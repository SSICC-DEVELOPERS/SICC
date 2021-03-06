/**
 * Copyright 2005 � por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * Espa�a
 *
 * Privado y Confidencial.
 * La informaci�n contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permiti�ndose
 * la distribuci�n de este c�digo sin permiso expreso.
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


public class LPRecepcionarEstimadosVentas extends LPSICCBase {

	private String accion = "";
	private String casoUso = null;
	private Long idioma=null;
	private Long pais= null;
	
	
	public LPRecepcionarEstimadosVentas() {
		
		super();
		
	}
	
	public void inicio() throws Exception {				
				
		
	}
	        
	public void ejecucion() throws Exception {				
		
		setTrazaFichero();
		rastreo();
		traza("*** Entrada - LPRecepcionarEstimadosVentas - ejecucion ***");
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
		
		traza("*** Salida - LPRecepcionarEstimadosVentas - ejecucion ***");
		
	}

	private void cargarDatosIniciales() throws Exception {
		
		traza("*** Entrada - LPRecepcionarEstimadosVentas - cargarDatosIniciales ***");
		
		pagina("contenido_estimados_MAV_activacion_recepcionar");
		
		DTOString dtos = new DTOString();                                    
		dtos.setOidIdioma(idioma);
		dtos.setOidPais(pais);
		dtos.setCadena(IGestorInterfaces.COD_INTERFAZ_SAB9);
		//dtos.setCadena("SAB-9");
		
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
		asignar("VAR","casoUso","LPRecepcionarEstimadosVentas");
		asignarAtributo("PAGINA","contenido_estimados_MAV_activacion_recepcionar", "cod", "0290");
		asignarAtributo("PAGINA","contenido_estimados_MAV_activacion_recepcionar", "msgle", "Recepcionar estimados de ventas (Manual)");
		getConfiguracionMenu("LPRecepcionarEstimadosVentas","");
		
		traza("*** Entrada - LPRecepcionarEstimadosVentas - cargarDatosIniciales ***");
		
	}

	private void recepcionar() throws Exception {
		
		traza("*** Entrada - LPRecepcionarEstimadosVentas - recepcionar ***");

		DTOINT dtoINT = new DTOINT();				
		dtoINT.setNumeroLote(new Long(conectorParametroLimpia("hNumeroLote","",true)));		
		dtoINT.setOidIdioma(idioma);
		dtoINT.setOidPais(pais);
    
    traza("*** Antes de valObserv *** " );
    String valObserv = conectorParametro("areatxtObservaciones");
    String valDescLote = conectorParametro("Descripcion");
    traza("*** valObserv *** " + valObserv);
    traza("*** valDescLote *** " + valDescLote);
    
    dtoINT.setObservaciones(valObserv);
    dtoINT.setDescripcionLote(valDescLote);
		
    
		MareBusinessID intRecepcionarEstimadosMAVManual=new MareBusinessID("INTRecepcionarEstimadosVentasManualBatch");
		Vector paramEntrada = new Vector();
		paramEntrada.add(dtoINT);
		paramEntrada.add(intRecepcionarEstimadosMAVManual);	
		
		conectar("ConectorRecepcionarEstimadosVentas", paramEntrada);
		pagina("salidaGenerica");
		asignarAtributo("VAR", "ejecutar", "valor", "cerrarVentana()");
		
		traza("*** Entrada - LPRecepcionarEstimadosVentas - recepcionar ***");
		
	}
		
	private void logStackTrace(Throwable e) throws Exception {
	
		traza("Se produjo la excepcion: " + e.getMessage());
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		e.printStackTrace(ps);
		
		traza("Stack Trace: " + baos.toString());
	
	}
	
         
}
