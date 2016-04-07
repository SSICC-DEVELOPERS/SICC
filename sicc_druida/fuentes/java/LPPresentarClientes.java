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
    $Id: LPPresentarClientes.java,v 1.1 2009/12/03 18:33:16 pecbazalar Exp $
    DESC
 */


import es.indra.druida.DruidaConector;

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;

import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;

import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.cmn.presentacion.cache.Cache;

import java.util.Vector;
import java.util.StringTokenizer;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import es.indra.sicc.dtos.cal.DTOTipificacion;

import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.logicanegocio.cal.ConstantesCAL;
import es.indra.sicc.dtos.cal.DTOFichaCliente;
import es.indra.sicc.dtos.cal.DTOCliente;
import es.indra.sicc.dtos.cal.DTOCabeceraPedido;
import es.indra.sicc.dtos.cal.DTODetallePedido;
import es.indra.sicc.dtos.cal.DTOContacto;
import es.indra.sicc.dtos.mae.DTOCodigoCliente;
import es.indra.sicc.dtos.cal.DTODescTipificacion;
import es.indra.sicc.dtos.cal.DTOBloqueoAdm;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import es.indra.sicc.util.xml.XMLDocument;

// Definicion de la clase
public class LPPresentarClientes extends LPSICCBase  {

         public LPPresentarClientes() {super();}

         private String accion = null;
         private Long pais  = null;   
         private Long idioma  = null;   
         private Long oidContacto  = null;   
         private Long oidCliente  = null;   
         private String codigoCliente  = null;   
         private Long oidTipoCliente  = null;   
         private String codigoTipoCliente  = null;   
         private Long oidSubtipoCliente  = null;   
         private Long oidSolicitudCabecera  = null;   
         private Long oidSolicitudPosicion  = null;   
         private Boolean indConsultoraInterna  = new Boolean(false);
         private String casoDeUso = "";   

           
         public void inicio() throws Exception {
                  setTrazaFichero();
                  traza("------------ Antes de Modal " + this.accion);
                  pagina("contenido_clientes_ficha_presentar");
         }

         public void ejecucion() throws Exception {
                  
                  rastreo();
                  
                  this.accion = conectorParametroLimpia("accion", "", true);
                  this.indConsultoraInterna = this.obtenerindConsultoraInterna();
                  try {
                           setTrazaFichero();
                           traza("********** accion parametro " + this.accion);
                           Cache cache = this.getSessionCache();

                           String accionSesion = (String)cache.get("accion");
                           traza("********** accion sesion 1" + accionSesion);
                           
                           if (accionSesion != null && !accionSesion.equals("")) {
                                    this.accion = accionSesion;
                           }

                           this.pais = UtilidadesSession.getPais(this);
                           this.idioma = UtilidadesSession.getIdioma(this);
                           
                           if (accion.equals("")) {
                                    //getConfiguracionMenu("LPPresentarClientes", "");
                  this.mostrarPGDatosSeleccion();     
                           } else if (accion.equals("Ver Ficha desde Página Recarga")) {
                                    traza("********** Ver Ficha desde Página Recarga");
                                    this.sesionParametrosRecoger();
                  this.verFichaCliente(new Boolean(true));     
                           } else if (accion.equals("Ver Ficha Consulta Interna Recarga")) {
                                    this.indConsultoraInterna = new Boolean(true);
                                    traza("********** Ver Ficha Consulta Interna Recarga");
                                    this.sesionParametrosRecoger();
                  this.verFichaCliente(new Boolean(false));     
                           } else if (accion.equals("Ver Ficha Solo")) {
                                    this.obtenerParametros();
                  this.verFichaCliente(new Boolean(false));    
                           } else if (accion.equals("Ver Ficha")) {
                                    this.sesionParametrosGuardar();
                           } else if (accion.equals("Ver Ficha Recarga")) {
                                    traza("********** Ver Ficha Recarga");
                                    this.sesionParametrosRecoger();
                  this.verFichaCliente(new Boolean(true));    
                           } else if (accion.equals("Comprobar Cliente")) {
                  this.comprobarCliente();     
                           } else if (accion.equals("Comprobar Cliente Recarga")) {
                                    traza("********** Comprobar Cliente Recarga");
                                    this.sesionParametrosRecoger();
                  this.comprobarClienteFicha();     
                           } else if (accion.equals("Ver Ficha desde Página")) {
                                    this.sesionParametrosGuardar();
                           } else if (accion.equals("Ver Ficha Consulta Interna")) {
                                    this.sesionParametrosGuardar();
                           } else if (accion.equals("Bloqueo")) {
                                    this.sesionParametrosRecoger();
                  this.realizarBloqueoAdministrativo();     
                           } else if (accion.equals("Cuentas corrientes")) {
                  this.verCuentasCorrientes();     
                           } else if (accion.equals("Vinculos")) {
                  this.verVinculos();     
                           } else if (accion.equals("Documentos")) {
                  this.verDocumentos();     
                           } else if (accion.equals("Direccion")) {
                  this.verDirecciones();     
                           } else if (accion.equals("Pedidos")) {
                  this.verPedidos();     
                           } else if (accion.equals("Datos adicionales Cabecera")) {
                  this.verDatosAdicionalesCabecera();     
                           } else if (accion.equals("Datos adicionales Detalle")) {
                  this.verDatosAdicionalesDetalle();     
                           } else if (accion.equals("Actualizar Estado Contacto")) {
                  this.mostrarPGEstadoContacto();     
                           } else if (accion.equals("Actualizar")) {
                  this.actualizarEstadoContacto();  
                           } else if (accion.equals("MostrarFichaPedidoNoFacturado")) {
                  this.mostrarFichaPedidoNoFacturado();  
                           } else if (accion.equals("Procesar Bloqueo")) {
                  this.procBloqueo();  
                           } else if (accion.equals("GuardarBloqueoAdm")) {
                  this.guardarBloqueoAdm();  
                           }
                  } catch (Exception ex) {
                           logStackTrace(ex);
                           this.lanzarPaginaError(ex);   
                  }
         }             	

         //Agregado por CAL-04
         private void mostrarFichaPedidoNoFacturado() throws Exception {
                  traza("--LPPresentarClientes.mostrarFichaPedidoNoFacturado(): Entrada");
                  
                  pagina("contenido_clientes_pedidos_presentar"); 
                                    
                  asignar("VAR", "idioma", this.idioma.toString());
                  asignar("VAR", "pais", this.pais.toString());
                  asignar("VAR", "oidCliente", conectorParametroLimpia("oidCliente", "", true));
                  asignar("VAR", "oidTipoCliente", conectorParametroLimpia("oidTipoCliente", "", true));
      asignar("VAR", "oidSubtipoCliente", conectorParametroLimpia("oidSubtipoCliente", "", true));
                  asignar("VAR", "indConsultoraInterna", conectorParametroLimpia("indConsultoraInterna", "", true));
      asignar("VAR", "oidSolicitudCabecera", conectorParametroLimpia("oidSolicitudCabecera", "", true));
                  asignar("VAR", "indNoFacturado", "NoFacturado");		

                  traza(" --LPPresentarClientes.mostrarFichaPedidoNoFacturado(): Salida");
         }
         //fin Agregado por CAL-04
         
         private void mostrarPGDatosSeleccion() throws Exception {
                  //Asigna la página PGDatosSeleccion 
                  pagina("contenido_clientes_seleccion");
                  traza("********** mostrarPGDatosSeleccion");
                  asignarAtributo("PAGINA", "contenido_clientes_seleccion", "cod", "0561");
         asignarAtributo("PAGINA", "contenido_clientes_seleccion", "msgle", "Presentar clientes");
                  Byte longitudCodigoCliente = this.obtenerLongitudCodigoCliente();
                  asignar("VAR","numDigitosCodigoCliente", longitudCodigoCliente.toString());
                  getConfiguracionMenu("LPPresentarClientes", "");
                  
                  asignar("VAR", "idioma", this.idioma.toString());
                  asignar("VAR", "pais", this.pais.toString());

                  DTOBelcorp dtoB = new DTOBelcorp();
                  dtoB.setOidPais(this.pais);
                  dtoB.setOidIdioma(this.idioma);

                  this.cargaCombo(dtoB);
	
                  asignar("VAR", "cteLlamadaDirecta", ConstantesCAL.OID_LLAMADA_DIRECTA.toString()); 

                  //Muestra la capa1
                  //Oculta la capa2 
                                    traza("********** mostrarPGDatosSeleccion 3");
                  asignarAtributo("CAPA", "capa2", "visibilidad", "hidden");
         }

