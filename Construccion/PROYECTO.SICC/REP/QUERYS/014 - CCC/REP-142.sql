--ESTE LAYOUT TIENE DOS CRITERIOS DE ORDENACION QUE SE DETALLAN ABAJO--

SELECT GEN_PAIS.VAL_I18N PAIS,
	   GEN_SOCIE.VAL_I18N SOCI,
	   BANCO.COD_BRIO,
	   BANCO.DES_BANC BANCO,
	   CCC_BAN.DES_CC CCC_BANCARIA,
   	   CCC_BAN.COD_CC,
	   MOV_BAN.NUM_LOTE NUM_COMPROBANTE,
	   MOV_BAN.COD_CONS CODIGO,
	   DECODE(MOV_BAN.NUM_FACT_BOLE, NULL, DECODE(MOV_BAN.NUM_CUPO, NULL, MOV_BAN.NUM_CONS_TRAN, MOV_BAN.NUM_CUPO), MOV_BAN.NUM_FACT_BOLE) NUM_CUOTA,
	   DECODE(MOV_BAN.VAL_NUME_DOCU, NULL, MOV_BAN.NUM_CONS_TRAN, MOV_BAN.VAL_NUME_DOCU) NUM_PAGO,
	   MOV_BAN.FEC_PAGO FECHA_VALOR,
	   MOV_BAN.FEC_proc FEC_PROCESO,
	   MOV_BAN.IMP_PAGO IMPORTE	   
FROM CCC_CUENT_CORRI_BANCA CCC_BAN,
	 CCC_MOVIM_BANCA MOV_BAN,
	 CCC_SUCUR SUC,
	 CCC_BANCO BANCO,
	 (
	 SELECT GEN.VAL_OID, GEN.VAL_I18N
	 FROM V_GEN_I18N_SICC GEN
	 WHERE GEN.ATTR_ENTI = 'SEG_PAIS'
	 	   AND GEN.IDIO_OID_IDIO = 1  										-- PARAMETRO DE IDIOMA --
	 ) GEN_PAIS,
 	 (
	 SELECT GEN.VAL_OID, GEN.VAL_I18N
	 FROM V_GEN_I18N_SICC GEN
	 WHERE GEN.ATTR_ENTI = 'SEG_SOCIE'
	 	   AND GEN.IDIO_OID_IDIO = 1  										-- PARAMETRO DE IDIOMA --
	 ) GEN_SOCIE
WHERE MOV_BAN.CCBA_OID_CC_BANC = CCC_BAN.OID_CUEN_CORR_BANC
	  AND CCC_BAN.SUCU_OID_SUCU = SUC.OID_SUCU
	  AND SUC.CBAN_OID_BANC = BANCO.OID_BANC
--	  AND MOV_BAN.COD_IDEN_proc<> 'T'
	  AND CCC_BAN.PAIS_OID_PAIS = GEN_PAIS.VAL_OID(+)
	  AND CCC_BAN.SOCI_OID_SOCI = GEN_SOCIE.VAL_OID(+)
	  AND TO_DATE(MOV_BAN.FEC_proc)<= TO_DATE('01/01/2050','DD/MM/YYYY') -- PARAMETRO DE FECHA HASTA --
	  AND TO_DATE(MOV_BAN.FEC_proc)>= TO_DATE('01/01/2000','DD/MM/YYYY') -- PARAMETRO DE FECHA DESDE -- 
--	  AND CCC_BAN.PAIS_OID_PAIS = 1						   			-- PARAMETRO DE PAIS --
--	  AND BANCO.OID_BANC IN (1)   									-- PARAMETRO DE BANCO --
--	  AND CCC_BAN.OID_CUEN_CORR_BANC IN (1)							-- PARAMETRO DE CUENTA CORRIENTE BANCARIA --
ORDER BY CODIGO
--ORDER BY FECHA_VALOR
