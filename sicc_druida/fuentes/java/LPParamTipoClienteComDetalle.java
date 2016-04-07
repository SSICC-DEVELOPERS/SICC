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


import es.indra.druida.DruidaConector;

import es.indra.mare.common.mln.MareBusinessID;

import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
  
import es.indra.sicc.dtos.com.DTOTipoClienteComDetalle;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.Vector;


public class LPParamTipoClienteComDetalle extends LPSICCBase {

	private String accion = null;
	private String opcionMenu = null;
	private Long idioma = null;
	private Long pais = null;
  
  private String cbSubClasificacion = null;
  private String cbTipoCliente = null;
  private String cbSubTipoCliente = null;
  private String cbTipoClasificacion = null;
  private String cbClasificacion = null;
  private String txtDescripcion = null;
 
 
	public LPParamTipoClienteComDetalle() {
		super();
	}

	
	public void inicio() throws Exception { }


	public void ejecucion() throws Exception {

		rastreo();
		try {
			setTrazaFichero(); 
			traza("*** Entrada - LPParamTipoClienteComDetalle - ejecucion ***");

			this.pais = UtilidadesSession.getPais(this);
			this.idioma = UtilidadesSession.getIdioma(this);

			this.accion = conectorParametroLimpia("accion", "", true);
			this.opcionMenu = conectorParametroLimpia("opcionMenu", "", true);

			traza("***** accion: " + accion);
			traza("***** opcionMenu: " + opcionMenu);

			if (accion.equals("")) {
					
			} 
			if (accion.equals("insertar")) {
			  this.cargarPagina();
			} 
			if (accion.equals("modificar")) {
			  this.cargarPagina();
			} 
			if (accion.equals("eliminar")) {
			  this.cargarPagina();
			} 
			if (accion.equals("consultar")) {
			  this.cargarPagina();
			} 
			if (accion.equals("detalleModificar")) {
			  this.detalleClienteCom();
			} 
			if (accion.equals("detalle")) {
			  this.detalleClienteCom();        
			} 
			if (accion.equals("guardar")) {
			  guardar();
			}                                                         
          traza("*** Salida - LPParamTipoClienteComDetalle - ejecucion ***");
		} catch (Exception e) {
			 //logStackTrace(e);
			 lanzarPaginaError(e);
		}

	}
  
  
  	private void cargarPagina() throws Exception {

		traza("*** Entrada - LPParamTipoClienteComDetalle - cargarPagina ***");
		
		try{
      
			DTOBelcorp dtoe = new DTOBelcorp();
			dtoe.setOidPais(this.pais);
			dtoe.setOidIdioma(this.idioma);

			traza("*** dtoe: " + dtoe);

			ComposerViewElementList list = new ComposerViewElementList();

			// Obtenemos los usuarios
			ComposerViewElement elem = new ComposerViewElement();
			elem.setIDBusiness("COMObtenerTipoClienteCOMGerente");
			elem.setDTOE(dtoe);
			list.addViewElement(elem);

			// Obtenemos las operaciones
			elem = new ComposerViewElement();
			elem.setIDBusiness("MAEObtenerTipos");
			elem.setDTOE(dtoe);
			list.addViewElement(elem);

		    ConectorComposerView conector = new ConectorComposerView(list, this.getRequest());
			conector.ejecucion();

			traza("*** antes de conectar");	
			DruidaConector drdConector = conector.getConector();
			traza("*** despues de conectar ");
      

			// Cargo titulo y menu secundario
			if (accion.equals("insertar")) {
				
				pagina("contenido_tipo_cliente_com_detalle_insertar");
				getFormatosValidaciones();
				
				traza("antes de anyadeHiddensI18N");
				anyadeHiddensI18N(true, "COM_TIPO_CLIEN_COMIS_DETAL", null , 
					new Integer(1),  "formulario", "txtDescripcion", false);
				traza("despues de anyadeHiddensI18N");

				asignarAtributoPagina("cod", "ComTipoClienComisDetal.create.label");
				getConfiguracionMenu("LPParamTipoClienteComDetalle", "insertar");

			}else if (accion.equals("modificar")) {
			
				pagina("contenido_tipo_cliente_com_detalle_consultar");
				getFormatosValidaciones();

				traza("antes de anyadeHiddensI18N");
				anyadeHiddensI18N(true, "COM_TIPO_CLIEN_COMIS_DETAL", null , 
					new Integer(1),  "formulario", "txtDescripcion", false);
				traza("despues de anyadeHiddensI18N");

				asignarAtributoPagina("cod", "ComTipoClienComisDetal.update.label");
				getConfiguracionMenu("LPParamTipoClienteComDetalle", "modificar");

			} else if (accion.equals("consultar")) {

				traza("en consultar entes de pagina");
				pagina("contenido_tipo_cliente_com_detalle_consultar");                  
				getFormatosValidaciones();
				
				traza("antes de anyadeHiddensI18N");
				anyadeHiddensI18N(true, "COM_TIPO_CLIEN_COMIS_DETAL", null , 
					new Integer(1),  "formulario", "txtDescripcion", false);
				traza("despues de anyadeHiddensI18N");

				asignarAtributoPagina("cod", "ComTipoClienComisDetal.query.label");
				getConfiguracionMenu("LPParamTipoClienteComDetalle", "consultar");

			} else if (accion.equals("eliminar")) {

				pagina("contenido_tipo_cliente_com_detalle_consultar");
				getFormatosValidaciones();          
				asignarAtributoPagina("cod", "ComTipoClienComisDetal.remove.label");
				getConfiguracionMenu("LPParamTipoClienteComDetalle", "eliminar");

			} else if (accion.equals("detalleModificar")) {

				pagina("contenido_tipo_cliente_com_detalle_insertar");
				getFormatosValidaciones();
				getConfiguracionMenu("LPParamTipoClienteComDetalle", "detalleModificar");
				asignarAtributoPagina("cod", "ComTipoClienComisDetal.update.label");			

				anyadeHiddensI18N(true, "COM_TIPO_CLIEN_COMIS_DETAL", convToLong("hOidTipoClieDet") , 
					new Integer(1),  "formulario", "txtDescripcion", false);

				asignarCombo("hOid", convToLong("hOidTipoClieDet"));

			} else if (accion.equals("detalle")) {

				pagina("contenido_tipo_cliente_com_detalle_insertar");
				getFormatosValidaciones();
				
				traza("antes de anyadeHiddensI18N");
				anyadeHiddensI18N(true, "COM_TIPO_CLIEN_COMIS_DETAL", convToLong("hOidTipoClieDet") , 
					new Integer(1),  "formulario", "txtDescripcion", true);
				traza("despues de anyadeHiddensI18N");
				
				getConfiguracionMenu("LPParamTipoClienteComDetalle", "detalle");
				asignarAtributoPagina("cod", "ComTipoClienComisDetal.view.label");
			}
      
			// Asigno los combos...
			asignar("COMBO", "cbSubClasificacion", drdConector, "COMObtenerTipoClienteCOMGerente"); 
			asignar("COMBO", "cbTipoCliente", drdConector, "MAEObtenerTipos");

			asignar("VAR", "pais", this.pais.toString());
			asignar("VAR", "idioma", this.idioma.toString());
			asignar("VAR", "opcionMenu", this.opcionMenu);
			asignar("VAR", "accion", this.accion);

			traza("*** pais: " + this.pais);
			traza("*** idioma: " + this.idioma);
			
		} catch (Exception e){
			//logStackTrace(e);
			lanzarPaginaError(e);
		}
		traza("*** Salida - LPParamTipoClienteComDetalle - cargarPagina ***");
	}
  
