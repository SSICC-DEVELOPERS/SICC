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
import es.indra.sicc.dtos.ape.DTOComprobarAlarmas;
import es.indra.sicc.dtos.ape.DTOTipoCajaEmbalaje;
import es.indra.sicc.logicanegocio.cra.DAOCRA;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.RecuperadorIdiomaDefectoServidor;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;
import java.util.ArrayList;
import es.indra.sicc.dtos.mae.DTOProducto;

public class DAOAlarmas  {
  public DAOAlarmas() { }
  
  /**
    * Sistema:     Belcorp
    * Modulo:      APE
    * Fecha:       22/02/2007
    * @version     1.0
    * @autor       Viviana Bongiovanni
    */
    
    /* Modificado por: Cristian Valenzuela
       Incidencia: BELC400000178
       Fecha: 23/04/2007 */
   
    public DTOOID obtenerAsignacionProductoAnaquelCabecera(DTOOID oidMapaCD) 
        throws MareException {
        UtilidadesLog.info("DAOAlarmas.obtenerAsignacionProductoAnaquelCabecera"+
        "(DTOOID oidMapaCD): Entrada");
        
        RecordSet rs = new RecordSet();        
        BelcorpService bs;
        String codigoError;
        DTOOID dtoOid = new DTOOID();        
        StringBuffer query = new StringBuffer();
            
        query.append(" SELECT ANAQUELCABECERA.PERD_OID_PERI ");
        query.append(" FROM APE_ASIGN_PRODU_ANAQU_CABEC ANAQUELCABECERA, ");
        query.append(" CRA_PERIO PERIODO ");
        query.append(" WHERE ANAQUELCABECERA.MCDC_OID_MAPA_CENT_DIST_CABE = " + oidMapaCD.getOid());
        query.append(" AND ANAQUELCABECERA.IND_ACTI_FACT = 'S' ");
        query.append(" AND ANAQUELCABECERA.PERD_OID_PERI = PERIODO.OID_PERI ");
        query.append(" AND PERIODO.FEC_INIC <= TRUNC(SYSDATE) ");
        query.append(" AND PERIODO.FEC_FINA >= TRUNC(SYSDATE) ");
        
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
        
        BigDecimal oidPeriodoActual = null;
        if(!rs.esVacio()) {
            oidPeriodoActual = (BigDecimal)rs.getValueAt(0, "PERD_OID_PERI");
            UtilidadesLog.debug("************* oidPeriodoActual: " + oidPeriodoActual);    
        }       
        
        DAOCRA dao = new DAOCRA();
        Long oidPeriodoSiguiente = null;
        if(oidPeriodoActual!=null) {
            oidPeriodoSiguiente = dao.obtienePeriodoSiguiente(new Long(oidPeriodoActual.longValue()));    
            UtilidadesLog.debug("************* oidPeriodoSiguiente: " + oidPeriodoSiguiente);
        }
        
        StringBuffer query2 = new StringBuffer();
        RecordSet rs2 = new RecordSet();        
        
        query2.append(" SELECT ANAQUELCABECERA.OID_ASIG_PROD_ANAQ_CABE  ");
        query2.append(" FROM APE_ASIGN_PRODU_ANAQU_CABEC  ANAQUELCABECERA ");
        query2.append(" WHERE ANAQUELCABECERA.MCDC_OID_MAPA_CENT_DIST_CABE = " + oidMapaCD.getOid());
        query2.append(" AND ANAQUELCABECERA.IND_ACTI_FACT = 'S' ");
        query2.append(" AND (ANAQUELCABECERA.PERD_OID_PERI = " + oidPeriodoActual + " OR ");
        query2.append(" ANAQUELCABECERA.PERD_OID_PERI = " + oidPeriodoSiguiente + ") ");
        
        try {
            bs = BelcorpService.getInstance();
            rs2 = bs.dbService.executeStaticQuery(query2.toString());
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
        
        BigDecimal oid = null;
        if(!rs2.esVacio()) {
            oid = (BigDecimal)rs2.getValueAt(0, "OID_ASIG_PROD_ANAQ_CABE");
            UtilidadesLog.debug("************* oid: " + oid);
        }        
        
        if(oid!=null) {
            dtoOid.setOid(new Long(oid.longValue()));        
        }     
        
        UtilidadesLog.info("DAOAlarmas.obtenerAsignacionProductoAnaquelCabecera(DTOOID oidMapaCD): Salida");
        return dtoOid;
  
 /*     try {
          bs = BelcorpService.getInstance();
      } catch (MareMiiServiceNotFoundException e) {
          UtilidadesLog.error("ERROR ", e);
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
      }
      
      if(oidMapaCD.getOid()!=null){
          dtoOid.setOid(new Long(1));
      }*/
  /*
     query.append(" SELECT B.oid_peri oid ");
            query.append(" FROM cra_perio A, cra_perio B ");
            query.append(" WHERE A.oid_peri = " + oidPeriodo);
            query.append(" AND B.pais_oid_pais = A.pais_oid_pais ");
            query.append(" AND B.marc_oid_marc = A.marc_oid_marc ");
            query.append(" AND B.cana_oid_cana = A.cana_oid_cana ");
            query.append(" AND B.fec_inic > A.fec_inic ");
            query.append(" ORDER BY B.fec_inic ");   




	    SimpleDateFormat formatter = new SimpleDateFormat ("dd-MM-yyyy");
            Timestamp date = new Timestamp(System.currentTimeMillis());

            //hacemos la consulta usando JDBC
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(" select P.OID_PERI
            stringBuffer.append(" FROM CRA_PERIO P, SEG_PERIO_CORPO PC ");
            stringBuffer.append(" where FEC_INIC <= to_date('" + formatter.format(date) + "', 'DD-MM-YYYY') 
	    and to_date('" + formatter.format(date) + "', 'DD-MM-YYYY') <= FEC_FINA and ");
            stringBuffer.append(" PAIS_OID_PAIS = ? and ");            
            stringBuffer.append(" P.PERI_OID_PERI = PC.OID_PERI ");
            stringBuffer.append(" ORDER BY FEC_INIC DESC ");
  
      try {
          rs = bs.dbService.executeStaticQuery(query.toString());
      } catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }
      */
  }
  
  /**
    * Sistema:     Belcorp
    * Modulo:      APE
    * Fecha:       25/06/2007
    * @version     1.0
    * @autor       Viviana Bongiovanni
    * Inc BELC400000527
    */
  public Integer obtienePeriodoSiguiente(Integer periodoActual) throws MareException {
      UtilidadesLog.info("DAOAlarmas.obtienePeriodoSiguiente(Integer periodoActual): Entrada");
      
      RecordSet rs = new RecordSet();        
      BelcorpService bs;
      StringBuffer query = new StringBuffer();
      
      try {
          bs = BelcorpService.getInstance();
      } catch (MareMiiServiceNotFoundException e) {
          UtilidadesLog.error("ERROR ", e);
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
      }
     
      query.append(" select OID from ( ");
      query.append(" SELECT B.oid_peri oid ");
      query.append(" FROM cra_perio A, cra_perio B ");
      query.append(" WHERE A.oid_peri = " + periodoActual);
      query.append(" AND B.pais_oid_pais = A.pais_oid_pais ");
      query.append(" AND B.marc_oid_marc = A.marc_oid_marc ");
      query.append(" AND B.cana_oid_cana = A.cana_oid_cana ");
      query.append(" AND B.fec_inic > A.fec_inic ");
      query.append(" ORDER BY B.fec_inic ");   
      query.append(" ) WHERE rownum = 1 ");
	   
      try {
          rs = bs.dbService.executeStaticQuery(query.toString());
          UtilidadesLog.debug("rs: " + rs);
          
      } catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }
      
      BigDecimal oidPeriodo= (BigDecimal)rs.getValueAt(0,"OID");
      
      UtilidadesLog.info("DAOAlarmas.obtienePeriodoSiguiente(Integer periodoActual): Salida");
      
      return Integer.valueOf(oidPeriodo.toString());
  }
  
