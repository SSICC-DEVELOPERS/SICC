CREATE OR REPLACE function REP_004_CONCAT_ACT (
	idperi_par in number,
	fec_prev_par in date,
	idgrupo_par in number,
	idpais_par in number,
	idmarca_par in number,
	idcanal_par in number
)
return varchar2


is


  var_aux varchar2(8000):= 'select cod_acti, fecha_prev ' ||
  		  				   'from ( select per.pais_oid_pais as pais, cab.OID_CABE_GRUP_ZONA as grupo, ' ||
						   'per.VAL_NOMB_PERI  periodo, act.COD_ACTI , ' ||
						   'cor.VAL_ANIO, zon.COD_ZONA, ' ||
						   '( select min(gru1.fec_prev) ' ||
						   'from cra_crono_grupo_zona gru1, ' ||
						   'cra_cabec_grupo_zona cab1, ' ||
						   'cra_activ act1 ' ||
						   'where gru1.PERD_OID_PERI=per.OID_PERI ' ||
						   'and cab1.MARC_OID_MARC=cab.MARC_OID_MARC ' ||
						   'and cab1.CANA_OID_CANA=cab.CANA_OID_CANA ' ||
						   'and cab1.PAIS_OID_PAIS=cab.PAIS_OID_PAIS ' ||
						   'and gru1.CACT_OID_ACTI=cro.CACT_OID_ACTI ' ||
						   'and gru1.CGZO_OID_CABE_GRUP_ZONA=cro.CGZO_OID_CABE_GRUP_ZONA ' ||
						   ') fecha_prev, ' ||
						   '( select max(gru2.fec_fina) ' ||
						   'from cra_crono_grupo_zona gru2, ' ||
						   'cra_cabec_grupo_zona cab2, ' ||
						   'cra_activ act2 ' ||
						   'where gru2.PERD_OID_PERI=per.OID_PERI ' ||
						   'and cab2.MARC_OID_MARC=cab.MARC_OID_MARC ' ||
						   'and cab2.CANA_OID_CANA=cab.CANA_OID_CANA ' ||
						   'and cab2.PAIS_OID_PAIS=cab.PAIS_OID_PAIS ' ||
						   'and gru2.CACT_OID_ACTI=cro.CACT_OID_ACTI ' ||
						   'and gru2.CGZO_OID_CABE_GRUP_ZONA=cro.CGZO_OID_CABE_GRUP_ZONA ' ||
						   ') fecha_fina ' ||
						   'from cra_crono_grupo_zona cro, ' ||
						   'cra_cabec_grupo_zona cab, ' ||
						   'cra_perio per, ' ||
						   'cra_activ act, ' ||
						   'seg_perio_corpo cor, ' ||
						   'cra_detal_grupo_zona det, ' ||
						   'zon_zona zon, ' ||
						   '( select oid_peri ' ||
						   'from ( select per.oid_peri, per.fec_inic, per.fec_fina ' ||
						   'from ( select per2.oid_peri, per2.fec_inic ' ||
						   'from cra_perio per2 ' ||
						   'where per2.oid_peri='|| idperi_par ||' ' || --PARAMETRO--
						   ') per_selec, ' ||
						   'cra_perio per ' ||
						   'where per.fec_inic>=per_selec.fec_inic ' ||
						   'and per.pais_oid_pais='|| idpais_par ||' ' || --PARAMETRO--
						   'and per.MARC_OID_MARC='|| idmarca_par ||' ' || --PARAMETRO--
						   'and per.CANA_OID_CANA='|| idcanal_par ||' ' || --PARAMETRO--
						   'order by per.fec_inic ' ||
						   ') where rownum in(1,2,3) ' ||
						   ')tres_per ' ||
						   'where cro.CACT_OID_ACTI=act.OID_ACTI ' ||
						   'and cro.PERD_OID_PERI=per.oid_peri ' ||
						   'and per.PERI_OID_PERI=cor.oid_peri ' ||
						   'and cro.CGZO_OID_CABE_GRUP_ZONA=cab.OID_CABE_GRUP_ZONA ' ||
						   'and det.CGZO_OID_CABE_GRUP_ZONA=cab.OID_CABE_GRUP_ZONA ' ||
						   'and det.ZZON_OID_ZONA=zon.oid_zona ' ||
						   'and cro.CGZO_OID_CABE_GRUP_ZONA= '|| idgrupo_par ||' ' || --PARAMETRO--
						   'and per.oid_peri=tres_per.oid_peri ) ' ||
						   'group by fecha_prev, cod_acti ';


    v_return varchar2(2000);

    type    my_curs_type is REF CURSOR;
    curs    my_curs_type;
    ret     varchar2(20);
	var_fecha date;

  begin

    OPEN curs FOR var_aux;
	LOOP
		FETCH curs INTO ret, var_fecha;
		  exit when curs%notfound;
		  if var_fecha = fec_prev_par
		  then
		  v_return := v_return||' '||ret;
		  end if;
	end loop;
	CLOSE curs;

    return v_return;

end;
/
