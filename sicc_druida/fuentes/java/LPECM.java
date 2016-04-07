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
 
import es.indra.druida.DruidaConector;
import es.indra.mare.common.mln.MareBusinessID;

import es.indra.sicc.cmn.negocio.interfaces.IGestorInterfaces;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;


import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.DTOString;
import java.util.Vector;


import es.indra.sicc.dtos.intsys.DTOINT;
import es.indra.sicc.dtos.intsys.DTOCargaInicialInterfaz;
import es.indra.sicc.cmn.negocio.batch.DTOBatch;

public class LPECM extends LPSICCBase {

	private String accion = "";
	private String opcion = "";
	private Long pais;
	private Long idioma;
	
	public LPECM() {
		super();
	}
	
	public void inicio() throws Exception {
		pagina("contenido_ventas_asociadas_consultoras_recibir");
	}
	
	public void ejecucion() throws Exception {
		setTrazaFichero();
		traza("*** Entrada - LPECM - ejecucion ***");
		
		this.accion = conectorParametroLimpia("accion", "", true);
		this.opcion = conectorParametroLimpia("opcion", "", true);
		this.idioma = UtilidadesSession.getIdioma(this);
		this.pais = UtilidadesSession.getPais(this);
		asignar("VAR","accion",this.accion);
		asignar("VAR","opcion",this.opcion);
		asignar("VAR","idioma",this.idioma.toString());
		asignar("VAR","pais",this.pais.toString());
		
		traza("Accion: "+this.accion+" Opcion: "+this.opcion+" Idioma: "+this.idioma+" Pais: "+this.pais);
		cargarMenuSecundario();
		try{
			if (accion.equals("")){
				traza("Antes de llamar a accionVacia");
				accionVacia();
			}
			if (accion.equals("guardar")){
				traza("Antes llamada a aacionGuardar");
				accionGuardar();
			}
		}catch(Exception  e){
			traza("ERROR: " + e);
			e.printStackTrace();
			lanzarPaginaError(e);
		}
		traza("*** Salida - LPECM - ejecucion ***");
	}
	
	private void accionVacia() throws Exception{
		traza("*** Entrada - LPECM - accionVacia ***");
		/*
		Si opcion = "ventas" { 
		-> Crear un DTOString con la constante IGestorInterfaces.COD_INTERFAZ_ECM1 (además del pais y el idioma) } 
		Si opcion = "clientes" { 
		-> Crear un DTOString con la constante IGestorInterfaces.COD_INTERFAZ_ECM2 (además del pais y el idioma) } 
		-> Llamar al ConectorObjeto con el idBusiness "INTCargaInicialInterfaz" y el dto. 
		-> Con el DTOINT obtenido mostramos la pantalla PgRecibirVentasAsociadasConsultora cargando los campos lbNumeroLote y descripcion con los atributos numeroLote y descripcionInterfaz */
		
		traza("Opcion: "+this.opcion);
		DTOString dtos = null;
		//DTOINT dtoSalida = null;
		DTOCargaInicialInterfaz dtoSalida = null;
		Vector paramConector = new Vector();
		if (!this.opcion.equals("")){
			if (this.opcion.equals("ventas")){
				traza(" Opcion VENTAS ");
				dtos = new DTOString();
				dtos.setCadena(IGestorInterfaces.COD_INTERFAZ_ECM1);
				dtos.setOidPais(pais);
				dtos.setOidIdioma(idioma);
			}
			if (this.opcion.equals("clientes")){
				traza(" Opcion CLIENTES ");
				dtos = new DTOString();
				dtos.setCadena(IGestorInterfaces.COD_INTERFAZ_ECM2);
				dtos.setOidPais(pais);
				dtos.setOidIdioma(idioma);
			}
			//Añadido por incidencia 15221
			if (this.opcion.equals("enviar clientes")){
				traza(" Opcion ENVIAR CLIENTES ");
				dtos = new DTOString();
				dtos.setCadena(IGestorInterfaces.COD_INTERFAZ_ECM3);
				dtos.setOidPais(pais);
				dtos.setOidIdioma(idioma);
			}
			
			//Relleno los parametros de entrada para llamar al conectorObjeto
			paramConector.add(dtos);
			paramConector.add(new MareBusinessID("INTCargaInicialInterfaz"));
			
			traza(" Antes de conectar ConectorObjeto CargaInicialInterfaz ");
			DruidaConector conector = conectar("ConectorObjeto", paramConector);
			dtoSalida = (DTOCargaInicialInterfaz)conector.objeto("DTOSalida");
			traza ("DTOSALIDA: "+ dtoSalida);
			
			//Con el DTOCargaInicialInterfaz obtenido cargamos los campos lblNumeroLote y Descripcion con los atributos numeroLote y descripcionInterfaz
			traza("***** Antes de rellenar campos de la carga inicial ");
			traza("DTOSALIDA.getNumeroLote: "+ dtoSalida.getNumeroLote());
			traza("DTOSALIDA.getDescripcion: "+dtoSalida.getDescripcion());
			
			asignarAtributo("CTEXTO","Descripcion","valor",dtoSalida.getDescripcion());
			asignar("LABELC","lbldtLote",dtoSalida.getNumeroLote().toString());
			asignar("VAR","numeroLote",dtoSalida.getNumeroLote().toString());
			asignar("VAR","descripcionLote",dtoSalida.getDescripcion());
/*
			asignarAtributo("CTEXTO","Descripcion","valor","Interfaz ECOM");
			asignar("LABELC","lbldtLote","32161264326");
			asignar("VAR","numeroLote","32161264326");
*/
			
		}

		
		traza("*** Salida - LPECM - accionVacia ***");
	}
	
