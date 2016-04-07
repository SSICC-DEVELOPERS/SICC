select DES_SUBG_VENT,
	   DES_REGI,
	   des_zona,
	   num_conc,
	   val_nomb,
	   periodo_desde,
	   periodo_hasta,
   	   grupo_desde,
	   grupo_hasta,
	   sum(nro_consultoras)nro_consultoras,
	   sum(nro_consultoras) / total_consultoras * 100 as por_consultoras,
	   sum(sum(nro_consultoras) / total_consultoras * 100)  over (partition by DES_SUBG_VENT, DES_REGI, des_zona, num_conc order by grupo_desde) por_acum,  
	   sum(nro_variacion_1) as nro_variacion_1,
   	   sum(nro_variacion_1) / total_consultoras * 100 as por_variacion_1,
	   sum(nro_variacion_2) as nro_variacion_2,
   	   sum(nro_variacion_2) / total_consultoras * 100 as por_variacion_2,
	   sum(nro_variacion_3) as nro_variacion_3,
   	   sum(nro_variacion_3) / total_consultoras * 100 as por_variacion_3,
	   sum(nro_variacion_4) as nro_variacion_4,
   	   sum(nro_variacion_4) / total_consultoras * 100 as por_variacion_4,
	   sum(nro_variacion_5) as nro_variacion_5,
   	   sum(nro_variacion_5) / total_consultoras * 100 as por_variacion_5,
	   sum(nro_variacion_6) as nro_variacion_6,
   	   sum(nro_variacion_6) / total_consultoras * 100 as por_variacion_6
