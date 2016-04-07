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

import es.indra.mare.common.mln.MareBusinessID;

import es.indra.druida.DruidaConector;

import es.indra.sicc.dtos.mae.DTOBuscarClienteBloqueo;

import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.util.Vector;
import java.util.StringTokenizer;


public class LPAgregarCuotas extends LPSICCBase {

	private String accion = null;
	private String casoUso = null;
	private Long idioma;
	private Long pais;

	public LPAgregarCuotas() {
		super();
	}

	public void inicio() throws Exception {
	}

	public void ejecucion() throws Exception {

		try {
			setTrazaFichero();
            		traza("***Entrada - LPAgregarCuotas - ejecucion***");

			accion = conectorParametroLimpia("accion", "", true);
			traza("***accion : " + accion);

    			this.idioma = UtilidadesSession.getIdioma(this);
			this.pais = UtilidadesSession.getPais(this);
			this.casoUso = new String("provisiones");

			if (accion.equals("")) {
			        // Defino el nombre de la vista
			    	pagina("contenido_cuotas_cancelacion");
			    	//Debemos recibir los parametros proceso, subproceso y empresa y los guardamos en los campos ocultos del mismo nombre. 
							
				asignar("VAR","idioma", this.idioma.toString());		
				asignar("VAR","pais", this.pais.toString());		
				asignar("VAR","casoUso", this.casoUso);		
				Byte longitudCodigoCliente = obtenerLongitudCodigoCliente();
				asignar("VAR","longitudCodigoCliente", longitudCodigoCliente.toString());
								
				String proceso = conectorParametroLimpia("proceso","",true);
		                String subproceso = conectorParametroLimpia("subproceso","",true);
                		String empresa = conectorParametroLimpia("empresa","",true);
                  		asignarAtributo("VAR","proceso","valor",proceso);
                  		asignarAtributo("VAR","subproceso","valor",subproceso);
                  		asignarAtributo("VAR","empresa","valor",empresa);
				
				traza("Empresa: "+empresa);
				traza("Proceso: "+proceso);
				traza("Subproceso: "+subproceso);

		                  //Guardamos los valores de los separadores
		                 String separadorDecimales = UtilidadesSession.getSeparadorDecimales(this);
		            	 String separadorMiles = ",";
		                  if (separadorDecimales.equals(",")) {
		                            separadorMiles = ".";
		                  }
		                  asignar("VAR","hid_SeparadorMiles", separadorMiles);
		                  asignar("VAR","hid_NumeroDecimales",UtilidadesSession.getFormatoNumerico(this));
		                  asignar("VAR","hid_SeparadorDecimales", separadorDecimales);
		                  
		                  traza ("CANAL: "+conectorParametroLimpia("canal","",true));
		                  traza ("ACCESO: "+conectorParametroLimpia("acceso","",true));
		                  traza ("SUBACCESO: "+conectorParametroLimpia("subacceso","",true));
		                  
		                  String canal = conectorParametroLimpia("canal","",true);
		                  String acceso = conectorParametroLimpia("acceso","",true);
		                  String subacceso = conectorParametroLimpia("subacceso","",true);
		                  asignarAtributo("VAR","hcanal","valor",canal);
		                  asignarAtributo("VAR","hacceso","valor",acceso);
		                  asignarAtributo("VAR","hsubacceso","valor",subacceso);


				//En caso de no recibir proceso ó subproceso salimos de este método.
				if ((proceso!=null) && (subproceso!=null)){
					//Utilizando "<<subsystem:soporte>> GestorCargaPantalla" cargamos el COMBO: Canal	

	                            DTOBelcorp dto = new DTOBelcorp();
	                            dto.setOidPais(pais);
	                            dto.setOidIdioma(idioma);
			                  
 	                            //Llamar al subsistema GestorCargaPantalla :- idBusiness = SEGConsultaCanales y DTOBelcorp => llena combo canal 
	                            

				    ComposerViewElementList listelem = new ComposerViewElementList();
		                    ComposerViewElement elemCana = null;
		                  
		                    elemCana=new ComposerViewElement(); 
		                    elemCana.setIDBusiness("SEGConsultaCanales");
		                    elemCana.setDTOE(dto);
		                    listelem.addViewElement(elemCana);

             			                  
			            /*Se ejecuta el conector y se obtiene un RowSet que contiene todos los datos solicitados.*/ 
			            ConectorComposerView conector = new ConectorComposerView(listelem, this.getRequest());
			            conector.ejecucion();
			            DruidaConector conConsultar = conector.getConector();	                            
				                            
				    asignar("COMBO", "cbCanal", conConsultar, "SEGConsultaCanales"); 
				}
			}

			traza("***Salida - LPAgregarCuotas - ejecucion***");
			getConfiguracionMenu("LPCancelacionCuotas", "");
		
		} catch (Exception e){
			lanzarPaginaError(e);
			logStackTrace(e);
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