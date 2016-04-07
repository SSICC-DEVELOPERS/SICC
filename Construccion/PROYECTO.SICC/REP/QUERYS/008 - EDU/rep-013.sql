select 
	   mat_cur.CPLC_OID_CABE_PLAN_CURS cod_plantilla,
	   gen_plant.plantilla,
	   mat_cur.COD_CURS,
	   gen_tipo_cur.tipo_curso,
	   mat_cur.VAL_OBJE_CURS,
	   mat_cur.VAL_CONT_CURS,
	   gen_frecu.frecuencia,
	   mat_cur.FEC_DISP_CURS,
	   mat_cur.FEC_LANZ,
	   mat_cur.FEC_FIN_CURS,
	   (	  
		select periodos.VAL_NOMB_PERI
		from ( 
			 select per.FEC_INIC, per.FEC_FINA, per.VAL_NOMB_PERI, per.OID_PERI, per.PAIS_OID_PAIS,
			 		per.MARC_OID_MARC, per.CANA_OID_CANA
			 from cra_perio per
			 order by per.FEC_INIC asc
			 )periodos
		where mat_cur.FEC_DISP_CURS between periodos.FEC_INIC and periodos.FEC_FINA
			  and periodos.PAIS_OID_PAIS = mat_cur.PAIS_OID_PAIS
	 		  and periodos.MARC_OID_MARC = mat_cur.MARC_OID_MARC
	  		  and periodos.CANA_OID_CANA = mat_cur.CANA_OID_CANA
			  and rownum = 1
		)periodo_disponible,
	    (	  
		select periodos.VAL_NOMB_PERI
		from ( 
			 select per.FEC_INIC, per.FEC_FINA, per.VAL_NOMB_PERI, per.OID_PERI, per.PAIS_OID_PAIS,
			 		per.MARC_OID_MARC, per.CANA_OID_CANA
			 from cra_perio per
			 order by per.FEC_INIC asc
			 )periodos
		where mat_cur.FEC_LANZ between periodos.FEC_INIC and periodos.FEC_FINA
			  and periodos.PAIS_OID_PAIS = mat_cur.PAIS_OID_PAIS
	 		  and periodos.MARC_OID_MARC = mat_cur.MARC_OID_MARC
	  		  and periodos.CANA_OID_CANA = mat_cur.CANA_OID_CANA
			  and rownum = 1
		)periodo_lanzamiento,
		(	  
		select periodos.VAL_NOMB_PERI
		from ( 
			 select per.FEC_INIC, per.FEC_FINA, per.VAL_NOMB_PERI, per.OID_PERI, per.PAIS_OID_PAIS,
			 		per.MARC_OID_MARC, per.CANA_OID_CANA
			 from cra_perio per
			 order by per.FEC_INIC asc
			 )periodos
		where mat_cur.FEC_FIN_CURS between periodos.FEC_INIC and periodos.FEC_FINA
			  and periodos.PAIS_OID_PAIS = mat_cur.PAIS_OID_PAIS
	 		  and periodos.MARC_OID_MARC = mat_cur.MARC_OID_MARC
	  		  and periodos.CANA_OID_CANA = mat_cur.CANA_OID_CANA
			  and rownum = 1
		)periodo_fin,
		subg.COD_SUBG_VENT, subg.DES_SUBG_VENT,
		reg.COD_REGI, reg.DES_REGI,
		zon.COD_ZONA, zon.DES_ZONA,
		sec.COD_SECC, sec.DES_SECCI,
		ter.COD_TERR,
		mat_cur.NUM_PART,
		tipo_clien.COD_TIPO_CLIE,
		gen_clasi.nivel_capacitador,
		prod.COD_SAP,
		gen_prod.regalo,
		mat_cur.NUM_UNID,
		gen_mom.momento,
		mat_cur.IND_BLOQ_EXTE
