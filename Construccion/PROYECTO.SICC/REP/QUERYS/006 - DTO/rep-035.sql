select 
	pai.COD_PAIS, gen_pais.val_i18n pais, subg.COD_SUBG_VENT, reg.COD_REGI, zon.COD_ZONA, sec.COD_SECC, ter.COD_TERR,
	cli.COD_CLIE, cli.VAL_APE1 ||' '||cli.VAL_APE2||' '||cli.VAL_NOM1||' '||cli.VAL_NOM2 as nombre_completo,
	tipo_clien.COD_TIPO_CLIE, subti_clien.COD_SUBT_CLIE, mae_clasi.COD_CLAS, mae_tipo_clasi_clien.COD_TIPO_CLAS,
	gen_tipo_descu.val_i18n tipo_descuento, des.NUM_DESC,
	cla.COD_CLAS_SOLI, tipo_sol.COD_TIPO_SOLI, cab.VAL_NUME_SOLI,  
	of_det.VAL_CODI_VENT, prod.COD_SAP, 
	his.VAL_BASE_CALC, his.VAL_BASE_CALC_ACUM, his.VAL_VENT_REAL, his.VAL_PORC_APLI, his.IMP_DESC_APLI
from 
	dto_histo_dto his,
	dto_descu des,
	dto_matri_descu mat,
	ped_solic_cabec cab,
	ped_clase_solic cla,
	pre_matri_factu mat_fac,
	pre_ofert_detal of_det, 
	seg_pais pai,
	ped_tipo_solic_pais tipo_sol_pais,
	ped_tipo_solic tipo_sol,
	mae_clien cli,
	mae_clien_tipo_subti tipo_subti,
	mae_tipo_clien tipo_clien,
	mae_subti_clien subti_clien,
	mae_clien_clasi,
	mae_clasi,
	mae_tipo_clasi_clien,
	mae_clien_unida_admin un_adm,
	mae_produ prod,
	zon_terri_admin ter_admi,
	zon_terri ter,
	zon_secci sec,
	zon_zona zon,
	zon_regio reg,
	zon_sub_geren_venta subg,
	(
	select gen.VAL_OID, gen.VAL_I18N
	from v_gen_i18n_sicc gen
	where gen.ATTR_ENTI='DTO_MATRI_DESCU'
	and gen.IDIO_OID_IDIO=1 --PARAMETRO--
	)gen_tipo_descu,
	(
	select gen.VAL_OID, gen.VAL_I18N
	from v_gen_i18n_sicc gen
	where gen.ATTR_ENTI='SEG_PAIS'
	and gen.IDIO_OID_IDIO=1 --PARAMETRO--
	)gen_pais
where 
	      his.DCTO_OID_DESC = des.OID_DESC
	  and his.SOCA_OID_SOLI_CABE = cab.OID_SOLI_CABE
  	  and his.CLIE_OID_CLIE = cli.OID_CLIE
	  and his.PAIS_OID_PAIS = pai.OID_PAIS
	  and cab.TSPA_OID_TIPO_SOLI_PAIS = tipo_sol_pais.OID_TIPO_SOLI_PAIS
	  and tipo_sol_pais.OID_TIPO_SOLI_PAIS = tipo_sol.OID_TIPO_SOLI(+)
	  and tipo_sol.CLSO_OID_CLAS_SOLI = cla.OID_CLAS_SOLI(+)
	  and cli.OID_CLIE = tipo_subti.CLIE_OID_CLIE(+)
	  and tipo_subti.TICL_OID_TIPO_CLIE = tipo_clien.OID_TIPO_CLIE(+)
	  and tipo_subti.SBTI_OID_SUBT_CLIE = subti_clien.OID_SUBT_CLIE(+)
	  and tipo_subti.OID_CLIE_TIPO_SUBT = mae_clien_clasi.CTSU_OID_CLIE_TIPO_SUBT(+)
	  and mae_clien_clasi.TCCL_OID_TIPO_CLASI = mae_tipo_clasi_clien.OID_TIPO_CLAS(+)
	  and mae_clien_clasi.TCCL_OID_TIPO_CLASI = mae_clasi.OID_CLAS(+)
	  and un_adm.CLIE_OID_CLIE(+) = cli.OID_CLIE
	  and ter_admi.OID_TERR_ADMI(+) =un_adm.ZTAD_OID_TERR_ADMI
	  and ter_admi.TERR_OID_TERR = ter.OID_TERR(+)
	  and ter_admi.ZSCC_OID_SECC = sec.OID_SECC(+)
	  and sec.ZZON_OID_ZONA = zon.OID_ZONA(+)
	  and zon.ZORG_OID_REGI = reg.OID_REGI(+)
	  and reg.ZSGV_OID_SUBG_VENT = subg.OID_SUBG_VENT(+)
	  and des.MDES_OID_TIPO_DESC = mat.OID_TIPO_DESC
	  and mat.OID_TIPO_DESC = gen_tipo_descu.val_oid
	  and his.MAFA_OID_MATR_FACT = mat_fac.OID_MATR_FACT
	  and mat_fac.OFDE_OID_DETA_OFER = of_det.OID_DETA_OFER
	  and of_det.PROD_OID_PROD = prod.OID_PROD
	  and his.PAIS_OID_PAIS = gen_pais.val_oid
	  and his.PAIS_OID_PAIS = pai.OID_PAIS
	  and pai.OID_PAIS = 1 	  			  	  			   	  		 				--PARAMETRO--
