 		 SELECT 	subgerencia, 	region, 	zona, 	territorio, 	num_concurso, 	desc_concurso, 	camp_ini_concu, 	camp_fin_concu, 	tipo_venta, 	nivel, 	cod_cliente, 	nombre, 	desc_premio, 	cantidad, 	camp_despacho, 	CASE 		WHEN (control = 1)  THEN 			venta_concurso 	END 		venta_concurso, 	DECODE(control,1,1,null) AS cuenta, 	ROWNUM AS num_fila FROM 	( 	SELECT 		subg.des_subg_vent AS subgerencia, 		reg.des_regi AS region, 		zona.des_zona AS zona, 		ter.cod_terr AS territorio, 		con_gen.num_conc AS num_concurso, 		con_gen.val_nomb AS desc_concurso, 		peri1.val_nomb_peri AS camp_ini_concu, 		peri2.val_nomb_peri AS camp_fin_concu, 		gen_tv.val_i18n AS tipo_venta, 		par_niv.num_nive AS nivel, 		cli.cod_clie AS cod_cliente, 		cli.val_nom1||' '||cli.val_nom2||' '||cli.val_ape1||' '||cli.val_ape2 AS nombre, 		DECODE(vista.oid_tipo_prem,2,'',vista.tipo_premio||' ') 				||vista.descripcion||' '||vista.cantidad 			AS desc_premio, 		gan.num_unid AS cantidad, 		peri3.val_nomb_peri AS camp_despacho, 		pq_apl_rep.fn_083_cu_obt_venta(con_gen.oid_para_gral,cli_ua.clie_oid_clie,pla_con.tven_oid_tipo_vent) 			AS venta_concurso, 		SUM(1) OVER 				(PARTITION BY subg.des_subg_vent, reg.des_regi, zona.des_zona, 					ter.cod_terr, con_gen.num_conc, par_niv.num_nive, cli.cod_clie 				ORDER BY ROWNUM) 			AS control 	FROM 		inc_concu_param_gener con_gen, 		inc_param_gener_premi par_gen, 		inc_param_nivel_premi par_niv, 		inc_plant_concu pla_con, 		inc_ganad gan, 		zon_sub_geren_venta subg, 		zon_regio reg, 		zon_zona zona, 		zon_secci sec, 		zon_terri_admin ter_adm, 		zon_terri ter, 		mae_clien_unida_admin cli_ua, 		mae_clien cli, 		v_rep_premios vista, 		cra_perio peri1, 		cra_perio peri2, 		cra_perio peri3, 		( 		SELECT gen.val_oid, gen.val_i18n 		FROM v_gen_i18n_sicc gen 		WHERE gen.attr_enti = 'INC_TIPO_VENTA' 		   AND gen.idio_oid_idio =  1  		) gen_tv	  	WHERE 		con_gen.plc2_oid_plan_conc = pla_con.oid_plan_conc 		AND par_gen.copa_oid_para_gral = con_gen.oid_para_gral 		AND par_gen.oid_para_gene_prem = par_niv.pagp_oid_para_gene_prem  		AND gan.panp_oid_para_nive_prem = par_niv.oid_para_nive_prem 		AND gan.perd_oid_peri = peri3.oid_peri 		AND subg.oid_subg_vent = reg.zsgv_oid_subg_vent 		AND reg.oid_regi = zona.zorg_oid_regi 		AND zona.oid_zona = sec.zzon_oid_zona 		AND sec.oid_secc = ter_adm.zscc_oid_secc 		AND ter.oid_terr = ter_adm.terr_oid_terr 		AND cli_ua.ztad_oid_terr_admi = ter_adm.oid_terr_admi 		AND cli_ua.clie_oid_clie = gan.clie_oid_clie 		AND par_niv.oid_para_nive_prem = vista.oid_para_nive_prem 		AND con_gen.perd_oid_peri_desd = peri1.oid_peri 		AND con_gen.perd_oid_peri_hast = peri2.oid_peri 		AND pla_con.tven_oid_tipo_vent = gen_tv.val_oid 		AND cli_ua.clie_oid_clie = cli.oid_clie 		AND cli_ua.ind_acti = 1 		AND con_gen.ind_acti = 1 		AND (vista.idio_tipo_premio =  1  OR vista.idio_tipo_premio IS NULL) 		AND pla_con.tven_oid_tipo_vent =  1  		AND con_gen.num_conc IN ( '1','2','3','4','5','6','7','8','9','10','11','12','05/002' ) 		AND par_niv.num_nive IN ( 1,2,3,4,5,6,7,8,9 ) 		AND con_gen.pais_oid_pais =  1  		 AND subg.oid_subg_vent IN ( 1 )  		 AND reg.oid_regi IN ( 1 )  		 AND zona.oid_zona IN ( 1 )  		 AND ter.oid_terr IN ( 1 ) 	  	   	) ORDER BY 	subgerencia, 	region, 	zona, 	territorio, 	num_concurso, 	cod_cliente  		 	