/* PARA LAYOUT CUANDO EL CAMPO INDICADOR MONTO_DEUDA VENGA EN 1 EN EL CAMPO MONTO _DEUDA SE DEBERA PRESENTAR 'N/A'*/

SELECT *
FROM
	(
	 	SELECT PRO.STRINGVALUE SOCIEDAD_DEFECTO
		FROM PRINCIPALS PRI,
			PROPERTYVALUES PRO			
		WHERE PRI.NAME = 'USUARIO1'			   	  	 -- PARAMETRO DE USUARIO POR DEFECTO --
			 AND PRO.IDPROPERTY = 48
			 AND PRO.IDPRINCIPAL = PRI.IDPRINCIPAL
	),
	(
	SELECT REGION,
		   ZONA,
		   SECCION,
		   TERRITORIO
		   COD_CLIENTE,
		   NOMBRE,
		   TELEFONO,
		   CAMP_INGRESO,
		   NIVEL_CAPACI,
		   CONSTANCIA,
		   PERIODO_1,
		   PERIODO_2,
		   PERIODO_3,
		   PERIODO_4,
		   OBSERVACIONES,   
		   INDICADOR_MONTO_DEUDA,
		   GANANCIA_ACUM,
		   DECODE(N_PEDIDOS, 0,0, VTA_ACUMULADA/N_PEDIDOS) PMNP,
		   VTA_PUB_P1,
		   VTA_PUB_P2,
		   VTA_PUB_P3,
		   VTA_PUB_P4,
		   DECODE(DECODE(N_PEDIDOS, 0,0, VTA_ACUMULADA/N_PEDIDOS), 0, 0, VTA_CAMP_ANALISIS/(VTA_ACUMULADA/N_PEDIDOS)) PORC_VTA_VS_PROME,
		   MONTO_DEUDA,
		   VTA_ACUMULADA,
		   N_PEDIDOS,
		   VTA_CAMP_ANALISIS
	FROM
	(
		SELECT REGION,
			   ZONA,
			   SECCION,
			   TERRITORIO,
			   COD_CLIENTE,
			   NOMBRE,
			   TELEFONO,
			   CAMP_INGRESO,
			   NIVEL_CAPACI,
	---------------------------- CALCULO DE CONSTANCIA ------------------------------------------------		   
			   CASE WHEN (PERIODO_ULTIMO_PEDIDO IS NOT NULL) THEN
			   		(
			   		SELECT COUNT(DISTINCT SOL_CAB.PERD_OID_PERI)
					FROM PED_SOLIC_CABEC SOL_CAB,
						 CRA_PERIO P
					WHERE P.OID_PERI = SOL_CAB.PERD_OID_PERI 
						  AND P.FEC_INIC >= FEC_P_18
						  AND P.FEC_FINA <= FEC_PERIODO_ULTIMO_PEDIDO
		                  AND SOL_CAB.CLIE_OID_CLIE = CLIENTE
	--                    AND SOL_CAB.IND_TS_NO_CONSO <> 1
	--					  AND SOL_CAB.IND_OC = 1
	--					  AND SOL_CAB.IND_PEDI_PRUE <> 1
	--					  AND SOL_CAB.FEC_FACT IS NOT NULL
						  AND P.PAIS_OID_PAIS = 1			 		-- PARAMETRO DE PAIS --
						  AND P.MARC_OID_MARC = 1					-- PARAMETRO DE MARCA --
						  AND P.CANA_OID_CANA = 1					-- PARAMETRO DE CANAL --
					GROUP BY SOL_CAB.CLIE_OID_CLIE
			   		)
			   END CONSTANCIA,
		       GANANCIA_ACUM, 					  			
	------------------------------- CALCULO DEL NUMERO DE PEDIDOS ---------------------------------------------		   
			       CASE WHEN ((OID_CAMP_INGRESO IS NOT NULL) AND (PERIODO_ULTIMO_PEDIDO IS NOT NULL)) THEN
					   (
					   SELECT COUNT(*)
					   FROM DTR_SEGME_CLIEN SG,
					   		CRA_PERIO P
					   WHERE FEC_P_18 <= P.FEC_INIC
					   		 AND FEC_PERIODO_ULTIMO_PEDIDO >= P.FEC_FINA
							 AND P.OID_PERI = SG.PERD_OID_PERI
							 AND SG.CLIE_OID_CLIE = CLIENTE
							 AND P.PAIS_OID_PAIS = 1			 		-- PARAMETRO DE PAIS --
							 AND P.MARC_OID_MARC = 1					-- PARAMETRO DE MARCA --
							 AND P.CANA_OID_CANA = 1					-- PARAMETRO DE CANAL --
					   GROUP BY SG.CLIE_OID_CLIE
					   )
				  END N_PEDIDOS,
	------------------------ CALCULO DE LA VENTA ACUMULADA ---------------------------------------------------			  
			      CASE WHEN ((OID_CAMP_INGRESO IS NOT NULL) AND (PERIODO_ULTIMO_PEDIDO IS NOT NULL)) THEN
					   (
					   SELECT SUM(NVL(SG.VAL_VENT, 0))
					   FROM DTR_SEGME_CLIEN SG,
					   		CRA_PERIO P
					   WHERE FEC_P_18 <= P.FEC_INIC
					   		 AND FEC_PERIODO_ULTIMO_PEDIDO >= P.FEC_FINA
							 AND P.OID_PERI = SG.PERD_OID_PERI
							 AND SG.CLIE_OID_CLIE = CLIENTE
							 AND P.PAIS_OID_PAIS = 1			 		-- PARAMETRO DE PAIS --
							 AND P.MARC_OID_MARC = 1					-- PARAMETRO DE MARCA --
							 AND P.CANA_OID_CANA = 1					-- PARAMETRO DE CANAL --
					   GROUP BY SG.CLIE_OID_CLIE
					   )
			       END VTA_ACUMULADA,
			  	   PERIODO_1,
				   PERIODO_2,
				   PERIODO_3,
				   PERIODO_4,
				   VTA_PUB_P1,
				   VTA_PUB_P2,
				   VTA_PUB_P3,
				   VTA_PUB_P4,
				   VTA_CAMP_ANALISIS,
				   MONTO_DEUDA,
				   INDICADOR_MONTO_DEUDA,
				   OBSERVACIONES
		FROM
		(
			SELECT CLIE_OID_CLIE CLIENTE,
				   REGION,
				   ZONA,
				   SECCION,
				   TERRITORIO,
				   COD_CLIENTE,
				   NOMBRE,
				   TELEFONO,
				   CAMP_INGRESO,
				   NIVEL_CAPACI,
	-------------------------------- CALCULO DE FECHA DEL PERIODO NUEMRO 18 -------------------------------			   
				   CASE WHEN ((OID_CAMP_INGRESO IS NOT NULL) AND (PERIODO_ULTIMO_PEDIDO IS NOT NULL)) THEN
				   			   CASE WHEN (OWN_PERU.FN_112_CALC_PER_ANT(1, 1, 1, OID_CAMP_INGRESO, PERIODO_ULTIMO_PEDIDO) > 18) THEN  -- PARAMETRO DE PAIS, MARCA, CANAL --
							   		(
									SELECT FEC_INIC 
									FROM CRA_PERIO
									WHERE OID_PERI = OWN_PERU.FN_008_CALC_OID_PER_ANT(1,1,1, 57, 18) --PERIODO_ULTIMO_PEDIDO,18)) -- PARAMETRO DE PAIS, MARCA, CANAL --
									)    				   		
							   ELSE
							   	   (	
								   SELECT FEC_INIC
								   FROM CRA_PERIO
								   WHERE OID_PERI = OID_CAMP_INGRESO
								   )
							   END	   
				   END FEC_P_18,
	----------------------------- CALCULO DE LA FECHA DEL PERIODO DEL ULTIMO PEDIDO ------------------------			   
				   CASE WHEN (PERIODO_ULTIMO_PEDIDO IS NOT NULL) THEN
				   		   (
						   SELECT FEC_FINA
						   FROM CRA_PERIO
						   WHERE OID_PERI = PERIODO_ULTIMO_PEDIDO
						   )
				   END FEC_PERIODO_ULTIMO_PEDIDO,
				   OID_CAMP_INGRESO,
				   PERIODO_ULTIMO_PEDIDO,				   
				   PERIODO_1,
				   PERIODO_2,
				   PERIODO_3,
				   PERIODO_4,
				   VTA_PUB_P1,
				   VTA_PUB_P2,
				   VTA_PUB_P3,
				   VTA_PUB_P4,
				   GANANCIA_ACUM,
				   VTA_CAMP_ANALISIS,
				   MONTO_DEUDA,
				   INDICADOR_MONTO_DEUDA,
				   OBSERVACIONES
			FROM
			(
			SELECT SEG_CLI.CLIE_OID_CLIE,
				   REG.DES_REGI REGION,
				   ZONA.DES_ZONA ZONA,
	------------------------------ SECCION DEL CLIENTE------------------------------------------------			   
				   (
				   SELECT SEC.COD_SECC
				   FROM MAE_CLIEN_UNIDA_ADMIN UA,
				   		ZON_TERRI_ADMIN TER_ADM,
						ZON_SECCI SEC,
						ZON_ZONA Z
				   WHERE UA.CLIE_OID_CLIE = SEG_CLI.CLIE_OID_CLIE
				   		 AND TER_ADM.OID_TERR_ADMI = UA.ZTAD_OID_TERR_ADMI
						 AND SEC.OID_SECC = TER_ADM.ZSCC_OID_SECC
						 AND Z.OID_ZONA = SEC.ZZON_OID_ZONA
						 AND Z.OID_ZONA = ZONA.OID_ZONA
						 AND ROWNUM = 1
						 AND UA.IND_ACTI = 1
				   ) SECCION,
	------------------------------ TERRITORIO DEL CLIENTE -------------------------------------------			   
				   (
				   SELECT TER.COD_TERR
				   FROM MAE_CLIEN_UNIDA_ADMIN UA,
				   		ZON_TERRI_ADMIN TER_ADM,
						ZON_SECCI SEC,
						ZON_ZONA Z,
						ZON_TERRI TER
				   WHERE UA.CLIE_OID_CLIE = SEG_CLI.CLIE_OID_CLIE
				   		 AND TER_ADM.OID_TERR_ADMI = UA.ZTAD_OID_TERR_ADMI
						 AND SEC.OID_SECC = TER_ADM.ZSCC_OID_SECC
						 AND Z.OID_ZONA = SEC.ZZON_OID_ZONA
						 AND Z.OID_ZONA = ZONA.OID_ZONA
						 AND TER_ADM.TERR_OID_TERR = TER.OID_TERR
						 AND ROWNUM = 1	
						 AND UA.IND_ACTI = 1				 
					) TERRITORIO,
					CLI.COD_CLIE COD_CLIENTE,
				   SUBSTR(CLI.VAL_APE1||' '||CLI.VAL_APE2||' '||CLI.VAL_NOM1||' '||CLI.VAL_NOM2, 0, 40) NOMBRE,
				   (
				   SELECT CLI_COM.VAL_TEXT_COMU
				   FROM MAE_CLIEN_COMUN CLI_COM,
				   		MAE_TIPO_COMUN TIP_COM
				   WHERE CLI_COM.CLIE_OID_CLIE = CLI.OID_CLIE
				   		 AND CLI_COM.TICM_OID_TIPO_COMU = TIP_COM.OID_TIPO_COMU
				  		 AND TIP_COM.COD_TIPO_COMU = 'TF'
			 	   ) TELEFONO,
	---------------------------- OID DE CAMPAÑA DE INGRESO -----------------------------------------			   
				   (
				   SELECT PERI.OID_PERI
				   FROM MAE_CLIEN_HISTO_ESTAT EST,
				   		CRA_PERIO PERI
				   WHERE EST.CLIE_OID_CLIE = CLI.OID_CLIE
				   		 AND EST.ESTA_OID_ESTA_CLIE = 2
						 AND PERI.OID_PERI = EST.PERD_OID_PERI 
				   ) OID_CAMP_INGRESO,
	----------------------- DESCRIPCION CAMPAÑA DE INGRESO -----------------------------------------			   
				   (
				   SELECT PERI.VAL_NOMB_PERI
				   FROM MAE_CLIEN_HISTO_ESTAT EST,
				   		CRA_PERIO PERI
				   WHERE EST.CLIE_OID_CLIE = CLI.OID_CLIE
				   		 AND EST.ESTA_OID_ESTA_CLIE = 2
						 AND PERI.OID_PERI = EST.PERD_OID_PERI 
				   ) CAMP_INGRESO,
	----------------------- NIVEL DE CAPACITACION -------------------------------------------------			   
				   	  (
				  SELECT GEN_TIP.VAL_I18N
				  FROM EDU_HISTO_CURSO HIS,
			           EDU_MATRI_CURSO MAT,
				       EDU_TIPO_CURSO TIP_COR,
					  (
					  SELECT HIS.CLIE_OID_CLIE,
					  		 MAX(HIS.FEC_ASIS) FEC_ASIS
					  FROM EDU_HISTO_CURSO HIS
					  GROUP BY HIS.CLIE_OID_CLIE
					  ) MAXI,
					  (
					  SELECT GEN.VAL_OID, GEN.VAL_I18N
					  FROM V_GEN_I18N_SICC GEN
					  WHERE GEN.ATTR_ENTI = 'EDU_TIPO_CURSO'
					  		AND GEN.IDIO_OID_IDIO = 1				 -- PARAMETRO DE IDIOMA --
					  ) GEN_TIP
				  WHERE HIS.CLIE_OID_CLIE = MAXI.CLIE_OID_CLIE
				  		AND HIS.FEC_ASIS = MAXI.FEC_ASIS 
			            AND HIS.MCUR_OID_CURS = MAT.OID_CURS
						AND MAT.TICU_OID_TIPO_CURS = TIP_COR.OID_TIPO_CURS
						AND HIS.CLIE_OID_CLIE = SEG_CLI.CLIE_OID_CLIE
						AND TIP_COR.OID_TIPO_CURS = GEN_TIP.VAL_OID(+)
				  ) NIVEL_CAPACI,		  
	----------------------- CALCULO DE PERIODO DEL ULTIMO PEDIDO -----------------------------------			  
			       (
					   SELECT PER.OID_PERI
					   FROM PED_SOLIC_CABEC SOL,
					   		(
								SELECT * 
								FROM CRA_PERIO PERI
								WHERE PERI.PAIS_OID_PAIS = 1			-- PARAMETRO DE PAIS --
									  AND PERI.MARC_OID_MARC = 1		-- PARAMETRO DE MARCA --
									  AND PERI.CANA_OID_CANA = 1		-- PARAMETRO DE CANAL --
								ORDER BY FEC_FINA DESC
							)PER
					   WHERE SOL.PERD_OID_PERI = PER.OID_PERI
					   		 AND SOL.CLIE_OID_CLIE = CLI.OID_CLIE
	--						 AND SOL.IND_TS_NO_CONSO <> 1
	--						 AND SOL.IND_OC = 1
	--						 AND SOL.IND_PEDI_PRUE <> 1
	--						 AND SOL.FEC_FACT IS NOT NULL
							 AND ROWNUM = 1
				   ) PERIODO_ULTIMO_PEDIDO, 				   				   	
	---------------------------- PERIODO 1 ---------------------------------------------------------			   
				   (
				   SELECT VAL_NOMB_PERI
				   FROM CRA_PERIO
				   WHERE OID_PERI = 61 	   	 			-- PARAMETRO DE PERIODO DESDE --
				   ) PERIODO_1,
	--------------------------- PERIODO 2 -----------------------------------------------------------			   
				   (
				   SELECT VAL_NOMB_PERI
				   FROM CRA_PERIO
				   WHERE OID_PERI = (
					   SELECT OWN_PERU.FN_008_CALC_OID_PER_ANT(1,1,1,65,3)   -- PARAMETRO DE PAIS, MARCA, CANAL, PERIODO HASTA --
					   FROM DUAL
					   )
				   ) PERIODO_2,
	---------------------------- PERIODO 3 ----------------------------------------------------------			   
				   (
				   SELECT VAL_NOMB_PERI
				   FROM CRA_PERIO
				   WHERE OID_PERI =(
					   SELECT OWN_PERU.FN_008_CALC_OID_PER_ANT(1,1,1,65,2)   -- PARAMETRO DE PAIS, MARCA, CANAL, PERIODO HASTA --
					   FROM DUAL
					   )
				   ) PERIODO_3,
	---------------------------- PERIODO 4------------------------------------------------------------			   
				   (
				   SELECT VAL_NOMB_PERI
				   FROM CRA_PERIO
				   WHERE OID_PERI = 65 	   	 			-- PARAMETRO DE PERIODO HASTA --
				   ) PERIODO_4,
	---------------------------- CALCULO DE VENTA EN EL 1 PERIODO -----------------------------------			   
				   (
				   SELECT SUM(SEG.VAL_VENT)
				   FROM DTR_SEGME_CLIEN SEG
				   WHERE SEG.PERD_OID_PERI = 61			-- PARAMETRO DE PERIODO DESDE--
				   		 AND SEG.CLIE_OID_CLIE = SEG_CLI.CLIE_OID_CLIE
				   ) VTA_PUB_P1,
	---------------------------- CALCULO DE VENTA EN EL 2 PERIODO -----------------------------------			   
				   (
				   SELECT SUM(SEG.VAL_VENT)
				   FROM DTR_SEGME_CLIEN SEG
				   WHERE SEG.PERD_OID_PERI =
					   (
					   SELECT OWN_PERU.FN_008_CALC_OID_PER_ANT(1,1,1,65,3)   -- PARAMETRO DE PAIS, MARCA, CANAL, PERIODO HASTA --
					   FROM DUAL
					   )
				   	   		 AND SEG.CLIE_OID_CLIE = SEG_CLI.CLIE_OID_CLIE
				   ) VTA_PUB_P2,
	--------------------------- CALCULO DE VENTA EN EL 3 PERIODO ------------------------------------			   
				   (
				   SELECT SUM(SEG.VAL_VENT)
				   FROM DTR_SEGME_CLIEN SEG
				   WHERE SEG.PERD_OID_PERI =
					   (
					   SELECT OWN_PERU.FN_008_CALC_OID_PER_ANT(1,1,1,65,2)   -- PARAMETRO DE PAIS, MARCA, CANAL, PERIODO HASTA --
					   FROM DUAL
					   )
					   AND SEG.CLIE_OID_CLIE = SEG_CLI.CLIE_OID_CLIE
				   ) VTA_PUB_P3,	   
	------------------------- CALCULO DE VENTA EN EL 4 PERIODO ------------------------------------			   
				   (
				   SELECT SUM(SEG.VAL_VENT)
				   FROM DTR_SEGME_CLIEN SEG
				   WHERE SEG.PERD_OID_PERI = 65			-- PARAMETRO DE PERIODO HASTA--
				   		 AND SEG.CLIE_OID_CLIE = SEG_CLI.CLIE_OID_CLIE
				   ) VTA_PUB_P4,
	-------------------------- CALCULO DE GANANCIA ACUMULADA --------------------------------------			   
				   (
				   SELECT NVL(SUM(SEG.IMP_DES1), 0) + NVL(SUM(SEG.IMP_DES3), 0)
				   FROM DTR_SEGME_CLIEN SEG,
				   		 CRA_PERIO PERI,
					   (
					   SELECT FEC_INIC
					   FROM CRA_PERIO
					   WHERE OID_PERI = 61		   	 		-- PARAMETRO DE PERIODO DESDE--
					   ) FI,
					   (
					   SELECT FEC_FINA
					   FROM CRA_PERIO
					   WHERE OID_PERI = 65		   	 		-- PARAMETRO DE PERIODO HASTA--
					   ) FF
				   WHERE FI.FEC_INIC <= PERI.FEC_INIC
						 AND FF.FEC_FINA >= PERI.FEC_FINA
						 AND PERI.OID_PERI = SEG.PERD_OID_PERI
						 AND SEG.CLIE_OID_CLIE = SEG_CLI.CLIE_OID_CLIE
				   GROUP BY SEG.CLIE_OID_CLIE							   
				   ) GANANCIA_ACUM,
	-------------------------- CALCULO DE VENTA EN LA CAMPAÑA DE ANALISIS -----------------------------			   
				   (
				   SELECT SUM(SG.VAL_VENT)
				   FROM DTR_SEGME_CLIEN SG,
				   		CRA_PERIO P
				   WHERE P.OID_PERI = 61   								 -- PARAMETRO DE PERIODO HASTA --
				   		 AND SG.PERD_OID_PERI = P.OID_PERI
						 AND SG.CLIE_OID_CLIE = SEG_CLI.CLIE_OID_CLIE
				   GROUP BY SG.CLIE_OID_CLIE	
				   ) VTA_CAMP_ANALISIS,
	------------------------- CALCULO DE MONTO DEUDA --------------------------------------------------			   
				   (
				   CASE WHEN (6 = 6) THEN				-- UNO ES PARAMETRO DE NIVEL --
				   		PQ_APL_REP.FN_CU_CALC_SALDO_CTA_CTE(PERI.PAIS_OID_PAIS, SEG_CLI.CLIE_OID_CLIE)
				   END	   		
				   ) MONTO_DEUDA,
				   (
				   CASE WHEN (6 = 6) THEN				-- UNO ES PARAMETRO DE NIVEL --
				   		0
				   ELSE
				   	    1
				   END	   		
				   ) INDICADOR_MONTO_DEUDA,
	------------------------------- OBSERVACIONES ----------------------------------------------------			   
				   (
				   SELECT VAL_TEXT
				   FROM MAE_CLIEN_OBSER CLI_OBS
				   WHERE CLI_OBS.CLIE_OID_CLIE = SEG_CLI.CLIE_OID_CLIE
				   		 AND CLI_OBS.MARC_OID_MARC = PERI.MARC_OID_MARC
				   ) OBSERVACIONES
			FROM DTR_SEGME_CLIEN SEG_CLI,
				 CRA_PERIO PERI,
				 ZON_REGIO REG,
				 ZON_ZONA ZONA,
				 MAE_CLIEN CLI,
				 (
				 SELECT FEC_INIC
				 FROM CRA_PERIO 
				 WHERE OID_PERI = 61	   		   	 	-- PARAMETRO DE PERIODO DESDE --
				 ) FI,
				 (
				 SELECT FEC_FINA
				 FROM CRA_PERIO 
				 WHERE OID_PERI = 61	   		   	 	-- PARAMETRO DE PERIODO HASTA --
				 ) FF	 
			WHERE SEG_CLI.PERD_OID_PERI = PERI.OID_PERI
				  AND FI.FEC_INIC <= PERI.FEC_INIC
				  AND FF.FEC_FINA >= PERI.FEC_FINA
				  AND SEG_CLI.NVSG_OID_NIVE_SEGM = 1		   -- PARAMETRO DE NIVEL --
				  AND CLI.OID_CLIE = SEG_CLI.CLIE_OID_CLIE
				  AND REG.OID_REGI = SEG_CLI.ZORG_OID_REGI
				  AND ZONA.OID_ZONA = SEG_CLI.ZZON_OID_ZONA
				  AND REG.OID_REGI = ZONA.ZORG_OID_REGI
				--  AND PERI.PAIS_OID_PAIS = 1		   	-- PARAMETRO DE PAIS --
				 -- AND PERI.MARC_OID_MARC = 1			-- PARAMETRO DE MARCA --
				 -- AND PERI.CANA_OID_CANA = 1			-- PARAMETRO DE CANAL -- 
				--  AND SEG_CLI.ZORG_OID_REGI = 7			-- PARAMETRO DE REGION --
				 -- AND SEG_CLI.ZZON_OID_ZONA = 1			-- PARAMETRO DE ZONA --	   
			)
		)	  
	)	  
	ORDER BY REGION,
		  	 ZONA,
			 SECCION,
			 GANANCIA_ACUM,
			 COD_CLIENTE
)	  
