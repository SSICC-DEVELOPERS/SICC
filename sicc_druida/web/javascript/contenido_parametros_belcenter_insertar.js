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

/*-----------------------------------------------*/
/*contenido_parametros_belcenter_insertar.js*/
/*-----------------------------------------------*/

var formulario = 'frmParametrosBelcenter';
var vCasoUso = formulario + '.casoUso';

var vCbCanal = formulario + '.cbCanal';
var vCbAcceso = formulario + '.cbAcceso';
var vCbSubAcceso = formulario + '.cbSubAcceso';
var vCbMovStockDev = formulario + '.cbMovStockDev';
var vCbTipoMovCob = formulario + '.cbTipoMovCob';
var vCbMovConfirmarStock = formulario + '.cbMovConfirmarStock';
var vCbMovStockTransito = formulario + '.cbMovStockTransito';
var vCbMovConfirmarStockTransito = formulario + '.cbMovConfirmarStockTransito';
var vCbMovReg = formulario + '.cbMovReg';
var vCbMovRegSap = formulario + '.cbMovRegSap';
var vCbDevolverStockExist = formulario + '.cbDevolverStockExist';
var vCbTipoMovCierre = formulario + '.cbTipoMovCierre';
var vCbCuentaCCC = formulario + '.cbCuentaCCC';
var vCbSociedad = formulario + '.cbSociedad';
var vCbTipoTransaccion = formulario + '.cbTipoTransaccion';
var vCbAdministradorBel = formulario + '.cbAdministradorBel';
var vCbMovPetExist = formulario + '.cbMovPetExist';

var vTxtDireccion = formulario + '.txtDireccion';
var vTxtTelefono = formulario + '.txtTelefono';
var vTxtMontoMaxDife = formulario + '.txtMontoMaxDife';
var vTxtLimiteCaja = formulario + '.txtLimiteCaja';
var vTxtNumeroCajas = formulario + '.txtNumeroCajas';
var vTxtNombreLocal = formulario + '.txtNombreLocal';
var vTxtAlertaStock = formulario + '.txtAlertaStock';
var vTxtTiempoReposicion = formulario + '.txtTiempoReposicion';
var vTxtFactorLocal = formulario + '.txtFactorLocal';
var vTxtNumMaxProductos = formulario + '.txtNumMaxProductos';
var vTxtCodCliente = formulario + '.txtCodCliente';

var vHCbCanal = formulario + '.hCbCanal';
var vHCbAcceso = formulario + '.hCbAcceso';
var vHCbSubAcceso = formulario + '.hCbSubAcceso';
var vHCbMovStockDev = formulario + '.hCbMovStockDev';
var vHCbTipoMovCob = formulario + '.hCbTipoMovCob';
var vHCbMovConfirmarStock = formulario + '.hCbMovConfirmarStock';
var vHCbMovStockTransito = formulario + '.hCbMovStockTransito';
var vHCbMovConfirmarStockTransito = formulario + '.hCbMovConfirmarStockTransito';
var vHCbMovReg = formulario + '.hCbMovReg';
var vHCbMovRegSap = formulario + '.hCbMovRegSap';
var vHCbDevolverStockExist = formulario + '.hCbDevolverStockExist';
var vHCbTipoMovCierre = formulario + '.hCbTipoMovCierre';
var vHCbCuentaCCC = formulario + '.hCbCuentaCCC';
var vHCbSociedad = formulario + '.hCbSociedad';
var vHCbTipoTransaccion = formulario + '.hCbTipoTransaccion';
var vHCbAdministradorBel = formulario + '.hCbAdministradorBel';
var vHCbMovPetExist = formulario + '.hCbMovPetExist';
var vHOidParametroBel = formulario + '.hOidParametroBel';

var vPais = formulario + '.pais';
var vIdioma = formulario + '.idioma';

