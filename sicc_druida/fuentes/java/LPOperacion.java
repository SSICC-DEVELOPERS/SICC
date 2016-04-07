/**
 * Copyright 2005 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
 /*
    INDRA/FAC/PROY
    $Id: LPOperacion.java,v 1.1 2009/12/03 18:35:04 pecbazalar Exp $
    DESC
 */

import es.indra.druida.DruidaConector;

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;

import es.indra.druida.dom.DruidaDOMObjeto;


import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOOID;

import es.indra.sicc.dtos.rec.DTOOperacion;

import java.util.Vector;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Collection;
import java.util.Iterator;

import java.math.BigDecimal;
import org.w3c.dom.Element;
import org.jaxen.dom.DOMXPath;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.cmn.presentacion.i18n.Idioma;
import es.indra.sicc.cmn.negocio.i18n.DTOI18nSICC;
 
// Definicion de la clase
public class LPOperacion extends LPSICCBase {
         
         
         private Long idioma = null; 
         private Long pais = null;
         private String accion = null;
         private String opcionMenu = null;
         private String idiomas = "";
         
         
         public LPOperacion() {
          	super();
         }
         
         public void inicio() throws Exception {
        
    }
    
    public void ejecucion() throws Exception{
         setTrazaFichero();
         try{    
                  traza("*** LPOperacion.ejecucion: Entrada **");
                  this.idioma = UtilidadesSession.getIdioma(this);
             this.pais = UtilidadesSession.getPais(this);
             this.accion = conectorParametroLimpia("accion","",true);
             traza("Accion definida : "+this.accion);
             this.opcionMenu = conectorParametroLimpia("opcionMenu","",true);
                           traza("opcionMenu definida : "+this.opcionMenu);
                           
                           Collection cIdiomas = getIdiomas(); //obtenemos los idiomas.
                           Iterator itIdiomas = cIdiomas.iterator();
                           while(itIdiomas.hasNext()){
                  Idioma idiomai18n = (Idioma)itIdiomas.next();
                                    this.idiomas += idiomai18n.getOid() +",";
                           }
                                             
                                                      
                           if(this.accion.equals("")){
                                    /*
                                    Si accion=" " { 
                                    Llama al método inicializar() 
                                    } */
                                    traza(" [CM] inicializar ");
                                    this.inicializar();
                           }else if(this.accion.equals("mostrar tipos operacion")){
                                                      /*Si accion="mostrar tipos operacion" { 
                                                      Llama al método mostrarPgTiposOperacion() pasandole el oidOperacion recibido 
                                                      } */
                                                      this.mostrarPgTiposOperacion();
                                        }else if(this.accion.equals("modificar operacion")){
                                                                /*Si accion ="modificar operacion" { 
                                                                Llama al método detalleOperacion() 
                                                                } */
                                                                this.detalleOperacion();
                                                        }else if(this.accion.equals("insertar operacion")){
                                                        			/*Si accion="insertar operacion" { 
                                                                                  Llama al metodo insertModif() 
                                                                                  Llama al método inicializar() 
                                                                                  } */
                                                                                  this.insertModif();
                                                                                  //this.inicializar();   
                                                                         // se elimina por incidencia 12971
                                                                         /*}else if(this.accion.equals("eliminar operacion"))
                                                                                    	  /*Si accion="eliminar operacion" { 
                                                                                             Llama al metodo eliminarOperacion() 
                                                                                             } 
                                                                                             this.eliminarOperacion();	  
                                                                                             */
                                                                                    }else if(this.accion.equals("detalle operacion")){
                                                                                    			/*Si accion="detalle operacion" { 
                                                                                                             Llama al metodo detalleOperacion() 
                                                                                                             }*/
                                                                                                             this.detalleOperacion();
                                                                                                    }	
                           traza("*** LPOperacion.ejecucion: Salida **");
                           
         }catch ( Exception e )  {
                  e.printStackTrace();
                  this.logStackTrace(e);
                  lanzarPaginaError(e);
         }                 
    
         }
         
         public void inicializar() throws Exception{

                  traza("*** LPOperacion.inicializar: Entrada ***");
                  
                  traza("*** Opción de menu: " + this.opcionMenu);
                                    
                  if(this.opcionMenu.equals("crear operacion")){
							   /*Si opcionMenu="crear operacion" { 
							   Deshabilitar btnConsultarTiposOperacion  --> hacerlo en el onload comprobando la opcionMenu que llega
							   Llama al método MostrarPgOperacion() con accion="crear operacion" 
							   } */
							   traza(" [CM] crear operacion ");
							   this.mostrarPgOperacion(null);	
                                                      
                           }else if(this.opcionMenu.equals("modificar operacion")){
									/*Si opcionMenu="modificar operacion" { 
									Deshabilitar btnDetalle  --> hacerlo en el onload
									Muestra la pantalla PgBuscarOperacion() 
									}*/
									pagina("contenido_operaciones_modificar");
									asignarAtributo("PAGINA","contenido_operaciones_modificar", "cod", "0488");
									asignarAtributo("PAGINA","contenido_operaciones_modificar", "msgle", "Modificar Operaciones");
									getConfiguracionMenu("LPOperacion", "consultarOperacion");
									asignarAtributo("VAR","opcionMenu","valor",this.opcionMenu);
									asignar("VAR", "idioma", this.idioma.toString());
									traza("->Idioma : "+this.idioma);
									asignar("VAR", "pais", this.pais.toString());   
									traza("->Pais : "+this.pais);
                                   	  
                             	}else if(this.opcionMenu.equals("eliminar operacion")){
													/*Si opcionMenu="Elimnar operacion" { 
																  Deshabilitar btnModificar --> hacerlo en el onload
																  Deshabilitar btnDetalle --> hacerlo en el onload
																  Muestra la pantalla PgBuscarOperacion 	
																  }*/
                                                    pagina("contenido_operaciones_modificar");
													asignarAtributo("PAGINA","contenido_operaciones_modificar", "cod", "0490");
													asignarAtributo("PAGINA","contenido_operaciones_modificar", "msgle", "Eliminar Operaciones");
													getConfiguracionMenu("LPOperacion", "eliminarOperacion");
													asignarAtributo("VAR","opcionMenu","valor",this.opcionMenu);
													asignar("VAR", "idioma", this.idioma.toString());
													traza("->Idioma : "+this.idioma);
													asignar("VAR", "pais", this.pais.toString());	
													traza("->Pais : "+this.pais);
                                                }else if(this.opcionMenu.equals("consultar operacion")){
                                                	
														traza("*** Entro en el if, opcion Consultar");
																/*Si opcionMenu="consultar operacion" { 
																	Deshabilitar btnModificar --> hacerlo en el onload
																	Muestra la pantalla PgBuscarOperacion() 
																	}*/
														pagina("contenido_operaciones_modificar");
														asignarAtributo("PAGINA","contenido_operaciones_modificar", "cod", "0489");
														asignarAtributo("PAGINA","contenido_operaciones_modificar", "msgle", "Consultar Operaciones");
														getConfiguracionMenu("LPOperacion", "consultarOperacion");
														asignarAtributo("VAR","opcionMenu","valor",this.opcionMenu);
														traza("*** Despues de asignar ");
														asignar("VAR", "idioma", this.idioma.toString());
														traza("->Idioma : "+this.idioma);
														asignar("VAR", "pais", this.pais.toString());	
														traza("->Pais : "+this.pais);
												 }
                  
                  
                  traza("*** LPOperacion.inicializar: Salida ***");
         }

