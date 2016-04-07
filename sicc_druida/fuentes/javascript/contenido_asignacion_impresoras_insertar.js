function onLoad() {
	configurarMenuSecundario('formulario');
	var acc = get('formulario.accion');
	if (acc == 'detalle') {
		// Deshabilito los campos
		accion('formulario.cbImprVirtual', '.disabled = true');
		accion('formulario.cbCanal', '.disabled = true');
		accion('formulario.cbAcceso', '.disabled = true');
		accion('formulario.cbSubAcceso', '.disabled = true');
		accion('formulario.cbFormulario', '.disabled = true');

		// Tomo las descripciones desde las variables hidden
		set_combo('formulario.cbImprVirtual', new Array(['', get('formulario.hImpresora')]));
		set_combo('formulario.cbCanal', new Array(['', get('formulario.hCanal')]));
		set_combo('formulario.cbAcceso', new Array(['', get('formulario.hAcceso')]));
		set_combo('formulario.cbSubAcceso', new Array(['', get('formulario.hSubacceso')]));
		set_combo('formulario.cbFormulario', new Array(['', get('formulario.hFormulario')]));
	} else {
		focaliza('formulario.cbImprVirtual');
	}

}

//-------------------------------------------------------------------------------------

function fLimpiar() {
	set('formulario.cbImprVirtual',new Array(''));
	set('formulario.cbCanal', new Array(''));
	onChangeCanal();
	onChangeAcceso();
	set('formulario.cbFormulario', new Array(''));
}

//-------------------------------------------------------------------------------------

function fGuardar() {
	onClickGuardar();
}


//-------------------------------------------------------------------------------------

function onChangeCanal() {

	var oidCanal = get('formulario.cbCanal','V');
	if (oidCanal != '') {
		
		var array = new Array();
		array[0] = new Array('oid',oidCanal);
		array[1] = new Array('oidIdioma',get('formulario.varIdioma'));

		recargaCombo('formulario.cbAcceso',
					 'SEGObtenerAccesosSinFiltro',
					 'es.indra.sicc.util.DTOOID',
					 array,
					 'setearCbAcceso(datos)');
		set_combo('formulario.cbSubAcceso', new Array(['','']));
	} else {
		set_combo('formulario.cbAcceso', new Array(['','']));
	}
}

//-------------------------------------------------------------------------------------

function setearCbAcceso(datos) {
	var arrayNuevo = new Array();
	arrayNuevo[0] = new Array('','');
	arrayNuevo = arrayNuevo.concat(datos);
	set_combo('formulario.cbAcceso',arrayNuevo);
}

//-------------------------------------------------------------------------------------

function onChangeAcceso() {

	var oidAcceso = get('formulario.cbAcceso','V');
	if (oidAcceso != '') {
		var array = new Array();
		array[0] = new Array('oid', oidAcceso);
		array[1] = new Array('oidIdioma',get('formulario.varIdioma'));
		recargaCombo('formulario.cbSubAcceso',
					 'SEGObtenerSubccesosSinFiltro',
					 'es.indra.sicc.util.DTOOID',
					 array,
					 'setearCbSubacceso(datos)');

	} else {
		set_combo('formulario.cbSubAcceso',new Array(['','']));
	}

}

//-------------------------------------------------------------------------------------

function setearCbSubacceso(datos) {
	var arrayNuevo = new Array();
	arrayNuevo[0] = new Array('','');
	arrayNuevo = arrayNuevo.concat(datos);
	set_combo('formulario.cbSubAcceso',arrayNuevo);
}

//-------------------------------------------------------------------------------------

function onClickGuardar() {
	if (! sicc_validaciones_generales()) {
		return false;
	}

	// Paso los valores de los campos a las variables hidden
	set('formulario.hImpresora', get('formulario.cbImprVirtual', 'V'));
	set('formulario.hSubacceso', get('formulario.cbSubAcceso', 'V'));
	set('formulario.hFormulario', get('formulario.cbFormulario', 'V'));

	// Envio el formulario
	eval('formulario').oculto = 'S';
	set('formulario.conectorAction', 'LPMantenimientoAsignacionImpresoras');
	set('formulario.accion', 'guardar');
	enviaSICC('formulario');
}


//-------------------------------------------------------------------------------------

function guardoCorrectamente(opcionMenu) {
	if (opcionMenu == 'insertar') {
		fLimpiar();
	}
}

//-------------------------------------------------------------------------------------

function noPudoGuardar() {

}

//-------------------------------------------------------------------------------------

function fVolver() {
	window.close();
}

//-------------------------------------------------------------------------------------

function onTab(campoActual) {

	if (campoActual == 'cbImprVirtual') {
		focaliza('formulario.cbCanal');
	} else if (campoActual == 'cbCanal') {
		focaliza('formulario.cbAcceso');
	} else if (campoActual == 'cbAcceso') {
		focaliza('formulario.cbSubAcceso');
	} else if (campoActual == 'cbSubAcceso') {
		focaliza('formulario.cbFormulario');
	} else if (campoActual == 'cbFormulario') {
		focaliza('formulario.cbImprVirtual');
	}
}

//-------------------------------------------------------------------------------------

function onShiftTab(campoActual) {

	if (campoActual == 'cbImprVirtual') {
		focaliza('formulario.cbFormulario');
	} else if (campoActual == 'cbCanal') {
		focaliza('formulario.cbImprVirtual');
	} else if (campoActual == 'cbAcceso') {
		focaliza('formulario.cbCanal');
	} else if (campoActual == 'cbSubAcceso') {
		focaliza('formulario.cbAcceso');
	} else if (campoActual == 'cbFormulario') {
		focaliza('formulario.cbSubAcceso');
	}
}