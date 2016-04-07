/**
 * Copyright 2005 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 */
package es.indra.sicc.logicanegocio.rec;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.dtos.bel.DTOMovimientoAlmacen;
import es.indra.sicc.dtos.bel.DTOMovimientoAlmacenCabecera;
import es.indra.sicc.dtos.bel.DTOMovimientoAlmacenDetalle;
import es.indra.sicc.dtos.bel.DTOReportePedidos;
import es.indra.sicc.dtos.cra.DTOPeriodo;
import es.indra.sicc.dtos.ped.DTONumeroSolicitud;
import es.indra.sicc.dtos.pre.DTOBuscarCodigoVentaPeriodo;
import es.indra.sicc.dtos.rec.DTOAtencionReclamoREC;
import es.indra.sicc.dtos.rec.DTOValidarLineaReclamo;
import es.indra.sicc.dtos.rec.DTOValidarOperacionReclamo;
import es.indra.sicc.dtos.rec.DTOValidarReclamo;
import es.indra.sicc.dtos.rec.DTOValidacionDocumento;
import es.indra.sicc.dtos.inc.DTOPrecioReclamo;

import es.indra.sicc.entidades.pre.DetalleOfertaLocal;
import es.indra.sicc.entidades.pre.DetalleOfertaLocalHome;
import es.indra.sicc.entidades.rec.AutorizacionesLocal;
import es.indra.sicc.entidades.rec.CabeceraReclamoLocal;
import es.indra.sicc.entidades.rec.CabeceraReclamoLocalHome;
import es.indra.sicc.entidades.rec.LineaOperacionReclamoDigitadoLocal;
import es.indra.sicc.entidades.rec.LineasOperacionReclamoLocal;
import es.indra.sicc.entidades.rec.LineasOperacionReclamoLocalHome;
import es.indra.sicc.entidades.rec.LineaOperacionReclamoDigitadoLocalHome;
import es.indra.sicc.entidades.rec.OperacionReclamoDigitadoLocal;
import es.indra.sicc.entidades.rec.OperacionReclamoDigitadoLocalHome;
import es.indra.sicc.entidades.rec.CabeceraReclamoDigitadoLocal;
import es.indra.sicc.entidades.rec.CabeceraReclamoDigitadoLocalHome;
import es.indra.sicc.entidades.rec.OperacionReclamoLocal;
import es.indra.sicc.entidades.rec.ResultadosChequeoLocal;
import es.indra.sicc.entidades.rec.ResultadosChequeoLocalHome;

import es.indra.sicc.entidades.rec.TiposBloqueoLocal;
import es.indra.sicc.logicanegocio.bel.ConstantesBEL;
import es.indra.sicc.logicanegocio.bel.MONGenerarMovimientoAlmacen;
import es.indra.sicc.logicanegocio.bel.MONGenerarMovimientoAlmacenHome;
import es.indra.sicc.logicanegocio.cra.MONPeriodos;
import es.indra.sicc.logicanegocio.cra.MONPeriodosHome;
import es.indra.sicc.logicanegocio.inc.MONSoporteExternoHome;
import es.indra.sicc.logicanegocio.ped.MONPedidosSolicitud;
import es.indra.sicc.logicanegocio.ped.MONPedidosSolicitudHome;
import es.indra.sicc.logicanegocio.ped.MONProcesosPED;
//import es.indra.sicc.logicanegocio.ped.MONProcesosPEDBean;
import es.indra.sicc.logicanegocio.ped.MONProcesosPEDHome;
import es.indra.sicc.logicanegocio.pre.MONMantenimientoMF;
import es.indra.sicc.logicanegocio.pre.MONMantenimientoMFHome;
import es.indra.sicc.logicanegocio.inc.MONSoporteExterno;

import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOString;
import es.indra.sicc.util.LogAPP;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Vector;

