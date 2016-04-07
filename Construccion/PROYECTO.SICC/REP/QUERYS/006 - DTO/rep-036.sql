select 
	   gen_matri.val_i18n tipo_descu, mar.COD_MARC, can.COD_CANA, acc.COD_ACCE, subac.COD_SBAC,
	   per.FEC_INIC, per2.fec_fina,
	   tipo_cli.COD_TIPO_CLIE, subti_cli.COD_SUBT_CLIE, cli.COD_CLIE,
	   decode(param_desc.IND_MODI,1,dto_cli.VAL_PORC_DESC,null) desc_por_cliente,
	   decode(des.IND_NACI,1,'NACIONAL','NO NACIONAL') AS alcan_admi,
	   decode(param_c_marcas.IND_MODI,1,'1','0')b_c_marca1,
	   decode(param_c_un_neg.IND_MODI,1,'1','0')b_c_un_negocio,
	   decode(param_c_neg.IND_MODI,1,'1','0')b_c_negocio, 
	   decode(param_c_sup_gen.IND_MODI,1,'1','0')b_c_1up_generico, 
	   decode(param_c_gen.IND_MODI,1,'1','0')b_c_generico, 
	   decode(param_c_prod.IND_MODI,1,'1','0')b_c_productos,  
	   decode(param_a_marcas.IND_MODI,1,'1','0')b_a_marcas, 
	   decode(param_a_un_neg.IND_MODI,1,'1','0')b_a_un_negocio,
	   decode(param_a_neg.IND_MODI,1,'1','0')b_a_negocio, 
	   decode(param_a_sup_gen.IND_MODI,1,'1','0')b_a_sup_generico, 
	   decode(param_a_gen.IND_MODI,1,'1','0')b_a_generico, 
	   decode(param_a_prod.IND_MODI,1,'1','0')b_a_productos,
	   des.IND_CULM, des.IND_MORO, des.IND_CTRL_DEVO, des.IND_CTRL_ANUL, des.IND_DESC_ACUMU, des.IND_AFEC_FACT, des.IND_AFEC_CC, des.IND_COMU_PART,
	   dto_cla_clien.VAL_PORC_ADIC ad_linea_carrera 
from dto_matri_descu mat,
	 dto_descu des,
	 dto_descu_acces dto_acc,
	 dto_descu_subac dto_subac,
	 dto_alcan_dto_clien dto_cli,
	 dto_alcan_dto_clasi_clien dto_cla_clien,
	 dto_param_tipo_descu param_c_marcas,
	 dto_param_tipo_descu param_c_un_neg,
	 dto_param_tipo_descu param_c_neg,
	 dto_param_tipo_descu param_c_sup_gen,
	 dto_param_tipo_descu param_c_gen,
	 dto_param_tipo_descu param_c_prod,
	 dto_param_tipo_descu param_a_marcas,
	 dto_param_tipo_descu param_a_un_neg,
	 dto_param_tipo_descu param_a_neg,
	 dto_param_tipo_descu param_a_sup_gen,
	 dto_param_tipo_descu param_a_gen,
	 dto_param_tipo_descu param_a_prod,
	 dto_param_tipo_descu param_desc,
	 mae_clien cli,
	 mae_clien_tipo_subti tipo_subti,
	 mae_tipo_clien tipo_cli,
	 mae_subti_clien subti_cli,
	 seg_marca mar,
	 seg_canal can,
	 seg_acces acc,
	 seg_subac subac,
	 cra_perio per,
	 cra_perio per2,
	 (
	 select gen.val_oid, gen.val_i18n
	 from v_gen_i18n_sicc gen
	 where gen.ATTR_ENTI= 'DTO_MATRI_DESCU'
	 and gen.IDIO_OID_IDIO=1 			   	 		  					 --PARAMETRO--
	 )gen_matri
where des.MDES_OID_TIPO_DESC = mat.OID_TIPO_DESC(+)
	  and mat.OID_TIPO_DESC= gen_matri.val_oid(+)
	  and des.PERD_OID_PERI = per.OID_PERI
	  and des.PERD_OID_PERI_LIMI_FIN = per2.OID_PERI(+)
	  and des.MARC_OID_MARC = mar.OID_MARC
	  and des.CANA_OID_CANA = can.OID_CANA
	  and dto_acc.DCTO_OID_DESC = des.OID_DESC 
	  and dto_acc.ACCE_OID_ACCE = acc.OID_ACCE
	  and dto_subac.DCTO_OID_DESC = des.OID_DESC
	  and dto_subac.SBAC_OID_SBAC = subac.OID_SBAC
	  and dto_cli.DCTO_OID_DESC(+) = des.OID_DESC
	  and dto_cli.CLIE_OID_CLIE = cli.OID_CLIE(+)
	  and cli.OID_CLIE = tipo_subti.CLIE_OID_CLIE(+)
	  and tipo_cli.OID_TIPO_CLIE(+) = tipo_subti.ticl_oid_tipo_clie
	  and subti_cli.OID_SUBT_CLIE(+) = tipo_subti.SBTI_OID_SUBT_CLIE
	  and dto_cla_clien.DCTO_OID_DESC(+) = des.OID_DESC
	  and mat.OID_TIPO_DESC = param_c_marcas.MDES_OID_TIPO_DESC
	  and param_c_marcas.PADT_OID_PARA = 14
	  and mat.OID_TIPO_DESC = param_c_un_neg.MDES_OID_TIPO_DESC
	  and param_c_un_neg.PADT_OID_PARA = 15
	  and mat.OID_TIPO_DESC = param_c_neg.MDES_OID_TIPO_DESC
	  and param_c_neg.PADT_OID_PARA = 16
	  and mat.OID_TIPO_DESC = param_c_sup_gen.MDES_OID_TIPO_DESC
	  and param_c_sup_gen.PADT_OID_PARA = 17
	  and mat.OID_TIPO_DESC = param_c_gen.MDES_OID_TIPO_DESC
	  and param_c_gen.PADT_OID_PARA = 18
	  and mat.OID_TIPO_DESC = param_c_prod.MDES_OID_TIPO_DESC
	  and param_c_prod.PADT_OID_PARA = 19
	  and mat.OID_TIPO_DESC = param_a_marcas.MDES_OID_TIPO_DESC
	  and param_a_marcas.PADT_OID_PARA = 20
	  and mat.OID_TIPO_DESC = param_a_un_neg.MDES_OID_TIPO_DESC
	  and param_a_un_neg.PADT_OID_PARA = 21
	  and mat.OID_TIPO_DESC = param_a_neg.MDES_OID_TIPO_DESC
	  and param_a_neg.PADT_OID_PARA = 22
	  and mat.OID_TIPO_DESC = param_a_sup_gen.MDES_OID_TIPO_DESC
	  and param_a_sup_gen.PADT_OID_PARA = 23
	  and mat.OID_TIPO_DESC = param_a_gen.MDES_OID_TIPO_DESC
	  and param_a_gen.PADT_OID_PARA = 24
	  and mat.OID_TIPO_DESC = param_a_prod.MDES_OID_TIPO_DESC
	  and param_a_prod.PADT_OID_PARA = 25
	  and mat.OID_TIPO_DESC = param_desc.MDES_OID_TIPO_DESC
	  and param_desc.PADT_OID_PARA = 11
  	  and des.pais_oid_pais = 1 --PARAMETRO--


	  