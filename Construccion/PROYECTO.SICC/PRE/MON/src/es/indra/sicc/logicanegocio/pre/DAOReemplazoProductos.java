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
import es.indra.sicc.dtos.ped.DTOTipifYUnidadAdminCliente;
import es.indra.sicc.dtos.ped.DTOTipificacion;
import es.indra.sicc.dtos.pre.DTOProductoReemplazo;
import es.indra.sicc.dtos.zon.DTOUnidadAdministrativa;
import es.indra.sicc.logicanegocio.ped.DAOSolicitud;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.RecuperadorIdiomaDefectoServidor;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Vector;
import javax.ejb.SessionContext;


/**
 * 
 * @date 03/08/06
 * @author pperanzola
 */
public class DAOReemplazoProductos 
{
    private SessionContext ctx;
    public DAOReemplazoProductos()
    {
    }
    public DAOReemplazoProductos(SessionContext context) {
        this.ctx = context;
    }
        /**
     * @date 03/08/06
     * @throws java.lang.Exception
     * @return 
     * @param indAntesCuadre
     * @param tipoCambio
     * @param monedaMF
     * @param dtoe
     * @author ppperanzola
     */
    public DTOCabeceraSolicitud reemplazarProductosSolicitud(DTOCabeceraSolicitud dtoe
                                                                , Long monedaMF
                                                                , BigDecimal tipoCambio
                                                                , Boolean indAntesCuadre
                                                                , DTOProductoReemplazo[] dtoProductoReemplazoSalida) throws Exception{
        UtilidadesLog.info("DAOReemplazoProductos.reemplazarProductosSolicitud(DTOCabeceraSolicitud dtoe, Long monedaMF, BigDecimal tipoCambio, Boolean indAntesCuadre): Entrada");
        //ArrayList posicionesSolicitud = dtoe.getPosiciones();
        ArrayList posicionesMensaje = new ArrayList();
        ArrayList posicionesReemplazo = new ArrayList();
        Vector vectorMensajes;
        //int posicion=0;
        int cantPos = dtoe.getPosiciones().size();
        //posicion = 0; si no inicializo el contador en el for de mas abajo
        //es probable que me saltee posiciones que deberia reemplazar (SiCC-20070133 gacevedo 19/03/07)
        int cantProdReemp;
        //UtilidadesLog.debug("dtoProductoReemplazoSalida = " + dtoProductoReemplazoSalida);
        if (dtoProductoReemplazoSalida != null && dtoProductoReemplazoSalida.length >0 ){
            cantProdReemp = dtoProductoReemplazoSalida.length;
            //UtilidadesLog.debug("cantProdReemp = " + cantProdReemp);
            for (int i = 0 ; i < cantProdReemp ; i++){
                DTOProductoReemplazo dtoPR = dtoProductoReemplazoSalida[i];
                if ( dtoPR != null && dtoPR.getIndAntesCuadre().equals(indAntesCuadre)){
                    for (int posicion=0;posicion<cantPos;posicion++){
                        DTOPosicionSolicitud dtoP = (DTOPosicionSolicitud)dtoe.getPosiciones().get(posicion);
    
                        if (dtoPR.getCvPrincipal().equals(dtoP.getCodigoVenta())){
                            String cvOriginal = dtoP.getCodigoVenta();
                            dtoP = reemplazarProducto(dtoP, dtoPR, monedaMF, tipoCambio);
                            posicionesReemplazo.add(dtoP);
                               
                           if (dtoe.getIndPedidoPrueba() == null || dtoe.getIndPedidoPrueba().equals(Boolean.TRUE)){ // graba si NO es simulacion de cuadre
                               if (dtoPR.getIndMensaje()!=null && dtoPR.getIndMensaje().equals(Boolean.TRUE)){//que es el reemplazo de ConstantesPRE.SI
                                   vectorMensajes = new Vector();
                                   vectorMensajes.add(0,dtoP);
                                   vectorMensajes.add (1,cvOriginal);
                                   posicionesMensaje.add(vectorMensajes);
                               }
                           }
                           //posicionesSolicitud.set(posicion, dtoP);
                        }
                    }
                }
            }
            this.generarMensaje(posicionesMensaje,dtoe.getOidCliente(),dtoe.getOidPais(), dtoe.getOidCabeceraSolicitud());
            //dtoe.setPosiciones(posicionesSolicitud);
        
        }
        
        if(posicionesReemplazo.size() > 0)
            dtoe.getPosiciones().addAll(posicionesReemplazo);
        
        UtilidadesLog.info("DAOReemplazoProductos.reemplazarProductosSolicitud(DTOCabeceraSolicitud dtoe, Long monedaMF, BigDecimal tipoCambio, Boolean indAntesCuadre): Salida");
        return dtoe;
        
    }
    
