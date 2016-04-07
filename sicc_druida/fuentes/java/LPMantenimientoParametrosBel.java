/**
 * Copyright 2006 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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

import java.util.ArrayList;
import java.math.BigDecimal;
import java.util.Vector;


import es.indra.mare.common.mln.MareBusinessID;
import es.indra.druida.DruidaConector;

import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.UtilidadesSession;

import es.indra.sicc.dtos.bel.DTOParametrosBEL;
import es.indra.sicc.dtos.bel.DTOBusquedaParametrosBEL;

import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;

public class LPMantenimientoParametrosBel extends LPSICCBase {
	private static final String ACCION = "accion";
	private static final String CASO_USO = "casoUso";

	// Acciones.
	private static final String ACCION_CONSULTAR = "consultar";
	private static final String ACCION_INSERTAR = "insertar";
	private static final String ACCION_MODIFICAR = "modificar";
	private static final String ACCION_ELIMINAR = "eliminar";
	private static final String ACCION_GUARDAR = "guardar";
	private static final String ACCION_GUARDAR_MODIFICACION = "guardarModificacion";
	private static final String ACCION_CONSULTAR_PARAMETROS = "consultarParametros";
	private static final String ACCION_MODIFICAR_PARAMETROS = "modificarParametros";

	// Casos de uso.
	private static final String CASO_USO_CONSULTAR = "consultar";
	private static final String CASO_USO_INSERTAR = "insertar";
	private static final String CASO_USO_MODIFICAR = "modificar";
	private static final String CASO_USO_ELIMINAR = "eliminar";

	// Tipo de control de la página.
	private static final String ELEMENTO_COMBO = "COMBO";
	private static final String ELEMENTO_TEXTO = "CTEXTO";
	private static final String ELEMENTO_VAR = "VAR";
	private static final String ELEMENTO_COD = "cod";

	private static final String ASIGNACION_VALOR = "valor";

	// Nombres de controles de combo de la pantalla.
	private static final String COMBO_CANAL = "cbCanal";
	private static final String COMBO_ACCESO = "cbAcceso";
	private static final String COMBO_SUBACCESO = "cbSubAcceso";
	private static final String COMBO_MOV_STOCK_DEV = "cbMovStockDev";
	private static final String COMBO_TIPO_MOV_COB = "cbTipoMovCob";
	private static final String COMBO_MOV_CONFIRMAR_STOCK = "cbMovConfirmarStock";
	private static final String COMBO_MOV_STOCK_TRANSITO = "cbMovStockTransito";
	private static final String COMBO_MOV_CONFIRMAR_STOCK_TRANSITO = "cbMovConfirmarStockTransito";
	private static final String COMBO_MOV_REG = "cbMovReg";
	private static final String COMBO_MOV_REG_SAP = "cbMovRegSap";
	private static final String COMBO_DEVOLVER_STOCK_EXIST = "cbDevolverStockExist";
	private static final String COMBO_TIPO_MOV_CIERRE = "cbTipoMovCierre";
	private static final String COMBO_CUENTA_CCC = "cbCuentaCCC";
	private static final String COMBO_EMPRESA = "cbSociedad";
	private static final String COMBO_TIPO_TRANSACCION = "cbTipoTransaccion";
	private static final String COMBO_ADMINISTRADOR_BEL = "cbAdministradorBel";
	private static final String COMBO_MOV_PET_EXIST = "cbMovPetExist";

	// Nombres de controles de texto de la pantalla.
	private static final String TEXTO_DIRECCION = "txtDireccion";
	private static final String TEXTO_TELEFONO = "txtTelefono";
	private static final String TEXTO_MONTO_MAX_DIF = "txtMontoMaxDife";
	private static final String TEXTO_LIMITE_CAJA = "txtLimiteCaja";
	private static final String TEXTO_NUMERO_CAJA = "txtNumeroCajas";
	private static final String TEXTO_NOMBRE_LOCAL = "txtNombreLocal";
	private static final String TEXTO_ALERTA_STOCK = "txtAlertaStock";
	private static final String TEXTO_TIEMPO_REPOSICION = "txtTiempoReposicion";
	private static final String TEXTO_FACTOR_LOCAL = "txtFactorLocal";
	private static final String TEXTO_NUM_MAX_PRODUCTOS = "txtNumMaxProductos";
	private static final String TEXTO_COD_CLIENTE = "txtCodCliente";

	// Variables ocultas de la pantalla para seleccionar los controles combo.
	private static final String VAR_COMBO_CANAL = "hCbCanal";
	private static final String VAR_COMBO_ACCESO = "hCbAcceso";
	private static final String VAR_COMBO_SUBACCESO = "hCbSubAcceso";
	private static final String VAR_COMBO_MOV_STOCK_DEV = "hCbMovStockDev";
	private static final String VAR_COMBO_TIPO_MOV_COB = "hCbTipoMovCob";
	private static final String VAR_COMBO_MOV_CONFIRMAR_STOCK = "hCbMovConfirmarStock";
	private static final String VAR_COMBO_MOV_STOCK_TRANSITO = "hCbMovStockTransito";
	private static final String VAR_COMBO_MOV_CONFIRMAR_STOCK_TRANSITO = "hCbMovConfirmarStockTransito";
	private static final String VAR_COMBO_MOV_REG = "hCbMovReg";
	private static final String VAR_COMBO_MOV_REG_SAP = "hCbMovRegSap";
	private static final String VAR_COMBO_DEVOLVER_STOCK_EXIST = "hCbDevolverStockExist";
	private static final String VAR_COMBO_TIPO_MOV_CIERRE = "hCbTipoMovCierre";
	private static final String VAR_COMBO_CUENTA_CCC = "hCbCuentaCCC";
	private static final String VAR_COMBO_EMPRESA = "hCbSociedad";
	private static final String VAR_COMBO_TIPO_TRANSACCION = "hCbTipoTransaccion";
	private static final String VAR_COMBO_ADMINISTRADOR_BEL = "hCbAdministradorBel";
	private static final String VAR_COMBO_MOV_PET_EXIST = "hCbMovPetExist";
	private static final String VAR_TEXTO_OID_CLIENTE = "oidCliente";
	private static final String VAR_TEXTO_CODIGO_CLIENTE = "codigoCliente";
	private static final String VAR_OID_PARAMETRO = "hOidParametroBel";

	private static final String PAGINA_CONSULTAR = "contenido_parametros_belcenter_buscar";
	private static final String PAGINA_INSERTAR = "contenido_parametros_belcenter_insertar";
	private static final String PAGINA_DETALLE = "contenido_parametros_belcenter_detalle";
	private static final String SALIDA_GENERICA = "salidaGenerica";

	private static final String TITULO_COD_CONSULTAR = "0670";
	private static final String TITULO_COD_INSERTAR = "0668";
	private static final String TITULO_COD_MODIFICAR = "0669";
	private static final String TITULO_COD_ELIMINAR = "0671";

	private String accion;
	private String casoUso;
	private Long idioma;
	private Long pais;

	public void inicio() throws Exception {}

	public void ejecucion() throws Exception {
        rastreo();
        setTrazaFichero();

        traza("*** Entrada - LPMantenimientoParametrosBel - ejecucion ***");

		accion = conectorParametroLimpia(ACCION, "", true);
		casoUso = conectorParametroLimpia(CASO_USO, "", true);
		idioma = UtilidadesSession.getIdioma(this);
		pais = UtilidadesSession.getPais(this); 

		try {
			if (ACCION_CONSULTAR.equalsIgnoreCase(accion)) {
				consultarDatos();
			} else if (ACCION_INSERTAR.equalsIgnoreCase(accion)) {
				insertarDatos();
			} else if (ACCION_MODIFICAR.equalsIgnoreCase(accion)) {
				modificarDatos();
			} else if (ACCION_ELIMINAR.equalsIgnoreCase(accion)) {
				eliminarDatos();
			} else if (ACCION_GUARDAR.equalsIgnoreCase(accion)) {
				guardarDatos();
			} else if (ACCION_CONSULTAR_PARAMETROS.equalsIgnoreCase(accion)) {
				consultarParametros();
			} else if (ACCION_MODIFICAR_PARAMETROS.equalsIgnoreCase(accion)) {
				modificarParametros();
			} else if (ACCION_GUARDAR_MODIFICACION.equalsIgnoreCase(accion)) {
				guardarModificacion();
			} 

			this.getFormatosValidaciones();
		} catch (Exception e)  {
			logStackTrace(e);
            lanzarPaginaError(e);
		}

		traza("*** Salida - LPMantenimientoParametrosBel - ejecucion ***");
    }

	private void consultarDatos() throws Exception {
        traza("*** Entrada - LPMantenimientoParametrosBel - consultarDatos ***");

		casoUso = CASO_USO_CONSULTAR;
		pagina(PAGINA_CONSULTAR);
		cargarVariables(TITULO_COD_CONSULTAR);

		DTOBelcorp dtoBelcorp = new DTOBelcorp();
		dtoBelcorp.setOidIdioma(idioma);
		dtoBelcorp.setOidPais(pais);

		String[] idBusiness = new String[] {"SEGConsultaCanales"};
		String[] comboBox = new String[] {COMBO_CANAL};

		cargarCombos(dtoBelcorp, idBusiness, comboBox, null, null);

		traza("*** Salida - LPMantenimientoParametrosBel - consultarDatos ***");
	}

	private void insertarDatos() throws Exception {
	    traza("*** Entrada - LPMantenimientoParametrosBel - ingresarDatos ***");

		casoUso = CASO_USO_INSERTAR;
		pagina(PAGINA_INSERTAR);
		cargarVariables(TITULO_COD_INSERTAR);
		cargarPagina();

		traza("*** Salida - LPMantenimientoParametrosBel - ingresarDatos ***");
	}

	private void modificarDatos() throws Exception  {
        traza("*** Entrada - LPMantenimientoParametrosBel - modificarDatos ***");

		casoUso = CASO_USO_MODIFICAR;
		pagina(PAGINA_CONSULTAR);
		cargarVariables(TITULO_COD_MODIFICAR);

		DTOBelcorp dtoBelcorp = new DTOBelcorp();
		dtoBelcorp.setOidIdioma(idioma);
		dtoBelcorp.setOidPais(pais);

		String[] idBusiness = new String[] {"SEGConsultaCanales"};
		String[] comboBox = new String[] {COMBO_CANAL};

		cargarCombos(dtoBelcorp, idBusiness, comboBox, null, null);	

		traza("*** Salida - LPMantenimientoParametrosBel - modificarDatos ***");
	}

	private void eliminarDatos() throws Exception {
        traza("*** Entrada - LPMantenimientoParametrosBel - eliminarDatos ***");

		casoUso = CASO_USO_ELIMINAR;
		pagina(PAGINA_CONSULTAR);
		cargarVariables(TITULO_COD_ELIMINAR);

		DTOBelcorp dtoBelcorp = new DTOBelcorp();
		dtoBelcorp.setOidIdioma(idioma);
		dtoBelcorp.setOidPais(pais);

		String[] idBusiness = new String[] {"SEGConsultaCanales"};
		String[] comboBox = new String[] {COMBO_CANAL};

		cargarCombos(dtoBelcorp, idBusiness, comboBox, null, null);			

		traza("*** Salida - LPMantenimientoParametrosBel - eliminarDatos ***");
	}

	private void guardarDatos() throws Exception {
        traza("*** Entrada - LPMantenimientoParametrosBel - guardarDatos ***");

		casoUso = CASO_USO_INSERTAR;
		guardar(PAGINA_INSERTAR);
		
		traza("*** Entrada - LPMantenimientoParametrosBel - guardarDatos ***");
	}

	private void guardarModificacion() throws Exception {
        traza("*** Entrada - LPMantenimientoParametrosBel - guardarModificacion ***");

		casoUso = CASO_USO_MODIFICAR;
		guardar(PAGINA_DETALLE);
		
		traza("*** Entrada - LPMantenimientoParametrosBel - guardarModificacion ***");
	}

	private void guardar(String nombrePagina) throws Exception {
        traza("*** Entrada - LPMantenimientoParametrosBel - guardar ***");

		pagina(nombrePagina);

		asignar(ELEMENTO_VAR, CASO_USO, casoUso);

		DTOParametrosBEL dto = new DTOParametrosBEL();
		dto.setOidPais(pais);
		dto.setOidIdioma(idioma);

        traza("opcionales");
		dto.setOidMoviStockEnTransito(convToLong(COMBO_MOV_STOCK_TRANSITO));
		//dto.setOidAdministradorBelCenter(convToLong(COMBO_ADMINISTRADOR_BEL));
		dto.setOidMoviPeticionExistencias(convToLong(COMBO_MOV_PET_EXIST));
		dto.setOidCliente(convToLong(VAR_TEXTO_OID_CLIENTE));

        traza("obligatorios");

		dto.setOidParametro(convToLong(VAR_OID_PARAMETRO));
		dto.setOidCanal(convToLong(COMBO_CANAL));
		dto.setOidAcceso(convToLong(COMBO_ACCESO));
		dto.setOidSubacceso(convToLong(COMBO_SUBACCESO));
		dto.setAlertaStock(convToLong(TEXTO_ALERTA_STOCK));
		dto.setOidMoviStockDevolucion(convToLong(COMBO_MOV_STOCK_DEV));
		dto.setOidTipoMoviCajaCobrar(convToLong(COMBO_TIPO_MOV_COB));
		dto.setOidMoviConfirmarStock(convToLong(COMBO_MOV_CONFIRMAR_STOCK));
		dto.setOidMoviConfirmarStockTransito(convToLong(COMBO_MOV_CONFIRMAR_STOCK_TRANSITO));
		dto.setOidMoviRegularizacion(convToLong(COMBO_MOV_REG));
		dto.setOidMoviRegularizacionSAP(convToLong(COMBO_MOV_REG_SAP));
		dto.setOidMoviDevolStockExistencias(convToLong(COMBO_DEVOLVER_STOCK_EXIST));
		dto.setOidTipoMoviCajaCierre(convToLong(COMBO_TIPO_MOV_CIERRE));
		dto.setOidCuentaCorriente(convToLong(COMBO_CUENTA_CCC));
		dto.setOidEmpresa(convToLong(COMBO_EMPRESA));
		dto.setOidTipoTransaccion(convToLong(COMBO_TIPO_TRANSACCION));

		dto.setFactorXLocal(convToBigDecimal(TEXTO_FACTOR_LOCAL));
		dto.setMontoMaxDiferencia(convToBigDecimal(TEXTO_MONTO_MAX_DIF));
		dto.setLimiteEfectCaja(convToBigDecimal(TEXTO_LIMITE_CAJA));
		
		dto.setNroCajas(convToInteger(TEXTO_NUMERO_CAJA));
		dto.setTiempoReposicion(convToInteger(TEXTO_TIEMPO_REPOSICION));
		dto.setNroMaxProdu(convToInteger(TEXTO_NUM_MAX_PRODUCTOS));
		dto.setCodigoCliente(convToString(VAR_TEXTO_CODIGO_CLIENTE));

		dto.setDireccion(convToString(TEXTO_DIRECCION));
		dto.setTelefono(convToString(TEXTO_TELEFONO));
		dto.setNombreLocal(convToString(TEXTO_NOMBRE_LOCAL));
		dto.setCodigoCliente(convToString(TEXTO_COD_CLIENTE));
		dto.setNombreAdministrador(convToString("hNombreAdministrador"));

		pagina(SALIDA_GENERICA);

		asignar("VAR", "ejecutar", "guardarCorrecto()");
		asignar("VAR", "ejecutarError", "guardarError()");

		MareBusinessID id = new MareBusinessID("BELGuardarParametros");

		traza("DTO SALIDA " + dto);

		Vector parameters = new Vector();
        parameters.add(dto);
        parameters.add(id);

		DruidaConector conector = conectar("ConectorGuardarParametrosBEL", parameters);			

		traza("*** Salida - LPMantenimientoParametrosBel - guardar ***");
	}

	private void cargarPagina() throws Exception {
        traza("*** Entrada - LPMantenimientoParametrosBel - cargarPagina ***");

		DTOBelcorp dtoBelcorp = new DTOBelcorp();
		dtoBelcorp.setOidIdioma(idioma);
		dtoBelcorp.setOidPais(pais);

		String[] idBusiness = new String[] {"SEGConsultaCanales", "MENObtenerCodUsuarios",
			"BELObtenerTiposMovimientosAlmacen", "BELObtenerTiposMovimientosAlmacen",
			"BELObtenerTiposMovimientosAlmacen", "BELObtenerTiposMovimientosAlmacen",
			"BELObtenerTiposMovimientosAlmacen", "BELObtenerTiposMovimientosAlmacen",
			"BELObtenerTiposMovimientosAlmacen", "BELObtenerTiposMovimientosAlmacen",
			"BELObtenerTiposMovimientosCaja", "BELObtenerTiposMovimientosCaja",
			"CCCObtenerCuentasCorrientesBancarias", "SEGObtenerEmpresasPorPais",
			"CCCObtenerTiposTransaccion"};
		
		String[] comboBox = new String[] {COMBO_CANAL, COMBO_ADMINISTRADOR_BEL, COMBO_MOV_CONFIRMAR_STOCK,
			COMBO_MOV_CONFIRMAR_STOCK_TRANSITO, COMBO_DEVOLVER_STOCK_EXIST, COMBO_MOV_PET_EXIST,
			COMBO_MOV_REG, COMBO_MOV_REG_SAP, COMBO_MOV_STOCK_TRANSITO, COMBO_MOV_STOCK_DEV,
			COMBO_TIPO_MOV_CIERRE, COMBO_TIPO_MOV_COB, COMBO_CUENTA_CCC, COMBO_EMPRESA,
			COMBO_TIPO_TRANSACCION};

		cargarCombos(dtoBelcorp, idBusiness, comboBox, null, null);

		traza("*** Salida - LPMantenimientoParametrosBel - cargarPagina ***");
	}

	private void consultarParametros() throws Exception {
		traza("*** Entrada - LPMantenimientoParametrosBel - consultarParametros ***");

		casoUso = ACCION_CONSULTAR_PARAMETROS;		
		cargarParametros(TITULO_COD_CONSULTAR);

		traza("*** Salida - LPMantenimientoParametrosBel - consultarParametros ***");
	}

	private void modificarParametros() throws Exception {
		traza("*** Entrada - LPMantenimientoParametrosBel - modificarParametros ***");

		casoUso = ACCION_MODIFICAR_PARAMETROS;
		cargarParametros(TITULO_COD_MODIFICAR);

		traza("*** Salida - LPMantenimientoParametrosBel - modificarParametros ***");
	}

    private void logStackTrace(Throwable e) throws Exception {
        traza("Se produjo la excepción: " + e.getMessage());

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream print = new PrintStream(out);
        e.printStackTrace(print);

        traza("Stack Trace: " + out);
    }

	private void cargarParametros(String titulo) throws Exception {
		traza("*** Entrada - LPMantenimientoParametrosBel - cargarParametros ***");

		DTOOID dto = new DTOOID();
		dto.setOidIdioma(idioma);
		dto.setOidPais(pais);
		dto.setOid(new Long(conectorParametroLimpia("oidParametrosBel", "", true)));

		pagina(PAGINA_DETALLE);

		asignar(ELEMENTO_VAR, VAR_OID_PARAMETRO, dto.getOid().toString());

		cargarVariables(titulo);
		cargarPagina();

		MareBusinessID idBusinessMare = new MareBusinessID("BELBuscarParametros");

		ArrayList parameters = new ArrayList();
		parameters.add(dto);
		parameters.add(idBusinessMare);

		DruidaConector conector = conectar("ConectorBuscarParametrosBEL", parameters);
		DTOParametrosBEL dtoResult = (DTOParametrosBEL)conector.objeto("DTOParametrosBEL");

		traza("*** Entrada - LPMantenimientoParametrosBel - cargarParametros ***" + ", dto: " + dto + ", dtoResult: " + dtoResult);

		DTOOID dtoOid = new DTOOID();
        dtoOid.setOid(dtoResult.getOidCanal());
        dtoOid.setOidIdioma(idioma);
        dtoOid.setOidPais(pais);

		String[] idBusiness = new String[] {"SEGObtieneAccesosPorCanal"};
        String[] comboBox = new String[] {COMBO_ACCESO};
    
		cargarCombos(dtoOid, idBusiness, comboBox, null, null);

		dtoOid = new DTOOID();
        dtoOid.setOid(dtoResult.getOidAcceso());
        dtoOid.setOidIdioma(idioma);
        dtoOid.setOidPais(pais);
    
        idBusiness = new String[] {"SegObtenerSubaccesosPorAcceso"};
        comboBox = new String[] {COMBO_SUBACCESO};
    
        cargarCombos(dtoOid, idBusiness, comboBox, null, null);

		asignarCombo(VAR_COMBO_CANAL, dtoResult.getOidCanal());
		asignarCombo(VAR_COMBO_ACCESO, dtoResult.getOidAcceso());
		asignarCombo(VAR_COMBO_SUBACCESO, dtoResult.getOidSubacceso());
		asignarCombo(VAR_COMBO_MOV_STOCK_TRANSITO, dtoResult.getOidMoviStockEnTransito());
		asignarCombo(VAR_COMBO_TIPO_MOV_COB, dtoResult.getOidTipoMoviCajaCobrar());
		asignarCombo(VAR_COMBO_MOV_CONFIRMAR_STOCK, dtoResult.getOidMoviConfirmarStock());
		asignarCombo(VAR_COMBO_MOV_CONFIRMAR_STOCK_TRANSITO, dtoResult.getOidMoviConfirmarStockTransito());
		asignarCombo(VAR_COMBO_MOV_REG, dtoResult.getOidMoviRegularizacion());
		asignarCombo(VAR_COMBO_MOV_REG_SAP, dtoResult.getOidMoviRegularizacionSAP());
		asignarCombo(VAR_COMBO_DEVOLVER_STOCK_EXIST, dtoResult.getOidMoviDevolStockExistencias());
		asignarCombo(VAR_COMBO_TIPO_MOV_CIERRE, dtoResult.getOidTipoMoviCajaCierre());
		asignarCombo(VAR_COMBO_CUENTA_CCC, dtoResult.getOidCuentaCorriente());
		asignarCombo(VAR_COMBO_EMPRESA, dtoResult.getOidEmpresa());
		asignarCombo(VAR_COMBO_TIPO_TRANSACCION, dtoResult.getOidTipoTransaccion());
		asignarCombo(VAR_COMBO_MOV_STOCK_DEV, dtoResult.getOidMoviStockDevolucion());
		asignarCombo(VAR_COMBO_ADMINISTRADOR_BEL, dtoResult.getNombreAdministrador());
		asignarCombo(VAR_COMBO_MOV_PET_EXIST, dtoResult.getOidMoviPeticionExistencias());

		asignarTexto(TEXTO_DIRECCION, dtoResult.getDireccion());
		asignarTexto(TEXTO_TELEFONO, dtoResult.getTelefono());
		asignarTexto(TEXTO_MONTO_MAX_DIF, dtoResult.getMontoMaxDiferencia());
		asignarTexto(TEXTO_LIMITE_CAJA, dtoResult.getLimiteEfectCaja());
		asignarTexto(TEXTO_NUMERO_CAJA, dtoResult.getNroCajas());
		asignarTexto(TEXTO_NOMBRE_LOCAL, dtoResult.getNombreLocal());
		asignarTexto(TEXTO_ALERTA_STOCK, dtoResult.getAlertaStock());
		asignarTexto(TEXTO_TIEMPO_REPOSICION, dtoResult.getTiempoReposicion());
		asignarTexto(TEXTO_FACTOR_LOCAL, dtoResult.getFactorXLocal());
		asignarTexto(TEXTO_NUM_MAX_PRODUCTOS, dtoResult.getNroMaxProdu());
		asignarTexto(TEXTO_COD_CLIENTE, dtoResult.getCodigoCliente());
		asignarTexto(VAR_TEXTO_OID_CLIENTE, dtoResult.getOidCliente());

		traza("*** Salida - LPMantenimientoParametrosBel - cargarParametros ***");
	}

	private void cargarVariables(String titulo) throws Exception {
		traza("*** Entrada - LPMantenimientoParametrosBel - cargarVariables ***");

		final String sesionIdioma = "idioma";
		final String sesionPais = "pais";

		getConfiguracionMenu(getClass().getName(), casoUso);
		asignarAtributoPagina(ELEMENTO_COD, titulo);
		asignar(ELEMENTO_VAR, CASO_USO, casoUso);
		asignar(ELEMENTO_VAR, sesionIdioma, idioma.toString());
		asignar(ELEMENTO_VAR, sesionPais, pais.toString());

		traza("*** Salida - LPMantenimientoParametrosBel - cargarVariables ***");
	}

	private void asignarCombo(String varNombreCombo, Object valor) throws Exception {
		traza("*** Entrada - LPMantenimientoParametrosBel - asignarCombo ***");

		asignar(ELEMENTO_VAR, varNombreCombo, (valor == null) ? "" : valor.toString());
		
		traza("*** Salida - LPMantenimientoParametrosBel - asignarCombo ***");
	}

	private void asignarTexto(String nombreTexto, Object valor) throws Exception {
		traza("*** Entrada - LPMantenimientoParametrosBel - asignarTexto ***");

		asignarAtributo(ELEMENTO_TEXTO, nombreTexto, ASIGNACION_VALOR, (valor == null) ? "" : valor.toString());

		traza("*** Salida - LPMantenimientoParametrosBel - asignarTexto ***");
	}

	 private Long convToLong(String parametro) throws Exception{

		String conector = null; 

		if (parametro != null) {		
			conector = conectorParametroLimpia(parametro, "", true);
			traza("*** " + getClass().getName() + " - convToLong elemento: " + parametro + "  valor:  " + conector);
		} else {
			traza("*** " + getClass().getName() + " - convToLong elemento: " + parametro + "  valor:  nulo ");
		}


		if ((conector != null) && (!conector.equals(""))) {
			   return new Long(conector);
		} else {
			   return null;
		}
	 }

	 private BigDecimal convToBigDecimal(String parametro) throws Exception{

		String conector = null; 

		if (parametro != null) {		
			conector = conectorParametroLimpia(parametro, "", true);
			traza("*** " + getClass().getName() + " - convToBigDecimal elemento: " + parametro + "  valor:  " + conector);
		} else {
			traza("*** " + getClass().getName() + " - convToBigDecimal elemento: " + parametro + "  valor:  nulo ");
		}

		if ((conector != null) && (!conector.equals(""))) {
			   return new BigDecimal(conector);
		} else {
			   return null;
		}
	 }

	 private Integer convToInteger(String parametro) throws Exception{

		String conector = null; 

		if (parametro != null) {		
			conector = conectorParametroLimpia(parametro, "", true);
			traza("*** " + getClass().getName() + " - convToInteger elemento: " + parametro + "  valor:  " + conector);
		} else {
			traza("*** " + getClass().getName() + " - convToInteger elemento: " + parametro + "  valor:  nulo ");
		}

		if ((conector != null) && (!conector.equals(""))) {
			   return new Integer(conector);
		} else {
			   return null;
		}
	 }

	 private String convToString(String parametro) throws Exception{

		String conector = null; 

		if (parametro != null) {		
			conector = conectorParametroLimpia(parametro, "", true);
			traza("*** " + getClass().getName() + " - convToString elemento: " + parametro + "  valor:  " + conector);
		} else {
			traza("*** " + getClass().getName() + " - convToString elemento: " + parametro + "  valor:  nulo ");
		}

		if (conector != null) {
			return conector;
		} else {
			return null;
		}
	 }

	private void cargarCombos(DTOBelcorp dto, String[] idBusiness, String[] comboBox, String[] column, String[] selected) throws Exception {
        traza("*** Entrada - LPMantenimientoParametrosBel - cargarCombos ***");

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

		// Asignar los datos obtenidos a los combos.
		if (selected != null && column != null) {
			for (int i = 0; i < comboBox.length; i++) {
				if (selected[i] != null && column[i] != null) {
					asignar(ELEMENTO_COMBO, comboBox[i], dc, idBusiness[i], column[i], selected[i]);
				} else {
					asignar(ELEMENTO_COMBO, comboBox[i], dc, idBusiness[i]); 
				}
			}
		} else {
			for(int i = 0; i < comboBox.length; i++) {
				asignar(ELEMENTO_COMBO, comboBox[i], dc, idBusiness[i]); 
			}
		}

		traza("*** Salida - LPMantenimientoParametrosBel - cargarCombos ***");
	}
}