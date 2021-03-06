/*NOTA PARA LAYOUTEADORES:
	   El parametro tipo de operacion, sera reemplazado donde estan los valores (1,1007,1044,1074)*/
--FALTA EL PARAMETRO CODIGO DE VENTA, HAY UNA CONSULTA PENDIENTE CON EMILIO--	   
select 
	   val_nomb_peri,
	   descripcion,
	   cod_sap,
	   val_codi_vent,
   	   cod_operacion_1,
	   desc_operacion_1,
	   cod_operacion_2,
	   desc_operacion_2,
	   cod_operacion_3,
	   desc_operacion_3,
	   cod_operacion_4,
	   desc_operacion_4,
	   sum(NUM_UNID_ATEN)unidades_facturadas,
	   sum(operacion_1)operacion_1,   
	   decode( nvl(sum(NUM_UNID_ATEN),0),0,0, sum(operacion_1) / sum(NUM_UNID_ATEN) )*100 por_unidades_1,
	   sum(operacion_2)operacion_2,
   	   decode( nvl(sum(NUM_UNID_ATEN),0),0,0, sum(operacion_2) / sum(NUM_UNID_ATEN) )*100 por_unidades_2,
	   sum(operacion_3)operacion_3,
	   decode( nvl(sum(NUM_UNID_ATEN),0),0,0, sum(operacion_3) / sum(NUM_UNID_ATEN) )*100 por_unidades_3,
	   sum(operacion_4)operacion_4,
   	   decode( nvl(sum(NUM_UNID_ATEN),0),0,0, sum(operacion_4) / sum(NUM_UNID_ATEN) )*100 por_unidades_4,
	   sum(operacion_1 + operacion_2 + operacion_3 + operacion_4) as unidades_reclamadas 
from
(
	select gen_prod.descripcion,
		   prod.cod_sap,
		   of_det.val_codi_vent,
  		   fac_lin.NUM_UNID_ATEN,
		   per.val_nomb_peri,
		   decode(t_op.ROPE_OID_OPER,1,lin_rec.NUM_UNID_RECL,0)operacion_1,
	   	   decode(t_op.ROPE_OID_OPER,1044,lin_rec.NUM_UNID_RECL,0)operacion_2,
	   	   decode(t_op.ROPE_OID_OPER,1074,lin_rec.NUM_UNID_RECL,0)operacion_3,
	   	   decode(t_op.ROPE_OID_OPER,1007,lin_rec.NUM_UNID_RECL,0)operacion_4,
		   operaciones.cod_operacion_1,
		   operaciones.desc_operacion_1,
		   operaciones.cod_operacion_2,
		   operaciones.desc_operacion_2,
		   operaciones.cod_operacion_3,
		   operaciones.desc_operacion_3,
		   operaciones.cod_operacion_4,
		   operaciones.desc_operacion_4		   
	from
		rec_cabec_recla cab_rec,
		rec_opera_recla op_rec,
		rec_linea_opera_recla lin_rec,
		rec_tipos_opera t_op,
		fac_docum_conta_cabec fac,
		fac_docum_conta_linea fac_lin,
		pre_ofert_detal of_det,
		ped_solic_cabec sol,
		ped_solic_posic pos,
		ped_tipo_solic_pais t_sol_p,
		ped_tipo_solic t_sol,
		cra_perio per,
		mae_produ prod,
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
					 		 and val_oid = 2--PARAMETRO OPERACION 1--
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
		 and cab_rec.SOCA_OID_SOLI_CABE = fac.soca_oid_soli_cabe(+)
		 and fac.OID_CABE = fac_lin.DCCA_OID_CABE(+)
		 and cab_rec.SOCA_OID_SOLI_CABE = pos.soca_oid_soli_cabe
		 and lin_rec.prod_oid_prod = prod.oid_prod
		 and prod.oid_prod = gen_prod.val_oid(+)
		 and op_rec.TIOP_OID_TIPO_OPER = t_op.OID_TIPO_OPER
		 and pos.OFDE_OID_DETA_OFER = of_det.OID_DETA_OFER
		 and cab_rec.PERD_OID_PERI_DOCU_REFE = per.oid_peri
		 and per.oid_peri = 57 --PARAMETRO PERIODO--
		 and cab_rec.PAIS_OID_PAIS = 1 --PARAMETRO PAIS--
		 and per.marc_oid_marc = 1 --PARAMETRO MARCA--
		 and per.cana_oid_cana = 1 --PARAMETRO CANAL--
		 and cab_rec.SOCA_OID_SOLI_CABE = sol.oid_soli_cabe
		 and sol.TSPA_OID_TIPO_SOLI_PAIS = t_sol_p.oid_tipo_soli_pais
		 and t_sol_p.TSOL_OID_TIPO_SOLI = t_sol.oid_tipo_soli
--		 and t_sol.acce_oid_acce in (1) --PARAMETRO ACCESO (PUNTO DE INGRESO) --
--		 and of_det.VAL_CODI_VENT in ('1111111','11111112') --PARAMETRO CODIGO VENTA--
)
group by
	  val_nomb_peri,
	  descripcion, 
	  cod_sap,
	  val_codi_vent 