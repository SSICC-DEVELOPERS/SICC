

SELECT  PC.COD_PERI||' - '||
	PERI.VAL_NOMB_PERI VAL_NOMB_PERI, I18PAIS.VAL_I18N AS PAIS, MARCA.DES_MARC, I18CANAL.VAL_I18N AS CANAL, 
	CIVI.COD_CICL_VIDA,	TOFE.COD_TIPO_OFER, 
	PRODU.COD_SAP,  
	OFDET.VAL_CODI_VENT,
	I18PRODU.VAL_I18N AS DESC_PROD,
	I18CLIEN.VAL_I18N AS DESC_TIPO_CLIEN,
	BPS.VAL_CRIT, BPS.VAL_BASE_DEST, BPS.VAL_FACT_CORR, BPS.VAL_PROM, BPS.NUM_UNID, BPS.VAL_OBSE, BPS.VAL_PREC_STND				   
FROM
	CRA_PERIO PERI,
	MAV_BPS_INTER BPS,
	MAV_DETAL_MAV DETAL_MAV,
	PRE_MATRI_FACTU MF,
	PRE_OFERT_DETAL OFDET,
	PRE_CICLO_VIDA CIVI,
	PRE_TIPO_OFERT TOFE,
	MAE_PRODU PRODU,
	SEG_MARCA MARCA,
	SEG_PERIO_CORPO PC,
	(
	 SELECT V.VAL_OID, V.VAL_I18N 
	  FROM V_GEN_I18N_SICC V 
	   WHERE V.ATTR_ENTI = 'SEG_PAIS' 
	    AND V.IDIO_OID_IDIO = 1		 	 		 -- PARAMETRO --
	) I18PAIS,
	(
	 SELECT V.VAL_OID, V.VAL_I18N 
	  FROM V_GEN_I18N_SICC V 
	   WHERE V.ATTR_ENTI = 'SEG_CANAL' 
	    AND V.IDIO_OID_IDIO = 1		 	 		 -- PARAMETRO --
	) I18CANAL,
	(
	 SELECT V.VAL_OID, V.VAL_I18N 
	  FROM V_GEN_I18N_SICC V 
	   WHERE V.ATTR_ENTI = 'MAE_PRODU' 
	    AND V.IDIO_OID_IDIO = 1		 	 		 -- PARAMETRO --
	) I18PRODU,
	(
	 SELECT V.VAL_OID, V.VAL_I18N 
	  FROM V_GEN_I18N_SICC V 
	   WHERE V.ATTR_ENTI = 'MAE_TIPO_CLIEN' 
	    AND V.IDIO_OID_IDIO = 1		 	 		 -- PARAMETRO --
	) I18CLIEN
WHERE
		MARCA.OID_MARC = PERI.MARC_OID_MARC
	AND BPS.PERD_OID_PERI = PERI.OID_PERI
	AND	BPS.CIVI_OID_CICL_VIDA = CIVI.OID_CICL_VIDA
	AND BPS.TOFE_OID_TIPO_OFER = TOFE.OID_TIPO_OFER
	AND BPS.PROD_OID_PROD = PRODU.OID_PROD
	AND DETAL_MAV.PERD_OID_PERI = BPS.PERD_OID_PERI
	AND DETAL_MAV.TICL_OID_TIPO_CLIE = BPS.TICL_OID_TIPO_CLIE
	AND DETAL_MAV.CIVI_OID_CICL_VIDA = BPS.CIVI_OID_CICL_VIDA
	AND DETAL_MAV.PROD_OID_PROD = BPS.PROD_OID_PROD
	AND DETAL_MAV.VAL_PREC_STND = BPS.VAL_PREC_STND
	AND DETAL_MAV.MAFA_OID_MATR_FACT = MF.OID_MATR_FACT
	AND MF.OFDE_OID_DETA_OFER = OFDET.OID_DETA_OFER
	AND OFDET.PROD_OID_PROD = BPS.PROD_OID_PROD
-----------------------------------------------------------------------------------
	AND I18PAIS.VAL_OID (+)= PERI.PAIS_OID_PAIS
	AND I18CANAL.VAL_OID (+)= PERI.CANA_OID_CANA
	AND I18PRODU.VAL_OID (+)= BPS.PROD_OID_PROD
	AND I18CLIEN.VAL_OID (+)= BPS.TICL_OID_TIPO_CLIE
-----------------------------------------------------------------------------------
    AND PC.OID_PERI = PERI.PERI_OID_PERI																				   																				   
	AND PERI.PAIS_OID_PAIS = 1	   			   						-- PARAMETRO --
	AND PERI.MARC_OID_MARC = 1	   			   						-- PARAMETRO --
	AND PERI.CANA_OID_CANA = 1	   			   						-- PARAMETRO --
--	AND PERI.OID_PERI = 58 	 	   			   						-- PARAMETRO --
--	AND BPS.CIVI_OID_CICL_VIDA IN (2)  			   					-- PARAMETRO --		
--	AND BPS.TOFE_OID_TIPO_OFER IN (25)  			   				-- PARAMETRO --
	AND PRODU.COD_SAP >= '200007725-P019' 	  						-- PARAMETRO --
	AND PRODU.COD_SAP <= '200007726-P019'							-- PARAMETRO --
	AND BPS.TICL_OID_TIPO_CLIE IN (1,2,3,4,5)						-- PARAMETRO --
	AND BPS.NUM_UNID >= 1 -- El "operador" viene como parametro 	-- PARAMETRO --*/
ORDER BY
	VAL_NOMB_PERI, 
	I18PAIS.VAL_I18N, 
	MARCA.DES_MARC, 
	I18CANAL.VAL_I18N,
	CIVI.COD_CICL_VIDA,   
	TOFE.COD_TIPO_OFER, 
	PRODU.COD_SAP,
	OFDET.VAL_CODI_VENT
