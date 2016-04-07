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

/*
    INDRA/CAR/PROY
    $Id: LPEliminaPlantilla.java,v 1.1 2009/12/03 18:40:20 pecbazalar Exp $
    DESC
*/

import es.indra.sicc.util.UtilidadesSession;
import es.indra.druida.DruidaBase;

// Definicion de la clase
public class LPEliminaPlantilla extends LPUtilidadesEDU {
    // Definicion del constructor
    public LPEliminaPlantilla() {super();}

    // Accion
    private String accion = null;

    // Definicion del metodo abstracto inicio
    public void inicio() throws Exception {
	// Asignar nombre de la vista
         pagina("contenido_plantilla_cursos_modificar");	
    }

    // Definicion del metodo abstracto ejecucion
    public void ejecucion() throws Exception {
    	rastreo();
    	this.accion = conectorParametroLimpia("accion", "", true);
    	
    	try{     
         	if ( accion.equals("")) {
             		accionVacia();
         	}
         }catch(Exception ex){
       		lanzarPaginaError(ex);
         }
         getConfiguracionMenu("LPEliminaPlantilla",accion);
    }
    
    private void accionVacia() throws Exception {
        //Obtenemos el idioma de la sesion
	UtilidadesSession sesion = new UtilidadesSession();
	Long idioma = sesion.getIdioma(this);
	asignarAtributo("VAR","idioma","valor",idioma.toString());
	//Caso de uso y titulo de la pantalla
	asignarAtributo("VAR","casoUso","valor","eliminar");
	asignarAtributo("PAGINA","contenido_plantilla_cursos_modificar","cod","0464");
	asignarAtributo("PAGINA","contenido_plantilla_cursos_modificar","msgle","Eliminar plantillas");
    }
}