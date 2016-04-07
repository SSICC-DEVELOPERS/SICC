//------------------------------------------------------------------------------------

function onLoadPag() {
	configurarMenuSecundario('formulario');
	DrdEnsanchaConMargenDcho('listado1',12);
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
	
	// Cargo manualmente los combos de tipo asiento, cabecera detalle y debe haber
	set_combo('formulario.cbTipoAsiento', [['', ''], ['1', 'VN'], ['2', 'AB'], ['3', 'TN']]);
	set_combo('formulario.cbCabecDetalle', [['', ''], ['1','C'], ['2', 'D']]);
	set_combo('formulario.cbDebeHaber', [['', ''], ['1', 'D'], ['2', 'H']]);
}

//------------------------------------------------------------------------------------

function onClickBuscar() {
	var parametros = armarArrayParametrosBusqueda();

	configurarPaginado(mipgndo, 'INTBuscarParametrosContablesFAC', 'ConectorBuscarParametrosContablesFAC',
						'es.indra.sicc.dtos.intsys.DTOParametrosContablesFAC', parametros);
}

//------------------------------------------------------------------------------------

function armarArrayParametrosBusqueda() {
	var parametros = new Array();
	parametros[0] = new Array('oidPais', get('formulario.varPais'));
	parametros[1] = new Array('oidIdioma', get('formulario.varIdioma'));

	var codApunte = get('formulario.txtCodApunte');
	if (codApunte != '') {
		parametros[parametros.length] = new Array('codApunte', codApunte);
	}

	var tipoAsiento = get('formulario.cbTipoAsiento', 'T');
	if (tipoAsiento != '') {
		parametros[parametros.length] = new Array('tipoAsiento', tipoAsiento);
	}

	var cabecDetalle = get('formulario.cbCabecDetalle', 'T');
	if (cabecDetalle != '') {
		parametros[parametros.length] = new Array('cabeceraDetalle', cabecDetalle);
	}

	var descripcion = get('formulario.txtDescripcion');
	if (descripcion != '') {
		parametros[parametros.length] = new Array('descripcion', descripcion);
	}

	var grupoProductos = get('formulario.txtGrupoProductos');
	if (grupoProductos != '') {
		parametros[parametros.length] = new Array('grupoProductos', grupoProductos);
	}

	var marcaProductos = get('formulario.cbMarcaProductos', 'V');
	if (marcaProductos != '') {
		parametros[parametros.length] = new Array('marcaProductos', marcaProductos);
	}

	var negocio = get('formulario.cbNegocio', 'V');
	if (negocio != '') {
		parametros[parametros.length] = new Array('negocio', negocio);
	}

	var codSap = get('formulario.txtCodSap');
	if (codSap != '') {
		parametros[parametros.length] = new Array('codProductoSAP', codSap);
	}

	var cuentaContable = get('formulario.cbCuentaContable', 'V');
	if (cuentaContable != '') {
		parametros[parametros.length] = new Array('cuentaContable', cuentaContable);
	}

	var debeHaber = get('formulario.cbDebeHaber', 'T');
	if (debeHaber != '') {
		parametros[parametros.length] = new Array('debeHaber', debeHaber);
	}

	var codImporte = get('formulario.cbCodImporte', 'V');
	if (codImporte != '') {
		parametros[parametros.length] = new Array('codImporte', codImporte);
	}

	return parametros;

}

//------------------------------------------------------------------------------------

function muestraLista(ultima,rowset) {
	var tamano = rowset.length;
	if (tamano > 0) {
		mostrarLista();
		return true;
	} else {
		ocultarLista();
		focaliza('formulario.txtCodApunte');
		return false;
	}
}

//------------------------------------------------------------------------------------

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
	if (opcionMenu == 'consultar'){ // Para ver detalle
		document.all["btnModificarDiv"].style.visibility='hidden';
		document.all["btnDetalleDiv"].style.visibility='visible';              
	} else if (opcionMenu == 'modificar'){ // Para modificar
		document.all["btnModificarDiv"].style.visibility='visible';
		document.all["btnDetalleDiv"].style.visibility='hidden';
	} else if (opcionMenu == 'eliminar'){ // Para ver detalle
		document.all["btnModificarDiv"].style.visibility='hidden';
		document.all["btnDetalleDiv"].style.visibility='visible';
		btnProxy(4,1);
	}
         
	eval (ON_RSZ);
}

//------------------------------------------------------------------------------------

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

//------------------------------------------------------------------------------------


function onClickDetalle() {
	var seleccionados = listado1.codSeleccionados();

	if (seleccionados.length == 1) {
		// Se selecciono un elemento, mostrar detalle
		var codigo = seleccionados[0];
		var obj = new Object();

		obj.hOid = listado1.extraeDato(codigo,0);				// OID_PARA_CONT_FACT
		obj.hCodApunte = listado1.extraeDato(codigo,1);			// COD_APUN
		obj.hTipoAsiento = listado1.extraeDato(codigo,2);		// VAL_TIPO_ASIE
		obj.hCabecDetalle = listado1.extraeDato(codigo,3);		// VAL_IDEN_CABE_DETA
		obj.hDescripcion = listado1.extraeDato(codigo,4);		// VAL_DESC
		obj.hGrupoProductos = listado1.extraeDato(codigo,5);	// VAL_GRUP_ARTI
		obj.hDebeHaber = listado1.extraeDato(codigo,6);			// VAL_INDI_DEBE_HABE
		obj.hCuentaContable = listado1.extraeDato(codigo,8);	// CUENTA_CONTABLE (se toma la descripcion y no el OID)
		obj.hCodImporte = listado1.extraeDato(codigo,10);		// COD_IMPO_CONT (se toma el codigo y no el OID)
		obj.hMarcaProductos = listado1.extraeDato(codigo,12);	// DES_MARC_PROD (se toma la descripcion y no el OID)
		obj.hNegocio = listado1.extraeDato(codigo,14);			// NEGOCIO (se toma la descripcion y no el OID)
		obj.hCodSap = listado1.extraeDato(codigo,17);			// COD_SAP (no se toma el país ni el OID de producto)

		obj.opcionMenu = get('formulario.opcionMenu');
		obj.accion = 'detalle';
		mostrarModalSICC('LPMantenimientoParametrosFacturacion', 'detalle', obj);
	} else if (seleccionados.length == 0) {
		// No se seleccionaron elementos, mostrar cartel
		GestionarMensaje('50');
	} else {
		// Se selecciono mas de un elemento, mostrar cartel
		GestionarMensaje('240');
	}
}

