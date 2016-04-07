select num_conc,
	   per_desde,
	   per_hasta,
	   des_subg_vent,
	   des_regi,
	   des_zona,
	   cod_terr,
	   COD_CLIE,
	   nombre_completo,
	   puntaje,
	   case when tipo_premio_mon = 1 then val_cant
	   		when tipo_premio_mon = 2 then puntaje * val_porc / 100
			when tipo_premio_mon = 3 then puntaje
	   end as premio
from
(
	select con.NUM_CONC,
		   per_ini.val_nomb_peri as per_desde,
		   per_fin.val_nomb_peri as per_hasta,
		   subg.DES_SUBG_VENT,
		   reg.DES_REGI,
		   zon.DES_ZONA,
		   ter.COD_TERR,
		   cli.COD_CLIE,
		   cli.VAL_NOM1||' '||cli.VAL_NOM2||' '||cli.VAL_APE1||' '||cli.VAL_APE2 as nombre_completo,
		   (
		   	select sum(cc.NUM_PUNT) 
			from inc_cuent_corri_punto cc
			where cc.CLIE_OID_CLIE = cli.oid_clie
				  and cc.COPA_OID_PARA_GRAL = con.oid_para_gral
				  and ( 
				  	  cc.TMOV_OID_TIPO_MOVI = 1 or 
					  ( cc.TMOV_OID_TIPO_MOVI = 2 and ( con.IND_ANUL = 1 or con.IND_DEVO = 1) ) or 
					  cc.TMOV_OID_TIPO_MOVI = 3 )
		   )puntaje,
		   mon.TPMO_OID_TIPO_PREM_MONE as tipo_premio_mon,
		   case when mon.MONE_OID_MONE = 2 --PARAMETRO MONEDA--
		   			 then val_cant
		   		else val_cant *
				   (
				   	select cam.VAL_TIPO_CAMB
					from seg_tipo_cambi cam
					where cam.MONE_OID_MON1 = mon.MONE_OID_MONE
						  and cam.MONE_OID_MON2 = 2 --PARAMETRO MONEDA--
				   )  
		   end as val_cant,
		   mon.VAL_PORC
	from inc_concu_param_gener con,
		 inc_premi_monet mon,
		 inc_ganad gan,
		 inc_param_nivel_premi niv,
		 inc_param_gener_premi par_pre,
		 mae_clien_unida_admin un_adm,
		 mae_clien cli,
		 zon_terri_admin ter_adm,
		 zon_terri ter,
		 zon_secci sec,
		 zon_zona zon,
		 zon_regio reg,
		 zon_sub_geren_venta subg,
		 cra_perio per_ini,
		 cra_perio per_fin		 
	where con.OID_PARA_GRAL = par_pre.COPA_OID_PARA_GRAL
		  and par_pre.OID_PARA_GENE_PREM = niv.PAGP_OID_PARA_GENE_PREM
		  and niv.OID_PARA_NIVE_PREM = gan.PANP_OID_PARA_NIVE_PREM
		  and gan.CLIE_OID_CLIE = un_adm.clie_oid_clie
		  and un_adm.IND_ACTI = 1
		  and con.IND_ACTI = 1
		  and con.OID_PARA_GRAL = 1
		  and un_adm.CLIE_OID_CLIE = cli.oid_clie
		  and un_adm.ZTAD_OID_TERR_ADMI = ter_adm.OID_TERR_ADMI
		  and ter_adm.TERR_OID_TERR = ter.OID_TERR
		  and ter_adm.ZSCC_OID_SECC = sec.OID_SECC
		  and sec.ZZON_OID_ZONA = zon.OID_ZONA
		  and zon.ZORG_OID_REGI = reg.OID_REGI
		  and reg.ZSGV_OID_SUBG_VENT = subg.OID_SUBG_VENT
		  and con.PERD_OID_PERI_DESD = per_ini.oid_peri
		  and con.PERD_OID_PERI_HAST = per_fin.oid_peri
		  and mon.PANP_OID_PARA_NIVE_PREM = niv.PAGP_OID_PARA_GENE_PREM
		  and con.PAIS_OID_PAIS = 1 --PARAMETRO PAIS--
		  and con.MARC_OID_MARC = 1 --PARAMETRO MARCA--
		  and con.CANA_OID_CANA = 1 --PARAMETRO CANAL--
		  and subg.OID_SUBG_VENT in (1,2,3,4,5,6,7,8) --PARAMETRO SUBGERENCIA--
		  and reg.OID_REGI in (1,2,3,4,5,6,7,8) --PARAMETRO REGION--
		  and zon.OID_ZONA in (1,2,3,4,5,6,7,8) --PARAMETRO ZONA-- 
		  and con.OID_PARA_GRAL = 1 --PARAMETRO CONCURSO--
) 