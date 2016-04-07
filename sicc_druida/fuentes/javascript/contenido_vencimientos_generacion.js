var FORMULARIO = 'frmGeneracionVencimientos';
var parametrosRecargaCombos = new Array();
var canalDisabled = false;
var accesoDisabled = false;
var subaccesoDisabled = false;
var codClienteDisabled = false;

function onLoadPag() {

	if (get(FORMULARIO + '.txtCodCliente') != "") {
		focaliza(FORMULARIO + '.cbMarca');
		codClienteDisabled = true;
	}
	else focaliza(FORMULARIO + '.txtCodCliente');

    configurarMenuSecundario(FORMULARIO);
    if (get(FORMULARIO + '.casoUso') == '') {
			if(get(FORMULARIO + '.acceso') != ""){
				accion(FORMULARIO+'.cbAcceso','.disabled=true');
				accesoDisabled = true;
			}
			if(get(FORMULARIO + '.subacceso') != ""){
				accion(FORMULARIO+'.cbSubacceso','.disabled=true');
				subaccesoDisabled = true;
			}
			if(get(FORMULARIO +'.canal') != ""){
				accion(FORMULARIO+'.cbCanal','.disabled=true');
				canalDisabled = true;
			}
	}
	if (get(FORMULARIO+'.errDescripcion') != '') {
         var wnd = fMostrarMensajeError(get(FORMULARIO+'.errCodigo'), get(FORMULARIO+'.errDescripcion'));
         if (get(FORMULARIO + '.casoUso') == '') window.close();
    }

	asignarEventosFichero2();
}


	
    function canalOnChange() {
         var canal = get(FORMULARIO + '.cbCanal');
         var idioma = get(FORMULARIO + '.idioma');
         var pais = get(FORMULARIO + '.pais');
         vaciaCombo(FORMULARIO + '.cbAcceso');
         vaciaCombo(FORMULARIO + '.cbSubacceso');
         if (canal != "")
                 recargaCombo(FORMULARIO + '.cbAcceso', 'SEGObtenerAccesosPorCanal', 'es.indra.sicc.dtos.seg.DTOAccesosPorCanal',  [["oidPais", pais], ["oidIdioma", idioma], ["oidCanal", canal]], 'seleccionaAcceso(datos)');
                 
     }

     function accesoOnChange() {
         var acceso = get(FORMULARIO + '.cbAcceso');
         var idioma = get(FORMULARIO + '.idioma');
         var pais = get(FORMULARIO + '.pais');
                  vaciaCombo(FORMULARIO + '.cbSubacceso');
                  if (acceso != "")
                           recargaCombo(FORMULARIO + '.cbSubacceso', 'SegObtenerSubaccesosPorAcceso', 'es.indra.sicc.util.DTOOID',  [["oidPais", pais], ["oidIdioma", idioma], ["oid", acceso]], 'seleccionaSubacceso(datos)' );
    }


	function vaciaCombo(combo) {
		set_combo(combo,[['','']],['']);
	}

// Función que se ejecuta al buscar el código de un cliente.
function accionSeleccionarCliente(){
	var objParametros = new Object();
	var arrCliente = mostrarModalSICC("LPBusquedaRapidaCliente", "", objParametros, null, null);
	if (arrCliente != null && arrCliente.length > 1) {
		set(FORMULARIO+'.txtCodCliente', arrCliente[1].toString());
	}
}
//valida que el campo cantidad sea numerico
function validaNumDoc (elemento) {
         
         var valor = get(FORMULARIO + '.' + elemento);
         if (valor != "") {
                  if (ValidaCaracteres(valor,'0123456789') != 'OK') {
                           var mensaje= DrdMsgCore(143) + '0123456789';
                           if (mensaje != "OK") {
                                    cdos_mostrarAlert(mensaje);
                                    focaliza(FORMULARIO + '.'+elemento);
                                    return false;
                           }  
                  }
         }
         return true;
}


