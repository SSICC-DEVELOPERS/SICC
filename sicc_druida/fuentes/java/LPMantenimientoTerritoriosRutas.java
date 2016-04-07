/*
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
import java.util.Vector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.Enumeration;

import es.indra.druida.DruidaConector;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.xml.XMLDocument;

import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;

import org.w3c.dom.Document;
import java.io.ByteArrayInputStream;

public class LPMantenimientoTerritoriosRutas extends LPSICCBase {
          
          private String accion = null;
          private String opcionMenu = null;
          private Long idioma = null;
          private Long pais = null;
          
          public LPMantenimientoTerritoriosRutas() {
                    super();
          }


          public void inicio() throws Exception {


          }
          public void ejecucion() throws Exception {
                    setTrazaFichero();
                    try  {         
                          traza("***** LPMantenimientoTerritoriosRutas Entrada");                         
                          this.idioma = UtilidadesSession.getIdioma(this);
                          traza("accion : "+accion);
                          this.pais = UtilidadesSession.getPais(this);                                                                  
                          traza("Intenta coger la accion");
                          this.accion = conectorParametroLimpia("accion","", true);
                          traza("La acción es -> "+this.accion);
                          this.opcionMenu = conectorParametroLimpia("opcionMenu","", true);
                          traza("La opción de menú es -> "+this.opcionMenu);

                          //segun la acción seleccionamos el caso de uso 
                          if(this.accion.equals("")){            	                                                          
                                this.inicializar();                                              
                          }           
                          if(this.accion.equals("Seleccionar")){  
						        pagina("contenido_territorios_asociados_rutas_mantener"); 
						        asignar("VAR","pais", pais.toString());          
								asignar("VAR","idioma", idioma.toString());
								asignarAtributo("PAGINA","contenido_territorios_asociados_rutas_mantener","cod","0777");
								asignarAtributo("PAGINA","contenido_territorios_asociados_rutas_mantener","msgle","");

                          	DTOSalida territorios = obtenerTerritoriosAsociados(); 
				mostrarTerritoriosAsociados(territorios);	
                          } 
			  if(this.accion.equals("Guardar")){
			  	this.guardar();
			  }
			  if(this.accion.equals("Eliminar")){
			  	this.eliminar();
			  }
			  traza("***** LPMantenimientoTerritoriosRutas Salida");                    
                    }catch ( Exception e ){
                              e.printStackTrace();
                              this.logStackTrace(e);
                              lanzarPaginaError(e);
                    }                
          } 
          public void inicializar()throws Exception{
                traza("***** inicializar Entrada");
                            /*Si opcionMenu == "Mantener Territorios" 
				{ 
					Llamar al método cargarPGMantenerTerritoriosRutas() 
					Habilitar area1 
					Deshabilitar area2 
					Deshabilitar area3 
				} 
				
				sino 
				Si opcionMenu == "Consultar Territorios" 
				{ 
					Asigna la página PGConsultarTerritoriosRutas 
					Llamar al método cargarPGMantenerTerritoriosRutas() 
					Habilita el botón btBuscar 
					Oculta la lista de resultados "listaTerritoriosAsociados" 
				} 
				*/  
			traza("Cargamos la página");
			if(this.opcionMenu.equals("Mantener Territorios")){
				this.cargarPGMantenerTerritoriosRutas(); 
			}
			if(this.opcionMenu.equals("Consultar Territorios")){
				this.cargarPGMantenerTerritoriosRutas(); 
			}
			traza("Página cargada");        						       
                        traza("***** inicializar Salida");     
          }

          private void cargarCombos(DTOSalida dato) throws Exception{
          	    traza("***** cargarCombos Entrada");     
          	    
          	    Long idioma = UtilidadesSession.getIdioma(this);
	            Long pais = UtilidadesSession.getPais(this);   
	                          						       
                    DTOBelcorp dtoBelcorp = new DTOBelcorp();
                    dtoBelcorp.setOidIdioma(idioma);
                    dtoBelcorp.setOidPais(pais);
                    
                    ComposerViewElementList listelem = new ComposerViewElementList();

                    ComposerViewElement elem1 = new ComposerViewElement();
                    elem1.setIDBusiness("APPObtenerRutas");
                    elem1.setDTOE(dtoBelcorp);
                    listelem.addViewElement(elem1);                                        
                    ConectorComposerView conector1 = new ConectorComposerView(listelem, this.getRequest());
                    conector1.ejecucion();
                    DruidaConector conConsultar = conector1.getConector();
                    if(dato!=null){ //Cargamos el combo que ya estaba seleccionado
                    	asignar("COMBO", "cbRuta", conConsultar, "APPObtenerRutas","OID_RUTA_TRAN",conectorParametroLimpia("oidRuta","", true));
                    }else{
                    	asignar("COMBO", "cbRuta", conConsultar, "APPObtenerRutas");
                    }

                    traza("***** cargarCombos Salida");    
                     
          }

          public void cargarPGMantenerTerritoriosRutas()throws Exception{
	                    traza("***** cargarPGMantenerTerritoriosRutas Entrada");
	                    
	                    if(this.opcionMenu.equals("Mantener Territorios")){
								pagina("contenido_territorios_asociados_rutas_mantener"); 
								asignar("VAR","pais", pais.toString());         
                            	asignar("VAR","idioma", idioma.toString());
                            	asignarAtributo("PAGINA","contenido_territorios_asociados_rutas_mantener","cod","0777");
                            	asignarAtributo("PAGINA","contenido_territorios_asociados_rutas_mantener","msgle","");
               			this.getConfiguracionMenu("LPMantenimientoTerritoriosRutas", "");                         
  	        
                            }
                            if(this.opcionMenu.equals("Consultar Territorios")){
				pagina("contenido_territorios_asociados_rutas_consultar"); 
				asignar("VAR","pais", pais.toString());         
                           	asignar("VAR","idioma", idioma.toString());
                           	asignarAtributo("PAGINA","contenido_territorios_asociados_rutas_consultar","cod","0778");
                           	asignarAtributo("PAGINA","contenido_territorios_asociados_rutas_consultar","msgle","");
               			this.getConfiguracionMenu("LPMantenimientoTerritoriosRutas", "Consultar");
			    } 
			    
			    this.cargarCombos(null);
			    			
			    asignarAtributo("VAR","casoUso","valor",this.opcionMenu);
	                    asignarAtributo("VAR","accion","valor",this.accion);					
			                              
			    traza("***** cargarPGMantenerTerritoriosRutas Salida");     
          }

          //Elimina los territorios asociados de la base de datos
	public void eliminar()throws Exception{
                          traza("***** eliminar Entrada");
                 pagina("salidaGenerica"); 
				asignar("VAR","ejecutar", "postEliminar();");
                         
                          DTOOIDs dtoOids = new DTOOIDs();
                          String lista = conectorParametroLimpia("listado2","",true);                            
                          StringTokenizer listaOids = new StringTokenizer(lista,","); 
                         // Long[] oids = new Long[listaOids.countTokens()];//a eliminar sólo de la Base de datos
                          Long[] oids = new Long[listaOids.countTokens()];//a eliminar sólo de la Base de datos
                          Long[] oids2 = new Long[listaOids.countTokens()];//todos
                          int i = 0;
                          int j = 0;
                          while(listaOids.hasMoreElements()){
                          	String aux = listaOids.nextElement().toString(); 
                          	if(!(aux).equals("0")){
	                          	oids[j] = new Long(aux);	                          		
	                          	j++;
	                        }
				oids2[i] = new Long(aux);
				i++;				
                          }
                          Long[] oids3 = new Long[j];                                                   
                          for (int h = 0; h < j; h++) {
                          	oids3[h] = oids[h];	
                          }
                          dtoOids.setOids(oids3);
	                  MareBusinessID idBusiness = new MareBusinessID("APPEliminarTerritoriosAsociados");
		  	  Vector entrada = new Vector();
		          entrada.add(dtoOids);
		          entrada.add(idBusiness);
		          traza("***** antes de conectar");
		          DruidaConector conector = conectar("ConectorEliminarTerritoriosAsociados",entrada);
		          traza("***** despues de conectar");
		          dtoOids.setOids(oids2);
		          eliminarTerritoriosLista(dtoOids);             
                          traza("***** eliminar Salida");  
                             
  	}

  	//Elimina los territorios asociados de la lista
  	public void eliminarTerritoriosLista (DTOOIDs DTOE) throws Exception{
                traza("***** eliminarTerritoriosLista Entrada");
        /*        StringBuffer pagina = new StringBuffer();
		pagina.append("<?xml version=\"1.0\" encoding=\"ISO-8859-1\" standalone=\"no\"?>");
		pagina.append("<PAGINA nombre=\"contenido_territorios_asociados_rutas_mantener\" onload=\"eliminarTerritoriosLista();\">");
		pagina.append("<JAVASCRIPT>");
		pagina.append("  <![CDATA[ ");
		pagina.append("  function eliminarTerritoriosLista() {");
		pagina.append("  	window.opener.listado2.eliminarSelecc()");
		pagina.append("  	window.opener.listado2.repinta()");
		pagina.append("  }");
		pagina.append("  ]]> ");
		pagina.append("</JAVASCRIPT>");
		pagina.append("</PAGINA>");

		this.setXML(getDocument(pagina.toString()));
  
  	        pagina("contenido_territorios_asociados_rutas_mantener"); 
  	        asignar("VAR","pais", pais.toString());          
		asignar("VAR","idioma", idioma.toString());
		asignarAtributo("PAGINA","contenido_territorios_asociados_rutas_mantener","cod","0777");
		asignarAtributo("PAGINA","contenido_territorios_asociados_rutas_mantener","msgle","");
  	        this.getConfiguracionMenu("LPMantenimientoTerritoriosRutas", "Eliminar");                         
  	        this.cargarCombos(null);*/
                
                traza("***** eliminarTerritoriosLista Salida");  
                     
  	}
  	
  	private Document getDocument(String cadena) throws Exception {
		javax.xml.parsers.DocumentBuilderFactory dfactory =
		javax.xml.parsers.DocumentBuilderFactory.newInstance();
		//		Use the DocumentBuilderFactory to provide access to a DocumentBuilder.
		javax.xml.parsers.DocumentBuilder dBuilder = dfactory.newDocumentBuilder();
		//		Use the DocumentBuilder to parse the XML input.
		org.w3c.dom.Document inDoc = dBuilder.parse(new ByteArrayInputStream(cadena.getBytes()), "file://C:/belcorpmmg/druida/xml/gui/");
		return inDoc;
	}

  	private DTOSalida obtenerTerritoriosAsociados () throws Exception{ 		
  		traza("***** obtenerTerritoriosAsociados Entrada");  
  		
  		DTOSalida dtoSalida = new DTOSalida();
  		  Long oid = new Long(conectorParametroLimpia("cbRuta","",true));   
                  DTOOID dtoOID = new DTOOID();
                  dtoOID.setOidPais(this.pais);
                  dtoOID.setOidIdioma(this.idioma);
                  dtoOID.setOid(oid);
           	  
                  MareBusinessID idBusiness = new MareBusinessID("APPObtenerTerritoriosAsociados");
	  	  Vector entrada = new Vector();
	          entrada.add(dtoOID);
	          entrada.add(idBusiness);
	           //conectas con el conector adecuado y pasándole la entrada deseada mediante el vector			   
	          traza("***** antes de conectar");
	          DruidaConector conector = conectar("ConectorObtenerTerritoriosAsociados",entrada);
	          traza("***** despues de conectar");
	          dtoSalida = (DTOSalida)conector.objeto("DTOSalida");
	          
                  traza("***** obtenerTerritoriosAsociados Salida");     
                  return dtoSalida;               
                  
	}

	private void mostrarTerritoriosAsociados (DTOSalida dtoSalida) throws Exception{  	
	                traza("***** mostrarTerritoriosAsociados Entrada");       			
			RecordSet filas = new RecordSet();
			filas.addColumn("oid");               
                        filas.addColumn("numeroSecuencia");                  
			filas.addColumn("codigoTerritorio");
                        filas.addColumn("modificado");
                        filas.addColumn("oidTerritorio");
                        filas.addColumn("oidRuta");
			if (dtoSalida.getResultado() != null) {
         			for (int i = 0; i < dtoSalida.getResultado().getRecords().size(); i++) {
         				Vector fila = new Vector();
         				fila.add(dtoSalida.getResultado().getValueAt(i,0));
         				fila.add(dtoSalida.getResultado().getValueAt(i,2));         	
         				fila.add(dtoSalida.getResultado().getValueAt(i,1));	
         				fila.add("");
					fila.add("");         				
					fila.add("");     
					filas.addRow(fila);    
					traza("Nº de filas: "+filas);
		           	}
		        }	        
		        traza("0");
                        this.getConfiguracionMenu("LPMantenimientoTerritoriosRutas", "Seleccionar");
                        asignarAtributo("CAPA","capa2","visibilidad","visible");	
                        asignarAtributo("CAPA","capaLista1","visibilidad","visible");
                        asignarAtributo("CAPA","capaLista2","visibilidad","visible");
                        this.cargarCombos(dtoSalida);
                        //Deshabilitar combo ruta (incidencia 9409)
                        asignarAtributoElemento("cbRuta","disabled","S");
	  		traza("1");
		        Vector cols = filas.getColumnIdentifiers();
		        traza("2");
                        DruidaConector conectorLista = UtilidadesBelcorp.generarConector("DTOSalida.resultado", filas, cols);
	  		traza("3");                        
                        asignar("LISTAEDITABLE", "listado2", conectorLista,"DTOSalida.resultado");
          		traza("4");                
                                  
		traza("***** mostrarTerritoriosAsociados Salida");     
                  
	}

	 public void guardar()throws Exception{
                traza("***** guardar Entrada");
                pagina("salidaGenerica"); 
				asignar("VAR","ejecutar", "postGuardar();");
   			
		RecordSet listaFinal = new RecordSet();
		
		String oid_Ruta="OID_RUTA";
		String oid="OID";
		String numero_Secuencia="NUMERO_SECUENCIA";
		String oid_Territorio="OID_TERRITORIO";
		listaFinal.addColumn(oid_Ruta);
		listaFinal.addColumn(oid);
		listaFinal.addColumn(numero_Secuencia);
		listaFinal.addColumn(oid_Territorio);

		Long oidRuta = new Long(conectorParametroLimpia("cbRuta","",true));
		String lista = conectorParametroLimpia("listaRegistros","",true);

                StringTokenizer listaT = new StringTokenizer(lista,"#"); // separa por registros

                while(listaT.hasMoreTokens()){    
                	Vector filaInsertar = new Vector();                	
                	String fila = listaT.nextToken();
                	String cadena;
                        StringTokenizer filaT = new StringTokenizer(fila,"@"); // separa por celdas
                    	while(filaT.hasMoreTokens()){
                    	    cadena=filaT.nextToken();
                            filaInsertar.add(cadena);      
                        }     
                        filaInsertar.add(0,oidRuta);
                        String aux = (String)filaInsertar.get(1);
                        traza("Aux="+aux);
                        if(aux.equals("0")){
                        	filaInsertar.set(1,null);
                        }
                        traza("Fila a Insertar:"+filaInsertar);
			listaFinal.addRow(filaInsertar);   
                } 	    
                DTOSalida dtoSalida = new DTOSalida();
                
                dtoSalida.setResultado(listaFinal);
                
                Vector paramConector = new Vector();
                paramConector.add(dtoSalida);
                paramConector.add(new MareBusinessID("APPGuardarTerritoriosAsociados"));             
                traza("***** Antes de Conectar ");
                DruidaConector conector = conectar("ConectorGuardarTerritoriosAsociados", paramConector);                                                                     
                traza("***** Despues de Conectar");   
                
  	    /*asignar("VAR","pais", pais.toString());          
		asignar("VAR","idioma", idioma.toString());
		asignarAtributo("PAGINA","contenido_territorios_asociados_rutas_mantener","cod","0777");
		asignarAtributo("PAGINA","contenido_territorios_asociados_rutas_mantener","msgle","");
                this.getConfiguracionMenu("LPMantenimientoTerritoriosRutas","Guardar");
                asignarAtributo("CAPA","capaLista1","visibilidad","hidden");
                asignarAtributo("CAPA","capaLista2","visibilidad","hidden");   
                this.cargarCombos(null);*/
                             
                traza("***** guardar Salida");     
          }
	         
        private void logStackTrace(Throwable e) throws Exception {
                  traza("Se produjo la excepcion: " + e.getMessage());		
                  ByteArrayOutputStream baos = new ByteArrayOutputStream();
                  PrintStream ps = new PrintStream(baos);
                  e.printStackTrace(ps);		
                  traza("Stack Trace: " + baos.toString());
        }       	                  	                                 
}                  