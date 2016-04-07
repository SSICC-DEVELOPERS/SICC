var FORMULARIO = 'frmFormulario';
var nombresCampos = ['txtCodCliente|TEXT','cbCCC|COMBO','txtGlosaContable|TEXT','txtImporte|TEXT',
	'txtDivisa|TEXT','txtImporteDivisa|TEXT','cbTipoAbono|COMBO'];
var codClienteDisabled = false;


function onLoadPag() {
	var errDescripcion = get(FORMULARIO +'.errDescripcion');
	if (errDescripcion !='') {
		var errCodigo = get(FORMULARIO+'.errCodigo');
		var wnd = fMostrarMensajeError(errCodigo, errDescripcion);
	}

	if (get(FORMULARIO + '.txtCodCliente') != "") {
		codClienteDisabled = true;
		focaliza(FORMULARIO + '.cbCCC');
	}
	else focaliza(FORMULARIO + '.txtCodCliente');
	configurarMenuSecundario(FORMULARIO);

}


// Función que se ejecuta cuando el usuario pulsa la imagen de la lupa
function accionSeleccionarCliente() {
	// Se muestra un cuadro de dialogo modal para que el usuario seleccione el
	// cliente
	var objParams = new Object();
	var cliente = mostrarModalSICC('LPBusquedaRapidaCliente', '', objParams, null, null);
	
	// Se rellena el campo de texto codigo de cliente con el seleccionado por
	// el usuario
	if (typeof(cliente)!='undefined') var codigoCliente = cliente[1]
	set(FORMULARIO+'.txtCodCliente',codigoCliente);
}


// Función que se ejecuta cuando el usuario pulsa el boton Añadir
function accionAnyadir() {
	if (sicc_validaciones_generales()) {
		var cuentaBancaria = get(FORMULARIO+'.cbCCC');
		var divisa = get(FORMULARIO+'.txtDivisa');
		var importeDivisa = get(FORMULARIO+'.txtImporteDivisa');
		var codigoCliente = get(FORMULARIO+'.txtCodCliente');
		var descripcionCuenta = get(FORMULARIO+'.cbCCC','T').toString();
		var glosaContable = get(FORMULARIO+'.txtGlosaContable');
		var tipoAbono = get(FORMULARIO+'.cbTipoAbono','T').toString();
		var tipoAbonoOid = get(FORMULARIO+'.cbTipoAbono').toString();
		var importe = get(FORMULARIO+'.txtImporte');
		
		if (divisa != '' && importeDivisa == '') {
			// Muestra el mensaje: Introduzca el importe para la divisa que ha seleccionado
			GestionarMensaje('1088');
			focaliza(FORMULARIO+'.txtImporteDivisa');
			return;
		}
		
		if (divisa == '' && importeDivisa != '') {
			// Muestra el mensaje: Seleccione una divisa para el importe divisa introducido
			GestionarMensaje('1089');
			focaliza(FORMULARIO+'.txtDivisa');
			return;
		}
		
		// Se crea un array con los siguientes campos :codigoCliente, descripcion cuenta bancaria, 
		// glosaContable, tipoAbono, importe, descripcion divisa, importeDivisa, cuentaBancaria y 
		// divisa.
		arrayConceptos = [codigoCliente,descripcionCuenta,tipoAbono,glosaContable,divisa,importe,importeDivisa,cuentaBancaria, tipoAbonoOid];
		//arrayConceptos = [codigoCliente,'asdfdsf','adsfdsaf',glosaContable,divisa,importe,importeDivisa,cuentaBancaria];
		// Se cierra la ventana y se devuelve el array
		window.returnValue = arrayConceptos;
		window.close();
	} 
}


// Función que se ejecuta cuando pierde el foco el campo Codigo de cliente
function codigoClienteOnBlur() {
	var codigoCliente = get(FORMULARIO+'.txtCodCliente');
	
	if (codigoCliente != '') {
		var longitudCodigoCliente = get(FORMULARIO+'.longitudCodigoCliente');
		var longitud = codigoCliente.length;
		
		// Se rellena el código de cliente con ceros
		var codigoClienteCeros = rellenaCeros(codigoCliente,longitudCodigoCliente,
			longitud);
		set(FORMULARIO+'.txtCodCliente',codigoClienteCeros); 
	}	
} 


// Función que se ejecuta cuando pierde el foco el campo Importe
function importeOnBlur() {
	var divisa = get(FORMULARIO+'.txtDivisa');
	var importe = get(FORMULARIO+'.txtImporte');
	var tasaCambioMonedaAlternativa = get(FORMULARIO+'.tasaCambioMonedaAlternativa');
	
	var separadorMiles = get(FORMULARIO +'.hid_SeparadorMiles');
	var separadorDecimales = get(FORMULARIO +'.hid_SeparadorDecimales');
	var numeroDecimales = get(FORMULARIO+'.hid_NumeroDecimales');

	if (importe != '' && validaImporte('txtImporte', 10)) {
		// Se pasa el importe a número para poder realizar los calculos
		var numImporte = obtieneNumeroDecimal(importe,separadorDecimales);

		// Se formatea el importe, añadiendo separadores de miles si hace falta
		set(FORMULARIO+'.txtImporte',formateaImporte(numImporte, separadorMiles, separadorDecimales));

		// Si se ha seleccionado la divisa se calcula el importeDivisa
		if (divisa != '' && tasaCambioMonedaAlternativa != '') {
			var importeDivisa = numImporte * Number(tasaCambioMonedaAlternativa);
			
			// Se redondea al numero de decimales permitido
			var importeDivisaRed = redondea(importeDivisa,numeroDecimales);
			
			set(FORMULARIO+'.txtImporteDivisa',formateaImporte(importeDivisaRed, separadorMiles, separadorDecimales));
		}
	} 
}


