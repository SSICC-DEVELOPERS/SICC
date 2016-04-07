function onLoadPag() {
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
	document.all["btnImprimirDiv"].style.visibility='hidden';
	document.all["btnReimprimirDiv"].style.visibility='hidden';

	// vbongiov -- Incidente APE20080626-1 -- 26/06/2008
	if (get('formulario.casoUso') == 'manual') {
	  visibilidad('capaBuscar','O');
	  visibilidad('capaImprimirManual','V');
	} else {
	  visibilidad('capaBuscar','V');
	  visibilidad('capaImprimirManual','O');
	}


	eval(ON_RSZ);
	focaliza('formulario.txtConsolidado');
}


//-----------------------------------------------------------------------

function onChangeTxtConsolidado() {
	txt_to('Mensajes', '');
}

//-----------------------------------------------------------------------

function onChangeTxtCaja() {
	txt_to('Mensajes', '');
}

//-----------------------------------------------------------------------

/**
 * CHANGELOG
 * ---------
 * 03/09/2009 - dmorello, Cambio 20090839
 *     Agrego param para indicar si limpio o no el label de mensajes
 */
function onClickBtnBuscar(limpiarMensajes) {

	if (limpiarMensajes) {
		txt_to('Mensajes', '');
	}

	if (! sicc_validaciones_generales()) {
		return false;
	}

	var oidPais = get('formulario.varPais');
	var nroCaja = get('formulario.txtCaja');
	var nroCons = get('formulario.txtConsolidado');

	// Valido los dos campos como numericos
	if (nroCaja != '' && fValidarNumero(nroCaja, 3, 0, 999) != 'OK') {
		GestionarMensaje('747');
		focaliza('formulario.txtCaja');
		return;
	}
	if (nroCons != '' && fValidarNumero(nroCons, 10, 0, 9999999999) != 'OK') {
		GestionarMensaje('747');
		focaliza('formulario.txtConsolidado');
		return;
	}

	// Armo el array con los parametros del DTO
	var array = new Array();
	array[0] = new Array('nroSolicCabec', nroCons);
	array[1] = new Array('oidPais', oidPais);
	if (nroCaja != '') {
		array[2] = new Array('nroCaja', nroCaja);
	}
	
	var casoUso = get('formulario.casoUso');
	if (casoUso == 'manual') {
		array[array.length] = new Array('impresa', 'false');
	} else if (casoUso == 'reimpresion') {
		array[array.length] = new Array('impresa', 'true');
	}

	configurarPaginado(mipgndo,
	                   'APEBuscarEtiquetasImprimir',
	                   'ConectorBuscarEtiquetasImprimir',
	                   'es.indra.sicc.dtos.ape.DTOBusquedaEtiqueta',
	                   array);

}

//-----------------------------------------------------------------------


function muestraLista(ultima, rowset) {
	var tamano = rowset.length;
	if (tamano > 0) {

		// Cambio las "S" de la ultima columna por el mensaje "SI"
		var si = get('formulario.hImpresionSi');
		var no = get('formulario.hImpresionNo');

		for (var i = 0; i < rowset.length; i++) {
			if (rowset[i][6] == si) {
				rowset[i][6] = GestionarMensaje('84');
			} else if (rowset[i][6] == no) {
				rowset[i][6] = GestionarMensaje('86');
			}
		}

		mostrarLista();
		return true; 
	}else{
		ocultarLista();
		focaliza('formulario.txtConsolidado');
		return false;  
	}
}   

//-------------------------------------------------------------------------------------

function mostrarLista(){
	DrdEnsanchaConMargenDcho('listado1',12);
	document.all["Cplistado1"].style.visibility='visible';
	document.all["CpLin1listado1"].style.visibility='visible';
	document.all["CpLin2listado1"].style.visibility='visible';
	document.all["CpLin3listado1"].style.visibility='visible';
	document.all["CpLin4listado1"].style.visibility='visible';

	var casoUso = get('formulario.casoUso');
	if (casoUso == 'manual') {
		  document.all["btnImprimirDiv"].style.visibility='visible';
	} else if (casoUso == 'reimpresion') {
		  document.all["btnReimprimirDiv"].style.visibility='visible';
	}

	eval (ON_RSZ);
}

