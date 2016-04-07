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
    INDRA/CAR/PROY
    $Id: contenido_aptas_cursos_asignar.js,v 1.1 2009/12/03 19:01:46 pecbazalar Exp $
    DESC
*/

var FORMULARIO = "formulario";

function onLoadPag(){     
      configurarMenuSecundario(FORMULARIO);	   
      var errDescripcion = get(FORMULARIO +'.errDescripcion');
      if (errDescripcion !='') {		
	var errCodigo = get(FORMULARIO+'.errCodigo');
	var wnd = fMostrarMensajeError(errCodigo, errDescripcion);
      }
         
      DrdEnsanchaConMargenDcho('listado1',12); 
     
      document.all["Cplistado1"].style.visibility=''; 
      document.all["CpLin1listado1"].style.visibility='';  
      document.all["CpLin2listado1"].style.visibility=''; 
      document.all["CpLin3listado1"].style.visibility='';
      document.all["CpLin4listado1"].style.visibility='';  
      
      document.all["primera1Div"].style.visibility=''; 
      document.all["ret1Div"].style.visibility='';
      document.all["ava1Div"].style.visibility='';  
      document.all["separaDiv"].style.visibility=''; 
      document.all["AsignarAptasDiv"].style.visibility='';     
      
      var constanteEDU = get(FORMULARIO+'.ConstantesEDU');
      var origen = get(FORMULARIO+'.indOrigen');
      if (origen==constanteEDU){
	document.all["btnModificarCurso"].style.visibility='';
	document.all["btnModificarPlantilla"].style.visibility='';
      }else{
	document.all["btnModificarCurso"].style.visibility='hidden';
	document.all["btnModificarPlantilla"].style.visibility='hidden';
      }
      
      focaliza(FORMULARIO+'.cbMarca');
      eval (ON_RSZ);   
    }

function muestraLista( ultima, rowset){
         var tamano = rowset.length;
         if (tamano > 0) {
                  visibleLista();
                  return true;
         } else {
                  invisibleLista();		
                  return false;
         }
}

function visibleLista() {
         if (!get_visibilidad('capaLista')){
                  visibilidad('capaLista','V');
         }
}

function invisibleLista() {
         if (get_visibilidad('capaLista')){
                  visibilidad('capaLista','O');
         }
}   

function compruebashtab() {
         if (get_visibilidad("capaLista")){
		var constanteEDU = get(FORMULARIO+'.ConstantesEDU');
     		var origen = get(FORMULARIO+'.indOrigen');
     		if (origen==constanteEDU){
     			document.all['btnModificarPlantilla'].focus();
   		}else{
       			document.all['AsignarAptas'].focus();
		}
         }else{
         	document.all['btnBuscar'].focus();
         }
}
function compruebatab() {
         if (get_visibilidad("capaLista")){
                document.all['AsignarAptas'].focus();
         }else{
         	focaliza(FORMULARIO+'.cbMarca');
         }
}

function compruebatabAsignar() {
	var constanteEDU = get(FORMULARIO+'.ConstantesEDU');
     	var origen = get(FORMULARIO+'.indOrigen');
     	if (origen==constanteEDU){
     		document.all['btnModificarCurso'].focus();
   	}else{
       		focaliza(FORMULARIO+'.cbMarca');
	}
}


function onSeleccionaMarca(){
	if (get(FORMULARIO+'.cbMarca')==''){
		borrarCombo();
	}else{
		recargaCombo(FORMULARIO+'.cbTipoCurso', 'CMNObtieneTiposCurso', 'es.indra.sicc.dtos.edu.DTODruidaBusqueda', [['oidMarca', get(FORMULARIO+'.cbMarca')],['oidIdioma', get(FORMULARIO+'.idioma')],['oidPais', get(FORMULARIO+'.pais')]] );
	}
}

function borrarCombo(combo){    
          set_combo(FORMULARIO+'.cbTipoCurso',[['','']],['']);
}

function onClickBuscar(){
	var marca = get(FORMULARIO+'.cbMarca');
	set(FORMULARIO+'.marca',marca);
	var canal = get(FORMULARIO+'.cbCanal');
	set(FORMULARIO+'.canal',canal);
	
	var tipoCurso = get(FORMULARIO+'.cbTipoCurso');
	var textCodCurso = get(FORMULARIO+'.txtCodCurso');	
	var textNomCurso = get(FORMULARIO+'.txtNombreCurso');
	var indOrigen = get(FORMULARIO+'.indOrigen');	
	var pais = get(FORMULARIO+'.pais');
	var idioma = get(FORMULARIO+'.idioma');	
	focaliza(FORMULARIO+'.cbMarca');
	configurarPaginado(mipgndo, "EDUBusquedaAsignarAptas", "ConectorConsultaAsignarAptas", 'es.indra.sicc.dtos.edu.DTOAsignarAptas', [ ["oidPais", pais], ["oidIdioma", idioma], ["marca", marca], ["canal", canal], ["tipoCurso", tipoCurso], ["codigo", textCodCurso], ["nombre", textNomCurso], ["indOrigen", indOrigen] ]);
	focaliza(FORMULARIO+'.cbMarca');
}
function onClickAsignar(){
         if (listado1.numSelecc() == 0) {
                  // Muestra el mensaje: "Debe seleccionar un elemento de la lista"
                  GestionarMensaje('50');
         } else {
                  if (listado1.numSelecc() != 1 ) {
                           //Muesta el mensaje: "Debe seleccionar un solo registro"
                           GestionarMensaje('8');
                           
                	  //Se limpia la lista editable
                  	  var seleccion=listado1.codigos();
	                  var i=0;
        	          while(seleccion[i]!=null){
                	  	listado1.deselecciona(i); 
                  		i++;           
                  	 }
                 } else {
			var objParams = new Object();
			var codigoSeleccionado = listado1.codSeleccionados();
			objParams.oidSeleccionado = codigoSeleccionado;
			objParams.origen = get(FORMULARIO+'.indOrigen');

			
			objParams.canal = listado1.extraeDato(codigoSeleccionado,9);
			
			objParams.marca = listado1.extraeDato(codigoSeleccionado,10);
			
			//participantes = el número óptimo de participantes del curso seleccionado en lstCursos 			
			objParams.participantes  = listado1.extraeDato(codigoSeleccionado,7);
			//Si el indicador de acceso a Data Mart del curso seleccionado en lstCursos es igual ConstantesCMN.VAL_TRUE 
			var indicadorDataMart = listado1.extraeDato(codigoSeleccionado,6);
			if(indicadorDataMart == get(FORMULARIO+'.constantesCMN')){
				mostrarModalSICC("LPFicheroAptas","", objParams, null, null);
			}else{
				objParams.path = "";
				mostrarModalSICC("LPAptas","", objParams, null, null);
			}
			focaliza(FORMULARIO+'.cbMarca');
                  }
         }	
}
function fGuardar(){
	onClickGuardar();
}

