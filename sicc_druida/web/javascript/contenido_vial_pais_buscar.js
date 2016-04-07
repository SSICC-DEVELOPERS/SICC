var varNoLimpiarSICC = true;
var valoresOrigScroll = false;

function inicializacion(){
   if(!fMostrarMensajeError()){

      DrdEnsanchaConMargenDcho('listaResultados',12);
      eval (ON_RSZ);  
      ocultarCapa();
             
      configurarMenuSecundario('frmDatos');
      setTimeout("focaliza(\'frmDatos.comboTipoVia\',\'\')", 100);

      if( get('frmDatos.accion')!='buscar' ){		  
         seleccionarUG(0);
      }else{
         posicionarCombo();
         moveTo( 'capaLista', 0, 399 );
         visibilidad('capaLista', 'V');
      }

      habilitarCampos();

		  if (document.all.tblDatlistaResultados) {
			   document.all.CpScrolllistaResultados.attachEvent ('onpropertychange', verificaResultado);
		  }

   }else  posicionarCombo();
}

function sacarScroll() {
	if(!valoresOrigScroll) {
		ocultar("CplistaResultados");
		ocultar("CpLin1listaResultados");
		ocultar("CpLin2listaResultados");
		ocultar("CpLin3listaResultados");
		ocultar("CpLin4listaResultados")   

		ocultar("capaEspacio");
		ocultar("ret1Div");
		ocultar("ava1Div");
		ocultar("primera1Div");
		ocultar("separaDiv");

		valoresOrigScroll = true;
	}
}

function ocultar (nombre)     { 
        var lacapa=document.all[nombre] 
        lacapa.viejo_top= lacapa.offsetTop ; 
        lacapa.style.top= -1000; 
} 

function mostrar (nombre)     { 
        var lacapa=document.all[nombre] 
        lacapa.style.top= lacapa.viejo_top; 
} 

function ponerScroll() {
	if(valoresOrigScroll){
		mostrar("CplistaResultados");
		mostrar("CpLin1listaResultados");
		mostrar("CpLin2listaResultados");
		mostrar("CpLin3listaResultados");
		mostrar("CpLin4listaResultados")   

		mostrar("capaEspacio");
		mostrar("ret1Div");
		mostrar("ava1Div");
		mostrar("primera1Div");
		mostrar("separaDiv");

		valoresOrigScroll = false;
	}
}


//Para ocultar y mostrar la lista si hay o no resultados
function verificaResultado() {
  if (event.propertyName == "innerHTML") {
	  //alert(listado1.datos.length);
	  if (listaResultados.datos.length > 0) {
		  if (document.all["CplistaResultados"].style.visibility == 'hidden')
			  mostrarCapa();
	  } else {
		  if (document.all["CplistaResultados"].style.visibility == '')
			  ocultarCapa();
	  }
  }
}


function habilitarCampos(){
   if( get('frmDatos.accion') == ''){
      comboUnidad1.disabled = false;

      //estos van a true
      comboUnidad2.disabled = true;
      comboUnidad3.disabled = true;
      comboUnidad4.disabled = true;
      comboUnidad5.disabled = true;
      comboUnidad6.disabled = true;
      comboUnidad7.disabled = true;
      comboUnidad8.disabled = true;
      comboUnidad9.disabled = true;

      //btnCrear.setTipo(0);
     //visibilidad('capaLista', 'O');
   }
}

