package es.indra.sicc.cmn.negocio.interfaces;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.cmn.negocio.interfaces.comun.DTOINTError;
import es.indra.sicc.cmn.negocio.interfaces.comun.IRegistroSicc;
import es.indra.sicc.cmn.negocio.interfaces.comun.InterfacesException;
import es.indra.sicc.cmn.negocio.interfaces.comun.InterfazInfo;
import es.indra.sicc.cmn.negocio.interfaces.comun.RegistroSicc;
import es.indra.sicc.cmn.negocio.interfaces.util.Util;

import java.io.FileNotFoundException;
import java.io.IOException;
import es.indra.sicc.util.UtilidadesLog;

/*
 * 16-05-2005 - rgiorgi: cambio por inc. 18257
 * */
public class GestorInterfaces 
{
  private static RegistroDefs registroDefs;
  private static RegistroInterfaces registroInterfaces;
  private static UtilidadesLog logAux = new UtilidadesLog();

  public GestorInterfaces() throws InterfacesException, MareException
  {
    UtilidadesLog.debug("ENTRA AL CONSTRUCTOR GestorInterfaces()");
    registroDefs = RegistroDefs.obtenerRegistro();
     UtilidadesLog.debug("DESPUES DE RegistroDefs.obtenerRegistro()");
    registroInterfaces = RegistroInterfaces.obtenerRegistroInterfaces();
  }

  public InterfazInfo crearInterfaz(String codigoInterfaz, String numeroLote, Long pais) 
    throws InterfacesException, MareException
  {
    InterfazDef def = RegistroDefs.obtenerInterfaz( codigoInterfaz );
    if( def == null ) 
    {
      UtilidadesLog.error( "Interfaz no definida: " + codigoInterfaz );
      throw new InterfacesException( "Interfaz no definida: " + codigoInterfaz );
    }
    
    registroInterfaces.registrarInterfaz( codigoInterfaz + numeroLote, Interfaz.obtenerInterfaz(def, numeroLote) );

    return new InterfazInfo( codigoInterfaz, numeroLote, pais );
  }

  public void anyadirRegistro(InterfazInfo interfazInfo, IRegistroSicc registro)
    throws InterfacesException, MareException
  {
    if( interfazInfo == null || registro == null )
      throw new InterfacesException( "Parámetros erróneos: \n  interfazInfo: " + 
        interfazInfo + "\n  registro: " + registro );

    Interfaz interfaz = registroInterfaces.obtenerInterfaz( interfazInfo );
    
    try
    {
      interfaz.anyadirRegistro( registro );
    } catch( IOException ioex )
    {
      UtilidadesLog.error( "Error E/S", ioex );
    }
  }

  public void enviarInterfaz( InterfazInfo interfazInfo ) throws InterfacesException
  {
    Interfaz interfaz = registroInterfaces.obtenerInterfaz( interfazInfo );
    interfaz.enviar();
    interfaz.notificar();
  }

  public void recargarInterfaces() throws InterfacesException, MareException
  {
    RegistroDefs.recargarInterfaces();
  }

  public void registrarError(DTOINTError dtoError) throws InterfacesException
  {
    Interfaz interfaz = registroInterfaces.obtenerInterfaz( dtoError.getInterfazInfo() );
    interfaz.registrarError( dtoError.getDescripcion(), dtoError.getRegistro() );
  }

  /*
   * 12-05-2005 - rgiorgi: inc.18111
   * 16-05-2005 - rgiorgi: cambio por inc. 18257
   * */
  public InterfazInfo importarInterfaz(InterfazInfo info) 
    throws InterfacesException, MareException
  {
    String codigoInterfaz = info.getCodigoInterfaz();
    String numeroLote = info.getNumeroLote();
    Long pais = info.getPais();

    InterfazDef def = importarInterfazP1(codigoInterfaz, numeroLote, pais, info);     
    
    return importarInterfazP2(codigoInterfaz, numeroLote, pais, def, info);
  }

  public InterfazInfo importarInterfaz(InterfazInfo info, String nombreArchivo) 
    throws InterfacesException, MareException
  {
    String codigoInterfaz = info.getCodigoInterfaz();
    String numeroLote = info.getNumeroLote();
    Long pais = info.getPais();

    InterfazDef def = importarInterfazP1(codigoInterfaz, numeroLote, pais, info);     
    def.setPatronNombreFicheros(nombreArchivo);
    
    return importarInterfazP2(codigoInterfaz, numeroLote, pais, def, info);
  }

