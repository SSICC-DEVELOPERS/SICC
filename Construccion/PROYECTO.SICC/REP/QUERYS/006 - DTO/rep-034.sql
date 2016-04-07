select  
	   gen_pais.val_i18n AS pais, 
	   gen_tipo_descu.val_i18n AS tipo_descu, gen_descu.val_i18n AS descuento, des.NUM_DESC,   
	   per.VAL_NOMB_PERI, 
	   count(DISTINCT his.CLIE_OID_CLIE) AS clientes,
	   count(DISTINCT his.SOCA_OID_SOLI_CABE) AS pedidos, 
	   sum(his.VAL_BASE_CALC) AS base_calc, 
	   sum(his.VAL_VENT_REAL) AS venta_real, 
	   DECODE(NVL(SUM(his.VAL_VENT_REAL),0),0,0,SUM(his.IMP_DESC_APLI) / SUM(his.VAL_VENT_REAL)) AS PORC_APLICADO, 
	   sum(his.IMP_DESC_APLI) AS imp_descuento, 
	   (
		SELECT 
			 count(DISTINCT his2.CLIE_OID_CLIE) AS Valor 
		FROM 
			 dto_histo_dto his2,
			 dto_descu des2,
			 dto_matri_descu mat2,
			 cra_perio per2,
			 (
			  select per.FEC_INIC
			  from cra_perio per
			  where per.OID_PERI = 7  						   	--PARAMETRO--
			 )per_desde,
			 (
			  select per.FEC_FINA
			  from cra_perio per
			  where per.OID_PERI = 58 							--PARAMETRO--
			 )per_hasta
		where 
			  	  his2.DCTO_OID_DESC = des2.OID_DESC
			  and des2.MDES_OID_TIPO_DESC = mat2.OID_TIPO_DESC
			  and mat2.OID_TIPO_DESC = mat.OID_TIPO_DESC
			  and des2.PERD_OID_PERI = per2.OID_PERI
--			  and des2.PAIS_OID_PAIS = 1 					   --PARAMETRO--
--			  and mat2.OID_TIPO_DESC in (1011) 				   --PARAMETRO--
--		 	  and des2.NUM_DESC = '1' 						   --PARAMETRO--
--		 	  and des2.MARC_OID_MARC = 1 					   --PARAMETRO--
--		 	  and des2.CANA_OID_CANA = 1 					   --PARAMETRO--
--			  and per2.FEC_INIC >= per_desde.fec_inic 	   	   --PARAMETRO CONDICIONADO--
--			  and per2.FEC_FINA <= per_hasta.fec_fina 		   --PARAMETRO CONDICIONADO--
		GROUP BY 
			  mat2.OID_TIPO_DESC
	   )total_clientes_tipo_desc
from dto_histo_dto his,
	 dto_descu des,
	 dto_matri_descu mat,
	 cra_perio per,
	 (
	  select per.FEC_INIC
	  from cra_perio per
	  where per.OID_PERI = 7  						   				 --PARAMETRO--
	 )per_desde,
	 (
	  select per.FEC_FINA
	  from cra_perio per
	  where per.OID_PERI = 58 										 --PARAMETRO--
	 )per_hasta,
	 (
	  select gen.VAL_OID, gen.VAL_I18N
	  from v_gen_i18n_sicc gen
	  where gen.ATTR_ENTI='SEG_PAIS'
	  		and gen.IDIO_OID_IDIO=1   								 --PARAMETRO--
	 )gen_pais,
	 (
	  select gen.VAL_OID, gen.VAL_I18N
	  from v_gen_i18n_sicc gen
	  where gen.ATTR_ENTI='DTO_DESCU'
	  		and gen.IDIO_OID_IDIO = 1 								 --PARAMETRO--
	 )gen_descu,	 
	 (
	  select gen.VAL_OID, gen.VAL_I18N
	  from v_gen_i18n_sicc gen
	  where gen.ATTR_ENTI='DTO_MATRI_DESCU'
	  		and gen.IDIO_OID_IDIO = 1 	   							 --PARAMETRO--
	 )gen_tipo_descu
where 
	  	  his.DCTO_OID_DESC = des.OID_DESC
	  and des.MDES_OID_TIPO_DESC = mat.OID_TIPO_DESC
	  and des.PERD_OID_PERI = per.OID_PERI
	  and gen_pais.val_oid(+) = des.PAIS_OID_PAIS
	  and gen_tipo_descu.val_oid(+) = mat.OID_TIPO_DESC
	  and gen_descu.val_oid(+) = des.OID_DESC
--	  and des.PAIS_OID_PAIS = 1  			 		   				 --PARAMETRO--
--	  and mat.OID_TIPO_DESC in (1011) 				   				 --PARAMETRO--
--	  and des.NUM_DESC = '1'   						   				 --PARAMETRO--
--	  and des.MARC_OID_MARC = 1 					   				 --PARAMETRO--
--	  and des.CANA_OID_CANA = 1 			 	   	   				 --PARAMETRO--
--	  and per.FEC_INIC >= per_desde.fec_inic 	   	   				 --PARAMETRO CONDICIONADO--
--	  and per.FEC_FINA <= per_hasta.fec_fina 		   				 --PARAMETRO CONDICIONADO--
GROUP BY 
	  gen_pais.val_i18n, 
	  des.NUM_DESC, gen_tipo_descu.val_i18n, gen_descu.val_i18n,  
	  per.VAL_NOMB_PERI, mat.OID_TIPO_DESC
ORDER BY
	  gen_pais.val_i18n, 
	  gen_tipo_descu.val_i18n, 
	  gen_descu.val_i18n, 
	  des.NUM_DESC,
	  per.VAL_NOMB_PERI 