    /**
     * 
     * @date 
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * @param oidPeriodo
     * @param posiciciones
     */
    public DTOProductoReemplazo[] obtenerProductoReemplazo(ArrayList posiciciones, Long oidPeriodo, Long oidSoliCabe ) throws MareException {
        UtilidadesLog.info("DAOReemplazoProductos.obtenerProductoReemplazo(DTOProductoReemplazo dtoe): Entrada");
        BelcorpService bs = null;
        int cantPosiciones = posiciciones.size();
        DTOProductoReemplazo[] dto = null;
        DAOSolicitud daoSoli = new DAOSolicitud();
        
        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            if (cantPosiciones>0)   {
                //enozigli 13/02/09 cambio por solic. PRE-013 1
                DTOTipifYUnidadAdminCliente dtoTipifYUa = daoSoli.obetenerTipifyUAClienSoli(oidSoliCabe);
                //fin enozigli 13/02/09 cambio por solic. PRE-013 1
            
                StringBuffer query = new StringBuffer(" SELECT dto2.val_codi_vent cv_reemplazo, dto2.VAL_FACT_REPE, ");
                query.append(" ind_reem_ante_cuad ind_antes_cuadre, ind_mens ind_mensaje, ");
                // Modificado por SICC20070315 - Rafael Romero - 02/08/2007
                query.append(" dto2.precio_unitario precio_catalogo, ");
                query.append(" dto2.IMP_PREC_POSI precio_posicionamiento, ");
                query.append(" dto2.OID_DETA_OFER, dto2.PROD_OID_PROD, dto1.val_codi_vent cv_principal ");
                // Fin modificado SICC20070315
                /*
                 * enozigli 23/03/2007
                 * se agrega oidOferta y tipoEstrategia por pedido de cambio relacionado con SICC 20070157 
                 * no estaba contemplado en el DECU este campo
                 */            
                query.append(" , dto2.OFER_OID_OFER, est.TIES_OID_TIPO_ESTR ");
                query.append(" , ma.TICL_OID_TIPO_CLIE, ma.SBTI_OID_SUBTI_CLIEN, ma.TCCL_OID_TIPO_CLAS, ma.CLAS_OID_CLAS, ma.ZORG_OID_REGI, ma.ZZON_OID_ZONA ");
                query.append(" , DTO2.FOPA_OID_FORM_PAGO ");
                
                // sapaza -- PER-SiCC-2014-0580 -- 05/11/2014
                query.append(" , DTO2.OCAT_OID_CATAL ");
                
                // sapaza -- PER-SiCC-2014-0580 -- 10/11/2014
                query.append(" , DTO2.NUM_PAGI_CATA ");
                
                query.append(" FROM ");
                query.append(" pre_matri_reemp ma, pre_matri_factu mf1, pre_ofert_detal dto1, pre_matri_factu mf2, ");
                query.append(" pre_ofert_detal dto2, pre_matri_factu_cabec cmf, pre_ofert ofe, pre_estra est  ");
                query.append(" WHERE  ");
                for (int x = 0 ; x < cantPosiciones ; x++){
                    if (x == 0){
                        query.append(" dto1.val_codi_vent in ( ");
                    }
                    if (x == (cantPosiciones-1) ){
                        query.append(" '" +  ((DTOPosicionSolicitud)posiciciones.get(x)).getCodigoVenta() + "' ) ");
                    }else{
                        query.append(" '" + ((DTOPosicionSolicitud)posiciciones.get(x)).getCodigoVenta() + "' ,");
                    }
                }
                query.append(" AND cmf.perd_oid_peri = " + oidPeriodo);
                query.append(" AND cmf.oid_cabe = mf1.mfca_oid_cabe");
                query.append(" AND dto1.OID_DETA_OFER = mf1.OFDE_OID_DETA_OFER ");
                query.append(" AND ma.mafa_oid_cod_ppal = mf1.oid_matr_fact");
                query.append(" AND dto2.oid_deta_ofer = mf2.ofde_oid_deta_ofer");
                query.append(" AND cmf.oid_cabe = mf2.mfca_oid_cabe");
                query.append(" AND ma.mafa_oid_cod_reem = mf2.oid_matr_fact ");
                query.append(" AND dto2.OFER_OID_OFER = ofe.OID_OFER ");
                query.append(" AND ofe.COES_OID_ESTR = est.OID_ESTR ");
                
                //sapaza -- PER-SiCC-2010-0497 -- 17/08/2010
                query.append(" AND ma.ind_acti = 1 ");
    
                UtilidadesLog.debug("QUERY:"+query.toString());
                RecordSet r = bs.dbService.executeStaticQuery(query.toString());
    
                if (r.esVacio()) {
                    UtilidadesLog.info("DAOReemplazoProductos.obtenerProductoReemplazo(DTOProductoReemplazo dtoe): Salida (NO ENCONTRO REEMPLAZOS)");
                    return null;
                }
                
                //filtrado de Reemplazos que no correspondan al cliente en cuestion dada su tipificacion y unidad administrativa
                
                UtilidadesLog.info("DAOReemplazoProductos.obtenerProductoReemplazo - comienza filtrado.");
                ArrayList posicOK = new ArrayList();
                for (int i = 0 ; i< r.getRowCount() ; i++){               
                    
                    Long oidTiCliR = bigDecimalToLong(r.getValueAt(i, "TICL_OID_TIPO_CLIE"));
                    Long oidSbtCliR = bigDecimalToLong(r.getValueAt(i, "SBTI_OID_SUBTI_CLIEN"));
                    Long oidTClasR = bigDecimalToLong(r.getValueAt(i, "TCCL_OID_TIPO_CLAS"));
                    Long oidClasR = bigDecimalToLong(r.getValueAt(i, "CLAS_OID_CLAS"));                    
                    Long oidRegR = bigDecimalToLong(r.getValueAt(i, "ZORG_OID_REGI"));
                    Long oidZonR = bigDecimalToLong(r.getValueAt(i, "ZZON_OID_ZONA"));                    
                    
                    boolean tipifOK= false;
                    ArrayList tipificaciones = dtoTipifYUa.getTipificaciones();                     
                    
                    //validamos tipificaciones si cumple con alguna de es OK
                    for (int j=0; j<tipificaciones.size(); j++)  {
                    
                        DTOTipificacion dtoTipif = (DTOTipificacion)tipificaciones.get(j);                        
                        Long oidTiCli = dtoTipif.getOidTipoCliente();
                        Long oidSbtCli = dtoTipif.getOidSubtipoCliente();
                        Long oidTClas = dtoTipif.getOidTipoClasificacion();                        
                        Long oidClas = dtoTipif.getOidClasificacion();                                               
                        
                        UtilidadesLog.debug("validando la tipificacion");
                        if (oidTiCliR == null) {
                            //Remplazo sin tipificacion definida, va siempre
                            tipifOK = true;
                        } else if (oidTiCliR.equals(oidTiCli)) {
                                if (oidSbtCliR == null) {                                    
                                    tipifOK = true;
                                } else if (oidSbtCliR.equals(oidSbtCli)) {
                                    if (oidTClasR == null) {                                    
                                        tipifOK = true;
                                    } else if (oidTClasR.equals(oidTClas)) {
                                        if (oidClasR == null) {                                    
                                            tipifOK = true;
                                        } else if (oidClasR.equals(oidClas)) {
                                            tipifOK = true;
                                        }
                                    }
                                }
                        }
                    }//for tipif
                    
                    boolean uniAdmOK = false;
                    ArrayList unidAdm = dtoTipifYUa.getUnidadesAdmin();
                    
                    if (tipifOK)  { //continuo validando la unidad administrativa, si cumple con alguna es OK
                        UtilidadesLog.debug("continuo validando la unidades administrativas");
                        for (int j=0; j<unidAdm.size(); j++)  {
                                DTOUnidadAdministrativa dtoUA = (DTOUnidadAdministrativa)unidAdm.get(j);                        
                                Long oidZon = dtoUA.getOidZona();
                                Long oidReg = dtoUA.getOidRegion();
                                                                
                                if (oidRegR == null) {
                                    //Remplazo sin ua definida
                                    uniAdmOK = true;
                                } else if (oidRegR.equals(oidReg)) {
                                        if (oidZonR == null) {                                    
                                            uniAdmOK = true;
                                        } else if (oidZonR.equals(oidZon)) {                                            
                                            uniAdmOK = true;
                                        }
                                }                                
                        }//for unidad admin
                    }//if tipifOK
                    
                    if (uniAdmOK)  {
                        //posible reemplazo, solo falta validar si se repite                            
                        posicOK.add(new Integer(i));
                    }                    
                }//for recordset
                            
                //filtro los repetidos
                UtilidadesLog.debug("filtro los repetidos");
                ArrayList posicOKFinal = new ArrayList();
                ArrayList codVentOK = new ArrayList();
                
                for (int i = 0 ; i< posicOK.size() ; i++){
                    String cvPpal = (String) r.getValueAt(((Integer)posicOK.get(i)).intValue(), "CV_PRINCIPAL");
                    if (i==0)  {
                        codVentOK.add(cvPpal);
                        posicOKFinal.add(posicOK.get(i));
                    } else {
                        if (!codVentOK.contains(cvPpal)) {
                            codVentOK.add(cvPpal);
                            posicOKFinal.add(posicOK.get(i));
                        }
                    }                    
                }
                
                                
                UtilidadesLog.info("DAOReemplazoProductos.obtenerProductoReemplazo - finaliza filtrado.");                
                //FIN filtrado de Reemplazos que no correspondan al cliente en cuestion dada su tipificacion y unidad administrativa
                
                dto = new DTOProductoReemplazo[posicOKFinal.size()];
                for (int j = 0 ; j< posicOKFinal.size() ; j++){
                    int i = ((Integer)posicOKFinal.get(j)).intValue();
                    dto[j] = new DTOProductoReemplazo();
                    dto[j].setCvReemplazo((String) r.getValueAt(i, "CV_REEMPLAZO"));
                    dto[j].setCvPrincipal((String) r.getValueAt(i, "CV_PRINCIPAL"));
        
                    if (r.getValueAt(i, "IND_ANTES_CUADRE") != null) {
                        if (((BigDecimal) r.getValueAt(i, "IND_ANTES_CUADRE")).longValue() == 1) {
                            dto[j].setIndAntesCuadre(Boolean.TRUE);
                        } else {
                            dto[j].setIndAntesCuadre(Boolean.FALSE);
                        }
                    }
        
                    if (r.getValueAt(i, "IND_MENSAJE") != null) {
                        if (((BigDecimal) r.getValueAt(i, "IND_MENSAJE")).longValue() == 1) {
                            dto[j].setIndMensaje(Boolean.TRUE);
                        } else {
                            dto[j].setIndMensaje(Boolean.FALSE);
                        }
                    }
        
                    dto[j].setPrecioCatalogoReemplazo((BigDecimal) r.getValueAt(i, "PRECIO_CATALOGO"));
                    
                    // Agregado por SICC20070315 - Rafael Romero - 02/08/2007
                    dto[j].setPrecioPosicionamiento((BigDecimal) r.getValueAt(i, "PRECIO_POSICIONAMIENTO"));
                    // Fin agregado SICC20070315
        
                    if (r.getValueAt(i, "PROD_OID_PROD") != null) {
                        Long tmpOidProd = null;
                        tmpOidProd = new Long(((BigDecimal) r.getValueAt(i, "PROD_OID_PROD")).longValue());
                        dto[j].setOidProducto(tmpOidProd);
                    }
                    
                    if (r.getValueAt(i, "FOPA_OID_FORM_PAGO") != null) {
                        Long tmpOidFP = null;
                        tmpOidFP = new Long(((BigDecimal) r.getValueAt(i, "FOPA_OID_FORM_PAGO")).longValue());
                        dto[j].setFormaPago(tmpOidFP);
                    }                    
        
                    if (r.getValueAt(i, "OID_DETA_OFER") != null) {
                        Long tmpOidOfer = null;
                        tmpOidOfer = new Long(((BigDecimal) r.getValueAt(i, "OID_DETA_OFER")).longValue());
                        dto[j].setOidDetalleOferta(tmpOidOfer);
                    }
                    
                    if (r.getValueAt(i, "VAL_FACT_REPE") != null) {
                        dto[j].setFactorCuadre(new Integer(r.getValueAt(i, "VAL_FACT_REPE").toString()));
                    }
    
                    /*
                     * enozigli 23/03/2007
                     * se agrega oidOferta y tipoEstrategia por pedido de cambio relacionado con SICC 20070157 
                     * no estaba contemplado en el DECU este campo
                     */
                    if (r.getValueAt(i, "OFER_OID_OFER") != null) {
                        Long tmpOidOfer = null;
                        tmpOidOfer = new Long(((BigDecimal) r.getValueAt(i, "OFER_OID_OFER")).longValue());
                        dto[j].setOidOferta(tmpOidOfer);
                    }           
                    
                    if (r.getValueAt(i, "TIES_OID_TIPO_ESTR") != null) {
                        Long tmpOidTipoEstra = null;
                        tmpOidTipoEstra = new Long(((BigDecimal) r.getValueAt(i, "TIES_OID_TIPO_ESTR")).longValue());
                        dto[j].setTipoEstrategia(tmpOidTipoEstra);
                    }  
                    
                    // sapaza -- PER-SiCC-2014-0580 -- 05/11/2014
                    if (r.getValueAt(i, "OCAT_OID_CATAL") != null) {
                        Long tmpOidCatalogo = null;
                        tmpOidCatalogo = new Long(((BigDecimal) r.getValueAt(i, "OCAT_OID_CATAL")).longValue());
                        dto[j].setCatalogo(tmpOidCatalogo);
                    } 
                    
                    // sapaza -- PER-SiCC-2014-0580 -- 05/11/2014
                    if (r.getValueAt(i, "NUM_PAGI_CATA") != null) {
                        Integer tmpOidPagina = null;
                        tmpOidPagina = new Integer(((BigDecimal) r.getValueAt(i, "NUM_PAGI_CATA")).intValue());
                        dto[j].setPagina(tmpOidPagina);
                    }
                    
                }
    
                UtilidadesLog.info("DAOReemplazoProductos.obtenerProductoReemplazo(DTOProductoReemplazo dtoe): Salida");
                return dto;
            }
            else    {
                UtilidadesLog.error("No hay posiciones en la solicitud.");
                return null;
            }
        } catch (Exception e) {
            UtilidadesLog.error("ERROR",e);
            UtilidadesLog.error(e.getMessage());
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
    }
    
