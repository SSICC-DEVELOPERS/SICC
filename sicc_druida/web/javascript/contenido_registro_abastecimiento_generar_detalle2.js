var FORMULARIO = "formularios";

function onLoadPag() {
	
	configurarMenuSecundario(FORMULARIO);
	
	// se pone el foco en la caja de texto
	focaliza(FORMULARIO + '.txtCodProducto');

	var errDescripcion = get(FORMULARIO + '.errDescripcion');
	if(errDescripcion != '') {
		var errCodigo = get(FORMULARIO +'.errCodigo');
		var wnd = fMostrarMensajeError(errCodigo, errDescripcion);
	}
}

function ejecutarCorrecta(arrayResultado) {
	window.returnValue = arrayResultado.split(',');
}

function ejecutarNoCorrecta() {
	set(FORMULARIO + '.txtCodProducto', '');
	// se pone el foco en la caja de texto
	focaliza(FORMULARIO + '.txtCodProducto');
}

function accionAceptar() {

	var codigoProducto = get(FORMULARIO + '.txtCodProducto');
	
	if (codigoProducto != '') {	
		set(FORMULARIO + '.accion', 'anadirProducto');
		set(FORMULARIO + '.conectorAction', "LPGenerarRegistroAbastecimiento");
		enviaSICC(FORMULARIO);
	}
}

function convertirAMayusculas() {
	var codigoProducto = get(FORMULARIO + '.txtCodProducto');
	if (codigoProducto != '') {
		set(FORMULARIO + '.txtCodProducto', get(FORMULARIO + '.txtCodProducto').toUpperCase());
	}
}

function fLimpiar() {
	set(FORMULARIO + '.txtCodProducto', '');
	// se pone el foco en la caja de texto
	focaliza(FORMULARIO + '.txtCodProducto');
}

function irACajaTexto() {
	focaliza(FORMULARIO + '.txtCodProducto');
}

function irABoton() {
	document.all['btnAceptar'].focus();	
}

function fVolver() {
	window.close();
}