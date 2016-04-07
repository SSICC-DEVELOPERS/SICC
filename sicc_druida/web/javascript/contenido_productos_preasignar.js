function onLoadPag(){  
	
    configurarMenuSecundario('formulario');
   
    if(!fMostrarMensajeError()){
        
        accion('formulario.cbMapaCentroDistribucion', '.disabled=true');
        accion('formulario.cbLinea', '.disabled=true');
        
        accion('formulario.cbPeriodo', '.disabled=true');
        accion('formulario.cbPeriodoDestino', '.disabled=true');
        
        accion('formulario.cbVersion', '.disabled=true');
        accion('formulario.cbVersionDestino', '.disabled=true');
       
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
        accion('formulario.cbMapaCentroDistribucion', '.disabled=false');
              
        set_combo('formulario.cbVersion', arrayVacio());
        accion('formulario.cbVersion', '.disabled=true');
        
        set_combo('formulario.cbVersionDestino', arrayVacio());
        accion('formulario.cbVersionDestino', '.disabled=true');
        
        // Carga Mapa Centro CD
        recargaCombo('formulario.cbMapaCentroDistribucion', 'APEObtenerMapasCDPorCD', 
          'es.indra.sicc.util.DTOOID', [['oid', get('formulario.cbCentroDistribucion')], ['oidIdioma', get('formulario.hIdioma')]]);
          
        // Carga Lineas  
        accion('formulario.cbLinea', '.disabled=false');
        recargaCombo('formulario.cbLinea', 'APEObtenerLineasArmadoCD', 
          'es.indra.sicc.util.DTOOID', [['oid', get('formulario.cbCentroDistribucion')], ['oidIdioma', get('formulario.hIdioma')]]
           ,'recargaLineas(datos)');
        
    } else {
        set_combo('formulario.cbMapaCentroDistribucion', arrayVacio());
        accion('formulario.cbMapaCentroDistribucion', '.disabled=true');      
       
        set_combo('formulario.cbLinea', arrayVacio());
        accion('formulario.cbLinea', '.disabled=true');
        
        set_combo('formulario.cbVersion', arrayVacio());
        accion('formulario.cbVersion', '.disabled=true');
        
        set_combo('formulario.cbVersionDestino', arrayVacio());
        accion('formulario.cbVersionDestino', '.disabled=true');
    } 
}
    
