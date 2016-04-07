select
	  oid_regi,
	  DES_REGI,
	  OID_OPER,
	  operacion,
	  periodo_n,
	  periodo_n_1,
	  periodo_n_2,
	  periodo_n_3,
	  sum(unidades_reclamadas)unidades_reclamadas,
	  sum(unidades_n)unidades_n,
	  sum(unidades_n_1)unidades_n_1,
	  sum(unidades_n_2)unidades_n_2,
	  sum(unidades_n_3)unidades_n_3
from 
	(
		select 
			   reg.oid_regi,
			   reg.DES_REGI,
			   op.OID_OPER,
			   gen_op.operacion,
			   nvl(sum(lin_rec.NUM_UNID_RECL),0)unidades_reclamadas,
			   per2.val_nomb_peri as periodo_n,
			   decode(op_rec.PERD_OID_PERI_RECL, op_rec.PERD_OID_PERI, sum(lin_rec.NUM_UNID_RECL),0) unidades_n,
			   periodos.periodo_n_1,
   			   decode(own_peru.fn_112_calc_per_ant (cab_rec.pais_oid_pais, per.marc_oid_marc, per.cana_oid_cana,op_rec.PERD_OID_PERI_RECL, op_rec.PERD_OID_PERI),2,nvl(sum(lin_rec.NUM_UNID_RECL),0),0)unidades_n_1,
			   periodos.periodo_n_2,
			   decode(own_peru.fn_112_calc_per_ant (cab_rec.pais_oid_pais, per.marc_oid_marc, per.cana_oid_cana,op_rec.PERD_OID_PERI_RECL, op_rec.PERD_OID_PERI),3,nvl(sum(lin_rec.NUM_UNID_RECL),0),0)unidades_n_2,
			   periodos.periodo_n_3,
			   case
			   	   when own_peru.fn_112_calc_per_ant (cab_rec.pais_oid_pais, per.marc_oid_marc, per.cana_oid_cana,op_rec.PERD_OID_PERI_RECL, op_rec.PERD_OID_PERI) >= 4 then
				   		nvl(sum(lin_rec.NUM_UNID_RECL),0)
				   else
				   	   0
				end as unidades_n_3
		from
			rec_cabec_recla cab_rec,
			rec_opera_recla op_rec,
			rec_linea_opera_recla lin_rec,
			rec_tipos_opera t_op,
			rec_opera op,
			zon_terri_admin ter_adm,
			zon_secci sec,
			zon_zona zon,
			zon_regio reg,
			cra_perio per,
			cra_perio per2,
			(
			 select val_oid, val_i18n operacion
			 from v_gen_i18n_sicc
			 where attr_enti = 'REC_OPERA'
			 	   and idio_oid_idio = 1 --PARAMETRO IDIOMA--
			)gen_op,
			--CALCULA LOS PERIODOS ANTERIORES------------------------------------------------------------------
			(
			select 
				(
					select val_nomb_peri
					from 
					(
					select C.OID_PERI, c.val_nomb_peri, c.fec_inic, rownum as pos								 
					from
						(
						 select * 
						 from cra_perio
						 order by fec_fina desc
						) c,	 										 
						 ( 														 
						  select ci.oid_peri, ci.fec_fina						 
						  from cra_perio ci	  									 
						  where ci.oid_peri = 1384				 
						 ) f 				  									 
					where 														 
						  c.fec_fina < f.fec_fina							 
						 and c.pais_oid_pais = 1							 
						 and c.marc_oid_marc = 1								 
						 and c.cana_oid_cana = 1
					)
					where pos = 1
				)periodo_n_1,
				(
					select val_nomb_peri
					from 
					(
					select C.OID_PERI, c.val_nomb_peri, c.fec_inic, rownum as pos								 
					from
						(
						 select * 
						 from cra_perio
						 order by fec_fina desc
						) c,	 										 
						 ( 														 
						  select ci.oid_peri, ci.fec_fina						 
						  from cra_perio ci	  									 
						  where ci.oid_peri = 1384				 
						 ) f 				  									 
					where 														 
						  c.fec_fina < f.fec_fina							 
						 and c.pais_oid_pais = 1							 
						 and c.marc_oid_marc = 1								 
						 and c.cana_oid_cana = 1
					)
					where pos = 2
				)periodo_n_2,
				(
					select val_nomb_peri
					from 
					(
					select C.OID_PERI, c.val_nomb_peri, c.fec_inic, rownum as pos								 
					from
						(
						 select * 
						 from cra_perio
						 order by fec_fina desc
						) c,	 										 
						 ( 														 
						  select ci.oid_peri, ci.fec_fina						 
						  from cra_perio ci	  									 
						  where ci.oid_peri = 1384				 
						 ) f 				  									 
					where 														 
						  c.fec_fina < f.fec_fina							 
						 and c.pais_oid_pais = 1							 
						 and c.marc_oid_marc = 1								 
						 and c.cana_oid_cana = 1
					)
					where pos = 3
				)periodo_n_3
			from dual
			)periodos
			---------------------------------------------------------------------------------------------------
		where
			 cab_rec.OID_CABE_RECL = op_rec.CARE_OID_CABE_RECL
			 and op_rec.OID_OPER_RECL = lin_rec.OPRE_OID_OPER_RECL
			 and op_rec.TIOP_OID_TIPO_OPER = t_op.OID_TIPO_OPER
			 and t_op.ROPE_OID_OPER = op.oid_oper
			 --------------------------------------------------------------------------------------------------
			 and cab_rec.ZTAD_OID_TERR_ADMI = ter_adm.oid_terr_admi
			 and ter_adm.ZSCC_OID_SECC = sec.oid_secc
			 and sec.ZZON_OID_ZONA = zon.oid_zona
			 and zon.ZORG_OID_REGI = reg.oid_regi
			 --------------------------------------------------------------------------------------------------
			 and op_rec.PERD_OID_PERI_RECL = per.oid_peri
			 and op_rec.PERD_OID_PERI = per2.oid_peri
			 and per.FEC_FINA < per2.fec_fina
			 and op.OID_OPER = gen_op.val_oid(+)
--			 and per.oid_peri  = 1384 --PARAMETRO PERIODO--
			 and per.marc_oid_marc in (1) --PARAMETRO MARCA--
			 and per.cana_oid_cana in (1) --PARAMETRO CANAL--
			 and cab_rec.pais_oid_pais = 1 --PARAMETRO PAIS--
--			 and op.oid_oper = 1154 --PARAMETRO OPERACION--
 			 and per.marc_oid_marc = per2.marc_oid_marc  
			 and per.cana_oid_cana = per2.cana_oid_cana
			 and per.pais_oid_pais = per2.pais_oid_pais
			 and cab_rec.pais_oid_pais = per2.pais_oid_pais
		group by
			  reg.oid_regi,
			  reg.DES_REGI,
			  per.VAL_NOMB_PERI,
			  op_rec.PERD_OID_PERI_RECL,
			  op_rec.PERD_OID_PERI,
			  gen_op.operacion,
			  cab_rec.pais_oid_pais,
			  per.marc_oid_marc,
			  per.cana_oid_cana,
			  per.oid_peri,
			  op.OID_OPER,
			  per2.val_nomb_peri
	)
group by
	  oid_regi,
	  DES_REGI,
	  OID_OPER,
	  operacion,
  	  periodo_n,
	  periodo_n_1,
	  periodo_n_2,
	  periodo_n_3
order by DES_REGI,
	  operacion			 