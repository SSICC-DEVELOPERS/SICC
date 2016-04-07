 SELECT 	gen_comis.val_i18n AS comision, 	subg.des_subg_vent, 	reg.des_regi, 	zon.des_zona, 	sec.des_secci, 	peri.val_nomb_peri AS periodo, 	cli_ger.val_nom1||' '||cli_ger.val_nom2||' '||cli_ger.val_ape1||' '||cli_ger.val_ape2 AS lider, 	cli.cod_clie, 	cli.val_nom1||' '||cli.val_nom2||' '||cli.val_ape1||' '||cli.val_ape2 AS cliente, 	cpt.val_ejer_cuot ||'-'|| cpt.id_cuota AS numero_factura, 	cpt.fec_fech_docu AS fecha_emision, 	cpt.fec_fech_valo AS fecha_pago, 	cpt.fec_fech_valo - cpt.fec_fech_docu AS dif_dias, 	com_cli.imp_mont_paga AS importe_comision, 	cpt.num_impo_pago AS neto_pagado FROM 	com_comis_cobra_acumu_clien com_cli, 	com_comis_cobra_acumu com_acu, 	com_comis com, 	com_cuota_por_tramo_com_calcu cpt, 	zon_sub_geren_venta subg, 	zon_regio reg, 	zon_zona zon, 	zon_secci sec, 	mae_clien cli_ger, 	mae_clien cli, 	cra_perio peri, 	( 	SELECT gen.val_oid, gen.val_i18n 	FROM v_gen_i18n_sicc gen 	WHERE gen.attr_enti = 'COM_COMIS' 	AND gen.idio_oid_idio =  1  	) gen_comis WHERE 	com_acu.oid_comi_cobr_acum = com_cli.coc2_oid_comi_cobr_acum 	AND com_acu.comi_oid_comi = com.oid_comi 	AND com_acu.clie_oid_clie = sec.clie_oid_clie 	AND cpt.actr_oid_comi_cobr_acum = com_cli.oid_comi_cobr_acum  	AND sec.clie_oid_clie(+) = cli_ger.oid_clie 	AND sec.zzon_oid_zona = zon.oid_zona 	AND zon.zorg_oid_regi = reg.oid_regi 	AND reg.zsgv_oid_subg_vent = subg.oid_subg_vent 	AND com_acu.perd_oid_peri =  41  	AND com_acu.perd_oid_peri = peri.oid_peri 	    AND (INSTR( 	    ( 		    CASE WHEN (sec.PERD_OID_PERI_FINA IS NOT NULL) THEN 	   		 	 ( 				  	 SELECT PQ_APL_REP.FN_013_FACDTR_CONCAT_PERI(sec.PERD_OID_PERI_INIC, sec.PERD_OID_PERI_FINA) 					 FROM DUAL 				 ) 	 		  	ELSE 	   		 	 ( 				  	 SELECT PQ_APL_REP.FN_013_FACDTR_CONCAT_PERI(sec.PERD_OID_PERI_INIC,( 																		SELECT * 																		FROM 																			(		 																			SELECT P.OID_PERI     																				FROM CRA_PERIO P        																				WHERE P.MARC_OID_MARC =  1           																				AND P.CANA_OID_CANA = 1     																				AND  P.PAIS_OID_PAIS =  1    																				AND SYSDATE  < = P.FEC_FINA         																				AND SYSDATE >= P.FEC_INIC 																			ORDER BY FEC_FINA DESC 	 																			) 																		WHERE ROWNUM = 1 																		)) 					 FROM DUAL 				 ) 	 			END 		), 			 	    	  	 ','|| 41 ||','					 		) > 0) 	AND gen_comis.val_oid(+) = com.oid_comi 	AND cpt.clie_oid_clie = cli.oid_clie 	 AND sec.oid_secc IN ( 1 )  	 AND zon.oid_zona IN ( 1 )  	 AND reg.oid_regi IN ( 1 )  	AND subg.oid_subg_vent IN ( 1,2,3,4,5,6,7,8,9 ) 	AND subg.cana_oid_cana =  1  	AND subg.marc_oid_marc =  1  	AND subg.pais_oid_pais =  1  	AND com.oid_comi =  1319   