
/**
* Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
* Avda. de Bruselas, 35
* Parque Empresarial Arroyo de la Vega
* 28108 Alcobendas, Madrid
* España
*
* Privado y Confidencial.
* La información contenida en este documento es propiedad de Indra sistemas.
* Para uso exclusivo de empleados autorizados no permitiéndose
* la distribución de este código sin permiso expreso.
*/ 


/*
    INDRA/CAR/PROY
    $Id: contenido_datos_cupones_introducir.js,v 1.1 2009/12/03 19:01:54 pecbazalar Exp $
    DESC
*/
var FORMULARIO = 'frmCapturarCupon';

function onLoadPag() {
	 eval (ON_RSZ);
	if (get(FORMULARIO+'.errDescripcion')!='') {
		var wnd = fMostrarMensajeError(get(FORMULARIO+'.errCodigo'), get(FORMULARIO+'.errDescripcion'));
		window.close();
	}

	//Control del foco
	focaliza(FORMULARIO + ".textCodCliente");

	configurarMenuSecundario(FORMULARIO);
		
}

	function fLimpiar() {
		focaliza(FORMULARIO + ".textCodCliente");
	}

	function fVolver(){
     	window.close();
	}


	//valida la fecha si el campo es modificable y no vacío 
	function validaFecha() {
		if (get(FORMULARIO + '.textFechaDocumento') != "") {
			var resul = EsFechaValida(get(FORMULARIO + '.textFechaDocumento'), get(FORMULARIO + '.textFechaDocumento'), FORMULARIO, null);
			if (resul == 1 || resul == 2) {  
				GestionarMensaje('1006', get(FORMULARIO + '.hFormatoFechaPais'));
				focaliza(FORMULARIO + '.textFechaDocumento');
				return false;
			}
		} 
	}

	function vaciaCombo(combo) {
		set_combo(combo, [['','']], ['']);
	}


	function accionBTN_Verificar() {
		if (!sicc_validaciones_generales()) { return false; }
		var numeroCupon = get(FORMULARIO + '.textNCupon');
		var codigoCliente = get(FORMULARIO + '.textCodCliente');
		var importe = get(FORMULARIO + '.textImporte');
		//Comprobamos que se han introducido los criterios mínimos: 

		/*if (numeroCupon == "" && (codigoCliente == "" || importe == "" )) {
			cdos_mostrarAlert(GestionarMensaje('1429'));
			if (codigoCliente == "" && importe == "") focaliza(FORMULARIO + '.textNCupon');
			else if (codigoCliente == "") focaliza(FORMULARIO + '.textCodCliente');
			else focaliza(FORMULARIO + '.textImporte');
			return false;
		} else if (numeroCupon != "" && (codigoCliente != "" || importe != "" )) {
			cdos_mostrarAlert(GestionarMensaje('1429'));
			if (codigoCliente != "") focaliza(FORMULARIO + '.textCodCliente');
			else focaliza(FORMULARIO + '.textImporte');
			return false;
		}
		*/

	    eval(FORMULARIO).oculto = 'S';
		set(FORMULARIO + '.accion', 'verificar');
		set(FORMULARIO + '.conectorAction', "LPCapturarCupon3");
		enviaSICC(FORMULARIO);
	}

	
 function verificacionCorrecta() {
	  eval(FORMULARIO).oculto = 'N';	 
	  GestionarMensaje("2628", null, null, null);

	  window.returnValue = "recarga";
	  window.close();
  }

 function verificacionIncorrecta() {
	  eval(FORMULARIO).oculto = 'N';	 

	  window.returnValue = "recarga";
	  window.close();
  }

	
// Función que se ejecuta al buscar el código de un cliente.
function accionSeleccionarCliente(){
         var objParametros = new Object();
         var arrCliente = mostrarModalSICC("LPBusquedaRapidaCliente", "", objParametros, null, null);
         if (arrCliente != null && arrCliente.length > 1) {
                  set(FORMULARIO + '.textCodCliente', arrCliente[1].toString());
         }
}

// Función que se ejecuta en el OnBlur del campo codigoCliente.
function codigoClienteOnBlur() {
          var codigoCliente = get(FORMULARIO + '.textCodCliente').toString();

          if (codigoCliente != '') {
                    var longitudCodigoCliente = get(FORMULARIO + '.longitudCodigoCliente').toString();
                    var longitud = codigoCliente.length;
                    set(FORMULARIO + '.textCodCliente', rellenaCeros(codigoCliente, longitudCodigoCliente, longitud))
          }
}

	function onBlurNCupon(){
		if(get(FORMULARIO +'.textNCupon') != "" && esNumero(get(FORMULARIO +'.textNCupon')) == '-1') {
			GestionarMensaje('747');
			focaliza(FORMULARIO + '.textNCupon');	
		}
	}

function importeOnBlur() {
	validaImporte('textImporte', 10)
}

// Función que valida si un importe es válido.
function validaImporte(nombreElemento, enteros) {

	var valor = get(FORMULARIO + '.' + nombreElemento);
	if (valor != "") {
		var numeroDecimales = get(FORMULARIO + '.hid_NumeroDecimales');
		var separadorMiles = get(FORMULARIO + '.hid_SeparadorMiles');
		var separadorDecimales = get(FORMULARIO + '.hid_SeparadorDecimales');
		//var numeroEnteros = longitudMax - numeroDecimales - 1;
	
		var resultado = ValidaMilesDecimales(valor, enteros, numeroDecimales, separadorMiles, separadorDecimales, 0);
		if (resultado != 'OK') {
			cdos_mostrarAlert(resultado);
			focaliza(FORMULARIO + '.' + nombreElemento);
			return false;
		}
	}
	return true;
}
