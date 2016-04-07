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
		 where IND_NIVE = 1 and IDIO_OID_IDIO = 1
		 and i18.attr_enti='MEN_FUNCI') func, 
         propertyvalues prop9, 
         propertyvalues prop24,
         propertyvalues prop25,
         propertyvalues prop30,
         propertyvalues prop38,
         propertyvalues prop39,
         propertyvalues prop40,
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
	 AND (    DECODE (TO_NUMBER (prop24.stringvalue), NULL, -1, TO_NUMBER (prop24.stringvalue) ) IN (1)			-- marca 
          AND DECODE (TO_NUMBER (prop25.stringvalue), NULL, -1, TO_NUMBER (prop25.stringvalue) ) IN (1)
          AND DECODE (TO_NUMBER (prop30.stringvalue), NULL, -1, TO_NUMBER (prop30.stringvalue) ) IN (1)
          AND DECODE (TO_NUMBER (prop9.stringvalue), NULL, -1, TO_NUMBER (prop9.stringvalue) ) IN (5)
          AND DECODE (TO_NUMBER (prop38.stringvalue), NULL, -1, TO_NUMBER (prop38.stringvalue) ) IN (1)
          AND DECODE (TO_NUMBER (prop39.stringvalue), NULL, -1, TO_NUMBER (prop39.stringvalue) ) IN (1)
          AND DECODE (TO_NUMBER (prop40.stringvalue), NULL, -1, TO_NUMBER (prop40.stringvalue) ) IN (1)
		  AND usuarios.apellidopaterno like '%Ap%'
		  AND usuarios.apellidomaterno like '%2%'
		  AND usuarios.nombre1 like '%s%'
		  AND usuarios.nombre2 like '%s%'
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
			 