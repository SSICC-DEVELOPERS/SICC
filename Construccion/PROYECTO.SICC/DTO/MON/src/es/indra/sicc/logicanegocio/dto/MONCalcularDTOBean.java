
/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La rmación contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 *
 */
package es.indra.sicc.logicanegocio.dto;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.MareServiceException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.dto.DTOAcumuladoVenta;
import es.indra.sicc.dtos.dto.DTOCriteriosSeleccionDTO;
import es.indra.sicc.dtos.dto.DTODescuento;
import es.indra.sicc.dtos.dto.DTOEscalon;
import es.indra.sicc.dtos.dto.DTOHistoricoDescuento;
import es.indra.sicc.dtos.dto.DTOMensajeDescuento;
import es.indra.sicc.dtos.dto.DTOSBaseAplicacion;
import es.indra.sicc.dtos.dto.DTOSBaseAplicacionDetalle;
import es.indra.sicc.dtos.dto.DTOSBaseCalculo;
import es.indra.sicc.dtos.dto.DTOSBaseCalculoDetalle;
import es.indra.sicc.dtos.dto.DTOSimulacionDescuento;
import es.indra.sicc.dtos.dto.DTOSolicitudDescuento;
import es.indra.sicc.dtos.dto.DTOSolicitudPosicionDescuento;
import es.indra.sicc.dtos.mae.DTOTipoSubtipoCliente;
import es.indra.sicc.dtos.msg.ConstantesMSG;
import es.indra.sicc.dtos.msg.DTOBuzonMensajes;
import es.indra.sicc.dtos.ped.DTOCabeceraSolicitud;
import es.indra.sicc.dtos.ped.DTOPeriodoDocumentoReferencia;
import es.indra.sicc.dtos.ped.DTOPosicionSolicitud;
import es.indra.sicc.dtos.ped.DTOSolicitudValidacion;
import es.indra.sicc.dtos.ped.DTOTipoSolicitud;
import es.indra.sicc.dtos.ped.DTOTipoSolicitudProceso;
import es.indra.sicc.entidades.seg.SubaccesoLocal;
import es.indra.sicc.entidades.seg.SubaccesoLocalHome;
import es.indra.sicc.entidades.zon.RegionLocal;
import es.indra.sicc.entidades.zon.RegionLocalHome;
import es.indra.sicc.entidades.zon.ZonaLocal;
import es.indra.sicc.entidades.zon.ZonaLocalHome;
import es.indra.sicc.logicanegocio.bel.ConstantesBEL;
import es.indra.sicc.logicanegocio.dto.DAOCalculoDescuentos;
import es.indra.sicc.logicanegocio.dto.MONHistoricoDTOHome;
import es.indra.sicc.logicanegocio.dto.ServiciosDTO;
import es.indra.sicc.logicanegocio.mae.ConstantesMAE;
import es.indra.sicc.logicanegocio.mae.MONClientes;
import es.indra.sicc.logicanegocio.mae.MONClientesHome;
import es.indra.sicc.logicanegocio.mae.MONConfiguracionClientes;
import es.indra.sicc.logicanegocio.mae.MONConfiguracionClientesHome;
import es.indra.sicc.logicanegocio.msg.MONGestionMensajesLocalHome;
import es.indra.sicc.logicanegocio.ped.ConstantesPED;
import es.indra.sicc.logicanegocio.ped.DAOSolicitud;
import es.indra.sicc.logicanegocio.ped.MONDigitacionInicial;
import es.indra.sicc.logicanegocio.ped.MONDigitacionInicialHome;
import es.indra.sicc.logicanegocio.ped.MONGenerarSolicitudModulosExternos;
import es.indra.sicc.logicanegocio.ped.MONGenerarSolicitudModulosExternosHome;
import es.indra.sicc.logicanegocio.pre.MONMantenimientoMFHome;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.Cronometrador;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.LogAPP;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.math.BigDecimal;

import java.rmi.RemoteException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

import javax.ejb.CreateException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.persistence.NoResultException;




/**
 * Sistema:           Belcorp
 * Modulo:            DTO
 * Submódulo:           
 * Componente:        MONCalcularDTOBean
 * Fecha:             28/07/2004
 * Observaciones:     Componente construido de acuerdo a la especificación del
 *                    Modelo de Componentes SICC-DCMO-DTO-201-334-N024
 *
 * @version           1.0
 * @autor             Gustavo De Marzi
 */
public class MONCalcularDTOBean implements SessionBean {

    private static int CANT_DECIMALES = 2; 
    private SessionContext ctx;
    private boolean generaMensaje = false;
    private ArrayList mensajesDescuento = new ArrayList(); ;
    private HashMap hashMarcaSolicitudDescuento = new HashMap();
    private UtilidadesLog log = new UtilidadesLog();

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


