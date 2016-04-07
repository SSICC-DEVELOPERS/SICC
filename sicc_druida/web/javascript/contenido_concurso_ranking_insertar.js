/**
* Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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

//Autor: Marcelo J. Maidana
//Fecha: 21/06/2005

var varNoLimpiarSICC = true;

function onLoadPag(){

    fMostrarMensajeError();
           configurarMenuSecundario('formulario');

    posicionarCombos();
    asignarChecks();
    asignarAreaTexto();
    onChangeCanal(); 
    
    
    //--Agregado para el consultar
    if(get("formulario.opcionMenu") == "Consultar Concurso Ranking"){
           deshabilitaCampos();
    }
                
    
    
    focaliza('formulario.textNombreConcurso');

    finCargaPagina = true;
}

//Autor: Marcelo J. Maidana
//Fecha: 21/06/2005
function onClickPestanyaPagina(numPestanya, form, lp){
    //Para validar formatos y que el combo Marca y Canal tenga valor
    
    
    if ((numPestanya == 3 && get('formulario.hIndEstadoParametrosGerentes')=='S') 
                || (numPestanya == 4 && get('formulario.hIndEstadoParametrosConsultoras')=='S') 
                || (numPestanya == 7 && get('formulario.hIndEstadoVariablesVenta')=='S')
                || numPestanya == 1 || numPestanya == 2 || numPestanya == 5 || numPestanya == 6){
           if (sicc_validaciones_generales()){
                if (comprobarDatosObligatorios()){
                      set('formulario.datosObligatorios', 'true');
                } else {
                      set('formulario.datosObligatorios', 'false');
                }
    
                pasarCamposAHiddens();
                onClickPestanyaHabilitada(numPestanya, form, lp);
           }
    }
}

//Autor: Marcelo J. Maidana
//Fecha: 28/06/2005
function asignarAreaTexto(){
    set('formulario.textObservaciones', get('formulario.hTextObservaciones'));
}



//Autor: Marcelo J. Maidana
//Fecha: 21/06/2005
function pasarCamposAHiddens(){
    pasarCombosAHiddens();
    pasarChecksAHiddens();
}

//Autor: Marcelo J. Maidana
//Fecha: 21/06/2005
function pasarCombosAHiddens(){
    set('formulario.hMarca', get('formulario.cbMarca')[0]);
    set('formulario.hCanal', get('formulario.cbCanal')[0]);
    set('formulario.hLstAccesos', get('formulario.cbAcceso').join(','));
    set('formulario.hPeriodoEvaluacionDesde', get('formulario.cbPeriodoEvaluacionDesde')[0]);
    set('formulario.hPeriodoEvaluacionHasta', get('formulario.cbPeriodoEvaluacionHasta')[0]);
    set('formulario.hPeriodoCalificacion', get('formulario.cbPeriodoCalificacion')[0]);
    set('formulario.hPeriodoPremiacion', get('formulario.cbPeriodoPremiacion')[0]);
    set('formulario.hConcursoDirigidoA', get('formulario.cbConcursoDirigidoA')[0]);
    set('formulario.hNivelAgrupamiento', get('formulario.cbNivelAgrupamiento')[0]);
    set('formulario.hTipoRanking', get('formulario.cbTipoRanking')[0]);
    set('formulario.hTipoExigencia', get('formulario.cbTipoExigencia')[0]);
          //alert("hPeriodoEvaluacionDesde: "+get('formulario.hPeriodoEvaluacionDesde'));
          //alert("hPeriodoEvaluacionHasta: "+get('formulario.hPeriodoEvaluacionHasta'));
          //alert("hPeriodoCalificacion: "+get('formulario.hPeriodoCalificacion'));
          //alert("hPeriodoPremiacion: "+get('formulario.hPeriodoPremiacion'));
}

//Autor: Marcelo J. Maidana
//Fecha: 21/06/2005
function pasarChecksAHiddens(){
    set('formulario.hDevoluciones', get('formulario.ckDevoluciones'));
    set('formulario.hAnulaciones', get('formulario.ckAnulaciones'));
    set('formulario.hFaltantesNoAnunciados', get('formulario.ckFaltantesNoAnunciados'));
    set('formulario.hActivo', get('formulario.ckActivo'));
}

//Autor: Marcelo J. Maidana
//Fecha: 21/06/2005
function comprobarDatosObligatorios(){
    if (get('formulario.textNombreConcurso') != '' && get('formulario.cbMarca') != '' &&
                get('formulario.cbCanal') != '' && get('formulario.cbAcceso') != '' &&
                get('formulario.cbPeriodoEvaluacionDesde') != '' && 
                get('formulario.cbPeriodoEvaluacionHasta') != '' &&
                get('formulario.cbPeriodoCalificacion') != '' &&
                get('formulario.cbPeriodoPremiacion') != '' &&
                get('formulario.cbConcursoDirigidoA') != '' &&
                get('formulario.cbNivelAgrupamiento') != '' &&
                get('formulario.cbTipoRanking') != ''){
           return true;
    } else {
           return false;
    }
}

//Autor: Marcelo J. Maidana
//Fecha: 21/06/2005
function fGuardar(){
    accionGuardar();
}

//Autor: Marcelo J. Maidana
//Fecha: 21/06/2005
function accionGuardar(){
         if(!sicc_validaciones_generales('camposOpcionales')) {
                  return;
    }   

    if (comprobarDatosObligatorios()){
           set('formulario.datosObligatorios', 'true');
    } else {
           set('formulario.datosObligatorios', 'false');
    }

    pasarCamposAHiddens();

    eval('formulario').oculto = 'S';
    set('formulario.conectorAction', 'LPMantenerConcursosRanking');
    set('formulario.accion', 'guardar');
    enviaSICC("formulario", "", "", "N");
}

//Autor: Marcelo J. Maidana
//Fecha: 21/06/2005 
//Mod Viviana Bongiovanni - 26/07/2005
function onChangeMarca(){
    if(get('formulario.hMarcaSel')!="" && get('formulario.hMarcaSel')!=get('formulario.cbMarca')) {
           if(GestionarMensaje('1572')) {
                set('formulario.hMarcaSel', [get('formulario.cbMarca')]);
                
                set('formulario.hPeriodoEvaluacionDesde', '');
                set('formulario.hPeriodoEvaluacionHasta', '');
                set('formulario.hPeriodoCalificacion', '');
                set('formulario.hPeriodoPremiacion', '');                
                
                cargarPeriodos("S");
           } else {
                set('formulario.cbMarca', [get('formulario.hMarcaSel')]);
           }
    } else {
           set('formulario.hMarcaSel', [get('formulario.cbMarca')]);
           cargarPeriodos("N");
    }
}

//Autor: Marcelo J. Maidana
//Fecha: 21/06/2005
//Mod Viviana Bongiovanni - 26/07/2005
function onChangeCanal(){
    if(get('formulario.hCanalSel')!="" && get('formulario.hCanalSel')!=get('formulario.cbCanal')) {
           if(GestionarMensaje('1572')) {
                set('formulario.hCanalSel', [get('formulario.cbCanal')]);
                
                set('formulario.hPeriodoEvaluacionDesde', '');
                set('formulario.hPeriodoEvaluacionHasta', '');
                set('formulario.hPeriodoCalificacion', '');
                set('formulario.hPeriodoPremiacion', '');
                set('formulario.hLstAccesos', '');
                
                cargarPeriodos("S");
                cargarAccesos();
           } else {
                set('formulario.cbCanal', [get('formulario.hCanalSel')]);
           }
    } else {
           set('formulario.hCanalSel', [get('formulario.cbCanal')]);
           cargarPeriodos("N");
                     recargaPeriodosMayores();
           cargarAccesos();
    }
}

//Cleal - 21864
function recargaPeriodosMayores(){
          var vArrayEvH = armarArrayDTOPeriodoMayor('cbEvH');
    recargaCombo("formulario.cbPeriodoEvaluacionHasta", 'COMObtenerPeriodosMayores', 'es.indra.sicc.dtos.cra.DTOPeriodo', vArrayEvH);
          
          var vArrayCal = armarArrayDTOPeriodoMayor('cbCal');
    recargaCombo("formulario.cbPeriodoCalificacion", 'COMObtenerPeriodosMayores', 'es.indra.sicc.dtos.cra.DTOPeriodo', vArrayCal);

          var vArrayPrem = armarArrayDTOPeriodoMayor('cbPrem');
    recargaCombo("formulario.cbPeriodoPremiacion", 'COMObtenerPeriodosMayores', 'es.indra.sicc.dtos.cra.DTOPeriodo', vArrayPrem);

}
// Cleal

function recargaComboPeriodoHasta() {
  //alert("*** recargaComboPeriodoHasta");
  var valor = get("formulario.cbPeriodoEvaluacionDesde");
  
  if(valor=="") {    
          var objArr = document.all['cbPeriodoEvaluacionHasta'];
    for(var i=0; i < objArr.length; i++){
              if(objArr[i].tagName && objArr[i].tagName.toUpperCase()=="SELECT"){
                         if (!objArr[i].disabled) {
                                    var aCombo = new Array(new Array("",""));
                                         set_combo('formulario.cbPeriodoEvaluacionHasta',aCombo, []);                                    
                                         set_combo('formulario.cbPeriodoCalificacion',aCombo, []);
                                         set_combo('formulario.cbPeriodoPremiacion',aCombo, []);
              }
           }
     }

          return;
  }

  
  var vArrayEvH = armarArrayDTOPeriodoMayor('cbEvH');
  //alert("cbEvH: "+vArrayEvH);
  
  recargaCombo("formulario.cbPeriodoEvaluacionHasta", 'COMObtenerPeriodosMayores', 'es.indra.sicc.dtos.cra.DTOPeriodo', vArrayEvH, "marcaComboPeriodosHasta(datos);");
}

function marcaComboPeriodosHasta(datos) {
          var datosNuevo = new Array();
          datosNuevo[0] = ["",""];

          for (var i = 0; i < datos.length; i++ )
                    datosNuevo[i+1]  = datos[i];

          set_combo("formulario.cbPeriodoEvaluacionHasta", datosNuevo);
          var sOidPeriodoHasta = get("formulario.hPeriodoEvaluacionHasta");
          var periodoSeleccionado = new Array();
          periodoSeleccionado = sOidPeriodoHasta.split(",");        
          set("formulario.cbPeriodoEvaluacionHasta", periodoSeleccionado)

                   recargaComboPeriodoCali();
}

function recargaComboPeriodoCali() {
  //alert("*** recargaComboPeriodoCali");
  var valor = get("formulario.cbPeriodoEvaluacionHasta");
  //alert("valor cbPeriodoEvaluacionHasta: "+valor);
  if(valor=="") {    
          var objArr = document.all['cbPeriodoCalificacion'];
    for(var i=0; i < objArr.length; i++){
              if(objArr[i].tagName && objArr[i].tagName.toUpperCase()=="SELECT"){
                         if (!objArr[i].disabled) {
                                    var aCombo = new Array(new Array("",""));                 
                                         set_combo('formulario.cbPeriodoCalificacion',aCombo, []);
                                         set_combo('formulario.cbPeriodoPremiacion',aCombo, []);
              }
           }
     }

          return;
  }

  
  var vArrayEvH = armarArrayDTOPeriodoMayor('cbCal');
  //alert("cbCal: "+vArrayEvH);
  
  recargaCombo("formulario.cbPeriodoCalificacion", 'COMObtenerPeriodosMayores', 'es.indra.sicc.dtos.cra.DTOPeriodo', vArrayEvH, "marcaComboPeriodosCali(datos);");
}

function marcaComboPeriodosCali(datos) {
          var datosNuevo = new Array();
          datosNuevo[0] = ["",""];

          for (var i = 0; i < datos.length; i++ )
                    datosNuevo[i+1]  = datos[i];

          set_combo("formulario.cbPeriodoCalificacion", datosNuevo);
          var sOidPeriodoHasta = get("formulario.hPeriodoCalificacion");
          var periodoSeleccionado = new Array();
          periodoSeleccionado = sOidPeriodoHasta.split(",");        
          set("formulario.cbPeriodoCalificacion", periodoSeleccionado)

                   recargaComboPeriodoPrem();
}

function recargaComboPeriodoPrem() {
  //alert("*** recargaComboPeriodoPrem");
  var valor = get("formulario.cbPeriodoCalificacion");
  //alert("valor cbPeriodoCalificacion: "+valor);
  if(valor=="") {    
          var objArr = document.all['cbPeriodoPremiacion'];
    for(var i=0; i < objArr.length; i++){
              if(objArr[i].tagName && objArr[i].tagName.toUpperCase()=="SELECT"){
                         if (!objArr[i].disabled) {
                                    var aCombo = new Array(new Array("",""));                 
                                         set_combo('formulario.cbPeriodoPremiacion',aCombo, []);
              }
           }
     }

          return;
  }

  
  var vArrayEvH = armarArrayDTOPeriodoMayor('cbPrem');
  //alert("cbPrem: "+vArrayEvH);
  
  recargaCombo("formulario.cbPeriodoPremiacion", 'COMObtenerPeriodosMayores', 'es.indra.sicc.dtos.cra.DTOPeriodo', vArrayEvH, "marcaComboPeriodosPrem(datos);");
}

function marcaComboPeriodosPrem(datos) {
          var datosNuevo = new Array();
          datosNuevo[0] = ["",""];

          for (var i = 0; i < datos.length; i++ )
                    datosNuevo[i+1]  = datos[i];

          set_combo("formulario.cbPeriodoPremiacion", datosNuevo);
          var sOidPeriodoHasta = get("formulario.hPeriodoPremiacion");
          var periodoSeleccionado = new Array();
          periodoSeleccionado = sOidPeriodoHasta.split(",");        
          set("formulario.cbPeriodoPremiacion", periodoSeleccionado)
}

//Cleal




function onChangePeriodoDesde(){

  //alert("*** onChangePeriodoDesde");
  var valor = get("formulario.cbPeriodoEvaluacionDesde");
  
  if(valor=="") {    
          var objArr = document.all['cbPeriodoEvaluacionHasta'];
    for(var i=0; i < objArr.length; i++){
              if(objArr[i].tagName && objArr[i].tagName.toUpperCase()=="SELECT"){
                         if (!objArr[i].disabled) {
                                    var aCombo = new Array(new Array("",""));
                                         set_combo('formulario.cbPeriodoEvaluacionHasta',aCombo, []);                                    
                                         set_combo('formulario.cbPeriodoCalificacion',aCombo, []);
                                         set_combo('formulario.cbPeriodoPremiacion',aCombo, []);
              }
           }
     }

          return;
  }

  
  var vArrayEvH = armarArrayDTOPeriodoMayor('cbEvH');
  //alert("cbEvH: "+vArrayEvH);
  
  recargaCombo("formulario.cbPeriodoEvaluacionHasta", 'COMObtenerPeriodosMayores', 'es.indra.sicc.dtos.cra.DTOPeriodo', vArrayEvH);

}


function onChangePeriodoHasta(){
  //alert("*** onChangePeriodoHasta");
  var valor = get("formulario.cbPeriodoEvaluacionHasta");
  
  if(valor=="") {    
          var objArr = document.all['cbPeriodoCalificacion'];
    for(var i=0; i < objArr.length; i++){
              if(objArr[i].tagName && objArr[i].tagName.toUpperCase()=="SELECT"){
                         if (!objArr[i].disabled) {
                                    var aCombo = new Array(new Array("",""));
                                         set_combo('formulario.cbPeriodoCalificacion',aCombo, []);
                                         set_combo('formulario.cbPeriodoPremiacion',aCombo, []);
              }
           }
     }

          return;
  }

  
  var vArrayEvH = armarArrayDTOPeriodoMayor('cbCal');
  //alert("cbCal: "+vArrayEvH);
  
  recargaCombo("formulario.cbPeriodoCalificacion", 'COMObtenerPeriodosMayores', 'es.indra.sicc.dtos.cra.DTOPeriodo', vArrayEvH);
}

function onChangePeriodoCalificacion(){
  //alert("*** onChangePeriodoCalificacion");
  var valor = get("formulario.cbPeriodoCalificacion");
  
  if(valor=="") {    
          var objArr = document.all['cbPeriodoPremiacion'];
    for(var i=0; i < objArr.length; i++){
              if(objArr[i].tagName && objArr[i].tagName.toUpperCase()=="SELECT"){
                         if (!objArr[i].disabled) {
                                    var aCombo = new Array(new Array("",""));
                                         set_combo('formulario.cbPeriodoPremiacion',aCombo, []);                                 
              }
           }
     }

          return;
  }

  
  var vArrayEvH = armarArrayDTOPeriodoMayor('cbPrem');
  //alert("cbPrem: "+vArrayEvH);
  
  recargaCombo("formulario.cbPeriodoPremiacion", 'COMObtenerPeriodosMayores', 'es.indra.sicc.dtos.cra.DTOPeriodo', vArrayEvH);

}

//Autor: Marcelo J. Maidana
//Fecha: 21/06/2005
function cargarPeriodos(inicializa){
    
    var vArray = armarArrayDTOPeriodo();

    if (get('formulario.cbMarca')[0] != '' && get('formulario.cbCanal')[0] != ''){
           recargaCombo( 'formulario.cbPeriodoEvaluacionDesde', 'CRAObtienePeriodos',
                'es.indra.sicc.dtos.cra.DTOPeriodo', vArray, 'asignarPeriodos(datos)');
                     
    } else {
           set_combo('formulario.cbPeriodoEvaluacionDesde', arrayVacio());
           set_combo('formulario.cbPeriodoEvaluacionHasta', arrayVacio());
           set_combo('formulario.cbPeriodoCalificacion', arrayVacio());
           set_combo('formulario.cbPeriodoPremiacion', arrayVacio());
    }
    
    if(inicializa== "S") {
           // Limpia todas las pestañas de concurso ranking
           set('formulario.conectorAction', 'LPMantenerConcursosRanking');
           set('formulario.accion', 'Inicializar pestanias');
           eval('formulario').oculto = 'S';
           enviaSICC('formulario', null, null, 'N');
    }
}

/*function marcaComboPeriodoHasta(datos) {
          var datosNuevo = new Array();
          datosNuevo[0] = ["",""];

          for (var i = 0; i < datos.length; i++ )
                    datosNuevo[i+1]  = datos[i];

          set_combo("formulario.cbPeriodoHasta", datosNuevo);
          var sOidPeriodoHasta = get("formulario.sOidPeriodoHasta");
          var periodoSeleccionado = new Array();
          periodoSeleccionado = sOidPeriodoHasta.split(",");        
          set("formulario.cbPeriodoHasta", periodoSeleccionado)
}*/