function ocultaLista() {
/*
    document.all["Cplistado3"].style.visibility = 'hidden';
    document.all["CpLin1listado3"].style.visibility = 'hidden';
    document.all["CpLin2listado3"].style.visibility = 'hidden';
    document.all["CpLin3listado3"].style.visibility = 'hidden';
    document.all["CpLin4listado3"].style.visibility = 'hidden';

    document.all["primera1Div"].style.visibility = 'hidden';
    document.all["ret1Div"].style.visibility = 'hidden';
    document.all["ava1Div"].style.visibility = 'hidden';
    document.all["separaDiv"].style.visibility = 'hidden';

	document.all["btnModificarDiv"].style.visibility = 'hidden';
	document.all["btnDetalleDiv"].style.visibility = 'hidden';
	document.all["btnEliminarDiv"].style.visibility = 'hidden';
	*/
}

function setearEstadoCampos(estado){

	/*carga inicial*/
	document.frmParametrosBelcenter.cbCanal.style.visibility=estado;
	document.frmParametrosBelcenter.cbMovStockTransito.style.visibility=estado;
	document.frmParametrosBelcenter.cbMovStockDev.style.visibility=estado;
	document.frmParametrosBelcenter.cbTipoMovCob.style.visibility=estado;
	document.frmParametrosBelcenter.cbMovConfirmarStockTransito.style.visibility=estado;
	document.frmParametrosBelcenter.cbMovConfirmarStock.style.visibility=estado;
	document.frmParametrosBelcenter.cbMovReg.style.visibility=estado;
	document.frmParametrosBelcenter.cbMovRegSap.style.visibility=estado;
	document.frmParametrosBelcenter.cbDevolverStockExist.style.visibility=estado;
	document.frmParametrosBelcenter.cbMovPetExist.style.visibility=estado;
	document.frmParametrosBelcenter.cbTipoMovCierre.style.visibility=estado;
	document.frmParametrosBelcenter.cbTipoMovCob.style.visibility=estado;
	document.frmParametrosBelcenter.txtCodCliente.style.visibility=estado;

	document.frmParametrosBelcenter.cbAcceso.style.visibility=estado;
	document.frmParametrosBelcenter.cbSubAcceso.style.visibility=estado;
	document.frmParametrosBelcenter.cbCuentaCCC.style.visibility=estado;
	document.frmParametrosBelcenter.cbAdministradorBel.style.visibility=estado;
	document.frmParametrosBelcenter.txtDireccion.style.visibility=estado;
	document.frmParametrosBelcenter.txtTelefono.style.visibility=estado;
	document.frmParametrosBelcenter.txtMontoMaxDife.style.visibility=estado;
	document.frmParametrosBelcenter.txtLimiteCaja.style.visibility=estado;
	document.frmParametrosBelcenter.txtNombreLocal.style.visibility=estado;
	document.frmParametrosBelcenter.txtFactorLocal.style.visibility=estado;
	document.frmParametrosBelcenter.txtNumMaxProductos.style.visibility=estado;
	document.frmParametrosBelcenter.txtAlertaStock.style.visibility=estado;
	document.frmParametrosBelcenter.txtTiempoReposicion.style.visibility=estado;
}

