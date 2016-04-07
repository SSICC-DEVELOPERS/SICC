select  	   mar.DES_MARC, 	   gen_can.canal, 	   op.COD_OPER, 	   per.val_nomb_peri, 	   per2.val_nomb_peri as periodo_referencia, 	   cli.COD_CLIE, 	   zon.cod_zona, 	   zon.DES_ZONA, 	   cab_rec.NUM_ATEN n_doc, 	   pro.COD_SAP cod_prod, 	   pod.VAL_CODI_VENT cod_venta, 	   GEN_PRODU.VAL_I18N DESC_PRODU,        sum( nvl(lin_rec.NUM_UNID_RECL,0) - nvl(lin_rec.NUM_UNID_DEVU,0) )  as cantidad, 	   sum( (nvl(lin_rec.NUM_UNID_RECL,0) - nvl(lin_rec.NUM_UNID_DEVU,0)) * nvl(lin_rec.VAL_PREC,0) ) as monto	   	    from 	rec_cabec_recla cab_rec, 	rec_opera_recla op_rec, 	rec_tipos_opera t_op, 	rec_opera op, 	rec_linea_opera_recla lin_rec, 	cra_perio per, 	cra_perio per2, 	mae_clien cli, 	seg_marca mar, 	mae_produ pro, 	pre_matri_factu pmf, 	pre_ofert_detal pod, 	( 	SELECT GEN.VAL_OID, GEN.VAL_I18N 	FROM V_GEN_I18N_SICC GEN 	WHERE GEN.ATTR_ENTI = 'MAE_PRODU' 		  AND GEN.IDIO_OID_IDIO =  1  	) GEN_PRODU, 	( 	 select val_oid, val_i18n canal 	 from v_gen_i18n_sicc 	 where attr_enti = 'SEG_CANAL' 	 	   and idio_oid_idio =  1  	)gen_can, 	zon_terri_admin ter_adm, 	zon_secci sec, 	zon_zona zon, 	( 	 select fec_inic 	 from cra_perio  	 where oid_peri =   1379 		 	)per_inic, 	( 	 select fec_fina 	 from cra_perio 	 where oid_peri =  DECODE( -1 , -1,  1379 ,  -1 ) 	 )per_fina where 	 cab_rec.OID_CABE_RECL = op_rec.CARE_OID_CABE_RECL 	 and op_rec.TIOP_OID_TIPO_OPER = t_op.OID_TIPO_OPER 	 and t_op.ROPE_OID_OPER = op.OID_OPER 	 and op_rec.OID_OPER_RECL = lin_rec.OPRE_OID_OPER_RECL 	  and op.IND_ANUL = 0		   	 and op_rec.PERD_OID_PERI_RECL = per.oid_peri 	 and cab_rec.PERD_OID_PERI_DOCU_REFE = per2.oid_peri 	 and cab_rec.clie_oid_clie = cli.oid_clie 	 and per.marc_oid_marc = mar.OID_MARC 	 and per.cana_oid_cana = gen_can.val_oid(+) 	 and lin_rec.prod_oid_prod = pro.oid_prod 	 and lin_rec.MAFA_OID_MATR_FACT = pmf.OID_MATR_FACT 	 and pmf.OFDE_OID_DETA_OFER = pod.OID_DETA_OFER 	 AND PRO.OID_PROD = GEN_PRODU.VAL_OID(+)    and per.marc_oid_marc =  1  	and per.cana_oid_cana =  1  	 and cab_rec.pais_oid_pais =  1   and per_inic.fec_inic  < = per.fec_inic 	 and per.fec_fina  < = per_fina.fec_fina 	 and cab_rec.ZTAD_OID_TERR_ADMI = ter_adm.OID_TERR_ADMI 	 and ter_adm.ZSCC_OID_SECC = sec.OID_SECC 	 and sec.ZZON_OID_ZONA = zon.oid_zona 	 and lin_rec.NUM_UNID_RECL  < > lin_rec.NUM_UNID_DEVU group by   	   mar.DES_MARC, 	   gen_can.canal, 	  op.COD_OPER, 	  cli.COD_CLIE, 	  per.val_nomb_peri, 	  zon.cod_zona, 	  zon.DES_ZONA, 	  cab_rec.NUM_ATEN, 	  per2.val_nomb_peri, 	  	   pro.COD_SAP, 	   pod.VAL_CODI_VENT,    	   GEN_PRODU.VAL_I18N, 	   	   cab_rec.NUM_ATEN   order by mar.DES_MARC, 	   gen_can.canal, 	   op.COD_OPER, 	   zon.DES_ZONA, 	   cab_rec.NUM_ATEN	 		 