//-------------------------------------------------------------------------------------

function ocultarLista() {
    document.all["Cplistado1"].style.visibility='hidden';
    document.all["CpLin1listado1"].style.visibility='hidden';
    document.all["CpLin2listado1" ].style.visibility='hidden';
    document.all["CpLin3listado1"].style.visibility='hidden';
    document.all["CpLin4listado1"].style.visibility='hidden';
    document.all["btnImprimirDiv"].style.visibility='hidden';
    document.all["btnReimprimirDiv"].style.visibility='hidden';
}

//-------------------------------------------------------------------------------------

function onSeleccionListado1() {

}

//-----------------------------------------------------------------------

function onClickBtnImprimir() {
	accionImprimir('imprimirSeleccion');
}

//-----------------------------------------------------------------------

function onClickBtnReimprimir() {
	accionImprimir('reimprimirSeleccion');
}

//-----------------------------------------------------------------------

function accionImprimir(accion) {
	var seleccionados = listado1.codSeleccionados();
	if (seleccionados.length > 0) {
		var strOids = '';
		for (var i = 0; i < seleccionados.length; ) {
			strOids += seleccionados[i];
			if (++i < seleccionados.length) {
				strOids += ',';
			}
		}
		set('formulario.hOidsImprimir', strOids);

		if (accion == 'imprimirSeleccion') {
			set('formulario.hImpresa', 'false');
		} else if (accion == 'reimprimirSeleccion') {
			set('formulario.hImpresa', 'true');
		}

		set('formulario.conectorAction', 'LPImprimirEtiquetasManual');
		set('formulario.accion', accion);
		eval('formulario').oculto = 'S';
		enviaSICC('formulario');

	} else {
		GestionarMensaje("4", null, null, null);
		return;
	}
}


//-----------------------------------------------------------------------

function fLimpiar() {
	set('formulario.txtCaja', '');
	set('formulario.txtConsolidado', '');
	txt_to('Mensajes', '');
	if (document.all["Cplistado1"].style.visibility == 'visible') {
		ocultarLista();
	}
}

//-----------------------------------------------------------------------

function onTab(campo) {
	if (campo == 'txtConsolidado') {
		focaliza('formulario.txtCaja');
	} else if (campo == 'txtCaja') {
		var casoUso = get('formulario.casoUso');
		if (casoUso == 'manual') {
			focalizaBotonHTML('botonContenido', 'btnImprimirManual');
		} else if (casoUso == 'reimpresion') {
			focalizaBotonHTML('botonContenido', 'btnBuscar');
		}
	} else if (campo == 'btnBuscar') {
		if (document.all["Cplistado1"].style.visibility == 'visible') {
			var casoUso = get('formulario.casoUso');
			if (casoUso == 'manual') {
				focalizaBotonHTML('botonContenido', 'btnImprimir');
			} else if (casoUso == 'reimpresion') {
				focalizaBotonHTML('botonContenido', 'btnReimprimir');
			}
		} else {
			focaliza('formulario.txtConsolidado');
		}
	} else if (campo == 'btnImprimir' || campo == 'btnReimprimir') {
		focaliza('formulario.txtConsolidado');
	} else if (campo == 'btnImprimirManual') { 
		focaliza('formulario.txtConsolidado'); 
	}
}

//-----------------------------------------------------------------------

