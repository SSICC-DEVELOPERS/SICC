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
    $Id: LPCopiaPlantilla.java,v 1.1 2009/12/03 18:34:32 pecbazalar Exp $
    DESC
*/
 
import java.util.Vector;
 
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.druida.DruidaConector;
 
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.dtos.edu.DTOCargaCursos;


// Definicion de la clase
public class LPCopiaPlantilla extends LPUtilidadesEDU {
	
	private static final String FORMULARIO = "frmInsertarPlantilla";
    private static final String NOMBRE_PLANTILLA = "txtNombrePlantilla";
    private static final String CABECERA_PLANTILLA = "EDU_PLANT_CURSO_CABEC";
	
	// Definicion del constructor
	public LPCopiaPlantilla() {super();}
	
	// Definicion del metodo abstracto inicio
	public void inicio() throws Exception {
	     // Asignar nombre de la vista
	      pagina("contenido_plantilla_cursos_modificar");         
	}
	
	// Definicion del metodo abstracto ejecucion
	public void ejecucion() throws Exception {
		rastreo();
		setTrazaFichero();
		traza("*** Entrada - LPCopiaPlantilla - ejecucion ***");
	     
		String accion = conectorParametroLimpia("accion", "", true);
		traza("accion: "+accion);
		try {     
			if ( accion.equals("")) {
				accionVacia();
			}
			if ( accion.equals("copiar")) {
				accionCopiar();
			}
		} catch(Exception e){
			logStackTrace(e);
			lanzarPaginaError(e);
		}

		getConfiguracionMenu("LPCopiaPlantilla",accion);
		traza("***Salida - LPCopiaPlantilla - ejecucion***");
	}
    
	private void accionVacia() throws Exception {
		traza("*** Entrada - LPCopiaPlantilla - accionVacia ***");
         
		//Obtenemos el idioma de la sesion 
		UtilidadesSession sesion = new UtilidadesSession();
		Long idioma = sesion.getIdioma(this);
		asignarAtributo("VAR","idioma","valor",idioma.toString());
		asignarAtributo("VAR","casoUso","valor","copiar");
		asignarAtributo("PAGINA","contenido_plantilla_cursos_modificar","cod","0201");
		asignarAtributo("PAGINA","contenido_plantilla_cursos_modificar","msgle","Copiar plantillas");
         
		traza("*** Entrada - LPCopiaPlantilla - accionVacia ***");
    }
    
    private void accionCopiar() throws Exception {
		traza("*** Entrada - LPCopiaPlantilla - accionCopiar ***");
	     
		// Defino el nombre de la vista
		pagina("contenido_plantilla_cursos_insertar");
		asignaHiddensValidacion();	     
		//- Se instancia un objeto DTOOIDs y se rellena con los oids de las plantillas seleccionadas. 
		String oid = conectorParametroLimpia("oidSeleccionado", "", true);
		traza("*** Oid a copiar:"+oid);
		Long oidPlantilla = null;
		if (!oid.equals("")) {
			oidPlantilla = new Long(oid);
		}
         
		DTOOIDs dtoOids = new DTOOIDs();
		Long oids[] = new Long[1];
		oids[0] = new Long(oidPlantilla.longValue());
		dtoOids.setOids(oids);
         
		//Obtenemos el pais y el idioma de la sesion
		UtilidadesSession sesion = new UtilidadesSession();
		Long pais = sesion.getPais(this); 
		Long idioma = sesion.getIdioma(this);
		dtoOids.setOidPais(pais);
		dtoOids.setOidIdioma(idioma);
         
		//- Se crea idNegocio = "EDUCopiaPlantilla" 
		MareBusinessID idBussiness = new MareBusinessID("EDUCopiaPlantilla");
     
		Vector paramEntrada = new Vector();
		paramEntrada.addElement(dtoOids);
		paramEntrada.addElement(idBussiness);
    	
		//- Se invoca al conector ConectorOIDs 
		DruidaConector conector = conectar("ConectorOIDs", paramEntrada);
         
		// Se obtiene el DTO devuelto por el conector
		DTOOID dtoOID = (DTOOID)conector.objeto("DTOOID");
         
		Long oidCopiado = dtoOID.getOid();
          
		//Genero la plantilla y la relleno
		this.muestraDetallesPlantilla(this.obtieneDetallesPlantilla(oidCopiado), new Boolean(false));
		
		//Rellena datos generales de la pagina
		asignarAtributo("VAR", "idioma","valor", idioma.toString());
		asignarAtributo("VAR", "pais", "valor",pais.toString());
		asignarAtributo("VAR", "casoUso", "valor","copiar");
		asignarAtributo("VAR", "oidPlantilla", "valor", oidCopiado.toString());
		asignarAtributo("PAGINA","contenido_plantilla_cursos_insertar","cod","0201");
		asignarAtributo("PAGINA","contenido_plantilla_cursos_insertar","msgle","Copiar plantillas");
		
		// Añade campos hiddens para la internacionalización del nombre de
        // la plantilla
		anyadeHiddensI18N(true,CABECERA_PLANTILLA,oidPlantilla,new Integer(1),FORMULARIO,
			NOMBRE_PLANTILLA,false);
			
		// Genera un campo oculto que contiene el formato de fecha
        generarHiddenFormatoFecha();

		traza("*** Salida - LPCopiaPlantilla - accionCopiar ***");
	}
	         private void asignaHiddensValidacion() throws Exception {
                  // Campos hidden para realizar la validacion de números con formato de miles y decimales
                  String formatoNumerico = UtilidadesSession.getFormatoNumerico(this);
                  String separadorDecimales = UtilidadesSession.getSeparadorDecimales(this);
                  String separadorMiles = ",";
                  if (separadorDecimales.equals(",")) {
                           separadorMiles = ".";
                  }
                  
                  asignarAtributo("VAR","hid_SeparadorMiles","valor",separadorMiles);
                  asignarAtributo("VAR","hid_NumeroDecimales","valor",formatoNumerico);
                  asignarAtributo("VAR","hid_SeparadorDecimales","valor",separadorDecimales);
         }

}