// Se llama a esta funcion al seleccionar en un combo U G
function seleccionarUG(combo){
    //var combo=window.event.srcElement;
    //alert('Combo seleccionado ' + combo);
    //combo.name //nombre combo
    //combo.value //devuelve ultimo oid del combo seleccion
    //guardar en un hidden hUltimoOidUG
         //if ( get( 'frmDatos.comboUnidad1', 'T' ) == '' ){
		if (combo == 0) {
           //alert("combo 1");
           deshabilitarResto(1);
		   cargarCombo1();
         }else 
		if (combo == 1) {
           deshabilitarResto(2);
           if ( get( 'frmDatos.comboUnidad1', 'T' ) != '' ) 
			   cargarCombo2();
		   else
			   comboUnidad2.disabled = true;
         }else 
		if (combo == 2) {
             deshabilitarResto(3);
			if ( get( 'frmDatos.comboUnidad2', 'T' ) != '' )
				cargarCombo3();
			else
			   comboUnidad3.disabled = true;
         }
         else 

		if (combo == 3) {
           deshabilitarResto(4);
           if ( get( 'frmDatos.comboUnidad3', 'T' ) != '' ) 
			   cargarCombo4();
		   else
			   comboUnidad4.disabled = true;
         }
         else 

		if (combo == 4) {

           deshabilitarResto(5);
           if ( get( 'frmDatos.comboUnidad4', 'T' ) != '' ) 
			   cargarCombo5();
		   else
			   comboUnidad5.disabled = true;
         }
         else 

		if (combo == 5) {

           deshabilitarResto(6);
           if ( get( 'frmDatos.comboUnidad5', 'T' ) != '' ) 
			   cargarCombo6();
		   else
			   comboUnidad6.disabled = true;

         }
         else 

		if (combo == 6) {

           deshabilitarResto(7);
           if ( get( 'frmDatos.comboUnidad6', 'T' ) != '' ) 
			   cargarCombo7();
		   else
			   comboUnidad7.disabled = true;

         }
         else 

		if (combo == 7) {

           deshabilitarResto(8);
           if ( get( 'frmDatos.comboUnidad7', 'T' ) != '' ) 
			   cargarCombo8();
		   else
			   comboUnidad8.disabled = true;
         }
         else 

		if (combo == 8) {

           deshabilitarResto(9);
           if ( get( 'frmDatos.comboUnidad8', 'T' ) != '' ) 
			   cargarCombo9();
		   else
			   comboUnidad9.disabled = true;

         }

}

function deshabilitarResto(combo){
   var aCombo= new Array(new Array("",""));
   //alert('deshabilitarResto '  + combo);
   if(combo == 1){
      
      set_combo('frmDatos.comboUnidad1', aCombo);
	  set_combo('frmDatos.comboUnidad2', aCombo);
      set_combo('frmDatos.comboUnidad3', aCombo);
      set_combo('frmDatos.comboUnidad4', aCombo);
      set_combo('frmDatos.comboUnidad5', aCombo);
      set_combo('frmDatos.comboUnidad6', aCombo);
      set_combo('frmDatos.comboUnidad7', aCombo);
      set_combo('frmDatos.comboUnidad8', aCombo);
      set_combo('frmDatos.comboUnidad9', aCombo);

      comboUnidad1.disabled = false;
	  comboUnidad2.disabled = true;
      comboUnidad3.disabled = true;
      comboUnidad4.disabled = true;
      comboUnidad5.disabled = true;
      comboUnidad6.disabled = true;
      comboUnidad7.disabled = true;
      comboUnidad8.disabled = true;
      comboUnidad9.disabled = true;

   }else if(combo == 2){
      
      set_combo('frmDatos.comboUnidad2', aCombo);
	  set_combo('frmDatos.comboUnidad3', aCombo);
      set_combo('frmDatos.comboUnidad4', aCombo);
      set_combo('frmDatos.comboUnidad5', aCombo);
      set_combo('frmDatos.comboUnidad6', aCombo);
      set_combo('frmDatos.comboUnidad7', aCombo);
      set_combo('frmDatos.comboUnidad8', aCombo);
      set_combo('frmDatos.comboUnidad9', aCombo);
           
      comboUnidad2.disabled = false;
	  comboUnidad3.disabled = true;
      comboUnidad4.disabled = true;
      comboUnidad5.disabled = true;
      comboUnidad6.disabled = true;
      comboUnidad7.disabled = true;
      comboUnidad8.disabled = true;
      comboUnidad9.disabled = true;
	  
   }else if(combo == 3){

      set_combo('frmDatos.comboUnidad3', aCombo);
	  set_combo('frmDatos.comboUnidad4', aCombo);
      set_combo('frmDatos.comboUnidad5', aCombo);
      set_combo('frmDatos.comboUnidad6', aCombo);
      set_combo('frmDatos.comboUnidad7', aCombo);
      set_combo('frmDatos.comboUnidad8', aCombo);
      set_combo('frmDatos.comboUnidad9', aCombo);

      comboUnidad3.disabled = false;		 
      comboUnidad4.disabled = true;
      comboUnidad5.disabled = true;
      comboUnidad6.disabled = true;
      comboUnidad7.disabled = true;
      comboUnidad8.disabled = true;
      comboUnidad9.disabled = true;

   }else if(combo == 4){
       
       set_combo('frmDatos.comboUnidad4', aCombo);
       set_combo('frmDatos.comboUnidad5', aCombo);
       set_combo('frmDatos.comboUnidad6', aCombo);
       set_combo('frmDatos.comboUnidad7', aCombo);
       set_combo('frmDatos.comboUnidad8', aCombo);
       set_combo('frmDatos.comboUnidad9', aCombo);

	   comboUnidad4.disabled = false;			  
       comboUnidad5.disabled = true;
       comboUnidad6.disabled = true;
       comboUnidad7.disabled = true;
       comboUnidad8.disabled = true;
       comboUnidad9.disabled = true;

   }else if(combo == 5){
       
       set_combo('frmDatos.comboUnidad5', aCombo);
       set_combo('frmDatos.comboUnidad6', aCombo);
       set_combo('frmDatos.comboUnidad7', aCombo);
       set_combo('frmDatos.comboUnidad8', aCombo);
       set_combo('frmDatos.comboUnidad9', aCombo);
             
       comboUnidad5.disabled = false;
	   comboUnidad6.disabled = true;
       comboUnidad7.disabled = true;
       comboUnidad8.disabled = true;
       comboUnidad9.disabled = true;

   }else if(combo == 6){
       
       set_combo('frmDatos.comboUnidad6', aCombo);
       set_combo('frmDatos.comboUnidad7', aCombo);
       set_combo('frmDatos.comboUnidad8', aCombo);
       set_combo('frmDatos.comboUnidad9', aCombo);
             
       comboUnidad6.disabled = false;
	   comboUnidad7.disabled = true;
       comboUnidad8.disabled = true;
       comboUnidad9.disabled = true;

   }else if(combo == 7){

       set_combo('frmDatos.comboUnidad7', aCombo);  
       set_combo('frmDatos.comboUnidad8', aCombo);
       set_combo('frmDatos.comboUnidad9', aCombo);
   
       comboUnidad7.disabled = false;
	   comboUnidad8.disabled = true;
       comboUnidad9.disabled = true;

   }else if(combo == 8){

       set_combo('frmDatos.comboUnidad8', aCombo);
       set_combo('frmDatos.comboUnidad9', aCombo);
       comboUnidad8.disabled = false;
	   comboUnidad9.disabled = true;
   } else if(combo == 9){
       set_combo('frmDatos.comboUnidad9', aCombo);
	   comboUnidad9.disabled = false;
   }
}