function onShiftTab(campo) {
	if (campo == 'txtConsolidado') {
		var casoUso = get('formulario.casoUso');
		if (document.all["Cplistado1"].style.visibility == 'visible') {
			if (casoUso == 'manual') {
				focalizaBotonHTML('botonContenido', 'btnImprimir');
			} else if (casoUso == 'reimpresion') {
				focalizaBotonHTML('botonContenido', 'btnReimprimir');
			}
		} else {
			if (casoUso == 'manual') { 
				focalizaBotonHTML('botonContenido', 'btnImprimirManual'); 
			} else if (casoUso == 'reimpresion') { 
				focalizaBotonHTML('botonContenido', 'btnBuscar');
			}
		}
	} else if (campo == 'txtCaja') {
		focaliza('formulario.txtConsolidado');
	} else if (campo == 'btnBuscar') {
		focaliza('formulario.txtCaja');
	} else if (campo == 'btnImprimir' || campo == 'btnReimprimir') {
		focalizaBotonHTML('botonContenido', 'btnBuscar');
	} else if (campo == 'btnImprimirManual') { 
		focaliza('formulario.txtCaja'); 
	}
}

//-----------------------------------------------------------------------

function impresionOK() {
	var casoUso = get('formulario.casoUso');
	var mensaje;
	if (casoUso == 'manual') {
		mensaje = GestionarMensaje('APEUI064'); // Agrego por BELC400000606
	} else {
		mensaje = GestionarMensaje('APEUI063'); // Agrego por BELC400000606
	}
	fLimpiar();
	txt_to('Mensajes', mensaje);
	focaliza('formulario.txtConsolidado');
	if (casoUso == 'manual') {
		onClickBtnBuscar(false); // false para que no limpie el label Mensajes
	}
}

//-----------------------------------------------------------------------

function impresionConError() {
	if (get('formulario.casoUso') == 'manual') { 
		fLimpiar(); 
		focaliza('formulario.txtConsolidado'); 
	} 
} 
    
//----------------------------------------------------------------------- 

// dmorello, 05/06/2008 - Cambio APE-09 
function onClickBtnImprimirManual() { 
	txt_to('Mensajes', '');
	if (! sicc_validaciones_generales()) { 
		return false; 
	} 

	// Valido los dos campos como numericos
	var nroCons = get('formulario.txtConsolidado');
	var nroCaja = get('formulario.txtCaja');
	if (nroCons != '' && fValidarNumero(nroCons, 10, 0, 9999999999) != 'OK') {
		GestionarMensaje('747');
		focaliza('formulario.txtConsolidado');
		return;
	}
	if (nroCaja != '' && fValidarNumero(nroCaja, 3, 0, 999) != 'OK') {
		GestionarMensaje('747');
		focaliza('formulario.txtCaja');
		return;
	}

	// Antepongo el numero de año al consolidado
	var consolidado = get('formulario.txtConsolidado');
	if (consolidado.length <= 8) {
		// Relleno con ceros para completar a 8 digitos
		while (consolidado.length < 8) {
			consolidado = '0' + consolidado;
		}
		// Completo el num de consolidado con los dos digitos del año
		var anio = get('formulario.hAnio');
		set('formulario.txtConsolidado', anio + consolidado);
	}

	set('formulario.conectorAction', 'LPImprimirEtiquetasManual'); 
	set('formulario.accion', 'imprimirEtiquetasConsolidadoCaja'); 
	eval('formulario').oculto = 'S'; 
	enviaSICC('formulario'); 
} 

//----------------------------------------------------------------------- 

// dmorello, 05/06/2008 - Cambio APE-09 
function onKeyPressTxtConsolidado() {

	if (get('formulario.casoUso') == 'manual') {
		if (event.keyCode == 13) {
			onClickBtnImprimirManual();
		} 
	} 
} 

//----------------------------------------------------------------------- 

// dmorello, 05/06/2008 - Cambio APE-09 
function etiquetasImpresas(numConsolidado) { 
	var mensaje = GestionarMensaje('APEUI068', numConsolidado); 
	fLimpiar(); 
	txt_to('Mensajes', mensaje);
	focaliza('formulario.txtConsolidado'); 
}