         public void mostrarPgOperacion(DTOOperacion dtoE) throws Exception{

                  // las comprobaciones son con opcionMenu no con accion como indica el diseño
                  traza("*** LPOperacion.mostrarPgOperacion: Entrada ***");
                  traza("*** OpcionMenu = "+this.opcionMenu);
                  if(this.opcionMenu.equals("crear operacion")){
						   /*Si accion="crear operacion" { 
						   Llamar al metodo cargarPgOperacion() 
						   Muestra la pantalla PgOperacios con 
						   - btnConsultarTiposOperacion deshabilitado  --> hacerlo en el onload
						   - opcionMenu="crear operacion" 
						   } */
							traza(" [CM] mostrando pagina de insertar cmatilla");
							pagina("contenido_operaciones_insertar");
							asignarAtributo("PAGINA","contenido_operaciones_insertar", "cod", "0487");
							asignarAtributo("PAGINA","contenido_operaciones_insertar", "msgle", "Insertar Operaciones");
							getConfiguracionMenu("LPOperacion", "insertarOperacion");
							asignar("VAR", "idioma", this.idioma.toString());
							traza("->Idioma : "+this.idioma);
							asignar("VAR", "pais", this.pais.toString());        
							traza("->Pais : "+this.pais);
							anyadeHiddensI18N(true, "REC_OPERA", null, new Integer(1), "frmFormulario", "txtDescripcionCorta", false);
							this.cargarPgOperacion();
							//añadido por incidencia 19565
							asignarAtributoElemento("cbTipoSolicitudPerdida","disabled","S");
                           
							asignarAtributo("VAR","opcionMenu","valor","crear operacion");
                           
                  }else if(this.opcionMenu.equals("modificar operacion")){
								  /*Si accion="modificar operacion" { 
								  Llamar al metodo cargarPgOperacion() 
									
								  Muestra la pantalla PgOperaciones con 
								  - btnConsultarTiposOperaciones deshabilitado --> hacerlo en el onload
								  - opcionMenu= "modificar operacion" 
								  } */
									pagina("contenido_operaciones_insertar");
									asignarAtributo("PAGINA","contenido_operaciones_insertar", "cod", "0488");
									asignarAtributo("PAGINA","contenido_operaciones_insertar", "msgle", "Modificar Operaciones");
                                    getConfiguracionMenu("LPOperacion", "modificarOperacion");
                                    asignar("VAR", "idioma", this.idioma.toString());
									traza("->Idioma : "+this.idioma);
									asignar("VAR", "pais", this.pais.toString()); 
									traza("->Pais : "+this.pais);
									anyadeHiddensI18N(true, "REC_OPERA", dtoE.getOidOperacion(), new Integer(1), "frmFormulario", "txtDescripcionCorta", false);
									asignar("VAR", "oidOperacion", dtoE.getOidOperacion().toString());
                                    this.cargarPgOperacion();
                                    //Asigna los campos de la pantalla a los valores recibidos en el DTOOperacion 
                                    this.rellenarPagina(dtoE);
                                      				  
                                    asignarAtributo("VAR","opcionMenu","valor","modificar operacion"); 
                                      
								   // splatas - BELC300022817 - 24/05/2006
								   asignarAtributoElemento("txtCodigoOperacion","disabled","S");
            
                              
                              }else if(this.opcionMenu.equals("detalle operacion")){
									/*Si accion="detalle operacion" { 
									Llamar al metodo cargarPgOperacion() 
									Asigna los campos de la pantalla a los valores recibidos en el DTOOperacion.resultado 
									Deshabilitar todos los campos //puesto que se trata de una consulta 
									Muestra la pantalla PgOperacio con 
									- btnAñadirTiposOperaciones deshabilitado --> hacer en el onload
									- opcionMenu="consultar operacion" 
									} */
									pagina("contenido_operaciones_insertar");                                                            
									asignarAtributo("PAGINA","contenido_operaciones_insertar", "cod", "0489");                      
									asignarAtributo("PAGINA","contenido_operaciones_insertar", "msgle", "Consultar Operaciones"); 
									getConfiguracionMenu("LPOperacion", "modificarOperacion");
									asignar("VAR", "idioma", this.idioma.toString());
									traza("->Idioma : "+this.idioma);
									asignar("VAR", "pais", this.pais.toString()); 
									traza("->Pais : "+this.pais);
									asignar("VAR", "oidOperacion", dtoE.getOidOperacion().toString());
									anyadeHiddensI18N(true, "REC_OPERA", dtoE.getOidOperacion(), new Integer(1), "frmFormulario", "txtDescripcionCorta", true);
									asignarAtributo("VAR","opcionMenu","valor","consultar operacion"); 
									this.cargarPgOperacion(); 
									//Asigna los campos de la pantalla a los valores recibidos en el DTOOperacion 
									this.rellenarPagina(dtoE); 
									//Deshabilitar todos los campos
									asignarAtributoElemento("txtCodigoOperacion","disabled","S");								
									asignarAtributoElemento("txtDescripcionCorta","disabled","S");	
									asignarAtributoElemento("txtDescripcionLarga","disabled","S");
									asignarAtributoElemento("cbPrecios","disabled","S");
									asignarAtributoElemento("Anulacion","disabled","S");
									asignarAtributoElemento("Perdida","disabled","S");
									asignarAtributoElemento("cbTipoSolicitudPerdida","disabled","S");
									asignarAtributoElemento("EsperarMercanciaFisica","disabled","S");
									asignarAtributoElemento("DevueltoFisicoFactura","disabled","S");
									asignarAtributoElemento("txtNumeroCampanas","disabled","S");
									asignarAtributoElemento("cbPrecioEnvia","disabled","S");
									asignarAtributoElemento("cbBloqueoChequeo","disabled","S");
									asignarAtributoElemento("FaltanteMercaderia","disabled","S");
									asignarAtributoElemento("IngresaEnvia","disabled","S");
									asignarAtributoElemento("cbTipoSolicitud1","disabled","S");
									asignarAtributoElemento("cbTipoSolicitud2","disabled","S");
									asignarAtributoElemento("cbCodigoMensajeGenerar","disabled","S");
									asignarAtributoElemento("EnviaGeneraDevuelve","disabled","S");
									asignarAtributoElemento("IngresaDevuelve","disabled","S");
									asignarAtributoElemento("cbTipoSolicitudGenera","disabled","S");
									asignarAtributoElemento("cbAlmacen","disabled","S");
									asignarAtributoElemento("cbMovimientoAlmacen","disabled","S");
									asignarAtributoElemento("DevuelveGeneraEnvia","disabled","S");
                                                         
									 // Se deshabilita en el js
									 //asignarAtributoElemento("btnAnadirTiposOperaciones","disabled","S");
                                      		                                                                              						  
								}
                  
                  traza("*** LPOperacion.mostrarPgOperacion: Salida ***");

    }
    
         public void cargarPgTiposOperacion() throws Exception{
                  
                  traza("*** LPOperacion.cargarPgTiposOperacion: Entrada ***");
                  /*Documentation
                  Crear un DTOBelcorp dtoe con: 
                  - pais = Pais activo 
                  - idioma = Idioma del usuario 
                  */
                  DTOBelcorp dtoe = new DTOBelcorp();
                  dtoe.setOidPais(this.pais);
                  dtoe.setOidIdioma(this.idioma);
                  
                  
                  //Crear una lista ComposerViewElementList 
                  ComposerViewElementList listelem = new ComposerViewElementList();
                  ComposerViewElement elem = new ComposerViewElement(); 
                  
                  //Bloqueo por diferencia de precio 
                  /*Crear un elemento de tipo ComposerViewElement() para cargar los precios 
                  elem.IDBusiness="RECObteneMotivosBloqueo"; 
                  elem.DTOE=dtoe; 
                  */
                  elem.setIDBusiness("RECObtenerMotivosBloqueo");
                  elem.setDTOE(dtoe);
                  listelem.addViewElement(elem);
                  traza("Elemento primero aniadido");
                  /*
                  //Rechazo por validacion 
                  Crear un elemento de tipo ComposerViewElement() para cargar los precios 
                  elem.IDBusiness="RECObteneMotivosRechazoDesbloqueo"; 
                  elem.DTOE=dtoe; 
                  */
                  elem = new ComposerViewElement();
                  elem.setIDBusiness("RECObtenerMotivosRechazoDesbloqueo");
                  elem.setDTOE(dtoe);
                  listelem.addViewElement(elem);
                  traza("Elemento segundo aniadido");
                  /*Invocar al subsistema GestorCargaPantalla 
                  
                  Asigna los combos: 
                  - cbBloqueoPorDiferenciaPrecio <- RECObteneMotivosBloqueo 
                  - cbBloqueoPorReclamoAnterior <- RECObteneMotivosBloqueo 
                  - cbReclamoPorImporte <- RECObteneMotivosBloqueo 
                  - cbBloqueoPorUnidades <- RECObteneMotivosBloqueo 
                  - cbRechazoPorValidacion <- RECObteneMotivosRechazoDesbloqueo
                  */
                  ConectorComposerView conector = new ConectorComposerView(listelem,this.getRequest());
                  traza("conector creado");
                  conector.ejecucion();
                  traza("ejecutado");
                  DruidaConector conConsultar = conector.getConector();
                  traza("Obtener conConsultar");

                  asignar("COMBO","cbBloqueoDiferenciaPrecio", conConsultar,"RECObtenerMotivosBloqueo");
                  asignar("COMBO","cbBloqueoReclamoAnterior", conConsultar,"RECObtenerMotivosBloqueo");
                  asignar("COMBO","cbBloqueoImporte", conConsultar,"RECObtenerMotivosBloqueo");
                  asignar("COMBO","cbBloqueoUnidades", conConsultar,"RECObtenerMotivosBloqueo");
                  asignar("COMBO","cbRechazoValidacion", conConsultar,"RECObtenerMotivosRechazoDesbloqueo");

                  traza("*** LPOperacion.cargarPgTiposOperacion: Salida ***");
         }

