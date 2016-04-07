SELECT 
	  I18PAIS.VAL_I18N PAIS, MARCA.DES_MARC as MARCA, I18CANAL.VAL_I18N CANAL, PERI.VAL_NOMB_PERI as CAMPANIA, 
	  OFE.NUM_OFER, OFEDET.VAL_CODI_VENT, PROD.COD_SAP, I18PROD.VAL_I18N as DESC_PROD, 
	  I18EST.VAL_I18N ESTRATEGIA, CIVI.COD_CICL_VIDA || '/' || TOFE.COD_TIPO_OFER AS CICLO_OFERTA,  
	  CAT.COD_CATA, OFEDET.NUM_PAGI_CATA,
	  OFEDET.VAL_FACT_REPE, FP.COD_FORM_PAGO FORMAPAGO,
	  (SELECT GOF.NUM_GRUP
	   FROM PRE_GRUPO_OFERT GOF
	   WHERE OFEDET.GOFE_OID_GRUP_OFER = GOF.OID_GRUP_OFER) AS NUM_GRUP,
	  (SELECT IC.COD_INDI_CUAD
	   FROM PRE_INDIC_CUADR IC,PRE_INDIC_CUADR_TIPO_ESTRA ICTE
	   WHERE  ICTE.INDC_OID_INDI_CUAD = IC.OID_IND_CUAD
	   		  AND  ICTE.OID_IND_CUAD_TIPO_ESTR  = (SELECT GOF.CUES_OID_IND_CUAD_TIPO_ESTR 
		 	  							   	  	   FROM PRE_GRUPO_OFERT GOF
											  	   WHERE OFEDET.GOFE_OID_GRUP_OFER = GOF.OID_GRUP_OFER)
	  ) COD_INDI_CUAD,
	  (SELECT GOF.COD_FACT_CUAD
	    FROM PRE_GRUPO_OFERT GOF
		WHERE OFEDET.GOFE_OID_GRUP_OFER = GOF.OID_GRUP_OFER) AS COD_FACT_CUAD,		
	  DECODE(OFE.IND_DESP_COMPL,1, 'SI', 'NO') IND_DESP_COMPL, ACC.COD_ACCE,
	  DECODE(VTAEX.OFER_OID_OFER,NULL,0,1) AS INDVTAEX, 
	  I18TCLIEN.VAL_I18N AS TCLIEN, I18STCLIEN.VAL_I18N AS STCLIEN, I18TCLASI.VAL_I18N AS TCLASI, I18CLASI.VAL_I18N AS CLASI,
	  OFEDET.IMP_PREC_CATA, OFEDET.IMP_PREC_POSI,
	  DECODE(ES.TIES_OID_TIPO_ESTR,2,OFEDET.IMP_PREC_CATA,0) IMP_COMPUESTA_FIJA
FROM
	  (
	  SELECT V.VAL_OID, V.VAL_I18N 
	  FROM V_GEN_I18N_SICC V 
	  WHERE V.ATTR_ENTI = 'MAE_PRODU'
	  AND V.IDIO_OID_IDIO = 1		 	 		 -- PARAMETRO --
	  ) I18PROD,
	  (
	  SELECT V.VAL_OID, V.VAL_I18N 
	  FROM V_GEN_I18N_SICC V 
	  WHERE V.ATTR_ENTI = 'PRE_ESTRA'
	  AND V.IDIO_OID_IDIO = 1		 	 		 -- PARAMETRO --
	  ) I18EST,
	  (
	  SELECT V.VAL_OID, V.VAL_I18N 
	  FROM V_GEN_I18N_SICC V 
	  WHERE V.ATTR_ENTI = 'MAE_TIPO_CLIEN'
	  AND V.IDIO_OID_IDIO = 1		 	 		 -- PARAMETRO --
	  ) I18TCLIEN,
	  (
	  SELECT V.VAL_OID, V.VAL_I18N 
	  FROM V_GEN_I18N_SICC V 
	  WHERE V.ATTR_ENTI =  'MAE_SUBTI_CLIEN'
	  AND V.IDIO_OID_IDIO = 1		 	 		 -- PARAMETRO --
	  ) I18STCLIEN,
	  (
	  SELECT V.VAL_OID, V.VAL_I18N 
	  FROM V_GEN_I18N_SICC V 
	  WHERE V.ATTR_ENTI = 'MAE_TIPO_CLASI_CLIEN' 
	  AND V.IDIO_OID_IDIO = 1		 	 		 -- PARAMETRO --
	  ) I18TCLASI,
	  (
	  SELECT V.VAL_OID, V.VAL_I18N 
	  FROM V_GEN_I18N_SICC V 
	  WHERE V.ATTR_ENTI = 'MAE_CLASI' 
	  AND V.IDIO_OID_IDIO = 1		 	 		 -- PARAMETRO --
	  ) I18CLASI,
	  (
	  SELECT V.VAL_OID, V.VAL_I18N 
	  FROM V_GEN_I18N_SICC V 
	  WHERE V.ATTR_ENTI = 'SEG_PAIS' 
	  AND V.IDIO_OID_IDIO = 1		 	 		 -- PARAMETRO --
	  ) I18PAIS,
	  (
	  SELECT V.VAL_OID, V.VAL_I18N 
	  FROM V_GEN_I18N_SICC V 
	  WHERE V.ATTR_ENTI = 'SEG_CANAL' 
	  AND V.IDIO_OID_IDIO = 1		 	 		 -- PARAMETRO --
	  ) I18CANAL,
	  CRA_PERIO PERI,
	  PRE_OFERT OFE,
	  PRE_OFERT_DETAL OFEDET,
	  PRE_MATRI_FACTU MF,
	  PRE_MATRI_FACTU_CABEC MFC,
	  MAE_PRODU PROD,
	  BEL_FORMA_PAGO FP,
	  PRE_ESTRA ES,
	  PRE_CATAL CAT,
	  SEG_MARCA MARCA,
	  PRE_CICLO_VIDA CIVI,
	  PRE_TIPO_OFERT TOFE,
	  SEG_ACCES ACC,
	  PRE_VENTA_EXCLU VTAEX
