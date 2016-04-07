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
    $Id: LPCopiaCurso.java,v 1.1 2009/12/03 18:37:13 pecbazalar Exp $
    DESC
*/

import java.util.Vector;
import java.util.ArrayList;
  
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.druida.DruidaConector;
 
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.dtos.edu.DTOCargaCursos;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class LPCopiaCurso extends LPUtilidadesEDU { 
    
    public LPCopiaCurso() {
    	super();
    }

    public void inicio() throws Exception {
    	// Defino el nombre de la vista
    	pagina("contenido_cursos_modificar");
    }

    public void ejecucion() throws Exception {
    	rastreo();
		setTrazaFichero();
		traza("*** Entrada - LPCopiaCurso - ejecucion ***");
        	String accion = conectorParametroLimpia("accion","",true);
        try { 
    		
    		traza("*** accion : "+accion);
	         
    		if (accion.equals("")) {
     			accionVacia();
    		} else if (accion.equals("copiar")) {
     			accionCopiar();
    		}
       	} catch(Exception e) {
       	        logStackTrace(e);
       		lanzarPaginaError(e);
       	}
       	getConfiguracionMenu("LPCopiarCurso",accion);
       	traza("***Salida - LPCopiaCurso - ejecucion***");
    }
    
    private void accionVacia() throws Exception {
    	 //Quitamos la visivilidad a la lista y marcamos el caso de uso
         traza("***Entrada -  LPCopiaCurso - accionVacia");
        
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
         asignarAtributo("VAR","casoUso","valor","copiar");
         asignarAtributo("PAGINA","contenido_cursos_modificar","cod","0203");
         asignarAtributo("PAGINA","contenido_cursos_modificar","msgle","Copiar cursos");
         traza("***Entrada -  LPCopiaCurso - accionVacia");
    }
     
    private void accionCopiar() throws Exception {
    	traza("*** Entrada - LPCopiaCurso - accionCopiar ***");
    	
    	// Defino el nombre de la vista
        pagina("contenido_cursos_insertar");
    	
    	// Se instancia un objeto DTOOIDs y se rellena con el oid 
    	String strOid = conectorParametroLimpia("oidSeleccionado", "", true);
    	Long oidCurso = null;
        if (!strOid.equals("")) {
        	oidCurso = new Long(strOid);
    	}
    
    	DTOOIDs dtoOids = new DTOOIDs();
    	Long oids[] = new Long[1];
    	oids[0] = new Long(oidCurso.longValue());
    	dtoOids.setOids(oids);
		dtoOids.setOidPais(UtilidadesSession.getPais(this));
		dtoOids.setOidIdioma(UtilidadesSession.getIdioma(this));

 	    // Se crea idNegocio = "EDUCopiaCurso" 
 	    MareBusinessID idBussiness = new MareBusinessID("EDUCopiaCurso");
     
    	Vector paramEntrada = new Vector();
    	paramEntrada.addElement(dtoOids); 
    	paramEntrada.addElement(idBussiness);
    
    	// Se invoca al conector ConectorOIDs  
    	DruidaConector conector = conectar("ConectorOIDs", paramEntrada);
	
	    traza("***Paso el conectar");
    	// Se obtiene el DTO devuelto por el conector
        DTOOID dtoOID = (DTOOID)conector.objeto("DTOOID");
        //Long oid = (Long)conector.objeto("DTOOID.oid");
        Long oid = dtoOID.getOid();
        traza("***LPCopiaCurso -"+oid);
         
        //- Llamamos oid al oid del curso seleccionado y se invoca a 
	    //muestraDetalleCurso(obtieneDetallesCurso(oid), false); 
	    //- Nótese que ambos métodos están declarados en el padre LPUtilidadesEDU. 
	    this.muestraDetallesCurso(this.obtieneDetallesCurso(oid),new Boolean(true)); 

        //Rellena datos generales de la pagina
	    UtilidadesSession session = new UtilidadesSession();
        Long pais = session.getPais(this);
        Long idioma = session.getIdioma(this);
        asignarAtributo("VAR", "idioma", "valor", idioma.toString());
        asignarAtributo("VAR", "pais", "valor", pais.toString());
        asignarAtributo("VAR", "casoUso", "valor", "copiar");
        asignarAtributo("VAR", "oid", "valor", oid.toString());
        this.generarHiddenFormatoFecha();
        anyadeHiddensI18N(true, "EDU_MATRI_CURSO", oid, new Integer(1), "formularioInsertarCurso", "txtNombreCurso", false); 
	    //Titulo
	    asignarAtributo("PAGINA","contenido_cursos_insertar","cod","0203");
	    asignarAtributo("PAGINA","contenido_cursos_insertar","msgle","Copiar cursos");		
  	    traza("*** Salida - LPCopiaCurso - accionCopiar ***");
 	}
}