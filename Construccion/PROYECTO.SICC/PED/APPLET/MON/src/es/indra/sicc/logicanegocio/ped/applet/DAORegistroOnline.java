package es.indra.sicc.logicanegocio.ped.applet;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.bel.DTOCambiosVentas;
import es.indra.sicc.dtos.bel.DTOPosicionCambioVenta;
import es.indra.sicc.dtos.ped.DTOPosicionSolicitud;
import es.indra.sicc.logicanegocio.ped.ConstantesPED;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.math.BigDecimal;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Vector;

public class DAORegistroOnline 
{
  private String codUsuario;
 
  public DAORegistroOnline(String codUsuario) { 
    this.codUsuario=codUsuario;
  }
    
    
  
  /**
   * Cambiar esta query por esta
   * 
   * SELECT   ac.cod_acce, tsp.oid_tipo_soli_pais oid_tsp,
         pq_apl_aux.valor_gen_i18n_sicc
                                      (1,
                                       tsp.tsol_oid_tipo_soli,
                                       'PED_TIPO_SOLIC'
                                      ) tipo_solicitud,
         m.oid_marc oid_marca, m.des_marc marca, c.oid_cana oid_canal,
         pq_apl_aux.valor_gen_i18n_sicc (1, c.oid_cana, 'SEG_CANAL') canal,
         ts.acce_oid_acce oid_acceso,
         pq_apl_aux.valor_gen_i18n_sicc (1,
                                         ts.acce_oid_acce,
                                         'SEG_ACCES'
                                        ) acceso,
         ts.sbac_oid_sbac oid_subacceso,
         pq_apl_aux.valor_gen_i18n_sicc (1,
                                         ts.sbac_oid_sbac,
                                         'SEG_SUBAC'
                                        ) subacceso,
         tsp.mone_oid_mone oid_moneda,
         pq_apl_aux.valor_gen_i18n_sicc
            (1,
             CASE
                WHEN (tsp.mone_oid_mone IS NULL)
                   THEN (SELECT pais.mone_oid_mone
                           FROM seg_pais pais
                          WHERE pais.oid_pais = 1)
                ELSE (tsp.mone_oid_mone)
             END,
             'SEG_MONED'
            ) moneda,
         ts.ticl_oid_tipo_clie tipo_cliente, 
		 p.oid_peri oid_periodo,
         p.val_nomb_peri periodo, 
		 tsp.ind_rese_stoc reserva_stock
    FROM ped_tipo_solic_pais tsp,
         seg_marca m,
         ped_tipo_solic ts,
         seg_canal c,
         seg_acces ac,
         cra_perio p
   WHERE  tsp.pais_oid_pais = 1
     AND tsp.tsol_oid_tipo_soli = ts.oid_tipo_soli
     AND ts.marc_oid_marc = m.oid_marc
     AND ts.acce_oid_acce = ac.oid_acce
     AND ac.cana_oid_cana = c.oid_cana
     AND p.fec_inic <= TO_DATE ('07-07-2006', 'DD-MM-YYYY')
     AND p.fec_fina >= TO_DATE ('07-07-2006', 'DD-MM-YYYY')
     AND p.pais_oid_pais = tsp.pais_oid_pais
     AND p.marc_oid_marc = ts.marc_oid_marc
     AND p.cana_oid_cana = c.oid_cana
ORDER BY oid_tsp

   * Aun no esta terminada
   * 
   */
  /**
  * @throws es.indra.mare.common.exception.MareException
  * @return 
  * @param belcenter
  * @param subacceso
  * @param idioma
  * @param pais
  */
  public RecordSet obtenerTiposSolicitud(Long pais, Long idioma, Long subacceso, Boolean belcenter) throws MareException
  {
    /*
    Obtiene todos los tipos de solicitud por pais 
    Si belcenter == True, filtrará por subacceso=recibido, canal=venta directa, acceso=belcenter y clase de solicitud=orden de compra 
    Si el subacceso es nulo para el tipo de solicitud, no se utilizará para el filtro 
    Aplicar la seguridad de datos estructurales 
    */
    UtilidadesLog.info("DAORegistroOnline.obtenerTiposSolicitud(Long pais, Long idioma, Long subacceso, Boolean belcenter): Entrada ");
    BelcorpService bs;
    RecordSet rs;
    StringBuffer buf = new StringBuffer();
    try {
      bs = BelcorpService.getInstance();
    }
    catch(MareMiiServiceNotFoundException e) {
      throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
    }
    try {
      /* Modificacion por Performance alorenzo 14/07/2006 */
      SimpleDateFormat dt = new SimpleDateFormat("dd-MM-yyyy");
      
      buf.append(" SELECT DISTINCT AC.COD_ACCE, ");
      buf.append("        TSP.OID_TIPO_SOLI_PAIS OID_TSP, ");
		  buf.append("        PQ_APL_AUX.Valor_Gen_I18n_Sicc(" + idioma + ",TSP.TSOL_OID_TIPO_SOLI,'PED_TIPO_SOLIC') TIPO_SOLICITUD,");
		  buf.append("        M.OID_MARC OID_MARCA, ");
		  buf.append("        M.DES_MARC MARCA, ");
		  buf.append("        C.OID_CANA OID_CANAL,"); 
		  buf.append("        PQ_APL_AUX.Valor_Gen_I18n_Sicc(" + idioma + ",C.OID_CANA,'SEG_CANAL') CANAL,");
   		buf.append("        AC.OID_ACCE OID_ACCESO,");
		  buf.append("        PQ_APL_AUX.Valor_Gen_I18n_Sicc(" + idioma + ",AC.OID_ACCE,'SEG_ACCES') ACCESO,");
		  buf.append("        TS.SBAC_OID_SBAC OID_SUBACCESO, ");
		  buf.append("        PQ_APL_AUX.Valor_Gen_I18n_Sicc(" + idioma + ",TS.SBAC_OID_SBAC,'SEG_SUBAC') SUBACCESO,");
		  buf.append("        TSP.MONE_OID_MONE OID_MONEDA, ");
		  buf.append("        PQ_APL_AUX.Valor_Gen_I18n_Sicc(" + idioma + ",CASE WHEN (TSP.MONE_OID_MONE IS NOT NULL) THEN TSP.MONE_OID_MONE ELSE ");
      buf.append(" (SELECT MONE_OID_MONE FROM SEG_PAIS WHERE OID_PAIS = " + pais + ") END,'SEG_MONED') MONEDA,");
   		buf.append("        TS.TICL_OID_TIPO_CLIE TIPO_CLIENTE, ");
		  buf.append("        P.OID_PERI OID_PERIODO, ");
		  buf.append("        P.VAL_NOMB_PERI PERIODO, ");
		  buf.append("        TSP.IND_RESE_STOC RESERVA_STOCK ");
      buf.append(" FROM PED_TIPO_SOLIC_PAIS TSP, ");
			buf.append("      SEG_MARCA M, ");
			buf.append("      PED_TIPO_SOLIC TS, ");
			buf.append("      SEG_CANAL C, ");
			buf.append("      SEG_ACCES AC, ");
			buf.append("      PED_CLASE_SOLIC CS, ");
			buf.append("      CRA_PERIO P ");
      buf.append(" WHERE TSP.PAIS_OID_PAIS = " + pais );
      if(belcenter != null && belcenter.booleanValue()) {
          buf.append("   AND ( AC.COD_ACCE = '" + ConstantesSEG.ACCESO_BELCENTER + "' OR AC.COD_ACCE = '" + ConstantesSEG.ACCESO_CALLCENTER +"' ) ");
          buf.append("   AND CS.IND_ORDE_COMP = 1 ");
          buf.append("   AND C.COD_CANA = '" + ConstantesSEG.COD_CANAL_VD + "' ");
          if (subacceso != null){
            buf.append("   AND TS.SBAC_OID_SBAC = " + subacceso);
          }
      }
	    buf.append("   AND TSP.TSOL_OID_TIPO_SOLI = TS.OID_TIPO_SOLI ");
      buf.append("   AND TS.CLSO_OID_CLAS_SOLI = CS.OID_CLAS_SOLI ");
	    buf.append("   AND TS.MARC_OID_MARC = M.OID_MARC ");
	    buf.append("   AND TS.ACCE_OID_ACCE = AC.OID_ACCE ");
	    buf.append("   AND AC.CANA_OID_CANA = C.OID_CANA ");
      buf.append("   AND P.FEC_INIC <= to_date('"+dt.format(new Date(System.currentTimeMillis()))+"','DD-MM-YYYY') ");
      buf.append("   AND P.FEC_FINA >= to_date('"+dt.format(new Date(System.currentTimeMillis()))+"','DD-MM-YYYY') ");
      buf.append("   AND P.PAIS_OID_PAIS = TSP.PAIS_OID_PAIS ");
      buf.append("   AND P.MARC_OID_MARC = TS.MARC_OID_MARC ");
      buf.append("   AND P.CANA_OID_CANA = AC.CANA_OID_CANA ");
      buf.append(" ORDER BY OID_TSP ");
    
    /*
      //SELECT
      buf.append("SELECT DISTINCT AC.COD_ACCE, TSP.OID_TIPO_SOLI_PAIS OID_TSP, GEN_TS.VAL_I18N TIPO_SOLICITUD, ");
      buf.append("M.OID_MARC OID_MARCA, M.DES_MARC MARCA, C.OID_CANA OID_CANAL, GEN_C.VAL_I18N CANAL, "); 
      buf.append("AC.OID_ACCE OID_ACCESO, GEN_AC.VAL_I18N ACCESO, TS.SBAC_OID_SBAC OID_SUBACCESO, ");
      buf.append("GEN_SAC.VAL_I18N SUBACCESO, TSP.MONE_OID_MONE OID_MONEDA, GEN_MO.VAL_I18N MONEDA, ");
      buf.append("TS.TICL_OID_TIPO_CLIE TIPO_CLIENTE, P.OID_PERI OID_PERIODO, P.VAL_NOMB_PERI PERIODO, TSP.IND_RESE_STOC RESERVA_STOCK ");
      
      //FROM
      buf.append(" FROM PED_TIPO_SOLIC_PAIS TSP, GEN_I18N_SICC GEN_TS, SEG_MARCA M, PED_TIPO_SOLIC TS, ");
      buf.append(" GEN_I18N_SICC GEN_C, SEG_CANAL C, SEG_ACCES AC, GEN_I18N_SICC GEN_AC, GEN_I18N_SICC GEN_SAC, ");
      buf.append(" GEN_I18N_SICC GEN_MO, PED_CLASE_SOLIC CS, CRA_PERIO P ");
      
      //WHERE  
      buf.append("WHERE GEN_TS.VAL_OID = TSP.TSOL_OID_TIPO_SOLI AND GEN_TS.IDIO_OID_IDIO = " + idioma + " AND GEN_TS.ATTR_ENTI = 'PED_TIPO_SOLIC' AND ");
      // PAIS = RECIBIDO  
      buf.append("TSP.PAIS_OID_PAIS = " + pais + " AND ");
      
      if(belcenter != null && belcenter.booleanValue()) {
          buf.append("TS.ACCE_OID_ACCE = AC.OID_ACCE AND ");
          buf.append("( AC.COD_ACCE = '" + ConstantesSEG.ACCESO_BELCENTER + "' OR AC.COD_ACCE = '" + ConstantesSEG.ACCESO_CALLCENTER +"' ) AND ");
          buf.append("TSP.TSOL_OID_TIPO_SOLI = TS.OID_TIPO_SOLI AND TS.CLSO_OID_CLAS_SOLI = CS.OID_CLAS_SOLI AND CS.IND_ORDE_COMP = 1 AND ");
          buf.append("TS.ACCE_OID_ACCE = AC.OID_ACCE ");
          buf.append(" AND AC.CANA_OID_CANA = C.OID_CANA AND C.COD_CANA = '" + ConstantesSEG.COD_CANAL_VD + "' AND  ");
          if (subacceso != null){
              buf.append("TS.SBAC_OID_SBAC = " + subacceso + " AND ");
          }
      }
      
      // MARCA  
      buf.append(" TSP.TSOL_OID_TIPO_SOLI = TS.OID_TIPO_SOLI AND TS.MARC_OID_MARC = M.OID_MARC AND ");
      // CANAL  
      buf.append(" TS.ACCE_OID_ACCE = AC.OID_ACCE AND AC.CANA_OID_CANA = C.OID_CANA AND GEN_C.VAL_OID = C.OID_CANA AND GEN_C.IDIO_OID_IDIO = " + idioma + " AND GEN_C.ATTR_ENTI = 'SEG_CANAL' AND ");
      // ACCESO  
      buf.append(" TS.ACCE_OID_ACCE = AC.OID_ACCE AND GEN_AC.VAL_OID = AC.OID_ACCE AND GEN_AC.IDIO_OID_IDIO = " + idioma + " AND GEN_AC.ATTR_ENTI = 'SEG_ACCES' AND ");
      // SUBACCESO 
      buf.append(" GEN_SAC.VAL_OID = TS.SBAC_OID_SBAC AND GEN_SAC.IDIO_OID_IDIO = " + idioma + " AND GEN_SAC.ATTR_ENTI = 'SEG_SUBAC' AND ");
      // MONEDA 
      buf.append(" ((gen_mo.val_oid = tsp.mone_oid_mone ");
			buf.append(" AND tsp.mone_oid_mone is not null) ");
			buf.append(" OR (tsp.mone_oid_mone is null ");
			buf.append(" AND gen_mo.val_oid = (select pais.MONE_OID_MONE ");
      buf.append(" from seg_pais pais ");
      buf.append(" where pais.OID_PAIS = ").append(pais).append(" ) ");
      buf.append(" ) ");
			buf.append(" ) ");
      //buf.append(" GEN_MO.VAL_OID = TSP.MONE_OID_MONE AND GEN_MO.IDIO_OID_IDIO = " + idioma + " AND GEN_MO.ATTR_ENTI = 'SEG_MONED' ");  
      buf.append(" AND GEN_MO.IDIO_OID_IDIO = " + idioma + " AND GEN_MO.ATTR_ENTI = 'SEG_MONED' ");  
      // PERIODO 
      SimpleDateFormat dt = new SimpleDateFormat("dd-MM-yyyy");
      buf.append(" AND P.FEC_INIC <= to_date('"+dt.format(new Date(System.currentTimeMillis()))+"','DD-MM-YYYY') ");
      buf.append(" AND P.FEC_FINA >= to_date('"+dt.format(new Date(System.currentTimeMillis()))+"','DD-MM-YYYY') ");
      buf.append(" AND P.PAIS_OID_PAIS = TSP.PAIS_OID_PAIS ");
      buf.append(" AND P.MARC_OID_MARC = TS.MARC_OID_MARC ");
      buf.append(" AND TS.ACCE_OID_ACCE = AC.OID_ACCE ");
      buf.append(" AND P.CANA_OID_CANA = AC.CANA_OID_CANA ");

      //AGREGADO POR jquiroga para que tenga sentido el metodo MONRegistroOnline.crearDTOTiposSolicitud() 
      buf.append(" Order by OID_TSP");
      */
      
      /* Fin Modificacion por Performance alorenzo 14/07/2006 */
      rs = bs.dbService.executeStaticQuery(buf.toString());
    }
    catch(Exception e) {
      UtilidadesLog.error("Exception: ",e);
      throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
    }
    UtilidadesLog.info("DAORegistroOnline.obtenerTiposSolicitud(Long pais, Long idioma, Long subacceso, Boolean belcenter): Salida ");
    return rs; 
  }