    /**
     * Realiza la simulacion de un descuento.
     * Toma el descuento a simular y una lista de solicitudes sobre las que aplica el descuento.
     * Retorna la lista de solicitudes con el descuento simulado. 
     * @autor gdmarzi
     */
    public DTOSimulacionDescuento simularDescuentos(DTOSimulacionDescuento dto) throws MareException  {
        UtilidadesLog.info("MONCalcularDTO.simularDescuentos(): Entrada");
        DTOSimulacionDescuento dtoSimulacionDescuento;
        try {
            ArrayList solicitudes = dto.getListaSolicitudes();
            Long oidDescuento = dto.getOidDescuento();
            UtilidadesLog.debug("oidDescuento: " + oidDescuento);
            Boolean simulacion = Boolean.TRUE;
            ArrayList solicitudesProcesadas = this.calcularDescuentos(solicitudes, oidDescuento, simulacion, dto.getOidIdioma(), dto.getOidPais());
            dtoSimulacionDescuento = new DTOSimulacionDescuento();
            dtoSimulacionDescuento.setListaSolicitudes(solicitudesProcesadas);
        } catch(MareException me) {
            ctx.setRollbackOnly();
            UtilidadesLog.error(me);
            throw me;
        } catch(Exception e) {
            ctx.setRollbackOnly();
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        UtilidadesLog.info("MONCalcularDTO.simularDescuentos(): Salida");
        // -> Devolver objeto DTOSimulacionDescuento.
        return dtoSimulacionDescuento;
    }


    /**
     * Realiza la validacion de los descuento asociados a una solictud.
     * Toma la solicitud a validar, sobre las que aplica los descuento asociados.
     * Retorna la lista de solicitudes con los descuentos aplicados. 
     * @autor gdmarzi
     */
    public DTOSolicitudDescuento validarDescuentos(DTOSolicitudValidacion dto) throws MareException {
        UtilidadesLog.info("MONCalcularDTO.validarDescuentos(): Entrada");
        DTOSolicitudDescuento dtoSolicitudDescuentoProcesado;
        try {
            DTOSolicitudDescuento dtoSolicitudDescuento = new DTOSolicitudDescuento();
            dtoSolicitudDescuento.setIndOrdenCompra(dto.getIndOrdenCompra());
            dtoSolicitudDescuento.setIndPedGTZona(dto.getIndPedGTZona());
            dtoSolicitudDescuento.setIndSimulacion(dto.getIndSimulacion());
            dtoSolicitudDescuento.setOidPais(dto.getOidPais());
            dtoSolicitudDescuento.setOidCanal(dto.getOidCanal());
            dtoSolicitudDescuento.setOidCliente(dto.getOidCliente());
            dtoSolicitudDescuento.setOidMarca(dto.getOidMarca());
            dtoSolicitudDescuento.setOidModulo(dto.getOidModulo());
            dtoSolicitudDescuento.setOidMoneda(dto.getOidMoneda());
            dtoSolicitudDescuento.setOidPeriodo(dto.getOidPeriodo());
            dtoSolicitudDescuento.setOidSolicitud(dto.getOidSolicitud());
            dtoSolicitudDescuento.setOidSubAcceso(dto.getOidSubAcceso());
            dtoSolicitudDescuento.setOidTipoSolPais(dto.getOidTipoSolPais());
            dtoSolicitudDescuento.setProceso(dto.getProceso());
            dtoSolicitudDescuento.setUbigeo(dto.getUbigeo());
            dtoSolicitudDescuento.setZona(dto.getZona());
            dtoSolicitudDescuento.setProceso(dto.getProceso());
            dtoSolicitudDescuento.setTipoCambio(dto.getTipoCambio());
            dtoSolicitudDescuento.setPrograma(dto.getPrograma());
            dtoSolicitudDescuento.setIpCliente(dto.getIpCliente());
            // Si no viene el idioma, se setea el idioma por defecto
            if (dto.getOidIdioma() != null) {
                dtoSolicitudDescuento.setOidIdioma(dto.getOidIdioma());
            } else {
                dtoSolicitudDescuento.setOidIdioma(ConstantesSEG.IDIOMA_DEFECTO);
            }
            dtoSolicitudDescuento.setNombrePeriodo(dto.getNombrePeriodo());
            dtoSolicitudDescuento.setDescripcionCanal(dto.getDescripcionCanal());
            dtoSolicitudDescuento.setPosiciones(new ArrayList());
            ArrayList solicitudes = new ArrayList();
            solicitudes.add(dtoSolicitudDescuento);
            Long oidDescuento = null;
            Boolean simulacion = Boolean.FALSE;
            ArrayList solicitudesProcesadas = this.calcularDescuentos(solicitudes, oidDescuento, simulacion, dto.getOidIdioma(), dto.getOidPais());
            dtoSolicitudDescuentoProcesado = (DTOSolicitudDescuento) solicitudesProcesadas.get(0);
        } catch(MareException me) {
            ctx.setRollbackOnly();
            UtilidadesLog.error(me);
            throw me;
        } catch(Exception e) {
            ctx.setRollbackOnly();
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        UtilidadesLog.info("MONCalcularDTO.validarDescuentos(): Salida");
        return dtoSolicitudDescuentoProcesado;
    }


    /**
     * Calcula un descuento para la lista de solicitudes.
     * El calculo del descuento puede ser real o una simulacion.
     * Cuando el calculo ES una simulacion se trabaja sobre una o varias solicitudes y un solo descuento.
     * Cuando el calculo NO ES una simulacion se trabaja sobre una sola solicitud y uno o varios descuentos.
     * Entrada: 
     * - listaSolicitudes: arrayList de objetos DTOSolicitudDescuento 
     * - oidDescuento: Long 
     * - simulacion: Boolean (Nos dice si se nos llama desde el caso de uso de simulación de descuentos) 
     * @autor gdmarzi
     */
    private ArrayList calcularDescuentos(ArrayList listaSolicitudes, Long oidDescuento, Boolean simulacion, Long oidIdiona, Long oidPais) throws MareException {
        UtilidadesLog.info("MONCalcularDTO.calcularDescuentos(): Entrada");
        Cronometrador.startTransaction("Calcular Descuento");   
        /*
         * 1.- Obtenemos los descuentos para aplicar 
         */
        UtilidadesLog.debug("Obtenemos los descuentos para aplicar");
        ArrayList listaDescuentos = new ArrayList();
        if ( ! simulacion.booleanValue()) {
            UtilidadesLog.debug("NO es simulacion, obtenemos todos los descuentos aplicables a la solicitud.");
            DTOSolicitudDescuento unicaSolicitudDescuento = (DTOSolicitudDescuento)listaSolicitudes.get(0);
            unicaSolicitudDescuento.setOidPais(oidPais);
            unicaSolicitudDescuento.setOidIdioma(oidIdiona);
            DTOSalida dtoSalida = this.seleccionarDescuentosSolicitud(unicaSolicitudDescuento);
            RecordSet descuentosSeleccionados = dtoSalida.getResultado();
            for(int pos=0; pos < descuentosSeleccionados.getRowCount(); pos++) {
                Long oidDescuentoSeleccionado = new Long((String)descuentosSeleccionados.getValueAt(pos,0));
                listaDescuentos.add(oidDescuentoSeleccionado);
            }
        } else {
            UtilidadesLog.debug("Es simulacion, con el descuento: " + oidDescuento);
            listaDescuentos.add(oidDescuento);
        }
        
        /* 
         * 2.- Aplicamos los descuentos cuyos oid están contenidos en el atributo "listaDescuentos" 
         * a cada solicitud contenida en el parámetro de entrada "listaSolicitudes.
         */
        ArrayList listaSolicitudesProcesadas = new ArrayList();
        DTOSolicitudDescuento solicitudProceso = null;
        // Para cada objeto DTOSolicitudDescuento contenido en el parámetro de entrada "listaSolicitudes" hacer
        for (int num=0; num < listaSolicitudes.size(); num++) {
            solicitudProceso = (DTOSolicitudDescuento)listaSolicitudes.get(num);
            solicitudProceso.setOidPais(oidPais);
            solicitudProceso.setOidIdioma(oidIdiona);
            // Si NO es simulacion
            if ( ! simulacion.booleanValue()) {
                UtilidadesLog.debug("NO es simulacion, recuperamos datos de la solicitud.");
                solicitudProceso = this.recuperarDatosSolicitud(solicitudProceso);
            }
            int i=0;
            boolean salir=false;
            // Mientras tenga descuentos y no tenga indicador de culminacion activo
            while ((!salir) && (i < listaDescuentos.size())) {
                Long oidDesc = (Long)listaDescuentos.get(i);
                DTODescuento dtoDescuento = obtenerDescuentoBatch(oidDesc, oidIdiona);

                solicitudProceso.setIndSimulacion(simulacion);
                Cronometrador.startTransaction("Aplicar Descuento");   
                solicitudProceso = this.aplicarDescuento(dtoDescuento, solicitudProceso); 
                Cronometrador.endTransaction("Aplicar Descuento");   
                // Si NO es simulacion 
                if ( ! simulacion.booleanValue()) {
                    if (dtoDescuento.getDatosGenerales().getCulminacion().booleanValue()) {
                        salir = true;
                    }
                }        
                i++;
                // Si el caso ES llamado desde simulación de descuentos sólo tenemos un descuento
                // que simular y saldrá del bucle. Incidencia 7095 lo confirma.
            }
            try{
                /*
                 * Genero Los mensajes antes de generar Los historicos
                 */
                DTOBuzonMensajes[] dtoBuzonMensajes = new DTOBuzonMensajes[mensajesDescuento.size()];
                for ( int x = 0 ; x < mensajesDescuento.size() ; x++ ){
                    dtoBuzonMensajes[x] = (DTOBuzonMensajes)mensajesDescuento.get(x);
                }
                dtoBuzonMensajes = this.getMONGestionMensajesLocalHome().create().insertarDatosMensajesBatch(dtoBuzonMensajes);
                // limpio la lista de mensajes que ya fueron enviados
                hashMarcaSolicitudDescuento.clear();
                mensajesDescuento.clear();
            }catch (Exception e){
                UtilidadesLog.error("ERROR",e);
                ctx.setRollbackOnly();
                throw new MareException(e);
            }

            // -> Añadir dtoSolicitudDescuento a la variable "listaSolicitudesProcesadas" 
            listaSolicitudesProcesadas.add(solicitudProceso);
        }
        Cronometrador.endTransaction("Calcular Descuento");   
        UtilidadesLog.info("MONCalcularDTO.calcularDescuentos(): Salida");
        return listaSolicitudesProcesadas;
    }


    private DTODescuento obtenerDescuentoBatch(Long oidDescuento, Long oidIdioma) throws MareException {
        DTODescuento dtoDescuento = new DTODescuento();
        ServiciosDTO serviciosDTO = ServiciosDTO.getInstannce();
        if ( serviciosDTO.getDescuentos().containsKey(oidDescuento) ) {
            dtoDescuento = (DTODescuento) serviciosDTO.getDescuentos().get(oidDescuento);
        } else {
            // -> Crear objeto DTOOID con valor tomado en interación anterior 
            DTOOID dtoOid = new DTOOID();
            dtoOid.setOid(oidDescuento);
            dtoOid.setOidIdioma(oidIdioma);
            try {
                MONMantenimientoDTOLocalHome monMantenimientoDTOHome = this.getMONMantenimientoDTOLocalHome();
                MONMantenimientoDTOLocal monMantenimientoDTO = monMantenimientoDTOHome.create();
                dtoDescuento = monMantenimientoDTO.obtenerDescuentoBatch(dtoOid);
            } catch (NamingException e) {
                throw new MareException(e,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            } catch (CreateException e) {
                throw new MareException(e,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
            serviciosDTO.getDescuentos().put(oidDescuento, dtoDescuento);
        }
        return dtoDescuento;
    }


    /**
     * Retorna todos los descuentos aplicables a la solicitud.
     * Tomando los atributos (oidSolicitud, oidPais, oidMarca, oidCanal, oidPeriodo, oidCliente,
     * oidSubacceso, indSimulacion, zona, oidModulo del dto entrada.
     * Más los datos obtenidos de la solicitud y del cliente como criterios de búsqueda.
     * Se seleccionan todos los descuentos aplicables a la solicitud,
     * ordenados por el atributo "numeroCorrelativo" de la entidad Descuento, campo NUM_DESC_CORR de la tabla DTO_DESCU.
     * @autor gdmarzi
     */
    private DTOSalida seleccionarDescuentosSolicitud(DTOSolicitudDescuento dto) throws MareException {
        UtilidadesLog.info("MONCalcularDTO.seleccionarDescuentosSolicitud(): Entrada");
        Long oidAcceso = null;
        Long oidRegion = null;
        Long oidSubgerenciaVenta = null;
        DTOCriteriosSeleccionDTO criterios = new DTOCriteriosSeleccionDTO();
        try {
            SubaccesoLocalHome subaccesoLocalHome = new SubaccesoLocalHome();
            SubaccesoLocal subaccesoLocal = subaccesoLocalHome.findByPrimaryKey(dto.getOidSubAcceso());
            oidAcceso = subaccesoLocal.getOidAcceso();
        } catch(NoResultException e) {
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        criterios.setOidPais(dto.getOidPais());
        criterios.setOidMarca(dto.getOidMarca());
        criterios.setOidCanal(dto.getOidCanal());
        criterios.setOidAcceso(oidAcceso);
        criterios.setOidSubacceso(dto.getOidSubAcceso());
        // Si es reclamo se utiliza el periodo de referencia
        if ( ! esReclamo(dto) ) {
            criterios.setOidPeriodo(dto.getOidPeriodo());
        } else {
            try {
                DTOPeriodoDocumentoReferencia dtoPeriodoDocRef;
                DTOOID dtoOid = new DTOOID();
                dtoOid.setOid(dto.getOidSolicitud());
                // -> Llamar al método "MONDigitacionInicial.obtenerPeriodoDocumentoReferencia(DTOE : DTOOID) : DTOOID" pasando como parámetro el DTOOID creado 
                MONDigitacionInicialHome monDigitacioInicialnHome = this.getMONDigitacionInicialHome();
                MONDigitacionInicial monDigitacionInicial = monDigitacioInicialnHome.create();
                dtoPeriodoDocRef = monDigitacionInicial.obtenerPeriodoDocumentoReferencia(dtoOid);
                criterios.setOidPeriodo(dtoPeriodoDocRef.getPeriodoDocumentoReferencia());
                // guardo el oid y nombre de periodo de referencia en la solicitud
                dto.setPeriodoDocumentoReferencia(dtoPeriodoDocRef.getPeriodoDocumentoReferencia());
                dto.setNombrePeriodoDocumentoReferencia(dtoPeriodoDocRef.getNombrePeriodoDocumentoReferencia());
            } catch (RemoteException e) {
                throw new MareException(e,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            } catch (CreateException e) {
                throw new MareException(e,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
        }
        criterios.setOidCliente(dto.getOidCliente());
        criterios.setOidZona(dto.getZona()); 
        try {
            ZonaLocalHome zonaLocalHome = new ZonaLocalHome();
            ZonaLocal zonaLocal = zonaLocalHome.findByPrimaryKey(dto.getZona());
            oidRegion = zonaLocal.getOidRegion();
        } catch(NoResultException e) {
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        criterios.setOidRegion(oidRegion);
        try {
            RegionLocalHome regionLocalHome = new RegionLocalHome();
            RegionLocal regionLocal = regionLocalHome.findByPrimaryKey(oidRegion);
            oidSubgerenciaVenta = regionLocal.getSgvOidSubgVenta();
        } catch(NoResultException e) {
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        criterios.setOidSubgerencia(oidSubgerenciaVenta);
        
        //doliva -- cambio Optimizacion Logs -- 09/04/2010 
        if(log.isDebugEnabled())
            UtilidadesLog.debug("Criterios para seleccionar descuentos: " + criterios);
        
        // -> Llamar al método "DAOCalculoDescuentos.seleccionarDescuentosSolicitud(dto : DTOCriteriosSeleccionDTO) : RecordSet" 
        DAOCalculoDescuentos daoCalculoDescuentos = new DAOCalculoDescuentos();
        RecordSet rsDescuentosSeleccionado  = daoCalculoDescuentos.seleccionarDescuentosSolicitud(criterios);
        UtilidadesLog.info("MONCalcularDTO.calcularDescuentos(): Salida");
        return new DTOSalida(rsDescuentosSeleccionado);
    }


    /**
     * Recupera los datos de una solicitud y sus posiciones.
     * Clona el dto de entrada y le agrega las posiciones de solicitud obtenidas.
     * @autor gdmarzi
     * @cambio  Incidencia SiCC 20070297. Si la solicitud es de reclamos, obtenemos las posiciones de la solicitud de referencia.
     * @autor gdmarzi
     */
    private DTOSolicitudDescuento recuperarDatosSolicitud(DTOSolicitudDescuento dto) throws MareException {
        UtilidadesLog.info("MONCalcularDTO.recuperarDatosSolicitud(): Entrada");
        DAOSolicitud daoSolicitud = new DAOSolicitud();
        DAOCalculoDescuentos dao = new DAOCalculoDescuentos();
        ArrayList posicionesSolicitudReferencia = new ArrayList();
        BigDecimal montoTotalSolicitud = BigDecimal.valueOf(0);
        // -> Clonar el dto de entrada, creando una copia del mismo que llamaremos "solicitudRespuesta" 
        DTOSolicitudDescuento solicitudRespuesta = (DTOSolicitudDescuento)deepCopy(dto);        
        Long oidSolicitud = solicitudRespuesta.getOidSolicitud();

        // Obtenemos las posiciones de la solicitud a aplicar descuento
        DTOSalida dtoSalidaPosiciones = daoSolicitud.obtenerPosicionesDTO(oidSolicitud);
        RecordSet rsPosiciones = dtoSalidaPosiciones.getResultado();

        for (int i=0; i<rsPosiciones.getRowCount(); i++) {
            // -> Crear objeto DTOSolicitudPosicionDescuento vacío y mapear el registro en él 
            DTOSolicitudPosicionDescuento dtoPosicion = new DTOSolicitudPosicionDescuento();
            // oidSolicitud, oidPosicion, codigoVenta, descripcionProducto, cantidad, unidadesPorAtender,
            // precioUnitarioCatalogoLocal, valorTotal, importeDescuentoUnitarioLocal, porcentajeDescuento,
            // productoComisionable, productoAportaMontoAEscala, estadoPosicion, oidMarcaProducto,
            // oidUnidadNegocio, oidNegocio, oidSuperGenerico, oidGenerico, oidTipoOferta, oidCicloVida
            dtoPosicion.setOidSolicitud(new Long(((BigDecimal)rsPosiciones.getValueAt(i,"OIDSOLICITUDCABECERA")).toString()));
            dtoPosicion.setOidPosicion(new Long(((BigDecimal)rsPosiciones.getValueAt(i,"OIDSOLICITUDPOSICION")).toString()));
            dtoPosicion.setCodigoVenta((String)rsPosiciones.getValueAt(i,"CODIGOVENTA"));
            dtoPosicion.setOidProducto(new Long(((BigDecimal)rsPosiciones.getValueAt(i,"OIDPRODUCTO")).toString()));
            dtoPosicion.setDescripcionProducto((String)rsPosiciones.getValueAt(i,"DESCRIPCIONPRODUCTO"));
            dtoPosicion.setCantidad(new Long(((BigDecimal)rsPosiciones.getValueAt(i,"CANTIDAD")).toString()));

            dtoPosicion.setUnidadesPorAtender(new Long(((BigDecimal)rsPosiciones.getValueAt(i,"UNIDADESPORATENDER")).toString()));
            dtoPosicion.setPrecioUnitarioCatalogoLocal((BigDecimal)rsPosiciones.getValueAt(i,"PRECIOUNITARIOCATALOGOLOCAL"));
            dtoPosicion.setValorTotal( dtoPosicion.getPrecioUnitarioCatalogoLocal().multiply(new BigDecimal(dtoPosicion.getUnidadesPorAtender().floatValue())) );
            dtoPosicion.setImporteDescuentoUnitarioLocal((BigDecimal)rsPosiciones.getValueAt(i,"DESCUENTO"));
            dtoPosicion.setPorcentajeDescuento((BigDecimal)rsPosiciones.getValueAt(i,"PORCENTAJEDESCUENTO"));

            if (rsPosiciones.getValueAt(i,"PRODUCTOCOMISIONABLE") != null) {
                if ((new Long(((BigDecimal)rsPosiciones.getValueAt(i,"PRODUCTOCOMISIONABLE")).toString())).longValue() == 1) {
                    dtoPosicion.setProductoComisionable(Boolean.TRUE);
                } else {
                    dtoPosicion.setProductoComisionable(Boolean.FALSE);
                }
            }            
            if (rsPosiciones.getValueAt(i,"PRODUCTOAPORTAMONTOAESCALA") != null) {
                if ((new Long(((BigDecimal)rsPosiciones.getValueAt(i,"PRODUCTOAPORTAMONTOAESCALA")).toString())).longValue() == 1) {
                    dtoPosicion.setProductoAportaMontoAEscala(Boolean.TRUE);
                } else {
                    dtoPosicion.setProductoAportaMontoAEscala(Boolean.FALSE);
                }
            }            

            dtoPosicion.setEstadoPosicion(new Long(((BigDecimal)rsPosiciones.getValueAt(i,"ESTADOPOSICION")).toString()));
            dtoPosicion.setOidTipoOferta(new Long(((BigDecimal)rsPosiciones.getValueAt(i,"OIDTIPOOFERTA")).toString()));
            dtoPosicion.setOidCicloVida(new Long(((BigDecimal)rsPosiciones.getValueAt(i,"OIDCICLOVIDA")).toString()));

            if (rsPosiciones.getValueAt(i,"OIDMARCAPRODUCTO") != null) {
                dtoPosicion.setOidMarcaProducto(new Long(((BigDecimal)rsPosiciones.getValueAt(i,"OIDMARCAPRODUCTO")).toString()));
            }
            if (rsPosiciones.getValueAt(i,"OIDUNIDADNEGOCIO") != null) {
                dtoPosicion.setOidUnidadNegocio(new Long(((BigDecimal)rsPosiciones.getValueAt(i,"OIDUNIDADNEGOCIO")).toString()));
            }
            if (rsPosiciones.getValueAt(i,"OIDNEGOCIO") != null) {
                dtoPosicion.setOidNegocio(new Long(((BigDecimal)rsPosiciones.getValueAt(i,"OIDNEGOCIO")).toString()));
            }
            if (rsPosiciones.getValueAt(i,"OIDSUPERGENERICO") != null) {
                dtoPosicion.setOidSupergenerico(new Long(((BigDecimal)rsPosiciones.getValueAt(i,"OIDSUPERGENERICO")).toString()));
            }
            if (rsPosiciones.getValueAt(i,"OIDGENERICO") != null) {
                dtoPosicion.setOidGenerico(new Long(((BigDecimal)rsPosiciones.getValueAt(i,"OIDGENERICO")).toString()));
            }
            if (rsPosiciones.getValueAt(i,"OFDE_OID_DETA_OFER") != null) {
                dtoPosicion.setOidDetalleOferta(new Long(rsPosiciones.getValueAt(i,"OFDE_OID_DETA_OFER").toString()));
            }
            if (rsPosiciones.getValueAt(i,"OID_MATR_FACT") != null) {
                dtoPosicion.setOidMatriFactu(new Long(rsPosiciones.getValueAt(i,"OID_MATR_FACT").toString()));
            }

            //acumulamos monto total solicitud
            montoTotalSolicitud = montoTotalSolicitud.add(dtoPosicion.getValorTotal());

            // -> Añadir el dto creado al atributo solicitudRespuesta.posiciones de tipo arrayList 
            solicitudRespuesta.getPosiciones().add(dtoPosicion);
        }
        
        //doliva -- cambio Optimizacion Logs -- 09/04/2010
        if(log.isDebugEnabled())
            UtilidadesLog.debug("montoTotalSolicitud: " +  montoTotalSolicitud.toString());
            
        solicitudRespuesta.setMontoTotalSolicitud(montoTotalSolicitud);

        // Para los reclamos, obtenemos las posiciones de la solicitud OC de referencia.
        if (this.esReclamo(dto)) {
            posicionesSolicitudReferencia = dao.obtenerPosicionesSolicitudReferencia(oidSolicitud);
            solicitudRespuesta.setPosicionesSolictudReferencia(posicionesSolicitudReferencia);
        }

        UtilidadesLog.info("MONCalcularDTO.recuperarDatosSolicitud(): Salida");
        return solicitudRespuesta;
    }



    /**
     * Retorna dtoSolicitudDescuento.
     * Aplica el descuento cuyos datos vienen en la variable descuento para una solicitud.
     * Comprueba si el descuento esta aprobado, morosidad y descuentos Especiales a Clientes...
     * @autor gdmarzi
     * Se realizo un cambio en la logica segun la incidencia 17875 por cambio en el DT.
     * 01/08/2005 - pperanzola - se realiza un cambio porque un campo puede llegar a ser nulo.
     * 03/08/2005 - pperanzola - se corrige la carga del DTOMensajeDescuento
     * @autor gdmarzi
     */
    private DTOSolicitudDescuento aplicarDescuento(DTODescuento descuento, DTOSolicitudDescuento solicitud) throws MareException {
        UtilidadesLog.info("MONCalcularDTO.aplicarDescuento(): Entrada");
        boolean clienteBloqueado;
        BigDecimal zonaAlcanceAdmin, regionAlcanceAdmin, subgerenciaAlcanceAdmin;
        boolean zonaValida, regionValida, subgerenciaValida;
        DTOSolicitudDescuento solicitudProceso = new DTOSolicitudDescuento();
        // -> Clonar objeto solicitud de entrada y guardar la copia en la variable "solicitudProceso"
        solicitudProceso = (DTOSolicitudDescuento)deepCopy(solicitud);
                
        //doliva -- cambio Optimizacion Logs -- 09/04/2010        
        if (log.isDebugEnabled()){ 
            UtilidadesLog.debug("solicitudProceso.pais: " + solicitudProceso.getOidPais());
            UtilidadesLog.debug("DTODescuento: "+descuento);
        }
        
        /** Comprobamos si el descuento de entrada está aprobado, si no lo está generamos un registro de log */
        // -> (1) Comprobar el atributo "DTODescuento.datosGenerales.aprobado"
        if ( ! descuento.getDatosGenerales().getAprobado().booleanValue() ) {
            // Generar un log 
            // -> mensajeLog = "[DTO][Calcular Descuentos] ¡Aviso! El siguiente descuento no está aprobado: " + DTODescuento.datosGenerales.numeroDescuento
            String mensajeLog = " ¡Aviso! El siguiente descuento no está aprobado: "; //Error DTO-0016
            mensajeLog = mensajeLog + descuento.getDatosGenerales().getNumeroDescuento();
            // -> Generar registro de LOG con el mensaje obtenido en iteración anterior utilizando el servicio "AppLoggingService" de MARE
            LogAPP.info(mensajeLog);
        } // fin (1)

        /** Comprobación de morosidad */
        UtilidadesLog.debug("Comprobación de morosidad");
        // -> (2) Comprobar el atributo "DTODescuento.datosGenerales.morosidad"
        if ( descuento.getDatosGenerales().getMorosidad().booleanValue() ) {
            UtilidadesLog.debug("El cliente posee morosidad");
            String bloqueoFinanciero = ConstantesMAE.BLOQUEO_FINANCIERO;
            Long oidCliente = solicitudProceso.getOidCliente();
            try {
                MONClientesHome monClientesHome = this.getMONClientesHome();
                MONClientes monClientes = monClientesHome.create();
                clienteBloqueado = monClientes.estaClienteBloqueado(oidCliente, bloqueoFinanciero);
            } catch (RemoteException e) {
                throw new MareException(e,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            } catch (CreateException e) {
                throw new MareException(e,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
            if (clienteBloqueado) {
                UtilidadesLog.debug("El cliente posee bloqueo finaciero");
                // -> Lanzar MareException con el código de error "DTO-0017". El cliente de la solicitud tiene bloqueo financiero.
                throw new MareException(new Exception(), UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_DTO,"",
                   ErroresDeNegocio.CLIENTE_CON_BLOQUEO_FINANCIERO_0017));    
            } 
        } // fin (2)
        UtilidadesLog.debug("El cliente no posee morosidad");

        /** Comprobación de Descuento Especial a Cliente */
        UtilidadesLog.debug(" Comprobación de Descuento Especial a Cliente");
        // -> Comprobar si el atributo "DTODescuento.descuentosACliente", de tipo RecordSet, tiene registros
        // Comprobamos si hay descuentos especiales para el cliente de la solicitud
        BigDecimal porcentajeDescuentoCliente = new BigDecimal(0);
        BigDecimal importeDescuentoFijoCliente = new BigDecimal(0);
        BigDecimal descuentoLinea = new BigDecimal(0);
        // (3) Si hay descuentos especiales a clientes y la solicitud no es un reclamo.
        if ( ! descuento.getDescuentosACliente().esVacio() && ! esReclamo(solicitudProceso) ) { 
            /** Aplicar el descuento (importe o porcentaje) a todas las posiciones de la Solicitud */
            // -> Recorrer el RecordSet DTODescuento.descuentosACliente
            // Segun incidencia 7418 se busca el descuento especial al cliente de la solicitud, si hubiera sólo habría uno.
            UtilidadesLog.debug("El descuento posee descuentos a cliente y no posee base calculo");
            RecordSet rsDescuentosACliente = descuento.getDescuentosACliente();
            for (int i=0; i < rsDescuentosACliente.getRowCount(); i++) {
                // Si el oid de cliente = solicitudProceso.oidCliente entonces
                Long oidCliente = new Long(((BigDecimal)rsDescuentosACliente.getValueAt(i,"OIDCLIENTE")).longValue());
                if (oidCliente.equals(solicitudProceso.getOidCliente())) {
                    //UtilidadesLog.debug("Encontre el descuento para el cliente");
                    // -> porcentajeDescuentoCliente = porcentaje del registro
                    if (rsDescuentosACliente.getValueAt(i,"VALORPORCENTAJEDESCUENTO") != null) {
                      porcentajeDescuentoCliente = (BigDecimal)rsDescuentosACliente.getValueAt(i,"VALORPORCENTAJEDESCUENTO");
                    }
                    //UtilidadesLog.debug("porcentajeDescuentoCliente" + porcentajeDescuentoCliente);
                    // -> importeDescuentoFijoCliente = importe fijo del registro
                    if (rsDescuentosACliente.getValueAt(i,"VALORIMPORTEFIJODESCUENTO") != null) {
                      importeDescuentoFijoCliente = (BigDecimal)rsDescuentosACliente.getValueAt(i,"VALORIMPORTEFIJODESCUENTO");
                    } 
                    //UtilidadesLog.debug("importeDescuentoFijoCliente" + importeDescuentoFijoCliente);
                    // -> Salir del bucle
                    break;
                }
            } 
        } // fin (3)

        // (4) Si DTODescuento.baseCalculo == vacío
        if ( ! poseeBaseCalculo(descuento) ) {           
            Cronometrador.startTransaction("Sin Base Calculo");   

            // (5) Si (porcentajeDescuentoCliente > 0) entonces     
            if (porcentajeDescuentoCliente.compareTo(new BigDecimal(0)) == 1) {
                UtilidadesLog.debug("El porcentajeDescuentoCliente es > 0");
                // -> Recorrer solicitudProceso.posiciones
                // (6) Para cada elemento de tipo DTOSolicitudPosicionDescuento, que llamaremos posicion hacer
                DTOSolicitudPosicionDescuento posicion;
                Iterator iter = solicitudProceso.getPosiciones().iterator();
                while (iter.hasNext()) {
                    posicion = (DTOSolicitudPosicionDescuento) iter.next();
                    if (log.isDebugEnabled()) UtilidadesLog.debug("Procesando posicion: " + posicion);
                    // Se calcula el descuento de la línea
                    // -> descuentoLinea = posicion.precioUnitarioCatalogoLocal x porcentajeDescuentoCliente / 100
                    if (log.isDebugEnabled()) UtilidadesLog.debug("  -- Desc. por cliente: precio * porc / 100 y redondeamos.... " + posicion.getPrecioUnitarioCatalogoLocal() + " * " + porcentajeDescuentoCliente + " / 100 " );
                    descuentoLinea = (new BigDecimal (posicion.getPrecioUnitarioCatalogoLocal().doubleValue() * porcentajeDescuentoCliente.doubleValue())).divide(new BigDecimal(100), CANT_DECIMALES, BigDecimal.ROUND_HALF_UP);
                    UtilidadesLog.debug("decuentoLinea:: " + descuentoLinea);
                    if (log.isDebugEnabled()) UtilidadesLog.debug("descuentoLinea: " + descuentoLinea);
                    // Se acumula el descuento calculado al que ya tuviera la posición si el descuento afecta a facturas
                    // -> posicion.importeDescuentoUnitarioLocal = posicion.importeDescuentoUnitarioLocal + descuentoLinea 
                    posicion.setImporteDescuentoUnitarioLocal(posicion.getImporteDescuentoUnitarioLocal().add(descuentoLinea));
                    // -> posicion.porcentajeDescuento = posicion.porcentajeDescuento + porcentajeDescuentoCliente
                    if (posicion.getPorcentajeDescuento() == null) posicion.setPorcentajeDescuento(new BigDecimal(0));
                    posicion.setPorcentajeDescuento(posicion.getPorcentajeDescuento().add(porcentajeDescuentoCliente));

                } //fin (6)

            } else 
            // (5) Si no Si (importeDescuentoFijoCliente > 0) entonces
            if (importeDescuentoFijoCliente.compareTo(new BigDecimal(0)) == 1) {
                UtilidadesLog.debug("El importeDescuentoFijoCliente es > 0");
                // Crear variable llamada "descuento3" de tipo BigDecimal inicializada a 0
                BigDecimal descuento3 = new BigDecimal(0);
                // Si (importeDescuentoFijoCliente > solicitudProceso.montoTotalSolicitud) entonces
                if (importeDescuentoFijoCliente.compareTo(solicitudProceso.getMontoTotalSolicitud()) == 1) {
                    UtilidadesLog.debug("El importeDescuentoFijoCliente es > que solicitudProceso.montoTotalSolicitud");
                    // -> descuento3 = solicitudProceso.montoTotalSolicitud
                    descuento3 = solicitudProceso.getMontoTotalSolicitud();
                } else {
                    UtilidadesLog.debug("El importeDescuentoFijoCliente NO es > que solicitudProceso.montoTotalSolicitud");
                    // -> descuento3 = importeDescuentoFijoCliente
                    descuento3 = importeDescuentoFijoCliente;
                }
                UtilidadesLog.debug("descuento3: " + descuento3);
                // -> solicitudProceso.montoDescuento3 = descuento3
                solicitudProceso.setMontoDescuento3(descuento3);
            } //fin (5)
            Cronometrador.endTransaction("Sin Base Calculo");   

        } else 
        // Si no hay descuentos especiales a cliente o existe base de cálculo entonces...
        // (4) Si no Si (DTODescuento.baseCalculo <> vacío) entonces
        if ( poseeBaseCalculo(descuento) ) {
            Cronometrador.startTransaction("Con Base Calculo");   
            /** Calcular acumulado de venta respecto de la Base de Cálculo */
            UtilidadesLog.debug("Hay descuentos especiales a cliente o existe base de cálculo");
            Cronometrador.startTransaction("Acumulado Venta");   
            DTOAcumuladoVenta acumuladoVenta = this.calcularAcumuladoVenta(descuento, solicitudProceso);
            Cronometrador.endTransaction("Acumulado Venta");   

            Cronometrador.startTransaction("Siete");   
            // (7) Si (DTODescuento.descuentosACliente <> vacío) && (importeDescuentoFijoCliente > 0) entonces
            if ( ( ! descuento.getDescuentosACliente().esVacio() ) && (importeDescuentoFijoCliente.compareTo(new BigDecimal(0)) == 1 ) )  {
                BigDecimal descuento3 = new BigDecimal(0);
                // Si (importeDescuentoFijoCliente > DTOAcumuladoVenta.montoVentaSolicitud) entonces
                if (importeDescuentoFijoCliente.compareTo(acumuladoVenta.getMontoVentaSolicitud()) == 1) {
                    UtilidadesLog.debug("El importeDescuentoFijoCliente es > que acumuladoVenta.montoVentaSolicitud");
                    // -> descuento3 = solicitudProceso.montoTotalSolicitud
                    descuento3 = acumuladoVenta.getMontoVentaSolicitud();
                } else {
                    UtilidadesLog.debug("El importeDescuentoFijoCliente NO es > que solicitudProceso.montoTotalSolicitud");
                    // -> descuento3 = importeDescuentoFijoCliente
                    descuento3 = importeDescuentoFijoCliente;
                }
                UtilidadesLog.debug("descuento3: " + descuento3);
                solicitudProceso.setMontoDescuento3(descuento3);
            } //fin (7)
            Cronometrador.endTransaction("Siete");   

            /*
             * Recorremos cada línea comisionable comprobando si existe una base de aplicación para ella
             * y aplicamos el descuento sobre la línea de solicitud
             * y si el cálculo es real se persiste en base de datos 
             */
            BigDecimal porcentajeDescuento = new BigDecimal(0);
            BigDecimal porcentajeDescuentoAcumuladoPosicion = new BigDecimal(0);
            BigDecimal porcentajeAcumuladoCCC = new BigDecimal(0);
            BigDecimal descuentoAcumuladoCCC = new BigDecimal(0);
            // -> Llamar al metodo completarRegionSubgerencia(solicitudProceso)
            solicitudProceso = this.completarRegionSubgerencia(solicitudProceso);
            // -> Recorrer atributo solicitudProceso.posiciones de tipo arrayList de objetos DTOSolicitudPosicionDescuento
            // (8) Para cada objeto DTOSolicitudPosicionDescuento al que llamamos "posicion" hacer:
            DTOSolicitudPosicionDescuento posicion;
            Iterator iter = solicitudProceso.getPosiciones().iterator();
            Cronometrador.startTransaction("Ocho");   
            while (iter.hasNext()) {
                posicion = (DTOSolicitudPosicionDescuento) iter.next();
                if (log.isDebugEnabled()) UtilidadesLog.debug("Procesando posicion descuento: " + posicion);
                // (9) Si (posicion.productoComisionable = "true") entonces
                if ( (posicion.getProductoComisionable() != null) && (posicion.getProductoComisionable().booleanValue()) ) {
                    Cronometrador.startTransaction("NueveUno");   
                    // (9.1) Si (DTODescuento.descuentosACliente == vacío) || (importeDescuentoFijoCliente == null) entonces, aqui null  0
                    
                    //doliva -- cambio Optimizacion Logs -- 09/04/2010
                    if(log.isDebugEnabled()){ 
                        UtilidadesLog.debug("descuento.getDescuentosACliente() : " + descuento.getDescuentosACliente());
                        UtilidadesLog.debug("importeDescuentoFijoCliente.compareTo(new BigDecimal(0)) " + importeDescuentoFijoCliente.compareTo(new BigDecimal(0)) );
                        UtilidadesLog.debug("importeDescuentoFijoCliente.compareTo(new BigDecimal(0)) == 0 " + importeDescuentoFijoCliente );                    
                    }
                    
                    if (descuento.getDescuentosACliente().esVacio() || importeDescuentoFijoCliente.compareTo(new BigDecimal(0)) == 0) {
                        /** Si hay descuento especial al cliente hay que mirar si es un porcentaje, en cuyo caso se aplica este porcentaje */
                        UtilidadesLog.debug("productoComisionable es true");
                        // (10) Si (DTODescuento.descuentosACliente <> vacío) entonces
                        if ( ! descuento.getDescuentosACliente().esVacio()) {
                            UtilidadesLog.debug("Tenemos descuentos a clientes");
                            // -> Poner a null la variable porcentajeDescuentoCliente
                            porcentajeDescuentoCliente = null;
                            // -> Recorrer atributo DTODescuento.descuentosACliente de tipo RecordSet
                            // Buscamos descuento especial al cliente
                            // Mientras haya registros en el RecordSet hacer:
                            RecordSet rsDescuentosACliente = descuento.getDescuentosACliente();
                            for (int i=0; i < rsDescuentosACliente.getRowCount(); i++) {
                                // Si el campo oidCliente = solicitudProceso.oidCliente entonces
                                Long oidCliente = new Long(((BigDecimal)rsDescuentosACliente.getValueAt(i,"OIDCLIENTE")).longValue());
                                if (oidCliente.equals(solicitudProceso.getOidCliente())) {
                                    // -> Guardar valor del campo porcentajeDescuento en variable "porcentajeDescuentoCliente".
                                    // Segun Incidencia 7854 no puede ser nulo segun su creacion correcta.
                                    porcentajeDescuentoCliente = (BigDecimal)rsDescuentosACliente.getValueAt(i,"VALORPORCENTAJEDESCUENTO");
                                    // -> Salir del bucle
                                    break;
                                }
                            }
                            UtilidadesLog.debug("porcentajeDescuentoCliente: " + porcentajeDescuentoCliente);
    
                            // Si no hay ningún descuento para el cliente de la solicitud porcentajeDescuentoCliente permanece con valor null
                            // Si (porcentajeDescuentoCliente <> null) entonces
                            if (porcentajeDescuentoCliente != null) {
                                UtilidadesLog.debug("Aplicamos el descuento especial al cliente.");
                                // Se aplica el descuento especial al cliente
                                //-> porcentajeDescuento = porcentajeDescuentoCliente
                                porcentajeDescuento = porcentajeDescuentoCliente;
                            } else {
                                UtilidadesLog.debug("El porcentajeDescuentoCliente es null, buscamos base aplicacion.");
                                // Se calcula la base de aplicación para la posición
                                // -> Llamar al método "MONCalcularDTO.calcularBaseAplicacion(acumuladoVenta : DTOAcumuladoVenta,
                                // descuento : DTODescuento, posicion : DTOSolicitudPosicionDescuento) : BigDecimal"
                                Cronometrador.startTransaction("calcularBaseAplicacion A");   
                                BigDecimal baseAplicacion = this.calcularBaseAplicacion(acumuladoVenta, descuento, posicion, solicitudProceso);
                                Cronometrador.endTransaction("calcularBaseAplicacion A");   
                                // -> Guardar valor de respuesta a la llamada anterior en la variable "porcentajeDescuento"
                                porcentajeDescuento = baseAplicacion;
                                //doliva -- cambio Optimizacion Logs -- 09/04/2010
                                if(log.isDebugEnabled())
                                    UtilidadesLog.debug(" porcentajeDescuento = baseAplicacion:" + porcentajeDescuento);
                            }
                        
                        } else {
                            UtilidadesLog.debug("NO tenemos descuentos a clientes");
                            // Se calcula la base de aplicación para la posición
                            Cronometrador.startTransaction("calcularBaseAplicacion B");   
                            BigDecimal baseAplicacion = this.calcularBaseAplicacion(acumuladoVenta, descuento, posicion, solicitudProceso);
                            Cronometrador.endTransaction("calcularBaseAplicacion B");   
                            porcentajeDescuento = baseAplicacion;
                            UtilidadesLog.debug(" porcentajeDescuento = baseAplicacion:" + porcentajeDescuento);
                        } //fin (10)

                        // Se calcula el descuento de la línea
                        // -> descuentoLinea = posicion.precioUnitarioCatalogoLocal x porcentajeDescuento / 100
                        descuentoLinea = (new BigDecimal (posicion.getPrecioUnitarioCatalogoLocal().doubleValue() * porcentajeDescuento.doubleValue())).divide(new BigDecimal(100), CANT_DECIMALES, BigDecimal.ROUND_HALF_UP);
                        
                        //doliva -- cambio Optimizacion Logs -- 09/04/2010
                        if(log.isDebugEnabled())
                            UtilidadesLog.debug("descuentoLinea::: " + descuentoLinea);
                            
                        // Se acumula el descuento calculado al que ya tuviera la posición si el descuento afecta a facturas
                        if (descuento.getDatosGenerales().getAfectaAFacturas().booleanValue()) {
                            UtilidadesLog.debug("afectaAFacturas es true");
                            // -> posicion.importeDescuentoUnitarioLocal = posicion.importeDescuentoUnitarioLocal + descuentoLinea 
                            posicion.setImporteDescuentoUnitarioLocal(posicion.getImporteDescuentoUnitarioLocal().add(descuentoLinea));
                            // -> posicion.porcentajeDescuento = posicion.porcentajeDescuento + porcentajeDescuento 
                            if (posicion.getPorcentajeDescuento() == null) posicion.setPorcentajeDescuento(new BigDecimal(0));
                            posicion.setPorcentajeDescuento(posicion.getPorcentajeDescuento().add(porcentajeDescuento));
                            porcentajeDescuentoAcumuladoPosicion = posicion.getPorcentajeDescuento();
                            if(log.isDebugEnabled())
                                UtilidadesLog.debug("posicion en afectaAFacturas " + posicion);
                        } else {                            
                            // -> descuentoAcumuladoCCC = descuentoAcumuladoCCC + descuentoLinea 
                            descuentoAcumuladoCCC = descuentoAcumuladoCCC.add(descuentoLinea);                            
                            // -> porcentajeAcumuladoCCC = porcentajeAcumuladoCCC + porcentajeDescuento 
                            porcentajeAcumuladoCCC = porcentajeAcumuladoCCC.add(porcentajeDescuento);
                            
                            //doliva -- cambio Optimizacion Logs -- 09/04/2010
                            if(log.isDebugEnabled()){
                                UtilidadesLog.debug("afectaAFacturas es false");
                                UtilidadesLog.debug("descuentoAcumuladoCCC: " + descuentoAcumuladoCCC);
                                UtilidadesLog.debug("porcentajeAcumuladoCCC: " + porcentajeAcumuladoCCC);
                            }
                        }
    
                        // (11) Si (solicitudProceso.indSimulacion <> "false") entonces
                        if ( ! solicitudProceso.getIndSimulacion().booleanValue()) {
                            UtilidadesLog.debug("indSimulacion es true");
                            Cronometrador.startTransaction("Once");   
                            DTOBuzonMensajes dtoBuzonMensaje = null;
                            // Si descuento.datosGenerales.comunicacionAParticipantes y debe generar mensaje 
                            if ( descuento.getDatosGenerales().getComunicacionAParticipantes().booleanValue() && generaMensaje && ! esReclamo(solicitudProceso) ) {
                                UtilidadesLog.debug("ComunicacionAParticipantes y cumple condiciones para generar el mensaje.");
                                // Llamar al caso de uso "Insertar en buzón de mensajes" si se cumplen las condiciones
                                // Obtiene el último dtoMensajeDescuento del ArrayList mensajesDescuento 
                                String keyDescuentoMarca = this.keyMensajeDescuento(descuento, posicion);
                                DTOMensajeDescuento dtoMensajeDescuento = (DTOMensajeDescuento) hashMarcaSolicitudDescuento.get(keyDescuentoMarca);
                                dtoMensajeDescuento.setOidPais(solicitud.getOidPais());
                                dtoMensajeDescuento.setCodigoMensaje(ConstantesMSG.MENSAJE_DTO01);
                                dtoMensajeDescuento.setCliente(solicitud.getOidCliente());
                                dtoMensajeDescuento.setDv1((solicitud.getDescripcionCanal() == null) ? "" : solicitud.getDescripcionCanal());
                                if ( ! esReclamo(solicitud) ) {
                                    dtoMensajeDescuento.setDv2(solicitud.getNombrePeriodo());
                                } else {
                                    dtoMensajeDescuento.setDv2(solicitud.getNombrePeriodoDocumentoReferencia());
                                }
                                dtoMensajeDescuento.setDv3((dtoMensajeDescuento.getDescripcionMarcaProducto() == null) ? "" : dtoMensajeDescuento.getDescripcionMarcaProducto());
                                //Cambio DTO-09 autor gdmarzi. Se envia en el mensaje el decusnto acumulado en la posicion
                                dtoMensajeDescuento.setDv4(porcentajeDescuentoAcumuladoPosicion.toString());
                                // genera el mensaje
                                dtoBuzonMensaje = this.armarMensaje(dtoMensajeDescuento);
                                generaMensaje = false;
                                // reemplaza con dtoBuzonMensaje el dtoMensajeDescuento segun la key en el hash de mensajes.
                                hashMarcaSolicitudDescuento.put(keyDescuentoMarca, dtoBuzonMensaje);
                                mensajesDescuento.add(dtoBuzonMensaje);
                            }
                            Cronometrador.endTransaction("Once");   
                        } //fin (11)
                    } //fin (9.1)
                    Cronometrador.endTransaction("NueveUno");   

                    /** Se aplican descuentos de alcance administrativo */
                    UtilidadesLog.debug("Se aplican descuentos de alcance administrativo");
                    // -> (14) Recorrer atributo descuento.alcanceAdministrativo de tipo RecordSet
                    RecordSet rsAlcanceAdministrativo = descuento.getAlcanceAdministrativo();
                    if (log.isDebugEnabled()) UtilidadesLog.debug("el rsAlcanceAdministrativo, tiene: " + rsAlcanceAdministrativo);
                    Cronometrador.startTransaction("Catorce");   
                    for (int k=0; k < rsAlcanceAdministrativo.getRowCount(); k++) {
                        // (15) Si ( (zonaDescuento ==  null) || (zonaDescuento == zonaCliente) &&
                        //          (regionDescuento ==  null) || (regionDescuento == regionCliente ) &&
                        //          (subGerenciaDescuento ==  null) || (subGerenciaDescuento == subGerenciaCliente ) ) entonces
                        zonaAlcanceAdmin = (BigDecimal)rsAlcanceAdministrativo.getValueAt(k, "OID_ZONA");
                        regionAlcanceAdmin = (BigDecimal)rsAlcanceAdministrativo.getValueAt(k, "OID_REGI");
                        subgerenciaAlcanceAdmin = (BigDecimal)rsAlcanceAdministrativo.getValueAt(k, "OID_SUBG_VENT");
                        zonaValida = (zonaAlcanceAdmin == null) || (zonaAlcanceAdmin.longValue() == solicitudProceso.getZona().longValue());
                        regionValida = (regionAlcanceAdmin == null) || (regionAlcanceAdmin.longValue() == solicitudProceso.getRegion().longValue());
                        subgerenciaValida = (subgerenciaAlcanceAdmin == null) || (subgerenciaAlcanceAdmin.longValue() == solicitudProceso.getSubgerencia().longValue());
                        if (log.isDebugEnabled()) UtilidadesLog.debug("subgerenciaValida: " + subgerenciaValida + " regionValida: " + regionValida + " zonaValida: " + zonaValida );
                        if (zonaValida && regionValida && subgerenciaValida) {
                            UtilidadesLog.debug("Coincide en nivel de zonificacion de alcanceAdministrativo del descuento con el nivel de zonificacon del cliente.");
                            // -> Obtener el porcentaje de descuento y guardar en la variable porcentajeDescuento
                            porcentajeDescuento = (BigDecimal)rsAlcanceAdministrativo.getValueAt(k, "VAL_PORC_ADIC");
                            //el campo VAL_PORC_ADIC puede ser nulo en la base
                            if (porcentajeDescuento == null){
                                UtilidadesLog.debug("porcentajeDescuento = VAL_PORC_ADIC es nulo");
                                porcentajeDescuento = new BigDecimal (0);
                            }
                            
                            // Se calcula el descuento de la línea, se redondea segun cambio 20090907
                            descuentoLinea = (new BigDecimal (posicion.getPrecioUnitarioCatalogoLocal().doubleValue() * porcentajeDescuento.doubleValue())).divide(new BigDecimal(100), CANT_DECIMALES, BigDecimal.ROUND_HALF_UP);
                            //doliva -- cambio Optimizacion Logs -- 09/04/2010
                            if(log.isDebugEnabled()){
                                UtilidadesLog.debug("porcentajeDescuento = VAL_PORC_ADIC: " + porcentajeDescuento);
                                UtilidadesLog.debug("decuentoLinea:::: " + descuentoLinea);
                            }
                            // Se acumula el descuento calculado al que ya tuviera la posición si el descuento afecta a facturas
                            // (24)Si (descuento.datosGenerales.afectaAFacturas = "true") entonces
                            if (descuento.getDatosGenerales().getAfectaAFacturas().booleanValue()) {                                
                                // -> posicion.importeDescuentoUnitarioLocal = posicion.importeDescuentoUnitarioLocal + descuentoLinea                                 
                                if (posicion.getImporteDescuentoUnitarioLocal() == null) posicion.setImporteDescuentoUnitarioLocal(new BigDecimal(0)); //linea agregada x SCS                                
                                posicion.setImporteDescuentoUnitarioLocal(posicion.getImporteDescuentoUnitarioLocal().add(descuentoLinea));
                                // -> posicion.porcentajeDescuento = posicion.porcentajeDescuento + porcentajeDescuento                                 
                                if (posicion.getPorcentajeDescuento() == null) posicion.setPorcentajeDescuento(new BigDecimal(0)); //linea agregada x SCS
                                posicion.setPorcentajeDescuento(posicion.getPorcentajeDescuento().add(porcentajeDescuento));
                                
                                //doliva -- cambio Optimizacion Logs -- 09/04/2010
                                if(log.isDebugEnabled()){
                                    UtilidadesLog.debug("AfectaAFacturas es true.");
                                    UtilidadesLog.debug("posicion.getImporteDescuentoUnitarioLocal(), es: " + posicion.getImporteDescuentoUnitarioLocal());
                                    UtilidadesLog.debug("posicion.getPorcentajeDescuento(), es: " + posicion.getPorcentajeDescuento());
                                    UtilidadesLog.debug("posicion en afectaAFacturas 3: " + posicion);
                                }
                            } else {                                
                                // -> descuentoAcumuladoCCC = descuentoAcumuladoCCC + descuentoLinea 
                                descuentoAcumuladoCCC = descuentoAcumuladoCCC.add(descuentoLinea);                                
                                // -> porcentajeAcumuladoCCC = porcentajeAcumuladoCCC + porcentajeDescuento 
                                porcentajeAcumuladoCCC = porcentajeAcumuladoCCC.add(porcentajeDescuento);
                                
                                //doliva -- cambio Optimizacion Logs -- 09/04/2010
                                if(log.isDebugEnabled()){
                                    UtilidadesLog.debug("AfectaAFacturas es false.");
                                    UtilidadesLog.debug("descuentoAcumuladoCCC: " + descuentoAcumuladoCCC);
                                    UtilidadesLog.debug("porcentajeAcumuladoCCC: " + porcentajeAcumuladoCCC);
                                }
                            }

                            // (16) Si (solicitudProceso.indSimulacion <> "false") entonces
                            if ( ! solicitudProceso.getIndSimulacion().booleanValue()) {
                                UtilidadesLog.debug("IndSimulacion es true");
                                // -> Crear variable mensaje de tipo DTOBuzonMensajes inializada a null
                                // Si (DTODescuento.datosGenerales.comunicacionAParticipantes = "true") entonces
                                if ( descuento.getDatosGenerales().getComunicacionAParticipantes().booleanValue() && ! esReclamo(solicitudProceso) ) {
                                    UtilidadesLog.debug("ComunicacionAParticipantes es true");
                                    // Llamar al caso de uso "Insertar en buzón de mensajes" si se cumplen las condiciones 
                                    DTOMensajeDescuento dtoMensaje =  new DTOMensajeDescuento();
                                    dtoMensaje.setOidPais(solicitudProceso.getOidPais());
                                    dtoMensaje.setCliente(solicitudProceso.getOidCliente());
                                    dtoMensaje.setCodigoMensaje(ConstantesMSG.MENSAJE_DTO02);
                                    dtoMensaje.setDv1((solicitudProceso.getOidMarca() == null) ? "" : solicitudProceso.getOidMarca().toString() );
                                    dtoMensaje.setDv2((solicitudProceso.getOidCanal() == null) ? "" : solicitudProceso.getOidCanal().toString() );
                                    dtoMensaje.setDv3(solicitudProceso.getOidPeriodo().toString());
                                    dtoMensaje.setDv4(descuento.getDatosGenerales().getDescripcion());
                                    dtoMensaje.setDv5(descuentoAcumuladoCCC.toString());
                                    // genera el mensaje 
                                    this.generarMensajeSimulacion(dtoMensaje);
                                }
                            } // fin (16)

                        } // fin (15)

                    } //fin (14)
                    Cronometrador.endTransaction("Catorce");   

                } //fin (9)

            } //fin (8)
            Cronometrador.endTransaction("Ocho");   

            /** Se abre solicitud de abono a cuentas corrientes si estamos en un cálculo real */
            // Si (solicitudProceso.indSimulacion = "false") entonces
            if ( ! solicitudProceso.getIndSimulacion().booleanValue() ) {
                UtilidadesLog.debug("IndSimulacion es false");
                // Si (descuentoAcumuladoCCC <> 0) entonces
                if (descuentoAcumuladoCCC.doubleValue() != 0) {
                    UtilidadesLog.debug("descuentoAcumuladoCCC es <> 0");
                    this.generarSolicitudDescuento(solicitud, descuentoAcumuladoCCC);
                }
            }
            Cronometrador.endTransaction("Con Base Calculo");   

        } else {
            UtilidadesLog.debug("Descuento erroneo, porque no hay descuento especiales a clientes y no hay base calculo asociada.");
            // -> Lanzar MareException con el código de error "DTO-0018"
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_DTO,"",
               ErroresDeNegocio.DESCUENTO_ERRONEO_0018));    
        } //fin (4)

        UtilidadesLog.info("MONCalcularDTO.aplicarDescuento(): Salida");
        // -> Devolver variable "solicitudProceso"
        return solicitudProceso;
    }


    /**
     * Retorna void
     * 
     * @autor ciglesias
     */
     /*metodo creador por incidecia BELC300024362 ciglesias*/
     private void generarSolicitudDescuento(DTOSolicitudDescuento solicitudProceso, BigDecimal descuentoAcumuladoCCC) 
        throws MareException
     {
        
        UtilidadesLog.info("MONCalcularDTO.generarSolicitudDescuento(): Entrada");
        
        DTOTipoSolicitud dtoTipoSolicitud = new DTOTipoSolicitud();
        dtoTipoSolicitud.setOidPais(solicitudProceso.getOidPais());
        dtoTipoSolicitud.setMarca(solicitudProceso.getOidMarca());
        dtoTipoSolicitud.setCanal(solicitudProceso.getOidCanal());
        dtoTipoSolicitud.setAcceso(solicitudProceso.getOidAcceso());
        dtoTipoSolicitud.setSubacceso(solicitudProceso.getOidSubAcceso());

        try
        {
            MONConfiguracionClientesHome monConfClientesHome = 
                this.getMONConfiguracionClientesHome();
                
            MONConfiguracionClientes monConfClientes = monConfClientesHome.create();
            
            dtoTipoSolicitud.setTipoCliente(
                (monConfClientes.
                    obtenerTipoPrincipalCliente(solicitudProceso.getOidCliente())).
                        getTipo());
                        
                        
        } catch (RemoteException e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (CreateException e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        
        DTOTipoSolicitudProceso dtoTipoSolProc = new DTOTipoSolicitudProceso();
        DAODescuento daoDescuento = new DAODescuento();
       
        dtoTipoSolProc = daoDescuento.obtenerTipoSolProcDTO(dtoTipoSolicitud);
        
        if (dtoTipoSolProc == null)
        {
          UtilidadesLog.debug(ErroresDeNegocio.DTO_0022 + 
            " Solicitud: " + solicitudProceso.getNumSolicitud() + 
            ", Pais: " + solicitudProceso.getOidPais() + 
            ", Marca: " + solicitudProceso.getOidMarca() + 
            ", Canal: " + solicitudProceso.getOidCanal() + 
            ", Acceso: " + solicitudProceso.getOidAcceso() + 
            ", Subacceso: " + solicitudProceso.getOidSubAcceso());
        }
        else
        {
                 DTOCabeceraSolicitud dtoCabSol = new DTOCabeceraSolicitud();
                 dtoCabSol.setOidPais(solicitudProceso.getOidPais());
                 dtoCabSol.setOperacion(ConstantesBEL.DTO017);
                 dtoCabSol.setModulo(new Long(ConstantesSEG.MODULO_DTO));
                 dtoCabSol.setTipoSolicitud(dtoTipoSolProc.getTipoSolicitud());
                 dtoCabSol.setOidCliente(solicitudProceso.getOidCliente());
                 dtoCabSol.setCliente(solicitudProceso.getCodigoCliente());
                 dtoCabSol.setTipoCliente(dtoTipoSolicitud.getTipoCliente());
                 dtoCabSol.setMarca(solicitudProceso.getOidMarca());
                 dtoCabSol.setCanal(solicitudProceso.getOidCanal());
                 dtoCabSol.setAcceso(solicitudProceso.getOidAcceso());
                 dtoCabSol.setSubacceso(solicitudProceso.getOidSubAcceso());
                 dtoCabSol.setNumeroDocumentoOrigen(solicitudProceso.getOidSolicitud());
                 dtoCabSol.setPeriodo(solicitudProceso.getOidPeriodo());
                 dtoCabSol.setMoneda(solicitudProceso.getOidMoneda());

                 DTOPosicionSolicitud dtoPosSol = new DTOPosicionSolicitud();
                 dtoPosSol.setTipoPosicion(dtoTipoSolProc.getTipoPosicion());
                 dtoPosSol.setSubtipoPosicion(dtoTipoSolProc.getSubtipoPosicion());

              
                 if (descuentoAcumuladoCCC.intValue() > 0)
                 {
                         dtoPosSol.setUnidadesDemandadas(new Long(1));
                         dtoPosSol.setPrecioCatalogoUnitarioLocal(descuentoAcumuladoCCC);
                 }
                 else
                 {
                         dtoPosSol.setUnidadesDemandadas(new Long(-1));
                         dtoPosSol.setPrecioCatalogoUnitarioLocal(new BigDecimal(-1).multiply(descuentoAcumuladoCCC) );
                 }
                         

                 dtoCabSol.getPosiciones().add(dtoPosSol);
           
                 //Se invoca al caso de uso "Generar Solicitud Desde Módulos Externos" de PED
                try
                {
                    MONGenerarSolicitudModulosExternosHome monGenSolModExtHome = 
                        this.getMONGenerarSolicitudModulosExternosHome();
                        
                    MONGenerarSolicitudModulosExternos monGenSolModExt = monGenSolModExtHome.create();
                    
                    monGenSolModExt.generaSolicitud(dtoCabSol);
                    
                } catch (RemoteException e) {
                    throw new MareException(e,
                        UtilidadesError.armarCodigoError(
                            CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                } catch (CreateException e) {
                    throw new MareException(e,
                        UtilidadesError.armarCodigoError(
                            CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }
                    
        }
        UtilidadesLog.info("MONCalcularDTO.generarSolicitudDescuento(): Salida");
     }


    /**
     * Retorna un dtoHistoricoDescuento.
     * Arma el dtoHistoricoDescuento de acuerdo a los parametros de entrada y la 
     * colaboracion con el mon MONMantenimientoMF y la entidad MatrizFacturacion.
     * @autor gdmarzi
     * @brecha DTO-08
     * @deprecated
     */
    private DTOHistoricoDescuento crearEntradaHistorico(DTOAcumuladoVenta acumuladoVenta, DTOSolicitudDescuento solicitudProceso,
                                        DTOSolicitudPosicionDescuento posicion, BigDecimal porcentajeDescuento, BigDecimal importeFijo, 
                                        DTODescuento descuento, DTOBuzonMensajes mensaje) throws MareException {
        return null;
    }

    
    /**
     * Generar los historicos de los descuentos aplicados a una solicitud.
     * Los historicos de descuento se tienen en cuenta a nivel soliciud y a nivel posicion.
     * Se limpia el listado historicosDescuentos, una vez procesados los mismos.
     * @autor gdmarzi
     * @Cambio Brecha DTO-08
     * @deprecated
     */
    private void generarHistoricoDescuentos(ArrayList historicosDescuento, Long oidPais, Long oidSolictud) throws MareException {

    }


    /**
     * Retorna DTOAcumuladoVenta.
     * Calcula el acumulado de venta de la solicitud para un descuento reflejandolo en dtoAcumuladoVenta.
     * Los atributos calculados son montoVentaSolicitud, numeroUnidadesSolicitud, montoVentaAcumulado, numeroUnidadesAcumulado.
     * @autor gdmarzi
     * @cambio Si la solicitud es de reclamos se debe tomar el monto de venta de la solicitud OC de referencia.
     *         Esta monto de venta se utiliza como base de calculo. Incidencia SiCC 20070297.
     *         Si la solicitud es de reclamos no se aplica el indicador de descuento acumulativo.
     * @autor gdmarzi
     */
    private DTOAcumuladoVenta calcularAcumuladoVenta(DTODescuento descuento, DTOSolicitudDescuento solicitud) throws MareException {
        UtilidadesLog.info("MONCalcularDTO.calcularAcumuladoVenta(): Entrada");
        Boolean perteneceABaseCalculo;
        DTOAcumuladoVenta dtoAcumuladoVenta = new DTOAcumuladoVenta();
        dtoAcumuladoVenta.setMontoVentaAcumulado(new BigDecimal(0));
        dtoAcumuladoVenta.setMontoVentaSolicitud(new BigDecimal(0));
        dtoAcumuladoVenta.setNumeroUnidadesAcumulado(new Long(0));
        dtoAcumuladoVenta.setNumeroUnidadesSolicitud(new Long(0));
        BigDecimal montoVentaPosicion;
        Iterator iterPos;
        
        // Si la solicitud es OC se acumulan las posiciones, si es de reclamos se acumulan las posiciones de la solicitud de referencia.
        if ( ! esReclamo(solicitud) ) {
            iterPos = solicitud.getPosiciones().iterator();
        } else {
            iterPos = solicitud.getPosicionesSolictudReferencia().iterator();
        }

        /** Acumulamos los valores de las posiciones de la solicitud de entrada */ 
        // -> Recorrer atributo DTOSolicitudDescuento.posiciones de tipo arrayList de objetos DTOSolicitudPosicionDescuento 
        while (iterPos.hasNext()) {
            DTOSolicitudPosicionDescuento posicion = (DTOSolicitudPosicionDescuento)iterPos.next();
            if (log.isDebugEnabled()) { 
                UtilidadesLog.debug("Procesando SolicitudPosicionDescuento: " +  posicion);
                UtilidadesLog.debug("posicion.getOidPosicion() " + posicion.getOidPosicion());
                UtilidadesLog.debug("posicion.getUnidadesPorAtender() " + posicion.getUnidadesPorAtender());
                UtilidadesLog.debug("posicion.getPrecioUnitarioCatalogoLocal() " + posicion.getPrecioUnitarioCatalogoLocal());
            }
            // Si (DTOSolicitudPosicionDescuento.estadoPosicion != ConstantesPED.ANULADO OR DTOSolicitudPosicionDescuento.estadoPosicion != ConstantesPED.BLOQUEADO) entonces
            if ((posicion.getEstadoPosicion() != ConstantesPED.ESTADO_POSICION_ANULADO) || (posicion.getEstadoPosicion() != ConstantesPED.ESTADO_POSICION_BLOQUEADO)) {
                // Si (DTOSolicitudPosicionDescuento.productoAportaMontoAEscala = "true") entonces 
                if ( ( posicion.getProductoAportaMontoAEscala() != null) && 
                       posicion.getProductoAportaMontoAEscala().booleanValue() ) {
                    UtilidadesLog.debug("El productoAportaMontoAEscala es true");
                    // -> Llamar al método "MONCalcularDTO.perteneceABaseCalculo(baseCalculo : DTOSBaseCalculo, posicion : DTOSolicitudPosicionDescuento) : Boolean" 
                    // pasando el objeto DTODescuento.baseCalculo[0] del descuento de entrada y el objeto DTOSolicitudPosicionDescuento creado 
                    perteneceABaseCalculo = this.perteneceABaseCalculo((DTOSBaseCalculo)descuento.getBaseCalculo().get(0), posicion);
                    // Si (valor recuperado = "true") entonces 
                    if (perteneceABaseCalculo.booleanValue()) {
                        UtilidadesLog.debug("El perteneceABaseCalculo es true");
                        // -> Hacer la siguiente operación: dto.unidadesPorAtender x dto.precioUnitarioCatalogoLocal 
                        montoVentaPosicion = (new BigDecimal(posicion.getUnidadesPorAtender().doubleValue())).multiply(posicion.getPrecioUnitarioCatalogoLocal());
                        // -> Acumular montoVentaPosicion al valor de la variable DTOAcumuladoVenta.montoVentaSolicitud 
                        dtoAcumuladoVenta.setMontoVentaSolicitud(dtoAcumuladoVenta.getMontoVentaSolicitud().add(montoVentaPosicion));
                        // -> Acumular el valor del atributo dto.unidadesPorAtencer al valor de la variable DTOAcumuladoVenta.numeroUnidadesSolicitud 
                        dtoAcumuladoVenta.setNumeroUnidadesSolicitud(new Long(dtoAcumuladoVenta.getNumeroUnidadesSolicitud().longValue() + posicion.getUnidadesPorAtender().longValue()));
                        // -> Acumular montoVentaPosicion al valor de la variable DTOAcumuladoVenta.montoVentaAcumulado 
                        dtoAcumuladoVenta.setMontoVentaAcumulado(dtoAcumuladoVenta.getMontoVentaAcumulado().add(montoVentaPosicion));
                        // -> Acumular el valor del atributo dto.unidadesPorAtencer al valor de la variable DTOAcumuladoVenta.numeroUnidadesAcumulado 
                        dtoAcumuladoVenta.setNumeroUnidadesAcumulado(new Long(dtoAcumuladoVenta.getNumeroUnidadesAcumulado().longValue() + posicion.getUnidadesPorAtender().longValue()));
                    }
                }
            }
        }
        if (log.isDebugEnabled()) UtilidadesLog.debug("dtoAcumuladoVenta parcial: " + dtoAcumuladoVenta);

        if ( ! esReclamo(solicitud) ) {
            /** Acumulamos los valores de las solicitudes anteriores del mismo periodo y cliente, teniendo en cuenta la base de cálculo **/ 
            // Comprobar si el descuento es acumulativo 
            if ( descuento.getDatosGenerales().getDescuentoAcumulativo().booleanValue() ) {
                UtilidadesLog.debug("Acumulamos los datos segun la base de calculo de todas las solicitudes");
                DAOSolicitud daoSolicitud = new DAOSolicitud();
    
                DTOSalida dtoSalida = daoSolicitud.obtenerPosicionesAcumuladasPeriodoClienteBaseCalculoDTO(solicitud.getOidSolicitud(), solicitud.getOidPeriodo(), solicitud.getOidCliente());
                RecordSet rsPosiciones = dtoSalida.getResultado();
                for(int i=0; i < rsPosiciones.getRowCount(); i++) {
                    // -> Crear objeto DTOSolicitudPosicionDescuento vacío llamado "dtoPosicion" y mapear el registro en él 
                    DTOSolicitudPosicionDescuento dtoPosicion = new DTOSolicitudPosicionDescuento();
                    dtoPosicion.setUnidadesPorAtender(new Long(((BigDecimal)rsPosiciones.getValueAt(i,"SUMAAGRUPADAUNIDADESPORATENDER")).toString()));
                    dtoPosicion.setValorTotal((BigDecimal)rsPosiciones.getValueAt(i,"SUMAAGRUPADAMONTOVENTAPOSICION"));
                    if (rsPosiciones.getValueAt(i,"OIDMARCAPRODUCTO") != null) {
                        dtoPosicion.setOidMarcaProducto(new Long(((BigDecimal)rsPosiciones.getValueAt(i,"OIDMARCAPRODUCTO")).toString()));
                    }
                    if (rsPosiciones.getValueAt(i,"OIDUNIDADNEGOCIO") != null) {
                        dtoPosicion.setOidUnidadNegocio(new Long(((BigDecimal)rsPosiciones.getValueAt(i,"OIDUNIDADNEGOCIO")).toString()));
                    }
                    if (rsPosiciones.getValueAt(i,"OIDNEGOCIO") != null) {
                        dtoPosicion.setOidNegocio(new Long(((BigDecimal)rsPosiciones.getValueAt(i,"OIDNEGOCIO")).toString()));
                    }
                    if (rsPosiciones.getValueAt(i,"OIDSUPERGENERICO") != null) {
                        dtoPosicion.setOidSupergenerico(new Long(((BigDecimal)rsPosiciones.getValueAt(i,"OIDSUPERGENERICO")).toString()));
                    }
                    if (rsPosiciones.getValueAt(i,"OIDGENERICO") != null) {
                        dtoPosicion.setOidGenerico(new Long(((BigDecimal)rsPosiciones.getValueAt(i,"OIDGENERICO")).toString()));
                    }
                    dtoPosicion.setOidTipoOferta(new Long(((BigDecimal)rsPosiciones.getValueAt(i,"OIDTIPOOFERTA")).toString()));
                    if (rsPosiciones.getValueAt(i,"OIDCICLOVIDA") != null) {
                        dtoPosicion.setOidCicloVida(new Long(((BigDecimal)rsPosiciones.getValueAt(i,"OIDCICLOVIDA")).toString()));
                    }
                    dtoPosicion.setOidProducto(new Long(((BigDecimal)rsPosiciones.getValueAt(i,"OIDPRODUCTO")).toString()));
                    dtoPosicion.setIndicadorDevolucion(Boolean.valueOf((String)rsPosiciones.getValueAt(i,"INDICADORDEVOLUCION")));
                    dtoPosicion.setIndicadorAnulacion(Boolean.valueOf((String)rsPosiciones.getValueAt(i,"INDICADORANULACION")));
                    UtilidadesLog.debug("agrupacion posicion por periodo cliente en proceso: " + dtoPosicion);
                    // -> Llamar al método "MONCalcularDTO.perteneceABaseCalculo(baseCalculo : DTOSBaseCalculo, posicion : DTOSolicitudPosicionDescuento) : Boolean" 
                    // pasando el objeto descuento.baseCalculo[0] de entrada y el objeto DTOSolicitudPosicionDescuento creado
                    perteneceABaseCalculo = this.perteneceABaseCalculo((DTOSBaseCalculo)descuento.getBaseCalculo().get(0), dtoPosicion);
                    // Si (valor recuperado = "true") entonces 
                    if (perteneceABaseCalculo.booleanValue()) {
                        UtilidadesLog.debug("perteneceABaseCalculo es true");
                        // Si el descuento permite anulaciones y la solicitud es de tipo de anulacion 
                        // o si el descuento permite devoluciones y la solicitud es de tipo de devolucion 
                        if ( ( descuento.getDatosGenerales().getControlAnulaciones().booleanValue()
                                && dtoPosicion.getIndicadorAnulacion().booleanValue() )
                            || ( descuento.getDatosGenerales().getControlDevoluciones().booleanValue() 
                                && dtoPosicion.getIndicadorDevolucion().booleanValue() ) ) {
                            // -> Hacer la siguiente operación: dto.unidadesPorAtender x dto.precioUnitarioCatalogoLocal 
                            montoVentaPosicion = dtoPosicion.getValorTotal();
                            // -> Restar resultado de la operación anterior al valor de la variable DTOAcumuladoVenta.montoVentaAcumulado 
                            dtoAcumuladoVenta.setMontoVentaAcumulado(dtoAcumuladoVenta.getMontoVentaAcumulado().subtract(montoVentaPosicion));
                            // -> Restar el valor del atributo dto.unidadesPorAtencer al valor de la variable DTOAcumuladoVenta.numeroUnidadesAcumulado 
                            dtoAcumuladoVenta.setNumeroUnidadesAcumulado(new Long(dtoAcumuladoVenta.getNumeroUnidadesAcumulado().longValue() - dtoPosicion.getUnidadesPorAtender().longValue()));
                        } else {
                            // -> Hacer la siguiente operación: dto.unidadesPorAtender x dto.precioUnitarioCatalogoLocal 
                            montoVentaPosicion = dtoPosicion.getValorTotal();
                            // -> Acumular resultado de la operación anterior al valor de la variable DTOAcumuladoVenta.montoVentaAcumulado 
                            dtoAcumuladoVenta.setMontoVentaAcumulado(dtoAcumuladoVenta.getMontoVentaAcumulado().add(montoVentaPosicion));
                            // -> Acumular el valor del atributo dto.unidadesPorAtencer al valor de la variable DTOAcumuladoVenta.numeroUnidadesAcumulado 
                            dtoAcumuladoVenta.setNumeroUnidadesAcumulado(new Long(dtoAcumuladoVenta.getNumeroUnidadesAcumulado().longValue() + dtoPosicion.getUnidadesPorAtender().longValue()));
                        }
                    }
                }
            }
        }
        if (log.isDebugEnabled()) UtilidadesLog.debug("dtoAcumuladoVenta final: " + dtoAcumuladoVenta);

        UtilidadesLog.info("MONCalcularDTO.calcularAcumuladoVenta(): Salida");
        return dtoAcumuladoVenta;
    }    


    /**
     * Este método valida si el producto pertenece a la base de cálculo del descuento,
     * en cuyo caso devuelve "true", en caso contrario devuelve "false".
     * @autor gdmarzi
     * @cambio Incidencia Cliente
     * - Si el flag de exclusión no está marcado, sólo se aplica el descuento (base de cálculo o aplicación, según corresponda) a los productos que cumplan que el tipo de oferta está entre los seleccionados. 
     * En este caso, la aplicación OBLIGA a seleccionar siempre al menos un tipo de oferta al crear las bases
     * - Si el flag de exclusión SI está marcado y se han seleccionado tipos de oferta, se aplica el descuento a los productos que NO tengan alguno de los tipos de oferta excluidos
     *  flag de exclusión SI está marcado pero no se ha seleccionado ningún tipo de oferta, la lógica a aplicar es "No se excluye ningún tipo de oferta", por tanto se aplica el descuento a todos. 
     *  Esta opción sería equivalente a no marcar el flag y seleccionar todos los tipos de oferta (se aplica el descuento a todos los tipos de oferta).
     * @autor gdmarzi
     */
    private Boolean perteneceABaseCalculo(DTOSBaseCalculo baseCalculo, DTOSolicitudPosicionDescuento posicion) throws MareException {
        UtilidadesLog.info("MONCalcularDTO.perteneceABaseCalculo(): Entrada");
        // -> Crear variable de tipo Boolean llamada pertenece = "false" 
        boolean pertenece = false;
        boolean violaExclusion = false;
        boolean exclusionChequeada = false;
        boolean inclusionValida = false;
        boolean perteneceFinal = false;
        // -> Recorrer atributo baseCalculo.detalle de tipo arrayList que contiene objetos DTOSBaseCalculoDetalle 
        if (baseCalculo.getDetalle() != null) {
            if (log.isDebugEnabled()) UtilidadesLog.debug("nro detalles de la base calculo " + baseCalculo.getDetalle().size());
            Iterator iterExc = baseCalculo.getDetalle().iterator();
            /** Verificamos que NO exista el tipo de oferta como exluido en algun detalle de la base de calculo  */
            while (iterExc.hasNext()) {
                // -> Tomar DTOSBaseAplicacionDetalle de turno contenido en el array 
                DTOSBaseCalculoDetalle baseCalculoDetalle = (DTOSBaseCalculoDetalle)iterExc.next();
                if (log.isDebugEnabled()) {
                    UtilidadesLog.debug("baseCalculoDetalle analisis exlusion: ");
                    UtilidadesLog.debug("  Marca " + baseCalculoDetalle.getMarca());
                    UtilidadesLog.debug("  UnidadNegocio :" + baseCalculoDetalle.getUnidadNegocio());
                    UtilidadesLog.debug("  SuperGenreico :" + baseCalculoDetalle.getSupergenerico());
                    UtilidadesLog.debug("  Generico :" + baseCalculoDetalle.getGenerico());
                    UtilidadesLog.debug("  Producto :" + baseCalculoDetalle.getProducto());
                    UtilidadesLog.debug("  CicloVida :" + baseCalculoDetalle.getCicloVida());
                    UtilidadesLog.debug("  Exclusion :" + baseCalculoDetalle.getExclusionTipoOferta());
                    UtilidadesLog.debug("  TipoOferta :" + baseCalculoDetalle.getTipoOferta());
                    UtilidadesLog.debug("  Marca :" + baseCalculoDetalle.getMarca());
                }
                // -> pertenece = ( ( (posicion.oidMarcaProducto == detalleBase.marca) || (detalleBase.marca == null) ) &&
                pertenece = (baseCalculoDetalle.getMarca() == null) || baseCalculoDetalle.getMarca().equals(posicion.getOidMarcaProducto());
                // (DTOSolicitudPosicionDescuento.oidUnidadNegocio = DTOSBaseAplicacionDetalle.unidadNegocio ó null) && 
                pertenece = pertenece && ( (baseCalculoDetalle.getUnidadNegocio() == null) || baseCalculoDetalle.getUnidadNegocio().equals(posicion.getOidUnidadNegocio()) );
                // ( (posicion.oidNegocio == detalleBase.negocio) || (detalleBase.negocio == null) ) &&
                pertenece = pertenece && ( (baseCalculoDetalle.getNegocio() == null) || baseCalculoDetalle.getNegocio().equals(posicion.getOidNegocio()) );
                // ( (posicion.oidSuperGenerico == detalleBase.superGenerico) || (detalleBase.superGenerico == null) ) &&
                pertenece = pertenece && ( (baseCalculoDetalle.getSupergenerico() == null) || baseCalculoDetalle.getSupergenerico().equals(posicion.getOidSupergenerico()) );
                // ( (posicion.oidGenerico == detalleBase.generico) || (detalleBase.unidadGenerico == null) )&&
                pertenece = pertenece && ( (baseCalculoDetalle.getGenerico() == null) || baseCalculoDetalle.getGenerico().equals(posicion.getOidGenerico()) );
                // ( (posicion.oidProducto == detalleBase.producto) || (detalleBase.producto == null) ) &&
                pertenece = pertenece && ( (baseCalculoDetalle.getProducto() == null) || baseCalculoDetalle.getProducto().equals(posicion.getOidProducto()) );
                // (posicion.oidCicloVida == detalleBase.cicloVida)&& 
                pertenece = pertenece && ( (baseCalculoDetalle.getCicloVida() == null) || baseCalculoDetalle.getCicloVida().equals(posicion.getOidCicloVida()) );
                // si el indicadro exclusion tipo eferta esta en null es false
                if (baseCalculoDetalle.getExclusionTipoOferta() == null) {
                    baseCalculoDetalle.setExclusionTipoOferta(Boolean.FALSE);
                }
                
                //doliva -- cambio Optimizacion Logs -- 09/04/2010
                if(log.isDebugEnabled())
                    UtilidadesLog.debug("pertenece verificando exlusion vii :" + pertenece);                

                // Si la posicion viene cmpliendo los primeros criterios
                if ( pertenece ) {
                    // si ExclusionTipoOferta es true verificamos exclusion
                    if (baseCalculoDetalle.getExclusionTipoOferta().booleanValue()) {
                        exclusionChequeada = true;
                        // Si la posicion tiene definido el tipoOferta 
                        if ( posicion.getOidTipoOferta() != null ) {
                            // si coincide el tipoOferta de al menos un detalle de base de aplicacion con el tipoOferta de la posicion, entonces violaExclusion.
                            if (posicion.getOidTipoOferta().equals(baseCalculoDetalle.getTipoOferta()) ) {
                                violaExclusion = true;    
                            }
                        } else {
                            // como indicador exclusion tipo oferta esta en true y el tipoOferta es null, son todos los tipos ofertas validos
                            inclusionValida = true;
                        }
                    }
                }
            } //while exclusion
            if (log.isDebugEnabled()) { 
                UtilidadesLog.debug("exclCheq: " + exclusionChequeada);                
                UtilidadesLog.debug("vioExc: " + violaExclusion);                
                UtilidadesLog.debug("inclVali: " + inclusionValida);                
            }
            //si ya chequeamos exlusion tipo oferta, el tipo oferta que no esta excluido esta incluido.
            if (exclusionChequeada) {
                if ( ( ! violaExclusion ) || inclusionValida ) {
                    perteneceFinal = true;
                }
            } else {
                Iterator iterIncl = baseCalculo.getDetalle().iterator();
                /** Verificamos que exista el tipo de oferta como inlcluido en algun detalle de la base de calculo */
                while (iterIncl.hasNext()) {
                    // -> Tomar DTOSBaseAplicacionDetalle de turno contenido en el array 
                    DTOSBaseCalculoDetalle baseCalculoDetalle = (DTOSBaseCalculoDetalle)iterIncl.next();
                    // -> pertenece = ( ( (posicion.oidMarcaProducto == detalleBase.marca) || (detalleBase.marca == null) ) &&
                    pertenece = (baseCalculoDetalle.getMarca() == null) || baseCalculoDetalle.getMarca().equals(posicion.getOidMarcaProducto());
                    // (DTOSolicitudPosicionDescuento.oidUnidadNegocio = DTOSBaseAplicacionDetalle.unidadNegocio ó null) && 
                    pertenece = pertenece && ( (baseCalculoDetalle.getUnidadNegocio() == null) || baseCalculoDetalle.getUnidadNegocio().equals(posicion.getOidUnidadNegocio()) );
                    // ( (posicion.oidNegocio == detalleBase.negocio) || (detalleBase.negocio == null) ) &&
                    pertenece = pertenece && ( (baseCalculoDetalle.getNegocio() == null) || baseCalculoDetalle.getNegocio().equals(posicion.getOidNegocio()) );
                    // ( (posicion.oidSuperGenerico == detalleBase.superGenerico) || (detalleBase.superGenerico == null) ) &&
                    pertenece = pertenece && ( (baseCalculoDetalle.getSupergenerico() == null) || baseCalculoDetalle.getSupergenerico().equals(posicion.getOidSupergenerico()) );
                    // ( (posicion.oidGenerico == detalleBase.generico) || (detalleBase.unidadGenerico == null) )&&
                    pertenece = pertenece && ( (baseCalculoDetalle.getGenerico() == null) || baseCalculoDetalle.getGenerico().equals(posicion.getOidGenerico()) );
                    // ( (posicion.oidProducto == detalleBase.producto) || (detalleBase.producto == null) ) &&
                    pertenece = pertenece && ( (baseCalculoDetalle.getProducto() == null) || baseCalculoDetalle.getProducto().equals(posicion.getOidProducto()) );
                    // (posicion.oidCicloVida == detalleBase.cicloVida)&& 
                    pertenece = pertenece && ( (baseCalculoDetalle.getCicloVida() == null) || baseCalculoDetalle.getCicloVida().equals(posicion.getOidCicloVida()) );
                    // si el indicadro exclusion tipo eferta esta en null es false
                    if (baseCalculoDetalle.getExclusionTipoOferta() == null) {
                        baseCalculoDetalle.setExclusionTipoOferta(Boolean.FALSE);
                    }
                    
                    //doliva -- cambio Optimizacion Logs -- 09/04/2010
                    if(log.isDebugEnabled())
                        UtilidadesLog.debug("inclusion pertenece vii :" + pertenece);                
    
                    // Si la posicion viene cumpliendo los primeros criterios
                    if ( pertenece ) {
                        // si ExclusionTipoOferta es false verificamos inclusion
                        if ( ! baseCalculoDetalle.getExclusionTipoOferta().booleanValue()) {
                            // Si la posicion tiene definido el tipoOferta 
                            if ( posicion.getOidTipoOferta() != null ) {
                                    //si coincide el tipoOferta algun detalle de base de aplicacion con el tipoOferta de la posicion, entonces inlcusionValida.
                                    if (posicion.getOidTipoOferta().equals(baseCalculoDetalle.getTipoOferta()) ) {
                                        inclusionValida = true; 
                                    }
                            } else {
                                //no es valido segun el negocio
                            }
                        }
                    }
                } //while inclusion
                
                //doliva -- cambio Optimizacion Logs -- 09/04/2010
                if(log.isDebugEnabled())
                    UtilidadesLog.debug("i-inclVal: " + inclusionValida);                
                
                if ( inclusionValida ) {
                    perteneceFinal = true;
                }
            }
        } //if

        // -> Devolver el valor de la variable "perteneceFinal"
        
        //doliva -- cambio Optimizacion Logs -- 09/04/2010
        if(log.isDebugEnabled())
            UtilidadesLog.debug("final: " + perteneceFinal);                
        
        UtilidadesLog.info("MONCalcularDTO.perteneceABaseCalculo(): Salida");
        return perteneceFinal;
    }


    /**
     * Calula la Base de Aplicacion.
     * Se determina que bases de aplicacion son aplicables a la posicion.
     * Si hay más de una base se determina cuál de ellas es más específica para aplicar esa misma a la posición.
     * Se comprueba si el número de unidades supera el número de unidades obligatorias de la base de aplicación.
     * Ademas busca la escala de aplicación en la base seleccionada.
     * @autor gdmarzi
     * modificaciones  - 03/08/2005 - BELC300019111 - pperanzola
     */
    private BigDecimal calcularBaseAplicacion(DTOAcumuladoVenta acumuladoVenta, DTODescuento descuento,
                                        DTOSolicitudPosicionDescuento posicion, DTOSolicitudDescuento solicitud) throws MareException {
        UtilidadesLog.info("MONCalcularDTO.calcularBaseAplicacion(): Entrada");
        generaMensaje = false;
        ArrayList basesAplicables = new ArrayList();
        Iterator iter = descuento.getBaseAplicacion().iterator();
        UtilidadesLog.debug("Se determina qué bases de aplicación son aplicables a la posición.");
        // (1) Para cada objeto DTOSBaseAplicacion hacer 
        while (iter.hasNext()) {
            DTOSBaseAplicacion baseAplicacion = (DTOSBaseAplicacion)iter.next();
            if (log.isDebugEnabled()) UtilidadesLog.debug("baseAplicacion: " + baseAplicacion);
            // -> Llamar al método "MONCalcularDTO.perteneceABaseAplicacion(baseAplicacion : DTOSBaseAplicacion, posicion : DTOSolicitudPosicionDescuento) : Boolean"
            Boolean pertenece = this.perteneceABaseAplicacion(baseAplicacion, posicion);
            // Si la llamada anterior devuelve "true" entonces 
            if (pertenece.booleanValue()) {
                UtilidadesLog.debug("Como pertenece a base de aplicacion se agrega a la lista de bases aplicables a las posiciones.");
                // -> Añadir DTOSBaseAplicacion al array basesAplicables 
                basesAplicables.add(baseAplicacion);
            }
        } //fin (1)

        /* Si hay más de una base se determina cuál de ellas es más específica para aplicar esa misma a la posición */
        // -> Crear una variable llamada "baseDeAplicacion" inicializada a null 
        DTOSBaseAplicacion baseDeAplicacion = null;
        // (2) Si "basesAplicables" contiene más de un elemento entonces 
        if (basesAplicables.size() > 1) {
            UtilidadesLog.debug("Ha mas de una base de aplicacion aplicable, se busca la mas especifica.");
            // -> Llamar al método "MONCalcularDTO.buscarBaseAplicacionMasEspecifica(posicion : DTOSolicitudPosicionDescuento, basesAplicables : arrayList) : DTOSBaseAplicacion" 
            // -> Tomar DTOSBaseAplicacion de respuesta a la llamada anterior 
            // -> Guardar el dto obtenido en la iteración anterior en la variable "baseDeAplicacion" 
            baseDeAplicacion = this.buscarBaseAplicacionMasEspecifica(posicion, basesAplicables);
            if (log.isDebugEnabled()) UtilidadesLog.debug("baseDeAplicacion mas especifica: " + baseDeAplicacion);
        } else if (basesAplicables.size() == 1) {
            //Si no Si "basesAplicables" contiene un elemento entonces 
            UtilidadesLog.debug("Tengo justo una base de aplicacion, la uso.");
            //-> Guardar el. dto obtenido en la iteración anterior en la variable "baseDeAplicacion" 
            baseDeAplicacion = (DTOSBaseAplicacion)basesAplicables.get(0);
            if (log.isDebugEnabled()) UtilidadesLog.debug("baseDeAplicacion unica: " + baseDeAplicacion);
        } //fin (2)

        // (3) Si (baseDeAplicacion <> null) entonces 
        if (baseDeAplicacion != null) {
            UtilidadesLog.debug("baseDeAplicacion no es null.");
            Long unidadesPorAtender;
            BigDecimal montoVenta;
            BigDecimal porcentaje = new BigDecimal(0);
            /* Comprobar que el número de unidades supera el número de unidades obligatorias de la base de aplicación */
            UtilidadesLog.debug("Comprobar que el número de unidades supera el número de unidades obligatorias de la base de aplicación.");
            // (4) Si (descuento.datosGenerales.descuentoAcumulativo = "true") entonces 
            if (descuento.getDatosGenerales().getDescuentoAcumulativo().booleanValue()) {
                UtilidadesLog.debug("descuentoAcumulativo es true");
                // -> unidadesPorAtender = DTOAcumuladoVenta.numeroUnidadesAcumulado 
                unidadesPorAtender = acumuladoVenta.getNumeroUnidadesAcumulado();
                // -> montoVenta = DTOAcumuladoVenta.montoVentaAcumulado
                montoVenta = acumuladoVenta.getMontoVentaAcumulado();
            } else {
                UtilidadesLog.debug("descuentoAcumulativo es false");
                // -> unidadesPorAtender = DTOAcumuladoVenta.numeroUnidadesSolicitud 
                unidadesPorAtender = acumuladoVenta.getNumeroUnidadesSolicitud();
                // -> montoVenta = DTOAcumuladoVenta.montoVentaSolicitud
                montoVenta = acumuladoVenta.getMontoVentaSolicitud();
            } //fin (4)
            if (log.isDebugEnabled()) {
                UtilidadesLog.debug("unidadesPorAtender: " + unidadesPorAtender);
                UtilidadesLog.debug("montoVenta " + montoVenta);
            }

            // (5) Si (baseDeAplicacion.numeroUnidadesObligatorias == null)||(unidadesPorAtender >= baseDeAplicacion.numeroUnidadesObligatorias)) entonces 
            if ( (baseDeAplicacion.getNumeroUnidadesObligatorias() == null) ||
                    (unidadesPorAtender.longValue() >= baseDeAplicacion.getNumeroUnidadesObligatorias().longValue()) ) {
                UtilidadesLog.debug("El numeroUnidadesObligatorias es null o unidadesPorAtender es >= a baseDeAplicacion.getNumeroUnidadesObligatorias");
                /* Buscar la escala de aplicación en la base seleccionada */
                UtilidadesLog.debug("Buscar la escala de aplicación en la base seleccionada");
                // -> Recorrer atributo baseDeAplicacion.escalones de tipo arrayList de objetos DTOEscalon 
                Iterator iterEscalones = baseDeAplicacion.getEscalones().iterator();
                // -> Crear variable booleana llamada salir = "false" 
                boolean salir = false;

                // (6) Mientras (salir = "false") y existan escalones hacer:
                while ( (! salir) && (iterEscalones.hasNext()) ) {
                    DTOEscalon escalon = (DTOEscalon)iterEscalones.next();
                    if (log.isDebugEnabled()) UtilidadesLog.debug("escalon: " + escalon);
                    // Si ((escalon.desde <= montoVenta) && ((escalon.hasta == null)||(montoVenta < escalon.hasta))) entonces
                    if ( (escalon.getEscalaDesde().doubleValue() <= montoVenta.doubleValue())
                            && ( (escalon.getEscalaHasta() == null) || (montoVenta.doubleValue() <= escalon.getEscalaHasta().doubleValue()) ) ) {
                        UtilidadesLog.debug("escalon.desde <= montoVenta y ( no tiene escalon.hasta o montoVenta <= escalon.hasta )");
                        // -> porcentaje = escalon.porcentajeDescuento 
                        porcentaje = new BigDecimal(escalon.getPorcentajeDescuento().doubleValue());
                        salir = true;
                        UtilidadesLog.debug("porcentaje de escala a aplicar: " + porcentaje);
                        
                        // sapaza -- PER-SiCC-2012-0335 -- 20/04/2012
                        posicion.setOidBaseAplicacion(baseDeAplicacion.getOidBase());
                        posicion.setOidEscala(escalon.getOidEscalon());     
                        
                        // sapaza -- PER-SiCC-2012-0412 -- 23/05/2012
                        solicitud.setMontoBaseCalculo(montoVenta);
                    }
                } //fin (6)
            } //fin (5)
            // -> generarMensaje = Llamar al método validarGeneraMensaje(descuento, baseDeAplicacion, posicion) 
            this.validarGenerarMensaje(descuento, baseDeAplicacion, posicion, solicitud);
            UtilidadesLog.debug("porcentaje: " + porcentaje);
            UtilidadesLog.info("MONCalcularDTO.calcularBaseAplicacion(): Salida");
            return porcentaje;
        } else {
            UtilidadesLog.debug("baseDeAplicacion es null.");
            // Devolver 0 
            UtilidadesLog.debug("porcentaje 0");
            UtilidadesLog.info("MONCalcularDTO.calcularBaseAplicacion(): Salida");
            return new BigDecimal(0);
        }
    }


    /**
     * Este método valida si el producto pertenece a la base de aplicación del descuento,
     * en cuyo caso devuelve "true", en caso contrario devuelve "false".
     * @autor gdmarzi
     * @cambio Incidencia Cliente
     * - Si el flag de exclusión no está marcado, sólo se aplica el descuento (base de cálculo o aplicación, según corresponda) a los productos que cumplan que el tipo de oferta está entre los seleccionados. 
     * En este caso, la aplicación OBLIGA a seleccionar siempre al menos un tipo de oferta al crear las bases
     * - Si el flag de exclusión SI está marcado y se han seleccionado tipos de oferta, se aplica el descuento a los productos que NO tengan alguno de los tipos de oferta excluidos
     *  flag de exclusión SI está marcado pero no se ha seleccionado ningún tipo de oferta, la lógica a aplicar es "No se excluye ningún tipo de oferta", por tanto se aplica el descuento a todos. 
     *  Esta opción sería equivalente a no marcar el flag y seleccionar todos los tipos de oferta (se aplica el descuento a todos los tipos de oferta).
     * @autor gdmarzi
     */
    private Boolean perteneceABaseAplicacion(DTOSBaseAplicacion baseAplicacion, DTOSolicitudPosicionDescuento posicion) throws MareException {
        UtilidadesLog.info("MONCalcularDTO.perteneceABaseAplicacion(): Entrada");
        boolean pertenece = false;
        boolean violaExclusion = false;
        boolean exclusionChequeada = false;
        boolean inclusionValida = false;
        boolean perteneceFinal = false;
        // -> Recorrer atributo baseAplicacion.detalle de tipo arrayList que contiene objetos DTOSBaseAplicacionDetalle 
        if (baseAplicacion.getDetalle() != null) {            
            Iterator iterExc = baseAplicacion.getDetalle().iterator();
            //doliva -- cambio Optimizacion Logs -- 09/04/2010
            if(log.isDebugEnabled()){
                UtilidadesLog.debug("nro detalles de la base aplicacion " + baseAplicacion.getDetalle().size());
                UtilidadesLog.debug("posicion analizada: " + posicion);
            }
            /** Verificamos que NO exista el tipo de oferta como exluido en algun detalle de la base de aplicacion  */
            while (iterExc.hasNext()) {
                DTOSBaseAplicacionDetalle baseAplicacionDetalle = (DTOSBaseAplicacionDetalle)iterExc.next();
                if (log.isDebugEnabled()) {
                    UtilidadesLog.debug("BaseAplicacionDetalle analisis exlusion: ");
                    UtilidadesLog.debug("  Marca " + baseAplicacionDetalle.getMarca());
                    UtilidadesLog.debug("  UnidadNegocio :" + baseAplicacionDetalle.getUnidadNegocio());
                    UtilidadesLog.debug("  SuperGenreico :" + baseAplicacionDetalle.getSupergenerico());
                    UtilidadesLog.debug("  Generico :" + baseAplicacionDetalle.getGenerico());
                    UtilidadesLog.debug("  Producto :" + baseAplicacionDetalle.getProducto());
                    UtilidadesLog.debug("  CicloVida :" + baseAplicacionDetalle.getCicloVida());
                    UtilidadesLog.debug("  Exclusion :" + baseAplicacionDetalle.getExclusionTipoOferta());
                    UtilidadesLog.debug("  TipoOferta :" + baseAplicacionDetalle.getTipoOferta());
                    UtilidadesLog.debug("  Marca :" + baseAplicacionDetalle.getMarca());
                }
                // -> pertenece = ( ( (posicion.oidMarcaProducto == detalleBase.marca) || (detalleBase.marca == null) ) &&
                pertenece = (baseAplicacionDetalle.getMarca() == null) || baseAplicacionDetalle.getMarca().equals(posicion.getOidMarcaProducto());
                // (DTOSolicitudPosicionDescuento.oidUnidadNegocio = DTOSBaseAplicacionDetalle.unidadNegocio ó null) && 
                pertenece = pertenece && ( (baseAplicacionDetalle.getUnidadNegocio() == null) || baseAplicacionDetalle.getUnidadNegocio().equals(posicion.getOidUnidadNegocio()) );
                // ( (posicion.oidNegocio == detalleBase.negocio) || (detalleBase.negocio == null) ) &&
                pertenece = pertenece && ( (baseAplicacionDetalle.getNegocio() == null) || baseAplicacionDetalle.getNegocio().equals(posicion.getOidNegocio()) );
                // ( (posicion.oidSuperGenerico == detalleBase.superGenerico) || (detalleBase.superGenerico == null) ) &&
                pertenece = pertenece && ( (baseAplicacionDetalle.getSupergenerico() == null) || baseAplicacionDetalle.getSupergenerico().equals(posicion.getOidSupergenerico()) );
                // ( (posicion.oidGenerico == detalleBase.generico) || (detalleBase.unidadGenerico == null) )&&
                pertenece = pertenece && ( (baseAplicacionDetalle.getGenerico() == null) || baseAplicacionDetalle.getGenerico().equals(posicion.getOidGenerico()) );
                // ( (posicion.oidProducto == detalleBase.producto) || (detalleBase.producto == null) ) &&
                pertenece = pertenece && ( (baseAplicacionDetalle.getProducto() == null) || baseAplicacionDetalle.getProducto().equals(posicion.getOidProducto()) );
                // (posicion.oidCicloVida == detalleBase.cicloVida)&& 
                pertenece = pertenece && ( (baseAplicacionDetalle.getCicloVida() == null) || baseAplicacionDetalle.getCicloVida().equals(posicion.getOidCicloVida()) );
                // si el indicadro exclusion tipo eferta esta en null es false
                if (baseAplicacionDetalle.getExclusionTipoOferta() == null) {
                    baseAplicacionDetalle.setExclusionTipoOferta(Boolean.FALSE);
                }
                
                //doliva -- cambio Optimizacion Logs -- 09/04/2010
                if(log.isDebugEnabled())
                    UtilidadesLog.debug("pertenece verificando exlusion 7 :" + pertenece);                

                // Si la posicion viene cmpliendo los primeros criterios
                if ( pertenece ) {
                    // si ExclusionTipoOferta es true verificamos exclusion
                    if (baseAplicacionDetalle.getExclusionTipoOferta().booleanValue()) {
                        exclusionChequeada = true;
                        // Si la posicion tiene definido el tipoOferta 
                        if ( posicion.getOidTipoOferta() != null ) {
                            // si coincide el tipoOferta de al menos un detalle de base de aplicacion con el tipoOferta de la posicion, entonces violaExclusion.
                            if (posicion.getOidTipoOferta().equals(baseAplicacionDetalle.getTipoOferta()) ) {
                                violaExclusion = true;    
                            }
                        } else {
                            // como indicador exclusion tipo oferta esta en true y el tipoOferta es null, son todos los tipos ofertas validos
                            inclusionValida = true;
                        }
                    }
                }
            } //while exclusion
            if (log.isDebugEnabled()) {
                UtilidadesLog.debug("e-exclusionChequeada: " + exclusionChequeada);                
                UtilidadesLog.debug("e-violaExclusion: " + violaExclusion);                
                UtilidadesLog.debug("e-inclusionValida: " + inclusionValida);                
            }
            //si ya chequeamos exlusion tipo oferta, el tipo oferta que no esta excluido esta incluido.
            if (exclusionChequeada) {
                if ( ( ! violaExclusion ) || inclusionValida ) {
                    perteneceFinal = true;
                }
            } else {
                Iterator iterIncl = baseAplicacion.getDetalle().iterator();
                /** Verificamos que exista el tipo de oferta como inlcluido en algun detalle de la base de aplicacion */
                while (iterIncl.hasNext()) {
                    // -> Tomar DTOSBaseAplicacionDetalle de turno contenido en el array 
                    DTOSBaseAplicacionDetalle baseAplicacionDetalle = (DTOSBaseAplicacionDetalle)iterIncl.next();
                    if (log.isDebugEnabled()) {
                        UtilidadesLog.debug("BaseAplicacionDetalle analisis inclusion: ");
                        UtilidadesLog.debug("  Marca " + baseAplicacionDetalle.getMarca());
                        UtilidadesLog.debug("  UnidadNegocio :" + baseAplicacionDetalle.getUnidadNegocio());
                        UtilidadesLog.debug("  SuperGenreico :" + baseAplicacionDetalle.getSupergenerico());
                        UtilidadesLog.debug("  Generico :" + baseAplicacionDetalle.getGenerico());
                        UtilidadesLog.debug("  Producto :" + baseAplicacionDetalle.getProducto());
                        UtilidadesLog.debug("  CicloVida :" + baseAplicacionDetalle.getCicloVida());
                        UtilidadesLog.debug("  Exclusion :" + baseAplicacionDetalle.getExclusionTipoOferta());
                        UtilidadesLog.debug("  TipoOferta :" + baseAplicacionDetalle.getTipoOferta());
                        UtilidadesLog.debug("  Marca :" + baseAplicacionDetalle.getMarca());
                    }
                    // -> pertenece = ( ( (posicion.oidMarcaProducto == detalleBase.marca) || (detalleBase.marca == null) ) &&
                    pertenece = (baseAplicacionDetalle.getMarca() == null) || baseAplicacionDetalle.getMarca().equals(posicion.getOidMarcaProducto());
                    // (DTOSolicitudPosicionDescuento.oidUnidadNegocio = DTOSBaseAplicacionDetalle.unidadNegocio ó null) && 
                    pertenece = pertenece && ( (baseAplicacionDetalle.getUnidadNegocio() == null) || baseAplicacionDetalle.getUnidadNegocio().equals(posicion.getOidUnidadNegocio()) );
                    // ( (posicion.oidNegocio == detalleBase.negocio) || (detalleBase.negocio == null) ) &&
                    pertenece = pertenece && ( (baseAplicacionDetalle.getNegocio() == null) || baseAplicacionDetalle.getNegocio().equals(posicion.getOidNegocio()) );
                    // ( (posicion.oidSuperGenerico == detalleBase.superGenerico) || (detalleBase.superGenerico == null) ) &&
                    pertenece = pertenece && ( (baseAplicacionDetalle.getSupergenerico() == null) || baseAplicacionDetalle.getSupergenerico().equals(posicion.getOidSupergenerico()) );
                    // ( (posicion.oidGenerico == detalleBase.generico) || (detalleBase.unidadGenerico == null) )&&
                    pertenece = pertenece && ( (baseAplicacionDetalle.getGenerico() == null) || baseAplicacionDetalle.getGenerico().equals(posicion.getOidGenerico()) );
                    // ( (posicion.oidProducto == detalleBase.producto) || (detalleBase.producto == null) ) &&
                    pertenece = pertenece && ( (baseAplicacionDetalle.getProducto() == null) || baseAplicacionDetalle.getProducto().equals(posicion.getOidProducto()) );
                    // (posicion.oidCicloVida == detalleBase.cicloVida)&& 
                    pertenece = pertenece && ( (baseAplicacionDetalle.getCicloVida() == null) || baseAplicacionDetalle.getCicloVida().equals(posicion.getOidCicloVida()) );
                    // si el indicadro exclusion tipo eferta esta en null es false
                    if (baseAplicacionDetalle.getExclusionTipoOferta() == null) {
                        baseAplicacionDetalle.setExclusionTipoOferta(Boolean.FALSE);
                    }
                    
                    //doliva -- cambio Optimizacion Logs -- 09/04/2010
                    if(log.isDebugEnabled())
                        UtilidadesLog.debug("inclusion pertenece 7 :" + pertenece);                
    
                    // Si la posicion viene cumpliendo los primeros criterios
                    if ( pertenece ) {
                        // si ExclusionTipoOferta es false verificamos inclusion
                        if ( ! baseAplicacionDetalle.getExclusionTipoOferta().booleanValue()) {
                            // Si la posicion tiene definido el tipoOferta 
                            if ( posicion.getOidTipoOferta() != null ) {
                                    //si coincide el tipoOferta algun detalle de base de aplicacion con el tipoOferta de la posicion, entonces inlcusionValida.
                                    if (posicion.getOidTipoOferta().equals(baseAplicacionDetalle.getTipoOferta()) ) {
                                        inclusionValida = true; 
                                    }
                            } else {
                                //no es valido segun el negocio
                            }
                        }
                    }
                } //while inclusion
                
                //doliva -- cambio Optimizacion Logs -- 09/04/2010
                if(log.isDebugEnabled())
                    UtilidadesLog.debug("i-inclusionValida: " + inclusionValida);                
                    
                if ( inclusionValida ) {
                    perteneceFinal = true;
                }
            }
        } //if

        //doliva -- cambio Optimizacion Logs -- 09/04/2010
        if(log.isDebugEnabled())
            UtilidadesLog.debug("perteneceFinal: " + perteneceFinal);                
        
        UtilidadesLog.info("MONCalcularDTO.perteneceABaseAplicacion(): Salida");
        return perteneceFinal;
    }


    /**
     * Retorna DTOSBaseAplicacion mas especifica.
     * El proceso consiste en hallar cual de las bases de aplicación contenidas en el array de entrada,
     * es más específica para la posición que se pasa como parámetro.
     * @autor fhofman
     */
    public DTOSBaseAplicacion buscarBaseAplicacionMasEspecifica(DTOSolicitudPosicionDescuento posicion, ArrayList basesAplicables) throws MareException {
        UtilidadesLog.info("MONCalcularDTO.buscarBaseAplicacionMasEspecifica(): Entrada");

        // -> Ordenar los detalles de cada base de aplicación por producto, cicloVida, tipoOferta, generico, supergenerico,
        // negocio, unidadNegocio y marca en orden descendente de modo que los valores nulos queden abajo
        Iterator baiter = basesAplicables.iterator();
        while(baiter.hasNext()){
            DTOSBaseAplicacion ba = (DTOSBaseAplicacion)baiter.next();
            Collections.sort(ba.getDetalle(), new DTOSBaseAplicacionDetalleComparator());

        }

        baiter = basesAplicables.iterator();

        // -> Tomar las bases de aplicación de dos en dos e ir decidiendo cual de las dos
        // es la más específica hasta que nos quede sólo una que será la elegida

        DTOSBaseAplicacion b1 = new DTOSBaseAplicacion();

        if(baiter.hasNext()){
            b1 = (DTOSBaseAplicacion) baiter.next();
        }

        DTOSBaseAplicacion b2 = new DTOSBaseAplicacion();
        
        while(baiter.hasNext()){
            // Seteo como b2 al nuevo de la lista de BaseAplicacion
            b2 = (DTOSBaseAplicacion) baiter.next();

            // Este macroIF setea el mas especifico y lo guarda en "b1" 
            // para luego comprararlo con b2 
/*-1*/      if(buscaMasEspecifico(b1,posicion,"PROD") != null){
/*0*/           if(buscaMasEspecifico(b1,posicion,"PROD") != null){
/*1*/              if(buscaMasEspecifico(b1,posicion,"MARC") != null){
/*2*/                   if(buscaMasEspecifico(b2,posicion,"MARC") != null){

/*3*/                       if(buscaMasEspecifico(b1,posicion,"UNEG") != null){
/*4*/                           if(buscaMasEspecifico(b2,posicion,"UNEG") != null){
                   
/*5*/                               if(buscaMasEspecifico(b1,posicion,"NEGO") != null){
/*6*/                                   if(buscaMasEspecifico(b2,posicion,"NEGO") != null){

/*7*/                                       if(buscaMasEspecifico(b1,posicion,"GENE") != null){
/*8*/                                          if(buscaMasEspecifico(b2,posicion,"GENE") != null){
                    
/*9*/                                               if(buscaMasEspecifico(b1,posicion,"SGEN") != null){
/*10*/                                                  if(buscaMasEspecifico(b2,posicion,"SGEN") != null){
                    
/*11*/                                                      if(buscaMasEspecifico(b1,posicion,"TOFE") != null){
/*12*/                                                          if(buscaMasEspecifico(b2,posicion,"TOFE") != null){

/*13*/                                                              if(buscaMasEspecifico(b1,posicion,"CVID") != null){
/*14*/                                                                  if(buscaMasEspecifico(b2,posicion,"CVID") != null){
                                                                            b1 = b2;
/*14*/                                                                  }else{
                                                                            b1 = b1;
/*14*/                                                                  }
/*13*/                                                              }else{
/*15*/                                                                  if(buscaMasEspecifico(b2,posicion,"CVID") != null){
                                                                            b1 = b2;
/*15*/                                                                  }else{
                                                                            b1 = b1;
/*15*/                                                                  }
                                                                                                                                        
/*13*/                                                              }
/*12*/                                                          }else{
                                                                    b1 = b1;
/*12*/                                                          }
/*11*/                                                      }else{
/*16*/                                                          if(buscaMasEspecifico(b2,posicion,"TOFE") != null){
                                                                    b1 = b2;
/*16*/                                                          }else{
                                                                    b1 = b1;
/*16*/                                                          }                                                 
/*11*/                                                       }
/*10*/                                                   }else{
                                                            b1 = b1;
/*10*/                                                   }
/*9*/                                               }else{
/*17*/                                                  if(buscaMasEspecifico(b2,posicion,"SGEN") != null){
                                                            b1 = b2;
/*17*/                                                  }else{
                                                            b1 = b1;                                      
/*17*/                                                  }   
/*9*/                                               }
/*8*/                                          }else{
                                                    b1 = b1;
/*8*/                                          }
/*7*/                                       }else{
/*18*/                                          if(buscaMasEspecifico(b2,posicion,"GENE") != null){
                                                    b1 = b2;
/*18*/                                          }else{
                                                    b1 = b1;                                      
/*18*/                                          }                               
/*7*/                                       }
/*6*/                                   }else{
                                            b1 = b1;                                      
/*6*/                                   }
/*5*/                               }else{
/*19*/                                  if(buscaMasEspecifico(b2,posicion,"NEGO") != null){                       
                                            b1 = b2;                                                                  
/*19*/                                  }else{
                                            b1 = b1;
/*19*/                                  }
/*5*/                               }      
/*4*/                           }else{
                                    b1 = b1;
/*4*/                           }
/*3*/                       }else{
/*20*/                          if(buscaMasEspecifico(b2,posicion,"UNEG") != null){                       
                                    b1 = b2;                                                                  
/*20*/                          }else{
                                    b1 = b1;
/*20*/                          }

/*3*/                       }
/*2*/                   }
/*1*/               }
                            // Por incidencia 8070 no se agrega el else 
                            /*(ajpoyato)
                            Ese caso no se va a dar, para entrar en este método las bases ya han sido validadas, quiere decir
                            que tienen marca obligatoriamente, y si no tienen marca es que el detalle es de un producto, en
                            cuyo la base más específica sería la que tiene el producto.
                            */
/*0*/           }
/*-1*/      }
        }
        UtilidadesLog.info("MONCalcularDTO.buscarBaseAplicacionMasEspecifica(): Salida");

        return b1;   
    }


    /**
     * El parametro ba representa una BaseAplicacion.
     */
    private DTOSBaseAplicacion buscaMasEspecifico(DTOSBaseAplicacion ba ,DTOSolicitudPosicionDescuento pocis, String which){
        UtilidadesLog.info("MONCalcularDTO.buscaMasEspecifico(): Entrada");

        ArrayList al = ba.getDetalle();
        Iterator iter = al.iterator();
        while(iter.hasNext()){
            DTOSBaseAplicacionDetalle bad = (DTOSBaseAplicacionDetalle)iter.next();
            if(which.equals("PROD")){
                if(bad.getProducto() != null && bad.getProducto().equals(pocis.getOidProducto())){
                    return ba;
                }
            }
            if(which.equals("MARC")){
                if(bad.getMarca() != null && bad.getMarca().equals(pocis.getOidMarcaProducto())){
                    return ba;
                }
            }
            if(which.equals("UNEG")){
                if(bad.getUnidadNegocio() != null && bad.getUnidadNegocio().equals(pocis.getOidUnidadNegocio())){
                    return ba;
                }
            }
            if(which.equals("NEGO")){
                if(bad.getNegocio() != null && bad.getNegocio().equals(pocis.getOidNegocio())){
                    return ba;
                }
            }
            if(which.equals("SGEN")){
                if(bad.getSupergenerico() != null && bad.getSupergenerico().equals(pocis.getOidSupergenerico())){
                    return ba;
                }
            }
            if(which.equals("GENE")){
                if(bad.getGenerico() != null && bad.getGenerico().equals(pocis.getOidGenerico())){
                    return ba;
                }
            }
            if(which.equals("TOFE") ){
                if(((bad.getTipoOferta() != null) && (bad.getTipoOferta().equals(pocis.getOidTipoOferta()))
                && bad.getExclusionTipoOferta().equals(Boolean.FALSE)) 
                || 
                ((bad.getTipoOferta() != null) && (  !bad.getTipoOferta().equals(pocis.getOidTipoOferta()) 
                &&  bad.getExclusionTipoOferta().equals(Boolean.TRUE)) 
                )){
                    return ba;
                }
            }
            if(which.equals("CVID") ){
                if(((bad.getCicloVida() != null) && (bad.getCicloVida().equals(pocis.getOidCicloVida()))
                && bad.getExclusionTipoOferta().equals(Boolean.FALSE)) 
                || 
                ((bad.getCicloVida() != null) && (  !bad.getCicloVida().equals(pocis.getOidCicloVida()) 
                &&  bad.getExclusionTipoOferta().equals(Boolean.TRUE)) 
                )){
                    UtilidadesLog.info("MONCalcularDTO.buscaMasEspecifico(): Salida");

                    return ba;
                }
            }
                
        }
        UtilidadesLog.info("MONCalcularDTO.buscaMasEspecifico(): Salida");

        return null;
    }


    /**
     * Método que comprueba si para la base de aplicacion y posición recibida se debe insertar un mensaje en el buzón.
     * @autor gdmarzi
     * @cambio se rehizo la validacion del envio de mensaje por cada marca, solicitud y descuento.
     */
    private void validarGenerarMensaje(DTODescuento descuento, DTOSBaseAplicacion baseAplicacion, 
                                       DTOSolicitudPosicionDescuento posicion, DTOSolicitudDescuento solicitud) throws MareException {
        UtilidadesLog.debug("MONCalcularDTO.validarGenerarMensaje(): Entrada");
        DTOMensajeDescuento mensajeDescuento;
        String keyDescuentoMarca;
        if ( descuento.getDatosGenerales().getComunicacionAParticipantes().booleanValue() && ! esReclamo(solicitud) ) {
            //Busca una linea de detalle con: 
            Iterator iter = baseAplicacion.getDetalle().iterator();
            while ( iter.hasNext() ) { 
                DTOSBaseAplicacionDetalle detalleBase = (DTOSBaseAplicacionDetalle)iter.next();
                // si coinciden la marca de la posicion con la marca de la base de aplicacion.
                if (posicion.getOidMarcaProducto().equals(detalleBase.getMarca())) {
                    keyDescuentoMarca = this.keyMensajeDescuento(descuento, posicion);
                    // si no genero un mensaje para esta misma marca, solicitud y descuento.
                    if ( ! hashMarcaSolicitudDescuento.containsKey(keyDescuentoMarca)) {
                        if (log.isDebugEnabled()) UtilidadesLog.debug("keyDescuentoMarca " + keyDescuentoMarca);
                        generaMensaje = true;
                        // Crea un DTOMensajeDescuento con: 
                        mensajeDescuento = new DTOMensajeDescuento();
                        mensajeDescuento.setDescuento(descuento.getDatosGenerales().getOidDescuento());
                        mensajeDescuento.setMarcaProducto(detalleBase.getMarca());
                        mensajeDescuento.setDescripcionMarcaProducto(detalleBase.getDescripcionMarca());
                        // agrega el mensaje al hash que verifica la genracion de un solo mensaje por marca, solicitud y descuento.
                        hashMarcaSolicitudDescuento.put(keyDescuentoMarca,mensajeDescuento);
                    }
                }
            }
        }
        UtilidadesLog.debug("MONCalcularDTO.validarGenerarMensaje(): Salida");
    }


    private String keyMensajeDescuento(DTODescuento descuento, DTOSolicitudPosicionDescuento posicion) throws MareException {
        String key;
        key = (descuento.getDatosGenerales().getOidDescuento().toString() + "-" + posicion.getOidMarcaProducto().toString()).toString(); 
        return key;
    }
    
    
    private DTOBuzonMensajes armarMensaje(DTOMensajeDescuento dtoe) throws MareException {
        DTOBuzonMensajes dtoB = new DTOBuzonMensajes();
        dtoB.setOidPais(dtoe.getOidPais());
        dtoB.setCodigoMensaje(dtoe.getCodigoMensaje());
        dtoB.setModuloOrigen(Long.valueOf(ConstantesSEG.MODULO_DTO));
        dtoB.setOidCliente(dtoe.getCliente());
        dtoB.setDatoVariable1(dtoe.getDv1());
        dtoB.setDatoVariable2(dtoe.getDv2());
        dtoB.setDatoVariable3(dtoe.getDv3());
        dtoB.setDatoVariable4(dtoe.getDv4());
        dtoB.setListaConsultoras(ConstantesMSG.NO);
        return dtoB;
    }


    /**
     * Completa la region y subgerencia a partir de la zona.
     * @autor gdmarzi
     */
    private DTOSolicitudDescuento completarRegionSubgerencia(DTOSolicitudDescuento solicitudDescuento) throws MareException {
        // -> Llamar al findByPrimaryKey de la entidad Zona pasando el valor de zonaCliente
        try {
            ZonaLocalHome zonaLocalHome = new ZonaLocalHome();
            ZonaLocal zonaLocal = zonaLocalHome.findByPrimaryKey(solicitudDescuento.getZona());
            solicitudDescuento.setRegion(zonaLocal.getOidRegion());
        } catch(NoResultException e) {
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        // -> Llamar al findByPrimaryKey de la entidad Region pasando el valor de regionCliente
        try {
            RegionLocalHome regionLocalHome = new RegionLocalHome();
            RegionLocal regionLocal = regionLocalHome.findByPrimaryKey(solicitudDescuento.getRegion());
            solicitudDescuento.setSubgerencia(regionLocal.getSgvOidSubgVenta());
        } catch(NoResultException e) {
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        return solicitudDescuento;
    }


    /**
     * Retorn true si el descuento posee base de calculo.
     */
    private boolean poseeBaseCalculo(DTODescuento descuento) {
        boolean poseeBaseCalculo;
        if (descuento.getBaseCalculo().isEmpty()) {
            poseeBaseCalculo = false;
        } else if ( ((DTOSBaseCalculo)descuento.getBaseCalculo().get(0)).getDetalle().isEmpty() ) {
            poseeBaseCalculo = false;   
        } else {
            poseeBaseCalculo = true;
        }
        return poseeBaseCalculo;
    } 


    private DTOBuzonMensajes generarMensajeSimulacion(DTOMensajeDescuento dtoe) throws MareException {
        UtilidadesLog.debug("MONCalcularDTO.generarMensajeSimulacion(): Entrada");
        DTOBuzonMensajes dtoB = new DTOBuzonMensajes();
        dtoB.setOidPais(dtoe.getOidPais());
        dtoB.setCodigoMensaje(dtoe.getCodigoMensaje());
        dtoB.setModuloOrigen(Long.valueOf(ConstantesSEG.MODULO_DTO));
        dtoB.setOidCliente(dtoe.getCliente());
        dtoB.setDatoVariable1(dtoe.getDv1());
        dtoB.setDatoVariable2(dtoe.getDv2());
        dtoB.setDatoVariable3(dtoe.getDv3());
        dtoB.setDatoVariable4(dtoe.getDv4());
        dtoB.setDatoVariable5(dtoe.getDv5());
        dtoB.setDatoVariable6(dtoe.getDv6());
        dtoB.setListaConsultoras(ConstantesMSG.NO);
        // DTOBuzonMensaje = Llamar al método insertaDatosMensaje de la interface IMSG pasándole dtoB
        try {
            dtoB = getMONGestionMensajesLocalHome().create().insertaDatosMensaje(dtoB);
        } catch(CreateException ce) {
            ctx.setRollbackOnly();
            UtilidadesLog.error(ce);
            throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        } catch(NamingException ne) {
            UtilidadesLog.error(ne);
            throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        UtilidadesLog.debug("MONCalcularDTO.generarMensajeSimulacion(): Salida");
        return dtoB;
    }


    /**
    * Retorna true si la solicitud es un reclamo.
    */
    private boolean esReclamo(DTOSolicitudDescuento solicitud) {
        boolean esReclamo;
        esReclamo =  ConstantesPED.MODULO_RECLAMOS.equals(solicitud.getOidModulo());
        return esReclamo;
    }


    /**
     * Retorna una copia del objeto pasado por parametro.
     */
    private Object deepCopy(Object oldObj) throws MareException {
        UtilidadesLog.debug("MONCalcularDTO.deepCopy(): Entrada");
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;

        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);

            oos.writeObject(oldObj);
            oos.flush();
            ByteArrayInputStream bin = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bin);

            UtilidadesLog.debug("MONCalcularDTO.deepCopy(): Salida");
            return ois.readObject();
        } catch(Exception e) {
            UtilidadesLog.debug("Exception en deepCopy = " + e);
            throw new MareException(e);
        } finally {
            try {
                oos.close();
                ois.close();
            } catch(Exception ex) {
                UtilidadesLog.debug("Exception en deepCopy = " + ex);
                throw new MareException(ex);
            }
        }
    }


    private MONDigitacionInicialHome getMONDigitacionInicialHome() throws MareException {
        MONDigitacionInicialHome home = null;
        BelcorpService bs = null;
        
        try {
              bs = BelcorpService.getInstance();
        } catch(MareMiiServiceNotFoundException e) {
            String codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        
        try {
            home = (MONDigitacionInicialHome) bs.ejbLocator.getHome(
                   "MONDigitacionInicial", MONDigitacionInicialHome.class);
        } catch (MareServiceException e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB ) );
        }
        return home;                                        
    }


    private MONClientesHome getMONClientesHome() throws MareException {

        MONClientesHome home = null;
        BelcorpService bs = null;
        
        try {
              bs = BelcorpService.getInstance();
        } catch(MareMiiServiceNotFoundException e) {
            String codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        
        try {
            home = (MONClientesHome) bs.ejbLocator.getHome(
                   "MONClientes", MONClientesHome.class);
        } catch (MareServiceException e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB ) );
        }
        return home;                                        
    }
    
    //creado por incidencia BELC300024362 
    private MONGenerarSolicitudModulosExternosHome getMONGenerarSolicitudModulosExternosHome() throws MareException {

        MONGenerarSolicitudModulosExternosHome home = null;
        BelcorpService bs = null;
        
        try {
              bs = BelcorpService.getInstance();
        } catch(MareMiiServiceNotFoundException e) {
            String codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        
        try {
            home = (MONGenerarSolicitudModulosExternosHome) bs.ejbLocator.getHome(
                   "MONGenerarSolicitudModulosExternos", MONGenerarSolicitudModulosExternosHome.class);
        } catch (MareServiceException e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB ) );
        }
        return home;                                        
    }


    //creado por incidencia BELC300024362 
    private MONConfiguracionClientesHome getMONConfiguracionClientesHome() throws MareException {

        MONConfiguracionClientesHome home = null;
        BelcorpService bs = null;
        
        try {
              bs = BelcorpService.getInstance();
        } catch(MareMiiServiceNotFoundException e) {
            String codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        
        try {
            home = (MONConfiguracionClientesHome) bs.ejbLocator.getHome(
                   "MONConfiguracionClientes", MONConfiguracionClientesHome.class);
        } catch (MareServiceException e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB ) );
        }
        return home;                                        
    }


    private MONHistoricoDTOHome getMONHistoricoDTOHome() throws MareException {

        MONHistoricoDTOHome home = null;
        BelcorpService bs = null;
        
        try {
              bs = BelcorpService.getInstance();
        } catch(MareMiiServiceNotFoundException e) {
            String codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        
        try {
            home = (MONHistoricoDTOHome) bs.ejbLocator.getHome(
                   "MONHistoricoDTO", MONHistoricoDTOHome.class);
        } catch (MareServiceException e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB ) );
        }
        return home;                                        
    }
   

    private MONMantenimientoMFHome getMONMantenimientoMFHome() throws MareException {

        MONMantenimientoMFHome home = null;
        BelcorpService bs = null;
        
        try {
              bs = BelcorpService.getInstance();
        } catch(MareMiiServiceNotFoundException e) {
            String codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        
        try {
            home = (MONMantenimientoMFHome) bs.ejbLocator.getHome(
                   "MONMantenimientoMF", MONMantenimientoMFHome.class);
        } catch (MareServiceException e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB ) );
        }
        return home;                                        
    }


    private MONMantenimientoDTOHome getMONMantenimientoDTOHome() throws MareException {

        MONMantenimientoDTOHome home = null;
        BelcorpService bs = null;
        
        try {
              bs = BelcorpService.getInstance();
        } catch(MareMiiServiceNotFoundException e) {
            String codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        
        try {
            home = (MONMantenimientoDTOHome) bs.ejbLocator.getHome(
                   "MONMantenimientoDTO", MONMantenimientoDTOHome.class);
        } catch (MareServiceException e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB ) );
        }
        return home;                                        
    }

    private MONHistoricoDTOLocalHome getMONHistoricoDTOLocalHome() throws NamingException
    {
        final InitialContext context = new InitialContext();
        return (MONHistoricoDTOLocalHome)context.lookup("java:comp/env/ejb/local/MONHistoricoDTO");
    }
    private MONMantenimientoDTOLocalHome getMONMantenimientoDTOLocalHome() throws NamingException
    {
        final InitialContext context = new InitialContext();
        return (MONMantenimientoDTOLocalHome)context.lookup("java:comp/env/ejb/local/MONMantenimientoDTO");
    }
    
    private MONGestionMensajesLocalHome getMONGestionMensajesLocalHome() throws NamingException
    {
        final InitialContext context = new InitialContext();
        return (MONGestionMensajesLocalHome)context.lookup("java:comp/env/ejb/local/MONGestionMensajes");
    }

}
