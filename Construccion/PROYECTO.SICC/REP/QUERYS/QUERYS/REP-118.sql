SELECT SOCI.SOCIEDAD, 	   DATOS.PAIS, 	   DATOS.VAL_NOMB_PERI, 	   DATOS.UNID_NEGOCIO, 	   DATOS.OPERA, 	   DATOS.COD_SAP, 	   DATOS.PROD, 	   DATOS.T_OPERA, 	   DATOS.UNI_FACTURADAS, 	   DATOS.UNI_RECLAMADAS_TOTAL, 	   DATOS.PORC, 	   DATOS.UNI_RECLA_DETALLE	 FROM  (   	SELECT SOC.VAL_DENO AS sociedad 	FROM PRINCIPALS PRI, 		PROPERTYVALUES PRO, 		SEG_SOCIE SOC			 	WHERE PRI.NAME =  'USUARIO1'  		 AND PRO.IDPROPERTY = 48 		 AND PRO.IDPRINCIPAL = PRI.IDPRINCIPAL 		 AND PRO.STRINGVALUE = SOC.OID_SOCI     ) SOCI, ( 	SELECT GEN_PAIS.VAL_I18N PAIS, 		   CABECERA.VAL_NOMB_PERI, 		   GEN_UN_NEGO.VAL_I18N UNID_NEGOCIO, 		   GEN_OP.VAL_I18N OPERA, 		   CABECERA.COD_SAP, 		   GEN_PRODU.VAL_I18N PROD, 		   GEN_T_OP.VAL_I18N T_OPERA,	 		   CABECERA.UNI_FACTURADAS, 		   CABECERA.UNI_RECLAMADAS UNI_RECLAMADAS_TOTAL, 		   CABECERA.PORC, 		   DETALLE.UNI_RECLAMADAS UNI_RECLA_DETALLE, 		   CABECERA.CONTROL 	FROM 		(  		SELECT CAB_REC.PAIS_OID_PAIS, 			   PERI.OID_PERI, 			   PERI.VAL_NOMB_PERI, 			   un_neg.OID_UNID_NEGO,	    			   OP.OID_OPER, 			   PRO.OID_PROD, 			   PRO.COD_SAP, 			   T_OP.OID_TIPO_OPER, 			   SUM(NVL(LIN_REC.NUM_UNID_RECL, 0)) UNI_RECLAMADAS		   	    		FROM PRE_MATRI_FACTU MAT, 			 PRE_OFERT_DETAL OD, 			 MAE_PRODU PRO, 			 mae_unida_negoc un_neg, 			 REC_CABEC_RECLA CAB_REC, 			 CRA_PERIO PERI, 			 REC_OPERA_RECLA OP_REC, 			 REC_OPERA OP, 			 REC_TIPOS_OPERA T_OP, 			 FAC_DOCUM_CONTA_CABEC FAC, 			 FAC_DOCUM_CONTA_LINEA FAC_LIN, 			 REC_LINEA_OPERA_RECLA LIN_REC, 			 PRE_CATAL CATA, 			( 			 SELECT FEC_INIC 			 FROM CRA_PERIO 			 WHERE OID_PERI =  57 	 			 			)PER_INI, 			( 			 SELECT FEC_FINA 			 FROM CRA_PERIO 			 WHERE OID_PERI = DECODE( -1 ,-1,  57 , -1 ) 			)PER_FIN 		WHERE MAT.OFDE_OID_DETA_OFER = OD.OID_DETA_OFER 			  AND OD.PROD_OID_PROD = PRO.OID_PROD 			  AND PRO.UNEG_OID_UNID_NEGO = un_neg.OID_UNID_NEGO 		      AND CAB_REC.SOCA_OID_SOLI_CABE = FAC.SOCA_OID_SOLI_CABE(+) 			  AND FAC.OID_CABE = FAC_LIN.DCCA_OID_CABE(+) 			 AND CAB_REC.PERD_OID_PERI_DOCU_REFE = PERI.OID_PERI 			  AND OP_REC.CARE_OID_CABE_RECL = CAB_REC.OID_CABE_RECL 			  AND LIN_REC.PROD_OID_PROD = PRO.OID_PROD 			  AND OP_REC.TIOP_OID_TIPO_OPER = T_OP.OID_TIPO_OPER 			  AND T_OP.ROPE_OID_OPER = OP.OID_OPER 			  AND PERI.FEC_INIC >= PER_INI.FEC_INIC 			AND PERI.FEC_FINA  < = PER_FIN.FEC_FINA 			  AND OD.OCAT_OID_CATAL = CATA.OID_CATA(+) 		      AND OP_REC.OID_OPER_RECL = LIN_REC.OPRE_OID_OPER_RECL 			     	 AND un_neg.OID_UNID_NEGO IN ( 1 )    			  AND cab_rec.PAIS_OID_PAIS =  1 	 	 			  AND PERI.MARC_OID_MARC = 1  			  AND PERI.CANA_OID_CANA =  1  		  	AND OP.OID_OPER =  32  		 		  	 AND CATA.OID_CATA IN ( 1 )  		GROUP BY CAB_REC.PAIS_OID_PAIS, 			  	 PERI.OID_PERI, 			     PERI.VAL_NOMB_PERI, 				 un_neg.OID_UNID_NEGO,	    				 OP.OID_OPER, 				 PRO.OID_PROD, 				 PRO.COD_SAP, 				 T_OP.OID_TIPO_OPER      		ORDER BY PAIS_OID_PAIS, 				 VAL_NOMB_PERI, 				 UN_NEG.OID_UNID_NEGO, 				 OP.OID_OPER, 				 PRO.OID_PROD, 				 T_OP.OID_TIPO_OPER 		) DETALLE,		  		(			  		SELECT *		  		FROM		  		( 		  			SELECT CAB_REC.PAIS_OID_PAIS, 				   PERI.OID_PERI, 				   PERI.VAL_NOMB_PERI, 				   un_NEG.OID_UNID_NEGO, 				   OP.OID_OPER, 				   PRO.OID_PROD, 				   PRO.COD_SAP, 				   SUM(NVL(FAC_LIN.NUM_UNID_ATEN, 0)) UNI_FACTURADAS, 				   SUM(NVL(LIN_REC.NUM_UNID_RECL, 0)) UNI_RECLAMADAS, 				   DECODE(SUM(NVL(FAC_LIN.NUM_UNID_ATEN, 0)), 0, 0,SUM(NVL(LIN_REC.NUM_UNID_RECL, 0))/SUM(NVL(FAC_LIN.NUM_UNID_ATEN, 0)))*100 PORC, 				   SUM(1) OVER (PARTITION BY CAB_REC.PAIS_OID_PAIS, PERI.VAL_NOMB_PERI, UN_NEG.OID_UNID_NEGO, OP.OID_OPER ORDER BY SUM(NVL(LIN_REC.NUM_UNID_RECL, 0)) DESC, COD_SAP) CONTROL 	    			FROM PRE_MATRI_FACTU MAT, 				 PRE_OFERT_DETAL OD, 				 MAE_PRODU PRO, 				 mae_unida_negoc un_neg, 				 REC_CABEC_RECLA CAB_REC, 				 CRA_PERIO PERI, 				 REC_OPERA_RECLA OP_REC, 				 REC_OPERA OP, 				 REC_TIPOS_OPERA T_OP, 				 FAC_DOCUM_CONTA_CABEC FAC, 				 FAC_DOCUM_CONTA_LINEA FAC_LIN, 				 REC_LINEA_OPERA_RECLA LIN_REC, 				 PRE_CATAL CATA, 				( 				 SELECT FEC_INIC 				 FROM CRA_PERIO 				  WHERE OID_PERI =  57 	 			 				)PER_INI, 				( 				 SELECT FEC_FINA 				 FROM CRA_PERIO 				  WHERE OID_PERI = DECODE( -1 ,-1,  57 , -1 ) 				)PER_FIN 			WHERE MAT.OFDE_OID_DETA_OFER = OD.OID_DETA_OFER 				  AND OD.PROD_OID_PROD = PRO.OID_PROD 				  AND PRO.UNEG_OID_UNID_NEGO = un_neg.OID_UNID_NEGO 			      AND CAB_REC.SOCA_OID_SOLI_CABE = FAC.SOCA_OID_SOLI_CABE(+) 				  AND FAC.OID_CABE = FAC_LIN.DCCA_OID_CABE(+) 				  AND CAB_REC.PERD_OID_PERI_DOCU_REFE = PERI.OID_PERI 				  AND OP_REC.CARE_OID_CABE_RECL = CAB_REC.OID_CABE_RECL 				  AND LIN_REC.PROD_OID_PROD = PRO.OID_PROD 				  AND OP_REC.TIOP_OID_TIPO_OPER = T_OP.OID_TIPO_OPER 				  AND T_OP.ROPE_OID_OPER = OP.OID_OPER 				  AND PERI.FEC_INIC >= PER_INI.FEC_INIC 				  AND PERI.FEC_FINA  < = PER_FIN.FEC_FINA 				  AND OD.OCAT_OID_CATAL = CATA.OID_CATA(+) 			      AND OP_REC.OID_OPER_RECL = LIN_REC.OPRE_OID_OPER_RECL 		   AND un_neg.OID_UNID_NEGO IN ( 1 )   			   	 			  	  AND cab_rec.PAIS_OID_PAIS =  1 	 	 			  	  AND PERI.MARC_OID_MARC = 1  				  AND PERI.CANA_OID_CANA =  1  		  AND OP.OID_OPER =  32  		 		  	   AND CATA.OID_CATA IN ( 1 )   			GROUP BY CAB_REC.PAIS_OID_PAIS, 				  	 PERI.OID_PERI, 				     PERI.VAL_NOMB_PERI, 				     un_NEG.OID_UNID_NEGO, 				     OP.OID_OPER, 					 PRO.OID_PROD, 				     PRO.COD_SAP 			ORDER BY PAIS_OID_PAIS, 					 VAL_NOMB_PERI, 					 OP.OID_OPER, 					 un_NEG.OID_UNID_NEGO, 					 PRO.OID_PROD, 					 PORC DESC  			) 		) CABECERA, 	( 		SELECT GEN.VAL_OID, GEN.VAL_I18N 		FROM V_GEN_I18N_SICC GEN 		WHERE GEN.ATTR_ENTI = 'MAE_PRODU' 			  AND GEN.IDIO_OID_IDIO =  1  	) GEN_PRODU, 	( 		SELECT GEN.VAL_OID, GEN.VAL_I18N 		FROM V_GEN_I18N_SICC GEN 		WHERE GEN.ATTR_ENTI = 'SEG_PAIS' 			  AND GEN.IDIO_OID_IDIO =  1  	) GEN_PAIS, 	( 		SELECT GEN.VAL_OID, GEN.VAL_I18N 		FROM V_GEN_I18N_SICC GEN 		WHERE GEN.ATTR_ENTI = 'REC_TIPOS_OPERA' 			  AND GEN.IDIO_OID_IDIO =  1  	) GEN_T_OP,	  	( 		SELECT GEN.VAL_OID, GEN.VAL_I18N 		FROM V_GEN_I18N_SICC GEN 		WHERE GEN.ATTR_ENTI = 'REC_OPERA' 			  AND GEN.IDIO_OID_IDIO =  1  	) GEN_OP,	  	( 		SELECT GEN.VAL_OID, GEN.VAL_I18N 		FROM V_GEN_I18N_SICC GEN 		WHERE GEN.ATTR_ENTI = 'MAE_UNIDA_NEGOC' 			  AND GEN.IDIO_OID_IDIO =  1  	) GEN_UN_NEGO	 WHERE DETALLE.OID_PERI = CABECERA.OID_PERI 	  AND DETALLE.OID_UNID_NEGO = CABECERA.OID_UNID_NEGO 	  AND DETALLE.OID_OPER = CABECERA.OID_OPER 	  AND DETALLE.OID_PROD = CABECERA.OID_PROD 	  AND CABECERA.PAIS_OID_PAIS = GEN_PAIS.VAL_OID(+)  	  AND CABECERA.OID_UNID_NEGO = GEN_UN_NEGO.VAL_OID(+) 	  AND CABECERA.OID_OPER = GEN_OP.VAL_OID(+) 	  AND CABECERA.OID_PROD = GEN_PRODU.VAL_OID(+) 	  AND DETALLE.OID_TIPO_OPER = GEN_T_OP.VAL_OID(+) 	  AND CABECERA.CONTROL  < =  23  ORDER BY  GEN_PAIS.VAL_I18N, 		   CABECERA.VAL_NOMB_PERI, 		   GEN_UN_NEGO.VAL_I18N, 		   GEN_OP.VAL_I18N, 		   CABECERA.UNI_RECLAMADAS ) DATOS