// Función que se ejecuta al pulsar el botón añadir.
function accionAnnadir(){
	if (!sicc_validaciones_generales()) { return false; }
	
	var res = EsFechaValida(get(FORMULARIO +'.txtFechaValor'),get(FORMULARIO +'.txtFechaVencimiento'),FORMULARIO,null);
	if(res == 3){
		GestionarMensaje('1434');
		focaliza(FORMULARIO +'.txtFechaVencimiento');
		return false;
	}
	
	if(get(FORMULARIO+'.cbMarca')==""){
		cdos_mostrarAlert(GestionarMensaje('1076'));
		focaliza(FORMULARIO+'.cbMarca');
		return false;
	}
	if(get(FORMULARIO+'.txtCodCliente')==""){
		GestionarMensaje('742');
		focaliza(FORMULARIO+'.txtCodCliente');
		return false;
	}
	if(!validaNumDoc('txtNDoc')) return false;

	if(get(FORMULARIO+'.txtNDoc').toString().length!=10){
		cdos_mostrarAlert(GestionarMensaje('1128')+" "+get(FORMULARIO+'.txtNDoc').toString());
		focaliza(FORMULARIO+'.txtNDoc');
		return false;
	}

	if((get(FORMULARIO+'.txtDivisa').toString()!="")&&(get(FORMULARIO+'.txtImporteDivisa').toString()=="")){
		GestionarMensaje('1088');
		focaliza(FORMULARIO+'.txtImporteDivisa');
	}else if((get(FORMULARIO+'.txtDivisa').toString()=="")&&(get(FORMULARIO+'.txtImporteDivisa').toString()!="")){
		GestionarMensaje('1089');
		focaliza(FORMULARIO+'.txtDivisa');
	}else{
		var codigoCliente = get(FORMULARIO+'.txtCodCliente').toString();
		var marcaDesc = get(FORMULARIO+'.cbMarca','T').toString();
		var canal = get(FORMULARIO +'.cbCanal','T').toString();
		var acceso = get(FORMULARIO +'.cbAcceso','T').toString();
		var subacceso = get(FORMULARIO +'.cbSubacceso','T').toString();
		var numeroDocumento = get(FORMULARIO+'.txtNDoc').toString();
		var referenciaExterna = get(FORMULARIO +'.txtReferenciaExterna').toString();
		var medioPagoDescripcion = get(FORMULARIO+'.cbMedioPago','T').toString();
		var divisa = get(FORMULARIO+'.txtDivisa').toString();
		var importe = get(FORMULARIO+'.txtImporte').toString();
		var importeDivisa = get(FORMULARIO+'.txtImporteDivisa').toString();
		var observaciones = get(FORMULARIO+'.areatxtObservaciones').toString();
		var medioPagoOid = get(FORMULARIO+'.cbMedioPago').toString();
		var marcaOid = get(FORMULARIO+'.cbMarca').toString();
		var subaccesoOid = get(FORMULARIO +'.cbSubacceso').toString();
		var accesoOid = get(FORMULARIO +'.cbAcceso').toString();
		var canalOid = get(FORMULARIO +'.cbCanal').toString();
		var fechaValor = get(FORMULARIO +'.txtFechaValor').toString();
		var fechaVencimiento = get(FORMULARIO +'.txtFechaVencimiento').toString();

		//alert([[codigoCliente,marcaDesc,canal,acceso,subacceso, numeroDocumento, referenciaExterna, fechaValor, fechaVencimiento, medioPagoDescripcion,divisa, importe, importeDivisa, observaciones, medioPagoOid, marcaOid, canalOid, accesoOid, subaccesoOid]]);
		
		window.returnValue = [[codigoCliente,marcaDesc,canal,acceso,subacceso, numeroDocumento, referenciaExterna, fechaValor, fechaVencimiento, medioPagoDescripcion,divisa, importe, importeDivisa, observaciones, medioPagoOid, marcaOid, canalOid, accesoOid, subaccesoOid]];
		window.close();	
	}
}

// Función que se ejecuta en el OnBlur del campo codigoCliente.
function codigoClienteOnBlur() {
	var codigoCliente = get(FORMULARIO+'.txtCodCliente').toString();
	if (codigoCliente != '') {
		var longitudCodigoCliente = get(FORMULARIO+'.longitudCodigoCliente').toString();
		var longitud = codigoCliente.length;
		set(FORMULARIO+'.txtCodCliente',rellenaCeros(codigoCliente,longitudCodigoCliente,longitud));
	}
	//valida el numero de documento en relacion al cliente.
	validarNumeroDocumento();
}

