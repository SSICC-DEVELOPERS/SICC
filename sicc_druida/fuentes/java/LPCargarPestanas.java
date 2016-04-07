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

import java.io.ByteArrayOutputStream; 
import java.io.PrintStream;

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;

import es.indra.druida.DruidaConector;

import es.indra.mare.common.mln.MareBusinessID;

import es.indra.sicc.util.UtilidadesSession;

public class LPCargarPestanas extends LPSICCBase {
	    
	private String accion = null;
    
    	// Definicion del constructor
    	public LPCargarPestanas() {
		super();
    	}
    
    	// Definicion del metodo abstracto inicio
    	public void inicio() throws Exception {

		// Defino el nombre de la vista
           	pagina("pestanas_cliente_presentar");
    	}

    	// Definicion del metodo abstracto ejecucion
        public void ejecucion() throws Exception {
                
                try{
                	setTrazaFichero();
                   	traza("***Entrada - LPCargarPestanas - ejecucion***");
             
             		
	                this.accion = conectorParametroLimpia("accion","",true);
	             		             	
	             	if(this.accion.equals("")) {
	             		this.accion = "lblFicha";
	        	} 
	             	asignarAtributo("table","table"+this.accion,"bgcolor","#496A9A");
	             	asignarAtributo("LABELC",this.accion,"id","menu5textoblanca");
	             	
	             	asignar("VAR", "accion", this.accion);
	             	
	             	traza("***accion : "+this.accion);
			
			
             		
             		traza("***Salida - LPCargarPestanas - ejecucion***");
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
