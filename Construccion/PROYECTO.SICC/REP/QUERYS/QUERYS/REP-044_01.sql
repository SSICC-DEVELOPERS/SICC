 SELECT PAIS, 	   MARCA, 	   CANAL, 	   ACCESO, 	   VAL_NOMB_PERI, 	   VAL_CODI_VENT, 	   COD_SAP, 	   DES_CORT, 	   VAL_TEXT_BREV, 	   DES_CATA, 	   NUM_PAGI_CATA, 	   IMP_PREC_CATA, 	   NUM_UNID_ESTI, 	   MONTONETOEST, 	   NULL AS TIPO_SOLIC, 	   NULL AS TIPO_POSIC, 	   UNID_TOTALES, 	   MONTO_FACT, 	   UNID_FALTANTES, 	   MONTO_NETO FROM ( 	SELECT I18PAIS.VAL_I18N PAIS, 		  MARCA.DES_MARC MARCA, 		  I18CANAL.VAL_I18N CANAL, 		  I18ACC.VAL_I18N ACCESO, 		  PERI.VAL_NOMB_PERI, 		  OFEDET.VAL_CODI_VENT,  		  PROD.COD_SAP, 	      	  PROD.DES_CORT,  		  I18PROD.VAL_I18N AS VAL_TEXT_BREV, 		  CAT.DES_CATA, 		  OFEDET.NUM_PAGI_CATA, 	      OFEDET.IMP_PREC_CATA, 		  OFEDET.NUM_UNID_ESTI, 		  (OFEDET.NUM_UNID_ESTI*OFEDET.IMP_PREC_CATA) AS MONTONETOEST, 		  NVL(SUM(SOLIC_POSIC.NUM_UNID_POR_ATEN), 0) UNID_TOTALES, 		  nvl(sum(solic_posic.VAL_PREC_NETO_TOTA_LOCA),0) AS MONTO_FACT, 		  NVL(SUM(SOLIC_POSIC.NUM_UNID_POR_ATEN-SOLIC_POSIC.NUM_UNID_ATEN),0) UNID_FALTANTES, 		  NVL(SUM((SOLIC_POSIC.NUM_UNID_POR_ATEN-SOLIC_POSIC.NUM_UNID_ATEN)*OFEDET.IMP_PREC_CATA*OFEDET.VAL_FACT_REPE),0) MONTO_NETO        	FROM 		  ( 		  SELECT V.VAL_OID, V.VAL_I18N  		  FROM V_GEN_I18N_SICC V  		  WHERE V.ATTR_ENTI = 'MAE_PRODU' 		  AND V.IDIO_OID_IDIO =  1 		 	 		 		  ) I18PROD, 		  ( 		  SELECT V.VAL_OID, V.VAL_I18N  		  FROM V_GEN_I18N_SICC V  		  WHERE V.ATTR_ENTI = 'SEG_ACCES'  		  AND V.IDIO_OID_IDIO =  1  		  ) I18ACC, 		  ( 		  SELECT V.VAL_OID, V.VAL_I18N  		  FROM V_GEN_I18N_SICC V  		  WHERE V.ATTR_ENTI = 'SEG_PAIS'  		  AND V.IDIO_OID_IDIO =  1 		 	 		 		  ) I18PAIS, 		  ( 		  SELECT V.VAL_OID, V.VAL_I18N  		  FROM V_GEN_I18N_SICC V  		  WHERE V.ATTR_ENTI = 'SEG_CANAL'  		  AND V.IDIO_OID_IDIO =  1 		 	 		 		  ) I18CANAL, 	  	  CRA_PERIO PERI, 		  PRE_OFERT OFE, 		  PRE_OFERT_DETAL OFEDET, 		  PRE_MATRI_FACTU MF, 		  PRE_MATRI_FACTU_CABEC MFC, 		  MAE_PRODU PROD, 		  PRE_CATAL CAT, 		  PED_SOLIC_POSIC SOLIC_POSIC, 		  PED_SOLIC_CABEC SOLIC_CABEC, 		  PED_TIPO_SOLIC_PAIS TIPO_SOLIC_PAIS, 		  PED_TIPO_SOLIC TIPO_SOLIC, 		  SEG_MARCA MARCA, 		  PED_TIPO_POSIC PTP 	WHERE PERI.OID_PERI = MFC.PERD_OID_PERI 		  AND OFE.MFCA_OID_CABE = MFC.OID_CABE 		  AND MF.MFCA_OID_CABE = MFC.OID_CABE 		  AND OFE.OID_OFER = OFEDET.OFER_OID_OFER  	 		  AND OFEDET.OID_DETA_OFER = MF.OFDE_OID_DETA_OFER 		  AND OFEDET.PROD_OID_PROD = PROD.OID_PROD 		  AND OFEDET.OCAT_OID_CATAL = CAT.OID_CATA 		  AND I18PROD.VAL_OID(+) = OFEDET.PROD_OID_PROD  	      AND I18ACC.VAL_OID(+) = TIPO_SOLIC.ACCE_OID_ACCE  	      AND I18PAIS.VAL_OID(+) = PERI.PAIS_OID_PAIS  	      AND I18CANAL.VAL_OID(+) = PERI.CANA_OID_CANA  		  AND OFEDET.OID_DETA_OFER = SOLIC_POSIC.OFDE_OID_DETA_OFER(+) 		  AND SOLIC_POSIC.SOCA_OID_SOLI_CABE = SOLIC_CABEC.OID_SOLI_CABE 		  AND SOLIC_CABEC.TSPA_OID_TIPO_SOLI_PAIS = TIPO_SOLIC_PAIS.OID_TIPO_SOLI_PAIS   		  AND TIPO_SOLIC_PAIS.TSOL_OID_TIPO_SOLI = TIPO_SOLIC.OID_TIPO_SOLI 		  AND PERI.MARC_OID_MARC = MARCA.OID_MARC 		  AND PTP.OID_TIPO_POSI = SOLIC_POSIC.TPOS_OID_TIPO_POSI 		  AND PERI.PAIS_OID_PAIS =  1 		 		 		  AND PERI.MARC_OID_MARC =  1 		 		 		  AND PERI.CANA_OID_CANA =  1 		 		 		  AND PERI.OID_PERI =  54    AND TIPO_SOLIC.ACCE_OID_ACCE =  1  					  AND OFEDET.VAL_CODI_VENT  > =  '1'  				       AND OFEDET.VAL_CODI_VENT  < =  '1'   	AND PROD.COD_SAP  > = '1' 		    	 AND PROD.COD_SAP  < =  '1' 		   		    AND I18PROD.VAL_I18N LIKE  '1'  	   AND OFEDET.NUM_PAGI_CATA >=  1   		  AND OFEDET.NUM_PAGI_CATA  < =  1   	  AND OFEDET.IMP_PREC_CATA  >   '1'  	   AND CAT.OID_CATA =  1   	  			 	  AND TIPO_SOLIC.OID_TIPO_SOLI =  1   	  AND PTP.OID_TIPO_POSI =  1  	   	 	 	GROUP BY I18PAIS.VAL_I18N, 		  MARCA.DES_MARC, 		  I18CANAL.VAL_I18N, 		  I18ACC.VAL_I18N, 		  PERI.VAL_NOMB_PERI, 		  OFEDET.VAL_CODI_VENT,  		 PROD.COD_SAP, 		  I18PROD.VAL_I18N, 	      	  PROD.DES_CORT,  		  CAT.DES_CATA, 		  OFEDET.NUM_PAGI_CATA, 	      OFEDET.IMP_PREC_CATA, 		  OFEDET.NUM_UNID_ESTI, 		  (OFEDET.NUM_UNID_ESTI*OFEDET.IMP_PREC_CATA) ) WHERE 1 = 1    AND UNID_TOTALES  >   1    AND UNID_FALTANTES  >   1  	 ORDER BY PAIS			    /* CRITERIOORDENACION1*/      /* CRITERIOORDENACION2*/      /* CRITERIOORDENACION3*/    	 