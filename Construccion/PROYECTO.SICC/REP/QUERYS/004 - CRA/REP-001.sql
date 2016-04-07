select fec_perio_f.VAL_NOMB_PERI,  
cro1.fec_inic as inicio_fact,
cro2.fec_fina as final_fact,
cro3.fec_inic+1 as inicio_venta,
cro4.fec_fina-1 as final_venta, gen_pais.val_i18n
from
	(
 	 select per.PERI_OID_PERI as periodocorporativo, per.OID_PERI as periodo_fact, per.VAL_NOMB_PERI, per.PAIS_OID_PAIS,  
		 (select crono.OID_CRON  from (select * from cra_crono, cra_activ act, cra_clase_activ cla_act
								 where cra_crono.CACT_OID_ACTI=act.OID_ACTI
								 	   and act.CLAC_OID_CLAS_ACTI = cla_act.OID_CLAS_ACTI
									   and cla_act.COD_CLAS_ACTI = 'FAC'
									   and cra_crono.FEC_INIC>to_date('1/1/2003','dd/MM/yyyy')   	  -- PARAMETRO --
									   and cra_crono.fec_fina< to_date('31/12/2015','dd/MM/yyyy')	  -- PARAMETRO --
		 						 order by cra_crono.FEC_INIC asc)crono
		 where crono.PERD_OID_PERI=per.OID_PERI
		 and rownum=1) AS oid_crono_min_f,
		 (select crono.OID_CRON  from (select * from cra_crono, cra_activ act, cra_clase_activ cla_act
								 where cra_crono.CACT_OID_ACTI=act.OID_ACTI
								 	   and act.CLAC_OID_CLAS_ACTI = cla_act.OID_CLAS_ACTI
									   and cla_act.COD_CLAS_ACTI = 'FAC'
									   and cra_crono.FEC_INIC>to_date('1/1/2003','dd/MM/yyyy')    -- PARAMETRO --
									   and cra_crono.fec_fina< to_date('31/12/2015','dd/MM/yyyy') -- PARAMETRO --
		  						 order by cra_crono.FEC_fina desc)crono
		 where crono.PERD_OID_PERI=per.OID_PERI
		 and rownum=1) AS oid_crono_max_f
	 from cra_perio per, seg_perio_corpo cor
	 where 
		   	 per.peri_oid_peri=cor.oid_peri
		 and per.PAIS_OID_PAIS IN (1)               				 -- PARAMETRO --
		 and per.MARC_OID_MARC=1            				 -- PARAMETRO --
		 and per.CANA_OID_CANA=1            				 -- PARAMETRO --
--		 and cor.val_anio=2005 								 -- PARAMETRO --
--		 and per.OID_PERI in (1)            			 -- PARAMETRO --
	)fec_perio_f,
	(
	select per.PERI_OID_PERI as periodocorporativo_v, per.OID_PERI as periodo_venta,    
		 (
		 select crono.OID_CRON  from (select * from cra_crono, cra_activ act, cra_clase_activ cla_act
								 where cra_crono.CACT_OID_ACTI=act.OID_ACTI
								 	   and act.CLAC_OID_CLAS_ACTI = cla_act.OID_CLAS_ACTI
									   and cla_act.COD_CLAS_ACTI = 'CVT'
								 	   and cra_crono.FEC_INIC>to_date('1/1/2003','dd/MM/yyyy')     	-- PARAMETRO --
								 	   and cra_crono.fec_fina< to_date('31/12/2015','dd/MM/yyyy')  	-- PARAMETRO --
		 						 order by cra_crono.FEC_INIC asc)crono
		 where crono.PERD_OID_PERI=per.OID_PERI
		 	   and rownum=1
		 ) oid_crono_min_v,
		 (
		 select crono.OID_CRON  from (select * from cra_crono, cra_activ act, cra_clase_activ cla_act
								 where cra_crono.CACT_OID_ACTI=act.OID_ACTI
								 	   and act.CLAC_OID_CLAS_ACTI = cla_act.OID_CLAS_ACTI
									   and cla_act.COD_CLAS_ACTI = 'CVT'
									   and cra_crono.FEC_INIC>to_date('1/1/2003','dd/MM/yyyy')     	-- PARAMETRO --
								 	   and cra_crono.fec_fina< to_date('31/12/2015','dd/MM/yyyy')  	-- PARAMETRO --
		  						 order by cra_crono.FEC_fina desc)crono
		 where crono.PERD_OID_PERI=per.OID_PERI
		 	   and rownum=1
		 ) oid_crono_max_v
		 from cra_perio per
	)fec_perio_v,
	cra_crono cro1, 
	cra_crono cro2,
	cra_crono cro3, 
	cra_crono cro4,
	(
	select gen.VAL_OID, gen.VAL_I18N 
	from v_gen_i18n_sicc gen
	where gen.ATTR_ENTI='SEG_PAIS'
		  and gen.IDIO_OID_IDIO=1			-- PARAMETRO --
	)gen_pais
where 
		fec_perio_f.periodo_fact=fec_perio_v.periodo_venta
	and fec_perio_f.oid_crono_min_f=cro1.oid_cron(+)
	and fec_perio_f.oid_crono_max_f=cro2.oid_cron(+)
	and fec_perio_v.oid_crono_min_v=cro3.oid_cron(+)
	and fec_perio_v.oid_crono_max_v=cro4.oid_cron(+)
	and fec_perio_f.pais_oid_pais=gen_pais.val_oid(+)
group by fec_perio_f.VAL_NOMB_PERI,  
	cro1.fec_inic ,
	cro2.fec_fina ,
	cro3.fec_inic+1 ,
	cro4.fec_fina-1,
	gen_pais.val_i18n
order by fec_perio_f.VAL_NOMB_PERI,  
	cro1.fec_inic ,
	cro2.fec_fina ,
	cro3.fec_inic+1 ,
	cro4.fec_fina-1