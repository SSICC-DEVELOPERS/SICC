select cod_regi, cod_grup, cod_acti, des_regi,   actividad, periodo, fecha_prev, fecha_fina, zonas, inicio, fin 
from  (
	select cod_regi, cod_grup, des_regi,  cod_acti, actividad, periodo, cod_zona, fecha_prev, fecha_fina, 
		own_peru.REP_008_CONCAT_ZONA (oid_peri, OID_REGI, OID_CRON_GRUP_ZONA, 1, 1, 1) as zonas,
		decode(fecha_fina,null,null,'INICIO') as inicio,
		decode(fecha_fina,null,null,'FIN') as fin
	from (
			select reg.cod_regi, cab.cod_grup, act.COD_ACTI, reg.OID_REGI,   cro.OID_CRON_GRUP_ZONA, per.VAL_NOMB_PERI periodo, per.oid_peri, reg.des_regi,  zon.cod_zona,
			        gen_act.val_i18n AS actividad,
					(
					 select min(cro1.fec_prev)  
					 from cra_crono_grupo_zona cro1, 
						cra_cabec_grupo_zona cab1, 
						cra_activ act1
					 where cro1.PERD_OID_PERI=per.OID_PERI
						and cab1.MARC_OID_MARC=cab.MARC_OID_MARC  
						and cab1.CANA_OID_CANA=cab.CANA_OID_CANA
						and cab1.PAIS_OID_PAIS=cab.PAIS_OID_PAIS
						and cro1.CACT_OID_ACTI=cro.CACT_OID_ACTI
						and cro1.CGZO_OID_CABE_GRUP_ZONA=cro.CGZO_OID_CABE_GRUP_ZONA
					)as fecha_prev,
					(
					 select max(cro2.fec_fina)  
					 from cra_crono_grupo_zona cro2, 
						cra_cabec_grupo_zona cab2, 
						cra_activ act2
					 where cro2.PERD_OID_PERI=per.OID_PERI
						and cab2.MARC_OID_MARC=cab.MARC_OID_MARC
						and cab2.CANA_OID_CANA=cab.CANA_OID_CANA
						and cab2.PAIS_OID_PAIS=cab.PAIS_OID_PAIS
						and cro2.CACT_OID_ACTI=cro.CACT_OID_ACTI
						and cro2.CGZO_OID_CABE_GRUP_ZONA=cro.CGZO_OID_CABE_GRUP_ZONA
					)as fecha_fina
			from zon_regio reg,
				 zon_zona zon, 
				 cra_crono_grupo_zona cro,
				 cra_cabec_grupo_zona cab,
				 cra_detal_grupo_zona det,
				 cra_perio per,
				 cra_activ act,
			    (
				 SELECT gen.val_oid, gen.val_i18n
			     FROM v_gen_i18n_sicc gen
			     WHERE gen.attr_enti = 'CRA_ACTIV'
			     	   AND gen.idio_oid_idio = 1                           --PARAMETRO--
			     ) gen_act
			where zon.ZORG_OID_REGI=reg.OID_REGI
				  and cro.CGZO_OID_CABE_GRUP_ZONA=cab.OID_CABE_GRUP_ZONA
				  and cab.OID_CABE_GRUP_ZONA=det.CGZO_OID_CABE_GRUP_ZONA
				  and det.ZZON_OID_ZONA=zon.OID_ZONA
				  and cro.PERD_OID_PERI=per.OID_PERI
				  and cro.CACT_OID_ACTI=act.OID_ACTI 
				  and act.oid_acti=gen_act.val_oid
				  and cro.PERD_OID_PERI=57 		  	 						  --PARAMETRO--
				  and reg.pais_oid_pais = 1                                   --PARAMETRO--
				  and reg.marc_oid_marc = 1                                   --PARAMETRO--
				  and reg.cana_oid_cana = 1                                   --PARAMETRO--
			  	  and zon.pais_oid_pais = 1                                   --PARAMETRO--
				  AND zon.marc_oid_marc = 1                                   --PARAMETRO--
				  AND zon.cana_oid_cana = 1                                   --PARAMETRO--
				  and cab.pais_oid_pais = 1                                   --PARAMETRO--
				  and cab.marc_oid_marc = 1                                   --PARAMETRO--
				  and cab.cana_oid_cana = 1                                   --PARAMETRO--
	)
)a
group by cod_regi, cod_grup, cod_acti, des_regi,   actividad, periodo, fecha_prev, fecha_fina, 
zonas, inicio, fin
order by des_regi, cod_grup, zonas, cod_acti
	  

