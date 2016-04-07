/**
* Copyright 2004 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
    $Id: contenido_no_asistentes_seleccionar.js,v 1.1 2009/12/03 19:02:00 pecbazalar Exp $
    DESC
*/

var FORMULARIO = 'formulario';

function onLoadPag()   {
	if (get(FORMULARIO+'.errDescripcion')!='') {
                  var wnd = fMostrarMensajeError(get(FORMULARIO+'.errCodigo'),get(FORMULARIO+'.errDescripcion'));
    }
	configurarMenuSecundario(FORMULARIO);
  	focaliza(FORMULARIO+'.txtCodCurso',''); 
}

function onClickAceptar(){
	set(FORMULARIO +'.accion','SegundaConvocatoria');
	enviaSICC(FORMULARIO);
}

function fAceptarCorrecto(){
	window.close();	
}
function validarCodCurso(){
    var num = get(FORMULARIO+'.txtCodCurso'); 
 	if(num != ""){
		var val = allTrim(num);             
    	//Como no nos interesa validar el número de dígitos que tiene el 
    	//entero ponemos uno suficientemente grande. 
		if ((ValidaInt(val.toString(),10000, 0)!="OK")||(val.toString() < 0)) {
			GestionarMensaje('747', null, null, null);
			focaliza(FORMULARIO+'.txtCodCurso');
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
function fVolver(){
         window.close();
}