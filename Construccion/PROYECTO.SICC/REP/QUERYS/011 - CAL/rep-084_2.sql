select
	  pais,
	  marca,
	  region,
	  periodo,
	  count(atendidas)+count(pendientes)total,
	  count(atendidas),
	  count(pendientes),
	  count(menos_24),
	  count(mas_24_menos_48),
	  count(mas_48),
	  count(tipo_clie_1),
  	  count(tipo_clie_2),
  	  count(tipo_clie_3),
  	  count(tipo_clie_4),
  	  count(tipo_clie_5),
  	  count(tipo_clie_6)
from 
(
	select 
		   gen_pais.pais pais,
		   mar.DES_MARC marca,
	   	   reg.DES_REGI region,
		   --OBTIENE EL PERIODO EN QUE SE EFECTUO LA CONSULTA--
		   (
			   select val_nomb_peri  
			   from  
			   (
			   		 select per.VAL_NOMB_PERI, per.FEC_INIC, per.FEC_FINA, per.oid_peri, per.PAIS_OID_PAIS, per.MARC_OID_MARC, per.CANA_OID_CANA
					 from cra_perio per
					 order by per.FEC_INIC
				)pe  
				where  conta.VAL_HORA_INIC between pe.FEC_INIC and pe.FEC_FINA
					   and PAIS_OID_PAIS = subg.PAIS_OID_PAIS
					   and MARC_OID_MARC = subg.MARC_OID_MARC
					   and CANA_OID_CANA = subg.CANA_OID_CANA
				and rownum = 1
			)periodo,
			--POR STATUS DE LLAMADA--
			(
			select tipo_est_cont.COD_ESTA 
			from cal_atrib_estad_conta est_cont,
				 cal_tipo_estad_conta tipo_est_cont
			where est_cont.TECO_OID_TIPO_ESTA_CONT = tipo_est_cont.OID_TIPO_ESTA_CONT
				  and est_cont.OID_ATRI_ESTA_CONT = conta.ATEC_OID_ATRI_ESTA_CONT
				  and tipo_est_cont.COD_ESTA  = '03'
			)atendidas,
					(
			select tipo_est_cont.COD_ESTA 
			from cal_atrib_estad_conta est_cont,
				 cal_tipo_estad_conta tipo_est_cont
			where est_cont.TECO_OID_TIPO_ESTA_CONT = tipo_est_cont.OID_TIPO_ESTA_CONT
				  and est_cont.OID_ATRI_ESTA_CONT = conta.ATEC_OID_ATRI_ESTA_CONT
				  and tipo_est_cont.COD_ESTA <>  '03'
			)pendientes,
			--POR TIEMPO DE RESPUESTA--
			(
			select 1
			from cal_conta conta2
			where conta2.OID_CONT = conta.OID_CONT
				  and nvl(trunc((((86400*(decode(conta.FEC_HORA_CIER,null,sysdate,conta.FEC_HORA_CIER)-conta.VAL_HORA_INIC))/60)/60)/24),0) < 1
			)menos_24,
			(
			select 1
			from cal_conta conta2
			where conta2.OID_CONT = conta.OID_CONT
				  and nvl(trunc((((86400*(decode(conta.FEC_HORA_CIER,null,sysdate,conta.FEC_HORA_CIER)-conta.VAL_HORA_INIC))/60)/60)/24),0) >= 1 
				  and nvl(trunc((((86400*(decode(conta.FEC_HORA_CIER,null,sysdate,conta.FEC_HORA_CIER)-conta.VAL_HORA_INIC))/60)/60)/24),0) < 2 
			)mas_24_menos_48,
			(
			select 1
			from cal_conta conta2
			where conta2.OID_CONT = conta.OID_CONT
				  and nvl(trunc((((86400*(decode(conta.FEC_HORA_CIER,null,sysdate,conta.FEC_HORA_CIER)-conta.VAL_HORA_INIC))/60)/60)/24),0) >= 2 
			)mas_48,
			--POR TIPO DE PERIODO--
			(
			select tipo_cli.COD_TIPO_CLIE 
			from mae_clien_tipo_subti tipo_subt,
				 mae_tipo_clien tipo_cli
			where tipo_subt.TICL_OID_TIPO_CLIE = tipo_cli.OID_TIPO_CLIE
				  and tipo_subt.IND_PPAL = 1 --INDICADOR DE TIPO PRINCIPAL--
				  and tipo_subt.clie_oid_clie = un_adm.clie_oid_clie
				  and tipo_cli.OID_TIPO_CLIE = 1 --PARAMETRO-- 
		    )tipo_clie_1,
			(
			select tipo_cli.COD_TIPO_CLIE 
			from mae_clien_tipo_subti tipo_subt,
				 mae_tipo_clien tipo_cli
			where tipo_subt.TICL_OID_TIPO_CLIE = tipo_cli.OID_TIPO_CLIE
				  and tipo_subt.IND_PPAL = 1 --INDICADOR DE TIPO PRINCIPAL--
				  and tipo_subt.clie_oid_clie = un_adm.clie_oid_clie
				  and tipo_cli.OID_TIPO_CLIE = 2 --PARAMETRO-- 
		    )tipo_clie_2,
			(
			select tipo_cli.COD_TIPO_CLIE 
			from mae_clien_tipo_subti tipo_subt,
				 mae_tipo_clien tipo_cli
			where tipo_subt.TICL_OID_TIPO_CLIE = tipo_cli.OID_TIPO_CLIE
				  and tipo_subt.IND_PPAL = 1 --INDICADOR DE TIPO PRINCIPAL--
				  and tipo_subt.clie_oid_clie = un_adm.clie_oid_clie
				  and tipo_cli.OID_TIPO_CLIE = 3 --PARAMETRO-- 
		    )tipo_clie_3,
			(
			select tipo_cli.COD_TIPO_CLIE 
			from mae_clien_tipo_subti tipo_subt,
				 mae_tipo_clien tipo_cli
			where tipo_subt.TICL_OID_TIPO_CLIE = tipo_cli.OID_TIPO_CLIE
				  and tipo_subt.IND_PPAL = 1 --INDICADOR DE TIPO PRINCIPAL--
				  and tipo_subt.clie_oid_clie = un_adm.clie_oid_clie
				  and tipo_cli.OID_TIPO_CLIE = 4 --PARAMETRO-- 
		    )tipo_clie_4,
			(
			select tipo_cli.COD_TIPO_CLIE 
			from mae_clien_tipo_subti tipo_subt,
				 mae_tipo_clien tipo_cli
			where tipo_subt.TICL_OID_TIPO_CLIE = tipo_cli.OID_TIPO_CLIE
				  and tipo_subt.IND_PPAL = 1 --INDICADOR DE TIPO PRINCIPAL--
				  and tipo_subt.clie_oid_clie = un_adm.clie_oid_clie
				  and tipo_cli.OID_TIPO_CLIE = 5 --PARAMETRO-- 
		    )tipo_clie_5,
			(
			select tipo_cli.COD_TIPO_CLIE 
			from mae_clien_tipo_subti tipo_subt,
				 mae_tipo_clien tipo_cli
			where tipo_subt.TICL_OID_TIPO_CLIE = tipo_cli.OID_TIPO_CLIE
				  and tipo_subt.IND_PPAL = 1 --INDICADOR DE TIPO PRINCIPAL--
				  and tipo_subt.clie_oid_clie = un_adm.clie_oid_clie
				  and tipo_cli.OID_TIPO_CLIE = 6 --PARAMETRO-- 
		    )tipo_clie_6	
	from 
		 mae_clien_unida_admin un_adm,
		 zon_terri_admin ter_adm,
		 zon_secci sec,
		 zon_zona zon,
		 zon_regio reg,
		 zon_sub_geren_venta subg,
		 cal_conta conta,
		 cal_motiv_conta mot_conta,
		 seg_marca mar,
		 (
		 select gen.val_oid, gen.val_i18n pais 
		 from v_gen_i18n_sicc gen
		 where gen.ATTR_ENTI = 'SEG_PAIS'
		 	   and gen.IDIO_OID_IDIO = 1 --PARAMETRO--
		 )gen_pais
	where un_adm.ZTAD_OID_TERR_ADMI = ter_adm.OID_TERR_ADMI
		  and ter_adm.ZSCC_OID_SECC = sec.OID_SECC
		  and sec.ZZON_OID_ZONA = zon.OID_ZONA
		  and zon.ZORG_OID_REGI = reg.OID_REGI
		  and reg.ZSGV_OID_SUBG_VENT = subg.OID_SUBG_VENT
		  and subg.PAIS_OID_PAIS = gen_pais.val_oid(+)
	/*	  and subg.PAIS_OID_PAIS = 1 --PARAMETRO--
		  and subg.MARC_OID_MARC = 1 --PARAMETRO--
		  and subg.CANA_OID_CANA = 1 --PARAMETRO--
		  and subg.OID_SUBG_VENT = 1 --PARAMETRO--
		  and reg.OID_REGI = 1 --PARAMETRO--
		  and zon.OID_ZONA = 1 --PARAMETRO--*/
		  and conta.VAL_HORA_INIC>= to_date('1/1/2003', 'dd/MM/yyyy') --PARAMETRO FECHA INICIO--
		  and conta.VAL_HORA_FIN <= to_date('31/12/2015', 'dd/MM/yyyy') --PARAMETRO FECHA FIN--
		  and un_adm.ind_acti = 1 --INDICADOR DE ACTIVO--
		  and conta.clie_oid_clie = un_adm.CLIE_OID_CLIE
		  and conta.pais_oid_pais = subg.PAIS_OID_PAIS
		  and conta.MOCO_OID_MOTI_CONT = mot_conta.OID_MOTI_CONT
		  and subg.MARC_OID_MARC = mar.OID_MARC
	--	  and mot_conta.COD_MOTI = '00' --INDICADOR DE INFORMACION GENERAL DEL CLIENTE--
)
group by
	  pais,
	  marca,
	  region,
	  periodo
order by region