         public void cargarPgOperacion() throws Exception{

                  traza("*** LPOperacion.cargarPgOperacion: Entrada ***");
                  /*Crear un DTOBelcorp dtoe con: 
                  - pais = Pais activo 
                  - idioma = Idioma del usuario 
                  */
                  DTOBelcorp dtoe = new DTOBelcorp();
                  dtoe.setOidPais(this.pais);
                  dtoe.setOidIdioma(this.idioma);
                  
                  //Crear una lista ComposerViewElementList 
                  ComposerViewElementList listelem = new ComposerViewElementList();
                  ComposerViewElement elem = new ComposerViewElement(); 
                  
                  /*Precios 
                  Crear un elemento de tipo ComposerViewElement() para cargar los precios 
                  elem.IDBusiness="RECObtenerPrecios"; 
                  elem.DTOE=dtoe; 
                  Añadir el elemento a la lista 
                  */
                  elem.setIDBusiness("RECObtenerPrecios");
                  elem.setDTOE(dtoe);
                  listelem.addViewElement(elem);
                  traza("Elemento 1 aniadido");
                  
                  // incidencia BELC300019226
                  //TipoSolicitud para perdida 
                  /*Crear un elemento de tipo ComposerViewElement() para cargar TipoSolicitudPerdida
                  elem.IDBusiness="RECObtenerTipoSolicitud"; 
                  elem.DTOE=dtoe; 
                  Añadir el elemento a la lista 
                  */
                  elem = new ComposerViewElement();
                  elem.setIDBusiness("RECObtenerTipoSolicitud");
                  elem.setDTOE(dtoe);
                  listelem.addViewElement(elem);
                  traza("Elemento 2 aniadido");
                  
                  // incidencia BELC300019226
                  //TipoSolicitud1: tipo de solicitud que se genera si hay stock para el producto 
                  //TipoSolicitud2: tipo de solicitud que se genera si no hay stock para el producto 
                  /*Crear un elemento de tipo ComposerViewElement() para cargar los TipoSolicitud1 y TipoSolicitud2 
                  elem.IDBusiness="RECObtenerTipoSolicitudNoNegativa"; 
                  elem.DTOE=dtoe; 
                  Añadir el elemento a la lista*/
                  elem = new ComposerViewElement();
                  elem.setIDBusiness("RECObtenerTipoSolicitudNoNegativa");
                  elem.setDTOE(dtoe);
                  listelem.addViewElement(elem);
                  traza("Elemento 3 aniadido");		
                  
                  /*	Incidencia BELC300021621
                  //TipoSolicitud2: tipo de solicitud que se genera si no hay stock para el producto
                   Crear un elemento de tipo ComposerViewElement() para cargar los TipoSolicitud1 y TipoSolicitud2
                   elem.IDBusiness="RECObtenerTipoSolicitudNegativa";
                   elem.DTOE=dtoe;
                   Añadir el elemento a la lista
                  */
                  elem = new ComposerViewElement();
                  elem.setIDBusiness("RECObtenerTipoSolicitudNegativa");
                  elem.setDTOE(dtoe);
                  listelem.addViewElement(elem);
                  traza("Elemento 3 - A aniadido");

                  /*PrecioEnvia 
                  Crear un elemento de tipo ComposerViewElement() para cargar los preciosEnvia 
                  elem.IDBusiness="RECObtenePrecioEnvia"; 
                  elem.DTOE=dtoe; 
                  Añadir el elemento a la lista 
                  */
                  elem = new ComposerViewElement();
                  elem.setIDBusiness("RECObtenerPrecioEnvia");
                  elem.setDTOE(dtoe);
                  listelem.addViewElement(elem);
                  traza("Elemento 4 aniadido");
                                    
                  /*Bloqueo por Chequeo 
                  Crear un elemento de tipo ComposerViewElement() para cargar los BloqueoChequeo 
                  elem.IDBusiness="RECObtenerMotivosBloqueo"; 
                  elem.DTOE=dtoe; 
                  Añadir el elemento a la lista 
                  */
                  elem = new ComposerViewElement();
                  elem.setIDBusiness("RECObtenerMotivosBloqueo");
                  elem.setDTOE(dtoe);
                  listelem.addViewElement(elem);
                  traza("Elemento 5 aniadido");
                                    
                  /*Codigo mensaje a generar 
                  Crear un elemento de tipo ComposerViewElement() para cargar los mensajes 
                  elem.IDBusiness="RECObtenerMensajes"; 
                  elem.DTOE=dtoe; 
                  Añadir el elemento a la lista 
                  */
                  elem = new ComposerViewElement();
                  elem.setIDBusiness("RECObtenerMensajes");
                  elem.setDTOE(dtoe);
                  listelem.addViewElement(elem);
                  traza("Elemento 6 aniadido");
                  
                  
                  /*TipoSolicitudGenera 
                  Crear un elemento de tipo ComposerViewElement() para cargar los TipoSolicitudGenera 
                  elem.IDBusiness="RECObtenerTipoSolicitudGenera"; 
                  elem.DTOE=dtoe; 
                  Añadir el elemento a la lista 
                  */
                  elem = new ComposerViewElement();
                  elem.setIDBusiness("RECObtenerTipoSolicitudGenera");
                  elem.setDTOE(dtoe);
                  listelem.addViewElement(elem);
                  traza("Elemento 7 aniadido");
                  
                  
                  /*Almacen 
                  Crear un elemento de tipo ComposerViewElement() para cargar los Almacenes 
                  elem.IDBusiness="RECObtenerAlmacen"; 
                  elem.DTOE=dtoe; 
                  Añadir el elemento a la lista 
                  */
                  elem = new ComposerViewElement();
                  elem.setIDBusiness("RECObtenerAlmacen");
                  elem.setDTOE(dtoe);
                  listelem.addViewElement(elem);
                  traza("Elemento 8 aniadido");
                                    
                  /*MovimientoAlmacen 
                  Crear un elemento de tipo ComposerViewElement() para cargar los MovimientoAlmacen 
                  elem.IDBusiness="RECObtenerMovimientoAlmacen"; 
                  elem.DTOE=dtoe; 
                  Añadir el elemento a la lista 
                  */
                  elem = new ComposerViewElement();
                  elem.setIDBusiness("RECObtenerMovimientoAlmacen");
                  elem.setDTOE(dtoe);
                  listelem.addViewElement(elem);
                  traza("Elemento 9 aniadido");
                  
                  
                  /*Invocar al subsistema GestorCargaPantalla 
                  
                  Asigna los combos: 
                  - cbPrecios <- RECObtenerPrecios 
                  - cbTipoSolicitudPerdida <- RECObtenerTipoSolicitud 
                  - cbPrecioEnvia <- RECObtenePrecioEnvia 
                  - cbBloqueoChequeo <- REC:ObtenerMotivosBloqueo 
                  - cbTipoSolicitud1 <- RECObtenerTipoSolicitudNoNegativa 
                  - cbTipoSolicitud2 <- RECObtenerTipoSolicitudNoNegativa 
                  - cbMensajeGenerar <- RECObtenerMensajes 
                  - cbTipoSolicitudGenera <- RECObtenerTipoSolicitudGenera 
                  - cbAlmacen <- RECObtenerAlmacen 
                  - cbMovimientoAlmacen <- RECObtenerMovimientoAlmacen
                  */
                  ConectorComposerView conector = new ConectorComposerView(listelem,this.getRequest());
         traza("conector creado");
         conector.ejecucion();
         traza("ejecutado");
         DruidaConector conConsultar = conector.getConector();
         traza("Obtener conConsultar");
         
         asignar("COMBO","cbPrecios", conConsultar,"RECObtenerPrecios");
                  asignar("COMBO","cbTipoSolicitudPerdida", conConsultar,"RECObtenerTipoSolicitud");
                  asignar("COMBO","cbTipoSolicitud1", conConsultar,"RECObtenerTipoSolicitudNoNegativa");
                  asignar("COMBO","cbTipoSolicitud2", conConsultar,"RECObtenerTipoSolicitudNegativa");
                  asignar("COMBO","cbPrecioEnvia", conConsultar,"RECObtenerPrecioEnvia");	
                  asignar("COMBO","cbBloqueoChequeo", conConsultar,"RECObtenerMotivosBloqueo");
                  asignar("COMBO","cbCodigoMensajeGenerar", conConsultar,"RECObtenerMensajes");
                  asignar("COMBO","cbAlmacen", conConsultar,"RECObtenerAlmacen");
                  asignar("COMBO","cbMovimientoAlmacen", conConsultar,"RECObtenerMovimientoAlmacen");
                  asignar("COMBO","cbTipoSolicitudGenera", conConsultar,"RECObtenerTipoSolicitudGenera");
    
    //vbongiov -- GCC-COL-REC-001 -- 14/12/2007    
    asignar("COMBO","cbTipoSolicitudRecojoInicial", conConsultar,"RECObtenerTipoSolicitudNegativa");
    asignar("COMBO","cbTipoSolicitudPrimerRecojoNoExitoso", conConsultar,"RECObtenerTipoSolicitud");
    asignar("COMBO","cbTipoSolicitudSegundoRecojoNoExitoso", conConsultar,"RECObtenerTipoSolicitud");
    asignar("COMBO","cbAlmacenPostVenta", conConsultar,"RECObtenerAlmacen");
    asignar("COMBO","cbMovimientoAlmacenRecojoInicial", conConsultar,"RECObtenerMovimientoAlmacen");
    asignar("COMBO","cbMovimientoAlmacenRecojoExitoso", conConsultar,"RECObtenerMovimientoAlmacen");
    asignar("COMBO","cbMovimientoAlmacenRecojoNoExitoso", conConsultar,"RECObtenerMovimientoAlmacen"); 
                  

				traza("*** LPOperacion.cargarPgOperacion: ParamIntPais***");

				  Vector paramConector = new Vector();
                  DTOBelcorp dtoBel=new DTOBelcorp();
                  dtoBel.setOidIdioma(idioma);
                  dtoBel.setOidPais(pais);
                  paramConector.add(dtoBel);
                  paramConector.add(new MareBusinessID("RECObtenerParamIntPais"));            
                  traza("Antes de Conectar ConectorObtenerParamIntPais");
                  DruidaConector conector2 = conectar("ConectorObtenerParamIntPais", paramConector);							
                  traza("Despues de Conectar ConectorObtenerParamIntPais");
                  Object objeto=conector2.objeto("DTOSalida");
                  traza("Objeto recogido"+objeto);
                  DTOSalida salida = (DTOSalida)conector2.objeto("DTOSalida");
                  traza("DTOSalida obtenido");
                  RecordSet rs = salida.getResultado();
                  if(!rs.esVacio()){
				     if(rs.getValueAt(0,"VAL_CANT_RECO")!=null){
					   Long cantRecojo = null;	
					   cantRecojo = Long.valueOf(((BigDecimal) rs.getValueAt(0,"VAL_CANT_RECO")).toString());
			           asignarAtributo("VAR","hcantRecojo","valor",cantRecojo.toString());               
		            }
				  }

                  traza("*** LPOperacion.cargarPgOperacion: Salida ***");
         }

