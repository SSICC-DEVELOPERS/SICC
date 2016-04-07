select
	  gen_pais.pais, 
	  cor.VAL_ANIO, 
	  per.VAL_NOMB_PERI, 
	  reg.DES_REGI, 
	  zon.COD_ZONA, 
	  gen_grupo.grupo, 
	  gen_act.actividad, 
	  cro.FEC_INIC fecha, 
	  fvt.NUM_PEDI estimado   
from cra_crono cro,
	 cra_perio per,
	 cra_activ act,
	 zon_zona zon,
	 zon_regio reg,
	 cra_detal_grupo_zona det,
	 cra_cabec_grupo_zona cab,
	 int_fuent_venta_previ_sap fvt,
	 seg_perio_corpo cor,
	 (
	 select gen.VAL_I18N actividad, gen.VAL_OID
	 from v_gen_i18n_sicc gen
	 where gen.ATTR_ENTI = 'CRA_ACTIV'
	 	   and gen.IDIO_OID_IDIO = 1 --PARAMETRO--
	 )gen_act,
	 (
	 select gen.VAL_I18N pais, gen.VAL_OID
	 from v_gen_i18n_sicc gen
	 where gen.ATTR_ENTI = 'SEG_PAIS'
	 	   and gen.IDIO_OID_IDIO = 1 --PARAMETRO--
	 )gen_pais,
	 (
	 select gen.VAL_I18N grupo, gen.VAL_OID
	 from v_gen_i18n_sicc gen
	 where gen.ATTR_ENTI = 'CRA_CABEC_GRUPO_ZONA'
	 	   and gen.IDIO_OID_IDIO = 1 --PARAMETRO--
	 )gen_grupo
where cro.PERD_OID_PERI(+) = per.OID_PERI
	  and cro.CACT_OID_ACTI = act.OID_ACTI
/*	  and per.PAIS_OID_PAIS = 1 --PARAMETRO--
	  and per.CANA_OID_CANA = 1 --PARAMETRO--
	  and per.MARC_OID_MARC = 1 --PARAMETRO--
/*	  and act.OID_ACTI in (1) --PARAMETRO--
	  and per.OID_PERI = 1  --PARAMETRO--
	  and reg.oid_regi = 1*/
	  and act.OID_ACTI = gen_act.val_oid(+)
	  and act.PAIS_OID_PAIS = gen_pais.val_oid(+)
	  and cab.OID_CABE_GRUP_ZONA = gen_grupo.val_oid(+)
	  and cro.ZZON_OID_ZONA = zon.OID_ZONA(+)
	  and zon.ZORG_OID_REGI = reg.OID_REGI(+)
	  and zon.PAIS_OID_PAIS = reg.PAIS_OID_PAIS
	  and zon.MARC_OID_MARC = reg.MARC_OID_MARC
	  and zon.CANA_OID_CANA = reg.CANA_OID_CANA
	  and zon.OID_ZONA = det.ZZON_OID_ZONA
	  and det.CGZO_OID_CABE_GRUP_ZONA = cab.OID_CABE_GRUP_ZONA
	  and cab.PAIS_OID_PAIS = per.PAIS_OID_PAIS   
	  and cab.CANA_OID_CANA = per.CANA_OID_CANA
	  and cab.MARC_OID_MARC = per.MARC_OID_MARC
	  and fvt.PERD_OID_PERI = per.OID_PERI
  	  and per.PERI_OID_PERI = cor.OID_PERI
	  and fvt.ZZON_OID_ZONA = zon.OID_ZONA
order by zon.COD_ZONA, gen_grupo.grupo, gen_act.actividad