function asignarPeriodos(datos){

    if (get('formulario.hPeriodoEvaluacionDesde') != ''){
           set_combo('formulario.cbPeriodoEvaluacionDesde', agregarVacio(datos), new Array(get('formulario.hPeriodoEvaluacionDesde')));
    } else {
           set_combo('formulario.cbPeriodoEvaluacionDesde', agregarVacio(datos));
    }
          
          recargaComboPeriodoHasta();
//                 recargaComboPeriodoCali();
//                 recargaComboPeriodoPrem();
}



//Autor: Marcelo J. Maidana
//Fecha: 27/06/2005
function agregarVacio(lista){
    var array = new Array();
    array[0] = new Array('', '');
    
    if (lista != null && lista.length > 0){
           for (var i = 0; i < lista.length; i++){
                array[i + 1] = lista[i];
           }
    }
    
    return array;
}


//Autor: Marcelo J. Maidana
//Fecha: 21/06/2005
function cargarAccesos(){
    var canal = get('formulario.cbCanal')[0];
    var idioma = get('formulario.hIdioma');

    if (canal != null && canal != ''){
           var array = new Array();
           var pos = new Array('oid', canal);
           array[0] = pos;
           pos = new Array('oidIdioma', idioma);
           array[1] = pos;
    
           recargaCombo( 'formulario.cbAcceso', 'SEGObtieneAccesosPorCanal',
                'es.indra.sicc.util.DTOOID', array, 'posicionarAccesos(datos)');
                
    } else {
           set_combo('formulario.cbAcceso', arrayVacio());
    }
    
}

