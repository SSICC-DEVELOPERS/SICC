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
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.intsys.DTOListaPicadoInduccionPTL;
import es.indra.sicc.dtos.ape.DTOListaPicadoDetalle;
import es.indra.sicc.dtos.ape.DTOListaPicadoCabecera;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.LogAPP;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Vector;


public class DAOCrearListasInduccionPTL  {
    public DAOCrearListasInduccionPTL() {  }
  
  /**
    * Sistema:     Belcorp
    * Modulo:      APE
    * Fecha:       28/02/2007
    * @version     1.0
    * @autor       Viviana Bongiovanni
    * @deprecated
    */
  
  /* Por la incidencia BELC400000431 
     este metodo dejo de utilizarse */  
  
  public void crearListasPicadoInduccionPTL(DTOListaPicadoInduccionPTL dtoe) throws MareException {
      UtilidadesLog.info("DAOCrearListasInduccionPTL.crearListasPicadoInduccionPTL(DTOListaPicadoInduccionPTL dtoe): Entrada");
        
      StringBuffer query = new StringBuffer();
      StringBuffer query1 = new StringBuffer();
      BelcorpService bs;

      try {
          bs = BelcorpService.getInstance();
      } catch (MareMiiServiceNotFoundException e) {
          UtilidadesLog.error("ERROR ", e);
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
      }

      // Actualiza picado cabecera
      query.append(" UPDATE APE_LISTA_PICAD_CABEC cabecera ");
      query.append(" SET cabecera.FEC_HORA_FINA_EMBA = SYSDATE ");
      query.append(" WHERE cabecera.OID_LIST_PICA_CABE IN ( ");
      query.append(" SELECT cab.OID_LIST_PICA_CABE ");
      query.append(" FROM APE_LISTA_PICAD_CABEC cab, ");
      query.append(" APE_LISTA_PICAD_DETAL det, ");
      query.append(" PED_SOLIC_CABEC sol, ");
      query.append(" MAE_PRODU prod ");
      query.append(" WHERE det.LPCA_OID_LIST_PICA_CABE = cab.OID_LIST_PICA_CABE ");
      query.append(" AND cab.SOCA_OID_SOLI_CABE = sol.OID_SOLI_CABE ");
      query.append(" AND det.PROD_OID_PROD = prod.OID_PROD ");
      query.append(" AND sol.VAL_NUME_SOLI = " + dtoe.getNroFactura());
      query.append(" AND cab.NUM_TOTA_CAJA = " + dtoe.getNroTotalCajas());
      query.append(" AND cab.VAL_NOMB_FACT = '" + dtoe.getOperadorIntroduccionFactura() + "' ");
      query.append(" AND det.NUM_CAJA = " + dtoe.getNroCaja());
      query.append(" AND prod.COD_SAP = '" + dtoe.getCodigoProducto() + "' ");
      query.append(" AND cab.FEC_HORA_FINA_EMBA IS NULL) ");
            
      try {
          int cant = bs.dbService.executeUpdate(query.toString());
          UtilidadesLog.debug("actualizo: " + cant); 
          
          if (cant == 0 ) 
          {
            LogAPP.error("No se encontró la lista de picado correspondiente. N° de caja: " + dtoe.getNroCaja() + " | N° factura: " + dtoe.getNroFactura());
          }
      } catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }
      
