select *
from (
	select oid_curs,
		   plantilla,
		   des_curs,
		   count(oid_clie)cantidad,
   		   IND_ASIS,
		   cod_zona,
		   modalidad,
		   fec_disp_curs,
		   FEC_LANZ,
		   fec_fin_curs,
		   desc_periodo_n,
		   sum(periodo_n)periodo_n,
		   desc_periodo_n_1,
		   sum(periodo_n_1)periodo_n_1,
		   desc_periodo_n_2,
		   sum(periodo_n_2)periodo_n_2,
		   desc_periodo_n_3,
		   sum(periodo_n_3)periodo_n_3,
		   desc_periodo_n_4,
		   sum(periodo_n_4)periodo_n_4,
		   desc_periodo_n_5,
		   sum(periodo_n_5)periodo_n_5,
		   desc_periodo_n_6,
		   sum(periodo_n_6)periodo_n_6,
		   desc_periodo_n_7,
		   sum(periodo_n_7)periodo_n_7,
		   desc_periodo_n_8,
		   sum(periodo_n_8)periodo_n_8,
		   desc_periodo_n_9,
		   sum(periodo_n_9)periodo_n_9
	from 
	(
		select cur.oid_curs,
			   cur.DES_CURS,
			  zon.cod_zona,
			  decode(his.ind_apta,1,'APTA','INVITADA')modalidad, --EN ESTE CASO DEBERA MOSTRARSE(intenacionalizado) --
			  cur.CPLC_OID_CABE_PLAN_CURS plantilla,
			  cur.FEC_DISP_CURS,
			  cur.FEC_LANZ,
			  cur.FEC_FIN_CURS,
			  his.IND_ASIS,
			  cli.OID_CLIE,
			  --DESCRIPCION PERIODO N--
		  (
		  select per_n.val_nomb_peri
		  from cra_perio per_n
		  where per_n.oid_peri = --TRAE EL PERIODO CORRESPONDIENTE--
		  					   	 (
			  					   	 select oid_peri
									 from
									 (	 
										 (
										 select oid_peri, VAL_NOMB_PERI, fec_inic, fec_fina, rownum as pos
										 from 
											 (
											 select per.oid_peri, per.VAL_NOMB_PERI, per.fec_fina, per.fec_inic
												from cra_perio per,
													 (
													 select per2.fec_fina
													 from cra_perio per2
													 where per2.oid_peri = 57 --PARAMETRO--
													 )per_param
												where per_param.fec_fina >= per.fec_fina
													  and per.pais_oid_pais = 1 --PARAMETRO--
													  and per.cana_oid_cana = 1 --PARAMETRO--
													  and per.marc_oid_marc = 1 --PARAMETRO--
												order by per.fec_fina desc
											 )
										 where rownum in (1,2,3,4,5,6,7,8,9,10)
										 )
									 )
									 where pos = 1
								 )
		  )desc_periodo_n, 
		  --SE CREA LA COLUMNA n --
		  (
			  select sum(pos.VAL_PREC_CATA_TOTA_LOCA)
			  from ped_solic_cabec sol,
			  	   ped_solic_posic pos
			  where sol.CLIE_OID_CLIE = cli.oid_clie
					and sol.TSPA_OID_TIPO_SOLI_PAIS_CONS is not null --CONDICION DE CONSOLIDADO--
					and sol.SOCA_OID_SOLI_CABE is not null  	  	   --CONDICION DE CONSOLIDADO--
					and pos.SOCA_OID_SOLI_CABE = sol.oid_soli_cabe
					and sol.perd_oid_peri =
										   	(
					  					   	 select oid_peri
											 from
											 (	 
												 (
												 select oid_peri, VAL_NOMB_PERI, fec_inic, fec_fina, rownum as pos
												 from 
													 (
													 select per.oid_peri, per.VAL_NOMB_PERI, per.fec_fina, per.fec_inic
														from cra_perio per,
															 (
															 select per2.fec_fina
															 from cra_perio per2
															 where per2.oid_peri = 57 --PARAMETRO--
															 )per_param
														where per_param.fec_fina >= per.fec_fina
															  and per.pais_oid_pais = 1 --PARAMETRO--
															  and per.cana_oid_cana = 1 --PARAMETRO--
															  and per.marc_oid_marc = 1 --PARAMETRO--
														order by per.fec_fina desc
													 )
												 where rownum in (1,2,3,4,5,6,7,8,9,10)
												 )
											 )
											 where pos = 1
										 )					
			  group by sol.perd_oid_peri
		  )periodo_n,
	  	  --DESCRIPCION PERIODO N-1 --
		  (
		  select per_n.val_nomb_peri
		  from cra_perio per_n
		  where per_n.oid_peri = (
			  					   	 select oid_peri
									 from
									 (	 
										 (
										 select oid_peri, VAL_NOMB_PERI, fec_inic, fec_fina, rownum as pos
										 from 
											 (
											 select per.oid_peri, per.VAL_NOMB_PERI, per.fec_fina, per.fec_inic
												from cra_perio per,
													 (
													 select per2.fec_fina
													 from cra_perio per2
													 where per2.oid_peri = 57 --PARAMETRO--
													 )per_param
												where per_param.fec_fina >= per.fec_fina
													  and per.pais_oid_pais = 1 --PARAMETRO--
													  and per.cana_oid_cana = 1 --PARAMETRO--
													  and per.marc_oid_marc = 1 --PARAMETRO--
												order by per.fec_fina desc
											 )
										 where rownum in (1,2,3,4,5,6,7,8,9,10)
										 )
									 )
									 where pos = 2
								 )
		  )desc_periodo_n_1, 
		  --SE CREA LA COLUMNA n-1 --
		  (
			  select sum(pos.VAL_PREC_CATA_TOTA_LOCA)
			  from ped_solic_cabec sol,
			  	   ped_solic_posic pos
			  where sol.CLIE_OID_CLIE = cli.oid_clie
					and sol.TSPA_OID_TIPO_SOLI_PAIS_CONS is not null --CONDICION DE CONSOLIDADO--
					and sol.SOCA_OID_SOLI_CABE is not null  	  	   --CONDICION DE CONSOLIDADO--
					and pos.SOCA_OID_SOLI_CABE = sol.oid_soli_cabe
					and sol.perd_oid_peri = (
						  					  							  	 select oid_peri
												 from
												 (	 
													 (
													 select oid_peri, VAL_NOMB_PERI, fec_inic, fec_fina, rownum as pos
													 from 
														 (
														 select per.oid_peri, per.VAL_NOMB_PERI, per.fec_fina, per.fec_inic
															from cra_perio per,
																 (
																 select per2.fec_fina
																 from cra_perio per2
																 where per2.oid_peri = 57 --PARAMETRO--
																 )per_param
															where per_param.fec_fina >= per.fec_fina
																  and per.pais_oid_pais = 1 --PARAMETRO--
																  and per.cana_oid_cana = 1 --PARAMETRO--
																  and per.marc_oid_marc = 1 --PARAMETRO--
															order by per.fec_fina desc
														 )
													 where rownum in (1,2,3,4,5,6,7,8,9,10)
													 )
												 )
												 where pos = 2
											)
			  group by sol.perd_oid_peri
		  )periodo_n_1,
	  	  --DESCRIPCION PERIODO N-2 --
		  (
		  select per_n.val_nomb_peri
		  from cra_perio per_n
		  where per_n.oid_peri = (
				  					   	 select oid_peri
										 from
										 (	 
											 (
											 select oid_peri, VAL_NOMB_PERI, fec_inic, fec_fina, rownum as pos
											 from 
												 (
												 select per.oid_peri, per.VAL_NOMB_PERI, per.fec_fina, per.fec_inic
													from cra_perio per,
														 (
														 select per2.fec_fina
														 from cra_perio per2
														 where per2.oid_peri = 57 --PARAMETRO--
														 )per_param
													where per_param.fec_fina >= per.fec_fina
														  and per.pais_oid_pais = 1 --PARAMETRO--
														  and per.cana_oid_cana = 1 --PARAMETRO--
														  and per.marc_oid_marc = 1 --PARAMETRO--
													order by per.fec_fina desc
												 )
											 where rownum in (1,2,3,4,5,6,7,8,9,10)
											 )
										 )
										 where pos = 3
								 )
		  )desc_periodo_n_2, 
		  --SE CREA LA COLUMNA n-2 --
		  (
			  select sum(pos.VAL_PREC_CATA_TOTA_LOCA)
			  from ped_solic_cabec sol,
			  	   ped_solic_posic pos
			  where sol.CLIE_OID_CLIE = cli.oid_clie
					and sol.TSPA_OID_TIPO_SOLI_PAIS_CONS is not null --CONDICION DE CONSOLIDADO--
					and sol.SOCA_OID_SOLI_CABE is not null  	  	   --CONDICION DE CONSOLIDADO--
					and pos.SOCA_OID_SOLI_CABE = sol.oid_soli_cabe
					and sol.perd_oid_peri = (
						  					   	 select oid_peri
												 from
												 (	 
													 (
													 select oid_peri, VAL_NOMB_PERI, fec_inic, fec_fina, rownum as pos
													 from 
														 (
														 select per.oid_peri, per.VAL_NOMB_PERI, per.fec_fina, per.fec_inic
															from cra_perio per,
																 (
																 select per2.fec_fina
																 from cra_perio per2
																 where per2.oid_peri = 57 --PARAMETRO--
																 )per_param
															where per_param.fec_fina >= per.fec_fina
																  and per.pais_oid_pais = 1 --PARAMETRO--
																  and per.cana_oid_cana = 1 --PARAMETRO--
																  and per.marc_oid_marc = 1 --PARAMETRO--
															order by per.fec_fina desc
														 )
													 where rownum in (1,2,3,4,5,6,7,8,9,10)
													 )
												 )
												 where pos = 3
										 	 )
			  group by sol.perd_oid_peri
		  )periodo_n_2,
	  	  --DESCRIPCION PERIODO N-3 --
		  (
		  select per_n.val_nomb_peri
		  from cra_perio per_n
		  where per_n.oid_peri = (
				  					   	 select oid_peri
										 from
										 (	 
											 (
											 select oid_peri, VAL_NOMB_PERI, fec_inic, fec_fina, rownum as pos
											 from 
												 (
												 select per.oid_peri, per.VAL_NOMB_PERI, per.fec_fina, per.fec_inic
													from cra_perio per,
														 (
														 select per2.fec_fina
														 from cra_perio per2
														 where per2.oid_peri = 57 --PARAMETRO--
														 )per_param
													where per_param.fec_fina >= per.fec_fina
														  and per.pais_oid_pais = 1 --PARAMETRO--
														  and per.cana_oid_cana = 1 --PARAMETRO--
														  and per.marc_oid_marc = 1 --PARAMETRO--
													order by per.fec_fina desc
												 )
											 where rownum in (1,2,3,4,5,6,7,8,9,10)
											 )
										 )
										 where pos = 4
								 	 )
		  )desc_periodo_n_3, 
		  --SE CREA LA COLUMNA n-3 --
		  (
			  select sum(pos.VAL_PREC_CATA_TOTA_LOCA)
			  from ped_solic_cabec sol,
			  	   ped_solic_posic pos
			  where sol.CLIE_OID_CLIE = cli.oid_clie
					and sol.TSPA_OID_TIPO_SOLI_PAIS_CONS is not null --CONDICION DE CONSOLIDADO--
					and sol.SOCA_OID_SOLI_CABE is not null  	  	   --CONDICION DE CONSOLIDADO--
					and pos.SOCA_OID_SOLI_CABE = sol.oid_soli_cabe
					and sol.perd_oid_peri = (
						  					   	 select oid_peri
												 from
												 (	 
													 (
													 select oid_peri, VAL_NOMB_PERI, fec_inic, fec_fina, rownum as pos
													 from 
														 (
														 select per.oid_peri, per.VAL_NOMB_PERI, per.fec_fina, per.fec_inic
															from cra_perio per,
																 (
																 select per2.fec_fina
																 from cra_perio per2
																 where per2.oid_peri = 57 --PARAMETRO--
																 )per_param
															where per_param.fec_fina >= per.fec_fina
																  and per.pais_oid_pais = 1 --PARAMETRO--
																  and per.cana_oid_cana = 1 --PARAMETRO--
																  and per.marc_oid_marc = 1 --PARAMETRO--
															order by per.fec_fina desc
														 )
													 where rownum in (1,2,3,4,5,6,7,8,9,10)
													 )
												 )
												 where pos = 4
										 	 )
		  group by sol.perd_oid_peri
		  )periodo_n_3,
	   	  --DESCRIPCION PERIODO N-4 --
		  (
		  select per_n.val_nomb_peri
		  from cra_perio per_n
		  where per_n.oid_peri = (
				  					   	 select oid_peri
										 from
										 (	 
											 (
											 select oid_peri, VAL_NOMB_PERI, fec_inic, fec_fina, rownum as pos
											 from 
												 (
												 select per.oid_peri, per.VAL_NOMB_PERI, per.fec_fina, per.fec_inic
													from cra_perio per,
														 (
														 select per2.fec_fina
														 from cra_perio per2
														 where per2.oid_peri = 57 --PARAMETRO--
														 )per_param
													where per_param.fec_fina >= per.fec_fina
														  and per.pais_oid_pais = 1 --PARAMETRO--
														  and per.cana_oid_cana = 1 --PARAMETRO--
														  and per.marc_oid_marc = 1 --PARAMETRO--
													order by per.fec_fina desc
												 )
											 where rownum in (1,2,3,4,5,6,7,8,9,10)
											 )
										 )
										 where pos = 5
								 	 )
		  )desc_periodo_n_4, 
		  --SE CREA LA COLUMNA n-4 --
		  (
		  select sum(pos.VAL_PREC_CATA_TOTA_LOCA)
			  from ped_solic_cabec sol,
			  	   ped_solic_posic pos
			  where sol.CLIE_OID_CLIE = cli.oid_clie
					and sol.TSPA_OID_TIPO_SOLI_PAIS_CONS is not null --CONDICION DE CONSOLIDADO--
					and sol.SOCA_OID_SOLI_CABE is not null  	  	   --CONDICION DE CONSOLIDADO--
					and pos.SOCA_OID_SOLI_CABE = sol.oid_soli_cabe
					and sol.perd_oid_peri = (
						  					   	 select oid_peri
												 from
												 (	 
													 (
													 select oid_peri, VAL_NOMB_PERI, fec_inic, fec_fina, rownum as pos
													 from 
														 (
														 select per.oid_peri, per.VAL_NOMB_PERI, per.fec_fina, per.fec_inic
															from cra_perio per,
																 (
																 select per2.fec_fina
																 from cra_perio per2
																 where per2.oid_peri = 57 --PARAMETRO--
																 )per_param
															where per_param.fec_fina >= per.fec_fina
																  and per.pais_oid_pais = 1 --PARAMETRO--
																  and per.cana_oid_cana = 1 --PARAMETRO--
																  and per.marc_oid_marc = 1 --PARAMETRO--
															order by per.fec_fina desc
														 )
													 where rownum in (1,2,3,4,5,6,7,8,9,10)
													 )
												 )
												 where pos = 5
										 	 )
			  group by sol.perd_oid_peri
		  )periodo_n_4,
	   	  --DESCRIPCION PERIODO N-5 --
		  (
		  select per_n.val_nomb_peri
		  from cra_perio per_n
		  where per_n.oid_peri = (
				  					   	 select oid_peri
										 from
										 (	 
											 (
											 select oid_peri, VAL_NOMB_PERI, fec_inic, fec_fina, rownum as pos
											 from 
												 (
												 select per.oid_peri, per.VAL_NOMB_PERI, per.fec_fina, per.fec_inic
													from cra_perio per,
														 (
														 select per2.fec_fina
														 from cra_perio per2
														 where per2.oid_peri = 57 --PARAMETRO--
														 )per_param
													where per_param.fec_fina >= per.fec_fina
														  and per.pais_oid_pais = 1 --PARAMETRO--
														  and per.cana_oid_cana = 1 --PARAMETRO--
														  and per.marc_oid_marc = 1 --PARAMETRO--
													order by per.fec_fina desc
												 )
											 where rownum in (1,2,3,4,5,6,7,8,9,10)
											 )
										 )
										 where pos = 6
								 	 )
		  )desc_periodo_n_5, 
		  --SE CREA LA COLUMNA n-5 --
		  (
			  select sum(pos.VAL_PREC_CATA_TOTA_LOCA)
			  from ped_solic_cabec sol,
			  	   ped_solic_posic pos
			  where sol.CLIE_OID_CLIE = cli.oid_clie
					and sol.TSPA_OID_TIPO_SOLI_PAIS_CONS is not null --CONDICION DE CONSOLIDADO--
					and sol.SOCA_OID_SOLI_CABE is not null  	  	   --CONDICION DE CONSOLIDADO--
					and pos.SOCA_OID_SOLI_CABE = sol.oid_soli_cabe
					and sol.perd_oid_peri = (
						  					   	 select oid_peri
												 from
												 (	 
													 (
													 select oid_peri, VAL_NOMB_PERI, fec_inic, fec_fina, rownum as pos
													 from 
														 (
														 select per.oid_peri, per.VAL_NOMB_PERI, per.fec_fina, per.fec_inic
															from cra_perio per,
																 (
																 select per2.fec_fina
																 from cra_perio per2
																 where per2.oid_peri = 57 --PARAMETRO--
																 )per_param
															where per_param.fec_fina >= per.fec_fina
																  and per.pais_oid_pais = 1 --PARAMETRO--
																  and per.cana_oid_cana = 1 --PARAMETRO--
																  and per.marc_oid_marc = 1 --PARAMETRO--
															order by per.fec_fina desc
														 )
													 where rownum in (1,2,3,4,5,6,7,8,9,10)
													 )
												 )
												 where pos = 6
										 	 )
			  group by sol.perd_oid_peri
		  )periodo_n_5,
	   	  --DESCRIPCION PERIODO N-6 --
		  (
		  select per_n.val_nomb_peri
		  from cra_perio per_n
		  where per_n.oid_peri = (
				  					   	 select oid_peri
										 from
										 (	 
											 (
											 select oid_peri, VAL_NOMB_PERI, fec_inic, fec_fina, rownum as pos
											 from 
												 (
												 select per.oid_peri, per.VAL_NOMB_PERI, per.fec_fina, per.fec_inic
													from cra_perio per,
														 (
														 select per2.fec_fina
														 from cra_perio per2
														 where per2.oid_peri = 57 --PARAMETRO--
														 )per_param
													where per_param.fec_fina >= per.fec_fina
														  and per.pais_oid_pais = 1 --PARAMETRO--
														  and per.cana_oid_cana = 1 --PARAMETRO--
														  and per.marc_oid_marc = 1 --PARAMETRO--
													order by per.fec_fina desc
												 )
											 where rownum in (1,2,3,4,5,6,7,8,9,10)
											 )
										 )
										 where pos = 7
								 	 )
		  )desc_periodo_n_6, 
		  --SE CREA LA COLUMNA n-6 --
		  (
			  select sum(pos.VAL_PREC_CATA_TOTA_LOCA)
			  from ped_solic_cabec sol,
			  	   ped_solic_posic pos
			  where sol.CLIE_OID_CLIE = cli.oid_clie
					and sol.TSPA_OID_TIPO_SOLI_PAIS_CONS is not null --CONDICION DE CONSOLIDADO--
					and sol.SOCA_OID_SOLI_CABE is not null  	  	   --CONDICION DE CONSOLIDADO--
					and pos.SOCA_OID_SOLI_CABE = sol.oid_soli_cabe
					and sol.perd_oid_peri = (
						  					   	 select oid_peri
												 from
												 (	 
													 (
													 select oid_peri, VAL_NOMB_PERI, fec_inic, fec_fina, rownum as pos
													 from 
														 (
														 select per.oid_peri, per.VAL_NOMB_PERI, per.fec_fina, per.fec_inic
															from cra_perio per,
																 (
																 select per2.fec_fina
																 from cra_perio per2
																 where per2.oid_peri = 57 --PARAMETRO--
																 )per_param
															where per_param.fec_fina >= per.fec_fina
																  and per.pais_oid_pais = 1 --PARAMETRO--
																  and per.cana_oid_cana = 1 --PARAMETRO--
																  and per.marc_oid_marc = 1 --PARAMETRO--
															order by per.fec_fina desc
														 )
													 where rownum in (1,2,3,4,5,6,7,8,9,10)
													 )
												 )
												 where pos = 7
										 	 )
			  group by sol.perd_oid_peri
		  )periodo_n_6,
	   	  --DESCRIPCION PERIODO N-7 --
		  (
		  select per_n.val_nomb_peri
		  from cra_perio per_n
		  where per_n.oid_peri = (
				  					   	 select oid_peri
										 from
										 (	 
											 (
											 select oid_peri, VAL_NOMB_PERI, fec_inic, fec_fina, rownum as pos
											 from 
												 (
												 select per.oid_peri, per.VAL_NOMB_PERI, per.fec_fina, per.fec_inic
													from cra_perio per,
														 (
														 select per2.fec_fina
														 from cra_perio per2
														 where per2.oid_peri = 57 --PARAMETRO--
														 )per_param
													where per_param.fec_fina >= per.fec_fina
														  and per.pais_oid_pais = 1 --PARAMETRO--
														  and per.cana_oid_cana = 1 --PARAMETRO--
														  and per.marc_oid_marc = 1 --PARAMETRO--
													order by per.fec_fina desc
												 )
											 where rownum in (1,2,3,4,5,6,7,8,9,10)
											 )
										 )
										 where pos = 8
								 	 )
		  )desc_periodo_n_7, 
		  --SE CREA LA COLUMNA n-7 --
		  (
			  select sum(pos.VAL_PREC_CATA_TOTA_LOCA)
			  from ped_solic_cabec sol,
			  	   ped_solic_posic pos
			  where sol.CLIE_OID_CLIE = cli.oid_clie
					and sol.TSPA_OID_TIPO_SOLI_PAIS_CONS is not null --CONDICION DE CONSOLIDADO--
					and sol.SOCA_OID_SOLI_CABE is not null  	  	   --CONDICION DE CONSOLIDADO--
					and pos.SOCA_OID_SOLI_CABE = sol.oid_soli_cabe
					and sol.perd_oid_peri = (
						  					   	 select oid_peri
												 from
												 (	 
													 (
													 select oid_peri, VAL_NOMB_PERI, fec_inic, fec_fina, rownum as pos
													 from 
														 (
														 select per.oid_peri, per.VAL_NOMB_PERI, per.fec_fina, per.fec_inic
															from cra_perio per,
																 (
																 select per2.fec_fina
																 from cra_perio per2
																 where per2.oid_peri = 57 --PARAMETRO--
																 )per_param
															where per_param.fec_fina >= per.fec_fina
																  and per.pais_oid_pais = 1 --PARAMETRO--
																  and per.cana_oid_cana = 1 --PARAMETRO--
																  and per.marc_oid_marc = 1 --PARAMETRO--
															order by per.fec_fina desc
														 )
													 where rownum in (1,2,3,4,5,6,7,8,9,10)
													 )
												 )
												 where pos = 8
										 	 )
			  group by sol.perd_oid_peri
		  )periodo_n_7,
	   	  --DESCRIPCION PERIODO N-8 --
		  (
		  select per_n.val_nomb_peri
		  from cra_perio per_n
		  where per_n.oid_peri = (
				  					   	 select oid_peri
										 from
										 (	 
											 (
											 select oid_peri, VAL_NOMB_PERI, fec_inic, fec_fina, rownum as pos
											 from 
												 (
												 select per.oid_peri, per.VAL_NOMB_PERI, per.fec_fina, per.fec_inic
													from cra_perio per,
														 (
														 select per2.fec_fina
														 from cra_perio per2
														 where per2.oid_peri = 57 --PARAMETRO--
														 )per_param
													where per_param.fec_fina >= per.fec_fina
														  and per.pais_oid_pais = 1 --PARAMETRO--
														  and per.cana_oid_cana = 1 --PARAMETRO--
														  and per.marc_oid_marc = 1 --PARAMETRO--
													order by per.fec_fina desc
												 )
											 where rownum in (1,2,3,4,5,6,7,8,9,10)
											 )
										 )
										 where pos = 9
								 	 )
		  )desc_periodo_n_8, 
		  --SE CREA LA COLUMNA n-8 --
		  (
			  select sum(pos.VAL_PREC_CATA_TOTA_LOCA)
			  from ped_solic_cabec sol,
			  	   ped_solic_posic pos
			  where sol.CLIE_OID_CLIE = cli.oid_clie
					and sol.TSPA_OID_TIPO_SOLI_PAIS_CONS is not null --CONDICION DE CONSOLIDADO--
					and sol.SOCA_OID_SOLI_CABE is not null  	  	   --CONDICION DE CONSOLIDADO--
					and pos.SOCA_OID_SOLI_CABE = sol.oid_soli_cabe
					and sol.perd_oid_peri = (
						  					   	 select oid_peri
												 from
												 (	 
													 (
													 select oid_peri, VAL_NOMB_PERI, fec_inic, fec_fina, rownum as pos
													 from 
														 (
														 select per.oid_peri, per.VAL_NOMB_PERI, per.fec_fina, per.fec_inic
															from cra_perio per,
																 (
																 select per2.fec_fina
																 from cra_perio per2
																 where per2.oid_peri = 57 --PARAMETRO--
																 )per_param
															where per_param.fec_fina >= per.fec_fina
																  and per.pais_oid_pais = 1 --PARAMETRO--
																  and per.cana_oid_cana = 1 --PARAMETRO--
																  and per.marc_oid_marc = 1 --PARAMETRO--
															order by per.fec_fina desc
														 )
													 where rownum in (1,2,3,4,5,6,7,8,9,10)
													 )
												 )
												 where pos = 9
										 	 )
			  group by sol.perd_oid_peri
		  )periodo_n_8,
	  	  --DESCRIPCION PERIODO N-9 --
		  (
		  select per_n.val_nomb_peri
		  from cra_perio per_n
		  where per_n.oid_peri = (
					  					 select oid_peri
											 from
											 (	 
												 (
												 select oid_peri, VAL_NOMB_PERI, fec_inic, fec_fina, rownum as pos
												 from 
													 (
													 select per.oid_peri, per.VAL_NOMB_PERI, per.fec_fina, per.fec_inic
														from cra_perio per,
															 (
															 select per2.fec_fina
															 from cra_perio per2
															 where per2.oid_peri = 57 --PARAMETRO--
															 )per_param
														where per_param.fec_fina >= per.fec_fina
															  and per.pais_oid_pais = 1 --PARAMETRO--
															  and per.cana_oid_cana = 1 --PARAMETRO--
															  and per.marc_oid_marc = 1 --PARAMETRO--
														order by per.fec_fina desc
													 )
												 where rownum in (1,2,3,4,5,6,7,8,9,10)
												 )
											 )
											 where pos = 10
									 	 )
		  )desc_periodo_n_9, 
		  --SE CREA LA COLUMNA n-9 --
		  (
			  select sum(pos.VAL_PREC_CATA_TOTA_LOCA)
			  from ped_solic_cabec sol,
			  	   ped_solic_posic pos
			  where sol.CLIE_OID_CLIE = cli.oid_clie
					and sol.TSPA_OID_TIPO_SOLI_PAIS_CONS is not null --CONDICION DE CONSOLIDADO--
					and sol.SOCA_OID_SOLI_CABE is not null  	  	   --CONDICION DE CONSOLIDADO--
					and pos.SOCA_OID_SOLI_CABE = sol.oid_soli_cabe
					and sol.perd_oid_peri = (
							  					 select oid_peri
													 from
													 (	 
														 (
														 select oid_peri, VAL_NOMB_PERI, fec_inic, fec_fina, rownum as pos
														 from 
															 (
															 select per.oid_peri, per.VAL_NOMB_PERI, per.fec_fina, per.fec_inic
																from cra_perio per,
																	 (
																	 select per2.fec_fina
																	 from cra_perio per2
																	 where per2.oid_peri = 57 --PARAMETRO--
																	 )per_param
																where per_param.fec_fina >= per.fec_fina
																	  and per.pais_oid_pais = 1 --PARAMETRO--
																	  and per.cana_oid_cana = 1 --PARAMETRO--
																	  and per.marc_oid_marc = 1 --PARAMETRO--
																order by per.fec_fina desc
															 )
														 where rownum in (1,2,3,4,5,6,7,8,9,10)
														 )
													 )
													 where pos = 10
											 	 )
			  group by sol.perd_oid_peri
		  )periodo_n_9  		  		  		  		  		  		  
		from edu_matri_curso cur,
			 edu_histo_curso his,
			 mae_clien cli,
			 mae_clien_unida_admin un_adm,
			 zon_terri_admin ter_adm,
			 zon_secci sec,
			 zon_zona zon,
			 cra_perio per   
		where his.MCUR_OID_CURS = cur.OID_CURS
			  and his.CLIE_OID_CLIE = cli.OID_CLIE
			  and un_adm.CLIE_OID_CLIE = cli.oid_clie
			  and un_adm.ZTAD_OID_TERR_ADMI = ter_adm.OID_TERR_ADMI
			  and ter_adm.ZSCC_OID_SECC = sec.OID_SECC
			  and sec.ZZON_OID_ZONA = zon.OID_ZONA
			  and cur.CANA_OID_CANA = 1 --PARAMETRO--
			  and cur.MARC_OID_MARC = 1 --PARAMETRO--
			  and cur.PAIS_OID_PAIS = 1 --PARAMETRO--
		--	  and zon.oid_zona = 1 --PARAMETRO--
			  and his.ind_apta = 1 --PARAMETRO--
			  and cur.fec_lanz between per.fec_inic and per.fec_fina
			  and per.oid_peri = 57 --PARAMETRO--
	--	  	  and cur.OID_CURS = 1 --PARAMETRO--
	--		  and cur.CPLC_OID_CABE_PLAN_CURS = 1 --PARAMETRO--
		group by cur.oid_curs,
				cur.CPLC_OID_CABE_PLAN_CURS,
			  	his.IND_ASIS,
				cur.DES_CURS,
		  		zon.cod_zona,
		  		cur.FEC_DISP_CURS,
				cur.FEC_LANZ,
				cur.FEC_FIN_CURS,
				cli.OID_CLIE,
				decode(his.ind_apta,1,'APTA','INVITADA')
	)
	group by 
		oid_curs,
		plantilla,
		   des_curs,
		   cod_zona,
		   modalidad,
		   fec_disp_curs,
		   fec_lanz,
		   fec_fin_curs,
		   IND_ASIS,
		   desc_periodo_n,
		   desc_periodo_n_1,
		   desc_periodo_n_2,
		   desc_periodo_n_3,
		   desc_periodo_n_4,
		   desc_periodo_n_5,
		   desc_periodo_n_6,
		   desc_periodo_n_7,
		   desc_periodo_n_8,
		   desc_periodo_n_9
   order by periodo_n asc --PARAMETRO--
)
where rownum <= 5  	--PARAMETRO--