//Autor: Marcelo J. Maidana
//Fecha: 29/06/2005
function posicionarAccesos(datos){
    if (get('formulario.hLstAccesos') != ''){
          // alert("datos: " + datos);
          // alert(get('formulario.hLstAccesos'));
           set_combo('formulario.cbAcceso', agregarVacio(datos));
           set('formulario.cbAcceso', get('formulario.hLstAccesos').split(','));
    } else {
           set_combo('formulario.cbAcceso', agregarVacio(datos));
    }
}

//Autor: Marcelo J. Maidana
//Fecha: 21/06/2005
function onChangeDirigidoA(){
    var dirigidoA = get('formulario.cbConcursoDirigidoA')[0];
    var dirigidoAConsultora = get('formulario.OID_DIRIGO_A_CONSULTORA');    
    var dirigidoAGerente = get('formulario.OID_DIRIGIDO_A_GERENTE');

    
    if (get('formulario.hConcursoDirigidoA') != ''){
    // alert('ac ' +  get('formulario.hConcursoDirigidoA'));
    
    
           if (dirigidoA == dirigidoAConsultora){
                if (GestionarMensaje('1569')){
                      set('formulario.hIndEstadoParametrosGerentes', 'N');
                      set('formulario.hIndEstadoParametrosConsultoras', 'S');
                      set('formulario.hIndEstadoVariablesVenta', 'N');
                      set('formulario.hConcursoDirigidoA', get('formulario.cbConcursoDirigidoA')[0]);
                      
                     
                } else {
                      set('formulario.cbConcursoDirigidoA', new Array(get('formulario.hConcursoDirigidoA')));
                      return;
                }
           } else if (dirigidoA == dirigidoAGerente){
                if (GestionarMensaje('1570')){
                      set('formulario.hIndEstadoParametrosGerentes', 'S');
                      set('formulario.hIndEstadoParametrosConsultoras', 'N');
                      set('formulario.hIndEstadoVariablesVenta', 'N');
                      set('formulario.hConcursoDirigidoA', get('formulario.cbConcursoDirigidoA')[0]);
                } else {
                      set('formulario.cbConcursoDirigidoA', new Array(get('formulario.hConcursoDirigidoA')));
                      return;
                }
           } else {
                if (GestionarMensaje('1571')){
                      set('formulario.hIndEstadoParametrosGerentes', 'N');
                      set('formulario.hIndEstadoParametrosConsultoras', 'N');
                      set('formulario.hIndEstadoVariablesVenta', 'N');
                      set('formulario.hConcursoDirigidoA', get('formulario.cbConcursoDirigidoA')[0]);
                } else {
                      set('formulario.cbConcursoDirigidoA', new Array(get('formulario.hConcursoDirigidoA')));
                      return;
                }
           }
    } else {
           set('formulario.hConcursoDirigidoA', get('formulario.cbConcursoDirigidoA')[0]);
    }
    
    //llamar a la LPMantenerConcursosRanking con accion="Inicializar Participantes"
    set('formulario.conectorAction', 'LPMantenerConcursosRanking');
    set('formulario.accion', 'Inicializar Participantes');
           set('formulario.hConcursoDirigidoA', dirigidoA);
           eval('formulario').oculto = 'S';
           enviaSICC('formulario', null, null, 'N');
}


