select 
	   gen_op.operacion,
   	   (
		   select pro.stringvalue
		   from principals pri,
		   		propertyvalues pro			
		   where pri.name = 'USUARIO1'--PARAMETRO CODIGO DE USUARIO--
		   		 and pro.idproperty = 48
				 and pro.idprincipal = pri.idprincipal
	   ) sociedad,
	   per.val_nomb_peri,
	   gen_t_sol.tipo_sol,
	   reg.oid_regi,
	   reg.DES_REGI,
   	   zon.OID_ZONA,
	   zon.DES_ZONA,
	   count(distinct lin_rec.OID_LINE_OPER_RECL) as cantidad
from
	rec_cabec_recla cab_rec,
	rec_opera_recla op_rec,
	rec_linea_opera_recla lin_rec,
	rec_opera op,
	rec_tipos_opera t_op,
	rec_tipo_movim t_mov,	
	ped_tipo_solic_pais t_sol_p,
	ped_tipo_solic t_sol,
	cra_perio per,
	zon_regio reg,
	zon_zona zon,
	zon_terri_admin ter_adm,
	zon_secci sec,
	(
	 select val_oid, val_i18n tipo_sol
	 from v_gen_i18n_sicc
	 where attr_enti= 'PED_TIPO_SOLIC'
	 	   and idio_oid_idio = 1
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
	)per_fin,
	(
	 select val_oid, val_i18n operacion
	 from v_gen_i18n_sicc
	 where attr_enti = 'REC_OPERA'
	 	   and idio_oid_idio = 1 --PARAMETRO IDIOMA--
	)gen_op		
where
	 cab_rec.OID_CABE_RECL = op_rec.CARE_OID_CABE_RECL
	 and op_rec.OID_OPER_RECL = lin_rec.OPRE_OID_OPER_RECL
	 and lin_rec.TSPA_OID_TIPO_SOLI_PAIS = t_sol_p.OID_TIPO_SOLI_PAIS
	 and t_sol_p.TSOL_OID_TIPO_SOLI = t_sol.oid_tipo_soli
	 and t_sol.oid_tipo_soli = gen_t_sol.val_oid(+)
	 and op_rec.TIOP_OID_TIPO_OPER = t_op.OID_TIPO_OPER
 	 and t_op.ROPE_OID_OPER = op.OID_OPER
	 and op.OID_OPER = gen_op.val_oid(+)
 	 and lin_rec.TIMO_OID_TIPO_MOVI = t_mov.OID_TIPO_MOVI
	 and t_mov.COD_TIPO_MOVI = 'E'
	 ----------------------------------------------------------------------------------------------------------
	 and op_rec.PERD_OID_PERI_RECL = per.oid_peri
 	 and per_ini.fec_inic <= per.fec_inic
	 and per.fec_fina <= per_fin.fec_fina
	 ----------------------------------------------------------------------------------------------------------
	 and cab_rec.ZTAD_OID_TERR_ADMI = ter_adm.OID_TERR_ADMI(+)
	 and ter_adm.ZSCC_OID_SECC = sec.OID_SECC(+)
	 and sec.ZZON_OID_ZONA = zon.oid_zona(+)
	 and zon.ZORG_OID_REGI = reg.oid_regi(+)
	 ----------------------------------------------------------------------------------------------------------
/*	 and cab_rec.pais_oid_pais = 1 --PARAMETRO PAIS--
	 and per.marc_oid_marc = 1 --PARAMETRO MARCA--
	 and per.cana_oid_cana = 1 --PARAMETRO CANAL--
	 and op.OID_OPER in (1) --PARAMETRO OPERACION--
	 and reg.oid_regi in (1) --PARAMETRO REGION--
	 and zon.oid_zona in (1) --PARAMETRO ZONA--*/
group by
	   gen_op.operacion,
	   per.val_nomb_peri,
	   gen_t_sol.tipo_sol,
	   reg.oid_regi,
	   reg.DES_REGI,
   	   zon.OID_ZONA,
	   zon.DES_ZONA
	  	 
	 