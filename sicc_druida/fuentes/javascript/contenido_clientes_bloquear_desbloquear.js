function onLoadPag() {
	// Seteo en el combo el primer tipo de documento que sea DNI
	set('formulario.cbTipoDocumento', new Array(get('formulario.hOidTipoDocumentoDNI')));

	configurarMenuSecundario('formulario');
	DrdEnsanchaConMargenDcho('listado1', 12);

	document.all["Cplistado1"].style.visibility='hidden';
	document.all["CpLin1listado1"].style.visibility='hidden';
	document.all["CpLin2listado1"].style.visibility='hidden';
	document.all["CpLin3listado1"].style.visibility='hidden';
	document.all["CpLin4listado1"].style.visibility='hidden';
	document.all["primera1Div"].style.visibility='hidden';
	document.all["ret1Div"].style.visibility='hidden';
	document.all["ava1Div"].style.visibility='hidden';
	document.all["separaDiv"].style.visibility='hidden';
	document.all["btnBloquearDiv"].style.visibility='hidden';
	document.all["btnConsultaDetalleDiv"].style.visibility='hidden';
	document.all["btnConsultaHistoricoDiv"].style.visibility='hidden';
	document.all["btnDesbloquearDiv"].style.visibility='hidden';

	eval(ON_RSZ);
	focaliza('formulario.txtCodCliente');
}

function onBlurTxtCodCliente() {
	var codCliente = get('formulario.txtCodCliente');
	if (codCliente != '') {
		var longitudCodigoCliente = get('formulario.hLongitudCodCliente');
		var longitud = codCliente.length;
		set('formulario.txtCodCliente',rellenaCeros(codCliente,longitudCodigoCliente,longitud));
	}
}

function onClickBuscar() {

	var codCliente = get('formulario.txtCodCliente');
	var nombre1 = get('formulario.txtNombre1');
	var nombre2 = get('formulario.txtNombre2');
	var apellido1 = get('formulario.txtApellido1');
	var apellido2 = get('formulario.txtApellido2');
	var tipoDocumento = get('formulario.cbTipoDocumento', 'V');
	var numeroDocumento = get('formulario.txtNumeroDocumento');

	// Verifico si se ingresó al menos un criterio de búsqueda
	if (codCliente == '' && nombre1 == '' && nombre2 == ''
			&& apellido1 == '' && apellido2 == ''
			&& tipoDocumento == '' && numeroDocumento == '') {

		GestionarMensaje('MAE0050');
		return;

	}

	var parametros = new Array();
	if (codCliente != ''){
		parametros[parametros.length] = new Array('codigo', codCliente);
	}
	if (nombre1 != ''){
		parametros[parametros.length] = new Array('nombre1', nombre1);
	}
	if (nombre2 != ''){
		parametros[parametros.length] = new Array('nombre2', nombre2);
	}
	if (apellido1 != ''){
		parametros[parametros.length] = new Array('apellido1', apellido1);
	}
	if (apellido2 != ''){
		parametros[parametros.length] = new Array('apellido2', apellido2);
	}
	if (tipoDocumento != ''){
		parametros[parametros.length] = new Array('oidTipoDocumento', tipoDocumento);
	}
	if (numeroDocumento != ''){
		parametros[parametros.length] = new Array('documentoIdentificacion', numeroDocumento);
	}

	configurarPaginado(mipgndo,'MAEBuscarBloqueosClientes',
	                   'ConectorBuscarBloqueosClientes',
	                   'es.indra.sicc.dtos.mae.DTOBuscarClienteBloqueo',
	                   parametros);
}

function muestraLista(ultima, rowset) {
	var tamano = rowset.length;
	if (tamano > 0) {
		mostrarLista();
		return true; 
	}else{
		ocultarLista();
		focaliza('formulario.txtCodCliente');
		return false;  
	}
}

function mostrarLista(){

	DrdEnsanchaConMargenDcho('listado1',12);
	document.all["Cplistado1"].style.visibility='visible';
	document.all["CpLin1listado1"].style.visibility='visible';
	document.all["CpLin2listado1"].style.visibility='visible';
	document.all["CpLin3listado1"].style.visibility='visible';
	document.all["CpLin4listado1"].style.visibility='visible';
	document.all["primera1Div"].style.visibility='visible';
	document.all["ret1Div"].style.visibility='visible';
	document.all["ava1Div"].style.visibility='visible';
	document.all["separaDiv"].style.visibility='visible';
	document.all["btnBloquearDiv"].style.visibility='visible';
	document.all["btnConsultaDetalleDiv"].style.visibility='visible';
	document.all["btnConsultaHistoricoDiv"].style.visibility='visible';
	document.all["btnDesbloquearDiv"].style.visibility='visible';

	eval (ON_RSZ);
}