//Autor: Viviana Bongiovanni
//Fecha: 27/06/2005
function inicializarParticipantes(dirigidoA){
           var dirigidoAConsultora = get('formulario.OID_DIRIGO_A_CONSULTORA');
    var dirigidoAGerente = get('formulario.OID_DIRIGIDO_A_GERENTE');
    
           if (dirigidoA == dirigidoAConsultora){
           set('formulario.hIndEstadoParametrosGerentes', 'N');
           set('formulario.hIndEstadoParametrosConsultoras', 'S');
           set('formulario.hIndEstadoVariablesVenta', 'N');
    } else if (dirigidoA == dirigidoAGerente){
           set('formulario.hIndEstadoParametrosGerentes', 'S');
           set('formulario.hIndEstadoParametrosConsultoras', 'N');
           set('formulario.hIndEstadoVariablesVenta', 'N');
    } else {
           set('formulario.hIndEstadoParametrosGerentes', 'N');
           set('formulario.hIndEstadoParametrosConsultoras', 'N');
           set('formulario.hIndEstadoVariablesVenta', 'N');
    }
    
    if(get('formulario.opcionMenu')=="Modificar Concurso Ranking"){  
             btnProxy(1,1);
             btnProxy(2,1);
             btnProxy(3,0);
             btnProxy(4,0);
             btnProxy(5,1);
             btnProxy(7,0);
             btnProxy(8,0);
             btnProxy(9,0);
             
             focaliza('formulario.cbConcursoDirigidoA','');
             
      } else {
             focaliza('formulario.cbConcursoDirigidoA','');
      }
}



