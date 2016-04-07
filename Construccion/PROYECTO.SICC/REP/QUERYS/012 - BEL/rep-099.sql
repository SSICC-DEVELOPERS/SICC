SELECT COD_SUBACCESO,
	   DESC_SUBACCESO,
	   ALMACEN,
	   DES_MARC_PROD,
	   DESC_UNI_NEG,
	   DESC_NEG,
	   SUP_GEN,
	   GENER,
	   COD_PROD,
	   DESC_PROD,
	   STOCK_1,
	   STOCK_2,
	   STOCK_3,
	   (STOCK_1 + STOCK_2 + STOCK_3) TOTAL,
	   STOCK_4,
	   '' AS OBSERVACION
FROM
	(
	SELECT SUBA.COD_SBAC COD_SUBACCESO,
		   GEN_SUBA.VAL_I18N DESC_SUBACCESO,
		   MARC_PRO.DES_MARC_PROD,
		   GEN_UNI_NEG.VAL_I18N DESC_UNI_NEG,
		   GEN_NEGOC.VAL_I18N DESC_NEG,
		   GEN_SUP_GENER.VAL_I18N SUP_GEN,
		   GEN_GENER.VAL_I18N GENER,
		   GEN_ALMACEN.VAL_I18N ALMACEN,
		   PROD.COD_SAP COD_PROD,
		   GEN_PROD.VAL_I18N DESC_PROD,
		   SUM(
		   NVL((
		   SELECT STOCK.VAL_SALD
		   FROM BEL_ESTAD_MERCA EST_MER
		   WHERE EST_MER.OID_ESTA_MERC = 1	 				-- PARAMETRO DE ESTADO DE MERCANCIA VENTA --
		   		AND STOCK.ESME_OID_ESTA_MERC = EST_MER.OID_ESTA_MERC
		   ), 0)) STOCK_1,
	       SUM(NVL((
		   SELECT STOCK.VAL_SALD
		   FROM BEL_ESTAD_MERCA EST_MER
		   WHERE EST_MER.OID_ESTA_MERC = 8	 				-- PARAMETRO DE ESTADO DE MERCANCIA TESTER --
		   		AND STOCK.ESME_OID_ESTA_MERC = EST_MER.OID_ESTA_MERC
		   ), 0)) STOCK_2,
		   SUM(NVL((
		   SELECT STOCK.VAL_SALD
		   FROM BEL_ESTAD_MERCA EST_MER
		   WHERE EST_MER.OID_ESTA_MERC = 12	 				-- PARAMETRO DE ESTADO DE MERCANCIA DEVOLUCION --
		   		AND STOCK.ESME_OID_ESTA_MERC = EST_MER.OID_ESTA_MERC
		   ), 0)) STOCK_3,
		   SUM(NVL((
		   SELECT STOCK.VAL_SALD
		   FROM BEL_ESTAD_MERCA EST_MER
		   WHERE EST_MER.OID_ESTA_MERC = 10	 				-- PARAMETRO DE ESTADO DE MERCANCIA TRANSITO --
		   		AND STOCK.ESME_OID_ESTA_MERC = EST_MER.OID_ESTA_MERC
		   ), 0)) STOCK_4	   	      
	FROM MAE_PRODU PROD,
		 MAE_NEGOC NEG,
		 MAE_UNIDA_NEGOC UNI_NEG,
		 MAE_GENER GENER,
		 MAE_SUPER_GENER SUP_GENER,
		 SEG_MARCA_PRODU  MARC_PRO,
		 BEL_STOCK STOCK,
		 BEL_ALMAC ALMA,
		 BEL_CONTR_ALMAC CON_ALM,
		 SEG_SUBAC SUBA,
		 (
		 SELECT GEN.VAL_OID, GEN.VAL_I18N
		 FROM V_GEN_I18N_SICC GEN
		 WHERE GEN.ATTR_ENTI= 'SEG_SUBAC'
		 	   AND GEN.IDIO_OID_IDIO = 1 	   							 -- PARAMETRO DE IDIOMA --
		 )GEN_SUBA,
		 (
		 SELECT GEN.VAL_OID, GEN.VAL_I18N
		 FROM V_GEN_I18N_SICC GEN
		 WHERE GEN.ATTR_ENTI = 'MAE_PRODU'
		 	   AND GEN.IDIO_OID_IDIO = 1  					-- PARAMETRO DE IDIOMA --
		 ) GEN_PROD,
	 	 (
		 SELECT GEN.VAL_OID, GEN.VAL_I18N
		 FROM V_GEN_I18N_SICC GEN
		 WHERE GEN.ATTR_ENTI = 'MAE_NEGOC'
		 	   AND GEN.IDIO_OID_IDIO = 1  					-- PARAMETRO DE IDIOMA --
		 ) GEN_NEGOC,
	 	 (
		 SELECT GEN.VAL_OID, GEN.VAL_I18N
		 FROM V_GEN_I18N_SICC GEN
		 WHERE GEN.ATTR_ENTI = 'MAE_UNIDA_NEGOC'
		 	   AND GEN.IDIO_OID_IDIO = 1  					-- PARAMETRO DE IDIOMA --
		 ) GEN_UNI_NEG,
	 	 (
		 SELECT GEN.VAL_OID, GEN.VAL_I18N
		 FROM V_GEN_I18N_SICC GEN
		 WHERE GEN.ATTR_ENTI = 'MAE_GENER'
		 	   AND GEN.IDIO_OID_IDIO = 1  					-- PARAMETRO DE IDIOMA --
		 ) GEN_GENER,
		 (
		 SELECT GEN.VAL_OID, GEN.VAL_I18N
		 FROM V_GEN_I18N_SICC GEN
		 WHERE GEN.ATTR_ENTI = 'MAE_SUPER_GENER'
		 	   AND GEN.IDIO_OID_IDIO = 1  					-- PARAMETRO DE IDIOMA --
		 ) GEN_SUP_GENER,
		 (
		 SELECT GEN.VAL_OID, GEN.VAL_I18N
		 FROM V_GEN_I18N_SICC GEN
		 WHERE GEN.ATTR_ENTI = 'BEL_ALMAC'
		 	   AND GEN.IDIO_OID_IDIO = 1  					-- PARAMETRO DE IDIOMA --
		 ) GEN_ALMACEN
	WHERE PROD.NEGO_OID_NEGO = NEG.OID_NEGO(+)
		  AND PROD.UNEG_OID_UNID_NEGO = UNI_NEG.OID_UNID_NEGO(+)	  
		  AND PROD.GENE_OID_GENE = GENER.OID_GENE(+)
		  AND PROD.SGEN_OID_SUPE_GENE = SUP_GENER.OID_SUPE_GENE(+)
		  AND PROD.MAPR_OID_MARC_PROD = MARC_PRO.OID_MARC_PROD(+)
		  AND STOCK.PROD_OID_PROD = PROD.OID_PROD
		  AND ALMA.PAIS_OID_PAIS = PROD.PAIS_OID_PAIS
		  AND ALMA.OID_ALMA = STOCK.ALMC_OID_ALMA
		  AND PROD.OID_PROD = CON_ALM.PROD_OID_PROD
		  AND CON_ALM.SBAC_OID_SBAC = SUBA.OID_SBAC
		  AND SUBA.OID_SBAC = GEN_SUBA.VAL_OID(+)   
		  AND PROD.OID_PROD = GEN_PROD.VAL_OID(+)
		  AND NEG.OID_NEGO = GEN_NEGOC.VAL_OID(+)
		  AND UNI_NEG.OID_UNID_NEGO = GEN_UNI_NEG.VAL_OID(+)
		  AND GENER.OID_GENE = GEN_GENER.VAL_OID(+)
		  AND SUP_GENER.OID_SUPE_GENE = GEN_SUP_GENER.VAL_OID(+)
		  AND ALMA.OID_ALMA = GEN_ALMACEN.VAL_OID(+)
	--	  AND PROD.PAIS_OID_PAIS = 1    					-- PARAMETRO DE PAIS --
	--	  AND ALMA.OID_ALMA = 1	   							-- PARAMETRO DE ALMACEN --
	--	  AND MARC_PRO.OID_MARC_PROD IN (1)	    			-- PARAMETRO DE MARCA DE PRODUCTO --
	--	  AND UNI_NEG.OID_UNID_NEGO IN (1)			    	-- PARAMETRO DE UNIDAD DE NEGOCIO --
	--	  AND NEG.OID_NEGO IN (1)					    	-- PARAMETRO DE NEGOCIO --
	--	  AND GENER.OID_GENE IN (1) 			     		-- PARAMETRO DE GENERICO --
	-- 	  AND SUP_GENER.OID_SUPE_GENE IN (1)				-- PARAMETRO DE SUPERGENERICO --
	--	  AND PROD.COD_SAP = 'CODPROD1-N023' 				-- PARAMETRO PRODUCTO --
	GROUP BY SUBA.COD_SBAC,
		   GEN_SUBA.VAL_I18N,
		   MARC_PRO.DES_MARC_PROD,
		   GEN_UNI_NEG.VAL_I18N,
		   GEN_NEGOC.VAL_I18N,
		   GEN_SUP_GENER.VAL_I18N,
		   GEN_GENER.VAL_I18N,
		   GEN_ALMACEN.VAL_I18N,
		   PROD.COD_SAP,
		   GEN_PROD.VAL_I18N
	)
ORDER BY COD_SUBACCESO,
	   DESC_SUBACCESO,
	   ALMACEN,
	   DES_MARC_PROD,
	   DESC_UNI_NEG,
	   DESC_NEG,
	   SUP_GEN,
	   GENER,
	   COD_PROD,
	   DESC_PROD