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

import java.io.ByteArrayOutputStream; 
import java.io.PrintStream;

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;

import es.indra.druida.DruidaConector;

import es.indra.mare.common.mln.MareBusinessID;

import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.UtilidadesSession;

import es.indra.sicc.util.UtilidadesSession;

import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;

import es.indra.sicc.dtos.fac.DTOOIDsDocumentos;

import es.indra.sicc.dtos.fac.DTOFACCierreFacturacion;

public class LPRangosNumeracionATratar extends LPSICCBase {
	    
	private String accion = null;
	private String casoDeUso = null;
    	private Long idioma;
    	private Long pais;   

    // Añadido por la BELC300015675
    private Long subacceso = null;    

    
    	// Definicion del constructor
    	public LPRangosNumeracionATratar() {
		super();
    	}
    
    	// Definicion del metodo abstracto inicio
    	public void inicio() throws Exception {

		// Defino el nombre de la vista
           	pagina("contenido_documento_contable_reimprimir");
    	}

    	// Definicion del metodo abstracto ejecucion
        public void ejecucion() throws Exception {
                //rastreo();
                try{
                	setTrazaFichero(); 
             		traza("***Entrada - LPRangosNumeracionATratar - ejecucion***");
             
             		this.idioma = UtilidadesSession.getIdioma(this);
					this.pais = UtilidadesSession.getPais(this);

		            // Añadido por la BELC300015675
		            // Obtenemos el subacceso por defecto de la sesión.
		            this.subacceso = UtilidadesSession.getSubaccesoPorDefecto(this);
		            traza("subacceso = " + this.subacceso);
			
             		asignar("VAR", "idioma", idioma.toString());
	             	asignar("VAR", "pais", pais.toString()); 
	                this.accion = conectorParametroLimpia("accion","",true);
	             	this.casoDeUso = conectorParametroLimpia("casoDeUso","",true);
	             	asignar("VAR", "accion", this.accion);
	             	asignar("VAR", "casoDeUso", this.casoDeUso);
	             	traza("***accion : "+this.accion);
	             	traza("***caso de uso : "+this.casoDeUso);
			
			if(this.casoDeUso.equals("anular")) {
                        	getConfiguracionMenu("LPRangosNumeracionATratar","anular");   
                        } else if(this.casoDeUso.equals("regenerar")) {
                        	getConfiguracionMenu("LPRangosNumeracionATratar","regenerar");   
                	} else if(this.casoDeUso.equals("imprimir")) {
                		getConfiguracionMenu("LPRangosNumeracionATratar","imprimir");   
                	}	
             
             		//Bifurcamos la accion
             		if (accion.equals("")) {
                  		inicializar();
             		} else if (accion.equals("anular")) {
             			anular();
             		} else if (accion.equals("regenerar")) {
             			regenerar();
             		} else if (accion.equals("imprimir")) {
             			imprimir();
             		}             
                    
             		traza("***Salida - LPRangosNumeracionATratar - ejecucion***");
        	}catch(Exception e){
                  	logStackTrace(e);
             		lanzarPaginaError(e);
         	}
         }
         
         
         
         private void inicializar() throws Exception {
          	traza("***Entrada - LPRangosNumeracionATratar - inicializar***");
                if(this.casoDeUso.equals("anular")) {
                	asignarAtributo("PAGINA","contenido_documento_contable_reimprimir", "cod", "0539");
         		asignarAtributo("PAGINA","contenido_documento_contable_reimprimir", "msgle", "Desasignar Número de Documento Contable");
         	} else if(this.casoDeUso.equals("regenerar")) {
         		asignarAtributo("PAGINA","contenido_documento_contable_reimprimir", "cod", "0540");
         		asignarAtributo("PAGINA","contenido_documento_contable_reimprimir", "msgle", "Reasignar Número de Documento Contable");
         	} else if(this.casoDeUso.equals("imprimir")) {
         		asignarAtributo("PAGINA","contenido_documento_contable_reimprimir", "cod", "0554");
         		asignarAtributo("PAGINA","contenido_documento_contable_reimprimir", "msgle", "Reimprimir Documento Contable");
               	}
                this.generarHiddenFormatoFecha();
                
                Byte longitudCodigoCliente = this.obtenerLongitudCodigoCliente();
         	asignar("VAR","numDigitosCodigoCliente", longitudCodigoCliente.toString());
                  
                obtenerDatosIniciales();
                  
                traza("***Salida - LPRangosNumeracionATratar - inicializar***");
         }
         
