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
 
import LPSICCBase; 

import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
import java.util.Vector;
import es.indra.mare.common.mln.MareBusinessID;

import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.UtilidadesSession;

import es.indra.druida.DruidaConector;
import es.indra.sicc.dtos.mae.DTOBuscarClientesCursos;

import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;


public class LPRegistrarAsistencia extends LPSICCBase {
          
	private String accion = null;
    private String casoUso = null;   
    private Long idioma;
    private Long pais;   
          
    public LPRegistrarAsistencia() {
    	super();
    }

    public void inicio() throws Exception {
                 
    }
    public void ejecucion() throws Exception { 
    	rastreo();
    	setTrazaFichero();
        try  {         
        	traza("LPRegistrarAsistencia Entrada");
			pagina("contenido_asistencia_cursos_registrar"); 
			
			this.idioma = UtilidadesSession.getIdioma(this);
            this.pais = UtilidadesSession.getPais(this);
            asignar("VAR", "idioma", idioma.toString());
        	asignar("VAR", "pais", pais.toString()); 
            this.accion = conectorParametroLimpia("accion","", true);
            traza("Accion definida : "+accion); 
			            
            if(this.accion.equals("")){
            	cargaInicial();
            }
                          
            traza("LPRegistraAsistencia Salida");
		}catch ( Exception e )  {
        	e.printStackTrace();
            logStackTrace(e);
            lanzarPaginaError(e);
        }              
	}

	private void cargaInicial() throws Exception{
    	try{
    		traza("LPRegistrarAsistencia cargaInicial Entrada");		

        	asignarAtributo("PAGINA","contenido_asistencia_cursos_registrar", "cod", "0206");
            asignarAtributo("PAGINA","contenido_asistencia_cursos_registrar", "msgle", "Registrar asistencia a cursos");
            getConfiguracionMenu("LPRegistrarAsistencia", "");
        	        	
        	ComposerViewElementList listelem = new ComposerViewElementList();
        	ComposerViewElement elem1 = new ComposerViewElement();
        	ComposerViewElement elem2 = new ComposerViewElement();
        	
        	DTOBelcorp dto = new DTOBelcorp();
        	dto.setOidPais(pais);
        	dto.setOidIdioma(idioma);
        	
        	elem1.setIDBusiness("SEGConsultaMarcas");
        	elem1.setDTOE(dto);
        	elem1.setPosOID((byte)0);
        	elem1.setPosDesc((byte)1);
			traza("Elemento 1 rellenado");
        	          
        	elem2.setIDBusiness("SEGConsultaCanales");
        	elem2.setDTOE(dto);
        	elem2.setPosOID((byte)0);
        	elem2.setPosDesc((byte)1);
			traza("Elemento 2 rellenado");
        	listelem.addViewElement(elem1);
        	traza("Elemento 1 aniadido");
        	listelem.addViewElement(elem2);
        	traza("Elemento 2 aniadido");
        	//Se llama al subsistema GestorCargaPantalla. 
        	ConectorComposerView conector = new ConectorComposerView(listelem,this.getRequest());
        	traza("conector creado");
        	conector.ejecucion();
        	traza("ejecutado");
        	DruidaConector conConsultar = conector.getConector();
        	traza("Obtener conConsultar");
        	
        	//Con los datos obtenidos en el ROWSET SEGConsultaMarcas se carga la combo cmbMarca 
        	//Con los datos obtenidos en el ROWSET SEGConsultaCanales se carga la combo cmbCanal
        	asignar("COMBO","cbMarca", conConsultar,"SEGConsultaMarcas");
        	asignar("COMBO","cbCanal", conConsultar,"SEGConsultaCanales");


		}catch ( Exception e )  {
        	e.printStackTrace();
            this.logStackTrace(e);
            lanzarPaginaError(e);
        }                  
        traza("LPRegistrarAsistencia cargaInicial Salida");		
	}
          
	private void logStackTrace(Throwable e) throws Exception {
    	traza("Se produjo la excepcion: " + e.getMessage());		
    	ByteArrayOutputStream baos = new ByteArrayOutputStream();
    	PrintStream ps = new PrintStream(baos);
    	e.printStackTrace(ps);		
    	traza("Stack Trace: " + baos.toString());
    }      
 
}


