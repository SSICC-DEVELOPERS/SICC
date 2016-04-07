-- ACORDAR CON MATIAS LOS PARAMETROS QUE SE DEBEN MOSTRAR YA QUE TODOS SON DE SELECCION MULTIPLE -- 
 --O EN SU DEFECTO VALORES DESDE HASTA --


SELECT GEN_PAIS.VAL_I18N PAIS,
	   GEN_SOCI.VAL_I18N SOCI,
	   GEN_NEGO.VAL_I18N NEGOCIO,
	   PROD.COD_SAP CODIGO_P,
	   GEN_PROD.VAL_I18N PRODU,
	   NVL(SUM(SOL_POS.NUM_UNID_ATEN), 0) UNIDADES,
	   NVL(SUM(SOL_POS.VAL_PREC_CATA_TOTA_LOCA), 0) VALOR_VENTA,
	   NVL((SUM(SOL_POS.NUM_UNID_ATEN)*PROD.VAL_COST_ESTD), 0) COSTO
FROM PED_SOLIC_CABEC SOL_CAB,
	 ZON_SUB_GEREN_VENTA SUBG,
	 ZON_REGIO REG,
	 ZON_ZONA ZONA,
	 ZON_SECCI SEC,
	 ZON_TERRI TER,
	 ZON_TERRI_ADMIN TER_ADM,
	 PED_SOLIC_POSIC SOL_POS,
	 PED_ESTAD_POSIC EST_POS,
	 MAE_PRODU PROD,
	 (
	 SELECT GEN.VAL_OID, GEN.VAL_I18N
	 FROM V_GEN_I18N_SICC GEN
	 WHERE GEN.ATTR_ENTI = 'SEG_PAIS'
	 	   AND GEN.IDIO_OID_IDIO = 1 								-- PARAMETRO DE IDIOMA --
	 ) GEN_PAIS,
 	 (
	 SELECT GEN.VAL_OID, GEN.VAL_I18N
	 FROM V_GEN_I18N_SICC GEN
	 WHERE GEN.ATTR_ENTI = 'SEG_SOCIE'
	 	   AND GEN.IDIO_OID_IDIO = 1 								-- PARAMETRO DE IDIOMA --
	 ) GEN_SOCI,
 	 (
	 SELECT GEN.VAL_OID, GEN.VAL_I18N
	 FROM V_GEN_I18N_SICC GEN
	 WHERE GEN.ATTR_ENTI = 'MAE_NEGOC'
	 	   AND GEN.IDIO_OID_IDIO = 1 								-- PARAMETRO DE IDIOMA --
	 ) GEN_NEGO,
 	 (
	 SELECT GEN.VAL_OID, GEN.VAL_I18N
	 FROM V_GEN_I18N_SICC GEN
	 WHERE GEN.ATTR_ENTI = 'MAE_PRODU'
	 	   AND GEN.IDIO_OID_IDIO = 1 								-- PARAMETRO DE IDIOMA --
	 ) GEN_PROD
WHERE SOL_CAB.IND_TS_NO_CONSO = 1
	  AND SOL_CAB.IND_PEDI_PRUE <> 1
	  AND SOL_CAB.FEC_FACT IS NOT NULL
	  AND SUBG.PAIS_OID_PAIS = SOL_CAB.PAIS_OID_PAIS 
	  AND SUBG.OID_SUBG_VENT = REG.ZSGV_OID_SUBG_VENT
	  AND ZONA.ZORG_OID_REGI = REG.OID_REGI
	  AND SOL_CAB.ZZON_OID_ZONA = ZONA.OID_ZONA
	  AND SEC.ZZON_OID_ZONA = ZONA.OID_ZONA
	  AND SOL_CAB.ZTAD_OID_TERR_ADMI = TER_ADM.OID_TERR_ADMI
	  AND TER_ADM.ZSCC_OID_SECC = SEC.OID_SECC
	  AND TER_ADM.TERR_OID_TERR = TER.OID_TERR
	  AND SOL_POS.SOCA_OID_SOLI_CABE = SOL_CAB.OID_SOLI_CABE 
	  AND SOL_POS.VAL_PREC_CATA_TOTA_LOCA > 0  
	  AND SOL_POS.ESPO_OID_ESTA_POSI = EST_POS.OID_ESTA_POSI
--	  AND EST_POS.COD_ESTA_POSI <> 'AN'
	  AND SOL_POS.PROD_OID_PROD = PROD.OID_PROD
	  AND SOL_CAB.PAIS_OID_PAIS = GEN_PAIS.VAL_OID(+)
	  AND SOL_CAB.SOCI_OID_SOCI = GEN_SOCI.VAL_OID(+)
	  AND PROD.NEGO_OID_NEGO = GEN_NEGO.VAL_OID(+)
	  AND PROD.OID_PROD = GEN_PROD.VAL_OID(+)
	  AND PROD.COD_SAP > TO_CHAR(1) 		  			   				 	-- PARAMETRO DE CODIGO DE PRODUCTO DESDE --
	  AND PROD.COD_SAP < TO_CHAR(99999)									-- PARAMETRO DE CODIGO DE PRODUCTO HASTA --
	  AND TO_DATE(SOL_CAB.FEC_CRON) >= TO_DATE('01/01/2000','DD/MM/YYYY')   -- PARAMETRO DE FECHA VALOR DE DESDE --
	  AND TO_DATE(SOL_CAB.FEC_CRON) <= TO_DATE('01/01/2050','DD/MM/YYYY')   -- PARAMETRO DE FECHA VALOR DE HASTA --
	  AND SOL_CAB.PAIS_OID_PAIS = 1   							-- PARAMETRO DE PAIS --
	  AND SUBG.CANA_OID_CANA IN (1)								-- PARAMETRO DE CANAL --
	  AND SUBG.MARC_OID_MARC IN (1)								-- PARAMETRO DE MARCA --
	  AND REG.OID_REGI IN (1)									-- PARAMETRO DE REGION --
	  AND ZONA.OID_ZONA IN (1)									-- PARAMETRO DE ZONA --
	  AND SEC.OID_SECC IN (1)									-- PARAMETRO DE SECCION --
	  AND TER.COD_TERR > 1										-- PARAMETRO DE TERRITORIO DESDE --
	  AND TER.COD_TERR < 1000000								-- PARAMETRO DE TERRITORIO HASTA --
	  AND PROD.NEGO_OID_NEGO IN (1)									-- PARAMETRO DE CLASE --
GROUP BY GEN_PAIS.VAL_I18N,
	     GEN_SOCI.VAL_I18N,
	  	 GEN_NEGO.VAL_I18N,
		 PROD.COD_SAP,
		 GEN_PROD.VAL_I18N,
		 PROD.VAL_COST_ESTD