// Función que se ejecuta cuando pierde el foco el campo Importe Divisa 
function importeDivisaOnBlur() {
	var divisa = get(FORMULARIO+'.txtDivisa');
	var importeDivisa = get(FORMULARIO+'.txtImporteDivisa');
	var tasaCambioMonedaAlternativa =get(FORMULARIO+'.tasaCambioMonedaAlternativa');
	
	var separadorMiles = get(FORMULARIO +'.hid_SeparadorMiles');
	var separadorDecimales = get(FORMULARIO +'.hid_SeparadorDecimales');
	var numeroDecimales = get(FORMULARIO+'.hid_NumeroDecimales');

	if (importeDivisa !='' && validaImporte('txtImporteDivisa', 10)) {	
		// Se pasa el importeDivisa a número para poder realizar los calculos
		var temp = obtieneNumeroDecimal(importeDivisa, separadorDecimales);
		
		// Se redondea al numero de decimales permitido
		var numImporteDivisa = redondea(temp,numeroDecimales);
		
		// Se formatea el importe, añadiendo separadores de miles si hace falta
		set(FORMULARIO+'.txtImporteDivisa',formateaImporte(numImporteDivisa, separadorMiles, separadorDecimales));
		
		// Si se ha seleccionado la divisa se calcula el importe
		if (divisa != '' && tasaCambioMonedaAlternativa != '') {
			var importe= numImporteDivisa / Number(tasaCambioMonedaAlternativa);
			
			// Se redondea al numero de decimales permitido
			var importeRed = redondea(importe,numeroDecimales);
			set(FORMULARIO+'.txtImporte',formateaImporte(importeRed, separadorMiles, separadorDecimales));
		}
	} 
}

function divisaOnChange() { 
	var divisa = get(FORMULARIO+'.txtDivisa');
	var tasaCambioMonedaAlternativa =get(FORMULARIO+'.tasaCambioMonedaAlternativa');
	var importeDivisa = get(FORMULARIO+'.txtImporteDivisa');
	var importe = get(FORMULARIO+'.txtImporte');
	
	var separadorMiles = get(FORMULARIO +'.hid_SeparadorMiles');
	var separadorDecimales = get(FORMULARIO +'.hid_SeparadorDecimales');
	var numeroDecimales = get(FORMULARIO+'.hid_NumeroDecimales');
	
	if (divisa != '') {
		set(FORMULARIO+'.txtDivisa', get(FORMULARIO+'.txtDivisa').toUpperCase());
		if (importe != '' && tasaCambioMonedaAlternativa != '') {
			// Se calcula  y formatea el importe divisa
			var numImporte = obtieneNumeroDecimal(importe,separadorDecimales);
			var numImporteDivisa = numImporte * Number(tasaCambioMonedaAlternativa);
			var importeDivisaRed = redondea(numImporteDivisa,numeroDecimales);
			set(FORMULARIO+'.txtImporteDivisa',formateaImporte(importeDivisaRed, separadorMiles, separadorDecimales));
			importeDivisaOnBlur();
		} else if (importeDivisa != '' && tasaCambioMonedaAlternativa != '') {
			// Se calcula y formatea el importe
			var numImporteDivisa = obtieneNumeroDecimal(importeDivisa, separadorDecimales);
			var numImporte = numImporteDivisa / Number(tasaCambioMonedaAlternativa);
			var importeRed = redondea(numImporte,numeroDecimales);
			set(FORMULARIO+'.txtImporte',formateaImporte(importeRed, separadorMiles, separadorDecimales));
		}
	} 
}

function validaFecha(nombreElemento) {
	var fecha = get(FORMULARIO+'.'+nombreElemento);
         
	if (fecha != '') {
		if (!EsFechaValida_SICC(fecha, FORMULARIO)) {
			// Muestra el mensaje: La fecha es incorrecta
			GestionarMensaje('947',FORMULARIO+'.'+nombreElemento);
			focaliza(FORMULARIO+'.'+nombreElemento);
			return false;
		}
	}
}


function validaImporte(nombreElemento, numeroEnteros) {
	var valor = get(FORMULARIO+'.'+nombreElemento);
	var numeroDecimales = get(FORMULARIO + '.hid_NumeroDecimales');
	var separadorMiles = get(FORMULARIO + '.hid_SeparadorMiles');
	var separadorDecimales = get(FORMULARIO + '.hid_SeparadorDecimales');
	
	var resultado = ValidaMilesDecimalesNegativo(valor,numeroEnteros,numeroDecimales,separadorMiles,
		separadorDecimales,0);
	if (resultado != 'OK') {
		cdos_mostrarAlert(resultado);
		focaliza(FORMULARIO+'.'+nombreElemento);
		return false;
	}
	return true;
}

function fLimpiar() {
/*	for (var i = 0; i < nombresCampos.length; i++){
		var campo = FORMULARIO+'.'+nombresCampos[i].split('|')[0];
		
		switch(nombresCampos[i].split('|')[1]){
			case "COMBO":		
					set(campo, 0);
					break;				
			case "TEXT":
				set(campo, "");
				break;
		}
	}*/
	if (get(FORMULARIO + '.txtCodCliente') != "") focaliza(FORMULARIO + '.cbCCC');
	else focaliza(FORMULARIO + '.txtCodCliente');
}

function fVolver() {
	window.close();
}

function focalizaAnterior(){
	if (codClienteDisabled) document.all['btnAnadir'].focus();
	else focaliza(FORMULARIO + '.txtCodCliente');
}

function focalizaSiguiente(){
	if (codClienteDisabled) focaliza(FORMULARIO + '.cbCCC');
	else focaliza(FORMULARIO + '.txtCodCliente');

}
