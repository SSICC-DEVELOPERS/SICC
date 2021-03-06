



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
SELECT DATOS_AAAA.PAIS,
	   DATOS_AAAA.DES_REGI,
	   DATOS_AAAA.DES_ZONA,
	   DATOS_AAAA.VAL_ANIO AAAA,
       TRUNC(((DATOS_AAAA.COD_PERI) - 1)/6)+1 GRUPO,
	   DATOS_AAAA.VAL_NOMB_PERI,
--------------------------------- PROMEDIO VENTA NETA POR PEDIDO (PMNP) ----------------------------------
	   DECODE(DATOS_AA.N_PEDIDOS, 0, 0, DATOS_AA.VENTA_NETA_ESTAD / DATOS_AA.N_PEDIDOS) PMNP_REALAA,
	   CASE WHEN (DATOS_AAAA.VENTA_NETA_ESTAD IS NOT NULL) THEN
	   		DECODE(DATOS_AAAA.N_PEDIDOS, 0, 0, DATOS_AAAA.VENTA_NETA_ESTAD / DATOS_AAAA.N_PEDIDOS)
	   END PMNP_REALAAAA,
	   DECODE(DATOS_AAAA.PLAN_N_PEDIDOS, 0, 0, DATOS_AAAA.PLAN_VENTA_NETA_ESTAD / DATOS_AAAA.PLAN_N_PEDIDOS) PMNP_PLANAAAA,
	   CASE WHEN (DATOS_AAAA.VENTA_NETA_ESTAD IS NOT NULL) THEN
	   		DECODE(DECODE(DATOS_AA.N_PEDIDOS, 0, 0, DATOS_AA.VENTA_NETA_ESTAD / DATOS_AA.N_PEDIDOS), 0, 0, ((DECODE(DATOS_AAAA.N_PEDIDOS, 0, 0, DATOS_AAAA.VENTA_NETA_ESTAD / DATOS_AAAA.N_PEDIDOS) / DECODE(DATOS_AA.N_PEDIDOS, 0, 0, DATOS_AA.VENTA_NETA_ESTAD / DATOS_AA.N_PEDIDOS))-1)*100) 
	   END PMNP_PORC_REALAAAA_REALAA, 
	   CASE WHEN (DATOS_AAAA.VENTA_NETA_ESTAD IS NOT NULL) THEN
	   		DECODE(DECODE(DATOS_AAAA.PLAN_N_PEDIDOS, 0, 0, DATOS_AAAA.PLAN_VENTA_NETA_ESTAD / DATOS_AAAA.PLAN_N_PEDIDOS), 0 ,0, ((DECODE(DATOS_AAAA.N_PEDIDOS, 0, 0, DATOS_AAAA.VENTA_NETA_ESTAD / DATOS_AAAA.N_PEDIDOS) / DECODE(DATOS_AAAA.PLAN_N_PEDIDOS, 0, 0, DATOS_AAAA.PLAN_VENTA_NETA_ESTAD / DATOS_AAAA.PLAN_N_PEDIDOS))-1)*100)
	   END PMNP_PORC_REALAAAA_PLAN,
