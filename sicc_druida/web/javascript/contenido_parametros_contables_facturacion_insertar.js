//------------------------------------------------------------------------------------

function onLoadPag() {

	configurarMenuSecundario('formulario');

	var acc = get('formulario.accion');

	// Cargo manualmente los combos de tipo asiento, cabecera detalle y debe haber

	if (acc != 'detalle') {
		set_combo('formulario.cbTipoAsiento', [['', ''], ['1', 'VN'], ['2', 'AB'], ['3', 'TN']]);
		set_combo('formulario.cbCabecDetalle', [['', ''], ['1','C'], ['2', 'D']]);
		set_combo('formulario.cbDebeHaber', [['', ''], ['1', 'D'], ['2', 'H']]);
	}
	

	if (acc == '') {
		// CU Insertar, cargo la pagina directamente
		ponerCamposEnBlanco();
		focaliza('formulario.txtCodApunte');
	} else if (acc == 'detalle') {
		// Ventana Detalle (CU Consultar/Eliminar)
		// En las variables hidden estan los valores que se muestran en pantalla
		// No hay ningun OID
		setearCamposDetalle();
		deshabilitarCampos();
	} else if (acc == 'modificar') {
		// CU Modificar
		// En las variables hidden estan los OIDs en los campos donde aplica
		setearCamposModificar();
		accion('formulario.txtCodApunte','.disabled = true');
		focaliza('formulario.cbTipoAsiento');
	}
}

//------------------------------------------------------------------------------------

function deshabilitarCampos() {
	accion('formulario.txtCodApunte','.disabled = true');
	accion('formulario.cbTipoAsiento','.disabled = true');
	accion('formulario.cbCabecDetalle','.disabled = true');
	accion('formulario.txtDescripcion','.disabled = true');
	accion('formulario.txtGrupoProductos','.disabled = true');
	accion('formulario.cbMarcaProductos','.disabled = true');
	accion('formulario.cbNegocio','.disabled = true');
	accion('formulario.txtCodSap','.disabled = true');
	accion('formulario.cbCuentaContable','.disabled = true');
	accion('formulario.cbDebeHaber','.disabled = true');
	accion('formulario.cbCodImporte','.disabled = true');
}

//------------------------------------------------------------------------------------

/* Sustituye a onClickGuardar() */
function fGuardar() {
	if (! sicc_validaciones_generales()) {
		return false;
	}

	// Seteo las variables hidden con los valores de los campos
	set('formulario.hCodApunte', get('formulario.txtCodApunte'));
	set('formulario.hTipoAsiento', get('formulario.cbTipoAsiento', 'T'));
	set('formulario.hCabecDetalle', get('formulario.cbCabecDetalle', 'T'));
	set('formulario.hDescripcion', get('formulario.txtDescripcion'));
	set('formulario.hGrupoProductos', get('formulario.txtGrupoProductos'));
	set('formulario.hMarcaProductos', get('formulario.cbMarcaProductos', 'V'));
	set('formulario.hNegocio', get('formulario.cbNegocio', 'V'));
	set('formulario.hCodSap', get('formulario.txtCodSap'));
	set('formulario.hCuentaContable', get('formulario.cbCuentaContable', 'V'));
	set('formulario.hDebeHaber', get('formulario.cbDebeHaber', 'T'));
	set('formulario.hCodImporte', get('formulario.cbCodImporte', 'V'));

	// Envio el formulario
	eval('formulario').oculto = 'S';
	set('formulario.conectorAction',"LPMantenimientoParametrosFacturacion");
	set('formulario.accion','guardar');
	enviaSICC('formulario');
}

//------------------------------------------------------------------------------------

function fLimpiar() {
	var opcionMenu = get('formulario.opcionMenu');
	if (opcionMenu == 'insertar') {
		// CU Insertar - Dejo todos los campos en blanco
		ponerCamposEnBlanco();
	} else if (opcionMenu == 'modificar') {
		// CU Modificar
		// Tomo de las variables hidden los valores iniciales
		setearCamposModificar();
	}
}

//------------------------------------------------------------------------------------

/*
 * Setea los campos de la pantalla con los valores de las variables hidden.
 * En las variables correspondientes a combos aparece el OID del elemento seleccionado.
 */
function setearCamposModificar() {
	set('formulario.txtCodApunte', get('formulario.hCodApunte'));

	var tipoAsiento = get('formulario.hTipoAsiento');
	if (tipoAsiento == 'VN') {
		set('formulario.cbTipoAsiento', new Array('1'));
	} else if (tipoAsiento == 'AB') {
		set('formulario.cbTipoAsiento', new Array('2'));
	} else if (tipoAsiento == 'TN')	{
		set('formulario.cbTipoAsiento', new Array('3'));
	}
		
	var cabecDetalle = get('formulario.hCabecDetalle');
	if (cabecDetalle == 'C') {
		set('formulario.cbCabecDetalle', new Array('1'));
	} else if (cabecDetalle == 'D') {
		set('formulario.cbCabecDetalle', new Array('2'));
	}

	set('formulario.txtDescripcion', get('formulario.hDescripcion'));
	set('formulario.txtGrupoProductos', get('formulario.hGrupoProductos'));
	set('formulario.cbMarcaProductos', new Array(get('formulario.hMarcaProductos')));
	set('formulario.cbNegocio', new Array(get('formulario.hNegocio')));
	set('formulario.txtCodSap', get('formulario.hCodSap'));
	set('formulario.cbCuentaContable', new Array(get('formulario.hCuentaContable')));

	var debeHaber = get('formulario.hDebeHaber');
	if (debeHaber == 'D') {
		set('formulario.cbDebeHaber', new Array('1'));
	} else if (debeHaber == 'H') {
		set('formulario.cbDebeHaber', new Array('2'));
	}
	
	set('formulario.cbCodImporte', new Array(get('formulario.hCodImporte')));
}

