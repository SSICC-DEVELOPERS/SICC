select PAIS,
	   per_desde,
	   per_hasta,
	   val_nomb_peri,
	   DES_SUBG_VENT,
	   DES_REGI,
	   DES_ZONA,
	   COD_TERR,
	   COD_CLIE,
	   apyno,
	   NUM_CONC,
	   NUM_NIVE,
	   cantidad as unidades,
	   DESCRIPCION,
	   sum(abono + cargo + canje)  as disponibles,
	   sum(canje)*(-1) as canjeados,
   	   case when sum(canje) = 0 and sum(abono + cargo + canje) <> 0 then 1 end as acumulado_no_canjeados,
	   case when sum(canje) <> 0 and sum(abono + cargo + canje) = 0 then 1 end as canjeados_sin_disponibles,
	   case when sum(canje) <> 0 and sum(abono + cargo + canje) <> 0 then 1 end as canjeados_con_disponibles,	
	   COUNT(DISTINCT COD_CLIE) OVER (PARTITION BY PAIS,PER_DESDE,PER_HASTA,DES_SUBG_VENT, DES_REGI,DES_ZONA, COD_TERR) TC_TERR,   
	   COUNT(DISTINCT COD_CLIE) OVER (PARTITION BY PAIS,PER_DESDE,PER_HASTA,DES_SUBG_VENT, DES_REGI,DES_ZONA) TC_ZONA,
       COUNT(DISTINCT COD_CLIE) OVER (PARTITION BY PAIS,PER_DESDE,PER_HASTA,DES_SUBG_VENT, DES_REGI) TC_REGION
