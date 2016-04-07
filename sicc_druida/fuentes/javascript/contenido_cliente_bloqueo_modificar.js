function onLoadPag() {
	configurarMenuSecundario('formulario');
	txt_to('lblTxtCodCliente', get('formulario.hCodCliente'));
	txt_to('lblTxtNombre1', get('formulario.hNombre1'));
	txt_to('lblTxtNombre2', get('formulario.hNombre2'));
	txt_to('lblTxtApellido1', get('formulario.hApellido1'));
	txt_to('lblTxtApellido2', get('formulario.hApellido2'));
	
	accion('formulario.chkBloqueado', '.disabled = true');

	txt_to('lblTxtTipobloqueo', get('formulario.hDescTipoBloqueo'));
	txt_to('lblTxtFechaBloqueo', get('formulario.hFechaBloqueo'));
	txt_to('lblTxtIndicadorBloqueo', get('formulario.hIndicadorBloqueo'));
	txt_to('lblTxtUsuarioBloqueo', get('formulario.hUsuarioBloqueo'));
	txt_to('lblTxtMotivoBloqueo', get('formulario.hMotivoBloqueo'));

	focaliza('formulario.cbTipoBloqueo');
}

function fGuardar() {
	if (! sicc_validaciones_generales()) {
		return false;
	}

	set('formulario.hOidTipoBloqueo', get('formulario.cbTipoBloqueo', 'V'));
	set('formulario.hObservBloqueoNuevo', get('formulario.txtObservBloqueo'));

	eval('formulario').oculto = 'S';
	set('formulario.conectorAction', 'LPBloquearDesbloquearCliente');
	set('formulario.accion', 'guardarBloqueo');
	set('formulario.casoDeUso', 'modificarBloqueo');
	enviaSICC('formulario');
}

function fGuardarOK() {
	window.returnValue = true;
}

function fGuardarError() {
	window.returnValue = false;
	focaliza('formulario.cbTipoBloqueo');
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

function fLimpiar() {
	txt_to('lblTxtCodCliente', get('formulario.hCodCliente'));
	txt_to('lblTxtNombre1', get('formulario.hNombre1'));
	txt_to('lblTxtNombre2', get('formulario.hNombre2'));
	txt_to('lblTxtApellido1', get('formulario.hApellido1'));
	txt_to('lblTxtApellido2', get('formulario.hApellido2'));
	txt_to('lblTxtTipobloqueo', get('formulario.hDescTipoBloqueo'));
	txt_to('lblTxtFechaBloqueo', get('formulario.hFechaBloqueo'));
	txt_to('lblTxtIndicadorBloqueo', get('formulario.hIndicadorBloqueo'));
	txt_to('lblTxtUsuarioBloqueo', get('formulario.hUsuarioBloqueo'));
	txt_to('lblTxtMotivoBloqueo', get('formulario.hMotivoBloqueo'));

	set('formulario.cbTipoBloqueo', new Array());
	set('formulario.txtMotivoBloqueo', '');
	set('formulario.txtObservBloqueo', '');
}

function fVolver() {
	window.returnValue = false;
	window.close();
}
