function onLoadPag() {
	configurarMenuSecundario('formulario');
	var acc = get('formulario.accion');
	if (acc == 'modificar') {
		
		// Deshabilito el campo codigo tipo bloqueo
		accion('formulario.txtCodTipoBloqueo', '.disabled = true');

		// Seteo los valores de los campos
		set('formulario.txtCodTipoBloqueo', get('formulario.hCodTipoBloqueo'));
		set('formulario.txtDescripcion', get('formulario.hDescripcion'));
		var indBloqFina = get('formulario.hIndBloqueoFinanciero');
		if (indBloqFina == GestionarMensaje('1010')) {
			set('formulario.chkBloqueoFinanciero', 'S');
		} else if (indBloqFina == GestionarMensaje('1011')) {
			set('formulario.chkBloqueoFinanciero', 'N');
		}
		set('formulario.cbFormaBloqueo', new Array(get('formulario.hOidFormaBloqueo')));
		set('formulario.cbFormaDesbloqueo', new Array(get('formulario.hOidFormaDesbloqueo')));
		set('formulario.txtNivelGravedad', get('formulario.hNivelGravedad'));
		set('formulario.cbMotivoRechazo', new Array(get('formulario.hOidMotivoRechazo')));

		// Seteo el foco
		focaliza('formulario.txtDescripcion');

	} else if (acc == 'detalle') {

		// Seteo los campos con los valores a mostrar
		set('formulario.txtCodTipoBloqueo', get('formulario.hCodTipoBloqueo'));
		set('formulario.txtDescripcion', get('formulario.hDescripcion'));
		var indBloqFina = get('formulario.hIndBloqueoFinanciero');
		if (indBloqFina == GestionarMensaje('1010')) {
			set('formulario.chkBloqueoFinanciero', 'S');
		} else if (indBloqFina == GestionarMensaje('1011')) {
			set('formulario.chkBloqueoFinanciero', 'N');
		}
		set_combo('formulario.cbFormaBloqueo', [ ['', get('formulario.hDescFormaBloqueo')] ], ['']);
		set_combo('formulario.cbFormaDesbloqueo', [ ['', get('formulario.hDescFormaDesbloqueo')] ], ['']);
		set('formulario.txtNivelGravedad', get('formulario.hNivelGravedad'));
		set_combo('formulario.cbMotivoRechazo', [ ['', get('formulario.hDescMotivoRechazo')] ], ['']);

		// Deshabilito todos los campos
		accion('formulario.txtCodTipoBloqueo', '.disabled = true');
		accion('formulario.txtDescripcion', '.disabled = true');
		accion('formulario.chkBloqueoFinanciero', '.disabled = true');
		accion('formulario.cbFormaBloqueo', '.disabled = true');
		accion('formulario.cbFormaDesbloqueo', '.disabled = true');
		accion('formulario.txtNivelGravedad', '.disabled = true');
		accion('formulario.cbMotivoRechazo', '.disabled = true');

	} else if (acc == '') {
		focaliza('formulario.txtCodTipoBloqueo');
	}
}

function onChangeChkBloqueoFinanciero() {
	if (get('formulario.chkBloqueoFinanciero') == 'S'){
		eval('formulario').oculto = 'S';
		set('formulario.conectorAction', 'LPMantenimientoTipoBloqueo');
		set('formulario.accion', 'validarBloqueoFinanciero');
		enviaSICC('formulario');
	}
}

function fGuardar() {
	if (! sicc_validaciones_generales()) {
		return false;
	}

	// Valido aparte el nivel de gravedad para mostrar el mensaje correspondiente
	var nivelGravedad = get('formulario.txtNivelGravedad')
	if (nivelGravedad == '' || isNaN(Number(nivelGravedad)) || Number(nivelGravedad) <= 0) {
		GestionarMensaje("MAE0049");
		return false;
	}

	// Paso los valores de los campos a las variables hidden
	set('formulario.hCodTipoBloqueo', get('formulario.txtCodTipoBloqueo'));
	set('formulario.hDescripcion', get('formulario.txtDescripcion'));
	set('formulario.hIndBloqueoFinanciero', get('formulario.chkBloqueoFinanciero'));
	set('formulario.hOidFormaBloqueo', get('formulario.cbFormaBloqueo', 'V'));
	set('formulario.hOidFormaDesbloqueo', get('formulario.cbFormaDesbloqueo', 'V'));
	set('formulario.hNivelGravedad', get('formulario.txtNivelGravedad'));
	set('formulario.hOidMotivoRechazo', get('formulario.cbMotivoRechazo', 'V'));

	// Llamo a la LP
	set('formulario.conectorAction', 'LPMantenimientoTipoBloqueo');
    set('formulario.accion', 'guardar');
	eval('formulario').oculto = 'S';
    enviaSICC('formulario');

}

