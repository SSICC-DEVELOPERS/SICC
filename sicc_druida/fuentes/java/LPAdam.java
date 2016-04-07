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

import java.util.Date;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import es.indra.druida.DruidaConector;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOString;
import es.indra.sicc.util.DTODate;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesFecha;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.dtos.intsys.DTOCargaInicialInterfaz;
import es.indra.sicc.dtos.intsys.DTOINT;
import es.indra.sicc.dtos.intsys.DTOEstatus;
import es.indra.sicc.dtos.intsys.DTOIndError;
import es.indra.sicc.logicanegocio.intsys.ConstantesINT;
import es.indra.sicc.cmn.negocio.interfaces.IGestorInterfaces;
import es.indra.sicc.dtos.intsys.DTOEnviarComInc;
import es.indra.sicc.dtos.intsys.DTOCargaAdam;
import es.indra.sicc.dtos.intsys.DTODescPers;
import es.indra.sicc.dtos.intsys.DTOMostrarDeuda;
import es.indra.sicc.dtos.intsys.DTOGenerarFichero;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;

public class LPAdam extends LPSICCBase {

	private String accion = "";
	private String casoUso = null;
	private Long idioma=null;
	private Long pais= null;

	
	public LPAdam() {
		super();
	}
	
	public void inicio() throws Exception {				

	}
	
	public void ejecucion() throws Exception {
		setTrazaFichero();
		rastreo();
		traza("*** Entrada - LPAdam - ejecucion ***");
		try{
			accion = conectorParametroLimpia("accion","",true);
			idioma = UtilidadesSession.getIdioma(this);
			pais = UtilidadesSession.getPais(this);

			if(accion.equals("enviar_com_inc")){
				accionEnviarComInc();
			}else if(accion.equals("enviar")){
				accionEnviar();
			}else if(accion.equals("enviar_descuentos")){
				accionEnviarDescuentos();
			}else if(accion.equals("recuperar_descuentos")){
				accionRecuperarDescuentos();
			}else if(accion.equals("mantenimiento_descuentos")){
				accionMantenimientoDescuentos();
			}else if(accion.equals("generar_fichero")){
				accionGenerarFichero();	
			}else if(accion.equals("generar_descuentos_deuda")){
				accionGenerarDescuentosDeuda();
			}else if(accion.equals("guardar")){
				accionGuardar();
			}else if(accion.equals("anular")){
				accionAnular();
			}else if(accion.equals("comprobar_batch")){
				accionComprobarBatch();
			}else if(accion.equals("recuperar_lote")){
				accionRecuperarLote();
			}
		}catch ( Exception e )  {
			logStackTrace(e);
			lanzarPaginaError(e);
		}
		traza("*** Salida  - LPAdam - ejecucion ***");

	}
	private void accionEnviarComInc() throws Exception{
		traza("*** Entrada - LPAdam - accionEnviarComInc ***");		
		/*
		Menu Secundario:	
			LPAdam/enviarComInc = 0252,0,0,1,0,1,1,1,1,1,1
		
		*/		
		pagina("contenido_comisiones_incentivos_enviar");
		
		cargarCombo(); 
		DTOString dtos = new DTOString();
		
		
		dtos.setOidIdioma(idioma);
		dtos.setOidPais(pais);
		dtos.setCadena(IGestorInterfaces.COD_INTERFAZ_ADA1);
		
		
		MareBusinessID mid = new MareBusinessID("INTCargaInicialInterfaz");
		Vector vec = new Vector();
		vec.add(dtos);
		vec.add(mid);
		
		DruidaConector dc = conectar("ConectorObjeto", vec);
		DTOCargaInicialInterfaz dtoCarga = (DTOCargaInicialInterfaz)dc.objeto("DTOSalida");
		
		String numeroDeLote=dtoCarga.getNumeroLote().toString();
		String descripcion=dtoCarga.getDescripcion();
	    //Este llamado no tiene sentido, esta query nunca encuentra nada
		//mdolce 14-10-2005
	//	Date fechaDesde=obtenerFechaDesde(numeroDeLote).getFecha();		
		//String fechaDesdeString=dateToString(fechaDesde);
		asignar("CTEXTO","Descripcion",descripcion);           		
		asignar("LABELC","lblvalorLote",numeroDeLote);
		asignar("VAR","numeroLote",numeroDeLote); 
	//	asignar("CTEXTO","FechaDesde",fechaDesdeString); 		
	//	asignar("VAR","fechaInterfaz",fechaDesdeString); 
		asignar("VAR", "idioma", idioma.toString());
		asignar("VAR", "pais", pais.toString());
		asignar("VAR", "accion", accion);			
		this.generarHiddenFormatoFecha();
		asignarAtributo("PAGINA","contenido_comisiones_incentivos_enviar", "cod", "0252");
         	asignarAtributo("PAGINA","contenido_comisiones_incentivos_enviar", "msgle", "Ingresar Comisiones e Incentivos");		
              	getConfiguracionMenu("LPAdam","enviarComInc");
              	
		traza("*** Salida  - LPAdam - accionEnviarComInc ***");
		
	}
	private void accionEnviar() throws Exception{
		traza("*** Entrada - LPAdam - accionEnviar ***");

		
		String comisiones=conectorParametroLimpia("ckComisiones","",true);
		String incentivos=conectorParametroLimpia("ckIncentivos","",true);
		String tiposUsuario=conectorParametroLimpia("cbTipoCliente","",true);		
		StringTokenizer tiposUsuarioToken=new StringTokenizer(tiposUsuario,"|");
		String numeroLote=conectorParametroLimpia("numeroLote","",true);
		String descripcionLote=conectorParametroLimpia("Descripcion","",true);
		Date fechaDesde=UtilidadesBelcorp.getDatefromSICCStringFormat(conectorParametroLimpia("FechaDesde","",true), UtilidadesSession.getFormatoFecha(this));		
		Date fechaHasta=UtilidadesBelcorp.getDatefromSICCStringFormat(conectorParametroLimpia("FechaHasta","",true), UtilidadesSession.getFormatoFecha(this));		
		String observaciones=conectorParametroLimpia("areatxtObservaciones","",true);
		Long arrayTiposClientes[]=new Long[tiposUsuarioToken.countTokens()];
		
		traza("************Parametros Recibidos************");
		traza("comisiones: "+comisiones);
		traza("incentivos: "+incentivos);
		traza("tiposUsuario: "+tiposUsuario);
		traza("numeroLote: "+numeroLote);
		traza("descripcionLote: "+descripcionLote);
		traza("fechaDesde: "+fechaDesde);
		traza("fechaHasta: "+fechaHasta);
		traza("observaciones: "+observaciones);
		traza("********************************************");

		for (int i=0; i<arrayTiposClientes.length;i++){
			arrayTiposClientes[i]=new Long(tiposUsuarioToken.nextToken());
		} 


		DTOEnviarComInc dtoEnvComInv=new DTOEnviarComInc();
		dtoEnvComInv.setNumeroLote(numeroLote);
		dtoEnvComInv.setDescripcionLote(descripcionLote);
		dtoEnvComInv.setFechaDesde(fechaDesde);
		dtoEnvComInv.setFechaHasta(fechaHasta);
		dtoEnvComInv.setObservaciones(observaciones);
		dtoEnvComInv.setArrayTiposClientes(arrayTiposClientes);		
		dtoEnvComInv.setOidPais(pais);
		dtoEnvComInv.setOidIdioma(idioma);
		
		if(comisiones.equals("S")){
			traza("Se envia Comision");	
			MareBusinessID intEnviarComisionesBatch=new MareBusinessID("INTEnviarComisionesBatch");
			Vector paramEntrada = new Vector();
			paramEntrada.add(dtoEnvComInv);
			paramEntrada.add(intEnviarComisionesBatch);
			conectar("ConectorEnviarComIncBatch", paramEntrada);
			traza("Se Conecta a ConectorEnviarComIncBacth, Comision");		
		}
		if(incentivos.equals("S")){
			traza("Se envia Incentivo");	
			MareBusinessID intEnviarIncentivosBatch=new MareBusinessID("INTEnviarIncentivosBatch");
			Vector paramEntrada = new Vector();
			paramEntrada.add(dtoEnvComInv);
			paramEntrada.add(intEnviarIncentivosBatch);	
			conectar("ConectorEnviarComIncBatch", paramEntrada);						
			traza("Se Conecta a ConectorEnviarComIncBatch, Incentivo");
		}		
		pagina("salidaGenerica");
		asignarAtributo("VAR", "ejecutar", "valor", "cerrarVentana()");
		traza("*** Salida - LPAdam - accionEnviar ***");
	}
	
