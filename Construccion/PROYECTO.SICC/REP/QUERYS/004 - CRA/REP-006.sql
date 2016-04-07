select gen_pais.VAL_I18N,  
	   cro.FEC_PREV, 
	   act.COD_ACTI, 
	   gen.VAL_I18N as actividad, 
	   cor.VAL_ANIO as anio,
	   per.VAL_NOMB_PERI as periodo, 
	   gen2.VAL_I18N as grupo 
from cra_crono_grupo_zona cro, 
	 cra_cabec_grupo_zona cab,
	 cra_activ act,
	(
	 Select g.VAL_OID, g.VAL_I18N
	 From
	 	 gen_i18n_sicc g
	 Where	
			g.ATTR_ENTI='CRA_ACTIV'
		and g.IDIO_OID_IDIO= 1 	 							 -- PARAMETRO --
	) gen,
	(
	 Select g.VAL_OID, g.VAL_I18N
	 From
	 	 gen_i18n_sicc g
	 Where	
			g.ATTR_ENTI='CRA_CABEC_GRUPO_ZONA'
		and g.IDIO_OID_IDIO= 1 	 			  				 -- PARAMETRO --
	) gen2,
	(
	 Select g.VAL_OID, g.VAL_I18N
	 From
	 	 gen_i18n_sicc g
	 Where	
			g.ATTR_ENTI='SEG_PAIS'
		and g.IDIO_OID_IDIO= 1 	 			  				 -- PARAMETRO --
	) gen_pais,
	cra_perio per,
	seg_perio_corpo cor
where 
		cab.OID_CABE_GRUP_ZONA=cro.CGZO_OID_CABE_GRUP_ZONA
	and per.OID_PERI=cro.PERD_OID_PERI
	and per.PERI_OID_PERI=cor.OID_PERI
	and cro.CACT_OID_ACTI=act.OID_ACTI
	and gen.VAL_OID(+)=act.OID_ACTI
	and gen2.VAL_OID(+)=cab.OID_CABE_GRUP_ZONA
	and gen_pais.VAL_OID(+)=cab.PAIS_OID_PAIS
	and cab.PAIS_OID_PAIS=1                	  				-- PARAMETRO --
--	and cab.MARC_OID_MARC = 1                				-- PARAMETRO --
--	and cab.CANA_OID_CANA = 1                				-- PARAMETRO --
--	and cro.PERD_OID_PERI in (1)                			-- PARAMETRO --
--	and cro.CACT_OID_ACTI in (1)                			-- PARAMETRO --
--	and cro.FEC_PREV = to_date('02/12/2004', 'dd/MM/yyyy')                			-- PARAMETRO --
order by 
	actividad, anio, periodo, grupo