
function onLoadPag(){  
	
    configurarMenuSecundario('formulario');    
    btnProxy(1,0);   
    
    if(!fMostrarMensajeError()){
 
        accion('formulario.cbMapaCentroDistOrigen', '.disabled=true');
        accion('formulario.cbMapaZonasOrigen', '.disabled=true');        
        accion('formulario.cbMapaCentroDistDestino', '.disabled=true');
        accion('formulario.cbLinea', '.disabled=true');
      
        set('formulario.cbCentroDistribucion', [get('formulario.hCbCentroDistribucion')]);
        
        if (get('formulario.hCbCentroDistribucion')!=''){
            onChangeCentroDistribucion();    
        }        
    }
    
    focaliza("formulario.cbCentroDistribucion");  	
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

function onChangeCentroDistribucion(){

    if(get('formulario.cbCentroDistribucion') != ''){
        accion('formulario.cbMapaCentroDistOrigen', '.disabled=false');
        accion('formulario.cbMapaCentroDistDestino', '.disabled=false');
        
        set_combo('formulario.cbMapaZonasOrigen', arrayVacio());
        accion('formulario.cbMapaZonasOrigen', '.disabled=true');
        
        set_combo('formulario.cbLinea', arrayVacio());
        accion('formulario.cbLinea', '.disabled=true');
        
        // Carga Mapa Centro CD
        recargaCombo('formulario.cbMapaCentroDistOrigen', 'APEObtenerMapasCDPorCD', 
          'es.indra.sicc.util.DTOOID', [['oid', get('formulario.cbCentroDistribucion')], ['oidIdioma', get('formulario.hIdioma')]]
          ,'recargarMapaCD(datos)');
        
    } else {
        set_combo('formulario.cbMapaCentroDistOrigen', arrayVacio());
        accion('formulario.cbMapaCentroDistOrigen', '.disabled=true');        
        set_combo('formulario.cbMapaZonasOrigen', arrayVacio());
        accion('formulario.cbMapaZonasOrigen', '.disabled=true');
        
        set_combo('formulario.cbMapaCentroDistDestino', arrayVacio());
        accion('formulario.cbMapaCentroDistDestino', '.disabled=true');
        
        set_combo('formulario.cbLinea', arrayVacio());
        accion('formulario.cbLinea', '.disabled=true');
        
    } 
}

function recargarMapaCD(datos){
    seteo = cargaArray(datos);
    set_combo('formulario.cbMapaCentroDistOrigen', seteo);
    set_combo('formulario.cbMapaCentroDistDestino', seteo);
}


function onChangeMapaCentroOrigen(){

    if(get('formulario.cbMapaCentroDistOrigen') != ''){
        accion('formulario.cbMapaZonasOrigen', '.disabled=false');
        
        set_combo('formulario.cbLinea', arrayVacio());
        accion('formulario.cbLinea', '.disabled=true');
        
        recargaCombo('formulario.cbMapaZonasOrigen', 'APEObtenerMapaZonaPorMapaCD', 
          'es.indra.sicc.util.DTOOID', [['oid', get('formulario.cbMapaCentroDistOrigen')], ['oidIdioma', get('formulario.hIdioma')]]);
    } else {
        set_combo('formulario.cbMapaZonasOrigen', arrayVacio());
        accion('formulario.cbMapaZonasOrigen', '.disabled=true');
        
        set_combo('formulario.cbLinea', arrayVacio());
        accion('formulario.cbLinea', '.disabled=true');
    } 
}

function onChangeMapaZonasOrigen(){

    if(get('formulario.cbMapaZonasOrigen') != ''){
        accion('formulario.cbLinea', '.disabled=false');
        recargaCombo('formulario.cbLinea', 'APEObtenerLineasMapaZona', 
          'es.indra.sicc.util.DTOOID', [['oid', get('formulario.cbMapaZonasOrigen')], ['oidIdioma', get('formulario.hIdioma')]]);
    } else {
        set_combo('formulario.cbLinea', arrayVacio());
        accion('formulario.cbLinea', '.disabled=true');
    } 
}


function onClickCopiar(){
  if(sicc_validaciones_generales("gMapZonaCopiar")){
        eval('formulario').oculto = 'S';       
        set('formulario.hDescMapaCD', get('formulario.cbMapaCentroDistDestino','T'));  
        set('formulario.conectorAction', 'LPMantenimientoMapaZonasLineasArmado');
        set('formulario.accion', 'copiar');
        enviaSICC('formulario', null, null, 'N');
    }
}


function fLimpiar(){

    onChangeCentroDistribucion();
    
    set_combo('formulario.cbMapaZonasOrigen', arrayVacio());
    accion('formulario.cbMapaZonasOrigen', '.disabled=true');
   
    set('formulario.txtDescripcionMapaDestino', '');        
    
    btnProxy(1,0);
    
    limpiaI18N('formulario', 1);
    
    focaliza("formulario.cbCentroDistribucion");
}

function focalizaCD(){
    focaliza('formulario.cbCentroDistribucion','');
}

function focalizaShTab(){
    focalizaBotonHTML('botonContenido','btnCopiar');
}


function ejecutarOK(){
    GestionarMensaje("264", null, null, null);
    fLimpiar();
}