  	private void guardar() throws Exception {

		traza("*** Entrada - LPParamTipoClienteComDetalle - guardar ***");
		pagina("contenido_tipo_cliente_com_detalle_insertar");

		try	{
			traza("antes de anyadeHiddensI18N");
				anyadeHiddensI18N(false, "COM_TIPO_CLIEN_COMIS_DETAL", null , new Integer(1),
					"formulario", "txtDescripcion", false);
			traza("despues de anyadeHiddensI18N");
			this.asignarAtributo("VAR", "cerrarVentana", "valor", "false");      

			/*
			->Con los parámetros de la pantalla llamante crear un DTOTipoClienteComDetalle "dtoEntrada" 
			dtoEntrada.setIdSubclasificacion = cbIdSubClasificacion 
			dtoEntrada.setTipoCliente = cbTipoCliente 
			dtoEntrada.setSubtipoCliente = cbSubtipoCliente 
			dtoEntrada.setTipoClasificacion = cbTipoClasificacion 
			dtoEntrada.setClasificacion = cbClasificacion 
			dtoEntrada.oidTipoClienteComDetalle = oid del hidden oid 
			dtoEntrada.vectorTraducciones = recuperaTraduccionesI18N(1) 


			-> Asignar el conector ConectorGuardarTipoClienteComDetalle con: 
			->idBBusiness = COMGuardarTipoClienteComDetalle 
			->dtoEntrada 

			*/



			DTOTipoClienteComDetalle dtoEntrada = new DTOTipoClienteComDetalle();

			if ( opcionMenu.equals("modificarTipoClienteCom")) {
				dtoEntrada.setOidTipoClienteComDetalle(convToLong("hOid"));
			}

			dtoEntrada.setIdSubclasificacion(convToLong("cbSubClasificacion"));
			dtoEntrada.setOidTipoCliente(convToLong("cbTipoCliente"));
			dtoEntrada.setOidSubtipoCliente(convToLong("cbSubTipoCliente"));
			dtoEntrada.setOidTipoClasificacion(convToLong("cbTipoClasificacion"));
			dtoEntrada.setOidClasificacion(convToLong("cbClasificacion"));
			dtoEntrada.setVectorTraducciones(recuperaTraduccionesI18N(new Integer(1)));

			traza("*** dtoAuto: " + dtoEntrada);

			MareBusinessID idBusiness = new MareBusinessID("COMGuardarTipoClienteComDetalle");

			Vector paramsEntrada = new Vector();
			paramsEntrada.add(dtoEntrada);
			paramsEntrada.add(idBusiness);

			pagina("salidaGenerica");
			asignarAtributo("VAR","ejecutar","valor","guardoCorrectamente('" + opcionMenu + "')");
			asignarAtributo("VAR","ejecutarError","valor","noPudoGuardar()");


			try	{
				traza("*** Antes de conectar para guardar");
				DruidaConector conector = conectar("ConectorGuardarTipoClienteComDetalle", paramsEntrada);
				traza("*** Despues de conectar para guardar");
			} catch (Exception e) {
				asignarAtributo("VAR", "ejecutarError", "valor", "fErrorAlGuardar();");
				throw e;
			}

			//asignarAtributo("VAR", "ejecutar", "valor", "limpiarCampos()");
			if(opcionMenu.equals("ModificarDetalleCom")){
				asignarAtributo("VAR", "cerrar", "valor", "S");          
			}

		} catch (Exception e) {
			//logStackTrace(e);
			lanzarPaginaError(e);
		}

		traza("*** Salida - LPParamTipoClienteComDetalle - guardar ***");

	}

