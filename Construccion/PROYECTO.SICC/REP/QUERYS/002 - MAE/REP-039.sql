select 
	pai.cod_pais, t_gen.VAL_I18N as pais, 
	subg.cod_subg_vent, subg.DES_SUBG_VENT, 
	reg.COD_REGI, reg.DES_REGI, 
	zon.COD_ZONA, zon.DES_ZONA,
	(a.an_fvt * cambio.val_cambio) as fvt_ant, (a.an_real * cambio.val_cambio) as real_ant , a.por_an,
	(a.ac_fvt * cambio.val_cambio) as fvt_act, (a.ac_real * cambio.val_cambio) as real_act , a.por_ac,
	(a.anio_ant_real * cambio.val_cambio) as real_anio_ant, (a.anio_ant_FVt * cambio.val_cambio) as fvt_anio_ant, a.por_anio_ant
from
	zon_sub_geren_venta subg,
	zon_regio reg,
	zon_zona zon,
	seg_pais pai,
	(
		  select avg(val_tipo_camb) as val_cambio
		  from seg_tipo_cambi cam,
		  seg_pais pai,
		  cra_perio per3
		  where cam.MONE_OID_MON1= pai.MONE_OID_MONE
		  and cam.MONE_OID_MON2=2  						  	-- VALUE --
		  and per3.fec_inic>=cam.FEC_DESD
		  and per3.fec_fina<=cam.FEC_HAST
		  and per3.oid_peri=56		  	 		   		 	-- PARAMETRO --
		  and pai.oid_pais=1		  	 		   		 	-- PARAMETRO --
	)cambio,
	(
	  	select gen.VAL_OID, gen.VAL_I18N
		from v_gen_i18n_sicc gen
		where gen.ATTR_ENTI='SEG_PAIS'
		and gen.IDIO_OID_IDIO=1		  	 		   		 	-- PARAMETRO --
	) t_gen,
	(
	select decode(actual_anterior.zona_ac_ant,null,anio_anterior.zona,actual_anterior.zona_ac_ant) as zona, 
	actual_anterior.ac_fvt, actual_anterior.ac_real, actual_anterior.por_ac,
	actual_anterior.an_fvt, actual_anterior.an_real, actual_anterior.por_an,
	anio_anterior.anio_ant_fvt, anio_anterior.anio_ant_real, anio_anterior.por_anio_ant
	from (
	select decode(actual.zona,null,anterior.zona,actual.zona) as zona_ac_ant, 
	actual.ac_fvt, actual.ac_real, actual.por_ac,
	anterior.an_fvt, anterior.an_real, anterior.por_an
	from 
	(
		 select decode(fact.peri,null,prev.peri,fact.peri) as periodo,
		 decode(fact.zona,null,prev.zona,fact.zona)as zona, 
		 fact.peri as peri_fact, fact.zona as zona_fact, prev.peri peri_prev, prev.zona zona_prev, 
		 fact.valor_f as ac_real, prev.valor_p as ac_FVt,
		 decode(prev.valor_p,0,0,(fact.valor_f/prev.valor_p)*100) as por_ac
		 from 
		 ( 	 
		 select fac.PERD_OID_PERI as peri, fac.ZZON_OID_ZONA as zona, sum(fac.VAL_TOTA_PAGA_DOCU) as valor_f
		 from fac_docum_conta_cabec fac
		 group by fac.PERD_OID_PERI, fac.ZZON_OID_ZONA
		 )fact full outer join 
		 (
		 select per.OID_PERI as peri, pre.ZZON_OID_ZONA as zona, sum(pre.VAL_VENT_NETA_ESTA) as valor_p
		 from int_fuent_venta_previ_sap pre,
		 cra_perio per
		 where pre.PERD_OID_PERI=PER.OID_PERI
		 and per.PAIS_OID_PAIS=1		  	 		   		 	 						-- PARAMETRO --
		 group by per.OID_PERI, pre.ZZON_OID_ZONA
		 )prev on fact.peri=prev.peri and fact.zona=prev.zona
		 where decode(fact.peri,null,prev.peri,fact.peri)=56	  	 		   		 	-- PARAMETRO --
	)actual full outer join
	(
	 	 select decode(fact.peri,null,prev.peri,fact.peri) as periodo,
		 decode(fact.zona,null,prev.zona,fact.zona) as zona,
		 fact.peri as peri_fact, fact.zona as zona_fact, prev.peri peri_prev, prev.zona zona_prev, 
		 fact.valor_f as an_REAL, prev.valor_p as an_FVt,
		 decode(prev.valor_p,0,0,(fact.valor_f/prev.valor_p)*100) as por_an
		 from
		 (
	 	  	 select oid_peri, fec_inic from (
			 Select per3.oid_peri, per3.fec_inic
			 from
			 (
			  	 select per2.oid_peri, per2.FEC_INIC
				 from cra_perio per2
				 where per2.OID_PERI=56		  	 		   		 	 	-- PARAMETRO --
				 and per2.pais_oid_pais=1		  	 		   		 	-- PARAMETRO --
			 )per_para,
			 cra_perio per3
			 where per3.fec_inic<per_para.fec_inic
			 order by per3.fec_inic desc
			 )
			 where rownum=1
		)peri_anterior, 
		( 	 
		select fac.PERD_OID_PERI as peri, fac.ZZON_OID_ZONA as zona, sum(fac.VAL_TOTA_PAGA_DOCU) as valor_f
		from fac_docum_conta_cabec fac
		group by fac.PERD_OID_PERI, fac.ZZON_OID_ZONA
		)fact full outer join 
		  (
		 select per.OID_PERI as peri, pre.ZZON_OID_ZONA as zona, sum(pre.VAL_VENT_NETA_ESTA) as valor_p
		 from 
		 	 int_fuent_venta_previ_sap pre,
			 cra_perio per
		 where 
		 	 pre.PERD_OID_PERI=PER.OID_PERI
			 and per.PAIS_OID_PAIS=1		  	 		   		 	 				-- PARAMETRO --
		 group by per.OID_PERI, pre.ZZON_OID_ZONA
		 )prev on  fact.peri=prev.peri and fact.zona=prev.zona
		 where decode(fact.peri,null,prev.peri,fact.peri)= peri_anterior.oid_peri
	)anterior on actual.zona=anterior.zona
	) actual_anterior,  
	(
 	 select decode(fact.peri,null,prev.peri,fact.peri) as periodo,
		 decode(fact.zona,null,prev.zona,fact.zona) as zona, 
		 fact.valor_f as anio_ant_real, prev.valor_p as anio_ant_FVt,
		 decode(prev.valor_p,0,0,(fact.valor_f/prev.valor_p)*100) as por_anio_ant
	 from
		 (-------------------------------idperiodo 
 		 select per.OID_PERi as pdos
		 from
			 cra_perio per, 
			 (---------------------------p_an_ant 
			 SELECT p_an_ant.pdos
			 FROM 
				 (
				 SELECT uno.puno, uno.val_anio, dos.pdos, dos.val_anio
		         FROM 		   
					 (
					 SELECT   p1.oid_peri AS puno, p1.val_anio, ROWNUM AS runo
			         FROM seg_perio_corpo p1,
				         (
						 SELECT p3.val_anio
				         FROM seg_perio_corpo p3,
						 	  cra_perio p
				         WHERE p3.OID_PERI = p.PERI_OID_PERI
						 	   and p.oid_peri = 56		  	 		   		 	 				-- PARAMETRO --
				         ) anio
			         WHERE p1.val_anio = anio.val_anio
			         ORDER BY p1.oid_peri ASC
					 )uno,
			         (
					 SELECT   p2.oid_peri pdos, p2.val_anio, ROWNUM AS rdos
			         FROM seg_perio_corpo p2,
				         (
						 SELECT p4.val_anio, p4.val_anio - 1 AS anio_ant
				         FROM seg_perio_corpo p4,
						 	  cra_perio p
				         WHERE p4.oid_peri = p.PERI_OID_PERI
						 	   and p.oid_peri = 56		  	 		   		 	 				-- PARAMETRO --
			         	 ) anio_ant
			         WHERE p2.val_anio = anio_ant.anio_ant
			         ORDER BY p2.oid_peri ASC
					 ) dos
		         WHERE runo = rdos
				 ) p_an_ant--------------------------
			 WHERE p_an_ant.puno = 56		  	 		   		 	 			-- PARAMETRO --
			 )per_cor
		 where per.PERI_OID_PERI=per_cor.pdos
	  	 and per.PAIS_OID_PAIS=1		  	 		   		 	 			-- PARAMETRO --
		 )idperiodo,--------------------------------
		 ( 	 
		 select fac.PERD_OID_PERI as peri, fac.ZZON_OID_ZONA as zona, sum(fac.VAL_TOTA_PAGA_DOCU) as valor_f
		 from fac_docum_conta_cabec fac
		 group by fac.PERD_OID_PERI, fac.ZZON_OID_ZONA
		 )fact full outer join
		 (
		 select per.OID_PERI as peri, pre.ZZON_OID_ZONA as zona, sum(pre.VAL_VENT_NETA_ESTA) as valor_p
		 from int_fuent_venta_previ_sap pre,
			 cra_perio per
			 where pre.PERD_OID_PERI=PER.OID_PERI
			 and per.PAIS_OID_PAIS=1		  	 		   		 	 				-- PARAMETRO --
		 group by per.OID_PERI, pre.ZZON_OID_ZONA
		 )prev on  fact.peri=prev.peri and fact.zona=prev.zona
		 where decode(fact.peri,null,prev.peri,fact.peri)= idperiodo.pdos
	)anio_anterior 
	where anio_anterior.zona(+)=actual_anterior.zona_ac_ant
	)a
