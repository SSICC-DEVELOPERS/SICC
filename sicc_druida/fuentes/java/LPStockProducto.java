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
 
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.druida.DruidaConector;

import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.DTOBelcorp;

import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Vector;
import java.util.ArrayList;

public class LPStockProducto extends LPSICCBase {
	
	private String accion = null;
        private Long idioma;
        private Long pais;
        private String oidContacto = null;
        
        public LPStockProducto(){
		super();
	}
	
	public void inicio() throws Exception {
         	pagina("contenido_producto_consultar");
        }
        
        public void ejecucion() throws Exception {
                  
                  setTrazaFichero();
                  try {
                            
                  	traza("***Entrada - LPPedidosNoFacturados - ejecucion***");
			
			this.idioma = UtilidadesSession.getIdioma(this);
                        this.pais = UtilidadesSession.getPais(this);
                        asignar("VAR", "idioma", idioma.toString());
                        asignar("VAR", "pais", pais.toString()); 
                        this.accion = conectorParametroLimpia("accion","",true);
                        this.oidContacto = conectorParametroLimpia("oidContacto","",true);   
						asignar("VAR", "oidContacto", this.oidContacto);


                        traza("***accion : " + accion);
                        
                        asignarAtributo("PAGINA", "contenido_producto_consultar", "msgle", "");
                        asignarAtributo("PAGINA", "contenido_producto_consultar", "cod", "0574");
                        getConfiguracionMenu("LPStockProducto", "Consultar");

                           
                        if (accion.equals("")) {
                        	this.cargaInicial();
                        }
                              
                        traza("***Salida - LPPedidosNoFacturados - ejecucion***");
                    
                    } catch(Exception e) {
                              logStackTrace(e);
                              lanzarPaginaError(e);
                    }
	}
     
     	private void cargaInicial() throws Exception {
     		try {
                            traza("***Entrada - LPPedidosNoFacturados - cargaInical***");
                           // alternativa: utilizar el metodo cargaCombo
                                                     
                           // Crear un DTOBelcorp dtoe con: 
                           // - pais = Pais activo 
                           // - idioma = Idioma del usuario
                           DTOBelcorp dtoBelcorp = new DTOBelcorp();
                                        
                           Long pais = UtilidadesSession.getPais(this);
                           Long idioma = UtilidadesSession.getIdioma(this);
                           dtoBelcorp.setOidPais(pais);
                           dtoBelcorp.setOidIdioma(idioma);
         
                           String[] idBusiness = {"SEGConsultaMarcas", "SEGConsultaCanales", "BELObtieneAlmacenPais"};
                                        
                           ArrayList dtos = new ArrayList();
                           dtos.add(dtoBelcorp);
                           dtos.add(dtoBelcorp);
                           dtos.add(dtoBelcorp);
                                                                                                                           
                           cargaCombos(dtoBelcorp, idBusiness, dtos);
                                                                                                                                            	          
                           traza("***Salida - LPPedidosNoFacturados - cargaInical***");
                    
                  } catch (Exception e) {
                           e.printStackTrace();
                           logStackTrace(e);
                           lanzarPaginaError(e);
                  }
          }
          
          private void cargaCombos(DTOBelcorp dtoBelcorp, String[] idBusiness, ArrayList dtos) throws Exception {
                    
                    traza("*** Entrada - cargaCombos ***");
                    
                    try {
                              //Cada elemento va a contener el IDbusiness y el DTO que reciben la logica de negocio como entrada. 
                              ComposerViewElementList listelem = new ComposerViewElementList();
                              ComposerViewElement elem = null;
                              
                              DTOBelcorp unDto = null;
                              for (int i = 0; i < idBusiness.length; i++) {
                                         elem = new ComposerViewElement(); 
                                         elem.setIDBusiness(idBusiness[i]);
                                         unDto = (DTOBelcorp)dtos.get(i);
                                         elem.setDTOE(unDto);
                                         
                                         listelem.addViewElement(elem);
                              }

                              /*Se ejecuta el conector y se obtiene un RowSet que contiene todos los datos solicitados.*/ 
                              ConectorComposerView conector = new ConectorComposerView(listelem, this.getRequest());
				
                              conector.ejecucion();
                              
                              traza("*** Antes de coger el conector ***");	
                              DruidaConector conConsultar = conector.getConector();
                              traza("*** Despues de coger el conector ***");
                              
                              /*Posterior a la llamada se debe hacer el asignar a los elementos de la pantalla 
                              //correspondiente utilizando el String que representa el BusinessID en cada caso. */
                                 
                              asignar("COMBO", "cbMarca", conConsultar, "SEGConsultaMarcas"); 
                              asignar("COMBO", "cbCanal", conConsultar, "SEGConsultaCanales"); 
                              asignar("COMBO", "cbAlmacen", conConsultar, "BELObtieneAlmacenPais"); 
                                    
                    } catch (Exception ex) {
                              this.logStackTrace(ex);
                    }
                    traza("*** Salida - cargaCombos ***");
        }
      
     	protected void logStackTrace(Throwable e) throws Exception {
                    traza("Se produjo la excepcion: " + e.getMessage());
                    
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    PrintStream ps = new PrintStream(baos);
                    e.printStackTrace(ps);
                                         
                    traza("Stack Trace: " + baos.toString());
    	}
}

        
        