function recargaLineas(datos){
    lineaDef = obtenerLineaDef(datos);
    
    seteo = cargaArray(datos);
    set_combo('formulario.cbLinea', seteo);
    set('formulario.cbLinea', [lineaDef]);
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

function onChangeMapaCentro(){

    rellenaCbVersion();
    recargarVersionDest();
}

function onChangeCbCanal(){
    if( get('formulario.cbMarca')!='' && get('formulario.cbCanal')!='' ){
        set_combo('formulario.cbVersion', arrayVacio());
        accion('formulario.cbVersion', '.disabled=true');
        
        set_combo('formulario.cbVersionDestino', arrayVacio());
        accion('formulario.cbVersionDestino', '.disabled=true');
        
        recargaComboPeriodo();
    } else {
        set_combo('formulario.cbPeriodo', arrayVacio());
        accion('formulario.cbPeriodo', '.disabled=true');
        set_combo('formulario.cbPeriodoDestino', arrayVacio());
        accion('formulario.cbPeriodoDestino', '.disabled=true');
        
        set_combo('formulario.cbVersion', arrayVacio());
        accion('formulario.cbVersion', '.disabled=true');
        
        set_combo('formulario.cbVersionDestino', arrayVacio());
        accion('formulario.cbVersionDestino', '.disabled=true');
    }
}

function onChangeCbMarca(){
    if( get('formulario.cbMarca')!='' && get('formulario.cbCanal')!='' ){
        set_combo('formulario.cbVersion', arrayVacio());
        accion('formulario.cbVersion', '.disabled=true');
        
        set_combo('formulario.cbVersionDestino', arrayVacio());
        accion('formulario.cbVersionDestino', '.disabled=true');
        
        recargaComboPeriodo();
    } else {
        set_combo('formulario.cbPeriodo', arrayVacio());
        accion('formulario.cbPeriodo', '.disabled=true');
        set_combo('formulario.cbPeriodoDestino', arrayVacio());
        accion('formulario.cbPeriodoDestino', '.disabled=true');
        
        set_combo('formulario.cbVersion', arrayVacio());
        accion('formulario.cbVersion', '.disabled=true');
        
        set_combo('formulario.cbVersionDestino', arrayVacio());
        accion('formulario.cbVersionDestino', '.disabled=true');
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


function onChangeCbPeriodo(){
    rellenaCbVersion();
    rellenaCbPeriodoDest();
}

function rellenaCbVersion(){
    if(get('formulario.cbCentroDistribucion')!='' &&
       get('formulario.cbMapaCentroDistribucion') != '' &&
       get('formulario.cbPeriodo')!=''){
        accion('formulario.cbVersion', '.disabled=false');        
        accion('formulario.cbVersionDestino', '.disabled=false');
        
        recargaCombo('formulario.cbVersion', 'APEObtenerVersionesAsignacion', 
          'es.indra.sicc.dtos.ape.DTOMantenerAsignacionProductosAnaqueles', armarArrayDTOVersion(),
          'recargarVersion(datos)');
    } else {
        set_combo('formulario.cbVersion', arrayVacio());
        accion('formulario.cbVersion', '.disabled=true');
        
        set_combo('formulario.cbVersionDestino', arrayVacio());
        accion('formulario.cbVersionDestino', '.disabled=true');
    } 
}

function recargarVersion(datos){
    seteo = cargaArray(datos);
    set_combo('formulario.cbVersion', seteo);    
}

function armarArrayDTOVersion(){
     var oidCentroDistribucion = get('formulario.cbCentroDistribucion');
     var oidMapaCentroDistribucion = get('formulario.cbMapaCentroDistribucion');
     var oidPeriodo = get('formulario.cbPeriodo');
     
     var array = new Array();
     var index = 0;
     
     array[index] = new Array('oidCentroDistribucion', oidCentroDistribucion[0]);
     index++;
     
     array[index] = new Array('oidMapaCentroDistribucion', oidMapaCentroDistribucion[0]);
     index++;
     
     array[index] = new Array('oidPeriodo', oidPeriodo[0]);
     index++;    
     
     /* BELC400000692 - dmorello, 30/08/2007 */
     var oidLineaArmado = get('formulario.cbLinea');
	 array[index++] = new Array('oidLineaArmado', oidLineaArmado);
     /* Fin BELC400000692 - dmorello, 30/08/2007 */

     return array;
}

function rellenaCbPeriodoDest(){
    if(get('formulario.cbPeriodo')!=''){    
        recargaCombo('formulario.cbPeriodoDestino', 'CRAObtienePeriodoSiguiente', 
          'es.indra.sicc.util.DTOOID', [['oid', get('formulario.cbPeriodo')]] ,
          'recargarPeriodoDest(datos)');
          
    } else {
        set_combo('formulario.cbPeriodoDestino', arrayVacio());
        
        set_combo('formulario.cbVersionDestino', arrayVacio());
        accion('formulario.cbVersionDestino', '.disabled=true');
    } 
}

function recargarPeriodoDest(datos){
    // Carga el periodo destino
    set_combo('formulario.cbPeriodoDestino', datos);
    
    recargarVersionDest();
}

function recargarVersionDest(){
    
    if(get('formulario.cbCentroDistribucion')!='' &&
       get('formulario.cbMapaCentroDistribucion') != '' &&
       get('formulario.cbPeriodoDestino')!=''){
       
        accion('formulario.cbVersionDestino', '.disabled=false');
    
        // Va a cargar la version destino
        recargaCombo('formulario.cbVersionDestino', 'APEObtenerVersionesAsignacion', 
              'es.indra.sicc.dtos.ape.DTOMantenerAsignacionProductosAnaqueles', armarArrayDTOVersionDest(),
              'recargarVersionDestino(datos)');
    } else {
        set_combo('formulario.cbVersionDestino', arrayVacio());
        accion('formulario.cbVersionDestino', '.disabled=true');
    } 
}

function recargarVersionDestino(datos){
    seteo = cargaArray(datos);
    set_combo('formulario.cbVersionDestino', seteo);    
    set('formulario.cbVersionDestino', [get('formulario.hNuevaVersion')]);    
}

function armarArrayDTOVersionDest(){
     var oidCentroDistribucion = get('formulario.cbCentroDistribucion');
     var oidMapaCentroDistribucion = get('formulario.cbMapaCentroDistribucion');
     var oidPeriodo = get('formulario.cbPeriodoDestino');
     
     var array = new Array();
     var index = 0;
     
     array[index] = new Array('oidCentroDistribucion', oidCentroDistribucion[0]);
     index++;
     
     array[index] = new Array('oidMapaCentroDistribucion', oidMapaCentroDistribucion[0]);
     index++;
     
     array[index] = new Array('oidPeriodo', oidPeriodo[0]);
     index++;    

     /* BELC400000692 - dmorello, 30/08/2007 */
     var oidLineaArmado = get('formulario.cbLinea');
	 array[index++] = new Array('oidLineaArmado', oidLineaArmado);
     /* Fin BELC400000692 - dmorello, 30/08/2007 */
     
     return array;
}

function onClickNuevaVersion(){
    if(sicc_validaciones_generales("gNuevaVersion")){
         var obj = new Object();
         obj.casoDeUso = 'PreasignarProductos'
         obj.accion = 'nuevaVersion';
         obj.oidMapaCentroDistribucion= get('formulario.cbMapaCentroDistribucion');
         obj.oidPeriodo= get('formulario.cbPeriodoDestino');
     
         var retorno = mostrarModalSICC('LPPreasignarProductos', 'nuevaVersion', obj, '795', '200');
         
         if(retorno!=null){
            oidNuevaVersion = retorno[0];
            set('formulario.hNuevaVersion', oidNuevaVersion);    
            
            rellenaCbPeriodoDest();            
         }
    }
}

function fGuardar(){
    if(sicc_validaciones_generales("gPreasigProd")) {
    
        set('formulario.hVersionDestino', get('formulario.cbVersionDestino','T'));
        
        eval('formulario').oculto = 'S';       
        set('formulario.conectorAction', 'LPPreasignarProductos');
        set('formulario.accion', 'guardar');
        enviaSICC('formulario', null, null, 'N');
    }
}

function ejecutarConfirmacion(){
    // ¿Desea realizar de nuevo la operación eliminando los datos existentes?
    if(GestionarMensaje("2584", null, null, null)){
        // ¿Desea mantener los datos ingresados manualmente?
        if(GestionarMensaje("2585", null, null, null)){
            set('formulario.codProcedenciaNoElimina', get('formulario.COD_PROCEDENCIA_MANUAL'));    
        } 
        
        eval('formulario').oculto = 'S';       
        
        set('formulario.hVersionDestino', get('formulario.cbVersionDestino','T'));
        
        set('formulario.conectorAction', 'LPPreasignarProductos');
        set('formulario.accion', 'guardarConfirmacion');
        enviaSICC('formulario', null, null, 'N');
        
    } else {
        fLimpiar();
    }   
}


function fLimpiar(){

    set('formulario.cbCentroDistribucion', [get('formulario.hCbCentroDistribucion')]);
    onChangeCentroDistribucion();
    
    set('formulario.cbMarca', '');
    set('formulario.cbCanal', '');
    set('formulario.cbFuentePeriodoOrigen', '');
    
    set_combo('formulario.cbPeriodo', arrayVacio());
    accion('formulario.cbPeriodo', '.disabled=true');
    set_combo('formulario.cbPeriodoDestino', arrayVacio());
    accion('formulario.cbPeriodoDestino', '.disabled=true');
    
    set_combo('formulario.cbVersion', arrayVacio());
    accion('formulario.cbVersion', '.disabled=true');
    
    set_combo('formulario.cbVersionDestino', arrayVacio());
    accion('formulario.cbVersionDestino', '.disabled=true');
    
    focaliza("formulario.cbCentroDistribucion");
}

function focalizaCD(){
    focaliza('formulario.cbCentroDistribucion','');
}


function focalizaTab(){
   focaliza('formulario.cbCentroDistribucion','');
}

function focalizaShTab(){
   focaliza('formulario.cbFuentePeriodoOrigen','');      
}
