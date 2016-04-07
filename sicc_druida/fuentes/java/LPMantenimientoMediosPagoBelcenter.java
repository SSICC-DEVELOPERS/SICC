/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
    INDRA/BEL/PROY
    $Id: LPMantenimientoMediosPagoBelcenter.java,v 1.1 2009/12/03 18:42:17 pecbazalar Exp $
    DESC
 */


//import java.util.HashMap;
import java.util.Vector;
import java.util.ArrayList;
import java.util.StringTokenizer;
//import java.math.BigDecimal;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;

import es.indra.druida.DruidaConector;

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;

import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.dtos.seg.DTOAccesosPorCanal;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.DTOSalida;

import es.indra.sicc.dtos.bel.DTOMediosPagoBelcenter;
import es.indra.sicc.dtos.bel.DTOEBuscarMediosPagoBelcenter;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;

public class LPMantenimientoMediosPagoBelcenter extends LPSICCBase {

	private String accion	= null;
	private String casodeuso	= null;
	
	public LPMantenimientoMediosPagoBelcenter() {
		super();
	}
           
	public void inicio() throws Exception {
	}

	public void ejecucion() throws Exception {
		setTrazaFichero();
		traza("*** Entrada - LPMantenimientoMediosPagoBelcenter - ejecucion ***");
		this.accion = conectorParametroLimpia("accion", "", true);
		this.casodeuso = conectorParametroLimpia("casodeuso", "", true);
		traza("*** LPMantenimientoMediosPagoBelcenter - CU ***: " + this.casodeuso + " accion: " + this.accion);

		try {
			if (this.accion.equals("insertar") || this.accion.equals("detalle")) {
				this.cargarPaginaInsertar();
			} else if (this.accion.equals("guardar")) {
				this.guardarRegistro();
			} else if (this.accion.equals("consultar")) {
				this.cargarPaginaBusqueda();
			}
		} catch (Exception ex) {
			this.logStackTrace(ex);
			this.lanzarPaginaError(ex);   
		}
		traza("*** Salida - LPMantenimientoMediosPagoBelcenter - ejecucion ***");
	} 