	private void accionEnviarDescuentos() throws Exception{
		traza("*** Entrada - LPAdam - accionEnviarDescuentos ***");
		
		pagina("contenido_descuentos_personal_enviar");
		cargarPantalla();				
		asignar("VAR", "idioma", idioma.toString());
		asignar("VAR", "pais", pais.toString());
		asignar("VAR", "accion", accion);			
		this.generarHiddenFormatoFecha();
		asignarAtributo("PAGINA","contenido_descuentos_personal_enviar", "cod", "0891");
         	asignarAtributo("PAGINA","contenido_descuentos_personal_enviar", "msgle", "Enviar descuentos a personal");		
              	
		
		getConfiguracionMenu("LPAdam","enviarDescuentos");			
		
		traza("*** Salida - LPAdam - accionEnviarDescuentos ***");
	}
	
	private void accionRecuperarDescuentos() throws Exception{
		traza("*** Entrada - LPAdam - accionRecuperarDescuentos ***");
		pagina("contenido_descuentos_personal_recuperar");
		this.generarHiddenFormatoFecha();
		asignarAtributo("PAGINA","contenido_descuentos_personal_recuperar", "cod", "0892");
         	asignarAtributo("PAGINA","contenido_descuentos_personal_recuperar", "msgle", "Recuperar descuentos a personal");		
              	
		
		getConfiguracionMenu("LPAdam","recuperarDescuentos");		
		asignar("VAR", "idioma", idioma.toString());
		asignar("VAR", "pais", pais.toString());
		asignar("VAR", "accion", accion);							
		cargarBusqueda();
		traza("*** Salida - LPAdam - accionRecuperarDescuentos ***");
	}	
	
