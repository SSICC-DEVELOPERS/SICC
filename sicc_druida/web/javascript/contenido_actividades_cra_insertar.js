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
/*

/*
    INDRA/CAR/PROY
    $Id: contenido_actividades_cra_insertar.js,v 1.1 2009/12/03 19:02:00 pecbazalar Exp $
    DESC
*/



function comboToStr(campo){
         var l=combo_get(campo,'L');
         var arrai=new Array();
         var datos='';
         for(var i=0;i<l;i++) {
                  datos += combo_get(campo,'V',i)+'|';
         }
         return datos;
}

function comboToStr_Asig(flag){
         //flag puede valer 'V' o 'T'
         var l=combo_get('frmInsertarActividades.cbProcAsig','L');
         var arrai=new Array();
         for(var i=0;i<l;i++) {
                  arrai[i]= combo_get('frmInsertarActividades.cbProcAsig',flag,i);
         }
         return arrai.toString();
}

function comboToStr_Disp(flag){
         //flag puede valer 'V' o 'T'
         var l=combo_get('frmInsertarActividades.cbProcDisp','L');
         var arrai=new Array();
         for(var i=0;i<l;i++) {
                  arrai[i]= combo_get('frmInsertarActividades.cbProcDisp',flag,i);
         }
         return arrai.toString();
}


function revisionActividadOrigen() {
         if(get('frmInsertarActividades.cboTpAct', 'T') == 'Fija'){
                  set('frmInsertarActividades.txtActRef','');
         }

}

function fGuardar(){
         var bandera = 'S';

         if(
                  fValidarCOMBO('frmInsertarActividades.cbPais') &&
                  fValidarCOMBO('frmInsertarActividades.cboMarcas') &&
                  fValidarCOMBO('frmInsertarActividades.cboCanales') &&
                  fValidarCTEXT('frmInsertarActividades.txtcdActividad') &&
                  fValidarCTEXT('frmInsertarActividades.txtdesActividad') &&		
                  fValidarCOMBO('frmInsertarActividades.cboTpAct')) {

                  if(get('frmInsertarActividades.cboTpAct', 'T') != 'Fija'){
                           if(!fValidarCTEXT('frmInsertarActividades.txtActRef')){
                                    bandera = 'N'
                           }
                    }
                    if (bandera=="S" && 
                             fValidarCTEXT('frmInsertarActividades.txtDias') &&
                             fValidarCOMBO('frmInsertarActividades.cboAreaResp')) {
                                    if(bandera == 'S'){

                                             set('frmInsertarActividades.hVProcAsig', comboToStr_Asig('V'));
                                             set('frmInsertarActividades.hTProcAsig', comboToStr_Asig('T'));
                                             set('frmInsertarActividades.hVProcDisp', comboToStr_Disp('V'));
                                             set('frmInsertarActividades.hTProcDisp', comboToStr_Disp('T'));
                                             
                                             set('frmInsertarActividades.hEbel', get('frmInsertarActividades.RebelNoticias'));
                                             set('frmInsertarActividades.hTipoDia', get('frmInsertarActividades.rbTipoDias'));

                                             //alert(get('frmInsertarActividades.hEbel'));
                                             //alert(get('frmInsertarActividades.hTipoDia'));

                                             set('frmInsertarActividades.hComboProc', comboToStr('frmInsertarActividades.cbProcAsig'));
                                             set('frmInsertarActividades.accion','guardar');

                                             if(get('frmInsertarActividades.hCasoDeUso')=='modificar'){
                                                      if (GestionarMensaje('938')){
                                                         set('frmInsertarActividades.conectorAction', 'LPModificarActividad');
                                                }
                                                      
                                             }
                                             else{

                                                      if (get('frmInsertarActividades.txtcdActividad') == get('frmInsertarActividades.txtActRef')) {
                                                                GestionarMensaje('945');
                                                                setTimeout("focaliza('frmInsertarActividades.txtActRef','')",100);
                                                                return;
                                                      }

                                                      set('frmInsertarActividades.conectorAction', 'LPInsertarActividadCRA');
                                             }
                                             enviaSICC('frmInsertarActividades');
                                    }
                    }
         }
}

