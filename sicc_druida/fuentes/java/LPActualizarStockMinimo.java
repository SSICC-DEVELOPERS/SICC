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
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;

import java.util.Vector;

import es.indra.sicc.cmn.negocio.comun.DTOComunes.DTOString; 

import es.indra.sicc.dtos.bel.DTOActualizarStockMinimo;
	
import es.indra.druida.DruidaConector;

import es.indra.mare.common.mln.MareBusinessID;

import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;

import es.indra.sicc.util.UtilidadesSession;

import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;

import es.indra.sicc.logicanegocio.seg.ConstantesSEG;

import es.indra.mare.common.exception.MareException;



public class LPActualizarStockMinimo extends LPSICCBase {
           
	   private Long pais = null;
	   private Long idioma = null;           
	   private String accion = null;

	   public LPActualizarStockMinimo() {
	              super();
	   }
	
	
	   public void inicio() throws Exception {
	
	
	   }
	   public void ejecucion() throws Exception {
	              setTrazaFichero();
	              try  {          
	                     traza("***** LPActualizarStockMinimo Entrada");                                                                                                
	                     traza("Intenta coger la accion");
	                     this.accion = conectorParametroLimpia("accion","", true);
	                     traza("La acción es -> "+this.accion); 
	                     this.idioma = UtilidadesSession.getIdioma(this);
	                     this.pais = UtilidadesSession.getPais(this);
	                     traza("PAIS: "+this.pais);
	
	                     //segun la acción seleccionamos el caso de uso 
	                     if(this.accion.equals("")){                                                                                        
	                            this.cargarPagina();                                                    
	                     }            
	                     if(this.accion.equals("actualizar")){  
	                            this.actualizar();  
	                     }                             
	                     traza("***** LPActualizarStockMinimo Salida");                      
	              }catch ( Exception e ){
	                          e.printStackTrace();
	                          this.logStackTrace(e);
	                          lanzarPaginaError(e);
	              }                  
	   } 
	       
