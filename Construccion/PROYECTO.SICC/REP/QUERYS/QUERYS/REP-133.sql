SELECT GEN_PAIS.VAL_I18N PAIS, 	   DATOS.SOCI OID_SOCI, 	   GEN_SOC.VAL_I18N SOCI, 	   DATOS.V_MES_NUM, 	   DATOS.V_MES, 	   DATOS.DOSANIOS_ANIO, 	   DATOS.UNANIO_ANIO, 	   DATOS.ANIOACTUAL_ANIO,      	   DATOS.DOSANIOS_IMP, 	   DATOS.DOSANIOS_PEND, 	   DATOS.DOSANIOS_PORC, 	   DATOS.UNANIO_IMP, 	   DATOS.UNANIO_PEND, 	   DATOS.UNANIO_PORC, 	   DATOS.ANIOACTUAL_IMP, 	   DATOS.ANIOACTUAL_PEND, 	   DATOS.ANIOACTUAL_PORC FROM 	(	 	SELECT TABLA2.PAIS, 		   TABLA2.SOCI, 		   TABLA2.V_MES_NUM, 		   TABLA2.V_MES, 		   TABLA2.DOSANIOS_ANIO, 		   TABLA2.DOSANIOS_IMP, 		   TABLA2.DOSANIOS_PEND, 		   TABLA2.DOSANIOS_PORC, 		   TABLA2.UNANIO_ANIO, 		   TABLA2.UNANIO_IMP, 		   TABLA2.UNANIO_PEND, 		   TABLA2.UNANIO_PORC, 		   (TO_CHAR(SYSDATE,'YYYY') - 0) ANIOACTUAL_ANIO, 		   NVL(ANIOACTUAL.IMP, 0) ANIOACTUAL_IMP, 		   NVL(ANIOACTUAL.PEND, 0) ANIOACTUAL_PEND, 		   NVL(ANIOACTUAL.PORC, 0) ANIOACTUAL_PORC 	FROM 	( 		 	SELECT PAIS.OID_PAIS, 				   MOV_CCC.SOCI_OID_SOCI, 				   TO_CHAR(MOV_CCC.FEC_DOCU,'MM') AS MES_NUM, 				   SUM(NVL(MOV_CCC.IMP_MOVI,0)) AS IMP, 				   SUM(NVL(MOV_CCC.IMP_PEND,0)) AS PEND, 				   DECODE(SUM(NVL(MOV_CCC.IMP_MOVI,0)), 0, 0, (SUM(NVL(MOV_CCC.IMP_PEND,0)) / SUM(NVL(MOV_CCC.IMP_MOVI,0)))) * 100 PORC 			FROM SEG_CANAL CANAL, 				 SEG_MARCA MARCA, 				 ZON_SUB_GEREN_VENTA SUB_GER, 				 SEG_PAIS PAIS, 				 ZON_REGIO REG, 				 ZON_ZONA ZONA, 				 ZON_SECCI SEC, 				 ZON_TERRI TER, 				 ZON_TERRI_ADMIN TER_ADM, 				 CCC_MOVIM_CUENT_CORRI MOV_CCC, 			     SEG_SOCIE SOC 			WHERE SUB_GER.CANA_OID_CANA = CANAL.OID_CANA  				  AND SUB_GER.MARC_OID_MARC = MARCA.OID_MARC 				  AND SUB_GER.PAIS_OID_PAIS = PAIS.OID_PAIS 				  AND REG.ZSGV_OID_SUBG_VENT = SUB_GER.OID_SUBG_VENT 				  AND ZONA.ZORG_OID_REGI = REG.OID_REGI 				  AND SEC.ZZON_OID_ZONA = ZONA.OID_ZONA 				  AND TER_ADM.TERR_OID_TERR = TER.OID_TERR 				  AND TER_ADM.TERR_OID_TERR = SEC.OID_SECC 				  AND MOV_CCC.ZTAD_OID_TERR_ADMI = TER_ADM.OID_TERR_ADMI 				  AND SOC.OID_SOCI = MOV_CCC.SOCI_OID_SOCI	   				  AND MOV_CCC.FEC_DOCU  <  TO_DATE('01/01/'||''||(TO_CHAR(SYSDATE,'YYYY') + 1),  'dd/mm/yyyy' )  				  AND MOV_CCC.FEC_DOCU >= TO_DATE('01/01/'||''||(TO_CHAR(SYSDATE,'YYYY') ),  'dd/mm/yyyy' ) 						   				  AND PAIS.OID_PAIS =  1  				  AND MARCA.OID_MARC =  1  			      AND CANAL.OID_CANA =  1  				  AND REG.OID_REGI IN ( 1 ) 				   AND ZONA.OID_ZONA IN ( 1 )  				   AND SEC.OID_SECC IN ( 1 )  				   AND TER.COD_TERR >=  '1'   				   AND TER.COD_TERR  < =  '1'    			GROUP BY  				  PAIS.OID_PAIS, 				  MOV_CCC.SOCI_OID_SOCI, 				  MARCA.OID_MARC, 				  CANAL.OID_CANA, 				  TO_CHAR(MOV_CCC.FEC_DOCU,'MM') 	) ANIOACTUAL	 	RIGHT OUTER JOIN		    	( 		SELECT TABLA1.PAIS, 			   TABLA1.SOCI, 			   TABLA1.V_MES_NUM, 			   TABLA1.V_MES, 			   TABLA1.DOSANIOS_ANIO, 			   TABLA1.DOSANIOS_IMP, 			   TABLA1.DOSANIOS_PEND, 			   TABLA1.DOSANIOS_PORC, 			   (TO_CHAR(SYSDATE,'YYYY') - 1) UNANIO_ANIO, 			   NVL(UNANIO.IMP, 0) UNANIO_IMP, 			   NVL(UNANIO.PEND, 0) UNANIO_PEND, 			   NVL(UNANIO.PORC, 0) UNANIO_PORC 		FROM 		(	 		 	SELECT PAIS.OID_PAIS, 				   MOV_CCC.SOCI_OID_SOCI, 				   TO_CHAR(MOV_CCC.FEC_DOCU,'MM') AS MES_NUM, 				   SUM(NVL(MOV_CCC.IMP_MOVI,0)) AS IMP, 				   SUM(NVL(MOV_CCC.IMP_PEND,0)) AS PEND, 				   DECODE(SUM(NVL(MOV_CCC.IMP_MOVI,0)), 0, 0, (SUM(NVL(MOV_CCC.IMP_PEND,0)) / SUM(NVL(MOV_CCC.IMP_MOVI,0)))) * 100 PORC 			FROM SEG_CANAL CANAL, 				 SEG_MARCA MARCA, 				 ZON_SUB_GEREN_VENTA SUB_GER, 				 SEG_PAIS PAIS, 				 ZON_REGIO REG, 				 ZON_ZONA ZONA, 				 ZON_SECCI SEC, 				 ZON_TERRI TER, 				 ZON_TERRI_ADMIN TER_ADM, 				 CCC_MOVIM_CUENT_CORRI MOV_CCC, 			     SEG_SOCIE SOC 			WHERE SUB_GER.CANA_OID_CANA = CANAL.OID_CANA  				  AND SUB_GER.MARC_OID_MARC = MARCA.OID_MARC 				  AND SUB_GER.PAIS_OID_PAIS = PAIS.OID_PAIS 				  AND REG.ZSGV_OID_SUBG_VENT = SUB_GER.OID_SUBG_VENT 				  AND ZONA.ZORG_OID_REGI = REG.OID_REGI 				  AND SEC.ZZON_OID_ZONA = ZONA.OID_ZONA 				  AND TER_ADM.TERR_OID_TERR = TER.OID_TERR 				  AND TER_ADM.TERR_OID_TERR = SEC.OID_SECC 				  AND MOV_CCC.ZTAD_OID_TERR_ADMI = TER_ADM.OID_TERR_ADMI 				  AND SOC.OID_SOCI = MOV_CCC.SOCI_OID_SOCI	   				  AND MOV_CCC.FEC_DOCU  <  TO_DATE('01/01/'||''||(TO_CHAR(SYSDATE,'YYYY') - 0),  'dd/mm/yyyy' ) 				  AND MOV_CCC.FEC_DOCU >= TO_DATE('01/01/'||''||(TO_CHAR(SYSDATE,'YYYY') - 1),  'dd/mm/yyyy' ) 						   				  AND PAIS.OID_PAIS =  1  				  AND MARCA.OID_MARC =  1  			      AND CANAL.OID_CANA =  1  				  AND REG.OID_REGI IN ( 1 ) 				   AND ZONA.OID_ZONA IN ( 1 )  				   AND SEC.OID_SECC IN ( 1 )  				   AND TER.COD_TERR >=  '1'   				   AND TER.COD_TERR  < =  '1'    			GROUP BY  				  PAIS.OID_PAIS, 				  MOV_CCC.SOCI_OID_SOCI, 				  MARCA.OID_MARC, 				  CANAL.OID_CANA, 				  TO_CHAR(MOV_CCC.FEC_DOCU,'MM') 		) UNANIO 		RIGHT OUTER JOIN	 		(	 			SELECT VIRTUAL.PAIS, 				   VIRTUAL.SOCI, 				   VIRTUAL.V_MES_NUM, 				   VIRTUAL.V_MES, 				   (TO_CHAR(SYSDATE,'YYYY') - 2) DOSANIOS_ANIO,      				   NVL(DOSANIOS.IMP, 0) DOSANIOS_IMP, 				   NVL(DOSANIOS.PEND,0) DOSANIOS_PEND, 				   NVL(DOSANIOS.PORC, 0) DOSANIOS_PORC 			FROM		    			( 			( 			 	SELECT PAIS.OID_PAIS, 					   MOV_CCC.SOCI_OID_SOCI, 					   TO_CHAR(MOV_CCC.FEC_DOCU,'MM') AS MES_NUM, 					   SUM(NVL(MOV_CCC.IMP_MOVI,0)) AS IMP, 					   SUM(NVL(MOV_CCC.IMP_PEND,0)) AS PEND, 					   DECODE(SUM(NVL(MOV_CCC.IMP_MOVI,0)), 0, 0, (SUM(NVL(MOV_CCC.IMP_PEND,0)) / SUM(NVL(MOV_CCC.IMP_MOVI,0)))) * 100 PORC 				FROM SEG_CANAL CANAL, 					 SEG_MARCA MARCA, 					 ZON_SUB_GEREN_VENTA SUB_GER, 					 SEG_PAIS PAIS, 					 ZON_REGIO REG, 					 ZON_ZONA ZONA, 					 ZON_SECCI SEC, 					 ZON_TERRI TER, 					 ZON_TERRI_ADMIN TER_ADM, 					 CCC_MOVIM_CUENT_CORRI MOV_CCC, 				     SEG_SOCIE SOC 				WHERE SUB_GER.CANA_OID_CANA = CANAL.OID_CANA  					  AND SUB_GER.MARC_OID_MARC = MARCA.OID_MARC 					  AND SUB_GER.PAIS_OID_PAIS = PAIS.OID_PAIS 					  AND REG.ZSGV_OID_SUBG_VENT = SUB_GER.OID_SUBG_VENT 					  AND ZONA.ZORG_OID_REGI = REG.OID_REGI 					  AND SEC.ZZON_OID_ZONA = ZONA.OID_ZONA 					  AND TER_ADM.TERR_OID_TERR = TER.OID_TERR 					  AND TER_ADM.TERR_OID_TERR = SEC.OID_SECC 					  AND MOV_CCC.ZTAD_OID_TERR_ADMI = TER_ADM.OID_TERR_ADMI 					  AND SOC.OID_SOCI = MOV_CCC.SOCI_OID_SOCI	   					  AND MOV_CCC.FEC_DOCU  <  TO_DATE('01/01/'||''||(TO_CHAR(SYSDATE,'YYYY') - 1),  'dd/mm/yyyy' )  					  AND MOV_CCC.FEC_DOCU >= TO_DATE('01/01/'||''||(TO_CHAR(SYSDATE,'YYYY') - 2),  'dd/mm/yyyy' ) 						   					  AND PAIS.OID_PAIS =  1  					  AND MARCA.OID_MARC =  1  				      AND CANAL.OID_CANA =  1  					  AND REG.OID_REGI IN ( 1 ) 					   AND ZONA.OID_ZONA IN ( 1 )  					   AND SEC.OID_SECC IN ( 1 )  					   AND TER.COD_TERR >=  '1'    					   AND TER.COD_TERR  < =  '1'   				GROUP BY  					  PAIS.OID_PAIS, 					  MOV_CCC.SOCI_OID_SOCI, 					  MARCA.OID_MARC, 					  CANAL.OID_CANA, 					  TO_CHAR(MOV_CCC.FEC_DOCU,'MM') 			) DOSANIOS 			RIGHT OUTER JOIN 			( 				SELECT PAIS_OID_PAIS PAIS, 					   SOCI_OID_SOCI SOCI, 					   V_MES_NUM, 					   V_MES 				FROM 				( 					SELECT SUB_GER.PAIS_OID_PAIS, 						   MOV_CCC.SOCI_OID_SOCI 					FROM SEG_CANAL CANAL, 						 SEG_MARCA MARCA, 						 ZON_SUB_GEREN_VENTA SUB_GER, 						 ZON_REGIO REG, 						 ZON_ZONA ZONA, 						 ZON_SECCI SEC, 					     ZON_TERRI TER, 						 ZON_TERRI_ADMIN TER_ADM, 						 CCC_MOVIM_CUENT_CORRI MOV_CCC 					WHERE SUB_GER.CANA_OID_CANA = CANAL.OID_CANA  						  AND SUB_GER.MARC_OID_MARC = MARCA.OID_MARC 						  AND REG.ZSGV_OID_SUBG_VENT = SUB_GER.OID_SUBG_VENT 						  AND ZONA.ZORG_OID_REGI = REG.OID_REGI 						  AND SEC.ZZON_OID_ZONA = ZONA.OID_ZONA 						  AND TER_ADM.TERR_OID_TERR = TER.OID_TERR 						  AND TER_ADM.TERR_OID_TERR = SEC.OID_SECC 						  AND MOV_CCC.ZTAD_OID_TERR_ADMI = TER_ADM.OID_TERR_ADMI 						  AND MOV_CCC.FEC_DOCU  <  TO_DATE('01/01/'||''||(TO_CHAR(SYSDATE,'YYYY') + 1),  'dd/mm/yyyy' )  						  AND MOV_CCC.FEC_DOCU >= TO_DATE('01/01/'||''||(TO_CHAR(SYSDATE,'YYYY') - 2),  'dd/mm/yyyy' ) 						   						  AND SUB_GER.PAIS_OID_PAIS =  1  						  AND MARCA.OID_MARC =  1  					      AND CANAL.OID_CANA =  1  						  AND REG.OID_REGI IN ( 1 ) 						   AND ZONA.OID_ZONA IN ( 1 )  						   AND SEC.OID_SECC IN ( 1 )  						   AND TER.COD_TERR >=  '1'   						   AND TER.COD_TERR  < =  '1'   					GROUP BY  						  SUB_GER.PAIS_OID_PAIS, 						  MOV_CCC.SOCI_OID_SOCI 				), 				( 				  	SELECT V_MES_NUM, 					       V_MES						   					FROM 					( 					 		SELECT TO_CHAR(TO_DATE('01/01/2005','DD/MM/YYYY'),'MM') AS V_MES_NUM, 								   'ENERO' V_MES 							FROM DUAL 						UNION 							SELECT TO_CHAR(TO_DATE('01/02/2005','DD/MM/YYYY'),'MM') AS V_MES_NUM, 								   'FEBRERO' V_MES 							FROM DUAL 						UNION 							SELECT TO_CHAR(TO_DATE('01/03/2005','DD/MM/YYYY'),'MM') AS V_MES_NUM, 								   'MARZO' V_MES 							FROM DUAL 						UNION 							SELECT TO_CHAR(TO_DATE('01/04/2005','DD/MM/YYYY'),'MM') AS V_MES_NUM, 								   'ABRIL' V_MES 							FROM DUAL 						UNION 							SELECT TO_CHAR(TO_DATE('01/05/2005','DD/MM/YYYY'),'MM') AS V_MES_NUM, 								   'MAYO' V_MES 							FROM DUAL 						UNION 							SELECT TO_CHAR(TO_DATE('01/06/2005','DD/MM/YYYY'),'MM') AS V_MES_NUM, 								   'JUNIO' V_MES 							FROM DUAL 						UNION 							SELECT TO_CHAR(TO_DATE('01/07/2005','DD/MM/YYYY'),'MM') AS V_MES_NUM, 								   'JULIO' V_MES 							FROM DUAL 						UNION 							SELECT TO_CHAR(TO_DATE('01/08/2005','DD/MM/YYYY'),'MM') AS V_MES_NUM, 								   'AGOSTO' V_MES 							FROM DUAL 						UNION 							SELECT TO_CHAR(TO_DATE('01/09/2005','DD/MM/YYYY'),'MM') AS V_MES_NUM, 								   'SEPTIEMBRE' V_MES 							FROM DUAL 						UNION 							SELECT TO_CHAR(TO_DATE('01/10/2005','DD/MM/YYYY'),'MM') AS V_MES_NUM, 								   'OCTUBRE' V_MES 							FROM DUAL 						UNION 							SELECT TO_CHAR(TO_DATE('01/11/2005','DD/MM/YYYY'),'MM') AS V_MES_NUM, 								   'NOVIEMBRE' V_MES 							FROM DUAL 						UNION 							SELECT TO_CHAR(TO_DATE('01/12/2005','DD/MM/YYYY'),'MM') AS V_MES_NUM, 								   'DICIEMBRE' V_MES 							FROM DUAL 						) 					)  				) VIRTUAL 			ON DOSANIOS.SOCI_OID_SOCI = VIRTUAL.SOCI  			   AND DOSANIOS.MES_NUM = VIRTUAL.V_MES_NUM 			)  		) TABLA1 		ON UNANIO.SOCI_OID_SOCI = TABLA1.SOCI  		   AND UNANIO.MES_NUM = TABLA1.V_MES_NUM 	) TABLA2    	ON ANIOACTUAL.SOCI_OID_SOCI = TABLA2.SOCI  	   AND ANIOACTUAL.MES_NUM = TABLA2.V_MES_NUM    	) DATOS, 	( 		SELECT GEN.VAL_OID, GEN.VAL_I18N 		FROM V_GEN_I18N_SICC GEN 		WHERE GEN.ATTR_ENTI = 'SEG_PAIS' 			  AND GEN.IDIO_OID_IDIO = 1 	) GEN_PAIS, 	( 		SELECT GEN.OID_SOCI VAL_OID, GEN.VAL_DENO VAL_I18N 		FROM SEG_SOCIE GEN 	) GEN_SOC WHERE DATOS.PAIS = GEN_PAIS.VAL_OID(+) 	  AND DATOS.SOCI = GEN_SOC.VAL_OID ORDER BY PAIS, 	     SOCI, 	     DATOS.V_MES_NUM 