/**
 * Copyright 2008 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 */


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;

import es.indra.druida.DruidaConector;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.dtos.inc.DTOArticuloLoteColeccion;
import es.indra.sicc.dtos.inc.DTOReemplazoArticuloLote;
import es.indra.sicc.dtos.pre.DTOEBuscarProductos;
import es.indra.sicc.dtos.zon.DTOUnidadAdministrativa;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;



public class LPMantenimientoRemplazoPremios extends LPSICCBase{
		private String accion = null;
		private String opcionMenu = null;
		private Long idioma;
		private Long pais;

		public LPMantenimientoRemplazoPremios() {
			super();
		}

		public void inicio() throws Exception {
		}
		public void ejecucion() throws Exception{
			try{
						this.setTrazaFichero();
						this.traza("77777777777LPMantenimientoRemplazoPremios.ejecucion: Entrada");
						this.rastreo();

						accion = this.conectorParametroLimpia("accion", "", true);
						traza("accion: " + accion);
						opcionMenu = this.conectorParametroLimpia("opcionMenu", "", true);
						traza("opcionMenu: " + opcionMenu);
						idioma = UtilidadesSession.getIdioma(this);
						traza("idioma: " + idioma);
						pais = UtilidadesSession.getPais(this);
						traza("pais: " + pais);

						if(accion.equals("")){
							
							cargarPagina();

						}else if(accion.equals("guardar")){
						      guardar();

						}else if(accion.equals("consultar")){
						    this.opcionMenu = "consultarDefinirReemplazo";
							consultar();

						}else if(accion.equals("modificar")){
							this.opcionMenu = "modificarDefinirReemplazo";
							modificar();													

						}
						else if(accion.equals("generarNuevaSolicitudReemplazo")){
							generarNuevaSolicitudReemplazo();
						}
						else if(accion.equals("definirReemplazo")){
							this.opcionMenu = "detalleDefinirReemplazo";
							definirReemplazo();							
							traza("opcionMenu: " + opcionMenu );
						}else if(accion.equals("buscar")){
							buscarProducto();
						}else if(accion.equals("validarBolsaFaltante")){
								this.validarVolsaFaltante();
						}
						else if(accion.equals("validarBolsaFaltanteModificar")){
								this.validarVolsaFaltanteModificar();
						}
						else if(accion.equals("generarNuevaSolicitudReemplazoModificado")){
								this.generarNuevaSolicitudReemplazoModificado();
						}
						else if(accion.equals("obtenerPendientesBolsaFaltantes")){
							this.obtenerPendientesBolsaFaltantes();
						}
						
						cargarMenuSecundarios();

						this.traza("7777777777LPMantenimientoRemplazoPremios.ejecucion(): Salida");
			
			}catch (Exception e) {
				//logStackTrace(e);
				this.lanzarPaginaError(e);
		    }
	  }
	  public void cargarPagina() throws Exception{
				traza("7777LPMantenimientoRemplazoPremios.cargarPagina(): Entrada");
				if(opcionMenu.equals("insertar")){
			 		pagina("contenido_remplazo_premio_insertar");
					this.getFormatosValidaciones();
					cargarComboConcurso();
				
				}else{
					pagina("contenido_remplazo_premio");
					this.getFormatosValidaciones();
				}
				this.asignarAtributo("VAR", "opcionMenu", "valor", opcionMenu);
				this.asignarAtributo("VAR", "accion", "valor", accion);
				this.asignarAtributo("VAR", "idioma", "valor", idioma.toString());
				this.asignarAtributo("VAR", "pais", "valor", pais.toString());
				
				
				traza("7777LPMantenimientoRemplazoPremios.cargarPagina(): Salida 7777");
			
	  }

	  public void cargarComboConcurso() throws Exception{
				 traza("777777LPMantenimientoRemplazoPremio.cargaComboConcurso(): Entrada 7777");

				
				///Cada elemento va a contener el IDbusiness y el DTO que reciben la logica de negocio como entrada. 
                   ComposerViewElementList listElement = new ComposerViewElementList();
         
                   DTOBelcorp dtoe = new DTOBelcorp();
                   dtoe.setOidPais(pais);
                   dtoe.setOidIdioma(idioma);
         
                   ComposerViewElement elem1 = new ComposerViewElement();
                   elem1.setIDBusiness("INCObtenerConcursoNumeroNombre");
                   elem1.setDTOE(dtoe);
          
                   listElement.addViewElement(elem1);
         
                   ConectorComposerView conector = new ConectorComposerView(listElement,this.getRequest());
                   try{          
                   conector.ejecucion();
          
				   traza("conector.getConector(): " + conector.getConector());
				   
                   DruidaConector conConsultar = conector.getConector();

                   asignar("COMBO", "cbConcurso", conConsultar, "INCObtenerConcursoNumeroNombre");

				   } catch(Exception e){
						e.printStackTrace();
				   }
                   

                    traza("*** Salida - LPPresentarClientes - cargaCombos ***");


				 traza("777777LPMantenimientoRemplazoPremio.cargaComboConcurso(): Salida 7777");
        
	  }
	  public void cargarMenuSecundarios() throws Exception{
	  
				 traza("777777LPMantenimientoRemplazoPremio.cargarMenuSecundario(): Entrada 7777");
				 if(accion.equals("")){

							if(opcionMenu.equals("insertar")){	
								traza("Entro a insertar");
								this.getFormatosValidaciones();
								this.asignarAtributoPagina("cod","3402");
								this.getConfiguracionMenu("LPMantenimientoRemplazoPremios","insertar"); 			
							}  																	  
							else if(opcionMenu.equals("modificarDefinirReemplazo")){
								traza("Entro al modificar");
								this.getFormatosValidaciones();
								this.asignarAtributoPagina("cod","3419");
								this.getConfiguracionMenu("LPMantenimientoRemplazoPremios","modificarDefinirReemplazo");
							}
							else if(opcionMenu.equals("consultarDefinirReemplazo")){
								this.getFormatosValidaciones();
								this.asignarAtributoPagina("cod","3419");
								this.getConfiguracionMenu("LPMantenimientoRemplazoPremios","consultarDefinirReemplazo");
							}
							else if(opcionMenu.equals("eliminarDefinirReemplazo")){
								this.getFormatosValidaciones();
								this.asignarAtributoPagina("cod","3419");
								this.getConfiguracionMenu("LPMantenimientoRemplazoPremios","eliminarDefinirReemplazo");
							}
         
				 }
				 else if(accion.equals("modificar")){
					 traza("Entro al modificar");
					  this.getFormatosValidaciones();
					  this.asignarAtributoPagina("cod","3419");
					  this.getConfiguracionMenu("LPMantenimientoRemplazoPremios","modificarDefinirReemplazo");
				 }                     
						   
				 else if(accion.equals("consultar")){
					  this.getFormatosValidaciones();
					  this.asignarAtributoPagina("cod","3419");
					  this.getConfiguracionMenu("LPMantenimientoRemplazoPremios","detalleDefinirReemplazo");
				 }
				 else if(accion.equals("definirReemplazo")){
					  this.getFormatosValidaciones();
					  this.asignarAtributoPagina("cod","3419");
					  this.getConfiguracionMenu("LPMantenimientoRemplazoPremios","detalleDefinirReemplazo");
				 }
			     traza("777777LPMantenimientoRemplazoPremio.cargarMenuSecundario(): Salida 7777");		
	  }

