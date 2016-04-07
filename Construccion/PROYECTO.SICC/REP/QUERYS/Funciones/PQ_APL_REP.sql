CREATE OR REPLACE PACKAGE OWN_PERU.pq_apl_rep as

FUNCTION FN_002_CONCAT_GRUP_CRONO (
	oid_peri_par in varchar,
	idmarca_par in number,
	idcanal_par in varchar,
	idacces_par in varchar,
	idzona_par in varchar,
	idanio_par in number,
	idpais_par in number
)
return varchar2;

FUNCTION FN_004_CONCAT_ACT (
	idperi_par in number,
	fec_prev_par in date,
	idgrupo_par in number,
	idpais_par in number,
	idmarca_par in number,
	idcanal_par in number
)
return varchar2;

FUNCTION FN_004_CONCAT_ACT_I18N (
	idpais_par in number,
	idmarca_par in number,
	idcanal_par in number,
	ididioma_par in number
)
return varchar2;

FUNCTION FN_008_CONCAT_ZONA (
	idperi_par in number,
	idregi_par in number,
	idgrupo_par in number,
	idmarca_par in number,
	idcanal_par in number,
	idpais_par in number
)
return varchar2;

FUNCTION FN_010_CONCAT_PRODUCTOS (
	ididioma_par in number,
	idcurso_par in number
)
return varchar2;

FUNCTION FN_CU_CALC_CUPON_EN_TRAMITE (
	idpais_par in varchar,
	idclien_par in varchar
)
return number;


FUNCTION FN_CU_CALC_DEUDA_VENC_CLIEN (
	idpais_par in  number,
	idclien_par in number
)
return number;


FUNCTION FN_CU_CALC_DIAS_ATRASO_CLIEN (
	idpais_par in  number,
	idclien_par in number
)
return number;


FUNCTION FN_CU_CALC_MONTO_SOLIC_NUEVAS (
	idclien_par in varchar
)
return number;


FUNCTION FN_CU_CALC_PED_PROMEDIO_CLIEN (
	idclien_par in number,
	idclasesolic_par in number,
--	idtipoperi_par in number,
	idperi1_par in number,
	idperi2_par in number
)
return number;


FUNCTION FN_CU_CALC_PERI_CON_PEDIDOS (
	idclien_par in number,
	idclasesolic_par in number,
--	idtipoperi_par in number,
	idperi1_par in number,
	idperi2_par in number
)
return number;

FUNCTION FN_CU_CALC_SALDO_CTA_CTE (
	idclien_par in varchar,
	idsubg_par in varchar := NULL,
	idreg_par in varchar := NULL,
	idsecc_par in varchar := NULL
)
return number;

FUNCTION FN_162_TOTAL_PROD_NEG (
	   id_peri_par in varchar,
	   id_region_par in varchar,
	   id_pais_par in varchar,
	   id_marca_par in varchar,
	   id_canal_par in varchar,
	   id_negocio_par in varchar, --PARAMETRO NO OBLIGATORIO, VENDRA -1 -
	   id_un_negocio_par in varchar, --PARAMETRO NO OBLIGATORIO, VENDRA -1 --
	   id_acceso_par in varchar, --PARAMETRO NO OBLIGATORIO, VENDRA -1 --
	   diario_par in varchar:=-1
)
return number;

FUNCTION FN_112_CALC_PER_ANT (
	idpais_par in varchar,
	idmarc_par in varchar,
	idcana_par in varchar,
	idperi_reg in varchar,
	idperi_rec in varchar
)
return number;

FUNCTION FN_008_CALC_OID_PER_ANT (
	idpais_par in varchar,
	idmarc_par in varchar,
	idcana_par in varchar,
	id_peri in varchar,
	n_peri in varchar
)
return number;

FUNCTION FN_011_CALC_RANK_POR_REGION (
	idpais_par in varchar,
	idmarc_par in varchar,
	idcana_par in varchar,
	id_reg in varchar,
	id_peri_desde in varchar,
	id_peri_hasta in varchar,
	id_cli in varchar

)
return number;

end pq_apl_rep;
/


CREATE OR REPLACE PACKAGE BODY OWN_PERU.pq_apl_rep as