// Función que se ejecuta cuando cambia el campo numero documento.
function validarNumeroDocumento() {
		var codigoCliente = get(FORMULARIO+'.txtCodCliente').toString();
		set(FORMULARIO + '.hCodigoCliente',codigoCliente);
		var nroDocumento = get(FORMULARIO+'.txtNDoc').toString();
		set(FORMULARIO + '.hNroDucumento',nroDocumento);
		if (nroDocumento != "") {
				// es necesario el codigo de cliente para validar si el numero de documento pertenece al cliente.
				if (codigoCliente == '') {
						GestionarMensaje('807');
						focaliza(FORMULARIO+'.txtCodCliente');
				} else {
						set(FORMULARIO + '.accion','validarNroDucumento');
						set(FORMULARIO + '.conectorAction','LPGeneracionVencimientos');
						eval(FORMULARIO).oculto = 'S';
						enviaSICC(FORMULARIO);
				}
		}
}

//Funcion que se ejecuta luego de validar el numero de documento e informa el estado.
function postValidarNroDucumento(estadoValidacionNroDocumento) {
	if (estadoValidacionNroDocumento == 'NE') {
			GestionarMensaje('805');
			focaliza(FORMULARIO+'.txtNDoc');
	} else {
			if (estadoValidacionNroDocumento == 'NP') {
					GestionarMensaje('806');
					set(FORMULARIO+'.txtNDoc','');
					focaliza(FORMULARIO+'.txtNDoc');
			} else {
					//en este caso, se valido que existe el numero de documento para el cliente.
					focaliza(FORMULARIO+'.txtReferenciaExterna');
			}
	}
}

// Función que se ejecuta cuando pierde el foco el campo Importe
function importeOnBlur() {
	var divisa = get(FORMULARIO+'.txtDivisa');
	var importe = get(FORMULARIO+'.txtImporte');
	var tasaCambioMonedaAlternativa = get(FORMULARIO+'.tasaCambioMonedaAlternativa');

	if (importe != '' && validaImporte('txtImporte', 10)) {
		// Doy el formato correcto al importe.
		var separadorMiles = get(FORMULARIO + '.hid_SeparadorMiles');
		var separadorDecimales = get(FORMULARIO + '.hid_SeparadorDecimales');
		var numeroDecimales = get(FORMULARIO + '.hid_NumeroDecimales');

		var numImporte = obtieneNumeroDecimal(importe, separadorDecimales);

		// Si se ha seleccionado la divisa calculo el importeDivisa correcto.
		// Realizo los cálculos antes de redondear el importe para obtener mayor precisión en los cálculos.
		if ((divisa != '')&&(tasaCambioMonedaAlternativa != '')) {
			var importeDivisa = numImporte * Number(tasaCambioMonedaAlternativa);
			importeDivisa = redondea(importeDivisa, numeroDecimales);
			set(FORMULARIO+'.txtImporteDivisa', formateaImporte(importeDivisa, separadorMiles, separadorDecimales));
		}
		numImporte = redondea(numImporte,numeroDecimales);
		set(FORMULARIO+'.txtImporte', formateaImporte(numImporte, separadorMiles, separadorDecimales));
	}else if(divisa!=''){
		set(FORMULARIO+'.txtImporte','');
		set(FORMULARIO+'.txtImporteDivisa','');	
	}
}