  private InterfazDef importarInterfazP1(String codigoInterfaz, String numeroLote, Long pais, InterfazInfo info) 
      throws InterfacesException, MareException {

    if( codigoInterfaz == null ||
        numeroLote == null ||
        pais == null )
    {
      String mensaje = "Parámetros erróneos\n" + "  codigoInterfaz: " + codigoInterfaz +
                        "\n  numeroLote: " + numeroLote + "\n  pais: " + pais;
      UtilidadesLog.error( mensaje );
      throw new InterfacesException( mensaje );
    }

    InterfazDef def = RegistroDefs.obtenerInterfaz( codigoInterfaz );
    if( def == null )
    {
      String mensaje = "Interfaz no definida: " + codigoInterfaz;
      UtilidadesLog.error( mensaje );
      throw new InterfacesException( mensaje );
    }
    
    return def;
  } 

  private InterfazInfo importarInterfazP2(String codigoInterfaz, String numeroLote, Long pais, InterfazDef def, InterfazInfo info) 
      throws InterfacesException, MareException {
    InterfazInfo infoSalida = null;      
    registroInterfaces.registrarInterfaz( codigoInterfaz + numeroLote, Interfaz.obtenerInterfaz(def, numeroLote) );

    infoSalida = new InterfazInfo( codigoInterfaz, numeroLote, pais );
    infoSalida.setDescripcionLote( info.getDescripcionLote() );
    infoSalida.setObservaciones( info.getObservaciones() );
    infoSalida.setNumeroLote( info.getNumeroLote() );
    infoSalida.setCriteriosConsulta( info.getCriteriosConsulta() );

    return infoSalida;
  }
  
  /*
   * 12-05-2005 - rgiorgi: inc.18111
   * */
  public InterfazInfo importarInterfaz(String codigoInterfaz, String numeroLote, Long pais) 
    throws InterfacesException, MareException
  {
    return importarInterfaz(new InterfazInfo( codigoInterfaz, numeroLote, pais ));
  }

  public IRegistroSicc cargarRegistro(InterfazInfo interfazInfo, boolean bCerrarInterfaz) 
    throws InterfacesException, MareException
  {
    if( interfazInfo == null )
    {
      String mensaje = "Parámetro erróneo:\n  interfazInfo: " + interfazInfo;
      UtilidadesLog.error( mensaje );
      throw new InterfacesException( mensaje );
    }

    Interfaz interfaz = registroInterfaces.obtenerInterfaz( interfazInfo );

    IRegistroSicc registroSicc = null;
    try
    {
        //doliva -- cambio Optimizacion Logs -- 24/03/2010
        if(logAux.isDebugEnabled()) { 	  
          UtilidadesLog.debug("cargar con parametro:" + bCerrarInterfaz );
        }  
      registroSicc = interfaz.cargarRegistro(bCerrarInterfaz);
    } catch( FileNotFoundException fex )
    {
      UtilidadesLog.error( "Error E/S", fex );
      throw new InterfacesException( "Error E/S", fex );
    } catch( IOException ioex )
    {
      UtilidadesLog.error( "Error E/S", ioex );
      throw new InterfacesException( "Error E/S", ioex );
    }

    return registroSicc;
  }
  
  public IRegistroSicc cargarRegistro(InterfazInfo interfazInfo) 
    throws InterfacesException, MareException
  {
	UtilidadesLog.debug("cargar simple");
	return cargarRegistro(interfazInfo, true);
  }

  public InfoRegistroLote obtenerInfoRegistroLote(InterfazInfo interfazInfo)
    throws InterfacesException, MareException
  {
    if( interfazInfo == null )
    {
      String mensaje = "Parámetro erróneo:\n  interfazInfo: " + interfazInfo;
      UtilidadesLog.error( mensaje );
      throw new InterfacesException( mensaje );
    }
	
	Interfaz interfaz = registroInterfaces.obtenerInterfaz( interfazInfo );
    
    int procesados = interfaz.getRegistrosProcesados();
    int erroneos = interfaz.getRegistrosErroneos();
    if(procesados<erroneos){
        procesados = 0;
        interfaz.setRegistrosProcesados(procesados);
    }else{
        interfaz.setRegistrosProcesados(procesados-erroneos);
    }
    String observaciones = null;
    if (interfaz.getEstadoNotificacion()!=null){
        observaciones = interfaz.getEstadoNotificacion();
    }else{
        observaciones = interfazInfo.getObservaciones();
    }
    
	InfoRegistroLote infoLote = new InfoRegistroLote(  interfazInfo.getPais(),
                                  interfazInfo.getCodigoInterfaz(),
                                  interfazInfo.getNumeroLote(),
                                  interfazInfo.getDescripcionLote(),
                                  interfaz.getFechaInicioProceso(),
                                  interfaz.getFechaFinProceso(),
                                  interfaz.getRegistrosProcesados(),
                                  interfaz.getRegistrosErroneos(),
                                  observaciones,
                                  interfazInfo.getCriteriosConsulta());
          // Agregado por cambio 20080664
          if(interfazInfo.getPeriodo()!=null){
            infoLote.setPeriodo(interfazInfo.getPeriodo());
          }
          //								  
	registroInterfaces.eliminarInterfaz( interfazInfo.getCodigoInterfaz() + interfazInfo.getNumeroLote() );
    
    return infoLote;
  }