         private void cargaCombo(DTOBelcorp dtoBelcorp) throws Exception {
                  traza("*** Entrada - LPPresentarClientes - cargaCombos ***");
         
                  //Cada elemento va a contener el IDbusiness y el DTO que reciben la logica de negocio como entrada. 
                  ComposerViewElementList listelem = new ComposerViewElementList();
                  ComposerViewElement elem = new ComposerViewElement();
                  elem.setIDBusiness("CALObtenerTipoLlamada");
                  elem.setDTOE(dtoBelcorp);
                  listelem.addViewElement(elem);

                  /*Se ejecuta el conector y se obtiene un RowSet que contiene todos los datos solicitados.*/ 
                  ConectorComposerView conector = new ConectorComposerView(listelem, this.getRequest());
                  conector.ejecucion();
                  DruidaConector conConsultar = conector.getConector();

                  /*Posterior a la llamada se debe hacer el asignar a los elementos de la pantalla correspondiente utilizando el String que representa el BusinessID en cada caso. */
                  asignar("COMBO", "cbSeleccion", conConsultar, "CALObtenerTipoLlamada"); 

                  traza("*** Salida - LPPresentarClientes - cargaCombos ***");
         }

                    
         private void verFichaCliente(Boolean indContacto) throws Exception {
                  traza("********** ver ficha");
                  //Mostrar la página PGFichaCliente con la siguiente información: 
                  pagina("contenido_clientes_ficha_presentar");
                  getConfiguracionMenu("LPPresentarClientes", "Marcos");
                  
                  mostrarPGFichaCliente(this.obtenerDatosFichaCliente(indContacto));
				  //mostrarPGFichaCliente(this.obtenerTipoComunicacion());	
         }
		
		 
         private DTOFichaCliente obtenerDatosFichaCliente(Boolean indContacto) throws Exception {
                  //Se guardará el contacto que ha tenido lugar y se obtendrán los datos del cliente 
                  traza("************ obtenerDatosFichaCliente");

                  DTOCliente dtoCliente = new DTOCliente();
                  dtoCliente.setOidPais(this.pais);
                  dtoCliente.setOidIdioma(this.idioma);
                  dtoCliente.setOidCliente(this.oidCliente);
                  dtoCliente.setOidTipoCliente(this.oidTipoCliente);
                  dtoCliente.setIndContacto(indContacto); //indica si debemos grabar en la entidad Contactos
                  traza("************ datos: " + this.pais + " " + this.idioma + " "  + this.oidCliente + " " + this.oidTipoCliente);

                  MareBusinessID idBusiness = new MareBusinessID("CALObtenerDatosFichaCliente");

                  // Se almacenan los parametros de entrada
                  Vector paramEntrada = new Vector();
                  paramEntrada.addElement(dtoCliente);
                  paramEntrada.addElement(idBusiness);

                  // Se invoca al conector ConectorConsulta para validar los datos
                  DruidaConector conector = conectar("ConectorObtenerDatosFichaCliente", paramEntrada);
                  traza("************ conexion");
                  return (DTOFichaCliente)conector.objeto("DTOFichaCliente");
				  
         }
		 

		/* ///////////////////////////
		 public DTOFichaCliente obtenerTipoComunicacion()throws Exception{
			      traza("***************ObtenerTipoComunicacion*********************");
			      DTOCliente dtoCliente = new DTOCliente();
			      dtoCliente.setOidCliente(this.oidCliente);
	   	          traza("********* datos: " + this.oidClient);
			      MareBusinessID idBusiness = new MareBusinessID("CALObtenerTipoComunicacion");

                  // Se almacenan los parametros de entrada
                  Vector paramEntrada = new Vector();
                  paramEntrada.addElement(dtoCliente);
                  paramEntrada.addElement(idBusiness);

                  // Se invoca al conector ConectorConsulta para validar los datos
                  DruidaConector conector = conectar("ConectorObtenerTipoComunicacion", paramEntrada);
                  traza("************ conexion");
                  return (DTOFichaCliente)conector.objeto("DTOFichaCliente");
		 }*/

