

SELECT NUM_CONC NUM_CONCURSO,
	   VAL_NOMB DESC_CONCURSO,
	   NULL AS CANT_DESPACHO,
	   TIPO_CONCURSO,
	   NUM_NIVE NUM_NIVEL,
	   DESCRIPCION DESC_PREMIO,
	   DES_REGI REGION,
	   CAMP_ANALISIS,
	   FEC_OBTE FECHA,
	   PED,
	   GANA,
	   DECODE(PED, 0, 0, (GANA/PED)*100) PORC_VARIA,
	   SUM(PED) OVER (PARTITION BY DES_REGI, NUM_CONC, NUM_NIVE, FEC_OBTE ORDER BY FEC_OBTE, ROWNUM) ACUM_PED,
	   SUM(GANA) OVER (PARTITION BY DES_REGI, NUM_CONC, NUM_NIVE, FEC_OBTE ORDER BY FEC_OBTE, ROWNUM) ACUM_GANA,
	   DECODE(SUM(PED) OVER (PARTITION BY DES_REGI, NUM_CONC, NUM_NIVE, FEC_OBTE ORDER BY FEC_OBTE, ROWNUM),0,0, SUM(GANA) OVER (PARTITION BY DES_REGI, NUM_CONC, NUM_NIVE, FEC_OBTE ORDER BY FEC_OBTE, ROWNUM)/SUM(PED) OVER (PARTITION BY DES_REGI, NUM_CONC, NUM_NIVE, FEC_OBTE ORDER BY FEC_OBTE, ROWNUM)) ACUM_VAR,
	   DECODE(SUM(PED) OVER (PARTITION BY DES_REGI, NUM_CONC, NUM_NIVE, FEC_OBTE ORDER BY FEC_OBTE, ROWNUM),0,0, SUM(GANA) OVER (PARTITION BY DES_REGI, NUM_CONC, NUM_NIVE, FEC_OBTE ORDER BY FEC_OBTE, ROWNUM)/SUM(PED) OVER (PARTITION BY DES_REGI, NUM_CONC, NUM_NIVE, FEC_OBTE ORDER BY FEC_OBTE, ROWNUM)*2) CANT_PROYECTADA, -- PARAMETRO DE CANTIDAD ESTIMA DE PEDIDOS (EL 2)--
   	   DECODE(SUM(PED) OVER (PARTITION BY DES_REGI, NUM_CONC, NUM_NIVE, FEC_OBTE ORDER BY FEC_OBTE, ROWNUM),0,0, (SUM(GANA) OVER (PARTITION BY DES_REGI, NUM_CONC, NUM_NIVE, FEC_OBTE ORDER BY FEC_OBTE, ROWNUM)/SUM(PED) OVER (PARTITION BY DES_REGI, NUM_CONC, NUM_NIVE, FEC_OBTE ORDER BY FEC_OBTE, ROWNUM)*2)-5) EXCESO      -- PARAMETRO DE UNIDADES COMPRADAS (EL 5) --                          
