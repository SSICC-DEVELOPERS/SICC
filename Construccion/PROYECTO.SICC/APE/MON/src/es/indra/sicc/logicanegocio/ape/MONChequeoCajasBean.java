/**
 * Copyright 2007 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.obtenerCajaChequear
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 *
 * Autor: Viviana Bongiovanni
 */
package es.indra.sicc.logicanegocio.ape;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.ape.DTODatosCajaDetalle;
import es.indra.sicc.entidades.ape.EtiquetasLocal;
import es.indra.sicc.entidades.ape.ListaPicadoDetalleLocal;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import java.util.ArrayList;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.sicc.dtos.ape.DTOBuscarCaja;
import es.indra.sicc.dtos.ape.DTODatosCajaCabecera;
import es.indra.sicc.dtos.ape.DTOBuscarProducto;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.entidades.ape.ListaPicadoDetalleLocalHome;
import es.indra.sicc.entidades.ape.EtiquetasLocalHome;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;


public class MONChequeoCajasBean implements SessionBean {

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

  public DTODatosCajaCabecera obtenerCajaChequear(DTOBuscarCaja dtoe) throws MareException {
    UtilidadesLog.info("MONChequeoCajas.obtenerCajaChequear(DTOBuscarCaja dtoe): Entrada");
    UtilidadesLog.debug("DTOBuscarCaja: " + dtoe);
    
    DTODatosCajaCabecera dtoDatosCajaCabecera = null;
    
    try {
        DAOChequeoCajas daoChequeoCajas = new DAOChequeoCajas();          
        
        dtoDatosCajaCabecera = daoChequeoCajas.obtenerCajaChequear(dtoe);
        
    }  catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          ex.printStackTrace();
          throw new MareException(ex);
    } 
    
    UtilidadesLog.info("MONChequeoCajas.obtenerCajaChequear(DTOBuscarCaja dtoe): Salida");
    return dtoDatosCajaCabecera;
  }

  public DTOSalida buscarProducto(DTOBuscarProducto dtoe) throws MareException {
    UtilidadesLog.info("MONChequeoCajas.buscarProducto(DTOBuscarProducto dtoe): Entrada");
    UtilidadesLog.debug("DTOBuscarProducto: " + dtoe);
    
    DAOChequeoCajas daoChequeoCajas = new DAOChequeoCajas();          
    
    DTOSalida dtoSalida = daoChequeoCajas.buscarProducto(dtoe);
    
    UtilidadesLog.info("MONChequeoCajas.buscarProducto(DTOBuscarProducto dtoe): Salida");
    return dtoSalida;
  }

  public void actualizarCaja(DTODatosCajaCabecera dtoe) throws MareException {
    UtilidadesLog.info("MONChequeoCajas.actualizarCaja(DTODatosCajaCabecera dtoe): Entrada");
    UtilidadesLog.debug("DTODatosCajaCabecera: " + dtoe);
    
    try{
    
        ListaPicadoDetalleLocalHome listaPicDetH = new ListaPicadoDetalleLocalHome();
        ListaPicadoDetalleLocal listaPicDet = null;
        EtiquetasLocalHome etiqH = new EtiquetasLocalHome();
        EtiquetasLocal etiq = null;
        DAOChequeoCajas daoChequeoCajas = new DAOChequeoCajas();
        
        boolean pedidoInconsistente = false;
        DTODatosCajaDetalle dtoDatosCajaDetalle = null;
        
        ArrayList detalles = dtoe.getDetalles();
        int cant = detalles.size();
        
        for(int i=0; i<cant; i++){
        
            dtoDatosCajaDetalle = (DTODatosCajaDetalle) detalles.get(i);
            
            if(dtoDatosCajaDetalle.getOidCodigoErrorChequeo()!=null){
                pedidoInconsistente = true;
            }
            
            if(dtoDatosCajaDetalle.getOidListaPicadoDetalle()!=null){
                // Ya existe el registro de detall
                listaPicDet = listaPicDetH.findByPrimaryKey(dtoDatosCajaDetalle.getOidListaPicadoDetalle());
                
                listaPicDet.setUnidadesChequeadas(dtoDatosCajaDetalle.getCantidadChequeada());
                listaPicDet.setCodigoError(dtoDatosCajaDetalle.getOidCodigoErrorChequeo());
                listaPicDet.setNombreChequeador(dtoe.getUsuarioChequeador());
                
                try {
                    listaPicDetH.merge(listaPicDet);
                } catch (PersistenceException e) {
                    ctx.setRollbackOnly();
                    UtilidadesLog.error("Error en merge: ", e);
                    throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }
                
            } else {
                // No existe el registro
                try {
                    listaPicDet = listaPicDetH.create(
                                        null, dtoDatosCajaDetalle.getCantidadChequeada(),null,
                                        dtoe.getNumeroCaja(), null, null, null, null,dtoe.getUsuarioChequeador(),
                                        dtoe.getOidListaPicadoCabecera(), dtoDatosCajaDetalle.getOidMapaCDDetalle(),
                                        dtoe.getOidTipoCajaEmbalaje(), dtoDatosCajaDetalle.getOidProducto(),
                                        ConstantesAPE.OID_SISTEMA_PICADO_MANUAL,null);
                                        
                    listaPicDet.setCodigoError(dtoDatosCajaDetalle.getOidCodigoErrorChequeo());  
                } catch (PersistenceException e) {
                    ctx.setRollbackOnly();
                    UtilidadesLog.error("Error en create o merge: ", e);
                    throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }
              
            }
        }
        
        etiq = etiqH.findByPrimaryKey(dtoe.getOidEtiqueta());
        
        etiq.setHoraInicioChequeo(dtoe.getHoraInicioChequeo());
        etiq.setHoraFinChequeo(dtoe.getHoraFinChequeo());
        etiq.setUsuario(dtoe.getUsuarioChequeador());
        
        if(pedidoInconsistente){
            etiq.setOidEstado(ConstantesAPE.OID_ESTADO_INCONSISTENTE);  
        } else {
            etiq.setOidEstado(ConstantesAPE.OID_ESTADO_CHEQUEADO);  
        }
        
        try {
            etiqH.merge(etiq);
        } catch (PersistenceException e) {
            ctx.setRollbackOnly();
            UtilidadesLog.error("Error en merge: ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        
        // vbongiov -- Cambio APE-012 -- 15/05/2008        
        Long oidCabecera = null;
        if(daoChequeoCajas.todasEtiquetaCheq(dtoe).booleanValue()){
            oidCabecera = daoChequeoCajas.validarClienteChequear(dtoe);
            
            if(oidCabecera != null){
               daoChequeoCajas.actualizarResultRevision(oidCabecera);
            }
        }
    
    } catch (NoResultException e) {
        ctx.setRollbackOnly();
        UtilidadesLog.error("ERROR ", e);
        throw new MareException(e, 
        UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
    }   catch (PersistenceException e) {
        ctx.setRollbackOnly();
        UtilidadesLog.error("ERROR ", e);
        throw new MareException(e, 
        UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
    } 
    
    UtilidadesLog.info("MONChequeoCajas.actualizarCaja(DTODatosCajaCabecera dtoe): Salida");
  }

}