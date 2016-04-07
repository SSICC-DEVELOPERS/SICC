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
    if (get('formulario.hCbCentroDistribucion')!=''){
        onChangeCentroDistribucion();    
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
		set("formulario.conectorAction", "LPEnviarMapaAnaquelesProducto");
		set("formulario.accion", "cargarVersiones");
		enviaSICC("formulario");
	}
}

function onChangeCbMarca(){
    recargaCbPeriodo();
}

function onChangeCbCanal(){
	recargaCbPeriodo();
}

function onChangeCbPeriodo(){
	onChangeCbMapaCentroDistribucion();
}

function onClickEnviar(){
	if(sicc_validaciones_generales()) {
	    set("formulario.hCbMarca", get('formulario.cbMarca'));
		set("formulario.hCbCanal", get('formulario.cbCanal'));
		set("formulario.hCbPeriodo", get('formulario.cbPeriodo'));
		set('formulario.hCbCentroDistribucion', get('formulario.cbCentroDistribucion'));
		set('formulario.hCbMapaCentroDistribucion', get('formulario.cbMapaCentroDistribucion'));
		set('formulario.hCbVersionAsignacion', get('formulario.cbVersionAsignacion'));
        eval("formulario").oculto= "S";
        set("formulario.conectorAction", "LPEnviarMapaAnaquelesProducto");
        set("formulario.accion", "enviar");
        enviaSICC("formulario"); 
	}
}

function enviarOk(){
	eval("formulario").oculto= "N";
	set("formulario.accion", "");
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
	focoMapaCentrDist();
}
function onTABMapaCentrDistr() {
	focoVersion();
}
function onTABVersion() {
	focoBtnEnviar();
}
function onTABBtnEnviar() {
	focoMarca();
}
function onShTABBtnEnviar() {
	focoVersion();
}
function onShTABVersion() {
	focoMapaCentrDistr();
}
function onShTABMapaCentrDistr() {
	focoCentrDistr();
}
function onShTABCentrDistr() {
	focoPeriodo();
}
function onShTABPeriodo() {
	focoCanal();
}
function onShTABCanal() {
	focoMarca();
}
function onShTABMarca() {
	focoBtnEnviar();
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
function focoMapaCentrDist() {
	focaliza("formulario.cbMapaCentroDistribucion");
}
function focoVersion() {
	focaliza("formulario.cbVersionAsignacion");
}
function focoBtnEnviar() {
	focalizaBotonHTML('botonContenido','btnEnviar');	
}
function focoMarca() {
	focaliza("formulario.cbMarca");
}

function fLimpiar(){
	limpieza();
}

function limpieza(){
    focoMarca();
	set('formulario.cbMarca', '');
	set('formulario.cbCanal', '');
	set_combo('formulario.cbPeriodo', arrayVacio());
	set('formulario.cbCentroDistribucion', '');
	set('formulario.cbMapaCentroDistribucion', arrayVacio());
	set_combo('formulario.cbVersionAsignacion', arrayVacio());
    if (get('formulario.hCbCentroDistribucion')!=''){
		set('formulario.cbCentroDistribucion', [get('formulario.hCbCentroDistribucion')]);
        onChangeCentroDistribucion();    
    }
}

/* 
 * Inc.BELC400000652 "Recarga de combo Periodo con seteo por default del periodo actual"
 * En la carga inicial desde la LP se setea el VAR hPeriodosActualesDefault que contiene el oid de 
 * periodo actual para cada combinacion existente en Sicc de Marca y Canal, con un contenido 
 * del tipo: oidMarca01,oidCanal01,oidPeriodo01|oidMarca02,oidCanal02,oidPeriodo02
 */
function recargaCbPeriodo() {
	set_combo('formulario.cbVersionAsignacion', arrayVacio());
	
	if ((get('formulario.cbMarca') != '')&&(get('formulario.cbCanal') != '')) {
		accion('formulario.cbPeriodo', '.disabled=false');
		recargaCombo('formulario.cbPeriodo', 'CRAObtienePeriodos',
			'es.indra.sicc.dtos.cra.DTOPeriodo', 
			[['pais',  get('formulario.pais')],
			 ['marca', get('formulario.cbMarca')], 
			 ['canal', get('formulario.cbCanal')],
			 ['oidIdioma', get('formulario.hIdioma')]], 'setearComboPeriodoValorActual(datos)');
	}else{
        set_combo('formulario.cbPeriodo', arrayVacio());
        accion('formulario.cbPeriodo', '.disabled=true');
	}
}

function setearComboPeriodoValorActual(datos) {
	var arrayNuevo = new Array();
	arrayNuevo[0] = new Array('','');
	arrayNuevo = arrayNuevo.concat(datos);
	set_combo('formulario.cbPeriodo', arrayNuevo);
	
	if(get('formulario.hPeriodosActualesDefault')!="") {
        var oidPeriodoActualDefault = getPeriodoActualDefault(get('formulario.cbMarca'), get('formulario.cbCanal'));
		
        if (oidPeriodoActualDefault == null) {
			return;
        }

		set('formulario.cbPeriodo', [[oidPeriodoActualDefault]]);
        
		onChangeCbPeriodo(); // Para que recargue el combo de Versiones (si estan seleccionados el resto de los datos necesarios para hecerlo)
	}
}

function getPeriodoActualDefault(marca, canal) {
	var arrPeriodosActuales = periodosActualesToArray(get('formulario.hPeriodosActualesDefault'));
	var cantPeriodos = arrPeriodosActuales.length;
	
	for (var i = 0; i < cantPeriodos; i++) {
		if (arrPeriodosActuales[i][0] == marca && arrPeriodosActuales[i][1] == canal) {
			return arrPeriodosActuales[i][2]; // el oidPeriodo
		}
	}
    return null;
}

function periodosActualesToArray(strMarcaCanalPeriodo) {
    var arrPeriodos = new Array();
	
	var arrayPeriodosAux = new Array();
    
    arrayPeriodosAux = strMarcaCanalPeriodo.split("|");
	var cantPeriodos = arrayPeriodosAux.length;
	
	for (var i = 0; i < cantPeriodos; i++) {
		arrPeriodos[i] = arrayPeriodosAux[i].split(",");
	}
	return arrPeriodos;
}

/* 
 * Inc.BELC400000652 "Al recargar las versiones se debe setear por default la activa para facturacion"
 * Este metodo se llama desde la LP.
 */
function recargaCbVersion(oidVersionDefault) {
	if ((get('formulario.cbPeriodo') != '')&&(get('formulario.cbMapaCentroDistribucion') != '')) {
		accion('formulario.cbVersionAsignacion', '.disabled=false');
		recargaCombo('formulario.cbVersionAsignacion', 
					 'APEObtenerVersionesAsignacion',
					 'es.indra.sicc.dtos.ape.DTOMantenerAsignacionProductosAnaqueles', 
					 [['oidPais', get('formulario.pais')],
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