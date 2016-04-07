/*
    INDRA/CAR/PROY
    $Id: js_actividades_referenciadas_repetitivas.js,v 1.1 2009/12/03 19:01:43 pecbazalar Exp $
    DESC
*/

         function doInitPagina(){
         /*
                  Separador de Actividades 		"|||||" 
                  ------------------------
         
                  Controles							
                  ----------------------
                           Separeador						"]]]]]"
                           
                           Orden
                                    Codigo Actividad
                                    TXTFECHAINICIO
                                    TXTPERIODICIDAD
                                    CHKANADIR
                                    TXTDESPLAZAMIENTO
                                    CHKUPDATE
                           
                           
                  Cajas de texto
                  ----------------------
                           Separador 						"+++++"
                           TXTFECHAINICIO
                           TXTPERIODICIDAD
         */		
         
                  //cargarBarra("barra_seleccion_actividades_referenciadas_repetitivas");

				  configurarMenuSecundario("frmSeleccionRepetitivaActividad");
                  /*
                  Deshabilito todos los controles de las pantallas, salvo los 
                  checkboxes de Actualizar. Cuando éstos se chequeen, se habilitaran los demas 
                  controles referidos a ésa actividad.
                  */
                  fDeshabilitarControles();
         
                  ShowError();
         }

         function fEnableDisableActividades( pCodigoActividad ){
                  
                  var sChk = "chkUpd" + pCodigoActividad ;
                  var multi = get('frmSeleccionRepetitivaActividad.hidMulti');

                  if ( get("frmSeleccionRepetitivaActividad." + sChk) == "S" ){
                           accion("frmSeleccionRepetitivaActividad.txtOffSet" + pCodigoActividad ,".disabled=false");
                           if (multi == '1') { 
                                    accion("frmSeleccionRepetitivaActividad.chkRepet" + pCodigoActividad ,".disabled=false");
                                    cdosFC("frmSeleccionRepetitivaActividad.chkRepet" + pCodigoActividad);
                           }
                  } else {
                           //accion("frmSeleccionRepetitivaActividad.chkRepet" + pCodigoActividad ,".disabled=true");
                           
                           set("frmSeleccionRepetitivaActividad.txtperio"  + pCodigoActividad,"");
                           set("frmSeleccionRepetitivaActividad.txtFechaIni"  + pCodigoActividad,"");
                           set("frmSeleccionRepetitivaActividad.txtOffSet" + pCodigoActividad ,"");
                           set("frmSeleccionRepetitivaActividad.chkRepet" + pCodigoActividad ,"N");


                           accion("frmSeleccionRepetitivaActividad.chkRepet"  + pCodigoActividad,".disabled=true");
                           accion("frmSeleccionRepetitivaActividad.txtperio"  + pCodigoActividad,".disabled=true");
                           accion("frmSeleccionRepetitivaActividad.txtFechaIni"  + pCodigoActividad,".disabled=true");
                           accion("frmSeleccionRepetitivaActividad.txtOffSet" + pCodigoActividad ,".disabled=true");	

/*
                           if (multi == '1') { 
                                    accion("frmSeleccionRepetitivaActividad.chkRepet" + pCodigoActividad ,".disabled=false");
                                    cdosFC("frmSeleccionRepetitivaActividad.chkRepet" + pCodigoActividad);
                           }
*/
                  }		
                  
         }

         function fEnableDisableTextBoxes(pNombreChk , pNombreControl ){
                  if ( get("frmSeleccionRepetitivaActividad." + pNombreChk) == "S") {
                           accion("frmSeleccionRepetitivaActividad." + pNombreControl,".disabled=false");
                           //cdosFC("frmSeleccionRepetitivaActividad." + pNombreControl);
                  }
                  else{
                           accion("frmSeleccionRepetitivaActividad." + pNombreControl,".disabled=true");
                           set("frmSeleccionRepetitivaActividad." + pNombreControl,"");
                  }
         }

         function fDeshabilitarControles(){
                  try {
                           var strActividades= new String( get("frmSeleccionRepetitivaActividad.hidActividades") );
                           var sArray = strActividades.split("|+|+|+|") ; //La cadena del split está definida en la LP.
                           var sCodigo = "";
                           var bFocalizarPrimero = true;
                           
                           for( var i = 0; i < sArray.length ; i++ ){
                                    var sCodigo = sArray[i];
                                    //Esto es para focalizar el primer checkbox
                                    if ( bFocalizarPrimero ){
                                             cdosFC("frmSeleccionRepetitivaActividad.chkUpd" + sCodigo );
                                             bFocalizarPrimero = false;
                                    }

                                    sCodigo = sArray[i];
                                    accion("frmSeleccionRepetitivaActividad.chkRepet" + sCodigo ,".disabled=true");
                                    accion("frmSeleccionRepetitivaActividad.txtperio"  + sCodigo,".disabled=true");
                                    accion("frmSeleccionRepetitivaActividad.txtFechaIni"  + sCodigo,".disabled=true");
                                    accion("frmSeleccionRepetitivaActividad.txtOffSet" + sCodigo ,".disabled=true");		
                           }
                  }
                  catch(e){
                  }
         
         }
         function fLimpiar(){ 
                  
                  fDeshabilitarControles();
                  
                  var strActividades= new String( get("frmSeleccionRepetitivaActividad.hidActividades") );
                  var sArray = strActividades.split("|+|+|+|") ; //La cadena del split está definida en la LP.
                  var bAlgunaSeleccionada = false;

                  try{
                           for( var i = 0; i < sArray.length ; i++ ){
                                    
                                    var sCodigo = sArray[i];
                                    
                                    set("frmSeleccionRepetitivaActividad.chkUpd" + sCodigo,"N");
                                    set("frmSeleccionRepetitivaActividad.chkRepet" + sCodigo,"N");
                                    set("frmSeleccionRepetitivaActividad.txtperio" + sCodigo,"");
                                    set("frmSeleccionRepetitivaActividad.txtFechaIni" + sCodigo,"");
                                    set("frmSeleccionRepetitivaActividad.txtOffSet" + sCodigo,"");
         
                           }		
                  }
                  catch( e ){
                  }		
         }


         function ShowError(){
                  if (get('frmSeleccionRepetitivaActividad.errDescripcion')!='')
                  {
                           var wnd = fMostrarMensajeError(get('frmSeleccionRepetitivaActividad.errCodigo'), 
                                    get('frmSeleccionRepetitivaActividad.errDescripcion'));
                           if (wnd != 0)
                                    cancelar();
                  }	
         } 

         function cancelar(){
                  set('frmSeleccionRepetitivaActividad.accion','');
                  set('frmSeleccionRepetitivaActividad.conectorAction','LPAniadirActividadesModoGrafico');
                  envia('frmSeleccionRepetitivaActividad');
         }

         function fValidar(){
                  var strActividades= new String( get("frmSeleccionRepetitivaActividad.hidActividades") );
                  var sArray = strActividades.split("|+|+|+|") ; //La cadena del split está definida en la LP.
                  var bAlgunaSeleccionada = false;
                  
                  for( var i = 0; i < sArray.length ; i++ ){
                           
                           var sCodigo = sArray[i];
                           
                           if( get("frmSeleccionRepetitivaActividad.chkUpd" + sCodigo) == "S" ){
                                    
                                    //Si chequeo en repetitiva
                                    if ( cdos_trim( get("frmSeleccionRepetitivaActividad.txtperio" + sCodigo) ) != "" ){
                                             var vRet =fValidarNatural( get("frmSeleccionRepetitivaActividad.txtperio" + sCodigo), 3, 0, 999);
                                             if (vRet != "OK" ){
                                                      cdosFC("frmSeleccionRepetitivaActividad.txtperio" + sCodigo);
                                                      return false;
                                             }
                                    }
                                    
                                    if ( cdos_trim( get("frmSeleccionRepetitivaActividad.txtFechaIni" + sCodigo) ) != "" ){
                                             var vRet =fValidarNatural( get("frmSeleccionRepetitivaActividad.txtFechaIni" + sCodigo), 3, 0, 999);
                                             if (vRet != "OK" ){
                                                      cdosFC("frmSeleccionRepetitivaActividad.txtFechaIni" + sCodigo);
                                                      return false;
                                             }
                                    }				

                                    if ( cdos_trim( get("frmSeleccionRepetitivaActividad.txtOffSet" + sCodigo) ) != "" ){
                                             var vRet =fValidarNatural( get("frmSeleccionRepetitivaActividad.txtOffSet" + sCodigo), 3, 0, 999);
                                             if (vRet != "OK" ){
                                                      cdosFC("frmSeleccionRepetitivaActividad.txtOffSet" + sCodigo);
                                                      return false;
                                             }
                                    }
                                    
                                    bAlgunaSeleccionada = true;
                           }
                  }
                  
                  return true;
         }
                  
         
         function fGuardar(){
                  
                  if ( ! fValidar() ) {
                           return;
                  }
                  
                  var strActividades= new String( get("frmSeleccionRepetitivaActividad.hidActividades") );
                  var sArray = strActividades.split("|+|+|+|") ; //La cadena del split está definida en la LP.
                  var sCodigo = "";
                  var sAPostear = "";
                  var bPrimeraVez = true;
                  var bAlgunaSeleccionada = false;
                  var sTemp = "";
                  for( var i = 0; i < sArray.length ; i++ ){
                           sCodigo = sArray[i];
                           if( get("frmSeleccionRepetitivaActividad.chkUpd" + sCodigo) == "S" ){
                                    
                                    if ( !bPrimeraVez ){
                                             sAPostear += "------";//Separador de Actividades
                                    }
                                    bPrimeraVez = false;
                                    
                                    sAPostear += sCodigo + "+++++";
                                    sAPostear += get("frmSeleccionRepetitivaActividad.chkRepet" + sCodigo) + "+++++";
                                    
                                    sTemp = cdos_trim( get("frmSeleccionRepetitivaActividad.txtperio" + sCodigo) );
                                    if ( sTemp == "" ){
                                             sTemp = "0";
                                    }
                                    sAPostear += sTemp + "+++++";
                                    
                                    sTemp = cdos_trim( get("frmSeleccionRepetitivaActividad.txtFechaIni" + sCodigo) );
                                    if ( sTemp == "" ){
                                             sTemp = "0";
                                    }
                                    sAPostear += sTemp + "+++++";

                                    sTemp = cdos_trim( get("frmSeleccionRepetitivaActividad.txtOffSet" + sCodigo) );
                                    if ( sTemp == "" ){
                                             sTemp = "0";
                                    }
                                    sAPostear += sTemp;

                                    
                                    bAlgunaSeleccionada = true;
                           }
                  }	
/*                if(!bAlgunaSeleccionada){
                           cdos_mostrarAlert("Debe seleccionar alguna actividad");
                           return;
                  }
                  
*/                
                  
                  set("frmSeleccionRepetitivaActividad.hidActividadesSeleccionadas", sAPostear );
                  set("frmSeleccionRepetitivaActividad.conectorAction", "LPAniadirActividadesModoGrafico" );
                  set("frmSeleccionRepetitivaActividad.accion", "grabar" );
                  envia("frmSeleccionRepetitivaActividad" );

         }

         function cdosFC(componente) {
                  if (componente == null || componente == '') return;
                  try{
                           setTimeout('focaliza(\'' + componente + '\', \'\')', 100);
                  }
                  catch(e){
                  }
                  
         }
         
         function fPaginaVolver(){
         
         }


         function focoOnTabChkActualizar(pCodigoActividad) {
         /*
                  if (get("frmSeleccionRepetitivaActividad.chkUpd" + pCodigoActividad) = "N") {
                           focaliza("frmSeleccionRepetitivaActividad.chkUpd" + pCodigoActividad,"");
                  } else {
         */
                           try	{
                                    focaliza('frmSeleccionRepetitivaActividad.chkRepet' + pCodigoActividad,'');
                           } catch (e) {
                                    //focaliza("frmSeleccionRepetitivaActividad.txtOffSet" + pCodigoActividad,"");
                           }	
                  //}
         }

         function focoOnShTabChkActualizar(pCodigoActividad)  {
/*                if (get("frmSeleccionRepetitivaActividad.chkUpd" + pCodigoActividad) == "N")) {
                           focaliza("frmSeleccionRepetitivaActividad.chkUpd" + pCodigoActividad, "");
                  } else {*/
                  try{
                           focaliza('frmSeleccionRepetitivaActividad.txtOffSet' + pCodigoActividad,'');
                  }catch(e){}
         }

         function focoOnTabTxtDiasDesplazamiento(pCodigoActividad) {
                  try
                  {
                           focaliza('frmSeleccionRepetitivaActividad.chkUpd' + pCodigoActividad,'');
                  }
                  catch (e) {}

         }

