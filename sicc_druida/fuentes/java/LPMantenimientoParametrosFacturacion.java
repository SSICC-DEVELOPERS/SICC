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

import es.indra.sicc.dtos.intsys.DTOParametrosContablesFAC;

import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.UtilidadesSession;

import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.util.Vector;

public class LPMantenimientoParametrosFacturacion extends LPSICCBase {

	private String accion = null;
	private String opcionMenu = null;

	private Long idioma = null;
	private Long pais = null;

	private String strOid = null;
	private String strCodApunte = null;
	private String strTipoAsiento = null;
	private String strCabecDetalle = null;
	private String strDescripcion = null;
	private String strGrupoProductos = null;
	private String strMarcaProductos = null;
	private String strNegocio = null;
	private String strCodSap = null;
	private String strCuentaContable = null;
	private String strDebeHaber = null;
	private String strCodImporte = null;


	public void inicio() throws Exception {
	
	}

	public void ejecucion() throws Exception {
		traza("*** Entrada - LPMantenimientoParametrosFacturacion - ejecucion");

		try	{
			setTrazaFichero();
			rastreo();
			this.pais = UtilidadesSession.getPais(this);
			this.idioma = UtilidadesSession.getIdioma(this);

			this.accion = conectorParametroLimpia("accion", "", true);
			this.opcionMenu = conectorParametroLimpia("opcionMenu", "", true);

			traza("*** accion: " + this.accion);
			traza("*** opcionMenu: " + this.opcionMenu);

			if (accion.equals("")) {
				this.cargarPagina();
			} else if (accion.equals("guardar")) {
				this.guardar();
			} else if (accion.equals("detalle")) {
				this.detalle();
			} else if (accion.equals("modificar")) {
				this.modificar();
			}

		} catch (Exception e) {
			logStackTrace(e);
			lanzarPaginaError(e);
		}

		traza("*** Salida - LPMantenimientoParametrosFacturacion - ejecucion");
	}


	
	
