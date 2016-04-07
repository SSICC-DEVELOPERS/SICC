function onLoadPag(){  
	
    configurarMenuSecundario('formulario');    
    
    if(!fMostrarMensajeError()){
    
        accion('formulario.cbMapaCentroDistOrigen', '.disabled=true');   
        accion('formulario.cbMapaZonasOrigen', '.disabled=true');   
        accion('formulario.cbOrdenAnaquel', '.disabled=true');
        accion('formulario.cbMapaCentroDistDestino', '.disabled=true');
        accion('formulario.cbMapaZonasDestino', '.disabled=true');   
       
        set('formulario.cbCentroDistribucion', [get('formulario.hCbCentroDistribucion')]);
        
        if (get('formulario.hCbCentroDistribucion')!=''){
            onChangeCentroDistribucion();    
        }        
    }
    
    focaliza("formulario.cbCentroDistribucion");  	
}

function arrayVacio(){  
    var array = new Array();             
        array[0] = new Array('','');
  
    return array;
}

function cargaArray(datos){
    var seteo = new Array(datos.length + 1);
    seteo[0] = ['' , '']
    for(i = 0; i < datos.length; i++){
      seteo[i+1] = [ datos[i][0], datos[i][1] ]
    }
    return seteo;
}


function onChangeCentroDistribucion(){

    if(get('formulario.cbCentroDistribucion') != ''){
        accion('formulario.cbMapaCentroDistOrigen', '.disabled=false');
        accion('formulario.cbMapaCentroDistDestino', '.disabled=false');
        
        set_combo('formulario.cbMapaZonasOrigen', arrayVacio());
        accion('formulario.cbMapaZonasOrigen', '.disabled=true');  
        set_combo('formulario.cbMapaZonasDestino', arrayVacio());
        accion('formulario.cbMapaZonasDestino', '.disabled=true');   
        
        set_combo('formulario.cbOrdenAnaquel', arrayVacio());
        accion('formulario.cbOrdenAnaquel', '.disabled=true');
        
        // Carga Mapa Centro CD
        recargaCombo('formulario.cbMapaCentroDistOrigen', 'APEObtenerMapasCDPorCD', 
          'es.indra.sicc.util.DTOOID', [['oid', get('formulario.cbCentroDistribucion')], ['oidIdioma', get('formulario.hIdioma')]]
          ,'recargarMapaCD(datos)');
     
    } else {
        set_combo('formulario.cbMapaCentroDistOrigen', arrayVacio());
        accion('formulario.cbMapaCentroDistOrigen', '.disabled=true');   
        set_combo('formulario.cbMapaZonasOrigen', arrayVacio());
        accion('formulario.cbMapaZonasOrigen', '.disabled=true');   
        
        set_combo('formulario.cbOrdenAnaquel', arrayVacio());
        accion('formulario.cbOrdenAnaquel', '.disabled=true');
        
        set_combo('formulario.cbMapaCentroDistDestino', arrayVacio());
        accion('formulario.cbMapaCentroDistDestino', '.disabled=true');
        set_combo('formulario.cbMapaZonasDestino', arrayVacio());
        accion('formulario.cbMapaZonasDestino', '.disabled=true');   
              
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
        set_combo('formulario.cbOrdenAnaquel', arrayVacio());
        accion('formulario.cbOrdenAnaquel', '.disabled=true');
        
        recargaCombo('formulario.cbMapaZonasOrigen', 'APEObtenerMapaZonaPorMapaCD', 
          'es.indra.sicc.util.DTOOID', [['oid', get('formulario.cbMapaCentroDistOrigen')], ['oidIdioma', get('formulario.hIdioma')]]
          ,'recargaMapaZonaOrig(datos)');
    } else {
        set_combo('formulario.cbMapaZonasOrigen', arrayVacio());
        accion('formulario.cbMapaZonasOrigen', '.disabled=true');
        
        set_combo('formulario.cbOrdenAnaquel', arrayVacio());
        accion('formulario.cbOrdenAnaquel', '.disabled=true');
    } 
}

function recargaMapaZonaOrig(datos){
    mapaZonaDef = obtenerMapaZonaDef(datos);
    
    seteo = cargaArray(datos);
    set_combo('formulario.cbMapaZonasOrigen', seteo);
    set('formulario.cbMapaZonasOrigen', [mapaZonaDef]);
    
    onChangeMapaZonasOrigen();
}

function obtenerMapaZonaDef(datos){
    valoresDef = get('formulario.hCbMapaZonaDef').split(",");
    //alert("valoresLineasDef: " + valoresLineasDef);
    if(datos != "" && valoresDef != ""){
    
        for(i = 0; i < datos.length; i++){
          oid = datos[i][0];
          for(j = 0; j < valoresDef.length; j++){  
            if(valoresDef[j]==oid){
                return oid;
            }
          }
        } 
        return "";
        
    } else {
        return "";
    }
}

function onChangeMapaCDDestino(){

    if(get('formulario.cbMapaCentroDistDestino') != ''){
        accion('formulario.cbMapaZonasDestino', '.disabled=false');        
        
        recargaCombo('formulario.cbMapaZonasDestino', 'APEObtenerMapaZonaPorMapaCD', 
          'es.indra.sicc.util.DTOOID', [['oid', get('formulario.cbMapaCentroDistDestino')], ['oidIdioma', get('formulario.hIdioma')]]);
                
    } else {
        set_combo('formulario.cbMapaZonasDestino', arrayVacio());
        accion('formulario.cbMapaZonasDestino', '.disabled=true');
    } 
}


function onChangeMapaZonasOrigen(){
    if(get('formulario.cbMapaZonasOrigen') != ''){
      accion('formulario.cbOrdenAnaquel', '.disabled=false');
      recargaCombo('formulario.cbOrdenAnaquel', 'APEObtenerMapasOrdenPorMapaZonas', 
        'es.indra.sicc.dtos.ape.DTOOrdenAnaquel', [['oid', get('formulario.cbMapaZonasOrigen')], ['oidIdioma', get('formulario.hIdioma')]]);
    } else {              
       set_combo('formulario.cbOrdenAnaquel', arrayVacio());
       accion('formulario.cbOrdenAnaquel', '.disabled=true');
   }
}

function onCopiar(){
  if(sicc_validaciones_generales("gCopiarOrAnaq")){
        eval('formulario').oculto = 'S';   
        set('formulario.hDescOrdenAnaquel', get('formulario.cbOrdenAnaquel','T'));
        set('formulario.conectorAction', 'LPCopiarOrdenAnaqueles');
        set('formulario.accion', 'copiar');
        enviaSICC('formulario', null, null, 'N');
    }
}

function fLimpiar(){

    onChangeCentroDistribucion();
            
    set('formulario.txtOrdenAnaquelDestino', '');        
    limpiaI18N('formulario', 1);
    
    focaliza("formulario.cbCentroDistribucion")
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