  public RecordSet obtenerDatosCliente(Long oidPais, String codCliente) throws MareException
  {
    UtilidadesLog.info("DAORegistroOnline.obtenerDatosCliente(Long oidPais, String codCliente): Entrada ");
    BelcorpService bs;
    RecordSet rs;
    StringBuffer buf = new StringBuffer();
    try {
      bs = BelcorpService.getInstance();
    }
    catch(MareMiiServiceNotFoundException e) {
      throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
    }
    try {
      //SELECT
      buf.append("SELECT  CL.OID_CLIE OID_CLIENTE, CL.VAL_NOM1 NOMBRE, CONCAT(CL.VAL_APE1,CONCAT(' ',CL.VAL_APE2)) APELLIDOS, CDA.IMP_MONT_LINE_CRED LINEA_CREDITO ");
      
      //FROM
      buf.append(" FROM MAE_CLIEN CL, MAE_CLIEN_DATOS_ADICI CDA ");
      
      //WHERE  
      buf.append(" WHERE CL.PAIS_OID_PAIS = " + oidPais + " AND CL.COD_CLIE = '" + codCliente + "' AND CDA.CLIE_OID_CLIE = CL.OID_CLIE");

      rs = bs.dbService.executeStaticQuery(buf.toString());
    }
    catch(Exception e) {
      UtilidadesLog.error("Exception: ",e);
      throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
    }
    UtilidadesLog.info("DAORegistroOnline.obtenerDatosCliente(Long oidPais, String codCliente): Salida ");
    return rs; 
  }