function focalizaUltimo() {
         
         if (get('frmInsertarActividades.hCasoDeUso') != 'modificar') {
                  focaliza('frmInsertarActividades.cbPais');
         } else {
                  focaliza('frmInsertarActividades.txtdesActividad');
         }
}

function focalizaDesc() {
         if (get('frmInsertarActividades.hCasoDeUso') != 'modificar') {
                  focaliza('frmInsertarActividades.txtcdActividad');
         } else {
                  focaliza('frmInsertarActividades.cbProcDisp');
         }

}

//function limpiarCampos(){
	function fLimpiar(){

         //alert("CU " + get('frmInsertarActividades.hCasoDeUso'));
         if (get('frmInsertarActividades.hCasoDeUso') != 'modificar') {
                  focaliza('frmInsertarActividades.cbPais','');
                   
                  iSeleccionado = new Array(); 
                  iSeleccionado[0] =(get('frmInsertarActividades.hPaisOrigen'));
                  setTimeout( 'set(\'frmInsertarActividades.cbPais\',iSeleccionado)',100);
          
                  set('frmInsertarActividades.cboMarcas','');
                  set('frmInsertarActividades.cboCanales','');
                  set('frmInsertarActividades.txtcdActividad','');
                  set('frmInsertarActividades.txtdesActividad','');
                  set('frmInsertarActividades.cboTpAct','');
                  set('frmInsertarActividades.txtActRef','');
                  set('frmInsertarActividades.cboAreaResp','');
                  set('frmInsertarActividades.RebelNoticias','N');
                  set('frmInsertarActividades.txtDias','');
                  set_combo('frmInsertarActividades.cbProcAsig',new Array());
                  set_combo('frmInsertarActividades.cbProcDisp',new Array());
                  focaliza('frmInsertarActividades.cbPais','');
         } else {

                  iSeleccionado = new Array(); 
                  
                  //Nombre Actividad
                  set('frmInsertarActividades.txtdesActividad',get('frmInsertarActividades.hNomActi'));
                  
                  //Tipo Actividad
                  iSeleccionado[0] =(get('frmInsertarActividades.hTipoAct'));
                  set('frmInsertarActividades.cboTpAct',iSeleccionado);

                  if(get('frmInsertarActividades.cboTpAct', 'T') == 'Fija'){
                           accion('frmInsertarActividades.txtActRef','.disabled=true');
                  } else {
                           accion('frmInsertarActividades.txtActRef','.disabled=false');
                  }


                  //Actividad Origen
                  set('frmInsertarActividades.txtActRef',get('frmInsertarActividades.hCactCodActi'));
                           
                  //Tipo Dia
                  if (get('frmInsertarActividades.hTipoDia') == "L") {
                           set('frmInsertarActividades.rbTipoDias','L');
                  } else {
                           set('frmInsertarActividades.rbTipoDias','C');
                  }
                  
                  //Dias Desplazamiento
                  set('frmInsertarActividades.txtDias',get('frmInsertarActividades.hDiasDesp'));

                  //Ebel Noticia
                  if (get('frmInsertarActividades.hEbel') == "No") {
                           set('frmInsertarActividades.RebelNoticias','N');
                  } else {
                           set('frmInsertarActividades.RebelNoticias','S');
                  }
                  
                  //Area Responsable
                  iSeleccionado[0] =(get('frmInsertarActividades.hDpteCodDpto'));
                  set('frmInsertarActividades.cboAreaResp',iSeleccionado);


                  /*alert("hVProcAsig: " + get('frmInsertarActividades.hVProcAsig'));
                  alert("hTProcAsig: " + get('frmInsertarActividades.hTProcAsig'));
                  alert("hVProcDisp: " + get('frmInsertarActividades.hVProcDisp'));
                  alert("hTProcDisp: " + get('frmInsertarActividades.hTProcDisp'));		*/

                  

                  //Procesos Asignados

                  var i;
                  var strV = new String(get('frmInsertarActividades.hVProcAsig'));
                  var sArrayV ;
                  var sArrayT;
                  if(strV.length > 0 ){ //Esta pregunta se hace porque el SPLIT siempre devuelve un Array con la menos 1 elemento.
                  sArrayV = strV.split('|');
                  }else{
                           sArrayV = new Array();
                  }
                  var strT = new String(get('frmInsertarActividades.hTProcAsig'));
                  if(strT.length > 0 ){
                  sArrayT = strT.split('|');
                  }else{
                           sArrayT = new Array();
                  }
                  var sArray = new Array();


                  
                  for (i = 0; i < sArrayV.length; i++){
             var par = new Array();
                           par[0] = sArrayV[i];
                           par[1] = sArrayT[i];
                           sArray[i] = par;
                  }

                  set_combo('frmInsertarActividades.cbProcAsig',sArray);
                  
                  //Procesos Disponibles
                  
                  strV = new String(get('frmInsertarActividades.hVProcDisp'));
                  if(strV.length > 0 ){ //Esta pregunta se hace porque el SPLIT siempre devuelve un Array con la menos 1 elemento.
                  sArrayV = strV.split('|');
                  }else{
                           sArrayV = new Array();
                  }

                  strT = new String(get('frmInsertarActividades.hTProcDisp'));
                  if(strT.length > 0 ){
                  sArrayT = strT.split('|');
                  }else{
                           sArrayT = new Array();
                  }

                  sArray = new Array();
                  
                  for (i = 0; i < sArrayV.length; i++){
             var par = new Array();
                           par[0] = sArrayV[i];
                           par[1] = sArrayT[i];
                           sArray[i] = par;
                  }
                  set_combo('frmInsertarActividades.cbProcDisp',sArray);
                  
                  //focalizo en el primer campo editable
                  focaliza('frmInsertarActividades.txtdesActividad','');
         }
}

