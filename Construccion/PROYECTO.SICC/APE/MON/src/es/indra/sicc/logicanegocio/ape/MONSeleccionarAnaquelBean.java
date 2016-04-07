/**
 * Copyright 2007 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
package es.indra.sicc.logicanegocio.ape;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.ape.DTOAsignacionProductoAnaquelBusqueda;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.LogAPP;
import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.sicc.dtos.ape.DTOProcesoFueraPedido;


public class MONSeleccionarAnaquelBean implements SessionBean {
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

    /**
     * Metodo de invocacion remota y transaccion 'requerida' que implementa el 
     * CU APE - Seleccionar Anaquel.
     * @author eiraola
     * @since 13/Abr/2007
     */
    public DTOProcesoFueraPedido seleccionarAnaquel(DTOAsignacionProductoAnaquelBusqueda dtoE) 
            throws MareException {
        UtilidadesLog.info("MONSeleccionarAnaquelBean.seleccionarAnaquel(dtoE): Entrada");
        UtilidadesLog.debug("****************** Producto oid: " + dtoE.getOidProducto());
        UtilidadesLog.debug("[ENTRADA] DTOAsignacionProductoAnaquelBusqueda " + dtoE);
        
        DTOProcesoFueraPedido dtoRetorno;
        try {
            UtilidadesLog.debug(" Indicador de producto Fuera de Caja/Bolsa: " + dtoE.getIndFueraCajaBolsa());
            if (dtoE.getIndFueraCajaBolsa().booleanValue()) {
                Long oidLinea = this.productoFueraCajaBolsa(dtoE);
                
                if (oidLinea != null) {
                    UtilidadesLog.debug("--- Utilizamos la Linea FP recuperada "+ oidLinea 
                                        +" (y no la del dto de [ENTRADA])");
                    dtoE.setOidLinea(oidLinea);
                    dtoRetorno = this.productoEnCajaBolsa(dtoE);
                } else {
                    dtoRetorno = null;
                }
            } else {
                dtoRetorno = this.productoEnCajaBolsa(dtoE);
            }
        } catch (MareException me) {
            UtilidadesLog.error("Se produjo una MareException " + me);
            throw me;
        } catch (Exception e) {
            UtilidadesLog.error("Se produjo una Exception " + e);
            throw new MareException(e);
        }
        UtilidadesLog.debug("[SALIDA] DTOProcesoFueraPedido " + dtoRetorno);
        UtilidadesLog.info("MONSeleccionarAnaquelBean.seleccionarAnaquel(dtoE): Salida");
        return dtoRetorno;
    }

    /**
     * Se le da tratamiento a los productos dentro de Caja o de Bolsa
     * @author eiraola
     * @since 13/Abr/2007
     * 
     * CHANGELOG
     * ---------
     * dmorello, 15/10/2008 - Si obtenerAsigAnaqActiFact devuelve null, no se asigna el producto
     *                        y se sale del metodo devolviendo null.
     * dmorello, 03/09/2009 - Cambio 20090839 - Seteo en el DTO a devolver el atributo letraParaAnaquel
     * 
     * sapaza, 17/11/2010 - Cambios para WCS y MUO - Se cambio Flujo en caso no se encuentra Anaquel para el Producto
     */
    private DTOProcesoFueraPedido productoEnCajaBolsa(DTOAsignacionProductoAnaquelBusqueda dtoE) 
            throws MareException {
        UtilidadesLog.info("MONSeleccionarAnaquelBean.productoEnCajaBolsa(dtoE): Entrada");
        DAOSeleccionarAnaquel daoSeleccAnaq = new DAOSeleccionarAnaquel();
        
        DTOSalida dto = daoSeleccAnaq.obtenerAsignacionProductoAnaquel(dtoE);
        RecordSet rs = dto.getResultado();
        DTOProcesoFueraPedido dtoProcFP = null;
        
        if (rs != null && !rs.esVacio()) {
            int cantAsignaciones = rs.getRowCount();
            int i = 0;
            String indSiguienteAsig = null;
            
            for (int pos = 0; pos < cantAsignaciones; pos++) {
                if (rs.getValueAt(pos, "IND_SIGU_ASIG") != null) {
                    indSiguienteAsig = (String)rs.getValueAt(pos, "IND_SIGU_ASIG");
                    if (ConstantesAPE.COD_SGTE_ASIGNACION.equals(indSiguienteAsig)) {
                        i = pos;
                        break;
                    }
                }
            }
            
            if (cantAsignaciones > 1) { // Agregado eiraola Inc. BELC400000571
                daoSeleccAnaq.limpiarFlagSgteAsignacion(new Long(((BigDecimal)rs.getValueAt(i, 
                    "OID_ASIG_PROD_ANAQ")).longValue()));
                
                // Si dto.resultado[i+1] es una posicion valida
                if ((i + 1) < cantAsignaciones) {
                    daoSeleccAnaq.asignarFlagSgteAsignacion(new Long(((BigDecimal)rs.getValueAt((i+1), 
                        "OID_ASIG_PROD_ANAQ")).longValue()));
                } else { // Si no es una posicion valida 
                    if (i != 0) {
                        daoSeleccAnaq.asignarFlagSgteAsignacion(new Long(((BigDecimal)rs.getValueAt(0, 
                            "OID_ASIG_PROD_ANAQ")).longValue()));
                    }
                }
            } // Agregado eiraola Inc. BELC400000571
            
            dtoProcFP = new DTOProcesoFueraPedido();
            
            //Agregado GPons - 07/05/2007 - APE-065
            dtoProcFP.setCodProducto(dtoE.getCodProducto());
            //Fin agregado GPons - 07/05/2007 - APE-065
            
            dtoProcFP.setOidProducto(dtoE.getOidProducto());
            dtoProcFP.setOidSublinea(new Long(((BigDecimal)rs.getValueAt(i, 
                "OID_SUBL_ARMA")).longValue()));
            dtoProcFP.setOidLinea(new Long(((BigDecimal)rs.getValueAt(i, 
                "LIAR_OID_LINE_ARMA")).longValue()));
            dtoProcFP.setOidMapaCDDetalle(new Long(((BigDecimal)rs.getValueAt(i, 
                "OID_MAPA_CENT_DIST_DETA")).longValue()));
            dtoProcFP.setNumeroUnidades((dtoE.getUnidades() == null)
                                        ? null
                                        : new Long(dtoE.getUnidades().longValue()));
            //SCS (15/05/2007) agregado x inc.: 441                            
            /*se elimina dtoProcFP.setOidZonaArmando(new Long(((BigDecimal)rs.getValueAt(i, 
                "IDZONA")).longValue()));*/
            //    
            dtoProcFP.setOidSistemaPicado(new Long(((BigDecimal)rs.getValueAt(i, 
                "SIPI_OID_SIST_PICA")).longValue())); 
            dtoProcFP.setIndFueraCaja(dtoE.getIndFueraCajaBolsa());
            dtoProcFP.setOidConfiguracionCD(dtoE.getOidCD());
            dtoProcFP.setOidConsolidado(dtoE.getOidConsolidado());
            dtoProcFP.setNumeroAnaquel((String)rs.getValueAt(i, "NUM_ANAQ"));
            
            Boolean indImprListaPicad = new Boolean(((BigDecimal)rs.getValueAt(i, 
                "IND_IMPR_LIST_PICA")).intValue() == 1 ? true : false);
            dtoProcFP.setImpresion(indImprListaPicad); 
            
            //SCS (15/05/2007) agregado x inc.: 441                            
            dtoProcFP.setIdZona(new Long(((BigDecimal)rs.getValueAt(i, 
                "IDZONA")).longValue()));
            dtoProcFP.setOidZonaArmando(new Long(((BigDecimal)rs.getValueAt(i, 
                "OIDMAPAZONADETALLE")).longValue()));
            dtoProcFP.setCodigoSublinea(new Long(((BigDecimal)rs.getValueAt(i, 
                "CODIGOSUBLINEA")).longValue()));
            //
            
            // Cambio 20090839
            dtoProcFP.setLetraParaAnaquel((String)rs.getValueAt(i, "LETRAANAQUEL"));
            
            // sapaza -- Cambios para WCS y MUO -- 22/09/2010
            if(rs.getValueAt(i, "NUM_ORD_IMPR_SUBL") != null)
                 dtoProcFP.setNumeroOrdenSubLinea(new Long(((BigDecimal)rs.getValueAt(i, 
                                              "NUM_ORD_IMPR_SUBL")).longValue()));
            
        } else {  // dto.resultado NO posee elementos
            rs = daoSeleccAnaq.obtenerSublineasPostVenta(dtoE);
            
            if (rs == null || rs.esVacio()) {
                // Loguear el error con la descripción de la línea 
                // APE-0048 "No existe Sublínea de postventa para la línea <descripción línea>"
                UtilidadesLog.debug("... procediendo a Loguear error en LogAPP: No existe sublinea postventa...");
                LogAPP.error("[APE] Seleccionar anaquel: No existe Sublínea de postventa para la línea " 
                             + dtoE.getOidLinea());
                UtilidadesLog.info("MONSeleccionarAnaquelBean.productoEnCajaBolsa(dtoE): Salida B");
                return null;
            }
           
            Long oidAnaquel = null;
            if(rs.getValueAt(0, "OID_ASIG_PROD_ANAQ") != null)
                oidAnaquel = new Long(((BigDecimal)rs.getValueAt(0, "OID_ASIG_PROD_ANAQ")).longValue());
            
            Long oidAnaqPVAsignar = new Long(((BigDecimal)rs.getValueAt(0, "OID_MAPA_CENT_DIST_DETA")).longValue());
            daoSeleccAnaq.insertarAnaqPostventa(dtoE.getOidPeriodo(), oidAnaqPVAsignar, dtoE.getOidProducto());
            
            // Se obtiene el anaquel activo para facturación 
            Long oidAnaqActFact = daoSeleccAnaq.obtenerAsigAnaqActivaFact(dtoE.getOidPeriodo(), 
                    dtoE.getOidMapaCDCabecera(), dtoE.getOidLinea()).getOid();
            
            if ((oidAnaqActFact != null) || (oidAnaquel != null)) {
                if(oidAnaquel==null)
                    daoSeleccAnaq.insertarAsigProdAnaq(oidAnaqActFact, oidAnaqPVAsignar, 
                                                   dtoE.getOidProducto(), ConstantesAPE.OID_PROCEDENCIA_BALANCEO);
                else
                    daoSeleccAnaq.actualizarAsigProdAnaq(oidAnaquel, dtoE.getOidProducto(), ConstantesAPE.OID_PROCEDENCIA_BALANCEO);
                
                dtoProcFP = new DTOProcesoFueraPedido();
                dtoProcFP.setOidProducto(dtoE.getOidProducto());
                dtoProcFP.setOidSublinea(new Long(((BigDecimal)rs.getValueAt(0, 
                    "OID_SUBL_ARMA")).longValue()));
                dtoProcFP.setOidLinea(dtoE.getOidLinea());
                dtoProcFP.setOidMapaCDDetalle(new Long(((BigDecimal)rs.getValueAt(0, 
                    "OID_MAPA_CENT_DIST_DETA")).longValue()));
                dtoProcFP.setNumeroUnidades((dtoE.getUnidades() == null)
                                            ? null
                                            : new Long(dtoE.getUnidades().longValue()));
                dtoProcFP.setOidSistemaPicado(new Long(((BigDecimal)rs.getValueAt(0, 
                    "SIPI_OID_SIST_PICA")).longValue()));
                dtoProcFP.setIndFueraCaja(dtoE.getIndFueraCajaBolsa());
                dtoProcFP.setOidConfiguracionCD(dtoE.getOidCD());
                dtoProcFP.setOidConsolidado(dtoE.getOidConsolidado());
                dtoProcFP.setNumeroAnaquel((String)rs.getValueAt(0, "NUM_ANAQ"));
                
                //SCS (15/05/2007) agregado x inc.: 441
                dtoProcFP.setIdZona(new Long(((BigDecimal)rs.getValueAt(0, 
                    "NUM_IDZO")).longValue()));  // eiraola - cambio nombre de campo por query modificada BELC400000576
                dtoProcFP.setOidZonaArmando(new Long(((BigDecimal)rs.getValueAt(0, 
                    "OID_MAPA_ZONA_DETA")).longValue()));  // eiraola - cambio nombre de campo por query modificada BELC400000576
                dtoProcFP.setCodigoSublinea(new Long(((BigDecimal)rs.getValueAt(0, 
                    "COD_SUBL_ARMA")).longValue()));  // eiraola - cambio nombre de campo por query modificada BELC400000576
                //
                
                Boolean indImprListaPicad = new Boolean(((BigDecimal)rs.getValueAt(0, 
                    "IND_IMPR_LIST_PICA")).intValue() == 1 ? true : false);
                dtoProcFP.setImpresion(indImprListaPicad);
                
                // Cambio 20090839
                dtoProcFP.setLetraParaAnaquel((String)rs.getValueAt(0, "VAL_LETR_PARA_ANAQ"));
                
                // sapaza -- Cambios para WCS y MUO -- 22/09/2010
                dtoProcFP.setCodProducto(dtoE.getCodProducto());
                if(rs.getValueAt(0, "NUM_ORD_IMPR_SUBL") != null)
                     dtoProcFP.setNumeroOrdenSubLinea(new Long(((BigDecimal)rs.getValueAt(0, 
                                                  "NUM_ORD_IMPR_SUBL")).longValue()));
            }
            
        }
        UtilidadesLog.info("MONSeleccionarAnaquelBean.productoEnCajaBolsa(dtoE): Salida A");
        return dtoProcFP;
    }

    /**
     * Se le da tratamiento a los productos fuera de caja y bolsa.
     * @author eiraola
     * @since 13/Abr/2007
     * 
     * CHANGELOG
     * ---------
     * Cambio RI 20080528 - dmorello, 08/10/2008
     *   - En la seleccion de linea AFP se elimina condicion de que la linea debe
     *     pertenecer al mapa CD recibido por parametro
     */
    private Long productoFueraCajaBolsa(DTOAsignacionProductoAnaquelBusqueda dtoE) throws MareException {
        UtilidadesLog.info("MONSeleccionarAnaquelBean.productoFueraCajaBolsa(dtoE): Entrada");
        
        DAOSeleccionarAnaquel daoSeleccAnaq = new DAOSeleccionarAnaquel();
        
        DTOOIDs lineasTipoSolicitud = daoSeleccAnaq.obtenerLineasTipoSolicitud(dtoE.getOidTipoSolicitudPais());
        
        DTOSalida dtoSalida = daoSeleccAnaq.obtenerLineasAFP(dtoE, lineasTipoSolicitud);
        RecordSet rs = dtoSalida.getResultado();

        if (rs != null && !rs.esVacio()) {
            int cantLineasAFP = rs.getRowCount();
            
            Integer indTipoSolicitud = null;
            
            Long oidLinea;
            
            for (int i = 0; i < cantLineasAFP; i++) {
                oidLinea = new Long(((BigDecimal)rs.getValueAt(i, "OID_LINE_ARMA")).longValue());
                indTipoSolicitud = new Integer(((BigDecimal)rs.getValueAt(i, "INDTIPOSOLICITUD")).intValue());
                
                // Si algún elemento de la lista posee indTipoSolicitud en TRUE 
                if (ConstantesAPE.TRUE.equals(indTipoSolicitud)) {
                    UtilidadesLog.info("MONSeleccionarAnaquelBean.productoFueraCajaBolsa(dtoE): Salida A");
                    return oidLinea;
                }
            }
        }

        // Si la lista lstLineas no posee elementos o ninguno posee indLineaMapaCD en TRUE
        // se loguea el error
        UtilidadesLog.debug("... procediendo a Loguear error en LogAPP: No existe linea de fuera de pedido...");
                LogAPP.error("[APE] Seleccionar anaquel: No existe Línea de fuera de pedido para el tipo de solicitud "
                             + dtoE.getOidTipoSolicitudPais());

        UtilidadesLog.info("MONSeleccionarAnaquelBean.productoFueraCajaBolsa(dtoE): Salida C");
        return null;
    }
    
}