         private void mostrarPGFichaCliente(DTOFichaCliente entrada) throws Exception {
                  traza("********** mostrar ficha");

                  asignar("VAR", "idioma", this.idioma.toString());
                  asignar("VAR", "pais", this.pais.toString());
                  //Datos Generales 
                  //Si accion 'Ver Ficha Solo' => no se crea contacto, debe cogerlo de parámetros
                  if (this.accion.equals("Ver Ficha Solo") && !conectorParametroLimpia("oidContacto", "", true).equals("")) {
                           this.oidContacto = new Long(conectorParametroLimpia("oidContacto", "", true));
                           traza("********** oidContacto-parametro: " + this.oidContacto);
                  } else {
                           this.oidContacto = entrada.getOidContacto(); //se guarda en la LP y se pasa a una variable de la página  
                           traza("********** oidContacto-creado: " + this.oidContacto);
                  }

                  if (entrada.getCliente() != null) {
                           this.oidCliente = entrada.getCliente().getOidCliente(); //se guarda en la LP y se pasa a una variable de la página
                           this.oidTipoCliente = entrada.getCliente().getOidTipoCliente(); //se guarda en la LP y se pasa a una variable de la página 
                           this.oidSubtipoCliente = entrada.getCliente().getOidSubtipoCliente(); //se guarda en la LP y se pasa a una variable de la página 
                  }
                  //this.indConsultoraInterna = indConsultoraInterna //paso la variable de la LP a la página //ñññ
                  if (this.oidContacto != null)
                           asignar("VAR", "oidContacto", this.oidContacto.toString());
                  if (this.oidCliente != null)
                           asignar("VAR", "oidCliente", this.oidCliente.toString());
                  if (this.oidTipoCliente != null)
                           asignar("VAR", "oidTipoCliente", this.oidTipoCliente.toString());
                  if (this.oidSubtipoCliente != null)
                           asignar("VAR", "oidSubtipoCliente", this.oidSubtipoCliente.toString());
                  if (this.indConsultoraInterna != null && this.indConsultoraInterna.booleanValue())
                           asignar("VAR", "indConsultoraInterna", "S");
                  else
                           asignar("VAR", "indConsultoraInterna", "N");

                  asignar("VAR", "casoDeUso", this.casoDeUso);
                  traza("********** casoDeusoMostrar: " + this.casoDeUso);
                  /*if (!this.casoDeUso.equals("Presentar"))
                           asignarAtributo("PAGINA", "contenido_clientes_ficha_presentar", "cod", "0559");*/


                  if (entrada.getCliente() != null) {
                           traza("********** datos generales: " + entrada.getCliente().toString());
                           asignar("LABELC", "lbldtCodCliente", this.obtieneCadena(entrada.getCliente().getCodCliente())); 
                           asignar("VAR", "codCliente", this.obtieneCadena(entrada.getCliente().getCodCliente())); // DBLG700000144 
                           asignar("LABELC", "lbldtTipoDocIdentidad", this.obtieneCadena(entrada.getCliente().getDesTipoDocumento())); 
                           asignar("LABELC", "lbldtNumDocumento", this.obtieneCadena(entrada.getCliente().getDocIdentidad())); 
                           asignar("LABELC", "lbldtApellido1", this.obtieneCadena(entrada.getCliente().getApellido1())); 
                           asignar("LABELC", "lbldtApellido2", this.obtieneCadena(entrada.getCliente().getApellido2())); 
                           asignar("LABELC", "lbldtApellidoCasada", this.obtieneCadena(entrada.getCliente().getApellidoCasada())); 
                           asignar("LABELC", "lbldtNombre1", this.obtieneCadena(entrada.getCliente().getNombre1())); 
                           asignar("LABELC", "lbldtNombre2", this.obtieneCadena(entrada.getCliente().getNombre2())); 
                           asignar("LABELC", "lbldtEstatus", this.obtieneCadena(entrada.getCliente().getDesEstatus())); 
                           asignar("LABELC", "lbldtIndicadorActivo", this.obtieneCadena(entrada.getCliente().getIndicadorActico())); 
                         //  asignar("LABELC", "lbldtTelefono", this.obtieneCadena(entrada.getCliente().getTelefono())); 
                         //  asignar("LABELC", "lbldtEmail", this.obtieneCadena(entrada.getCliente().getEmail())); 
                           asignar("LABELC", "lbldtTratamiento", this.obtieneCadena(entrada.getCliente().getDesTratamiento())); 
                           asignar("LABELC", "lbldtFechaProximoContacto", this.obtieneCadenaFecha(entrada.getCliente().getFechaProximoContacto())); 
                           //asignar("LABELC", "lbldtBloqueoAdministrativo", this.obtieneCadena(entrada.getCliente().getDesBloqueoAdministrativo())); 
                           //asignar("LABELC", "lbldtBloqueoFinanciero", this.obtieneCadena(entrada.getCliente().getDesBloqueoFinanciero())); 
                           asignar("LABELC", "lbldtBloqueo", this.obtieneCadena(entrada.getCliente().getBloqueo()));
                           asignar("LABELC", "lbldtFechaIngreso", this.obtieneCadenaFecha(entrada.getCliente().getFechaIngreso())); 
                           asignar("LABELC", "lbldtPeriodoIngreso", this.obtieneCadena(entrada.getCliente().getDesPeriodoIngreso()));
             asignar("LABELC", "lbldtFechaNac", this.obtieneCadenaFecha(entrada.getCliente().getFechaNacimiento()));
             asignar("LABELC", "lbldtFechaUltimoPedido", this.obtieneCadenaFecha(entrada.getCliente().getFechaUltimoPedido()));
             asignar("LABELC", "lbldtCampaniaUltimoPedido", this.obtieneCadena(entrada.getCliente().getDescUltimaCampaniaPedido()));
             if(entrada.getCliente().getNumeroUltimaBoletaDespacho()!=null){
                  asignar("LABELC", "lbldtNumeroBoleta", entrada.getCliente().getNumeroUltimaBoletaDespacho().toString());
             }
             if(entrada.getCliente().getMontoUltimaBoletaDespacho()!=null){
                  asignar("LABELC", "lbldtSaldoBoleta", entrada.getCliente().getMontoUltimaBoletaDespacho().toString() );
             }
             if(entrada.getCliente().getSaldoUnicoCCC()!=null){
                  asignar("LABELC", "lbldtSaldoUnico", entrada.getCliente().getSaldoUnicoCCC().toString());
             }
             if(entrada.getCliente().getTipoDireccion()!=null){
                  asignar("LABELC", "lbldtTipoDireccion", entrada.getCliente().getTipoDireccion());
             }
             if(entrada.getCliente().getTipoVia()!=null){
                  asignar("LABELC", "lbldtTipoVia", entrada.getCliente().getTipoVia());
             }
             if(entrada.getCliente().getNombreVia()!=null){
                  asignar("LABELC", "lbldtVia", entrada.getCliente().getNombreVia());
             }
             if(entrada.getCliente().getNumeroPrincipal()!=null){
                  asignar("LABELC", "lbldtNumeroPrincipal", entrada.getCliente().getNumeroPrincipal());
             }
             if(entrada.getCliente().getObservacionesDireccion()!=null){
                  asignar("LABELC", "lbldtObservaciones", entrada.getCliente().getObservacionesDireccion());
             }
             if(entrada.getCliente().getDescUniGeo()!=null){
                  asignar("LABELC", "lbldtDescripcionUbigeo", entrada.getCliente().getDescUniGeo());
             }
                  }

                  //Información de cliente 
                  if (entrada.getTipificacion() != null) {
                           /*asignar("LABELC", "lbldtTipoCliente", this.obtieneCadena(entrada.getTipificacion().getDesTipoCliente())); 
                           asignar("LABELC", "lbldtSubtipoCliente", this.obtieneCadena(entrada.getTipificacion().getDesSubtipoCliente())); 
                           asignar("LABELC", "lbldtTipoClasificacion", this.obtieneCadena(entrada.getTipificacion().getDesTipoClasificacion())); 
                           asignar("LABELC", "lbldtClasificacion", this.obtieneCadena(entrada.getTipificacion().getDesClasificacion())); */
             this.asignarTipificacion(entrada.getTipificacion());
                  }

                  //Nombres de Consultora/Gerente zona/Gerente regional/Subgerentes ventas 
                  if (entrada.getNombreConsultora() != null) {
                           traza("********** datos consultora: " + entrada.getNombreConsultora().toString());
                           //mostrar el formulario con la etiqueta "Consultora" (por defecto)
                           asignar("LABELC", "lbldtApellido1x", this.obtieneCadena(entrada.getNombreConsultora().getApellido1())); 
                           asignar("LABELC", "lbldtApellido2x", this.obtieneCadena(entrada.getNombreConsultora().getApellido2())); 
                           asignar("LABELC", "lbldtNombre1x", this.obtieneCadena(entrada.getNombreConsultora().getNombre1())); 
                           asignar("LABELC", "lbldtNombre2x", this.obtieneCadena(entrada.getNombreConsultora().getNombre2())); 
                  } 
 
                  if (entrada.getNombreGerenteZona() != null) {
                           traza("********** datos gerente zona: " + entrada.getNombreGerenteZona().toString());
                           //mostrar el formulario con la etiqueta "GerenteZona"
                           asignarAtributo("LABELC", "lblConsultora", "cod", "1164"); 
                           asignar("LABELC", "lbldtApellido1x", this.obtieneCadena(entrada.getNombreGerenteZona().getApellido1())); 
                           asignar("LABELC", "lbldtApellido2x", this.obtieneCadena(entrada.getNombreGerenteZona().getApellido2())); 
                           asignar("LABELC", "lbldtNombre1x", this.obtieneCadena(entrada.getNombreGerenteZona().getNombre1())); 
                           asignar("LABELC", "lbldtNombre2x", this.obtieneCadena(entrada.getNombreGerenteZona().getNombre2())); 
                  }

                  if (entrada.getNombreGerenteRegional() != null) {
                           traza("********** datos gerente region: " + entrada.getNombreGerenteRegional().toString());
                           //mostrar el formulario con la etiqueta "Gerente regional" 
                           asignarAtributo("LABELC", "lblConsultora", "cod", "1992"); 
                           asignar("LABELC", "lbldtApellido1x", this.obtieneCadena(entrada.getNombreGerenteRegional().getApellido1())); 
                           asignar("LABELC", "lbldtApellido2x", this.obtieneCadena(entrada.getNombreGerenteRegional().getApellido2())); 
                           asignar("LABELC", "lbldtNombre1x", this.obtieneCadena(entrada.getNombreGerenteRegional().getNombre1())); 
                           asignar("LABELC", "lbldtNombre2x", this.obtieneCadena(entrada.getNombreGerenteRegional().getNombre2())); 
                  }


                  if (entrada.getNombreSubgerenteVentas() != null) {
                           traza("********** datos subgenerente: " + entrada.getNombreSubgerenteVentas().toString());
                           //mostrar el formulario con la etiqueta "Subgerente ventas" 
                           asignarAtributo("LABELC", "lblConsultora", "cod", "1993"); 
                           asignar("LABELC", "lbldtApellido1x", this.obtieneCadena(entrada.getNombreSubgerenteVentas().getApellido1())); 
                           asignar("LABELC", "lbldtApellido2x", this.obtieneCadena(entrada.getNombreSubgerenteVentas().getApellido2())); 
                           asignar("LABELC", "lbldtNombre1x", this.obtieneCadena(entrada.getNombreSubgerenteVentas().getNombre1())); 
                           asignar("LABELC", "lbldtNombre2x", this.obtieneCadena(entrada.getNombreSubgerenteVentas().getNombre2())); 
                  }

                  //Grupo unidades administrativas 
                  //lstUnidadesAdministrativas = entrada.unidadesAdministrativas 
                  Vector cols = null;
                  DruidaConector conectorCargaLista = null; 
                  
                  RecordSet rs = entrada.getUnidadesAdministrativas();
				  traza("*****rs : " + rs);
                  if (rs != null) {
							traza("**************************77777777777777777777");
                           cols = rs.getColumnIdentifiers();
                           conectorCargaLista = UtilidadesBelcorp.generarConector("DTOSalida.combo_ROWSET", rs, cols);
                           asignar("LISTAEDITABLE", "listado1", conectorCargaLista, "DTOSalida.combo_ROWSET");
				  }

                  //Grupo últimos pedidos 
                  //lstUltimosPedidos = entrada.ultimosPedidos 
                  rs = entrada.getUltimosPedidos();
                  if (rs != null) {
                           Vector colsSinFormato = new Vector();
                           cols = rs.getColumnIdentifiers();
                           colsSinFormato.add(new Integer(0));
                           colsSinFormato.add(new Integer(1));
                           conectorCargaLista = this.generarConectorFormato("DTOSalida.combo_ROWSET", rs, cols, colsSinFormato);
                           asignar("LISTAEDITABLE", "listado2", conectorCargaLista, "DTOSalida.combo_ROWSET"); 

                  }
				  traza("************");
				  rs = entrada.getTipoComunicacion();	
				  traza(" rs :" + rs );
				  if( rs != null ){
					    traza("**********************77777777777777777777777");
						cols = rs.getColumnIdentifiers();
                        conectorCargaLista = UtilidadesBelcorp.generarConector("DTOSalida.combo_ROWSET", rs, cols);
                        asignar("LISTAEDITABLE", "listado5", conectorCargaLista, "DTOSalida.combo_ROWSET");
				  }
                  //Grupo datos económicos 
                  if (entrada.getCliente() != null) {
                           if (entrada.getCliente().getMontoLineaCredito() != null)
                                    asignar("LABELC", "lbldtMontoLineaCredito", this.formateaNumerico(entrada.getCliente().getMontoLineaCredito().toString())); 
                           asignar("LABELC", "lbldtNivelRiesgo", this.obtieneCadena(entrada.getCliente().getDesNivelRiesgo())); 
                  }
                  if (entrada.getMontoSolicitudesNuevas() != null)
                           asignar("LABELC", "lbldtMontoSolicitudesNuevas", this.formateaNumerico(entrada.getMontoSolicitudesNuevas().toString())); 

                  //Deshabilitar todos los campos de la página PGFichaCliente 
 
                  //Si !indConsultoraInterna 
                  //Habilitar el botón btActualizarEstadoContacto
                  if (!this.indConsultoraInterna.booleanValue()) {
                           asignar("VAR", "activaBtActualiza", "S");

                    //<Inicio> INCIDENCIA DBLG700000296, Si !indConsultoraInterna, Habilitar el botón btBloqueoAdministrativo
                    asignar("VAR", "activaBtBloqueo", "S");
                    //<Fin> INCIDENCIA DBLG700000296
                  }

         }