function onLoadPag(){
	if (get('frmParametrosBelcenter.errCodigo') != "") {
		fMostrarMensajeError();
		window.close();
	}

	configurarMenuSecundario('frmParametrosBelcenter');

	var casoUsoSeleccionado = get(vCasoUso);

	if (casoUsoSeleccionado == "insertar") {
		DrdEnsanchaConMargenDcho('listado3', 6);
		focaliza('frmParametrosBelcenter.cbCanal','');
		cargarPagina();

	} else if (casoUsoSeleccionado == "consultarParametros") {
		combos = new Array(vCbCanal, vCbAcceso, vCbSubAcceso, vCbMovStockDev, vCbTipoMovCob, 
			vCbMovConfirmarStock, vCbMovStockTransito, vCbMovConfirmarStockTransito, vCbMovReg,
			vCbMovRegSap, vCbDevolverStockExist, vCbTipoMovCierre, vCbCuentaCCC, vCbSociedad,
			vCbTipoTransaccion, vCbAdministradorBel, vCbMovPetExist);

		textos = new Array(vTxtDireccion, vTxtTelefono, vTxtMontoMaxDife, vTxtLimiteCaja,
			vTxtNumeroCajas, vTxtNombreLocal, vTxtAlertaStock, vTxtTiempoReposicion,
			vTxtFactorLocal, vTxtNumMaxProductos, vTxtCodCliente);

		deshabilitarCombosTextos(combos, textos, 'true');
		mostrarDatosSeleccionados();
		ocultaLista();
	} else if (casoUsoSeleccionado == "modificarParametros") {
		combos = new Array(vCbCanal, vCbAcceso, vCbSubAcceso);
		deshabilitarCombosTextos(combos, null, 'true');
		mostrarDatosSeleccionados();
		ocultaLista();
		focaliza('frmParametrosBelcenter.txtDireccion','');
	} else if (casoUsoSeleccionado == "eliminar") {
		mostrarDatosSeleccionados();
		ocultaLista();
	}

	eval(ON_RSZ);
}

function fBorrar(){
	var seleccionados = listado3.codSeleccionados();
	var cantSeleccionados = seleccionados.length;

	if (cantSeleccionados > 0) {
		if (listado3.datos.length == cantSeleccionados) {
			borroUltimos = true;
		} else {
			borroUltimos = false;
		}
		
		eliminarFilas(seleccionados, "BELEliminarParametros", mipgndo3);
		return true;

	} else {
		GestionarMensaje("4", null, null, null);
		return false;
	}
}

function cargarPagina(){
	if ( get('frmParametrosBelcenter.casoUso') == "insertar"){

		configurarPaginado(	mipgndo3, 
							"BELObtenerParametrosBEL", 
							"ConectorObtenerParametrosBEL",
							"es.indra.sicc.dtos.bel.DTOBusquedaParametrosBEL",
							[["oidPais", get(vPais)],
							 ["oidIdioma", get(vIdioma)]]);

		setearEstadoCampos('');
	}
/*
	if ( get('frmParametrosBelcenter.casoUso') == "modificarParametros") {
		setearEstadoCampos('');
		document.frmParametrosBelcenter.cbAcceso.style.visibility='hidden';
		document.frmParametrosBelcenter.cbCanal.style.visibility='hidden';
		document.frmParametrosBelcenter.cbSubacceso.style.visibility='hidden';
		document.frmParametrosBelcenter.listado3.style.visibility='hidden';
	}

	if ( get('frmParametrosBelcenter.casoUso') == "consultarParametros") {
		setearEstadoCampos('hidden');
	}

	if ( get('frmParametrosBelcenter.casoUso') == "eliminar") {
		setearEstadoCampos('hidden');
	}
	*/
}

function btnBusquedaClienteOnClick(){
	var casoUsoSeleccionado = get(vCasoUso);

	if (casoUsoSeleccionado == "insertar" || casoUsoSeleccionado == "modificarParametros") {
		var obj = new Object();
		var whnd = mostrarModalSICC('LPBusquedaRapidaCliente','',obj);
		if(whnd!=null){
			var oid = whnd[0];
			var cod = whnd[1];
			set("frmParametrosBelcenter.txtCodCliente", cod);
			set("frmParametrosBelcenter.codigoCliente", cod);
			set("frmParametrosBelcenter.oidCliente", oid);
		}

		focaliza('frmParametrosBelcenter.txtCodCliente','');
	}
}

function onChangeCodigoCliente(){
	set("frmParametrosBelcenter.oidCliente", ""); 
}

function onBlurCodigoCliente() {
	if(get("frmParametrosBelcenter.txtCodCliente") != "") {
		var cliente = validarLongCodCliene(get("frmParametrosBelcenter.txtCodCliente"));      
		set("frmParametrosBelcenter.txtCodCliente", cliente); 
	}
}

