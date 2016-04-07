
SELECT *
FROM
	(
	 	SELECT PRO.STRINGVALUE SOCIEDAD_DEFECTO
		FROM PRINCIPALS PRI,
			PROPERTYVALUES PRO			
		WHERE PRI.NAME = 'USUARIO1'			   	  	 -- PARAMETRO DE USUARIO POR DEFECTO --
			 AND PRO.IDPROPERTY = 48
			 AND PRO.IDPRINCIPAL = PRI.IDPRINCIPAL
	),
	(
	SELECT ANIO.VAL_ANIO||''||TO_CHAR(CLI.FEC_INGR, 'MM') MES,
		   REG.DES_REGI REGION,
		   ZONA.DES_ZONA ZONA,
		   SEC.COD_SECC SECCION,
		   TER.COD_TERR TERRITORIO,
		   SUBSTR(CLI.VAL_APE1||' '||CLI.VAL_APE2||' '||CLI.VAL_NOM1||' '||CLI.VAL_NOM2, 0, 40) NOMBRE,
		   (
		   SELECT CLI_COM.VAL_TEXT_COMU
		   FROM MAE_CLIEN_COMUN CLI_COM,
		   		MAE_TIPO_COMUN TIP_COM
		   WHERE CLI_COM.CLIE_OID_CLIE = CLI.OID_CLIE
		   		 AND CLI_COM.TICM_OID_TIPO_COMU = TIP_COM.OID_TIPO_COMU
		  		 AND TIP_COM.COD_TIPO_COMU = 'TF'
	 	   ) TEL1,
		   (
		   SELECT PERI.VAL_NOMB_PERI
		   FROM MAE_CLIEN_HISTO_ESTAT EST,
		   		CRA_PERIO PERI
		   WHERE EST.CLIE_OID_CLIE = CLI.OID_CLIE
		   		 AND EST.ESTA_OID_ESTA_CLIE = 2
				 AND PERI.OID_PERI = EST.PERD_OID_PERI 
		   ) CAMP_INGRESO,
		   CLI.FEC_INGR ANIO_INGRESO,
		   ANIO.VAL_ANIO - TO_CHAR(CLI.FEC_INGR, 'YYYY') N_ANIOS_EN_BELCORP,
		   (
		   SELECT NIVEL.VAL_DESC
		   FROM DTR_SEGME_CLIEN SEG,
		   		DTR_NIVEL_SEGME NIVEL
		   WHERE SEG.CLIE_OID_CLIE = CLI.OID_CLIE
		   		 AND SEG.ZORG_OID_REGI = REG.OID_REGI
				 AND SEG.ZZON_OID_ZONA = ZONA.OID_ZONA
				 AND SEG.PERD_OID_PERI = 91			   				   	-- PARAMETRO DE PERIODO HASTA --
				 AND SEG.NVSG_OID_NIVE_SEGM = NIVEL.OID_NIVE_SEGM 
		   ) SEGMENTO,
	   	   (
		   SELECT VAL_TEXT
		   FROM MAE_CLIEN_OBSER CLI_OBS
		   WHERE CLI_OBS.CLIE_OID_CLIE = CLI.OID_CLIE
		   		 AND CLI_OBS.MARC_OID_MARC = PERI.MARC_OID_MARC
		   ) OBSERVACIONES,
		   1 AS CANTIDAD	   	   
	FROM CRA_PERIO PERI,
		 MAE_CLIEN_UNIDA_ADMIN CLI_UNI,
		 MAE_CLIEN CLI,
		 ZON_ZONA ZONA,
		 ZON_REGIO REG,
		 ZON_SECCI SEC,
		 ZON_TERRI_ADMIN TER_ADM,
		 ZON_TERRI TER,
		 (	 	  
			SELECT DISTINCT PER_COR.VAL_ANIO,
				   FI.FEC_INIC,
				   FF.FEC_FINA
			FROM CRA_PERIO PERI,
				 SEG_PERIO_CORPO PER_COR,
				 (
				 SELECT FEC_INIC
				 FROM CRA_PERIO
				 WHERE OID_PERI = 55					-- PARAMETRO DE PERIODO DESDE --
				 ) FI,
				 (
				 SELECT FEC_FINA
				 FROM CRA_PERIO
				 WHERE OID_PERI = 91 					-- PARAMETRO DE PERIODO HASTA --
				 ) FF
			WHERE FI.FEC_INIC <= PERI.FEC_INIC
				  AND FF.FEC_FINA >=PERI.FEC_FINA
				  AND PERI.PERI_OID_PERI = PER_COR.OID_PERI
				  AND PERI.PAIS_OID_PAIS = 1	  		-- PARAMETRO DE PAIS --
				  AND PERI.CANA_OID_CANA = 1			-- PARAMETRO DE CANAL --
				  AND PERI.MARC_OID_MARC = 1			-- PARAMETRO DE MARCA --
		 ) ANIO
	WHERE PERI.OID_PERI = CLI_UNI.PERD_OID_PERI_INI
		  AND CLI_UNI.CLIE_OID_CLIE = CLI.OID_CLIE
		  AND ANIO.FEC_INIC <= TO_DATE(TO_CHAR(CLI.FEC_INGR, 'DD/MM')||'/'||ANIO.VAL_ANIO, 'DD/MM/YYYY')
		  AND ANIO.FEC_FINA >= TO_DATE(TO_CHAR(CLI.FEC_INGR, 'DD/MM')||'/'||ANIO.VAL_ANIO, 'DD/MM/YYYY') 
		  AND TO_CHAR(CLI.FEC_INGR, 'MM') = '01' 	   	 	-- PARAMETRO DE MES--
		  AND CLI_UNI.IND_ACTI = 1
		  AND CLI_UNI.ZTAD_OID_TERR_ADMI = TER_ADM.OID_TERR_ADMI
		  AND TER_ADM.ZSCC_OID_SECC = SEC.OID_SECC
		  AND TER.OID_TERR = TER_ADM.TERR_OID_TERR
		  AND SEC.ZZON_OID_ZONA = ZONA.OID_ZONA
		  AND REG.OID_REGI = ZONA.ZORG_OID_REGI
    	  AND ZONA.OID_ZONA = 1			  		-- PARAMETRO DE REGION --
    	  AND REG.OID_REGI = 7 			  		-- PARAMETRO DE ZONA --
		  AND PERI.PAIS_OID_PAIS = 1	  		-- PARAMETRO DE PAIS --
		  AND PERI.CANA_OID_CANA = 1			-- PARAMETRO DE CANAL --
		  AND PERI.MARC_OID_MARC = 1			-- PARAMETRO DE MARCA --
	ORDER BY MES,
		  	 REGION,
		  	 ZONA,
			 CLI.FEC_INGR,
			 CLI.COD_CLIE
)			 
