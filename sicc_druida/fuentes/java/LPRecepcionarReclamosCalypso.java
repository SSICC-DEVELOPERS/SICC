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
import es.indra.sicc.util.DTOString;

import es.indra.sicc.dtos.intsys.DTOINT;
import es.indra.sicc.dtos.intsys.DTOCargaInicialInterfaz;

import es.indra.sicc.cmn.negocio.interfaces.IGestorInterfaces;

import es.indra.mare.common.mln.MareBusinessID;

import es.indra.druida.DruidaConector;


public class LPRecepcionarReclamosCalypso extends LPSICCBase {

	private String accion = "";
	private String casoUso = null;
	private Long idioma=null;
	private Long pais= null;
	
	
	public LPRecepcionarReclamosCalypso() {		
		super();		
	}
	
	public void inicio() throws Exception {	
	}
	        
	public void ejecucion() throws Exception {		
		setTrazaFichero();
		rastreo();
		traza("LPRecepcionarReclamosCalypso.ejecucion():Entrada");
		try {
          accion = conectorParametroLimpia("accion","",true);
          idioma = UtilidadesSession.getIdioma(this);
          pais = UtilidadesSession.getPais(this);
          
          if(accion.equals("")) {
              cargarPantalla(); 
          } else if(accion.equals("recepcionar")) {
              recepcionar();
          }
          
		} catch(Exception e) {
        logStackTrace(e);
        //lanzarPaginaError(e);
		}		
		traza("LPRecepcionarReclamosCalypso.ejecucion():Salida");		
	}

  /**
   * @author Emilio Noziglia
   * @since 02/12/2005
   * @param void  
   * @return void 
   * @throws Exception
   * @reference SICC-DMCO-INTSAB-GCC-001-003
   */ 
	private void cargarPantalla() throws Exception {
		
		traza("LPRecepcionarReclamosCalypso.cargarPantalla():Entrada");
		
		pagina("contenido_reclamos_calypso_recepcionar");
		
		DTOString dtos = new DTOString();                                    
		dtos.setOidIdioma(idioma);
		dtos.setOidPais(pais);
		dtos.setCadena(IGestorInterfaces.COD_INTERFAZ_CPR1);
		
		MareBusinessID mid = new MareBusinessID("INTCargaInicialInterfaz");
		Vector vec = new Vector();
		vec.add(dtos);
		vec.add(mid);
		
		DruidaConector dc = conectar("ConectorObjeto", vec);
		DTOCargaInicialInterfaz dtoCarga = (DTOCargaInicialInterfaz)dc.objeto("DTOSalida");
		
		String numeroDeLote=dtoCarga.getNumeroLote().toString();
		String descripcion=dtoCarga.getDescripcion();		
		
		asignar("CTEXTO","txtDescripcion",descripcion);            		
		asignar("LABELC","lblvalorLote",numeroDeLote);	
		asignar("VAR","numeroLote",numeroDeLote);
		asignarAtributo("PAGINA","contenido_reclamos_calypso_recepcionar", "cod", "01016");
		asignarAtributo("PAGINA","contenido_reclamos_calypso_recepcionar", "msgle", "Recepcionar reclamos calypso (Manual)");
		getConfiguracionMenu("LPRecepcionarReclamosCalypso","");
		
		traza("LPRecepcionarReclamosCalypso.cargarPantalla():Salida");
		
	}

  /**
   * @author Emilio Noziglia
   * @since 02/12/2005
   * @param void  
   * @return void 
   * @throws Exception
   * @reference SICC-DMCO-INTSAB-GCC-001-003
   */ 	
	private void recepcionar() throws Exception {
		
		traza("LPRecepcionarReclamosCalypso.recepcionar():Entrada");

		DTOINT dtoINT = new DTOINT();				
		dtoINT.setNumeroLote(new Long(conectorParametroLimpia("numeroLote","",true)));		
		dtoINT.setOidIdioma(pais);
		dtoINT.setOidPais(idioma);
        traza("el dto DTOINT (para RET) contiene: " + dtoINT);

		
		MareBusinessID intRecepcionar = new MareBusinessID("INTRETRecepcionarReclamosCalyspso");
		Vector paramEntrada = new Vector();
		paramEntrada.add(dtoINT);
		paramEntrada.add(intRecepcionar);	
		
		pagina("salidaGenerica");
		asignarAtributo("VAR", "ejecutar", "valor", "cerrarVentana()");

		conectar("ConectorRecepcionarReclamosCalypso", paramEntrada);
		
		traza("LPRecepcionarReclamosCalypso.recepcionar():Salida");
		
	}

  /**
   * @author Emilio Noziglia
   * @since 02/12/2005
   * @param Throwable e  
   * @return void 
   * @throws Exception
   * @reference Metodo de apoyo
   */ 		
	private void logStackTrace(Throwable e) throws Exception {
	
		traza("Se produjo la excepcion: " + e.getMessage());
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		e.printStackTrace(ps);
		
		traza("Stack Trace: " + baos.toString());
	
	}
	
         
}