	private void accionMantenimientoDescuentos() throws Exception{
		traza("*** Entrada - LPAdam - accionMantenimientoDescuentos ***");
		
		String tiposUsuario=conectorParametroLimpia("listaOidTiposCliente","",true);
		String subTiposUsuario=conectorParametroLimpia("listaOidSubTiposCliente","",true);
		StringTokenizer tiposUsuarioToken=new StringTokenizer(tiposUsuario,"|");
		StringTokenizer subTiposUsuarioToken=new StringTokenizer(subTiposUsuario,"|");
		int longitud=tiposUsuarioToken.countTokens();		
		ArrayList arrayTiposSubtipos=new ArrayList();
		
		for (int i=0; i<longitud;i++){
			Vector vectorDatos=new Vector();
			vectorDatos.add(new Long(tiposUsuarioToken.nextToken()));
			vectorDatos.add(new Long(subTiposUsuarioToken.nextToken()));
			arrayTiposSubtipos.add(vectorDatos);			
		}		
		
		String descripcionLote=conectorParametroLimpia("txtDescripcion","",true);
		Date fechaDesde=UtilidadesBelcorp.getDatefromSICCStringFormat(conectorParametroLimpia("FechaVencimientoDesde","",true), UtilidadesSession.getFormatoFecha(this));		
		Date fechaHasta=UtilidadesBelcorp.getDatefromSICCStringFormat(conectorParametroLimpia("FechaVencimientoHasta","",true), UtilidadesSession.getFormatoFecha(this));		
		String observaciones=conectorParametroLimpia("areatxtObservaciones","",true);
		Long marca=new Long(conectorParametroLimpia("cbMarca","",true));
		Long canal=new Long(conectorParametroLimpia("cbCanal","",true));
		Long acceso=new Long(conectorParametroLimpia("cbAcceso","",true));
		String descMarca =conectorParametroLimpia("descMarca","",true);
		String descCanal =conectorParametroLimpia("descCanal","",true);
		String descAcceso=conectorParametroLimpia("descAcceso","",true);
		
		traza("************Parametros Recibidos LPAdam.accionMantenimientoDescuentos ************");
		traza("marca: "+marca);
		traza("canal: "+canal);
		traza("acceso: "+acceso);
		traza("descMarca: "+descMarca);
		traza("descCanal: "+descCanal);
		traza("descAcceso: "+descAcceso);		
		traza("tiposUsuario: "+tiposUsuario);
		traza("subTiposUsuario: "+subTiposUsuario);				
		traza("descripcionLote: "+descripcionLote);		
		traza("fechaDesde: "+fechaDesde);
		traza("fechaHasta: "+fechaHasta);
		traza("observaciones: "+observaciones);	
		traza("**********************************************************************************");				
		
		pagina("contenido_descuentos_personal_enviar_detalle");
		DTODescPers dtoDescPersonas=new DTODescPers();
		dtoDescPersonas.setFechaVencimientoDesde(fechaDesde);
		dtoDescPersonas.setFechaVencimientoHasta(fechaHasta);
		dtoDescPersonas.setListaTS(arrayTiposSubtipos);
		dtoDescPersonas.setOidPais(pais);
		dtoDescPersonas.setOidIdioma(idioma);
		MareBusinessID intObtenerDatosAdam=new MareBusinessID("INTObtenerDatosAdam");
		Vector paramEntrada = new Vector();
		paramEntrada.add(dtoDescPersonas);
		paramEntrada.add(intObtenerDatosAdam);	
		
		traza("Llamada al conector ConectorObtenerDatosAdam");
		DruidaConector conCarga = conectar("ConectorObtenerDatosAdam", paramEntrada);
		traza("Vuelta del conector ConectorObtenerDatosAdam");
		
		DTOMostrarDeuda dtoMostrarDeuda =(DTOMostrarDeuda) conCarga.objeto("DTOMostrarDeuda");		
		
		traza("dtoMostrarDeuda: "+dtoMostrarDeuda);
		
		asignar("VAR", "hMarca", marca.toString());
		asignar("VAR", "hCanal", canal.toString());
		asignar("VAR", "hAcceso", acceso.toString());		
		asignar("VAR", "idioma", idioma.toString());
		asignar("VAR", "pais", pais.toString());		
		asignar("VAR", "accion", accion);		
		
		asignar("LABELC", "lbldtMarca", descMarca);
		asignar("LABELC", "lbldtCanal", descCanal);
		asignar("LABELC", "lbldtAcceso", descAcceso);
		
		asignar("LABELC", "lbldtDescripcion", descripcionLote);	
		asignar("VAR", "hDescripcion", descripcionLote);	
		asignar("AREATEXTO", "areatxtObservaciones", observaciones);
		
		asignar("LABELC", "lbldtFechaVencimientoDesde", conectorParametroLimpia("FechaVencimientoDesde","",true));		
		asignar("VAR", "hFechaVencimientoDesde", conectorParametroLimpia("FechaVencimientoDesde","",true));
		asignar("LABELC", "lbldtFechaVencimientoHasta", conectorParametroLimpia("FechaVencimientoHasta","",true));				
		asignar("VAR", "hFechaVencimientoHasta", conectorParametroLimpia("FechaVencimientoHasta","",true));
		asignar("VAR", "hNumeroLote", "");
		
		String numDocumento=dtoMostrarDeuda.getNumDocumento();
		Date fechaCreacion=dtoMostrarDeuda.getFechaCreacion();
		Long oidEstatus=dtoMostrarDeuda.getOidEstatus();
		String estatus=dtoMostrarDeuda.getEstatus();
		asignar("LABELC", "lbldtNumeroDocumento",numDocumento);
		asignar("VAR", "hNumeroDocumento", numDocumento);
		asignar("LABELC", "lbldtFechaCreacion",dateToString(fechaCreacion));
		asignar("VAR", "hFechaCreacion", dateToString(fechaCreacion));
		if(estatus!=null){
			asignar("VAR", "hEstatus", estatus);		
			asignar("LABELC","lbldtEstatus",estatus);
		}
		if(oidEstatus!=null){
			asignar("VAR","hOidEstatus", oidEstatus.toString());
		}
		
		DruidaConector conectorCargaLista = UtilidadesBelcorp.generarConector( "DTOSalida.combo_ROWSET",  dtoMostrarDeuda.getDetalle(), dtoMostrarDeuda.getDetalle().getColumnIdentifiers());
		asignar("LISTAEDITABLE", "datosDeDetalle", conectorCargaLista, "DTOSalida.combo_ROWSET");			
		asignar("VAR","ConstantesINT_ESTADO_PENDIENTE", ConstantesINT.ESTADO_PENDIENTE.toString());
		asignar("VAR","ConstantesINT_ESTADO_ENVIADO", ConstantesINT.ESTADO_ENVIADO.toString());
						
		String separadorDecimales = UtilidadesSession.getSeparadorDecimales(this);
		String separadorMiles = ",";
		if (separadorDecimales.equals(",")) {
			separadorMiles = ".";
		}
		asignar("VAR","hid_SeparadorMiles", separadorMiles);
		asignar("VAR","hid_NumeroDecimales",UtilidadesSession.getFormatoNumerico(this));
		asignar("VAR","hid_SeparadorDecimales", separadorDecimales);		
		
		this.generarHiddenFormatoFecha();
		//asignarAtributo("PAGINA","contenido_descuentos_personal_recuperar", "cod", "0892");
         	//asignarAtributo("PAGINA","contenido_descuentos_personal_recuperar", "msgle", "Recuperar descuentos a personal");		
              	getConfiguracionMenu("LPAdam","enviarDetalle");	
		
		traza("*** Salida - LPAdam - accionMantenimientoDescuentos ***");	
	}
	
