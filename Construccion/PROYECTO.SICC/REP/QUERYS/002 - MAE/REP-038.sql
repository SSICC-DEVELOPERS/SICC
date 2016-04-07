select subg.cod_subg_vent, subg.DES_SUBG_VENT, reg.COD_REGI, reg.DES_REGI,zon.COD_ZONA, zon.DES_ZONA,
	ingresos.fvt_ingresos, ingresos.real_ingresos, ingresos.por_ing,
	activos.fvt_activos, activos.real_activos, activos.por_act,
	egresos.fvt_egresos, egresos.real_egresos, egresos.por_egr,
	reingresos.fvt_reingresos, reingresos.real_reingresos, reingresos.por_reing,
	retirados.fvt_retirados, retirados.real_retirados, retirados.por_ret,
	reactivados.fvt_reactivados, reactivados.real_reactivados, reactivados.por_react
from
	zon_sub_geren_venta subg,
	zon_regio reg,
	zon_zona zon,
	(
	---INGRESOS---
		  select decode(fac_ingresos.zona,null, int_ingresos.zona,fac_ingresos.zona) as zona, 
		  int_ingresos.fvt_ingresos, fac_ingresos.real_ingresos,
		  decode(int_ingresos.fvt_ingresos,0,0,(fac_ingresos.real_ingresos/int_ingresos.fvt_ingresos)*100) as por_ing
		  from
		  (
		   	  select fac.PERD_OID_PERI as peri, fac.ZZON_OID_ZONA as zona,  sum(fac.VAL_TOTA_PAGA_DOCU) as real_ingresos from
		  	  fac_docum_conta_cabec fac,
		  	  ped_solic_cabec sol,
		  	  mae_clien cli,
		  	  mae_clien_histo_estat his
		  	  where fac.SOCA_OID_SOLI_CABE=sol.OID_SOLI_CABE
		  	  and sol.CLIE_OID_CLIE=his.CLIE_OID_CLIE
		  	  and fac.PERD_OID_PERI=his.PERD_OID_PERI
		  	  and his.ESTA_OID_ESTA_CLIE=2 --ESTATUS NUEVO NO VALUE--
		  	  group by fac.PERD_OID_PERI, fac.ZZON_OID_ZONA
		  )fac_ingresos full outer join
		  (
		   	  select per.OID_PERI as peri, pre.ZZON_OID_ZONA as zona, sum(pre.NUM_INGR) fvt_ingresos
		  	  from int_fuent_venta_previ_sap pre,
		  	  cra_perio per,
			  seg_perio_corpo cor
		  	  where pre.PERD_OID_PERI=PER.OID_PERI
		  	  and per.PAIS_OID_PAIS=1 --value--
		  	  group by per.OID_PERI, pre.ZZON_OID_ZONA
		  )int_ingresos on fac_ingresos.peri=int_ingresos.peri and fac_ingresos.zona=int_ingresos.zona 
		  where   int_ingresos.peri=56 --VALUE--
		  or fac_ingresos.peri=56 --value--
	)ingresos, 
	(
	--EGRESOS--
		  select decode(fac_egresos.zona,null,int_egresos.zona,fac_egresos.zona) as zona, 
		  int_egresos.fvt_egresos, fac_egresos.real_egresos,
		  decode(int_egresos.fvt_egresos,0,0,(fac_egresos.real_egresos/int_egresos.fvt_egresos)*100) as por_egr
		  from
		  (
		   	  select fac.PERD_OID_PERI as peri, fac.ZZON_OID_ZONA as zona,  sum(fac.VAL_TOTA_PAGA_DOCU) as real_egresos from
		  	  fac_docum_conta_cabec fac,
			  ped_solic_cabec sol,
			  mae_clien cli,
		  	  mae_clien_histo_estat his
		  	  where fac.SOCA_OID_SOLI_CABE=sol.OID_SOLI_CABE
		  	  and sol.CLIE_OID_CLIE=his.CLIE_OID_CLIE
		  	  and fac.PERD_OID_PERI=his.PERD_OID_PERI
		  	  and his.ESTA_OID_ESTA_CLIE=4 --ESTATUS EGRESANTE NO VALUE--
		  	  or his.ESTA_OID_ESTA_CLIE=5 --ESTATUS EGRESADA NO VALUE--
		  	  group by fac.PERD_OID_PERI, fac.ZZON_OID_ZONA
		  )fac_egresos full outer join
		  (
		   	  select per.OID_PERI as peri, pre.ZZON_OID_ZONA as zona, sum(pre.NUM_EGRE) fvt_egresos
		  	  from int_fuent_venta_previ_sap pre,
		  	  cra_perio per
		  	  where pre.PERD_OID_PERI=PER.OID_PERI
		  	  and per.PAIS_OID_PAIS=1 --value--
		  	  group by per.OID_PERI, pre.ZZON_OID_ZONA
		  )int_egresos on fac_egresos.peri=int_egresos.peri and fac_egresos.zona=int_egresos.zona 
		  where fac_egresos.peri=56 --VALUE--
		  or int_egresos.peri=56 --VALUE--
	)egresos,
	(
	--REINGRESOS
		  select decode(fac_reingresos.zona,null,int_reingresos.zona,fac_reingresos.zona) as zona, 
		  int_reingresos.fvt_reingresos, fac_reingresos.real_reingresos,
		  decode(int_reingresos.fvt_reingresos,0,0,(fac_reingresos.real_reingresos/int_reingresos.fvt_reingresos)*100) as por_reing
		  from
		  (
		   	  select fac.PERD_OID_PERI as peri, fac.ZZON_OID_ZONA as zona,  sum(fac.VAL_TOTA_PAGA_DOCU) as real_reingresos from
		  	  fac_docum_conta_cabec fac,
		  	  ped_solic_cabec sol,
		  	  mae_clien cli,
		  	  mae_clien_histo_estat his
		  	  where fac.SOCA_OID_SOLI_CABE=sol.OID_SOLI_CABE
		  	  and sol.CLIE_OID_CLIE=his.CLIE_OID_CLIE
		  	  and fac.PERD_OID_PERI=his.PERD_OID_PERI
		  	  and his.ESTA_OID_ESTA_CLIE=6 --ESTATUS REINGRESO NO VALUE--
		  	  group by fac.PERD_OID_PERI, fac.ZZON_OID_ZONA
		  )fac_reingresos full outer join
		  (
		   	  select per.OID_PERI as peri, pre.ZZON_OID_ZONA as zona, sum(pre.NUM_REIN) fvt_reingresos
		  	  from int_fuent_venta_previ_sap pre,
		  	  cra_perio per
		  	  where pre.PERD_OID_PERI=PER.OID_PERI
		  	  and per.PAIS_OID_PAIS=1 --value--
		  	  group by per.OID_PERI, pre.ZZON_OID_ZONA
		  )int_reingresos on fac_reingresos.peri=int_reingresos.peri and fac_reingresos.zona=int_reingresos.zona
		  where fac_reingresos.peri=56 --VALUE--
		  or int_reingresos.peri=56 --VALUE--
	)reingresos, 
	(
	--RETIRADOS--
		  select decode(fac_retirados.zona,null,int_retirados.zona,fac_retirados.zona) as zona,  
		  int_retirados.fvt_retirados, fac_retirados.real_retirados,
		  decode(int_retirados.fvt_retirados,0,0,(fac_retirados.real_retirados/int_retirados.fvt_retirados)*100) as por_ret
		  from
		  (
		   	  select fac.PERD_OID_PERI as peri, fac.ZZON_OID_ZONA as zona,  sum(fac.VAL_TOTA_PAGA_DOCU) as real_retirados from
		  	  fac_docum_conta_cabec fac,
		  	  ped_solic_cabec sol,
		  	  mae_clien cli,
		  	  mae_clien_histo_estat his
		  	  where fac.SOCA_OID_SOLI_CABE=sol.OID_SOLI_CABE
		  	  and sol.CLIE_OID_CLIE=his.CLIE_OID_CLIE
		  	  and fac.PERD_OID_PERI=his.PERD_OID_PERI
		  	  and his.ESTA_OID_ESTA_CLIE=7 --ESTATUS RETIRADO NO VALUE--
		  	  group by fac.PERD_OID_PERI, fac.ZZON_OID_ZONA
		  )fac_retirados full outer join
		  (
		   	  select per.OID_PERI as peri, pre.ZZON_OID_ZONA as zona, 0  as fvt_retirados
		  	  from int_fuent_venta_previ_sap pre,
		  	  cra_perio per
		  	  where pre.PERD_OID_PERI=PER.OID_PERI
		  	  and per.PAIS_OID_PAIS=1 --value--
		  	  group by per.OID_PERI, pre.ZZON_OID_ZONA
		  )int_retirados on fac_retirados.peri=int_retirados.peri and fac_retirados.zona=int_retirados.zona
		  where fac_retirados.peri=56 --VALUE--
		  or int_retirados.peri=56 --VALUE--
	)retirados,
	--REACTIVADOS--
	(
	 	  select decode(fac_reactivados.zona,null,int_reactivados.zona,fac_reactivados.zona) as zona, 
		  int_reactivados.fvt_reactivados, fac_reactivados.real_reactivados,
		  decode(int_reactivados.fvt_reactivados,0,0,(fac_reactivados.real_reactivados/int_reactivados.fvt_reactivados)*100) as por_react
		  from
		  (
		   	  select fac.PERD_OID_PERI as peri, fac.ZZON_OID_ZONA as zona,  sum(fac.VAL_TOTA_PAGA_DOCU) as real_reactivados from
		  	  fac_docum_conta_cabec fac,
		  	  ped_solic_cabec sol,
		  	  mae_clien cli,
		  	  mae_clien_histo_estat his
		  	  where fac.SOCA_OID_SOLI_CABE=sol.OID_SOLI_CABE
		  	  and sol.CLIE_OID_CLIE=his.CLIE_OID_CLIE
		  	  and fac.PERD_OID_PERI=his.PERD_OID_PERI
		  	  and his.ESTA_OID_ESTA_CLIE=8 --ESTATUS REACTIVADO NO VALUE--
		  	  group by fac.PERD_OID_PERI, fac.ZZON_OID_ZONA
		  )fac_reactivados full outer join
		  (
		      select per.OID_PERI as peri, pre.ZZON_OID_ZONA as zona, 0  as fvt_reactivados
		  	  from int_fuent_venta_previ_sap pre,
		  	  cra_perio per
		  	  where pre.PERD_OID_PERI=PER.OID_PERI
		  	  and per.PAIS_OID_PAIS=1 --value--
		  	  group by per.OID_PERI, pre.ZZON_OID_ZONA
		  )int_reactivados on fac_reactivados.peri=int_reactivados.peri and fac_reactivados.zona=int_reactivados.zona
		  where fac_reactivados.peri=56 --VALUE--
		  or int_reactivados.peri=56 --VALUE--
	)reactivados,
	--ACTIVOS--
	(
	 	  select decode(fac_activos.zona,null,int_activos.zona,fac_activos.zona) as zona, 
		  int_activos.fvt_activos, fac_activos.real_activos,
		  decode(int_activos.fvt_activos,0,0,(fac_activos.real_activos/int_activos.fvt_activos)*100) as por_act
		  from
		  	  (
		   	  select fac.PERD_OID_PERI as peri, fac.ZZON_OID_ZONA as zona,   sum(fac.VAL_TOTA_PAGA_DOCU) as real_activos
		  	  from fac_docum_conta_cabec fac,
		  	  (
		  	   	  select sol.OID_SOLI_CABE
		  		  from ped_solic_cabec sol,
		  		  (
	 	  		   	  select oid_peri 
					  from 
					  (
		  			  	   select per2.oid_peri
		  				   from cra_perio per2,
		  				   (
		  				   		select per.FEC_FINA
		  						from cra_perio per
		  						where per.OID_PERI=56 --value--
		  					)actual
		  					where per2.fec_fina<actual.fec_fina
			  					and per2.pais_oid_pais=1 --value--
			  					and per2.MARC_OID_MARC=1 --value--
			  					and per2.CANA_OID_CANA=1 --value--
		  					order by per2.fec_fina desc
		  			   )
		  			   where rownum <= 2
		  			)dos_per_ant
		  			where sol.IND_OC=1
			  			and sol.FEC_FACT IS NOT null
			  			and sol.PERD_OID_PERI=dos_per_ant.oid_peri
			 		)cli_act
			  	where fac.SOCA_OID_SOLI_CABE=cli_act.oid_soli_cabe
			  	group by fac.PERD_OID_PERI, fac.ZZON_OID_ZONA
		  	)fac_activos full outer join
		  	(
		    select per.OID_PERI as peri, pre.ZZON_OID_ZONA as zona, NVL(sum(pre.NUM_ACTI_INIC+pre.NUM_ACTI_FINA),0) as fvt_activos
		  	from int_fuent_venta_previ_sap pre,
		  		cra_perio per
		  	where pre.PERD_OID_PERI=PER.OID_PERI
		  		and per.PAIS_OID_PAIS=1 --value--
		  	group by per.OID_PERI, pre.ZZON_OID_ZONA
		  	)int_activos on fac_activos.peri=int_activos.peri and fac_activos.zona=int_activos.zona
		  where fac_activos.peri=56 --VALUE--
		  		or int_activos.peri=56 --VALUE--
	)activos