         private void regenerar() throws Exception {
         	try {
         	     traza("***Entrada - LPRangosNumeracionATratar - regenerar***");
         	     pagina("salidaGenerica");
                     asignar("VAR", "cerrarVentana", "false");
                     
                     StringTokenizer st = null;
                     Long oid = null;
                     
                                
                     String listaOids = conectorParametroLimpia("listaOids", "", true);
                     traza("-------------- listaOids: " + listaOids);
                     String tam = conectorParametroLimpia("tamOids", "", true);
                     traza("-------------- tamOids: " + tam);
                     st = new StringTokenizer(listaOids, ",");
                     Integer index = new Integer(tam);
                     DTOOIDs dtoOids = new DTOOIDs();
                     Long[] oids = new Long[index.intValue()];
               	     int i = 0;  
                                       
                     while (st.hasMoreTokens()) {
                     	oid = new Long(st.nextToken());
                             oids[i] = new Long(oid.intValue());
                             ++i;            	
                     }
                               
                     dtoOids.setOids(oids);
                     
                     //Llamada a negocio:
                     //DTOE: DTOOIDs 
		     //DTOS: DTOSalida 
		     //Conector: ConectorRegenerarFacturas 
		     //Fachada: MLNFRegenerarFacturas
		      
		     MareBusinessID idNegocio = new MareBusinessID("FACRegenerarFacturas");
		     Vector paramsEntrada = new Vector();
		     paramsEntrada.add(dtoOids);
                     paramsEntrada.add(idNegocio);
                                                         
                     DruidaConector conector = conectar("ConectorRegenerarFacturas", paramsEntrada);
                                   
                     asignar("VAR", "ejecutar", "operacionCorrecta()");
                                 
         	     
	             traza("***Salida - LPRangosNumeracionATratar - regenerar***");
	        } catch (Exception e) {
                     e.printStackTrace();
             	     logStackTrace(e);
                     lanzarPaginaError(e);
                }
         }
         
         private void imprimir() throws Exception {
         	try {
         		traza("***Entrada - LPRangosNumeracionATratar - imprimir***");
         		
         		pagina("salidaGenerica");
                     	asignar("VAR", "cerrarVentana", "false");
         		
         		StringTokenizer st = null;
                     	Long oid = null;
                     	
                     	String listaOids = conectorParametroLimpia("listaOids", "", true);
                     	traza("-------------- listaOids: " + listaOids);
                     	String tam = conectorParametroLimpia("tamOids", "", true);
                     	traza("-------------- tamOids: " + tam);
                     	Integer index = new Integer(tam);
                     	DTOOIDs dtoOids = new DTOOIDs();
                     	Long[] oids = new Long[index.intValue()];
               	    	 int i = 0;  
                                     
                     	st = new StringTokenizer(listaOids, ",");   
                     	while (st.hasMoreTokens()) {
                     		oid = new Long(st.nextToken());
                            	 oids[i] = new Long(oid.intValue());
                            	 ++i;            	
                     	}
                               
                     	dtoOids.setOids(oids);
                     
                     	//Llamada a negocio:
                     	//DTOE: DTOOIDs 
		    	 //DTOS: DTOSalida 
                    	//Conector: ConectorReimprimirDocumentos  
		     	//Fachada: MLNFReimprimirDocumento

			MareBusinessID idNegocio = new MareBusinessID("FACReimprimirDocumento");

	        // Añadido por la BELC300015675
	        // Obtenemos el subacceso por defecto de la sesión.
	        DTOOIDsDocumentos dtoOidsDocumentos = new DTOOIDsDocumentos();
	        dtoOidsDocumentos.setOidPais(pais);
	        dtoOidsDocumentos.setOidIdioma(idioma);
	        dtoOidsDocumentos.setSubacceso(this.subacceso);
	        dtoOidsDocumentos.setLista(dtoOids);

	     	Vector paramsEntrada = new Vector();
		     	paramsEntrada.add(dtoOidsDocumentos);
		     	paramsEntrada.add(idNegocio);
                     
                     	traza("Antes de ConectorReimprimirDocumentos");                              
                     	DruidaConector conector = conectar("ConectorReimprimirDocumentos", paramsEntrada);
                     	traza("Despues de ConectorReimprimirDocumentos");
                     	
                     	asignar("VAR", "ejecutar", "imprimirCorrecto()");
         		
         		traza("***Salida - LPRangosNumeracionATratar - imprimir***");
         	    } catch (Exception e) {
                     	e.printStackTrace();
             	     	logStackTrace(e);
                        lanzarPaginaError(e);
                    }
         }	
         