  public RecordSet buscarSolicitudesCambiosVentas(DTOCambiosVentas dtoE) throws MareException
  {
    UtilidadesLog.info("DAORegistroOnline.buscarSolicitudesCambiosVentas(DTOCambiosVentas dtoE): Entrada ");
    // Obtener las solicitudes que cumplan los criterios de entrada además de: 
    // - Fecha = Fecha del sistema 
    // - Indicador de OC = Activo 
    // - Indicador TS no consolidado = Desactivo 
    // - Indicador cambio/venta Belcenter = Activo 
    // El resultado se ordenará por: pais,tipo solicitud,canal,acceso,subacceso,numero solicitud 
    // El número de solicitud puede venir nulo en la entrada y no se tendra en cuenta en ese caso      
    BelcorpService bs;
    RecordSet rs;
    StringBuffer buf = new StringBuffer();
    SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
       
    try {
      bs = BelcorpService.getInstance();
    }
    catch(MareMiiServiceNotFoundException e) {
      throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
    }
    try {
      buf.append(" SELECT "); 
      buf.append(" SC.OID_SOLI_CABE OID,  "); 
      buf.append(" SC.PAIS_OID_PAIS PAIS,  "); 
      buf.append(" SC.TSPA_OID_TIPO_SOLI_PAIS TIPO_SOLICITUD,  "); 
      buf.append(" CA.COD_CANA CANAL,  "); 
      buf.append(" AC.COD_ACCE ACCESO,  "); 
      buf.append(" SB.COD_SBAC SUBACCESO,  "); 
      buf.append(" SC.VAL_NUME_SOLI NUMERO_SOLICITUD,  "); 
      buf.append(" SC.VAL_TOTA_PAGA_LOCA TOTAL_PAGAR_LOCAL "); 
      
      buf.append(" FROM  "); 
      buf.append(" PED_SOLIC_CABEC SC,  "); 
      buf.append(" SEG_SUBAC SB,  "); 
      buf.append(" SEG_ACCES AC,  "); 
      buf.append(" SEG_CANAL CA,  "); 
      buf.append(" PED_TIPO_SOLIC_PAIS TSP  "); 
      
      buf.append(" WHERE  ");

      /* PAIS */
      buf.append("SC.PAIS_OID_PAIS =  " + dtoE.getOidPais() + " AND ");
      
      /* SUBACCESO */ 
      buf.append(" SC.SBAC_OID_SBAC = SB.OID_SBAC AND "); 
      buf.append(" SC.SBAC_OID_SBAC = " + dtoE.getOidSubacceso() + " AND "); 
      
      /* ACCESO */ 
      buf.append(" SB.ACCE_OID_ACCE = AC.OID_ACCE AND "); 
      
      /* CANAL */ 
      buf.append(" AC.CANA_OID_CANA = CA.OID_CANA AND "); 
      
      /* NUMERO SOLICITUD */
      if(dtoE.getNumeroSolicitud()!=null)
        buf.append(" SC.VAL_NUME_SOLI = " + dtoE.getNumeroSolicitud() + " AND ");
      
      /* FECHA */
      buf.append(" SC.FEC_CRON = TRUNC(TO_DATE('"+dt.format(new Date(System.currentTimeMillis()))+"','YYYY-MM-DD')) AND ");
     
      /* ORDEN DE COMPRA ACTIVO*/ 
      //buf.append(" SC.IND_OC = 1 AND "); 
      buf.append(" SC.IND_OC = 0 AND "); 
      
      /* TS NO CONSOLIDADO DESACTIVO*/ 
      buf.append(" (SC.IND_TS_NO_CONSO = 0 OR SC.IND_TS_NO_CONSO IS NULL) AND "); 
      
      /* CAMBIO VENTA BELCENTER ACTIVO */ 
      buf.append(" SC.TSPA_OID_TIPO_SOLI_PAIS = TSP.OID_TIPO_SOLI_PAIS AND TSP.IND_CAMB_VENT_BEL = 1 "); 
      
      
      buf.append(" ORDER BY "); 
      buf.append(" PAIS,TIPO_SOLICITUD,CANAL,ACCESO,SUBACCESO,NUMERO_SOLICITUD ");      
      
      rs = bs.dbService.executeStaticQuery(buf.toString());
    }
    catch(Exception e) {
      UtilidadesLog.error("Exception: ",e);
      throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
    }
    UtilidadesLog.info("DAORegistroOnline.buscarSolicitudesCambiosVentas(DTOCambiosVentas dtoE): Salida ");
    return rs; 
  }
  
