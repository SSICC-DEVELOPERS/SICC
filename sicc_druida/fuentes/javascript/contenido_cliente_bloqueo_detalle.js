function onLoadPag() {
	configurarMenuSecundario('formulario');
	txt_to('lblTxtCodCliente', get('formulario.hCodCliente'));
	txt_to('lblTxtNombre1', get('formulario.hNombre1'));
	txt_to('lblTxtNombre2', get('formulario.hNombre2'));
	txt_to('lblTxtApellido1', get('formulario.hApellido1'));
	txt_to('lblTxtApellido2', get('formulario.hApellido2'));
	txt_to('lblTxtTipobloqueo', get('formulario.hDescTipoBloqueo'));
	txt_to('lblTxtFechaBloqueo', get('formulario.hFechaBloqueo'));
	txt_to('lblTxtIndicadorBloqueo', get('formulario.hIndicadorBloqueo'));
	txt_to('lblTxtUsuarioBloqueo', get('formulario.hUsuarioBloqueo'));
	txt_to('lblTxtUsuarioDesbloqueo', get('formulario.hUsuarioDesbloqueo'));
	txt_to('lblTxtFechaDesbloqueo', get('formulario.hFechaDesbloqueo'));
	txt_to('lblTxtIndicadorDesbloqueo', get('formulario.hIndicadorDesbloqueo'));
	txt_to('lblTxtMotivoBloqueo', get('formulario.hMotivoBloqueo'));

	set('formulario.txtObservBloqueo', get('formulario.hObservBloqueo'));
	set('formulario.txtObservDesbloqueo', get('formulario.hObservDesbloqueo'));

	accion('formulario.chkBloqueado', '.disabled = true');
}

function fVolver() {
	window.close();
}
