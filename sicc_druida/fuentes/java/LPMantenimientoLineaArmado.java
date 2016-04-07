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

import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;

import java.util.Vector;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.HashMap;
import java.math.BigDecimal;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import es.indra.mare.common.mln.MareBusinessID;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.druida.DruidaConector;

import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.util.DTOBelcorp;


import es.indra.sicc.dtos.ape.DTOConfiguracionCentroDistribucion;
import es.indra.sicc.dtos.ape.DTOProgramaCubicaje;
import es.indra.sicc.dtos.ape.DTOTipoSolicitudLinea;
import es.indra.sicc.dtos.ape.DTOLineaArmado;
import es.indra.sicc.dtos.ape.DTOUsuarioAlarmaLineas;
import es.indra.sicc.dtos.ape.DTOInsertarLineaArmado;

import es.indra.sicc.logicanegocio.ape.ConstantesAPE;


public class LPMantenimientoLineaArmado extends LPSICCBase {
	
	private String accion = null;
	private String opcionMenu = null;
	private Long pais = null;
	private Long idioma = null;

	public LPMantenimientoLineaArmado() {
		super();
	}


	public void inicio() throws Exception {
		

	}
	public void ejecucion() throws Exception {
        rastreo();
        setTrazaFichero();

		try  {	
			traza("LPMantenimientoLineaArmado Entrada");

			this.accion = conectorParametroLimpia("accion", "", true);
			this.opcionMenu = conectorParametroLimpia("opcionMenu", "", true);
			this.idioma = UtilidadesSession.getIdioma(this);			
			this.pais = UtilidadesSession.getPais(this);

			traza("accion: " + this.accion);
			traza("opcionMenu: " + this.opcionMenu);
			traza("idioma: " + this.idioma);
			traza("pais: " + this.pais);
					
			if(this.accion.equals("")){
				this.cargarPantalla();
			}
			
			if(this.accion.equals("guardar")){//insertar
				this.guardar();
			}
			
			if(this.accion.equals("detalle")){//consultar o modificar
				this.mostrarDetalle();
			}

			if(this.accion.equals("modificarDetalle")){//consultar o modificar
				this.mostrarDetalle();
			}

			this.getFormatosValidaciones();

			traza("LPMantenimientoLineaArmado Salida");			
		}catch ( Exception e )  {
			traza("entro en catch LPMantenimientoLineaArmado");			
			e.printStackTrace();
			this.logStackTrace(e);
			lanzarPaginaError(e);
		}		
	}

	private void logStackTrace(Throwable e) throws Exception {
		traza("Se produjo la excepcion: " + e.getMessage());		
        preservaHiddensI18n(new Integer(1),"APP_CONFI_CENTR_DISTR","formulario","txtDescripcion", false);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		//e.printStackTrace(ps);		
		while (e != null) {
			e.printStackTrace(ps);
			e = e.getCause();
		}
		traza("Stack Trace: " + baos.toString());
	}	
	
	private	void cargarPantalla() throws Exception{
		traza("entro en LPMantenimientoLineaArmado.cargarPantalla");			

		if (this.opcionMenu.equals("insertar")) {
			pagina("contenido_linea_armado_insertar");

			getConfiguracionMenu("LPMantenimientoLineaArmado", "insertar");
			asignarAtributoPagina("cod", "ApeLineaArmado.create.label");
			asignar("VAR", "casoUso", "insertar");
			asignar("VAR", "hPais", this.pais.toString());
			asignar("VAR","hIdioma",this.idioma.toString());
			asignar("VAR","opcionMenu",this.opcionMenu);
			asignar("VAR","accion",this.accion);
			asignar("VAR", "hDeshabilitar", "false");


			anyadeHiddensI18N(false, "APE_LINEA_ARMAD", null, new Integer(1), "formulario", "txtDescripcion", false);	

			this.obtenerCodigoLinea();

			this.cargarCombos();

		} else {
			pagina("contenido_linea_armado_modificar");

			asignar("VAR", "hPais", this.pais.toString());
			asignar("VAR","hIdioma",this.idioma.toString());
			asignar("VAR","opcionMenu",this.opcionMenu);
			asignar("VAR","accion",this.accion);

			
			if (this.opcionMenu.equals("modificar")) {
				getConfiguracionMenu("LPMantenimientoLineaArmado", "modificarDetalle");
				asignarAtributoPagina("cod", "ApeLineaArmado.update.label");
				asignar("VAR", "casoUso", "modificar");

			} else if (this.opcionMenu.equals("consultar")) {
				getConfiguracionMenu("LPMantenimientoLineaArmado", "consultar");
				asignarAtributoPagina("cod", "ApeLineaArmado.query.label");
				asignar("VAR", "casoUso", "consultar");

			} else if (this.opcionMenu.equals("eliminar")) {
				getConfiguracionMenu("LPMantenimientoLineaArmado", "eliminar");
				asignarAtributoPagina("cod", "ApeLineaArmado.remove.label");
				asignar("VAR", "casoUso", "eliminar");
			}


			this.cargarCombosConsulta();

		}

		traza("salio en LPMantenimientoLineaArmado.cargarPantalla");			

	}

