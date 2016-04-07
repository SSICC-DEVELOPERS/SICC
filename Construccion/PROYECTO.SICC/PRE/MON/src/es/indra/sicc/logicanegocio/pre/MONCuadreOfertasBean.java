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
import es.indra.sicc.dtos.msg.ConstantesMSG;
import es.indra.sicc.dtos.msg.DTOBuzonMensajes;
import es.indra.sicc.dtos.ped.DTOCabeceraSolicitud;
import es.indra.sicc.dtos.ped.DTOPosicionSolicitud;
import es.indra.sicc.dtos.ped.DTOSolicitudValidacion;
import es.indra.sicc.dtos.pre.ConstantesPRE;
import es.indra.sicc.dtos.pre.DTOBuscarCodigoVentaPeriodo;
import es.indra.sicc.dtos.pre.DTOProductoReemplazo;
import es.indra.sicc.entidades.msg.MensajesLocal;
import es.indra.sicc.entidades.msg.MensajesLocalHome;
import es.indra.sicc.entidades.ped.SolicitudMensajesLocal;
import es.indra.sicc.entidades.ped.SolicitudMensajesLocalHome;
import es.indra.sicc.entidades.pre.CabeceraMFLocal;
import es.indra.sicc.entidades.pre.CabeceraMFLocalHome;
import es.indra.sicc.entidades.pre.DetalleOfertaLocal;
import es.indra.sicc.entidades.pre.DetalleOfertaLocalHome;
import es.indra.sicc.logicanegocio.msg.MONGestionMensajesHome;
import es.indra.sicc.logicanegocio.ped.ConstantesPED;
import es.indra.sicc.logicanegocio.ped.DAOSolicitud;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesError;

import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

import javax.ejb.CreateException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.rmi.PortableRemoteObject;
import es.indra.sicc.logicanegocio.pre.DAOReemplazoProductos;
import es.indra.sicc.logicanegocio.msg.MONGestionMensajesLocalHome;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

/**
 * MON general del cuadre de ofertas, invoca a los demas MONes segun el tipo de oferta.
 *
 * @version 3.6 - 12 Sep 2005
 * @author Emilio Noziglia
 */
public class MONCuadreOfertasBean implements SessionBean  {