--------------------------------- PROMEDIO PRECIO POR UNIDAD -MONEDA LOCAL- (PPU) ------------------------
	   DECODE(DATOS_AA.UNIDADES_VENDIDAS, 0, 0, DATOS_AA.VENTA_NETA_ESTAD / DATOS_AA.UNIDADES_VENDIDAS) PPU_REALAA,
	   CASE WHEN (DATOS_AAAA.VENTA_NETA_ESTAD IS NOT NULL) THEN
	   		DECODE(DATOS_AAAA.UNIDADES_VENDIDAS, 0, 0, DATOS_AAAA.VENTA_NETA_ESTAD / DATOS_AAAA.UNIDADES_VENDIDAS)
	   END PPU_REALAAAA,
	   DECODE(DATOS_AAAA.PLAN_UNIDADES_VENDIDAS, 0, 0, DATOS_AAAA.PLAN_VENTA_NETA_ESTAD / DATOS_AAAA.PLAN_UNIDADES_VENDIDAS) PPU_PLANAAAA,
	   CASE WHEN (DATOS_AAAA.VENTA_NETA_ESTAD IS NOT NULL) THEN
	   		DECODE(DECODE(DATOS_AA.UNIDADES_VENDIDAS, 0, 0, DATOS_AA.VENTA_NETA_ESTAD / DATOS_AA.UNIDADES_VENDIDAS), 0, 0, ((DECODE(DATOS_AAAA.UNIDADES_VENDIDAS, 0, 0, DATOS_AAAA.VENTA_NETA_ESTAD / DATOS_AAAA.UNIDADES_VENDIDAS) / DECODE(DATOS_AA.UNIDADES_VENDIDAS, 0, 0, DATOS_AA.VENTA_NETA_ESTAD / DATOS_AA.UNIDADES_VENDIDAS))-1)*100) 
	   END PPU_PORC_REALAAAA_REALAA, 
	   CASE WHEN (DATOS_AAAA.VENTA_NETA_ESTAD IS NOT NULL) THEN
	   		DECODE(DECODE(DATOS_AAAA.PLAN_UNIDADES_VENDIDAS, 0, 0, DATOS_AAAA.PLAN_VENTA_NETA_ESTAD / DATOS_AAAA.PLAN_UNIDADES_VENDIDAS), 0 ,0, ((DECODE(DATOS_AAAA.UNIDADES_VENDIDAS, 0, 0, DATOS_AAAA.VENTA_NETA_ESTAD / DATOS_AAAA.UNIDADES_VENDIDAS) / DECODE(DATOS_AAAA.PLAN_UNIDADES_VENDIDAS, 0, 0, DATOS_AAAA.PLAN_VENTA_NETA_ESTAD / DATOS_AAAA.PLAN_UNIDADES_VENDIDAS))-1)*100)
	   END PPU_PORC_REALAAAA_PLAN,
--------------------------------- PROMEDIO UNIDADES POR PEDIDO (PUP) -------------------------------------
	   DECODE(DATOS_AA.N_PEDIDOS, 0, 0, DATOS_AA.UNIDADES_VENDIDAS / DATOS_AA.N_PEDIDOS) PUP_REALAA,
	   CASE WHEN (DATOS_AAAA.UNIDADES_VENDIDAS IS NOT NULL) THEN
	   		DECODE(DATOS_AAAA.N_PEDIDOS, 0, 0, DATOS_AAAA.UNIDADES_VENDIDAS / DATOS_AAAA.N_PEDIDOS)
	   END PUP_REALAAAA,
	   DECODE(DATOS_AAAA.PLAN_N_PEDIDOS, 0, 0, DATOS_AAAA.PLAN_UNIDADES_VENDIDAS / DATOS_AAAA.PLAN_N_PEDIDOS) PUP_PLANAAAA,
	   CASE WHEN (DATOS_AAAA.UNIDADES_VENDIDAS IS NOT NULL) THEN
	   		DECODE(DECODE(DATOS_AA.N_PEDIDOS, 0, 0, DATOS_AA.UNIDADES_VENDIDAS / DATOS_AA.N_PEDIDOS), 0, 0, ((DECODE(DATOS_AAAA.N_PEDIDOS, 0, 0, DATOS_AAAA.UNIDADES_VENDIDAS / DATOS_AAAA.N_PEDIDOS) / DECODE(DATOS_AA.N_PEDIDOS, 0, 0, DATOS_AA.UNIDADES_VENDIDAS / DATOS_AA.N_PEDIDOS))-1)*100) 
	   END PUP_PORC_REALAAAA_REALAA, 
	   CASE WHEN (DATOS_AAAA.UNIDADES_VENDIDAS IS NOT NULL) THEN
	   		DECODE(DECODE(DATOS_AAAA.PLAN_N_PEDIDOS, 0, 0, DATOS_AAAA.PLAN_UNIDADES_VENDIDAS / DATOS_AAAA.PLAN_N_PEDIDOS), 0 ,0, ((DECODE(DATOS_AAAA.N_PEDIDOS, 0, 0, DATOS_AAAA.UNIDADES_VENDIDAS / DATOS_AAAA.N_PEDIDOS) / DECODE(DATOS_AAAA.PLAN_N_PEDIDOS, 0, 0, DATOS_AAAA.PLAN_UNIDADES_VENDIDAS / DATOS_AAAA.PLAN_N_PEDIDOS))-1)*100)
	   END PUP_PORC_REALAAAA_PLAN,
