SELECT *
FROM
	(
	   SELECT PRO.STRINGVALUE SOCIEDAD_DEFECTO
	   FROM PRINCIPALS PRI,
			PROPERTYVALUES PRO				
	   WHERE PRI.NAME = 'USUARIO1'									  -- PARAMETRO DE USUARIO -- 
			 AND PRO.IDPROPERTY = 48
			 AND PRO.IDPRINCIPAL = PRI.IDPRINCIPAL
	),
	(
	 SELECT GEN_PAIS.VAL_I18N PAIS,
	        VAL_NOMB_PERI PERIODO,
	        DES_REGI REGION,
	 	   SOCI_OID_SOCI,
	        GEN_SOCI.VAL_I18N SOCIEDAD,
	        FEC_FACT,
	 	   SUM(NUM_UNID_DEMA) UNID_DEMANDA,
	 	   SUM(UNID_FALTANTES) UNID_FALTANTES,
	           TRUNC(DECODE(SUM(NUM_UNID_DEMA), 0, 0, SUM(UNID_FALTANTES) / SUM(NUM_UNID_DEMA))*100, 2) PORC_UNID_FALTANTES,
	           COUNT(DISTINCT PED) CANT_PEDIDOS,
	        decode( SUM(UNID_FALTANTES),0,0,COUNT(DISTINCT PED))PEDIDOS_FALTANTES,
	 	   TRUNC(DECODE(COUNT(DISTINCT PED), 0, 0, decode( SUM(UNID_FALTANTES),0,0,COUNT(DISTINCT PED)) / COUNT(DISTINCT PED))*100, 2) PORC_PEDIDOS_FAL
	 FROM
	 (
	 	SELECT SOL_CAB.PAIS_OID_PAIS,
	 		   SOL_CAB.SOCI_OID_SOCI,
	 		   PERI.VAL_NOMB_PERI,
	 		   REG.DES_REGI,
	 		   SOL_CAB.FEC_FACT,
	 		   NVL(SOL_POS.NUM_UNID_DEMA, 0) NUM_UNID_DEMA,
	 		   CASE WHEN(SOL_POS.IND_CTRL_STOC = 1) THEN
	 			   NVL(SOL_POS.NUM_UNID_DEMA, 0) - NVL(SOL_POS.NUM_UNID_COMPR, 0)
	 		   ELSE
	 	   	   	   NVL(SOL_POS.NUM_UNID_POR_ATEN, 0) - NVL(SOL_POS.NUM_UNID_COMPR, 0)
	 		   END AS UNID_FALTANTES,
	 		   SOL_CAB.OID_SOLI_CABE PED			   	   
	 	FROM PED_SOLIC_CABEC SOL_CAB,
	 		 CRA_PERIO PERI,
	 		 ZON_REGIO REG,
	 		 ZON_ZONA ZONA,
	 		 PED_SOLIC_POSIC SOL_POS,
	 		 (
	 			 SELECT FEC_INIC
	 			 FROM CRA_PERIO
	 			 WHERE OID_PERI = 57	 								-- PARAMETRO DE PERIDO DE INICIO --
	 		 ) PER_INI,
	 		 (
	 		 SELECT FEC_FINA
	 		 FROM CRA_PERIO
	 		 WHERE OID_PERI = DECODE(-1,		-- PARAMETRO DE PERIDO DE FIN --
	 		 	   			  		 -1, 		--evaluar default--
	 								 57, 		-- PARAMETRO DE PERIDO DE INICIO --
	 								 58)		-- PARAMETRO DE PERIDO DE FIN --
	 		 ) PER_FIN
	 	WHERE PERI.FEC_INIC >= PER_INI.FEC_INIC
	 		  AND PERI.FEC_FINA <= PER_FIN.FEC_FINA
	 		  AND SOL_CAB.ZZON_OID_ZONA = ZONA.OID_ZONA
	 		  AND SOL_CAB.OID_SOLI_CABE = SOL_POS.SOCA_OID_SOLI_CABE
	 		  AND SOL_CAB.PERD_OID_PERI = PERI.OID_PERI
	 		  AND REG.OID_REGI = ZONA.ZORG_OID_REGI
	 --			  AND SOL_POS.IND_RECU_OBLI = 1
	 		  AND PERI.CANA_OID_CANA IN (1) 						    -- PARAMETRO DE CANAL --
	 		  AND PERI.MARC_OID_MARC IN (1)							   	-- PARAMETRO DE MARCA --
	 		  AND SOL_CAB.PAIS_OID_PAIS = 1 							-- PARAMETRO DE PAIS --
	 		  AND ZONA.ZORG_OID_REGI IN (1)								-- PARAMETRO DE REGION --
	 ) DATOS,
	 (
	 	SELECT GEN.VAL_OID, GEN.VAL_I18N
	 	FROM V_GEN_I18N_SICC GEN
	 	WHERE GEN.ATTR_ENTI = 'SEG_PAIS'
	 		  AND GEN.IDIO_OID_IDIO = 1  	 									  -- PARAMETRO DE IDIOMA --
	 ) GEN_PAIS,
	 (
	 	SELECT GEN.VAL_OID, GEN.VAL_I18N
	 	FROM V_GEN_I18N_SICC GEN
	 	WHERE GEN.ATTR_ENTI = 'SEG_SOCIE'
	 		  AND GEN.IDIO_OID_IDIO = 1  	 									  -- PARAMETRO DE IDIOMA --
	 ) GEN_SOCI
	 WHERE DATOS.PAIS_OID_PAIS = GEN_PAIS.VAL_OID(+)
	 	  AND DATOS.SOCI_OID_SOCI = GEN_SOCI.VAL_OID(+)		  	  
	 GROUP BY GEN_PAIS.VAL_I18N,
	 		 VAL_NOMB_PERI,
	 	   	 DES_REGI,
	 		 SOCI_OID_SOCI,
	 	   	 GEN_SOCI.VAL_I18N,
	 		 FEC_FACT
	 ORDER BY PAIS,
	 	  	 PERIODO,
	 		 REGION	  
	)
	   