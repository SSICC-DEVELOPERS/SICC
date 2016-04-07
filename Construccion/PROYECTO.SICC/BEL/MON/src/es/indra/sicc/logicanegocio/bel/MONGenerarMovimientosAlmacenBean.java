/**
 * Copyright 2002 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
package es.indra.sicc.logicanegocio.bel;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMii;
import es.indra.mare.common.mii.MareTopic;
import es.indra.mare.common.mii.services.logging.LoggingService;

import es.indra.sicc.cmn.negocio.validacion.MONValidacion;
import es.indra.sicc.cmn.negocio.validacion.MONValidacionHome;
import es.indra.sicc.dtos.bel.DTOGMA;
import es.indra.sicc.dtos.bel.DTOGMADetalle;
import es.indra.sicc.dtos.bel.DTOMovimientoAlmacen;
import es.indra.sicc.dtos.bel.DTOMovimientoAlmacenCabecera;
import es.indra.sicc.dtos.bel.DTOMovimientoAlmacenDetalle;
import es.indra.sicc.dtos.bel.DTOReportePedidos;
import es.indra.sicc.dtos.bel.DTOTipoMovimientoAlmacen;
import es.indra.sicc.dtos.ped.DTOTipoSolicitudOperacion;
import es.indra.sicc.dtos.ped.DTOCabeceraSolicitud;
import es.indra.sicc.dtos.ped.DTOPosicionSolicitud;
import es.indra.sicc.dtos.cra.DTOPeriodo;
import es.indra.sicc.entidades.seg.AccesoLocal;
import es.indra.sicc.entidades.seg.AccesoLocalHome;
import es.indra.sicc.entidades.bel.ParametrosBelcenterLocal;
import es.indra.sicc.entidades.bel.ParametrosBelcenterLocalHome;
//import es.indra.sicc.entidades.bel.ParametrosBelcenterLocal;
import es.indra.sicc.entidades.seg.CanalLocal;
import es.indra.sicc.entidades.seg.CanalLocalHome;
import es.indra.sicc.entidades.seg.SubaccesoLocal;
import es.indra.sicc.entidades.seg.SubaccesoLocalHome;
import es.indra.sicc.entidades.mae.ClienteDatosBasicosLocal;
import es.indra.sicc.entidades.mae.ClienteDatosBasicosLocalHome;
import es.indra.sicc.entidades.mae.MaestroProductosLocal;
import es.indra.sicc.entidades.mae.MaestroProductosLocalHome;
import es.indra.sicc.logicanegocio.bel.ErroresDeNegocio;
import es.indra.sicc.logicanegocio.cra.MONPeriodos;
import es.indra.sicc.logicanegocio.cra.MONPeriodosHome;
import es.indra.sicc.logicanegocio.ped.MONTiposSolicitudPais;
import es.indra.sicc.logicanegocio.ped.MONTiposSolicitudPaisHome;
import es.indra.sicc.entidades.ped.TiposSolicitudProcesoLocalHome;
import es.indra.sicc.entidades.ped.TiposSolicitudProcesoLocal;
import es.indra.sicc.logicanegocio.ped.MONGenerarSolicitudModulosExternos;
import es.indra.sicc.logicanegocio.ped.MONGenerarSolicitudModulosExternosHome;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.ExcepcionParametrizada;
import es.indra.sicc.entidades.mae.MaestroProductosPK;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.math.BigDecimal;
import java.rmi.RemoteException;

import java.sql.Date;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.ejb.FinderException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.persistence.NoResultException;

import javax.persistence.PersistenceException;

import javax.rmi.PortableRemoteObject;

public class MONGenerarMovimientosAlmacenBean implements SessionBean {
    private SessionContext ctx;

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

    public DTOSalida consultaAlmacen(DTOBelcorp dto) throws MareException {
        UtilidadesLog.info("MONGenerarMovimientosAlmacenBean.consultaAlmacen(DTOBelcorp dto):Entrada");

        DTOSalida salida = new DTOSalida();
        MONServicioBEL monServicioBel = this.getMONServicioBEL();

        try {
            salida = monServicioBel.obtenerAlmacenes(dto);
        } catch (RemoteException e) {
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            this.loguearError("consultaAlmacen: RemoteException", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("MONGenerarMovimientosAlmacenBean.consultaAlmacen(DTOBelcorp dto):Salida");

        return salida;
    }

    public void guardarGMA(DTOGMA dtoGMA) throws MareException {
        UtilidadesLog.info("MONGenerarMovimientosAlmacenBean.guardarGMA(DTOGMA dtoGMA):Entrada");
        UtilidadesLog.debug("****Entrada dtoGMA: "+dtoGMA);

        String codigoError = null;

        /*
         * referencias a los entities
         */
        AccesoLocal accesoLocal = null;
        AccesoLocalHome accesoHome = this.getAccesoLocalHome();
        MONPeriodos monPeriodos = this.getMONPeriodos();
        MONMantenimientoTiposMovimientosAlmacen monMantenimientoTiposMovimientosAlmacen =
            this.getMONMantenimientoTiposMovimientosAlmacen();
        MONServicioBEL monServicioBEL = getMONServicioBEL();
        MONGenerarMovimientoAlmacen monGenerarMovimientoAlmacen = getMONGenerarMovimientoAlmacen();
        CanalLocal canalLocal = null;
        CanalLocalHome canalLocalHome = this.getCanalLocalHome();
		
        /*
         * Recuperar Periodo
         */
        Long oidCanal = null;
        Long oidAcceso = null;

        try {
            // Hacer un findByClaveUnica sobre la entidad Canal, pasando el atributo DTOGMA.cabecera.canal 
            canalLocal = canalLocalHome.findByClaveUnica(dtoGMA.getCabecera()
                                                               .getCanal()
                                                               .toString());

            // Obtener el oid de canal del registro encontrado 
            oidCanal = canalLocal.getOid();
            UtilidadesLog.debug("****Metodo guardarGMA: OidCanal= "+oidCanal);
            // Hacer un findByClaveUnica sobre la entidad Acceso, pasando el atributo DTOGMA.cabecera.acceso y el oid de canal obtenido en la actividad anterior 
            accesoLocal = accesoHome.findByClaveUnica(dtoGMA.getCabecera()
                                                            .getAcceso(),
                    oidCanal);
            UtilidadesLog.debug("****Metodo guardarGMA: oidAcceso= "+oidAcceso);
            oidAcceso = accesoLocal.getOid();
        } catch (NoResultException fe) {
            this.loguearError("guardarGMA: FinderException", fe);
            codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException(fe, UtilidadesError.armarCodigoError(codigoError));
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        /*
         * se validan los vinculos
         */
        //País	Sociedad	Marca	Canal	Acceso	Subacceso
        //	X				  X		  X		   X		X
        
        UtilidadesLog.debug("****Metodo guardarGMA: entro en validar vinculos");
        validarVinculos(dtoGMA.getOidPais(), null,
            dtoGMA.getCabecera().getOidMarca(), oidCanal, oidAcceso,
            dtoGMA.getCabecera().getOidSubacceso());
        UtilidadesLog.debug("****Metodo guardarGMA: Valido Pais, Marca, Canal, Acceso, Sub acceso");
        // Crear un objeto DTOPeriodo, llenando sólo los atributos pais, marca, canal y fechaIni con los datos DTOGMA.pais (DTOGMA hereda de DTOBelcorp), DTOGMA.cabecera.oidMarca, el oid de canal obtenido anteriormente, y la fecha actual del sistema. 
        DTOPeriodo dtoPeriodo = new DTOPeriodo();
        dtoPeriodo.setPais(dtoGMA.getOidPais());
        dtoPeriodo.setMarca(dtoGMA.getCabecera().getOidMarca());
        dtoPeriodo.setCanal(oidCanal);

        Date fechaActual = new Date(System.currentTimeMillis());
        dtoPeriodo.setFechaInicio(new Date(dtoGMA.getCabecera().getFecha().getTime()));

        // Llamar al método "MONPeriodos.obtienePeriodosFecha(dto : DTOPeriodo) : DTOSalida" pasando como parámetro el dto creado en la actividad anterior 
        DTOSalida salida = null;
        /**********---------------------------------AGREGADO-----------------------------------------------**********
        Si no existe el periodo 
        Lanzar MareException con el código de mensaje "BEL-0008" 
        /**********---------------------------------------------------------------------------------------------------**********/
        UtilidadesLog.debug("****Metodo guardarGMA:Entro a Validar periodo con: "+dtoPeriodo);
        
        try {
            salida = monPeriodos.obtienePeriodosFecha(dtoPeriodo);
        }catch (MareException mex){
            UtilidadesLog.debug("****Metodo obtienePeridodosFecha: devuelve: "+salida);
            if( salida == null){
		    UtilidadesLog.debug("****Metodo obtieneperiodofecha: volvio 'null' lanzar mensaje de periodo existente ");
        	throw new MareException(new Exception(), UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_BEL, ErroresDeNegocio.PERIODO_INEXISTENTE));
            }
            if(!salida.getResultado().esVacio()){
            throw mex;
            }
        }catch (RemoteException e) {
            this.loguearError("guardarGMA: RemoteException", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        
        UtilidadesLog.debug("****Metodo guardarGMA: Busqueda de un perido valido: "+salida);
        // Obtener el oid de periodo del PRIMER REGISTRO del RecordSet del DTOSalida obtenido en la actividad anterior 	
        Long oidPeriodo = null;
		if (!salida.getResultado().esVacio())
			oidPeriodo = new Long(((BigDecimal) salida.getResultado().getRow(0).get(0)).longValue());
		else {
		    UtilidadesLog.debug("****Metodo guardarGMA: la validacion del periodo vino vacia ");
        	throw new MareException(new Exception(), UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_BEL, ErroresDeNegocio.PERIODO_INEXISTENTE));
		}

        /*
         * Obtener tipoMovimientoAlmacen
         */

        // Tomar atributo DTOGMA.cabecera.oidTipoMovimientoAlmacen y crear un objeto DTOOID 
        DTOOID dtoOID = new DTOOID();
        dtoOID.setOid(dtoGMA.getCabecera().getOidTipoMovimientoAlmacen());
        dtoOID.setOidIdioma(dtoGMA.getOidIdioma());

        // Llamar al método "MONMantenimientoTiposMovimientosAlmacen.consultarTipoMovimientoAlmacen(dto : DTOOID) : DTOTipoMovimientoAlmacen" 
        // Recuperar DTOTipoMovimientoAlmacen de respuesta		
        DTOTipoMovimientoAlmacen dtoTipoMovimientoAlmacen = null;

        try {
            dtoTipoMovimientoAlmacen = monMantenimientoTiposMovimientosAlmacen.consultarTipoMovimientoAlmacen(dtoOID);

            //UtilidadesLog.debug(dtoTipoMovimientoAlmacen.getOidEstadoMercancia1());
        } catch (RemoteException e) {
            this.loguearError("guardarGMA: RemoteException", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        // Si (DTOTipoMovimientoAlmacen.movimientoEntreAlmacenes = "True") entonces 
        // Llamar al CU Generar Solicitud Modulos Externos 
        // Llamar al método "PEDTaponGenerarSolicitudME.generarSolicitudModulosExternos" (Mirar en carpeta de interfaces, módulo PED) 
        // Fin Si 
        if (dtoTipoMovimientoAlmacen.getMovimientoEntreAlmacenes().booleanValue() == true) {
            try {
                    //Incidencia 8595
                    // Llamar al CU Generar Solicitud Modulos Externos 
                    //-> Tomar valor de atributo dto.cabecera.oidSubacceso y hacer findByPrimaryKey sobre la entidad Subacceso con el oid anterior 
                    SubaccesoLocalHome subaccesoLocalHome = this.getSubaccesoLocalHome();
                    SubaccesoLocal subaccesoLocal = subaccesoLocalHome.findByPrimaryKey(dtoGMA.getCabecera().getOidSubacceso());
            
                    //-> Tomar valor de atributo Subacceso.oidAcceso y Hacer findByPrimaryKey sobre la entidad Acceso con el oid anterior 
                    AccesoLocal accesoMEALocal = accesoHome.findByPrimaryKey(subaccesoLocal.getOidAcceso());
    
    
                    //-> Crear variable llamada "tsOperacion" de tipo DTOTipoSolicitudOperacion haciendo el siguiente mapeo: 
                    DTOTipoSolicitudOperacion tsOperacion = new DTOTipoSolicitudOperacion();
                    tsOperacion.setOidMarca(dtoGMA.getCabecera().getOidMarca()); 
                    tsOperacion.setOidCanal(accesoMEALocal.getOidCanal()); 
                    // Hallamos el tipo de cliente para el filtro 
                    //-> Hacer findByUK sobre la entidad ParametrosBelcenter pasando dto.cabecera.oidSubacceso 
                    ParametrosBelcenterLocalHome parametrosBelcenterLocalHome = this.getParametrosBelcenterLocalHome();
                    //Se elimino debido a la incidencia 10261
                    //ParametrosBelcenterLocal parametrosBelcenterLocal = parametrosBelcenterLocalHome.findByUK(dtoGMA.getCabecera().getOidSubacceso());
                    ParametrosBelcenterLocal parametrosBelcenterLocal = parametrosBelcenterLocalHome.findByUK(dtoGMA.getOidPais(), dtoGMA.getCabecera().getOidSubacceso());
    
    
                    //-> Llamar al método "DAOServicioBEL.obtenerPrimerTipoCliente(ParametrosBelcenter.oidCliente : Long) : Long" 
                    String usuario = ctx.getCallerPrincipal().getName();
                    
                    
                    DAOServicioBel daoServicioBel = new DAOServicioBel(usuario);
                    tsOperacion.setOidTipoCliente(daoServicioBel.obtenerPrimerTipoCliente(parametrosBelcenterLocal.getCliente())); 
                    tsOperacion.setOidOperacion(ConstantesBEL.BEL002);
                    tsOperacion.setOidIdioma(dtoGMA.getOidIdioma());
                    MONTiposSolicitudPais monTiposSolicitudPais = this.getMONTiposSolicitudPais();
                    UtilidadesLog.debug("****Metodo guardarGMA: tsOperacion " + tsOperacion.getOidTipoCliente() + " _ " + tsOperacion.getOidMarca() + " _ " + tsOperacion.getOidCanal() + " _CTE " + tsOperacion.getOidOperacion());
                    DTOSalida dtoSalida = monTiposSolicitudPais.obtieneTipoSolicitudOperacion(tsOperacion); 
                    //Asignar a "tipoSolicitud" el "oid de tipo de solicitud por pais" obtenido del primer registro del RecordSet obtenido en la llamada anterior 
                    Long tipoSolicitud = null;
                    if (dtoSalida != null && !dtoSalida.getResultado().esVacio()) {
                            UtilidadesLog.debug("****Metodo guardarGMA: dtoSalida no vacio " + dtoSalida.getResultado().getValueAt(0,0));
                            UtilidadesLog.debug("****Metodo guardarGMA: dtoSalida no vacio " + dtoSalida.getResultado().getValueAt(0,"OID"));
                            tipoSolicitud = new Long(((BigDecimal)dtoSalida.getResultado().getValueAt(0, "OID")).longValue());
                    }
                    DTOCabeceraSolicitud cabeceraSolicitud = new DTOCabeceraSolicitud();
                    cabeceraSolicitud.setOidPais(dtoGMA.getOidPais()); 
                    cabeceraSolicitud.setOidIdioma(dtoGMA.getOidIdioma()); 
                    cabeceraSolicitud.setMarca(dtoGMA.getCabecera().getOidMarca()); 
                    cabeceraSolicitud.setCanal(accesoMEALocal.getOidCanal());
                    cabeceraSolicitud.setAcceso(accesoMEALocal.getOid()); 
                    cabeceraSolicitud.setSubacceso(dtoGMA.getCabecera().getOidSubacceso()); 
                    cabeceraSolicitud.setTipoSolicitud(tipoSolicitud); 
                    cabeceraSolicitud.setTipoCliente(tsOperacion.getOidTipoCliente()); 
                    cabeceraSolicitud.setOidCliente(parametrosBelcenterLocal.getCliente()); 
                    //Hacer findByPrimaryKey sobre la entidad ClienteDatosBasicos tomando tsOperacion.oidCliente incidencia BELC300008982
                    ClienteDatosBasicosLocalHome clienteDBLH = this.getClienteDatosBasicosLocalHome();
                    ClienteDatosBasicosLocal clienteDBL = clienteDBLH.findByPrimaryKey(parametrosBelcenterLocal.getCliente());
                    cabeceraSolicitud.setCliente(clienteDBL.getCod_clie());
                    //cabeceraSolicitud.setCliente("00000009999"); 
                    cabeceraSolicitud.setModulo(new Long(ConstantesSEG.MODULO_BEL));
                    cabeceraSolicitud.setOperacion(ConstantesBEL.BEL002);
    
    
                    // Hallamos el periodo actual 
                    //-> Llamar al método "IPeriodos.obtienePeriodoActual(pais : Long, marca : Long, canal : Long) : DTOPeriodo" 
                    DTOPeriodo periodoActual = monPeriodos.obtienePeriodoActual(cabeceraSolicitud.getOidPais(), cabeceraSolicitud.getMarca(), cabeceraSolicitud.getCanal());
                    cabeceraSolicitud.setPeriodo(periodoActual.getOid()); 
                    cabeceraSolicitud.setFecha(fechaActual); 
                    cabeceraSolicitud.setNumeroDocumentoOrigen(new Long(1)); 
    
                    // Creamos las líneas de detalle 
                    //-> Hacer findByUK sobre la entidad TipoSolicitudProceso pasando ConstantesBEL.BEL002 y cabeceraSolicitud.oidSolicitud 
                    TiposSolicitudProcesoLocalHome tiposSolicitudProcesoLocalHome = this.getTiposSolicitudProcesoLocalHome();
                    UtilidadesLog.debug("****Metodo guardarGMA: tiposolicitud " + cabeceraSolicitud.getTipoSolicitud() + " _ " + tipoSolicitud + " _CTE " + ConstantesBEL.BEL002);
                    TiposSolicitudProcesoLocal tiposSolicitudProcesoLocal = tiposSolicitudProcesoLocalHome.findByUKProceso(ConstantesBEL.BEL002, cabeceraSolicitud.getTipoSolicitud());
    
                    ArrayList arrayPosiciones = new ArrayList(); 
                    //-> Recorrer dto.detalle con contador "i" 
                    for (int i = 0; i < dtoGMA.getDetalle().size(); i++) {
                            //-> Crear variable llamada "posicion" de tipo DTOPosicionSolicitud y hacer el siguiente mapeo:
                            DTOPosicionSolicitud dtoPosicionSolicitud = new DTOPosicionSolicitud();
                            dtoPosicionSolicitud.setTipoPosicion(tiposSolicitudProcesoLocal.getOidTipoPosicion()); 
                            dtoPosicionSolicitud.setSubtipoPosicion(tiposSolicitudProcesoLocal.getOidSubTipoPosicion()); 
                            dtoPosicionSolicitud.setProducto(((DTOGMADetalle)dtoGMA.getDetalle().get(i)).getOidProducto()); 
                            dtoPosicionSolicitud.setUnidadesDemandadas(((DTOGMADetalle)dtoGMA.getDetalle().get(i)).getCantidad());
                            dtoPosicionSolicitud.setUnidadesPorAtender(dtoPosicionSolicitud.getUnidadesDemandadas());
                            dtoPosicionSolicitud.setUnidadesDemandaReal(dtoPosicionSolicitud.getUnidadesDemandadas());
                            arrayPosiciones.add(dtoPosicionSolicitud);
                    }
                    //-> Añadir "posicion" a cabeceraSolicitud.posiciones (array de posiciones)
                    cabeceraSolicitud.setPosiciones(arrayPosiciones);
    
                    // Llamamos al método que implementa el CU Generar Solicitud Modulos Externos 
                    //-> Llamar al método "IPEDGenerarSolicitudesExternas.generaSolicitud(DTOE : DTOCabeceraSolicitud) : DTOOID" 
                    MONGenerarSolicitudModulosExternos monGenerarSolicitudModulosExternos = this.getMONGenerarSolicitudModulosExternos();
                    monGenerarSolicitudModulosExternos.generaSolicitud(cabeceraSolicitud);
            } catch (NoResultException fe) {
                    this.loguearError("guardarGMA_Movimientos entre almacenes: FinderException", fe);
                    codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
                    throw new MareException(fe, UtilidadesError.armarCodigoError(codigoError));
            }  catch (PersistenceException ce) {   
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                    
            } catch (RemoteException fe) {
                    this.loguearError("guardarGMA_Movimientos entre almacenes: RemoteException", fe);
                    codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                    throw new MareException(fe, UtilidadesError.armarCodigoError(codigoError));
            }
	
        }

        /*
        * Recorrer DTOGMA.detalle
        */

        // Crear objeto DTOMovimientoAlmacen 
        DTOMovimientoAlmacen dtoMovimientoAlmacen = new DTOMovimientoAlmacen();

        // Crear objeto DTOMovimientoAlmacenCabecera 
        DTOMovimientoAlmacenCabecera dtoMovimientoAlmacenCabecera = new DTOMovimientoAlmacenCabecera();

        // pais => pais de usuario activo en atributo DTOGMA.pais 
        dtoMovimientoAlmacenCabecera.setOidPais(dtoGMA.getOidPais());

        //- numeroDocumento => DTOGMA.cabecera.numeroDocumento 
        dtoMovimientoAlmacenCabecera.setNumeroDocumento(dtoGMA.getCabecera()
                                                              .getNumeroDocumento());

        //- oidTipoMovimientoAlmacen => DTOGMA.cabecera.oidTipoMovimientoAlmacen 
        dtoMovimientoAlmacenCabecera.setOidTipoMovimientoAlmacen(dtoGMA.getCabecera()
                                                                       .getOidTipoMovimientoAlmacen());

        //- fecha => fecha del sistema 

		//dtoMovimientoAlmacenCabecera.setFecha(fechaActual);
		
		// Cambio por incidencia 10660: ahora la fecha es la del dto de entrada

        dtoMovimientoAlmacenCabecera.setFecha(new Date(dtoGMA.getCabecera().getFecha().getTime()));

        //- oidAlmacenSalida => DTOGMA.cabecera.oidAlmacenOrigen 
        dtoMovimientoAlmacenCabecera.setOidAlmacenSalida(dtoGMA.getCabecera()
                                                               .getOidAlmacenOrigen());

        //- oidAlmacenEntrada => DTOGMA.cabecera.oidAlmacenDestino 
        dtoMovimientoAlmacenCabecera.setOidAlmacenEntrada(dtoGMA.getCabecera()
                                                                .getOidAlmacenDestino());

        //- oidMarca => DTOGMA.cabecera.oidMarca 
        dtoMovimientoAlmacenCabecera.setOidMarca(dtoGMA.getCabecera()
                                                       .getOidMarca());

        //- oidCanal => oid de canal obtenido anteriormente 
        dtoMovimientoAlmacenCabecera.setOidCanal(oidCanal); 

        //- oidAcceso => oid de acceso obtenido anteriormente 
        dtoMovimientoAlmacenCabecera.setOidAcceso(oidAcceso); 

        //- oidSubacceso => DTOGMA.cabera.oidSubacceso 
        dtoMovimientoAlmacenCabecera.setOidSubacceso(dtoGMA.getCabecera()
                                                           .getOidSubacceso());

        //- oidPeriodo => oid de período obtenido 
        dtoMovimientoAlmacenCabecera.setOidPeriodo(oidPeriodo);

        //- observaciones => DTOGMA.cabecera.observaciones 
        dtoMovimientoAlmacenCabecera.setObservaciones(dtoGMA.getCabecera()
                                                            .getObservaciones());

        //- indicadorNoGenerarCabecera => "False" 
        dtoMovimientoAlmacenCabecera.setIndicadorNoGenerarCabecera(new Boolean(
                false));

        // Asignar objeto DTOMovimientoAlmacenCabecera al atributo DTOMovimientoAlmacen.cabecera 
        dtoMovimientoAlmacen.setCabecera(dtoMovimientoAlmacenCabecera);
        dtoMovimientoAlmacen.setOidIdioma(dtoGMA.getOidIdioma());
        dtoMovimientoAlmacen.setOidPais(dtoGMA.getOidPais());

        // Para cada objeto DTOGMADetalle contenido en el atributo DTOGMA.detalle hacer
        Iterator iterador = dtoGMA.getDetalle().iterator();
        DTOGMADetalle dtoGMADetalle = null;
        Long saldo = null;
        ArrayList detalles = new ArrayList(); //para dtoMovimientoAlmacen.SetDetalle

		//Añadido por incidencias 10708 y 10661 paraobtener el codigo sap del producto
		MaestroProductosLocal maestroProductosLocal = null;
        MaestroProductosLocalHome maestroProductosLocalHome = this.getMaestroProductosLocalHome();
		MaestroProductosPK mae = null;

        while (iterador.hasNext()) {
            // Llamar al método "MONServicioBEL.comprobarStock(almacen : Long, estado : Long, producto : Long) : Long" pasando el atributo DTOGMA.cabecera.almacenOrigen, el atributo del tipo de movimiento recuperado DTOTipoMovimientoAlmacen.oidEstadoMercancia, y el atributo DTOGMADetalle.oidProducto 
            dtoGMADetalle = (DTOGMADetalle) iterador.next();

            try {

				//BELBELC300009431 
				/*
				 * (4)Si ((tipoMovimiento.operacion1 = '-') and (DTOGMADetalle.cantidad > 0)||
				(tipoMovimiento.operacion1 = '+') and (DTOGMADetalle.cantidad < 0)) entonces
				-> Llamar al método "MONServicioBEL.comprobarStock(almacen : Long, estado : Long, producto : Long) : Long" pasando el atributo dto.cabecera.almacenOrigen, el atributo del tipo de movimiento recuperado DTOTipoMovimientoAlmacen.oidEstadoMercancia, y el atributo DTOGMADetalle.oidProducto
					-> La llama anterior devuelve el saldo de producto
					(5)Si (saldo < ABS(DTOGMADetalle.cantidad)) entonces
						-> Lanzar MareException con el código de mensaje "BEL-0003"
					(5)Fin Si
				(4)Fin si
				*/
				
				if((dtoTipoMovimientoAlmacen.getOperacion1().equals(new Character('-')) && dtoGMADetalle.getCantidad().longValue() > 0) || (dtoTipoMovimientoAlmacen.getOperacion1().equals(new Character('+')) && dtoGMADetalle.getCantidad().longValue() < 0)) {
					// BELC300006117. Se pasa OidEstadoMercancia1
					saldo = monServicioBEL.comprobarStock(dtoGMA.getCabecera().getOidAlmacenOrigen(), dtoTipoMovimientoAlmacen.getOidEstadoMercancia1(), dtoGMADetalle.getOidProducto()); 
					// Si (saldo < DTOGMADetalle.cantidad) entonces 
					// Lanzar MareException con el código de mensaje "BEL-0003" 
					if (saldo.longValue() < Math.abs(dtoGMADetalle.getCantidad().longValue())) {
						//Modificado por incidencias 10708 y 10661
						/*throw new MareException(new Exception(),
							UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_BEL,
								ErroresDeNegocio.SALDO_INSUFICIENTE_PARA_PRODUCTO));*/
						//Debemos obtener el codigo sap del producto
						mae=new MaestroProductosPK(dtoGMADetalle.getOidProducto());
						try {
							maestroProductosLocal=maestroProductosLocalHome.findByPrimaryKey(mae);
						}catch (FinderException fe) {
							this.loguearError("guardarGMA: FinderException", fe);
							codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
							throw new MareException(fe,
								UtilidadesError.armarCodigoError(codigoError));
						}
						
						ExcepcionParametrizada ep = new ExcepcionParametrizada("", UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_BEL, "", ErroresDeNegocio.SALDO_INSUFICIENTE_PARA_PRODUCTO));
						ep.addParameter(maestroProductosLocal.getCodigoSAP());
						ep.setPosicion(ExcepcionParametrizada.POSICION_MEDIO);
						throw ep;
					}
				}
            } catch (RemoteException e) {
                this.loguearError("guardarGMA: RemoteException", e);
                throw new MareException(e,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }

            DTOMovimientoAlmacenDetalle dtoMovimientoAlmacenDetalle = new DTOMovimientoAlmacenDetalle();

            // numeroMovimiento => NULL 
            // oidTipoMovimientoAlmacen => NULL 
            // oidAlmacenSalida => NULL 
            // oidAlmacenEntrada => NULL 
            // oidProducto => DTOGMA.detalle.oidProducto 
            dtoMovimientoAlmacenDetalle.setOidProducto(dtoGMADetalle.getOidProducto());

            // cantidad => DTOGMA.detalle.cantidad
            dtoMovimientoAlmacenDetalle.setCantidad(dtoGMADetalle.getCantidad());

            // unidadesAtendidas => NULL 
            // precioVentaNeto => DTOGMA.detalle.precioVentaNeto 
            dtoMovimientoAlmacenDetalle.setPrecioVentaNeto(dtoGMADetalle.getPrecioVentaNeto());

            // precioContable => DTOGMA.detalle.precioContable
            dtoMovimientoAlmacenDetalle.setPrecioContable(dtoGMADetalle.getPrecioContable());

            // numeroPosicionReferencia => NULL 
            // numeroDocumentoReferencia => NULL 
            // operacion => "BEL001"
            dtoMovimientoAlmacenDetalle.setOperacion("BEL001");

            detalles.add(dtoMovimientoAlmacenDetalle);
        }

        dtoMovimientoAlmacen.setDetalle(detalles);

        // Llamada al CU Grabar Movimiento Almacen y Stock 
        // Llamar al método "MONGenerarMovimientoAlmacen.grabarMovimientoAlmacenYStock(dto : DTOMovimientoAlmacen) : DTOLineasKO" 
        try {
            DTOReportePedidos dtoReportePedidos = monGenerarMovimientoAlmacen.grabarMovimientoAlmacenYStock(dtoMovimientoAlmacen);
        } catch (RemoteException e) {
            this.loguearError("guardarGMA: RemoteException", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        UtilidadesLog.info("MONGenerarMovimientosAlmacenBean.guardarGMA(DTOGMA dtoGMA):Salida");
    }

    private MONServicioBEL getMONServicioBEL() throws MareException {
        // Se obtiene el interfaz home
        UtilidadesLog.debug("****Metodo getMONServicioBEL: Entrada");

        MONServicioBELHome home = (MONServicioBELHome) UtilidadesEJB.getHome("MONServicioBEL",
                MONServicioBELHome.class);

        // Se obtiene el interfaz remoto
        MONServicioBEL ejb = null;

        try {
            ejb = home.create();
        } catch (Exception e) {
            this.loguearError("*** Error en getMONServicioBEL", e);

            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.debug("****Metodo getMONServicioBEL: Salida");

        return ejb;
    }





    private MONGenerarSolicitudModulosExternos getMONGenerarSolicitudModulosExternos() throws MareException {
        // Se obtiene el interfaz home
        UtilidadesLog.debug("****Metodo getMONGenerarSolicitudModulosExternos: Entrada");

        MONGenerarSolicitudModulosExternosHome home = (MONGenerarSolicitudModulosExternosHome) UtilidadesEJB.getHome("MONGenerarSolicitudModulosExternos",  MONGenerarSolicitudModulosExternosHome.class);

        // Se obtiene el interfaz remoto
        MONGenerarSolicitudModulosExternos ejb = null;

        try {
            ejb = home.create();
        } catch (Exception e) {
            this.loguearError("*** Error en getMONGenerarSolicitudModulosExternos", e);

            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.debug("****Metodo getMONGenerarSolicitudModulosExternos: Salida");

        return ejb;
    }

    private MONPeriodos getMONPeriodos() throws MareException {
        // Se obtiene el interfaz home
        UtilidadesLog.debug("****Metodo getMONPeriodos: Entrada");

        MONPeriodosHome home = (MONPeriodosHome) UtilidadesEJB.getHome("MONPeriodos", MONPeriodosHome.class);

        // Se obtiene el interfaz remoto
        MONPeriodos ejb = null;

        try {
            ejb = home.create();
        } catch (Exception e) {
            this.loguearError("*** Error en getMONPeriodos", e);

            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.debug("****Metodo getMONPeriodos: Salida");

        return ejb;
    }

    private MONMantenimientoTiposMovimientosAlmacen getMONMantenimientoTiposMovimientosAlmacen()
        throws MareException {
        // Se obtiene el interfaz home
        UtilidadesLog.debug("****Metodo getMONMantenimientoTiposMovimientosAlmacen: Entrada");

        MONMantenimientoTiposMovimientosAlmacenHome home = (MONMantenimientoTiposMovimientosAlmacenHome) UtilidadesEJB.getHome("MONMantenimientoTiposMovimientosAlmacen",
                MONMantenimientoTiposMovimientosAlmacenHome.class);

        // Se obtiene el interfaz remoto
        MONMantenimientoTiposMovimientosAlmacen ejb = null;

        try {
            ejb = home.create();
        } catch (Exception e) {
            this.loguearError("*** Error en getMONMantenimientoTiposMovimientosAlmacen", e);

            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.debug("****Metodo getMONMantenimientoTiposMovimientosAlmacen: Salida");

        return ejb;
    }

    private MONGenerarMovimientoAlmacen getMONGenerarMovimientoAlmacen() throws MareException {
        // Se obtiene el interfaz home
        UtilidadesLog.debug("****Metodo getMONGenerarMovimientoAlmacen: Entrada");

        MONGenerarMovimientoAlmacenHome home = (MONGenerarMovimientoAlmacenHome) UtilidadesEJB.getHome("MONGenerarMovimientoAlmacen",
                MONGenerarMovimientoAlmacenHome.class);

        // Se obtiene el interfaz remoto
        MONGenerarMovimientoAlmacen ejb = null;

        try {
            ejb = home.create();
        } catch (Exception e) {
            this.loguearError("*** Error en getMONGenerarMovimientoAlmacen", e);

            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.debug("****Metodo getMONGenerarMovimientoAlmacen: Salida");

        return ejb;
    }

    private MONValidacion getMONValidacion() throws MareException {
        // Se obtiene el interfaz home
        UtilidadesLog.debug("****Metodo getMONValidacion: Entrada");

        MONValidacionHome home = (MONValidacionHome) UtilidadesEJB.getHome("MONValidacion",
                MONValidacionHome.class);

        // Se obtiene el interfaz remoto
        MONValidacion ejb = null;

        try {
            ejb = home.create();
        } catch (Exception e) {
            this.loguearError("*** Error en getMONValidacion", e);

            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.debug("****Metodo  getMONValidacion: Salida");

        return ejb;
    }

    private MONTiposSolicitudPais getMONTiposSolicitudPais() throws MareException {
        // Se obtiene el interfaz home
        UtilidadesLog.debug("****Metodo getMONTiposSolicitudPais: Entrada");

        MONTiposSolicitudPaisHome home = (MONTiposSolicitudPaisHome) UtilidadesEJB.getHome("MONTiposSolicitudPais", MONTiposSolicitudPaisHome.class);

        // Se obtiene el interfaz remoto
        MONTiposSolicitudPais ejb = null;

        try {
            ejb = home.create();
        } catch (Exception e) {
            this.loguearError("*** Error en getMONTiposSolicitudPais", e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        UtilidadesLog.debug("****Metodo getMONTiposSolicitudPais: Salida");

        return ejb;
    }

    private void loguearError(String mensaje, Throwable e) {
        UtilidadesLog.debug("****Metodo loguearError: Entrada");
        UtilidadesLog.error("****Error Metodo: " + mensaje + ": " +
            e.getMessage());
        UtilidadesLog.error(e);
    }

    private void loguearStackTrace(Throwable e) {
        UtilidadesLog.debug("****Metodo loguearStackTrace: Entrada");

        try {
            ByteArrayOutputStream pila = new ByteArrayOutputStream();
            PrintStream out = new PrintStream(pila);
            /*e.printStackTrace(out);
            UtilidadesLog.error(pila.toString());*/
            UtilidadesLog.error(e);
        } catch (Exception ex) {
            UtilidadesLog.error("Error Logeando Pila: " + ex.getMessage());
        }
    }

    private Boolean validarVinculos(Long Pais, Long Sociedad, Long Marca,
        Long Canal, Long Acceso, Long Subacceso) throws MareException {
        UtilidadesLog.info("MONGenerarMovimientosAlmacenBean.validarVinculos(Long Pais, Long Sociedad, Long Marca, Long Canal, Long Acceso, Long Subacceso):Entrada");
        try {
            MONValidacion monValidacion = getMONValidacion();

            if (!(monValidacion.validarVinculos(Pais, Sociedad, Marca, Canal,
                        Acceso, Subacceso)).booleanValue()) {
                UtilidadesLog.error(
                    "compruebaAcceso: validarVinculos: CodigosError.ERROR_VINCULOS_INVALIDOS");
                throw new MareException(new Exception(),
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_VINCULOS_INVALIDOS));
            }
        } catch (RemoteException re) {
            ctx.setRollbackOnly();
            this.loguearError("guardarReclamo: RemoteException:validarVinculos",
                re);
            throw new MareException(re,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (MareException e) {
            throw e;
        }
        UtilidadesLog.info("MONGenerarMovimientosAlmacenBean.validarVinculos(Long Pais, Long Sociedad, Long Marca, Long Canal, Long Acceso, Long Subacceso):Salida");
        return Boolean.TRUE;
    }


    private MaestroProductosLocalHome getMaestroProductosLocalHome() throws MareException {
        UtilidadesLog.debug("****Metodo getMaestroProductosLocalHome: Entrada");
        MaestroProductosLocalHome maestroProductosLocalHome = (MaestroProductosLocalHome) UtilidadesEJB.getLocalHome("java:comp/env/MaestroProductos");
        UtilidadesLog.debug("****Metodo getMaestroProductosLocalHome: Salida");
        return maestroProductosLocalHome;
    }
    
    private AccesoLocalHome getAccesoLocalHome() {
        return new AccesoLocalHome();
    }
    
    private CanalLocalHome getCanalLocalHome() {
        return new CanalLocalHome();
    }
    
    private ClienteDatosBasicosLocalHome getClienteDatosBasicosLocalHome() {
        return new ClienteDatosBasicosLocalHome();
    }    
    
    private ParametrosBelcenterLocalHome getParametrosBelcenterLocalHome() {
      return new ParametrosBelcenterLocalHome();
    }
    
    private SubaccesoLocalHome getSubaccesoLocalHome() {
        return new SubaccesoLocalHome();
    }    
    
    private TiposSolicitudProcesoLocalHome getTiposSolicitudProcesoLocalHome() {
        return new TiposSolicitudProcesoLocalHome();
    }    
    


}
