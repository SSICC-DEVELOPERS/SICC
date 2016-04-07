select 
	   per.VAL_NOMB_PERI,
	   sol.fec_fact,
	   reg.COD_REGI,
	   zon.COD_ZONA,
	   cli.VAL_APE1||' '||cli.VAL_APE2||' '||cli.VAL_NOM1||' '||cli.VAL_NOM2 AS gerente_zon,
	   count(sol.oid_soli_cabe) AS cant_sol,
	   sum(sol.VAL_TOTA_PAGA_LOCA + sol.VAL_IMPO_REDO_LOCA) AS importe_facturado,
	   decode(sum(sol.VAL_TOTA_PAGA_LOCA + sol.VAL_IMPO_REDO_LOCA)
	   		  ,0
			  ,0
			  ,count(sol.oid_soli_cabe) / sum(sol.VAL_TOTA_PAGA_LOCA + sol.VAL_IMPO_REDO_LOCA)) AS promedio
from seg_marca mar,
	 seg_canal can,
	 seg_acces acc,
	 ped_tipo_solic t_sol,
	 ped_solic_cabec sol,
	 ped_tipo_solic_pais t_sol_p,
	 zon_zona zon,
	 zon_regio reg,
	 cra_perio per,
	 mae_clien cli,
	 (
	 select gen.VAL_OID, gen.VAL_I18N pais
	 from v_gen_i18n_sicc gen
	 where gen.ATTR_ENTI = 'SEG_PAIS'
	 	   and gen.IDIO_OID_IDIO = 1 --PAREMETRO--
	 )gen_pais
where sol.TSPA_OID_TIPO_SOLI_PAIS = t_sol_p.OID_TIPO_SOLI_PAIS 
	  and t_sol_p.TSOL_OID_TIPO_SOLI = t_sol.OID_TIPO_SOLI
	  and t_sol.MARC_OID_MARC = mar.OID_MARC
	  and t_sol.ACCE_OID_ACCE = acc.OID_ACCE
	  and acc.CANA_OID_CANA = can.OID_CANA
	  and sol.ZZON_OID_ZONA= zon.OID_ZONA
	  and sol.PERD_OID_PERI = per.OID_PERI
	  and sol.IND_TS_NO_CONSO <> 1
	  and sol.IND_PEDI_PRUE <> 1
	  and reg.IND_ACTI = 1
	  and sol.FEC_FACT is not null
	  and zon.clie_oid_clie = cli.OID_CLIE
	  and zon.ZORG_OID_REGI = reg.OID_REGI
	  and sol.PAIS_OID_PAIS = gen_pais.val_oid(+)
	  and sol.PAIS_OID_PAIS = 1 --PARAMETRO--
	  and mar.OID_MARC = 1 --PARAMETRO--
	  and can.OID_CANA = 1 --PARAMETRO--
	  and per.OID_PERI = 57 --PARAMETRO--
	  and t_sol.ACCE_OID_ACCE = 1 --PARAMETRO-- 
	  and zon.OID_ZONA in (1) --PARAMETRO--
	  and zon.ZORG_OID_REGI in (1) --PARAMETRO--
	  and TO_DATE(sol.fec_fact) between TO_DATE('1/1/2003','DD/MM/YYYY') and TO_DATE('31/12/2015','DD/MM/YYYY')   
group by 
	  per.VAL_NOMB_PERI,
	  sol.fec_fact,
	   reg.COD_REGI,
	   zon.COD_ZONA,
	   cli.VAL_APE1||' '||cli.VAL_APE2||' '||cli.VAL_NOM1||' '||cli.VAL_NOM2
order by
	   reg.COD_REGI,
  	   zon.COD_ZONA,
	   cli.VAL_APE1||' '||cli.VAL_APE2||' '||cli.VAL_NOM1||' '||cli.VAL_NOM2
