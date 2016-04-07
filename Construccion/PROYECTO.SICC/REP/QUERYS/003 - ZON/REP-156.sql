/* Formatted on 2005/07/07 17:44 (Formatter Plus v4.8.0) */
SELECT   pai.cod_pais, mar.des_marc AS marca, gen3.val_i18n AS canal,
         subg.cod_subg_vent, reg.cod_regi, zon.cod_zona, sec.cod_secc,
         ter.cod_terr, sec.des_secci AS seccion,
         un_adm2.oid_clie_unid_admi AS un_adm_sale,
         un_adm.oid_clie_unid_admi AS un_adm_actual,
            cli.val_ape1
         || ' '
         || cli.val_ape2
         || ' '
         || cli.val_nom1
         || ' '
         || cli.val_nom2 AS gerente_zona,
         cli2.oid_clie, cli2.cod_clie,
            cli2.val_ape1
         || ' '
         || cli2.val_ape2
         || ' '
         || cli2.val_nom1
         || ' '
         || cli2.val_nom2 AS nombre_completo,
         pai.cod_pais, subg2.cod_subg_vent, reg2.cod_regi, zon2.cod_zona,
         sec2.cod_secc, ter2.cod_terr, 0 AS cantidad
    FROM mae_clien_unida_admin un_adm,
         mae_clien_unida_admin un_adm2,
         mae_clien cli,
         mae_clien cli2,
         cra_perio per,
         cra_perio per2,
         zon_terri_admin zta,
         zon_secci sec,
         zon_zona zon,
         zon_regio reg,
         zon_sub_geren_venta subg,
         zon_terri ter,
         zon_terri_admin zta2,
         zon_secci sec2,
         zon_zona zon2,
         zon_regio reg2,
         zon_sub_geren_venta subg2,
         zon_terri ter2,
         seg_marca mar,
         seg_canal can,
         seg_pais pai,
         v_gen_i18n_sicc gen3,
         (SELECT MIN (per3.fec_inic) AS fid, MAX (per3.fec_fina) AS ffd,
                 MIN (per4.fec_inic) AS fih, MAX (per4.fec_fina) AS ffh
            FROM cra_perio per3, cra_perio per4
           WHERE per3.oid_peri = 1001                                  --value
                 AND per4.oid_peri = 1502                              --value
                                         ) per_selec
   WHERE un_adm.perd_oid_peri_ini = per.oid_peri
     AND un_adm2.perd_oid_peri_ini = per2.oid_peri
     AND un_adm.clie_oid_clie = un_adm2.clie_oid_clie
     AND per.fec_inic > per2.fec_inic
     AND un_adm.oid_clie_unid_admi <> un_adm2.oid_clie_unid_admi
     AND un_adm.ztad_oid_terr_admi = zta.oid_terr_admi
     AND zta.terr_oid_terr = ter.oid_terr
     AND zta.zscc_oid_secc = sec.oid_secc
     AND sec.zzon_oid_zona = zon.oid_zona
     AND zon.zorg_oid_regi = reg.oid_regi
     AND reg.zsgv_oid_subg_vent = subg.oid_subg_vent
     AND un_adm2.ztad_oid_terr_admi = zta2.oid_terr_admi
     AND zta2.terr_oid_terr = ter2.oid_terr
     AND zta2.zscc_oid_secc = sec2.oid_secc
     AND sec2.zzon_oid_zona = zon2.oid_zona
     AND zon2.zorg_oid_regi = reg2.oid_regi
     AND reg2.zsgv_oid_subg_vent = subg2.oid_subg_vent
     AND per.fec_inic >= per_selec.fid
     AND per.fec_inic <= per_selec.ffh
     AND subg.marc_oid_marc = mar.oid_marc
     AND subg.cana_oid_cana = can.oid_cana
     AND subg.pais_oid_pais = pai.oid_pais
     AND subg2.pais_oid_pais = pai.oid_pais
     AND gen3.attr_enti(+) = 'SEG_CANAL'
     AND gen3.val_oid(+) = can.oid_cana
     AND zon.clie_oid_clie = cli.oid_clie(+)
     AND un_adm.clie_oid_clie = cli2.oid_clie
     AND gen3.idio_oid_idio = 1                                      --value--
     AND cli2.cod_clie = '00000001597'                               --value--
     AND zon.oid_zona = 2                                            --value--
     AND reg.oid_regi = 2                                            --value--
     AND subg.oid_subg_vent = 2                                      --value--
     AND mar.oid_marc = 1                                            --value--
     AND can.oid_cana = 1                                            --value--
     AND pai.oid_pais = 1                                            --value--
ORDER BY pai.cod_pais,
         subg.cod_subg_vent,
         reg.cod_regi,
         zon.cod_zona,
         sec.cod_secc,
         ter.cod_terr,
         subg2.cod_subg_vent,
         reg2.cod_regi,
         zon2.cod_zona,
         sec2.cod_secc,
         ter2.cod_terr