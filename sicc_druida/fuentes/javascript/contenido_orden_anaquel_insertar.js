function onLoadPag(){
    configurarMenuSecundario('formulario');
    fMostrarMensajeError();

    if (get('formulario.errCodigo')=="200044"){
         modificarOk();
    }

    if (get('formulario.opcionMenu') != 'insertar'){
      //seteo valores de combo elejidos en la pagina de busqueda
      seteoValoresCbSelecEnBusqueda();      
      deshabilitaCab();
      internacionalizacionOrdenacion();
      mostrarLista();
      
      focaliza("formulario.ChkOrdenPorDefecto");
      
    } else{
    
      ocultarLista();      
      set('formulario.cbCentroDistribucion', [get('formulario.hCbCentroDistribucion')]);
      if (get('formulario.hCbCentroDistribucion')!=''){
           onChangeCentroDistribucion();    
      }      
      focaliza("formulario.cbCentroDistribucion");
    }
}


function internacionalizacionOrdenacion(){
  
  var codigos = listado1.codigos();
         for(var i=0; i<codigos.length; i++){
  
      if(listado1.extraeDato(codigos[i],1)=="SI"){
           listado1.insertaDato(codigos[i],1,GestionarMensaje('1010'),false);
      } else{
           listado1.insertaDato(codigos[i],1,GestionarMensaje('1011'),false);
      }
  }
}

//*** inicio- agregado y modificado por cvalenzu

function seteoValoresCbSelecEnBusqueda(){
         //seteo valores de combos seleccionado en la pagina de busqueda
         
         set('formulario.cbCentroDistribucion', [get('formulario.hCbCentroDistribucion')]);
         recargaCombo('formulario.cbMapaCentroDistribucion', 'APEObtenerMapasCDPorCD', 
    'es.indra.sicc.util.DTOOID', [['oid', get('formulario.cbCentroDistribucion')], ['oidIdioma', get('formulario.hIdioma')]], 'rellenarComboMapaCentroDistribucion(datos)');

  /*set('formulario.cbMapaCentroDistribucion', [get('formulario.hOidMapaCentrDistr')]);
         set('formulario.cbMapaZonas', [get('formulario.hOidMapaZona')]);
         set('formulario.cbLineaArmado', [get('formulario.hOidLnArmado')]);
         set('formulario.cbSublineaArmado', [get('formulario.hOidSublnArmado')]);*/
         
         set('formulario.txtDescripcion', get('formulario.hTxtDescripcion'));
         set('formulario.ChkOrdenPorDefecto', get('formulario.hChkOrdenPorDefecto'));
         btnProxy(5, '0');

         if ( (get('formulario.opcionMenu') == 'consultar') || (get('formulario.opcionMenu') == 'eliminar') ){
             document.getElementById("ChkOrdenPorDefecto").disabled = true;
         }
}

function rellenarComboMapaCentroDistribucion(datos) {
         var arrayNuevo = new Array();
         arrayNuevo[0] = new Array('','');
         arrayNuevo = arrayNuevo.concat(datos);
         set_combo('formulario.cbMapaCentroDistribucion',arrayNuevo);

         //Si existe oid de mapa centro se deja seleccionado
         //y se cargan los combos mapa zonas y linea armaado
         if(get("formulario.hOidMapaCentrDistr")!="") {
                  var oidMapaCentrDistr = get("formulario.hOidMapaCentrDistr");  
                  var oidSeleccionado = new Array();
                  oidSeleccionado = oidMapaCentrDistr.split(",");	    
             set("formulario.cbMapaCentroDistribucion", oidSeleccionado);			
                  recargaCombosMapaZonasLineaArmado();
         }
}

function recargaCombosMapaZonasLineaArmado() {
          recargaCombo('formulario.cbLineaArmado', 'APEObtenerLineasMapaCD', 
     'es.indra.sicc.util.DTOOID', [['oid', get('formulario.cbMapaCentroDistribucion')], ['oidIdioma', get('formulario.hIdioma')]]
     ,'rellenarComboLineaArmado(datos)');

     recargaCombo('formulario.cbMapaZonas', 'APEObtenerMapaZonaPorMapaCD',
          'es.indra.sicc.util.DTOOID', [['oid', get('formulario.cbMapaCentroDistribucion')], ['oidIdioma', get('formulario.hIdioma')]]
     ,'rellenarComboMapaZonas(datos)');
}

