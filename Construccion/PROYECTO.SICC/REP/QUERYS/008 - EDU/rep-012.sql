select
	  per.VAL_NOMB_PERI, gen_curso.curso,  cursos.ped_regular, cursos.ped_extemporanea, cursos.ped_no_asistido 	   
from
	(
	select 
		   decode(decode(regular.perd_oid_peri, null, extemporaneas.perd_oid_peri, regular.perd_oid_peri), null, no_asistido.perd_oid_peri,decode(regular.perd_oid_peri, null, extemporaneas.perd_oid_peri,regular.perd_oid_peri))perd_oid_peri,   
		   decode(decode(regular.oid_curs, null, extemporaneas.oid_curs, regular.oid_curs), null, no_asistido.oid_curs, decode(regular.oid_curs, null, extemporaneas.oid_curs, regular.oid_curs)) oid_curs,    
		   regular.pedidos as ped_regular,
		   extemporaneas.pedidos as ped_extemporanea,
		   no_asistido.pedidos as ped_no_asistido
	from 
		(
		--REGULAR--		   
		select sol.PERD_OID_PERI, cur.OID_CURS, count(distinct sol.OID_SOLI_CABE) pedidos 
		from edu_histo_curso his_cur,
			 ped_solic_cabec sol,
			 edu_matri_curso cur
		where his_cur.clie_oid_clie = sol.CLIE_OID_CLIE
			  and his_cur.MCUR_OID_CURS = cur.OID_CURS 
			  and his_cur.IND_APTA = 1
			  and his_cur.IND_ASIS = 1
			  and cur.CANA_OID_CANA = 1 --PARAMETRO--
			  and cur.MARC_OID_MARC = 1 --PARAMETRO--
			  and cur.PAIS_OID_PAIS = 1 --PARAMETRO--
			  and cur.OID_CURS = 1 --PARAMETRO--
		group by sol.PERD_OID_PERI, cur.OID_CURS
		)regular 
		full outer join 
		(
		--EXTEMPORANEAS--
		select sol.PERD_OID_PERI, cur.OID_CURS, count(distinct sol.OID_SOLI_CABE) pedidos
		from edu_histo_curso his_cur,
			 ped_solic_cabec sol,
		 	 edu_matri_curso cur
		where his_cur.clie_oid_clie = sol.CLIE_OID_CLIE
			  and his_cur.MCUR_OID_CURS = cur.OID_CURS 
			  and his_cur.IND_INVIT = 1
			  and his_cur.IND_ASIS = 2
	  		  and cur.CANA_OID_CANA = 1 --PARAMETRO--
			  and cur.MARC_OID_MARC = 1 --PARAMETRO--
			  and cur.PAIS_OID_PAIS = 1 --PARAMETRO--
	  		  and cur.OID_CURS = 1 --PARAMETRO--
		group by sol.PERD_OID_PERI, cur.OID_CURS
		)extemporaneas 
		on regular.perd_oid_peri = extemporaneas.perd_oid_peri and regular.oid_curs = extemporaneas.oid_curs
		full outer join
		(
		--NO ASISTIDO-- 
		select sol.PERD_OID_PERI, cur.OID_CURS, count(distinct sol.OID_SOLI_CABE) pedidos
		from edu_histo_curso his_cur,
			 ped_solic_cabec sol,
		 	 edu_matri_curso cur
		where his_cur.clie_oid_clie = sol.CLIE_OID_CLIE
			  and his_cur.MCUR_OID_CURS = cur.OID_CURS 
			  and his_cur.IND_ASIS = 0
	  		  and cur.CANA_OID_CANA = 1 --PARAMETRO--
			  and cur.MARC_OID_MARC = 1 --PARAMETRO--
			  and cur.PAIS_OID_PAIS = 1 --PARAMETRO--
	  		  and cur.OID_CURS = 1 --PARAMETRO--
		group by sol.PERD_OID_PERI, cur.OID_CURS
		)no_asistido on ( no_asistido.perd_oid_peri = regular.perd_oid_peri and no_asistido.oid_curs = regular.oid_curs)
		or ( no_asistido.perd_oid_peri = extemporaneas.perd_oid_peri and no_asistido.oid_curs = extemporaneas.oid_curs) 
	)cursos,
	(
	select gen.VAL_OID, gen.VAL_I18N curso
	from v_gen_i18n_sicc gen
	where gen.ATTR_ENTI = 'EDU_MATRI_CURSO'
		  and gen.IDIO_OID_IDIO = 1 --PARAMETRO--
	)gen_curso,
	(
	select per_i.FEC_INIC
	from cra_perio per_i
	where per_i.oid_peri = 1379 --PARAMETRO--
	)per_inic,
	(
	select per_f.fec_fina 
	from cra_perio per_f
	where per_f.oid_peri = 71 --PARAMETRO--
	)per_fina,
	cra_perio per
where per.FEC_INIC >= per_inic.fec_inic
	  and per.fec_fina <= per_fina.fec_fina
	  and cursos.perd_oid_peri = per.OID_PERI
	  and cursos.oid_curs = gen_curso.val_oid(+)
order by per.VAL_NOMB_PERI, gen_curso.curso,  cursos.ped_regular, cursos.ped_extemporanea, cursos.ped_no_asistido

 	