//Autor: Marcelo J. Maidana
//Fecha: 21/06/2005
function armarArrayDTOPeriodo(){
    var pais = get('formulario.hPais');
             var marca = get('formulario.cbMarca');
             var canal = get('formulario.cbCanal');   
    var periodoDesde = get('formulario.hOidPeriodoDesde');
             var array = new Array();
             var index = 0;

           if( pais != null && pais != '' ){
                      array[index] = new Array('pais', pais);
    index++;
           }      

           if( marca != null && marca[0] != null && marca[0] != '' ){
                      array[index] = new Array('marca', marca[0]);
                      index++;
           }

           if( canal != null && canal[0] != null && canal[0] != '' ){
                      array[index] = new Array('canal', canal[0]);
                      index++;
           }

           return array;
}

//Cleal 21864
function armarArrayDTOPeriodoMayor(cb){
    var pais = get('formulario.hPais');
    var marca = get('formulario.cbMarca');
    var canal = get('formulario.cbCanal');   
    var periodo = '';
    var array = new Array();
    var index = 0;
            //alert("***cb: "+cb);
            if (cb=='cbEvH'){
                      periodo = get('formulario.cbPeriodoEvaluacionDesde');
                      //alert("PeriodoDesde: "+periodo);
            } else if (cb=='cbCal'){
                      periodo = get('formulario.cbPeriodoEvaluacionHasta');
                      //alert("PeriodoEvaluacionHasta: "+periodo);
            } else if (cb=='cbPrem'){
                      periodo = get('formulario.cbPeriodoCalificacion');
                      //alert("PeriodoCalificacion: "+periodo);
            }

          if( pais != null && pais != '' ){
                    array[index] = new Array('oidPais', pais);
    index++;
          }      

          if( marca != null && marca[0] != null && marca[0] != '' ){
                    array[index] = new Array('marca', marca[0]);
                    index++;
          }

          if( canal != null && canal[0] != null && canal[0] != '' ){
                    array[index] = new Array('canal', canal[0]);
                    index++;
          }

          if( periodo != null && periodo[0] != null && periodo[0] != '' ){
                    array[index] = new Array('oid', periodo[0]);
                    index++;
          }

          return array;
}