--------------------------------- PROMEDIO POR PEDIDO (CPP) ----------------------------------------------	   
	   DECODE(DATOS_AA.N_PEDIDOS, 0, 0, DATOS_AA.N_CLIENTES / DATOS_AA.N_PEDIDOS) CPP_REALAA,
	   CASE WHEN (DATOS_AAAA.N_CLIENTES IS NOT NULL) THEN
	   		DECODE(DATOS_AAAA.N_PEDIDOS, 0, 0, DATOS_AAAA.N_CLIENTES / DATOS_AAAA.N_PEDIDOS)
	   END CPP_REALAAAA,
	   DECODE(DATOS_AAAA.PLAN_N_PEDIDOS, 0, 0, DATOS_AAAA.PLAN_N_CLIENTES / DATOS_AAAA.PLAN_N_PEDIDOS) CPP_PLANAAAA,
	   CASE WHEN (DATOS_AAAA.N_CLIENTES IS NOT NULL) THEN
	   		DECODE(DECODE(DATOS_AA.N_PEDIDOS, 0, 0, DATOS_AA.N_CLIENTES / DATOS_AA.N_PEDIDOS), 0, 0, ((DECODE(DATOS_AAAA.N_PEDIDOS, 0, 0, DATOS_AAAA.N_CLIENTES / DATOS_AAAA.N_PEDIDOS) / DECODE(DATOS_AA.N_PEDIDOS, 0, 0, DATOS_AA.N_CLIENTES / DATOS_AA.N_PEDIDOS))-1)*100) 
	   END CPP_PORC_REALAAAA_REALAA, 
	   CASE WHEN (DATOS_AAAA.N_CLIENTES IS NOT NULL) THEN
	   		DECODE(DECODE(DATOS_AAAA.PLAN_N_PEDIDOS, 0, 0, DATOS_AAAA.PLAN_N_CLIENTES / DATOS_AAAA.PLAN_N_PEDIDOS), 0 ,0, ((DECODE(DATOS_AAAA.N_PEDIDOS, 0, 0, DATOS_AAAA.N_CLIENTES / DATOS_AAAA.N_PEDIDOS) / DECODE(DATOS_AAAA.PLAN_N_PEDIDOS, 0, 0, DATOS_AAAA.PLAN_N_CLIENTES / DATOS_AAAA.PLAN_N_PEDIDOS))-1)*100)
	   END CPP_PORC_REALAAAA_PLAN,
	   CASE WHEN (DATOS_AAAA.VENTA_NETA_ESTAD IS NOT NULL) THEN
	   		1
	   END IND_PARA_TOTAL_CAMPANIA_FIN	  