	private void guardar() throws Exception{
		traza("LPMantenimientoLineaArmado.guardar Entrada");
		int contador;

		pagina("salidaGenerica");

		anyadeHiddensI18N(false, "APE_LINEA_ARMAD", null, new Integer(1),"formulario", "txtDescripcion", false);
        Vector inter = recuperaTraduccionesI18N(new Integer(1));
		DTOInsertarLineaArmado dtoInsertar = new DTOInsertarLineaArmado();

		dtoInsertar.setAttrTraducible(inter);

		DTOProgramaCubicaje dtoPC = new DTOProgramaCubicaje();
		dtoPC.setOid(new Long(conectorParametroLimpia("cbProgramaCubicaje", "", true)));

		DTOConfiguracionCentroDistribucion dtoCD = new DTOConfiguracionCentroDistribucion();
		dtoCD.setOidCentroDistribucion(new Long(conectorParametroLimpia("cbCentroDistribucion", "", true)));
		dtoCD.setOidPais(UtilidadesSession.getPais(this));
		dtoCD.setOidIdioma(UtilidadesSession.getIdioma(this));

		String oidLinea = conectorParametroLimpia("hOidLinea", "", true);

		DTOLineaArmado dtoLA = new DTOLineaArmado();

		traza("oid Linea " + oidLinea);
		if((oidLinea != null) && (!oidLinea.equals(""))) {
			dtoLA.setOid(new Long(conectorParametroLimpia("hOidLinea", "", true)));
		}

		dtoLA.setCodigoLinea(new Long(conectorParametroLimpia("txtLineaArmado", "", true)));
		dtoLA.setDescripcion(conectorParametroLimpia("txtDescripcion", "", true));
		dtoLA.setLongitudNumeroEtiqueta(new Long(conectorParametroLimpia("txtLongitudNroEtiqueta", "", true)));
		dtoLA.setProgramaCubicaje(dtoPC);
		dtoLA.setCentroDistribucion(dtoCD);
		dtoLA.setOidPais(UtilidadesSession.getPais(this));
		dtoLA.setOidIdioma(UtilidadesSession.getPais(this));

		dtoLA.setValorDefecto(new Boolean(conectorParametroLimpia("chkLineaDefault", "", true).equals("S")));
		//dtoLA.setImprimirListaPicado(new Boolean(conectorParametroLimpia("chkImprimirListaPicaoNivelLinea", "", true).equals("S"))); //ciglesias incidencia 356
		dtoLA.setLineaAFP(new Boolean(conectorParametroLimpia("chkLineaAFP", "", true).equals("S")));

		if (dtoLA.getLineaAFP().booleanValue()){ //true 
			//dtoLA.setFormatoEtiqueta(conectorParametroLimpia("txtFormatoEtiquetasAFP", "", true));//ciglesias incidencia 364
			dtoLA.setNumeroEtiquetasAFP(new Long(conectorParametroLimpia("txtNumeroEtiquetasAFP", "", true)));
		}
		/**********************************************************************************/
		/**********************************************************************************/
		String hTipoSol = conectorParametroLimpia("hlstTipoSolicitudConsolidado", "", true);
		String oids[] = null;

		if((hTipoSol != null) && (!hTipoSol.equals(""))) {
			StringTokenizer st1 = new StringTokenizer( hTipoSol, "|||" );
			oids = new String[st1.countTokens()];
			int ind1 = 0;

			while( st1.hasMoreTokens() ){
				oids[ind1++] = st1.nextToken();
			}
		}

		String tipoSolicitud = conectorParametroLimpia("cbTiposSolicitudConsolidado", "", true);
		DTOTipoSolicitudLinea dtoTSL[] = null;

		StringTokenizer st = new StringTokenizer( tipoSolicitud, "|" );
		int cantElementos = cantElementosNuevos(tipoSolicitud, oids);

		if ( cantElementos > 0) {
			dtoTSL = new DTOTipoSolicitudLinea[cantElementos];

			int ind = 0;

			while( st.hasMoreTokens() ){

				String oid = st.nextToken();

				if (!pertenece(oids, oid)) {
					dtoTSL[ind] = new DTOTipoSolicitudLinea();
					dtoTSL[ind].setLineaArmado(dtoLA);
					dtoTSL[ind].setTipoSolicitudPais(new Long(oid));
					dtoTSL[ind].setOidPais(UtilidadesSession.getPais(this));
					ind++;
				} else {
					traza("no hay nuevos tipos solicitud");
				}
			}
		}
		
		Long oidsEliminarTSL[] = new Long[0];

		if (oids != null) {
			String tS = conectorParametroLimpia("cbTiposSolicitudConsolidado", "", true);
			StringTokenizer st2 = new StringTokenizer( tipoSolicitud, "|" );
			String oidsSeleccionados[] = new String[st2.countTokens()];
			
			String oidElem = null;

			int ind3 = 0;
			while( st2.hasMoreTokens() ){
				oidsSeleccionados[ind3++] = st2.nextToken();
			}

			for (int k = 0; k < oids.length; k++) {
				if (!pertenece(oidsSeleccionados, oids[k])) {
					if (oidElem == null) {
						oidElem = oids[k];
					} else {
						oidElem = oidElem +  "|||" + oids[k];
					}
				}
			}

			if (oidElem != null) {
				traza("oidElem " + oidElem);
				StringTokenizer st3 = new StringTokenizer( oidElem, "|||" );
				oidsEliminarTSL = new Long[st3.countTokens()];

				int ind4 = 0;
				while( st3.hasMoreTokens() ){
					oidsEliminarTSL[ind4++] = new Long(st3.nextToken());
				}

			}
		}

		/**********************************************************************************/
		/**********************************************************************************/

		String hListaUsuarios = conectorParametroLimpia("hListaUsuarios", "", true);
		RecordSet rListaUsuarios = null;
		DTOUsuarioAlarmaLineas dtoUA[] = null;

		if (hListaUsuarios != null) {
			rListaUsuarios = this.parseaLista(hListaUsuarios);

			if (rListaUsuarios != null) {
				dtoUA = new DTOUsuarioAlarmaLineas[rListaUsuarios.getRowCount()];

				for (int i = 0; i < rListaUsuarios.getRowCount(); i++) {
			
					dtoUA[i] = new DTOUsuarioAlarmaLineas();

					if (!((String)rListaUsuarios.getValueAt(i,0)).equals("g")) {
						dtoUA[i].setOid(new Long((String)rListaUsuarios.getValueAt(i,0)));
					}
					dtoUA[i].setEmail((String)rListaUsuarios.getValueAt(i,1));
					dtoUA[i].setLineaArmado(dtoLA);
					dtoUA[i].setOidPais(UtilidadesSession.getPais(this));
				}
			}
		}

		dtoInsertar.setDtoLineaArmado(dtoLA);
		dtoInsertar.setDtoTipoSolicitudLinea(dtoTSL);
		dtoInsertar.setDtoUsuarioAlarmaLineas(dtoUA);

		if (!opcionMenu.equals("insertar")) {
			dtoInsertar.setOidsSolicitudEliminados(oidsEliminarTSL);
			dtoInsertar.setOidsUsuariosEliminados(listadoEliminado("hEliminados"));
		}

		traza("DTO " + dtoInsertar);

		//asignar("VAR", "ejecutar", "bienGuardado();");
		asignar("VAR", "ejecutarError", "malGuardado();");

		Vector paramConector = new Vector();			
		paramConector.add(dtoInsertar);
		paramConector.add(new MareBusinessID("APEInsertarLineaArmado"));           
		DruidaConector conector = conectar("ConectorInsertarLineaArmado", paramConector);							
		preservaHiddensI18n(new Integer(1), "APE_LINEA_ARMAD", "formulario", "txtDescripcion", false);

		if (opcionMenu.equals("insertar")) {
            DTOOID dtoResult = (DTOOID)conector.objeto("DTOOID");
            //asignar("VAR", "htxtLineaArmado", dtoResult.getOid().toString());
            asignar("VAR", "ejecutar", "bienGuardado('" + dtoResult.getOid().toString() + "');");
        }

		traza("LPMantenimientoLineaArmado.guardar Salida");
	}

