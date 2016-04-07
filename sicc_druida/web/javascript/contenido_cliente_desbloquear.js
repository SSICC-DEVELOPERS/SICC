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

	focaliza('formulario.txtObservDesbloqueo');
}

function fGuardar() {
	if (! sicc_validaciones_generales()) {
		return false;
	}

	set('formulario.hObservDesbloqueo', get('formulario.txtObservDesbloqueo'));

	eval('formulario').oculto = 'S';
	set('formulario.conectorAction', 'LPBloquearDesbloquearCliente');
	set('formulario.accion', 'guardarBloqueo');
	set('formulario.casoDeUso', 'desbloquear');
	enviaSICC('formulario');
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

	set('formulario.txtObservDesbloqueo', '');
}

function fGuardarOK() {
         window.returnValue = true;
}

function fGuardarError() {
         window.returnValue = false;
}

function fVolver() {
	window.close();
}

function onTab(campo) {
	if (campo == 'txtObservDesbloqueo') {
		focaliza('formulario.txtObservDesbloqueo');
	}
}

function onShiftTab(campo) {
	if (campo == 'txtObservDesbloqueo') {
		focaliza('formulario.txtObservDesbloqueo');
	}
}