where zon.oid_zona=ingresos.zona(+)
	and zon.oid_zona=egresos.zona(+)
	and zon.oid_zona=reingresos.zona(+)
	and zon.oid_zona=reactivados.zona(+)
	and zon.oid_zona=retirados.zona(+)
	and zon.oid_zona=activos.zona(+)
	AND NOT (ingresos.fvt_ingresos IS NULL 
			 AND ingresos.real_ingresos IS NULL 
			 AND ingresos.por_ing IS NULL 
			 AND activos.fvt_activos IS NULL 
			 AND activos.real_activos IS NULL 
			 AND activos.por_act IS NULL 
			 AND egresos.fvt_egresos IS NULL 
			 AND egresos.real_egresos IS NULL 
			 AND egresos.por_egr IS NULL 
			 AND reingresos.fvt_reingresos IS NULL 
			 AND reingresos.real_reingresos IS NULL 
			 AND reingresos.por_reing IS NULL 
			 AND retirados.fvt_retirados IS NULL 
			 AND retirados.real_retirados IS NULL 
			 AND retirados.por_ret IS NULL 
			 AND reactivados.fvt_reactivados IS NULL 
			 AND reactivados.real_reactivados IS NULL 
			 AND reactivados.por_react IS NULL 
			 AND ingresos.real_ingresos IS NULL
			 )
	and zon.ZORG_OID_REGI=reg.OID_REGI
	and reg.ZSGV_OID_SUBG_VENT=subg.OID_SUBG_VENT
	--and subg.MARC_OID_MARC=1 --value--
	and subg.PAIS_OID_PAIS=1 --value--
	--and subg.CANA_OID_CANA=1 --value--
	--and subg.OID_SUBG_VENT=1 --value no oblig--
	--and reg.OID_REGI=1 --value no oblig--
	and zon.OID_ZONA = 1 --value no oblig--
	group by subg.cod_subg_vent, subg.DES_SUBG_VENT, reg.COD_REGI, reg.DES_REGI,zon.COD_ZONA, zon.DES_ZONA,
	ingresos.fvt_ingresos, ingresos.real_ingresos, ingresos.por_ing,
	activos.fvt_activos, activos.real_activos, activos.por_act,
	egresos.fvt_egresos, egresos.real_egresos, egresos.por_egr,
	reingresos.fvt_reingresos, reingresos.real_reingresos, reingresos.por_reing,
	retirados.fvt_retirados, retirados.real_retirados, retirados.por_ret,
	reactivados.fvt_reactivados, reactivados.real_reactivados, reactivados.por_react 
order by subg.cod_subg_vent, subg.DES_SUBG_VENT, reg.COD_REGI, reg.DES_REGI,zon.COD_ZONA, zon.DES_ZONA