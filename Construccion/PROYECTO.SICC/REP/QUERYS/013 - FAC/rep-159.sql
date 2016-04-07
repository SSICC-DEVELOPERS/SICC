select
	   mon.VAL_NOMB_CORT_MONE,
	   periodos.periodo_act,
	   periodos.periodo_ant,
	   periodos.OID_SUBG,
	   periodos.DES_SUBG_VENT,
	   periodos.OID_REGI,
	   periodos.DES_REGI,
  	   per_ant.pedidos_est_per_ant AS ESTIM,
	   per_ant.pedidos_fact_per_ant AS FACTUR,
	   round(decode(per_ant.pedidos_est_per_ant,0,0,
	   		per_ant.pedidos_fact_per_ant / per_ant.pedidos_est_per_ant * 100),0) AS VAR,
 	   --
	   per_act_mov_diario.pedidos AS PEDID,
	   per_act_mov_diario.monto_neto AS NETO,
   	   decode(per_act_mov_diario.pedidos,0,0,
	   		per_act_mov_diario.monto_neto / per_act_mov_diario.pedidos ) AS PSP_mov_diario, 
	   round(decode(per_act_mov_diario.pedidos,0,0,
	   		per_act_mov_diario.faltantes / per_act_mov_diario.pedidos * 100 ),1) AS por_faltantes_mov_diario,
	   --
	   per_act_mov_acum.pedidos_estimados,
	   per_act_mov_acum.pedidos_fact,
	   (per_act_mov_acum.pedidos_fact - per_act_mov_acum.pedidos_estimados) AS diferencia,
	   decode(per_act_mov_acum.pedidos_estimados,0,0,
	   		(per_act_mov_acum.pedidos_fact / per_act_mov_acum.pedidos_estimados -1 )*100) AS por_f_e,
	   decode(per_act_mov_acum.pedidos_fact,0,0,
	   		per_act_mov_acum.unidades_atendidas / per_act_mov_acum.pedidos_fact ) AS PUP,
	   --
	   per_act_mov_acum.monto_neto_estimado,
	   per_act_mov_acum.monto_neto_fact,
	   round(decode(per_act_mov_acum.monto_neto_estimado,0,0,
	   		(monto_neto_fact / per_act_mov_acum.monto_neto_estimado -1)*100),0) AS por_variacion,
	   decode(per_act_mov_acum.pedidos_fact,0,0,
	   		per_act_mov_acum.monto_neto_fact / per_act_mov_acum.pedidos_fact) AS PSP,
	   round(decode(per_act_mov_acum.pedidos_fact,0,0,
	   		per_act_mov_acum.faltantes/per_act_mov_acum.pedidos_fact * 100),2) AS por_faltantes
from 
------CALCULO PERIODO ANTERIOR, y TODAS LAS REGIONES-----------------------------------------------------------
	(
		select periodos_calc.*,
			   reg.oid_regi,
			   reg.DES_REGI,
			   reg.ZSGV_OID_SUBG_VENT oid_subg,
			   subg.DES_SUBG_VENT
		from
			(
			 select peri.OID_PERI oid_per_ant,
			 		peri.val_nomb_peri periodo_ant, 
			 		per.oid_peri oid_per_act,
					per.val_nomb_peri periodo_act
				 from ( 
			 	  	select per2.oid_peri,
						   per2.fec_inic, 
						   per2.pais_oid_pais, 
						   per2.cana_oid_cana, 
						   per2.marc_oid_marc,
						   per2.val_nomb_peri  
					from cra_perio per2 
					order by per2.fec_inic desc
					)peri,
					cra_perio per  
				 where  per.OID_PERI = 57 --PARAMETRO--
				   and peri.FEC_INIC < per.fec_inic
				   and peri.pais_oid_pais = 1 --PARAMETRO--
				   and peri.cana_oid_cana = 1 --PARAMETRO--
				   and peri.marc_oid_marc = 1 --PARAMETRO--
		  		   and rownum = 1
			)periodos_calc,
		zon_regio reg,
		zon_sub_geren_venta subg
	where reg.ZSGV_OID_SUBG_VENT = subg.OID_SUBG_VENT
	)periodos