function inicializacion(){

         //alert("CU " + get('frmInsertarActividades.hCasoDeUso'));

		 configurarMenuSecundario("frmInsertarActividades");
         if(get('frmInsertarActividades.hCasoDeUso')=="modificar"){
                  //cargarBarra("barra_actividades_cra_modificar");
				 
                  txtcdActividad.disabled = true;
                  cbPais.disabled = true;
                  cboMarcas.disabled = true;
                  cboCanales.disabled = true;
                  
                  inicializacionRadioB();
                  inicializacionRadioTipoDia();

                  posicionarCombo();

                  var strV = '';
                  var strT = '';
         var i;
                  var longitud = combo_get('frmInsertarActividades.cbProcAsig','L');
         
                  if (longitud > 0) {
                           strV = combo_get('frmInsertarActividades.cbProcAsig','V',0);
                           strT = combo_get('frmInsertarActividades.cbProcAsig','T',0);
                  }
                  
         for( i = 1; i < longitud; i++) {
                  strV += '|' +
             combo_get('frmInsertarActividades.cbProcAsig','V',i);

                           strT += '|' +
             combo_get('frmInsertarActividades.cbProcAsig','T',i);
         }

           

                  set('frmInsertarActividades.hVProcAsig', strV);
                  set('frmInsertarActividades.hTProcAsig', strT);

                  strV = '';
                  strT = '';
         
                  longitud = combo_get('frmInsertarActividades.cbProcDisp','L');
         
                  if (longitud > 0) {
                           strV = combo_get('frmInsertarActividades.cbProcDisp','V',0);
                           strT = combo_get('frmInsertarActividades.cbProcDisp','T',0);
                  }
                  
         for( i = 1; i < longitud; i++) {
                  strV += '|' +
             combo_get('frmInsertarActividades.cbProcDisp','V',i);

                           strT += '|' +
             combo_get('frmInsertarActividades.cbProcDisp','T',i);
         }

                  set('frmInsertarActividades.hVProcDisp', strV);
                  set('frmInsertarActividades.hTProcDisp', strT);

                  focaliza('frmInsertarActividades.txtdesActividad','');
         }
         else{
                  //cargarBarra("barra_actividades_cra_insertar");
                  
                  var iSeleccionadoP = new Array();

                  iSeleccionadoP[0] = get('frmInsertarActividades.hPais');
                  
                  set('frmInsertarActividades.cbPais',iSeleccionadoP);
                  
                  //-----------------------------------------------------------------------------------------------------
                  iSeleccionado = new Array(); 
                  
                  //Nombre Actividad
                  set('frmInsertarActividades.txtcdActividad',get('frmInsertarActividades.hCodActi'));
                  
                  set('frmInsertarActividades.txtdesActividad',get('frmInsertarActividades.hNomActi'));
                  
                  //Tipo Actividad
                  iSeleccionado[0] =(get('frmInsertarActividades.hTipoAct'));
                  set('frmInsertarActividades.cboTpAct',iSeleccionado);

                  if(get('frmInsertarActividades.cboTpAct', 'T') == 'Fija'){
                           accion('frmInsertarActividades.txtActRef','.disabled=true');
                  } else {
                           accion('frmInsertarActividades.txtActRef','.disabled=false');
                  }


                  //Actividad Origen
                  set('frmInsertarActividades.txtActRef',get('frmInsertarActividades.hCactCodActi'));
                           
                  //Tipo Dia
                  if (get('frmInsertarActividades.hTipoDia') == "L") {
                           set('frmInsertarActividades.rbTipoDias','L');
                  } else {
                           set('frmInsertarActividades.rbTipoDias','C');
                  }
                  
                  //Dias Desplazamiento
                  set('frmInsertarActividades.txtDias',get('frmInsertarActividades.hDiasDesp'));

                  //Ebel Noticia
                  if (get('frmInsertarActividades.hEbel') == "No") {
                           set('frmInsertarActividades.RebelNoticias','N');
                  } else {
                           set('frmInsertarActividades.RebelNoticias','S');
                  }
                  

/*           //Estos dependen del canal por lo tanto no se puede mantener su valor al cambiar el canal.
                  //Area Responsable
                  iSeleccionado[0] =(get('frmInsertarActividades.hDpteCodDpto'));
                  set('frmInsertarActividades.cboAreaResp',iSeleccionado);


         

                  //Procesos Asignados

                  var i;
                  var strV = new String(get('frmInsertarActividades.hVProcAsig'));
                  var sArrayV ;
                  var sArrayT;
                  if(strV.length > 0 ){ //Esta pregunta se hace porque el SPLIT siempre devuelve un Array con la menos 1 elemento.
                  sArrayV = strV.split('|');
                  }else{
                           sArrayV = new Array();
                  }
                  var strT = new String(get('frmInsertarActividades.hTProcAsig'));
                  if(strT.length > 0 ){
                  sArrayT = strT.split('|');
                  }else{
                           sArrayT = new Array();
                  }
                  var sArray = new Array();


                  
                  for (i = 0; i < sArrayV.length; i++){
             var par = new Array();
                           par[0] = sArrayV[i];
                           par[1] = sArrayT[i];
                           sArray[i] = par;
                  }

                  set_combo('frmInsertarActividades.cbProcAsig',sArray);
                  
                  //Procesos Disponibles
                  
                  strV = new String(get('frmInsertarActividades.hVProcDisp'));
                  if(strV.length > 0 ){ //Esta pregunta se hace porque el SPLIT siempre devuelve un Array con la menos 1 elemento.
                  sArrayV = strV.split('|');
                  }else{
                           sArrayV = new Array();
                  }

                  strT = new String(get('frmInsertarActividades.hTProcDisp'));
                  if(strT.length > 0 ){
                  sArrayT = strT.split('|');
                  }else{
                           sArrayT = new Array();
                  }

                  sArray = new Array();
                  
                  for (i = 0; i < sArrayV.length; i++){
             var par = new Array();
                           par[0] = sArrayV[i];
                           par[1] = sArrayT[i];
                           sArray[i] = par;
                  }
                  set_combo('frmInsertarActividades.cbProcDisp',sArray);*/
                  //-----------------------------------------------------------------------------------------------------
                  //alert("canal:" + get('frmInsertarActividades.hCanales'));
                  if (get('frmInsertarActividades.hCanales') != "") {
                           focaliza('frmInsertarActividades.txtcdActividad');
                  } else {
                           focaliza('frmInsertarActividades.cbPais','');
                  }
         }
         accion('frmInsertarActividades.txtActRef','.disabled=true');
         accion('frmInsertarActividades.txtTodas','.disabled=true');
         accion('frmInsertarActividades.cboAreaResp','.disabled=true');
         //accion('frmInsertarActividades.cbProcDisp','.disabled=true');

         //accion('frmInsertarActividades.cbPais','.readonly=\'S\'');
         //accion('frmInsertarActividades.cboMarcas','.readonly=false');
         //accion('frmInsertarActividades.cboCanales','.readonly=false');
         
         //lalala
         //alert(get('frmInsertarActividades.hTipoAct'));

         if (get('frmInsertarActividades.hTipoAct')=='0'){
                  accion('frmInsertarActividades.txtActRef','.disabled=true');
         //	accion('frmInsertarActividades.txtDias','.disabled=true');
         } else {
                  accion('frmInsertarActividades.txtActRef','.disabled=false');
         //	accion('frmInsertarActividades.txtDias','.disabled=false');
         }

         mostrarCodigoError();
}                 

