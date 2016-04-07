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

/*
    INDRA/CAR/PROY
    $Id: LPEvaluarClientesChequear.java,v 1.1 2009/12/03 18:33:08 pecbazalar Exp $
    DESC
*/

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;

import es.indra.druida.DruidaConector;

import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;

import es.indra.sicc.dtos.cra.ConstantesCRA;

import es.indra.mare.common.dto.MareDTO;

import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.util.Vector;

public class LPEvaluarClientesChequear extends LPSICCBase {
    
	private String accion = null;
	private String casoUso = null;
	private Long idioma = null;
	private Long pais = null;
	private String separadorMiles = null;
	private String separadorDecimales = null;
	
	
	public LPEvaluarClientesChequear() {
	      super();
	}
	
	
	public void inicio() throws Exception {
	}
	
	
	public void ejecucion() throws Exception {
	
		// rastreo(); // no se accede a ella desde el menu principal
		
		try {
			setTrazaFichero(); 
			traza("*** Entrada - LPEvaluarClientesChequear - ejecucion ***");
			
			this.accion = conectorParametroLimpia("accion", "", true);
			traza("*** accion: " + accion);                     
			
			this.idioma = UtilidadesSession.getIdioma(this); 
			this.pais = UtilidadesSession.getPais(this);
			
			if (accion.equals("")) {
				this.cargaInicial();
			} else if (accion.equals("generarChequeos")) {
				this.generarChequeos();
			}
			
			traza("*** Salida - LPEvaluarClientesChequear - ejecucion ***");
	          
		} catch(Exception e) {
			logStackTrace(e);
			lanzarPaginaError(e);
		}
	}
	
	private void cargaInicial() throws Exception {
		traza("*** Entrada - LPEvaluarClientesChequear - cargaInicial ***");

		// nombre="contenido_zonas_seleccionar" cod="0682" titulo="Seleccionar Zonas"
		pagina("contenido_zonas_seleccionar");
		asignarAtributo("PAGINA", "contenido_zonas_seleccionar", "cod", "0682");
		asignarAtributo("PAGINA", "contenido_zonas_seleccionar", "msgle", "Seleccionar Zonas");
		getConfiguracionMenu("LPEvaluarClientesChequear", "");
		// entrada en el menu secundario: 
		// LPEvaluarClientesChequear/ = 0682,0,0,1,0,1,1,1,1,1,1

      // se asignan pais e idioma a los campos ocultos de la pantalla
      asignar("VAR", "idioma", this.idioma.toString());
      asignar("VAR", "pais", this.pais.toString());

      // cada usuario tiene una marca y canal por defecto que deben seleccionarse
      Long marca = UtilidadesSession.getMarcaPorDefecto(this);
      Long canal = UtilidadesSession.getCanalPorDefecto(this);
      
      // se asignan estos valores a campos ocultos de la pagina
      asignar("VAR", "oidMarca", marca.toString());
      asignar("VAR", "oidCanal", canal.toString());
 
      // Crear un DTOBelcorp dtoe con: 
      // - pais = Pais activo 
      // - idioma = Idioma del usuario 
      DTOBelcorp dtoe = new DTOBelcorp();
      dtoe.setOidPais(this.pais);
      dtoe.setOidIdioma(this.idioma);
      
      traza("-------------- DTOBelcorp creado: " + dtoe);
      
      // Crear una lista ComposerViewElementList
      ComposerViewElementList listelem = new ComposerViewElementList();
      ComposerViewElement elem = null;
      
      //Marcas 
      // Crear un elemento de tipo ComposerViewElement() para cargar las marcas 
      // elem.IDBusiness="SEGConsultaMarcas"; 
      // elem.DTOE=dtoe; 
      // Añadir el elemento a la lista 
      elem=new ComposerViewElement(); 
      elem.setIDBusiness("SEGConsultaMarcas");
      elem.setDTOE(dtoe);
      elem.setPosOID(new Byte("0").byteValue()); 
      elem.setPosDesc(new Byte("1").byteValue());
      listelem.addViewElement(elem);

      //Canales 
      // Crear un elemento de tipo ComposerViewElement() para cargar los canales
      // elem.IDBusiness="SEGConsultaCanales"; 
      // elem.DTOE=dtoe;
      // Añadir el elemento a la lista
      elem=new ComposerViewElement(); 
      elem.setIDBusiness("SEGConsultaCanales");
      elem.setDTOE(dtoe);
      elem.setPosOID(new Byte("0").byteValue()); 
      elem.setPosDesc(new Byte("1").byteValue());
      listelem.addViewElement(elem);

		traza("--------------- antes de conectar");

      // Invocar al subsistema GestorCargaPantalla 
      ConectorComposerView conector = new ConectorComposerView(listelem, this.getRequest());
      
      conector.ejecucion();
      
      DruidaConector conConsultar = conector.getConector();
      
      traza("--------------- despues de conectar");

      // Asigna los combos: 

      // - cbMarca <- SEGConsultaMarcas 
      asignar("COMBO", "cbMarca", conConsultar, "SEGConsultaMarcas", "VAL_OID", marca.toString());
                  
      // - cbCanal <- SEGConsultaCanales
      asignar("COMBO", "cbCanal", conConsultar, "SEGConsultaCanales", "VAL_OID", canal.toString()); 
				
		traza("*** Salida - LPEvaluarClientesChequear - cargaInicial ***");
	}
	
	private void generarChequeos() throws Exception {
		
		traza("*** Entrada - LPEvaluarClientesChequear - generarChequeos ***");
		
		pagina("salidaGenerica");
		asignar("VAR", "cerrarVentana", "true");
		asignar("VAR", "ejecutar", "ejecucionCorrecta()");
		//asignar("VAR", "ejecutarError", "ejecutarNoCorrecta()");

		// Crear idBusiness == "RECEvaluarClientesChequear" 
		// Crea un dto MareDTO 
		// // Añadimos al dto el periodo seleccionado en el combo 
		// dto.addProperty(ConstantesCRA.DATO_PERIODO,oidPeriodo) 
		// Invoca a ConectorEvaluarClientesChequear
		
		Long oidPeriodo = new Long(conectorParametroLimpia("cbPeriodo", "", true));
		
		traza("---- oidPeriodo recuperado de pantalla: " + oidPeriodo);
		
		MareDTO dto = new MareDTO();
		dto.addProperty(ConstantesCRA.DATO_PERIODO, oidPeriodo);
		
		traza("---- MareDTO creado: " + dto);
		
      Vector paramsEntrada = new Vector();                               		
      paramsEntrada.add(dto);                                                       		
      paramsEntrada.add(new MareBusinessID("RECEvaluarClientesChequear"));
      DruidaConector conector = conectar("ConectorEvaluarClientesChequear", paramsEntrada);	
      
      traza("*** Salida - LPEvaluarClientesChequear - generarChequeos ***");
	}
	
	protected void logStackTrace(Throwable e) throws Exception {
	   traza("Se produjo la excepcion: " + e.getMessage());
	   
	   ByteArrayOutputStream baos = new ByteArrayOutputStream();
	   PrintStream ps = new PrintStream(baos);
	   e.printStackTrace(ps);
	                          
	   traza("Stack Trace: " + baos.toString());
	}
	
}