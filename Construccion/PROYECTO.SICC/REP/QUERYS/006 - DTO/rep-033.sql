select distinct
	   gen_matri.val_i18n tipo_descu,
	   des.NUM_DESC, 
	   gen_descu.val_i18n descripcion, 
	   mar.COD_MARC, 
	   can.COD_CANA, 
	   acc.COD_ACCE, 
	   subac.COD_SBAC,
	   per.FEC_INIC, 
	   per2.FEC_FINA,
	   tclien.COD_TIPO_CLIE,
	   stclien.COD_SUBT_CLIE,
	   cli.COD_CLIE, 
	   decode(dto_clien.IMP_FIJO,null,dto_clien.VAL_PORC_DESC, dto_clien.IMP_FIJO) AS desc_por_clie,
	   subg.COD_SUBG_VENT, 
	   reg.COD_REGI, 
	   zon.COD_ZONA,
	   mar_prod.COD_MARC_PROD AS bc_marca, 
	   uneg.COD_UNID_NEGO AS bc_unid_neg, 
	   neg.COD_NEGO AS bc_neg, 
	   gen.COD_GENE AS bc_gen, 
	   sgen.COD_SUPE_GENE AS bc_supergen, 
	   prod.COD_SAP AS bc_cod_pro,
	   mar_prod2.COD_MARC_PROD AS ba_marca, 
	   uneg2.COD_UNID_NEGO AS ba_unid_neg, 
	   neg2.COD_NEGO AS ba_neg, 
	   sgen2.COD_SUPE_GENE AS ba_supergen, 
	   gen2.COD_GENE AS ba_gen, 
	   prod2.COD_SAP AS ba_cod_pro,
   	   esc.VAL_DESD AS ESCAL_VAL_DESD, 
	   esc.VAL_HAST AS ESCAL_VAL_HAST, 
	   esc.VAL_PORC_DESC,
	   des.IND_CULM, des.IND_MORO, 
	   des.IND_CTRL_DEVO, 
	   des.IND_CTRL_ANUL, 
	   des.IND_DESC_ACUMU, 
	   des.IND_AFEC_FACT, 
	   des.IND_AFEC_CC, 
	   des.IND_COMU_PART,
	   dto_clasi.VAL_PORC_ADIC AS VAL_PORC_ADIC_LIN_CARRERA,
	   decode(des.IND_NACI,1, 0, dto_adm.VAL_PORC_ADIC) VAL_PORC_ADIC_UADMIN,
	   tclasi.COD_TIPO_CLAS, 
	   clasi.COD_CLAS
from dto_descu des, 
	 dto_matri_descu mat,
	 dto_descu_acces dto_acc,
	 dto_descu_subac dto_subac,
	 dto_descu_tipo_clien  dto_tclien,
 	 dto_descu_subti_clien dto_stclien,
 	 dto_alcan_dto_clien dto_clien,
	 dto_alcan_dto_clasi_clien dto_clasi,
	 dto_alcan_dto_admin dto_adm,
	 dto_base_calcu_cabec dto_basec,
	 dto_base_calcu_detal dto_based, 
	 dto_base_aplic_cabec dto_baplic,
	 dto_base_aplic_detal dto_baplid, 
	 dto_escln esc,
	 seg_canal can, 
	 seg_marca mar,
 	 seg_acces acc,
	 seg_subac subac,
	 seg_marca_produ mar_prod,
 	 seg_marca_produ mar_prod2,
	 cra_perio per,
	 cra_perio per2,
	 mae_tipo_clien tclien,
	 mae_subti_clien stclien,
 	 mae_clasi clasi,
	 mae_tipo_clasi_clien tclasi,
	 mae_clien cli,
	 mae_gener gen,
 	 mae_gener gen2,
 	 mae_super_gener sgen,
 	 mae_super_gener sgen2,
	 mae_negoc neg,
 	 mae_negoc neg2,
	 mae_unida_negoc uneg,
 	 mae_unida_negoc uneg2,
	 mae_produ prod,
 	 mae_produ prod2,
	 zon_regio reg,
	 zon_sub_geren_venta subg,
	 zon_zona zon,
	 (
		 select geni18.VAL_OID, geni18.VAL_I18N
		 from v_gen_i18n_sicc geni18
		 where geni18.ATTR_ENTI='DTO_DESCU'
		 	   and geni18.IDIO_OID_IDIO=1                                                                --  PARAMETRO --                                                                --  PARAMETRO --
	 ) gen_descu,
	 ( 
		 select geni18.VAL_OID, geni18.VAL_I18N
		 from v_gen_i18n_sicc geni18
		 where geni18.ATTR_ENTI='DTO_MATRI_DESCU'
		 	   and geni18.IDIO_OID_IDIO=1                                                                --  PARAMETRO --
	 ) gen_matri
