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
import es.indra.mare.common.mln.MareBusinessID;

import es.indra.druida.DruidaConector;

import java.io.ByteArrayOutputStream; 
import java.io.PrintStream;

import es.indra.sicc.util.DTOBelcorp;

import es.indra.sicc.util.UtilidadesSession;

import es.indra.sicc.util.DTOOID;

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.util.DTOSalida;

import java.util.Vector;




public class LPGerente extends LPSICCBase
{
	
	private String accion = null;
    private Long hIdioma;
    private Long hPais;
    private Long hOid= null;
    private String oidContacto = null;
   
  
    // Definicion del constructor
    public LPGerente (){
          super();
    } 
         
    //Inicio vacio
    public void inicio() throws Exception {
   		pagina("contenido_gerente_consultar");
    }

    public void ejecucion() throws Exception {

    	rastreo();
		setTrazaFichero(); 
		try{
            
            traza("***Entrada - LPGerente - ejecucion***");     
            this.hIdioma = UtilidadesSession.getIdioma(this);
            this.hPais = UtilidadesSession.getPais(this);
            asignar("VAR", "idioma", this.hIdioma.toString());
            asignar("VAR", "pais", this.hPais.toString()); 
			this.accion = conectorParametroLimpia("accion", "", true); 
			this.oidContacto = conectorParametroLimpia("oidContacto","",true);   
			asignar("VAR", "oidContacto", this.oidContacto);
  
            asignarAtributo("PAGINA","contenido_gerente_consultar", "cod", "0573");
         	asignarAtributo("PAGINA","contenido_gerente_consultar", "msgle", "Consultar Gerente ");
            this.hOid = new Long(conectorParametroLimpia("oidZona", "", true)); 
            //this.hOid = new Long(1); //para probar
            traza("oid "+hOid);     
  			if (accion.equals("")) {
				cargaInicial(); 
			}
			getConfiguracionMenu("LPGerente","");
			
    		traza("***Salida - LPGerente - ejecucion***");
          }catch(Exception e){
          	logStackTrace(e);
            lanzarPaginaError(e);
         }
         
		}
		
		private void cargaInicial() throws Exception{
			try{
				traza("***Entra - LPGerente - cargaInicial***");
				DTOOID dtoe = new DTOOID();
				dtoe.setOidPais(this.hPais);
	        	dtoe.setOidIdioma(this.hIdioma);
	        	dtoe.setOid(this.hOid);
	        	Vector paramConector = new Vector();
				paramConector.add(dtoe);
	    		MareBusinessID mid = new MareBusinessID("CALConsultarGerente");
	            paramConector.add(mid);
	            traza("antes de llamar al conector objeto");
	            DruidaConector conector = conectar("ConectorConsultarGerente", paramConector);
	            traza("Despues de conectar");
	            DTOSalida dtoSalida = (DTOSalida)conector.objeto("DTOSalida");
	            asignar("LABELC","lbldtCodCliente",(dtoSalida.getResultado().getValueAt(0,0)).toString());
	            if (dtoSalida.getResultado().getValueAt(0,1)!= null){
	            	asignar("LABELC","lbldtNombre1",(dtoSalida.getResultado().getValueAt(0,1)).toString());
	        	}
	        	if (dtoSalida.getResultado().getValueAt(0,2)!= null){
	            	asignar("LABELC","lbldtNombre2",(dtoSalida.getResultado().getValueAt(0,2)).toString());
	        	}
	        	if (dtoSalida.getResultado().getValueAt(0,3)!=null){
	            	asignar("LABELC","lbldtApellido1",(dtoSalida.getResultado().getValueAt(0,3)).toString()); 
	        	}
	        	if (dtoSalida.getResultado().getValueAt(0,4)!=null) {
	            asignar("LABELC","lbldtApellido2",(dtoSalida.getResultado().getValueAt(0,4)).toString());
	        	}
	            traza("***Salida - LPGerente - cargaInicial***");
	         }catch(Exception  e){
         		traza("ERROR: " + e);
         		e.printStackTrace();
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


        