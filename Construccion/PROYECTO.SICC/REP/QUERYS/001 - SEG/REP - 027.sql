
	select val_i18n as FUNCION,usuarios.apellidopaterno, usuarios.apellidomaterno,usuarios.nombre1,usuarios.nombre2, 1 as Cantidad 
		   from (
		   select distinct VAL_NOMB_PROG, i18.VAL_I18N, us.IDMEMBER
		   from 
		   MEN_FUNCI fu 
		   LEFT OUTER JOIN PRINCIPALS pr ON TO_CHAR(fu.OID_FUNC) = pr.NAME 
		   INNER JOIN MEMBEROF per on per.IDROLE = pr.IDPRINCIPAL
		   INNER JOIN MEMBEROF us on per.IDMEMBER = us.IDROLE
		   INNER JOIN V_GEN_I18N_SICC i18 on fu.OID_FUNC = i18.VAL_OID 
		   where IND_NIVE = 1
		   and IDIO_OID_IDIO = 1
		   and i18.attr_enti='MEN_FUNCI'
		   ), own_mare.V_USU_LARGO usuarios
	where usuarios.IdUsuario = idmember 
	group by VAL_I18N,usuarios.apellidopaterno, usuarios.apellidomaterno,usuarios.nombre1,usuarios.nombre2
	order by val_i18n,usuarios.apellidopaterno, usuarios.apellidomaterno,usuarios.nombre1,usuarios.nombre2