	public void cargarPagina() throws Exception {
		traza("*** Entrada - LPMantenimientoParametros - cargarPagina ***");
		try	{
			if (opcionMenu.equals("insertar")) {
				pagina("contenido_parametros_contables_facturacion_insertar");
				asignarAtributoPagina("cod", "IntParamContaFactu.create.label");
				getConfiguracionMenu("LPMantenimientoParametrosFacturacion", "insertar");
			} else if (opcionMenu.equals("consultar")) {
				pagina("contenido_parametros_contables_facturacion_consultar");
				asignarAtributoPagina("cod", "IntParamContaFactu.query.label");
				getConfiguracionMenu("LPMantenimientoParametrosFacturacion", "consultar");
			} else if (opcionMenu.equals("modificar")) {
				pagina("contenido_parametros_contables_facturacion_consultar");
				asignarAtributoPagina("cod", "IntParamContaFactu.update.label");
				getConfiguracionMenu("LPMantenimientoParametrosFacturacion", "modificar");				
			} else if (opcionMenu.equals("eliminar")) {
				pagina("contenido_parametros_contables_facturacion_consultar");
				asignarAtributoPagina("cod", "IntParamContaFactu.remove.label");
				getConfiguracionMenu("LPMantenimientoParametrosFacturacion", "eliminar");
			}

			asignar("VAR", "accion", this.accion);
			asignar("VAR", "opcionMenu", this.opcionMenu);
			asignar("VAR", "varPais", this.pais.toString());
			asignar("VAR", "varIdioma", this.idioma.toString());

			DTOBelcorp dtob = new DTOBelcorp();
			dtob.setOidPais(this.pais);
			dtob.setOidIdioma(this.idioma);
			
			ComposerViewElementList list = new ComposerViewElementList();
			ComposerViewElement element;

			// Carga del combo de marcas de producto
			element = new ComposerViewElement();
			element.setIDBusiness("SEGRecuperarMarcasProducto");
			element.setDTOE(dtob);
			list.addViewElement(element);

			// Carga del combo de negocios
			element = new ComposerViewElement();
			element.setIDBusiness("MAEObtenerNegocioPorPais");
			element.setDTOE(dtob);
			list.addViewElement(element);

			// Carga del combo de cuentas contables
			element = new ComposerViewElement();
			element.setIDBusiness("CCCObtenerCuentasContables");
			element.setDTOE(dtob);
			list.addViewElement(element);

			// Carga del combo de importes contables
			element = new ComposerViewElement();
			element.setIDBusiness("INTObtenerImportesContablesFAC");
			element.setDTOE(null);
			list.addViewElement(element);

			ConectorComposerView conector = new ConectorComposerView(list, this.getRequest());
			conector.ejecucion();

			traza("*** antes de conectar");
			DruidaConector drdConector = conector.getConector();
			traza("*** despues de conectar");

			// Asigno los combos...
			asignar("COMBO", "cbMarcaProductos", drdConector, "SEGRecuperarMarcasProducto");
			asignar("COMBO", "cbNegocio", drdConector, "MAEObtenerNegocioPorPais");
			asignar("COMBO", "cbCuentaContable", drdConector, "CCCObtenerCuentasContables");
			asignar("COMBO", "cbCodImporte", drdConector, "INTObtenerImportesContablesFAC");

			/*
			 * NOTA dmorello, 19/09/2006:
			 * Los combos de tipo de asiento, indicador cabecera/detalle e
			 * indicador debe/haber se cargan mediante JavaScript
			 */
		} catch (Exception e) {
			logStackTrace(e);
			lanzarPaginaError(e);
		}
		traza("*** Salida - LPMantenimientoParametros - cargarPagina ***");
	}

	
	
	
	public void guardar() throws Exception {
		traza("*** Entrada - LPMantenimientoParametrosFacturacion - guardar ***");
		try	{
			pagina("salidaGenerica");

			// Obtengo de la pagina los valores a guardar
			this.strOid = conectorParametroLimpia("hOid", "", true);
			this.strCodApunte = conectorParametroLimpia("hCodApunte", "", true);
			this.strTipoAsiento = conectorParametroLimpia("hTipoAsiento", "", true);
			this.strCabecDetalle = conectorParametroLimpia("hCabecDetalle", "", true);
			this.strDescripcion = conectorParametroLimpia("hDescripcion", "", true);
			this.strGrupoProductos = conectorParametroLimpia("hGrupoProductos", "", true);
			this.strMarcaProductos = conectorParametroLimpia("hMarcaProductos", "", true);
			this.strNegocio = conectorParametroLimpia("hNegocio", "", true);
			this.strCodSap = conectorParametroLimpia("hCodSap", "", true);
			this.strCuentaContable = conectorParametroLimpia("hCuentaContable", "", true);
			this.strDebeHaber = conectorParametroLimpia("hDebeHaber", "", true);
			this.strCodImporte = conectorParametroLimpia("hCodImporte", "", true);


			// Armo el DTO para enviarlo a parte servidora
			DTOParametrosContablesFAC dto = new DTOParametrosContablesFAC();

			if (strOid.length() > 0) {
				dto.setOid(new Long(strOid));
			} else {
				dto.setOid(null);
			}
			dto.setOidPais(this.pais);
			dto.setOidIdioma(this.idioma);
			dto.setCodApunte(strCodApunte);
			dto.setTipoAsiento(strTipoAsiento);
			dto.setCabeceraDetalle(strCabecDetalle);
			dto.setDescripcion(strDescripcion);
			dto.setGrupoProductos(strGrupoProductos);
			
			if (strMarcaProductos.length() > 0) {
				dto.setMarcaProductos(new Long(strMarcaProductos));
			} else {
				dto.setMarcaProductos(null);
			}
			
			if (strNegocio.length() > 0) {
				dto.setNegocio(new Long(strNegocio));
			} else {
				dto.setNegocio(null);
			}
			
			dto.setCodProductoSAP(strCodSap);
			dto.setCuentaContable(new Long(strCuentaContable));
			dto.setDebeHaber(strDebeHaber);
			dto.setCodImporte(new Long(strCodImporte));

			traza("dto: " + dto);

			MareBusinessID idBusiness = new MareBusinessID("INTActualizarParametrosContablesFAC");

			Vector params = new Vector();
			params.add(dto);
			params.add(idBusiness);

			try	{
				traza("*** antes de conectar para guardar...");
				DruidaConector conector = conectar("ConectorActualizarParametrosContablesFAC", params);
				traza("*** despues de conectar para guardar...");
			} catch (Exception e) {
				asignarAtributo("VAR", "ejecutarError", "valor", "errorAlGuardar()");
				throw e;
			}
			asignarAtributo("VAR", "ejecutar", "valor", "guardoCorrectamente()");

		} catch (Exception e) {
			logStackTrace(e);
			lanzarPaginaError(e);
		}
		traza("*** Salida - LPMantenimientoParametrosFacturacion - guardar ***");
	}

