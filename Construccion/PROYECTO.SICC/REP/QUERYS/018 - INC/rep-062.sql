select subg.DES_SUBG_VENT,
	   reg.DES_REGI,
	   zon.DES_ZONA,
	   ter.COD_TERR,
	   con.NUM_CONC,
	   con.VAL_NOMB,
   	   gen_incum.motivo_incum,
	   per_ini.val_nomb_peri as periodo_inicial,
	   per_fin.val_nomb_peri as periodo_fina,
   	   cli_recte.cod_clie as cod_clie_recte,
   	   cli_recte.VAL_APE1||' '||cli_recte.val_ape2||' '||cli_recte.VAL_NOM1 as nombre_recte,
	   cli_recdo.cod_clie as cod_clie_recdo,
	   cli_recdo.VAL_APE1||' '||cli_recdo.val_ape2||' '||cli_recdo.VAL_NOM1 as nombre_recdo,
	   per_ingre.val_nomb_peri as periodo_ingreso,
	   cli_id.NUM_DOCU_IDEN,
	   count(distinct cli_recte.oid_clie) over (partition by num_conc, can_gan.BINC_OID_BASE_INCU)cons_mot_incum,
	   count(distinct can_gan.BINC_OID_BASE_INCU) over (partition by subg.DES_SUBG_VENT, reg.DES_REGI, zon.DES_ZONA, ter.COD_TERR) incum_un_adm
from inc_concu_param_gener con,
	 inc_candi_ganad can_gan,
	 inc_clien_recdo recdo,
	 inc_clien_recte recte,
	 cra_perio per_ini,
	 cra_perio per_fin,
	 cra_perio per_ingre,
	 mae_clien cli_recdo,
	 mae_clien cli_recte,
	 mae_clien_ident cli_id,
	 mae_clien_unida_admin un_adm,
	 zon_terri_admin ter_adm,
	 zon_terri ter,
	 zon_secci sec,
	 zon_zona zon,
	 zon_regio reg,
	 zon_sub_geren_venta subg,
	 (
	  select val_oid, val_i18n motivo_incum
	  from v_gen_i18n_sicc
	  where attr_enti = 'INC_BASE_INCUM'
	  		and idio_oid_idio = 1 --PARAMETRO IDIOMA--
	 )gen_incum
where
	 con.PERD_OID_PERI_DESD = per_ini.oid_peri
	 and con.PERD_OID_PERI_HAST = per_fin.oid_peri
/*	 and con.pais_oid_pais = 1 --PARAMETRO PAIS--
	 and con.marc_oid_marc = 1 --PARAMETRO MARCA--
	 and con.cana_oid_cana = 1 --PARAMETRO CANAL--*/
	 and recdo.CLR3_OID_CLIE_RETE = recte.clie_oid_clie
	 and recdo.clie_oid_clie = cli_recdo.oid_clie
--	 and recdo.IND_EFEC <> 1
	 and recte.clie_oid_clie = cli_recte.oid_clie
	 and con.OID_PARA_GRAL = recte.COPA_OID_PARA_GRAL 
	 and recdo.PERD_OID_PERI = per_ingre.oid_peri
	 and recdo.clie_oid_clie = un_adm.clie_oid_clie
	 and un_adm.IND_ACTI = 1
	 and un_adm.ZTAD_OID_TERR_ADMI = ter_adm.OID_TERR_ADMI
	 and ter_adm.TERR_OID_TERR = ter.OID_TERR
	 and ter_adm.ZSCC_OID_SECC = sec.OID_SECC
	 and sec.ZZON_OID_ZONA = zon.oid_zona
	 and zon.ZORG_OID_REGI = reg.oid_regi
	 and reg.ZSGV_OID_SUBG_VENT = subg.OID_SUBG_VENT 
/*	 and subg.OID_SUBG_VENT in (1) --PARAMETRO SUBGERENCIA--
	 and reg.oid_regi in (1) --PARAMETRO REGION--
	 and zon.oid_zona in (1) --PARAMETRO ZONA--*/
	 and cli_recdo.OID_CLIE = cli_id.CLIE_OID_CLIE(+)
	 and cli_id.VAL_IDEN_DOCU_PRIN(+) = 1
--	 and con.NUM_CONC  in ('1') --PARAMETRO NUMERO DE CONCURSO--
	 and recte.CLIE_OID_CLIE = can_gan.CLIE_OID_CLIE
	 and recte.COPA_OID_PARA_GRAL = can_gan.COPA_OID_PARA_GRAL
	 and recdo.PERD_OID_PERI = can_gan.PERD_OID_PERI_EVAL
	 and can_gan.BINC_OID_BASE_INCU = gen_incum.val_oid(+)
	 and can_gan.BINC_OID_BASE_INCU in (1) --PARAMETRO MOTIVOS DE INCUMPLIMIENTO--