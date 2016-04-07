CREATE OR REPLACE function rep_002_concat_grup_crono (
	oid_peri_par in number,
	idmarca_par in number,
	idcanal_par in varchar,
	idacces_par in varchar,
	idzona_par in varchar,
	idanio_par in number
)
return varchar2

is

  var_aux varchar2(8000):= 'select cab.COD_GRUP '  		||
  		  				   'from seg_canal can, '		||
							   'seg_marca mar, ' 		||
							   'seg_pais pai, ' 		||
							   'principals pri, ' 			||
							   'cra_activ act, '			||
							   'cra_clase_activ cla, ' 		||
							   'cra_perio per, ' 	 		||
							   'cra_cabec_grupo_zona cab, ' ||
							   'cra_crono_grupo_zona cro, ' ||
							   'cra_detal_grupo_zona det, '	||
							   'zon_zona zon, ' 	 	    ||
							   'zon_regio reg, ' 			||
							   'seg_perio_corpo cor ' 		||
						   'where act.CLAC_OID_CLAS_ACTI=cla.OID_CLAS_ACTI ' ||
							   'and cla.OID_CLAS_ACTI=3 ' || --3 facturacion--
							   'and act.CANA_OID_CANA=can.OID_CANA ' 		   ||
							   'and act.MARC_OID_MARC=mar.OID_MARC ' 		   ||
							   'and act.ACCE_OID_ACCE in ('|| idacces_par||' ) ' || --value
							   'and act.PAIS_OID_PAIS=pai.OID_PAIS ' 		   ||
							   'and mar.OID_MARC='|| idmarca_par ||' '   			   ||--value
							   'and per.OID_PERI ='|| oid_peri_par ||'  ' 		   ||--value
							   'and can.OID_CANA in ('|| idcanal_par ||') '    ||--value
							   'and zon.OID_ZONA in ( '|| idzona_par ||' ) ' 	   || --value
							   'and act.OID_ACTI=cro.CACT_OID_ACTI ' 	 	   ||
							   'and cro.PERD_OID_PERI=per.OID_PERI ' 		   ||
							   'and per.PERI_OID_PERI=cor.OID_PERI ' 		   ||
							   'and cor.VAL_ANIO='|| idanio_par ||' '	   			   || --value
							   'and cab.OID_CABE_GRUP_ZONA=cro.CGZO_OID_CABE_GRUP_ZONA ' ||
							   'and det.CGZO_OID_CABE_GRUP_ZONA=cab.OID_CABE_GRUP_ZONA ' ||
							   'and det.zzon_oid_zona=zon.OID_ZONA ' ||
							   'and zon.ZORG_OID_REGI=reg.OID_REGI ' ||
						   'group by cab.cod_grup ';
---------------------------------------------------------------------------------------

    v_return varchar2(2000);

    type    my_curs_type is REF CURSOR;
    curs    my_curs_type;
    ret     varchar2(20);
	var_fecha date;

  begin

    OPEN curs FOR var_aux;
	LOOP
		FETCH curs INTO ret;
		  exit when curs%notfound;
		  v_return := v_return||' '||ret;
	end loop;
	CLOSE curs;

    return v_return;

end;
/
