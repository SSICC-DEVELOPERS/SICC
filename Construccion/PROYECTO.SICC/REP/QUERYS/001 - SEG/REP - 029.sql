SELECT 
		 usuarios.idusuario, usuarios.apellidopaterno, usuarios.apellidomaterno, usuarios.nombre1, usuarios.nombre2, 
		 func.VAL_I18N, 1 AS cantidad
FROM own_mare.v_usu_largo usuarios, 
	 ( 
	  	 Select distinct i18.VAL_I18N, i18.OID_I18N, us.IDMEMBER as idusuario 
		 from 
		 MEN_FUNCI fu 
		 LEFT OUTER JOIN PRINCIPALS pr ON TO_CHAR(fu.OID_FUNC) = pr.NAME 
		 INNER JOIN MEMBEROF per on per.IDROLE = pr.IDPRINCIPAL 
		 INNER JOIN MEMBEROF us on per.IDMEMBER = us.IDROLE 
		 INNER JOIN V_GEN_I18N_SICC i18 on fu.OID_FUNC = i18.VAL_OID 
		 where IND_NIVE = 1 and IDIO_OID_IDIO = 1	   	 		  -- Parametro  
		 and i18.attr_enti='MEN_FUNCI' Order By i18.VAL_I18N) func, 
         propertyvalues prop9,                                 -- Departamento 
         propertyvalues prop24,                                       -- Marca 
         propertyvalues prop25,                                       -- Canal 
         propertyvalues prop30,      -- Empresa (Nombre Entidad es "Sociedad") 
         propertyvalues prop38,                                      -- Region 
         propertyvalues prop39,                                        -- Zona 
         propertyvalues prop40,                                     -- Seccion 
         users us 
WHERE ( 
   		 us.IDUSER = usuarios.idusuario 
		 AND us.IDUSER(+) = func.idusuario 
		 AND us.iduser = prop9.idprincipal 
         AND prop9.idproperty = 9 
         AND us.iduser = prop24.idprincipal 
         AND prop24.idproperty = 24 
         AND us.iduser = prop25.idprincipal 
         AND prop25.idproperty = 25 
         AND us.iduser = prop30.idprincipal 
         AND prop30.idproperty = 30 
         AND us.iduser = prop38.idprincipal 
         AND prop38.idproperty = 38 
         AND us.iduser = prop39.idprincipal 
         AND prop39.idproperty = 39 
         AND us.iduser = prop40.idprincipal 
         AND prop40.idproperty = 40 
         ) 
	 AND (    NVL(prop24.stringvalue,-1) IN (1)                                           -- marca  
          AND NVL(prop25.stringvalue, -1) IN (1)                                           -- canal 
          AND NVL(prop30.stringvalue, -1) IN (1)                                         -- empresa 
          AND NVL(prop9.stringvalue, -1) IN (5)                                           -- depto 
          AND NVL(prop38.stringvalue, -1) IN (1)                                          -- region 
          AND NVL(prop40.stringvalue, -1) IN (1)                                         -- seccion 
          AND NVL(prop39.stringvalue, -1) IN (1)                                            -- zona 
		  AND usuarios.apellidopaterno like '%Ap%'		  -- El % sera parte del texto de entrada 
		  AND usuarios.apellidomaterno like '%2%'			  -- El % sera parte del texto de entrada 
		  AND usuarios.nombre1 like '%s%'			  -- El % sera parte del texto de entrada 
		  AND usuarios.nombre2 like '%s%'			  -- El % sera parte del texto de entrada 
         )
GROUP BY usuarios.idusuario, 
         usuarios.apellidopaterno, 
         usuarios.apellidomaterno, 
         usuarios.nombre1, 
         usuarios.nombre2, 
		 func.VAL_I18N 
ORDER BY usuarios.idusuario,
         usuarios.apellidopaterno,
         usuarios.apellidomaterno,
         usuarios.nombre1,
         usuarios.nombre2
			 