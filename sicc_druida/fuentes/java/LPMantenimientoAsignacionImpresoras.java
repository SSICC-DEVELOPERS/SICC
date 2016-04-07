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
  
import es.indra.sicc.dtos.fac.DTOAsignacionImpresoras;

import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.Vector;


public class LPMantenimientoAsignacionImpresoras extends LPSICCBase {


	private Long pais = null;
	private Long idioma = null;
	private String accion = null;
	private String opcionMenu = null;


	public void inicio() throws Exception {

	}

	public void ejecucion() throws Exception {
		traza("*** Entrada - LPMantenimientoAsignacionImpresoras - ejecucion ");
		setTrazaFichero();
		try	{
			rastreo();

			this.pais = UtilidadesSession.getPais(this);
			this.idioma = UtilidadesSession.getIdioma(this);
			this.accion = this.conectorParametroLimpia("accion", "", true);
			this.opcionMenu = this.conectorParametroLimpia("opcionMenu", "", true);

			if (accion.equals("")) {
				this.cargarPagina();
			} else if (accion.equals("guardar")) {
				this.guardar();
			} else if (accion.equals("detalle")) {
				this.detalle();
			}
		} catch (Exception e) {
			traza("*** Exception en LPMantenimientoAsignacionImpresoras");
			e.printStackTrace();
			lanzarPaginaError(e);
		}

		traza("*** Salida - LPMantenimientoAsignacionImpresoras - ejecucion ");
	}


	public void cargarPagina() throws Exception {
		traza("*** Entrada - LPMantenimientoAsignacionImpresoras - cargarPagina ");
		try	{

			if (this.opcionMenu.equals("consultar") || this.opcionMenu.equals("eliminar")) {
				pagina("contenido_asignacion_impresoras_consultar");
			} else if (this.opcionMenu.equals("insertar")) {
				pagina("contenido_asignacion_impresoras_insertar");
			}
			getFormatosValidaciones();


			DTOBelcorp dtob = new DTOBelcorp();
			dtob.setOidPais(this.pais);
			dtob.setOidIdioma(this.idioma);

			traza("dtob: " + dtob);

			ComposerViewElementList list = new ComposerViewElementList();
			ComposerViewElement element;

			// Obtenemos las impresoras virtuales
			element = new ComposerViewElement();
			element.setIDBusiness("FACObtenerImpresorasVirtuales");
			element.setDTOE(null);
			list.addViewElement(element);

			// Obtenemos los canales
			element = new ComposerViewElement();
			element.setIDBusiness("SEGConsultaCanales");
			element.setDTOE(dtob);
			list.addViewElement(element);

			// Obtenemos los formularios
			element = new ComposerViewElement();
			element.setIDBusiness("FACObtenerFormularios");
			element.setDTOE(null);
			list.addViewElement(element);


			ConectorComposerView conector = new ConectorComposerView(list, this.getRequest());
			conector.ejecucion();

			traza("*** antes de conectar");	
			DruidaConector drdConector = conector.getConector();
			traza("*** despues de conectar ");

			// Asigno los combos
			asignar("COMBO", "cbImprVirtual", drdConector, "FACObtenerImpresorasVirtuales");
			asignar("COMBO", "cbCanal", drdConector, "SEGConsultaCanales");
			asignar("COMBO", "cbFormulario", drdConector, "FACObtenerFormularios");

			// Cargo titulo y menu secundario
			if (this.opcionMenu.equals("insertar")) {
				asignarAtributoPagina("cod", "FacAsignImpre.create.label");
				getConfiguracionMenu("LPMantenimientoAsignacionImpresoras", "insertar");
			} else if (this.opcionMenu.equals("consultar")) {
				asignarAtributoPagina("cod", "FacAsignImpre.query.label");
				getConfiguracionMenu("LPMantenimientoAsignacionImpresoras", "consultar");
			} else if (this.opcionMenu.equals("eliminar")) {
				asignarAtributoPagina("cod", "FacAsignImpre.remove.label");
				getConfiguracionMenu("LPMantenimientoAsignacionImpresoras", "eliminar");
			}


			asignar("VAR", "varPais", this.pais.toString());
			asignar("VAR", "varIdioma", this.idioma.toString());
			asignar("VAR", "accion", this.accion);
			asignar("VAR", "opcionMenu", this.opcionMenu);

			// TODO: hab/deshab de botones

		} catch (Exception e) {
			logStackTrace(e);
			lanzarPaginaError(e);
		}


		traza("*** Salida - LPMantenimientoAsignacionImpresoras - cargarPagina ");
	}


