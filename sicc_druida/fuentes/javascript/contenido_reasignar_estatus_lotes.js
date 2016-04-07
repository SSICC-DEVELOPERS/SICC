function onLoadPag() {
    configurarMenuSecundario('formulario');
   
    fMostrarMensajeError();
    
    // vbongiov - Cambio 20070458 - 30/01/2008
    set('formulario.cbMarca', [get('formulario.oidMarcaDef')]);
    set('formulario.cbCanal', [get('formulario.oidCanalDef')]);
    
    var pais  = get('formulario.oidPais');
    var marca = get('formulario.oidMarcaDef');
    var canal = get('formulario.oidCanalDef');
         
    recargaPeriodoAct(pais, marca, canal);
}

function cargaArray(datos){
    var seteo = new Array(datos.length + 1);
    seteo[0] = ['' , '']
    for(i = 0; i < datos.length; i++){
      seteo[i+1] = [ datos[i][0], datos[i][1] ]
    }
    return seteo;
}

function onChangeMarca() {
    var pais  = get('formulario.oidPais');
    var marca = get('formulario.cbMarca');
    var canal = get('formulario.cbCanal');
    recargaPeriodoAct(pais, marca, canal);
}

function onChangeCanal() {
    var pais  = get('formulario.oidPais');
    var marca = get('formulario.cbMarca');
    var canal = get('formulario.cbCanal');
    recargaPeriodoAct(pais, marca, canal);
}

function recargaPeriodoAct(pais, marca, canal) {

    if (pais != '' && marca != '' && canal != '') {    
      accion('formulario.cbPeriodoActual', '.disabled=false');      
      
      recargaCombo('formulario.cbPeriodoActual', 'MAEObtienePeriodoActReasigEstatus', 
           'es.indra.sicc.dtos.cra.DTOPeriodo', [['oidPais', pais], ['marca', marca], ['canal', canal]], 
           'recargaPeriodos(datos ' + ','+ pais +','+ marca + ','+ canal + ')');
           
    } else { // Vacio el combo Periodo
         set_combo('formulario.cbPeriodoActual', [['','']], [null]);
         accion('formulario.cbPeriodoActual', '.disabled=true');
    }
}

function recargaPeriodos(datos,pais, marca, canal) {
    
    if (datos.length !=1 && datos.length!=0){
         set('formulario.periodosSolapados', 'S');
    }
    
    var reg = datos[0];
    set('formulario.oidPeriodo', reg[0]);
    
    recargaCombo('formulario.cbPeriodoActual', 'CRAObtienePeriodos', 
           'es.indra.sicc.dtos.cra.DTOPeriodo', [['oidPais', pais], ['marca', marca], ['canal', canal]], 
           'recargaCbPeriodos(datos)');
}

function recargaCbPeriodos(datos){
    
    seteo = cargaArray(datos);
    set_combo('formulario.cbPeriodoActual', seteo);
    set('formulario.cbPeriodoActual', [get('formulario.oidPeriodo')]);
    
    if(get('formulario.periodosSolapados')=="S"){
         GestionarMensaje("2617");
    }
    
    foco('formulario.cbMarca'); 
}

function accionReasignar() {
    if (!sicc_validaciones_generales()) {
         return false;
    }
   
    eval('formulario').oculto = 'S';
    set('formulario.accion', 'reasignar');
    set('formulario.conectorAction', 'LPReasignarEstatusEnLotes');
    enviaSICC('formulario');
}


function fLimpiar() {
   
   set('formulario.cbMarca', [get('formulario.oidMarcaDef')]);
   set('formulario.cbCanal', [get('formulario.oidCanalDef')]);
 
   var pais  = get('formulario.oidPais');
   var marca = get('formulario.oidMarcaDef');
   var canal = get('formulario.oidCanalDef');
         
   recargaPeriodoAct(pais, marca, canal);
}


function focalizaCbMarca() {
    foco('formulario.cbMarca'); 
}





function seleccionaCombo(combo, oidSelecc) {
    var iSeleccionado = new Array(); 
    iSeleccionado[0] = oidSelecc; 
    set(combo, iSeleccionado);
}

function seleccionaComboMultiple(combo, arrayOidsSelecc) {
    var iSeleccionado = new Array();
    var cantSeleccionados = arrayOidsSelecc.length;

    for (var i = 0; i < cantSeleccionados; i++) {
         iSeleccionado[i] = arrayOidsSelecc[i];
    }
    set(combo, iSeleccionado);
}

function chequeaError() {
    var errCod = get('formulario.errCodigo');
    var errDesc = get('formulario.errDescripcion');
    
    // Tomado de sicc_util.js fMostrarMensajeError
    if ( (errDesc != null && errDesc.split(" ").join("") != "")  
                   || (errCod != null && errCod.split(" ").join("") != "") ) {
         return true;
    }
         return false;
}

function muestraSeleccionAnterior() {
         // Valores a recargar si hay error en parte servidora
    var pais  = get('formulario.oidPais');
    var oidMarcaAntesError = get('formulario.oidMarca');
    var oidCanalAntesError = get('formulario.oidCanal');
    var oidPeriodoAntesError = get('formulario.oidPeriodo');
    var arrayRegiones = new Array();
    
    arrayRegiones = strRegionesAntesError.split(",");
    
    seleccionaCombo('formulario.cbMarca', oidMarcaAntesError);
    seleccionaCombo('formulario.cbCanal', oidCanalAntesError);
    seleccionaCombo('formulario.cbPeriodoActual', oidPeriodoAntesError);
    seleccionaComboMultiple('formulario.cbRegion', arrayRegiones);
}