function cargarCombo1(){
         var pais = get('frmDatos.hPais');
         var strParametros = 'ConectorConsultaUnidadesGeograficas| ?' + pais;
         asignar([['COMBO','frmDatos.comboUnidad1','ConectorDTZON','dtoSalida.resultado_ROWSET',strParametros]], '', '');
}

/*
function cargarCombo1( combo, idBusiness, dto, parametros ){
         //var pais = get('frmDatos.hPais');
         //var strParametros = 'ConectorConsultaUnidadesGeograficas| ?' + pais;
         
         //asignar([['COMBO','frmDatos.comboUnidad1','ConectorDTZON','dtoSalida.resultado_ROWSET',strParametros]], '', '');
    asignar([['COMBO', combo, 'ConectorDruidaTransactionQuery', 'dtoSalida.resultado_ROWSET',formarCadena(idBusiness, dto, parametros)]]);
}
*/

function cargarCombo2(){
         var pais = get('frmDatos.hPais');
         var strParametros = 'ConectorConsultaUnidadesGeograficas|' + get( 'frmDatos.comboUnidad1', 'V' ) + '?' + pais;
         //alert(strParametros);
         asignar([['COMBO','frmDatos.comboUnidad2','ConectorDTZON','dtoSalida.resultado_ROWSET',strParametros]], '', '');
}

function cargarCombo3(){
         var pais = get('frmDatos.hPais');
         var strParametros = 'ConectorConsultaUnidadesGeograficas|' + get( 'frmDatos.comboUnidad2', 'V' ) + '?' + pais;
         
         asignar([['COMBO','frmDatos.comboUnidad3','ConectorDTZON','dtoSalida.resultado_ROWSET',strParametros]], '', '');
}

function cargarCombo4(){
         var pais = get('frmDatos.hPais');
         var strParametros = 'ConectorConsultaUnidadesGeograficas|' + get( 'frmDatos.comboUnidad3', 'V' ) + '?' + pais;
         asignar([['COMBO','frmDatos.comboUnidad4','ConectorDTZON','dtoSalida.resultado_ROWSET',strParametros]], '', '');
}

function cargarCombo5(){
         var pais = get('frmDatos.hPais');
         var strParametros = 'ConectorConsultaUnidadesGeograficas|' + get( 'frmDatos.comboUnidad4', 'V' ) + '?' + pais;
         asignar([['COMBO','frmDatos.comboUnidad5','ConectorDTZON','dtoSalida.resultado_ROWSET',strParametros]], '', '');
}

