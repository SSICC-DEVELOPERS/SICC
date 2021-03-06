/*EN EL CASO DEL PARAMETRO "SELECCIONO PREMIO SI O NO" SE REMOVERA EL "not", EN CASO QUE NO VENGA ESTE PARAMETRO
SE LO REMOVERA NORMALMENTE*/

select con.NUM_CONC,
	   per1.VAL_NOMB_PERI as per_desde,
	   per2.VAL_NOMB_PERI as per_hasta,
	   gen_pais.pais,
	   subg.DES_SUBG_VENT,
	   reg.DES_REGI,
	   zon.des_zona,
   	   ter.COD_TERR,
	   cli.cod_clie,
	   cli.VAL_APE1||' '||cli.VAL_APE2||' '||cli.VAL_NOM1 as apyno,
	   v_pre.TIPO_PREMIO||' '||v_pre.DESCRIPCION||' '||v_pre.cantidad as descripcion,
	   sum(gan.NUM_UNID) as cantidad,
	   count(*) over (partition by con.OID_PARA_GRAL, zon.des_zona, v_pre.TIPO_PREMIO||' '||v_pre.DESCRIPCION||' '||v_pre.cantidad order by 1  RANGE UNBOUNDED PRECEDING)cant_por_concurso_zona,
	   sum(cc_pun.NUM_PUNT) as puntos_totales	 
from inc_concu_param_gener con,
	 inc_param_gener_premi par_gen_pre,
	 inc_cuent_corri_punto cc_pun,
	 inc_ganad gan,
	 inc_premi_elegi pre_el,
	 mae_clien cli,
	 mae_clien_unida_admin un_adm,
	 v_rep_premios v_pre,
	 zon_terri_admin ter_adm,
	 zon_secci sec,
	 zon_zona zon,
	 zon_regio reg,
	 zon_terri ter,
	 zon_sub_geren_venta subg,
	 cra_perio per1,
	 cra_perio per2,
	 (
	  select val_oid, val_i18n pais
	  from v_gen_i18n_sicc
	  where attr_enti = 'SEG_PAIS'
	  		and idio_oid_idio  = 1 --PARAMETRO IDIOMA--
	 )gen_pais
where con.OID_PARA_GRAL = cc_pun.COPA_OID_PARA_GRAL
	  and cc_pun.CLIE_OID_CLIE = un_adm.CLIE_OID_CLIE
	  and un_adm.clie_oid_clie = cli.OID_CLIE
	  and un_adm.IND_ACTI = 1
--	  and con.IND_ACTI = 1
	  and par_gen_pre.COPA_OID_PARA_GRAL = con.OID_PARA_GRAL
--	  and par_gen_pre.OID_PARA_GENE_PREM = v_pre.PAGP_OID_PARA_GENE_PREM
	  and pre_el.COPA_OID_PARA_GRAL = con.OID_PARA_GRAL
	  and pre_el.clie_oid_clie = cli.oid_clie
	  and pre_el.PANP_OID_PARA_NIVE_PREM = v_pre.OID_PARA_NIVE_PREM(+)
	  and gan.CLIE_OID_CLIE = cli.oid_clie
	  and gan.PANP_OID_PARA_NIVE_PREM = pre_el.PANP_OID_PARA_NIVE_PREM
	  and con.PERD_OID_PERI_DESD = per1.oid_peri
	  and con.PERD_OID_PERI_HAST = per2.oid_peri
	  and con.pais_oid_pais in (1) --PARAMETRO PAIS--
	  and con.pais_oid_pais = gen_pais.val_oid(+)
--	  and con.NUM_CONC in (1) --PARAMETRO NUMERO DE CONNCURSO--
	  and un_adm.ZTAD_OID_TERR_ADMI = ter_adm.OID_TERR_ADMI
	  and ter_adm.ZSCC_OID_SECC = sec.OID_SECC
	  and sec.ZZON_OID_ZONA = zon.OID_ZONA
	  and zon.ZORG_OID_REGI = reg.OID_REGI
	  and ter_adm.TERR_OID_TERR = ter.OID_TERR
	  and reg.ZSGV_OID_SUBG_VENT = subg.OID_SUBG_VENT
	  and reg.ZSGV_OID_SUBG_VENT in (1) --PARAMETRO SUBGERENCIA--
/*	  and reg.OID_REGI in (1) --PARAMETRO REGION--
	  and zon.oid_zona in (1)--PARAMETRO ZONA--*/
	  and v_pre.OID_PARA_NIVE_PREM is not null --ESTE ES EL PARAMETRO INDICADO ARRIBA--
	  and ( cc_pun.TMOV_OID_TIPO_MOVI = 1 or ( cc_pun.TMOV_OID_TIPO_MOVI = 2 and ( con.IND_ANUL = 1 or con.IND_DEVO = 1) ) or cc_pun.TMOV_OID_TIPO_MOVI = 3 )
group by cc_pun.TMOV_OID_TIPO_MOVI,
	  con.IND_ANUL, con.IND_DEVO, v_pre.TIPO_PREMIO||' '||v_pre.DESCRIPCION,
	  cli.cod_clie,
	   v_pre.cantidad, cli.VAL_APE1||' '||cli.VAL_APE2||' '||cli.VAL_NOM1,
	   ter.COD_TERR, con.NUM_CONC,
	   zon.DES_ZONA, per1.VAL_NOMB_PERI,
	   per2.VAL_NOMB_PERI,
	   con.OID_PARA_GRAL,
   	   v_pre.OID_PARA_NIVE_PREM,
	   gen_pais.pais,
   	   subg.DES_SUBG_VENT,
	   reg.DES_REGI,
	   zon.des_zona
