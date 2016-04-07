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

import es.indra.mare.common.exception.MareException;

import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;

import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;

import es.indra.sicc.dtos.fac.DTOOIDsDocumentos;

public class LPImprimirCuponesReemplazo extends LPSICCBase {
	
	private String accion = null;
    	private Long idioma;
    	private Long pais;
    	
    	public LPImprimirCuponesReemplazo() {
          super();
    	}   
    	
    	public void inicio() throws Exception {
         // Defino el nombre de la vista
         pagina("contenido_cupones_reemplazo_imprimir");
    	}
    	
    	public void ejecucion() throws Exception {
    		
    		setTrazaFichero();
    		try {
                	 
             		traza("***Entrada - LPImprimirCuponesReemplazo - ejecucion***");
              
                        this.idioma = UtilidadesSession.getIdioma(this);
                        this.pais = UtilidadesSession.getPais(this);
                        asignar("VAR", "idioma", idioma.toString());
                        asignar("VAR", "pais", pais.toString()); 
                        this.accion = conectorParametroLimpia("accion","",true);
                        // Fecha:
                        this.generarHiddenFormatoFecha();
                        String longitudCodCliente = obtenerLongitudCodigoCliente().toString(); 
                  	asignar("VAR", "longitudCodigoCliente", longitudCodCliente);
			
			asignarAtributo("PAGINA", "contenido_cupones_reemplazo_imprimir", "msgle", "");
                  	asignarAtributo("PAGINA", "contenido_cupones_reemplazo_imprimir", "cod", "0555");
                  	getConfiguracionMenu("LPImprimirCuponesReemplazo", "imprimir");
                           
                        traza("***accion : " + accion);
                        
                        if (accion.equals("")) {
                  		this.obtenerDatosIniciales();
             		} else if (accion.equals("imprimir")) {
                  		this.imprimir();
                  	}
                           
                        traza("***Salida - LPImprimirCuponesReemplazo - ejecucion***");
                  
                  } catch(Exception e) {
                           logStackTrace(e);
                           lanzarPaginaError(e);
                  }
         }
         
	public void obtenerDatosIniciales() throws Exception {
		
		try {
			 traza("***Entrada - LPImprimirCuponesReemplazo - obtenerDatosIniciales***");
			// alternativa: utilizar el metodo cargaCombo
			
			
	                // Crear un DTOBelcorp dtoe con: 
	                // - pais = Pais activo 
	                // - idioma = Idioma del usuario
	                DTOBelcorp dtoBelcorp = new DTOBelcorp();
	                           
	                Long pais = UtilidadesSession.getPais(this);
	                Long idioma = UtilidadesSession.getIdioma(this);
	                dtoBelcorp.setOidPais(pais);
	             	dtoBelcorp.setOidIdioma(idioma);
	
	                String[] idBusiness = {"SEGConsultaMarcas", "SEGConsultaCanales"};
	                           
	                ArrayList dtos = new ArrayList();
	                dtos.add(dtoBelcorp);
	                dtos.add(dtoBelcorp);
                                                                               
	                String[] combos = {"cbMarca", "cbCanal"};                        
	                           
	                // cada usuario tiene una marca y canal por defecto que deben seleccionarse
	                Long marca = UtilidadesSession.getMarcaPorDefecto(this);
	                Long canal = UtilidadesSession.getCanalPorDefecto(this);
	
	                String[] seleccionados = {marca.toString(), canal.toString()};
	                String[] columnas = {"VAL_OID", "VAL_OID"};
	                           
	                cargaCombos(dtoBelcorp, 
	                            idBusiness, 
	                            dtos,
	                            combos, 
	                            seleccionados, 
	                            columnas);
				                                                                                           	         
	                traza("***Salida - LPImprimirCuponesReemplazo - obtenerDatosIniciales***");
                  
                } catch (Exception e) {
                	e.printStackTrace();
             		logStackTrace(e);
             		lanzarPaginaError(e);
                }
         }
         