function cargarCombo6(){
         var pais = get('frmDatos.hPais');
         var strParametros = 'ConectorConsultaUnidadesGeograficas|' + get( 'frmDatos.comboUnidad5', 'V' ) + '?' + pais;
         asignar([['COMBO','frmDatos.comboUnidad6','ConectorDTZON','dtoSalida.resultado_ROWSET',strParametros]], '', '');
}

function cargarCombo7(){
         var pais = get('frmDatos.hPais');
         var strParametros = 'ConectorConsultaUnidadesGeograficas|' + get( 'frmDatos.comboUnidad6', 'V' ) + '?' + pais;
         asignar([['COMBO','frmDatos.comboUnidad7','ConectorDTZON','dtoSalida.resultado_ROWSET',strParametros]], '', '');
}

function cargarCombo8(){
         var pais = get('frmDatos.hPais');
         var strParametros = 'ConectorConsultaUnidadesGeograficas|' + get( 'frmDatos.comboUnidad7', 'V' ) + '?' + pais;
         asignar([['COMBO','frmDatos.comboUnidad8','ConectorDTZON','dtoSalida.resultado_ROWSET',strParametros]], '', '');
}

function cargarCombo9(){
         var pais = get('frmDatos.hPais');
         var strParametros = 'ConectorConsultaUnidadesGeograficas|' + get( 'frmDatos.comboUnidad8', 'V' ) + '?' + pais;
         asignar([['COMBO','frmDatos.comboUnidad9','ConectorDTZON','dtoSalida.resultado_ROWSET',strParametros]], '', '');
}
    



function posicionarCombo() {
         var iComboTipoVia = new Array();
         iComboTipoVia[0] = get('frmDatos.hComboTipoVia');
         set('frmDatos.comboTipoVia',iComboTipoVia);
    
         if( get('frmDatos.hComboUnidad1') != '' ){
                  var iComboUnidad1 = new Array();
                  iComboUnidad1[0] = get('frmDatos.hComboUnidad1');
                  if( get( 'frmDatos.hContComboUnidad1' ) != '' ){
                           set_combo( 'frmDatos.comboUnidad1', eval(get( 'frmDatos.hContComboUnidad1' )), iComboUnidad1 );
                  }
         }
         else{
                  comboUnidad1.disabled = true;
         }

         if( get('frmDatos.hComboUnidad2') != '' ){
                  var iComboUnidad2 = new Array();
                  iComboUnidad2[0] = get('frmDatos.hComboUnidad2');
                  if( get( 'frmDatos.hContComboUnidad2' ) != '' ){
                           set_combo( 'frmDatos.comboUnidad2', eval(get( 'frmDatos.hContComboUnidad2' )), iComboUnidad2 );
                  }
         }
         else{
                  comboUnidad2.disabled = true;
         }

         if( get('frmDatos.hComboUnidad3') != '' ){
                  var iComboUnidad3 = new Array();
                  iComboUnidad3[0] = get('frmDatos.hComboUnidad3');
                  if( get( 'frmDatos.hContComboUnidad3' ) != '' ){
                           set_combo( 'frmDatos.comboUnidad3', eval(get( 'frmDatos.hContComboUnidad3' )), iComboUnidad3 );
                  }
         }
         else{
                  comboUnidad3.disabled = true;
         }

         if( get('frmDatos.hComboUnidad4') != '' ){
                  var iComboUnidad4 = new Array();
                  iComboUnidad4[0] = get('frmDatos.hComboUnidad4');
                  if( get( 'frmDatos.hContComboUnidad4' ) != '' ){
                           set_combo( 'frmDatos.comboUnidad4', eval(get( 'frmDatos.hContComboUnidad4' )), iComboUnidad4 );
                  }
         }
         else{
                  comboUnidad4.disabled = true;
         }

         if( get('frmDatos.hComboUnidad5') != '' ){
                  var iComboUnidad5 = new Array();
                  iComboUnidad5[0] = get('frmDatos.hComboUnidad5');
                  if( get( 'frmDatos.hContComboUnidad5' ) != '' ){
                           set_combo( 'frmDatos.comboUnidad5', eval(get( 'frmDatos.hContComboUnidad5' )), iComboUnidad5 );
                  }
         }
         else{
                  comboUnidad5.disabled = true;
         }

         if( get('frmDatos.hComboUnidad6') != '' ){
                  var iComboUnidad6 = new Array();
                  iComboUnidad6[0] = get('frmDatos.hComboUnidad6');
                  if( get( 'frmDatos.hContComboUnidad6' ) != '' ){
                           set_combo( 'frmDatos.comboUnidad6', eval(get( 'frmDatos.hContComboUnidad6' )), iComboUnidad6 );
                  }
         }
         else{
                  comboUnidad6.disabled = true;
         }

         if( get('frmDatos.hComboUnidad7') != '' ){
                  var iComboUnidad7 = new Array();
                  iComboUnidad7[0] = get('frmDatos.hComboUnidad7');
                  if( get( 'frmDatos.hContComboUnidad7' ) != '' ){
                           set_combo( 'frmDatos.comboUnidad7', eval(get( 'frmDatos.hContComboUnidad7' )), iComboUnidad7 );
                  }
         }
         else{
                  comboUnidad7.disabled = true;
         }

         if( get('frmDatos.hComboUnidad8') != '' ){
                  var iComboUnidad8 = new Array();
                  iComboUnidad8[0] = get('frmDatos.hComboUnidad8');
                  if( get( 'frmDatos.hContComboUnidad8' ) != '' ){
                           set_combo( 'frmDatos.comboUnidad8', eval(get( 'frmDatos.hContComboUnidad8' )), iComboUnidad8 );
                  }
         }
         else{
                  comboUnidad8.disabled = true;
         }

         if( get('frmDatos.hComboUnidad9') != '' ){
                  var iComboUnidad9 = new Array();
                  iComboUnidad9[0] = get('frmDatos.hComboUnidad9');
                  if( get( 'frmDatos.hContComboUnidad9' ) != '' ){
                           set_combo( 'frmDatos.comboUnidad9', eval(get( 'frmDatos.hContComboUnidad9' )), iComboUnidad9 );
                  }
         }
         else{
                  comboUnidad9.disabled = true;
         }

         var iTxtNombreVia = new Array();
         iTxtNombreVia[0] = get('frmDatos.hTxtNombreVia');
         set('frmDatos.txtNombreVia', get('frmDatos.hTxtNombreVia'));

         var iTxtNumero = new Array();
         iTxtNumero[0] = get('frmDatos.hTxtNumero');
         set('frmDatos.txtNumero', get('frmDatos.hTxtNumero'));
}

