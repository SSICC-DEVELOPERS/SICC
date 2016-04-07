select 
	   gen_can.canal,
	   mar.DES_MARC,
	   gen_pais.pais,
	   per.VAL_NOMB_PERI,
  	   TER.COD_TERR,
	   cli.COD_CLIE,
	   pos.VAL_CODI_VENT, 
	   pos.NUM_UNID_DEMA,
	   prod.COD_SAP, 
	   t_ofer.COD_TIPO_OFER,
	   ofer.NUM_GRUP,
	   pos.VAL_PREC_CATA_UNIT_LOCA,
	   t_ofer.IND_COMI
from ped_solic_cabec sol,
	 ped_solic_posic pos,
	 ped_estad_posic est_pos,
	 mae_produ prod,
	 pre_ofert_detal of_det,
	 pre_tipo_ofert t_ofer,
	 pre_ofert ofer,
	 pre_grupo_ofert g_ofer,
	 mae_clien cli,
	 cra_perio per,
	 zon_zona zon,
	 zon_terri ter,
	 seg_marca mar,
	 seg_subac subac,
 	 (
	 select gen.val_oid, gen.val_i18n pais
	 from v_gen_i18n_sicc gen
	 where gen.ATTR_ENTI = 'SEG_PAIS'
	 	   and gen.idio_oid_idio = 1 --PARAMETRO--
	 )gen_pais,
  	 (
	 select gen.val_oid, gen.val_i18n canal
	 from v_gen_i18n_sicc gen
	 where gen.ATTR_ENTI = 'SEG_CANAL'
	 	   and gen.idio_oid_idio = 1 --PARAMETRO--
	 )gen_can
where sol.IND_OC = 1 --ACTIVO--
	  and sol.IND_PEDI_PRUE <> 1 --DESACTIVADO--  
	  and sol.IND_TS_NO_CONSO = 1 --ACTIVO--
	  and sol.FEC_FACT is not null
	  and sol.OID_SOLI_CABE = pos.SOCA_OID_SOLI_CABE
	  and pos.PROD_OID_PROD = prod.OID_PROD
	  and pos.OFDE_OID_DETA_OFER = of_det.oid_deta_ofer(+)
	  and of_det.TOFE_OID_TIPO_OFER = t_ofer.OID_TIPO_OFER
	  and sol.CLIE_OID_CLIE = cli.OID_CLIE
	  and of_det.GOFE_OID_GRUP_OFER = g_ofer.OID_GRUP_OFER(+)
	  and sol.PERD_OID_PERI = per.OID_PERI
	  and pos.NUM_UNID_DEMA > 20
	  and pos.ESPO_OID_ESTA_POSI = est_pos.OID_ESTA_POSI(+)
	  and est_pos.COD_ESTA_POSI <> 'AN'
	  and pos.VAL_CODI_VENT is not null
	  and sol.ZZON_OID_ZONA = zon.OID_ZONA
	  and sol.pais_oid_pais = gen_pais.val_oid(+)
	  and zon.CANA_OID_CANA = gen_can.val_oid(+)
	  and sol.TERR_OID_TERR = ter.OID_TERR
	  and zon.marc_oid_marc = mar.oid_marc
	  and sol.SBAC_OID_SBAC = subac.OID_SBAC
	  and of_det.OFER_OID_OFER = ofer.OID_OFER
	  and subac.ACCE_OID_ACCE in (1) --PARAMETRO-- 
  	  and sol.PAIS_OID_PAIS = 1 --PARAMETRO--
	  and sol.PERD_OID_PERI in (57)--PARAMETRO--
	  and sol.ZZON_OID_ZONA in (1) --PARAMETRO--
	  and zon.ZORG_OID_REGI in (1) --PARAMETRO--
	  and zon.MARC_OID_MARC = 1 --PARAMETRO--
	  and zon.CANA_OID_CANA = 1 --PARAMETRO--
order by cod_clie, val_codi_vent, prod.COD_SAP 