import javax.ejb.SessionContext;
import javax.ejb.SessionBean;
import es.indra.sicc.entidades.rec.OperacionReclamoLocalHome;
import es.indra.sicc.entidades.rec.AutorizacionesLocalHome;
import es.indra.sicc.entidades.rec.TiposBloqueoLocalHome;
import java.util.Iterator;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class MONValidarReclamosBean implements SessionBean  {

    // Atributos de la clase
    private final String REC = "REC";
    private final String CU = "Validar Reclamos Digitados";
    
    private SessionContext ctx;
    //private UserTransaction u;
        
    public void ejbCreate() {
    }

    public void ejbActivate() {
    }

    public void ejbPassivate() {
    }

    public void ejbRemove() {
    }

    public void setSessionContext(SessionContext ctx) {
        this.ctx = ctx;
    }

    public void procesoValidacionReclamos(DTOBelcorp dtoBelcorp) throws MareException {
        // Valida todos los recolamos digitados
        // Si la información es completa y valida, se da el reclamo por bueno y se modifica su estado a "Ingresado"
        UtilidadesLog.info("MONValidarReclamos.procesoValidacionReclamos(DTOBelcorp):Entrada");
        
        // Recupera en primer lugar todos los reclamos del pais
        ArrayList reclamosDigitados = this.obtenerReclamosDigitados(dtoBelcorp);
        
        // Valida los reclamos recuperados
        this.validarReclamos(reclamosDigitados);

        UtilidadesLog.info("MONValidarReclamos.procesoValidacionReclamos(DTOBelcorp):Salida");
    }

    private ArrayList obtenerReclamosDigitados(DTOBelcorp dto) throws MareException {
        UtilidadesLog.info("MONValidarReclamos.obtenerReclamosDigitados(DTOBelcorp):Entrada");

        DAORec daoRec = new DAORec();
        
        // Obtiene de BD todos los reclamos en estado digitado
        RecordSet reclamos = daoRec.obtenerReclamosDigitados(dto.getOidPais());
        
        // Crea un ArrayList reclamosDigitados
        ArrayList reclamosDigitados = new ArrayList();
        
        int tamaño = reclamos.getRowCount();
        DTOValidarReclamo dtoValidarReclamo = null;
        
        for(int i=0; i<tamaño; i++) {
            dtoValidarReclamo = new DTOValidarReclamo();

            dtoValidarReclamo.setOidPais(new Long(dto.getOidPais().longValue()));
            dtoValidarReclamo.setOidReclamo(new Long(((BigDecimal)reclamos.getValueAt(i, "OID_RECLAMO")).longValue()));
            dtoValidarReclamo.setCodigoCliente((String)reclamos.getValueAt(i, "COD_CLIENTE"));
            dtoValidarReclamo.setNumeroDocumentoRefrencia(new Long(((BigDecimal)reclamos.getValueAt(i, "DOC_REFERENCIA")).longValue()));
            dtoValidarReclamo.setOidIdioma(new Long(dto.getOidIdioma().longValue()));
 
            reclamosDigitados.add(dtoValidarReclamo);
        }

        UtilidadesLog.info("MONValidarReclamos.obtenerReclamosDigitados(DTOBelcorp):Salida");

        return reclamosDigitados;
    }

    private void validarReclamos(ArrayList reclamos) throws MareException {
        // Recibe un ArrayList de reclamos (DTOValidarReclamo) y realiza las validaciones de cada uno
        UtilidadesLog.info("MONValidarReclamos.validarReclamos(ArrayList):Entrada");

        int tamanio = reclamos.size();
        DTOValidarReclamo dtoValidarReclamo = null;
        
        for(int i = 0; i<tamanio; i++) {
            dtoValidarReclamo = (DTOValidarReclamo)reclamos.get(i);
            
            this.validarUnReclamo(dtoValidarReclamo);
        }

        UtilidadesLog.info("MONValidarReclamos.validarReclamos(ArrayList):Salida");
    }

    // BELC300014869, BELC300014866, 18801
    private DTOValidarReclamo validarUnReclamo(DTOValidarReclamo reclamo) throws MareException {
        // Realiza las validaciones para un reclamo
        UtilidadesLog.info("MONValidarReclamos.validarUnReclamo(DTOValidarReclamo):Entrada");
        UtilidadesLog.debug("*** DTOValidarReclamo entrada: "+reclamo);
        
        // Valida el documento de referencia
        reclamo = this.validarCabeceraReclamo(reclamo);
        if(reclamo.getError()==true) { 
            this.reclamoError(reclamo);
            UtilidadesLog.info("validarCabeceraReclamo - MONValidarReclamos.validarUnReclamo(DTOValidarReclamo):Salida");
             return reclamo;
       }
        
        // Valida las operaciones del reclamo
        reclamo = this.validarOperaciones(reclamo);
        if(reclamo.getError()==true) {
            this.reclamoError(reclamo);
            UtilidadesLog.info("validarOperaciones - MONValidarReclamos.validarUnReclamo(DTOValidarReclamo):Salida");
            return reclamo;
        } else {
            reclamo.setEstado(ConstantesREC.ESTADO_RECLAMO_INGRESADO);
        }
        
        // Valida el bloqueo por chequeo físico
        //reclamo = this.validarBloqueoChequeoFisico(reclamo);
                
        // Guarda los datos del reclamo
        reclamo = this.guardarReclamo(reclamo);
        
        // Generar lineas automáticas
        reclamo = this.generarLineasAutomaticas(reclamo);

        // Valida los bloqueos del reclamo
        reclamo = this.validarBloqueosReclamo(reclamo);

        // Valida el bloqueo por chequeo físico
        reclamo = this.validarBloqueoChequeoFisico(reclamo);

        // Genera movimientos de almacén
        this.generarMovimientoAlmacenReclamo(reclamo);
        
        
        // incidencia BELC300018490
        // Genera la solicitud para el reclamo con el numeroAtencion
        DTOAtencionReclamoREC dtoAtenReclaREC  = new DTOAtencionReclamoREC();
        dtoAtenReclaREC.setNumAtencion(reclamo.getNumeroAtencion());
        dtoAtenReclaREC.setOidPais(reclamo.getOidPais());
        dtoAtenReclaREC.setOidIdioma(reclamo.getOidIdioma());
        dtoAtenReclaREC.setNumRecojo(ConstantesREC.RECLAMO_DIGITADO);
        
        MONCapturaProcesoReclamos mon = this.getMONCapturaProcesoReclamos();
        
        if (!reclamo.getEstado().equals( ConstantesREC.ESTADO_RECLAMO_BLOQUEADO )){
            
            try{
                mon.generarSolicitudes(dtoAtenReclaREC);
            } catch (RemoteException re){
                UtilidadesLog.error(re);
                ctx.setRollbackOnly();
                String error = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                throw new MareException(re, UtilidadesError.armarCodigoError(error));
            }
        }
        
        UtilidadesLog.info("MONValidarReclamos.validarUnReclamo(DTOValidarReclamo):Salida");
        
        return reclamo;
    }

    // BELC300014868
    private DTOValidarReclamo validarCabeceraReclamo(DTOValidarReclamo reclamo) throws MareException {
        // Valida el documento de referencia del reclamo
        UtilidadesLog.info("MONValidarReclamos.validarCabeceraReclamo(DTOValidarReclamo):Entrada");
        UtilidadesLog.debug("*** DTOValidarReclamo: "+reclamo);
        
        // Obtiene los datos de la cabecera
        DAORec daoRec = new DAORec();
        RecordSet documentos = daoRec.obtenerCabeceraReclamoDigitado(reclamo.getOidReclamo());

        // valida el documento del reclamo
        DTOValidacionDocumento dtoValidacionDocumento = this.validarDocumentoReferencia(documentos);
        
        //REC-08 Incidencia 
        /*valida el cliente
          Si ((documentos.getValueAt(0,"COD_CLIEN_REC") != (documentos.getValueAt(0,"COD_CLIEN_MAE"))
          {
           error= true
          } */
        UtilidadesLog.debug("*** dtoValidacionDocumento: " + dtoValidacionDocumento);
         if(!dtoValidacionDocumento.getError().booleanValue()){
          
                   UtilidadesLog.debug("Codigo Cliente Reclamos " + documentos.getValueAt(dtoValidacionDocumento.getPosicion().intValue(),"COD_CLIEN_REC") );
                   UtilidadesLog.debug("Codigo Cliente  MAE " + documentos.getValueAt(0,"COD_CLIEN_MAE") );
               
                    // Si no se produce error, completamos los datos del reclamo
                    if( documentos.getValueAt(dtoValidacionDocumento.getPosicion().intValue(),"COD_CLIEN_REC").equals(documentos.getValueAt(dtoValidacionDocumento.getPosicion().intValue(),"COD_CLIEN_MAE"))  ) {                    
                       
                        if(documentos.getValueAt(dtoValidacionDocumento.getPosicion().intValue(), "OID_RECLAMO")!=null) {
                            reclamo.setOidReclamo(new Long(((BigDecimal)documentos.getValueAt(dtoValidacionDocumento.getPosicion().intValue(), "OID_RECLAMO")).longValue()));
                        }
                        if(documentos.getValueAt(dtoValidacionDocumento.getPosicion().intValue(), "PAIS")!=null) {
                            reclamo.setCodigoPais((String)documentos.getValueAt(dtoValidacionDocumento.getPosicion().intValue(), "PAIS"));
                        }
                        if(documentos.getValueAt(dtoValidacionDocumento.getPosicion().intValue(), "NUMERO_RECLAMO")!=null) {
                            reclamo.setNumeroReclamo(new Long(((BigDecimal)documentos.getValueAt(dtoValidacionDocumento.getPosicion().intValue(), "NUMERO_RECLAMO")).longValue()));
                        }
                        if(documentos.getValueAt(dtoValidacionDocumento.getPosicion().intValue(), "TIPO_INGRESO")!=null) {
                            reclamo.setOidTipoIngreso(new Long(((BigDecimal)documentos.getValueAt(dtoValidacionDocumento.getPosicion().intValue(), "TIPO_INGRESO")).longValue()));
                        }
                        if(documentos.getValueAt(dtoValidacionDocumento.getPosicion().intValue(), "USUARIO_INGRESO")!=null) {
                            reclamo.setCodigoUsuario((String)documentos.getValueAt(dtoValidacionDocumento.getPosicion().intValue(), "USUARIO_INGRESO"));
                        }
                        if(documentos.getValueAt(dtoValidacionDocumento.getPosicion().intValue(), "FECHA_INGRESO")!=null) {
                            reclamo.setFechaIngreso((Date)documentos.getValueAt(dtoValidacionDocumento.getPosicion().intValue(), "FECHA_INGRESO"));
                        }
                        if(documentos.getValueAt(dtoValidacionDocumento.getPosicion().intValue(), "OID_DOCUMENTO")!=null) {
                            reclamo.setOidDocumentoReferencia(new Long(((BigDecimal)documentos.getValueAt(dtoValidacionDocumento.getPosicion().intValue(), "OID_DOCUMENTO")).longValue()));
                        }
                        if(documentos.getValueAt(dtoValidacionDocumento.getPosicion().intValue(), "OID_MARCA")!=null) {
                            reclamo.setOidMarca(new Long(((BigDecimal)documentos.getValueAt(dtoValidacionDocumento.getPosicion().intValue(), "OID_MARCA")).longValue()));
                        }
                        if(documentos.getValueAt(dtoValidacionDocumento.getPosicion().intValue(), "OID_CANAL")!=null) {
                            reclamo.setOidCanal(new Long(((BigDecimal)documentos.getValueAt(dtoValidacionDocumento.getPosicion().intValue(), "OID_CANAL")).longValue()));
                        }
                        if(documentos.getValueAt(dtoValidacionDocumento.getPosicion().intValue(), "OID_ACCESO")!=null) {
                            reclamo.setOidAcceso(new Long(((BigDecimal)documentos.getValueAt(dtoValidacionDocumento.getPosicion().intValue(), "OID_ACCESO")).longValue()));
                        }
                        if(documentos.getValueAt(dtoValidacionDocumento.getPosicion().intValue(), "OID_SUBACCESO")!=null) {
                            reclamo.setOidSubacceso(new Long(((BigDecimal)documentos.getValueAt(dtoValidacionDocumento.getPosicion().intValue(), "OID_SUBACCESO")).longValue()));
                        }
                        if(documentos.getValueAt(dtoValidacionDocumento.getPosicion().intValue(), "FECHA_EMISION")!=null) {
                            reclamo.setFechaEmision((Date)documentos.getValueAt(dtoValidacionDocumento.getPosicion().intValue(), "FECHA_EMISION"));
                        }
                        if(documentos.getValueAt(dtoValidacionDocumento.getPosicion().intValue(), "OID_CLIENTE")!=null) {
                            reclamo.setOidCliente(new Long(((BigDecimal)documentos.getValueAt(dtoValidacionDocumento.getPosicion().intValue(), "OID_CLIENTE")).longValue()));
                        }
                        if(documentos.getValueAt(dtoValidacionDocumento.getPosicion().intValue(), "OID_SUBTIPO_CLIENTE")!=null) {
                            reclamo.setOidSubtipoCliente(new Long(((BigDecimal)documentos.getValueAt(dtoValidacionDocumento.getPosicion().intValue(), "OID_SUBTIPO_CLIENTE")).longValue()));
                        }
                        if(documentos.getValueAt(dtoValidacionDocumento.getPosicion().intValue(), "OID_TIPO_CLIENTE")!=null) {
                            reclamo.setOidTipoCliente(new Long(((BigDecimal)documentos.getValueAt(dtoValidacionDocumento.getPosicion().intValue(), "OID_TIPO_CLIENTE")).longValue()));
                        }
                        if(documentos.getValueAt(dtoValidacionDocumento.getPosicion().intValue(), "OID_TERRITORIO_ADM")!=null) {
                            reclamo.setOidTerritorioAdm(new Long(((BigDecimal)documentos.getValueAt(dtoValidacionDocumento.getPosicion().intValue(), "OID_TERRITORIO_ADM")).longValue()));
                        }
                        if(documentos.getValueAt(dtoValidacionDocumento.getPosicion().intValue(), "OID_PERIODO_SOLICITUD")!=null) {
                            reclamo.setOidPeriodoSolicitud(new Long(((BigDecimal)documentos.getValueAt(dtoValidacionDocumento.getPosicion().intValue(), "OID_PERIODO_SOLICITUD")).longValue()));
                        }
                        if(documentos.getValueAt(dtoValidacionDocumento.getPosicion().intValue(), "OID_TIPO_DOCUMENTO_LEGAL")!=null) {
                            reclamo.setOidTipoDocumentoLegal(new Long(((BigDecimal)documentos.getValueAt(dtoValidacionDocumento.getPosicion().intValue(), "OID_TIPO_DOCUMENTO_LEGAL")).longValue()));
                        }
                        if(documentos.getValueAt(dtoValidacionDocumento.getPosicion().intValue(), "OID_RESULTADO_CHEQUEO")!=null) {
                            reclamo.setOidResultadoChequeo(new Long(((BigDecimal)documentos.getValueAt(dtoValidacionDocumento.getPosicion().intValue(), "OID_RESULTADO_CHEQUEO")).longValue()));
                        }
                        if(documentos.getValueAt(dtoValidacionDocumento.getPosicion().intValue(), "OID_CONCURSO_PARAMETROS")!=null) {
                            reclamo.setOidConcursoParametros(new Long(((BigDecimal)documentos.getValueAt(dtoValidacionDocumento.getPosicion().intValue(), "OID_CONCURSO_PARAMETROS")).longValue()));
                        }
            
                        // BELC300018867
                        // Obtiene el periodo del reclamo
                        DTOPeriodo dtoPeriodo = new DTOPeriodo();
                        dtoPeriodo.setOidPais(new Long(reclamo.getOidPais().longValue()));
                        dtoPeriodo.setPais(new Long(reclamo.getOidPais().longValue()));
                        dtoPeriodo.setMarca(new Long(reclamo.getOidMarca().longValue()));
                        dtoPeriodo.setCanal(new Long(reclamo.getOidCanal().longValue()));
                        dtoPeriodo.setFechaInicio(new Date(reclamo.getFechaIngreso().getTime()));
                        
                        MONPeriodos monPeriodos = this.getMONPeriodos();
                        DTOSalida dtoSalida = null;
                        
                        try {
                            dtoSalida = monPeriodos.obtienePeriodosFecha(dtoPeriodo);
                        } catch (RemoteException e) {
                            String errorCatch = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                            ctx.setRollbackOnly();
                            throw new MareException(e, UtilidadesError.armarCodigoError(errorCatch));
                        }
                
                        // Obtiene el oid del primer periodo recuperado
                        // BELC300014956
                        reclamo.setOidPeriodoReclamo(new Long(((BigDecimal)dtoSalida.getResultado().getValueAt(0, "OID")).longValue()));            
                        
                        reclamo.setError(false);
                    } else {
                        reclamo.setError(true);
                    }
        }else{
             reclamo.setError(true);
        }
        UtilidadesLog.info("MONValidarReclamos.validarCabeceraReclamo(DTOValidarReclamo):Salida");
        return reclamo;
    }

    private void reclamoError(DTOValidarReclamo reclamo) throws MareException {
        // Actualiza el estado del reclamo y sus operaciones a "Error" y 
        // genera un log de error con los datos del mismo
        UtilidadesLog.info("MONValidarReclamos.reclamoError(DTOValidarReclamo):Entrada");
        UtilidadesLog.debug("*** DTOVAlidarREclamo entrado: "+reclamo);

        // Actualiza el estado del reclamo
        this.actualizarEstadoReclamo(reclamo.getOidReclamo(), ConstantesREC.ESTADO_RECLAMO_ERROR); //REC-08 mamontie 15/12/05
        UtilidadesLog.debug("*** DTOVAlidarREclamo actualizo el estado");
        reclamo.setEstado(ConstantesREC.ESTADO_RECLAMO_ERROR); //REC-08 mamontie 15/12/05
        UtilidadesLog.debug("*** DTOVAlidarREclamo seteo estado reclamos "+reclamo);
        
        // Escribe el log de error
        // Utilizar el servicio APPLoggingService para generar un log de error:
        // [PED] [CU] reclamo.codigoPais, reclamo.fechaIngreso, reclamo.numeroReclamo, reclamo.codigoCliente, reclamo.numeroDocumentoReferencia
        StringBuffer error = new StringBuffer("");
        error.append("["+this.REC+"] ["+this.CU+"] codigoPais="+reclamo.getCodigoPais());
        error.append(", fechaIngreso="+reclamo.getFechaIngreso()+", numeroReclamo="+reclamo.getNumeroReclamo());
        error.append(", codigoCliente="+reclamo.getCodigoCliente());
        error.append(", numeroDocumentoReferencia="+reclamo.getNumeroDocumentoRefrencia());
        LogAPP.info(error.toString());        

        UtilidadesLog.info("MONValidarReclamos.reclamoError(DTOValidarReclamo):Salida");
    }

    private DTOValidarReclamo validarOperaciones(DTOValidarReclamo reclamo) throws MareException {
        // Realiza las validaciones de las operaciones de un reclamo 
        UtilidadesLog.info("MONValidarReclamos.validarOperaciones(DTOValidarReclamo):Entrada");
    
        DAORec daoRec = new DAORec();
        
        RecordSet operacionesReclamo = daoRec.obtenerOperacionesReclamoDigitado(reclamo.getOidReclamo());
        reclamo.setError(true);

        int tamanio = operacionesReclamo.getRowCount();
        DTOValidarOperacionReclamo dtoValidarOperacionReclamo = null;
        ArrayList operaciones = new ArrayList();
        
        int valorBooleano;
        
        UtilidadesLog.debug("Tamño Operaciones: "+tamanio);
        for(int i = 0; i<tamanio; i++) {
            dtoValidarOperacionReclamo = new DTOValidarOperacionReclamo();
            
            // COL-REC-001
            if(operacionesReclamo.getValueAt(i, "IND_RECO")!=null) {
                dtoValidarOperacionReclamo.setIndRecojo(
                        operacionesReclamo.getValueAt(i, "IND_RECO").toString().equals("1")?
                           Boolean.TRUE.booleanValue() : Boolean.FALSE.booleanValue());
                if(dtoValidarOperacionReclamo.getIndRecojo()){
                  reclamo.setNumeroRecojo(ConstantesREC.RECOJO_INICIAL);
                }
            }
            if(operacionesReclamo.getValueAt(i, "TSPA_OID_TIPO_SOLI_REC_INIC")!=null) {
                dtoValidarOperacionReclamo.setOidTipoSolicRecojoIncial(
                        new Long(((BigDecimal)operacionesReclamo.getValueAt(i, "TSPA_OID_TIPO_SOLI_REC_INIC")).longValue()));
            }
            if(operacionesReclamo.getValueAt(i, "TSPA_OID_TIPO_SOLI_PRI_NO_EXIT")!=null) {
                dtoValidarOperacionReclamo.setOidTipoSolicPrimerRecojoNoExitoso(
                        new Long(((BigDecimal)operacionesReclamo.getValueAt(i, "TSPA_OID_TIPO_SOLI_PRI_NO_EXIT")).longValue()));
            }
            if(operacionesReclamo.getValueAt(i, "TSPA_OID_SOLI_PAIS_SEG_NO_EXIT")!=null) {
                dtoValidarOperacionReclamo.setOidTipoSolicSegundoRecojoNoExitoso(
                        new Long(((BigDecimal)operacionesReclamo.getValueAt(i, "TSPA_OID_SOLI_PAIS_SEG_NO_EXIT")).longValue()));
            }
            if(operacionesReclamo.getValueAt(i, "TMAL_OID_TIPO_ALMA_REC_INIC")!=null) {
                dtoValidarOperacionReclamo.setOidTipoAlmacenRecojoInicial(
                        new Long(((BigDecimal)operacionesReclamo.getValueAt(i, "TMAL_OID_TIPO_ALMA_REC_INIC")).longValue()));
            }
            if(operacionesReclamo.getValueAt(i, "TMAL_OID_TIPO_ALMA_REC_EXIT")!=null) {
                dtoValidarOperacionReclamo.setOidTipoAlmacenRecojoExitoso(
                        new Long(((BigDecimal)operacionesReclamo.getValueAt(i, "TMAL_OID_TIPO_ALMA_REC_EXIT")).longValue()));
            }
            if(operacionesReclamo.getValueAt(i, "TMAL_OID_TIPO_ALMA_REC_NO_EXIT")!=null) {
                dtoValidarOperacionReclamo.setOidTipoAlmacenRecojoNoExitoso(
                        new Long(((BigDecimal)operacionesReclamo.getValueAt(i, "TMAL_OID_TIPO_ALMA_REC_NO_EXIT")).longValue()));
            }
            if(operacionesReclamo.getValueAt(i, "ALMC_OID_ALMA_POSV")!=null) {
                dtoValidarOperacionReclamo.setOidAlmacenPostVenta(
                        new Long(((BigDecimal)operacionesReclamo.getValueAt(i, "ALMC_OID_ALMA_POSV")).longValue()));
            }
            // COL-REC-001 fin 
            
            if(operacionesReclamo.getValueAt(i, "OID_OPERACION")!=null) {
                dtoValidarOperacionReclamo.setOidOperacion(
                        new Long(((BigDecimal)operacionesReclamo.getValueAt(i, "OID_OPERACION")).longValue()));
            }
            if(operacionesReclamo.getValueAt(i, "NUMERO_OPERACION")!=null) {
                dtoValidarOperacionReclamo.setNumeroOperacion(
                        new Integer(((BigDecimal)operacionesReclamo.getValueAt(i, "NUMERO_OPERACION")).intValue()));
            }
            if(operacionesReclamo.getValueAt(i, "OID_RECLAMO")!=null) {
                dtoValidarOperacionReclamo.setOidReclamo(
                        new Long(((BigDecimal)operacionesReclamo.getValueAt(i, "OID_RECLAMO")).longValue()));
            }
            if(operacionesReclamo.getValueAt(i, "IND_ANULACION")!=null) {
                dtoValidarOperacionReclamo.setAnulacion(
                        (((BigDecimal)operacionesReclamo.getValueAt(i, "IND_ANULACION")).longValue())== new Long(1).longValue()?true:false);
            }
            if(operacionesReclamo.getValueAt(i, "IND_PERDIDA")!=null) {
                dtoValidarOperacionReclamo.setPerdida(
                        (((BigDecimal)operacionesReclamo.getValueAt(i, "IND_PERDIDA")).longValue())== new Long(1).longValue()?true:false);
            }
            if(operacionesReclamo.getValueAt(i, "OID_PRECIO_ENVIA")!=null) {
                dtoValidarOperacionReclamo.setOidPrecioEnvia(
                        new Long(((BigDecimal)operacionesReclamo.getValueAt(i, "OID_PRECIO_ENVIA")).longValue()));
            }
            if(operacionesReclamo.getValueAt(i, "OID_ASUME_PERDIDA")!=null) {
                dtoValidarOperacionReclamo.setOidAsumePerdida(
                        new Long(((BigDecimal)operacionesReclamo.getValueAt(i, "OID_ASUME_PERDIDA")).longValue()));
            }
            if(operacionesReclamo.getValueAt(i, "OID_ARTICULO")!=null) {
                dtoValidarOperacionReclamo.setOidArticulo(
                        new Long(((BigDecimal)operacionesReclamo.getValueAt(i, "OID_ARTICULO")).longValue()));
            }
            if(operacionesReclamo.getValueAt(i, "MONTO_ARTICULO")!=null) {
                dtoValidarOperacionReclamo.setMontoPerdida(
                        (BigDecimal)operacionesReclamo.getValueAt(i, "MONTO_ARTICULO"));
            }
            if(operacionesReclamo.getValueAt(i, "OID_RESPONSABLE_PERDIDA")!=null) {
                dtoValidarOperacionReclamo.setOidResponsablePerdida(
                        new Long(((BigDecimal)operacionesReclamo.getValueAt(i, "OID_RESPONSABLE_PERDIDA")).longValue()));
            }
            if(operacionesReclamo.getValueAt(i, "OID_CLIENTE_SEGURO")!=null) {
                dtoValidarOperacionReclamo.setOidClienteSeguro(
                        new Long(((BigDecimal)operacionesReclamo.getValueAt(i, "OID_CLIENTE_SEGURO")).longValue()));
            }
            if(operacionesReclamo.getValueAt(i, "DEVUELVE_FISICO_FACTURA")!=null) {
                dtoValidarOperacionReclamo.setDevuelveFisicoFactura(
                        (((BigDecimal)operacionesReclamo.getValueAt(i, "DEVUELVE_FISICO_FACTURA")).longValue())== new Long(1).longValue()?true:false);
            }
            if(operacionesReclamo.getValueAt(i, "DEVUELVE_EN_FACTURA")!=null) {
                dtoValidarOperacionReclamo.setDevuelveEnFactura(
                        (((BigDecimal)operacionesReclamo.getValueAt(i, "DEVUELVE_EN_FACTURA")).longValue())== new Long(1).longValue()?true:false);
            }
            if(operacionesReclamo.getValueAt(i, "ENVIA_EN_FACTURA")!=null) {
                dtoValidarOperacionReclamo.setEnviaEnFactura(
                        (((BigDecimal)operacionesReclamo.getValueAt(i, "ENVIA_EN_FACTURA")).longValue())== new Long(1).longValue()?true:false);
            }
            if(operacionesReclamo.getValueAt(i, "OID_BLOQUEO_UNIDADES")!=null) {
                dtoValidarOperacionReclamo.setOidBloqueoUnidades(
                        new Long(((BigDecimal)operacionesReclamo.getValueAt(i, "OID_BLOQUEO_UNIDADES")).longValue()));
            }
            if(operacionesReclamo.getValueAt(i, "OID_BLOQUEO_IMPORTE")!=null) {
                dtoValidarOperacionReclamo.setOidBloqueoImporte(
                        new Long(((BigDecimal)operacionesReclamo.getValueAt(i, "OID_BLOQUEO_IMPORTE")).longValue()));
            }
            if(operacionesReclamo.getValueAt(i, "OID_BLOQUEO_DIFERENCIA")!=null) {
                dtoValidarOperacionReclamo.setOidBloqueoDiferencia(
                        new Long(((BigDecimal)operacionesReclamo.getValueAt(i, "OID_BLOQUEO_DIFERENCIA")).longValue()));
            }
            if(operacionesReclamo.getValueAt(i, "OID_BLOQUEO_ANTERIOR")!=null) {
                dtoValidarOperacionReclamo.setOidBloqueoAnterior(
                        new Long(((BigDecimal)operacionesReclamo.getValueAt(i, "OID_BLOQUEO_ANTERIOR")).longValue()));
            }
            if(operacionesReclamo.getValueAt(i, "OID_MOTIVO_BLOQUEO")!=null) {
                dtoValidarOperacionReclamo.setOidMotivoBloqueo(
                        new Long(((BigDecimal)operacionesReclamo.getValueAt(i, "OID_MOTIVO_BLOQUEO")).longValue()));
            }
            if(operacionesReclamo.getValueAt(i, "OID_TIPO_OPERACION")!=null) {
                dtoValidarOperacionReclamo.setOidTipoOperacion(
                        new Long(((BigDecimal)operacionesReclamo.getValueAt(i, "OID_TIPO_OPERACION")).longValue()));
            }
            if(operacionesReclamo.getValueAt(i, "OID_PRECIO_PERDIDA")!=null) {
                dtoValidarOperacionReclamo.setOidPrecioPerdida(
                        new Long(((BigDecimal)operacionesReclamo.getValueAt(i, "OID_PRECIO_PERDIDA")).longValue()));
            }
            if(operacionesReclamo.getValueAt(i, "PORCENTAJE_PERDIDA")!=null) {
                dtoValidarOperacionReclamo.setPorcentajePerdida(
                        (BigDecimal)operacionesReclamo.getValueAt(i, "PORCENTAJE_PERDIDA"));
            }
            // a los 2 valores siguientes de la operacion no se les daba valor
            // tampoco se obtenian de la SQL de DAORec.obtenerOperacionesReclamoDigitado
            // los campos necesarios
            if(operacionesReclamo.getValueAt(i, "ENVIA_GENERA_DEVUELVE") != null) {
                valorBooleano = ((BigDecimal)operacionesReclamo.getValueAt(i, "ENVIA_GENERA_DEVUELVE")).intValue();
                if (valorBooleano == 1) {
                  dtoValidarOperacionReclamo.setEnviaGeneraDevuelve(true);
                } else {
                  dtoValidarOperacionReclamo.setEnviaGeneraDevuelve(false); 
                }
            }
            if(operacionesReclamo.getValueAt(i, "DEVUELVE_GENERA_ENVIA") != null) {
                valorBooleano = ((BigDecimal)operacionesReclamo.getValueAt(i, "DEVUELVE_GENERA_ENVIA")).intValue();
                if (valorBooleano == 1) {
                  dtoValidarOperacionReclamo.setDevuelveGeneraEnvia(true);
                } else {
                  dtoValidarOperacionReclamo.setDevuelveGeneraEnvia(false); 
                }
            }

            //añadido por incidencia 15177
            if(operacionesReclamo.getValueAt(i, "OID_PRECIO")!=null) {
                dtoValidarOperacionReclamo.setOidPrecio(
                        new Long(((BigDecimal)operacionesReclamo.getValueAt(i, "OID_PRECIO")).longValue()));
            }
            
            //añadido por incidencia 22963 mamontie 05/04/06
            if(operacionesReclamo.getValueAt(i, "COD_OPERACION")!=null) {
                dtoValidarOperacionReclamo.setCodigoOperacion(
                        (String)operacionesReclamo.getValueAt(i, "COD_OPERACION"));
            }
            
            
            // Valida la operacion
            dtoValidarOperacionReclamo = (DTOValidarOperacionReclamo) this.validarUnaOperacion(dtoValidarOperacionReclamo, reclamo);

            // Si una de las operaciones se valida correctamente, el reclamo es válido
            if(dtoValidarOperacionReclamo.getError()==false){
                reclamo.setError(false);

                // Añade la operación al reclamo
                operaciones.add(dtoValidarOperacionReclamo);
            } 
        }
        
        reclamo.setOperaciones(operaciones);        
        
        UtilidadesLog.info("MONValidarReclamos.validarOperaciones(DTOValidarReclamo):Salida");
        return reclamo;
    }

    // A falta de que se construya el entity operacionDigitada
    private DTOValidarOperacionReclamo validarUnaOperacion(DTOValidarOperacionReclamo operacion, DTOValidarReclamo reclamo) throws MareException {
        // Realiza las validaciones de una operación del reclamo
        UtilidadesLog.info("MONValidarReclamos.validarUnaOperacion(DTOValidarOperacionReclamo , DTOValidarReclamo):Entrada");
        UtilidadesLog.debug("DTOValidarOperacionReclamo: "+operacion);
        UtilidadesLog.debug("DTOValidarReclamo: "+reclamo);
        
        // MAMONTIE comentado por inc 21982 porque se esta perdiendo el estado del error operacion.setError(false);
        
        // Se valida la cabecera de la operación
        if(operacion.getPerdida() == true){
            // Si la operacion es de perdida y no hay responsable, falla la operación
            if ((operacion.getOidResponsablePerdida() == null)){
                UtilidadesLog.debug("*** No hay responsable para la operacion de perdida");
                operacion.setError(true);
                this.operacionError(operacion, reclamo);
                return operacion;
            }

        // Si el seguro asume la pérdida, el artículo y el monto no pueden ser nulos
            if(operacion.getOidAsumePerdida()!= null){
                if(operacion.getOidAsumePerdida().longValue() == ConstantesREC.ASUME_SEGURO.longValue()) {
                    UtilidadesLog.debug("*** Asume Perdida");
                    if((operacion.getOidArticulo() == null)||(operacion.getMontoPerdida() == null)||
                        (operacion.getOidClienteSeguro() == null)) {
                        UtilidadesLog.debug("***Articulo y Monto son NULOS");
                        operacion.setError(true);
                        this.operacionError(operacion, reclamo);
                        return operacion;
                    }
                }
            }
        }

        // Si la operación es de anulación, generamos las lineas de operación de forma automática
        if(operacion.getAnulacion() == true) {
            UtilidadesLog.debug("**** Operacion es de Anulacion");
            operacion = this.generarOperacionAnulacion(operacion, reclamo);
        } else {
            // Valida las lineas de operacion
            UtilidadesLog.debug("***Operacion no es de Anulacion, se validan las lineas");
            operacion = this.validarLineasOperacion(operacion, reclamo);
        }

        // Si las lineas de la operación son correctas, se completa la información de la misma
        if(operacion.getError() != true) {
            UtilidadesLog.debug("*** Lineas de la operacion correctas");
            operacion = this.completarOperacion(operacion);
        }else{
            // Si una de las lineas no es valida, se anula la operación
            //comentado por MDOLCE 16-01-06
            //operacion.setError(Boolean.TRUE.booleanValue());            
            this.operacionError(operacion,reclamo);
            return operacion;
        }

        // La operación es correcta y actualizamos el estado de la operación digitada
        OperacionReclamoDigitadoLocalHome operacionReclamoDigitadoLH = new OperacionReclamoDigitadoLocalHome();
        OperacionReclamoDigitadoLocal operacionReclamoDigitadoLocal = null;
        
        try {
            operacionReclamoDigitadoLocal = operacionReclamoDigitadoLH.findByPrimaryKey(operacion.getOidOperacion());
        } catch (NoResultException e){
            String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            ctx.setRollbackOnly();
            UtilidadesLog.error("MONValidarReclamos.validarUnaOperacion: Finder en operacionReclamoDigitado", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }catch(PersistenceException e) {
               ctx.setRollbackOnly();
               String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
               throw new MareException(e, UtilidadesError.armarCodigoError(error));
            }   

        operacionReclamoDigitadoLocal.setEstadoOperacion(ConstantesREC.ESTADO_OPERACION_INGRESADO);
        operacionReclamoDigitadoLH.merge(operacionReclamoDigitadoLocal);
        UtilidadesLog.debug("Se actualiza eli estado de la operacion a INGRESADO");
        UtilidadesLog.info("MONValidarReclamos.validarUnaOperacion(DTOValidarOperacionReclamo , DTOValidarReclamo):Salida");

        return operacion;
    }

    // Pendiente de la BELC300014873
    private DTOValidacionDocumento validarDocumentoReferencia(RecordSet documentos) throws MareException { 
        //Incidencia BELC300021984
        // Valida el documento de referencia del reclamo 
        UtilidadesLog.info("MONValidarReclamos.validarDocumentoReferencia(RecordSet):Entrada"); 

        // Si se recupera un único documento, es correcto 
        // Si no, nos quedamos con el que tenga Canal="VD", Acceso="GZ" y Subacceso="000" 
        // En caso contrario, error 
        //boolean error = false; 
        DTOValidacionDocumento dtoValidacionDocumento = new DTOValidacionDocumento();
        // Si no se obtienen documentos, falla la validación 
        if( documentos.esVacio() || documentos.getRowCount() == 0) { 
            dtoValidacionDocumento.setError(Boolean.TRUE);; 
        } else { 
            if(documentos.getRowCount() > 1) { 
                UtilidadesLog.debug("Hay documentos"); 
                //jrivas 5/9/2005 
                //CAMBIO REC-N041 
                String canal; 
                String acceso; 
                String subacceso; 
                Long indSolicitudNegativa;
                for (int i = 0; i < documentos.getRowCount(); i++ ) { 
                    canal = (String) documentos.getValueAt(i,"COD_CANAL"); 
                    acceso = (String) documentos.getValueAt(i,"COD_ACCESO"); 
                    subacceso = (String) documentos.getValueAt(i,"COD_SUBACCESO"); 
                    indSolicitudNegativa = new Long(documentos.getValueAt(i, "IND_SOLICITUD_NEGATIVA").toString());
                    // No se encuentran ConstantesSEG.ACCESO_GZ y ConstantesSEG.SUBACCESO_000. BELC300014873 
                    /*if (!(canal.equals(ConstantesSEG.CANAL_VD) && acceso.equals(ConstantesSEG.ACCESO_GZ) && 
                          subacceso.equals(ConstantesSEG.SUBACCESO_000)))   { 
                        UtilidadesLog.debug("antes de sacar " + documentos); 
                        documentos.removeRow(i); 
                        UtilidadesLog.debug("despues de sacar " + documentos); 
                    } */
                    //mamontie 30/11/05
                    //Incidencia BELC300021324
                    dtoValidacionDocumento.setError(Boolean.TRUE);
                    /*if ((canal.equals(ConstantesSEG.COD_CANAL_VD) && acceso.equals(ConstantesSEG.ACCESO_GZ) && 
                          subacceso.equals(ConstantesSEG.SUBACCESO_000)) || documentos.getRowCount()==1 ) {
                          dtoValidacionDocumento.setPosicion(new Integer(i));
                          dtoValidacionDocumento.setError(Boolean.FALSE);
                    } 
                    if(documentos.getRowCount() == 0) { 
                        // error = true; 
                        //mamontie 30/11/05
                        //Incidencia BELC300021324
                        dtoValidacionDocumento.setError(Boolean.TRUE);
                    } */
                    
                    
                    if (canal.equals(ConstantesSEG.COD_CANAL_VD) && acceso.equals(ConstantesSEG.ACCESO_GZ) && 
                          subacceso.equals(ConstantesSEG.SUBACCESO_000) &&
                          indSolicitudNegativa.equals(ConstantesREC.IND_SOLICITUD_NEGATIVA_FALSE)) {
                          dtoValidacionDocumento.setPosicion(new Integer(i));
                          dtoValidacionDocumento.setError(Boolean.FALSE);
                    } 
                } 
        }else{
            dtoValidacionDocumento.setPosicion(new Integer(0));
            Long indSolicitudNegativa = new Long(documentos.getValueAt(0, "IND_SOLICITUD_NEGATIVA").toString());
            if (indSolicitudNegativa.equals(ConstantesREC.IND_SOLICITUD_NEGATIVA_TRUE)){
                dtoValidacionDocumento.setError(Boolean.TRUE);
            } else{
                dtoValidacionDocumento.setError(Boolean.FALSE);
            }
        } 
    } 
        UtilidadesLog.info("MONValidarReclamos.validarDocumentoReferencia(RecordSet):Salida");  
        return dtoValidacionDocumento; 
    }




    private DTOValidarLineaReclamo[] obtenerLineasDigitadas(Long oidOperacion) throws MareException{
    UtilidadesLog.debug(" DTOValidarLineaReclamo[] obtenerLineasDigitadas(Long oidOperacion)  entrada");

    /*
     *Incidencia 21982 mamontie 27/03/06
     * Se agrega este metodo para aquellos casos en que se digita un codigo de venta que no se encuentran factura
     * */
    DTOValidarLineaReclamo[] dtoValidarLineaReclamoArr =null;
    
     try{
            LineaOperacionReclamoDigitadoLocalHome linOperacionLH = new LineaOperacionReclamoDigitadoLocalHome();
            Collection lineasOperacionDevuelve =linOperacionLH.findByOidOperacionReclamoDigitado(oidOperacion);
            UtilidadesLog.debug("obtenerLineasDigitadas  1");
            dtoValidarLineaReclamoArr = new DTOValidarLineaReclamo[lineasOperacionDevuelve.size()];
            DTOValidarLineaReclamo dtoValidarLineaReclamo = new DTOValidarLineaReclamo();
            UtilidadesLog.debug("obtenerLineasDigitadas  2");
            Iterator iLineasOperacionDevuelve = lineasOperacionDevuelve.iterator();
            LineaOperacionReclamoDigitadoLocal lineaOperacion = null;
            int i=0;
           
             while (iLineasOperacionDevuelve.hasNext()){                
                dtoValidarLineaReclamo = new DTOValidarLineaReclamo();                 
                lineaOperacion = (LineaOperacionReclamoDigitadoLocal)iLineasOperacionDevuelve.next();                 
                dtoValidarLineaReclamo.setOidLineaOperacion(lineaOperacion.getOid());
                dtoValidarLineaReclamo.setNumeroLinea(lineaOperacion.getNumeroLinea());
                dtoValidarLineaReclamo.setOidOperacion(lineaOperacion.getOperacion());                 
                dtoValidarLineaReclamo.setCodigoVenta(lineaOperacion.getCodigoVenta()!=null?lineaOperacion.getCodigoVenta().toString():"");
                dtoValidarLineaReclamo.setUnidadesReclamadas(lineaOperacion.getUnidadesReclamadas());                 
                dtoValidarLineaReclamo.setUnidadesDevueltas(lineaOperacion.getUnidadesDevueltas()==null?new Integer(0):lineaOperacion.getUnidadesDevueltas());
                dtoValidarLineaReclamo.setOidTipoMovimiento(lineaOperacion.getTipoMovimiento());
                dtoValidarLineaReclamo.setOidMotivoDevolucion(lineaOperacion.getMotivoDevolucion());                 
                dtoValidarLineaReclamoArr[i] = dtoValidarLineaReclamo;
                i++;
             }
            UtilidadesLog.debug(" DTOValidarLineaReclamo[] obtenerLineasDigitadas(Long oidOperacion)  salida");      
              
    
       }catch (NoResultException e){
               String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
               UtilidadesLog.error("MONValidarReclamos.validarLineasOperacion: FinderException en operacionReclamoDigitadoLH.findByReclamoTipoMovimiento", e);
                ctx.setRollbackOnly();
               throw new MareException(e, UtilidadesError.armarCodigoError(error));
       }catch(PersistenceException e) {
               ctx.setRollbackOnly();
               String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
               throw new MareException(e, UtilidadesError.armarCodigoError(error));
            }   catch (Exception ex){
               UtilidadesLog.error("MONValidarReclamos.validarLineasOperacion: Exception", ex);
       }
      return dtoValidarLineaReclamoArr;
    }

    // Pendiente de la BELC300014894, BELC300014902, 14875
    //Inc 21982 mamontie 27/03/06
    private DTOValidarOperacionReclamo validarLineasOperacion(DTOValidarOperacionReclamo operacion, DTOValidarReclamo reclamo) throws MareException {
        // Valida las lineas de la operacion recibida
        UtilidadesLog.info("MONValidarReclamos.validarLineasOperacion(DTOValidarOperacionReclamo , DTOValidarReclamo):Entrada"); 

        
        try {
            // Obtiene el número de lineas de tipo "devuelve" para la operación
            LineaOperacionReclamoDigitadoLocalHome lineaOperacionLH = new LineaOperacionReclamoDigitadoLocalHome();
            Collection lineasOperacionDevuelve = new Vector(lineaOperacionLH.findByOperacionTipoMovimiento(
                                            operacion.getOidOperacion(), 
                                            ConstantesREC.TIPO_MOVIMIENTO_DEVUELVE));
                                            
            operacion.setNumeroLineasDevuelve(new Integer(lineasOperacionDevuelve.size()));
        } catch (NoResultException e){
            String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            ctx.setRollbackOnly();
            UtilidadesLog.error("MONValidarReclamos.validarLineasOperacion: FinderException en operacionReclamoDigitadoLH.findByReclamoTipoMovimiento", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }catch(PersistenceException e) {
               ctx.setRollbackOnly();
               String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
               throw new MareException(e, UtilidadesError.armarCodigoError(error));
            }   

        /* mamontie 27/03/06 Incidencia 21982 */
        //obtiene las lineas digitadas para la operacion tratada
        UtilidadesLog.debug("antes de llamar a obtenerLineasDigitadas");
        DTOValidarLineaReclamo[] dtoValidarLineaReclamoDig =  (DTOValidarLineaReclamo[])obtenerLineasDigitadas(operacion.getOidOperacion());
       /* fin 21982*/
        // Obtiene las lineas
        UtilidadesLog.debug(" 1 ");
        DAORec daoRec = new DAORec();
        RecordSet lineasEnSolicitud = daoRec.obtenerLineasOperacion(
                                        operacion.getOidOperacion(), reclamo.getOidDocumentoReferencia());
        UtilidadesLog.debug(" 2 ");
        int tamaño = lineasEnSolicitud.getRowCount();                                        
        DTOValidarLineaReclamo dtoValidarLineaReclamo = null;
        ArrayList dtos = new ArrayList();
        operacion.setLineas(dtos);
        UtilidadesLog.debug(" 3 **** " + dtoValidarLineaReclamoDig);
        /*inc 21982 
         * valida si existe el producto en la factura
        */
         boolean existe=false;
         ArrayList oidLinea = new ArrayList();
         Long oidOperacionRs = null;
         UtilidadesLog.debug(" 4 ");
         for( int a=0; a<dtoValidarLineaReclamoDig.length; a++  ){ 
              existe =false;    
              UtilidadesLog.debug(" 5 ");
              for(int i=0; i<tamaño; i++) {
                  oidOperacionRs = new Long(((BigDecimal)lineasEnSolicitud.getValueAt(i,"OID_LINEA_OPERACION")).longValue());
                  if(dtoValidarLineaReclamoDig[a].getOidLineaOperacion().equals(oidOperacionRs)  ){
                        UtilidadesLog.debug(" 6 ");
                        UtilidadesLog.debug(" ******  iguales  ******");
                        existe = true;                        
                        dtoValidarLineaReclamo = new DTOValidarLineaReclamo();
                        
                        if(lineasEnSolicitud.getValueAt(i,"OID_LINEA_OPERACION")!=null) {
                            dtoValidarLineaReclamo.setOidLineaOperacion(new Long(
                                ((BigDecimal)lineasEnSolicitud.getValueAt(i,"OID_LINEA_OPERACION")).longValue()));    
                        }
                        if(lineasEnSolicitud.getValueAt(i,"NUMERO_LINEA")!=null) {
                            dtoValidarLineaReclamo.setNumeroLinea(new Integer(
                                ((BigDecimal)lineasEnSolicitud.getValueAt(i,"NUMERO_LINEA")).intValue()));    
                        }
                        if(lineasEnSolicitud.getValueAt(i,"OID_OPERACION")!=null) {
                            dtoValidarLineaReclamo.setOidOperacion(new Long(
                                ((BigDecimal)lineasEnSolicitud.getValueAt(i,"OID_OPERACION")).longValue()));    
                        }
                        if(lineasEnSolicitud.getValueAt(i,"CODIGO_VENTA")!=null) {
                            dtoValidarLineaReclamo.setCodigoVenta((String)lineasEnSolicitud.getValueAt(i,"CODIGO_VENTA"));    
                        }
                        if(lineasEnSolicitud.getValueAt(i,"UNIDADES_RECLAMADAS")!=null) {
                            dtoValidarLineaReclamo.setUnidadesReclamadas(new Integer(
                                ((BigDecimal)lineasEnSolicitud.getValueAt(i,"UNIDADES_RECLAMADAS")).intValue()));    
                        }
                        if(lineasEnSolicitud.getValueAt(i,"UNIDADES_DEVUELTAS")!=null) {
                            dtoValidarLineaReclamo.setUnidadesDevueltas(new Integer(
                                ((BigDecimal)lineasEnSolicitud.getValueAt(i,"UNIDADES_DEVUELTAS")).intValue()));    
                        }
                        if(lineasEnSolicitud.getValueAt(i,"OID_TIPO_MOVIMIENTO")!=null) {
                            dtoValidarLineaReclamo.setOidTipoMovimiento(new Long(
                                ((BigDecimal)lineasEnSolicitud.getValueAt(i,"OID_TIPO_MOVIMIENTO")).longValue()));    
                        }
                        if(lineasEnSolicitud.getValueAt(i,"OID_MOTIVO_DEVOLUCION")!=null) {
                            dtoValidarLineaReclamo.setOidMotivoDevolucion(new Long(
                                ((BigDecimal)lineasEnSolicitud.getValueAt(i,"OID_MOTIVO_DEVOLUCION")).longValue()));    
                        }
                        if(lineasEnSolicitud.getValueAt(i,"OID_PRODUCTO")!=null) {
                            dtoValidarLineaReclamo.setOidProducto(new Long(
                                ((BigDecimal)lineasEnSolicitud.getValueAt(i,"OID_PRODUCTO")).longValue()));    
                        }
                        if(lineasEnSolicitud.getValueAt(i,"OID_TIPO_OFERTA")!=null) {
                            dtoValidarLineaReclamo.setOidTipoOferta(new Long(
                                ((BigDecimal)lineasEnSolicitud.getValueAt(i,"OID_TIPO_OFERTA")).longValue()));    
                        }
                        if(lineasEnSolicitud.getValueAt(i,"PRECIO_CATALOGO_UNITARIO_LOCAL")!=null) {
                            dtoValidarLineaReclamo.setPrecioCatalogoUnitarioLocal(
                                (BigDecimal)lineasEnSolicitud.getValueAt(i,"PRECIO_CATALOGO_UNITARIO_LOCAL"));    
                        }
                        if(lineasEnSolicitud.getValueAt(i,"DESCUENTO_UNITARIO_LOCAL")!=null) {
                            dtoValidarLineaReclamo.setImporteDescuentoUnitarioLocal(
                                (BigDecimal)lineasEnSolicitud.getValueAt(i,"DESCUENTO_UNITARIO_LOCAL"));    
                        }
                        // BELC300014902
                        /*if(lineasOperacion.getValueAt(i,"OID_MF")!=null) {
                            dtoValidarLineaReclamo.setOidLineaOperacion(new Long(
                                ((BigDecimal)lineasOperacion.getValueAt(i,"OID_MF")).longValue()));    
                        }*/
                        // BELC300014902
                        if(lineasEnSolicitud.getValueAt(i,"OID_MF")!=null) {
                            dtoValidarLineaReclamo.setOidMF(new Long(
                                ((BigDecimal)lineasEnSolicitud.getValueAt(i,"OID_MF")).longValue()));    
                        }
                        if(lineasEnSolicitud.getValueAt(i,"OID_SOLI_POSI")!=null) {
                            dtoValidarLineaReclamo.setOidPosicionReferencia(new Long(
                                ((BigDecimal)lineasEnSolicitud.getValueAt(i,"OID_SOLI_POSI")).longValue()));    
                        }
                        UtilidadesLog.debug("antes de llamar a validarUnaLinea cuando el producto existe en factura");
                        // Valida la linea
                        dtoValidarLineaReclamo = this.validarUnaLinea(dtoValidarLineaReclamo, operacion, reclamo);
            
                        // Si una de las lineas no es valida, se anula la operación
                        if(dtoValidarLineaReclamo.getError() == true) {
                            operacion.setError(true);
                            return operacion;
                        } else {
                            // Añade la linea a la operación
                            dtos.add(dtoValidarLineaReclamo);
                        }
                             
                        //sale del for del rs porque encontro el oid
                        i=tamaño+1;
              
                  }//if donde compara solic con linea digitada
              }
              UtilidadesLog.debug(" 7 " + existe);
              if(!existe){
                     UtilidadesLog.debug(" *** if(!existe) ****");
                     //significa que el producto no esta en factura
                     // Valida la linea
                      dtoValidarLineaReclamo = this.validarUnaLinea(dtoValidarLineaReclamoDig[a], operacion, reclamo);
                      UtilidadesLog.debug(" 8 " + dtoValidarLineaReclamo );
                      // Si una de las lineas no es valida, se anula la operación
                      if(dtoValidarLineaReclamo.getError() == true) {
                          UtilidadesLog.debug(" *** if(!existe) con error ****");
                          operacion.setError(true);
                          return operacion;
                      } else {
                          UtilidadesLog.debug(" *** if(!existe) sin error ****");
                          // Añade la linea a la operación
                          dtos.add(dtoValidarLineaReclamo);
                      }
              }
         }
         /* FIN valida si existe el producto en la factura */
                        
         UtilidadesLog.info("MONValidarReclamos.validarLineasOperacion(DTOValidarOperacionReclamo , DTOValidarReclamo):Salida");
         return operacion;
    }

    // BELC300014880
    private DTOValidarLineaReclamo validarUnaLinea(DTOValidarLineaReclamo linea, DTOValidarOperacionReclamo operacion, DTOValidarReclamo reclamo) throws MareException {
        // Valida una linea de operación
        UtilidadesLog.info("MONValidarReclamos.validarUnaLinea(DTOValidarLineaReclamo , DTOValidarOperacionReclamo , DTOValidarReclamo):Entrada");

        // Si la linea es valida y estaba en la solicitud, completa sus datos
        if(linea.getOidProducto() != null) {
            linea = this.completarLinea(linea, operacion);
        } else {
            
            // El producto no estaba en la solicitud
            if(operacion.getDevuelveFisicoFactura() == false) {
                // Validar que la operación tiene 2 lineas de tipo "Devuelve"
                if(operacion.getNumeroLineasDevuelve().intValue() != 2) {
                    linea.setError(true);
                    UtilidadesLog.info(" validarUnaLinea  **  operacion.getNumeroLineasDevuelve() <> 2 ");
                    return linea;
                } else {
                
                    UtilidadesLog.debug("else");
                
                    // incidencia BELC300018807 y remodificado poir 15177
                    linea = this.buscarPrecioLinea(linea, reclamo,operacion.getOidPrecio());
                    
                    UtilidadesLog.debug("linea.getOidPosicionReferencia(): " + linea.getOidPosicionReferencia());
                    UtilidadesLog.debug("linea.getOidTipoMovimiento(): " + linea.getOidTipoMovimiento());
                    
                    if (linea.getOidPosicionReferencia() == null 
                            && linea.getOidTipoMovimiento().longValue() 
                            == ConstantesREC.TIPO_MOVIMIENTO_DEVUELVE.longValue()){
                            
                            UtilidadesLog.debug("Asignacion de ceros");
                            
                        linea.setPrecio(new BigDecimal(0.0));
                        linea.setImporteAbono(new BigDecimal(0.0));
                    }
                    UtilidadesLog.info("validarUnaLinea  **  operacion.getNumeroLineasDevuelve() = 2  ");
                    return linea;
            }
            } else {
                // operacion.devuelveFisicoFactura == true
                if(linea.getOidTipoMovimiento().longValue() == ConstantesREC.TIPO_MOVIMIENTO_DEVUELVE.longValue()
                        && operacion.getDevuelveEnFactura() == true) {
                    linea.setError(true);
                    UtilidadesLog.info("validarUnaLinea  ***   operacion.devuelveFisicoFactura == true ***  DEVUELVE");
                    return linea;
                }
                if(linea.getOidTipoMovimiento().longValue() == ConstantesREC.TIPO_MOVIMIENTO_ENVIA.longValue()
                        && operacion.getEnviaEnFactura() == true) {
                    linea.setError(true);
                    UtilidadesLog.info("MONValidarReclamos.validarUnaLinea  ** ENVIA ");
                    return linea;
                }
            }

            // Calcula el precio de la linea      eliminada por incidencia 15177 
            //se vuelve  a poner la inc 21982
            linea = this.buscarPrecioLinea(linea, reclamo, operacion.getOidPrecio());
        }

        UtilidadesLog.info("MONValidarReclamos.validarUnaLinea(DTOValidarLineaReclamo , DTOValidarOperacionReclamo , DTOValidarReclamo):Salida");
        return linea;
    }

    private DTOValidarLineaReclamo completarLinea(DTOValidarLineaReclamo linea, DTOValidarOperacionReclamo operacion) throws MareException {
        // Calcula el precio de la linea
        UtilidadesLog.info("MONValidarReclamos.completarLinea(DTOValidarLineaReclamo , DTOValidarOperacionReclamo):Entrada");
        UtilidadesLog.debug("DTOValidarLineaReclamo linea: " + linea);
        UtilidadesLog.debug("DTOValidarOperacionReclamo operacion: " + operacion);

        if(operacion.getOidPrecioEnvia() != null && operacion.getOidPrecioEnvia().longValue() == ConstantesREC.PRECIO_ENVIA_FACTURA.longValue()) {
           if(linea.getImporteDescuentoUnitarioLocal()!=null){
            linea.setPrecio(new BigDecimal(
                linea.getPrecioCatalogoUnitarioLocal().doubleValue() - 
                linea.getImporteDescuentoUnitarioLocal().doubleValue()));
           }else{
             linea.setPrecio(new BigDecimal(
                linea.getPrecioCatalogoUnitarioLocal().doubleValue()));
           }
        } else {
            // operacion.oidPrecioEnvia == ConstantesREC.PRECIO_ENVIA_CATALOGO
            linea.setPrecio(new BigDecimal(linea.getPrecioCatalogoUnitarioLocal().doubleValue()));
        }

        // Calcula los importes de cargo o abono
        if(linea.getOidTipoMovimiento().longValue() == ConstantesREC.TIPO_MOVIMIENTO_ENVIA.longValue()) {
            linea.setImporteCargo(new BigDecimal(
                linea.getPrecio().doubleValue() * linea.getUnidadesReclamadas().doubleValue()));
                
        } else {
            // linea.oidTipoMovimiento == ConstantesREC.TIPO_MOVIMIENTO_DEVUELVE
            linea.setImporteAbono(new BigDecimal(
                linea.getPrecio().doubleValue() * linea.getUnidadesReclamadas().doubleValue()));
                
        }

        UtilidadesLog.info("MONValidarReclamos.completarLinea(DTOValidarLineaReclamo , DTOValidarOperacionReclamo):Salida");
        return linea;
    }
    
    
    private void operacionError(DTOValidarOperacionReclamo operacion, DTOValidarReclamo reclamo) throws MareException {
        // Actualiza el estado de la operación a "Error" y genera un log de error con los datos del mismo
        UtilidadesLog.info("operacionError(DTOValidarOperacionReclamo operacion, DTOValidarReclamo reclamo):Entrada");
        
        // Actualiza el estado de la operación
      // this.actualizarEstadoOperacion(operacion.getOidOperacion(), ConstantesREC.ESTADO_OPERACION_ERROR);//REC-08 mamontie 15/12/05

        // Escribe el log de error
        // Utilizar el servicio APPLoggingService para generar un log de error:
        
        StringBuffer error = new StringBuffer("");
        error.append("["+this.REC+"] ["+this.CU+"] codigoPais="+reclamo.getCodigoPais());
        error.append(", fechaIngreso= "+reclamo.getFechaIngreso()+", numeroReclamo= "+reclamo.getNumeroReclamo());        
        error.append(", codigoCliente "+reclamo.getCodigoCliente());
        error.append(", numeroDocumentoReferencia= "+reclamo.getNumeroDocumentoRefrencia());
        error.append(", codigoOperacion= "+operacion.getCodigoOperacion());
        LogAPP.info(error.toString());
        UtilidadesLog.info("operacionError(DTOValidarOperacionReclamo operacion, DTOValidarReclamo reclamo):Salida");
    }

    private void actualizarEstadoReclamo(Long oidReclamo, Long oidEstado) throws MareException {
        // Actualiza el estado de un reclamo y sus operaciones
        UtilidadesLog.info("MONValidarReclamos.actualizarEstadoReclamo(Long , Long):Entrada");

        // Actualiza el estado de la cabecera
        CabeceraReclamoDigitadoLocalHome cabeceraReclamoDigitadoLH =new CabeceraReclamoDigitadoLocalHome();
        CabeceraReclamoDigitadoLocal cabeceraReclamoDigitadoLocal = null;
        
        try { 
            cabeceraReclamoDigitadoLocal = cabeceraReclamoDigitadoLH.findByPrimaryKey(oidReclamo);
        } catch (NoResultException e) {
            String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            ctx.setRollbackOnly();
            UtilidadesLog.error("MONValidarReclamos.actualizarEstadoReclamo: FinderException en cabeceraReclamoDigitado: "+oidReclamo, e);
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }catch(PersistenceException e) {
               ctx.setRollbackOnly();
               String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
               throw new MareException(e, UtilidadesError.armarCodigoError(error));
            }   

        cabeceraReclamoDigitadoLocal.setEstado(oidEstado);
        cabeceraReclamoDigitadoLH.merge(cabeceraReclamoDigitadoLocal);
        // Actualiza el estado de las operaciones
        OperacionReclamoDigitadoLocalHome operacionReclamoDigitadoLH = new OperacionReclamoDigitadoLocalHome();
        OperacionReclamoDigitadoLocal operacionReclamoDigitadoLocal = null;
        Vector operacionesReclamoDigitado = null;
        
        try { 
            // No se encuentra operacionReclamoDigitadoLH.findByUK(reclamo.oidReclamo)
            operacionesReclamoDigitado = new Vector(operacionReclamoDigitadoLH.findByReclamo(oidReclamo));
        } catch (NoResultException e) {
            String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            ctx.setRollbackOnly();
            UtilidadesLog.error("MONValidarReclamos.actualizarEstadoReclamo: FinderException en operacionReclamoDigitadoLH.findByUK(oidReclamo): "+oidReclamo, e);
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }catch(PersistenceException e) {
               ctx.setRollbackOnly();
               String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
               throw new MareException(e, UtilidadesError.armarCodigoError(error));
            }   
        
        int tamaño = operacionesReclamoDigitado.size();
        
        for(int i = 0; i<tamaño; i++) {
            operacionReclamoDigitadoLocal = (OperacionReclamoDigitadoLocal) operacionesReclamoDigitado.get(i);
           
           //REC-08 mamontie 18/12/05
            if(oidEstado.equals( ConstantesREC.ESTADO_RECLAMO_ERROR )){
              operacionReclamoDigitadoLocal.setEstadoOperacion(ConstantesREC.ESTADO_OPERACION_ERROR);
            }else{
              operacionReclamoDigitadoLocal.setEstadoOperacion(oidEstado);
            }
            operacionReclamoDigitadoLH.merge(operacionReclamoDigitadoLocal);
        }

        UtilidadesLog.info("MONValidarReclamos.actualizarEstadoReclamo(Long , Long):Salida");
    }

    private void actualizarEstadoOperacion(Long oidOperacion, Long oidEstado) throws MareException {
        // Actualiza el estado de una operación
        UtilidadesLog.info("MONValidarReclamos.actualizarEstadoOperacion(Long , Long):Entrada");

        OperacionReclamoDigitadoLocalHome operacionReclamoDigitadoLH = new OperacionReclamoDigitadoLocalHome();
        OperacionReclamoDigitadoLocal operacionReclamoDigitadoLocal = null;
        
        try { 
            operacionReclamoDigitadoLocal = operacionReclamoDigitadoLH.findByPrimaryKey(oidOperacion);
        } catch (NoResultException e) {
            String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            ctx.setRollbackOnly();
            UtilidadesLog.error("MONValidarReclamos.actualizarEstadoOperacion: FinderException en OperacionReclamoDigitadoLocal: "+oidOperacion, e);
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }catch(PersistenceException e) {
               ctx.setRollbackOnly();
               String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
               throw new MareException(e, UtilidadesError.armarCodigoError(error));
            }   

        operacionReclamoDigitadoLocal.setEstadoOperacion(oidEstado);  
        operacionReclamoDigitadoLH.merge(operacionReclamoDigitadoLocal);

        UtilidadesLog.info("MONValidarReclamos.actualizarEstadoOperacion(Long , Long):Salida");
    }

    private DTOValidarOperacionReclamo completarOperacion(DTOValidarOperacionReclamo operacion) throws MareException {
        // Completa los datos de la operación
        UtilidadesLog.info("MONValidarReclamos.completarOperacion(DTOValidarOperacionReclamo):Entrada");
        // Se valida la cabecera de la operación
        if(operacion.getPerdida() == true) {
            // Si el cliente asume la pérdida, se calcula el monto de pérdida
            if(operacion.getOidAsumePerdida() != null && operacion.getOidAsumePerdida().longValue() == ConstantesREC.ASUME_CLIENTE.longValue()) {
                operacion = this.calcularMontoPerdida(operacion);
            }
        }
        UtilidadesLog.info("MONValidarReclamos.completarOperacion(DTOValidarOperacionReclamo):Salida");
        return operacion;
    }

    // BELC300014909, BELC300014939
    private DTOValidarOperacionReclamo calcularMontoPerdida(DTOValidarOperacionReclamo operacion) throws MareException {
        UtilidadesLog.info("MONValidarReclamos.calcularMontoPerdida(DTOValidarOperacionReclamo):Salida");

        ArrayList lineas = operacion.getLineas();
        ArrayList temp = new ArrayList();
        int tamaño = lineas.size();
        DTOValidarLineaReclamo dtoLinea = null;
        
        for(int i = 0; i<tamaño; i++) {
            dtoLinea = (DTOValidarLineaReclamo)lineas.get(i);

            float precioCatalogo = dtoLinea.getPrecioCatalogoUnitarioLocal() != null ?
                                dtoLinea.getPrecioCatalogoUnitarioLocal().floatValue() : 0;
            float unidadesReclamadas = dtoLinea.getUnidadesReclamadas() != null ?
                                    dtoLinea.getUnidadesReclamadas().floatValue() : 0;
            float descuentoUnitario = dtoLinea.getImporteDescuentoUnitarioLocal() != null ?
                                    dtoLinea.getImporteDescuentoUnitarioLocal().floatValue() : 0;
            float porcentajePerdida = operacion.getPorcentajePerdida() != null ?
                                    operacion.getPorcentajePerdida().floatValue() : 0;
            if(operacion.getOidPrecioPerdida().longValue() == ConstantesREC.PRECIO_PERDIDA_CATALOGO.longValue()) {
                dtoLinea.setOidPrecioPerdida(new Long(operacion.getOidPrecioPerdida().longValue()));
                
                 /*Se quita por incidencia BELC300022756
                dtoLinea.setMontoPerdida(new BigDecimal(precioCatalogo * unidadesReclamadas));*/
                dtoLinea.setMontoPerdida(new BigDecimal(precioCatalogo));
                        
            } else {
                // operacion.oidPrecioPerdida != ConstantesREC.PRECIO_PERDIDA_CATALOGO
                dtoLinea.setOidPrecioPerdida(new Long(operacion.getOidPrecioPerdida().longValue()));
                // No se encuentra la propiedad montoPerdida BELC300014939
                 /*Se quita por incidencia BELC300022756
                  * dtoLinea.setMontoPerdida(new BigDecimal(
                        (precioCatalogo - descuentoUnitario) * unidadesReclamadas));*/                       
                        
                 dtoLinea.setMontoPerdida(new BigDecimal((precioCatalogo - descuentoUnitario)));       
            }

            // Aplicamos el porcentaje de recargo
            // BELC300019516
            dtoLinea.setMontoPerdida(new BigDecimal(dtoLinea.getMontoPerdida().floatValue() * (1 + porcentajePerdida / 100))); 

            // Guardamos la linea en el ArrayList
            temp.add(dtoLinea);
        }

        operacion.setLineas(temp);
        UtilidadesLog.info("MONValidarReclamos.calcularMontoPerdida(DTOValidarOperacionReclamo):Salida");

        return operacion;
    }

    // BELC300014954, BELC300014949
    private DTOValidarReclamo generarNumeroAtencion(DTOValidarReclamo reclamo) throws MareException {
        // Llamamos a CU Generar Número Documento
        UtilidadesLog.info("MONValidarReclamos.generarNumeroAtencion(DTOValidarReclamo):Entrada");

        // hay que poner incidencia
        // cambio indicado a fmarting por correo el 26/05/2005
        DTONumeroSolicitud dtoNumeroSolicitud = new DTONumeroSolicitud();
        dtoNumeroSolicitud.setOidCanal(null);
        dtoNumeroSolicitud.setOidAcceso(null);
        dtoNumeroSolicitud.setOidSubacceso(null);
        dtoNumeroSolicitud.setOidPais(new Long(reclamo.getOidPais().longValue()));
        // BELC300014949 
        dtoNumeroSolicitud.setOperacion(ConstantesBEL.COD_REC034);

        // Obtiene el número de solicitud (MONProcesoPED)
        MONProcesosPED monProcesoPed = this.getMONProcesosPED();
        // BELC300014954 
        try{
            reclamo.setNumeroAtencion(new Long(monProcesoPed.generaNumeroDocumento(dtoNumeroSolicitud)));
        } catch (RemoteException e){
            ctx.setRollbackOnly();
            String error = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }

        UtilidadesLog.info("MONValidarReclamos.generarNumeroAtencion(DTOValidarReclamo):Salida");
        return reclamo;
    }

    private DTOValidarReclamo guardarReclamo(DTOValidarReclamo reclamo) throws MareException {
        // Guarda los datos de un reclamo digitado y validado correctamente
        UtilidadesLog.info("MONValidarReclamos.guardarReclamo(DTOValidarReclamo):Entrada");
        UtilidadesLog.debug("*** DTOValidarReclamo: "+reclamo);

        // Genera el número de atención del reclamo
        reclamo = this.generarNumeroAtencion(reclamo);

        // Actualizamos el estado del reclamo digitado
        CabeceraReclamoDigitadoLocalHome cabeceraReclamoDigitadoLH = new CabeceraReclamoDigitadoLocalHome();
        CabeceraReclamoDigitadoLocal cabeceraReclamoDigitadoLocal = null;
        
        try {
            cabeceraReclamoDigitadoLocal = cabeceraReclamoDigitadoLH.findByPrimaryKey(reclamo.getOidReclamo());
        } catch(NoResultException e) {
            String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }catch(PersistenceException e) {
               ctx.setRollbackOnly();
               String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
               throw new MareException(e, UtilidadesError.armarCodigoError(error));
            }   

        cabeceraReclamoDigitadoLocal.setEstado(ConstantesREC.ESTADO_RECLAMO_INGRESADO);
        cabeceraReclamoDigitadoLH.merge(cabeceraReclamoDigitadoLocal);
        // Guarda la cabecera del reclamo
        reclamo = this.guardarCabeceraReclamo(reclamo);

        // Guarda las operaciones del reclamo
        reclamo = this.guardarOperacionesReclamo(reclamo);

        // BELC300019480
        // Calcula el importe del reclamo
        //this.calcularImporteReclamo(reclamo.getOidReclamo());

        UtilidadesLog.info("MONValidarReclamos.guardarReclamo(DTOValidarReclamo):Salida");
        return reclamo;
    }

    // BELC300014954, BELC300014956, BELC300018867
    private DTOValidarReclamo guardarCabeceraReclamo(DTOValidarReclamo reclamo) throws MareException {
        // Guarda la cabecera del reclamo 
        UtilidadesLog.info("MONValidarReclamos.guardarCabeceraReclamo(DTOValidarReclamo):Entrada");
        UtilidadesLog.debug("*** DTOValidarReclamo: "+reclamo);

        CabeceraReclamoLocalHome cabeceraReclamoLH = new CabeceraReclamoLocalHome();
        CabeceraReclamoLocal cabeceraReclamoLocal = null;
        
        UtilidadesLog.debug("*** DTOValidarReclamo antes del create: " + reclamo);
        
        // Aún no restá el número de atención en el reclamo. BELC300014954
        // BELC300018591
        Long numReclamo = reclamo.getNumeroReclamo();
        if (numReclamo == null) numReclamo = reclamo.getNumeroAtencion();
        
        try {
            cabeceraReclamoLocal = cabeceraReclamoLH.create(reclamo.getNumeroAtencion(), //numeroAtencion, 
                                                            numReclamo, // numeroReclamo, 
                                                            reclamo.getOidPais(),//pais
                                                            reclamo.getOidDocumentoReferencia(), //numeroDocumentoReferencia, 
                                                            reclamo.getOidPeriodoSolicitud(),// periodoDocumentoReferencia, 
                                                            reclamo.getOidCliente(), // cliente, 
                                                            reclamo.getOidPeriodoReclamo(), // periodoReclamo, 
                                                            reclamo.getOidTipoCliente(), // subTipoCliente, 
                                                            reclamo.getOidTipoDocumentoLegal(),// tipoDocumento, 
                                                            reclamo.getEstado(),// estadoReclamo, 
                                                            reclamo.getOidTipoCliente());// tipoCliente);
                                    
        } catch (PersistenceException e){
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            /*try {
                u.rollback();
            } catch (SystemException ex) {
                ex.printStackTrace();
            }*/
            String error = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        cabeceraReclamoLocal.setFechaDocumentoReferencia((java.sql.Date)reclamo.getFechaEmision());
        cabeceraReclamoLocal.setUsuarioIngreso(reclamo.getCodigoUsuario());
        cabeceraReclamoLocal.setFechaIngreso((java.sql.Date)reclamo.getFechaIngreso());
        cabeceraReclamoLocal.setSubTipoCliente(reclamo.getOidSubtipoCliente());
        cabeceraReclamoLocal.setTipoIngreso(reclamo.getOidTipoIngreso());
        cabeceraReclamoLocal.setUnidadAdministrativaCliente(reclamo.getOidTerritorioAdm());
        cabeceraReclamoLH.merge(cabeceraReclamoLocal);
        
    
        reclamo.setOidReclamo(cabeceraReclamoLocal.getOid());
        
        UtilidadesLog.info("MONValidarReclamos.guardarCabeceraReclamo(DTOValidarReclamo):Salida");
        return reclamo;
    }

    // Falta un valor para el create del entity BELC300014977. Resuelto con el script BELCORP_03_722
    private DTOValidarReclamo guardarOperacionesReclamo(DTOValidarReclamo reclamo) throws MareException {
        // Guarda las operaciones del reclamo digitado 
        UtilidadesLog.info("MONValidarReclamos.guardarOperacionesReclamo(DTOValidarReclamo):Entrada");
        UtilidadesLog.debug("*** DTOValidarReclamo: "+reclamo);
  
        ArrayList operaciones = reclamo.getOperaciones();
        int tamanio = operaciones != null ? operaciones.size() : 0;
        DTOValidarOperacionReclamo dtoValidarOperacion = null;
        
        OperacionReclamoLocalHome operacionReclamoLH = new OperacionReclamoLocalHome();
        OperacionReclamoLocal operacionReclamoLocal = null;
        
        UtilidadesLog.debug("*****Tamanio array Operaciones: "+tamanio);
        for(int i = 0; i<tamanio; i++) {
            UtilidadesLog.debug("****Entra en el for con lo que hay operaciones y va a crearla");
            dtoValidarOperacion = (DTOValidarOperacionReclamo)operaciones.get(i);

            try {
                operacionReclamoLocal = operacionReclamoLH.create(
                                            dtoValidarOperacion.getNumeroOperacion(),
                                            reclamo.getOidReclamo(), 
//                                            new Long(1), //motivorechazo no encontrado. BELC300014977
                                            reclamo.getOidPeriodoReclamo(), 
                                            dtoValidarOperacion.getOidTipoOperacion(), //diseño dice que viene de reclamo
                                            reclamo.getOidDocumentoReferencia());
            } catch (PersistenceException e) {
                UtilidadesLog.error(e);
                ctx.setRollbackOnly();
                /*try {
                    u.rollback();
                } catch (SystemException ex) {
                    ex.printStackTrace();
                }*/
                String error = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
                throw new MareException(e, UtilidadesError.armarCodigoError(error));
            }
         
            if(dtoValidarOperacion.getMontoPerdida()!=null) {
                operacionReclamoLocal.setMontoPerdida(dtoValidarOperacion.getMontoPerdida());
            }
            if(dtoValidarOperacion.getPorcentajePerdida()!=null) {
                operacionReclamoLocal.setPorcentajePerdida(new Double(
                                            dtoValidarOperacion.getPorcentajePerdida().doubleValue()));
            }
            if(dtoValidarOperacion.getOidPrecioPerdida()!=null) {
                operacionReclamoLocal.setPrecioPerdida(dtoValidarOperacion.getOidPrecioPerdida());
            }
            if(dtoValidarOperacion.getOidAsumePerdida()!=null) {
                operacionReclamoLocal.setAsumePerdida(dtoValidarOperacion.getOidAsumePerdida());
            }
            if(dtoValidarOperacion.getOidArticulo()!=null) {
                operacionReclamoLocal.setArticulo(dtoValidarOperacion.getOidArticulo());
            }
            if(dtoValidarOperacion.getOidClienteSeguro()!=null) {
                operacionReclamoLocal.setClienteSeguro(dtoValidarOperacion.getOidClienteSeguro());
            }
            /*if(reclamo.getOidDocumentoReferencia()!=null) {
                operacionReclamoLocal.setDocumentoReferencia(reclamo.getOidDocumentoReferencia());
            }*/
            if(dtoValidarOperacion.getOidResponsablePerdida()!=null) {
                operacionReclamoLocal.setResponsablePerdida(dtoValidarOperacion.getOidResponsablePerdida());
            }
            operacionReclamoLocal.setEstadoOperacion(ConstantesREC.ESTADO_OPERACION_INGRESADO);
            operacionReclamoLH.merge(operacionReclamoLocal);
            
            dtoValidarOperacion.setOidOperacion(new Long(operacionReclamoLocal.getOid().longValue()));

            // Guarda las lineas de la operación
            dtoValidarOperacion = this.guardarLineasOperacionReclamo(dtoValidarOperacion);

            // Inserta la operación en el ArrayList
            //reclamo.operaciones.set(posicion, operacion)
            // antes se hacia un add y se juntaban las nueva operaciones a las del reclamo digitado
            operaciones.set(i, dtoValidarOperacion);
        }
        reclamo.setOperaciones(operaciones);

        UtilidadesLog.info("MONValidarReclamos.guardarOperacionesReclamo(DTOValidarReclamo):Salida");
        return reclamo;
    }

    // BELC300014990
    private DTOValidarOperacionReclamo guardarLineasOperacionReclamo(DTOValidarOperacionReclamo operacion) throws MareException {
        // Guarda las lineas de la operación recibida
        UtilidadesLog.info("MONValidarReclamos.guardarLineasOperacionReclamo(DTOValidarOperacionReclamo):Entrada");

        ArrayList lineas = operacion.getLineas();
        ArrayList arrayTempo = new ArrayList();
        DTOValidarLineaReclamo dtoValidarLinea = null;
        int tamanio = lineas != null ? lineas.size() : 0;
        
        LineasOperacionReclamoLocalHome lineasOperacionLH = new LineasOperacionReclamoLocalHome();
        LineasOperacionReclamoLocal lineasOperacionLocal = null;
        
        UtilidadesLog.debug("Tamaño lineas: "+lineas);
        for(int i = 0; i<tamanio; i++) {
            UtilidadesLog.debug("Entra en el for con lo que hay lineas y las crea");
            dtoValidarLinea = (DTOValidarLineaReclamo)lineas.get(i);

            try {
                lineasOperacionLocal = lineasOperacionLH.create(
                                        dtoValidarLinea.getNumeroLinea(),
                                        operacion.getOidOperacion(),
                                        dtoValidarLinea.getOidTipoOferta(),
                                        null, // falta: por incidencia BELC300014990 tipoPosicion dejara de ser obligatorio. Deben corregir BBDD
                                        dtoValidarLinea.getOidTipoMovimiento(),
                                        dtoValidarLinea.getOidMotivoDevolucion());
            } catch (PersistenceException e) {
                UtilidadesLog.error(e);
                ctx.setRollbackOnly();
                /*try {
                    u.rollback();
                } catch (SystemException ex) {
                    ex.printStackTrace();
                }*/
                String error = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
                throw new MareException(e, UtilidadesError.armarCodigoError(error));
            }
            
            if(dtoValidarLinea.getUnidadesReclamadas()!=null) {
                lineasOperacionLocal.setUnidadesReclamadas(dtoValidarLinea.getUnidadesReclamadas());
            }
            if(dtoValidarLinea.getPrecio()!=null) {
                lineasOperacionLocal.setPrecio(dtoValidarLinea.getPrecio());
            }
            if(dtoValidarLinea.getImporteAbono()!=null) {
                lineasOperacionLocal.setImporteAbono(dtoValidarLinea.getImporteAbono());
            }
            if(dtoValidarLinea.getImporteCargo()!=null) {
                lineasOperacionLocal.setImporteCargo(dtoValidarLinea.getImporteCargo());
            }
            if(dtoValidarLinea.getUnidadesDevueltas()!=null) {
                lineasOperacionLocal.setNumeroUnidadesDevueltas(dtoValidarLinea.getUnidadesDevueltas());
            }
            if(dtoValidarLinea.getOidProducto()!=null) {
                lineasOperacionLocal.setProducto(dtoValidarLinea.getOidProducto());
            }
            // BELC300014990
            if(dtoValidarLinea.getOidMF()!=null) {
                lineasOperacionLocal.setCodigoVenta(dtoValidarLinea.getOidMF());
            }
            // BELC300014990
            if(dtoValidarLinea.getMontoPerdida()!=null) {
                lineasOperacionLocal.setMontoPerdida(dtoValidarLinea.getMontoPerdida());
            }
            // BELC300014990
            if(dtoValidarLinea.getOidPrecioPerdida()!=null) {
                lineasOperacionLocal.setPrecioPerdida(dtoValidarLinea.getOidPrecioPerdida());
            }
            lineasOperacionLocal.setIndicadorEstado(new Character(
                                            ConstantesREC.ESTADO_LINEA_INGRESADO.charAt(0)));
            
            if(dtoValidarLinea.getOidPosicionReferencia()!=null && 
                    dtoValidarLinea.getOidTipoMovimiento().equals(ConstantesREC.TIPO_MOVIMIENTO_DEVUELVE)) {
                lineasOperacionLocal.setPosicionReferencia(dtoValidarLinea.getOidPosicionReferencia());
            } 
                                            
            dtoValidarLinea.setOidLineaOperacion(new Long(lineasOperacionLocal.getOid().longValue()));
            lineasOperacionLH.merge(lineasOperacionLocal);
            // BELC300019153
            dtoValidarLinea.setOidOperacion(operacion.getOidOperacion());

            arrayTempo.add(dtoValidarLinea);
        }

        operacion.setLineas(arrayTempo);
        
        UtilidadesLog.info("MONValidarReclamos.guardarLineasOperacionReclamo(DTOValidarOperacionReclamo):Salida");
        return operacion;
    }

    private void calcularImporteReclamo(Long oidReclamo) throws MareException {
        // Obtiene y actualiza el importe del reclamo recibido 
        UtilidadesLog.info("MONValidarReclamos.calcularImporteReclamo(Long):Entrada");
        UtilidadesLog.debug("**** oidReclamo: " + oidReclamo);
        DAORec dao = new DAORec();
        RecordSet importes = new RecordSet();
        importes = dao.obtenerSaldoPagarReclamo(oidReclamo);
        BigDecimal importeCargo = (BigDecimal)importes.getValueAt(0, "IMPORTE_CARGO");
        BigDecimal importeAbono = (BigDecimal)importes.getValueAt(0, "IMPORTE_ABONO");
        BigDecimal saldoPagar = (BigDecimal)importes.getValueAt(0, "SALDO_PAG");
        CabeceraReclamoLocalHome cabeceraReclamoLocalHome = new CabeceraReclamoLocalHome();
        CabeceraReclamoLocal cabeceraReclamoLocal = null;
        
        try {
        cabeceraReclamoLocal = cabeceraReclamoLocalHome.findByPrimaryKey(oidReclamo); 
        } catch(NoResultException e){
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            UtilidadesLog.error("MONValidarReclamos.validarBloqueoChequeoFisico: Finder en validarBloqueoChequeoFisico", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }catch(PersistenceException e) {
               ctx.setRollbackOnly();
               String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
               throw new MareException(e, UtilidadesError.armarCodigoError(error));
            }   
        cabeceraReclamoLocal.setTotalDevuelve(importeAbono);
        cabeceraReclamoLocal.setTotalEnvia(importeCargo);
        cabeceraReclamoLocal.setSaldoPagar(saldoPagar);
        cabeceraReclamoLocalHome.merge(cabeceraReclamoLocal);
        UtilidadesLog.info("MONValidarReclamos.calcularImporteReclamo(Long):Salida");
    }

    // BELC300014926, BELC300018882, BELC300018959
    private void generarMovimientoAlmacenReclamo(DTOValidarReclamo reclamo) throws MareException 
    {
        // Por cada linea de operación del reclamo de tipo "Devuelve" 
        //y número de unidades devueltas <> 0 se realiza su ingreso en el almacén 
        UtilidadesLog.info("MONValidarReclamos.generarMovimientoAlmacenReclamo(DTOValidarReclamo):Entrada");   

        // Obtiene las lineas del reclamo 
        DAORec dao = new DAORec(); 
        RecordSet lineas = dao.obtenerLineasMovimientoAlmacen(reclamo);
    
        if (!lineas.esVacio()) {
            DTOMovimientoAlmacenCabecera cabeceraMovimientoAlmacen = this.crearDTOMovimientoAlmacenCabecera(reclamo);
        
            //Recorre el ArrayList lineas utilizando el contador num 
            //BELC300014926
            ArrayList detalle = new ArrayList();
            DTOMovimientoAlmacenDetalle detalleAlmacen = null;
            
            for (int num=0; num < lineas.getRowCount(); num++){    
                detalleAlmacen = this.crearDTOMovimientoAlmacenDetalle(lineas, num);
                //Ver incidencia BELC300014926
                detalle.add(detalleAlmacen);
            }   
            
            DTOMovimientoAlmacen dtoAlmacen = new DTOMovimientoAlmacen();
            dtoAlmacen.setCabecera(cabeceraMovimientoAlmacen);
            dtoAlmacen.setDetalle(detalle); 
            dtoAlmacen.setOidIdioma(reclamo.getOidIdioma());
            dtoAlmacen.setOidPais(reclamo.getOidPais());
            
            UtilidadesLog.debug("****** DTOMovimientoAlmacen: " + dtoAlmacen);
            
            MONGenerarMovimientoAlmacen mon = this.getMONGenerarMovimientoAlmacen();
            DTOReportePedidos dto = null;
    
            // Solicita la reserva de almacén 
            try{
                dto = mon.grabarMovimientoAlmacenYStock(dtoAlmacen); 
            }catch(RemoteException e){
                UtilidadesLog.error(e);
                ctx.setRollbackOnly();
                String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                UtilidadesLog.error("MONCapturaProcesoReclamos.buscarPrecioLinea: RemoteException", e);
                throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));      
            }
        }

        UtilidadesLog.info("MONValidarReclamos.generarMovimientoAlmacenReclamo(DTOValidarReclamo):Salida");      
    }

    private DTOMovimientoAlmacenCabecera crearDTOMovimientoAlmacenCabecera(DTOValidarReclamo reclamo) throws MareException {
        // Crea la estructura necesaria para realizar la reserva de almacén 
        UtilidadesLog.info("MONValidarReclamos.crearDTOMovimientoAlmacenCabecera(DTOValidarReclamo):Entrada");   
        // Crea la cabecera del movimiento 
        DTOMovimientoAlmacenCabecera dto = new DTOMovimientoAlmacenCabecera();
        dto.setOidPais(reclamo.getOidPais());
        dto.setFecha(new Date(System.currentTimeMillis()));
        dto.setOidMarca(reclamo.getOidMarca());
        dto.setOidCanal(reclamo.getOidCanal());
        dto.setOidAcceso(reclamo.getOidAcceso());
        dto.setOidSubacceso(reclamo.getOidSubacceso());
        dto.setOidPeriodo(reclamo.getOidPeriodoReclamo());
        UtilidadesLog.info("MONValidarReclamos.crearDTOMovimientoAlmacenCabecera(DTOValidarReclamo):Salida");   
        //Devuelve DTOMovimientoAlmacenCabecera
        return dto;
    }

    private DTOMovimientoAlmacenDetalle crearDTOMovimientoAlmacenDetalle(RecordSet lineas, int num) throws MareException {
    // Genera un DTOMovimientoAlmacenDetalle para el registro del RecordSet lineas indicado por el valor num 
        UtilidadesLog.info("MONValidarReclamos.crearDTOMovimientoAlmacenDetalle(RecordSet , int):Entrada");    
        DTOMovimientoAlmacenDetalle dto= new DTOMovimientoAlmacenDetalle();
        
        if(lineas.getValueAt(num,"IND_RECO").toString().equals("0")){
          if (lineas.getValueAt(num,"OID_ALMACEN")!= null){
          dto.setOidAlmacenSalida(new Long(((BigDecimal)lineas.getValueAt(num,"OID_ALMACEN")).longValue())); 
          }
          if (lineas.getValueAt(num,"OID_TIPO_MOVIMIENTO_ALMACEN")!= null){
              dto.setOidTipoMovimientoAlmacen(new Long(((BigDecimal)lineas.getValueAt(num,"OID_TIPO_MOVIMIENTO_ALMACEN")).longValue()));
          }
          dto.setOperacion(ConstantesBEL.COD_REC046);
        }else{
          if (lineas.getValueAt(num,"ALMC_OID_ALMA_POSV")!= null){
          dto.setOidAlmacenSalida(new Long(((BigDecimal)lineas.getValueAt(num,"ALMC_OID_ALMA_POSV")).longValue())); 
          }
          if (lineas.getValueAt(num,"TMAL_OID_TIPO_ALMA_REC_INIC")!= null){
              dto.setOidTipoMovimientoAlmacen(new Long(((BigDecimal)lineas.getValueAt(num,"TMAL_OID_TIPO_ALMA_REC_INIC")).longValue()));
          }
          dto.setOperacion(ConstantesBEL.COD_REC058);
        }        
        if (lineas.getValueAt(num,"OID_PRODUCTO") != null){
            dto.setOidProducto(new Long(((BigDecimal)lineas.getValueAt(num,"OID_PRODUCTO")).longValue()));
        }
        if (lineas.getValueAt(num,"OID_TIPO_OFERTA") != null){ 
            dto.setOidTipoOferta(new Long(((BigDecimal)lineas.getValueAt(num,"OID_TIPO_OFERTA")).longValue()));
        }
        if (lineas.getValueAt(num,"UNIDADES_DEVUELTAS") != null) {
            dto.setCantidad(new Long(((BigDecimal)lineas.getValueAt(num,"UNIDADES_DEVUELTAS")).longValue())); 
        }
        UtilidadesLog.info("MONValidarReclamos.crearDTOMovimientoAlmacenDetalle(RecordSet , int):Salida");       
        return dto;
    }

    private DTOValidarReclamo validarBloqueoChequeoFisico(DTOValidarReclamo reclamo) throws MareException {
        // Valida el bloqueo por chequeo físico      
        //Ver incidenca
        UtilidadesLog.info("MONValidarReclamos.validarBloqueoChequeoFisico(DTOValidarReclamo):Entrada");       
        
        CabeceraReclamoLocal cabecReclaLocal = null;
        
        DTOValidarOperacionReclamo operacion = null;
        boolean validarBloqueo = false;
        if (reclamo.getEstado() != ConstantesREC.ESTADO_RECLAMO_BLOQUEADO ){ 
            //Recorre el ArrayList reclamo.operaciones utilizando el contador pos 
            for (int i = 0; i < reclamo.getOperaciones().size() && validarBloqueo == false; i++){ 
                operacion = ((DTOValidarOperacionReclamo )(reclamo.getOperaciones()).get(i)); 
            
                if (operacion.getOidMotivoBloqueo() != null){ 
                    validarBloqueo = true;
                } 
            } 
    
            UtilidadesLog.debug("validarBloqueo: " + validarBloqueo);
    
            if (validarBloqueo == true){ 
                ResultadosChequeoLocalHome resultadosChequeoLocalHome =new ResultadosChequeoLocalHome();
                ResultadosChequeoLocal resultadosChequeoLocal = null;
                try {
                    UtilidadesLog.debug("Se busca con: " + reclamo.getOidResultadoChequeo());
                    resultadosChequeoLocal = resultadosChequeoLocalHome.findByPrimaryKey(reclamo.getOidResultadoChequeo());
                    UtilidadesLog.debug("Termino busqueda");
                }catch(NoResultException e){
                    String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
                    ctx.setRollbackOnly();
                    UtilidadesLog.error("MONValidarReclamos.validarBloqueoChequeoFisico: Finder en validarBloqueoChequeoFisico", e);
                    throw new MareException(e, UtilidadesError.armarCodigoError(error));
                }catch(PersistenceException e) {
               ctx.setRollbackOnly();
               String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
               throw new MareException(e, UtilidadesError.armarCodigoError(error));
            }   
                if (resultadosChequeoLocal.getIndicativoResultado() == Boolean.TRUE ){ 
                
                    UtilidadesLog.debug("Entra a condicion para asignar");
                
                    // Bloquea el reclamo 
                    //reclamo.setEstado(ConstantesREC.ESTADO_RECLAMO_BLOQUEADO);
                     CabeceraReclamoLocalHome crLH =new CabeceraReclamoLocalHome();
                    try {
                        cabecReclaLocal = crLH.findByPrimaryKey(reclamo.getOidReclamo());    
                    } catch (NoResultException e){
                        String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
                        ctx.setRollbackOnly();
                        UtilidadesLog.error("MONValidarReclamos.validarBloqueosReclamo: Finder en CabeceraReclamo", e);
                        throw new MareException(e, UtilidadesError.armarCodigoError(error));
                    }catch(PersistenceException e) {
               ctx.setRollbackOnly();
               String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
               throw new MareException(e, UtilidadesError.armarCodigoError(error));
            }   
                    
                    cabecReclaLocal.setEstadoReclamo(ConstantesREC.ESTADO_RECLAMO_BLOQUEADO);
                    cabecReclaLocal.setMotivoBloqueo(operacion.getOidMotivoBloqueo());
                    crLH.merge(cabecReclaLocal);
                    reclamo.setEstado(ConstantesREC.ESTADO_RECLAMO_BLOQUEADO);
                    
                    UtilidadesLog.debug("Asigno estado bloqueado");
                } 
            } 
        } 
        //Devuelve reclamo
        UtilidadesLog.info("MONValidarReclamos.validarBloqueoChequeoFisico(DTOValidarReclamo):Salida");          
        return reclamo;
    }
     private MONMantenimientoMF getMONMantenimientoMF() throws MareException {
        // Se obtiene el interfaz home
                                        
        MONMantenimientoMFHome home = (MONMantenimientoMFHome)UtilidadesEJB.getHome(
            "MONMantenimientoMF", MONMantenimientoMFHome.class);
            
        // Se obtiene el interfaz remoto
        MONMantenimientoMF ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
            UtilidadesLog.error("*** Error en getMONMantenimientoMF",e);
            ctx.setRollbackOnly();
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
        return ejb;
    }
    
    //modificado por incidencia 15177
    private DTOValidarLineaReclamo buscarPrecioLinea(DTOValidarLineaReclamo linea, DTOValidarReclamo reclamo, Long oidPrecio) throws MareException {
        // Accede al módulo de Precios para obtener el precio de la linea recibida 
        UtilidadesLog.info("MONValidarReclamos.buscarPrecioLinea(DTOValidarLineaReclamo , DTOValidarReclamo , Long):Entrada");
        
        if (oidPrecio.longValue() == ConstantesREC.PRECIO_PRECIOS.longValue()){
        
            UtilidadesLog.debug("a - oidPrecio.longValue() == ConstantesREC.PRECIO_PRECIOS.longValue()");
        
            DTOBuscarCodigoVentaPeriodo dto = new DTOBuscarCodigoVentaPeriodo();
            dto.setOidPais(reclamo.getOidPais());
            dto.setPeriodo(reclamo.getOidPeriodoSolicitud()); //inc.BELC300022734
            dto.setCodigoVenta(linea.getCodigoVenta());
            DTOSalida dtoSalida = new DTOSalida();
            MONMantenimientoMF mon = this.getMONMantenimientoMF();
            try{
            dtoSalida = mon.buscarCodigoVentaPeriodo(dto); // MONMantenimientoMF 
            }catch(RemoteException e){
                String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                ctx.setRollbackOnly();
                UtilidadesLog.error("MONCapturaProcesoReclamos.buscarPrecioLinea: RemoteException", e);
                throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));    
            }catch(MareException e){ 
                UtilidadesLog.info(" MareException Sete el error de la linea por codigoVenta periodo no existe");               
            }
            
            if (dtoSalida != null || !dtoSalida.getResultado().esVacio()){
            
                UtilidadesLog.debug("dtoSalida vacio");
            
                // Obtiene el oidDetalleOferta. 
                Long oidDetalleOferta = new Long(((BigDecimal)dtoSalida.getResultado().getValueAt(0,0)).longValue());
                // Accede a la entidad DetalleOferta para recuperar los datos requeridos 
           
                 DetalleOfertaLocalHome detalleOfertaLocalHome = new DetalleOfertaLocalHome();
                 DetalleOfertaLocal detalleOfertaLocal = null;
                 try {
                        UtilidadesLog.debug("detalleOfertaLocalHome.findByPrimaryKey(oidDetalleOferta) " + oidDetalleOferta );   
                        detalleOfertaLocal = detalleOfertaLocalHome.findByPrimaryKey(oidDetalleOferta);
                        UtilidadesLog.debug("detalleOfertaLocalHome.findByPrimaryKey(oidDetalleOferta) " + detalleOfertaLocal );   
                 }catch(NoResultException e) {
                        String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
                     ctx.setRollbackOnly();
                        UtilidadesLog.error("MONValidarReclamos.buscarPrecioLinea: Finder en buscarPrecioLinea", e);
                        throw new MareException(e, UtilidadesError.armarCodigoError(error));
                 }catch(PersistenceException e) {
               ctx.setRollbackOnly();
               String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
               throw new MareException(e, UtilidadesError.armarCodigoError(error));
            }   
                 
                // Actualizo los datos de la linea 
                if(dtoSalida.getResultado().getValueAt(0,4)!=null){
                    linea.setOidMF(new Long(((BigDecimal)dtoSalida.getResultado().getValueAt(0,4)).longValue()));
                }
                
                UtilidadesLog.debug("detalleOfertaLocal.oid: " + detalleOfertaLocal.getOid());
                UtilidadesLog.debug("detalleOfertaLocal.precioCatalogo: " + detalleOfertaLocal.getPrecioCatalogo());
                
                linea.setOidTipoOferta(detalleOfertaLocal.getOidTipoOfer());
                linea.setOidProducto(detalleOfertaLocal.getOidProd());
                linea.setPrecio(detalleOfertaLocal.getPrecioCatalogo()!=null?detalleOfertaLocal.getPrecioCatalogo():new BigDecimal(0)); 
        }else { //No se encontro el producto
        

        
                // Modificado por incidencia 15177
                // Busca el precio en Incentivos 
                //linea.setPrecio(this.buscarProductoIncentivos(reclamo.getOidConcursoParametros(),linea.getCodigoVenta()));
                linea.setError(true);
                UtilidadesLog.info("MONValidarReclamos.buscarPrecioLinea(DTOValidarLineaReclamo , DTOValidarReclamo , Long):Salida");
                return linea;
            } 
        }else{
        
            UtilidadesLog.debug("a - else");
        
            //añadido else por incidencia 15177
            if (oidPrecio.longValue() == ConstantesREC.PRECIO_PREMIOS.longValue()){
            
                UtilidadesLog.debug("Premios");
            
                // Busca el precio en Incentivos 
                DTOPrecioReclamo dtoPrecioReclamo = this.buscarProductoIncentivos(reclamo.getOidConcursoParametros(),linea.getCodigoVenta());
                if ( linea.getOidProducto() != null){
                    linea.setPrecio(dtoPrecioReclamo.getPrecioPublico());
                    linea.setOidProducto(dtoPrecioReclamo.getOidProducto());
                }else{
                    linea.setError(true);
                    UtilidadesLog.info("MONValidarReclamos.buscarPrecioLinea(DTOValidarLineaReclamo , DTOValidarReclamo , Long):Salida");
                    return linea;
                }
            }
        }

        UtilidadesLog.debug("Tipo movimiento: " + linea.getOidTipoMovimiento());
        UtilidadesLog.debug("Precio: " + linea.getPrecio());
        UtilidadesLog.debug("Unidaddes Reclamadas: " + linea.getUnidadesReclamadas());
        UtilidadesLog.debug("Unidades Devueltas: " + linea.getUnidadesDevueltas());

        if (linea.getOidTipoMovimiento().longValue() == ConstantesREC.TIPO_MOVIMIENTO_ENVIA.longValue()){ 
            UtilidadesLog.debug("Entro por tipo mov. envia");
            //linea.setImporteCargo((linea.getPrecio()).multiply(linea.getUnidadesDevueltas()==null?new BigDecimal(0):new BigDecimal(linea.getUnidadesDevueltas().doubleValue())));
            
            linea.setImporteCargo(linea.getPrecio().multiply(linea.getUnidadesReclamadas() == null ? new BigDecimal(0) : new BigDecimal(linea.getUnidadesReclamadas().doubleValue())));
            
        } else {// linea.tipoMovimiento == ConstantesREC.TIPO_MOVIMIENTO_DEVUELVE 
            UtilidadesLog.debug("Entro por tipo mov. devuelve");
            linea.setImporteAbono((linea.getPrecio()).multiply(new BigDecimal(linea.getUnidadesReclamadas().doubleValue())));
        }
        
        // incidencia BELC300018807
        if (linea.getOidProducto() == null) {
            linea.setError(true);
        }
        
        UtilidadesLog.debug("linea: " + linea);
        
        UtilidadesLog.info("MONValidarReclamos.buscarPrecioLinea(DTOValidarLineaReclamo , DTOValidarReclamo , Long):Salida");   
        return linea;
    }
    private MONPedidosSolicitud getMONPedidosSolicitud() throws MareException {
        // Se obtiene el interfaz home
                                                
        MONPedidosSolicitudHome home = (MONPedidosSolicitudHome)UtilidadesEJB.getHome(
            "MONPedidosSolicitud", MONPedidosSolicitudHome.class);
            
        // Se obtiene el interfaz remoto
        MONPedidosSolicitud ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
                                   UtilidadesLog.error("*** Error en getMONPedidosSolicitud",e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
        
        return ejb;
    }


    // BELC300014882 -> se envio a cdos BELC300014706 
    private DTOValidarOperacionReclamo generarOperacionAnulacion(DTOValidarOperacionReclamo operacion, DTOValidarReclamo reclamo) throws MareException {
    // Si la operación es de anulación, generamos las lineas de operación de forma automática 
        // Obtenemos las posiciones del documento de referencia del reclamo 
        UtilidadesLog.info("MONValidarReclamos.generarOperacionAnulacion(DTOValidarOperacionReclamo , DTOValidarReclamo):Salida"); 
        DTOOID dto = new DTOOID();
        // BELC300018951
        dto.setOid(reclamo.getOidDocumentoReferencia());
        DTOSalida dtoSalida = new DTOSalida();
        MONPedidosSolicitud mon = this.getMONPedidosSolicitud();
        try {
        dtoSalida =  mon.obtenerPosicionesReclamo(dto); // MONPedidosSolicitud 
        }catch(RemoteException e){
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            ctx.setRollbackOnly();
            UtilidadesLog.error("MONCapturaProcesoReclamos.generarOperacionAnulacion: RemoteException", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));      
        }
        
        //Recorre el RecordSet DTOSalida.resultado utilizando el contador fila 
        DTOValidarLineaReclamo dtoValida = null;
        ArrayList arrayLineas = new ArrayList();
        
        // BELC300018954
        int numeroLinea = 0;
        
        Integer unidadesAtendidas = null;
        
        for (int i=0;i<dtoSalida.getResultado().getRowCount();i++){ 
            dtoValida = new DTOValidarLineaReclamo();
            
            dtoValida.setOidTipoMovimiento(ConstantesREC.TIPO_MOVIMIENTO_DEVUELVE);
            dtoValida.setCodigoVenta((String)dtoSalida.getResultado().getValueAt(i,"CODIGO_VENTA"));//Conprobar el campo cuando este construido

            // el UNIDADES_ATENDIDAS no es obligatorio
            unidadesAtendidas = null;
            if (dtoSalida.getResultado().getValueAt(i,"UNIDADES_ATENDIDAS") != null) {
                unidadesAtendidas = new Integer(((BigDecimal)dtoSalida.getResultado().getValueAt(i,"UNIDADES_ATENDIDAS")).intValue());
            }
            dtoValida.setUnidadesReclamadas(unidadesAtendidas);
            dtoValida.setUnidadesDevueltas(unidadesAtendidas);
            
            // BELC300018954
            dtoValida.setNumeroLinea(new Integer(++numeroLinea));            
            
            // BELC300019016
            dtoValida.setOidProducto(new Long(((BigDecimal)dtoSalida.getResultado().getValueAt(i, "OID_PRODUCTO")).longValue()));

            // Añade la linea a la operación 
            //ArrayList array = operacion.getLineas();
            arrayLineas.add(dtoValida);
        } 
        operacion.setLineas(arrayLineas);

        UtilidadesLog.info("MONValidarReclamos.generarOperacionAnulacion(DTOValidarOperacionReclamo , DTOValidarReclamo):Salida");    
        return operacion;
    }

    //Falta BELC300014879 puesta depsuesn en la BELC300014887
    private DTOPrecioReclamo buscarProductoIncentivos(Long concurso, String cv) throws MareException {
      // Busca el precio del producto en el modulo INC 
      UtilidadesLog.info("MONValidarReclamos.buscarProductoIncentivos(Long , String):Entrada");    
        DTOPrecioReclamo dto = new DTOPrecioReclamo();
        dto.setOidConcurso(concurso);
        dto.setCodigoVenta(cv);
        MONSoporteExterno mon = this.getMONSoperteExterno();
        try {
            dto = mon.obtenerPrecioReclamo(dto); // MONSoporteExterno     
        } catch (RemoteException re){
            ctx.setRollbackOnly();
            String error = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            UtilidadesLog.error(error);
            throw new MareException(re, UtilidadesError.armarCodigoError(error));
        }
        
        UtilidadesLog.info("MONValidarReclamos.buscarProductoIncentivos(Long , String):Salida");       
        //modificado retorno por incidencia 15177
        //return dto.getPrecioPublico();
        return dto;
    }

    
    private DTOValidarReclamo validarBloqueosReclamo(DTOValidarReclamo reclamo) throws MareException 
    {
        UtilidadesLog.info("MONValidarReclamos.validarBloqueosReclamo(DTOValidarReclamo):Entrada");    
        
        // Valida los posibles bloqueos del reclamo 
    
        // cabeceraReclamo = CabeceraReclamo.findByPrimaryKey(reclamo.oidReclamo) 
        CabeceraReclamoLocal cabecReclaLocal = null;
        CabeceraReclamoLocalHome CReclaLH = new CabeceraReclamoLocalHome();
        try {
            cabecReclaLocal = CReclaLH.findByPrimaryKey(reclamo.getOidReclamo());    
        } catch (NoResultException e){
            String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            ctx.setRollbackOnly();
            UtilidadesLog.error("MONValidarReclamos.validarBloqueosReclamo: Finder en CabeceraReclamo", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }catch(PersistenceException e) {
               ctx.setRollbackOnly();
               String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
               throw new MareException(e, UtilidadesError.armarCodigoError(error));
            }   

        // Trata las operaciones del reclamo 
        // Reccorre el ArrayList reclamo.operaciones utilizando el contador posicion 
        ArrayList operaciones = reclamo.getOperaciones();
        DTOValidarOperacionReclamo operacion = null;
        
        boolean bloqueado;
        
        for (int posicion = 0; posicion < operaciones.size(); posicion++) {
        
            bloqueado = false;
            
            // operacion = (DTOValidarOperacionReclamo)reclamo.operaciones.get(posicion) 
            operacion = (DTOValidarOperacionReclamo)operaciones.get(posicion);
            
            // operacion.pais = reclamo.pais 
            operacion.setOidPais(reclamo.getOidPais());
        
            //// Bloqueo por unidades 
            // Si operacion.oidBloqueoUnidades != null 
            // { 
            // bloqueado = validarBloqueoPorUnidades(operacion) 
            // } 
            if (operacion.getOidBloqueoUnidades() != null) {
                bloqueado = this.validarBloqueoPorUnidades(operacion);
            }
        
            // Bloqueo por importe 
            // Si operacion.oidBloqueoImporte != null AND bloqueado == false 
            // { 
            // bloqueado = validarBloqueoPorImporte(operacion) 
            // } 
            if (operacion.getOidBloqueoImporte() != null && bloqueado == false) {
                bloqueado = this.validarBloqueoPorImporte(operacion);
            }
            
            //// Bloqueo por diferencia 
            // Si operacion.oidBloqueoDiferencia != null AND bloqueado == false 
            // { 
            // bloqueado = validarBloqueoPorDiferencia(operacion) 
            // } 
            if (operacion.getOidBloqueoDiferencia() != null && bloqueado == false) {
                bloqueado = this.validarBloqueoPorDiferencia(operacion);
            }
        
            // Si operacion.oidBloqueoAnterior != null AND bloqueado == false 
            // { 
            // bloqueado = validarBloqueoPorReclamoAnterior(operacion) 
            // } 
            if (operacion.getOidBloqueoAnterior() != null && bloqueado == false) {
                bloqueado = this.validarBloqueoPorReclamoAnterior(reclamo.getOidDocumentoReferencia(), operacion);
            }

            
            // El reclamo tiene al menos una operación no bloqueada 
            // Se actualiza el estado del reclamo a ingresado y sin motivo de bloqueo 
            // Si bloqueado == false AND cabeceraReclamo.estadoReclamo != ConstantesREC.ESTADO_RECLAMO_INGRESADO 
            if (bloqueado == false && cabecReclaLocal.getEstadoReclamo().compareTo(ConstantesREC.ESTADO_RECLAMO_INGRESADO) != 0) {
                // cabeceraReclamo.estadoReclamo = ConstantesREC.ESTADO_RECLAMO_INGRESADO 
                // cabeceraReclamo.motivoBloqueo = null 
                cabecReclaLocal.setEstadoReclamo(ConstantesREC.ESTADO_RECLAMO_INGRESADO);
                cabecReclaLocal.setMotivoBloqueo(null);
                CReclaLH.merge(cabecReclaLocal);
            } 
        } 
        
        UtilidadesLog.info("MONValidarReclamos.validarBloqueosReclamo(DTOValidarReclamo):Salida");    
    
        // Devuelve reclamo
        return reclamo;    
    }
    /*  mamontie inc.22744 */
    private DTOValidarReclamo generarLineasAutomaticas(DTOValidarReclamo reclamo) throws MareException 
    {
        UtilidadesLog.info("MONValidarReclamos.generarLineasAutomaticas(DTOValidarReclamo):Entrada");    
        // Genera lineas de operación envia o devuelve para las operación 
        // Trata las operaciones del reclamo 
        ArrayList operaciones = reclamo.getOperaciones();

        DTOValidarOperacionReclamo operacion = null;
        Boolean anulacion = Boolean.FALSE;

        for (int i=0; i < operaciones.size(); i++) {
            operacion = (DTOValidarOperacionReclamo)operaciones.get(i);
            /* inicio 22744 */
            if( operacion.getAnulacion()){
                anulacion = Boolean.TRUE;
            }            
            /* fin 22744 */
            
            
            if (operacion.getDevuelveGeneraEnvia()) {
                this.generarEnviosAutomaticos(operacion);
            }
            
            if (operacion.getEnviaGeneraDevuelve()) {
                this.generarDevuelvesAutomaticos(operacion);
            }            
        }
        
        //inc 22744
        if(anulacion.booleanValue()){
             this.calcularImporteReclamoAnulacion(reclamo);        
        }else {
             this.calcularImporteReclamo(reclamo.getOidReclamo()); 
        }
        
        // BELC300019480
        // Calcula el importe del reclamo
       // comenteado por inc 22744  this.calcularImporteReclamo(reclamo.getOidReclamo());        

        UtilidadesLog.info("MONValidarReclamos.generarLineasAutomaticas(DTOValidarReclamo):Salida " + reclamo);   
        return reclamo;
    }

    private void generarEnviosAutomaticos(DTOValidarOperacionReclamo operacion) throws MareException 
    {
        UtilidadesLog.info("MONValidarReclamos.generarEnviosAutomaticos(DTOValidarOperacionReclamo):Entrada");   
        // Genera una linea envia por cada linea devuelve 
        // Trata las lineas de la operacion 
        ArrayList lineasOpera = operacion.getLineas();

        DTOValidarLineaReclamo linea= null;
        DTOValidarLineaReclamo lineaEnvia = null;

        int numeroLineas = lineasOpera.size();
        
        for (int i=0; i < numeroLineas ; i++) {
            linea = (DTOValidarLineaReclamo)lineasOpera.get(i);
            
            //Si linea.oidTipoMovimiento == ConstantesREC.TIPO_MOVIMIENTO_DEVUELVE 
            if (linea.getOidTipoMovimiento().compareTo(ConstantesREC.TIPO_MOVIMIENTO_DEVUELVE) == 0){
                // Genera una copia de la linea envía 
                try{
                    lineaEnvia = (DTOValidarLineaReclamo)linea.clone();
                    
                    
                    //mamontie inc bloq REC-08 18/11/2005 lineaEnvia.setNumeroLinea(new Integer(numeroLineas + i));
                    if(i==0){
                      lineaEnvia.setNumeroLinea(new Integer(linea.getNumeroLinea().intValue()+ i + 1));  
                    }else {
                      lineaEnvia.setNumeroLinea(new Integer(lineaEnvia.getNumeroLinea().intValue() + 1));  
                    }
                    //lineaEnvia.setNumeroLinea(new Integer(numeroLineas + i));
                    lineaEnvia.setOidTipoMovimiento(ConstantesREC.TIPO_MOVIMIENTO_ENVIA );
                    lineaEnvia.setImporteAbono(null);
                    lineaEnvia.setImporteCargo(linea.getImporteAbono());
                    // incidencia 19226
                    lineaEnvia.setMontoPerdida(null);
                    lineaEnvia.setOidPosicionReferencia(null);
                }catch (CloneNotSupportedException cex){
                    UtilidadesLog.error(cex);
                    ctx.setRollbackOnly();
                    UtilidadesLog.error("MONValidarReclamos.generarEnviosAutomaticos: CloneNotSupportedException", cex);
                }
                // Guarda la linea en BD 
                this.guardarLineaEnviaDevuelve(lineaEnvia);
            }
        }

        UtilidadesLog.info("MONValidarReclamos.generarEnviosAutomaticos(DTOValidarOperacionReclamo):Salida");    
    }
    
    private void guardarLineaEnviaDevuelve(DTOValidarLineaReclamo linea) throws MareException 
    {
        UtilidadesLog.info("MONValidarReclamos.guardarLineaEnviaDevuelve(DTOValidarLineaReclamo):Entrada");   
        // Graba una linea de operación del tipo envia o devuelve 
        // Guarda la linea en BD 
        /*Crea una entrada en la entidad LineasOperacionReclamo con: 
        - numeroLinea = linea.numeroLinea 
        - unidadesReclamadas = linea.unidadesReclamadas 
        - precio = linea.precio 
        - importeAbono = linea.importeAbono 
        - importeCargo = linea.importeCargo 
        - numeroUnidadesDevueltas = linea.unidadesDevueltas 
        - operacion = linea.oidOperacion 
        - tipoOferta = linea.oidTipoOferta 
        - tipoMovimiento = linea.oidTipoMovimiento 
        - producto = linea.oidProducto 
        - codigoVenta = linea.oidMF 
        - motivoDevolucion = linea.oidMotivoDevolucion 
        - montoPerdida = linea.montoPerdida 
        - precioPerdida = linea.oidPrecioPerdida 
        - indicadorEstado = ConstantesREC.ESTADO_LINEA_INGRESADO*/
        LineasOperacionReclamoLocal lineasORLocal= null;
        try{
            //mamontie REC-08 
            linea.setNumeroLinea(new Integer(linea.getNumeroLinea().intValue()+1));
            UtilidadesLog.debug( "linea.getNumeroLinea() " + linea.getNumeroLinea() );
            LineasOperacionReclamoLocalHome LORLH = new LineasOperacionReclamoLocalHome();
            lineasORLocal = LORLH.create(linea.getNumeroLinea(),
                                            linea.getOidOperacion(),
                                            linea.getOidTipoOferta(),
                                            null,//tipoPosicion
                                            linea.getOidTipoMovimiento(),
                                            linea.getOidMotivoDevolucion());
            lineasORLocal.setUnidadesReclamadas(linea.getUnidadesReclamadas());
            lineasORLocal.setPrecio(linea.getPrecio());
            lineasORLocal.setImporteAbono(linea.getImporteAbono());
            lineasORLocal.setImporteCargo(linea.getImporteCargo());
            lineasORLocal.setNumeroUnidadesDevueltas(linea.getUnidadesDevueltas());
            lineasORLocal.setProducto(linea.getOidProducto());
            lineasORLocal.setCodigoVenta(linea.getOidMF()); 
            lineasORLocal.setMontoPerdida(linea.getMontoPerdida());
            lineasORLocal.setPrecioPerdida(linea.getOidPrecioPerdida());
            lineasORLocal.setIndicadorEstado(new Character(ConstantesREC.ESTADO_LINEA_INGRESADO.charAt(0)));
            lineasORLocal.setPosicionReferencia(linea.getOidPosicionReferencia());
            LORLH.merge(lineasORLocal);
        }catch (PersistenceException cex){
            UtilidadesLog.error(cex);
            ctx.setRollbackOnly();
            String error = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
            throw new MareException(cex, UtilidadesError.armarCodigoError(error));
        }        
        UtilidadesLog.info("MONValidarReclamos.guardarLineaEnviaDevuelve(DTOValidarLineaReclamo):Salida");   
    }
    
    private boolean validarBloqueoPorUnidades(DTOValidarOperacionReclamo operacion) throws MareException 
    {
        // Valida el bloqueo por unidades de una operacion 
    
        UtilidadesLog.info("MONValidarReclamos.validarBloqueoPorUnidades(DTOValidarOperacionReclamo):Entrada");   
		
		// unidades = DAORec.obtenerUnidadesOperacion(operacion.oidOperacion) 
        RecordSet unidades = new DAORec().obtenerUnidadesOperacion(operacion.getOidOperacion());

		// unidadesReclamadas = unidades.getValueAt(0, "UNIDADES_RECLAMADAS") 
        Integer unidadesReclamadas = null;
        if (unidades.getValueAt(0, "UNIDADES_RECLAMADAS") != null) {
            unidadesReclamadas = new Integer(((BigDecimal)unidades.getValueAt(0, "UNIDADES_RECLAMADAS")).intValue());
        } else {
            unidadesReclamadas = new Integer(0);
        }
		
        // unidadesDevueltas = unidades.getValueAt(0, "UNIDADES_DEVUELTAS") 
        Integer unidadesDevueltas = null;
        if (unidades.getValueAt(0, "UNIDADES_DEVUELTAS") != null) {
            unidadesDevueltas = new Integer(((BigDecimal)unidades.getValueAt(0, "UNIDADES_DEVUELTAS")).intValue());
        } else {
            unidadesDevueltas = new Integer(0);
        }
        		
        // Si unidadesDevueltas > unidadesReclamadas 
        if (unidadesDevueltas.compareTo(unidadesReclamadas) > 0) {
			// Bloquea la operación 
			// tipoBloqueo = TiposBloqueo.findByUK(operacion.pais, ConstantesREC.BLOQUEO_UNIDADES_DEVUELTAS) 
            TiposBloqueoLocal tiposBloqLocal = null;
            try {
                tiposBloqLocal = new TiposBloqueoLocalHome().findByUK(operacion.getOidPais(), ConstantesREC.BLOQUEO_UNIDADES_DEVUELTAS);
            } catch (NoResultException e){
                String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
                ctx.setRollbackOnly();
                UtilidadesLog.error("MONValidarReclamos.validarBloqueoPorUnidades: Finder en TiposBloqueo: ", e);
                throw new MareException(e, UtilidadesError.armarCodigoError(error));
            }catch(PersistenceException e) {
               ctx.setRollbackOnly();
               String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
               throw new MareException(e, UtilidadesError.armarCodigoError(error));
            }   
            
            // operacionReclamo = Operacion.findByPrimaryKey(operacion.oidOperacion) 
            OperacionReclamoLocal operacReclamoLocal = null;
            OperacionReclamoLocalHome OpReLH = new OperacionReclamoLocalHome();
            try {
                operacReclamoLocal = OpReLH.findByPrimaryKey(operacion.getOidOperacion());
            } catch (NoResultException e){
                String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
                ctx.setRollbackOnly();
                UtilidadesLog.error("MONValidarReclamos.validarBloqueoPorUnidades: Finder en OperacionReclamo: ", e);
                throw new MareException(e, UtilidadesError.armarCodigoError(error));
            }catch(PersistenceException e) {
               ctx.setRollbackOnly();
               String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
               throw new MareException(e, UtilidadesError.armarCodigoError(error));
            }   
            
			// operacionReclamo.estadoOperacion = ConstantesREC.ESTADO_OPERACION_BLOQUEO 
			// operacionReclamo.motivoBloqueo = operacion.oidBloqueoUnidades 
			// operacionReclamo.tipoBloqueo = tipoBloqueo.oid 
            operacReclamoLocal.setEstadoOperacion(ConstantesREC.ESTADO_OPERACION_BLOQUEO);
            operacReclamoLocal.setMotivoBloqueo(operacion.getOidBloqueoUnidades());
            operacReclamoLocal.setTipoBloqueo(tiposBloqLocal.getOid());
            OpReLH.merge(operacReclamoLocal);
            
            UtilidadesLog.info("MONValidarReclamos.validarBloqueoPorUnidades(DTOValidarOperacionReclamo):Salida");   
            
            // Devuelve true 
            return true;
		} 

		// Devuelve false        
        UtilidadesLog.info("MONValidarReclamos.validarBloqueoPorUnidades(DTOValidarOperacionReclamo):Salida");   
        
        return false;
    }

    // BELC300019827
    private boolean validarBloqueoPorImporte(DTOValidarOperacionReclamo operacion) throws MareException 
    {
        UtilidadesLog.info("MONValidarReclamos.validarBloqueoPorImporte(DTOValidarOperacionReclamo):Entrada");   
        
        // Valida el bloqueo por importe de una operacion

		//// Obtiene el usuario actual 
		// usuario = Llama al método getCallerPrincipal() del contexto del EJB y obtiene el código del usuario 
        String usuario = ctx.getCallerPrincipal().getName();
        
        //Crea un DTOString con:
        //- cadena = usuario
        //- pais = operacion.pais
        DTOString dtoString = new DTOString();
        dtoString.setCadena(usuario);
        dtoString.setOidPais(operacion.getOidPais());
        
        //oidUsuario = DAORec.obtenerUsuario(DTOString)
        Integer oidUsuario = new DAORec().obtenerUsuario(dtoString);
        
        AutorizacionesLocal autorizacLocal = null;
        
		// autorizacion = Autorizaciones.findByUK(operacion.pais, operacion.oitTipoOperacion, usuario) 
        try {
            autorizacLocal = new AutorizacionesLocalHome().findByUK(operacion.getOidPais(), operacion.getOidTipoOperacion(), oidUsuario);
        } catch (NoResultException e){
            String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            ctx.setRollbackOnly();
            UtilidadesLog.error("MONValidarReclamos.validarBloqueoPorImporte: Finder en Autorizaciones: ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }catch(PersistenceException e) {
               ctx.setRollbackOnly();
               String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
               throw new MareException(e, UtilidadesError.armarCodigoError(error));
            }   

		// importes = DAORec.obtenerImporteCargo(operacion.oidOperacion) 
        RecordSet importes = new DAORec().obtenerImportesCargoAbonoOperacion(operacion.getOidOperacion());
        
		// importeCargo = importes.getValueAt(0,"IMPORTE_CARGO") 
        BigDecimal importeCargo = null;
        
        if (importes.getValueAt(0, "IMPORTE_CARGO") != null) {
            importeCargo = (BigDecimal)importes.getValueAt(0, "IMPORTE_CARGO");
        } else {
            importeCargo = new BigDecimal(0);
        }

		// Si importeCargo > autorizacion.importeMaximo { 
        if (importeCargo.compareTo(autorizacLocal.getImporteMaximo()) > 0) {
			// // Bloquea la operación 
			
            // tipoBloqueo = TiposBloqueo.findByUK(operacion.pais, ConstantesREC.BLOQUEO_IMPORTE_MAXIMO) 
            TiposBloqueoLocal tiposBloqLocal = null;
            try {
                tiposBloqLocal = new TiposBloqueoLocalHome().findByUK(operacion.getOidPais(), ConstantesREC.BLOQUEO_IMPORTE_MAXIMO);
            } catch (NoResultException e){
                String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
                ctx.setRollbackOnly();
                UtilidadesLog.error("MONValidarReclamos.validarBloqueoPorImporte: Finder en TiposBloqueo: ", e);
                throw new MareException(e, UtilidadesError.armarCodigoError(error));
            }catch(PersistenceException e) {
               ctx.setRollbackOnly();
               String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
               throw new MareException(e, UtilidadesError.armarCodigoError(error));
            }   
            
			// operacionReclamo = Operacion.findByPrimaryKey(operacion.oidOperacion) 
            OperacionReclamoLocal operacReclamoLocal = null;
            OperacionReclamoLocalHome opLH = new OperacionReclamoLocalHome();
            try {
                operacReclamoLocal = opLH.findByPrimaryKey(operacion.getOidOperacion());
            } catch (NoResultException e){
                String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
                ctx.setRollbackOnly();
                UtilidadesLog.error("MONValidarReclamos.validarBloqueoPorImporte: Finder en OperacionReclamo: ", e);
                throw new MareException(e, UtilidadesError.armarCodigoError(error));
            } catch(PersistenceException e) {
               ctx.setRollbackOnly();
               String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
               throw new MareException(e, UtilidadesError.armarCodigoError(error));
            }              
			
            // operacionReclamo.estadoOperacion = ConstantesREC.ESTADO_OPERACION_BLOQUEO 
			// operacionReclamo.motivoBloqueo = operacion.oidBloqueoImporte 
			// operacionReclamo.tipoBloqueo = tipoBloqueo.oid 
            operacReclamoLocal.setEstadoOperacion(ConstantesREC.ESTADO_OPERACION_BLOQUEO);
            operacReclamoLocal.setMotivoBloqueo(operacion.getOidBloqueoImporte());
            operacReclamoLocal.setTipoBloqueo(tiposBloqLocal.getOid());
            opLH.merge(operacReclamoLocal);
			// Devuelve true 
            UtilidadesLog.info("MONValidarReclamos.validarBloqueoPorImporte(DTOValidarOperacionReclamo):Salida");   
            return true;
		} 

		// Devuelve false        
        UtilidadesLog.info("MONValidarReclamos.validarBloqueoPorImporte(DTOValidarOperacionReclamo):Salida");   
        return false;    
    }

    // se aplican los mismos cambios indicados para validarBloqueoPorImporte en BELC300019827
    private boolean validarBloqueoPorDiferencia (DTOValidarOperacionReclamo operacion) throws MareException 
    {
        UtilidadesLog.info("MONValidarReclamos.validarBloqueoPorDiferencia(DTOValidarOperacionReclamo):Entrada");   
        
        // Valida el bloqueo por diferencia de una operacion 

        // Obtiene el usuario actual 
        // usuario = Llama al método getCallerPrincipal() del contexto del EJB y obtiene el código del usuario 
        String usuario = ctx.getCallerPrincipal().getName();
        
        //Crea un DTOString con:
        //- cadena = usuario
        //- pais = operacion.pais
        DTOString dtoString = new DTOString();
        dtoString.setCadena(usuario);
        dtoString.setOidPais(operacion.getOidPais());
        
        //oidUsuario = DAORec.obtenerUsuario(DTOString)
        Integer oidUsuario = new DAORec().obtenerUsuario(dtoString);
        
        AutorizacionesLocal autorizacionesLocal = null;
        
        try {
            autorizacionesLocal = new AutorizacionesLocalHome().findByUK(operacion.getOidPais(), operacion.getOidTipoOperacion(), oidUsuario);
        } catch (NoResultException e){
            String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            ctx.setRollbackOnly();
            UtilidadesLog.error("MONValidarReclamos.validarBloqueoPorDiferencia: Finder en Autorizaciones: ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }catch(PersistenceException e) {
               ctx.setRollbackOnly();
               String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
               throw new MareException(e, UtilidadesError.armarCodigoError(error));
            }   

        RecordSet importes = new DAORec().obtenerImportesCargoAbonoOperacion(operacion.getOidOperacion());
        
        BigDecimal importeCargo = null;
        BigDecimal importeAbono = null;
        
        if (importes.getValueAt(0, "IMPORTE_CARGO") != null) {
            importeCargo = (BigDecimal)importes.getValueAt(0, "IMPORTE_CARGO");
        } else {
            importeCargo = new BigDecimal(0);
        }
        if (importes.getValueAt(0, "IMPORTE_ABONO") != null) {
            importeAbono = (BigDecimal)importes.getValueAt(0, "IMPORTE_ABONO");
        } else {
            importeAbono = new BigDecimal(0);
        }
        
        // Si (importeCargo - importeAbono) > autorizacion.importeMaximo 
        BigDecimal importe = importeCargo.add(importeAbono.negate());
        
        if ((importe.compareTo(autorizacionesLocal.getImporteMaximo()) > 0)) {
			// Bloquea la operación 
			
            TiposBloqueoLocal tiposBloqLocal = null;
            try {
                tiposBloqLocal = new TiposBloqueoLocalHome().findByUK(operacion.getOidPais(), ConstantesREC.BLOQUEO_DIFERENCIA_IMPORTES);
            } catch (NoResultException e){
                String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
                ctx.setRollbackOnly();
                UtilidadesLog.error("MONValidarReclamos.validarBloqueoPorDiferencia: Finder en TiposBloqueo: ", e);
                throw new MareException(e, UtilidadesError.armarCodigoError(error));
            }catch(PersistenceException e) {
               ctx.setRollbackOnly();
               String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
               throw new MareException(e, UtilidadesError.armarCodigoError(error));
            }   
             
            OperacionReclamoLocal operacReclamoLocal = null;
            OperacionReclamoLocalHome OpLH = new OperacionReclamoLocalHome();
            try {
                operacReclamoLocal = OpLH.findByPrimaryKey(operacion.getOidOperacion());
            } catch (NoResultException e){
                String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
                ctx.setRollbackOnly();
                UtilidadesLog.error("MONValidarReclamos.validarBloqueoPorDiferencia: Finder en OperacionReclamo: ", e);
                throw new MareException(e, UtilidadesError.armarCodigoError(error));
            } catch(PersistenceException e) {
               ctx.setRollbackOnly();
               String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
               throw new MareException(e, UtilidadesError.armarCodigoError(error));
            }             
			
            operacReclamoLocal.setEstadoOperacion(ConstantesREC.ESTADO_OPERACION_BLOQUEO);
            operacReclamoLocal.setMotivoBloqueo(operacion.getOidBloqueoDiferencia());
            operacReclamoLocal.setTipoBloqueo(tiposBloqLocal.getOid());
            OpLH.merge(operacReclamoLocal);
			// Devuelve true 
            UtilidadesLog.info("MONValidarReclamos.validarBloqueoPorDiferencia(DTOValidarOperacionReclamo):Salida");
            return true;
		} 

		// Devuelve false   
        UtilidadesLog.info("MONValidarReclamos.validarBloqueoPorDiferencia(DTOValidarOperacionReclamo):Salida");
        return false;
    }

    // En el diseño indica: Taponado por incidencia BELC300015208
    // modificado por la incidencia 15177
    private boolean validarBloqueoPorReclamoAnterior(Long oidDocumentoReferencia, DTOValidarOperacionReclamo operacion) throws MareException {
        UtilidadesLog.info("MONValidarReclamos.validarBloqueoPorReclamoAnterior(Long , DTOValidarOperacionReclamo):Entrada");   
        ArrayList lineas = operacion.getLineas();
        DTOValidarLineaReclamo lineaOperacion = null;
        RecordSet reclamos = null;
        if (lineas!=null){
            int numeroLineas = lineas.size();
            for (int i=0; i<numeroLineas; i++){
                lineaOperacion = (DTOValidarLineaReclamo)lineas.get(i);
                DAORec daoRec = new DAORec();
                reclamos = daoRec.obtenerReclamosAnteriores(oidDocumentoReferencia,lineaOperacion.getOidMF(),lineaOperacion.getOidProducto(),null);
                if (!reclamos.esVacio()){
                    UtilidadesLog.info("MONValidarReclamos.validarBloqueoPorReclamoAnterior(Long , DTOValidarOperacionReclamo):Salida");   
                    return true;
                }else {
                    UtilidadesLog.info("MONValidarReclamos.validarBloqueoPorReclamoAnterior(Long , DTOValidarOperacionReclamo):Salida");   
                    return false;
                    }
            }
        }
        UtilidadesLog.info("MONValidarReclamos.validarBloqueoPorReclamoAnterior(Long , DTOValidarOperacionReclamo):Salida");
        return false;
    }

    private void generarDevuelvesAutomaticos(DTOValidarOperacionReclamo operacion)    
        throws MareException 
    {  
        UtilidadesLog.info("MONValidarReclamos.generarDevuelvesAutomaticos(DTOValidarOperacionReclamo):Entrada");   
        
		//// Genera una linea devuelve por cada linea envia 

		// Trata las lineas de la operacion 
		// Recorre el ArrayList operacion.lineas utilizando el contador posicion { 
        ArrayList lineas = operacion.getLineas();
        DTOValidarLineaReclamo linea = null;
        DTOValidarLineaReclamo lineaDevuelve = null;        
        
        int numeroLineas = lineas.size();
        
        for (int posicion = 0; posicion < numeroLineas; posicion++) {
			// linea = (DTOValidarLineaReclamo)operacion.lineas.get(posicion) 
            linea = (DTOValidarLineaReclamo)lineas.get(posicion);
	
			// Si linea.oidTipoMovimiento == ConstantesREC.TIPO_MOVIMIENTO_ENVIA { 
            if (linea.getOidTipoMovimiento().compareTo(ConstantesREC.TIPO_MOVIMIENTO_ENVIA) == 0) {
				// Genera una copia de la linea envía 
				// lineaDevuelve = linea.clone() 
                try {
                    lineaDevuelve = (DTOValidarLineaReclamo)linea.clone();
                } catch (CloneNotSupportedException cnse) {
                    UtilidadesLog.error(cnse);
                    UtilidadesLog.error("MONValidarReclamos.generarDevuelvesAutomaticos: CloneNotSupportedException", cnse);
                }
	
				// Actualiza los atributos de la nueva linea 
				// lineaDevuelve.numeroLinea = operacion.lineas.size() + 1 
				// lineaDevuelve.oidTipoMovimiento = ConstantesREC.TIPO_MOVIMIENTO_ENVIA 
				// lineaDevuelve.importeAbono = linea.importeCargo 
				// lineaDevuelve.importeCargo = null 
        
                //jrivas inc bloq REC-08 22/11/2005 lineaEnvia.setNumeroLinea(new Integer(numeroLineas + i));
                lineaDevuelve.setNumeroLinea(new Integer(lineaDevuelve.getNumeroLinea().intValue() + posicion + 1));  
                //lineaDevuelve.setNumeroLinea(new Integer(numeroLineas + posicion));
                
                lineaDevuelve.setOidTipoMovimiento(ConstantesREC.TIPO_MOVIMIENTO_DEVUELVE);
                lineaDevuelve.setImporteAbono(linea.getImporteCargo());
                lineaDevuelve.setImporteCargo(null);
                // incidencia 19226
                lineaDevuelve.setMontoPerdida(null);
				 
                if(operacion.getDevuelveEnFactura()){
                    lineaDevuelve.setOidPosicionReferencia(linea.getOidPosicionReferencia());
                }
                // Guarda la linea en BD 
				this.guardarLineaEnviaDevuelve(lineaDevuelve);
			} 
		}
        
        UtilidadesLog.info("MONValidarReclamos.generarDevuelvesAutomaticos(DTOValidarOperacionReclamo):Salida");   
    }    
    
 
    private MONProcesosPED getMONProcesosPED() throws MareException {
        // Se obtiene el interfaz home
        MONProcesosPEDHome home = (MONProcesosPEDHome)UtilidadesEJB.getHome(
            "MONProcesosPED", MONProcesosPEDHome.class);
            
        // Se obtiene el interfaz remoto
        MONProcesosPED ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
			UtilidadesLog.error("*** Error en getMONProcesosPED",e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
        return ejb;
	}
    
    private MONPeriodos getMONPeriodos() throws MareException {
        // Se obtiene el interfaz home
        MONPeriodosHome home = (MONPeriodosHome)UtilidadesEJB.getHome(
            "MONPeriodos", MONPeriodosHome.class);
            
        // Se obtiene el interfaz remoto
        MONPeriodos ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
			UtilidadesLog.error("*** Error en getMONPeriodos",e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
        return ejb;
	}

  

    private MONGenerarMovimientoAlmacen getMONGenerarMovimientoAlmacen() throws MareException {
        // Se obtiene el interfaz home

        MONGenerarMovimientoAlmacenHome home = (MONGenerarMovimientoAlmacenHome) UtilidadesEJB.getHome("MONGenerarMovimientoAlmacen",
                MONGenerarMovimientoAlmacenHome.class);

        // Se obtiene el interfaz remoto
        MONGenerarMovimientoAlmacen ejb = null;

        try {
            ejb = home.create();
        } catch (Exception e) {
            UtilidadesLog.error("*** Error en getMONGenerarMovimientoAlmacen", e);

            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            ctx.setRollbackOnly();
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }


        return ejb;
    }
    
    private MONSoporteExterno getMONSoperteExterno() throws MareException {
        // Se obtiene el interfaz home
        MONSoporteExternoHome home = (MONSoporteExternoHome)UtilidadesEJB.getHome(
            "MONSoporteExterno", MONSoporteExternoHome.class);
            
        // Se obtiene el interfaz remoto
        MONSoporteExterno ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
			UtilidadesLog.error("*** Error en getMONSoporteExterno",e);
            ctx.setRollbackOnly();
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
        return ejb;
	}
    
     private MONCapturaProcesoReclamos getMONCapturaProcesoReclamos() throws MareException {
        // Se obtiene el interfaz home
        MONCapturaProcesoReclamosHome home = (MONCapturaProcesoReclamosHome)UtilidadesEJB.getHome(
            "MONCapturaProcesoReclamos", MONCapturaProcesoReclamosHome.class);
            
        // Se obtiene el interfaz remoto
        MONCapturaProcesoReclamos ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
			UtilidadesLog.error("*** Error en getMONCapturaProcesoReclamos",e);
            ctx.setRollbackOnly();
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
        return ejb;
	}

    /* autor: mamontie
   * 11/05/2006 Inc. 22744
   * */
  public void calcularImporteReclamoAnulacion(DTOValidarReclamo dto) throws MareException
  {
      /*
           *  // Obtiene y actualiza el importe del reclamo recibido
         SolicitudCabecera soliCabe =  SolicitudCabecera.findByPK(reclamo.oidDocumentoReferencia)
         Si(soliCabe.moneda != null){
           importeCargo = soliCabe.totalPagarLocal
         }Sino{
           importeCargo = soliCabe.totalPagarDocumento
         }
         importeAbono = DAORec. obtenerImporteAbono (reclamo.oidReclamo)
         saldoPagar = importeCargo - importeAbono
         reclamo = CabeceraReclamo.findByPrimaryKey(oidReclamo)
         reclamo.totalDevuelve = importeCargo
         reclamo.totalEnvia = importeAbono
         reclamo.saldoPagar = saldoPagar
    
       * */
  
      UtilidadesLog.info("calcularImporteReclamoAnulación Entrada");

       StringBuffer sql = new StringBuffer();
       RecordSet resultado = null;
       String codigoError = null;
       Long moneda = null;
       Long importeCargo = null;
       Long importeAbono = null;
       Long saldoPagar = null;
       DAORec daoRec = new DAORec();
       
       sql.append(" SELECT MONE_OID_MONE MONEDA, VAL_PREC_CATA_TOTA_LOCA TOTALOCA, VAL_PREC_CATA_TOTA_DOCU TOTADOCU ");
       sql.append(" FROM PED_SOLIC_CABEC ");
       sql.append(" WHERE OID_SOLI_CABE=  " + dto.getOidDocumentoReferencia());
       	// Se ejecuta la consulta 
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        
        try {
          resultado = bs.dbService.executeStaticQuery(sql.toString());
                UtilidadesLog.debug("Resultado del RecordSet:" + resultado);
        } catch (Exception e) {
          UtilidadesLog.error("obtenerCodigosTipoOperacion: ",e);
                codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            ctx.setRollbackOnly();
                throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
  
        if(!resultado.esVacio()){
            moneda = (resultado.getValueAt(0,"MONEDA")!=null?  new Long(((BigDecimal)resultado.getValueAt(0,"MONEDA")).longValue()):null);
            if(moneda!=null){
              importeCargo= (resultado.getValueAt(0,"TOTALOCA")!=null?  new Long(((BigDecimal)resultado.getValueAt(0,"TOTALOCA")).longValue()):null);
            }else{
              importeCargo= (resultado.getValueAt(0,"TOTADOCU")!=null?  new Long(((BigDecimal)resultado.getValueAt(0,"TOTADOCU")).longValue()):null);
            }          
        }
        
        importeAbono = daoRec.obtenerImporteAbono(dto.getOidDocumentoReferencia());
        saldoPagar = new Long(importeCargo.longValue() - importeAbono.longValue());
        UtilidadesLog.info( " importeCargo  "  + importeCargo + "importeAbono " + importeAbono + "saldoPagar  " + saldoPagar);
        
        
          // Actualiza el estado de la cabecera
        CabeceraReclamoLocalHome cabeceraReclamoLH = new CabeceraReclamoLocalHome();
        CabeceraReclamoLocal cabeceraReclamoLocal = null;
        
        try { 
            cabeceraReclamoLocal = cabeceraReclamoLH.findByPrimaryKey(dto.getOidReclamo());
        } catch (NoResultException e) {
            String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            ctx.setRollbackOnly();
            UtilidadesLog.error("MONValidarReclamos.actualizarEstadoReclamo: FinderException en cabeceraReclamo: "+dto.getOidReclamo(), e);
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }catch(PersistenceException e) {
               ctx.setRollbackOnly();
               String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
               throw new MareException(e, UtilidadesError.armarCodigoError(error));
            }   

        cabeceraReclamoLocal.setTotalDevuelve(new BigDecimal(importeAbono.longValue()));
        cabeceraReclamoLocal.setTotalEnvia(new BigDecimal(importeCargo.longValue()));
        cabeceraReclamoLocal.setSaldoPagar(new BigDecimal(saldoPagar.longValue()));
        cabeceraReclamoLH.merge(cabeceraReclamoLocal);
        UtilidadesLog.info("calcularImporteReclamoAnulación Entrada");      
  }
  
}