where 
	   	  des.MDES_OID_TIPO_DESC = mat.OID_TIPO_DESC
		  -- 				 
	  and des.CANA_OID_CANA = can.OID_CANA
	  and des.MARC_OID_MARC = mar.OID_MARC
	  and des.PERD_OID_PERI = per.OID_PERI
	  and des.PERD_OID_PERI_LIMI_FIN = per2.OID_PERI(+)
  	  and des.OID_DESC = dto_acc.DCTO_OID_DESC(+)
	  and des.oid_desc = dto_subac.DCTO_OID_DESC(+) 
	  and des.OID_DESC = dto_tclien.DCTO_OID_DESC(+)
	  and des.OID_DESC = dto_stclien.DCTO_OID_DESC(+)
	  --
	  and des.OID_DESC = dto_clien.DCTO_OID_DESC(+) 
	  and des.OID_DESC = dto_clasi.DCTO_OID_DESC(+)
	  and des.OID_DESC = dto_adm.DCTO_OID_DESC(+)
	  ---
	  and dto_tclien.TICL_OID_TIPO_CLIE = tclien.OID_TIPO_CLIE(+)
  	  and dto_stclien.SBTI_OID_SUBT_CLIE = stclien.OID_SUBT_CLIE(+)
	  --
	  and dto_acc.ACCE_OID_ACCE = acc.OID_ACCE(+)
	  and dto_subac.SBAC_OID_SBAC = subac.OID_SBAC(+)
	  --
	  and des.OID_DESC = dto_basec.DCTO_OID_DESC(+) 
	  and des.OID_DESC = dto_baplic.DCTO_OID_DESC(+) 
	  --
	  and dto_clasi.CLAS_OID_CLAS = clasi.oid_clas(+)
	  and clasi.TCCL_OID_TIPO_CLAS = tclasi.oid_tipo_clas(+)
	  and dto_clien.CLIE_OID_CLIE = cli.OID_CLIE(+)
	  -- 
	  and dto_adm.ZORG_OID_REGI = reg.OID_REGI(+)
	  and dto_adm.ZSGV_OID_SUBG_VENT = subg.OID_SUBG_VENT(+)
	  and dto_adm.ZZON_OID_ZONA = zon.OID_ZONA(+)
	  --
	  and dto_basec.OID_CABE = dto_based.BCCA_OID_CABE(+)
	  and dto_based.GENE_OID_GENE = gen.OID_GENE(+)
	  and dto_based.NEGO_OID_NEGO = neg.OID_NEGO(+)
	  and dto_based.MAPR_OID_MARC_PROD = mar_prod.OID_MARC_PROD(+)
	  and dto_based.SGEN_OID_SUPE_GENE = sgen.OID_SUPE_GENE(+)
	  and dto_based.UNEG_OID_UNID_NEGO = uneg.OID_UNID_NEGO(+)
	  and dto_based.PROD_OID_PROD = prod.OID_PROD(+)
	  --
	  and dto_baplic.OID_CABE = dto_baplid.BACA_OID_CABE(+)
	  and dto_baplid.GENE_OID_GENE = gen2.OID_GENE(+)
	  and dto_baplid.NEGO_OID_NEGO = neg2.OID_NEGO(+)
	  and dto_baplid.MAPR_OID_MARC_PROD = mar_prod2.OID_MARC_PROD(+)
	  and dto_baplid.SGEN_OID_SUPE_GENE = sgen2.OID_SUPE_GENE(+)
	  and dto_baplid.UNEG_OID_UNID_NEGO = uneg2.OID_UNID_NEGO(+)
  	  and dto_baplid.PROD_OID_PROD = prod2.OID_PROD(+)
	  --	  
	  and dto_baplic.OID_CABE = esc.OID_ESLN(+)
	  and des.OID_DESC = gen_descu.val_oid(+)
	  and mat.OID_TIPO_DESC = gen_matri.val_oid(+)
	  and des.PAIS_OID_PAIS = 1 			   			 	   	 		 --PARAMETRO--
	  and des.MDES_OID_TIPO_DESC in (1010,1011,1020) 					 --PARAMETRO--
	  and des.OID_DESC = 1211								 --PARAMETRO--
ORDER BY
	   gen_matri.val_i18n, des.NUM_DESC, gen_descu.val_i18n, mar.COD_MARC, can.COD_CANA, acc.COD_ACCE, subac.COD_SBAC,
	   per.FEC_INIC, per2.FEC_FINA,
	   tclien.COD_TIPO_CLIE, stclien.COD_SUBT_CLIE, cli.cod_clie, decode(dto_clien.IMP_FIJO,null,dto_clien.VAL_PORC_DESC, dto_clien.IMP_FIJO),
	   subg.COD_SUBG_VENT, reg.COD_REGI, zon.COD_ZONA,
	   mar_prod.COD_MARC_PROD, uneg.COD_UNID_NEGO, neg.COD_NEGO, gen.COD_GENE, sgen.COD_SUPE_GENE, prod.COD_SAP,
	   mar_prod2.COD_MARC_PROD, uneg2.COD_UNID_NEGO, neg2.COD_NEGO, sgen2.COD_SUPE_GENE, gen2.COD_GENE, prod2.COD_SAP,
   	   esc.VAL_DESD, esc.VAL_HAST, 
	   esc.VAL_PORC_DESC,	   
	   des.IND_CULM, des.IND_MORO, des.IND_CTRL_DEVO, des.IND_CTRL_ANUL, des.IND_DESC_ACUMU, des.IND_AFEC_FACT,	des.IND_AFEC_CC, des.IND_COMU_PART,
	   dto_clasi.VAL_PORC_ADIC, decode(des.IND_NACI,1, 0, dto_adm.VAL_PORC_ADIC),
  	   tclasi.COD_TIPO_CLAS, clasi.COD_CLAS
