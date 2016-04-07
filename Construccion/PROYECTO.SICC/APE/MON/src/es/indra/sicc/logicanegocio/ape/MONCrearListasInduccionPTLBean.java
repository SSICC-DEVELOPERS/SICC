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

import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.ape.DTOListaPicadoCabecera;
import es.indra.sicc.dtos.ape.DTOListaPicadoDetalle;
import es.indra.sicc.dtos.intsys.DTODetalleCaja;
import es.indra.sicc.dtos.intsys.DTODetalleCajaProducto;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.sicc.dtos.intsys.DTOListaPicadoInduccionPTL;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.entidades.ape.EtiquetasLocalHome;
import es.indra.sicc.entidades.ape.EtiquetasLocal;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class MONCrearListasInduccionPTLBean implements SessionBean  {
  public void ejbCreate() { }
  public void ejbActivate() { }
  public void ejbPassivate() { }
  public void ejbRemove() { }
  public void setSessionContext(SessionContext ctx) { }

   /**
    * Sistema:     Belcorp
    * Modulo:      APE
    * Fecha:       28/02/2007
    * @version     1.0
    * @autor       Viviana Bongiovanni
    * @deprecated  14/09/2007 NO UTILIZAR mas este metodo porque se cambio el contenido del 
    *              DTO que viene de PTL-3
    */
    
  /* Modificado por: Cristian Valenzuela
     Fecha: 24/05/2007
     Incidencia: BELC400000431  */
     
  public void crearListasPicadoInduccionPTL_DISABLED(DTOListaPicadoInduccionPTL dtoe) throws MareException {
      UtilidadesLog.info("MONCrearListasInduccionPTL.crearListasPicadoInduccionPTL"+
      "(DTOListaPicadoInduccionPTL dtoe): Entrada");
      UtilidadesLog.debug("*** DTOListaPicadoInduccionPTL: " + dtoe);
      
      BelcorpService bs;
      RecordSet rs;
      String codigoError;
      StringBuffer query = new StringBuffer();
      
      query.append(" SELECT cabecera.OID_LIST_PICA_CABE,  ");
      query.append(" to_char(cabecera.FEC_HORA_FINA_EMBA, 'yyyy-MM-dd HH24:MI:SS') as FECHA, ");
      query.append(" cabecera.SOCA_OID_SOLI_CABE, ");
      query.append(" cabecera.NUM_TOTA_CAJA, ");
      query.append(" cabecera.VAL_NOMB_FACT, ");
      query.append(" detalle.OID_LIST_PICA_DETA, ");
      query.append(" detalle.NUM_CODI_POSI, ");
      query.append(" detalle.NUM_UNID_PROD, ");
      query.append(" detalle.VAL_LINE, ");
      query.append(" detalle.NUM_CAJA, ");
      query.append(" detalle.IND_IMPR, ");
      query.append(" detalle.VAL_NOMB_PICA, ");
      query.append(" detalle.NUM_UNID_PICA, ");
      query.append(" detalle.NUM_UNID_CHEQ, ");
      query.append(" detalle.LPCA_OID_LIST_PICA_CABE, ");
      query.append(" detalle.TCEM_OID_TIPO_CAJA_EMBA, ");
      query.append(" detalle.MCDD_OID_MAPA_CENT_DIST_DETA, ");
      query.append(" detalle.SIPI_OID_SIST_PICA, ");
      query.append(" detalle.PROD_OID_PROD, ");
      query.append(" detalle.VAL_NOMB_CHEQ, ");
      query.append(" productos.COD_SAP ");
      query.append(" FROM APE_LISTA_PICAD_CABEC cabecera, ");
      query.append(" APE_LISTA_PICAD_DETAL detalle, ");
      query.append(" MAE_PRODU productos ");
      query.append(" WHERE cabecera.SOCA_OID_SOLI_CABE = " + dtoe.getNroFactura());
      query.append(" AND cabecera.OID_LIST_PICA_CABE = detalle.LPCA_OID_LIST_PICA_CABE ");      
      query.append(" AND detalle.PROD_OID_PROD = productos.OID_PROD ");        
      
      try {
        bs = BelcorpService.getInstance();
        rs = bs.dbService.executeStaticQuery(query.toString());
      }
      catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
      }
      catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
      }     
      
      DTOListaPicadoCabecera dtoCabecera = new DTOListaPicadoCabecera();     
      
      if(!rs.esVacio())  {
        UtilidadesLog.debug("*** Obtiene datos para DTOListaPicadoCabecera");
        ArrayList detalles = new ArrayList();
        
        BigDecimal oidCabecera = (BigDecimal)rs.getValueAt(0, "OID_LIST_PICA_CABE");
        String strFecha = (String)rs.getValueAt(0, "FECHA");
        UtilidadesLog.debug("*** FECHA : " + strFecha);               
        BigDecimal oidConsolidado = (BigDecimal)rs.getValueAt(0, "SOCA_OID_SOLI_CABE");
        BigDecimal numTotaCaja = (BigDecimal)rs.getValueAt(0, "NUM_TOTA_CAJA");
        String nomFact = (String)rs.getValueAt(0, "VAL_NOMB_FACT");
        
        dtoCabecera.setOid(new Long(oidCabecera.longValue()));
        dtoCabecera.setStrFechaHoraFinEmbalaje(strFecha);

        if(oidConsolidado!=null) {
            dtoCabecera.setOidSolicitudCAbecera(new Long(oidConsolidado.longValue()));    
        }
        if(numTotaCaja!=null) {
            dtoCabecera.setNumeroTotalCajas(new Long(numTotaCaja.longValue()));
        }
        if(nomFact!=null) {
            dtoCabecera.setNombreFacturador(nomFact);
        }
        
        UtilidadesLog.debug("*** DTOListaPicadoCabecera: " + dtoCabecera);        
        int cant = rs.getRowCount();
        UtilidadesLog.debug("*** cant: " + cant);
        
        for(int i=0; i<cant; i++) {
            UtilidadesLog.debug("*** Obtiene datos para DTOListaPicadoDetalle");
            DTOListaPicadoDetalle dtoDetalle = new DTOListaPicadoDetalle();
            
            BigDecimal oid = (BigDecimal)rs.getValueAt(i, "OID_LIST_PICA_DETA");
            BigDecimal numCodiPosi = (BigDecimal)rs.getValueAt(i, "NUM_CODI_POSI");
            BigDecimal numUnidProd = (BigDecimal)rs.getValueAt(i, "NUM_UNID_PROD");
            BigDecimal valLine = (BigDecimal)rs.getValueAt(i, "VAL_LINE");
            BigDecimal numCaja = (BigDecimal)rs.getValueAt(i, "NUM_CAJA");
            String indImpr = (String)rs.getValueAt(i, "IND_IMPR");
            String valNombPica = (String)rs.getValueAt(i, "VAL_NOMB_PICA");
            BigDecimal numUnidPica = (BigDecimal)rs.getValueAt(i, "NUM_UNID_PICA");
            BigDecimal numUnidCheq = (BigDecimal)rs.getValueAt(i, "NUM_UNID_CHEQ");
            BigDecimal oidListaCabecera = (BigDecimal)rs.getValueAt(i, "LPCA_OID_LIST_PICA_CABE");
            BigDecimal oidTipoCaja = (BigDecimal)rs.getValueAt(i, "TCEM_OID_TIPO_CAJA_EMBA");
            BigDecimal oidMapaCentro = (BigDecimal)rs.getValueAt(i, "MCDD_OID_MAPA_CENT_DIST_DETA");
            BigDecimal oidSistemaPica = (BigDecimal)rs.getValueAt(i, "SIPI_OID_SIST_PICA");
            BigDecimal oidProducto = (BigDecimal)rs.getValueAt(i, "PROD_OID_PROD");
            String nomCheq = (String)rs.getValueAt(i, "VAL_NOMB_CHEQ");
            String codSap = (String)rs.getValueAt(i, "COD_SAP");
            
            dtoDetalle.setOid(new Long(oid.longValue()));
            dtoDetalle.setCodigoPosicion(new Long(numCodiPosi.longValue()));            
            dtoDetalle.setUnidadesProducto(new Long(numUnidProd.longValue()));
            dtoDetalle.setValorLinea(valLine);
            
            if(numCaja!=null) {
                dtoDetalle.setNumeroCaja(new Long(numCaja.longValue()));    
            }
            
            if(indImpr!=null) {
                if(indImpr.equals("N"))  {
                    dtoDetalle.setIndicadorImpresion(Boolean.FALSE);        
                }
                else  {
                    dtoDetalle.setIndicadorImpresion(Boolean.TRUE);
                }
            }            
            
            dtoDetalle.setNombrePicador(valNombPica);
            
            if(numUnidPica!=null) {
                dtoDetalle.setUnidadesPicadas(new Long(numUnidPica.longValue()));    
            }
            
            if(numUnidCheq!=null) {
                dtoDetalle.setUnidadesChequeadas(new Long(numUnidCheq.longValue()));    
            }
            
            dtoDetalle.setOidCabecera(new Long(oidListaCabecera.longValue()));
            
            if(oidTipoCaja!=null) {
                dtoDetalle.setOidTipoCajaEmbalaje(new Long(oidTipoCaja.longValue()));    
            }
            
            dtoDetalle.setOidMapaCDDetalle(new Long(oidMapaCentro.longValue()));
            dtoDetalle.setOidSistemaPicado(new Long(oidSistemaPica.longValue()));
            dtoDetalle.setOidProducto(new Long(oidProducto.longValue()));
            dtoDetalle.setNombreChequeador(nomCheq);    
            dtoDetalle.setCodigoSAP(codSap);
            dtoDetalle.setNumeroAnaquel(dtoe.getAnaquel());
            
            detalles.add(dtoDetalle);
        }
        
        dtoCabecera.setDetalles(detalles);
        UtilidadesLog.debug("*** DTOListaPicadoCabecera (completo)" + dtoCabecera);
        
        boolean detalleActualizado = false; 
        ArrayList detallesEliminados = new ArrayList();
        DTOListaPicadoDetalle detalleNuevo = null;   
        
        if(dtoCabecera.getNumeroTotalCajas()!=null && dtoe.getNroOriginalCajasFactura()!=null) {
            if(dtoCabecera.getNumeroTotalCajas().longValue() ==
               dtoe.getNroOriginalCajasFactura().longValue()) {                
                UtilidadesLog.debug("*** 1 - sale del metodo");                                
                return;
            }            
        }
        
        if(dtoCabecera.getNumeroTotalCajas()!=null && dtoe.getNroOriginalCajasFactura()!=null) {
            if((dtoCabecera.getNumeroTotalCajas().longValue() != 
            dtoe.getNroOriginalCajasFactura().longValue()) &&
            (dtoCabecera.getNumeroTotalCajas().longValue() != 1 &&
            dtoe.getNroOriginalCajasFactura().longValue() !=1)) {             
                UtilidadesLog.debug("*** 2 - se setea numero total cajas");                
                dtoCabecera.setNumeroTotalCajas(dtoe.getNroOriginalCajasFactura());             
            }            
        }
        
        if(dtoCabecera.getStrFechaHoraFinEmbalaje()==null) {         
            UtilidadesLog.debug("*** 3 - se setea fecha de sistema");   
            java.util.Date fechaSistema = new java.util.Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String strFechaTemp = sdf.format(fechaSistema);            
            UtilidadesLog.debug("*** strFechaTemp " + strFechaTemp);   
            dtoCabecera.setStrFechaHoraFinEmbalaje(strFechaTemp);
        }
           
        if(dtoCabecera.getNombreFacturador()==null) {                
            UtilidadesLog.debug("*** 4 - se setea nombre facturador");                   
            dtoCabecera.setNombreFacturador(dtoe.getOperadorIntroduccionFactura());
        }
        
        DAOCrearListasInduccionPTL dao = new DAOCrearListasInduccionPTL();
        UtilidadesLog.debug("*** Llamando a buscarUltimoCodigoPosicion");        
        Long ultimoCodigoPosicion = dao.buscarUltimoCodigoPosicion(dtoCabecera.getOid());
        UtilidadesLog.debug("*** ultimoCodigoPosicion " + ultimoCodigoPosicion);        
        
        ArrayList deta = dtoCabecera.getDetalles();     
        
        for(int i=0; i<deta.size(); i++) {
            DTOListaPicadoDetalle dtoDetalle = (DTOListaPicadoDetalle)deta.get(i);
            UtilidadesLog.debug("*** i " + i);        
            UtilidadesLog.debug("*** DTOListaPicadoDetalle " + dtoDetalle);        
            
            if(dtoe.getNroCaja()!=null && dtoe.getNroCaja().longValue()==1)  {            
                if(dtoDetalle.getOidSistemaPicado()!=null &&                 
                dtoDetalle.getOidSistemaPicado().longValue() ==
                ConstantesAPE.OID_SISTEMA_PICADO_MANUAL.longValue()) {        
                    
                    UtilidadesLog.debug("*** 5 - se setea numero caja");
                    
                    dtoDetalle.setNumeroCaja(new Long(1));         
                }               
            }
            
            if((dtoDetalle.getCodigoSAP().equals(dtoe.getCodigoProducto())) &&
               (dtoDetalle.getNombrePicador()==null) &&
               (detalleActualizado==false))  {
            
               UtilidadesLog.debug("*** 6 - se setean datos para DTOListaPicadoDetalle");                 
               UtilidadesLog.debug(" y detalleActualizado = true");                 
               
               dtoDetalle.setNumeroCaja(dtoe.getNroCaja());
               // vbongiov -- BELC400000582 --23/07/2007 
               //dtoDetalle.setNumeroAnaquel(dtoe.getAnaquel());
               dtoDetalle.setUnidadesProducto(dtoe.getCantidadRequeridaPicar());
               dtoDetalle.setUnidadesPicadas(dtoe.getCantidadActualPicada());
               dtoDetalle.setNombrePicador(dtoe.getNombrePicadorProducto());
               detalleActualizado = true;                
            }            
            else if((dtoDetalle.getCodigoSAP().equals(dtoe.getCodigoProducto())) &&
                    (dtoDetalle.getNombrePicador()==null) &&
                    (detalleActualizado==true)) {
                
                UtilidadesLog.debug("*** 7 - se setean oids de DTOListaPicadoDetalle.oid");                 
                UtilidadesLog.debug(" a DTOOIDs.oids[] ");    
                
                detallesEliminados.add(dtoDetalle.getOid());                
                UtilidadesLog.debug(" se borra el elemento de DTOListaPicadoCabecera.detalles");                                                 
                deta.remove(i);
            }
            else if((dtoDetalle.getCodigoSAP().equals(dtoe.getCodigoProducto())) &&
                    (dtoDetalle.getNombrePicador()!=null) &&
                    (detalleNuevo==null)) {
                UtilidadesLog.debug("*** 8 - se setean datos a detalleNuevo");   
                
                detalleNuevo = new DTOListaPicadoDetalle();
                detalleNuevo.setNumeroCaja(dtoe.getNroCaja());
                detalleNuevo.setNumeroAnaquel(dtoe.getAnaquel());
                detalleNuevo.setUnidadesProducto(dtoe.getCantidadRequeridaPicar());            
                detalleNuevo.setUnidadesPicadas(dtoe.getCantidadActualPicada());
                detalleNuevo.setNombrePicador(dtoe.getNombrePicadorProducto());
                detalleNuevo.setCodigoPosicion(new Long(ultimoCodigoPosicion.longValue() + 1));
                detalleNuevo.setOidCabecera(dtoDetalle.getOidCabecera());
                detalleNuevo.setOidMapaCDDetalle(dtoDetalle.getOidMapaCDDetalle());
                detalleNuevo.setOidSistemaPicado(ConstantesAPE.OID_SISTEMA_PICADO_MANUAL);
                detalleNuevo.setOidProducto(dtoDetalle.getOidProducto());
                detalleNuevo.setIndicadorImpresion(dtoDetalle.getIndicadorImpresion());
                detalleNuevo.setUnidadesChequeadas(dtoDetalle.getUnidadesChequeadas());
                detalleNuevo.setNombreChequeador(dtoDetalle.getNombreChequeador());
                detalleNuevo.setOidTipoCajaEmbalaje(dtoDetalle.getOidTipoCajaEmbalaje());
                detalleNuevo.setValorLinea(dtoDetalle.getValorLinea());
            }
            
            try {
                EtiquetasLocalHome elh = new EtiquetasLocalHome();
                EtiquetasLocal el = elh.findByListaPicCabecCaja(dtoDetalle.getOidCabecera(),
                dtoDetalle.getNumeroCaja());
                
                if(el.getNumeroCaja()!=null && dtoe.getNroCaja()!=null) {
                    if(el.getNumeroCaja().longValue() == dtoe.getNroCaja().longValue()) {
                    
                        if(el.getSolicitudCabecera()!=null && dtoe.getNroFactura()!=null) {
                            if(el.getSolicitudCabecera().longValue() == dtoe.getNroFactura().longValue())  {                                
                            
                                if(dtoe.getOperadorChequeoCajaFactura()!=null) {
                                    try {
                                        if(dtoe.getOperadorChequeoCajaFactura().equals("1")) {
                                            UtilidadesLog.debug("*** 9 - seteando estado embalado");   
                                            el.setOidEstado(ConstantesAPE.OID_ESTADO_PEDIDO_EMBALADO);
                                        }   
                                        else  {
                                            UtilidadesLog.debug("*** 10 - seteando estado terminado");   
                                            el.setOidEstado(ConstantesAPE.OID_ESTADO_PEDIDO_TERMINADO);
                                        }//fin else
                                        elh.merge(el);
                                    } catch (PersistenceException e) {
                                        // dmorello, 20/10/2008: tal como se hace en los dos siguiente
                                        // bloques catch, no se tira una excepcion...
                                        UtilidadesLog.error("ERROR ", e);
                                    }
                                }//fin if
                            }//fin if   
                        }//fin if
                    }//fin if               
                }//fin if                
            } catch (NoResultException e) {
                // dmorello, 20/10/2008: Al llegar a este codigo durante la migracion
                // se encuentra que no se lanza una excepcion aqui - se deja tal cual
                UtilidadesLog.error("ERROR ", e);
            } catch (PersistenceException e) {
                // dmorello, 20/10/2008: Al llegar a este codigo durante la migracion
                 // se encuentra que no se lanza una excepcion aqui - se deja tal cual
                UtilidadesLog.error("ERROR ", e);
            }                 
        } // fin for
        
        UtilidadesLog.debug("*** Llamando a actualizarListaPicado");   
        dao.actualizarListaPicado(dtoCabecera);
        
        if(detallesEliminados!=null && detallesEliminados.size()>0) {
            UtilidadesLog.debug("*** Llamando a eliminarDetalles");   
            int cantidad = detallesEliminados.size();
            UtilidadesLog.debug("*** cantidad:" + cantidad);   
            Long[] oids = new Long[cantidad];
            for(int i=0; i<cantidad; i++) {
                oids[i] = (Long)detallesEliminados.get(i);
            }            
            dao.eliminarDetalles(oids);    
        }
        
        
        if(detalleNuevo!=null) {
            UtilidadesLog.debug("*** Llamando a insertarListaPicadoDetalle");   
            ArrayList arr = new ArrayList();
            arr.add(detalleNuevo);
            dao.insertarListaPicadoDetalle(arr);
        }
      }
      
      UtilidadesLog.info("MONCrearListasInduccionPTL.crearListasPicadoInduccionPTL"+
      "(DTOListaPicadoInduccionPTL dtoe): Salida");
  }


    /**
     * Reemplaza al metodo ahora denominado: "crearListasPicadoInduccionPTL_DISABLED"
     * Creado por Inc.BELC400000715 (Un archivo de PTL-3 contiene multiples Cajas de una Factura
     * y cada Caja tiene multiples Productos).
     * @author eiraola
     * @since 17/Sep/2007
     */
    public void crearListasPicadoInduccionPTL(DTOListaPicadoInduccionPTL dtoe) throws MareException {
        UtilidadesLog.info("MONCrearListasInduccionPTL.crearListasPicadoInduccionPTL"+
                           "(DTOListaPicadoInduccionPTL dtoe): Entrada");
        
        if (dtoe.getDetallesCaja() == null || dtoe.getDetallesCaja().size() == 0) {
            UtilidadesLog.debug(" .... No hay Cajas para procesar.");
            UtilidadesLog.info("MONCrearListasInduccionPTL.crearListasPicadoInduccionPTL"+
                           "(DTOListaPicadoInduccionPTL dtoe): Salida A");
            return;
        }
        
        // - Hacer una consulta en la entidad ListaPicadoCabecera y ListaPicadoDetalle 
        // filtrando en ListaPicadoCabecera por consolidado y en detalla por oidCabecera.
        BelcorpService bs;
        RecordSet rs;
        StringBuffer query = new StringBuffer();
        
        query.append(" SELECT cabecera.OID_LIST_PICA_CABE,  ");
        query.append(" to_char(cabecera.FEC_HORA_FINA_EMBA, 'yyyy-MM-dd HH24:MI:SS') as FECHA, ");
        query.append(" cabecera.SOCA_OID_SOLI_CABE, ");
        query.append(" cabecera.NUM_TOTA_CAJA, ");
        query.append(" cabecera.VAL_NOMB_FACT, ");
        query.append(" detalle.OID_LIST_PICA_DETA, ");
        query.append(" detalle.NUM_CODI_POSI, ");
        query.append(" detalle.NUM_UNID_PROD, ");
        query.append(" detalle.VAL_LINE, ");
        query.append(" detalle.NUM_CAJA, ");
        query.append(" detalle.IND_IMPR, ");
        query.append(" detalle.VAL_NOMB_PICA, ");
        query.append(" detalle.NUM_UNID_PICA, ");
        query.append(" detalle.NUM_UNID_CHEQ, ");
        query.append(" detalle.LPCA_OID_LIST_PICA_CABE, ");
        query.append(" detalle.TCEM_OID_TIPO_CAJA_EMBA, ");
        query.append(" detalle.MCDD_OID_MAPA_CENT_DIST_DETA, ");
        query.append(" (SELECT mcdd.NUM_ANAQ ");
		query.append("    FROM APE_MAPA_CENTR_DISTR_DETAL mcdd ");
        query.append("   WHERE mcdd.OID_MAPA_CENT_DIST_DETA = detalle.MCDD_OID_MAPA_CENT_DIST_DETA) AS NUM_ANAQ, ");
        query.append(" detalle.SIPI_OID_SIST_PICA, ");
        query.append(" detalle.PROD_OID_PROD, ");
        query.append(" detalle.VAL_NOMB_CHEQ, ");
        query.append(" productos.COD_SAP ");
        query.append(" FROM APE_LISTA_PICAD_CABEC cabecera, ");
        query.append(" APE_LISTA_PICAD_DETAL detalle, ");
        query.append(" MAE_PRODU productos ");
        query.append(" WHERE cabecera.SOCA_OID_SOLI_CABE = ");
        query.append("  (SELECT psc.OID_SOLI_CABE ");
        query.append("     FROM PED_SOLIC_CABEC psc ");
        query.append("    WHERE psc.PAIS_OID_PAIS = " + dtoe.getOidPais());
        query.append("      AND psc.VAL_NUME_SOLI = " + dtoe.getNumeroConsolidado() + ") ");
        query.append(" AND cabecera.OID_LIST_PICA_CABE = detalle.LPCA_OID_LIST_PICA_CABE ");      
        query.append(" AND detalle.PROD_OID_PROD = productos.OID_PROD ");     
        
        try {
            bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            String codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            String codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        
        
        // - Asginar el resultado de la consulta en el DTOListaPicadoCabecera, con sus detalles.
        DTOListaPicadoCabecera dtoCabecera = new DTOListaPicadoCabecera();
        
        boolean detalleActualizado = false;
        ArrayList detallesEliminados = new ArrayList();
        // Cambio APE-07 - dmorello, 20/02/2008
        //DTOListaPicadoDetalle detalleNuevo = null;
        boolean detallePicadoActualizado = false;
        // Fin cambio APE-07 - dmorello, 20/02/2008
      
        if (!rs.esVacio()) {
            DAOCrearListasInduccionPTL daoCrearListasIndPTL = new DAOCrearListasInduccionPTL();
            UtilidadesLog.debug("*** Armando el DTOListaPicadoCabecera con los datos de la consulta...");
            ArrayList detalles = new ArrayList();
            Long oidListaPicadoCabec = new Long( ((BigDecimal)rs.getValueAt(0, "OID_LIST_PICA_CABE")).longValue() );
            dtoCabecera.setOid(oidListaPicadoCabec);
            
            if (rs.getValueAt(0, "FECHA") != null) {
                dtoCabecera.setStrFechaHoraFinEmbalaje((String)rs.getValueAt(0, "FECHA"));
            }
            Long oidSolicitudCabecera = new Long( ((BigDecimal)rs.getValueAt(0, "SOCA_OID_SOLI_CABE")).longValue() );
            dtoCabecera.setOidSolicitudCAbecera(oidSolicitudCabecera);
            
            if (rs.getValueAt(0, "NUM_TOTA_CAJA") != null) {
                dtoCabecera.setNumeroTotalCajas(new Long( ((BigDecimal)rs.getValueAt(0, "NUM_TOTA_CAJA")).longValue() ));
            }
            
            if (rs.getValueAt(0, "VAL_NOMB_FACT") != null) {
                dtoCabecera.setNombreFacturador((String)rs.getValueAt(0, "VAL_NOMB_FACT"));
            }
            
            UtilidadesLog.debug("*** DTOListaPicadoCabecera: " + dtoCabecera);
            int cant = rs.getRowCount();
            UtilidadesLog.debug("*** cant: " + cant);
            
            DTOListaPicadoDetalle dtoDetalle;
            UtilidadesLog.debug("*** Armando los DTOListaPicadoDetalle con los datos de la consulta...");
            
            for(int i=0; i < cant; i++) {
                UtilidadesLog.debug("*** detalle... " + i);
                dtoDetalle = new DTOListaPicadoDetalle();
                
                dtoDetalle.setOid(new Long( ((BigDecimal)rs.getValueAt(i, "OID_LIST_PICA_DETA")).longValue() ));
                dtoDetalle.setCodigoPosicion(new Long( ((BigDecimal)rs.getValueAt(i, "NUM_CODI_POSI")).longValue() ));
                dtoDetalle.setUnidadesProducto(new Long( ((BigDecimal)rs.getValueAt(i, "NUM_UNID_PROD")).longValue() ));
                
                if (rs.getValueAt(i, "VAL_LINE") != null) {
                    dtoDetalle.setValorLinea((BigDecimal)rs.getValueAt(i, "VAL_LINE"));
                }
                if (rs.getValueAt(i, "NUM_CAJA") != null) {
                    dtoDetalle.setNumeroCaja(new Long( ((BigDecimal)rs.getValueAt(i, "NUM_CAJA")).longValue() ));
                }
                if (rs.getValueAt(i, "IND_IMPR") != null) {
                    String indImpr = (String)rs.getValueAt(i, "IND_IMPR");
                    
                    if (indImpr.equals(ConstantesAPE.TRUE.toString())) {
                        dtoDetalle.setIndicadorImpresion(Boolean.TRUE);
                    } else {
                        dtoDetalle.setIndicadorImpresion(Boolean.FALSE);
                    }
                }
                if (rs.getValueAt(i, "VAL_NOMB_PICA") != null) {
                    dtoDetalle.setNombrePicador((String)rs.getValueAt(i, "VAL_NOMB_PICA"));
                }
                if (rs.getValueAt(i, "NUM_UNID_PICA") != null) {
                    dtoDetalle.setUnidadesPicadas(new Long( ((BigDecimal)rs.getValueAt(i, "NUM_UNID_PICA")).longValue() ));    
                }
                if (rs.getValueAt(i, "NUM_UNID_CHEQ") != null) {
                    dtoDetalle.setUnidadesChequeadas(new Long( ((BigDecimal)rs.getValueAt(i, "NUM_UNID_CHEQ")).longValue() ));    
                }
                
                dtoDetalle.setOidCabecera(oidListaPicadoCabec);
                
                if (rs.getValueAt(i, "TCEM_OID_TIPO_CAJA_EMBA") != null) {
                    dtoDetalle.setOidTipoCajaEmbalaje(new Long( 
                            ((BigDecimal)rs.getValueAt(i, "TCEM_OID_TIPO_CAJA_EMBA")).longValue() )); 
                }
                
                dtoDetalle.setOidMapaCDDetalle(new Long( 
                        ((BigDecimal)rs.getValueAt(i, "MCDD_OID_MAPA_CENT_DIST_DETA")).longValue() ));
                dtoDetalle.setNumeroAnaquel((String)rs.getValueAt(i, "NUM_ANAQ"));
                dtoDetalle.setOidSistemaPicado(new Long( ((BigDecimal)rs.getValueAt(i, "SIPI_OID_SIST_PICA")).longValue() ));
                dtoDetalle.setOidProducto(new Long( ((BigDecimal)rs.getValueAt(i, "PROD_OID_PROD")).longValue() ));
                
                if (rs.getValueAt(i, "VAL_NOMB_CHEQ") != null) {
                    dtoDetalle.setNombreChequeador((String)rs.getValueAt(i, "VAL_NOMB_CHEQ"));
                }
                if (rs.getValueAt(i, "COD_SAP") != null) {
                    dtoDetalle.setCodigoSAP((String)rs.getValueAt(i, "COD_SAP"));
                }
                
                UtilidadesLog.debug("*** DTOListaPicadoDetalle: " + dtoDetalle);
                detalles.add(dtoDetalle);
            } // fin for
            
            dtoCabecera.setDetalles(detalles);
            UtilidadesLog.debug("*** DTOListaPicadoCabecera (completo): " + dtoCabecera);
            
            Long numeroTotalCajasSicc = dtoCabecera.getNumeroTotalCajas();
            UtilidadesLog.debug(" ---> En Sicc el numero total de cajas es: " + numeroTotalCajasSicc);
            
            
            ArrayList detallesCaja = dtoe.getDetallesCaja();
            int cantCajas = detallesCaja.size();
            UtilidadesLog.debug(" Cantidad Cajas de archivo PTL-3: " + cantCajas);
            DTODetalleCaja dtoDetalleCaja;
            
            for (int i = 0; i < cantCajas; i++) { // FOR (SO:)
                UtilidadesLog.debug(" ========== Detalle de Caja =========== i: " + i);
                dtoDetalleCaja = (DTODetalleCaja)detallesCaja.get(i);
                
                if (i == 0) { // Actualizaremos la cabecera solamente con datos de la primera caja (SO:)
                    if (numeroTotalCajasSicc!=null && dtoDetalleCaja.getNumeroTotalCajas()!=null) {
                        
                        if (numeroTotalCajasSicc.equals(dtoDetalleCaja.getNumeroTotalCajas())) {
                            if (numeroTotalCajasSicc.equals(new Long(1))) {
                                UtilidadesLog.debug("*** 1 - Finaliza el CU: Era una unica Caja en Sicc igual que Ptl");
                                return;
                            }
                        } else { // La cant cajas es distinta en Sicc y en la Interfaz
                            UtilidadesLog.debug("*** 2 - Se actualiza NumeroTotalCajas del dto");
                            dtoCabecera.setNumeroTotalCajas(dtoDetalleCaja.getNumeroTotalCajas());
                        }
                        
                    } else {
                        throw new MareException("Numero Total de Cajas es nulo");
                    }
                    
                    
                    if (dtoCabecera.getStrFechaHoraFinEmbalaje()==null) {
                        UtilidadesLog.debug("*** 3 - Se setea fecha de sistema en Fecha Fin Embalaje de Cabecera");
                        java.util.Date fechaSistema = new java.util.Date();
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                        String strFechaTemp = sdf.format(fechaSistema);
                        UtilidadesLog.debug("*** strFechaTemp " + strFechaTemp);
                        dtoCabecera.setStrFechaHoraFinEmbalaje(strFechaTemp);
                    }
                    
                    if (dtoCabecera.getNombreFacturador()==null) {
                        UtilidadesLog.debug("*** 4 - Se setea nombre facturador en Cabecera");
                        dtoCabecera.setNombreFacturador(dtoDetalleCaja.getOperadorIntroduccionFactura());
                    }
                } // fin if i == 0
                
                
                
                ArrayList detallesCajaProducto = dtoDetalleCaja.getDetallesCajaProducto();
                int cantProductos = detallesCajaProducto.size();
                UtilidadesLog.debug(" Cantidad de Productos en la caja: " + cantProductos);
                DTODetalleCajaProducto dtoDetalleCajaProducto;
                
                ArrayList deta = dtoCabecera.getDetalles();
                
                for (int j = 0; j < cantProductos; j++) { // FOR (SS:)
                    UtilidadesLog.debug(" ------- Detalle de Caja-Producto ------- j: " + j);
                    dtoDetalleCajaProducto = (DTODetalleCajaProducto)detallesCajaProducto.get(j);
                    
                    // Cambio APE-07 - dmorello, 20/02/2008
                    //detalleNuevo = null;
                    detallePicadoActualizado = false;
                    // Fin cambio APE-07 - dmorello, 20/02/2008
                    
                    
                    // - Para cada detalle de DTOListaPicadoCabecera.detalle
                    detalleActualizado = false;
                    
                    for (int k = 0; k < deta.size(); k++) {
                        dtoDetalle = (DTOListaPicadoDetalle)deta.get(k);
                        UtilidadesLog.debug("*** DTOListaPicadoDetalle (k: "+ k +") " + dtoDetalle);
                        
                        if (dtoDetalleCaja.getNroCaja() != null && dtoDetalleCaja.getNroCaja().longValue() == 1) {
                            if (dtoDetalle.getOidSistemaPicado() != null
                                    && dtoDetalle.getOidSistemaPicado().longValue() ==
                                    ConstantesAPE.OID_SISTEMA_PICADO_MANUAL.longValue()) {
                                
                                UtilidadesLog.debug("*** 5 - Se setea numero caja = 1");
                                dtoDetalle.setNumeroCaja(new Long(1));
                            } // fin si
                        } // fin si
                        
                        
                        if ((dtoDetalle.getCodigoSAP().equals(dtoDetalleCajaProducto.getCodigoProducto())) 
                                && (dtoDetalle.getNombrePicador() == null) 
                                && (!detalleActualizado)) {
                            
                            UtilidadesLog.debug("*** 6 - Se setean datos para DTOListaPicadoDetalle "
                                              + "y detalleActualizado = true");
                            dtoDetalle.setNumeroCaja(dtoDetalleCaja.getNroCaja());
                            dtoDetalle.setNumeroAnaquel(dtoDetalleCajaProducto.getAnaquel());
                            dtoDetalle.setUnidadesProducto(dtoDetalleCajaProducto.getCantidadRequeridaPicar());
                            dtoDetalle.setUnidadesPicadas(dtoDetalleCajaProducto.getCantidadActualPicada());
                            dtoDetalle.setNombrePicador(dtoDetalleCajaProducto.getNombrePicadorProducto());
                            detalleActualizado = true;
                            
                        } else if ((dtoDetalle.getCodigoSAP().equals(dtoDetalleCajaProducto.getCodigoProducto())) 
                                    && (dtoDetalle.getNombrePicador() == null) 
                                    && (detalleActualizado)) {
                            
                            UtilidadesLog.debug("*** 7 - Se setean oids de DTOListaPicadoDetalle.oid "
                                               + "para eliminar ");    
                            
                            detallesEliminados.add(dtoDetalle.getOid());                
                            UtilidadesLog.debug("*** 7 - Se quita el elemento de DTOListaPicadoCabecera.detalles");                                                 
                            deta.remove(k);
                            UtilidadesLog.debug(".... como acabo de quitar del ArrayList, decremento en uno el valor de 'k'");
                            k--;
                            
                        } else if ((dtoDetalle.getCodigoSAP().equals(dtoDetalleCajaProducto.getCodigoProducto())) 
                                    && (dtoDetalle.getNombrePicador() != null)
                            // Cambio APE-07 - dmorello, 20/02/2008
                                    //&& (detalleNuevo == null)) {
                                    && (! detallePicadoActualizado)) {
                            UtilidadesLog.debug("*** 8 - Se actualizan cabecera y detalle de lista picado");   
                            
                            //detalleNuevo = new DTOListaPicadoDetalle();
                            detallePicadoActualizado = true;
                            
                            //detalleNuevo.setNumeroCaja(dtoDetalleCaja.getNroCaja());
                            //detalleNuevo.setNumeroAnaquel(dtoDetalleCajaProducto.getAnaquel());
                            //detalleNuevo.setUnidadesProducto(dtoDetalleCajaProducto.getCantidadRequeridaPicar());            
                            //detalleNuevo.setUnidadesPicadas(dtoDetalleCajaProducto.getCantidadActualPicada());
                            //detalleNuevo.setNombrePicador(dtoDetalleCajaProducto.getNombrePicadorProducto());
                            ////detalleNuevo.setCodigoPosicion(new Long(ultimoCodigoPosicion.longValue() + 1));
                            //detalleNuevo.setOidCabecera(dtoDetalle.getOidCabecera());
                            //detalleNuevo.setOidMapaCDDetalle(dtoDetalle.getOidMapaCDDetalle());
                            //detalleNuevo.setOidSistemaPicado(ConstantesAPE.OID_SISTEMA_PICADO_MANUAL); // Eliminado eiraola
                            //detalleNuevo.setOidSistemaPicado(dtoDetalle.getOidSistemaPicado());          // Agregado  eiraola
                            //detalleNuevo.setOidProducto(dtoDetalle.getOidProducto());
                            //detalleNuevo.setIndicadorImpresion(dtoDetalle.getIndicadorImpresion());
                            //detalleNuevo.setUnidadesChequeadas(dtoDetalle.getUnidadesChequeadas());
                            //detalleNuevo.setNombreChequeador(dtoDetalle.getNombreChequeador());
                            //detalleNuevo.setOidTipoCajaEmbalaje(dtoDetalle.getOidTipoCajaEmbalaje());
                            //detalleNuevo.setValorLinea(dtoDetalle.getValorLinea());
                            
                            //detallesNuevos.add(detalleNuevo);
                            
                            dtoCabecera.setNombreFacturador(dtoDetalleCaja.getOperadorIntroduccionFactura());
                            dtoCabecera.setFechaHoraFinEmbalaje(new Timestamp(System.currentTimeMillis()));
                            dtoDetalle.setNombrePicador(dtoDetalleCajaProducto.getNombrePicadorProducto());

                            // Fin cambio APE-07 dmorello 20/02/2008
                        }
                        
                    } // fin for de DTOListaPicadoCabecera.detalle
                    
                } // FIN FOR (SS:)
                
                
                
                
                try {
                    StringBuffer updateEtiquetas = new StringBuffer();
                    updateEtiquetas.append("UPDATE APE_ETIQU SET ESTP_OID_ESTA_PEDI = ");
                    
                    if (dtoDetalleCaja.getIndChequeo() != null 
                            && dtoDetalleCaja.getIndChequeo().booleanValue() == true) { // "1"
                        UtilidadesLog.debug("*** 9 - Seteando estado embalado");   
                        updateEtiquetas.append(ConstantesAPE.OID_ESTADO_PEDIDO_EMBALADO);
                    } else {
                        UtilidadesLog.debug("*** 10 - Seteando estado terminado");
                        updateEtiquetas.append(ConstantesAPE.OID_ESTADO_PEDIDO_TERMINADO);
                    }//fin else
                    
                    updateEtiquetas.append(" WHERE LPCA_OID_LIST_PICA_CABE = " + oidListaPicadoCabec);
                    updateEtiquetas.append("   AND NUM_CAJA = " + dtoDetalleCaja.getNroCaja());
                    
                    int cantEtiquetasActualizadas = bs.dbService.executeUpdate(updateEtiquetas.toString());
                    UtilidadesLog.debug(" se actualizaron " + cantEtiquetasActualizadas + " registros de APE_ETIQU.");
                    
                } catch (Exception e) {
                    UtilidadesLog.debug(" --- No se pudo actualizar el Estado del Pedido en entidad Etiquetas");
                    throw new MareException(e, UtilidadesError.armarCodigoError(
                            CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }
                
                
            } // FIN FOR (SO:)
            
            UtilidadesLog.debug("*** Llamando a actualizarListaPicado...");
            daoCrearListasIndPTL.actualizarListaPicado(dtoCabecera);
            
            int cantidadEliminados = detallesEliminados.size();
            UtilidadesLog.debug("*** Cantidad ListPicadDetal a Eliminar:" + cantidadEliminados);
            
            if (cantidadEliminados > 0) {
                UtilidadesLog.debug("*** Llamando a eliminarDetalles...");
                Long[] oids = (Long[]) detallesEliminados.toArray( new Long[cantidadEliminados] );
                daoCrearListasIndPTL.eliminarDetalles(oids);    
            }
            
            // Cambio APE-07 - dmorello, 20/02/2008
            //int cantidadNuevos = detallesNuevos.size();
            //UtilidadesLog.debug("*** Cantidad ListPicadDetal a Insertar:" + cantidadNuevos);
            //
            //if (cantidadNuevos > 0) {
            //    UtilidadesLog.debug("*** Llamando a insertarListaPicadoDetalle...");
            //    daoCrearListasIndPTL.insertarListaPicadoDetalle(detallesNuevos);
            //}
            // Fin cambio APE-07 dmorello 20/02/2008
            
        } // fin si rs > 0
        
        
        UtilidadesLog.info("MONCrearListasInduccionPTL.crearListasPicadoInduccionPTL"+
                           "(DTOListaPicadoInduccionPTL dtoe): Salida");
    }
}