         private void anular() throws Exception {
         	try {
 	             traza("***Entrada - LPRangosNumeracionATratar - anular***");
 	             pagina("salidaGenerica");
                     asignar("VAR", "cerrarVentana", "false");
                     
                     StringTokenizer st = null;
                     Long oid = null;
                     
                                
                     String listaOids = conectorParametroLimpia("listaOids", "", true);
                     traza("-------------- listaOids: " + listaOids);
                     String tam = conectorParametroLimpia("tamOids", "", true);
                     traza("-------------- tamOids: " + tam);
                     Integer index = new Integer(tam);
                     DTOOIDs dtoOids = new DTOOIDs();
                     Long[] oids = new Long[index.intValue()];
               	     int i = 0;  
                                     
                     st = new StringTokenizer(listaOids, ",");   
                     while (st.hasMoreTokens()) {
                     	oid = new Long(st.nextToken());
                             oids[i] = new Long(oid.intValue());
                             ++i;            	
                     }
                               
                     dtoOids.setOids(oids);
                     
                     //Llamada a negocio:
                     //DTOE: DTOOIDs 
		     //DTOS: DTOSalida 
                     //Conector: ConectorAnularFacturas 
		     //Fachada: MLNFAnularFacturas 
                      
		     MareBusinessID idNegocio = new MareBusinessID("FACAnularFacturas");
		     Vector paramsEntrada = new Vector();
		     
		     paramsEntrada.add(dtoOids);
		     /*
		     DTOFACCierreFacturacion aa = new DTOFACCierreFacturacion();
		     traza("NUEVO");
		     traza(aa);
		     
		     paramsEntrada.add(aa);
		     */
		     
		     paramsEntrada.add(idNegocio);
                     
                     traza("Antes de ConectorAnularFacturas");                              
                     DruidaConector conector = conectar("ConectorAnularFacturas", paramsEntrada);
                     traza("Despues de ConectorAnularFacturas");
                
                     asignar("VAR", "ejecutar", "operacionCorrecta()");
 	        
         	     traza("***Salida - LPRangosNumeracionATratar - anular**");
         	} catch (Exception e) {
                     e.printStackTrace();
             	     logStackTrace(e);
                     lanzarPaginaError(e);
                }
	 }
         
         
         
         private void obtenerDatosIniciales() throws Exception{
                  traza("***Entrada - LPRangosNumeracionATratar - obtenerDatosIniciales***");
                  
                  try{
                            		
                        //Creamos DTOBelcorp
                        DTOBelcorp dto = new DTOBelcorp();
                        dto.setOidPais(pais);
                        dto.setOidIdioma(idioma);
                          
                        //Creamos lista composerView
                        ComposerViewElementList listElement = new ComposerViewElementList();
                             		
                        //Carga canales
                        ComposerViewElement elem1=new ComposerViewElement();
                        elem1.setIDBusiness("SEGConsultaCanales");
                 	elem1.setDTOE(dto);
                  	elem1.setPosOID((byte)0);
                  	elem1.setPosDesc((byte)1);
                  	listElement.addViewElement(elem1);
                  	traza("elemento añadido");
                 
                  	//Carga los tipos de documento
                  	ComposerViewElement elem2 = new ComposerViewElement();
                  	elem2.setIDBusiness("FACObtenerTiposDocumentoLegal");
                 	elem2.setDTOE(dto);
                 	elem2.setPosOID((byte)0);
                 	elem1.setPosDesc((byte)1);
                 	
                 	
                  	listElement.addViewElement(elem2);
                  	traza("elemento añadido");
                           
                        //Llamar al subsistema GestorCargaPantalla
                        ConectorComposerView conector = new ConectorComposerView(listElement,this.getRequest());
                  	traza("conector creado");
                  conector.ejecucion();
                  traza("ejecutado");
                  DruidaConector conConsultar = conector.getConector();
                  traza("Obtener conConsultar");
         
        
                  asignar("COMBO","cbCanal", conConsultar,"SEGConsultaCanales"); 
                  asignar("COMBO","cbTipoDocumentoContable", conConsultar,"FACObtenerTiposDocumentoLegal");
         
                  }catch ( Exception e )  {
                  logStackTrace(e);
                           lanzarPaginaError(e);
                  }		

                  traza("***Salida - LPRangosNumeracionATratar - obtenerDatosIniciales***");
         }
         
         protected void logStackTrace(Throwable e) throws Exception {
           traza("Se produjo la excepcion: " + e.getMessage());
    
           ByteArrayOutputStream baos = new ByteArrayOutputStream();
           PrintStream ps = new PrintStream(baos);
           e.printStackTrace(ps);
                            
           traza("Stack Trace: " + baos.toString());
   	 }
         
}