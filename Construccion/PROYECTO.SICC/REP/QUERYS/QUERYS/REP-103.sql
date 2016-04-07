  		 select  	   val_codi_vent, 	   descripcion, 	   unidad_negocio, 	  	 		( 		 select op.COD_OPER 		from rec_opera op 		where op.OID_OPER =  1 	  	  		) cod_operacion_1, 		( 		 select val_i18n 		 from v_gen_i18n_sicc 		 where attr_enti = 'REC_OPERA' 		 		 and val_oid =  1 	  	 		 		 and idio_oid_idio =  1 	  	 		)desc_operacion_1, 		 		  ( 		 select op.COD_OPER 		from rec_opera op 		where op.OID_OPER =  -1 	  	 		) cod_operacion_2, 		( 		 select val_i18n 		 from v_gen_i18n_sicc 		 where attr_enti = 'REC_OPERA' 		 		 and val_oid =   -1 	  	 		 		 and idio_oid_idio =  1 	  	 		)desc_operacion_2, 		 		( 		 select op.COD_OPER 		from rec_opera op 		where op.OID_OPER =   -1 	  	 		) cod_operacion_3, 		( 		 select val_i18n 		 from v_gen_i18n_sicc 		 where attr_enti = 'REC_OPERA' 		 		 and val_oid =   -1 	  	 		 		 and idio_oid_idio =   1 	  	 		)desc_operacion_3, 		 		( 		 select op.COD_OPER 		from rec_opera op 		where op.OID_OPER =  -1 	   		) cod_operacion_4, 		( 		 select val_i18n 		 from v_gen_i18n_sicc 		 where attr_enti = 'REC_OPERA' 		 		 and val_oid =  -1 	   		 		 and idio_oid_idio =   1 	  	 		)desc_operacion_4, 		 		unidades_facturadas, 		unidades_1, 		unidades_2, 		unidades_3, 		unidades_4, 		suma_unidades from  ( 	select 		  val_codi_vent, 		  descripcion, 		  unidad_negocio, 	  	  sum(NUM_UNID_ATEN)unidades_facturadas, 		  sum(operacion_1)as unidades_1, 		  sum(operacion_2)as unidades_2, 		  sum(operacion_3)as unidades_3, 		  sum(operacion_4)as unidades_4, 		  nvl(sum(operacion_1),0) + nvl(sum(operacion_2),0) + nvl(sum(operacion_3),0) + nvl(sum(operacion_4),0) suma_unidades 	from 		( 		select  			   gen_prod.descripcion, 			   of_det.val_codi_vent, 			   gen_un_neg.unidad_negocio, 			   fac_lin.NUM_UNID_ATEN, 			   decode(t_op.ROPE_OID_OPER, 1 ,lin_rec.NUM_UNID_RECL,0)operacion_1, 			   decode(t_op.ROPE_OID_OPER, -1 ,lin_rec.NUM_UNID_RECL,0)operacion_2, 			   decode(t_op.ROPE_OID_OPER, -1 ,lin_rec.NUM_UNID_RECL,0)operacion_3, 			   decode(t_op.ROPE_OID_OPER, -1 ,lin_rec.NUM_UNID_RECL,0)operacion_4 			from rec_cabec_recla cab_rec, 				 rec_opera_recla op_rec, 				 rec_linea_opera_recla lin_rec, 				 rec_tipos_opera t_op, 				 fac_docum_conta_cabec fac, 				 fac_docum_conta_linea fac_lin, 				 mae_produ prod, 				 ped_solic_posic pos, 				 ped_solic_cabec sol, 				 ped_tipo_solic_pais t_sol_p, 				 ped_tipo_solic t_sol, 				 pre_ofert_detal of_det, 				 cra_perio per, 				 ( 				  select oid_peri, fec_inic, fec_fina 				  from cra_perio 				  where oid_peri =   1379 	  	 				 )per_ini,  				 ( 				  select oid_peri, fec_inic, fec_fina 				  from cra_perio 				  where oid_peri =   71 	  	 				 )per_fin, 				 ( 				  select val_oid, val_i18n descripcion 				  from v_gen_i18n_sicc 				  where attr_enti = 'MAE_PRODU' 				  		and idio_oid_idio =  1 	   				 )gen_prod, 				 ( 				  select val_oid, val_i18n unidad_negocio 				  from v_gen_i18n_sicc 				  where attr_enti = 'MAE_UNIDA_NEGOC' 				  		and idio_oid_idio =  1 	   				 )gen_un_neg			  			where 				 cab_rec.OID_CABE_RECL = op_rec.CARE_OID_CABE_RECL 				 and op_rec.OID_OPER_RECL = lin_rec.OPRE_OID_OPER_RECL 				 and op_rec.TIOP_OID_TIPO_OPER = t_op.OID_TIPO_OPER 				 and lin_rec.PROD_OID_PROD = prod.OID_PROD 				 and prod.OID_PROD = gen_prod.val_oid(+) 				 and prod.UNEG_OID_UNID_NEGO = gen_un_neg.val_oid(+) 				 and sol.oid_soli_cabe = pos.soca_oid_soli_cabe 				 and fac.SOCA_OID_SOLI_CABE(+) = cab_rec.soca_oid_soli_cabe 				 and fac.OID_CABE = fac_lin.DCCA_OID_CABE(+) 				 and cab_rec.soca_oid_soli_cabe = sol.soca_oid_soli_cabe 				 and sol.TSPA_OID_TIPO_SOLI_PAIS = t_sol_p.oid_tipo_soli_pais 				 and t_sol_p.TSOL_OID_TIPO_SOLI = t_sol.oid_tipo_soli 				 and pos.OFDE_OID_DETA_OFER = of_det.OID_DETA_OFER 				 and cab_rec.PERD_OID_PERI_RECL = per.oid_peri 				 and per_ini.fec_inic  < = per.fec_inic 				 and per.fec_fina  < = per_fin.fec_fina 	       and per.marc_oid_marc =  1   	         and per.cana_oid_cana =  1   				 and cab_rec.pais_oid_pais =  1 	   				 AND T_OP.ROPE_OID_OPER IN ( 1 , -1 , -1 , -1 ) 	 and prod.UNEG_OID_UNID_NEGO in  ( 1 )   	 	 and of_det.OCAT_OID_CATAL in ( 1 )    	  and t_sol.acce_oid_acce in ( 1 )    		) 	group by 		  unidad_negocio, 		  val_codi_vent, 		  descripcion 	order by suma_unidades DESC ) where rownum  < =  5 	  	 		