         private void comprobarCliente() throws Exception {
                  traza("********** comprobarCliente ficha");
                  pagina("salidaGenerica");
                  asignarAtributo("PAGINA", "salidaGenerica", "onload", "fMostrarMensajeError(get('frmFormulario.errCodigo'), get('frmFormulario.errDescripcion'));window.close();");		//Recuperar los datos de la página y guardarlos en la LP: 
                  if (!conectorParametroLimpia("codigoCliente", "", true).equals(""))
                           this.codigoCliente = conectorParametroLimpia("codigoCliente", "", true);

                  DTOSalida dtoSalida = this.obtenerTiposCliente();
                  if (dtoSalida.getResultado().esVacio()) { 
                  traza("********** no hay datos");
                           pagina("salidaGenerica");
                           //asignarAtributo("PAGINA", "salidaGenerica", "onload", "window.opener.mostrarCAL003();window.close();");		//Recuperar los datos de la página y guardarlos en la LP: 
                           asignarAtributo("PAGINA", "salidaGenerica", "onload", "GestionarMensaje('UICAL0003');close();");		//Recuperar los datos de la página y guardarlos en la LP: 
                           
                           //mostrar mensaje CAL003: El código de cliente no existe 
                  } else if (dtoSalida.getResultado().getRowCount() == 1) {
                           traza("********** resultado 1");
                           //guardar los datos en la LP (en sesion)
                           if (dtoSalida.getResultado().getValueAt(0, 0) != null)
                                    this.oidCliente = new Long(((BigDecimal)dtoSalida.getResultado().getValueAt(0, 0)).longValue()); 
                           this.codigoCliente = (String)dtoSalida.getResultado().getValueAt(0, 1);
                           if (dtoSalida.getResultado().getValueAt(0, 2) != null)
                                    this.oidTipoCliente = new Long(((BigDecimal)dtoSalida.getResultado().getValueAt(0, 2)).longValue()); 
                           this.codigoTipoCliente = (String)dtoSalida.getResultado().getValueAt(0, 3);
                           Cache cache = this.getSessionCache();
                           cache.put("oidCliente", this.oidCliente.toString());
                           this.conectorParametroSesion("oidCliente33",this.oidCliente.toString());
                           cache.put("codigoCliente", this.codigoCliente);
                           cache.put("oidTipoCliente", this.oidTipoCliente.toString());
                           cache.put("codigoTipoCliente", this.codigoTipoCliente);
                           cache.put("accion", this.accion + " Recarga");
                           cache.put("casoDeUso", conectorParametroLimpia("casoDeUso", "", true));
                           traza("********** datos: " + this.oidCliente + " " + this.oidTipoCliente + " " + this.codigoCliente + " " + this.codigoTipoCliente);
                           pagina("enlace_ficha");
                           //this.mostrarPGFichaCliente(this.obtenerDatosFichaCliente(new Boolean(true))); 
                  } else  
                           this.mostrarPGTiposCliente(dtoSalida);
         }
         private void comprobarClienteFicha() throws Exception {
                  //Mostrar la página PGFichaCliente con la siguiente información: 
                  this.verFichaCliente(new Boolean(true));
         }
         
         private DTOSalida obtenerTiposCliente() throws Exception {

                  traza("********** obtener tipos");
                  DTOCodigoCliente dtoOID = new DTOCodigoCliente();
                  dtoOID.setCodigoCliente(this.codigoCliente);
                  dtoOID.setOidPais(this.pais);
                  dtoOID.setOidIdioma(this.idioma);

                  MareBusinessID idBusiness = new MareBusinessID("CALObtenerTiposCliente");

                  // Se almacenan los parametros de entrada
                  Vector paramEntrada = new Vector();
                  paramEntrada.addElement(dtoOID);
                  paramEntrada.addElement(idBusiness);

                  // Se invoca al conector ConectorConsulta para validar los datos
	              DruidaConector conector = conectar("ConectorObtenerTiposCliente", paramEntrada);
	              return (DTOSalida)conector.objeto("DTOSalida");
         }

         private void mostrarPGTiposCliente(DTOSalida entrada) throws Exception {
                  traza("********** mostrar tipos cliente");
                  //Mostrar página PGTiposCliente
                  pagina("contenido_clientes_seleccion_detalle");
                  asignarAtributo("PAGINA", "contenido_clientes_seleccion_detalle", "cod", "0561");
         asignarAtributo("PAGINA", "contenido_clientes_seleccion_detalle", "msgle", "Presentar clientes");

                  traza("********** titulo...");
                  getConfiguracionMenu("LPPresentarClientes", "Tipos");


                  asignar("VAR", "idioma", this.idioma.toString());
                  asignar("VAR", "pais", this.pais.toString());
                  RecordSet rs = entrada.getResultado();
                  if (rs != null) {
                           Vector cols = rs.getColumnIdentifiers();
                           DruidaConector conectorCargaLista = UtilidadesBelcorp.generarConector("DTOSalida.combo_ROWSET", rs, cols);
                           asignar("LISTAEDITABLE", "listado1", conectorCargaLista, "DTOSalida.combo_ROWSET");
         }
         }
         