/*
function enviarFormulario() {
         if(	fValidarCOMBO('frmDatos.comboTipoVia')	&&
                  fValidarCTEXT('frmDatos.txtNombreVia')	&&
                  //  fValidarCTEXT('frmDatos.txtNumero')		  &&
                  fValidarCOMBO('frmDatos.comboUnidad1')	&&
                  fValidarCOMBO('frmDatos.comboUnidad2')	&&
                  fValidarCOMBO('frmDatos.comboUnidad3')) {

                  set('frmDatos.hComboTipoVia', get('frmDatos.comboTipoVia'));
                  set('frmDatos.hDescComboTipoVia', get('frmDatos.comboTipoVia', 'T'));
                  set('frmDatos.hTxtNombreVia', get('frmDatos.txtNombreVia'));
                  set('frmDatos.hTxtNumero', get('frmDatos.txtNumero'));
                  set('frmDatos.hComboUnidad1', get('frmDatos.comboUnidad1'));
                  set('frmDatos.hComboUnidad2', get('frmDatos.comboUnidad2'));
                  set('frmDatos.hComboUnidad3', get('frmDatos.comboUnidad3'));
                  set('frmDatos.hComboUnidad4', get('frmDatos.comboUnidad4'));
                  set('frmDatos.hComboUnidad5', get('frmDatos.comboUnidad5'));
                  set('frmDatos.hComboUnidad6', get('frmDatos.comboUnidad6'));
                  set('frmDatos.hComboUnidad7', get('frmDatos.comboUnidad7'));
                  set('frmDatos.hComboUnidad8', get('frmDatos.comboUnidad8'));
                  set('frmDatos.hComboUnidad9', get('frmDatos.comboUnidad9'));

                  guardarContCombos( 'frmDatos.comboUnidad1', 'frmDatos.hContComboUnidad1' );
                  guardarContCombos( 'frmDatos.comboUnidad2', 'frmDatos.hContComboUnidad2' );
                  guardarContCombos( 'frmDatos.comboUnidad3', 'frmDatos.hContComboUnidad3' );
                  guardarContCombos( 'frmDatos.comboUnidad4', 'frmDatos.hContComboUnidad4' );
                  guardarContCombos( 'frmDatos.comboUnidad5', 'frmDatos.hContComboUnidad5' );
                  guardarContCombos( 'frmDatos.comboUnidad6', 'frmDatos.hContComboUnidad6' );
                  guardarContCombos( 'frmDatos.comboUnidad7', 'frmDatos.hContComboUnidad7' );
                  guardarContCombos( 'frmDatos.comboUnidad8', 'frmDatos.hContComboUnidad8' );
                  guardarContCombos( 'frmDatos.comboUnidad9', 'frmDatos.hContComboUnidad9' );
                  
         set('frmDatos.conectorAction', 'LPEstructuraVial' );
    
         enviaSICC('frmDatos');
    }
}

*/