//Autor: Marcelo J. Maidana
//Fecha: 23/06/2005 -   Creado
function guardarKO(){
    if(get('formulario.opcionMenu')=="Modificar Concurso Ranking"){  
             btnProxy(1,1);
             btnProxy(2,1);
             btnProxy(3,0);
             btnProxy(4,0);
             btnProxy(5,1);
             btnProxy(7,0);
             btnProxy(8,0);
             btnProxy(9,0);
             
             focaliza('formulario.textNombreConcurso');
             
      } else {
             focaliza('formulario.textNombreConcurso');
      }
}

//Autor: Marcelo J. Maidana
//Fecha: 23/06/2005 -   Creado
function setTabFocus(campo){
    if (campo == 'textNombreConcurso'){
           focaliza('formulario.cbMarca');
    }
    
    if (campo == 'cbMarca'){
           focaliza('formulario.cbCanal');
    }
    
    if (campo == 'cbCanal'){
           focaliza('formulario.cbAcceso');
    }

    if (campo == 'cbAcceso'){
           focaliza('formulario.cbPeriodoEvaluacionDesde');
    }

    if (campo == 'cbPeriodoEvaluacionDesde'){
           focaliza('formulario.cbPeriodoEvaluacionHasta');
    }

    if (campo == 'cbPeriodoEvaluacionHasta'){
           focaliza('formulario.cbPeriodoCalificacion');
    }

    if (campo == 'cbPeriodoCalificacion'){
           focaliza('formulario.cbPeriodoPremiacion');
    }

    if (campo == 'cbPeriodoPremiacion'){
           focaliza('formulario.cbConcursoDirigidoA');
    }

    if (campo == 'cbConcursoDirigidoA'){
           focaliza('formulario.cbNivelAgrupamiento');
    }

    if (campo == 'cbNivelAgrupamiento'){
           focaliza('formulario.cbTipoRanking');
    }

    if (campo == 'cbTipoRanking'){
           focaliza('formulario.ckDevoluciones');
    }

    if (campo == 'ckDevoluciones'){
           focaliza('formulario.ckAnulaciones');
    }

    if (campo == 'ckAnulaciones'){
           focaliza('formulario.ckFaltantesNoAnunciados');
    }

    if (campo == 'ckFaltantesNoAnunciados'){
           focaliza('formulario.cbTipoExigencia');
    }

    if (campo == 'cbTipoExigencia'){
           focaliza('formulario.ckActivo');
    }

    if (campo == 'ckActivo'){
           focaliza('formulario.textObservaciones');
    }

    if (campo == 'textObservaciones'){
           focaliza('formulario.textNombreConcurso');
    }
}