         private void obtenerParametros() throws Exception {
                  //Se guardan los parámetros de la página y se guardan en la LP 
                  if (!conectorParametroLimpia("oidCliente", "", true).equals(""))
                           this.oidCliente = new Long(conectorParametroLimpia("oidCliente", "", true));
                  this.codigoCliente = conectorParametroLimpia("codigoCliente", "", true);
                  if (!conectorParametroLimpia("oidTipoCliente", "", true).equals(""))
                           this.oidTipoCliente = new Long(conectorParametroLimpia("oidTipoCliente", "", true));
                  this.codigoTipoCliente = conectorParametroLimpia("codigoTipoCliente", "", true);
                  this.casoDeUso = conectorParametroLimpia("casoDeUso", "", true);
         }

         private void sesionParametrosGuardar() throws Exception {
                  traza("************ sesion");
                  //Se guardan los parámetros de la página y se guardan en la LP 
                  Cache cache = this.getSessionCache();
                  if (!conectorParametroLimpia("oidCliente", "", true).equals(""))
                           cache.put("oidCliente", conectorParametroLimpia("oidCliente", "", true));
                  cache.put("codigoCliente", conectorParametroLimpia("codigoCliente", "", true));
                  if (!conectorParametroLimpia("oidTipoCliente", "", true).equals(""))
                           cache.put("oidTipoCliente", conectorParametroLimpia("oidTipoCliente", "", true));
                  cache.put("codigoTipoCliente", conectorParametroLimpia("codigoTipoCliente", "", true));
                  cache.put("casoDeUso", conectorParametroLimpia("casoDeUso", "", true));
                  traza("********** casoDeuso: " + conectorParametroLimpia("casoDeUso", "", true));

                  cache.put("accion", this.accion + " Recarga");
                  pagina("enlace_ficha");
         }

         private void sesionParametrosRecoger() throws Exception {
                  traza("************ sesion recoger");
                  Cache cache = this.getSessionCache();
                  //Se guardan los parámetros de la página y se guardan en la LP 
                  String parametro =(String)cache.get("oidCliente");
                  if (parametro != null && !parametro.equals("") ) {
                           traza("************ sesion recoger 1");
                           this.oidCliente = new Long(parametro);
                  }
                           traza("************ sesion recoger 11");
                  parametro =(String)cache.get("codigoCliente");
                  if (parametro != null && !parametro.equals("") ) {
                           this.codigoCliente = parametro;
                           traza("************ sesion recoger 2");
                  }
                           traza("************ sesion recoger 22");
                  parametro =(String)cache.get("oidTipoCliente");
                  if (parametro != null && !parametro.equals("") ) {
                           traza("************ sesion recoger 3");
                           this.oidTipoCliente = new Long(parametro);
                  }
                           traza("************ sesion recoger 33");
                  parametro =(String)cache.get("codigoTipoCliente");
                  if (parametro != null && !parametro.equals("") ) {
                           this.codigoTipoCliente = parametro;
                           traza("************ sesion recoger 4");
                  }
                  parametro =(String)cache.get("casoDeUso");
                  if (parametro != null && !parametro.equals("") ) {
                           this.casoDeUso = parametro;
                           traza("************ sesion recoger casoDeuso: " + parametro);
                  }


                           traza("************ sesion recoger 44");
                  cache.clear();
         }


         private Boolean obtenerindConsultoraInterna() throws Exception {
                  //Se guardan los parámetros de la página y se guardan en la LP 
                  String parametro = conectorParametroLimpia("indConsultoraInterna", "", true);
                  if (parametro.equals("S")) return new Boolean(true);
                  else return new Boolean(false);
         }

         private void realizarBloqueoAdministrativo() throws Exception {
                  traza("********** bloqueo");
                  pagina("salidaGenerica");
                  asignar("VAR", "cerrarVentana", "false");
                  asignar("VAR", "ejecutar", "mostrarCAL0001()");
                  this.oidCliente = new Long(conectorParametroLimpia("oidCliente", "", true));
                  //Crear un dtoe del tipo DTOOID con la siguiente información de la LP: 
                  DTOOID dtoOID = new DTOOID();
                  dtoOID.setOid(this.oidCliente);
                  dtoOID.setOidPais(this.pais);
                  dtoOID.setOidIdioma(this.idioma);

                  MareBusinessID idBusiness = new MareBusinessID("CALRealizarBloqueoAdministrativo");

                  // Se almacenan los parametros de entrada
                  Vector paramEntrada = new Vector();
                  paramEntrada.addElement(dtoOID);
                  paramEntrada.addElement(idBusiness);

                  // Se invoca al conector ConectorConsulta para validar los datos
                  try {
                      DruidaConector conector = conectar("ConectorRealizarBloqueoAdministrativo", paramEntrada);
                           asignarAtributo("VAR","ejecutar","valor","procesarBloqueo(" + this.oidCliente + ")");
                  } catch (Exception e)  { 
                           throw e;
         }
         }

    private void procBloqueo() throws Exception {
                  traza("*** Entrada - LPPresentarClientes - procBloqueo ***");
                  //me guardo el cliente SCS

                  pagina("contenido_datos_adicionales_bloqueo");
                  asignar("VAR", "hOidCliente", conectorParametroLimpia("oidCliente", "", true));

                  getConfiguracionMenu("LPPresentarClientes", "ProcesarBloqueo");

                  this.cargaComboTipoBloqueo();

         }

         private void guardarBloqueoAdm() throws Exception {
                  traza("*** Entrada - LPPresentarClientes - guardarBloqueoAdm ***");
                  pagina("salidaGenerica");
                  asignar("VAR", "cerrarVentana", "false");
                  
                  DTOBloqueoAdm dtoGuardBloq = new DTOBloqueoAdm(); 
                  ComposerViewElement elem = new ComposerViewElement();
                  conectorParametroLimpia("hOidCliente", "", true);
         traza("conectorParametroLimpia(...: " + conectorParametroLimpia("hOidCliente", "", true));


                  dtoGuardBloq.setOidTipoBloqueo(new Long(conectorParametroLimpia("hOidTipoBloqueo", "", true)));
                  dtoGuardBloq.setMotivoBloqueo(conectorParametroLimpia("hTxtMotBloq", "", true));
                  dtoGuardBloq.setObsBloqueo(conectorParametroLimpia("hObsBloq", "", true));
                  dtoGuardBloq.setOidCliente(new Long(conectorParametroLimpia("hOidCliente", "", true)));

                  dtoGuardBloq.setOidPais(this.pais);
                  dtoGuardBloq.setOidIdioma(this.idioma);

         Vector params = new Vector();
         params.add(dtoGuardBloq);
         params.add(new MareBusinessID("CALGuardarBloqueoAdm"));
                  traza("voy a guardar!!");

                  try {
             this.conectar("ConectorGuardarBloqAdm", params);
                  } catch (Exception e)  { 
                           throw e;
         }

                  asignarAtributo("VAR","ejecutar","valor","guardBloqOK()");
                  traza("*** Salida  - LPPresentarClientes - guardarBloqueoAdm ***");
         }

         private void cargaComboTipoBloqueo() throws Exception {
                  traza("*** Entrada - LPPresentarClientes - cargaComboTipoBloqueo ***");
         
                  //Cada elemento va a contener el IDbusiness y el DTO que reciben la logica de negocio como entrada. 
                  ComposerViewElementList listelem = new ComposerViewElementList();
                  ComposerViewElement elem = new ComposerViewElement();

                  DTOOID dtoOID = new DTOOID();
                  dtoOID.setOid(this.oidCliente);
                  dtoOID.setOidPais(this.pais);
                  dtoOID.setOidIdioma(this.idioma);

                  elem.setIDBusiness("CALObtenerTipoBloqueo");
                  elem.setDTOE(dtoOID);
                  listelem.addViewElement(elem);

                  /*Se ejecuta el conector y se obtiene un RowSet que contiene todos los datos solicitados.*/ 
                  ConectorComposerView conector = new ConectorComposerView(listelem, this.getRequest());
                  conector.ejecucion();
                  DruidaConector conConsultar = conector.getConector();

                  /*Posterior a la llamada se debe hacer el asignar a los elementos de la pantalla correspondiente utilizando el String que representa el BusinessID en cada caso. */
                  asignar("COMBO", "cbTipoBloqueo", conConsultar, "CALObtenerTipoBloqueo"); 

                  traza("*** Salida - LPPresentarClientes - cargaComboTipoBloqueo ***");
         }

