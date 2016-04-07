select gen_comis.val_i18n comision,
	   subg.DES_SUBG_VENT,
	   reg.DES_REGI,
	   per3.VAL_NOMB_PERI as per_comision,
	   cli.VAL_APE1||' '||cli.VAL_APE2||' '||cli.VAL_NOM1||' '||cli.VAL_NOM2 as gerente,
	   cli2.cod_clie,
	   cli2.VAL_APE1||' '||cli2.VAL_APE2||' '||cli2.VAL_NOM1||' '||cli2.VAL_NOM2 as cliente,
	   cpt.NUM_IMPO as monto_neto,
	   cpt.NUM_IMPO_PAGO as monto_recuperado,
	   cpt.NUM_IMPO_PAGO * 100 / cpt.NUM_IMPO as por_recuperado,
	   cpt.NUM_IMPO_PAGO * com_cli.VAL_PORC_COMI / 100 as monto_abonar,
	   cpt.VAL_EJER_CUOT||'-'||cpt.ID_CUOTA as numero_factura,
	   cpt.FEC_FECH_DOCU as fecha_factura,
	   cpt.FEC_FECH_VALO as fecha_pago
from zon_regio reg,
	 zon_sub_geren_venta subg,
	 cra_perio per,
	 cra_perio per2,
	 cra_perio per3,
	 mae_clien cli,
 	 mae_clien cli2,
	 com_comis_cobra_acumu_clien com_cli,
	 com_comis_cobra_acumu com_acu,
	 com_cuota_por_tramo_com_calcu cpt,
	 (
	  select fec_inic, fec_fina
	  from cra_perio
	  where oid_peri = 57 --PARAMETRO PERIODO--
	 )per_par,
	 (
	  select gen.val_oid, gen.val_i18n
	  from v_gen_i18n_sicc gen
	  where gen.attr_enti = 'COM_COMIS'
	  		and gen.idio_oid_idio = 1  	 							-- parametro de idioma --
	 ) gen_comis
where
	 reg.PERD_OID_PERI_INIC = per.oid_peri(+)
	 and reg.PERD_OID_PERI_FINA = per2.oid_peri(+)
	 and per.fec_inic < per_par.fec_inic 
	 and per_par.fec_fina < nvl(per2.fec_fina,sysdate)
	 and reg.ZSGV_OID_SUBG_VENT = subg.OID_SUBG_VENT
	 and reg.clie_oid_clie = cli.oid_clie(+)
	 and com_cli.COC2_OID_COMI_COBR_ACUM = com_acu.OID_COMI_COBR_ACUM
 	 and cpt.ACTR_OID_COMI_COBR_ACUM = com_cli.OID_COMI_COBR_ACUM
	 and com_acu.CLIE_OID_CLIE = cli.oid_clie
	 and com_acu.COMI_OID_COMI = gen_comis.val_oid(+)
	 and com_acu.PERD_OID_PERI = per3.oid_peri
	 and cpt.CLIE_OID_CLIE = cli2.oid_clie
	 and reg.OID_REGI in (2) --PARAMETRO REGION--
	 and subg.OID_SUBG_VENT in (1) --PARAMETRO SUBGERENCIA--
	 and per.MARC_OID_MARC = 1 --PARAMETRO MARCA--
	 and per.CANA_OID_CANA = 1 --PARAMETRO CANAL--
	 and com_acu.COMI_OID_COMI = 1319 --PARAMETRO COMISION--
	 and com_cli.VAL_NIVE_TRAM = '1' --PARAMETRO FECHA DE VENCIMIENTO (Nivel de tramo)--