 SELECT 	subg.DES_SUBG_VENT AS subgerencia, 	reg.DES_REGI, 	zon.DES_ZONA, 	con.NUM_CONC, 	con.VAL_NOMB AS concurso, 	per_ini.val_nomb_peri AS periodo_ini, 	per_fin.val_nomb_peri AS periodo_fin, 	COUNT(DISTINCT cli_recte.oid_clie) over (PARTITION BY subg.des_subg_vent, reg.des_regi, zon.des_zona, num_conc)AS total_cli_recte_conc,	    	cli_recte.cod_clie AS cod_cli_recte, 	cli_recte.VAL_NOM1||' '||cli_recte.VAL_APE1 AS nom_cli_recte, 	COUNT(DISTINCT cli_recdo.oid_clie) over (PARTITION BY subg.des_subg_vent, reg.des_regi, zon.des_zona, num_conc)AS total_cli_recdo_conc,		 	cli_recdo.cod_clie AS cod_cli_recdo, 	cli_recdo.val_nom1||' '||cli_recdo.val_ape2 AS nom_cli_recdo, 	niv.NUM_NIVE, 	v_pre.TIPO_PREMIO||' '||v_pre.DESCRIPCION||' '||v_pre.cantidad AS premio, 	COUNT(DISTINCT v_pre.NUM_PREM) over (PARTITION BY subg.des_subg_vent, reg.des_regi, zon.des_zona, num_conc) AS cant_tot_pre_conc, 	gan.NUM_UNID FROM 	inc_concu_param_gener con, 	inc_param_gener_premi pre, 	inc_param_nivel_premi niv, 	cra_perio per_ini, 	cra_perio per_fin, 	inc_clien_recte recte, 	inc_clien_recdo recdo, 	mae_clien cli_recte, 	mae_clien cli_recdo, 	inc_ganad gan, 	v_rep_premios v_pre, 	mae_clien_unida_admin un_adm, 	zon_terri_admin ter_adm, 	zon_secci sec, 	zon_zona zon, 	zon_regio reg, 	zon_sub_geren_venta subg WHERE 	con.PERD_OID_PERI_DESD = per_ini.oid_peri 	AND con.IND_ACTI = 1 	AND con.PERD_OID_PERI_HAST = per_fin.oid_peri 	AND recte.COPA_OID_PARA_GRAL = con.OID_PARA_GRAL 	AND recte.OID_CLIE_RETE = recdo.CLR3_OID_CLIE_RETE 	AND recte.CLIE_OID_CLIE = cli_recte.oid_clie 	AND recdo.clie_oid_clie = cli_recdo.oid_clie 	AND recdo.IND_EFEC = 1 	AND gan.CLIE_OID_CLIE = recte.clie_oid_clie 	AND con.OID_PARA_GRAL = pre.COPA_OID_PARA_GRAL 	AND pre.OID_PARA_GENE_PREM = niv.PAGP_OID_PARA_GENE_PREM 	AND niv.OID_PARA_NIVE_PREM = gan.PANP_OID_PARA_NIVE_PREM 	AND niv.OID_PARA_NIVE_PREM = v_pre.OID_PARA_NIVE_PREM 	AND v_pre.IDIO_TIPO_PREMIO IN ( 1 ,NULL) 	AND un_adm.IND_ACTI = 1 	AND cli_recte.OID_CLIE = un_adm.clie_oid_clie 	AND un_adm.ZTAD_OID_TERR_ADMI = ter_adm.OID_TERR_ADMI 	AND ter_adm.ZSCC_OID_SECC = sec.OID_SECC 	AND sec.ZZON_OID_ZONA = zon.oid_zona 	AND zon.ZORG_OID_REGI = reg.oid_regi 	AND reg.ZSGV_OID_SUBG_VENT = subg.oid_subg_vent 	    AND reg.ZSGV_OID_SUBG_VENT IN  ( 1 )    	   AND reg.OID_REGI IN  ( 1 )    	   AND zon.OID_ZONA IN  ( 1 )    	AND con.pais_oid_pais =  1  	AND con.marc_oid_marc =   1 	  	AND con.cana_oid_cana =   1 	 	AND con.NUM_CONC IN ( '1' ) ORDER BY    subg.des_subg_vent,    reg.des_regi,    zon.des_zona,    con.num_conc,    cli_recte.cod_clie,    v_pre.tipo_premio|| ' '|| v_pre.descripcion|| ' '|| v_pre.cantidad 	 		 