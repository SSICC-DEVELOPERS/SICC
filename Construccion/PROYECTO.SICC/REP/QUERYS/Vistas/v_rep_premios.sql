CREATE OR REPLACE FORCE VIEW OWN_PERU.V_REP_PREMIOS
(PAGP_OID_PARA_GENE_PREM, OID_PARA_NIVE_PREM, OID_TIPO_PREM, TIPO_PREMIO, NUM_PREM, 
 CANTIDAD, OID_TIPO, DESCRIPCION, IDIO_TIPO_PREMIO)
AS 
select PAGP_OID_PARA_GENE_PREM, desc_premio.oid_para_nive_prem,  desc_premio.OID_TIPO_PREM, gen_pre.tipo_premio, desc_premio.num_prem, desc_premio.cantidad, desc_premio.oid_tipo, desc_premio.descripcion, desc_premio.idio_tipo_premio_n
from (
	   	select val_oid, val_i18n tipo_premio, idio_oid_idio as idio_tipo_premio
		from v_gen_i18n_sicc
		where attr_enti = 'INC_TIPO_PREMI'
	 )gen_pre,
	(
		(
		select niv_pre.PAGP_OID_PARA_GENE_PREM, niv_pre.OID_PARA_NIVE_PREM, tip_pre.OID_TIPO_PREM, lot_art.NUM_PREM, pre_art.NUM_UNID as cantidad, lot_art.OID_LOTE_PREM_ARTI as oid_tipo, lot_art.VAL_DESC_LOTE_PREM_ARTI as descripcion, null idio_tipo_premio_n
		from inc_param_nivel_premi niv_pre,
		  	   inc_tipo_premi tip_pre,
			   inc_premi_artic pre_art,
			   inc_lote_premi_artic lot_art
		where niv_pre.tpre_oid_tipo_prem = tip_pre.oid_tipo_prem
			  and niv_pre.oid_para_nive_prem = pre_art.panp_oid_para_nive_prem
			  and pre_art.oid_prem_arti = lot_art.prar_oid_prem_arti
			  and tip_pre.OID_TIPO_PREM = 2
		)
		union
		(
		select niv_pre.PAGP_OID_PARA_GENE_PREM, niv_pre.OID_PARA_NIVE_PREM, tip_pre.OID_TIPO_PREM, pre_des.NUM_PREM, pre_des.VAL_CANT_DESC, tip_des.oid_tipo_desc as oid_tipo, gen_des.descripcion, idio_tipo_premio
		from inc_param_nivel_premi niv_pre,
		  	   inc_tipo_premi tip_pre,
			   inc_premi_descu pre_des,
			   inc_tipo_descu tip_des,
			   (
			   	select val_oid, val_i18n as descripcion, idio_oid_idio as idio_tipo_premio
				from v_gen_i18n_sicc
				where attr_enti = 'INC_TIPO_DESCU'
			   )gen_des
		where niv_pre.tpre_oid_tipo_prem = tip_pre.oid_tipo_prem
			  and niv_pre.OID_PARA_NIVE_PREM = pre_des.OID_PARA_NIVE_PREM
			  and pre_des.tdsc_oid_tipo_desc = pre_des.oid_prem_desc
		  	  and tip_pre.OID_TIPO_PREM = 3
			  and tip_des.oid_tipo_desc = gen_des.val_oid(+)
		)
		union
		(
		select niv_pre.PAGP_OID_PARA_GENE_PREM, niv_pre.OID_PARA_NIVE_PREM, tip_pre.OID_TIPO_PREM, pre_pun.NUM_PREM,
			   case when tip_pre_pun.OID_TIPO_PREM_PUNT = 1 then pre_pun.VAL_CANT
					when tip_pre_pun.OID_TIPO_PREM_PUNT = 2 then pre_pun.VAL_PORC
					end as cantidad, tip_pre_pun.OID_TIPO_PREM_PUNT as oid_tipo, gen_pun.descripcion, gen_pun.idio_tipo_premio
		from inc_param_nivel_premi niv_pre,
		  	   inc_tipo_premi tip_pre,
			   inc_premi_punto pre_pun,
			   inc_tipo_premi_punto tip_pre_pun,
			   (
			   	select val_oid, val_i18n as descripcion, idio_oid_idio as idio_tipo_premio
				from v_gen_i18n_sicc
				where attr_enti = 'INC_TIPO_PRE_PUN'
			   )gen_pun
		where niv_pre.tpre_oid_tipo_prem = tip_pre.oid_tipo_prem
			  and niv_pre.OID_PARA_NIVE_PREM = pre_pun.PANP_OID_PARA_NIVE_PREM
			  and pre_pun.tppu_oid_tipo_prem_punt = tip_pre_pun.oid_tipo_prem_punt
			  and tip_pre.OID_TIPO_PREM = 4
			  and tip_pre_pun.OID_TIPO_PREM_PUNT = gen_pun.val_oid(+)
		)
		union
		(
		select niv_pre.PAGP_OID_PARA_GENE_PREM, niv_pre.OID_PARA_NIVE_PREM, tip_pre.OID_TIPO_PREM, pre_mon.NUM_PREM,
			   case when tip_pre_mon.OID_TIPO_PREM_MONE = 1 then pre_mon.VAL_CANT
					when tip_pre_mon.OID_TIPO_PREM_MONE = 2 then pre_mon.VAL_PORC
					end as cantidad, tip_pre_mon.OID_TIPO_PREM_MONE as oid_tipo,  gen_mon.descripcion, gen_mon.idio_tipo_premio  --FALTA VER CUAL ES CADA TIPO--
		from inc_param_nivel_premi niv_pre,
		  	   INC_TIPO_PREMI tip_pre,
			   inc_premi_monet pre_mon,
			   inc_tipo_premi_monet tip_pre_mon,
			   (
			   	select val_oid, val_i18n as descripcion, idio_oid_idio as idio_tipo_premio
				from v_gen_i18n_sicc
				where attr_enti = 'INC_TIPO_PRE_MONET'
			   )gen_mon
		where niv_pre.tpre_oid_tipo_prem = tip_pre.oid_tipo_prem
			  and niv_pre.OID_PARA_NIVE_PREM = pre_mon.PANP_OID_PARA_NIVE_PREM
			  and pre_mon.tpmo_oid_tipo_prem_mone = tip_pre_mon.oid_tipo_prem_mone
			  and tip_pre.OID_TIPO_PREM = 1
			  and tip_pre_mon.OID_TIPO_PREM_MONE = gen_mon.val_oid(+)
		)
	)desc_premio
where desc_premio.OID_TIPO_PREM = gen_pre.val_oid(+)
	  and desc_premio.idio_tipo_premio_n = gen_pre.idio_tipo_premio(+)