//------------------------------------------------------------------------------------

function onClickModificar() {
	var seleccionados = listado1.codSeleccionados();
	
	if (seleccionados.length == 1) {
		// Se selecciono un elemento, mostrar detalle
		var codigo = seleccionados[0];
		var obj = new Object();

		obj.hOid = listado1.extraeDato(codigo,0);				// OID_PARA_CONT_FACT
		obj.hCodApunte = listado1.extraeDato(codigo,1);			// COD_APUN
		obj.hTipoAsiento = listado1.extraeDato(codigo,2);		// VAL_TIPO_ASIE
		obj.hCabecDetalle = listado1.extraeDato(codigo,3);		// VAL_IDEN_CABE_DETA
		obj.hDescripcion = listado1.extraeDato(codigo,4);		// VAL_DESC
		obj.hGrupoProductos = listado1.extraeDato(codigo,5);	// VAL_GRUP_ARTI
		obj.hDebeHaber = listado1.extraeDato(codigo,6);			// VAL_INDI_DEBE_HABE
		obj.hCuentaContable = listado1.extraeDato(codigo,7);	// CUCO_OID_CUEN_CONT
		obj.hCodImporte = listado1.extraeDato(codigo,9);		// IMCF_OID_IMPO_CONT_FACT
		obj.hMarcaProductos = listado1.extraeDato(codigo,11);	// MAPR_OID_MARC_PROD
		obj.hNegocio = listado1.extraeDato(codigo,13);			// NEGO_OID_NEGO
		obj.hCodSap = listado1.extraeDato(codigo,17);			// COD_SAP (no se toma el país ni el OID de producto)

		obj.opcionMenu = get('formulario.opcionMenu');
		obj.accion = 'modificar';
		var retorno = mostrarModalSICC('LPMantenimientoParametrosFacturacion', 'modificar', obj);

		if (retorno == 'modificar') {
			mipgndo.recargar();
		}

	} else if (seleccionados.length == 0) {
		// No se seleccionaron elementos, mostrar cartel
		GestionarMensaje('50');
	} else {
		// Se selecciono mas de un elemento, mostrar cartel
		GestionarMensaje('1022');
	}
}

//------------------------------------------------------------------------------------

function fBorrar() {

	var seleccionados = listado1.codSeleccionados();
	if (seleccionados.length > 0) {
		var oids = new Array();
		for (var i = 0; i < seleccionados.length; i++) {
			oids[i] = listado1.extraeDato(seleccionados[i], 0);
		}
		eliminarFilas(oids, 'INTEliminarParametrosContablesFAC', mipgndo);
	} else {
		GestionarMensaje('4');
	}

}

//------------------------------------------------------------------------------------

function fLimpiar() {
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
		focalizaBotonHTML('botonContenido', 'btnBuscar');
	} else if (campoActual == 'btnBuscar') {
		if (document.all["Cplistado1"].style.visibility != 'hidden') {
			var opcionMenu = get('formulario.opcionMenu');
			if (opcionMenu == 'modificar') {
				focalizaBotonHTML('botonContenido', 'btnModificar');
			} else if (opcionMenu == 'consultar' || opcionMenu == 'eliminar') {
				focalizaBotonHTML('botonContenido', 'btnDetalle');
			}
		} else {
			focaliza('formulario.txtCodApunte');
		}
	} else if (campoActual == 'btnModificar' || campoActual == 'btnDetalle') {
		focaliza('formulario.txtCodApunte');
	}
}

//------------------------------------------------------------------------------------

function onShiftTab(campoActual) {
	if (campoActual == 'txtCodApunte') {
		if (document.all["Cplistado1"].style.visibility != 'hidden') {
			var opcionMenu = get('formulario.opcionMenu');
			if (opcionMenu == 'modificar') {
				focalizaBotonHTML('botonContenido', 'btnModificar');
			} else if (opcionMenu == 'consultar' || opcionMenu == 'eliminar') {
				focalizaBotonHTML('botonContenido', 'btnDetalle');
			}
		} else {
			focalizaBotonHTML('botonContenido', 'btnBuscar');
		}
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
	} else if (campoActual == 'btnBuscar') {
		focaliza('formulario.cbCodImporte');
	} else if (campoActual == 'btnModificar' || campoActual == 'btnDetalle') {
		focalizaBotonHTML('botonContenido', 'btnBuscar');
	}
}

//------------------------------------------------------------------------------------

function deshabilitarBotonAvance() {
	var largo = listado1.datos.length;
	var ultimoReg = listado1.datos[largo-1][0];
	var totalReg = listado1.datos[0][19];
	if (ultimoReg == totalReg) {
		// Deshabilito el botón Avance
		mipgndo.ava.setTipo(0);
	}
}