	private void accionGenerarFichero() throws Exception{
	
		traza("*** Entrada - LPAdam - accionGenerarFichero ***");	
		pagina("contenido_generando_interfaz");
		DTOGenerarFichero dtoGenerarFichero=null;
		dtoGenerarFichero=crearDTO();
		MareBusinessID intGenerarFicheroAdam=new MareBusinessID("INTGenerarFicheroAdam");
		Vector paramEntrada = new Vector();
		paramEntrada.add(dtoGenerarFichero);
		paramEntrada.add(intGenerarFicheroAdam);	
		
		DruidaConector conectorGenerarFicheroAdam=conectar("ConectorGenerarFicheroAdam", paramEntrada);				
		DTOString dtoString =(DTOString) conectorGenerarFicheroAdam.objeto("DTOString");
		asignar("LABELC", "lbldtLote", dtoString.getCadena());
		asignar("VAR", "hNumeroLote", dtoString.getCadena());
					
		traza("*** Salida  - LPAdam - accionGenerarFichero ***");		
		
	}
	private void accionGenerarDescuentosDeuda() throws Exception{
	
		traza("*** Entrada - LPAdam - accionGenerarDescuentosDeuda ***");			
		
		pagina("salidaGenerica");
		DTOGenerarFichero dtoGenerarFichero=crearDTO();		
		dtoGenerarFichero.setOidEstatus(ConstantesINT.ESTADO_CONFIRMADO);
		MareBusinessID intGenerarDescuentosDeuda=new MareBusinessID("INTGenerarDescuentosDeuda");
		Vector paramEntrada = new Vector();
		paramEntrada.add(dtoGenerarFichero);
		paramEntrada.add(intGenerarDescuentosDeuda);	
		DruidaConector conCarga = conectar("ConectorGenerarDescuentosDeuda", paramEntrada);
		DTOEstatus dtoEstatus =(DTOEstatus) conCarga.objeto("DTOEstatus");		
		asignarAtributo("VAR", "ejecutar", "valor", "vueltaAnular("+dtoEstatus.getCadena()+")");
					
		traza("*** Salida  - LPAdam - accionGenerarDescuentosDeuda ***");	
		
	}
	private void accionGuardar() throws Exception{
	
		traza("*** Entrada - LPAdam - accionGuardar ***");
		
		pagina("salidaGenerica");	
		DTOGenerarFichero dtoGenerarFichero=crearDTO();
		MareBusinessID intGuardarDescuento=new MareBusinessID("INTGuardarDescuento");
		Vector paramEntrada = new Vector();
		paramEntrada.add(dtoGenerarFichero);
		paramEntrada.add(intGuardarDescuento);			
		conectar("ConectorGuardarDescuento", paramEntrada);					
		asignarAtributo("VAR", "ejecutar", "valor", "vacia()");		
	
		traza("*** Salida  - LPAdam - accionGuardar ***");	
		
	}
	private void accionAnular() throws Exception{
		traza("*** Entrada - LPAdam - accionAnular ***");
		pagina("salidaGenerica");
		
		DTOGenerarFichero dtoGenerarFichero=crearDTO();
		dtoGenerarFichero.setOidEstatus(ConstantesINT.ESTADO_ANULADO);
		MareBusinessID intGuardarDescuento=new MareBusinessID("INTGuardarDescuento");
		Vector paramEntrada = new Vector();
		paramEntrada.add(dtoGenerarFichero);
		paramEntrada.add(intGuardarDescuento);	
		DruidaConector conCarga = conectar("ConectorGuardarDescuento", paramEntrada);
				
		DTOEstatus dtoEstatus =(DTOEstatus) conCarga.objeto("DTOEstatus");	
		asignarAtributo("VAR", "ejecutar", "valor", "vueltaAnular('"+dtoEstatus.getCadena()+"')");	
									
		traza("*** Salida  - LPAdam - accionAnular ***");	
		
	}
	
	private void accionComprobarBatch() throws Exception{
		
		traza("*** Entrada - LPAdam - accionComprobarBatch ***");	
		
		DTOINT dtoINT = new DTOINT();				
		dtoINT.setNumeroLote(new Long(conectorParametroLimpia("hNumeroLote","",true)));		
		// Corregido por HRCS - Fecha 26/03/2007 - Incidencia Sicc20070161
		dtoINT.setOidIdioma(idioma);
		dtoINT.setOidPais(pais);
		
		MareBusinessID intGenerarFicheroAdam=new MareBusinessID("INTComprobarBatch");
		Vector paramEntrada = new Vector();
		paramEntrada.add(dtoINT);
		paramEntrada.add(intGenerarFicheroAdam);	
		
		DruidaConector conectorCombroparBatch=conectar("ConectorComprobarBatch", paramEntrada);				
		//DTOIndError dtoIndError =(DTOIndError) conectorCombroparBatch.objeto("DTOIndError");		
		Object objeto=conectorCombroparBatch.objeto("DTOIndError");
		DTOIndError dtoIndError =null;
		Boolean correcto=null;
		if(objeto instanceof DTOIndError){	
			dtoIndError =(DTOIndError)objeto;
			int indicadorError=dtoIndError.getIndLog().intValue();
			if(indicadorError==0){
				correcto=Boolean.TRUE;
			}else if(indicadorError==1){
				correcto=Boolean.FALSE;
			}		
		}
		traza("Objeto recuperado: "+objeto);
		
		traza("correcto: "+correcto);
		pagina("salidaGenerica");
		asignar("VAR", "cerrarVentana", "false");
		if(correcto==null){			
			asignarAtributo("VAR", "ejecutar", "valor", "vueltaIgual()");
		}else if(correcto.booleanValue()==true){
			asignarAtributo("VAR", "ejecutar", "valor","cerrarVentana('true','"+dtoIndError.getEstado()+"')");
		}else if(correcto.booleanValue()==false){
			asignarAtributo("VAR", "ejecutar", "valor","cerrarVentana('false','"+dtoIndError.getEstado()+"')");
		}

		traza("*** Salida  - LPAdam - accionComprobarBatch ***");		
		
	}

