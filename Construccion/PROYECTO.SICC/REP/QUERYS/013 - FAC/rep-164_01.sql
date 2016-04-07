SELECT 
	   gen_pais.pais,
	   gen_soc.sociedad,
	   reg.VAL_SERI_DOCU_REFE,
	   reg.VAL_NUME_DOCU_REFE,
	   reg.IMP_IMPU,
   	   gen_acc.acceso as sistema_emision,
	   gen_subac.subacceso as punto_emision,
   	   t_doc_r.COD_TIPO_DOCU as tipo_dcmto,
   	   reg.VAL_SERI_DOCU_LEGA as serie,
	   min(reg.NUM_DOCU_CONT_INTE) as doc_inicial,
	   max(reg.NUM_DOCU_CONT_INTE) as doc_final,
	   max(reg.NUM_DOCU_CONT_INTE) - min(reg.NUM_DOCU_CONT_INTE) as cant_doc,
   	   sum(reg.IND_ESTA) as cant_anul,
	   max(reg.VAL_NUME_DOCU_LEGA) - min(reg.VAL_NUME_DOCU_LEGA) - count(reg.IND_ESTA) as cant_doc_no_regis, 
	   sum(reg.VAL_BASE_IMPO) as base_imponible,
	   sum(reg.VAL_DESC) as descuento,
	   sum(reg.VAL_BASE_IMPO_NETO) as base_impo_neto,
	   sum(reg.IMP_IMPU) as igv,
	   sum(reg.IMP_TOTA) as importe_total,
	   count(reg.IND_FACT_GRAT) as tg
from fac_regis_unico_venta reg,
	 fac_tipo_docum t_doc,
	 fac_tipo_docum t_doc_r,
	 seg_subac subac,
	 seg_acces acc,
	 (
	  select val_oid, val_i18n pais
	  from v_gen_i18n_sicc
	  where attr_enti = 'SEG_PAIS'
	  		and idio_oid_idio = 1 --PARAMETRO--
	 )gen_pais,
	 (
	  select val_oid, val_i18n sociedad
	  from v_gen_i18n_sicc
	  where attr_enti ='SEG_SOCIE'
	 	   and idio_oid_idio = 1 --PARAMETRO--
	 )gen_soc,
	 (
	  select val_oid, val_i18n acceso
	  from v_gen_i18n_sicc
	  where attr_enti ='SEG_ACCES'
	 	   and idio_oid_idio = 1 --PARAMETRO--
	 )gen_acc,
	 (
	  select val_oid, val_i18n subacceso
	  from v_gen_i18n_sicc
	  where attr_enti ='SEG_SUBAC'
	 	   and idio_oid_idio = 1 --PARAMETRO--
	 )gen_subac
where 
	  reg.SBAC_OID_SBAC = subac.OID_SBAC
	  and reg.PAIS_OID_PAIS = gen_pais.val_oid(+)
	  and reg.TIDO_OID_TIPO_DOCU = t_doc.OID_TIPO_DOCU(+)
	  and reg.TIDO_TIPO_DOCU_REFE = t_doc_r.OID_TIPO_DOCU(+)
	  and reg.SOCI_OID_SOCI = gen_soc.val_oid(+)
	  and subac.ACCE_OID_ACCE = acc.oid_acce
	  and reg.SOCI_OID_SOCI = 1 --PARAMETRO--
	  and reg.SBAC_OID_SBAC in (1) --PARAMETRO--
	  and reg.PAIS_OID_PAIS = 1 --PARAMETRO--
	  and reg.TIDO_OID_TIPO_DOCU in (5,11,14) --PARAMETRO--
	  and subac.ACCE_OID_ACCE = 1 --PARAMETRO--
	  and acc.CANA_OID_CANA = 1 --PARAMETRO--
	  and TO_DATE(reg.FEC_EMIS) BETWEEN to_date('1/1/2004','DD/MM/YYYY')  and to_date('31/12/2015','DD/MM/YYYY')
	  and acc.oid_acce = gen_acc.val_oid
	  and subac.OID_SBAC = gen_subac.val_oid
group by gen_pais.pais,
	   gen_soc.sociedad,
	   reg.VAL_SERI_DOCU_REFE,
	   reg.VAL_NUME_DOCU_REFE,
	   reg.IMP_IMPU,
   	   gen_acc.acceso,
	   gen_subac.subacceso,
   	   t_doc_r.COD_TIPO_DOCU,
   	   reg.VAL_SERI_DOCU_LEGA