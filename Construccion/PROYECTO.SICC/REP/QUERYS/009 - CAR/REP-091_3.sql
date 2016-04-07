SELECT 
	  PERI.VAL_NOMB_PERI, GEN_CANA.CANAL, PERI.FEC_INIC, PERI.FEC_FINA,
	  REGI.COD_REGI, 
	  ZONA.COD_ZONA, 
	  (CLIEN.COD_CLIE ||' '|| CLIEN.VAL_APE1 ||' '|| CLIEN.VAL_APE2 ||' '|| CLIEN.VAL_NOM1 ||' '|| CLIEN.VAL_NOM2) AS CLIENTE,
	  RIESGO.COD_NIVE_RIES,
	  T_SOLIC.COD_TIPO_SOLI,
	  SOL_ESTADO.COD_ESTA_SOLI,
 	  GEN_ESTADO_EVAL_AUTO.ESTADO_EVAL_AUTO,
	  (
	   DECODE(SOL_ENTR.IND_VALI_1,1,'B1 ','') || 
	   DECODE(SOL_ENTR.IND_VALI_2,1,'B2 ','') || 
	   DECODE(SOL_ENTR.IND_VALI_3,1,'B3 ','') || 
	   DECODE(SOL_ENTR.IND_VALI_4,1,'B4 ','')
	  ) AS MOTIVO,
	  SOL_ENTR.FEC_DOCU,
 	  GEN_ESTADO_FINAL.ESTADO_FINAL,
	  COD.COD_APRO,
	  DECODE(SOL_ENTR.IND_NOTI,1,'Si', 'No') AS INFORME_GZ,
	  SOL_ENTR.FEC_HORA_LIBE,
	  (
	   CLIEN_ADICI.IMP_MONT_LINE_CRED -
	   own_peru.CU_CALC_MONTO_SOLIC_NUEVAS(SOL_ENTR.CLIE_OID_CLIE) -
	   own_peru.CU_CALC_SALDO_CTA_CTE(SOL_ENTR.CLIE_OID_CLIE) +
	   own_peru.CU_CALC_CUPON_EN_TRAMITE(SOL_ENTR.PAIS_OID_PAIS, SOL_ENTR.CLIE_OID_CLIE)
	  ) AS LCD,
	  USUARIO.NOMBREUSUARIO AS REPRES_CRED,
	  CLIEN_ADICI.IMP_MONT_LINE_CRED AS LC,
	  SOL_CAB.VAL_NUME_SOLI,
	  SOL_ENTR.VAL_MONT_ORDE,
	  USUARIO_LIBERACION.NOMBREUSUARIO AS USUARIO
FROM
	  CAR_SOLI_ENTR_BLOQ SOL_ENTR,
	  PED_TIPO_SOLIC T_SOLIC,
	  CAR_NIVEL_RIESG RIESGO,
	  CRA_PERIO PERI,
	  ZON_ZONA ZONA,
	  ZON_REGIO REGI,
	  ZON_SUB_GEREN_VENTA SUBGV,
	  SEG_SUBAC SUBACC,
	  SEG_ACCES ACC,
	  MAE_CLIEN CLIEN,
	  MAE_CLIEN_DATOS_ADICI CLIEN_ADICI,
	  CAR_EJECU_CUENT EJECTA,
	  own_mare.V_USU_LARGO USUARIO,
	  CAR_EJECU_CUENT EJECTA_LIBERACION,
	  own_mare.V_USU_LARGO USUARIO_LIBERACION,
	  PED_SOLIC_CABEC SOL_CAB,
	  CAR_CODIG_APROB COD, 
	  PED_ESTAD_SOLIC SOL_ESTADO,
	  (
	   SELECT GEN.VAL_OID, GEN.VAL_I18N AS ESTADO_EVAL_AUTO
	   FROM V_GEN_I18N_SICC GEN
	   WHERE GEN.ATTR_ENTI = 'CAR_ESTAT_PEDID' 
			  AND GEN.IDIO_OID_IDIO = 1		 	 		 				  -- PARAMETRO --
	  ) GEN_ESTADO_EVAL_AUTO,
	  (
	   SELECT GEN.VAL_OID, GEN.VAL_I18N AS ESTADO_FINAL
	   FROM V_GEN_I18N_SICC GEN
	   WHERE GEN.ATTR_ENTI = 'CAR_ESTAT_PEDID' 
			  AND GEN.IDIO_OID_IDIO = 1		 	 		 				  -- PARAMETRO --
	  ) GEN_ESTADO_FINAL,
	  (
	   SELECT GEN.VAL_OID, GEN.VAL_I18N AS CANAL
	   FROM V_GEN_I18N_SICC GEN
	   WHERE GEN.ATTR_ENTI = 'SEG_CANAL'
	  		AND GEN.IDIO_OID_IDIO = 1 		   							  --PARAMETRO--
	  )GEN_CANA