  public BigDecimal  calcularMontoDevuelve(Long oidSolicitud) throws MareException
  {
    UtilidadesLog.info("DAORegistroOnline.calcularMontoDevuelve(Long oidSolicitud): Entrada ");
    BelcorpService bs;
    RecordSet rs;
    StringBuffer buf = new StringBuffer();
    try {
      bs = BelcorpService.getInstance();
    }
    catch(MareMiiServiceNotFoundException e) {
      throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
    }
    try {
      buf.append(" SELECT  ");
      buf.append(" SUM(SC2.VAL_PREC_FACT_TOTA_LOCA * -1) MONTO_DEVUELVE ");
      
      buf.append(" FROM "); 
      buf.append(" BEL_MOVIM_CAJA_CABEC MCC, "); 
      buf.append(" BEL_MOVIM_CAJA_DETAL MCD, "); 
      buf.append(" PED_SOLIC_CABEC SC, "); 
      buf.append(" PED_SOLIC_CABEC SC2 ");
      
      buf.append(" WHERE "); 
      buf.append(" SC.OID_SOLI_CABE = " + oidSolicitud + " AND "); 
      buf.append(" MCC.SOCA_OID_SOLI_CABE = SC.OID_SOLI_CABE AND "); 
      buf.append(" MCD.MCAC_OID_CABE = MCC.OID_CABE AND ");
      buf.append(" MCD.SOCA_OID_SOLI_CABE_NOTA = SC2.OID_SOLI_CABE ");

      rs = bs.dbService.executeStaticQuery(buf.toString());
    }
    catch(Exception e) {
      UtilidadesLog.error("Exception: ",e);
      throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
    }    

    if (rs.esVacio()){
        UtilidadesLog.info("DAORegistroOnline.calcularMontoDevuelve(Long oidSolicitud): Salida ");
        return null;
    } else{
        UtilidadesLog.info("DAORegistroOnline.calcularMontoDevuelve(Long oidSolicitud): Salida ");
        return (BigDecimal)rs.getValueAt(0,0);  
    }
  }  
  