---------------------------------------------------------------------------------------------------------------	 
LEFT OUTER JOIN
------PERIODO ANTERIOR-----------------------------------------------------------------------------------------
	(
	select acum_per_ant.pedidos_fact_per_ant,
		   acum_per_ant.perd_oid_peri,
		   acum_per_ant.ZORG_OID_REGI,
		   previsto_per_ant.pedidos_est_per_ant
	from
		(
		select  count(sol_con.oid_soli_cabe) pedidos_fact_per_ant,
				sol_con.perd_oid_peri,
				zon.ZORG_OID_REGI
		from
			---SOLICITUDES CONSOLIDADAS--
			(
			   select *
			   from ped_solic_cabec
			   where ped_solic_cabec.fec_fact is not null
			   		 and ped_solic_cabec.IND_PEDI_PRUE <> 1
			  		 and ped_solic_cabec.IND_TS_NO_CONSO <> 1
			)sol_con,
			ped_tipo_solic_pais t_sol_p,
			ped_tipo_solic t_sol,
			zon_zona zon,
			zon_regio reg,
			seg_acces acc
		where sol_con.ZZON_OID_ZONA = zon.OID_ZONA(+)
			  and sol_con.TSPA_OID_TIPO_SOLI_PAIS = t_sol_p.OID_TIPO_SOLI_PAIS(+)
			  and t_sol_p.TSOL_OID_TIPO_SOLI = t_sol.OID_TIPO_SOLI(+)
			  and zon.ZORG_OID_REGI = reg.OID_REGI(+)
			  and t_sol.ACCE_OID_ACCE = acc.OID_ACCE(+)
		group by sol_con.PERD_OID_PERI,
				zon.ZORG_OID_REGI
		)acum_per_ant
		FULL OUTER JOIN
		(
				select sum(fvt.NUM_PEDI)pedidos_est_per_ant,
					   fvt.ZORG_OID_REGI,
					   fvt.PERD_OID_PERI
				from int_fuent_venta_previ_sap fvt
				group by fvt.ZORG_OID_REGI,
					   fvt.PERD_OID_PERI
		)previsto_per_ant
			on previsto_per_ant.ZORG_OID_REGI = acum_per_ant.ZORG_OID_REGI
		   and previsto_per_ant.PERD_OID_PERI = acum_per_ant.PERD_OID_PERI
	)per_ant
on per_ant.perd_oid_peri = periodos.oid_per_ant
   and per_ant.ZORG_OID_REGI = periodos.oid_regi
---------------------------------------------------------------------------------------------------------------
LEFT OUTER JOIN 
------PERIODO ACTUAL MOVIMIENTO ACUMULADO----------------------------------------------------------------------
	(
	select acum.pedidos_fact, 
				acum.monto_neto_fact,
				acum.faltantes,
				acum.unidades_atendidas,
				acum.PERD_OID_PERI,
				acum.ZORG_OID_REGI,
				previsto.pedidos_estimados,
				previsto.monto_neto_estimado
	from
		(
		select  count(sol_con.oid_soli_cabe) pedidos_fact, 
				sum(sol_con.VAL_TOTA_PAGA_LOCA + sol_con.VAL_IMPO_REDO_LOCA)monto_neto_fact,
				count(distinct sol_no_con.soca_oid_soli_cabe)faltantes,
				sum(sol_con.NUM_UNID_ATEN_TOTA)unidades_atendidas,
				sol_con.PERD_OID_PERI,
				zon.ZORG_OID_REGI
		from
			---SOLICITUDES CONSOLIDADAS--
			(
			   select *
			   from ped_solic_cabec
			   where ped_solic_cabec.fec_fact is not null
			   		 and ped_solic_cabec.IND_PEDI_PRUE <> 1
			  		 and ped_solic_cabec.IND_TS_NO_CONSO <> 1
			)sol_con,
			--SOLICITUDES NO CONSOLIDADAS--
			(
			   select *
			   from ped_solic_cabec
			   where ped_solic_cabec.fec_fact is not null
			   		 and ped_solic_cabec.IND_PEDI_PRUE <> 1
			  		 and ped_solic_cabec.IND_TS_NO_CONSO = 1
			)sol_no_con,
			ped_tipo_solic_pais t_sol_p,
			ped_tipo_solic t_sol,
			zon_zona zon,
			zon_regio reg,
			seg_acces acc,
			ped_solic_posic pos,
			ped_estad_posic est_pos
		where sol_con.ZZON_OID_ZONA = zon.OID_ZONA(+)
			  and sol_con.TSPA_OID_TIPO_SOLI_PAIS = t_sol_p.OID_TIPO_SOLI_PAIS(+)
			  and t_sol_p.TSOL_OID_TIPO_SOLI = t_sol.OID_TIPO_SOLI(+)
			  and zon.ZORG_OID_REGI = reg.OID_REGI(+)
			  and t_sol.ACCE_OID_ACCE = acc.OID_ACCE(+)
			  and sol_con.oid_soli_cabe = sol_no_con.soca_oid_soli_cabe
			  and sol_no_con.oid_soli_cabe = pos.SOCA_OID_SOLI_CABE
			  and pos.ESPO_OID_ESTA_POSI = est_pos.OID_ESTA_POSI
--			  and est_pos.COD_ESTA_POSI <> 'AN'
			  and acc.CANA_OID_CANA = 1 --PARAMETRO CANAL--
			  and t_sol.marc_oid_marc = 1 --PARAMETRO MARCA--
			  and sol_con.pais_oid_pais = 1 --PARAMETRO PAIS--
			  and sol_no_con.pais_oid_pais = 1 --PARAMETRO PAIS--
			  and zon.ZORG_OID_REGI in (1) --PARAMETRO REGION--
			  and acc.oid_acce = 1 --PARAMETRO ACCESO--
		group by sol_con.PERD_OID_PERI,
				zon.ZORG_OID_REGI
		)acum
		FULL OUTER JOIN
		(	
			select sum(fvt.NUM_PEDI)pedidos_estimados,
				   sum(fvt.VAL_VENT_NETA_ESTA)monto_neto_estimado,
				   fvt.ZORG_OID_REGI,
				   fvt.PERD_OID_PERI
			from int_fuent_venta_previ_sap fvt
			group by fvt.ZORG_OID_REGI,
				   fvt.PERD_OID_PERI
		)previsto
		on previsto.ZORG_OID_REGI = acum.ZORG_OID_REGI
		   and previsto.PERD_OID_PERI = acum.PERD_OID_PERI
	)per_act_mov_acum
