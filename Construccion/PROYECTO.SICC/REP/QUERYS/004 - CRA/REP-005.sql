select pais, anio, DES_ZONA, cod_grup, grupo, COD_ACTI, actividad, campana, fecha_prev, fecha_fina 
from (
	select act.COD_ACTI, gen_act.VAL_I18N as actividad, zon.DES_ZONA,  cab.COD_GRUP , per.VAL_NOMB_PERI as campana,
		   gen_pais.VAL_I18N as pais, cor.VAL_ANIO as anio, gen_grupo.val_i18n as grupo,
		gru.OID_CRON_GRUP_ZONA,
		(
		select min(gru1.fec_prev)  
		from cra_crono_grupo_zona gru1, 
			cra_cabec_grupo_zona cab1, 
			cra_activ act1
		where gru1.PERD_OID_PERI=per.OID_PERI
			and cab1.MARC_OID_MARC=cab.MARC_OID_MARC  
			and cab1.CANA_OID_CANA=cab.CANA_OID_CANA
			and cab1.PAIS_OID_PAIS=cab.PAIS_OID_PAIS
			and gru1.CACT_OID_ACTI=act.OID_ACTI
			and gru1.CGZO_OID_CABE_GRUP_ZONA=gru.CGZO_OID_CABE_GRUP_ZONA
		group by gru1.CGZO_OID_CABE_GRUP_ZONA, gru1.PERD_OID_PERI,cab1.MARC_OID_MARC, cab1.CANA_OID_CANA, 
		cab1.PAIS_OID_PAIS, gru1.CACT_OID_ACTI
		)as fecha_prev,
		(
		select max(gru2.fec_fina)  
		from cra_crono_grupo_zona gru2, 
			cra_cabec_grupo_zona cab2, 
			cra_activ act2
		where gru2.PERD_OID_PERI=per.OID_PERI
			and cab2.MARC_OID_MARC=cab.MARC_OID_MARC
			and cab2.CANA_OID_CANA=cab.CANA_OID_CANA
			and cab2.PAIS_OID_PAIS=cab.PAIS_OID_PAIS
			and gru2.CACT_OID_ACTI=gru.CACT_OID_ACTI
			and gru2.CGZO_OID_CABE_GRUP_ZONA=gru.CGZO_OID_CABE_GRUP_ZONA
		group by gru2.CGZO_OID_CABE_GRUP_ZONA, gru2.PERD_OID_PERI,cab2.MARC_OID_MARC, cab2.CANA_OID_CANA, 
		cab2.PAIS_OID_PAIS, gru2.CACT_OID_ACTI  
		)as fecha_fina
	from cra_perio per, 
		 cra_crono_grupo_zona gru, 
		 cra_cabec_grupo_zona cab, 
		 cra_activ act,
		 cra_detal_grupo_zona det,
		 seg_perio_corpo cor,
		 zon_zona zon,
		 (
		 select gen.VAL_OID, gen.VAL_I18N
		 from v_gen_i18n_sicc gen
		 where gen.ATTR_ENTI='CRA_CABEC_GRUPO_ZONA'
		 	   and gen.IDIO_OID_IDIO=1 --value--
		 )gen_grupo,
		 (
		 select gen2.VAL_OID, gen2.VAL_I18N
		 from v_gen_i18n_sicc gen2
		 where gen2.ATTR_ENTI='CRA_ACTIV'
		 	   and gen2.IDIO_OID_IDIO=1 --value--
		 )gen_act,
		 (
		 select gen3.VAL_OID, gen3.VAL_I18N
		 from v_gen_i18n_sicc gen3
		 where gen3.ATTR_ENTI='SEG_PAIS'
		 	   and gen3.IDIO_OID_IDIO=1 --value--
		 )gen_pais,
		 (
		 select per2.fec_inic, per2.fec_fina
		 from cra_perio per2
		 where per2.oid_peri=1379--value--
		 )per_desde,
		 (
		 select per3.fec_inic, per3.fec_fina
		 from cra_perio per3
		 where per3.oid_peri=71 --value--
		 )per_hasta
	where gru.PERD_OID_PERI=per.OID_PERI
		and gru.CACT_OID_ACTI=act.OID_ACTI
		and gru.CGZO_OID_CABE_GRUP_ZONA=cab.OID_CABE_GRUP_ZONA
		and per.PERI_OID_PERI=cor.OID_PERI
		and det.CGZO_OID_CABE_GRUP_ZONA=cab.OID_CABE_GRUP_ZONA
		and det.ZZON_OID_ZONA=zon.OID_ZONA
		and gen_grupo.val_oid=cab.OID_CABE_GRUP_ZONA
		and gen_act.val_oid=act.OID_ACTI
		and gen_pais.val_oid=per.PAIS_OID_PAIS
		and per.PAIS_OID_PAIS=1 --value--
		and per.CANA_OID_CANA=1 --value--
		and per.MARC_OID_MARC=1 --value--
		and cab.OID_CABE_GRUP_ZONA=1 --value--
		and act.OID_ACTI in (2) --value--
		and per.FEC_INIC>=per_desde.fec_inic  
		and per.FEC_inic<=per_hasta.fec_fina 
	)
group by COD_ACTI, actividad, cod_grup, campana, pais, anio, DES_ZONA, grupo, fecha_prev, fecha_fina
order by COD_ACTI, actividad, campana, fecha_prev



