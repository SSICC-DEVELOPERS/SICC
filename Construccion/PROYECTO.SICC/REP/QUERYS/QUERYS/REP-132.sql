 SELECT TABLA.PAIS, 	   TABLA.SOC, 	   TABLA.GRUPO, 	   TABLA.SUBGRUPO, 	   TABLA.FEC_DOCU, 	   TABLA.COMPROBANTE, 	   TABLA.IMPORTE, 	   NVL(TABLA.TOTAL, 0) TOT_CAR_ANTERIOR, 	   NVL(ACUMABO.TOTAL, 0) TOT_ABO_ANTERIOR FROM ( 	SELECT * 	FROM 	( 		SELECT GEN_PAIS.VAL_I18N PAIS, 			   DETALLE.PAIS_OID_PAIS, 			   DETALLE.SOCI_OID_SOCI, 			   SOC.VAL_DENO SOC, 			   DETALLE.ORDENGRUPO, 			   DETALLE.GRUPO, 			   DETALLE.ORDENSUBGRUPO, 		       DETALLE.SUBGRUPO, 			   DETALLE.FEC_DOCU, 			   DETALLE.COMPROBANTE, 			   DETALLE.IMPORTE 		FROM 		( 			( 				SELECT PAIS_OID_PAIS, 					   SOCI_OID_SOCI, 					   ORDENGRUPO, 					   GRUPO, 					   ORDENSUBGRUPO, 					   SUBGRUPO, 					   FEC_DOCU, 					   COMPROBANTE, 					   SUM(IMP) IMPORTE 				FROM 				( 					SELECT CAR_ABO_CAB.PAIS_OID_PAIS, 						   CAR_ABO_CAB.SOCI_OID_SOCI, 						   CASE WHEN DET_CAR.IMP >= 0  						   THEN 						   	   'A' 						   ELSE 						   	   'B' 						   END AS ORDENGRUPO, 						   CASE WHEN DET_CAR.IMP >= 0  						   THEN 						   	   'RESUMEN_CARGOS_POR_TIPO_Y_COMPROBANTE' 						   ELSE 						   	   'RESUMEN_ABONOS_POR_TIPO_Y_COMPROBANTE' 						   END AS GRUPO, 						   CASE WHEN DET_CAR.IMP >= 0 						   THEN 						   	   CASE WHEN PRO.COD_proc = 'CCC001' 							   THEN 							   	   'CARGOS_DE_FACTURACION' 							   ELSE 							   	   'CARGOS_DIRECTOS' 							   END 						   ELSE 							   CASE WHEN PRO.COD_proc = 'CCC001' 							   THEN 							   	  'ABONOS_POR_NOTA_DE_CREDITO' 							   ELSE 								  'ABONOS_DIRECTOS' 							   END 						   END AS SUBGRUPO, 						   CASE WHEN DET_CAR.IMP >= 0 						   THEN 						   	   CASE WHEN PRO.COD_proc = 'CCC001' 							   THEN 							   	   'A' 							   ELSE 							   	   'B' 							   END 						   ELSE 							   CASE WHEN PRO.COD_proc = 'CCC001' 							   THEN 							   	  'D' 							   ELSE 								  'E' 							   END 						   END AS ORDENSUBGRUPO, 						   CAR_ABO_CAB.FEC_DOCU, 						   CAR_ABO_CAB.VAL_NUME_LOTE_CONT COMPROBANTE, 						   PRO.COD_proc, 						   CASE WHEN DET_CAR.IMP >= 0 						   THEN 						   	   DET_CAR.IMP 						   ELSE 						   	   (DET_CAR.IMP)*(-1)  						   END AS IMP 					FROM CCC_CABEC_CARGA_ABONO_DIREC CAR_ABO_CAB, 						 CCC_DETAL_CARGO_ABONO_DIREC DET_CAR, 			             CCC_PROCE PRO, 			             CCC_SUBPR SUBP 					WHERE CAR_ABO_CAB.VAL_NUME_LOTE_CONT IS NOT NULL 						  AND DET_CAR.CCAD_OID_CABE_CARG = CAR_ABO_CAB.OID_CABE_CARG 						  AND CAR_ABO_CAB.CCPR_OID_proc = PRO.OID_proc 						  AND PRO.OID_proC= SUBP.CCPR_OID_PROC 			              AND (PRO.COD_proc = 'CCC001' 					       OR ( PRO.COD_proc = 'CCC003' and SUBP.COD_SUBP = 4) )  		 						  AND TO_DATE(CAR_ABO_CAB.FEC_DOCU) >= TO_DATE( '01/01/2001' ,  'dd/MM/yyyy' )                           						  AND TO_DATE(CAR_ABO_CAB.FEC_DOCU)  < = TO_DATE( '01/01/2005' , 'dd/MM/yyyy' )   						  AND CAR_ABO_CAB.PAIS_OID_PAIS =  1 		 						   						  					   				) 				GROUP BY PAIS_OID_PAIS, 					     SOCI_OID_SOCI, 						 ORDENGRUPO, 					     GRUPO,  						 ORDENSUBGRUPO, 					     SUBGRUPO, 						 FEC_DOCU, 					     COMPROBANTE 			)	    		    			UNION ALL 			(	 			 	SELECT CAR_ABO_CAB.PAIS_OID_PAIS, 				       SOC.OID_SOCI, 					   'B' ORDENGRUPO, 			  		   'RESUMEN_ABONOS_POR_TIPO_Y_COMPROBANTE' AS GRUPO, 					   'C' ORDENSUBGRUPO, 					   'ABONOS_COBRANZA' AS SUBGRUPO, 				       CAR_ABO_CAB.FEC_DOCU, 					   CCB.DES_CC COMPROBANTE, 			    	   SUM(DET_CAR.IMP) IMPORTE 				FROM CCC_CABEC_CARGA_ABONO_DIREC CAR_ABO_CAB, 					 SEG_SOCIE SOC, 					 CCC_DETAL_CARGO_ABONO_DIREC DET_CAR, 			         CCC_PROCE PRO, 					 CCC_CUENT_CORRI_BANCA CCB 				WHERE CAR_ABO_CAB.VAL_NUME_LOTE_CONT IS NOT NULL 					  AND CAR_ABO_CAB.SOCI_OID_SOCI = SOC.OID_SOCI 					  AND DET_CAR.CCAD_OID_CABE_CARG = CAR_ABO_CAB.OID_CABE_CARG 					  AND CAR_ABO_CAB.CCPR_OID_proc = PRO.OID_proC 					  AND PRO.COD_proc = 'TES001' 					  AND CCB.OID_CUEN_CORR_BANC = DET_CAR.CCBA_OID_CUEN_CORR_BANC		   					  AND TO_DATE(CAR_ABO_CAB.FEC_DOCU) >= TO_DATE( '01/01/2001' ,  'dd/MM/yyyy' )  					  AND TO_DATE(CAR_ABO_CAB.FEC_DOCU)  < = TO_DATE( '01/01/2005' ,  'dd/MM/yyyy' )        					  AND CAR_ABO_CAB.PAIS_OID_PAIS =   1  				GROUP BY CAR_ABO_CAB.PAIS_OID_PAIS, 					   SOC.OID_SOCI, 					   'B', 					   'RESUMEN_ABONOS_POR_TIPO_Y_COMPROBANTE', 					   'C', 					   'ABONOS_COBRANZA', 					   CAR_ABO_CAB.FEC_DOCU, 					   CCB.DES_CC 			)  		)DETALLE,		  		SEG_SOCIE SOC, 		( 		    SELECT GEN.VAL_OID, GEN.VAL_I18N 			FROM V_GEN_I18N_SICC GEN 			WHERE GEN.ATTR_ENTI = 'SEG_PAIS' 			   AND GEN.IDIO_OID_IDIO =   1 		 		 		) GEN_PAIS 		WHERE DETALLE.PAIS_OID_PAIS = GEN_PAIS.VAL_OID(+) 			  AND DETALLE.SOCI_OID_SOCI = SOC.OID_SOCI 		) DET,	   		(		 	 	 		   SELECT  SOC.OID_SOCI, 				   SUM(DET_CAR.IMP) TOTAL 		   FROM CCC_CABEC_CARGA_ABONO_DIREC CAR_ABO_CAB, 				 SEG_SOCIE SOC, 				 CCC_DETAL_CARGO_ABONO_DIREC DET_CAR, 		         CCC_PROCE PRO, 			     CCC_SUBPR SUBP 		   WHERE CAR_ABO_CAB.VAL_NUME_LOTE_CONT IS NOT NULL 		         AND CAR_ABO_CAB.SOCI_OID_SOCI = SOC.OID_SOCI 				 AND DET_CAR.CCAD_OID_CABE_CARG = CAR_ABO_CAB.OID_CABE_CARG 				 AND DET_CAR.IMP >= 0 				 AND CAR_ABO_CAB.CCPR_OID_proc = PRO.OID_proC 				 AND (PRO.COD_proc = 'CCC001' OR (PRO.COD_proc = 'CCC003' AND SUBP.COD_SUBP = 4)) 				 AND SUBP.CCPR_OID_proc = PRO.OID_proc 			     AND TO_DATE(CAR_ABO_CAB.FEC_DOCU) >= TO_DATE(ADD_MONTHS(TO_DATE( '01/01/2001' ,  'dd/MM/yyyy' ), -1))    			     AND TO_DATE(CAR_ABO_CAB.FEC_DOCU)  < = TO_DATE(ADD_MONTHS(TO_DATE( '01/01/2005' ,  'dd/MM/yyyy' ), -1))    		     	  AND CAR_ABO_CAB.PAIS_OID_PAIS =   1 		   		 			GROUP BY SOC.OID_SOCI 		) ACUMCAR 	WHERE DET.SOCI_OID_SOCI = ACUMCAR.OID_SOCI(+) ) TABLA,	  				  ( 						  	SELECT OID_SOCI, 		   SUM(TOTAL) TOTAL 	FROM 	(	 		( 			SELECT SOC.OID_SOCI, 				   SUM(DET_CAR.IMP * (-1)) TOTAL 			FROM CCC_CABEC_CARGA_ABONO_DIREC CAR_ABO_CAB, 				 SEG_SOCIE SOC, 				 CCC_DETAL_CARGO_ABONO_DIREC DET_CAR, 			     CCC_PROCE PRO, 			     CCC_SUBPR SUBP 			WHERE CAR_ABO_CAB.VAL_NUME_LOTE_CONT IS NOT NULL 				  AND CAR_ABO_CAB.SOCI_OID_SOCI = SOC.OID_SOCI 				  AND DET_CAR.CCAD_OID_CABE_CARG = CAR_ABO_CAB.OID_CABE_CARG 				  AND DET_CAR.IMP  <  0 				  AND CAR_ABO_CAB.CCPR_OID_proc = PRO.OID_proC 			 	  AND (PRO.COD_proc = 'CCC001' OR (PRO.COD_proc = 'CCC003' AND SUBP.COD_SUBP = 4)) 			      AND SUBP.CCPR_OID_proc = PRO.OID_proc 				  AND TO_DATE(CAR_ABO_CAB.FEC_DOCU) >= TO_DATE(ADD_MONTHS(TO_DATE( '01/01/2001' ,  'dd/MM/yyyy' ), -1))  				  AND TO_DATE(CAR_ABO_CAB.FEC_DOCU)  < = TO_DATE(ADD_MONTHS(TO_DATE( '01/01/2005' ,  'dd/MM/yyyy' ), -1))     				  AND CAR_ABO_CAB.PAIS_OID_PAIS=   1 	 			 			GROUP BY SOC.OID_SOCI 		) 		UNION ALL 		(	 		 	SELECT SOC.OID_SOCI, 		    	   SUM(DET_CAR.IMP) TOTAL 			FROM CCC_CABEC_CARGA_ABONO_DIREC CAR_ABO_CAB, 				 SEG_SOCIE SOC, 				 CCC_DETAL_CARGO_ABONO_DIREC DET_CAR, 		         CCC_PROCE PRO, 	 			 CCC_CUENT_CORRI_BANCA CCB 			WHERE CAR_ABO_CAB.VAL_NUME_LOTE_CONT IS NOT NULL 				  AND CAR_ABO_CAB.SOCI_OID_SOCI = SOC.OID_SOCI 				  AND DET_CAR.CCAD_OID_CABE_CARG = CAR_ABO_CAB.OID_CABE_CARG 				  AND CAR_ABO_CAB.CCPR_OID_proc = PRO.OID_proC 				  AND PRO.COD_proc = 'TES001' 				  AND CCB.OID_CUEN_CORR_BANC = CAR_ABO_CAB.CCBA_OID_CUEN_CORR_BANC			   				  AND TO_DATE(CAR_ABO_CAB.FEC_DOCU) >= TO_DATE(ADD_MONTHS(TO_DATE( '01/01/2001' ,  'dd/MM/yyyy' ), -1))    				  AND TO_DATE(CAR_ABO_CAB.FEC_DOCU)  < = TO_DATE(ADD_MONTHS(TO_DATE( '01/01/2005' ,  'dd/MM/yyyy' ), -1))      				  AND CAR_ABO_CAB.PAIS_OID_PAIS =   1 		    				   			GROUP BY CAR_ABO_CAB.PAIS_OID_PAIS, 				   SOC.OID_SOCI 		) 	) 	GROUP BY OID_SOCI ) ACUMABO WHERE TABLA.SOCI_OID_SOCI = ACUMABO.OID_SOCI(+)				  ORDER BY SOC, 	  	 TABLA.ORDENGRUPO, 		 TABLA.ORDENSUBGRUPO, 		 FEC_DOCU 