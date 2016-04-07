CREATE OR REPLACE function REP_008_CONCAT_ZONA (
	idperi_par in number,
	idregi_par in number,
	idgrupo_par in number,
	idmarca_par in number,
	idcanal_par in number,
	idpais_par in number
)
return varchar2


is

  var_aux varchar2(8000):= 'select cod_zona ' ||
  		  				   'from ( ' ||
						   'select reg.cod_regi, reg.OID_REGI, cab.cod_grup, act.COD_ACTI, act.OID_ACTI, cro.OID_CRON_GRUP_ZONA, ' ||
						   'per.VAL_NOMB_PERI periodo, reg.des_regi, zon.cod_zona, ' ||
						   '( '	||
						   'select min(cro1.fec_prev) ' ||
						   'from cra_crono_grupo_zona cro1, ' ||
						   'cra_cabec_grupo_zona cab1, ' ||
						   'cra_activ act1 ' ||
						   'where cro1.PERD_OID_PERI=per.OID_PERI ' ||
						   'and cab1.MARC_OID_MARC=cab.MARC_OID_MARC ' ||
						   'and cab1.CANA_OID_CANA=cab.CANA_OID_CANA ' ||
						   'and cab1.PAIS_OID_PAIS=cab.PAIS_OID_PAIS ' ||
						   'and cro1.CACT_OID_ACTI=cro.CACT_OID_ACTI ' ||
						   'and cro1.CGZO_OID_CABE_GRUP_ZONA=cro.CGZO_OID_CABE_GRUP_ZONA ' ||
						   ')as fecha_prev, ' 	||
						   '( select max(cro2.fec_fina) ' ||
						   'from cra_crono_grupo_zona cro2, ' ||
						   'cra_cabec_grupo_zona cab2, ' ||
						   'cra_activ act2 ' ||
						   'where cro2.PERD_OID_PERI=per.OID_PERI ' 					 ||
						   'and cab2.MARC_OID_MARC=cab.MARC_OID_MARC ' 					 ||
						   'and cab2.CANA_OID_CANA=cab.CANA_OID_CANA ' 					 ||
						   'and cab2.PAIS_OID_PAIS=cab.PAIS_OID_PAIS ' 					 ||
						   'and cro2.CACT_OID_ACTI=cro.CACT_OID_ACTI ' 					 ||
						   'and cro2.CGZO_OID_CABE_GRUP_ZONA=cro.CGZO_OID_CABE_GRUP_ZONA ' ||
						   ')as fecha_fina ' ||
						   'from zon_regio reg, ' ||
						   'zon_zona zon, ' ||
						   'cra_crono_grupo_zona cro, ' ||
						   'cra_cabec_grupo_zona cab, ' ||
						   'cra_detal_grupo_zona det, ' ||
						   'cra_perio per, ' 	 	  	||
						   'cra_activ act ' 			||
						   'where zon.ZORG_OID_REGI=reg.OID_REGI ' ||
						   'and cro.CGZO_OID_CABE_GRUP_ZONA=cab.OID_CABE_GRUP_ZONA ' ||
						   'and cab.OID_CABE_GRUP_ZONA=det.CGZO_OID_CABE_GRUP_ZONA ' ||
						   'and det.ZZON_OID_ZONA=zon.OID_ZONA ' ||
						   'and cro.PERD_OID_PERI=per.OID_PERI ' ||
						   'and cro.CACT_OID_ACTI=act.OID_ACTI ' ||
						   'and cro.PERD_OID_PERI= ' || idperi_par || ' '		 ||
						   'and reg.pais_oid_pais = ' || idpais_par || '  '		 ||
						   'and reg.marc_oid_marc = ' || idmarca_par || ' ' 	 ||
						   'and reg.cana_oid_cana = ' || idcanal_par || ' '		 ||
						   'and zon.pais_oid_pais = ' || idpais_par || ' ' 		 ||
						   'and zon.marc_oid_marc = ' || idmarca_par || ' ' 	 ||
						   'and zon.cana_oid_cana = ' || idcanal_par || ' ' 	 ||
						   'and cab.pais_oid_pais = ' || idpais_par || ' ' 		 ||
						   'and cab.marc_oid_marc = ' || idmarca_par || ' ' 	 ||
						   'and cab.cana_oid_cana = ' || idcanal_par || ' ' 	 ||
						   ') '  ||
						   'where OID_REGI = ' || idregi_par || ' ' 		 	||
						   'and OID_CRON_GRUP_ZONA = ' || idgrupo_par  || ' ' 	||
						   'group by cod_regi, cod_grup, des_regi, cod_acti, periodo, cod_zona, fecha_prev, fecha_fina ' ;

    v_return varchar2(2000);

    type    my_curs_type is REF CURSOR;
    curs    my_curs_type;
    ret     varchar2(20);

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
