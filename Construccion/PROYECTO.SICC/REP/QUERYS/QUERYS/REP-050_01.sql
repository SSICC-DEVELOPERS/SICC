 SELECT 	DES_SUBG_VENT, 	DES_REGI, 	DES_ZONA, 	cod_clie, 	nombre_completo, 	pais, 	direccion, 	telefono, 	NUM_DOCU_IDEN, 	nivel, 	num_conc, 	descripcion, 	periodo_inicio, 	periodo_fin, 	val_nomb_peri, 	DENSE_RANK() OVER (PARTITION BY 		num_conc, 		descripcion, 		DES_SUBG_VENT, 		DES_REGI, 		DES_ZONA, 		nivel 	ORDER BY cod_clie ASC) AS nro_correlativo, 	SUM(puntos_totales)AS puntos FROM  	( 	SELECT 		subg.DES_SUBG_VENT, 		reg.DES_REGI, 		zon.DES_ZONA, 		cli.cod_clie, 		gen_pais.pais,  		cli.VAL_NOM1||' '||cli.VAL_APE1||' '||cli.VAL_APE2 AS nombre_completo, 		cli_dir.VAL_NOMB_VIA||' '||cli_dir.NUM_PPAL AS direccion, 		cli_com.VAL_TEXT_COMU AS telefono, 		cli_id.NUM_DOCU_IDEN, 		CASE 			WHEN cc_pun.TMOV_OID_TIPO_MOVI = 1 OR ( cc_pun.TMOV_OID_TIPO_MOVI = 2 AND ( par_gen.IND_ANUL = 1 OR par_gen.IND_DEVO = 1) ) OR cc_pun.TMOV_OID_TIPO_MOVI = 3 THEN  				SUM(cc_pun.NUM_PUNT) 			ELSE 0 		END AS puntos_totales, 		niv_pre.NUM_NIVE AS nivel, 		par_gen.NUM_CONC, 		par_gen.val_nomb as descripcion, 		per_ini.val_nomb_peri AS periodo_inicio, 		per_fin.val_nomb_peri AS periodo_fin, 		per.val_nomb_peri 	FROM 		inc_concu_param_gener par_gen, 		inc_param_gener_premi gen_pre, 		cra_perio per_ini, 		cra_perio per_fin, 		inc_ganad gan, 		inc_param_nivel_premi niv_pre, 		inc_cuent_corri_punto cc_pun,	  		inc_premi_monet pre_mon, 		mae_clien_direc cli_dir, 		mae_clien_unida_admin un_adm, 		mae_clien cli, 		mae_clien_comun cli_com, 		mae_clien_ident cli_id, 		mae_tipo_comun tip_com, 		zon_terri_admin ter_adm, 		zon_terri ter, 		zon_secci sec, 		zon_zona zon, 		zon_regio reg, 		zon_sub_geren_venta subg, 		cra_perio per, 		( 		SELECT val_oid, val_i18n pais 		FROM v_gen_i18n_sicc 		WHERE attr_enti = 'SEG_PAIS' 			AND idio_oid_idio =  1  		)gen_pais 	WHERE 		par_gen.OID_PARA_GRAL = gen_pre.COPA_OID_PARA_GRAL 		AND par_gen.PERD_OID_PERI_DESD = per_ini.oid_peri 		AND par_gen.PERD_OID_PERI_HAST = per_fin.oid_peri 		AND niv_pre.PAGP_OID_PARA_GENE_PREM = gen_pre.OID_PARA_GENE_PREM 		AND gan.PANP_OID_PARA_NIVE_PREM = niv_pre.OID_PARA_NIVE_PREM 		AND un_adm.clie_oid_clie = gan.clie_oid_clie 		AND un_adm.clie_oid_clie = cli.oid_clie 		AND cli.oid_clie = cli_id.CLIE_OID_CLIE 		AND cli_id.VAL_IDEN_DOCU_PRIN = 1 		AND cli.oid_clie = cli_com.clie_oid_clie(+) 		AND cli_com.TICM_OID_TIPO_COMU = tip_com.OID_TIPO_COMU 		AND tip_com.COD_TIPO_COMU = 'TF' 		AND cli.oid_clie = cli_dir.clie_oid_clie(+) 		AND cli_dir.IND_DIRE_PPAL = 1 		AND cc_pun.COPA_OID_PARA_GRAL = par_gen.OID_PARA_GRAL  		AND un_adm.IND_ACTI = 1 		AND un_adm.ZTAD_OID_TERR_ADMI = ter_adm.OID_TERR_ADMI 		AND ter_adm.ZSCC_OID_SECC = sec.OID_SECC 		AND sec.ZZON_OID_ZONA = zon.OID_ZONA 		AND zon.ZORG_OID_REGI = reg.OID_REGI 		AND reg.ZSGV_OID_SUBG_VENT = subg.OID_SUBG_VENT 		AND cc_pun.PERD_OID_PERI = per.oid_peri 		AND ter_adm.TERR_OID_TERR = ter.OID_TERR 		      AND subg.OID_SUBG_VENT IN ( 1 )   		   AND reg.oid_regi IN  ( 1 )    		      AND zon.OID_ZONA IN ( 1 )    		AND par_gen.NUM_CONC IN ( '1' )  		AND par_gen.pais_oid_pais IN ( 1 )  		AND par_gen.pais_oid_pais = gen_pais.val_oid(+) 		AND niv_pre.NUM_NIVE IN ( 1,2 )  	GROUP BY cc_pun.TMOV_OID_TIPO_MOVI, 		par_gen.IND_ANUL, 		cli.cod_clie, 		cli.VAL_NOM1||' '||cli.VAL_APE1||' '||cli.VAL_APE2, 		cli_dir.VAL_NOMB_VIA||' '||cli_dir.NUM_PPAL, 		cli_com.VAL_TEXT_COMU, 		cli_id.NUM_DOCU_IDEN, 		niv_pre.NUM_NIVE, 		par_gen.NUM_CONC, 		par_gen.IND_DEVO, 		par_gen.val_nomb, 		per_ini.val_nomb_peri, 		per_fin.val_nomb_peri, 		per.val_nomb_peri, 		gen_pais.pais, 		subg.DES_SUBG_VENT, 		reg.DES_REGI, 		zon.DES_ZONA 	)	   GROUP BY 	cod_clie, 	nombre_completo, 	direccion, 	telefono, 	nivel, 	num_conc, 	descripcion, 	periodo_inicio, 	periodo_fin, 	val_nomb_peri, 	NUM_DOCU_IDEN, 	pais, 	DES_SUBG_VENT, 	DES_REGI, 	DES_ZONA ORDER BY 	pais, 	num_conc, 	descripcion, 	DES_SUBG_VENT, 	DES_REGI, 	DES_ZONA, 	cod_clie, 	nombre_completo ASC 		