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
    INDRA/CCC/PROY
    $Id: LPInterfazLarissa.java,v 1.1 2009/12/03 18:32:54 pecbazalar Exp $
    DESC
 */
 
import es.indra.druida.DruidaConector;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.cmn.negocio.interfaces.IGestorInterfaces;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;


import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOString;
import es.indra.sicc.util.DTOColeccion;
import java.util.Vector;
import java.util.ArrayList;

import es.indra.sicc.dtos.intsys.DTOCargaInicialInterfaz;
import es.indra.sicc.dtos.intsys.DTOINT;
import es.indra.sicc.dtos.intsys.DTOINTCargaInicialLarissa;

public class LPInterfazLarissa extends LPSICCBase {

	private String accion= null;
	private Long pais;
	private Long idioma;
	
	public LPInterfazLarissa() {
	    super();
	}
	
	public void inicio() throws Exception {
	      pagina("contenido_larissa_interfaz");
	}
	
	public void ejecucion() throws Exception {
	      setTrazaFichero();
	      traza("*** Entrada - LPInterfazLarissa - ejecucion ***");          
	      
	      this.accion = conectorParametroLimpia("accion", "", true);
	      this.idioma = UtilidadesSession.getIdioma(this);
	      this.pais = UtilidadesSession.getPais(this);
	      
	      traza("Accion: "+this.accion+" Idioma: "+this.idioma+" Pais: "+this.pais);
	      asignarAtributo("PAGINA","contenido_larissa_interfaz", "cod", "0270");
	      asignarAtributo("PAGINA","contenido_larissa_interfaz", "msgle", "Interfaz con larissa");
	      getConfiguracionMenu("LPInterfazLarissa","");
	      
	      try{				
	               if (accion.equals("")){
	                        traza("Antes de llamar a cargarDatosIniciales");
	                        cargarDatosIniciales();
	               }
	               if (accion.equals("enviar")){
	                        traza("enviarInterfaces");
	                        enviarInterfaces();
	               }
	      }catch(Exception  e){
	               traza("ERROR: " + e);
	               e.printStackTrace();
	               lanzarPaginaError(e);  
	      }
	      traza("*** Salida - LPInterfazLarissa - ejecucion ***");          
	}
         