function ocultarLista() {
	document.all["Cplistado1"].style.visibility='hidden';
	document.all["CpLin1listado1"].style.visibility='hidden';
	document.all["CpLin2listado1"].style.visibility='hidden';
	document.all["CpLin3listado1"].style.visibility='hidden';
	document.all["CpLin4listado1"].style.visibility='hidden';
	document.all["primera1Div"].style.visibility='hidden';
	document.all["ret1Div"].style.visibility='hidden';
	document.all["ava1Div"].style.visibility='hidden';
	document.all["separaDiv"].style.visibility='hidden';
	document.all["btnBloquearDiv"].style.visibility='hidden';
	document.all["btnConsultaDetalleDiv"].style.visibility='hidden';
	document.all["btnConsultaHistoricoDiv"].style.visibility='hidden';
	document.all["btnDesbloquearDiv"].style.visibility='hidden';
}

function onClickBloquear() {
	var codigos = listado1.codSeleccionados();
	if (codigos.length != 1) {
		GestionarMensaje('50');
		return;
	}

	var codigo = codigos[0];

	// Verifico si esta bloqueado, en tal caso pregunto si quiere modificar
	var bloqueado = listado1.extraeDato(codigo, 7);
	if (bloqueado == 'S') {
		var modificar = GestionarMensaje('MAE0052');
		if (! modificar) {
			return;
		}
	}

	var obj = new Object();
	obj.opcionMenu = get('formulario.opcionMenu');
	obj.hOidCliente = listado1.extraeDato(codigo, 1);
	obj.hCodCliente = listado1.extraeDato(codigo, 2);
	obj.hNombre1 = listado1.extraeDato(codigo, 3);
	obj.hNombre2 = listado1.extraeDato(codigo, 4);
	obj.hApellido1 = listado1.extraeDato(codigo, 5);
	obj.hApellido2 = listado1.extraeDato(codigo, 6);
	obj.hBloqueado = listado1.extraeDato(codigo, 7);

	var retorno;

	if (bloqueado == 'S') {
		// Si estoy modificando bloqueo, agrego los datos necesarios...
		obj.accion = 'modificar';
		obj.hOidBloqueo = listado1.extraeDato(codigo, 0);
		obj.hDescTipoBloqueo = listado1.extraeDato(codigo, 8);
		obj.hFechaBloqueo = listado1.extraeDato(codigo, 9);
		obj.hMotivoBloqueo = listado1.extraeDato(codigo, 11);
		obj.hUsuarioBloqueo = listado1.extraeDato(codigo, 12);
		obj.hIndicadorBloqueo = listado1.extraeDato(codigo, 14);
		obj.hObservBloqueo = listado1.extraeDato(codigo, 16);

		retorno = mostrarModalSICC('LPBloquearDesbloquearCliente', 'modificar', obj);

	} else {
		// Estoy introduciendo un bloqueo nuevo...
		obj.accion = 'bloquear';
		retorno = mostrarModalSICC('LPBloquearDesbloquearCliente', 'bloquear', obj);
	}
	
	// El valor de retorno es un boolean, que vale "true" si hay que recargar la pagina
	if (retorno != null && retorno == true) {
		onClickBuscar();
	}
}

function onClickConsultaDetalle() {

	var codigos = listado1.codSeleccionados();
	if (codigos.length != 1) {
		GestionarMensaje('50');
		return;
	}

	var codigo = codigos[0];

	var obj = new Object();
	obj.accion = 'detalle';
	obj.opcionMenu = get('formulario.opcionMenu');
	obj.hCodCliente = listado1.extraeDato(codigo, 2);
	obj.hNombre1 = listado1.extraeDato(codigo, 3);
	obj.hNombre2 = listado1.extraeDato(codigo, 4);
	obj.hApellido1 = listado1.extraeDato(codigo, 5);
	obj.hApellido2 = listado1.extraeDato(codigo, 6);
	obj.hBloqueado = listado1.extraeDato(codigo, 7);
	obj.hDescTipoBloqueo = listado1.extraeDato(codigo, 8);
	obj.hFechaBloqueo = listado1.extraeDato(codigo, 9);
	obj.hFechaDesbloqueo = listado1.extraeDato(codigo, 10);
	obj.hMotivoBloqueo = listado1.extraeDato(codigo, 11);
	obj.hUsuarioBloqueo = listado1.extraeDato(codigo, 12);
	obj.hUsuarioDesbloqueo = listado1.extraeDato(codigo, 13);
	obj.hIndicadorBloqueo = listado1.extraeDato(codigo, 14);
	obj.hIndicadorDesbloqueo = listado1.extraeDato(codigo, 15);
	obj.hObservBloqueo = listado1.extraeDato(codigo, 16);
	obj.hObservDesbloqueo = listado1.extraeDato(codigo, 17);
	
	mostrarModalSICC('LPBloquearDesbloquearCliente', 'detalle', obj);
}