// Función que se ejecuta cuando pierde el foco el campo Importe Divisa 
function importeDivisaOnBlur() {
	var divisa = get(FORMULARIO+'.txtDivisa');
	var importeDivisa = get(FORMULARIO+'.txtImporteDivisa');
	var tasaCambioMonedaAlternativa = get(FORMULARIO+'.tasaCambioMonedaAlternativa');

	if (importeDivisa != '' && validaImporte('txtImporteDivisa', 10)) {
		// Doy el formato correcto a importeDivisa.		
		var separadorMiles = get(FORMULARIO + '.hid_SeparadorMiles');
		var separadorDecimales = get(FORMULARIO + '.hid_SeparadorDecimales');
		var numeroDecimales = get(FORMULARIO + '.hid_NumeroDecimales');

		var numImporteDivisa = obtieneNumeroDecimal(importeDivisa, separadorDecimales);

		// Si se ha seleccionado la divisa calculo el importe correcto.
		// Realizo los cálculos antes de redondear el importe para obtener mayor precisión en los cálculos.
		if ((divisa != '')&&(tasaCambioMonedaAlternativa != '')) {
			var importe= numImporteDivisa / Number(tasaCambioMonedaAlternativa);
			importe = redondea(importe,numeroDecimales);
			set(FORMULARIO+'.txtImporte', formateaImporte(importe, separadorMiles, separadorDecimales));
		}
		numImporteDivisa = redondea(numImporteDivisa,numeroDecimales);
		set(FORMULARIO+'.txtImporteDivisa', formateaImporte(numImporteDivisa, separadorMiles, separadorDecimales));
	} else if(divisa != '') {
		set(FORMULARIO+'.txtImporte','');
		set(FORMULARIO+'.txtImporteDivisa','');	
	}
}

// Función que valida si un importe es válido.
function validaImporte(nombreElemento, numeroEnteros) {

	var valor = get(FORMULARIO+'.'+nombreElemento);
	var numeroDecimales = get(FORMULARIO + '.hid_NumeroDecimales');
	var separadorMiles = get(FORMULARIO + '.hid_SeparadorMiles');
	var separadorDecimales = get(FORMULARIO + '.hid_SeparadorDecimales');

	var resultado = ValidaMilesDecimalesNegativo(valor, numeroEnteros, numeroDecimales, separadorMiles, separadorDecimales,0);
	if (resultado != 'OK') {
		cdos_mostrarAlert(resultado);
		focaliza(FORMULARIO+'.'+nombreElemento);
		return false;
	}
	return true;
}

// Función que se ejecutará en el evento onLoad de la página cuando se acepte el envío,
//devolverá los datos almacenados en el array de JavaScript arrConsulta (almacenados desde la LP)
//y cerrará la página.
function accionAceptarEnvio() {
	if (datosRetorno != null && datosRetorno.length > 0) {
		window.returnValue = datosRetorno;
	} else
		cdos_mostrarAlert(GestionarMensaje('1451'));
	window.close();
}

// Función que se ejecutará al recargar la página cuando se haya seleccionado un archivo.
function procesarArchivo(file) {
	set(FORMULARIO+'.nombreArchivo',file);
	set(FORMULARIO+'.accion',"AceptarEnvioArchivo");
	set(FORMULARIO+'.conectorAction',"LPGeneracionVencimientos");
	enviaSICC(FORMULARIO,null,null,"N");
}

function btnAnadirOnTab(){
	// Paso el foco al campo tipo file.
	document.forms['fichero2_form'].elements[4].focus();
}

function txtCodClienteOnShTab(){
	// Paso el foco al botón asignar.
	document.forms['fichero2_form'].elements[6].focus();	
}

function focalizaAnterior(){
	if (codClienteDisabled) document.forms['fichero2_form'].elements[6].focus();
	else focaliza(FORMULARIO + '.txtCodCliente');
}

function fichero2OnTab(){
	if (codClienteDisabled) focaliza(FORMULARIO + '.cbMarca');
	else
		focaliza(FORMULARIO + '.txtCodCliente');
}

function fichero2OnShTab(){
	document.all['btnAnadir'].focus();
}

function fontab_fichero2(e){
        if (ns) return true;
        var codigoTecla = (window.Event) ? e.which : event.keyCode;
        var shift_pul=(ie)?e.shiftKey:false;
        if (shift_pul || codigoTecla!=9) {return true;}
		fichero2OnTab();
        event.returnValue=false;		
}

function fonshtab_fichero2(e) {
        if (ns) return true;
		var codigoTecla = (window.Event) ? e.which : event.keyCode;
        var shift_pul=(ie)?e.shiftKey:false;
		if (!shift_pul || codigoTecla!=9) {return true;}
		fichero2OnShTab();
		event.returnValue=false;}


