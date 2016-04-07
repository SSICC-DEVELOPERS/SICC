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

import es.indra.sicc.dtos.bel.DTOMovimientoAlmacen;
import es.indra.sicc.dtos.bel.DTOMovimientoAlmacenCabecera;
import es.indra.sicc.dtos.bel.DTOMovimientoAlmacenDetalle;
import es.indra.sicc.dtos.rec.DTOAtencionReclamoREC;
import es.indra.sicc.dtos.rec.DTOBuscarProductosReclamados;
import es.indra.sicc.dtos.rec.DTOLineasOperacion;
import es.indra.sicc.dtos.rec.DTOMovAlmac;
import es.indra.sicc.dtos.rec.DTORecibirProductos;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;

import es.indra.sicc.entidades.rec.LineasOperacionReclamoLocal;
import es.indra.sicc.entidades.rec.LineasOperacionReclamoLocalHome;

import es.indra.sicc.entidades.rec.OperacionReclamoLocal;
import es.indra.sicc.entidades.rec.OperacionReclamoLocalHome;

import es.indra.sicc.logicanegocio.bel.ConstantesBEL;
import es.indra.sicc.logicanegocio.bel.MONGenerarMovimientoAlmacen;
import es.indra.sicc.logicanegocio.bel.MONGenerarMovimientoAlmacenHome;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class MONRecibirProductosBean implements SessionBean  {
    
    private SessionContext ctx;
    
    public void ejbCreate() {
    }

    public void ejbActivate() {
    }

    public void ejbPassivate() {
    }

    public void ejbRemove() {
    }

    public void setSessionContext(SessionContext ctx){
        this.ctx = ctx;
    }

    public DTOSalida buscarProductosReclamados(DTOBuscarProductosReclamados dto) throws MareException {
    	UtilidadesLog.info("MONRecibirProductos.buscarProductosReclamados(DTOBuscarProductosReclamados):Entrada");

        DAORecibirProductos dao = new DAORecibirProductos();
        DTOSalida dtoSalida = dao.buscarProductosReclamados(dto);
		UtilidadesLog.info("MONRecibirProductos.buscarProductosReclamados(DTOBuscarProductosReclamados):Salida");
        return dtoSalida;
    }
    /**
    * Sistema:     Belcorp
    * Modulo:      REC
    * Fecha:       11/10/2005
    * @version     1.0
    * @autor       Cristian Valenzuela
    */
    // BELC300015967, BELC300015997, BELC300016018, BELC300016020
    public void recibirProductos(DTORecibirProductos dto) throws MareException {
        UtilidadesLog.info("MONRecibirProductos.recibirProductos(DTORecibirProductos):Entrada");
        UtilidadesLog.debug("DTORecibirProductos dto: " + dto);
        
        // Ordenamos las posiciones del ArrayList Lineas en función del atributo 
        // oidCabeceraReclamo de cada DTOLineasOperacion.
        
        ArrayList arrayLineas = dto.getLineas();
        ArrayList arrayOrdenado = new ArrayList();
        DTOLineasOperacion dtoLineas = null;
        DTOLineasOperacion dtoLineasMenor = null;
        int menor;
        // Ordenamos todos los elementos
        
        while( arrayLineas.size() > 0 ) {
            UtilidadesLog.debug("AAAA");
            menor = 0;
            dtoLineasMenor = (DTOLineasOperacion)arrayLineas.get(menor);
            // Buscamos el menor 
            for(int j = 1; j<arrayLineas.size(); j++) {
                UtilidadesLog.debug("BBBB");
                dtoLineas = (DTOLineasOperacion)arrayLineas.get(j);
                // Si encuentro uno menor que el que habíamos considerado
                if(dtoLineas.getOidCabeceraReclamo().longValue() < 
                                            dtoLineasMenor.getOidCabeceraReclamo().longValue()) {
                    UtilidadesLog.debug("CCCC");
                    dtoLineasMenor = dtoLineas;
                    menor = j;
                }
            }
            
            // Ya tenemos el menor. Lo eliminamos de la lista original y lo añadimos a la nueva
            UtilidadesLog.debug("DDDD");
            arrayOrdenado.add(dtoLineasMenor);
            arrayLineas.remove(menor);
        }
        
        //Vamos a actualizar las unidades a devolver de las lineas recibidas en el dtoe
        LineasOperacionReclamoLocalHome lineasOperacionLH = new LineasOperacionReclamoLocalHome();
        LineasOperacionReclamoLocal lineasOperacionLocal = null;
        UtilidadesLog.debug(" ****** Primer bucle");
        for(int i = 0; i<arrayOrdenado.size(); i++) {
            UtilidadesLog.debug("Bucle " + i);    
            dtoLineas = (DTOLineasOperacion)arrayOrdenado.get(i);
            try {
                lineasOperacionLocal = lineasOperacionLH.findByPrimaryKey(dtoLineas.getOidLineaOperacion());
            } catch(NoResultException e) {
                String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
                ctx.setRollbackOnly();
                throw new MareException(e, UtilidadesError.armarCodigoError(error));
            }catch (PersistenceException createException) {
               UtilidadesLog.debug(createException);
               ctx.setRollbackOnly();
               throw new MareException(createException,
                   UtilidadesError.armarCodigoError(
                       CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));        
            }
            // BELC300015967, BELC300019645 
            // LineaOperacion.unidadesDevueltas = LineaOperacion.unidadesDevueltas + Lineas.unidadesADevolver
            
            // Modificado por ssantana, 26/10/2005
            // (lineasOperacionLocal.getNumeroUnidadesDevueltas() puede ser null)
            Integer iNroUnidadesDevueltasEntity = 
                                lineasOperacionLocal.getNumeroUnidadesDevueltas();
            Integer iNroUnidadesDevueltasDTO = 
                                dtoLineas.getNumeroUnidadesADevolver();
                                
            if ( iNroUnidadesDevueltasEntity == null ) {
               iNroUnidadesDevueltasEntity = new Integer(0);
            }
            
            // No creo que ESTE venga null, pero por las dudas, sumarle 0 no hace daño.
            if ( iNroUnidadesDevueltasDTO == null ) {
               iNroUnidadesDevueltasDTO = new Integer(0);
            }
            UtilidadesLog.debug(" --- iNroUnidadesDevueltasEntity " + iNroUnidadesDevueltasEntity);
            UtilidadesLog.debug(" --- iNroUnidadesDevueltasDTO " + iNroUnidadesDevueltasDTO);
            UtilidadesLog.debug(" --- Suma " + iNroUnidadesDevueltasDTO);
            
            int iSuma = iNroUnidadesDevueltasEntity.intValue() + 
                                              iNroUnidadesDevueltasDTO.intValue();
            Integer iSumaUnidadesDevueltas = new Integer(iSuma);
            UtilidadesLog.debug(" --- Suma " + iSumaUnidadesDevueltas);
            lineasOperacionLocal.setNumeroUnidadesDevueltas(iSumaUnidadesDevueltas);
            lineasOperacionLH.merge(lineasOperacionLocal);
        }
        
        UtilidadesLog.debug("sale de bucle");
        /*Vamos a ingresar en almacén cada producto ingresado (cada linea de operacion recibida)*/
        //vamos a obtener el movimiento de almacén y el almacén para cada línea
        DAORecibirProductos dao = new DAORecibirProductos();
        ArrayList movAlmacen = dao.obtenerAlmacenDeLinea(arrayOrdenado);
        
        // Vamos a llamar al caso de uso Movimiento de almacén y Stock (BEL).
        // Las lineas recibidas pueden ser de varias solicitudes. 
        // Debemos llamar al Caso de uso con una cabecera (para todas las lineas de la misma solicitud) y un 
        // detalle con las lineas. 
        DTOOID dtoOid = new DTOOID();
        dtoOid.setOidPais(dto.getOidPais());
        dtoOid.setOidIdioma(dto.getOidIdioma());
        
        Long oidCabeceraReclamoAux = new Long(0);
        DTOMovimientoAlmacen dtoMovimientoAlmacen = null;
        DTOMovimientoAlmacenCabecera dtoMovimientoAlmacenCabecera = null;
        DTOMovimientoAlmacenDetalle dtoMovimientoAlmacenDetalle = null;
        DTOMovAlmac dtoMovAlmac = null;
        MONGenerarMovimientoAlmacen mon = this.getMONGenerarMovimientoAlmacen();
        ArrayList arrayAlmacenDetalle = new ArrayList();
        boolean cambioCabecera = true;
        
        UtilidadesLog.debug(" ****** Segundo bucle");
        for(int i = 0; i<arrayOrdenado.size(); i++) {
            UtilidadesLog.debug("Bucle " + i);    
            dtoLineas = (DTOLineasOperacion) arrayOrdenado.get(i);
            
            // Hemos cambiado de cabecera.
            if(dtoLineas.getOidCabeceraReclamo().longValue()!=oidCabeceraReclamoAux.longValue()) {
                UtilidadesLog.debug(" ---- Aca A");
                if(dtoMovimientoAlmacen!=null) {
                    UtilidadesLog.debug(" ---- Aca A1");
                    // Añado al DTO los detalles que hemos ido recopilando
                    dtoMovimientoAlmacen.setDetalle(arrayAlmacenDetalle);
                    try {
                        mon.grabarMovimientoAlmacenYStock(dtoMovimientoAlmacen);
                    } catch (RemoteException e) {
                        String error = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                        ctx.setRollbackOnly();
                        throw new MareException(e, UtilidadesError.armarCodigoError(error));
                    }                    
                    dtoOid.setOid(dtoLineas.getOidCabeceraReclamo());
                    UtilidadesLog.debug(" ---- Aca A2");
                    this.generarSolicitud(arrayOrdenado, dtoOid);
                    // Preparo la creación de un nuevo dto de cabecera
                    UtilidadesLog.debug(" ---- Aca A3");
                    arrayAlmacenDetalle = new ArrayList();
                    cambioCabecera = true;
                }
            }
            
            UtilidadesLog.debug(" ---- Aca B");
            // Si ha cambiado el oid, cambio la cabecera
            if(cambioCabecera) {
                UtilidadesLog.debug(" ---- Aca C");
                dtoMovimientoAlmacenCabecera = new DTOMovimientoAlmacenCabecera();
                dtoMovimientoAlmacenCabecera.setOidPais(dto.getOidPais());
                if(dtoLineas.getOidMarca()!=null) {
                    dtoMovimientoAlmacenCabecera.setOidMarca(dtoLineas.getOidMarca());
                }
                if(dtoLineas.getOidCanal()!=null) {
                    dtoMovimientoAlmacenCabecera.setOidCanal(dtoLineas.getOidCanal());
                }
                if(dtoLineas.getOidAcceso()!=null) {
                    dtoMovimientoAlmacenCabecera.setOidAcceso(dtoLineas.getOidAcceso());
                }
                if(dtoLineas.getOidSubAcceso()!=null) {
                    dtoMovimientoAlmacenCabecera.setOidSubacceso(dtoLineas.getOidSubAcceso());
                }
                if(dtoLineas.getOidPeriodoReclamo()!=null) {
                    dtoMovimientoAlmacenCabecera.setOidPeriodo(dtoLineas.getOidPeriodoReclamo());
                }
                UtilidadesLog.debug(" ---- Aca C1");
                dtoMovimientoAlmacenCabecera.setFecha(new Date(System.currentTimeMillis()));
                dtoMovimientoAlmacenCabecera.setIndicadorNoGenerarCabecera(Boolean.FALSE);
                dtoMovimientoAlmacen = new DTOMovimientoAlmacen();
                dtoMovimientoAlmacen.setCabecera(dtoMovimientoAlmacenCabecera);
                dtoMovimientoAlmacen.setOidPais(dto.getOidPais());
                dtoMovimientoAlmacen.setOidIdioma(dto.getOidIdioma());
                oidCabeceraReclamoAux=dtoLineas.getOidCabeceraReclamo();
                UtilidadesLog.debug(" ---- Aca C2");
                cambioCabecera = false;
            }
            
            UtilidadesLog.debug(" ************** Tercar bucle (dentro del 2do)");
            for(int j = 0; j<movAlmacen.size(); j++) {
                UtilidadesLog.debug("         Sub-bucle " + j);
                dtoMovAlmac = (DTOMovAlmac) movAlmacen.get(j);
            
                if(dtoLineas.getOidLineaOperacion().longValue()==dtoMovAlmac.getOidLineaOperacion().longValue()) {
                    dtoMovimientoAlmacenDetalle = new DTOMovimientoAlmacenDetalle();
                    // El almacén es de salida. BELC300016020 
                    if(dtoMovAlmac.getOidAlmacen()!=null) {
                        dtoMovimientoAlmacenDetalle.setOidAlmacenSalida(dtoMovAlmac.getOidAlmacen());
                    }
                    if(dtoMovAlmac.getOidTipoMovimiento()!=null) {
                        dtoMovimientoAlmacenDetalle.setOidTipoMovimientoAlmacen(dtoMovAlmac.getOidTipoMovimiento());
                    }
                    if(dtoMovAlmac.getOidTipoOferta()!=null) {
                        dtoMovimientoAlmacenDetalle.setOidTipoOferta(dtoMovAlmac.getOidTipoOferta());
                    }
                    if(dtoMovAlmac.getOidProducto()!=null) {
                        dtoMovimientoAlmacenDetalle.setOidProducto(dtoMovAlmac.getOidProducto());
                    }
                    if(dtoLineas.getNumeroUnidadesADevolver()!=null) {
                        dtoMovimientoAlmacenDetalle.setCantidad(new Long(
                                                dtoLineas.getNumeroUnidadesADevolver().longValue()));
                    }                    
                    // ConstantesBEL.COD_REC051. BELC300015997
                     dtoMovimientoAlmacenDetalle.setOperacion(ConstantesBEL.COD_REC051);
                    
                    //Agregado por Cristian Valenzuela
                    //Incidencia BELC300020954
                    dtoMovimientoAlmacenDetalle.setOidTipoPosicion(dtoMovAlmac.getOidTipoPosicion());
                    dtoMovimientoAlmacenDetalle.setOidSubtipoPosicion(dtoMovAlmac.getOidSubtipoPosicion());                    
                    //FIN - Agregado por Cristian Valenzuela                    
                    UtilidadesLog.debug("         Agregad dto - " + dtoMovimientoAlmacenDetalle);
                    arrayAlmacenDetalle.add(dtoMovimientoAlmacenDetalle);
                    // Solo puede haber un almacen asociado a la línea. Salimos del for
                    break;
                }
            }
        }
        //Con esta coprobacion nos aseguramos que la ultima cabecera siempre se graba
        UtilidadesLog.debug(" Sale de bucles ");
        if(arrayOrdenado.size()>0) {
            UtilidadesLog.debug(" ---- Aca OOOOOOOOO");
            // Añado al DTO los detalles que hemos ido recopilando
            dtoMovimientoAlmacen.setDetalle(arrayAlmacenDetalle);
            try {
                UtilidadesLog.debug("Antes grabarMovimientoAlmacenYStock.FUERA FOR");
                mon.grabarMovimientoAlmacenYStock(dtoMovimientoAlmacen);
            } catch (RemoteException e) {
                String error = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                ctx.setRollbackOnly();
                throw new MareException(e, UtilidadesError.armarCodigoError(error));
            }
            dtoOid.setOid(new Long(dtoLineas.getOidCabeceraReclamo().longValue()));
            UtilidadesLog.debug(" ---- Aca PPPPPPPPPP");
            this.generarSolicitud(arrayOrdenado, dtoOid);
        }
        
		UtilidadesLog.info("MONRecibirProductos.recibirProductos(DTORecibirProductos):Salida");
    }

    // BELC300016018, BELC300016020
    public void generarSolicitud(ArrayList lineas, DTOOID dtoOid) throws MareException {
        // Generamos una solicitud para las lineas del reclamo recibido
		UtilidadesLog.info("MONRecibirProductos.generarSolicitud(ArrayList , DTOOID):Entrada");
        
        boolean esperarMercaderia = true;
        boolean unidadesValidas = true;
        Long numeroAtencion = new Long(0);
        
        int tam = lineas.size();
        DTOLineasOperacion dtoLineas = null;
        
        OperacionReclamoLocalHome operacionReclamoLH = null;
        OperacionReclamoLocal operacionReclamoL = null;
        
        for(int posicion = 0; posicion<tam; posicion++) {
            dtoLineas = (DTOLineasOperacion) lineas.get(posicion);
            
            if(dtoLineas.getOidCabeceraReclamo().longValue() == dtoOid.getOid().longValue()) {
                UtilidadesLog.debug("Entra, oidCabeceraReclamo igual que DTOOID");
                if((numeroAtencion.longValue() == 0) && (dtoLineas.getNumeroAtencion()!=null)) {
                    numeroAtencion = new Long(dtoLineas.getNumeroAtencion().longValue());
                }
                
                if (dtoLineas.getIndEntregaMercaderia() != null && dtoLineas.getIndEntregaMercaderia().equals( ConstantesREC.IND_MERCADERIA_N)){
                    if(dtoLineas.getEsperarMercaderia().booleanValue() == false) {
                        esperarMercaderia = false;                    
                    }
                }
                
                UtilidadesLog.debug("NumeroUnidadesDevueltas: " + dtoLineas.getNumeroUnidadesDevueltas());
                UtilidadesLog.debug("NumeroUnidadesADevolver: " + dtoLineas.getNumeroUnidadesADevolver());
                UtilidadesLog.debug("UnidadesReclamadas: " + dtoLineas.getUnidadesReclamadas());
                
                UtilidadesLog.debug("EsperarMercaderia: "+dtoLineas.getEsperarMercaderia().booleanValue());
                if((dtoLineas.getDevuelveFisico().booleanValue() == true) || 
                                (dtoLineas.getPrecioUnitario().longValue() == 0)) {
                    // Añadido atributo a DTOLineasOperacion BELC300016020
                    
                    if ((dtoLineas.getNumeroUnidadesADevolver().longValue() 
                            + dtoLineas.getNumeroUnidadesDevueltas().longValue() != dtoLineas.getUnidadesReclamadas().longValue())
                            || (dtoLineas.getNumeroUnidadesADevolver()==null) || (dtoLineas.getUnidadesReclamadas()==null)) {
                        unidadesValidas = false;
                        UtilidadesLog.debug("UnidadesValidas=false");
                    } else if(esperarMercaderia == true) {
                    
                        UtilidadesLog.debug("esperarMercaderia == true");
                    
                        //// Actualizamos el indicador de entrega de mercadería de la entidad operacionReclamo
                        //Hacemos un findByUK sobre la entidad operacionReclamo 
                        //con los campos  numeroOperacion y oidCabecera ambos de la lineaReclamo.
                        //Actualizamos el campo INEM_OID_INDI_ENTR_MERC de la 
                        //entidadObtenida con el       valor ConstantesREC.IND_MERCADERIA_S y lo guardamos en la base.
                        operacionReclamoLH = new OperacionReclamoLocalHome();
                        operacionReclamoL = null;
                        
                        UtilidadesLog.debug("OID RECLAMO: " + dtoOid.getOid());
                        UtilidadesLog.debug("NUMERO OPERACION: " + dtoLineas.getNumeroOperacion());
                        
                        try{
                            operacionReclamoL = operacionReclamoLH.findByUK(dtoOid.getOid(), dtoLineas.getNumeroOperacion());
                        } catch(NoResultException fe){
                    
                            if (operacionReclamoL != null){
                                UtilidadesLog.debug("operacionReclamoL.oid: " + operacionReclamoL.getOid());
                            } else {
                                UtilidadesLog.debug("operacionReclamoL: null");
                            }
                        
                            if (operacionReclamoL != null){
                                operacionReclamoL.setIndicativoEntregaMercaderia(ConstantesREC.IND_MERCADERIA_S);
                            }
                            operacionReclamoLH.merge(operacionReclamoL);
                        }catch (PersistenceException createException) {
                           UtilidadesLog.debug(createException);
                           ctx.setRollbackOnly();
                           throw new MareException(createException,
                               UtilidadesError.armarCodigoError(
                                   CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));        
                        }
                }
            }
        }
        
        if((esperarMercaderia == true) && (unidadesValidas == true)) {
        
            //yyy
            // Actualizamos el indicador de entrega de mercadería de la entidad operacionReclamo
            // Hacemos un findByUK sobre la entidad operacionReclamo con los campos 
            // numeroOperacion y oidCabecera ambos de la lineaReclamo.
            // Actualizamos el campo INEM_OID_INDI_ENTR_MERC de la entidadObtenida 
            // con el valor ConstantesREC.IND_MERCADERIA_S y lo guardamos en la base.
            //OperacionReclamoLocalHome operacionReclamoLH = this.getOperacionReclamoLocalHome();
            //OperacionReclamoLocal operacionReclamoL = operacionReclamoLH.findByUK();
        
        
            MONCapturaProcesoReclamos monCapturaProcesoReclamos = this.getMONCapturaProcesoReclamos();
            
            DTOAtencionReclamoREC dtoAtencionReclamo = new DTOAtencionReclamoREC();
            dtoAtencionReclamo.setOidIdioma(new Long(dtoOid.getOidIdioma().longValue()));
            dtoAtencionReclamo.setOidPais(new Long(dtoOid.getOidPais().longValue()));
            dtoAtencionReclamo.setNumAtencion(numeroAtencion);
            try {
                UtilidadesLog.debug("Antes llamar a GenerarSolicitudes de MONCapturaProcesosReclamos");
                monCapturaProcesoReclamos.generarSolicitudes(dtoAtencionReclamo);
            } catch (RemoteException e) {
                String error = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                ctx.setRollbackOnly();
                throw new MareException(e, UtilidadesError.armarCodigoError(error));
            }
        }
        
		UtilidadesLog.info("MONRecibirProductos.generarSolicitud(ArrayList , DTOOID):Salida");
    }
}


    private MONGenerarMovimientoAlmacen getMONGenerarMovimientoAlmacen() throws MareException {
		
        
        MONGenerarMovimientoAlmacenHome home = 
                (MONGenerarMovimientoAlmacenHome) UtilidadesEJB.getHome("MONGenerarMovimientoAlmacen", MONGenerarMovimientoAlmacenHome.class);

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
    
    private MONCapturaProcesoReclamos getMONCapturaProcesoReclamos() throws MareException {
		        
        MONCapturaProcesoReclamosHome home = 
                (MONCapturaProcesoReclamosHome) UtilidadesEJB.getHome("MONCapturaProcesoReclamos", MONCapturaProcesoReclamosHome.class);

        MONCapturaProcesoReclamos ejb = null;                
        try {
            ejb = home.create();
        } catch (Exception e) {
            UtilidadesLog.error("*** Error en getMONCapturaProcesoReclamos", e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            ctx.setRollbackOnly();
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }
        
		        
        return ejb;
    }
    
}