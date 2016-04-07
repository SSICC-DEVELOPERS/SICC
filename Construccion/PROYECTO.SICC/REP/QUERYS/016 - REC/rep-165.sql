--SINO VIENE PERIODO DESDE REMOVER EL SUBSELECT PER_DESDE, ADEMAS DE LA CONDICION DEL WHERE--
--SINO VIENE PERIODO HASTA REMOVER EL SUBSELECT PER_HASTA, ADEMAS DE LA CONDICION DEL WHERE--
 
select sociedad.sociedad,
	   cab_rec.NUM_ATEN as codigo_reclamo,
	   t_op.VAL_TIPO_OPER,
	   cli.COD_CLIE cod_responsable,
	   cli.val_ape1||' '||cli.val_ape2||' '||cli.val_nom1||' '||cli.val_nom2 as nombre_responsable,	  
	   gen_asu_per.ASUME_PERDIDA,
	   cab_rec.FEC_INGR as fecha_registro,
	   per2.val_nomb_peri as periodo_registro,
	   cli2.cod_clie as cod_cliente,
	   op_rec.IMP_MONT_PERD,
	   sol_cab.fec_cron as fecha_sol,
	   gen_t_sol.tipo_solicitud as TIPO_SOLICITUD_PERDIDA,
	   cab_rec.NUM_RECL AS NUME_SOLI,
	   sol_cab.VAL_NUME_SOLI as DOCU_REFER,
	   per.val_nomb_peri as periodo_referencia,
	   det_of.VAL_CODI_VENT,
	   prod.cod_sap,
	   gen_prod.descripcion,
	   lin_rec.NUM_UNID_RECL as unidades,
	   lin_rec.IMP_MONT_PERD as monto_factura
from rec_cabec_recla cab_rec,
	 rec_opera_recla op_rec,
	 rec_linea_opera_recla lin_rec,
	 rec_tipo_movim tip_mov,
	 rec_tipos_opera t_op,
	 mae_produ prod,
	 pre_matri_factu mat_fac,
	 pre_ofert_detal det_of,
	 ped_solic_cabec sol_cab,
	 ped_tipo_solic_pais t_sol_p,
	 cra_perio per,
	 cra_perio per2,
	 mae_clien cli,
	 mae_clien cli2,
	 (
	  select val_oid, val_i18n descripcion
	  from v_gen_i18n_sicc
	  where attr_enti = 'MAE_PRODU'
	  		and idio_oid_idio = 1 --PARAMETRO IDIOMA--
	 )gen_prod,
	 (
	  select val_oid, val_i18n tipo_solicitud
	  from v_gen_i18n_sicc
	  where attr_enti = 'PED_TIPO_SOLIC'
	  		and idio_oid_idio = 1 --PARAMETRO IDIOMA--
	 )gen_t_sol,
	 (
	  select val_oid, val_i18n asume_perdida
	  from v_gen_i18n_sicc
	  where attr_enti = 'REC_ASUME_PERDI'
	  		and idio_oid_idio = 1 --PARAMETRO IDIOMA--
	 )gen_asu_per,
	 (
	  	select pro.stringvalue as sociedad
		from principals pri,
			propertyvalues pro			
		where pri.name = 'USUARIO1'						-- PARAMETRO DE USUARIO POR DEFECTO --
			 and pro.idproperty = 48
			 and pro.idprincipal = pri.idprincipal
	  )sociedad,
	  (
	   select oid_peri, fec_inic 
	   from cra_perio
	   where oid_peri = 1379
	  )per_desde,
	  (
	   select oid_peri, fec_fina
	   from cra_perio
	   where oid_peri = 71
	  )per_hasta
where cab_rec.OID_CABE_RECL = op_rec.CARE_OID_CABE_RECL
	  and op_rec.OID_OPER_RECL = lin_rec.OPRE_OID_OPER_RECL
	  and lin_rec.TIMO_OID_TIPO_MOVI = tip_mov.OID_TIPO_MOVI 
--	  and op_rec.ASPE_OID_ASUM_PERD is not null
	  and tip_mov.COD_TIPO_MOVI = 'D'
	  and lin_rec.prod_oid_prod = prod.oid_prod
	  and prod.oid_prod = gen_prod.val_oid(+)
	  and lin_rec.MAFA_OID_MATR_FACT = mat_fac.OID_MATR_FACT(+)
	  and mat_fac.OFDE_OID_DETA_OFER = det_of.OID_DETA_OFER(+)
	  and lin_rec.prod_oid_prod = det_of.prod_oid_prod
	  and cab_rec.soca_oid_soli_cabe = sol_cab.oid_soli_cabe
	  and sol_cab.PERD_OID_PERI = per.oid_peri
	  and op_rec.TIOP_OID_TIPO_OPER = t_op.OID_TIPO_OPER
	  and op_rec.CLIE_OID_RESP_PERD = cli.oid_clie
	  and cab_rec.PERD_OID_PERI_RECL = per2.oid_peri
	  and cab_rec.clie_oid_clie = cli2.oid_clie
	  and op_rec.TSPA_OID_TIPO_SOLI_PAIS = t_sol_p.OID_TIPO_SOLI_PAIS(+)
	  and t_sol_p.TSOL_OID_TIPO_SOLI = gen_t_sol.val_oid(+)
  	  and op_rec.ASPE_OID_ASUM_PERD = gen_asu_per.val_oid(+)
/*	  and cab_rec.pais_oid_pais = 1 --PARAMETRO PAIS--
	  and t_op.OID_TIPO_OPER in (1) --PARAMETRO TIPO DE OPERACION--
	  and cab_rec.NUM_ATEN IN ('11111') --PARAMETRO NUMERO DE ATENCION--
	  and per2.marc_oid_marc = 1 --PARAMETRO MARCA--
	  and per2.cana_oid_cana = 1 --PARAMETRO CANAL--
	  and cab_rec.FEC_INGR between '1/1/2001' --PARAMETRO FECHA DE REGISTRO DESDE--
	  and '1/12/2015' --PARAMETRO FECHA DE REGISTRO HASTA--
	  and op_rec.ASPE_OID_ASUM_PERD in (1) --PARAMETRO ASUME PERDIDA--
	  and t_sol_p.OID_TIPO_SOLI_PAIS in (1) --PARAMETRO TIPO SOLICITUD PERDIDA--
	  and op_rec.CLIE_OID_RESP_PERD in (1) --PARAMETRO RESPONSABLE PERDIDA--*/
	  and per_desde.fec_inic <= per2.fec_inic
	  and per_hasta.fec_fina >= per2.fec_fina  