from edu_matri_curso mat_cur,
	 edu_regal regal,
	 edu_regal_detal det_reg,
	 zon_terri ter,
	 zon_secci sec,
	 zon_sub_geren_venta subg,
	 zon_zona zon,
	 zon_regio reg,
	 mae_produ prod,
	 mae_tipo_clien tipo_clien,
	 cra_perio per,
 	 cra_perio per2,
 	 cra_perio per3,
 	 cra_perio per4,
	 (
	 select gen.val_oid, gen.val_i18n regalo
	 from v_gen_i18n_sicc gen
	 where gen.ATTR_ENTI = 'MAE_PRODU'
	 	   and gen.IDIO_OID_IDIO = 1  		   					 --PARAMETRO--
	 )gen_prod,
	 (
	 select gen.val_oid, gen.val_i18n momento
	 from v_gen_i18n_sicc gen
	 where gen.ATTR_ENTI = 'EDU_MOMEN_ENTRE'
	 	   and gen.IDIO_OID_IDIO = 1 		 					 --PARAMETRO--
	 )gen_mom,
	 (
	 select gen.val_oid, gen.val_i18n plantilla
	 from v_gen_i18n_sicc gen
	 where gen.ATTR_ENTI = 'EDU_PLANT_CURSO_CABEC'
	 	   and gen.IDIO_OID_IDIO = 1 			  				 --PARAMETRO--
	 )gen_plant,
	 (
	 select gen.val_oid, gen.val_i18n tipo_curso
	 from v_gen_i18n_sicc gen
	 where gen.ATTR_ENTI = 'EDU_TIPO_CURSO'
	 	   and gen.IDIO_OID_IDIO = 1 	   						 --PARAMETRO--
	 )gen_tipo_cur,
	 (
	 select gen.val_oid, gen.val_i18n frecuencia
	 from v_gen_i18n_sicc gen
	 where gen.ATTR_ENTI = 'EDU_FRECU_CURSO'
	 	   and gen.IDIO_OID_IDIO = 1 							 --PARAMETRO--
	 )gen_frecu,
 	 (
	 select gen.val_oid, gen.val_i18n nivel_capacitador
	 from v_gen_i18n_sicc gen
	 where gen.ATTR_ENTI = 'MAE_CLASI'
	 	   and gen.IDIO_OID_IDIO = 1  				   			 --PARAMETRO--
	 )gen_clasi
where mat_cur.TERR_OID_TERR = ter.OID_TERR(+)
	  and mat_cur.ZORG_OID_REGI = reg.OID_REGI(+)
	  and mat_cur.ZSCC_OID_SECC = sec.OID_SECC(+)
	  and mat_cur.ZSGV_OID_SUBG_VENT = subg.OID_SUBG_VENT(+)
	  and mat_cur.ZZON_OID_ZONA = zon.oid_zona(+)
	  and mat_cur.REGA_OID_REGA = regal.OID_REGA(+)
	  and regal.OID_REGA = det_reg.REGA_OID_REGA
	  and det_reg.prod_oid_prod = prod.oid_prod
	  and prod.OID_PROD = gen_prod.val_oid(+)
	  and mat_cur.MOME_OID_MOME_ENTR = gen_mom.val_oid(+)
	  and mat_cur.TICU_OID_TIPO_CURS = gen_tipo_cur.val_oid(+)
	  and mat_cur.FRCU_OID_FREC = gen_frecu.val_oid(+)
	  and mat_cur.CPLC_OID_CABE_PLAN_CURS = gen_plant.val_oid(+)
  	  and mat_cur.CLAS_OID_CLAS = gen_clasi.val_oid(+)
	  and mat_cur.TICL_OID_TIPO_CLIE = tipo_clien.OID_TIPO_CLIE(+)
	  and mat_cur.PERD_OID_PERI_INIC_CONS = per.OID_PERI(+)
	  and mat_cur.PERD_OID_PERI_FINA_CONS = per2.oid_peri(+)
	  and mat_cur.PERD_OID_PERI_INIC_COMP = per3.OID_PERI(+)
	  and mat_cur.PERD_OID_PERI_FINA_COMP = per4.OID_PERI(+)
-----------------------------------------------------------------------
--	  and mat_cur.PAIS_OID_PAIS = 1    				   				   --PARAMETRO--
--	  and mat_cur.TICU_OID_TIPO_CURS = 6 							   --PARAMETRO--
--	  and mat_cur.OID_CURS = 1 		   								   --PARAMETRO--
--	  and mat_cur.FEC_DISP_CURS = to_date('1/1/1', 'dd/MM/yyyy')	   --PARAMETRO--
--	  and mat_cur.FEC_LANZ = to_date('1/1/1', 'dd/MM/yyyy')			   --PARAMETRO--
--	  and mat_cur.FEC_FIN_CURS = to_date('1/1/1', 'dd/MM/yyyy')		   --PARAMETRO--