         public DTOSalida obtenerTiposOperacion(Long oidOperacion ) throws Exception{

                  /*Documentation
                  //Obtenermos los tipos de operacion asociados a la operacion 
                  Invocar conector ConectorObtenerTiposOperacion con un DTO del tipo DTOOid- Parametro del DTOOid: 
                  - oid = oidOperacion (parametro recibido que indica a que operacion estan asociados estos tipos de operacion) 
                  Crear IDBusiness="RECObtenerTiposOperacion" 
                  Obtiene DTOSalida. 
                  */
                  traza("*** LPOperacion.obtenerTiposOperacion: Entrada ***");
                  
                  Vector paramConector = new Vector();
                  DTOOID dtoOid=new DTOOID();
                  dtoOid.setOidIdioma(idioma);
                  dtoOid.setOidPais(pais);
                  dtoOid.setOid(oidOperacion);
                  paramConector.add(dtoOid);
                  paramConector.add(new MareBusinessID("RECObtenerTiposOperacion"));            
                  traza("Antes de Conectar ConectorObtenerTiposOperacion");
                  DruidaConector conector = conectar("ConectorObtenerTiposOperacion", paramConector);							
                  traza("Despues de Conectar ConectorObtenerTiposOperacion");
                  Object objeto=conector.objeto("DTOSalida");
                  traza("Objeto recogido"+objeto);
                  DTOSalida salida = (DTOSalida)conector.objeto("DTOSalida");
                  traza("DTOSalida obtenido");
                  
                  // Modificamos los valores boolean por un si o un no que es lo que aparece en la lista
                  RecordSet rs = salida.getResultado();
                  if(!rs.esVacio()){
                           for(int i=0;i<rs.getRowCount();i++){
                                    
                                    if(rs.getValueAt(i,3) != null){
                                             if( ((BigDecimal)rs.getValueAt(i,3)).intValue() == 1)
                                                      rs.setValueAt("Si",i,3);
                                             else
                                                      rs.setValueAt("No",i,3);
                                    }
                                    if(rs.getValueAt(i,5) != null){
                                             if( ((BigDecimal)rs.getValueAt(i,5)).intValue() == 1)
                                                      rs.setValueAt("Si",i,5);
                                             else
                                                      rs.setValueAt("No",i,5);
                                    }
                                    if(rs.getValueAt(i,6) != null){
                                             if( ((BigDecimal)rs.getValueAt(i,6)).intValue() == 1)
                                                      rs.setValueAt("Si",i,6);
                                             else
                                                      rs.setValueAt("No",i,6);
                                    }
                                    if(rs.getValueAt(i,7) != null){
                                             if( ((BigDecimal)rs.getValueAt(i,7)).intValue() == 1)
                                                      rs.setValueAt("Si",i,7);
                                             else
                                                      rs.setValueAt("No",i,7);
                                    }	
                           }
                  }
                  salida.setResultado(rs);	
                  
                  
                  traza("*** LPOperacion.obtenerTiposOperacion: Salida ***");
                  return salida;
         }
         