where 
	zon.oid_zona=a.zona
	and zon.ZORG_OID_REGI=reg.OID_REGI
	and reg.ZSGV_OID_SUBG_VENT=subg.OID_SUBG_VENT
	and subg.PAIS_OID_PAIS=pai.oid_pais
	and t_gen.val_oid=pai.oid_pais
	and subg.PAIS_OID_PAIS=1		  	 		   		 	 				-- PARAMETRO --
	and subg.MARC_OID_MARC=1		  	 		   		 	 				-- PARAMETRO --
	and subg.CANA_OID_CANA=1		  	 		   		 	 				-- PARAMETRO --
	and subg.OID_SUBG_VENT=1		  	 		   		 	 				-- PARAMETRO --
	and reg.OID_REGI=1		  	 		   		 	 						-- PARAMETRO --
	and zon.OID_ZONA=1		  	 		   		 	 						-- PARAMETRO --
group by  
	pai.cod_pais, t_gen.VAL_I18N, subg.cod_subg_vent, subg.DES_SUBG_VENT, reg.COD_REGI, reg.DES_REGI, zon.COD_ZONA, zon.DES_ZONA,
	a.an_fvt * cambio.val_cambio , a.an_real * cambio.val_cambio , a.por_an,
	a.ac_fvt * cambio.val_cambio , a.ac_real * cambio.val_cambio , a.por_ac,
	a.anio_ant_real * cambio.val_cambio , a.anio_ant_FVt * cambio.val_cambio , a.por_anio_ant
order by pai.cod_pais, subg.cod_subg_vent, reg.COD_REGI, zon.COD_ZONA