 /**
* Copyright 2004 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Vector;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.w3c.dom.NodeList;

import es.indra.druida.Contexto;
import es.indra.druida.DruidaConector;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.dtos.ccc.DTOBuscarRegistroVentas;
import es.indra.sicc.dtos.ccc.DTORegistroVentas;
import es.indra.sicc.dtos.mae.DTOBusquedaRapidaCliente;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;

public class LPMantenimientoRegistroVentas extends LPSICCBase {
          
          private String accion = null;
          private String casoUso = null;
          private Long pais;
          private Long idioma;
          
          public LPMantenimientoRegistroVentas() {
                    super();
          }

          public void inicio() throws Exception {
                    
          }
          public void ejecucion() throws Exception {
                    setTrazaFichero();
                    try  {         
                           traza("LPMantenimientoRegistroVentas Entrada");
                           this.idioma = UtilidadesSession.getIdioma(this);
                  this.pais = UtilidadesSession.getPais(this);
                  this.accion = conectorParametroLimpia("accion","", true);
                  traza("Accion definida : "+accion);
                    
             //Menú principal 
             if(this.accion.equals("TipoImpuesto")){
                  this.obtieneCoeficienteImpuesto();
             }else if(this.accion.equals("Modificar_cliente")){
             	//Añadido por incidencia 13566
             		traza("Accion Modificar cliente");
               		this.modificarCliente();
             }else if(this.accion.equals("insertar_menu_principal")){
                           //Si accion="insertar_menu_principal" 
                                             //- Mostramos (cargamos) la página: "RegistroVentas" 
                                             //- Desactivamos la opción "Volver" del menú secundario 
                      this.casoUso = "insertar"; 
                      pagina("contenido_registro_ventas_insertar");

                    		asignar("VAR", "idioma", idioma.toString());
                    		traza("->Idioma : "+idioma);
                    		asignar("VAR", "pais", pais.toString());	
                    		traza("->Pais : "+pais);
                    			asignar("VAR", "casoUso", "insertar");
                                    
                                             // Fecha:
                                             this.generarHiddenFormatoFecha();
                                             
                                             //SimpleDateFormat formateador = new SimpleDateFormat (UtilidadesSession.getFormatoFecha(this));
                                             //String fecha = formateador.format(new Date(System.currentTimeMillis()));
                                    
                                             String formatoFecha = UtilidadesSession.getFormatoFecha(this);
                                             String fecha = UtilidadesBelcorp.fechaFormateada(new Date(System.currentTimeMillis()), formatoFecha);
                                             asignarAtributoElemento("txtFechaEmision","valor", fecha );
                                    
                           // Numeros:
                           String separadorDecimales = UtilidadesSession.getSeparadorDecimales(this);
                                             String separadorMiles = ",";
                                             if (separadorDecimales.equals(",")) {
                                                      separadorMiles = ".";
                                             }
                                             asignar("VAR","hid_SeparadorMiles", separadorMiles);
                                             asignar("VAR","hid_NumeroDecimales",UtilidadesSession.getFormatoNumerico(this));
                                             asignar("VAR","hid_SeparadorDecimales", separadorDecimales);
                                             
                                             Byte longitudCodigoCliente = obtenerLongitudCodigoCliente();
                           	         asignar("VAR","numDigitosCodigoCliente", longitudCodigoCliente.toString());
                           
                                             
                                             traza("Separador de decimales: "+separadorDecimales);
                                             traza("Separador de decimales: "+separadorMiles);
                           
                    			asignarAtributo("PAGINA","contenido_registro_ventas_insertar", "cod", "0783");
                    		asignarAtributo("PAGINA","contenido_registro_ventas_insertar", "msgle", "Insertar Registro Ventas");
                    		
                    		getConfiguracionMenu("LPMantenimientoRegistroVentas","Insertar");
                           }else if(this.accion.equals("consultar_menu_principal")){
                                    //Si accion="consultar_menu_principal"  
                                                      //- Mostramos (cargamos) la página: "BusquedaRegistroVentas" 
                                                      //- Desactivamos la opción "Eliminar" del menú secundario 
                                                      //- Desactivamos el botón "Modificar" 
                                                      //- Activamos el botón "Detalle" 
                           this.casoUso = "consultar"; 
                           pagina("contenido_registro_ventas_modificar");

                    			asignar("VAR", "idioma", idioma.toString());
                    			traza("->Idioma : "+idioma);
                    			asignar("VAR", "pais", pais.toString());	
                    			traza("->Pais : "+pais);
                    				asignar("VAR", "casoUso", "consultar");

                                                      // Fecha:
                                                      this.generarHiddenFormatoFecha();

                                // Numeros:
                                String separadorDecimales = UtilidadesSession.getSeparadorDecimales(this);
                                                      String separadorMiles = ",";
                                                      if (separadorDecimales.equals(",")) {
                                                                separadorMiles = ".";
                                                      }
                                                      asignar("VAR","hid_SeparadorMiles", separadorMiles);
                                                      asignar("VAR","hid_NumeroDecimales",UtilidadesSession.getFormatoNumerico(this));
                                                      asignar("VAR","hid_SeparadorDecimales", separadorDecimales);
                           
                                                      Byte longitudCodigoCliente = obtenerLongitudCodigoCliente();
                         		         asignar("VAR","numDigitosCodigoCliente", longitudCodigoCliente.toString());
                           
                    				asignarAtributo("PAGINA","contenido_registro_ventas_modificar", "cod", "0786");
                    			asignarAtributo("PAGINA","contenido_registro_ventas_modificar", "msgle", "Buscar Registro Ventas");
                    			getConfiguracionMenu("LPMantenimientoRegistroVentas","Consultar");
                   }else if(this.accion.equals("modificar_menu_principal")){
                                                      //Si accion="modificar_menu_principal" 
                                                      //- Mostramos (cargamos) la página: "BusquedaRegistroVentas" 
                                                      //- Desactivamos la opción "Eliminar" del menú secundario 
                                                      //- Desactivamos el botón "Detalle" 
                                                      //- Activamos el botón Modificar 
                           this.casoUso = "modificar";
                           pagina("contenido_registro_ventas_modificar");
                    		
                    			asignar("VAR", "idioma", idioma.toString());
                    			traza("->Idioma : "+idioma);
                    			asignar("VAR", "pais", pais.toString());	
                    			traza("->Pais : "+pais);
                    				asignar("VAR", "casoUso", "modificar");

                                                      // Fecha:
                                                      this.generarHiddenFormatoFecha();
                                    
                                // Numeros:
                                String separadorDecimales = UtilidadesSession.getSeparadorDecimales(this);
                                                      String separadorMiles = ",";
                                                      if (separadorDecimales.equals(",")) {
                                                                separadorMiles = ".";
                                                      }
                                                      asignar("VAR","hid_SeparadorMiles", separadorMiles);
                                                      asignar("VAR","hid_NumeroDecimales",UtilidadesSession.getFormatoNumerico(this));
                                                      asignar("VAR","hid_SeparadorDecimales", separadorDecimales);
                                    
                                                      Byte longitudCodigoCliente = obtenerLongitudCodigoCliente();
                           		asignar("VAR","numDigitosCodigoCliente", longitudCodigoCliente.toString());
                                                      
                    				asignarAtributo("PAGINA","contenido_registro_ventas_modificar", "cod", "0784");
                    			asignarAtributo("PAGINA","contenido_registro_ventas_modificar", "msgle", "Modificar Registro Ventas");
                    			getConfiguracionMenu("LPMantenimientoRegistroVentas","Modificar");
                                    }else if(this.accion.equals("eliminar_menu_principal")){
                                    //Si accion="eliminar_menu_principal" 
                                                                //- Mostramos (cargamos) la página: "BusquedaRegistroVentas" 
                                                                //- Activamos la opción "Eliminar" del menú secundario 
                                                                //- Desactivamos el botón "Modificar" 
                                                                //- Activamos el botón "Detalle" 
                                this.casoUso = "eliminar";
                                pagina("contenido_registro_ventas_modificar");

                    				asignar("VAR", "idioma", idioma.toString());
                    				traza("->Idioma : "+idioma);
                    				asignar("VAR", "pais", pais.toString());	
                    				traza("->Pais : "+pais);
                    					asignar("VAR", "casoUso", "eliminar");
                    		
                                    // Fecha:
                                                                this.generarHiddenFormatoFecha();
                                    
                                    // Numeros:
                                    String separadorDecimales = UtilidadesSession.getSeparadorDecimales(this);
                                                                String separadorMiles = ",";
                                                                if (separadorDecimales.equals(",")) {
                                                                         separadorMiles = ".";
                                                                }
                                                                asignar("VAR","hid_SeparadorMiles", separadorMiles);
                                                                asignar("VAR","hid_NumeroDecimales",UtilidadesSession.getFormatoNumerico(this));
                                                                asignar("VAR","hid_SeparadorDecimales", separadorDecimales);
                                             
                                                                Byte longitudCodigoCliente = obtenerLongitudCodigoCliente();
                                    	asignar("VAR","numDigitosCodigoCliente", longitudCodigoCliente.toString());
                    		
                    					asignarAtributo("PAGINA","contenido_registro_ventas_modificar", "cod", "0785");
                    				asignarAtributo("PAGINA","contenido_registro_ventas_modificar", "msgle", "Eliminar Registro Ventas");
                    				getConfiguracionMenu("LPMantenimientoRegistroVentas","Eliminar");
                           }


                           //Menú Secundario
                           if(this.accion.equals("guardar_menu_sec")){     
                                    traza("accion guardar del menu secundario");
                                    //Si accion="guardar_menu_sec" 
                                    //Cargamos el DTORegistroVentas con los datos de la pantalla "RegistroVentas" 
                                    //-Llamamos al conector "ConectorGuardarRegistroVentas" pasándole los parámetros: 
                                    //idBusiness="CCCGuardarRegistroVentas" 
                                    //DTORegistroVentas 
             			try{
             				pagina("salidaGenerica");
             				traza("Salida Generica");
             				this.casoUso = conectorParametroLimpia("casoUso","", true);
             				traza("CU: "+this.casoUso);
             				asignar("VAR", "cerrarVentana", "false");
                                             DTORegistroVentas dtor = new DTORegistroVentas();
                                             dtor.setOidPais(this.pais);
											 traza("pais: " + pais);
                                             dtor.setOidIdioma(this.idioma);
                                             
                                             // Datos del DTO
                                             traza("Antes de comprobar el CU");
                                             if (this.casoUso.equals("modificar")){
                                                      traza("----> CASO DE USO MODIFICAR <----- ");
                                                      traza("Oid a modificar: "+conectorParametroLimpia("oidSeleccionado", "", true));
                                                      dtor.setOidReg(new Long(conectorParametroLimpia("oidSeleccionado", "", true)));
                                             }
                                             traza("Despues de comprobar el CU");
                                             //Empresa
                                             dtor.setOidEmpresa(new Long(conectorParametroLimpia("cbEmpresa", "", true)));
                                             
                                             //Tipo Impuesto
                                             dtor.setOidIndImpuestos(new Long(conectorParametroLimpia("cbTipoImpuesto", "", true)));
                                             
                                             //Fecha Emision
                                             String fecha = conectorParametroLimpia("txtFechaEmision","",true);
                           
                                             //SimpleDateFormat formateador = new SimpleDateFormat ("dd/MM/yyyy");
                                             //ParsePosition pos = new ParsePosition(0);
                                             //Date fechaCierre = formateador.parse(fecha,pos);
                                             traza("Formato de fecha: "+ UtilidadesSession.getFormatoFecha(this));
                                             Date fechaCierre = UtilidadesBelcorp.getDatefromSICCStringFormat(fecha, UtilidadesSession.getFormatoFecha(this)); 
                                             traza("Fecha de cierre: "+fechaCierre);
                                             dtor.setFechaEmision(fechaCierre);
                                             
                                             traza("1");
                                             //Codigo Cliente
                                             dtor.setCodigoCliente(new String(conectorParametroLimpia("txtCodCliente", "", true)));

                                             traza("2");	
                                             //nombre1
                                             dtor.setNombre1(new String(conectorParametroLimpia("txtNombre1", "", true)));

                                             traza("3");	
                                             //Nombre2  incidencia 13371
                                             if (!conectorParametroLimpia("txtNombre2", "", true).equals("null")){
                                             		dtor.setNombre2(new String(conectorParametroLimpia("txtNombre2", "", true)));
					     }
                                             traza("4");	
                                             //Apellido1
                                             dtor.setApellido1(new String(conectorParametroLimpia("txtApellido1", "", true)));

                                             traza("5");	
                                             //Apellido2
                                             dtor.setApellido2(new String(conectorParametroLimpia("txtApellido2", "", true)));

                                             traza("6: " + conectorParametroLimpia("baseSinFormato", "", true));	
                                             //Base imponible
                                             dtor.setBaseImponible(new BigDecimal(conectorParametroLimpia("txtBaseImponible", "", true)));
                                             
                                             traza("7a");	
                                             traza("7: " + conectorParametroLimpia("importeSinFormato", "", true));	
                                             traza("7b");	
                                             //Importe impuesto
                                             dtor.setImporteImpuesto(new BigDecimal(conectorParametroLimpia("importeSinFormato", "", true)));
                                             
                                             traza("8a");	
                                             traza("8" + conectorParametroLimpia("totalSinFormato", "", true));
                                             traza("8b");	
                                             //Importe Total
                                             dtor.setImporteTotal(new BigDecimal(conectorParametroLimpia("totalSinFormato", "", true)));
                                             //dtor.setImporteTotal(new BigDecimal(conectorParametroLimpia("lbldtImporteTotal", "", true)));
 											 dtor.setCoeficienteImpuesto(new BigDecimal(conectorParametroLimpia("coeficienteImp", "", true)));
 											 traza("8c" + conectorParametroLimpia("coeficienteImp", "", true));
 											 
		 									 
                                             traza("9");	
                                             //OidSubAcceso
                                             if (!conectorParametroLimpia("cbSubacceso", "", true).equals("")){
                                                      dtor.setOidSubAcceso(new Long(conectorParametroLimpia("cbSubacceso", "", true)));
                                             }

                                             traza("0");	
                                             //Punto Emision
                                             if (!conectorParametroLimpia("txtPuntoEmision", "", true).equals("")){
                                                      dtor.setPuntoEmision(new String(conectorParametroLimpia("txtPuntoEmision", "", true)));
                                             }
                                             
                                             traza("1");	
                                             //Tipo documento Legal
                                             dtor.setOidTipoDocumentoLegal(new Long(conectorParametroLimpia("cbTipoDocLegal", "", true)));

                                             traza("2");	
                                             //Serie Documento Legal
                                             dtor.setSerieDocumentoLegal(new String(conectorParametroLimpia("txtSerieDocLegal", "", true)));

                                             traza("3");						
                                             //Numero Documento Legal
                                             //cambiado por incidencia 15038
                                             //dtor.setNumeroDocumentoLegal(new Integer(conectorParametroLimpia("txtNumDocLegal", "", true)));
                                             dtor.setNumeroDocumentoLegal(new String(conectorParametroLimpia("txtNumDocLegal", "", true)));

                                             traza("4");	
                                             //Numero identificacion fiscal
                                             if(!conectorParametroLimpia("txtNumIdentificaionFiscal", "", true).equals("")){
													 dtor.setNumeroIdentificacionFiscal(new String(conectorParametroLimpia("txtNumIdentificaionFiscal", "", true)));
                                             } 
                                             traza("5");	
                                             //Numero identificacion Nacional
                                             if (!conectorParametroLimpia("txtNumIdentificaionNacional", "", true).equals("")){
                                                      dtor.setNumeroIdentificacionNacional(new String(conectorParametroLimpia("txtNumIdentificaionNacional", "", true)));
                                             }

                                             traza("6");						
                                             //tipo documento ref
                                             if (!conectorParametroLimpia("cbTipoDocLegalReferencia", "", true).equals("")){
                                                      dtor.setOidTipoDocumentoRef(new Long(conectorParametroLimpia("cbTipoDocLegalReferencia", "", true)));
                                             }

                                             traza("7");	
                                             //Serie documento ref
                                             if (!conectorParametroLimpia("txtSerieDocReferencia", "", true).equals("null")){
                                                      dtor.setSerieDocumentoRef(new String(conectorParametroLimpia("txtSerieDocReferencia", "", true)));
                                             }	

                                             traza("8");	
                                             //Numero Documento ref
                                             if (!conectorParametroLimpia("txtNumDocReferencia", "", true).equals("")){
                                                      //cambiado por incidencia 15038
                                                      //dtor.setNumeroDocumentoRef(new Integer(conectorParametroLimpia("txtNumDocReferencia", "", true)));
                                                      dtor.setNumeroDocumentoRef(new String(conectorParametroLimpia("txtNumDocReferencia", "", true)));
                                             }
                                             
                                             traza("9");	
                                             //Estado
                                             if(conectorParametroLimpia("ckEstadoAnulado", "", true).equals("S")){
                                                      dtor.setEstadoAnulado(new Boolean(true) );//Bool
                                             }else{
                                                      dtor.setEstadoAnulado(new Boolean(false) );//Bool
                                             }
											 traza("10 " + conectorParametroLimpia("descuentoSinFormato","", true));
                                             String descuento = conectorParametroLimpia("descuentoSinFormato","", true);
											 traza("descuento: " + descuento);
											 dtor.setDescuento(new BigDecimal(descuento));
											 traza("11");
											 String baseImponibleNeto = conectorParametroLimpia("baseSinFormato","", true);
											 dtor.setBaseImponibleNeto(new BigDecimal(baseImponibleNeto));
											 String numDocLegalFinal = conectorParametroLimpia("txtNumDocLegalFinal","", true);
											 if(!numDocLegalFinal.equals("")){
											    dtor.setNumeroDocumentoLegalFinal(new String(numDocLegalFinal));
											 }

                                             traza("0");	
                                             //Estado RUV
                                             dtor.setEstadoRUV(new String(conectorParametroLimpia("estadoRUV", "", true)));

                                             traza("1");	
                                             //Indicador Transferencia gratuita
                                             if(conectorParametroLimpia("ckIndicadorTransferenciaGratuita", "", true).equals("S")){
                                             	traza("2a");	
                                                      dtor.setIndTransfGratuita(new Boolean(true));
                                             }else{
                                                      traza("2b");	
                                                      dtor.setIndTransfGratuita(new Boolean(false));
                                             }
                                             
                                             //sapaza -- PER-SiCC-2010-0487 -- 16/08/2010
                                             traza("sa 1");	
                                             //Tipo documento
                                             if (!conectorParametroLimpia("cbTipoDocSigla", "", true).equals("")){
                                                      dtor.setOidTipoDocumento(new Long(conectorParametroLimpia("cbTipoDocSigla", "", true)));
                                             }
                                             traza("sa 2");	
                                             //Fecha Emision Referencia
                                             String fechaEmisionReferencia = conectorParametroLimpia("txtFechaEmisionReferencia","",true);
                                             if(!fechaEmisionReferencia.equals("")){
                                            	 Date fechaEmisionAux = UtilidadesBelcorp.getDatefromSICCStringFormat(fechaEmisionReferencia, UtilidadesSession.getFormatoFecha(this));
                                            	 traza("Fecha de emision referencia: "+fechaEmisionAux);
                                            	 dtor.setFechaEmisionReferencia(fechaEmisionAux);
                                             }	 
                                             
                                             //SB MODIFICADO
                                             traza("sb Modificaciones modulo RUV  ");

                                             String numDocControl = conectorParametroLimpia("txtNumDocControl","", true);
											 if(!numDocControl.equals("")){
											    dtor.setNumDocControlLegal(new String(numDocControl));
											 }                                             
                                             
                                            
                                             traza("3");	
                                             traza("DTO A ENVIAR: "+ dtor );
                                             traza("base sin formato: " + conectorParametroLimpia("baseSinFormato", "", true));

                                           
                                             
                                             
                                             if (this.casoUso.equals("modificar")){
                                                      traza("----> CASO DE USO MODIFICAR <----- ");
                                                      try{
														
														 Vector paramConector = new Vector();
														 paramConector.add(dtor);            
														 traza("DTO GUARDADO");
														 //IdNegocio = "CCCGuardarRegistroVentas" 
														 paramConector.add(new MareBusinessID("CCCModificarRegistroVentas"));          
														 traza("IDBUSINESS GUARDADO");
														 //Se invoca el conector ConectorGuardarRegistroVentas 
														 traza("Antes de Conectar ConectorModificarRegistroVentas");
														 DruidaConector conector = conectar("ConectorModificarRegistroVentas", paramConector);
														 traza("Despues de Conectar ConectorModificarRegistroVentas");	
                                                         asignarAtributo("VAR", "ejecutar", "valor", "inserccionCorrecta()");
													  
													  }catch(Exception e){
													  
														e.printStackTrace();
														this.logStackTrace(e);
													    // lanzarPaginaError(e);
														throw e;			 
													  
												    }

                                             }else{
                                                      traza("----> CASO DE USO Insertar <----- ");
													 try{
														 Vector paramConector = new Vector();
														 paramConector.add(dtor);            
														 traza("DTO GUARDADO");
														 //IdNegocio = "CCCGuardarRegistroVentas" 
														 paramConector.add(new MareBusinessID("CCCGuardarRegistroVentas"));          
														 traza("IDBUSINESS GUARDADO");
														 //Se invoca el conector ConectorGuardarRegistroVentas 
														 traza("Antes de Conectar ConectorGuardarRegistroVentas");
														 DruidaConector conector = conectar("ConectorGuardarRegistroVentas", paramConector);
														 traza("Despues de Conectar ConectorGuardarRegistroVentas");	
													     asignarAtributo("VAR", "ejecutar", "valor", "inserccionCorrecta()");					
													 }catch(Exception e){
														e.printStackTrace();
														this.logStackTrace(e);
													    // lanzarPaginaError(e);
														throw e;			 
													 }
                                                      
                                             }
                                    }catch ( Exception e )  {
                                             e.printStackTrace();
                                             this.logStackTrace(e);
                                            // lanzarPaginaError(e);
											throw e;
                                    }
                           }


                           if(this.accion.equals("volver_menu_sec")){      
                                    //Si accion="volver_menu_sec" 
                                    //- Regresamos a la página de búsqueda: "BusquedaRegistroVentas" 
                                    pagina("contenido_registro_ventas_modificar");
                    		asignar("VAR", "idioma", idioma.toString());
                    		traza("->Idioma : "+idioma);
                    		asignar("VAR", "pais", pais.toString());	
                    		traza("->Pais : "+pais);
                    		//asignarAtributo("PAGINA","contenido_registro_ventas_modificar", "cod", "0785");
                    		//asignarAtributo("PAGINA","contenido_registro_ventas_modificar", "msgle", "Buscar Registro Ventas");
                           }

                           if(this.accion.equals("insertar_menu_principal")){      
                                    //Si accion="insertar_menu_principal"  
                                    //Utilizando "<<subsystem:soporte>> GestorCargaPantalla" cargamos los 
                                    //COMBOS: Empresa, TipoImpuestos, Canal, Acceso y SubAcceso, TipoDocumentoLegal, TipoDocumentoLegalReferencia. 
                                    ComposerViewElementList listelem = new ComposerViewElementList();
                            	ComposerViewElement empresa = new ComposerViewElement(); 
                            	ComposerViewElement tipoImpuestos = new ComposerViewElement();
                            	ComposerViewElement canal = new ComposerViewElement();
                            	ComposerViewElement acceso = new ComposerViewElement();
                            	ComposerViewElement subAcceso = new ComposerViewElement();
                            	ComposerViewElement tipoDocumentoLegal = new ComposerViewElement();
                            	ComposerViewElement tipoDocumentoLegalReferencia = new ComposerViewElement();
                            	
                            	//sapaza -- PER-SiCC-2010-0487 -- 16/08/2010
                            	ComposerViewElement tipoDocumentoSigla = new ComposerViewElement(); 
                            	
                            	DTOBelcorp dto = new DTOBelcorp();
                            	dto.setOidPais(pais);
                            	dto.setOidIdioma(idioma);
                            	
                            	empresa.setIDBusiness("SEGObtenerEmpresasPorPais");
                            	empresa.setDTOE(dto);
                                    traza("Elemento empresa");

                            	tipoImpuestos.setIDBusiness("CCCObtenerTasasImpuestoPorPais");
                            	tipoImpuestos.setDTOE(dto);
                                traza("Elemento tipo impuestos");

                                canal.setIDBusiness("SEGConsultaCanales");
                            	canal.setDTOE(dto);
                                traza("Elemento canales");

                                  

                            	tipoDocumentoLegal.setIDBusiness("FACObtenerTiposDocumentoLegal");
                            	//tipoDocumentoLegal.setIDBusiness("CCCObtenerTasasImpuestoPorPais");
                            	tipoDocumentoLegal.setDTOE(dto);
                                traza("Elemento tipo documento legal");

                                //sapaza -- PER-SiCC-2010-0487 -- 16/08/2010    
                                tipoDocumentoSigla.setIDBusiness("MAEObtenerTiposDocumentoPorSigla");
                                tipoDocumentoSigla.setDTOE(dto);
                                traza("Elemento tipo documento sigla");
                                

                                listelem.addViewElement(canal);
                            	listelem.addViewElement(empresa);
                            	listelem.addViewElement(tipoImpuestos);
                            	listelem.addViewElement(tipoDocumentoLegal);
                            	listelem.addViewElement(tipoDocumentoSigla); //sapaza -- PER-SiCC-2010-0487 -- 16/08/2010
                     
                            	traza("Elementos anadidos");
                            	
                            	//Se llama al subsistema GestorCargaPantalla. 
                            	ConectorComposerView conector = new ConectorComposerView(listelem,this.getRequest());
                            	traza("conector creado");
                            	conector.ejecucion();
                            	traza("ejecutado");
                            	DruidaConector conConsultar = conector.getConector();
                            	traza("Obtener conConsultar");
                                    
                                asignar("COMBO","cbCanal", conConsultar,"SEGConsultaCanales");
                                traza("Combo canal asignado");
                            	asignar("COMBO","cbEmpresa", conConsultar,"SEGObtenerEmpresasPorPais");
                            	traza("Combo empresa asignado");
                                asignar("COMBO","cbTipoImpuesto", conConsultar,"CCCObtenerTasasImpuestoPorPais");
                                traza("Combo tipoImpuesto asignado");				
                                    
                            	
                            	asignar("COMBO","cbTipoDocLegal", conConsultar,"FACObtenerTiposDocumentoLegal");
                            	//asignar("COMBO","cbTipoDocLegal", conConsultar,"CCCObtenerTasasImpuestoPorPais");
                            	traza("Combo tipoDocLegal asignado");
                                    
                                asignar("COMBO","cbTipoDocLegalReferencia", conConsultar,"FACObtenerTiposDocumentoLegal");
                                //asignar("COMBO","cbTipoDocLegalReferencia", conConsultar,"CCCObtenerTasasImpuestoPorPais");	
                                traza("Combo tipoDocLegalRef asignado");
                                
                                //sapaza -- PER-SiCC-2010-0487 -- 16/08/2010    
                                asignar("COMBO","cbTipoDocSigla", conConsultar,"MAEObtenerTiposDocumentoPorSigla");
                                traza("Combo cbTipoDocSigla asignado");                                
                                      
                           }else if(!this.accion.equals("guardar_menu_sec") && !this.accion.equals("TipoImpuesto") && !this.accion.equals("Modificar_cliente")
							        && !this.accion.equals("seleccionarArchivo") && !this.accion.equals("exportarArchivo")){        
                                    //else if accion != "guardar_menu_sec" 
                                    //Utilizando "<<subsystem:soporte>> GestorCargaPantalla" cargamos el COMBO:TipoImpuestos. 
                                ComposerViewElementList listelem = new ComposerViewElementList();
                            	ComposerViewElement cbImpuesto = new ComposerViewElement();
                            	ComposerViewElement canal = new ComposerViewElement();
                               	ComposerViewElement tipoDocumentoLegal = new ComposerViewElement();
  
								DTOBelcorp dto = new DTOBelcorp();
                            	dto.setOidPais(pais);
                            	dto.setOidIdioma(idioma);
                            	
                            	cbImpuesto.setIDBusiness("CCCObtenerTasasImpuestoPorPais");
                            	cbImpuesto.setDTOE(dto);
                                traza("[cs]Elemento tipo impuestos");
                                
								canal.setIDBusiness("SEGConsultaCanales");
                            	canal.setDTOE(dto);
                                traza("Elemento canales"); 

                                tipoDocumentoLegal.setIDBusiness("FACObtenerTiposDocumentoLegal");
                            	//tipoDocumentoLegal.setIDBusiness("CCCObtenerTasasImpuestoPorPais");
                            	tipoDocumentoLegal.setDTOE(dto);
                                traza("Elemento tipo documento legal");
                            	
								listelem.addViewElement(cbImpuesto);
                                listelem.addViewElement(canal); 
                                listelem.addViewElement(tipoDocumentoLegal); 
                            	
                            	//Se llama al subsistema GestorCargaPantalla. 
                            	ConectorComposerView conector = new ConectorComposerView(listelem,this.getRequest());
                            	traza("[cs]conector creado");
                            	conector.ejecucion();
                            	traza("ejecutado");
                            	DruidaConector conConsultar = conector.getConector();
                            	traza("[cs]Obtener conConsultar");
                  
                                asignar("COMBO","cbImpuesto", conConsultar,"CCCObtenerTasasImpuestoPorPais");				
                            	traza("[cs]Obtener asignado el combo");		
    							asignar("COMBO","cbCanal", conConsultar,"SEGConsultaCanales");
                                traza("Combo canal asignado");
								asignar("COMBO","cbTipoDocLegal", conConsultar,"FACObtenerTiposDocumentoLegal");
								traza("Combo tipoDocLegal asignado");

                           }
						   
						   // vbongiov -- Cambio 20070451 --14/11/2008
						  if(this.accion.equals("exportarArchivo")){
							   exportarArchivo();
							   getConfiguracionMenu();
						   }
                           
                    }catch ( Exception e )  {
                              e.printStackTrace();
                              logStackTrace(e);
                              lanzarPaginaError(e);
                    }  
                    traza("LPMantenimientoRegistroVentas Salida");         
          }


		// vbongiov -- Cambio 20070451 --14/11/2008
        private void exportarArchivo() throws Exception {
			try {
				pagina("salidaGenerica");

				String formatoFechaPais = UtilidadesSession.getFormatoFecha(this);

				
				String fechaEmisionDesde = conectorParametroLimpia("txtFechaEmisionDesde", "", true);
				String fechaEmisionHasta = conectorParametroLimpia("txtFechaEmisionHasta", "", true);
				String codigoClienteDesde = conectorParametroLimpia("txtCodClienteDesde", "", true);
				String codigoClienteHasta = conectorParametroLimpia("txtCodClienteHasta", "", true);
				String oidImpuestos = conectorParametroLimpia("cbImpuesto", "", true);
				String oidCanal = conectorParametroLimpia("cbCanal", "", true);
				String oidAcceso = conectorParametroLimpia("cbAcceso", "", true);
				String oidSubacceso = conectorParametroLimpia("cbSubacceso", "", true);
				String oidTipoDocLegal = conectorParametroLimpia("cbTipoDocLegal", "", true);
				String serieDocLegal = conectorParametroLimpia("txtSerieDocLegal", "", true);
				String numeroDocLegalDesde = conectorParametroLimpia("txtSerieNumeroDocLegalDesde", "", true);
				String numeroDocLegalHasta = conectorParametroLimpia("txtSerieNumeroDocLegalHasta", "", true);

				DTOBuscarRegistroVentas dtoBuscarRegistroVentas = new DTOBuscarRegistroVentas();

				dtoBuscarRegistroVentas.setOidPais(this.pais); 
				dtoBuscarRegistroVentas.setFechaEmisionDesde(fechaEmisionDesde.equals("")?null:UtilidadesBelcorp.getDatefromSICCStringFormat(fechaEmisionDesde, formatoFechaPais));
				dtoBuscarRegistroVentas.setFechaEmisionHasta(fechaEmisionHasta.equals("")?null:UtilidadesBelcorp.getDatefromSICCStringFormat(fechaEmisionHasta, formatoFechaPais));
				dtoBuscarRegistroVentas.setCodigoClienteDesde(codigoClienteDesde.equals("")?null:codigoClienteDesde);
				dtoBuscarRegistroVentas.setCodigoClienteHasta(codigoClienteHasta.equals("")?null:codigoClienteHasta);
				dtoBuscarRegistroVentas.setOidImpuestos(oidImpuestos.equals("")?null:Long.valueOf(oidImpuestos));  
				dtoBuscarRegistroVentas.setOidSubacceso(oidSubacceso.equals("")?null:Long.valueOf(oidSubacceso));  
				dtoBuscarRegistroVentas.setOidTipoDocLegal(oidTipoDocLegal.equals("")?null:Long.valueOf(oidTipoDocLegal));  
				dtoBuscarRegistroVentas.setSerieDocuLegal(serieDocLegal.equals("")?null:serieDocLegal);
				dtoBuscarRegistroVentas.setNumeroDocLegalDesde(numeroDocLegalDesde.equals("")?null:numeroDocLegalDesde);
				dtoBuscarRegistroVentas.setNumeroDocLegalHasta(numeroDocLegalHasta.equals("")?null:numeroDocLegalHasta);
				dtoBuscarRegistroVentas.setExportar("S");				

				traza("dtoBuscarRegistroVentas: " + dtoBuscarRegistroVentas);

				MareBusinessID id = new MareBusinessID("CCCExportarArchivoRegistroVentas");             
				Vector paramEntrada = new Vector();
			 
				paramEntrada.add(dtoBuscarRegistroVentas);
				paramEntrada.add(id);
				traza("*************** Antes de conectar");
				DruidaConector dc2 = conectar("ConectorExportarArchivoRegistroVentas", paramEntrada);
				traza("*************** Despues de conectar");

				String nombreFichero = "RegistroVentas"+  System.currentTimeMillis()+ ".xls";
				WritableWorkbook workbook = Workbook.createWorkbook(new File(Contexto.getPropiedad("DESCARGABLES", "PATH") + nombreFichero)); 
				WritableSheet sheet = workbook.createSheet("Registro Ventas", 0); 

				NodeList lista = dc2.getXML().getElementsByTagName("ROW");
                int largo = lista.getLength();
				int columnas = 13;
				Label label;

				for(int i = 0; i< largo;i++){
					for( int j = 0; j<columnas ;j++){
						label = new Label(j, i+1, lista.item(i).getChildNodes().item(j).getFirstChild().getNodeValue());
						sheet.addCell(label); 
					}			
				}

				workbook.write(); 
				workbook.close();

				asignarAtributo("VAR","ejecutar","valor","descargar('"+nombreFichero+"')");

			} catch(Exception e) {
				 traza("Excepcion: " + e);
				 asignarAtributo("VAR", "ejecutarError", "valor", "alert('vivi')");
				 throw e;
			}

		}

		// vbongiov -- Cambio 20070451 --14/11/2008
        private void seleccionarArchivo() throws Exception {
			traza("accion seleccionarArchivo inicio");      

			pagina("contenido_seleccion_fichero_registro_venta");

			String fechaEmisionDesde = conectorParametroLimpia("fechaEmisionDesde", "", true);
			String fechaEmisionHasta = conectorParametroLimpia("fechaEmisionHasta", "", true);
			String codigoClienteDesde = conectorParametroLimpia("codigoClienteDesde", "", true);
			String codigoClienteHasta = conectorParametroLimpia("codigoClienteHasta", "", true);
			String oidImpuestos = conectorParametroLimpia("oidImpuestos", "", true);
			String oidCanal = conectorParametroLimpia("oidCanal", "", true);
			String oidAcceso = conectorParametroLimpia("oidAcceso", "", true);
			String oidSubacceso = conectorParametroLimpia("oidSubacceso", "", true);
			String oidTipoDocLegal = conectorParametroLimpia("oidTipoDocLegal", "", true);
			String serieDocLegal = conectorParametroLimpia("serieDocLegal", "", true);
			String numeroDocLegalDesde = conectorParametroLimpia("numeroDocLegalDesde", "", true);
			String numeroDocLegalHasta = conectorParametroLimpia("numeroDocLegalHasta", "", true);

			asignarAtributo("VAR","hFechaEmisionDesde","valor", fechaEmisionDesde);  
			asignarAtributo("VAR","hFechaEmisionHasta","valor", fechaEmisionHasta);  
			asignarAtributo("VAR","hCodigoClienteDesde","valor", codigoClienteDesde);  
			asignarAtributo("VAR","hCodigoClienteHasta","valor", codigoClienteHasta);  
			asignarAtributo("VAR","hOidImpuestos","valor", oidImpuestos);  
			asignarAtributo("VAR","hOidCanal","valor", oidCanal);  
			asignarAtributo("VAR","hOidAcceso","valor", oidAcceso);  
			asignarAtributo("VAR","hOidSubacceso","valor", oidSubacceso);  
			asignarAtributo("VAR","hOidTipoDocLegal","valor", oidTipoDocLegal);  
			asignarAtributo("VAR","hSerieDocLegal","valor", serieDocLegal);  
			asignarAtributo("VAR","hNumeroDocLegalDesde","valor", numeroDocLegalDesde);  
			asignarAtributo("VAR","hNumeroDocLegalHasta","valor", numeroDocLegalHasta);  

		}


          
        //Añadido por incidencia 13566
        private void modificarCliente() throws Exception {
        	traza("modificarCliente Entrada");
        	pagina("PGOcultaCliente");
        	//Recuperamos pais e idioma de sesion
            this.pais = UtilidadesSession.getPais(this);
            this.idioma = UtilidadesSession.getIdioma(this);
            String codigoCliente = conectorParametroLimpia("txtCodCliente","",true);
        	DTOBusquedaRapidaCliente dto = new DTOBusquedaRapidaCliente();
        	
        	
        	dto.setOidIdioma(this.idioma);
        	dto.setOidPais(this.pais);
        	dto.setCodigoCliente(codigoCliente);
        	dto.setIndicadorSituacion(new Long(0));
        	dto.setTamanioPagina(new Integer(20));
        	traza("El dto es:" + dto);
        	//ConectorBusquedaRapidaCliente
        	traza("llamamos conector ConectorBusquedaRapidaCliente");
        	Vector listelem = new Vector();
        	listelem.add(dto);
            listelem.add(new MareBusinessID("MAEBusquedaRapidaCliente"));
            DruidaConector conector=null;
            try{
            	conector = conectar("ConectorBusquedaRapidaCliente", listelem);
            	DTOSalida dtoSalida = (DTOSalida)conector.objeto("DTOSalida");
            	traza("Despues llamada conector");
	            
	            RecordSet rs = dtoSalida.getResultado();
	            //traza("Despues");
	            //traza("Recordset" + rs);
	            if (rs != null && !rs.esVacio()) {
	            	if (rs.getValueAt(0, "OID") != null)
	            		asignar("VAR", "oidCliente", rs.getValueAt(0,"OID").toString());
	            	if (rs.getValueAt(0, "VAL_NOM1") != null)
	            		asignar("VAR", "nombre1", rs.getValueAt(0,"VAL_NOM1").toString());
	            	if (rs.getValueAt(0, "VAL_NOM2") != null)
	            		asignar("VAR", "nombre2", rs.getValueAt(0,"VAL_NOM2").toString());
	            	if (rs.getValueAt(0, "VAL_APE1") != null)
	            		asignar("VAR", "apellido1", rs.getValueAt(0,"VAL_APE1").toString());
	            	if (rs.getValueAt(0, "VAL_APE2") != null)
	            		asignar("VAR", "apellido2", rs.getValueAt(0,"VAL_APE2").toString());
	            }	
        	}catch(Exception e){
        		traza("No existe el cliente");
        	}
            
            

        	traza("modificarCliente Salida");
        
    	}
                  
		private void obtieneCoeficienteImpuesto()throws Exception {
        	
        	traza("obtieneCoeficienteImpuesto Entrada");
            //Salida genérica
            pagina("salidaGenerica_arrayDatos");
            
            this.casoUso = conectorParametroLimpia("casoUso","", true);
            traza("Caso de uso:" + this.casoUso);
            if (this.casoUso.equals("insertar")) {
            	asignar("VAR", "cerrarVentana", "true");
            }else {
            	asignar("VAR", "cerrarVentana", "false");
            }
            
            asignar("VAR", "ejecutar", "ponerCoeficiente(");

            //Recuperamos pais e idioma de sesion
            Long pais = UtilidadesSession.getPais(this);
            Long idioma = UtilidadesSession.getIdioma(this);
                      
            String tipoImpuesto = conectorParametroLimpia("cbOidTipoImpuesto", "", true);
            traza("TipoImpuesto = " + tipoImpuesto);
                      
            if(!tipoImpuesto.equals("")){
            	Vector listelem = new Vector();
				               
            	//Creamos el DOTOOID y lo rellenamos
            	DTOOID dto = new DTOOID();
            	dto.setOidIdioma(idioma);
            	dto.setOidPais(pais);
            	traza("cargamos el DTO");
            	dto.setOid(new Long(tipoImpuesto));
            	traza("DTO cargado");
            	          
            	listelem.add(dto);
            	listelem.add(new MareBusinessID("CCCCoeficienteImpuesto"));
            	          
            	traza("llamamos conector");
            	DruidaConector conector = conectar("ConectorCoeficienteImpuesto", listelem);
            	traza("recogemos el DTO del conector");
            	//Con el DTOSalida que obtenemos, con sus atributos rellenamos los compontes. º
            	DTOSalida dtoSalida = (DTOSalida)conector.objeto("DTOSalida");
            	RecordSet rs = dtoSalida.getResultado();
            	if (rs != null && !rs.esVacio()) {
            		Vector cols = rs.getColumnIdentifiers();
            	    DruidaConector conectorCargaCoeficiente = UtilidadesBelcorp.generarConector( "arrayDatos", rs, cols);
            	    asignar("MATRIZJS", "arrayDatos", conectorCargaCoeficiente);
            	}
            }
            traza("obtieneCoeficienteImpuesto Salida");	
		}

          private void logStackTrace(Throwable e) throws Exception {
                  traza("Se produjo la excepcion: " + e.getMessage());		
                  ByteArrayOutputStream baos = new ByteArrayOutputStream();
                  PrintStream ps = new PrintStream(baos);
                  e.printStackTrace(ps);		
                  traza("Stack Trace: " + baos.toString());
          }      

}
