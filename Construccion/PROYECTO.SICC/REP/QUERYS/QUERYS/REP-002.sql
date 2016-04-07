 	SELECT VAL_NOMB_PERI AS PERIODO,  		   			FECHA_PREV,                    pq_apl_rep.Fn_002_Concat_Grup_Crono(' 11,19,20,21,22,13,15,16,17 ', COD_REGI, 1 , 1 ,' 1 ',TO_CHAR(FECHA_PREV,'DD/MM/YYYY'), DECODE(' -1 ','-1',NULL,' -1 ')) GRUPO,                    CASE WHEN (DECODE ((SELECT FER.OID_FERI                                      FROM CRA_FERIA FER                                     WHERE FER.CACT_OID_ACTI = CACT_OID_ACTI                                       AND FER.CGZO_OID_CABE_GRUP_ZONA =  OID_CABE_GRUP_ZONA                                       AND FER.FEC_FERI = FECHA_PREV                                       AND IND_FEST = 1),NULL, 'NO','SI') = 'SI' ) THEN 'FERIADO'                      ELSE COD_REGI                  END AS REGION,                  VAL_ANIO AS ANIO                     FROM ( 							SELECT DISTINCT COR.VAL_ANIO,  								   			  PER.OID_PERI,  											  CRO.FEC_PREV FECHA_PREV, 		                                 	  PER.VAL_NOMB_PERI,  											  CAB.COD_GRUP, 											  REG.COD_REGI, 		                                      CAB.OID_CABE_GRUP_ZONA, 		                                      ACT.OID_ACTI AS CACT_OID_ACTI, 											  ACT.ACCE_OID_ACCE 		                    FROM CRA_ACTIV ACT, 		                                 CRA_PERIO PER, 		                                 CRA_CABEC_GRUPO_ZONA CAB, 		                                 CRA_CRONO_GRUPO_ZONA CRO, 		                                 CRA_DETAL_GRUPO_ZONA DET, 		                                 ZON_ZONA ZON, 		                                 ZON_REGIO REG, 		                                 SEG_PERIO_CORPO COR 		                    WHERE ACT.COD_ACTI = 'FA' 		                             AND ACT.PAIS_OID_PAIS = PER.PAIS_OID_PAIS 		                             AND ACT.MARC_OID_MARC = PER.MARC_OID_MARC 		                             AND ACT.CANA_OID_CANA = PER.CANA_OID_CANA 		                             AND PER.PAIS_OID_PAIS =  1  		                             AND PER.MARC_OID_MARC =  1  		                             AND PER.CANA_OID_CANA IN ( 1 ) 		                             AND PER.OID_PERI IN ( 57, 55 ) 		                             AND ZON.OID_ZONA IN  ( 11,19,20,21,22,13,15,16,17 ) 		                             AND COR.VAL_ANIO =  2004  		                             AND ACT.OID_ACTI = CRO.CACT_OID_ACTI 		                             AND CRO.PERD_OID_PERI = PER.OID_PERI 		                             AND PER.PERI_OID_PERI = COR.OID_PERI 		                             AND CAB.OID_CABE_GRUP_ZONA =  CRO.CGZO_OID_CABE_GRUP_ZONA 		                             AND DET.CGZO_OID_CABE_GRUP_ZONA =  CAB.OID_CABE_GRUP_ZONA 		                             AND DET.ZZON_OID_ZONA = ZON.OID_ZONA 		                             AND ZON.ZORG_OID_REGI = REG.OID_REGI 						  AND CASE WHEN (' -1 ' = '-1') THEN 						  		  -1 						   ELSE 						    		  CAB.ACCE_OID_ACCE 						   END  IN ( -1 ) 						   AND CRO.FEC_PREV IS NOT NULL 					)