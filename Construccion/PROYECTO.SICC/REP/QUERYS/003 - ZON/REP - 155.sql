(
SELECT 
	   PAIS.COD_PAIS, I18PAIS.VAL_I18N, 
	   MARC.DES_MARC, I18CANA.VAL_I18N,
	   SUBG.COD_SUBG_VENT, SUBG.DES_SUBG_VENT,			   
	   REG.COD_REGI, REG.DES_REGI, 
	   ZON.COD_ZONA, ZON.DES_ZONA, 
	   SEC.COD_SECC, SEC.DES_SECCI,
	   TER.COD_TERR,
   	   (CLISUBG.VAL_APE1 || ' ' || CLISUBG.VAL_APE2 || ' ' || DECODE(CLISUBG.VAL_APEL_CASA,NULL,'','de ' || CLISUBG.VAL_APEL_CASA) || ' ' || CLISUBG.VAL_NOM1 || ' ' || CLISUBG.VAL_NOM2) as RESP_SUBG, 
   	   (CLIREG.VAL_APE1 || ' ' || CLIREG.VAL_APE2 || ' ' || DECODE(CLIREG.VAL_APEL_CASA,NULL,'','de ' || CLIREG.VAL_APEL_CASA) || ' ' || CLIREG.VAL_NOM1 || ' ' || CLIREG.VAL_NOM2) as RESP_REG,
	   (CLIZON.VAL_APE1 || ' ' || CLIZON.VAL_APE2 || ' ' || DECODE(CLIZON.VAL_APEL_CASA,NULL,'','de ' || CLIZON.VAL_APEL_CASA) || ' ' || CLIZON.VAL_NOM1 || ' ' || CLIZON.VAL_NOM2) as RESP_ZON,
	   (CLISEC.VAL_APE1 || ' ' || CLISEC.VAL_APE2 || ' ' || DECODE(CLISEC.VAL_APEL_CASA,NULL,'','de ' || CLISEC.VAL_APEL_CASA) || ' ' || CLISEC.VAL_NOM1 || ' ' || CLISEC.VAL_NOM2) as RESP_SEC,
   	   SUM(DECODE(CLIHIST.ESTA_OID_ESTA_CLIE,1,1,0)) AS ACTIVAS, SUM(DECODE(CLIHIST.ESTA_OID_ESTA_CLIE,2,1,0)) AS INGRESOS, SUM(DECODE(CLIHIST.ESTA_OID_ESTA_CLIE,5,1,0)) AS EGRESOS,  COUNT(CLIADMIN.CLIE_OID_CLIE) AS "4� Pedido",
	   SUM(PED.VAL_UNID_DEMA_REAL_TOTA) AS SUM_UNID_DEMA_REAL_TOTA, SUM(PED.NUM_UNID_POR_ATEN_TOTA) AS SUM_UNID_POR_ATEN_TOTA, SUM(PED.NUM_UNID_ATEN_TOTA) AS SUM_UNID_ATEN_TOTA, SUM(PED.VAL_PREC_NETO_TOTA_LOCA) AS SUM_PREC_NETO_TOTA_LOCA   
FROM 
	 V_GEN_I18N_SICC I18CANA,
	 V_GEN_I18N_SICC I18PAIS,
	 SEG_PAIS PAIS,
	 SEG_MARCA MARC,
	 ZON_SUB_GEREN_VENTA SUBG, 
	 ZON_REGIO REG, 
	 ZON_ZONA ZON,
	 ZON_SECCI SEC,
	 ZON_TERRI TER,
	 ZON_TERRI_ADMIN TERADMIN,
	 MAE_CLIEN CLISUBG,
	 MAE_CLIEN CLIREG,
	 MAE_CLIEN CLIZON,
	 MAE_CLIEN CLISEC,
	 MAE_CLIEN_UNIDA_ADMIN CLIADMIN,
	 MAE_CLIEN_HISTO_ESTAT CLIHIST,
	 MAE_CLIEN_DATOS_ADICI CLIADIC,
	 PED_SOLIC_CABEC PED,
	 CRA_PERIO PERII,
	 CRA_PERIO PERIF,
	 (
	 SELECT MIN(PERD.FEC_INIC) AS F_D_D, MAX(PERD.FEC_FINA) AS F_D_H, MIN(PERH.FEC_INIC) AS F_H_D, MAX(PERH.FEC_FINA) AS F_H_H
	 FROM CRA_PERIO PERD, CRA_PERIO PERH
	   WHERE PERD.PAIS_OID_PAIS = PERH.PAIS_OID_PAIS 
	   		 AND PERD.MARC_OID_MARC = PERH.MARC_OID_MARC
	   		 AND PERD.CANA_OID_CANA = PERH.CANA_OID_CANA
	   		 AND PERD.PAIS_OID_PAIS = 1								-- Parametro --
	   		 AND PERD.MARC_OID_MARC = 1								-- Parametro --
	   		 AND PERD.CANA_OID_CANA = 1		 						-- Parametro --
	   		 AND PERD.OID_PERI =41			 					-- Parametro --
	   		 AND PERH.OID_PERI =42							-- Parametro --
	   )  PERIDH
WHERE 
	  	  SUBG.OID_SUBG_VENT = REG.ZSGV_OID_SUBG_VENT
	  AND REG.OID_REGI = ZON.ZORG_OID_REGI
	  AND ZON.OID_ZONA = SEC.ZZON_OID_ZONA
	  AND SEC.OID_SECC = TERADMIN.ZSCC_OID_SECC
	  AND PAIS.OID_PAIS = SUBG.PAIS_OID_PAIS
	  AND PAIS.OID_PAIS = REG.PAIS_OID_PAIS
	  AND PAIS.OID_PAIS = ZON.PAIS_OID_PAIS
	  AND PAIS.OID_PAIS = TERADMIN.PAIS_OID_PAIS
	  AND PAIS.OID_PAIS = PERII.PAIS_OID_PAIS 
	  AND MARC.OID_MARC = SUBG.MARC_OID_MARC
	  AND SUBG.CLIE_OID_CLIE = CLISUBG.OID_CLIE(+)
	  AND REG.CLIE_OID_CLIE = CLIREG.OID_CLIE(+)
	  AND ZON.CLIE_OID_CLIE = CLIZON.OID_CLIE(+)
	  AND SEC.CLIE_OID_CLIE = CLISEC.OID_CLIE(+)
	  AND I18PAIS.VAL_OID = PAIS.OID_PAIS
	  AND I18CANA.VAL_OID = SUBG.CANA_OID_CANA
	  AND I18PAIS.ATTR_ENTI = 'SEG_PAIS'			  	  -- Val --
	  AND I18CANA.ATTR_ENTI = 'SEG_CANAL'			  	  -- Val --
	  AND PERII.PAIS_OID_PAIS = PERIF.PAIS_OID_PAIS 
	  AND PERII.MARC_OID_MARC = PERIF.MARC_OID_MARC 
	  AND PERII.CANA_OID_CANA = PERIF.CANA_OID_CANA 
	  AND SUBG.IND_BORR = 0	   							  -- Val --
	  AND I18PAIS.IDIO_OID_IDIO = 1					  	  -- Param --
	  AND I18CANA.IDIO_OID_IDIO = 1					  	  -- Param --
	  AND PAIS.OID_PAIS = 1		  						  -- Param --	  	 
	  AND SUBG.MARC_OID_MARC = 1					  	  -- Param -- 
	  AND SUBG.CANA_OID_CANA = 1					  	  -- Param --
	  AND PERII.MARC_OID_MARC = 1					  	  -- Param -- 
	  AND PERII.CANA_OID_CANA = 1					  	  -- Param -- 
/*	  AND SUBG.OID_SUBG_VENT = 1					  	  -- Param --
	  AND REG.OID_REGI = 1					  	  		  -- Param --
	  AND ZON.OID_ZONA = 1						  		  -- Param --
	  AND SEC.OID_SECC = 1			*/		  	  		  -- Param --
--	  AND TER.OID_TERR = 1					  	  		  -- Param --
	  AND TERADMIN.OID_TERR_ADMI = CLIADMIN.ZTAD_OID_TERR_ADMI
	  AND TERADMIN.TERR_OID_TERR = TER.OID_TERR
	  AND CLIADMIN.CLIE_OID_CLIE = CLIHIST.CLIE_OID_CLIE
	  AND CLIADMIN.CLIE_OID_CLIE = CLIADIC.CLIE_OID_CLIE
	  AND CLIADMIN.CLIE_OID_CLIE = PED.CLIE_OID_CLIE
	  AND CLIHIST.PERD_OID_PERI = PERII.OID_PERI
	  AND CLIHIST.PERD_OID_PERI_PERI_FIN = PERIF.OID_PERI
	  AND PERII.FEC_INIC <= PERIDH.F_H_H
GROUP BY
	   CLIADMIN.OID_CLIE_UNID_ADMI,
	   CLIHIST.ESTA_OID_ESTA_CLIE, CLIHIST.PERD_OID_PERI, PERII.FEC_INIC, PERII.FEC_FINA, CLIHIST.PERD_OID_PERI_PERI_FIN, PERIF.FEC_INIC, PERIF.FEC_FINA, 
	   CLIADIC.ESTA_OID_ESTA_CLIE, 
	   PAIS.COD_PAIS, I18PAIS.VAL_I18N, 
	   MARC.DES_MARC, I18CANA.VAL_I18N,
	   SUBG.COD_SUBG_VENT, SUBG.DES_SUBG_VENT,			   
	   REG.COD_REGI, REG.DES_REGI, 
	   ZON.COD_ZONA, ZON.DES_ZONA, 
	   SEC.COD_SECC, SEC.DES_SECCI,
	   TER.COD_TERR,
	   CLISUBG.VAL_APE1, CLISUBG.VAL_APE2, DECODE(CLISUBG.VAL_APEL_CASA,NULL,'','de ' || CLISUBG.VAL_APEL_CASA), CLISUBG.VAL_NOM1, CLISUBG.VAL_NOM2,
	   CLIREG.VAL_APE1, CLIREG.VAL_APE2, DECODE(CLIREG.VAL_APEL_CASA,NULL,'','de ' || CLIREG.VAL_APEL_CASA), CLIREG.VAL_NOM1, CLIREG.VAL_NOM2,
	   CLIZON.VAL_APE1, CLIZON.VAL_APE2, DECODE(CLIZON.VAL_APEL_CASA,NULL,'','de ' || CLIZON.VAL_APEL_CASA), CLIZON.VAL_NOM1, CLIZON.VAL_NOM2,
	   CLISEC.VAL_APE1, CLISEC.VAL_APE2, DECODE(CLISEC.VAL_APEL_CASA,NULL,'','de ' || CLISEC.VAL_APEL_CASA), CLISEC.VAL_NOM1, CLISEC.VAL_NOM2
HAVING 
	   COUNT(CLIADMIN.CLIE_OID_CLIE) <4 
)
UNION ALL
(SELECT 
	   PAIS.COD_PAIS, I18PAIS.VAL_I18N, 
	   MARC.DES_MARC, I18CANA.VAL_I18N,
	   SUBG.COD_SUBG_VENT, SUBG.DES_SUBG_VENT,			   
	   REG.COD_REGI, REG.DES_REGI, 
	   ZON.COD_ZONA, ZON.DES_ZONA, 
	   SEC.COD_SECC, SEC.DES_SECCI,
	   TER.COD_TERR,
	   (CLISUBG.VAL_APE1 || ' ' || CLISUBG.VAL_APE2 || ' ' || DECODE(CLISUBG.VAL_APEL_CASA,NULL,'','de ' || CLISUBG.VAL_APEL_CASA) || ' ' || CLISUBG.VAL_NOM1 || ' ' || CLISUBG.VAL_NOM2) as RESP_SUBG,
	   (CLIREG.VAL_APE1 || ' ' || CLIREG.VAL_APE2 || ' ' || DECODE(CLIREG.VAL_APEL_CASA,NULL,'','de ' || CLIREG.VAL_APEL_CASA) || ' ' || CLIREG.VAL_NOM1 || ' ' || CLIREG.VAL_NOM2) as RESP_REG,
	   (CLIZON.VAL_APE1 || ' ' || CLIZON.VAL_APE2 || ' ' || DECODE(CLIZON.VAL_APEL_CASA,NULL,'','de ' || CLIZON.VAL_APEL_CASA) || ' ' || CLIZON.VAL_NOM1 || ' ' || CLIZON.VAL_NOM2) as RESP_ZON,
	   (CLISEC.VAL_APE1 || ' ' || CLISEC.VAL_APE2 || ' ' || DECODE(CLISEC.VAL_APEL_CASA,NULL,'','de ' || CLISEC.VAL_APEL_CASA) || ' ' || CLISEC.VAL_NOM1 || ' ' || CLISEC.VAL_NOM2) as RESP_SEC,
	   SUM(DECODE(CLIHIST.ESTA_OID_ESTA_CLIE,1,1,0)) AS ACTIVOS, SUM(DECODE(CLIHIST.ESTA_OID_ESTA_CLIE,2,1,0)) AS NUEVOS, SUM(DECODE(CLIHIST.ESTA_OID_ESTA_CLIE,5,1,0)) AS EGRESADOS,  COUNT(CLIADMIN.CLIE_OID_CLIE) AS "4� Pedido",	    
	   SUM(PED.VAL_UNID_DEMA_REAL_TOTA) AS SUM_UNID_DEMA_REAL_TOTA, SUM(PED.NUM_UNID_POR_ATEN_TOTA) AS SUM_UNID_POR_ATEN_TOTA, SUM(PED.NUM_UNID_ATEN_TOTA) AS SUM_UNID_ATEN_TOTA, SUM(PED.VAL_PREC_NETO_TOTA_LOCA) AS SUM_PREC_NETO_TOTA_LOCA   
FROM 
	 V_GEN_I18N_SICC I18CANA,
	 V_GEN_I18N_SICC I18PAIS,
	 SEG_PAIS PAIS,
	 SEG_MARCA MARC,
	 ZON_SUB_GEREN_VENTA SUBG, 
	 ZON_REGIO REG, 
	 ZON_ZONA ZON,
	 ZON_SECCI SEC,
	 ZON_TERRI TER,
	 ZON_TERRI_ADMIN TERADMIN,
	 MAE_CLIEN CLISUBG,
	 MAE_CLIEN CLIREG,
	 MAE_CLIEN CLIZON,
	 MAE_CLIEN CLISEC,
	 MAE_CLIEN_UNIDA_ADMIN CLIADMIN,
	 MAE_CLIEN_HISTO_ESTAT CLIHIST,
	 MAE_CLIEN_DATOS_ADICI CLIADIC,
	 PED_SOLIC_CABEC PED,
	 CRA_PERIO PERII,
	 CRA_PERIO PERIF,
	 (
	 SELECT MIN(PERD.FEC_INIC) AS F_D_D, MAX(PERD.FEC_FINA) AS F_D_H, MIN(PERH.FEC_INIC) AS F_H_D, MAX(PERH.FEC_FINA) AS F_H_H
	 FROM CRA_PERIO PERD, CRA_PERIO PERH
	   WHERE PERD.PAIS_OID_PAIS = PERH.PAIS_OID_PAIS 
	   		 AND PERD.MARC_OID_MARC = PERH.MARC_OID_MARC
	   		 AND PERD.CANA_OID_CANA = PERH.CANA_OID_CANA
	   		 AND PERD.PAIS_OID_PAIS = 1								-- Parametro --
	   		 AND PERD.MARC_OID_MARC = 1								-- Parametro --
	   		 AND PERD.CANA_OID_CANA = 1		 						-- Parametro --
	   		 AND PERD.OID_PERI =41			 					-- Parametro --
	   		 AND PERH.OID_PERI =42							-- Parametro --
	   )  PERIDH
WHERE 
	  	  SUBG.OID_SUBG_VENT = REG.ZSGV_OID_SUBG_VENT
	  AND REG.OID_REGI = ZON.ZORG_OID_REGI
	  AND ZON.OID_ZONA = SEC.ZZON_OID_ZONA
	  AND SEC.OID_SECC = TERADMIN.ZSCC_OID_SECC
	  AND PAIS.OID_PAIS = SUBG.PAIS_OID_PAIS
	  AND PAIS.OID_PAIS = REG.PAIS_OID_PAIS
	  AND PAIS.OID_PAIS = ZON.PAIS_OID_PAIS
	  AND PAIS.OID_PAIS = TERADMIN.PAIS_OID_PAIS
	  AND PAIS.OID_PAIS = PERII.PAIS_OID_PAIS 
	  AND MARC.OID_MARC = SUBG.MARC_OID_MARC
	  AND SUBG.CLIE_OID_CLIE = CLISUBG.OID_CLIE(+)
	  AND REG.CLIE_OID_CLIE = CLIREG.OID_CLIE(+)
	  AND ZON.CLIE_OID_CLIE = CLIZON.OID_CLIE(+)
	  AND SEC.CLIE_OID_CLIE = CLISEC.OID_CLIE(+)
	  AND I18PAIS.VAL_OID = PAIS.OID_PAIS
	  AND I18CANA.VAL_OID = SUBG.CANA_OID_CANA
	  AND I18PAIS.ATTR_ENTI = 'SEG_PAIS'			  	  -- Val --
	  AND I18CANA.ATTR_ENTI = 'SEG_CANAL'			  	  -- Val --
	  AND PERII.PAIS_OID_PAIS = PERIF.PAIS_OID_PAIS 
	  AND PERII.MARC_OID_MARC = PERIF.MARC_OID_MARC 
	  AND PERII.CANA_OID_CANA = PERIF.CANA_OID_CANA 
	  AND SUBG.IND_BORR = 0	   							  -- Val --
	  AND I18PAIS.IDIO_OID_IDIO = 1					  	  -- Param --
	  AND I18CANA.IDIO_OID_IDIO = 1					  	  -- Param --
	  AND PAIS.OID_PAIS = 1		  						  -- Param --	  	 
	  AND SUBG.MARC_OID_MARC = 1					  	  -- Param -- 
	  AND SUBG.CANA_OID_CANA = 1					  	  -- Param --
	  AND PERII.MARC_OID_MARC = 1					  	  -- Param -- 
	  AND PERII.CANA_OID_CANA = 1					  	  -- Param -- 
/*	  AND SUBG.OID_SUBG_VENT = 1					  	  -- Param --
	  AND REG.OID_REGI = 1					  	  		  -- Param --
	  AND ZON.OID_ZONA = 1						  		  -- Param --
	  AND SEC.OID_SECC = 1				*/	  	  		  -- Param --
	--  AND TER.OID_TERR = 1					  	  		  -- Param --
	  AND TERADMIN.OID_TERR_ADMI = CLIADMIN.ZTAD_OID_TERR_ADMI
	  AND TERADMIN.TERR_OID_TERR = TER.OID_TERR
	  AND CLIADMIN.CLIE_OID_CLIE = CLIHIST.CLIE_OID_CLIE
	  AND CLIADMIN.CLIE_OID_CLIE = CLIADIC.CLIE_OID_CLIE
	  AND CLIADMIN.CLIE_OID_CLIE = PED.CLIE_OID_CLIE
	  AND CLIHIST.PERD_OID_PERI = PERII.OID_PERI
	  AND CLIHIST.PERD_OID_PERI_PERI_FIN = PERIF.OID_PERI
	  AND PERII.FEC_INIC <= PERIDH.F_H_H
GROUP BY
	   CLIADMIN.OID_CLIE_UNID_ADMI,
	   CLIHIST.ESTA_OID_ESTA_CLIE, CLIHIST.PERD_OID_PERI, PERII.FEC_INIC, PERII.FEC_FINA, CLIHIST.PERD_OID_PERI_PERI_FIN, PERIF.FEC_INIC, PERIF.FEC_FINA, 
	   CLIADIC.ESTA_OID_ESTA_CLIE, 
	   PAIS.COD_PAIS, I18PAIS.VAL_I18N, 
	   MARC.DES_MARC, I18CANA.VAL_I18N,
	   SUBG.COD_SUBG_VENT, SUBG.DES_SUBG_VENT,			   
	   REG.COD_REGI, REG.DES_REGI, 
	   ZON.COD_ZONA, ZON.DES_ZONA, 
	   SEC.COD_SECC, SEC.DES_SECCI,
	   TER.COD_TERR,
	   CLISUBG.VAL_APE1, CLISUBG.VAL_APE2, DECODE(CLISUBG.VAL_APEL_CASA,NULL,'','de ' || CLISUBG.VAL_APEL_CASA), CLISUBG.VAL_NOM1, CLISUBG.VAL_NOM2,
	   CLIREG.VAL_APE1, CLIREG.VAL_APE2, DECODE(CLIREG.VAL_APEL_CASA,NULL,'','de ' || CLIREG.VAL_APEL_CASA), CLIREG.VAL_NOM1, CLIREG.VAL_NOM2,
	   CLIZON.VAL_APE1, CLIZON.VAL_APE2, DECODE(CLIZON.VAL_APEL_CASA,NULL,'','de ' || CLIZON.VAL_APEL_CASA), CLIZON.VAL_NOM1, CLIZON.VAL_NOM2,
	   CLISEC.VAL_APE1, CLISEC.VAL_APE2, DECODE(CLISEC.VAL_APEL_CASA,NULL,'','de ' || CLISEC.VAL_APEL_CASA), CLISEC.VAL_NOM1, CLISEC.VAL_NOM2
HAVING 
	   COUNT(CLIADMIN.CLIE_OID_CLIE) >3 
)
ORDER BY
	  COD_SUBG_VENT, 
	  COD_REGI, 
	  COD_ZONA, 
	  COD_SECC,
	  COD_TERR
	  