WHERE
	      SOL_ENTR.PERD_OID_PERI = PERI.OID_PERI
	  AND SOL_ENTR.ZZON_OID_ZONA = ZONA.OID_ZONA
	  AND ZONA.ZORG_OID_REGI = REGI.OID_REGI
	  AND REGI.ZSGV_OID_SUBG_VENT = SUBGV.OID_SUBG_VENT 
	  AND SOL_ENTR.TSOL_OID_TIPO_SOLI = T_SOLIC.OID_TIPO_SOLI
	  AND SOL_ENTR.NIRI_OID_NIVE_RIES = RIESGO.OID_NIVE_RIES
	  AND SOL_ENTR.SBAC_OID_SBAC = SUBACC.OID_SBAC
	  AND SUBACC.ACCE_OID_ACCE = ACC.OID_ACCE
	  AND SOL_ENTR.CLIE_OID_CLIE = CLIEN.OID_CLIE
	  AND SOL_ENTR.CLIE_OID_CLIE = CLIEN_ADICI.CLIE_OID_CLIE(+)
	  AND SOL_ENTR.SOCA_OID_SOLI_CABE = SOL_CAB.OID_SOLI_CABE
	  AND SOL_ENTR.COAP_OID_CODI_APRO = COD.OID_CODI_APRO(+)
	  AND SOL_CAB.ESSO_OID_ESTA_SOLI = SOL_ESTADO.OID_ESTA_SOLI
	  AND PERI.CANA_OID_CANA = GEN_CANA.VAL_OID(+)
	  AND SOL_ENTR.ESPE_OID_ESTA_PEDI= GEN_ESTADO_EVAL_AUTO.VAL_OID(+)
	  AND SOL_CAB.ESPE_OID_ESTA_PEDI = GEN_ESTADO_FINAL.VAL_OID(+)
	  AND SOL_ENTR.EJCU_OID_EJEC_CUEN = EJECTA.OID_EJEC_CUEN
	  AND EJECTA.USER_EJEC_CUEN  = USUARIO.IDUSUARIO(+)
	  AND SOL_ENTR.EJCU_OID_USUA_LIBE= EJECTA_LIBERACION.OID_EJEC_CUEN
	  AND EJECTA_LIBERACION.USER_EJEC_CUEN  = USUARIO_LIBERACION.IDUSUARIO(+)
------------------------------------------------------------
--	  AND PERI.PAIS_OID_PAIS = 1 							   	  	  	  			   --PARAMETRO--
--	  AND SUBGV.OID_SUBG_VENT = 1  													   --PARAMETRO--
--	  AND PERI.MARC_OID_MARC = 1 													   --PARAMETRO--
--	  AND PERI.CANA_OID_CANA = 1 													   --PARAMETRO--
--	  AND ACC.OID_ACCE = 1 	   														   --PARAMETRO--
--	  AND PERI.OID_PERI = 57 --54--40 												   --PARAMETRO--
--	  AND SOL_ENTR.TSOL_OID_TIPO_SOLI IN (72, 1433,10,67,1384,1,2,3,4,5,65) 		   --PARAMETRO--
--	  AND REGI.OID_REGI IN (1,2,3,4,5,6,7,8,9,10) 									   --PARAMETRO--
--	  AND ZONA.OID_ZONA IN (1,2,3,4,5,6,7,8,9,10,11,12,13,14) 						   --PARAMETRO--
--	  AND SOL_CAB.ESSO_OID_ESTA_SOLI=1 											   --PARAMETRO--
--	  AND SOL_ENTR.ESPE_OID_ESTA_PEDI = 1					  						   --PARAMETRO--
--	  AND EJECTA.USER_EJEC_CUEN = 1	 												   --PARAMETRO--
--	  AND SOL_ENTR.NIRI_OID_NIVE_RIES = 1 											   --PARAMETRO--
--	  AND (DECODE(SOL_ENTR.IND_VALI_1,1,'B1 ','') || DECODE(SOL_ENTR.IND_VALI_2,1,'B2 ','') || DECODE(SOL_ENTR.IND_VALI_3,1,'B3 ','') || DECODE(SOL_ENTR.IND_VALI_4,1,'B4 ','')) = 'B1 B2 B3 B4 '
--	  AND SOL_ENTR.COAP_OID_CODI_APRO =1 		  	 								   --PARAMETRO--
--	  AND SOL_ENTR.IND_NOTI = 1		  												   --PARAMETRO--
ORDER BY
	  PERI.VAL_NOMB_PERI,  
	  EJECTA.USER_EJEC_CUEN, 
	  RIESGO.COD_NIVE_RIES,
	  CLIEN_ADICI.IMP_MONT_LINE_CRED,
	  SOL_ENTR.VAL_MONT_ORDE
	  	  