         private void verCuentasCorrientes() throws Exception {
                  traza("********** cc");
                  //Se muestra la página PGCuentasCorrientes y se le pasa:
                  pagina("contenido_clientes_cuentas_corrientes_presentar"); 
                  getConfiguracionMenu("LPPresentarClientes", "Marcos");
                  this.pasoVariablesAPagina();
                  //this.asignarTitulo("contenido_clientes_cuentas_corrientes_presentar");
                  //Deshabilitar todos los campos 
         }

         private void verDirecciones() throws Exception {
                  traza("********** ver direcciones");
                  //Se muestra la página PGDirecciones y se le pasa:
                  pagina("contenido_clientes_direccion_presentar"); 
                  getConfiguracionMenu("LPPresentarClientes", "Marcos");
                  this.pasoVariablesAPagina();
                  //this.asignarTitulo("contenido_clientes_direccion_presentar");
                  //Todos los campos están deshabilitados
         }

         private void verVinculos() throws Exception {
                  traza("********** vinculos");
                  //Se muestra la página PGVinculos y se le pasa: 
                  pagina("contenido_clientes_vinculos_presentar"); 
                  getConfiguracionMenu("LPPresentarClientes", "Marcos");
                  this.pasoVariablesAPagina();
                  //this.asignarTitulo("contenido_clientes_vinculos_presentar");
                  //Todos los campos están deshabilitados
         }

         private void verDocumentos() throws Exception {
                  traza("********** documentos");
                  //Se muestra la página PGDocumentos y se le pasa: 
                  pagina("contenido_clientes_documentos_presentar"); 
                  getConfiguracionMenu("LPPresentarClientes", "Marcos");
                  this.pasoVariablesAPagina();
                  //this.asignarTitulo("contenido_clientes_documentos_presentar");
                  //Todos los campos están deshabilitados
         }

         private void verPedidos() throws Exception {
                  traza("********** pedidos");
                  //Se muestra la página PGPedidos y se le pasa: 
                  pagina("contenido_clientes_pedidos_presentar"); 
                  getConfiguracionMenu("LPPresentarClientes", "Marcos");
                  this.pasoVariablesAPagina();
                  //this.asignarTitulo("contenido_clientes_pedidos_presentar");
                  //Todos los campos están deshabilitados
         }

         /*private void asignarTitulo(String pagina) throws Exception {
                  asignar("VAR", "casoDeUso", conectorParametroLimpia("casoDeUso", "", true));
                  traza("********** caso>uso pestaña: " + conectorParametroLimpia("casoDeUso", "", true));
                  if (!conectorParametroLimpia("casoDeUso", "", true).equals("Presentar"))
                           asignarAtributo("PAGINA", pagina, "cod", "0559");
         }*/

         private void verDatosAdicionalesCabecera() throws Exception {
                  traza("********** mostrar cabecera");
                  //Mostrar la página PGDatosAdicionalesCabecera con la siguiente información:
                  pagina("contenido_pedidos_cabecera");
                  getConfiguracionMenu("LPPresentarClientes", "Detalle");
                  this.mostrarPGDatosAdicionalesCabecera(this.obtenerDatosAdicionalesCabecera());
         }

         private DTOCabeceraPedido obtenerDatosAdicionalesCabecera() throws Exception {
                  traza("********** datos cabecera");
                  //Se recuperan los datos adicionales de la cabecera seleccionada 

                  DTOOID dtoOID = new DTOOID();
                  dtoOID.setOid(new Long(conectorParametroLimpia("oidSolicitudCabecera", "", true)));
                  dtoOID.setOidPais(this.pais);
                  dtoOID.setOidIdioma(this.idioma);

                  MareBusinessID idBusiness = new MareBusinessID("CALObtenerDatosAdicionalesCabecera");

                  // Se almacenan los parametros de entrada
                  Vector paramEntrada = new Vector();
                  paramEntrada.addElement(dtoOID);
                  paramEntrada.addElement(idBusiness);

                  // Se invoca al conector ConectorConsulta para validar los datos
                  DruidaConector conector = conectar("ConectorObtenerDatosAdicionalesCabecera", paramEntrada);
                  return (DTOCabeceraPedido)conector.objeto("DTOCabeceraPedido");
         }
         
         private void pasoVariablesAPagina() throws Exception {
                  asignar("VAR", "idioma", this.idioma.toString());
                  asignar("VAR", "pais", this.pais.toString());
                  asignar("VAR", "oidCliente", conectorParametroLimpia("oidCliente", "", true));
         asignar("VAR", "codCliente", conectorParametroLimpia("codCliente", "", true));
                  //ñññ si ver ficha no genera contacto debemos pasarlo a pagínas
                  //asignar("VAR", "oidContacto", conectorParametroLimpia("oidContacto", "", true));
                  asignar("VAR", "oidTipoCliente", conectorParametroLimpia("oidTipoCliente", "", true));
                  asignar("VAR", "oidSubtipoCliente", conectorParametroLimpia("oidSubtipoCliente", "", true));
                  
                  //agregar por CAL-04
                  if (accion.equals("MostrarFichaPedidoNoFacturado")) {
             asignar("VAR", "indNoFacturado", "Pedido");    
                  }	
                  //fin agrega por CAL-04

                  if (this.indConsultoraInterna.booleanValue())
                           asignar("VAR", "indConsultoraInterna", "S");
                  else
                           asignar("VAR", "indConsultoraInterna", "N");
                  asignar("VAR", "oidContacto", conectorParametroLimpia("oidContacto", "", true));

         }

         private void mostrarPGDatosAdicionalesCabecera(DTOCabeceraPedido entrada) throws Exception {
                  traza("********** mostrar cabecera");
                  asignar("VAR", "idioma", this.idioma.toString());
                  asignar("VAR", "pais", this.pais.toString());
                  asignar("LABELC", "lbldtMotivoAprobacion", this.obtieneCadena(entrada.getMotivoAprobacion())); 
                  asignar("LABELC", "lbldtEstadoCredito", this.obtieneCadena(entrada.getEstadoCredito())); 
                  asignar("LABELC", "lbldtCanal", this.obtieneCadena(entrada.getCanal())); 
                  asignar("LABELC", "lbldtAcceso", this.obtieneCadena(entrada.getAcceso())); 
                  asignar("LABELC", "lbldtSubacceso", this.obtieneCadena(entrada.getLocalSubacceso())); 
                  asignar("LABELC", "lbldtAccesoFisico", this.obtieneCadena(entrada.getAccesoFisico())); 
                  asignar("LABELC", "lbldtDestinatario", this.obtieneCadena(entrada.getDestinatario())); 
                  asignar("LABELC", "lbldtTipoDireccion", this.obtieneCadena(entrada.getDestino())); 
                  asignar("LABELC", "lbldtPagador", this.obtieneCadena(entrada.getPagador())); 
                  asignar("LABELC", "lbldtConsultoraAsociada", this.obtieneCadena(entrada.getConsultoraAsociada())); 
                  asignar("LABELC", "lbldtReceptorFactura", this.obtieneCadena(entrada.getReceptorFactura())); 
                  asignar("LABELC", "lbldtModuloGeneraPedido", this.obtieneCadena(entrada.getModuloGeneraPedido())); 
                  asignar("LABELC", "lbldtEstadisticable", this.obtieneCadena(entrada.getEstadisticable())); 
                  asignar("LABELC", "lbldtAlmacen", this.obtieneCadena(entrada.getAlmacenSalida())); 
                  asignar("LABELC", "lbldtEmpresa", this.obtieneCadena(entrada.getSociedadVentas())); 
                  asignar("LABELC", "lbldtFechaFacturacion", this.obtieneCadenaFecha(entrada.getFechaFacturacion())); 
                  asignar("LABELC", "lbldtFechaProgramadaFacturacion", this.obtieneCadenaFecha(entrada.getFechaProgFacturacion())); 
                  asignar("LABELC", "lbldtObservaciones", this.obtieneCadena(entrada.getGlosa())); 
         }

         private void verDatosAdicionalesDetalle() throws Exception {
                  traza("********** ver detalle");
                  //Mostrar la página PGDatosAdicionalesDetalle con la siguiente información:
                  pagina("contenido_pedidos_detalle");
                  getConfiguracionMenu("LPPresentarClientes", "Detalle");
                  this.mostrarPGDatosAdicionalesDetalle(this.obtenerDatosAdicionalesDetalle());
         }

