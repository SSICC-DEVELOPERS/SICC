-- POR ESPECIALISTA (DETALLADO)--

SELECT PAIS,
	   COD_SBAC,
	   DESC_SUBA,
	   COD_ESP,
	   NOMB_ESP,
	   COD_OPER,
	   FECHA,
	   UNID_ATEN,
	   MONTO_FAC,
	   N_OPERAC 
FROM
(
	(	  	  
	SELECT GEN_PAIS.VAL_I18N PAIS,
		   SUBA.COD_SBAC,
		   GEN_SUBA.VAL_I18N DESC_SUBA,
		   SOL_CAB.VAL_USUA COD_ESP,
		   USU.VAL_NOM1||' '||USU.VAL_APEL_PATE NOMB_ESP,
		   'VT' COD_OPER,
		   SOL_CAB.FEC_CRON FECHA,
		   SUM(SOL_POS.NUM_UNID_VENT) UNID_ATEN,
		   SUM(NVL(SOL_POS.VAL_PREC_CATA_UNIT_LOCA, 0) * NVL(SOL_POS.NUM_UNID_VENT, 0)) MONTO_FAC,
		   COUNT(*) N_OPERAC,
		   1 AS CONTROL_OPER
	FROM PED_SOLIC_CABEC SOL_CAB,
		 PED_TIPO_SOLIC TIP_SOL,
		 PED_TIPO_SOLIC_PAIS TIP_SOL_PAIS,
		 SEG_ACCES ACCE,
		 SEG_SUBAC SUBA,
		 PED_SOLIC_POSIC SOL_POS,
		 SEG_PAIS PAIS,
		 V_REP_USUAR_LARGO USU,
		 (
		 SELECT GEN.VAL_OID, GEN.VAL_I18N
		 FROM V_GEN_I18N_SICC GEN
		 WHERE GEN.ATTR_ENTI = 'SEG_PAIS'
		 	 AND GEN.IDIO_OID_IDIO = 1		  							-- PRAMETRO DE IDIOMA --
		 ) GEN_PAIS,
		 (
		 SELECT GEN.VAL_OID, GEN.VAL_I18N
		 FROM V_GEN_I18N_SICC GEN
		 WHERE GEN.ATTR_ENTI = 'SEG_SUBAC'
		 	   AND GEN.IDIO_OID_IDIO = 1  							-- PARAMETRO DE IDIOMA --
		 ) GEN_SUBA
	WHERE ACCE.OID_ACCE = TIP_SOL.ACCE_OID_ACCE
		  AND TIP_SOL.OID_TIPO_SOLI = TIP_SOL_PAIS.TSOL_OID_TIPO_SOLI
		  AND TIP_SOL_PAIS.OID_TIPO_SOLI_PAIS = SOL_CAB.TSPA_OID_TIPO_SOLI_PAIS
		  AND SOL_POS.SOCA_OID_SOLI_CABE = SOL_CAB.OID_SOLI_CABE
		  AND SUBA.ACCE_OID_ACCE = ACCE.OID_ACCE
		  AND SOL_CAB.SBAC_OID_SBAC = SUBA.OID_SBAC
	  	  AND SOL_CAB.IND_TS_NO_CONSO = 0
		  AND SOL_CAB.IND_PEDI_PRUE = 0
		  AND SUBA.OID_SBAC = GEN_SUBA.VAL_OID(+)
		  AND SOL_CAB.PAIS_OID_PAIS = PAIS.OID_PAIS
		  AND PAIS.OID_PAIS = GEN_PAIS.VAL_OID(+)
		  AND USU.VAL_NOMB_USUA = SOL_CAB.VAL_USUA	  
	      AND SOL_POS.NUM_UNID_VENT <> 0
		  AND SOL_POS.NUM_UNID_VENT IS NOT NULL
	      AND TO_DATE(SOL_CAB.FEC_CRON) >= TO_DATE('01/01/2000', 'DD/MM/YYYY') --PARAMETRO DE FECHA DE INICIO --
		  AND TO_DATE(SOL_CAB.FEC_CRON) <= TO_DATE('01/01/2050', 'DD/MM/YYYY') --PARAMETRO DE FECHA DE FIN --
		  AND SOL_CAB.SBAC_OID_SBAC IN (1)			  				-- PARAMETRO DE SUBACCESO --
		  AND SOL_CAB.PAIS_OID_PAIS = 1	  				  			-- PARAMETRO DE PAIS --
		  AND TIP_SOL.ACCE_OID_ACCE = 1								-- PARAMETRO DE ACCESO --
		  AND ACCE.CANA_OID_CANA = 1  								-- PARAMETRO DE CANAL --
		  AND SOL_CAB.VAL_USUA = 'PRUEBAS'                          -- PARAMETRO DE ESPECIALISTA --
	GROUP BY GEN_PAIS.VAL_I18N,
		   SUBA.COD_SBAC,
		   GEN_SUBA.VAL_I18N,
		   SOL_CAB.VAL_USUA,
		   USU.VAL_NOM1||' '||USU.VAL_APEL_PATE,
		   'VT',
		   SOL_CAB.FEC_CRON
	)
	UNION ALL
	(  	  
	SELECT GEN_PAIS.VAL_I18N PAIS,
		   SUBA.COD_SBAC,
		   GEN_SUBA.VAL_I18N DESC_SUBA,
		   SOL_CAB.VAL_USUA COD_ESP,
		   USU.VAL_NOM1||' '||USU.VAL_APEL_PATE NOMB_ESP,
		   'CM' COD_OPER,
		   SOL_CAB.FEC_CRON FECHA,
		   SUM(SOL_POS.NUM_UNID_CAMB) UNID_ATEN,
		   SUM(NVL(SOL_POS.VAL_PREC_CATA_UNIT_LOCA, 0) * NVL(SOL_POS.NUM_UNID_CAMB, 0)) MONTO_FAC,
		   COUNT(*) N_OPERAC,
		   2 AS CONTROL_OPER
	FROM PED_SOLIC_CABEC SOL_CAB,
		 PED_TIPO_SOLIC TIP_SOL,
		 PED_TIPO_SOLIC_PAIS TIP_SOL_PAIS,
		 SEG_ACCES ACCE,
		 SEG_SUBAC SUBA,
		 PED_SOLIC_POSIC SOL_POS,
		 SEG_PAIS PAIS,
		 V_REP_USUAR_LARGO USU,
		 (
		 SELECT GEN.VAL_OID, GEN.VAL_I18N
		 FROM V_GEN_I18N_SICC GEN
		 WHERE GEN.ATTR_ENTI = 'SEG_PAIS'
		 	 AND GEN.IDIO_OID_IDIO = 1		  							-- PRAMETRO DE IDIOMA --
		 ) GEN_PAIS,
		 (
		 SELECT GEN.VAL_OID, GEN.VAL_I18N
		 FROM V_GEN_I18N_SICC GEN
		 WHERE GEN.ATTR_ENTI = 'SEG_SUBAC'
		 	   AND GEN.IDIO_OID_IDIO = 1  							-- PARAMETRO DE IDIOMA --
		 ) GEN_SUBA
	WHERE ACCE.OID_ACCE = TIP_SOL.ACCE_OID_ACCE
		  AND TIP_SOL.OID_TIPO_SOLI = TIP_SOL_PAIS.TSOL_OID_TIPO_SOLI
		  AND TIP_SOL_PAIS.OID_TIPO_SOLI_PAIS = SOL_CAB.TSPA_OID_TIPO_SOLI_PAIS
		  AND SOL_POS.SOCA_OID_SOLI_CABE = SOL_CAB.OID_SOLI_CABE
		  AND SUBA.ACCE_OID_ACCE = ACCE.OID_ACCE
		  AND SOL_CAB.SBAC_OID_SBAC = SUBA.OID_SBAC
	  	  AND SOL_CAB.IND_TS_NO_CONSO = 0
		  AND SOL_CAB.IND_PEDI_PRUE = 0
		  AND SUBA.OID_SBAC = GEN_SUBA.VAL_OID(+)
		  AND SOL_CAB.PAIS_OID_PAIS = PAIS.OID_PAIS
		  AND PAIS.OID_PAIS = GEN_PAIS.VAL_OID(+)
		  AND USU.VAL_NOMB_USUA = SOL_CAB.VAL_USUA	  
	      AND SOL_POS.NUM_UNID_CAMB <> 0
		  AND SOL_POS.NUM_UNID_CAMB IS NOT NULL
		  AND SOL_CAB.FEC_CRON >= TO_DATE('01/01/2000', 'DD/MM/YYYY') --PARAMETRO DE FECHA DE INICIO --
		  AND SOL_CAB.FEC_CRON <= TO_DATE('01/01/2050', 'DD/MM/YYYY') --PARAMETRO DE FECHA DE FIN --
		  AND SOL_CAB.SBAC_OID_SBAC IN (1)			  				-- PARAMETRO DE SUBACCESO --
		  AND SOL_CAB.PAIS_OID_PAIS = 1	  				  			-- PARAMETRO DE PAIS --
		  AND TIP_SOL.ACCE_OID_ACCE = 1								-- PARAMETRO DE ACCESO --
		  AND ACCE.CANA_OID_CANA = 1  								-- PARAMETRO DE CANAL --
		  AND SOL_CAB.VAL_USUA = 'PRUEBAS'                          -- PARAMETRO DE ESPECIALISTA --
	GROUP BY GEN_PAIS.VAL_I18N,
		   SUBA.COD_SBAC,
		   GEN_SUBA.VAL_I18N,
		   SOL_CAB.VAL_USUA,
		   USU.VAL_NOM1||' '||USU.VAL_APEL_PATE,
		   'CM',
		   SOL_CAB.FEC_CRON
	)		
)
WHERE CONTROL_OPER IN (1,2)
ORDER BY PAIS,
	     COD_SBAC,
	     COD_ESP,
		 FECHA
	  