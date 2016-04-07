package es.indra.sicc.cmn.negocio.interfaces;

import es.indra.sicc.cmn.negocio.interfaces.buzones.Buzon;
import es.indra.sicc.cmn.negocio.interfaces.buzones.IBuzon;
import es.indra.sicc.cmn.negocio.interfaces.comun.IRegistroSicc;
import es.indra.sicc.cmn.negocio.interfaces.comun.InterfacesException;
import es.indra.sicc.cmn.negocio.interfaces.notificacion.NotificacionDTO;
import es.indra.sicc.cmn.negocio.interfaces.notificacion.Notificador;
import es.indra.sicc.cmn.negocio.interfaces.notificacion.NotificadorSAPJCO;
import es.indra.sicc.cmn.negocio.interfaces.util.Util;

import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

public abstract class Interfaz 
{
  public static final String INTERFAZ_ENTRADA = "ENTRADA";
  public static final String INTERFAZ_SALIDA = "SALIDA";

  protected String codigo;
  protected String descripcion;
  protected String extension;
  protected String formatoCompresion;
  protected String nivelLog;
  protected boolean logErrores;
  protected boolean logTransferencia;
  protected String tipoProcesamiento;
  protected String tipoEjecucion;
  protected String procesosRequisito;
  protected String procesoPosterior;

  protected Buzon buzonES;
  protected Buzon buzonTemporal;
  protected Buzon buzonHistorico;

  protected Registro registro;

  protected int registrosProcesados;
  protected int registrosErroneos;
  protected Date fechaInicioProceso;
  protected Date fechaFinProceso;
  protected String numeroLote;
  protected String nombreFichero;

  protected Logger logger;
  private String pathBuzonLog;
  protected String patronNombre;
  
  protected List notificadores;
  

  private FileAppender fileApp;
  private String patronLog;
  private String estadoNotificacion;

  protected Interfaz( InterfazDef def, String numeroLote ) throws InterfacesException
  {
    codigo = def.getCodigo();
    this.numeroLote = numeroLote;
    descripcion = def.getDescripcion();
    extension = def.getExtension();
    nombreFichero = codigo + "_" + this.numeroLote + "." + extension;
    formatoCompresion = def.getFormatoCompresion();
    patronNombre = def.getPatronNombreFicheros();
    patronLog = def.getPatronLog();
    logErrores = def.isLogErrores();
    pathBuzonLog = def.getPathLog();
    
    if( logErrores )
    {
      logger = Util.getLogger( this.getClass(), def.getNivelLog() );
      
    }
    logTransferencia = def.isLogTransferencia();
    tipoProcesamiento = def.getTipoProcesamiento();
    tipoEjecucion = def.getTipoProcesamiento();
    procesosRequisito = def.getProcesosRequisito();
    procesoPosterior = def.getProcesoPosterior();
    //buzonTemporal.abrir( this );
    buzonHistorico = Buzon.obtenerBuzon( IBuzon.BUZON_SALIDA, def.getPathBuzonHistorico() );

    registro = def.getRegistro();
    
    notificadores = def.getNotificadores();
    
    registrosProcesados = 0;
    registrosErroneos = 0;
    fechaInicioProceso = new Date();
  }

  public static Interfaz obtenerInterfaz( InterfazDef def, String numeroLote )
    throws InterfacesException
  {
    Interfaz interfaz = null;
    if( def.getTipo().toUpperCase().equals( Interfaz.INTERFAZ_ENTRADA ) )
      interfaz = new InterfazEntrada( def, numeroLote );
    else if( def.getTipo().toUpperCase().equals( Interfaz.INTERFAZ_SALIDA ) )
      interfaz = new InterfazSalida( def, numeroLote );
    else
      throw new InterfacesException( "Tipo de interfaz desconocido: " + def.getTipo() );

    return interfaz;
  }

  public abstract void cerrarInterfaz()
    throws InterfacesException, IOException;

  public abstract void anyadirRegistro( IRegistroSicc registroSicc )
    throws InterfacesException, IOException;

  public abstract IRegistroSicc cargarRegistro()
    throws InterfacesException, FileNotFoundException, IOException;

  public abstract IRegistroSicc cargarRegistro( boolean bCerrarInterfaz )
    throws InterfacesException, FileNotFoundException, IOException;
    