    SessionContext ctx; 
    private static UtilidadesLog logAux = new UtilidadesLog();
    
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
   * 03/08/06 - [1] - pperanzola, mejoras por performance
   */
    public DTOCabeceraSolicitud cuadrarOfertas(DTOCabeceraSolicitud dtoe, Long tipoPosicion, Long subtipoPosicion) throws MareException {
        UtilidadesLog.info("MONCuadreOfertasBean.cuadrarOfertas(DTOCabeceraSolicitud dtoe, Long tipoPosicion, Long subtipoPosicion): Entrada");
        Long moneda = null;
        BigDecimal tipoCambio = null;  
        
        //doliva -- cambio Optimizacion Logs -- 09/04/2010
        if(logAux.isDebugEnabled())
            UtilidadesLog.debug("## dtoe ENTRADA=" + dtoe);
            
        DAOReemplazoProductos daoReemplazo = new DAOReemplazoProductos(this.ctx);
        try{
            CabeceraMFLocalHome cmflh = new CabeceraMFLocalHome();
            CabeceraMFLocal cabec = cmflh.findByUK(dtoe.getPeriodo());
            moneda = cabec.getMoneda();
            if (cabec.getTipoCambio()!=null)
              tipoCambio = new BigDecimal(cabec.getTipoCambio().doubleValue());
        }catch (NoResultException e){
             UtilidadesLog.error("ERROR",e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        try{
            dtoe = this.ordenarPosiciones(dtoe);

            Boolean indAntesCuadre = Boolean.TRUE;
            
            DTOProductoReemplazo[] dtoProdReemp = daoReemplazo.obtenerProductoReemplazo(dtoe.getPosiciones(),dtoe.getPeriodo(), dtoe.getOidCabeceraSolicitud());
            
            dtoe = daoReemplazo.reemplazarProductosSolicitud(dtoe,moneda,tipoCambio,indAntesCuadre,dtoProdReemp); //[1] dtoe = reemplazarProductosSolicitud(dtoe, moneda, tipoCambio, indAntesCuadre);

            dtoe = realizarCuadre(dtoe, tipoPosicion, subtipoPosicion);

            indAntesCuadre = Boolean.FALSE;
            
            dtoProdReemp = daoReemplazo.obtenerProductoReemplazo(dtoe.getPosiciones(),dtoe.getPeriodo(), dtoe.getOidCabeceraSolicitud());
            
            dtoe = daoReemplazo.reemplazarProductosSolicitud(dtoe,moneda,tipoCambio,indAntesCuadre,dtoProdReemp);//[1] dtoe = reemplazarProductosSolicitud(dtoe, moneda, tipoCambio, indAntesCuadre);

            dtoe = setUnidadesPorAtender(dtoe);
        } catch (Exception e) {
            if (e instanceof MareException){
                throw (MareException)e;
            }else{
                UtilidadesLog.error("ERROR",e);
                ctx.setRollbackOnly();
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
        }
        UtilidadesLog.info("MONCuadreOfertasBean.cuadrarOfertas(DTOCabeceraSolicitud dtoe, Long tipoPosicion, Long subtipoPosicion): Salida");
        return dtoe;
    }

  /**     
   *@autor jpbosnja
   */
    public void revertirCuadre(DTOSolicitudValidacion dtoe) throws MareException {
        UtilidadesLog.info("MONCuadreOfertasBean.revertirCuadre(DTOSolicitudValidacion dtoe): Entrada");
        try{
            DAOSolicitud dao = new DAOSolicitud();
            dao.eliminarPosicionesCuadre(dtoe.getOidSolicitud(), ConstantesPED.TIPO_POSICION_CUADRE_OFERTAS);
            dao.actualizarPosicionesRevertirCuadre(dtoe.getOidSolicitud());
            eliminarMensajesAsociados(dtoe.getOidPais(), dtoe.getOidSolicitud());

        }catch (Exception e){
            if (e instanceof MareException){
                throw (MareException)e;
            }else{
                UtilidadesLog.error("ERROR",e);
                ctx.setRollbackOnly();
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
        }
        UtilidadesLog.info("MONCuadreOfertasBean.revertirCuadre(DTOSolicitudValidacion dtoe): Salida");
    }
  /**
   * 
    Crea un DTOProductoReemplazo con: 
    - oidPeriodo = periodo 
    - cvPrincipal = codigoVenta 

    DTOProductoReemplazo = MONMantenimientoMF.obtenerProductoReemplazo(DTOProductoReemplazo) 

    Devuelve DTOProductoReemplazo
    *@autor jpbosnja
    */
    private DTOProductoReemplazo obtenerProductoReemplazo(Long periodo, String codigoVenta) throws Exception{
        UtilidadesLog.info("MONCuadreOfertasBean.obtenerProductoReemplazo(Long periodo, String codigoVenta): Entrada");
        DTOProductoReemplazo dto = new DTOProductoReemplazo();
        dto.setOidPeriodo(periodo);
        dto.setCvPrincipal(codigoVenta);
        try{
            //dto = getMONMantenimientoMFHome().create().obtenerProductoReemplazo(dto);
            dto = getMONMantenimientoMFLocalHome().create().obtenerProductoReemplazo(dto);
        }catch (NamingException e){
            UtilidadesLog.error("ERROR",e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }catch(CreateException e){
            UtilidadesLog.error("ERROR",e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }catch (Exception e){
            if (e instanceof MareException){
                throw (MareException)e;
            }else{
                UtilidadesLog.error("ERROR",e);
                ctx.setRollbackOnly();
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
        }
        UtilidadesLog.info("MONCuadreOfertasBean.obtenerProductoReemplazo(Long periodo, String codigoVenta): Salida");
        return dto;
    }
    
    
    /**
     * @author jpbosnjak
     * @date 
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * @param dtoe
     */
    private DTOProductoReemplazo[] obtenerProductoReemplazo2(DTOProductoReemplazo[] dtoe) throws MareException {
        UtilidadesLog.info("MONCuadreOfertas.obtenerProductoReemplazo2(DTOProductoReemplazo dtoe): Entrada");
        BelcorpService bs = null;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            StringBuffer query = new StringBuffer(" SELECT dto2.val_codi_vent cv_reemplazo, dto2.VAL_FACT_REPE, ");
            query.append(" ind_reem_ante_cuad ind_antes_cuadre, ind_mens ind_mensaje, ");
            query.append(" dto2.imp_prec_cata precio_catalogo, dto2.OID_DETA_OFER, dto2.PROD_OID_PROD, dto1.val_codi_vent cv_principal");
            query.append(" FROM ");
            query.append(" pre_matri_reemp ma, pre_matri_factu mf1, pre_ofert_detal dto1, pre_matri_factu mf2, ");
            query.append(" pre_ofert_detal dto2, pre_matri_factu_cabec cmf  ");
            query.append(" WHERE  ");
            for (int x = 0 ; x < dtoe.length ; x++){
                if (x == 0){
                    query.append(" dto1.val_codi_vent in ( ");
                }
                if (x == (dtoe.length-1) ){
                    query.append(" '" + dtoe[x].getCvPrincipal() + "' ) ");
                }else{
                    query.append(" '" + dtoe[x].getCvPrincipal() + "' ,");
                }
            }
            query.append(" AND cmf.perd_oid_peri = " + dtoe[0].getOidPeriodo());
            query.append(" AND cmf.oid_cabe = mf1.mfca_oid_cabe");
            query.append(" AND dto1.OID_DETA_OFER = mf1.OFDE_OID_DETA_OFER ");
            query.append(" AND ma.mafa_oid_cod_ppal = mf1.oid_matr_fact");
            query.append(" AND dto2.oid_deta_ofer = mf2.ofde_oid_deta_ofer");
            query.append(" AND cmf.oid_cabe = mf2.mfca_oid_cabe");
            query.append(" AND ma.mafa_oid_cod_reem = mf2.oid_matr_fact");

            RecordSet r = bs.dbService.executeStaticQuery(query.toString());

            if (r.esVacio()) {
                return null;
            }
            DTOProductoReemplazo[] dto = new DTOProductoReemplazo[r.getRowCount()];
            for (int i = 0 ; i< r.getRowCount() ; i++){
                dto[i] = new DTOProductoReemplazo();
                dto[i].setCvReemplazo((String) r.getValueAt(i, "CV_REEMPLAZO"));
                dto[i].setCvPrincipal((String) r.getValueAt(i, "CV_PRINCIPAL"));
    
                if (r.getValueAt(i, "IND_ANTES_CUADRE") != null) {
                    if (((BigDecimal) r.getValueAt(i, "IND_ANTES_CUADRE")).longValue() == 1) {
                        dto[i].setIndAntesCuadre(Boolean.TRUE);
                    } else {
                        dto[i].setIndAntesCuadre(Boolean.FALSE);
                    }
                }
    
                if (r.getValueAt(i, "IND_MENSAJE") != null) {
                    if (((BigDecimal) r.getValueAt(i, "IND_MENSAJE")).longValue() == 1) {
                        dto[i].setIndMensaje(Boolean.TRUE);
                    } else {
                        dto[i].setIndMensaje(Boolean.FALSE);
                    }
                }
    
                dto[i].setPrecioCatalogoReemplazo((BigDecimal) r.getValueAt(i, "PRECIO_CATALOGO"));
    
                if (r.getValueAt(i, "PROD_OID_PROD") != null) {
                    Long tmpOidProd = null;
                    tmpOidProd = new Long(((BigDecimal) r.getValueAt(i, "PROD_OID_PROD")).longValue());
                    dto[i].setOidProducto(tmpOidProd);
                }
    
                if (r.getValueAt(i, "OID_DETA_OFER") != null) {
                    Long tmpOidOfer = null;
                    tmpOidOfer = new Long(((BigDecimal) r.getValueAt(i, "OID_DETA_OFER")).longValue());
                    dto[i].setOidDetalleOferta(tmpOidOfer);
                }
                
                if (r.getValueAt(i, "VAL_FACT_REPE") != null) {
                    dto[i].setFactorCuadre(new Integer(r.getValueAt(i, "VAL_FACT_REPE").toString()));
                }
                //UtilidadesLog.debug("Reemplazo encontrado: "+dto[i]);
            }

            UtilidadesLog.info("MONCuadreOfertas.obtenerProductoReemplazo2(DTOProductoReemplazo dtoe): Salida");
            return dto;
        } catch (Exception e) {
            UtilidadesLog.error("ERROR",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
    }

   /**
    * @autor jpbosnja
    * @modificado - 08/08/2005 - BELC300014487 - pperanzola
    */
    private DTOPosicionSolicitud reemplazarProducto(DTOPosicionSolicitud dtoPosicionSolicitud, DTOProductoReemplazo dtoProductoReemplazo, Long monedaMF, BigDecimal tipoCambio) throws Exception{
        UtilidadesLog.info("MONCuadreOfertasBean.reemplazarProducto(DTOPosicionSolicitud dtoPosicionSolicitud, DTOProductoReemplazo dtoProductoReemplazo, Long monedaMF, BigDecimal tipoCambio): Entrada");
        dtoPosicionSolicitud.setCodigoVenta(dtoProductoReemplazo.getCvReemplazo());
        // seteamos el oidDetalleOferta del producto de reemplazo a la posicion. Activamos 
        // el indicador de producto de reemplazo en la posicion
        dtoPosicionSolicitud.setOidDetalleOferta(dtoProductoReemplazo.getOidDetalleOferta());
        //UtilidadesLog.debug("getOidDetalleOferta =  " + dtoProductoReemplazo.getOidDetalleOferta()); 
        dtoPosicionSolicitud.setProductoReemplazado(Boolean.TRUE);
        dtoPosicionSolicitud.setFactorRepeticion(dtoProductoReemplazo.getFactorCuadre());
        if (monedaMF==null){
            dtoPosicionSolicitud.setPrecioCatalogoUnitarioLocal(dtoProductoReemplazo.getPrecioCatalogoReemplazo());    
        }else{
            dtoPosicionSolicitud.setPrecioCatalogoUnitarioLocal(tipoCambio.multiply(dtoProductoReemplazo.getPrecioCatalogoReemplazo()));
            dtoPosicionSolicitud.setPrecioCatalogoUnitarioDocumento(dtoProductoReemplazo.getPrecioCatalogoReemplazo());
        }
        UtilidadesLog.info("MONCuadreOfertasBean.reemplazarProducto(DTOPosicionSolicitud dtoPosicionSolicitud, DTOProductoReemplazo dtoProductoReemplazo, Long monedaMF, BigDecimal tipoCambio): Salida");
        return dtoPosicionSolicitud;
    }


   /**
    *@autor jpbosnja
    * 03/08/06 - [1] - pperanzola - se modifica para que no genere mensaje si es una simulacion de cuadre
    **/
    private DTOCabeceraSolicitud reemplazarProductosSolicitud(DTOCabeceraSolicitud dtoe, Long monedaMF, BigDecimal tipoCambio, Boolean indAntesCuadre) throws Exception{
        UtilidadesLog.info("MONCuadreOfertasBean.reemplazarProductosSolicitud(DTOCabeceraSolicitud dtoe, Long monedaMF, BigDecimal tipoCambio, Boolean indAntesCuadre): Entrada");
        ArrayList posicionesSolicitud = dtoe.getPosiciones();
        int posicion=0;
        int cantPos = posicionesSolicitud.size();
        DTOProductoReemplazo[] dtoProductoReemplazoEntrada = new DTOProductoReemplazo[cantPos];
        for (;posicion<cantPos;posicion++){
            DTOPosicionSolicitud dtoP = (DTOPosicionSolicitud)posicionesSolicitud.get(posicion);
            dtoProductoReemplazoEntrada[posicion] = new DTOProductoReemplazo();
            dtoProductoReemplazoEntrada[posicion].setCvPrincipal(dtoP.getCodigoVenta());
            dtoProductoReemplazoEntrada[posicion].setOidPeriodo(dtoe.getPeriodo());
        }
        if (dtoProductoReemplazoEntrada.length <1){
            return dtoe;
        }
        DTOProductoReemplazo[] dtoProductoReemplazoSalida = obtenerProductoReemplazo2(dtoProductoReemplazoEntrada);
        posicion = 0;
        if (dtoProductoReemplazoSalida != null){
            for (int i = 0 ; i < dtoProductoReemplazoSalida.length ; i++){
                for (;posicion<cantPos;posicion++){
                    DTOPosicionSolicitud dtoP = (DTOPosicionSolicitud)posicionesSolicitud.get(posicion);
                    //UtilidadesLog.debug("Comparo principal: "+dtoProductoReemplazoSalida[i].getCvPrincipal()+" - "+dtoP.getCodigoVenta());
                    if (dtoProductoReemplazoSalida[i].getCvPrincipal().equals(dtoP.getCodigoVenta())){
                      
                        //DTOProductoReemplazo dtoPR = obtenerProductoReemplazo(dtoe.getPeriodo(), dtoP.getCodigoVenta());
                        DTOProductoReemplazo dtoPR = dtoProductoReemplazoSalida[i];
                        if ( dtoPR != null && dtoPR.getIndAntesCuadre().equals(indAntesCuadre)){
                           String cvOriginal = dtoP.getCodigoVenta();
                           dtoP = reemplazarProducto(dtoP, dtoPR, monedaMF, tipoCambio);
                           
                           if (dtoe.getIndPedidoPrueba() == null || dtoe.getIndPedidoPrueba().equals(Boolean.TRUE)){ // [1] graba si NO es simulacion de cuadre
                               if (dtoPR.getIndMensaje()!=null && dtoPR.getIndMensaje().equals(Boolean.TRUE)){//que es el reemplazo de ConstantesPRE.SI
                                   generarMensaje(dtoe, new Long(posicion), cvOriginal);
                               }
                           }
                           posicionesSolicitud.set(posicion, dtoP);
                        }
                    }
                }
            }
        }
        dtoe.setPosiciones(posicionesSolicitud);
        
        UtilidadesLog.info("MONCuadreOfertasBean.reemplazarProductosSolicitud(DTOCabeceraSolicitud dtoe, Long monedaMF, BigDecimal tipoCambio, Boolean indAntesCuadre): Salida");
        return dtoe;
    }
    
  /**
   *@autor jpbosnja
   */
    private void generarMensaje(DTOCabeceraSolicitud dtoe, Long posicion, String cvOriginal) throws Exception{
        UtilidadesLog.info("MONCuadreOfertasBean.generarMensaje(DTOCabeceraSolicitud dtoe, Long posicion, String cvOriginal): Entrada");
        try{
            DTOPosicionSolicitud dtoP = (DTOPosicionSolicitud)dtoe.getPosiciones().get(posicion.intValue());
            DTOBuscarCodigoVentaPeriodo dtoB = new DTOBuscarCodigoVentaPeriodo();
            dtoB.setCodigoVenta(dtoP.getCodigoVenta());
            dtoB.setPeriodo(dtoe.getPeriodo());
            DTOSalida dtoS=null;
            try{
                //dtoS = getMONMantenimientoMFHome().create().buscarCodigoVentaPeriodo(dtoB);
                dtoS = this.buscarCodigoVentaPeriodo(dtoB);
            }catch(Exception e){
                //Por si tira error y no encuentra datos
                dtoS = new DTOSalida();
            }
            DTOBuzonMensajes dtoBuzon = new DTOBuzonMensajes();
            dtoBuzon.setOidPais(dtoe.getOidPais()); 
            dtoBuzon.setCodigoMensaje(ConstantesMSG.MENSAJE_PRE02); 
            dtoBuzon.setOidCliente(dtoe.getOidCliente()); 
            dtoBuzon.setModuloOrigen(new Long(ConstantesSEG.MODULO_PRE)); 
            dtoBuzon.setDatoVariable1(dtoP.getCodigoVenta()); 
            Long oidDetalleOferta = null;
            if (dtoS.getResultado()!=null && dtoS.getResultado().getRowCount()>0){ 
                oidDetalleOferta = new Long(((BigDecimal)dtoS.getResultado().getValueAt(0,0)).longValue());
                DetalleOfertaLocalHome dolh = new DetalleOfertaLocalHome();
                DetalleOfertaLocal detalLocal = dolh.findByPrimaryKey(oidDetalleOferta);
                dtoBuzon.setDatoVariable3(detalLocal.getTextoBreve()); 
                dtoBuzon.setDatoVariable4(detalLocal.getFactorRepeticion().toString());
            }
            if (dtoP.getUnidadesDemandadas()!=null)
                dtoBuzon.setDatoVariable5(dtoP.getUnidadesDemandadas().toString());
            if (dtoP.getUnidadesAtendidas()!=null)
                dtoBuzon.setDatoVariable6(dtoP.getUnidadesAtendidas().toString());    
            dtoBuzon.setDatoVariable7( cvOriginal); 
            dtoBuzon.setListaConsultoras(ConstantesMSG.NO);
            //getMONGestionMensajesHome().create().insertaDatosMensaje(dtoBuzon);
            getMONGestionMensajesLocalHome().create().insertaDatosMensaje(dtoBuzon);
            
            // gPineda cdos 26/07/06 - BELC300023756 (DBLG500001024)
            guardarMensajeSolicitud(dtoe, dtoBuzon);
                        
        } catch (NoResultException e) {
            UtilidadesLog.error("ERROR",e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException e) {
            UtilidadesLog.error("ERROR",e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (NamingException e) {
            UtilidadesLog.error("ERROR",e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch(CreateException e) {
            UtilidadesLog.error("ERROR",e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (Exception e) {
            if (e instanceof MareException){
                throw (MareException)e;
            }else{
                UtilidadesLog.error("ERROR",e);
                ctx.setRollbackOnly();
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
        }
        UtilidadesLog.info("MONCuadreOfertasBean.generarMensaje(DTOCabeceraSolicitud dtoe, Long posicion, String cvOriginal): Salida");
    }

   /**   
    * @autor jpbosnja
    * @modificado enozigli 13/09/2005 Nota: si las unidades por atender son modificadas
    *             por el factor de cuadre, el indicador de unidades modificadas no se
    *             ponia en TRUE, y luego en PED no se actualizaba el campo de la BD.
    *             lineas agregadas [1]
    * @modificado gPineda 19/07/2006
    *             En el caso de que se modifique las unidades por factor de cuadre y no
    *             por factor de repetición, no se estaría modificando en la BD. [2]
    *             Por ende, se elimina el if para que siempre se modifique la BD.
    */
    private DTOCabeceraSolicitud setUnidadesPorAtender(DTOCabeceraSolicitud dtoe) throws Exception{
        UtilidadesLog.info("MONCuadreOfertasBean.setUnidadesPorAtender(DTOCabeceraSolicitud dtoe): Entrada");
        
        ArrayList posicionesSolicitud = dtoe.getPosiciones();
        int posicion = 0;
        int cantPos = posicionesSolicitud.size();
        //DetalleOfertaLocalHome dLocalHome = getDetalleOfertaLocalHome();
        for (;posicion<cantPos;posicion++){
            DTOPosicionSolicitud dtoP = (DTOPosicionSolicitud)posicionesSolicitud.get(posicion);
            //DetalleOfertaLocal detal = dLocalHome.findByPrimaryKey(dtoP.getOidDetalleOferta());
            
            //[2] long uniPorAtenderOrig = dtoP.getUnidadesPorAtender().longValue();//[1]
            
            //doliva -- cambio Optimizacion Logs -- 09/04/2010
            if(logAux.isDebugEnabled())
                UtilidadesLog.debug("   setUnidadesPorAtender(DTOCabeceraSolicitud dtoe): dtoP: " + dtoP);
            //dtoP.setUnidadesPorAtender(new Long(dtoP.getUnidadesPorAtender().longValue()*detal.getFactorRepeticion().intValue()));
            
            /*
             * enoziglia 14/03/2007
             * Se agrega este cambio por la incidencia SiCC 20070113 
             * Se estaria pisando el valor de Unidades de Demanda Real, pero es el mismo de Unidades por atender.
             */
            dtoP.setUnidadesDemandaReal(new Long(dtoP.getUnidadesPorAtender().longValue()*dtoP.getFactorRepeticion().intValue()));
            
            /**
             * Ya esta dentro del dto, por lo tanto no es necesario ir a buscarlo a la BD
             * autor: jpbosnja
             */
            dtoP.setUnidadesPorAtender(new Long(dtoP.getUnidadesPorAtender().longValue()*dtoP.getFactorRepeticion().intValue()));
            
            
            //[2] if (uniPorAtenderOrig != dtoP.getUnidadesPorAtender().longValue()){//[1]
                dtoP.setUnidadesModificadas(Boolean.TRUE);//[1]
            //[2] }//[1]
            
            //UtilidadesLog.debug("MONCuadreOfertas.setUnidadesPorAtender CV:"+dtoP.getCodigoVenta()+" Unid:"+dtoP.getUnidadesPorAtender());
            posicionesSolicitud.set(posicion,dtoP);
        }
        dtoe.setPosiciones(posicionesSolicitud);
        
        UtilidadesLog.info("MONCuadreOfertasBean.setUnidadesPorAtender(DTOCabeceraSolicitud dtoe): Salida");
        return dtoe;
    }

   /**
      mensaje = Mensaje.findByUK(DTOCabeceraSolicitud.pais, ConstantesMSG.MENSAJE_PRE02)
      Creamos una entrada en la entidad SolicitudMensajes con:
      - solicitud: DTOCabeceraSolictud.oidCabeceraSolicitud
      - buzonMensaje: DTOBuzonMensaje.oid
      - mensaje: mensaje.oid
    *
    *@autor jpbosnja
    */
    private void guardarMensajeSolicitud(DTOCabeceraSolicitud dtoCabeceraSolicitud, DTOBuzonMensajes dtoBuzonMensajes) throws Exception{
        UtilidadesLog.info("MONCuadreOfertasBean.guardarMensajeSolicitud(DTOCabeceraSolicitud dtoCabeceraSolicitud, DTOBuzonMensajes dtoBuzonMensajes): Entrada");
        try{
            if (dtoCabeceraSolicitud.getOidCabeceraSolicitud() !=null   &&
                dtoBuzonMensajes.getOid() != null){    /*   pperez CAMBIO MSG-002  */
                MensajesLocalHome mlh = new MensajesLocalHome();
                MensajesLocal m = mlh.findByUk(dtoCabeceraSolicitud.getOidPais(),ConstantesMSG.MENSAJE_PRE02);
                getSolicitudMensajesLocalHome().create(dtoCabeceraSolicitud.getOidCabeceraSolicitud(),
                                                           m.getOid(),
                                                           dtoBuzonMensajes.getOid());
            }
        }catch (NoResultException e){
            UtilidadesLog.error("ERROR",e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }catch(PersistenceException e){
            UtilidadesLog.error("ERROR",e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }catch (Exception e){
            if (e instanceof MareException){
                throw (MareException)e;
            }else{
                UtilidadesLog.error("ERROR",e);
                ctx.setRollbackOnly();
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
        }
        UtilidadesLog.info("MONCuadreOfertasBean.guardarMensajeSolicitud(DTOCabeceraSolicitud dtoCabeceraSolicitud, DTOBuzonMensajes dtoBuzonMensajes): Salida");
    }
    
    /**
      // Ordena las posiciones de la solicitud en función del número de oferta y grupo 
      // Utiliza las clases java.util.Collections y ComparadorOfertas para ordenar el ArrayList posiciones contenido en el DTOCabeceraSolicitud 
      ComparadorOfertas comparador = new ComparadorOfertas() 
      Collections.sort(DTOE.posiciones, comparador); 
      Devuelve DTOE
     *
     *@autor jpbosnja
     */
    private DTOCabeceraSolicitud ordenarPosiciones(DTOCabeceraSolicitud dtoe) throws Exception{
        UtilidadesLog.info("MONCuadreOfertasBean.ordenarPosiciones(DTOCabeceraSolicitud dtoe): Entrada");
        ComparadorSolicitud comparador = new ComparadorSolicitud();
        Collections.sort(dtoe.getPosiciones(),comparador);
        UtilidadesLog.info("MONCuadreOfertasBean.ordenarPosiciones(DTOCabeceraSolicitud dtoe): Salida");
        return dtoe;
    }
    
   /**  
    *@autor jpbosnja
    */
    private void eliminarMensajesAsociados(Long pais, Long oidSolicutud) throws Exception{
        UtilidadesLog.info("MONCuadreOfertasBean.eliminarMensajesAsociados(Long pais, Long oidSolicutud): Entrada");
        try{
            MensajesLocalHome mlh = new MensajesLocalHome();
            MensajesLocal mensajeLocal = mlh.findByUk(pais, ConstantesMSG.MENSAJE_PRE02);
            SolicitudMensajesLocalHome slh = getSolicitudMensajesLocalHome();
            Collection mensajesSolicitud = slh.findBySolicitudMensaje(oidSolicutud, mensajeLocal.getOid());
            Iterator it = mensajesSolicitud.iterator();
            while(it.hasNext()){
                DTOBuzonMensajes dtoBuzon = new DTOBuzonMensajes();
                SolicitudMensajesLocal solLocal = (SolicitudMensajesLocal)it.next();
                dtoBuzon.setOid(solLocal.getValorBuzonMensaje());
                //getMONGestionMensajesHome().create().eliminaDatosMensaje(dtoBuzon);
                getMONGestionMensajesLocalHome().create().eliminaDatosMensaje(dtoBuzon);
                slh.remove(solLocal);
            }
        }catch (NamingException e){
            UtilidadesLog.error("ERROR",e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }catch(CreateException e){
            UtilidadesLog.error("ERROR",e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }catch(NoResultException e){
            UtilidadesLog.error("ERROR",e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }catch(PersistenceException e){
            UtilidadesLog.error("ERROR",e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
        }catch (Exception e){
            if (e instanceof MareException){
                throw (MareException)e;
            }else{
                UtilidadesLog.error("ERROR",e);
                ctx.setRollbackOnly();
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
        }
        UtilidadesLog.info("MONCuadreOfertasBean.eliminarMensajesAsociados(Long pais, Long oidSolicutud): Salida");
    }
  /**    
   *@autor jpbosnja
   */
    private DTOCabeceraSolicitud realizarCuadre(DTOCabeceraSolicitud dtoe, Long tipoPosicion, Long subtipoPosicion) throws Exception{
        UtilidadesLog.info("MONCuadreOfertasBean.realizarCuadre(DTOCabeceraSolicitud dtoe, Long tipoPosicion, Long subtipoPosicion): Entrada");
        Long oidOfertaAnterior = null;
        ArrayList posicionesOferta = null;
        dtoe.setIndCompletar(Boolean.FALSE);
        ArrayList posiciones = (ArrayList)dtoe.getPosiciones().clone();
        Iterator it = posiciones.iterator();
        /*UtilidadesLog.debug("posiciones= " + posiciones);
        UtilidadesLog.debug("tipoPosicion= " + tipoPosicion);
        UtilidadesLog.debug("tipoPosicion= " + tipoPosicion);*/
        try{
            while (it.hasNext()){
                DTOPosicionSolicitud dtoP = (DTOPosicionSolicitud)it.next();
                //UtilidadesLog.debug("Cuadrando posicion numero: "+dtoP.getNumeroPosicion());
                Long tipoEstrategia = dtoP.getTipoEstrategia();
                Long oidOferta = dtoP.getOidOferta();
                if (oidOfertaAnterior == null || !oidOferta.equals(oidOfertaAnterior)){
                    oidOfertaAnterior = oidOferta;
                    if (tipoEstrategia.intValue() == ConstantesPRE.COMPUESTA_FIJA && (!ConstantesPED.ESTADO_POSICION_ANULADO.equals(dtoP.getTipoPosicion()))){
                        //UtilidadesLog.debug("La posicion numero: "+dtoP.getNumeroPosicion()+" corresponde a una estrategia COMPUESTA_FIJA");
                        //dtoe =  getMONCuadreCompuestaFijaHome().create().cuadrarOferta(dtoe, dtoP, tipoPosicion, subtipoPosicion);
                        dtoe =  getMONCuadreCompuestaFijaLocalHome().create().cuadrarOferta(dtoe, dtoP, tipoPosicion, subtipoPosicion);
                    }else if (tipoEstrategia.intValue() == ConstantesPRE.CONDICIONADA){
                        //UtilidadesLog.debug("La posicion numero: "+dtoP.getNumeroPosicion()+" corresponde a una estrategia CONDICIONADA");
                        posicionesOferta = obtenerPosicionesOferta(posiciones, oidOferta, posiciones.indexOf(dtoP)); 
                        //dtoe = getMONCuadreCondicionadaHome().create().cuadrarOferta(dtoe, posicionesOferta, tipoPosicion, subtipoPosicion);
                        dtoe = getMONCuadreCondicionadaLocalHome().create().cuadrarOferta(dtoe, posicionesOferta, tipoPosicion, subtipoPosicion);
                    }else if(tipoEstrategia.intValue() == ConstantesPRE.COMPUESTA_VARIABLE ){
                        //UtilidadesLog.debug("La posicion numero: "+dtoP.getNumeroPosicion()+" corresponde a una estrategia COMPUESTA_VARIABLE");
                        posicionesOferta = obtenerPosicionesOferta(posiciones, oidOferta, posiciones.indexOf(dtoP)); 
                        //dtoe = getMONCuadreCompuestaVariableHome().create().cuadrarOferta(dtoe, posicionesOferta, null, Boolean.FALSE, tipoPosicion, subtipoPosicion); 
                        dtoe = getMONCuadreCompuestaVariableLocalHome().create().cuadrarOferta(dtoe, posicionesOferta, null, Boolean.FALSE, tipoPosicion, subtipoPosicion); 
                    }else{
                        //UtilidadesLog.debug("La posicion numero: "+dtoP.getNumeroPosicion()+" NO Se va a cuadrar por ser de estrategia individual");
                    }
                }
            }
            this.getMONCuadreProductosLocalHome().create().completarPosicion(dtoe);
            dtoe.setIndCompletar(Boolean.TRUE);
            dtoe = getMONCuadrePromocionLocalHome().create().cuadrarOferta(dtoe, tipoPosicion, subtipoPosicion);
        }catch (NamingException e){
            UtilidadesLog.error("ERROR",e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }catch(CreateException e){
            UtilidadesLog.error("ERROR",e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }catch (Exception e){
            if (e instanceof MareException){
                throw (MareException)e;
            }else{
                UtilidadesLog.error("ERROR",e);
                ctx.setRollbackOnly();
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
        }
        UtilidadesLog.info("MONCuadreOfertasBean.realizarCuadre(DTOCabeceraSolicitud dtoe, Long tipoPosicion, Long subtipoPosicion): Salida");
        return dtoe;
    }
  /**
   *@autor jpbosnja
   */
    private ArrayList obtenerPosicionesOferta(ArrayList posiciones, Long oidOferta, int primeraPosicion) throws Exception{
        UtilidadesLog.info("MONCuadreOfertasBean.obtenerPosicionesOferta(ArrayList posiciones, Long oidOferta, int primeraPosicion): Entrada");
        DTOPosicionSolicitud dtoP = (DTOPosicionSolicitud)posiciones.get(primeraPosicion);
        Long numeroOferta = dtoP.getOidOferta();
        ArrayList posicionesOferta = new ArrayList();
        int numeroPosicion = primeraPosicion;
        int cantPos = posiciones.size();
        
        while (dtoP.getOidOferta().longValue() == numeroOferta.longValue() 
               && cantPos>numeroPosicion){
               
            if(!ConstantesPED.ESTADO_POSICION_ANULADO.equals(dtoP.getTipoPosicion())){
                posicionesOferta.add(dtoP); 
            }
            numeroPosicion++;
            if (posiciones.size()>numeroPosicion){
                dtoP = (DTOPosicionSolicitud)posiciones.get(numeroPosicion);
            }else{
                break;
            }
        }
        
        UtilidadesLog.info("MONCuadreOfertasBean.obtenerPosicionesOferta(ArrayList posiciones, Long oidOferta, int primeraPosicion): Salida");
        return posicionesOferta;
    }

    private MONMantenimientoMFHome getMONMantenimientoMFHome() throws NamingException {
    final InitialContext context = new InitialContext();
    return (MONMantenimientoMFHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONMantenimientoMF"), MONMantenimientoMFHome.class);
  }

  private MONCuadreCompuestaFijaHome getMONCuadreCompuestaFijaHome() throws NamingException {
    final InitialContext context = new InitialContext();
    return (MONCuadreCompuestaFijaHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONCuadreCompuestaFija"), MONCuadreCompuestaFijaHome.class);
  }

  private MONCuadreCompuestaVariableHome getMONCuadreCompuestaVariableHome() throws NamingException {
    final InitialContext context = new InitialContext();
    return (MONCuadreCompuestaVariableHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONCuadreCompuestaVariable"), MONCuadreCompuestaVariableHome.class);
  }

  private SolicitudMensajesLocalHome getSolicitudMensajesLocalHome() throws NamingException {
    return new SolicitudMensajesLocalHome();
  }

  private MONGestionMensajesHome getMONGestionMensajesHome() throws NamingException {
    final InitialContext context = new InitialContext();
    return (MONGestionMensajesHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONGestionMensajes"), MONGestionMensajesHome.class);
  }


    private MONCuadreCondicionadaHome getMONCuadreCondicionadaHome() throws NamingException {
    final InitialContext context = new InitialContext();
    return (MONCuadreCondicionadaHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONCuadreCondicionada"), MONCuadreCondicionadaHome.class);
  }

  private MONCuadrePromocionHome getMONCuadrePromocionHome() throws NamingException {
    final InitialContext context = new InitialContext();
    return (MONCuadrePromocionHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONCuadrePromocion"), MONCuadrePromocionHome.class);
  }
  
    private DTOSalida buscarCodigoVentaPeriodo(DTOBuscarCodigoVentaPeriodo dto) throws MareException {
        UtilidadesLog.info("MONMantenimientoMFBean.buscarCodigoVentaPeriodo(DTOBuscarCodigoVentaPeriodo dto): Entrada");
        
        Long periodo = dto.getPeriodo();
        String codigoVenta = dto.getCodigoVenta();
        Long catalogo = dto.getCatalogo();

        StringBuffer query = new StringBuffer();
        RecordSet rs = null;
        DTOSalida dtos = new DTOSalida();
        BelcorpService belcorpService = null;

        if (periodo != null) {
            try {
                belcorpService = BelcorpService.getInstance();
            } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
                UtilidadesLog.error(serviceNotFoundException);
                throw new MareException(serviceNotFoundException, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
            }

            //Buscamos la matriz de facturacion correspondiente
            rs = null;
            query = new StringBuffer();
            query.append(" SELECT D.OID_DETA_OFER OID, D.VAL_CODI_VENT, C.COD_CATA, D.VAL_POSI_PAGI ");
            query.append(" FROM PRE_OFERT_DETAL D, PRE_CATAL C, PRE_OFERT O, PRE_MATRI_FACTU_CABEC M ");
            query.append(" WHERE D.OCAT_OID_CATAL = C.OID_CATA(+)");
            query.append(" AND M.PERD_OID_PERI = "+periodo);
            query.append(" AND M.OID_CABE = O.MFCA_OID_CABE ");
            query.append(" AND O.OID_OFER = D.OFER_OID_OFER ");
            query.append(" AND M.OID_CABE = O.MFCA_OID_CABE ");
            

            if ((codigoVenta != null) && (codigoVenta.length() > 0)) {
                query.append(" AND D.VAL_CODI_VENT = '" + codigoVenta + "'");
            }

            if (catalogo != null) {
                query.append(" AND D.OCAT_OID_CATAL = " + catalogo.toString());
            }

            if (dto.getPaginaDesde() != null) {
                query.append(" AND D.VAL_POSI_PAGI >= " + dto.getPaginaDesde().toString());
            }

            if (dto.getPaginaHasta() != null) {
                query.append(" AND d.VAL_POSI_PAGI <= " + dto.getPaginaHasta().toString());
            }

            try {
                rs = belcorpService.dbService.executeStaticQuery(query.toString());
            } catch (Exception exception) {
                UtilidadesLog.error(exception);
                throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
            }

            dtos = new DTOSalida();
            dtos.setResultado(rs);
        }

        if ((rs == null) || rs.esVacio()) {
            //UtilidadesLog.debug("Tirando mare exception");
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        
        UtilidadesLog.info("MONMantenimientoMFBean.buscarCodigoVentaPeriodo(DTOBuscarCodigoVentaPeriodo dto): Salida");
        return dtos;
    }

    private MONCuadrePromocionLocalHome getMONCuadrePromocionLocalHome() throws NamingException
    {
        final InitialContext context = new InitialContext();
        return (MONCuadrePromocionLocalHome)context.lookup("java:comp/env/ejb/local/MONCuadrePromocion");
    }

    private MONCuadreProductosLocalHome getMONCuadreProductosLocalHome() throws NamingException
    {
        final InitialContext context = new InitialContext();
        return (MONCuadreProductosLocalHome)context.lookup("java:comp/env/ejb/local/MONCuadreProductos");
    }

    private MONCuadreCompuestaVariableLocalHome getMONCuadreCompuestaVariableLocalHome() throws NamingException
    {
        final InitialContext context = new InitialContext();
        return (MONCuadreCompuestaVariableLocalHome)context.lookup("java:comp/env/ejb/local/MONCuadreCompuestaVariable");
    }

    private MONCuadreCondicionadaLocalHome getMONCuadreCondicionadaLocalHome() throws NamingException
    {
        final InitialContext context = new InitialContext();
        return (MONCuadreCondicionadaLocalHome)context.lookup("java:comp/env/ejb/local/MONCuadreCondicionada");
    }

    private MONMantenimientoMFLocalHome getMONMantenimientoMFLocalHome() throws NamingException
    {
        final InitialContext context = new InitialContext();
        return (MONMantenimientoMFLocalHome)context.lookup("java:comp/env/ejb/local/MONMantenimientoMF");
    }

    private MONCuadreCompuestaFijaLocalHome getMONCuadreCompuestaFijaLocalHome() throws NamingException
    {
        final InitialContext context = new InitialContext();
        return (MONCuadreCompuestaFijaLocalHome)context.lookup("java:comp/env/ejb/local/MONCuadreCompuestaFija");
    }

    private MONGestionMensajesLocalHome getMONGestionMensajesLocalHome() throws NamingException
    {
        final InitialContext context = new InitialContext();
        return (MONGestionMensajesLocalHome)context.lookup("java:comp/env/ejb/local/MONGestionMensajes");
    }
    
    
}