function fVolver(){
	window.close();
}

function onClickGuardar(){
	var constanteEDU = get(FORMULARIO+'.ConstantesEDU');
	if (get(FORMULARIO+'.indOrigen')==constanteEDU){
	         if (listado1.numSelecc() == 0) {
	                  // Muestra el mensaje: "Debe seleccionar un elemento de la lista"
	                  GestionarMensaje('50');
	         } else {
	                  if (listado1.numSelecc() != 1 ) {
	                           //Muesta el mensaje: "Debe seleccionar un solo registro"
	                           GestionarMensaje('8');
	                           
	                	  //Se limpia la lista editable
	                  	  var seleccion=listado1.codigos();
		                  var i=0;
	        	          while(seleccion[i]!=null){
	                	  	listado1.deselecciona(i); 
	                  		i++;           
	                  	 }
	                  } else {
				set(FORMULARIO+'.accion','Guardar');
         			set(FORMULARIO+'.conectorAction','LPAptasCurso');
         			set(FORMULARIO+'.curso',listado1.codSeleccionados());
         			enviaSICC(FORMULARIO);
	                  }
	         }
	}	
}

function onClickPlantilla(){
       if (listado1.numSelecc() == 0) {
                // Muestra el mensaje: "Debe seleccionar un elemento de la lista"
                GestionarMensaje('50');
       } else {
                if (listado1.numSelecc() != 1 ) {
                         //Muesta el mensaje: "Debe seleccionar un solo registro"
                         GestionarMensaje('8');
                	  //Se limpia la lista editable
                  	  var seleccion=listado1.codigos();
	                  var i=0;
        	          while(seleccion[i]!=null){
                	  	listado1.deselecciona(i); 
                  		i++;           
                  	 }
                } else {
			var objParams = new Object();
			//oid = el oid de la plantilla del curso seleccionado en lstCursos
			var codigoselec = listado1.codSeleccionados();
			var codigoPlantilla = listado1.extraeDato(codigoselec,8);
			objParams.oid = codigoPlantilla;
			mostrarModalSICC("LPModificaPlantilla","modificar", objParams, null, null);
			focaliza(FORMULARIO+'.cbMarca');
                }
       }
}


function onClickCurso(){
       if (listado1.numSelecc() == 0) {
                // Muestra el mensaje: "Debe seleccionar un elemento de la lista"
                GestionarMensaje('50');
       } else {
                if (listado1.numSelecc() != 1 ) {
                         //Muesta el mensaje: "Debe seleccionar un solo registro"
                         GestionarMensaje('8');
                	  //Se limpia la lista editable
                  	  var seleccion=listado1.codigos();
	                  var i=0;
        	          while(seleccion[i]!=null){
                	  	listado1.deselecciona(i); 
                  		i++;           
                  	 }
                } else {
			var objParams = new Object();
			//oid = el oid del curso seleccionado en lstCursos				
			var codigoSeleccionado = listado1.codSeleccionados();
			objParams.oid = codigoSeleccionado;
			mostrarModalSICC("LPModificaCurso","modificar", objParams, null, null);
			focaliza(FORMULARIO+'.cbMarca');
                }
       }
}	

function validarCodCurso(){ 
	var num = get(FORMULARIO+'.txtCodCurso'); 
	if(num != ""){
		var val = allTrim(num);             
    	//Como no nos interesa validar el número de dígitos que tiene el 
    	//entero ponemos uno suficientemente grande. 
		if ((ValidaInt(val.toString(),10000, 0)!="OK")||(val.toString() < 0)) {
			GestionarMensaje('747', null, null, null);
			focaliza(FORMULARIO+'.txtCodCurso');
			return false;
		}
	}
}
function allTrim(sStr){ 
         return rTrim(lTrim(sStr)); 
}
function lTrim(sStr){ 
         while (sStr.charAt(0) == " "){
                  sStr = sStr.substr(1, sStr.length - 1); 
         }
         return sStr; 
} 
function rTrim(sStr){ 
         while (sStr.charAt(sStr.length - 1) == " ") {
                  sStr = sStr.substr(0, sStr.length - 1); 
         }
         return sStr; 
} 
 