  //Agregado por Cristian Valenzuela - 17/10/2005
  public abstract void reset() throws InterfacesException, IOException;
  //FIN - Agregado por Cristian Valenzuela - 17/10/2005

  public abstract void enviar() throws InterfacesException;

  public String getCodigo()
  {
    return codigo;
  }

  public void setCodigo(String newCodigo)
  {
    codigo = newCodigo;
  }

  public String getDescripcion()
  {
    return descripcion;
  }

  public void setDescripcion(String newDescripcion)
  {
    descripcion = newDescripcion;
  }

  public String getExtension()
  {
    return extension;
  }

  public void setExtension(String newExtension)
  {
    extension = newExtension;
  }

  public String getFormatoCompresion()
  {
    return formatoCompresion;
  }

  public void setFormatoCompresion(String newFormatoCompresion)
  {
    formatoCompresion = newFormatoCompresion;
  }

  public String getNivelLog()
  {
    return nivelLog;
  }

  public void setNivelLog(String newNivelLog)
  {
    nivelLog = newNivelLog;
  }

  public boolean isLogErrores()
  {
    return logErrores;
  }

  public void setLogErrores(boolean newLogErrores)
  {
    logErrores = newLogErrores;
  }

  public boolean isLogTransferencia()
  {
    return logTransferencia;
  }

  public void setLogTransferencia(boolean newLogTransferencia)
  {
    logTransferencia = newLogTransferencia;
  }

  public String getTipoProcesamiento()
  {
    return tipoProcesamiento;
  }

  public void setTipoProcesamiento(String newTipoProcesamiento)
  {
    tipoProcesamiento = newTipoProcesamiento;
  }

  public String getTipoEjecucion()
  {
    return tipoEjecucion;
  }

  public void setTipoEjecucion(String newTipoEjecucion)
  {
    tipoEjecucion = newTipoEjecucion;
  }

  public String getProcesosRequisito()
  {
    return procesosRequisito;
  }

  public void setProcesosRequisito(String newProcesosRequisito)
  {
    procesosRequisito = newProcesosRequisito;
  }

  public String getProcesoPosterior()
  {
    return procesoPosterior;
  }

  public void setProcesoPosterior(String newProcesoPosterior)
  {
    procesoPosterior = newProcesoPosterior;
  }

  public String getNumeroLote()
  {
    return numeroLote;
  }

  public void setNumeroLote(String newNumeroLote)
  {
    numeroLote = newNumeroLote;
  }

  public String toString()
  {
    return getCodigo() + "(" + getNumeroLote() + ")";
  }

  public Buzon getBuzonES()
  {
    return buzonES;
  }

  public void setBuzonES(Buzon newBuzonES)
  {
    buzonES = newBuzonES;
  }

  public Buzon getBuzonHistorico()
  {
    return buzonHistorico;
  }

  public void setBuzonHistorico(Buzon newBuzonHistorico)
  {
    buzonHistorico = newBuzonHistorico;
  }

  public Buzon getBuzonTemporal()
  {
    return buzonTemporal;
  }

  public void setBuzonTemporal(Buzon newBuzonTemporal)
  {
    buzonTemporal = newBuzonTemporal;
  }

  public Logger getLogger()
  {
    return logger;
  }
  
 
  public String getNombreFichero()
  {
    return nombreFichero;
  }

  public void setNombreFichero(String nombreFichero)
  {
    this.nombreFichero = nombreFichero;
  }
  
  protected String obtenerFicheroLog()
  {
    return  getPathBuzonLog() + System.getProperty("file.separator") + 
            getNombreFichero() + ".err";
  }

  public String getPathBuzonLog()
  {
    return pathBuzonLog;
  }

  public void setPathBuzonLog(String pathBuzonLog)
  {
    this.pathBuzonLog = pathBuzonLog;
  }

