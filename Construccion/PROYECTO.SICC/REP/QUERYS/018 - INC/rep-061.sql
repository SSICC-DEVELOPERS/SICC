select subg.DES_SUBG_VENT as subgerencia,
	   reg.DES_REGI,
	   zon.DES_ZONA,
	   con.NUM_CONC,
	   con.VAL_NOMB as concurso,
	   per_ini.val_nomb_peri as periodo_ini,
	   per_fin.val_nomb_peri as periodo_fin,
	   count(distinct cli_recte.oid_clie) over (partition by num_conc)as total_cli_recte_conc,
	   cli_recte.cod_clie as cod_cli_recte,
	   cli_recte.VAL_NOM1||' '||cli_recte.VAL_APE1 as nom_cli_recte,
	   count(distinct cli_recdo.oid_clie) over (partition by num_conc)as total_cli_recdo_conc,
	   cli_recdo.cod_clie as cod_cli_recdo,
	   cli_recdo.val_nom1||' '||cli_recdo.val_ape2 as nom_cli_recdo,
	   niv.NUM_NIVE,
	   v_pre.TIPO_PREMIO||' '||v_pre.DESCRIPCION||' '||v_pre.cantidad as premio,
	   count(distinct v_pre.NUM_PREM) over (partition by num_conc) as cant_tot_pre_conc,
	   gan.NUM_UNID
from inc_concu_param_gener con,
	 inc_param_gener_premi pre,
	 inc_param_nivel_premi niv,
	 cra_perio per_ini,
	 cra_perio per_fin,
	 inc_clien_recte recte,
	 inc_clien_recdo recdo,
	 mae_clien cli_recte,
	 mae_clien cli_recdo,
	 inc_ganad gan,
	 v_rep_premios v_pre,
	 mae_clien_unida_admin un_adm,
	 zon_terri_admin ter_adm,
	 zon_secci sec,
	 zon_zona zon,
	 zon_regio reg,
	 zon_sub_geren_venta subg
where
	 con.PERD_OID_PERI_DESD = per_ini.oid_peri
	 and con.IND_ACTI = 1
	 and con.PERD_OID_PERI_HAST = per_fin.oid_peri
	 and recte.COPA_OID_PARA_GRAL = con.OID_PARA_GRAL
	 and recte.OID_CLIE_RETE = recdo.CLR3_OID_CLIE_RETE
	 and recte.CLIE_OID_CLIE = cli_recte.oid_clie
	 and recdo.clie_oid_clie = cli_recdo.oid_clie
	 and recdo.IND_EFEC = 1
	 and gan.CLIE_OID_CLIE = recte.clie_oid_clie
	 and con.OID_PARA_GRAL = pre.COPA_OID_PARA_GRAL
	 and pre.OID_PARA_GENE_PREM = niv.PAGP_OID_PARA_GENE_PREM
	 and niv.OID_PARA_NIVE_PREM = gan.PANP_OID_PARA_NIVE_PREM
	 and niv.OID_PARA_NIVE_PREM = v_pre.OID_PARA_NIVE_PREM
--	 and v_pre.IDIO_TIPO_PREMIO = 1
	 and un_adm.IND_ACTI = 1
	 and cli_recte.OID_CLIE = un_adm.clie_oid_clie
	 and un_adm.ZTAD_OID_TERR_ADMI = ter_adm.OID_TERR_ADMI
	 and ter_adm.ZSCC_OID_SECC = sec.OID_SECC
	 and sec.ZZON_OID_ZONA = zon.oid_zona
	 and zon.ZORG_OID_REGI = reg.oid_regi
	 and reg.ZSGV_OID_SUBG_VENT = subg.oid_subg_vent
/*	 and reg.ZSGV_OID_SUBG_VENT in (1) --PARAMETRO SUBGERENCIA--
	 and reg.OID_REGI in (1) --PARAMETRO REGION--
	 and zon.OID_ZONA in (1) --PARAMETRO ZONA--
	 and con.pais_oid_pais = 1 --PARAMETRO PAIS--
	 and con.marc_oid_marc = 1 --PARAMETRO MARCA--
	 and con.cana_oid_cana = 1 --PARAMETRO CANAL--
	 and con.NUM_CONC in (1) --PARAMETRO NUMERO CONCURSO--*/