	  public void definirReemplazo() throws Exception{
				traza("777777LPMantenimientoRemplazoPremio.definirReemplazo(): Entrada");
				pagina("contenido_remplazo_premio");                        
			    this.getFormatosValidaciones();	
				cargaComboCenSerGara();
				cargarComboCriterioReemplazo();
				cargarComboZonaRegion();
				asignarAtributo("VAR", "opcionMenu", "valor", opcionMenu);
				asignarAtributo("VAR", "accion", "valor", accion);
				asignarAtributo("VAR", "varPais", "valor", pais.toString());
				asignarAtributo("VAR", "varIdioma", "valor", idioma.toString());

				String numPremio = this.conectorParametroLimpia("numPremio", "", true);
				String codigoProducto = this.conectorParametroLimpia("codigoProducto", "", true);
				String descripcion = this.conectorParametroLimpia("descripcion", "", true);	
			    String oidArticuloLote = this.conectorParametroLimpia("oidArticuloLote", "", true);


				traza("77777777777 numPremio: " + numPremio);
				traza("77777777777 codigoProducto: " + codigoProducto);
				traza("77777777777 descripcion: " + descripcion);		
				//traza("77777777777 numeroOrden: " + numeroOrden);		
				
				asignarAtributo("VAR", "Npremio", "valor", numPremio);
				asignarAtributo("VAR", "codigo", "valor", codigoProducto);
				asignarAtributo("VAR", "descripcionProducto", "valor", descripcion);
				asignarAtributo("CTEXTO", "txtNumUnidades4", "valor", "1");
				//asignarAtributo("CTEXTO", "codigoSegundo", "valor", codigoProducto);
				 asignarAtributo("VAR", "oidArticuloLote", "valor", oidArticuloLote);


				traza("7777777LPMantenimientoRemplazoPremio.definirReemplazo(): Salida");	 


	  }
	  public void cargaComboCenSerGara() throws Exception{
			
			   traza("777777LPMantenimientoRemplazoPremio.cargarComboCenSerGara(): Entrada");	

			   ComposerViewElementList listElement = new ComposerViewElementList();
         
			   DTOBelcorp dtoe = new DTOBelcorp();
			   dtoe.setOidPais(pais);
			   dtoe.setOidIdioma(idioma);
	 
			   ComposerViewElement elem1 = new ComposerViewElement();
			   elem1.setIDBusiness("INCObtenerCentroServicio");
			   elem1.setDTOE(dtoe);
	  
			   listElement.addViewElement(elem1);
	 
			   ConectorComposerView conector = new ConectorComposerView(listElement,this.getRequest());
			   try{          
				   conector.ejecucion();
		  
				   traza("conector.getConector(): " + conector.getConector());
				   
				   DruidaConector conConsultar = conector.getConector();

				   asignar("COMBO","cbCenServGar",conConsultar,"INCObtenerCentroServicio"); 
				   asignar("COMBO","cbCenServEntrega",conConsultar,"INCObtenerCentroServicio"); 

			   } catch(Exception e){
					e.printStackTrace();
			   }			 
			   traza("777777LPMantenimientoRemplazoPremio.cargarComboCenSerGara(): Salida");

	  }
	 public void cargarComboCriterioReemplazo() throws Exception{
			traza("777777LPMantenimientoRemplazoPremio.cargarComboCriterioReemplazo(): Entrada");
			   ComposerViewElementList listElement = new ComposerViewElementList();
         
			   DTOBelcorp dtoe = new DTOBelcorp();
			   dtoe.setOidPais(pais);
			   dtoe.setOidIdioma(idioma);
	 
			   ComposerViewElement elem1 = new ComposerViewElement();
			   elem1.setIDBusiness("INCObtenerCriterioReemplazo");
			   elem1.setDTOE(dtoe);
	  
			   listElement.addViewElement(elem1);
	 
			   ConectorComposerView conector = new ConectorComposerView(listElement,this.getRequest());
			   try{          
					   conector.ejecucion();
			  
					   traza("conector.getConector(): " + conector.getConector());
					   
					   DruidaConector conConsultar = conector.getConector();

					   asignar("COMBO","cbCriterioReemplazo",conConsultar,"INCObtenerCriterioReemplazo"); 


			   } catch(Exception e){
					e.printStackTrace();
			   }			 

			traza("777777LPMantenimientoRemplazoPremio.cargarComboCriterioReemplazo(): Salida");
	 }
	 public void cargarComboZonaRegion() throws  Exception{
		  traza("LPMantenimientoRemplazoPremio.cargarComboZonaRegion(): Entrada");

			ComposerViewElementList listElement = new ComposerViewElementList();
			DTOUnidadAdministrativa dtoUnidadAdmin = new DTOUnidadAdministrativa();
			dtoUnidadAdmin.setOidPais(new Long(pais));
			dtoUnidadAdmin.setOidIdioma(new Long(idioma));      

			ComposerViewElement elem1 = new ComposerViewElement();
    		ComposerViewElement elem2 = new ComposerViewElement();
		    elem1.setIDBusiness("ZONRecargaZonas");
			elem1.setDTOE(dtoUnidadAdmin);
			elem2.setIDBusiness("ZONRecargaRegiones");
		    elem2.setDTOE(dtoUnidadAdmin);
	  
		    listElement.addViewElement(elem1);
			listElement.addViewElement(elem2);
	 
			ConectorComposerView conector = new ConectorComposerView(listElement,this.getRequest());
			try{          
					   conector.ejecucion();
			  
					   traza("conector.getConector(): " + conector.getConector());
					   
					   DruidaConector conConsultar = conector.getConector();

					   asignar("COMBO","cbZona",conConsultar,"ZONRecargaZonas"); 
   					   asignar("COMBO","cbRegion",conConsultar,"ZONRecargaRegiones"); 	

			} catch(Exception e){
					e.printStackTrace();
			}			 

          

		 traza("LPMantenimientoRemplazoPremio.cargarComboZonaRegion(): Salida");
	 }
	 private DruidaConector generarConectorComboRegion(RecordSet rs) throws Exception {
                  RecordSet raux = new RecordSet();
                  traza("rs: "+rs);
                  
                  raux.addColumn("OID");
                  raux.addColumn("DESC");

                  for (int fila = 0; rs.existeFila(fila); fila++) {
                           Vector v = new Vector();	
                           BigDecimal oidZona = (BigDecimal) rs.getValueAt(fila, "OID_REGI");
                           String descZona = (String) rs.getValueAt(fila, 5);

                           v.add(new Long(oidZona.longValue()));
                           v.add(descZona);
                           raux.addRow(v);
                  }

                  return UtilidadesBelcorp.generarConector("dtoSalida", raux, raux.getColumnIdentifiers());
     }
	 private DruidaConector generarConectorComboZona(RecordSet rs) throws Exception {
                  RecordSet raux = new RecordSet();
                  traza("rs: "+rs);
                  
                  raux.addColumn("OID");
                  raux.addColumn("DESC");

                  for (int fila = 0; rs.existeFila(fila); fila++) {
                           Vector v = new Vector();	
                           BigDecimal oidZona = (BigDecimal) rs.getValueAt(fila, "OID_ZONA");
                           String descZona = (String) rs.getValueAt(fila, 5);

                           v.add(new Long(oidZona.longValue()));
                           v.add(descZona);
                           raux.addRow(v);
                  }

                  return UtilidadesBelcorp.generarConector("dtoSalida", raux, raux.getColumnIdentifiers());
     }



