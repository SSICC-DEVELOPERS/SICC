select gen_pais.pais,
	   (
		   select pro.stringvalue
		   from principals pri,
		   		propertyvalues pro			
		   where pri.name = 'USUARIO1'--PARAMETRO CODIGO DE USUARIO--
		   		 and pro.idproperty = 48
				 and pro.idprincipal = pri.idprincipal
	   ) sociedad,
	   per.val_nomb_peri,
	   reg.oid_regi,
	   reg.DES_REGI,
	   op.COD_OPER,
	   gen_op.operacion,
	   zon.cod_zona,
	   cli.VAL_APE1||' '||cli.VAL_APE2||' '||cli.VAL_NOM1||' '||cli.VAL_NOM2 as gerente,
	   nvl(sum(fac.VAL_TOTA_PAGA_DOCU),0) as facturado,
	   nvl(sum(lin_rec.NUM_UNID_RECL),0) as cant_operacion,
	   decode( nvl(sum(fac.VAL_TOTA_PAGA_DOCU),0),0,0,
	   		   nvl(sum(lin_rec.NUM_UNID_RECL),0) / sum(fac.VAL_TOTA_PAGA_DOCU) )*100 as por_oper_fact,
	   decode( nvl(sum(fac_lin.NUM_UNID_ATEN),0),0,0,
	   		   nvl(sum(lin_rec.NUM_UNID_RECL),0) / sum(fac_lin.NUM_UNID_ATEN) )*100 as por_participacion,
	   nvl(sum(fac.VAL_TOTA_PAGA_LOCA),0) as total
from
	fac_docum_conta_cabec fac,
	fac_docum_conta_linea fac_lin,
	ped_solic_cabec sol,
	rec_cabec_recla cab_rec,
	rec_opera_recla op_rec,
	rec_linea_opera_recla lin_rec,
	rec_tipos_opera t_op,
	rec_opera op,
	zon_regio reg,
	zon_zona zon,
	mae_clien cli,
	cra_perio per,
	(
	 select val_oid, val_i18n pais
	 from v_gen_i18n_sicc
	 where attr_enti = 'SEG_PAIS'
	 	   and idio_oid_idio = 1 --PARAMETRO IDIOMA--
	)gen_pais,
	(
	 select fec_inic
	 from cra_perio
	 where oid_peri = 1379 --PARAMETRO--
	)per_ini,
	(
	 select fec_fina
	 from cra_perio
	 where oid_peri = decode(71,-1,1379,71) --PARAMETRO--
	)per_fin,
	(
	 select val_oid, val_i18n operacion
	 from v_gen_i18n_sicc
	 where attr_enti = 'REC_OPERA'
	 	   and idio_oid_idio = 1 --PARAMETRO IDIOMA--
	)gen_op
where
	 fac.OID_CABE = fac_lin.DCCA_OID_CABE(+)
	 and fac.SOCA_OID_SOLI_CABE(+) = sol.oid_soli_cabe
	 and cab_rec.SOCA_OID_SOLI_CABE = sol.oid_soli_cabe
	 and cab_rec.OID_CABE_RECL = op_rec.CARE_OID_CABE_RECL
	 and op_rec.OID_OPER_RECL = lin_rec.OPRE_OID_OPER_RECL
	 ----------------------------------------------------------------------------------------------------------
	 and fac.ZORG_OID_REGI = reg.oid_regi
	 and fac.ZZON_OID_ZONA = zon.oid_zona
	 ----------------------------------------------------------------------------------------------------------
	 and zon.CLIE_OID_CLIE = cli.oid_clie(+)
	 and cab_rec.pais_oid_pais = gen_pais.val_oid(+)
	 and op_rec.TIOP_OID_TIPO_OPER = t_op.OID_TIPO_OPER
	 and t_op.ROPE_OID_OPER = op.OID_OPER
	 and op.OID_OPER = gen_op.val_oid(+)
	 and op.IND_ANUL <> 1
	 and fac.PERD_OID_PERI = per.oid_peri
	 and per_ini.fec_inic <= per.fec_inic
	 and per.fec_fina <= per_fin.fec_fina
	 and cab_rec.pais_oid_pais = 1 --PARAMETRO PAIS--
--	 and reg.oid_regi in (1) --PARAMETRO REGION--
--	 and zon.oid_zona in (1) --PARAMETRO ZONA--
	 and op.OID_OPER in (1) --PARAMETRO TIPO DE OPERACION--
--	 and per.marc_oid_marc in (1) --PARAMETRO MARCA--
--	 and per.cana_oid_cana in (1) --PARAMETRO CANAL--
group by
	  gen_pais.pais,
	  per.val_nomb_peri,
	  reg.oid_regi,
	  reg.DES_REGI,
	  op.COD_OPER,
	  gen_op.operacion,
	  zon.cod_zona,
	  cli.VAL_APE1||' '||cli.VAL_APE2||' '||cli.VAL_NOM1||' '||cli.VAL_NOM2
order by
	  per.val_nomb_peri,
	  gen_op.operacion,
	  des_regi,
	  cod_zona	  
