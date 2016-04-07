function onLoadPag(){  
         
    configurarMenuSecundario('formulario');                           
    fMostrarMensajeError();
    
    set('formulario.cbCentroDistribucion', [get('formulario.hCbCentroDistribucion')]);
         
    if (get('formulario.hCbCentroDistribucion')!=''){
         onChangeCentroDistribucion();    
    }
    
    if (get('formulario.opcionMenu')== 'eliminar'){
         btnProxy(4, '1');
    }
    
    focaliza("formulario.cbCentroDistribucion");
}

function onChangeCentroDistribucion(){
    if(get('formulario.cbCentroDistribucion') != ''){
         //accion('formulario.cbMapaCentroDistribucion', '.disabled=false');
         recargaCombo('formulario.cbMapaCentroDistribucion', 'APEObtenerMapasCDPorCD', 
           'es.indra.sicc.util.DTOOID', [['oid', get('formulario.cbCentroDistribucion')], ['oidIdioma', get('formulario.hIdioma')]]);
    } else {
         set_combo('formulario.cbMapaCentroDistribucion', arrayVacio());
         accion('formulario.cbMapaCentroDistribucion', '.disabled=true');
    }
      
}

function onChangeMapaCentroDistribucion(){
    if(get('formulario.cbMapaCentroDistribucion') != ''){
                  //el cb mapa zonas
         //accion('formulario.cbMapaZonas', '.disabled=false');  
         recargaCombo('formulario.cbMapaZonas', 'APEObtenerMapaZonaPorMapaCD',
                  'es.indra.sicc.util.DTOOID', [['oid', get('formulario.cbMapaCentroDistribucion')], ['oidIdioma', get('formulario.hIdioma')]]
           ,'recargaMapaZonas(datos)');
    } else {         
         set_combo('formulario.cbMapaZonas', arrayVacio());
         accion('formulario.cbMapaZonas', '.disabled=true');
    }
}

function onChangeMapaZonas(){
    if(get('formulario.cbMapaZonas') != ''){
         //accion('formulario.cbOrdenAnaquel', '.disabled=false');
         recargaCombo('formulario.cbOrdenAnaquel', 'APEObtenerMapasOrdenPorMapaZonas', 
           'es.indra.sicc.dtos.ape.DTOOrdenAnaquel', [['oid', get('formulario.cbMapaZonas')], ['oidIdioma', get('formulario.hIdioma')]]
           ,'recargaOrdenAnaquel(datos)');
    } else {         
         set_combo('formulario.cbOrdenAnaquel', arrayVacio());
         accion('formulario.cbOrdenAnaquel', '.disabled=true');
    }
}

function recargaMapaZonas(datos){
         mapaZonasDef = obtenerMapaZonasDef(datos); 
         seteo = cargaArray(datos);
    set_combo('formulario.cbMapaZonas', seteo);
    set('formulario.cbMapaZonas', [mapaZonasDef]);

}

function recargaOrdenAnaquel(datos){
         seteo = cargaArray(datos);     
         set_combo('formulario.cbOrdenAnaquel', seteo);
}

function obtenerMapaZonasDef(datos){
         valoresMapaZonasDef = get('formulario.hCbMapaZonasDef').split(",");
         if(datos != "" && valoresMapaZonasDef != ""){
         for(i = 0; i < datos.length; i++){
           oidLinea = datos[i][0];
           //alert("oidLinea: " + oidLinea);
           for(j = 0; j < valoresMapaZonasDef.length; j++){  
             //alert("valoresLineasDef[j]: " + valoresLineasDef[j]);
             if(valoresMapaZonasDef[j]==oidLinea){
                  return oidLinea;
             }
           }
         } 
         return "";
         
    } else {
         return "";
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

function onClickAceptar(){
         if(sicc_validaciones_generales()) {  

                  var obj = new Object();
                  if (get('formulario.opcionMenu')=='modificar'){
           opcionMenu = "modificar"
                  accion = 'modificar';
                  }
                  if (get('formulario.opcionMenu')=='consultar'){
           opcionMenu = "consultar"
                  accion = 'consultar';
                  }
                  if (get('formulario.opcionMenu')=='eliminar'){
           opcionMenu = "eliminar"
                  accion = 'eliminar';
                  }

    obj.opcionMenu = opcionMenu;
    obj.accion = accion;

                  obj.hOidCentroDistribucion     = get('formulario.cbCentroDistribucion');
                  obj.hOidMapaCentroDistribucion = get('formulario.cbMapaCentroDistribucion');

                  obj.hOidMapaZonas	 = get('formulario.cbMapaZonas');
                  obj.hOidOrdenAnaquel = get('formulario.cbOrdenAnaquel');

                  var retorno = mostrarModalSICC('LPMantenimientoOrdenAnaqueles', accion, obj, '850', '700');

    if(retorno!=null && retorno[0]=="OK"){
      fLimpiar();
    }
    
         }
}

function fBorrar(){
  if(sicc_validaciones_generales()) {
      if(GestionarMensaje("3360")){     
           eval('formulario').oculto= 'S';
           set('formulario.conectorAction', 'LPMantenimientoOrdenAnaqueles');
           set('formulario.accion', 'eliminarConfirmado');
           enviaSICC('formulario', null, null, 'N');
      }
  }
}


function fLimpiar(){

  set('formulario.cbCentroDistribucion', [get('formulario.hCbCentroDistribucion')]);
  
  set_combo('formulario.cbMapaZonas', arrayVacio());
  set_combo('formulario.cbOrdenAnaquel', arrayVacio());
         
  if (get('formulario.hCbCentroDistribucion')!=''){
      onChangeCentroDistribucion();    
  }
  
  if(get('formulario.opcionMenu') == 'eliminar'){
      btnProxy(4, '1');
   }
  
  focaliza("formulario.cbCentroDistribucion");  
}


function onshtabCentroDistribucion(){
         focoBotonBuscar();
}

function focoBotonBuscar() {
         focalizaBotonHTML('botonContenido','btnAceptar');	
}

function onTABCentroDistribucion(){
         focoMapaCentroDistr();
}

function focoMapaCentroDistr() {
         focaliza("formulario.cbMapaCentroDistribucion");
}

function onshtabMapaCentroDistribucion(){
         focoCentroDistribucion();
}

function focoCentroDistribucion(){
         focaliza("formulario.cbCentroDistribucion");
}

function onTABMapaCentroDistribucion(){
         focoMapaZonas();
}

function focoMapaZonas() {
         focaliza("formulario.cbMapaZonas");
}

function onshtabMapaZonas(){
         focoMapaCentroDistr();
}

function focoMapaCentroDistr(){
         focaliza("formulario.cbMapaCentroDistribucion");
}

function onTABMapaZonas(){
         focoMapaOrden();
}

function focoMapaOrden(){
         focaliza("formulario.cbOrdenAnaquel");
}

function onshtabOrdenAnaquel(){
         focoMapaZonas();
}

function onTABOrdenAnaquel(){
         focoBotonBuscar()
}

function onTABbtnBuscar(){
    focoCentroDistribucion();
}

function onshtabbtnBuscar(){
         focoMapaOrden();
}