//Autor: Marcelo J. Maidana
//Fecha: 23/06/2005 -   Creado
function setSHTabFocus(campo){
    if (campo == 'textNombreConcurso'){
           focaliza('formulario.textObservaciones');
    }

    if (campo == 'textObservaciones'){
           focaliza('formulario.ckActivo');
    }

    if (campo == 'ckActivo'){
           focaliza('formulario.cbTipoExigencia');
    }

    if (campo == 'cbTipoExigencia'){
           focaliza('formulario.ckFaltantesNoAnunciados');
    }

    if (campo == 'ckFaltantesNoAnunciados'){
           focaliza('formulario.ckAnulaciones');
    }

    if (campo == 'ckAnulaciones'){
           focaliza('formulario.ckDevoluciones');
    }

    if (campo == 'ckDevoluciones'){
           focaliza('formulario.cbTipoRanking');
    }

    if (campo == 'cbTipoRanking'){
           focaliza('formulario.cbNivelAgrupamiento');
    }

    if (campo == 'cbNivelAgrupamiento'){
           focaliza('formulario.cbConcursoDirigidoA');
    }

    if (campo == 'cbConcursoDirigidoA'){
           focaliza('formulario.cbPeriodoPremiacion');
    }

    if (campo == 'cbPeriodoPremiacion'){
           focaliza('formulario.cbPeriodoCalificacion');
    }

    if (campo == 'cbPeriodoCalificacion'){
           focaliza('formulario.cbPeriodoEvaluacionHasta');
    }

    if (campo == 'cbPeriodoEvaluacionHasta'){
           focaliza('formulario.cbPeriodoEvaluacionDesde');
    }

    if (campo == 'cbPeriodoEvaluacionDesde'){
           focaliza('formulario.cbAcceso');
    }

    if (campo == 'cbAcceso'){
           focaliza('formulario.cbCanal');
    }

    if (campo == 'cbCanal'){
           focaliza('formulario.cbMarca');
    }

    if (campo == 'cbMarca'){
           focaliza('formulario.textNombreConcurso');
    }
}

//Autor: Marcelo J. Maidana
//Fecha: 23/06/2005 - Creado.
function posicionarCombos(){
    if (get('formulario.hMarca') != ''){
           set('formulario.cbMarca', [get('formulario.hMarca')]);
           set('formulario.hMarcaSel', [get('formulario.hMarca')]);
    } else {
           set('formulario.hMarcaSel', '');
    }
     
    if (get('formulario.hCanal') != ''){
           set('formulario.cbCanal', [get('formulario.hCanal')]);
           set('formulario.hCanalSel', [get('formulario.hCanal')]);
    } else {
           set('formulario.hCanalSel', '');
    }

    if (get('formulario.hLstAccesos') != ''){
           set('formulario.cbAcceso', get('formulario.hLstAccesos').split(','));
    } 
  
    if (get('formulario.hPeriodoEvaluacionDesde') != ''){
           set('formulario.cbPeriodoEvaluacionDesde', [get('formulario.hPeriodoEvaluacionDesde')]);
    }
    
    if (get('formulario.hPeriodoEvaluacionHasta') != ''){
           set('formulario.cbPeriodoEvaluacionHasta', [get('formulario.hPeriodoEvaluacionHasta')]);
    }

    if (get('formulario.hPeriodoCalificacion') != ''){
           set('formulario.cbPeriodoCalificacion', [get('formulario.hPeriodoCalificacion')]);
    }

    if (get('formulario.hPeriodoPremiacion') != ''){
           set('formulario.cbPeriodoPremiacion', [get('formulario.hPeriodoPremiacion')]);
    }   
    
    if (get('formulario.hConcursoDirigidoA') != ''){
           
           set('formulario.cbConcursoDirigidoA', [get('formulario.hConcursoDirigidoA')]);
    }

    if (get('formulario.hNivelAgrupamiento') != ''){
           set('formulario.cbNivelAgrupamiento', [get('formulario.hNivelAgrupamiento')]);
    }
    
    if (get('formulario.hTipoRanking') != ''){
           set('formulario.cbTipoRanking', [get('formulario.hTipoRanking')]);
    }
    
    if (get('formulario.hTipoExigencia') != ''){
           set('formulario.cbTipoExigencia', [get('formulario.hTipoExigencia')]);
    }

}