  public RecordSet simularCambiosVentas(DTOOID dtoE) throws MareException
  {
    UtilidadesLog.info("DAORegistroOnline.simularCambiosVentas(DTOOID dtoE): Entrada ");
    BelcorpService bs;
    RecordSet rs;
    StringBuffer buf = new StringBuffer();
    try {
      bs = BelcorpService.getInstance();
    }
    catch(MareMiiServiceNotFoundException e) {
      throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
    }
    try {
      buf.append(" SELECT ");
      buf.append(" GEN_P.VAL_I18N PRODUCTO, "); 
      buf.append(" SP.NUM_UNID_ATEN UNIDADES_ATENDIDAS, "); 
      buf.append(" SP.VAL_PREC_FACT_UNIT_LOCA MONTO, ");
      buf.append(" SP.NUM_UNID_CAMB UNIDADES_CAMBIO, ");
      buf.append(" SP.NUM_UNID_VENT UNIDADES_VENTA ");
      
      buf.append(" FROM ");
      buf.append(" PED_SOLIC_POSIC SP, ");
      buf.append(" GEN_I18N_SICC_PAIS GEN_P "); 
      
      buf.append(" WHERE "); 
      buf.append(" GEN_P.ATTR_ENTI = 'MAE_PRODU' AND "); 
      buf.append(" GEN_P.ATTR_NUM_ATRI = 1 AND "); 
      buf.append(" GEN_P.IDIO_OID_IDIO = " + dtoE.getOidIdioma() + " AND "); 
      buf.append(" GEN_P.VAL_OID = SP.PROD_OID_PROD AND "); 
      buf.append(" SP.SOCA_OID_SOLI_CABE = " + dtoE.getOid() + " "); 

      rs = bs.dbService.executeStaticQuery(buf.toString());
    }
    catch(Exception e) {
      UtilidadesLog.error("Exception: ",e);
      throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
    }
    UtilidadesLog.info("DAORegistroOnline.simularCambiosVentas(DTOOID dtoE): Salida ");
    return rs;
  }
  
