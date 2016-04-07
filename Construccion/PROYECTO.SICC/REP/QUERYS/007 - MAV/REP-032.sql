select 
	   gen_pais.pais,
	   gen_canal.canal,
	   gen_act.actividad,
	   res.FEC_RESU_PAGO_INTE,   
	   gen_TIPO_SOLIC.TIPO_SOLIC,
	   cab_sol.VAL_NUME_SOLI,
	   res.FEC_INIC, res.FEC_FIN,
	   res.NUM_ITEM, 
	   res.NUM_UNID_TOTA,
	   soc.VAL_DENO empresa_que_factura,
	   cli.VAL_APE1||' '||cli.VAL_APE2||' '||cli.VAL_NOM1||' '||cli.VAL_NOM2 empresa_a_quien_factura, 
	   res.VAL_PORC_SOBR_COST, 
	   res.VAL_MONT_TOTA,
	   per.VAL_NOMB_PERI
from 
	  MAV_RESUM_PAGO_INTER res,
	  ped_solic_cabec cab_sol,
	  ped_tipo_solic_pais tipo_sol,
	  MAV_ACTIV act,
	  cra_perio per,
	  mae_clien cli, 
  	  seg_socie soc, 
	  MAV_PERIO_REFER_PAGOS PERIO_REFER,
	  (
	  select gen.VAL_OID, gen.VAL_I18N AS TIPO_SOLIC
	  from v_gen_i18n_sicc gen
	  where gen.ATTR_ENTI= 'PED_TIPO_SOLIC'
	  		and gen.IDIO_OID_IDIO = 1 --PARAMETRO--
	  )gen_TIPO_SOLIC,
	  (
	  select gen.VAL_OID, gen.VAL_I18N AS actividad
	  from v_gen_i18n_sicc gen
	  where gen.ATTR_ENTI= 'MAV_ACTIV'
	  		and gen.IDIO_OID_IDIO = 1 --PARAMETRO--
	  )gen_act,
	  (
	  select gen.VAL_OID, gen.VAL_I18N AS canal
	  from v_gen_i18n_sicc gen
	  where gen.ATTR_ENTI= 'SEG_CANAL'
	  		and gen.IDIO_OID_IDIO = 1 --PARAMETRO--
	  )gen_canal,
	  (
	  select gen.VAL_OID, gen.VAL_I18N AS pais
	  from v_gen_i18n_sicc gen
	  where gen.ATTR_ENTI= 'SEG_PAIS'
	  		and gen.IDIO_OID_IDIO = 1 --PARAMETRO--
	  )gen_pais
where 
	      res.SOCA_OID_SOLI_CABE = cab_sol.OID_SOLI_CABE
	  and cab_sol.TSPA_OID_TIPO_SOLI_PAIS = tipo_sol.OID_TIPO_SOLI_PAIS
	  and res.ACTI_OID_ACTI = act.OID_ACTI
	  and cab_sol.CLIE_OID_CLIE = cli.oid_clie
	  and cab_sol.SOCI_OID_SOCI = soc.oid_soci
	  and res.CANA_OID_CANA = gen_canal.val_oid(+)
  	  and act.OID_ACTI = gen_act.val_oid(+)
	  and per.PAIS_OID_PAIS = gen_pais.val_oid(+)
------------------------------------------------------------------------------------------------
	  AND RES.ACTI_OID_ACTI = RES.ACTI_OID_ACTI
	  AND RES.CANA_OID_CANA = RES.CANA_OID_CANA
	  AND RES.MARC_OID_MARC = RES.MARC_OID_MARC
	  AND RES.FEC_INIC = RES.FEC_INIC
	  AND RES.FEC_FIN = RES.FEC_FIN
	  AND PERIO_REFER.REPI_OID_RESU_PAGO_INTE = RES.OID_RESU_PAGO_INTE
	  AND PERIO_REFER.PERD_OID_PERI = PER.OID_PERI 
------------------------------------------------------------------------------------------------
	  and TIPO_SOL.TSOL_OID_TIPO_SOLI = gen_TIPO_SOLIC.val_oid(+)
  	  and res.ACTI_OID_ACTI in (1) 													 --PARAMETRO--
	  and res.CANA_OID_CANA in (1) 													 --PARAMETRO--
	  and res.MARC_OID_MARC in (1) 													 --PARAMETRO--
	  and cab_sol.pais_oid_pais = 1  												 --PARAMETRO--
	  and res.FEC_RESU_PAGO_INTE  between to_date('01/01/2000', 'dd/MM/yyyy') and to_date('01/01/2008', 'dd/MM/yyyy')	 --PARAMETRO--
order by 
	   gen_act.actividad,
	   res.FEC_RESU_PAGO_INTE,   
	   gen_TIPO_SOLIC.TIPO_SOLIC,
	   cab_sol.VAL_NUME_SOLI,
	   res.FEC_INIC, res.FEC_FIN,
	   res.NUM_ITEM, 
	   res.NUM_UNID_TOTA,
	   soc.VAL_DENO,
	   cli.VAL_APE1||' '||cli.VAL_APE2||' '||cli.VAL_NOM1||' '||cli.VAL_NOM2, 
	   res.VAL_PORC_SOBR_COST, 
	   res.VAL_MONT_TOTA,
	   per.VAL_NOMB_PERI

