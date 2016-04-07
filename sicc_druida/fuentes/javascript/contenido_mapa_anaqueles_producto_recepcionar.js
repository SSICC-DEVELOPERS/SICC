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

function onLoadPag() {
    configurarMenuSecundario('formulario');
    fMostrarMensajeError();
         focaliza('formulario.cbMarca');
         set('formulario.cbCentroDistribucion', [get('formulario.hCbCentroDistribucion')]);
         onChangeCentroDistribucion();
}

function onChangeCbMarca(){
         set_combo('formulario.cbVersionAsignacion', arrayVacio());
         if ((get('formulario.cbMarca') != '')&&(get('formulario.cbCanal') != '')){
                  accion('formulario.cbPeriodo', '.disabled=false');
                  recargaCombo('formulario.cbPeriodo', 'CRAObtienePeriodos',
                           'es.indra.sicc.dtos.cra.DTOPeriodo', 
                           [['marca', get('formulario.cbMarca')], 
                           ['canal', get('formulario.cbCanal')],
                           ['oidIdioma', get('formulario.hIdioma')]]);
         }else{
         set_combo('formulario.cbPeriodo', arrayVacio());
         accion('formulario.cbPeriodo', '.disabled=true');
         }
}

function onChangeCentroDistribucion(){
         set_combo('formulario.cbVersionAsignacion', arrayVacio());
         
    if(get('formulario.cbCentroDistribucion') != ''){
         accion('formulario.cbMapaCentroDistribucion', '.disabled=false');
         recargaCombo('formulario.cbMapaCentroDistribucion', 'APEObtenerMapasCDPorCD', 
             'es.indra.sicc.util.DTOOID', [['oid', get('formulario.cbCentroDistribucion')], 
                           ['oidIdioma', get('formulario.hIdioma')]]);
    } else {
         set_combo('formulario.cbMapaCentroDistribucion', arrayVacio());
         accion('formulario.cbMapaCentroDistribucion', '.disabled=true');
    }
}

function onChangeCbCanal(){
         onChangeCbMarca();
}

function arrayVacio(){  
    var array = new Array();              
         array[0] = new Array('','');
  
    return array;
}

function onChangeCbMapaCentroDistribucion() {
         set_combo('formulario.cbVersionAsignacion', arrayVacio());
         
    if (get('formulario.cbPeriodo') != '' && get('formulario.cbMapaCentroDistribucion') != '') {
                  set("formulario.hCbPeriodo", get('formulario.cbPeriodo'));
                  set('formulario.hCbCentroDistribucion', get('formulario.cbCentroDistribucion'));
                  set('formulario.hCbMapaCentroDistribucion', get('formulario.cbMapaCentroDistribucion'));
                  eval("formulario").oculto= "S";
                  set("formulario.conectorAction", "LPRecepcionarMapaAnaquelesProducto");
                  set("formulario.accion", "cargarVersiones");
                  enviaSICC("formulario");
         }
}

/* dmorello, 26/02/2008 */
function onChangeCbPeriodo() {
         onChangeCbMapaCentroDistribucion();
}

function recepcion(){
         if(sicc_validaciones_generales()) {
                  set("formulario.hCbPeriodo", get('formulario.cbPeriodo'));
                  set('formulario.hCbCentroDistribucion', get('formulario.cbCentroDistribucion'));
         set('formulario.hCbMapaCentroDistribucion', get('formulario.cbMapaCentroDistribucion')); 
         set('formulario.hCbVersiones', get('formulario.cbVersionAsignacion', 'T')); 
         eval("formulario").oculto= "S";
         set("formulario.conectorAction", "LPRecepcionarMapaAnaquelesProducto");
         set("formulario.accion", "recepcionar");
         enviaSICC("formulario"); 
         }
}

function cerrarVentana() {
    limpieza();
}

function onTABMarca() {
         focoCanal();
}
function onTABCanal() {
         focoPeriodo();
}
function onTABPeriodo() {
         focoCentrDistr();
}
function onTABCentrDistr() {
         focoMapaCentrDistr();
}
function onTABBtnRece() {
         focoMarca();
}
function onShTABBtnRece() {
    focoVersion();      
}
function onShTABPeriodo() {
         focoCanal();
}
function onShTABCanal() {
         focoMarca();
}
function onShTABMarca() {
         focoBtnRece();
}
function onTABMapaCentrDistr() {
         focoVersion();
}
function onShTABCentrDistr() {  
         focoPeriodo();
}
function onShTABMapaCentrDistr() {
         focoCentrDistr();
}
function focoCanal() {
         focaliza("formulario.cbCanal");
}
function focoPeriodo() {
         focaliza("formulario.cbPeriodo");
}
function focoCentrDistr() {
         focaliza("formulario.cbCentroDistribucion");
}
function focoMapaCentrDistr() {
         focaliza("formulario.cbMapaCentroDistribucion");
}
function focoBtnRece() {
         focalizaBotonHTML('botonContenido','btnRecepcionar');	
}
function focoMarca() {
         focaliza("formulario.cbMarca");
}
function focoVersion() {
         focaliza("formulario.cbVersionAsignacion");
}
function onShTABVersion() {
         focoMapaCentrDistr();
}
function onTABVersion() {
         focoBtnRece();
}

function fLimpiar() {
         limpieza();
}

function limpieza(){
    focoMarca();
         set('formulario.cbMarca', '');
         set('formulario.cbCanal', '');
         set_combo('formulario.cbPeriodo', arrayVacio());
         set('formulario.cbCentroDistribucion', '');
}

/* 
 * Inc.BELC400000652 "Al recargar las versiones se debe setear por default la activa para facturacion"
 * Este metodo se llama desde la LP.
 */
function recargaCbVersion(oidVersionDefault) {
         if ((get('formulario.cbPeriodo') != '')&&(get('formulario.cbMapaCentroDistribucion') != '')) {
                  recargaCombo('formulario.cbVersionAsignacion', 
                                              'APEObtenerVersionesAsignacion',
                                              'es.indra.sicc.dtos.ape.DTOMantenerAsignacionProductosAnaqueles', 
                                              [['oidPais', get('formulario.hPais')],
                                                ['oidIdioma', get('formulario.hIdioma')],
                                                ['oidMapaCentroDistribucion', get('formulario.cbMapaCentroDistribucion')], 
                                                ['oidPeriodo', get('formulario.cbPeriodo')]],
                                                'setearComboVersionesValorDefault(datos, '+oidVersionDefault+')');
         } else {
         set_combo('formulario.cbVersionAsignacion', arrayVacio());
         accion('formulario.cbVersionAsignacion', '.disabled=true');
         }
}

function setearComboVersionesValorDefault(datos, oidVersionDefault) {

         var arrayNuevo = new Array();
         arrayNuevo[0] = new Array('','');
         arrayNuevo = arrayNuevo.concat(datos);
         set_combo('formulario.cbVersionAsignacion', arrayNuevo);
         
         if (oidVersionDefault != "") {
                  set('formulario.cbVersionAsignacion', [[oidVersionDefault]]);
         }
}
