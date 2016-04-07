CREATE OR REPLACE function REP_004_CONCAT_ACT_I18N (
	idperiodo_par in number,
	idgrupo_par in number,
	idpais_par in number,
	idmarca_par in number,
	idcanal_par in number,
	ididioma_par in number
)
return varchar2


is

  var_aux varchar2(5000):= 'select distinct act.COD_ACTI, gen_act.VAL_I18N ' ||
						   'from cra_crono_grupo_zona cro, ' ||
						   '	 cra_cabec_grupo_zona cab, ' ||
						   '	 cra_activ act, ' ||
						   '	(select gen.VAL_OID, gen.VAL_I18N ' ||
						   '	from v_gen_i18n_sicc gen ' ||
						   '	where gen.ATTR_ENTI= ''CRA_ACTIV'' ' ||
						   '	and gen.IDIO_OID_IDIO='|| ididioma_par ||			--PARAMETRO--
						   '	)gen_act, ' ||
						   '( select oid_peri ' ||
						   'from ( select per.oid_peri, per.fec_inic, per.fec_fina ' ||
						   'from ( select per2.oid_peri, per2.fec_inic ' ||
						   'from cra_perio per2 ' ||
						   'where per2.oid_peri='|| idperi_par ||' ' || --PARAMETRO--
						   ') per_selec, ' ||
						   'cra_perio per ' ||
						   'where per.fec_inic>=per_selec.fec_inic ' ||
						   'order by per.fec_inic ' ||
						   ') where rownum in(1,2,3) ' ||
						   ')tres_per ' ||
						   'where cro.CACT_OID_ACTI=act.OID_ACTI ' ||
						   '	and cro.CGZO_OID_CABE_GRUP_ZONA=cab.OID_CABE_GRUP_ZONA ' ||
						   '	and gen_act.VAL_OID = act.OID_ACTI ' ||
						   '	and cab.PAIS_OID_PAIS ='|| idpais_par ||			--PARAMETRO--
						   '	and cab.MARC_OID_MARC ='|| idmarca_par ||			--PARAMETRO--
						   '	and cab.CANA_OID_CANA ='|| idcanal_par ||			--PARAMETRO--
						   '	and cab.OID_CABE_GRUP_ZONA ='|| idgrupo_par ||			--PARAMETRO--
						   '	and cro.PERD_OID_PERI = tres_per.oid_peri '|| 
						   'Order By act.COD_ACTI, gen_act.VAL_I18N ';


    v_return varchar2(2000);

    type    my_curs_type is REF CURSOR;
    curs    my_curs_type;
    ret     varchar2(20);
    ret2     varchar2(50);

  begin

    OPEN curs FOR var_aux;
	LOOP
		FETCH curs INTO ret, ret2;
		  exit when curs%notfound;
		  v_return := v_return || ret || '-' || ret2 || '   ';
	end loop;
	CLOSE curs;

    return v_return;

end;
/

