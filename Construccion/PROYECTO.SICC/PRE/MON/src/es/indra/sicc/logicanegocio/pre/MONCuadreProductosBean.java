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
 *
 */
package es.indra.sicc.logicanegocio.pre;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.ped.DTOCabeceraSolicitud;
import es.indra.sicc.dtos.ped.DTOPosicionSolicitud;
import es.indra.sicc.dtos.pre.DTOAgregarProductoSolicitud;
import es.indra.sicc.dtos.pre.DTOBuscarCodigoVentaPeriodo;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesError;

import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;

import java.util.ArrayList;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.rmi.PortableRemoteObject;

/**
 * MON general del cuadre de productos dentro de las ofertas.
 *
 * @version 3.6 - 12 Sep 2005
 * @author Emilio Noziglia
 */
public class MONCuadreProductosBean implements SessionBean  {

    SessionContext ctx;
    
    public void ejbCreate() {
    }

    public void ejbActivate() {
    }

    public void ejbPassivate() {
    }

    public void ejbRemove() {
    }

    public void setSessionContext(SessionContext ctx) {
        this.ctx=ctx;
    }

   /**    
    * @autor jpbosnja
    * @modificado - 08/08/2005 - BELC300014487 - pperanzola
    */
    public DTOCabeceraSolicitud agregarProductos(DTOCabeceraSolicitud dtoCabeceraSolicitud, DTOAgregarProductoSolicitud dtoAgregarProductoSolicitud, DTOPosicionSolicitud dtoPosicionSolicitud) throws MareException {
        UtilidadesLog.info("MONCuadreProductosBean.agregarProductos(DTOCabeceraSolicitud dtoCabeceraSolicitud, DTOAgregarProductoSolicitud dtoAgregarProductoSolicitud, DTOPosicionSolicitud dtoPosicionSolicitud): Entrada");
        try{
            if (dtoPosicionSolicitud!=null){
                dtoPosicionSolicitud.setUnidadesPorAtender(new Long(dtoPosicionSolicitud.getUnidadesPorAtender().longValue()+
                                                           dtoAgregarProductoSolicitud.getUnidadesPorAtender().longValue()));
                dtoPosicionSolicitud.setUnidadesDemandaReal(new Long(dtoPosicionSolicitud.getUnidadesDemandaReal().longValue()+
                                                           dtoAgregarProductoSolicitud.getUnidadesPorAtender().longValue()));
                dtoPosicionSolicitud.setUnidadesModificadas(Boolean.TRUE);
                
                for (int i=0; i<dtoCabeceraSolicitud.getPosiciones().size();i++){
                    DTOPosicionSolicitud dtoPosi = (DTOPosicionSolicitud)dtoCabeceraSolicitud.getPosiciones().get(i);
                    if (dtoPosi.getNumeroPosicion().longValue()==dtoPosicionSolicitud.getNumeroPosicion().longValue()){
                        dtoCabeceraSolicitud.getPosiciones().set(i, dtoPosicionSolicitud);
                    }else{
                        //UtilidadesLog.debug("No se pudo agregar el producto, hay un error grave");
                    }
                }
            }else if (dtoPosicionSolicitud == null){
                 //UtilidadesLog.debug("dtoAgregarProductoSolicitud.getUnidadesPorAtender():"+dtoAgregarProductoSolicitud.getUnidadesPorAtender());
                //Cuando es un nuevo Producto de la misma oferta, 
                DTOPosicionSolicitud dtoPosicionSolicitudNew = new DTOPosicionSolicitud();
                dtoPosicionSolicitudNew.setTipoPosicion(dtoAgregarProductoSolicitud.getOidTipoPosicion());
                //dtoPosicionSolicitud.setNumeroPosicion(new Long(dtoCabeceraSolicitud.getPosiciones().size()));//+1
                dtoPosicionSolicitudNew.setNumeroPosicion(new Long(obtenerUltimaPosicion(dtoCabeceraSolicitud)+1));
                dtoPosicionSolicitudNew.setSubtipoPosicion(dtoAgregarProductoSolicitud.getOidSubtipoPosicion());
                dtoPosicionSolicitudNew.setCodigoVenta(dtoAgregarProductoSolicitud.getCodigoVenta());
                dtoPosicionSolicitudNew.setUnidadesDemandadas(new Long(0));
                dtoPosicionSolicitudNew.setUnidadesPorAtender(dtoAgregarProductoSolicitud.getUnidadesPorAtender());
                dtoPosicionSolicitudNew.setUnidadesDemandaReal(dtoAgregarProductoSolicitud.getUnidadesPorAtender());
                if (dtoCabeceraSolicitud.getIndCompletar()!=null && dtoCabeceraSolicitud.getIndCompletar().booleanValue()){
                    dtoPosicionSolicitudNew.setIndPosicionCompletada(Boolean.TRUE);
                    dtoPosicionSolicitudNew = completarPosicion(dtoCabeceraSolicitud, dtoPosicionSolicitudNew);
                }else{
                    dtoPosicionSolicitudNew.setIndPosicionCompletada(Boolean.FALSE);
                }
                
                dtoCabeceraSolicitud.getPosiciones().add(dtoPosicionSolicitudNew);
            }            
            
            UtilidadesLog.info("MONCuadreProductosBean.agregarProductos(DTOCabeceraSolicitud dtoCabeceraSolicitud, DTOAgregarProductoSolicitud dtoAgregarProductoSolicitud, DTOPosicionSolicitud dtoPosicionSolicitud): Salida");
            return dtoCabeceraSolicitud;          
        }catch (Exception e){
            if (e instanceof MareException){
                throw (MareException)e;
            }else{
                UtilidadesLog.error(e);
                ctx.setRollbackOnly();
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
        }
    }

   /**
    * @Autor: jpbosnja
    * @Recibe: DTOCabeceraSolicitud dtoCabeceraSolicitud
    * @Retorna: long 
    */  
    private long obtenerUltimaPosicion(DTOCabeceraSolicitud dtoCabeceraSolicitud) throws MareException{
        UtilidadesLog.info("MONCuadreProductosBean.obtenerUltimaPosicion(DTOCabeceraSolicitud dtoCabeceraSolicitud): Entrada");
        try{ 
            long maximo = 0;
            int posicion = 0;
            while (posicion < dtoCabeceraSolicitud.getPosiciones().size()){
                DTOPosicionSolicitud dtoP = (DTOPosicionSolicitud)dtoCabeceraSolicitud.getPosiciones().get(posicion);
                if (dtoP.getNumeroPosicion().longValue() > maximo){
                    maximo = dtoP.getNumeroPosicion().longValue();
                }
                posicion++;
            }            
            
            UtilidadesLog.info("MONCuadreProductosBean.obtenerUltimaPosicion(DTOCabeceraSolicitud dtoCabeceraSolicitud): Salida");
            return maximo;
        }catch (Exception e){
            if (e instanceof MareException){
                throw (MareException)e;
            }else{
                UtilidadesLog.error(e);
                ctx.setRollbackOnly();
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
        }
        
    }

   /**
    *@autor jpbosnja
    */
    private Long obtenerProductoMF(Long oidPeriodo, String cv) throws Exception{
        UtilidadesLog.info("MONCuadreProductosBean.obtenerProductoMF(Long oidPeriodo, String cv): Entrada");
        DTOBuscarCodigoVentaPeriodo dto = new DTOBuscarCodigoVentaPeriodo();
        dto.setPeriodo(oidPeriodo);
        dto.setCodigoVenta(cv);
        try{
            DTOSalida dtoS = this.buscarCodigoVentaPeriodo(dto);
            
            UtilidadesLog.info("MONCuadreProductosBean.obtenerProductoMF(Long oidPeriodo, String cv): Salida");
            return new Long (((BigDecimal)dtoS.getResultado().getValueAt(0,0)).longValue());
        }catch (Exception e){
            if (e instanceof MareException){
                throw (MareException)e;
            }else{
                UtilidadesLog.error(e);
                ctx.setRollbackOnly();
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
        }        
    }

   /**    
    *@autor jpbosnja
    */
    private DTOPosicionSolicitud completarPosicion(DTOCabeceraSolicitud dtoCabeceraSolicitud, DTOPosicionSolicitud dtoPosicionSolicitud) throws Exception{
        UtilidadesLog.info("MONCuadreProductosBean.completarPosicion(DTOCabeceraSolicitud dtoCabeceraSolicitud, DTOPosicionSolicitud dtoPosicionSolicitud): Entrada");
        try{
            /*Long oidDetalleOferta = obtenerProductoMF(dtoCabeceraSolicitud.getPeriodo(), dtoPosicionSolicitud.getCodigoVenta());
            UtilidadesLog.debug("oidDetalleOferta=" + oidDetalleOferta);
            RecordSet datosPosicion = this.obtenerDatosPosicionCuadre(oidDetalleOferta);*/
            RecordSet datosPosicion = this.buscarDatosProducto(dtoCabeceraSolicitud.getPeriodo(), dtoPosicionSolicitud.getCodigoVenta());
            
            //V_PRE_22 
            UtilidadesLog.debug("catalogo:"+datosPosicion.getValueAt(0,"CATALOGO")+" pagina:"+datosPosicion.getValueAt(0,"PAGINA"));
            dtoPosicionSolicitud.setCatalogo(BigToLong(datosPosicion.getValueAt(0,"CATALOGO")));//V_PRE22
            dtoPosicionSolicitud.setPagina(BigToInteger(datosPosicion.getValueAt(0,"PAGINA")));//V_PRE22 segundo error
            dtoPosicionSolicitud.setTipoEstrategia(BigToLong(datosPosicion.getValueAt(0,"TIPO_ESTRATEGIA")));//V_PRE22 tercer error
            
            dtoPosicionSolicitud.setProducto(BigToLong(datosPosicion.getValueAt(0,"OIDPROD")));
            dtoPosicionSolicitud.setFormaPago(BigToLong(datosPosicion.getValueAt(0,"OIDFORMAPAGO")));
            dtoPosicionSolicitud.setOidDetalleOferta(BigToLong(datosPosicion.getValueAt(0,"OID")));
            dtoPosicionSolicitud.setOidOferta(BigToLong(datosPosicion.getValueAt(0,"OID_OFERTA")));
            dtoPosicionSolicitud.setFactorRepeticion(BigToInteger(datosPosicion.getValueAt(0,"VAL_FACT_REPE")));
            Long monedaMF = BigToLong(datosPosicion.getValueAt(0,"MONE_OID_MONE"));
            
            /*
             * enozigli 22/07/2007 se agrega grupo y nro oferta req. para cuadre promos
             */
            dtoPosicionSolicitud.setGrupo(BigToInteger(datosPosicion.getValueAt(0,"NUM_GRUP")));
            dtoPosicionSolicitud.setNumeroOferta(BigToInteger(datosPosicion.getValueAt(0,"NUM_OFER")));
            /*
             * fin enozigli 22/07/2007 se agrega grupo y nro oferta req. para cuadre promos
             */

            Double tipoCambio = dtoCabeceraSolicitud.getTipoCambio();
            
            BigDecimal precioCatalogo = (BigDecimal)datosPosicion.getValueAt(0,"PRECIO_CATALOGO");
            
            if (precioCatalogo!= null 
                && precioCatalogo.doubleValue() >0){
                if (monedaMF!=null){
                    dtoPosicionSolicitud.setPrecioCatalogoUnitarioDocumento((BigDecimal)datosPosicion.getValueAt(0,"PRECIO_UNITARIO"));//Bloqueante V-PRE-18
                    dtoPosicionSolicitud.setPrecioContableUnitarioDocumento(new BigDecimal(0));
                    if (dtoPosicionSolicitud.getPrecioCatalogoUnitarioDocumento()!=null){
                        if (tipoCambio!=null){
                            dtoPosicionSolicitud.setPrecioCatalogoUnitarioLocal(dtoPosicionSolicitud.getPrecioCatalogoUnitarioDocumento().multiply(new BigDecimal(tipoCambio.doubleValue())));
                        }else{
                            dtoPosicionSolicitud.setPrecioCatalogoUnitarioLocal(dtoPosicionSolicitud.getPrecioCatalogoUnitarioDocumento());
                        }
                    }
                    dtoPosicionSolicitud.setPrecioContableUnitarioLocal(new BigDecimal(0));
                }else{
                    dtoPosicionSolicitud.setPrecioCatalogoUnitarioLocal((BigDecimal)datosPosicion.getValueAt(0,"PRECIO_UNITARIO"));//Bloqueante V-PRE-18
                    dtoPosicionSolicitud.setPrecioContableUnitarioLocal(new BigDecimal(0));
                }
            }else{
                if (monedaMF!=null){
                    dtoPosicionSolicitud.setPrecioCatalogoUnitarioDocumento(new BigDecimal(0));
                    dtoPosicionSolicitud.setPrecioContableUnitarioDocumento((BigDecimal)datosPosicion.getValueAt(0,"PRECIO_POSICIONAMIENTO"));
                    dtoPosicionSolicitud.setPrecioCatalogoUnitarioLocal(new BigDecimal(0));
                    if (dtoPosicionSolicitud.getPrecioContableUnitarioDocumento()!=null){
                        if (tipoCambio!=null){
                            dtoPosicionSolicitud.setPrecioContableUnitarioLocal(dtoPosicionSolicitud.getPrecioContableUnitarioDocumento().multiply(new BigDecimal(tipoCambio.doubleValue())));
                        }else{
                            dtoPosicionSolicitud.setPrecioContableUnitarioLocal(dtoPosicionSolicitud.getPrecioContableUnitarioDocumento());
                        }
                    }
                }else{
                    dtoPosicionSolicitud.setPrecioContableUnitarioLocal((BigDecimal)datosPosicion.getValueAt(0,"PRECIO_POSICIONAMIENTO"));//SiCC 20070069
                    dtoPosicionSolicitud.setPrecioCatalogoUnitarioLocal(new BigDecimal(0));
                } 
            }
            
            UtilidadesLog.info("MONCuadreProductosBean.completarPosicion(DTOCabeceraSolicitud dtoCabeceraSolicitud, DTOPosicionSolicitud dtoPosicionSolicitud): Salida");
            return dtoPosicionSolicitud;
        }catch (Exception e){
            if (e instanceof MareException){
                throw (MareException)e;
            }else{
                UtilidadesLog.error("ERROR",e);
                ctx.setRollbackOnly();
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
        }        
    }
    
    public void completarPosicion(DTOCabeceraSolicitud dtoCabeceraSolicitud) throws Exception{
        UtilidadesLog.info("MONCuadreProductosBean.completarPosicion(DTOCabeceraSolicitud dtoCabeceraSolicitud): Entrada");
        try{
            ArrayList pos = dtoCabeceraSolicitud.getPosiciones();
            boolean hayParaCompletar = false;
            StringBuffer cv  = new StringBuffer();
            for (int i = 0 ; i < pos.size() ; i++){
                DTOPosicionSolicitud p = (DTOPosicionSolicitud)pos.get(i);
                if (p.getIndPosicionCompletada()!=null && !p.getIndPosicionCompletada().booleanValue()){
                    hayParaCompletar = true;
                    cv.append("'").append(p.getCodigoVenta()).append("' ,");
                }
            }
            if (hayParaCompletar) {
                cv.deleteCharAt(cv.length()-1);
    
                RecordSet datosPosicion = this.buscarDatosProductos(dtoCabeceraSolicitud.getPeriodo(), cv.toString());
                
                for (int i = 0 ; i < datosPosicion.getRowCount() ; i++) {
                    String codigoVenta =  datosPosicion.getValueAt(i,"VAL_CODI_VENT").toString();
                    for (int x = 0 ; x < pos.size() ; x++ ){
                        DTOPosicionSolicitud p = (DTOPosicionSolicitud)pos.get(x);
                        if (p.getIndPosicionCompletada()!=null && !p.getIndPosicionCompletada().booleanValue() && p.getCodigoVenta().equals(codigoVenta)){
                            p.setCatalogo(BigToLong(datosPosicion.getValueAt(i,"CATALOGO")));//V_PRE22
                            p.setPagina(BigToInteger(datosPosicion.getValueAt(i,"PAGINA")));//V_PRE22 segundo error
                            p.setTipoEstrategia(BigToLong(datosPosicion.getValueAt(i,"TIPO_ESTRATEGIA")));//V_PRE22 tercer error
                            
                            p.setProducto(BigToLong(datosPosicion.getValueAt(i,"OIDPROD")));
                            p.setFormaPago(BigToLong(datosPosicion.getValueAt(i,"OIDFORMAPAGO")));
                            p.setOidDetalleOferta(BigToLong(datosPosicion.getValueAt(i,"OID")));
                            p.setOidOferta(BigToLong(datosPosicion.getValueAt(i,"OID_OFERTA")));
                            p.setFactorRepeticion(BigToInteger(datosPosicion.getValueAt(i,"VAL_FACT_REPE")));
                            Long monedaMF = BigToLong(datosPosicion.getValueAt(i,"MONE_OID_MONE"));
                
                            Double tipoCambio = dtoCabeceraSolicitud.getTipoCambio();
                            
                            BigDecimal precioCatalogo = (BigDecimal)datosPosicion.getValueAt(i,"PRECIO_CATALOGO");
                            
                            if (precioCatalogo!= null 
                                && precioCatalogo.doubleValue() >0){
                                if (monedaMF!=null){
                                    p.setPrecioCatalogoUnitarioDocumento((BigDecimal)datosPosicion.getValueAt(i,"PRECIO_UNITARIO"));//Bloqueante V-PRE-18
                                    p.setPrecioContableUnitarioDocumento(new BigDecimal(0));
                                    if (p.getPrecioCatalogoUnitarioDocumento()!=null){
                                        if (tipoCambio!=null){
                                            p.setPrecioCatalogoUnitarioLocal(p.getPrecioCatalogoUnitarioDocumento().multiply(new BigDecimal(tipoCambio.doubleValue())));
                                        }else{
                                            p.setPrecioCatalogoUnitarioLocal(p.getPrecioCatalogoUnitarioDocumento());
                                        }
                                    }
                                    p.setPrecioContableUnitarioLocal(new BigDecimal(0));
                                }else{
                                    p.setPrecioCatalogoUnitarioLocal((BigDecimal)datosPosicion.getValueAt(i,"PRECIO_UNITARIO"));//Bloqueante V-PRE-18
                                    p.setPrecioContableUnitarioLocal(new BigDecimal(0));
                                }
                            }else{
                                if (monedaMF!=null){
                                    p.setPrecioCatalogoUnitarioDocumento(new BigDecimal(0));
                                    p.setPrecioContableUnitarioDocumento((BigDecimal)datosPosicion.getValueAt(i,"PRECIO_POSICIONAMIENTO"));
                                    p.setPrecioCatalogoUnitarioLocal(new BigDecimal(0));
                                    if (p.getPrecioContableUnitarioDocumento()!=null){
                                        if (tipoCambio!=null){
                                            p.setPrecioContableUnitarioLocal(p.getPrecioContableUnitarioDocumento().multiply(new BigDecimal(tipoCambio.doubleValue())));
                                        }else{
                                            p.setPrecioContableUnitarioLocal(p.getPrecioContableUnitarioDocumento());
                                        }
                                    }
                                }else{
                                    p.setPrecioContableUnitarioLocal((BigDecimal)datosPosicion.getValueAt(i,"PRECIO_POSICIONAMIENTO"));//SiCC 20070069
                                    p.setPrecioCatalogoUnitarioLocal(new BigDecimal(0));
                                } 
                            }
                            p.setIndPosicionCompletada(Boolean.TRUE);
                            break;
                        }
                    }
                }
            } else {
                UtilidadesLog.debug("Las posiciones estaban completas previamente.");
            }
            

        }catch (Exception e){
            if (e instanceof MareException){
                throw (MareException)e;
            }else{
                UtilidadesLog.error("ERROR",e);
                ctx.setRollbackOnly();
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
        }        
    }

   /**
    * @autor jpbosnja
    * @modificado - 08/08/2005 - BELC300014487 - pperanzola
    **/
    public DTOCabeceraSolicitud eliminarProductos(DTOCabeceraSolicitud dtoe, Long posicion, Long unidadesEliminar) throws Exception{
        UtilidadesLog.info("MONCuadreProductosBean.eliminarProductos(DTOCabeceraSolicitud dtoe, Long posicion, Long unidadesEliminar): Entrada");
        
        int cantPos = dtoe.getPosiciones().size();

        for (int i=0;i<cantPos;i++){
            DTOPosicionSolicitud dtoP = (DTOPosicionSolicitud)dtoe.getPosiciones().get(i);
            //En el metodo activa el indicador de unidadesModificadas siempre.
            dtoP.setUnidadesModificadas(Boolean.TRUE);
            if (dtoP.getNumeroPosicion().longValue()==posicion.longValue()){
                //posicion = new Long(i);
                /*Esto lo agregue para que las unidades por atender no queden en negativo*/
                if ((dtoP.getUnidadesPorAtender().longValue()-unidadesEliminar.longValue())<0){
                    dtoP.setUnidadesPorAtender(new Long(0));
                }else{
                    dtoP.setUnidadesPorAtender(new Long(dtoP.getUnidadesPorAtender().longValue()-unidadesEliminar.longValue()));
                }
                if ((dtoP.getUnidadesDemandaReal().longValue()-unidadesEliminar.longValue())<0){
                    dtoP.setUnidadesDemandaReal(new Long(0));
                }else{
                    dtoP.setUnidadesDemandaReal(new Long(dtoP.getUnidadesDemandaReal().longValue()-unidadesEliminar.longValue()));
                }
                break;
            }
        }        

        UtilidadesLog.info("MONCuadreProductosBean.eliminarProductos(DTOCabeceraSolicitud dtoe, Long posicion, Long unidadesEliminar): Salida");
        return dtoe;
    }
    
    private RecordSet buscarDatosProducto(Long oidPeriodo, String cv) throws MareException {
        UtilidadesLog.info("MONCuadreProductos.buscarDatosProducto(DTOBuscarCodigoVentaPeriodo dto): Entrada");
        
        BelcorpService belcorpService;
        RecordSet rs;

        /*
         * enozigli 22/02/2007 se modifica la query para que traiga grupo y 
         * nro de oferta necesarios para el proceso de cuadre de promociones         
         */
        StringBuffer query = new StringBuffer();
        query.append(" SELECT d.oid_deta_ofer OID, d.ocat_oid_catal catalogo, d.num_pagi_cata pagina, ");
        query.append(" d.prod_oid_prod oidprod, d.fopa_oid_form_pago oidformapago, ");
        query.append(" d.val_fact_repe, d.imp_prec_cata precio_catalogo, d.precio_unitario, ");
        query.append(" d.imp_prec_posi precio_posicionamiento, ");
        query.append(" estra.ties_oid_tipo_estr tipo_estrategia, d.ofer_oid_ofer oid_oferta, ");
        query.append(" p.mone_oid_mone, o.NUM_OFER, g.NUM_GRUP ");
        query.append(" FROM pre_ofert_detal d, ");
        query.append(" pre_matri_factu_cabec p, ");
        query.append(" pre_ofert o, ");
        query.append(" pre_estra estra, ");
        query.append(" pre_grupo_ofert g ");
        query.append(" WHERE d.ofer_oid_ofer = o.oid_ofer ");
        query.append(" AND p.oid_cabe = o.mfca_oid_cabe ");
        query.append(" AND p.perd_oid_peri = "+oidPeriodo);
        query.append(" AND d.val_codi_vent = '"+cv+"'");
        query.append(" AND d.ofer_oid_ofer = o.oid_ofer ");
        query.append(" AND o.coes_oid_estr = estra.oid_estr ");
        query.append(" and g.OID_GRUP_OFER(+) = d.GOFE_OID_GRUP_OFER ");
           
        
        try {
            belcorpService = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
            UtilidadesLog.error(serviceNotFoundException);
            throw new MareException(serviceNotFoundException, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            rs = belcorpService.dbService.executeStaticQuery(query.toString());
        } catch (Exception exception) {
            UtilidadesLog.error("ERROR",exception);
            throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("MONCuadreProductos.buscarDatosProducto(DTOBuscarCodigoVentaPeriodo dto): Salida");
        return rs;
    }
    
    private RecordSet buscarDatosProductos(Long oidPeriodo, String cv) throws MareException {
        UtilidadesLog.info("MONCuadreProductos.buscarDatosProducto(DTOBuscarCodigoVentaPeriodo dto): Entrada");
        
        BelcorpService belcorpService;
        RecordSet rs;

        StringBuffer query = new StringBuffer();
        query.append(" SELECT d.oid_deta_ofer OID, d.ocat_oid_catal catalogo, d.num_pagi_cata pagina, ");
        query.append(" d.prod_oid_prod oidprod, d.fopa_oid_form_pago oidformapago, ");
        query.append(" d.val_fact_repe, d.imp_prec_cata precio_catalogo, d.precio_unitario, ");
        query.append(" d.imp_prec_posi precio_posicionamiento, ");
        query.append(" estra.ties_oid_tipo_estr tipo_estrategia, d.ofer_oid_ofer oid_oferta, ");
        query.append(" p.mone_oid_mone, d.VAL_CODI_VENT ");
        query.append(" FROM pre_ofert_detal d, ");
        query.append(" pre_matri_factu_cabec p, ");
        query.append(" pre_ofert o, ");
        query.append(" pre_estra estra ");
        query.append(" WHERE d.ofer_oid_ofer = o.oid_ofer ");
        query.append(" AND p.oid_cabe = o.mfca_oid_cabe ");
        query.append(" AND p.perd_oid_peri = "+oidPeriodo);
        query.append(" AND d.val_codi_vent in ( ");
        query.append(cv);
        query.append(" ) ");
        query.append(" AND o.coes_oid_estr = estra.oid_estr ");
        
        try {
            belcorpService = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
            UtilidadesLog.error(serviceNotFoundException);
            throw new MareException(serviceNotFoundException, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            rs = belcorpService.dbService.executeStaticQuery(query.toString());
        } catch (Exception exception) {
            UtilidadesLog.error("ERROR",exception);
            throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("MONCuadreProductos.buscarDatosProducto(DTOBuscarCodigoVentaPeriodo dto): Salida");
        return rs;
    }
    
    
    private DTOSalida buscarCodigoVentaPeriodo(DTOBuscarCodigoVentaPeriodo dto) throws MareException {
        UtilidadesLog.info("MONCuadreProductos.buscarCodigoVentaPeriodo(DTOBuscarCodigoVentaPeriodo dto): Entrada");
        
        String codigoVenta = dto.getCodigoVenta();
        /*Long catalogo = dto.getCatalogo();
        Integer paginaDesde = dto.getIndicadorSituacion();
        Integer paginaHasta = dto.getTamanioPagina();*/
        BelcorpService belcorpService;
        RecordSet rs;

        StringBuffer query = new StringBuffer();
        query.append(" SELECT d.oid_deta_ofer OID ");
        query.append(" FROM pre_ofert_detal d, pre_matri_factu_cabec p, pre_ofert o ");
        query.append(" WHERE d.ofer_oid_ofer = o.oid_ofer AND p.oid_cabe = o.mfca_oid_cabe ");
        query.append(" AND p.PERD_OID_PERI = "+dto.getPeriodo());
        if ((codigoVenta != null) && (codigoVenta.length() > 0)) {
            query.append(" AND D.VAL_CODI_VENT = '" + codigoVenta + "'");
        }

        /*if (catalogo != null) {
            query.append(" AND D.OCAT_OID_CATAL = " + catalogo.toString());
        }

        if (dto.getPaginaDesde() != null) {
            query.append(" AND D.VAL_POSI_PAGI >= " + dto.getPaginaDesde().toString());
        }

        if (dto.getPaginaHasta() != null) {
            query.append(" AND d.VAL_POSI_PAGI <= " + dto.getPaginaHasta().toString());
        }*/
        
        try {
            belcorpService = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
            UtilidadesLog.error(serviceNotFoundException);
            throw new MareException(serviceNotFoundException, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            rs = belcorpService.dbService.executeStaticQuery(query.toString());
        } catch (Exception exception) {
            UtilidadesLog.error(exception);
            throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        DTOSalida dtos = new DTOSalida();
        dtos.setResultado(rs);

        if ((rs == null) || rs.esVacio()) {
            //UtilidadesLog.debug("Tirando mare exception");
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        
        UtilidadesLog.info("MONCuadreProductos.buscarCodigoVentaPeriodo(DTOBuscarCodigoVentaPeriodo dto): Salida");
        return dtos;
    }

    private MONMantenimientoMFHome getMONMantenimientoMFHome() throws NamingException {
        final InitialContext context = new InitialContext();
        return (MONMantenimientoMFHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONMantenimientoMF"), MONMantenimientoMFHome.class);
    }
    
 /**
  * @Autor: Emilio Noziglia
  * @Fecha : 05/12/2006
  * @Recibe: Long oidDetalleOferta
  * @Retorna: RecordSet 
  * @Descripción: obtiene los datos de la posicion requeridos para el cuadre.
  */ 
   public RecordSet obtenerDatosPosicionCuadre(Long oidDetalleOferta) throws MareException {
      UtilidadesLog.info("MONCuadreProductos.obtenerDatosPosicionCuadre(Long oidDetalleOferta): Entrada");

      BelcorpService belcorpService = BelcorpService.getInstance();
      RecordSet rs = null;
      StringBuffer query = new StringBuffer();

      query.append(" SELECT OD.OCAT_OID_CATAL CATALOGO, OD.NUM_PAGI_CATA PAGINA, OD.PROD_OID_PROD OIDPROD, ");
      query.append(" OD.FOPA_OID_FORM_PAGO OIDFORMAPAGO, OD.OID_DETA_OFER, OD.VAL_FACT_REPE, ");
      query.append(" OD.IMP_PREC_CATA PRECIO_CATALOGO, OD.PRECIO_UNITARIO, OD.IMP_PREC_POSI PRECIO_POSICIONAMIENTO, ");
      query.append(" ESTRA.TIES_OID_TIPO_ESTR TIPO_ESTRATEGIA, OD.OFER_OID_OFER OID_OFERTA ");
      query.append(" FROM PRE_OFERT_DETAL OD, PRE_OFERT OFE, PRE_ESTRA ESTRA ");
      query.append(" WHERE OD.OFER_OID_OFER = OFE.OID_OFER ");
      query.append(" AND OFE.COES_OID_ESTR = ESTRA.OID_ESTR ");
      query.append(" AND OD.OID_DETA_OFER = "+oidDetalleOferta);

      try {
            rs = belcorpService.dbService.executeStaticQuery(query.toString());
      } catch (MareMiiServiceNotFoundException serviceNotFoundException) {            
            UtilidadesLog.error(serviceNotFoundException);
            throw new MareException(serviceNotFoundException, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
      } catch (Exception exception) {            
            UtilidadesLog.error(exception);
            throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
      }
            
      UtilidadesLog.info("MONCuadreProductos.obtenerDatosPosicionCuadre(Long oidDetalleOferta): Salida");
      return rs;
   }
   
    private Integer BigToInteger(Object num) {
        UtilidadesLog.info("MONCuadreProductos.BigToInteger(Object num): Entrada");
        if (num != null) {
            UtilidadesLog.info("MONCuadreProductos.BigToInteger(Object num): Salida");
            return (new Integer(((BigDecimal) num).intValue()));
        } else {
            UtilidadesLog.info("MONCuadreProductos.BigToInteger(Object num): Salida");
            return null;
        }        
    }

    private Long BigToLong(Object num) {
        UtilidadesLog.info("MONCuadreProductos.BigToLong(Object num): Entrada");
        if (num != null) {
            UtilidadesLog.info("MONCuadreProductos.BigToLong(Object num): Salida");
            return (new Long(((BigDecimal) num).longValue()));
        } else {
            UtilidadesLog.info("MONCuadreProductos.BigToLong(Object num): Salida");
            return null;
        }
    }   
}