	public void detalle() throws Exception {
		traza("*** Entrada - LPMantenimientoParametrosFacturacion - detalle ***");
		try	{
			// Se entra en este metodo cuando accion == "detalle"

			// Obtengo los datos desde la ventana llamante
			this.strOid = conectorParametroLimpia("hOid", "", true);
			this.strCodApunte = conectorParametroLimpia("hCodApunte", "", true);
			this.strTipoAsiento = conectorParametroLimpia("hTipoAsiento", "", true);
			this.strCabecDetalle = conectorParametroLimpia("hCabecDetalle", "", true);
			this.strDescripcion = conectorParametroLimpia("hDescripcion", "", true);
			this.strGrupoProductos = conectorParametroLimpia("hGrupoProductos", "", true);
			this.strMarcaProductos = conectorParametroLimpia("hMarcaProductos", "", true);
			this.strNegocio = conectorParametroLimpia("hNegocio", "", true);
			this.strCodSap = conectorParametroLimpia("hCodSap", "", true);
			this.strCuentaContable = conectorParametroLimpia("hCuentaContable", "", true);
			this.strDebeHaber = conectorParametroLimpia("hDebeHaber", "", true);
			this.strCodImporte = conectorParametroLimpia("hCodImporte", "", true);

			// Cargo pagina de detalle
			pagina("contenido_parametros_contables_facturacion_insertar");
			asignarAtributoPagina("cod", "IntParamContaFactu.view.label");
			getConfiguracionMenu("LPMantenimientoParametrosFacturacion", "detalle");

			asignar("VAR", "accion", this.accion);
			asignar("VAR", "opcionMenu", this.opcionMenu);
			asignar("VAR", "varPais", this.pais.toString());
			asignar("VAR", "varIdioma", this.idioma.toString());

			// Asigno valores obtenidos a la pagina recien cargada
			asignar("VAR", "hOid", strOid);
			asignar("VAR", "hCodApunte", strCodApunte);
			asignar("VAR", "hTipoAsiento", strTipoAsiento);
			asignar("VAR", "hCabecDetalle", strCabecDetalle);
			asignar("VAR", "hDescripcion", strDescripcion);
			asignar("VAR", "hGrupoProductos", strGrupoProductos);
			asignar("VAR", "hMarcaProductos", strMarcaProductos);
			asignar("VAR", "hNegocio", strNegocio);
			asignar("VAR", "hCodSap", strCodSap);
			asignar("VAR", "hCuentaContable", strCuentaContable);
			asignar("VAR", "hDebeHaber", strDebeHaber);
			asignar("VAR", "hCodImporte", strCodImporte);


		} catch (Exception e) {
			logStackTrace(e);
			lanzarPaginaError(e);
		}
		traza("*** Salida - LPMantenimientoParametrosFacturacion - detalle ***");
	}

