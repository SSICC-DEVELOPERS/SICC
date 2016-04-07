SELECT DES_SUBG_VENT,
	   DES_REGI,
	   VARIABLE,
	   COD_ZONA,
	   GERENTE,
	   FEC_ANIO_COME AS ANIO,
	   VALOR
	  
FROM
(
	(		
		SELECT SUBG.DES_SUBG_VENT,
			   REG.DES_REGI,		
			   ZON.COD_ZONA,	
			   CLI.VAL_NOM1||' '||CLI.VAL_NOM2||' '||CLI.VAL_APE1||' '||CLI.VAL_APE2 AS GERENTE,	
			   VTA_PRO.FEC_ANIO_COME,	
		   	SUM(VTA_PRO.NUM_ACTI_FINA)AS VALOR,
			1	AS VARIABLE
		FROM INC_RESUL_VENTA_PROYE_ZONA VTA_PRO,		
			 INC_METAS_VENTA_PROYE_ZONA MET_PRO,	
			 ZON_ZONA ZON,	
			 ZON_REGIO REG,	
			 ZON_SUB_GEREN_VENTA SUBG,
			 MAE_CLIEN CLI,	
			 CRA_PERIO PER,	
			 (	
			  SELECT FEC_INIC	
			  FROM CRA_PERIO
			  WHERE OID_PERI = 1379 --PARAMETRO PERIODO DESDE--
			 )FEC_DESDE,
			 (
			  SELECT FEC_FINA
			  FROM CRA_PERIO
			  WHERE OID_PERI = 71 --PARAMETRO PERIODO HASTA--
			 )FEC_HASTA
		WHERE VTA_PRO.MVPZ_OID_META_VENT_PROY_ZONA = MET_PRO.OID_META_VENT_PROY_ZONA	
			  AND MET_PRO.ZZON_OID_ZONA = ZON.OID_ZONA
			  AND ZON.ZORG_OID_REGI = REG.OID_REGI
			  AND ZON.CLIE_OID_CLIE = CLI.OID_CLIE
/*			  AND ZON.PAIS_OID_PAIS = 1 --PARAMETRO PAIS--
			  AND ZON.MARC_OID_MARC = 1 --PARAMETRO MARCA--
			  AND ZON.CANA_OID_CANA = 1 --PARAMETRO CANAL--
			  AND ZON.OID_ZONA IN (1) --PARAMETRO ZONA--
			  AND REG.OID_REGI IN (7) --PARAMETRO REGION--*/	
			  AND SUBG.OID_SUBG_VENT = REG.ZSGV_OID_SUBG_VENT
			  AND ZON.PAIS_OID_PAIS = PER.PAIS_OID_PAIS
			  AND ZON.MARC_OID_MARC = PER.MARC_OID_MARC
			  AND ZON.CANA_OID_CANA = PER.CANA_OID_CANA
			  AND VTA_PRO.PERD_OID_PERI = PER.OID_PERI	
			  AND FEC_DESDE.FEC_INIC <= PER.FEC_INIC	
			  AND PER.FEC_FINA <= FEC_HASTA.FEC_FINA	
			  AND MET_PRO.COPA_OID_PARA_GRAL = 1 --PARAMETRO CONCURSO--	
		GROUP BY SUBG.DES_SUBG_VENT,
			  	 REG.DES_REGI,		
			   ZON.COD_ZONA,	
			   CLI.VAL_NOM1||' '||CLI.VAL_NOM2||' '||CLI.VAL_APE1||' '||CLI.VAL_APE2,	
		   	   VTA_PRO.FEC_ANIO_COME	
	)		
	UNION		
	(		
		SELECT SUBG.DES_SUBG_VENT,
			   REG.DES_REGI,		
			   ZON.COD_ZONA,	
			   CLI.VAL_NOM1||' '||CLI.VAL_NOM2||' '||CLI.VAL_APE1||' '||CLI.VAL_APE2,	
			   VTA_PRO.FEC_ANIO_COME,	
		   	SUM(VTA_PRO.NUM_ACTI_INIC),
			2	AS VARIABLE
		FROM INC_RESUL_VENTA_PROYE_ZONA VTA_PRO,		
			 INC_METAS_VENTA_PROYE_ZONA MET_PRO,	
			 ZON_ZONA ZON,	
			 ZON_REGIO REG,	
			 ZON_SUB_GEREN_VENTA SUBG,
			 MAE_CLIEN CLI,	
			 CRA_PERIO PER,	
			 (	
			  SELECT FEC_INIC	
			  FROM CRA_PERIO	
			  WHERE OID_PERI = 57 --PARAMETRO PERIODO DESDE--	
			 )FEC_DESDE,	
			 (	
			  SELECT FEC_FINA	
			  FROM CRA_PERIO
			  WHERE OID_PERI = 58 --PARAMETRO PERIODO HASTA--
			 )FEC_HASTA
		WHERE VTA_PRO.MVPZ_OID_META_VENT_PROY_ZONA = MET_PRO.OID_META_VENT_PROY_ZONA	
			  AND MET_PRO.ZZON_OID_ZONA = ZON.OID_ZONA
			  AND ZON.ZORG_OID_REGI = REG.OID_REGI
			  AND ZON.CLIE_OID_CLIE = CLI.OID_CLIE
			  AND ZON.PAIS_OID_PAIS = 1 --PARAMETRO PAIS--
			  AND ZON.MARC_OID_MARC = 1 --PARAMETRO MARCA--
			  AND ZON.CANA_OID_CANA = 1 --PARAMETRO CANAL--
			  AND ZON.OID_ZONA IN (1) --PARAMETRO ZONA--
			  AND REG.OID_REGI IN (7) --PARAMETRO REGION--
  			  AND SUBG.OID_SUBG_VENT = REG.ZSGV_OID_SUBG_VENT
  			  AND ZON.PAIS_OID_PAIS = PER.PAIS_OID_PAIS
			  AND ZON.MARC_OID_MARC = PER.MARC_OID_MARC
			  AND ZON.CANA_OID_CANA = PER.CANA_OID_CANA
			  AND VTA_PRO.PERD_OID_PERI = PER.OID_PERI
			  AND FEC_DESDE.FEC_INIC <= PER.FEC_INIC
			  AND PER.FEC_FINA <= FEC_HASTA.FEC_FINA
			  AND MET_PRO.COPA_OID_PARA_GRAL = 1 --PARAMETRO CONCURSO--
		GROUP BY SUBG.DES_SUBG_VENT, 
			  REG.DES_REGI,		
			   ZON.COD_ZONA,	
			   CLI.VAL_NOM1||' '||CLI.VAL_NOM2||' '||CLI.VAL_APE1||' '||CLI.VAL_APE2,	
		   	   VTA_PRO.FEC_ANIO_COME	
	)		
	UNION		
	(		
		SELECT SUBG.DES_SUBG_VENT,
			   REG.DES_REGI,		
			   ZON.COD_ZONA,	
			   CLI.VAL_NOM1||' '||CLI.VAL_NOM2||' '||CLI.VAL_APE1||' '||CLI.VAL_APE2,	
			   VTA_PRO.FEC_ANIO_COME,	
		   	SUM(VTA_PRO.VAL_ACTI),
			3	AS VARIABLE
		FROM INC_RESUL_VENTA_PROYE_ZONA VTA_PRO,		
			 INC_METAS_VENTA_PROYE_ZONA MET_PRO,	
			 ZON_ZONA ZON,
			 ZON_REGIO REG,
			 ZON_SUB_GEREN_VENTA SUBG,
			 MAE_CLIEN CLI,
			 CRA_PERIO PER,
			 (
			  SELECT FEC_INIC
			  FROM CRA_PERIO
			  WHERE OID_PERI = 57 --PARAMETRO PERIODO DESDE--
			 )FEC_DESDE,
			 (
			  SELECT FEC_FINA
			  FROM CRA_PERIO
			  WHERE OID_PERI = 58 --PARAMETRO PERIODO HASTA--
			 )FEC_HASTA
		WHERE VTA_PRO.MVPZ_OID_META_VENT_PROY_ZONA = MET_PRO.OID_META_VENT_PROY_ZONA	
			  AND MET_PRO.ZZON_OID_ZONA = ZON.OID_ZONA
			  AND ZON.ZORG_OID_REGI = REG.OID_REGI	
			  AND ZON.CLIE_OID_CLIE = CLI.OID_CLIE	
			  AND ZON.PAIS_OID_PAIS = 1 --PARAMETRO PAIS--	
			  AND ZON.MARC_OID_MARC = 1 --PARAMETRO MARCA--	
			  AND ZON.CANA_OID_CANA = 1 --PARAMETRO CANAL--	
			  AND ZON.OID_ZONA IN (1) --PARAMETRO ZONA--	
			  AND REG.OID_REGI IN (7) --PARAMETRO REGION--	
    		  AND ZON.PAIS_OID_PAIS = PER.PAIS_OID_PAIS
			  AND ZON.MARC_OID_MARC = PER.MARC_OID_MARC
			  AND ZON.CANA_OID_CANA = PER.CANA_OID_CANA
			  AND VTA_PRO.PERD_OID_PERI = PER.OID_PERI	
			  AND FEC_DESDE.FEC_INIC <= PER.FEC_INIC	
			  AND PER.FEC_FINA <= FEC_HASTA.FEC_FINA	
			  AND MET_PRO.COPA_OID_PARA_GRAL = 1 --PARAMETRO CONCURSO--	
  			  AND SUBG.OID_SUBG_VENT = REG.ZSGV_OID_SUBG_VENT
		GROUP BY SUBG.DES_SUBG_VENT,
			   REG.DES_REGI,		
			   ZON.COD_ZONA,	
			   CLI.VAL_NOM1||' '||CLI.VAL_NOM2||' '||CLI.VAL_APE1||' '||CLI.VAL_APE2,	
		   	   VTA_PRO.FEC_ANIO_COME	
	)		
	UNION		
	(		
		SELECT SUBG.DES_SUBG_VENT,
			   REG.DES_REGI,		
			   ZON.COD_ZONA,	
			   CLI.VAL_NOM1||' '||CLI.VAL_NOM2||' '||CLI.VAL_APE1||' '||CLI.VAL_APE2,	
			   VTA_PRO.FEC_ANIO_COME,	
		   	SUM(VTA_PRO.VAL_CAPI),
			4	AS VARIABLE
		FROM INC_RESUL_VENTA_PROYE_ZONA VTA_PRO,		
			 INC_METAS_VENTA_PROYE_ZONA MET_PRO,	
			 ZON_ZONA ZON,	
			 ZON_REGIO REG,	
			 ZON_SUB_GEREN_VENTA SUBG,
			 MAE_CLIEN CLI,	
			 CRA_PERIO PER,	
			 (	
			  SELECT FEC_INIC
			  FROM CRA_PERIO
			  WHERE OID_PERI = 57 --PARAMETRO PERIODO DESDE--
			 )FEC_DESDE,
			 (
			  SELECT FEC_FINA
			  FROM CRA_PERIO
			  WHERE OID_PERI = 58 --PARAMETRO PERIODO HASTA--
			 )FEC_HASTA
		WHERE VTA_PRO.MVPZ_OID_META_VENT_PROY_ZONA = MET_PRO.OID_META_VENT_PROY_ZONA	
			  AND MET_PRO.ZZON_OID_ZONA = ZON.OID_ZONA
			  AND ZON.ZORG_OID_REGI = REG.OID_REGI
			  AND ZON.CLIE_OID_CLIE = CLI.OID_CLIE
			  AND ZON.PAIS_OID_PAIS = 1 --PARAMETRO PAIS--
			  AND ZON.MARC_OID_MARC = 1 --PARAMETRO MARCA--
			  AND ZON.CANA_OID_CANA = 1 --PARAMETRO CANAL--
			  AND ZON.OID_ZONA IN (1) --PARAMETRO ZONA--	
			  AND REG.OID_REGI IN (7) --PARAMETRO REGION--	
			  AND ZON.PAIS_OID_PAIS = PER.PAIS_OID_PAIS
			  AND ZON.MARC_OID_MARC = PER.MARC_OID_MARC
			  AND ZON.CANA_OID_CANA = PER.CANA_OID_CANA
			  AND VTA_PRO.PERD_OID_PERI = PER.OID_PERI	
			  AND FEC_DESDE.FEC_INIC <= PER.FEC_INIC	
			  AND PER.FEC_FINA <= FEC_HASTA.FEC_FINA	
			  AND MET_PRO.COPA_OID_PARA_GRAL = 1 --PARAMETRO CONCURSO--	
  			  AND SUBG.OID_SUBG_VENT = REG.ZSGV_OID_SUBG_VENT
		GROUP BY SUBG.DES_SUBG_VENT,
			  	 REG.DES_REGI,		
			   ZON.COD_ZONA,	
			   CLI.VAL_NOM1||' '||CLI.VAL_NOM2||' '||CLI.VAL_APE1||' '||CLI.VAL_APE2,	
		   	   VTA_PRO.FEC_ANIO_COME	
	)		
	UNION		
	(		
		SELECT SUBG.DES_SUBG_VENT,
			   REG.DES_REGI,		
			   ZON.COD_ZONA,	
			   CLI.VAL_NOM1||' '||CLI.VAL_NOM2||' '||CLI.VAL_APE1||' '||CLI.VAL_APE2,	
			   VTA_PRO.FEC_ANIO_COME,	
		   	SUM(VTA_PRO.IMP_EGRE),
			5	AS VARIABLE
		FROM INC_RESUL_VENTA_PROYE_ZONA VTA_PRO,		
			 INC_METAS_VENTA_PROYE_ZONA MET_PRO,	
			 ZON_ZONA ZON,	
			 ZON_REGIO REG,	
			 ZON_SUB_GEREN_VENTA SUBG,
			 MAE_CLIEN CLI,	
			 CRA_PERIO PER,	
			 (	
			  SELECT FEC_INIC	
			  FROM CRA_PERIO	
			  WHERE OID_PERI = 57 --PARAMETRO PERIODO DESDE--	
			 )FEC_DESDE,	
			 (	
			  SELECT FEC_FINA
			  FROM CRA_PERIO
			  WHERE OID_PERI = 58 --PARAMETRO PERIODO HASTA--
			 )FEC_HASTA
		WHERE VTA_PRO.MVPZ_OID_META_VENT_PROY_ZONA = MET_PRO.OID_META_VENT_PROY_ZONA	
			  AND MET_PRO.ZZON_OID_ZONA = ZON.OID_ZONA
			  AND ZON.ZORG_OID_REGI = REG.OID_REGI
			  AND ZON.CLIE_OID_CLIE = CLI.OID_CLIE
			  AND ZON.PAIS_OID_PAIS = 1 --PARAMETRO PAIS--
			  AND ZON.MARC_OID_MARC = 1 --PARAMETRO MARCA--
			  AND ZON.CANA_OID_CANA = 1 --PARAMETRO CANAL--
			  AND ZON.OID_ZONA IN (1) --PARAMETRO ZONA--
			  AND REG.OID_REGI IN (7) --PARAMETRO REGION--
			  AND ZON.PAIS_OID_PAIS = PER.PAIS_OID_PAIS
			  AND ZON.MARC_OID_MARC = PER.MARC_OID_MARC
			  AND ZON.CANA_OID_CANA = PER.CANA_OID_CANA
			  AND VTA_PRO.PERD_OID_PERI = PER.OID_PERI
			  AND FEC_DESDE.FEC_INIC <= PER.FEC_INIC
			  AND PER.FEC_FINA <= FEC_HASTA.FEC_FINA
			  AND MET_PRO.COPA_OID_PARA_GRAL = 1 --PARAMETRO CONCURSO--	
  			  AND SUBG.OID_SUBG_VENT = REG.ZSGV_OID_SUBG_VENT
		GROUP BY SUBG.DES_SUBG_VENT,
			   REG.DES_REGI,		
			   ZON.COD_ZONA,	
			   CLI.VAL_NOM1||' '||CLI.VAL_NOM2||' '||CLI.VAL_APE1||' '||CLI.VAL_APE2,	
		   	   VTA_PRO.FEC_ANIO_COME	
	)		
	UNION		
	(		
		SELECT SUBG.DES_SUBG_VENT,
			   REG.DES_REGI,		
			   ZON.COD_ZONA,	
			   CLI.VAL_NOM1||' '||CLI.VAL_NOM2||' '||CLI.VAL_APE1||' '||CLI.VAL_APE2,	
			   VTA_PRO.FEC_ANIO_COME,	
		   	SUM(VTA_PRO.IMP_INGR),
			6	AS VARIABLE
		FROM INC_RESUL_VENTA_PROYE_ZONA VTA_PRO,		
			 INC_METAS_VENTA_PROYE_ZONA MET_PRO,
			 ZON_ZONA ZON,
			 ZON_REGIO REG,
			 ZON_SUB_GEREN_VENTA SUBG,
			 MAE_CLIEN CLI,
			 CRA_PERIO PER,
			 (
			  SELECT FEC_INIC
			  FROM CRA_PERIO
			  WHERE OID_PERI = 57 --PARAMETRO PERIODO DESDE--
			 )FEC_DESDE,
			 (
			  SELECT FEC_FINA
			  FROM CRA_PERIO
			  WHERE OID_PERI = 58 --PARAMETRO PERIODO HASTA--
			 )FEC_HASTA
		WHERE VTA_PRO.MVPZ_OID_META_VENT_PROY_ZONA = MET_PRO.OID_META_VENT_PROY_ZONA	
			  AND MET_PRO.ZZON_OID_ZONA = ZON.OID_ZONA
			  AND ZON.ZORG_OID_REGI = REG.OID_REGI
			  AND ZON.CLIE_OID_CLIE = CLI.OID_CLIE
			  AND ZON.PAIS_OID_PAIS = 1 --PARAMETRO PAIS--
			  AND ZON.MARC_OID_MARC = 1 --PARAMETRO MARCA--
			  AND ZON.CANA_OID_CANA = 1 --PARAMETRO CANAL--
			  AND ZON.OID_ZONA IN (1) --PARAMETRO ZONA--
			  AND REG.OID_REGI IN (7) --PARAMETRO REGION--
			  AND ZON.PAIS_OID_PAIS = PER.PAIS_OID_PAIS
			  AND ZON.MARC_OID_MARC = PER.MARC_OID_MARC
			  AND ZON.CANA_OID_CANA = PER.CANA_OID_CANA
    		  AND VTA_PRO.PERD_OID_PERI = PER.OID_PERI
			  AND FEC_DESDE.FEC_INIC <= PER.FEC_INIC
			  AND PER.FEC_FINA <= FEC_HASTA.FEC_FINA
			  AND MET_PRO.COPA_OID_PARA_GRAL = 1 --PARAMETRO CONCURSO--
  			  AND SUBG.OID_SUBG_VENT = REG.ZSGV_OID_SUBG_VENT
		GROUP BY SUBG.DES_SUBG_VENT,
			   REG.DES_REGI,	
			   ZON.COD_ZONA,
			   CLI.VAL_NOM1||' '||CLI.VAL_NOM2||' '||CLI.VAL_APE1||' '||CLI.VAL_APE2,
		   	   VTA_PRO.FEC_ANIO_COME
	)		
	UNION		
	(		
		SELECT SUBG.DES_SUBG_VENT,
			   REG.DES_REGI,		
			   ZON.COD_ZONA,	
			   CLI.VAL_NOM1||' '||CLI.VAL_NOM2||' '||CLI.VAL_APE1||' '||CLI.VAL_APE2,	
			   VTA_PRO.FEC_ANIO_COME,	
		   	SUM(VTA_PRO.NUM_CLIE),
			7	AS VARIABLE
		FROM INC_RESUL_VENTA_PROYE_ZONA VTA_PRO,		
			 INC_METAS_VENTA_PROYE_ZONA MET_PRO,	
			 ZON_ZONA ZON,	
			 ZON_REGIO REG,	
			 ZON_SUB_GEREN_VENTA SUBG,
			 MAE_CLIEN CLI,	
			 CRA_PERIO PER,	
			 (
			  SELECT FEC_INIC
			  FROM CRA_PERIO
			  WHERE OID_PERI = 57 --PARAMETRO PERIODO DESDE--
			 )FEC_DESDE,
			 (
			  SELECT FEC_FINA
			  FROM CRA_PERIO
			  WHERE OID_PERI = 58 --PARAMETRO PERIODO HASTA--
			 )FEC_HASTA
		WHERE VTA_PRO.MVPZ_OID_META_VENT_PROY_ZONA = MET_PRO.OID_META_VENT_PROY_ZONA	
			  AND MET_PRO.ZZON_OID_ZONA = ZON.OID_ZONA
			  AND ZON.ZORG_OID_REGI = REG.OID_REGI
			  AND ZON.CLIE_OID_CLIE = CLI.OID_CLIE
			  AND ZON.PAIS_OID_PAIS = PER.PAIS_OID_PAIS
			  AND ZON.MARC_OID_MARC = PER.MARC_OID_MARC
			  AND ZON.CANA_OID_CANA = PER.CANA_OID_CANA
			  AND ZON.PAIS_OID_PAIS = 1 --PARAMETRO PAIS--
			  AND ZON.MARC_OID_MARC = 1 --PARAMETRO MARCA--
			  AND ZON.CANA_OID_CANA = 1 --PARAMETRO CANAL--	
			  AND ZON.OID_ZONA IN (1) --PARAMETRO ZONA--	
			  AND REG.OID_REGI IN (7) --PARAMETRO REGION--	
			  AND VTA_PRO.PERD_OID_PERI = PER.OID_PERI	
			  AND FEC_DESDE.FEC_INIC <= PER.FEC_INIC	
			  AND PER.FEC_FINA <= FEC_HASTA.FEC_FINA	
			  AND MET_PRO.COPA_OID_PARA_GRAL = 1 --PARAMETRO CONCURSO--
			  			  AND SUBG.OID_SUBG_VENT = REG.ZSGV_OID_SUBG_VENT	
		GROUP BY SUBG.DES_SUBG_VENT, 
			  REG.DES_REGI,					  
			   ZON.COD_ZONA,	
			   CLI.VAL_NOM1||' '||CLI.VAL_NOM2||' '||CLI.VAL_APE1||' '||CLI.VAL_APE2,	
		   	   VTA_PRO.FEC_ANIO_COME	
	)		
	UNION		
	(		
		SELECT SUBG.DES_SUBG_VENT,
			   REG.DES_REGI,		
			   ZON.COD_ZONA,	
			   CLI.VAL_NOM1||' '||CLI.VAL_NOM2||' '||CLI.VAL_APE1||' '||CLI.VAL_APE2,	
			   VTA_PRO.FEC_ANIO_COME,	
		   	SUM(VTA_PRO.NUM_ORDE),
			8	AS VARIABLE
		FROM INC_RESUL_VENTA_PROYE_ZONA VTA_PRO,		
			 INC_METAS_VENTA_PROYE_ZONA MET_PRO,	
			 ZON_ZONA ZON,	
			 ZON_REGIO REG,	
			 ZON_SUB_GEREN_VENTA SUBG,
			 MAE_CLIEN CLI,	
			 CRA_PERIO PER,	
			 (	
			  SELECT FEC_INIC	
			  FROM CRA_PERIO	
			  WHERE OID_PERI = 57 --PARAMETRO PERIODO DESDE--	
			 )FEC_DESDE,	
			 (
			  SELECT FEC_FINA
			  FROM CRA_PERIO
			  WHERE OID_PERI = 58 --PARAMETRO PERIODO HASTA--
			 )FEC_HASTA
		WHERE VTA_PRO.MVPZ_OID_META_VENT_PROY_ZONA = MET_PRO.OID_META_VENT_PROY_ZONA	
			  AND MET_PRO.ZZON_OID_ZONA = ZON.OID_ZONA
			  AND ZON.ZORG_OID_REGI = REG.OID_REGI
			  AND ZON.CLIE_OID_CLIE = CLI.OID_CLIE
			  AND ZON.PAIS_OID_PAIS = 1 --PARAMETRO PAIS--
			  AND ZON.MARC_OID_MARC = 1 --PARAMETRO MARCA--
			  AND ZON.CANA_OID_CANA = 1 --PARAMETRO CANAL--
			  AND ZON.OID_ZONA IN (1) --PARAMETRO ZONA--
			  AND REG.OID_REGI IN (7) --PARAMETRO REGION--
			  AND ZON.PAIS_OID_PAIS = PER.PAIS_OID_PAIS
			  AND ZON.MARC_OID_MARC = PER.MARC_OID_MARC
			  AND ZON.CANA_OID_CANA = PER.CANA_OID_CANA
			  AND VTA_PRO.PERD_OID_PERI = PER.OID_PERI
			  AND FEC_DESDE.FEC_INIC <= PER.FEC_INIC
			  AND PER.FEC_FINA <= FEC_HASTA.FEC_FINA	
			  AND MET_PRO.COPA_OID_PARA_GRAL = 1 --PARAMETRO CONCURSO--
  			  AND SUBG.OID_SUBG_VENT = REG.ZSGV_OID_SUBG_VENT	
		GROUP BY SUBG.DES_SUBG_VENT,
			   REG.DES_REGI,		
			   ZON.COD_ZONA,	
			   CLI.VAL_NOM1||' '||CLI.VAL_NOM2||' '||CLI.VAL_APE1||' '||CLI.VAL_APE2,	
		   	   VTA_PRO.FEC_ANIO_COME	
	)		
	UNION		
	(		
		SELECT SUBG.DES_SUBG_VENT,
			   REG.DES_REGI,		
			   ZON.COD_ZONA,	
			   CLI.VAL_NOM1||' '||CLI.VAL_NOM2||' '||CLI.VAL_APE1||' '||CLI.VAL_APE2,	
			   VTA_PRO.FEC_ANIO_COME,	
		   	SUM(VTA_PRO.NUM_PEDI),
			9	AS VARIABLE
		FROM INC_RESUL_VENTA_PROYE_ZONA VTA_PRO,	
			 INC_METAS_VENTA_PROYE_ZONA MET_PRO,
			 ZON_ZONA ZON,
			 ZON_REGIO REG, ZON_SUB_GEREN_VENTA SUBG,
			 MAE_CLIEN CLI,
			 CRA_PERIO PER,
			 (
			  SELECT FEC_INIC
			  FROM CRA_PERIO
			  WHERE OID_PERI = 57 --PARAMETRO PERIODO DESDE--
			 )FEC_DESDE,
			 (
			  SELECT FEC_FINA
			  FROM CRA_PERIO
			  WHERE OID_PERI = 58 --PARAMETRO PERIODO HASTA--
			 )FEC_HASTA
		WHERE VTA_PRO.MVPZ_OID_META_VENT_PROY_ZONA = MET_PRO.OID_META_VENT_PROY_ZONA	
			  AND MET_PRO.ZZON_OID_ZONA = ZON.OID_ZONA
			  AND ZON.ZORG_OID_REGI = REG.OID_REGI
			  AND ZON.PAIS_OID_PAIS = PER.PAIS_OID_PAIS
			  AND ZON.MARC_OID_MARC = PER.MARC_OID_MARC
			  AND ZON.CANA_OID_CANA = PER.CANA_OID_CANA
			  AND ZON.CLIE_OID_CLIE = CLI.OID_CLIE
			  AND ZON.PAIS_OID_PAIS = 1 --PARAMETRO PAIS--
			  AND ZON.MARC_OID_MARC = 1 --PARAMETRO MARCA--
			  AND ZON.CANA_OID_CANA = 1 --PARAMETRO CANAL--
			  AND ZON.OID_ZONA IN (1) --PARAMETRO ZONA--
			  AND REG.OID_REGI IN (7) --PARAMETRO REGION--
			  AND VTA_PRO.PERD_OID_PERI = PER.OID_PERI
			  AND FEC_DESDE.FEC_INIC <= PER.FEC_INIC
			  AND PER.FEC_FINA <= FEC_HASTA.FEC_FINA
			  AND MET_PRO.COPA_OID_PARA_GRAL = 1 --PARAMETRO CONCURSO--
			  			  AND SUBG.OID_SUBG_VENT = REG.ZSGV_OID_SUBG_VENT
		GROUP BY SUBG.DES_SUBG_VENT, REG.DES_REGI,	
			   ZON.COD_ZONA,
			   CLI.VAL_NOM1||' '||CLI.VAL_NOM2||' '||CLI.VAL_APE1||' '||CLI.VAL_APE2,
		   	   VTA_PRO.FEC_ANIO_COME	
	)		
	UNION		
	(		
		SELECT SUBG.DES_SUBG_VENT,REG.DES_REGI,		
			   ZON.COD_ZONA,	
			   CLI.VAL_NOM1||' '||CLI.VAL_NOM2||' '||CLI.VAL_APE1||' '||CLI.VAL_APE2,	
			   VTA_PRO.FEC_ANIO_COME,	
		   	SUM(VTA_PRO.IMP_PREC_MEDI_UNIT),
			10	AS VARIABLE
		FROM INC_RESUL_VENTA_PROYE_ZONA VTA_PRO,		
			 INC_METAS_VENTA_PROYE_ZONA MET_PRO,	
			 ZON_ZONA ZON,	
			 ZON_REGIO REG, ZON_SUB_GEREN_VENTA SUBG,	
			 MAE_CLIEN CLI,	
			 CRA_PERIO PER,
			 (
			  SELECT FEC_INIC
			  FROM CRA_PERIO
			  WHERE OID_PERI = 57 --PARAMETRO PERIODO DESDE--
			 )FEC_DESDE,
			 (
			  SELECT FEC_FINA
			  FROM CRA_PERIO
			  WHERE OID_PERI = 58 --PARAMETRO PERIODO HASTA--
			 )FEC_HASTA
		WHERE VTA_PRO.MVPZ_OID_META_VENT_PROY_ZONA = MET_PRO.OID_META_VENT_PROY_ZONA	
			  AND MET_PRO.ZZON_OID_ZONA = ZON.OID_ZONA
			  AND ZON.ZORG_OID_REGI = REG.OID_REGI
			  AND ZON.CLIE_OID_CLIE = CLI.OID_CLIE
			  AND ZON.PAIS_OID_PAIS = 1 --PARAMETRO PAIS--
			  AND ZON.MARC_OID_MARC = 1 --PARAMETRO MARCA--	
			  AND ZON.CANA_OID_CANA = 1 --PARAMETRO CANAL--	
			  AND ZON.OID_ZONA IN (1) --PARAMETRO ZONA--	
			  AND REG.OID_REGI IN (7) --PARAMETRO REGION--	
			  AND ZON.PAIS_OID_PAIS = PER.PAIS_OID_PAIS
			  AND ZON.MARC_OID_MARC = PER.MARC_OID_MARC
			  AND ZON.CANA_OID_CANA = PER.CANA_OID_CANA
			  AND VTA_PRO.PERD_OID_PERI = PER.OID_PERI	
			  AND FEC_DESDE.FEC_INIC <= PER.FEC_INIC	
			  AND PER.FEC_FINA <= FEC_HASTA.FEC_FINA	
			  AND MET_PRO.COPA_OID_PARA_GRAL = 1 --PARAMETRO CONCURSO--	
  			  AND SUBG.OID_SUBG_VENT = REG.ZSGV_OID_SUBG_VENT
    	GROUP BY SUBG.DES_SUBG_VENT,REG.DES_REGI,		
			   ZON.COD_ZONA,	
			   CLI.VAL_NOM1||' '||CLI.VAL_NOM2||' '||CLI.VAL_APE1||' '||CLI.VAL_APE2,	
		   	   VTA_PRO.FEC_ANIO_COME	
	)		
	UNION		
	(		
		SELECT SUBG.DES_SUBG_VENT,REG.DES_REGI,		
			   ZON.COD_ZONA,	
			   CLI.VAL_NOM1||' '||CLI.VAL_NOM2||' '||CLI.VAL_APE1||' '||CLI.VAL_APE2,	
			   VTA_PRO.FEC_ANIO_COME,	
		   	SUM(VTA_PRO.VAL_PROM_VENT_PEDI),
			11	AS VARIABLE
		FROM INC_RESUL_VENTA_PROYE_ZONA VTA_PRO,		
			 INC_METAS_VENTA_PROYE_ZONA MET_PRO,	
			 ZON_ZONA ZON,	
			 ZON_REGIO REG, ZON_SUB_GEREN_VENTA SUBG,	
			 MAE_CLIEN CLI,	
			 CRA_PERIO PER,	
			 (	
			  SELECT FEC_INIC	
			  FROM CRA_PERIO	
			  WHERE OID_PERI = 57 --PARAMETRO PERIODO DESDE--	
			 )FEC_DESDE,
			 (
			  SELECT FEC_FINA
			  FROM CRA_PERIO
			  WHERE OID_PERI = 58 --PARAMETRO PERIODO HASTA--
			 )FEC_HASTA
		WHERE VTA_PRO.MVPZ_OID_META_VENT_PROY_ZONA = MET_PRO.OID_META_VENT_PROY_ZONA	
			  AND MET_PRO.ZZON_OID_ZONA = ZON.OID_ZONA
			  AND ZON.ZORG_OID_REGI = REG.OID_REGI
			  AND ZON.CLIE_OID_CLIE = CLI.OID_CLIE
			  			  AND SUBG.OID_SUBG_VENT = REG.ZSGV_OID_SUBG_VENT
			  AND ZON.PAIS_OID_PAIS = 1 --PARAMETRO PAIS--
			  AND ZON.MARC_OID_MARC = 1 --PARAMETRO MARCA--
			  AND ZON.CANA_OID_CANA = 1 --PARAMETRO CANAL--
			  AND ZON.OID_ZONA IN (1) --PARAMETRO ZONA--
			  AND REG.OID_REGI IN (7) --PARAMETRO REGION--
			  AND VTA_PRO.PERD_OID_PERI = PER.OID_PERI
			  AND ZON.PAIS_OID_PAIS = PER.PAIS_OID_PAIS
			  AND ZON.MARC_OID_MARC = PER.MARC_OID_MARC
			  AND ZON.CANA_OID_CANA = PER.CANA_OID_CANA
			  AND FEC_DESDE.FEC_INIC <= PER.FEC_INIC	
			  AND PER.FEC_FINA <= FEC_HASTA.FEC_FINA	
			  AND MET_PRO.COPA_OID_PARA_GRAL = 1 --PARAMETRO CONCURSO--	
		GROUP BY SUBG.DES_SUBG_VENT,REG.DES_REGI,		
			   ZON.COD_ZONA,	
			   CLI.VAL_NOM1||' '||CLI.VAL_NOM2||' '||CLI.VAL_APE1||' '||CLI.VAL_APE2,	
		   	   VTA_PRO.FEC_ANIO_COME	
	)		
	UNION		
	(		
		SELECT SUBG.DES_SUBG_VENT,REG.DES_REGI,		
			   ZON.COD_ZONA,	
			   CLI.VAL_NOM1||' '||CLI.VAL_NOM2||' '||CLI.VAL_APE1||' '||CLI.VAL_APE2,	
			   VTA_PRO.FEC_ANIO_COME,	
		   	SUM(VTA_PRO.VAL_PROM_ORDE_PEDI),
			12	AS VARIABLE
		FROM INC_RESUL_VENTA_PROYE_ZONA VTA_PRO,		
			 INC_METAS_VENTA_PROYE_ZONA MET_PRO,	
			 ZON_ZONA ZON,	
			 ZON_REGIO REG, ZON_SUB_GEREN_VENTA SUBG,	
			 MAE_CLIEN CLI,	
			 CRA_PERIO PER,	
			 (	
			  SELECT FEC_INIC	
			  FROM CRA_PERIO	
			  WHERE OID_PERI = 57 --PARAMETRO PERIODO DESDE--	
			 )FEC_DESDE,	
			 (	
			  SELECT FEC_FINA	
			  FROM CRA_PERIO	
			  WHERE OID_PERI = 58 --PARAMETRO PERIODO HASTA--	
			 )FEC_HASTA
		WHERE VTA_PRO.MVPZ_OID_META_VENT_PROY_ZONA = MET_PRO.OID_META_VENT_PROY_ZONA	
			  AND MET_PRO.ZZON_OID_ZONA = ZON.OID_ZONA
			  AND ZON.ZORG_OID_REGI = REG.OID_REGI
			  			  AND SUBG.OID_SUBG_VENT = REG.ZSGV_OID_SUBG_VENT
			  AND ZON.CLIE_OID_CLIE = CLI.OID_CLIE
			  AND ZON.PAIS_OID_PAIS = PER.PAIS_OID_PAIS
			  AND ZON.MARC_OID_MARC = PER.MARC_OID_MARC
			  AND ZON.CANA_OID_CANA = PER.CANA_OID_CANA
			  AND ZON.PAIS_OID_PAIS = 1 --PARAMETRO PAIS--
			  AND ZON.MARC_OID_MARC = 1 --PARAMETRO MARCA--
			  AND ZON.CANA_OID_CANA = 1 --PARAMETRO CANAL--
			  AND ZON.OID_ZONA IN (1) --PARAMETRO ZONA--
			  AND REG.OID_REGI IN (7) --PARAMETRO REGION--
			  AND VTA_PRO.PERD_OID_PERI = PER.OID_PERI
			  AND FEC_DESDE.FEC_INIC <= PER.FEC_INIC
			  AND PER.FEC_FINA <= FEC_HASTA.FEC_FINA
			  AND MET_PRO.COPA_OID_PARA_GRAL = 1 --PARAMETRO CONCURSO--
		GROUP BY SUBG.DES_SUBG_VENT,REG.DES_REGI,	
			   ZON.COD_ZONA,
			   CLI.VAL_NOM1||' '||CLI.VAL_NOM2||' '||CLI.VAL_APE1||' '||CLI.VAL_APE2,	
		   	   VTA_PRO.FEC_ANIO_COME	
	)		
	UNION		
	(		
		SELECT SUBG.DES_SUBG_VENT,REG.DES_REGI,		
			   ZON.COD_ZONA,	
			   CLI.VAL_NOM1||' '||CLI.VAL_NOM2||' '||CLI.VAL_APE1||' '||CLI.VAL_APE2,	
			   VTA_PRO.FEC_ANIO_COME,	
		   	SUM(VTA_PRO.VAL_PROM_UNID_PEDI),
			13	AS VARIABLE
		FROM INC_RESUL_VENTA_PROYE_ZONA VTA_PRO,		
			 INC_METAS_VENTA_PROYE_ZONA MET_PRO,	
			 ZON_ZONA ZON,	
			 ZON_REGIO REG, ZON_SUB_GEREN_VENTA SUBG,	
			 MAE_CLIEN CLI,
			 CRA_PERIO PER,
			 (
			  SELECT FEC_INIC
			  FROM CRA_PERIO
			  WHERE OID_PERI = 57 --PARAMETRO PERIODO DESDE--
			 )FEC_DESDE,
			 (
			  SELECT FEC_FINA
			  FROM CRA_PERIO
			  WHERE OID_PERI = 58 --PARAMETRO PERIODO HASTA--
			 )FEC_HASTA
		WHERE VTA_PRO.MVPZ_OID_META_VENT_PROY_ZONA = MET_PRO.OID_META_VENT_PROY_ZONA	
			  AND MET_PRO.ZZON_OID_ZONA = ZON.OID_ZONA
			  AND ZON.ZORG_OID_REGI = REG.OID_REGI
			  AND ZON.CLIE_OID_CLIE = CLI.OID_CLIE
			  			  AND SUBG.OID_SUBG_VENT = REG.ZSGV_OID_SUBG_VENT
			  AND ZON.PAIS_OID_PAIS = 1 --PARAMETRO PAIS--	
			  AND ZON.MARC_OID_MARC = 1 --PARAMETRO MARCA--	
			  AND ZON.CANA_OID_CANA = 1 --PARAMETRO CANAL--	
			  AND ZON.OID_ZONA IN (1) --PARAMETRO ZONA--	
			  AND REG.OID_REGI IN (7) --PARAMETRO REGION--	
			  AND ZON.PAIS_OID_PAIS = PER.PAIS_OID_PAIS
			  AND ZON.MARC_OID_MARC = PER.MARC_OID_MARC
			  AND ZON.CANA_OID_CANA = PER.CANA_OID_CANA
			  AND VTA_PRO.PERD_OID_PERI = PER.OID_PERI	
			  AND FEC_DESDE.FEC_INIC <= PER.FEC_INIC	
			  AND PER.FEC_FINA <= FEC_HASTA.FEC_FINA	
			  AND MET_PRO.COPA_OID_PARA_GRAL = 1 --PARAMETRO CONCURSO--	
		GROUP BY SUBG.DES_SUBG_VENT,REG.DES_REGI,		
			   ZON.COD_ZONA,	
			   CLI.VAL_NOM1||' '||CLI.VAL_NOM2||' '||CLI.VAL_APE1||' '||CLI.VAL_APE2,	
		   	   VTA_PRO.FEC_ANIO_COME	
	)		
	UNION		
	(		
		SELECT SUBG.DES_SUBG_VENT,REG.DES_REGI,		
			   ZON.COD_ZONA,	
			   CLI.VAL_NOM1||' '||CLI.VAL_NOM2||' '||CLI.VAL_APE1||' '||CLI.VAL_APE2,	
			   VTA_PRO.FEC_ANIO_COME,	
		   	SUM(VTA_PRO.IMP_REIN),
			14	AS VARIABLE
		FROM INC_RESUL_VENTA_PROYE_ZONA VTA_PRO,		
			 INC_METAS_VENTA_PROYE_ZONA MET_PRO,	
			 ZON_ZONA ZON,	
			 ZON_REGIO REG, ZON_SUB_GEREN_VENTA SUBG,	
			 MAE_CLIEN CLI,	
			 CRA_PERIO PER,	
			 (	
			  SELECT FEC_INIC	
			  FROM CRA_PERIO	
			  WHERE OID_PERI = 57 --PARAMETRO PERIODO DESDE--
			 )FEC_DESDE,
			 (
			  SELECT FEC_FINA
			  FROM CRA_PERIO
			  WHERE OID_PERI = 58 --PARAMETRO PERIODO HASTA--
			 )FEC_HASTA
		WHERE VTA_PRO.MVPZ_OID_META_VENT_PROY_ZONA = MET_PRO.OID_META_VENT_PROY_ZONA	
			  AND MET_PRO.ZZON_OID_ZONA = ZON.OID_ZONA
			  AND ZON.ZORG_OID_REGI = REG.OID_REGI
			  AND ZON.CLIE_OID_CLIE = CLI.OID_CLIE
			  AND ZON.PAIS_OID_PAIS = 1 --PARAMETRO PAIS--
			  			  AND SUBG.OID_SUBG_VENT = REG.ZSGV_OID_SUBG_VENT
			  AND ZON.MARC_OID_MARC = 1 --PARAMETRO MARCA--
			  AND ZON.CANA_OID_CANA = 1 --PARAMETRO CANAL--
			  AND ZON.OID_ZONA IN (1) --PARAMETRO ZONA--
			  AND REG.OID_REGI IN (7) --PARAMETRO REGION--
			  AND ZON.PAIS_OID_PAIS = PER.PAIS_OID_PAIS
			  AND ZON.MARC_OID_MARC = PER.MARC_OID_MARC
			  AND ZON.CANA_OID_CANA = PER.CANA_OID_CANA
			  AND VTA_PRO.PERD_OID_PERI = PER.OID_PERI	
			  AND FEC_DESDE.FEC_INIC <= PER.FEC_INIC	
			  AND PER.FEC_FINA <= FEC_HASTA.FEC_FINA	
			  AND MET_PRO.COPA_OID_PARA_GRAL = 1 --PARAMETRO CONCURSO--	
		GROUP BY SUBG.DES_SUBG_VENT,REG.DES_REGI,		
			   ZON.COD_ZONA,	
			   CLI.VAL_NOM1||' '||CLI.VAL_NOM2||' '||CLI.VAL_APE1||' '||CLI.VAL_APE2,	
		   	   VTA_PRO.FEC_ANIO_COME	
	)		
	UNION		
	(		
		SELECT SUBG.DES_SUBG_VENT,REG.DES_REGI,		
			   ZON.COD_ZONA,	
			   CLI.VAL_NOM1||' '||CLI.VAL_NOM2||' '||CLI.VAL_APE1||' '||CLI.VAL_APE2,	
			   VTA_PRO.FEC_ANIO_COME,	
		   	SUM(VTA_PRO.VAL_RETE),
			15	AS VARIABLE
		FROM INC_RESUL_VENTA_PROYE_ZONA VTA_PRO,		
			 INC_METAS_VENTA_PROYE_ZONA MET_PRO,	
			 ZON_ZONA ZON,	 ZON_SUB_GEREN_VENTA SUBG,
			 ZON_REGIO REG,	
			 MAE_CLIEN CLI,	
			 CRA_PERIO PER,	
			 (	
			  SELECT FEC_INIC	
			  FROM CRA_PERIO	
			  WHERE OID_PERI = 57 --PARAMETRO PERIODO DESDE--	
			 )FEC_DESDE,	
			 (	
			  SELECT FEC_FINA	
			  FROM CRA_PERIO	
			  WHERE OID_PERI = 58 --PARAMETRO PERIODO HASTA--
			 )FEC_HASTA
		WHERE VTA_PRO.MVPZ_OID_META_VENT_PROY_ZONA = MET_PRO.OID_META_VENT_PROY_ZONA	
			  AND MET_PRO.ZZON_OID_ZONA = ZON.OID_ZONA
			  AND ZON.ZORG_OID_REGI = REG.OID_REGI
			  AND ZON.CLIE_OID_CLIE = CLI.OID_CLIE
			  AND ZON.PAIS_OID_PAIS = 1 --PARAMETRO PAIS--
			  AND ZON.MARC_OID_MARC = 1 --PARAMETRO MARCA--
			  AND ZON.CANA_OID_CANA = 1 --PARAMETRO CANAL--
			  AND ZON.OID_ZONA IN (1) --PARAMETRO ZONA--
			  AND REG.OID_REGI IN (7) --PARAMETRO REGION--
			  AND ZON.PAIS_OID_PAIS = PER.PAIS_OID_PAIS
			  			  AND SUBG.OID_SUBG_VENT = REG.ZSGV_OID_SUBG_VENT
			  AND ZON.MARC_OID_MARC = PER.MARC_OID_MARC
			  AND ZON.CANA_OID_CANA = PER.CANA_OID_CANA
			  AND VTA_PRO.PERD_OID_PERI = PER.OID_PERI
			  AND FEC_DESDE.FEC_INIC <= PER.FEC_INIC
			  AND PER.FEC_FINA <= FEC_HASTA.FEC_FINA
			  AND MET_PRO.COPA_OID_PARA_GRAL = 1 --PARAMETRO CONCURSO--
		GROUP BY SUBG.DES_SUBG_VENT,REG.DES_REGI,	
			   ZON.COD_ZONA,	
			   CLI.VAL_NOM1||' '||CLI.VAL_NOM2||' '||CLI.VAL_APE1||' '||CLI.VAL_APE2,	
		   	   VTA_PRO.FEC_ANIO_COME	
	)		
	UNION		
	(		
		SELECT SUBG.DES_SUBG_VENT,REG.DES_REGI,		
			   ZON.COD_ZONA,	
			   CLI.VAL_NOM1||' '||CLI.VAL_NOM2||' '||CLI.VAL_APE1||' '||CLI.VAL_APE2,	
			   VTA_PRO.FEC_ANIO_COME,	
		   	SUM(VTA_PRO.NUM_UNID_VEND),
			16	AS VARIABLE
		FROM INC_RESUL_VENTA_PROYE_ZONA VTA_PRO,		
			 INC_METAS_VENTA_PROYE_ZONA MET_PRO,	
			 ZON_ZONA ZON,	 ZON_SUB_GEREN_VENTA SUBG,
			 ZON_REGIO REG,
			 MAE_CLIEN CLI,
			 CRA_PERIO PER,
			 (
			  SELECT FEC_INIC
			  FROM CRA_PERIO
			  WHERE OID_PERI = 57 --PARAMETRO PERIODO DESDE--
			 )FEC_DESDE,
			 (
			  SELECT FEC_FINA
			  FROM CRA_PERIO
			  WHERE OID_PERI = 58 --PARAMETRO PERIODO HASTA--
			 )FEC_HASTA
		WHERE VTA_PRO.MVPZ_OID_META_VENT_PROY_ZONA = MET_PRO.OID_META_VENT_PROY_ZONA	
			  AND MET_PRO.ZZON_OID_ZONA = ZON.OID_ZONA
			  AND ZON.ZORG_OID_REGI = REG.OID_REGI
			  AND ZON.CLIE_OID_CLIE = CLI.OID_CLIE	
			  AND ZON.PAIS_OID_PAIS = PER.PAIS_OID_PAIS
			  AND ZON.MARC_OID_MARC = PER.MARC_OID_MARC
			  AND ZON.CANA_OID_CANA = PER.CANA_OID_CANA
			  AND ZON.PAIS_OID_PAIS = 1 --PARAMETRO PAIS--	
			  AND ZON.MARC_OID_MARC = 1 --PARAMETRO MARCA--	
			  AND ZON.CANA_OID_CANA = 1 --PARAMETRO CANAL--	
			  AND ZON.OID_ZONA IN (1) --PARAMETRO ZONA--	
			  AND REG.OID_REGI IN (7) --PARAMETRO REGION--	
			  AND VTA_PRO.PERD_OID_PERI = PER.OID_PERI	
			  			  AND SUBG.OID_SUBG_VENT = REG.ZSGV_OID_SUBG_VENT
			  AND FEC_DESDE.FEC_INIC <= PER.FEC_INIC	
			  AND PER.FEC_FINA <= FEC_HASTA.FEC_FINA	
			  AND MET_PRO.COPA_OID_PARA_GRAL = 1 --PARAMETRO CONCURSO--	
		GROUP BY SUBG.DES_SUBG_VENT,REG.DES_REGI,		
			   ZON.COD_ZONA,	
			   CLI.VAL_NOM1||' '||CLI.VAL_NOM2||' '||CLI.VAL_APE1||' '||CLI.VAL_APE2,	
		   	   VTA_PRO.FEC_ANIO_COME	
	)		
	UNION		
	(		
		SELECT SUBG.DES_SUBG_VENT,
		 REG.DES_REGI,		
			   ZON.COD_ZONA,	
			   CLI.VAL_NOM1||' '||CLI.VAL_NOM2||' '||CLI.VAL_APE1||' '||CLI.VAL_APE2,	
			   VTA_PRO.FEC_ANIO_COME,	
		   	SUM(VTA_PRO.IMP_VENT_NETA_ESTA),
			17	AS VARIABLE
		FROM INC_RESUL_VENTA_PROYE_ZONA VTA_PRO,		
			 INC_METAS_VENTA_PROYE_ZONA MET_PRO,	
			 ZON_ZONA ZON,	
			 ZON_REGIO REG, ZON_SUB_GEREN_VENTA SUBG,	
			 MAE_CLIEN CLI,	
			 CRA_PERIO PER,	
			 (	
			  SELECT FEC_INIC	
			  FROM CRA_PERIO
			  WHERE OID_PERI = 57 --PARAMETRO PERIODO DESDE--
			 )FEC_DESDE,
			 (
			  SELECT FEC_FINA
			  FROM CRA_PERIO
			  WHERE OID_PERI = 58 --PARAMETRO PERIODO HASTA--
			 )FEC_HASTA
		WHERE VTA_PRO.MVPZ_OID_META_VENT_PROY_ZONA = MET_PRO.OID_META_VENT_PROY_ZONA	
			  AND MET_PRO.ZZON_OID_ZONA = ZON.OID_ZONA
			  AND ZON.ZORG_OID_REGI = REG.OID_REGI
			  AND ZON.CLIE_OID_CLIE = CLI.OID_CLIE
			  AND ZON.PAIS_OID_PAIS = 1 --PARAMETRO PAIS--
			  AND ZON.MARC_OID_MARC = 1 --PARAMETRO MARCA--
			  AND ZON.CANA_OID_CANA = 1 --PARAMETRO CANAL--
			  AND ZON.OID_ZONA IN (1) --PARAMETRO ZONA--
			  AND REG.OID_REGI IN (7) --PARAMETRO REGION--	
			  AND ZON.PAIS_OID_PAIS = PER.PAIS_OID_PAIS
			  AND ZON.MARC_OID_MARC = PER.MARC_OID_MARC
			  AND ZON.CANA_OID_CANA = PER.CANA_OID_CANA
			  AND VTA_PRO.PERD_OID_PERI = PER.OID_PERI	
			  			  AND SUBG.OID_SUBG_VENT = REG.ZSGV_OID_SUBG_VENT
			  AND FEC_DESDE.FEC_INIC <= PER.FEC_INIC	
			  AND PER.FEC_FINA <= FEC_HASTA.FEC_FINA	
			  AND MET_PRO.COPA_OID_PARA_GRAL = 1 --PARAMETRO CONCURSO--	
		GROUP BY SUBG.DES_SUBG_VENT, 
			   REG.DES_REGI,		
			   ZON.COD_ZONA,	
			   CLI.VAL_NOM1||' '||CLI.VAL_NOM2||' '||CLI.VAL_APE1||' '||CLI.VAL_APE2,	
		   	   VTA_PRO.FEC_ANIO_COME	
	)		
)
WHERE VARIABLE IN (1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17) --PARAMETRO VARIABLE--
ORDER BY VARIABLE, VALOR DESC