function validarLongCodCliene(codCliente) {
	var longiCod = 11;
	var faltantes = longiCod -  codCliente.length;
	var resultCod = new String("");
	if(faltantes > 0){
	   for(var t = 0 ; t<faltantes; t++){
				resultCod = resultCod + "0";
	   }
	   resultCod = resultCod + codCliente;
	   return resultCod;
	}
	return codCliente;
}

function cbAccesoOnChange(){
         recargaCombo(	'frmParametrosBelcenter.cbSubAcceso', 
						 'SegObtenerSubaccesosPorAcceso', 
						 'es.indra.sicc.util.DTOOID', 
						 [["oidIdioma", get('frmParametrosBelcenter.idioma')], 
						  ["oid", get('frmParametrosBelcenter.cbAcceso')]]);

}

function cbAccesoOnChange(){
	vaciaSubacceso();
	var oidAcceso = get('frmParametrosBelcenter.cbAcceso');
	if(oidAcceso != ""){ 
		recargaCombo(	'frmParametrosBelcenter.cbSubAcceso', 
						'SegObtenerSubaccesosPorAcceso', 
						'es.indra.sicc.util.DTOOID', 
						[['oidIdioma', get('frmParametrosBelcenter.idioma')], 
						 ['oid', oidAcceso]]);
	}
}

function cbCanalOnChange(){
	vaciaAcceso();
	var oidcanal = get('frmParametrosBelcenter.cbCanal');
	if (oidcanal != "") {
		recargaCombo(	'frmParametrosBelcenter.cbAcceso', 
						'SEGObtieneAccesosPorCanal', 
						'es.indra.sicc.util.DTOOID', 
						[['oidIdioma', get('frmParametrosBelcenter.idioma')], 
						 ['oid', oidcanal]]);
	}
}

function cbSociedadOnChange(){
/*	var oidsociedad = get('frmParametrosBelcenter.cbSociedad');
	if (oidsociedad != "") {
		recargaCombo(	'frmParametrosBelcenter.cbCuentaCCC', 
						'CCCRecargarCCEmpresa', 
						'es.indra.sicc.util.DTOOID', 
						[['oid', oidsociedad]]);
	} else {
          set_combo('frmParametrosBelcenter.cbCuentaCCC',[['','']],[''])
	}
*/
}

function vaciaAcceso(){
          set_combo('frmParametrosBelcenter.cbAcceso',[['','']],['']);
          vaciaSubacceso();
}

function vaciaSubacceso(){
          set_combo('frmParametrosBelcenter.cbSubAcceso',[['','']],['']);
}

function fGuardar() {

  accionGuardar();
}

function accionGuardar() {

	if(!sicc_validaciones_generales()){
	  return false;
	}

	eval('frmParametrosBelcenter').oculto = "S";
	set('frmParametrosBelcenter.conectorAction','LPMantenimientoParametrosBel');

	if (get('frmParametrosBelcenter.casoUso') == "insertar") {
		set('frmParametrosBelcenter.accion','guardar');

	} else if (get('frmParametrosBelcenter.casoUso') == "modificarParametros") {
 		set('frmParametrosBelcenter.accion','guardarModificacion');
	}

	set('frmParametrosBelcenter.hNombreAdministrador',get('frmParametrosBelcenter.cbAdministradorBel','T'));

	enviaSICC('frmParametrosBelcenter');
}

function guardarCorrecto() {
	if (get(vCasoUso) == "modificarParametros") {
		window.close();
	} else {
		fLimpiar();

		configurarPaginado(	mipgndo3, 
							"BELObtenerParametrosBEL", 
							"ConectorObtenerParametrosBEL",
							"es.indra.sicc.dtos.bel.DTOBusquedaParametrosBEL",
							[["oidPais", get(vPais)],
							 ["oidIdioma", get(vIdioma)]]);
	}

}

function guardarError() {
}

function fBorrar() {
    accionEliminar();
}