	public void modificar() throws Exception {
		traza("*** Entrada - LPMantenimientoAutorizacion - modificar ***");
		try	{
			// Entramos aca con accion == "modificar"

			// Obtengo los datos desde la ventana llamante
			this.strOid = conectorParametroLimpia("hOid", "", true);
			this.strCodApunte = conectorParametroLimpia("hCodApunte", "", true);
			this.strTipoAsiento = conectorParametroLimpia("hTipoAsiento", "", true);
			this.strCabecDetalle = conectorParametroLimpia("hCabecDetalle", "", true);
			this.strDescripcion = conectorParametroLimpia("hDescripcion", "", true);
			this.strGrupoProductos = conectorParametroLimpia("hGrupoProductos", "", true);
			this.strMarcaProductos = conectorParametroLimpia("hMarcaProductos", "", true);
			this.strNegocio = conectorParametroLimpia("hNegocio", "", true);
			this.strCodSap = conectorParametroLimpia("hCodSap", "", true);
			this.strCuentaContable = conectorParametroLimpia("hCuentaContable", "", true);
			this.strDebeHaber = conectorParametroLimpia("hDebeHaber", "", true);
			this.strCodImporte = conectorParametroLimpia("hCodImporte", "", true);

			// Cargo pagina de detalle
			pagina("contenido_parametros_contables_facturacion_insertar");
			asignarAtributoPagina("cod", "IntParamContaFactu.update.label");
			getConfiguracionMenu("LPMantenimientoParametrosFacturacion", "detalleModificar");

			asignar("VAR", "accion", this.accion);
			asignar("VAR", "opcionMenu", this.opcionMenu);
			asignar("VAR", "varPais", this.pais.toString());
			asignar("VAR", "varIdioma", this.idioma.toString());

			DTOBelcorp dtob = new DTOBelcorp();
			dtob.setOidPais(this.pais);
			dtob.setOidIdioma(this.idioma);
			
			ComposerViewElementList list = new ComposerViewElementList();
			ComposerViewElement element;

			// Carga del combo de marcas de producto
			element = new ComposerViewElement();
			element.setIDBusiness("SEGRecuperarMarcasProducto");
			element.setDTOE(dtob);
			list.addViewElement(element);

			// Carga del combo de negocios
			element = new ComposerViewElement();
			element.setIDBusiness("MAEObtenerNegocioPorPais");
			element.setDTOE(dtob);
			list.addViewElement(element);

			// Carga del combo de cuentas contables
			element = new ComposerViewElement();
			element.setIDBusiness("CCCObtenerCuentasContables");
			element.setDTOE(dtob);
			list.addViewElement(element);

			// Carga del combo de importes contables
			element = new ComposerViewElement();
			element.setIDBusiness("INTObtenerImportesContablesFAC");
			element.setDTOE(null);
			list.addViewElement(element);

			ConectorComposerView conector = new ConectorComposerView(list, this.getRequest());
			conector.ejecucion();

			traza("*** antes de conectar");
			DruidaConector drdConector = conector.getConector();
			traza("*** despues de conectar");

			// Asigno los combos...
			asignar("COMBO", "cbMarcaProductos", drdConector, "SEGRecuperarMarcasProducto");
			asignar("COMBO", "cbNegocio", drdConector, "MAEObtenerNegocioPorPais");
			asignar("COMBO", "cbCuentaContable", drdConector, "CCCObtenerCuentasContables");
			asignar("COMBO", "cbCodImporte", drdConector, "INTObtenerImportesContablesFAC");

			/*
			 * NOTA dmorello, 19/09/2006:
			 * Los combos de tipo de asiento, indicador cabecera/detalle e
			 * indicador debe/haber se cargan mediante JavaScript
			 */

			// Asigno valores obtenidos a la pagina recien cargada
			asignar("VAR", "hOid", strOid);
			asignar("VAR", "hCodApunte", strCodApunte);
			asignar("VAR", "hTipoAsiento", strTipoAsiento);
			asignar("VAR", "hCabecDetalle", strCabecDetalle);
			asignar("VAR", "hDescripcion", strDescripcion);
			asignar("VAR", "hGrupoProductos", strGrupoProductos);
			asignar("VAR", "hMarcaProductos", strMarcaProductos);
			asignar("VAR", "hNegocio", strNegocio);
			asignar("VAR", "hCodSap", strCodSap);
			asignar("VAR", "hCuentaContable", strCuentaContable);
			asignar("VAR", "hDebeHaber", strDebeHaber);
			asignar("VAR", "hCodImporte", strCodImporte);

		} catch (Exception e) {
			logStackTrace(e);
			lanzarPaginaError(e);
		}
		traza("*** Salida - LPMantenimientoAutorizacion - modificar ***");
	}

	
	protected void logStackTrace(Throwable e) throws Exception {  
		traza("Se produjo la excepcion: " + e.getMessage());        

		ByteArrayOutputStream baos = new ByteArrayOutputStream();  
		PrintStream ps = new PrintStream(baos);                      
		e.printStackTrace(ps);                                          

		traza("Stack Trace: " + baos.toString());                    
	} 

}