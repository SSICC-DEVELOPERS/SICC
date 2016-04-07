function onLoad() {
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

	eval(ON_RSZ);
	focaliza('formulario.cbImprVirtual');
}

//-------------------------------------------------------------------------------------

function fLimpiar() {
	set('formulario.cbImprVirtual', new Array(''));
	set('formulario.cbCanal', new Array(''));
	onChangeCanal();
	onChangeAcceso();
	set('formulario.cbFormulario', new Array(''));
	
} 

//-------------------------------------------------------------------------------------

function fBorrar() {
	onClickEliminar();
}


//-------------------------------------------------------------------------------------

function onChangeCanal() {

	var oidCanal = get('formulario.cbCanal','V');
	if (oidCanal != '') {
		
		var array = new Array();
		array[0] = new Array('oid',oidCanal);
		array[1] = new Array('oidIdioma',get('formulario.varIdioma'));

		recargaCombo('formulario.cbAcceso',
					 'SEGObtenerAccesosSinFiltro',
					 'es.indra.sicc.util.DTOOID',
					 array,
					 'setearCbAcceso(datos)');
		set_combo('formulario.cbSubAcceso', new Array(['','']));
	} else {
		set_combo('formulario.cbAcceso', new Array(['','']));
	}
}

//-------------------------------------------------------------------------------------

function setearCbAcceso(datos) {
	var arrayNuevo = new Array();
	arrayNuevo[0] = new Array('','');
	arrayNuevo = arrayNuevo.concat(datos);
	set_combo('formulario.cbAcceso',arrayNuevo);
}

//-------------------------------------------------------------------------------------

function onChangeAcceso() {

	var oidAcceso = get('formulario.cbAcceso','V');
	if (oidAcceso != '') {

		var array = new Array();
		array[0] = new Array('oid', oidAcceso);
		array[1] = new Array('oidIdioma',get('formulario.varIdioma'));
		recargaCombo('formulario.cbSubAcceso',
					 'SEGObtenerSubccesosSinFiltro',
					 'es.indra.sicc.util.DTOOID',
					 array,
					 'setearCbSubacceso(datos)');

	} else {
		set_combo('formulario.cbSubAcceso',new Array(['','']));
	}

}

//-------------------------------------------------------------------------------------

function setearCbSubacceso(datos) {
	var arrayNuevo = new Array();
	arrayNuevo[0] = new Array('','');
	arrayNuevo = arrayNuevo.concat(datos);
	set_combo('formulario.cbSubAcceso',arrayNuevo);
}

//-------------------------------------------------------------------------------------

function onClickBuscar() {

	var parametros = new Array();

	parametros[0] = new Array('oidIdioma', get('formulario.varIdioma'));
	
	var impresora = get('formulario.cbImprVirtual','V');
	if (impresora != ''){
		parametros[parametros.length] = new Array('impresoraVirtual',impresora);
	}

	var canal = get('formulario.cbCanal','V');
	if (canal != ''){
		parametros[parametros.length] = new Array('canal',canal);
	}
	
	var acceso = get('formulario.cbAcceso','V');
	if (acceso != ''){
		parametros[parametros.length] = new Array('acceso',acceso);
	}

	var subacceso = get('formulario.cbSubAcceso','V');
	if (subacceso != '') {
		parametros[parametros.length] = new Array('subAcceso',subacceso);
	}

	var formu = get('formulario.cbFormulario','V');
	if (formu != '') {
		parametros[parametros.length] = new Array('formulario',formu);
	}
	
	configurarPaginado(mipgndo,
					  'FACConsultarAsignacionImpresoras',
					  'ConectorConsultarAsignacionImpresoras',
					  'es.indra.sicc.dtos.fac.DTOAsignacionImpresoras',
					  parametros);
}

//-------------------------------------------------------------------------------------