         public void mostrarPgTiposOperacion() throws Exception{ 

                  /*Documentation
                  Si opcionMenu="modificar operacion" { 
                  lstResultados=obtenerTipoOperacion(oidOperacion) 
                  Llama al metodo cargarPgTiposOperacion 
                  Muestra la pantalla PgTiposOperacion pasandole 
                  - oidOperaciones recibido de la pantalla 
                  - la variable booleana modificado a false. 
                  }*/
                  traza("*** LPOperacion.mostrarPgTiposOperacion: Entrada ***");
                  String oid = conectorParametroLimpia("oidOperacion","",true);
                  String listaTipos = conectorParametroLimpia("listaTiposSinFormatear","",true);
                  String listaEliminados = conectorParametroLimpia("listaEliminados","",true);
                  traza("*** OID = "+oid);
                  traza("*** ArrayListaTipos = "+listaTipos);
                  traza("*** ArrayEliminados = "+listaEliminados);
                  
                  if(this.opcionMenu.equals("modificar operacion")){
                           traza("*** opcionMenu = modificar operacion ***");
                           
                           pagina("contenido_operaciones_mantener");
                           asignarAtributo("PAGINA","contenido_operaciones_mantener", "cod", "0934");
             asignarAtributo("PAGINA","contenido_operaciones_mantener", "msgle", "Mantener Tipos de Operaciones");
             getConfiguracionMenu("LPOperacion","tiposOperacion");
             asignarAtributo("VAR","opcionMenu","valor",this.opcionMenu);
             asignarAtributo("VAR","idiomas","valor",this.idiomas);
             asignarAtributo("VAR","listaTipos","valor",listaTipos);
             asignarAtributo("VAR","listaEliminados","valor",listaEliminados);
             
             asignar("VAR", "idioma", this.idioma.toString());
             traza("->Idioma : "+this.idioma);
             asignar("VAR", "pais", this.pais.toString());        
             traza("->Pais : "+this.pais);
                           this.crearHiddensI18N(false,new Integer(1)); 
                           this.cargarPgTiposOperacion();
                           //cargar la lista
                           if(listaTipos.equals("")){ // modificacion por incidencia 13620
                                    DTOSalida dtoS = this.obtenerTiposOperacion(new Long(oid));  
                                    RecordSet rs = dtoS.getResultado();
                                    Vector cols = null;
                                    DruidaConector conectorCargaLista = null; 	
                  
                                    if (rs != null ) {
                                             cols = rs.getColumnIdentifiers();
                                             conectorCargaLista = UtilidadesBelcorp.generarConector("DTOSalida.combo_ROWSET", rs, cols);
                                             asignar("LISTAEDITABLE", "listado1", conectorCargaLista, "DTOSalida.combo_ROWSET");
                           } 
                  }
                           asignarAtributo("VAR","oidOperacion","valor", oid);
                           asignarAtributo("VAR","modificado","valor","false");
                  } 
                  
                  /*Si opcionMenu="consultar operacion" { 
                  Llama al metodo cargarPgTiposOperacion 
                  Muestra la pantalla PgTiposOperacion pasandole 
                  - oidOperaciones recibido de la pantalla 
                  - la variable booleana modificado a false. 
                  Se deshabilitan todos los campos de la pantalla. 
                  } */
                  if(this.opcionMenu.equals("consultar operacion")){
                           traza("*** opcionMenu = consultar operacion ***");
                           pagina("contenido_operaciones_mantener");
                           asignarAtributo("PAGINA","contenido_operaciones_mantener", "cod", "0934");
             asignarAtributo("PAGINA","contenido_operaciones_mantener", "msgle", "Mantener Tipos de Operaciones");
                           getConfiguracionMenu("LPOperacion","tiposOperacion");
                           asignarAtributo("VAR","opcionMenu","valor",this.opcionMenu);
                           asignar("VAR", "idioma", this.idioma.toString());
             traza("->Idioma : "+this.idioma);
             asignar("VAR", "pais", this.pais.toString());        
             traza("->Pais : "+this.pais);
                           this.cargarPgTiposOperacion();
                           this.crearHiddensI18N(true,new Integer(1));
                           DTOSalida dtoS = this.obtenerTiposOperacion(new Long(oid));
                           //cargar la lista
                           RecordSet rs = dtoS.getResultado();
                           Vector cols = null;
                           DruidaConector conectorCargaLista = null; 	

                           if (rs != null ) {
                                    cols = rs.getColumnIdentifiers();
                                    conectorCargaLista = UtilidadesBelcorp.generarConector("DTOSalida.combo_ROWSET", rs, cols);
                                    asignar("LISTAEDITABLE", "listado1", conectorCargaLista, "DTOSalida.combo_ROWSET");
                  }
                           asignarAtributo("VAR","oidOperacion","valor", oid);
                           asignarAtributo("VAR","modificado","valor","false");
                           //desabilitar campos
                           asignarAtributoElemento("txtTipoOperacion","disabled","S");								
             asignarAtributoElemento("txtDescripcion","disabled","S");   
                           asignarAtributoElemento("txtDescripcionLarga","disabled","S");
                           asignarAtributoElemento("txtCantidadDiasAtras","disabled","S");
                           asignarAtributoElemento("CampanaReferenciaUnica","disabled","S");
                           asignarAtributoElemento("InformacionEbelNoticias","disabled","S");
                           asignarAtributoElemento("DevuelveEstaFactura","disabled","S");
                           asignarAtributoElemento("EnviaEstaFactura","disabled","S");
                           asignarAtributoElemento("cbBloqueoDiferenciaPrecio","disabled","S");
                           asignarAtributoElemento("cbBloqueoReclamoAnterior","disabled","S");
                           asignarAtributoElemento("cbBloqueoImporte","disabled","S");
                           asignarAtributoElemento("cbBloqueoUnidades","disabled","S");
                           asignarAtributoElemento("cbRechazoValidacion","disabled","S");
                           asignarAtributoElemento("iconoI18N","onclick",""); 
                           
                           // los botones se deshabilitan en el js
                           /*asignarAtributoElemento("btnInsertar","disabled","S");
                           asignarAtributoElemento("Modificar","disabled","S");
                           asignarAtributoElemento("Eliminar","disabled","S");
                           */
                  }
                  
                  /*Si opcionMenu="crear operacion" { 
                  Llama al metodo cargarPgTiposOperacion 
                  Muestra la pantalla "PGTiposOperacion" 
                  } 
                  */
                  if(this.opcionMenu.equals("crear operacion")){
                           traza("*** opcionMenu = crear operacion ***");
                           pagina("contenido_operaciones_mantener");
                           asignarAtributo("PAGINA","contenido_operaciones_mantener", "cod", "0934");
             asignarAtributo("PAGINA","contenido_operaciones_mantener", "msgle", "Mantener Tipos de Operaciones");
                           getConfiguracionMenu("LPOperacion","tiposOperacion");
                           asignarAtributo("VAR","idiomas","valor",this.idiomas);
                           asignarAtributo("VAR","listaTipos","valor",listaTipos);
             asignarAtributo("VAR","listaEliminados","valor",listaEliminados);
                           asignar("VAR", "idioma", this.idioma.toString());
             traza("->Idioma : "+this.idioma);
             asignar("VAR", "pais", this.pais.toString());        
             traza("->Pais : "+this.pais);
                           asignarAtributo("VAR","opcionMenu","valor",this.opcionMenu);
                           this.crearHiddensI18N(false,new Integer(1)); 
                           this.cargarPgTiposOperacion();
                  }
                  traza("*** LPOperacion.mostrarPgTiposOperacion: Salida ***");
         }
         
         public void insertarOperacion() throws Exception{
                  
                  
                  /*Llama al metodo crearDtoOperacion() 
                  Con el DTOE recibido 
                  Invocar al conector ConectorInsertarOperacion con el DTOE 
                  Crear IDBusiness="RECInsertarOperacion" 
                  */
                  
                  traza("*** LPOperacion.insertarOperacion: Entrada ***");
                  DTOOperacion dtoE = this.crearDtoOperacion();
                  
                  pagina("salidaGenerica");
                  asignar("VAR", "cerrarVentana", "false");
                                    
                  Vector paramConector = new Vector();
                  paramConector.add(dtoE);
                  paramConector.add(new MareBusinessID("RECInsertarOperacion"));            
                  traza("Antes de Conectar ConectorInsertarOperacion");
                  DruidaConector conector = conectar("ConectorInsertarOperacion", paramConector);							
                  traza("Despues de Conectar ConectorInsertarOperacion");
                  
                  traza("*** LPOperacion.insertarOperacion: Salida ***");
 
                  
         }
         
         public void modificarOperacion() throws Exception{

                  /*Llama al metodo crearDtoOperacion() 
                  Con el DTOE recibido 
                  Invocar al conector ConectorInsertarOperacion con el DTOE 
                  Crear IDBusiness="RECInsertarOperacion" 
                  */
                  
                  traza("*** LPOperacion.modificarOperacion: Entrada ***");
                  DTOOperacion dtoE = this.crearDtoOperacion();
                  
                  pagina("salidaGenerica");
                  asignar("VAR", "cerrarVentana", "false");
                  
                  Vector paramConector = new Vector();
                  paramConector.add(dtoE);
                  paramConector.add(new MareBusinessID("RECInsertarOperacion"));            
                  traza("Antes de Conectar ConectorInsertarOperacion");
                  DruidaConector conector = conectar("ConectorInsertarOperacion", paramConector);							
                  traza("Despues de Conectar ConectorInsertarOperacion");
                  
                  //Si se produce un error se muestra el mensaje correspondiente, en caso OK se genera 
                  //una pagina con una funcion javaScript que cierre la ventana.
                  
                  
                  traza("*** LPOperacion.modificarOperacion: Salida ***");

         }
                  
