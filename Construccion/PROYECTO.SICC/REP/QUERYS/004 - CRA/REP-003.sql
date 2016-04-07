select 
	gen2.VAL_I18N as pais , 
	cab.COD_GRUP, 
	gen3.VAL_I18N as grupo, 
	to_char(gru.FEC_PREV,'MON dd') AS Fecha, 
	per.VAL_NOMB_PERI, 
	cor.VAL_ANIO, 
	gen.VAL_I18N as actividad 
from 
	cra_perio per, 
	cra_crono_grupo_zona gru, 
	cra_activ act, 
	cra_cabec_grupo_zona cab, 
	seg_perio_corpo cor, 
	( 
	 Select g.VAL_OID, g.VAL_I18N 
	 From 
	 	 gen_i18n_sicc g 
	 Where 
			g.ATTR_ENTI='CRA_ACTIV' 
		and g.IDIO_OID_IDIO= 1 	 			-- PARAMETRO -- 
	) gen, 
	( 
	 Select g.VAL_OID, g.VAL_I18N 
	 From 
	 	 gen_i18n_sicc g 
	 Where 
			g.ATTR_ENTI='SEG_PAIS' 
		and g.IDIO_OID_IDIO= 1 	 			-- PARAMETRO -- 
	) gen2, 
	( 
	 Select g.VAL_OID, g.VAL_I18N 
	 From 
	 	 gen_i18n_sicc g 
	 Where 
			g.ATTR_ENTI='CRA_CABEC_GRUPO_ZONA' 
		and g.IDIO_OID_IDIO= 1 	 			-- PARAMETRO -- 
	) gen3, 
	seg_pais pai, 
	cra_detal_grupo_zona det, 
	zon_zona zon 
where 
	    gru.CACT_OID_ACTI=act.OID_ACTI 
	and gru.PERD_OID_PERI=per.OID_PERI 
	and per.PERI_OID_PERI=cor.OID_PERI 
	and gru.CGZO_OID_CABE_GRUP_ZONA=cab.OID_CABE_GRUP_ZONA 
	and act.PAIS_OID_PAIS=pai.OID_PAIS 
	and gen.VAL_OID(+)=act.OID_ACTI 
	and gen2.VAL_OID(+)=pai.OID_PAIS 
	and gen3.VAL_OID(+)=cab.OID_CABE_GRUP_ZONA 
	and det.CGZO_OID_CABE_GRUP_ZONA=cab.OID_CABE_GRUP_ZONA 
	and det.ZZON_OID_ZONA=zon.OID_ZONA 
	and pai.OID_PAIS=1 --value-- 
	and act.MARC_OID_MARC=1 --value-- 
	and act.CANA_OID_CANA=1 --value-- 
	and cor.VAL_ANIO=2004 --value-- 
	and act.OID_ACTI= 2 --value-- 
--	and zon.OID_ZONA in (1,2,3,4,5,6,7,8,9,10) --value-- 
group by 
	cab.COD_GRUP, 
	gen3.VAL_I18N, 
	gru.FEC_PREV, 
	per.VAL_NOMB_PERI, 
	cor.VAL_ANIO, 
	gen2.VAL_I18N, 
	gen.VAL_I18N 
order by 
    PAIS, GRUPO
