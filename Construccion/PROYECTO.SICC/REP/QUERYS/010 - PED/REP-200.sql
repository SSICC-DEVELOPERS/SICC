SELECT COD_PAIS,
	   INI_SESI AS DIA,
	   ID_USU AS DIGITAD,
	   SUM(COD_VENTA_ING) VEN_ING,
	   SUM(DOCU_ING) DOC_INGRESO,
	   SUM(PORC_ERROR_ING) ERROR_ING,
	   SUM(HORA_ING) HORA_ING,
	   SUM(COD_VENTA_VER) COD_VEN_VER,
	   SUM(DOCU_VER) DOC_VERI,
	   SUM(HORA_VER) HORA_VER,
	   SUM(ING_HORA) ING_HORA,
	   SUM(VER_HORA) VER_HORA,
	   SUM(EVAL) EVAL
FROM              
(                            
	SELECT COD_PAIS,
		   ID_USU,                
		   INI_SESI,                     
		   NVL(CASE WHEN (EST.COD_proc = 'P115') THEN      
		   		SUM(NVL(EST.NUM_CV,0))
		   END, 0) COD_VENTA_ING,
		   NVL(CASE WHEN (EST.COD_proc = 'P115') THEN
		   		SUM(NVL(EST.NUM_OC,0))
		   END, 0) DOCU_ING,
		   NVL(CASE WHEN (EST.COD_proc = 'P115') THEN
		   		DECODE(SUM(NVL(EST.NUM_OC, 0)), 0, 0, SUM(NVL(EST.ERROR_CV, 0))/SUM(NVL(EST.NUM_OC, 0)))*100
		   END, 0) PORC_ERROR_ING,
		   NVL(CASE WHEN (EST.COD_proc = 'P115') THEN
		   		SUM(EST.FIN_SESI-EST.INI_SESI)*24
		   END, 0) HORA_ING,
		   NVL(CASE WHEN (EST.COD_proC = 'P120') THEN
		   		SUM(NVL(EST.NUM_CV, 0))
		   END, 0) COD_VENTA_VER,
		   NVL(CASE WHEN (EST.COD_proc = 'P120') THEN
		   		SUM(NVL(EST.NUM_OC, 0))
		   END, 0) DOCU_VER,
		   NVL(CASE WHEN (EST.COD_proc = 'P120') THEN
		   		SUM(EST.FIN_SESI-EST.INI_SESI)*24
		   END, 0) HORA_VER,
		   NVL(CASE WHEN (EST.COD_proc = 'P115') THEN      
		   		DECODE(SUM(EST.FIN_SESI-EST.INI_SESI)*24, 0 ,0, SUM(NVL(EST.NUM_CV,0)) / (SUM(EST.FIN_SESI-EST.INI_SESI)*24))
		   END, 0) ING_HORA,
		   NVL(CASE WHEN (EST.COD_proc = 'P120') THEN      
		   		DECODE(SUM(EST.FIN_SESI-EST.INI_SESI)*24, 0 ,0, SUM(NVL(EST.NUM_CV,0)) / (SUM(EST.FIN_SESI-EST.INI_SESI)*24))
		   END, 0) VER_HORA,
		   NVL((CASE WHEN (EST.COD_proc = 'P115') THEN      
		   		((DECODE(SUM(EST.FIN_SESI-EST.INI_SESI)*24, 0 ,0, SUM(NVL(EST.NUM_CV,0)) / (SUM(EST.FIN_SESI-EST.INI_SESI)*24)))*100)/2500
		   END) + 
		   (CASE WHEN (EST.COD_proc = 'P120') THEN      
		   		((DECODE(SUM(EST.FIN_SESI-EST.INI_SESI)*24, 0 ,0, SUM(NVL(EST.NUM_CV,0)) / (SUM(EST.FIN_SESI-EST.INI_SESI)*24)))*100)/2500
		   END), 0) EVAL	   	   	  	   	   	   
	FROM NDG_ESTAD_DIGIT EST 
	WHERE TO_DATE(EST.INI_SESI) >= TO_DATE('01/01/2000','DD/MM/YYYY')  -- PARAMETRO DE FECHA INICIO --
		  AND TO_DATE(EST.INI_SESI) <= TO_DATE('01/01/2050','DD/MM/YYYY') 			-- PARAMETRO DE FECHA HASTA --
	GROUP BY COD_PAIS, 
		  ID_USU,
		  INI_SESI,	  
		  EST.COD_proc
)	  
GROUP BY COD_PAIS,
	  ID_USU,
	  INI_SESI	  