function muestraLista(ultima, rowset) {
	var tamano = rowset.length;
	if (tamano > 0) {
		mostrarLista();
		return true; 
	}else{
		ocultarLista();
		focaliza('formulario.cbImprVirtual');
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
    document.all["btnDetalleDiv"].style.visibility='visible';              

    if (get('formulario.opcionMenu')=='eliminar'){ // Para ver detalle
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
	btnProxy(4,0);
}



//-------------------------------------------------------------------------------------

function onClickDetalle() {

	var codigos = listado1.codSeleccionados();

	if (codigos.length == 1) {
		var codigo = codigos[0];
		var obj = new Object();
		obj.hImpresora = listado1.extraeDato(codigo,2);
		obj.hCanal = listado1.extraeDato(codigo,4);
		obj.hAcceso = listado1.extraeDato(codigo,6);
		obj.hSubacceso = listado1.extraeDato(codigo,8);
		obj.hFormulario = listado1.extraeDato(codigo,10);

		obj.opcionMenu = get('formulario.opcionMenu');
		obj.accion = 'detalle';
		mostrarModalSICC('LPMantenimientoAsignacionImpresoras', 'detalle', obj);
	} else {
		GestionarMensaje('50');
	}

}

//-------------------------------------------------------------------------------------

function onClickEliminar() {

	var seleccionados = listado1.codSeleccionados();
	var oids =  new Array();
	var cantSeleccionados = seleccionados.length;
		 
	if (cantSeleccionados == 0) {
	   GestionarMensaje("4", null, null, null);
	   return;
	}

	for (var i = 0; i < seleccionados.length; i++) {
		oids[i] = listado1.extraeDato(seleccionados[i], 0);
	}

	eliminarFilas(oids, "FACEliminaAsignacionImpresoras", mipgndo);
}

//-------------------------------------------------------------------------------------

function onTab(campoActual) {

	if (campoActual == 'cbImprVirtual') {
		focaliza('formulario.cbCanal');
	} else if (campoActual == 'cbCanal') {
		focaliza('formulario.cbAcceso');
	} else if (campoActual == 'cbAcceso') {
		focaliza('formulario.cbSubAcceso');
	} else if (campoActual == 'cbSubAcceso') {
		focaliza('formulario.cbFormulario');
	} else if (campoActual == 'cbFormulario') {
		focalizaBotonHTML('botonContenido','btnBuscar');
	} else if (campoActual == 'btnBuscar') {
		if (document.all["Cplistado1"].style.visibility == 'hidden') {
			focaliza('formulario.cbImprVirtual');
		} else {
			focalizaBotonHTML('botonContenido','btnDetalle');
		}
	} else if (campoActual == 'btnDetalle') {
		focaliza('formulario.cbImprVirtual');
	}
}

//-------------------------------------------------------------------------------------

function onShiftTab(campoActual) {

	if (campoActual == 'cbImprVirtual') {
		if (document.all["Cplistado1"].style.visibility == 'hidden') {
			focalizaBotonHTML('botonContenido', 'btnBuscar');
		} else {
			focalizaBotonHTML('botonContenido', 'btnDetalle');
		}
	} else if (campoActual == 'cbCanal') {
		focaliza('formulario.cbImprVirtual');
	} else if (campoActual == 'cbAcceso') {
		focaliza('formulario.cbCanal');
	} else if (campoActual == 'cbSubAcceso') {
		focaliza('formulario.cbAcceso');
	} else if (campoActual == 'cbFormulario') {
		focaliza('formulario.cbSubAcceso');
	} else if (campoActual == 'btnBuscar') {
		focaliza('formulario.cbFormulario');
	} else if (campoActual == 'btnDetalle') {
		focalizaBotonHTML('botonContenido', 'btnBuscar');
	}
}

//-------------------------------------------------------------------------------------

/*
 * Deshabilita el botón avance en caso de que la pagina actual este completa
 * y no queden mas datos por mostrar, evitando los carteles de error que aparecerian
 */
function asignarEstadoBotonAvance() {
	var largo = listado1.datos.length;
	var ultimoReg = listado1.datos[largo-1][0];
	var totalReg = listado1.datos[0][12];
	if (ultimoReg == totalReg) {
		  // Deshabilito el botón Avance
		  mipgndo.ava.setTipo(0);
	}
}