	public void actualizar()throws Exception{
		try{
			traza("***** actualizar Entrada");
			
			pagina("salidaGenerica");
			asignar("VAR","cerrarVentana","false");
			asignar("VAR","ejecutar","Correcto()");
			
			DTOActualizarStockMinimo dto = new DTOActualizarStockMinimo(); 
			traza("subacceso");
			String subacceso = conectorParametroLimpia("subacceso","",true);
			traza("periodo");
			String periodo = conectorParametroLimpia("cbPeriodo","",true);
			
		        traza("*******pais: "+ this.pais + " idioma: " + this.idioma + " subacceso: " + subacceso + " periodo: " + periodo );		        
		        dto.setOidPais(this.pais);		
		        traza("*******1a");
			dto.setOidIdioma(this.idioma);
		        traza("*******1b");	
		        if(!subacceso.equals("")){
		        	dto.setSubacceso(new Long(subacceso));
		       	}					
		        traza("*******1c");		
		        if(!periodo.equals("")){
		        	dto.setPeriodo(new Long(periodo));
		       	}					
		        traza("*******2");			
			MareBusinessID idBusiness = new MareBusinessID("BELActualizarStockMinimo");
		        Vector entrada = new Vector();
		        entrada.add(dto);
		        entrada.add(idBusiness);
		        traza("Antes de conectar");		        
		 	DruidaConector conector = conectar("ConectorActualizarStockMinimo",entrada);
		        traza("Después de conectar");		 	
			traza("***** actualizar Salida");
	  	}catch ( Exception e ){
	       		e.printStackTrace();
	             	this.logStackTrace(e);
	                lanzarPaginaError(e);
	        }
	}
	public void cargarPagina()throws Exception{
		try{
		traza("***** cargarPagina Entrada");   
		/*
		-> Asignar página "contenido_stock_minimo_actualizar" 
		-> Obtener la dirección IP del cliente a través del request 
		-> Crear objeto DTOString, asignando a su atributo "cadena" la dirección IP obtenida en la actividad anterior 
		-> Crear idBusiness = "BELObtenerSubaccesoAsociado" 
		-> Asignar conector "ConectorObtenerSubaccesoAsociado" con idBusiness y dto creados 
		-> Crear variable llamada "subacceso" de tipo DTOOID y asignarle el dto de respuesta de la asignación anterior 
		-> Asignar a la variable "subacceso" de la pantalla el valor del atributo "subacceso.oid" 
		-> Llamar al subsistema GestorCargaPantalla con los siguientes datos 
		- idBusiness = "SEGConsultaMarcas" => llena el combo "marca" 
		-> Asignar a la variable "canal" el valor de "ConstantesSEG.CANAL_VD" 
		-> Mostrar página
		*/		
		pagina("contenido_stock_minimo_actualizar");    
	        asignarAtributo("PAGINA","contenido_stock_minimo_actualizar","cod","0482");
	        asignarAtributo("PAGINA","contenido_stock_minimo_actualizar","msgle","Actualizar stock minimo");
	        asignar("VAR", "pais", this.pais.toString());
	        asignar("VAR", "idioma", this.idioma.toString());
	        this.getConfiguracionMenu("LPActualizarStockMinimo", "");          		
		this.cargarCombos();	
	        // Obtengo la ip del cliente y la almaceno en un DTOString.
                  
                DTOString dtoString = new DTOString();
                dtoString.setCadena(this.getRequest().getRemoteAddr());
                dtoString.setOidPais(this.pais);
                dtoString.setOidIdioma(this.idioma);
                traza("************* LPActualizarStockMinimo.IP" + this.getRequest().getRemoteAddr());

                MareBusinessID idBusiness = new MareBusinessID("BELObtenerSubaccesoAsociado");
                  
                //Almacenamos los parametros de entrada
                Vector paramEntrada = new Vector();
                paramEntrada.addElement(dtoString);
                paramEntrada.addElement(idBusiness);
                  
                traza("************* LPActualizarStockMinimo antes conector " + paramEntrada);
                DruidaConector conector = conectar("ConectorObtenerSubaccesoAsociado", paramEntrada);
                traza("************* LPActualizarStockMinimo despues conector ");
                  
                //- Se obtiene un DTOOID con el subacceso asociado.
                DTOOID dtoOID = (DTOOID)conector.objeto("DTOOID");
                  
                traza("DTOOID: "+dtoOID);
                String strOid = (dtoOID.getOid()==null)?"":dtoOID.getOid().toString();
                  
                //String strOid="4";
                  
                asignar("VAR", "subacceso", strOid); 

                // vbongiov -- 29/10/2008
				DTOString dtoString1 = new DTOString();
                dtoString1.setCadena(ConstantesSEG.COD_CANAL_VD);
                dtoString1.setOidPais(this.pais);
                dtoString1.setOidIdioma(this.idioma);

                MareBusinessID idBusiness1 = new MareBusinessID("BELObtenerCanalVD");
                  
                //Almacenamos los parametros de entrada
                Vector paramEntrada1 = new Vector();
                paramEntrada1.addElement(dtoString1);
                paramEntrada1.addElement(idBusiness1);
                  
                traza("************* LPActualizarStockMinimo antes conector " + paramEntrada1);
                DruidaConector conector1 = conectar("ConectorObtenerCanalVD", paramEntrada1);
                traza("************* LPActualizarStockMinimo despues conector ");
                  
                //- Se obtiene un DTOOID con el subacceso asociado.
                DTOOID dtoOID1 = (DTOOID)conector1.objeto("DTOOID");

	            asignar("VAR", "canal", dtoOID1.getOid().toString());	        
	        
	    	traza("***** cargarPagina Salida");     
	  	}catch ( Exception e ){
	       		e.printStackTrace();
	             	this.logStackTrace(e);
	                lanzarPaginaError(e);
	        }
	   }
	
	                       
	   private void cargarCombos() throws Exception{
	          try{
	              traza("***** cargarCombos Entrada"); 
	                              						        
	              DTOBelcorp dtoBelcorp = new DTOBelcorp();
	              dtoBelcorp.setOidIdioma(this.idioma);
	              dtoBelcorp.setOidPais(this.pais);
	              
	              ComposerViewElementList listelem = new ComposerViewElementList();
	
	              ComposerViewElement elem1 = new ComposerViewElement();
	              elem1.setIDBusiness("SEGConsultaMarcas");
	              elem1.setDTOE(dtoBelcorp);
	              listelem.addViewElement(elem1);                                             
	              ConectorComposerView conector1 = new ConectorComposerView(listelem, this.getRequest());
	              conector1.ejecucion();
	              DruidaConector conConsultar = conector1.getConector();
	             
	              asignar("COMBO", "cbMarca", conConsultar, "SEGConsultaMarcas"); 
	
	              traza("***** cargarCombos Salida");    
	                
	          }catch ( Exception e ){
	                      e.printStackTrace();
	                      this.logStackTrace(e);
	                      lanzarPaginaError(e);
	              }
	   }
	
	           
	 private void logStackTrace(Throwable e) throws Exception {
	            traza("Se produjo la excepcion: " + e.getMessage());           
	            ByteArrayOutputStream baos = new ByteArrayOutputStream();
	            PrintStream ps = new PrintStream(baos);
	            e.printStackTrace(ps);                  
	            traza("Stack Trace: " + baos.toString());
	 }                                     	                                     
}                    