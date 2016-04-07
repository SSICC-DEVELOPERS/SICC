/**
 * Copyright 2006 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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

import es.indra.druida.DruidaConector;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.cmn.negocio.i18n.DTOI18nSICC;
import es.indra.sicc.dtos.bel.DTOControlAlmacen;

import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream; 
import java.util.Vector;
 
	public class LPMantenimientoControlesAlmacen  extends LPSICCBase {
	
		Long pais = null;
		Long idioma = null;
			
		private String accion = null;
		private String opcionMenu = null;
		
		private String sOidControlAlmacen = null;
		private String sOidCanal = null;
		private String sOidAcceso = null;
		private String sOidSubacceso = null;
		private String sOidProducto = null;
		private String sOidAlmacen = null;
		private String txtStockMinimo = null;
		private String txtStockMaximo = null;
		private String txtStockReposicion = null;
		private String activado = null;
        private String txtCodigoProducto = null;




          public LPMantenimientoControlesAlmacen() {
                    super();
          }
          
          public void inicio() throws Exception {}

      public void ejecucion() throws Exception {
          rastreo();
          setTrazaFichero();
          traza("*** Entrada - LPMantenimientoControlesAlmacen  - ejecucion ***");
                    try  {
                        accion = conectorParametroLimpia("accion", "", true);
								opcionMenu = conectorParametroLimpia("opcionMenu", "", true);						
								
								pais = UtilidadesSession.getPais(this); 
								idioma = UtilidadesSession.getIdioma(this);
				
								if (accion.equals("")) {
										inicializar(); 
								}
								else {
										if (accion.equals("guardar")) {
														guardar();
										}
										else {
												if (accion.equals("modificar")) {
															modificarControlesAlmacen();
												}
												else {
														if (accion.equals("detalle")) {
																	detalleControlAlmacen();
														}
												}
										}
									}
														
                    }
                    catch ( Exception e )  {
                              traza("....Excepcion LPMant - opcionMenu: " + opcionMenu);
                              if (opcionMenu.equals("InsertarControlesAlmacen")){
                                  cargarPGInsertarControlesAlmacen();
                                  asignarAtributo("VAR", "oidControlAlmacen", "valor", conectorParametro("oidControlAlmacen"));     
			                      asignarAtributo("VAR", "hCanal", "valor", conectorParametro("cbCanal"));
			                      asignarAtributo("VAR", "hAcceso", "valor", conectorParametro("cbAcceso"));
			                      asignarAtributo("VAR", "hSubacceso", "valor", conectorParametro("cbSubacceso"));	 
			                      asignarAtributo("VAR", "oidProducto", "valor", conectorParametro("oidProducto"));
			                      asignarAtributo("VAR", "oidAlmacen", "valor", conectorParametro("cbAlmacen"));
	                   		      asignarAtributo("VAR", "activado", "valor", conectorParametro("cbActivado"));
	                     		  asignarAtributo("CTEXTO", "txtStockMinimo", "valor", conectorParametro("txtStockMinimo"));
			                      asignarAtributo("CTEXTO", "txtStockMaximo", "valor", conectorParametro("txtStockMaximo"));
			                      asignarAtributo("CTEXTO", "txtStockReposicion", "valor", conectorParametro("txtStockReposicion"));
                                  asignarAtributo("CTEXTO", "txtCodigoProducto", "valor", conectorParametro("txtCodigoProducto"));
                                  asignarAtributo("VAR", "recupera", "valor", "S");
                              }
                              logStackTrace(e);
                              lanzarPaginaError(e);
                    }
           traza("*** Salida - LPMantenimientoControlesAlmacen  - ejecucion ***");
      }

		private void logStackTrace(Throwable e) throws Exception {
          traza("Se produjo la excepcion: " + e.getMessage());
          ByteArrayOutputStream baos = new ByteArrayOutputStream();
          PrintStream ps = new PrintStream(baos);
          e.printStackTrace(ps);
          traza("Stack Trace: " + baos.toString());
		}		

		private void inicializar() throws Exception {
			 traza("*** Entrada - LPMantenimientoControlesAlmacen  - inicializar ***");
		
			opcionMenu = conectorParametroLimpia("opcionMenu", "", true);
			traza(" **** opcionMenu : " + opcionMenu);
			
			if (opcionMenu.equals("InsertarControlesAlmacen")) {
				cargarPGInsertarControlesAlmacen();
			
			}
			else {
	 			if (opcionMenu.equals("ModificarControlesAlmacen") || opcionMenu.equals("ConsultarControlesAlmacen") 
																					|| opcionMenu.equals("EliminarControlesAlmacen")) {
					cargarPGConsultarControlesAlmacen();
				}
			}

		}

      public void cargarPGInsertarControlesAlmacen() throws Exception{
			traza("*** Entrada - LPMantenimientoControlesAlmacen  - cargarPGInsertarControlesAlmacen ***");

				pagina("contenido_controles_almacen_insertar");
                this.getFormatosValidaciones();
			
				DTOBelcorp dtoe = new DTOBelcorp();
			   		
				pais = UtilidadesSession.getPais(this); 
				idioma = UtilidadesSession.getIdioma(this);
				dtoe.setOidPais(pais);
				dtoe.setOidIdioma(idioma);

				//	Crear una lista ComposerViewElementList
				ComposerViewElementList lista = new ComposerViewElementList();

				ComposerViewElement elem1 = new ComposerViewElement();
				elem1.setIDBusiness("SEGConsultaCanales");
				elem1.setDTOE(dtoe);
				lista.addViewElement(elem1);

				/************** AGREGA *******************/
				 ComposerViewElement elem2 = new ComposerViewElement();
				 elem2.setIDBusiness("BELObtenerAlmacenes");
				 elem2.setDTOE(dtoe);
             lista.addViewElement(elem2);
				 /************** FIN AGREGA *******************/

				 // Invocar al  subsistema GestorCargaPantalla
				 ConectorComposerView conector = new ConectorComposerView(lista, this.getRequest());
		       conector.ejecucion();
		       DruidaConector resultados = conector.getConector();
		
       		 asignar("COMBO", "cbCanal", resultados, "SEGConsultaCanales");
				 asignar("COMBO", "cbAlmacen", resultados, "BELObtenerAlmacenes");
								
				//Deshabilitar el campo txtCodigoProducto
			    asignarAtributo("VAR", "habilitaCodProd", "valor","N");

	         if(opcionMenu.equals("InsertarControlesAlmacen")){
     					getConfiguracionMenu("LPMantenimientoControlesAlmacen","insertar");
						asignarAtributo("VAR", "habilitaBtnBuscarProd", "valor","N");
				} 
             traza("opcionMenu: " + opcionMenu);
            if(opcionMenu.equals("ConsultarControlesAlmacen")){
   					getConfiguracionMenu("LPMantenimientoControlesAlmacen","detalle");
                    this.asignarAtributoPagina("cod", "01039");
						asignarAtributo("VAR", "habilitaBtnGuardar", "valor","N");
				}

				if(opcionMenu.equals("ModificarControlesAlmacen")){
   					getConfiguracionMenu("LPMantenimientoControlesAlmacen","modificarDetalle");
                    this.asignarAtributoPagina("cod", "01038");
				}
				
				if(accion.equals("modificar")){
							asignarAtributo("VAR", "habilitaCanal", "valor","N");
							asignarAtributo("VAR", "habilitaAcceso", "valor","N");
							asignarAtributo("VAR", "habilitaSubacceso", "valor","N");
                            asignarAtributo("VAR", "habilitaAlmacen", "valor","N");
				}
				
				asignarAtributo("VAR", "accion", "valor",accion);
				asignarAtributo("VAR", "opcionMenu", "valor",opcionMenu);
				asignarAtributo("VAR", "pais", "valor", pais.toString());
				asignarAtributo("VAR", "idioma", "valor", idioma.toString());			
		}	
		
		public void cargarPGConsultarControlesAlmacen() throws Exception{
   			traza("*** Entrada - LPMantenimientoControlesAlmacen  - cargarPGConsultarControlesAlmacen ***");
				
				pagina("contenido_controles_almacen_modificar");
                this.getFormatosValidaciones();
			
				DTOBelcorp dtoe = new DTOBelcorp();
			  		
				pais = UtilidadesSession.getPais(this); 
				idioma = UtilidadesSession.getIdioma(this);
				dtoe.setOidPais(pais);
				dtoe.setOidIdioma(idioma);

		      ComposerViewElementList lista = new ComposerViewElementList();
				//Obtenemos los canales

				ComposerViewElement elem1 = new ComposerViewElement();
				elem1.setIDBusiness("SEGConsultaCanales");
				elem1.setDTOE(dtoe);
				lista.addViewElement(elem1);
	
				ComposerViewElement elem2 = new ComposerViewElement();
				elem2.setIDBusiness("BELObtenerAlmacenes");
				elem2.setDTOE(dtoe);
				lista.addViewElement(elem2);
	
	//		 Invocar al  subsistema GestorCargaPantalla
				ConectorComposerView conector = new ConectorComposerView(lista, this.getRequest());
		      conector.ejecucion();
		      DruidaConector resultados = conector.getConector();
				
				asignar("COMBO", "cbCanal", resultados, "SEGConsultaCanales");
				asignar("COMBO", "cbAlmacen", resultados, "BELObtenerAlmacenes");
				
				if(opcionMenu.equals("ConsultarControlesAlmacen")){
						
					getConfiguracionMenu("LPMantenimientoControlesAlmacen","consultar");
					this.asignarAtributoPagina("cod", "01035");

					asignarAtributo("VAR", "habilitaBtnEliminar", "valor","N");
					asignarAtributo("VAR", "habilitaBtnModificar", "valor","N");
				}			
			
				if(opcionMenu.equals("ModificarControlesAlmacen")){

					getConfiguracionMenu("LPMantenimientoControlesAlmacen","modificar");
				
					asignarAtributo("VAR", "habilitaBtnEliminar", "valor","N");
					asignarAtributo("VAR", "habilitaBtnDetalle", "valor","N");
				}
			
				if(opcionMenu.equals("EliminarControlesAlmacen")){

					getConfiguracionMenu("LPMantenimientoControlesAlmacen","eliminar");
					this.asignarAtributoPagina("cod", "01037");

					asignarAtributo("VAR", "habilitaBtnModificar", "valor","N");
					asignarAtributo("VAR", "habilitaBtnDetalle", "valor","N");

				}
			
				asignarAtributo("VAR", "accion", "valor",accion);
				asignarAtributo("VAR", "opcionMenu", "valor",opcionMenu);
				asignarAtributo("VAR", "pais", "valor", pais.toString());
				asignarAtributo("VAR", "idioma", "valor", idioma.toString());						
		}

		public void guardar()throws Exception{
		traza("*** Entrada - LPMantenimientoControlesAlmacen  - guardar ***");

			DTOControlAlmacen dtoCA = crearDTOControlAlmacen(); 

			MareBusinessID businessID = new MareBusinessID("BELActualizarControlAlmacen");
		
			Vector parametros = new Vector();
			parametros.add(dtoCA);
			parametros.add(businessID);

			//try {
			traza("******************* Entrando al try...");
			traza("******************* Antes de conectar");
			
				conectar("ConectorActualizarControlAlmacen", parametros);
			
			traza("******************* Despues de conectar");
			//}catch(Exception e) {
            // throw e;
			//}

			cargarPGInsertarControlesAlmacen();

			if(opcionMenu.equals("ModificarControlesAlmacen")){
					asignarAtributo("VAR", "cerrar", "valor", "S");
			}

		}
		
		/**
		Recupera los valores de la página PGInsertarControlesAlmacen y los guarda 
		en un DTOControlAlmacen 
		*/
		public DTOControlAlmacen crearDTOControlAlmacen() throws Exception{
		traza("*** Entrada - LPMantenimientoControlesAlmacen  - crearDTOControlAlmacen ***");
		
		
		/*
			accion = conectorParametroLimpia("accion", "", true);
			opcionMenu = conectorParametroLimpia("opcionMenu", "", true);
		*/
		
			DTOControlAlmacen dtoCA = new DTOControlAlmacen(); 
//		oidPlantilla = conectorParametroLimpia("oidPlantilla", "", true);
			sOidControlAlmacen = conectorParametroLimpia("oidControlAlmacen", "", true);

			traza("*********** sOidControlAlmacen " + sOidControlAlmacen);
		
			if (opcionMenu.equals("InsertarControlesAlmacen")) {
				traza("*********** Seteando oid a null");
				dtoCA.setOidControlAlmacen(null);			
			}
			else {
				traza("*********** Seteando oid");
				
				if(!sOidControlAlmacen.equals("")){
					dtoCA.setOidControlAlmacen(Long.valueOf(sOidControlAlmacen));
				}				
			}
	
			sOidCanal = conectorParametroLimpia("cbCanal", "", true);
			dtoCA.setOidCanal(Long.valueOf(sOidCanal));
			
			sOidAcceso = conectorParametroLimpia("cbAcceso", "", true);
			dtoCA.setOidAcceso(Long.valueOf(sOidAcceso));
		
			sOidSubacceso = conectorParametroLimpia("cbSubacceso", "", true);
			dtoCA.setOidSubacceso(Long.valueOf(sOidSubacceso));
		 
			sOidProducto = conectorParametroLimpia("oidProducto", "", true);
			dtoCA.setOidProducto(Long.valueOf(sOidProducto));
		
			
			txtStockMinimo = conectorParametroLimpia("txtStockMinimo", "", true);
			dtoCA.setStockMinimo(txtStockMinimo.equals("")? null:Long.valueOf(txtStockMinimo));
		
			txtStockMaximo = conectorParametroLimpia("txtStockMaximo", "", true);		
			dtoCA.setStockMaximo(txtStockMaximo.equals("") ? null: Long.valueOf(txtStockMaximo));
		
			txtStockReposicion = conectorParametroLimpia("txtStockReposicion", "", true);
			dtoCA.setStockReposicion(txtStockReposicion.equals("") ? null: Long.valueOf(txtStockReposicion));
			
			/************** AGREGA *******************/
			sOidAlmacen = conectorParametroLimpia("cbAlmacen", "", true);
			dtoCA.setOidAlmacen(Long.valueOf(sOidAlmacen));
			/************** FIN AGREGA *******************/			
			
			activado = conectorParametroLimpia("cbActivado", "", true);
			//traza("Activado: " + (char)cbActivado.charAt(0)); 
   		dtoCA.setActivado(activado.equals("") ? null: new Character(activado.charAt(0))); 
				
			return dtoCA;
		}	

		// vamos a tener que desabilitar "almacen"
		public void modificarControlesAlmacen() throws Exception{
		traza("*** Entrada - LPMantenimientoControlesAlmacen  - modificarControlesAlmacen ***");
		
		sOidControlAlmacen  = conectorParametroLimpia("oidControlAlmacen", "", true);
		DTOControlAlmacen dtoCA = obtenerControlAlmacen();
		cargarPGInsertarControlesAlmacen();
		mostrarDatosControlAlmacen(dtoCA);
		
		}
		
		public DTOControlAlmacen obtenerControlAlmacen() throws Exception{
		traza("*** Entrada - LPMantenimientoControlesAlmacen  - obtenerControlAlmacen ***");
																																																						
			DTOOID dtoID = new DTOOID();
			
			sOidControlAlmacen  = conectorParametroLimpia("oidControlAlmacen", "", true);
			dtoID.setOid(Long.valueOf(sOidControlAlmacen));
																
			MareBusinessID businessID = new MareBusinessID("BELObtenerControlAlmacen");
			Vector parametros = new Vector();
			parametros.add(dtoID);
			parametros.add(businessID);
																						
		traza("******** Antes de conectar");
			DruidaConector con = conectar("ConectorObtenerControlAlmacen", parametros);
		traza("******** Despues de conectar");
																														
			DTOControlAlmacen dtoCA = (DTOControlAlmacen)con.objeto("DTOControlAlmacen");
		return dtoCA;																									
		
		}

		/*
		* Muestra en la página PGInsertarControlesAlmacen los datos recibidos en el DTOControlAlmacen: 
		*/
		public void mostrarDatosControlAlmacen(DTOControlAlmacen DTOE) throws Exception{
		traza("*********** Entre a mostrarDatosControlAlmacen - LPMantenimientoControlesAlmacen");

			  sOidControlAlmacen = DTOE.getOidControlAlmacen() != null ? DTOE.getOidControlAlmacen().toString(): "";
			  sOidCanal = DTOE.getOidCanal() != null ? DTOE.getOidCanal().toString() : ""; 	
			  sOidAcceso = DTOE.getOidAcceso() != null ? DTOE.getOidAcceso().toString() : ""; 	
			  sOidSubacceso = DTOE.getOidSubacceso() != null ? DTOE.getOidSubacceso().toString() : ""; 
			  sOidProducto = DTOE.getOidProducto() != null ? DTOE.getOidProducto().toString() : "";  
			  sOidAlmacen = DTOE.getOidAlmacen() != null ? DTOE.getOidAlmacen().toString() : "";  
			  activado = DTOE.getActivado() != null ? DTOE.getActivado().toString() : "" ;  
			  txtStockMinimo = DTOE.getStockMinimo() != null ? DTOE.getStockMinimo().toString() : "";
			  txtStockMaximo = DTOE.getStockMaximo() != null ? DTOE.getStockMaximo().toString() : "";		
			  txtStockReposicion = DTOE.getStockReposicion() != null ? DTOE.getStockReposicion().toString() : ""; 
              txtCodigoProducto = DTOE.getCodigoProducto() != null ? DTOE.getCodigoProducto().toString() : "";
			  
			  asignarAtributo("VAR", "oidControlAlmacen", "valor", sOidControlAlmacen);     
			  asignarAtributo("VAR", "hCanal", "valor", sOidCanal);
			  asignarAtributo("VAR", "hAcceso", "valor", sOidAcceso);
			  asignarAtributo("VAR", "hSubacceso", "valor", sOidSubacceso);	 
			  asignarAtributo("VAR", "oidProducto", "valor", sOidProducto);
			  asignarAtributo("VAR", "oidAlmacen", "valor", sOidAlmacen);
			  asignarAtributo("VAR", "activado", "valor", activado);
			  asignarAtributo("CTEXTO", "txtStockMinimo", "valor", txtStockMinimo);
			  asignarAtributo("CTEXTO", "txtStockMaximo", "valor", txtStockMaximo);
			  asignarAtributo("CTEXTO", "txtStockReposicion", "valor", txtStockReposicion);
              asignarAtributo("CTEXTO", "txtCodigoProducto", "valor", txtCodigoProducto);
			  asignarAtributo("VAR", "hStockMinimo", "valor", txtStockMinimo);
			  asignarAtributo("VAR", "hStockMaximo", "valor", txtStockMaximo);
			  asignarAtributo("VAR", "hStockReposicion", "valor", txtStockReposicion);

			}
		/*
       *	Muestra en la página PGInsertarControlesAlmacen los datos recibidos en el DTOControlAlmacen:
		 */
		public void detalleControlAlmacen() throws Exception{
		traza("*********** Entre a detalleControlAlmacen - LPMantenimientoControlesAlmacen");

			DTOControlAlmacen DTO = obtenerControlAlmacen();
			cargarPGInsertarControlesAlmacen();
			// RECARGA DE COMBOS
			mostrarDatosControlAlmacen(DTO);
			
			asignarAtributo("VAR", "habilitaCanal", "valor","N");
			asignarAtributo("VAR", "habilitaAcceso", "valor","N");
			asignarAtributo("VAR", "habilitaSubacceso", "valor","N");
			asignarAtributo("VAR", "habilitaCodProd", "valor","N");
			asignarAtributo("VAR", "habilitaAlmacen", "valor","N");
			asignarAtributo("VAR", "habilitaSMinimo", "valor","N");
			asignarAtributo("VAR", "habilitaSMaximo", "valor","N");
			asignarAtributo("VAR", "habilitaSReposicion", "valor","N");
			asignarAtributo("VAR", "habilitaActivado", "valor","N");
		} 
}