	private void mostrarDetalle() throws Exception {
		traza("LPMantenimientoLineaArmado.mostrarDetalle Entrada");

		pagina("contenido_linea_armado_insertar");
		this.cargarCombos();
		this.rellenarPantalla();
		traza("LPMantenimientoLineaArmado.mostrarDetalle Salida");
	}

	private void cargarCombos() throws Exception{
        traza("*** Entrada - LPMantenimientoLineaArmado - cargarCombos ***");

		DTOBelcorp dtoBelcorp = new DTOBelcorp();
		dtoBelcorp.setOidPais(this.pais);
		dtoBelcorp.setOidIdioma(this.idioma);
		String[] idBusiness = new String[] {"APEObtenerDescripcionesCD","APEObtenerProgramasCubicaje","PEDconsultaTiposConsolidado"};
		String[] comboBox = new String[] {"cbCentroDistribucion","cbProgramaCubicaje","cbTiposSolicitudConsolidado"};
		this.auxCargarCombos(dtoBelcorp, idBusiness, comboBox, null, null);
		this.obtenerCDPorDefecto();
		traza("*** Salida - LPMantenimientoLineaArmado - cargarCombos ***");
	}


	private void auxCargarCombos(DTOBelcorp dto, String[] idBusiness, String[] comboBox, String[] column, String[] selected) throws Exception {
        traza("*** Entrada - LPMantenimientoLineaArmado - auxCargarCombos ***");

		ComposerViewElementList list = new ComposerViewElementList();
		ComposerViewElement element = null;

		for (int i = 0; i < idBusiness.length; i++) { 
			element = new ComposerViewElement(); 
            element.setIDBusiness(idBusiness[i]);
            element.setDTOE(dto);
            list.addViewElement(element);
		}

		// Obtener un RowSet que contiene los datos solicitados por list.
		ConectorComposerView ccv = new ConectorComposerView(list, this.getRequest());
        ccv.ejecucion();
        DruidaConector dc = ccv.getConector();

		if (selected != null && column != null) {
			for (int i = 0; i < comboBox.length; i++) {
				if (selected[i] != null && column[i] != null) {
					asignar("COMBO", comboBox[i], dc, idBusiness[i], column[i], selected[i]);
				} else {
					asignar("COMBO", comboBox[i], dc, idBusiness[i]); 
				}
			}
		} else {
			for(int i = 0; i < comboBox.length; i++) {
				asignar("COMBO", comboBox[i], dc, idBusiness[i]); 
			}
		}

		traza("*** Salida - LPMantenimientoLineaArmado - auxCargarCombos ***");
	}