function validaDatos(){
    var b = 'false';
    if ( get( 'frmDatos.comboTipoVia', 'T' ) == '' ){
         GestionarMensaje('1081');
                  setTimeout("focaliza(\'frmDatos.comboTipoVia\',\'\')", 100);		
         b = 'false';
         return;
    }else{b = 'true';}

    if ( get( 'frmDatos.txtNombreVia', 'T' ) == '' ){
         GestionarMensaje('1082');
         setTimeout("focaliza(\'frmDatos.txtNombreVia\',\'\')", 100);         
         b = 'false';
         return;
    }else{b = 'true';}
    
    if ( get( 'frmDatos.comboUnidad1', 'T' ) == '' ){
         GestionarMensaje('1083');
         setTimeout("focaliza(\'frmDatos.comboUnidad1\',\'\')", 100);         
         b = 'false';
         return;
    }else{b = 'true';}

    if ( get( 'frmDatos.comboUnidad2', 'T' ) == '' ){
         GestionarMensaje('1084');         
         if(!comboUnidad2.isDisabled){
             setTimeout("focaliza(\'frmDatos.comboUnidad2\',\'\')", 100);             
         }         
         b = 'false';
         return;
    }else{b = 'true';}

    if ( get( 'frmDatos.comboUnidad3', 'T' ) == '' ){
         GestionarMensaje('1085');
         if(!comboUnidad3.isDisabled){
             setTimeout("focaliza(\'frmDatos.comboUnidad3\',\'\')", 100);             
         }         
         b = 'false';
         return;
    }else{b = 'true';}    


	if ( fValidarNatural(get('frmDatos.txtNumero'),6,0,999999)!='OK') {
             setTimeout("focaliza(\'frmDatos.txtNumero\',\'\')", 100);    
             b = 'false';
    }else{b = 'true';}    

    return b;
}



//Se invoca al presionar el boton buscar
function buscar(){
    if(sicc_validaciones_generales()){
         var oid ="";
         if ( get( 'frmDatos.comboUnidad2', 'T' ) == '' ){
         oid = get( 'frmDatos.comboUnidad1');
         }
         else if ( get( 'frmDatos.comboUnidad3', 'T' ) == '' ){
             oid = get( 'frmDatos.comboUnidad2');
         }
         else if ( get( 'frmDatos.comboUnidad4', 'T' ) == '' ){
             oid = get( 'frmDatos.comboUnidad3');
         }
         else if ( get( 'frmDatos.comboUnidad5', 'T' ) == '' ){
             oid = get( 'frmDatos.comboUnidad4');
         }
         else if ( get( 'frmDatos.comboUnidad6', 'T' ) == '' ){
             oid = get( 'frmDatos.comboUnidad5');
         }
         else if ( get( 'frmDatos.comboUnidad7', 'T' ) == '' ){
             oid = get( 'frmDatos.comboUnidad6');
         }
         else if ( get( 'frmDatos.comboUnidad8', 'T' ) == '' ){
             oid = get( 'frmDatos.comboUnidad7');
         }
         else if ( get( 'frmDatos.comboUnidad9', 'T' ) == '' ){
             oid = get( 'frmDatos.comboUnidad8');
         }
         else if ( get( 'frmDatos.comboUnidad9', 'T' ) != '' ){
             oid = get( 'frmDatos.comboUnidad9');
         }
    
    var datos =  new Array();
         var i = 0;
    
    /*
    determina el ultimo combo selccionado
    */

    datos[i] = ["oidUGnivel", oid];
         i++;

    if ( get('frmDatos.comboTipoVia')!="")
         {
                  datos[i] = ["oidTipoVia",get('frmDatos.comboTipoVia')];
                  i++;
         }

    if ( get('frmDatos.txtNombreVia')!="")
         {
                  datos[i] = ["nombreVia",get('frmDatos.txtNombreVia')];
                  i++;
         }
    
    if ( get('frmDatos.txtNumero')!="")
         {
		          formatoDef = get('frmDatos.hFormatoDef');

                  datos[i] = ["numeroPortal",numeroDeFormatoSICC(get('frmDatos.txtNumero'), formatoDef)];
                  i++;
         }

	ocultarCapa();
    configurarPaginado(mipgndo,"ZONLocalizacionVias","ConectorLocalizacionVias","es.indra.sicc.dtos.zon.DTOELocalizacionDirecciones", datos);
    //mostrarCapa();
    }
}

