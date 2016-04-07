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


import es.indra.druida.DruidaConector;

import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;

import java.util.Vector;
import java.util.Date;
import java.util.Calendar;
import java.util.StringTokenizer;



import java.math.BigDecimal;

import java.text.SimpleDateFormat;
import java.text.ParsePosition;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.druida.DruidaConector;
 
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesFecha;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOBelcorp;

import es.indra.sicc.dtos.seg.DTOAccesosPorCanal;

import es.indra.sicc.dtos.ccc.DTOBancoSucursal;
import es.indra.sicc.dtos.ccc.DTOReclamo;
import es.indra.sicc.dtos.ccc.DTONumeroReclamo;

import es.indra.sicc.logicanegocio.ccc.CCCConstantes;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class LPMantenimientoReclamos extends LPSICCBase {
         
         private String accion = null;
         private String casoUso = null;
         private Long pais;
         private Long idioma;
         private DruidaConector conConsultarTem;
         private Integer nIdentificacion;
        
         
         
         public LPMantenimientoReclamos() {
                  super();
         }
         public void inicio() throws Exception {
                  
         }

		 /*
		  * Modificado: mmaidana
		  * Fecha: 24/10/2005
		  * Motivo: Incidencia 19074
		  */
         public void ejecucion() throws Exception {
                  setTrazaFichero();
     try  {			
	  		traza("*****LPMantenimientoReclamos Entrada");
			this.idioma = UtilidadesSession.getIdioma(this);
                        this.pais = UtilidadesSession.getPais(this);
                        this.accion = conectorParametroLimpia("accion","", true);
                        traza("*****ACCION ---Accion definida : "+accion);
		/*	if(conectorParametroLimpia("accion","", true).equals("")){
				this.accion="insertar_menu_principal";
				traza("he cambiado la accion porque venia vacia");
			}
		*/
			//Menú principal 
                        if(this.accion.equals("insertar_menu_principal")){
                		//Si accion="insertar_menu_principal" { 
				//- Mostramos (cargamos) la página: "PantallaReclamos" 
				//- Desactivamos la opción "Volver" del menú secundario 
				//- Desactivamos la opción "Eliminar" del menú secundario 
				//-Utilizando "<<subsystem:soporte>> GestorCargaPantalla" 
				//cargamos los COMBOS: Empresa, Canal, Banco, MedioPago, 
				//UsuarioGestorReclamoPrevisto (Usuario). 
				//} 

                                this.casoUso = "insertar"; 
                                pagina("contenido_reclamos_insertar");

				Byte longitud = this.obtenerLongitudCodigoCliente();
				Long longitudCodigoCliente = new Long(longitud.longValue());
				asignar("VAR","longitudCodigoCliente",longitudCodigoCliente.toString());	
				asignar("VAR","tamanio",longitud.toString());
				traza("Longitud del cod cliente: "+longitudCodigoCliente);
				traza("Longitud del cod cliente: "+longitud);
         	  		asignar("VAR", "idioma", idioma.toString());
         	  		traza("->Idioma : "+idioma);
         	  		asignar("VAR", "pais", pais.toString());	
         	  		traza("->Pais : "+pais);
		  		asignar("VAR", "casoUso", "insertar");
				
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
				
  		  		asignarAtributo("PAGINA","contenido_reclamos_insertar","cod","0532");
				asignarAtributo("PAGINA","contenido_reclamos_insertar","msgle","Insertar reclamos");
         	  		
         	  		getConfiguracionMenu("LPMantenimientoReclamos","Insertar");
         	  		
         	  		//COMBOS::
         	  		//-Utilizando "<<subsystem:soporte>> GestorCargaPantalla" 
				//cargamos los COMBOS: Empresa, Canal, Banco, MedioPago, 
				//UsuarioGestorReclamoPrevisto (Usuario). 
				
         	  		cargarCombos(new Boolean(true), new Boolean(false));
         	  		
         	  		asignar("COMBO","cbEmpresa", conConsultarTem,"SEGObtenerEmpresasPorPais");
         	  		asignar("COMBO","cbCanal", conConsultarTem,"SEGConsultaCanales");
				asignar("COMBO","cbBancoRecaudacion", conConsultarTem,"CCCObtieneBancos");
         	  		asignar("COMBO","cbMedioPago", conConsultarTem,"BELObtenerMediosPagoCombo");
         	  		
         	  		asignar("COMBO","cbUsuarioGestorReclamoPrevisto", conConsultarTem,"MENObtenerCodUsuarios");
				
				
				
				//***************************************************************************************
				
				
				
				//CCCGenerarSiguienteNumeroReclamo MLNFGenerarSiguienteNumeroReclamo.xml
				Vector paramConector = new Vector();
				DTOBelcorp dto=new DTOBelcorp();
				dto.setOidIdioma(this.idioma);
				dto.setOidPais(this.pais);
				
				paramConector.add(dto);
				paramConector.add(new MareBusinessID("CCCGenerarSiguienteNumeroReclamo"));          
				traza("Antes de Conectar");
				DruidaConector conector = conectar("ConectorGenerarSiguienteNumeroReclamo", paramConector);							
				traza("Despues de Conectar");
				Object objeto=conector.objeto("DTONumeroReclamo");
				traza("Objeto recogido"+objeto);
				DTONumeroReclamo  dtoNumeroReclamo = (DTONumeroReclamo)conector.objeto("DTONumeroReclamo");	
				traza("DTONumeroReclamo obtenido " +dtoNumeroReclamo);
				nIdentificacion= dtoNumeroReclamo.getNumeroIdentificacion();
				
							
			        traza("nIdentificacion " +nIdentificacion);
			        if(nIdentificacion != null) {
			        	asignarAtributo("LABELC","lbldtNumIdentificacion","valor",nIdentificacion.toString());
			        	//asignar("VAR","hid_numLote", nIdentificacion.toString());
			        	asignar("VAR", "nIdentificacion", nIdentificacion.toString());
			        }
			        
			  	
			      // asignar("VAR", "nIdentificacion", "200");
			        //Además rellenamos los siguientes campos con valores por defecto. 
					//fechaDocumento = ponemos la fecha actual 
				 traza ("fechaD");
				 traza ("longitudCodigoCliente"+ conectorParametroLimpia("longitudCodigoCliente", "", true));
				
				String fechaD = UtilidadesBelcorp.fechaFormateada(new java.util.Date(), UtilidadesSession.getFormatoFecha(this));
				asignarAtributo("LABELC","lbldtFechaDoc","valor",fechaD);
				asignar("VAR","fecdoc", fechaD);
				 traza ("despues de asignarla fechaD");
				//en usuarioSolicitante ponemos el código de usuario del usuario 
				//actual del sistema, cogiendolo de la sesión. 
				String usuario = UtilidadesSession.getIdUsuario(this);
				asignarAtributo("LABELC", "lblUsuarioSolicitantedt", "valor" , usuario);
				asignar("VAR","hUsuarioSolicitante", usuario);
					//en pais ponemos la descripcion del pais activo 
				//CAMBIOS EN LA MAQUETACION
				String desPais = UtilidadesSession.getDescripcionPais(this);
				//CAMBIOS EN LA MAQUETACION   asignarAtributo("LABELC", "lblPaisActual", "valor", desPais);DESAPARECE
				asignar("VAR","hPais", desPais);
					//en año ponemos las dos ultimas cifras del año actual del sistema 
					//en periodoMes ponemos el número de mes actual con dos cifras. 
			      	String anyo = UtilidadesFecha.convertirAString(new Date(System.currentTimeMillis()),"yy");
			      	String mes = UtilidadesFecha.convertirAString(new Date(System.currentTimeMillis()),"MM");
			      	asignarAtributo("LABELC","lbldtAño","valor",anyo); 
			      	asignarAtributo("LABELC","lbldtMes","valor",mes);
			      	
			      	asignar("VAR","hAnyo", anyo);
			      	asignar("VAR","hPeriodoMes", mes);
			      	
			        //Generamos el hidden para el formato de fecha
			        
			       /* 
			        //Datos preseleccionados
					Long canal = UtilidadesSession.getCanalPorDefecto(this);
					if (canal != null) {
						asignar("VAR", "canal", canal.toString());
					}
					Long empresa = UtilidadesSession.getSociedadPorDefecto(this);
					if (empresa != null) {
						asignar("VAR", "empresa", empresa.toString());
					}
			 		Long subacceso = UtilidadesSession.getSubaccesoPorDefecto(this);
					if (subacceso != null) {
						asignar("VAR", "subacceso", subacceso.toString());
					}
				*/	
					
			}//Insertar
				//**********hasta aqui......***************************************************************+
		
			
			
                       
                      
                        if(this.accion.equals("consultar_menu_principal")){
                        	traza("Entro en  consultar_menu_principal");
				//  Mostramos (cargamos) la página: "BuscarReclamos" 
				//- Desactivamos la opción "Volver" del menú secundario 
				//- Desactivamos la opción "Eliminar" del menú secundario 
				///- Desactivamos la opción "Guardar" del menú secundario 
				
				//- Desactivamos el botón "Modificar" 
				//- Desactivamos el botón "CambiarAProcesado" 
				//- Desactivamos el botón "CargosyAbonos" 
				
				pagina("contenido_reclamos_buscar");
				traza("Pagina seleccionada: contenido_reclamos_buscar");
				
				Byte longitud = this.obtenerLongitudCodigoCliente();
				Long longitudCodigoCliente = new Long(longitud.longValue());
				asignar("VAR","longitudCodigoCliente",longitudCodigoCliente.toString());					
				traza("->Idioma : "+idioma);
         	  		asignar("VAR", "idioma", idioma.toString());
         	  		traza("->Idioma : "+idioma);
         	  		asignar("VAR", "pais", pais.toString());	
         	  		traza("->Pais : "+pais);
		  		asignar("VAR", "casoUso", "consultar");
				// Fecha:
				this.generarHiddenFormatoFecha();
								
				asignarAtributo("PAGINA","contenido_reclamos_buscar","cod","0534");	
				asignarAtributo("PAGINA","contenido_reclamos_buscar","msgle","Consultar reclamos");	
				getConfiguracionMenu("LPMantenimientoReclamos", "Consultar");
				
				//CARGAR LOS COMBOS de usuario
				traza("Al cargar los Combos.");
				ComposerViewElementList listelem = new ComposerViewElementList();
				
				DTOBelcorp dto = new DTOBelcorp();
			        dto.setOidPais(this.pais);
			        dto.setOidIdioma(this.idioma);
         	  	
				ComposerViewElement usuarioP = new ComposerViewElement();
		         	usuarioP.setIDBusiness("MENObtenerCodUsuarios");
		         	usuarioP.setDTOE(dto);
				traza("Elemento UsuarioP");
				listelem.addViewElement(usuarioP);
				
				
				ComposerViewElement situa= new ComposerViewElement();
		         	situa.setIDBusiness("CCCObtenerSituacionesReclamo");
		         	situa.setDTOE(dto);
				traza("Elemento situacion");
				listelem.addViewElement(situa);
				
				ComposerViewElement banco = new ComposerViewElement();
		         	banco.setIDBusiness("CCCObtieneBancos");
		         	banco.setDTOE(dto);
				traza("Elemento Banco");
				listelem.addViewElement(banco);

				
				
				

				traza("Antes del conector ComposerView");
				//Se llama al subsistema GestorCargaPantalla. 
		         	ConectorComposerView conector = new ConectorComposerView(listelem,this.getRequest());
		         	traza("conector creado");
		         	conector.ejecucion();
		         	traza("ejecutado");
		         	DruidaConector conConsultar = conector.getConector();
		         	traza("Obtener conConsultar");
				
				asignar("COMBO","cbUsuarioSolicitante", conConsultar,"MENObtenerCodUsuarios");
				asignar("COMBO","cbUsuarioGestorReclamoPrevisto", conConsultar,"MENObtenerCodUsuarios");
				asignar("COMBO","cbUsuarioGestorReclamoReal", conConsultar,"MENObtenerCodUsuarios");
				asignar("COMBO","cbBancoRecaudacion", conConsultar,"CCCObtieneBancos");
				asignar("COMBO","cbSituacion", conConsultar,"CCCObtenerSituacionesReclamo");
				traza("Todos los combos asignados en consultar");

/*
		         	ComposerViewElementList listaelementos = new ComposerViewElementList();
		         	ComposerViewElement elemento1 = new ComposerViewElement();
		         	elemento1.setIDBusiness("CCCObtenerSituacionesReclamo");
		         	DTOBelcorp dtobelc = new DTOBelcorp();
		         	dtobelc.setOidIdioma(new Long(1));
		         	dtobelc.setOidPais(new Long(1));
		         	elemento1.setDTOE(dtobelc);
		         	listaelementos.addViewElement(elemento1);
		         	ConectorComposerView conec = new ConectorComposerView(listaelementos,this.getRequest());
		         	traza("antes");
		         	conec.ejecucion();
		         	traza("despues");
		         	DruidaConector conConsu = conector.getConector();
		         	asignar("COMBO","cbSituacion", conConsu,"DTOSalida.resultado");
*/

                        }//metodo consultar
                        

                        
                        
                        
                        
                        if(this.accion.equals("modificar_menu_principal")){
                        	pagina("contenido_reclamos_buscar");
				Byte longitud = this.obtenerLongitudCodigoCliente();
				Long longitudCodigoCliente = new Long(longitud.longValue());
				asignar("VAR","longitudCodigoCliente",longitudCodigoCliente.toString());	
				
				asignar("VAR","estado",CCCConstantes.RECLAMO_SITUACION_SOLICITADO.toString());
				traza("Estado: "+CCCConstantes.RECLAMO_SITUACION_SOLICITADO.toString());
                        	
                        	
				this.casoUso = "modificar"; 
				
				traza("->Idioma : "+idioma);
         	  		asignar("VAR", "idioma", idioma.toString());
         	  		traza("->Idioma : "+idioma);
         	  		asignar("VAR", "pais", pais.toString());	
         	  		traza("->Pais : "+pais);
		  		asignar("VAR", "casoUso", "modificar");
				// Fecha:
				this.generarHiddenFormatoFecha();
				
				
				asignarAtributo("PAGINA","contenido_reclamos_buscar","cod","0533");	
				asignarAtributo("PAGINA","contenido_reclamos_buscar","msgle","Modificar reclamos");	
				getConfiguracionMenu("LPMantenimientoReclamos", "Modificar");
				
				//CARGAR LOS COMBOS de usuario
				traza("Al cargar los Combos.");
				ComposerViewElementList listelem = new ComposerViewElementList();

				DTOBelcorp dto = new DTOBelcorp();
			        dto.setOidPais(this.pais);
			        dto.setOidIdioma(this.idioma);

				ComposerViewElement situa= new ComposerViewElement();
		         	situa.setIDBusiness("CCCObtenerSituacionesReclamo");
		         	situa.setDTOE(dto);
				traza("Elemento situacion");
				listelem.addViewElement(situa);
         	  	
				ComposerViewElement usuarioP = new ComposerViewElement();
		         	usuarioP.setIDBusiness("MENObtenerCodUsuarios");
		         	usuarioP.setDTOE(dto);
				traza("Elemento UsuarioP");
				listelem.addViewElement(usuarioP);

				ComposerViewElement banco = new ComposerViewElement();
		         	banco.setIDBusiness("CCCObtieneBancos");
		         	banco.setDTOE(dto);
				traza("Elemento Banco");
				listelem.addViewElement(banco);
				
			
				//Se llama al subsistema GestorCargaPantalla. 
		         	ConectorComposerView conector = new ConectorComposerView(listelem,this.getRequest());
		         	traza("conector creado");
		         	conector.ejecucion();
		         	traza("ejecutado");
		         	DruidaConector conConsultar = conector.getConector();
		         	traza("Obtener conConsultar");
				
				asignar("COMBO","cbUsuarioSolicitante", conConsultar,"MENObtenerCodUsuarios");
				asignar("COMBO","cbUsuarioGestorReclamoPrevisto", conConsultar,"MENObtenerCodUsuarios");
				asignar("COMBO","cbUsuarioGestorReclamoReal", conConsultar,"MENObtenerCodUsuarios");
				asignar("COMBO","cbBancoRecaudacion", conConsultar,"CCCObtieneBancos");
				asignar("COMBO","cbSituacion", conConsultar,"CCCObtenerSituacionesReclamo");
				
							
				
                        }//metodo modificar
                        if(this.accion.equals("eliminar_menu_principal")){
                    		pagina("contenido_reclamos_buscar");
				Byte longitud = this.obtenerLongitudCodigoCliente();
				Long longitudCodigoCliente = new Long(longitud.longValue());
				asignar("VAR","longitudCodigoCliente",longitudCodigoCliente.toString());	
                    		
				this.casoUso = "eliminar"; 
				
				traza("->Idioma : "+idioma);
         	  		asignar("VAR", "idioma", idioma.toString());
         	  		traza("->Idioma : "+idioma);
         	  		asignar("VAR", "pais", pais.toString());	
         	  		traza("->Pais : "+pais);
		  		asignar("VAR", "casoUso", "eliminar");
				// Fecha:
				this.generarHiddenFormatoFecha();
				
				
				asignarAtributo("PAGINA","contenido_reclamos_buscar","cod","0535");	
				asignarAtributo("PAGINA","contenido_reclamos_buscar","msgle","Eliminar reclamos");	
				getConfiguracionMenu("LPMantenimientoReclamos", "Eliminar");	
				
				//CARGAR LOS COMBOS de usuario
				traza("Al cargar los Combos.");
				ComposerViewElementList listelem = new ComposerViewElementList();
				DTOBelcorp dto = new DTOBelcorp();
			        dto.setOidPais(this.pais);
			        dto.setOidIdioma(this.idioma);
         	  	
				ComposerViewElement usuarioP = new ComposerViewElement();
		         	usuarioP.setIDBusiness("MENObtenerCodUsuarios");
		         	usuarioP.setDTOE(dto);
				traza("Elemento UsuarioP");
				
				listelem.addViewElement(usuarioP);
				ComposerViewElement banco = new ComposerViewElement();
		         	banco.setIDBusiness("CCCObtieneBancos");
		         	banco.setDTOE(dto);
				traza("Elemento Banco");
				
				listelem.addViewElement(banco);
				
				ComposerViewElement situa= new ComposerViewElement();
		         	situa.setIDBusiness("CCCObtenerSituacionesReclamo");
		         	situa.setDTOE(dto);
				traza("Elemento situacion");
				listelem.addViewElement(situa);
				
				//Se llama al subsistema GestorCargaPantalla. 
		         	ConectorComposerView conector = new ConectorComposerView(listelem,this.getRequest());
		         	traza("conector creado");
		         	conector.ejecucion();
		         	traza("ejecutado");
		         	DruidaConector conConsultar = conector.getConector();
		         	traza("Obtener conConsultar");
				
				asignar("COMBO","cbUsuarioSolicitante", conConsultar,"MENObtenerCodUsuarios");
				asignar("COMBO","cbUsuarioGestorReclamoPrevisto", conConsultar,"MENObtenerCodUsuarios");
				asignar("COMBO","cbUsuarioGestorReclamoReal", conConsultar,"MENObtenerCodUsuarios");
				asignar("COMBO","cbBancoRecaudacion", conConsultar,"CCCObtieneBancos");
				asignar("COMBO","cbSituacion", conConsultar,"CCCObtenerSituacionesReclamo");
				traza("Todos los combos asignados en consultar");	
                        }//metodo eliminar
                        
                        if(this.accion.equals("procesar_btn")){
                        	traza("ESTAMOS EN procesar_btn");
                        	//Si accion="procesar_btn" { 
				//Construimos un DTOOIDs con el array de oids que nos llega como parámetro. 
				//Llamamos a "ConectorPasarAProcesados", IdBusiness="CCCPasarAProcesados", 
				//y parámetro de entrada el DTOOIDs. 
				//} 
				pagina("salidaGenerica");
				String codigos=null;
				Long movimientos[] =null;
				codigos = conectorParametroLimpia("oidses", "", true);
				traza("oidses" + conectorParametroLimpia("oidses", "", true));
				if(!codigos.equals("")) {
				       java.util.StringTokenizer st = new java.util.StringTokenizer(codigos, ",");
				       if (st.countTokens() > 0){
				                movimientos = new Long[st.countTokens()];
				                traza("dentro del if ");        
				                for (int i = 0; i < movimientos.length; i++) {
				                	traza("dentro del for");
				                         movimientos[i] = Long.valueOf (st.nextToken());
				                }
				       }
				}
				traza("codigos= "+codigos );
				
				DTOOIDs dtoOids= new DTOOIDs();
				dtoOids.setOidIdioma(this.idioma);
				dtoOids.setOidPais(this.pais);
				dtoOids.setOids(movimientos);
				traza("DTOOIDs" + dtoOids);
				
				Vector paramConector = new Vector();
				
				paramConector.add(dtoOids);
				paramConector.add(new MareBusinessID("CCCPasarAProcesados"));          
				traza("Antes de Conectar");
				DruidaConector conector = conectar("ConectorPasarAProcesados", paramConector);							
				traza("Despues de Conectar");
				

                        	
                        }
			if(this.accion.equals("consultar_btn")){
				/*Si accion="consultar_btn" {
				//La llamada se produce al pulsar el botón "Detalle" de la pantalla
				"BuscarReclamos". Este botón se visualiza solo en consultas.
				//Nos llega como parámetro: OID de entidad "RecepcionReclamos" obtenido a partir de la fila seleccionada por el
				usuario para Modificar.
				-Guardamos el oid en el campo oculto de la pantalla "PantallaReclamos" llamado oid.
				-Creamos un DTOOID con el OID que nos llega como parámetro y utilizando el "ConectorObtenerReclamo",
				IdBusiness="CCCObtenerReclamo" obtenemos un DTOReclamo con el cual vamos a llenar la pantalla.
				
				- Mostramos (cargamos) la página: "PantallaReclamos".
				- Mostramos la página (capa): "PantallaResolucionReclamo".
				- Desactivamos la opción "Volver" del menú secundario
				- Desactivamos la opción "Eliminar" del menú secundario  
				
				- Debemos copiar los datos obtenidos en el DTOReclamo a los 
				  campos de pantalla.
				  Se deshabilitan todos los campos de pantalla.
				}
			*/
			
				this.casoUso = "consultar"; 
                                pagina("contenido_reclamos_insertar");
				Byte longitud = this.obtenerLongitudCodigoCliente();
				Long longitudCodigoCliente = new Long(longitud.longValue());
				asignar("VAR","longitudCodigoCliente",longitudCodigoCliente.toString());	
                                
				
         	  		asignar("VAR", "idioma", idioma.toString());
         	  		traza("->Idioma : "+idioma);
         	  		asignar("VAR", "pais", pais.toString());	
         	  		traza("->Pais : "+pais);
		  		//asignar("VAR", "casoUso", "consultar");
				
				// Fecha:
				this.generarHiddenFormatoFecha();
				
				
	                        // Numeros:
	                        String separadorDecimales = UtilidadesSession.getSeparadorDecimales(this);
				String separadorMiles = ",";
				if (separadorDecimales.equals(",")){
					separadorMiles = ".";
				}
				asignar("VAR","hid_SeparadorMiles", separadorMiles);
				asignar("VAR","hid_NumeroDecimales",UtilidadesSession.getFormatoNumerico(this));
				asignar("VAR","hid_SeparadorDecimales", separadorDecimales);
				  		  					
				
				traza("CU CU CU CU"+conectorParametroLimpia("cu", "", true));
				if(conectorParametroLimpia("cu", "", true)!=null){
					if(conectorParametroLimpia("cu", "", true).equals("consultar")){
						asignarAtributo("PAGINA","contenido_reclamos_insertar","cod","0534");	
						asignarAtributo("PAGINA","contenido_reclamos_insertar","msgle","Consultar reclamos");	
						getConfiguracionMenu("LPMantenimientoReclamos", "ConsultarPopup");
					}
					if(conectorParametroLimpia("cu", "", true).equals("eliminar")){
						asignarAtributo("PAGINA","contenido_reclamos_insertar","cod","0535");	
						asignarAtributo("PAGINA","contenido_reclamos_insertar","msgle","Eliminar reclamos");	
						getConfiguracionMenu("LPMantenimientoReclamos", "ConsultarPopup");
					}
				}
				asignarAtributo("VAR","casoUso","valor","consultar");		
					
				
				traza("oidRecibido String: "+conectorParametroLimpia("oidSeleccionado", "", true));			
				Long oidRecibido=new Long(conectorParametroLimpia("oidSeleccionado", "", true));
				traza("oidRecibido : "+oidRecibido);
				
				Vector paramConector = new Vector();
				DTOOID dtoOid=new DTOOID();
				dtoOid.setOidIdioma(idioma);
				dtoOid.setOidPais(pais);
				dtoOid.setOid(oidRecibido);
				paramConector.add(dtoOid);
				paramConector.add(new MareBusinessID("CCCObtenerReclamo"));          
				traza("Antes de Conectar");
				DruidaConector conector = conectar("ConectorObtenerReclamo", paramConector);							
				traza("Despues de Conectar");
				Object objeto=conector.objeto("DTOReclamo");
				traza("Objeto recogido"+objeto);
				DTOReclamo  dtoReclamo = (DTOReclamo)conector.objeto("DTOReclamo");	
				traza("DTOReclamo obtenido " +dtoReclamo);
				asignar("VAR", "oid", oidRecibido.toString());			
				
				
         	  		cargarCombos(new Boolean(true), new Boolean(true));
         	  		
         	  		ComposerViewElementList listelem = new ComposerViewElementList();
				DTOBelcorp dto = new DTOBelcorp();
			        dto.setOidPais(this.pais);
			        dto.setOidIdioma(this.idioma);
			        
			        traza("this.pais "+this.pais);
	         	  	traza("this.idioma "+this.idioma);
	         	  	
			        
			        	DTOAccesosPorCanal dtoA = new DTOAccesosPorCanal();
			        	dtoA.setOidCanal(dtoReclamo.getOidCanal());
			        	dtoA.setOidPais(this.pais);
			        	dtoA.setOidIdioma(this.idioma);
			        	
			         	ComposerViewElement acceso = new ComposerViewElement();
			         	acceso.setIDBusiness("SEGObtenerAccesosPorCanal");
			         	acceso.setDTOE(dtoA);
					listelem.addViewElement(acceso);
					traza("Elemento acceso");
				
				
				
					DTOOID dtoOidA= new DTOOID();
					dtoOidA.setOid(dtoReclamo.getOidAcceso());
				        dtoOidA.setOidPais(this.pais);
				        dtoOidA.setOidIdioma(this.idioma);
				       
				        ComposerViewElement sub = new ComposerViewElement();
			         	sub.setIDBusiness("SegObtenerSubaccesosPorAcceso");
			         	sub.setDTOE(dtoOidA);
					listelem.addViewElement(sub);
					traza("Elemento sub");
				
				if(dtoReclamo.getOidPeriodoReclamante()!=null){
					DTOOID dtoOidP= new DTOOID();
					dtoOidP.setOid(dtoReclamo.getOidCanal());
				     	dtoOidP.setOidPais(this.pais);
				     	dtoOidP.setOidIdioma(this.idioma);
				      
					ComposerViewElement periodo = new ComposerViewElement();
			        	periodo.setIDBusiness("SEGObtenerPeriodosPorCanal");
			        	periodo.setDTOE(dtoOidP);
					listelem.addViewElement(periodo);
					traza("Elemento periodo");
				}
				
				
				
					DTOOID dtoOidS= new DTOOID();
					dtoOidS.setOid(dtoReclamo.getOidBanco());
					dtoOidS.setOidPais(this.pais);
					dtoOidS.setOidIdioma(this.idioma);
					ComposerViewElement Sucursal = new ComposerViewElement();
				        Sucursal.setIDBusiness("CCCRecargaSucursales");
				        Sucursal.setDTOE(dtoOidS);
					listelem.addViewElement(Sucursal);
				
				
				
					DTOOID dtoOidC= new DTOOID();
					dtoOidC.setOid(dtoReclamo.getOidSucursal());
					dtoOidC.setOidPais(this.pais);
					dtoOidC.setOidIdioma(this.idioma);
					ComposerViewElement cuentas = new ComposerViewElement();
				        cuentas.setIDBusiness("CCCRecargaCuentas");
				        cuentas.setDTOE(dtoOidC);
					listelem.addViewElement(cuentas);
				
				
				
				//Se llama al subsistema GestorCargaPantalla. 
	         	ConectorComposerView conector1 = new ConectorComposerView(listelem,this.getRequest());
	         	traza("conector creado");
	         	conector1.ejecucion();
	         	traza("ejecutado");
	         	DruidaConector conConsultar1 = conector1.getConector();
	         	traza("Obtener conConsultar");
	         		traza("dtoRecalmos = " +dtoReclamo);
				traza("Empresa cargamos");
				String fechaFormateada;
				
				asignar("COMBO","cbEmpresa", conConsultarTem,"SEGObtenerEmpresasPorPais","OID_SOCI",dtoReclamo.getOidEmpresa().toString());
	         		if(dtoReclamo.getOidBanco()!=null){
	         			traza("getOidBanco()!=null= " + dtoReclamo.getOidBanco());
	         			asignar("COMBO","cbBancoRecaudacion", conConsultarTem,"CCCObtieneBancos","OID_BANC",dtoReclamo.getOidBanco().toString());
	         		}else{
	         			traza("getOidBanco()==null");
	         			asignar("COMBO","cbBancoRecaudacion", conConsultarTem,"CCCObtieneBancos");}
	         		
	         		if(dtoReclamo.getOidSucursal()!=null){
	         			traza("getOidSucursal(()!=null =" + dtoReclamo.getOidSucursal());
					asignar("COMBO","cbSucursalRecaudacion", conConsultar1,"CCCRecargaSucursales","OID_SUCU",dtoReclamo.getOidSucursal().toString());
					traza("ComboDependiente sucursal");
				}else{
					traza("getOidSucursal(()==null");
					asignar("COMBO","cbSucursalRecaudacion", conConsultar1,"CCCRecargaSucursales");
					}
				if(dtoReclamo.getOidCuentaCorriente()!=null){
					traza("getOidCuentaCorriente !=null=" + dtoReclamo.getOidCuentaCorriente());
					asignar("COMBO","cbCuenta", conConsultar1,"CCCRecargaCuentas","OID_CUEN_CORR_BANC",dtoReclamo.getOidCuentaCorriente().toString());
					traza("ComboDependiente CCCRecargaCuentas");
				}else{
					traza("getOidCuentaCorriente==null");
					asignar("COMBO","cbCuenta", conConsultar1,"CCCRecargaCuentas");
					}
	         		
	         		
	         		traza("cargo el canal+++");
	         		asignar("COMBO","cbCanal", conConsultarTem,"SEGConsultaCanales","VAL_OID",dtoReclamo.getOidCanal().toString());
	         		
	         		if(dtoReclamo.getOidAcceso()!=null){
	         			traza("getOidAcceso !=null");	
	         			asignar("COMBO","cbAcceso", conConsultar1,"SEGObtenerAccesosPorCanal","VAL_OID",dtoReclamo.getOidAcceso().toString());
		         		
		         	
	         		}else{
	         			traza("getOidAcceso ==null");
	         			asignar("COMBO","cbAcceso", conConsultar1,"SEGObtenerAccesosPorCanal");
	         		}
	         		if(dtoReclamo.getOidSubacceso()!=null){//ACUERDATE QUE AQUI FALTA RELLENAR EL SUBACCESO
		         		traza("getOidSubacceso!= null   getOidSubacceso= "+ dtoReclamo.getOidSubacceso());
		         		//asignar("COMBO","cbSubacceso", conConsultar1,"SegObtenerSubaccesosPorAcceso");//,"OID_SBAC",dtoReclamo.getOidSubacceso().toString());
		         		asignar("COMBO","cbSubacceso", conConsultar1,"SegObtenerSubaccesosPorAcceso","OID_SBAC",dtoReclamo.getOidSubacceso().toString());
		         	}else{	
		         		traza("getOidSubacceso== null ");
		         		asignar("COMBO","cbSubacceso", conConsultar1,"SegObtenerSubaccesosPorAcceso");
	         		}
	         		
	         		if(dtoReclamo.getUsuarioGestorReclamoPrevisto()!=null){
	         			traza("getUsuarioGestorReclamoPrevisto!=null");
	         			asignar("COMBO","cbUsuarioGestorReclamoPrevisto", conConsultarTem,"MENObtenerCodUsuarios","IDPRINCIPAL",dtoReclamo.getUsuarioGestorReclamoPrevisto().toString());
					
				}else{
					traza("getUsuarioGestorReclamoPrevisto==null");
					asignar("COMBO","cbUsuarioGestorReclamoPrevisto", conConsultarTem,"MENObtenerCodUsuarios");
					
				}
					
				//este es obligatorio:
				if(dtoReclamo.getUsuarioGestorReclamoReal()!=null){
					//asignar("COMBO", "cbUsuarioGestorReclamoReal",dtoReclamo.getUsuarioGestorReclamoReal());
					traza("getUsuarioGestorReclamoReal!=null");
	         			asignar("COMBO","cbUsuarioGestorReclamoReal", conConsultarTem,"MENObtenerCodUsuarios","IDPRINCIPAL",dtoReclamo.getUsuarioGestorReclamoReal().toString());
					
				}else{
					traza("getUsuarioGestorReclamoReal==null");
					asignar("COMBO","cbUsuarioGestorReclamoReal", conConsultarTem,"MENObtenerCodUsuarios");
					
				}
	         		
	         //***************FALTAN ESTOS DOS INCIDENCIAS**********************							ATENCION||||
	         		if(dtoReclamo.getOidMotivoRechazoDesbloqueo()!=null){//BELC300009126	
					asignar("COMBO","cbCodigoSolucionRechazo", conConsultarTem,"RECObtenerMotivosRechazoDesbloqueo", "VAL_OID", dtoReclamo.getOidMotivoRechazoDesbloqueo().toString());
					traza("Cargado el MotivodeRechazoDesbloqueo");
					
				}else{
					traza("getOidMotivoRechazoDesbloqueo==null");
					asignar("COMBO","cbCodigoSolucionRechazo", conConsultarTem,"RECObtenerMotivosRechazoDesbloqueo");
				}
	         		
	         		if(dtoReclamo.getOidPeriodoReclamante()!=null){
					asignar("COMBO","cbPeriodoReclamante", conConsultar1,"SEGObtenerPeriodosPorCanal", "OID_PERI", dtoReclamo.getOidPeriodoReclamante().toString());
					traza("Cargado el getOidPeriodoReclamante");
					
				}else{
					traza("getgetOidPeriodoReclamante==null");
					asignar("COMBO","cbPeriodoReclamante", conConsultar1,"SEGObtenerPeriodosPorCanal");
				}
				
	traza("3");
				if(dtoReclamo.getOidSituacion()!=null){
					asignar("COMBO","cbSituacion", conConsultarTem,"CCCObtenerSituacionesReclamo","OID_SITU_RECL", dtoReclamo.getOidSituacion().toString());
					traza("Cargado el cbidSituacion ");
					
				}else{
					traza("getOidSituacion==null");
					asignar("COMBO","cbSituacion", conConsultarTem,"CCCObtenerSituacionesReclamo");
				}
				
				
				
			
			//***********Ponemos los datos del dtoreclamo en la pantalla	****************
			
				if(dtoReclamo.getNumeroIdentificacion()!=null){
					asignarAtributo("LABELC","lbldtNumIdentificacion","valor",dtoReclamo.getNumeroIdentificacion().toString());
				}
				
				if(dtoReclamo.getOidMedioPago()!=null){
					//asignar("COMBO","cbMedioPago", conConsultar,"BELObtenerMediosPagoCombo");
					asignar("COMBO","cbMedioPago", conConsultarTem,"BELObtenerMediosPagoCombo","OID_MEDI_PAGO",dtoReclamo.getOidMedioPago().toString());
					}else{   asignar("COMBO","cbMedioPago", conConsultarTem,"BELObtenerMediosPagoCombo");
						}
		traza("4");	
				if(dtoReclamo.getAnioCargoAbono()!=null){
					asignar("CTEXTO", "txtAnoCargoAbonoDirecto",dtoReclamo.getAnioCargoAbono()+"");
				}
	traza("6");
				if(dtoReclamo.getEjercicioCuota()!=null){
					asignar("CTEXTO", "textEjercicioCuota",dtoReclamo.getEjercicioCuota()+"");
				}
				traza("7");
				if(dtoReclamo.getFechaResolucionPrevista()!=null){//DATE
					fechaFormateada=UtilidadesBelcorp.fechaFormateada(dtoReclamo.getFechaResolucionPrevista(), 
															UtilidadesSession.getFormatoFecha(this));
					asignar("CTEXTO", "textFechaResolucionReclamoPrevista",fechaFormateada);
				}
	traza("8");
				
	
				if(dtoReclamo.getFicheroDocumentoAdjunto()!=null){
					asignar("CTEXTO", "textFicheroDocAdjunto",dtoReclamo.getFicheroDocumentoAdjunto());
				}
				if(dtoReclamo.getImporteReclamado()!=null){
					BigDecimal importeBig=new BigDecimal(dtoReclamo.getImporteReclamado().doubleValue()+0.0001);				 
					String ImporteFormateado=formatearImporte(importeBig,separadorMiles.charAt(0),separadorDecimales.charAt(0));
					asignar("CTEXTO", "textImporteReclamado",ImporteFormateado);
				}
				
				//if(dtoReclamo.getImporteReclamado()!=null){
				//	asignar("CTEXTO", "textImporteReclamado",dtoReclamo.getImporteReclamado()+"");
				//}
				
				
		traza("9");		
				if(dtoReclamo.getNumeroIdentificadorCuota()!=null){
					asignar("CTEXTO", "textNumeroIdentificadorCuota",dtoReclamo.getNumeroIdentificadorCuota()+"");
				}
				
				if(dtoReclamo.getNumeroOrdenCuota()!=null){
					asignar("CTEXTO", "textNumeroOrdenCuota",dtoReclamo.getNumeroOrdenCuota()+"");
				}
				
				if(dtoReclamo.getObservacionesAreaReclamos()!=null){
					//asignar("AREATEXTO", "textObservacionesAreaReclamos",dtoReclamo.getObservacionesAreaReclamos());
					asignarAtributoElemento("textObservacionesAreaReclamos","valor",dtoReclamo.getObservacionesAreaReclamos()+"");
				}
				traza("10");		
				if(dtoReclamo.getObservacionesClienteReclamante()!=null){
					//asignar("AREATEXTO", "textObservacionesClienteReclamante",dtoReclamo.getObservacionesClienteReclamante());
					asignarAtributoElemento("textObservacionesClienteReclamante","valor",dtoReclamo.getObservacionesClienteReclamante()+"");
				}
				
		traza("11");	
				if(dtoReclamo.getCodigoClienteReclamante()!=null){
					asignar("CTEXTO", "textCodigoClienteReclamante",dtoReclamo.getCodigoClienteReclamante()+"");
				}
				
				if(dtoReclamo.getFechaValor()!=null){
					fechaFormateada=UtilidadesBelcorp.fechaFormateada(dtoReclamo.getFechaValor(), 
													 UtilidadesSession.getFormatoFecha(this));						
					asignar("CTEXTO", "textFechaValor",fechaFormateada+"");
				}
				if(dtoReclamo.getFechaDocumento()!=null){//DATE
					fechaFormateada=UtilidadesBelcorp.fechaFormateada(dtoReclamo.getFechaDocumento(), 
														 UtilidadesSession.getFormatoFecha(this));						
					//asignar("CTEXTO", "lbldtFechaDoc",fechaFormateada);
					asignarAtributo("LABELC","lbldtFechaDoc","valor",fechaFormateada);
				}
		traza("12");		
				if(dtoReclamo.getMes()!=null){
					//asignar("LABELC", "lbldtMes",dtoReclamo.getPeriodoMes());
					asignarAtributo("LABELC","lbldtMes","valor",dtoReclamo.getMes());
				}
		traza("12.5");		
				
				if(dtoReclamo.getUsuarioSolicitante()!=null){
					//asignar("LABELC", "lblUsuarioSolicitantedt",dtoReclamo.getUsuarioSolicitante());
					asignarAtributo("LABELC","lblUsuarioSolicitantedt","valor",dtoReclamo.getUsuarioSolicitante());
				}
				traza("12.6");
				if(dtoReclamo.getFechaResolucionReal()!=null){//DATE
					fechaFormateada=UtilidadesBelcorp.fechaFormateada(dtoReclamo.getFechaResolucionReal(), 
															 UtilidadesSession.getFormatoFecha(this));				
						asignar("CTEXTO", "txtFechaResolucionReclamoReal",fechaFormateada);
				}
				traza("12.7");
				
				//Modificado por inc. 19074.
				//El anio ahora viene con 2 digitos.
				//if(dtoReclamo.getAnio()!=null){
				//	asignar("LABELC", "lbldtAño",dtoReclamo.getAnio().substring(2,4));
				//}

				traza("12.6");
				//campos de la capa iferior*******************************************************
				/*if(dtoReclamo.getOidMotivoRechazoDesbloqueo()!=null){
					asignar("VAR", "motivocb", dtoReclamo.getOidBanco().toString());
				}*/
				if(dtoReclamo.getNumeroCargoAbono()!=null){
					asignar("CTEXTO", "txtNumCargoAbonoDirecto",dtoReclamo.getNumeroCargoAbono()+"");
				}
				if(dtoReclamo.getMesCargoAbono()!=null){
					asignar("CTEXTO", "txtMesCargoAbonoDirecto",dtoReclamo.getMesCargoAbono());
				}
				if(dtoReclamo.getObservacionesResolucionReclamos()!=null){
						//asignar("AREATEXTO", "atxtObservacionesResolucionReclamos",dtoReclamo.getObservacionesResolucion());
						asignarAtributoElemento("atxtObservacionesResolucionReclamos","valor",dtoReclamo.getObservacionesResolucionReclamos()+"");
		
				}
         	  		
         	  		
         	  		
         	  		traza("DISABLED");
				//se deshabilitan los campos.
				asignarAtributoElemento("cbCanal","disabled","S");								
				asignarAtributoElemento("cbAcceso","disabled","S");								
				asignarAtributoElemento("cbBancoRecaudacion","disabled","S");
				asignarAtributoElemento("cbCuenta","disabled","S");
				asignarAtributoElemento("cbMedioPago","disabled","S");
				asignarAtributoElemento("cbCodigoSolucionRechazo","disabled","S");
				asignarAtributoElemento("cbPeriodoReclamante","disabled","S");
				asignarAtributoElemento("cbSituacion","disabled","S");
				asignarAtributoElemento("cbSubacceso","disabled","S");
				asignarAtributoElemento("cbSucursalRecaudacion","disabled","S");
				asignarAtributoElemento("cbEmpresa","disabled","S");
				asignarAtributoElemento("txtAnoCargoAbonoDirecto","disabled","S");
				asignarAtributoElemento("textEjercicioCuota","disabled","S");
				asignarAtributoElemento("textFechaResolucionReclamoPrevista","disabled","S");
				asignarAtributoElemento("txtFechaResolucionReclamoReal","disabled","S");
				asignarAtributoElemento("textFechaValor","disabled","S");
				asignarAtributoElemento("textFicheroDocAdjunto","disabled","S");
				asignarAtributoElemento("textImporteReclamado","disabled","S");
				asignarAtributoElemento("txtNumCargoAbonoDirecto","disabled","S");
				asignarAtributoElemento("textNumeroIdentificadorCuota","disabled","S");
				asignarAtributoElemento("textNumeroOrdenCuota","disabled","S");
				asignarAtributoElemento("textNumeroSerieCuota","disabled","S");
				asignarAtributoElemento("textObservacionesAreaReclamos","disabled","S");
				asignarAtributoElemento("textObservacionesClienteReclamante","disabled","S");
				asignarAtributoElemento("atxtObservacionesResolucionReclamos","disabled","S");
				asignarAtributoElemento("txtMesCargoAbonoDirecto","disabled","S");
				asignarAtributoElemento("textCodigoClienteReclamante","disabled","S");
				asignarAtributoElemento("textFechaDocumento","disabled","S");
				asignarAtributoElemento("cbUsuarioGestorReclamoPrevisto","disabled","S");
				asignarAtributoElemento("cbUsuarioGestorReclamoReal","disabled","S");	
				//atencion  cambio peligroso
				asignarAtributoElemento("imgBuscarCliente","disabled","S");
			
			
			
			}//consultarbtm
			
			if(this.accion.equals("modificar_btn")){
				this.casoUso = "modificar"; 
                    pagina("contenido_reclamos_insertar");

					traza("nuevas constantes");
					asignar("VAR","consSOLICITADO",CCCConstantes.RECLAMO_SITUACION_SOLICITADO.toString());
					asignar("VAR","consEN_PROCESO",CCCConstantes.RECLAMO_SITUACION_EN_PROCESO.toString());
					asignar("VAR","consRESUELTO",CCCConstantes.RECLAMO_SITUACION_RESUELTO.toString());
					asignar("VAR","consRECHAZADO",CCCConstantes.RECLAMO_SITUACION_RECHAZADO.toString());								


         	  		asignar("VAR", "idioma", idioma.toString());
         	  		traza("->Idioma : "+idioma);
         	  		asignar("VAR", "pais", pais.toString());	
         	  		traza("->Pais : "+pais);
		  		asignar("VAR", "casoUso", "modificar");

				Byte longitud = this.obtenerLongitudCodigoCliente();
				Long longitudCodigoCliente = new Long(longitud.longValue());
				asignar("VAR","longitudCodigoCliente",longitudCodigoCliente.toString());	
				
				// Fecha:
				this.generarHiddenFormatoFecha();
				
				
	                        // Numeros:
	                        String separadorDecimales = UtilidadesSession.getSeparadorDecimales(this);
				String separadorMiles = ",";
				if (separadorDecimales.equals(",")){
					separadorMiles = ".";
				}
				asignar("VAR","hid_SeparadorMiles", separadorMiles);
				asignar("VAR","hid_NumeroDecimales",UtilidadesSession.getFormatoNumerico(this));
				asignar("VAR","hid_SeparadorDecimales", separadorDecimales);
				  		  					
				asignarAtributo("VAR","casoUso","valor","modificar");
				asignarAtributo("PAGINA","contenido_reclamos_insertar","cod","0533");	
				asignarAtributo("PAGINA","contenido_reclamos_insertar","msgle","Modificar reclamos");	
				getConfiguracionMenu("LPMantenimientoReclamos", "ModificarPopup");
				
			
			
				traza("oidRecibido String: "+conectorParametroLimpia("oidSeleccionado", "", true));			
				Long oidRecibido=new Long(conectorParametroLimpia("oidSeleccionado", "", true));
				traza("oidRecibido : "+oidRecibido);
				asignar("VAR","oid", oidRecibido.toString());
				
				Vector paramConector = new Vector();
				DTOOID dtoOid=new DTOOID();
				dtoOid.setOidIdioma(idioma);
				dtoOid.setOidPais(pais);
				dtoOid.setOid(oidRecibido);
				paramConector.add(dtoOid);
				paramConector.add(new MareBusinessID("CCCObtenerReclamo"));          
				traza("Antes de Conectar");
				DruidaConector conector = conectar("ConectorObtenerReclamo", paramConector);							
				traza("Despues de Conectar");
				Object objeto=conector.objeto("DTOReclamo");
				traza("Objeto recogido"+objeto);
				DTOReclamo  dtoReclamo = (DTOReclamo)conector.objeto("DTOReclamo");	
				traza("DTOReclamo obtenido " +dtoReclamo);
				asignar("VAR", "oid", oidRecibido.toString());	
				
				cargarCombos(new Boolean(true), new Boolean(true));
				int banderaFecha=1;
				traza("El oid situacion es: " + dtoReclamo.getOidSituacion().toString());
				traza("Resuelto es:" + CCCConstantes.RECLAMO_SITUACION_RESUELTO);
				traza("Rechazado es:" + CCCConstantes.RECLAMO_SITUACION_RECHAZADO);
				if(!(dtoReclamo.getOidSituacion().toString().equals(CCCConstantes.RECLAMO_SITUACION_RESUELTO)) && 
					!(dtoReclamo.getOidSituacion().toString().equals(CCCConstantes.RECLAMO_SITUACION_RECHAZADO ))) 
				{ 	
					traza("Entra en if");
					asignarAtributoElemento("cbCodigoSolucionRechazo","disabled","S");
					asignarAtributoElemento("txtMesCargoAbonoDirecto","disabled","S");
					asignarAtributoElemento("txtAnoCargoAbonoDirecto","disabled","S");
					asignarAtributoElemento("txtNumCargoAbonoDirecto","disabled","S");
					asignarAtributoElemento("cbUsuarioGestorReclamoReal","disabled","S");
					asignarAtributoElemento("txtFechaResolucionReclamoReal","disabled","S");
					
					asignarAtributoElemento("atxtObservacionesResolucionReclamos","disabled","S");
					banderaFecha=0;
					asignar("VAR", "activDesact", "1");
					traza("elemento asignado : activDesact=1");
					//cuando se desabilita el campo se pone a cero incidencia BEL10298
					//solo se deja activo el de situacion
					//-Si ( situacion==CCCConstantes.RECLAMO_SITUACION_RESUELTO || 
					//situacion==CCCConstantes.RECLAMO_SITUACION_RECHAZADO ) 
					//Se habilitan todos los campos de entrada de la capa: 
					//"PantallaResolucionReclamo". En caso contrario solo estará habilitado 
					//el combo "situacion".  
				}
			
				//los combos estan cargados , solo hay que poner el valor que habia antes:
				
				ComposerViewElementList listelem = new ComposerViewElementList();
				DTOBelcorp dto = new DTOBelcorp();
			        dto.setOidPais(this.pais);
			        dto.setOidIdioma(this.idioma);
			        
			        traza("this.pais "+this.pais);
	         	  	traza("this.idioma "+this.idioma);
	         	  	
			        
			        	DTOAccesosPorCanal dtoA = new DTOAccesosPorCanal();
			        	dtoA.setOidCanal(dtoReclamo.getOidCanal());
			        	dtoA.setOidPais(this.pais);
			        	dtoA.setOidIdioma(this.idioma);
			        	
			         	ComposerViewElement acceso = new ComposerViewElement();
			         	acceso.setIDBusiness("SEGObtenerAccesosPorCanal");
			         	acceso.setDTOE(dtoA);
					listelem.addViewElement(acceso);
					traza("Elemento acceso");
				
				
				
					DTOOID dtoOidA= new DTOOID();
					dtoOidA.setOid(dtoReclamo.getOidAcceso());
				        dtoOidA.setOidPais(this.pais);
				        dtoOidA.setOidIdioma(this.idioma);
				       
				        ComposerViewElement sub = new ComposerViewElement();
			         	sub.setIDBusiness("SegObtenerSubaccesosPorAcceso");
			         	sub.setDTOE(dtoOidA);
					listelem.addViewElement(sub);
					traza("Elemento sub");
				
				if(dtoReclamo.getOidPeriodoReclamante()!=null){//RECIENdeSCOMENTADO
					DTOOID dtoOidP= new DTOOID();
					dtoOidP.setOid(dtoReclamo.getOidCanal());
				     	dtoOidP.setOidPais(this.pais);
				     	dtoOidP.setOidIdioma(this.idioma);
				      
					ComposerViewElement periodo = new ComposerViewElement();
			        	periodo.setIDBusiness("SEGObtenerPeriodosPorCanal");
			        	periodo.setDTOE(dtoOidP);
					listelem.addViewElement(periodo);
					traza("Elemento periodo");
				}
				
				
				
					DTOOID dtoOidS= new DTOOID();
					dtoOidS.setOid(dtoReclamo.getOidBanco());
					dtoOidS.setOidPais(this.pais);
					dtoOidS.setOidIdioma(this.idioma);
					ComposerViewElement Sucursal = new ComposerViewElement();
				        Sucursal.setIDBusiness("CCCRecargaSucursales");
				        Sucursal.setDTOE(dtoOidS);
					listelem.addViewElement(Sucursal);
				
				
				
					DTOOID dtoOidC= new DTOOID();
					dtoOidC.setOid(dtoReclamo.getOidSucursal());
					dtoOidC.setOidPais(this.pais);
					dtoOidC.setOidIdioma(this.idioma);
					ComposerViewElement cuentas = new ComposerViewElement();
				        cuentas.setIDBusiness("CCCRecargaCuentas");
				        cuentas.setDTOE(dtoOidC);
					listelem.addViewElement(cuentas);
				
				
				
				//Se llama al subsistema GestorCargaPantalla. 
	         	ConectorComposerView conector1 = new ConectorComposerView(listelem,this.getRequest());
	         	traza("conector creado");
	         	conector1.ejecucion();
	         	traza("ejecutado");
	         	DruidaConector conConsultar1 = conector1.getConector();
	         	traza("Obtener conConsultar");
	         		traza("dtoRecalmos = " +dtoReclamo);
				traza("Empresa cargamos");
				asignar("COMBO","cbEmpresa", conConsultarTem,"SEGObtenerEmpresasPorPais","OID_SOCI",dtoReclamo.getOidEmpresa().toString());
	         		if(dtoReclamo.getOidBanco()!=null){
	         			traza("getOidBanco()!=null"+ dtoReclamo.getOidBanco().toString());
	         			asignar("COMBO","cbBancoRecaudacion", conConsultarTem,"CCCObtieneBancos","OID_BANC",dtoReclamo.getOidBanco().toString());
	         		}else{
	         			traza("getOidBanco()==null");
	         			asignar("COMBO","cbBancoRecaudacion", conConsultarTem,"CCCObtieneBancos");}
	         		
	         		if(dtoReclamo.getOidSucursal()!=null){
	         			traza("getOidSucursal(()!=null" +dtoReclamo.getOidSucursal().toString());
					asignar("COMBO","cbSucursalRecaudacion", conConsultar1,"CCCRecargaSucursales","OID_SUCU",dtoReclamo.getOidSucursal().toString());
					traza("ComboDependiente sucursal");
				}else{
					traza("getOidSucursal(()==null");
					asignar("COMBO","cbSucursalRecaudacion", conConsultar1,"CCCRecargaSucursales");
					}
				if(dtoReclamo.getOidCuentaCorriente()!=null){
					traza("getOidCuentaCorriente !=null" +dtoReclamo.getOidCuentaCorriente().toString());
					asignar("COMBO","cbCuenta", conConsultar1,"CCCRecargaCuentas","OID_CUEN_CORR_BANC",dtoReclamo.getOidCuentaCorriente().toString());
					traza("ComboDependiente CCCRecargaCuentas");
				}else{
					traza("getOidCuentaCorriente==null");
					asignar("COMBO","cbCuenta", conConsultar1,"CCCRecargaCuentas");
					}
	         		
	         		
	         		traza("cargo el canal+++" +dtoReclamo.getOidCanal().toString());
	         		asignar("COMBO","cbCanal", conConsultarTem,"SEGConsultaCanales","VAL_OID",dtoReclamo.getOidCanal().toString());
	         		
	         		if(dtoReclamo.getOidAcceso()!=null){
	         			traza("getOidAcceso !=null"+dtoReclamo.getOidAcceso().toString());	
	         			asignar("COMBO","cbAcceso", conConsultar1,"SEGObtenerAccesosPorCanal","VAL_OID",dtoReclamo.getOidAcceso().toString());
		         		
		         	
	         		}else{
	         			traza("getOidAcceso ==null");
	         			asignar("COMBO","cbAcceso", conConsultar1,"SEGObtenerAccesosPorCanal");
	         		}
	         		if(dtoReclamo.getOidSubacceso()!=null){//ACUERDATE QUE AQUI FALTA RELLENAR EL SUBACCESO
		         		traza("getOidSubacceso!= null   getOidSubacceso= "+ dtoReclamo.getOidSubacceso());
		         		//asignar("COMBO","cbSubacceso", conConsultar1,"SegObtenerSubaccesosPorAcceso");//,"OID_SBAC",dtoReclamo.getOidSubacceso().toString());
		         		asignar("COMBO","cbSubacceso", conConsultar1,"SegObtenerSubaccesosPorAcceso","OID_SBAC",dtoReclamo.getOidSubacceso().toString());
		         	}else{	
		         		traza("getOidSubacceso== null ");
		         		asignar("COMBO","cbSubacceso", conConsultar1,"SegObtenerSubaccesosPorAcceso");
	         		}
	         		
	         		if(dtoReclamo.getUsuarioGestorReclamoPrevisto()!=null){
	         			traza("getUsuarioGestorReclamoPrevisto!=null" +dtoReclamo.getUsuarioGestorReclamoPrevisto().toString());
	         			asignar("COMBO","cbUsuarioGestorReclamoPrevisto", conConsultarTem,"MENObtenerCodUsuarios","IDPRINCIPAL",dtoReclamo.getUsuarioGestorReclamoPrevisto().toString());
					
				}else{
					traza("getUsuarioGestorReclamoPrevisto==null");
					asignar("COMBO","cbUsuarioGestorReclamoPrevisto", conConsultarTem,"MENObtenerCodUsuarios");
					
				}
					
				//este es obligatorio:
				int usuarioPuesto=0;
				if(dtoReclamo.getUsuarioGestorReclamoReal()!=null){
					//asignar("COMBO", "cbUsuarioGestorReclamoReal",dtoReclamo.getUsuarioGestorReclamoReal());
					traza("getUsuarioGestorReclamoReal!=null");
	         			asignar("COMBO","cbUsuarioGestorReclamoReal", conConsultarTem,"MENObtenerCodUsuarios","IDPRINCIPAL",dtoReclamo.getUsuarioGestorReclamoReal().toString());
	         			usuarioPuesto=1;
					
				}else{
					traza("getUsuarioGestorReclamoReal==null");
					asignar("COMBO","cbUsuarioGestorReclamoReal", conConsultarTem,"MENObtenerCodUsuarios");
					
				}
	         		
	          //***************FALTAN ESTOS DOS INCIDENCIAS**********************							ATENCION||||
	         		if(dtoReclamo.getOidMotivoRechazoDesbloqueo()!=null){//BELC300009126	
					asignar("COMBO","cbCodigoSolucionRechazo", conConsultarTem,"RECObtenerMotivosRechazoDesbloqueo", "VAL_OID", dtoReclamo.getOidMotivoRechazoDesbloqueo().toString());
					traza("Cargado el MotivodeRechazoDesbloqueo");
					
				}else{
					traza("getOidMotivoRechazoDesbloqueo==null");
					asignar("COMBO","cbCodigoSolucionRechazo", conConsultarTem,"RECObtenerMotivosRechazoDesbloqueo");
				}
	         		
	         		if(dtoReclamo.getOidPeriodoReclamante()!=null){
					asignar("COMBO","cbPeriodoReclamante", conConsultar1,"SEGObtenerPeriodosPorCanal", "OID_PERI", dtoReclamo.getOidPeriodoReclamante().toString());
					traza("Cargado el getOidPeriodoReclamante");
					
				}else{
					traza("getOidMotivoRechazoDesbloqueo==null");
					asignar("COMBO","cbPeriodoReclamante", conConsultar1,"SEGObtenerPeriodosPorCanal");
				}
				
	traza("3");
				if(dtoReclamo.getOidSituacion()!=null){
					asignar("COMBO","cbSituacion", conConsultarTem,"CCCObtenerSituacionesReclamo","OID_SITU_RECL", dtoReclamo.getOidSituacion().toString());
					traza("Cargado el cbidSituacion ");
					
				}else{
					traza("getOidSituacion==null");
					asignar("COMBO","cbSituacion", conConsultarTem,"CCCObtenerSituacionesReclamo");
				}
				
	         		
				
			
			//***********Ponemos los datos del dtoreclamo en la pantalla	****************
			
				if(dtoReclamo.getNumeroIdentificacion()!=null){
					asignarAtributo("LABELC","lbldtNumIdentificacion","valor",dtoReclamo.getNumeroIdentificacion().toString());
					asignar("VAR","nIdentificacion",dtoReclamo.getNumeroIdentificacion().toString());
				}
				
				
				if(dtoReclamo.getOidMedioPago()!=null){
					//asignar("COMBO","cbMedioPago", conConsultar,"BELObtenerMediosPagoCombo");
					asignar("COMBO","cbMedioPago", conConsultarTem,"BELObtenerMediosPagoCombo","OID_MEDI_PAGO",dtoReclamo.getOidMedioPago().toString());
					}else{   asignar("COMBO","cbMedioPago", conConsultarTem,"BELObtenerMediosPagoCombo");
						}
				traza("2");
				
	
				
				traza("4");
				
				if(dtoReclamo.getAnioCargoAbono()!=null){
					asignar("CTEXTO", "txtAnoCargoAbonoDirecto",dtoReclamo.getAnioCargoAbono()+"");
				}
	traza("6");
				if(dtoReclamo.getEjercicioCuota()!=null){
					asignar("CTEXTO", "textEjercicioCuota",dtoReclamo.getEjercicioCuota()+"");
				}
				traza("7");
				if(dtoReclamo.getFechaResolucionPrevista()!=null){//DATE
					String fechaFormateada=UtilidadesBelcorp.fechaFormateada(dtoReclamo.getFechaResolucionPrevista(), 
															UtilidadesSession.getFormatoFecha(this));
					asignar("CTEXTO", "textFechaResolucionReclamoPrevista",fechaFormateada);
				}
	traza("8");
				
	
				if(dtoReclamo.getFicheroDocumentoAdjunto()!=null){
					asignar("CTEXTO", "textFicheroDocAdjunto",dtoReclamo.getFicheroDocumentoAdjunto());
				}
				
				if(dtoReclamo.getImporteReclamado()!=null){
					BigDecimal importeBig=new BigDecimal(dtoReclamo.getImporteReclamado().doubleValue()+0.0001);				 
					String ImporteFormateado=formatearImporte(importeBig,separadorMiles.charAt(0),separadorDecimales.charAt(0));
					asignar("CTEXTO", "textImporteReclamado",ImporteFormateado);
				}
				
		traza("9");		
				if(dtoReclamo.getNumeroIdentificadorCuota()!=null){
					asignar("CTEXTO", "textNumeroIdentificadorCuota",dtoReclamo.getNumeroIdentificadorCuota()+"");
				}
				
				if(dtoReclamo.getNumeroOrdenCuota()!=null){
					asignar("CTEXTO", "textNumeroOrdenCuota",dtoReclamo.getNumeroOrdenCuota()+"");
				}
				
				if(dtoReclamo.getObservacionesAreaReclamos()!=null){
					//asignar("AREATEXTO", "textObservacionesAreaReclamos",dtoReclamo.getObservacionesAreaReclamos());
					asignarAtributoElemento("textObservacionesAreaReclamos","valor",dtoReclamo.getObservacionesAreaReclamos()+"");
				}
				traza("10");		
				if(dtoReclamo.getObservacionesClienteReclamante()!=null){
					//asignar("AREATEXTO", "textObservacionesClienteReclamante",dtoReclamo.getObservacionesClienteReclamante());
					asignarAtributoElemento("textObservacionesClienteReclamante","valor",dtoReclamo.getObservacionesClienteReclamante()+"");
				}
				
		traza("11");	
				if(dtoReclamo.getCodigoClienteReclamante()!=null){
					asignar("CTEXTO", "textCodigoClienteReclamante",dtoReclamo.getCodigoClienteReclamante()+"");
				}
				
				if(dtoReclamo.getFechaValor()!=null){
					String fechaFormateada1=UtilidadesBelcorp.fechaFormateada(dtoReclamo.getFechaValor(), 
														 UtilidadesSession.getFormatoFecha(this));
					asignar("CTEXTO", "textFechaValor",fechaFormateada1+"");
				}
				if(dtoReclamo.getFechaDocumento()!=null){//DATE
					String fechaFormateada=UtilidadesBelcorp.fechaFormateada(dtoReclamo.getFechaDocumento(), 
														 UtilidadesSession.getFormatoFecha(this));						
					asignarAtributo("LABELC","lbldtFechaDoc","valor",fechaFormateada);
					asignar("VAR","fecdoc",fechaFormateada);
					
				}
				
		traza("12");		
				if(dtoReclamo.getMes()!=null){
					asignarAtributo("LABELC","lbldtMes","valor",dtoReclamo.getMes());
					asignar("VAR","hPeriodoMes",dtoReclamo.getMes().toString());
				}
				
				
				if(dtoReclamo.getUsuarioSolicitante()!=null){
					asignarAtributo("LABELC","lblUsuarioSolicitantedt","valor",dtoReclamo.getUsuarioSolicitante());
					asignar("VAR","hUsuarioSolicitante",dtoReclamo.getUsuarioSolicitante().toString());
				}
				int fechaPuesta=0;
				if(dtoReclamo.getFechaResolucionReal()!=null){//DATE
					String fechaFormateada=UtilidadesBelcorp.fechaFormateada(dtoReclamo.getFechaResolucionReal(), 
															 UtilidadesSession.getFormatoFecha(this));				
						asignar("CTEXTO", "txtFechaResolucionReclamoReal",fechaFormateada);
						fechaPuesta=1;
						traza("pongo la fecha resolucion reclamo real "+ fechaFormateada);
				}
				
				
				if(dtoReclamo.getAnio()!=null){

					//Modificado por inc. 19074.
					//El anio ahora viene con 2 digitos.
					//asignar("LABELC", "lbldtAño",dtoReclamo.getAnio().substring(2,4));
					asignar("VAR","hAnyo",dtoReclamo.getAnio().toString());
				}
				//campos de la capa iferior*******************************************************
				
				if(dtoReclamo.getNumeroCargoAbono()!=null){
					asignar("CTEXTO", "txtNumCargoAbonoDirecto",dtoReclamo.getNumeroCargoAbono()+"");
				}
				if(dtoReclamo.getMesCargoAbono()!=null){
					asignar("CTEXTO", "txtMesCargoAbonoDirecto",dtoReclamo.getMesCargoAbono());
				}
				if(dtoReclamo.getObservacionesResolucionReclamos()!=null){
						//asignar("AREATEXTO", "atxtObservacionesResolucionReclamos",dtoReclamo.getObservacionesResolucion());
					asignarAtributoElemento("atxtObservacionesResolucionReclamos","valor",dtoReclamo.getObservacionesResolucionReclamos()+"");
		
				}
				//incidencia 10298
				if(banderaFecha==1){//quiere decir que esta habilitado el campo 
					if(fechaPuesta==0){
						traza("txtFechaResolucionReclamoReal HABILITADO Y VACIO");
						//si ese campo esta vacio se pone la fecha del sistema.
						String fechaReal = UtilidadesBelcorp.fechaFormateada(new java.util.Date(), UtilidadesSession.getFormatoFecha(this));
						asignar("CTEXTO", "txtFechaResolucionReclamoReal",fechaReal);	
					}
					if(usuarioPuesto==0){
						traza("cbUsuarioGestorReclamoReal HABILITADO Y VACIO");
						//si este cambio esta vacio se pone el usuario el sistema
						String usuarioActivo = UtilidadesSession.getIdUsuario(this);//sacamos el usuario del sistema
						asignar("COMBO","cbUsuarioGestorReclamoReal", conConsultarTem,"MENObtenerCodUsuarios","CODUSER",usuarioActivo);
					}
				}
							/*String fechaD = UtilidadesBelcorp.fechaFormateada(new java.util.Date(), UtilidadesSession.getFormatoFecha(this));
							asignarAtributo("LABELC","lbldtFechaDoc","valor",fechaD);
							asignar("VAR","fecdoc", fechaD);
							 traza ("despues de asignarla fechaD");
							//en usuarioSolicitante ponemos el código de usuario del usuario 
							//actual del sistema, cogiendolo de la sesión. 
							String usuario = UtilidadesSession.getIdUsuario(this);
							asignarAtributo("LABELC", "lblUsuarioSolicitantedt", "valor" , usuario);
										*/
				
				
		}//if modificarboton"
			
			//Menú Secundario
                        if(this.accion.equals("guardar_menu_sec")){
                        	pagina("salidaGenerica");
                        	traza("ESTAMOS EN GUARDAR MENU SECUNDARIO : "+accion);	
                        	this.accion = conectorParametroLimpia("accion", "", true);
				
				Long idioma = UtilidadesSession.getIdioma(this);
				traza("accion : "+accion);
				//asignar("VAR", "idioma", idioma.toString());
				Long pais = UtilidadesSession.getPais(this);
				//asignar("VAR", "pais", pais.toString());
				
				// Numeros:
	                        String separadorDecimales = UtilidadesSession.getSeparadorDecimales(this);
				String separadorMiles = ",";
				if (separadorDecimales.equals(",")){
					separadorMiles = ".";
				}
				//asignar("VAR","hid_SeparadorMiles", separadorMiles);
				//asignar("VAR","hid_NumeroDecimales",UtilidadesSession.getFormatoNumerico(this));
				//asignar("VAR","hid_SeparadorDecimales", separadorDecimales);
				
				////Menú Secundario                                                          
				//Si accion="guardar_menu_sec"{                                              
				                                                                      
				//Cargamos el DTOReclamo con los datos de la pantalla                        
				//"PantallaReclamos".                                                        
				                                                                       
				//Si el campo oculto "oid" es distinto de null entonces se trata de una      
				//modificación por tanto debemos cargar también los campos de la pantalla    
				//(capa) "PantallaResolucionReclamo".                                        
				                                                                         
				//-Llamamos al conector "ConectorGuardarReclamo" pasándole los parámetros:   
				//idBusiness="CCCGuardarReclamo"                                             
				//DTOReclamo.}                                                             
				                                                                       

				DTOReclamo dtor = new DTOReclamo();
				dtor.setOidPais(this.pais);
				dtor.setOidIdioma(this.idioma);
				
				
				traza("Por VARS");
				traza("anio:"+conectorParametroLimpia("hAnyo", "", true));
				traza("mes:"+conectorParametroLimpia("hPeriodoMes", "", true));
				traza("num iden:"+conectorParametroLimpia("nIdentificacion", "", true));
				traza("fec doc:"+conectorParametroLimpia("fecdoc", "", true));
				
				if(!conectorParametroLimpia("fecdoc", "", true).equals("")){ 
					StringTokenizer st= new StringTokenizer(conectorParametroLimpia("fecdoc", "", true),"/");
					int tamano=st.countTokens();
					String[] dat=new String[tamano];
					traza("****tamano= "+ tamano);
					for(int x=0;x<tamano;x++){
						dat[x]=(String)st.nextElement();
						traza("****dat[x]= " +dat[x]);
					}

					//Agregado por inc. 19074.
					if (dat[2] != null && dat[2].length() > 2){
						dat[2] = dat[2].substring(2, 4);
					}

					traza("dat yo Creo final = " +dat[2]);
				
					if(!dat[2].equals("")){ //rellenamos el anio aqui dentro, siempre entrara ya que fecDoc es obligatorio
 						dtor.setAnio(dat[2]);	
					}	
					traza("Por setAnio" +dtor.getAnio());
					traza("NumeroIdentificacion:"+conectorParametroLimpia("nIdentificacion", "", true));
				}
				if(!conectorParametroLimpia("nIdentificacion", "", true).equals("")){         
 					dtor.setNumeroIdentificacion(new Integer(conectorParametroLimpia("nIdentificacion", "", true)));
 				}
 				
				traza("lbldtMes:"+conectorParametroLimpia("hPeriodoMes", "", true));
				if(!conectorParametroLimpia("hPeriodoMes", "", true).equals("")){ 
					dtor.setMes(new String(conectorParametroLimpia("hPeriodoMes", "", true)));
				}
				traza("Antes de buscar el parametro");
				if(!conectorParametroLimpia("textFechaValor","",true).equals("")){ 
					traza("dentro del parametro");
					
					String fechaValor = conectorParametroLimpia("textFechaValor","",true);
					traza("Formato de fecha: "+ UtilidadesSession.getFormatoFecha(this));
					Date fechaValor1 = UtilidadesBelcorp.getDatefromSICCStringFormat(fechaValor, UtilidadesSession.getFormatoFecha(this)); 
					traza("fechaReclamoReal(Valor): "+fechaValor1);
					traza("guardar_menu_sec:" + fechaValor1);
					dtor.setFechaValor(fechaValor1);
				}	
				traza("fecdoc:"+conectorParametroLimpia("fecdoc", "", true));
				if(!conectorParametroLimpia("fecdoc", "", true).equals("")){ 
					String fechaDoc = conectorParametroLimpia("fecdoc","",true);
					traza("Formato de fecha: "+ UtilidadesSession.getFormatoFecha(this));
					Date fechaDocumento = UtilidadesBelcorp.getDatefromSICCStringFormat(fechaDoc, UtilidadesSession.getFormatoFecha(this)); 
					traza("(dtosetFechaDocumento): "+fechaDocumento);
					dtor.setFechaDocumento(fechaDocumento);
				}
				if(!conectorParametroLimpia("cbEmpresa", "", true).equals("")){ 
					dtor.setOidEmpresa(new Long(conectorParametroLimpia("cbEmpresa", "", true)));
				}
				if(!conectorParametroLimpia("cbCanal", "", true).equals("")){ 
					dtor.setOidCanal(new Long(conectorParametroLimpia("cbCanal", "", true)));
				}
				if(!conectorParametroLimpia("cbAcceso", "", true).equals("")){ 
					dtor.setOidAcceso(new Long(conectorParametroLimpia("cbAcceso", "", true)));
				}
				if(!conectorParametroLimpia("cbSubacceso", "", true).equals("")){ 
					dtor.setOidSubacceso(new Long(conectorParametroLimpia("cbSubacceso", "", true)));
				}
				traza("Codigo cliente"+conectorParametroLimpia("textCodigoClienteReclamante", "", true));
				if(!conectorParametroLimpia("textCodigoClienteReclamante", "", true).equals("")){ 
					dtor.setCodigoClienteReclamante(new String(conectorParametroLimpia("textCodigoClienteReclamante", "", true)));
				}
				// QUITAR ESTO CUANDO SE CARGA COMBO!!!
				//dtor.setOidSituacion(new Long("1"));		
				//dtor.setOidPeriodoReclamante(new Long(1));
				
				//++++++++++++++++++++++OJO AQUI YA ***************************
				if(!conectorParametroLimpia("cbPeriodoReclamante", "", true).equals("")){		
					dtor.setOidPeriodoReclamante(new Long(conectorParametroLimpia("cbPeriodoReclamante", "", true)));
				}
				if(!conectorParametroLimpia("textImporteReclamado", "", true).equals("")){
					Double iporteDesformateado=desformatearImporte(conectorParametroLimpia("textImporteReclamado", "", true),separadorMiles.charAt(0),separadorDecimales.charAt(0));				
					dtor.setImporteReclamado(new BigDecimal(iporteDesformateado.doubleValue()));//Double
				}
				//dtor.setImporteReclamado(new BigDecimal(conectorParametroLimpia("textImporteReclamado", "", true)));
				if(!conectorParametroLimpia("textFechaResolucionReclamoPrevista", "", true).equals("")){
					String fechaRPrevista = conectorParametroLimpia("textFechaResolucionReclamoPrevista","",true);
					traza("Formato de fecha: "+ UtilidadesSession.getFormatoFecha(this));
					Date fechaRPrevista1 = UtilidadesBelcorp.getDatefromSICCStringFormat(fechaRPrevista, UtilidadesSession.getFormatoFecha(this)); 
					traza("fechaRPrevista1: "+fechaRPrevista1);
					//dtor.setFechaDocumento(fechaRPrevista1);
					dtor.setFechaResolucionPrevista(fechaRPrevista1);
				}
				if(!conectorParametroLimpia("textObservacionesClienteReclamante", "", true).equals("")){
					dtor.setObservacionesClienteReclamante(new String(conectorParametroLimpia("textObservacionesClienteReclamante", "", true)));
				}
				if(!conectorParametroLimpia("textObservacionesAreaReclamos", "", true).equals("")){
					dtor.setObservacionesAreaReclamos(new String(conectorParametroLimpia("textObservacionesAreaReclamos", "", true)));
				}
				 
				 if(!conectorParametroLimpia("cbBancoRecaudacion", "", true).equals("")){
					dtor.setOidBanco(new Long(conectorParametroLimpia("cbBancoRecaudacion", "", true)));
				}
				if(!conectorParametroLimpia("cbSucursalRecaudacion", "", true).equals("")){
					dtor.setOidSucursal(new Long(conectorParametroLimpia("cbSucursalRecaudacion", "", true)));
				}
				if(!conectorParametroLimpia("cbCuenta", "", true).equals("")){
					dtor.setOidCuentaCorriente(new Long(conectorParametroLimpia("cbCuenta", "", true)));
				}
				if(!conectorParametroLimpia("cbMedioPago", "", true).equals("")){
					dtor.setOidMedioPago(new Long(conectorParametroLimpia("cbMedioPago", "", true)));
				}
				if(!conectorParametroLimpia("textEjercicioCuota", "", true).equals("")){
				 	dtor.setEjercicioCuota(new String(conectorParametroLimpia("textEjercicioCuota", "", true)));
				}
				if(!conectorParametroLimpia("textNumeroIdentificadorCuota", "", true).equals("")){
					dtor.setNumeroIdentificadorCuota(new Integer(conectorParametroLimpia("textNumeroIdentificadorCuota", "", true)));
				}
				if(!conectorParametroLimpia("textNumeroOrdenCuota", "", true).equals("")){
					dtor.setNumeroOrdenCuota(new Integer(conectorParametroLimpia("textNumeroOrdenCuota", "", true)));
				}
				if(!conectorParametroLimpia("cbUsuarioGestorReclamoPrevisto", "", true).equals("")){
					dtor.setUsuarioGestorReclamoPrevisto(new String(conectorParametroLimpia("cbUsuarioGestorReclamoPrevisto", "", true)));
					traza("al guardar enviamos en Gestor PREVISTO" +dtor.getUsuarioGestorReclamoPrevisto());
				}
				if(!conectorParametroLimpia("textFicheroDocAdjunto", "", true).equals("")){
					dtor.setFicheroDocumentoAdjunto(new String(conectorParametroLimpia("textFicheroDocAdjunto", "", true)));
				}
				
				
				String comporbarOID=conectorParametroLimpia("oid", "", true);
				String insmod = null;
				
				if(!comporbarOID.equals("")){
				
					insmod = new String("modificar");
					traza("----> en guardar menu secundario CASO DE USO MODIFICAR <----- ");
					traza("Oid a modificar: "+conectorParametroLimpia("oid", "", true));
					
					if(!conectorParametroLimpia("oid", "", true).equals("")){
						dtor.setOid(new Long(conectorParametroLimpia("oid", "", true)));
					}	
					//CARGAMOS TAMBIEN LOS CAMPOS DE LA CAPA
					
					
					if(!conectorParametroLimpia("cbSituacion", "", true).equals("")){
						dtor.setOidSituacion(new Long(conectorParametroLimpia("cbSituacion", "", true)));
					}
					
					//Fecha real campo obligatorio
					if(!conectorParametroLimpia("txtFechaResolucionReclamoReal", "", true).equals("")){
						String fecha = conectorParametroLimpia("txtFechaResolucionReclamoReal","",true);
						traza("Formato de fecha: "+ UtilidadesSession.getFormatoFecha(this));
						Date fechaReclamoReal = UtilidadesBelcorp.getDatefromSICCStringFormat(fecha, UtilidadesSession.getFormatoFecha(this)); 
						traza("fechaReclamoReal: "+fechaReclamoReal);
						dtor.setFechaResolucionReal(fechaReclamoReal);	
					}
					if(!conectorParametroLimpia("cbUsuarioGestorReclamoReal", "", true).equals("")){
						dtor.setUsuarioGestorReclamoReal(new String(conectorParametroLimpia("cbUsuarioGestorReclamoReal", "", true)));
						traza("al guardar enviamos en Gestor REAL" +dtor.getUsuarioGestorReclamoReal());
					}
					if(!conectorParametroLimpia("cbCodigoSolucionRechazo", "", true).equals("")){
						dtor.setOidMotivoRechazoDesbloqueo(new Long(conectorParametroLimpia("cbCodigoSolucionRechazo", "", true)));
					}
					if(!conectorParametroLimpia("txtNumCargoAbonoDirecto", "", true).equals("")){
						dtor.setNumeroCargoAbono(new Integer(conectorParametroLimpia("txtNumCargoAbonoDirecto", "", true)));
					}
					if(!conectorParametroLimpia("txtAnoCargoAbonoDirecto", "", true).equals("")){
						dtor.setAnioCargoAbono(new String(conectorParametroLimpia("txtAnoCargoAbonoDirecto", "", true)));
					}
					if(!conectorParametroLimpia("txtMesCargoAbonoDirecto", "", true).equals("")){
						dtor.setMesCargoAbono(new String(conectorParametroLimpia("txtMesCargoAbonoDirecto", "", true)));  
					}
					if(!conectorParametroLimpia("atxtObservacionesResolucionReclamos", "", true).equals("")){
						dtor.setObservacionesResolucionReclamos(new String(conectorParametroLimpia("atxtObservacionesResolucionReclamos", "", true)));  
					}
					
				}//if oid;
				
				//creamos la conexion y metemos el dto.
			traza("*******GUARDA*********DTOReclamo Formado: "+ dtor);
			Vector paramConector = new Vector();
			paramConector.add(dtor);
			paramConector.add(new MareBusinessID("CCCGuardarReclamo"));          
			traza("Antes de Conectar ConectorGuardarReclamo ");
			DruidaConector conector = conectar("ConectorGuardarReclamo", paramConector);							
			traza("Despues de Conectar ConectorGuardarReclamo");	
			if (insmod!=null){
				traza("estoy en Modificar solamente");
				asignarAtributo("VAR", "ejecutar", "valor", "modificacionCorrecta()");
			}else{
				traza("estoy en Inseratar solamente");
				
				asignarAtributo("VAR", "ejecutar", "valor", "inserccionCorrecta()");
				conectorActionOpener(true);
				//conectorParametro("accion","insertar_menu_principal");
  				
				
  				conectorAction("LPMantenimientoReclamos"); //nombre de la LP
  				conectorActionParametro("accion", "insertar_menu_principal"); 
  				//asignarAtributo("VAR","accion","insertar_menu_principal");
  				


			}
			
			
                        
                       }// if guardar menu secundario


                  /*      if(this.accion.equals("volver_menu_sec")){	// ARTURO
				//Si accion="volver_menu_sec" 
				//- Regresamos a la página de búsqueda: "BusquedaRegistroVentas" 
                                pagina("contenido_registro_ventas_modificar");
				Byte longitud = this.obtenerLongitudCodigoCliente();
				Long longitudCodigoCliente = new Long(longitud.longValue());
				asignar("VAR","longitudCodigoCliente",longitudCodigoCliente.toString());	
                                
         	  		asignar("VAR", "idioma", idioma.toString());
         	  		traza("->Idioma : "+idioma);
         	  		asignar("VAR", "pais", pais.toString());	
         	  		traza("->Pais : "+pais);
  		  		//asignarAtributo("PAGINA","contenido_registro_ventas_modificar", "cod", "0785");
         	  		//asignarAtributo("PAGINA","contenido_registro_ventas_modificar", "msgle", "Buscar Registro Ventas");
                        }
                        */

                        traza("******LPMantenimientoReclamos Salida");
                      
        }catch ( Exception e )  {
                           e.printStackTrace();
                        traza("Exception e.getMessage"+ e.getMessage());
                        traza("CLASE= "+e.getClass().getName());
                        if((e.getClass().getName()).equals("InvocationTargetException")){
                        	traza("increiblemente esto ha funcionado");
                        	
                        	}
                         traza("hashCode"+e.hashCode());
                         traza("getLocalizedMessage"+e.getLocalizedMessage());
                         //traza("CAUSA"+e.getCause().getMessage());
                         
                         //traza("getCause"+e.getCause());
                         //Throwable trow=new Throwable(e.getCause());
                        // trow=e.getCause();
                         //initCause
                        
                        //Throwable trow=new Throwable(e.getCause()==null ? null : e.getCause().toString());
                        	//trow=e.getCause();
                        	//System.out.println("Throwable. getMessage()= "+trow.getMessage());
                        	//Throwable(String message, Throwable cause) 
                        	//Throwable(Throwable cause) 
         // Constructs a new throwable with the specified cause and a detail message 
         //of (cause==null ? null : cause.toString()) (which typically contains the class and detail message of cause).

                        /*if ( e.detail instanceof MareException){
				System.out.println("MareException");
				MareException mare  =new MareException(e.detail()); 
				//mare.=(MareException)e.detail();
				System.out.println("Codigo error :MareException " + mare.getMessage());
				
			}*/
			
			traza("LoNOrmal");
                        logStackTrace(e);
                        lanzarPaginaError(e);
        }
                  		
   }//metodo ejecucion


         private void logStackTrace(Throwable e) throws Exception {
	        traza("Se produjo la excepcion: " + e.getMessage());		
          	ByteArrayOutputStream baos = new ByteArrayOutputStream();
          	PrintStream ps = new PrintStream(baos);
          	e.printStackTrace(ps);		
          	traza("Stack Trace: " + baos.toString());
         }	
         
         private RecordSet construirRecordsetSimple(Long oid, String descripcion) throws Exception{
		RecordSet rcsSalida=new RecordSet();
		try{
			traza("LP.construirRecordsetSimple Entrada");			
			String sOid="OID";
			String sDescripcion="DESCRIPCION";
			Vector vectorDatos=new Vector();
			vectorDatos.add(oid);
			
			if (descripcion!=null){
				vectorDatos.add(descripcion);
			}else{
				vectorDatos.add("");
			}
			
			rcsSalida.addColumn(sOid);
			rcsSalida.addColumn(sDescripcion);	
			rcsSalida.addRow(vectorDatos);
			traza("LPConsultarReclamos.construirRecordsetSimple Salida");			
		}catch(Exception e){
			e.printStackTrace();
			this.logStackTrace(e);
			lanzarPaginaError(e);			
		}
		return rcsSalida;
		
		
	}
	
	
	private void cargarCombos(Boolean uno, Boolean dos) throws Exception{
		//uno siempre a true
		//COMBOS::
         	  		//-Utilizando "<<subsystem:soporte>> GestorCargaPantalla" 
				//cargamos los COMBOS: Empresa, Canal, Banco, MedioPago, 
				//UsuarioGestorReclamoPrevisto (Usuario). 
		try{	
			ComposerViewElementList listelem = new ComposerViewElementList();
			DTOBelcorp dto = new DTOBelcorp();
		        dto.setOidPais(this.pais);
		        dto.setOidIdioma(this.idioma);
		        
		        traza("this.pais "+this.pais);
         	  	traza("this.idioma "+this.idioma);
         	  	if(uno.booleanValue()){
         	  			         	
		        	traza("1.-uno.booleanValue");
		         	
		         	ComposerViewElement empresa = new ComposerViewElement();
		         	empresa.setIDBusiness("SEGObtenerEmpresasPorPais");
		         	empresa.setDTOE(dto);
				traza("Elemento empresa");
				
				listelem.addViewElement(empresa);
				
				ComposerViewElement canal = new ComposerViewElement();
		         	canal.setIDBusiness("SEGConsultaCanales");
		         	canal.setDTOE(dto);
				traza("Elemento canales");
				
				listelem.addViewElement(canal);
				
				
				
				ComposerViewElement mediosPago = new ComposerViewElement();
		         	mediosPago.setIDBusiness("BELObtenerMediosPagoCombo");
		         	mediosPago.setDTOE(dto);
				traza("Elemento mediosPago ");
				//idBusiness = "BELObtenerMediosPagoCombo" MONServicioBEL.obtenerMediosPagoCombo(dto : DTOBelcorp) : DTOSalida


				listelem.addViewElement(mediosPago);
		         	
		         	ComposerViewElement usuarioP = new ComposerViewElement();
		         	usuarioP.setIDBusiness("MENObtenerCodUsuarios");
		         	usuarioP.setDTOE(dto);
				traza("Elemento UsuarioP");
				
				listelem.addViewElement(usuarioP);
				
				ComposerViewElement banco = new ComposerViewElement();
		         	banco.setIDBusiness("CCCObtieneBancos");
		         	banco.setDTOE(dto);
				traza("Elemento Banco");
				
				listelem.addViewElement(banco);
		         	
		        }
		 	   if(dos.booleanValue()){
				traza("1.-dos.booleanValue"); //BELC300008840
				ComposerViewElement situa= new ComposerViewElement();
		         	situa.setIDBusiness("CCCObtenerSituacionesReclamo");
		         	situa.setDTOE(dto);
				traza("Elemento situacion");
				listelem.addViewElement(situa);//BELC300008840    
				
				//listelem.addViewElement(situacion);
			//BELC300009126
				ComposerViewElement motivoRechazo = new ComposerViewElement();//BELC300009126
		         	motivoRechazo.setIDBusiness("RECObtenerMotivosRechazoDesbloqueo");
		         	motivoRechazo.setDTOE(dto);
				traza("Elemento motivos Rechazo ");
				
				listelem.addViewElement(motivoRechazo);
				//casca el negocio de este metodo
				
				
				
				
			}
         	//Se llama al subsistema GestorCargaPantalla. 
         	ConectorComposerView conector = new ConectorComposerView(listelem,this.getRequest());
         	traza("conector creado");
         	conector.ejecucion();
         	traza("ejecutado");
         	DruidaConector conConsultar = conector.getConector();
         	
         	this.conConsultarTem=conConsultar;
         	traza("Obtener conConsultar");
		         	
			/*if(uno.booleanValue()){	
				traza("2.-uno.booleanValue");
				//asignar("COMBO","cbCanal", conConsultar,"SEGConsultaCanales");
				traza("Combo canal asignado");
		         	asignar("COMBO","cbEmpresa", conConsultar,"SEGObtenerEmpresasPorPais");
		         	traza("Combo empresa asignado");
				asignar("COMBO","cbBancoRecaudacion", conConsultar,"CCCObtieneBancos");
				traza("Combo banco asignado");				
				
		         	asignar("COMBO","cbMedioPago", conConsultar,"BELObtenerMediosPagoCombo");
		         	//traza("Combo tipoDocLegal asignado");
				asignar("COMBO","cbUsuarioGestorReclamoPrevisto", conConsultar,"MENObtenerUsuarios");				
				//traza("Combo tipoDocLegalRef asignado");
			}
			
			if(dos.booleanValue()){
				traza("2.-dos.booleanValue");
				//asignar("COMBO","cbSituacion", conConsultar,"CCCObtenerSituacionesReclamo");
				//traza("Combo situacion asignado");
				asignar("COMBO","cbUsuarioGestorReclamoReal", conConsultar,"MENObtenerUsuarios");
				
				//asignar("COMBO","cbCodigoSolucionRechazo", conConsultar,"RECObtenerMotivosRechazoDesbloqueo");BELC300009126
				
				
			}
			*/
	}catch(Exception e){
		traza(" [csanchez]Exception en cargarCombos() my Function ");
		e.printStackTrace();
		this.logStackTrace(e);
		lanzarPaginaError(e);			
	}	
			
		}//funcion carga comboas

   private String formatearImporte(BigDecimal dineroEntrada,char separadorMiles,char separadorDecimales){
		StringTokenizer tokens=new StringTokenizer(dineroEntrada.toString(),".");		
		StringBuffer bufferDecimal=new StringBuffer(tokens.nextToken());// almacena la parte entera.
		StringBuffer bufferDinero=new StringBuffer();//almacena el resultado
		StringBuffer bufferDecimales=new StringBuffer();//almacena la parte decimal
	
		int miles=0;
		while(bufferDecimal.length()>0){
			miles++;
			bufferDinero.insert(0,bufferDecimal.charAt(bufferDecimal.length()-1));
			bufferDecimal.deleteCharAt(bufferDecimal.length()-1);
			if(miles==3&&bufferDecimal.length()>0){
				miles=0;
				bufferDinero.insert(0,separadorMiles);
			}
		}

		if((tokens.hasMoreTokens())){
			bufferDecimales.append(tokens.nextToken());
			String comprobacion=bufferDecimales.toString();
			if(bufferDecimales.length()>1){
				if(!bufferDecimales.substring(0,2).equals("00")){
					if(!bufferDecimales.substring(1,2).equals("0")){
						bufferDinero.append(separadorDecimales+bufferDecimales.substring(0,2));
					}else{
						bufferDinero.append(separadorDecimales+bufferDecimales.substring(0,1));
					}
				}
			}else{
				if(!bufferDecimales.substring(0,1).equals("0")){
					bufferDinero.append(separadorDecimales+bufferDecimales.toString());
				}
			}
		}
		return bufferDinero.toString();
		
	}//funcion importes
	
   private Double desformatearImporte(String dineroEntrada,char separadorMiles,char separadorDecimales){
		String dineroSalida="";
		StringTokenizer tokens=new StringTokenizer(dineroEntrada,separadorMiles+"");					
		while(tokens.hasMoreTokens()){
			dineroSalida=dineroSalida+tokens.nextToken();
		}
		dineroSalida=dineroSalida.replace(separadorDecimales,'.');
		return new Double(dineroSalida);
	}//desformatear	
	

}//clase
                   
                                                                                                                                	                                                      