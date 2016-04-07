var formName = "formulario";
var listaOculta = "true";

// --------------------------------------------------------------------------------------------- //
function onLoadPag(){   
    
    var errDescripcion = get('formulario.errDescripcion');
    if (errDescripcion != '') {          
         var errCodigo = get('formulario.errCodigo');
         var wnd = fMostrarMensajeError(errCodigo, errDescripcion);
     }
    
    configurarMenuSecundario('formulario');     
    DrdEnsanchaConMargenDcho('listado1',12);
    ocultarLista();
    ocultarBotones();
    eval (ON_RSZ); 
  
    focaliza('formulario.cbCentroDistribucion');
    
    // Después de Activar recargamos la lista
    var exec = get('formulario.ejecutar');
    
    
    if( exec == "reload"){
         onClickBuscar();
    }
    
}

// --------------------------------------------------------------------------------------------- //
function ocultarLista() {

    document.all["Cplistado1"].style.visibility='hidden';
    document.all["CpLin1listado1"].style.visibility='hidden';
    document.all["CpLin2listado1"].style.visibility='hidden';
    document.all["CpLin3listado1"].style.visibility='hidden';
    document.all["CpLin4listado1"].style.visibility='hidden';
    document.all["primera1Div"].style.visibility='hidden';
    document.all["ret1Div"].style.visibility='hidden';
    document.all["ava1Div"].style.visibility='hidden';
    document.all["separaDiv"].style.visibility='hidden';
    
    listaOculta = "true";

}

// --------------------------------------------------------------------------------------------- //
function mostrarLista() {

    document.all["Cplistado1"].style.visibility='';
    document.all["CpLin1listado1"].style.visibility='';
    document.all["CpLin2listado1"].style.visibility='';
    document.all["CpLin3listado1"].style.visibility='';
    document.all["CpLin4listado1"].style.visibility='';
    document.all["primera1Div"].style.visibility='';
    document.all["ret1Div"].style.visibility='';
    document.all["ava1Div"].style.visibility='';
    document.all["separaDiv"].style.visibility='';
    
    listaOculta = "false";
    
}

// --------------------------------------------------------------------------------------------- //
function ocultarBotones(){

    document.all["Activar"].style.visibility='hidden';
    document.all["Desactivar"].style.visibility='hidden';

}

// --------------------------------------------------------------------------------------------- //
function mostrarBotones(){

    document.all["Activar"].style.visibility='';
    document.all["Desactivar"].style.visibility='';

}

// --------------------------------------------------------------------------------------------- //

function onChangeCbCentroDistribucion() {

         var oidCD = get('formulario.cbCentroDistribucion', 'V');
    var oidPeri = get('formulario.cbPeriodo', 'V');

         if (oidCD != '' && oidPeri != '') {
                  var arr = new Array();
                  arr[arr.length] = new Array("oidCentroDistribucion", oidCD);
                  arr[arr.length] = new Array("oidPeriodo", oidPeri);
                  
                  recargaCombo('formulario.cbVersion', 'APEObtenerVersionesAsignacion', 
                           'es.indra.sicc.dtos.ape.DTOMantenerAsignacionProductosAnaqueles', arr);
         } else {
                  // Si no hay CD ni periodo seleccionados, se borra el contenido de cbVersion
                  set_combo('formulario.cbVersion', new Array(['','']), ['']);
         }
}

// --------------------------------------------------------------------------------------------- //
function onChangeCbCanal(){

         var marca = get("formulario.cbMarca", 'V');
         var canal = get('formulario.cbCanal', 'V');
         if (marca != '' && canal != '') {
                  var pais = get("formulario.hPais");
                  
                  var arr = new Array();
                  arr[arr.length] = new Array("marca", marca);
                  arr[arr.length] = new Array("canal", canal);
                  arr[arr.length] = new Array("pais", pais);
                  
                  recargaCombo('formulario.cbPeriodo', 'CRAObtienePeriodos', 'es.indra.sicc.dtos.cra.DTOPeriodo', arr);
         } else {
                  // Si no hay marca ni canal seleccionados, se borra el contenido de cbPeriodo y cbVersion
                  set_combo('formulario.cbVersion', new Array(['','']), ['']);
                  set_combo('formulario.cbPeriodo', new Array(['','']), ['']);
         }
}

// --------------------------------------------------------------------------------------------- //
function onChangeCbMarca(){

         var marca = get("formulario.cbMarca", 'V');
         var canal = get('formulario.cbCanal', 'V');
         if (marca != '' && canal != '') {
                  var pais = get("formulario.hPais");
                  
                  var arr = new Array();
                  arr[arr.length] = new Array("pais", pais);
                  arr[arr.length] = new Array("marca", marca);
                  arr[arr.length] = new Array("canal", canal);
                  
                  recargaCombo('formulario.cbPeriodo', 'CRAObtienePeriodos', 'es.indra.sicc.dtos.cra.DTOPeriodo', arr);
         } else {
                  // Si no hay marca ni canal seleccionados, se borra el contenido de cbPeriodo y cbVersion
                  set_combo('formulario.cbVersion', new Array(['','']), ['']);
                  set_combo('formulario.cbPeriodo', new Array(['','']), ['']);
         }
}