//Autor: Marcelo J. Maidana
//Fecha: 23/06/2005 - Creado.
function asignarChecks(){

    var devoluciones = get('formulario.hDevoluciones');
    var anulaciones = get('formulario.hAnulaciones');
    var faltantes = get('formulario.hFaltantesNoAnunciados');
    var activo = get('formulario.hActivo');

           if(devoluciones == 'S'){
           set('formulario.ckDevoluciones', 'S');
           }else{
           set('formulario.ckDevoluciones', 'N');
           }

           if(anulaciones == 'S'){
           set('formulario.ckAnulaciones', 'S');
           }else{
           set('formulario.ckAnulaciones', 'N');
           }

           if(faltantes == 'S'){
           set('formulario.ckFaltantesNoAnunciados', 'S');
           }else{
           set('formulario.ckFaltantesNoAnunciados', 'N');
           }

           if(activo == 'S'){
           set('formulario.ckActivo', 'S');
           }else{
           set('formulario.ckActivo', 'N');
           }
}

function fVolver(){
      window.close();
}

//Autor: Marcelo J. Maidana
//Fecha: 30/06/2005 - Creado.
function fLimpiar(){
    if (GestionarMensaje('1572')){
           if(get('formulario.opcionMenu')=="Modificar Concurso Ranking"){  
                set('formulario.conectorAction', 'LPMantenerConcursosRanking');
                set('formulario.accion', 'limpiar');
                eval('formulario').oculto = 'N';
                enviaSICC('formulario', null, null, 'N');
           } else {
           set('formulario.hConcursoDirigidoA', get('formulario.cbConcursoDirigidoA')[0]);
                // Limpia los campos
                set('formulario.textNombreConcurso', '');
                set('formulario.cbMarca', '');
                set('formulario.hMarcaSel', '');
                set('formulario.cbCanal', '');
                set('formulario.hCanalSel', '');
                set_combo('formulario.cbAcceso', arrayVacio());
                set('formulario.cbAcceso', '');
                set('formulario.hLstAccesos', '');
                set_combo('formulario.cbPeriodoEvaluacionDesde', arrayVacio());
                set_combo('formulario.cbPeriodoEvaluacionHasta', arrayVacio());
                set_combo('formulario.cbPeriodoCalificacion', arrayVacio());
                set_combo('formulario.cbPeriodoPremiacion', arrayVacio());
                set('formulario.cbPeriodoEvaluacionDesde', '');
                set('formulario.cbPeriodoEvaluacionHasta', '');
                set('formulario.cbPeriodoCalificacion', '');
                set('formulario.cbPeriodoPremiacion', '');
                set('formulario.hPeriodoEvaluacionDesde', '');
                set('formulario.hPeriodoEvaluacionHasta', '');
                set('formulario.hPeriodoCalificacion', '');
                set('formulario.hPeriodoPremiacion', '');
                set('formulario.cbConcursoDirigidoA', '');
                set('formulario.hConcursoDirigidoA', '');
                set('formulario.cbNivelAgrupamiento', '');
                set('formulario.cbTipoRanking', '');
                set('formulario.ckDevoluciones', 'S');
                set('formulario.ckAnulaciones', 'S');
                set('formulario.ckFaltantesNoAnunciados', 'S');
                set('formulario.cbTipoExigencia', get('formulario.OID_TIPO_EXIGENCIA_ACTIVIDAD'));
                set('formulario.hTipoExigencia', get('formulario.OID_TIPO_EXIGENCIA_ACTIVIDAD'));
                set('formulario.ckActivo', 'N');
                set('formulario.textObservaciones', '');

                set('formulario.hIndEstadoParametrosGerentes', 'N');
                set('formulario.hIndEstadoParametrosConsultoras', 'N');
                set('formulario.hIndEstadoVariablesVenta', 'N');
              
                set('formulario.conectorAction', 'LPMantenerConcursosRanking');
                set('formulario.accion', 'limpiar');
                eval('formulario').oculto = 'S';
                enviaSICC('formulario', null, null, 'N');
           }
    }
}

function arrayVacio(){  
    var array = new Array();                    
            array[0] = new Array('','');
    
    return array;
}


function deshabilitaCampos(){
    accion("formulario.textNombreConcurso", ".disabled=true");
    accion("formulario.cbMarca", ".disabled=true");
    accion("formulario.cbCanal", ".disabled=true");
    accion("formulario.cbAcceso", ".disabled=true");
    accion("formulario.cbPeriodoEvaluacionDesde", ".disabled=true");
    accion("formulario.cbPeriodoEvaluacionHasta", ".disabled=true");
    accion("formulario.cbPeriodoCalificacion", ".disabled=true");
    accion("formulario.cbPeriodoPremiacion", ".disabled=true");
    accion("formulario.cbConcursoDirigidoA", ".disabled=true");
    accion("formulario.cbNivelAgrupamiento", ".disabled=true");
    accion("formulario.cbTipoRanking", ".disabled=true");
    accion("formulario.ckDevoluciones", ".disabled=true");
    accion("formulario.ckAnulaciones", ".disabled=true");
    accion("formulario.ckFaltantesNoAnunciados", ".disabled=true");
    accion("formulario.cbTipoExigencia", ".disabled=true");
    accion("formulario.ckActivo", ".disabled=true");
    accion("formulario.textObservaciones", ".disabled=true");
}

