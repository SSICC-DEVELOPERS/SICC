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

function onLoad() {
    configurarMenuSecundario("formulario");
    
     if(!fMostrarMensajeError()){
     
        accion('formulario.cbPeriodo', '.disabled=true');
        
        set('formulario.cbCentroDistribucion', [[get('formulario.hCbCentroDistribucion')]]);
        
         if (get('formulario.hCbCentroDistribucion')!=''){
            onChangeCbCentroDistribucion();    
        }    
     }
}

function cargaArray(datos){
    var seteo = new Array(datos.length + 1);
    seteo[0] = ['' , '']
    for(i = 0; i < datos.length; i++){
      seteo[i+1] = [ datos[i][0], datos[i][1] ]
    }
    return seteo;
}
    
function arrayVacio(){  
    var array = new Array();             
        array[0] = new Array('','');
  
    return array;
}


function onChangeCbCentroDistribucion() {
    if(get('formulario.cbCentroDistribucion') != ''){
        accion('formulario.cbMapaCentroDistribucion', '.disabled=false');
        accion('formulario.cbLineaArmado', '.disabled=false');
        
        // Carga Mapa Centro CD
        recargaCombo('formulario.cbMapaCentroDistribucion', 'APEObtenerMapasCDPorCD', 
          'es.indra.sicc.util.DTOOID', [['oid', get('formulario.cbCentroDistribucion')], ['oidIdioma', get('formulario.oidIdioma')]]);
          
        // Carga Lineas  
        accion('formulario.cbLineaArmado', '.disabled=false');
        recargaCombo('formulario.cbLineaArmado', 'APEObtenerLineasArmadoCD', 
          'es.indra.sicc.util.DTOOID', [['oid', get('formulario.cbCentroDistribucion')], ['oidIdioma', get('formulario.oidIdioma')]]
           ,'recargaLineas(datos)');
        
    } else {
        set_combo('formulario.cbMapaCentroDistribucion', arrayVacio());
        accion('formulario.cbMapaCentroDistribucion', '.disabled=true');      
        
        set_combo('formulario.cbLineaArmado', arrayVacio());
        accion('formulario.cbLineaArmado', '.disabled=true');
    } 
}

function recargaLineas(datos){
    lineaDef = obtenerLineaDef(datos);
    
    seteo = cargaArray(datos);
    set_combo('formulario.cbLineaArmado', seteo);
    set('formulario.cbLineaArmado', [lineaDef]);
}

function obtenerLineaDef(datos){
    valoresLineasDef = get('formulario.hCbLineasCDDef').split(",");
    //alert("valoresLineasDef: " + valoresLineasDef);
    if(datos != "" && valoresLineasDef != ""){
    
        for(i = 0; i < datos.length; i++){
          oidLinea = datos[i][0];
          for(j = 0; j < valoresLineasDef.length; j++){  
            if(valoresLineasDef[j]==oidLinea){
                return oidLinea;
            }
          }
        } 
        return "";
        
    } else {
        return "";
    }
}

function onChangeCbCanal() {
    if( get('formulario.cbMarca')!='' && get('formulario.cbCanal')!='' ){
        cargarPeriodos();
    } else {
        set_combo('formulario.cbPeriodo', arrayVacio());
        accion('formulario.cbPeriodo', '.disabled=true');
    }
    
}

function onChangeCbMarca() {
    if( get('formulario.cbMarca')!='' && get('formulario.cbCanal')!='' ){
        cargarPeriodos();
    } else {
        set_combo('formulario.cbPeriodo', arrayVacio());
        accion('formulario.cbPeriodo', '.disabled=true');
    }
}

function onClickEjecutar() {
    if ( !sicc_validaciones_generales() ) {
        return false;
    }
    set('formulario.descCD', get('formulario.cbCentroDistribucion', 'T'));
    set('formulario.descMapaCD', get('formulario.cbMapaCentroDistribucion', 'T'));
    set('formulario.descLinea', get('formulario.cbLineaArmado', 'T'));
    set('formulario.descMarca', get('formulario.cbMarca', 'T'));
    set('formulario.descCanal', get('formulario.cbCanal', 'T'));
    set('formulario.descPeriodo', get('formulario.cbPeriodo', 'T'));
    
    set('formulario.conectorAction', 'LPMantenerAlarmas');
    set('formulario.accion', 'emitir');
    eval('formulario').oculto = 'S';
    enviaSICC('formulario');
}

function fLimpiar() {
    set('formulario.cbCentroDistribucion', [get('formulario.hCbCentroDistribucion')]);
    onChangeCbCentroDistribucion();    
    
    set('formulario.cbMarca', '');
    set('formulario.cbCanal', '');
    
    set_combo('formulario.cbPeriodo', arrayVacio());
    accion('formulario.cbPeriodo', '.disabled=true');
    
    focaliza("formulario.cbCentroDistribucion");
}

function cargarPeriodos() {
    accion('formulario.cbPeriodo', '.disabled=false');
    
    var pais  = get('formulario.oidPais');
    var marca = get('formulario.cbMarca');
    var canal = get('formulario.cbCanal');
    
    var arrayDtoPeriodo = new Array();
    arrayDtoPeriodo[0] = ["pais",  pais];
    arrayDtoPeriodo[1] = ["marca", marca];
    arrayDtoPeriodo[2] = ["canal", canal];
    arrayDtoPeriodo[3] = ["oidIdioma", get('formulario.oidIdioma')];
    
    recargaCombo("formulario.cbPeriodo", "CRAObtienePeriodos", "es.indra.sicc.dtos.cra.DTOPeriodo", arrayDtoPeriodo);   
}


function emisionAlarmasExitosa() {
    fLimpiar();
}

function focalizaCD(){
    focaliza('formulario.cbCentroDistribucion','');
}
