function onLoadPag(){
	configurarMenuSecundario("formulario");
	eval(ON_RSZ);

	var oidPeriodoActual = get('formulario.hOidPeriodoActual');
	if (oidPeriodoActual != ''){
		set('formulario.cbPeriodoCerrar', new Array(oidPeriodoActual));
		focaliza('formulario.cbPeriodoCerrar');
	} else {
		focaliza('formulario.cbMarca');
	}

	var oidPeriodoPosteriorActual = get('formulario.hOidPeriodoPosteriorActual');
	if (oidPeriodoPosteriorActual != ''){
		set('formulario.cbPeriodoActivar', new Array(oidPeriodoPosteriorActual));
	}

	var oidMarca = get('formulario.hOidMarca');
	if (oidMarca != '') {
		set('formulario.cbMarca', new Array(oidMarca));
	}

	var oidCanal = get('formulario.hOidCanal');
	if (oidCanal != '') {
		set('formulario.cbCanal', new Array(oidCanal));
	}
}

function fLimpiar() {
	set('formulario.cbMarca', new Array(''));
	set('formulario.cbCanal', new Array(''));
	onChangeMarcaCanal();
}

function onChangeMarcaCanal() {
	if (get('formulario.cbMarca') != '' && get('formulario.cbCanal') != '') {

		//Llamar a LP con accion 'recargarPeriodos'
		set('formulario.hOidMarca', get('formulario.cbMarca')[0]);
		set('formulario.hOidCanal', get('formulario.cbCanal')[0]);
		set('formulario.conectorAction', 'LPActivarCerrarConcursos');
		set('formulario.accion', 'recargarPeriodos');
		eval('formulario').oculto = 'N';
		enviaSICC('formulario');

	} else {
		set_combo('formulario.cbPeriodoCerrar', new Array(['', '']));
		set_combo('formulario.cbPeriodoActivar', new Array(['', '']));
		set('formulario.hOidMarca', '');
		set('formulario.hOidCanal', '');
	}
}

function afterRecargaPeriodos() {
	var oidPeriActual = get('formulario.hOidPeriodoActual');
	var oidPeriPost = get('formulario.hOidPeriodoPosteriorActual');

	set('formulario.cbPeriodoCerrar', new Array(oidPeriActual));
	set('formulario.cbPeriodoActivar', new Array(oidPeriPost));
}

function onClickBtnCerrarConcursos() {
	if (! sicc_validaciones_generales()) {
		return;
	}
	
	if (get('formulario.cbPeriodoCerrar') == '') {
		GestionarMensaje('INC063');
		return;
	}
	
	// Verifico si se selecciono el periodo actual
	// A partir de eso, seteo la "variable de entorno"
	if (get('formulario.cbPeriodoCerrar') != get('formulario.hOidPeriodoActual')) {
		var continuar = GestionarMensaje('INC064');
		if (continuar) {
			set('formulario.hVariableEntorno', 'false');
		} else {
			return;
		}
	} else {
		set('formulario.hVariableEntorno', 'true');
	}

	// Llamo a la LP con accion 'cerrar' y el OID del periodo seleccionado

	set('formulario.hOidPeriodoCerrar', get('formulario.cbPeriodoCerrar')[0]);
	set('formulario.conectorAction', 'LPActivarCerrarConcursos');
	set('formulario.accion', 'cerrar');
	eval('formulario').oculto = 'S';

	enviaSICC('formulario');
}

function onClickBtnActivarConcursos() {
	if (! sicc_validaciones_generales()) {
		return;
	}
	
	if (get('formulario.cbPeriodoActivar') == '') {
		GestionarMensaje('INC062');
		return;
	}
	
	if (get('formulario.cbPeriodoActivar') != get('formulario.hOidPeriodoActual')) {
		var continuar = GestionarMensaje('INC064');
		if (!continuar) {
			return;
		}
	}

	// Llamo a la LP con accion 'activar' y el OID del periodo seleccionado

	set('formulario.hOidPeriodoActivar', get('formulario.cbPeriodoActivar')[0]);
	set('formulario.conectorAction', 'LPActivarCerrarConcursos');
	set('formulario.accion', 'activar');
	eval('formulario').oculto = 'S';
	enviaSICC('formulario');
}

function ok() {
	set('formulario.conectorAction', 'LPActivarCerrarConcursos');
	set('formulario.accion', '');
	eval('formulario').oculto = 'N';
	enviaSICC('formulario');
}

function onTab(campo) {
	switch(campo) {
		case "cbMarca": focaliza('formulario.cbCanal'); break;
		case "cbCanal": focaliza('formulario.cbPeriodoCerrar'); break;
		case "cbPeriodoCerrar": focalizaBotonHTML('botonContenido','btnCerrarConcursos'); break;
		case "btnCerrarConcursos": focaliza('formulario.cbPeriodoActivar'); break;
		case "cbPeriodoActivar": focalizaBotonHTML('botonContenido','btnActivarConcursos'); break;
		case "btnActivarConcursos": focaliza('formulario.cbMarca'); break;
	}
}

function onShiftTab(campo) {
	switch(campo) {
		case "cbMarca": focalizaBotonHTML('botonContenido','btnActivarConcursos'); break;
		case "cbCanal": focaliza('formulario.cbMarca'); break;
		case "cbPeriodoCerrar": focaliza('formulario.cbCanal'); break;
		case "btnCerrarConcursos": focaliza('formulario.cbPeriodoCerrar'); break;
		case "cbPeriodoActivar": focalizaBotonHTML('botonContenido','btnCerrarConcursos'); break;
		case "btnActivarConcursos": focaliza('formulario.cbPeriodoActivar'); break;
	}
}