  public Long obtenerNumeroUnidadesVendidas(Long oidSolicitud) throws MareException
  {
    UtilidadesLog.info("DAORegistroOnline.obtenerNumeroUnidadesVendidas(Long oidSolicitud): Entrada ");
    BelcorpService bs;
    RecordSet rs;
    StringBuffer buf = new StringBuffer();
    try {
      bs = BelcorpService.getInstance();
    }
    catch(MareMiiServiceNotFoundException e) {
      throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
    }
    try {
      buf.append(" SELECT ");
      buf.append(" SUM(SP.NUM_UNID_ATEN) UNIDADES_VENDIDAS ");
      
      buf.append(" FROM "); 
      buf.append(" PED_SOLIC_POSIC SP "); 
      
      buf.append(" WHERE "); 
      buf.append(" SP.SOCA_OID_SOLI_CABE = " + oidSolicitud + " AND "); 
      buf.append(" SP.ESPO_OID_ESTA_POSI <> " + ConstantesPED.ESTADO_POSICION_ANULADO + " ");

      rs = bs.dbService.executeStaticQuery(buf.toString());
    }
    catch(Exception e) {
      UtilidadesLog.error("Exception: ",e);
      throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
    }    

    if (rs.esVacio() || rs.getValueAt(0,0) == null){
        UtilidadesLog.info("DAORegistroOnline.obtenerNumeroUnidadesVendidas(Long oidSolicitud): Entrada ");
        return null;
    } else {
        UtilidadesLog.info("DAORegistroOnline.obtenerNumeroUnidadesVendidas(Long oidSolicitud): Entrada ");
        return new Long(((BigDecimal)rs.getValueAt(0,0)).longValue());    
    }
  }  
  
  public RecordSet obtenerPosicionesCambioVenta(Long oidSolicitud) throws MareException
  {
  
    UtilidadesLog.info("DAORegistroOnline.obtenerPosicionesCambioVenta(Long oidSolicitud): Entrada ");
    BelcorpService bs;
    RecordSet rs;
    StringBuffer buf = new StringBuffer();
    try {
      bs = BelcorpService.getInstance();
    }
    catch(MareMiiServiceNotFoundException e) {
      throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
    }
    try {
      buf.append(" SELECT ");
      buf.append(" SP.OID_SOLI_POSI OID, "); 
      buf.append(" SP.PROD_OID_PROD OID_PRODUCTO, "); 
      buf.append(" MP.COD_SAP COD_PRODUCTO, "); 
      buf.append(" SP.VAL_CODI_VENT CODIGO_VENTA, "); 
      buf.append(" SP.COD_POSI NUMERO_POSICION, "); 
      buf.append(" SP.NUM_UNID_ATEN UNIDADES_ATENDIDAS, "); 
      buf.append(" SP.VAL_PREC_FACT_UNIT_LOCA PRECIO_UNITARIO, "); 
      buf.append(" SP.NUM_UNID_CAMB UNIDADES_CAMBIO, "); 
      buf.append(" SP.NUM_UNID_VENT UNIDADES_VENTA "); 
      
      buf.append(" FROM "); 
      buf.append(" PED_SOLIC_POSIC SP, "); 
      buf.append(" MAE_PRODU MP ");
      
      buf.append(" WHERE "); 
      buf.append(" SP.SOCA_OID_SOLI_CABE = " + oidSolicitud + " AND "); 
      buf.append(" MP.OID_PROD = SP.PROD_OID_PROD "); 
      buf.append(" ORDER BY PRECIO_UNITARIO DESC ");
      
      rs = bs.dbService.executeStaticQuery(buf.toString());
    }
    catch(Exception e) {
      UtilidadesLog.error("Exception: ",e);
      throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
    }
    UtilidadesLog.info("DAORegistroOnline.obtenerPosicionesCambioVenta(Long oidSolicitud): Salida ");
    return rs;
  }
  