function asignarEventosFichero2(){
	// Asigno al evento ontab del botón asignar la función fichero2OnTab();
	document.forms['fichero2_form'].elements[6].onkeydown=function(){fontab_fichero2(event)}
	document.forms['fichero2_form'].elements[4].onkeydown=function(){fonshtab_fichero2(event);return false;}
		
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
		} else if (importeDivisa != '' && tasaCambioMonedaAlternativa != '') {
			// Se calcula y formatea el importe
			var numImporteDivisa = obtieneNumeroDecimal(importeDivisa, separadorDecimales);
			var numImporte = numImporteDivisa / Number(tasaCambioMonedaAlternativa);
			var importeRed = redondea(numImporte,numeroDecimales);
			set(FORMULARIO+'.txtImporte',formateaImporte(importeRed, separadorMiles, separadorDecimales));
		}
	} else{
		set(FORMULARIO+'.txtImporteDivisa',"");
	}
}

function fVolver(){
	window.close();	
}

	function fLimpiar() {
		
			set(FORMULARIO+'.areatxtObservaciones','');
			var canal = get(FORMULARIO + '.canal');
			set(FORMULARIO + '.cbCanal', [canal]);
			if (!canalDisabled)
				vaciaCombo(FORMULARIO + '.cbAcceso');
			else {
				var acceso = get(FORMULARIO + '.acceso');
				set(FORMULARIO + '.cbAcceso', [acceso]);
			}

			if (!accesoDisabled)
				vaciaCombo(FORMULARIO + '.cbSubacceso');
			else {
				var subacceso = get(FORMULARIO + '.subacceso');
				set(FORMULARIO + '.cbSubacceso', [subacceso]);
			}
		if (get(FORMULARIO + '.txtCodCliente') != "") focaliza(FORMULARIO + '.cbMarca');
		else focaliza(FORMULARIO + '.txtCodCliente');

	}

         function seleccionaAcceso(datos) {
                  var acceso = get(FORMULARIO + '.acceso');
                  set_combo(FORMULARIO+'.cbAcceso', incluyeOpcionVacia(datos));
                  set(FORMULARIO + '.cbAcceso', [acceso]);
                  accesoOnChange();
         }
                  
         function seleccionaSubacceso(datos) {
                  var subacceso = get(FORMULARIO + '.subacceso');
                  set_combo(FORMULARIO+'.cbSubacceso', incluyeOpcionVacia(datos));
                  set(FORMULARIO + '.cbSubacceso', [subacceso]);
         }
	// Incluye la opcion vacia al principio del array 
	function incluyeOpcionVacia(datos) {
	         var datos2 = new Array();
	         datos2[0] = ['',''];
	         
	         for (var i=0;i<datos.length;i++) {
	         	datos2[i+1] = datos[i];
	         }
	         return datos2;
	}
         
//Recarga multiples combos, para ello recibe un array con tantas filas como combos a cargar
// cada fila debe tener las siguientes columnas: combo, idBusiness, dto, parametros y opcionalmente funcion
function recargaComboMultiple(parametros) {
           var i;
           var instruccion = "asignar([";

           for (i=0; i<parametros.length; ++i) {
           	instruccion = instruccion + "['COMBO', '" + parametros[i][0] + 
           	                 "', 'ConectorDruidaTransactionQuery', 'dtoSalida.resultado_ROWSET', " +
                                           "formarCadenaDT('" + parametros[i][1] + "', '" + parametros[i][2] + 
                                           "', " + parametros[i][3] + ")";
                  if (parametros[i].length == 5)
                           instruccion = instruccion + ", '" + parametros[i][4] + "'";

                  instruccion = instruccion + "]";
                  if (i != parametros.length -1) {
                  //Si no es la ultima fila ponemos la coma que separa del siguiente array  		
                           instruccion = instruccion + ", ";
                  }
           }
           instruccion = instruccion + "]);";

           eval(instruccion);
}

		function validaFecha(fecha) {
                  if(eval(FORMULARIO + '.' + fecha + 'RO') != "S"){
                           if (get(FORMULARIO + '.' + fecha).toString() != "")
                                    var resul = EsFechaValida(get(FORMULARIO + '.' + fecha), get(FORMULARIO + '.' + fecha), FORMULARIO, null);
                                    if (resul == 1 || resul == 2) {  
                                             var strCaja = FORMULARIO + '.' + fecha;
                                             GestionarMensaje('1006', get(FORMULARIO + '.hFormatoFechaPais'));
                                             focaliza(strCaja);
                                             return false;
                                    }
                  } 
         }