function inicializacionRadioB(){
         if(get('frmInsertarActividades.hEbel')=='N' || get('frmInsertarActividades.hEbel')=='' || get('frmInsertarActividades.hEbel')=='0'){
                  set('frmInsertarActividades.RebelNoticias', 'N');
         }
         else{
                  set('frmInsertarActividades.RebelNoticias', 'S');
         }
}

function inicializacionRadioTipoDia(){
         if(get('frmInsertarActividades.hTipoDia')=='L' || get('frmInsertarActividades.hTipoDia')=='' || get('frmInsertarActividades.hTipoDia')=='1'){
                  set('frmInsertarActividades.rbTipoDias', 'L');
         }
         else{
                  set('frmInsertarActividades.rbTipoDias', 'C');
         }
}

function enviarFormulario(){
         if(fValidarCOMBO('frmInsertarActividades.cbPais'))
         if(fValidarCOMBO('frmInsertarActividades.cboCanales'))
         if(fValidarCOMBO('frmInsertarActividades.cboMarcas'))
         enviaSICC('frmInsertarActividades');
}


function mostrarCodigoError(){
         var parametros = new Object();
         parametros.errCodigo = get('frmInsertarActividades.errCodigo');
         parametros.errDescripcion = get('frmInsertarActividades.errDescripcion');
           
         if (get('frmInsertarActividades.errDescripcion')!=''){
                  var wnd = fMostrarMensajeError(get('frmInsertarActividades.errCodigo'),get('frmInsertarActividades.errDescripcion'));
                  //////limpiarCombos();	
         /*	if (wnd == 0)
                           reintentar();
                  else
                           cancelar();
         */}		
} 