         public DTOOperacion crearDtoOperacion() throws Exception{

                  /*Recoge los datos procedentes de la PgOperacion 
                  Crear DTOE del tipo DTOOperacion con los atributos recogidos: 
                  DTOE.oidOperacion = oidOperacion //En el caso de ser insercion estara a null 
                  DTOE.codOperacion = codOperacion 
                  DTOE.descripcionCorta = descripcionCorta 
                  DTOE.descripcionLarga = descripcionLarga 
                  DTOE.oidPrecios = oidPrecios del elemento seleccionado en la cbPrecios 
                  DTOE.anulacion = anulacion 
                  DTOE.perdida = perdida 
                  DTOE.oidTipoSolicitudPerdida = oidTipoSolicitudPerdida del elemento seleccionado en la cbTipoSolicitudPerdida 
                  DTOE.esperarMercanciaFísica = esperarMercanciaFísica 
                  DTOE.numeroCampañasHistoriadevueltoFisicoFactura = numeroCampañasHistoriadevueltoFisicoFactura 
                  DTOE.oidPrecioEnvia = oidPrecioEnvia del elemento seleccionado en la cbPrecioEnvia 
                  DTOE.oidBloqueoChequeo = oidBloqueoChequeo del elemento seleccionado en la cbBloqueoChequeo 
                  DTOE.faltanteMercaderia = faltanteMercaderia 
                  DTOE.ingresaEnvia = ingresaEnvia 
                  DTOE.oidTipoSolicitud1 = oidTipoSolicitud1 del elemento seleccionado en la cbTipoSolicitud1 
                  DTOE.oidTipoSolicitud2 = oidTipoSolicitud2 del elemento seleccionado en la cbTipoSolicitud2 
                  DTOE.oidMensajeGenerar = oidMensajeGenerar del elemento seleccionado en la cbMensajeGenerar 
                  DTOE.enviaGeneraDevuelve = enviaGeneraDevuelve 
                  DTOE.ingresaDevuelve = ingresaDevuelve 
                  DTOE.oidTipoSolicitudGenera = oidTipoSolicitudGenera del elemento seleccionado en la cbTipoSolicitudGenera 
                  DTOE.oidAlmacen = oidAlmacen del elemento seleccionado en la cbAlmacen 
                  DTOE.oidMovimientoAlmacen = oidMovimientoAlmacen del elemento seleccionado en la cbMovimientoAlmacen 
                  DTOE.devuelveGeneraEnvia = devuelveGeneraEnvia 
                  DTOE.ArrayListTiposOperacion = ArrayListTiposOperacion 
                  DTOE.ArrayListEliminados = ArrayListEliminados
                  */
                  traza("*** LPOperacion.crearDtoOperacion: Entrada ***");
                  DTOOperacion dto = new DTOOperacion();
                  
                  if(this.opcionMenu.equals("modificar operacion"))
                           dto.setOidOperacion(new Long(conectorParametroLimpia("oidOperacion","",true))); 
                           
                  dto.setOidPais(new Long(conectorParametroLimpia("pais","",true)));
                  dto.setOidIdioma(new Long(conectorParametroLimpia("idioma","",true)));
                  
                  dto.setCodOperacion(conectorParametroLimpia("txtCodigoOperacion","",true));
                  dto.setDescripcionCorta(conectorParametroLimpia("txtDescripcionCorta","",true));
                  dto.setDescripcionLarga(conectorParametroLimpia("txtDescripcionLarga","",true));
                  dto.setOidPrecios(new Long(conectorParametroLimpia("cbPrecios","",true)));
                  if (!conectorParametroLimpia("Anulacion", "", true).equals("")){
                           if(conectorParametroLimpia("Anulacion", "", true).equals("S")){
                  dto.setAnulacion(new Boolean(true) );
             }else{
                  dto.setAnulacion(new Boolean(false) );
             }
         }
         if (!conectorParametroLimpia("Perdida", "", true).equals("")){
                           if(conectorParametroLimpia("Perdida", "", true).equals("S")){
                  dto.setPerdida(new Boolean(true) );
             }else{
                  dto.setPerdida(new Boolean(false) );
             }
         }
         if (!conectorParametroLimpia("cbTipoSolicitudPerdida", "", true).equals("")){
                  dto.setOidTIpoSolicitudPerdida(new Long(conectorParametroLimpia("cbTipoSolicitudPerdida", "", true)));
         }
         if (!conectorParametroLimpia("EsperarMercanciaFisica", "", true).equals("")){
                           if(conectorParametroLimpia("EsperarMercanciaFisica", "", true).equals("S")){
                  dto.setEsperarMercaderiaFisica(new Boolean(true) );
             }else{
                  dto.setEsperarMercaderiaFisica(new Boolean(false) );
             }
         }
         if (!conectorParametroLimpia("DevueltoFisicoFactura", "", true).equals("")){
                           if(conectorParametroLimpia("DevueltoFisicoFactura", "", true).equals("S")){
                  dto.setDevueltoFisicoFactura(new Boolean(true) );
             }else{
                  dto.setDevueltoFisicoFactura(new Boolean(false) );
             }
         }
         if (!conectorParametroLimpia("txtNumeroCampanas", "", true).equals("")){
                  dto.setNumeroCampaniasHistoria(new Integer(conectorParametroLimpia("txtNumeroCampanas", "", true)));
         }
         if (!conectorParametroLimpia("cbPrecioEnvia", "", true).equals("")){
                  dto.setOidPrecioEnvia(new Long(conectorParametroLimpia("cbPrecioEnvia", "", true)));
         }
                  if (!conectorParametroLimpia("cbBloqueoChequeo", "", true).equals("")){
                  dto.setOidBloqueoChequeo(new Long(conectorParametroLimpia("cbBloqueoChequeo", "", true)));
         }
                  if (!conectorParametroLimpia("FaltanteMercaderia", "", true).equals("")){
                           if(conectorParametroLimpia("FaltanteMercaderia", "", true).equals("S")){
                  dto.setFaltanteMercaderia(new Boolean(true) );
             }else{
                  dto.setFaltanteMercaderia(new Boolean(false) );
             }
         }
         if (!conectorParametroLimpia("IngresaEnvia", "", true).equals("")){
                           if(conectorParametroLimpia("IngresaEnvia", "", true).equals("S")){
                  dto.setIngresaEnvia(new Boolean(true) );
             }else{
                  dto.setIngresaEnvia(new Boolean(false) );
             }
         }
         //traza("cbTipoSolicitud1: " + conectorParametroLimpia("cbTipoSolicitud1", "", true));
         if (!conectorParametroLimpia("cbTipoSolicitud1", "", true).equals("")){
                  dto.setOidTipoSolicitud1(new Long(conectorParametroLimpia("cbTipoSolicitud1", "", true)));
         }
         if (!conectorParametroLimpia("cbTipoSolicitud2", "", true).equals("")){
                  dto.setOidTipoSolicitud2(new Long(conectorParametroLimpia("cbTipoSolicitud2", "", true)));
         }
         if (!conectorParametroLimpia("cbCodigoMensajeGenerar", "", true).equals("")){
                  dto.setOidMensajeGenerar(new Long(conectorParametroLimpia("cbCodigoMensajeGenerar", "", true)));
         }
         if (!conectorParametroLimpia("enviaGeneraDevuelve", "", true).equals("")){
                           if(conectorParametroLimpia("enviaGeneraDevuelve", "", true).equals("S")){
                  dto.setEnviaGeneraDevuelve(new Boolean(true) );
             }else{
                  dto.setEnviaGeneraDevuelve(new Boolean(false) );
             }
         }
         if (!conectorParametroLimpia("IngresaDevuelve", "", true).equals("")){
                           if(conectorParametroLimpia("IngresaDevuelve", "", true).equals("S")){
                  dto.setIngresaDevuelve(new Boolean(true) );
             }else{
                  dto.setIngresaDevuelve(new Boolean(false) );
             }
         }
         if (!conectorParametroLimpia("cbTipoSolicitudGenera", "", true).equals("")){
                  dto.setOidTipoSolicitudGenera(new Long(conectorParametroLimpia("cbTipoSolicitudGenera", "", true)));
         }
                  if (!conectorParametroLimpia("cbAlmacen", "", true).equals("")){
                  dto.setOidAlmacen(new Long(conectorParametroLimpia("cbAlmacen", "", true)));
         }
                  if (!conectorParametroLimpia("cbMovimientoAlmacen", "", true).equals("")){
                  dto.setOidMovimientoAlmacen(new Long(conectorParametroLimpia("cbMovimientoAlmacen", "", true)));
         }
                  if (!conectorParametroLimpia("DevuelveGeneraEnvia", "", true).equals("")){
                           if(conectorParametroLimpia("DevuelveGeneraEnvia", "", true).equals("S")){
                  dto.setDevuelveGeneraEnvia(new Boolean(true) );
             }else{
                  dto.setDevuelveGeneraEnvia(new Boolean(false) );
             }
         }
                  
         //vbongiov -- GCC-COL-REC-001-- 17/12/2007         
         String cbTipoSolicitudRecojoInicial = conectorParametroLimpia("cbTipoSolicitudRecojoInicial", "", true);    
         String cbTipoSolicitudPrimerRecojoNoExitoso = conectorParametroLimpia("cbTipoSolicitudPrimerRecojoNoExitoso", "", true);
         String cbTipoSolicitudSegundoRecojoNoExitoso = conectorParametroLimpia("cbTipoSolicitudSegundoRecojoNoExitoso", "", true);
         String cbAlmacenPostVenta = conectorParametroLimpia("cbAlmacenPostVenta", "", true);
         String cbMovimientoAlmacenRecojoInicial = conectorParametroLimpia("cbMovimientoAlmacenRecojoInicial", "", true);
         String cbMovimientoAlmacenRecojoExitoso = conectorParametroLimpia("cbMovimientoAlmacenRecojoExitoso", "", true);
         String cbMovimientoAlmacenRecojoNoExitoso = conectorParametroLimpia("cbMovimientoAlmacenRecojoNoExitoso", "", true);
                  
         if(conectorParametroLimpia("recojo", "", true).equals("S")){
             dto.setRecojo(new Boolean(true) );
             
             dto.setOidTipoSolicitudRecojoInicial(Long.valueOf(cbTipoSolicitudRecojoInicial));
			 if (!"".equals(cbTipoSolicitudPrimerRecojoNoExitoso)) {
	             dto.setOidTipoSolicitudPrimerRecojoNoExitoso(Long.valueOf(cbTipoSolicitudPrimerRecojoNoExitoso));
			 }
			 if (!"".equals(cbTipoSolicitudSegundoRecojoNoExitoso)) {
				dto.setOidTipoSolicitudSegundoRecojoNoExitoso(Long.valueOf(cbTipoSolicitudSegundoRecojoNoExitoso));
			 }
             dto.setOidAlmacenPostVenta(Long.valueOf(cbAlmacenPostVenta));
             dto.setOidMovimientoAlmacenRecojoInicial(Long.valueOf(cbMovimientoAlmacenRecojoInicial));
             dto.setOidMovimientoAlmacenRecojoExitoso(Long.valueOf(cbMovimientoAlmacenRecojoExitoso));
             dto.setOidMovimientoAlmacenRecojoNoExitoso(Long.valueOf(cbMovimientoAlmacenRecojoNoExitoso));
             
         }else{
             dto.setRecojo(new Boolean(false) );
         }
         
         String listaTiposOp = conectorParametroLimpia("listaTiposOperaciones","",true);
         traza(" listaTiposOp: " + listaTiposOp);
         String listaEliminados = conectorParametroLimpia("listaEliminados","",true); 
         ArrayList listaTO = new ArrayList();
         
         if(!listaTiposOp.equals("")){
                  StringTokenizer st = new StringTokenizer(listaTiposOp,"#");
                  while (st.hasMoreTokens()) {
                           listaTO.add(st.nextToken());
                  }
         }
         traza(" listaTO: " + listaTO );
         // cada elemento del array es un cadena que contiene los valores de una fila
         dto.setArrayListTiposOperacion(listaTO); // contenido de la lista de la pagina de tipos operacion.
         
         ArrayList eliminados = new ArrayList();
         if(!listaEliminados.equals("")){
                  StringTokenizer st2 = new StringTokenizer(listaEliminados,",");
                  while (st2.hasMoreTokens()) {
                           eliminados.add(st2.nextToken());
                  }
         }
         dto.setArrayListEliminados(eliminados); // oids que se eliminan de tipos de operacion.
         
         //recogemos las descripciones i18n
         Vector vIdiomas = this.recuperaTraduccionesI18N(new Integer(1));         
         traza("*** vIdiomas = "+vIdiomas);
         
         //comprobacion por si hay problemas con el 1er atributo que a veces viene null si se han 
         //modificado descripciones en la pagina de tipos de operacion.
         
         ((DTOI18nSICC)vIdiomas.get(0)).setValorI18n(dto.getDescripcionCorta());
         
         dto.setAttriTraducible(vIdiomas);
         
                           
                  traza("*** LPOperacion.crearDtoOperacion: Salida ***");
                  traza("dto: " + dto);
                  
                  return dto;
         }
         