function onClickConsultaHistorico() {

	var codigos = listado1.codSeleccionados();
	if (codigos.length != 1) {
		GestionarMensaje('50');
		return;
	}

	var codigo = codigos[0];

	var obj = new Object();
	obj.accion = 'historico';
	obj.opcionMenu = get('formulario.opcionMenu');
	obj.hOidCliente = listado1.extraeDato(codigo, 1);
	obj.hCodCliente = listado1.extraeDato(codigo, 2);
	obj.hNombre1 = listado1.extraeDato(codigo, 3);
	obj.hNombre2 = listado1.extraeDato(codigo, 4);
	obj.hApellido1 = listado1.extraeDato(codigo, 5);
	obj.hApellido2 = listado1.extraeDato(codigo, 6);
	obj.hBloqueado = listado1.extraeDato(codigo, 7);

	mostrarModalSICC('LPBloquearDesbloquearCliente', 'historico', obj);
}

function onClickDesbloquear() {

	var codigos = listado1.codSeleccionados();
	if (codigos.length != 1) {
		GestionarMensaje('50');
		return;
	}

	var codigo = codigos[0];
	var bloqueado = listado1.extraeDato(codigo, 7);

	// Hago un envia oculto para validar si el usuario tiene permiso de desbloqueo
	// Si tiene permiso, luego se llama a cargarModalDesbloquear() desde la LP.
	if (bloqueado == 'S') {
		set('formulario.hOidTipoBloqueoElemSeleccionado', listado1.extraeDato(codigo, 18));

		eval('formulario').oculto = 'S';
		set('formulario.conectorAction', 'LPBloquearDesbloquearCliente');
		set('formulario.accion', 'validarPermisoDesbloquear');
		set('formulario.casoDeUso', 'desbloquear');
		enviaSICC('formulario');
	}
}

function cargarModalDesbloquear() {

	var codigo = listado1.codSeleccionados()[0];

	var obj = new Object();
	obj.accion = 'desbloquear';
	obj.opcionMenu = get('formulario.opcionMenu');
	obj.hOidBloqueo = listado1.extraeDato(codigo, 0);
	obj.hCodCliente = listado1.extraeDato(codigo, 2);
	obj.hNombre1 = listado1.extraeDato(codigo, 3);
	obj.hNombre2 = listado1.extraeDato(codigo, 4);
	obj.hApellido1 = listado1.extraeDato(codigo, 5);
	obj.hApellido2 = listado1.extraeDato(codigo, 6);
	obj.hBloqueado = listado1.extraeDato(codigo, 7);
	obj.hDescTipoBloqueo = listado1.extraeDato(codigo, 8);
	obj.hFechaBloqueo = listado1.extraeDato(codigo, 9);
	obj.hMotivoBloqueo = listado1.extraeDato(codigo, 11);
	obj.hUsuarioBloqueo = listado1.extraeDato(codigo, 12);
	obj.hIndicadorBloqueo = listado1.extraeDato(codigo, 14);
	obj.hObservBloqueo = listado1.extraeDato(codigo, 16);
	
	var retorno = mostrarModalSICC('LPBloquearDesbloquearCliente', 'desbloquear', obj);
	if (retorno != null && retorno == true) {
		onClickBuscar();
	}
}

function usuarioSinPermisoDesbloquear() {
	GestionarMensaje('MAE0053');
}

function tipoBloqueoSinDesbloqueoManual() {
	GestionarMensaje('MAE0054');
}

function fLimpiar() {
	set('formulario.txtCodCliente', '');
	set('formulario.txtNombre1', '');
	set('formulario.txtNombre2', '');
	set('formulario.txtApellido1', '');
	set('formulario.txtApellido2', '');
	set('formulario.cbTipoDocumento', new Array(get('formulario.hOidTipoDocumentoDNI')));
	set('formulario.txtNumeroDocumento', '');
	ocultarLista();
}

function onTab(campo) {
	if (campo == 'txtCodCliente') {
		focaliza('formulario.txtNombre1');
	} else if (campo == 'txtNombre1') {
		focaliza('formulario.txtNombre2');
	} else if (campo == 'txtNombre2') {
		focaliza('formulario.txtApellido1');
	} else if (campo == 'txtApellido1') {
		focaliza('formulario.txtApellido2');
	} else if (campo == 'txtApellido2') {
		focaliza('formulario.cbTipoDocumento');
	} else if (campo == 'cbTipoDocumento') {
		focaliza('formulario.txtNumeroDocumento');
	} else if (campo == 'txtNumeroDocumento') {
		focaliza('formulario.txtCodCliente');
	}
}

function onShiftTab(campo) {
	if (campo == 'txtCodCliente') {
		focaliza('formulario.txtNumeroDocumento');
	} else if (campo == 'txtNombre1') {
		focaliza('formulario.txtCodCliente');
	} else if (campo == 'txtNombre2') {
		focaliza('formulario.txtNombre1');
	} else if (campo == 'txtApellido1') {
		focaliza('formulario.txtNombre2');
	} else if (campo == 'txtApellido2') {
		focaliza('formulario.txtApellido1');
	} else if (campo == 'cbTipoDocumento') {
		focaliza('formulario.txtApellido2');
	} else if (campo == 'txtNumeroDocumento') {
		focaliza('formulario.cbTipoDocumento');
	}
}
