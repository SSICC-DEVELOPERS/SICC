SELECT CANAL.OID_CANA,
	   GEN_CANAL.VAL_I18N CANAL,
	   ACCE.OID_ACCE,
	   GEN_ACCE.VAL_I18N ACCESO,
	   SUBA.COD_SBAC COD_LOCAL,
	   BEL_REG_ABA_CAB.NUM_SOLI HOJA_DEMAN,
	   TO_DATE(BEL_REG_ABA_CAB.FEC_CONF, 'DD/MM/YYYY') FECHA_CONF,
	   TO_DATE(BEL_REG_ABA_CAB.FEC_INGR, 'DD/MM/YYYY') FECHA_INGR,	   
	   PROD.COD_SAP COD_PRODUC,
	   GEN_PROD.VAL_I18N DES_PRODUC,
	   NVL(BEL_REG_ABA_DEL.NUM_UNID_ENVI,0) SOLICITADAS,
	   NVL(BEL_REG_ABA_DEL.NUM_UNID_CONF,0) CONFIRMADAS,
	   NVL(BEL_REG_ABA_DEL.NUM_UNID_ATEN,0) RECIBIDAS,
	   NVL(BEL_REG_ABA_DEL.NUM_UNID_ENVI - BEL_REG_ABA_DEL.NUM_UNID_CONF,0) CONFIRMADO_VS,
	   NVL(BEL_REG_ABA_DEL.NUM_UNID_CONF - BEL_REG_ABA_DEL.NUM_UNID_ATEN,0) RECIBIDOS	   	   
FROM MAE_PRODU PROD,
	 SEG_ACCES ACCE,
	 SEG_CANAL CANAL,
	 SEG_SUBAC SUBA,
	 BEL_REGIS_ABAST_CABEC BEL_REG_ABA_CAB,
	 BEL_REGIS_ABAST_DETAL BEL_REG_ABA_DEL,
	 BEL_ESTAD_HOJA_DEMAN EST_HOJA_DEM,
	 (
	 SELECT GEN.VAL_OID, GEN.VAL_I18N
	 FROM V_GEN_I18N_SICC GEN
	 WHERE GEN.ATTR_ENTI = 'SEG_CANAL'
	 	   AND GEN.IDIO_OID_IDIO = 1  		-- PARAMETRO DE IDIOMA --
	 ) GEN_CANAL,
	 (
	 SELECT GEN.VAL_OID, GEN.VAL_I18N
	 FROM V_GEN_I18N_SICC GEN
	 WHERE GEN.ATTR_ENTI = 'SEG_ACCES'
	 	   AND GEN.IDIO_OID_IDIO = 1         -- PARAMETRO DE IDIOMA --
	 ) GEN_ACCE,
	 (
	 SELECT GEN.VAL_OID, GEN.VAL_I18N
	 FROM V_GEN_I18N_SICC GEN
	 WHERE GEN.ATTR_ENTI = 'MAE_PRODU'
	 	   AND GEN.IDIO_OID_IDIO = 1  		-- PARAMETRO DE IDIOMA --
	 ) GEN_PROD
WHERE ACCE.CANA_OID_CANA = CANAL.OID_CANA
	  AND SUBA.ACCE_OID_ACCE = ACCE.OID_ACCE
	  AND BEL_REG_ABA_CAB.PAIS_OID_PAIS = PROD.PAIS_OID_PAIS
	  AND BEL_REG_ABA_CAB.SBAC_OID_SBAC = SUBA.OID_SBAC
	  AND BEL_REG_ABA_DEL.RABC_OID_REGI_ABAS_CABE = BEL_REG_ABA_CAB.OID_REGI_ABAS_CABE
	  AND BEL_REG_ABA_CAB.DHDE_OID_ESTA_HOJA_DEMA = EST_HOJA_DEM.OID_ESTA_HOJA_DEMA
	  AND (EST_HOJA_DEM.COD_ESTA_HOJA_DEMA = 'I' 
	  	   OR EST_HOJA_DEM.COD_ESTA_HOJA_DEMA = 'F')  
	  AND (BEL_REG_ABA_DEL.NUM_UNID_ATEN <> BEL_REG_ABA_DEL.NUM_UNID_CONF
	  	   OR BEL_REG_ABA_DEL.NUM_UNID_ENVI <> BEL_REG_ABA_DEL.NUM_UNID_CONF)
	  AND BEL_REG_ABA_DEL.PROD_OID_PROD = PROD.OID_PROD
	  AND CANAL.OID_CANA = GEN_CANAL.VAL_OID(+)
	  AND ACCE.OID_ACCE = GEN_ACCE.VAL_OID(+)
	  AND PROD.OID_PROD = GEN_PROD.VAL_OID(+)
      AND (BEL_REG_ABA_CAB.FEC_INGR >=  TO_DATE('01/01/2000', 'DD/MM/YYYY')          -- PARAMETRO DE FECHA DE INICIO --
	      OR BEL_REG_ABA_CAB.FEC_CONF >= TO_DATE('01/01/2000', 'DD/MM/YYYY'))        -- PARAMETRO DE FECHA DE INICIO --
      AND (BEL_REG_ABA_CAB.FEC_INGR <=  TO_DATE('01/01/2006','DD/MM/YYYY')            -- PARAMETRODE FECHA DE FIN --   '
	  	  OR BEL_REG_ABA_CAB.FEC_CONF <= TO_DATE('01/01/2006', 'DD/MM/YYYY'))		  -- PARAMETRODE FECHA DE FIN --		      	  
--	  AND PROD.PAIS_OID_PAIS = 1  							 -- PARAMETRO DE PAIS --
--	  AND CANAL.OID_CANA = 1   	  							 -- PARAMETRO DE CANAL --
--	  AND ACCE.OID_ACCE = 1									 -- PARAMETRO DE ACCESO --
--	  AND SUBA.OID_SBAC IN (1)								 -- PARAMETRO DE SUBACCESO --
ORDER BY CANAL.OID_CANA,
         ACCE.OID_ACCE,
         SUBA.COD_SBAC,
         BEL_REG_ABA_CAB.NUM_SOLI,
	     BEL_REG_ABA_CAB.FEC_CONF,
         PROD.COD_SAP

	   