	private void accionRecuperarLote() throws Exception{ 
	
		traza("*** Entrada - LPAdam - accionRecuperarLote ***");
	
		pagina("contenido_descuentos_personal_enviar_detalle");

		DTOOID dtoOid=new DTOOID();
		dtoOid.setOidPais(this.pais);
		dtoOid.setOidIdioma(this.idioma);
		dtoOid.setOid(new Long (conectorParametroLimpia("hOidDescuentoPersonalCabecera","",true)));
		
		MareBusinessID intRecuperarLoteAdam=new MareBusinessID("INTRecuperarLoteAdam");
		
		Vector paramEntrada = new Vector();
		paramEntrada.add(dtoOid);
		paramEntrada.add(intRecuperarLoteAdam);	
		
		DruidaConector conectorRecuperarLoteAdam=conectar("ConectorRecuperarLoteAdam", paramEntrada);				
		DTOGenerarFichero dtoGenerarFichero =(DTOGenerarFichero) conectorRecuperarLoteAdam.objeto("DTOGenerarFichero");		
	
		asignar("VAR", "idioma", idioma.toString());
		asignar("VAR", "pais", pais.toString());		
		asignar("VAR", "accion", accion);		
		if(dtoGenerarFichero.getNumeroDocumento()!=null){		
			asignar("LABELC", "lbldtNumeroDocumento",dtoGenerarFichero.getNumeroDocumento());//String   
		}
		if(dtoGenerarFichero.getNumeroDocumento()!=null){		
			asignar("VAR", "hNumeroDocumento",dtoGenerarFichero.getNumeroDocumento());//String   
		}
		if(dtoGenerarFichero.getNumeroLote()!=null){		
			asignar("VAR", "hNumeroLote",dtoGenerarFichero.getNumeroLote());//String   
		}
		if(dtoGenerarFichero.getNumeroLote()!=null){		
			asignar("LABELC", "lbldtLote",dtoGenerarFichero.getNumeroLote());//String   
		}
		if(dtoGenerarFichero.getDescripcionLote()!=null){		
			asignar("LABELC", "lbldtDescripcion",dtoGenerarFichero.getDescripcionLote());//String   
		}	
		if(dtoGenerarFichero.getDescripcionLote()!=null){		
			asignar("VAR", "hDescripcion",dtoGenerarFichero.getDescripcionLote());//String   
		}
		if(dtoGenerarFichero.getFechaCreacion()!=null){		
			asignar("LABELC", "lbldtFechaCreacion",dateToString(dtoGenerarFichero.getFechaCreacion()));//Date   
		}
		if(dtoGenerarFichero.getFechaCreacion()!=null){		
			asignar("VAR", "hFechaCreacion",dateToString(dtoGenerarFichero.getFechaCreacion()));//Date   
		}
		if(dtoGenerarFichero.getFechaVencimientoDesde()!=null){		
			asignar("LABELC", "lbldtFechaVencimientoDesde",dateToString(dtoGenerarFichero.getFechaVencimientoDesde()));//Date   
		}
		if(dtoGenerarFichero.getFechaVencimientoDesde()!=null){		
			asignar("VAR", "hFechaVencimientoDesde",dateToString(dtoGenerarFichero.getFechaVencimientoDesde()));//Date   
		}
		if(dtoGenerarFichero.getFechaVencimientoHasta()!=null){		
			asignar("LABELC", "lbldtFechaVencimientoHasta",dateToString(dtoGenerarFichero.getFechaVencimientoHasta()));//Date   
		}
		if(dtoGenerarFichero.getFechaVencimientoHasta()!=null){		
			asignar("VAR", "hFechaVencimientoHasta",dateToString(dtoGenerarFichero.getFechaVencimientoHasta()));//Date   
		}
		
		if(dtoGenerarFichero.getOidEstatus()!=null){
			asignar("VAR","hOidEstatus", dtoGenerarFichero.getOidEstatus().toString());
		}						
		if(dtoGenerarFichero.getEstatus()!=null){
			asignar("VAR", "hEstatus", dtoGenerarFichero.getEstatus());		
			asignar("LABELC","lbldtEstatus",dtoGenerarFichero.getEstatus());
		}	
		if(dtoGenerarFichero.getObservaciones()!=null){				  
			asignar("AREATEXTO", "areatxtObservaciones",dtoGenerarFichero.getObservaciones());//String   						
		}
		if(dtoGenerarFichero.getOidCanal()!=null){
			asignar("VAR", "hCanal",dtoGenerarFichero.getOidCanal().toString());//Long   
		}
		if(dtoGenerarFichero.getOidMarca()!=null){
			asignar("VAR", "hMarca",dtoGenerarFichero.getOidMarca().toString());//Long   
		}
		if(dtoGenerarFichero.getOidAcceso()!=null){
			asignar("VAR", "hAcceso",dtoGenerarFichero.getOidAcceso().toString());//Long   
		}
										
		asignar("LABELC", "lbldtMarca", conectorParametroLimpia("descMarca","",true));
		asignar("LABELC", "lbldtCanal", conectorParametroLimpia("descCanal","",true));
		asignar("LABELC", "lbldtAcceso", conectorParametroLimpia("descAcceso","",true));
		
					
		DruidaConector conectorCargaLista = UtilidadesBelcorp.generarConector( "DTOSalida.combo_ROWSET",  dtoGenerarFichero.getLstDetalle(), dtoGenerarFichero.getLstDetalle().getColumnIdentifiers());
		asignar("LISTAEDITABLE", "datosDeDetalle", conectorCargaLista, "DTOSalida.combo_ROWSET");					

		asignar("VAR","ConstantesINT_ESTADO_PENDIENTE", ConstantesINT.ESTADO_PENDIENTE.toString());
		asignar("VAR","ConstantesINT_ESTADO_ENVIADO", ConstantesINT.ESTADO_ENVIADO.toString());
		asignar("VAR","ConstantesINT_ESTADO_ANULADO", ConstantesINT.ESTADO_ANULADO.toString());
		asignar("VAR","ConstantesINT_ESTADO_CONFIRMADO", ConstantesINT.ESTADO_CONFIRMADO.toString());
	 						
		String separadorDecimales = UtilidadesSession.getSeparadorDecimales(this);
		String separadorMiles = ",";
		if (separadorDecimales.equals(",")) {
			separadorMiles = ".";
		}
		asignar("VAR","hid_SeparadorMiles", separadorMiles);
		asignar("VAR","hid_NumeroDecimales",UtilidadesSession.getFormatoNumerico(this));
		asignar("VAR","hid_SeparadorDecimales", separadorDecimales);			
			
		this.generarHiddenFormatoFecha();
				
		getConfiguracionMenu("LPAdam","enviarDetalle");			
		
		traza("*** Entrada - LPAdam - accionRecuperarLote ***");
	}
		
