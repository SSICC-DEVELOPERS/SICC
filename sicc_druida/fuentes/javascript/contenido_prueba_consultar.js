function onLoadPag() {
	var opcionMenu = get('formulario.opcionMenu');
	//set('formulario.hOidCentroAnterior', centroDefecto);
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
	focaliza('formulario.txtOidSoli');
}

//--------------------------------------------------------------------------------------------------------

function onClickBuscar() {
	var parametros = new Array();

	/*parametros[0] = new Array('oidIdioma', get('formulario.varIdioma'));
	parametros[1] = new Array('oidPais', get('formulario.varPais'));

	var lineaArmado = get('formulario.cbLineaArmado','V');
	if (lineaArmado != ''){
		  parametros[parametros.length] = new Array('oidLineaArmado', lineaArmado);
	}

	var centroDist = get('formulario.cbCentroDistribucion','V');
	if (centroDist != ''){
		  parametros[parametros.length] = new Array('oidCentroDistribucion', centroDist);
	}*/

	parametros[parametros.length] = new Array('oid', get('formulario.txtOidSoli'));
	/*configurarPaginado(mipgndo,
						'APEVisualizarListaPicado',
						'ConectorConsultarPrueba',
						'es.indra.sicc.util.DTOOID',
						parametros)*/
}

//--------------------------------------------------------------------------------------------------------

function muestraLista(ultima, rowset) {
	var tamano = rowset.length;
	if (tamano > 0) {
		mostrarLista();
		return true; 
	}else{
		ocultarLista();
		focaliza('formulario.cbCentroDistribucion');
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

//-------------------------------------------------------------------------------------

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

//-------------------------------------------------------------------------------------

function onClickModificar() {
	var codigos = listado1.codSeleccionados();

	if (codigos.length == 1) {
		var codigo = codigos[0];
		var obj = new Object();

		obj.hOidCentroDistribucion = listado1.extraeDato(codigo,4);   // OID
		obj.hDescCentroDistribucion = listado1.extraeDato(codigo,0);  // DESCRIPCION
		obj.hOidLineaArmado = listado1.extraeDato(codigo,5);          // OID
		obj.hDescLineaArmado = listado1.extraeDato(codigo,1);         // DESCRIPCION
		obj.hPorcentajeVariacion = listado1.extraeDato(codigo,2);     // VALOR
		obj.hOidFuncionDistribucion = listado1.extraeDato(codigo,6);  // OID
		obj.hDescFuncionDistribucion = listado1.extraeDato(codigo,3); // DESCRIPCION

		obj.opcionMenu = get('formulario.opcionMenu');
		obj.accion = 'modificar';
		mostrarModalSICC('LPMantenerConfiguracionBalanceo', 'modificar', obj);
		onClickBuscar();
	} else {
		GestionarMensaje('50');
	}
}

//--------------------------------------------------------------------------------------------------------

function onClickDetalle() {
	var codigos = listado1.codSeleccionados();

	if (codigos.length == 1) {
		var codigo = codigos[0];
		var obj = new Object();

		obj.hDescCentroDistribucion = listado1.extraeDato(codigo,0);
		obj.hDescLineaArmado = listado1.extraeDato(codigo,1);
		obj.hPorcentajeVariacion = listado1.extraeDato(codigo,2);
		obj.hDescFuncionDistribucion = listado1.extraeDato(codigo,3);

		obj.opcionMenu = get('formulario.opcionMenu');
		obj.accion = 'detalle';
		mostrarModalSICC('LPMantenerConfiguracionBalanceo', 'detalle', obj);
	} else {
		GestionarMensaje('50');
	}
}

//--------------------------------------------------------------------------------------------------------

function onClickEliminar() {
	var seleccionados = listado1.codSeleccionados();
		   
	if (seleccionados.length == 0) {
		GestionarMensaje("4", null, null, null);
		return;
	}

	// Extraigo de la lista los OIDs de las lineas de armado
	var oidsLineas = new Array();
	for (var i = 0; i < seleccionados.length; i++) {
		var oidLinea = listado1.extraeDato(seleccionados[i], 5);
		oidsLineas[oidsLineas.length] = oidLinea;
	}

	eliminarFilas(oidsLineas, "APEEliminarConfiguracionBalanceo", mipgndo);
}

//--------------------------------------------------------------------------------------------------------

function fLimpiar() {
	// Tambien oculto la lista al limpiar 
	ocultarLista(); 
}

//--------------------------------------------------------------------------------------------------------

function fBorrar() {
	onClickEliminar();
}

//--------------------------------------------------------------------------------------------------------

function onTab(campo) {
	if (campo == 'cbCentroDistribucion') {
		focaliza('formulario.cbLineaArmado');
	} else if (campo == 'cbLineaArmado') {
		focalizaBotonHTML('botonContenido','btnBuscar');
	} else if (campo == 'btnBuscar') {
		if (document.all["Cplistado1"].style.visibility == 'hidden') {
			focaliza('formulario.cbCentroDistribucion');
		} else {
			var opcionMenu = get('formulario.opcionMenu');
			if (opcionMenu == 'modificar') {
				focalizaBotonHTML('botonContenido','btnModificar');
			} else {
				focalizaBotonHTML('botonContenido','btnDetalle');
			}
		}
	} else if (campo == 'btnDetalle' || campo == 'btnModificar') {
		focaliza('formulario.cbCentroDistribucion');
	}
}

//--------------------------------------------------------------------------------------------------------

function onShiftTab(campo) {
	if (campo == 'cbCentroDistribucion') {
		if (document.all["Cplistado1"].style.visibility == 'hidden') {
			focalizaBotonHTML('botonContenido','btnBuscar');
		} else {
			var opcionMenu = get('formulario.opcionMenu');
			if (opcionMenu == 'modificar') {
				focalizaBotonHTML('botonContenido','btnModificar');
			} else {
				focalizaBotonHTML('botonContenido','btnDetalle');
			}
		}
	} else if (campo == 'cbLineaArmado') {
		focaliza('formulario.cbCentroDistribucion');
	} else if (campo == 'btnBuscar') {
		focaliza('formulario.cbLineaArmado');
	} else if (campo == 'btnModificar' || campo == 'btnDetalle') {
		focalizaBotonHTML('botonContenido','btnBuscar');
	}
}

//--------------------------------------------------------------------------------------------------------

/*
 * Deshabilita el botón avance en caso de que la pagina actual este completa
 * y no queden mas datos por mostrar, evitando los carteles de error que aparecerian
 */
function asignarEstadoBotonAvance() {
	var primeraLineaLista = listado1.datos[0];
	var esUltimaPagina = primeraLineaLista[primeraLineaLista.length - 1];
	if (esUltimaPagina == '1') {
		// Deshabilito el botón Avance
		mipgndo.ava.setTipo(0);
	}
}