	private void cargarCombosConsulta() throws Exception {
		DTOBelcorp dtoBelcorp = new DTOBelcorp();
		dtoBelcorp.setOidPais(this.pais);
		dtoBelcorp.setOidIdioma(this.idioma);
		String[] idBusiness = new String[] {"APEObtenerDescripcionesCD"};//,"APEObtenerDescripcionesLineas"
		String[] comboBox = new String[] {"cbCentroDistribucion"};//,"cbDescripcion"

		this.auxCargarCombos(dtoBelcorp, idBusiness, comboBox, null, null);
	}

	private void obtenerCodigoLinea() throws Exception {
		DTOBelcorp dtoBelcorp = new DTOBelcorp();
		dtoBelcorp.setOidPais(this.pais);
		dtoBelcorp.setOidIdioma(this.idioma);

		Vector paramConector = new Vector();			
		paramConector.add(dtoBelcorp);
		paramConector.add(new MareBusinessID("APEObtenerProximoCodigoLinea"));           
		DruidaConector conector = conectar("ConectorObtenerProximoCodigoLinea", paramConector);							
		DTOOID dtoResult = (DTOOID)conector.objeto("DTOOID");
		asignar("VAR", "htxtLineaArmado", dtoResult.getOid().toString());
	}


	private void rellenarPantalla() throws Exception {
    
        
		String hOid = conectorParametroLimpia("oid", "", true);
		String hOidDescripcionesCD = conectorParametroLimpia("descripcionCD", "", true);
		String htxtLineaArmado = conectorParametroLimpia("codigo", "", true);
		String hDescripcion = conectorParametroLimpia("descripcion", "", true);
		//String hImprimir = conectorParametroLimpia("imprimir", "", true); //ciglesias incidencia 356
		String hLineaAFP = conectorParametroLimpia("lineaAFP", "", true);
		String hDefecto = conectorParametroLimpia("defecto", "", true);
		String hPrograma = conectorParametroLimpia("programa", "", true);
		String hLongitud = conectorParametroLimpia("longitud", "", true);
		//String hEtiquetas = conectorParametroLimpia("etiquetas", "", true);//ciglesias incidencia 364
		String hNumEtiquetas = conectorParametroLimpia("numEtiquetas", "", true);

		//pagina("contenido_linea_armado_insertar");

		traza("valores obtenidos " + hOid + " - " +hOidDescripcionesCD + " - " +htxtLineaArmado + " - " +hDescripcion + " - " + //hImprimir + " - " + //ciglesias incidencia 356
			hLineaAFP+ " - " + hDefecto+ " - " + hPrograma+ " - " + //hEtiquetas + " - " + //ciglesias incidencia 364
			hNumEtiquetas);

		asignar("VAR", "hOidLinea", hOid);
		asignar("VAR", "hOidDescripcionCD", hOidDescripcionesCD);
		asignar("VAR", "htxtLineaArmado", htxtLineaArmado);
		asignar("VAR", "hDescripcion", hDescripcion);
		//asignar("VAR", "hImprimir", hImprimir); //ciglesias incidencias 356
		asignar("VAR", "hLineaAFP", hLineaAFP);
		asignar("VAR", "hDefecto", hDefecto);
		asignar("VAR", "hPrograma", hPrograma);
		asignar("VAR", "hLongitud", hLongitud);
		//asignar("VAR", "hEtiquetas", hEtiquetas);//ciglesias incidencia 364
		asignar("VAR", "hNumEtiquetas", hNumEtiquetas);

		if(this.accion.equals("modificarDetalle")){
			anyadeHiddensI18N(true, "APE_LINEA_ARMAD", new Long(hOid), new Integer(1), "formulario", "txtDescripcion", false);	
			asignar("VAR", "hDeshabilitar", "false");
			getConfiguracionMenu("LPMantenimientoLineaArmado", "modificarDetalle");
			asignarAtributoPagina("cod", "ApeLineaArmado.update.label");
			asignar("VAR", "casoUso", "modificarDetalle");
		} else {
			anyadeHiddensI18N(true, "APE_LINEA_ARMAD", new Long(hOid), new Integer(1), "formulario", "txtDescripcion", true);	
			asignar("VAR", "hDeshabilitar", "true");
			getConfiguracionMenu("LPMantenimientoLineaArmado", "detalle");
			asignarAtributoPagina("cod", "ApeLineaArmado.view.label");
			asignar("VAR", "casoUso", "detalle");

		}

		DTOOID dtoOid = new DTOOID();
		dtoOid.setOid(new Long(hOid));

		this.cargarTiposSolicitud(dtoOid);
		this.cargarUsuariosAlarmaLinea(dtoOid);
        //this.cargarCombos();
	}