on  per_act_mov_acum.perd_oid_peri = periodos.oid_per_act
	and per_act_mov_acum.ZORG_OID_REGI = periodos.oid_regi
---------------------------------------------------------------------------------------------------------------
LEFT OUTER JOIN
------PERIODO ACTUAL MOVIMIENTO DIARIO-------------------------------------------------------------------------
	(
	select  count(sol_con.oid_soli_cabe) pedidos, 
			sum(sol_con.VAL_TOTA_PAGA_LOCA + sol_con.VAL_IMPO_REDO_LOCA)monto_neto,
			count(distinct sol_no_con.soca_oid_soli_cabe)faltantes,
			sol_con.PERD_OID_PERI,
			zon.ZORG_OID_REGI,
			acc.oid_acce,
			acc.cana_oid_cana,
			sol_con.pais_oid_pais,
			t_sol.marc_oid_marc
	from
		---SOLICITUDES CONSOLIDADAS--
		(
		   select *
		   from ped_solic_cabec
		   where ped_solic_cabec.fec_fact is not null
		   		 and ped_solic_cabec.IND_PEDI_PRUE <> 1
		  		 and ped_solic_cabec.IND_TS_NO_CONSO <> 1
		)sol_con,
		--SOLICITUDES NO CONSOLIDADAS--
		(
		   select *
		   from ped_solic_cabec
		   where ped_solic_cabec.fec_fact is not null
		   		 and ped_solic_cabec.IND_PEDI_PRUE <> 1
		  		 and ped_solic_cabec.IND_TS_NO_CONSO = 1
		)sol_no_con,
		ped_tipo_solic_pais t_sol_p,
		ped_tipo_solic t_sol,
		zon_zona zon,
		zon_regio reg,
		seg_acces acc,
		ped_solic_posic pos,
		ped_estad_posic est_pos
	where sol_con.ZZON_OID_ZONA = zon.OID_ZONA(+)
		  and sol_con.TSPA_OID_TIPO_SOLI_PAIS = t_sol_p.OID_TIPO_SOLI_PAIS(+)
		  and t_sol_p.TSOL_OID_TIPO_SOLI = t_sol.OID_TIPO_SOLI(+)
		  and zon.ZORG_OID_REGI = reg.OID_REGI(+)
		  and t_sol.ACCE_OID_ACCE = acc.OID_ACCE(+)
		  and sol_con.fec_fact between '1/1/2001' --PARAMETRO FECHA INICIO--
		  	  and to_date('31/12/2015','dd/mm/yyyy') -1 --PARAMETRO FECHA FIN--
		  and sol_con.oid_soli_cabe = sol_no_con.soca_oid_soli_cabe
		  and sol_no_con.oid_soli_cabe = pos.SOCA_OID_SOLI_CABE
		  and pos.ESPO_OID_ESTA_POSI = est_pos.OID_ESTA_POSI
		  and est_pos.COD_ESTA_POSI <> 'AN'
  		  and acc.CANA_OID_CANA = 1 --PARAMETRO-- 
  		  and t_sol.marc_oid_marc = 1 --PARAMETRO--
  		  and sol_con.pais_oid_pais = 1 --PARAMETRO PAIS--
		  and sol_no_con.pais_oid_pais = 1 --PARAMETRO PAIS--
  		  and zon.ZORG_OID_REGI in (1) --PARAMETRO REGION--
  		  and acc.oid_acce = 1 --PARAMETRO ACCESO--
	group by sol_con.PERD_OID_PERI,
			zon.ZORG_OID_REGI,
			acc.oid_acce,
			acc.cana_oid_cana,
			sol_con.pais_oid_pais,
			t_sol.marc_oid_marc
	)per_act_mov_diario
on per_act_mov_diario.perd_oid_peri = periodos.oid_per_act
   and per_act_mov_diario.ZORG_OID_REGI = periodos.oid_regi
   and per_act_mov_acum.ZORG_OID_REGI = per_act_mov_diario.ZORG_OID_REGI,
---------------------------------------------------------------------------------------------------------------
seg_pais pai
INNER JOIN
seg_moned mon
on pai.MONE_OID_MONE = mon.OID_MONE
   and pai.OID_PAIS = 1 --PARAMETRO PAIS--
ORDER BY periodo_act, periodo_ant, 
	  periodos.DES_SUBG_VENT, periodos.DES_REGI


