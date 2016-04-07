package es.indra.sicc.cmn.negocio.auditoria;

import es.indra.mare.common.exception.MareException;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import es.indra.sicc.cmn.negocio.auditoria.MONAuditoria;
import es.indra.sicc.cmn.negocio.auditoria.MONAuditoriaBean;
import es.indra.sicc.cmn.negocio.auditoria.MONAuditoriaHome;
import es.indra.sicc.cmn.negocio.i18n.MONI18nHome;
import es.indra.sicc.cmn.negocio.i18n.MONI18n;


import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.lang.reflect.Method;

import java.util.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.CreateException;
import javax.ejb.EntityBean;
import javax.ejb.EntityContext;
import java.rmi.RemoteException;
import javax.naming.NamingException;

import javax.naming.InitialContext;

import javax.rmi.PortableRemoteObject;


public abstract class EntidadSICCAuditableBean implements EntityBean {
  private static final int CREAR = 1;
  private static final int MODIFICAR = 2;
  private static final int ELIMINAR = 3;
  private static HashMap configuracion;
  private final static String CONF_SI = "si";
  private final static String CONF_NO = "no";
  private boolean auditar;
  private String ipCliente;
  private String programa;
  private EntityContext ctx;
  private Long pkEntidad = null;
  protected String nombreTabla;

  private void auditar( int op ) {
    /*String Entidad = this.getClass(  ).getName(  );
    Entidad = Entidad.substring( 0, Entidad.indexOf( "Bean" ) );
    Entidad = Entidad.substring( Entidad.lastIndexOf(".")+1 );

    UtilidadesLog.debug( "auditando entidad " + Entidad + " (op:" + op + ")" );
    try {
      InitialContext ic = new InitialContext(  );
      MONAuditoriaHome maHome = (MONAuditoriaHome) PortableRemoteObject.narrow( 
          ic.lookup( "MONAuditoria" ), MONAuditoriaHome.class );
      MONAuditoria maLocal = maHome.create(  );

      if ( configuracion == null )
        configuracion = maLocal.obtenerConfiguracionAuditoria(  );

      String resAud = (String) configuracion.get( Entidad );

      if ( ( resAud != null ) && resAud.startsWith( CONF_SI ) ) {
        String dump = dumpToString( resAud ); //este metodo tambien obtiene la pk (ojo el orden)
        maLocal.auditar( 
          programa, ipCliente, Entidad, pkEntidad, new Integer( op ), dump );
      } else if ( resAud == null ) {
        UtilidadesLog.debug( 
          "La Entidad " + Entidad
          + " no existe en el archivo de configuración de Auditoria." );

        //No se deberia cachear una MareException abajo
        throw new MareException( 
          "La Entidad no existe en el archivo de configuración de Auditoria." );
      }
    } catch ( Exception e ) {
      UtilidadesLog.debug("Exception :" + e.getMessage());
    }*/
  }

  public void ejbCreate(  ) {
    UtilidadesLog.debug( "auditoria - create" );
    auditar( CREAR );
  }

  public void ejbStore(  ) {
    UtilidadesLog.debug( "auditoria - store" );
    auditar( MODIFICAR );
  }

  public void ejbRemove(  ) {
    UtilidadesLog.debug( "auditoria - remove" );
    auditar( ELIMINAR );
    eliminarTraducciones();
  }

  public void setEntityContext( EntityContext ctx ) {
    this.ctx = ctx;
  }

  public void unsetEntityContext(  ) {
    this.ctx = null;
  }

  /** Este metodo Realiza un volcado de los atributos modificables del entity bean
    * por reflection. El formato sería: atributo1=valor; atributo2=valor...
    * solo de los atributos especificados por el parametro opciones.
    * Si el parametro es * se hace dump de todos los atributos del entity.
    */
  private String dumpToString( String opciones ) {
    try {
      Vector atributos = getAtributosDump( opciones );

      // Metodos del bean:
      Class clsBean = this.getClass(  );
      Method[] method = clsBean.getMethods(  );
      Vector noIncluir = new Vector(  );
      noIncluir.add( "getClass" );
      noIncluir.add( "getConfiguracion" );
      noIncluir.add( "getObject" );

      HashMap dump = new HashMap( 20 );
      Object resMethod;
      String atrib;
      String dumpResult;
      for ( int i = 0; i < method.length; i++ ) {
        String methodName = method [i].getName(  );

        if ( methodName.startsWith( "get" ) && ( !noIncluir.contains( methodName ) ) ) {
          
          atrib = methodName.substring( 3, 4 ).toLowerCase(  )
            + methodName.substring( 4 );
          resMethod = method [i].invoke( this, null );
          dumpResult = atrib + "=" + resMethod + "; ";
          dump.put( atrib, dumpResult );
          if ( methodName.equals( "getOid" ) )
            this.pkEntidad = (Long) resMethod;
        }
      }

      StringBuffer result = new StringBuffer(  );
      if ( atributos == null ) { // dump de todos los atributos

        Iterator it = dump.values(  ).iterator(  );
        while ( it.hasNext(  ) )
          result.append( (String) it.next(  ) );
      } else { // dump de los atributos en el orden especificado
        if ( atributos.size(  ) == 0 )
          return "no dump"; // sin dump

        String resDump;
        String atr;
        for ( int i = 0; i < atributos.size(  ); i++ ) {
          atr = (String) atributos.get( i );
          resDump = (String) dump.get( atr );
          if ( resDump != null )
            result.append( resDump );
        }
      }

      if ( pkEntidad == null )
        UtilidadesLog.debug( "No se encontro PK en el entity: Se llamará oid?" );

      return result.toString(  );
    } catch ( Throwable e ) {
      System.err.println( e );

      return null;
    }
  }

