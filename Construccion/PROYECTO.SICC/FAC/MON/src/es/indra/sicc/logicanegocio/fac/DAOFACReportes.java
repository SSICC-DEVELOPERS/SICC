package es.indra.sicc.logicanegocio.fac;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.fac.DTOFACReporte;
import es.indra.sicc.logicanegocio.mae.ConstantesMAE;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;

public class DAOFACReportes 
{
  public DAOFACReportes()
  {
  }

  public RecordSet obtenerDatosSegmentosZonas(DTOFACReporte dtoe) throws MareException
  {
      StringBuffer sql = new StringBuffer("");

      sql.append(" SELECT count(*) ");
      sql.append(" FROM DTR_SEGME_ZONAS DSC ");
      sql.append(" WHERE DSC.PERD_OID_PERI = "+dtoe.getPeriodo());
      if (dtoe.getRegion() != null)
          sql.append(" AND DSC.ZORG_OID_REGI = "+dtoe.getRegion());
      if (dtoe.getZona() != null)
          sql.append(" AND DSC.ZZON_OID_ZONA = "+dtoe.getZona());	    

  
      BelcorpService bs = null;
      bs = BelcorpService.getInstance();
  
      RecordSet rs = null;
  
      // Obtenemos todos los registros
      try{
        rs = bs.dbService.executeStaticQuery(sql.toString());
      } catch(Exception e) {
        e.printStackTrace();
        throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
      }
      
      return rs;
  }
  
