package es.indra.sicc.cmn.negocio.validacion;
import es.indra.mare.common.exception.MareException;
//import es.indra.mare.common.mgu.MGUMON;
import es.indra.mare.common.mgu.manager.Property;
import es.indra.mare.common.mgu.manager.UserIDImpl;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.logicanegocio.men.MONUsuarios;
import es.indra.sicc.logicanegocio.men.MONUsuariosHome;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;

import java.lang.Long;
import java.lang.StringBuffer;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.sicc.util.UtilidadesLog;

import javax.ejb.CreateException;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.rmi.PortableRemoteObject;


public class MONValidacionBean implements SessionBean 
{   

    //Variables que simbolizan el estado de cada propiedad.
    private final int TO_CHECK_NOT_VALID = -1;
    private final int TO_CHECK_VALID = 1;
    
    //Nombre de propiedades que se deben Validar el Acceso.
    private final static String N_ACCESO   = "Acceso";
    private final static String N_CANAL    = "Canal";
    private final static String N_MARCA    = "Marca";
    private final static String N_PAIS     = "Pais";
    private final static String N_REGION   = "Region";
    private final static String N_SECCION  = "Seccion";
    private final static String N_SOCIEDAD = "Sociedad";
    private final static String N_SUBNIVELACCESO  = "SubnivelAcceso";
    private final static String N_TERRITORIO= "Territorio";
    private final static String N_ZONA      = "Zona";
    private final static String N_SUBGERENCIA = "SubgerenciaVentas";

    private HashMap propertiesHash = null;
    //private MONUsuariosHo mguMon = null;  

    private SessionContext ctx;

  public void ejbCreate()
  {
  }

  public void ejbActivate()
  {
  }

  public void ejbPassivate()
  {
  }

  public void ejbRemove()
  {
  }

  public void setSessionContext(SessionContext ctx)
  {
    this.ctx = ctx;
  }

  public Boolean validarVinculos(Long Pais, Long Sociedad, Long Marca, Long Canal, Long Acceso, Long Subacceso)  throws MareException  {   
        UtilidadesLog.info("MONValidacionBean.validarVinculos(): Entrada");

     // Toma los parámetros de entrada, y cheque se existe una entrada con esos parámetros
    // en la tabla COM_VINCU. De ser así, devuelve TRUE. De otra forma devuelve FALSE.

    // *************************
    //   Forma la sentencia SQL
    // *************************
    String sNombreTabla = "SEG_VINCU_JERAR";
    StringBuffer SQL = new StringBuffer("SELECT * FROM ");
   
    SQL.append(sNombreTabla);
    SQL.append(" WHERE 1=1 ");
    int nLongitud = SQL.length();
    //UtilidadesLog.debug("Antes de chequeo Nulls");

    //SQL.append(" AND PAIS_OID_PAIS");
    if (Pais != null)
    {
      if (!Pais.equals(""))
         SQL.append(" AND PAIS_OID_PAIS=" + Pais.toString() );      
      //UtilidadesLog.debug("Pais - DONE");
    } else
    {
      SQL.append(" AND PAIS_OID_PAIS IS NULL");
    }
    
    //SQL.append(" AND SOCI_OID_SOCI");
    if (Sociedad != null  ) 
    {
      if ( !Sociedad.equals("") )
          SQL.append(" AND SOCI_OID_SOCI=" + Sociedad.toString() );
      //UtilidadesLog.debug("Sociedad - DONE" );
    } else
    {
      SQL.append(" AND SOCI_OID_SOCI IS NULL");
    }

    //SQL.append(" AND MARC_OID_MARC");
    if (Marca != null)
    {
        if (!Marca.equals(""))
          SQL.append(" AND MARC_OID_MARC=" + Marca.toString() );    
        //UtilidadesLog.debug("Marca - DONE");
    } else
    {
      SQL.append(" AND MARC_OID_MARC IS NULL");
    }

    //SQL.append(" AND CANA_OID_CANA");
    if (Canal != null )
    {
        if (!Canal.equals(""))
          SQL.append(" AND CANA_OID_CANA=" + Canal.toString() );
        //UtilidadesLog.debug("Canal - DONE");
    } else
    {
      SQL.append(" AND CANA_OID_CANA IS NULL");
    }

    //SQL.append(" AND ACCE_OID_ACCE");
    if (Acceso != null)
    {
        if (!Acceso.equals(""))
          SQL.append(" AND ACCE_OID_ACCE=" + Acceso.toString() );
        //UtilidadesLog.debug("Acceso - DONE");
    } else
    {
      SQL.append(" AND ACCE_OID_ACCE IS NULL");
    }

    //SQL.append(" AND SBAC_OID_SBAC");
    if (Subacceso != null)
    {
        if ( !Subacceso.equals("") )
         SQL.append(" AND SBAC_OID_SBAC=" + Subacceso.toString() );
        //UtilidadesLog.debug("Subacceso - DONE");
    } else
    {
      SQL.append(" AND SBAC_OID_SBAC IS NULL");
    }

    // ********************************************************
    // Fin de creación de sentencia SQL
    // ********************************************************

    // Chequea si todos los parámetros eran NULL o ""
    //if ( nLongitud == SQL.length() )
    //{
    // Si es asi, devuelve FALSE.
    //  return Boolean.FALSE;
    //}

    BelcorpService service = getService();
    RecordSet r = null;
    String codigoError;
    
            try 
            {
                r = service.dbService.executeStaticQuery( SQL.toString() );      
            } catch (Exception e)
            { 
              // Si se produce un error, tira una MareException.
              //throw new MareException(e.getMessage());      
              codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
              throw new MareException(e,UtilidadesError.armarCodigoError(codigoError));
            }        

        UtilidadesLog.info("MONValidacionBean.validarVinculos(): Salida");
    
    if ( r.getRowCount() == 0 )
    {
      // Devolvió vacío, por lo que no hay un vínculo en la tabla con ese juego
      // de datos. Devuelve FALSE.
      return Boolean.FALSE;
    } else
      return Boolean.TRUE;
  }

