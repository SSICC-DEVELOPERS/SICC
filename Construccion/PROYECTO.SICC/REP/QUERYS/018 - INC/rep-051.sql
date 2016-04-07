	select NUM_CONC,
		   concurso,
		   NUM_NIVE,
		   per_desde,
		   per_hasta,
		   per_cc,
		   cod_clie,
		   apyno,
		   NUM_PREM,
		   descripcion,
		   per_despacho,
		   boleta_despacho,
		   FEC_CRON,
		   pais,
		   DES_SUBG_VENT,
		   DES_REGI,
		   DES_ZONA,
		   COD_TERR,
		   DENSE_RANK() OVER (PARTITION BY
	  		  num_conc,
	   		  descripcion,
			  DES_SUBG_VENT,
	  		  DES_REGI,
	  		  DES_ZONA,
	  		  COD_TERR,
			  num_nive
	   	   ORDER BY cod_clie asc) as nro_correlativo,
		   sum(puntos_totales) as puntos,
		   count(*) over ( partition by num_conc, concurso, DES_SUBG_VENT, DES_REGI, DES_ZONA, COD_TERR, num_nive, descripcion order by 1 ) as cant_por_desc
	from
		(
		select gen_pais.pais,
			   subg.DES_SUBG_VENT,
			   reg.DES_REGI,
			   zon.DES_ZONA,
			   ter.COD_TERR,
			   con.NUM_CONC,
			   con.VAL_NOMB as concurso,
			   niv_pre.NUM_NIVE,
			   per_ini.VAL_NOMB_PERI as per_desde,
			   per_fin.VAL_NOMB_PERI as per_hasta,
			   per_cc.val_nomb_peri per_cc,
			   cli.cod_clie,
			   cli.VAL_NOM1||' '||cli.VAL_APE1||' '||cli.VAL_APE2 as apyno,
			   case
		      	   when cc.TMOV_OID_TIPO_MOVI = 1 or ( cc.TMOV_OID_TIPO_MOVI = 2 and ( con.IND_ANUL = 1 or con.IND_DEVO = 1) ) or cc.TMOV_OID_TIPO_MOVI = 3 then 
		   			sum(cc.NUM_PUNT)
		   	   else 0
		       end as puntos_totales,
			   v_pre.NUM_PREM,
			   v_pre.TIPO_PREMIO||' '||v_pre.descripcion||' '||v_pre.cantidad as descripcion,
			   per_desp.val_nomb_peri as per_despacho,
			   sol.VAL_NUME_SOLI as boleta_despacho,
			   sol.FEC_CRON,
			   v_pre.OID_PARA_NIVE_PREM
		from inc_concu_param_gener con,
			 inc_param_gener_premi par_gen_pre,
			 inc_param_nivel_premi niv_pre,
			 inc_ganad gan,
		 	 inc_cuent_corri_punto cc,
			 mae_clien_unida_admin un_adm,
			 zon_sub_geren_venta subg,
			 zon_regio reg,
			 zon_zona zon,
			 zon_secci sec,
			 zon_terri_admin ter_adm,
			 zon_terri ter,
			 mae_clien cli,
			 cra_perio per_ini,
			 cra_perio per_fin,
			 cra_perio per_cc,
			 cra_perio per_desp,
			 v_rep_premios v_pre,
			 ped_solic_cabec sol,
			 (
			  select val_oid, val_i18n pais
			  from v_gen_i18n_sicc
			  where attr_enti = 'SEG_PAIS'
			  		and idio_oid_idio = 1 --PARAMETRO IDIOMA--
			 )gen_pais
		where con.OID_PARA_GRAL = par_gen_pre.COPA_OID_PARA_GRAL
			  and par_gen_pre.OID_PARA_GENE_PREM = niv_pre.PAGP_OID_PARA_GENE_PREM  
			  and niv_pre.OID_PARA_NIVE_PREM = gan.PANP_OID_PARA_NIVE_PREM
			  and niv_pre.OID_PARA_NIVE_PREM = v_pre.OID_PARA_NIVE_PREM
			  --
			  and gan.clie_oid_clie = cc.clie_oid_clie
			  and un_adm.clie_oid_clie = cli.oid_clie
			  and un_adm.ZTAD_OID_TERR_ADMI = ter_adm.OID_TERR_ADMI
			  and ter_adm.ZSCC_OID_SECC = sec.OID_SECC
			  and sec.ZZON_OID_ZONA = zon.OID_ZONA
			  and zon.ZORG_OID_REGI = reg.OID_REGI
			  and reg.ZSGV_OID_SUBG_VENT = subg.OID_SUBG_VENT
			  and ter_adm.TERR_OID_TERR = ter.OID_TERR
			  and con.PERD_OID_PERI_DESD = per_ini.oid_peri
			  and con.PERD_OID_PERI_HAST = per_fin.oid_peri
			  and cc.PERD_OID_PERI = per_cc.oid_peri
		  	  and cc.COPA_OID_PARA_GRAL = con.OID_PARA_GRAL
			  and cc.CLIE_OID_CLIE = un_adm.clie_oid_clie
			  and con.pais_oid_pais = gen_pais.val_oid(+) 
			  and con.IND_ACTI = 1
			  and un_adm.IND_ACTI = 1
			  and v_pre.OID_TIPO = 2 
			  and con.OID_PARA_GRAL = sol.COPA_OID_PARA_GENE
			  and sol.CLIE_OID_CLIE = cc.clie_oid_clie
			  and sol.PERD_OID_PERI = per_desp.oid_peri
		--	  and v_pre.NUM_PREM = sol.NUM_PREM 
		--	  and v_pre.IDIO_TIPO_PREMIO = 1 --PARAMETRO IDIOMA--
		/*	  and reg.ZSGV_OID_SUBG_VENT in (1) --PARAMETRO SUBGERENCIA--
			  and reg.oid_regi in (1) --PARAMETRO REGION--
			  and zon.OID_ZONA in (1) --PARAMETRO ZONA--
			  and ter_adm.TERR_OID_TERR in (1) --PARAMETRO TERRITORIO--
			  and con.NUM_CONC in (1) --PARAMETRO NUMERO DE CONCURSO--
			  and niv_pre.OID_PARA_NIVE_PREM in (1) --PARAMETRO NIVEL DE CONCURSO--
			  and con.PAIS_OID_PAIS in (1) --PARAMETRO PAIS-- */
		group by
			   con.OID_PARA_GRAL,
			   cc.CLIE_OID_CLIE ,
			   con.NUM_CONC,
			   niv_pre.NUM_NIVE,
			   per_ini.VAL_NOMB_PERI,
			   per_fin.VAL_NOMB_PERI,
			   per_cc.val_nomb_peri,
			   cli.cod_clie,
			   cli.VAL_NOM1||' '||cli.VAL_APE1||' '||cli.VAL_APE2,
   			   v_pre.TIPO_PREMIO||' '||v_pre.descripcion||' '||v_pre.cantidad,
			   per_desp.val_nomb_peri,
			   sol.VAL_NUME_SOLI,
			   sol.FEC_CRON,
			   cc.TMOV_OID_TIPO_MOVI,
			   con.IND_ANUL,
			   con.IND_DEVO,
	   		   con.VAL_NOMB,
			   v_pre.NUM_PREM,
			   v_pre.OID_PARA_NIVE_PREM,
			   gen_pais.pais,
			   subg.DES_SUBG_VENT,
			   reg.DES_REGI,
			   zon.DES_ZONA,
			   ter.COD_TERR
		)
	group by
			   NUM_CONC,
			   NUM_NIVE,
			   per_desde,
			   per_hasta,
			   per_cc,
			   cod_clie,
			   apyno,
			   descripcion,
			   per_despacho,
			   boleta_despacho,
			   FEC_CRON,
			   concurso,
			   num_prem,
   			   OID_PARA_NIVE_PREM,
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
	  cod_clie asc			   