function poneManito(nombre) {
	document.frmParametrosBelcenter.lupa.style.cursor = "hand";
}

function fLimpiar() {
	if (
		(get('frmParametrosBelcenter.casoUso') == "insertar") || 
		(get('frmParametrosBelcenter.casoUso') == "modificarParametros")
	   ) {
		set('frmParametrosBelcenter.txtCodCliente', '');
		set('frmParametrosBelcenter.txtMontoMaxDife', '');
		set('frmParametrosBelcenter.txtLimiteCaja', '');
		set('frmParametrosBelcenter.txtNumeroCajas', '');
		set('frmParametrosBelcenter.txtTiempoReposicion', '');
		set('frmParametrosBelcenter.txtFactorLocal', '');
		set('frmParametrosBelcenter.txtNumMaxProductos', '');
		set('frmParametrosBelcenter.txtAlertaStock', '');
		set('frmParametrosBelcenter.txtDireccion', '');
		set('frmParametrosBelcenter.txtTelefono', '');
		set('frmParametrosBelcenter.txtNombreLocal', '');

		set('frmParametrosBelcenter.cbAdministradorBel','');
		set('frmParametrosBelcenter.cbMovStockTransito','');
		set('frmParametrosBelcenter.cbMovConfirmarStockTransito','');
		set('frmParametrosBelcenter.cbMovReg','');
		set('frmParametrosBelcenter.cbMovRegSap','');
		set('frmParametrosBelcenter.cbDevolverStockExist','');
		set('frmParametrosBelcenter.cbMovPetExist','');
		set('frmParametrosBelcenter.cbMovConfirmarStock','');
		set('frmParametrosBelcenter.cbMovStockDev','');
		set('frmParametrosBelcenter.cbTipoMovCob','');
		set('frmParametrosBelcenter.cbSociedad','');
		set('frmParametrosBelcenter.cbTipoMovCierre','');
		set('frmParametrosBelcenter.cbTipoTransaccion','');
		set('frmParametrosBelcenter.cbCuentaCCC','');


		if (get('frmParametrosBelcenter.casoUso') == "insertar") {
			set('frmParametrosBelcenter.cbCanal','');
			set_combo('frmParametrosBelcenter.cbAcceso',[['','']],['']);
			set_combo('frmParametrosBelcenter.cbSubAcceso',[['','']],['']);
			focaliza('frmParametrosBelcenter.cbCanal','');
		} else {
			focaliza('frmParametrosBelcenter.txtDireccion','');
		}
	}
}

function focoBel(campo) {
	focaliza('frmParametrosBelcenter.' + campo);
}


