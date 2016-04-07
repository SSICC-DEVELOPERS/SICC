SELECT DES_REGI,
	   DES_ZONA,
	   GERENTE_ZONA,
	   COD_SECC,
	   GERENTE_SECC,
	   COD_TERR,
	   PERIODO_INGRESO,
	   COD_CLIE,
	   NOMBRE_CLI,
	   PERIODO1,
	   SUM(IMPORTE_P1) IMPORTE_P1,
	   PERIODO2,
	   SUM(IMPORTE_P2) IMPORTE_P2,
	   PERIODO3,
	   SUM(IMPORTE_P3) IMPORTE_P3,
	   PERIODO4,
	   SUM(IMPORTE_P4) IMPORTE_P4,
	   PERIODO5,
	   SUM(IMPORTE_P5) IMPORTE_P5,
	   (SUM(IMPORTE_P1) + SUM(IMPORTE_P2) + SUM(IMPORTE_P3) + SUM(IMPORTE_P4) + SUM(IMPORTE_P5)) TOTAL_NETO
FROM
(
	SELECT DATOS.DES_REGI,
		  DATOS.DES_ZONA,
		  (
			  SELECT CLI.VAL_NOM1||' '||CLI.VAL_APE1||' '||CLI.VAL_APE2
			  FROM MAE_CLIEN CLI
			  WHERE CLI.OID_CLIE = DATOS.CLIE_ZONA
		  ) GERENTE_ZONA,		  
		  DATOS.COD_SECC,
		  -----------------------------------------------------------------------------------------------------
		  (
			  SELECT CLI.VAL_NOM1||' '||CLI.VAL_APE1||' '||CLI.VAL_APE2
			  FROM MAE_CLIEN CLI
			  WHERE CLI.OID_CLIE = DATOS.CLIE_SEC
		  ) GERENTE_SECC,		  
		  -----------------------------------------------------------------------------------------------------		  
		  DATOS.COD_TERR,
		  -----------------------------------------------------------------------------------------------------		  
   		  (
			  SELECT VAL_NOMB_PERI
			  FROM
				  (
					  SELECT VAL_NOMB_PERI, FEC_INIC, FEC_FINA
					  FROM CRA_PERIO 
					  ORDER BY FEC_INIC
				  ) PERI			  
			  WHERE ROWNUM = 1
			  		AND PERI.FEC_INIC <= DATOS.FEC_INGR
					AND PERI.FEC_FINA >= DATOS.FEC_INGR
		  ) PERIODO_INGRESO,
		  -----------------------------------------------------------------------------------------------------
		  DATOS.COD_CLIE,
		  DATOS.NOMBRE_CLI,
		  (
			  SELECT VAL_NOMB_PERI
			  FROM CRA_PERIO
			  WHERE OID_PERI = P.OID_PERI1
		  ) PERIODO1,
		  -----------------------------------------------------------------------------------------------------
		  CASE 
			  WHEN (P.OID_PERI1 = DATOS.OID_PERI) THEN
			  	   DATOS.IMPORTE
			  ELSE
			  	   0
		  END IMPORTE_P1,
		  CASE 
			  WHEN (P.OID_PERI2 <> -1) THEN
				  (
					  SELECT VAL_NOMB_PERI
					  FROM CRA_PERIO
					  WHERE OID_PERI = P.OID_PERI2
				  )
		  END PERIODO2,
		  -----------------------------------------------------------------------------------------------------
		  CASE 
			  WHEN ((P.OID_PERI2 <> -1) AND (P.OID_PERI2 = DATOS.OID_PERI)) THEN  
			  	   DATOS.IMPORTE
			  ELSE 0
		  END IMPORTE_P2,
		  CASE 
			  WHEN (P.OID_PERI3 <> -1) THEN
				  (
					  SELECT VAL_NOMB_PERI
					  FROM CRA_PERIO
					  WHERE OID_PERI = P.OID_PERI3
				  )
		  END PERIODO3,
		  -----------------------------------------------------------------------------------------------------
		  CASE 
			  WHEN ((P.OID_PERI3 <> -1) AND (P.OID_PERI3 = DATOS.OID_PERI)) THEN  
			  	   DATOS.IMPORTE
			  ELSE  0
		  END IMPORTE_P3,
		  -----------------------------------------------------------------------------------------------------
	  	  CASE 
			  WHEN (P.OID_PERI4 <> -1) THEN
				  (
					  SELECT VAL_NOMB_PERI
					  FROM CRA_PERIO
					  WHERE OID_PERI = P.OID_PERI4
				  )
		  END PERIODO4,
		  -----------------------------------------------------------------------------------------------------
		  CASE 
			  WHEN ((P.OID_PERI4 <> -1) AND (P.OID_PERI4 = DATOS.OID_PERI)) THEN  
			  	   DATOS.IMPORTE
			  ELSE 0
		  END IMPORTE_P4,
		  -----------------------------------------------------------------------------------------------------
		  CASE 
			  WHEN (P.OID_PERI5 <> -1) THEN
				  (
					  SELECT VAL_NOMB_PERI
					  FROM CRA_PERIO
					  WHERE OID_PERI = P.OID_PERI5
				  )
		  END PERIODO5,
		  -----------------------------------------------------------------------------------------------------
		  CASE 
			  WHEN ((P.OID_PERI5 <> -1) AND (P.OID_PERI5 = DATOS.OID_PERI)) THEN  
			  	   DATOS.IMPORTE
			  ELSE 0
		  END IMPORTE_P5
		  -----------------------------------------------------------------------------------------------------
	FROM
	(
	 	--CALCULA LOS CINCO PERIODOS---------------------------------------------------------------------------
		--CALCULA EL PRIMER PERIODO----------------------------------------------------------------------------
		SELECT P1.OID_PERI1,
			   P2.OID_PERI2,
			   P3.OID_PERI3,
			   P4.OID_PERI4,
			   P5.OID_PERI5
		FROM
		(
		 	SELECT OID_PERI OID_PERI1
			FROM 
			(
				SELECT OID_PERI,
					   ROWNUM AS POS
				FROM
				(
					SELECT PERI.OID_PERI
					FROM CRA_PERIO PERI,
						 (
							 SELECT FEC_INIC
							 FROM CRA_PERIO
							 WHERE OID_PERI = 54					-- PARAMETRO DE PERIODO INICIO --
						 ) FI,
						 (
							 SELECT FEC_FINA
							 FROM CRA_PERIO
							 WHERE OID_PERI = 71						-- PARAMETRO DE PERIODO FINAL --
						 ) FF
					WHERE FI.FEC_INIC <= PERI.FEC_INIC
						  AND FF.FEC_FINA >= PERI.FEC_FINA
						  AND PERI.MARC_OID_MARC IN (1,2)					-- PARAMETRO DE MARCA (no es in)--
						  AND PERI.CANA_OID_CANA = 1					-- PARAMETRO DE CANAL --
						  AND PERI.PAIS_OID_PAIS = 1					-- PARAMETRO DE PAIS --
					ORDER BY PERI.FEC_INIC
				)
			)
			WHERE POS = 1 
		) P1,
		--CALCULA EL SEGUNDO PERIODO---------------------------------------------------------------------------
		(
		SELECT CASE WHEN ( 2 > (
						   		SELECT COUNT(PERI.OID_PERI) TOTAL
								FROM CRA_PERIO PERI,
									 (
										 SELECT FEC_INIC
										 FROM CRA_PERIO
										 WHERE OID_PERI = 54					-- PARAMETRO DE PERIODO INICIO --
									 ) FI,
									 (
										 SELECT FEC_FINA
										 FROM CRA_PERIO
										 WHERE OID_PERI = 71						-- PARAMETRO DE PERIODO FINAL --
									 ) FF
								WHERE FI.FEC_INIC <= PERI.FEC_INIC
									  AND FF.FEC_FINA >= PERI.FEC_FINA
									  AND PERI.MARC_OID_MARC IN (1,2)					-- PARAMETRO DE MARCA (no es in)--
									  AND PERI.CANA_OID_CANA = 1					-- PARAMETRO DE CANAL --
									  AND PERI.PAIS_OID_PAIS = 1					-- PARAMETRO DE PAIS --
								)) THEN
						-1
					ELSE
						(
							SELECT OID_PERI 
							FROM 
							(
								SELECT OID_PERI,
									   ROWNUM AS POS
								FROM
								(
									SELECT PERI.OID_PERI
									FROM CRA_PERIO PERI,
										 (
											 SELECT FEC_INIC
											 FROM CRA_PERIO
											 WHERE OID_PERI = 54					-- PARAMETRO DE PERIODO INICIO --
										 ) FI,
										 (
											 SELECT FEC_FINA
											 FROM CRA_PERIO
											 WHERE OID_PERI = 71						-- PARAMETRO DE PERIODO FINAL --
										 ) FF
									WHERE FI.FEC_INIC <= PERI.FEC_INIC
										  AND FF.FEC_FINA >= PERI.FEC_FINA
										  AND PERI.MARC_OID_MARC IN (1,2)					-- PARAMETRO DE MARCA (no es in)--
										  AND PERI.CANA_OID_CANA = 1					-- PARAMETRO DE CANAL --
										  AND PERI.PAIS_OID_PAIS = 1					-- PARAMETRO DE PAIS --
									ORDER BY PERI.FEC_INIC
								)
							)
							WHERE POS = 2 
						)
					END OID_PERI2			
				FROM DUAL
		) P2,
		--CALCULA EL TERCER PERIODO----------------------------------------------------------------------------
		(
		SELECT CASE WHEN ( 3 > (
						   		SELECT COUNT(PERI.OID_PERI) TOTAL
								FROM CRA_PERIO PERI,
									 (
										 SELECT FEC_INIC
										 FROM CRA_PERIO
										 WHERE OID_PERI = 54					-- PARAMETRO DE PERIODO INICIO --
									 ) FI,
									 (
										 SELECT FEC_FINA
										 FROM CRA_PERIO
										 WHERE OID_PERI = 71						-- PARAMETRO DE PERIODO FINAL --
									 ) FF
								WHERE FI.FEC_INIC <= PERI.FEC_INIC
									  AND FF.FEC_FINA >= PERI.FEC_FINA
									  AND PERI.MARC_OID_MARC IN (1,2)					-- PARAMETRO DE MARCA (no es in)--
									  AND PERI.CANA_OID_CANA = 1					-- PARAMETRO DE CANAL --
									  AND PERI.PAIS_OID_PAIS = 1					-- PARAMETRO DE PAIS --
								)) THEN
						-1
					ELSE
						(
							SELECT OID_PERI 
							FROM 
							(
								SELECT OID_PERI,
									   ROWNUM AS POS
								FROM
								(
									SELECT PERI.OID_PERI
									FROM CRA_PERIO PERI,
										 (
											 SELECT FEC_INIC
											 FROM CRA_PERIO
											 WHERE OID_PERI = 54					-- PARAMETRO DE PERIODO INICIO --
										 ) FI,
										 (
											 SELECT FEC_FINA
											 FROM CRA_PERIO
											 WHERE OID_PERI = 71						-- PARAMETRO DE PERIODO FINAL --
										 ) FF
									WHERE FI.FEC_INIC <= PERI.FEC_INIC
										  AND FF.FEC_FINA >= PERI.FEC_FINA
										  AND PERI.MARC_OID_MARC IN (1,2)					-- PARAMETRO DE MARCA (no es in)--
										  AND PERI.CANA_OID_CANA = 1					-- PARAMETRO DE CANAL --
										  AND PERI.PAIS_OID_PAIS = 1					-- PARAMETRO DE PAIS --
									ORDER BY PERI.FEC_INIC
								)
							)
							WHERE POS = 3 
						)
					END OID_PERI3			
				FROM DUAL
		) P3,
		--CALCULA EL CUARTO PERIODO----------------------------------------------------------------------------
		(
		SELECT CASE WHEN ( 4 > (
						   		SELECT COUNT(PERI.OID_PERI) TOTAL
								FROM CRA_PERIO PERI,
									 (
										 SELECT FEC_INIC
										 FROM CRA_PERIO
										 WHERE OID_PERI = 54					-- PARAMETRO DE PERIODO INICIO --
									 ) FI,
									 (
										 SELECT FEC_FINA
										 FROM CRA_PERIO
										 WHERE OID_PERI = 71					-- PARAMETRO DE PERIODO FINAL --
									 ) FF
								WHERE FI.FEC_INIC <= PERI.FEC_INIC
									  AND FF.FEC_FINA >= PERI.FEC_FINA
									  AND PERI.MARC_OID_MARC IN (1,2)					-- PARAMETRO DE MARCA (no es in)--
									  AND PERI.CANA_OID_CANA = 1					-- PARAMETRO DE CANAL --
									  AND PERI.PAIS_OID_PAIS = 1					-- PARAMETRO DE PAIS --
								)) THEN
						-1
					ELSE
						(
							SELECT OID_PERI 
							FROM 
							(
								SELECT OID_PERI,
									   ROWNUM AS POS
								FROM
								(
									SELECT PERI.OID_PERI
									FROM CRA_PERIO PERI,
										 (
											 SELECT FEC_INIC
											 FROM CRA_PERIO
											 WHERE OID_PERI = 54					-- PARAMETRO DE PERIODO INICIO --
										 ) FI,
										 (
											 SELECT FEC_FINA
											 FROM CRA_PERIO
											 WHERE OID_PERI = 71						-- PARAMETRO DE PERIODO FINAL --
										 ) FF
									WHERE FI.FEC_INIC <= PERI.FEC_INIC
										  AND FF.FEC_FINA >= PERI.FEC_FINA
										  AND PERI.MARC_OID_MARC IN (1,2)					-- PARAMETRO DE MARCA (no es in)--
										  AND PERI.CANA_OID_CANA = 1					-- PARAMETRO DE CANAL --
										  AND PERI.PAIS_OID_PAIS = 1					-- PARAMETRO DE PAIS --
									ORDER BY PERI.FEC_INIC
								)
							)
							WHERE POS = 4 
						)
					END OID_PERI4			
				FROM DUAL
		) P4,
		--CALCULA EL QUINTO PERIODO----------------------------------------------------------------------------
		(
		SELECT CASE WHEN ( 5 > (
						   		SELECT COUNT(PERI.OID_PERI) TOTAL
								FROM CRA_PERIO PERI,
									 (
										 SELECT FEC_INIC
										 FROM CRA_PERIO
										 WHERE OID_PERI = 54					-- PARAMETRO DE PERIODO INICIO --
									 ) FI,
									 (
										 SELECT FEC_FINA
										 FROM CRA_PERIO
										 WHERE OID_PERI = 71						-- PARAMETRO DE PERIODO FINAL --
									 ) FF
								WHERE FI.FEC_INIC <= PERI.FEC_INIC
									  AND FF.FEC_FINA >= PERI.FEC_FINA
									  AND PERI.MARC_OID_MARC IN (1,2)					-- PARAMETRO DE MARCA (no es in)--
									  AND PERI.CANA_OID_CANA = 1					-- PARAMETRO DE CANAL --
									  AND PERI.PAIS_OID_PAIS = 1					-- PARAMETRO DE PAIS --
								)) THEN
						-1
					ELSE
						(
							SELECT OID_PERI 
							FROM 
							(
								SELECT OID_PERI,
									   ROWNUM AS POS
								FROM
								(
									SELECT PERI.OID_PERI
									FROM CRA_PERIO PERI,
										 (
											 SELECT FEC_INIC
											 FROM CRA_PERIO
											 WHERE OID_PERI = 54					-- PARAMETRO DE PERIODO INICIO --
										 ) FI,
										 (
											 SELECT FEC_FINA
											 FROM CRA_PERIO
											 WHERE OID_PERI = 71						-- PARAMETRO DE PERIODO FINAL --
										 ) FF
									WHERE FI.FEC_INIC <= PERI.FEC_INIC
										  AND FF.FEC_FINA >= PERI.FEC_FINA
										  AND PERI.MARC_OID_MARC IN (1,2)					-- PARAMETRO DE MARCA (no es in)--
										  AND PERI.CANA_OID_CANA = 1					-- PARAMETRO DE CANAL --
										  AND PERI.PAIS_OID_PAIS = 1					-- PARAMETRO DE PAIS --
									ORDER BY PERI.FEC_INIC
								)
							)
							WHERE POS = 5 
						)
					END OID_PERI5			
				FROM DUAL
		) P5
	) P,
	--FIN CALCULO DE LOS 5 PERIODOS----------------------------------------------------------------------------
	(
		SELECT REG.DES_REGI,
			  ZONA.DES_ZONA,
			  ZONA.CLIE_OID_CLIE CLIE_ZONA,
			  SEC.COD_SECC,
			  SEC.CLIE_OID_CLIE CLIE_SEC,
			  TER.COD_TERR,
			  CLI.COD_CLIE,
			  CLI.VAL_NOM1||' '||CLI.VAL_APE1 NOMBRE_CLI,
			  CLI.FEC_INGR,
			  PERI.OID_PERI,
			  SUM(NVL(SOL_CAB.VAL_TOTA_PAGA_LOCA, 0)) IMPORTE
		FROM MAE_CLIEN CLI,
			 CRA_PERIO PERI,
			 PED_SOLIC_CABEC SOL_CAB,
			 ZON_SUB_GEREN_VENTA SUBG,
			 ZON_REGIO REG,
			 ZON_ZONA ZONA,
			 ZON_SECCI SEC,
			 ZON_TERRI TER,
			 ZON_TERRI_ADMIN TER_ADM,
			 (
				 SELECT P.FEC_INIC, P.FEC_FINA
				 FROM CRA_PERIO P
				 WHERE P.OID_PERI = 61 		   		 			  	-- PARAMETRO DE PERIODO final--
			 ) PERI_PARA,
			 (
				 SELECT FEC_INIC
				 FROM CRA_PERIO
				 WHERE OID_PERI = 54					-- PARAMETRO DE PERIODO INICIO --
			 ) FI,
			 (
				 SELECT FEC_FINA
				 FROM CRA_PERIO
				 WHERE OID_PERI = 71						-- PARAMETRO DE PERIODO FINAL --
			 ) FF
		WHERE FI.FEC_INIC <= PERI.FEC_INIC
			  AND FF.FEC_FINA >= PERI.FEC_FINA
		--	  AND CLI.FEC_INGR BETWEEN FI.FEC_INIC AND FF.FEC_FINA
			  AND CLI.OID_CLIE = SOL_CAB.CLIE_OID_CLIE
			  AND SOL_CAB.PERD_OID_PERI = PERI.OID_PERI
			  AND SOL_CAB.FEC_FACT IS NOT NULL
			  AND SOL_CAB.IND_TS_NO_CONSO <> 1
			  AND SOL_CAB.IND_PEDI_PRUE <> 1 
			  AND SUBG.OID_SUBG_VENT = REG.ZSGV_OID_SUBG_VENT
			  AND REG.OID_REGI = ZONA.ZORG_OID_REGI
			  AND ZONA.OID_ZONA = SEC.ZZON_OID_ZONA
			  AND SEC.OID_SECC = TER_ADM.ZSCC_OID_SECC
			  AND TER.OID_TERR = TER_ADM.TERR_OID_TERR
			  AND SOL_CAB.TERR_OID_TERR = TER.OID_TERR
		  	  AND (SELECT PE.FEC_INIC 
			  	   FROM CRA_PERIO PE
				   WHERE ZONA.PERD_OID_PERI_INIC = PE.OID_PERI
				  ) <= PERI_PARA.FEC_INIC  
			  AND (SELECT DECODE(PE.FEC_FINA, NULL, SYSDATE, PE.FEC_FINA) 
			  	   FROM CRA_PERIO PE
				   WHERE ZONA.PERD_OID_PERI_FINA = PE.OID_PERI
				  ) >= PERI_PARA.FEC_FINA	 
		  	  AND (SELECT PE.FEC_INIC 
			  	   FROM CRA_PERIO PE
				   WHERE SEC.PERD_OID_PERI_INIC = PE.OID_PERI
				  ) <= PERI_PARA.FEC_INIC  
			  AND (SELECT DECODE(PE.FEC_FINA, NULL, SYSDATE, PE.FEC_FINA) 
			  	   FROM CRA_PERIO PE
				   WHERE SEC.PERD_OID_PERI_FINA = PE.OID_PERI
				  ) >= PERI_PARA.FEC_FINA	 
			  AND PERI.PAIS_OID_PAIS = 1						-- PARAMETRO DE PAIS --
			  AND PERI.MARC_OID_MARC = 1					-- PARAMETRO DE MARCA--
			  AND PERI.CANA_OID_CANA = 1					-- PARAMETRO DE CANAL --
			  AND SUBG.OID_SUBG_VENT IN (1,1028,1029,1030,1031,1032,1033)					-- PARAMETRO DE SUBGERENCIA DE VENTAS --
			  AND REG.OID_REGI IN (1,2,3,4,5,6)						-- PARAMETRO DE REGION --
			  AND ZONA.OID_ZONA IN (13,12,11,10,9,8,6,1)						-- PARAMETRO DE ZONA --
			  AND SEC.OID_SECC IN (1,2,3,4,5,6,7,8,9,10,11,12,13)						-- PARAMETRO DE SECCION -- 
    		  AND TER.OID_TERR IN (1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20)						-- PARAMETRO DE TERRRITORIO --
		GROUP BY  REG.DES_REGI,
			  ZONA.DES_ZONA,
			  ZONA.CLIE_OID_CLIE,
			  SEC.COD_SECC,
			  SEC.CLIE_OID_CLIE,
			  TER.COD_TERR,
			  CLI.COD_CLIE,
	  		  CLI.VAL_NOM1||' '||CLI.VAL_APE1,
			  CLI.FEC_INGR,
			  PERI.OID_PERI
	) DATOS
)	   
GROUP BY DES_REGI,
	  DES_ZONA,
	  GERENTE_ZONA,
	  COD_SECC,
	  GERENTE_SECC,
	  COD_TERR,
	  PERIODO_INGRESO,
	  COD_CLIE,
	  NOMBRE_CLI,
	  PERIODO1,
	  PERIODO2,
	  PERIODO3,
	  PERIODO4,
	  PERIODO5