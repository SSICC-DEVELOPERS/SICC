/**
 * Copyright 2007 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
    fMostrarMensajeError();    
    focaliza("formulario.txtVersion");
}

function onClickAceptar() {
    if (sicc_validaciones_generales()) {
         casoDeUso = get('formulario.casoDeUso');
         
         eval('formulario').oculto = 'S';

                  if(casoDeUso=='PreasignarProductos'){
             set('formulario.conectorAction', 'LPPreasignarProductos');
         }
                  else if(casoDeUso == 'AsignacionManualProductos'){
             set('formulario.conectorAction', 'LPMantenerAsignacionManualProductos');
         }
                  else if(casoDeUso == 'EjecutarBalanceo'){
             set('formulario.conectorAction', 'LPMantenerBalanceo');
         }
    
         set('formulario.accion', 'validarNuevaVersion');
         enviaSICC('formulario', null, null, 'N');
    }
}

function ejecutarOK(oidNuevaVersion, txtVersion) {
    var arrayParaDevolver = new Array();         
    arrayParaDevolver[0] = oidNuevaVersion;
    arrayParaDevolver[1] = txtVersion;
    window.returnValue = arrayParaDevolver;    
    window.close();
}

function ejecutarERR() {
         eval('formulario').oculto = 'N';
}

function fLimpiar() {
    set('formulario.txtVersion', '');
    set('formulario.hOidNuevaVersion', '');
    focaliza('formulario.txtVersion');
}

function fVolver() {
    var arrayParaDevolver = null;    
    window.returnValue = arrayParaDevolver;
    window.close();
}
