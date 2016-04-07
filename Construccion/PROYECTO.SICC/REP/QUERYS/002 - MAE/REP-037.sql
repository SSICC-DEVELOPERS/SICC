select 
	a.pais, a.subgerencia, a.region, a.zona, a.seccion, 
	a.codigo, a.nombrecompleto, a.direccion, a.fecha_ingreso, a.DOCUMENTO, a.TEL, 	
	decode(NVL(saldo,0),0,0,1) as CONSALDO, decode(NVL(saldo,0),0,1,0) SINSALDO 
from 
	(
	select  
	cli_val.PAIS, cli_val.SUBGERENCIA , cli_val.REGION, cli_val.ZONA as zona, cli_val.SECCION,
	datos_cli.CODIGO,datos_cli.idcliente, datos_cli.NOMBRE as nombrecompleto, datos_cli.DIRECCION, datos_cli.fecha_ingreso,
	(select 
		pe.VAL_NOMB_PERI 
	 from 
		 (
		  select * from cra_perio per2 order by per2.FEC_INIC
		 )pe  
	 where datos_cli.fecha_ingreso >= pe.FEC_INIC and datos_cli.fecha_ingreso <= pe.FEC_FINA and rownum = 1 
	) campaña,
	datos_cli.documento, 
	datos_cli.tel, 
	(
	 SELECT SUM(m.IMP_PEND) as suma 
	 FROM CCC_MOVIM_CUENT_CORRI m 
	 WHERE m.CLIE_OID_CLIE = cli_val.clie_oid_clie
	 	   AND M.ZSGV_OID_SUBG_VENT = cli_val.OID_SUBG_VENT
	 	   AND M.ZORG_OID_REGI = CLI_VAL.OID_REGI
		   AND M.ZSCC_OID_SECC = CLI_VAL.OID_SECC
	) as saldo
	 from
	(
	select 
		distinct un_adm.CLIE_OID_CLIE, un_adm.ZTAD_OID_TERR_ADMI, 
		(PAIS.COD_PAIS || ' ' || gen.VAL_I18N) AS PAIS, 
		(subg.COD_SUBG_VENT || ' ' || subg.DES_SUBG_VENT) AS SUBGERENCIA, 
		(reg.COD_REGI || ' ' || reg.DES_REGI) AS REGION, 
		(zon.COD_ZONA || ' ' || zon.DES_ZONA) AS ZONA, 
		(sec.COD_SECC || ' ' || sec.DES_SECCI) AS SECCION,   
		subg.OID_SUBG_VENT, reg.OID_REGI, zon.OID_ZONA, sec.OID_SECC
	from   
		mae_clien_unida_admin un_adm,
		cra_perio per, 
		cra_perio per2,		
		cra_perio per3,		
		zon_terri_admin zta, 
		seg_marca mar, 
		seg_canal can, 
		zon_sub_geren_venta subg,		zon_regio reg,		zon_zona zon,		zon_secci sec,
		(
		 SELECT V.VAL_OID, V.VAL_I18N 
		 FROM V_GEN_I18N_SICC V 
		 WHERE V.ATTR_ENTI = 'SEG_PAIS' 
		 AND V.IDIO_OID_IDIO = 1		 	 		 				 	-- PARAMETRO --
		) gen,
		SEG_PAIS PAIS
	where 
		    un_adm.PERD_OID_PERI_INI=per.OID_PERI 
		and un_adm.PERD_OID_PERI_FIN(+)=per2.OID_PERI
		and per3.OID_PERI=56		 	 		 				 		-- PARAMETRO --
		and per.FEC_INIC<=per3.FEC_INIC
		and per3.FEC_FINA<=per2.FEC_FINA
		and un_adm.ZTAD_OID_TERR_ADMI=zta.oid_terr_admi	 	   			 	  			
		and zta.zscc_oid_secc=sec.OID_SECC
		and sec.ZZON_OID_ZONA=zon.OID_ZONA
		and zon.ZORG_OID_REGI=reg.OID_REGI
		and reg.ZSGV_OID_SUBG_VENT=subg.oid_subg_vent
		and subg.marc_oid_marc=mar.OID_MARC
		and subg.cana_oid_cana=can.OID_CANA
		and gen.VAL_OID(+)=subg.PAIS_OID_PAIS
		and subg.PAIS_OID_PAIS = PAIS.OID_PAIS
		and subg.PAIS_OID_PAIS = 1		 	 		 				 	-- PARAMETRO --
		and mar.OID_MARC=1 		 	 		 				 			-- PARAMETRO --
		and can.OID_CANA=1 		 	 		 				 			-- PARAMETRO --
		and subg.oid_subg_vent=1 		 	 		 				 	-- PARAMETRO --
		and reg.OID_REGI=1  		 	 		 				 		-- PARAMETRO --
		and zon.OID_ZONA=1 		 	 		 				 			-- PARAMETRO --
		and sec.OID_SECC=1 		 	 		 				 			-- PARAMETRO --
		and zta.oid_terr_admi=1 		 	 		 				 	-- PARAMETRO --
	)cli_val,
	(
	select  datos.idcliente,codigo,nombre, direccion,fecha_ingreso, docu.documento ,tel
	from 
		(
	 	select  cli.OID_CLIE as idcliente,cli.COD_CLIE codigo, cli.VAL_APE1 ||' '||cli.VAL_APE2||' '||cli.VAL_NOM1||' '||cli.VAL_NOM2 as nombre,
			tipo_via.t_v||' '|| dir.VAL_NOMB_VIA ||'   '|| dir.NUM_PPAL as direccion, cli.FEC_INGR as fecha_ingreso 
		From mae_clien_ident id,  
			mae_clien_direc dir, 
			mae_clien cli,
			(select gen.VAL_I18N as t_v, via.OID_TIPO_VIA
			from seg_tipo_via via, 
			v_gen_i18n_sicc gen 
			where gen.ATTR_ENTI='SEG_TIPO_VIA'
			and gen.VAL_OID=via.oid_tipo_via
			and gen.IDIO_OID_IDIO=1 		 	 		 				 			-- PARAMETRO --
			) tipo_via
			where cli.OID_CLIE=id.OID_CLIE_IDEN(+)
			and cli.PAIS_OID_PAIS = 1 		 	 		 				 			-- PARAMETRO --
			and cli.OID_CLIE=dir.CLIE_OID_CLIE(+)
			and dir.TIVI_OID_TIPO_VIA=tipo_via.oid_tipo_via(+)
			and dir.TIDC_OID_TIPO_DIRE(+)=1 		 	 		 				 	-- VALUE --
			and cli.COD_CLIE = '00000000001' 		 	 		 				 		-- PARAMETRO --
		 ) datos,
		 (
	  	   	  select  com.CLIE_OID_CLIE as oidcli,com.VAL_TEXT_COMU as tel  
			  from mae_clien_comun com, mae_tipo_comun tcom
			  where com.TICM_OID_TIPO_COMU(+)=tcom.OID_TIPO_COMU
			  and tcom.COD_TIPO_COMU='TF' 		 	 		 				 		-- VALUE --
		 ) tel,
		 (
	 	   	   select distinct id2.clie_oid_clie as idcli,
	 		   decode((select id.NUM_DOCU_IDEN from mae_clien_ident id where id.VAL_IDEN_DOCU_PRIN=1 and id.CLIE_OID_CLIE=id2.CLIE_OID_CLIE ),
			   NULL,'',(select id.NUM_DOCU_IDEN from mae_clien_ident id where id.VAL_IDEN_DOCU_PRIN=1 and id.CLIE_OID_CLIE=id2.CLIE_OID_CLIE)) as documento
			   from mae_clien_ident id2, mae_clien cli_doc
			   where id2.CLIE_OID_CLIE = cli_doc.OID_CLIE
			   		 and cli_doc.COD_CLIE = '00000000001' 		 	 		 			-- PARAMETRO --
		 )docu
	 where tel.oidcli(+)=datos.idcliente
	 and docu.idcli(+)=datos.idcliente
	)datos_cli, 
	mae_clien_datos_adici dat_adic
where 
	    datos_cli.idcliente=cli_val.clie_oid_clie
	and cli_val.clie_oid_clie(+)=dat_adic.clie_oid_clie
and dat_adic.esta_oid_esta_clie = 5  		 	 		 				 			-- VALUE --
) a
order by a.pais, a.subgerencia,  a.region, a.zona, a.seccion, a.codigo