	private void cargarCombo() throws Exception{
	
		traza("*** Entrada - LPAdam - cargarCombo ***");		

		DTOBelcorp dto = new DTOBelcorp();
		dto.setOidPais(this.pais);
		dto.setOidIdioma(this.idioma);
		
	
		ComposerViewElementList listelem = new ComposerViewElementList();
		ComposerViewElement elem =new ComposerViewElement(); 
				
		elem.setIDBusiness("MAEObtenerTipos");
		elem.setDTOE(dto);
		
		listelem.addViewElement(elem);
		
		ConectorComposerView conector = new ConectorComposerView(listelem, this.getRequest());
		conector.ejecucion();
		DruidaConector conConsultar = conector.getConector();		
		asignar("COMBO", "cbTipoCliente", conConsultar, "MAEObtenerTipos");
		
		traza("*** Salida  - LPAdam - cargarCombo ***");
		
	}	
	private DTODate obtenerFechaDesde(String numeroDeLote) throws Exception{
	
		traza("*** Entrada - LPAdam - obtenerFechaDesde ***");
		DTOINT dtoINT = new DTOINT();
				
		dtoINT.setNumeroLote(new Long(numeroDeLote));		
		//	Corregido por HRCS - Fecha 26/03/2007 - Incidencia Sicc20070161
		dtoINT.setOidIdioma(idioma);
		dtoINT.setOidPais(pais);
				
		MareBusinessID intObtenerFechaDesde=new MareBusinessID("INTObtenerFechaDesde");
		Vector paramEntrada = new Vector();
		paramEntrada.add(dtoINT);
		paramEntrada.add(intObtenerFechaDesde);	
		
		DruidaConector conCarga = conectar("ConectorObtenerFechaDesde", paramEntrada);
		
		DTODate dtoDate =(DTODate) conCarga.objeto("DTODate");
		
		traza("*** Salida  - LPAdam - obtenerFechaDesde ***");		
		return dtoDate;
										
	}
	
	private void cargarPantalla() throws Exception{
	
		traza("*** Entrada - LPAdam - cargarPantalla ***");
		
		DTOBelcorp dto = new DTOBelcorp();
		dto.setOidPais(this.pais);
		dto.setOidIdioma(this.idioma);	
		MareBusinessID intCargaAdam=new MareBusinessID("INTCargaAdam");
		Vector paramEntrada = new Vector();
		paramEntrada.add(dto);
		paramEntrada.add(intCargaAdam);				
		DruidaConector conCargaAdam = conectar("ConectorCargaAdam", paramEntrada);
		DTOCargaAdam dtoCargaAdam =(DTOCargaAdam)conCargaAdam.objeto("DTOCargaAdam");	
						
		DruidaConector conectorCargaCombo = UtilidadesBelcorp.generarConector( "DTOSalida.combo_ROWSET",  dtoCargaAdam.getCanales(), dtoCargaAdam.getCanales().getColumnIdentifiers());
		asignar("COMBO", "cbCanal", conectorCargaCombo, "DTOSalida.combo_ROWSET");			
		
		conectorCargaCombo = UtilidadesBelcorp.generarConector( "DTOSalida.combo_ROWSET",  dtoCargaAdam.getMarcas(), dtoCargaAdam.getMarcas().getColumnIdentifiers());
		asignar("COMBO", "cbMarca", conectorCargaCombo, "DTOSalida.combo_ROWSET");	
		
		conectorCargaCombo = UtilidadesBelcorp.generarConector( "DTOSalida.combo_ROWSET",  dtoCargaAdam.getTipoCliente(), dtoCargaAdam.getTipoCliente().getColumnIdentifiers());
		asignar("COMBO", "cbTipoCliente", conectorCargaCombo, "DTOSalida.combo_ROWSET");							
		
		asignar("VAR", "estadoP", dtoCargaAdam.getEstadoP().toString());
		if(dtoCargaAdam.getFechaDesde()!=null){
			String fechaDesdeString=this.dateToString(dtoCargaAdam.getFechaDesde());
			traza("Fecha : "+dtoCargaAdam.getFechaDesde());
			traza("Fecha String: "+fechaDesdeString);
			asignar("VAR", "fechaInterfaz", fechaDesdeString);		
			asignar("CTEXTO","FechaVencimientoDesde",fechaDesdeString); 
		}
		
		traza("*** Salida - LPAdam - cargarPantalla ***");
	
	}
	