function mostrarMsjExisteBloqFinanciero() {
	GestionarMensaje('MAE0048');
}


function guardoCorrectamente() {
	if (get('formulario.opcionMenu') == 'insertar') {
		fLimpiar();
	}
}

function fLimpiar() {
	
    limpiaI18N("formulario", 1);
	if (get('formulario.opcionMenu') == 'insertar') {
		set('formulario.txtCodTipoBloqueo', '');
		set('formulario.txtDescripcion', '');
		set('formulario.chkBloqueoFinanciero', '');
		set('formulario.cbFormaBloqueo', new Array(''));
		set('formulario.cbFormaDesbloqueo', new Array(''));
		set('formulario.txtNivelGravedad', '');
		set('formulario.cbMotivoRechazo', new Array(''));
	} else {
		set('formulario.txtCodTipoBloqueo', get('formulario.hCodTipoBloqueo'));
		set('formulario.txtDescripcion', get('formulario.hDescripcion'));
		set('formulario.cbFormaBloqueo', new Array(get('formulario.hOidFormaBloqueo')));
		set('formulario.cbFormaDesbloqueo', new Array(get('formulario.hOidFormaDesbloqueo')));
		set('formulario.txtNivelGravedad', get('formulario.hNivelGravedad'));
		set('formulario.cbMotivoRechazo', new Array(get('formulario.hOidMotivoRechazo')));

		var indBloqFina = get('formulario.hIndBloqueoFinanciero');
		if (indBloqFina == GestionarMensaje('1010')) {
			set('formulario.chkBloqueoFinanciero', 'S');
		} else if (indBloqFina == GestionarMensaje('1011')) {
			set('formulario.chkBloqueoFinanciero', 'N');
		}
	}
}

function fVolver() {
	window.close();
}

function onTab(campo) {
	if (campo == 'txtCodTipoBloqueo') {
		focaliza('formulario.txtDescripcion');
	} else if (campo == 'txtDescripcion') {
		focaliza('formulario.chkBloqueoFinanciero');
	} else if (campo == 'chkBloqueoFinanciero') {
		focaliza('formulario.cbFormaBloqueo');
	} else if (campo == 'cbFormaBloqueo') {
		focaliza('formulario.cbFormaDesbloqueo');
	} else if (campo == 'cbFormaDesbloqueo') {
		focaliza('formulario.txtNivelGravedad');
	} else if (campo == 'txtNivelGravedad') {
		focaliza('formulario.cbMotivoRechazo');
	} else if (campo == 'cbMotivoRechazo') {
		focaliza('formulario.txtCodTipoBloqueo');
	}
}

function onShiftTab(campo) {
	if (campo == 'txtCodTipoBloqueo') {
		focaliza('formulario.cbMotivoRechazo');
	} else if (campo == 'txtDescripcion') {
		focaliza('formulario.txtCodTipoBloqueo');
	} else if (campo == 'chkBloqueoFinanciero') {
		focaliza('formulario.txtDescripcion');
	} else if (campo == 'cbFormaBloqueo') {
		focaliza('formulario.chkBloqueoFinanciero');
	} else if (campo == 'cbFormaDesbloqueo') {
		focaliza('formulario.cbFormaBloqueo');
	} else if (campo == 'txtNivelGravedad') {
		focaliza('formulario.cbFormaDesbloqueo');
	} else if (campo == 'cbMotivoRechazo') {
		focaliza('formulario.txtNivelGravedad');
	}
}