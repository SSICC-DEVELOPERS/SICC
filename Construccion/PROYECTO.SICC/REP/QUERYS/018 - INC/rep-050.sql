select DES_SUBG_VENT,
	   DES_REGI,
	   DES_ZONA,
	   COD_TERR,
	   cod_clie,
	   nombre_completo,
	   pais,
	   direccion,
	   telefono,
	   NUM_DOCU_IDEN,
	   nivel,
	   num_conc,
	   descripcion,
	   periodo_inicio,
	   periodo_fin,
	   val_nomb_peri,
	   DENSE_RANK() OVER (PARTITION BY
	  		  num_conc,
	   		  descripcion,
			  DES_SUBG_VENT,
	  		  DES_REGI,
	  		  DES_ZONA,
	  		  COD_TERR,
			  nivel
	   ORDER BY cod_clie asc) as nro_correlativo,
		 sum(puntos_totales)as puntos
from 
	(
		select subg.DES_SUBG_VENT,
			   reg.DES_REGI,
			   zon.DES_ZONA,
			   ter.COD_TERR,
			   cli.cod_clie,
			   gen_pais.pais, 
			   cli.VAL_NOM1||' '||cli.VAL_APE1||' '||cli.VAL_APE2 as nombre_completo,
			   cli_dir.VAL_NOMB_VIA||' '||cli_dir.NUM_PPAL as direccion,
			   cli_com.VAL_TEXT_COMU as telefono,
			   cli_id.NUM_DOCU_IDEN,
			   case
				   	   when cc_pun.TMOV_OID_TIPO_MOVI = 1 or ( cc_pun.TMOV_OID_TIPO_MOVI = 2 and ( par_gen.IND_ANUL = 1 or par_gen.IND_DEVO = 1) ) or cc_pun.TMOV_OID_TIPO_MOVI = 3 then 
							sum(cc_pun.NUM_PUNT)
					   else 0
				   end as puntos_totales,
			   niv_pre.NUM_NIVE as nivel,
			   par_gen.NUM_CONC,
			   gen_par.descripcion,
			   per_ini.val_nomb_peri as periodo_inicio,
			   per_fin.val_nomb_peri as periodo_fin,
			   per.val_nomb_peri
		from inc_concu_param_gener par_gen,
			 inc_param_gener_premi gen_pre,
 			 cra_perio per_ini,
			 cra_perio per_fin,
 			 inc_ganad gan,
			 inc_param_nivel_premi niv_pre,
			 inc_cuent_corri_punto cc_pun,	 
			 inc_premi_monet pre_mon,
		 	 mae_clien_direc cli_dir,
			 mae_clien_unida_admin un_adm,
			 mae_clien cli,
			 mae_clien_comun cli_com,
			 mae_clien_ident cli_id,
			 mae_tipo_comun tip_com,
			 zon_terri_admin ter_adm,
			 zon_terri ter,
			 zon_secci sec,
			 zon_zona zon,
			 zon_regio reg,
			 zon_sub_geren_venta subg,
			 cra_perio per,
			 (
			  select val_oid, val_i18n descripcion
			  from v_gen_i18n_sicc
			  where attr_enti = 'INC_CONCU_PARAM_GENER'
			  		and idio_oid_idio = 1 --PARAMETRO IDIOMA--
			 )gen_par,
			 (
			  select val_oid, val_i18n pais
			  from v_gen_i18n_sicc
			  where attr_enti = 'SEG_PAIS'
			  		and idio_oid_idio = 1 --PARAMETRO IDIOMA--
			 )gen_pais
		where par_gen.OID_PARA_GRAL = gen_pre.COPA_OID_PARA_GRAL
			  and par_gen.PERD_OID_PERI_DESD = per_ini.oid_peri
			  and par_gen.PERD_OID_PERI_HAST = per_fin.oid_peri
			  and niv_pre.PAGP_OID_PARA_GENE_PREM = gen_pre.OID_PARA_GENE_PREM
			  and gan.PANP_OID_PARA_NIVE_PREM = niv_pre.OID_PARA_NIVE_PREM
			  -------------------------------------------------------------------------------------------------
			  and un_adm.clie_oid_clie = gan.clie_oid_clie
			  and un_adm.clie_oid_clie = cli.oid_clie
			  and cli.oid_clie = cli_id.CLIE_OID_CLIE
			  and cli_id.VAL_IDEN_DOCU_PRIN(+) = 1
			  and cli.oid_clie = cli_com.clie_oid_clie(+)
			  and cli_com.TICM_OID_TIPO_COMU = tip_com.OID_TIPO_COMU(+)
--			  and tip_com.COD_TIPO_COMU(+) = 'TF'
			  and cli.oid_clie = cli_dir.clie_oid_clie(+)
--			  and cli_dir.IND_DIRE_PPAL(+) = 1
			  -------------------------------------------------------------------------------------------------	  
			  and cc_pun.COPA_OID_PARA_GRAL = par_gen.OID_PARA_GRAL 
--			  and un_adm.IND_ACTI = 1
			  and un_adm.ZTAD_OID_TERR_ADMI = ter_adm.OID_TERR_ADMI
			  and ter_adm.ZSCC_OID_SECC = sec.OID_SECC
			  and sec.ZZON_OID_ZONA = zon.OID_ZONA
			  and zon.ZORG_OID_REGI = reg.OID_REGI
			  and reg.ZSGV_OID_SUBG_VENT = subg.OID_SUBG_VENT
			  and par_gen.OID_PARA_GRAL = gen_par.val_oid(+)
			  and cc_pun.PERD_OID_PERI = per.oid_peri
			  and ter_adm.TERR_OID_TERR = ter.OID_TERR
		/*	  and ter_adm.TERR_OID_TERR in (1) --PARAMETRO TERRITORIO--
			  and subg.OID_SUBG_VENT in (1) --PARAMETRO SUBGERENCIA--
			  and reg.OID_REGI in (1) --PARAMETRO REGION--
			  and zon.OID_ZONA in (1) --PARAMETRO ZONA--
			  and par_gen.NUM_CONC in (1) --PARAMETRO NUMERO CONCURSO--*/
			  and par_gen.pais_oid_pais in (1) --PARAMETRO PAIS--
  			  and par_gen.pais_oid_pais = gen_pais.val_oid(+)
			  and niv_pre.NUM_NIVE in (1,2) --PARAMETRO NIVEL DE PREMIACION--
		group by cc_pun.TMOV_OID_TIPO_MOVI,
			  par_gen.IND_ANUL,
			  cli.cod_clie,
			  cli.VAL_NOM1||' '||cli.VAL_APE1||' '||cli.VAL_APE2,
			  cli_dir.VAL_NOMB_VIA||' '||cli_dir.NUM_PPAL,
			  cli_com.VAL_TEXT_COMU,
			  cli_id.NUM_DOCU_IDEN,
			  niv_pre.NUM_NIVE,
			  par_gen.NUM_CONC,
			  par_gen.IND_DEVO,
			  gen_par.descripcion,
			  per_ini.val_nomb_peri,
			  per_fin.val_nomb_peri,
			  per.val_nomb_peri,
			  gen_pais.pais,
			  subg.DES_SUBG_VENT,
			  reg.DES_REGI,
			  zon.DES_ZONA,
			  ter.COD_TERR
	)	  
group by cod_clie,
	   nombre_completo,
	   direccion,
	   telefono,
	   nivel,
	   num_conc,
	   descripcion,
	   periodo_inicio,
	   periodo_fin,
	   val_nomb_peri,
	   NUM_DOCU_IDEN,
	   pais,
	   DES_SUBG_VENT,
	   DES_REGI,
	   DES_ZONA,
	   COD_TERR
order by
	  pais,
	  num_conc,
	  descripcion,
	  DES_SUBG_VENT,
	  DES_REGI,
	  DES_ZONA,
	  COD_TERR,
	  cod_clie,
	  nombre_completo asc