function limpiarCombos(){
         set("frmInsertarActividades.hPais", ""); 
         set("frmInsertarActividades.hCanales", ""); 
         set("frmInsertarActividades.hMarcas", ""); 
}

function posicionarCombo() {
         //alert ("posicionarCombo");

         var iSeleccionadoP = new Array();
         iSeleccionadoP[0] = get('frmInsertarActividades.hPais');
         set('frmInsertarActividades.cbPais',iSeleccionadoP);

         var iSeleccionadoM = new Array();
         iSeleccionadoM[0] = get('frmInsertarActividades.hMarcas');
         set('frmInsertarActividades.cboMarcas',iSeleccionadoM);

         var iSeleccionado = new Array();
         iSeleccionado[0] = get('frmInsertarActividades.hCanales');
         set('frmInsertarActividades.cboCanales',iSeleccionado);

         var iSeleccionado = new Array();
         iSeleccionado[0] = get('frmInsertarActividades.hTipoAct');
         set('frmInsertarActividades.cboTpAct',iSeleccionado);

         var iSeleccionado = new Array();
         iSeleccionado[0] = get('frmInsertarActividades.hDpteCodDpto');
         set('frmInsertarActividades.cboAreaResp',iSeleccionado);

         var iSeleccionadoDD = new Array();
         iSeleccionadoDD[0] = get('frmInsertarActividades.hDiasDesp');
         set('frmInsertarActividades.txtDias',iSeleccionadoDD);

         habilitarCampos();
}

