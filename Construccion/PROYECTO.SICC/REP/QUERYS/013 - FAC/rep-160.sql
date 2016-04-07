select periodo,
	   gen_t_ofer.tipo_ofer,
	   gen_unid_negoc.un_neg,
	   pedidos_diarios,
	   pedidos,
	   monto_vta_diaria,
	   unidades_vta_diaria,
	   prom_mon_ped_vta_diaria,
	   prom_uni_ped_vta_diaria,
	   monto,
	   unidades,
	   prom_mon_ped,
	   prom_uni_ped
from 
		(-- DATOS (PERIODO Y DIARIO) -- 
			select 
				   decode(por_dia.oid_tipo_ofer,null,por_periodo.oid_tipo_ofer,por_dia.oid_tipo_ofer) AS OID_TIPO_OFER,
				   decode(por_dia.uneg_oid_unid_nego,null,por_periodo.uneg_oid_unid_nego,por_dia.uneg_oid_unid_nego) AS OID_UNID_NEG,
				   decode(por_periodo.periodo,null,por_dia.periodo,por_periodo.periodo) AS PERIODO,
				   NVL(por_dia.monto_vta_diaria,0) AS monto_vta_diaria,
				   NVL(por_dia.unidades_vta_diaria,0) AS unidades_vta_diaria,
				   NVL(por_dia.prom_mon_ped_vta_diaria,0) AS prom_mon_ped_vta_diaria,
				   NVL(por_dia.prom_uni_ped_vta_diaria,0) AS prom_uni_ped_vta_diaria,
  				   NVL(por_dia.pedidos_diarios,0) AS pedidos_diarios,
				   --
				   por_periodo.monto,
				   por_periodo.unidades,
				   por_periodo.prom_mon_ped,
				   por_periodo.prom_uni_ped,
				   por_periodo.pedidos
			from
				(--RESUELVE LA VENTA DIARIA--
					select
						   t_ofer.OID_TIPO_OFER,
						   prod.UNEG_OID_UNID_NEGO, 
					   	   sum(pos.VAL_PREC_TOTA_LOCA) AS monto_vta_diaria,
						   sum(pos.NUM_UNID_ATEN) AS unidades_vta_diaria,
						   decode(count(sol_no_con.oid_soli_cabe),0,0,
						   		sum(pos.VAL_PREC_TOTA_LOCA) / count(sol_no_con.oid_soli_cabe) ) AS prom_mon_ped_vta_diaria,
						   decode(count(sol_no_con.oid_soli_cabe),
						   		 0,
								 0,
					   			 sum(pos.NUM_UNID_ATEN) / count(sol_no_con.oid_soli_cabe)
								 ) AS prom_uni_ped_vta_diaria,
						   count(sol_no_con.oid_soli_cabe) AS pedidos_diarios,
						   per.VAL_NOMB_PERI AS periodo
					from
						(
							select *
							from ped_solic_cabec sol
							where sol.FEC_FACT IS NOT NULL
								  and sol.IND_PEDI_PRUE <> 1
								  and sol.IND_TS_NO_CONSO = 1
						)sol_no_con,
						ped_solic_posic pos,
						ped_estad_posic est_pos,
						ped_tipo_solic_pais t_sol_p,
						ped_tipo_solic t_sol,
						seg_acces acc,
						mae_produ prod,
						cra_perio per,
						cra_perio per2,
						cra_perio per3,
						pre_ofert_detal ofe_det,
						pre_tipo_ofert t_ofer,
						pre_grupo_ofert gru_ofer
					where
						 sol_no_con.oid_soli_cabe = pos.SOCA_OID_SOLI_CABE
						 and pos.ESPO_OID_ESTA_POSI = est_pos.OID_ESTA_POSI
						 and est_pos.COD_ESTA_POSI <> 'AN' 
						 and pos.PROD_OID_PROD = prod.OID_PROD
						 and sol_no_con.perd_oid_peri = per.oid_peri
						 and prod.PERD_OID_PERI_INIC = per2.oid_peri(+)
						 and prod.PERD_OID_PERI_FIN = per3.oid_peri(+)
						 and sol_no_con.TSPA_OID_TIPO_SOLI_PAIS = t_sol_p.OID_TIPO_SOLI_PAIS
						 and t_sol_p.TSOL_OID_TIPO_SOLI = t_sol.OID_TIPO_SOLI
						 and t_sol.ACCE_OID_ACCE = acc.OID_ACCE
						 and pos.OFDE_OID_DETA_OFER = ofe_det.OID_DETA_OFER(+)
						 and ofe_det.TOFE_OID_TIPO_OFER = t_ofer.OID_TIPO_OFER(+)
						 and ofe_det.GOFE_OID_GRUP_OFER = gru_ofer.OID_GRUP_OFER(+)
						 and to_date(sol_no_con.fec_fact) BETWEEN to_date('11/11/2005','dd/mm/yyyy') --PARAMETRO FECHA INICIO (Por Ahora)--
						 	 							  AND 	  to_date('11/11/2015','dd/mm/yyyy') --PARAMETRO FECHA FIN (Por Ahora)--
						 and sol_no_con.perd_OID_PERI = 57 --PARAMETRO--
--						 and prod.NEGO_OID_NEGO in (1) --PARAMETRO--
--						 and prod.UNEG_OID_UNID_NEGO in (1) --PARAMETRO--
--						 and per.FEC_INIC between per2.fec_inic and per3.fec_fina
--					     and sol_no_con.pais_oid_pais = 1 --PARAMETRO--
--						 and acc.CANA_OID_CANA = 1 --PARAMETRO--
--						 and t_sol.MARC_OID_MARC = 1 --PARAMETRO--
--						 and acc.OID_ACCE = 1 --PARAMETRO--*/
					group by 
						  t_ofer.OID_TIPO_OFER,
						 prod.UNEG_OID_UNID_NEGO,
						 per.VAL_NOMB_PERI
				)por_dia,
				(--RESUELVE LA VENTA ACUMULADA--
					select 
						   t_ofer.OID_TIPO_OFER,
						   prod.UNEG_OID_UNID_NEGO, 
					   	   sum(pos.VAL_PREC_TOTA_LOCA) AS monto,
						   sum(pos.NUM_UNID_ATEN) AS unidades,
						   decode(count(sol_no_con.oid_soli_cabe),0,0,
						   		sum(pos.VAL_PREC_TOTA_LOCA) / count(sol_no_con.oid_soli_cabe) )prom_mon_ped,
						   decode(count(sol_no_con.oid_soli_cabe),0,0,
					   			sum(pos.NUM_UNID_ATEN) / count(sol_no_con.oid_soli_cabe) )prom_uni_ped,
						   count(sol_no_con.oid_soli_cabe) AS pedidos,
						   per.VAL_NOMB_PERI AS periodo
					from
						(
							select *
							from ped_solic_cabec sol
							where sol.FEC_FACT IS NOT NULL
								  and sol.IND_PEDI_PRUE <> 1
								  and sol.IND_TS_NO_CONSO = 1
						)sol_no_con,
						ped_solic_posic pos,
						ped_estad_posic est_pos,
						ped_tipo_solic_pais t_sol_p,
						ped_tipo_solic t_sol,
						seg_acces acc,
						mae_produ prod,
						cra_perio per,
						cra_perio per2,
						cra_perio per3,
						pre_ofert_detal ofe_det,
						pre_tipo_ofert t_ofer,
						pre_grupo_ofert gru_ofer
					where
						 sol_no_con.oid_soli_cabe = pos.SOCA_OID_SOLI_CABE
						 and pos.ESPO_OID_ESTA_POSI = est_pos.OID_ESTA_POSI
						 and est_pos.COD_ESTA_POSI <> 'AN' 
						 and pos.PROD_OID_PROD = prod.OID_PROD
						 and sol_no_con.perd_oid_peri = per.oid_peri
						 and prod.PERD_OID_PERI_INIC = per2.oid_peri(+)
						 and prod.PERD_OID_PERI_FIN = per3.oid_peri(+)
						 and sol_no_con.TSPA_OID_TIPO_SOLI_PAIS = t_sol_p.OID_TIPO_SOLI_PAIS
						 and t_sol_p.TSOL_OID_TIPO_SOLI = t_sol.OID_TIPO_SOLI
						 and t_sol.ACCE_OID_ACCE = acc.OID_ACCE
						 and pos.OFDE_OID_DETA_OFER = ofe_det.OID_DETA_OFER(+)
						 and ofe_det.TOFE_OID_TIPO_OFER = t_ofer.OID_TIPO_OFER(+)
						 and ofe_det.GOFE_OID_GRUP_OFER = gru_ofer.OID_GRUP_OFER(+)
						 and sol_no_con.perd_OID_PERI = 57 --PARAMETRO--
--						 and prod.NEGO_OID_NEGO in (1) --PARAMETRO--
--						 and prod.UNEG_OID_UNID_NEGO in (1) --PARAMETRO--
--						 and per.FEC_INIC between per2.fec_inic and per3.fec_fina
--						 and sol_no_con.pais_oid_pais = 1 --PARAMETRO--
--						 and acc.CANA_OID_CANA = 1 --PARAMETRO--
--						 and t_sol.MARC_OID_MARC = 1 --PARAMETRO--
--						 and acc.OID_ACCE = 1 --PARAMETRO--*/
					group by 
						  t_ofer.OID_TIPO_OFER,
						  prod.UNEG_OID_UNID_NEGO,
						  per.VAL_NOMB_PERI
				)por_periodo
			WHERE POR_PERIODO.OID_TIPO_OFER = POR_DIA.OID_TIPO_OFER(+)
			   AND POR_PERIODO.UNEG_OID_UNID_NEGO = POR_DIA.UNEG_OID_UNID_NEGO(+) 
		) datos,
		(
		  	   select val_oid, val_i18n un_neg
			   from v_gen_i18n_sicc gen
			   where attr_enti = 'MAE_UNIDA_NEGOC'
			   		 and idio_oid_idio = 1
		) gen_unid_negoc,
		(
		  	   select val_oid, val_i18n tipo_ofer
			   from v_gen_i18n_sicc gen
			   where attr_enti = 'PRE_TIPO_OFERT'
			   		 and idio_oid_idio = 1
		) gen_t_ofer
where datos.oid_tipo_ofer = gen_t_ofer.val_oid(+)
	  and datos.oid_unid_neg = gen_unid_negoc.val_oid(+)
order by
	  periodo,
	  gen_t_ofer.tipo_ofer,
	  gen_unid_negoc.un_neg
