--HACER EL CORTE POR CONCURSO, Y OID_PERI, PERO MOSTRAR PERIODO--
select num_conc,
	   concurso,
	   DES_SUBG_VENT,
	   DES_REGI,
	   DES_ZONA,
	   COD_TERR,
	   periodo_inicial,
	   periodo_final,
	   periodo,
	   oid_peri,
	   nivel_alcanzado,
	   total_clientes,
	   cod_clie,
	   apellido_paterno,
	   apellido_materno,
	   nombres,
	   puntos_acum,
	   puntos_falt_prox_nivel,
	   rank() over ( partition by num_conc, concurso, DES_SUBG_VENT, DES_REGI, DES_ZONA, COD_TERR, periodo_inicial,
	   periodo_final, periodo, oid_peri,nivel_alcanzado order by puntos_acum desc) as ranking
from
( 
	SELECT num_conc,
		   concurso,
		   DES_SUBG_VENT,
		   DES_REGI,
		   DES_ZONA,
		   COD_TERR,
		   periodo_inicial,
		   periodo_final,
		   val_nomb_peri AS periodo,
		   oid_peri AS oid_peri,
		   DECODE(nivel_alcanzado,0,0,nivel_alcanzado) AS nivel_alcanzado,
		   COUNT(COD_CLIE) AS total_clientes,
		   DECODE(nivel_alcanzado,0,NULL,cod_clie) AS cod_clie,
		   DECODE(nivel_alcanzado,0,NULL,apellido_paterno) AS apellido_paterno,
		   DECODE(nivel_alcanzado,0,NULL,apellido_materno) AS apellido_materno,
		   DECODE(nivel_alcanzado,0,NULL,nombres) AS nombres,
		   DECODE(nivel_alcanzado,0,0,puntos_acum) AS puntos_acum,
		   DECODE(nivel_alcanzado,0,NULL,puntos_falt_prox_nivel) AS puntos_falt_prox_nivel
	FROM
	(
		SELECT 	num_conc,
				concurso,
				DES_SUBG_VENT,
				DES_REGI,
				DES_ZONA,
				COD_TERR,
				periodo_inicial,
				periodo_final,
				COD_CLIE,
				apellido_paterno,
				apellido_materno,
				nombres,
				oid_peri,
				val_nomb_peri,
				puntos_acum,
				OID_PARA_GENE_PREM,
				(				   
				 SELECT NVL(MAX(niv_pre.NUM_NIVE),0)
				 FROM inc_param_nivel_premi niv_pre
				 WHERE niv_pre.PAGP_OID_PARA_GENE_PREM = OID_PARA_GENE_PREM
			   		 AND DECODE(niv_pre.NUM_CANT_FIJA_PUNT,NULL,niv_pre.NUM_CANT_INIC_PUNT,niv_pre.NUM_CANT_FIJA_PUNT) <= puntos_acum
				)nivel_alcanzado,
				(
				 SELECT MIN(DECODE(niv_pre.NUM_CANT_FIJA_PUNT,NULL,niv_pre.NUM_CANT_INIC_PUNT,niv_pre.NUM_CANT_FIJA_PUNT)) - puntos_acum
				 FROM inc_param_nivel_premi niv_pre
				 WHERE niv_pre.PAGP_OID_PARA_GENE_PREM = OID_PARA_GENE_PREM
				 	   AND DECODE(niv_pre.NUM_CANT_FIJA_PUNT,NULL,niv_pre.NUM_CANT_INIC_PUNT,niv_pre.NUM_CANT_FIJA_PUNT) > puntos_acum
		   		)puntos_falt_prox_nivel
		FROM 
		(
			SELECT 
				   con.IND_DEVO,
				   con.IND_ANUL,
				   con.num_conc,
				   con.VAL_NOMB AS concurso,
				   con.oid_para_gral,
				   par_pre.OID_PARA_GENE_PREM,
				   cli.OID_CLIE,
				   con.VAL_NOMB,
				   subg.DES_SUBG_VENT,
				   reg.DES_REGI,
				   zon.DES_ZONA,
				   ter.COD_TERR,
				   per_ini.val_nomb_peri AS periodo_inicial,
				   per_fin.val_nomb_peri AS periodo_final,
				   cli.COD_CLIE,
				   cli.VAL_APE1 AS apellido_paterno,
				   cli.VAL_APE2 AS apellido_materno, 
				   cli.VAL_NOM1||' '||cli.VAL_NOM2 AS nombres,
	   			   per.oid_peri,
				   per.val_nomb_peri,
				   SUM(
				   (
				   	SELECT SUM(pun.NUM_PUNT)
					FROM inc_cuent_corri_punto pun
					WHERE pun.CLIE_OID_CLIE = cli.OID_CLIE
						  AND pun.COPA_OID_PARA_GRAL = con.OID_PARA_GRAL
						  AND pun.PERD_OID_PERI = per.oid_peri
						  AND ( pun.TMOV_OID_TIPO_MOVI = 3 OR pun.TMOV_OID_TIPO_MOVI = 1 
						  	  OR ( pun.TMOV_OID_TIPO_MOVI = 2 AND (con.IND_ANUL = 1 OR con.IND_DEVO = 1) ))
				   )) over (PARTITION BY con.oid_para_gral, subg.DES_SUBG_VENT, reg.DES_REGI, zon.DES_ZONA, ter.COD_TERR, cod_clie ORDER BY per.oid_peri, per.fec_inic) puntos_acum 
			FROM inc_concu_param_gener con,
				 inc_param_gener_premi par_pre,
				 mae_clien cli,
				 mae_clien_unida_admin un_adm,
				 mae_clien_tipo_subti subt,
				 mae_clien_clasi cla,
				 zon_terri_admin ter_adm,
				 zon_terri ter,
				 zon_secci sec,
				 zon_zona zon,
				 zon_regio reg,
				 zon_sub_geren_venta subg,
				 cra_perio per_ini,
				 cra_perio per_fin,
				 cra_perio per
			WHERE 
				  par_pre.COPA_OID_PARA_GRAL = con.OID_PARA_GRAL
				  AND un_adm.clie_oid_clie = cli.oid_clie
				  AND un_adm.IND_ACTI = 1
				  AND con.IND_ACTI = 1
				  AND un_adm.ZTAD_OID_TERR_ADMI = ter_adm.OID_TERR_ADMI
				  AND ter_adm.TERR_OID_TERR = ter.OID_TERR
				  AND ter_adm.ZSCC_OID_SECC = sec.OID_SECC
				  AND sec.ZZON_OID_ZONA = zon.OID_ZONA
				  AND zon.ZORG_OID_REGI = reg.OID_REGI
				  AND reg.ZSGV_OID_SUBG_VENT = subg.oid_subg_vent
				  AND con.PERD_OID_PERI_DESD = per_ini.oid_peri
				  AND con.PERD_OID_PERI_HAST = per_fin.oid_peri
				  AND per_ini.fec_inic <= per.fec_inic
				  AND per_fin.fec_fina >= per.fec_fina
				  AND per.pais_oid_pais = con.pais_oid_pais
				  AND per.marc_oid_marc = con.marc_oid_marc
				  AND per.cana_oid_cana = con.cana_oid_cana
				  and subg.oid_subg_vent in (1) --PARAMETRO SUBGERENCIA--
				  and reg.oid_regi in (5) --PARAMETRO REGION--
				  and zon.oid_zona in (6) --PARAMETRO ZONA--
				  and ter_adm.TERR_OID_TERR in (1108) --PARAMETRO TERRITORIO--
--				  AND con.oid_para_gral IN (1123) --PARAMETRO CONCURSO--
				  and con.pais_oid_pais = 1 --PARAMETRO PAIS--
				  and con.marc_oid_marc = 1 --PARAMETRO MARCA--
				  and con.cana_oid_cana = 1 --PARAMETRO CANAL--
				  AND cli.oid_clie = subt.CLIE_OID_CLIE
				  AND subt.OID_CLIE_TIPO_SUBT = cla.CTSU_OID_CLIE_TIPO_SUBT 
				  AND subt.TICL_OID_TIPO_CLIE = 2 --PARAMETRO TIPO DE CLIENTE--
				  AND subt.SBTI_OID_SUBT_CLIE = 1 --PARAMETRO SUBTIPO DE CLIENTE--
				  AND cla.CLAS_OID_CLAS = 1 --PARAMETRO CLASIFICACION--
				  AND cla.TCCL_OID_TIPO_CLASI = 1 --PARAMETRO TIPO DE CLASIFICACION--  
				  AND subt.IND_PPAL = 1
				  AND cla.IND_PPAL = 1
		)
	)
	GROUP BY num_conc,
		   concurso,
		   DES_SUBG_VENT,
		   DES_REGI,
		   DES_ZONA,
		   COD_TERR,
		   periodo_inicial,
		   periodo_final,
		   DECODE(nivel_alcanzado,0,NULL,COD_CLIE),
		   DECODE(nivel_alcanzado,0,NULL,apellido_paterno),
		   DECODE(nivel_alcanzado,0,NULL,apellido_materno),
		   DECODE(nivel_alcanzado,0,NULL,nombres),
		   DECODE(nivel_alcanzado,0,0,nivel_alcanzado),
		   DECODE(nivel_alcanzado,0,NULL,puntos_falt_prox_nivel),
	   	   val_nomb_peri,
		   oid_peri,
	   	   DECODE(nivel_alcanzado,0,0,puntos_acum)
)
	order by num_conc, 
		   concurso,
		   DES_SUBG_VENT,
		   DES_REGI,
		   DES_ZONA,
		   COD_TERR,
		   periodo_inicial,
		   periodo_final,
		   oid_peri,
		   nivel_alcanzado,
		   puntos_acum desc