function focalizaPrimero(){
         focaliza('frmInsertarActividades.cbPais','');
}

function ordenar(lista) {
         box = eval('document.'+lista);
         quickSort(box, 0, box.options.length - 1);
}

function quickSort(box, inicio, fin) {
         primero = inicio;
         ultimo = fin;
         if (primero >= ultimo) { 
                  return; 
         }
         textoMedio = box.options[parseInt(((primero + ultimo) / 2).toString())].text;
         while(primero < ultimo) 
         {
                  while(primero < ultimo && (comparar(box.options[primero].text, textoMedio) == -1)) 
                  {
                           primero++;
                  }
                  for(; primero < ultimo && (comparar(box.options[ultimo].text, textoMedio) == 1); ultimo--) { }
                  if(primero < ultimo)
                  {
                           opcionPrimero = crearOpcion(box, primero);
                           opcionUltimo = crearOpcion(box, ultimo);
                           box.options[primero] = opcionUltimo;
                           box.options[ultimo] = opcionPrimero;
                  }
         }
         if(ultimo < primero)
         {
                  aux = ultimo;
                  ultimo = primero;
                  primero = aux;
         }
         quickSort(box, inicio, primero);
         quickSort(box, primero != inicio ? primero : primero + 1, fin);
}

function traspasar(listaOrigen, listaDestino) {
         //alert("traspasar");
         var vecDestValue = get(listaDestino,'V');
         vectorValue = get(listaOrigen,'V');
         vectorDesc = get(listaOrigen,'T');
   //alert("Origen:" + listaOrigen.longitud);
   //alert("Destino:" + vecDestValue.length);
         for (var i=0; i <= vectorValue.length - 1; i++) {
                  if ((vectorValue[i] != null) && (vectorValue[i] != '')) {
                           del_combo(listaOrigen, 'V', vectorValue[i]);
                           combo_add(listaDestino, vectorValue[i], vectorDesc[i]);
                           //ordenar(listaDestino);
                  }
         }
}

function agregando(){
         traspasar('frmInsertarActividades.cbProcAsig', 'frmInsertarActividades.cbProcDisp');
}

function eliminando(){
         traspasar('frmInsertarActividades.cbProcDisp', 'frmInsertarActividades.cbProcAsig');
}

function canalSeleccionado() {
         //alert("afuera");

         if ((get('frmInsertarActividades.cbPais')!='')&& 
         (get('frmInsertarActividades.cboMarcas')!='')&&
         (get('frmInsertarActividades.cboCanales')!='')){
                   //alert("entro");
                  set('frmInsertarActividades.accion','canalSeleccionado');
                  enviaSICC('frmInsertarActividades');	   
         }   
}

function habilitarCampos() {
         //alert("afuera");

         if ((get('frmInsertarActividades.cbPais')!='')&& 
         (get('frmInsertarActividades.cboMarcas')!='')&&
         (get('frmInsertarActividades.cboCanales')!='')){
                   //alert("entro");
                   accion('frmInsertarActividades.cboAreaResp','.disabled=false');
                   //accion('frmInsertarActividades.cbProcDisp','.disabled=false');   
         }   
}

function deshabilitarActRef() {
         //alert(get('frmInsertarActividades.cboTpAct'));
         if (get('frmInsertarActividades.cboTpAct')=='0'){
                  accion('frmInsertarActividades.txtActRef','.disabled=true');
//                accion('frmInsertarActividades.txtDias','.disabled=true');
         } else {
                  accion('frmInsertarActividades.txtActRef','.disabled=false');
//                accion('frmInsertarActividades.txtDias','.disabled=false');
         }
}