	private Long convToLong(String parametro) throws Exception{

		String conector = null; 

		if (parametro != null) {		
			conector = conectorParametroLimpia(parametro, "", true);
			traza("*** " + getClass().getName() + " - convToLong elemento: " + parametro + "  valor:  " + conector);
		} else {
			traza("*** " + getClass().getName() + " - convToLong elemento: " + parametro + "  valor:  nulo ");
		}


		if ((conector != null) && (!conector.equals(""))) {
		   return new Long(conector);
		} else {
		   return null;
		}
	}

	private String convToString(String parametro) throws Exception{

		String conector = null; 

		if (parametro != null) {		
			conector = conectorParametroLimpia(parametro, "", true);
			traza("*** " + getClass().getName() + " - convToString elemento: " + parametro + "  valor:  " + conector);
		} else {
			traza("*** " + getClass().getName() + " - convToString elemento: " + parametro + "  valor:  nulo ");
		}

		if (conector != null) {
			return conector;
		} else {
			return null;
		}
	}

	private void asignarCombo(String varNombreCombo, Object valor) throws Exception {

		traza("*** " + getClass().getName() + " - asignarCombo - Entrada");

		asignarAtributo("VAR", varNombreCombo, "valor", (valor == null) ? "" : valor.toString());
		
		traza("*** " + getClass().getName() + " - asignarCombo - Salida");
	}

   
	private void detalleClienteCom() throws Exception {
		traza("*** Entrada - LPParamTipoClienteComDetalle - detalleClienteCom ***");

		try	{

//			pagina("contenido_tipo_cliente_com_detalle_consultar");

			cbSubClasificacion = convToString("hOidSubClasificacion");
			cbTipoCliente = convToString("hOidTipoCliente");
			cbSubTipoCliente = convToString("hOidSubTipoCliente");
			cbTipoClasificacion = convToString("hOidTipoClasificacion");
			cbClasificacion = convToString("hOidClasificacion");
			txtDescripcion = convToString("htxtDescripcion");

			this.cargarPagina();
/*
			anyadeHiddensI18N(true, "COM_TIPO_CLIEN_COMIS_DETAL", null , 
				new Integer(1),  "formulario", "txtDescripcion", true);
*/
			//Asigno los campos
			asignarCombo("hOidSubClasificacion", cbSubClasificacion);
			asignarCombo("hOidTipoCliente", cbTipoCliente);
			asignarCombo("hOidSubTipoCliente", cbSubTipoCliente);
			asignarCombo("hOidTipoClasificacion", cbTipoClasificacion);
			asignarCombo("hOidClasificacion", cbClasificacion);
			asignarCombo("htxtDescripcion", txtDescripcion);

		} catch (Exception e) {
			//logStackTrace(e);
			lanzarPaginaError(e);
		}

		traza("*** Salida - LPParamTipoClienteComDetalle - detalleClienteCom ***");
	}

   
   
}