         public void insertModif() throws Exception{ 

                  traza("*** LPOperacion.insertModif: Entrada ***");
                  pagina("salidaGenerica");
                  asignar("VAR","cerrarVentana","false");
                  
                  if(this.opcionMenu.equals("crear operacion")){
                           /*
                           Si opcionMenu="crear operacion" {  
                           Llama al metodo insertarOperacion() 
                           } */
                           this.insertarOperacion();
                           traza("*** Despues de insertar ***");
                           asignarAtributo("VAR", "ejecutar", "valor", "insercionCorrecta()");
                           traza("*** Despues de llamar a insercionCorrecta ***");
                           
                  }else if(this.opcionMenu.equals("modificar operacion")){
                             	 /*Si opcionMenu="modificar operacion" { 
                                     Llama al metodo modificarOperacion() 
                                 }*/
                             	 this.modificarOperacion();
                             	 asignarAtributo("VAR", "ejecutar", "valor", "modificacionCorrecta()"); 
                             }
                  traza("*** LPOperacion.insertModif: Salida ***"); 
                             
         }
         
         public void detalleOperacion() throws Exception{ 

         /*Crear un DTOE del tipo DTOOid con el oidOperacion recibido de la pantallaBuscarOperaciones 
                  Invocar al conector ConectorDetalleOperaciones con el DTOE 
                  Crear IDBusiness="RECDetalleOperaciones" 
                  Obtiene DTOOperacion 
                  */
                  traza("*** LPOperacion.detalleOperacion: Entrada ***");
                  DTOOID dtoE = new DTOOID();
                  dtoE.setOidPais(this.pais);
                  dtoE.setOidIdioma(this.idioma);
                  traza(" *** Oid = "+ conectorParametroLimpia("oidOperacion", "", true));
                  this.opcionMenu = conectorParametroLimpia("opcionMenu", "", true);
                  dtoE.setOid(new Long(conectorParametroLimpia("oidOperacion", "", true)));

                  Vector paramConector = new Vector();
                  paramConector.add(dtoE);
                  paramConector.add(new MareBusinessID("RECDetalleOperaciones"));            
                  traza("Antes de Conectar ConectorDetalleOperaciones");
                  DruidaConector conector = conectar("ConectorDetalleOperaciones", paramConector);							
                  traza("Despues de Conectar ConectorDetalleOperaciones");
                  
                  Object objeto=conector.objeto("DTOOperacion");
                  traza("Objeto recogido"+objeto);
                  DTOOperacion dtoOp = (DTOOperacion)conector.objeto("DTOOperacion");
                  traza("DTOOperacion obtenido");
                  
                  //Llama al método mostrarPgOperacion() pasandole este DTOOperacion 
                  this.mostrarPgOperacion(dtoOp);
                  traza("*** LPOperacion.detalleOperacion: Salida ***");
         }
         
