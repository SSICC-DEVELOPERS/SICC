 		 		           SELECT GEN_COMIS.VAL_I18N COMISION, 	   DAT.VAL_NOMB_PERI, 	   DAT.DES_REGI, 	   DAT.DES_ZONA, 	   DAT.DES_SECCI, 	   VAL_CANT_FACT, 	   NUM_DIAS1, 	   SUM(MONT_RECUP_T1) MONT_RECUP_T1, 	   SUM(PORC_RECUP_T1) PORC_RECUP_T1,        SUM(IMP_PAGAR_T1) IMP_PAGAR_T1, 	   NUM_DIAS2, 	   SUM(MONT_RECUP_T2) MONT_RECUP_T2, 	   SUM(PORC_RECUP_T2) PORC_RECUP_T2, 	   SUM(IMP_PAGAR_T2) IMP_PAGAR_T2, 	   NUM_DIAS3, 	   SUM(MONT_RECUP_T3) MONT_RECUP_T3, 	   SUM(PORC_RECUP_T3) PORC_RECUP_T3,        SUM(IMP_PAGAR_T3) IMP_PAGAR_T3, 	   NUM_DIAS4, 	   SUM(MONT_RECUP_T4) MONT_RECUP_T4, 	   SUM(PORC_RECUP_T4) PORC_RECUP_T4, 	   SUM(IMP_PAGAR_T4) IMP_PAGAR_T4, 	   PORC_COMISION_T1, 	   PORC_COMISION_T2, 	   PORC_COMISION_T3, 	   PORC_COMISION_T4 FROM	 ( 	SELECT DATOS.OID_COMI, 		   DATOS.VAL_NOMB_PERI, 		   DATOS.DES_REGI, 		   DATOS.DES_ZONA, 		   DATOS.DES_SECCI, 		   VAL_CANT_FACT, 		   CASE WHEN (TRAMO1  < > -1) THEN 		   		NUM_DIAS1 		   END NUM_DIAS1, 		   CASE WHEN (TRAMO1  < > -1 AND VAL_NIVE_TRAM = TRAMO1) THEN 		   		IMP_MONT_RECU 		   END MONT_RECUP_T1, 		   CASE WHEN (TRAMO1  < > -1 AND VAL_NIVE_TRAM = TRAMO1) THEN 		   		VAL_PORC_RECU 		   END PORC_RECUP_T1, 		   CASE WHEN (TRAMO1  < > -1 AND VAL_NIVE_TRAM = TRAMO1) THEN 		   		IMP_MONT_PAGA 		   END IMP_PAGAR_T1, 	   	   CASE WHEN (TRAMO2  < > -1) THEN 		   		NUM_DIAS2 		   END NUM_DIAS2, 		   CASE WHEN (TRAMO2  < > -1 AND VAL_NIVE_TRAM = TRAMO2) THEN 		   		IMP_MONT_RECU 		   END MONT_RECUP_T2, 		   CASE WHEN (TRAMO2  < > -1 AND VAL_NIVE_TRAM = TRAMO2) THEN 		   		VAL_PORC_RECU 		   END PORC_RECUP_T2, 		   CASE WHEN (TRAMO2  < > -1 AND VAL_NIVE_TRAM = TRAMO2) THEN 		   		IMP_MONT_PAGA 		   END IMP_PAGAR_T2, 		   CASE WHEN (TRAMO3  < > -1) THEN 		   		NUM_DIAS3 		   END NUM_DIAS3, 		   CASE WHEN (TRAMO3  < > -1 AND VAL_NIVE_TRAM = TRAMO3) THEN 		   		IMP_MONT_RECU 		   END MONT_RECUP_T3, 		   CASE WHEN (TRAMO3  < > -1 AND VAL_NIVE_TRAM = TRAMO3) THEN 		   		VAL_PORC_RECU 		   END PORC_RECUP_T3, 		   CASE WHEN (TRAMO3  < > -1 AND VAL_NIVE_TRAM = TRAMO3) THEN 		   		IMP_MONT_PAGA 		   END IMP_PAGAR_T3, 		   CASE WHEN (TRAMO4  < > -1) THEN 		   		NUM_DIAS4 		   END NUM_DIAS4, 		   CASE WHEN (TRAMO4  < > -1 AND VAL_NIVE_TRAM = TRAMO4) THEN 		   		IMP_MONT_RECU 		   END MONT_RECUP_T4, 		   CASE WHEN (TRAMO4  < > -1 AND VAL_NIVE_TRAM = TRAMO4) THEN 		   		VAL_PORC_RECU 		   END PORC_RECUP_T4, 		   CASE WHEN (TRAMO4  < > -1 AND VAL_NIVE_TRAM = TRAMO4) THEN 		   		IMP_MONT_PAGA 		   END IMP_PAGAR_T4,    		   CASE WHEN (TRAMO1  < > -1) THEN 		   		VAL_PORC_COMI1 		   END PORC_COMISION_T1,    		   CASE WHEN (TRAMO2  < > -1) THEN 		   		VAL_PORC_COMI2 		   END PORC_COMISION_T2,    		   CASE WHEN (TRAMO3 < > -1) THEN 		   		VAL_PORC_COMI3 		   END PORC_COMISION_T3,    		   CASE WHEN (TRAMO4  < > -1) THEN 		   		VAL_PORC_COMI4 		   END PORC_COMISION_T4		 	FROM	 	(	 			SELECT T1.NUM_DIAS1, 				   T1.VAL_PORC_COMI1, 				   T1.TRAMO1, 				   T2.NUM_DIAS2, 				   T2.VAL_PORC_COMI2, 				   T2.TRAMO2, 				   T3.NUM_DIAS3, 				   T3.VAL_PORC_COMI3, 				   T3.TRAMO3, 				   T4.NUM_DIAS4, 				   T4.VAL_PORC_COMI4, 				   T4.TRAMO4			    			FROM 			( 				SELECT NUM_DIAS NUM_DIAS1, 					   VAL_PORC_COMI VAL_PORC_COMI1, 					   TRAMO TRAMO1 				FROM 				( 					SELECT NUM_DIAS, 						   TRAMO, 						   VAL_PORC_COMI, 						   ROWNUM AS POS 					FROM 					( 					 	( 						SELECT DISTINCT COM_CLI.VAL_NIVE_TRAM TRAMO, 							   COM_CLI.NUM_DIAS, 							   COM_CLI.VAL_PORC_COMI 						FROM COM_COMIS_COBRA_ACUMU_CLIEN COM_CLI 						WHERE COM_CLI.VAL_NIVE_TRAM >=  1  							  AND COM_CLI.VAL_NIVE_TRAM  < = 4  						ORDER BY COM_CLI.NUM_DIAS 						) 					) 				) 				WHERE POS = 1 			) T1,	 			(	 			SELECT 			(CASE WHEN (2 > ( 						SELECT COUNT(DISTINCT COM_CLI.VAL_NIVE_TRAM) TOTAL_TRAMO	  						FROM COM_COMIS_COBRA_ACUMU_CLIEN COM_CLI 						WHERE COM_CLI.VAL_NIVE_TRAM >=  1  							  AND COM_CLI.VAL_NIVE_TRAM  < =  4   						)) THEN 				 -1		 			ELSE 				(SELECT NUM_DIAS 				FROM 				( 	 				SELECT NUM_DIAS, 						   TRAMO, 						   ROWNUM AS POS 					FROM 					( 					SELECT * 					FROM 					 	( 						SELECT DISTINCT COM_CLI.VAL_NIVE_TRAM TRAMO,  							   COM_CLI.NUM_DIAS NUM_DIAS 						FROM COM_COMIS_COBRA_ACUMU_CLIEN COM_CLI 						WHERE COM_CLI.VAL_NIVE_TRAM >=  1  							  AND COM_CLI.VAL_NIVE_TRAM  < =  4   						ORDER BY NUM_DIAS 						) 					) 				) 				WHERE POS = 2 				)  			END) NUM_DIAS2, 			(CASE WHEN (2 > ( 						SELECT COUNT(DISTINCT COM_CLI.VAL_NIVE_TRAM) TOTAL_TRAMO	  						FROM COM_COMIS_COBRA_ACUMU_CLIEN COM_CLI 						WHERE COM_CLI.VAL_NIVE_TRAM >=  1  							  AND COM_CLI.VAL_NIVE_TRAM  < =  4   						)) THEN 				 -1		 			ELSE 				(SELECT VAL_PORC_COMI 				FROM 				( 	 				SELECT VAL_PORC_COMI, 						   TRAMO, 						   ROWNUM AS POS 					FROM 					( 					SELECT * 					FROM 					 	( 						SELECT DISTINCT COM_CLI.VAL_NIVE_TRAM TRAMO,  							   COM_CLI.NUM_DIAS NUM_DIAS, 							   COM_CLI.VAL_PORC_COMI 						FROM COM_COMIS_COBRA_ACUMU_CLIEN COM_CLI 						WHERE COM_CLI.VAL_NIVE_TRAM >=  1  							  AND COM_CLI.VAL_NIVE_TRAM  < =  4   						ORDER BY NUM_DIAS 						) 					) 				) 				WHERE POS = 2 				)  			END) VAL_PORC_COMI2, 			(CASE WHEN (2 > ( 						SELECT COUNT(DISTINCT COM_CLI.VAL_NIVE_TRAM) TOTAL_TRAMO	  						FROM COM_COMIS_COBRA_ACUMU_CLIEN COM_CLI 						WHERE COM_CLI.VAL_NIVE_TRAM >=  1  							  AND COM_CLI.VAL_NIVE_TRAM  < =  4   						)) THEN 				 -1		 			ELSE 				(SELECT TRAMO				    				FROM 				( 	 				SELECT NUM_DIAS, 						   TRAMO, 						   ROWNUM AS POS 					FROM 					( 					SELECT * 					FROM 					 	( 						SELECT DISTINCT COM_CLI.VAL_NIVE_TRAM TRAMO,  							   COM_CLI.NUM_DIAS NUM_DIAS 						FROM COM_COMIS_COBRA_ACUMU_CLIEN COM_CLI 						WHERE COM_CLI.VAL_NIVE_TRAM >=  1  							  AND COM_CLI.VAL_NIVE_TRAM  < =  4   						ORDER BY NUM_DIAS 						) 					) 				) 				WHERE POS = 2 				)  			END) TRAMO2					  			FROM DUAL		 			) T2, 			( 			SELECT 			(CASE WHEN (3 > ( 						SELECT COUNT(DISTINCT COM_CLI.VAL_NIVE_TRAM) TOTAL_TRAMO	  						FROM COM_COMIS_COBRA_ACUMU_CLIEN COM_CLI 						WHERE COM_CLI.VAL_NIVE_TRAM >=  1  							  AND COM_CLI.VAL_NIVE_TRAM  < =  4   						)) THEN 				 -1		 			ELSE 				(SELECT NUM_DIAS				    				FROM 				( 	 				SELECT NUM_DIAS, 						   TRAMO, 						   ROWNUM AS POS 					FROM 					( 					SELECT * 					FROM 					 	( 						SELECT DISTINCT COM_CLI.VAL_NIVE_TRAM TRAMO,  							   COM_CLI.NUM_DIAS NUM_DIAS 						FROM COM_COMIS_COBRA_ACUMU_CLIEN COM_CLI 						WHERE COM_CLI.VAL_NIVE_TRAM >=  1  							  AND COM_CLI.VAL_NIVE_TRAM  < =  4   						ORDER BY NUM_DIAS 						) 					) 				) 				WHERE POS = 3 				)  			END) NUM_DIAS3, 			(CASE WHEN (3 > ( 						SELECT COUNT(DISTINCT COM_CLI.VAL_NIVE_TRAM) TOTAL_TRAMO	  						FROM COM_COMIS_COBRA_ACUMU_CLIEN COM_CLI 						WHERE COM_CLI.VAL_NIVE_TRAM >=  1  							  AND COM_CLI.VAL_NIVE_TRAM  < =  4   						)) THEN 				 -1		 			ELSE 				(SELECT VAL_PORC_COMI		    				FROM 				( 	 				SELECT VAL_PORC_COMI, 						   TRAMO, 						   ROWNUM AS POS 					FROM 					( 					SELECT * 					FROM 					 	( 						SELECT DISTINCT COM_CLI.VAL_NIVE_TRAM TRAMO,  							   COM_CLI.NUM_DIAS NUM_DIAS, 							   COM_CLI.VAL_PORC_COMI 						FROM COM_COMIS_COBRA_ACUMU_CLIEN COM_CLI 						WHERE COM_CLI.VAL_NIVE_TRAM >=  1  							  AND COM_CLI.VAL_NIVE_TRAM  < =  4   						ORDER BY NUM_DIAS 						) 					) 				) 				WHERE POS = 3 				)  			END) VAL_PORC_COMI3,			 			(CASE WHEN (3 > ( 						SELECT COUNT(DISTINCT COM_CLI.VAL_NIVE_TRAM) TOTAL_TRAMO	  						FROM COM_COMIS_COBRA_ACUMU_CLIEN COM_CLI 						WHERE COM_CLI.VAL_NIVE_TRAM >=  1  							  AND COM_CLI.VAL_NIVE_TRAM  < =  4   						)) THEN 				 -1		 			ELSE 				(SELECT TRAMO				    				FROM 				( 	 				SELECT NUM_DIAS, 						   TRAMO, 						   ROWNUM AS POS 					FROM 					( 					SELECT * 					FROM 					 	( 						SELECT DISTINCT COM_CLI.VAL_NIVE_TRAM TRAMO,  							   COM_CLI.NUM_DIAS NUM_DIAS 						FROM COM_COMIS_COBRA_ACUMU_CLIEN COM_CLI 						WHERE COM_CLI.VAL_NIVE_TRAM >=  1  							  AND COM_CLI.VAL_NIVE_TRAM  < =  4   						ORDER BY NUM_DIAS 						) 					) 				) 				WHERE POS = 3 				)  			END) TRAMO3		  			FROM DUAL		 			) T3, 			( 			SELECT 			(CASE WHEN (4 > ( 						SELECT COUNT(DISTINCT COM_CLI.VAL_NIVE_TRAM) TOTAL_TRAMO	  						FROM COM_COMIS_COBRA_ACUMU_CLIEN COM_CLI 						WHERE COM_CLI.VAL_NIVE_TRAM >=  1  							  AND COM_CLI.VAL_NIVE_TRAM  < =  4   						)) THEN 				 -1		 			ELSE 				(SELECT NUM_DIAS				    				FROM 				( 	 				SELECT NUM_DIAS, 						   TRAMO, 						   ROWNUM AS POS 					FROM 					( 					SELECT * 					FROM 					 	( 						SELECT DISTINCT COM_CLI.VAL_NIVE_TRAM TRAMO,  							   COM_CLI.NUM_DIAS NUM_DIAS 						FROM COM_COMIS_COBRA_ACUMU_CLIEN COM_CLI 						WHERE COM_CLI.VAL_NIVE_TRAM >=  1  							  AND COM_CLI.VAL_NIVE_TRAM  < =  4   						ORDER BY NUM_DIAS 						) 					) 				) 				WHERE POS = 4 				)  			END) NUM_DIAS4, 			(CASE WHEN (4 > ( 						SELECT COUNT(DISTINCT COM_CLI.VAL_NIVE_TRAM) TOTAL_TRAMO	  						FROM COM_COMIS_COBRA_ACUMU_CLIEN COM_CLI 						WHERE COM_CLI.VAL_NIVE_TRAM >=  1  							  AND COM_CLI.VAL_NIVE_TRAM  < =  4   						)) THEN 				 -1		 			ELSE 				(SELECT VAL_PORC_COMI				    				FROM 				( 	 				SELECT VAL_PORC_COMI, 						   TRAMO, 						   ROWNUM AS POS 					FROM 					( 					SELECT * 					FROM 					 	( 						SELECT DISTINCT COM_CLI.VAL_NIVE_TRAM TRAMO,  							   COM_CLI.NUM_DIAS NUM_DIAS, 							   COM_CLI.VAL_PORC_COMI 						FROM COM_COMIS_COBRA_ACUMU_CLIEN COM_CLI 						WHERE COM_CLI.VAL_NIVE_TRAM >=  1  							  AND COM_CLI.VAL_NIVE_TRAM  < =  4   						ORDER BY NUM_DIAS 						) 					) 				) 				WHERE POS = 4 				)  			END) VAL_PORC_COMI4,     		(CASE WHEN (4 > ( 						SELECT COUNT(DISTINCT COM_CLI.VAL_NIVE_TRAM) TOTAL_TRAMO	  						FROM COM_COMIS_COBRA_ACUMU_CLIEN COM_CLI 						WHERE COM_CLI.VAL_NIVE_TRAM >=  1  							  AND COM_CLI.VAL_NIVE_TRAM  < =  4   						)) THEN 				 -1		 			ELSE 				(SELECT TRAMO				    				FROM 				( 	 				SELECT NUM_DIAS, 						   TRAMO, 						   ROWNUM AS POS 					FROM 					( 					SELECT * 					FROM 					 	( 						SELECT DISTINCT COM_CLI.VAL_NIVE_TRAM TRAMO,  							   COM_CLI.NUM_DIAS NUM_DIAS 						FROM COM_COMIS_COBRA_ACUMU_CLIEN COM_CLI 						WHERE COM_CLI.VAL_NIVE_TRAM >=  1  							  AND COM_CLI.VAL_NIVE_TRAM  < =  4   						ORDER BY NUM_DIAS 						) 					) 				) 				WHERE POS = 4 				)  			END) TRAMO4		  			FROM DUAL		 			) T4		 	) T, 	( 		SELECT COM.OID_COMI, 			   PERI.VAL_NOMB_PERI, 			   REG.DES_REGI, 			   ZON.DES_ZONA, 			   SEC.DES_SECCI, 			   COM_ACU.VAL_CANT_FACT, 			   COM_CLI.VAL_NIVE_TRAM, 			   COM_CLI.IMP_MONT_RECU, 			   COM_CLI.VAL_PORC_RECU, 			   COM_CLI.IMP_MONT_PAGA 		FROM ZON_SUB_GEREN_VENTA SUBG, 			 ZON_REGIO REG, 			 ZON_ZONA ZON, 			 ZON_SECCI SEC, 			 COM_COMIS_COBRA_ACUMU_CLIEN COM_CLI, 			 COM_COMIS_COBRA_ACUMU COM_ACU, 			 COM_COMIS_CALCU COM_CAL, 			 COM_COMIS COM, 			 CRA_PERIO PERI, 		 	( 			 SELECT GEN.VAL_OID, GEN.VAL_I18N 			 FROM V_GEN_I18N_SICC GEN 			 WHERE GEN.ATTR_ENTI = 'COM_COMIS' 			 	   AND GEN.IDIO_OID_IDIO = 1  			 	 			 ) GEN_COMIS 		WHERE COM.OID_COMI = COM_CAL.COMI_OID_COMI 		  	    AND (INSTR( 	    ( 		    CASE WHEN (REG.PERD_OID_PERI_FINA IS NOT NULL) THEN 	   		 	 ( 				  	 SELECT PQ_APL_REP.FN_013_FACDTR_CONCAT_PERI(REG.PERD_OID_PERI_INIC, REG.PERD_OID_PERI_FINA) 					 FROM DUAL 				 ) 	 		  	ELSE 	   		 	 ( 				  	 SELECT PQ_APL_REP.FN_013_FACDTR_CONCAT_PERI(REG.PERD_OID_PERI_INIC,( 																		SELECT * 																		FROM 																			(		 																			SELECT P.OID_PERI     																				FROM CRA_PERIO P        																				WHERE P.MARC_OID_MARC =  1           																				AND P.CANA_OID_CANA = 1     																				AND  P.PAIS_OID_PAIS =  1    																				AND SYSDATE  < = P.FEC_FINA         																				AND SYSDATE >= P.FEC_INIC 																			ORDER BY FEC_FINA DESC 	 																			) 																		WHERE ROWNUM = 1 																		)) 					 FROM DUAL 				 ) 	 			END 		), 			 	    	  	 ','|| 41 ||','					 		) > 0) 					  AND SEC.CLIE_OID_CLIE = COM_CAL.CLIE_OID_CLIE 			  AND PERI.OID_PERI = COM.PERD_OID_PERI 			  AND COM_ACU.COMI_OID_COMI = COM.OID_COMI 			  AND COM_ACU.CLIE_OID_CLIE = COM_CAL.CLIE_OID_CLIE 			  AND COM_ACU.PERD_OID_PERI = PERI.OID_PERI 			  AND SUBG.OID_SUBG_VENT = REG.ZSGV_OID_SUBG_VENT 			  AND REG.OID_REGI = ZON.ZORG_OID_REGI 			  AND ZON.OID_ZONA = SEC.ZZON_OID_ZONA 			  AND COM_CLI.VAL_NIVE_TRAM >=  1  			  AND COM_CLI.VAL_NIVE_TRAM  < =  4  			  AND COM_CLI.COC2_OID_COMI_COBR_ACUM = COM_ACU.OID_COMI_COBR_ACUM 			  AND COM.OID_COMI = GEN_COMIS.VAL_OID(+) 			  AND SUBG.PAIS_OID_PAIS =   1  			  AND SUBG.CANA_OID_CANA =  1  			  AND SUBG.MARC_OID_MARC =   1  			   AND SEC.OID_SECC IN ( 1 )  			   AND ZON.OID_ZONA IN ( 1 )   			   AND REG.OID_REGI IN ( 1 )  			   AND SUBG.OID_SUBG_VENT IN ( 1 )  			  AND COM.PERD_OID_PERI =   41  			  AND COM.OID_COMI =  1319  	) DATOS ) DAT, ( SELECT GEN.VAL_OID, GEN.VAL_I18N  FROM V_GEN_I18N_SICC GEN WHERE GEN.ATTR_ENTI = 'COM_COMIS' 	  AND GEN.IDIO_OID_IDIO =  1  ) GEN_COMIS WHERE DAT.OID_COMI = GEN_COMIS.VAL_OID(+) GROUP BY GEN_COMIS.VAL_I18N, 	   DAT.VAL_NOMB_PERI, 	   DAT.DES_REGI, 	   DAT.DES_ZONA, 	   DAT.DES_SECCI, 	   VAL_CANT_FACT, 	   NUM_DIAS1, 	   NUM_DIAS2, 	   NUM_DIAS3, 	   NUM_DIAS4, 	   PORC_COMISION_T1, 	   PORC_COMISION_T2, 	   PORC_COMISION_T3, 	   PORC_COMISION_T4 	   	   		  