	public void modificar() throws Exception{
					traza("LPMantenimientoRemplazoPremio.modificar(): Entrada");
					traza("777777LPMantenimientoRemplazoPremio.definirReemplazo(): Entrada");
					pagina("contenido_remplazo_premio");                        
					this.getFormatosValidaciones();	
					cargaComboCenSerGara();
					cargarComboCriterioReemplazo();
					cargarComboZonaRegion();
					asignarAtributo("VAR", "opcionMenu", "valor", opcionMenu);
					asignarAtributo("VAR", "accion", "valor", accion);
					asignarAtributo("VAR", "varPais", "valor", pais.toString());
					asignarAtributo("VAR", "varIdioma", "valor", idioma.toString());
					traza("opcionMenu: " + opcionMenu);
				    String oidReemProducto = conectorParametro("oidReemplazoArticLote")==null?"":conectorParametro("oidReemplazoArticLote");							  						
					String valoresLista1 = conectorParametro("valoresLista1")==null?"":conectorParametro("valoresLista1");
					String alcanceGeografico = conectorParametro("rbAlcanceGeografico")==null?"":conectorParametro("rbAlcanceGeografico");
		 		    StringTokenizer stv2 = new StringTokenizer(valoresLista1,";");
   					traza("valoresLista1: "+ valoresLista1);
					traza("oidReemProducto:  " + oidReemProducto); 
					String productoRemplazado = "";
					String oidProducto = "";
					String codigoProductoReemplazo = "";
					String descripcionProducto = "";
					String undidades = "";
					String codVentaFicticio = "";
					String oidCriterioReemplazo = "";
					String criterioReemplazo = "";
					String valorCriterio = "";
					String nroOrden = "";
					String indicadorActivo = "";
					String oidReemplazoArticuloLote = "";
					String IndCenServG = "";  
					String oidCenServGar = ""; 
					String NumMeses = "";
					String Observaciones = ""; 
					String PrecioPublico4 = ""; 
					String ArticuloDespacha = ""; 
					String TipoEntrega = ""; 
					String CenServEntrega = "";
					String Comunicacion = "";
					String numeroPremio = ""; 
					String descripcionProductoReemplazado = ""; 
					String oidRegion = "";
					String oidZona = "";
					String re = "";
					String zo = "";
					String oidArticuloLote = "";
					
					// sapaza -- PER-SiCC-2012-0019 -- 07/03/2012
					String posicionReemplazo = "";
					
				    traza("stv2: "+ stv2);				
				    ArrayList array = new ArrayList();
				    while (stv2.hasMoreTokens()){
						    String oid = stv2.nextToken();
							traza("oid: " + oid);
							traza(new Character(oid.charAt(0)));
							if(oid != null){			 
									  		
                                      productoRemplazado = stv2.nextToken();
									  oidProducto = stv2.nextToken();
									  codigoProductoReemplazo = stv2.nextToken();
									  descripcionProducto = stv2.nextToken();
									  undidades = stv2.nextToken();
									  codVentaFicticio = stv2.nextToken();
									  oidCriterioReemplazo = stv2.nextToken();
									  criterioReemplazo = stv2.nextToken();
									  valorCriterio = stv2.nextToken();
									  nroOrden = stv2.nextToken();
									  indicadorActivo = stv2.nextToken();
									  oidReemplazoArticuloLote = stv2.nextToken();
									  
									  // sapaza -- PER-SiCC-2012-0019 -- 07/03/2012
									  posicionReemplazo = stv2.nextToken();
									  
									  IndCenServG = stv2.nextToken();
									  oidCenServGar = stv2.nextToken();
									  NumMeses = stv2.nextToken();
									  Observaciones = stv2.nextToken();
									  PrecioPublico4 = stv2.nextToken();
									  ArticuloDespacha = stv2.nextToken();
									  TipoEntrega = stv2.nextToken();
									  CenServEntrega = stv2.nextToken();
									  Comunicacion = stv2.nextToken();
									  numeroPremio = stv2.nextToken();
									  descripcionProductoReemplazado = stv2.nextToken();
									  re = stv2.nextToken();
									  zo = stv2.nextToken();
									  oidArticuloLote = stv2.nextToken();
									  
									  traza("productoRemplazado: " + productoRemplazado ); 
									  traza("oidProducto: " + oidProducto);
									  traza("codigoProductoReemplazo: " + codigoProductoReemplazo );
									  traza("descripcionProducto: " + descripcionProducto );
									  traza("undidades: " + undidades );
									  traza("codVentaFicticio: " + codVentaFicticio );
									  traza("oidCriterioReemplazo: " + oidCriterioReemplazo );
									  traza("criterioReemplazo: " + criterioReemplazo );
									  traza("valorCriterio: " + valorCriterio );
									  traza("nroOrden: " + nroOrden );
									  traza("indicadorActivo: " + indicadorActivo );
									  traza("oidReemplazoArticuloLote: " + oidReemplazoArticuloLote );
									  
									  // sapaza -- PER-SiCC-2012-0019 -- 07/03/2012
									  traza("posicionReemplazo: " + posicionReemplazo);
									  
									  traza("IndCenServG: " + IndCenServG);
									  traza("oidCenServGar: " + oidCenServGar);
									  traza("Observaciones: " + Observaciones );
									  traza("PrecioPublico4: " + PrecioPublico4 );
									  traza("ArticuloDespacha: " + ArticuloDespacha );
									  traza("TipoEntrega: " + TipoEntrega );
									  traza("CenServEntrega: " + CenServEntrega );
									  traza("Comunicacion: " + Comunicacion );
									  traza("NumMeses: " + NumMeses );							
									  traza("numeroPremio: " + numeroPremio );
									  traza("descripcionProductoReemplazado: " + descripcionProductoReemplazado);
									  traza("re: " + re);
									  traza("zo: " + zo);
									  traza("oidArticuloLote: " + oidArticuloLote);
							} 		
				     }
					
					if(oidArticuloLote.equals("undefined")){
							 DTOReemplazoArticuloLote dto = new DTOReemplazoArticuloLote();
							 dto.setOidReemArtiLote(new Long(oidReemProducto));						
							 try{	
									MareBusinessID id = new MareBusinessID("INCObtenerDatosFaltantes");							
									Vector paramEntrada = new Vector();
									paramEntrada.add(dto);
									paramEntrada.add(id);
									traza("paramEntrada: " + paramEntrada);
									DruidaConector conector  = conectar("ConectorObtenerDatosFaltantes",  paramEntrada);
									DTOSalida dtoSalida = (DTOSalida)conector.objeto("dtoSalida");
									RecordSet rs = dtoSalida.getResultado(); 							
									traza("rs: " + rs);
									int cant = rs.getRowCount();
									if(!rs.esVacio()){												   
										       IndCenServG =((BigDecimal)rs.getValueAt(0,"IND_CENT_DIST_GARA")).toString();
											   traza("IndCenServG: " + IndCenServG);
										       if(rs.getValueAt(0,"CESE_OID_CESE_GARA") != null){
													oidCenServGar =((BigDecimal)rs.getValueAt(0,"CESE_OID_CESE_GARA")).toString();
													traza("oidCenServGar: " + oidCenServGar);
											   }	
											   if(rs.getValueAt(0,"NUM_MESE_GARA") != null){
													NumMeses =((BigDecimal)rs.getValueAt(0,"NUM_MESE_GARA")).toString();
													traza("NumMeses: " + NumMeses);
											   }
											   if(rs.getValueAt(0,"VAL_OBSE_CENT_DIST") != null){
													Observaciones =(String)rs.getValueAt(0,"VAL_OBSE_CENT_DIST");
													traza("Observaciones: " + Observaciones);
											   }
											   if(rs.getValueAt(0,"IMP_PREC_PUBL") != null){
													PrecioPublico4 =((BigDecimal)rs.getValueAt(0,"IMP_PREC_PUBL")).toString();
													traza("PrecioPublico4: " + PrecioPublico4);
                                               }
											   if(rs.getValueAt(0,"IND_DESP") != null){
													ArticuloDespacha =((BigDecimal)rs.getValueAt(0,"IND_DESP")).toString();
													traza("ArticuloDespacha: " + ArticuloDespacha);
											   }
											   if(rs.getValueAt(0,"IND_TIPO_ENTR_PREM") != null){
													TipoEntrega  = (String)rs.getValueAt(0,"IND_TIPO_ENTR_PREM");
													traza("TipoEntrega: " + TipoEntrega);
											   }
											   if(rs.getValueAt(0,"CESE_OID_CESE_ENTR") != null){
													CenServEntrega = ((BigDecimal)rs.getValueAt(0,"CESE_OID_CESE_ENTR")).toString();
													traza("CenServEntrega: " + CenServEntrega);
											   }
											   Comunicacion = ((BigDecimal)rs.getValueAt(0,"IND_COMU")).toString();
											   traza("Comunicacion: " + Comunicacion);
											   numeroPremio = ((BigDecimal)rs.getValueAt(0,"NUM_PREM")).toString();
											   traza("numeroPremio: " + numeroPremio);
											   productoRemplazado = (String)rs.getValueAt(0,"COD_SAP");
											   traza("productoRemplazado:  " + productoRemplazado);
											   descripcionProductoReemplazado = (String)rs.getValueAt(0,"VAL_I18N");											   	  								  									  
   											   traza("descripcionProductoReemplazado: " + descripcionProductoReemplazado);
											   String regio= ""; 
											   String zona = "";
									           for(int i=0; i < cant; i++){
													 if(rs.getValueAt(i,"ZORG_OID_REGI") != null){
														regio = ((BigDecimal)rs.getValueAt(i,"ZORG_OID_REGI")).toString();
														traza("regio: " + regio);
														oidRegion =  oidRegion + regio + ",";
													 }
													 if(rs.getValueAt(i,"ZZON_OID_ZONA") != null){
														zona = ((BigDecimal)rs.getValueAt(i,"ZZON_OID_ZONA")).toString();
														traza("zona: " + zona);
														oidZona =  oidZona + zona + ",";
                                                     }
												}
											oidArticuloLote = ((BigDecimal)rs.getValueAt(0,"ARLO_OID_ARTI_LOTE")).toString();
									}

								}catch(Exception ex)
     							{
									 ex.printStackTrace();						 
								}           							 
					} 
					traza("oidRegion: " + oidRegion);
					traza("oidZona: " + oidZona);
					asignarAtributo	("VAR", "codigo", "valor", productoRemplazado);// esta
					asignarAtributo("VAR", "oidProducto", "valor", oidProducto);// esta
					asignarAtributo("CTEXTO", "txtCodProducto", "valor", codigoProductoReemplazo); //esta
					
					// sapaza -- PER-SiCC-2012-0019 -- 07/03/2012
					asignarAtributo("VAR", "codigoReemplazoInicio", "valor", codigoProductoReemplazo); //esta
					
					asignarAtributo("VAR", "descripcionProducto", "valor", descripcionProductoReemplazado);// esta
					asignarAtributo("CTEXTO", "txtNumUnidades4", "valor", undidades); // esta
					if(codVentaFicticio.equals("BLANCO")){
						codVentaFicticio = "";
					}
					asignarAtributo("VAR", "codVentaFicticio", "valor", codVentaFicticio); // esta 
					asignarAtributo("VAR", "oidCriterioReemplazo", "valor", oidCriterioReemplazo);  // esta
					if(valorCriterio.equals("BLANCO")){
						valorCriterio = "";
					}
					asignarAtributo("CTEXTO", "txtValorCriterio", "valor", valorCriterio); // esta
					asignarAtributo("CTEXTO", "txtNumOrden", "valor", nroOrden); // esta
					asignarAtributo("VAR", "indicadorActivo", "valor", indicadorActivo);// esta
					asignarAtributo("VAR", "Npremio", "valor", numeroPremio); // esta					
					asignarAtributo("VAR", "desProducto", "valor", descripcionProductoReemplazado); // esta
					if(NumMeses.equals("BLANCO")){
						NumMeses = "";
					}
					asignarAtributo("CTEXTO", "txtNumMeses", "valor", NumMeses);// esta
					if(Observaciones.equals("BLANCO")){
						Observaciones = "";
					}
					asignarAtributo("AREATEXTO", "areaObservaciones", "valor", Observaciones); // esta
					if(PrecioPublico4.equals("BLANCO")){
						PrecioPublico4 = "";
					}
					asignarAtributo("CTEXTO", "txtPrecioPublico4", "valor", PrecioPublico4);// esta 
					asignarAtributo("VAR", "ArticuloDespacha4", "valor", ArticuloDespacha); // esta					
					asignarAtributo("VAR", "Comunicacion", "valor", Comunicacion); // esta
					if(!oidRegion.equals("")){
						asignarAtributo("VAR", "oidRegion", "valor", oidRegion);// falta
					}else{
						asignarAtributo("VAR", "oidRegion", "valor", re);// falta
					}
					if(!oidZona.equals("")){
						asignarAtributo("VAR", "oidZona", "valor", oidZona);// falta
					}else{
						asignarAtributo("VAR", "oidZona", "valor", zo);// falta
					}
					asignarAtributo("VAR", "ChkIndCenServG", "valor", IndCenServG); // traer de la base.
					asignarAtributo("VAR", "CriterioReemplazo", "valor", criterioReemplazo); 
					asignarAtributo("VAR", "CenServEntrega", "valor", CenServEntrega);
					asignarAtributo("VAR", "TipoEntrega", "valor", TipoEntrega);					
					asignarAtributo("VAR", "oidCenServGar", "valor", oidCenServGar);
					asignarAtributo("VAR", "oidConcurso", "valor", oidReemProducto);							
					 asignarAtributo("VAR", "oidArticuloLote", "valor", oidArticuloLote);
					 
					// sapaza -- PER-SiCC-2012-0019 -- 07/03/2012 
					asignarAtributo("VAR", "posicionReemplazo", "valor", posicionReemplazo);
					 
					traza("LPMantenimientoRemplazoPremio.modificar(): Salida");
				}
	public void guardar() throws Exception{
			       traza("LPMantenimientoRemplazoPremio.guardar(): Entrada");
				   pagina("salidaGenerica");
				   String rta = null;
				  // DTOColeccion dtos = new DTOColeccion();				   
    			   DTOArticuloLoteColeccion dtos = new DTOArticuloLoteColeccion();
                   String indicadorDespacho = this.conectorParametroLimpia("ArticuloDespacha4","", true);//
				   String precioPublico = this.conectorParametroLimpia("PrecioPublico4","", true);//				   
				   String indicadorCentroGarantia = this.conectorParametroLimpia("ChkIndCenServG","", true);
				   String indicadorTipoEntrega = this.conectorParametroLimpia("rdTipoEntrega","", true);
				   String observacion = this.conectorParametroLimpia("areaObservaciones","", true);
				   String numeroMes = this.conectorParametroLimpia("NumMeses","", true);
				   String oidCentroServicioEntrega = this.conectorParametroLimpia("oidCenServEntrega","", true);
				   String oidCentroServicioGarantia = this.conectorParametroLimpia("oidCenServGar","", true);			  
				  // String oidArticuloLote = this.conectorParametroLimpia("oidArticuloLote","", true);				  
				   String indicadorComunocacion = this.conectorParametroLimpia("ChkComunicacion","", true);
				   String region = this.conectorParametroLimpia("oidRegion","", true);
				   String zona	 = this.conectorParametroLimpia("oidZona","", true);				  
    			   String valoresLista2 = conectorParametro("valoresLista2")==null?"":conectorParametro("valoresLista2");
				   String registrosEliminados = conectorParametro("posicionesEliminadas")==null?"":conectorParametro("posicionesEliminadas");
				   String oidregio= ""; 
	    		   String oidzona = "";
    			   String reg = ""; 
                   String zon =  "";
				   DTOReemplazoArticuloLote dto = new DTOReemplazoArticuloLote();
				   int cant=0; 
				  
				   traza("valoresLista2: "+valoresLista2); 				 
				   traza("registrosEliminados: " + registrosEliminados);
				   traza("indicadorDespacho: " + indicadorDespacho);
				   traza("precioPublico: " + precioPublico);				 
				   traza("indicadorCentroGarantia: " + indicadorCentroGarantia);
				   traza("indicadorTipoEntrega: " + indicadorTipoEntrega);
				   traza("observacion: " + observacion);
				   traza("numeroMes: " + numeroMes);
				   traza("oidCentroServicioEntrega: " + oidCentroServicioEntrega);
				   traza("oidCentroServicioGarantia: " + oidCentroServicioGarantia);				 
				  // traza("oidArticuloLote: " + oidArticuloLote);				 
				   traza("indicadorComunocacion: " + indicadorComunocacion);
				   traza("region: " + region);
				   traza("zona: " + zona);
				 
				 
				   StringTokenizer stv2 = new StringTokenizer(valoresLista2,";");
				   traza("stv2: "+ stv2);
				   StringTokenizer stv3 = new StringTokenizer(registrosEliminados, ",");
				 
				   ArrayList array = new ArrayList();
				   ArrayList regiEliminado = new ArrayList();

					
				   while (stv2.hasMoreTokens()){
						    String oid = stv2.nextToken();
							traza("oid: " + oid);
							traza(new Character(oid.charAt(0)));
							if(new Character(oid.charAt(0)).toString().equals("a")){
									  traza("este es un nuevo registro");								  

                                      String productoRemplazado = stv2.nextToken();
									  String oidProducto = stv2.nextToken();
									  String codigoProductoReemplazo = stv2.nextToken();
									  String descripcionProducto = stv2.nextToken();
									  String undidades = stv2.nextToken();
									  String codVentaFicticio = stv2.nextToken();
									  String oidCriterioReemplazo = stv2.nextToken();
									  String criterioReemplazo = stv2.nextToken();
									  String valorCriterio = stv2.nextToken();
									  String nroOrden = stv2.nextToken();
									  String indicadorActivo = stv2.nextToken();
									  String oidReemplazoArticuloLote = stv2.nextToken();
									  
									  // sapaza -- PER-SiCC-2012-0019 -- 07/03/2012
									  String posicionReemplazo = stv2.nextToken();
									  
									  String IndCenServG = stv2.nextToken();
									  String oidCenServGar = stv2.nextToken();
									  String NumMeses = stv2.nextToken();
									  String Observaciones = stv2.nextToken();
									  String PrecioPublico4 = stv2.nextToken();
									  String ArticuloDespacha = stv2.nextToken();
									  String TipoEntrega = stv2.nextToken();
									  String CenServEntrega = stv2.nextToken();
									  String Comunicacion = stv2.nextToken();
									  String numeroPremio = stv2.nextToken();
									  String descripcionProductoReemplazado = stv2.nextToken();
									  String region2 = stv2.nextToken();
									  String zona2 = stv2.nextToken();
									  String oidArticuloLote = stv2.nextToken();


									  traza("productoRemplazado: " + productoRemplazado);
									  traza("oidProducto: " + oidProducto);
									  traza("codigoProductoReemplazo: " + codigoProductoReemplazo );
									  traza("descripcionProducto: " + descripcionProducto );
									  traza("undidades: " + undidades );
									  traza("codVentaFicticio: " + codVentaFicticio );
									  traza("oidCriterioReemplazo: " + oidCriterioReemplazo );
									  traza("criterioReemplazo: " + criterioReemplazo );
									  traza("valorCriterio: " + valorCriterio );
									  traza("nroOrden: " + nroOrden );
									  traza("indicadorActivo: " + indicadorActivo );
									  traza("oidReemplazoArticuloLote: " + oidReemplazoArticuloLote );
									  traza("IndCenServG: " + IndCenServG);
									  traza("oidCenServGar: " + oidCenServGar);
									  traza("Observaciones: " + Observaciones );
									  traza("PrecioPublico4: " + PrecioPublico4 );
									  traza("ArticuloDespacha: " + ArticuloDespacha );
									  traza("TipoEntrega: " + TipoEntrega );
									  traza("CenServEntrega: " + CenServEntrega );
									  traza("Comunicacion: " + Comunicacion );
									  traza("NumMeses: " + NumMeses );
									  traza("numeroPremio: " + numeroPremio );
									  traza("descripcionProductoReemplazado: " + descripcionProductoReemplazado );
									  traza("region: " + region2 );
									  traza("zona: " + zona2 );
									   traza("oidArticuloLote: " + oidArticuloLote );

									  
									  dto = generearDtoReemplazoArticuloLote(oidReemplazoArticuloLote,ArticuloDespacha, PrecioPublico4,
																				undidades, codVentaFicticio, oidProducto, IndCenServG,
																				TipoEntrega, Observaciones, NumMeses, CenServEntrega,
																				oidCenServGar, oidCriterioReemplazo, valorCriterio,
																				oidArticuloLote, nroOrden, indicadorActivo,	Comunicacion, region2, zona2);
									  array.add(dto);
									  cant = cant + 1;
									  traza("cant: " + cant);
							}else{
								  traza("este registro ya existe");
								  
								  String productoRemplazado = stv2.nextToken();
								  String oidProducto = stv2.nextToken();
								  String codigoProductoReemplazo = stv2.nextToken();
								  String descripcionProducto = stv2.nextToken();
								  String undidades = stv2.nextToken();
								  String codVentaFicticio = stv2.nextToken();
								  String oidCriterioReemplazo = stv2.nextToken();
								  String criterioReemplazo = stv2.nextToken();
								  String valorCriterio = stv2.nextToken();
								  String nroOrden = stv2.nextToken();
								  String indicadorActivo = stv2.nextToken();
								  String oidReemplazoArticuloLote = stv2.nextToken();
								  
								  // sapaza -- PER-SiCC-2012-0019 -- 07/03/2012
								  String posicionReemplazo = stv2.nextToken();
								  
								  String IndCenServ = stv2.nextToken();
								  String oidCenServGar = stv2.nextToken();
								  String NumMeses = stv2.nextToken();
								  String Observaciones = stv2.nextToken();
								  String PrecioPublico4 = stv2.nextToken();
								  String ArticuloDespacha = stv2.nextToken();
								  String TipoEntrega = stv2.nextToken();
								  String CenServEntrega = stv2.nextToken();
								  String Comunicacion = stv2.nextToken();
								  String numeroPremio = stv2.nextToken();
								  String descripcionProductoReemplazado = stv2.nextToken();							 
								  String re = stv2.nextToken();
								  String zo = stv2.nextToken();
								  String artiLote = stv2.nextToken();
					
								  traza("productoRemplazado: " + productoRemplazado);	
								  traza("oidProd: " + oidProducto );
								  traza("codigoProductoReemp: " + codigoProductoReemplazo);
								  traza("descripcionProdu: " + descripcionProducto);
								  traza("undid: " + undidades);
								  traza("codVentaFic " + codVentaFicticio);
								  traza("oidCriterioRe " + oidCriterioReemplazo);
								  traza("criterioReem " + criterioReemplazo);
								  traza("valorCrite " + valorCriterio);
								  traza("nroOrd " + nroOrden);
								  traza("indicadorAc " + indicadorActivo);
								  traza("oidReemplazoArticulo " + oidReemplazoArticuloLote);
								  traza("IndCenSe " + IndCenServ);
								  traza("oidCenSer " + oidCenServGar);
								  traza("Observa " + Observaciones);
								  traza("PrecioPubl "  + PrecioPublico4);
								  traza("ArticuloDes " + ArticuloDespacha);
								  traza("TipoEntr " + TipoEntrega);
								  traza("CenServE " + CenServEntrega);
								  traza("Comunica " + Comunicacion);
								  traza("NumMes " + NumMeses);		
								  traza("numeroPremio: " + numeroPremio );
								  traza("descripcionProductoReemplazado: " + descripcionProductoReemplazado );
								  traza("re: " + re );
								  traza("zo: " + zo );
								   traza("artiLote: " + artiLote );
								  if(!oidReemplazoArticuloLote.equals("") && !IndCenServ.equals("BLANCO")){
									  traza("Registro modificado");
									  traza("oidReemplazoArticuloLote: " + oidReemplazoArticuloLote);
									  traza("IndCenServG: " + IndCenServ);  	
									   dto = generearDtoReemplazoArticuloLote(oidReemplazoArticuloLote,ArticuloDespacha, PrecioPublico4,
																				undidades, codVentaFicticio, oidProducto, IndCenServ,
																				TipoEntrega, Observaciones, NumMeses, CenServEntrega,
																				oidCenServGar, oidCriterioReemplazo, valorCriterio,
																				artiLote, nroOrden, indicadorActivo,	Comunicacion, re, zo);												 
								   array.add(dto);
									} 								  
								
								
								
								cant = cant + 1;
    							traza("cant: " + cant);

						 }	
				      
				   }
				  while (stv3.hasMoreTokens())
			      {
						regiEliminado.add(stv3.nextToken());	
				  }
				  dtos.setRegistrosEliminados(regiEliminado);
				  dtos.setLista(array);

                
				
                  try{                            
					    MareBusinessID businessID = new MareBusinessID("INCGuardarReemplazoArticuloLote");                  
						Vector parametro = new Vector(); 
						parametro.add(dtos);
						parametro.add(businessID);
					    traza("para: " + parametro);
                        traza("********** Antes de conectar");
                        DruidaConector conector  = conectar("ConectorGuardarReemplazoAriculoLote77", parametro);
						traza("7777777777777");
						/*DTOSalida dtoSalida = (DTOSalida)conector.objeto("dtoSalida");
						RecordSet rs = dtoSalida.getResultado(); 
						if(!rs.esVacio()){
							rta = "si";
						}else{
							rta = "no";
						}*/
                        traza("*********** Despues de conectar");
                        asignarAtributo("VAR", "ejecutar", "valor", "fGuardarOK()");                  
                  }catch(Exception e){
                        traza("********* Entrando al Catch");
                        e.printStackTrace();
						asignarAtributo("VAR", "ejecutarError", "valor", "fGuardarERR()");
                        throw e;
                  }
			      traza("LPMantenimientoRemplazoPremio.guardar(): Salida");	
	}
	public DTOReemplazoArticuloLote generearDtoReemplazoArticuloLote(String oidReemplazoArticuloLote, String ArticuloDespacha, String precioPublico,
																	 String numeroUnidades, String codVentaFicticio, String oidProducto, 
																	 String indicadorCentroGarantia, String indicadorTipoEntrega, String observacion,
																	 String numeroMes, String oidCentroServicioEntrega,	String oidCentroServicioGarantia,
																	 String oidCriterioReemplazo, String valorCriterioReemplazo, String oidArticuloLote, 
		                                                             String numeroOrden,  String indicadorActiva, String indicadorComunocacion, 
																	 String region, String zona	)throws Exception{
		traza("generarReemplazoArticuloLote: Entrada");
			      DTOReemplazoArticuloLote dto = new DTOReemplazoArticuloLote();  
				  traza("oidReemplazoArticuloLote: "+oidReemplazoArticuloLote);
				  traza("precioPublico: " + precioPublico);
				  traza("indicadorDespacho: " + ArticuloDespacha);
				  traza("oidReemArtiLote: "+ oidReemplazoArticuloLote );
				  traza(" codVentFict: " +  codVentaFicticio);
				  traza(" indCentDistGara: " + indicadorCentroGarantia);
				  traza(" indTipoEntrPrem: " + indicadorTipoEntrega );
				  traza(" valObseCentDist: " + observacion );
				  traza(" numMeseGara: " +  numeroMes);
				  traza(" ceseOidCeseEntr: " + oidCentroServicioEntrega);
				  traza(" ceseOidCeseGara: " + oidCentroServicioGarantia);
				  traza(" indComu: " + indicadorComunocacion);
				  traza(" region: " + region);
				  traza(" zona: " + zona);
				 
				  if(!oidReemplazoArticuloLote.equals("") && !oidReemplazoArticuloLote.equals("undefined")){
					    traza("1");
						dto.setOidReemArtiLote(new Long(oidReemplazoArticuloLote));
				   }
				  if(!ArticuloDespacha.equals("") && !ArticuloDespacha.equals("BLANCO")){
					    if(ArticuloDespacha.equals("S")){
							traza("2");
							dto.setIndDesp(new Long(1));
						}else{
							traza("2");
							dto.setIndDesp(new Long(0));
						}
				  }
				  if(!precioPublico.equals("") && !precioPublico.equals("BLANCO") ){
					   traza("3");
						dto.setImpPrecPubi(new BigDecimal(precioPublico));
				  }
				  if(!numeroUnidades.equals("") && !numeroUnidades.equals("BLANCO") ){
					   traza("4");
						dto.setNumUnid(new Long(numeroUnidades));
				  }
				  if(!codVentaFicticio.equals("") && !codVentaFicticio.equals("BLANCO")){
					   traza("5");
					   dto.setCodVentFict(new String(codVentaFicticio));
				  }if( !oidProducto.equals("") && !oidProducto.equals("BLANCO")){
					   traza("6");
					   dto.setProdOidProd(new Long(oidProducto));	
				  }if(!indicadorCentroGarantia.equals("") && !indicadorCentroGarantia.equals("BLANCO") ){
					   if(indicadorCentroGarantia.equals("S")){
						   traza("7");
							dto.setIndCentDistGara(new Long(1));	
						}else{
							traza("7");
						   	dto.setIndCentDistGara(new Long(0));	
				  }
				  }if(!indicadorTipoEntrega.equals("") && !indicadorTipoEntrega.equals("BLANCO")){
					    traza("8");
						dto.setIndTipoEntrPrem(new String(indicadorTipoEntrega));
				  }if(!observacion.equals("") && !observacion.equals("BLANCO")){
					    traza("9");
						dto.setValObseCentDist(new String(observacion));
				  }if(!numeroMes.equals("") && !numeroMes.equals("BLANCO")){
					    traza("10");
						dto.setNumMeseGara(new Long(numeroMes));
				  }
				  if(!oidCentroServicioEntrega.equals("") && !oidCentroServicioEntrega.equals("BLANCO") ){
					    traza("11");
						dto.setCeseOidCeseEntr(new Long(oidCentroServicioEntrega));
				  }if(!oidCentroServicioGarantia.equals("") && !oidCentroServicioGarantia.equals("BLANCO")){
					    traza("12");
						dto.setCeseOidCeseGara( new Long(oidCentroServicioGarantia));
				  }if(!oidCriterioReemplazo.equals("") && !oidCriterioReemplazo.equals("BLANCO")){
					    traza("13");
						dto.setCtreOidCritReem(new Long(oidCriterioReemplazo));

				  }if(!valorCriterioReemplazo.equals("") && !valorCriterioReemplazo.equals("BLANCO")){
					    traza("14"); 
						dto.setValCritReem(new Long(valorCriterioReemplazo));
				  }if(!oidArticuloLote.equals("") && !oidArticuloLote.equals("BLANCO")){
					    traza("15");
						dto.setArloOidArtiLote(new Long(oidArticuloLote));
				  }if(!numeroOrden.equals("") && !numeroOrden.equals("BLANCO")){
					   traza("16");
						dto.setNumOrde(new Long(numeroOrden));	
				  }if(!indicadorActiva.equals("") && !indicadorActiva.equals("BLANCO") ){
						if(indicadorActiva.equals("SI")){
							traza("17"); 
							dto.setIndActi(new Long(1));
                        }else{
							traza("17");
						    dto.setIndActi(new Long(0));		
						}
				  }
				  if(!indicadorComunocacion.equals("") && !indicadorComunocacion.equals("BLANCO")){
						if(indicadorComunocacion.equals("S")){
							traza("18");
							dto.setIndComu(new Long(1));
						}else{
							traza("18");
							dto.setIndComu(new Long(0));	
						}
				  }
				  ArrayList regi= new ArrayList(); 
				  if(!region.equals("") && !region.equals("BLANCO")){
				       traza("19");
				         String [] regionCampo = region.split(",");	
					     int j = 0;	
					   while(j < regionCampo.length){
							regi.add(regionCampo[j]);	
							j++;
					   }
					   traza("19");
					   dto.setOidRegion(regi);	
				  }
				  ArrayList zon= new ArrayList(); 	
				  if(!zona.equals("") && !zona.equals("BLANCO")){
					   traza("20");
					   String [] zonaCampo = zona.split(",");					   
					   int j = 0;
					   while(j < zonaCampo.length){						    
							zon.add(zonaCampo[j]);	
							j++;
						}
						traza("20 zon: " + zon);
					   dto.setOidZona(zon);						
				  }
				  dto.setOidPais(pais);
                  dto.setOidIdioma(idioma); 	
			  traza("DTO: " +  dto);
			  traza("generarReemplazoArticuloLote: Salida");
			return dto;
	}

