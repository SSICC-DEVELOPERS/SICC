/**
* Copyright 2004 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
    $Id: contenido_extemporaneas_cursos_registrar.js,v 1.1 2009/12/03 19:02:19 pecbazalar Exp $
    DESC
*/
var FORMULARIO = "formulario";

// ------------------------------------------------------------------------------------------------------------------------------------------------------------
function onLoadPag()   
{       

	if (get(FORMULARIO+'.errDescripcion')!='') {
		var wnd = fMostrarMensajeError(get(FORMULARIO+'.errCodigo'),get(FORMULARIO+'.errDescripcion'));
	}     
	DrdEnsanchaConMargenDcho('listado1',12); 
	configurarMenuSecundario(FORMULARIO);
	/*document.all["Cplistado1"].style.visibility=''; 
	document.all["CpLin1listado1"].style.visibility='';  
	document.all["CpLin2listado1"].style.visibility=''; 
	document.all["CpLin3listado1"].style.visibility='';
	document.all["CpLin4listado1"].style.visibility='';  
	
	document.all["primera1Div"].style.visibility=''; 
	document.all["ret1Div"].style.visibility='';
	document.all["ava1Div"].style.visibility='';  
	document.all["separaDiv"].style.visibility=''; 
	document.all["ParticipantesDiv"].style.visibility=''; 
	*/    
	eval (ON_RSZ); 
	focaliza(FORMULARIO+'.cbMarca');  
     
}
    
// ------------------------------------------------------------------------------------------------------------------------------------------------------------
function onSeleccionaMarca(){
	var marca = get(FORMULARIO+'.cbMarca');
	var idioma = get(FORMULARIO+'.idioma');
	var pais = get(FORMULARIO+'.pais');
	
	if(marca != 0){
		recargaCombo(FORMULARIO+'.cbTipoCurso', 'CMNObtieneTiposCurso', 'es.indra.sicc.dtos.edu.DTODruidaBusqueda', [['oidIdioma',idioma],['oidMarca', marca],['oidPais',pais]] );
		focaliza(FORMULARIO+'.cbTipoCurso');
	} else{
		set_combo(FORMULARIO+'.cbTipoCurso',[['','']],['']);
		focaliza(FORMULARIO+'.cbMarca'); 
	}
	
}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------
function compruebashtab(){                               
	if (get_visibilidad("capaLista")){              
	        document.all['InvitarParticipantes'].focus();   
	}else{                                          
	        document.all['btnBuscar'].focus();      
	}                                               
}                                                         

// ------------------------------------------------------------------------------------------------------------------------------------------------------------
function compruebatab(){                                 
	if (get_visibilidad("capaLista")){              
	        document.all['Aceptar'].focus();   
	}else{                                          
	        focaliza(FORMULARIO+'.cbMarca');        
	}  
}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------
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

// ------------------------------------------------------------------------------------------------------------------------------------------------------------
function allTrim(sStr){ 
         return rTrim(lTrim(sStr)); 
}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------
function lTrim(sStr){ 
         while (sStr.charAt(0) == " "){
                  sStr = sStr.substr(1, sStr.length - 1); 
         }
         return sStr; 
} 

// ------------------------------------------------------------------------------------------------------------------------------------------------------------
function rTrim(sStr){ 
         while (sStr.charAt(sStr.length - 1) == " ") {
                  sStr = sStr.substr(0, sStr.length - 1); 
         }
         return sStr; 
}                             