// --------------------------------------------------------------------------------------------- //
function onChangeCbPeriodo() {

    var oidCD = get('formulario.cbCentroDistribucion', 'V');
    var oidPeri = get('formulario.cbPeriodo', 'V');

         if (oidCD != '' && oidPeri != '') {
                  var arr = new Array();
                  arr[arr.length] = new Array("oidCentroDistribucion", oidCD);
                  arr[arr.length] = new Array("oidPeriodo", oidPeri);
                  
                  recargaCombo('formulario.cbVersion', 'APEObtenerVersionesAsignacion', 
                           'es.indra.sicc.dtos.ape.DTOMantenerAsignacionProductosAnaqueles', arr);
         } else {
                  // Si no hay CD ni periodo seleccionados, se borra el contenido de cbVersion
                  set_combo('formulario.cbVersion', new Array(['','']), ['']);
         }
}

// --------------------------------------------------------------------------------------------- //
function onClickBuscar(){
    
    if(sicc_validaciones_generales()) {   
         var parametros = armarArray();
         
         configurarPaginado( mipgndo, 
             'APEConsultarVersionesAsignacion', 
             'ConectorConsultarVersionesAsignacion',
             'es.indra.sicc.dtos.ape.DTOMantenerAsignacionProductosAnaqueles',
             parametros );
    }          
}

// --------------------------------------------------------------------------------------------- //
function armarArray()  {
    
    var array = new Array();
    
    array[array.length] = new Array('oidCentroDistribucion', get('formulario.cbCentroDistribucion'));
    array[array.length] = new Array('oidPeriodo', get('formulario.cbPeriodo'));
    array[array.length] = new Array('oidAsignacionProductoAnaquel', get('formulario.cbVersion'));
    
    return array;
}

// --------------------------------------------------------------------------------------------- //
function onClickActivar(){

    var codigos = listado1.codSeleccionados();
    var tam = codigos.length;
    
    if( tam == 1 ){     
         
         if(sicc_validaciones_generales()) {  
         
           if(listado1.extraeDato(codigos[0],7)=="N"){
         
             var oidPA = codigos;                                    // oidProd.Anaq.
             var oidCD = listado1.extraeDato(codigos[0],4);      // oidCent.Dist.
             
             set('formulario.hOidProdAnaq', oidPA);
             set('formulario.hCentDist', oidCD);
             set('formulario.hOidLinea', listado1.extraeDato(codigos[0],6));
             
             eval("formulario").oculto= "S";
             set("formulario.conectorAction", "LPMantenerVerAsigProdAnaqueles");
             set("formulario.accion", "activarVersion");
             enviaSICC("formulario"); 
             
           } else {
             GestionarMensaje('2610');
           }
         }
         
    } else if( tam < 1) {
         GestionarMensaje('50');

    } else {
         GestionarMensaje('1217');
    }
    
}

function onClickDesactivar(){

    var codigos = listado1.codSeleccionados();
    var tam = codigos.length;
    
    if( tam == 1 ){     
         
         if(sicc_validaciones_generales()) {  
         
           if(listado1.extraeDato(codigos[0],7)=="S"){
         
             var oidPA = codigos;                                    // oidProd.Anaq.
             
             set('formulario.hOidProdAnaq', oidPA);
             
             eval("formulario").oculto= "S";
             set("formulario.conectorAction", "LPMantenerVerAsigProdAnaqueles");
             set("formulario.accion", "desactivarVersion");
             enviaSICC("formulario"); 
             
           } else {
             GestionarMensaje('2611');
           }
         }
         
    } else if( tam < 1) {
         GestionarMensaje('50');

    } else {
         GestionarMensaje('1217');
    }
    
}

// --------------------------------------------------------------------------------------------- //
function onShTab(origen){
   if(origen==1){
      if(listado1.codigos().length!=0){
           focalizaBotonHTML_XY('Desactivar');
      } else {
           focalizaBotonHTML('botonContenido','btnBuscar');
      }
    } else if(origen==2){
         focalizaBotonHTML('botonContenido','btnBuscar');
    }
}

// --------------------------------------------------------------------------------------------- //
function onTab(origen){
    if(origen==1){
      if(listado1.codigos().length!=0){
           focalizaBotonHTML_XY('Activar');
      } else {
           focaliza('formulario.cbCentroDistribucion');
      }
    } else if(origen==2){
         focaliza('formulario.cbCentroDistribucion');
    }
}

// --------------------------------------------------------------------------------------------- //
function fLimpiar(){

    set('formulario.cbCentroDistribucion', '');
    set('formulario.cbMarca', '');
    set('formulario.cbCanal', '');
    set_combo('formulario.cbPeriodo', [['', '']], '');
    set_combo('formulario.cbVersion', [['', '']], '');
    
    ocultarLista();
    ocultarBotones();
    
    focaliza('formulario.cbCentroDistribucion');

}

// --------------------------------------------------------------------------------------------- //
function muestraLista(ultima, rowset, error){

    var tamano = rowset.length;
    if (tamano > 0) {
         
         mostrarLista();
         mostrarBotones();
         eval(ON_RSZ);
         return true;
    
    } else {
         
         ocultarLista();
         ocultarBotones();
         focaliza("formulario.cbCentroDistribucion");
         return false;
    }

}