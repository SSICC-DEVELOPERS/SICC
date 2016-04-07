 SELECT 	NUM_CONC, 	DES_SUBG_VENT, 	COD_REGI, 	gerente_region, 	SUM(consultoras_con_metas) AS consultoras_con_metas, 	SUM(cons_ganadoras)AS cons_ganadoras, 	SUM(DECODE(consultoras_con_metas,0,0,cons_ganadoras / consultoras_con_metas) * 100) por_ganadoras FROM  	( 	SELECT  		con.NUM_CONC, 		subg.DES_SUBG_VENT, 		reg.COD_REGI, 		cli_reg.VAL_NOM1||' '||cli_reg.VAL_NOM2||' '||cli_reg.VAL_APE1||' '||cli_reg.VAL_APE2 AS gerente_region, 		COUNT(*) AS consultoras_con_metas, 		( 		   	SELECT 				COUNT(*) 			FROM 				inc_ganad gan, 				inc_param_nivel_premi niv, 				inc_param_gener_premi par_pre, 				mae_clien_unida_admin un_adm2 			WHERE 				gan.PANP_OID_PARA_NIVE_PREM = niv.OID_PARA_NIVE_PREM 				AND niv.PAGP_OID_PARA_GENE_PREM = par_pre.OID_PARA_GENE_PREM 				AND par_pre.COPA_OID_PARA_GRAL = con.OID_PARA_GRAL  				AND gan.CLIE_OID_CLIE = un_adm2.CLIE_OID_CLIE 				AND un_adm2.ZTAD_OID_TERR_ADMI = ter_adm.OID_TERR_ADMI 				AND un_adm2.ind_acti = 1 		) cons_ganadoras 	FROM 		mae_clien_unida_admin un_adm, 		mae_clien cli_reg, 		mae_clien cli_zon, 		zon_sub_geren_venta subg, 	 	zon_regio reg, 		zon_zona zon, 		zon_secci sec, 		zon_terri_admin ter_adm, 		inc_concu_param_gener con, 		( 			SELECT * 			FROM 				( 					( 						SELECT * 						FROM inc_metas_tipo_venta met2 						WHERE met2.copa_oid_para_gral =  1042   					) 					MINUS  					( 						SELECT 							met.* 						FROM 							inc_metas_tipo_venta met, 							inc_desca des, 							inc_causa_desca cau_des 						WHERE 							met.CLIE_OID_CLIE = des.clie_oid_clie 							AND met.COPA_OID_PARA_GRAL = des.COPA_OID_PARA_GRAL 							AND des.CADE_OID_CAUS_DESC = cau_des.OID_CAUS_DESC 							AND cau_des.COD_CAUS in ('FA','FC') 							AND met.COPA_OID_PARA_GRAL =  1042   					) 				) 		 ) cons_totales 	WHERE 		un_adm.ZTAD_OID_TERR_ADMI = ter_adm.OID_TERR_ADMI 		AND un_adm.IND_ACTI = 1 		AND con.IND_ACTI = 1 		AND ter_adm.ZSCC_OID_SECC = sec.OID_SECC 		AND sec.ZZON_OID_ZONA = zon.oid_zona 		AND zon.ZORG_OID_REGI = reg.oid_regi 		AND reg.ZSGV_OID_SUBG_VENT = subg.OID_SUBG_VENT 		AND cons_totales.clie_oid_clie = un_adm.clie_oid_clie 		AND cons_totales.COPA_OID_PARA_GRAL = con.OID_PARA_GRAL 		AND reg.clie_oid_clie = cli_reg.oid_clie(+) 		AND zon.clie_oid_clie = cli_zon.oid_clie(+) 	    and con.PAIS_OID_PAIS =   1   		and con.MARC_OID_MARC =   1   		and con.CANA_OID_CANA =  1  	 		and con.OID_PARA_GRAL =  1042   		 AND SUBG.OID_SUBG_VENT IN  ( 1 )  		  AND REG.OID_REGI IN ( 1 )   	GROUP BY 		con.NUM_CONC, 		subg.DES_SUBG_VENT, 		reg.COD_REGI, 		cli_reg.VAL_NOM1||' '||cli_reg.VAL_NOM2||' '||cli_reg.VAL_APE1||' '||cli_reg.VAL_APE2, 		con.OID_PARA_GRAL, 		ter_adm.OID_TERR_ADMI 	) GROUP BY 	NUM_CONC, 	DES_SUBG_VENT, 	COD_REGI, 	gerente_region 