      // Actualiza picado detalle
      query1.append(" UPDATE APE_LISTA_PICAD_DETAL detalle ");
      query1.append(" SET detalle.VAL_NOMB_CHEQ = '" + dtoe.getOperadorChequeoCajaFactura() + "', ");
      query1.append(" detalle.VAL_NOMB_PICA = '" + dtoe.getNombrePicadorProducto() + "', ");
      query1.append(" detalle.NUM_UNID_PICA = " + dtoe.getCantidadRequeridaPicar());
      query1.append(" WHERE detalle.OID_LIST_PICA_DETA IN ( ");
      query1.append(" SELECT det.OID_LIST_PICA_DETA ");
      query1.append(" FROM APE_LISTA_PICAD_CABEC cab, ");
      query1.append(" APE_LISTA_PICAD_DETAL det, ");
      query1.append(" PED_SOLIC_CABEC sol, ");
      query1.append(" MAE_PRODU prod ");
      query1.append(" WHERE det.LPCA_OID_LIST_PICA_CABE = cab.OID_LIST_PICA_CABE ");
      query1.append(" AND cab.SOCA_OID_SOLI_CABE = sol.OID_SOLI_CABE ");
      query1.append(" AND det.PROD_OID_PROD = prod.OID_PROD ");
      query1.append(" AND sol.VAL_NUME_SOLI = " + dtoe.getNroFactura());
      query1.append(" AND cab.NUM_TOTA_CAJA = " + dtoe.getNroTotalCajas());
      query1.append(" AND cab.VAL_NOMB_FACT = '" + dtoe.getOperadorIntroduccionFactura() + "' ");
      query1.append(" AND det.NUM_CAJA = " + dtoe.getNroCaja());
      query1.append(" AND prod.COD_SAP = '" + dtoe.getCodigoProducto() + "') ");

      
      try {
          int cant1 = bs.dbService.executeUpdate(query1.toString());
          UtilidadesLog.debug("actualizo: " + cant1); 
      } catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }
      
      UtilidadesLog.info("DAOCrearListasInduccionPTL.crearListasPicadoInduccionPTL(DTOListaPicadoInduccionPTL dtoe): Salida");
  }

    /**
     * Sistema:     Belcorp
     * Modulo:      APE
     * Fecha:       17/05/2007
     * @version     1.0
     * @autor       Cristian Valenzuela
     */
    public void insertarListaPicadoDetalle(ArrayList dtosListaPicadoDetalle) throws MareException {
        UtilidadesLog.info("DAOCrearListasInduccionPTL.insertarListaPicadoDetalle(dtos): Entrada");
        
        try {
            int cantDetallesNuevos = dtosListaPicadoDetalle.size();
            UtilidadesLog.debug(" * * * cant detalles ListaPicad nuevos para insertar: " + cantDetallesNuevos);
            
            DTOListaPicadoDetalle dtoe;
            String ind_impr;
            
            Vector vInserts = new Vector();
            StringBuffer insertLPD;
            
            for (int i = 0; i < cantDetallesNuevos; i++) {
                dtoe = (DTOListaPicadoDetalle)dtosListaPicadoDetalle.get(i);
                
                insertLPD = new StringBuffer();
                
                insertLPD.append("INSERT INTO APE_LISTA_PICAD_DETAL ");
                insertLPD.append( "(OID_LIST_PICA_DETA, ");
                //insertLPD.append(  "NUM_CODI_POSI, ");//NOT NULL
                insertLPD.append(  "NUM_UNID_PROD, ");//NOT NULL
                insertLPD.append(  "VAL_LINE, ");
                insertLPD.append(  "NUM_CAJA, ");
                insertLPD.append(  "IND_IMPR, ");
                insertLPD.append(  "VAL_NOMB_PICA, ");
                insertLPD.append(  "NUM_UNID_PICA, ");
                insertLPD.append(  "NUM_UNID_CHEQ, ");
                insertLPD.append(  "LPCA_OID_LIST_PICA_CABE, ");//NOT NULL
                insertLPD.append(  "TCEM_OID_TIPO_CAJA_EMBA, ");
                insertLPD.append(  "MCDD_OID_MAPA_CENT_DIST_DETA, ");//NOT NULL
                insertLPD.append(  "SIPI_OID_SIST_PICA, ");//NOT NULL
                insertLPD.append(  "PROD_OID_PROD, ");//NOT NULL
                insertLPD.append(  "VAL_NOMB_CHEQ)");
                insertLPD.append(" VALUES ");
                insertLPD.append( "(APE_LPDE_SEQ.nextval, ");
                //insertLPD.append(dtoe.getCodigoPosicion() + " , ");
                insertLPD.append(dtoe.getUnidadesProducto()+ ", ");
                insertLPD.append(dtoe.getValorLinea() + ", ");
                insertLPD.append(dtoe.getNumeroCaja() + ", ");
                
                if (dtoe.getIndicadorImpresion()!=null 
                        && dtoe.getIndicadorImpresion().booleanValue()==true) {
                    insertLPD.append("'" + ConstantesAPE.TRUE.toString() + "', ");
                } else {
                    insertLPD.append("'" + ConstantesAPE.FALSE.toString() + "', ");
                }
                                
                if (dtoe.getNombrePicador()!=null) {
                    insertLPD.append("'" + dtoe.getNombrePicador() + "', ");
                } else {
                    insertLPD.append(" NULL, ");
                }         
                
                insertLPD.append(dtoe.getUnidadesPicadas() + ", ");
                insertLPD.append(dtoe.getUnidadesChequeadas() + ", ");
                insertLPD.append(dtoe.getOidCabecera() + ", ");
                insertLPD.append(dtoe.getOidTipoCajaEmbalaje() + ", ");
                insertLPD.append(dtoe.getOidMapaCDDetalle() + ", ");
                insertLPD.append(dtoe.getOidSistemaPicado() + ", ");
                insertLPD.append(dtoe.getOidProducto() + ", ");
                if (dtoe.getNombreChequeador() != null) {
                    insertLPD.append("'" + dtoe.getNombreChequeador() + "')");
                } else {
                    insertLPD.append(" NULL)");
                }
                
                insertLPD.append(";"); // Separador de sentencias del script
                
                vInserts.add(insertLPD);
            } // fin for dtos
            
            UtilidadesLog.debug("* * * Antes de ejecutar los Insert (masivo)...");
            invocarExecutor(vInserts);
            
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        
        UtilidadesLog.info("DAOCrearListasInduccionPTL.insertarListaPicadoDetalle(dtos): Salida");
    } 
    
   /**
    * Sistema:     Belcorp
    * Modulo:      APE
    * Fecha:       21/05/2007
    * @version     1.0
    * @autor       Cristian Valenzuela
    * @observaciones
    *   eiraola 19/09/2007 Para BELC400000715, no tiene mucho que ver pero aproveche para
    *                      usar el EXECUTOR y no multiples updates individuales.
    *                      Estaba mal que actualizaba MapaCDDetalle, lo que se actualiza es
    *                      ListaPicadoDetalle con el anaquel de la interfaz Ptl-3
    */
    public void actualizarListaPicado(DTOListaPicadoCabecera dtoe) throws MareException {
        UtilidadesLog.info("DAOCrearListasInduccionPTL.actualizarListaPicado(DTOListaPicadoCabecera dtoe): Entrada");
        
        try {
            UtilidadesLog.debug("* * * DTOListaPicadoCabecera: " + dtoe);
            Vector vUpdates = new Vector();
            
            StringBuffer updateLPC = new StringBuffer();
            updateLPC.append("UPDATE APE_LISTA_PICAD_CABEC lpc SET");
            updateLPC.append(" lpc.NUM_TOTA_CAJA = " + dtoe.getNumeroTotalCajas() + ",");
            // dmorello, 20/02/2008
            //updateLPC.append(" lpc.FEC_HORA_FINA_EMBA = TO_DATE('" + dtoe.getStrFechaHoraFinEmbalaje() 
            //                                                    + "','yyyy-MM-dd HH24:MI:SS'),");
            updateLPC.append(" lpc.FEC_HORA_FINA_EMBA = ");
            if (dtoe.getStrFechaHoraFinEmbalaje() != null) {
                updateLPC.append("TO_DATE('").append(dtoe.getStrFechaHoraFinEmbalaje()).append("','yyyy-MM-dd HH24:MI:SS'),");
            } else {
                updateLPC.append("null,");
            }
            //updateLPC.append(" lpc.VAL_NOMB_FACT = '" + dtoe.getNombreFacturador() + "'");
            updateLPC.append(" lpc.VAL_NOMB_FACT = ");
            if (dtoe.getNombreFacturador() != null) {
                updateLPC.append('\'').append(dtoe.getNombreFacturador()).append('\'');
            } else {
               updateLPC.append("null");
            }
            // Fin dmorello 20/02/2008
            
            updateLPC.append(" WHERE lpc.SOCA_OID_SOLI_CABE = " + dtoe.getOidSolicitudCAbecera());
            updateLPC.append(";");
            
            vUpdates.add(updateLPC);
            
            ArrayList detalles = dtoe.getDetalles();
            int cantDetalles = detalles.size();
            UtilidadesLog.debug("* * * Cantidad de detalles de Lista Picado para UPDATE: " + cantDetalles);
            
            DTOListaPicadoDetalle dtoDetalle;
            StringBuffer updateLPD;
            
            for (int i = 0; i < cantDetalles; i++) {
                dtoDetalle = (DTOListaPicadoDetalle)detalles.get(i);
                updateLPD = new StringBuffer();
             
                updateLPD.append("UPDATE APE_LISTA_PICAD_DETAL lpd SET");
                updateLPD.append(" lpd.NUM_UNID_PROD = " + dtoDetalle.getUnidadesProducto() + ",");
                updateLPD.append(" lpd.NUM_CAJA = " + dtoDetalle.getNumeroCaja()+ ",");
                updateLPD.append(" lpd.NUM_UNID_PICA = " + dtoDetalle.getUnidadesPicadas() + ",");
                
                if (dtoDetalle.getNombrePicador()!=null) {
                    updateLPD.append(" lpd.VAL_NOMB_PICA = '" + dtoDetalle.getNombrePicador() + "',");
                } else {
                    updateLPD.append(" lpd.VAL_NOMB_PICA = NULL,");
                }
                updateLPD.append(" lpd.MCDD_OID_MAPA_CENT_DIST_DETA = ");
                updateLPD.append( "(SELECT mcd.OID_MAPA_CENT_DIST_DETA ");
                updateLPD.append(    "FROM APE_MAPA_CENTR_DISTR_DETAL mcd ");
                updateLPD.append(   "WHERE mcd.NUM_ANAQ = '"+dtoDetalle.getNumeroAnaquel()+"' ");
                updateLPD.append(     "AND mcd.MCDC_OID_MAPA_CENT_DIST_CABE = ");
                updateLPD.append(         "(SELECT MCDC_OID_MAPA_CENT_DIST_CABE ");
                updateLPD.append(            "FROM APE_MAPA_CENTR_DISTR_DETAL ");
                updateLPD.append(           "WHERE OID_MAPA_CENT_DIST_DETA = "+dtoDetalle.getOidMapaCDDetalle()+")) ");
                
                updateLPD.append("WHERE lpd.OID_LIST_PICA_DETA = " +dtoDetalle.getOid()+ ";");
                
                vUpdates.add(updateLPD);
                
            } // fin for detalles
            
            UtilidadesLog.debug("* * * Antes de ejecutar el Update masivo...");
            invocarExecutor(vUpdates);
            
        } catch (Exception e) {
            UtilidadesLog.error(" --- Error en DAOCrearListasInduccionPTL.actualizarListaPicado");
            throw new MareException(e,  UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        
        UtilidadesLog.info("DAOCrearListasInduccionPTL.actualizarListaPicado(DTOListaPicadoCabecera dtoe): Salida");    
    } 
    
    /**
     * Sistema:     Belcorp
     * Modulo:      APE
     * Fecha:       17/05/2007
     * @version     1.0
     * @autor       Cristian Valenzuela
     */
    public Long buscarUltimoCodigoPosicion(Long oid) throws MareException {
        UtilidadesLog.info("DAOCrearListasInduccionPTL.buscarUltimoCodigoPosicion"+
        "(Long oid): Entrada");
        
        UtilidadesLog.info("* * * oid: " + oid);
           
        BelcorpService bs;
        RecordSet rs;
        String codigoError;
        Long proximoCodigo = null;
        StringBuffer query = new StringBuffer();
        
        query.append(" SELECT MAX(LISTA.NUM_CODI_POSI) AS ULTIMOCODIGO ");
        query.append(" FROM APE_LISTA_PICAD_DETAL LISTA ");
        query.append(" WHERE LISTA.LPCA_OID_LIST_PICA_CABE = " + oid);  
        
        try {
            bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(query.toString());
            
             if (rs.esVacio() || rs.getValueAt(0, 0) == null) {
                proximoCodigo = new Long("1");
            } else {
                proximoCodigo = new Long(((BigDecimal)rs.getValueAt(0, 0)).longValue());
            }
            
            UtilidadesLog.info("* * * proximoCodigo: " + proximoCodigo);
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
        
        UtilidadesLog.info("DAOCrearListasInduccionPTL.buscarUltimoCodigoPosicion"+
        "(Long oid): Salida");    
        return proximoCodigo;      
    }

    /**
     * Sistema:     Belcorp
     * Modulo:      APE
     * Fecha:       18/05/2007
     * @version     1.0
     * @autor       Cristian Valenzuela
     */  
    public void eliminarDetalles(Long[] oids) throws MareException {
        UtilidadesLog.info("DAOCrearListasInduccionPTL.eliminarDetalles(ArrayList lista): Entrada");
        
        StringBuffer query = new StringBuffer();
        BelcorpService bs;
        
        try {
            bs = BelcorpService.getInstance();
            
            query.append("DELETE FROM APE_LISTA_PICAD_DETAL ");
            query.append( "WHERE OID_LIST_PICA_DETA IN " + 
                          this.armarListaSql("OID_LIST_PICA_DETA", oids));
            
            int cant = bs.dbService.executeUpdate(query.toString());
            
        } catch (MareMiiServiceNotFoundException msnfe) {
            UtilidadesLog.error("ERROR ", msnfe);
            throw new MareException(msnfe, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
            CodigosError.ERROR_DE_BORRADO_DE_DATOS));
        }
        UtilidadesLog.info("DAOCrearListasInduccionPTL.eliminarDetalles(ArrayList lista): Salida");
    }

    /**
     * Crea una lista SQL fragmentada cada 1000 elementos por restriccion del
     * operador IN.
     * Ej.: (1723, 1728,..... 1999) OR cac.clie_oid_clie IN (322, 4545,.....)
     * @author eiraola
     * @since 19/Sep/2007
     */
    private StringBuffer armarListaSql(String nombreCampo, Long[] valoresLista) throws Exception {
        StringBuffer fragmentoQuery = new StringBuffer();
        int cantValores = valoresLista.length;
        
        fragmentoQuery.append("(");
        
        for (int i = 0; i < cantValores; i++) {
            if ( (i+1) < cantValores ) {
                if ((i+1)%1000 == 0) {
                    fragmentoQuery.append(valoresLista[i] + ") OR "+ nombreCampo +" IN (");
                } else {
                    fragmentoQuery.append(valoresLista[i] + ",");
                }
            } else {
                fragmentoQuery.append(valoresLista[i]);
            }
        }
        fragmentoQuery.append(")");
        
        return fragmentoQuery;
    }
    
    /**
     * Metodo auxiliar para ejecutar un script con sentencias Sql tipo UPDATE o 
     * DELETE realizando un unico acceso a BBDD (cada sentencia es un elemento de 
     * la clase StringBuffer en el Vector de entrada, y debe finalizar en ';')
     * @autor eiraola
     * @since 18/Sep/2007
     */
    private void invocarExecutor(Vector vExecutor) throws MareException {
        String query = new String ();
        int cantSentencias = vExecutor.size();
        UtilidadesLog.debug("    cantidad de sentencias a ejecutar_" + cantSentencias);
        if (cantSentencias == 0) return;
                
        for (int i=0; i< cantSentencias; i++){
            query = query + ((StringBuffer) vExecutor.get(i)).toString();
        }
        try {
            UtilidadesEJB.getBelcorpService().dbService.executeProcedure("PQ_PLANI.EXECUTOR", query);
        } catch (Exception ex) {
            UtilidadesLog.error(ex.getMessage());
            throw new MareException(ex, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
    }
}    