/*
//guardar el contenido de los combos de Unidades geograficas en una variable oculta
           
function guardarContCombos( cmb, hidd ){

         //'frmDatos.comboUnidad1'
         var longitud = combo_get( cmb, 'L' );
         var strArray = '[';
         var i;

         for( i = 0; i < longitud; i++ ){
                  strArray = strArray + '["' + combo_get( cmb, 'V', i ) + '", "' + combo_get( cmb, 'T', i ) + '"]';
                  if( i < (longitud - 1) ){
                           strArray = strArray + ', ';
                  }
         }
         strArray = strArray + ']';

         //asigna el string a la variable oculta
         //'frmDatos.hContComboUnidad1'
         set( hidd, strArray );
}
*/

//Se invoca cuando se presiona Tab
function setTabFocus( campo ){

         if( campo == 'comboTipoVia' )
                  focaliza('frmDatos.txtNombreVia');

         if( campo == 'txtNombreVia' )
                  focaliza('frmDatos.txtNumero');

         if( campo == 'txtNumero' )
                  focaliza('frmDatos.comboUnidad1');
         
         if( campo == 'comboUnidad1' )
                  if( comboUnidad2.disabled == false )
                           focaliza('frmDatos.comboUnidad2');
                  else
                           focaliza('frmDatos.comboTipoVia');

         if( campo == 'comboUnidad2' )
                  if( comboUnidad3.disabled == false )
                           focaliza('frmDatos.comboUnidad3');
                  else
                           focaliza('frmDatos.comboTipoVia');

         if( campo == 'comboUnidad3' )
                  if( comboUnidad4.disabled == false )
                           focaliza('frmDatos.comboUnidad4');
                  else
                           focaliza('frmDatos.comboTipoVia');

         if( campo == 'comboUnidad4' )
                  if( comboUnidad5.disabled == false )
                           focaliza('frmDatos.comboUnidad5');
                  else
                           focaliza('frmDatos.comboTipoVia');

         if( campo == 'comboUnidad5' )
                  if( comboUnidad6.disabled == false )
                           focaliza('frmDatos.comboUnidad6');
                  else
                           focaliza('frmDatos.comboTipoVia');

         if( campo == 'comboUnidad6' )
                  if( comboUnidad7.disabled == false )
                           focaliza('frmDatos.comboUnidad7');
                  else
                           focaliza('frmDatos.comboTipoVia');

         if( campo == 'comboUnidad7' )
                  if( comboUnidad8.disabled == false )
                           focaliza('frmDatos.comboUnidad8');
                  else
                           focaliza('frmDatos.comboTipoVia');

         if( campo == 'comboUnidad8' )
                  if( comboUnidad9.disabled == false )
                           focaliza('frmDatos.comboUnidad9');
                  else
                           focaliza('frmDatos.comboTipoVia');

         if( campo == 'comboUnidad9' )
                  focaliza('frmDatos.comboTipoVia');
}