	private void cargarPaginaInsertar()  throws Exception  {
		traza("*** Entrada - LPMantenimientoMediosPagoBelcenter - cargarPaginaInsertar ***");
		pagina("contenido_medios_pago_belcenter_insertar");
		asignar("VAR", "casodeuso", this.casodeuso);

		if (this.casodeuso.equals("consultar")) {
			asignarAtributo("PAGINA", "contenido_medios_pago_belcenter_insertar", "cod", "0386");
			asignarAtributo("PAGINA", "contenido_medios_pago_belcenter_insertar", "msgle", "Consultar Medios de Pago por Belcenter");
		} else if (this.casodeuso.equals("eliminar")) {
			asignarAtributo("PAGINA", "contenido_medios_pago_belcenter_insertar", "cod", "0387");
			asignarAtributo("PAGINA", "contenido_medios_pago_belcenter_insertar", "msgle", "Eliminar Medios de Pago por Belcenter");
		} else  {
			asignarAtributo("PAGINA", "contenido_medios_pago_belcenter_insertar", "cod", "0385");
			asignarAtributo("PAGINA", "contenido_medios_pago_belcenter_insertar", "msgle", "Insertar Medios de Pago por Belcenter");
		}

		Long idioma = UtilidadesSession.getIdioma(this);
		asignar("VAR", "idioma", idioma.toString());
		Long pais = UtilidadesSession.getPais(this);
		asignar("VAR", "pais", pais.toString());

		Vector paramEntrada = new Vector();
		DTOBelcorp dto = new DTOBelcorp();
		dto.setOidPais(pais);
		dto.setOidIdioma(idioma);
		
		if (!this.casodeuso.equals("eliminar") && !this.casodeuso.equals("consultar")) {
			Long canal = null;
			Long acceso = null;
			Long subacceso = null;
			try {
				canal = UtilidadesSession.getCanalPorDefecto(this);
				acceso = UtilidadesSession.getAccesoPorDefecto(this);
				subacceso = UtilidadesSession.getSubaccesoPorDefecto(this);
			} catch (Exception e) {
			}
			if (canal != null) {
				asignar("VAR", "canal", canal.toString());
			}
			if (acceso != null) {
				asignar("VAR", "acceso", acceso.toString());
			}
			if (subacceso != null) {
				asignar("VAR", "subacceso", subacceso.toString());
			}
			//Llamar al subsistema GestorCargaPantalla :- idBusiness = SEGConsultaCanales y DTOBelcorp => llena combo canal 
			String [] idNegocios = new String[1];
			idNegocios[0] = new String("SEGConsultaCanales");
			String [] combos = new String[1];
			combos[0] = new String("cbCanal");
			this.cargaCombos(dto, idNegocios, combos, null, null);
			String [] selecs = new String[1];
			selecs[0] = canal.toString();

			String [] columnas = new String[1];
			columnas[0] = new String("VAL_OID");

			this.cargaCombos(dto, idNegocios, combos, selecs, columnas);
			
		} 
		// Crear idBusiness = "BELObtenerMediosDePago" 
		// Invocar conector "ConectorObtenerMediosDePago" con idBusiness creado y el DTOBelcorp creado
		paramEntrada.add(dto);
		paramEntrada.add(new MareBusinessID("BELObtenerMediosDePago"));
		DruidaConector conector = conectar("ConectorObtenerMediosDePago", paramEntrada);
		traza("*** LPMantenimientoMediosPagoBelcenter - conectado ***");

		//Contiene un RecordSet con los siguientes campos: 
		//- oid de medio de pago (columna oculta) 
		//- código de medio de pago 
		//- descripción internacionalizada del medio de pago 
		//- descripción del tipo de medio de pago
		//-> Tomar DTOSalida de respuesta a la llamada al conector de la actividad anterior 
		//-> Mapear el RecordSet del DTOSalida obtenido sobre la lista de pantalla "mediosDePago" 

        asignar("LISTAEDITABLE", "listado1", conector, "dtoSalida.resultado_ROWSET");

		if (this.casodeuso.equals("eliminar") || this.casodeuso.equals("consultar")) {
			traza("*** LPMantenimientoMediosPagoBelcenter - eliminar/consultar ***");
			//-> Crear idBusiness = "BELConsultarMediosPagoBelcenter" 
			// Tomar oid del medio de pago seleccionado en la pantalla de búsqueda y crear un objeto DTOOID
			DTOOID dtoOID = new DTOOID();
			dtoOID.setOidPais(pais);
			dtoOID.setOidIdioma(idioma);
			dtoOID.setOid(new Long(conectorParametroLimpia("listado1", "", true)));
	

			//-> Invocar al conector "ConectorConsultarMediosPagoBelcenter" con idBusiness anterior y el objeto DTOOID creado 
			paramEntrada = new Vector();
			paramEntrada.add(dtoOID);
			paramEntrada.add(new MareBusinessID("BELConsultarMediosPagoBelcenter")); 
			conector = conectar("ConectorConsultarMedioPagoBelcenter", paramEntrada);
			//-> Tomar el DTOMediosPagoBelcenter de respuesta a la invocación anterior 
				traza("*** LPMantenimientoMediosPagoBelcenter - subbacceso... ***" );
			DTOMediosPagoBelcenter resultado = (DTOMediosPagoBelcenter)conector.objeto("DTOMediosPagoBelcenter");
			//- oidSubacceso : Long 
			//- mediosPago : arrayList (oids de Medios de Pago) 
			//-> Dejar seleccionados en pantalla el subacceso y los medios de pago de la lista correspondientes a los oid del array del dto obtenido 
				traza("*** LPMantenimientoMediosPagoBelcenter - resultado ***" + resultado);

			Long subaccesoSelec = resultado.getOidSubacceso();
			if (subaccesoSelec != null) {
				traza("*** LPMantenimientoMediosPagoBelcenter - subbacceso ***" + subaccesoSelec);
				asignar("VAR", "subacceso", subaccesoSelec.toString());
				Vector valores = new Vector();
				valores.add(subaccesoSelec);
				valores.add(resultado.getDescripcionSubacceso());
				RecordSet rs = new RecordSet();
				rs.addColumn("CODIGO");
				rs.addColumn("DESCRIPCION");
				rs.addRow(valores);
		
				Vector cols = rs.getColumnIdentifiers();
				DruidaConector conectorCargaCombo = UtilidadesBelcorp.generarConector( "DTOSalida.combo_ROWSET", rs, cols);
				asignar("COMBO", "cbSubacceso", conectorCargaCombo, "DTOSalida.combo_ROWSET", cols.get(0).toString(), subaccesoSelec.toString());
			} 

			Long canalSelec = resultado.getOidCanal();
			if (canalSelec != null) {
				traza("*** LPMantenimientoMediosPagoBelcenter - canal ***" + canalSelec);
				asignar("VAR", "canal", canalSelec.toString());
				Vector valores = new Vector();
				valores.add(canalSelec);
				valores.add(resultado.getDescripcionCanal());
				RecordSet rs = new RecordSet();
				rs.addColumn("CODIGO");
				rs.addColumn("DESCRIPCION");
				rs.addRow(valores);
		
				Vector cols = rs.getColumnIdentifiers();
				DruidaConector conectorCargaCombo = UtilidadesBelcorp.generarConector( "DTOSalida.combo_ROWSET", rs, cols);
				asignar("COMBO", "cbCanal", conectorCargaCombo, "DTOSalida.combo_ROWSET", cols.get(0).toString(), canalSelec.toString());
			}

			Long accesoSelec = resultado.getOidAcceso();
			if (accesoSelec != null) {
				traza("*** LPMantenimientoMediosPagoBelcenter - acceso ***" + accesoSelec);
				asignar("VAR", "acceso", accesoSelec.toString());
				Vector valores = new Vector();
				valores.add(accesoSelec);
				valores.add(resultado.getDescripcionAcceso());
				RecordSet rs = new RecordSet();
				rs.addColumn("CODIGO");
				rs.addColumn("DESCRIPCION");
				rs.addRow(valores);
		
				Vector cols = rs.getColumnIdentifiers();
				DruidaConector conectorCargaCombo = UtilidadesBelcorp.generarConector( "DTOSalida.combo_ROWSET", rs, cols);
				asignar("COMBO", "cbAcceso", conectorCargaCombo, "DTOSalida.combo_ROWSET", cols.get(0).toString(), accesoSelec.toString());
			}

			ArrayList mediosPago = resultado.getMediosPago();
			if (mediosPago != null && mediosPago.size() > 0) {
				String mediosPagoStr = "";
				int i = 0;
				for (i = 0; i < mediosPago.size() - 1; i++) {
					mediosPagoStr += (Long)mediosPago.get(i) + ",";
				}
				mediosPagoStr += ((Long)mediosPago.get(i)).toString();
				asignar("VAR", "hmediosPago", mediosPagoStr);
			}
			
			//-> Deshabilitar tanto el combo de subaccesos como la lista, sólo permitir la consulta de los datos y pulsar el botón volver o salir
			deshabilitaCampos();
			getConfiguracionMenu("LPMantenimientoMediosPagoBelcenter", "detalle");
 		} else {
			traza("*** LPMantenimientoMediosPagoBelcenter - insertar ***");

			//-> Permitir al usuario seleccionar un canal, acceso y subacceso y los medios de pago que desee de la lista, tendrá que seleccionar al menos un medio de pago obligatoriamente y un subacceso. 
			getConfiguracionMenu("LPMantenimientoMediosPagoBelcenter", "insertar");
		} 
		/*Long canal = UtilidadesSession.getCanalPorDefecto(this);
		if (canal != null) {
				traza("***  - canalpordefecto ***");
			asignar("VAR", "canal", canal.toString());
		}*/
				traza("*** Salida - LPMantenimientoMediosPagoBelcenter - cargarPaginaInsertar ***");
	}