function setTabCampos(campo){

	if (campo == 'txtCodCliente'){
		focoBel('txtMontoMaxDife');

	} else if (campo == 'txtMontoMaxDife'){
		focoBel('txtLimiteCaja');

	} else if (campo == 'txtLimiteCaja'){
		focoBel('txtNumeroCajas');

	} else if (campo == 'txtNumeroCajas'){
		focoBel('txtTiempoReposicion');
	
	} else if (campo == 'txtTiempoReposicion'){
		focoBel('cbAdministradorBel');
	
	} else if (campo == 'cbAdministradorBel'){
		focoBel('txtFactorLocal');
	
	} else if (campo == 'txtFactorLocal'){
		focoBel('txtNumMaxProductos');
	
	} else if (campo == 'txtNumMaxProductos'){
		focoBel('txtAlertaStock');
	
	} else if (campo == 'txtAlertaStock'){
		focoBel('cbMovStockTransito');
	
	} else if (campo == 'cbMovStockTransito'){
		focoBel('cbMovConfirmarStock');
	
	} else if (campo == 'cbMovConfirmarStock'){
		focoBel('cbMovReg');
	
	} else if (campo == 'cbMovReg'){
		focoBel('cbMovRegSap');
	
	} else if (campo == 'cbMovRegSap'){
		focoBel('cbDevolverStockExist');
	
	} else if (campo == 'cbDevolverStockExist'){
		focoBel('cbMovPetExist');
	
	} else if (campo == 'cbMovPetExist'){
		focoBel('cbMovConfirmarStockTransito');
	
	} else if (campo == 'cbMovConfirmarStockTransito'){
		focoBel('cbMovStockDev');
	
	} else if (campo == 'cbMovStockDev'){
		focoBel('cbTipoMovCob');
	
	} else if (campo == 'cbTipoMovCob'){
		focoBel('cbSociedad');
	
	} else if (campo == 'cbSociedad'){
		focoBel('cbCuentaCCC');
	
	} else if (campo == 'cbCuentaCCC'){
		focoBel('cbTipoMovCierre');
	
	} else if (campo == 'cbTipoMovCierre'){
		focoBel('cbTipoTransaccion');
	
	} else if (campo == 'cbTipoTransaccion'){
		if (get(vCasoUso) == "insertar") {
			focoBel('cbCanal');
		} else {
			focoBel('txtDireccion');
		}

	} else if (campo == 'cbCanal'){
		focoBel('cbAcceso');
	
	} else if (campo == 'cbAcceso'){
		focoBel('cbSubAcceso');
	
	} else if (campo == 'cbSubAcceso'){
		focoBel('txtDireccion');
	
	} else if (campo == 'txtDireccion'){
		focoBel('txtTelefono');
	
	} else if (campo == 'txtTelefono'){
		focoBel('txtNombreLocal');
	
	} else if (campo == 'txtNombreLocal'){
		focoBel('txtCodCliente');
	}
}

function setShTabCampos(campo){

	if (campo == 'txtCodCliente'){
		focoBel('txtNombreLocal');

	} else if (campo == 'txtMontoMaxDife'){
		focoBel('txtCodCliente');
	
	} else if (campo == 'txtLimiteCaja'){
		focoBel('txtMontoMaxDife');
	
	} else if (campo == 'txtNumeroCajas'){
		focoBel('txtLimiteCaja');
	
	} else if (campo == 'txtTiempoReposicion'){
		focoBel('txtNumeroCajas');
	
	} else if (campo == 'cbAdministradorBel'){
		focoBel('txtTiempoReposicion');
	
	} else if (campo == 'txtFactorLocal'){
		focoBel('cbAdministradorBel');
	
	} else if (campo == 'txtNumMaxProductos'){
		focoBel('txtFactorLocal');
	
	} else if (campo == 'txtAlertaStock'){
		focoBel('txtNumMaxProductos');
	
	} else if (campo == 'cbMovStockTransito'){
		focoBel('txtAlertaStock');
	
	} else if (campo == 'cbMovConfirmarStock'){
		focoBel('cbMovStockTransito');
	
	} else if (campo == 'cbMovReg'){
		focoBel('cbMovConfirmarStock');
	
	} else if (campo == 'cbMovRegSap'){
		focoBel('cbMovReg');
	
	} else if (campo == 'cbDevolverStockExist'){
		focoBel('cbMovRegSap');
	
	} else if (campo == 'cbMovPetExist'){
		focoBel('cbDevolverStockExist');
	
	} else if (campo == 'cbMovConfirmarStockTransito'){
		focoBel('cbMovPetExist');
	
	} else if (campo == 'cbMovStockDev'){
		focoBel('cbMovConfirmarStockTransito');
	
	} else if (campo == 'cbTipoMovCob'){
		focoBel('cbMovStockDev');
	
	} else if (campo == 'cbSociedad'){
		focoBel('cbTipoMovCob');
	
	} else if (campo == 'cbCuentaCCC'){
		focoBel('cbSociedad');
	
	} else if (campo == 'cbTipoMovCierre'){
		focoBel('cbCuentaCCC');
	
	} else if (campo == 'cbTipoTransaccion'){
		focoBel('cbTipoMovCierre');
	
	} else if (campo == 'cbCanal'){
		focoBel('cbTipoTransaccion');

	} else if (campo == 'cbAcceso'){
		focoBel('cbCanal');
	
	} else if (campo == 'cbSubAcceso'){
		focoBel('cbAcceso');
	
	} else if (campo == 'txtDireccion'){
		if (get(vCasoUso) == "insertar") {
			focoBel('cbSubAcceso');
		} else {
			focoBel('cbTipoTransaccion');
		}
		
	} else if (campo == 'txtTelefono'){
		focoBel('txtDireccion');
	
	} else if (campo == 'txtNombreLocal'){
		focoBel('txtTelefono');
	}

}