  /** Debuelve un vector con los atrinbutos a Dumpear
   *  Formato: <NombreEntity> = si; [ Atrib1, ..., AtrinbN | * ]
   *  @return vector vacio si no hay atributos a dumpear,
   *          vector con los atributos a dumpear en el orden especificado o
   *          null si hay que dumpear todo.   */
  private Vector getAtributosDump( String opciones ) {
    Vector res = new Vector(  );

    if ( opciones.startsWith( CONF_NO ) )
      return res;

    if ( opciones.indexOf( ";" ) == -1 )
      return res;

    if ( opciones.indexOf( "*" ) != -1 )
      return null;

    String cola = opciones.substring( opciones.indexOf( ";" )+1 );
    String atrib;
    StringTokenizer st = new StringTokenizer( cola, "," );

    while ( st.hasMoreElements(  ) ) {
      atrib = ( (String) st.nextElement(  ) ).trim(  );

      if ( atrib.length(  ) > 0 )
        res.add( atrib );
    }

    return res;
  }

  public void ejbHomeParametrosAuditoria( DTOAuditableSICC dtoEntrada ) {
    /*this.ipCliente = dtoEntrada.getIpCliente(  );
    this.programa = dtoEntrada.getPrograma(  );*/
  }

  private void eliminarTraducciones() {
//      UtilidadesLog.info("Ingresando a eliminarTraducciones()");
      /*String codigoError;
      if (nombreTabla!=null) {
        try {
            getMONI18n().eliminarTraducciones(nombreTabla,
                                                   getPK());
        } catch (Exception re) {
//            UtilidadesLog.info("No se Pudo Eliminar las traducciones: "+re.getMessage());
        }
      }*/
//      UtilidadesLog.info("Saliendo de eliminarTraducciones()");
  }

  private MONI18n getMONI18n() throws MareException {
    String codigoError;
    try {
      InitialContext ic = new InitialContext(  );
      MONI18nHome maHome = (MONI18nHome) PortableRemoteObject.narrow( 
          ic.lookup( "MONI18n" ), MONI18nHome.class );
      return maHome.create();    
    } catch(NamingException ne) {
        codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
        throw new MareException(ne,UtilidadesError.armarCodigoError(codigoError));
    } catch(RemoteException re) {
        codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
        throw new MareException(re,UtilidadesError.armarCodigoError(codigoError));
    } catch(CreateException ce) {
        codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
        throw new MareException(ce,UtilidadesError.armarCodigoError(codigoError));
    }
  }

  private Long getPK() {
     Long pk = null;
     try {
      // Metodos del bean:
      Class clsBean = this.getClass(  );
      Method[] method = clsBean.getMethods();

      for ( int i = 0; i < method.length; i++ ) {
          if ( method[i].getName().equals( "getOid" ) )
            pk = (Long)  method [i].invoke( this, null );
      }
     } catch (Throwable e) {
//        UtilidadesLog.info("Problemas al obtener la pk de la entidad : "+e.getMessage());  
     }
     return pk;
   } 

    public Object getObject(String atributo) {
        // arma el nombre del método get...() que se debe invocar
        String beginChar = atributo.substring(0, 1).toUpperCase();
        String restString = atributo.substring(1);
        String methodName = "get" + beginChar + restString;
        Method method = null;
        Class[] params = {  };

        try {
            method = this.getClass().getDeclaredMethod(methodName, params);
        } catch (Exception e) {
			return null;
		}

        Object[] args = {  };
        Object objectResult = null;

        try {
            objectResult = method.invoke(this, args);
        } catch (Exception ie) {
			return null;
		}

        return objectResult;
    }

    public void setObject(String atributo, Object valor) {
        // arma el nombre del método set...() que se debe invocar
        String beginChar = atributo.substring(0, 1).toUpperCase();
        String restString = atributo.substring(1);
        String methodName = "set" + beginChar + restString;
        Method method = null;
        Class[] params = { valor.getClass() };

        try {
            method = this.getClass().getDeclaredMethod(methodName, params);
        } catch (Exception e) {}

        Object[] args = { valor };

        try {
            method.invoke(this, args);
        } catch (Exception ie) {}
    }


    private String getStackTrace(Exception e) {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);

        e.printStackTrace(ps);

        return new String(os.toByteArray());
    }

}