FUNCTION FN_002_CONCAT_GRUP_CRONO (
	oid_peri_par in varchar,
	idmarca_par in number,
	idcanal_par in varchar,
	idacces_par in varchar,
	idzona_par in varchar,
	idanio_par in number,
	idpais_par in number
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
							   'and act.PAIS_OID_PAIS=pai.OID_PAIS ' 		   ||
							   'and pai.oid_pais = '|| idpais_par ||' ' ||  --value
							   'and mar.OID_MARC='|| idmarca_par ||' '   			   ||--value
							   'and can.OID_CANA in ('|| idcanal_par ||') ';

    v_return varchar2(2000);

    type    my_curs_type is REF CURSOR;
    curs    my_curs_type;
    ret     varchar2(20);
	var_fecha date;

begin
	if idacces_par <> '' then
	   var_aux := var_aux ||
			   'and act.ACCE_OID_ACCE in ('|| idacces_par ||' ) ';
	end if;
	var_aux := var_aux ||
			   'and zon.OID_ZONA in ( '|| idzona_par ||' ) ' 	   || --value
			   'and per.OID_PERI IN ('|| oid_peri_par ||') ' 		   ||--value
			   'and act.OID_ACTI=cro.CACT_OID_ACTI ' 	 	   ||
			   'and cro.PERD_OID_PERI=per.OID_PERI ' 		   ||
			   'and per.PERI_OID_PERI=cor.OID_PERI ' 		   ||
			   'and cor.VAL_ANIO='|| idanio_par ||' '	   			   || --value
			   'and cab.OID_CABE_GRUP_ZONA=cro.CGZO_OID_CABE_GRUP_ZONA ' ||
			   'and det.CGZO_OID_CABE_GRUP_ZONA=cab.OID_CABE_GRUP_ZONA ' ||
			   'and det.zzon_oid_zona=zon.OID_ZONA ' ||
			   'and zon.ZORG_OID_REGI=reg.OID_REGI ' ||
		   'group by cab.cod_grup ';
  OPEN curs FOR var_aux;
	LOOP
		FETCH curs INTO ret;
		  exit when curs%notfound;
		  v_return := v_return||' '||ret;
	end loop;
	CLOSE curs;

    return v_return;

end;

FUNCTION FN_004_CONCAT_ACT (
	idperi_par in number,
	fec_prev_par in date,
	idgrupo_par in number,
	idpais_par in number,
	idmarca_par in number,
	idcanal_par in number
)
return varchar2

is
  cursor c_cursor is
  select cod_acti, fecha_prev
  from ( select per.pais_oid_pais as pais
        ,cab.OID_CABE_GRUP_ZONA as grupo
        ,per.VAL_NOMB_PERI  periodo
        ,act.COD_ACTI
        ,cor.VAL_ANIO
        ,zon.COD_ZONA
        ,( select min(gru1.fec_prev)
           from cra_crono_grupo_zona gru1,
                cra_cabec_grupo_zona cab1,
                cra_activ act1
           where gru1.PERD_OID_PERI=per.OID_PERI
             and cab1.MARC_OID_MARC=cab.MARC_OID_MARC
             and cab1.CANA_OID_CANA=cab.CANA_OID_CANA
             and cab1.PAIS_OID_PAIS=cab.PAIS_OID_PAIS
             and gru1.CACT_OID_ACTI=cro.CACT_OID_ACTI
             and gru1.CGZO_OID_CABE_GRUP_ZONA=cro.CGZO_OID_CABE_GRUP_ZONA
         ) fecha_prev
       ,( select max(gru2.fec_fina)
          from cra_crono_grupo_zona gru2,
          cra_cabec_grupo_zona cab2,
          cra_activ act2
          where gru2.PERD_OID_PERI=per.OID_PERI
            and cab2.MARC_OID_MARC=cab.MARC_OID_MARC
            and cab2.CANA_OID_CANA=cab.CANA_OID_CANA
            and cab2.PAIS_OID_PAIS=cab.PAIS_OID_PAIS
            and gru2.CACT_OID_ACTI=cro.CACT_OID_ACTI
            and gru2.CGZO_OID_CABE_GRUP_ZONA=cro.CGZO_OID_CABE_GRUP_ZONA
        ) fecha_fina
  from cra_crono_grupo_zona cro,
       cra_cabec_grupo_zona cab,
       cra_perio per,
       cra_activ act,
       seg_perio_corpo cor,
       cra_detal_grupo_zona det,
       zon_zona zon,
       ( select oid_peri
         from ( select per.oid_peri, per.fec_inic, per.fec_fina
                from ( select per2.oid_peri, per2.fec_inic
                       from cra_perio per2
                       where per2.oid_peri= idperi_par --PARAMETRO--
                     ) per_selec,
                     cra_perio per
                where per.fec_inic>=per_selec.fec_inic
                  and per.pais_oid_pais= idpais_par  --PARAMETRO--
                  and per.MARC_OID_MARC= idmarca_par --PARAMETRO--
                  and per.CANA_OID_CANA= idcanal_par --PARAMETRO--
                order by per.fec_inic
              ) where rownum <=3
       ) tres_per
  where cro.CACT_OID_ACTI=act.OID_ACTI
    and cro.PERD_OID_PERI=per.oid_peri
    and per.PERI_OID_PERI=cor.oid_peri
    and cro.CGZO_OID_CABE_GRUP_ZONA=cab.OID_CABE_GRUP_ZONA
    and det.CGZO_OID_CABE_GRUP_ZONA=cab.OID_CABE_GRUP_ZONA
    and det.ZZON_OID_ZONA=zon.oid_zona
    and cro.CGZO_OID_CABE_GRUP_ZONA=idgrupo_par --PARAMETRO--
    and per.oid_peri=tres_per.oid_peri )
  group by fecha_prev, cod_acti;

/***
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
***/

    v_return varchar2(2000);
    ret      varchar2(20);
	var_fecha date;

  begin

  open c_cursor;
	LOOP
		FETCH c_cursor INTO ret, var_fecha;
		  exit when c_cursor%notfound;
		  if var_fecha = fec_prev_par
		  then
		  v_return := v_return||' '||ret;
		  end if;
	end loop;
	CLOSE c_cursor;

    return v_return;

end;


FUNCTION FN_004_CONCAT_ACT_I18N (
	idpais_par in number,
	idmarca_par in number,
	idcanal_par in number,
	ididioma_par in number
)
return varchar2


is

  cursor c_cursor is
    select act.COD_ACTI, gen_act.actividad
    from cra_activ act,
    	 (
    	 select gen.VAL_OID, gen.VAL_I18N as actividad
    	 from v_gen_i18n_sicc gen
    	 where gen.ATTR_ENTI = 'CRA_ACTIV'
    	 	   and gen.IDIO_OID_IDIO = ididioma_par --PARAMETRO--
    	 )gen_act
    where act.MARC_OID_MARC = idmarca_par		--PARAMETRO--
    	  and act.CANA_OID_CANA = idcanal_par --PARAMETRO--
    	  and act.PAIS_OID_PAIS = idpais_par --PARAMETRO--
        and gen_act.val_oid(+) = act.OID_ACTI
    order by act.COD_ACTI, gen_act.actividad;

/***
  var_aux varchar2(5000):=
							'select act.COD_ACTI, gen_act.actividad ' ||
							'from cra_activ act, ' ||
							'	 ( ' ||
							'	 select gen.VAL_OID, gen.VAL_I18N as actividad ' ||
							'	 from v_gen_i18n_sicc gen ' ||
							'	 where gen.ATTR_ENTI = ''CRA_ACTIV'' ' ||
							'	 	   and gen.IDIO_OID_IDIO = '|| ididioma_par ||			--PARAMETRO--
							'	 )gen_act ' ||
							'where act.MARC_OID_MARC = '|| idmarca_par ||			--PARAMETRO--
							'	  and act.CANA_OID_CANA = '|| idcanal_par ||			--PARAMETRO--
							'	  and act.PAIS_OID_PAIS= '|| idpais_par ||			--PARAMETRO--
						    '     and gen_act.val_oid(+) = act.OID_ACTI ' ||
							'order by act.COD_ACTI, gen_act.actividad ';
****/

    v_return varchar2(20000);

    ret     varchar2(20);
    ret2     varchar2(4000);

  begin

  OPEN c_cursor;
	LOOP
      FETCH c_cursor INTO ret, ret2;
		  exit when c_cursor%notfound;
		  v_return := v_return || ret || '-' || ret2 || '   ';
	end loop;
	CLOSE c_cursor;

    return v_return;

end;


FUNCTION FN_008_CONCAT_ZONA (
	idperi_par in number,
	idregi_par in number,
	idgrupo_par in number,
	idmarca_par in number,
	idcanal_par in number,
	idpais_par in number
)
return varchar2


is

cursor c_cursor is
select cod_zona
from ( select reg.cod_regi, reg.OID_REGI, cab.cod_grup, act.COD_ACTI, act.OID_ACTI, cro.OID_CRON_GRUP_ZONA,
       per.VAL_NOMB_PERI periodo, reg.des_regi, zon.cod_zona,
       ( select min(cro1.fec_prev)
         from cra_crono_grupo_zona cro1,
           cra_cabec_grupo_zona cab1,
           cra_activ act1
         where cro1.PERD_OID_PERI=per.OID_PERI
           and cab1.MARC_OID_MARC=cab.MARC_OID_MARC
           and cab1.CANA_OID_CANA=cab.CANA_OID_CANA
           and cab1.PAIS_OID_PAIS=cab.PAIS_OID_PAIS
           and cro1.CACT_OID_ACTI=cro.CACT_OID_ACTI
           and cro1.CGZO_OID_CABE_GRUP_ZONA=cro.CGZO_OID_CABE_GRUP_ZONA
       ) as fecha_prev,
       ( select max(cro2.fec_fina)
         from cra_crono_grupo_zona cro2,
              cra_cabec_grupo_zona cab2,
              cra_activ act2
         where cro2.PERD_OID_PERI=per.OID_PERI
           and cab2.MARC_OID_MARC=cab.MARC_OID_MARC
           and cab2.CANA_OID_CANA=cab.CANA_OID_CANA
           and cab2.PAIS_OID_PAIS=cab.PAIS_OID_PAIS
           and cro2.CACT_OID_ACTI=cro.CACT_OID_ACTI
           and cro2.CGZO_OID_CABE_GRUP_ZONA=cro.CGZO_OID_CABE_GRUP_ZONA
       )as fecha_fina
       from zon_regio reg,
       zon_zona zon,
       cra_crono_grupo_zona cro,
       cra_cabec_grupo_zona cab,
       cra_detal_grupo_zona det,
       cra_perio per,
       cra_activ act
where zon.ZORG_OID_REGI=reg.OID_REGI
  and cro.CGZO_OID_CABE_GRUP_ZONA=cab.OID_CABE_GRUP_ZONA
  and cab.OID_CABE_GRUP_ZONA=det.CGZO_OID_CABE_GRUP_ZONA
  and det.ZZON_OID_ZONA=zon.OID_ZONA
  and cro.PERD_OID_PERI=per.OID_PERI
  and cro.CACT_OID_ACTI=act.OID_ACTI
  and cro.PERD_OID_PERI= idperi_par
  and reg.pais_oid_pais = idpais_par
  and reg.marc_oid_marc = idmarca_par
  and reg.cana_oid_cana = idcanal_par
  and zon.pais_oid_pais = idpais_par
  and zon.marc_oid_marc = idmarca_par
  and zon.cana_oid_cana = idcanal_par
  and cab.pais_oid_pais = idpais_par
  and cab.marc_oid_marc = idmarca_par
  and cab.cana_oid_cana = idcanal_par
)
where OID_REGI = idregi_par
  and OID_CRON_GRUP_ZONA = idgrupo_par
group by cod_regi, cod_grup, des_regi, cod_acti, periodo, cod_zona, fecha_prev, fecha_fina;


/*
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
*/

    v_return varchar2(2000);
    ret     varchar2(20);

  begin

    OPEN c_cursor;
	LOOP
		FETCH c_cursor INTO ret;
		  exit when c_cursor%notfound;
		  v_return := v_return||' '||ret;
	end loop;
	CLOSE c_cursor;

    return v_return;

end;


FUNCTION FN_010_CONCAT_PRODUCTOS (
	ididioma_par in number,
	idcurso_par in number
)
return varchar2


is

/*
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
*/

  cursor c_cursor is
  select prod.COD_SAP, gen_produ.regalo
  from edu_matri_curso cur,
  	 edu_regal rega,
  	 edu_regal_detal det_regal,
  	 mae_produ prod,
  	 (
  	 select gen.VAL_OID, gen.VAL_I18N regalo
  	 from v_gen_i18n_sicc gen
  	 where gen.ATTR_ENTI= 'MAE_PRODU'
  	 	   and gen.IDIO_OID_IDIO = ididioma_par
  	 )gen_produ
  where cur.OID_CURS = idcurso_par
  	  and cur.REGA_OID_REGA = rega.OID_REGA(+)
  	  and rega.OID_REGA = det_regal.REGA_OID_REGA
  	  and det_regal.PROD_OID_PROD = prod.OID_PROD
  	  and gen_produ.val_oid(+) = prod.oid_prod
  order by prod.COD_SAP, gen_produ.regalo;

    v_return varchar2(20000);

    ret     varchar2(20);
    ret2     varchar2(4000);

begin
  OPEN c_cursor;
	LOOP
		FETCH c_cursor INTO ret, ret2;
		  exit when c_cursor%notfound;
		  v_return := v_return || ret || '-' || ret2 || '      ';
	end loop;
	CLOSE c_cursor;

  return v_return;

end;

FUNCTION FN_CU_CALC_CUPON_EN_TRAMITE (
	idpais_par in varchar,
	idclien_par in varchar
)
return number

is

  var_aux_num number;

begin

	 EXECUTE IMMEDIATE 'SELECT NVL(SUM(d.IMP_DETA),0) as suma ' ||
	 		 		   'FROM CCC_CUPON_TRAMI_DEPUR c, CCC_DETAL_CUPON_TRAMI_DEPUR d, ' ||
					   'CCC_SITUA_CUPON s ' ||
					   'WHERE c.OID_CUPO_TRAM_DEPU = d.CTDE_OID_CUPO_TRAM_DEPU ' ||
					   'AND d.SICU_OID_SITU_CUPO = s.OID_SITU_CUPO ' ||
					   'AND c.PAIS_OID_PAIS = :1 ' ||
					   'AND d.CLIE_OID_CLIE = :2 ' ||
					   'AND s.COD_SITU_CUPO = ''T'''
	 INTO var_aux_num
	 USING idpais_par, idclien_par ;

  	 return var_aux_num;

end;


FUNCTION FN_CU_CALC_DEUDA_VENC_CLIEN (
	idpais_par in  number,
	idclien_par in number
)
return number

is

  var_aux_num number;

begin

	 EXECUTE IMMEDIATE 'SELECT NVL(SUM(IMP_PEND),0) as suma ' ||
  		  			   'FROM CCC_MOVIM_CUENT_CORRI m, MAE_CLIEN c ' ||
  		  			   'WHERE m.CLIE_OID_CLIE = c.OID_CLIE ' ||
  		  			   'AND c.PAIS_OID_PAIS= :1 ' ||
  		  			   'AND m.CLIE_OID_CLIE = :2 ' ||
  		  			   'AND m.IMP_MOVI <> m.IMP_PAGA'
	 INTO var_aux_num
	 USING idpais_par, idclien_par;

  	 return var_aux_num;

end;


FUNCTION FN_CU_CALC_DIAS_ATRASO_CLIEN (
	idpais_par in  number,
	idclien_par in number
)
return number

is

   var_aux varchar2(2000):= 'SELECT m.FEC_ULTI_MOVI, m.FEC_VENC ' ||
  		  				   'FROM CCC_MOVIM_CUENT_CORRI m, MAE_CLIEN c ' ||
  		  				   'WHERE m.CLIE_OID_CLIE = c.OID_CLIE ' ||
  		  				   'AND c.PAIS_OID_PAIS= ' || idpais_par || ' ' ||
  		  				   'AND m.CLIE_OID_CLIE = ' || idclien_par || ' ' ||
  		  				   'AND ( TO_DATE( SYSDATE,''YYYY-MM-DD'') - m.FEC_VENC) > 0 ' ||
  		  				   'AND m.IMP_MOVI <> m.IMP_PAGA ' ||
  		  				   'AND m.IMP_PAGO <> 0 ' ||
  		  				   'AND m.FEC_ULTI_MOVI > m.FEC_VENC ' ||
  		  				   'UNION ' ||
  		  				   'SELECT h.FEC_MOVI, h.FEC_VENC ' ||
  		  				   'FROM CCC_HISTO_MOVIM_CC h, MAE_CLIEN c ' ||
  		  				   'WHERE h.CLIE_OID_CLIE = c.OID_CLIE ' ||
  		  				   'AND c.PAIS_OID_PAIS= ' || idpais_par || ' ' ||
  		  				   'AND h.CLIE_OID_CLIE = ' || idclien_par || ' ' ||
  		  				   'AND ( TO_DATE( SYSDATE ,''YYYY-MM-DD'') - h.FEC_VENC) > 0 ' ||
  		  				   'AND h.IMP <> h.IMP_PAGA ' ||
  		  				   'AND h.IMP_PAGO <> 0 ' ||
  		  				   'AND h.FEC_MOVI > h.FEC_VENC ';
/*---------------------------------------------------------------------------------------
Timestamp valorFechaM = new Timestamp(((Date) regs.getValueAt(i, "FEC_ULTI_MOVI")).getTime());
Timestamp valorFechaV = new Timestamp(((Date) regs.getValueAt(i, "FEC_VENC")).getTime());
Long valorImporteP = new Long(((BigDecimal) regs.getValueAt(i,"IMP_PAGO")).longValue());

long dias = ((valorFechaM.getTime() - valorFechaV.getTime()) / 86400000);

long valorTotal = dias * valorImporteP.longValue();

Long lngvalorTotal = new Long(valorTotal);

dtoDias.setNumeroDias(new Integer(lngvalorTotal.intValue()));

total += valorImporteP.longValue();
}

dtoDias.setNumeroDias(new Integer(
dtoDias.getNumeroDias().intValue() / total));
*/
    type    my_curs_type is REF CURSOR;
    curs    my_curs_type;
	var_ulti_movi date;
	var_fec_venc date;
	var_tot_dias int;
	var_cant_dias int;
	var_retorno int;

  begin

  	var_tot_dias:=0;
    OPEN curs FOR var_aux;
	LOOP
		FETCH curs INTO var_ulti_movi, var_fec_venc;
		  exit when curs%notfound;
		  var_tot_dias:= var_tot_dias + (var_ulti_movi-var_fec_venc);
	end loop;

	var_cant_dias:= curs%rowcount;

	CLOSE curs;
	if var_cant_dias = 0 then
	   var_retorno := 0;
	else
	   var_retorno:= var_tot_dias/var_cant_dias;
	end if;

    return var_retorno;
end;


FUNCTION FN_CU_CALC_MONTO_SOLIC_NUEVAS (
	idclien_par in varchar
)
return number


is

  var_aux_num number;

begin

	 EXECUTE IMMEDIATE 'SELECT NVL(SUM(CA.VAL_TOTA_PAGA_LOCA),0) MONTO_SOLICITUDES_NUEVAS ' ||
  			  		   'FROM PED_SOLIC_CABEC CA ' ||
					   'WHERE CA.CLIE_OID_CLIE = :1 ' ||
		   			   'AND CA.FEC_FACT IS NULL AND CA.ESSO_OID_ESTA_SOLI= 1 ' ||
		   			   'OR CA.ESSO_OID_ESTA_SOLI= 5 ' ||
					   'AND (CA.IND_PEDI_PRUE is NULL OR CA.IND_PEDI_PRUE<>1)'
	 INTO var_aux_num
	 USING idclien_par;

  	 return var_aux_num;

end;


FUNCTION FN_CU_CALC_PED_PROMEDIO_CLIEN (
	idclien_par in number,
	idclasesolic_par in number,
--	idtipoperi_par in number,
	idperi1_par in number,
	idperi2_par in number

)
return number

is

  var_aux_num number;

begin

  	 EXECUTE IMMEDIATE 'SELECT NVL(AVG(SUM(A.val_tota_paga_loca)),0) ' ||
  		  			   'FROM ped_solic_cabec A, cra_perio B, cra_perio C, cra_perio D ' ||
  		  			   'WHERE   A.clie_oid_clie = :1 ' ||
  		  			   'AND     A.clso_oid_clas_soli = :2 ' ||
  		  			   'AND A.fec_fact IS NOT NULL ' ||
  		  			   'AND NVL(A.ind_ts_no_conso, 0) = 0 ' ||
  		  			   'AND NVL(A.ind_pedi_prue, 0) = 0 ' ||
  		  			   'AND B.oid_peri = A.perd_oid_peri  ' ||
  		  			   'AND C.oid_peri = :3 ' ||
  		  			   'AND D.oid_peri = :4 ' ||
  		  			   'AND B.fec_inic >= C.fec_inic ' ||
  		  			   'AND B.fec_fina <= D.fec_fina ' ||
					   'GROUP BY A.val_tota_paga_loca'
	 INTO var_aux_num
	 USING idclien_par, idclasesolic_par, idperi1_par, idperi2_par;

  	 return var_aux_num;

end;



FUNCTION FN_CU_CALC_PERI_CON_PEDIDOS (
	idclien_par in number,
	idclasesolic_par in number,
--	idtipoperi_par in number,
	idperi1_par in number,
	idperi2_par in number

)
return number

is

  var_aux_num number;

begin

  	 EXECUTE IMMEDIATE 'SELECT COUNT(*) ' ||
  		  			   'FROM ( ' ||
  		  			   		 'SELECT DISTINCT A.perd_oid_peri ' ||
  		  			   		 'FROM ' ||
  		  			   		 	   'ped_solic_cabec A, ' ||
  		  			   			   'cra_perio B, ' ||
  		  			   			   'cra_perio C, ' ||
  		  			   			   'cra_perio D ' ||
  		  			   		'WHERE A.clie_oid_clie = :1 ' ||
  		  			   			   'AND A.clso_oid_clas_soli = :2 ' ||
  		  			   			   'AND A.fec_fact IS NOT NULL ' ||
  		  			   			   'AND NVL(A.ind_ts_no_conso, 0) = 0 ' ||
  		  			   			   'AND NVL(A.ind_pedi_prue, 0) = 0 ' ||
  		  			   			   'AND B.oid_peri = A.perd_oid_peri  ' ||
  		  			   			   'AND C.oid_peri = :3 ' ||
  		  			   			   'AND D.oid_peri = :4 ' ||
  		  			   			   'AND B.fec_inic >= C.fec_inic ' ||
  		  			   			   'AND B.fec_fina <= D.fec_fina' ||
  		  			   		')'
	 INTO var_aux_num
	 USING idclien_par, idclasesolic_par, idperi1_par, idperi2_par;

  	 return var_aux_num;

end;

FUNCTION FN_CU_CALC_SALDO_CTA_CTE (
	idclien_par in varchar,
	idsubg_par in varchar := NULL,
	idreg_par in varchar := NULL,
	idsecc_par in varchar := NULL
)
return number


is

  var_aux_num number;
  var_aux_str varchar2(2000):='SELECT NVL(SUM(m.IMP_PEND),0)  AS SUMA ' ||
  			  		   'FROM CCC_MOVIM_CUENT_CORRI m ' ||
					   'WHERE m.CLIE_OID_CLIE = :ID';

begin

  	 if (idsubg_par >= 0) then
  	 	var_aux_str := var_aux_str || ' AND M.ZSGV_OID_SUBG_VENT =' || idsubg_par;
	 end if;

  	 if (idreg_par >= 0) then
  	 	var_aux_str := var_aux_str || ' AND M.ZORG_OID_REGI =' || idreg_par;
	 end if;

  	 if (idsecc_par >= 0) then
  	 	var_aux_str := var_aux_str || ' AND M.ZSCC_OID_SECC =' || idsecc_par;
	 end if;

	 EXECUTE IMMEDIATE var_aux_str
	 INTO var_aux_num
	 USING idclien_par;

  	 return var_aux_num;

end;

FUNCTION FN_162_TOTAL_PROD_NEG (
	   id_peri_par in varchar,
	   id_region_par in varchar,
	   id_pais_par in varchar,
	   id_marca_par in varchar,
	   id_canal_par in varchar,
	   id_negocio_par in varchar, --PARAMETRO NO OBLIGATORIO, VENDRA -1 -
	   id_un_negocio_par in varchar, --PARAMETRO NO OBLIGATORIO, VENDRA -1 --
	   id_acceso_par in varchar, --PARAMETRO NO OBLIGATORIO, VENDRA -1 --
	   diario_par in varchar:=-1
)
return number

is

  var_aux_num varchar2(8000);
  var_aux number;
  aux varchar2(200);
  aux2 varchar2(200);

begin
	 if id_un_negocio_par = -1  then
	 	aux:='prod.UNEG_OID_UNID_NEGO';
	 else
		aux:= id_un_negocio_par;
	 end if;

	 if id_negocio_par = -1  then
	 	aux2:='prod.NEGO_OID_NEGO';
	 else
		aux2:= id_negocio_par;
	 end if;

	   var_aux_num := 'select unidades_faltantes 	  '||
				'from '||
				'(	 '||
				'	select	 '||
				'productos.nego_oid_nego, '||
				'sum((nvl(solicitudes.NUM_UNID_POR_ATEN,0) - nvl(solicitudes.NUM_UNID_ATEN,0)))unidades_faltantes  '||
				'	from (	 '||
				'(	 '||
				'select sol_no_con.oid_soli_cabe, '||
				'pos.oid_soli_posi, '||
				'pos.VAL_PREC_NETO_TOTA_LOCA, '||
				'pos.NUM_UNID_ATEN, '||
				'pos.NUM_UNID_POR_ATEN,	 '||
				'pos.prod_oid_prod, '||
				'sol_no_con.perd_oid_peri	 '||
				'from	   	 '||
				'	( '||
				'select * '||
				'from ped_solic_cabec sol	 '||
				'	  where sol.FEC_FACT is not null '||
				  '   and sol.IND_PEDI_PRUE <> 1	  '||
				'	and sol.IND_TS_NO_CONSO = 1  '||
				')sol_no_con,    	  '||
				'ped_solic_posic pos, '||
				'ped_estad_posic est_pos, '||
				'zon_zona zon, '||
				'ped_tipo_solic_pais t_sol_p, '||
				'ped_tipo_solic t_sol '||
				'where '||
				'	sol_no_con.oid_soli_cabe = pos.SOCA_OID_SOLI_CABE '||
				'	and pos.ESPO_OID_ESTA_POSI = est_pos.OID_ESTA_POSI(+)	 '||
				'	and est_pos.COD_ESTA_POSI(+) <> ''AN'' '||
				'	and pos.NUM_UNID_POR_ATEN > pos.NUM_UNID_ATEN  '||
				'	and  sol_no_con.FEC_FACT = ( decode( ' || diario_par || ' ' ||
				',-1,sol_no_con.FEC_FACT,sysdate - 1) ) '||
				'	and sol_no_con.perd_oid_peri= ' || id_peri_par || ' '||
				'	and sol_no_con.ZZON_OID_ZONA = zon.oid_zona '||
				'	and zon.ZORG_OID_REGI in (  ' || id_region_par || ' ) '||
				'	and sol_no_con.TSPA_OID_TIPO_SOLI_PAIS =  t_sol_p.oid_tipo_soli_pais '||
				'	and t_sol_p.tsol_oid_tipo_soli = t_sol.oid_tipo_soli '||
				'	and t_sol.acce_oid_acce = ( decode( ' || id_acceso_par || ' ' ||
				',-1,t_sol.acce_oid_acce,' || id_acceso_par || ') ) '||
				')solicitudes	 	  	  	 '||
				'inner join 	 '||
				'(	   '||
				'select prod_per.OID_PROD, prod_per.UNEG_OID_UNID_NEGO, prod_per.nego_oid_nego  '||
				'from    '||
				'( '||
				'select prod.OID_PROD, prod.UNEG_OID_UNID_NEGO, prod.nego_oid_nego 	  '||
				'from    '||
				'	mae_produ prod, '||
				'	cra_perio per, '||
				'	(	 '||
				'select *	 '||
				'from cra_perio per 	 '||
				'where  per.pais_oid_pais = ' || id_pais_par || ' '||
				'	and per.marc_oid_marc = ' || id_marca_par || ' 	 '||
				'	and per.cana_oid_cana = ' || id_canal_par || '	 '||
				'	)  per_inic,	  '||
				'	(   '||
				'select *	 '||
				'from cra_perio per 	 '||
				'where  per.pais_oid_pais = ' || id_pais_par || ' '||
				'	and per.marc_oid_marc = ' || id_marca_par || ' 	 '||
				'	and per.cana_oid_cana = ' || id_canal_par || '	 '||
				'	)  per_fina  '||
				'where   '||
				'prod.PERD_OID_PERI_INIC = per_inic.oid_peri '||
				'and prod.PERD_OID_PERI_FIN = per_fina.oid_peri '||
				'and per_inic.fec_inic <= per.FEC_INIC  '||
				'and per_fina.fec_fina >= per.fec_fina '||
				'and per.oid_peri = ' || id_peri_par || ' '||
				'and prod.UNEG_OID_UNID_NEGO in ( ' || aux  || ' ) '||
				'and prod.nego_oid_nego in ( ' || aux2 || ' ) '||
				'union	 	 '||
				'	select prod.OID_PROD, prod.UNEG_OID_UNID_NEGO, prod.nego_oid_nego  '||
				'	from mae_produ prod	   '||
				'	where ( prod.PERD_OID_PERI_INIC is null '||
				'or prod.PERD_OID_PERI_FIN is null )	 '||
				'  and prod.UNEG_OID_UNID_NEGO in ( ' || aux  || ' )  '||
				'  and prod.nego_oid_nego in ( ' || aux2 || '	)    '||
				')prod_per 	   '||
				')productos '||
				'on solicitudes.prod_oid_prod = productos.oid_prod	 '||
				'inner join cra_perio per	    '||
				'on solicitudes.perd_oid_peri = per.oid_peri '||
				'	)	    '||
				'	group by productos.nego_oid_nego '||
				'	order by unidades_faltantes desc '||
				')	  '||
				'where rownum < 9';

	 EXECUTE IMMEDIATE var_aux_num INTO var_aux;

  	 return nvl(var_aux,0);

end;


FUNCTION FN_112_CALC_PER_ANT (
	idpais_par in varchar,
	idmarc_par in varchar,
	idcana_par in varchar,
	idperi_reg in varchar,
	idperi_rec in varchar
)
return number


is

  var_aux_num number;

begin

		 EXECUTE IMMEDIATE

							'select count (*) as cant_per								' ||
							'from cra_perio c,	 										' ||
							'	 (														' ||
							'	  select ci.oid_peri, ci.fec_fina						' ||
							'	  from cra_perio ci	  									' ||
							'	  where ci.oid_peri = :1								' ||
							'	 ) i,				  									' ||
							'	 ( 														' ||
							'	  select ci.oid_peri, ci.fec_fina						' ||
							'	  from cra_perio ci	  									' ||
							'	  where ci.oid_peri = :2								' ||
							'	 ) f 				  									' ||
							'where 														' ||
							'	 c.fec_fina >= i.fec_fina  								' ||
							'	 and c.fec_fina <= f.fec_fina							' ||
							'	 and c.pais_oid_pais = :3								' ||
							'	 and c.marc_oid_marc = :4								' ||
							'	 and c.cana_oid_cana = :5								'


	 INTO var_aux_num
	 USING idperi_reg , idperi_rec, idpais_par, idmarc_par, idcana_par;

  	 return var_aux_num;

end;

FUNCTION FN_008_CALC_OID_PER_ANT (
	idpais_par in varchar,
	idmarc_par in varchar,
	idcana_par in varchar,
	id_peri in varchar,
	n_peri in varchar
)
return number


is

  var_aux_num number;

begin

		 EXECUTE IMMEDIATE


		 		 'SELECT OID_PERI			                    '||
                 'FROM                                          '||
				 '	(                                           '||
				 '	SELECT OID_PERI,                            '||
				 '		   ROWNUM AS POS                        '||
				 '	FROM                                        '||
				 '		(                                       '||
				 '		SELECT PERI.OID_PERI	                '||
				 '		FROM CRA_PERIO PERI,                    '||
				 '			 (                                  '||
				 '			 SELECT FEC_FINA                    '||
				 '			 FROM CRA_PERIO                     '||
				 '			 WHERE OID_PERI = :1                '||
				 '			 ) FF  			  					'||
				 '		WHERE FF.FEC_FINA >= PERI.FEC_FINA		'||
				 '			  AND PERI.PAIS_OID_PAIS = :2	  	'||
				 '			  AND PERI.MARC_OID_MARC = :3		'||
				 '			  AND PERI.CANA_OID_CANA = :4		'||
				 '		ORDER BY PERI.FEC_FINA DESC	   			'||
				 '		)	  	 								'||
				 '	)											'||
				 'WHERE POS =	:5								'



	 INTO var_aux_num
	 USING id_peri, idpais_par, idmarc_par, idcana_par, n_peri;

  	 return var_aux_num;

end;


FUNCTION FN_011_CALC_RANK_POR_REGION (
	idpais_par in varchar,
	idmarc_par in varchar,
	idcana_par in varchar,
	id_reg in varchar,
	id_peri_desde in varchar,
	id_peri_hasta in varchar,
	id_cli in varchar

)
return number


is

  var_aux_num number;

begin

		 EXECUTE IMMEDIATE


				'SELECT POS                                                 '||
				'FROM                                                       '||
				'(                                                          '||
				'	SELECT CLIE_OID_CLIE,                                   '||
				'		   VENTA,                                           '||
				'		   ROWNUM AS POS                                    '||
				'	FROM                                                    '||
				'	(                                                       '||
				'		SELECT SEG_CLI.CLIE_OID_CLIE,                       '||
				'			   SUM(SEG_CLI.VAL_VENT) VENTA                  '||
				'		FROM DTR_SEGME_CLIEN SEG_CLI,                       '||
				'			 CRA_PERIO PERI,                                '||
				'			 ZON_REGIO REGI,                                '||
				'			 (                                              '||
				'			 SELECT FEC_INIC                                '||
				'			 FROM CRA_PERIO                                 '||
				'			 WHERE OID_PERI = :1	 				        '||
				'			 ) FI,                                          '||
				'			 (                                              '||
				'			 SELECT FEC_FINA                                '||
				'			 FROM CRA_PERIO                                 '||
				'			 WHERE OID_PERI = :2					        '||
				'			 ) FF	                                        '||
				'		WHERE FI.FEC_INIC <= PERI.FEC_INIC                  '||
				'			  AND FF.FEC_FINA >= PERI.FEC_FINA              '||
				'			  AND SEG_CLI.PERD_OID_PERI = PERI.OID_PERI     '||
				'			  AND SEG_CLI.ZORG_OID_REGI = REGI.OID_REGI     '||
				'			  AND REGI.OID_REGI = :3			   	        '||
				'			  AND PERI.PAIS_OID_PAIS = :4  			        '||
				'			  AND PERI.CANA_OID_CANA = :5			        '||
				'			  AND PERI.MARC_OID_MARC = :6			        '||
				'		GROUP BY REGI.OID_REGI,                             '||
				'				 SEG_CLI.CLIE_OID_CLIE	                    '||
				'		ORDER BY VENTA DESC                                 '||
				'	)                                                       '||
				')	                                                        '||
				'WHERE CLIE_OID_CLIE = :7                                    '




	 INTO var_aux_num
	 USING id_peri_desde, id_peri_hasta, id_reg, idpais_par, idcana_par, idmarc_par, id_cli;

  	 return var_aux_num;

end;


end pq_apl_rep;
/


GRANT EXECUTE ON  OWN_PERU.PQ_APL_REP TO USU_PERU;