    private Long bigDecimalToLong(Object numero) {    
      if (numero != null) {
        return new Long(((BigDecimal) numero).longValue());
      } else {
        return null;
      }
    }
    
    /**
     * 06/09/2011   Modificado por Sapaza, por el RCR PER-SiCC-2011-0615 Modificar la indicación de 
     *              reemplazos en el detalle de factura
     * 
     * @date 
     * @throws java.lang.Exception
     * @return 
     * @param tipoCambio
     * @param monedaMF
     * @param dtoProductoReemplazo
     * @param dtoPosicionSolicitud
     */
    private DTOPosicionSolicitud reemplazarProducto(DTOPosicionSolicitud dtoPosicionSolicitud
                                                    , DTOProductoReemplazo dtoProductoReemplazo
                                                    , Long monedaMF
                                                    , BigDecimal tipoCambio) throws Exception{
        UtilidadesLog.info("DAOReemplazoProductos.reemplazarProducto(DTOPosicionSolicitud dtoPosicionSolicitud, DTOProductoReemplazo dtoProductoReemplazo, Long monedaMF, BigDecimal tipoCambio): Entrada");
        DTOPosicionSolicitud dtoPosicionSolicitudAux = (DTOPosicionSolicitud)dtoPosicionSolicitud.clone();
        dtoPosicionSolicitudAux.setCodigoVenta(dtoProductoReemplazo.getCvReemplazo());
        dtoPosicionSolicitudAux.setOidDetalleOferta(dtoProductoReemplazo.getOidDetalleOferta());
        dtoPosicionSolicitudAux.setProductoReemplazado(Boolean.TRUE);
        dtoPosicionSolicitudAux.setOidProducto(dtoProductoReemplazo.getOidProducto());
        dtoPosicionSolicitudAux.setProducto(dtoProductoReemplazo.getOidProducto());
        dtoPosicionSolicitudAux.setFactorRepeticion(dtoProductoReemplazo.getFactorCuadre());
        /*
         * enozigli 23/03/2007
         * se agrega oidOferta y tipoEstrategia por pedido de cambio relacionado con SICC 20070157 
         * no estaba contemplado en el DECU este campo
         */
        dtoPosicionSolicitudAux.setOidOferta(dtoProductoReemplazo.getOidOferta());
        dtoPosicionSolicitudAux.setTipoEstrategia(dtoProductoReemplazo.getTipoEstrategia());
        
        dtoPosicionSolicitudAux.setFormaPago(dtoProductoReemplazo.getFormaPago());
        
        // sapaza -- PER-SiCC-2014-0580 -- 05/11/2014
        dtoPosicionSolicitudAux.setCatalogo(dtoProductoReemplazo.getCatalogo());
        
        // sapaza -- PER-SiCC-2014-0580 -- 10/11/2014
        dtoPosicionSolicitudAux.setPagina(dtoProductoReemplazo.getPagina());
        
        // Modificado por SICC20070315 - Rafael Romero - 01/08/2007
        if(dtoProductoReemplazo.getPrecioCatalogoReemplazo()!=null && dtoProductoReemplazo.getPrecioCatalogoReemplazo().doubleValue()>0){
            if (monedaMF==null){
                dtoPosicionSolicitudAux.setPrecioCatalogoUnitarioLocal(dtoProductoReemplazo.getPrecioCatalogoReemplazo());    
                dtoPosicionSolicitudAux.setPrecioCatalogoUnitarioDocumento(new BigDecimal(0));
                dtoPosicionSolicitudAux.setPrecioContableUnitarioLocal(new BigDecimal(0));
                dtoPosicionSolicitudAux.setPrecioContableUnitarioDocumento(new BigDecimal(0));
            }else{
                dtoPosicionSolicitudAux.setPrecioCatalogoUnitarioLocal(tipoCambio.multiply(dtoProductoReemplazo.getPrecioCatalogoReemplazo()));
                dtoPosicionSolicitudAux.setPrecioCatalogoUnitarioDocumento(dtoProductoReemplazo.getPrecioCatalogoReemplazo());
                dtoPosicionSolicitudAux.setPrecioContableUnitarioLocal(new BigDecimal(0));
                dtoPosicionSolicitudAux.setPrecioContableUnitarioDocumento(new BigDecimal(0));
            }
        }else{
            if (monedaMF==null){
                dtoPosicionSolicitudAux.setPrecioCatalogoUnitarioLocal(new BigDecimal(0));
                dtoPosicionSolicitudAux.setPrecioCatalogoUnitarioDocumento(new BigDecimal(0));
                dtoPosicionSolicitudAux.setPrecioContableUnitarioLocal(dtoProductoReemplazo.getPrecioPosicionamiento());
                dtoPosicionSolicitudAux.setPrecioContableUnitarioDocumento(new BigDecimal(0));
            }else{
                dtoPosicionSolicitudAux.setPrecioCatalogoUnitarioLocal(new BigDecimal(0));
                dtoPosicionSolicitudAux.setPrecioCatalogoUnitarioDocumento(new BigDecimal(0));
                dtoPosicionSolicitudAux.setPrecioContableUnitarioLocal(tipoCambio.multiply(dtoProductoReemplazo.getPrecioPosicionamiento()));
                dtoPosicionSolicitudAux.setPrecioContableUnitarioDocumento(dtoProductoReemplazo.getPrecioPosicionamiento());
            }
        }

        // FIN modificado SICC20070315

        dtoPosicionSolicitudAux.setTipoPosicion(new Long(4));
        dtoPosicionSolicitudAux.setSubtipoPosicion(new Long(2029));
        //dtoPosicionSolicitudAux.setPosicionRecuperacion(dtoPosicionSolicitud.getOidPosicionSolicitud());
        dtoPosicionSolicitudAux.setPosicionRecuperacion(Long.getLong(dtoPosicionSolicitud.getCodigoVenta().trim()));
        dtoPosicionSolicitudAux.setOidPosicionSolicitud(null);
        
        dtoPosicionSolicitud.setTipoPosicion(new Long(4));
        dtoPosicionSolicitud.setSubtipoPosicion(new Long(2030));
        dtoPosicionSolicitud.setUnidadesPorAtender(new Long(0));
        dtoPosicionSolicitud.setUnidadesComprometidas(new Long(0));
        dtoPosicionSolicitud.setUnidadesDemandaReal(new Long(0));
        dtoPosicionSolicitudAux.setProductoReemplazado(Boolean.TRUE);
        dtoPosicionSolicitud.setProductoReemplazado(Boolean.TRUE);
        
        UtilidadesLog.info("DAOReemplazoProductos.reemplazarProducto(DTOPosicionSolicitud dtoPosicionSolicitud, DTOProductoReemplazo dtoProductoReemplazo, Long monedaMF, BigDecimal tipoCambio): Salida");
        return dtoPosicionSolicitudAux;
    }
    
    
    /**
     * 
     * @date 
     * @throws es.indra.mare.common.exception.MareException
     * @param oidPais
     * @param oidCliente
     * @param posicionesMensaje
     */
    private void generarMensaje(ArrayList posicionesMensaje, Long oidCliente, Long oidPais, Long cabeSoli)throws MareException{
        UtilidadesLog.info("DAOReemplazoProductos.generarMensaje(ArrayList posicionesMensaje): Entrada");
        Vector vectorMensaje= null;
        
        //UtilidadesLog.debug("posicionesMensaje = " + posicionesMensaje);
        int tamanoPosMen = posicionesMensaje.size();
        int i;
        String cvOriginal;
        DTOPosicionSolicitud dtoP = null;        
        String detallesOferta = new String();
        Hashtable tblBuzonMensajeInserta = new Hashtable();
        String[] datosVariables; 
        //UtilidadesLog.debug("tamanoPosMen = " + tamanoPosMen);
        if (tamanoPosMen>0){
            
            //listaDtosBuzon = new DTOBuzonMensajes[tamanoPosMen];
            for (i = 0 ; i < tamanoPosMen; i++){
                vectorMensaje  = (Vector)posicionesMensaje.get(i);
                dtoP = (DTOPosicionSolicitud)vectorMensaje.get(0);
                cvOriginal = (String)vectorMensaje.get(1);
                detallesOferta = detallesOferta + dtoP.getOidDetalleOferta() + ",";
                datosVariables = new String[7];
                datosVariables[0]= "'" + dtoP.getCodigoVenta() + "'" ;//DATO_VARI_01 
                datosVariables[1]= new String ("null");//DATO_VARI_03 
                datosVariables[2]= new String ("null");//DATO_VARI_04 
                datosVariables[3]= (dtoP.getUnidadesDemandadas()!=null ? "'" + dtoP.getUnidadesDemandadas().toString() + "'" : "null");//DATO_VARI_05 
                datosVariables[4]= (dtoP.getUnidadesAtendidas()!=null ? "'" + dtoP.getUnidadesAtendidas().toString()+ "'"  : "null");//DATO_VARI_06 
                datosVariables[5]= "'" + cvOriginal + "'" ;//DATO_vARI_07 
                datosVariables[6]= "0" ;//IND_LIST_CONS  va en 0 porque es ConstantesMSG.NO
                //UtilidadesLog.debug("datosVariables =  " + datosVariables);
                tblBuzonMensajeInserta.put(dtoP.getOidDetalleOferta(),datosVariables);
            }
            
            this.consultaDetalleOferta(detallesOferta, tblBuzonMensajeInserta);
            this.grabaMensajeBuzon(tblBuzonMensajeInserta, oidCliente, oidPais, cabeSoli);
            
            
        }
        UtilidadesLog.info("DAOReemplazoProductos.generarMensaje(ArrayList posicionesMensaje): Salida");
    }
    
