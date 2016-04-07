package es.indra.sicc.logicanegocio.zon;

import es.indra.mare.common.exception.MareException;

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.negocio.batch.util.BatchUtil;
import es.indra.sicc.cmn.negocio.interfaces.IGestorInterfaces;
import es.indra.sicc.cmn.negocio.interfaces.comun.IRegistroSicc;
import es.indra.sicc.cmn.negocio.interfaces.comun.InterfacesException;
import es.indra.sicc.cmn.negocio.interfaces.comun.InterfazInfo;
import es.indra.sicc.cmn.negocio.interfaces.comun.RegistroSicc;
import es.indra.sicc.cmn.negocio.interfaces.fachada.MONGestorInterfaces;
import es.indra.sicc.cmn.negocio.interfaces.fachada.MONGestorInterfacesHome;
import es.indra.sicc.cmn.presentacion.subidaFichero.DTOFicheroResultado;
import es.indra.sicc.cmn.negocio.batch.DTOSalidaBatch;
import es.indra.sicc.cmn.negocio.batch.DTOBatch;

import es.indra.sicc.entidades.fac.TiposCierreLocal;
import es.indra.sicc.entidades.fac.TiposCierreLocalHome;
import es.indra.sicc.entidades.mae.ClienteDatosAdicionalesLocal;
import es.indra.sicc.entidades.mae.ClienteDatosAdicionalesLocalHome;
import es.indra.sicc.entidades.mae.ClienteHistoricoEstatusLocal;
import es.indra.sicc.entidades.mae.ClienteHistoricoEstatusLocalHome;
import es.indra.sicc.entidades.mae.EstatusClienteLocal;
import es.indra.sicc.entidades.mae.EstatusClienteLocalHome;
import es.indra.sicc.logicanegocio.fac.ConstantesFAC;
import es.indra.sicc.dtos.fac.DTOFACCierreFacturacion;
import es.indra.sicc.dtos.msg.ConstantesMSG;
import es.indra.sicc.dtos.msg.DTOBuzonMensajes;
import es.indra.sicc.dtos.zon.DTOFicheroDisp;
import es.indra.sicc.dtos.zon.DTOFicheroRezonificacion;
import es.indra.sicc.dtos.zon.DTORezonificacionCabecera;
import es.indra.sicc.dtos.zon.DTORezonificacionRegistro;
import es.indra.sicc.entidades.cra.PeriodoLocal;
import es.indra.sicc.entidades.mae.ClienteDatosBasicosLocal;
import es.indra.sicc.entidades.mae.ClienteDireccionLocal;
import es.indra.sicc.entidades.mae.ClienteDireccionLocalHome;
import es.indra.sicc.entidades.mae.ClienteUnidadAdministrativaLocal;
import es.indra.sicc.entidades.seg.CanalLocal;
import es.indra.sicc.entidades.seg.MarcaLocal;
import es.indra.sicc.entidades.seg.PaisLocal;
import es.indra.sicc.entidades.seg.PeriodoCorporativoLocal;
import es.indra.sicc.entidades.seg.TipoPeriodoCorporativoLocal;
import es.indra.sicc.entidades.zon.HistoricoZonasLocal;
import es.indra.sicc.entidades.zon.RegionLocal;
import es.indra.sicc.entidades.zon.RegionLocalHome;
import es.indra.sicc.entidades.zon.SeccionLocal;
import es.indra.sicc.entidades.zon.SeccionLocalHome;
import es.indra.sicc.entidades.zon.SubGerenciaVentaLocal;
import es.indra.sicc.entidades.zon.SubGerenciaVentaLocalHome;
import es.indra.sicc.entidades.zon.TerritorioAdministrativoLocal;
import es.indra.sicc.entidades.zon.TerritorioAdministrativoLocalHome;
import es.indra.sicc.entidades.zon.TerritorioLocal;
import es.indra.sicc.entidades.zon.ZonaLocal;
import es.indra.sicc.logicanegocio.cra.DAOCRA;
import es.indra.sicc.logicanegocio.fac.DAOFACCierreFacturacion;
import es.indra.sicc.logicanegocio.inc.Periodo;
import es.indra.sicc.logicanegocio.msg.MONGestionMensajes;
import es.indra.sicc.logicanegocio.msg.MONGestionMensajesHome;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.MAEEjbLocators;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;
import javax.ejb.CreateException;
import javax.ejb.FinderException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.sicc.entidades.seg.PaisLocalHome;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import es.indra.sicc.entidades.seg.MarcaLocalHome;
import es.indra.sicc.entidades.seg.CanalLocalHome;
import es.indra.sicc.entidades.seg.PeriodoCorporativoLocalHome;
import es.indra.sicc.entidades.cra.PeriodoLocalHome;
import es.indra.sicc.entidades.mae.ClienteDatosBasicosLocalHome;
import javax.rmi.PortableRemoteObject;
import es.indra.sicc.entidades.zon.TerritorioLocalHome;
import es.indra.sicc.entidades.mae.ClienteUnidadAdministrativaLocalHome;
import es.indra.sicc.entidades.zon.ZonaLocalHome;
import es.indra.sicc.entidades.zon.HistoricoZonasLocalHome;
import es.indra.sicc.entidades.seg.TipoPeriodoCorporativoLocalHome;
import es.indra.mare.enterprise.mln.BusinessFacadeLocalHome;
import es.indra.sicc.logicanegocio.cra.MONPeriodosHome;
import es.indra.sicc.logicanegocio.cra.MONPeriodos;
import es.indra.sicc.dtos.cra.DTOPeriodo;
import es.indra.sicc.dtos.zon.DTOEjecutarReterritorializacion;
import es.indra.sicc.dtos.zon.DTOEjecutarReterritorializacionCab;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class MONReterritorializacionBean implements SessionBean 
{
    private Long pais;
    private Long marca;
    private Long canal;
    private Long periodo;
    private String tipoPeriodo;
    public static String TIPO_OPERACION_PARTICION = "P";
    public static String TIPO_OPERACION_FUSION = "F";
    public static String TIPO_OPERACION_TRASVASE = "T";
    private RezonificacionFileWrapper fileWrapper;
    private HashMap UnidadesCreadas;
    private int TERRITORIO = 5;
    private ArrayList lineasConError;

    //(30/05/2007)agregado por incidencia Sicc-20070276 (Sapaza)
    private Long region;
    private ArrayList periodos = new ArrayList();
    private HashMap cierrePeriodos = new HashMap();
    private HashMap cierreRegiones = new HashMap();
    private Long periodoInicio;
    private Long periodoFin;
    private Long oidTipoCierrePeriodo = null;
    private Long oidTipoCierreRegion = null;
    private java.sql.Date fechaActual;
        
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

    public void setSessionContext(SessionContext ctx) {
 		this.ctx = ctx;
   }

    public DTOFicheroRezonificacion lanzarReterritorializacion(DTOFicheroDisp infoFichero) throws MareException{
        UtilidadesLog.info("MONReterritorializacionBean.lanzarReterritorializacion(DTOFicheroDisp infoFichero): Entrada");
        
        // Lee el fichero recibido y realiza el proceso de reterritorializacion        
        DTOFicheroRezonificacion fichero = this.leerFichero(infoFichero);
        
        // Comprueba los datos de la cabecera 
        this.obtenerDatosCabecera(fichero.getCabecera());

        // Valida si es un fichero de reterritorialización 
        boolean correcto = validarRTZ(fichero);
        if (!correcto){
            // Aborta el proceso. Se debe tratar el fichero con el CU Rezonificación 
            fileWrapper.cerrarArchivo();
            //Lanza una Excepción con código de error: 280300001 
            throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_ZON, "",
                ErroresDeNegocio.FICHERO_NO_DE_RETERRITORIALIZACION));
        }
        
        // Llama al proceso de rezonificación en modo Batch 
        DTOBatch dtoBatch = new DTOBatch( "reterritorializacion", new MareBusinessID( "ZONProcesarFicheroReterritorializacion" ), fichero); 
        
        try{
            BatchUtil.executeMLN( dtoBatch, "ZONReterritorializacion");
            //BatchUtil.executeMLN( dtoBatch, "FACProcesosGP5");
        }catch(RemoteException re){
                UtilidadesLog.error("*** Error en lanzarReterritorializacion",re);
                String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));			
        }

        UtilidadesLog.info("MONReterritorializacionBean.lanzarReterritorializacion(DTOFicheroDisp infoFichero): Salida");
        return fichero;
    }

  /**
   * 07-07-2006   Modificado por Sapaza, incidencia Sicc-20070276, se modifico para que manejara
   *              transacciones independientes por linea de detalle
   * @throws es.indra.mare.common.exception.MareException
   * @return 
   * @param dtoBatch
   */
    public DTOSalidaBatch reterritorializacion(DTOBatch dtoBatch) throws MareException
    {
        UtilidadesLog.info("MONReterritorializacionBean.reterritorializacion(DTOBatch dtoBatch): Entrada");
        // Procesa los registros recibidos y realiza el proceso de reterritorializacion correspondiente para cada uno 
        this.lineasConError = new ArrayList();
        // Obtiene el fichero del dtoBatch de entrada
        DTOFicheroRezonificacion fichero = null;
        try{
            fichero = (DTOFicheroRezonificacion)dtoBatch.getDTOOnline();
            UtilidadesLog.debug(" RECIBIDO DTOFicheroRezonificacion  "+fichero);        
        }catch(ClassCastException cce){
            UtilidadesLog.debug("**** ClassCastException  en  MONReestructuracionPrimeraFase.rezonificar, salimos del metodo : ");
            throw new MareException(" ClassCastException  en  MONReestructuracionPrimeraFase.rezonificar  ", cce);
        }
        
        // Obtiene los datos de cabecera 
        this.obtenerDatosCabecera(fichero.getCabecera());
        
        ArrayList regs = fichero.getRegistros();
        try{
         UtilidadesLog.debug("**** MONReestructuracionPrimeraFase.rezonificar, en el try : ");
        DTORezonificacionRegistro registro = null;
        int n = regs.size();
         UtilidadesLog.debug("**** MONReestructuracionPrimeraFase.rezonificar,n es : " + n);
        for (int posicion=0;posicion<n;posicion++){
            registro = (DTORezonificacionRegistro)fichero.getRegistros().get(posicion);
            
             UtilidadesLog.debug("**** el registro es: " + registro.toString() );
             if ( registro.getDatoOrigen1() == null || registro.getDatoOrigen1().trim().length() == 0 ){
                 UtilidadesLog.debug("**** el registroorigen es null o vacio "  );
                ErrorLineaFichero errorLineaFichero = new ErrorLineaFichero();
                errorLineaFichero.nroLinea = posicion + 1 ;
                errorLineaFichero.descError = FileInterfaceMensajes.M00048 + "1";
                this.lineasConError.add(errorLineaFichero );
                continue;
             }
             

              if ( registro.getDatoOrigen2() == null || registro.getDatoOrigen2().trim().length() == 0 ){
                UtilidadesLog.debug("**** el registroorigen2 es null o vacio "  );
                ErrorLineaFichero errorLineaFichero = new ErrorLineaFichero();
                errorLineaFichero.nroLinea = posicion + 1 ;
                errorLineaFichero.descError = FileInterfaceMensajes.M00048 + "2";
                this.lineasConError.add(errorLineaFichero) ;
                continue;
             }
             
             String datoNuevo = registro.getDatoNuevo();
             if(registro.getTipoOp().equalsIgnoreCase(ConstantesZON.TIPO_OPERACION_FUSION) && (
                    datoNuevo == null || datoNuevo.trim().length() == 0)){
                 
                  UtilidadesLog.debug("**** El tipo operacion es fusion y dato nuevo es vacio"  );
                  ErrorLineaFichero errorLineaFichero = new ErrorLineaFichero();
                  errorLineaFichero.nroLinea = posicion + 1 ;
                  errorLineaFichero.descError = FileInterfaceMensajes.M00048 + "3";
                  this.lineasConError.add(errorLineaFichero );
                  continue;           
                
             }else if ( !registro.getTipoOp().equalsIgnoreCase(ConstantesZON.TIPO_OPERACION_FUSION)
                        && ( registro.getCodCliente() == null 
                        || registro.getCodCliente().trim().length() == 0 ) ){
                        
                  UtilidadesLog.debug("**** El tipo operacion NO es fusion y cod cliente es vacio "  );      
                  ErrorLineaFichero errorLineaFichero = new ErrorLineaFichero();
                  errorLineaFichero.nroLinea = posicion + 1 ;
                  errorLineaFichero.descError = FileInterfaceMensajes.M00052;
                  this.lineasConError.add(errorLineaFichero);
                  continue;  
              }

            try {
                  //Realiza la operacion correspondiente
                  UtilidadesLog.debug("****Antes de realizar operacion correspondiente"  );  
                  realizarOperacionTransaccion(registro); //incidencia Sicc-20070276
            } catch(Exception m){
                  UtilidadesLog.error(" ...error al realizar operacion de linea Nro:" + (posicion + 1));
                  UtilidadesLog.error(m);
                  this.lineasConError.add(new ErrorLineaFichero(posicion + 1, m.getMessage()));
            } 
            
        }//fin for         
        } catch (Exception m) {
            UtilidadesLog.error(m);
            ctx.setRollbackOnly();
            if (m instanceof MareException)
                throw (MareException)m;
        } finally {
            // Incidencia 21808
            UtilidadesLog.debug(" ...grabando el LOG del proceso");
            this.grabarLogErroresReterritorializacion(fichero);
        }
        UtilidadesLog.info("MONReterritorializacionBean.reterritorializacion(DTOBatch dtoBatch): Salida");
        return new DTOSalidaBatch ( 0,"Reterritorializacion realizada" );
    }
  
  private MONGestorInterfacesHome getMONGestorInterfacesHome() throws MareException {
        UtilidadesLog.info("MONReterritorializacionBean.getMONGestorInterfacesHome(): Entrada");
        try {
            final InitialContext context = new InitialContext();
            MONGestorInterfacesHome mgiH = null;
            mgiH = (MONGestorInterfacesHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONGestorInterfaces"), MONGestorInterfacesHome.class);
            UtilidadesLog.info("MONReterritorializacionBean.getMONGestorInterfacesHome(): Salida");
            return mgiH;
        } catch (NamingException ne) {
            throw new MareException(ne, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        
    }
    private void grabarLogErroresReterritorializacion(DTOFicheroRezonificacion fichero) throws MareException {
        UtilidadesLog.info("MONReterritorializacionBean.grabarLogErroresReestructuracion(): Entrada");
        
        MONGestorInterfaces gestor = null;
        MONGestorInterfacesHome monGestorInterfacesHome = null;
        InterfazInfo info = null;
        InterfazInfo interfaz = null;
        RegistroSicc registro = new RegistroSicc();
        
        int cantErrores = this.lineasConError.size();
        UtilidadesLog.debug("...hubo errores " + cantErrores);
        
        DTORezonificacionCabecera cabeceraArchivo = fichero.getCabecera();
        UtilidadesLog.debug("...cabecera de archivo: " + cabeceraArchivo);
        
        try {
            /* Archivo "ZON-2_<numeroLote>.TXT"
             * Contiene
             *  - Cabecera
             *    nombreFicheroOriginal
             *    fechayHoraProceso
             *    copia de la cabecera original
             *  - Detalle
             *    NroLineaDelError + "Faltan datos...."
             * rezonificacion procesado y la cantidad de errores ocurridos.
             */
            
            /* Fecha y hora del proceso */
            Timestamp ahora = new Timestamp(System.currentTimeMillis()); 
                        
            /* Caracter para separar lineas de la cabecera - seria el 'Enter' */
            String bajaLinea = System.getProperty( "line.separator" );
                                    
            /* String vacio para los casos en que los campos van vacios */
            String vacio = new String();
            
            /* Variables para la cabecera del Log */
            String nombreFichero = fichero.getNombreFichero() + bajaLinea;
            String fechaProceso = ahora.toString() + bajaLinea;
            String pais = cabeceraArchivo.getCodPais() + bajaLinea;
            String marca = cabeceraArchivo.getCodMarca() + bajaLinea;
            String canal = cabeceraArchivo.getCodCanal() + bajaLinea;
            String tipoPeriodo = cabeceraArchivo.getTipoPeriodo() + bajaLinea;
            String periodoInicio = cabeceraArchivo.getPeriodoInicio() + bajaLinea;
            String fechaActualizacion = cabeceraArchivo.getFechaActualizacion().toString() + bajaLinea;
            
            // vbongiov -- 29/10/2007
            String fechaCreacionGis = null;
            if(cabeceraArchivo.getFechaCreacionGIS()!=null){
                fechaCreacionGis = cabeceraArchivo.getFechaCreacionGIS().toString() + bajaLinea;
            } else {
                fechaCreacionGis = " " + bajaLinea;
            }
            
            
            monGestorInterfacesHome = getMONGestorInterfacesHome();
            gestor = monGestorInterfacesHome.create();
            info = gestor.obtenerInterfazInfo(IGestorInterfaces.COD_INTERFAZ_ZON2, this.pais);
            interfaz = gestor.crearInterfaz(info);
                        
            
            /** Cabecera del LOG */
            registro.vaciar();
            registro.anyadirCampo(IRegistroSicc.ZON_NOMBRE_FICHERO, nombreFichero);
            registro.anyadirCampo(IRegistroSicc.ZON_FECHA_PROCESO, fechaProceso);
            
            registro.anyadirCampo(IRegistroSicc.ZON_PAIS, pais);
            registro.anyadirCampo(IRegistroSicc.ZON_MARCA, marca);
            registro.anyadirCampo(IRegistroSicc.ZON_CANAL, canal);
            registro.anyadirCampo(IRegistroSicc.ZON_TIPO_PERIODO, tipoPeriodo);
            registro.anyadirCampo(IRegistroSicc.ZON_PERIODO_INICIO, periodoInicio);
            registro.anyadirCampo(IRegistroSicc.ZON_FECHA_ACTUALIZACION, fechaActualizacion);
            registro.anyadirCampo(IRegistroSicc.ZON_CREACION_GIS, fechaCreacionGis);
            if (cantErrores > 0) { // El encabezado del detalle
                registro.anyadirCampo(IRegistroSicc.ZON_DETALLE, "        Linea" + "\t" + "Error");
            } else {
                registro.anyadirCampo(IRegistroSicc.ZON_DETALLE, vacio);
            }
            
            gestor.anyadirRegistro(interfaz, registro);
            UtilidadesLog.debug("... la cabecera se grabo correctamente en el archivo Log de ZON");
            
            ErrorLineaFichero errorLinea;
            String descripcionError;
            
            if (cantErrores > 0) {
                for (int i = 0; i < cantErrores; i++) {
                    errorLinea = (ErrorLineaFichero) this.lineasConError.get(i);
                    descripcionError = errorLinea.getNroLinea() + "\t" + errorLinea.getDescError();
                    
                    /** Detalle del LOG - con errores */
                    registro.vaciar();
                    // Van los datos de cabecera vacios para evitar error en cantidad de campos
                    registro.anyadirCampo(IRegistroSicc.ZON_NOMBRE_FICHERO, vacio);
                    registro.anyadirCampo(IRegistroSicc.ZON_FECHA_PROCESO, vacio); 
                    registro.anyadirCampo(IRegistroSicc.ZON_PAIS, vacio);
                    registro.anyadirCampo(IRegistroSicc.ZON_MARCA, vacio);
                    registro.anyadirCampo(IRegistroSicc.ZON_CANAL, vacio);
                    registro.anyadirCampo(IRegistroSicc.ZON_TIPO_PERIODO, vacio);
                    registro.anyadirCampo(IRegistroSicc.ZON_PERIODO_INICIO, vacio);
                    registro.anyadirCampo(IRegistroSicc.ZON_FECHA_ACTUALIZACION, vacio);
                    registro.anyadirCampo(IRegistroSicc.ZON_CREACION_GIS, vacio);
                    
                    registro.anyadirCampo(IRegistroSicc.ZON_DETALLE, descripcionError);
                    gestor.anyadirRegistro(interfaz, registro);
                }
            } else {
                    /** Detalle del LOG - cuando no hay errores */
                    String resultadoProceso = "El proceso finalizó sin errores en las lineas de operacion.";
                    registro.vaciar();
                    // Van los datos de cabecera vacios para evitar error en cantidad de campos
                    registro.anyadirCampo(IRegistroSicc.ZON_NOMBRE_FICHERO, vacio);
                    registro.anyadirCampo(IRegistroSicc.ZON_FECHA_PROCESO, vacio); 
                    registro.anyadirCampo(IRegistroSicc.ZON_PAIS, vacio);
                    registro.anyadirCampo(IRegistroSicc.ZON_MARCA, vacio);
                    registro.anyadirCampo(IRegistroSicc.ZON_CANAL, vacio);
                    registro.anyadirCampo(IRegistroSicc.ZON_TIPO_PERIODO, vacio);
                    registro.anyadirCampo(IRegistroSicc.ZON_PERIODO_INICIO, vacio);
                    registro.anyadirCampo(IRegistroSicc.ZON_FECHA_ACTUALIZACION, vacio);
                    registro.anyadirCampo(IRegistroSicc.ZON_CREACION_GIS, vacio);
                    
                    registro.anyadirCampo(IRegistroSicc.ZON_DETALLE, resultadoProceso);
                    gestor.anyadirRegistro(interfaz, registro);
            }
            UtilidadesLog.debug("... el detalle se grabo correctamente en el archivo Log de ZON");
            gestor.enviarInterfaz(interfaz);
            
        } catch (InterfacesException iex) {
            UtilidadesLog.error(iex);
            throw new MareException(iex, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (RemoteException rex) {
            UtilidadesLog.error(rex);
            throw new MareException(rex, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (CreateException cex) {
            UtilidadesLog.error(cex);
            throw new MareException(cex, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        UtilidadesLog.info("MONReterritorializacionBean.grabarLogErroresReestructuracion(): Salida");
    }

    private void obtenerDatosCabecera (DTORezonificacionCabecera cabecera) throws MareException {
        UtilidadesLog.info("MONReterritorializacionBean.obtenerDatosCabecera (DTORezonificacionCabecera cabecera): Entrada");
        UtilidadesLog.debug("DTORezonificacionCabecera recibido: " + cabecera);

        // BELC300018983
        PaisLocal paisLocal = null;
        try {
            paisLocal = this.getPaisLocalHome().findByUk(cabecera.getCodPais());
        } catch (NoResultException e) {
            // Si se captura una Excepción, generar una MareException con error: 280320001 - "El país no existe"
            throw new MareException(e, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_ZON, "", ErroresDeNegocio.PAIS_NO_EXISTE));
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        MarcaLocal marcaLocal = null;
        try {
            marcaLocal = this.getMarcaLocalHome().findByUK(cabecera.getCodMarca());
        } catch (NoResultException e) {
            // Si se captura una Excepción, generar una MareException con error: 280330001 - "La marca no existe"
            throw new MareException(e, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_ZON, "", ErroresDeNegocio.MARCA_NO_EXISTE));
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        CanalLocal canalLocal = null;
        try {
            canalLocal = this.getCanalLocalHome().findByUK(cabecera.getCodCanal());
        } catch (NoResultException e) {
            // Si se captura una Excepción, generar una MareException con error: 280340001 - "El canal no existe"
            throw new MareException(e, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_ZON, "", ErroresDeNegocio.CANAL_NO_EXISTE));
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        TipoPeriodoCorporativoLocal tipoPeriodoCorporativoLocal = null;
        try {
            tipoPeriodoCorporativoLocal = this.getTipoPeriodoCorporativoLocalHome().findByUk(cabecera.getTipoPeriodo());
        } catch (NoResultException e) {
            // Si se captura una Excepción, generar una MareException con error: 280350001 - "El tipo periodo no existe"
            throw new MareException(e, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_ZON, "", ErroresDeNegocio.TIPO_PERIODO_NO_EXISTE));
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        //obtenemos el periodo que viene por fichero, sino viene obtenemos periodo actual.
        Long periodoReferencia;
        UtilidadesLog.debug("periodoInicio " + cabecera.getPeriodoInicio());
        if ( cabecera.getPeriodoInicio() != null && (!cabecera.getPeriodoInicio().equals("")) ) {
            PeriodoCorporativoLocal periodoCorporativoLocal = null;
            try {
                periodoCorporativoLocal = this.getPeriodoCorporativoLocalHome().findByUK(cabecera.getPeriodoInicio());
            } catch (NoResultException e) {
                // Si se captura una Excepción, generar una MareException con error: 280360001 - "El periodo no existe"
                throw new MareException(e, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_ZON, "", ErroresDeNegocio.PERIODO_NO_EXISTE));
            }  catch (PersistenceException ce) {   
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
            PeriodoLocal periodoLocal = null;
            try {
                periodoLocal = this.getPeriodoLocalHome().findByUk(periodoCorporativoLocal.getOid(), marcaLocal.getOid(), paisLocal.getOid(), canalLocal.getOid());
            } catch (NoResultException e) {
                throw new MareException(e, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_ZON, "", ErroresDeNegocio.PERIODO_NO_EXISTE));    
            }  catch (PersistenceException ce) {   
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
            periodoReferencia = periodoLocal.getOid();
        } else {
            MONPeriodos monPeriodo = this.getMONPeriodos();
            DTOPeriodo dtoPeriodo;
            try {
                dtoPeriodo = monPeriodo.obtienePeriodoActual(paisLocal.getOid(), marcaLocal.getOid(), canalLocal.getOid()) ;
                UtilidadesLog.debug("periodoActual " + dtoPeriodo);
            } catch (RemoteException e) {
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
            periodoReferencia = dtoPeriodo.getOid() ;
        }
        
        this.pais = paisLocal.getOid(); 
        this.marca = marcaLocal.getOid();
        this.canal = canalLocal.getOid(); 
        this.periodo = periodoReferencia;
        this.tipoPeriodo = cabecera.getTipoPeriodo();
        this.fechaActual = obtenerFechaActual();  //agregado por incidencia SiCC-20070262 (25-05-2007) (Sapaza)        
        UtilidadesLog.info("MONReterritorializacionBean.obtenerDatosCabecera (DTORezonificacionCabecera cabecera): Salida");
    }
    
    private boolean validarRTZ (DTOFicheroRezonificacion fichero) throws MareException {
        UtilidadesLog.info("MONReterritorializacionBean.validarRTZ (DTOFicheroRezonificacion fichero): Entrada");
        // Valida si el fichero recibido es de reterritorialización 
        if (fichero.getRegistros() != null){
            ArrayList regs = fichero.getRegistros();
    
            DTORezonificacionRegistro registro = null;
            int n = regs.size();
            for (int posicion=0;posicion<n;posicion++){
                registro = (DTORezonificacionRegistro)fichero.getRegistros().get(posicion);
                DatoRegistro datoRegistro1 = new DatoRegistro(registro.getDatoOrigen1());
                DatoRegistro datoRegistro2 = new DatoRegistro(registro.getDatoOrigen2());
                if( (datoRegistro1.esTerritorio()==false) || (datoRegistro2.esTerritorio()==false) ||
              
                    datoRegistro1.getTerritorio().equals( datoRegistro2.getTerritorio() ) ){ // INC BELC300024021 gPineda 06/06/2006
                    return false;
                } 
            }
        }else{
            return false;
        }
      
        UtilidadesLog.info("MONReterritorializacionBean.validarRTZ (DTOFicheroRezonificacion fichero): Salida");
        return true;
    }

    private DTOFicheroRezonificacion leerFichero (DTOFicheroDisp infoFichero) throws MareException {
        UtilidadesLog.info("MONReterritorializacionBean.leerFichero (DTOFicheroDisp infoFichero): Entrada");

        // Lee el fichero indicado en la entrada  
        this.fileWrapper = new RezonificacionFileWrapper(infoFichero.getPathFichero(), infoFichero.getNombreFichero());

        // Lee la cabecera del fichero 
        DTOFicheroRezonificacion dtoFicheroRezonificacion = new DTOFicheroRezonificacion();
        dtoFicheroRezonificacion.setCabecera((DTORezonificacionCabecera)fileWrapper.leerCabecera());
        //this.obtenerDatosCabecera(dtoFicheroRezonificacion.getCabecera());    //BELC300018451

        // Lee los registros del fichero 
        DTORezonificacionRegistro dtoRezonificacionRegistro = (DTORezonificacionRegistro)fileWrapper.leerRegistro();
        dtoFicheroRezonificacion.setRegistros(new ArrayList());
        
        while (dtoRezonificacionRegistro != null) {
            dtoFicheroRezonificacion.getRegistros().add(dtoRezonificacionRegistro);
            dtoRezonificacionRegistro = (DTORezonificacionRegistro)fileWrapper.leerRegistro();
        }
        dtoFicheroRezonificacion.setNombreFichero(infoFichero.getNombreFichero());
        // Cierra el archivo 
        fileWrapper.cerrarArchivo(); 
        
        UtilidadesLog.info("MONReterritorializacionBean.leerFichero (DTOFicheroDisp infoFichero): Salida");
        return dtoFicheroRezonificacion;
    }

  /**
   * 05/06/2007   Modificado por Sapaza, incidencia Sicc-20070276, se modifica para que lance
   *              una transaccion por cada detalle del fichero
   * @throws es.indra.mare.common.exception.MareException
   * @param mapValores
   * @param registro
   */
    public void realizarOperacion(DTORezonificacionRegistro registro, HashMap mapValores) throws MareException {
        UtilidadesLog.info("MONReterritorializacionBean.realizarOperacion (DTORezonificacionRegistro registro, HashMap mapValores): Entrada");
        
        //recupera Valores de Cabecera del Fichero, incidencia 20070276
        ponerValoresFichero(mapValores);
        
        // Realiza la operación indicada entre las dos unidades administrativas recibidas
        if (registro.getTipoOp().equals(ConstantesZON.TIPO_OPERACION_PARTICION)){
            particion(registro); 
        }
        if (registro.getTipoOp().equals(ConstantesZON.TIPO_OPERACION_FUSION)){
            fusion(registro); 
        }
        if (registro.getTipoOp().equals(ConstantesZON.TIPO_OPERACION_TRASVASE)){
            trasvase(registro);
            // Agregado por INC 21881 - dmorello, 02/01/2006
            // Solo para trasvase - INC 22937 31/05/2006
            this.generarMensaje(registro);
        }
        
        // Genera el histórico de la operación
        this.generarHistorico(registro); 
    
        UtilidadesLog.info("MONReterritorializacionBean.realizarOperacion (DTORezonificacionRegistro registro, HashMap mapValores): Salida");
    }
    
    private void particion (DTORezonificacionRegistro registro) throws MareException {
        UtilidadesLog.info("MONReterritorializacionBean.particion (DTORezonificacionRegistro registro): Entrada");
        
        // Realiza la partición de una UA en otra
        // Obtiene la UA correspondiente al dato origen 1 del registro
        ClienteDatosBasicosLocal clienteDatosBasicosLocal = null;
        try {
            clienteDatosBasicosLocal = this.getClienteDatosBasicosLocalHome().findByCodigoYPais(this.pais,registro.getCodCliente());
        } catch (NoResultException fex) {
            UtilidadesLog.debug("Cliente Datos Basicos no existe");
           // throw new MareException(fex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
          throw new MareException(FileInterfaceMensajes.M00053);
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        DatoRegistro datoRegistro1 = new DatoRegistro(registro.getDatoOrigen1(),registro.getNse1(),registro.getNse2());
      
        UnidadAdministrativa unidadAdministrativa1 = null; 
        try{
         unidadAdministrativa1 = obtenerTerritorio(datoRegistro1);
        } catch(MareException mex){
          String mensaje = FileInterfaceMensajes.M00049 + "1" +":"+mex.getMessage();
          throw new MareException(mensaje);
        }
        // Obtiene al dato origen 2 del registro
        DatoRegistro datoRegistro2 = new DatoRegistro(registro.getDatoOrigen2(),registro.getNse1(),registro.getNse2());
        
        //Particiona la unidad 1 generando una nueva unidad con código 2
        UnidadAdministrativa nuevaUnidad = unidadAdministrativa1.particion(clienteDatosBasicosLocal.getOid(),datoRegistro2.getTerritorio());
        
        nuevaUnidad.setOidPadre( unidadAdministrativa1.getOidPadre());
        nuevaUnidad.setOidUnidadGeografica(unidadAdministrativa1.getOidUnidadGeografica());

        nuevaUnidad.setNse1(datoRegistro1.obtenerNSE1());
        nuevaUnidad.setNse2(datoRegistro1.obtenerNSE2());
        
        //Guarda la nueva unidad fruto de la fusión
        this.guardarTerritorio(nuevaUnidad);
        
        //Actualiza la unidad original
        this.actualizarTerritorio(unidadAdministrativa1, nuevaUnidad.getOid(), clienteDatosBasicosLocal.getOid());

        // Asigna el nivel socioeconómico
        try {            
            this.getMONReestructuracion().asignarNSE(this.pais, this.marca, this.canal, nuevaUnidad.getOid(), null, null);        
        } catch(RemoteException re) {
            UtilidadesLog.error("*** Error en partición",re);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));			
        }

        UtilidadesLog.info("MONReterritorializacionBean.particion (DTORezonificacionRegistro registro): Salida");
    }
    
    private UnidadAdministrativa obtenerTerritorio (DatoRegistro datoRegistro) throws MareException {
        UtilidadesLog.info("MONReterritorializacionBean.obtenerTerritorio (DatoRegistro datoRegistro): Entrada");
        
         UtilidadesLog.debug("Canal " + this.canal);
         UtilidadesLog.debug("Pais " + this.pais);
         UtilidadesLog.debug("Marca " + this.marca);         
         UtilidadesLog.debug("datoRegistro.getTerritorio(): " + datoRegistro.getTerritorio());   
         
        // Obtiene el territorio
        TerritorioLocal territorioLocal = null;
        
        SubGerenciaVentaLocal subGerenciaVentaLocal = obtenerSubgerencia(datoRegistro.getSubgerencia());
        Long oidSGV = subGerenciaVentaLocal.getOidSubgVenta();
                
        RegionLocal regionLocal = obtenerRegion(datoRegistro.getRegion(), oidSGV);
        Long oidRegion = regionLocal.getOid();
        this.region = oidRegion; //incidencia SiCC-20070262
              
        ZonaLocal zonaLocal = obtenerZona(datoRegistro.getZona(), oidRegion);
        
        //obtengo la zona solo para saber si existe en esa region, 
        //en ese caso lanza una excepcion antes de continuar
        Long oidZona = zonaLocal.getOid();
        SeccionLocal seccionLocal = obtenerSeccion(datoRegistro.getSeccion(), oidZona);
        
        Long oidValoresEstrGeo = null;
        Long oidTerri = null;
        
        try{
        
            UtilidadesLog.debug("datoRegistro.getTerritorio(): " + datoRegistro.getTerritorio());
            UtilidadesLog.debug("this.pais: " + this.pais);
            
            Collection colec = this.getTerritorioLocalHome().findByCodigoPais(new Long(datoRegistro.getTerritorio()), this.pais);
            UtilidadesLog.debug("Terri colec " + colec + " - " + colec.size());
            if (!colec.isEmpty() && colec.size() == 1) {
                Iterator iterator = colec.iterator();
                territorioLocal = (TerritorioLocal) iterator.next();
                oidValoresEstrGeo = territorioLocal.getOidValoresEstruGeo();
                oidTerri = territorioLocal.getOid();
            } else { 
            
                Timestamp fechActT = new Timestamp(System.currentTimeMillis());
                String fechAct = fechActT.getDate() + "/" +(fechActT.getMonth()+1) + "/" + (fechActT.getYear()+1900);
                
                UtilidadesLog.debug("fechAct: " + fechAct);
            
                DAOEjecutarReterritorializacion dao = new DAOEjecutarReterritorializacion();
                RecordSet rs = dao.buscarTerritorioPorCodigoPaisBorradoRTZ(new Long(datoRegistro.getTerritorio()), 
                                                                                 this.pais,
                                                                                 fechAct);
                UtilidadesLog.debug("Terri colec borrada por RTZ: " + colec + " - " + colec.size());
                
                if (!rs.esVacio() && rs.getRowCount() == 1) {
                    oidValoresEstrGeo = new Long(((BigDecimal)rs.getValueAt(0, "VEPO_OID_VALO_ESTR_GEOP")).longValue());
                    oidTerri = new Long(((BigDecimal)rs.getValueAt(0, "OID_TERR")).longValue());
                } else { 
                    UtilidadesLog.debug("*** No se encontró el Territorio***");
                    throw new MareException("No se encontró el Territorio", UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
                }
            }
        } catch (NoResultException fex) {
            UtilidadesLog.debug("Territorio no existe");
            throw new MareException(fex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
            
        UnidadAdministrativa territorio = crearTerritorio(oidTerri,datoRegistro.getTerritorio(), datoRegistro.getSeccion(), zonaLocal.getOid()); 
        territorio.setOidUnidadGeografica(oidValoresEstrGeo); // BELC300018846

        UtilidadesLog.info("MONReterritorializacionBean.obtenerTerritorio (DatoRegistro datoRegistro): Salida");
        return territorio;
    }
    
    private UnidadAdministrativa crearTerritorio (Long oidTerritorio, String codTerritorio, 
                                                  String codSeccion, Long oidZona) 
                                                  throws MareException {
        UtilidadesLog.info("MONReterritorializacionBean.crearTerritorio (Long oidTerritorio, String codTerritorio, String codSeccion, Long oidZona) : Entrada");
        
        UtilidadesLog.debug("oidTerritorio: " + oidTerritorio);
        UtilidadesLog.debug("codTerritorio: " + codTerritorio);
        UtilidadesLog.debug("codSeccion: " + codSeccion);
        UtilidadesLog.debug("oidZona: " + oidZona);
        
        // Crea un territorio y obtiene todos los clientes pertenecientes al mismo
        // Incidencia BELC300018817
        UnidadAdministrativa uaTerritorio = new UnidadAdministrativa(this.TERRITORIO, oidTerritorio, codTerritorio, "");
        uaTerritorio.setOidTerritorio(oidTerritorio);
        
        // Obtenemos la sección
        SeccionLocal seccionLocal = null;
        try{
            // Incidencia BELC300018857
            Collection colec = this.getSeccionLocalHome().findByCodigo(this.pais, this.marca, this.canal, oidZona, codSeccion);
            UtilidadesLog.debug("Seccion colec: " + colec);
            if (!colec.isEmpty() && colec.size() == 1) {
                Iterator iterator = colec.iterator();
                seccionLocal = (SeccionLocal) iterator.next();
            } else { 
                UtilidadesLog.debug("*** No se encontró la sección***");
                throw new MareException("", UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            }
            
            uaTerritorio.setOidPadre(seccionLocal.getOid());
        } catch (NoResultException fex) {
            UtilidadesLog.debug("Sección no existe");
            throw new MareException(fex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        
        // Obtenemos el territorio administrativo
        TerritorioAdministrativoLocal territorioAdministrativoLocal = null;
        Long oidTerriAdmin = null;
        try{
            Collection colec = this.getTerritorioAdministrativoLocalHome().findBySeccionTerritorio(seccionLocal.getOid(), oidTerritorio);
            UtilidadesLog.debug("TerritorioAdmin colec: " + colec);
            if (!colec.isEmpty() && colec.size() == 1) {
                Iterator iterator = colec.iterator();
                territorioAdministrativoLocal = (TerritorioAdministrativoLocal) iterator.next();
                oidTerriAdmin = territorioAdministrativoLocal.getOid();
            } else { 
            
                Timestamp fechActT = new Timestamp(System.currentTimeMillis());
                String fechAct = fechActT.getDate() + "/" +(fechActT.getMonth()+1) + "/" + (fechActT.getYear()+1900);
                
                UtilidadesLog.debug("fechAct: " + fechAct);
                
                DAOEjecutarReterritorializacion dao = new DAOEjecutarReterritorializacion();
                RecordSet rs =dao.obtenerTerriAdminPorSeccionTerritorioBorrRTZ(seccionLocal.getOid(),  oidTerritorio, fechAct);

                if (!rs.esVacio() && rs.getRowCount() == 1) {
                    oidTerriAdmin = new Long(((BigDecimal)rs.getValueAt(0, "OID_TERR_ADMI")).longValue());
                } else {            
                    UtilidadesLog.debug("*** No se encontró el TerritorioAdministrativo***");
                    throw new MareException("", UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
                }
            }
            
            UtilidadesLog.debug("territorioAdministrativoLocal.getOid(): " + oidTerriAdmin);            
            uaTerritorio.setOidTerritorioAdm(oidTerriAdmin);
        } catch (NoResultException fex) {
            UtilidadesLog.debug("Territorio Administrativo no existe");
            throw new MareException(fex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        
        // Obtenemos los clientes del territorio administrativo  
        DAOReestructuracion daoReestruccturacion = new DAOReestructuracion();
        RecordSet clientes = daoReestruccturacion.obtenerClientesPorTerritorioFisico(oidTerritorio);
        
        if (clientes != null && !clientes.esVacio()){
            int n = clientes.getRowCount();
            Long oidCliente = null;
            ArrayList arrayClientes = new ArrayList();
            for (int i = 0; i < n; i++) {
                oidCliente = new Long(((BigDecimal)clientes.getValueAt(i,"OID_CLIENTE")).longValue());
                arrayClientes.add(oidCliente);
            }
            uaTerritorio.setClientes(arrayClientes);
        }
        
        UtilidadesLog.debug("uaTerritorio.clientes: " + uaTerritorio.getClientes());
        
        UtilidadesLog.info("MONReterritorializacionBean.crearTerritorio (Long oidTerritorio, String codTerritorio, String codSeccion, Long oidZona): Salida");
        return uaTerritorio;
    }
    
    private void fusion (DTORezonificacionRegistro registro) throws MareException {
        UtilidadesLog.info("MONReterritorializacionBean.fusion (DTORezonificacionRegistro registro): Entrada");
        // Realiza la fusión de los 2 territorios contenidos en el registro
        
        // Obtiene la UA correspondiente al dato origen 1 del registro 
        DatoRegistro datoRegistro1 = null;
        UnidadAdministrativa unidadAdministrativa1 = null;
        try{
          datoRegistro1 = new DatoRegistro(registro.getDatoOrigen1(), registro.getNse1(), registro.getNse2()); 
          unidadAdministrativa1 = this.obtenerTerritorio(datoRegistro1);      
        }catch (MareException mex) {
          String mensaje = FileInterfaceMensajes.M00049 + "1" +":"+mex.getMessage();
          throw new MareException(mensaje);
        }
        // Obtiene la UA correspondiente al dato origen 2 del registro 
        DatoRegistro datoRegistro2 = null;
        UnidadAdministrativa unidadAdministrativa2 = null;
        try{
           datoRegistro2 = new DatoRegistro(registro.getDatoOrigen2(), registro.getNse1(), registro.getNse2());
           unidadAdministrativa2 = this.obtenerTerritorio(datoRegistro2); 
        }catch(MareException mex){
          String mensaje = FileInterfaceMensajes.M00049 + "2" +":"+mex.getMessage();
          throw new MareException(mensaje);
        }
        // Obtiene la UA correspondiente al dato destino del registro 
        DatoRegistro datoDestino = new DatoRegistro(registro.getDatoNuevo(), registro.getNse1(), registro.getNse2());
        
        // Fusiona ambas unidades y asigna código al resultado
        UnidadAdministrativa nuevaUnidad = unidadAdministrativa1.fusion(unidadAdministrativa2, datoDestino.getTerritorio());
        
        nuevaUnidad.setNse1(datoDestino.obtenerNSE1()); 
        nuevaUnidad.setNse2(datoDestino.obtenerNSE2()); 
        
        // Guarda la nueva unidad fruto de la fusión 
        this.guardarTerritorio(nuevaUnidad);
        
        // Actualiza las unidades originales 
        this.actualizarTerritorio(unidadAdministrativa1, nuevaUnidad.getOid(), null); 
        this.actualizarTerritorio(unidadAdministrativa2, nuevaUnidad.getOid(), null);
        
        // Asigna el nivel socioeconómico
        MONReestructuracion monReestructuracion = this.getMONReestructuracion();                
        try {
            monReestructuracion.asignarNSE(this.pais, this.marca, this.canal, nuevaUnidad.getOid(), null, null);
        } catch (RemoteException e)  {
          String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
          throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));    			
        } 
        
        UtilidadesLog.info("MONReterritorializacionBean.fusion (DTORezonificacionRegistro registro): Salida");
    }
    
    //BELC300019427        
    private void actualizarTerritorio (UnidadAdministrativa unidad, Long oidTerritorioNuevo, Long oidCliente) throws MareException {
        UtilidadesLog.info("MONReterritorializacionBean.actualizarTerritorio (UnidadAdministrativa unidad, Long oidTerritorioNuevo, Long oidCliente): Entrada");
        UtilidadesLog.debug("oidTerritorioNuevo:" + oidTerritorioNuevo);
        // Desactiva el territorio administrativo correspondiente 
        TerritorioAdministrativoLocal territorioAdministrativoLocal = null;
        try {
            UtilidadesLog.debug("unidad.getOidTerritorioAdm()" + unidad.getOidTerritorioAdm());
            territorioAdministrativoLocal = this.getTerritorioAdministrativoLocalHome().findByPrimaryKey(unidad.getOidTerritorioAdm());
        } catch (NoResultException e) { 
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            UtilidadesLog.error("actualizarTerritorio: FinderException", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));    				
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        //PENDIENTE INCIDENCIA BELC300018478
        territorioAdministrativoLocal.setPeriodoFin(this.periodo);
        territorioAdministrativoLocal.setFechaReterri(new Timestamp(System.currentTimeMillis()));
        territorioAdministrativoLocal.setBorrado(new Long(1));
        
        this.getTerritorioAdministrativoLocalHome().merge(territorioAdministrativoLocal);
        
        // Busca otras relaciones del territorio con secciones de distinta marca y canal 
        //numeroTerritorios = DAORezonificacion.obtenerTerritoriosAdministrativosPeriodoActual....
        //INCIDENCIA BELC300018806 POR SI ES DAOReestructuracion en vez de DAORezonificacion
        DAOReestructuracion daoR = new DAOReestructuracion();
        Long numeroTerritorios = daoR.obtenerTerritoriosAdministrativosPeriodoActual(this.pais,this.marca,this.canal,unidad.getOid()) ;
        
        // Si no hay relacciones elimina el territorio 
        if (numeroTerritorios.longValue()==0){
            TerritorioLocal territorioLocal = null;
            try {
                UtilidadesLog.debug("unidad.getOid()" + unidad.getOid());
                territorioLocal = this.getTerritorioLocalHome().findByPrimaryKey(unidad.getOid());
            } catch (NoResultException e) { 
                UtilidadesLog.error(e);
                ctx.setRollbackOnly();
                String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
                UtilidadesLog.error("MONReterritorializacionBean.actualizarTerritorio: FinderException", e);
                throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));    				
            }  catch (PersistenceException ce) {   
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
            territorioLocal.setFechaRtz(new Timestamp(System.currentTimeMillis()));
            territorioLocal.setBorrado(new Long(1));
            this.getTerritorioLocalHome().merge(territorioLocal);
        }

        if (oidCliente != null) {
                this.actualizarCliente(oidCliente, unidad.getOidTerritorioAdm()); 
                this.actualizarDireccionCliente(oidCliente, unidad.getOid(), oidTerritorioNuevo);
        } else
            for (int i = 0; i < unidad.getClientes().size(); i++) {
                this.actualizarCliente((Long)unidad.getClientes().get(i), unidad.getOidTerritorioAdm()); 
                this.actualizarDireccionCliente((Long)unidad.getClientes().get(i), unidad.getOid(), oidTerritorioNuevo);
            }

        UtilidadesLog.info("MONReterritorializacionBean.actualizarTerritorio (UnidadAdministrativa unidad, Long oidTerritorioNuevo, Long oidCliente): Salida");
    }
    
    private void guardarTerritorio (UnidadAdministrativa unidad) throws MareException {
        UtilidadesLog.info("MONReterritorializacionBean.guardarTerritorio (UnidadAdministrativa unidad): Entrada");
        UtilidadesLog.debug("unidad.getOid()" + unidad.getOid());
        UtilidadesLog.debug("unidad.getTipo()" + unidad.getTipo());
        UtilidadesLog.debug("unidad.obtenerCodigoCompleto()" + unidad.obtenerCodigoCompleto());
        
        if (this.UnidadesCreadas == null) this.UnidadesCreadas = new HashMap();
        UtilidadesLog.debug("this.UnidadesCreadas:" + this.UnidadesCreadas);
        // Comprueba si existe el territorio
        if (this.UnidadesCreadas.containsKey(unidad.obtenerCodigoCompleto())) {
            // Si lo obtiene recupero el oid que se guardo
            unidad.setOidTerritorio((Long)this.UnidadesCreadas.get(unidad.obtenerCodigoCompleto()));
            unidad.setOid(unidad.getOidTerritorio());
            //BELC300019362
            try {
                TerritorioLocal territorio = this.getTerritorioLocalHome().findByPrimaryKey(unidad.getOid());
                Collection colec = this.getTerritorioAdministrativoLocalHome().findBySeccionTerritorio(unidad.getOidPadre(), unidad.getOid());
                if (!colec.isEmpty() && colec.size() == 1) {
                    Iterator iterator = colec.iterator();
                    TerritorioAdministrativoLocal territorioAdministrativoLocal = (TerritorioAdministrativoLocal) iterator.next();
                    UtilidadesLog.debug("territorioAdministrativoLocal.getOid(): " + territorioAdministrativoLocal.getOid());
                    unidad.setOidTerritorioAdm(territorioAdministrativoLocal.getOid());
                } else { 
                    UtilidadesLog.debug("*** No se encontró el TerritorioAdministrativo (guardarTerritorio)***");
                    throw new MareException("", UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
                }

            } catch (NoResultException e)  {
                UtilidadesLog.debug("*** Método guardarTerritorio: No hay territorio ***");
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));                
            }  catch (PersistenceException ce) {   
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
        } else {
            try {
                //Incidencia 18848. Si no encuentra la uniAdm en el hashMap, hace un create en el entity Territorio con los datos recibidos
                UtilidadesLog.debug("No encontro uniAdm en el HashMap, la crea");
                TerritorioLocalHome territorioLH =  this.getTerritorioLocalHome();
                TerritorioLocal territorio = territorioLH.create(new Long(unidad.obtenerCodigoUnidad()), this.pais,
                                                                new Long(0), unidad.getOidUnidadGeografica(),
                                                                new Timestamp((new Date()).getTime()) );
                territorio.setNse1(unidad.getNse1());
                territorio.setNse2(unidad.getNse2());
                this.getTerritorioLocalHome().merge(territorio);

                unidad.setOidTerritorio(territorio.getOid());                
                unidad.setOid(unidad.getOidTerritorio());
                this.UnidadesCreadas.put(unidad.obtenerCodigoCompleto(), unidad.getOidTerritorio());
            } catch (PersistenceException e) {
                UtilidadesLog.error(e);
                ctx.setRollbackOnly();
                String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
                throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));		
            }
            try {
                // Asocia el territorio a la sección 
                // Hace un create en el entity TerritorioAdministrativo
                // Incidencia BELC300018848
                TerritorioAdministrativoLocal territorioAdministrativoLocal = this.getTerritorioAdministrativoLocalHome().create(this.pais, this.marca, this.canal, unidad.getOidPadre(), unidad.getOid(), this.periodo, new Long(0));
                territorioAdministrativoLocal.setFechaReterri(new Timestamp(System.currentTimeMillis()));
                this.getTerritorioAdministrativoLocalHome().merge(territorioAdministrativoLocal);
                UtilidadesLog.debug("territorioAdministrativoLocal.getOid(): " + territorioAdministrativoLocal.getOid());
                unidad.setOidTerritorioAdm(territorioAdministrativoLocal.getOid());
            } catch (PersistenceException e) {
                UtilidadesLog.error(e);
                ctx.setRollbackOnly();
                String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
                throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));		
            }
            
        }
        // Guarda los clientes asignados
        int n = unidad.getClientes().size();
        if (unidad.getClientes() != null)
        for (int i = 0; i < n; i++) {
            this.guardarCliente(unidad.getOidTerritorioAdm(),(Long)unidad.getClientes().get(i));
        }

        UtilidadesLog.info("MONReterritorializacionBean.guardarTerritorio (UnidadAdministrativa unidad): Salida");
    }
    
    private void actualizarCliente (Long oidCliente, Long oidTerritorioAdm) throws MareException {
        UtilidadesLog.info("MONReterritorializacionBean.actualizarCliente (Long oidCliente, Long oidTerritorioAdm): Entrada");
        // Actualiza el periodo fin del cliente asociado al territorio recibido
        
        // Obtiene la relación entre el cliente y el territorio recibido 
        // Se pueden obtener varios ya que un cliente puede estar asignado a la unidad administrativa en varios Periodos 
        Collection clientesUA = null;
        
        UtilidadesLog.debug("oidCliente: " + oidCliente);
        UtilidadesLog.debug("oidTerritorioAdm: " + oidTerritorioAdm);
        try {
            clientesUA = this.getClienteUnidadAdministrativaLocalHome().findUAActiva(oidCliente, oidTerritorioAdm);
        } catch (NoResultException e)  {
            UtilidadesLog.debug("*** Método actualizarCliente: No hay clientes ***");
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        
        // Actualiza los datos del cliente 
        ClienteUnidadAdministrativaLocal clienteLocal = null;
        if (!clientesUA.isEmpty()) { 
            Object [] clientesUAArray = clientesUA.toArray();
            int n = clientesUAArray.length;
            for (int i = 0; i < n; i++) {
                clienteLocal = (ClienteUnidadAdministrativaLocal) clientesUAArray[i];
                UtilidadesLog.debug("ClienteUnidadAdministrativaLocal: " + clienteLocal.getOid());
                UtilidadesLog.debug("this.periodo: " + this.periodo);
                
                //clienteLocal = clienteLocal.findByPrimaryKey(clienteUA.oid); 
                clienteLocal.setPerd_oid_peri_fin(this.periodo);
                clienteLocal.setInd_acti(new Long(0));
                this.getClienteUnidadAdministrativaLocalHome().merge(clienteLocal);
            }
        }
        UtilidadesLog.info("MONReterritorializacionBean.actualizarCliente (Long oidCliente, Long oidTerritorioAdm): Salida");
    }
    
    private void guardarCliente (Long territorio, Long cliente) throws MareException {
        UtilidadesLog.info("MONReterritorializacionBean.guardarCliente (Long territorio, Long cliente): Entrada");
        try {
            ClienteUnidadAdministrativaLocal clienteLocal = (this.getClienteUnidadAdministrativaLocalHome()).create(cliente,this.periodo, null ,territorio, new Long(1));
        } catch (PersistenceException e) {
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            throw new MareException(FileInterfaceMensajes.M00054);		
        }
        UtilidadesLog.info("MONReterritorializacionBean.guardarCliente (Long territorio, Long cliente): Salida");
    }

    private void actualizarDireccionCliente (Long oidCliente, Long oidTerritorioAntiguo, Long oidTerritorioNuevo) throws MareException {
        UtilidadesLog.info("MONReterritorializacionBean.actualizarDireccionCliente (Long oidCliente, Long oidTerritorioAntiguo, Long oidTerritorioNuevo): Entrada");
        // Actualiza la dirección del cliente
        // BELC300018806
        // BELC300018852
        DAOReestructuracion dao = new DAOReestructuracion();
        RecordSet clientes = dao.obtenerClienteDireccion(oidCliente, oidTerritorioAntiguo);
        if(clientes != null){
            if(!clientes.esVacio()){
                int n=clientes.getRowCount();
                for(int i=0;i<n;i++){
                    Long oidClienteDireccion = (new Long(((BigDecimal)clientes.getValueAt(i,"OIDCLIENTE")).longValue()));
                    try{
                        ClienteDireccionLocal clienteDireccion = this.getClienteDireccionLocalHome().findByPrimaryKey(oidClienteDireccion);
                        clienteDireccion.setTerr_oid_terr(oidTerritorioNuevo);
                        this.getClienteDireccionLocalHome().merge(clienteDireccion);
                    } catch (NoResultException e)  {
                        UtilidadesLog.debug("*** Método actualizarDireccionCliente: No hay clientes ***");
                        throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
                    }  catch (PersistenceException ce) {   
                        UtilidadesLog.error("ERROR ", ce);
                        throw new MareException(ce, 
                        UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                    }
                }
            }
        }
        
        UtilidadesLog.info("MONReterritorializacionBean.actualizarDireccionCliente (Long oidCliente, Long oidTerritorioAntiguo, Long oidTerritorioNuevo): Salida");
    }

  /**
   * 30/05/2007 (Sapaza), modificado por incidencia SiCC-20070276, Se modifica la logica para actualizar unidades
   *            administrativas, se hace calculo de periodo inicio en base a si regionDestino esta Cerrado y
   *            Si la consultora realizo pedido en los periodos vigentes. Ademas se actualiza el status del cliente
   *            a su estatus anterior siempre y cuando no haya hecho pedidos y la region origen este cerrado
   * @throws es.indra.mare.common.exception.MareException
   * @param registro
   */
    private void trasvase (DTORezonificacionRegistro registro) throws MareException {
        UtilidadesLog.info("MONReterritorializacionBean.trasvase (DTORezonificacionRegistro registro): Entrada");
        // Realiza el trasvase de una unidad a otra 
        
        // Obtiene la UA correspondiente al dato origen 1 del registro 
        ClienteDatosBasicosLocal clienteDatosBasicosLocal =null;
        try {
            clienteDatosBasicosLocal = this.getClienteDatosBasicosLocalHome().findByCodigoYPais(this.pais,registro.getCodCliente());
        } catch (NoResultException fex) {
            UtilidadesLog.debug("Cliente Datos Basicos no existe");
           // throw new MareException(fex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            throw new MareException(FileInterfaceMensajes.M00053);
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        
        DatoRegistro datoRegistro1 = null;
        UnidadAdministrativa unidadAdministrativa1 = null;
        Long regionOrigen = null; 
        
        try{
         datoRegistro1 = new DatoRegistro(registro.getDatoOrigen1(), registro.getNse1(), registro.getNse2());
         unidadAdministrativa1 = this.obtenerTerritorio(datoRegistro1);
         regionOrigen = this.region; 
        } catch(MareException mex){
          String mensaje = FileInterfaceMensajes.M00049 + "1" +":"+mex.getMessage();
          throw new MareException(mensaje);
        }
        
        // Obtiene la UA correspondiente al dato origen 2 del registro 
        DatoRegistro datoRegistro2 = null;
        UnidadAdministrativa unidadAdministrativa2 = null;
        Long regionDestino = null; 
        
        try{
         datoRegistro2 = new DatoRegistro(registro.getDatoOrigen2(), registro.getNse1(), registro.getNse2());
         unidadAdministrativa2 = this.obtenerTerritorio(datoRegistro2); 
         regionDestino = this.region; 
        } catch(MareException mex){
          String mensaje = FileInterfaceMensajes.M00049 + "2" +":"+mex.getMessage();
          throw new MareException(mensaje);
        }
        
        //Obtiene los periodos Inicio y Fin para la actualizacion de las Unidades Administrativas del Cliente
        try{
            this.obtenerPeriodosUnidadesAdministrativas(clienteDatosBasicosLocal.getOid(), regionOrigen, regionDestino);
        } catch(MareException mex){
            String mensaje = FileInterfaceMensajes.M00055;
            throw new MareException(mensaje);
        }
        
        try{
            //Actualiza las Unidades Administrativas del Cliente
            this.actualizarUnidadesAdministrativas(clienteDatosBasicosLocal.getOid(), unidadAdministrativa1.getOidTerritorioAdm(), 
                                                  unidadAdministrativa2.getOidTerritorioAdm());
            //Actualiza Status en DatosAdicionales del Cliente
            this.actualizaStatusCliente(clienteDatosBasicosLocal.getOid(), regionOrigen, regionDestino);
        } catch(MareException mex){
            UtilidadesLog.error(mex);
            ctx.setRollbackOnly();
            throw new MareException(mex.getMessage());
        }
        
        // Actualiza la dirección del cliente 
        try{
            this.actualizarDireccionCliente(clienteDatosBasicosLocal.getOid(), unidadAdministrativa1.getOid(), unidadAdministrativa2.getOid());
        } catch(MareException mex){
            String mensaje = FileInterfaceMensajes.M00058 + ":" + mex.getMessage();
            ctx.setRollbackOnly();
            throw new MareException(mensaje);
        }

        UtilidadesLog.info("MONReterritorializacionBean.trasvase (DTORezonificacionRegistro registro): Salida");
    }
    
    private void generarHistorico (DTORezonificacionRegistro registro) throws MareException {
        UtilidadesLog.info("MONReterritorializacionBean.generarHistorico (DTORezonificacionRegistro registro): Entrada");
        // Genera el histórico de la operación recibida en el registro
        // 18810
        try{
            HistoricoZonasLocal historicoZonasLocal = this.getHistoricoZonasLocalHome().create(registro.getTipoOp(), registro.getDatoOrigen1(), registro.getDatoOrigen2(),new Timestamp((new Date()).getTime()), this.periodo);
            if (registro.getTipoOp().equals(ConstantesZON.TIPO_OPERACION_FUSION)){
                historicoZonasLocal.setUa3(registro.getDatoNuevo());
                this.getHistoricoZonasLocalHome().merge(historicoZonasLocal);
            }
        }catch(PersistenceException e){
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(codigoError);            
        }
        
        UtilidadesLog.info("MONReterritorializacionBean.generarHistorico (DTORezonificacionRegistro registro): Salida");
    }
    
    /**
     * Método agregado por INC 21881
     * @author dmorello
     * @date 02/01/2006
     * @throws es.indra.mare.common.exception.MareException
     * @param registro
     */
    private void generarMensaje(DTORezonificacionRegistro registro) throws MareException {
    
        UtilidadesLog.info("MONReterritorializacionBean.generarMensaje(DTORezonificacionRegistro registro): Entrada");
        UtilidadesLog.debug("DTORezonificacionRegistro recibido: " + registro);
        
        //se agrega la obtención del nombre de período de CRA
        //agrega 27/04/2006 incidencia 22937
        PeriodoLocal miPeriodo = null;
        String nombrePeriodo;
            try {
                miPeriodo = this.getPeriodoLocalHome().findByPrimaryKey(this.periodo);
                nombrePeriodo = miPeriodo.getNombrePeriodo();
            } catch (NoResultException e) {
                UtilidadesLog.debug("Periodo no existe");
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
         }  catch (PersistenceException ce) {   
             UtilidadesLog.error("ERROR ", ce);
             throw new MareException(ce, 
             UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }       
        //fin agrega
        
                
        DatoRegistro datoRegistroAnterior = new DatoRegistro(registro.getDatoOrigen1(), registro.getNse1(), registro.getNse2());
        UtilidadesLog.debug("Registro Anterior: " + " Seccion " + datoRegistroAnterior.getSeccion()+ 
                            " Region "+ datoRegistroAnterior.getRegion()+ " Territorio "+ datoRegistroAnterior.getTerritorio());
        UtilidadesLog.debug("Como this.periodo.toString(): "+this.periodo.toString());
        
        
        /* Elimina incidencia 22937 
        UnidadAdministrativa unidadAdministrativaAnterior = this.obtenerTerritorio(datoRegistroAnterior);
        String codTerritorioAnterior = datoRegistroAnterior.getTerritorio();
        fin elimina */
        
        /*
         unaZona = Zona.findByCodigo(pais, marca, canal, datoRegistroAnterior.getZona())
         nombreTerritorioAnterior = DAOZON.obtenerNombreSeccion(periodo, datoRegistroAnterior.getSeccion, unaZona.oid)
         */
         
        //Agrega 27/04/2006 incidencia 22937
        DAOZON daoZon = new DAOZON(); // USADO MAS ABAJO
        //ZonaLocal unaZona = null; // USADO MAS ABAJO
        String nombreTerritorioAnterior = null; 
        nombreTerritorioAnterior = daoZon.obtenerNombreSeccion(datoRegistroAnterior, this.pais, this.marca, this.canal);
        UtilidadesLog.debug("**** daoZon nombreTerritorioAnterior_"+nombreTerritorioAnterior);
        
        /*
        try {
            Collection colec = this.getZonaLocalHome().findByCodigo(this.pais, this.marca, this.canal, datoRegistroAnterior.getZona());
            
            UtilidadesLog.debug("Zona colec " + colec + " - " + colec.size());
            if (!colec.isEmpty() && colec.size() == 1) {
                Iterator iterator = colec.iterator();
                unaZona = (ZonaLocal) iterator.next();
            } else { 
                UtilidadesLog.debug("*** No se encontró la Zona***");
                throw new MareException("No se encontró la Zona", UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            }    
          UtilidadesLog.debug("*** obtenerNombreSeccion("+this.periodo.toString()+","+datoRegistroAnterior.getSeccion()+","+unaZona.getOid()+")");
          nombreTerritorioAnterior = daoZon.obtenerNombreSeccion(this.periodo.toString(), datoRegistroAnterior.getSeccion(), unaZona.getOid());   
        
        }catch (FinderException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
         }*/
         //fin agrega 27/04/2006
                 
        DatoRegistro datoRegistroNuevo = null;
        
        //elima 27/04/2006 incidencia 22937
        /*if (ConstantesZON.TIPO_OPERACION_FUSION.equals(registro.getTipoOp())) {
            datoRegistroNuevo = new DatoRegistro(registro.getDatoNuevo(),registro.getNse1(),
                registro.getNse2());
        } else { //fin elimina 27/04/2006 */
         datoRegistroNuevo = new DatoRegistro(registro.getDatoOrigen2(),registro.getNse1(),registro.getNse2());
         UtilidadesLog.debug("Registro Nuevo: "+" Seccion " + datoRegistroNuevo.getSeccion()+" Region "+
                              datoRegistroNuevo.getRegion()+" Territorio "+ datoRegistroNuevo.getTerritorio());
         
         
        //}        
        
        /* elimina 27/04/2006 incidencia 22937
        UnidadAdministrativa unidadAdministrativaNueva = this.obtenerTerritorio(datoRegistroNuevo);
        String codTerritorioNuevo = datoRegistroNuevo.getTerritorio();
        fin elimina 27/04/2006 */
        
        //Agrega 27/04/2006 incidencia 22937
        String nombreTerritorioNuevo = null;
        nombreTerritorioNuevo = daoZon.obtenerNombreSeccion(datoRegistroNuevo, this.pais, this.marca, this.canal);
        UtilidadesLog.debug("**** daoZon nombreTerritorioNuevo_" + nombreTerritorioNuevo);
        /*
        try {
            Collection colec = this.getZonaLocalHome().findByCodigo(this.pais, this.marca, this.canal, datoRegistroNuevo.getZona());
            //AD.
            UtilidadesLog.debug("Zona colec " + colec + " - " + colec.size());
            if (!colec.isEmpty() ) {
                Iterator iterator = colec.iterator();
                unaZona = (ZonaLocal) iterator.next();
            } else { 
                UtilidadesLog.debug("*** No se encontró la Zona***");
                throw new MareException("No se encontró la Zona", UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            }
                        
           
           nombreTerritorioNuevo = daoZon.obtenerNombreSeccion(this.periodo.toString(), datoRegistroNuevo.getSeccion(), unaZona.getOid()); 
        }catch (FinderException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
         }*/
         //fin agrega 27/04/2006
              
        //Elimina 27/04/2006 incidencia 22937
        //DAOZON daoZon = new DAOZON();
        // 21881 - dmorello, 05/04/2006: Cambio OIDs por códigos de clientes
        /*
        String codResponsableAnterior
            = daoZon.obtenerResponsableTerritorio(this.marca, this.canal, this.periodo, codTerritorioAnterior);
        String codResponsableNuevo
            = daoZon.obtenerResponsableTerritorio(this.marca, this.canal, this.periodo, codTerritorioNuevo);
        */
        //fin Elimina 27/04/2006 incidencia 22937    
        
         //AGREGA 27/04/2006 incidencia 22937 
         String nombreResponsableAnterior;
         //nombreResponsableAnterior = daoZon.obtenerResponsableTerritorio(this.marca, this.canal, this.periodo, nombreTerritorioAnterior);
          nombreResponsableAnterior = daoZon.obtenerResponsableTerritorio(this.marca, this.canal, this.periodo, datoRegistroAnterior.getTerritorio());
          UtilidadesLog.debug("**** daoZon nombreResponsableAnterior_" + nombreResponsableAnterior);
          
         String nombreResponsableNuevo;
         //nombreResponsableNuevo = daoZon.obtenerResponsableTerritorio(this.marca, this.canal, this.periodo, nombreTerritorioNuevo);        
         nombreResponsableNuevo = daoZon.obtenerResponsableTerritorio(this.marca, this.canal, this.periodo, datoRegistroNuevo.getTerritorio());        
         UtilidadesLog.debug("**** daoZon nombreResponsableNuevo_" + nombreResponsableNuevo);
         //fin AGREGA 27/04/2006 incidencia 22937
         
         //    ADD incidencia 22937 08/06/2006
          ClienteDatosBasicosLocalHome clienteHome = this.getClienteDatosBasicosLocalHome();
          ClienteDatosBasicosLocal cliente = null;
          try {
                cliente = clienteHome.findByCodigoYPais(this.pais,registro.getCodCliente());
                
                UtilidadesLog.debug("**Datos enviados a Buzon de Mensajes, cliente_"+cliente.getOid()+" respons_anter_"+nombreResponsableAnterior+
                                     " nomb_territ_ante_"+nombreTerritorioAnterior+ " nomb_territ_nuevo_" +nombreTerritorioNuevo+
                                     " nomb_resp_nuevo_"+nombreResponsableNuevo+" periodo_"+ nombrePeriodo);
                
                this.enviarABuzonDeMensajes(cliente.getOid(), nombreResponsableAnterior,nombreTerritorioAnterior, 
                                       nombreTerritorioNuevo, nombreResponsableNuevo, nombrePeriodo);          
                           
  
          } catch (NoResultException e) {
                UtilidadesLog.debug("ClienteDatosBasicos no existe");
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
          }  catch (PersistenceException ce) {   
              UtilidadesLog.error("ERROR ", ce);
              throw new MareException(ce, 
              UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
          }
          //FIN ADD incidencia 22937 08/06/2006         
        
        UtilidadesLog.info("MONReterritorializacionBean.generarMensaje(DTORezonificacionRegistro registro): Salida");
    }

    /**
     * Método agregado por INC 21881
     * Se modifica por la misma incidencia (dmorello, 05/04/2006)
     * Recibe codigos de territorios y responsables en lugar de OIDs
     * 
     * @author dmorello
     * @date 02/01/2006
     * @throws es.indra.mare.common.exception.MareException
     * @param codResponsableNuevo
     * @param codTerritorioNuevo
     * @param codTerritorioAnterior
     * @param codResponsableAnterior
     * @param oidCliente
     */
    private void enviarABuzonDeMensajes(Long oidCliente, String codResponsableAnterior,
            String codTerritorioAnterior, String codTerritorioNuevo, String codResponsableNuevo, String nomPeriodo)
            throws MareException {
            
        UtilidadesLog.info("MONReterritorializacionBean.enviarABuzonDeMensajes(Long oidCliente, Long oidResponsableAnterior, long oidUnidadAdministrativaAnterior, Long oidUnidadAdministrativaNueva, Long oidResponsableNuevo): Entrada");
        
        // Creo el DTOBuzonMensajes y le asigno valores
        DTOBuzonMensajes dtoB = new DTOBuzonMensajes();
        dtoB.setOidPais(this.pais);
        dtoB.setCodigoMensaje("ZON03");
        dtoB.setOidCliente(oidCliente);
        dtoB.setModuloOrigen(new Long(ConstantesSEG.MODULO_ZON));
        dtoB.setDatoVariable1(this.tipoPeriodo);
        
        //dtoB.setDatoVariable2(this.periodo.toString());
        dtoB.setDatoVariable2(nomPeriodo);// 27/04/2006 incidencia 22937
        /*
         * INC 21881 - dmorello, 09/01/2006
         * Si oidResponsableAnterior es nulo, se agrega un espacio en blanco
         */
        dtoB.setDatoVariable3(codResponsableAnterior != null?
                              codResponsableAnterior : " ");
        dtoB.setDatoVariable4(codTerritorioAnterior);
        dtoB.setDatoVariable5(codTerritorioNuevo);
        /*
         * INC 21881 - dmorello, 09/01/2006
         * Si oidResponsableNuevo es nulo, se agrega un espacio en blanco
         */
        dtoB.setDatoVariable6(codResponsableNuevo!=null?
                              codResponsableNuevo: " ");
        
        // Llamo al CU Insertar en Buzón de Mensajes
        MONGestionMensajesHome monGestionMensajesHome = this.getMONGestionMensajesHome();
        MONGestionMensajes monGestionMensajes = null;
        try {
            monGestionMensajes = monGestionMensajesHome.create();
            monGestionMensajes.insertaDatosMensaje(dtoB);
        } catch (CreateException e) {
            UtilidadesLog.error("*** Error en enviarABuzonDeMensajes: ",e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));	            
        } catch (RemoteException e) {
            UtilidadesLog.error("*** Error en enviarABuzonDeMensajes: ",e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));	
        }

        UtilidadesLog.info("MONReterritorializacionBean.enviarABuzonDeMensajes(Long oidCliente, Long oidResponsableAnterior, long oidUnidadAdministrativaAnterior, Long oidUnidadAdministrativaNueva, Long oidResponsableNuevo): Salida");
    }

    private MONReestructuracion getMONReestructuracion() throws MareException {
        // Se obtiene el interfaz home
		UtilidadesLog.info("MONReterritorializacionBean.ggetMONReestructuracion(): Entrada");
        MONReestructuracionHome home = (MONReestructuracionHome)UtilidadesEJB.getHome("MONReestructuracion", MONReestructuracionHome.class);
            
        // Se obtiene el interfaz remoto
        MONReestructuracion ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
		UtilidadesLog.info("MONReterritorializacionBean.getMONReestructuracion()): Salida");
        return ejb;
	}


    private BusinessFacadeLocalHome getBusinessFacadeLocalHome() throws NamingException
    {
        final InitialContext context = new InitialContext();
        return (BusinessFacadeLocalHome)context.lookup("java:comp/env/BusinessFacadeBATCH");
    }
    


    private MONPeriodos getMONPeriodos() throws MareException {
        // Se obtiene el interfaz home
		UtilidadesLog.info("MONReterritorializacionBean.getMONPeriodos(): Entrada");
        MONPeriodosHome home = (MONPeriodosHome)UtilidadesEJB.getHome("MONPeriodos", MONPeriodosHome.class);
            
        // Se obtiene el interfaz remoto
        MONPeriodos ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
		UtilidadesLog.info("MONReterritorializacionBean.getMONPeriodos(): Salida");   
        return ejb;
	}
    
    private MONGestionMensajesHome getMONGestionMensajesHome() throws MareException {
		UtilidadesLog.info("MONReterritorializacionBean.getMONGestionMensajes(): Entrada");
        MONGestionMensajesHome monGestionMensajesHome = (MONGestionMensajesHome) UtilidadesEJB.getHome("MONGestionMensajes",MONGestionMensajesHome.class);
        UtilidadesLog.info("MONReterritorializacionBean.getMONGestionMensajesHome(): Salida");
        return monGestionMensajesHome;
    }
    
    private SubGerenciaVentaLocal obtenerSubgerencia(String codSubgerencia) throws MareException {
        try {
                UtilidadesLog.debug("obtenerSubgerencia");
                UtilidadesLog.debug("this.marca: " + this.marca);
                UtilidadesLog.debug("this.pais: " + this.pais);
                UtilidadesLog.debug("this.canal: " + this.canal);
                UtilidadesLog.debug("codSubgerencia: " + codSubgerencia);               
                
                
                Collection colecSgv = (this.getSubGerenciaVentaLocalHome()).findByCodigo(this.marca, this.pais, this.canal, codSubgerencia); 
                SubGerenciaVentaLocal subgerenciaVentaLocal = null;
                int cantSgv = colecSgv.size();
                if (cantSgv == 1) {
                    Iterator iterator = colecSgv.iterator();
                    subgerenciaVentaLocal = (SubGerenciaVentaLocal) iterator.next();
                    Long oidSGV = subgerenciaVentaLocal.getOidSubgVenta();
                    UtilidadesLog.debug("*** SGV - El oidSGV es_" + oidSGV);
                    return subgerenciaVentaLocal;
                } else {
                    UtilidadesLog.debug("*** SGV - Se encontraron_" + cantSgv + " Subgerencias con el codigo ingresado.");
                    throw new MareException("No se encontró la Subgerencia", UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
                }
            } catch (NoResultException e) {
                UtilidadesLog.error("*** SGV - Error en el findByCodigo al buscar la subgerencia ***");
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            }  catch (PersistenceException ce) {   
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
    }
    
    private RegionLocal obtenerRegion(String codRegion, Long oidSubgerencia) throws MareException {
        try {
                Collection colecReg = (this.getRegionLocalHome()).findByCodigo(oidSubgerencia, codRegion);
                RegionLocal regionLocal = null;
                int cantReg = colecReg.size();
                if (cantReg == 1) {
                    Iterator iterator = colecReg.iterator();
                    regionLocal = (RegionLocal) iterator.next();
                    Long oidRegion = regionLocal.getOid();
                    UtilidadesLog.debug("*** REGION - El oidRegion es_" + oidRegion);
                    return regionLocal;
                } else {
                    UtilidadesLog.debug("*** REGION - Se encontraron_" + cantReg + " Regiones con el codigo ingresado.");
                    throw new MareException("No se encontró la Region", UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
                }
            } catch (NoResultException e) {
                UtilidadesLog.error("*** REGION - Error en el findByCodigo al buscar la region ***");
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            }  catch (PersistenceException ce) {   
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
    }
    
    private ZonaLocal obtenerZona(String codZona, Long oidRegion) throws MareException {
        try {
            Collection colecZon = (this.getZonaLocalHome()).findByCodigo(oidRegion, codZona);
            ZonaLocal zonaLocal = null;
            int cantZon = colecZon.size();
            if (cantZon == 1) {
                Iterator iterator = colecZon.iterator();
                zonaLocal = (ZonaLocal) iterator.next();
                Long oidZona = zonaLocal.getOid();
                UtilidadesLog.debug("*** ZONA - El oidZona es_" + oidZona);
                return zonaLocal;
            } else { 
                UtilidadesLog.debug("*** ZONA - Se encontraron_" + cantZon + " Zonas con el codigo ingresado.");
                    throw new MareException("No se encontró la Zona", UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            }
        } catch (NoResultException e) {
            UtilidadesLog.error("*** ZONA - Error en el findByCodigo al buscar la zona ***");
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
    }
    
    private SeccionLocal obtenerSeccion(String codSeccion, Long oidZona) throws MareException {
        try {
                Collection colecSecc = (this.getSeccionLocalHome()).findByCodigo(this.pais, this.marca, this.canal, oidZona, codSeccion);
                SeccionLocal seccionLocal = null;
                int cantSecc = colecSecc.size();
                if (cantSecc == 1) {
                    Iterator iterator = colecSecc.iterator();
                    seccionLocal = (SeccionLocal) iterator.next();
                    Long oidSeccion = seccionLocal.getOid();
                    UtilidadesLog.debug("*** SECCION - El oidSeccion es_" + oidSeccion);
                    return seccionLocal;
                } else { 
                    UtilidadesLog.debug("*** SECCION - Se encontraron_" + cantSecc + " Secciones con el codigo ingresado.");
                    throw new MareException("No se encontró la seccion", UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
                }
            } catch (NoResultException e) {
                UtilidadesLog.error("*** SECCION - Error en el findByCodigo al buscar la seccion ***");
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            }  catch (PersistenceException ce) {   
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }

    }

  /**
   * 31/05/2007 (Sapaza), agregado por incidencia SiCC-20070276, se actualiza la unidad administrativa actual
   *            con periodoFin = this.PeriodoFin calculado, y se crea la nueva unidad administrativa con
   *            periodoInicio = this.PeriodoInicio calculado
   * @throws es.indra.mare.common.exception.MareException
   * @param unidadAdministrativa2
   * @param unidadAdministrativa1
   * @param cliente
   */
    private void actualizarUnidadesAdministrativas(Long cliente, Long unidadAdministrativa1, Long unidadAdministrativa2) throws MareException {
        UtilidadesLog.info("MONReterritorializacionBean.actualizarUnidadesAdministrativas (Long cliente, Long unidadAdministrativa1, Long unidadAdministrativa2): Entrada");

        ClienteUnidadAdministrativaLocal clienteLocal = null;
        Long indActivoUANuevo;
        Long indActivoUAAnterior;
        boolean crearUnidadAdmin = true;
        
        //Verificamos si el periodo esta cerrado
        if (cierrePeriodos.get(this.periodoFin.toString()).toString().equalsIgnoreCase("1")) {
            indActivoUANuevo = new Long(1);
            indActivoUAAnterior = new Long(0);
        } else {
            indActivoUANuevo = new Long(0);
            indActivoUAAnterior = new Long(1);
        }

        //Caso 2.- Quiere decir que ya se efectuo el cambio de unidad administrativa, porque
        //el ultimo registro esta activo, y el periodoInicio = this.periodoInicio, en ese caso
        //solo se actualiza este registro
        try {
            Collection unidadAdministrativaCollection = (this.getClienteUnidadAdministrativaLocalHome()).findUAActivaByCliente(cliente);
            Iterator itadm = unidadAdministrativaCollection.iterator();
           
            if (itadm.hasNext()){        
                clienteLocal = (ClienteUnidadAdministrativaLocal) itadm.next();
                
                if(clienteLocal.getPerd_oid_peri_ini().longValue() == this.periodoInicio.longValue()) {
                    UtilidadesLog.info("actualizarUnidadesAdministrativas: CASO 2");                
                    clienteLocal.setZtad_oid_terr_admi(unidadAdministrativa2);
                    clienteLocal.setPerd_oid_peri_fin(null);
                    this.getClienteUnidadAdministrativaLocalHome().merge(clienteLocal);
                    crearUnidadAdmin = false;
                }
            }
        } catch (NoResultException e) {
            UtilidadesLog.error(e);
            throw new MareException(FileInterfaceMensajes.M00060);		
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        if(crearUnidadAdmin) {
            //Caso 3.- Quiere decir que ya se efectuo el cambio de unidad administrativa, pero
            //todavia no se da de alta la ultima unidad administrativa del Cliente, se actualiza
            //dicho registro y el registro anterior a el (la activa) se actualiza
            if(clienteLocal.getPerd_oid_peri_fin()!=null) {
                UtilidadesLog.info("actualizarUnidadesAdministrativas: CASO 3");
                
                //a.- Actualizar Registro Ultima en MAE Unidad Administrativa
                try {
                    Collection unidadAdministrativaCollection = (this.getClienteUnidadAdministrativaLocalHome()).findUAUltima(cliente); 
                    Iterator itadm = unidadAdministrativaCollection.iterator();
                   
                    if (itadm.hasNext()){        
                        ClienteUnidadAdministrativaLocal clienteLocal2 = (ClienteUnidadAdministrativaLocal) itadm.next();
                        clienteLocal2.setZtad_oid_terr_admi(unidadAdministrativa2);
                        clienteLocal2.setPerd_oid_peri_ini(this.periodoInicio);
                        clienteLocal2.setPerd_oid_peri_fin(null);
                        clienteLocal2.setInd_acti(indActivoUANuevo);
                        this.getClienteUnidadAdministrativaLocalHome().merge(clienteLocal2);
                    }
                } catch (NoResultException e) {
                    UtilidadesLog.error(e);
                    throw new MareException(FileInterfaceMensajes.M00061);		
                }  catch (PersistenceException ce) {   
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }
                
                //b.- Actualizar Registro Anterior en MAE Unidad Administrativa
                clienteLocal.setPerd_oid_peri_fin(this.periodoFin);
                clienteLocal.setInd_acti(indActivoUAAnterior);
                this.getClienteUnidadAdministrativaLocalHome().merge(clienteLocal);
            } else {
                UtilidadesLog.info("actualizarUnidadesAdministrativas: CASO 1");
                
                //Caso 1.- Se actualiza el registro activo (se da de baja, si ha cerrado el periodoFin), 
                //y se crea la nueva unidad administrativa (se da de alta, si ha cerrado la periodoFin)
            
                //a.- Insertar Nuevo Registro en MAE Unidad Administrativa
                try {
                    ClienteUnidadAdministrativaLocal clienteLocal2 = (this.getClienteUnidadAdministrativaLocalHome()).create(cliente,this.periodoInicio, null ,
                                                                      unidadAdministrativa2, indActivoUANuevo);
                } catch (PersistenceException e) {
                    UtilidadesLog.error(e);
                    throw new MareException(FileInterfaceMensajes.M00030);		
                }

                //b.- Actualizar Registro Anterior en MAE Unidad Administrativa
                clienteLocal.setPerd_oid_peri_fin(this.periodoFin);
                clienteLocal.setInd_acti(indActivoUAAnterior);
                this.getClienteUnidadAdministrativaLocalHome().merge(clienteLocal);
            }
            
        }
        
        UtilidadesLog.info("MONReterritorializacionBean.actualizarUnidadesAdministrativas (Long cliente, Long unidadAdministrativa1, Long unidadAdministrativa2): Salida");
    }
    
  /**
   * 31/05/2007 (Sapaza), agrgado por incidencia SiCC-20070276, se calcula los periodos Inicio y Fin en base
   *            a la cantidad de pedidos que la consultora realiza y si ha cerrado la region origen 
   *            y destino en los periodos vigentes
   * @throws es.indra.mare.common.exception.MareException
   * @param regionDestino
   * @param regionOrigen
   * @param cliente
   */
    private void obtenerPeriodosUnidadesAdministrativas(Long cliente, Long regionOrigen, Long regionDestino) throws MareException {
        UtilidadesLog.info("MONReterritorializacionBean.obtenerPeriodosUnidadesAdministrativas (Long cliente, Long regionOrigen, Long regionDestino): Entrada");    
        DAOReestructuracion daoReestructuracion = new DAOReestructuracion();
        DAOCRA daoCRA = new DAOCRA();
        
        UtilidadesLog.debug("cliente: " + cliente);
        UtilidadesLog.debug("regionOrigen: " + regionOrigen);
        UtilidadesLog.debug("regionDestino: " + regionDestino);
        
        //Obtenemos los periodos vigentes y obtenemos las regiones cerrados para los periodos recuperados
        if(periodos.size() ==0 ) {
            cargarPeriodosVigentes();
        }
        
        //Verificamos si region destino ha cerrado
        boolean cerradoRegionesDestino = true;
        for(int i=0; i< periodos.size(); i++) {
            String periodo = periodos.get(i).toString();
            boolean cerrado = validarCierreRegion(regionDestino, periodo);
            
            if(!cerrado) {
                cerradoRegionesDestino = false;
                break;
            }
        }
        
        //Verificamos si paso pedidos en periodos vigentes
        boolean pasoPedidos = daoReestructuracion.validarPedidosConsultora(cliente, periodos.toString().replace('[','(').replace(']',')'));
        
        if(!pasoPedidos && !cerradoRegionesDestino) {
            UtilidadesLog.debug("No Paso Pedidos");
            //Menor de los periodos vigentes
            periodoInicio = (Long) periodos.get(0);
        }
        else {
            UtilidadesLog.debug("Paso Pedidossssss");
            //PeriodoInicio = El mayor entre (Periodo Siguiente al ultimo periodo en que consultora paso pedido)
            //y (PeriodoSiguiente al ultimo periodo de cierre de region destino)
            RecordSet resultado1 = daoReestructuracion.obtenerPeriodoSiguientePasoPedidoCliente(cliente, this.pais, this.marca, this.canal);
            RecordSet resultado2 = daoReestructuracion.obtenerPeriodoSiguienteUltimoCierreRegion(this.pais, this.marca, this.canal, regionDestino, this.oidTipoCierreRegion);
            
            if(resultado1 != null && !resultado1.esVacio() && resultado2!= null && !resultado2.esVacio()) {
                Long fechaIniPeriSiguiente1 = new Long((String)resultado1.getValueAt(0, 1));
                Long fechaIniPeriSiguiente2 = new Long((String)resultado2.getValueAt(0, 1));
            
                UtilidadesLog.debug("PeriodoSiguientePasoPedidoCliente :" + resultado1.getValueAt(0, 0));
                UtilidadesLog.debug("PeriodoSiguienteUltimoCierreRegionDestino :" + resultado2.getValueAt(0, 0));
            
                if(fechaIniPeriSiguiente1.longValue() > fechaIniPeriSiguiente2.longValue()) {
                    this.periodoInicio = new Long(((BigDecimal)resultado1.getValueAt(0, 0)).longValue());
                } else {
                    this.periodoInicio = new Long(((BigDecimal)resultado2.getValueAt(0, 0)).longValue());
                }
            }else if (resultado1 != null && !resultado1.esVacio()) {
                this.periodoInicio = new Long(((BigDecimal)resultado1.getValueAt(0, 0)).longValue());
                UtilidadesLog.debug("PeriodoSiguientePasoPedidoCliente :" + resultado1.getValueAt(0, 0));
            }else if (resultado2 != null && !resultado2.esVacio()) {
                this.periodoInicio = new Long(((BigDecimal)resultado2.getValueAt(0, 0)).longValue());
                UtilidadesLog.debug("PeriodoSiguienteUltimoCierreRegionDestino :" + resultado2.getValueAt(0, 0));
            }
        }

        //Periodo Anterior al periodo Inicio
        this.periodoFin = daoCRA.obtienePeriodoAnterior(this.periodoInicio);
        
        //se guarda el estado de cierre de periodoFin
        validarCierrePeriodo(this.periodoFin);
        
        UtilidadesLog.debug("PeriodoInicio: " + this.periodoInicio);
        UtilidadesLog.debug("PeriodoFin: " + this.periodoFin);
        
        UtilidadesLog.info("MONReterritorializacionBean.obtenerPeriodosUnidadesAdministrativas (Long cliente, Long regionOrigen, Long regionDestino): Salida");            
    }

    private void cargarPeriodosVigentes() throws MareException {
        DAOFACCierreFacturacion daoFACCierre = new DAOFACCierreFacturacion();
        DAOCRA daoCRA = new DAOCRA();
    
        DTOPeriodo dto = new DTOPeriodo();
        dto.setPais(this.pais);
        dto.setCanal(this.canal);
        dto.setMarca(this.marca);
        dto.setFechaInicio(this.fechaActual);
        RecordSet respuesta = daoCRA.obtienePeriodosFecha(dto).getResultado();
        
        //cargamos los tipos de cierre de facturacion
        cargarTiposCierreFacturacion();
        
        for(int i=0; i<respuesta.getRowCount(); i++) {
            Long periodoVigente = new Long(((BigDecimal)respuesta.getValueAt(i, 0)).longValue());
            this.periodos.add(periodoVigente);
            
            DTOFACCierreFacturacion dtoe = new DTOFACCierreFacturacion();
            dtoe.setOidPais(this.pais);
            dtoe.setCanal(this.canal);
            dtoe.setMarca(this.marca);
            dtoe.setTipoCierre(oidTipoCierreRegion);
            dtoe.setCodigoTipoCierre(ConstantesFAC.TIPO_CIERRE_REGION);
            dtoe.setPeriodo(periodoVigente);
        
            ArrayList regionesCerrados = daoFACCierre.obtenerControlCierreRegionPorPeriodo(dtoe);
            this.cierreRegiones.put(periodoVigente.toString(), regionesCerrados);
        }
    }

    private void cargarTiposCierreFacturacion() throws MareException {
        UtilidadesLog.info("MONReterritorializacionBean.cargarTiposCierreFacturacion(): Entrada");

        UtilidadesLog.debug("INICIO");        
        
        TiposCierreLocalHome tiposCierreLH = this.getTiposCierreLocalHome();
        TiposCierreLocal tiposCierreL = null;
        Collection colTiposCierre = null;
        UtilidadesLog.debug("FIN");        
        
        try {
            colTiposCierre = tiposCierreLH.findAll();
        } catch(NoResultException fe) {
            throw new MareException(fe, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        Iterator iterator = colTiposCierre.iterator();
        
        while (iterator.hasNext()) {
            tiposCierreL = (TiposCierreLocal)iterator.next();
            
            if (tiposCierreL.getCodigo().equals(ConstantesFAC.TIPO_CIERRE_PERIODO)) {
                  oidTipoCierrePeriodo = tiposCierreL.getOid();
            }
            if (tiposCierreL.getCodigo().equals(ConstantesFAC.TIPO_CIERRE_REGION)) {
                  oidTipoCierreRegion = tiposCierreL.getOid();
            }
        }
        
        UtilidadesLog.info("MONReterritorializacionBean.cargarTiposCierreFacturacion(): Salida");        
    }

    private boolean validarCierreRegion(Long region, String periodoR) {
        ArrayList regionesCerrado = (ArrayList)this.cierreRegiones.get(periodoR);
        boolean cerrado = false;
        
        for(int j=0; j< regionesCerrado.size(); j++) {        
            Long regionx = (Long)regionesCerrado.get(j);
            
            if(regionx.longValue() == region.longValue()) {
                cerrado = true;
                break;
            }
        }
    
        return cerrado;
    }

    private void validarCierrePeriodo(Long periodo) throws MareException {
        DAOFACCierreFacturacion daoFACCierre = new DAOFACCierreFacturacion();
        
        if(this.cierrePeriodos.get(this.periodoFin.toString()) == null) {
            DTOFACCierreFacturacion dtoe = new DTOFACCierreFacturacion();
            dtoe.setOidPais(this.pais);
            dtoe.setCanal(this.canal);
            dtoe.setMarca(this.marca);
            dtoe.setCodigoTipoCierre(ConstantesFAC.TIPO_CIERRE_PERIODO);
            dtoe.setTipoCierre(oidTipoCierrePeriodo);            
            dtoe.setPeriodo(periodo);
            
            Integer cierreProcesos = daoFACCierre.obtenerNumeroControlCierres(dtoe);
            if(cierreProcesos.intValue()>0)
                this.cierrePeriodos.put(this.periodoFin.toString(), "1");
            else
                this.cierrePeriodos.put(this.periodoFin.toString(), "0");            
                
            UtilidadesLog.debug("Indicador Cierre Periodo (" + periodo + "): " + cierreProcesos.toString());                
        }
    }
    
  /**
   * 31/05/2007 (Sapaza), agregado por incidencia SiCC-20070276,Se encarga de volver al status anterior del 
   *            cliente, haciendo rollback de lo que se hizo en el proceso de cierre de region para la region Origen
   * @throws es.indra.mare.common.exception.MareException
   * @param regionDestino
   * @param regionOrigen
   * @param cliente
   */
    private void actualizaStatusCliente(Long cliente, Long regionOrigen, Long regionDestino) throws MareException {
        UtilidadesLog.info("MONReterritorializacionBean.actualizaStatusCliente(Long cliente, Long regionOrigen, Long regionDestino): Entrada");

        boolean indPeriodoVigente = false;
        boolean indCierreRegionOrigen = false;
        boolean indCierreRegionDestino = false;

        //Verificamos si periodoInicio es periodoVigente
        for(int i=0; i< this.periodos.size(); i++) {
            Long periodo = (Long)this.periodos.get(i);
            
            if(periodo.longValue() == this.periodoInicio.longValue()) {
                 indPeriodoVigente = true;
                 break;
            }
        }        

        UtilidadesLog.info("Indicador Periodo Vigente: " + indPeriodoVigente);
        
        //Verificamos Si Region Origen ha cerrado y Region Destino ha cerrado
        if(indPeriodoVigente) {
            indCierreRegionOrigen = validarCierreRegion(regionOrigen, this.periodoInicio.toString());
            indCierreRegionDestino = validarCierreRegion(regionDestino, this.periodoInicio.toString());
            UtilidadesLog.info("indCierreRegionOrigen("+regionOrigen+"): " + indCierreRegionOrigen);
            UtilidadesLog.info("indCierreRegionDestino("+regionDestino+"): " + indCierreRegionDestino);
        }

        if(indPeriodoVigente && indCierreRegionOrigen && !indCierreRegionDestino) {
            UtilidadesLog.debug("Se valida si se actualiza Estatus del Cliente");
            Vector vStatusCliente = new Vector();
            Long oidDatosAdi = null;
            Long estatus = null;
            Long oidHistoEstatus = null;
            Long oidHistoEstatusActual = null;
            Long numCampSinPedi;
      
            ClienteDatosAdicionalesLocalHome clienteDAdicionalesHome = this.getClienteDatosAdicionalesLocalHome();
            ClienteHistoricoEstatusLocalHome historicoEstatusHome = this.getClienteHistoricoEstatusLocalHome();        
      
            //Recuperamos el oid y Numero Campaña sin Pedidos para el cliente        
            try {
                ClienteDatosAdicionalesLocal clienteDAdicionalesL = clienteDAdicionalesHome.findByCliente(cliente);
                oidDatosAdi = clienteDAdicionalesL.getOid();
                numCampSinPedi = clienteDAdicionalesL.getNum_camp_sin_pedi();
                UtilidadesLog.debug("Numero de Campanias sin Pedido: " + numCampSinPedi);                
            } catch (NoResultException fe) {
                UtilidadesLog.debug(" No se encontro DatosAdicionales para cliente");
                throw new MareException(FileInterfaceMensajes.M00056);
            }  catch (PersistenceException ce) {   
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
      
            if(numCampSinPedi.longValue() > 0) {
                UtilidadesLog.debug("Se Evalua si se realiza rollback de Historico de Estatus");                
                
                //Recuperamos el oid y Status del penultimo Historico de Status, con periodofin = this.PeriodoFin
                try {
                    ClienteHistoricoEstatusLocal historicoEstatusL = historicoEstatusHome.findHistoricoPorPeriodoFin(cliente, this.periodoFin);
                    oidHistoEstatus = historicoEstatusL.getOid();
                    estatus = historicoEstatusL.getEsta_oid_esta_clie();
                } catch (NoResultException fe) {
                    UtilidadesLog.debug(" No se encontro Historico Status para el Cliente y Periodo Fin");
                }  catch (PersistenceException ce) {   
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }
          
                //si encuentra estatus anterior, se hace rollback de lo que se realizo 
                //en cierre de region para region Destino
                if(oidHistoEstatus != null) {
                    UtilidadesLog.debug("Se encontro Historico Anterior Status");                

                    //Recuperamos el oid y Status del penultimo Historico de Status, con periodofin = this.PeriodoFin
                    try {
                        ClienteHistoricoEstatusLocal historicoEstatusL = historicoEstatusHome.findByUK(cliente, this.periodoInicio);
                        oidHistoEstatusActual = historicoEstatusL.getOid();
                    } catch (NoResultException fe) {
                        UtilidadesLog.debug(" No se encontro Historico Actual para el Cliente y Periodo Fin");
                        throw new MareException(FileInterfaceMensajes.M00059);
                    }  catch (PersistenceException ce) {   
                        UtilidadesLog.error("ERROR ", ce);
                        throw new MareException(ce, 
                        UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                    }

                    try {                    
                        //Elimina Historico Clasificacion para el Historico Status actual
                        armarDeleteHistoClasificacion(oidHistoEstatusActual, vStatusCliente);
                    
                        //Elimina Historico Status con PeriodoInicio = this.periodoInicio
                        armarDeleteHistoEstatus(oidHistoEstatusActual, vStatusCliente);
                        
                        //Recupera Status Anterior y Actualiza Pedido Periodo Fin = Null
                        armarUpdateEstatusHistoEstatus(oidHistoEstatus, estatus, vStatusCliente);
                  
                        //Actualiza Estatus Anterior y resta 1 a Nro Periodos sin Pedido
                        numCampSinPedi = new Long (numCampSinPedi.longValue() - 1);
                        armarUpdateDatosAdicionales(oidDatosAdi, numCampSinPedi, estatus, vStatusCliente);

                        UtilidadesLog.debug("MONReterritorializacionBean.actualizaStatusCliente: Hecho");                           
                        
                        //efectuamos los cambios
                        invocarExecutor (vStatusCliente);
                    } catch (Exception e) {
                        UtilidadesLog.error("Error al actualizar Status del cliente");
                        throw new MareException(FileInterfaceMensajes.M00057);
                    }
                        
                }    
            }    
        }
        
        UtilidadesLog.info("MONReterritorializacionBean.actualizaStatusCliente(Long cliente, Long regionOrigen, Long regionDestino): Salida");        
    }

    private void armarDeleteHistoEstatus(Long oidHistoStatus, Vector vUpdate) throws MareException {
        
        StringBuffer updateDatosAdic = new StringBuffer();
        updateDatosAdic.append("DELETE FROM MAE_CLIEN_HISTO_ESTAT");
        updateDatosAdic.append(" WHERE OID_HIST_ESTA = " + oidHistoStatus + ";");
        
        vUpdate.add(updateDatosAdic);  // Acumulo los Update en este Vector que existe fuera del método
    }

    private void armarDeleteHistoClasificacion(Long oidHistoStatus, Vector vUpdate) throws MareException {
        
        StringBuffer updateDatosAdic = new StringBuffer();
        updateDatosAdic.append("DELETE FROM MAE_HISTO_CLASI");
        updateDatosAdic.append(" WHERE CLHE_OID_HIST_ESTA = " + oidHistoStatus + ";");
        
        vUpdate.add(updateDatosAdic);  // Acumulo los Update en este Vector que existe fuera del método
    }

    private void armarUpdateDatosAdicionales(Long oidDatosAdic, Long numCampSinPedi, Long estatus, Vector vUpdate) throws MareException {
        
        StringBuffer updateDatosAdic = new StringBuffer();
        updateDatosAdic.append("UPDATE MAE_CLIEN_DATOS_ADICI");
        updateDatosAdic.append(" SET NUM_CAMP_SIN_PEDI = "+ numCampSinPedi); 
        updateDatosAdic.append(" , ESTA_OID_ESTA_CLIE = " + estatus );
        updateDatosAdic.append(" WHERE OID_CLIE_DATO_ADIC = " + oidDatosAdic + ";");
        
        vUpdate.add(updateDatosAdic);  // Acumulo los Update en este Vector que existe fuera del método
    }

    private void armarUpdateEstatusHistoEstatus(Long oidHistoEstatus, Long oidEstatus, Vector vUpdate) throws MareException {
        
        StringBuffer updateHistoEstatus = new StringBuffer();
        updateHistoEstatus.append("UPDATE MAE_CLIEN_HISTO_ESTAT");
        updateHistoEstatus.append(" SET ESTA_OID_ESTA_CLIE = " + oidEstatus + ",");
        updateHistoEstatus.append(" PERD_OID_PERI_PERI_FIN = NULL ");        
        updateHistoEstatus.append(" WHERE OID_HIST_ESTA = " + oidHistoEstatus + ";");
        
        vUpdate.add(updateHistoEstatus);  // Acumulo los Update en este Vector que existe fuera del método
    }

    private void invocarExecutor (Vector vExecutor) throws MareException {
        String query = new String ();
        int cantSentencias = vExecutor.size();
        UtilidadesLog.debug("    cantidad de sentencias a ejecutar_" + cantSentencias);
        if (cantSentencias == 0) return;
                
        for (int i=0; i< cantSentencias; i++){
            query = query + ((StringBuffer) vExecutor.get(i)).toString();
        }
        try {
            UtilidadesEJB.getBelcorpService().dbService.executeProcedure("PQ_PLANI.EXECUTOR" ,query);
        } catch (Exception ex ){
            UtilidadesLog.error(ex.getMessage());
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
    }
    
    private java.sql.Date obtenerFechaActual() {
        UtilidadesLog.info("MONINTDATBean.formateaFechaHora(java.util.Date fecha): Entrada");
        java.util.Date fecha = new java.util.Date();
        java.sql.Date fechaD = new java.sql.Date(fecha.getTime());
        UtilidadesLog.info("MONINTDATBean.formateaFechaHora(java.util.Date fecha): Salida");
        return fechaD;
    }

    private HashMap obtenerValoresFichero() {
        UtilidadesLog.info("MONReterritorializacionBean.obtenerValoresFichero(): Entrada");
        
        HashMap mapValores = new HashMap();
        
        mapValores.put("pais", this.pais); 
        mapValores.put("marca", this.marca);
        mapValores.put("canal", this.canal); 
        mapValores.put("periodo", this.periodo); 
        mapValores.put("tipoPeriodo", this.tipoPeriodo); 
        mapValores.put("fechaActual", this.fechaActual); 
        
        UtilidadesLog.info("MONReterritorializacionBean.obtenerValoresFichero(): Salida");
        
        return mapValores;
    }

    private void ponerValoresFichero(HashMap mapValores) {
        UtilidadesLog.info("MONReterritorializacionBean.ponerValoresFichero(HashMap mapValores): Entrada");
        
        this.pais = (Long)mapValores.get("pais");
        this.marca = (Long)mapValores.get("marca"); 
        this.canal = (Long)mapValores.get("canal"); 
        this.periodo = (Long)mapValores.get("periodo"); 
        this.tipoPeriodo = (String)mapValores.get("tipoPeriodo"); 
        this.fechaActual = (java.sql.Date)mapValores.get("fechaActual"); 
        
        UtilidadesLog.info("MONReterritorializacionBean.ponerValoresFichero(HashMap mapValores): Entrada");
    }

    private MONReterritorializacionLocalHome getReterritorializacionLocalHome() throws MareException {
        UtilidadesLog.info("MONReterritorializacionBean.getReterritorializacionLocalHome(): Entrada");
        MONReterritorializacionLocalHome reterritorioLocalHome = (MONReterritorializacionLocalHome) UtilidadesEJB.getLocalHome("java:comp/env/MONReterritorializacion");
        UtilidadesLog.info("MONReterritorializacionBean.getReterritorializacionLocalHome(): Salida");
        return reterritorioLocalHome;
    }
 
    private void realizarOperacionTransaccion(DTORezonificacionRegistro registro) throws MareException {
        MONReterritorializacionLocal reterritorioLocal = null;

        try {
            reterritorioLocal = this.getReterritorializacionLocalHome().create();
        } catch (CreateException cex) {
            UtilidadesLog.error(cex);
            throw new MareException(cex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        reterritorioLocal.realizarOperacion(registro, obtenerValoresFichero());        
    }
    
  /**
   * 06-06-2007     agregado por Sapaza, incidencia Sicc-20070276, se actualiza las unidades administrativas
   *                de una lista de clientes, ademas se hace rollback en caso que si region Origen ha cerrado
   *                y no haya cerrado su regionDestino
   *                
   * @throws es.indra.mare.common.exception.MareException
   * @param territorioAdmDestino
   * @param territorioAdmOrigen
   * @param regionDestino
   * @param regionOrigen
   * @param periodoFin
   * @param periodoInicio
   * @param canal
   * @param marca
   * @param pais
   * @param clientes
   */
    public void actualizarClientesUnidadesAdminyStatus(ArrayList clientes, Long pais, Long marca, Long canal,
                  Long periodoInicio, Long periodoFin, Long regionOrigen, Long regionDestino, 
                  Long territorioAdmOrigen, Long territorioAdmDestino) 
        throws MareException {
        UtilidadesLog.info("MONReterritorializacionBean.actualizarClientesUnidadesAdminyStatus(): Entrada");

        this.pais = pais;
        this.marca = marca; 
        this.canal = canal; 
        this.fechaActual = obtenerFechaActual(); 
  
        this.periodoInicio = periodoInicio;
        this.periodoFin = periodoFin;

        try {
            UtilidadesLog.info("Cargar Datos Proceso actualizarClientesUnidadesAdminyStatus");

            if(periodoInicio != null) {
                //cargamos los periodos vigentes y los cierres de regiones
                cargarPeriodosVigentes();
                validarCierrePeriodo(periodoFin);
            }
      
            for(int i=0; i<clientes.size(); i++) {
                Long cliente = (Long)clientes.get(i);
                UtilidadesLog.info("INICIO Proceso actualizarClientesUnidadesAdminyStatus, al Cliente:" + cliente);

                if(periodoInicio == null) {
                    obtenerPeriodosUnidadesAdministrativas(cliente, regionOrigen, regionDestino);                
                }
                
                //Actualiza las Unidades Administrativas del Cliente
                this.actualizarUnidadesAdministrativas(cliente, territorioAdmOrigen, territorioAdmDestino);
                
                //Actualiza Status en DatosAdicionales del Cliente
                this.actualizaStatusCliente(cliente, regionOrigen, regionDestino);
                UtilidadesLog.info("FIN Proceso actualizarClientesUnidadesAdminyStatus, al Cliente:" + cliente);
            }   
        } catch (Exception e) {
            UtilidadesLog.error("Error al actualizar Unidades Administrativas y Status del cliente");
            UtilidadesLog.error(e);            
            throw new MareException(e.getMessage());
        }
        
        UtilidadesLog.info("MONReterritorializacionBean.actualizarClientesUnidadesAdminyStatus(): Salida");        
    }

    private PaisLocalHome getPaisLocalHome() {
        return new PaisLocalHome();
    }

    private MarcaLocalHome getMarcaLocalHome() {
        return new MarcaLocalHome();
    }

    private CanalLocalHome getCanalLocalHome() {           
        return new CanalLocalHome();
    }
    
    private PeriodoCorporativoLocalHome getPeriodoCorporativoLocalHome() {
        return new PeriodoCorporativoLocalHome();
    }

    private PeriodoLocalHome getPeriodoLocalHome() {
        return new PeriodoLocalHome();
    }    

    private TerritorioLocalHome getTerritorioLocalHome()  {
        return new TerritorioLocalHome();
    }
    private SeccionLocalHome getSeccionLocalHome() {
        return new SeccionLocalHome();
    }

    private TerritorioAdministrativoLocalHome getTerritorioAdministrativoLocalHome() {
        return new TerritorioAdministrativoLocalHome();
    }
    
    private ClienteDatosBasicosLocalHome getClienteDatosBasicosLocalHome() {
        return new ClienteDatosBasicosLocalHome();
    }

    private ClienteUnidadAdministrativaLocalHome getClienteUnidadAdministrativaLocalHome() {
        return new ClienteUnidadAdministrativaLocalHome();
    }
    
    private ClienteDireccionLocalHome getClienteDireccionLocalHome() {
        return new ClienteDireccionLocalHome();
    }    
    
    private ZonaLocalHome getZonaLocalHome() {
        return new ZonaLocalHome();
    }

    private HistoricoZonasLocalHome getHistoricoZonasLocalHome() {
        return new HistoricoZonasLocalHome();
    }  
    
    private TipoPeriodoCorporativoLocalHome getTipoPeriodoCorporativoLocalHome() {
        return new TipoPeriodoCorporativoLocalHome();
    }
    
    private RegionLocalHome getRegionLocalHome() {
        return new RegionLocalHome();        
    }

    private SubGerenciaVentaLocalHome getSubGerenciaVentaLocalHome() {
        return new SubGerenciaVentaLocalHome();
    }
    
    private TiposCierreLocalHome getTiposCierreLocalHome() {
        return new TiposCierreLocalHome();
    }

    private ClienteDatosAdicionalesLocalHome getClienteDatosAdicionalesLocalHome() {
        return new ClienteDatosAdicionalesLocalHome();
    }
    
    private ClienteHistoricoEstatusLocalHome getClienteHistoricoEstatusLocalHome() {
        return new ClienteHistoricoEstatusLocalHome();
    }

    

}
