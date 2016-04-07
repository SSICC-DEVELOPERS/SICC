/**
 * Copyright 2009 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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

function onLoadPag(){	 
	configurarMenuSecundario('formulario');
	eval (ON_RSZ);
	focaliza('formulario.cbMarca');
}

function onChangeMarcaCanal(){

	var marca = get('formulario.cbMarca', 'V');
	var canal = get('formulario.cbCanal', 'V');

	if (canal != "" && marca != "") {

		var oidPais = get('formulario.varPais');
		var oidIdioma = get('formulario.varIdioma');
		var datosDTO = [["marca",marca],["canal",canal],["oidIdioma",oidIdioma],["oidPais",oidPais]];

		// De acuerdo a marca-canal seleccionados, cargo el combo de periodos...
		var idBusiness = "CRAObtienePeriodos";
		var claseDTO = "es.indra.sicc.dtos.cra.DTOPeriodo";
		recargaCombo('formulario.cbPeriodo', idBusiness, claseDTO, datosDTO);

		// ... y tambien el de subgerencia de ventas
		idBusiness = "ZONRecargaSubgerenciaVentas";
		claseDTO = "es.indra.sicc.dtos.zon.DTOUnidadAdministrativa";	
		datosDTO = [["oidMarca",marca],["oidCanal",canal],["oidIdioma",oidIdioma],["oidPais",oidPais]];
		recargaCombo('formulario.cbSubgerenciaVentas', idBusiness, claseDTO, datosDTO);

	} else {
		vaciaCombo('formulario.cbPeriodo');
		vaciaCombo('formulario.cbSubgerenciaVentas');
		onChangeSubgerenciaVentas();
	}	

}


function onChangeSubgerenciaVentas() {

	var subgerencia = get('formulario.cbSubgerenciaVentas', 'V');
	if (subgerencia != "") {
		var oidPais = get('formulario.varPais');
		var oidIdioma = get('formulario.varIdioma');
		var marca = get('formulario.cbMarca', 'V');
		var canal = get('formulario.cbCanal', 'V');
		var datosDTO = [["oidMarca",marca],["oidCanal",canal],["oidIdioma",oidIdioma],["oidPais",oidPais], ["oidSGV", subgerencia]];
		var idBusiness = "ZONRecargaRegiones";
		var claseDTO = "es.indra.sicc.dtos.zon.DTOUnidadAdministrativa";	
		recargaCombo('formulario.cbRegion', idBusiness, claseDTO, datosDTO);
	} else {
		vaciaCombo('formulario.cbRegion');
		onChangeRegion();
	}

}

function onChangeRegion() {
	var region = get('formulario.cbRegion', 'V');
	if (region != "") {
		var oidPais = get('formulario.varPais');
		var oidIdioma = get('formulario.varIdioma');
		var marca = get('formulario.cbMarca', 'V');
		var canal = get('formulario.cbCanal', 'V');
		var subgerencia = get('formulario.cbSubgerenciaVentas', 'V');
		var datosDTO = [["oidMarca",marca],["oidCanal",canal],["oidIdioma",oidIdioma],["oidPais",oidPais], ["oidSGV", subgerencia], ["oidRegion", region]];
		var idBusiness = "ZONRecargaZonas";
		var claseDTO = "es.indra.sicc.dtos.zon.DTOUnidadAdministrativa";	
		recargaCombo('formulario.cbZona', idBusiness, claseDTO, datosDTO);
	} else {
		vaciaCombo('formulario.cbZona');
	}

}

function vaciaCombo(combo){
           set_combo(combo,[['','']],['']);
}


function onClickGenerar() {
	if(!sicc_validaciones_generales()){
		return;
	}

	set('formulario.hOidPeriodo', get('formulario.cbPeriodo', 'V')[0]);
	set('formulario.hOidZona', get('formulario.cbZona', 'V')[0]);
	set('formulario.accion','generar');
	set('formulario.conectorAction','LPGenerarBoletasRecojoCierreDeZona');

	enviaSICC('formulario');
}

function cerrarVentana() {
	var formulario = getFormularioSICC();
	set(formulario+".conectorAction","LPInicioBelcorp");
	set(formulario+".accion","");
	try {
		parent.frames['menu'].location.reload();
		parent.frames["iconos"].mostrarCapa();
	} catch(e) {

	}
	eval(formulario).oculto = 'N';
	enviaSICC(formulario,'','','N');
}

function fLimpiar(){
	fLimpiarGenericoSICC();
	set('formulario.cbMarca',['']);
	set('formulario.cbCanal',['']);
	onChangeMarcaCanal();
}

function onTab(campo) {
	if (campo == 'cbMarca') {
		focaliza('formulario.cbCanal');
	} else if (campo == 'cbCanal') {
		focaliza('formulario.cbPeriodo');
	} else if (campo == 'cbPeriodo') {
		focaliza('formulario.cbSubgerenciaVentas');
	} else if (campo == 'cbSubgerenciaVentas') {
		focaliza('formulario.cbRegion');
	} else if (campo == 'cbRegion') {
		focaliza('formulario.cbZona');
	} else if (campo == 'cbZona') {
		focalizaBotonHTML('botonContenido','btnGenerar');
	} else if (campo == 'btnGenerar') {
		focaliza('formulario.cbMarca');
	}
}

function onShiftTab(campo) {
	if (campo == 'cbMarca') {
		focalizaBotonHTML('botonContenido','btnGenerar');
	} else if (campo == 'cbCanal') {
		focaliza('formulario.cbMarca');
	} else if (campo == 'cbPeriodo') {
		focaliza('formulario.cbCanal');
	} else if (campo == 'cbSubgerenciaVentas') {
		focaliza('formulario.cbPeriodo');
	} else if (campo == 'cbRegion') {
		focaliza('formulario.cbSubgerenciaVentas');
	} else if (campo == 'cbZona') {
		focaliza('formulario.cbRegion');
	} else if (campo == 'btnGenerar') {
		focaliza('formulario.cbZona');
	}
}