	private void cargarPaginaBusqueda()  throws Exception  {
		traza("*** Entrada - LPMantenimientoMediosPagoBelcenter - cargarPaginaBusqueda ***");
		//-> Asignar página "contenido_medios_pago_belcenter_consultar" 
		pagina("contenido_medios_pago_belcenter_consultar");

		asignar("VAR", "casodeuso", this.casodeuso);
		//-> Crear un DTOBelcorp tomando el idioma y el pais de la sesión 
		Long idioma = UtilidadesSession.getIdioma(this);
		asignar("VAR", "idioma", idioma.toString());
		Long pais = UtilidadesSession.getPais(this);
		asignar("VAR", "pais", pais.toString());
		Vector paramEntrada = new Vector();
		DTOBelcorp dto = new DTOBelcorp();
		dto.setOidPais(pais);
		dto.setOidIdioma(idioma);
		//-> Llamar al subsistema GestorCargaPantalla 
		//- idBusiness = SEGConsultaCanales y DTOBelcorp => llena combo canal 
		//- idBusiness = BELObtenerTiposMedioPago => llena combo tipoMedioPago 
		String [] idNegocios = new String[2];
		idNegocios[0] = new String("SEGConsultaCanales");
		idNegocios[1] = new String("BELObtenerTiposMedioPago");
		String [] combos = new String[2];
		combos[0] = new String("cbCanal");
		combos[1] = new String("cbTipoMediosPago");
		this.cargaCombos(dto, idNegocios, combos, null, null);


		//Si "casodeuso" = "consultar" entonces 
		if (this.casodeuso.equals("consultar")) {
			//-> permitir sólo seleccionar un registro de la lista 
			asignarAtributo("PAGINA", "contenido_medios_pago_belcenter_consultar", "cod", "0386");
			asignarAtributo("PAGINA", "contenido_medios_pago_belcenter_consultar", "msgle", "Consultar Medios de Pago por Belcenter");
			getConfiguracionMenu("LPMantenimientoMediosPagoBelcenter", "consultar");
		} else if (this.casodeuso.equals("eliminar")) {
			//Si no Si "casodeuso" = "eliminar" entonces 
			//-> permitir seleccionar uno o más registros de la lista para ser eliminados. 
			asignarAtributo("PAGINA", "contenido_medios_pago_belcenter_consultar", "cod", "0387");
			asignarAtributo("PAGINA", "contenido_medios_pago_belcenter_consultar", "msgle", "Eliminar Medios de Pago por Belcenter");
			getConfiguracionMenu("LPMantenimientoMediosPagoBelcenter", "eliminar");
		}

		
		//getConfiguracionMenu("LPMantenimientoMediosPagoBelcenter", "consultar");
		traza("*** Salida - LPMantenimientoMediosPagoBelcenter - cargarPaginaBusqueda ***");
	}

