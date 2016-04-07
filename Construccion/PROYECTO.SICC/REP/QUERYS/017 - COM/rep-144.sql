select gen_comis.val_i18n as comision,
	   subg.des_subg_vent,
	   reg.des_regi,
	   peri.val_nomb_peri as periodo,
	   cli_ger.val_nom1||' '||cli_ger.val_nom2||' '||cli_ger.val_ape1||' '||cli_ger.val_ape2 as ger_regi,
	   cli.cod_clie,
   	   cli.val_nom1||' '||cli.val_nom2||' '||cli.val_ape1||' '||cli.val_ape2 as cliente,
	   cpt.VAL_EJER_CUOT ||'-'|| cpt.ID_CUOTA as numero_factura,
	   cpt.FEC_FECH_DOCU as fecha_emision,
	   cpt.FEC_FECH_VALO as fecha_pago,
	   cpt.FEC_FECH_VALO - cpt.FEC_FECH_DOCU as dif_dias,
	   com_cli.IMP_MONT_PAGA as importe_comision,
	   cpt.NUM_IMPO_PAGO as neto_pagado
from com_comis_cobra_acumu_clien com_cli,
	 com_comis_cobra_acumu com_acu,
	 com_comis com,
 	 com_cuota_por_tramo_com_calcu cpt,
	 zon_sub_geren_venta subg,
	 zon_regio reg,
	 cra_perio peri,
	 cra_perio peri2,
	 mae_clien cli_ger,
	 mae_clien cli,
	 (
	  select gen.val_oid, gen.val_i18n
	  from v_gen_i18n_sicc gen
	  where gen.attr_enti = 'COM_COMIS'
	  		and gen.idio_oid_idio = 1  	 							-- parametro de idioma --
	 ) gen_comis,
	 (
	  select fec_inic, fec_fina
	  from cra_perio
	  where oid_peri = 57 --PARAMETRO PERIODO--
	 )per_par
where com_acu.oid_comi_cobr_acum = com_cli.coc2_oid_comi_cobr_acum
	 and com_acu.comi_oid_comi = com.oid_comi
	 and com_acu.clie_oid_clie = reg.clie_oid_clie
	 and cpt.actr_oid_comi_cobr_acum = com_cli.oid_comi_cobr_acum 
	 and reg.clie_oid_clie = cli_ger.oid_clie(+)
	 and reg.zsgv_oid_subg_vent = subg.oid_subg_vent
	 and reg.PERD_OID_PERI_INIC = peri.oid_peri
	 and reg.PERD_OID_PERI_FINA = peri2.oid_peri(+)
	 and gen_comis.val_oid(+) = com.oid_comi
	 and cpt.clie_oid_clie = cli.oid_clie
	 and reg.oid_regi in (1,2,3,4,5,6,7,8,9) 	  				  -- parametro de region --
	 and subg.oid_subg_vent in (1,2,3,4,5,6,7,8,9)				  -- parametro de subgerencia de ventas --
	 and subg.cana_oid_cana = 1	 			 					  -- parametro de canal --
	 and subg.marc_oid_marc = 1									  -- parametro de marca --
	 and subg.pais_oid_pais = 1									  -- parametro de pais --
	 and com.oid_comi = 1319	   	 			 				  -- parametro de comisiones --
	 and peri.fec_inic < per_par.fec_inic
	 and per_par.fec_fina < nvl(peri2.fec_fina,sysdate)