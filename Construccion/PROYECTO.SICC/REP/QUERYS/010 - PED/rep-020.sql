select
  	  mar.DES_MARC,
	  gen_can.canal,
	  per.VAL_NOMB_PERI,
	  usu.NOMBRE1||' '||usu.NOMBRE2||' '||usu.APELLIDOPATERNO nombre_usuario,
	  --INGRESOS--
	  sum(decode(pro.COD_proc,'P115',est_dig.NUM_CV,0))cv_ingresos,
	  sum(decode(pro.COD_proc,'P115',est_dig.NUM_OC,0))doc_ingresos,
	  decode(sum(decode(pro.COD_proc,'P115',est_dig.NUM_CV,0)),0,0,sum(decode(pro.COD_proc,'P115',est_dig.NUM_ERRO_CV,0)) / sum(decode(pro.COD_proc,'P115',est_dig.NUM_CV,0))*100)porc_ingresos,
	  sum(decode(pro.cod_proc,'P115',(est_dig.FEC_FIN_SESI - est_dig.FEC_INIC_SESI)*24,0))horas_ingresos,
	  --VERIFICACION--
	  sum(decode(pro.COD_proc,'P120',est_dig.NUM_CV,0))cv_verificacion,
  	  sum(decode(pro.COD_proc,'P120',est_dig.NUM_OC,0))doc_verificacion,
	  sum(decode(pro.cod_proc,'P120',(est_dig.FEC_FIN_SESI - est_dig.FEC_INIC_SESI)*24,0))horas_verificacion,
	  --
   	  decode( sum(decode(pro.cod_proc,'P115',(est_dig.FEC_FIN_SESI - est_dig.FEC_INIC_SESI)*24,0)) ,0, 0, sum(decode(pro.COD_proc,'P115',est_dig.NUM_CV,0)) / sum(decode(pro.cod_proc,'P115',(est_dig.FEC_FIN_SESI - est_dig.FEC_INIC_SESI)*24,0)) )ingresado_horas,
   	  decode( sum(decode(pro.cod_proc,'P120',(est_dig.FEC_FIN_SESI - est_dig.FEC_INIC_SESI)*24,0)) ,0, 0, sum(decode(pro.COD_proc,'P120',est_dig.NUM_CV,0)) / sum(decode(pro.cod_proc,'P120',(est_dig.FEC_FIN_SESI - est_dig.FEC_INIC_SESI)*24,0)) )verificado_horas,
	  (decode( sum(decode(pro.cod_proc,'P115',(est_dig.FEC_FIN_SESI - est_dig.FEC_INIC_SESI)*24,0)) ,0, 0, sum(decode(pro.COD_proc,'P115',est_dig.NUM_CV,0)) / sum(decode(pro.cod_proc,'P115',(est_dig.FEC_FIN_SESI - est_dig.FEC_INIC_SESI)*24,0)) ) + --INGRESADO--
   	  decode( sum(decode(pro.cod_proc,'P120',(est_dig.FEC_FIN_SESI - est_dig.FEC_INIC_SESI)*24,0)) ,0, 0, sum(decode(pro.COD_proc,'P120',est_dig.NUM_CV,0)) / sum(decode(pro.cod_proc,'P120',(est_dig.FEC_FIN_SESI - est_dig.FEC_INIC_SESI)*24,0)) )) *0.04 promedio 	  
from 
	 ped_tipo_solic t_sol,
	 ped_tipo_solic_pais t_sol_p,
	 ped_estad_digit est_dig,
	 seg_marca mar,
	 seg_acces acc,
	 seg_subac subac,
	 own_mare.v_usu_largo usu,
	 cra_perio per,
	 ped_proce pro,
	 (
	 select gen.val_oid, gen.VAL_I18N canal
	 from v_gen_i18n_sicc gen
	 where gen.ATTR_ENTI = 'SEG_CANAL'
	 	   and gen.IDIO_OID_IDIO = 1 --PARAMETRO--
	 )gen_can
where 
	  est_dig.TSPA_OID_TIPO_SOLI_PAIS = t_sol_p.OID_TIPO_SOLI_PAIS
	  and t_sol_p.pais_oid_pais = 1
	  and t_sol_p.TSOL_OID_TIPO_SOLI = t_sol.OID_TIPO_SOLI
	  and t_sol.ACCE_OID_ACCE = acc.OID_ACCE
	  and t_sol.MARC_OID_MARC = mar.OID_MARC
	  and acc.OID_ACCE = subac.ACCE_OID_ACCE
	  and est_dig.VAL_USUA = usu.NOMBREUSUARIO
	  and est_dig.PERD_OID_PERI = per.OID_PERI
	  and acc.CANA_OID_CANA = gen_can.val_oid(+)
	  and est_dig.PROC_OID_PROC= pro.OID_PROC
	  and t_sol.MARC_OID_MARC = 1 --PARAMETRO--
	  and t_sol.ACCE_OID_ACCE in (1)  --PARAMETRO--
	  and acc.CANA_OID_CANA = 1 --PARAMETRO--
	  and subac.OID_SBAC in (1) --PARAMETRO--
	  and per.OID_PERI in (57) --PARAMETRO--
group by
  	  mar.DES_MARC,
	  gen_can.canal,
	  per.VAL_NOMB_PERI,
	  usu.NOMBRE1||' '||usu.NOMBRE2||' '||usu.APELLIDOPATERNO