	private DTOGenerarFichero crearDTO() throws Exception{
	
		traza("*** Entrada - LPAdam - crearDTO ***");
				
		String marca=conectorParametroLimpia("hMarca","",true);
		String canal=conectorParametroLimpia("hCanal","",true);
		String acceso=conectorParametroLimpia("hAcceso","",true);
		String oidEstatus=conectorParametroLimpia("hOidEstatus","",true);
		String estatus=conectorParametroLimpia("hEstatus","",true);
		String descripcion=conectorParametroLimpia("hDescripcion","",true);
		String fechaVencimientoDesde=conectorParametroLimpia("hFechaVencimientoDesde","",true);
		String fechaVencimientoHasta=conectorParametroLimpia("hFechaVencimientoHasta","",true);
		String numeroLote=conectorParametroLimpia("hNumeroLote","",true);
		String numeroDocumento=conectorParametroLimpia("hNumeroDocumento","",true);
		String fechaCreacion=conectorParametroLimpia("hFechaCreacion","",true);
		String observaciones=conectorParametroLimpia("areatxtObservaciones","",true);
				
		
		DTOGenerarFichero retorno= new DTOGenerarFichero();		
		retorno.setNumeroDocumento(numeroDocumento);//String   
		retorno.setNumeroLote(numeroLote);//String   
		retorno.setDescripcionLote(descripcion);//String   
		if(!fechaCreacion.equals("")){
			retorno.setFechaCreacion(toDate(fechaCreacion));//Date   
		}
		if(!fechaVencimientoDesde.equals("")){
			retorno.setFechaVencimientoDesde(toDate(fechaVencimientoDesde));//Date   
		}
		if(!fechaVencimientoHasta.equals("")){
			retorno.setFechaVencimientoHasta(toDate(fechaVencimientoHasta));//Date   
		}
		if(!oidEstatus.equals("")){
			retorno.setOidEstatus(new Long(oidEstatus));//Long   
		}
			
		retorno.setEstatus(estatus);//String   
		retorno.setObservaciones(observaciones);//String   
		  
		if(!canal.equals("")){
			retorno.setOidCanal(new Long(canal));//Long   
		}
		if(!marca.equals("")){
			retorno.setOidMarca(new Long(marca));//Long   
		}
		if(!acceso.equals("")){
			retorno.setOidAcceso(new Long(acceso));//Long 
		}
		
		RecordSet listaDetalles=new RecordSet();
		Vector identificadoresColumna=new Vector();
		identificadoresColumna.add("OIDCLIENTE");
		identificadoresColumna.add("OIDSUBTIPOCLIENTE");
		identificadoresColumna.add("IMPORTECALCULADO");
		identificadoresColumna.add("IMPORTEDESCONTAR");
		identificadoresColumna.add("IMPORTEENVIAR");
		
		identificadoresColumna.add("CODCLIENTE");
		identificadoresColumna.add("TIPOCLIENTE");
		identificadoresColumna.add("CODPLANILLA");
		
		listaDetalles.setColumnIdentifiers(identificadoresColumna);
		traza("listaOidClientes: "+conectorParametroLimpia("listaOidClientes",": ",true));
		traza("listaOidSubTipoClientes: "+conectorParametroLimpia("listaOidSubTipoClientes","",true));
		traza("listaImporteCalculados: "+conectorParametroLimpia("listaImporteCalculados","",true));
		traza("listaImportesDescontar: "+conectorParametroLimpia("listaImportesDescontar","",true));
		traza("listaImportesEnviar: "+conectorParametroLimpia("listaImportesEnviar","",true));
				
		traza("listaCodCliente: "+conectorParametroLimpia("listaCodCliente","",true));
		traza("listaTipoCliente: "+conectorParametroLimpia("listaTipoCliente","",true));
		traza("listaCodPlanilla: "+conectorParametroLimpia("listaCodPlanilla","",true));		
		StringTokenizer tokenOidClientes=new StringTokenizer(conectorParametroLimpia("listaOidClientes","",true),"|");
		StringTokenizer tokenOidSubTipoClientes=new StringTokenizer(conectorParametroLimpia("listaOidSubTipoClientes","",true),"|");
		StringTokenizer tokenImporteCalculados=new StringTokenizer(conectorParametroLimpia("listaImporteCalculados","",true),"|");
		StringTokenizer tokenImportesDescontar=new StringTokenizer(conectorParametroLimpia("listaImportesDescontar","",true),"|");
		StringTokenizer tokenImportesEnviar=new StringTokenizer(conectorParametroLimpia("listaImportesEnviar","",true),"|");
		
		StringTokenizer tokenCodCliente=new StringTokenizer(conectorParametroLimpia("listaCodCliente","",true),"|");
		StringTokenizer tokenTipoCliente=new StringTokenizer(conectorParametroLimpia("listaTipoCliente","",true),"|");
		StringTokenizer tokenCodPlanilla=new StringTokenizer(conectorParametroLimpia("listaCodPlanilla","",true),"|");		
		traza("tokenOidClientes: "+tokenOidClientes.countTokens());
		traza("tokenOidSubTipoClientes: "+tokenOidSubTipoClientes.countTokens());
		traza("tokenImporteCalculados: "+tokenImporteCalculados.countTokens());
		traza("tokenImportesDescontar: "+tokenImportesDescontar.countTokens());
		traza("tokenImportesEnviar: "+tokenImportesEnviar.countTokens());
		traza("tokenCodCliente: "+tokenCodCliente.countTokens());
		traza("tokenTipoCliente: "+tokenTipoCliente.countTokens());
		traza("tokenCodPlanilla: "+tokenCodPlanilla.countTokens());		
		while(tokenOidClientes.hasMoreTokens()){
			Vector datosFila=new Vector();
			
			String comprueba=tokenOidClientes.nextToken();
			if(!comprueba.equals("_")){
				datosFila.add(new Long(comprueba));  
			}else{
				datosFila.add(null);  
			}

			comprueba=tokenOidSubTipoClientes.nextToken();
			if(!comprueba.equals("_")){
				datosFila.add(new Long(comprueba));  
			}else{
				datosFila.add(null);  
			}
			
			comprueba=tokenImporteCalculados.nextToken();
			if(!comprueba.equals("_")){
				datosFila.add(new BigDecimal(comprueba));  
			}else{
				datosFila.add(null);  
			}
			
			comprueba=tokenImportesDescontar.nextToken();
			if(!comprueba.equals("_") || !comprueba.equals("undefined")){
				datosFila.add(new BigDecimal(comprueba));  
			}else{
				datosFila.add(null);  
			}
			
			comprueba=tokenImportesEnviar.nextToken();
			if(!comprueba.equals("_") || !comprueba.equals("undefined")){
				datosFila.add(new BigDecimal(comprueba));  
			}else{
				datosFila.add(null);  
			}		

			comprueba=tokenCodCliente.nextToken();
			if(!comprueba.equals("_")){
				datosFila.add(comprueba);  
			}else{
				datosFila.add(null);  
			}		
			
			comprueba=tokenTipoCliente.nextToken();
			if(!comprueba.equals("_")){
				datosFila.add(new Long(comprueba));  
			}else{
				datosFila.add(null);  
			}		
			
			comprueba=tokenCodPlanilla.nextToken();
			if(!comprueba.equals("_")){
				datosFila.add(comprueba);  
			}else{
				datosFila.add(null);  
			}
			traza("Dato fila n: "+datosFila);																																				
			listaDetalles.addRow(datosFila);
			
		}						
		retorno.setLstDetalle(listaDetalles);//RecordSet 
		retorno.setOidPais(pais);
		retorno.setOidIdioma(idioma);		
		traza("DTO Retorno: "+retorno);
		traza("*** Salida - LPAdam - crearDTO ***");
		return retorno;		
		
	}
	
