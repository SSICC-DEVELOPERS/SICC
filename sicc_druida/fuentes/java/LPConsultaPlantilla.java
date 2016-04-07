/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
    INDRA/EDU/PROY
    $Id: LPConsultaPlantilla.java,v 1.1 2009/12/03 18:39:35 pecbazalar Exp $
    DESC
 */

import es.indra.sicc.util.UtilidadesSession;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

// Definicion de la clase
public class LPConsultaPlantilla extends LPUtilidadesEDU {
	
	private String accion = null;
	private static final String FORMULARIO = "frmInsertarPlantilla";
    private static final String NOMBRE_PLANTILLA = "txtNombrePlantilla";
    private static final String CABECERA_PLANTILLA = "EDU_PLANT_CURSO_CABEC";
	
	public LPConsultaPlantilla() {
		super();
	}
     
	public void inicio() throws Exception {
		// Asignar nombre de la vista
		pagina("contenido_plantilla_cursos_modificar");	
	}

	public void ejecucion() throws Exception {
		rastreo();
		this.accion = conectorParametroLimpia("accion", "", true);
		try {
			if (accion.equals("")) {
				accionVacia();
			} else if (accion.equals("detalle")) {
				accionDetalle();
			}
		} catch (Exception e) {
			logStackTrace(e);
       		lanzarPaginaError(e); 
		}
		
		getConfiguracionMenu("LPConsultaPlantilla",accion); 
	}
    	
	private void accionVacia() throws Exception {
		traza("***Entrada -  LPConsultaPlantilla - accionVacia");
	    	
		//Obtenemos el idioma de la sesion
		UtilidadesSession sesion = new UtilidadesSession();
		Long idioma = sesion.getIdioma(this);
		asignarAtributo("VAR","idioma","valor",idioma.toString());
		
		//Caso de uso y titulo de la pantalla
		asignarAtributo("VAR","casoUso","valor","consultar");
		asignarAtributo("PAGINA","contenido_plantilla_cursos_modificar","cod","0465");
		asignarAtributo("PAGINA","contenido_plantilla_cursos_modificar","msgle","Consultar plantillas");
			
		traza("***Salida -  LPConsultaPlantilla - accionVacia");
	}
    	 
	private void accionDetalle() throws Exception {
		traza("***Entrada -  LPConsultaPlantilla - accionDetalle");
    		
		pagina("contenido_plantilla_cursos_insertar");
		String casoUso = conectorParametroLimpia("casoUso", "", true);
		String oid = conectorParametroLimpia("oidSeleccionado", "", true);
		Long oidPlantilla = null;
        if (!oid.equals("")) {
        	oidPlantilla = new Long(oid);
    	}
		
		//Genero la plantilla y la relleno
		this.muestraDetallesPlantilla(this.obtieneDetallesPlantilla(oidPlantilla), new Boolean(true));
		
		//Rellena datos generales de la pagina
		UtilidadesSession session = new UtilidadesSession();
		Long pais = session.getPais(this);
		Long idioma = session.getIdioma(this);
		asignarAtributo("VAR", "idioma","valor", idioma.toString());
		asignarAtributo("VAR", "pais", "valor",pais.toString());
		asignarAtributo("VAR", "casoUso", "valor",casoUso);
		//Titulo Consultar, Excepcion si el caso de uso es eliminar
		asignarAtributo("PAGINA","contenido_plantilla_cursos_insertar","cod","0465");
		asignarAtributo("PAGINA","contenido_plantilla_cursos_insertar","msgle","Consultar plantillas");
		if(casoUso.equals("eliminar")) {
			asignarAtributo("PAGINA","contenido_plantilla_cursos_insertar","cod","0464");
			asignarAtributo("PAGINA","contenido_plantilla_cursos_insertar","msgle","Eliminar plantillas");
		}
		
		// Añade campos hiddens para la internacionalización del nombre de
        // la plantilla
		anyadeHiddensI18N(true,CABECERA_PLANTILLA,oidPlantilla,new Integer(1),FORMULARIO,
			NOMBRE_PLANTILLA,true);
    		
		traza("***Salida -  LPConsultaPlantilla - accionDetalle");
	}
    	
}
