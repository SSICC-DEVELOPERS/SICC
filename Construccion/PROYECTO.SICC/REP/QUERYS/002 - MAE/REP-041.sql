select  
	codigo, nombre, docu.documento ,tel, direccion, fecha_ingreso, 
	(
	 SELECT SUM(m.IMP_PEND) as suma 
	 FROM CCC_MOVIM_CUENT_CORRI m 
	 WHERE m.CLIE_OID_CLIE = datos.idcliente
 	 	   AND M.ZSGV_OID_SUBG_VENT = subg.oid_subg_vent
	 	   AND M.ZORG_OID_REGI = reg.OID_REGI
		   AND M.ZSCC_OID_SECC = sec.OID_SECC
	) as saldo 
from 
	(
	select  
		cli.OID_CLIE as idcliente,cli.COD_CLIE codigo, cli.VAL_APE1 ||' '||cli.VAL_APE2||' '||cli.VAL_NOM1||' '||cli.VAL_NOM2 as nombre,
		tipo_via.t_v||' '|| dir.VAL_NOMB_VIA ||'   '|| dir.NUM_PPAL as direccion, cli.FEC_INGR as fecha_ingreso 
	From mae_clien_ident id,  
		mae_clien_direc dir, 
		mae_clien cli,
		(
		 select via.OID_TIPO_VIA, gen.VAL_I18N as t_v 
		 from seg_tipo_via via, 
		 	  v_gen_i18n_sicc gen 
		 where gen.ATTR_ENTI='SEG_TIPO_VIA'
 			   and gen.VAL_OID=via.oid_tipo_via
			   and gen.IDIO_OID_IDIO=1 --value
		) tipo_via
	where cli.OID_CLIE=id.CLIE_OID_CLIE(+)
		and cli.OID_CLIE=dir.CLIE_OID_CLIE(+)
		and dir.TIVI_OID_TIPO_VIA= tipo_via.oid_tipo_via(+)
		and dir.TIDC_OID_TIPO_DIRE(+)=1
		and cli.PAIS_OID_PAIS in (1)   					   --value
		and cli.VAL_APE1 like '%a%' 					   --value--
		and cli.VAL_APE2 like '%a%' 					   --value--
		and cli.VAL_NOM1 like '%a%' 					   --value--
		and cli.VAL_NOM2 like '%a%' 					   --value--
		and cli.COD_CLIE = '018'					   --value--
		and id.VAL_IDEN_DOCU_PRIN =1 
	) datos,
	(
	 select  com.CLIE_OID_CLIE as oidcli, com.VAL_TEXT_COMU as tel  
	 from mae_clien_comun com, mae_tipo_comun tcom
	 where com.TICM_OID_TIPO_COMU=tcom.OID_TIPO_COMU
	 and tcom.COD_TIPO_COMU='TF'
	) tel,
	(
	 select id.CLIE_OID_CLIE as IDCLI, id.NUM_DOCU_IDEN AS DOCUMENTO from mae_clien_ident id where id.VAL_IDEN_DOCU_PRIN=1
	)docu,
	mae_clien_unida_admin un_adm,
	zon_zona zon,
	zon_regio reg,
	zon_secci sec,
	zon_sub_geren_venta subg,
	zon_terri_admin zta
where 
	tel.oidcli(+)=datos.idcliente
	and docu.idcli(+)=datos.idcliente
	and un_adm.CLIE_OID_CLIE=datos.idcliente
	and un_adm.ZTAD_OID_TERR_ADMI=zta.oid_terr_admi	 	   			 	  			
	and zta.zscc_oid_secc=sec.OID_SECC
	and sec.ZZON_OID_ZONA=zon.OID_ZONA
	and zon.ZORG_OID_REGI=reg.OID_REGI
	and reg.ZSGV_OID_SUBG_VENT=subg.oid_subg_vent
order by codigo, nombre




