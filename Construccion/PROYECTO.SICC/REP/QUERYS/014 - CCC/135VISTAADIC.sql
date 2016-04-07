SELECT PAIS,
	   SOCI,
	   MONEDA,
	   PERIODO,
	   NEGOCIO,
       IMPORTE,	  
	   CASE WHEN (CONTROL = 1) THEN
	   		VENTA_LINEA
	   END VENTA_LINEA,
	   CASE WHEN (CONTROL = 1) THEN
	   		DESC_COMERCIAL
	   END DESC_COMERCIAL,
	   CASE WHEN (CONTROL = 1) THEN
	   		VENTA_CATALOGO
	   END VENTA_CATALOGO,
	   CASE WHEN (CONTROL = 1) THEN
	   		NEG_APOYO
	   END NEG_APOYO,
	   CASE WHEN (CONTROL = 1) THEN
	   		P_USUARIO
	   END P_USUARIO,
	   CASE WHEN (CONTROL = 1) THEN
	   		MAT_PROMOCI
	   END MAT_PROMOCI,
	   CASE WHEN (CONTROL = 1) THEN
	   		RECUP_FLETE
	   END RECUP_FLETE,
	   CASE WHEN (CONTROL = 1) THEN
	   		INCENTIVOS
	   END INCENTIVOS,
	   CASE WHEN (CONTROL = 1) THEN
	   		OTROS_ING
	   END OTROS_ING,
	   CASE WHEN (CONTROL = 1) THEN
	   		TOTAL_VENTA
	   END TOTAL_VENTA,
	   CASE WHEN (CONTROL = 1) THEN
	   		IGV
	   END IGV,
	   CASE WHEN (CONTROL = 1) THEN
	   		REDONDEO
	   END REDONDEO,
   	   CASE WHEN (CONTROL = 1) THEN
	   		TOTAL_FACT
	   END TOTAL_FACT
