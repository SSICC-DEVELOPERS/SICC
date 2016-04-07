SELECT COD_PRODUC, 	   DES_PROD, 	   BELCENTER, 	   ALMACEN,        FEC_MOVI, 	   NUM_DOCU_REFE, 	   N_MOVIMIENTO, 	   EST_MER,        UN_ENTRADA,        UN_SALIDA,  	   UNID, 	   STOCK_ACT 	    FROM ( SELECT PROD.COD_SAP COD_PRODUC, 	   GEN_PROD.VAL_I18N DES_PROD, 	   BEL_MOV_ALM_CAB.SBAC_OID_SBAC||''||GEN_SUBA.VAL_I18N BELCENTER, 	   GEN_ALMA.VAL_I18N ALMACEN, 	   TO_DATE( '01/01/2001' ,  'dd/MM/yyyy' )-1  FEC_MOVI, 	   0 NUM_DOCU_REFE, 	   0 N_MOVIMIENTO, 	   '-' EST_MER, 	   0 UN_ENTRADA, 	   0 UN_SALIDA, 	   STOCK.VAL_SALD - SUM(DECODE(BEL_TIP_MOV_ALM.COD_OPER_1, '-', (BEL_MOV_ALM_DET.VAL_CANT) * -1, BEL_MOV_ALM_DET.VAL_CANT)) UNID, 	   0 STOCK_ACT FROM MAE_PRODU PROD, 	 BEL_TIPO_MOVIM_ALMAC BEL_TIP_MOV_ALM, 	 BEL_MOVIM_ALMAC_CABEC BEL_MOV_ALM_CAB, 	 BEL_MOVIM_ALMAC_DETAL BEL_MOV_ALM_DET, 	 BEL_ALMAC ALMACEN, 	 BEL_STOCK STOCK, 	 ( 	 SELECT GEN.VAL_OID, GEN.VAL_I18N 	 FROM V_GEN_I18N_SICC GEN 	 WHERE GEN.ATTR_ENTI = 'SEG_SUBAC' 	 	   AND GEN.IDIO_OID_IDIO =  1  	 ) GEN_SUBA, 	 ( 	 SELECT GEN.VAL_OID, GEN.VAL_I18N 	 FROM V_GEN_I18N_SICC GEN 	 WHERE GEN.ATTR_ENTI = 'BEL_ALMAC' 	 	   AND GEN.IDIO_OID_IDIO =  1  	 ) GEN_ALMA, 	 ( 	 SELECT GEN.VAL_OID, GEN.VAL_I18N 	 FROM V_GEN_I18N_SICC GEN 	 WHERE GEN.ATTR_ENTI = 'MAE_PRODU' 		  AND GEN.IDIO_OID_IDIO =  1  	) GEN_PROD WHERE BEL_TIP_MOV_ALM.PAIS_OID_PAIS = PROD.PAIS_OID_PAIS 	  AND BEL_MOV_ALM_DET.TMAL_OID_TIPO_MOVI_ALMA = BEL_TIP_MOV_ALM.OID_TIPO_MOVI_ALMA 	  AND BEL_MOV_ALM_DET.PROD_OID_PROD = PROD.OID_PROD 	  AND BEL_MOV_ALM_DET.MVAL_OID_MOVI_ALMA = BEL_MOV_ALM_CAB.OID_MOVI_ALMA 	  AND BEL_MOV_ALM_CAB.ALMC_OID_ALMA_1 = ALMACEN.OID_ALMA 	  AND BEL_MOV_ALM_DET.ALMC_OID_ALMA_ENTR = ALMACEN.OID_ALMA 	  AND STOCK.PROD_OID_PROD = PROD.OID_PROD 	  AND STOCK.ALMC_OID_ALMA = ALMACEN.OID_ALMA 	  AND PROD.OID_PROD = GEN_PROD.VAL_OID(+) 	  AND ALMACEN.OID_ALMA = GEN_ALMA.VAL_OID(+) 	  AND BEL_MOV_ALM_CAB.SBAC_OID_SBAC = GEN_SUBA.VAL_OID(+) 	  AND TO_DATE(BEL_MOV_ALM_CAB.FEC_MOVI) >= TO_DATE( '01/01/2001' ,  'dd/MM/yyyy' )  	  AND TO_DATE(BEL_MOV_ALM_CAB.FEC_MOVI)  < = TO_DATE( '09/12/2050' , 'dd/MM/yyyy' )  	  AND PROD.COD_SAP =  '200007727'  	  AND ALMACEN.OID_ALMA IN ( 1055 )			  			   		   	  AND PROD.PAIS_OID_PAIS =  1  	  AND BEL_TIP_MOV_ALM.ESME_OID_ESTA_MERC_1 =  1  GROUP BY PROD.COD_SAP, 	  BEL_MOV_ALM_CAB.SBAC_OID_SBAC||''||GEN_SUBA.VAL_I18N, 	   GEN_PROD.VAL_I18N, 	   GEN_ALMA.VAL_I18N, 	   TO_DATE( '01/01/2001' ,  'dd/MM/yyyy' )-1,    	   BEL_TIP_MOV_ALM.ESME_OID_ESTA_MERC_1,	   	    	   STOCK.VAL_SALD	    ) UNION ALL  ( SELECT PROD.COD_SAP COD_PRODUC, 	   GEN_PROD.VAL_I18N DES_PROD,        BEL_MOV_ALM_CAB.SBAC_OID_SBAC||''||GEN_SUBA.VAL_I18N BELCENTER, 	   GEN_ALMA.VAL_I18N ALMACEN, 	   BEL_MOV_ALM_CAB.FEC_MOVI FEC_MOVI, 	   BEL_MOV_ALM_DET.NUM_DOCU_REFE, 	   BEL_MOV_ALM_DET.N_MOVIMIENTO, 	   GEN_EST_MER.VAL_I18N EST_MER, 	   DECODE(BEL_TIP_MOV_ALM.COD_OPER_1, '+', BEL_MOV_ALM_DET.VAL_CANT, 0) UN_ENTRADA, 	   DECODE(BEL_TIP_MOV_ALM.COD_OPER_1, '-', BEL_MOV_ALM_DET.VAL_CANT, 0) UN_SALIDA,  	   DECODE(BEL_TIP_MOV_ALM.COD_OPER_1, '-', (BEL_MOV_ALM_DET.VAL_CANT) * -1, BEL_MOV_ALM_DET.VAL_CANT) unid, 	   STOCK.VAL_SALD STOCK_ACT FROM MAE_PRODU PROD, 	 BEL_TIPO_MOVIM_ALMAC BEL_TIP_MOV_ALM, 	 BEL_MOVIM_ALMAC_CABEC BEL_MOV_ALM_CAB, 	 BEL_MOVIM_ALMAC_DETAL BEL_MOV_ALM_DET, 	 BEL_ALMAC ALMACEN, 	 BEL_STOCK STOCK, 	 BEL_ESTAD_MERCA EST_MER, 	 ( 	 SELECT GEN.VAL_OID, GEN.VAL_I18N 	 FROM V_GEN_I18N_SICC GEN 	 WHERE GEN.ATTR_ENTI = 'SEG_SUBAC' 	 	   AND GEN.IDIO_OID_IDIO =  1  	 ) GEN_SUBA, 	 ( 	 SELECT GEN.VAL_OID, GEN.VAL_I18N 	 FROM V_GEN_I18N_SICC GEN 	 WHERE GEN.ATTR_ENTI = 'BEL_ALMAC' 	 	   AND GEN.IDIO_OID_IDIO =  1  	 ) GEN_ALMA, 	 ( 	 SELECT GEN.VAL_OID, GEN.VAL_I18N 	 FROM V_GEN_I18N_SICC GEN 	 WHERE GEN.ATTR_ENTI = 'MAE_PRODU' 		  AND GEN.IDIO_OID_IDIO =  1  	) GEN_PROD, 	( 	SELECT GEN.VAL_OID, GEN.VAL_I18N 	FROM V_GEN_I18N_SICC GEN 	WHERE GEN.ATTR_ENTI = 'BEL_ESTAD_MERCA' 		  AND GEN.IDIO_OID_IDIO =  1  	) GEN_EST_MER WHERE BEL_TIP_MOV_ALM.PAIS_OID_PAIS = PROD.PAIS_OID_PAIS 	  AND BEL_MOV_ALM_DET.TMAL_OID_TIPO_MOVI_ALMA = BEL_TIP_MOV_ALM.OID_TIPO_MOVI_ALMA 	  AND BEL_MOV_ALM_DET.PROD_OID_PROD = PROD.OID_PROD 	  AND BEL_MOV_ALM_DET.MVAL_OID_MOVI_ALMA = BEL_MOV_ALM_CAB.OID_MOVI_ALMA 	  AND BEL_MOV_ALM_CAB.ALMC_OID_ALMA_1 = ALMACEN.OID_ALMA 	  AND BEL_MOV_ALM_DET.ALMC_OID_ALMA_ENTR = ALMACEN.OID_ALMA 	  AND STOCK.PROD_OID_PROD = PROD.OID_PROD 	  AND STOCK.ALMC_OID_ALMA = ALMACEN.OID_ALMA 	  AND PROD.OID_PROD = GEN_PROD.VAL_OID(+) 	  AND ALMACEN.OID_ALMA = GEN_ALMA.VAL_OID(+) 	  AND BEL_TIP_MOV_ALM.ESME_OID_ESTA_MERC_1 = EST_MER.OID_ESTA_MERC 	  AND EST_MER.OID_ESTA_MERC = GEN_EST_MER.VAL_OID(+)   	  AND BEL_MOV_ALM_CAB.SBAC_OID_SBAC = GEN_SUBA.VAL_OID(+) 	  AND TO_DATE(BEL_MOV_ALM_CAB.FEC_MOVI) >= TO_DATE( '01/01/2001' ,  'dd/MM/yyyy' )  	  AND TO_DATE(BEL_MOV_ALM_CAB.FEC_MOVI)  < = TO_DATE( '09/12/2050' , 'dd/MM/yyyy' )  	  AND PROD.COD_SAP =  '200007727'  	  AND ALMACEN.OID_ALMA IN ( 1055 )			  			   		   	  AND PROD.PAIS_OID_PAIS =  1  	  AND BEL_TIP_MOV_ALM.ESME_OID_ESTA_MERC_1 =  1  ) ORDER BY COD_PRODUC, 	   ALMACEN,	    	   EST_MER, 	   FEC_MOVI 