         private void rellenarPagina(DTOOperacion dtoE) throws Exception{
         
                  traza("*** LPOperacion.rellenarPagina: Entrada ***");
                  
                  asignar("CTEXTO","txtCodigoOperacion",dtoE.getCodOperacion());
                  asignar("CTEXTO","txtDescripcionCorta",dtoE.getDescripcionCorta());
                  if(dtoE.getDescripcionLarga() != null)
                           asignar("CTEXTO","txtDescripcionLarga",dtoE.getDescripcionLarga());
                  
                  asignar("VAR","oidPrecios",dtoE.getOidPrecios().toString());
                  
                  if(dtoE.getAnulacion().booleanValue()){
                           asignarAtributo("CHECKBOX","Anulacion","check","S");
                           asignarAtributo("VAR","anulacion","valor","S");
                  }else{
                           asignarAtributo("CHECKBOX","Anulacion","check","N"); 
                           asignarAtributo("VAR","anulacion","valor","N");
                  }
                  if(dtoE.getPerdida() != null){
                           if(dtoE.getPerdida().booleanValue()){
                                    asignarAtributo("CHECKBOX","Perdida","check","S");
                                    asignarAtributo("VAR","perdida","valor","S");
                           }else{
                                    asignarAtributo("CHECKBOX","Perdida","check","N");
                                    asignarAtributo("VAR","perdida","valor","N");
                                    asignarAtributoElemento("cbTipoSolicitudPerdida","disabled","S");
                           }
                  }
                  if(dtoE.getOidTIpoSolicitudPerdida()!=null)
                           asignar("VAR","oidTipoSolicitudPerdida",dtoE.getOidTIpoSolicitudPerdida().toString());
                  
                  if(dtoE.getEsperarMercaderiaFisica() != null){
                           if(dtoE.getEsperarMercaderiaFisica().booleanValue()){
                                    asignarAtributo("CHECKBOX","EsperarMercanciaFisica","check","S");
                                    asignarAtributo("VAR","esperarMercanciaFisica","valor","S");
                           }else{
                                    asignarAtributo("CHECKBOX","EsperarMercanciaFisica","check","N");
                                    asignarAtributo("VAR","esperarMercanciaFisica","valor","N");
                           }
         }
                  if(dtoE.getDevueltoFisicoFactura() != null){
                           if(dtoE.getDevueltoFisicoFactura().booleanValue()){
                                    asignarAtributo("CHECKBOX","DevueltoFisicoFactura","check","S");
                                    asignarAtributo("VAR","devueltoFisicoFactura","valor","S");
                           }else{
                                    asignarAtributo("CHECKBOX","DevueltoFisicoFactura","check","N");
                                    asignarAtributo("VAR","devueltoFisicoFactura","valor","N");
                           }
                  }
                  if(dtoE.getNumeroCampaniasHistoria() != null)
                           asignar("CTEXTO","txtNumeroCampanas",dtoE.getNumeroCampaniasHistoria().toString());
                  if(dtoE.getOidPrecioEnvia() != null)
                           asignar("VAR","oidPrecioEnvia",dtoE.getOidPrecioEnvia().toString());
                  
                  if(dtoE.getOidBloqueoChequeo() != null)
                           asignar("VAR","oidBloqueoChequeo",dtoE.getOidBloqueoChequeo().toString());
                  
                  if(dtoE.getFaltanteMercaderia() != null){
                           if(dtoE.getFaltanteMercaderia().booleanValue()){
                                    asignarAtributo("CHECKBOX","FaltanteMercaderia","check","S");
                                    asignarAtributo("VAR","faltanteMercaderia","valor","S");
                           }else{
                                    asignarAtributo("CHECKBOX","FaltanteMercaderia","check","N");
                                    asignarAtributo("VAR","faltanteMercaderia","valor","N");
                           }
                  }
                  if(dtoE.getIngresaEnvia() != null){
                           if(dtoE.getIngresaEnvia().booleanValue()){
                                    asignarAtributo("CHECKBOX","IngresaEnvia","check","S");
                                    asignarAtributo("VAR","ingresaEnvia","valor","S");
                           }else{
                                    asignarAtributo("CHECKBOX","IngresaEnvia","check","N");
                                    asignarAtributo("VAR","ingresaEnvia","valor","N");
                           }
                  }	
                  if(dtoE.getOidTipoSolicitud1() != null)
                           asignar("VAR","oidTipoSolicitud1",dtoE.getOidTipoSolicitud1().toString());
                  
                  if(dtoE.getOidTipoSolicitud2() != null)
                           asignar("VAR","oidTipoSolicitud2",dtoE.getOidTipoSolicitud2().toString());
                  
                  if(dtoE.getOidMensajeGenerar() != null)
                           asignar("VAR","oidCodigoMensajeGenerar",dtoE.getOidMensajeGenerar().toString());
                  
                  if(dtoE.getEnviaGeneraDevuelve() != null){
                           if(dtoE.getEnviaGeneraDevuelve().booleanValue()){
                                    asignarAtributo("CHECKBOX","EnviaGeneraDevuelve","check","S");
                                    asignarAtributo("VAR","enviaGeneraDevuelve","valor","S");
                           }else{
                                    asignarAtributo("CHECKBOX","EnviaGeneraDevuelve","check","N");
                                    asignarAtributo("VAR","enviaGeneraDevuelve","valor","N");
                           }
                  }
                  if(dtoE.getIngresaDevuelve() != null){
                           if(dtoE.getIngresaDevuelve().booleanValue()){
                                    asignarAtributo("CHECKBOX","IngresaDevuelve","check","S");
                                    asignarAtributo("VAR","ingresaDevuelve","valor","S");
                           }else{
                                    asignarAtributo("CHECKBOX","IngresaDevuelve","check","N");
                                    asignarAtributo("VAR","ingresaDevuelve","valor","N");
                           }
                   }
                  if(dtoE.getOidTipoSolicitudGenera() != null)
                           asignar("VAR","oidTipoSolicitudGenera",dtoE.getOidTipoSolicitudGenera().toString());
                  
                  if(dtoE.getOidAlmacen() != null)			
                           asignar("VAR","oidAlmacen",dtoE.getOidAlmacen().toString());
                  
                  if(dtoE.getOidMovimientoAlmacen() != null)
                           asignar("VAR","oidMovimientoAlmacen",dtoE.getOidMovimientoAlmacen().toString());
                  
                  if(dtoE.getDevuelveGeneraEnvia() != null){
                           if(dtoE.getDevuelveGeneraEnvia().booleanValue()){
                                    asignarAtributo("CHECKBOX","DevuelveGeneraEnvia","check","S");
                                    asignarAtributo("VAR","devuelveGeneraEnvia","valor","S");
                           }else{
                                    asignarAtributo("CHECKBOX","DevuelveGeneraEnvia","check","N");
                                    asignarAtributo("VAR","devuelveGeneraEnvia","valor","N");
                           }
                  }
    
    //vbongiov -- GCC-COL-REC-001-- 17/12/2007   
    if(dtoE.getRecojo().booleanValue()){
                                    asignarAtributo("CHECKBOX","recojo","check","S");
         asignar("VAR","hRecojo","S");
    }else{
         asignarAtributo("CHECKBOX","recojo","check","N");
         asignar("VAR","hRecojo","N");
    }
    
    if(dtoE.getOidTipoSolicitudRecojoInicial() != null)
                           asignar("VAR","hOidTipoSolicitudRecojoInicial",dtoE.getOidTipoSolicitudRecojoInicial().toString());
      
    if(dtoE.getOidTipoSolicitudPrimerRecojoNoExitoso() != null)
                           asignar("VAR","hOidTipoSolicitudPrimerRecojoNoExitoso",dtoE.getOidTipoSolicitudPrimerRecojoNoExitoso().toString());
      
    if(dtoE.getOidTipoSolicitudSegundoRecojoNoExitoso() != null)
                           asignar("VAR","hOidTipoSolicitudSegundoRecojoNoExitoso",dtoE.getOidTipoSolicitudSegundoRecojoNoExitoso().toString());
      
    if(dtoE.getOidAlmacenPostVenta() != null)
                           asignar("VAR","hOidAlmacenPostVenta",dtoE.getOidAlmacenPostVenta().toString());
      
    if(dtoE.getOidMovimientoAlmacenRecojoInicial() != null)
                           asignar("VAR","hOidMovimientoAlmacenRecojoInicial",dtoE.getOidMovimientoAlmacenRecojoInicial().toString());
      
    if(dtoE.getOidMovimientoAlmacenRecojoExitoso() != null)
                           asignar("VAR","hOidMovimientoAlmacenRecojoExitoso",dtoE.getOidMovimientoAlmacenRecojoExitoso().toString());
    
    if(dtoE.getOidMovimientoAlmacenRecojoNoExitoso() != null)
                           asignar("VAR","hOidMovimientoAlmacenRecojoNoExitoso",dtoE.getOidMovimientoAlmacenRecojoNoExitoso().toString());
    
                  traza("*** LPOperacion.rellenarPagina: Salida ***");
         }
         
         private void crearHiddensI18N(boolean cargado,Integer nroAtributoTraducible) throws Exception{
         
                  traza("*** LPOperacion.crearHiddensI18N: Entrada ***");
                  if(cargado){
             conectorParametroSesion("hEntidad_" + nroAtributoTraducible, "");
             conectorParametroSesion("hOid_" + nroAtributoTraducible, "");
             conectorParametroSesion("hCargado_" + nroAtributoTraducible, "");
             conectorParametroSesion("cargo_" + nroAtributoTraducible, "");
         }
                                    
                  Element elemento = this.getFormulario();
         Collection idiomas = getIdiomas();
         Iterator itIdiomas = idiomas.iterator();
         int cantIdiomas = idiomas.size();
         traza("Nro de Idiomas: " + cantIdiomas);
         DruidaDOMObjeto vari18NEntidad = crearOCULTO("hi18NEntidad_" + nroAtributoTraducible, "");
         vari18NEntidad.setAtributo("valor", "REC_TIPOS_OPERA");
         traza("*** Entidad = "+ conectorParametroSesion("hEntidad_"+nroAtributoTraducible));
         DruidaDOMObjeto vari18NOID = crearOCULTO("hi18NOID_" + nroAtributoTraducible, "");
         vari18NOID.setAtributo("valor", "");
         DruidaDOMObjeto vari18NCargado = crearOCULTO("hi18NCargado_" + nroAtributoTraducible, "");
         vari18NCargado.setAtributo("valor", (new Boolean(cargado)).toString());
         if(elemento != null){
                  
                  elemento.appendChild(vari18NEntidad.getXML());
             elemento.appendChild(vari18NOID.getXML());
             elemento.appendChild(vari18NCargado.getXML());
                           for(int i = 0; i < cantIdiomas; i++){
                  Idioma idioma = (Idioma)itIdiomas.next();
                  traza("*** Oid idioma ="+idioma.getOid());
                  DruidaDOMObjeto vari18NTraduccion = crearOCULTO("descripcion_" + nroAtributoTraducible + "_" + idioma.getOid(), "");
                  vari18NTraduccion.setAtributo("valor", "");
                  elemento.appendChild(vari18NTraduccion.getXML());
                  traza(vari18NTraduccion.getXML());
             }
             conectorParametroSesion("hEntidad_" + nroAtributoTraducible, "REC_TIPOS_OPERA");
             conectorParametroSesion("hCargado_" + nroAtributoTraducible, (new Boolean(cargado)).toString());
             
         }else{
                  throw new Exception("No se encontro el formulario donde colocar los atributos de i18n.");
         }
                  traza("*** LPOperacion.crearHiddensI18N: Salida ***");
         }
         
         private Element getFormulario() throws Exception{
         DOMXPath xform = new DOMXPath("//PAGINA/FORMULARIO[VAR[@nombre='conectorAction']]");
         Element formulario = (Element)xform.selectSingleNode(getXML());
         if(formulario == null){
             traza("No se encontro el formulario con el var 'conectorAction'.");
             throw new Exception("No se encontro el formulario con el var 'conectorAction'.");
         } else{
             return formulario;
         }
    }

         
         private void logStackTrace(Throwable e) throws Exception {
         traza("Se produjo la excepcion: " + e.getMessage());            
         ByteArrayOutputStream baos = new ByteArrayOutputStream();
         PrintStream ps = new PrintStream(baos);
         e.printStackTrace(ps);                    
         traza("Stack Trace: " + baos.toString());
    }            
}