function rellenarComboLineaArmado(datos) {
         var arrayNuevo = new Array();
         arrayNuevo[0] = new Array('','');
         arrayNuevo = arrayNuevo.concat(datos);
         set_combo('formulario.cbLineaArmado',arrayNuevo);
  
  //Si existe oid de linea armado se deja seleccionado
         if(get("formulario.hOidLnArmado")!="") {
                  var oidLineaArmado = get("formulario.hOidLnArmado");  
                  var oidSeleccionado = new Array();
                  oidSeleccionado = oidLineaArmado.split(",");	    
             set("formulario.cbLineaArmado", oidSeleccionado);			
         }
}



function rellenarComboMapaZonas(datos) {
         var arrayNuevo = new Array();
         arrayNuevo[0] = new Array('','');
         arrayNuevo = arrayNuevo.concat(datos);
         set_combo('formulario.cbMapaZonas',arrayNuevo);

         //Si existe oid de mapa zona se deja seleccionado
         if(get("formulario.hOidMapaZona")!="") {
                  var oidMapaZona = get("formulario.hOidMapaZona");  
                  var oidSeleccionado = new Array();
                  oidSeleccionado = oidMapaZona.split(",");	    
             set("formulario.cbMapaZonas", oidSeleccionado);			
         }
}

//*** fin- agregado y modificado por cvalenzu

function onChangeCentroDistribucion(){
    if(get('formulario.cbCentroDistribucion') != ''){
         accion('formulario.cbMapaCentroDistribucion', '.disabled=false');
         recargaCombo('formulario.cbMapaCentroDistribucion', 'APEObtenerMapasCDPorCD', 
           'es.indra.sicc.util.DTOOID', [['oid', get('formulario.cbCentroDistribucion')], ['oidIdioma', get('formulario.hIdioma')]]);
    } else {
         set_combo('formulario.cbMapaCentroDistribucion', arrayVacio());
         accion('formulario.cbMapaCentroDistribucion', '.disabled=true');
         set_combo('formulario.cbLineaArmado', arrayVacio());
         accion('formulario.cbLineaArmado', '.disabled=true');
         
         comboSubLineaVacio();
    }
      
}

function onChangeMapaCentroDistribucion(){
    if(get('formulario.cbMapaCentroDistribucion') != ''){
         accion('formulario.cbLineaArmado', '.disabled=false');
         recargaCombo('formulario.cbLineaArmado', 'APEObtenerLineasMapaCD', 
           'es.indra.sicc.util.DTOOID', [['oid', get('formulario.cbMapaCentroDistribucion')], ['oidIdioma', get('formulario.hIdioma')]]
           ,'recargaLineaArmado(datos)');

                  //el cb mapa zonas
         accion('formulario.cbMapaZonas', '.disabled=false');  
         recargaCombo('formulario.cbMapaZonas', 'APEObtenerMapaZonaPorMapaCD',
                  'es.indra.sicc.util.DTOOID', [['oid', get('formulario.cbMapaCentroDistribucion')], ['oidIdioma', get('formulario.hIdioma')]]
           ,'recargaMapaZonas(datos)');
    } else {         
         set_combo('formulario.cbLineaArmado', arrayVacio());
         accion('formulario.cbLineaArmado', '.disabled=true');
         comboSubLineaVacio();
    }
}



