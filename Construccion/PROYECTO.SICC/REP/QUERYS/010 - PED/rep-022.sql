select
	  mar.DES_MARC,	  
	  gen_can.canal,	  
	  per.val_nomb_peri,
	  usu.NOMBRE1||' '||usu.NOMBRE2||' '||usu.APELLIDOPATERNO nombre_completo,
	  prog.VAL_NOMB,
	  sum(decode(pro.COD_PROC,'P115',est_dig.NUM_CV,0))cv_ingresos_115,
	  sum(decode(pro.COD_PROC,'P115',est_dig.NUM_OC,0))doc_ingresos_115,
  	  sum(decode(pro.COD_PROC,'P120',est_dig.NUM_CV,0))cv_ingresos_120,
	  sum(decode(pro.COD_PROC,'P120',est_dig.NUM_OC,0))doc_ingresos_120,
	  sum(est_dig.FEC_FIN_SESI-est_dig.FEC_INIC_SESI)*24 as horas,
	  (
	  select count(*)
	  from ped_solic_cabec sol,
	  	   ped_tipo_solic t_sol2,
	  	   ped_estad_digit est_dig2,
		   ped_tipo_solic_pais t_sol_p2,
	  	   rec_cabec_recla rec,
		   rec_tipo_ingre t_ing,
		   seg_acces acc2
	  where sol.OID_SOLI_CABE = rec.SOCA_OID_SOLI_CABE
			and rec.TIIN_OID_TIPO_INGR = t_ing.OID_TIPO_INGR
			and est_dig2.TSPA_OID_TIPO_SOLI_PAIS = t_sol_p2.OID_TIPO_SOLI_PAIS
			and sol.TSPA_OID_TIPO_SOLI_PAIS = t_sol_p2.OID_TIPO_SOLI_PAIS
			and t_ing.COD_TIPO_INGR = 'D'
			and est_dig2.VAL_USUA = est_dig.val_usua
			and t_sol_p2.TSOL_OID_TIPO_SOLI = t_sol2.OID_TIPO_SOLI
			and t_sol2.ACCE_OID_ACCE = acc2.OID_ACCE
			and est_dig2.FEC_INIC_SESI >= '1/1/2003' --PARAMETRO--
			and est_dig2.FEC_FIN_SESI <= '31/12/2005' --PARAMETRO--
			--and est_dig2.PERD_OID_PERI = 1 --PARAMETRO--
			and t_sol_p2.pais_oid_pais = 1 --PARAMETRO--
			and t_sol2.MARC_OID_MARC = 1 --PARAMETRO--
			and acc2.CANA_OID_CANA = 1 --PARAMETRO--
	  )reclamos
from   
	 ped_estad_digit est_dig,
	 ped_tipo_solic_pais t_sol_p,
	 ped_tipo_solic t_sol,
	 ped_proce pro,
	 ped_grupo_proce gru_pro,
	 ped_progr prog,
	 seg_acces acc,
	 cra_perio per,
	 own_mare.v_usu_largo usu,
	 seg_marca mar,
	 (
	 select gen.val_oid, gen.val_i18n canal
	 from v_gen_i18n_sicc gen		  
	 where gen.attr_enti = 'SEG_CANAL'
	 	   and gen.idio_oid_idio = 1 --PARAMETRO--
	 )gen_can
where 
	  t_sol_p.OID_TIPO_SOLI_PAIS = est_dig.TSPA_OID_TIPO_SOLI_PAIS
	  and t_sol_p.TSOL_OID_TIPO_SOLI = t_sol.OID_TIPO_SOLI
	  and t_sol.ACCE_OID_ACCE = acc.OID_ACCE
	  and est_dig.PERD_OID_PERI = per.OID_PERI
	  and est_dig.VAL_USUA = usu.NOMBREUSUARIO
	  and t_sol.MARC_OID_MARC = mar.oid_marc
	  and acc.OID_ACCE = gen_can.VAL_OID(+)
	  and est_dig.PROC_OID_proc=pro.OID_PROC
	  and pro.PROG_OID_PROG = prog.OID_PROG
	  and t_sol.MARC_OID_MARC = 1 --PARAMETRO--
	  and acc.CANA_OID_CANA = 1 --PARAMETRO--
	  and t_sol_p.pais_oid_pais = 1 --PARAMETRO--
--	  and est_dig.PERD_OID_PERI = 1 --PARAMETRO--
	  and est_dig.FEC_INIC_SESI >= '1/1/2003' --PARAMETRO--
	  and est_dig.FEC_FIN_SESI <= '31/12/2005' --PARAMETRO--
group by
	  est_dig.val_usua,
  	  mar.DES_MARC,
	  gen_can.canal,
	  per.val_nomb_peri,
	  usu.NOMBRE1||' '||usu.NOMBRE2||' '||usu.APELLIDOPATERNO,
	  prog.VAL_NOMB
order by nombre_completo
