select periodo, fecha_prev, grupo, region, anio
from (
	select b.VAL_NOMB_PERI as periodo, fecha_prev,  
		  own_peru.rep_002_concat_grup_crono(
		  									 '57,55',		   			   				  -- PARAMETRO --
	   					  	   			     1, 		   			   					  -- PARAMETRO --
											 1, 		   			   					  -- PARAMETRO --
											 1, 		   			   					  -- PARAMETRO --
											 '11,19,20,21,22,13,15,16,17', 		   		  -- PARAMETRO --
											 2004,		   			   					  -- PARAMETRO -- 
											 1		   			   					  	  -- PARAMETRO --
											  ) as grupo,
		  CASE WHEN (decode((select fer.OID_FERI from cra_feria fer 
		  where fer.CACT_OID_ACTI=b.CACT_OID_ACTI
		  	  and fer.CGZO_OID_CABE_GRUP_ZONA=b.OID_CABE_GRUP_ZONA
			  and fer.FEC_FERI=fecha_prev
			  and fer.IND_FEST = 1
			  ),NULL,'NO','SI') = 'SI') THEN 'FERIADO'
		  WHEN (cuantas_regiones > 1) THEN ' '
		  ELSE B.COD_REGI
		  END AS region, b.VAL_ANIO as anio
	from 
	 	(
	  	 select  
		     a.VAL_ANIO, a.oid_peri, a.cod_grup, a.COD_ZONA, a.cod_regi, a.OID_CABE_GRUP_ZONA, a.CACT_OID_ACTI, 
		  	 a.VAL_NOMB_PERI, a.PAIS_OID_PAIS, a.MARC_OID_MARC, a.CANA_OID_CANA, a.ACCE_OID_ACCE, a.OID_ZONA,
			 (
			  select count(distinct reg2.OID_REGI)  
			  from 
				 cra_activ act2,
				 cra_clase_activ cla2,
				 cra_perio per2,
				 cra_cabec_grupo_zona cab2,
				 cra_crono_grupo_zona cro2,
				 cra_detal_grupo_zona det2,
				 zon_zona zon2,
				 zon_regio reg2,
				 seg_perio_corpo cor2
			  where act2.CLAC_OID_CLAS_ACTI=cla2.OID_CLAS_ACTI
				 and cla2.OID_CLAS_ACTI=3 --3 facturacion-- 	---NO PARAMETRO---
				 and act2.CANA_OID_CANA=per2.CANA_OID_CANA
				 and act2.MARC_OID_MARC=per2.MARC_OID_MARC
				 and act2.PAIS_OID_PAIS=per2.PAIS_OID_PAIS
				 and act2.OID_ACTI=cro2.CACT_OID_ACTI
				 and cro2.PERD_OID_PERI=per2.OID_PERI
				 and per2.PERI_OID_PERI=cor2.OID_PERI
				 and cab2.OID_CABE_GRUP_ZONA=cro2.CGZO_OID_CABE_GRUP_ZONA
				 and det2.CGZO_OID_CABE_GRUP_ZONA=cab2.OID_CABE_GRUP_ZONA
				 and det2.zzon_oid_zona=zon2.OID_ZONA
				 and zon2.ZORG_OID_REGI=reg2.OID_REGI
				 and act2.ACCE_OID_ACCE = a.ACCE_OID_ACCE
				 and act2.ACCE_OID_ACCE in (1)		   			  			  -- PARAMETRO -- 
				 and per2.OID_PERI in (57,55)		   			  			  -- PARAMETRO -- 
				 and per2.PAIS_OID_PAIS = 1		   			   				  -- PARAMETRO --
				 and per2.MARC_OID_MARC = 1		   			  			  -- PARAMETRO --
				 and per2.CANA_OID_CANA in (1) 		   			  			  -- PARAMETRO --
				 and zon2.OID_ZONA IN (11,19,20,21,22,13,15,16,17)			  -- PARAMETRO --
			 	 and cor2.VAL_ANIO =2004		   			   				  -- PARAMETRO --
				 and cro2.fec_prev = a.fec_prev 
			  ) cuantas_regiones,
			  (
			   select MIN(gru1.fec_prev)
			   from cra_crono_grupo_zona gru1, 
					cra_cabec_grupo_zona cab1
			   where gru1.PERD_OID_PERI = A.OID_PERI 	
					and gru1.CGZO_OID_CABE_GRUP_ZONA = a.OID_CABE_GRUP_ZONA 
					and gru1.CACT_OID_ACTI = a.CACT_OID_ACTI
					and cab1.PAIS_OID_PAIS = 1 	  			  			   		-- PÁRAMETRO --
					and cab1.MARC_OID_MARC = 1 	  			  			   	-- PÁRAMETRO --
					and cab1.CANA_OID_CANA IN (1) 	  			  			   	-- PÁRAMETRO --
			  ) fecha_prev
		 from 
		 	 (
			 select cor.VAL_ANIO, per.OID_PERI, cro.FEC_PREV, per.VAL_NOMB_PERI,  
				cab.COD_GRUP, zon.COD_ZONA, reg.COD_REGI, CAB.OID_CABE_GRUP_ZONA, act.CACT_OID_ACTI, 
				cab.PAIS_OID_PAIS, cab.MARC_OID_MARC, cab.CANA_OID_CANA, act.ACCE_OID_ACCE, zon.OID_ZONA 
			 from cra_activ act,
				cra_clase_activ cla,
				cra_perio per,
				cra_cabec_grupo_zona cab,
				cra_crono_grupo_zona cro,
				cra_detal_grupo_zona det,
				zon_zona zon,
				zon_regio reg,
				seg_perio_corpo cor
			 where act.CLAC_OID_CLAS_ACTI=cla.OID_CLAS_ACTI
				and cla.OID_CLAS_ACTI=3 --3 facturacion-- ---NO PARAMETRO--- 	
				and act.PAIS_OID_PAIS=per.PAIS_OID_PAIS
				and act.MARC_OID_MARC=per.MARC_OID_MARC
				and act.CANA_OID_CANA=per.CANA_OID_CANA
				and per.PAIS_OID_PAIS = 1			   	  						-- PARAMETROS --
				and per.MARC_OID_MARC=1 			   	  						-- PARAMETROS --
				and per.CANA_OID_CANA in (1) 			   	  					-- PARAMETROS --
				and act.ACCE_OID_ACCE in (1) 			   	  					-- PARAMETROS --
				and per.OID_PERI in (55, 57) 			   	  					-- PARAMETROS --
				and zon.OID_ZONA in (11,19,20,21,22,13,15,16,17) 				-- PARAMETROS --
				and cor.VAL_ANIO=2004 			   	  							-- PARAMETROS --
				and act.OID_ACTI=cro.CACT_OID_ACTI
				and cro.PERD_OID_PERI=per.OID_PERI
				and per.PERI_OID_PERI=cor.OID_PERI
				and cab.OID_CABE_GRUP_ZONA=cro.CGZO_OID_CABE_GRUP_ZONA
				and det.CGZO_OID_CABE_GRUP_ZONA=cab.OID_CABE_GRUP_ZONA
				and det.zzon_oid_zona=zon.OID_ZONA
				and zon.ZORG_OID_REGI=reg.OID_REGI
			)a
		)b
	where fecha_prev is not null
)
group by periodo, fecha_prev, grupo, region, anio
oRDER bY fecha_prev