	private void guardarRegistro()  throws Exception  {
		traza("*** Entrada - LPMantenimientoMediosPagoBelcenter - guardarRegistro ***");
		//-> Asignar página "contenido_medios_pago_belcenter_insertar" 
				pagina("salidaGenerica");
				asignar("VAR", "cerrarVentana", "false");
				asignar("VAR", "ejecutar", "accionEjecutada()");
		//-> Crear un objeto DTOMediosPagoBelcenter 
		Long idioma = UtilidadesSession.getIdioma(this);
		Long pais = UtilidadesSession.getPais(this);
		DTOMediosPagoBelcenter dtoMediosPagoBelcenter =  new DTOMediosPagoBelcenter();
		//- oidSubacceso : Long 
		//- mediosPago : arrayList 
		//-> Tomar el oid del subacceso seleccionado en pantalla y asignarlo al atributo oidSubacceso del dto 
		//-> Tomar los oids de los medios de pago seleccionados de la lista y meterlos en el array mediosPago del dto 
		dtoMediosPagoBelcenter.setOidPais(pais);
		dtoMediosPagoBelcenter.setOidIdioma(idioma);
		dtoMediosPagoBelcenter.setOidSubacceso(this.numero(conectorParametroLimpia("cbSubacceso", "", true)));
		dtoMediosPagoBelcenter.setOidCanal(this.numero(conectorParametroLimpia("cbCanal", "", true)));
		dtoMediosPagoBelcenter.setOidAcceso(this.numero(conectorParametroLimpia("cbAcceso", "", true)));
		String mediosPagoSelec = conectorParametroLimpia("listado1", "", true);
		StringTokenizer st = new StringTokenizer(mediosPagoSelec, ",");
		ArrayList mediosPago = new ArrayList();
		while (st.countTokens() > 0) {
				mediosPago.add( new Long(st.nextToken()));
		}
		dtoMediosPagoBelcenter.setMediosPago(mediosPago);

		//-> Crear idBusiness = "BELGuardarMediosPagoBelcenter" 
		//-> Invocar conector "ConectorGuardarMediosPagoBelcenter" con dto e idBusiness creados 
		Vector paramEntrada = new Vector();
		paramEntrada.add(dtoMediosPagoBelcenter);
		paramEntrada.add(new MareBusinessID("BELGuardarMediosPagoBelcenter")); 
		DruidaConector conector = conectar("ConectorGuardarMediosPagoBelcenter", paramEntrada);
		
		traza("*** Salida - LPMantenimientoMediosPagoBelcenter - guardarRegistro ***");
	}

