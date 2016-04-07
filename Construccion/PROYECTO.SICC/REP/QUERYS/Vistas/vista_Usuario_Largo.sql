CREATE OR REPLACE FORCE VIEW OWN_MARE.V_USU_LARGO
(IDUSUARIO, APELLIDOPATERNO, APELLIDOMATERNO, NOMBRE1, NOMBRE2)
AS 
Select us_ex.iduser as IdUsuario, 
	      decode((Select p.STRINGVALUE from propertyvalues p, users us_in where  us_in.IDUSER= us_ex.IDUSER AND us_in.IDUSER=p.IDPRINCIPAL and p.IDPROPERTY=2),NULL,'',(Select p.STRINGVALUE from propertyvalues p, users us_in where  us_in.IDUSER= us_ex.IDUSER AND us_in.IDUSER=p.IDPRINCIPAL and p.IDPROPERTY=2)) as apellido1, 
	      decode((Select p.STRINGVALUE from propertyvalues p, users us_in where  us_in.IDUSER= us_ex.IDUSER AND us_in.IDUSER=p.IDPRINCIPAL and p.IDPROPERTY=3),NULL,'',(Select p.STRINGVALUE from propertyvalues p, users us_in where  us_in.IDUSER= us_ex.IDUSER AND us_in.IDUSER=p.IDPRINCIPAL and p.IDPROPERTY=3)) as apellido2, 
	      decode((Select p.STRINGVALUE from propertyvalues p, users us_in where  us_in.IDUSER= us_ex.IDUSER AND us_in.IDUSER=p.IDPRINCIPAL and p.IDPROPERTY=5),NULL,'',(Select p.STRINGVALUE from propertyvalues p, users us_in where  us_in.IDUSER= us_ex.IDUSER AND us_in.IDUSER=p.IDPRINCIPAL and p.IDPROPERTY=5)) as nombre1, 
	      decode((Select p.STRINGVALUE from propertyvalues p, users us_in where  us_in.IDUSER= us_ex.IDUSER AND us_in.IDUSER=p.IDPRINCIPAL and p.IDPROPERTY=6),NULL,'',(Select p.STRINGVALUE from propertyvalues p, users us_in where  us_in.IDUSER= us_ex.IDUSER AND us_in.IDUSER=p.IDPRINCIPAL and p.IDPROPERTY=6)) as nombre2 
From users us_ex;


GRANT SELECT ON  OWN_MARE.V_USU_LARGO TO USU_PERU;


