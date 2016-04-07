function onLoadPag() {

	var opcionMenu = get('formulario.opcionMenu');
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
	document.all["btnDetalleDiv"].style.visibility='hidden';
	document.all["btnModificarDiv"].style.visibility='hidden';

	eval(ON_RSZ);
	focaliza('formulario.txtCodTipoBloqueo');
}


function onClickBuscar() {
	var parametros = new Array();

	parametros[0] = new Array('oidIdioma', get('formulario.varIdioma'));

	var codigo = get('formulario.txtCodTipoBloqueo');
	if (codigo != ''){
		parametros[parametros.length] = new Array('codigo', codigo);
	}

	var descripcion = get('formulario.txtDescripcion');
	if (descripcion != ''){
		parametros[parametros.length] = new Array('descripcion', descripcion);
	}

	configurarPaginado(mipgndo,'MAEConsultarTiposBloqueo',
	                   'ConectorConsultarTiposBloqueo',
	                   'es.indra.sicc.dtos.mae.DTOTipoBloqueo',
	                   parametros);
}


function onClickDetalle() {
	var codigos = listado1.codSeleccionados();

	if (codigos.length == 1) {
		var codigo = codigos[0];
		var obj = new Object();

		obj.hOidTipoBloqueo = listado1.extraeDato(codigo,0);
		obj.hCodTipoBloqueo = listado1.extraeDato(codigo,1);
		obj.hDescripcion = listado1.extraeDato(codigo,2);
		obj.hIndBloqueoFinanciero = listado1.extraeDato(codigo,3);
		obj.hDescFormaBloqueo = listado1.extraeDato(codigo,4);
		obj.hDescFormaDesbloqueo = listado1.extraeDato(codigo,5);
		obj.hNivelGravedad = listado1.extraeDato(codigo,6);
		obj.hDescMotivoRechazo = listado1.extraeDato(codigo,7);

		obj.opcionMenu = get('formulario.opcionMenu');
		obj.accion = 'detalle';
		mostrarModalSICC('LPMantenimientoTipoBloqueo', 'detalle', obj);
	} else {
		GestionarMensaje('50');
	}
}


function onClickModificar() {
	var codigos = listado1.codSeleccionados();

	if (codigos.length == 1) {
		var codigo = codigos[0];
		var obj = new Object();

		obj.hOidTipoBloqueo = listado1.extraeDato(codigo,0);
		obj.hCodTipoBloqueo = listado1.extraeDato(codigo,1);
		obj.hDescripcion = listado1.extraeDato(codigo,2);
		obj.hIndBloqueoFinanciero = listado1.extraeDato(codigo,3);
		obj.hOidFormaBloqueo = listado1.extraeDato(codigo,8);
		obj.hOidFormaDesbloqueo = listado1.extraeDato(codigo,9);
		obj.hNivelGravedad = listado1.extraeDato(codigo,6);
		obj.hOidMotivoRechazo = listado1.extraeDato(codigo,10);

		obj.opcionMenu = get('formulario.opcionMenu');
		obj.accion = 'modificar';
		mostrarModalSICC('LPMantenimientoTipoBloqueo', 'modificar', obj);
		onClickBuscar();
	} else {
		GestionarMensaje('50');
	}
}

function muestraLista(ultima,rowset) {
	var tamano = rowset.length;
	if (tamano > 0) {
		mostrarLista();

		// Cambio 1/0 en Ind.bloqueo financiero por texto Si/No
		var si = GestionarMensaje("1010", null, null, null);
		var no = GestionarMensaje("1011", null, null, null);

		for ( var i = 0; i < rowset.length; i++ ) {
			var campo = rowset[i][4];
			var campoValor = parseInt(campo, 10);
			if (campoValor == 1) {
				campo = si;
			} else if (campoValor == 0) {
				campo = no;
			}
			rowset[i][4] = campo;
		}

		return true; 
	}else{
		ocultarLista();
		focaliza('formulario.txtCodTipoBloqueo');
		return false;  
	}
}

function mostrarLista() {

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

	var opcionMenu = get('formulario.opcionMenu');
	if (opcionMenu == 'modificar') {
		document.all["btnModificarDiv"].style.visibility='visible';
	} else if (opcionMenu = 'consultar' || opcionMenu == 'eliminar') {
		document.all["btnDetalleDiv"].style.visibility='visible';
	}

	if (get('formulario.opcionMenu')=='eliminar') {
		btnProxy(4,1);
	}

	eval (ON_RSZ);

}

function ocultarLista() {
	document.all["Cplistado1"].style.visibility='hidden';
	document.all["CpLin1listado1"].style.visibility='hidden';
	document.all["CpLin2listado1" ].style.visibility='hidden';
	document.all["CpLin3listado1"].style.visibility='hidden';
	document.all["CpLin4listado1"].style.visibility='hidden';
	document.all["primera1Div"].style.visibility='hidden';
	document.all["ret1Div"].style.visibility='hidden';
	document.all["ava1Div"].style.visibility='hidden';
	document.all["separaDiv"].style.visibility='hidden';    
	document.all["btnDetalleDiv"].style.visibility='hidden';
	document.all["btnModificarDiv"].style.visibility='hidden';
	btnProxy(4,0);
}

function fBorrar() {

	var seleccionados = listado1.codSeleccionados();

	if (seleccionados.length == 0) {
		GestionarMensaje("4", null, null, null);
		return;
	}

	// Extraigo de la lista los OIDs de las lineas de armado
	var oidsLineas = new Array();
	for (var i = 0; i < seleccionados.length; i++) {
		var oidLinea = listado1.extraeDato(seleccionados[i], 0);
		oidsLineas[oidsLineas.length] = oidLinea;
	}

	eliminarFilas(oidsLineas, "MAEEliminarTiposBloqueo", mipgndo);
}

function fLimpiar() {
	set('formulario.txtCodTipoBloqueo', '');
	set('formulario.txtDescripcion', '');
	ocultarLista();
	focaliza('formulario.txtCodTipoBloqueo');
}

function onTab(campo) {
	if (campo == 'txtCodTipoBloqueo') {
		focaliza('formulario.txtDescripcion');
	} else if (campo == 'txtDescripcion') {
		focaliza('formulario.txtCodTipoBloqueo');
	}
}


function onShiftTab(campo) {
	if (campo == 'txtCodTipoBloqueo') {
		focaliza('formulario.txtDescripcion');
	} else if (campo == 'txtDescripcion') {
		focaliza('formulario.txtCodTipoBloqueo');
	}
}