  public void actualizarPosicionCambioVenta(DTOPosicionCambioVenta dtoE) throws MareException
  {
    UtilidadesLog.info("DAORegistroOnline.actualizarPosicionCambioVenta(DTOPosicionCambioVenta dtoE): Entrada ");
    BelcorpService bs;
    StringBuffer buf = new StringBuffer();    
    try {
      bs = BelcorpService.getInstance();
    }
    catch(MareMiiServiceNotFoundException e) {
      throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
    }

    try {
      buf.append(" UPDATE PED_SOLIC_POSIC ");
      buf.append(" SET ");
      buf.append(" NUM_UNID_VENT = (DECODE(NUM_UNID_VENT,NULL,0,NUM_UNID_VENT) + " + dtoE.getUnidadesVenta() + "), "); 
      buf.append(" NUM_UNID_CAMB = (DECODE(NUM_UNID_CAMB,NULL,0,NUM_UNID_CAMB) + " + dtoE.getUnidadesCambio() + ") " );
      buf.append(" WHERE OID_SOLI_POSI=" + dtoE.getOid());
      
      bs.dbService.executePreparedUpdate(buf.toString(), new Vector());
    }
    catch (Exception e) {
      UtilidadesLog.error("Exception: ",e);
      throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
    }
    UtilidadesLog.info("DAORegistroOnline.actualizarPosicionCambioVenta(DTOPosicionCambioVenta dtoE): Salida ");
  }
  
  /*
   * Fecha de Creacion: 19/05/2005
   * Autor: Damasia Maneiro
   * Comentario:  Obtiene la información necesaria para generar una posicion de 
   * solicitud que será utilizada en el proceso de simulación de cuadre de ofertas 
   * */  
  /*
   * Autor: Cortaberría
   * Fecha: 19/05/2005
   * Se estaba creando un nuevo objeto posicion en vez de completar el recibido por parámetro.
   * 
   * Autor: Pperanzola
   * Fecha: 08/08/2005
   * Estaban invertidas las columnas IND_CNDT y NUM_POSI_RANK
   */
   public DTOPosicionSolicitud obtenerPosicionSimularCuadre(DTOPosicionSolicitud posicion)throws MareException{
    UtilidadesLog.info("DAORegistroOnline.obtenerPosicionSimularCuadre(DTOPosicionSolicitud posicion): Entrada ");
    BelcorpService bs;
    RecordSet rs;
    StringBuffer buf = new StringBuffer();
    
    try {
      bs = BelcorpService.getInstance();
    } catch(MareMiiServiceNotFoundException e) {
      throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
    }
    
    try {
      //SELECT
      buf.append("SELECT A.OFER_OID_OFER, B.NUM_OFER, D.NUM_GRUP, C.TIES_OID_TIPO_ESTR, F.OID_IND_CUAD,");
      buf.append("D.COD_FACT_CUAD, D.IND_CNDT, A.NUM_POSI_RANK, A.VAL_FACT_REPE, A.OCAT_OID_CATAL, G.LIPR_OID_LINE_PROD,");
      buf.append("A.NUM_PAGI_CATA, A.IMP_PREC_CATA, A.IMP_PREC_POSI ");
      
      //FROM
      buf.append("FROM PRE_OFERT_DETAL A, PRE_OFERT B, PRE_ESTRA C, PRE_GRUPO_OFERT D, PRE_INDIC_CUADR_TIPO_ESTRA E, PRE_INDIC_CUADR F, MAE_PRODU G ");
      
      //WHERE  
      buf.append("WHERE A.OID_DETA_OFER = " + posicion.getOidDetalleOferta());
      buf.append(" AND B.OID_OFER = A.OFER_OID_OFER ");
      buf.append("AND B.COES_OID_ESTR = C.OID_ESTR ");
      buf.append("AND A.OFER_OID_OFER = D.OFER_OID_OFER (+) ");
      buf.append("AND D.OID_GRUP_OFER (+) = A.GOFE_OID_GRUP_OFER ");
      buf.append("AND D.CUES_OID_IND_CUAD_TIPO_ESTR = E.OID_IND_CUAD_TIPO_ESTR (+) ");
      buf.append("AND E.INDC_OID_INDI_CUAD = F.OID_IND_CUAD (+) ");
      buf.append("AND A.PROD_OID_PROD= G.OID_PROD ");
      
      rs = bs.dbService.executeStaticQuery(buf.toString());
      
        
    } catch(Exception e) {
      UtilidadesLog.error("Exception: ",e);
      throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
    }
       
   if(rs.esVacio() || rs.getValueAt(0,0) == null){
        UtilidadesLog.info("DAORegistroOnline.obtenerPosicionSimularCuadre(DTOPosicionSolicitud posicion): Salida ");
        return null;
   } else{
      //DTOPosicionSolicitud posicionSolicitud = new DTOPosicionSolicitud();    
       
      if(rs.getValueAt(0,0)!= null){     
        BigDecimal oidOferta = (BigDecimal)rs.getValueAt(0,0);
        posicion.setOidOferta(new Long(oidOferta.longValue()));     
      }    
     
      if(rs.getValueAt(0,1)!= null){     
        BigDecimal numOferta = (BigDecimal)rs.getValueAt(0,1);
        posicion.setNumeroOferta(new Integer(numOferta.intValue()));
      }    
      
      if(rs.getValueAt(0,2)!= null){     
        BigDecimal grupo = (BigDecimal)rs.getValueAt(0,2);
        posicion.setGrupo(new Integer(grupo.intValue()));   
      }    
      
       if(rs.getValueAt(0,3)!= null){     
        BigDecimal tipoEstrategia = (BigDecimal)rs.getValueAt(0,3);
        posicion.setTipoEstrategia(new Long(tipoEstrategia.longValue()));  
      }    
      
       if(rs.getValueAt(0,4)!= null){     
        BigDecimal indicadorCuadre = (BigDecimal)rs.getValueAt(0,4);
        posicion.setIndicadorCuadre(new Long(indicadorCuadre.longValue()));
      }      
      
      if(rs.getValueAt(0,5)!= null){     
        BigDecimal factorCuadre = (BigDecimal)rs.getValueAt(0,5);
        posicion.setFactorCuadre(new Long(factorCuadre.longValue()));
      }      
      
  
      if(rs.getValueAt(0,"IND_CNDT")!= null){     
        BigDecimal indCondicionante = (BigDecimal)rs.getValueAt(0,"IND_CNDT");
        
        if(indCondicionante.intValue()>0)
          posicion.setIndCondicionante(new Boolean(true));
        else
          posicion.setIndCondicionante(new Boolean(false));              
      } 
      
      if(rs.getValueAt(0,"NUM_POSI_RANK")!= null){     
        BigDecimal posicionRanking = (BigDecimal)rs.getValueAt(0,"NUM_POSI_RANK");
        posicion.setPosicionRanking(new Long(posicionRanking.longValue()));
      }  
      
      if(rs.getValueAt(0,8)!= null){     
        BigDecimal factorRepeticion =(BigDecimal)rs.getValueAt(0,8);
        posicion.setFactorRepeticion(new Integer(factorRepeticion.intValue()));
      }   
      
      if(rs.getValueAt(0,9)!= null){     
        BigDecimal catalogo = (BigDecimal)rs.getValueAt(0,9);
        posicion.setCatalogo(new Long(catalogo.intValue()));
      }   
      
      if(rs.getValueAt(0,10)!= null){     
        BigDecimal lineaProducto = (BigDecimal)rs.getValueAt(0,10);
        posicion.setLineaProducto(new Long(lineaProducto.intValue()));
      }   
     
      if(rs.getValueAt(0,11)!= null){     
        BigDecimal pagina = (BigDecimal)rs.getValueAt(0,11);
        posicion.setPagina(new Integer(pagina.intValue()));
      }        
   
      if(rs.getValueAt(0,12)!= null){         
        posicion.setPrecioCatalogoUnitarioLocal((BigDecimal)rs.getValueAt(0,12));
      }          
      
      if(rs.getValueAt(0,13)!= null){         
        posicion.setPrecioContableUnitarioLocal((BigDecimal)rs.getValueAt(0,13));
      }       
     UtilidadesLog.info("DAORegistroOnline.obtenerPosicionSimularCuadre(DTOPosicionSolicitud posicion): Salida ");
     return posicion;  
    
    }
      
   }
   
