/**
* Copyright 2005 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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

var FORMULARIO = 'formulario';
/*var mensajeEstado = '';
var mensajeInicial = '';
var cadenaBlancos = '';
var BLANCOS = 0;
var TIEMPO = 0;
var CORTE = 1;*/
var desplazamiento = 1;

function onLoadPag(){
	var errDescripcion = get(FORMULARIO +'.errDescripcion');
	if (errDescripcion !='') {                            
		var errCodigo = get(FORMULARIO+'.errCodigo');
		var wnd = fMostrarMensajeError(errCodigo, errDescripcion);
	}
    configurarMenuSecundario(FORMULARIO);
    
	var marquesina = document.getElementById("marq");
	marquesina.scrollAmount = desplazamiento; // Cantidad de pixels que se desplaza en cada redrawing.
	marquesina.innerHTML = get(FORMULARIO + '.mensaje');

    /*BLANCOS = Number(get(FORMULARIO + '.blancos'));
    TIEMPO = Number(get(FORMULARIO + '.tiempo'));
    CORTE = Number(get(FORMULARIO + '.corte'));
    
    for (i = 0; i < BLANCOS; i++)
    	cadenaBlancos += ' ';
   	
	mensajeInicial = cadenaBlancos + get(FORMULARIO + '.mensaje');
	mensajeEstado = cadenaBlancos + get(FORMULARIO + '.mensaje');
	if (get(FORMULARIO + '.mensaje') != '') {
		//window.status = mensajeEstado;           // Se reemplaza por html MARQUEE
		//setTimeout ('mostrarMensaje()', TIEMPO); // Se reemplaza por html MARQUEE
	}*/
    focaliza(FORMULARIO + '.txtTelefonoLlamante');
}

/*function mostrarMensaje() {
	if (mensajeEstado.length > CORTE)
		mensajeEstado = mensajeEstado.substr(CORTE, mensajeEstado.length - CORTE);
	else
		mensajeEstado = mensajeInicial;
		
	window.status = mensajeEstado;
	setTimeout ('mostrarMensaje()', TIEMPO);
}*/


function accionBuscar(){
	if(sicc_validaciones_generales()) {
		/*var pais = get(FORMULARIO+'.pais');
		var idioma = get(FORMULARIO+'.idioma');
		set(FORMULARIO +'.telefono', get(FORMULARIO+'.txtTelefonoLlamante'));
		set(FORMULARIO +'.accion','Buscar Por Telefono');
		set(FORMULARIO +'.conectorAction','LPRecepcionLlamadas');
		enviaSICC(FORMULARIO); */
		var objParams = new Object();
		objParams.telefono = get(FORMULARIO+'.txtTelefonoLlamante');
		mostrarModalSICC('LPRecepcionLlamadas', 'Buscar Por Telefono', objParams, null, null);
	}
}

function fLimpiar(){
         focaliza(FORMULARIO+'.txtTelefonoLlamante');                      
}

function fVolver(){
         window.close();
}

function validarTfnoLlamante(){                                   
         var num = get(FORMULARIO+'.txtTelefonoLlamante'); 
         if(num != ""){
                  var val = allTrim(num);              
         //Como no nos interesa validar el número de dígitos que tiene el 
         //entero ponemos uno suficientemente grande. 
                  if ((ValidaInt(val.toString(),10000, 0)!="OK")||(val.toString() < 0)) {
                           GestionarMensaje('747', null, null, null);
                           focaliza(FORMULARIO+'.txtTelefonoLlamante');
                           return false;
                  }
         }                                   
} 
function allTrim(sStr){ 
          return rTrim(lTrim(sStr)); 
}
function lTrim(sStr){ 
          while (sStr.charAt(0) == " "){
                    sStr = sStr.substr(1, sStr.length - 1); 
          }
          return sStr; 
} 
function rTrim(sStr){ 
          while (sStr.charAt(sStr.length - 1) == " ") {
                    sStr = sStr.substr(0, sStr.length - 1); 
          }
          return sStr; 
}  

function operacionMarquesina() {
    var marquesinaTemp = document.getElementById("marq");
	//alert(desplazamiento);
	desplazamiento = desplazamiento + 1;
    if (desplazamiento == 5) {
		desplazamiento = 1;
	}   
	marquesinaTemp.scrollAmount = desplazamiento; // Cantidad de pixels que se desplaza
	
}