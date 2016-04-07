select
	   grupo,
	   PAIS,
	   cod_peri,
	   anio_actual,
	   anio_1,
	   anio_2,
	   monto_anio_actual * 100 / decode(anio_actual_ult_per,0,20,anio_actual_ult_per)as monto_anio_actual, --OJO!!!! 20 ES PARAMETRO NúMERO PEDIDOS AñO ANTERIOR--
   	   monto_anio_1 * 100 / decode(anio_1_ult_per,0,20,anio_1_ult_per)as monto_anio_1, --OJO!!!! 20 ES PARAMETRO NúMERO PEDIDOS AñO ANTERIOR--
   	   monto_anio_2 * 100 / decode(anio_2_ult_per,0,20,anio_2_ult_per)as monto_anio_2 --OJO!!!! 20 ES PARAMETRO NúMERO PEDIDOS AñO ANTERIOR--
from 
(
	select 
		   paises.descripcion AS PAIS, 
		   periodos.cod_peri,
		   periodos.anio_actual,
		   periodos.anio_1,
		   periodos.anio_2,
		   (
		   	select count(distinct sol.oid_soli_cabe)
			from ped_solic_cabec sol,
				 ped_solic_posic pos,
				 cra_perio per,
				 seg_perio_corpo cor,
				 mae_produ prod,
				 mae_clien cli,
				 mae_clien_tipo_subti tip_subt,
				 mae_clien_clasi cla,
				 mae_subti_clien subt,
				 mae_tipo_clasi_clien tip_cla 
			where sol.oid_soli_cabe = pos.soca_oid_soli_cabe
				  and cor.OID_PERI = per.PERI_OID_PERI
				  and sol.PERD_OID_PERI = peR.oid_peri
				  and pos.PROD_OID_PROD = prod.oid_prod
				  --
				  and sol.CLIE_OID_CLIE = cli.oid_clie
				  and cli.OID_CLIE = tip_subt.CLIE_OID_CLIE
				  and tip_subt.OID_CLIE_TIPO_SUBT = cla.CTSU_OID_CLIE_TIPO_SUBT
				  and tip_subt.SBTI_OID_SUBT_CLIE = subt.OID_SUBT_CLIE
				  and subt.OID_SUBT_CLIE = tip_cla.SBTI_OID_SUBT_CLIE
				  and tip_cla.OID_TIPO_CLAS = cla.TCCL_OID_TIPO_CLASI
				  --			  
				  and substr(cor.COD_PERI,5,2) = periodos.cod_peri  
				  and cor.VAL_ANIO = 2005 --PARAMETRO ANIO--
				  and sol.PAIS_OID_PAIS = paises.oid_pais
				  and per.CANA_OID_CANA = 1 --PARAMETRO CANAL--
				  and per.marc_oid_marc = 1 --PARAMETRO MARCA--
				  and tip_subt.TICL_OID_TIPO_CLIE in (1) --PARAMETRO TIPO CLIENTE--
				  and tip_subt.SBTI_OID_SUBT_CLIE in (1) --PARAMETRO SUBTIPO CLIENTE--
				  and cla.CLAS_OID_CLAS in (1) --PARAMETRO CLASIFICACION--
				  and cla.TCCL_OID_TIPO_CLASI in (1) --PARAMETRO TIPO CLASIFICACION--
				  and prod.NEGO_OID_NEGO in (1) --PARAMETRO NEGOCIO--
				  and prod.UNEG_OID_UNID_NEGO in (1) --PARAMETRO UNIDAD DE NEGOCIO--
			)as monto_anio_actual,
			(
		   	select count(distinct sol.oid_soli_cabe)
			from ped_solic_cabec sol,
				 ped_solic_posic pos,
				 cra_perio per,
				 seg_perio_corpo cor,
	 			 mae_produ prod,
				 mae_clien cli,
				 mae_clien_tipo_subti tip_subt,
				 mae_clien_clasi cla,
				 mae_subti_clien subt,
				 mae_tipo_clasi_clien tip_cla
			where sol.oid_soli_cabe = pos.soca_oid_soli_cabe
				  and cor.OID_PERI = per.PERI_OID_PERI
				  and sol.PERD_OID_PERI = per.oid_peri
	  			  and pos.PROD_OID_PROD = prod.oid_prod
				  --
				  and sol.CLIE_OID_CLIE = cli.oid_clie
				  and cli.OID_CLIE = tip_subt.CLIE_OID_CLIE
				  and tip_subt.OID_CLIE_TIPO_SUBT = cla.CTSU_OID_CLIE_TIPO_SUBT
				  and tip_subt.SBTI_OID_SUBT_CLIE = subt.OID_SUBT_CLIE
				  and subt.OID_SUBT_CLIE = tip_cla.SBTI_OID_SUBT_CLIE
				  and tip_cla.OID_TIPO_CLAS = cla.TCCL_OID_TIPO_CLASI
				  --			  
	  			  and cor.VAL_ANIO = 2005 -1 --PARAMETRO ANIO--
				  and sol.PAIS_OID_PAIS = paises.oid_pais
	  			  and per.CANA_OID_CANA = 1 --PARAMETRO CANAL--
				  and per.marc_oid_marc = 1 --PARAMETRO MARCA--
				  and tip_subt.TICL_OID_TIPO_CLIE in (1) --PARAMETRO TIPO CLIENTE--
				  and tip_subt.SBTI_OID_SUBT_CLIE in (1) --PARAMETRO SUBTIPO CLIENTE--
				  and cla.CLAS_OID_CLAS in (1) --PARAMETRO CLASIFICACION--
				  and cla.TCCL_OID_TIPO_CLASI in (1) --PARAMETRO TIPO CLASIFICACION--
				  and prod.NEGO_OID_NEGO in (1) --PARAMETRO NEGOCIO--
				  and prod.UNEG_OID_UNID_NEGO in (1) --PARAMETRO UNIDAD DE NEGOCIO--
				  and substr(cor.COD_PERI,5,2) =
				  	  							-- periodo último del año anterior al más antiguo --
												(
													select cod_peri
													from (
														 select substr(cor.COD_PERI,5,2)as cod_peri
														 from seg_perio_corpo cor
														 where cor.val_anio = 2005 - 1--2005 ES PARAMETRO ANIO--
														 order by substr(cor.COD_PERI,5,2) desc
													)
													where rownum = 1
												)
												----------------------------------------------------------------			  
			) as anio_actual_ult_per,
			-------------------------------------------------------------------------------------------------------
		   (
		   	select count(distinct sol.oid_soli_cabe)
			from ped_solic_cabec sol,
				 ped_solic_posic pos,
				 cra_perio per,
				 seg_perio_corpo cor,
				 mae_produ prod,
				 mae_clien cli,
				 mae_clien_tipo_subti tip_subt,
				 mae_clien_clasi cla,
				 mae_subti_clien subt,
				 mae_tipo_clasi_clien tip_cla 
			where sol.oid_soli_cabe = pos.soca_oid_soli_cabe
				  and cor.OID_PERI = per.PERI_OID_PERI
				  and sol.PERD_OID_PERI = peR.oid_peri
				  and pos.PROD_OID_PROD = prod.oid_prod
				  --
				  and sol.CLIE_OID_CLIE = cli.oid_clie
				  and cli.OID_CLIE = tip_subt.CLIE_OID_CLIE
				  and tip_subt.OID_CLIE_TIPO_SUBT = cla.CTSU_OID_CLIE_TIPO_SUBT
				  and tip_subt.SBTI_OID_SUBT_CLIE = subt.OID_SUBT_CLIE
				  and subt.OID_SUBT_CLIE = tip_cla.SBTI_OID_SUBT_CLIE
				  and tip_cla.OID_TIPO_CLAS = cla.TCCL_OID_TIPO_CLASI
				  --			  
				  and substr(cor.COD_PERI,5,2) = periodos.cod_peri  
				  and cor.VAL_ANIO = 2005 -1 --PARAMETRO ANIO--
				  and sol.PAIS_OID_PAIS = paises.oid_pais
				  and per.CANA_OID_CANA = 1 --PARAMETRO CANAL--
				  and per.marc_oid_marc = 1 --PARAMETRO MARCA--
				  and tip_subt.TICL_OID_TIPO_CLIE in (1) --PARAMETRO TIPO CLIENTE--
				  and tip_subt.SBTI_OID_SUBT_CLIE in (1) --PARAMETRO SUBTIPO CLIENTE--
				  and cla.CLAS_OID_CLAS in (1) --PARAMETRO CLASIFICACION--
				  and cla.TCCL_OID_TIPO_CLASI in (1) --PARAMETRO TIPO CLASIFICACION--
				  and prod.NEGO_OID_NEGO in (1) --PARAMETRO NEGOCIO--
				  and prod.UNEG_OID_UNID_NEGO in (1) --PARAMETRO UNIDAD DE NEGOCIO--
			) as monto_anio_1,
			(
		   	select count(distinct sol.oid_soli_cabe)
			from ped_solic_cabec sol,
				 ped_solic_posic pos,
				 cra_perio per,
				 seg_perio_corpo cor,
	 			 mae_produ prod,
				 mae_clien cli,
				 mae_clien_tipo_subti tip_subt,
				 mae_clien_clasi cla,
				 mae_subti_clien subt,
				 mae_tipo_clasi_clien tip_cla
			where sol.oid_soli_cabe = pos.soca_oid_soli_cabe
				  and cor.OID_PERI = per.PERI_OID_PERI
				  and sol.PERD_OID_PERI = per.oid_peri
	  			  and pos.PROD_OID_PROD = prod.oid_prod
				  --
				  and sol.CLIE_OID_CLIE = cli.oid_clie
				  and cli.OID_CLIE = tip_subt.CLIE_OID_CLIE
				  and tip_subt.OID_CLIE_TIPO_SUBT = cla.CTSU_OID_CLIE_TIPO_SUBT
				  and tip_subt.SBTI_OID_SUBT_CLIE = subt.OID_SUBT_CLIE
				  and subt.OID_SUBT_CLIE = tip_cla.SBTI_OID_SUBT_CLIE
				  and tip_cla.OID_TIPO_CLAS = cla.TCCL_OID_TIPO_CLASI
				  --			  
	  			  and cor.VAL_ANIO = 2005 -2 --PARAMETRO ANIO--
				  and sol.PAIS_OID_PAIS = paises.oid_pais
	   			  and per.CANA_OID_CANA = 1 --PARAMETRO CANAL--
				  and per.marc_oid_marc = 1 --PARAMETRO MARCA--
				  and tip_subt.TICL_OID_TIPO_CLIE in (1) --PARAMETRO TIPO CLIENTE--
				  and tip_subt.SBTI_OID_SUBT_CLIE in (1) --PARAMETRO SUBTIPO CLIENTE--
				  and cla.CLAS_OID_CLAS in (1) --PARAMETRO CLASIFICACION--
				  and cla.TCCL_OID_TIPO_CLASI in (1) --PARAMETRO TIPO CLASIFICACION--
				  and prod.NEGO_OID_NEGO in (1) --PARAMETRO NEGOCIO--
				  and prod.UNEG_OID_UNID_NEGO in (1) --PARAMETRO UNIDAD DE NEGOCIO--
				  and substr(cor.COD_PERI,5,2) =
				  	  							-- periodo último del año anterior al más antiguo --
												(
													select cod_peri
													from (
														 select substr(cor.COD_PERI,5,2)as cod_peri
														 from seg_perio_corpo cor
														 where cor.val_anio = 2005 - 2--2005 ES PARAMETRO ANIO--
														 order by substr(cor.COD_PERI,5,2) desc
													)
													where rownum = 1
												)
												----------------------------------------------------------------			  
			)anio_1_ult_per,
			-------------------------------------------------------------------------------------------------------
		   (
		   	select count(distinct sol.oid_soli_cabe)
			from ped_solic_cabec sol,
				 ped_solic_posic pos,
				 cra_perio per,
				 seg_perio_corpo cor,
				 mae_produ prod,
				 mae_clien cli,
				 mae_clien_tipo_subti tip_subt,
				 mae_clien_clasi cla,
				 mae_subti_clien subt,
				 mae_tipo_clasi_clien tip_cla 
			where sol.oid_soli_cabe = pos.soca_oid_soli_cabe
				  and cor.OID_PERI = per.PERI_OID_PERI
				  and sol.PERD_OID_PERI = peR.oid_peri
				  and pos.PROD_OID_PROD = prod.oid_prod
				  --
				  and sol.CLIE_OID_CLIE = cli.oid_clie
				  and cli.OID_CLIE = tip_subt.CLIE_OID_CLIE
				  and tip_subt.OID_CLIE_TIPO_SUBT = cla.CTSU_OID_CLIE_TIPO_SUBT
				  and tip_subt.SBTI_OID_SUBT_CLIE = subt.OID_SUBT_CLIE
				  and subt.OID_SUBT_CLIE = tip_cla.SBTI_OID_SUBT_CLIE
				  and tip_cla.OID_TIPO_CLAS = cla.TCCL_OID_TIPO_CLASI
				  --			  
				  and substr(cor.COD_PERI,5,2) = periodos.cod_peri  
				  and cor.VAL_ANIO = 2005 -2 --PARAMETRO ANIO--
				  and sol.PAIS_OID_PAIS = paises.oid_pais
				  and per.CANA_OID_CANA = 1 --PARAMETRO CANAL--
				  and per.marc_oid_marc = 1 --PARAMETRO MARCA--
				  and tip_subt.TICL_OID_TIPO_CLIE in (1) --PARAMETRO TIPO CLIENTE--
				  and tip_subt.SBTI_OID_SUBT_CLIE in (1) --PARAMETRO SUBTIPO CLIENTE--
				  and cla.CLAS_OID_CLAS in (1) --PARAMETRO CLASIFICACION--
				  and cla.TCCL_OID_TIPO_CLASI in (1) --PARAMETRO TIPO CLASIFICACION--
				  and prod.NEGO_OID_NEGO in (1) --PARAMETRO NEGOCIO--
				  and prod.UNEG_OID_UNID_NEGO in (1) --PARAMETRO UNIDAD DE NEGOCIO--
			)monto_anio_2,
			(
		   	select count(distinct sol.oid_soli_cabe)
			from ped_solic_cabec sol,
				 ped_solic_posic pos,
				 cra_perio per,
				 seg_perio_corpo cor,
	 			 mae_produ prod,
				 mae_clien cli,
				 mae_clien_tipo_subti tip_subt,
				 mae_clien_clasi cla,
				 mae_subti_clien subt,
				 mae_tipo_clasi_clien tip_cla
			where sol.oid_soli_cabe = pos.soca_oid_soli_cabe
				  and cor.OID_PERI = per.PERI_OID_PERI
				  and sol.PERD_OID_PERI = per.oid_peri
	  			  and pos.PROD_OID_PROD = prod.oid_prod
				  --
				  and sol.CLIE_OID_CLIE = cli.oid_clie
				  and cli.OID_CLIE = tip_subt.CLIE_OID_CLIE
				  and tip_subt.OID_CLIE_TIPO_SUBT = cla.CTSU_OID_CLIE_TIPO_SUBT
				  and tip_subt.SBTI_OID_SUBT_CLIE = subt.OID_SUBT_CLIE
				  and subt.OID_SUBT_CLIE = tip_cla.SBTI_OID_SUBT_CLIE
				  and tip_cla.OID_TIPO_CLAS = cla.TCCL_OID_TIPO_CLASI
				  --			  
	  			  and cor.VAL_ANIO = 2005 -3 --PARAMETRO ANIO--
				  and sol.PAIS_OID_PAIS = paises.oid_pais
	   			  and per.CANA_OID_CANA = 1 --PARAMETRO CANAL--
				  and per.marc_oid_marc = 1 --PARAMETRO MARCA--
				  and tip_subt.TICL_OID_TIPO_CLIE in (1) --PARAMETRO TIPO CLIENTE--
				  and tip_subt.SBTI_OID_SUBT_CLIE in (1) --PARAMETRO SUBTIPO CLIENTE--
				  and cla.CLAS_OID_CLAS in (1) --PARAMETRO CLASIFICACION--
				  and cla.TCCL_OID_TIPO_CLASI in (1) --PARAMETRO TIPO CLASIFICACION--
				  and prod.NEGO_OID_NEGO in (1) --PARAMETRO NEGOCIO--
				  and prod.UNEG_OID_UNID_NEGO in (1) --PARAMETRO UNIDAD DE NEGOCIO--
				  and substr(cor.COD_PERI,5,2) =
				  	  							-- periodo último del año anterior al más antiguo --
												(
													select cod_peri
													from (
														 select substr(cor.COD_PERI,5,2)as cod_peri
														 from seg_perio_corpo cor
														 where cor.val_anio = 2005 - 3--2005 ES PARAMETRO ANIO--
														 order by substr(cor.COD_PERI,5,2) desc
													)
													where rownum = 1
												)
												----------------------------------------------------------------			  
			)as anio_2_ult_per,
			trunc((periodos.cod_peri-1)/6) as grupo
	from (
		  select substr(cor.COD_PERI,5,2)as cod_peri, val_anio as anio_actual, val_anio -1 as anio_1, val_anio-2 as anio_2
		  from seg_perio_corpo cor
		  where cor.val_anio = 2005 --PARAMETRO ANIO--
		  order by substr(cor.COD_PERI,5,2)
		 )periodos,
		 (
		  select pai.oid_pais, gen.val_i18n DESCRIPCION
		  from seg_pais pai,
		  	   v_gen_i18n_sicc gen
		  where pai.oid_pais in (1,2,3,4,5,6,7,8,9) --PARAMETRO PAIS--
		  		and gen.ATTR_ENTI = 'SEG_PAIS'
				and idio_oid_idio = 4 --PARAMETRO IDIOMA--
				and gen.VAL_OID(+) = pai.oid_pais
		 )paises
)
UNION
(
select 99999 AS grupo,
	   PAIS,
	   NULL,
	   NULL,
	   NULL,
	   NULL,
	   decode(anio_actual_ult_per,0,20,anio_actual_ult_per) as anio_actual_ult_per, --OJO!!!! 20 ES PARAMETRO NúMERO PEDIDOS AñO ANTERIOR--
   	   decode(anio_1_ult_per,0,20,anio_1_ult_per) as anio_1_ult_per, --OJO!!!! 20 ES PARAMETRO NúMERO PEDIDOS AñO ANTERIOR--
   	   decode(anio_2_ult_per,0,20,anio_2_ult_per) as anio_2_ult_per --OJO!!!! 20 ES PARAMETRO NúMERO PEDIDOS AñO ANTERIOR--
from
	(
	select 
		   paises.descripcion AS PAIS, 
			(
		   	select count(distinct sol.oid_soli_cabe)
			from ped_solic_cabec sol,
				 ped_solic_posic pos,
				 cra_perio per,
				 seg_perio_corpo cor,
	 			 mae_produ prod,
				 mae_clien cli,
				 mae_clien_tipo_subti tip_subt,
				 mae_clien_clasi cla,
				 mae_subti_clien subt,
				 mae_tipo_clasi_clien tip_cla
			where sol.oid_soli_cabe = pos.soca_oid_soli_cabe
				  and cor.OID_PERI = per.PERI_OID_PERI
				  and sol.PERD_OID_PERI = per.oid_peri
	  			  and pos.PROD_OID_PROD = prod.oid_prod
				  --
				  and sol.CLIE_OID_CLIE = cli.oid_clie
				  and cli.OID_CLIE = tip_subt.CLIE_OID_CLIE
				  and tip_subt.OID_CLIE_TIPO_SUBT = cla.CTSU_OID_CLIE_TIPO_SUBT
				  and tip_subt.SBTI_OID_SUBT_CLIE = subt.OID_SUBT_CLIE
				  and subt.OID_SUBT_CLIE = tip_cla.SBTI_OID_SUBT_CLIE
				  and tip_cla.OID_TIPO_CLAS = cla.TCCL_OID_TIPO_CLASI
				  --			  
	  			  and cor.VAL_ANIO = 2005 -1 --PARAMETRO ANIO--
				  and sol.PAIS_OID_PAIS = paises.oid_pais
	  			  and per.CANA_OID_CANA = 1 --PARAMETRO CANAL--
				  and per.marc_oid_marc = 1 --PARAMETRO MARCA--
				  and tip_subt.TICL_OID_TIPO_CLIE in (1) --PARAMETRO TIPO CLIENTE--
				  and tip_subt.SBTI_OID_SUBT_CLIE in (1) --PARAMETRO SUBTIPO CLIENTE--
				  and cla.CLAS_OID_CLAS in (1) --PARAMETRO CLASIFICACION--
				  and cla.TCCL_OID_TIPO_CLASI in (1) --PARAMETRO TIPO CLASIFICACION--
				  and prod.NEGO_OID_NEGO in (1) --PARAMETRO NEGOCIO--
				  and prod.UNEG_OID_UNID_NEGO in (1) --PARAMETRO UNIDAD DE NEGOCIO--
				  and substr(cor.COD_PERI,5,2) =
				  	  							-- periodo último del año anterior al más antiguo --
												(
													select cod_peri
													from (
														 select substr(cor.COD_PERI,5,2)as cod_peri
														 from seg_perio_corpo cor
														 where cor.val_anio = 2005 - 1--2005 ES PARAMETRO ANIO--
														 order by substr(cor.COD_PERI,5,2) desc
													)
													where rownum = 1
												)
												----------------------------------------------------------------			  
			) as anio_actual_ult_per,
			(
		   	select count(distinct sol.oid_soli_cabe)
			from ped_solic_cabec sol,
				 ped_solic_posic pos,
				 cra_perio per,
				 seg_perio_corpo cor,
	 			 mae_produ prod,
				 mae_clien cli,
				 mae_clien_tipo_subti tip_subt,
				 mae_clien_clasi cla,
				 mae_subti_clien subt,
				 mae_tipo_clasi_clien tip_cla
			where sol.oid_soli_cabe = pos.soca_oid_soli_cabe
				  and cor.OID_PERI = per.PERI_OID_PERI
				  and sol.PERD_OID_PERI = per.oid_peri
	  			  and pos.PROD_OID_PROD = prod.oid_prod
				  --
				  and sol.CLIE_OID_CLIE = cli.oid_clie
				  and cli.OID_CLIE = tip_subt.CLIE_OID_CLIE
				  and tip_subt.OID_CLIE_TIPO_SUBT = cla.CTSU_OID_CLIE_TIPO_SUBT
				  and tip_subt.SBTI_OID_SUBT_CLIE = subt.OID_SUBT_CLIE
				  and subt.OID_SUBT_CLIE = tip_cla.SBTI_OID_SUBT_CLIE
				  and tip_cla.OID_TIPO_CLAS = cla.TCCL_OID_TIPO_CLASI
				  --			  
	  			  and cor.VAL_ANIO = 2005 -2 --PARAMETRO ANIO--
				  and sol.PAIS_OID_PAIS = paises.oid_pais
	   			  and per.CANA_OID_CANA = 1 --PARAMETRO CANAL--
				  and per.marc_oid_marc = 1 --PARAMETRO MARCA--
				  and tip_subt.TICL_OID_TIPO_CLIE in (1) --PARAMETRO TIPO CLIENTE--
				  and tip_subt.SBTI_OID_SUBT_CLIE in (1) --PARAMETRO SUBTIPO CLIENTE--
				  and cla.CLAS_OID_CLAS in (1) --PARAMETRO CLASIFICACION--
				  and cla.TCCL_OID_TIPO_CLASI in (1) --PARAMETRO TIPO CLASIFICACION--
				  and prod.NEGO_OID_NEGO in (1) --PARAMETRO NEGOCIO--
				  and prod.UNEG_OID_UNID_NEGO in (1) --PARAMETRO UNIDAD DE NEGOCIO--
				  and substr(cor.COD_PERI,5,2) =
				  	  							-- periodo último del año anterior al más antiguo --
												(
													select cod_peri
													from (
														 select substr(cor.COD_PERI,5,2)as cod_peri
														 from seg_perio_corpo cor
														 where cor.val_anio = 2005 - 2--2005 ES PARAMETRO ANIO--
														 order by substr(cor.COD_PERI,5,2) desc
													)
													where rownum = 1
												)
												----------------------------------------------------------------			  
			)anio_1_ult_per,
			(
		   	select count(distinct sol.oid_soli_cabe)
			from ped_solic_cabec sol,
				 ped_solic_posic pos,
				 cra_perio per,
				 seg_perio_corpo cor,
	 			 mae_produ prod,
				 mae_clien cli,
				 mae_clien_tipo_subti tip_subt,
				 mae_clien_clasi cla,
				 mae_subti_clien subt,
				 mae_tipo_clasi_clien tip_cla
			where sol.oid_soli_cabe = pos.soca_oid_soli_cabe
				  and cor.OID_PERI = per.PERI_OID_PERI
				  and sol.PERD_OID_PERI = per.oid_peri
	  			  and pos.PROD_OID_PROD = prod.oid_prod
				  --
				  and sol.CLIE_OID_CLIE = cli.oid_clie
				  and cli.OID_CLIE = tip_subt.CLIE_OID_CLIE
				  and tip_subt.OID_CLIE_TIPO_SUBT = cla.CTSU_OID_CLIE_TIPO_SUBT
				  and tip_subt.SBTI_OID_SUBT_CLIE = subt.OID_SUBT_CLIE
				  and subt.OID_SUBT_CLIE = tip_cla.SBTI_OID_SUBT_CLIE
				  and tip_cla.OID_TIPO_CLAS = cla.TCCL_OID_TIPO_CLASI
				  --			  
	  			  and cor.VAL_ANIO = 2005 -3 --PARAMETRO ANIO--
				  and sol.PAIS_OID_PAIS = paises.oid_pais
	   			  and per.CANA_OID_CANA = 1 --PARAMETRO CANAL--
				  and per.marc_oid_marc = 1 --PARAMETRO MARCA--
				  and tip_subt.TICL_OID_TIPO_CLIE in (1) --PARAMETRO TIPO CLIENTE--
				  and tip_subt.SBTI_OID_SUBT_CLIE in (1) --PARAMETRO SUBTIPO CLIENTE--
				  and cla.CLAS_OID_CLAS in (1) --PARAMETRO CLASIFICACION--
				  and cla.TCCL_OID_TIPO_CLASI in (1) --PARAMETRO TIPO CLASIFICACION--
				  and prod.NEGO_OID_NEGO in (1) --PARAMETRO NEGOCIO--
				  and prod.UNEG_OID_UNID_NEGO in (1) --PARAMETRO UNIDAD DE NEGOCIO--
				  and substr(cor.COD_PERI,5,2) =
				  	  							-- periodo último del año anterior al más antiguo --
												(
													select cod_peri
													from (
														 select substr(cor.COD_PERI,5,2)as cod_peri
														 from seg_perio_corpo cor
														 where cor.val_anio = 2005 - 3--2005 ES PARAMETRO ANIO--
														 order by substr(cor.COD_PERI,5,2) desc
													)
													where rownum = 1
												)
												----------------------------------------------------------------			  
			)as anio_2_ult_per
	from (
		  select pai.oid_pais, gen.val_i18n DESCRIPCION
		  from seg_pais pai,
		  	   v_gen_i18n_sicc gen
		  where pai.oid_pais in (1,2,3,4,5,6,7,8,9) --PARAMETRO PAIS--
		  		and gen.ATTR_ENTI = 'SEG_PAIS'
				and idio_oid_idio = 4 --PARAMETRO IDIOMA--
				and gen.VAL_OID(+) = pai.oid_pais
		 )paises
	)
)
order by	  PAIS, GRUPO, COD_PERI