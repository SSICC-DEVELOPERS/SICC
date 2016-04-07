select pais,
	   DECODE(desc_area,NULL,'Z - SIN AREA DE SEGUIMIENTO',desc_area) desc_area,  sum(tipo_cli_1)tipo_cli_1, sum(tipo_cli_2)tipo_cli_2, sum(tipo_cli_3)tipo_cli_3, 
	   sum(tipo_cli_4)tipo_cli_4, sum(tipo_cli_5)tipo_cli_5, sum(tipo_cli_6)tipo_cli_6, sum(pendiente)pendientes,
	   sum(atendida) atendidas, sum(menos_24) menos_24, sum(mas_24_menos_48) mas_24_menos_48, sum(mas_48) mas_48, 
	   decode(sum(pendiente + atendida),0,0, sum(fin_inicio) / sum(pendiente + atendida))promedio,
	   count(oid_cont)total	   
from ( 
	select gen_pai.pais,
		   oid_cont, cal_cab_buz.oid_cabe_buzo, cal_det_buz.OID_DETA_BUZO, 
		   cal_cab_buz.val_desc_cabe_buzo desc_area,
		   (
		   select 1 
		   from cal_motiv_tipo_clien mot_tipo_cli,
		   		mae_tipo_clien tipo_cli
		   where mot_tipo_cli.moco_oid_moti_cont = mot.OID_MOTI_CONT
			   and mot_tipo_cli.ticl_oid_tipo_clie = tipo_cli.OID_TIPO_CLIE 
			   and tipo_cli.OID_TIPO_CLIE = 1 --PARAMETRO--
		   )tipo_cli_1,
	   	   (
		   select 1 
		   from cal_motiv_tipo_clien mot_tipo_cli,
		   		mae_tipo_clien tipo_cli
		   where mot_tipo_cli.moco_oid_moti_cont = mot.OID_MOTI_CONT
			   and mot_tipo_cli.ticl_oid_tipo_clie = tipo_cli.OID_TIPO_CLIE 
			   and tipo_cli.OID_TIPO_CLIE = 2 --PARAMETRO--
		   )tipo_cli_2,
	   	   (
		   select 1 
		   from cal_motiv_tipo_clien mot_tipo_cli,
		   		mae_tipo_clien tipo_cli
		   where mot_tipo_cli.moco_oid_moti_cont = mot.OID_MOTI_CONT
		   	   and mot_tipo_cli.ticl_oid_tipo_clie = tipo_cli.OID_TIPO_CLIE 
		   	   and tipo_cli.OID_TIPO_CLIE = 3 --PARAMETRO--
		   )tipo_cli_3,
	   	   (
		   select 1 
		   from cal_motiv_tipo_clien mot_tipo_cli,
		   		mae_tipo_clien tipo_cli
		   where mot_tipo_cli.moco_oid_moti_cont = mot.OID_MOTI_CONT
		   	   and mot_tipo_cli.ticl_oid_tipo_clie = tipo_cli.OID_TIPO_CLIE 
		   	   and tipo_cli.OID_TIPO_CLIE = 4 --PARAMETRO--
		   )tipo_cli_4,
	   	   (
		   select 1 
		   from cal_motiv_tipo_clien mot_tipo_cli,
		   		mae_tipo_clien tipo_cli
		   where mot_tipo_cli.moco_oid_moti_cont = mot.OID_MOTI_CONT
			   and mot_tipo_cli.ticl_oid_tipo_clie = tipo_cli.OID_TIPO_CLIE 
			   and tipo_cli.OID_TIPO_CLIE = 5 --PARAMETRO--
		   )tipo_cli_5,
		   (
		   select 1 
		   from cal_motiv_tipo_clien mot_tipo_cli,
		   		mae_tipo_clien tipo_cli
		   where mot_tipo_cli.moco_oid_moti_cont = mot.OID_MOTI_CONT
		   and mot_tipo_cli.ticl_oid_tipo_clie = tipo_cli.OID_TIPO_CLIE 
		   and tipo_cli.OID_TIPO_CLIE = 6 --PARAMETRO--
		   )tipo_cli_6,
		   decode(est.COD_ESTA,'03',1,0) atendida,
		   decode(est.COD_ESTA,'03',0,1) pendiente,
		   --POR TIEMPO DE RESPUESTA--
		   (
		   select 1
		   from cal_conta conta2,
		   		cal_atrib_estad_conta atr2,
				cal_tipo_estad_conta est2
		   where conta2.OID_CONT = con.OID_CONT
		   and nvl(trunc((((86400*(DECODE(conta2.FEC_HORA_CIER, NULL, SYSDATE, conta2.FEC_HORA_CIER)-conta2.VAL_HORA_INIC))/60)/60)/24),0) < 1
		   		  and conta2.ATEC_OID_ATRI_ESTA_CONT = atr2.oid_atri_esta_cont
				  and atr2.teco_oid_tipo_esta_cont = est2.oid_tipo_esta_cont
				  and est.COD_ESTA = '03'
		   ) menos_24,
		   (
		   select 1
		   from cal_conta conta2,
		   		cal_atrib_estad_conta atr2,
				cal_tipo_estad_conta est2
		   where conta2.OID_CONT = con.OID_CONT
		   		 and nvl(trunc((((86400*(DECODE(conta2.FEC_HORA_CIER, NULL, SYSDATE, conta2.FEC_HORA_CIER)-conta2.VAL_HORA_INIC))/60)/60)/24),0) >= 1 
				 and nvl(trunc((((86400*(DECODE(conta2.FEC_HORA_CIER, NULL, SYSDATE, conta2.FEC_HORA_CIER)-conta2.VAL_HORA_INIC))/60)/60)/24),0) < 2
				 and conta2.ATEC_OID_ATRI_ESTA_CONT = atr2.oid_atri_esta_cont
				 and atr2.teco_oid_tipo_esta_cont = est2.oid_tipo_esta_cont
				 and est.COD_ESTA = '03'
			) mas_24_menos_48,
		   (
		   select 1
		   from cal_conta conta2,
		   		cal_atrib_estad_conta atr2,
				cal_tipo_estad_conta est2
		   where conta2.OID_CONT = con.OID_CONT
		   		 and nvl(trunc((((86400*(DECODE(conta2.FEC_HORA_CIER, NULL, SYSDATE, conta2.FEC_HORA_CIER)-conta2.VAL_HORA_INIC))/60)/60)/24),0) >= 2 
				 and conta2.ATEC_OID_ATRI_ESTA_CONT = atr2.oid_atri_esta_cont
				 and atr2.teco_oid_tipo_esta_cont = est2.oid_tipo_esta_cont
				 and est.COD_ESTA = '03'
		   ) mas_48,
		    Trunc(((86400*(DECODE(con.VAL_HORA_FIN, NULL, CON.VAL_HORA_INIC, con.VAL_HORA_FIN)-con.VAL_HORA_INIC))/60)/60)-24*(trunc((((86400*(DECODE(con.VAL_HORA_FIN, NULL, CON.VAL_HORA_INIC, con.VAL_HORA_FIN) - con.VAL_HORA_INIC))/60)/60)/24)) fin_inicio		   
from cal_conta con,
		 cal_motiv_conta mot,
		 cal_atrib_estad_conta atr,
		 cal_tipo_estad_conta est,
		 cal_cabec_buzon cal_cab_buz,
		 cal_detal_buzon cal_det_buz,
		 (
		 select gen.val_oid, gen.val_i18n pais
		 from v_gen_i18n_sicc gen
		 where gen.ATTR_ENTI = 'SEG_PAIS'
		 	   and gen.idio_oid_idio = 1 --PARAMETRO--
		 )gen_pai
	where con.MOCO_OID_MOTI_CONT = mot.OID_MOTI_CONT
	--	  and mot.COD_MOTI = '00'	
--		  and con.COD_OPER = 'USUARIO1' --PARAMETRO--
		  and con.ATEC_OID_ATRI_ESTA_CONT = atr.oid_atri_esta_cont
		  and atr.teco_oid_tipo_esta_cont = est.oid_tipo_esta_cont
--		  and con.PAIS_OID_PAIS = 1 --PARAMETRO--
		  and con.VAL_HORA_INIC >= to_date('1/1/2003', 'dd/MM/yyyy') --PARAMETRO--
		  and con.VAL_HORA_FIN <= to_date('31/12/2015', 'dd/MM/yyyy') --PARAMETRO--
		  and cal_det_buz.CABU_OID_CABE_BUZO = cal_cab_buz.oid_cabe_buzo(+)
--	      and cal_cab_buz.cod_buzo = 'BBB' --PARAMETRO--
		  and cal_det_buz.CONT_OID_CONT(+) = con.OID_CONT
		  and con.pais_oid_pais = gen_pai.val_oid(+)
)
group by pais,
	  desc_area
order by desc_area