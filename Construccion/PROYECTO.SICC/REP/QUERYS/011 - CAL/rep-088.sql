select gen_pais.val_i18n Pais, cab.COD_BUZO, cab.val_desc_cabe_buzo Desc_Buzon, cli.COD_CLIE,
       usu.apellidopaterno||' '||usu.apellidomaterno||' '||usu.nombre1||' ' ||usu.nombre2 as NOMBRE_CLIE,
	   det.COD_ACTI, det.VAL_DESC_ACTI, det.FEC_HORA_CREA, to_char(det.FEC_HORA_CREA, 'HH24:MI:SS'),  
	   trunc((((86400*(SYSDATE - det.FEC_HORA_CREA))/60)/60)/24) Dias_Pendientes,
	   con.COD_CONT Contactos, 1 as CANTIDAD
from cal_cabec_buzon cab,
	 cal_detal_buzon det,
	 cal_conta con,
	 cal_estat_activ_conta act,
	 mae_clien cli,
	 own_mare.v_usu_largo usu,
	 (select gen.VAL_OID, gen.VAL_I18N                  -- TRAEMOS DESCRIPCION DE PAIS PARA EL IDIOMA -- 
	  from v_gen_i18n_sicc gen
	  where gen.attr_enti = 'SEG_PAIS'
	  		and gen.IDIO_OID_IDIO = 1   --PARAMETRO--
	 ) gen_pais
where con.OID_CONT = det.CONT_OID_CONT(+)                
	  and cab.OID_CABE_BUZO = det.CABU_OID_CABE_BUZO  
	  and cab.PAIS_OID_PAIS = 1 --PARAMETRO--          
	  and con.VAL_HORA_INIC >= to_date('1/1/2003', 'dd/MM/yyyy') --PARAMETRO--
	  and con.VAL_HORA_FIN <= to_date('31/12/2015', 'dd/MM/yyyy') --PARAMETRO--
--	  and cab.OID_CABE_BUZO = 1 --PARAMETRO--
	  AND CLI.COD_CLIE = 1  --PARAMETRO CODIGO DE CLIENTE--
	  and det.ESAC_OID_ESTA_ACTI_CONT = act.OID_ESTA_ACTI_CONT
--      and act.COD_ESTA = 'N'    
	  and con.CLIE_OID_CLIE = cli.OID_CLIE 
	  and con.COD_OPER = usu.nombreusuario
	  and gen_pais.val_oid = cab.PAIS_OID_PAIS
order by gen_pais.val_oid, cab.COD_BUZO, det.FEC_HORA_CREA, cli.cod_clie

