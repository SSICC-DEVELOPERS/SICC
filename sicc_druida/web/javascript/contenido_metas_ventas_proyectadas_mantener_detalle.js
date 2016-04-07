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

//Autor: Marcelo J. Maidana


/**
 * Sistema:     Belcorp
 * Modulo:      INC
 * Fecha:       
 * @version     
 * @autor       Marcelo J. Maidana
 */
function onLoadPag(){
    fMostrarMensajeError();
    configurarMenuSecundario("formulario");
	gestionarCampos();

	if (txtActivas.disabled == false){
		focaliza('formulario.txtActivas');
	} else {
		focalizaBotonHTML('botonContenido', 'btnAceptar');
	}
}

/**
 * Sistema:     Belcorp
 * Modulo:      INC
 * Fecha:       
 * @version     
 * @autor       Marcelo J. Maidana
 */
function gestionarCampos(){
	deshabilitarCampos();

	if(get('formulario.hEstadoTxtActivas')=='S'){
		accion('formulario.txtActivas','.disabled=false');
	}

	if(get('formulario.hEstadoTxtIngreso')=='S'){
		accion('formulario.txtIngreso','.disabled=false');
	}

	if(get('formulario.hEstadoTxtReingreso')=='S'){
		accion('formulario.txtReingreso', '.disabled=false');
	}

	if(get('formulario.hEstadoTxtEgresos')=='S'){
		accion('formulario.txtEgresos', '.disabled=false');
	}

	if(get('formulario.hEstadoTxtEntregadas')=='S'){
		accion('formulario.txtEntregadas', '.disabled=false');
	}

	if(get('formulario.hEstadoTxtRecibidas')=='S'){
		accion('formulario.txtRecibidas', '.disabled=false');
	}

	if(get('formulario.hEstadoTxtCapitalizacion')=='S'){
		accion('formulario.txtCapitalizacion', '.disabled=false');
	}

	if(get('formulario.hEstadoTxtActivasFinales')=='S'){
		accion('formulario.txtActivasFinales', '.disabled=false');
	}

	if(get('formulario.hEstadoTxtActividad')=='S'){
		accion('formulario.txtActividad', '.disabled=false');
	}

	if(get('formulario.hEstadoTxtNumPedidos')=='S'){
		accion('formulario.txtNumPedidos', '.disabled=false');
	}

	if(get('formulario.hEstadoTxtPrecioPromedioUnitario')=='S'){
		accion('formulario.txtPrecioPromedioUnitario', '.disabled=false');
	}

	if(get('formulario.hEstadoTxtPromedioVentaPedido')=='S'){
		accion('formulario.txtPromedioVentaPedido', '.disabled=false');
	}

	if(get('formulario.hEstadoTxtPromedioUnidadesPedido')=='S'){
		accion('formulario.txtPromedioUnidadesPedido', '.disabled=false');
	}

	if(get('formulario.hEstadoTxtPromedioOrdenesPedido')=='S'){
		accion('formulario.txtPromedioOrdenesPedido', '.disabled=false');
	}

	if(get('formulario.hEstadoTxtRetencion')=='S'){
		accion('formulario.txtRetencion', '.disabled=false');
	}

	if(get('formulario.hEstadoTxtVentaEstadisticable')=='S'){
		accion('formulario.txtVentaEstadisticable', '.disabled=false');
	}
}

/**
 * Sistema:     Belcorp
 * Modulo:      INC
 * Fecha:       
 * @version     
 * @autor       Marcelo J. Maidana
 */