	public void consultar() throws Exception{
		 traza("LPMantenimientoRemplazoPremio.consultar(): Entrada");
			traza("LPMantenimientoRemplazoPremio.modificar(): Entrada");
					traza("777777LPMantenimientoRemplazoPremio.definirReemplazo(): Entrada");
					pagina("contenido_remplazo_premio");                        
					this.getFormatosValidaciones();	
					cargaComboCenSerGara();
					cargarComboCriterioReemplazo();
					cargarComboZonaRegion();
					asignarAtributo("VAR", "opcionMenu", "valor", opcionMenu);
					asignarAtributo("VAR", "accion", "valor", accion);
					asignarAtributo("VAR", "varPais", "valor", pais.toString());
					asignarAtributo("VAR", "varIdioma", "valor", idioma.toString());
					traza("opcionMenu: " + opcionMenu);
				    String oidReemProducto = conectorParametro("oidReemplazoArticLote")==null?"":conectorParametro("oidReemplazoArticLote");							  						
					String valoresLista1 = conectorParametro("valoresLista1")==null?"":conectorParametro("valoresLista1");
		 		    StringTokenizer stv2 = new StringTokenizer(valoresLista1,";");
   					traza("valoresLista1: "+ valoresLista1);
					traza("oidReemProducto:  " + oidReemProducto); 
					String productoRemplazado = "";
					String oidProducto = "";
					String codigoProductoReemplazo = "";
					String descripcionProducto = "";
					String undidades = "";
					String codVentaFicticio = "";
					String oidCriterioReemplazo = "";
					String criterioReemplazo = "";
					String valorCriterio = "";
					String nroOrden = "";
					String indicadorActivo = "";
					String oidReemplazoArticuloLote = "";
					String IndCenServG = "";  
					String oidCenServGar = ""; 
					String NumMeses = "";
					String Observaciones = ""; 
					String PrecioPublico4 = ""; 
					String ArticuloDespacha = ""; 
					String TipoEntrega = ""; 
					String CenServEntrega = "";
					String Comunicacion = "";
					String numeroPremio = ""; 
					String descripcionProductoReemplazado = ""; 
					String oidRegion = "";
					String oidZona = "";
					String oidArticuloLote = "";
					String re = "";
					String zo = "";
				    traza("stv2: "+ stv2);				
				    ArrayList array = new ArrayList();
				    while (stv2.hasMoreTokens()){
						    String oid = stv2.nextToken();
							traza("oid: " + oid);
							traza(new Character(oid.charAt(0)));
							if(oid != null){			 
									  		
                                      productoRemplazado = stv2.nextToken();
									  oidProducto = stv2.nextToken();
									  codigoProductoReemplazo = stv2.nextToken();
									  descripcionProducto = stv2.nextToken();
									  undidades = stv2.nextToken();
									  codVentaFicticio = stv2.nextToken();
									  oidCriterioReemplazo = stv2.nextToken();
									  criterioReemplazo = stv2.nextToken();
									  valorCriterio = stv2.nextToken();
									  nroOrden = stv2.nextToken();
									  indicadorActivo = stv2.nextToken();
									  oidReemplazoArticuloLote = stv2.nextToken();
									  
									  // sapaza -- PER-SiCC-2012-0019 -- 07/03/2012
									  String posicionReemplazo = stv2.nextToken();
									  
									  IndCenServG = stv2.nextToken();
									  oidCenServGar = stv2.nextToken();
									  NumMeses = stv2.nextToken();
									  Observaciones = stv2.nextToken();
									  PrecioPublico4 = stv2.nextToken();
									  ArticuloDespacha = stv2.nextToken();
									  TipoEntrega = stv2.nextToken();
									  CenServEntrega = stv2.nextToken();
									  Comunicacion = stv2.nextToken();
									  numeroPremio = stv2.nextToken();
									  descripcionProductoReemplazado = stv2.nextToken();
									  re = stv2.nextToken();
									  zo = stv2.nextToken();
									  oidArticuloLote = stv2.nextToken();
									  
									  traza("productoRemplazado: " + productoRemplazado ); 
									  traza("oidProducto: " + oidProducto);
									  traza("codigoProductoReemplazo: " + codigoProductoReemplazo );
									  traza("descripcionProducto: " + descripcionProducto );
									  traza("undidades: " + undidades );
									  traza("codVentaFicticio: " + codVentaFicticio );
									  traza("oidCriterioReemplazo: " + oidCriterioReemplazo );
									  traza("criterioReemplazo: " + criterioReemplazo );
									  traza("valorCriterio: " + valorCriterio );
									  traza("nroOrden: " + nroOrden );
									  traza("indicadorActivo: " + indicadorActivo );
									  traza("oidReemplazoArticuloLote: " + oidReemplazoArticuloLote );
									  traza("IndCenServG: " + IndCenServG);
									  traza("oidCenServGar: " + oidCenServGar);
									  traza("Observaciones: " + Observaciones );
									  traza("PrecioPublico4: " + PrecioPublico4 );
									  traza("ArticuloDespacha: " + ArticuloDespacha );
									  traza("TipoEntrega: " + TipoEntrega );
									  traza("CenServEntrega: " + CenServEntrega );
									  traza("Comunicacion: " + Comunicacion );
									  traza("NumMeses: " + NumMeses );							
									  traza("numeroPremio: " + numeroPremio );
									  traza("descripcionProductoReemplazado: " + descripcionProductoReemplazado);
									  traza("oidRegion: " + re);
									  traza("oidZona: " + zo);
									  traza("oidArticuloLote: " + oidArticuloLote);
									  
							} 		
				     }
					
					if(!oidReemProducto.equals("undefined")){
							 DTOReemplazoArticuloLote dto = new DTOReemplazoArticuloLote();
							 dto.setOidReemArtiLote(new Long(oidReemProducto));						
							 try{	
									MareBusinessID id = new MareBusinessID("INCObtenerDatosFaltantes");							
									Vector paramEntrada = new Vector();
									paramEntrada.add(dto);
									paramEntrada.add(id);									
									DruidaConector conector  = conectar("ConectorObtenerDatosFaltantes",  paramEntrada);
									DTOSalida dtoSalida = (DTOSalida)conector.objeto("dtoSalida");
									RecordSet rs = dtoSalida.getResultado(); 							
									traza("rs: " + rs);
									int cant = rs.getRowCount();
									if(!rs.esVacio()){												   
										       IndCenServG =((BigDecimal)rs.getValueAt(0,"IND_CENT_DIST_GARA")).toString();
											   traza("IndCenServG: " + IndCenServG);
										       if(rs.getValueAt(0,"CESE_OID_CESE_GARA") != null){
													oidCenServGar =((BigDecimal)rs.getValueAt(0,"CESE_OID_CESE_GARA")).toString();
													traza("oidCenServGar: " + oidCenServGar);
											   }	
											   if(rs.getValueAt(0,"NUM_MESE_GARA") != null){
													NumMeses =((BigDecimal)rs.getValueAt(0,"NUM_MESE_GARA")).toString();
													traza("NumMeses: " + NumMeses);
											   }
											   if(rs.getValueAt(0,"VAL_OBSE_CENT_DIST") != null){
													Observaciones =(String)rs.getValueAt(0,"VAL_OBSE_CENT_DIST");
													traza("Observaciones: " + Observaciones);
											   }
											   if(rs.getValueAt(0,"IMP_PREC_PUBL") != null){
													PrecioPublico4 =((BigDecimal)rs.getValueAt(0,"IMP_PREC_PUBL")).toString();
													traza("PrecioPublico4: " + PrecioPublico4);
                                               }
											   if(rs.getValueAt(0,"IND_DESP") != null){
													ArticuloDespacha =((BigDecimal)rs.getValueAt(0,"IND_DESP")).toString();
													traza("ArticuloDespacha: " + ArticuloDespacha);
											   }
											   if(rs.getValueAt(0,"IND_TIPO_ENTR_PREM") != null){
													TipoEntrega  = (String)rs.getValueAt(0,"IND_TIPO_ENTR_PREM");
													traza("TipoEntrega: " + TipoEntrega);
											   }
											   if(rs.getValueAt(0,"CESE_OID_CESE_ENTR") != null){
													CenServEntrega = ((BigDecimal)rs.getValueAt(0,"CESE_OID_CESE_ENTR")).toString();
													traza("CenServEntrega: " + CenServEntrega);
											   }
											   Comunicacion = ((BigDecimal)rs.getValueAt(0,"IND_COMU")).toString();
											   traza("Comunicacion: " + Comunicacion);
											   numeroPremio = ((BigDecimal)rs.getValueAt(0,"NUM_PREM")).toString();
											   traza("numeroPremio: " + numeroPremio);
											   productoRemplazado = (String)rs.getValueAt(0,"COD_SAP");
											   traza("productoRemplazado:  " + productoRemplazado);
											   descripcionProductoReemplazado = (String)rs.getValueAt(0,"VAL_I18N");											   	  								  									  
   											   traza("descripcionProductoReemplazado: " + descripcionProductoReemplazado);
											   String regio= ""; 
											   String zona = "";
									           for(int i=0; i < cant; i++){
													 if(rs.getValueAt(i,"ZORG_OID_REGI") != null){
														regio = ((BigDecimal)rs.getValueAt(i,"ZORG_OID_REGI")).toString();
														traza("regio: " + regio);
														oidRegion =  oidRegion + regio + ",";
														
													 }
													 if(rs.getValueAt(i,"ZZON_OID_ZONA") != null){
														zona = ((BigDecimal)rs.getValueAt(i,"ZZON_OID_ZONA")).toString();
														traza("zona: " + zona);
														oidZona =  oidZona + zona + ",";
                                                     }
												}	

											  oidArticuloLote =	((BigDecimal)rs.getValueAt(0,"ARLO_OID_ARTI_LOTE")).toString();
											  
									}

								}catch(Exception ex)
     							{
									 ex.printStackTrace();						 
								}           							 
					} 
					
					traza("oidRegion: " + oidRegion);
					traza("oidZona: " + oidZona);
					asignarAtributo	("VAR", "codigo", "valor", productoRemplazado);// esta
					asignarAtributo("VAR", "oidProducto", "valor", oidProducto);// esta
					asignarAtributo("CTEXTO", "txtCodProducto", "valor", codigoProductoReemplazo); //esta
					asignarAtributo("VAR", "descripcionProducto", "valor", descripcionProductoReemplazado);// esta
					asignarAtributo("CTEXTO", "txtNumUnidades4", "valor", undidades); // esta
					if(codVentaFicticio.equals("BLANCO")){
						codVentaFicticio = "";
					}
					asignarAtributo("CTEXTO", "codVentaFicticio", "valor", codVentaFicticio); // esta 
					asignarAtributo("VAR", "oidCriterioReemplazo", "valor", oidCriterioReemplazo);  // esta
					if(valorCriterio.equals("BLANCO")){
						valorCriterio = "";
					}
					asignarAtributo("CTEXTO", "txtValorCriterio", "valor", valorCriterio); // esta
					asignarAtributo("CTEXTO", "txtNumOrden", "valor", nroOrden); // esta
					asignarAtributo("VAR", "indicadorActivo", "valor", indicadorActivo);// esta
					asignarAtributo("VAR", "Npremio", "valor", numeroPremio); // esta
					
					asignarAtributo("VAR", "desProducto", "valor", descripcionProductoReemplazado); // esta
					if(NumMeses.equals("BLANCO")){
						NumMeses = "";
					}
					asignarAtributo("CTEXTO", "txtNumMeses", "valor", NumMeses);// esta
					if(Observaciones.equals("BLANCO")){
						Observaciones = "";
					}
					asignarAtributo("AREATEXTO", "areaObservaciones", "valor", Observaciones); // esta
					if(PrecioPublico4.equals("BLANCO")){
						PrecioPublico4 = "";
					}
					asignarAtributo("CTEXTO", "txtPrecioPublico4", "valor", PrecioPublico4);// esta 
					asignarAtributo("VAR", "ArticuloDespacha4", "valor", ArticuloDespacha); // esta
					//asignarAtributo("VAR", "oidCenServEntrega", "valor", oidCenServEntrega); // esta
					asignarAtributo("VAR", "Comunicacion", "valor", Comunicacion); // esta
					//asignarAtributo("VAR", "AlcanceGeografico", "valor", rbAlcanceGeografico); // falta

					if(!oidRegion.equals("")){
						asignarAtributo("VAR", "oidRegion", "valor", oidRegion);// falta
					}else{
						asignarAtributo("VAR", "oidRegion", "valor", re);// falta
					}
					if(!oidZona.equals("")){
						asignarAtributo("VAR", "oidZona", "valor", oidZona);// falta
					}else{
						asignarAtributo("VAR", "oidZona", "valor", zo);// falta
					}
					asignarAtributo("VAR", "ChkIndCenServG", "valor", IndCenServG); // traer de la base.
					asignarAtributo("VAR", "CriterioReemplazo", "valor", criterioReemplazo); 
					asignarAtributo("VAR", "CenServEntrega", "valor", CenServEntrega);
					asignarAtributo("VAR", "TipoEntrega", "valor", TipoEntrega);
					
					asignarAtributo("VAR", "oidCenServGar", "valor", oidCenServGar);
					 asignarAtributo("VAR", "oidArticuloLote", "valor", oidArticuloLote);
					//asignarAtributo("VAR", "CenServGar", "valor", CenServGar);
					/*asignarAtributo("VAR", "oidProductosMayorErrorSacado", "valor", oidProductosMayorErrorSacado);
					asignarAtributo("VAR", "oidProductosMayorErrorSacado", "valor", oidProductosMayorErrorSacado);
					asignarAtributo("VAR", "oidProductosMayorErrorSacado", "valor", oidProductosMayorErrorSacado);*/		

		 traza("LPMantenimientoRemplazoPremio.consultar(): Salida");
	}
	public void generarNuevaSolicitudReemplazo() throws  Exception{
		 traza("LPMantenimientoReemplazoPremio.generarNuevaSolicitudReemplazo(): Entrada");
		 pagina("salidaGenerica");
		 try{
				 
				 String oidConcurso = conectorParametro("cbConcurso")==null?"":conectorParametro("cbConcurso");
				 traza("oidConcurso: " + oidConcurso);
				 DTOReemplazoArticuloLote dto = new DTOReemplazoArticuloLote();
				 dto.setOidConcurso(new Long(oidConcurso));
				 MareBusinessID id = new MareBusinessID("INCBatchReemplaz");							
				 Vector paramEntrada = new Vector();
				 traza("pais: " + pais);
				 dto.setOidPais(pais);
				 paramEntrada.add(dto);
				 paramEntrada.add(id);									
				 DruidaConector conector  = conectar("ConectorBatchReemplazoArticuloLote", paramEntrada);
				 asignarAtributo("VAR", "ejecutar", "valor", "fActualizarGrilla()"); 
		 } catch(Exception e){
					traza("********* Entrando al Catch");
                    e.printStackTrace();
		    		asignarAtributo("VAR", "ejecutarError", "valor", "fActualizarErr()");
                    throw e;
		 }
				
		 traza("LPMantenimientoReemplazoPremio.generarNuevaSolicitudReemplazo(): Salida");
		
	}
	public void buscarProducto() throws Exception{
		traza("777777777LPMantenimientoProductosMayorErrorSacado.buscarProducto(): Entrada");
		pagina("salidaGenerica");
		try{
			String codigoProducto = conectorParametroLimpia("txtCodProducto", "", true);
			String oidProd = null;
			String desProducto= null;
			traza("7777777codigoProducto: " + codigoProducto);

			DTOEBuscarProductos dtoP = new DTOEBuscarProductos();
			dtoP.setOidPais(pais);
			dtoP.setOidIdioma(idioma);
			dtoP.setCodSAP(new String(codigoProducto));
		    MareBusinessID businessID = new MareBusinessID("INCObtenerProducto");
			
			Vector para = new Vector(); 
			para.add(dtoP);
			para.add(businessID);
			
			traza("7777777777 Antes de conectar");
			DruidaConector dc =	conectar("ConectorObtenerProducto", para);
            traza("777777777 Despues de conectar");

			DTOSalida dtoSalida = (DTOSalida)dc.objeto("DTOSalida");
			RecordSet rs = dtoSalida.getResultado(); 							
			traza("rs: " + rs);
			
			
			oidProd   =  ((BigDecimal)rs.getValueAt(0,"OID_PROD")).toString();
			desProducto = (String)rs.getValueAt(0,"DES_CORT");			  
			
			traza("77777777oidProducto: " + oidProd);
			traza("77777777desProducto: " + desProducto);
			//asignarAtributo("VAR", "oidProducto", "valor", oidProd);
			//asignarAtributo("VAR", "desProducto", "valor", desProducto);
			asignarAtributo("VAR", "cerrarVentana", "valor", "false");
			asignarAtributo("VAR", "ejecutar", "valor", "fverProducto('" + this.replace(desProducto,"'", " ") + "','"+ oidProd + "');");  

 


			this.traza("7777777LPMantenimientoProductosMayorErrorSacado.buscarProducto(): Salida");
		}catch(Exception e){
			traza("777777777 Entrando al Catch");
            asignarAtributo("VAR", "ejecutarError", "valor", "fBuscarErr()");
            throw e;
		}

	}
	public void validarVolsaFaltante()throws Exception{
		traza("LPMantenimientoRemplazoPremio.validarVolsaFaltante(): Entrada");
			pagina("salidaGenerica");
			String rta = null;
			try{
			String oidConcurso = conectorParametro("cbConcurso")==null?"":conectorParametro("cbConcurso");
			traza("oidConcurso: " + oidConcurso);
			DTOReemplazoArticuloLote dto = new DTOReemplazoArticuloLote();
			dto.setOidConcurso(new Long(oidConcurso));
			ArrayList array = new ArrayList();
			array.add(dto);

			MareBusinessID businessID = new MareBusinessID("INCValidarBolsaFaltante");                  
			DTOArticuloLoteColeccion dtos = new DTOArticuloLoteColeccion();	
			dtos.setLista(array);
			Vector parametro = new Vector(); 
			parametro.add(dtos);
			parametro.add(businessID);
			traza("para: " + parametro);
			traza("********** Antes de conectar");
			DruidaConector conector  = conectar("ConectorValidarBolsaFaltante", parametro);
			traza("7777777777777");
			DTOSalida dtoSalida = (DTOSalida)conector.objeto("dtoSalida");
			RecordSet rs = dtoSalida.getResultado(); 
			if(!rs.esVacio()){
					rta = "si";
			}else{
					rta = "no";
			}
            traza("*********** Despues de conectar");
            asignarAtributo("VAR", "ejecutar", "valor", "generarNuevaSolicitud('"+ rta +"')");                  
            }catch(Exception e){
                 traza("********* Entrando al Catch");
                 e.printStackTrace();
				 asignarAtributo("VAR", "ejecutarError", "valor", "generarNuevaSolicitudERR()");
                 throw e;
            }
		traza("LPMantenimientoRemplazoPremio.validarVolsaFaltante(): Entrada");

	}
	  public static String replace(String s, String s1, String s2){  

            int i = 0; 
            int j = 0; 
            int k = s1.length(); 

            StringBuffer stringbuffer = null; 
            String s3 = s; 

            while((j = s.indexOf(s1, i)) >= 0)
            { 

                    if(stringbuffer == null) 
                     { 
                          stringbuffer = new StringBuffer(s.length() * 2); 
                     } 
                     stringbuffer.append(s.substring(i, j)); 
                     stringbuffer.append(s2); 
                     i = j + k; 
            } 

            if(i != 0) 
            { 
                     stringbuffer.append(s.substring(i)); 
                     s3 = stringbuffer.toString(); 
            } 

            return s3; 

   }
   public void validarVolsaFaltanteModificar() throws Exception{
			traza("LPMantenimientoRemplazoPremio.validarVolsaFaltanteModificar(): Entrada");
			pagina("salidaGenerica");
			String rta = null;
			try{
			String oidConcurso = conectorParametro("cbConcurso")==null?"":conectorParametro("cbConcurso");
			traza("oidConcurso: " + oidConcurso);
			DTOReemplazoArticuloLote dto = new DTOReemplazoArticuloLote();
			dto.setOidConcurso(new Long(oidConcurso));
			ArrayList array = new ArrayList();
			array.add(dto);

			MareBusinessID businessID = new MareBusinessID("INCValidarBolsaFaltanteModificado");                  
			DTOArticuloLoteColeccion dtos = new DTOArticuloLoteColeccion();	
			dtos.setLista(array);
			Vector parametro = new Vector(); 
			parametro.add(dtos);
			parametro.add(businessID);
			traza("para: " + parametro);
			traza("********** Antes de conectar");
			DruidaConector conector  = conectar("ConectorValidarBolsaFaltanteModificados", parametro);
			traza("7777777777777");
			DTOSalida dtoSalida = (DTOSalida)conector.objeto("dtoSalida");
			RecordSet rs = dtoSalida.getResultado(); 
			if(!rs.esVacio()){
					rta = "si";
			}else{
					rta = "no";
			}
            traza("*********** Despues de conectar");
            asignarAtributo("VAR", "ejecutar", "valor", "generarNuevaSolicitudModificar('"+ rta +"')");                  
            }catch(Exception e){
                 traza("********* Entrando al Catch");
                 e.printStackTrace();
				 asignarAtributo("VAR", "ejecutarError", "valor", "generarNuevaSolicitudModificadoERR()");
                 throw e;
            }

			traza("LPMantenimientoRemplazoPremio.validarVolsaFaltanteModificar(): Salida");
   }
   public void generarNuevaSolicitudReemplazoModificado() throws Exception{
				traza("LPMantenimientoRemplazoPremio.generarNuevaSolicitudReemplazoModificado(): Entrada");
				 pagina("salidaGenerica");
				try{
				 
				 String oidConcurso = conectorParametro("cbConcurso")==null?"":conectorParametro("cbConcurso");
				 traza("oidConcurso: " + oidConcurso);
				 DTOReemplazoArticuloLote dto = new DTOReemplazoArticuloLote();
				 dto.setOidConcurso(new Long(oidConcurso));
				 MareBusinessID id = new MareBusinessID("INCBatchReemplazModificado");							
				 Vector paramEntrada = new Vector();
				 traza("pais: " + pais);
				 dto.setOidPais(pais);
				 paramEntrada.add(dto);
				 paramEntrada.add(id);									
				 DruidaConector conector  = conectar("ConectorBatchReemplazoArticuloLoteModificado", paramEntrada);
				 asignarAtributo("VAR", "ejecutar", "valor", "fActualizarGrilla()"); 
				 } catch(Exception e){
					traza("********* Entrando al Catch");
                    e.printStackTrace();
		    		asignarAtributo("VAR", "ejecutarError", "valor", "fActualizarErr()");
                    throw e;
				 }
				traza("LPMantenimientoRemplazoPremio.generarNuevaSolicitudReemplazoModificado(): Salida");
   }

