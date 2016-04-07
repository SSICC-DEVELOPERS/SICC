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

import java.io.ByteArrayOutputStream;
import java.io.PrintStream; 

import java.util.Vector;
import java.util.Date;

import es.indra.sicc.util.UtilidadesFecha;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.dtos.ccc.DTOFecha;
import es.indra.sicc.dtos.ccc.DTONumRegistros;
import es.indra.druida.DruidaConector;
import es.indra.mare.common.mln.MareBusinessID;


 
public class LPReabrirPeriodo extends LPSICCBase {

	private String accion = null;
	
	public LPReabrirPeriodo() {
    		super();
	}

	public void inicio() throws Exception {
	}

	public void ejecucion() throws Exception {
		rastreo();
		setTrazaFichero();
		traza("*** Entrada - LPReabrirPeriodo - ejecucion ***");
    		try  {
			pagina("contenido_registro_ventas_reabrir");
			Long idioma = UtilidadesSession.getIdioma(this);
			traza("Idioma: "+idioma);
			Long pais = UtilidadesSession.getPais(this);
			traza("Pais: "+pais);
			this.accion = conectorParametroLimpia("accion","", true);
			asignar("VAR", "idioma", idioma.toString());			
			asignar("VAR", "pais", pais.toString());	
			this.generarHiddenFormatoFecha();
			if(this.accion.equals("")){ 
  		  		asignarAtributo("PAGINA","contenido_registro_ventas_reabrir", "cod", "0195");
         	  		asignarAtributo("PAGINA","contenido_registro_ventas_reabrir", "msgle", "Reabrir registro de ventas");
         	  		getConfiguracionMenu("LPReabrirPeriodo","");
			}
			if(this.accion.equals("reabrir")){
				this.accionReabrir(idioma,pais);
			}
		 traza("accion : "+accion);
		}catch ( Exception e ) {
			logStackTrace(e);
		    lanzarPaginaError(e);
		}
		
		traza("*** Salida - LPReabrirPeriodo - ejecucion ***");
	}
	private void accionReabrir(Long idioma, Long pais) throws Exception{
		traza("*** Entrada - LPReabrirPeriodo - accionReabrir ***");
	    try{
	    	                                                                                                           
   			//Si opcion="S" { 
		String opcion = conectorParametroLimpia("opcion", "", true);
		traza("OPCION: "+opcion);
		if(opcion.equals("S")){
			/*Llamamos al conector "ConectorReabrirRegistrosVentas" y le pasamos
			 * los parámetros siguientes:                                                                        
		 	* idBusiness="CCCReabrirRegistroVentas"                                                                     
		 	 * dto = DTOFecha (fechaCierre) 
		 	 */
		 	DTOFecha dtoFecha = new DTOFecha();
		 	dtoFecha.setOidIdioma(idioma);
		 	dtoFecha.setOidPais(pais); 
			//Cambio formato de fecha
			String fecha = conectorParametroLimpia("txtFechaCierre","",true);
			if(fecha!=null && !fecha.equals("")){
				Date fechaCierre = UtilidadesBelcorp.getDatefromSICCStringFormat(fecha,UtilidadesSession.getFormatoFecha(this));
      				dtoFecha.setFechaCierre(fechaCierre);//Date
      				traza("---> Fecha Cierre: "+fechaCierre);
			}			
			//java.util.Date fechaCierre = UtilidadesFecha.convertirAFecha(fecha,"yyyy-MM-dd");
			//dtoFecha.setFechaCierre(fechaCierre);
			
			Vector paramConector = new Vector();
	                paramConector.add(dtoFecha);
	                paramConector.add(new MareBusinessID("CCCReabrirRegistroVentas"));           
	                
	                traza("Antes de Conectar ConectorReabrirRegistrosVentas ");
	                DruidaConector conector = conectar("ConectorReabrirRegistrosVentas", paramConector);							
	                traza("Despues de Conectar ConectorReabrirRegistrosVentas");	
	                
	                Object objeto=conector.objeto("DTONumRegistros");
	                traza("Objeto recogido"+objeto);
	                DTONumRegistros dtoNumReg = (DTONumRegistros)conector.objeto("DTONumRegistros");	
	                traza("DTONumRegistros obtenido");	                         
   				
     		        Long registros = dtoNumReg.getNumeroRegistros();
     		        traza("Numero de registros modificados: "+registros);
     		        asignar("VAR","numRegistros",registros.toString());
     		        asignar("VAR","accion","salida"); 
     		        //this.generarHiddenFormatoFecha();
     		        //pagina("contenido_registro_ventas_reabrir");
   		}                                                                                                       
                                                                     
                                                                                                            
  
		}catch ( Exception e )  {
        	e.printStackTrace();
        	this.logStackTrace(e);
        	lanzarPaginaError(e);
        }		  
    	traza("*** Salida - LPReabrirPeriodo - accionReabrir ***"); 
    }
      
    private void logStackTrace(Throwable e) throws Exception {     
		traza("Se produjo la excepcion: " + e.getMessage());         
	                                                             
		ByteArrayOutputStream baos = new ByteArrayOutputStream();    
		PrintStream ps = new PrintStream(baos);                      
		e.printStackTrace(ps);                                       
		                                                             
		traza("Stack Trace: " + baos.toString());                    
	 } 
}                                                            
                                                                                                   