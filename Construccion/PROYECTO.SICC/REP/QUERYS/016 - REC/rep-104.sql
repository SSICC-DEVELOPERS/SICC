select
	  cod_sap,
	  descripcion,
	  val_nomb_peri,
 	  cod_operacion_1,
	  desc_operacion_1,
	  cod_operacion_2,
	  desc_operacion_2,
	  cod_operacion_3,
	  desc_operacion_3,
      cod_operacion_4,
	  desc_operacion_4,
	  sum(num_unid)unidades_facturadas,
	  sum(operacion_1)as unidades_1,
	  decode(nvl(sum(num_unid),0),0,0,sum(operacion_1) / sum(num_unid))*100 as por_unidades_1,
	  sum(operacion_2)as unidades_2,
	  decode(nvl(sum(num_unid),0),0,0,sum(operacion_2) / sum(num_unid))*100 as por_unidades_2,
	  sum(operacion_3)as unidades_3,
      decode(nvl(sum(num_unid),0),0,0,sum(operacion_3) / sum(num_unid))*100 as por_unidades_3,
	  sum(operacion_4)as unidades_4,
  	  decode(nvl(sum(num_unid),0),0,0,sum(operacion_4) / sum(num_unid))*100 as por_unidades_4,
	  nvl(sum(operacion_1),0) + nvl(sum(operacion_2),0) + nvl(sum(operacion_3),0) + nvl(sum(operacion_4),0) suma_unidades
from
	(
	select 
		   gen_prod.descripcion,
		   prod.cod_sap,
		   per.val_nomb_peri,
		   decode(t_op.ROPE_OID_OPER,1,lin_rec.NUM_UNID_RECL,0)operacion_1,
		   decode(op_rec.TIOP_OID_TIPO_OPER,1007,lin_rec.NUM_UNID_RECL,0)operacion_2,
		   decode(t_op.ROPE_OID_OPER,1074,lin_rec.NUM_UNID_RECL,0)operacion_3,
		   decode(t_op.ROPE_OID_OPER,1044,lin_rec.NUM_UNID_RECL,0)operacion_4,
		   operaciones.cod_operacion_1,
		   operaciones.desc_operacion_1,
		   operaciones.cod_operacion_2,
		   operaciones.desc_operacion_2,
		   operaciones.cod_operacion_3,
		   operaciones.desc_operacion_3,
		   operaciones.cod_operacion_4,
		   operaciones.desc_operacion_4,
		   est_dev.num_unid
		from rec_cabec_recla cab_rec,
			 rec_opera_recla op_rec,
			 rec_linea_opera_recla lin_rec,
			 rec_tipos_opera t_op,
			 mae_produ prod,
			 cra_perio per,
			 cra_perio per_dev,
			 pre_matri_estad_produ_devol est_dev,
			 ped_solic_cabec sol,
			 ped_tipo_solic_pais t_sol_p,
			 ped_tipo_solic t_sol,
			 (
			  select oid_peri, fec_inic, fec_fina
			  from cra_perio
			  where oid_peri = 1379
			 )per_ini, 
			 (
			  select oid_peri, fec_inic, fec_fina
			  from cra_perio
			  where oid_peri = 71
			 )per_fin, 
			 (
			  select val_oid, val_i18n descripcion
			  from v_gen_i18n_sicc
			  where attr_enti = 'MAE_PRODU'
			  		and idio_oid_idio = 1 --PARAMETRO--
			 )gen_prod,
			 (
			select 
				  	(
					 select op.COD_OPER
					from rec_opera op
					where op.OID_OPER = 1 --PARAMETRO OPERACION 1--
					) cod_operacion_1,
					(
					 select val_i18n
					 from v_gen_i18n_sicc
					 where attr_enti = 'REC_OPERA'
					 		 and val_oid = 1--PARAMETRO OPERACION 1--
					 		 and idio_oid_idio = 1 --PARAMETRO IDIOMA--
					)desc_operacion_1,
					  (
					 select op.COD_OPER
					from rec_opera op
					where op.OID_OPER = 2 --PARAMETRO OPERACION 2--
					) cod_operacion_2,
					(
					 select val_i18n
					 from v_gen_i18n_sicc
					 where attr_enti = 'REC_OPERA'
					 		 and val_oid = 2--PARAMETRO OPERACION 2--
					 		 and idio_oid_idio = 1 --PARAMETRO IDIOMA--
					)desc_operacion_2,
					(
					 select op.COD_OPER
					from rec_opera op
					where op.OID_OPER = 3 --PARAMETRO OPERACION 3--
					) cod_operacion_3,
					(
					 select val_i18n
					 from v_gen_i18n_sicc
					 where attr_enti = 'REC_OPERA'
					 		 and val_oid = 3--PARAMETRO OPERACION 3--
					 		 and idio_oid_idio = 1 --PARAMETRO IDIOMA--
					)desc_operacion_3,
					(
					 select op.COD_OPER
					from rec_opera op
					where op.OID_OPER = 4 --PARAMETRO OPERACION 4--
					) cod_operacion_4,
					(
					 select val_i18n
					 from v_gen_i18n_sicc
					 where attr_enti = 'REC_OPERA'
					 		 and val_oid = 4--PARAMETRO OPERACION 4--
					 		 and idio_oid_idio = 1 --PARAMETRO IDIOMA--
					)desc_operacion_4
			from dual
			)operaciones			 
		where
			 cab_rec.OID_CABE_RECL = op_rec.CARE_OID_CABE_RECL
			 and op_rec.OID_OPER_RECL = lin_rec.OPRE_OID_OPER_RECL
			 and lin_rec.PROD_OID_PROD = prod.OID_PROD
			 and prod.OID_PROD = gen_prod.val_oid(+)
			 and cab_rec.PERD_OID_PERI_DOCU_REFE = per.oid_peri
			 and per_ini.fec_inic <= per.fec_inic
			 and per.fec_fina <= per_fin.fec_fina
			 and est_dev.PROD_OID_PROD(+) = PROD.OID_PROD
			 and est_dev.perd_oid_peri = per_dev.oid_peri(+)
			 and op_rec.TIOP_OID_TIPO_OPER = t_op.OID_TIPO_OPER
			 and per.marc_oid_marc = 1 --PARAMETRO MARCA--
			 and per.cana_oid_cana = 1 --PARAMETRO CANAL--
	--		 and prod.oid_prod in (1) --PARAMETRO PRODUCTO--
			 and cab_rec.soca_oid_soli_cabe = sol.oid_soli_cabe
			 and sol.TSPA_OID_TIPO_SOLI_PAIS = t_sol_p.oid_tipo_soli_pais
			 and t_sol_p.TSOL_OID_TIPO_SOLI = t_sol.oid_tipo_soli
			 and t_sol.acce_oid_acce in (1) --PARAMETRO ACCESO--
	)
group by
	  cod_sap,
	  descripcion,
	  val_nomb_peri

	  
	  

