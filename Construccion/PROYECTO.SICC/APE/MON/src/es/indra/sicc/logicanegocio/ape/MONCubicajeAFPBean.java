package es.indra.sicc.logicanegocio.ape;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.ape.DTODatosAgrupacion;
import es.indra.sicc.dtos.ape.DTODatosPallet;
import es.indra.sicc.dtos.ape.DTODatosPallets;
import es.indra.sicc.dtos.ape.DTOImpresionFP;
import es.indra.sicc.logicanegocio.mae.DAOMAEProductos;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.math.BigDecimal;

import java.util.ArrayList;

import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

/**
 * @author Rafael Romero
 * @date 26/03/2007
 */
public class MONCubicajeAFPBean implements SessionBean  {
    
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

    public DTOSalida buscarListaPicadoCubicaje(DTOImpresionFP dtoE) throws MareException {
        UtilidadesLog.debug("MONCubicajeAFPBean.buscarListaPicadoCubicaje(DTOImpresionFP dtoe): Entrada");  
        DTOSalida dtos=(new DAOCubicajeAFP()).buscarListaPicadoCubicaje(dtoE);
        UtilidadesLog.debug("MONCubicajeAFPBean.buscarListaPicadoCubicaje(DTOImpresionFP dtoe): Salida");
        return dtos;
    }

    public DTOSalida buscarListaDatosPallet(DTOOID dtoE) throws MareException {
        UtilidadesLog.debug("MONCubicajeAFPBean.buscarListaDatosPallet(DTOOID dtoe): Entrada");  
        DTOSalida dtos=(new DAOCubicajeAFP()).buscarListaDatosPallet(dtoE);
        UtilidadesLog.debug("MONCubicajeAFPBean.buscarListaDatosPallet(DTOOID dtoe): Salida");
        return dtos;
    }

