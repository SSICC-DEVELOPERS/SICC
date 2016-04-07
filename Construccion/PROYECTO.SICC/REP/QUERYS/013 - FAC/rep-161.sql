select 
	   per.val_nomb_peri,
	   productos.producto,
	   productos.cod_sap,
	   count(distinct solicitudes_per_ant.oid_soli_cabe) AS ped_reales,
	   NVL((
		  select sum(fvt.NUM_PEDI)
		  from int_fuent_venta_previ_sap fvt
		  where fvt.PERD_OID_PERI =  solicitudes.perd_oid_peri
	   ),0) AS pedidos_estimados,
	   NVL((
		 select nvl(sum(stk.VAL_SALD),0)
		 from bel_stock stk,
		 	  bel_almac alm
		 where stk.ALMC_OID_ALMA(+) = alm.OID_ALMA
			   and stk.PROD_OID_PROD =  productos.oid_prod
			   and alm.PAIS_OID_PAIS = 1 				  	  --PARAMETRO--
	   ),0) AS stock,
	  ---------------------------------------------------------------------------------------------------------
  	  --ACUMULADO DIA ANTERIOR---------------------------------------------------------------------------------
  	  count(distinct sol_dia_ant.oid_soli_cabe) AS num_sol,
	  NVL(sum(sol_dia_ant.VAL_PREC_NETO_TOTA_LOCA),0) AS neto_local,
	  NVL(sum(sol_dia_ant.NUM_UNID_ATEN),0) AS un_atn,
	  NVL(sum(sol_dia_ant.NUM_UNID_POR_ATEN) - sum(sol_dia_ant.NUM_UNID_ATEN),0) AS  faltantes,
	  decode(sum(sol_dia_ant.NUM_UNID_ATEN),0,0,
	  		sum(sol_dia_ant.VAL_PREC_NETO_TOTA_LOCA) / sum(sol_dia_ant.NUM_UNID_ATEN)) AS vl_venta,
	  decode(count(distinct sol_dia_ant.oid_soli_cabe),0,0,
	  		sum(sol_dia_ant.NUM_UNID_ATEN) / count(distinct sol_dia_ant.oid_soli_cabe)) AS pua,
	  decode(count(distinct sol_dia_ant.oid_soli_cabe),0,0,
	  		(sum(sol_dia_ant.NUM_UNID_POR_ATEN) - sum(sol_dia_ant.NUM_UNID_ATEN)) / count(distinct sol_dia_ant.oid_soli_cabe)) AS puf,
	  --ACUMULADO PERIODO ACTUAL-------------------------------------------------------------------------------
	  count(distinct solicitudes.oid_soli_cabe) AS num_sol_p,
	  NVL(sum(solicitudes.VAL_PREC_NETO_TOTA_LOCA),0) AS neto_local_p,
	  NVL(sum(solicitudes.NUM_UNID_ATEN),0) AS un_atn_p,
	  NVL(sum(solicitudes.NUM_UNID_POR_ATEN) - sum(solicitudes.NUM_UNID_ATEN),0) AS faltantes_p
	  ---------------------------------------------------------------------------------------------------------