  /**
    * Sistema:     Belcorp
    * Modulo:      APE
    * Fecha:       25/06/2007
    * @version     1.0
    * @autor       Viviana Bongiovanni
    * Inc BELC400000527
    */
  public RecordSet obtenerUsuariosLA(Long oidCentroDistribucion) throws MareException {
      UtilidadesLog.info("DAOAlarmas.obtenerUsuariosLA(Long oidCentroDistribucion): Entrada");
      
      RecordSet rs = new RecordSet();        
      BelcorpService bs;
      StringBuffer query = new StringBuffer();
      
      try {
          bs = BelcorpService.getInstance();
      } catch (MareMiiServiceNotFoundException e) {
          UtilidadesLog.error("ERROR ", e);
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
      }
     
      query.append(" SELECT lin.OID_LINE_ARMA, usuLin.VAL_MAIL MAIL ");
      query.append(" FROM APE_USUAR_ALARM_LINEA usuLin, APE_LINEA_ARMAD lin ");
      query.append(" WHERE usuLin.LIAR_OID_LINE_ARMA = lin.OID_LINE_ARMA ");
      query.append(" AND lin.CCDI_OID_CONF_CENT_DIST = " + oidCentroDistribucion);
	   
      try {
          rs = bs.dbService.executeStaticQuery(query.toString());
          UtilidadesLog.debug("rs: " + rs);
          
      } catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }
      