	private void cargarDatosIniciales() throws Exception{
		traza("*** Entrada - LPInterfazLarissa - cargarDatosIniciales  ***");
		/*
		Invocamos al motor plano, con los siguientes parámetros: 		
		DTOE: new DTOString( IGestorInterfaces.COD_INTERFAZ_LAR1 ) 
		DTOS: DTOINT 
		conector: ConectorObjeto 
		IDBusiness: INTCargaInicial 
		- asignamos el valor DTOS.numeroLote al control lblNumeroLote 
		- asignamos el valor DTOS.descripcion al control txtDescripcion 			
		*/
		
		DTOCargaInicialInterfaz dtoSalida=null;
		Vector paramConector = new Vector();
		DTOString dtos = new DTOString();
		
		dtos.setCadena(IGestorInterfaces.COD_INTERFAZ_LAR1);
		//traza("COD_INTERFAZ_LAR1 "+IGestorInterfaces.COD_INTERFAZ_LAR1);
		dtos.setOidPais(pais);
		dtos.setOidIdioma(idioma);
		
		//Relleno los parametros de entrada para llamar al conector
		paramConector.add(dtos);
		paramConector.add(new MareBusinessID("INTCargaInicialInterfaz"));
		
		traza("Antes de conectar en accion vacia");			
		DruidaConector conector1 = conectar("ConectorObjeto", paramConector);
		dtoSalida = (DTOCargaInicialInterfaz)conector1.objeto("DTOSalida");
		traza ("DTOCargaInicialInterfaz: "+ dtoSalida);
		
		//Con el DTOCargaInicialInterfaz obtenido cargamos los campos lblNumeroLote y Descripcion con los atributos numeroLote y descripcion
		traza("***** Antes de rellenar campos");   
		traza("DTOSALIDA.getNumeroLote: "+ dtoSalida.getNumeroLote());
		traza("DTOSALIDA.getDescripcion: "+dtoSalida.getDescripcion());
		
		asignarAtributo("CTEXTO","Descripcion","valor",dtoSalida.getDescripcion());
		asignar("LABELC","lbldtLote",dtoSalida.getNumeroLote().toString());
		asignar("VAR","numeroLote",dtoSalida.getNumeroLote().toString()); 
		
		
		/*
		Cargamos el combo Interfaces
		Invocamos al motor plano, con los siguientes parámetros:
		DTOE: DTOBelcorp, con el pais y idioma del usuario
		DTOS: DTOColeccion
		conector: ConectorCargaInicialLarissa 
		IDBusiness: INTCargaInicialLarissa
		- Con el DTO obtenido se carga el control 'lstInterfaces', mostrando la descripcion de cada registro			
		*/
		
		paramConector = new Vector();
		DTOBelcorp dtoBelcorp = new DTOBelcorp();	
		DTOColeccion dtoSalidaInterfaz = null;
		dtoBelcorp.setOidPais(pais);
		dtoBelcorp.setOidIdioma(idioma);
		
		paramConector.add(dtoBelcorp);
		paramConector.add(new MareBusinessID("INTCargaInicialLarissa"));
		
		traza("Antes de conectar en accion vacia para recoger datos del combo interfaz");			
		DruidaConector conectorInterfaz = conectar("ConectorCargaInicialLarissa", paramConector);
		dtoSalidaInterfaz = (DTOColeccion)conectorInterfaz.objeto("DTOSalida");
		traza ("DTOSALIDA: "+ dtoSalidaInterfaz);
		
		ArrayList array = null;
		RecordSet rs = new RecordSet();
		Vector vFila = null;
		array = dtoSalidaInterfaz.getLista();
		if (array!=null){
			rs.addColumn("id");
			rs.addColumn("Interfaz");
			for (int i=0;i<array.size();i++){
				vFila = new Vector();
				vFila.add(new Integer(i));
				vFila.add(array.get(i));
				rs.addRow(vFila);
			}
			traza("Antes de cargar combo interfaces");
			Vector cols = rs.getColumnIdentifiers();
			DruidaConector conectorCargaCombo = UtilidadesBelcorp.generarConector( "DTOSalida.combo_ROWSET", rs, cols);
			asignar("COMBO", "cbInterfaz", conectorCargaCombo, "DTOSalida.combo_ROWSET"); 
		}
		
		
			
		/*		
		Crear una lista ComposerViewElementList 
		Crear un DTOBelcorp dtoe con: 
		- pais = Pais activo 
		- idioma = Idioma del usuario*/
		
		// Se obtiene el pais y el idioma de sesión
		asignar("VAR", "idioma", idioma.toString());
		asignar("VAR", "pais", pais.toString());
		
		DTOBelcorp dto = new DTOBelcorp();
		dto.setOidPais(this.pais);
		dto.setOidIdioma(this.idioma);
		
		//Invocar al subsistema GestorCargaPantalla 
		ComposerViewElementList listelem = new ComposerViewElementList();
		ComposerViewElement elem = null;
		
		elem=new ComposerViewElement(); 
		elem.setIDBusiness("SEGConsultaMarcas");
		elem.setDTOE(dto);
		listelem.addViewElement(elem);
		
		elem=new ComposerViewElement(); 
		elem.setIDBusiness("SEGConsultaCanales");
		elem.setDTOE(dto);
		listelem.addViewElement(elem);
		
		
		ConectorComposerView conector2 = new ConectorComposerView(listelem, this.getRequest());
		conector2.ejecucion();
		DruidaConector conConsultar = conector2.getConector();
		
		asignar("COMBO", "cbMarca", conConsultar, "SEGConsultaMarcas");
		asignar("COMBO", "cbCanal", conConsultar, "SEGConsultaCanales");
		
		// Asignamos valor por defecto al check 16801
		asignarAtributo("CHECKBOX","ckProductosEstimados","check","S");
		
		traza("*** Salida - LPInterfazLarissa - cargarDatosIniciales ***");
	}
	