	private void accionGuardar() throws Exception{
		traza("*** Entrada - LPECM - accionGuardar ***");
		traza(" Opcion: "+ this.opcion);
		pagina("salidaGenerica");
		asignar("VAR", "cerrarVentana", "false");
		asignarAtributo("VAR", "ejecutar", "valor", "ejecucionCorrecta()");
		
		/*
		-> Crear un DTOINT que rellenamos con los campos recogidos de la pantalla (además del pais y el idioma) 
		-> Si opcion = "ventas" { 
		- Llamar al ConectorRecibirVentasAsociadas con el dto creado y el idBusiness "ECMRecibirVentasAsociadas" } 
		-> Si opcion = "clientes" { 
		- Llamar al ConectorRecibirClientesBatch con el dto creado y el idBusiness "ECMRecibirClientes" } 
		-> Si opcion = "enviar clientes" { 
		- Llamar al ConectorEnviarClientesConsultorasBatch con el dto creado y el idBusiness "ECMEnviarClientesConsultorasBatch" } */
		
		DTOINT dto = new DTOINT();
		Vector paramConector = new Vector();
		
		Long numeroLote = new Long(conectorParametroLimpia("numeroLote","",true));
		String descripcion = conectorParametroLimpia("Descripcion","",true);
		String observaciones = conectorParametroLimpia("areatxtObservaciones","",true);
		traza("Pasa recuperacion datos");

		if (this.pais!=null){
			dto.setOidPais(this.pais);
		}

		if (this.idioma!=null){
			dto.setOidIdioma(this.idioma);
		}
		
		traza("Antes de comprobar numeroLote");
		if ((numeroLote != null) && !(numeroLote.equals(""))){
			dto.setNumeroLote(numeroLote);
		}

		traza("Antes de comprobar descripcion");
		if ((descripcion != null) && !(descripcion.equals(""))){
			dto.setDescripcionLote(descripcion);
		}

		traza("Antes de comprobar observaciones");
		if ((observaciones != null) && !(observaciones.equals(""))){
			dto.setObservaciones(observaciones);
		}
		
		traza ("DTO: "+dto);
		paramConector.add(dto);
		
		if (this.opcion.equals("ventas")){
			paramConector.add(new MareBusinessID("ECMRecibirVentasAsociadas"));
			traza(" ANTES CONECTOR AL ENVIAR ConectorRecibirVentasAsociadas ");
			DruidaConector conector = conectar("ConectorRecibirVentasAsociadas", paramConector);
		}
		
		if (this.opcion.equals("clientes")){
			//Modificado por incidencia 15221
			paramConector.add(new MareBusinessID("ECMRecibirClientesBatch"));
			traza(" ANTES CONECTOR AL ENVIAR ConectorRecibirClientesBatch ");
			DruidaConector conector = conectar("ConectorRecibirClientesBatch", paramConector);
			
		}

		if (this.opcion.equals("enviar clientes")){
			paramConector.add(new MareBusinessID("ECMEnviarClientesConsultorasBatch"));
			traza(" ANTES CONECTOR AL ENVIAR ConectorEnviarClientesConsultoraBatch  ");
			DruidaConector conector = conectar("ConectorEnviarClientesConsultoraBatch", paramConector);
		}				

		traza("*** Salida - LPECM - accionGuardar ***");
	}
	
	private void cargarMenuSecundario() throws Exception{
		traza("*** Entrada - LPECM - cargarMenuSecundario ***");
		traza(" Opcion: "+this.opcion);
		if (this.opcion.equals("ventas")){
			asignarAtributo("PAGINA","contenido_ventas_asociadas_consultoras_recibir", "cod", "0902");
			asignarAtributo("PAGINA","contenido_ventas_asociadas_consultoras_recibir", "msgle", "Recibir ventas asociadas a consultoras");
			getConfiguracionMenu("LPECM","ventas");
		}
		if (this.opcion.equals("clientes")){
			asignarAtributo("PAGINA","contenido_ventas_asociadas_consultoras_recibir", "cod", "0288");
			asignarAtributo("PAGINA","contenido_ventas_asociadas_consultoras_recibir", "msgle", "Recepción de clientes");
			getConfiguracionMenu("LPECM","clientes");
		}
		if (this.opcion.equals("enviar clientes")){
			asignarAtributo("PAGINA","contenido_ventas_asociadas_consultoras_recibir", "cod", "0903");
			asignarAtributo("PAGINA","contenido_ventas_asociadas_consultoras_recibir", "msgle", "Enviar Clientes Consultoras");
			getConfiguracionMenu("LPECM","enviar");
		}		
		traza("*** Salida - LPECM - cargarMenuSecundario ***");
	}
}