         private DTODetallePedido obtenerDatosAdicionalesDetalle() throws Exception {
                  traza("********** datos detalle");
                  //Se recuperan los datos adicionales del detalle de cabecera seleccionado 
                  DTOOID dtoOID = new DTOOID();
                  dtoOID.setOid(new Long(conectorParametroLimpia("oidSolicitudPosicion", "", true)));
                  dtoOID.setOidPais(this.pais);
                  dtoOID.setOidIdioma(this.idioma);

                  MareBusinessID idBusiness = new MareBusinessID("CALObtenerDatosAdicionalesDetalle");

                  // Se almacenan los parametros de entrada
                  Vector paramEntrada = new Vector();
                  paramEntrada.addElement(dtoOID);
                  paramEntrada.addElement(idBusiness);

                  // Se invoca al conector ConectorConsulta para validar los datos
                  DruidaConector conector = conectar("ConectorObtenerDatosAdicionalesDetalle", paramEntrada);
                  return (DTODetallePedido)conector.objeto("DTODetallePedido");
         }

         private void mostrarPGDatosAdicionalesDetalle(DTODetallePedido entrada) throws Exception {
                  traza("********** mostrar detalle");
                  asignar("VAR", "idioma", this.idioma.toString());
                  asignar("VAR", "pais", this.pais.toString());
                  asignar("LABELC", "lbldtTipoSolicitudOrigen", this.obtieneCadena(entrada.getTipoSolicitudOrigen())); 
                  asignar("LABELC", "lbldtNumSolicitudOrigen", this.obtieneCadena(entrada.getNumSolicitudOrigen())); 
                  asignar("LABELC", "lbldtEstadoPosicion", this.obtieneCadena(entrada.getEstadoPosicion())); 
                  asignar("LABELC", "lbldtTipoPosicion", this.obtieneCadena(entrada.getTipoPosicion())); 
                  asignar("LABELC", "lbldtNumSolicitudRecuperacion", this.obtieneCadena(entrada.getNumSolicitudRecuperacion())); 
                  asignar("LABELC", "lbldtLimiteVenta", this.obtieneCadena(entrada.getLimiteVenta())); 
                  asignar("LABELC", "lbldtControlStock", this.obtieneCadena(entrada.getControlStock())); 
                  asignar("LABELC", "lbldtControlLiquidacion", this.obtieneCadena(entrada.getControlLiquidacion())); 
                  asignar("LABELC", "lbldtFormaPago", this.obtieneCadena(entrada.getFormaPago())); 
         }

         private void mostrarPGEstadoContacto() throws Exception {
                  traza("*** Entrada - LPPresentarClientes - mostrarPGEstadoContacto ***");
                  //Mostrar la página PGEstadoContacto con la siguiente información:
                  pagina("contenido_estado_contacto_actualizar");
                  getConfiguracionMenu("LPPresentarClientes", "Estado");
                  traza("********** caso>uso: " + conectorParametroLimpia("casoDeUso", "", true));
                  /*if (!conectorParametroLimpia("casoDeUso", "", true).equals("Presentar"))
                           asignarAtributo("PAGINA", "contenido_estado_contacto_actualizar", "cod", "0559");*/

                  asignar("VAR", "idioma", this.idioma.toString());
                  asignar("VAR", "pais", this.pais.toString());
                  DTOBelcorp dtoB = new DTOBelcorp();
                  dtoB.setOidPais(this.pais);
                  dtoB.setOidIdioma(this.idioma);
         
                  //Cada elemento va a contener el IDbusiness y el DTO que reciben la logica de negocio como entrada. 
                  ComposerViewElementList listelem = new ComposerViewElementList();
                  ComposerViewElement elem = new ComposerViewElement();
                  elem.setIDBusiness("CALObtenerEstadoContacto");
                  elem.setDTOE(dtoB);
                  listelem.addViewElement(elem);

                  /*Se ejecuta el conector y se obtiene un RowSet que contiene todos los datos solicitados.*/ 
                  ConectorComposerView conector = new ConectorComposerView(listelem, this.getRequest());
                  conector.ejecucion();
                  DruidaConector conConsultar = conector.getConector();

                  /*
                           Posterior a la llamada se debe hacer el asignar a los elementos de la pantalla
                           correspondiente utilizando el String que representa el BusinessID en cada caso. 
                  */
                  asignar("COMBO", "cbEstadoContacto", conConsultar, "CALObtenerEstadoContacto");
                  String contacto = conectorParametroLimpia("oidContacto", "", true);
                  if (!contacto.equals("")) {
                           asignar("VAR", "oidContacto", contacto);
                           traza("*** oidContacto ***: " + contacto);
                  }

                  traza("*** Salida - LPPresentarClientes - mostrarPGEstadoContacto ***");
        }


    private void asignarTipificacion(DTODescTipificacion dtoE) throws Exception{
         //el dto de entrada contiene un hash con las distintas tipificacion agrupadas.
         if(dtoE.getArbolTipificacionCliente()==null){return;}
         
         RecordSet tipoCliente = new RecordSet();
         RecordSet subTipoCliente = new RecordSet();
         RecordSet tipoClasificacion = new RecordSet();
         RecordSet clasificacion = new RecordSet();

         Vector columnas = new Vector();
         columnas.add("VALUE");
         columnas.add("TEXT");
         
         tipoCliente.setColumnIdentifiers(columnas);
         subTipoCliente.setColumnIdentifiers(columnas);
         tipoClasificacion.setColumnIdentifiers(columnas);
         clasificacion.setColumnIdentifiers(columnas);
         
         HashMap tipoClientes=dtoE.getArbolTipificacionCliente();
         //para asignar los 4 combos generamos un conector para cada
         //uno, teniendo en cuenta que el codigo de cada
         //option debe hacer referencia a la relacion existente entre 
         //los mismos.
         Vector valores = null;
         HashMap subTiposClientes = null;
         HashMap tiposClasificacion = null;
         HashMap clasificaciones = null;
         Iterator itTipoCliente = tipoClientes.keySet().iterator();
         while(itTipoCliente.hasNext()){
             DTOTipificacion dtoTipo = (DTOTipificacion)tipoClientes.get(itTipoCliente.next().toString());
             valores = new Vector();
             //el primer combo lleva el indicador de gerente en el value del option
             valores.add(dtoTipo.getOidTipificacion().toString());
             valores.add(dtoTipo.getDescripcionTipificacion());
             tipoCliente.addRow(valores);
             subTiposClientes = dtoTipo.getDependientesTipificacion();
             if(subTiposClientes!=null && subTiposClientes.size()>0){
                  Iterator itSubTipoCliente = subTiposClientes.keySet().iterator();
                  while(itSubTipoCliente.hasNext()){
                      DTOTipificacion dtoSubTipo = (DTOTipificacion)subTiposClientes.get(itSubTipoCliente.next().toString());
                      valores = new Vector();
                      valores.add(dtoTipo.getDescripcionTipificacion());
                      valores.add(dtoSubTipo.getDescripcionTipificacion());
                      subTipoCliente.addRow(valores);
                      tiposClasificacion = dtoSubTipo.getDependientesTipificacion();
                      if(tiposClasificacion!=null && tiposClasificacion.size()>0){
                           Iterator itTipoClasificacion = tiposClasificacion.keySet().iterator();
                           while(itTipoClasificacion.hasNext()){
                                DTOTipificacion dtoTipoClasificacion = (DTOTipificacion)tiposClasificacion.get(itTipoClasificacion.next().toString());
                                valores = new Vector();
                                valores.add(dtoSubTipo.getDescripcionTipificacion());
                                valores.add(dtoTipoClasificacion.getDescripcionTipificacion());
                                tipoClasificacion.addRow(valores);
                                clasificaciones = dtoTipoClasificacion.getDependientesTipificacion();
                                if(clasificaciones!=null && clasificaciones.size()>0){
                                    Iterator itClasificaciones = clasificaciones.keySet().iterator();
                                    while(itClasificaciones.hasNext()){
                                         DTOTipificacion dtoClasificacion = (DTOTipificacion)clasificaciones.get(itClasificaciones.next().toString());
                                         valores = new Vector();
                                         valores.add(dtoTipoClasificacion.getDescripcionTipificacion());
                                         valores.add(dtoClasificacion.getDescripcionTipificacion());
                                         clasificacion.addRow(valores);
                                    }
                                }
                           }
                      }
                  }                  
             }
         }
         
         DruidaConector conTipoCliente = UtilidadesBelcorp.generarConector("DTOSALIDA_ROWSET", tipoCliente,columnas);
         DruidaConector conSubTipoCliente = UtilidadesBelcorp.generarConector("DTOSALIDA_ROWSET", subTipoCliente,columnas);
         DruidaConector conTipoClasificacion = UtilidadesBelcorp.generarConector("DTOSALIDA_ROWSET", tipoClasificacion,columnas);
         DruidaConector conClasificacion = UtilidadesBelcorp.generarConector("DTOSALIDA_ROWSET", clasificacion,columnas);
         asignar("COMBO", "cbdtTipoCliente", conTipoCliente, "DTOSALIDA_ROWSET");
         asignar("COMBO", "cbdtSubTipoCliente", conSubTipoCliente, "DTOSALIDA_ROWSET");
         asignar("COMBO", "cbdtTipoClasificacion", conTipoClasificacion, "DTOSALIDA_ROWSET");
         asignar("COMBO", "cbdtClasificacion", conClasificacion, "DTOSALIDA_ROWSET");
         
    }

