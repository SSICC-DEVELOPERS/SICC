 SELECT 	num_conc, 	val_nomb, 	periodo_desde, 	periodo_hasta, 	grupo_desde, 	grupo_hasta, 	SUM(nro_consultoras)nro_consultoras, 	SUM(nro_consultoras) / total_consultoras * 100 AS por_consultoras, 	SUM( 		SUM(nro_consultoras) / total_consultoras * 100 		) over (PARTITION BY 					num_conc 				ORDER BY grupo_desde) 		AS por_acum,   	SUM(nro_variacion_1) AS nro_variacion_1, 	SUM(nro_variacion_1) / total_consultoras * 100 AS por_variacion_1, 	SUM(nro_variacion_2) AS nro_variacion_2, 	SUM(nro_variacion_2) / total_consultoras * 100 AS por_variacion_2, 	SUM(nro_variacion_3) AS nro_variacion_3, 	SUM(nro_variacion_3) / total_consultoras * 100 AS por_variacion_3, 	SUM(nro_variacion_4) AS nro_variacion_4, 	SUM(nro_variacion_4) / total_consultoras * 100 AS por_variacion_4, 	SUM(nro_variacion_5) AS nro_variacion_5, 	SUM(nro_variacion_5) / total_consultoras * 100 AS por_variacion_5, 	SUM(nro_variacion_6) AS nro_variacion_6, 	SUM(nro_variacion_6) / total_consultoras * 100 AS por_variacion_6 FROM 	( 	SELECT 		num_conc, 		val_nomb, 		periodo_desde, 		periodo_hasta, 		COUNT(clie_oid_clie) AS nro_consultoras, 		total_consultoras, 		grupo_desde, 		grupo_hasta, 		grupo, 		CASE 			WHEN por_variacion >   0              AND por_variacion  < =   20  				THEN COUNT(clie_oid_clie) 		END 			AS nro_variacion_1, 		CASE 			WHEN por_variacion >   20  	   	   	AND por_variacion  < =   40  				THEN COUNT(clie_oid_clie) 		END 			AS nro_variacion_2, 		CASE 			WHEN por_variacion >   40  		   	AND por_variacion  < =   60  				THEN COUNT(clie_oid_clie) 		END 			AS nro_variacion_3, 		CASE 			WHEN  por_variacion >   60   	   	    AND por_variacion  < =   80  				THEN COUNT(clie_oid_clie) 		END 			AS nro_variacion_4, 		CASE 			WHEN  por_variacion >   80   		    AND por_variacion  < =   100  				THEN COUNT(clie_oid_clie) 		END 			AS nro_variacion_5, 		CASE 			WHEN   por_variacion >   -1   		    AND por_variacion  < =   -1  				THEN COUNT(clie_oid_clie) 		END 			AS nro_variacion_6 	FROM 		( 		SELECT 			num_conc, 			val_nomb, 			periodo_desde, 			periodo_hasta, 			clie_oid_clie, 			COUNT(*) over ( PARTITION BY num_conc ) 				AS total_consultoras,  			CASE WHEN (monto_venta * 100) / meta  <  100 THEN 				100 - ((monto_venta * 100) / meta ) 			END 				AS por_variacion, 			PQ_APL_REP.FN_072_RANGO(meta) AS grupo, 			DECODE( 			   PQ_APL_REP.FN_072_RANGO(meta),1000, 			   PQ_APL_REP.FN_072_RANGO(meta), 			   PQ_APL_REP.FN_072_RANGO(meta) + 1)  AS grupo_desde, 			CASE WHEN PQ_APL_REP.FN_072_RANGO(meta)  <  3000 THEN 				PQ_APL_REP.FN_072_RANGO(meta) + 500 			ELSE 				PQ_APL_REP.FN_072_RANGO(meta) + 1000 			END 				AS grupo_hasta 			  		FROM 			( 			SELECT 				con.num_conc, 				con.val_nomb, 				per1.val_nomb_peri periodo_desde, 				per2.val_nomb_peri periodo_hasta,		      				con.OID_PARA_GRAL, 				un_adm.clie_oid_clie, 				pla_con.TVEN_OID_TIPO_VENT, 				met.val_meta * moneda.valor_moneda AS meta, 				PQ_APL_REP.FN_083_CU_OBT_VENTA (con.OID_PARA_GRAL, un_adm.clie_oid_clie, tip_vta.OID_TIPO_VENT) * moneda.valor_moneda AS monto_venta, 				( 					SELECT 						CASE WHEN SUM(can_gan.IND_META_SUPE) >= 1 THEN 							1 						ELSE 							0 						END 					FROM 						inc_candi_ganad can_gan 					WHERE 						can_gan.clie_oid_clie = un_adm.clie_oid_clie 						AND can_gan.copa_oid_para_gral = con.oid_para_gral 				)ind_meta_supe 			FROM 				inc_concu_param_gener con, 				inc_plant_concu pla_con, 				inc_tipo_venta tip_vta, 				inc_metas_tipo_venta met, 				mae_clien_unida_admin un_adm, 				mae_clien_tipo_subti tip_sub, 				mae_clien_clasi cla, 				zon_terri_admin ter_adm, 				zon_secci sec, 				zon_zona zon, 				zon_regio reg, 				zon_sub_geren_venta subg, 				seg_pais pai, 				cra_perio per1, 				cra_perio per2, 				(						 					SELECT 						CASE WHEN pais.mone_oid_mone =  2  							THEN 1 						ELSE 							( 								SELECT tip_cam.VAL_TIPO_CAMB 							   	FROM seg_tipo_cambi tip_cam 								WHERE tip_cam.MONE_OID_MON1 = pais.mone_oid_mone 								AND tip_cam.MONE_OID_MON2 =  2  								AND SYSDATE BETWEEN tip_cam.FEC_DESD AND tip_cam.FEC_HAST 							) 						END 							AS valor_moneda 					FROM 						seg_pais pais 					WHERE 						pais.oid_pais =  1   				) moneda 			WHERE 				con.PLC2_OID_PLAN_CONC = pla_con.OID_PLAN_CONC 				AND pla_con.TVEN_OID_TIPO_VENT = tip_vta.OID_TIPO_VENT 				AND con.OID_PARA_GRAL = met.COPA_OID_PARA_GRAL 				AND met.clie_oid_clie = un_adm.clie_oid_clie 				AND con.PERD_OID_PERI_DESD = per1.oid_peri 				AND con.PERD_OID_PERI_HAST = per2.oid_peri 				AND con.IND_ACTI = 1 				AND un_adm.IND_ACTI = 1 				AND un_adm.ZTAD_OID_TERR_ADMI = ter_adm.OID_TERR_ADMI 				AND ter_adm.ZSCC_OID_SECC = sec.OID_SECC 				AND sec.ZZON_OID_ZONA = zon.oid_zona 				AND zon.ZORG_OID_REGI = reg.oid_regi 				AND reg.ZSGV_OID_SUBG_VENT = subg.OID_SUBG_VENT 				AND un_adm.clie_oid_clie = tip_sub.clie_oid_clie 				AND tip_sub.IND_PPAL = 1  				AND tip_sub.OID_CLIE_TIPO_SUBT = cla.CTSU_OID_CLIE_TIPO_SUBT 				AND cla.IND_PPAL = 1 				AND con.pais_oid_pais = pai.OID_PAIS 				AND con.oid_para_gral =  1  				and con.pais_oid_pais =  1   				and con.marc_oid_marc = 1   				and con.cana_oid_cana =  1   				and tip_vta.OID_TIPO_VENT =  1   				  	    and tip_sub.TICL_OID_TIPO_CLIE in   ( 1 )    		 				  	and tip_sub.SBTI_OID_SUBT_CLIE in  ( 1 )   				 and cla.TCCL_OID_TIPO_CLASI in  ( 1 )   				  	and cla.CLAS_OID_CLAS in ( 1 )              			) 		WHERE ind_meta_supe  < > 1 		) 	GROUP BY 		num_conc, 		val_nomb, 		periodo_desde, 		periodo_hasta, 		por_variacion, 		grupo_desde, 		grupo_hasta, 		grupo, 		total_consultoras 	) WHERE 	grupo IN ( 1000,2500 )  GROUP BY 	num_conc, 	val_nomb, 	periodo_desde, 	periodo_hasta, 	grupo_desde, 	grupo_hasta, 	total_consultoras 	 			   