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
import es.indra.sicc.dtos.ape.DTOBusquedaEtiqueta;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesSession;

import java.util.Vector;


public class LPAnulacionEtiquetas extends LPSICCBase {

	private Long pais = null;
	private Long idioma = null;
	private String accion = null;
	private String opcionMenu = null;



	public void inicio() throws Exception { }



	public void ejecucion() throws Exception {
		setTrazaFichero();
		traza("*** Entrada - LPAnulacionEtiquetas - ejecucion ***");
		try {
			this.pais = UtilidadesSession.getPais(this);
			this.idioma = UtilidadesSession.getIdioma(this);
			this.accion = conectorParametroLimpia("accion", "", true);
			this.opcionMenu = conectorParametroLimpia("opcionMenu", "", true);

			traza("pais = " + this.pais);
			traza("idioma = " + this.idioma);
			traza("accion = " + this.accion);
			traza("opcionMenu = " + this.opcionMenu);

			if (accion.equals("anulacion")) {
				this.cargarPantalla();
			} else if (accion.equals("anular")) {
				this.anular();
			} else if (accion.equals("buscarEtiquetas")) {
				this.buscarEtiquetas();
			}
		} catch (Exception e) {
			traza("Exception en LPAnulacionEtiquetas.ejecucion()");
			e.printStackTrace();
			lanzarPaginaError(e);
		}
		traza("*** Salida - LPAnulacionEtiquetas - ejecucion ***");
	}






	public void cargarPantalla() throws Exception {
		traza("*** Entrada - LPAnulacionEtiquetas - cargarPantalla ***");
		try	{
			pagina("contenido_etiquetas_accion_manual_usuarios_imprimir2");
			asignarAtributoPagina("cod", "0606");
			getConfiguracionMenu("LPAnulacionEtiquetas", "anulacion");

			asignar("VAR", "varPais", this.pais.toString());
		} catch (Exception e) {
			traza("Exception en LPAnulacionEtiquetas.cargarPantalla()");
			e.printStackTrace();
			lanzarPaginaError(e);
		}
		traza("*** Salida - LPAnulacionEtiquetas - cargarPantalla ***");
	}





	public void anular() throws Exception {
		traza("*** Entrada - LPAnulacionEtiquetas - anular ***");
		try {
			pagina("salidaGenerica");
			
			// Creo el DTOOIDs
			String hOids = conectorParametroLimpia("hOidsAnular", "", true);
			traza("hOids: " + hOids);
			String[] strOids = hOids.split(",");
			Long[] oids = new Long[strOids.length];
			for (int i = 0; i < strOids.length; i++) {
				oids[i] = new Long(strOids[i]);
			}
			DTOOIDs dtoOids = new DTOOIDs();
			dtoOids.setOids(oids);

			MareBusinessID idBusiness = new MareBusinessID("APEAnularEtiquetas");
			Vector paramsEntrada = new Vector();
			paramsEntrada.add(dtoOids);
			paramsEntrada.add(idBusiness);

			traza("*** Antes de conectar para anular");
			DruidaConector conector = conectar("ConectorAnularEtiquetas", paramsEntrada);
			traza("*** Despues de conectar para anular");
			this.asignarAtributo("VAR", "ejecutar", "valor", "anulacionFinalizadaOK()");

		} catch (Exception e) {
			traza("Exception en LPAnulacionEtiquetas.anular()");
			e.printStackTrace();
			lanzarPaginaError(e);
		}
		traza("*** Salida - LPAnulacionEtiquetas - anular ***");
	}




	/**
	 * dmorello, 25/01/2007
	 * Este método no fue finalizado. De todos modos, se deja sin uso
	 * ya que se intentará llevar a cabo la misma funcionalidad por medio de JavaScript
	 */
	public void buscarEtiquetas() throws Exception {
		traza("*** Entrada - LPAnulacionEtiquetas - buscarEtiquetas ***");
		/*
		 * Crear DTOBusquedaEtiqueta con nroSolicCabec = nroConsolidado 
		 * Crear idBusiness == 'APEBuscarEtiquetas' 
		 * Conectar con ConectorBusquedaEtiquetas pasándole el dto e idBusiness creado anteriormente 
		 * -> Asignar resultado a listado1 
		 * -> mostrar listado 1
		 */
		try {
			pagina("salidaGenerica");

			String strConsolidado = conectorParametroLimpia("hNroConsolidado", "", true);
			traza("strConsolidado: " + strConsolidado);
			DTOBusquedaEtiqueta dto = new DTOBusquedaEtiqueta();
			if (strConsolidado != null && strConsolidado.length() > 0) {
				dto.setNroSolicCabec(new Long(strConsolidado));
			} else {
				dto.setNroSolicCabec(null);
			}
			
			MareBusinessID idBusiness = new MareBusinessID("APEBuscarEtiquetas");
			Vector paramsEntrada = new Vector();
			paramsEntrada.add(dto);
			paramsEntrada.add(idBusiness);

			traza("*** Antes de conectar para buscar etiquetas");
			DruidaConector conector = conectar("ConectorBuscarEtiquetas", paramsEntrada);
			traza("*** Despues de conectar para buscar etiquetas");

			DTOSalida dtoSalida = (DTOSalida)conector.objeto("dtoSalida.resultado");

			/* SIN TERMINAR */



		} catch (Exception e) {
			traza("Exception en LPAnulacionEtiquetas.buscarEtiquetas()");
			e.printStackTrace();
			lanzarPaginaError(e);
		}
		traza("*** Salida - LPAnulacionEtiquetas - buscarEtiquetas ***");		
	}
}