--	  and cli.COD_CLIE = '00000000001'												--PARAMETRO--
--	  and reg.OID_REGI in (1) 														--PARAMETRO--
--	  and reg.ZSGV_OID_SUBG_VENT in (1) 												--PARAMETRO--
--	  and zon.OID_ZONA in (1) 														--PARAMETRO--
--	  and ter.OID_TERR in (1) 														--PARAMETRO--
--	  and tipo_clien.OID_TIPO_CLIE in (1) 											--PARAMETRO--
--	  and subti_clien.OID_SUBT_CLIE in (1) 											--PARAMETRO--
--	  and mae_tipo_clasi_clien.OID_TIPO_CLAS (1) 									--PARAMETRO--
--	  and mae_clasi.OID_CLAS in (1) 		 										--PARAMETRO--
--	  and mat.OID_TIPO_DESC in (1)			  										--PARAMETRO--
--	  and des.NUM_DESC in (1)  														--PARAMETRO--
--	  and cla.OID_CLAS_SOLI in (1) 													--PARAMETRO--
--	  and tipo_sol.OID_TIPO_SOLI in (1) 											--PARAMETRO--
--	  and cab.VAL_NUME_SOLI=1 	 													--PARAMETRO--
group by cli.VAL_APE1 ||' '||cli.VAL_APE2||' '||cli.VAL_NOM1||' '||cli.VAL_NOM2,
	   gen_tipo_descu.val_i18n, des.NUM_DESC,  
	   cab.VAL_NUME_SOLI,
	   his.SOCA_OID_SOLI_CABE, his.VAL_BASE_CALC, his.VAL_BASE_CALC_ACUM, his.VAL_VENT_REAL, his.IMP_DESC_APLI, his.VAL_PORC_APLI,
	   pai.COD_PAIS, cla.COD_CLAS_SOLI, tipo_sol.COD_TIPO_SOLI, cab.OID_SOLI_CABE, 
   	   tipo_clien.COD_TIPO_CLIE, subti_clien.COD_SUBT_CLIE, mae_clasi.COD_CLAS, mae_tipo_clasi_clien.COD_TIPO_CLAS,
	   subg.COD_SUBG_VENT, reg.COD_REGI, zon.COD_ZONA, sec.COD_SECC, ter.COD_TERR,
	   prod.COD_SAP, cli.COD_CLIE, gen_pais.val_i18n, of_det.VAL_CODI_VENT
order by 
	pai.COD_PAIS, gen_pais.val_i18n, subg.COD_SUBG_VENT, reg.COD_REGI, zon.COD_ZONA, sec.COD_SECC, ter.COD_TERR,
	cli.COD_CLIE, cli.VAL_APE1 ||' '||cli.VAL_APE2||' '||cli.VAL_NOM1||' '||cli.VAL_NOM2,
	tipo_clien.COD_TIPO_CLIE, subti_clien.COD_SUBT_CLIE, mae_clasi.COD_CLAS, mae_tipo_clasi_clien.COD_TIPO_CLAS,
	gen_tipo_descu.val_i18n , des.NUM_DESC,
	cla.COD_CLAS_SOLI, tipo_sol.COD_TIPO_SOLI, cab.VAL_NUME_SOLI,  
	of_det.VAL_CODI_VENT, prod.COD_SAP, 
	his.VAL_BASE_CALC, his.VAL_BASE_CALC_ACUM, his.VAL_VENT_REAL, his.VAL_PORC_APLI, his.IMP_DESC_APLI


** Solo falta el Codigo de linea, este se muestra en el layout y no se lo nombra en el DECU ...	  