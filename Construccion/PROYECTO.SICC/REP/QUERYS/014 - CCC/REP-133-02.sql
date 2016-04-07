





SELECT PERIODO.PAIS,
	   PERIODO.SOCI,
	   PERIODO.COD_PERI,
	   PERIODO.VAL_ANIO,
	   DATOS.IMP,
	   DATOS.PEND,
	   DATOS.PORC
FROM
	(
		SELECT PAIS.OID_PAIS,
			   MOV_CCC.SOCI_OID_SOCI,
			   PER_COR.OID_PERI,
			   SUM(NVL(MOV_CCC.IMP_MOVI,0)) AS IMP,
   			   SUM(NVL(MOV_CCC.IMP_PEND,0)) AS PEND,
			   DECODE(SUM(NVL(MOV_CCC.IMP_MOVI,0)), 0, 0, (SUM(NVL(MOV_CCC.IMP_PEND,0)) / SUM(NVL(MOV_CCC.IMP_MOVI,0)))) * 100 PORC
		FROM 
		     SEG_CANAL CANAL,
			 SEG_MARCA MARCA,
			 ZON_SUB_GEREN_VENTA SUB_GER,
			 SEG_PAIS PAIS,
			 ZON_REGIO REG,
			 ZON_ZONA ZONA,
			 ZON_SECCI SEC,
		     ZON_TERRI TER,
			 ZON_TERRI_ADMIN TER_ADM,
			 CCC_MOVIM_CUENT_CORRI MOV_CCC,
			 SEG_SOCIE SOC,
			 SEG_PERIO_CORPO PER_COR,
			 CRA_PERIO PER
		WHERE SUB_GER.CANA_OID_CANA = CANAL.OID_CANA 
			  AND SUB_GER.MARC_OID_MARC = MARCA.OID_MARC
			  AND SUB_GER.PAIS_OID_PAIS = PAIS.OID_PAIS
			  AND REG.ZSGV_OID_SUBG_VENT = SUB_GER.OID_SUBG_VENT
			  AND ZONA.ZORG_OID_REGI = REG.OID_REGI
			  AND SEC.ZZON_OID_ZONA = ZONA.OID_ZONA
			  AND TER_ADM.TERR_OID_TERR = TER.OID_TERR
			  AND TER_ADM.TERR_OID_TERR = SEC.OID_SECC
			  AND MOV_CCC.ZTAD_OID_TERR_ADMI = TER_ADM.OID_TERR_ADMI
			  AND SOC.OID_SOCI = MOV_CCC.SOCI_OID_SOCI
			  AND PER.CANA_OID_CANA = CANAL.OID_CANA
			  AND PER.MARC_OID_MARC = MARCA.OID_MARC
			  AND PER.PAIS_OID_PAIS = PAIS.OID_PAIS
			  AND MOV_CCC.PERD_OID_PERI = PER.OID_PERI
			  AND PER.PERI_OID_PERI = PER_COR.OID_PERI
			  AND MOV_CCC.FEC_DOCU <= TO_DATE('01/11/2005','DD/MM/YYYY') -- PARAMETRO DE FECHA --
			  AND MOV_CCC.FEC_DOCU >= TO_DATE('01/01/'||''||(TO_CHAR(TO_DATE('01/11/2005','DD/MM/YYYY'),'YYYY') - 2), 'DD/MM/YYYY') -- PARAMETRO DE FECHA --
		--	  AND PAIS.OID_PAIS = 1		  			  				-- PARAMETRO DE PAIS --
		--	  AND MARCA.OID_MARCA = 1								-- PARAMETRO DE MARCA --
		--    AND CANAL.OID_CANA = 1								-- PARAMETRO DE CANAL --
		--	  AND REG.OID_REGI IN (1)								-- PARAMETRO DE REGION --
		--	  AND ZONA.OID_ZONA IN (1)								-- PARAMETRO DE ZONA --
		--	  AND SEC.OID_SECC IN (1)								-- PARAMETRO DE SECCION --
			  AND TER.COD_TERR >= 1									-- PARAMETRO DE TERRITORIO DESDE --
			  AND TER.COD_TERR <= 1000000							-- PARAMETRO DE TERRITORIO HASTA --
		GROUP BY 
			  PAIS.OID_PAIS,
			  MOV_CCC.SOCI_OID_SOCI,
			  PER_COR.OID_PERI
	) DATOS,
	(	
 		SELECT *
		FROM SEG_PERIO_CORPO SP,
			 (
			   SELECT DISTINCT MCC.SOCI_OID_SOCI,
			   		  GEN_SOCI.VAL_I18N SOCI,
					  GEN_PAIS.VAL_I18N PAIS
			   FROM ZON_SUB_GEREN_VENTA SUBG,
			        ZON_REGIO REG,
			        ZON_ZONA ZONA,
                    ZON_SECCI SEC,
			 		ZON_TERRI_ADMIN TA, 
					ZON_TERRI TER,
			 		CCC_MOVIM_CUENT_CORRI MCC,
    				 (
					 SELECT GEN.VAL_OID, GEN.VAL_I18N
					 FROM V_GEN_I18N_SICC GEN
					 WHERE GEN.ATTR_ENTI = 'SEG_SOCIE'
					 	   AND GEN.IDIO_OID_IDIO = 1 		   	  							-- PARAMETRO DE IDIOMA --
					 ) GEN_SOCI,
					 (
					 SELECT GEN.VAL_OID, GEN.VAL_I18N
					 FROM V_GEN_I18N_SICC GEN
					 WHERE GEN.ATTR_ENTI = 'SEG_PAIS'
					 	   AND GEN.IDIO_OID_IDIO = 1 		   	  							-- PARAMETRO DE IDIOMA --
					 ) GEN_PAIS
			   WHERE SUBG.OID_SUBG_VENT = REG.ZSGV_OID_SUBG_VENT
				  AND REG.OID_REGI = ZONA.ZORG_OID_REGI
				  AND ZONA.OID_ZONA = SEC.ZZON_OID_ZONA
				  AND SEC.OID_SECC = TA.ZSCC_OID_SECC
				  AND TA.OID_TERR_ADMI = MCC.ZTAD_OID_TERR_ADMI
	  			  AND GEN_SOCI.VAL_OID(+) = MCC.SOCI_OID_SOCI
				  AND SUBG.PAIS_OID_PAIS = GEN_PAIS.VAL_OID(+)
				  AND TER.OID_TERR = TA.TERR_OID_TERR
				  AND MCC.FEC_DOCU <= TO_DATE('01/11/2005','DD/MM/YYYY') -- PARAMETRO DE FECHA --
				  AND MCC.FEC_DOCU >= TO_DATE('01/01/'||''||(TO_CHAR(TO_DATE('01/11/2005','DD/MM/YYYY'),'YYYY') - 2), 'DD/MM/YYYY') -- PARAMETRO DE FECHA --
				  AND SUBG.PAIS_OID_PAIS = 1 									 -- PARAMETRO DE PAIS --
				  AND SUBG.MARC_OID_MARC = 1									 -- PARAMETRO DE MARCA --
				  AND SUBG.CANA_OID_CANA = 1									 -- PARAMETRO DE CANAL --
	  		--	  AND REG.OID_REGI IN (1)								-- PARAMETRO DE REGION --
			--	  AND ZONA.OID_ZONA IN (1)								-- PARAMETRO DE ZONA --
			--	  AND SEC.OID_SECC IN (1)								-- PARAMETRO DE SECCION --
	 			  AND TER.COD_TERR >= 1									-- PARAMETRO DE TERRITORIO DESDE --
				  AND TER.COD_TERR <= 1000000							-- PARAMETRO DE TERRITORIO HASTA --  
			)
		WHERE SP.VAL_ANIO >= TO_CHAR(TO_DATE('01/11/2005','DD/MM/YYYY'),'YYYY') - 2
			  AND SP.VAL_ANIO <= TO_CHAR(TO_DATE('01/11/2005','DD/MM/YYYY'), 'YYYY')
		ORDER BY VAL_ANIO
    ) PERIODO
WHERE DATOS.OID_PERI(+) = PERIODO.OID_PERI	
	  AND DATOS.SOCI_OID_SOCI(+) = PERIODO.SOCI_OID_SOCI	
ORDER BY PAIS,
	  	 SOCI,
		 VAL_ANIO,
		 COD_PERI  