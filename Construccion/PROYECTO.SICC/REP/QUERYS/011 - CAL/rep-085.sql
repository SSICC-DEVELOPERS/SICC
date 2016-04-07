select pais, motivo, sum(tipo_cli_1) tipo_cli_1, sum(tipo_cli_2) tipo_cli_2, sum(tipo_cli_3) tipo_cli_3, 
	   sum(tipo_cli_4) tipo_cli_4, sum(tipo_cli_5) tipo_cli_5, sum(tipo_cli_6) tipo_cli_6, sum(pendiente) pendientes,
	   sum(atendida) atendidas, sum(menos_24) menos_24, sum(mas_24_menos_48) mas_24_menos_48, sum(mas_48) mas_48,
	   ROUND(decode(sum(pendiente + atendida),0,0, sum(fin_inicio) / sum(pendiente + atendida)), 2) promedio
from ( 
	select 
		   con.OID_CONT,
		   gen_pais.pais,
		   gen_motivo.motivo,
		   --POR TIPO DE CLIENTE--
		   CASE WHEN (CON.TICL_OID_TIPO_CLIE = 1) THEN		 -- PARAMETRO DE TIPO DE CLIENTE 1 --
		   		1
		   ELSE 
		   		0
		   END TIPO_CLI_1,
		   CASE WHEN (CON.TICL_OID_TIPO_CLIE = 2) THEN		 -- PARAMETRO DE TIPO DE CLIENTE 2 --
		   		1
		   ELSE 
		   		0
		   END TIPO_CLI_2,
   		   CASE WHEN (CON.TICL_OID_TIPO_CLIE = 3) THEN		 -- PARAMETRO DE TIPO DE CLIENTE 3 --
		   		1
		   ELSE
		        0
		   END TIPO_CLI_3,
		   CASE WHEN (CON.TICL_OID_TIPO_CLIE = 4) THEN		 -- PARAMETRO DE TIPO DE CLIENTE 4 --
		   		1
		   ELSE 
		   		0
		   END TIPO_CLI_4,
		   CASE WHEN (CON.TICL_OID_TIPO_CLIE = 5) THEN		 -- PARAMETRO DE TIPO DE CLIENTE 5 --
		   		1
		   ELSE
		   	    0
		   END TIPO_CLI_5,
		   CASE WHEN (CON.TICL_OID_TIPO_CLIE = 6) THEN		 -- PARAMETRO DE TIPO DE CLIENTE 6 --
		   		1
		   ELSE
		        0
		   END TIPO_CLI_6,
		   decode(est.COD_ESTA,'03',1,0) atendida,
		   decode(est.COD_ESTA,'03',0,1)pendiente,
		   --POR TIEMPO DE RESPUESTA--
		   CASE WHEN (EST.COD_ESTA = '03') THEN
		   		CASE WHEN (nvl(trunc((((86400*(DECODE(con.FEC_HORA_CIER, NULL, SYSDATE, con.FEC_HORA_CIER)-con.VAL_HORA_INIC))/60)/60)/24),0) < 1) THEN
					 1
				ELSE
					 0
			    END 
		   ELSE
		   	   0		   	   
		   END MENOS_24,	
		   CASE WHEN (EST.COD_ESTA = '03') THEN
		   		CASE WHEN ((nvl(trunc((((86400*(DECODE(con.FEC_HORA_CIER, NULL, SYSDATE, con.FEC_HORA_CIER)-con.VAL_HORA_INIC))/60)/60)/24),0) >= 1) AND (nvl(trunc((((86400*(DECODE(con.FEC_HORA_CIER, NULL, SYSDATE, con.FEC_HORA_CIER)-con.VAL_HORA_INIC))/60)/60)/24),0) < 2)) THEN
					 1
				ELSE
					 0
			    END 
		   ELSE
		   	   0		   	   
		   END MAS_24_MENOS_48,	
		   CASE WHEN (EST.COD_ESTA = '03') THEN
		   		CASE WHEN (nvl(trunc((((86400*(DECODE(con.FEC_HORA_CIER, NULL, SYSDATE, con.FEC_HORA_CIER)-con.VAL_HORA_INIC))/60)/60)/24),0) >= 2) THEN
					 1
				ELSE
					 0
			    END 
		   ELSE
		   	   0		   	   
		   END MAS_48,	
   		   CON.VAL_HORA_FIN-CON.VAL_HORA_INIC FIN_INICIO
	from cal_conta con,
		 cal_motiv_conta mot,
		 cal_atrib_estad_conta atr,
		 cal_tipo_estad_conta est,
		 (
		 select GEN.VAL_OID, GEN.VAL_I18N MOTIVO
		 from v_gen_i18n_sicc gen
		 where gen.ATTR_ENTI = 'CAL_MOTIV_CONTA'
		 	   and gen.IDIO_OID_IDIO = 1 --PARAMETRO--
		 )gen_motivo,
		 (
		 select gen.VAL_OID, gen.VAL_I18N pais
		 from v_gen_i18n_sicc gen
		 where gen.ATTR_ENTI = 'SEG_PAIS'
		 	   and gen.IDIO_OID_IDIO = 1 --PARAMETRO--
		 )gen_pais
	where con.MOCO_OID_MOTI_CONT = mot.OID_MOTI_CONT
		  and gen_motivo.val_oid(+) = mot.OID_MOTI_CONT
		  and con.ATEC_OID_ATRI_ESTA_CONT = atr.oid_atri_esta_cont
		  and atr.teco_oid_tipo_esta_cont = est.oid_tipo_esta_cont
		  and con.PAIS_OID_PAIS = gen_pais.val_oid(+)
		  and con.PAIS_OID_PAIS = 1 --PARAMETRO--
	--	  and con.MOCO_OID_MOTI_CONT in (1) --PARAMETRO--
		  and con.VAL_HORA_INIC >= to_date('1/1/2003', 'dd/MM/yyyy') --PARAMETRO--
		  and con.VAL_HORA_FIN <= to_date('31/12/2015', 'dd/MM/yyyy') --PARAMETRO--
		  AND CON.TICL_OID_TIPO_CLIE IN (1,2,3,4,5,6) 				  -- PARAMETRO DE TIPO DE CLIENTE --
)
group by pais, motivo
order by motivo
