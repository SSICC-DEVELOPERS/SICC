package es.indra.sicc.logicanegocio.mav;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.dtos.ped.DTOCabeceraSolicitud;
import es.indra.sicc.logicanegocio.ped.MONGenerarSolicitudModulosExternos;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.entidades.mav.DetalleMAVLocalHome;
import es.indra.sicc.dtos.mav.DTODatosMensaje;
import es.indra.sicc.dtos.mav.DTODetalleMAV;
import es.indra.sicc.dtos.msg.DTOBuzonMensajes;
import es.indra.sicc.dtos.ped.DTOEstatusSolicitud;
import es.indra.sicc.dtos.ped.DTOPosicionSolicitud;
import es.indra.sicc.dtos.ped.DTOSolicitudValidacion;
import es.indra.sicc.entidades.mav.EnvioMAVLocal;
import es.indra.sicc.entidades.mav.EnvioMAVLocalHome;
import es.indra.sicc.entidades.mav.SolicitudEnvioMAVLocal;
import es.indra.sicc.entidades.mav.SolicitudEnvioMAVLocalHome;
import es.indra.sicc.logicanegocio.mav.DAOProcesoEnvioAgregadosSolicitud;
import es.indra.sicc.logicanegocio.mav.MONBusinessPlanning;
import es.indra.sicc.logicanegocio.mav.MONBusinessPlanningHome;
import es.indra.sicc.logicanegocio.mav.MONGenerarMensajes;
import es.indra.sicc.logicanegocio.mav.MONGenerarMensajesHome;
import es.indra.sicc.logicanegocio.mav.MONRegistroMAVHome;
import es.indra.sicc.logicanegocio.msg.MONGestionMensajes;
import es.indra.sicc.logicanegocio.msg.MONGestionMensajesHome;
import es.indra.sicc.util.RecuperadorIdiomaDefectoServidor;


import es.indra.sicc.logicanegocio.ped.ConstantesPED;
import es.indra.sicc.logicanegocio.ped.DAOSolicitud;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;

import java.math.BigDecimal;

import java.rmi.RemoteException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Vector;
import javax.ejb.CreateException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.rmi.PortableRemoteObject;
import es.indra.sicc.logicanegocio.ped.MONGenerarSolicitudModulosExternosHome;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;


public class MONProcesoEnvioAgregadosSolicitudBean implements SessionBean {
    SessionContext ctx = null;
    private UtilidadesLog log = new UtilidadesLog();
    
    public void ejbCreate() {}

    public void ejbActivate() {}

    public void ejbPassivate() {}

    public void ejbRemove() {}

    public void setSessionContext(SessionContext ctx) {
        this.ctx = ctx;
    }