function habilitarCampos(){
	accion('formulario.txtActivas','.disabled=false');
	accion('formulario.txtIngreso','.disabled=false');
	accion('formulario.txtReingreso', '.disabled=false');
	accion('formulario.txtEgresos', '.disabled=false');
	accion('formulario.txtEntregadas', '.disabled=false');
	accion('formulario.txtRecibidas', '.disabled=false');
	accion('formulario.txtCapitalizacion', '.disabled=false');
	accion('formulario.txtActivasFinales', '.disabled=false');
	accion('formulario.txtActividad', '.disabled=false');
	accion('formulario.txtNumPedidos', '.disabled=false');
	accion('formulario.txtPrecioPromedioUnitario', '.disabled=false');
	accion('formulario.txtPromedioVentaPedido', '.disabled=false');
	accion('formulario.txtPromedioUnidadesPedido', '.disabled=false');
	accion('formulario.txtPromedioOrdenesPedido', '.disabled=false');
	accion('formulario.txtRetencion', '.disabled=false');
	accion('formulario.txtVentaEstadisticable', '.disabled=false');
}

/**
 * Sistema:     Belcorp
 * Modulo:      INC
 * Fecha:       
 * @version     
 * @autor       Marcelo J. Maidana
 */
function deshabilitarCampos(){
    accion('formulario.txtActivas','.disabled=true');
	accion('formulario.txtIngreso','.disabled=true');
	accion('formulario.txtReingreso', '.disabled=true');
	accion('formulario.txtEgresos', '.disabled=true');
	accion('formulario.txtEntregadas', '.disabled=true');
	accion('formulario.txtRecibidas', '.disabled=true');
	accion('formulario.txtCapitalizacion', '.disabled=true');
	accion('formulario.txtActivasFinales', '.disabled=true');
	accion('formulario.txtActividad', '.disabled=true');
	accion('formulario.txtNumPedidos', '.disabled=true');
	accion('formulario.txtPrecioPromedioUnitario', '.disabled=true');
	accion('formulario.txtPromedioVentaPedido', '.disabled=true');
	accion('formulario.txtPromedioUnidadesPedido', '.disabled=true');
	accion('formulario.txtPromedioOrdenesPedido', '.disabled=true');
	accion('formulario.txtRetencion', '.disabled=true');
	accion('formulario.txtVentaEstadisticable', '.disabled=true');
}

/**
 * Sistema:     Belcorp
 * Modulo:      INC
 * Fecha:       
 * @version     
 * @autor       Marcelo J. Maidana
 */
function accionAceptar(){
    var obj = new Object();
    obj.oid = get('formulario.oid');
	obj.cliente = get('formulario.cliente');
	obj.activas = get('formulario.txtActivas');
	obj.ingresos = get('formulario.txtIngreso');
	obj.reingresos = get('formulario.txtReingreso');
    obj.egresos = get('formulario.txtEgresos');        
	obj.entregadas = get('formulario.txtEntregadas');
	obj.recibidas = get('formulario.txtRecibidas');
	obj.capitalizacion = get('formulario.txtCapitalizacion');
    obj.actFinales = get('formulario.txtActivasFinales');
    obj.actividad = get('formulario.txtActividad');
    obj.pedidos = get('formulario.txtNumPedidos');
    obj.precioPromUnitario = get('formulario.txtPrecioPromedioUnitario');
    obj.promedioVtaPedido = get('formulario.txtPromedioVentaPedido');
    obj.promUnidadesPedido = get('formulario.txtPromedioUnidadesPedido');
    obj.promOrdenesPedido = get('formulario.txtPromedioOrdenesPedido');
    obj.retencion = get('formulario.txtRetencion');
    obj.ventasEstadisticab = get('formulario.txtVentaEstadisticable');
		
    window.returnValue = obj;
    window.close();
}

/**
 * Sistema:     Belcorp
 * Modulo:      INC
 * Fecha:       
 * @version     
 * @autor       Marcelo J. Maidana
 */
function setTabFocus(campo){
	if (campo == 'btnAceptar' && txtActivas.disabled == false){
		focaliza('formulario.txtActivas');
	}
}

/**
 * Sistema:     Belcorp
 * Modulo:      INC
 * Fecha:       
 * @version     
 * @autor       Marcelo J. Maidana
 */
function setSHTabFocus(campo){
	if (campo == 'txtActivas'){
		focalizaBotonHTML('botonContenido', 'btnAceptar');
	}
}

function fVolver() {
	window.close();
}

