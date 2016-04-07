select gen_pais.pais,
	per.val_nomb_peri,
	   (
		   select pro.stringvalue
		   from principals pri,
		   		propertyvalues pro			
		   where pri.name = 'USUARIO1'--PARAMETRO CODIGO DE USUARIO--
		   		 and pro.idproperty = 48
				 and pro.idprincipal = pri.idprincipal
	   ) empresa,
	   reg.COD_REGI,
	   reg.DES_REGI,
	   cli2.VAL_APE1||' '||cli2.VAL_APE2||' '||cli2.VAL_NOM1||' '||cli2.VAL_NOM2 as gerente_region,
	   zon.COD_ZONA,
	   zon.DES_ZONA,
	   cli.VAL_APE1||' '||cli.VAL_APE2||' '||cli.VAL_NOM1||' '||cli.VAL_NOM2 as gerente_zona,
	   nvl(sum(fac.VAL_TOTA_PAGA_DOCU),0) as facturado,
	   --------------------------------------------------------------------------------------------------------
	   nvl(count(distinct op.OID_OPER),0) as operaciones_anuladas,
	   --------------------------------------------------------------------------------------------------------
	   decode( nvl(sum(fac.VAL_TOTA_PAGA_DOCU),0),0,0,
	   		   nvl(count(distinct op.OID_OPER),0) / sum(fac.VAL_TOTA_PAGA_DOCU) )*100 as por_anulaciones,
	   --------------------------------------------------------------------------------------------------------			   
	   decode( nvl(sum(fac.NUM_UNID_ATEN_TOTA),0),0,0,
	   		   nvl(count(distinct op.OID_OPER),0) / sum(fac.NUM_UNID_ATEN_TOTA) )*100 as por_participacion,
	   --------------------------------------------------------------------------------------------------------
	   nvl(sum(fac.VAL_TOTA_PAGA_LOCA),0) as total	    
from
	fac_docum_conta_cabec fac,
	fac_docum_conta_linea fac_lin,
	rec_cabec_recla cab_rec,
	rec_opera_recla op_rec,
	rec_opera op,
	rec_tipos_opera t_op,
	zon_regio reg,
	zon_zona zon,
	mae_clien cli,
	mae_clien cli2,
	cra_perio per,
	(
	 select fec_inic
	 from cra_perio
	 where oid_peri = 1379 --PARAMETRO PERIODO INICIO--
	)per_ini,
	(
	 select fec_fina
	 from cra_perio
	 where oid_peri = decode(71,-1,1379,71) --PARAMETRO PERIODO FIN--
	)per_fin,
	(
	 select val_oid, val_i18n pais
	 from v_gen_i18n_sicc
	 where attr_enti = 'SEG_PAIS'
	 	   and idio_oid_idio = 1 --PARAMETRO IDIOMA--
	)gen_pais		
where
	 fac.OID_CABE = fac_lin.DCCA_OID_CABE(+)
	 and cab_rec.OID_CABE_RECL = op_rec.CARE_OID_CABE_RECL
	 and fac.soca_oid_soli_cabe(+) = cab_rec.soca_oid_soli_cabe
	 and cab_rec.OID_CABE_RECL = op_rec.CARE_OID_CABE_RECL
	 and op_rec.TIOP_OID_TIPO_OPER = t_op.OID_TIPO_OPER
	 and t_op.ROPE_OID_OPER = op.OID_OPER
	 ----------------------------------------------------------------------------------------------------------
	 and fac.ZORG_OID_REGI = reg.oid_regi
	 and fac.ZZON_OID_ZONA = zon.oid_zona
	 and zon.CLIE_OID_CLIE = cli.oid_clie(+)
	 and reg.CLIE_OID_CLIE = cli2.oid_clie(+)
	 ----------------------------------------------------------------------------------------------------------
	 and cab_rec.PERD_OID_PERI_RECL = per.oid_peri
 	 and per_ini.fec_inic <= per.fec_inic
	 and per.fec_fina <= per_fin.fec_fina
	 ----------------------------------------------------------------------------------------------------------
	 and cab_rec.pais_oid_pais = gen_pais.val_oid(+)
	 and cab_rec.pais_oid_pais = 1 --PARAMETRO PAIS--
	 and per.marc_oid_marc in (1) --PARAMETRO MARCA--
	 and per.cana_oid_cana in (1) --PARAMETRO CANAL--
	 and reg.oid_regi in (1) --PARAMETRO REGION--
	 and zon.oid_zona in (1) --PARAMETRO ZONA--
	 and op.OID_OPER = 1 --PARAMETRO
group by
	  gen_pais.pais,
	   reg.COD_REGI,
	   reg.DES_REGI,
	   cli2.VAL_APE1||' '||cli2.VAL_APE2||' '||cli2.VAL_NOM1||' '||cli2.VAL_NOM2,
	   zon.COD_ZONA,
	   zon.DES_ZONA,
	   cli.VAL_APE1||' '||cli.VAL_APE2||' '||cli.VAL_NOM1||' '||cli.VAL_NOM2,
	   per.val_nomb_peri