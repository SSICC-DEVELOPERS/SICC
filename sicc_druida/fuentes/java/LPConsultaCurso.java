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
    $Id: LPConsultaCurso.java,v 1.1 2009/12/03 18:33:54 pecbazalar Exp $
    DESC
*/

import java.util.Vector;
import java.util.ArrayList;
  
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.druida.DruidaConector;
 
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.dtos.edu.DTOPlantillaCurso;
import es.indra.sicc.dtos.edu.DTODetallePlantillaCurso;
import es.indra.sicc.dtos.edu.DTOParametro;
import es.indra.sicc.dtos.edu.DTOCargaCursos;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


// Definicion de la clase
public class LPConsultaCurso extends LPUtilidadesEDU {
    // Definicion del constructor
    public LPConsultaCurso() {super();}

    // Definicion del metodo abstracto inicio
    public void inicio() throws Exception {
   
           // Defino el nombre de la vista
           pagina("contenido_cursos_modificar");
    }

    // Definicion del metodo abstracto ejecucion
    public void ejecucion() throws Exception {
    	rastreo();
    	try{
	        setTrazaFichero();
	        traza("***Entrada - LPConsultaCurso - ejecucion***");
	        
	        String accion = conectorParametroLimpia("accion","",true);
	        traza("***accion : "+accion);
	         
         	//Bifurcamos la accion
         	if ( accion.equals("")) {
             		accionVacia();
         		}
         	if ( accion.equals("detalle")) {
             		accionDetalle();
         	}
         	traza("***Salida - LPConsultaCurso - ejecucion***");
         	getConfiguracionMenu("LPConsultaCurso",accion);
       	}catch(Exception e){
       		logStackTrace(e);
       		lanzarPaginaError(e);
       	}
    }
    
    private void accionVacia() throws Exception {
        //Quitamos la visivilidad a la lista y marcamos el caso de uso
        traza("***Entrada -  LPConsultaCurso - accionVacia");
        
        //- Se crea una instancia DTOBelcorp y se rellena con los datos de sesión. 
        //Obtenemos el pais y el idioma de la sesion
         UtilidadesSession sesion = new UtilidadesSession();
         Long pais = sesion.getPais(this); 
         Long idioma = sesion.getIdioma(this);

         //Se instancia un DTOBelcorp
         DTOBelcorp dtoEntrada = new DTOBelcorp();
         dtoEntrada.setOidPais(pais);
         dtoEntrada.setOidIdioma(idioma);
                  
    	 //- Se crea idNegocio "EDUDatosConsultaCursos" 
         MareBusinessID idBussiness = new MareBusinessID("EDUDatosConsultaCursos");
         
         //Almacenamos los parametros de entrada
         Vector paramEntrada = new Vector();
         paramEntrada.addElement(dtoEntrada);
         paramEntrada.addElement(idBussiness);
        
         traza ("Llamo a conectar");
         
         //- Se invoca al ConectorObtieneDatosConsultaCursos 
         DruidaConector conector = conectar("ConectorObtieneDatosConsultaCursos", paramEntrada);
         
         //- Se obtiene un DTOCargaCursos relleno tan sólo con las marcas y los 
	     //canales y se mostrarán los mismos en el cmbMarcas y cmbCanales de PaginaEliminarCurso 
         DTOCargaCursos dtoSalida = (DTOCargaCursos) conector.objeto("DTOCargaCursos");
         
         // Se obtiene el DTO de salida DTOCargaCursos relleno 
         DTOCargaCursos dtoCargaCursos = (DTOCargaCursos)conector.objeto("DTOCargaCursos");
            
         // Se cargan los combos de marcas y canales 
         RecordSet rsMarcas = dtoCargaCursos.getMarcas();
         RecordSet rsCanales = dtoCargaCursos.getCanales();
         
         traza("Cargando combos ...");
         
         Vector cols = rsMarcas.getColumnIdentifiers();
         DruidaConector conectorMarcas = UtilidadesBelcorp.generarConector(
             "DTOCargaCursos.marcas",rsMarcas,cols);
         asignar("COMBO","cbMarca",conectorMarcas,"DTOCargaCursos.marcas");
         
         cols = rsCanales.getColumnIdentifiers();
         DruidaConector conectorCanales = UtilidadesBelcorp.generarConector(
             "DTOCargaCursos.canales",rsCanales,cols);
         asignar("COMBO","cbCanal",conectorCanales,"DTOCargaCursos.canales");
         
         traza("Combos cargados ...");
         
         asignarAtributo("VAR","idioma","valor",idioma.toString());
         asignarAtributo("VAR","casoUso","valor","consultar");
         asignarAtributo("PAGINA","contenido_cursos_modificar","cod","0468");
         asignarAtributo("PAGINA","contenido_cursos_modificar","msgle","Consultar cursos");
         traza("***Salida -  LPConsultaCurso - accionVacia");
    }
     
    private void accionDetalle() throws Exception {
    traza("***Entrada -  LPConsultaCurso - accionDetalle");
    // Defino el nombre de la vista
    pagina("contenido_cursos_insertar");
    //- Llamamos oid al oid del curso seleccionado y se invoca a 
	//muestraDetalleCurso(obtieneDetallesCurso(oid), true); 
	//- Nótese que ambos métodos están declarados en el padre LPUtilidadesEDU.
	String casoUso = conectorParametroLimpia("casoUso", "", true);  
	String oid = conectorParametroLimpia("oidSeleccionado", "", true); 
	this.muestraDetallesCurso(this.obtieneDetallesCurso(new Long(oid)),new Boolean(true));
	
	//Rellena datos generales de la pagina
	UtilidadesSession session = new UtilidadesSession();
    Long pais = session.getPais(this);
    Long idioma = session.getIdioma(this);
    asignarAtributo("VAR", "idioma","valor", idioma.toString());
    asignarAtributo("VAR", "pais", "valor",pais.toString());
    asignarAtributo("VAR", "casoUso", "valor",casoUso);
    this.generarHiddenFormatoFecha();
    anyadeHiddensI18N(true, "EDU_MATRI_CURSO", new Long(oid), new Integer(1), "formularioInsertarCurso", "txtNombreCurso", true); 
	//Titulo Consultar, Excepcion si el caso de uso es eliminar
	asignarAtributo("PAGINA","contenido_cursos_insertar","cod","0468");
	asignarAtributo("PAGINA","contenido_cursos_insertar","msgle","Consultar cursos");
	if(casoUso.equals("eliminar")) {
		asignarAtributo("PAGINA","contenido_cursos_insertar","cod","0467");
        asignarAtributo("PAGINA","contenido_cursos_insertar","msgle","Eliminar cursos");
	}
	traza("***Salida -  LPConsultaCurso - accionDetalle");
    }
}