     public Long obtenerSaldo(Long almacen, String codigoLibreDisposicion, Long producto, Long pais) throws MareException{
        UtilidadesLog.info("DAORegistroOnline.obtenerSaldo(Long Almacen, String codigoLibreDisposicion, Long producto, Long pais): Entrada ");
        BelcorpService bs;
        RecordSet r = null;
        StringBuffer buf = new StringBuffer();    
        try {
          bs = BelcorpService.getInstance();
        }
        catch(MareMiiServiceNotFoundException e) {
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
    
        try {
          buf.append(" SELECT VAL_SALD FROM BEL_STOCK c, BEL_ESTAD_MERCA d ");
          buf.append(" WHERE ");
          buf.append(" c.ALMC_OID_ALMA = "+almacen); 
          buf.append(" AND c.PROD_OID_PROD = "+producto );
          buf.append(" AND d.OID_ESTA_MERC = c.ESME_OID_ESTA_MERC ");
          buf.append(" AND d.COD_ESTA = '"+codigoLibreDisposicion+"'");
          buf.append(" AND d.PAIS_OID_PAIS = "+pais);
          
          r = bs.dbService.executeStaticQuery(buf.toString());
        }
        catch (Exception e) {
          UtilidadesLog.error("Exception: ",e);
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        if (r == null || r.esVacio()){
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        UtilidadesLog.info("DAORegistroOnline.obtenerSaldo(Long Almacen, String codigoLibreDisposicion, Long producto, Long pais): Salida ");
        return Long.valueOf(r.getValueAt(0,0).toString());    
    }
}