FROM
(
	SELECT DATOS.PAIS,
		   DATOS.SOCI,
		   MONEDA.MONEDA,
		   DATOS.PERIODO,
		   DATOS.NEGOCIO,
	       DATOS.IMPORTE*MONEDA.VAL_TIPO_CAMB IMPORTE,
		   DATOS.VENTA_LINEA*MONEDA.VAL_TIPO_CAMB VENTA_LINEA,
		   DATOS.DESC_COMERCIAL*MONEDA.VAL_TIPO_CAMB DESC_COMERCIAL,
	       DATOS.VENTA_CATALOGO*MONEDA.VAL_TIPO_CAMB VENTA_CATALOGO,
		   DATOS.NEG_APOYO*MONEDA.VAL_TIPO_CAMB NEG_APOYO,
		   DATOS.P_USUARIO*MONEDA.VAL_TIPO_CAMB P_USUARIO,
		   DATOS.MAT_PROMOCI*MONEDA.VAL_TIPO_CAMB MAT_PROMOCI,
		   DATOS.RECUP_FLETE*MONEDA.VAL_TIPO_CAMB RECUP_FLETE,
		   DATOS.INCENTIVOS*MONEDA.VAL_TIPO_CAMB INCENTIVOS,
		   DATOS.OTROS_ING*MONEDA.VAL_TIPO_CAMB OTROS_ING,
		   DATOS.TOTAL_VENTA*MONEDA.VAL_TIPO_CAMB TOTAL_VENTA,
		   DATOS.IGV*MONEDA.VAL_TIPO_CAMB IGV,
		   DATOS.REDONDEO*MONEDA.VAL_TIPO_CAMB REDONDEO,
		   DATOS.TOTAL_FACT*MONEDA.VAL_TIPO_CAMB TOTAL_FACT,
		   SUM(1) OVER (PARTITION BY PAIS,SOCI,MONEDA,PERIODO ORDER BY ROWNUM) CONTROL	   
	FROM
		(	
			SELECT 	GEN_PAIS.VAL_I18N PAIS,
					GEN_SOCI.VAL_I18N SOCI,
					CASE WHEN (DETALLE.PERI < 10) THEN
						 '0'|| DETALLE.PERI ||' - '|| DETALLE.EJER
					ELSE
						 DETALLE.PERI||' - '||DETALLE.EJER
					END PERIODO,
					DETALLE.PERI,
					GEN_NEGO.VAL_I18N NEGOCIO,
					DETALLE.IMPORTE,
					TOTALES.VENTA_LINEA,
			 	    TOTALES.DESC_COMERCIAL,
				    TOTALES.VENTA_CATALOGO,
				    TOTALES.NEG_APOYO,
				    TOTALES.P_USUARIO,
				    TOTALES.MAT_PROMOCI,
				    TOTALES.RECUP_FLETE,
				    TOTALES.INCENTIVOS,
				    TOTALES.OTROS_ING,
				    TOTALES.TOTAL_VENTA,
				    TOTALES.IGV,
				    TOTALES.REDONDEO,
				    TOTALES.TOTAL_FACT
			FROM	
			(	
			SELECT VIRTUAL.PAIS,
				   VIRTUAL.SOCI,
				   VIRTUAL.PERI,
				   VIRTUAL.EJER,
				   DATOS.VENTA_LINEA,
				   DATOS.DESC_COMERCIAL,
				   DATOS.VENTA_CATALOGO,
				   DATOS.NEG_APOYO,
				   DATOS.P_USUARIO,
				   DATOS.MAT_PROMOCI,
				   DATOS.RECUP_FLETE,
				   DATOS.INCENTIVOS,
				   DATOS.OTROS_ING,
				   DATOS.TOTAL_VENTA,
				   DATOS.IGV,
				   DATOS.REDONDEO,
				   DATOS.TOTAL_FACT	   
			FROM	
				(
					SELECT PAIS,
						   SOCI,
						   VAL_PERI_CONT,
						   VAL_EJER_CONT,
						   SUM(VENTA_LINEA) VENTA_LINEA,
						   SUM(DESC_COMERCIAL) DESC_COMERCIAL,
						   SUM(VENTA_CATALOGO) VENTA_CATALOGO,
						   SUM(NEG_APOYO) NEG_APOYO,
						   SUM(P_USUARIO) P_USUARIO,
						   SUM(MAT_PROMOCI) MAT_PROMOCI,
						   SUM(RECUP_FLETE) RECUP_FLETE,	   
						   SUM(INCENTIVOS) INCENTIVOS,
						   SUM(OTROS_ING) OTROS_ING,
						   SUM(TOTAL_VENTA) TOTAL_VENTA,
						   SUM(IGV) IGV,
						   SUM(REDONDEO) REDONDEO,
						   SUM(TOTAL_FACT) TOTAL_FACT
					FROM				   
						(
						SELECT PAIS,
							   SOCI,
							   VAL_PERI_CONT,
							   VAL_EJER_CONT,
							   CASE WHEN (GRUPO = 'VENTA BRUTA') THEN
							   		VENTA_LINEA
							   ELSE
							   	    VENTA_LINEA*-1
							   END VENTA_LINEA,
							   CASE WHEN (GRUPO = 'VENTA BRUTA') THEN
							   		DESC_COMERCIAL
							   ELSE
							   	    DESC_COMERCIAL*-1
							   END DESC_COMERCIAL,
							   CASE WHEN (GRUPO = 'VENTA BRUTA') THEN
							   		VENTA_CATALOGO
							   ELSE
							   	    VENTA_CATALOGO*-1
							   END VENTA_CATALOGO,
							   CASE WHEN (GRUPO = 'VENTA BRUTA') THEN
							   		NEG_APOYO
							   ELSE
							   	    NEG_APOYO*-1
							   END NEG_APOYO,
							   CASE WHEN (GRUPO = 'VENTA BRUTA') THEN
							   		P_USUARIO
							   ELSE
							   	    P_USUARIO*-1
							   END P_USUARIO,
							   CASE WHEN (GRUPO = 'VENTA BRUTA') THEN
							   		MAT_PROMOCI
							   ELSE
							   	    MAT_PROMOCI*-1
							   END MAT_PROMOCI,
							   CASE WHEN (GRUPO = 'VENTA BRUTA') THEN
							   		RECUP_FLETE
							   ELSE
							   	    RECUP_FLETE*-1
							   END RECUP_FLETE,
							   CASE WHEN (GRUPO = 'VENTA BRUTA') THEN
							   		INCENTIVOS
							   ELSE
							   	    INCENTIVOS*-1
							   END INCENTIVOS,
							   CASE WHEN (GRUPO = 'VENTA BRUTA') THEN
							   		OTROS_ING
							   ELSE
							   	    OTROS_ING*-1
							   END OTROS_ING,
							   CASE WHEN (GRUPO = 'VENTA BRUTA') THEN
							   		TOTAL_VENTA
							   ELSE
							   	    TOTAL_VENTA*-1
							   END TOTAL_VENTA,
							   CASE WHEN (GRUPO = 'VENTA BRUTA') THEN
							   		IGV
							   ELSE
							   	    IGV*-1
							   END IGV,
							   CASE WHEN (GRUPO = 'VENTA BRUTA') THEN
							   		REDONDEO
							   ELSE
							   	    REDONDEO*-1
							   END REDONDEO,
							   CASE WHEN (GRUPO = 'VENTA BRUTA') THEN
							   		TOTAL_FACT
							   ELSE
							   	    TOTAL_FACT*-1
							   END TOTAL_FACT
						FROM
							(			  
				  	  			(
									SELECT PAIS,
										   SOCI,
										   VAL_PERI_CONT,
										   VAL_EJER_CONT,
										   GRUPO,
										   SUM(VENTA_LINEA) VENTA_LINEA,
										   SUM(DESC_COMERCIAL) DESC_COMERCIAL,
										   SUM(VENTA_LINEA)+SUM(DESC_COMERCIAL) AS VENTA_CATALOGO,
										   SUM(NEG_APOYO) NEG_APOYO,
										   SUM(P_USUARIO) P_USUARIO,
										   SUM(MAT_PROMOCI) MAT_PROMOCI,
										   SUM(RECUP_FLETE) RECUP_FLETE,	   
										   SUM(INCENTIVOS) INCENTIVOS,
										   SUM(OTROS_ING) OTROS_ING,
										   SUM(VENTA_LINEA)+SUM(DESC_COMERCIAL)+SUM(NEG_APOYO)+SUM(P_USUARIO)+SUM(MAT_PROMOCI)+SUM(RECUP_FLETE)+SUM(INCENTIVOS)+SUM(OTROS_ING) AS TOTAL_VENTA,
										   SUM(IGV) IGV,
										   SUM(REDONDEO) REDONDEO,
										   SUM(VENTA_LINEA)+SUM(DESC_COMERCIAL)+SUM(NEG_APOYO)+SUM(P_USUARIO)+SUM(MAT_PROMOCI)+SUM(RECUP_FLETE)+SUM(INCENTIVOS)+SUM(OTROS_ING)+SUM(IGV)+SUM(REDONDEO) TOTAL_FACT
									FROM
										(	   
											SELECT NEGO.PAIS_OID_PAIS PAIS,
												   DAT.SOCI_OID_SOCI SOCI,
												   DAT.VAL_PERI_CONT,
												   DAT.VAL_EJER_CONT,
												   CASE WHEN (DAT.VAL_TIPO_ASIE = 'VM') THEN
												   		'VENTA BRUTA'
												   ELSE
												   	    'DEVOLUCIONES'
												   END AS GRUPO,	
												   MAR_PRO.OID_MARC_PROD MARCA,
												   CASE WHEN ((CCC.COD_CUEN_SAP = 410101001 OR CCC.COD_CUEN_SAP = 410301003) AND NEGO.OID_NEGO < > '500') THEN
								                   		 SUM(NVL(DAT.IMP_DATO_SAP, 0))
												   END AS VENTA_LINEA,
								    			   CASE WHEN (CCC.COD_CUEN_SAP = 410301001 OR CCC.COD_CUEN_SAP = 410303001 OR CCC.COD_CUEN_SAP = 410302001) THEN
													   	SUM(NVL(DAT.IMP_DATO_SAP,0))*-1
												   END AS DESC_COMERCIAL,
												   CASE WHEN ((CCC.COD_CUEN_SAP = 410301001 OR CCC.COD_CUEN_SAP = 410301003) AND NEGO.OID_NEGO < > '500') THEN
														SUM(NVL(DAT.IMP_DATO_SAP, 0))
												   END AS NEG_APOYO,
												   CASE WHEN (CCC.COD_CUEN_SAP = 410103001 OR CCC.COD_CUEN_SAP = 410303002) THEN
														SUM(NVL(DAT.IMP_DATO_SAP,0))
												   END AS P_USUARIO,
											   	   CASE WHEN (CCC.COD_CUEN_SAP = 410102001 OR CCC.COD_CUEN_SAP = 410302001) THEN
														SUM(NVL(DAT.IMP_DATO_SAP,0))
												   END AS MAT_PROMOCI,
												   CASE WHEN (CCC.COD_CUEN_SAP = 420101001) THEN
														SUM(NVL(DAT.IMP_DATO_SAP,0))
												   END AS RECUP_FLETE,
												   CASE WHEN (CCC.COD_CUEN_SAP = 410301002) THEN
														SUM(NVL(DAT.IMP_DATO_SAP,0))
												   END AS INCENTIVOS,
												   CASE WHEN (CCC.COD_CUEN_SAP = 420390003) THEN
														SUM(NVL(DAT.IMP_DATO_SAP,0))
												   END AS OTROS_ING,
												   CASE WHEN (CCC.COD_CUEN_SAP = 210101001) THEN
														SUM(NVL(DAT.IMP_DATO_SAP,0))
												   END AS IGV,
												   CASE WHEN (CCC.COD_CUEN_SAP = 420205001) THEN
														SUM(NVL(DAT.IMP_DATO_SAP,0))
												   END AS REDONDEO																	
								 			FROM INT_DATOS_SAPFI DAT,
												 SEG_PERIO_CORPO PER_COR,
											 	 SEG_MARCA_PRODU MAR_PRO,
												 SEG_CANAL CANAL,
												 SEG_ACCES ACCE,
												 SEG_SUBAC SUBA,
												 MAE_NEGOC NEGO,
												 CCC_CUENT_CONTA CCC
											WHERE DAT.IND_FACT_CCC = 'F'
												  AND (DAT.VAL_TIPO_ASIE = 'VM' OR DAT.VAL_TIPO_ASIE = 'AB')
												  AND PER_COR.OID_PERI = DAT.PERI_OID_PERI
												  AND MAR_PRO.OID_MARC_PROD = DAT.MAPR_OID_MARC_PROD
												  AND ACCE.CANA_OID_CANA = CANAL.OID_CANA
												  AND SUBA.ACCE_OID_ACCE = ACCE.OID_ACCE
												  AND SUBA.OID_SBAC = DAT.SBAC_OID_SBAC
												  AND NEGO.OID_NEGO = DAT.NEGO_OID_NEGO
												  AND DAT.CUCO_OID_CUEN_CONT = CCC.OID_CUEN_CONT
												  AND (ACCE.IND_ACCE = 'G' OR ACCE.IND_ACCE = 'C')
			 --  	%start_EJERCICIOCONTABLEVALUE%  AND DAT.VAL_EJER_CONT = %value_EJERCICIOCONTABLEVALUE%		%end_EJERCICIOCONTABLEVALUE%  
			      						          AND NEGO.PAIS_OID_PAIS = 1	
												GROUP BY NEGO.PAIS_OID_PAIS,
													   DAT.SOCI_OID_SOCI,
													   DAT.VAL_PERI_CONT,
													   DAT.VAL_EJER_CONT,
													   DAT.VAL_TIPO_ASIE,
													   MAR_PRO.OID_MARC_PROD,
													   NEGO.OID_NEGO,	   
													   CCC.COD_CUEN_SAP
												)	  
											GROUP BY PAIS,
													 SOCI,
													 VAL_PERI_CONT,
													 VAL_EJER_CONT,
													 GRUPO
										)
										UNION ALL 
										(
											SELECT PAIS,
												   SOCI,
												   VAL_PERI_CONT,
												   VAL_EJER_CONT,	
												   GRUPO,								   
												   SUM(VENTA_LINEA) VENTA_LINEA,
												   SUM(DESC_COMERCIAL) DESC_COMERCIAL,
												   SUM(VENTA_LINEA)+SUM(DESC_COMERCIAL) AS VENTA_CATALOGO,
												   SUM(NEG_APOYO) NEG_APOYO,
												   SUM(P_USUARIO) P_USUARIO,
												   SUM(MAT_PROMOCI) MAT_PROMOCI,
												   SUM(RECUP_FLETE) RECUP_FLETE,	   
												   SUM(INCENTIVOS) INCENTIVOS,
												   SUM(OTROS_ING) OTROS_ING,
												   SUM(VENTA_LINEA)+SUM(DESC_COMERCIAL)+SUM(NEG_APOYO)+SUM(P_USUARIO)+SUM(MAT_PROMOCI)+SUM(RECUP_FLETE)+SUM(INCENTIVOS)+SUM(OTROS_ING) AS TOTAL_VENTA,
												   SUM(IGV) IGV,
												   SUM(REDONDEO) REDONDEO,
												   SUM(VENTA_LINEA)+SUM(DESC_COMERCIAL)+SUM(NEG_APOYO)+SUM(P_USUARIO)+SUM(MAT_PROMOCI)+SUM(RECUP_FLETE)+SUM(INCENTIVOS)+SUM(OTROS_ING)+SUM(IGV)+SUM(REDONDEO) TOTAL_FACT
											FROM
												(	   
												   SELECT NEGO.PAIS_OID_PAIS PAIS,
												          DAT.SOCI_OID_SOCI SOCI,
														  DAT.VAL_PERI_CONT,
														  DAT.VAL_EJER_CONT,
														   CASE WHEN (DAT.VAL_TIPO_ASIE = 'VM') THEN
														   		'VENTA BRUTA'
														   ELSE
														   	    'DEVOLUCIONES'
														   END AS GRUPO,	
														   SUBA.OID_SBAC BELCENTER,
														   CASE WHEN ((CCC.COD_CUEN_SAP = 410101001 OR CCC.COD_CUEN_SAP = 410301003) AND NEGO.OID_NEGO < > '500') THEN
														   		SUM(NVL(DAT.IMP_DATO_SAP,0))
														   END AS VENTA_LINEA,
														   CASE WHEN (CCC.COD_CUEN_SAP = 410301001 OR CCC.COD_CUEN_SAP = 410303001 OR CCC.COD_CUEN_SAP = 410302001) THEN
														   		(SUM(NVL(DAT.IMP_DATO_SAP,0)))* -1
														   END AS DESC_COMERCIAL,
														   CASE WHEN ((CCC.COD_CUEN_SAP = 410301001 OR CCC.COD_CUEN_SAP = 410301003) AND NEGO.OID_NEGO < > '500') THEN
														   		SUM(NVL(DAT.IMP_DATO_SAP,0))
														   END AS NEG_APOYO,
											 			   CASE WHEN (CCC.COD_CUEN_SAP = 410103001 OR CCC.COD_CUEN_SAP = 410303002) THEN
														   		SUM(NVL(DAT.IMP_DATO_SAP,0))
														   END AS P_USUARIO,
													   	   CASE WHEN (CCC.COD_CUEN_SAP = 410102001 OR CCC.COD_CUEN_SAP = 410302001) THEN
														   		SUM(NVL(DAT.IMP_DATO_SAP,0))
														   END AS MAT_PROMOCI,
														   CASE WHEN (CCC.COD_CUEN_SAP = 420101001) THEN
														   		SUM(NVL(DAT.IMP_DATO_SAP,0))
														   END AS RECUP_FLETE,
														   CASE WHEN (CCC.COD_CUEN_SAP = 410301002) THEN
														   		SUM(NVL(DAT.IMP_DATO_SAP,0))
														   END AS INCENTIVOS,
														   CASE WHEN (CCC.COD_CUEN_SAP = 420390003) THEN
														   		SUM(NVL(DAT.IMP_DATO_SAP,0))
														   END AS OTROS_ING,
														   CASE WHEN (CCC.COD_CUEN_SAP = 210101001) THEN
														   		SUM(NVL(DAT.IMP_DATO_SAP,0))
														   END AS IGV,
														   CASE WHEN (CCC.COD_CUEN_SAP = 420205001) THEN
														   		SUM(NVL(DAT.IMP_DATO_SAP,0))
														   END AS REDONDEO															
													FROM INT_DATOS_SAPFI DAT,
														 SEG_PERIO_CORPO PER_COR,
													 	 SEG_MARCA_PRODU MAR_PRO,
														 SEG_CANAL CANAL,
														 SEG_ACCES ACCE,
														 SEG_SUBAC SUBA,
														 MAE_NEGOC NEGO,
														 CCC_CUENT_CONTA CCC
													WHERE DAT.IND_FACT_CCC = 'F'
														  AND (DAT.VAL_TIPO_ASIE = 'VM' OR DAT.VAL_TIPO_ASIE = 'AB')
														  AND PER_COR.OID_PERI = DAT.PERI_OID_PERI
														  AND MAR_PRO.OID_MARC_PROD = DAT.MAPR_OID_MARC_PROD
														  AND ACCE.CANA_OID_CANA = CANAL.OID_CANA
														  AND SUBA.ACCE_OID_ACCE = ACCE.OID_ACCE
														  AND SUBA.OID_SBAC = DAT.SBAC_OID_SBAC
														  AND NEGO.OID_NEGO = DAT.NEGO_OID_NEGO
														  AND DAT.CUCO_OID_CUEN_CONT = CCC.OID_CUEN_CONT
														  AND ACCE.IND_ACCE = 'B'
					 --	%start_EJERCICIOCONTABLEVALUE%  AND DAT.VAL_EJER_CONT = %value_EJERCICIOCONTABLEVALUE%		%end_EJERCICIOCONTABLEVALUE%  
			  	  										  AND NEGO.PAIS_OID_PAIS = 1	
													GROUP BY NEGO.PAIS_OID_PAIS,
														   DAT.SOCI_OID_SOCI,
														   DAT.VAL_PERI_CONT,
														   DAT.VAL_EJER_CONT,
														   DAT.VAL_TIPO_ASIE,
														   SUBA.OID_SBAC,
														   NEGO.OID_NEGO,	   
														   CCC.COD_CUEN_SAP
												)	  
											GROUP BY PAIS,
													 SOCI,
													 VAL_PERI_CONT,
													 VAL_EJER_CONT,
													 GRUPO
										)
										UNION ALL
										(
											SELECT PAIS,
												   SOCI,
												   VAL_PERI_CONT,
												   VAL_EJER_CONT,
												   GRUPO,
												   SUM(VENTA_LINEA) VENTA_LINEA,
												   SUM(DESC_COMERCIAL) DESC_COMERCIAL,
												   SUM(VENTA_LINEA)+SUM(DESC_COMERCIAL) AS VENTA_CATALOGO,
												   SUM(NEG_APOYO) NEG_APOYO,
												   SUM(P_USUARIO) P_USUARIO,
												   SUM(MAT_PROMOCI) MAT_PROMOCI,
												   SUM(RECUP_FLETE) RECUP_FLETE,	   
												   SUM(INCENTIVOS) INCENTIVOS,
												   SUM(OTROS_ING) OTROS_ING,
												   SUM(VENTA_LINEA)+SUM(DESC_COMERCIAL)+SUM(NEG_APOYO)+SUM(P_USUARIO)+SUM(MAT_PROMOCI)+SUM(RECUP_FLETE)+SUM(INCENTIVOS)+SUM(OTROS_ING) AS TOTAL_VENTA,
												   SUM(IGV) IGV,
												   SUM(REDONDEO) REDONDEO,
												   SUM(VENTA_LINEA)+SUM(DESC_COMERCIAL)+SUM(NEG_APOYO)+SUM(P_USUARIO)+SUM(MAT_PROMOCI)+SUM(RECUP_FLETE)+SUM(INCENTIVOS)+SUM(OTROS_ING)+SUM(IGV)+SUM(REDONDEO) TOTAL_FACT
											FROM
											(	   
												SELECT NEGO.PAIS_OID_PAIS PAIS,
													   DAT.SOCI_OID_SOCI SOCI,
													   DAT.VAL_PERI_CONT,
													   DAT.VAL_EJER_CONT,
													   CASE WHEN (DAT.VAL_TIPO_ASIE = 'VM') THEN
													   		'VENTA BRUTA'
													   ELSE
													   	    'DEVOLUCIONES'
													   END AS GRUPO,	
													   CANAL.OID_CANA,
													   CASE WHEN ((CCC.COD_CUEN_SAP = 410101001 OR CCC.COD_CUEN_SAP = 410301003) AND NEGO.OID_NEGO < > '500') THEN
															SUM(NVL(DAT.IMP_DATO_SAP,0))
													   END AS VENTA_LINEA,
													   CASE WHEN (CCC.COD_CUEN_SAP = 410301001 OR CCC.COD_CUEN_SAP = 410303001 OR CCC.COD_CUEN_SAP = 410302001) THEN
													   		(SUM(NVL(DAT.IMP_DATO_SAP,0)))* -1
													   END AS DESC_COMERCIAL,
									 				   CASE WHEN ((CCC.COD_CUEN_SAP = 410301001 OR CCC.COD_CUEN_SAP = 410301003) AND NEGO.OID_NEGO < > '500') THEN
													   		SUM(NVL(DAT.IMP_DATO_SAP,0))
													   END AS NEG_APOYO,
													   CASE WHEN (CCC.COD_CUEN_SAP = 410103001 OR CCC.COD_CUEN_SAP = 410303002) THEN
													   		SUM(NVL(DAT.IMP_DATO_SAP,0))
													   END AS P_USUARIO,
												   	   CASE WHEN (CCC.COD_CUEN_SAP = 410102001 OR CCC.COD_CUEN_SAP = 410302001) THEN
													   		SUM(NVL(DAT.IMP_DATO_SAP,0))
													   END AS MAT_PROMOCI,
													   CASE WHEN (CCC.COD_CUEN_SAP = 420101001) THEN
													   		SUM(NVL(DAT.IMP_DATO_SAP,0))
													   END AS RECUP_FLETE,
													   CASE WHEN (CCC.COD_CUEN_SAP = 410301002) THEN
													   		SUM(NVL(DAT.IMP_DATO_SAP,0))
													   END AS INCENTIVOS,
													   CASE WHEN (CCC.COD_CUEN_SAP = 420390003) THEN
													   		SUM(NVL(DAT.IMP_DATO_SAP,0))
													   END AS OTROS_ING,
													   CASE WHEN (CCC.COD_CUEN_SAP = 210101001) THEN
													   		SUM(NVL(DAT.IMP_DATO_SAP,0))
													   END AS IGV,
													   CASE WHEN (CCC.COD_CUEN_SAP = 420205001) THEN
													   		SUM(NVL(DAT.IMP_DATO_SAP,0))
													   END AS REDONDEO																
												FROM INT_DATOS_SAPFI DAT,
													 SEG_PERIO_CORPO PER_COR,
												 	 SEG_MARCA_PRODU MAR_PRO,
													 SEG_CANAL CANAL,
													 SEG_ACCES ACCE,
													 SEG_SUBAC SUBA,
													 MAE_NEGOC NEGO,
													 CCC_CUENT_CONTA CCC
												WHERE DAT.IND_FACT_CCC = 'F'
													  AND (DAT.VAL_TIPO_ASIE = 'VM' OR DAT.VAL_TIPO_ASIE = 'AB')
													  AND PER_COR.OID_PERI = DAT.PERI_OID_PERI
													  AND MAR_PRO.OID_MARC_PROD = DAT.MAPR_OID_MARC_PROD
													  AND ACCE.CANA_OID_CANA = CANAL.OID_CANA
													  AND SUBA.ACCE_OID_ACCE = ACCE.OID_ACCE
													  AND SUBA.OID_SBAC = DAT.SBAC_OID_SBAC
													  AND NEGO.OID_NEGO = DAT.NEGO_OID_NEGO
													  AND DAT.CUCO_OID_CUEN_CONT = CCC.OID_CUEN_CONT
													  AND ACCE.IND_ACCE = 'O'
			   	--%start_EJERCICIOCONTABLEVALUE%  AND DAT.VAL_EJER_CONT = %value_EJERCICIOCONTABLEVALUE%		%end_EJERCICIOCONTABLEVALUE%  
												       AND NEGO.PAIS_OID_PAIS = 1	
												GROUP BY NEGO.PAIS_OID_PAIS,
													   DAT.SOCI_OID_SOCI,
													   DAT.VAL_PERI_CONT,
													   DAT.VAL_EJER_CONT,
													   DAT.VAL_TIPO_ASIE,
													   CANAL.OID_CANA,
													   NEGO.OID_NEGO,	   
													   CCC.COD_CUEN_SAP
											)	  
											GROUP BY PAIS,
													 SOCI,
													 VAL_PERI_CONT,
													 VAL_EJER_CONT,
													 GRUPO
										)		
						  			)
								)		
					GROUP BY PAIS,
						   SOCI,
						   VAL_PERI_CONT,
						   VAL_EJER_CONT
				 ) DATOS,	 
				 (
					SELECT *
					FROM
					(		
						SELECT DISTINCT DAT.SOCI_OID_SOCI SOCI,
							   NEGO.PAIS_OID_PAIS PAIS			
						FROM INT_DATOS_SAPFI DAT,
							 SEG_PERIO_CORPO PER_COR,
						 	 SEG_MARCA_PRODU MAR_PRO,
							 SEG_ACCES ACCE,
							 SEG_SUBAC SUBA,
							 MAE_NEGOC NEGO
						WHERE DAT.IND_FACT_CCC = 'F'
							  AND (DAT.VAL_TIPO_ASIE = 'VM' OR DAT.VAL_TIPO_ASIE = 'AB')
							  AND PER_COR.OID_PERI = DAT.PERI_OID_PERI
							  AND SUBA.ACCE_OID_ACCE = ACCE.OID_ACCE
							  AND SUBA.OID_SBAC = DAT.SBAC_OID_SBAC
							  AND (ACCE.IND_ACCE = 'G' OR ACCE.IND_ACCE = 'C' OR ACCE.IND_ACCE = 'B' OR ACCE.IND_ACCE = 'O')
			--	%start_EJERCICIOCONTABLEVALUE%  AND DAT.VAL_EJER_CONT = %value_EJERCICIOCONTABLEVALUE%		%end_EJERCICIOCONTABLEVALUE%  
				   			  AND NEGO.PAIS_OID_PAIS = 1
					),
					(
					   SELECT 2005 EJER		  	-- PARAMETRO DE EJERCICIO COMERCIAL --
					   FROM DUAL			
					) ,							
					(
					   (
						   SELECT 1 PERI
						   FROM DUAL
					   )
					   UNION ALL
					   (
						   SELECT 2
						   FROM DUAL
					   )
					   UNION ALL
					   (
						   SELECT 3
						   FROM DUAL
					   )
					   UNION ALL
					   (
						   SELECT 4
						   FROM DUAL
					   )
					   UNION ALL
					   (
						   SELECT 5
						   FROM DUAL
					   )
					   UNION ALL
					   (
						   SELECT 6
						   FROM DUAL
					   )
					   UNION ALL
					   (
						   SELECT 7
						   FROM DUAL
					   )
					   UNION ALL
					   (
						   SELECT 8
						   FROM DUAL
					   )
					   UNION ALL
					   (
						   SELECT 9
						   FROM DUAL
					   )
					   UNION ALL
					   (
						   SELECT 10
						   FROM DUAL
					   )
					   UNION ALL
					   (
						   SELECT 11
						   FROM DUAL
					   )
					   UNION ALL
					   (
						   SELECT 12
						   FROM DUAL
					   )
					) 
				) VIRTUAL
			WHERE DATOS.PAIS(+) = VIRTUAL.PAIS 
			  AND DATOS.SOCI(+) = VIRTUAL.SOCI
			  AND DATOS.VAL_EJER_CONT(+) = VIRTUAL.EJER
			  AND DATOS.VAL_PERI_CONT(+) = VIRTUAL.PERI
			) TOTALES,
			(	 
				SELECT VIRTUAL.PAIS,
					   VIRTUAL.SOCI,
					   VIRTUAL.EJER,
					   VIRTUAL.PERI,
					   VIRTUAL.OID_NEGO,
					   DATOS.IMPORTE
				FROM 
					 (
					 SELECT PAIS,
					 		SOCI,
							VAL_PERI_CONT,
							VAL_EJER_CONT,
							OID_NEGO,
							SUM(IMPORTE) IMPORTE
					 FROM
					 	 (
					 			(
								SELECT PAIS,
									   SOCI,
									   VAL_PERI_CONT,
									   VAL_EJER_CONT,
									   OID_NEGO,
									   SUM(IMPORTE) IMPORTE
								FROM
									(
										SELECT NEGO.PAIS_OID_PAIS PAIS,
											   DAT.SOCI_OID_SOCI SOCI,
											   DAT.VAL_PERI_CONT,
											   DAT.VAL_EJER_CONT,
											   NEGO.OID_NEGO,
					           			   	   CASE WHEN ( DAT.VAL_TIPO_ASIE = 'VM') THEN
												   SUM(NVL(DAT.IMP_DATO_SAP, 0))
											   ELSE
												   SUM(NVL(DAT.IMP_DATO_SAP, 0))*-1
											   END AS IMPORTE
										FROM INT_DATOS_SAPFI DAT,
											 SEG_PERIO_CORPO PER_COR,
										 	 SEG_MARCA_PRODU MAR_PRO,
											 SEG_CANAL CANAL,
											 SEG_ACCES ACCE,
											 SEG_SUBAC SUBA,
											 MAE_NEGOC NEGO,
											 CCC_CUENT_CONTA CCC
										WHERE DAT.IND_FACT_CCC = 'F'
											  AND (CCC.COD_CUEN_SAP = 410101001 OR CCC.COD_CUEN_SAP = 410301003 OR CCC.COD_CUEN_SAP = 01)
											  AND NEGO.OID_NEGO < > '500'
											  AND (DAT.VAL_TIPO_ASIE = 'VM' OR DAT.VAL_TIPO_ASIE = 'AB')
											  AND PER_COR.OID_PERI = DAT.PERI_OID_PERI
											  AND MAR_PRO.OID_MARC_PROD = DAT.MAPR_OID_MARC_PROD
											  AND ACCE.CANA_OID_CANA = CANAL.OID_CANA
											  AND SUBA.ACCE_OID_ACCE = ACCE.OID_ACCE
											  AND SUBA.OID_SBAC = DAT.SBAC_OID_SBAC
											  AND NEGO.OID_NEGO = DAT.NEGO_OID_NEGO
											  AND DAT.CUCO_OID_CUEN_CONT = CCC.OID_CUEN_CONT
											  AND (ACCE.IND_ACCE = 'G' OR ACCE.IND_ACCE = 'C')
				--	%start_EJERCICIOCONTABLEVALUE%  AND DAT.VAL_EJER_CONT = %value_EJERCICIOCONTABLEVALUE%		%end_EJERCICIOCONTABLEVALUE%  
				   							  AND NEGO.PAIS_OID_PAIS = 1	
										GROUP BY NEGO.PAIS_OID_PAIS,
											   DAT.SOCI_OID_SOCI,
											   DAT.VAL_PERI_CONT,
											   DAT.VAL_EJER_CONT,
											   DAT.VAL_TIPO_ASIE,
											   MAR_PRO.OID_MARC_PROD,
											   NEGO.OID_NEGO
									)
									GROUP BY PAIS,
											 SOCI,
											 VAL_PERI_CONT,
											 VAL_EJER_CONT,
											 OID_NEGO
								)
								UNION ALL
								(			
									SELECT PAIS,
										   SOCI,
										   VAL_PERI_CONT,
										   VAL_EJER_CONT,
										   OID_NEGO,
										   SUM(IMPORTE) IMPORTE
									FROM
								    	(
										SELECT NEGO.PAIS_OID_PAIS PAIS,
											   DAT.SOCI_OID_SOCI SOCI,
											   DAT.VAL_PERI_CONT,
											   DAT.VAL_EJER_CONT,
											   SUBA.OID_SBAC BELCENTER,
											   NEGO.OID_NEGO,
											   CASE WHEN (DAT.VAL_TIPO_ASIE = 'VM') THEN
											   	   SUM(NVL(DAT.IMP_DATO_SAP, 0))
											   ELSE
											   	   SUM(NVL(DAT.IMP_DATO_SAP, 0))*-1
										 	   END IMPORTE
										FROM INT_DATOS_SAPFI DAT,
											 SEG_PERIO_CORPO PER_COR,
										 	 SEG_MARCA_PRODU MAR_PRO,
											 SEG_CANAL CANAL,
											 SEG_ACCES ACCE,
											 SEG_SUBAC SUBA,
											 MAE_NEGOC NEGO,
											 CCC_CUENT_CONTA CCC
										WHERE DAT.IND_FACT_CCC = 'F'
											  AND (DAT.VAL_TIPO_ASIE = 'VM' OR DAT.VAL_TIPO_ASIE = 'AB')
											  AND (CCC.COD_CUEN_SAP = 410101001 OR CCC.COD_CUEN_SAP = 410301003 OR CCC.COD_CUEN_SAP = 01)
											  AND NEGO.OID_NEGO < > '500'
											  AND PER_COR.OID_PERI = DAT.PERI_OID_PERI
											  AND MAR_PRO.OID_MARC_PROD = DAT.MAPR_OID_MARC_PROD
											  AND ACCE.CANA_OID_CANA = CANAL.OID_CANA
											  AND SUBA.ACCE_OID_ACCE = ACCE.OID_ACCE
											  AND SUBA.OID_SBAC = DAT.SBAC_OID_SBAC
											  AND NEGO.OID_NEGO = DAT.NEGO_OID_NEGO
											  AND DAT.CUCO_OID_CUEN_CONT = CCC.OID_CUEN_CONT
											  AND ACCE.IND_ACCE = 'B'
				--%start_EJERCICIOCONTABLEVALUE%  AND DAT.VAL_EJER_CONT = %value_EJERCICIOCONTABLEVALUE%		%end_EJERCICIOCONTABLEVALUE%  
				   AND NEGO.PAIS_OID_PAIS = 1
										GROUP BY NEGO.PAIS_OID_PAIS,
											   DAT.SOCI_OID_SOCI,
											   DAT.VAL_EJER_CONT,
											   DAT.VAL_PERI_CONT,
				 							   DAT.VAL_TIPO_ASIE,
				 							   SUBA.OID_SBAC,
												   NEGO.OID_NEGO
										)
								GROUP BY PAIS,
										 SOCI,
										 VAL_EJER_CONT,
										 VAL_PERI_CONT,
										 OID_NEGO
					    	)
							UNION ALL 
							(
								SELECT PAIS,
									   SOCI,
									   VAL_PERI_CONT,
									   VAL_EJER_CONT,
									   OID_NEGO,
									   SUM(IMPORTE) IMPORTE
								FROM
							    	(
					   				SELECT NEGO.PAIS_OID_PAIS PAIS,
										   DAT.SOCI_OID_SOCI SOCI,
										   DAT.VAL_PERI_CONT,
										   DAT.VAL_EJER_CONT,
										   CANAL.OID_CANA,		   
										   NEGO.OID_NEGO,
										   CASE WHEN (DAT.VAL_TIPO_ASIE = 'VM') THEN
										   		SUM(NVL(DAT.IMP_DATO_SAP, 0))
										   ELSE
										   	   SUM(NVL(DAT.IMP_DATO_SAP, 0))*-1
										   END AS IMPORTE
									FROM INT_DATOS_SAPFI DAT,
										 SEG_PERIO_CORPO PER_COR,
									 	 SEG_MARCA_PRODU MAR_PRO,
										 SEG_CANAL CANAL,
										 SEG_ACCES ACCE,
										 SEG_SUBAC SUBA,
										 MAE_NEGOC NEGO,
										 CCC_CUENT_CONTA CCC	 
									WHERE DAT.IND_FACT_CCC = 'F'
										  AND (DAT.VAL_TIPO_ASIE = 'VM' OR DAT.VAL_TIPO_ASIE = 'AB')
										  AND (CCC.COD_CUEN_SAP = 410101001 OR CCC.COD_CUEN_SAP = 410301003 OR CCC.COD_CUEN_SAP = 01)
										  AND NEGO.OID_NEGO < > '500'
										  AND PER_COR.OID_PERI = DAT.PERI_OID_PERI
										  AND MAR_PRO.OID_MARC_PROD = DAT.MAPR_OID_MARC_PROD
										  AND ACCE.CANA_OID_CANA = CANAL.OID_CANA
										  AND SUBA.ACCE_OID_ACCE = ACCE.OID_ACCE
										  AND SUBA.OID_SBAC = DAT.SBAC_OID_SBAC
										  AND NEGO.OID_NEGO = DAT.NEGO_OID_NEGO
										  AND DAT.CUCO_OID_CUEN_CONT = CCC.OID_CUEN_CONT
										  AND ACCE.IND_ACCE = 'O'
				--%start_EJERCICIOCONTABLEVALUE%  AND DAT.VAL_EJER_CONT = %value_EJERCICIOCONTABLEVALUE%		%end_EJERCICIOCONTABLEVALUE%  
										  AND NEGO.PAIS_OID_PAIS = 1	
									GROUP BY NEGO.PAIS_OID_PAIS,
											   DAT.SOCI_OID_SOCI,
											   DAT.VAL_EJER_CONT,
											   DAT.VAL_PERI_CONT,
											   DAT.VAL_TIPO_ASIE,
											   CANAL.OID_CANA,
											   NEGO.OID_NEGO
									)
							GROUP BY PAIS,
									 SOCI,
									 VAL_EJER_CONT,
									 VAL_PERI_CONT,
									 OID_NEGO
							)
						)
						GROUP BY PAIS,
					 		SOCI,
							VAL_PERI_CONT,
							VAL_EJER_CONT,
							OID_NEGO
					) DATOS,
					(
						 SELECT *
					  	 FROM
						  	( 
								SELECT DISTINCT NEGO.PAIS_OID_PAIS PAIS,
									   NEGO.OID_NEGO						   
								FROM INT_DATOS_SAPFI DAT,
									 SEG_PERIO_CORPO PER_COR,
								 	 SEG_MARCA_PRODU MAR_PRO,
									 SEG_CANAL CANAL,
									 SEG_ACCES ACCE,
									 SEG_SUBAC SUBA,
									 MAE_NEGOC NEGO
								WHERE DAT.IND_FACT_CCC = 'F'
									  AND (DAT.VAL_TIPO_ASIE = 'VM' OR DAT.VAL_TIPO_ASIE = 'AB')
									  AND PER_COR.OID_PERI = DAT.PERI_OID_PERI
									  AND MAR_PRO.OID_MARC_PROD = DAT.MAPR_OID_MARC_PROD
									  AND ACCE.CANA_OID_CANA = CANAL.OID_CANA
									  AND SUBA.ACCE_OID_ACCE = ACCE.OID_ACCE
									  AND SUBA.OID_SBAC = DAT.SBAC_OID_SBAC
									  AND (ACCE.IND_ACCE = 'G' OR ACCE.IND_ACCE = 'C' OR ACCE.IND_ACCE = 'B' OR ACCE.IND_ACCE = 'O')
				--	%start_EJERCICIOCONTABLEVALUE%  AND DAT.VAL_EJER_CONT = %value_EJERCICIOCONTABLEVALUE%		%end_EJERCICIOCONTABLEVALUE%  
							   AND NEGO.PAIS_OID_PAIS = 1	
							),
							(		
								SELECT DISTINCT DAT.SOCI_OID_SOCI SOCI
								FROM INT_DATOS_SAPFI DAT,
									 SEG_PERIO_CORPO PER_COR,
								 	 SEG_MARCA_PRODU MAR_PRO,
									 SEG_ACCES ACCE,
									 SEG_SUBAC SUBA,
									 MAE_NEGOC NEGO
								WHERE DAT.IND_FACT_CCC = 'F'
									  AND (DAT.VAL_TIPO_ASIE = 'VM' OR DAT.VAL_TIPO_ASIE = 'AB')
									  AND PER_COR.OID_PERI = DAT.PERI_OID_PERI
									  AND SUBA.ACCE_OID_ACCE = ACCE.OID_ACCE
									  AND SUBA.OID_SBAC = DAT.SBAC_OID_SBAC
									  AND (ACCE.IND_ACCE = 'G' OR ACCE.IND_ACCE = 'C' OR ACCE.IND_ACCE = 'B' OR ACCE.IND_ACCE = 'O')
				--	%start_EJERCICIOCONTABLEVALUE%  AND DAT.VAL_EJER_CONT = %value_EJERCICIOCONTABLEVALUE%		%end_EJERCICIOCONTABLEVALUE%  
						   			  AND NEGO.PAIS_OID_PAIS = 1
							),
							(
								SELECT *
								FROM
								(
								   SELECT 2005 EJER		  	-- PARAMETRO DE EJERCICIO COMERCIAL --
								   FROM DUAL			
								) EJER,							
								(
								   (
									   SELECT 1 PERI
									   FROM DUAL
								   )
								   UNION ALL
								   (
									   SELECT 2
									   FROM DUAL
								   )
								   UNION ALL
								   (
									   SELECT 3
									   FROM DUAL
								   )
								   UNION ALL
								   (
									   SELECT 4
									   FROM DUAL
								   )
								   UNION ALL
								   (
									   SELECT 5
									   FROM DUAL
								   )
								   UNION ALL
								   (
									   SELECT 6
									   FROM DUAL
								   )
								   UNION ALL
								   (
									   SELECT 7
									   FROM DUAL
								   )
								   UNION ALL
								   (
									   SELECT 8
									   FROM DUAL
								   )
								   UNION ALL
								   (
									   SELECT 9
									   FROM DUAL
								   )
								   UNION ALL
								   (
									   SELECT 10
									   FROM DUAL
								   )
								   UNION ALL
								   (
									   SELECT 11
									   FROM DUAL
								   )
								   UNION ALL
								   (
									   SELECT 12
									   FROM DUAL
								   )
								) PERI
							)
						) VIRTUAL
					WHERE DATOS.PAIS(+) = VIRTUAL.PAIS 
					  AND DATOS.SOCI(+) = VIRTUAL.SOCI
					  AND DATOS.VAL_EJER_CONT(+) = VIRTUAL.EJER
					  AND DATOS.VAL_PERI_CONT(+) = VIRTUAL.PERI
					  AND DATOS.OID_NEGO(+) = VIRTUAL.OID_NEGO 
			) DETALLE,
			(
			  	SELECT GEN.VAL_OID, GEN.VAL_I18N
				FROM V_GEN_I18N_SICC GEN
				WHERE GEN.ATTR_ENTI = 'SEG_PAIS'
					  AND GEN.IDIO_OID_IDIO = 1				   -- PARAMETRO DE IDIOMA --
			) GEN_PAIS,
			(
			  	SELECT GEN.VAL_OID, GEN.VAL_I18N
				FROM V_GEN_I18N_SICC GEN
				WHERE GEN.ATTR_ENTI = 'SEG_SOCIE'
					  AND GEN.IDIO_OID_IDIO = 1				   -- PARAMETRO DE IDIOMA --
			) GEN_SOCI,
			(
			  	SELECT GEN.VAL_OID, GEN.VAL_I18N
				FROM V_GEN_I18N_SICC GEN
				WHERE GEN.ATTR_ENTI = 'MAE_NEGOC'
					  AND GEN.IDIO_OID_IDIO = 1				   -- PARAMETRO DE IDIOMA --
			) GEN_NEGO
			WHERE TOTALES.PAIS = DETALLE.PAIS
				  AND TOTALES.SOCI = DETALLE.SOCI
				  AND TOTALES.PERI = DETALLE.PERI
				  AND TOTALES.EJER = DETALLE.EJER
				  AND DETALLE.PAIS = GEN_PAIS.VAL_OID(+)
				  AND DETALLE.SOCI = GEN_SOCI.VAL_OID(+)
				  AND DETALLE.OID_NEGO = GEN_NEGO.VAL_OID(+)
			ORDER BY PAIS,
				  	 SOCI,		 
				  	 DETALLE.PERI,
				  	 DETALLE.EJER,
					 NEGOCIO	 		
		) DATOS,
		(		 
			SELECT PERI,
				   CASE WHEN CONTROL = 1 THEN
				   		VAL_TIPO_CAMB
				   ELSE
				   	    1
				   END VAL_TIPO_CAMB,
				   CASE WHEN CONTROL = 1 THEN
				   		MONE_ALTER
				   ELSE
				   	    MONE_NACIO
				   END MONEDA
			FROM
				(  	 
					SELECT PERI.PERI,
					   TIPO_CAMBIO.VAL_TIPO_CAMB,
					   TIPO_CAMBIO.MONE_NACIO,
					   TIPO_CAMBIO.MONE_ALTER,
					   SUM(1) OVER (PARTITION BY PERI.PERI ORDER BY ROWNUM) CONTROL	   
					FROM		 
					(		 
						SELECT V.PERI,
							   MAX(TIP_CAM.FEC_DESD) FECHA	 
						FROM		 
							(
							   (
								   SELECT 1 PERI
								   FROM DUAL
							   )
							   UNION ALL
							   (
								   SELECT 2
								   FROM DUAL
							   )
							   UNION ALL
							   (
								   SELECT 3
								   FROM DUAL
							   )
							   UNION ALL
							   (
								   SELECT 4
								   FROM DUAL
							   )
							   UNION ALL
							   (
								   SELECT 5
								   FROM DUAL
							   )
							   UNION ALL
							   (
								   SELECT 6
								   FROM DUAL
							   )
							   UNION ALL
							   (
								   SELECT 7
								   FROM DUAL
							   )
							   UNION ALL
							   (
								   SELECT 8
								   FROM DUAL
							   )
							   UNION ALL
							   (
								   SELECT 9
								   FROM DUAL
							   )
							   UNION ALL
							   (
								   SELECT 10
								   FROM DUAL
							   )
							   UNION ALL
							   (
								   SELECT 11
								   FROM DUAL
							   )
							   UNION ALL
							   (
								   SELECT 12
								   FROM DUAL
							   )
							) V,
							(		 
								SELECT *
								FROM SEG_TIPO_CAMBI STC,
									 SEG_PAIS PAIS,
									 SEG_MONED MON
								WHERE PAIS.OID_PAIS = 1		 	-- PARAMETRO DE PAIS --
									  AND STC.MONE_OID_MON1 = PAIS.MONE_OID_MONE
									  AND MON.COD_MONE = 'USD'
									  AND STC.MONE_OID_MON2 = MON.OID_MONE
									  AND TO_CHAR(STC.FEC_DESD, 'YYYY') <= 2005 -- PARAMETRO DE EJERCICIO COMERCIAL --
								ORDER BY STC.FEC_DESD DESC
							) TIP_CAM	   		 
						WHERE TO_CHAR(TIP_CAM.FEC_DESD, 'MM/YYYY') <= CASE WHEN V.PERI < 10 THEN 0||V.PERI ELSE TO_CHAR(V.PERI) END||'/'||2005  --PARAMETRO --  
						GROUP BY V.PERI
					) PERI,
					(		 
						SELECT STC.VAL_TIPO_CAMB,
							   GEN_MONE.VAL_I18N MONE_NACIO,
							   GEN_MONE2.VAL_I18N MONE_ALTER,
							   STC.FEC_DESD
						FROM SEG_TIPO_CAMBI STC,
							 SEG_PAIS PAIS,
							 SEG_MONED MON,
							 (
							  	SELECT GEN.VAL_OID, GEN.VAL_I18N
								FROM V_GEN_I18N_SICC GEN
								WHERE GEN.ATTR_ENTI = 'SEG_MONED'
									  AND GEN.IDIO_OID_IDIO = 1    	  	   		-- PARAMETRO DE IDIOMA --
							 ) GEN_MONE,
							 (
							  	SELECT GEN.VAL_OID, GEN.VAL_I18N
								FROM V_GEN_I18N_SICC GEN
								WHERE GEN.ATTR_ENTI = 'SEG_MONED'
									  AND GEN.IDIO_OID_IDIO = 1    	  	   		-- PARAMETRO DE IDIOMA --
							 ) GEN_MONE2
						WHERE PAIS.OID_PAIS = 1		 	-- PARAMETRO DE PAIS --
							  AND STC.MONE_OID_MON1 = PAIS.MONE_OID_MONE
							  AND MON.COD_MONE = 'USD'
							  AND STC.MONE_OID_MON2 = MON.OID_MONE
							  AND TO_CHAR(STC.FEC_DESD, 'YYYY') <= 2005 -- PARAMETRO DE EJERCICIO COMERCIAL --
							  AND PAIS.MONE_OID_MONE = GEN_MONE.VAL_OID(+)
							  AND MON.OID_MONE = GEN_MONE2.VAL_OID(+)
						ORDER BY STC.FEC_DESD DESC
					) TIPO_CAMBIO,
					(
					  	(
						    SELECT 1
							FROM DUAL
						)
						UNION ALL
						(
							SELECT 1
							FROM DUAL
						)
					) TIPO_CAM_VIR
				WHERE TIPO_CAMBIO.FEC_DESD = PERI.FECHA 	   		 
			)
		) MONEDA
	WHERE MONEDA.PERI = DATOS.PERI
)			  	 
ORDER BY PAIS,
	  	 SOCI,
		 MONEDA,
		 PERIODO,
		 NEGOCIO

