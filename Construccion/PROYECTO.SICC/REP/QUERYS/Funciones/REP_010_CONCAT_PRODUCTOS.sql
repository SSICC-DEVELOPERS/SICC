CREATE OR REPLACE FUNCTION OWN_PERU.REP_010_CONCAT_PRODUCTOS (
	ididioma_par in number,
	idcurso_par in number
)
return varchar2


is

  var_aux varchar2(5000):=
  		  				    'select prod.COD_SAP, gen_produ.regalo ' ||
							'from edu_matri_curso cur, ' ||
							'	 edu_regal rega, ' ||
							'	 edu_regal_detal det_regal, ' ||
							'	 mae_produ prod, ' ||
							'	 ( ' ||
							'	 select gen.VAL_OID, gen.VAL_I18N regalo ' ||
							'	 from v_gen_i18n_sicc gen ' ||
							'	 where gen.ATTR_ENTI= ''MAE_PRODU'' ' ||
							'	 	   and gen.IDIO_OID_IDIO = '|| ididioma_par ||
							'	 )gen_produ ' ||
							'where cur.OID_CURS = '|| idcurso_par ||
							'	  and cur.REGA_OID_REGA = rega.OID_REGA(+) ' ||
							'	  and rega.OID_REGA = det_regal.REGA_OID_REGA ' ||
							'	  and det_regal.PROD_OID_PROD = prod.OID_PROD ' ||
							'	  and gen_produ.val_oid(+) = prod.oid_prod ' ||
							'order by prod.COD_SAP, gen_produ.regalo ';

    v_return varchar2(20000);

    type    my_curs_type is REF CURSOR;
    curs    my_curs_type;
    ret     varchar2(20);
    ret2     varchar2(4000);

  begin

    OPEN curs FOR var_aux;
	LOOP
		FETCH curs INTO ret, ret2;
		  exit when curs%notfound;
		  v_return := v_return || ret || '-' || ret2 || '      ';
	end loop;
	CLOSE curs;

    return v_return;

end;
/


GRANT EXECUTE ON  OWN_PERU.REP_010_CONCAT_PRODUCTOS TO USU_PERU;