  public void eliminarRegistrosSegmentoZonaClientes(DTOFACReporte dtoe) throws MareException
  {
      StringBuffer sql = new StringBuffer("");
      StringBuffer sql2 = new StringBuffer("");

      sql.append(" delete FROM DTR_SEGME_ZONAS DSC ");
      sql2.append(" delete FROM DTR_SEGME_CLIEN DSC ");

      sql.append(" WHERE DSC.PERD_OID_PERI = "+dtoe.getPeriodo());
      sql2.append(" WHERE DSC.PERD_OID_PERI = "+dtoe.getPeriodo());
      if (dtoe.getRegion() != null){
          sql.append(" AND DSC.ZORG_OID_REGI = "+dtoe.getRegion());
          sql2.append(" AND DSC.ZORG_OID_REGI = "+dtoe.getRegion());
      }
      if (dtoe.getZona() != null){
          sql.append(" AND DSC.ZZON_OID_ZONA = "+dtoe.getZona());	    
          sql2.append(" AND DSC.ZZON_OID_ZONA = "+dtoe.getZona());	    
      }

  
      BelcorpService bs = null;
      bs = BelcorpService.getInstance();
  
      RecordSet rs = null;
  
      // Obtenemos todos los registros
      try{
        bs.dbService.executeUpdate(sql.toString());
        bs.dbService.executeUpdate(sql2.toString());
      } catch(Exception e) {
        e.printStackTrace();
        throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_BORRADO_DE_DATOS));
      }
      
  }
  
  public RecordSet obtenerDatosCabeceraSolicitud(DTOFACReporte dtoe) throws MareException
  {
      StringBuffer sql = new StringBuffer("");

      sql.append(" SELECT PSC.PERD_OID_PERI, ");
      sql.append(" REG.OID_REGI, ");
	    sql.append(" ZON.OID_ZONA, ");
	    sql.append(" PSC.CLIE_OID_CLIE, ");
	    sql.append(" NVL(SUM(PSC.VAL_PREC_NETO_TOTA_LOCA),0) VENTA, ");
	    sql.append(" COUNT(*) N_PEDIDOS, ");
	    sql.append(" DECODE(COUNT(*),0,0,NVL(SUM(PSC.VAL_PREC_NETO_TOTA_LOCA),0)/COUNT(*)) PMNP, ");
	    sql.append(" NVL(SUM(PSC.VAL_IMPO_DESC_1_TOTA_LOCA),0) IMP_DESC_1, ");
	    sql.append(" NVL(SUM(PSC.VAL_IMPO_DESC_3_TOTA_LOCA),0) IMP_DESC_3 ");
      sql.append(" FROM PED_SOLIC_CABEC PSC, ");
	    sql.append(" ZON_REGIO REG, ");
      sql.append(" ZON_ZONA ZON ");
      sql.append(" WHERE REG.OID_REGI = ZON.ZORG_OID_REGI ");
      sql.append(" AND PSC.ZZON_OID_ZONA = ZON.OID_ZONA  ");
      sql.append(" AND PSC.IND_TS_NO_CONSO = 0  ");
      sql.append(" AND PSC.IND_OC = 0 ");
      sql.append(" AND PSC.IND_PEDI_PRUE <> 1 ");
      sql.append(" AND PSC.FEC_FACT IS NOT NULL ");
      sql.append(" AND PSC.PAIS_OID_PAIS =  "+dtoe.getOidPais());
      sql.append(" AND PSC.PERD_OID_PERI =  "+dtoe.getPeriodo());
      if (dtoe.getRegion() != null)
          sql.append(" AND REG.OID_REGI = "+dtoe.getRegion());
      if (dtoe.getZona() != null)
          sql.append(" AND ZON.OID_ZONA = "+dtoe.getZona());	    
      sql.append(" GROUP BY PSC.PAIS_OID_PAIS, ");
	  	sql.append(" PSC.PERD_OID_PERI, ");
		  sql.append(" REG.OID_REGI, ");
		  sql.append(" ZON.OID_ZONA, ");
		  sql.append(" PSC.CLIE_OID_CLIE ");
  
      BelcorpService bs = null;
      bs = BelcorpService.getInstance();
  
      RecordSet rs = null;
  
      // Obtenemos todos los registros
      try{
        rs = bs.dbService.executeStaticQuery(sql.toString());
      } catch(Exception e) {
        e.printStackTrace();
        throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
      }
      
      return rs;
  }
  
  public RecordSet obtenerDatosSegmentosClientes(DTOFACReporte dtoe) throws MareException
  {
      StringBuffer sql = new StringBuffer("");

      sql.append(" SELECT DSC.PERD_OID_PERI, ");
	    sql.append(" DSC.ZORG_OID_REGI, ");
	    sql.append(" DSC.ZZON_OID_ZONA, ");
	    sql.append(" NVL(SUM(DSC.VAL_VENT),0) VENTA, ");
	    sql.append(" NVL(SUM(DSC.NUM_PEDI),0) N_PEDIDO, ");
	    sql.append(" ROUND(DECODE(NVL(SUM(DSC.NUM_PEDI),0), 0, 0,NVL(SUM(DSC.VAL_VENT),0)/SUM(DSC.NUM_PEDI)), 0) PMNP ");
      sql.append(" FROM DTR_SEGME_CLIEN DSC ");
      sql.append(" WHERE DSC.PERD_OID_PERI =  "+dtoe.getPeriodo());
      if (dtoe.getRegion() != null)
          sql.append(" AND DSC.ZORG_OID_REGI = "+dtoe.getRegion());
      if (dtoe.getZona() != null)
          sql.append(" AND DSC.ZZON_OID_ZONA = "+dtoe.getZona());	    
      sql.append(" GROUP BY DSC.PERD_OID_PERI, DSC.ZORG_OID_REGI,	 DSC.ZZON_OID_ZONA ");
  
      BelcorpService bs = null;
      bs = BelcorpService.getInstance();
  
      RecordSet rs = null;
  
      // Obtenemos todos los registros
      try{
        rs = bs.dbService.executeStaticQuery(sql.toString());
      } catch(Exception e) {
        e.printStackTrace();
        throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
      }
      
      return rs;
  }
  
  public RecordSet obtenerDatosSegmentosClientesNueva(DTOFACReporte dtoe) throws MareException
  {
      StringBuffer sql = new StringBuffer("");
  

      sql.append(" SELECT DSC.OID_SEGM_CLIE, 1 AS NIVEL ");
      sql.append(" FROM DTR_SEGME_CLIEN DSC, ");
      sql.append(" MAE_CLIEN_HISTO_ESTAT CHE ");
      sql.append(" WHERE CHE.CLIE_OID_CLIE = DSC.CLIE_OID_CLIE ");
      sql.append(" AND CHE.ESTA_OID_ESTA_CLIE = "+ConstantesMAE.ESTATUS_NUEVO);
      sql.append(" AND ((INSTR( ");
		  sql.append("  ( ");
			sql.append(" CASE WHEN (CHE.PERD_OID_PERI_PERI_FIN IS NOT NULL) THEN ");
		  sql.append(" (  ");
			sql.append(" SELECT FN_013_FACDTR_CONCAT_PERI(CHE.PERD_OID_PERI, CHE.PERD_OID_PERI_PERI_FIN) ");
			sql.append(" FROM DUAL ");
			sql.append(" ) ");
			sql.append(" ELSE ");
			sql.append(" '1' ");
			sql.append(" END ");
			sql.append(" ), ");
			sql.append(" ( ");
			sql.append(" CASE WHEN (CHE.PERD_OID_PERI_PERI_FIN IS NOT NULL)  THEN ");
			sql.append(" ','||(FN_008_CALC_OID_PER_ANT("+dtoe.getOidPais()+","+dtoe.getMarca()+","+dtoe.getCanal()+","+dtoe.getPeriodo()+",1))||',' ");
			sql.append(" ELSE ");
			sql.append(" '1' ");
			sql.append(" END ");
			sql.append(" ) ");
			sql.append(" ) > 0) ");
			sql.append(" OR ");
			sql.append(" (INSTR( ");
			sql.append(" ( ");
			sql.append(" CASE WHEN (CHE.PERD_OID_PERI_PERI_FIN IS NOT NULL) THEN ");
			sql.append(" ( ");
			sql.append(" SELECT FN_013_FACDTR_CONCAT_PERI(CHE.PERD_OID_PERI, CHE.PERD_OID_PERI_PERI_FIN) ");
			sql.append(" FROM DUAL ");
			sql.append(" ) ");
			sql.append(" ELSE ");
			sql.append(" '1' ");
			sql.append(" END ");
			sql.append(" ), ");
			sql.append(" ( ");
			sql.append(" CASE WHEN (CHE.PERD_OID_PERI_PERI_FIN IS NOT NULL)  THEN ");
			sql.append(" ','||(FN_008_CALC_OID_PER_ANT("+dtoe.getOidPais()+","+dtoe.getMarca()+","+dtoe.getCanal()+","+dtoe.getPeriodo()+",2))||',' ");
			sql.append(" ELSE ");
			sql.append(" '1' ");
			sql.append(" END ");
			sql.append(" ) ");
			sql.append(" ) > 0) ");
			sql.append(" OR ");
			sql.append(" (INSTR( ");
			sql.append(" ( ");
			sql.append(" CASE WHEN (CHE.PERD_OID_PERI_PERI_FIN IS NOT NULL) THEN ");
			sql.append(" ( ");
			sql.append(" SELECT FN_013_FACDTR_CONCAT_PERI(CHE.PERD_OID_PERI, CHE.PERD_OID_PERI_PERI_FIN) ");
			sql.append(" FROM DUAL ");
			sql.append(" ) ");
			sql.append(" ELSE ");
			sql.append(" '1' ");
			sql.append(" END ");
			sql.append(" ), ");
			sql.append(" ( ");
			sql.append(" CASE WHEN (CHE.PERD_OID_PERI_PERI_FIN IS NOT NULL)  THEN ");
			sql.append(" ','||(FN_008_CALC_OID_PER_ANT("+dtoe.getOidPais()+","+dtoe.getMarca()+","+dtoe.getCanal()+","+dtoe.getPeriodo()+",3))||',' ");
			sql.append(" ELSE ");
			sql.append(" '1' ");
			sql.append(" END ");
			sql.append(" ) ");
			sql.append(" ) > 0) ");
			sql.append(" OR ");
			sql.append(" (INSTR( ");
			sql.append(" ( ");
			sql.append(" CASE WHEN (CHE.PERD_OID_PERI_PERI_FIN IS NOT NULL) THEN ");
			sql.append(" ( ");
			sql.append(" SELECT FN_013_FACDTR_CONCAT_PERI(CHE.PERD_OID_PERI, CHE.PERD_OID_PERI_PERI_FIN) ");
			sql.append(" FROM DUAL ");
			sql.append(" ) ");
			sql.append(" ELSE ");
			sql.append(" '1' ");
			sql.append(" END ");
			sql.append(" ), ");
			sql.append(" ( ");
			sql.append(" CASE WHEN (CHE.PERD_OID_PERI_PERI_FIN IS NOT NULL)  THEN ");
			sql.append(" ','||(FN_008_CALC_OID_PER_ANT("+dtoe.getOidPais()+","+dtoe.getMarca()+","+dtoe.getCanal()+","+dtoe.getPeriodo()+",4))||',' ");//ver esto
			sql.append(" ELSE ");
			sql.append(" '1' ");
			sql.append("  END ");
			sql.append(" ) ");
			sql.append(" ) > 0)) ");
			sql.append(" AND DSC.NVSG_OID_NIVE_SEGM IS NULL ");
			sql.append(" AND DSC.PERD_OID_PERI =  "+dtoe.getPeriodo());
      if (dtoe.getRegion()!=null)
          sql.append(" AND DSC.ZORG_OID_REGI =  "+dtoe.getRegion());
      if (dtoe.getZona()!=null)
          sql.append(" AND DSC.ZZON_OID_ZONA = "+dtoe.getZona());
  
      BelcorpService bs = null;
      bs = BelcorpService.getInstance();
  
      RecordSet rs = null;
  
      // Obtenemos todos los registros
      try{
        rs = bs.dbService.executeStaticQuery(sql.toString());
      } catch(Exception e) {
        e.printStackTrace();
        throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
      }
      
      return rs;
  }
  
  public RecordSet obtenerDatosSegmentosClientesReingresos(DTOFACReporte dtoe) throws MareException
  {
      StringBuffer sql = new StringBuffer("");
  
      sql.append(" SELECT DSC.OID_SEGM_CLIE, ");
	    sql.append(" 8 AS NIVEL ");
	    sql.append(" FROM DTR_SEGME_CLIEN DSC, ");
	    sql.append(" MAE_CLIEN_HISTO_ESTAT CHE ");
	    sql.append(" WHERE CHE.CLIE_OID_CLIE = DSC.CLIE_OID_CLIE ");
	    sql.append(" AND DSC.NVSG_OID_NIVE_SEGM IS NULL ");
	    sql.append(" AND CHE.ESTA_OID_ESTA_CLIE = "+ConstantesMAE.ESTATUS_REINGRESO);
	    sql.append(" AND (INSTR( ");
	    sql.append(" ( ");
	    sql.append(" CASE WHEN (CHE.PERD_OID_PERI_PERI_FIN IS NOT NULL) THEN ");
	    sql.append(" ( ");
	    sql.append(" SELECT FN_013_FACDTR_CONCAT_PERI(CHE.PERD_OID_PERI, CHE.PERD_OID_PERI_PERI_FIN) ");
	    sql.append(" FROM DUAL ");
	    sql.append(" ) ");
	    sql.append(" ELSE ");
	    sql.append(" '1' ");
	    sql.append(" END ");
	    sql.append(" ), ");
	    sql.append(" ( ");
	    sql.append(" CASE WHEN (CHE.PERD_OID_PERI_PERI_FIN IS NOT NULL)  THEN ");
	    sql.append(" ','||"+dtoe.getPeriodo()+"||',' ");
	    sql.append(" ELSE ");
	    sql.append(" '1' ");
	    sql.append(" END ");
	    sql.append(" ) ");
	    sql.append(" ) > 0) ");
	    sql.append(" AND DSC.PERD_OID_PERI = "+dtoe.getPeriodo());
      if (dtoe.getRegion()!=null)
          sql.append(" AND DSC.ZORG_OID_REGI =  "+dtoe.getRegion());
      if (dtoe.getZona()!=null)
          sql.append(" AND DSC.ZZON_OID_ZONA = "+dtoe.getZona());
  
      BelcorpService bs = null;
      bs = BelcorpService.getInstance();
  
      RecordSet rs = null;
  
      // Obtenemos todos los registros
      try{
        rs = bs.dbService.executeStaticQuery(sql.toString());
      } catch(Exception e) {
        e.printStackTrace();
        throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
      }
      
      return rs;
  }
  
  public RecordSet obtenerDatosCalculoNiveles(DTOFACReporte dtoe) throws MareException
  {
      StringBuffer sql = new StringBuffer("");
  
      sql.append(" SELECT OID_SEGM_CLIE, ");
	    sql.append(" CASE WHEN (NIVEL IS NOT NULL) THEN");
	    sql.append(" NIVEL");
	    sql.append(" ELSE");
	    sql.append(" CASE WHEN (DIF >= 20) THEN");
	    sql.append(" 3");
	    sql.append(" ELSE");
	    sql.append(" CASE WHEN (DIF < 20 OR DIF > -20) THEN");
	    sql.append(" 4");
	    sql.append(" ELSE");
	    sql.append(" CASE WHEN (DIF <= -20) THEN");
	    sql.append(" 5");
	    sql.append(" END");
	    sql.append(" END");
	    sql.append(" END");
	    sql.append(" END NIVEL");
	    sql.append(" FROM");
	    sql.append(" (");
	    sql.append(" SELECT OID_SEGM_CLIE,");
	    sql.append(" PERD_OID_PERI,");
	    sql.append(" ZORG_OID_REGI,");
	    sql.append(" ZZON_OID_ZONA,");
	    sql.append(" CLIE_OID_CLIE,");
	    sql.append(" DECODE(VAL_PMNP,0,0,((VAL_VENT*100)/VAL_PMNP)-100) DIF, ");
	    sql.append(" CASE WHEN (PORC >= ORDEN) THEN");
	    sql.append(" 2");
	    sql.append(" END AS NIVEL ");
	    sql.append(" FROM");
	    sql.append(" (");
	    sql.append(" SELECT DSC.OID_SEGM_CLIE,");
	    sql.append(" DSC.PERD_OID_PERI,");
	    sql.append(" DSC.ZORG_OID_REGI,");
	    sql.append("  DSC.ZZON_OID_ZONA,");
	    sql.append(" DSC.CLIE_OID_CLIE,");
	    sql.append(" DSC.VAL_VENT, ");
	    sql.append(" DSZ.VAL_PMNP, ");
	    sql.append(" TRUNC((COUNT(*) OVER (PARTITION BY DSC.PERD_OID_PERI, DSC.ZORG_OID_REGI, DSC.ZZON_OID_ZONA)*0.1),0) + ");
	    sql.append(" CASE WHEN ((COUNT(*) OVER (PARTITION BY DSC.PERD_OID_PERI, DSC.ZORG_OID_REGI, DSC.ZZON_OID_ZONA)*0.1)- ");
	    sql.append(" TRUNC((COUNT(*) OVER (PARTITION BY DSC.PERD_OID_PERI, DSC.ZORG_OID_REGI, DSC.ZZON_OID_ZONA)*0.1),0) > 0) ");
	    sql.append(" THEN 1 ELSE 0 END PORC, ");
	    sql.append(" SUM(1) OVER (PARTITION BY DSC.PERD_OID_PERI, DSC.ZORG_OID_REGI, DSC.ZZON_OID_ZONA ORDER BY DSC.VAL_VENT DESC, DSC.CLIE_OID_CLIE)	ORDEN ");
	    sql.append(" FROM DTR_SEGME_CLIEN DSC, ");
	    sql.append(" DTR_SEGME_ZONAS DSZ");
	    sql.append(" WHERE DSZ.ZZON_OID_ZONA = DSC.ZZON_OID_ZONA ");
	    sql.append(" AND DSZ.ZORG_OID_REGI = DSC.ZORG_OID_REGI ");
	    sql.append("  AND DSZ.PERD_OID_PERI = DSC.PERD_OID_PERI ");
	    sql.append(" AND DSC.NVSG_OID_NIVE_SEGM IS NULL ");
	    sql.append(" AND DSC.PERD_OID_PERI = "+dtoe.getPeriodo());
	    if (dtoe.getRegion()!=null)
          sql.append(" AND DSC.ZORG_OID_REGI =  "+dtoe.getRegion());
      if (dtoe.getZona()!=null)
          sql.append(" AND DSC.ZZON_OID_ZONA = "+dtoe.getZona());
      sql.append(" )) ");
      BelcorpService bs = null;
      bs = BelcorpService.getInstance();
  
      RecordSet rs = null;
  
      // Obtenemos todos los registros
      try{
        rs = bs.dbService.executeStaticQuery(sql.toString());
      } catch(Exception e) {
        e.printStackTrace();
        throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
      }
      
      return rs;
  }
  
  public RecordSet obtenerDatosSegmentosEgresos(DTOFACReporte dtoe) throws MareException
  {
      StringBuffer sql = new StringBuffer("");

      sql.append(" SELECT "+dtoe.getPeriodo()+" AS PERIODO, ");
	    sql.append(" REG.OID_REGI,");
	    sql.append(" ZON.OID_ZONA,");
	    sql.append(" CUA.CLIE_OID_CLIE,");
	    sql.append(" 6 AS NIVEL	");
	    sql.append(" FROM MAE_CLIEN_UNIDA_ADMIN CUA,");
	    sql.append(" ZON_REGIO REG, ");
	    sql.append(" ZON_ZONA ZON, ");
	    sql.append(" ZON_SECCI SEC, ");
	    sql.append(" ZON_TERRI_ADMIN ZTA, ");
	    sql.append(" MAE_CLIEN_HISTO_ESTAT CHE ");
	    sql.append(" WHERE CUA.IND_ACTI = 1 ");
	    sql.append(" AND CUA.ZTAD_OID_TERR_ADMI = ZTA.OID_TERR_ADMI ");
	    sql.append(" AND REG.OID_REGI = ZON.ZORG_OID_REGI ");
	    sql.append(" AND ZON.OID_ZONA = SEC.ZZON_OID_ZONA ");
	    sql.append(" AND SEC.OID_SECC = ZTA.ZSCC_OID_SECC ");
	    sql.append(" AND CHE.CLIE_OID_CLIE = CUA.CLIE_OID_CLIE ");
	    sql.append(" AND CUA.CLIE_OID_CLIE NOT IN (SELECT DSC.CLIE_OID_CLIE ");
	    sql.append(" FROM DTR_SEGME_CLIEN DSC ");
	    sql.append(" WHERE DSC.PERD_OID_PERI =  "+dtoe.getPeriodo());
      if (dtoe.getRegion()!=null)
          sql.append(" AND DSC.ZORG_OID_REGI =  "+dtoe.getRegion());
      if (dtoe.getZona()!=null)
          sql.append(" AND DSC.ZZON_OID_ZONA = "+dtoe.getZona());
	    sql.append(" ) ");
	    sql.append(" AND CHE.ESTA_OID_ESTA_CLIE = "+ConstantesMAE.ESTATUS_NORMAL);
	    sql.append(" AND (INSTR( ");
	    sql.append(" ( ");
	    sql.append(" CASE WHEN (CHE.PERD_OID_PERI_PERI_FIN IS NOT NULL) THEN ");
	    sql.append(" ( ");
	    sql.append(" SELECT FN_013_FACDTR_CONCAT_PERI(CHE.PERD_OID_PERI, CHE.PERD_OID_PERI_PERI_FIN) ");
	    sql.append(" FROM DUAL ");
	    sql.append(" ) ");
	    sql.append(" ELSE ");
	    sql.append(" '1' ");
	    sql.append(" END ");
	    sql.append(" ), ");
	    sql.append(" ( ");
	    sql.append(" CASE WHEN (CHE.PERD_OID_PERI_PERI_FIN IS NOT NULL)  THEN ");
	    sql.append(" ','||"+dtoe.getPeriodo()+"||',' ");
	    sql.append(" ELSE ");
	    sql.append(" '1' ");
	    sql.append(" END ");
	    sql.append(" ) ");
	    sql.append(" ) > 0) ");
      if (dtoe.getRegion()!=null)
          sql.append(" AND REG.OID_REGI =  "+dtoe.getRegion());
      if (dtoe.getZona()!=null)
          sql.append(" AND ZON.OID_ZONA = "+dtoe.getZona());
   
   
	    

      BelcorpService bs = null;
      bs = BelcorpService.getInstance();
  
      RecordSet rs = null;
  
      // Obtenemos todos los registros
      try{
        rs = bs.dbService.executeStaticQuery(sql.toString());
      } catch(Exception e) {
        e.printStackTrace();
        throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
      }
      
      return rs;
  }
  
}