// new

         function focoOnShTabTxtDiasDesplazamiento(pCodigoActividad) {

                  try	{
/*
                           if (get('frmSeleccionRepetitivaActividad.chkRepet' + pCodigoActividad) = 'N') {
                                    focaliza('frmSeleccionRepetitivaActividad.chkRepet' + pCodigoActividad,'');
                           } else {
*/
                                    focaliza('frmSeleccionRepetitivaActividad.txtFechaIni' + pCodigoActividad,'');
         //		}
                           
                  } catch (e) {
                           //focaliza('frmSeleccionRepetitivaActividad.chkUpd' + pCodigoActividad,'');
                  }
         }

         function focoOnTabChkRepetitiva(pCodigoActividad) {
                  /*
                  if(get('frmSeleccionRepetitivaActividad.chkRepet' + pCodigoActividad) = 'N') {
                           focaliza('frmSeleccionRepetitivaActividad.txtOffSet' + pCodigoActividad,'');
                  } else {
                           */
                           try  {
                           focaliza('frmSeleccionRepetitivaActividad.txtperio' + pCodigoActividad,'');
                           }
                           catch (e) { }

                  //}
         }

         function focoOnShTabChkRepetitiva(pCodigoActividad) {
                  try
                  {
                           focaliza('frmSeleccionRepetitivaActividad.chkUpd' + pCodigoActividad,'');
                  }
                  catch (e)
                  {
                  }
         }

         function focoOnTabTxtCadaCuantosDias(pCodigoActividad) {
                  try
                  {
                           focaliza('frmSeleccionRepetitivaActividad.txtFechaIni' + pCodigoActividad,'');
                  }
                  catch (e)
                  {
                  }

         }

         function focoOnShTabTxtCadaCuantosDias(pCodigoActividad) {
                  try
                  {
                           focaliza('frmSeleccionRepetitivaActividad.chkRepet' + pCodigoActividad,'');
                  }
                  catch (e)
                  {
                  }

         }

         function focoOnTabTxtCantidadDiasFin(pCodigoActividad) {
                  try
                  {
                           focaliza('frmSeleccionRepetitivaActividad.txtOffSet' + pCodigoActividad,'');
                  }
                  catch (e)
                  {
                  }
         }

         function focoOnShTabTxtCantidadDiasFin(pCodigoActividad) {
                  try
                  {
                           focaliza('frmSeleccionRepetitivaActividad.txtperio' + pCodigoActividad,'');
                  }
                  catch (e)
                  {
                  }
         }

