SELECT 
	   gen_pais.pais,
	   gen_soc.sociedad,
	   reg.IND_ESTA, --si indicador  = 1 entonces se mostrara ANULADO--
	   reg.IND_TRAN_GRAT, --si indicador = 1 entonces se mostrara TRANSFERENCIA GRATUITA--
	   sol.VAL_NUME_SOLI boleta_despacho,
	   t_doc.COD_TIPO_DOCU,
	   reg.VAL_SERI_DOCU_LEGA,
	   reg.VAL_NUME_DOCU_LEGA,
	   reg.VAL_NUME_IDEN_FISC,
	   cli.COD_CLIE,
	   reg.VAL_APE1||' '||reg.VAL_APE2||' '||reg.VAL_NOM1||' '||reg.VAL_NOM2 nombre_completo,
	   t_doc_r.COD_TIPO_DOCU,
	   reg.VAL_SERI_DOCU_REFE,
	   reg.VAL_NUME_DOCU_REFE,
	   reg.VAL_BASE_IMPO,
	   reg.VAL_DESC,
	   reg.VAL_BASE_IMPO_NETO,
	   reg.IMP_IMPU,
	   reg.IMP_TOTA
from fac_regis_unico_venta reg,
	 fac_docum_conta_cabec fac,
	 fac_tipo_docum t_doc,
	 fac_tipo_docum t_doc_r,
	 seg_subac subac,
	 seg_acces acc,
	 ped_solic_cabec sol,
	 mae_clien cli,
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
	 )gen_soc
where 
	  reg.SBAC_OID_SBAC = subac.OID_SBAC
	  and reg.DCCA_OID_CABE = fac.OID_CABE(+)
	  and reg.PAIS_OID_PAIS = gen_pais.val_oid(+)
	  and reg.TIDO_OID_TIPO_DOCU = t_doc.OID_TIPO_DOCU(+)
	  and reg.TIDO_TIPO_DOCU_REFE = t_doc_r.OID_TIPO_DOCU(+)
	  and reg.CLIE_OID_CLIE = cli.OID_CLIE
	  and reg.SOCI_OID_SOCI = gen_soc.val_oid(+)
	  and fac.SOCA_OID_SOLI_CABE = sol.oid_soli_cabe (+)
	  and subac.ACCE_OID_ACCE = acc.oid_acce
	  and reg.SOCI_OID_SOCI = 1 --PARAMETRO--
	  and reg.SBAC_OID_SBAC in (1) --PARAMETRO--
	  and reg.PAIS_OID_PAIS = 1 --PARAMETRO--
	  and reg.TIDO_OID_TIPO_DOCU in (5,11,14) --PARAMETRO--
	  and subac.ACCE_OID_ACCE = 1 --PARAMETRO--
	  and acc.CANA_OID_CANA = 1 --PARAMETRO--
	  and TO_DATE(reg.FEC_EMIS) BETWEEN to_date('1/1/2004','DD/MM/YYYY')  and to_date('31/12/2015','DD/MM/YYYY')
order by sociedad, nombre_completo