    /**
     *  MONProcesoEnvioAgregadosSolicitud.validarAgregados(dto : DTOSolicitudValidacion) : DTOEstatusSolicitud
     * Entrada:
     * - dto : DTOSolicitudValidacion
     *
     * DTOSolicitudValidacion:
     * - oidSolicitud : Long
     * - oidPais : Long
     * - oidMarca : Long
     * - oidCanal : Long
     * - oidPeriodo : Long
     * - oidMoneda : Long
     * - oidTipoSolPais : Long
     * - oidCliente : Long
     * - oidSubAcceso : Long
     * - indSimulacion : Boolean
     * - indOrdenCompra : Boolean
     * - indPedGTZona : Boolean
     * - Zona : Long
     * - UBIGEO : Long
     * - oidModulo : Long
     * - proceso : DTOProceso
     * - tipoCambio : BigDecimal
     * - numDecimales : Integer
     * - oidAcceso : Long
     * - numSolicitud : String
     * - indUnionSolicitudes : Boolean
     *
     * Proceso:
     * // En primer lugar se obtienen los registros de DetalleMAV para los criterios de entrada
     * -> Tomar del dto de entrada los valores: oidCliente, oidPeriodo y ConstantesMAV.T_ESTAD_PROCESO_INICIADO para la siguiente llamada
     * -> Llamar al método "DAOProcesoEnvioAgregadosSolicitud.obtenerDetallesMAV(cliente : Long, periodo : Long, tipoEstadoProceso : Long) : RecordSet"
     * -> Crear variable llamada detallesMAV de tipo RecordSet y asignarle la respuesta a la llamada anterior
     * Para cada registro de "detallesMAV" hacer
     * -> Llamar al método MONProcesoEnvioAgregadosSolicitud.procesarLineaDetalle(dto1 : DTOSolicitudValidacion, dto2 : DTODetalleMAV)
     * Fin Para
     */
     public DTOEstatusSolicitud validarAgregados(DTOSolicitudValidacion dto)
        throws MareException {
        UtilidadesLog.info("MONProcesoEnvioAgregadosSolicitudBean.validarAgregados(DTOSolicitudValidacion dto):Entrada");
        //UtilidadesLog.debug("DTOSolicitudValidacion: " + dto); 
        
        UtilidadesLog.debug("DTOSolicitudValidacion: " + dto);

        DAOProcesoEnvioAgregadosSolicitud daoProcesoEnvioAgregadosSolicitud = new DAOProcesoEnvioAgregadosSolicitud(); 

        try { 
            RecordSet rsDetallesMAV = daoProcesoEnvioAgregadosSolicitud.obtenerDetallesMAV(dto.getOidCliente(), dto.getOidPeriodo(), 
                    new Long(ConstantesMAV.T_ESTAD_PROCESO_INICIADO)); //new Long(2) 

            UtilidadesLog.debug("rsDetallesMAV: " + rsDetallesMAV); 
            
            if(!rsDetallesMAV.esVacio()) { 
                MONBusinessPlanningLocal monBP = this.getMONBusinessPlanningLocalHome().create(); 
                DTOOID dtoOid = new DTOOID(); 
                Boolean bExisteEnvio = null;
                Long oidAnterior = null;
                for(int i = 0; i < rsDetallesMAV.getRowCount(); i++) { 
                    BigDecimal bigOid = new BigDecimal(rsDetallesMAV.getValueAt(i, 22).toString()); 
                    if (oidAnterior!=null && oidAnterior.longValue() == bigOid.longValue()){
                        continue;
                    }else{
                        oidAnterior = new Long(bigOid.longValue());
                    }
                    UtilidadesLog.debug("-- Bucle " + i + " - Procesa DetallaMAV: " + bigOid.toString()); 
                    /* Agregado por ssantana, 08/06/2006 */ 
                    bExisteEnvio = this.chequeaExistenciaEnvioMAV(bigOid,  dto.getOidCliente());
                    /* Fin Agregado por ssantana, 08/06/2006 */ 
                    if ( !bExisteEnvio.booleanValue()) {
                       /* Arma el DTOOid con el oid del DetalleMAV a procesar */
                       Long oidDetalleMAV = new Long( bigOid.longValue() ); 
                       dtoOid.setOid(oidDetalleMAV); 
                       dtoOid.setOidIdioma( dto.getOidIdioma() );
                       dtoOid.setOidPais( dto.getOidPais() ); 
                       
                       /* Obtiene los datos del DetalleMAV */
                       DTODetalleMAV dtoDetalleMAV = monBP.obtieneDetalleMAV(dtoOid); 
    
                       /* Ahora SI invoca a procesarLineaDetalle con el DetalleMAV completo */
                       this.procesarLineaDetalle(dto, dtoDetalleMAV);
                    }
                }
                
            } 
            daoProcesoEnvioAgregadosSolicitud = null; 
        } catch(Exception e) { 
            UtilidadesLog.error("ERROR",e);
            ctx.setRollbackOnly();        
            if(e instanceof MareException) { 
                throw (MareException)e; 
            } else { 
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS)); 
            } 
        }
        
        
        // Agregado por ssantana, inc. BELC300018233, 22/7/2005, la llamda a aniadirAgregados()
        //  se realiza siempre. 
        //this.aniadirAgregados(dto, ultCodPosi);
        this.aniadirAgregados(dto);        
        // Fin agregado ssantana, inc. BELC300018233
        
        DTOEstatusSolicitud dtos = new DTOEstatusSolicitud();
        dtos.setEstatus(ConstantesPED.ESTADO_SOLICITUD_VALIDADO);
        UtilidadesLog.info("MONProcesoEnvioAgregadosSolicitudBean.validarAgregados(DTOSolicitudValidacion dto):Salida");
        return dtos;        
    }

    public DTOEstatusSolicitud revertirAgregados(DTOSolicitudValidacion dto)
        throws MareException {
        UtilidadesLog.info("MONProcesoEnvioAgregadosSolicitudBean.revertirAgregados(DTOSolicitudValidacion dto):Entrada");
        BelcorpService bs;
        //RecordSet resultado = new RecordSet();
        bs = UtilidadesEJB.getBelcorpService();
        //StringBuffer query = new StringBuffer();
        HashSet hshSet = new HashSet();
        Long oidEnvio = null;
        
        try {
            DAOProcesoEnvioAgregadosSolicitud dao = new DAOProcesoEnvioAgregadosSolicitud();
            RecordSet solicitudes = dao.obtenerSolicitudesEnvioMAV(dto);
            //Vector vOidEnvioTratados = new Vector(); 
            
            if ((solicitudes != null) && (!solicitudes.esVacio())) {
                int cant = solicitudes.getRowCount();
                
                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010  
                  UtilidadesLog.debug("Borrando las tuplas en MAV_SOLIC_ENVIO...");
                  
                for(int i = 0; i < cant; i++) {
                    Long solicitudEnvio = 
                            Long.valueOf(solicitudes.getValueAt(i, "OID_SOLI_ENVI").toString());
                    SolicitudEnvioMAVLocalHome semlh = 
                            new SolicitudEnvioMAVLocalHome();
                    SolicitudEnvioMAVLocal sem = 
                            semlh.findByPrimaryKey(solicitudEnvio);
                    /* Almaceno el Oid de Envio Tratado. */
                    oidEnvio = sem.getOidEnvio();
                    hshSet.add(oidEnvio);
                    /*vOidEnvioTratados.add(oidEnvio);*/
                    /* Elimino la entrada en MAV_SOLIC_ENVIO */
                    semlh.remove(sem);
                }

                /* 
                 * Ahora chequeo si algun Envio todavía tiene solicitudes asociadas 
                 * tras la eliminación de la revertida.  
                 */
                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010  
                  UtilidadesLog.debug("Chequeo si un Envio tiene Solic. Envio MAV asociada");
                  
                /*cant = vOidEnvioTratados.size();*/
                Iterator it = hshSet.iterator();
                while (it.hasNext()) {
                   oidEnvio = (Long) it.next();
                   Boolean existe = dao.existenSolicitudesEnvioMAV(oidEnvio);
                   
                   if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                
                     UtilidadesLog.debug("Envio " + oidEnvio + ", tiene Sol. Envio MAV? " 
                                        + existe.booleanValue());
                   // vbongiov -- 29/09/2006
                   if (!existe.booleanValue()) {
                        EnvioMAVLocalHome emlh = new EnvioMAVLocalHome();
                       EnvioMAVLocal em = emlh.findByPrimaryKey(oidEnvio);
                       em.setIndicadorEnvio(new Character("P".charAt(0)));
                       emlh.merge(em);
                       DTOBuzonMensajes dtobm = new DTOBuzonMensajes();
                       /*
                        * Modificado por ssantana, 06/03/2006, inc. 22717
                        */
                       if(em.getOidBuzonMensajes() != null) {
                           dtobm.setNumeroSecuencial(em.getNumeroSecuencia());
                           dtobm.setOidMensaje(em.getOidBuzonMensajes());
                           dtobm.setOidCliente(em.getOidCliente());
                           MONGestionMensajes monGestionMensajes = getMONGestionMensajesHome().create();
                           monGestionMensajes.eliminaDatosMensaje(dtobm);
                       }
                       /*
                        * Fin Modificado por ssantana, 06/03/2006, inc. 22717
                        */
                   }
                }
                
            }
            
            /*-> Tomar los valores de dto.oidSolicitud y dto.proceso.oidTipoPosicion para hacer la siguiente llamada
            -> Llamar al método "DAOSolicitud.eliminarPosicionesCuadre(oidSolicitud : Long, oidTipoPosicion : Long) : void" */
            bs = BelcorpService.getInstance();
            DAOSolicitud daoSol = new DAOSolicitud();

            if(dto.getProceso() != null)
                daoSol.eliminarPosicionesCuadre(dto.getOidSolicitud(), dto.getProceso().getOidTipoPosicion());

            /*-> Crear variable "respuesta" de tipo DTOEstatusSolicitud
            -> respuesta.estatus = ConstantesPED.ESTADO_SOLICITUD_VALIDADO
            -> Devolver respuesta*/
            DTOEstatusSolicitud respuesta = new DTOEstatusSolicitud();
            respuesta.setEstatus(ConstantesPED.ESTADO_SOLICITUD_VALIDADO);
            UtilidadesLog.info("MONProcesoEnvioAgregadosSolicitudBean.revertirAgregados(DTOSolicitudValidacion dto):Salida");
            return respuesta;
        } catch(RemoteException re) {
            ctx.setRollbackOnly();
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch(NamingException re) {
            ctx.setRollbackOnly();
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch(NoResultException re) {
            ctx.setRollbackOnly();
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch(CreateException re) {
            ctx.setRollbackOnly();
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }  catch(PersistenceException re) {
            ctx.setRollbackOnly();
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }        

    }

    /**
     * MONProcesoEnvioAgregadosSolicitud.procesarLineaDetalle(dto1 : DTOSolicitudValidacion, dto2 : DTODetalleMAV) : void
     * Entrada:
     * - dto1 : DTOSolicitudValidacion
     * - dto2 : DTODetalleMAV
     * Proceso:
     * -> Llamar al método "MONProcesoEnvioAgregadosSolicitud.validarSolicitudPorDetalleMAV(dto1 : DTOSolicitudValidacion, dto2 : DTODetalleMAV) : Boolean"
     * Si la respuesta al método anterior es "true" entonces
     * -> Llamar al método "MONProcesoEnvioAgregadosSolicitud.generarEnvio(dto1 : DTOSolicitudValidacion, dto2 : DTODetalleMAV) : void"
     * Fin Si
     * -> Llamar al método "MONProcesoEnvioAgregadosSolicitud.añadirAgregados(dto1 : DTOSolicitudValidacion, dto2 : DTODetalleMAV) : void"
     */
    private void procesarLineaDetalle(DTOSolicitudValidacion dto1, DTODetalleMAV dto2)
        throws MareException {
        UtilidadesLog.info("MONProcesoEnvioAgregadosSolicitudBean.procesarLineaDetalle(DTOSolicitudValidacion dto1, DTODetalleMAV dto2):Entrada");
        try {
            if(this.validarSolicitudPorDetalleMAV(dto1, dto2).booleanValue()) {
                
                // Agregado por ssantana, por inc. 18065, 2/8/2005
                //MONRegistroMAVHome monRegistroMAVH = this.getMONRegistroMAVHome();
                //MONRegistroMAV monRegistroMAV = monRegistroMAVH.create();
                MONRegistroMAVLocal monRegistroMAV = this.getMONRegistroMAVLocalHome().create();
                
                if ( dto2.getOidIdioma() == null)  {
                   RecuperadorIdiomaDefectoServidor recuperadorIdioma = new RecuperadorIdiomaDefectoServidor();
                   Long idiomaPorDefecto = recuperadorIdioma.getIdiomaDefectoServidor();
                   dto2.setOidIdioma(idiomaPorDefecto);
                }
                
                DTODetalleMAV dtoDetalleMAV =  monRegistroMAV.comprobarCodigoVenta(dto2, dto1.getOidPeriodo());
                UtilidadesLog.debug("DTODetalleMAV luego de Matriz Facturacion: " + dtoDetalleMAV);
                // Fin agregado ssantana, por inc. 18065, 2/8/2005
                
                this.generarEnvio(dto1, dtoDetalleMAV);
            }

            // By ssantana, inc. BELC300018233, se elimina llamada a "aniadirAgregados()"
            // de este método. 
            //this.aniadirAgregados(dto1, numSolicitud);
            // Fin cambio x inc. BELC300018233
        } catch(Exception e) {
            UtilidadesLog.error(e);
            if(e instanceof MareException) {
                throw (MareException)e;
            } else {
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
        }
        UtilidadesLog.info("MONProcesoEnvioAgregadosSolicitudBean.procesarLineaDetalle(DTOSolicitudValidacion dto1, DTODetalleMAV dto2):Salida");
    }

    private Boolean validarSolicitudPorDetalleMAV(DTOSolicitudValidacion dto1, DTODetalleMAV dto2)
        throws MareException {
        
        UtilidadesLog.info("MONProcesoEnvioAgregadosSolicitudBean.validarSolicitudPorDetalleMAV(DTOSolicitudValidacion dto1, DTODetalleMAV dto2):Entrada");
        DAOProcesoEnvioAgregadosSolicitud daoProcesoEnvioAgregadosSolicitud = new DAOProcesoEnvioAgregadosSolicitud();

        Boolean bCumpleZonificacion = daoProcesoEnvioAgregadosSolicitud.cumpleZonificacion(dto2, dto1.getOidCliente());

        if(bCumpleZonificacion.booleanValue()) {
            Boolean bCumpleCriterioAsignacion = this.cumpleCriteriosAsignacion(dto1, dto2);

            if(bCumpleCriterioAsignacion.booleanValue()) {
                Boolean bCumpleEstatusCliente = daoProcesoEnvioAgregadosSolicitud.cumpleEstatusCliente(dto2, dto1.getOidCliente());
                
                UtilidadesLog.info("MONProcesoEnvioAgregadosSolicitudBean.validarSolicitudPorDetalleMAV(DTOSolicitudValidacion dto1, DTODetalleMAV dto2):Salida");
                return bCumpleEstatusCliente;
            }
            // end if 2
        }
        // end if 1
        UtilidadesLog.info("MONProcesoEnvioAgregadosSolicitudBean.validarSolicitudPorDetalleMAV(DTOSolicitudValidacion dto1, DTODetalleMAV dto2):Salida");
        return Boolean.valueOf(false);
    }

    /**
     * MONProcesoEnvioAgregadosSolicitud.cumpleCriteriosAsignacion(dto1 : DTOSolicitudValidacion, dto2 : DTODetalleMAV) : Boolean
     *
     * Entrada:
     * - dto1 : DTOSolicitudValidacion
     * - dto2 : DTODetalleMAV
     * Proceso:
     * -> Crear variable llamada "respuesta" de tipo Boolean
     * (2)Si (dto2.criterioAsignacion = ConstantesMAV.CRITERIO_ASIGNA_ATRIBUTOS) entonces
     * -> Llamar al método "DAOProcesoEnvioAgregadosSolicitud.cumpleCriterioPorAtributos(dto1 : DTOSolicitudValidacion, dto2 : DTODetalleMAV) : Boolean"
     * -> respuesta = llamada anterior
     * (2)Si no Si (dto2.criterioAsignacion = ConstantesMAV.CRITERIO_ASIGNA_VARIABLES) entonces
     * -> respuesta = "True" (El cliente ya cumple la tipificación de cliente del detalle MAV, y la zonificación se comprueba en otro método)
     * (2)Fin Si
     * -> Devolver "respuesta"
     */
    private Boolean cumpleCriteriosAsignacion(DTOSolicitudValidacion dto1, DTODetalleMAV dto2)
        throws MareException {
          
        UtilidadesLog.info("MONProcesoEnvioAgregadosSolicitudBean.cumpleCriteriosAsignacion(DTOSolicitudValidacion dto1, DTODetalleMAV dto2):Entrada");
        Boolean bRespuesta = Boolean.valueOf(false);

        DAOProcesoEnvioAgregadosSolicitud daoProcesoEnvioAgregadosSolicitud = new DAOProcesoEnvioAgregadosSolicitud();

        if(dto2.getCriterioAsignacion().intValue() == ConstantesMAV.CRITERIO_ASIGNA_ATRIBUTOS) {
            try {
                bRespuesta = daoProcesoEnvioAgregadosSolicitud.cumpleCriterioPorAtributos(dto1, dto2);
                daoProcesoEnvioAgregadosSolicitud = null;
            } catch(Exception e) {
                UtilidadesLog.error("ERROR", e);
                if(e instanceof MareException) {
                    throw (MareException)e;
                } else {
                    throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                }
            }
        }else if(dto2.getCriterioAsignacion().intValue() == ConstantesMAV.CRITERIO_ASIGNA_VARIABLES){
            bRespuesta = Boolean.valueOf(true);
        }

        UtilidadesLog.info("MONProcesoEnvioAgregadosSolicitudBean.cumpleCriteriosAsignacion(DTOSolicitudValidacion dto1, DTODetalleMAV dto2):Salida");
        return bRespuesta;
    }

    /**
     * MONProcesoEnvioAgregadosSolicitud.generarEnvio(dto1 : DTOSolicitudValidacion, dto2 : DTODetalleMAV) : void
     * Entrada:
     * - dto1 : DTOSolicitudValidacion
     * - dto2 : DTODetalleMAV
     * Proceso:
     * -> Crear variable llamada "unidadesEnvio" de tipo Long
     * -> unidadesEnvio = dto2.unidadesPorCliente
     * -> Tomar dto2, dto1.oidPeriodo, actividad = dto2.actividad, dto1.oidCliente para la siguiente llamada
     * -> Llamar al método "MONRegistrosMAV.generarEnvioMAV(dto : DTODetalleMAV, periodo : Long, actividad : Long, cliente : Long, unidadesEnvio : Long) : void"
     */
    private void generarEnvio(DTOSolicitudValidacion dto1, DTODetalleMAV dto2)
        throws MareException {
        UtilidadesLog.info("MONProcesoEnvioAgregadosSolicitudBean.generarEnvio(DTOSolicitudValidacion dto1, DTODetalleMAV dto2):Entrada");
        Long lngUnidadesEnvio;
        lngUnidadesEnvio = new Long(dto2.getUnidadesPorCliente().longValue());

        MONRegistroMAVLocal monMAV = null;

        try {
            monMAV = this.getMONRegistroMAVLocalHome().create();
            Long oidPeriodoProcesado = dto1.getOidPeriodo();            

            monMAV.generarEnvioMAV(dto2, oidPeriodoProcesado, dto2.getActividad(), dto1.getOidCliente(), lngUnidadesEnvio);
            
            /* 
             * Agregado por ssantana, 20/12/2005
             * Inc. BELC300021963
             * Ahora se cambia el tipo de Estado de Proceso del DetalleMAV,
             * con el mismo criterio que en Generar Informacion MAV. 
             */
             /*
              * No va en Validar Agregados, según lo visto con Pruebas y Modelizado.
              */
            /*Integer constan = null;
            Long periodoFinalDetalleMAV = dto2.getPeriodoFin();
            Long periodoInicioDetalleMAV = dto2.getPeriodo();
            
            detalleMAVLH = this.getDetalleMAVLocalHome();
     
            if (periodoFinalDetalleMAV == null ) {
               UtilidadesLog.debug("Cambia Estado a Proceso Generado - Caso A ");
               constan = new Integer(ConstantesMAV.T_ESTAD_PROCESO_GENERADO);
               detalleL = detalleMAVLH.findByPrimaryKey(dto2.getOid());
               detalleL.setOidEstadoProceso(Long.valueOf(constan.toString()) );
            }
                  
            if (periodoFinalDetalleMAV != null &&
                periodoFinalDetalleMAV.equals(oidPeriodoProcesado) ) {
               UtilidadesLog.debug("Cambia Estado a Proceso Generado - Caso B");                                       
               constan = new Integer(ConstantesMAV.T_ESTAD_PROCESO_GENERADO);
               detalleL = detalleMAVLH.findByPrimaryKey(dto2.getOid());
               detalleL.setOidEstadoProceso(Long.valueOf(constan.toString()) );
            }*/
            /* Fin Agregado por ssantana, 20/12/2005 */
        } catch(CreateException re) {
            UtilidadesLog.error("ERROR",re);
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch(NamingException ne) {
            UtilidadesLog.error("ERROR",ne);
            throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (Exception fex) {
            UtilidadesLog.error("ERROR",fex);
            String sCodigoError = 
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(fex, 
                          UtilidadesError.armarCodigoError(sCodigoError));
        }
         
        UtilidadesLog.info("MONProcesoEnvioAgregadosSolicitudBean.generarEnvio(DTOSolicitudValidacion dto1, DTODetalleMAV dto2):Salida");
    }

    /**
     * MONProcesoEnvioAgregadosSolicitud.añadirAgregados(dto1 : DTOSolicitudValidacion) : void
     * Entrada:
     * - dto1 : DTOSolicitudValidacion
     * Proceso:
     * -> Llamar al método "DAOProcesoEnvioAgregadosSolicitud.obtenerEnviosMAV(dto : DTOSolicitudValidacion) : RecordSet"
     * Para cada registro del RecordSet obtenido en la llamada anterior hacer:
     * -> Crear variable llamada dto2 de tipo DTODetalleMAV
     * -> Tomar el oid del DetalleMAV del registro del envío y crear un DTOOID para la siguiente llamada
     * -> Llamar al método "MONBusinessPlanning.obtieneDetalleMAV(dto : DTOOID) : DTODetalleMAV"
     * -> Asignar a "dto2" el DetalleMAV obtenido de la llamada anterior
     * // Se crea la posición
     * -> Crear variable llamada "posicion" de tipo DTOPosicionSolicitud y hacer el siguiente mapeo:
     * -> posicion.tipoPosicion = dto1.proceso.oidTipoPosicion
     * -> posicion.subtipoPosicion = dto1.proceso.oidSubtipoPosicion
     * -> posicion.detalleOferta = dto2.codigoVenta (es el oid de un detalle oferta)
     * -> posicion.unidadesDemandadas = 0
     * -> posicion.unidadesPorAtender = unidades por atender del registro de turno
     * -> posicion.unidadesDemandaReal = posicion.unidadesPorAtender
     * Si (dto2.precio > 0) entonces
     * -> posicion.precioCatalogoUnitarioLocal = dto2.precio
     * -> posicion.precioCatalogoUnitarioDocumento = posicion.precioCatalogoUnitarioLocal / dto1.tipoCambio
     * -> posicion.precioContableUnitarioDocumento = 0
     * -> posicion.precioContableUnitarioLocal = 0
     * Si no entonces
     * -> posicion.precioCatalogoUnitarioLocal = 0
     * -> posicion.precioCatalogoUnitarioDocumento = 0
     * -> posicion.precioContableUnitarioLocal = dto2.precioContable
     * -> posicion.precioContableUnitarioDocumento = posicion.precioContableUnitarioLocal / dto1.tipoCambio
     * Fin Si
     * -> Tomar la "posicion" creada y dto1.oidSolicitud para la siguiente llamada
     * -> Llamar al método "DAOSolicitud.guardarPosicion(DTOE : DTOPosicionSolicitud, oidCabeceraSolicitud : Long) : DTOPosicionSolicitud"
     * // Se genera un mensaje llamando al CU Generar Mensajes
     * -> Crear variable llamada "mensaje" de tipo DTODatosMensaje y hacer el siguiente mapeo:
     * -> mensaje.oidMarca = dto2.marca
     * -> mensaje.oidCanal = dto2.canal
     * -> mensaje.oidAcceso = dto1.oidAcceso
     * -> mensaje.oidSubacceso = dto1.oidSubacceso
     * -> mensaje.oidActividad = dto2.actividad
     * -> mensaje.oidPeriodoInicio = dto2.periodo
     * -> mensaje.oidPeriodoFin = dto2.periodoFin
     * -> mensaje.codigoCliente = código de cliente del registro del envío
     * -> mensaje.codigoMensaje = código de mensaje del registro del envío
     * -> mensaje.oidProducto = dto2.producto
     * -> mensaje.codigoVenta = código de venta del registro del envío
     * -> mensaje.descripcionProducto = descripcion de producto del registro del envío
     * -> mensaje.precioPosicionamiento = dto2.precioContable
     * -> mensaje.precioCatalogo = dto2.precio
     * -> mensaje.precioVenta = dto2.precio
     * -> mensaje.unidadesDemandadas = unidades demandadas del registro del envío
     * -> mensaje.oidRegion = null
     * -> mensaje.oidZona = null
     * -> mensaje.oidTerritorio = null
     * -> mensaje.oidTipoCliente = dto2.tipoCliente
     * -> mensaje.oidSubtipoCliente = null
     * -> mensaje.oidTipoClasificacion = dto2.tipoClasificacion
     * -> mensaje.oidClasificacion = dto2.clasificacion
     * -> mensaje.oidEstatusMAV = dto2.estadoMAV
     * -> Llamar al método "MONGenerarMensajes.generarMensaje(dto : DTODatosMensaje) : void"
     * Si (dto1.indSimulacion = false) entonces
     * -> Hacer findByPrimaryKey sobre EnvioMAV tomando el oid del registro del envío
     * -> EnvioMAV.indEnvio = 'E'
     * -> Hacer create sobre SolicitudEnvioMAV usando EnvioMAV.oidEnvioMav y dto1.oidSolicitud
     * -> SolicitudEnvioMAV.generada = "True"
     * Fin Si
     * Fin Para
     */
     /*
      * Autor: Cortaberría
      * Fecha: 14/07/2005
      * Se modifico dtoPosicion.setUnidadesAtendidas por dtoPosicion.setUnidadesPorAtender
      * por pedido de Juan Pablo Bosnjak desde Perú, mediante mail del día 13/7
      */
    private void aniadirAgregados(DTOSolicitudValidacion dto1) throws MareException {
        
        UtilidadesLog.info("MONProcesoEnvioAgregadosSolicitudBean.aniadirAgregados(DTOSolicitudValidacion dto1):Entrada");
        DAOProcesoEnvioAgregadosSolicitud daoProcesoEnvioAgregadosSolicitud = new DAOProcesoEnvioAgregadosSolicitud();

        try {
            UtilidadesLog.debug("Llama a daoProcesoEnvioAgregadosSolicitud.obtenerEnviosMAV");
            RecordSet rs = daoProcesoEnvioAgregadosSolicitud.obtenerEnviosMAV(dto1);
            UtilidadesLog.debug("rs: " + rs);

            MONBusinessPlanningHome monBPHome = null;
            MONBusinessPlanning monBP = null;

            monBPHome = this.getMONBusinessPlanningHome();
            monBP = monBPHome.create();

            if(!rs.esVacio()) {
            
                // Agregado por ssantana, 25/7/2005, 
                //  a petición de Juan Pablo Bosnjak
                BigDecimal ultCodPosi = daoProcesoEnvioAgregadosSolicitud.obtenerUltimaPosicion(dto1.getOidSolicitud());             
                if(ultCodPosi == null) 
                      ultCodPosi = new BigDecimal(0.0D); 
                // Fin agregado ssantana, 27/5/2005
                  
                for(int i = 0; i < rs.getRowCount(); i++) {
                    UtilidadesLog.debug("Bucle: " + i);
                    DTODetalleMAV dtoDetalleMAV = new DTODetalleMAV();

                    //dtoDetalleMAV.getOidEnvio();
                    DTOOID dtoOid = new DTOOID();
                    //dtoOid.setOid(new Long(((BigDecimal)rs.getValueAt(i, "OID_DETA_MAV")).longValue()));
                    dtoOid.setOid(new Long((rs.getValueAt(i, 6)).toString()));
                    dtoOid.setIpCliente(dto1.getIpCliente());
                    dtoOid.setOidIdioma(dto1.getOidIdioma());

                    /*
                     * Agregado por ssantana, 02/03/2006,
                     * Obtiene Idioma por Defecto del Servidor, si no
                     * existe tal en el DetalleMAV. 
                     */
                    dtoDetalleMAV = monBP.obtieneDetalleMAV(dtoOid);
                    if (dtoDetalleMAV.getOidIdioma() == null) {
                        UtilidadesLog.debug("Recupera Idioma por defecto servidor");
                        RecuperadorIdiomaDefectoServidor recuperadorIdioma = 
                                new RecuperadorIdiomaDefectoServidor();
                        Long idiomaPorDefecto = 
                                recuperadorIdioma.getIdiomaDefectoServidor();
                        dtoDetalleMAV.setOidIdioma(idiomaPorDefecto);        
                    }

                    DTOPosicionSolicitud dtoPosicion = new DTOPosicionSolicitud();
                    
                    
                    dtoPosicion.setNumeroPosicion(new Long(ultCodPosi.longValue()+i+1));                     
                    dtoPosicion.setCodigoVenta((String) (rs.getValueAt(i,19)));
                    dtoPosicion.setOidDetalleOferta(Long.valueOf(rs.getValueAt(i,20).toString()) );
                    dtoPosicion.setTipoPosicion(dto1.getProceso().getOidTipoPosicion());
                    dtoPosicion.setSubtipoPosicion(dto1.getProceso().getOidSubTipoPosicion());
                    dtoPosicion.setProducto(dtoDetalleMAV.getProducto());
                    dtoPosicion.setUnidadesDemandadas(new Long(0));
                    //     * -> posicion.unidadesPorAtender = unidades por atender del registro de turno/
                    //dtoPosicion.setUnidadesAtendidas(new Long(((BigDecimal)rs.getValueAt(i, "NUM_UNID")).longValue()));
                    //dtoPosicion.setUnidadesPorAtender(new Long(((BigDecimal)rs.getValueAt(i, "NUM_UNID")).longValue()));
                    dtoPosicion.setUnidadesPorAtender(new Long((rs.getValueAt(i, 2)).toString()));
                    dtoPosicion.setUnidadesComprometidas(dtoPosicion.getUnidadesPorAtender());
                    dtoPosicion.setUnidadesDemandaReal(dtoPosicion.getUnidadesPorAtender());

                    //Integer iPrecioContableUnitarioLocal = new Integer(0);
                    //Integer iPrecioCatalogoUnitarioLocal = new Integer(0);

                    //BigDecimal bgPrecioContableUnitarioDocumento = new BigDecimal(0);
                    //BigDecimal bgPrecioCatalogoUnitarioDocumento = new BigDecimal(0);
                    

                    if(dtoDetalleMAV.getPrecio().intValue() > 0) 
                    {
                        UtilidadesLog.debug("dtoDetalleMAV.getPrecio() > 0");
                        // Modificado por ssantana, 15/3/2005
                        /*-> posicion.precioCatalogoUnitarioLocal = dto2.precio 
                          -> posicion.precioCatalogoUnitarioDocumento = posicion.precioCatalogoUnitarioLocal / dto1.tipoCambio 
                          -> posicion.precioContableUnitarioDocumento = 0 
                          -> posicion.precioContableUnitarioLocal = 0  */
                        
                        BigDecimal bigPrecioCatUnitLocal = new BigDecimal(dtoDetalleMAV.getPrecio().doubleValue());
                        BigDecimal bigTipoCambio = dto1.getTipoCambio();
                        BigDecimal bigPrecioCatUniDoc = new BigDecimal(0);
                        
                        if ( bigTipoCambio != null && bigTipoCambio.doubleValue() > 0)
                          bigPrecioCatUniDoc = bigPrecioCatUnitLocal.divide(bigTipoCambio, BigDecimal.ROUND_HALF_UP);

                        dtoPosicion.setPrecioContableUnitarioLocal(new BigDecimal(0));                        
                        dtoPosicion.setPrecioContableUnitarioDocumento(new BigDecimal(0));
                        dtoPosicion.setPrecioCatalogoUnitarioLocal(bigPrecioCatUnitLocal);
                        dtoPosicion.setPrecioCatalogoUnitarioDocumento(bigPrecioCatUniDoc);

                    } else {
                        UtilidadesLog.debug("dtoDetalleMAV.getPrecio() <= 0");
                        // Modificado por ssantana, 13/5/2005
                        // -> posicion.precioCatalogoUnitarioLocal = 0 
                        // -> posicion.precioCatalogoUnitarioDocumento = 0 
                        // -> posicion.precioContableUnitarioLocal = dto2.precioContable 
                        // -> posicion.precioContableUnitarioDocumento = posicion.precioContableUnitarioLocal / dto1.tipoCambio                         
                        
                        BigDecimal bigPrecioContable = new BigDecimal(dtoDetalleMAV.getPrecioContable().doubleValue());
                        BigDecimal bigTipoCambio = dto1.getTipoCambio();
                        BigDecimal bigPrecioContableUnitDoc = new BigDecimal(0);
                        if ( bigTipoCambio != null && bigTipoCambio.doubleValue() > 0) 
                           bigPrecioContableUnitDoc = bigPrecioContable.divide(bigTipoCambio, BigDecimal.ROUND_HALF_UP);
                                        
                        dtoPosicion.setPrecioCatalogoUnitarioLocal(new BigDecimal(0));
                        dtoPosicion.setPrecioCatalogoUnitarioDocumento(new BigDecimal(0));
                        dtoPosicion.setPrecioContableUnitarioLocal(bigPrecioContable);
                        dtoPosicion.setPrecioContableUnitarioDocumento(bigPrecioContableUnitDoc);
                    }
                    dtoPosicion.setEstadoPosicion(ConstantesPED.ESTADO_POSICION_CORRECTO);
                    //DTOPosicionSolicitud dtoPosicionSolicitud = null;
                    //DAOSolicitud daoSolicitud = new DAOSolicitud();
                    
                    /*dtoPosicion.setNumeroPosicion(new Long(1));
                    dtoPosicion.setOidDetalleOferta(new Long(4));
                    dtoPosicion.setProducto(new Long(1));*/
                    /*dtoPosicionSolicitud = daoSolicitud.guardarPosicion(dtoPosicion, 
                                                                        dto1.getOidSolicitud()); // dto1.getOidSolicitud()*/
                    Vector CabecerasPosiciones = new Vector();
                    DTOCabeceraSolicitud cabecera = new DTOCabeceraSolicitud();
                    cabecera.setOidCabeceraSolicitud(dto1.getOidSolicitud());
                    cabecera.setPeriodo(dto1.getOidPeriodo());
                    cabecera.setAcceso(dto1.getOidAcceso());
                    cabecera.setSubacceso(dto1.getOidSubAcceso());
                    cabecera.setIndicadorDigitacion(new Boolean("false"));//no es digitada
                    cabecera.setTipoSolicitud(dto1.getOidTipoSolPais());
                    ArrayList posiciones = new ArrayList();
                    posiciones.add(dtoPosicion);
                    cabecera.setPosiciones(posiciones);
                    CabecerasPosiciones.add(cabecera);
                    MONGenerarSolicitudModulosExternosHome mGenerarHome =  getMONGenerarSolicitudModulosExternosHome();
                    MONGenerarSolicitudModulosExternos generarSolicitudPed = mGenerarHome.create();
                    CabecerasPosiciones=generarSolicitudPed.generarPosiciones(CabecerasPosiciones);
                    if(!((DTOCabeceraSolicitud)CabecerasPosiciones.get(0)).getOK().booleanValue()){
                        throw new MareException(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS);
                    }

                    // Modificado por ssantana, 19/7/2005, inc. BELC300018230. 
                    // Solo se genera mensaje si el DetalleMAV así lo indica.
                    DTOBuzonMensajes dtoBuzon = new DTOBuzonMensajes();
                    if ( dtoDetalleMAV.getEnviarMensaje() != null && 
                            dtoDetalleMAV.getEnviarMensaje().booleanValue() )
                    {
                        DTODatosMensaje dtoDatosMensaje = new DTODatosMensaje();
    
                        dtoDatosMensaje.setOidMarca(dtoDetalleMAV.getMarca());
                        dtoDatosMensaje.setOidCanal(dtoDetalleMAV.getCanal());
                        dtoDatosMensaje.setOidAcceso(dto1.getOidAcceso());
                        dtoDatosMensaje.setOidSubacceso(dto1.getOidSubAcceso());
                        dtoDatosMensaje.setOidActividad(dtoDetalleMAV.getActividad());
                        dtoDatosMensaje.setOidPeriodoInicio(dtoDetalleMAV.getPeriodo());
                        dtoDatosMensaje.setOidPeriodoFin(dtoDetalleMAV.getPeriodoFin());
    
                        //if (rs.getValueAt(i, "COD_CLIE")!=null)
                        //    dtoDatosMensaje.setCodigoCliente(rs.getValueAt(i, "COD_CLIE").toString());
                        if (rs.getValueAt(i, 16)!=null)
                            dtoDatosMensaje.setCodigoCliente(rs.getValueAt(i, 16).toString());
                        
                        /*
                         * Agregado por ssantana, 03/03/2006, BELC300022717
                         */
                        /*if (rs.getValueAt(i, "NUM_MENS") != null) {
                            Long oidMensaje = Long.valueOf( rs.getValueAt(i, "NUM_MENS").toString());
                            dtoDatosMensaje.setOidMensaje(oidMensaje);
                        }*/
                        /* MAV_ENVIO.NUM_MENS */ 
                        if (rs.getValueAt(i, 15) != null) {
                            Long oidMensaje = Long.valueOf( rs.getValueAt(i, 15).toString());
                            dtoDatosMensaje.setOidMensaje(oidMensaje);
                        }
                        /*
                         * Fin Agregado por ssantana, 03/03/2006, BELC300022717
                         */
                        

                        dtoDatosMensaje.setOidProducto(dtoDetalleMAV.getProducto());
                        //dtoDatosMensaje.setCodigoVenta((String) (rs.getValueAt(i,"VAL_CODI_VENT")));
                        dtoDatosMensaje.setCodigoVenta((String) (rs.getValueAt(i,19)));
                        //if (rs.getValueAt(i, "VAL_TEXT_BREV")!=null)
                        //    dtoDatosMensaje.setDescripcionProducto(rs.getValueAt(i, "VAL_TEXT_BREV").toString()); //     * -> mensaje.descripcionProducto = descripcion de producto del registro del envío
                        if (rs.getValueAt(i, 18)!=null)
                            dtoDatosMensaje.setDescripcionProducto(rs.getValueAt(i, 18).toString()); //     * -> mensaje.descripcionProducto = descripcion de producto del registro del envío
                        dtoDatosMensaje.setPrecioPosicionamiento(new BigDecimal(dtoDetalleMAV.getPrecioContable().doubleValue()));
                        dtoDatosMensaje.setPrecioCatalogo(new BigDecimal(dtoDetalleMAV.getPrecio().longValue()));
                        dtoDatosMensaje.setPrecioVenta(new BigDecimal(dtoDetalleMAV.getPrecio().longValue()));
                        //dtoDatosMensaje.setUnidadesDemandadas(new Long(((BigDecimal)rs.getValueAt(i, "NUM_UNID")).longValue())); //      * -> mensaje.unidadesDemandadas = unidades demandadas del registro del envío
                        dtoDatosMensaje.setUnidadesDemandadas(new Long((rs.getValueAt(i, 2)).toString())); //      * -> mensaje.unidadesDemandadas = unidades demandadas del registro del envío
                        dtoDatosMensaje.setOidRegion(null);
                        dtoDatosMensaje.setOidZona(null);
                        dtoDatosMensaje.setOidTerritorio(null);
                        dtoDatosMensaje.setOidTipoCliente(dtoDetalleMAV.getTipoCliente());
                        dtoDatosMensaje.setOidSubtipoCliente(null);
                        dtoDatosMensaje.setOidTipoClasificacion(dtoDetalleMAV.getTipoClasificacion()); //
                        dtoDatosMensaje.setOidClasificacion(dtoDetalleMAV.getClasificacion()); //
                        dtoDatosMensaje.setOidEstatusMAV(dtoDetalleMAV.getEstadoMAV()); //
                        UtilidadesLog.debug("dtoDetalleMAV.getOidPais(): " + dtoDetalleMAV.getOidPais());
                        UtilidadesLog.debug("dtoDetalleMAV.getOidIdioma(): " + dtoDetalleMAV.getOidIdioma());
                        dtoDatosMensaje.setOidPais(dtoDetalleMAV.getOidPais());
                        dtoDatosMensaje.setOidIdioma(dtoDetalleMAV.getOidIdioma());
    
                        try {
                            MONGenerarMensajesHome monGenerarMensajesHome = getMONGenerarMensajesHome();
                            MONGenerarMensajes monGenerarMensajes = monGenerarMensajesHome.create();
                            dtoBuzon = monGenerarMensajes.generarMensaje(dtoDatosMensaje);
                        } catch(NamingException e) {
                            UtilidadesLog.error(e);
                            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                        }
                    }
                    // Fin agregado ssantana, 19/7/2005, inc. BELC300018230. 

                    Long lngOidRegistroEnvio = new Long(0);
                    Long lngOidEnvioMAV = new Long(0);
    
                    UtilidadesLog.debug("GA - dto1:"+dto1);


                    if(!dto1.getIndSimulacion().booleanValue()) {
                    
                        UtilidadesLog.debug("GA - Entro a generar el envio MAV.");
                    
                        try {
                            //lngOidRegistroEnvio = new Long(((BigDecimal)rs.getValueAt(i, "OID_ENVI")).longValue());
                            lngOidRegistroEnvio = new Long((rs.getValueAt(i, 0)).toString());

                            EnvioMAVLocalHome emavh = new EnvioMAVLocalHome();
                            EnvioMAVLocal emav = emavh.findByPrimaryKey(lngOidRegistroEnvio);                            

                            char cE = 69;
                            emav.setIndicadorEnvio(new Character(cE));
                            emavh.merge(emav);
                            /*
                             * Agregado por ssantana, 06/03/2006, inc. 22717
                             * Si existe Num. Secuencial en DTOBuzonMEnsajes,
                             * lo graba en el Envio.
                             */
                             Long numSecuencial = dtoBuzon.getNumeroSecuencial();
                             if (numSecuencial != null) {
                                emav.setNumeroSecuencia(numSecuencial);
                             }
                             /*
                              * Fin Agregado por ssantana, 06/03/2006, inc. 22717
                              */

                            lngOidEnvioMAV = emav.getOid();
                        } catch(NoResultException e) {
                            ctx.setRollbackOnly();
                            UtilidadesLog.error(e);
                            throw new MareException(e,
                                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
                        }

                        try {
                            SolicitudEnvioMAVLocalHome semlh = new SolicitudEnvioMAVLocalHome();
                            SolicitudEnvioMAVLocal semav = semlh.create(lngOidEnvioMAV, dto1.getOidSolicitud());
                            semav.setGenerada(Boolean.valueOf(true));
                            semlh.merge(semav);
                        } catch(PersistenceException e) {
                            UtilidadesLog.error(e);
                            ctx.setRollbackOnly();                            
                            throw new MareException(e,
                                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                        }
                    }

                    // end if
                    ultCodPosi = ultCodPosi.add(new BigDecimal(1));
                  }
                }

            // end for
        } catch(RemoteException re) {
            UtilidadesLog.error(re);
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch(CreateException ce) {
            UtilidadesLog.error(ce);
            throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch(NamingException ne) {
            UtilidadesLog.error(ne);
            throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch(Exception e) {
            e.printStackTrace();
            UtilidadesLog.error(e);
            if(e instanceof MareException) {
                throw (MareException)e;
            } else {
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
        }
        UtilidadesLog.info("MONProcesoEnvioAgregadosSolicitudBean.aniadirAgregados(DTOSolicitudValidacion dto1):Salida");
    }


    private MONGenerarMensajesHome getMONGenerarMensajesHome()
        throws NamingException {
        final InitialContext context = new InitialContext();

        return (MONGenerarMensajesHome)PortableRemoteObject.narrow(context.lookup("MONGenerarMensajes"), MONGenerarMensajesHome.class);
    }

    private MONGestionMensajesHome getMONGestionMensajesHome()
        throws NamingException {
        final InitialContext context = new InitialContext();
        return (MONGestionMensajesHome)PortableRemoteObject.narrow(context.lookup("MONGestionMensajes"), MONGestionMensajesHome.class);
    }


    private MONBusinessPlanningHome getMONBusinessPlanningHome()
        throws NamingException {
        final InitialContext context = new InitialContext();
        return (MONBusinessPlanningHome)PortableRemoteObject.narrow(context.lookup("MONBusinessPlanning"),
            MONBusinessPlanningHome.class);
    }

    private MONRegistroMAVHome getMONRegistroMAVHome() throws NamingException {
        final InitialContext context = new InitialContext();
        return (MONRegistroMAVHome)PortableRemoteObject.narrow(context.lookup("MONRegistroMAV"), MONRegistroMAVHome.class);
    }

  private DetalleMAVLocalHome getDetalleMAVLocalHome() throws NamingException {
    final InitialContext context = new InitialContext();
    return (DetalleMAVLocalHome)context.lookup("java:comp/env/DetalleMAV");
  }
  
  
  /**
   * @author: ssantana, 08/06/2006
   * @throws es.indra.mare.common.exception.MareException
   * @return Boolean
   * @param oidCliente
   * @param oidDetalleMAV
   */
  private Boolean chequeaExistenciaEnvioMAV(BigDecimal bigOidDetalleMAV, 
                                            Long oidCliente) throws MareException {
      UtilidadesLog.info("MONProcesoEnvioAgregadosSolicitud.chequeaExistenciaEnvioMAV():Entrada");
      DAOProcesoEnvioAgregadosSolicitud dao = new DAOProcesoEnvioAgregadosSolicitud();
      Boolean bExisteEnvio = dao.chequeaExistenciaEnvioMAV(bigOidDetalleMAV, oidCliente);
      UtilidadesLog.info("MONProcesoEnvioAgregadosSolicitud.chequeaExistenciaEnvioMAV():Salida");
      return bExisteEnvio;
  }

    private MONGenerarSolicitudModulosExternosHome getMONGenerarSolicitudModulosExternosHome() throws NamingException
    {
        final InitialContext context = new InitialContext();
        return (MONGenerarSolicitudModulosExternosHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONGenerarSolicitudModulosExternos"), MONGenerarSolicitudModulosExternosHome.class);
    }

    private MONRegistroMAVLocalHome getMONRegistroMAVLocalHome() throws NamingException
    {
        final InitialContext context = new InitialContext();
        return (MONRegistroMAVLocalHome)context.lookup("java:comp/env/ejb/local/MONRegistroMAV");
    }

    private MONBusinessPlanningLocalHome getMONBusinessPlanningLocalHome() throws NamingException
    {
        final InitialContext context = new InitialContext();
        return (MONBusinessPlanningLocalHome)context.lookup("java:comp/env/ejb/local/MONBusinessPlanning");
    }


}