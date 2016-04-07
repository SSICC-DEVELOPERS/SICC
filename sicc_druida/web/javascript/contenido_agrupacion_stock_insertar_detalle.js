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
    $Id: contenido_agrupacion_stock_insertar_detalle.js,v 1.1 2009/12/03 19:01:32 pecbazalar Exp $
    DESC
*/

var FORMULARIO = 'formulario';

function onLoadPag(){
	var codOperacion = get(FORMULARIO + '.codOperacion');
	var acci = get(FORMULARIO +'.accion');
	if (codOperacion != ''){
		set(FORMULARIO +'.cbOperacion', [codOperacion]);
	}else{
		var operacion = get(FORMULARIO +'.operacion');
		if(operacion == '+'){
			codOperacion = "01";
			set(FORMULARIO +'.codOperacion',codOperacion);
		}else{
			codOperacion = "00";
			set(FORMULARIO +'.codOperacion',codOperacion);
		}
			set(FORMULARIO +'.cbOperacion', [codOperacion]);
	}
	varNoLimpiarSICC = true;
	if(acci == 'modificar'){
		accion(FORMULARIO +'.cbEstado','.disabled=true');	
		focaliza(FORMULARIO +'.cbOperacion','');
	}else{
		focaliza(FORMULARIO +'.cbEstado');
	}
	configurarMenuSecundario(FORMULARIO);
}

function accionAceptar(){
	var acc = get(FORMULARIO + '.accion');
	var estado = get(FORMULARIO +'.cbEstado','T').toString();
	var operador = get(FORMULARIO +'.cbOperacion','T').toString();
	var codestado = get(FORMULARIO +'.cbEstado').toString();
	var codoperador = get(FORMULARIO +'.cbOperacion').toString();
	var oid = get(FORMULARIO +'.oidEstadoMercancia');
	if (sicc_validaciones_generales()){
		window.returnValue = [oid,estado,operador,codestado,codoperador];
		window.close();
	}
}

function fVolver(){
         window.close();
}

function fLimpiar(){
	var operacion = get(FORMULARIO + '.codOperacion');
	var acci = get(FORMULARIO +'.accion');
	set(FORMULARIO + '.cbOperacion', [operacion]);
	if(acci == 'anadir'){
		set(FORMULARIO +'.cbEstado',[]);
	}
}

function focoboton(){
	document.all['btnAceptar'].focus();	
}

function focalizaBoton(){
	var accion = get(FORMULARIO +'.accion');
	if(accion == 'modificar'){
		focaliza(FORMULARIO +'.cbOperacion');
	}else{
		focaliza(FORMULARIO +'.cbEstado');
	}
}

function focobotonAceptar(){
	var accion = get(FORMULARIO +'.accion');
	if(accion == 'modificar'){
		document.all['btnAceptar'].focus();
	}else{
		focaliza(FORMULARIO +'.cbEstado');
	}
}