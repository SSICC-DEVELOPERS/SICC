select
	  a.periodo,
	  a.actividades,
	  a.fecha_prev,
	  a.fecha_fina,
	  a.pais,
	  a.val_anio,
	  a.grupo,
	  a.actividades_i18n
from 
(
	select periodo,
	--
	  	   CASE WHEN (decode((select fer.OID_FERI from cra_feria fer 
		   where fer.CACT_OID_ACTI = OID_ACTI
		   		 and fer.CGZO_OID_CABE_GRUP_ZONA = OID_CABE_GRUP_ZONA
				 and fer.FEC_FERI = fecha_prev
				 and fer.IND_FEST = 1
				 ),NULL,'NO','SI') = 'SI') THEN 'FESTIVO'
		   ELSE 	   own_peru.rep_004_concat_act(
		   						   41,								-- PARAMETRO 	idperi_par in number,-- 
								   fecha_prev, 
								   1,								-- PARAMETRO 	idgrupo_par in number,-- 
								   1,								-- PARAMETRO 	idpais_par in number,-- 
								   1,								-- PARAMETRO 	idmarca_par in number,-- 
								   1								-- PARAMETRO 	idcanal_par in number--
								  ) 
		   END AS actividades,
	-- 
		   fecha_prev, fecha_fina, pais, val_anio, grupo, 
		   own_peru.rep_004_concat_act_I18N (
								   1,								-- PARAMETRO 	idpais_par in number,-- 
								   1,								-- PARAMETRO 	idmarca_par in number,-- 
								   1,								-- PARAMETRO 	idcanal_par in number,-- 
								   1								-- PARAMETRO 	ididioma_par in number--
								  ) as actividades_I18N
	from 
	   (
		select per.VAL_NOMB_PERI  periodo, act.COD_ACTI , gen_pais.val_i18n pais, cor.VAL_ANIO, gen_grupo.val_i18n grupo, 
			   zon.COD_ZONA, cab.OID_CABE_GRUP_ZONA, act.oid_acti,
			   (
				select min(gru1.fec_prev)  
				from cra_crono_grupo_zona gru1, 
					cra_cabec_grupo_zona cab1, 
					cra_activ act1
				where gru1.PERD_OID_PERI=per.OID_PERI
					and cab1.MARC_OID_MARC=cab.MARC_OID_MARC  
					and cab1.CANA_OID_CANA=cab.CANA_OID_CANA
					and cab1.PAIS_OID_PAIS=cab.PAIS_OID_PAIS
					and gru1.CACT_OID_ACTI=cro.CACT_OID_ACTI
					and gru1.CGZO_OID_CABE_GRUP_ZONA=cro.CGZO_OID_CABE_GRUP_ZONA
			  ) fecha_prev,
			  (
				select max(gru2.fec_fina)  
				from cra_crono_grupo_zona gru2, 
					cra_cabec_grupo_zona cab2, 
					cra_activ act2
				where gru2.PERD_OID_PERI=per.OID_PERI
					and cab2.MARC_OID_MARC=cab.MARC_OID_MARC
					and cab2.CANA_OID_CANA=cab.CANA_OID_CANA
					and cab2.PAIS_OID_PAIS=cab.PAIS_OID_PAIS
					and gru2.CACT_OID_ACTI=cro.CACT_OID_ACTI
					and gru2.CGZO_OID_CABE_GRUP_ZONA=cro.CGZO_OID_CABE_GRUP_ZONA
			   ) fecha_fina
		from cra_crono_grupo_zona cro,
			 cra_cabec_grupo_zona cab,
			 cra_perio per,
			 cra_activ act,
			 seg_perio_corpo cor,
			 cra_detal_grupo_zona det,
			 cra_feria fer,
			 zon_zona zon,
			 (		
				select oid_peri 
				from 
				(		
					 select per.oid_peri, per.fec_inic, per.fec_fina
					 from 		
					 (
			 		  	select per2.oid_peri, per2.fec_inic
						from cra_perio per2
						where per2.oid_peri=41 			   			--PARAMETRO--
					 )per_selec,
					 cra_perio per
					 where per.fec_inic>=per_selec.fec_inic
				 	 	   and per.CANA_OID_CANA=1 		   			--PARAMETRO--
				 		   and per.MARC_OID_MARC=1 		   			--PARAMETRO--
				 		   and per.pais_oid_pais=1 					--PARAMETRO--
		    		order by per.fec_inic
			  	) 
		  	  where rownum in(1,2,3)
			 )tres_per,
			  (
			   		select gen.VAL_OID, gen.VAL_I18N 
					from v_gen_i18n_sicc gen 
					where gen.ATTR_ENTI='SEG_PAIS'
						and gen.IDIO_OID_IDIO=1   	 				--PARAMETRO--
			  )gen_pais,
			  (
			   		select gen.VAL_OID, gen.VAL_I18N 
					from v_gen_i18n_sicc gen 
					where gen.ATTR_ENTI='CRA_CABEC_GRUPO_ZONA'
						and gen.IDIO_OID_IDIO=1 			  		--PARAMETRO--
			  )gen_grupo
		where cro.CACT_OID_ACTI=act.OID_ACTI
			  and cro.PERD_OID_PERI=per.oid_peri
			  and per.PERI_OID_PERI=cor.oid_peri
			  and cro.CGZO_OID_CABE_GRUP_ZONA=cab.OID_CABE_GRUP_ZONA
			  and det.CGZO_OID_CABE_GRUP_ZONA=cab.OID_CABE_GRUP_ZONA
			  and det.ZZON_OID_ZONA=zon.oid_zona
			  and per.oid_peri=tres_per.oid_peri
			  and per.PAIS_OID_PAIS=gen_pais.val_oid
			  and cab.OID_CABE_GRUP_ZONA=gen_grupo.val_oid
			  and cab.OID_CABE_GRUP_ZONA=1 			  				--PARAMETRO--
			  and cro.oid_cron_grup_zona = fer.oid_feri(+) 
		)
	where fecha_prev is not null
)a
group by a.periodo,
	  a.actividades,
	  a.fecha_prev,
	  a.fecha_fina,
	  a.pais,
	  a.val_anio,
	  a.grupo,
	  a.actividades_i18n
order by a.periodo, a.fecha_prev, a.fecha_fina