   public void obtenerPendientesBolsaFaltantes() throws Exception {
       traza("Entró a 'obtenerPendientesBolsaFaltantes()'");
       pagina("contenido_remplazo_faltantes_concurso");
       
       String oidConcurso = conectorParametro("oidConcurso")==null?"":conectorParametro("oidConcurso");
       String nombreConcurso = conectorParametro("nombreConcurso")==null?"":conectorParametro("nombreConcurso");
       
	   traza("oidConcurso: " + oidConcurso);
	   traza("nombreConcurso: " + nombreConcurso);
		
       // Carga de combo de datos Niveles
       DTOOID dtoBel = new DTOOID();
       dtoBel.setOidPais(UtilidadesSession.getPais(this));
       dtoBel.setOidIdioma(UtilidadesSession.getIdioma(this));
       dtoBel.setOid(new Long(oidConcurso));
       
       Vector paramEntrada = new Vector();
       paramEntrada.add(dtoBel);
       paramEntrada.add(new MareBusinessID("INCObtenerPendientesBolsaFaltantes"));

       traza("antes conector");
       DruidaConector conectorRecupConcRank = conectar("ConectorObtenerPendientesBolsaFaltantes", paramEntrada);
       traza("ConectorObjetoGenerico trajo --> " + conectorRecupConcRank);

       asignar("LISTADOA", "listado1", conectorRecupConcRank, "dtoSalida.resultado_ROWSET");
       this.asignarAtributo("LABELC","lbldtNombreConcurso","valor", nombreConcurso);
       
       traza("Sale de 'obtenerPendientesBolsaFaltantes()'");
   }

   
}