from
( 
	select DES_SUBG_VENT,
		   DES_REGI,
		   des_zona,
		   num_conc,
		   val_nomb,
		   periodo_desde,
		   periodo_hasta,
		   count(clie_oid_clie) as nro_consultoras,
		   total_consultoras,
		   grupo_desde,
		   grupo_hasta,
		   grupo,
	   	   --------------------------------------------------------------------------------------------------------
		   --PARAMETROS DE VARIACION: en caso que no venga, poner por default -1 --
		   --EJ case when por_variacion >= 'PARAMETRO_VARIACION_DESDE_1'  and por_variacion < 'PARAMETRO_VARIACION_HASTA_1' then  sum(ind_meta_const) / count(distinct clie_oid_clie) * 100 end as nro_variacion_1,
		   case when por_variacion > 0  and por_variacion <= 15 then count(clie_oid_clie) end as nro_variacion_1,
	   	   --------------------------------------------------------------------------------------------------------
	   	   case when por_variacion > 15 and por_variacion <= 20 then count(clie_oid_clie) end as nro_variacion_2,
	   	   --------------------------------------------------------------------------------------------------------
		   case when por_variacion > 20 and por_variacion <= 25 then count(clie_oid_clie) end as nro_variacion_3,
	   	   --------------------------------------------------------------------------------------------------------
	   	   case when por_variacion > 25 and por_variacion <= 30 then count(clie_oid_clie) end as nro_variacion_4,
	   	   --------------------------------------------------------------------------------------------------------
		   case when por_variacion > 30 and por_variacion <= 50 then count(clie_oid_clie) end as nro_variacion_5,
	   	   --------------------------------------------------------------------------------------------------------
		   case when por_variacion > 50 and por_variacion <= 100 then count(clie_oid_clie) end as nro_variacion_6
		   --------------------------------------------------------------------------------------------------------
	from
	(
		select DES_SUBG_VENT,
			   DES_REGI,
			   des_zona,
			   num_conc,
			   val_nomb,
			   periodo_desde,
			   periodo_hasta,
			   clie_oid_clie,
			   count(*) over ( partition by num_conc, DES_SUBG_VENT, DES_REGI, des_zona)total_consultoras, 
			   --------------------------------------------------------------------------------------------------------
			   case when (monto_venta * 100) / meta < 100 then 100 - ((monto_venta * 100) / meta ) end as por_variacion,
			   own_peru.FN_072_RANGO(meta) as grupo,
			   --------------------------------------------------------------------------------------------------------
			   decode(
				   own_peru.FN_072_RANGO(meta),1000,
				   own_peru.FN_072_RANGO(meta),
				   own_peru.FN_072_RANGO(meta) + 1)  as grupo_desde,
			   --------------------------------------------------------------------------------------------------------
			   case when
			   		own_peru.FN_072_RANGO(meta) < 3000 then
					own_peru.FN_072_RANGO(meta) + 500 else
					own_peru.FN_072_RANGO(meta) + 1000 end as grupo_hasta
			   --------------------------------------------------------------------------------------------------------
		from (
			select subg.DES_SUBG_VENT,
				   reg.DES_REGI,
				   zon.des_zona,
				   con.num_conc,
				   con.val_nomb,
				   per1.val_nomb_peri periodo_desde,
				   per2.val_nomb_peri periodo_hasta,		     
				   con.OID_PARA_GRAL,
				   un_adm.clie_oid_clie,
				   pla_con.TVEN_OID_TIPO_VENT,
				   ----------------------------------------------------------------------------------------------------
				   met.val_meta * moneda.valor_moneda as meta,
		   		   ----------------------------------------------------------------------------------------------------
				   own_peru.FN_083_CU_OBT_VENTA (con.OID_PARA_GRAL, un_adm.clie_oid_clie, tip_vta.OID_TIPO_VENT) * moneda.valor_moneda as monto_venta,
				   ----------------------------------------------------------------------------------------------------
				   (
				   	select case when sum(can_gan.IND_META_SUPE) >= 1 then 1 else 0 end
					from inc_candi_ganad can_gan
					where can_gan.clie_oid_clie = un_adm.clie_oid_clie
						  and can_gan.copa_oid_para_gral = con.oid_para_gral
					)ind_meta_supe
					from inc_concu_param_gener con,
						 inc_plant_concu pla_con,
						 inc_tipo_venta tip_vta,
						 inc_metas_tipo_venta met,
						 mae_clien_unida_admin un_adm,
						 mae_clien_tipo_subti tip_sub,
						 mae_clien_clasi cla,
						 zon_terri_admin ter_adm,
						 zon_secci sec,
						 zon_zona zon,
						 zon_regio reg,
						 zon_sub_geren_venta subg,
						 seg_pais pai,
						 cra_perio per1,
						 cra_perio per2,
						 (						
							select case when pais.mone_oid_mone = 2 --PARAMETRO MONEDA REFERENCIA--
								    then 1
								   else
									   ( select tip_cam.VAL_TIPO_CAMB
							   		   from seg_tipo_cambi tip_cam
									   where tip_cam.MONE_OID_MON1 = pais.mone_oid_mone
										   and tip_cam.MONE_OID_MON2 = 2 --PARAMETRO MONEDA REFERENCIA--
										   and sysdate between tip_cam.FEC_DESD and tip_cam.FEC_HAST ) end as valor_moneda
							from seg_pais pais
							where pais.oid_pais = 1
						)moneda
					where con.PLC2_OID_PLAN_CONC = pla_con.OID_PLAN_CONC
						  and pla_con.TVEN_OID_TIPO_VENT = tip_vta.OID_TIPO_VENT
						  and con.OID_PARA_GRAL = met.COPA_OID_PARA_GRAL
						  and met.clie_oid_clie = un_adm.clie_oid_clie
						  and con.PERD_OID_PERI_DESD = per1.oid_peri
						  and con.PERD_OID_PERI_HAST = per2.oid_peri
						  and con.IND_ACTI = 1
						  and un_adm.IND_ACTI = 1
						  and un_adm.ZTAD_OID_TERR_ADMI = ter_adm.OID_TERR_ADMI
						  and ter_adm.ZSCC_OID_SECC = sec.OID_SECC
						  and sec.ZZON_OID_ZONA = zon.oid_zona
						  and zon.ZORG_OID_REGI = reg.oid_regi
						  and reg.ZSGV_OID_SUBG_VENT = subg.OID_SUBG_VENT
						  and un_adm.clie_oid_clie = tip_sub.clie_oid_clie
						  and tip_sub.IND_PPAL = 1 
						  and tip_sub.OID_CLIE_TIPO_SUBT = cla.CTSU_OID_CLIE_TIPO_SUBT
						  and cla.IND_PPAL = 1
						  and con.pais_oid_pais = pai.OID_PAIS
						  and con.oid_para_gral = 1
					/*	  and zon.oid_zona in (1) --PARAMETRO ZONA--
						  and reg.oid_regi in (1) --PARAMETRO REGION--
						  and reg.ZSGV_OID_SUBG_VENT in (1) --PARAMETRO SUBGERENCIA--
						  and con.pais_oid_pais = 1 --PARAMETRO PAIS--
						  and con.marc_oid_marc = 1 --PARAMETRO MARCA--
						  and con.cana_oid_cana = 1 --PARAMETRO CANAL--
						  and tip_vta.OID_TIPO_VENT = 1 --PARAMETRO TIPO DE VENTA--
						  and tip_sub.TICL_OID_TIPO_CLIE in (1) --PARAMETRO TIPO DE CLIENTE--
						  and tip_sub.SBTI_OID_SUBT_CLIE in (1) --PARAMETRO SUBTIPO DE CLIENTE--
						  and cla.TCCL_OID_TIPO_CLASI in (1) --PARAMETRO TIPO DE CLASIFICACION--
						  and cla.CLAS_OID_CLAS in (1) --PARAMETRO CLASIFICACION--*/
			)
		where ind_meta_supe <> 1
	)
	group by DES_SUBG_VENT,
		   DES_REGI,
		   des_zona,
		   num_conc,
		   val_nomb,
	   	   periodo_desde,
		   periodo_hasta,
		   por_variacion,
		   grupo_desde,
		   grupo_hasta,
		   grupo,
		   total_consultoras
)
where grupo in (0,3000) --PARAMETRO MONTO DE VENTA DESDE--
group by DES_SUBG_VENT,
	   DES_REGI,
	   des_zona,
	   num_conc,
	   val_nomb,
   	   periodo_desde,
	   periodo_hasta,
	   grupo_desde,
	   grupo_hasta,
	   total_consultoras
	   