select 
	   cab_rec.COD_USUA_INGR as usuario,
	   op.COD_OPER,
	   per.val_nomb_peri,
	   est_rec.COD_ESTA,
	   nvl(count(op_rec.OID_OPER_RECL),0)cant_reclamos,
	   decode( nvl(sum(lin_op.NUM_UNID_RECL),0),0,0,
	   		   count(op_rec.OID_OPER_RECL) / sum(lin_op.NUM_UNID_RECL) )*100 por_participacion,
   	   nvl(sum(lin_op.NUM_UNID_RECL),0)num_unid_rec,
	   nvl(sum(lin_op.NUM_UNID_RECL * lin_op.VAL_PREC),0)monto,
	   nvl(sum(cab_rec.NUM_TOTA_ENVI - cab_rec.NUM_TOTA_DEVU),0)monto_diferencia
from
	rec_cabec_recla cab_rec,
	rec_opera_recla op_rec,
	rec_linea_opera_recla lin_op,
	rec_tipos_opera t_op,
	rec_opera op,
	rec_estad_recla est_rec,
	cra_perio per,
	ped_solic_cabec sol,
	ped_tipo_solic_pais t_sol_p,
	ped_tipo_solic t_sol
where
	 cab_rec.OID_CABE_RECL = op_rec.CARE_OID_CABE_RECL
	 and op_rec.OID_OPER_RECL = lin_op.OPRE_OID_OPER_RECL
	 and lin_op.TOFE_OID_TIPO_OFER = t_op.OID_TIPO_OPER
	 and t_op.ROPE_OID_OPER = op.OID_OPER
	 and cab_rec.ESRE_OID_ESTA_RECL = est_rec.OID_ESTA_RECL
	 and cab_rec.PERD_OID_PERI_RECL = per.oid_peri
	 and cab_rec.soca_oid_soli_cabe = sol.oid_soli_cabe
	 and sol.TSPA_OID_TIPO_SOLI_PAIS = t_sol_p.oid_tipo_soli_pais
	 and t_sol_p.TSOL_OID_TIPO_SOLI = t_sol.oid_tipo_soli
	 and t_sol.acce_oid_acce in (1) --PARAMETRO FORMA DE INGRESO--
	 and cab_rec.pais_oid_pais = 1 --PARAMETRO PAIS--
	 and per.marc_oid_marc in (1) --PARAMETRO MARCA--
	 and per.cana_oid_cana in (1) --PARAMETRO CANAL--
	 and per.oid_peri = 93 --PARAMETRO CAMPAÑA--
group by
	  cab_rec.COD_USUA_INGR,
	  op.COD_OPER,
  	  est_rec.COD_ESTA,
	  per.val_nomb_peri
order by 
	  cab_rec.COD_USUA_INGR,
	  op.COD_OPER,
  	  est_rec.COD_ESTA
