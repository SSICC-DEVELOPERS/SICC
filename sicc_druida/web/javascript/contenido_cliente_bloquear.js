function onLoadPag() {
	configurarMenuSecundario('formulario');
	txt_to('lblTxtCodCliente', get('formulario.hCodCliente'));
	txt_to('lblTxtNombre1', get('formulario.hNombre1'));
	txt_to('lblTxtNombre2', get('formulario.hNombre2'));
	txt_to('lblTxtApellido1', get('formulario.hApellido1'));
	txt_to('lblTxtApellido2', get('formulario.hApellido2'));
	set('formulario.chkBloqueado', get('formulario.hBloqueado'));
	accion('formulario.chkBloqueado', '.disabled = true');
	focaliza('formulario.cbTipoBloqueo');
}

function fGuardar() {
	if (! sicc_validaciones_generales()) {
		return false;
	}

	set('formulario.hOidTipoBloqueo', get('formulario.cbTipoBloqueo', 'V'));
	set('formulario.hObservBloqueo', get('formulario.txtObservBloqueo'));

	eval('formulario').oculto = 'S';
	set('formulario.conectorAction', 'LPBloquearDesbloquearCliente');
	set('formulario.accion', 'guardarBloqueo');
	set('formulario.casoDeUso', 'bloquear');
	enviaSICC('formulario');
}


function fGuardarOK() {
	window.returnValue = true;
}

function fGuardarError() {
	window.returnValue = false;
}

function fLimpiar() {
	txt_to('lblTxtCodCliente', get('formulario.hCodCliente'));
	txt_to('lblTxtNombre1', get('formulario.hNombre1'));
	txt_to('lblTxtNombre2', get('formulario.hNombre2'));
	txt_to('lblTxtApellido1', get('formulario.hApellido1'));
	txt_to('lblTxtApellido2', get('formulario.hApellido2'));
	set('formulario.cbTipoBloqueo', new Array([]));
	set('formulario.txtMotivoBloqueo', '');
	set('formulario.txtObservBloqueo', '');
}

function fVolver() {
	window.returnValue = false;
	window.close();
}

function onTab(campo) {
	if (campo == 'cbTipoBloqueo') {
		focaliza('formulario.txtMotivoBloqueo');
	} else if (campo == 'txtMotivoBloqueo') {
		focaliza('formulario.txtObservBloqueo');
	} else if (campo == 'txtObservBloqueo') {
		focaliza('formulario.cbTipoBloqueo');
	}
}

function onShiftTab(campo) {
	if (campo == 'cbTipoBloqueo') {
		focaliza('formulario.txtObservBloqueo');
	} else if (campo == 'txtMotivoBloqueo') {
		focaliza('formulario.cbTipoBloqueo');
	} else if (campo == 'txtObservBloqueo') {
		focaliza('formulario.txtMotivoBloqueo');
	}
}
