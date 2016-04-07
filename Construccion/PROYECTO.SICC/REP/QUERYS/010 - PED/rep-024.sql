select
	  pais,
  	  marca,
	  canal,
  	  val_nomb_peri,
	  acceso,
	  DES_REGI,
  	  gerente_reg,
	  COD_ZONA,
	  DES_ZONA,
	  gerente_zon,
	  OID_MARC, 
	  OID_CANA,
	  OID_REGI,
	  pais_oid_pais,
	  OID_PERI,
	  OID_ACCE,
  	  oid_zona,
	  estimado,
	  recibido,
	  facturado,
	  real_recibido,
	  recibido_per_ant,
	  pedidos_nuevas,
	  decode(estimado,0,0,facturado/estimado*100) AS por_alcanzado
from 
(
	select
		  comb.pais,
	  	  comb.marca,
		  comb.canal,
	  	  comb.val_nomb_peri,
		  comb.acceso,
		  comb.DES_REGI,
		  comb.COD_ZONA,
		  comb.DES_ZONA,
	  	  comb.gerente_reg,
		  comb.gerente_zon,
		  comb.OID_MARC, 
		  comb.OID_CANA,
		  comb.OID_REGI,
		  comb.pais_oid_pais,
		  solic.OID_PERI,
		  comb.OID_ACCE,
	  	  solic.oid_zona,
		  --ESTIMADO--
		  case
		  	  when decode(solic.oid_peri,null,0,1) = 1 then
			  	nvl(   (
				   	select SUM(fvt.NUM_ORDE)
					from int_fuent_venta_previ_sap fvt,
						 cra_perio per_fvt
					where fvt.perD_oid_peri = per_fvt.OID_PERI
						  and per_fvt.OID_PERI = solic.oid_peri
						  and fvt.ZZON_OID_ZONA = solic.oid_zona
					group by fvt.ZZON_OID_ZONA,
						   per_fvt.OID_PERI
					),0)
			  else 0
		  end AS estimado,
		  --RECIBIDO--
		  case
		  	   when decode(solic.OID_PERI,null,0,1) = 1 then 
			   nvl(( 
		  	  select
		  	  		  count(sol.oid_soli_cabe)
		  		from seg_marca mar,
		  			 seg_canal can,
		  			 seg_acces acc,
		  			 ped_tipo_solic t_sol,
		  			 ped_solic_cabec sol,
		  			 ped_tipo_solic_pais t_sol_p,
		  			 zon_zona zon,
		  			 cra_perio per
		  		where sol.TSPA_OID_TIPO_SOLI_PAIS = t_sol_p.OID_TIPO_SOLI_PAIS 
		  			  and t_sol_p.TSOL_OID_TIPO_SOLI = t_sol.OID_TIPO_SOLI
		  			  and t_sol.MARC_OID_MARC = mar.OID_MARC
		  			  and t_sol.ACCE_OID_ACCE = acc.OID_ACCE
		  			  and acc.CANA_OID_CANA = can.OID_CANA
		  			  and sol.ZZON_OID_ZONA= zon.OID_ZONA
		  			  and sol.PERD_OID_PERI = per.OID_PERI
		  			  and sol.IND_TS_NO_CONSO = 1
		  			  and sol.IND_PEDI_PRUE <> 1
		  			  and sol.FEC_FACT is null
		  			  and per.OID_PERI = solic.oid_peri
		  			  and sol.ZZON_OID_ZONA = solic.oid_zona
		  			  and mar.OID_MARC = comb.oid_marc
					  and can.oid_cana = comb.oid_cana
					  and t_sol_p.PAIS_OID_PAIS = comb.pais_oid_pais
					  and acc.OID_ACCE = comb.oid_acce
				),0)
	   	  else 0
		  end AS recibido,
		  --FACTURADO
	  	  case 
		  	   when decode(solic.OID_PERI,null,0,1) = 1 then
			   nvl(( 
		  	  select
		  	  		  count(sol.oid_soli_cabe)
		  		from seg_marca mar,
		  			 seg_canal can,
		  			 seg_acces acc,
		  			 ped_tipo_solic t_sol,
		  			 ped_solic_cabec sol,
		  			 ped_tipo_solic_pais t_sol_p,
		  			 zon_zona zon,
		  			 cra_perio per
		  		where sol.TSPA_OID_TIPO_SOLI_PAIS = t_sol_p.OID_TIPO_SOLI_PAIS 
		  			  and t_sol_p.TSOL_OID_TIPO_SOLI = t_sol.OID_TIPO_SOLI
		  			  and t_sol.MARC_OID_MARC = mar.OID_MARC
		  			  and t_sol.ACCE_OID_ACCE = acc.OID_ACCE
		  			  and acc.CANA_OID_CANA = can.OID_CANA
		  			  and sol.ZZON_OID_ZONA= zon.OID_ZONA
		  			  and sol.PERD_OID_PERI = per.OID_PERI
		  			  and sol.IND_TS_NO_CONSO = 1
		  			  and sol.IND_PEDI_PRUE <> 1
		  			  and sol.FEC_FACT is not null
		  			  and per.OID_PERI = solic.oid_peri
		  			  and sol.ZZON_OID_ZONA = solic.oid_zona
		  			  and mar.OID_MARC = comb.oid_marc
					  and can.oid_cana = comb.oid_cana
					  and t_sol_p.PAIS_OID_PAIS = comb.pais_oid_pais
					  and acc.OID_ACCE = comb.oid_acce
				),0)
		  else 0
		  end AS facturado,
		  --REAL_RECIBIDO
	  	  case
		  	  when decode(solic.oid_peri,null,0,1) = 1 then
			  	nvl(   (
				   	select count(fvt.NUM_ORDE)
					from int_fuent_venta_previ_sap fvt,
						 cra_perio per_fvt
					where fvt.perD_oid_peri = per_fvt.PERI_OID_PERI
						  and per_fvt.OID_PERI = solic.oid_peri
						  and fvt.ZZON_OID_ZONA = solic.oid_zona
					group by fvt.ZZON_OID_ZONA,
						   per_fvt.OID_PERI
					),0)
			  else 0
		  end -
		  case
		  	   when decode(solic.OID_PERI,null,0,1) = 1 then 
			   nvl(( 
		  	  select
		  	  		  count(sol.oid_soli_cabe)
		  		from seg_marca mar,
		  			 seg_canal can,
		  			 seg_acces acc,
		  			 ped_tipo_solic t_sol,
		  			 ped_solic_cabec sol,
		  			 ped_tipo_solic_pais t_sol_p,
		  			 zon_zona zon,
		  			 cra_perio per
		  		where sol.TSPA_OID_TIPO_SOLI_PAIS = t_sol_p.OID_TIPO_SOLI_PAIS 
		  			  and t_sol_p.TSOL_OID_TIPO_SOLI = t_sol.OID_TIPO_SOLI
		  			  and t_sol.MARC_OID_MARC = mar.OID_MARC
		  			  and t_sol.ACCE_OID_ACCE = acc.OID_ACCE
		  			  and acc.CANA_OID_CANA = can.OID_CANA
		  			  and sol.ZZON_OID_ZONA= zon.OID_ZONA
		  			  and sol.PERD_OID_PERI = per.OID_PERI
		  			  and sol.IND_TS_NO_CONSO = 1
		  			  and sol.IND_PEDI_PRUE <> 1
		  			  and sol.FEC_FACT is null
		  			  and per.OID_PERI = solic.oid_peri
		  			  and sol.ZZON_OID_ZONA = solic.oid_zona
		  			  and mar.OID_MARC = comb.oid_marc
					  and can.oid_cana = comb.oid_cana
					  and t_sol_p.PAIS_OID_PAIS = comb.pais_oid_pais
					  and acc.OID_ACCE = comb.oid_acce
				),0)
	   	  else 0
		  end AS real_recibido,
		  --RECIBIDO_PER_ANT--
		  case
		  	  when decode(solic.OID_PERI,null,0,1) = 1 then 
		  (	
		  select
		  		  count(sol.oid_soli_cabe)
			from seg_marca mar,
				 seg_canal can,
				 seg_acces acc,
				 ped_tipo_solic t_sol,
				 ped_solic_cabec sol,
				 ped_tipo_solic_pais t_sol_p,
				 zon_zona zon,
				 cra_perio per
			where sol.TSPA_OID_TIPO_SOLI_PAIS = t_sol_p.OID_TIPO_SOLI_PAIS 
				  and t_sol_p.TSOL_OID_TIPO_SOLI = t_sol.OID_TIPO_SOLI
				  and t_sol.MARC_OID_MARC = mar.OID_MARC
				  and t_sol.ACCE_OID_ACCE = acc.OID_ACCE
				  and acc.CANA_OID_CANA = can.OID_CANA
				  and sol.ZZON_OID_ZONA= zon.OID_ZONA
				  and sol.PERD_OID_PERI = per.OID_PERI
				  and sol.IND_TS_NO_CONSO = 1
				  and sol.IND_PEDI_PRUE <> 1
				  and sol.FEC_FACT is null
				  and per.OID_PERI = solic.per_ant
				  and sol.ZZON_OID_ZONA = solic.oid_zona
	 			  and mar.OID_MARC = comb.oid_marc
				  and can.oid_cana = comb.oid_cana
				  and t_sol_p.PAIS_OID_PAIS = comb.pais_oid_pais
				  and acc.OID_ACCE = comb.oid_acce
			)
			else 0
			end AS recibido_per_ant,
		  --PEDIDOS DE NUEVAS--
		  case 
		  	  when decode(solic.OID_PERI,null,0,1) = 1 then 
		  	 (	
		  	  select
		  	  		  count(sol.oid_soli_cabe)
		  		from seg_marca mar,
		  			 seg_canal can,
		  			 seg_acces acc,
		  			 ped_tipo_solic t_sol,
		  			 ped_solic_cabec sol,
		  			 ped_tipo_solic_pais t_sol_p,
		  			 zon_zona zon,
		  			 cra_perio per,
	 				 mae_estat_clien est,
					 mae_clien_histo_estat his_est
		  		where sol.TSPA_OID_TIPO_SOLI_PAIS = t_sol_p.OID_TIPO_SOLI_PAIS 
		  			  and t_sol_p.TSOL_OID_TIPO_SOLI = t_sol.OID_TIPO_SOLI
		  			  and t_sol.MARC_OID_MARC = mar.OID_MARC
		  			  and t_sol.ACCE_OID_ACCE = acc.OID_ACCE
		  			  and acc.CANA_OID_CANA = can.OID_CANA
		  			  and sol.ZZON_OID_ZONA= zon.OID_ZONA
		  			  and sol.PERD_OID_PERI = per.OID_PERI
		  			  and sol.IND_TS_NO_CONSO = 1
		  			  and sol.IND_PEDI_PRUE <> 1
		  			  and sol.FEC_FACT is not null
		  			  and per.OID_PERI = solic.oid_peri
		  			  and sol.ZZON_OID_ZONA = solic.oid_zona
		  			  and mar.OID_MARC = comb.oid_marc
					  and can.oid_cana = comb.oid_cana
					  and t_sol_p.PAIS_OID_PAIS = comb.pais_oid_pais
					  and acc.OID_ACCE = comb.oid_acce
					  and his_est.CLIE_OID_CLIE = sol.CLIE_OID_CLIE
					  and his_est.PERD_OID_PERI = sol.PERD_OID_PERI
					  and his_est.ESTA_OID_ESTA_CLIE = est.OID_ESTA_CLIE
					  and est.COD_ESTA_CLIE = '02' --NUEVA--
		  	)
			else 0
			end AS pedidos_nuevas
	from 	(--SOLICITUDES--
			select 
			   	   sol.OID_SOLI_CABE,
				   mar.OID_MARC, 
				   can.OID_CANA,
				   zon.OID_ZONA,
				   zon.ZORG_OID_REGI,
				   per.oid_peri,
				   acc.OID_ACCE,
				   t_sol_p.PAIS_OID_PAIS,
				   t_sol.oid_tipo_soli,
				   gen_t_sol.tipo_sol,
				   sol.FEC_FACT,
				   --CALCULO EL PERIODO ANTERIOR--
					 (
						 select peri.OID_PERI
				 		 from ( 
						 	  	select per2.oid_peri,
									   per2.fec_inic, 
									   per2.pais_oid_pais, 
									   per2.cana_oid_cana, 
									   per2.marc_oid_marc  
								from cra_perio per2 
								order by per2.fec_inic desc
								)peri  
				 		 where peri.FEC_INIC < per.fec_inic
							   and peri.pais_oid_pais = t_sol_p.PAIS_OID_PAIS --PARAMETRO--
							   and peri.cana_oid_cana = can.OID_CANA --PARAMETRO--
							   and peri.marc_oid_marc = mar.OID_MARC --PARAMETRO--
					   		   and rownum = 1
			 		)per_ant
			from seg_marca mar,
				 seg_canal can,
				 seg_acces acc,
				 ped_tipo_solic t_sol,
				 ped_solic_cabec sol,
				 ped_tipo_solic_pais t_sol_p,
				 zon_zona zon,
				 cra_perio per,
	   			 (
				 select gen.val_oid, gen.val_i18n tipo_sol
				 from v_gen_i18n_sicc gen
				 where gen.ATTR_ENTI = 'PED_TIPO_SOLIC'
				 	   and gen.IDIO_OID_IDIO = 1 --PARAMETRO--
				 )gen_t_sol
			where sol.TSPA_OID_TIPO_SOLI_PAIS = t_sol_p.OID_TIPO_SOLI_PAIS 
				  and t_sol_p.TSOL_OID_TIPO_SOLI = t_sol.OID_TIPO_SOLI
				  and t_sol.MARC_OID_MARC = mar.OID_MARC
				  and t_sol.ACCE_OID_ACCE = acc.OID_ACCE
				  and acc.CANA_OID_CANA = can.OID_CANA
				  and sol.ZZON_OID_ZONA= zon.OID_ZONA
				  and sol.PERD_OID_PERI = per.OID_PERI
				  and sol.IND_TS_NO_CONSO = 1
				  and sol.IND_PEDI_PRUE <> 1
	  			  and t_sol.OID_TIPO_SOLI = gen_t_sol.val_oid(+)
		)solic,
		( --COMBINACIONES NO TRATADAS--
			select distinct 
				   mar.OID_MARC, 
				   can.OID_CANA,
				   zon.OID_ZONA,
				   reg.OID_REGI,
				   per.OID_PERI,
				   acc.OID_ACCE,
				   t_sol_p.PAIS_OID_PAIS,
				   gen_acc.acceso,
				   mar.DES_MARC marca,
				   gen_can.canal,
				   gen_pai.pais,
				   zon.COD_ZONA,
				   zon.DES_ZONA,
				   reg.DES_REGI,
				   per.VAL_NOMB_PERI,
				   cli.VAL_APE1||' '||cli.VAL_APE2||' '||cli.VAL_NOM1||' '||cli.VAL_NOM2 gerente_reg,
	   			   cli2.VAL_APE1||' '||cli2.VAL_APE2||' '||cli2.VAL_NOM1||' '||cli2.VAL_NOM2 gerente_zon
			from seg_acces acc,
				 seg_canal can,
				 seg_marca mar,
				 ped_tipo_solic t_sol,
				 ped_tipo_solic_pais t_sol_p,
				 cra_perio per,
				 zon_zona zon,
				 zon_regio reg,
				 mae_clien cli,
				 mae_clien cli2,
				 (
				 select gen.val_oid, gen.val_i18n acceso
				 from v_gen_i18n_sicc gen
				 where gen.ATTR_ENTI = 'SEG_ACCES'
				 	   and gen.IDIO_OID_IDIO = 1 --PARAMETRO--
				 )gen_acc,
				 (
				 select gen.val_oid, gen.val_i18n canal
				 from v_gen_i18n_sicc gen
				 where gen.ATTR_ENTI = 'SEG_CANAL'
				 	   and gen.IDIO_OID_IDIO = 1 --PARAMETRO--
				 )gen_can,
	 			 (
				 select gen.val_oid, gen.val_i18n pais
				 from v_gen_i18n_sicc gen
				 where gen.ATTR_ENTI = 'SEG_PAIS'
				 	   and gen.IDIO_OID_IDIO = 1 --PARAMETRO--
				 )gen_pai
			where acc.CANA_OID_CANA = can.OID_CANA
				  and acc.OID_ACCE = t_sol.ACCE_OID_ACCE
				  and t_sol.MARC_OID_MARC = mar.OID_MARC
				  and per.MARC_OID_MARC = mar.OID_MARC
				  and per.CANA_OID_CANA = can.OID_CANA
				  and per.pais_oid_pais = t_sol_p.pais_oid_pais
				  and zon.CANA_OID_CANA = can.OID_CANA
				  and zon.MARC_OID_MARC = mar.OID_MARC
				  and zon.pais_oid_pais = t_sol_p.pais_oid_pais
				  and t_sol.OID_TIPO_SOLI = t_sol_p.TSOL_OID_TIPO_SOLI
				  and zon.ZORG_OID_REGI = reg.OID_REGI
				  and reg.CLIE_OID_CLIE = cli.OID_CLIE(+)
				  and zon.CLIE_OID_CLIE = cli2.oid_clie(+)
				  and acc.oid_acce = gen_acc.val_oid(+)
				  and t_sol_p.pais_oid_pais = gen_pai.val_oid(+)
				  and can.OID_CANA = gen_can.val_oid(+)
				  and reg.IND_ACTI = 1
/*				  and per.oid_peri in (57) --PARAMETRO--
				  and t_sol_p.PAIS_OID_PAIS = 1 --PARAMETRO--
				  and can.OID_CANA in (1) --PARAMETRO--
				  and mar.OID_MARC = 1 --PARAMETRO--
				  and acc.OID_ACCE in (1) --PARAMETRO--
				  and zon.ZORG_OID_REGI in (1) --PARAMETRO--
				  and cli.OID_CLIE in (1) --PARAMETRO--  */
		 )comb
	where solic.oid_marc(+) = comb.oid_marc
		  and solic.oid_cana(+) = comb.oid_cana
		  and solic.ZORG_OID_REGI(+) = comb.oid_regi
		  and solic.oid_peri(+) = comb.oid_peri
		  and solic.oid_acce(+) = comb.oid_acce
		  and solic.pais_oid_pais(+) = comb.pais_oid_pais
		  and solic.oid_zona(+) = comb.oid_zona
	group by
		  comb.pais,
	  	  comb.marca,
		  comb.canal,
	  	  comb.val_nomb_peri,
	  	  comb.gerente_reg,
		  comb.gerente_zon,
		  comb.acceso,
		  comb.DES_REGI,
		  comb.COD_ZONA,
		  comb.DES_ZONA,
		  comb.OID_MARC, 
		  comb.OID_CANA,
		  comb.OID_REGI,
		  solic.OID_PERI,
		  comb.OID_ACCE,
	 	  solic.oid_zona,
	  	  comb.pais_oid_pais,
		  solic.per_ant
)
order by
	  recibido,
	  pais,
	  marca,
	  canal,
  	  val_nomb_peri,
	  acceso,
	  DES_REGI,
  	  gerente_reg,
	  gerente_zon