from 
	--SOLICITUDES PERIODO ANTERIOR-----------------------------------------------------------------------------
	(
		select sol_no_con.oid_soli_cabe,
			   pos.VAL_PREC_NETO_TOTA_LOCA,
			   pos.NUM_UNID_ATEN,
			   pos.NUM_UNID_POR_ATEN,
			   pos.prod_oid_prod,
			   sol_no_con.perd_oid_peri
	from
	  	(
			 select *
			 from ped_solic_cabec sol
			 where sol.FEC_FACT is not null
			 	   and sol.IND_PEDI_PRUE <> 1
				   and sol.IND_TS_NO_CONSO = 1
		)sol_no_con,
		--CALCULO PERIODO ANTERIOR ---
		(
		 select peri.OID_PERI oid_per_ant
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
		)periodos,
		ped_solic_posic pos,
		ped_estad_posic est_pos,
		ped_tipo_solic_pais t_sol_p,
		ped_tipo_solic t_sol, 
		zon_zona zon
	where
		 sol_no_con.oid_soli_cabe(+) = pos.SOCA_OID_SOLI_CABE
		 and pos.ESPO_OID_ESTA_POSI = est_pos.OID_ESTA_POSI(+)
		 and est_pos.COD_ESTA_POSI(+) <> 'AN'
		 and sol_no_con.ZZON_OID_ZONA = zon.ZORG_OID_REGI
		 and zon.ZORG_OID_REGI in (1) --PARAMETRO--
		 and periodos.oid_per_ant = sol_no_con.perd_oid_peri 
		 and sol_no_con.TSPA_OID_TIPO_SOLI_PAIS = t_sol_p.OID_TIPO_SOLI_PAIS
		 and t_sol_p.TSOL_OID_TIPO_SOLI = t_sol.OID_TIPO_SOLI
		 and t_sol.acce_oid_acce = 1 --PARAMETRO--
	)solicitudes_per_ant
	-----------------------------------------------------------------------------------------------------------
	FULL OUTER JOIN
		--SOLICITUDES DIA ANTERIOR---------------------------------------------------------------------------------
		(
			select sol_no_con.oid_soli_cabe,
				   pos.VAL_PREC_NETO_TOTA_LOCA,
				   pos.NUM_UNID_ATEN,
				   pos.NUM_UNID_POR_ATEN,
				   pos.prod_oid_prod,
				   sol_no_con.perd_oid_peri
		from
		  	(
				 select *
				 from ped_solic_cabec sol
				 where sol.FEC_FACT is not null
				 	   and sol.IND_PEDI_PRUE <> 1
					   and sol.IND_TS_NO_CONSO = 1
			)sol_no_con,
			ped_solic_posic pos,
			ped_estad_posic est_pos,
			ped_tipo_solic_pais t_sol_p,
			ped_tipo_solic t_sol, 
			zon_zona zon
		where
			 sol_no_con.oid_soli_cabe(+) = pos.SOCA_OID_SOLI_CABE
			 and pos.ESPO_OID_ESTA_POSI = est_pos.OID_ESTA_POSI(+)
			 and est_pos.COD_ESTA_POSI(+) <> 'AN'
			 and TO_DATE(sol_no_con.fec_fact) = TO_DATE(SYSDATE-1)
			 and sol_no_con.ZZON_OID_ZONA = zon.ZORG_OID_REGI
			 and zon.ZORG_OID_REGI in (1) --PARAMETRO-- 
	 		 and sol_no_con.TSPA_OID_TIPO_SOLI_PAIS = t_sol_p.OID_TIPO_SOLI_PAIS
			 and t_sol_p.TSOL_OID_TIPO_SOLI = t_sol.OID_TIPO_SOLI
		 	 and t_sol.acce_oid_acce = 1 --PARAMETRO--
		)sol_dia_ant
	ON sol_dia_ant.prod_oid_prod = solicitudes_per_ant.prod_oid_prod
		-----------------------------------------------------------------------------------------------------------
		FULL OUTER JOIN
			--SOLICITUDES PARA PERIODO ACTUAL--------------------------------------------------------------------------
			(
			 select sol_no_con.oid_soli_cabe,
					   pos.VAL_PREC_NETO_TOTA_LOCA,
					   pos.NUM_UNID_ATEN,
					   pos.NUM_UNID_POR_ATEN,
					   pos.prod_oid_prod,
					   sol_no_con.perd_oid_peri
			 from
			  	(
					 select *
					 from ped_solic_cabec sol
					 where sol.FEC_FACT is not null
					 	   and sol.IND_PEDI_PRUE <> 1
						   and sol.IND_TS_NO_CONSO = 1
				)sol_no_con,
				ped_solic_posic pos,
				ped_estad_posic est_pos,
				ped_tipo_solic_pais t_sol_p,
				ped_tipo_solic t_sol, 
				zon_zona zon
			 where
				 sol_no_con.oid_soli_cabe(+) = pos.SOCA_OID_SOLI_CABE
				 and pos.ESPO_OID_ESTA_POSI = est_pos.OID_ESTA_POSI(+)
				 and est_pos.COD_ESTA_POSI(+) <> 'AN'
				 and sol_no_con.perd_oid_peri= 57 --PARAMETRO--
				 and sol_no_con.ZZON_OID_ZONA = zon.ZORG_OID_REGI
				 and zon.ZORG_OID_REGI in (1) --PARAMETRO--
				 and sol_no_con.TSPA_OID_TIPO_SOLI_PAIS = t_sol_p.OID_TIPO_SOLI_PAIS
				 and t_sol_p.TSOL_OID_TIPO_SOLI = t_sol.OID_TIPO_SOLI
				 and t_sol.acce_oid_acce = 1 --PARAMETRO--
			)solicitudes
		ON solicitudes.prod_oid_prod = DECODE(solicitudes_per_ant.prod_oid_prod,NULL,sol_dia_ant.prod_oid_prod,solicitudes_per_ant.prod_oid_prod)
			 ----------------------------------------------------------------------------------------------------------
			INNER JOIN
			--PRODUCTOS------------------------------------------------------------------------------------------------
				--EXCLUYE SOLO LOS REGISTROS QUE NO CUMPLAN CON LA CONDICION PERIODO_ENTRE PERIODO_HASTA--
				--LOS QUE NO TIENEN PERIODO, SE INCLUIRAN-- 
				(
				select OID_PROD, cod_sap, UNEG_OID_UNID_NEGO, nego_oid_nego, gen_prod.producto
				from
					(
					select prod.OID_PROD, prod.cod_sap, prod.UNEG_OID_UNID_NEGO, prod.nego_oid_nego
					from
						mae_produ prod,
						cra_perio per, 
						(
						 select *
						 from cra_perio per 
						 where  per.pais_oid_pais = 1 --PARAMETRO--
							   and per.cana_oid_cana = 1 --PARAMETRO--
							   and per.marc_oid_marc = 1 --PARAMETRO--
						)  per_inic,
						(
						 select *
						 from cra_perio per 
						 where  per.pais_oid_pais = 1 --PARAMETRO--
							   and per.cana_oid_cana = 1 --PARAMETRO--
							   and per.marc_oid_marc = 1 --PARAMETRO--
						)  per_fina
					where
						 prod.PERD_OID_PERI_INIC = per_inic.oid_peri
						 and prod.PERD_OID_PERI_FIN = per_fina.oid_peri
						 and per_inic.fec_inic <= per.FEC_INIC
						 and per_fina.fec_fina >= per.fec_fina
						 and prod.UNEG_OID_UNID_NEGO in (31,51,52) --PARAMETRO--
						 and prod.nego_oid_nego in (31,51,52) --PARAMETRO--
						 and per.oid_peri = 57 --PARAMETRO--
					union
						select prod.OID_PROD, prod.cod_sap, prod.UNEG_OID_UNID_NEGO, prod.nego_oid_nego
						from mae_produ prod
						where ( prod.PERD_OID_PERI_INIC is null
							  or prod.PERD_OID_PERI_FIN is null )
							  and prod.UNEG_OID_UNID_NEGO in (31,51,52) --PARAMETRO--
							  and prod.nego_oid_nego in (31,51,52) --PARAMETRO--
					),
					(
						select val_oid, val_i18n producto
						from v_gen_i18n_sicc
						where attr_enti = 'MAE_PRODU'
							 and idio_oid_idio = 1 --PARAMETRO--
					)gen_prod
					where oid_prod = gen_prod.val_oid(+)
				)productos
			ON productos.oid_prod = solicitudes.prod_oid_prod
				   	   or productos.oid_prod = solicitudes_per_ant.prod_oid_prod
				   	   or productos.oid_prod = sol_dia_ant.prod_oid_prod
				   --------------------------------------------------------------------------------------------------------
	   LEFT JOIN
		   cra_perio per
	   ON per.oid_peri = solicitudes.perd_oid_peri
group by
	   solicitudes.perd_oid_peri,
   	   productos.producto,
	   productos.oid_prod,
	   productos.cod_sap,
	   per.val_nomb_peri