from
(
	select paises.PAIS, 
		   per2.val_nomb_peri as per_desde,
		   per3.val_nomb_peri as per_hasta,
		   per.val_nomb_peri,
		   subg.DES_SUBG_VENT,
		   reg.DES_REGI,
		   zon.DES_ZONA,
		   ter.COD_TERR,
		   cli.COD_CLIE,
		   cli.VAL_NOM1||' '||cli.VAL_APE1 as apyno,
		   par_gen.NUM_CONC,
		   niv_pre.NUM_NIVE,
		   v_pre.cantidad,
		   decode(v_pre.oid_tipo_prem,2,
		   v_pre.TIPO_PREMIO||' '||v_pre.DESCRIPCION||' '||niv_pre.NUM_NIVE,
		   v_pre.TIPO_PREMIO||' '||v_pre.DESCRIPCION ) as descripcion,
		   ----------------------------------------------------------------------------------------------------
		   decode(cc_pun.TMOV_OID_TIPO_MOVI,1,sum(cc_pun.NUM_PUNT),0) as abono,
		   ----------------------------------------------------------------------------------------------------
		   case
		   	   when cc_pun.TMOV_OID_TIPO_MOVI = 2 and (par_gen.IND_ANUL = 1 or par_gen.IND_DEVO = 1) then
			   		sum(cc_pun.NUM_PUNT)
			   else 0
		   end as cargo,
		   ----------------------------------------------------------------------------------------------------
		   case
		   	   when cc_pun.TMOV_OID_TIPO_MOVI = 3 then
			   		sum(cc_pun.NUM_PUNT)
			    else 0
		   end as canje
		   ----------------------------------------------------------------------------------------------------
	from
		inc_concu_param_gener par_gen,
		inc_cuent_corri_punto cc_pun,
		inc_premi_elegi pre_el,
		mae_clien cli,
		zon_zona zon,
		zon_regio reg,
		zon_secci sec,
		zon_terri_admin ter_adm,
		zon_sub_geren_venta subg,
		zon_terri ter,
		cra_perio per,
		cra_perio per2,
		cra_perio per3,
		inc_param_nivel_premi niv_pre,
		inc_param_gener_premi par_pre,
		mae_clien_unida_admin un_adm,
		v_rep_premios v_pre,
		(
		  select gen.VAL_OID, gen.val_i18n PAIS
		  from v_gen_i18n_sicc gen
		  where gen.ATTR_ENTI = 'SEG_PAIS'
				and idio_oid_idio = 4 --PARAMETRO IDIOMA--
				and gen.VAL_OID in (1,2,3,4,5,6,7,8,9)--par_gen.pais_oid_pais--pai.oid_pais
		 )paises
	where
		 par_gen.IND_ACTI = 1
		 and par_gen.OID_PARA_GRAL = cc_pun.COPA_OID_PARA_GRAL
		 and cc_pun.CLIE_OID_CLIE = cli.oid_clie
		 and cc_pun.clie_oid_clie = un_adm.clie_oid_clie
--		 and un_adm.IND_ACTI = 1
		 and un_adm.ZTAD_OID_TERR_ADMI = ter_adm.OID_TERR_ADMI
		 and par_gen.PERD_OID_PERI_DESD = per2.oid_peri
		 and par_gen.PERD_OID_PERI_HAST = per3.oid_peri
		 and ter_adm.ZSCC_OID_SECC = sec.OID_SECC
		 and sec.ZZON_OID_ZONA = zon.OID_ZONA
		 and zon.ZORG_OID_REGI = reg.oid_regi
		 and reg.ZSGV_OID_SUBG_VENT = subg.OID_SUBG_VENT
		 and ter_adm.TERR_OID_TERR = ter.OID_TERR
		 and cc_pun.PERD_OID_PERI = per.oid_peri
		 and pre_el.COPA_OID_PARA_GRAL = par_gen.OID_PARA_GRAL
		 and pre_el.CLIE_OID_CLIE = cli.OID_CLIE
		 and pre_el.PANP_OID_PARA_NIVE_PREM = v_pre.OID_PARA_NIVE_PREM
		 and pre_el.PANP_OID_PARA_NIVE_PREM = niv_pre.OID_PARA_NIVE_PREM
--		 and v_pre.IDIO_TIPO_PREMIO = 1  
		 and subg.OID_SUBG_VENT in (1) --PARAMETRO SUBGERENCIA--
--		 and reg.OID_REGI in (7) --PARAMETRO REGION-- 
--		 and zon.OID_ZONA in (1) --PARAMETRO ZONA--
--		 and ter_adm.TERR_OID_TERR in (2) --PARAMETRO TERRITORIO--
		 and par_gen.NUM_CONC in (2) --PARAMETRO NUMERO CONCURSO--
		 and par_gen.pais_oid_pais in (1,2,3,4,5,6,7) --PARAMETRO PAIS--
		 and par_gen.pais_oid_pais = paises.VAL_OID (+)
	group by 
		   paises.PAIS,
		   per.val_nomb_peri,
		   subg.DES_SUBG_VENT,
		   reg.DES_REGI,
		   zon.DES_ZONA,
		   ter.COD_TERR,
		   cli.COD_CLIE,
		   cli.VAL_NOM1||' '||cli.VAL_APE1,
		   par_gen.NUM_CONC,
		   cc_pun.TMOV_OID_TIPO_MOVI,
		   par_gen.IND_ANUL,
		   par_gen.IND_DEVO,
		   niv_pre.NUM_NIVE,
   		   decode(v_pre.OID_TIPO_PREM,2,
		   v_pre.TIPO_PREMIO||' '||v_pre.DESCRIPCION||' '||niv_pre.NUM_NIVE,
		   v_pre.TIPO_PREMIO||' '||v_pre.DESCRIPCION ),
		   v_pre.cantidad,
		   per2.val_nomb_peri,
		   per3.val_nomb_peri
)
group by
	  PAIS,
	  per_desde,
	   per_hasta,
	   val_nomb_peri,
	   DES_SUBG_VENT,
	   DES_REGI,
	   DES_ZONA,
	   COD_TERR,
	   COD_CLIE,
	   apyno,
	   NUM_CONC,
	   NUM_NIVE,
	   DESCRIPCION,
	   cantidad