  public void registrarError(String descripcion, IRegistroSicc registroSicc )
    throws InterfacesException
  {
        incrementarRegistrosErroneos();
                                                                                            
    if( logErrores ) {
        StringBuffer mensaje = new StringBuffer( "Error de negocio: ").append(descripcion).append(" ");
        mensaje.append(getBuzonTemporal().getFichero().getName()).append(" ");
        if( registroSicc != null && registroSicc.numeroCampos() != 0 ){
            mensaje.append(getRegistrosProcesados());
            mensaje.append( "\nRegistro:\n" + registro.serializar(registroSicc) );
        }
        try {
            // DBLG400000829 - splatas
            fileApp = new FileAppender(new PatternLayout(patronLog), obtenerFicheroLog());
            fileApp.setImmediateFlush(true);
            logger.addAppender(fileApp);
            logger.error( mensaje.toString() );
            logger.removeAppender(fileApp);
            fileApp.close();
            fileApp = null;
        } catch (IOException ex) {
            System.err.println( "Error al crear fichero de log: " + obtenerFicheroLog() );
            //throw new InterfacesException("Error al crear fichero de log", ex);
        }
    }
  }
  
  /**
   * Metodo para registrar errores que No sean "de Negocio" en el archivo .err de 
   * cada Interfaz. Por ejemplo: "No se ha recibido el fichero de interfaz" (en BuzonEntrada).
   * @author eiraola
   * @date 29/Ago/2007
   */
  public void registrarErrorInterfaz(String descripcion) throws InterfacesException {
      if( logErrores ) {
          try {
            fileApp = new FileAppender(new PatternLayout(patronLog), obtenerFicheroLog());
            fileApp.setImmediateFlush(true);
            logger.addAppender(fileApp);
            logger.error( descripcion );
            logger.removeAppender(fileApp);
            fileApp.close();
            fileApp = null;
          } catch (Exception ex) {
              System.err.println( "Interfaz.registrarErrorInterfaz: Error al crear fichero de log: " 
                      + obtenerFicheroLog() );
          }
      }
  }
  
  protected void incrementarRegistrosProcesados()
  {
    registrosProcesados++;
  }
  
  protected void incrementarRegistrosErroneos()
  {
    //incrementarRegistrosProcesados();
    registrosErroneos++;
  }
  
  protected void notificar() {
    /*
	NotificacionDTO dto = new NotificacionDTO(  getCodigo(), 
                                                "Interfaz " + this + " enviada" );
    */
	Notificador notificador;
    for( Iterator it = getNotificadores().iterator(); it.hasNext(); ) {
        notificador = (Notificador)it.next();
        try {      
        notificador.notificar();
        } catch( InterfacesException iex ){
          getLogger().error("Error de notificación - notificador: " + notificador, iex.getEx() );
          if (notificador instanceof NotificadorSAPJCO){
              this.setEstadoNotificacion("Error en la función SAP - "+iex.getEx());
          }
        }
        if (this.getEstadoNotificacion()== null && (notificador instanceof NotificadorSAPJCO)){
            this.setEstadoNotificacion("La función en SAP terminó satisfactoriamente");
        }
    }    
  }

  public String getPatronNombre()
  {
    return patronNombre;
  }

  public void setPatronNombre(String patronNombre)
  {
    this.patronNombre = patronNombre;
  }

  public Date getFechaInicioProceso()
  {
    return fechaInicioProceso;
  }

  public void setFechaInicioProceso(Date fechaInicioProceso)
  {
    this.fechaInicioProceso = fechaInicioProceso;
  }

  public Date getFechaFinProceso()
  {
    return fechaFinProceso;
  }

  public void setFechaFinProceso(Date fechaFinProceso)
  {
    this.fechaFinProceso = fechaFinProceso;
  }

  public int getRegistrosProcesados()
  {
    return registrosProcesados;
  }

  public void setRegistrosProcesados(int registrosProcesados)
  {
    this.registrosProcesados = registrosProcesados;
  }

  public int getRegistrosErroneos()
  {
    return registrosErroneos;
  }

  public void setRegistrosErroneos(int registrosErroneos)
  {
    this.registrosErroneos = registrosErroneos;
  }

  public List getNotificadores()
  {
    return notificadores;
  }

  public void setNotificadores(List notificadores)
  {
    this.notificadores = notificadores;
  }

  public String getEstadoNotificacion(){
    return estadoNotificacion;
  }

  public void setEstadoNotificacion(String estadoNotificacion){
    this.estadoNotificacion = estadoNotificacion;
  }



}