//Se invoca cuando se presiona Shift + Tab
function setShiftTabFocus( campo ){
         if( campo == 'comboTipoVia' )
                  if( comboUnidad9.disabled == false )
                           focaliza('frmDatos.comboUnidad9');
                  else if( comboUnidad8.disabled == false )
                           focaliza('frmDatos.comboUnidad8');
                  else if( comboUnidad7.disabled == false )
                           focaliza('frmDatos.comboUnidad7');
                  else if( comboUnidad6.disabled == false )
                           focaliza('frmDatos.comboUnidad6');
                  else if( comboUnidad5.disabled == false )
                           focaliza('frmDatos.comboUnidad5');
                  else if( comboUnidad4.disabled == false )
                           focaliza('frmDatos.comboUnidad4');
                  else if( comboUnidad3.disabled == false )
                           focaliza('frmDatos.comboUnidad3');
                  else if( comboUnidad2.disabled == false )
                           focaliza('frmDatos.comboUnidad2');
                  else if( comboUnidad1.disabled == false )
                           focaliza('frmDatos.comboUnidad1');

         if( campo == 'txtNombreVia' )
                  focaliza('frmDatos.comboTipoVia');

         if( campo == 'txtNumero' )
                  focaliza('frmDatos.txtNombreVia');

         if( campo == 'comboUnidad1' )
                  focaliza('frmDatos.txtNumero');

         if( campo == 'comboUnidad2' )
                  focaliza('frmDatos.comboUnidad1');

         if( campo == 'comboUnidad3' )
                  if( comboUnidad2.disabled == false )
                           focaliza('frmDatos.comboUnidad2');

         if( campo == 'comboUnidad4' )
                  if( comboUnidad3.disabled == false )
                           focaliza('frmDatos.comboUnidad3');

         if( campo == 'comboUnidad5' )
                  if( comboUnidad4.disabled == false )
                           focaliza('frmDatos.comboUnidad4');

         if( campo == 'comboUnidad6' )
                  if( comboUnidad5.disabled == false )
                           focaliza('frmDatos.comboUnidad5');

         if( campo == 'comboUnidad7' )
                  if( comboUnidad6.disabled == false )
                           focaliza('frmDatos.comboUnidad6');

         if( campo == 'comboUnidad8' )
                  if( comboUnidad7.disabled == false )
                           focaliza('frmDatos.comboUnidad7');

         if( campo == 'comboUnidad9' )
                  if( comboUnidad8.disabled == false )
                           focaliza('frmDatos.comboUnidad8');
}

function ocultarCapa(){
         document.all["CplistaResultados"].style.visibility='hidden';
         document.all["CpLin1listaResultados"].style.visibility='hidden';
         document.all["CpLin2listaResultados"].style.visibility='hidden';
         document.all["CpLin3listaResultados"].style.visibility='hidden';
         document.all["CpLin4listaResultados"].style.visibility='hidden';
         document.all["primera1Div"].style.visibility='hidden';
         document.all["ret1Div"].style.visibility='hidden';
         document.all["ava1Div"].style.visibility='hidden';
         document.all["separaDiv"].style.visibility='hidden';

		 sacarScroll();
}

function mostrarCapa(){
         document.all["CplistaResultados"].style.visibility='';
         document.all["CpLin1listaResultados"].style.visibility='';
         document.all["CpLin2listaResultados"].style.visibility='';
         document.all["CpLin3listaResultados"].style.visibility='';
         document.all["CpLin4listaResultados"].style.visibility='';
         document.all["primera1Div"].style.visibility='';
         document.all["ret1Div"].style.visibility='';
         document.all["ava1Div"].style.visibility='';
         document.all["separaDiv"].style.visibility='';

		 ponerScroll();
}



function muestraLista( ultima, rowset, error){

	var tamano = rowset.length;

	if (tamano > 0) {
		mostrarCapa();
		eval (ON_RSZ);
		focaliza('frmDatos.comboTipoVia');
		return true;
     } else {
	    ocultarCapa(); 
	    focaliza('frmDatos.comboTipoVia');
	    return false;
	 }
					 
}


function fLimpiar(){
    var aCombo = new Array(new Array("",""));
    set_combo( 'frmDatos.comboUnidad2', aCombo );
    set_combo( 'frmDatos.comboUnidad3', aCombo );
    set_combo( 'frmDatos.comboUnidad4', aCombo );
    set_combo( 'frmDatos.comboUnidad5', aCombo );
    set_combo( 'frmDatos.comboUnidad6', aCombo );
    set_combo( 'frmDatos.comboUnidad7', aCombo );
    set_combo( 'frmDatos.comboUnidad8', aCombo );
    set_combo( 'frmDatos.comboUnidad9', aCombo );
    
    set('frmDatos.txtNombreVia','');
    set('frmDatos.txtNumero','');
    iSeleccionado1 = new Array(); 
    iSeleccionado1[0] ="";
    set('frmDatos.comboTipoVia',iSeleccionado1);
    set('frmDatos.comboUnidad1',iSeleccionado1);
    
    habilitarCampos();

	focaliza('frmDatos.comboTipoVia');

    /*var codigos = listaResultados.codigos();
    var longitud = codigos.length;
    for(var i=0;i<longitud;i++) {
                  listaResultados.deselecciona(i);    
    }*/
    
}        

function focalizaTab(){
 if(comboUnidad2.isDisabled){
    focalizaBotonHTML('botonContenido','btnCrear');             
 }   


}
function fVolver(){}    // no se implementa
function fGuardar(){}   // no se implementa
function fBorrar(){}    // no se implementa