	public InterfazInfo obtenerInterfazInfo(String codigoInterfaz) 
		throws InterfacesException, MareException {
            
        UtilidadesLog.debug("antes de GestorInterfaces.obtenerInterfazInfo");
        
        UtilidadesLog.debug("La información de las interfaces se carga del archivo cuya ruta es:");
        UtilidadesLog.debug((String)Util.getMGC().getProperty("interfaces.conf"));
        
		if( codigoInterfaz == null )
		{
			String mensaje = "Parámetros erróneos\n" + "  codigoInterfaz: " + codigoInterfaz;
			UtilidadesLog.error( mensaje );
			throw new InterfacesException( mensaje );
		}

		InterfazDef def = RegistroDefs.obtenerInterfaz( codigoInterfaz );
		if( def == null )
		{
			String mensaje = "Interfaz no definida: " + codigoInterfaz;
			UtilidadesLog.error( mensaje );
			throw new InterfacesException( mensaje );
		}
    
		InterfazInfo info = new InterfazInfo( codigoInterfaz, null, null );
		info.setDescripcionLote( def.getDescripcion() );
		
		return info;
	}
	
	
	public static void main( String[] args ) {
		try
		{
			GestorInterfaces gestor = new GestorInterfaces();
			InterfazInfo info = gestor.obtenerInterfazInfo("TEST");
			String numeroLote = new Long(System.currentTimeMillis()).toString().substring(0,12);
			info.setNumeroLote( numeroLote );
			InterfazInfo interfaz = 
				gestor.crearInterfaz( info.getCodigoInterfaz(), info.getNumeroLote(), new Long(1L) );

			IRegistroSicc reg = new RegistroSicc();
			reg.anyadirCampo( "numeroLote", "123456789012" );
			reg.anyadirCampo( "codigo", new Integer(13) );
			gestor.anyadirRegistro( interfaz, reg );
			gestor.enviarInterfaz( interfaz );

		} catch( InterfacesException iex ) {
			UtilidadesLog.debug( iex.getMotivo() );
		} catch( Exception ex ) {
			ex.printStackTrace();
		}
	}

  public void cerrarInterfaz(InterfazInfo interfazInfo) 
    throws InterfacesException, MareException
  {
        if( interfazInfo == null )
        {
          String mensaje = "Parámetro erróneo:\n  interfazInfo: " + interfazInfo;
          UtilidadesLog.error( mensaje );
          throw new InterfacesException( mensaje );
        }
    
        Interfaz interfaz = registroInterfaces.obtenerInterfaz( interfazInfo );
    
        IRegistroSicc registroSicc = null;
        try
        {
          interfaz.cerrarInterfaz();
        } catch( FileNotFoundException fex )
        {
          UtilidadesLog.error( "Error E/S", fex );
          throw new InterfacesException( "Error E/S", fex );
        } catch( IOException ioex )
        {
          UtilidadesLog.error( "Error E/S", ioex );
          throw new InterfacesException( "Error E/S", ioex );
        }
  }
  
  //Agregado por Cristian Valenzuela - 17/10/2005
  public void reset(InterfazInfo interfazInfo) throws InterfacesException, MareException {
    if( interfazInfo == null )  {
      String mensaje = "Parámetro erróneo:\n  interfazInfo: " + interfazInfo;
      UtilidadesLog.error( mensaje );
      throw new InterfacesException( mensaje );
    }

    Interfaz interfaz = registroInterfaces.obtenerInterfaz( interfazInfo );

    try {
	  interfaz.reset();
    }
    catch( FileNotFoundException fex ) {
      UtilidadesLog.error( "Error E/S", fex );
      throw new InterfacesException( "Error E/S", fex );
    }
    catch( IOException ioex ) {
      UtilidadesLog.error( "Error E/S", ioex );
      throw new InterfacesException( "Error E/S", ioex );
    } 
  }  
  //FIN - Agregado por Cristian Valenzuela - 17/10/2005
}