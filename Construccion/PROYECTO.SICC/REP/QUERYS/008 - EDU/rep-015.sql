select
	   MARCA.DES_MARC,cli.oid_clie, 
	   cli.COD_CLIE,
	   cli.VAL_APE1||' '||cli.VAL_APE2||' '||cli.VAL_NOM1||' '||cli.VAL_NOM2 nombre_completo,
	   tipo_cli.COD_TIPO_CLIE,
	   stipo_cli.COD_SUBT_CLIE,
	   mat_cur.COD_CURS,
	   gen_curso.curso,
	   gen_tipo_curso.tipo_curso,
	   gen_plant.plantilla,
	   mat_cur.FEC_DISP_CURS,
	   mat_cur.FEC_LANZ,
	   mat_cur.FEC_FIN_CURS,
	   his_cur.FEC_ASIS,
	   mat_cur.IND_BLOQ_EXTE,
	   his_cur.IND_INVIT,
	   decode(his_cur.IND_ASIS,0,0,1) as total_final,
	   1 as totalcurso
from edu_histo_curso his_cur,
	 edu_matri_curso mat_cur,
	 edu_tipo_curso tipo_cur,
	 edu_plant_curso_cabec plant,
	 mae_clien cli,
	 mae_tipo_clien tipo_cli,
	 mae_subti_clien stipo_cli,
	 SEG_MARCA MARCA,
	 (
	 select gen.val_oid, gen.val_i18n curso
	 from v_gen_i18n_sicc gen
	 where gen.attr_enti = 'EDU_MATRI_CURSO'
	 	   and gen.idio_oid_idio = 1 						 				 --PARAMETRO--
	 )gen_curso,
	 (
	 select gen.val_oid, gen.val_i18n plantilla
	 from v_gen_i18n_sicc gen
	 where gen.attr_enti = 'EDU_PLANT_CURSO_CABEC'
	 	   and gen.idio_oid_idio = 1 			  							 --PARAMETRO--
	 )gen_plant,
	 (
	 select gen.val_oid, gen.val_i18n tipo_curso
	 from v_gen_i18n_sicc gen
	 where gen.attr_enti = 'EDU_TIPO_CURSO'
	 	   and gen.idio_oid_idio = 1 	   									 --PARAMETRO--
	 )gen_tipo_curso
where his_cur.CLIE_OID_CLIE = cli.OID_CLIE
	  and his_cur.SBTI_OID_SUBT_CLIE = stipo_cli.OID_SUBT_CLIE
	  and stipo_cli.TICL_OID_TIPO_CLIE = tipo_cli.OID_TIPO_CLIE
	  and his_cur.MCUR_OID_CURS = mat_cur.OID_CURS
	  and mat_cur.OID_CURS = gen_curso.val_oid(+)
	  and mat_cur.TICU_OID_TIPO_CURS = tipo_cur.OID_TIPO_CURS(+)
	  and mat_cur.CPLC_OID_CABE_PLAN_CURS = plant.OID_CABE
	  and plant.oid_cabe = gen_plant.val_oid(+)
	  and tipo_cur.OID_TIPO_CURS = gen_tipo_curso.val_oid(+)
	  AND MARCA.OID_MARC = mat_cur.MARC_OID_MARC
	  and mat_cur.PAIS_OID_PAIS = 1 										 --PARAMETRO--
/*	  and tipo_cli.OID_TIPO_CLIE = 1 										 --PARAMETRO--
	  and stipo_cli.OID_SUBT_CLIE = 1 										 --PARAMETRO--
	  and cli.COD_CLIE = '1' 		  											 --PARAMETRO--
*/	  and mat_cur.MARC_OID_MARC = 1 										 --PARAMETRO--
order by
	   MARCA.DES_MARC, 
	   cli.COD_CLIE,
	   cli.VAL_APE1||' '||cli.VAL_APE2||' '||cli.VAL_NOM1||' '||cli.VAL_NOM2,
	   tipo_cli.COD_TIPO_CLIE,
	   stipo_cli.COD_SUBT_CLIE,
	   mat_cur.COD_CURS,
	   gen_curso.curso,
	   gen_plant.plantilla  