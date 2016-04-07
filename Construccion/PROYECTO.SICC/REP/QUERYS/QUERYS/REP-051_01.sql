 		 SELECT 	NUM_CONC, 	concurso, 	NUM_NIVE, 	per_desde, 	per_hasta, 	per_cc, 	cod_clie, 	apyno, 	NUM_PREM, 	descripcion, 	per_despacho, 	boleta_despacho, 	FEC_CRON, 	pais, 	DES_SUBG_VENT, 	DES_REGI, 	DES_ZONA, 	DENSE_RANK() OVER 		( 		PARTITION BY 			num_conc, 			descripcion, 			DES_SUBG_VENT, 			DES_REGI, 			DES_ZONA, 			num_nive 		ORDER BY 			cod_clie ASC 		) AS nro_correlativo, 	COUNT(DISTINCT COD_CLIE) OVER 		( 		PARTITION BY 			num_conc, 			concurso, 			DES_SUBG_VENT, 			DES_REGI, 			DES_ZONA, 			num_nive, 			descripcion 		) AS cant_por_desc, 	SUM(puntos_totales) AS puntos FROM 	( 	SELECT 		gen_pais.pais, 		subg.DES_SUBG_VENT, 		reg.DES_REGI, 		zon.DES_ZONA, 		con.NUM_CONC, 		con.VAL_NOMB AS concurso, 		niv_pre.NUM_NIVE, 		per_ini.VAL_NOMB_PERI AS per_desde, 		per_fin.VAL_NOMB_PERI AS per_hasta, 		per_cc.val_nomb_peri per_cc, 		cli.cod_clie, 		cli.VAL_NOM1||' '||cli.VAL_APE1||' '||cli.VAL_APE2 AS apyno, 		CASE 			WHEN cc.TMOV_OID_TIPO_MOVI = 1 					OR ( cc.TMOV_OID_TIPO_MOVI = 2 AND ( con.IND_ANUL = 1 OR con.IND_DEVO = 1) ) 					OR cc.TMOV_OID_TIPO_MOVI = 3 THEN  		   		SUM(cc.NUM_PUNT) 		   	ELSE 				0 		END 			AS puntos_totales, 		v_pre.NUM_PREM, 		v_pre.TIPO_PREMIO||' '||v_pre.descripcion||' '||v_pre.cantidad AS descripcion, 		per_desp.val_nomb_peri AS per_despacho, 		sol.VAL_NUME_SOLI AS boleta_despacho, 		sol.FEC_CRON, 		v_pre.OID_PARA_NIVE_PREM 	FROM 		inc_concu_param_gener con, 		inc_param_gener_premi par_gen_pre, 		inc_param_nivel_premi niv_pre, 		inc_ganad gan, 		inc_cuent_corri_punto cc, 		mae_clien_unida_admin un_adm, 		zon_sub_geren_venta subg, 		zon_regio reg, 		zon_zona zon, 		zon_secci sec, 		zon_terri_admin ter_adm, 		zon_terri ter, 		mae_clien cli, 		cra_perio per_ini, 		cra_perio per_fin, 		cra_perio per_cc, 		cra_perio per_desp, 		v_rep_premios v_pre, 		ped_solic_cabec sol, 		( 			SELECT val_oid, val_i18n pais 			FROM v_gen_i18n_sicc 			WHERE attr_enti = 'SEG_PAIS' 			  AND idio_oid_idio =   1  		)gen_pais 	WHERE 		con.OID_PARA_GRAL = par_gen_pre.COPA_OID_PARA_GRAL 		AND par_gen_pre.OID_PARA_GENE_PREM = niv_pre.PAGP_OID_PARA_GENE_PREM   		AND niv_pre.OID_PARA_NIVE_PREM = gan.PANP_OID_PARA_NIVE_PREM 		AND niv_pre.OID_PARA_NIVE_PREM = v_pre.OID_PARA_NIVE_PREM 		AND gan.clie_oid_clie = cc.clie_oid_clie 		AND un_adm.clie_oid_clie = cli.oid_clie 		AND un_adm.ZTAD_OID_TERR_ADMI = ter_adm.OID_TERR_ADMI 		AND ter_adm.ZSCC_OID_SECC = sec.OID_SECC 		AND sec.ZZON_OID_ZONA = zon.OID_ZONA 		AND zon.ZORG_OID_REGI = reg.OID_REGI 		AND reg.ZSGV_OID_SUBG_VENT = subg.OID_SUBG_VENT 		AND ter_adm.TERR_OID_TERR = ter.OID_TERR 		AND con.PERD_OID_PERI_DESD = per_ini.oid_peri 		AND con.PERD_OID_PERI_HAST = per_fin.oid_peri 		AND cc.PERD_OID_PERI = per_cc.oid_peri 		AND cc.COPA_OID_PARA_GRAL = con.OID_PARA_GRAL 		AND cc.CLIE_OID_CLIE = un_adm.clie_oid_clie 		AND con.pais_oid_pais = gen_pais.val_oid(+)  		AND con.IND_ACTI = 1 		AND un_adm.IND_ACTI = 1 		AND v_pre.OID_TIPO_PREM = 2 		AND con.OID_PARA_GRAL = sol.COPA_OID_PARA_GENE 		AND sol.CLIE_OID_CLIE = cc.clie_oid_clie 		AND sol.PERD_OID_PERI = per_desp.oid_peri 		AND v_pre.num_prem = sol.num_prem 			AND reg.ZSGV_OID_SUBG_VENT IN ( 1 )	 					AND reg.oid_regi IN  ( 1 )						  						AND zon.OID_ZONA IN ( 1 )						  		AND con.NUM_CONC IN ( '1' )  		AND niv_pre.OID_PARA_NIVE_PREM IN ( 5 )  		AND con.PAIS_OID_PAIS IN  ( 1 )  	GROUP BY 		con.OID_PARA_GRAL, 		cc.CLIE_OID_CLIE , 		con.NUM_CONC, 		niv_pre.NUM_NIVE, 		per_ini.VAL_NOMB_PERI, 		per_fin.VAL_NOMB_PERI, 		per_cc.val_nomb_peri, 		cli.cod_clie, 		cli.VAL_NOM1||' '||cli.VAL_APE1||' '||cli.VAL_APE2, 		v_pre.TIPO_PREMIO||' '||v_pre.descripcion||' '||v_pre.cantidad, 		per_desp.val_nomb_peri, 		sol.VAL_NUME_SOLI, 		sol.FEC_CRON, 		cc.TMOV_OID_TIPO_MOVI, 		con.IND_ANUL, 		con.IND_DEVO, 		con.VAL_NOMB, 		v_pre.NUM_PREM, 		v_pre.OID_PARA_NIVE_PREM, 		gen_pais.pais, 		subg.DES_SUBG_VENT, 		reg.DES_REGI, 		zon.DES_ZONA 	) GROUP BY 	NUM_CONC, 	NUM_NIVE, 	per_desde, 	per_hasta, 	per_cc, 	cod_clie, 	apyno, 	descripcion, 	per_despacho, 	boleta_despacho, 	FEC_CRON, 	concurso, 	num_prem, 	OID_PARA_NIVE_PREM, 	pais, 	DES_SUBG_VENT, 	DES_REGI, 	DES_ZONA ORDER BY 	pais, 	num_conc, 	descripcion, 	DES_SUBG_VENT, 	DES_REGI, 	DES_ZONA, 	cod_clie ASC			   				    