	private void cargarTiposSolicitud(DTOOID oidLinea) throws Exception {
        UtilidadesLog.debug("LPMantenimientoLineaArmado.cargarTiposSolicitud(): Entrada");
		Vector paramConector = new Vector();
		paramConector.add(oidLinea);           
		paramConector.add(new MareBusinessID("APEObtenerTiposSolicitudLinea")); 
		DruidaConector conector = conectar("ConectorObtenerTiposSolicitudLinea", paramConector);		
		
		DTOSalida dtoSalida = (DTOSalida)conector.objeto("DTOSalida");
		RecordSet record = dtoSalida.getResultado();

        if (record != null && !record.esVacio()) {
			String cadena = ((BigDecimal) record.getValueAt(0,1)).toString() ;

			for (int i = 1; i < record.getRowCount() ; i++) {
				cadena = cadena + "|||" + record.getValueAt(i,1);
			}
			asignar("VAR", "hlstTipoSolicitudConsolidado", cadena);
		}
        else{
            UtilidadesLog.debug("record vacio");
        }
        UtilidadesLog.debug("LPMantenimientoLineaArmado.cargarTiposSolicitud(): Salida");
	}

	private void cargarUsuariosAlarmaLinea(DTOOID oidLinea) throws Exception {
        UtilidadesLog.debug("LPMantenimientoLineaArmado.cargarUsuariosAlarmaLinea(): Entrada");
		Vector paramConector = new Vector();
		paramConector.add(oidLinea);           
		paramConector.add(new MareBusinessID("APEObtenerUsuariosAlarmaLinea")); 
		DruidaConector conector = conectar("ConectorObtenerUsuariosALarmaLinea", paramConector);

		DTOSalida dtoSalida = (DTOSalida)conector.objeto("DTOSalida");
		RecordSet record = dtoSalida.getResultado();
		if (!record.esVacio()) {
			String cadena = record.getValueAt(0,0) + "|,|" + record.getValueAt(0,1);

			for (int i = 1; i < record.getRowCount() ; i++) {
				cadena = cadena + "|||" +record.getValueAt(i,0) + "|,|" + record.getValueAt(i,1);
			}
			asignar("VAR", "hlstUsuariosAlarmaProd", cadena);
		}
        UtilidadesLog.debug("LPMantenimientoLineaArmado.cargarUsuariosAlarmaLinea(): Salida");
	}