// ------------------------------------------------------------------------------------------------------------------------------------------------------------
function onClickBuscar(){
	//Este método se ejecuta cuando pulsa sobre btnBuscar. 
	//Se carga la lista lstCursos(listado1) con los cursos que cumplen el criterio de búsqueda especificado por el usuario. 
	
	var marca = get(FORMULARIO+'.cbMarca');
	var canal = get(FORMULARIO+'.cbCanal');
	var tipocurso = get(FORMULARIO+'.cbTipoCurso');
	var codigocurso= get(FORMULARIO+'.txtCodCurso');
	var nombrecurso= get(FORMULARIO+'.txtNombreCurso');
	var idioma = get(FORMULARIO+'.idioma');
	var pais = get(FORMULARIO+'.pais');
	
	
	configurarPaginado(mipgndo, "EDUBusquedaRegistrarExtemporaneas", 
								"ConectorConsultaRegistrarExtemporaneas", 
								"es.indra.sicc.dtos.edu.DTOConsultaCurso", 
								[ ["marca", marca], 
								["canal", canal], ["tipoCurso", tipocurso], 
								["codigo", codigocurso], ["nombre", nombrecurso],['oidIdioma',idioma],['oidPais',pais]]);
	
}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------
function onClickAceptar(){
	
	/*Cuando se pulsa el botón btnAceptar, 
	si hay un curso seleccionado en la lista lstCursos(listado1), 
	se abre una ventana emergente modal 
	y en la nueva ventana se invoca LPExtemporaneas con: 
		accion = "" 
		oid = el oid del curso seleccionado en lstCursos
	*/	
	if (listado1.numSelecc() == 0) {
         //Mostramos mensaje de error 
         GestionarMensaje('50');
    } else {
    	if (listado1.numSelecc()!=1) {
    		//Muesta el mensaje: "Debe seleccionar un solo registro"
    		GestionarMensaje('8');
    		//Se limpia la lista editable
            var seleccion=listado1.codigos();
            var i=0;
            while(seleccion[i]!=null){
              	listado1.deselecciona(i); 
               	i++;           
            }
    	}else {
			listado1.actualizaDat();
			var datos = listado1.datos;
    		var objParams = new Object();
			var cods = listado1.codSeleccionados();
			var indice = obtieneIndicePorCodigo(cods[0], 'listado1');

			objParams.oid = cods[0];
			objParams.oidTipoCurso = datos[indice][8];
			//alert("TipoCurso: " + datos[indice][8]);

			mostrarModalSICC('LPExtemporaneas', '', objParams, null, null);
    	}
    }
}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------
function onClickInvitar() {
	/*Cuando se pulsa el botón btnInvitar, si hay un curso seleccionado en la lista lstCursos, 
	se abre una ventana emergente modal y en la nueva ventana se invoca LPInvitadas con: 
	accion = "" 
	oid = el oid del curso seleccionado en lstCursos*/
	if (listado1.numSelecc() == 0) {
         //Mostramos mensaje de error 
         GestionarMensaje('50');
    } else {
    	if (listado1.numSelecc()!=1) {
    		//Muesta el mensaje: "Debe seleccionar un solo registro"
    		GestionarMensaje('8');
    		//Se limpia la lista editable
            var seleccion=listado1.codigos();
            var i=0;
            while(seleccion[i]!=null){
              	listado1.deselecciona(i); 
               	i++;           
            }
    	}else {
    		var objParams = new Object();
			objParams.oid = listado1.codSeleccionados();
			mostrarModalSICC('LPInvitadas', '', objParams, null, null);
    	}
    }

}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------
function visibleLista() {
         if (!get_visibilidad("capaLista")){
                  visibilidad('capaLista','V');
                  DrdEnsanchaConMargenDcho('listado1',12);
                  eval (ON_RSZ);  
         }
}
 
// ------------------------------------------------------------------------------------------------------------------------------------------------------------
function invisibleLista() {
         if (get_visibilidad("capaLista")){
                  visibilidad('capaLista','O');
         }
}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------
function muestraLista( ultima, rowset){
	var tamano = rowset.length;
	if (tamano > 0) {
	        visibleLista();
	        return true;
	} else {
	        invisibleLista();              
	        focaliza(FORMULARIO+'.cbMarca');
	        //cdos_mostrarAlert("No existen registros que cumplan los criterios de búsqueda");
	        return false;
	}
}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------
function obtieneIndicePorCodigo(codigo, lista) {
   eval(lista    + ".actualizaDat();");
   var datos = eval(lista + ".datos;");
   var indice = -1;
   var match = false; 

   for (var i = 0; (i < datos.length) && (!match); i++) {
            var codigoLista = datos[i];
            if ( parseInt( codigo, 10) == parseInt(codigoLista , 10) ) {
                           indice = i;
                           match = true;
            }
   }

   return indice;
}