    public void guardarListaDatosPallets(DTODatosPallets dtoE) throws MareException {
        UtilidadesLog.info("MONCubicajeAFP.guardarListaDatosPallets(DTODatosPallets dtoE): Entrada");
        
        try {
            UtilidadesLog.debug("[ENTRADA] Se recibe el dtoE: " + dtoE);
            ArrayList listaPallets = dtoE.getListaPallets();
            int cantPallets = (listaPallets != null)? listaPallets.size() : 0;
            UtilidadesLog.debug("--- cantidad de elementos (detalles de la cabecera ListPic): " + cantPallets);
            
            if (!(cantPallets > 0)) {
                UtilidadesLog.info("MONCubicajeAFP.guardarListaDatosPallets(DTODatosPallets dtoE): Salida (sin datos entrada)");
                return;
            }
            
            Long oidPais = dtoE.getOidPais();
            Long oidListaPicadCabec = ((DTODatosPallet)listaPallets.get(0)).getOidCabecera(); // Oid de la ListaPicadoCabecera (en comun)
            
            ArrayList numerosCajaActuales = new ArrayList(); // Provenientes de la edicion en pantalla del usuario 
            ArrayList numerosCajaAnteriores = new ArrayList(); // Provenientes de la BBDD (Lista Picado Detalle)
            
            DTODatosPallet dtoDatosPallet = null;
            Long oid = null;
            RecordSet rs = null;
            Long numCaja;
            
            //MaestroProductosLocalHome maeProduLocalHome = MAEEjbLocators.getMaestroProductosLocalHome();
            //MaestroProductosLocal maeProduLocal = null;
            
            DAOCubicajeAFP daoCubicajeAFP = new DAOCubicajeAFP();
            
            UtilidadesLog.debug("----- ListaPicado oid (cabecera): " + oidListaPicadCabec);
            
            for (int i = 0; i < cantPallets; i++) {
                dtoDatosPallet = (DTODatosPallet) listaPallets.get(i);
                oid = dtoDatosPallet.getOid();
                UtilidadesLog.debug("     ---- oid (detalle): " + oid);
                
                if (oid != null) {
                    // Actualizar
                    rs = daoCubicajeAFP.actualizarDatosPallets(dtoDatosPallet);
                    
                    // Actualizar numerosCajaAnteriores con los datos del rs
                    if (rs != null && !rs.esVacio()) {
                        //oidListaPicadCabec = new Long(((BigDecimal) rs.getValueAt(0, "LPCA_OID_LIST_PICA_CABE")).longValue());
                        numCaja = new Long(((BigDecimal) rs.getValueAt(0, "NUM_CAJA")).longValue());
                        
                        UtilidadesLog.debug("         -- numeroCaja anterior: " + numCaja);
                        UtilidadesLog.debug("         -- numeroCaja actual: " + dtoDatosPallet.getNumeroPallet());
                        
                        if (numCaja != null && !numerosCajaAnteriores.contains(numCaja)) {
                            numerosCajaAnteriores.add(numCaja);
                        }
                    }
                    
                } else {
                    // Insertar
                    UtilidadesLog.debug("         -- buscando el Producto con el codigo: " + 
                                        dtoDatosPallet.getCodigoProducto() + 
                                        " y oidPais: " + dtoDatosPallet.getOidPais());
                    // Eliminado - eiraola - 16/08/2007 [INICIO]
                    //try {
                    //    maeProduLocal  = maeProduLocalHome.findByUK(dtoDatosPallet.getOidPais(), 
                    //                                                dtoDatosPallet.getCodigoProducto());
                    //} catch (FinderException fe) {
                    //    UtilidadesLog.error("         -- no se encontro el producto indicado en el Maestro de Productos");
                    //    throw new MareException(fe, UtilidadesError.armarCodigoError(
                    //        CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
                    //}
                    // Eliminado - eiraola - 16/08/2007 [FIN]
                    
                    // Agregado - eiraola - 16/08/2007 [INICIO]
                    DAOMAEProductos daoMaeProductos = new DAOMAEProductos();
                    Long oidProdu = daoMaeProductos.validarCodigoProducto(dtoDatosPallet.getCodigoProducto(), 
                                                                          dtoDatosPallet.getOidPais());
                    if (oidProdu == null) {
                        UtilidadesLog.error("         -- no se encontro el producto indicado en el Maestro de Productos");
                        throw new MareException(new Exception(), UtilidadesError.armarCodigoError(
                            CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
                    }
                    // Agregado - eiraola - 16/08/2007 [FIN]
                    
                    //daoCubicajeAFP.insertarDatosPallets(dtoDatosPallet, maeProduLocal.getOid()); // Eliminado - eiraola - 16/08/2007
                    daoCubicajeAFP.insertarDatosPallets(dtoDatosPallet, oidProdu);                 // Agregado  - eiraola - 16/08/2007
                    
                } // fin else
                
                
                if (dtoDatosPallet.getNumeroPallet() != null && 
                        !numerosCajaActuales.contains(dtoDatosPallet.getNumeroPallet())) {
                    numerosCajaActuales.add(dtoDatosPallet.getNumeroPallet());
                }
                
            } // fin for
            
            daoCubicajeAFP.actualizarTotalDatosCajas(dtoDatosPallet.getOidCabecera()); 
            
            
            // inc BELC400000315 - inicio
            // Eliminar las etiquetas sin caja asignada
            daoCubicajeAFP.eliminarEtiquetas(oidListaPicadCabec, numerosCajaAnteriores);
            // inc BELC400000315 - fin
            
            daoCubicajeAFP.mantieneEtiquetas(oidPais, oidListaPicadCabec, numerosCajaActuales);
        } catch (Exception e) {
            UtilidadesLog.error(" **** No se pudo guardar la Asignacion de Pallets", e);
            ctx.setRollbackOnly();                
            throw new MareException("Error al guardarListaDatosPallets", e);
        }
        UtilidadesLog.info("MONCubicajeAFP.guardarListaDatosPallets(DTODatosPallets dtoE): Salida");
    }

    public DTOSalida verDatosAgrupacion(DTODatosAgrupacion dtoE) throws MareException {
        UtilidadesLog.debug("MONCubicajeAFPBean.verDatosAgrupacion(DTODatosAgrupacion dtoe): Entrada");  
        
        DTOSalida dtos=(new DAOCubicajeAFP()).buscarDatosAgrupacion(dtoE);
        
        UtilidadesLog.debug("MONCubicajeAFPBean.verDatosAgrupacion(DTODatosAgrupacion dtoe): Salida");
        return dtos;
    }
    
}