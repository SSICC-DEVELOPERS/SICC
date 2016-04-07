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

import es.indra.mare.common.exception.MareException;
import es.indra.druida.DruidaConector;

import java.io.ByteArrayOutputStream; 
import java.io.PrintStream;

import es.indra.sicc.util.DTOBelcorp;

import es.indra.sicc.util.UtilidadesSession;


public class LPProgramasLanzamiento extends LPSICCBase
{
	
	private String accion = null;
    private Long hIdioma;
    private Long hPais;
  	private String oidContacto = null;
    // Definicion del constructor
    public LPProgramasLanzamiento(){
          super();
    } 
         
    //Inicio vacio
    public void inicio() throws Exception {
    	pagina("contenido_programas_lanzamiento_consultar");
    	getConfiguracionMenu("LPProgramasLanzamiento","");

    }

    public void ejecucion() throws Exception {

    	rastreo();
		
		try{
            setTrazaFichero(); 
            traza("***Entrada - LPProgramasLanzmiento - ejecucion***");
            
     		this.accion = conectorParametroLimpia("accion", "", true);
            this.hIdioma = UtilidadesSession.getIdioma(this);
            this.hPais = UtilidadesSession.getPais(this);
            
            asignar("VAR", "idioma", hIdioma.toString());
            asignar("VAR", "pais", hPais.toString()); 
			this.oidContacto = conectorParametroLimpia("oidContacto","",true);   
			asignar("VAR", "oidContacto", this.oidContacto); 
            asignarAtributo("PAGINA","contenido_programas_lanzamiento_consultar", "cod", "0560");
         	asignarAtributo("PAGINA","contenido_programas_lanzamiento_consultar", "msgle", "Consultar Programas de Lanzamiento");
            //Muestra falta incidencia  			
  			if (accion.equals("")) {
				//pagina("contenido_programas_lanzamiento_consultar");
			}
			//getConfiguracionMenu("LPProgramasLanzamiento","");
			
    		traza("***Salida - LPConsultaFacturas - ejecucion***");
          }catch(Exception e){
          	logStackTrace(e);
            lanzarPaginaError(e);
         }
         
		}
		
     	protected void logStackTrace(Throwable e) throws Exception {
           traza("Se produjo la excepcion: " + e.getMessage());
    
           ByteArrayOutputStream baos = new ByteArrayOutputStream();
           PrintStream ps = new PrintStream(baos);
           e.printStackTrace(ps);
                            
           traza("Stack Trace: " + baos.toString());
    	}

      
         
}


        