         private void actualizarEstadoContacto() throws Exception {
                  traza("********** actualizar estado");
                  pagina("salidaGenerica");
                  
                  //DBLG5000001030-Gpons
                  asignar("VAR", "cerrarVentana", "false");
                  asignar("VAR", "ejecutar", "fVolver()");

                  //Crear un dtoe del tipo DTOOID con la siguiente información de la LP:
                  String contacto = conectorParametroLimpia("oidContacto", "", true);
                  traza("*** oidContacto actualizar***: " + contacto);

                  DTOContacto dtoContacto = new DTOContacto();
                  dtoContacto.setOidContacto(new Long(contacto));
                  dtoContacto.setOidPais(this.pais);
                  dtoContacto.setOidIdioma(this.idioma);
                  dtoContacto.setOidEstado(new Long(conectorParametroLimpia("cbEstadoContacto", "", true)));
                  dtoContacto.setOidAtributo(new Long(conectorParametroLimpia("cbAtributoEstado", "", true)));

                  MareBusinessID idBusiness = new MareBusinessID("CALActualizarContacto");

                  // Se almacenan los parametros de entrada
                  Vector paramEntrada = new Vector();
                  paramEntrada.addElement(dtoContacto);
                  paramEntrada.addElement(idBusiness);

                  // Se invoca al conector ConectorConsulta para validar los datos
                  DruidaConector conector = conectar("ConectorActualizarContacto", paramEntrada);
         }

         private void logStackTrace(Throwable e) throws Exception {
                traza("Se produjo la excepcion: " + e.getMessage());
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                PrintStream ps = new PrintStream(baos);
                e.printStackTrace(ps);
                traza("Stack Trace: " + baos.toString());
         }

         private String obtieneCadenaFecha(java.util.Date valor) throws Exception {
                  String fecha = new String("");
                traza("************** Fecha: " + valor);
                traza("************** Fecha: " + UtilidadesSession.getFormatoFecha(this));
                  if (valor != null)
                           fecha = UtilidadesBelcorp.fechaFormateada(new java.sql.Date(valor.getTime()), UtilidadesSession.getFormatoFecha(this));
                traza("************** Fecha: " + fecha);
                  return fecha;
         }

         private String obtieneCadena(String valor) throws Exception {
                  if (valor != null)
                           return valor;
                  else return "";
         }

    private DruidaConector generarConectorFormato(String rowsetID, RecordSet datos, Vector columns, Vector colsSinFormato) throws Exception, DOMException {
         StringBuffer salida = new StringBuffer();
         int sizeColums = datos.getColumnCount();
         int sizeRows = datos.getRowCount();
         if(columns == null)
             columns = new Vector();
         Vector columsDesc = datos.getColumnIdentifiers();
         DruidaConector conectorValoresPosibles = new DruidaConector();
         XMLDocument xmlDoc = new XMLDocument();
         Document docDestino = xmlDoc.makeDocument("<ROWSET2/>");
         Element e_rows = docDestino.createElement("ROWSET");
         e_rows.setAttribute("ID", rowsetID);
         docDestino.getDocumentElement().appendChild(e_rows);
         for (int i = 0; i < sizeRows; i++) {
             Element e_row = docDestino.createElement("ROW");
             e_rows.appendChild(e_row);
             for(int j = 0; j < sizeColums; j++)
                  if(columns.contains(columsDesc.elementAt(j))) {
                      Element e_campo2 = docDestino.createElement("CAMPO");
                      e_campo2.setAttribute("NOMBRE", columsDesc.elementAt(j).toString());
                      e_campo2.setAttribute("TIPO", "OBJECTO");
                      e_campo2.setAttribute("LONGITUD", "50");
                      String dato = "";
                      Object datoObj = datos.getValueAt(i, j);
                      if (datoObj != null ) {
                           if (datoObj instanceof BigDecimal && !colsSinFormato.contains(new Integer(j))) {
                                    dato = this.formateaNumerico(datoObj.toString());
                           } else {
                                    dato = datoObj.toString();
                           }
                      }
                      org.w3c.dom.Text txt = docDestino.createTextNode(dato);
                      e_campo2.appendChild(txt);
                      e_row.appendChild(e_campo2);
                  }
         }
         conectorValoresPosibles.setXML(docDestino.getDocumentElement());
         return conectorValoresPosibles;
    }
          
          private String formateaNumerico(String dineroEntrada)  throws Exception{
                    String separadorMiles = ",";
                    String separadorDecimales = UtilidadesSession.getSeparadorDecimales(this);
                    String numeroDecimales = UtilidadesSession.getFormatoNumerico(this);
                    String signo = "";
                    if (separadorDecimales.equals(",")) separadorMiles=".";
                                             if (dineroEntrada.startsWith("-", 0)) {
                                                      signo = "-";
                                                      dineroEntrada = dineroEntrada.substring(1);
                                             }                
                    StringTokenizer tokens=new StringTokenizer(dineroEntrada, ".");
                    StringBuffer bufferEntero=new StringBuffer(tokens.nextToken());// almacena la parte entera.
                    StringBuffer bufferDinero=new StringBuffer();//almacena el resultado
                    StringBuffer bufferDecimales=new StringBuffer();//almacena la parte decimal
                    
                    //Si ya contiene los separadores de mil no formateamos la cadena
                    for (int i=0; i<bufferEntero.length(); i++) {
                              if (bufferEntero.charAt(i) == separadorMiles.charAt(0)) return dineroEntrada;
                    }
                    int miles=0;
                    while (bufferEntero.length()>0) {
                              miles++;
                              bufferDinero.insert(0, bufferEntero.charAt(bufferEntero.length()-1));
                              bufferEntero.deleteCharAt(bufferEntero.length()-1);
                              if (miles==3 && bufferEntero.length()>0) {
                                         miles=0;
                                         bufferDinero.insert(0, separadorMiles);
                              }
                    }

                    if (numeroDecimales != null && tokens.hasMoreTokens()) { 
                              bufferDecimales.append(tokens.nextToken());
                              //Scale siempre vendrá a 00? //creo que en plantillas puede ser de longitud 0
                              if (!bufferDecimales.substring(0, bufferDecimales.length()).equals("00") && !bufferDecimales.substring(0, bufferDecimales.length()).equals("0")) {
                                         if (numeroDecimales.equals("1")) 
                                                   bufferDinero.append(separadorDecimales + bufferDecimales.substring(0,1));
                                         else if (numeroDecimales.equals("2")) {
                                             if (bufferDecimales.length() == 2) 
                                                   bufferDinero.append(separadorDecimales + bufferDecimales.substring(0, 2));
                                             else if (bufferDecimales.length() == 1)
                                                      bufferDinero.append(separadorDecimales + bufferDecimales.substring(0, 1) + "0");
                                         }
                              }
                    }              
                    String resultado = signo + bufferDinero.toString();
                    return resultado;
          }
}