	private void enviarInterfaces() throws Exception{
		
		traza("*** Entrada - LPInterfazLarissa - enviarInterfaces ***");
		
		//Salida Generica
		pagina("salidaGenerica");
		asignar("VAR", "cerrarVentana", "false");
		asignar("VAR", "ejecutar", "ejecucionCorrecta()");
		
		/*
		Invocamos al motor plano, con los siguientes parámetros: 
		
		DTOE: DTOINTCargaInicialLarissa, construído con los datos de pantalla 
		DTOS: DTOSalidaBatch 
		conector: ConectorEnviarInterfaces 
		IDBusiness: "INTEnviarInterfacesLarissa"
		*/
		
		DTOINTCargaInicialLarissa dtoe = new DTOINTCargaInicialLarissa();
		Vector paramConector = new Vector();
		
		String numeroLote = conectorParametroLimpia("numeroLote","",true);
		String descripcion = conectorParametroLimpia("Descripcion","",true);
		String observaciones = conectorParametroLimpia("areatxtObservaciones","",true);
		String canal = conectorParametroLimpia("cbCanal","",true);
		String marca = conectorParametroLimpia("cbMarca","",true);
		String periodo = conectorParametroLimpia("cbPeriodo","",true);
		String estimados = conectorParametroLimpia("hEstimados","",true);
		
		traza("NumeroLote: "+numeroLote);
		traza("Descripcion: "+descripcion);
		traza("Observaciones: "+observaciones);
		traza("Canal: "+canal);
		traza("Marca: "+marca);
		traza("Periodo: "+periodo);
		traza("Estimados: "+estimados);
		traza("Pais: "+this.pais);
		traza("Idioma: "+this.idioma);

		if (this.pais!=null){
			dtoe.setOidPais(this.pais);
		}
		traza("Antes de comprobar idioma");
		if (this.idioma!=null){
			dtoe.setOidIdioma(this.idioma);
			traza("Pasa setIdioma");
		}
		traza("Antes de comprobar canal)");
		if ((canal!=null) && !(canal.equals(""))){
			dtoe.setCanal(new Long(canal));
			traza("Pasa setCanal");
		}
		traza("Antes de comprobar marca");
		if ((marca!=null) && !(marca.equals(""))){
			dtoe.setMarca(new Long(marca));
			traza("Pasa setMarca");
		}
		traza("Antes de comprobar periodo");
		if ((periodo != null) && !(periodo.equals(""))){
			dtoe.setPeriodo(new Long(periodo));
			traza("Pasa setPeriodo");
		}
		traza("Antes de comprobar observaciones");
		if ((observaciones != null) && !(observaciones.equals(""))){
			dtoe.setObservaciones(observaciones);
		}
		traza("Antes de comprobar descripcion");
		if ((descripcion != null) && !(descripcion.equals(""))){
			dtoe.setDescripcionLote(descripcion);
		}
		traza("Antes de comprobar numeroLote");
		if ((numeroLote != null) && !(numeroLote.equals(""))){
			dtoe.setNumeroLote(numeroLote);
		}
		
		if (estimados.equals("S")){
			dtoe.setEnviarEstimados(new Boolean(true));
		}else{
			dtoe.setEnviarEstimados(new Boolean(false));
		}
		
		
		traza ("DTO: "+dtoe);
		paramConector.add(dtoe);
		paramConector.add(new MareBusinessID("INTEnviarInterfacesLarissa"));
		traza("ANTES CONECTOR AL ENVIAR");
		DruidaConector conector = conectar("ConectorEnviarInterfaces", paramConector);
		traza("*** Salida - LPInterfazLarissa - enviarInterfaces ***");
	}

         
}