	private boolean pertenece(String oids[], String oid) throws Exception{
		boolean esta = false;
		if (oids != null) {
			for( int i = 0; i < oids.length && !esta; i++ ){
				esta = oid.equals(oids[i]);
			}
		} else {
			return false;
		}
		return esta;
	}
   
	private RecordSet parseaLista(String sXml) throws Exception {
        traza("sxml: " + sXml);
        sXml = sXml.replaceAll("&", "&amp;");
        String sPropiedadActual = null;
        String sValorCampo = null;
        String sPropiedad = null;
        Node nodeDoc = null;        
        Node nodoRow = null;
        Node nodoCampo = null;
        NodeList nodeList = null;
        NodeList nodeListCampos = null;
        HashMap hshAtributos = new HashMap();
        DocumentBuilder docBuilder = null;
        RecordSet rRetorno = null;
        Vector vFila = null;
   
        ArrayList posicionesOperacion = new ArrayList();
        
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        docBuilder = docBuilderFactory.newDocumentBuilder();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(sXml.getBytes());
        
        nodeDoc = docBuilder.parse(inputStream).getFirstChild();
        traza("nodeDoc: " + nodeDoc.getNodeName());
        nodeList = nodeDoc.getOwnerDocument().getElementsByTagName("ROW");
        //nodeDoc.getChildNodes(); 
        long cantElems = nodeList.getLength();
        traza("cantElems: " + cantElems);

        /* Recorro tags <ROW> */        
        for (int i=0; i<cantElems; i++) {
        
           hshAtributos = new HashMap();
           nodoRow = nodeList.item(i);
           nodeListCampos = nodoRow.getChildNodes();
           long cantCampos = nodeListCampos.getLength();

           /* 
            * Si es la primer iteracion, armo la estrucutra del RecordSet 
            * con el numero de campos
            */            
           if (i == 0) {
              rRetorno = this.armarEstructuraRecordSet(cantCampos);             
           }
           
            /* Recorro tags <CAMPO> */
           vFila = new Vector(); 
           for (int j=0; j<cantCampos; j++) {
               nodoCampo = nodeListCampos.item(j);
               /* sPropiedad = this.obtenerPropiedadCampo(nodoCampo);*/
               sValorCampo = this.obtenerValorCampo(nodoCampo);
               vFila.add(sValorCampo);
           }
           rRetorno.addRow(vFila);
        }

        return rRetorno;
    }  
	