function mostrarDatosSeleccionados() {
	combosASeleccionar = new Array(vCbCanal, vCbAcceso, vCbSubAcceso, vCbMovStockDev, vCbTipoMovCob, 
		vCbMovConfirmarStock, vCbMovStockTransito, vCbMovConfirmarStockTransito, vCbMovReg,
		vCbMovRegSap, vCbDevolverStockExist, vCbTipoMovCierre, vCbCuentaCCC, vCbSociedad,
		vCbTipoTransaccion, vCbAdministradorBel, vCbMovPetExist);

	valoresSeleccionados = new Array(vHCbCanal, vHCbAcceso, vHCbSubAcceso, vHCbMovStockDev,
		vHCbTipoMovCob, vHCbMovConfirmarStock, vHCbMovStockTransito, vHCbMovConfirmarStockTransito,
		vHCbMovReg, vHCbMovRegSap, vHCbDevolverStockExist, vHCbTipoMovCierre, vHCbCuentaCCC,
		vHCbSociedad, vHCbTipoTransaccion, vHCbAdministradorBel, vHCbMovPetExist);
		
	seleccionadosPor = new Array('oid', 'oid', 'oid', 'oid', 'oid', 'oid', 'oid', 'oid', 'oid',
		'oid', 'oid', 'oid', 'oid', 'oid', 'oid', 'descripcion', 'oid');

	seleccionarCombos(combosASeleccionar, valoresSeleccionados, seleccionadosPor);
}

function deshabilitarCombosTextos(combos, textos, valor) {
	if (combos != null && valor == 'true' || valor == 'false') {
		for (var i = 0; i < combos.length; i++) {
			accion(combos[i], '.disabled=' + valor);
		}

		if (textos != null) {
			for (var i = 0; i < textos.length; i++) {
				accion(textos[i], '.disabled=' + valor);
			}
		}
	}
}

function seleccionarCombos(combosASeleccionar, valoresSeleccionados, seleccionadosPor) {
	if (combosASeleccionar != null && valoresSeleccionados != null && seleccionadosPor != null &&
		combosASeleccionar.length == valoresSeleccionados.length && combosASeleccionar.length == seleccionadosPor.length) {
		for (var i = 0; i < combosASeleccionar.length; i++) {
			if (seleccionadosPor[i] == 'oid') {
				iSeleccionado = new Array();
				iSeleccionado[0] = get(valoresSeleccionados[i]);
				set(combosASeleccionar[i], iSeleccionado);
			} else if (seleccionadosPor[i] == 'descripcion') {
				var elemento = document.getElementById(obtenerElemento(combosASeleccionar[i].replace(formulario + '.','')));
				var opciones = elemento.options;
				var valor = get(valoresSeleccionados[i]);

				for (var j = 0; j < opciones.length; j++) {
					if (valor == opciones[j].text) {
						var iSeleccionado = new Array(); 
						var oid = opciones[j].value;
						iSeleccionado[0] = oid;
						set(combosASeleccionar[i], iSeleccionado);
					}
				}
			}
		}
	}
}

function obtenerElemento(combosASeleccionar) {
	return combosASeleccionar.replace(formulario + '.','');
}

function fVolver() {
		window.returnValue = null; // Para que no actualice el LISTADO si no se 'guardó' correctamente.
		window.close();
}