FROM
(
	SELECT V_AAAA.PAIS,
		   V_AAAA.OID_REGI,
		   V_AAAA.DES_REGI,
		   V_AAAA.OID_ZONA,
		   V_AAAA.DES_ZONA,
		   V_AAAA.VAL_ANIO,
		   SUBSTR(V_AAAA.COD_PERI,5,2) COD_PERI,
		   V_AAAA.VAL_NOMB_PERI,
		   DATOS_AAAA.VENTA_NETA_ESTAD,
		   DATOS_AAAA.UNIDADES_VENDIDAS,
		   DATOS_AAAA.N_CLIENTES,
		   DATOS_AAAA.N_PEDIDOS,
		   V_AAAA.PLAN_VENTA_NETA_ESTAD,
		   V_AAAA.PLAN_UNIDADES_VENDIDAS,
		   V_AAAA.PLAN_N_CLIENTES,
		   V_AAAA.PLAN_N_PEDIDOS
	FROM
	(
		SELECT REG.OID_REGI,
			   ZONA.OID_ZONA,
			   PERI.OID_PERI,
			   NVL((
			   SELECT SUM(VRA.IMP_VENT_NETA_ESTA)
			   FROM INT_FUENT_VENTA_REAL_VACUM VRA
			   WHERE VRA.PAIS_OID_PAIS = 1 	 					-- PARAMETRO DE PAIS --
			   	  AND VRA.PERD_OID_PERI = PERI.OID_PERI
			  	  AND VRA.ZORG_OID_REGI = REG.OID_REGI					-- PARAMETRO DE REGION --
				  AND VRA.ZZON_OID_ZONA = ZONA.OID_ZONA					-- PARAMETRO DE ZONA --
			   GROUP BY REG.OID_REGI,
			   		 	ZONA.OID_ZONA,
						PERI.OID_PERI 
			   ), 0) VENTA_NETA_ESTAD,
			   NVL((
			   SELECT SUM(VRA.NUM_UNID_VEND)
			   FROM INT_FUENT_VENTA_REAL_VACUM VRA
			   WHERE VRA.PAIS_OID_PAIS = 1 	 					-- PARAMETRO DE PAIS --
			   	  AND VRA.PERD_OID_PERI = PERI.OID_PERI
			  	  AND VRA.ZORG_OID_REGI = REG.OID_REGI					-- PARAMETRO DE REGION --
				  AND VRA.ZZON_OID_ZONA = ZONA.OID_ZONA					-- PARAMETRO DE ZONA --
			   GROUP BY REG.OID_REGI,
			   		 	ZONA.OID_ZONA, 
						PERI.OID_PERI 
			   ), 0) UNIDADES_VENDIDAS,
			   NVL((
			   SELECT SUM(VRA.NUM_CLIE)
			   FROM INT_FUENT_VENTA_REAL_VACUM VRA
			   WHERE VRA.PAIS_OID_PAIS = 1 	 					-- PARAMETRO DE PAIS --
			   	  AND VRA.PERD_OID_PERI = PERI.OID_PERI
			  	  AND VRA.ZORG_OID_REGI = REG.OID_REGI					-- PARAMETRO DE REGION --
				  AND VRA.ZZON_OID_ZONA = ZONA.OID_ZONA					-- PARAMETRO DE ZONA --
			   GROUP BY REG.OID_REGI,
			   		 	ZONA.OID_ZONA, 
						PERI.OID_PERI 
			   ), 0) N_CLIENTES,
			   NVL((
			   SELECT SUM(VRA.NUM_PEDI)
			   FROM INT_FUENT_VENTA_REAL_VACUM VRA
			   WHERE VRA.PAIS_OID_PAIS = 1 	 					-- PARAMETRO DE PAIS --
			   	  AND VRA.PERD_OID_PERI = PERI.OID_PERI
			  	  AND VRA.ZORG_OID_REGI = REG.OID_REGI					-- PARAMETRO DE REGION --
				  AND VRA.ZZON_OID_ZONA = ZONA.OID_ZONA					-- PARAMETRO DE ZONA --
			   GROUP BY REG.OID_REGI,
			   		 	ZONA.OID_ZONA, 
						PERI.OID_PERI 
			   ), 0) N_PEDIDOS		   
		FROM CRA_PERIO PERI,
			 ZON_ZONA ZONA,
			 ZON_REGIO REG,
			 (
			 SELECT FEC_INIC
			 FROM CRA_PERIO 
			 WHERE OID_PERI = 55 				-- PARAMETRO DE PERIODO DESDE -- 
			 ) FI,
			 (
			 SELECT FEC_FINA
			 FROM CRA_PERIO 
			 WHERE OID_PERI = 67               -- PARAMETRO DE PERIDO HASTA --
			 ) FF	 
		WHERE PERI.FEC_INIC >= FI.FEC_INIC
			  AND PERI.FEC_FINA <= FF.FEC_FINA
			  AND ZONA.ZORG_OID_REGI = REG.OID_REGI
			  AND PERI.PAIS_OID_PAIS = 1		-- PARAMETRO DE PAIS --
			  AND PERI.MARC_OID_MARC = 1		-- PARAMETRO DE PAIS --
			  AND PERI.CANA_OID_CANA = 1		-- PARAMETRO DE PAIS --
			  AND ZONA.OID_ZONA = 1	   			-- PARAMETRO DE ZONA --
			  AND REG.OID_REGI = 7				-- PARAMETRO DE REGION --
	) DATOS_AAAA,
	(
	SELECT GEN_PAIS.VAL_I18N PAIS,
		   REG.OID_REGI,
		   REG.DES_REGI,
		   ZONA.OID_ZONA,
		   ZONA.DES_ZONA,
		   PC.VAL_ANIO,
		   PC.COD_PERI,
		   PERI.OID_PERI,
		   PERI.VAL_NOMB_PERI,
			   NVL((
			   SELECT SUM(VRA.IMP_VENT_NETA_ESTA)
			   FROM INT_FUENT_VENTA_REAL_VACUM VRA
			   WHERE VRA.PAIS_OID_PAIS = 1 	 					-- PARAMETRO DE PAIS --
			   	  AND VRA.PERD_OID_PERI = PERI.OID_PERI
			  	  AND VRA.ZORG_OID_REGI = REG.OID_REGI					-- PARAMETRO DE REGION --
				  AND VRA.ZZON_OID_ZONA = ZONA.OID_ZONA					-- PARAMETRO DE ZONA --
			   GROUP BY REG.OID_REGI,
			   		 	ZONA.OID_ZONA,
						PERI.OID_PERI 
			   ), 0) PLAN_VENTA_NETA_ESTAD,
			   NVL((
			   SELECT SUM(VRA.NUM_UNID_VEND)
			   FROM INT_FUENT_VENTA_REAL_VACUM VRA
			   WHERE VRA.PAIS_OID_PAIS = 1 	 					-- PARAMETRO DE PAIS --
			   	  AND VRA.PERD_OID_PERI = PERI.OID_PERI
			  	  AND VRA.ZORG_OID_REGI = REG.OID_REGI					-- PARAMETRO DE REGION --
				  AND VRA.ZZON_OID_ZONA = ZONA.OID_ZONA					-- PARAMETRO DE ZONA --
			   GROUP BY REG.OID_REGI,
			   		 	ZONA.OID_ZONA, 
						PERI.OID_PERI 
			   ), 0) PLAN_UNIDADES_VENDIDAS,
			   NVL((
			   SELECT SUM(VRA.NUM_CLIE)
			   FROM INT_FUENT_VENTA_REAL_VACUM VRA
			   WHERE VRA.PAIS_OID_PAIS = 1 	 					-- PARAMETRO DE PAIS --
			   	  AND VRA.PERD_OID_PERI = PERI.OID_PERI
			  	  AND VRA.ZORG_OID_REGI = REG.OID_REGI					-- PARAMETRO DE REGION --
				  AND VRA.ZZON_OID_ZONA = ZONA.OID_ZONA					-- PARAMETRO DE ZONA --
			   GROUP BY REG.OID_REGI,
			   		 	ZONA.OID_ZONA, 
						PERI.OID_PERI 
			   ), 0) PLAN_N_CLIENTES,
			   			   NVL((
			   SELECT SUM(VRA.NUM_PEDI)
			   FROM INT_FUENT_VENTA_REAL_VACUM VRA
			   WHERE VRA.PAIS_OID_PAIS = 1 	 					-- PARAMETRO DE PAIS --
			   	  AND VRA.PERD_OID_PERI = PERI.OID_PERI
			  	  AND VRA.ZORG_OID_REGI = REG.OID_REGI					-- PARAMETRO DE REGION --
				  AND VRA.ZZON_OID_ZONA = ZONA.OID_ZONA					-- PARAMETRO DE ZONA --
			   GROUP BY REG.OID_REGI,
			   		 	ZONA.OID_ZONA, 
						PERI.OID_PERI 
			   ), 0) PLAN_N_PEDIDOS		   
	FROM CRA_PERIO PERI,
		 ZON_ZONA ZONA,
		 ZON_REGIO REG,
		 (
		 SELECT PER_COR.OID_PERI,
		 		PER_COR.COD_PERI,
				PER_COR.VAL_ANIO
		 FROM SEG_PERIO_CORPO PER_COR
		 WHERE PER_COR.VAL_ANIO = (
	   							 SELECT PER_COR.VAL_ANIO
								 FROM SEG_PERIO_CORPO PER_COR,
								 	  CRA_PERIO PERI 
								 WHERE PERI.OID_PERI = 1379	  				   			 	-- PARAMETRO DE PERIODO DESDE --
								 	   AND PERI.PERI_OID_PERI = PER_COR.OID_PERI								    	  
								 )
		) PC,
		(
		SELECT GEN.VAL_OID, GEN.VAL_I18N
		FROM V_GEN_I18N_SICC GEN
		WHERE GEN.ATTR_ENTI = 'SEG_PAIS'
			  AND GEN.IDIO_OID_IDIO = 1	   					  		  -- PARAMETRO DE PAIS  --
		) GEN_PAIS
	WHERE PERI.PERI_OID_PERI = PC.OID_PERI 
		  AND GEN_PAIS.VAL_OID(+) = PERI.PAIS_OID_PAIS
		  AND PERI.MARC_OID_MARC = 1			   					  -- PARAMETRO DE MARCA --
		  AND PERI.CANA_OID_CANA = 1								  -- PARAMETRO DE CANAL --
		  AND PERI.PAIS_OID_PAIS = 1								  -- PARAMETRO DE PAIS -- 
		  AND ZONA.ZORG_OID_REGI = REG.OID_REGI
	      AND ZONA.OID_ZONA = 1	   			-- PARAMETRO DE ZONA --
	      AND REG.OID_REGI = 7				-- PARAMETRO DE REGION --
	) V_AAAA
	WHERE DATOS_AAAA.OID_PERI(+) = V_AAAA.OID_PERI
		  AND DATOS_AAAA.OID_REGI(+) = V_AAAA.OID_REGI
		  AND DATOS_AAAA.OID_ZONA(+) = V_AAAA.OID_ZONA
) DATOS_AAAA,
(	 
    SELECT OID_REGI,
		   OID_ZONA,
		   SUBSTR(COD_PERI,5,2) COD_PERI,
		   VENTA_NETA_ESTAD,
		   UNIDADES_VENDIDAS,
		   N_CLIENTES,
		   N_PEDIDOS
	FROM
 	 (
		SELECT REG.OID_REGI,
			   ZONA.OID_ZONA,
			   PC.COD_PERI,
			   NVL((
				   SELECT SUM(VRA.IMP_VENT_NETA_ESTA)
				   FROM INT_FUENT_VENTA_REAL_VACUM VRA
				   WHERE VRA.PAIS_OID_PAIS = 1 	 					-- PARAMETRO DE PAIS --
				   	  AND VRA.PERD_OID_PERI = PERI.OID_PERI
				  	  AND VRA.ZORG_OID_REGI = REG.OID_REGI					-- PARAMETRO DE REGION --
					  AND VRA.ZZON_OID_ZONA = ZONA.OID_ZONA					-- PARAMETRO DE ZONA --
				   GROUP BY REG.OID_REGI,
				   		 	ZONA.OID_ZONA,
				   		 	PERI.OID_PERI 
			   ), 0) VENTA_NETA_ESTAD,
			   NVL((
				   SELECT SUM(VRA.NUM_UNID_VEND)
				   FROM INT_FUENT_VENTA_REAL_VACUM VRA
				   WHERE VRA.PAIS_OID_PAIS = 1 	 					-- PARAMETRO DE PAIS --
				   	  AND VRA.PERD_OID_PERI = PERI.OID_PERI
				  	  AND VRA.ZORG_OID_REGI = REG.OID_REGI					-- PARAMETRO DE REGION --
					  AND VRA.ZZON_OID_ZONA = ZONA.OID_ZONA					-- PARAMETRO DE ZONA --
				   GROUP BY REG.OID_REGI,
				   		 	ZONA.OID_ZONA,
				   		 	PERI.OID_PERI 
			   ), 0) UNIDADES_VENDIDAS,
			   NVL((
				   SELECT SUM(VRA.NUM_CLIE)
				   FROM INT_FUENT_VENTA_REAL_VACUM VRA
				   WHERE VRA.PAIS_OID_PAIS = 1 	 					-- PARAMETRO DE PAIS --
				   	  AND VRA.PERD_OID_PERI = PERI.OID_PERI
				  	  AND VRA.ZORG_OID_REGI = REG.OID_REGI					-- PARAMETRO DE REGION --
					  AND VRA.ZZON_OID_ZONA = ZONA.OID_ZONA					-- PARAMETRO DE ZONA --
				   GROUP BY REG.OID_REGI,
				   		 	ZONA.OID_ZONA,
				   		 	PERI.OID_PERI 
			   ), 0) N_CLIENTES,		   
				 NVL((
				   SELECT SUM(VRA.NUM_PEDI)
				   FROM INT_FUENT_VENTA_REAL_VACUM VRA
				   WHERE VRA.PAIS_OID_PAIS = 1 	 					-- PARAMETRO DE PAIS --
				   	  AND VRA.PERD_OID_PERI = PERI.OID_PERI
				  	  AND VRA.ZORG_OID_REGI = REG.OID_REGI					-- PARAMETRO DE REGION --
					  AND VRA.ZZON_OID_ZONA = ZONA.OID_ZONA					-- PARAMETRO DE ZONA --
				   GROUP BY REG.OID_REGI,
				   		 	ZONA.OID_ZONA,
							PERI.OID_PERI 
				   ), 0) N_PEDIDOS
		FROM CRA_PERIO PERI,
			 ZON_ZONA ZONA,
			 ZON_REGIO REG,
			 (
			 SELECT PER_COR.OID_PERI,
			 		PER_COR.COD_PERI
			 FROM SEG_PERIO_CORPO PER_COR
			 WHERE PER_COR.VAL_ANIO = (
		   							 SELECT PER_COR.VAL_ANIO
									 FROM SEG_PERIO_CORPO PER_COR,
									 	  CRA_PERIO PERI 
									 WHERE PERI.OID_PERI = 1379	  				   			 	-- PARAMETRO DE PERIODO DESDE --
									 	   AND PERI.PERI_OID_PERI = PER_COR.OID_PERI								    	  
									 ) - 1 
			) PC
		WHERE PERI.PERI_OID_PERI = PC.OID_PERI
			  AND PERI.MARC_OID_MARC = 1			   					  -- PARAMETRO DE MARCA --
			  AND PERI.CANA_OID_CANA = 1								  -- PARAMETRO DE CANAL --
			  AND PERI.PAIS_OID_PAIS = 1								  -- PARAMETRO DE PAIS -- 
			  AND ZONA.ZORG_OID_REGI = REG.OID_REGI
		      AND ZONA.OID_ZONA = 1	   			-- PARAMETRO DE ZONA --
		      AND REG.OID_REGI = 7				-- PARAMETRO DE REGION --
	)
) DATOS_AA
WHERE DATOS_AAAA.COD_PERI = DATOS_AA.COD_PERI(+)
	  AND DATOS_AAAA.OID_REGI = DATOS_AA.OID_REGI(+)
	  AND DATOS_AAAA.OID_ZONA = DATOS_AA.OID_ZONA(+)
)		  
ORDER BY DES_REGI,
	  	 DES_ZONA,
		 GRUPO,
		 VAL_NOMB_PERI
	  
	  
	  
	  