  private BelcorpService getService() throws EJBException
  {
     try
     {
        BelcorpService belcorpService = BelcorpService.getInstance();
        return belcorpService;        
        
     } catch (MareMiiServiceNotFoundException mmsnfe)
     {
              throw new EJBException(mmsnfe);
     }     
  }        

    /*
     * Este método valida si el usuario corritente (Proviene del Contexto) 
     * tiene permiso de acceder a las propiedades, que se pasan por parametros,
     * mediante el chequeos de los valores pasados como argumento.
     * **/
    public Boolean validarAccesos(Long pais, Long sociedad, Long marca, Long canal, Long acceso, Long subAcceso, Long subgerencia, Long region, Long zona, Long seccion, Long territorio) throws MareException {
        UtilidadesLog.info("MONValidacionBean.validarAccesos(): Entrada");

        /*if ( pais == null || sociedad == null || marca == null || canal == null ||
            acceso == null|| subAcceso == null || subgerencia == null || region == null ||
            zona == null || seccion == null || territorio == null ){
                return new Boolean(false);
        }*/
         String codigoError;
         boolean result = true;
            try{
                int []arrayToCheck = new int[11];
            
                arrayToCheck[0] = checkCampo(N_PAIS,pais);//.toString());                
                arrayToCheck[1] = checkCampo(N_SOCIEDAD,sociedad);//.toString());                
                arrayToCheck[2] = checkCampo(N_MARCA,marca);//.toString());
                arrayToCheck[3] = checkCampo(N_CANAL,canal);//.toString());
                arrayToCheck[4] = checkCampo(N_ACCESO,acceso);//.toString());
                arrayToCheck[5] = checkCampo(N_SUBNIVELACCESO,subAcceso);//.toString());
                arrayToCheck[6] = checkCampo(N_SUBGERENCIA,subgerencia);//.toString());
                arrayToCheck[7] = checkCampo(N_REGION,region);//.toString());
                arrayToCheck[8] = checkCampo(N_ZONA,zona);//.toString());
                arrayToCheck[9] = checkCampo(N_SECCION,seccion);//.toString());
                arrayToCheck[10]= checkCampo(N_TERRITORIO,territorio);//.toString());
                
                for(int j=0;j<arrayToCheck.length; j++){
                    if ( arrayToCheck[j] == TO_CHECK_NOT_VALID ){
                        result = false;
                    }
                }

            }catch(RemoteException e){
                codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                throw new MareException(e.getMessage());
            }catch(NamingException me){                
                codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                throw new MareException(me,UtilidadesError.armarCodigoError(codigoError));                
            }
            UtilidadesLog.info("MONValidacionBean.validarAccesos(): Salida");
            return new Boolean(result);
    }


