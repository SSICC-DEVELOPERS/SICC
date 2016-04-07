--CUANDO MAX_PERIO IS NOT NULL se escribe: RETIRADA ULT. PED.(internacionalizado) Y EL CAMPO MAX_PERIO--
select 	
		per3.VAL_NOMB_PERI periodo,
	   mar.DES_MARC, gen_canal.canal,
	   per.VAL_NOMB_PERI periodo_inicio, 
	   per2.VAL_NOMB_PERI periodo_fin, 
	   reg.DES_REGI, zon.DES_ZONA,
	   cli.COD_CLIE, 
	   cli.VAL_APE1 ||' '||cli.VAL_APE2||' '||cli.VAL_NOM1||' '||cli.VAL_NOM2 as nombre_completo, 
	   sum(fac.VAL_PREC_CATA_TOTA_DOCU)/ count(distinct sol.OID_SOLI_CABE) as catalogo,
	   sum(his_dto.VAL_PORC_APLI)/count(distinct sol.OID_SOLI_CABE) as ganancia,
	   null as max_perio
from edu_histo_curso his,
	 mae_clien_unida_admin adm,
	 zon_terri_admin ter_adm, 
	 zon_secci sec, 
	 zon_zona zon, 
	 zon_regio reg,
	 mae_clien cli,
	 edu_matri_curso cur,
	 cra_perio per, 
	 cra_perio per2,
	 cra_perio per3,
 	 fac_docum_conta_cabec fac, 
	 mae_clien_histo_estat his_est,
	 mae_estat_clien est,
	 ped_solic_cabec sol,
	 dto_histo_dto his_dto,
	 dto_descu des,
	 seg_marca mar,
	 (
	 select gen.VAL_OID, gen.VAL_I18N canal 
	 from v_gen_i18n_sicc gen
	 where gen.ATTR_ENTI = 'SEG_CANAL'
	 	   and gen.IDIO_OID_IDIO = 1 --PARAMETRO--
	 )gen_canal,
	 (
	 select per_i.FEC_INIC 
	 from cra_perio per_i
	 where per_i.oid_peri = 1379 --PARAMETRO--
	 )per_inic,
	 (
	 select per_f.fec_fina 
	 from cra_perio per_f
	 where per_f.oid_peri = 71 --PARAMETRO--
	 )per_fina
where his.CLIE_OID_CLIE = adm.CLIE_OID_CLIE
	  and adm.ZTAD_OID_TERR_ADMI = ter_adm.OID_TERR_ADMI
	  and ter_adm.ZSCC_OID_SECC = sec.OID_SECC
	  and sec.ZZON_OID_ZONA = zon.OID_ZONA
	  and zon.ZORG_OID_REGI = reg.OID_REGI
/*	  and zon.OID_ZONA = 1 --PARAMETRO--
	  and reg.OID_REGI = 1 --PARAMETRO--
	  and cur.PAIS_OID_PAIS = 1 --PARAMETRO--
	  and cur.MARC_OID_MARC = 1 --PARAMETRO--
	  and cur.CANA_OID_CANA = 1 --PARAMETRO--*/
--	  and cur.OID_CURS = 1
	  and cur.CANA_OID_CANA = gen_canal.val_oid(+)
	  and cur.MARC_OID_MARC = mar.OID_MARC
	  and his.CLIE_OID_CLIE = cli.OID_CLIE
	  and his.MCUR_OID_CURS = cur.OID_CURS
	  and adm.PERD_OID_PERI_INI = per.OID_PERI
	  and adm.PERD_OID_PERI_FIN = per2.oid_peri(+)
	  --
	  and fac.PERD_OID_PERI = per3.OID_PERI
	  and fac.PAIS_OID_PAIS = cur.PAIS_OID_PAIS
	  and fac.SOCA_OID_SOLI_CABE = sol.OID_SOLI_CABE
	  --
	  and sol.CLIE_OID_CLIE = his.CLIE_OID_CLIE
	  and his_est.CLIE_OID_CLIE(+) = his.CLIE_OID_CLIE
	  and his_est.PERD_OID_PERI = per3.OID_PERI
      and his_est.ESTA_OID_ESTA_CLIE = est.OID_ESTA_CLIE
 	  and est.OID_ESTA_CLIE <> 7 --ESTATUS NO "RETIRADA"--
	  --
	  and his_dto.CLIE_OID_CLIE = his.CLIE_OID_CLIE
	  and his_dto.PAIS_OID_PAIS = cur.PAIS_OID_PAIS
	  and his_dto.DCTO_OID_DESC = des.OID_DESC
	  and des.PERD_OID_PERI = per3.OID_PERI
	  and per.FEC_INIC >= per_inic.fec_inic
	  and per2.fec_fina <= per_fina.fec_fina
	  and per3.FEC_INIC >= per_inic.fec_inic
	  and per3.fec_fina <= per_fina.fec_fina
group by per3.VAL_NOMB_PERI,
	  mar.DES_MARC, gen_canal.canal, 
	  per.VAL_NOMB_PERI, per2.VAL_NOMB_PERI,
	  reg.DES_REGI, zon.DES_ZONA,
	  cli.COD_CLIE, cli.VAL_APE1 ||' '||cli.VAL_APE2||' '||cli.VAL_NOM1||' '||cli.VAL_NOM2
