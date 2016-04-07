select per.VAL_NOMB_PERI, reg.COD_REGI, reg.DES_REGI, cab.COD_GRUP, act.COD_ACTI, zon.cod_zona,
	   gen_act.actividad,
	   cli.VAL_APE1||' '||cli.VAL_APE2||' '||cli.VAL_NOM1||' '||cli.VAL_NOM2 nombrecompleto,
	   cro.FEC_INIC fecha_prev, cro.FEC_FINA 
from cra_crono cro,
	 cra_perio per,
	 cra_activ act,
	 zon_zona zon,
	 zon_regio reg,
	 cra_detal_grupo_zona det,
	 cra_cabec_grupo_zona cab,
	 mae_clien cli,
	 (
	 select gen.VAL_I18N actividad, gen.VAL_OID
	 from v_gen_i18n_sicc gen
	 where gen.ATTR_ENTI = 'CRA_ACTIV'
	 	   and gen.IDIO_OID_IDIO = 1 --PARAMETRO--
	 )gen_act
where cro.PERD_OID_PERI = per.OID_PERI
  	  and cro.CACT_OID_ACTI = act.OID_ACTI
/*  	  and per.PAIS_OID_PAIS = 1 --PARAMETRO--
	  and per.CANA_OID_CANA = 1 --PARAMETRO--
	  and per.MARC_OID_MARC = 1 --PARAMETRO--
	  and per.OID_PERI = 1  --PARAMETRO--*/
	  and act.PAIS_OID_PAIS = per.PAIS_OID_PAIS
	  and act.CANA_OID_CANA = per.CANA_OID_CANA
	  and act.MARC_OID_MARC = per.MARC_OID_MARC
	  and act.OID_ACTI = gen_act.val_oid(+)
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
	  and zon.CLIE_OID_CLIE = cli.OID_CLIE(+)
order by
	  des_regi, cod_grup, cod_zona, actividad
 

	  
	  
	   




		