         private void cargaCombos(DTOBelcorp dtoBelcorp, 
                                  String[] idBusiness, 
                                  ArrayList dtos,
                                  String[] combos, 
                                  String[] seleccionados, 
                                  String[] columnas) throws Exception {
                  
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
                           
			   traza("-------antes de coger el conector ----------");	
                           DruidaConector conConsultar = conector.getConector();
         		   traza("-------despues de coger el conector ----------");
         		   
                           /*Posterior a la llamada se debe hacer el asignar a los elementos de la pantalla 
                           //correspondiente utilizando el String que representa el BusinessID en cada caso. */
                             
                           asignar("COMBO", "cbMarca", conConsultar, "SEGConsultaMarcas"); 
                     	   asignar("COMBO", "cbCanal", conConsultar, "SEGConsultaCanales"); 
                     		
                  } catch (Exception ex) {
                           this.logStackTrace(ex);
                  }
                  traza("*** Salida - cargaCombos ***");
         }
         
         private void imprimir() throws Exception {
                  try {
                        traza("***Entrada - LPImprimirCuponesReemplazo - imprimir***");
                        pagina("salidaGenerica");
                        asignar("VAR", "cerrarVentana", "false");
                        
                         //- Se construye un objeto DTOOIDs con los oid de los registros marcados en la pantalla de detalle
			DTOOIDs dtoOids = new DTOOIDs();
                  	String parametro = conectorParametroLimpia("codigos", "", true);
                  	traza("**********parametro: " + parametro);
                    
                  	if(!parametro.equals("")) {
                        	StringTokenizer st = new StringTokenizer(parametro, ",");;
                           	Vector vOids = new Vector();
                           	while (st.countTokens() > 0) {
                                	vOids.add(new Long(st.nextToken())); 
                           	}
                           	Long[] oids = new Long[vOids.size()];
                           	for (int i = 0; i < oids.length; i++)
                                	oids[i] = (Long)vOids.get(i);
                           	dtoOids.setOids(oids);
                  	}

                  	dtoOids.setOidPais(pais);
                  	dtoOids.setOidIdioma(idioma);
                        
                        //Llamada a negocio:
                        //DTOE: DTOOIDs. Modificado por la BELC300015675. Ahora entra un DTOOIDsDocumentos
                        //DTOS: DTOSalida 
                        //Conector: ConectorImprimirCuponesReemplazo
                        //Fachada: MLNFImprimirCuponesReemplazo 
                         
                        // Añadido por la BELC300015675
                        // Obtenemos el subacceso por defecto de la sesión.
                        Long subacceso = UtilidadesSession.getSubaccesoPorDefecto(this);
                        traza("subacceso obtenido = "+subacceso);
                        DTOOIDsDocumentos dtoOidsDocumentos = new DTOOIDsDocumentos();
                        dtoOidsDocumentos.setOidPais(pais);
                        dtoOidsDocumentos.setOidIdioma(idioma);
                        dtoOidsDocumentos.setSubacceso(subacceso);
                        dtoOidsDocumentos.setLista(dtoOids);

                        MareBusinessID idNegocio = new MareBusinessID("FACImprimirCuponesReemplazo");
                        Vector paramsEntrada = new Vector();
                        paramsEntrada.add(dtoOidsDocumentos);
                        paramsEntrada.add(idNegocio);
                        
                        traza("Antes de ConectorImprimirCuponesReemplazo");                                  
                        DruidaConector conector = conectar("ConectorImprimirCuponesReemplazo", paramsEntrada);
                        traza("Despues de ConectorImprimirCuponesReemplazo");
                                                   
                        asignar("VAR", "ejecutar", "operacionCorrecta()");
                  
                        traza("***Salida - LPImprimirCuponesReemplazo - imprimir***");
                  } catch (Exception e) {
                        e.printStackTrace();
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