    public HashMap getUserProperties() throws  NamingException,  RemoteException, MareException 
    {
        if ( propertiesHash == null ){
            try {
                MONUsuarios mguMon = this.getMONUsuariosHome().create();
                String uName = this.ctx.getCallerPrincipal().getName();
                this.propertiesHash = mguMon.getProperties(new UserIDImpl(uName));                    
            } catch (CreateException e) {
                UtilidadesLog.error("ERROR",e);
                ctx.setRollbackOnly();
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));            
            }
        }

        return this.propertiesHash;
    }

    public HashMap getUserPropertiesUserApp(String userApp) throws  NamingException,  RemoteException, MareException 
    {
        if ( propertiesHash == null ){
            try {
                MONUsuarios mguMon = this.getMONUsuariosHome().create();
                String uName = userApp;
                this.propertiesHash = mguMon.getProperties(new UserIDImpl(uName));                    
            } catch (CreateException e) {
                UtilidadesLog.error("ERROR",e);
                ctx.setRollbackOnly();
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));            
            }                
        }

        return this.propertiesHash;
    }
    
    private int checkCampo(String campo, Long valorCampo) 
        throws MareException, NamingException, RemoteException
    {
         if (valorCampo==null)
            return TO_CHECK_VALID;
         int result = TO_CHECK_NOT_VALID;
         getUserProperties();
         if( propertiesHash.containsKey(campo))
         {
            Property pProperty = (Property)propertiesHash.get(campo);
            
            if ( pProperty.isMultivalued())
            {                    
                Iterator valuesIt = ((HashSet)pProperty.getValue()).iterator();
                while(valuesIt.hasNext())
                {
                    if ( valuesIt.next().equals(valorCampo.toString())){
                        result = TO_CHECK_VALID;
                        break;
                    }
                }                        
            }
            else{
                //No es multiValuado.
                if ( pProperty.getValue().toString().equals(valorCampo.toString()) ){
                    result = TO_CHECK_VALID;                                    
                }
            }
        }
        return result;
    }

    private int checkCampoUser(String campo, Long valorCampo, String usuario) 
        throws MareException, NamingException, RemoteException
    {
         if (valorCampo==null)
            return TO_CHECK_VALID;
         int result = TO_CHECK_NOT_VALID;
         getUserPropertiesUserApp(usuario);
         if( propertiesHash.containsKey(campo))
         {
            Property pProperty = (Property)propertiesHash.get(campo);
            
            if ( pProperty.isMultivalued())
            {                    
                Iterator valuesIt = ((HashSet)pProperty.getValue()).iterator();
                while(valuesIt.hasNext())
                {
                    if ( valuesIt.next().equals(valorCampo.toString())){
                        result = TO_CHECK_VALID;
                        break;
                    }
                }                        
            }
            else{
                //No es multiValuado.
                if ( pProperty.getValue().toString().equals(valorCampo.toString()) ){
                    result = TO_CHECK_VALID;                                    
                }
            }
        }
        return result;
    }

    public Boolean validarAccesos(Long pais, Long sociedad, Long marca, Long canal, Long acceso, Long subAcceso, Long subgerencia, Long region, Long zona, Long seccion, Long territorio, String user) throws MareException
    {
        UtilidadesLog.info("MONValidacionBean.validarAccesos(con usuario!): Entrada");
        UtilidadesLog.debug("el usuario que recibo es: " + user);

        /*if ( pais == null || sociedad == null || marca == null || canal == null ||
            acceso == null|| subAcceso == null || subgerencia == null || region == null ||
            zona == null || seccion == null || territorio == null ){
                return new Boolean(false);
        }*/
         String codigoError;
         boolean result = true;
            try{
                int []arrayToCheck = new int[11];
            
                arrayToCheck[0] = checkCampoUser(N_PAIS,pais,user);//.toString());                
                arrayToCheck[1] = checkCampoUser(N_SOCIEDAD,sociedad,user);//.toString());                
                arrayToCheck[2] = checkCampoUser(N_MARCA,marca,user);//.toString());
                arrayToCheck[3] = checkCampoUser(N_CANAL,canal,user);//.toString());
                arrayToCheck[4] = checkCampoUser(N_ACCESO,acceso,user);//.toString());
                arrayToCheck[5] = checkCampoUser(N_SUBNIVELACCESO,subAcceso,user);//.toString());
                arrayToCheck[6] = checkCampoUser(N_SUBGERENCIA,subgerencia,user);//.toString());
                arrayToCheck[7] = checkCampoUser(N_REGION,region,user);//.toString());
                arrayToCheck[8] = checkCampoUser(N_ZONA,zona,user);//.toString());
                arrayToCheck[9] = checkCampoUser(N_SECCION,seccion,user);//.toString());
                arrayToCheck[10]= checkCampoUser(N_TERRITORIO,territorio,user);//.toString());
                
                for(int j=0;j<arrayToCheck.length; j++){
                    if ( arrayToCheck[j] == TO_CHECK_NOT_VALID ){
                        result = false;
                    }
                }

            }catch(RemoteException e){
                codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                throw new MareException(e.getMessage());
            }catch(NamingException me){                
                codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                throw new MareException(me,UtilidadesError.armarCodigoError(codigoError));                
            }
            UtilidadesLog.info("MONValidacionBean.validarAccesos( con usuario!): Salida");
            return new Boolean(result);
    }

    private MONUsuariosHome getMONUsuariosHome() throws NamingException {
        final InitialContext context = new InitialContext();
        return (MONUsuariosHome) PortableRemoteObject.narrow( context.lookup( "java:comp/env/MONUsuarios" ), MONUsuariosHome.class );
    }
}