	private void cargarBusqueda() throws Exception{
		
		traza("*** Entrada - LPAdam - cargarBusqueda ***");
		
		DTOBelcorp dto = new DTOBelcorp();
		dto.setOidPais(this.pais);
		dto.setOidIdioma(this.idioma);
				
		ComposerViewElementList listelem = new ComposerViewElementList();
		ComposerViewElement elem1 =new ComposerViewElement(); 
		ComposerViewElement elem2 =new ComposerViewElement(); 
		ComposerViewElement elem3 =new ComposerViewElement(); 
		
		elem1.setIDBusiness("SEGConsultaCanales");
		elem1.setDTOE(dto);
		elem1.setPosOID((byte)0);
		elem1.setPosDesc((byte)1);
		
		elem2.setIDBusiness("SEGConsultaMarcas");
		elem2.setDTOE(dto);
		elem2.setPosOID((byte)0);
		elem2.setPosDesc((byte)1);		
		
		elem3.setIDBusiness("INTRecuperarEstatus");
		elem3.setDTOE(dto);
		
		listelem.addViewElement(elem1);
		listelem.addViewElement(elem2);
		listelem.addViewElement(elem3);
		
		ConectorComposerView conector = new ConectorComposerView(listelem, this.getRequest());
		conector.ejecucion();
		DruidaConector conConsultar = conector.getConector();		
		asignar("COMBO", "cbCanal", conConsultar,"SEGConsultaCanales");
		asignar("COMBO", "cbMarca", conConsultar,"SEGConsultaMarcas");
		asignar("COMBO", "cbEstado", conConsultar,"INTRecuperarEstatus");
		
		traza("*** Salida - LPAdam - cargarBusqueda ***");
		
	}
	
	private Date toDate(String sFecha) throws Exception{
		
		String formatoUsuario = UtilidadesSession.getFormatoFecha(this);
		char frmFecha[] = formatoUsuario.toCharArray();
		for (int i=0; i < frmFecha.length; i++ ) {
			if ( frmFecha[i] == 'm' ){
				frmFecha[i] = 'M';
			}else if ( frmFecha[i] == 'a' || frmFecha[i] == 'A'){
				frmFecha[i] = 'y';
			}
		}
		
		String formatoFecha = new String(frmFecha);					
		SimpleDateFormat miFecha = new SimpleDateFormat(formatoFecha);
		java.util.Date fecha = miFecha.parse(sFecha);		
		return fecha;
		
	}
	
	private String dateToString(Date fecha) throws Exception{
		
		if(fecha==null){
			return "";
		}
		String formatoUsuario = UtilidadesSession.getFormatoFecha(this);
		char frmFecha[] = formatoUsuario.toCharArray();
		for (int i=0; i < frmFecha.length; i++ ) {
			if ( frmFecha[i] == 'm' ){
				frmFecha[i] = 'M';
			}else if ( frmFecha[i] == 'a' || frmFecha[i] == 'A'){
				frmFecha[i] = 'y';
			}
		}
		
		String formatoFecha = new String(frmFecha);					
		SimpleDateFormat miFecha = new SimpleDateFormat(formatoFecha);
		String sFecha = miFecha.format(fecha);		
		return sFecha;
		
	}
	
	private void logStackTrace(Throwable e) throws Exception {
		
		traza("Se produjo la excepcion: " + e.getMessage());
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		e.printStackTrace(ps);
		
		traza("Stack Trace: " + baos.toString());
		
	}
		
}