	private void deshabilitaCampos() throws Exception  {
		traza("*** Entrada - LPAplicarCargosAbonos - deshabilitaCampos ***");
		
		asignarAtributoElemento("cbCanal", "disabled", "S");
		asignarAtributoElemento("cbAcceso", "disabled", "S");
		asignarAtributoElemento("cbSubacceso", "disabled", "S");
		
		traza("*** Salida - LPAplicarCargosAbonos - deshabilitaCampos ***");
	}

	private void logStackTrace(Throwable e) throws Exception {
		traza("Se produjo la excepcion: " + e.getMessage());

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		e.printStackTrace(ps);
                    
		traza("Stack Trace: " + baos.toString());
	}



private void cargaCombos(DTOBelcorp dtoBelcorp, String[] idNegocios, String[] combos, String[] seleccionados, String[] columnas) throws Exception {
		traza("*** Entrada - cargaCombos ***");
		try {
		//Cada elemento va a contener el IDbusiness y el DTO que reciben la logica de negocio como entrada. 
		ComposerViewElementList listelem = new ComposerViewElementList();
		ComposerViewElement elem = null;
		
		for (int i = 0; i < idNegocios.length; i++) {
			elem=new ComposerViewElement(); 
			elem.setIDBusiness(idNegocios[i]);
			elem.setDTOE(dtoBelcorp);
			listelem.addViewElement(elem);
		}
		
		/*Se ejecuta el conector y se obtiene un RowSet que contiene todos los datos solicitados.*/ 
		ConectorComposerView conector = new ConectorComposerView(listelem, this.getRequest());
		conector.ejecucion();
		DruidaConector conConsultar = conector.getConector();
		
		/*Posterior a la llamada se debe hacer el asignar a los elementos de la pantalla 
		//correspondiente utilizando el String que representa el BusinessID en cada caso. */
		if (seleccionados == null) {
			for(int j = 0; j < combos.length; j++) {
				asignar("COMBO", combos[j], conConsultar, idNegocios[j]); 
			}
		} else {
			for (int j = 0; j < combos.length; j++) {
				if (seleccionados[j] != null && !seleccionados[j].equals("") && columnas != null && columnas.length > j && columnas[j] != null && !columnas[j].equals(""))
					asignar("COMBO", combos[j], conConsultar, idNegocios[j], columnas[j], seleccionados[j]);
			   	else
			   		asignar("COMBO", combos[j], conConsultar, idNegocios[j]); 
			}
		}		
		} catch (Exception ex) {
			this.logStackTrace(ex);
		}
		traza("*** Salida - cargaCombos ***");
	}	

	private Long numero(String entrada) throws Exception {
		if (entrada != null && !entrada.equals("")) {
			return new Long(entrada);
		}
		return null;
	}

}
