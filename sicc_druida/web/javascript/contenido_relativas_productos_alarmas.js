function onLoadPag(){  
	configurarMenuSecundario('formulario');
    if(!fMostrarMensajeError()){ 
        accion('formulario.cbPeriodo', '.disabled=true');
        set('formulario.cbCentroDistribucion', [get('formulario.hCbCentroDistribucion')]);               
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

function onChangeCbCanal(){
    if( get('formulario.cbMarca')!='' && get('formulario.cbCanal')!='' ){
        
        recargaComboPeriodo();
    } else {
        set_combo('formulario.cbPeriodo', arrayVacio());
        accion('formulario.cbPeriodo', '.disabled=true');
    }
}

function onChangeCbMarca(){
    if( get('formulario.cbMarca')!='' && get('formulario.cbCanal')!='' ){
        
        recargaComboPeriodo();
    } else {
        set_combo('formulario.cbPeriodo', arrayVacio());
        accion('formulario.cbPeriodo', '.disabled=true');
    }
}

function recargaComboPeriodo(){
    accion('formulario.cbPeriodo', '.disabled=false');
        
    recargaCombo('formulario.cbPeriodo', 'CRAObtenerPeriodos', 'es.indra.sicc.dtos.cra.DTOPeriodo', 
    armarArrayDTOPeriodo(), 'recargarPeriodos(datos)');
}

function armarArrayDTOPeriodo(){
     var marca = get('formulario.cbMarca');
     var canal = get('formulario.cbCanal');
     var array = new Array();
     var index = 0;
     
     array[index] = new Array('marca', marca[0]);
     index++;
     
     array[index] = new Array('canal', canal[0]);
     index++;    

     var pais = get("formulario.hPais");
     array[index] = ["pais", pais];
     
     return array;
}

function recargarPeriodos(datos){
    seteo = cargaArray(datos);
    set_combo('formulario.cbPeriodo', seteo);
}

function onClickAceptar(){
    if(sicc_validaciones_generales("gAlarmaProd")) {    
        eval('formulario').oculto = 'S';     
        set('formulario.hDescCD', get('formulario.cbCentroDistribucion','T'));  
       
        set('formulario.conectorAction', 'LPAlarmas');
        set('formulario.accion', 'comprobarProductos');
        enviaSICC('formulario', null, null, 'N');         
    }
}

function fLimpiar(){
    set('formulario.cbCentroDistribucion', [get('formulario.hCbCentroDistribucion')]);    
    set('formulario.cbMarca', '');
    set('formulario.cbCanal', '');
    
    set_combo('formulario.cbPeriodo', arrayVacio());
    accion('formulario.cbPeriodo', '.disabled=true');
    
    focaliza('formulario.cbCentroDistribucion','');
}

function focalizaCD(){
    focaliza('formulario.cbCentroDistribucion','');
}

function focalizaShTab(){
    focalizaBotonHTML('botonContenido','btnAceptar');
}


