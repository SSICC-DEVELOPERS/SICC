/**
 * Copyright 2007 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 *
 */

import es.indra.druida.DruidaConector;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.dtos.ape.DTOImpresionEtiquetas;
import es.indra.sicc.dtos.ape.DTOImpresionEtiquetasManual;
import es.indra.sicc.logicanegocio.ape.ConstantesAPE;
import es.indra.sicc.util.UtilidadesSession;
import java.text.SimpleDateFormat; 
import java.util.Date; 
import java.util.Vector;

public class LPImprimirEtiquetasManual extends LPSICCBase {

	private Long pais = null;
	private Long idioma = null;
	private String accion = null;
	private String casoUso = null;

	public void inicio() throws Exception {  }

	public void ejecucion() throws Exception {
		setTrazaFichero();
		traza("*** Entrada - LPImprimirEtiquetasManual - ejecucion ***");
		try {

			this.pais = UtilidadesSession.getPais(this);
			this.idioma = UtilidadesSession.getIdioma(this);
			this.accion = conectorParametroLimpia("accion", "", true);

			traza("pais = " + this.pais);
			traza("idioma = " + this.idioma);
			traza("accion = " + this.accion);

			if (accion.equals("imprimir")) {
				this.cargarPantalla();
			} else if (accion.equals("buscarEtiquetas")) {
				this.buscarEtiquetas();
			} else if (accion.equals("imprimirSeleccion")) {
				this.imprimirSeleccion();
			} else if (accion.equals("reimprimir")) {
				this.reimprimir();
			} else if (accion.equals("buscarEtiquetasReimprimir")) {
				this.buscarEtiquetas();
			} else if (accion.equals("reimprimirSeleccion")) {
				this.imprimirSeleccion();
			} else if (accion.equals("imprimirEtiquetasConsolidadoCaja")) { 
				this.imprimirEtiquetasConsolidadoCaja(); 
			}

		} catch (Exception e) {
			traza("Exception en LPImprimirEtiquetasManual.ejecucion()");
			e.printStackTrace();
			lanzarPaginaError(e);
		}
		traza("*** Salida - LPImprimirEtiquetasManual - ejecucion ***");
	}


	
	public void cargarPantalla() throws Exception {
		traza("*** Entrada - LPImprimirEtiquetasManual - cargarPantalla ***");
		try {
			pagina("contenido_etiquetas_accion_manual_usuarios_imprimir");

			if (accion.equals("reimprimir")) {
				this.casoUso = "reimpresion";
				asignarAtributoPagina("cod", "0607");
			} else if (accion.equals("imprimir")) {
				this.casoUso = "manual";
				asignarAtributoPagina("cod", "0605");

				 // Seteo el año actual en la variable hidden
				 asignar("VAR", "hAnio", new SimpleDateFormat("y").format(new Date()));
			}
			getConfiguracionMenu("LPImprimirEtiquetasManual", accion);
			asignar("VAR", "casoUso", casoUso);

			asignar("VAR", "hImpresionSi", ConstantesAPE.IMPRESION_SI.toString());
			asignar("VAR", "hImpresionNo", ConstantesAPE.IMPRESION_NO.toString());

			asignar("VAR", "varPais", this.pais.toString());
		} catch (Exception e) {
			traza("Exception en LPImprimirEtiquetasManual.cargarPantalla()");
			e.printStackTrace();
			lanzarPaginaError(e);
		}
		traza("*** Salida - LPImprimirEtiquetasManual - cargarPantalla ***");
	}



	public void buscarEtiquetas() throws Exception {

		/*
		 * dmorello, 31/01/2007
		 * La funcionalidad correspondiente a este método se implementó totalmente
		 * en la página XML y en el código JavaScript.
		 */

	}



	
	public void imprimirSeleccion() throws Exception {
		traza("*** Entrada - LPImprimirEtiquetasManual - imprimirSeleccion ***");
		try {
			pagina("salidaGenerica");

			// Armo el DTO con la info de la pagina
			String strOids = conectorParametroLimpia("hOidsImprimir", "", true);
			String strImpresa = conectorParametroLimpia("hImpresa", "", true);
			traza("strOids: " + strOids);
			traza("strImpresa: " + strImpresa);

			DTOImpresionEtiquetas dto = new DTOImpresionEtiquetas();
			String[] arrayOids = strOids.split(",");
			Long[] oids = new Long[arrayOids.length];
			for (int i = 0; i < arrayOids.length; i++) {
				oids[i] = new Long(arrayOids[i]);
			}
			dto.setOids(oids);
			dto.setImpresa(new Boolean(strImpresa));
			dto.setOidPais(this.pais);

			traza("pais del dto: " + dto.getOidPais());

			// Imprimo...
			Vector parametros = new Vector();
			MareBusinessID id = new MareBusinessID("APEImprimirEtiquetasSeleccionadas");
			parametros.add(dto);
			parametros.add(id);

			try {
				DruidaConector conector = conectar("ConectorImprimirEtiquetasSeleccionadas", parametros);
				asignar("VAR", "ejecutar", "impresionOK()");
			} catch (Exception e) {
				asignar("VAR", "ejecutarError", "impresionConError()");
				throw e;
			}


		} catch (Exception e) {
			traza("Exception en LPImprimirEtiquetasManual.imprimirSeleccion()");
			e.printStackTrace();
			lanzarPaginaError(e);
		}
		traza("*** Salida - LPImprimirEtiquetasManual - imprimirSeleccion ***");
	}



	
	public void reimprimir() throws Exception {
		traza("*** Entrada - LPImprimirEtiquetasManual - reimprimir ***");
		this.cargarPantalla();
		traza("*** Salida - LPImprimirEtiquetasManual - reimprimir ***");
	}

	public void imprimirEtiquetasConsolidadoCaja() throws Exception { 
		traza("*** Entrada - LPImprimirEtiquetasManual - imprimirEtiquetasConsolidadoCaja ***"); 

		String consolidado = conectorParametroLimpia("txtConsolidado", "", true); 
		String caja = conectorParametroLimpia("txtCaja", "", true); 

		traza("*** consolidado: \"" + consolidado + '"');
		traza("*** caja: \"" + caja + '"');

		pagina("salidaGenerica"); 

		DTOImpresionEtiquetasManual dto = new DTOImpresionEtiquetasManual(); 
		dto.setOidPais(this.pais); 
		dto.setNumConsolidado(new Long(consolidado)); 
		if (caja.length() > 0) { 
			dto.setNumCaja(new Long(caja)); 
		} 

		Vector parametros = new Vector(); 
		MareBusinessID id = new MareBusinessID("APEImprimirEtiquetasConsolidadoCaja"); 
		parametros.add(dto); 
		parametros.add(id); 

		try { 
			DruidaConector conector = conectar("ConectorImprimirEtiquetasConsolidadoCaja", parametros); 
			asignar("VAR", "ejecutar", "etiquetasImpresas('" + consolidado + "')"); 
		} catch (Exception e) { 
			traza("Exception en LPImprimirEtiquetasManual.imprimirEtiquetasConsolidadoCaja()"); 
			asignar("VAR", "ejecutarError", "impresionConError()"); 
			throw e; 
		} 

		traza("*** Salida - LPImprimirEtiquetasManual - imprimirEtiquetasConsolidadoCaja ***"); 
	}
}