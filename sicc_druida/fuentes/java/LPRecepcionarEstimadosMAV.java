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

import java.util.Vector;

import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.DTOString;

import es.indra.sicc.dtos.intsys.DTOINT;
import es.indra.sicc.dtos.intsys.DTOCargaInicialInterfaz;

import es.indra.sicc.cmn.negocio.interfaces.IGestorInterfaces;

import es.indra.mare.common.mln.MareBusinessID;

import es.indra.druida.DruidaConector;

public class LPRecepcionarEstimadosMAV extends LPSICCBase {

	private String accion = "";
	private String casoUso = null;
	private Long idioma=null;
	private Long pais= null;
		
	public LPRecepcionarEstimadosMAV() {
		
		super();
		
	}
	
	public void inicio() throws Exception {	
					
				
		
	}	
	
	public void ejecucion() throws Exception {	
					
		setTrazaFichero();
		rastreo();
		traza("*** Entrada - LPRecepcionarEstimadosMAV - ejecucion ***");
		try{
			accion = conectorParametroLimpia("accion","",true);
			idioma = UtilidadesSession.getIdioma(this);
			pais = UtilidadesSession.getPais(this);
			
			if(accion.equals("")){
				cargarDatosIniciales(); 
			}else if(accion.equals("recepcionar")){
				recepcionar();
			}
		}catch ( Exception e )  {
			logStackTrace(e);
			lanzarPaginaError(e);
		}		
		traza("*** Salida - LPRecepcionarEstimadosMAV - ejecucion ***");
		
	}
	
	private void cargarDatosIniciales() throws Exception {
		
		traza("*** Entrada - LPRecepcionarEstimadosMAV - cargarDatosIniciales ***");
		
		pagina("contenido_estimados_MAV_activacion_recepcionar");
		
		DTOString dtos = new DTOString();                                    
		dtos.setOidIdioma(idioma);
		dtos.setOidPais(pais);
		dtos.setCadena(IGestorInterfaces.COD_INTERFAZ_SAB10);
		//dtos.setCadena("SAB-10");
		
		MareBusinessID mid = new MareBusinessID("INTCargaInicialInterfaz");
		Vector vec = new Vector();
		vec.add(dtos);
		vec.add(mid);
		
		DruidaConector dc = conectar("ConectorObjeto", vec);
		DTOCargaInicialInterfaz dtoCarga = (DTOCargaInicialInterfaz)dc.objeto("DTOSalida");
		
		String numeroDeLote=dtoCarga.getNumeroLote().toString();
		String descripcion=dtoCarga.getDescripcion();		
		
		asignar("CTEXTO","Descripcion",descripcion);            		
		asignar("LABELC","lblvalorLote",numeroDeLote);	
		asignar("VAR","hNumeroLote",numeroDeLote);
		asignar("VAR","casoUso","LPRecepcionarEstimadosMAV");	
		asignarAtributo("PAGINA","contenido_estimados_MAV_activacion_recepcionar", "cod", "0895");
		asignarAtributo("PAGINA","contenido_estimados_MAV_activacion_recepcionar", "msgle", "Recepcionar Estimados MAV Activación Manual");			
		getConfiguracionMenu("LPRecepcionarEstimadosMAV","");
		
		traza("*** Entrada - LPRecepcionarEstimadosMAV - cargarDatosIniciales ***");
		
	}

	private void recepcionar() throws Exception {
		
		traza("*** Entrada - LPRecepcionarEstimadosMAV - recepcionar ***");
		
		DTOINT dtoINT = new DTOINT();				
		dtoINT.setNumeroLote(new Long(conectorParametroLimpia("hNumeroLote","",true)));		
		dtoINT.setOidIdioma(idioma);
		dtoINT.setOidPais(pais);
		
		MareBusinessID intRecepcionarEstimadosMAVManual=new MareBusinessID("INTRecepcionarEstimadosMAVManualBatch");
		Vector paramEntrada = new Vector();
		paramEntrada.add(dtoINT);
		paramEntrada.add(intRecepcionarEstimadosMAVManual);	
		
		conectar("ConectorRecepcionarEstimadosMAV", paramEntrada);		
		
		pagina("salidaGenerica");
		asignarAtributo("VAR", "ejecutar", "valor", "cerrarVentana()");
		
		traza("*** Entrada - LPRecepcionarEstimadosMAV - recepcionar ***");
		
	}
			
	private void logStackTrace(Throwable e) throws Exception {
	
		traza("Se produjo la excepcion: " + e.getMessage());
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		e.printStackTrace(ps);
		
		traza("Stack Trace: " + baos.toString());
	
	}	
         
}