WHERE
	      PERI.OID_PERI = MFC.PERD_OID_PERI
	  AND OFE.MFCA_OID_CABE = MFC.OID_CABE
	  AND MF.MFCA_OID_CABE = MFC.OID_CABE
	  AND OFE.OID_OFER = OFEDET.OFER_OID_OFER  	
	  AND OFEDET.OID_DETA_OFER = MF.OFDE_OID_DETA_OFER
	  AND OFEDET.PROD_OID_PROD = PROD.OID_PROD
	  AND OFE.FOPA_OID_FORM_PAGO = FP.OID_FORM_PAGO(+)
	  AND OFEDET.OCAT_OID_CATAL = CAT.OID_CATA(+)
	  AND OFE.COES_OID_ESTR = ES.OID_ESTR (+)
	  AND OFEDET.CIVI_OID_CICLO_VIDA=CIVI.OID_CICL_VIDA (+) 
	  AND OFEDET.TOFE_OID_TIPO_OFER=TOFE.OID_TIPO_OFER (+) 
	  AND OFE.ACCE_OID_ACCE=ACC.OID_ACCE (+)
	  AND OFE.OID_OFER = VTAEX.OFER_OID_OFER(+)
	  AND PERI.MARC_OID_MARC = MARCA.OID_MARC(+)
	  AND I18EST.VAL_OID(+) = OFE.COES_OID_ESTR
	  AND I18TCLIEN.VAL_OID(+) = VTAEX.TICL_OID_TIPO_CLIE
	  AND I18STCLIEN.VAL_OID(+) = VTAEX.SBTI_OID_SUBT_CLIE
	  AND I18TCLASI.VAL_OID(+) = VTAEX.TCCL_OID_TIPO_CLAS
	  AND I18CLASI.VAL_OID(+) = VTAEX.CLAS_OID_CLAS
      AND I18PAIS.VAL_OID(+) = PERI.PAIS_OID_PAIS 
      AND I18CANAL.VAL_OID(+) = PERI.CANA_OID_CANA 
      AND I18PROD.VAL_OID(+) = OFEDET.PROD_OID_PROD 
/*	  AND PERI.PAIS_OID_PAIS = 1		 		   -- PARAMETRO --
	  AND PERI.MARC_OID_MARC = 1		 		   -- PARAMETRO --
	  AND PERI.CANA_OID_CANA = 1		 		   -- PARAMETRO --
	  AND PERI.OID_PERI = 16		 		   -- PARAMETRO --
	  AND OFE.ACCE_OID_ACCE = 4					   -- PARAMETRO --
	  AND OFEDET.CIVI_OID_CICLO_VIDA = 1		   -- PARAMETRO --
	  AND OFEDET.TOFE_OID_TIPO_OFER = 1			   -- PARAMETRO --
	  AND OFEDET.VAL_CODI_VENT >= '036021'		   -- PARAMETRO --
	  AND OFEDET.VAL_CODI_VENT <= '036024'		   -- PARAMETRO --
	  AND PROD.COD_SAP >= 'CODPROD28-N023-PRO21'  -- PARAMETRO --
	  AND PROD.COD_SAP <= 'CODPROD29-N023-PRO22'  -- PARAMETRO --
/*	  AND ES.TIES_OID_TIPO_ESTR = 3				   -- PARAMETRO --
	  AND OFEDET.IMP_PREC_CATA >= 0				   -- PARAMETRO --
	  AND OFEDET.IMP_PREC_POSI >= 0				   -- PARAMETRO --
	  AND CAT.OID_CATA = 69	   	  				   -- PARAMETRO --
	  AND OFEDET.NUM_PAGI_CATA >= 1				   -- PARAMETRO --
	  AND OFEDET.NUM_PAGI_CATA <= 10			   -- PARAMETRO --
	  AND OFE.FOPA_OID_FORM_PAGO = 7			   -- PARAMETRO --*/
ORDER BY
	  OFE.NUM_OFER,
	  OFEDET.VAL_CODI_VENT