    private String obtenerValorCampo(Node nodo) 
          throws Exception {
        Node textNode = nodo.getFirstChild();
        String sValorCampo = null;
        if (textNode != null) { 

          sValorCampo = textNode.getNodeValue();
        } else {
          sValorCampo = "";
        }
        return sValorCampo;
    } 

  private RecordSet armarEstructuraRecordSet(long cantCampos)
          throws Exception {
          
      RecordSet r = new RecordSet();
      Vector vCampos = new Vector();
      String sCampo = "campo_";
      
      for (int i=0; i < cantCampos; i++ ){
         vCampos.add(sCampo + i);
      }
      
      r.setColumnIdentifiers(vCampos);
      return r;
  }

  private int cantElementosNuevos(String input, String oids[]) throws Exception {
	int cantidad = 0;
	StringTokenizer st = new StringTokenizer( input, "|" );
	while( st.hasMoreTokens() ){

		String oid = st.nextToken();

		if (!pertenece(oids, oid)) {
			cantidad++;
		}
	}
	return cantidad;
  }

  private Long[] listadoEliminado(String nombre) throws Exception {
	String palabra = conectorParametroLimpia(nombre, "", true);

	traza("listadoEliminado " + palabra);

	StringTokenizer token = new StringTokenizer( palabra, "," );
	Long oids[] = new Long[token.countTokens()];
	int ind1 = 0;

	while( token.hasMoreTokens() ){
		oids[ind1++] = new Long(token.nextToken());
	}
	return oids;
  }


    private void showAttr(NodeList nodelist) throws Exception{
    	this.showAttrAux(nodelist, -1);
    }
    
    private void showAttrAux(NodeList nodelist, long grade) throws Exception
	{
    	//showAttr(resultados.getXML().getChildNodes());
		grade++;
    	
	    if(nodelist != null)
	    {
			traza("cantidad de valores " + nodelist.getLength());
	        for(int j = 0; j < nodelist.getLength(); j++)
	        {
	            Node node = nodelist.item(j);
	            print(node.getNodeValue(), "value", grade);
				print(node.getNodeName(),"name", grade);
	            traza(generateSpace(grade) + "Childrens begin");
				showAttrAux(node.getChildNodes(), grade);
	            traza(generateSpace(grade) + "Childrens end");
	        }
	    }
	}
    
	private void print(Object value, String name, long grade) throws Exception {
		if (value != null) {
			traza(generateSpace(grade) + "the " + name + " is " + value.toString());
		} else {
			traza(generateSpace(grade) + "the " + name + " is empty");
		}
	}
	
	private String generateSpace(long grade) throws Exception {
		String out = "";
		for (int i = 0; i < grade; i++) {
			out = out + " - ";
		}
		return out;
	}  


    private Long obtenerCDPorDefecto() throws Exception {
        DTOBelcorp dtoe = new DTOBelcorp();
        dtoe.setOidPais(pais);
        dtoe.setOidIdioma(idioma);
        Vector parametros = new Vector();
        parametros.add(dtoe);
        parametros.add(new MareBusinessID("APEObtenerValoresDefecto"));
        
        DruidaConector conector = conectar("ConectorObtenerValoresDefecto", parametros);
        
        DTOSalida dtoSalida = (DTOSalida)conector.objeto("DTOSalida");
        
        // Solo no interesa el valor default para CD (Centro de Distribucion)
        String oidCDDefault = "";
        RecordSet valoresDef = dtoSalida.getResultado();
        traza(" - - - El RecordSet de valores por Defecto contiene:" + valoresDef);
        
        int cant = valoresDef.getRowCount();
        
        for (int i = 0; i < cant; i++) {
            if(((String)(valoresDef.getValueAt(i, "COMBO"))).equals(ConstantesAPE.CONFIGURACION_CD)){
                traza(" *** oidCDDefault:" + valoresDef.getValueAt(i, "OID"));
                oidCDDefault = ((BigDecimal)valoresDef.getValueAt(i, "OID")).toString();
                break;
            }
        }
        asignarAtributo("VAR", "hValorDefecto", "valor", oidCDDefault);

        if (!oidCDDefault.equals("")) {
            return new Long(oidCDDefault);
        } else {
            traza(" *** No hay CD por defecto");
            return null;
        }
    }
}
