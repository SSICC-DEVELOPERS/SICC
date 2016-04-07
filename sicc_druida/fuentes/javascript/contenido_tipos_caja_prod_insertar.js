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

function onLoadPag() {
    configurarMenuSecundario("formulario");
    if (get('formulario.cerrar') == "S") {
        set('formulario.cerrar', "N");
        window.close();
    }

    fMostrarMensajeError();
    focaliza('formulario.txtCodigoCaja');
}


function fGuardar() { // Equivale a onClickGuardar
    if (!sicc_validaciones_generales()) {
        return false;
    }
    
    set('formulario.conectorAction', 'LPMantenimientoTipoCajaProducto');
    set('formulario.accion', 'insertarTipoCaja');
    enviaSICC('formulario');
    
    if (get('formulario.opcionMenu') == "modificar") {
        var arrayParaDevolver = new Array();
        
        arrayParaDevolver[0] = get('formulario.txtCodigoCaja');
        arrayParaDevolver[1] = get('formulario.txtDescripcion');
        
        window.returnValue = arrayParaDevolver;
    }
    
}


function fLimpiar() {
    limpiaI18N("formulario", 1);
    
    var opcionMenu = get('formulario.opcionMenu');
    
    if (opcionMenu == 'insertar') {
        set("formulario.txtCodigoCaja", "");
        set("formulario.txtDescripcion", "");
        focaliza("formulario.txtCodigoCaja");
    } else if (opcionMenu == 'modificar') {
        set("formulario.txtDescripcion", get('formulario.hDescripcion'));
        focaliza("formulario.txtDescripcion");
    }       
}


function fVolver() {
    this.close();
}
