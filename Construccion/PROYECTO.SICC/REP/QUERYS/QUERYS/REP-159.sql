SELECT PER_ANT.PERIODO_ACT, 	   PER_ANT.PERIODO_ANT, 	   PER_ANT.OID_SUBG_VENT, 	   PER_ANT.DES_SUBG_VENT, 	   PER_ANT.OID_REGI, 	   PER_ANT.DES_REGI, 	   PER_ANT.MONEDA, 	   PER_ANT.ESTIM, 	   PER_ANT.FACTUR, 	   ROUND(DECODE(PER_ANT.ESTIM,0,0,(PER_ANT.FACTUR/PER_ANT.ESTIM)*100)) VAR, 	   NVL(DIARIO.N_PEDIDO,0) PEDID, 	   NVL(DIARIO.MONTO_NETO,0) NETO, 	   DECODE(NVL(DIARIO.N_PEDIDO,0),0,0,DIARIO.MONTO_NETO/DIARIO.N_PEDIDO) PSP_MOV_DIARIO, 	   ROUND(DECODE(NVL(DIARIO.N_PEDIDO,0),0,0,(FALTANTES.FALTA/DIARIO.N_PEDIDO)*100),1) POR_FALTANTES_MOV_DIARIO, 	   PER_ANT.ESTIM_ACT PEDIDOS_ESTIMADOS, 	   NVL(ACUM.N_PEDIDO,0) PEDIDOS_FACT, 	   (NVL(ACUM.N_PEDIDO,0)-PER_ANT.ESTIM_ACT) DIFERENCIA, 	   ROUND(DECODE(PER_ANT.ESTIM_ACT,0,0,(NVL(ACUM.N_PEDIDO,0)/PER_ANT.ESTIM_ACT)*100)) POR_F_E, 	   DECODE(NVL(ACUM.N_PEDIDO,0),0,0,ACUM.NUM_UNID_TOTA/ACUM.N_PEDIDO) PUP,  	   PER_ANT.VENTA_NETA_ACT MONTO_NETO_ESTIMADO,  	   NVL(ACUM.MONTO_NETO,0) MONTO_NETO_FACT, 	   ROUND(DECODE(PER_ANT.VENTA_NETA_ACT,0,0,(NVL(ACUM.MONTO_NETO,0)/PER_ANT.VENTA_NETA_ACT)*100)) POR_VARIACION, 	   DECODE(NVL(ACUM.N_PEDIDO,0),0,0,NVL(ACUM.MONTO_NETO,0)/ACUM.N_PEDIDO) PSP, 	   ROUND(DECODE(NVL(ACUM.N_PEDIDO,0),0,0,(FALTANTES_ACUM.FALTA/ACUM.N_PEDIDO)*100),1) POR_FALTANTES	    FROM ( SELECT PER.VAL_NOMB_PERI PERIODO_ACT, 	   PER_ANT.VAL_NOMB_PERI PERIODO_ANT, 	   SGV.OID_SUBG_VENT, 	   SGV.DES_SUBG_VENT, 	   REG.OID_REGI, 	   REG.DES_REGI, 	   GEN_MONED.VAL_I18N MONEDA, 	   ( 	   	 SELECT COUNT(*) 		 FROM PED_SOLIC_CABEC PSC, 			  ZON_ZONA ZON, 			  SEG_SUBAC SA 		 WHERE PSC.PERD_OID_PERI = PER_ANT.OID_PERI 		 	   AND ZON.ZORG_OID_REGI = REG.OID_REGI 		 	   AND PSC.FEC_FACT IS NOT NULL 			   AND PSC.IND_TS_NO_CONSO  < > 1 			   AND PSC.IND_PEDI_PRUE  < > 1 			   AND PSC.ZZON_OID_ZONA = ZON.OID_ZONA 			   AND PSC.SBAC_OID_SBAC = SA.OID_SBAC 			    AND SA.ACCE_OID_ACCE =  1   	   ) FACTUR, 	   ( 	   	 SELECT NVL(SUM(FVP.NUM_PEDI),0) 		 FROM INT_FUENT_VENTA_PREVI_SAP FVP 		 WHERE FVP.PERD_OID_PERI = PER_ANT.OID_PERI 		 	   AND FVP.ZORG_OID_REGI = REG.OID_REGI 	   ) ESTIM, 	   ( 	   	 SELECT NVL(SUM(FVP.NUM_PEDI),0) 		 FROM INT_FUENT_VENTA_PREVI_SAP FVP 		 WHERE FVP.PERD_OID_PERI = PER.OID_PERI 		 	   AND FVP.ZORG_OID_REGI = REG.OID_REGI 	   ) ESTIM_ACT, 	   ( 	   	 SELECT NVL(SUM(FVP.VAL_VENT_NETA_ESTA),0) 		 FROM INT_FUENT_VENTA_PREVI_SAP FVP 		 WHERE FVP.PERD_OID_PERI = PER.OID_PERI 		 	   AND FVP.ZORG_OID_REGI = REG.OID_REGI 	   ) VENTA_NETA_ACT    FROM CRA_PERIO PER, 	 ZON_REGIO REG,	  	 ZON_SUB_GEREN_VENTA SGV, 	 SEG_PAIS PAIS, 	 ( 	    SELECT GEN.VAL_OID, GEN.VAL_I18N 		FROM V_GEN_I18N_SICC GEN 		WHERE GEN.ATTR_ENTI = 'SEG_MONED' 			  AND GEN.IDIO_OID_IDIO =  1  	 ) GEN_MONED, 	 ( 	    SELECT P.OID_PERI, 			   P.VAL_NOMB_PERI 		FROM CRA_PERIO P 		WHERE P.OID_PERI = (SELECT PQ_APL_REP.FN_008_CALC_OID_PER_ANT(PERI.PAIS_OID_PAIS,PERI.MARC_OID_MARC,PERI.CANA_OID_CANA,PERI.OID_PERI,2) 							FROM CRA_PERIO PERI 							WHERE PERI.OID_PERI =  57 	  	 	 						   ) 	 ) PER_ANT WHERE SGV.OID_SUBG_VENT = REG.ZSGV_OID_SUBG_VENT 	  AND PAIS.OID_PAIS = PER.PAIS_OID_PAIS 	  AND PAIS.MONE_OID_MONE = GEN_MONED.VAL_OID(+) 	  AND PER.PAIS_OID_PAIS =  1  	  AND PER.MARC_OID_MARC =  1  	  AND PER.CANA_OID_CANA =  1  	  AND PER.OID_PERI =  57 	  		 	  AND REG.OID_REGI IN ( 1,7 )			 ) PER_ANT, (	   	  SELECT ZON.ZORG_OID_REGI OID_REGI, 	  		 SUM(PSC.VAL_TOTA_PAGA_LOCA + PSC.VAL_IMPO_REDO_LOCA) MONTO_NETO,  			 COUNT(*) N_PEDIDO 	  FROM PED_SOLIC_CABEC PSC, 	  	   ZON_ZONA ZON,            SEG_SUBAC SA 	  WHERE PSC.FEC_FACT = TO_DATE( '01/05/2005' , 'dd/MM/yyyy' )  		   AND PSC.IND_TS_NO_CONSO  < > 1 		   AND PSC.IND_PEDI_PRUE  < > 1 		   AND PSC.PERD_OID_PERI =  57   	 		   AND PSC.ZZON_OID_ZONA = ZON.OID_ZONA 		   AND ZON.ZORG_OID_REGI IN ( 1,7 )	   				  		   AND PSC.SBAC_OID_SBAC = SA.OID_SBAC 		    AND SA.ACCE_OID_ACCE =  1  	   	 GROUP BY ZON.ZORG_OID_REGI ) DIARIO, (	   SELECT ZORG_OID_REGI, 	   SUM(FALTA) FALTA FROM (	   	SELECT ZORG_OID_REGI, 		   SOCA_OID_SOLI_CABE, 		   CASE WHEN SUM(FALTA)>0 THEN 		   		1 		   ELSE 		   	    0 		   END FALTA 	FROM 	(		   		SELECT CONSO.ZORG_OID_REGI, 			   PSC.SOCA_OID_SOLI_CABE, 			   CASE WHEN (PSP.NUM_UNID_POR_ATEN  < > 0) AND (PSP.NUM_UNID_POR_ATEN IS NOT NULL) AND (PSP.NUM_UNID_POR_ATEN>PSP.NUM_UNID_COMPR) THEN 			   		1 			   ELSE 			   	    0 			   END FALTA	    		FROM PED_SOLIC_CABEC PSC, 			 PED_SOLIC_POSIC PSP,	 		(	   			  SELECT ZON.ZORG_OID_REGI, 			  		 PSC.OID_SOLI_CABE 			  FROM PED_SOLIC_CABEC PSC, 			  	   ZON_ZONA ZON, 		           SEG_SUBAC SA 			  WHERE PSC.FEC_FACT = TO_DATE( '01/05/2005' , 'dd/MM/yyyy' )  				   AND PSC.IND_TS_NO_CONSO  < > 1 				   AND PSC.IND_PEDI_PRUE  < > 1 				   AND PSC.PERD_OID_PERI =  57    				   AND PSC.ZZON_OID_ZONA = ZON.OID_ZONA 				   AND ZON.ZORG_OID_REGI IN ( 1,7 )	   				   AND PSC.SBAC_OID_SBAC = SA.OID_SBAC 				    AND SA.ACCE_OID_ACCE =  1  	   		) CONSO 		WHERE PSC.SOCA_OID_SOLI_CABE = CONSO.OID_SOLI_CABE 			 AND PSC.IND_TS_NO_CONSO = 1 		     AND PSC.IND_PEDI_PRUE  < > 1 			 AND PSP.SOCA_OID_SOLI_CABE = PSC.OID_SOLI_CABE 			 AND PSP.ESPO_OID_ESTA_POSI  < > 2 	)	  	GROUP BY ZORG_OID_REGI, SOCA_OID_SOLI_CABE ) GROUP BY ZORG_OID_REGI ) FALTANTES, 	(	   	  SELECT ZON.ZORG_OID_REGI OID_REGI, 	  		 SUM(PSC.VAL_TOTA_PAGA_LOCA + PSC.VAL_IMPO_REDO_LOCA) MONTO_NETO,  			 COUNT(*) N_PEDIDO, 			 SUM(PSC.NUM_UNID_ATEN_TOTA) NUM_UNID_TOTA 	  FROM PED_SOLIC_CABEC PSC, 	  	   ZON_ZONA ZON,            SEG_SUBAC SA 	  WHERE PSC.IND_TS_NO_CONSO  < > 1 		   AND PSC.IND_PEDI_PRUE  < > 1 		   AND PSC.FEC_FACT IS NOT NULL  		   AND PSC.FEC_FACT >= TO_DATE( '04/12/2004' , 'dd/MM/yyyy' ) 			   		   AND PSC.FEC_FACT  < = TO_DATE( '01/05/2005' , 'dd/MM/yyyy' )-1 			   		   AND PSC.PERD_OID_PERI =  57   			 		   AND PSC.ZZON_OID_ZONA = ZON.OID_ZONA 		   AND ZON.ZORG_OID_REGI IN ( 1,7 )	   			 		   AND PSC.SBAC_OID_SBAC = SA.OID_SBAC 		    AND SA.ACCE_OID_ACCE =  1  	   	 GROUP BY ZON.ZORG_OID_REGI ) ACUM,    (	   SELECT ZORG_OID_REGI, 	   SUM(FALTA) FALTA FROM (	   	SELECT ZORG_OID_REGI, 		   SOCA_OID_SOLI_CABE, 		   CASE WHEN SUM(FALTA)>0 THEN 		   		1 		   ELSE 		   	    0 		   END FALTA 	FROM 	(		   		SELECT CONSO.ZORG_OID_REGI, 			   PSC.SOCA_OID_SOLI_CABE, 			   CASE WHEN (PSP.NUM_UNID_POR_ATEN  < > 0) AND (PSP.NUM_UNID_POR_ATEN IS NOT NULL) AND (PSP.NUM_UNID_POR_ATEN>PSP.NUM_UNID_COMPR) THEN 			   		1 			   ELSE 			   	    0 			   END FALTA	    		FROM PED_SOLIC_CABEC PSC, 			 PED_SOLIC_POSIC PSP,	 			 (	   				  SELECT ZON.ZORG_OID_REGI, 				  		 PSC.OID_SOLI_CABE 				  FROM PED_SOLIC_CABEC PSC, 				  	   ZON_ZONA ZON, 			           SEG_SUBAC SA 				  WHERE PSC.IND_TS_NO_CONSO  < > 1 					   AND PSC.IND_PEDI_PRUE  < > 1 					   AND PSC.FEC_FACT IS NOT NULL  					   AND PSC.FEC_FACT >= TO_DATE( '04/12/2004' , 'dd/MM/yyyy' ) 			   					   AND PSC.FEC_FACT  < = TO_DATE( '01/05/2005' , 'dd/MM/yyyy' )-1 			   					   AND PSC.PERD_OID_PERI =  57  					   AND PSC.ZZON_OID_ZONA = ZON.OID_ZONA 					   AND ZON.ZORG_OID_REGI IN ( 1,7 )	   					   AND PSC.SBAC_OID_SBAC = SA.OID_SBAC 					    AND SA.ACCE_OID_ACCE =  1  	   		   	) CONSO 		WHERE PSC.SOCA_OID_SOLI_CABE = CONSO.OID_SOLI_CABE 			 AND PSC.IND_TS_NO_CONSO = 1 		     AND PSC.IND_PEDI_PRUE  < > 1 			 AND PSP.SOCA_OID_SOLI_CABE = PSC.OID_SOLI_CABE 			 AND PSP.ESPO_OID_ESTA_POSI  < > 2 	)	  	GROUP BY ZORG_OID_REGI, SOCA_OID_SOLI_CABE ) GROUP BY ZORG_OID_REGI ) FALTANTES_ACUM	   WHERE PER_ANT.OID_REGI = DIARIO.OID_REGI(+) 	  AND PER_ANT.OID_REGI = FALTANTES.ZORG_OID_REGI(+) 	  AND PER_ANT.OID_REGI = ACUM.OID_REGI(+) 	  AND PER_ANT.OID_REGI = FALTANTES_ACUM.ZORG_OID_REGI(+) 	  