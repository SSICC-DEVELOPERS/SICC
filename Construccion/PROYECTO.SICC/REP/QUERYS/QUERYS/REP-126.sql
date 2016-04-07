SELECT GEN_PAIS.VAL_I18N PAIS, 	   CABECERAS.VAL_NOMB_USUA OPERAD, 	   'CARTERA' CARTERA, 	   CABECERAS.GRUPO, 	   DETALLE_ACC.DESC_ACCION, 	   CABECERAS.IMPORTE, 	   CABECERAS.CONSULTORAS, 	   CABECERAS.IMPORTE_SUBT, 	   CABECERAS.PORC_IMPORTE_SUBT, 	   CABECERAS.NRO_CONSULTORAS_SUBT, 	   CABECERAS.PORC_CONSULTORAS_SUBT, 	   DETALLE_ACC.IMPORTE_ACC, 	   (DETALLE_ACC.IMPORTE_ACC/CABECERAS.IMPORTE_SUBT)*100 PORC_IMPORTE_ACC, 	   DETALLE_ACC.NC_ACC NRO_CONSULTORAS_ACC, 	   (DETALLE_ACC.NC_ACC/CABECERAS.NRO_CONSULTORAS_SUBT)*100 PORC_CONSULTORAS_ACC FROM (	 	SELECT CABECERA.PAIS_OID_PAIS, 	    CABECERA.USER_OID_USUA_COBR, 	    CABECERA.VAL_NOMB_USUA, 	    CABECERA.IMPORTE, 	    CABECERA.CONSULTORAS, 	    CABE_SUBTIPOS.GRUPO, 	    CABE_SUBTIPOS.IMPORTE IMPORTE_SUBT, 	    (CABE_SUBTIPOS.IMPORTE/CABECERA.IMPORTE)*100 PORC_IMPORTE_SUBT, 	    CABE_SUBTIPOS.NC NRO_CONSULTORAS_SUBT, 	    (CABE_SUBTIPOS.NC/CABECERA.CONSULTORAS)*100 PORC_CONSULTORAS_SUBT 	FROM 	 ( 	 SELECT CRO_COB.PAIS_OID_PAIS, 	 	   USU_CRO.USER_OID_USUA_COBR, 	 	   USU.VAL_NOMB_USUA, 	 	   SUM(ASI_COB.IMP_DEUD_ASIG) IMPORTE, 	 	   COUNT(DISTINCT MCC.CLIE_OID_CLIE) CONSULTORAS	 	 FROM COB_ASIGN_COBRA ASI_COB, 	 	 COB_CRONO_COBRA CRO_COB, 	 	 COB_USUAR_COBRA USU_CRO, 	 	 CRA_PERIO PERI, 	 	 ZON_SECCI SEC, 	 	 ZON_TERRI_ADMIN TER_ADM, 	 	 ZON_TERRI TER, 	 	 CCC_MOVIM_CUENT_CORRI MCC, 	 	 MAE_CLIEN CLI, 	 	 V_REP_USUAR_LARGO USU 	 WHERE ASI_COB.CRCO_OID_CRON_COBR = CRO_COB.OID_CRON_COBR 	 	  AND ASI_COB.ESAS_OID_ESTA_ASIG  < > 4  	 	  AND ASI_COB.ESAS_OID_ESTA_ASIG  < > 5 	 	  AND CRO_COB.USCO_OID_USUA_COBR = USU_CRO.OID_USUA_COBR  	 	  AND CRO_COB.PERD_OID_PERI = PERI.OID_PERI 	 	  AND MCC.OID_MOVI_CC = ASI_COB.MVCC_OID_MOVI_CC 		  AND USU.COD_USUA = USU_CRO.USER_OID_USUA_COBR 	 	  AND CLI.OID_CLIE = MCC.CLIE_OID_CLIE		   		  AND TER.OID_TERR = TER_ADM.TERR_OID_TERR 	 	  AND MCC.ZSCC_OID_SECC = SEC.OID_SECC 	 	  AND MCC.ZTAD_OID_TERR_ADMI = TER_ADM.OID_TERR_ADMI 	 	  AND CRO_COB.PAIS_OID_PAIS =  1  	 	   AND PERI.MARC_OID_MARC =  1   	 	   AND PERI.CANA_OID_CANA =  1  						 	 	   AND PERI.OID_PERI IN ( 1 )  	 	   AND MCC.ZORG_OID_REGI=  1   	 	   AND SEC.ZZON_OID_ZONA =  1   	 	   AND SEC.OID_SECC =  1   	 	   AND TER.COD_TERR >=  '1'   	 	   AND TER.COD_TERR  < =  '1'  		 	 	   AND CRO_COB.COD_CART =  '1'   	 	   AND USU_CRO.OID_USUA_COBR =  1   	 GROUP BY CRO_COB.PAIS_OID_PAIS, 	 	     USU_CRO.USER_OID_USUA_COBR, 	      	 USU.VAL_NOMB_USUA 	 ) CABECERA,	   	 (	   	 SELECT CRO_COB.PAIS_OID_PAIS, 	 	   USU_CRO.USER_OID_USUA_COBR, 	 	   CASE WHEN (SUB_COB.OID_SUBT_ACCI = 1) THEN 	 	   		'CONTACTADAS' 	 	   ELSE 	 			'NO CONTACTADAS' 	 	   END AS GRUPO, 	 	   SUM(ASI_COB.IMP_DEUD_ASIG) IMPORTE, 	 	   COUNT(DISTINCT CLI.OID_CLIE) NC 	 FROM COB_ASIGN_COBRA ASI_COB, 	 	COB_CRONO_COBRA CRO_COB, 	     COB_USUAR_COBRA USU_CRO, 	     CRA_PERIO PERI, 	     ZON_SECCI SEC, 	     ZON_TERRI_ADMIN TER_ADM, 	   	ZON_TERRI TER, 	     CCC_MOVIM_CUENT_CORRI MCC, 	 	( 	 	SELECT GES_COB.CLIE_OID_CLIE, GES_COB.ACCO_OID_ACCI_COBR 	 	FROM 	 		( 	 		SELECT G.CLIE_OID_CLIE, MAX(G.FEC_GEST) AS FEC_GEST 	 		FROM COB_GESTI_COBRA G 	 		WHERE G.FEC_GEST IS NOT NULL 	 		GROUP BY G.CLIE_OID_CLIE 	 		) GC, 	 		COB_GESTI_COBRA GES_COB 	 	WHERE GC.CLIE_OID_CLIE = GES_COB.CLIE_OID_CLIE 	 		  AND GC.FEC_GEST = GES_COB.FEC_GEST 	 	) GES, 	 	MAE_CLIEN CLI, 	 	COB_ACCIO_COBRA ACC_COB, 	 	COB_SUBTI_ACCIO SUB_COB 	 WHERE ASI_COB.CRCO_OID_CRON_COBR = CRO_COB.OID_CRON_COBR 	    AND ASI_COB.ESAS_OID_ESTA_ASIG  < > 4  	    AND ASI_COB.ESAS_OID_ESTA_ASIG  < > 5 	    AND CRO_COB.USCO_OID_USUA_COBR = USU_CRO.OID_USUA_COBR  	    AND CRO_COB.PERD_OID_PERI = PERI.OID_PERI 	    AND MCC.OID_MOVI_CC = ASI_COB.MVCC_OID_MOVI_CC 	    AND ACC_COB.OID_ACCI_COBR = GES.ACCO_OID_ACCI_COBR 	    AND ACC_COB.SACC_OID_SUBT_ACCI = SUB_COB.OID_SUBT_ACCI 	    AND CLI.OID_CLIE = MCC.CLIE_OID_CLIE 	    AND GES.CLIE_OID_CLIE = CLI.OID_CLIE         AND TER.OID_TERR = TER_ADM.TERR_OID_TERR 	 	AND MCC.ZSCC_OID_SECC = SEC.OID_SECC 	 	AND MCC.ZTAD_OID_TERR_ADMI = TER_ADM.OID_TERR_ADMI 	 	AND CRO_COB.PAIS_OID_PAIS =  1  	 	 AND PERI.MARC_OID_MARC =  1    	  	 AND PERI.CANA_OID_CANA =  1  						  	  	 AND PERI.OID_PERI IN ( 1 )   	  	 AND MCC.ZORG_OID_REGI=  1    	  	 AND SEC.ZZON_OID_ZONA =  1    	  	 AND SEC.OID_SECC =  1    	  	 AND TER.COD_TERR >=  '1'    	  	 AND TER.COD_TERR  < =  '1'  		  	  	 AND CRO_COB.COD_CART =  '1'    	  	 AND USU_CRO.OID_USUA_COBR =  1   	 GROUP BY CRO_COB.PAIS_OID_PAIS, 	 	     USU_CRO.USER_OID_USUA_COBR, 	 	  	 SUB_COB.OID_SUBT_ACCI	  	 ) CABE_SUBTIPOS	   	WHERE CABECERA.USER_OID_USUA_COBR = CABE_SUBTIPOS.USER_OID_USUA_COBR ) CABECERAS,		  (		  	SELECT CRO_COB.PAIS_OID_PAIS, 		   USU_CRO.USER_OID_USUA_COBR, 		   CASE WHEN (SUB_COB.OID_SUBT_ACCI = 1) THEN 		   		'CONTACTADAS' 		   ELSE 				'NO CONTACTADAS' 		   END AS GRUPO, 		   ACC_COB.VAL_DESC DESC_ACCION, 		   SUM(ASI_COB.IMP_DEUD_ASIG) IMPORTE_ACC, 		   COUNT(DISTINCT CLI.OID_CLIE) NC_ACC 	FROM COB_ASIGN_COBRA ASI_COB, 		COB_CRONO_COBRA CRO_COB, 	    COB_USUAR_COBRA USU_CRO, 	    CRA_PERIO PERI, 	    ZON_SECCI SEC, 	    ZON_TERRI_ADMIN TER_ADM, 	  	ZON_TERRI TER, 	    CCC_MOVIM_CUENT_CORRI MCC, 		( 		SELECT GES_COB.CLIE_OID_CLIE, GES_COB.ACCO_OID_ACCI_COBR 		FROM 			( 			SELECT G.CLIE_OID_CLIE, MAX(G.FEC_GEST) AS FEC_GEST 			FROM COB_GESTI_COBRA G 			WHERE G.FEC_GEST IS NOT NULL 			GROUP BY G.CLIE_OID_CLIE 			) GC, 			COB_GESTI_COBRA GES_COB 		WHERE GC.CLIE_OID_CLIE = GES_COB.CLIE_OID_CLIE 			  AND GC.FEC_GEST = GES_COB.FEC_GEST 		) GES, 		MAE_CLIEN CLI, 		COB_ACCIO_COBRA ACC_COB, 		COB_SUBTI_ACCIO SUB_COB 	WHERE ASI_COB.CRCO_OID_CRON_COBR = CRO_COB.OID_CRON_COBR 	   AND ASI_COB.ESAS_OID_ESTA_ASIG  < > 4  	   AND ASI_COB.ESAS_OID_ESTA_ASIG  < > 5 	   AND CRO_COB.USCO_OID_USUA_COBR = USU_CRO.OID_USUA_COBR  	   AND CRO_COB.PERD_OID_PERI = PERI.OID_PERI 	   AND MCC.OID_MOVI_CC = ASI_COB.MVCC_OID_MOVI_CC 	   AND ACC_COB.OID_ACCI_COBR = GES.ACCO_OID_ACCI_COBR 	   AND ACC_COB.SACC_OID_SUBT_ACCI = SUB_COB.OID_SUBT_ACCI 	   AND CLI.OID_CLIE = MCC.CLIE_OID_CLIE 	   AND GES.CLIE_OID_CLIE = CLI.OID_CLIE        AND TER.OID_TERR = TER_ADM.TERR_OID_TERR 	   AND MCC.ZSCC_OID_SECC = SEC.OID_SECC 	   AND MCC.ZTAD_OID_TERR_ADMI = TER_ADM.OID_TERR_ADMI  	   AND CRO_COB.PAIS_OID_PAIS =  1   	    AND PERI.MARC_OID_MARC =  1    	    AND PERI.CANA_OID_CANA =  1  						  	    AND PERI.OID_PERI IN ( 1 )   	    AND MCC.ZORG_OID_REGI=  1    	    AND SEC.ZZON_OID_ZONA =  1    	    AND SEC.OID_SECC =  1    	    AND TER.COD_TERR >=  '1'    	    AND TER.COD_TERR  < =  '1'  		  	    AND CRO_COB.COD_CART =  '1'    	    AND USU_CRO.OID_USUA_COBR =  1   	GROUP BY CRO_COB.PAIS_OID_PAIS, 		     USU_CRO.USER_OID_USUA_COBR, 		  	 SUB_COB.OID_SUBT_ACCI, 			 ACC_COB.VAL_DESC  ) DETALLE_ACC, (     SELECT GEN.VAL_OID, GEN.VAL_I18N     FROM V_GEN_I18N_SICC GEN     WHERE GEN.ATTR_ENTI = 'SEG_PAIS'  	     AND GEN.IDIO_OID_IDIO =  1   ) GEN_PAIS WHERE DETALLE_ACC.USER_OID_USUA_COBR = CABECERAS.USER_OID_USUA_COBR		 	  AND DETALLE_ACC.GRUPO = CABECERAS.GRUPO 	  AND GEN_PAIS.VAL_OID(+) = CABECERAS.PAIS_OID_PAIS		 ORDER BY  PAIS, 	  	    /* CRITERIOORDENACION1*/ ,  	      CABECERAS.GRUPO, 	  	  DETALLE_ACC.DESC_ACCION 