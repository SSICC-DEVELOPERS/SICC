/*CREATE OR REPLACE function fn_162_total_prod_neg (
	   id_peri_par in varchar,
	   id_region_par in varchar,
	   id_pais_par in varchar,
	   id_marca_par in varchar,
	   id_canal_par in varchar,
	   id_negocio_par in varchar, --PARAMETRO NO OBLIGATORIO, ENDRA -1 -
	   id_un_negocio_par in varchar, --PARAMETRO NO OBLIGATORIO, VENDRA -1 --
	   id_acceso_par in varchar, --PARAMETRO NO OBLIGATORIO, VENDRA -1 --
	   diario_par in varchar:=-1
)*/



(
	select
		  datos_acum.movimiento,
		  datos_acum.val_nomb_peri,
		  datos_acum.negocio,
		  datos_acum.descripcion,
		  datos_acum.monto_neto_acum,
		  datos_acum.por_vs_venta,
		  decode(total_negocio.total,0,0, ( unidades_faltantes / total_negocio.total )) *100 as por_participacion
	from
		(
			select neg.oid_nego, nvl(own_peru.fn_162_total_prod_neg(57,1,1,1,1,neg.oid_nego,1,1),0)total
			from mae_negoc neg
		)total_negocio,
		(
		select
				  'A' as movimiento,
				  per.VAL_NOMB_PERI,
				  productos.nego_oid_nego,
		  		  productos.negocio,
			  	  productos.producto as descripcion,
				  (nvl(sum(solicitudes.NUM_UNID_POR_ATEN),0) - nvl(sum(solicitudes.NUM_UNID_ATEN),0)) unidades_faltantes,
				   --POR PERIODO---------------------------------------------------------------------------------------
				  (nvl(sum(solicitudes.NUM_UNID_POR_ATEN),0) - nvl(sum(solicitudes.NUM_UNID_ATEN),0)) * sum( solicitudes.VAL_PREC_NETO_TOTA_LOCA) monto_neto_acum,
				   ----------------------------------------------------------------------------------------------------
				   decode( sum(solicitudes.NUM_UNID_ATEN)  ,0,0, 
				   		(nvl(sum(solicitudes.NUM_UNID_POR_ATEN),0) - nvl(sum(solicitudes.NUM_UNID_ATEN),0)) / sum(solicitudes.NUM_UNID_ATEN))por_vs_venta
			from (
				--SOLICITUDES PARA PERIODO ACTUAL----------------------------------------------------------------------
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
			/*			 where sol.FEC_FACT is not null
						 	   and sol.IND_PEDI_PRUE <> 1
							   and sol.IND_TS_NO_CONSO = 1*/
					)sol_no_con,
					ped_solic_posic pos,
					ped_estad_posic est_pos,
					zon_zona zon,
					ped_tipo_solic_pais t_sol_p,
					ped_tipo_solic t_sol
				where
					 sol_no_con.oid_soli_cabe = pos.SOCA_OID_SOLI_CABE
					 and pos.ESPO_OID_ESTA_POSI = est_pos.OID_ESTA_POSI(+)
			--		 and est_pos.COD_ESTA_POSI(+) <> 'AN'
					 and pos.NUM_UNID_POR_ATEN > pos.NUM_UNID_ATEN 
--					 and sol_no_con.perd_oid_peri= 57 --PARAMETRO--
					 and sol_no_con.ZZON_OID_ZONA = zon.oid_zona
--					 and zon.ZORG_OID_REGI in (1) --PARAMETRO-- 
					 and sol_no_con.TSPA_OID_TIPO_SOLI_PAIS =  t_sol_p.oid_tipo_soli_pais
					 and t_sol_p.tsol_oid_tipo_soli = t_sol.oid_tipo_soli
					 and t_sol.acce_oid_acce = 1
				)solicitudes
				-------------------------------------------------------------------------------------------------------
				inner join 
				--PRODUCTOS--------------------------------------------------------------------------------------------
				--EXCLUYE SOLO LOS REGISTROS QUE NO CUMPLAN CON LA CONDICION PERIODO_ENTRE PERIODO_HASTA--
				--LOS QUE NO TIENEN PERIODO, SE INCLUIRAN-- 
				(
				select prod_per.OID_PROD, prod_per.cod_sap, prod_per.UNEG_OID_UNID_NEGO, prod_per.nego_oid_nego, gen_neg.negocio,
					   prod_per.producto
				from
					(
					select prod.OID_PROD, prod.cod_sap, prod.UNEG_OID_UNID_NEGO, prod.nego_oid_nego, gen_prod.producto
					from
						mae_produ prod,
						cra_perio per,
						(
						 select val_oid, val_i18n producto
						 from v_gen_i18n_sicc 
						 where attr_enti='MAE_PRODU'
						 	   and idio_oid_idio = 1 --PARAMETRO--
						)gen_prod,
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
--						 and per.oid_peri = 57 --PARAMETRO--
		--				 and prod.UNEG_OID_UNID_NEGO in (31,51,52) --PARAMETRO--
--						 and prod.nego_oid_nego in (31) --PARAMETRO--
						 and prod.oid_prod = gen_prod.val_oid(+)
					union
						select prod.OID_PROD, prod.cod_sap, prod.UNEG_OID_UNID_NEGO, prod.nego_oid_nego, gen_prod.producto
						from mae_produ prod,
							(
							 select val_oid, val_i18n producto
							 from v_gen_i18n_sicc 
							 where attr_enti='MAE_PRODU'
							 	   and idio_oid_idio = 1 --PARAMETRO--
							)gen_prod
						where ( prod.PERD_OID_PERI_INIC is null
							  or prod.PERD_OID_PERI_FIN is null )
		--					  and prod.UNEG_OID_UNID_NEGO in (31,51,52) --PARAMETRO--
--							  and prod.nego_oid_nego in (31) --PARAMETRO--
						 	  and prod.oid_prod = gen_prod.val_oid(+)				  
					)prod_per,
					(
					 select val_oid, val_i18n negocio
					 from v_gen_i18n_sicc
					 where attr_enti = 'MAE_NEGOC'
					 	   and idio_oid_idio = 1
					)gen_neg
				where prod_per.nego_oid_nego = gen_neg.val_oid(+)
				)productos
				-------------------------------------------------------------------------------------------------------
				on solicitudes.prod_oid_prod = productos.oid_prod
				-------------------------------------------------------------------------------------------------------
				inner join cra_perio per
				-------------------------------------------------------------------------------------------------------
				on solicitudes.perd_oid_peri = per.oid_peri
			)
			group by
				  productos.negocio,
				  productos.producto, 
				  per.VAL_NOMB_PERI,
				  productos.nego_oid_nego
		)datos_acum
	where total_negocio.oid_nego = datos_acum.nego_oid_nego
)
---------------------------------------------------------------------------------------------------------------
union
---------------------------------------------------------------------------------------------------------------
(
	select
		  datos_acum.movimiento,
		  datos_acum.val_nomb_peri,
		  datos_acum.negocio,
		  datos_acum.descripcion,
		  datos_acum.monto_neto_acum,
		  datos_acum.por_vs_venta,
		  ( unidades_faltantes / total_negocio.total ) *100 as por_participacion
	from
		(
			select neg.oid_nego, own_peru.fn_162_total_prod_neg(57,1,1,1,1,neg.oid_nego,1,1,1)total
			from mae_negoc neg
		)total_negocio,
		(
		select
				  'D' as movimiento,
				  per.VAL_NOMB_PERI,
				  productos.nego_oid_nego,
		  		  productos.negocio,
			  	  productos.producto as descripcion,
				  (nvl(sum(solicitudes.NUM_UNID_POR_ATEN),0) - nvl(sum(solicitudes.NUM_UNID_ATEN),0)) unidades_faltantes,
				   --POR PERIODO---------------------------------------------------------------------------------------
				  (nvl(sum(solicitudes.NUM_UNID_POR_ATEN),0) - nvl(sum(solicitudes.NUM_UNID_ATEN),0)) * sum( solicitudes.VAL_PREC_NETO_TOTA_LOCA) monto_neto_acum,
				   ----------------------------------------------------------------------------------------------------
				   decode( sum(solicitudes.NUM_UNID_ATEN)  ,0,0, 
				   		(nvl(sum(solicitudes.NUM_UNID_POR_ATEN),0) - nvl(sum(solicitudes.NUM_UNID_ATEN),0)) / sum(solicitudes.NUM_UNID_ATEN))por_vs_venta
			from (
				--SOLICITUDES PARA PERIODO ACTUAL----------------------------------------------------------------------
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
			/*			 where sol.FEC_FACT is not null
						 	   and sol.IND_PEDI_PRUE <> 1
							   and sol.IND_TS_NO_CONSO = 1*/
					)sol_no_con,
					ped_solic_posic pos,
					ped_estad_posic est_pos,
					zon_zona zon,
					ped_tipo_solic_pais t_sol_p,
					ped_tipo_solic t_sol
				where
					 sol_no_con.oid_soli_cabe = pos.SOCA_OID_SOLI_CABE
					 and pos.ESPO_OID_ESTA_POSI = est_pos.OID_ESTA_POSI(+)
			--		 and est_pos.COD_ESTA_POSI(+) <> 'AN'
					 and pos.NUM_UNID_POR_ATEN > pos.NUM_UNID_ATEN 
					 and sol_no_con.perd_oid_peri= 57 --PARAMETRO--
					 and sol_no_con.ZZON_OID_ZONA = zon.oid_zona
					 and zon.ZORG_OID_REGI in (1) --PARAMETRO--
					 and  sol_no_con.FEC_FACT = sysdate - 1
 					 and sol_no_con.TSPA_OID_TIPO_SOLI_PAIS =  t_sol_p.oid_tipo_soli_pais
					 and t_sol_p.tsol_oid_tipo_soli = t_sol.oid_tipo_soli
					 and t_sol.acce_oid_acce = 1
				)solicitudes
				-------------------------------------------------------------------------------------------------------
				inner join 
				--PRODUCTOS--------------------------------------------------------------------------------------------
				--EXCLUYE SOLO LOS REGISTROS QUE NO CUMPLAN CON LA CONDICION PERIODO_ENTRE PERIODO_HASTA--
				--LOS QUE NO TIENEN PERIODO, SE INCLUIRAN-- 
				(
				select prod_per.OID_PROD, prod_per.cod_sap, prod_per.UNEG_OID_UNID_NEGO, prod_per.nego_oid_nego, gen_neg.negocio,
					   prod_per.producto
				from
					(
					select prod.OID_PROD, prod.cod_sap, prod.UNEG_OID_UNID_NEGO, prod.nego_oid_nego, gen_prod.producto
					from
						mae_produ prod,
						cra_perio per,
						(
						 select val_oid, val_i18n producto
						 from v_gen_i18n_sicc 
						 where attr_enti='MAE_PRODU'
						 	   and idio_oid_idio = 1 --PARAMETRO--
						)gen_prod,
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
						 and per.oid_peri = 57 --PARAMETRO--
		--				 and prod.UNEG_OID_UNID_NEGO in (31,51,52) --PARAMETRO--
						 and prod.nego_oid_nego in (31) --PARAMETRO--
						 and prod.oid_prod = gen_prod.val_oid(+)
					union
						select prod.OID_PROD, prod.cod_sap, prod.UNEG_OID_UNID_NEGO, prod.nego_oid_nego, gen_prod.producto
						from mae_produ prod,
							(
							 select val_oid, val_i18n producto
							 from v_gen_i18n_sicc 
							 where attr_enti='MAE_PRODU'
							 	   and idio_oid_idio = 1 --PARAMETRO--
							)gen_prod
						where ( prod.PERD_OID_PERI_INIC is null
							  or prod.PERD_OID_PERI_FIN is null )
		--					  and prod.UNEG_OID_UNID_NEGO in (31,51,52) --PARAMETRO--
							  and prod.nego_oid_nego in (31) --PARAMETRO--
						 	  and prod.oid_prod = gen_prod.val_oid(+)				  
					)prod_per,
					(
					 select val_oid, val_i18n negocio
					 from v_gen_i18n_sicc
					 where attr_enti = 'MAE_NEGOC'
					 	   and idio_oid_idio = 1
					)gen_neg
				where prod_per.nego_oid_nego = gen_neg.val_oid(+)
				)productos
				-------------------------------------------------------------------------------------------------------
				on solicitudes.prod_oid_prod = productos.oid_prod
				-------------------------------------------------------------------------------------------------------
				inner join cra_perio per
				-------------------------------------------------------------------------------------------------------
				on solicitudes.perd_oid_peri = per.oid_peri
			)
			group by
				  productos.negocio,
				  productos.producto, 
				  per.VAL_NOMB_PERI,
				  productos.nego_oid_nego
		)datos_acum
	where total_negocio.oid_nego = datos_acum.nego_oid_nego
)