--------------------------------------------------------------------------------------------------------
union all
select per3.VAL_NOMB_PERI periodo,
	   mar.DES_MARC, gen_canal.canal,
	   per.VAL_NOMB_PERI periodo_inicio, 
	   per2.VAL_NOMB_PERI periodo_fin, 
	   reg.DES_REGI, zon.DES_ZONA,
	   cli.COD_CLIE, 
	   cli.VAL_APE1 ||' '||cli.VAL_APE2||' '||cli.VAL_NOM1||' '||cli.VAL_NOM2 as nombre_completo,
	   null as catalogo,
	   null as ganancia,
	   nvl((
	   select per_max.VAL_NOMB_PERI
		from ped_solic_cabec sol,
			 cra_perio per_max,
			 (
			 select per.OID_PERI 
			 from cra_perio per
			 order by per.FEC_FINA desc
			 )periodos
		where sol.CLIE_OID_CLIE = cli.OID_CLIE
			  and periodos.OID_PERI = sol.PERD_OID_PERI
			  and periodos.oid_peri = per_max.OID_PERI
			  and rownum = 1
		),' ')max_perio
from edu_histo_curso his,
	 mae_clien_unida_admin adm,
	 zon_terri_admin ter_adm, zon_secci sec, zon_zona zon, zon_regio reg,
	 mae_clien cli,
	 edu_matri_curso cur,
	 cra_perio per, 
	 cra_perio per2,
	 cra_perio per3,
 	 fac_docum_conta_cabec fac, 
	 mae_clien_histo_estat his_est,
	 mae_estat_clien est,
	 ped_solic_cabec sol,
	 dto_histo_dto his_dto,
	 dto_descu des,
	 seg_marca mar,
	 (
	 select gen.VAL_OID, gen.VAL_I18N canal 
	 from v_gen_i18n_sicc gen
	 where gen.ATTR_ENTI = 'SEG_CANAL'
	 	   and gen.IDIO_OID_IDIO = 1 --PARAMETRO--
	 )gen_canal,
	 (
	 select per.FEC_INIC 
	 from cra_perio per
	 where per.oid_peri = 1379--PARAMETRO--
	 )per_inic,
	 (
	 select per.fec_fina 
	 from cra_perio per
	 where per.oid_peri = 71 --PARAMETRO--
	 )per_fina
where his.CLIE_OID_CLIE = adm.CLIE_OID_CLIE
	  and adm.ZTAD_OID_TERR_ADMI = ter_adm.OID_TERR_ADMI
	  and ter_adm.ZSCC_OID_SECC = sec.OID_SECC
	  and sec.ZZON_OID_ZONA = zon.OID_ZONA
	  and zon.ZORG_OID_REGI = reg.OID_REGI
	  and zon.OID_ZONA = 1 --PARAMETRO--
	  and reg.OID_REGI = 1 --PARAMETRO--
	  and cur.PAIS_OID_PAIS = 1 --PARAMETRO--
	  and cur.MARC_OID_MARC = 1 --PARAMETRO--
	  and cur.CANA_OID_CANA = 1 --PARAMETRO--
--	  and cur.OID_CURS = 1
	  and cur.CANA_OID_CANA = gen_canal.val_oid(+)
	  and cur.MARC_OID_MARC = mar.OID_MARC
	  and his.CLIE_OID_CLIE = cli.OID_CLIE
	  and his.MCUR_OID_CURS = cur.OID_CURS
	  and adm.PERD_OID_PERI_INI = per.OID_PERI(+)
	  and adm.PERD_OID_PERI_FIN = per2.oid_peri(+)
	  and fac.PERD_OID_PERI = per3.OID_PERI
	  and fac.PAIS_OID_PAIS = cur.PAIS_OID_PAIS
	  and fac.SOCA_OID_SOLI_CABE = sol.OID_SOLI_CABE
	  --
	  and sol.CLIE_OID_CLIE = his.CLIE_OID_CLIE
	  and his_est.CLIE_OID_CLIE(+) = his.CLIE_OID_CLIE
	  and his_est.PERD_OID_PERI = per3.OID_PERI
      and his_est.ESTA_OID_ESTA_CLIE = est.OID_ESTA_CLIE
 	  and est.OID_ESTA_CLIE = 7 --ESTATUS " RETIRADA"--
	  --
	  and his_dto.CLIE_OID_CLIE = his.CLIE_OID_CLIE
	  and his_dto.PAIS_OID_PAIS = cur.PAIS_OID_PAIS
	  and his_dto.DCTO_OID_DESC = des.OID_DESC
	  and des.PERD_OID_PERI = per3.OID_PERI
  	  and per.FEC_INIC >= per_inic.fec_inic
	  and per2.fec_fina <= per_fina.fec_fina
	  and per3.FEC_INIC >= per_inic.fec_inic
	  and per3.fec_fina <= per_fina.fec_fina
group by per3.VAL_NOMB_PERI,
	  mar.DES_MARC, gen_canal.canal, 
	  per.VAL_NOMB_PERI, per2.VAL_NOMB_PERI,
	  reg.DES_REGI, zon.DES_ZONA,
	  cli.COD_CLIE, cli.VAL_APE1 ||' '||cli.VAL_APE2||' '||cli.VAL_NOM1||' '||cli.VAL_NOM2,
	  cli.OID_CLIE	  
order by periodo, periodo_inicio, periodo_fin, cod_clie, nombre_completo 
	   
