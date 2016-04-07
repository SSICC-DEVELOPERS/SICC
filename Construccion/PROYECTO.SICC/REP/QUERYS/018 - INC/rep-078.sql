select  NUM_CONC,
		DES_SUBG_VENT,
		DES_REGI,
		COD_ZONA,
		COD_REGI,
		gerente_region,
		gerente_zona,
		sum(consultoras_con_metas) as consultoras_con_metas,
		sum(cons_ganadoras)as cons_ganadoras,
		sum(decode(consultoras_con_metas,0,0,cons_ganadoras / consultoras_con_metas) * 100) por_ganadoras
from 
(
---------------------------------------------------------------------------------------------------------------
	select 
		   con.NUM_CONC,
		   subg.DES_SUBG_VENT,
		   reg.DES_REGI,
		   zon.COD_ZONA,
		   reg.COD_REGI,
		   cli_reg.VAL_NOM1||' '||cli_reg.VAL_NOM2||' '||cli_reg.VAL_APE1||' '||cli_reg.VAL_APE2 as gerente_region,
	   	   cli_zon.VAL_NOM1||' '||cli_zon.VAL_NOM2||' '||cli_zon.VAL_APE1||' '||cli_zon.VAL_APE2 as gerente_zona,
		   count(*) as consultoras_con_metas,
		   (
		   	select count(*)
			from inc_ganad gan,
				 inc_param_nivel_premi niv,
				 inc_param_gener_premi par_pre,
				 mae_clien_unida_admin un_adm2
			where gan.PANP_OID_PARA_NIVE_PREM = niv.OID_PARA_NIVE_PREM
				  and niv.PAGP_OID_PARA_GENE_PREM = par_pre.OID_PARA_GENE_PREM
				  and par_pre.COPA_OID_PARA_GRAL = con.OID_PARA_GRAL 
				  and gan.CLIE_OID_CLIE = un_adm2.CLIE_OID_CLIE
				  and un_adm2.ZTAD_OID_TERR_ADMI = ter_adm.OID_TERR_ADMI
				  and un_adm2.ind_acti = 1
			) cons_ganadoras
	from mae_clien_unida_admin un_adm,
		 mae_clien cli_reg,
		 mae_clien cli_zon,
		 zon_sub_geren_venta subg,
	 	 zon_regio reg,
		 zon_zona zon,
		 zon_secci sec,
		 zon_terri_admin ter_adm,
		 inc_concu_param_gener con,
		 (
			 select * from (
			 (
			  select * from inc_metas_tipo_venta met2
			  where met2.copa_oid_para_gral = 1 --PARAMETRO CONCURSO--
			 )
	 		 minus 
			 (
			  select met.*
			  from inc_metas_tipo_venta met,
			  	   inc_desca des,
				   inc_causa_desca cau_des
			  where met.CLIE_OID_CLIE = des.clie_oid_clie
			  		and met.COPA_OID_PARA_GRAL = des.COPA_OID_PARA_GRAL
					and des.CADE_OID_CAUS_DESC = cau_des.OID_CAUS_DESC
--					and cau_des.COD_CAUS in ('FA','FC')
					and met.COPA_OID_PARA_GRAL = 1 --PARAMETRO CONCURSO--
			 ))
		 )cons_totales
	where un_adm.ZTAD_OID_TERR_ADMI = ter_adm.OID_TERR_ADMI
		  and un_adm.IND_ACTI = 1
		  and con.IND_ACTI = 1
		  and ter_adm.ZSCC_OID_SECC = sec.OID_SECC
		  and sec.ZZON_OID_ZONA = zon.oid_zona
		  and zon.ZORG_OID_REGI = reg.oid_regi
		  and reg.ZSGV_OID_SUBG_VENT = subg.OID_SUBG_VENT
		  and cons_totales.clie_oid_clie = un_adm.clie_oid_clie
		  and cons_totales.COPA_OID_PARA_GRAL = con.OID_PARA_GRAL
		  and reg.clie_oid_clie = cli_reg.oid_clie(+)
		  and zon.clie_oid_clie = cli_zon.oid_clie(+)
/*		  and con.PAIS_OID_PAIS = 1 --PARAMETRO PAIS--
		  and con.MARC_OID_MARC = 1 --PARAMETRO MARCA--
		  and con.CANA_OID_CANA = 1 --PARAMETRO CANAL--
		  and con.OID_PARA_GRAL = 1 --PARAMETRO CONCURSO--
		  and subg.OID_SUBG_VENT in (1,2,3,4,5,6,7) --PARAMETRO SUBGERENCIA--
		  and reg.OID_REGI in (1,2,3,4,5,6,7) --PARAMETRO REGION--
		  and zon.OID_ZONA in (1,2,3,4,5,6,7) --PARAMETRO ZONA--*/
--		  and ter_adm.TERR_OID_TERR = 1 --PARAMETRO TERRITORIO--
	group by con.NUM_CONC,
		   subg.DES_SUBG_VENT,
		   reg.DES_REGI,
		   zon.COD_ZONA,
		   reg.COD_REGI,
		   cli_reg.VAL_NOM1||' '||cli_reg.VAL_NOM2||' '||cli_reg.VAL_APE1||' '||cli_reg.VAL_APE2,
	   	   cli_zon.VAL_NOM1||' '||cli_zon.VAL_NOM2||' '||cli_zon.VAL_APE1||' '||cli_zon.VAL_APE2,
		   con.OID_PARA_GRAL,
		   ter_adm.OID_TERR_ADMI 
---------------------------------------------------------------------------------------------------------------
)
group by NUM_CONC,
		DES_SUBG_VENT,
		DES_REGI,
		COD_ZONA,
		COD_REGI,
		gerente_region,
		gerente_zona
