select gen_pais.pais,
	   (
		   select pro.stringvalue
		   from principals pri,
		   		propertyvalues pro			
		   where pri.name = 'USUARIO1'--PARAMETRO CODIGO DE USUARIO--
		   		 and pro.idproperty = 48
				 and pro.idprincipal = pri.idprincipal
	   ) sociedad,
	   reg.oid_regi,
	   reg.DES_REGI,
	   gen_op.operacion,
	   per.val_nomb_peri,
	   gen_t_sol.tipo_sol,
	   nvl(sum(fac_lin.NUM_UNID_ATEN),0)facturado,
	   nvl(sum(rec_lin.NUM_UNID_RECL),0)total_operaciones,
	   decode( nvl(sum(fac_lin.NUM_UNID_ATEN),0),0,0,
	   		nvl(sum(rec_lin.NUM_UNID_RECL),0) / sum(fac_lin.NUM_UNID_ATEN) )*100 as porcentaje   
from
	fac_docum_conta_cabec fac,
	fac_docum_conta_linea fac_lin,
	rec_cabec_recla rec_cab,
	rec_opera_recla op_rec,
	rec_linea_opera_recla rec_lin,
	rec_opera op,
	rec_tipos_opera t_op,
	rec_preci prec,
	rec_tipo_movim t_mov,
	zon_regio reg,
	zon_zona zon,
	cra_perio per,
	ped_tipo_solic_pais t_sol_p,
	ped_tipo_solic t_sol,
	(
	 select val_oid, val_i18n operacion
	 from v_gen_i18n_sicc
	 where attr_enti = 'REC_OPERA'
	 	   and idio_oid_idio = 1 --PARAMETRO IDIOMA--
	)gen_op,
	(
	 select val_oid, val_i18n pais
	 from v_gen_i18n_sicc
	 where attr_enti = 'SEG_PAIS'
	 	   and idio_oid_idio = 1 --PARAMETRO IDIOMA--
	)gen_pais,
	(
	 select val_oid, val_i18n tipo_sol
	 from v_gen_i18n_sicc
	 where attr_enti = 'PED_TIPO_SOLIC'
	 	   and idio_oid_idio = 1 --PARAMETRO IDIOMA--
	)gen_t_sol,
	(
	 select fec_inic
	 from cra_perio
	 where oid_peri = 1379 --PARAMETRO PERIODO INICIO--
	)per_ini,
	(
	 select fec_fina
	 from cra_perio
	 where oid_peri = decode(71,-1,1379,71) --PARAMETRO PERIODO FIN--
	)per_fin	
where
	 fac.OID_CABE = fac_lin.DCCA_OID_CABE(+)
	 and rec_cab.SOCA_OID_SOLI_CABE(+) = fac.SOCA_OID_SOLI_CABE
	 and rec_cab.OID_CABE_RECL = op_rec.CARE_OID_CABE_RECL
	 and op_rec.TIOP_OID_TIPO_OPER = t_op.OID_TIPO_OPER
	 and op_rec.OID_OPER_RECL = rec_lin.OPRE_OID_OPER_RECL
	 and t_op.ROPE_OID_OPER = op.OID_OPER
	 and op.PECI_OID_PECI = prec.OID_PREC
--	 and prec.COD_PREC = 'I'
	 and rec_lin.TIMO_OID_TIPO_MOVI = t_mov.OID_TIPO_MOVI
--	 and t_mov.COD_TIPO_MOVI = 'E'
	 and op.OID_OPER = gen_op.val_oid(+)
	 and rec_cab.pais_oid_pais = gen_pais.val_oid(+)
	 ----------------------------------------------------------------------------------------------------------
	 and fac.ZORG_OID_REGI = reg.oid_regi
	 and fac.zzon_oid_zona = zon.oid_zona
	 ----------------------------------------------------------------------------------------------------------
	 and op_rec.PERD_OID_PERI_RECL = per.oid_peri
 	 and per_ini.fec_inic <= per.fec_inic
	 and per.fec_fina <= per_fin.fec_fina
	 ----------------------------------------------------------------------------------------------------------
	 and rec_lin.TSPA_OID_TIPO_SOLI_PAIS = t_sol_p.OID_TIPO_SOLI_PAIS(+)
	 and t_sol_p.TSOL_OID_TIPO_SOLI = t_sol.oid_tipo_soli(+)
	 and t_sol.oid_tipo_soli = gen_t_sol.val_oid(+)
--	 and reg.oid_regi in (1) --PARAMETRO REGION--
--	 and zon.oid_zona in (1) --PARAMETRO ZONA--
--	 and op.OID_OPER in (1) --PARAMETRO OPERACION--
	 and rec_cab.pais_oid_pais = 1 --PARAMETRO PAIS--
	 and per.marc_oid_marc = 1 --PARAMETRO MARCA--
	 and per.cana_oid_cana = 1 --PARAMETRO CANAL--
group by
	  reg.oid_regi,
	  reg.DES_REGI,
	  gen_pais.pais,
	  gen_op.operacion,
	  gen_t_sol.tipo_sol,
	  per.val_nomb_peri