//------------------------------------------------------------------------------------

function ponerCamposEnBlanco() {
	set('formulario.txtCodApunte', '');
	set('formulario.cbTipoAsiento', new Array(''));
	set('formulario.cbCabecDetalle', new Array(''));
	set('formulario.txtDescripcion', '');
	set('formulario.txtGrupoProductos', '');
	set('formulario.cbMarcaProductos', new Array(''));
	set('formulario.cbNegocio', new Array(''));
	set('formulario.txtCodSap', '');
	set('formulario.cbCuentaContable', new Array(''));
	set('formulario.cbDebeHaber', new Array(''));
	set('formulario.cbCodImporte', new Array(''));
}

//------------------------------------------------------------------------------------

/*
 * Setea los campos de la pantalla con los valores de las variables hidden.
 * En las variables correspondientes a combos no hay ningún OID, aparecen directamente
 * los textos a mostrar.
 */
function setearCamposDetalle() {
	set('formulario.txtCodApunte', get('formulario.hCodApunte'));
	set_combo('formulario.cbTipoAsiento', [ ['', get('formulario.hTipoAsiento')] ]);
	set_combo('formulario.cbCabecDetalle', [ ['', get('formulario.hCabecDetalle')] ] );
	set('formulario.txtDescripcion', get('formulario.hDescripcion'));
	set('formulario.txtGrupoProductos', get('formulario.hGrupoProductos'));
	set_combo('formulario.cbMarcaProductos', [ ['', get('formulario.hMarcaProductos')] ]);
	set_combo('formulario.cbNegocio', [ ['', get('formulario.hNegocio')] ]);
	set('formulario.txtCodSap', get('formulario.hCodSap'));
	set_combo('formulario.cbCuentaContable', [ ['', get('formulario.hCuentaContable')] ]);
	set_combo('formulario.cbDebeHaber', [ ['', get('formulario.hDebeHaber')] ]);
	set_combo('formulario.cbCodImporte', [ ['', get('formulario.hCodImporte')] ]);
}

//------------------------------------------------------------------------------------

function onTab(campoActual) {
	if (campoActual == 'txtCodApunte') {
		focaliza('formulario.cbTipoAsiento');
	} else if (campoActual == 'cbTipoAsiento') {
		focaliza('formulario.cbCabecDetalle');
	} else if (campoActual == 'cbCabecDetalle') {
		focaliza('formulario.txtDescripcion');
	} else if (campoActual == 'txtDescripcion') {
		focaliza('formulario.txtGrupoProductos');
	} else if (campoActual == 'txtGrupoProductos') {
		focaliza('formulario.cbMarcaProductos');
	} else if (campoActual == 'cbMarcaProductos') {
		focaliza('formulario.cbNegocio');
	} else if (campoActual == 'cbNegocio') {
		focaliza('formulario.txtCodSap');
	} else if (campoActual == 'txtCodSap') {
		focaliza('formulario.cbCuentaContable');
	} else if (campoActual == 'cbCuentaContable') {
		focaliza('formulario.cbDebeHaber');
	} else if (campoActual == 'cbDebeHaber') {
		focaliza('formulario.cbCodImporte');
	} else if (campoActual == 'cbCodImporte') {
		focaliza('formulario.txtCodApunte');
	}
}

//------------------------------------------------------------------------------------

function onShiftTab(campoActual) {
	if (campoActual == 'txtCodApunte') {
		focaliza('formulario.cbCodImporte');
	} else if (campoActual == 'cbTipoAsiento') {
		focaliza('formulario.txtCodApunte');
	} else if (campoActual == 'cbCabecDetalle') {
		focaliza('formulario.cbTipoAsiento');
	} else if (campoActual == 'txtDescripcion') {
		focaliza('formulario.cbCabecDetalle');
	} else if (campoActual == 'txtGrupoProductos') {
		focaliza('formulario.txtDescripcion');
	} else if (campoActual == 'cbMarcaProductos') {
		focaliza('formulario.txtGrupoProductos');
	} else if (campoActual == 'cbNegocio') {
		focaliza('formulario.cbMarcaProductos');
	} else if (campoActual == 'txtCodSap') {
		focaliza('formulario.cbNegocio');
	} else if (campoActual == 'cbCuentaContable') {
		focaliza('formulario.txtCodSap');
	} else if (campoActual == 'cbDebeHaber') {
		focaliza('formulario.cbCuentaContable');
	} else if (campoActual == 'cbCodImporte') {
		focaliza('formulario.cbDebeHaber');
	}
}

//------------------------------------------------------------------------------------

function fVolver() {
	window.close();
}

//------------------------------------------------------------------------------------

function guardoCorrectamente() {
	if (get('formulario.opcionMenu') == 'modificar') {
		returnValue = "modificar";
		window.close();
	} else {
		fLimpiar();
		focaliza('formulario.txtCodApunte');
	}
}

//------------------------------------------------------------------------------------

function errorAlGuardar() {
	focaliza('formulario.txtCodApunte');
}

//------------------------------------------------------------------------------------