FROM
(
	SELECT CON_GEN.NUM_CONC,
		   CON_GEN.VAL_NOMB,
		   GEN_TIPO_CON.VAL_I18N TIPO_CONCURSO,
		   PAR_NIV.NUM_NIVE,
		   VISTA.DESCRIPCION,
		   REG.DES_REGI,
		   PERI.VAL_NOMB_PERI CAMP_ANALISIS,
		   GANA.FEC_OBTE,
		   COUNT(DISTINCT GANA.CLIE_OID_CLIE) GANA,
		   NVL((
			    SELECT COUNT(SOL_CAB.OID_SOLI_CABE)
				FROM PED_SOLIC_CABEC SOL_CAB,
					 PED_TIPO_SOLIC_PAIS TIP_PAIS,
					 PED_TIPO_SOLIC TIP_SOL,
					 ZON_REGIO R,
					 ZON_ZONA ZONA,
					 SEG_ACCES ACC,
					 SEG_CANAL CANAL
				WHERE SOL_CAB.PAIS_OID_PAIS = 1									-- PARAMETRO DE PAIS --
					  AND SOL_CAB.ZZON_OID_ZONA = ZONA.OID_ZONA
					  AND ZONA.ZORG_OID_REGI = R.OID_REGI
					  AND SOL_CAB.TSPA_OID_TIPO_SOLI_PAIS = TIP_PAIS.OID_TIPO_SOLI_PAIS
					  AND TIP_PAIS.TSOL_OID_TIPO_SOLI = TIP_SOL.OID_TIPO_SOLI
					  AND TIP_SOL.ACCE_OID_ACCE = ACC.OID_ACCE
					  AND ACC.CANA_OID_CANA = CANAL.OID_CANA
					  AND SOL_CAB.ZZON_OID_ZONA = ZONA.OID_ZONA
					  AND CANAL.COD_CANA = 'VD'
					  AND SOL_CAB.IND_OC = 1
					  AND SOL_CAB.FEC_FACT IS NOT NULL
					  AND SOL_CAB.FEC_FACT = GANA.FEC_OBTE
					  AND SOL_CAB.PERD_OID_PERI = PERI.OID_PERI
					  AND R.OID_REGI = REG.OID_REGI
				GROUP BY R.OID_REGI,
					  	 SOL_CAB.FEC_FACT
			), 0) PED
	FROM INC_CONCU_PARAM_GENER CON_GEN,
		 INC_PARAM_GENER_PREMI PAR_GEN,
		 INC_PARAM_NIVEL_PREMI PAR_NIV,
		 V_REP_PREMIOS VISTA,
		 INC_GANAD GANA,
		 MAE_CLIEN_UNIDA_ADMIN UND_ADM,
		 ZON_SUB_GEREN_VENTA SUBG,
		 ZON_REGIO REG,
		 ZON_ZONA ZONA,
		 ZON_SECCI SEC,
		 ZON_TERRI_ADMIN TER_ADM,
		 CRA_PERIO PERI,
		 (
		 SELECT GEN.VAL_OID, GEN.VAL_I18N
		 FROM V_GEN_I18N_SICC GEN
		 WHERE GEN.ATTR_ENTI = 'INC_BASE_CALCU'
		 	   AND GEN.IDIO_OID_IDIO = 1	   	   	   	   	   -- PARAMETRO DE IDIOMA --
		 ) GEN_TIPO_CON
	WHERE CON_GEN.OID_PARA_GRAL = PAR_GEN.COPA_OID_PARA_GRAL
		  AND PAR_GEN.OID_PARA_GENE_PREM = PAR_NIV.PAGP_OID_PARA_GENE_PREM
		  AND VISTA.OID_PARA_NIVE_PREM(+) = PAR_NIV.OID_PARA_NIVE_PREM
		  AND GANA.PANP_OID_PARA_NIVE_PREM = PAR_NIV.OID_PARA_NIVE_PREM
		  AND GANA.CLIE_OID_CLIE = UND_ADM.CLIE_OID_CLIE
		  AND SUBG.OID_SUBG_VENT = REG.ZSGV_OID_SUBG_VENT
		  AND REG.OID_REGI = ZONA.ZORG_OID_REGI
		  AND ZONA.OID_ZONA = SEC.ZZON_OID_ZONA
		  AND SEC.OID_SECC = TER_ADM.ZSCC_OID_SECC
		  AND UND_ADM.ZTAD_OID_TERR_ADMI = TER_ADM.OID_TERR_ADMI
		  AND UND_ADM.IND_ACTI = 1
		  AND CON_GEN.IND_ACTI = 1
--		  AND VISTA.IDIO_TIPO_PREMIO = 1   							-- PARAMETRO DE IDIOMA --
		  AND PERI.OID_PERI = GANA.PERD_OID_PERI
		  AND GEN_TIPO_CON.VAL_OID(+) = CON_GEN.BCAL_OID_BASE_CALC
		  AND GANA.PERD_OID_PERI IN (1, 51, 52, 53, 54) 			-- PARAMETRO DE CAMPA�A DE ANALISIS --
		  AND CON_GEN.PAIS_OID_PAIS = 1	  							-- PARAMETRO DE PAIS --
          AND CON_GEN.MARC_OID_MARC IN (1,2,3,4,5) 					-- PARAMETRO DE MARCA --
		  AND CON_GEN.NUM_CONC = '05/002'	   								-- PARAMETRO DE NUMERO DE CONCURSO --
		  AND PAR_NIV.NUM_NIVE IN (1,2,3,4,5,6,7,8,9) 				-- PARAMETRO DE NIVEL --
		  AND SUBG.OID_SUBG_VENT IN (1,2,3,4,5,6,7,8,9) 			-- PARAMETRO DE SUBGERENCIA DE VENTAS --
		  AND REG.OID_REGI IN (1,2,3,4,5,6,7,8,9)					-- PARAMETRO DE REGION --
	GROUP BY CON_GEN.NUM_CONC,
		  	 CON_GEN.VAL_NOMB,
		  	 GEN_TIPO_CON.VAL_I18N,
			 PAR_NIV.NUM_NIVE,
             VISTA.DESCRIPCION,
			 REG.OID_REGI,
			 REG.DES_REGI,	
			 PERI.OID_PERI,	 
			 PERI.VAL_NOMB_PERI,
			 GANA.FEC_OBTE			 
)	  
ORDER BY REGION,
	  	 NUM_CONCURSO,
		 NUM_NIVEL,
		 FEC_OBTE	  
	  
		 
		 
		 
		 
		  	   	  			