function recargaMapaZonas(datos){
         mapaZonasDef = obtenerMapaZonasDef(datos); 
         seteo = cargaArray(datos);
    set_combo('formulario.cbMapaZonas', seteo);
    set('formulario.cbMapaZonas', [mapaZonasDef]);

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

function recargaLineaArmado(datos){
    lineaArmadoDef = obtenerLineaArmadoDef(datos);
    //alert("lineaDef: " + lineaDef);
    seteo = cargaArray(datos);
    set_combo('formulario.cbLineaArmado', seteo);
    set('formulario.cbLineaArmado', [lineaArmadoDef]);
}

function obtenerLineaArmadoDef(datos){
    valoresLineaArmadoDef = get('formulario.hCbLineaArmadoCDDef').split(",");
    //alert("valoresLineasDef: " + valoresLineasDef);
    if(datos != "" && valoresLineaArmadoDef != ""){
    
         for(i = 0; i < datos.length; i++){
           oidLinea = datos[i][0];
           //alert("oidLinea: " + oidLinea);
           for(j = 0; j < valoresLineaArmadoDef.length; j++){  
             //alert("valoresLineasDef[j]: " + valoresLineasDef[j]);
             if(valoresLineaArmadoDef[j]==oidLinea){
                  return oidLinea;
             }
           }
         } 
         return "";
         
    } else {
         return "";
    }
}
                                                                                                  
function fLimpiar(){

    if (get('formulario.opcionMenu') == 'insertar'){
         limpiaYhabilitaObjetos();
         limpiaI18N('formulario', 1);
         
    } else {
         eval("formulario").oculto= "N";
         set("formulario.conectorAction", "LPMantenimientoOrdenAnaqueles");
         enviaSICC("formulario"); 
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

function onClickBtnBuscar(){
         if(sicc_validaciones_generales()) {  
           set("formulario.hOidMapaZona", get('formulario.cbMapaZonas'));
                  set("formulario.hOidMapaCentrDistr", get('formulario.cbMapaCentroDistribucion'));
                  set('formulario.hChkOrdenPorDefecto', get('formulario.ChkOrdenPorDefecto'));

    eval("formulario").oculto= "S";
    set("formulario.conectorAction", "LPMantenimientoOrdenAnaqueles");
    set("formulario.accion", "Buscar");
    enviaSICC("formulario"); 
  }
}

function muestraLista(ultima, rowset) {
    var tamanio = rowset.length;

    if (tamanio > 0) {
    for(i = 0; i < rowset.length; i++){
         if(rowset[i][2]=="SI"){
             rowset[i][2] = GestionarMensaje('1010');
         } else{
             rowset[i][2] = GestionarMensaje('1011');
         }
     }
      
      deshabilitaCab();
      mostrarLista();
      focalizaBotonHTML_XY('AsignarOrden');
      return true;
      
   } else {
        ocultarLista();
        return false;
   }
} 

function deshabilitaCab(){
    inHabilitoObjetos();
    deshabilitarHabilitarBoton('botonContenido','btnBuscar','D');
    
    botonesMenSec();
}

function botonesMenSec(){

    if(get('formulario.opcionMenu') == 'consultar' || get('formulario.opcionMenu') == "eliminar"){
         btnProxy(1, '0');
         btnProxy(5, '0');
    } else {
         btnProxy(1, '1');
         btnProxy(5, '1');
    }
    
    // Menu secundario en la modal
    btnProxy(2, '1');
    btnProxy(3, '0');
    btnProxy(4, '0');
    btnProxy(7, '0');
    btnProxy(8, '0');
    btnProxy(9, '0');
}


function buscarSubLineas(){

     var arr = new Array();
     
     var idioma = get("formulario.hIdioma");
     arr[arr.length] = new Array("oidIdioma", idioma);          
     arr[arr.length] = new Array("oidLinea", get('formulario.cbLineaArmado')); 
     arr[arr.length] = new Array("oidOrdenAnaquelCab", get('formulario.oidOrdenAnaqCabecera')); 
     
     configurarPaginado(mipgndo,"APEObtenerSublineasLineaOrdenacion","ConectorObtenerSublineasLineaOrdenacion",
                           "es.indra.sicc.dtos.ape.DTOSublineasLineaOrdenacion",arr);
                           
     
}

function onClickBtnAsignarOrden(){
  
   if (listado1.numSelecc() == 1){   
   
      if(get('formulario.opcionMenu') == 'insertar'){
           onClickBtnAsignarOrdenInsertar();
      } else if(get('formulario.opcionMenu') == 'consultar' || get('formulario.opcionMenu') == 'eliminar'){
           onClickBtnAsignarOrdenConsultar();
      }  else {
           onClickBtnAsignarOrdenGeneral();
      }  
      
   } else{
     GestionarMensaje('8',null,null,null);
   } 
}

function onClickBtnAsignarOrdenConsultar(){

    codigo = listado1.codSeleccionados();
    
    if(listado1.extraeDato(codigo, 1)==GestionarMensaje('1011')){           
           GestionarMensaje('2593',null,null,null);
    } else {
           onClickBtnAsignarOrdenGeneral();
    }
}

function onClickBtnAsignarOrdenInsertar(){

    codigo = listado1.codSeleccionados();
    
    if(listado1.extraeDato(codigo, 1)==GestionarMensaje('1011') || 
        (listado1.extraeDato(codigo, 1)==GestionarMensaje('1010') && GestionarMensaje('2591',null,null,null))){
           
           onClickBtnAsignarOrdenGeneral();
    }
}

function onClickBtnAsignarOrdenGeneral(){

   codigo = listado1.codSeleccionados();
 
   var obj = new Object();
   obj.opcionMenu = get('formulario.opcionMenu');
   obj.accion = 'AsignarOrden';
   obj.hOidSublnArmado = codigo;
   obj.hOidMapaCentrDistr = get('formulario.cbMapaCentroDistribucion');
   obj.detalleSubLinea = listado1.extraeDato(codigo, 2);
   
   var retorno = mostrarModalSICC('LPMantenimientoOrdenAnaqueles', 'AsignarOrden', obj, '900', '450');
   
   if(retorno!=null){          
      listado1.insertaDato(codigo,1,GestionarMensaje('1010'),false);
      listado1.insertaDato(codigo,2,retorno[0],true);
      
      listado1.deselecciona (DrIndiceEnArray(listado1.datos, codigo, 0));
   }        
}

function onClickBtnDetalle(){
  onClickBtnAsignarOrden();
}

function onClickBtnDesasignarOrden(){
  if (listado1.numSelecc() == 1){   
      codigo = listado1.codSeleccionados();
   
      if(listado1.extraeDato(codigo, 1)==GestionarMensaje('1011')){           
           GestionarMensaje('2594',null,null,null);
      } else {
           listado1.insertaDato(codigo,2,"",true);
           listado1.insertaDato(codigo,1,GestionarMensaje('1011'),false);
           
           listado1.deselecciona (DrIndiceEnArray(listado1.datos, codigo, 0));
      }          
   } else{
     GestionarMensaje('8',null,null,null);
   }
}

function fGuardar() {

 if(sicc_validaciones_generales()) {
      var codigos = listado1.codigos();
      var mensaje = "S";
    
      for (var i=0; i<codigos.length ; i++){
         if(listado1.extraeDato(codigos[i], 1)==GestionarMensaje('1010')){
             mensaje = "N";
         }
      }
      
      if(mensaje=="S"){
           GestionarMensaje('2592',null,null,null);
           return;
      }
 
      set('formulario.listaDetalles', armarListaDetalles());      
      set('formulario.hChkOrdenPorDefecto', get('formulario.ChkOrdenPorDefecto'));
      
      if (get('formulario.opcionMenu')!= 'modificar'){
         eval('formulario').oculto= 'S';
         set('formulario.conectorAction', 'LPMantenimientoOrdenAnaqueles');
         set('formulario.accion', 'Guardar');
         enviaSICC('formulario');
         
      } else{
           if (get('formulario.hiddenDefault') == 'S' && get('formulario.ChkOrdenPorDefecto') == 'N') {
             noExisteUnOrdenAnaqDefault();
           }
           
           eval('formulario').oculto= 'S';
           set('formulario.conectorAction', 'LPMantenimientoOrdenAnaqueles');
           set('formulario.accion', 'GuardarModificacion');           
           enviaSICC('formulario');
      }
  }
}

function armarListaDetalles(){                                                                                
    var codigos = listado1.codigos();
    var cadena = "";
    
    for (var i=0; i<codigos.length ; i++){
         if(listado1.extraeDato(codigos[i], 1)==GestionarMensaje('1010')){
    
             if( cadena!= "")
                cadena = cadena + "%";
                
             oidSubLinea = codigos[i];
             cadena = cadena + oidSubLinea + "$";
             
             anaqueles = listado1.extraeDato(codigos[i], 2);
             
             cadena = cadena + anaqueles;                
         }           
    }    
   // alert("cadena: " + cadena);
    return cadena;
}

function fVolver() {
    close();
}

function yaExisteUnOrdenAnaqPorDef(descCD, descMapaCD, descMapaZona, descMapaAnaq) {
         eval("formulario").oculto= "N";
         var objParametros = new Object();
         objParametros.CD = descCD;
         objParametros.MapaCD = descMapaCD;
         objParametros.MapaZona = descMapaZona;
         objParametros.MapaAnaquel = descMapaAnaq;
         
  GestionarMensaje('APEUI060', objParametros); // Antes era '2580' (casi igual pero no parametrizado)
  
  if(get('formulario.opcionMenu') != 'insertar' ){
                           botonesMenSec();
         }
         return;
}

function noExisteUnOrdenAnaqDefault() {
         GestionarMensaje('APEUI059');
         return;
}

function noHayAnaqSinExpand(){
         eval("formulario").oculto= "N";
    GestionarMensaje('2581');
         return;
}



function visualizaBotones(){  

    opcionMenu = get('formulario.opcionMenu');
    
    if(opcionMenu == "insertar"){
         document.all["AsignarOrdenDiv"].style.visibility='';
         document.all["DesasignarOrdenDiv"].style.visibility='hidden';
         document.all["DetalleDiv"].style.visibility='hidden';
   } else if(opcionMenu == "modificar"){
         document.all["AsignarOrdenDiv"].style.visibility='';
         document.all["DesasignarOrdenDiv"].style.visibility='';
         document.all["DetalleDiv"].style.visibility='hidden';
   } else if(opcionMenu == "consultar"){
         document.all["AsignarOrdenDiv"].style.visibility='hidden';
         document.all["DesasignarOrdenDiv"].style.visibility='hidden';
         document.all["DetalleDiv"].style.visibility='';
    } else if(opcionMenu == "eliminar"){
         document.all["AsignarOrdenDiv"].style.visibility='hidden';
         document.all["DesasignarOrdenDiv"].style.visibility='hidden';
         document.all["DetalleDiv"].style.visibility='';
    }
}

function mostrarLista(){
    DrdEnsanchaConMargenDcho('listado1',12);
    document.all["Cplistado1"].style.visibility='visible';
    document.all["CpLin1listado1"].style.visibility='visible';
    document.all["CpLin2listado1"].style.visibility='visible';
    document.all["CpLin3listado1"].style.visibility='visible';
    document.all["CpLin4listado1"].style.visibility='visible';
    
    document.all["primeraDiv"].style.visibility='hidden'; 
    document.all["retDiv"].style.visibility='hidden';
    document.all["avaDiv"].style.visibility='hidden';  
    document.all["separaDiv"].style.visibility='hidden'; 
    
    eval (ON_RSZ);  
    
    visualizaBotones();
}

function ocultarLista(){
         DrdEnsanchaConMargenDcho('listado1',12);
         document.all["Cplistado1"].style.visibility='hidden';
         document.all["CpLin1listado1"].style.visibility='hidden';
         document.all["CpLin2listado1"].style.visibility='hidden';
         document.all["CpLin3listado1"].style.visibility='hidden';
         document.all["CpLin4listado1"].style.visibility='hidden';
  
  document.all["primeraDiv"].style.visibility='hidden'; 
  document.all["retDiv"].style.visibility='hidden';
  document.all["avaDiv"].style.visibility='hidden';  
  document.all["separaDiv"].style.visibility='hidden'; 
  
  document.all["AsignarOrdenDiv"].style.visibility='hidden';
  document.all["DesasignarOrdenDiv"].style.visibility='hidden';
  document.all["DetalleDiv"].style.visibility='hidden';
    
         eval (ON_RSZ);  
}                                                              

//function mostrarListaConValores(valoresLista, valoresComboLista, valoresSeleccionadosComboLista) {
function mostrarListaConValores(valoresLista, valoresComboLista, valoresComboOidsLista) {

         mostrarCapaCabecera();

         var filasTempCombo = valoresComboLista.split("|");
    var datosCombo = new Array(filasTempCombo.length);
         var filasTempOidsCombo = valoresComboOidsLista.split("|");
  
         for(var j=0; j<filasTempCombo.length ; j++) {
                  var columnasTempCombo = filasTempCombo[j].split("$");
                  var oidCombo = filasTempOidsCombo[j].split("$");

                  //alert("columnasTempCombo: " + columnasTempCombo);
                  //alert("oidComboSCS: " + oidCombo);

                  if (columnasTempCombo==" ")
                  {
                           columnasTempCombo = ' ';
                  }

                  datosCombo[j] = [ oidCombo, columnasTempCombo ];
         }

    listado1.tiposCol[0][2] = datosCombo;                   
         ////////////////////////////////////////////////////////////////
         var datos = new Array();
         var filasTemp = valoresLista.split("|");
         for(var i=0; i<filasTemp.length ; i++) {
                  var columnasTemp = filasTemp[i].split("$");
                  datos[i] = columnasTemp;
         }
         listado1.setDatos(datos);

         listado1.repinta();	 
         inHabilitoObjetos();

         if ((get('formulario.opcionMenu') == 'modificar') ||
                  (get('formulario.opcionMenu') == 'insertar')){
             btnProxy(1, '1');
         }

         if (get('formulario.opcionMenu') == 'modificar'){
             btnProxy(5, '0');
         }

}

function mostrarCapaCabecera() {
         document.all["capa1"].style.visibility= "visible";
}


function inHabilitoObjetos() {
                  document.getElementById("cbCentroDistribucion").disabled = true;
                  document.getElementById("cbMapaCentroDistribucion").disabled = true;
                  document.getElementById("cbMapaZonas").disabled = true;
                  document.getElementById("txtDescripcion").disabled = true;
                  document.getElementById("cbLineaArmado").disabled = true;
                  if (get('formulario.opcionMenu') == 'insertar') {
                           document.getElementById("ChkOrdenPorDefecto").disabled = true; // eiraola 03/Jul/2007
                  }
}

function limpiaYhabilitaObjetos() {

         document.getElementById("cbCentroDistribucion").disabled = false;
         document.getElementById("cbMapaCentroDistribucion").disabled = false;
         document.getElementById("cbMapaZonas").disabled = false;
         document.getElementById("txtDescripcion").disabled = false;
         document.getElementById("cbLineaArmado").disabled = false;
         document.getElementById("ChkOrdenPorDefecto").disabled = false; // eiraola 03/Jul/2007
  
  deshabilitarHabilitarBoton('botonContenido','btnBuscar','A');
    
  set_combo('formulario.cbMapaZonas', arrayVacio());
  set('formulario.ChkOrdenPorDefecto', 'N');  
  set_combo('formulario.cbLineaArmado', arrayVacio());
  accion('formulario.cbLineaArmado', '.disabled=true');
         set('formulario.txtDescripcion', '');
  
  onChangeCentroDistribucion();
  
  listado1.limpia();
         ocultarLista();
}


function modificarOk() {
    var retorno = new Array();
    retorno[0] = "OK";
    
    returnValue = retorno;

    eval("formulario").oculto= "N";
    window.close();
}

function focoCentroDistribucion(){
    focaliza("formulario.cbCentroDistribucion");
}

function focoDescripcion() {
         focaliza("formulario.txtDescripcion");
}

function onTABChkOrdenPorDefecto() {
    if (get('formulario.opcionMenu') == 'insertar'){
         focalizaBotonHTML('botonContenido','btnBuscar');
    } else if (get('formulario.opcionMenu') == 'modificar'){
         focalizaBotonHTML_XY('AsignarOrden');
    }
}

function onTABBuscar() {
   if(listado1.codigos().length!=0){
      focalizaBotonHTML_XY('AsignarOrden');
   } else {
      focaliza("formulario.cbCentroDistribucion");
   }
}

function onTABAsignarOrden() {
    if (get('formulario.opcionMenu') == 'insertar'){
         focaliza("formulario.cbCentroDistribucion");
    } else if (get('formulario.opcionMenu') == 'modificar'){
         focalizaBotonHTML_XY('DesasignarOrden');
    }
}

function onTABDesasignarOrden() {
   focaliza("formulario.ChkOrdenPorDefecto");
}

function onTABDetalle() {
   focalizaBotonHTML_XY('Detalle');
}

function onShTABChkOrdenPorDefecto() {
    if (get('formulario.opcionMenu') == 'insertar'){
         focaliza("formulario.cbLineaArmado");
    } else if (get('formulario.opcionMenu') == 'modificar'){
         focalizaBotonHTML_XY('DesasignarOrden');
    }
}

function onShTABAsignarOrden() {
    if (get('formulario.opcionMenu') == 'insertar'){
         focalizaBotonHTML('botonContenido','btnBuscar');
    } else if (get('formulario.opcionMenu') == 'modificar'){
         focaliza("formulario.ChkOrdenPorDefecto");
    }
}

function onShTABCD() {
   if(listado1.codigos().length!=0){
      focalizaBotonHTML_XY('AsignarOrden');
   } else {
      focalizaBotonHTML('botonContenido','btnBuscar');
   }
}