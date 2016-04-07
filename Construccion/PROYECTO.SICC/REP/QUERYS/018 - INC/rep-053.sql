select DES_SUBG_VENT,
	   DES_REGI,
	   DES_ZONA,
	   val_nomb_peri,
	   nro_dia,
	   num_conc,
	   tipo_concurso,
	   num_nive,
	   desc_premio,
	   despacho_diario,
	   cons_con_morosidad,
	   compra_inicial,
	   despacho_acum,
	   faltantes,
	   sum(faltantes) over ( partition by num_conc order by rownum ) as faltantes_acum,
	   saldo
from 
(
	select DES_SUBG_VENT,
		   DES_REGI,
		   DES_ZONA,
		   val_nomb_peri,
		   nro_dia,
		   num_conc,
		   tipo_concurso,
		   num_nive,
		   desc_premio,
		   despacho_diario,
		   cons_con_morosidad,
		   compra_inicial,
		   despacho_acum,
		   rank() over ( partition by saldo order by rownum) as rank,
		   case when (rank() over ( partition by saldo order by rownum)) > 1 and saldo = 0 then unidades_faltantes 
		   		else faltantes
		   end as faltantes,
		   saldo
	from 
	(
		select DES_SUBG_VENT,
			   DES_REGI,
			   DES_ZONA,
			   val_nomb_peri,
			   nro_dia,		 
			   num_conc,
			   tipo_concurso,
			   num_nive,
			   desc_premio,
			   despacho_diario,
			   cons_con_morosidad,
			   250 as compra_inicial, --PARAMETRO UNIDADES COMPRADAS (250)--
			   --------------------------------------------------------------------------------------------------------	   
			   nvl(sum(despacho_diario) over ( partition by num_conc order by rownum),0) as despacho_acum,
			   --------------------------------------------------------------------------------------------------------
			   case when 250 - nvl(sum(despacho_diario) over ( partition by num_conc order by rownum),0) <= 0 then 
			   		(250 - nvl(sum(despacho_diario) over ( partition by num_conc order by rownum),0))*-1  else 0 end as faltantes,
			   --------------------------------------------------------------------------------------------------------			
			   case when 250 - nvl(sum(despacho_diario) over ( partition by num_conc order by rownum),0) <= 0 then 0
			   		else 250 - nvl(sum(despacho_diario) over ( partition by num_conc order by rownum),0) end as saldo,
			   unidades_faltantes
		from
		(
			select DES_SUBG_VENT,
				   DES_REGI,
				   DES_ZONA,
				   val_nomb_peri,	
				   nro_dia,
				   num_conc,
				   tipo_concurso,
				   num_nive,
				   desc_premio,
				   sum(num_unid_aten)as despacho_diario,
				   count(distinct cons_con_morosidad) as cons_con_morosidad,
				   sum(num_unid_falt) as unidades_faltantes
			from
			(
				select subg.DES_SUBG_VENT, 
					   reg.DES_REGI,
					   zon.DES_ZONA,
					   per.val_nomb_peri,
					   per.oid_peri,
					   pos.OID_SOLI_POSI,
				  	   sol.FEC_CRON - per.FEC_INIC + 1 as nro_dia, 
					   con.NUM_CONC,
					   gen_bas_cal.val_i18n as tipo_concurso,
					   niv_pre.NUM_NIVE,
					   gen_prod.val_i18n as desc_premio,
					   pos.NUM_UNID_ATEN,
					   --------------------------------------------------------------------------------------------------------
					   (
					   	select can.CLIE_OID_CLIE
						from inc_candi_ganad can
						where can.clie_oid_clie = sol.clie_oid_clie
							  and can.copa_oid_para_gral = con.OID_PARA_GRAL
							  and can.perd_oid_peri = sol.PERD_OID_PERI
							  and can.BINC_OID_BASE_INCU = 4
						) as cons_con_morosidad,
						bol_fal.NUM_UNID_FALT
				from inc_concu_param_gener con,
					 inc_param_gener_premi gen_pre,
					 inc_param_nivel_premi niv_pre,
					 inc_premi_artic pre_art,
					 inc_lote_premi_artic lot_art,
					 inc_bolsa_falta bol_fal,
					 inc_rango ran,
					 ped_solic_cabec sol,
					 ped_solic_posic pos,
					 ped_tipo_solic_pais t_sol_p,
					 ped_tipo_solic t_sol,
					 zon_zona zon,
					 zon_regio reg,
					 zon_sub_geren_venta subg,
					 cra_perio per,
					 (
					  select val_oid, val_i18n
					  from v_gen_i18n_sicc 
					  where attr_enti =  'INC_BASE_CALCU'
					  		and idio_oid_idio = 1 --PARAMETRO IDIOMA--
					 )gen_bas_cal,
					 (
					  select val_oid, val_i18n
					  from v_gen_i18n_sicc 
					  where attr_enti =  'MAE_PRODU'
					  		and idio_oid_idio = 1 --PARAMETRO IDIOMA--
					 )gen_prod
				where con.BCAL_OID_BASE_CALC = gen_bas_cal.val_oid(+)
					  and con.OID_PARA_GRAL = gen_pre.COPA_OID_PARA_GRAL
					  and niv_pre.PAGP_OID_PARA_GENE_PREM = gen_pre.OID_PARA_GENE_PREM
					  and niv_pre.TPRE_OID_TIPO_PREM = 2
					  and niv_pre.OID_PARA_NIVE_PREM = pre_art.PANP_OID_PARA_NIVE_PREM
					  and pre_art.OID_PREM_ARTI = lot_art.PRAR_OID_PREM_ARTI
					  and con.OID_PARA_GRAL = sol.COPA_OID_PARA_GENE
					  and sol.oid_soli_cabe = pos.soca_oid_soli_cabe
					  and sol.TSPA_OID_TIPO_SOLI_PAIS = t_sol_p.OID_TIPO_SOLI_PAIS
					  and t_sol_p.TSOL_OID_TIPO_SOLI = t_sol.OID_TIPO_SOLI
		--			  and t_sol.COD_TIPO_SOLI in ('I3','I4','IF','IN')
					  and pos.prod_oid_prod = gen_prod.val_oid(+)
					  and sol.PERD_OID_PERI = per.oid_peri
					  and con.OID_PARA_GRAL = 2 --PARAMETRO CONCURSO--
					  and pos.OID_SOLI_POSI = bol_fal.SOPO_OID_SOLI_POSI(+)
					  and con.pais_oid_pais = 1 --PARAMETRO PAIS--
					  and con.MARC_OID_MARC = 2 --PARAMETRO MARCA--
					  and con.CANA_OID_CANA = 1 --PARAMETRO CANAL--
					  and zon.ZORG_OID_REGI in (7) --PARAMETRO REGION--
					  and reg.ZSGV_OID_SUBG_VENT in (1) --PARAMETRO SUBGERENCIA--
					  and sol.ZZON_OID_ZONA in (1) --PARAMETRO ZONA--
					  and con.OID_PARA_GRAL = ran.COPA_OID_PARA_GRAL
					  and ran.OID_RANG in (112,113) --PARAMETRO NIVELES DE CONCURSO--
					  and sol.ZZON_OID_ZONA = zon.OID_ZONA
					  and zon.ZORG_OID_REGI = reg.oid_regi
					  and reg.ZSGV_OID_SUBG_VENT = subg.OID_SUBG_VENT 
			)		  
				group by  val_nomb_peri,	
				   nro_dia,
				   num_conc,
				   tipo_concurso,
				   num_nive,
				   desc_premio,
				   DES_SUBG_VENT,
				   DES_REGI,
				   DES_ZONA
		)
	)
	order by val_nomb_peri, nro_dia asc
)
order by val_nomb_peri, nro_dia asc