    /**
     * 
     * @date 04/08/06
     * @throws es.indra.mare.common.exception.MareException
     * @param tblBuzonMensajeInserta
     * @author pperanzola
     * DATO_VARI_01  , DATO_VARI_03  , DATO_VARI_04  , DATO_VARI_05  , DATO_VARI_06 , DATO_vARI_07  , IND_LIST_CONS,  IND_ACTI ,  FEC_GRAB
     */
    private void grabaMensajeBuzon (Hashtable tblBuzonMensajeInserta, Long oidCliente, Long oidPais , Long cabeSoli) throws MareException{
        UtilidadesLog.info("DAOReemplazoProductos.grabaMensajeBuzon(Hashtable tblBuzonMensajeInserta, Long oidCliente, Long oidPais): Entrada");
        String mensajes = new String();        
        String[] datosVari;        
        ArrayList parametros = new ArrayList();
        Iterator it = tblBuzonMensajeInserta.values().iterator();
        SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy kk:mm:ss");
        while (it.hasNext()){
            datosVari = (String[]) it.next();
            mensajes = mensajes + datosVari[0] + " , " //DATO_VARI_01
                                + datosVari[1] + " , " //DATO_VARI_03
                                + datosVari[2] + " , " //DATO_VARI_04
                                + datosVari[3] + " , " //DATO_VARI_05
                                + datosVari[4] + " , " //DATO_VARI_06
                                + datosVari[5] + " , " //DATO_VARI_07
                                + datosVari[6] + " , " //IND_LIST_CONS
                                + " 1 "          + " , " //IND_ACTI
                                + " TO_DATE ('" + sd.format(new java.sql.Timestamp(System.currentTimeMillis())).toString() + "','dd/MM/yyyy HH24:MI:SS') ; " ;//FEC_GRAB
                                
        }
        parametros.add(mensajes);
        parametros.add(oidPais.toString());
        parametros.add(oidCliente.toString());
        parametros.add(cabeSoli.toString());        
        UtilidadesLog.debug("mensajes = " + mensajes);
        UtilidadesLog.debug("oidPais = " + oidPais);
        UtilidadesLog.debug("oidCliente = " + oidCliente);
        UtilidadesLog.debug("cabeSoli = " + cabeSoli);
        try{
            BelcorpService.getInstance().dbService.executeProcedure("PQ_PLANI.PRE_ACTUA_BUZON_MENSA", parametros);
        }catch(Exception ex){
            UtilidadesLog.error(ex.getMessage());
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS)); 
        }
        UtilidadesLog.info("DAOReemplazoProductos.grabaMensajeBuzon(Hashtable tblBuzonMensajeInserta, Long oidCliente, Long oidPais): Salida");
    }
    
    /** 
     * 
     * @date 04/08/06
     * @throws es.indra.mare.common.exception.MareException
     * @param tblBuzonMensajeInserta
     * @param detallesOferta
     * @author pperanzola
     */
    private void consultaDetalleOferta ( String detallesOferta ,Hashtable tblBuzonMensajeInserta ) throws MareException{
        UtilidadesLog.info("DAOReemplazoProductos.consultaDetalleOferta ( String detallesOferta ,Hashtable tblBuzonMensajeInserta ): Entrada");
        //UtilidadesLog.debug(" tblBuzonMensajeInserta = "+ tblBuzonMensajeInserta);
        detallesOferta = detallesOferta.substring(0, detallesOferta.length() -1 );
        String[] detaBuffer = detallesOferta.split(",");
        int i;
        int cont=0;
        String tmpOids = new String ();
        StringBuffer query = new StringBuffer();
        
        //cdos gPineda BELC300023756 - se cambia el texto breve por el texto largo internacionalizable
        //query.append(" SELECT OID_DETA_OFER, VAL_TEXT_BREV, VAL_FACT_REPE  FROM PRE_OFERT_DETAL ");
        //query.append(" WHERE 1=2 ");
        RecuperadorIdiomaDefectoServidor recuperadorIdioma=new RecuperadorIdiomaDefectoServidor(); 
        Long idiomaPorDefecto= recuperadorIdioma.getIdiomaDefectoServidor();
        query.append(" SELECT OID_DETA_OFER, i.VAL_I18N VAL_TEXT, VAL_FACT_REPE ");
        query.append(" FROM PRE_OFERT_DETAL , GEN_I18N_SICC_PAIS i ");
        query.append(" WHERE ( i.attr_enti = 'MAE_PRODU' AND i.VAL_OID = prod_oid_prod AND i.idio_oid_idio = "+ idiomaPorDefecto +" ) AND ( 1=2 ");
        
        RecordSet rs;
        Long oidOfertaDetalle;
        String textoI18N = new String();
        String factRepe= new String();
        String[] datosVariables;
        
        if (detaBuffer.length >1000){
            for ( i = 0; i < detaBuffer.length; i++){   
                cont = cont + 1;
                if ( cont < 1000){
                  if (!tmpOids.equals("")){
                    tmpOids = tmpOids + "," + detaBuffer[i] ;
                  }else{
                    tmpOids = detaBuffer[i] ;
                  }
                }else{
                    query.append(" OR  OID_DETA_OFER IN (" + tmpOids  + ") "); 
                    cont = 0;
                    tmpOids = "";
                    
                }
                
            }
            query.append(" OR OID_DETA_OFER IN (" + tmpOids  + ") "); 
        }else{
            query.append(" OR OID_DETA_OFER IN (" + detallesOferta + ") ");        
        }
        query.append(" )");
        //UtilidadesLog.debug("query = " + query.toString());
        try {
            rs = BelcorpService.getInstance().dbService.executeStaticQuery(query.toString());
        }catch (Exception ex){
            UtilidadesLog.error(ex.getMessage());
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        
        int cantReg = rs.getRowCount();
        //UtilidadesLog.debug("cantReg = " + cantReg);
        for (i= 0; i < cantReg; i++){
            oidOfertaDetalle = new Long(((BigDecimal)rs.getValueAt(i, "OID_DETA_OFER")).longValue());
            factRepe = ((rs.getValueAt(i, "VAL_FACT_REPE") != null)? "'" + new String(((BigDecimal)rs.getValueAt(i, "VAL_FACT_REPE")).toString()) + "'" :"null");
            textoI18N = ((rs.getValueAt(i, "VAL_TEXT"))!= null? "'" + (String)(rs.getValueAt(i, "VAL_TEXT")) + "'" : "null");
            datosVariables = (String[])tblBuzonMensajeInserta.get(oidOfertaDetalle);
            datosVariables[1] = textoI18N;
            datosVariables[2] = factRepe;
            //UtilidadesLog.debug("datosVariables"+i+" = " + datosVariables);
        }
        
        UtilidadesLog.info("DAOReemplazoProductos.consultaDetalleOferta ( String detallesOferta ,Hashtable tblBuzonMensajeInserta ): Salida");
    }
}