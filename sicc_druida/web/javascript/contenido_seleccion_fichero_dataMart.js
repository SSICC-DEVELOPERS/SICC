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
    $Id: contenido_seleccion_fichero_dataMart.js,v 1.1 2009/12/03 19:01:42 pecbazalar Exp $
    DESC
*/
var FORMULARIO = 'frmUnico';

function onLoadPag() {
	//focaliza(FORMULARIO +'.fichero2');
	configurarMenuSecundario(FORMULARIO);
	if (get(FORMULARIO+'.indOrigen') == 2){
    		btnProxy(1, 0); 
    }else{
    		btnProxy(1, 1); 
    }
	var errDescripcion = get(FORMULARIO +'.errDescripcion');
	if (errDescripcion !='') {		
		var errCodigo = get(FORMULARIO+'.errCodigo');
		var wnd = fMostrarMensajeError(errCodigo, errDescripcion);
      	}
}
function onClickAceptar(file) {
	set(FORMULARIO+'.path',file);
	set(FORMULARIO+'.accion',"");
	set(FORMULARIO+'.conectorAction',"LPAptas");
	set(FORMULARIO+'.indOrigen',get(FORMULARIO+'.indOrigen'));
	set(FORMULARIO+'.oid',get(FORMULARIO+'.oidCurso'));
	set(FORMULARIO+'.participantes',get(FORMULARIO+'.numParticipantes'));
	set(FORMULARIO+'.oidCursoSeleccionado', get(FORMULARIO+'.oidCurso'));
	enviaSICC(FORMULARIO,null,null,"N");
}

function fVolver(){
	window.close();
}