	public void guardar() throws Exception {
		traza("*** Entrada - LPMantenimientoAsignacionImpresoras - guardar ");

		try	{

			pagina("salidaGenerica");
			this.asignarAtributo("VAR", "cerrarVentana", "valor", "false");
			this.asignarAtributo("VAR","ejecutar","valor","guardoCorrectamente('" + opcionMenu + "')");

			// Obtengo datos para crear el DTO
			String strOidImpresora = conectorParametroLimpia("hImpresora", "", true);
			String strOidSubacceso = conectorParametroLimpia("hSubacceso", "", true);
			String strOidFormulario = conectorParametroLimpia("hFormulario", "", true);
			
			// Creo el DTO
			DTOAsignacionImpresoras dto = new DTOAsignacionImpresoras();
			dto.setImpresoraVirtual(new Long(strOidImpresora));
			dto.setSubAcceso(new Long(strOidSubacceso));
			dto.setFormulario(new Long(strOidFormulario));
			traza("dto: " + dto);

			MareBusinessID id = new MareBusinessID("FACGuardarAsignacionImpresoras");
			Vector paramsEntrada = new Vector();
			paramsEntrada.add(dto);
			paramsEntrada.add(id);

			// Guardo...
			try	{
				traza("*** Antes de conectar para guardar");
				DruidaConector conector = conectar("ConectorGuardarAsignacionImpresoras", paramsEntrada);
				traza("*** Despues de conectar para guardar");
				this.asignarAtributo("VAR", "ejecutar", "valor", "guardoCorrectamente('" + this.opcionMenu + "')");
			} catch (Exception e) {
				this.asignarAtributo("VAR","ejecutarError","valor","noPudoGuardar()");
				throw e;
			}

		} catch (Exception e) {
			logStackTrace(e);
			lanzarPaginaError(e);
		}

		traza("*** Salida - LPMantenimientoAsignacionImpresoras - guardar ");
	}


	public void detalle() throws Exception {
		traza("*** Entrada - LPMantenimientoAsignacionImpresoras - detalle ");

		try	{
			
			// Obtengo los datos de la ventana llamante
			String descImpresora = conectorParametroLimpia("hImpresora", "", true);
			String descCanal = conectorParametroLimpia("hCanal", "", true);
			String descAcceso = conectorParametroLimpia("hAcceso", "", true);
			String descSubacceso = conectorParametroLimpia("hSubacceso", "", true);
			String descFormulario = conectorParametroLimpia("hFormulario", "", true);

			// Cargo la pagina para mostrar el detalle
			pagina("contenido_asignacion_impresoras_insertar");
			getFormatosValidaciones();

			asignar("VAR", "varPais", this.pais.toString());
			asignar("VAR", "varIdioma", this.idioma.toString());
			asignar("VAR", "accion", this.accion);
			asignar("VAR", "opcionMenu", this.opcionMenu);

			// Cargo la info para llenar los combos
			asignarAtributo("VAR", "hImpresora", "valor", descImpresora);
			asignarAtributo("VAR", "hCanal", "valor", descCanal);
			asignarAtributo("VAR", "hAcceso", "valor", descAcceso);
			asignarAtributo("VAR", "hSubacceso", "valor", descSubacceso);
			asignarAtributo("VAR", "hFormulario", "valor", descFormulario);

			this.asignarAtributoPagina("cod", "FacAsignImpre.view.label");
			getConfiguracionMenu("LPMantenimientoAsignacionImpresoras", "detalle");

			// TODO: hab/deshab de botones (en JavaScript)


		} catch (Exception e) {
			logStackTrace(e);
			lanzarPaginaError(e);
		}

		traza("*** Salida - LPMantenimientoAsignacionImpresoras - detalle ");
	}


	protected void logStackTrace(Throwable e) throws Exception {  
		traza("Se produjo la excepcion: " + e.getMessage());        

		ByteArrayOutputStream baos = new ByteArrayOutputStream();  
		PrintStream ps = new PrintStream(baos);                      
		e.printStackTrace(ps);                                          

		traza("Stack Trace: " + baos.toString());                    
	} 



}