      UtilidadesLog.info("DAOAlarmas.obtenerUsuariosLA(Long oidCentroDistribucion): Salida");
      
      return rs;
  }
  
  /**
    * Sistema:     Belcorp
    * Modulo:      APE
    * Fecha:       25/06/2007
    * @version     1.0
    * @autor       Viviana Bongiovanni
    * Inc BELC400000527
    * 
    * CHANGELOG
    * ---------
    * SCS, 11/09/2007 - Modificaciones CUs 2da entrega - APE-088
    *    - Se reescribe query que recupera productos
    * dmorello, 29/10/2008 - Cambio SiCC 20080779
    *    - Se agrega recuperacion de descripcion i18n de producto
    *    - Se elimina recuperacion de descripcion corta
    */
  public ArrayList obtenerProductosMF(Integer peridodoActual, Integer periodoSiguiente) throws MareException {
      UtilidadesLog.info("DAOAlarmas.obtenerProductosMF(Integer peridodoActual, Integer periodoSiguiente): Entrada");
      
      RecordSet rs = new RecordSet();        
      BelcorpService bs;
      StringBuffer query = new StringBuffer();
      
      try {
          bs = BelcorpService.getInstance();
      } catch (MareMiiServiceNotFoundException e) {
          UtilidadesLog.error("ERROR ", e);
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
      }
      
      Long oidIdioma = RecuperadorIdiomaDefectoServidor.getIdiomaDefectoServidor();
      
      query.append(" (SELECT  DISTINCT prod.oid_prod, prod.cod_sap, ");
      query.append("          pq_apl_aux.Valor_Gen_I18n_Sicc(").append(oidIdioma);
      query.append("                , prod.oid_prod, 'MAE_PRODU') AS des_prod ");
      query.append(" FROM PRE_MATRI_FACTU_CABEC matricab, ");
      query.append(" PRE_OFERT ofer, ");
      query.append(" PRE_OFERT_DETAL oferdet, ");
      query.append(" MAE_PRODU prod ");
      query.append(" WHERE prod.oid_prod = oferdet.prod_oid_prod ");
      query.append(" AND oferdet.ofer_oid_ofer = ofer.oid_ofer ");
      query.append(" AND ofer.mfca_oid_cabe = matricab.oid_cabe ");
      query.append(" AND matricab.ind_matr_fact = 1 ");
      query.append(" AND matricab.perd_oid_peri IN (" + peridodoActual + " , " + periodoSiguiente+ ") " );
      query.append(" AND (prod.num_unid_caja IS NULL ");
      query.append(" OR prod.num_unid_caja = 0 ");  
      query.append(" OR prod.val_dime_alto IS NULL ");
      query.append(" OR prod.val_dime_alto = 0 ");
      query.append(" OR prod.val_dime_larg IS NULL ");
      query.append(" OR prod.val_dime_larg = 0 ");
      query.append(" OR prod.val_dime_anch IS NULL ");
      query.append(" OR prod.val_dime_anch = 0 "); 
      query.append(" OR prod.unmd_oid_unid_medi_dime IS NULL ");
      query.append(" OR prod.unmd_oid_unid_medi_dime = 0 ");
      query.append(" OR prod.val_volu IS NULL ");
      query.append(" OR prod.val_volu = 0 ");
      query.append(" OR prod.unmd_oid_unid_medi IS NULL ");
      query.append(" OR prod.unmd_oid_unid_medi = 0 ");
      query.append(" OR prod.val_peso IS NULL ");
      query.append(" OR prod.val_peso = 0 ");
      query.append(" OR prod.unmd_oid_unid_medi_peso IS NULL ");
      query.append(" OR prod.unmd_oid_unid_medi_peso = 0 ");
      query.append(" OR prod.cod_ind_dent_caja IS NULL ");
      query.append(" ) ");
      query.append(" ) ");							
      query.append(" UNION ");
      query.append(" (SELECT DISTINCT prod2.oid_prod oidpr, prod2.cod_sap codpr, ");
      query.append("          pq_apl_aux.Valor_Gen_I18n_Sicc(").append(oidIdioma);
      query.append("                , prod.oid_prod, 'MAE_PRODU') AS des_prod ");
      query.append(" FROM PRE_MATRI_FACTU_CABEC matricab, ");
      query.append(" PRE_OFERT ofer, ");
      query.append(" PRE_OFERT_DETAL oferdet, ");
      query.append(" PRE_OFERT_DETAL oferdet2, ");
      query.append(" MAE_PRODU prod, ");
      query.append(" MAE_PRODU prod2, ");
      query.append(" PRE_MATRI_FACTU mf1, ");
      query.append(" PRE_MATRI_FACTU mf2, ");
      query.append(" PRE_MATRI_REEMP mree ");
      query.append(" WHERE prod.oid_prod = oferdet.prod_oid_prod ");
      query.append(" AND oferdet.ofer_oid_ofer = ofer.oid_ofer ");
      query.append(" AND ofer.mfca_oid_cabe = matricab.oid_cabe ");
      query.append(" AND matricab.ind_matr_fact = 1 ");
      query.append(" AND matricab.perd_oid_peri IN (" + peridodoActual + " , " + periodoSiguiente+ ") " );
      query.append(" AND ofer.mfca_oid_cabe = mf1.mfca_oid_cabe ");
      query.append(" AND oferdet.oid_deta_ofer = mf1.ofde_oid_deta_ofer ");
      query.append(" AND mree.mafa_oid_cod_ppal = mf1.oid_matr_fact ");
      query.append(" AND mree.mafa_oid_cod_reem = mf2.oid_matr_fact ");
      query.append(" AND mf2.ofde_oid_deta_ofer = oferdet2.oid_deta_ofer ");
      query.append(" AND oferdet2.prod_oid_prod = prod2.oid_prod ");
      query.append(" AND (prod2.num_unid_caja IS NULL ");
      query.append(" OR prod2.num_unid_caja = 0 ");  
      query.append(" OR prod2.val_dime_alto IS NULL ");
      query.append(" OR prod2.val_dime_alto = 0 ");
      query.append(" OR prod2.val_dime_larg IS NULL ");
      query.append(" OR prod2.val_dime_larg = 0 ");
      query.append(" OR prod2.val_dime_anch IS NULL ");
      query.append(" OR prod2.val_dime_anch = 0 ");  
      query.append(" OR prod2.unmd_oid_unid_medi_dime IS NULL ");
      query.append(" OR prod2.unmd_oid_unid_medi_dime = 0 ");
      query.append(" OR prod2.val_volu IS NULL ");
      query.append(" OR prod2.val_volu = 0 "); 
      query.append(" OR prod2.unmd_oid_unid_medi IS NULL ");
      query.append(" OR prod2.unmd_oid_unid_medi = 0 ");   
      query.append(" OR prod2.val_peso IS NULL ");
      query.append(" OR prod2.val_peso = 0 ");
      query.append(" OR prod2.unmd_oid_unid_medi_peso IS NULL ");
      query.append(" OR prod2.unmd_oid_unid_medi_peso = 0 "); 
      query.append(" OR prod2.cod_ind_dent_caja IS NULL ");
      query.append(" ) ");
      query.append(" ) ");     
       
      try {
          rs = bs.dbService.executeStaticQuery(query.toString());
          UtilidadesLog.debug("rs: " + rs);
          
      } catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }
      
      int cant = rs.getRowCount();
      DTOProducto dtoProducto = null;
      ArrayList productos = new ArrayList();
      
      for(int i=0; i < cant; i++){
          dtoProducto = new DTOProducto();
          
          dtoProducto.setOid(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_PROD")).toString()));
          dtoProducto.setCodSAP((String)rs.getValueAt(i,"COD_SAP"));
          dtoProducto.setDescSAP((String)rs.getValueAt(i, "DES_PROD"));
          productos.add(dtoProducto);
      }
      
      UtilidadesLog.debug("productos: " + productos);
      
      UtilidadesLog.info("DAOAlarmas.obtenerProductosMF(Integer peridodoActual, Integer periodoSiguiente): Salida");
      
      return productos;
  }
  
   /**
    * Sistema:     Belcorp
    * Modulo:      APE
    * Fecha:       22/02/2007
    * @version     1.0
    * @autor       Viviana Bongiovanni
    */
  public ArrayList obtenerProductosInvalidos(DTOOID oidAsignacionProductoAnaquelCabecera, DTOOID oidLinea) throws MareException {
      UtilidadesLog.info("DAOAlarmas.obtenerProductosInvalidos(DTOOID oidAsignacionProductoAnaquelCabecera, DTOOID oidLinea): Entrada");
      
      RecordSet rs = new RecordSet();
      StringBuffer query = new StringBuffer();
      BelcorpService bs;
  
      try {
          bs = BelcorpService.getInstance();
      } catch (MareMiiServiceNotFoundException e) {
          UtilidadesLog.error("ERROR ", e);
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
      }
  
      query.append(" SELECT DISTINCT prod.COD_SAP, prod.DES_CORT ");
      query.append(" FROM APE_ASIGN_PRODU_ANAQU_DETAL det, ");
      query.append(" APE_LINEA_ARMAD lin, MAE_PRODU prod ");
      query.append(" WHERE det.APAC_OID_ASIG_PROD_ANAQ_CABE =  " + oidAsignacionProductoAnaquelCabecera.getOid());
      query.append(" AND det.PROD_OID_PROD = prod.OID_PROD ");
      query.append(" AND lin.OID_LINE_ARMA = " + oidLinea.getOid());
      query.append(" AND prod.FEC_ULTI_ACTU > lin.FEC_HORA_REVI_ALAR ");
      query.append(" AND (prod.NUM_UNID_CAJA IS NULL ");
      query.append(" OR prod.VAL_DIME_ALTO IS NULL ");
      query.append(" OR prod.VAL_DIME_LARG IS NULL ");
      query.append(" OR prod.VAL_DIME_ANCH IS NULL ");
      query.append(" OR prod.UNMD_OID_UNID_MEDI_DIME IS NULL ");
      query.append(" OR prod.VAL_VOLU IS NULL ");
      query.append(" OR prod.UNMD_OID_UNID_MEDI IS NULL ");
      query.append(" OR prod.VAL_PESO IS NULL ");
      query.append(" OR prod.UNMD_OID_UNID_MEDI_PESO IS NULL ");
      query.append(" OR prod.COD_IND_DENT_CAJA IS NULL) ");
        
      try {
          rs = bs.dbService.executeStaticQuery(query.toString());
      } catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }
      
      int cant = rs.getRowCount();
      DTOProducto dtoProducto = null;
      ArrayList productos = new ArrayList();
      
      for(int i=0; i < cant; i++){
          dtoProducto = new DTOProducto();
          
          dtoProducto.setCodSAP((String)rs.getValueAt(i,"COD_SAP"));
          dtoProducto.setDescCorta((String)rs.getValueAt(i,"DES_CORT"));
          
          productos.add(dtoProducto);
      }
      
      UtilidadesLog.debug("productos invalidos: " + productos);
        
      UtilidadesLog.info("DAOAlarmas.obtenerProductosInvalidos(DTOOID oidAsignacionProductoAnaquelCabecera, DTOOID oidLinea): Salida");      
      return productos;
  }
  
  /**
  * Sistema:     Belcorp
  * Modulo:      APE
  * Fecha:       23/02/2007
  * @version     1.0
  * @autor       Viviana Bongiovanni
  */
  
  /* Modificado por: Cristian Valenzuela
     Fecha: 26/04/2007 
     Incidencia: BELC400000353 */
   
  public ArrayList obtenerDatosCajas(DTOComprobarAlarmas dtoe) throws MareException {
      UtilidadesLog.info("DAOAlarmas.obtenerDatosCajas(DTOComprobarAlarmas dtoe): Entrada");
        
      RecordSet rs = new RecordSet();
      StringBuffer query = new StringBuffer();
      ArrayList cajas = new ArrayList();
      BelcorpService bs;

      try {
          bs = BelcorpService.getInstance();
      }
      catch (MareMiiServiceNotFoundException e) {
          UtilidadesLog.error("ERROR ", e);
          throw new MareException(e, 
          UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
      }

      query.append(" SELECT tipoCaj.UNMD_OID_UNID_MEDI_CAPA, NVL(tipocaj.num_capa, 0) NUM_CAPA, ");
      query.append("  NVL(tipoCaj.NUM_CAPA_MINI, 0) NUM_CAPA_MINI, tipoCaj.NUM_NIVE_APLI, ");
      query.append(" tipoCaj.IND_CUBI, tipoCaj.PAIS_OID_PAIS, ");
      query.append(" i18n.VAL_I18N DESC_CAJA, i18n1.VAL_I18N DESC_LINEA ");
      query.append(" , tipocaj.OID_TIPO_CAJA_EMBA "); // agregado eiraola (objetivo: detectar registro 'ficticio' o no correspondiente a un TipoCajaEmbalaje)
      query.append(" FROM APE_LINEA_ARMAD lin, APE_LINEA_TIPO_CAJA_EMBAL linCaj, ");
      query.append(" APE_TIPO_CAJA_EMBAL tipoCaj, v_gen_i18n_sicc i18n, v_gen_i18n_sicc i18n1 ");
      query.append(" WHERE lin.CCDI_OID_CONF_CENT_DIST = " + dtoe.getOidCentroDistribucion());
      
      if(dtoe.getOidLineaArmado()!=null){
          query.append(" AND lin.OID_LINE_ARMA = " + dtoe.getOidLineaArmado());
      }
      
      query.append(" AND linCaj.LIAR_OID_LINE_ARMA(+) = lin.OID_LINE_ARMA ");
      query.append(" AND linCaj.TCEM_OID_TIPO_CAJA_EMBA = tipoCaj.OID_TIPO_CAJA_EMBA(+) ");
      query.append(" AND tipoCaj.PAIS_OID_PAIS(+) = " + dtoe.getOidPais());
    //Eliminado - BELC400000353
    //query.append(" AND tipoCaj.IND_CUBI(+) = 1 ");
      query.append(" AND tipoCaj.OID_TIPO_CAJA_EMBA = i18n.VAL_OID(+) ");
      query.append(" AND i18n.idio_oid_idio(+) =  " + dtoe.getOidIdioma());
      query.append(" AND i18n.attr_num_atri(+) = 1 ");
      query.append(" AND i18n.attr_enti(+) = 'APE_TIPO_CAJA_EMBAL' ");
      query.append(" AND lin.OID_LINE_ARMA = i18n1.VAL_OID ");
      query.append(" AND i18n1.idio_oid_idio = " + dtoe.getOidIdioma());
      query.append(" AND i18n1.attr_num_atri = 1 ");
      query.append(" AND i18n1.attr_enti = 'APE_LINEA_ARMAD' ");
      query.append(" ORDER BY NVL(tipocaj.num_capa, 0) DESC ");      

      try {
          rs = bs.dbService.executeStaticQuery(query.toString());
      }
      catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          throw new MareException(ex,
          UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }
     
      UtilidadesLog.debug("rs: " + rs);
      
      int cant = rs.getRowCount();
      DTOTipoCajaEmbalaje dtoTipoCajaEmbalaje = null;
      Long oidTipoCajaEmbalaje;
      
      for(int i=0; i< cant; i++){
          dtoTipoCajaEmbalaje = new DTOTipoCajaEmbalaje();
          
          oidTipoCajaEmbalaje = (rs.getValueAt(i, "OID_TIPO_CAJA_EMBA") != null)
                                ? new Long(((BigDecimal)rs.getValueAt(i, "OID_TIPO_CAJA_EMBA")).longValue())
                                : null;
          dtoTipoCajaEmbalaje.setOid(oidTipoCajaEmbalaje);
          
          BigDecimal unidadMedidaCapacidad = (BigDecimal)rs.getValueAt(i,"UNMD_OID_UNID_MEDI_CAPA");
          dtoTipoCajaEmbalaje.setOidUnidadMedidaCapacidad(unidadMedidaCapacidad!=null?Long.valueOf(unidadMedidaCapacidad.toString()):null);
         
          dtoTipoCajaEmbalaje.setCapacidad((BigDecimal)rs.getValueAt(i,"NUM_CAPA"));
          dtoTipoCajaEmbalaje.setCapacidadMinima((BigDecimal)rs.getValueAt(i,"NUM_CAPA_MINI"));
          dtoTipoCajaEmbalaje.setNivelAplicacion((BigDecimal)rs.getValueAt(i,"NUM_NIVE_APLI"));
         
          dtoTipoCajaEmbalaje.setOidPais(dtoe.getOidPais());
          
          dtoTipoCajaEmbalaje.setDescripcion((String)rs.getValueAt(i,"DESC_CAJA"));
          dtoTipoCajaEmbalaje.setDescripcionLinea((String)rs.getValueAt(i,"DESC_LINEA"));
          
          String indCub = (String)rs.getValueAt(i,"IND_CUBI");
          dtoTipoCajaEmbalaje.setIndicadorCubicaje(indCub!=null?(indCub.equals("1")?Boolean.TRUE:Boolean.FALSE):null);

          cajas.add(dtoTipoCajaEmbalaje);
      }      
      
      UtilidadesLog.debug("cajas: " + cajas);
     
      UtilidadesLog.info("DAOAlarmas.obtenerDatosCajas(DTOComprobarAlarmas dtoe: Salida");       
      return cajas;
  }
}