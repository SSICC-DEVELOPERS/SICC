select periodos.cod_peri,
	   periodos.val_nomb_peri,
	   periodos.p as percentil,
	   datos.avg,
	   datos.monto_venta,
	   datos.cant_sol,
	   periodos.ind_grupo,
	   sum(por_apor_per) over ( partition by periodos.P order by periodos.COD_PERI, ROWNUM) as acumulado
from 
(
---------------------------------------------------------------------------------------------------------------
	select 
		   cod_peri,
		   oid_peri,
		   sum(monto_venta) as monto_venta,
		   avg(monto_venta)as avg,
		   decode(sum(monto_venta),0,0,sum(monto_venta_per)  * 100 / sum(monto_venta))as por_apor_per,
		   percentil,
		   count(oid_soli_cabe)cant_sol   
	from 
	(
	---------------------------------------------------------------------------------------------------------------
		select datos.cod_peri,
			   datos.oid_peri,
			   datos.val_nomb_peri,
			   datos.monto_venta,
			   datos.oid_soli_cabe,
			   min(tabla_percentiles.p)as percentil,
			   datos.monto_venta_per
		from 
		(
		---------------------------------------------------------------------------------------------------------------	
						select
							  oid_soli_cabe,
							  cod_peri,
							  sum(monto_venta)as monto_venta,
							  sum(sum(monto_venta)) over ( PARTITION BY cod_peri order by 1 ) monto_venta_per,
							  row_number() over (partition by cod_peri order by nvl(sum(monto_venta),0) desc) * 100 /
							  count(oid_soli_cabe) OVER (PARTITION BY cod_peri ORDER BY 1) as percentil,
							  val_nomb_peri,
							  oid_peri
						from
							(
								select 
									  sol.oid_soli_cabe,
									  per.val_nomb_peri,
									  per.oid_peri,
									  cor.COD_PERI,
									  pos.OID_SOLI_POSI,
									  sol.VAL_TIPO_CAMB,
									  sol.fec_fact,
									  (
											  case
											  	  when
												  	  pla_con.TVEN_OID_TIPO_VENT = 3 then --PARAMETRO TIPO DE VENTA--
													  			 nvl(pos.NUM_UNID_COMPR,0) * nvl(pos.VAL_PREC_CATA_UNIT_DOCU,0)
												  when
												  	  pla_con.TVEN_OID_TIPO_VENT = 1 then --PARAMETRO TIPO DE VENTA--
													  			 (nvl(pos.NUM_UNID_COMPR,0) * nvl(pos.VAL_PREC_CATA_UNIT_DOCU,0)) -
																 (nvl(pos.VAL_PORC_DESC,0)
																  * nvl(pos.NUM_UNID_COMPR,0)) -
																 (nvl(pos.VAL_IMPO_IMPU_UNIT_DOCU,0) * nvl(pos.NUM_UNID_COMPR,0))
												  when
												  	  pla_con.TVEN_OID_TIPO_VENT = 2 then --PARAMETRO TIPO DE VENTA--										  	   			 
												  				 (nvl(pos.NUM_UNID_COMPR,0) * nvl(pos.VAL_PREC_CATA_UNIT_DOCU,0)) -
																 (nvl(pos.VAL_PORC_DESC,0)
																 * nvl(pos.NUM_UNID_COMPR,0))
											  end
											  ) * decode( nvl(sol.val_tipo_camb,0),0,1,sol.val_tipo_camb ) *
											  decode( pais.mone_oid_mone,2, --2 ES PARAMETRO MONEDA--
											  1,
											  ( select tip_cam.VAL_TIPO_CAMB
											    from seg_tipo_cambi tip_cam
											    where pais.MONE_OID_MONE = tip_cam.MONE_OID_MON1
											   		 and tip_cam.MONE_OID_MON2 = 2  --PARAMETRO MONEDA--
													 and sol.FEC_FACT between tip_cam.FEC_DESD and tip_cam.FEC_HAST )
									   ) as monto_venta
								from 
									 ped_solic_cabec sol,
									 ped_solic_posic pos,
									 cra_perio per,
									 inc_concu_param_gener con,
									 inc_plant_concu pla_con,
									 zon_zona zon,
									 zon_regio reg,
									 pre_ofert_detal of_det,
									 mae_produ prod,
									 mae_clien_tipo_subti subt,
									 mae_clien_clasi cla,
									 seg_perio_corpo cor,
								 	 seg_pais pais
								where
									 sol.OID_SOLI_CABE = pos.soca_oid_soli_cabe
								--	 and sol.pais_oid_pais = 1 --PARAMETRO PAIS--
									 and sol.PERD_OID_PERI = per.oid_peri
									 and per.marc_oid_marc = 1 --PARAMETRO MARCA--
									 and per.cana_oid_cana = 1 --PARAMETRO CANAL--
								--	 and sol.ZZON_OID_ZONA in (1) --PARAMETRO ZONA--
									 and sol.ZZON_OID_ZONA = zon.OID_ZONA
									 and zon.ZORG_OID_REGI = reg.OID_REGI
									 and sol.IND_OC = 1
								--	 and reg.OID_REGI in (1) --PARAMETRO REGION--
								--	 and reg.ZSGV_OID_SUBG_VENT in (1) --PARAMETRO SUBGERENCIA--
									 and pos.OFDE_OID_DETA_OFER = of_det.OID_DETA_OFER
								--	 and of_det.TOFE_OID_TIPO_OFER not in (1) --PARAMETRO TIPO OFERTA--
									 and pos.prod_oid_prod = prod.oid_prod
								--	 and prod.UNEG_OID_UNID_NEGO in (1) --PARAMETRO UNIDAD DE NEGOCIO--
								--	 and prod.NEGO_OID_NEGO in (1) --PARAMETRO NEGOCIO--
									 and per.PERI_OID_PERI = cor.OID_PERI
									 and cor.VAL_ANIO = '2004' --PARAMETRO AÑO--
									 and sol.pais_oid_pais = pais.OID_PAIS
									 and subt.clie_oid_clie = sol.clie_oid_clie
	 								 and subt.oid_clie_tipo_subt = cla.CTSU_OID_CLIE_TIPO_SUBT
									 /*and subt.SBTI_OID_SUBT_CLIE in (1) --PARAMETRO SUBTIPO CLIENTE--
									 and subt.ticl_oid_tipo_clie in (1) --PARAMETRO TIPO CLIENTE--
									 and cla.CLAS_OID_CLAS in (1) --PARAMETRO CLASIFICACION--
									 and cla.TCCL_OID_TIPO_CLASI in (1) --PARAMETRO TIPO CLASIFICACION--*/
									 and sol.COPA_OID_PARA_GENE = con.OID_PARA_GRAL
									 and con.PLC2_OID_PLAN_CONC = pla_con.OID_PLAN_CONC
									 and pla_con.TVEN_OID_TIPO_VENT = 2 --PARAMETRO TIPO DE VENTA--
							)
						group by 
							  oid_soli_cabe,
							  val_tipo_camb,
							  val_nomb_peri,
							  oid_peri,
							  cod_peri,
							  fec_fact
		---------------------------------------------------------------------------------------------------------------
				)datos,
				(
				select *
				from 
					(
						select	0.1 p from dual union select	0.2	from dual union select	0.3	from dual union
						select	0.4	from dual union select	0.5	from dual union select	0.6	from dual union
						select	0.7	from dual union select	0.8	from dual union select	0.9	from dual union
						select	1 	from dual union select	2	from dual union select	3	from dual union
						select	4	from dual union select	5	from dual union select	6	from dual union
						select	7	from dual union select	8	from dual union select	9	from dual union
						select	10	from dual union select	11	from dual union select	12	from dual union
						select	13	from dual union select	14	from dual union select	15	from dual union
						select	16	from dual union select	17	from dual union select	18	from dual union
						select	19	from dual union select	20	from dual union select	21	from dual union
						select	22	from dual union select	23	from dual union select	24	from dual union
						select	25	from dual union select	26	from dual union select	27	from dual union
						select	28	from dual union select	29	from dual union select	30	from dual union
						select	31	from dual union select	32	from dual union select	33	from dual union
						select	34	from dual union select	35	from dual union select	36	from dual union
						select	37	from dual union select	38	from dual union select	39	from dual union
						select	40	from dual union select	41	from dual union select	42	from dual union
						select	43	from dual union select	44	from dual union select	45	from dual union
						select	46	from dual union select	47	from dual union select	48	from dual union
						select	49	from dual union select	50	from dual union select	51	from dual union
						select	52	from dual union select	53	from dual union select	54	from dual union
						select	55	from dual union select	56	from dual union select	57	from dual union
						select	58	from dual union select	59	from dual union select	60	from dual union
						select	61	from dual union select	62	from dual union select	63	from dual union
						select	64	from dual union select	65	from dual union select	66	from dual union
						select	67	from dual union select	68	from dual union select	69	from dual union
						select	70	from dual union select	71	from dual union select	72	from dual union
						select	73	from dual union select	74	from dual union select	75	from dual union
						select	76	from dual union select	77	from dual union select	78	from dual union
						select	79	from dual union select	80	from dual union select	81	from dual union
						select	82	from dual union select	83	from dual union select	84	from dual union
						select	85	from dual union select	86	from dual union select	87	from dual union
						select	88	from dual union select	89	from dual union select	90	from dual union
						select	91	from dual union select	92	from dual union select	93	from dual union
						select	94	from dual union select	95	from dual union select	96	from dual union
						select	97	from dual union select	98	from dual union select	99	from dual union
						select	100	from dual
					)
				where p in (0.2,0.3,0.4,0.5,0.9,1,2,3,4,7,13,16,19,50,100) --PARAMETRO PERCENTILES--
				)
				tabla_percentiles
			where datos.percentil <= tabla_percentiles.p
			group by datos.cod_peri,
			   datos.oid_peri,
			   datos.val_nomb_peri,
			   datos.monto_venta,
	   		   datos.monto_venta_per,
			   oid_soli_cabe
	---------------------------------------------------------------------------------------------------------------			   
	)
	group by cod_peri, oid_peri, percentil
---------------------------------------------------------------------------------------------------------------		   
)datos,
(
	select tabla_percentiles.*,
		   periodos.*
	from
			(
			select *
			from 
				(
					select	0.1 p from dual union select	0.2	from dual union select	0.3	from dual union
					select	0.4	from dual union select	0.5	from dual union select	0.6	from dual union
					select	0.7	from dual union select	0.8	from dual union select	0.9	from dual union
					select	1 	from dual union select	2	from dual union select	3	from dual union
					select	4	from dual union select	5	from dual union select	6	from dual union
					select	7	from dual union select	8	from dual union select	9	from dual union
					select	10	from dual union select	11	from dual union select	12	from dual union
					select	13	from dual union select	14	from dual union select	15	from dual union
					select	16	from dual union select	17	from dual union select	18	from dual union
					select	19	from dual union select	20	from dual union select	21	from dual union
					select	22	from dual union select	23	from dual union select	24	from dual union
					select	25	from dual union select	26	from dual union select	27	from dual union
					select	28	from dual union select	29	from dual union select	30	from dual union
					select	31	from dual union select	32	from dual union select	33	from dual union
					select	34	from dual union select	35	from dual union select	36	from dual union
					select	37	from dual union select	38	from dual union select	39	from dual union
					select	40	from dual union select	41	from dual union select	42	from dual union
					select	43	from dual union select	44	from dual union select	45	from dual union
					select	46	from dual union select	47	from dual union select	48	from dual union
					select	49	from dual union select	50	from dual union select	51	from dual union
					select	52	from dual union select	53	from dual union select	54	from dual union
					select	55	from dual union select	56	from dual union select	57	from dual union
					select	58	from dual union select	59	from dual union select	60	from dual union
					select	61	from dual union select	62	from dual union select	63	from dual union
					select	64	from dual union select	65	from dual union select	66	from dual union
					select	67	from dual union select	68	from dual union select	69	from dual union
					select	70	from dual union select	71	from dual union select	72	from dual union
					select	73	from dual union select	74	from dual union select	75	from dual union
					select	76	from dual union select	77	from dual union select	78	from dual union
					select	79	from dual union select	80	from dual union select	81	from dual union
					select	82	from dual union select	83	from dual union select	84	from dual union
					select	85	from dual union select	86	from dual union select	87	from dual union
					select	88	from dual union select	89	from dual union select	90	from dual union
					select	91	from dual union select	92	from dual union select	93	from dual union
					select	94	from dual union select	95	from dual union select	96	from dual union
					select	97	from dual union select	98	from dual union select	99	from dual union
					select	100	from dual
				)
			where p in (0.2,0.3,0.4,0.5,0.9,1,2,3,4,7,13,16,19,50,13) --PARAMETRO PERCENTILES--
			)
			tabla_percentiles,
			(				
			select per.val_nomb_peri,
				   per.OID_PERI,
				   cod_peri,
--				   substr(cor.cod_peri,5,2)as cod_per,
				   trunc((substr(cor.cod_peri,5,2) - 1 )/6) as ind_grupo				   
			from cra_perio per,
				 seg_perio_corpo cor
			where
				 per.peri_oid_peri = cor.OID_PERI
				 and cor.VAL_ANIO = '2004' --PARAMETRO ANIO--
				 and per.pais_oid_pais = 1 --PARAMETRO PAIS--
				 and per.marc_oid_marc = 1 --PARAMETRO MARCA--
				 and per.cana_oid_cana = 1 --MARAMETRO CANAL--
			)periodos
)periodos
where
	 datos.oid_peri(+) = periodos.oid_peri 
	 and datos.percentil(+) = periodos.p
ORDER BY PERCENTIL, COD_PERI