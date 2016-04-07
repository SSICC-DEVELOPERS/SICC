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
    $Id: LPEliminaCurso.java,v 1.1 2009/12/03 18:34:22 pecbazalar Exp $
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

// Definicion de la clase
public class LPEliminaCurso extends LPUtilidadesEDU {
    // Definicion del constructor
    public LPEliminaCurso() {super();}

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
        	traza("***Entrada - LPEliminaCurso - ejecucion***");
         
        	String accion = conectorParametroLimpia("accion","",true);
        	traza("***accion : "+accion);
	         
         	//Bifurcamos la accion
         	if ( accion.equals("")) {
             	accionVacia();
         	}
         	traza("***Salida - LPEliminaCurso - ejecucion***"); 
         	getConfiguracionMenu("LPEliminaCurso",accion);
         }catch(Exception e){
       		lanzarPaginaError(e);
         }
    }
    
    private void accionVacia() throws Exception {
         //Quitamos la visivilidad a la lista y marcamos el caso de uso
         traza("***Entrada -  LPEliminaCurso - accionVacia");
        
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
         asignarAtributo("VAR","casoUso","valor","eliminar");
         asignarAtributo("PAGINA","contenido_cursos_modificar","cod","0467");
         asignarAtributo("PAGINA","contenido_cursos_modificar","msgle","Eliminar cursos");
         traza("***Entrada -  LPEliminaCurso - accionVacia");
        }
        
}