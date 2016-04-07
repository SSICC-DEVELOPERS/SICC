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
    $Id: contenido_formularios_tipo_solicitud_asignar.js,v 1.1 2009/12/03 19:02:15 pecbazalar Exp $
    DESC
*/
var FORMULARIO = 'frm';
var guardando = false;
var JS_NUMERO_DEFECTO = 99999999;//cajas de texto vacias van al principio

//Funcion que se ejecuta al cargar la pagina
function onLoadPag()   {
    configurarMenuSecundario(FORMULARIO);
	fMostrarMensajeError();
	DrdEnsanchaConMargenDcho('listado1',12);                 
	ocultarListaEditable();
	eval(ON_RSZ);     
    focaliza(FORMULARIO + ".cbTipoSolicitud");
}


/**
* Asignamos el ConectorObtenerFormulariosTipoSolicitud al listado formularios 
* pasandole como parametro el valor del combo tipoSolicitud.
* Desabilitamos el combo tipoSolicitud y el boton aceptar.
*/
function aceptar() {
	if(sicc_validaciones_generales()){   
		deshabilita();
		mostrarListaEditable();
		configurarPaginado(mipgndo, 'FACCargaFormulariosTiposSolicitud', 'ConectorObtenerFormulariosTipoSolicitud',   
								'es.indra.sicc.util.DTOOID', armarArray());   
		btnProxy(1,1);
	}
}

function armarArray()  {   
	var array = new Array();   
	array[0] = new Array('oid',get(FORMULARIO + ".cbTipoSolicitud"));   
	return array;   
}   


function limpiaLista(){
	filas = listado1.datos.length;
	if (filas != 0) {
		listado1.eliminar(0,filas);
	}
	ocultarListaEditable();
}

function fGuardar(){
		if (sicc_validaciones_generales()) {
				//Enviamos el formulario de forma oculta con la accion "guardar"
				var i = compruebaOrden();
				if (i != 0){
					// Muestra el mensaje: "No se puede repetir los números de orden para 
					// un tipo de solicitud" (UIFAC0001)
					GestionarMensaje('1338');
					var nombrelistado="listado1";                                                  
					var nombreCajaText="Orden";                                                    
					var indiceFila=i;                                                              
					eval(nombrelistado+".preparaCamposDR()");                                      
					focaliza('frm'+nombrelistado+'.'+nombreCajaText+'_'+indiceFila,''); //Focalizo 

					return false;
				}   
				guardando = true;
	 			var bol = obtenerOids();
	 			
	 			if(bol){
	 				set(FORMULARIO+'.accion','guardar');
     				set(FORMULARIO+'.conectorAction','LPFormularioTiposSolicitud');	
     				
     				enviaSICC(FORMULARIO);
     			}else{
     				guardando = false;
     			}
     	}
}
 

/**
* Mostramos la lista editable, en este caso con los botones de paginacion ocultos por ser no paginada.
*/
function mostrarListaEditable() {   
	document.all["Cplistado1"].style.visibility='visible';   
	document.all["CpLin1listado1"].style.visibility='visible';   
	document.all["CpLin2listado1"].style.visibility='visible';   
	document.all["CpLin3listado1"].style.visibility='visible';   
	document.all["CpLin4listado1"].style.visibility='visible';   
	document.all["primera1Div"].style.visibility='hidden';   
	document.all["ret1Div"].style.visibility='hidden';   
	document.all["ava1Div"].style.visibility='hidden';   
	document.all["separaDiv"].style.visibility='hidden';   
}   

function ocultarListaEditable() {   
	document.all["Cplistado1"].style.visibility='hidden';   
	document.all["CpLin1listado1"].style.visibility='hidden';   
	document.all["CpLin2listado1"].style.visibility='hidden';   
	document.all["CpLin3listado1"].style.visibility='hidden';   
	document.all["CpLin4listado1"].style.visibility='hidden';   
	document.all["primera1Div"].style.visibility='hidden';   
	document.all["ret1Div"].style.visibility='hidden';   
	document.all["ava1Div"].style.visibility='hidden';   
	document.all["separaDiv"].style.visibility='hidden';   
}   

function habilita(){

	document.all['btnAceptar'].disabled=false;
    accion(FORMULARIO+'.cbTipoSolicitud','.disabled=false');
}

function deshabilita(){

	document.all['btnAceptar'].disabled=true;
    accion(FORMULARIO+'.cbTipoSolicitud','.disabled=true');
}

function fLimpiar(){
	habilita();
	set(FORMULARIO+'.cbTipoSolicitud', ['']);
	focaliza(FORMULARIO +'.cbTipoSolicitud');
	limpiaLista();
	btnProxy(1,0);
	guardando = false;
}

function obtenerOids(){
	//Almacenamos en un hidden los dos valores de las filas
	//de la lista editable
	//#oid@ordenformulario#oid@ordenformulario  
                  
    var cadena = "";
    listado1.actualizaDat(); //Actualiza el array 'datos'
    var datosFinal = listado1.datos;
        for (i = 0; i < datosFinal.length; i++) {
            var fila = datosFinal[i];
            //Comprobamos que el campo ordenfomulario este informado
            var temp = allTrim(fila[6]);
            if (temp != "" &&(ValidaInt(temp.toString(),10000, 0)=="OK")&&(temp.toString() > 0)) {
            	//Recogemos los valores
            	cadena += fila[0]+"@"+allTrim(fila[6])+"#";
            }else if(temp != ""){
            	GestionarMensaje('747', null, null, null);
            	var nombrelistado="listado1"; 
				var nombreCajaText="Orden"; 
				var indiceFila=i;   
				eval(nombrelistado+".preparaCamposDR()"); 
				focaliza('frm'+nombrelistado+'.'+nombreCajaText+'_'+indiceFila,''); //Focalizo 
            	return false;
        	}
        }	 	             
   		set(FORMULARIO + '.cadena', cadena);
   		return true;
}

function correcto() {
	//Llamamos a la funcion que implementa el boton limpiar de los iconos
	fLimpiar();
    //window.parent.frames['iconos'].foc_btnBarra5(); 
}

function muestraLista( ultima, rowset){
	var tamano = rowset.length;
	if (tamano > 0) {
		var nombrelistado="listado1"; 
		var nombreCajaText="Orden"; 
		eval(nombrelistado+".preparaCamposDR()"); 
		//focaliza('frm'+nombrelistado+'.'+nombreCajaText+'_0','');
		return true;
	} else {
		focaliza(FORMULARIO +'.cbTipoSolicitud');
		return false;
	}
}

function ordenOnBlur(FILAEVENTO) {
		if(guardando == false){  
			if (errorNoEnteroEnLista(listado1,FILAEVENTO,6))   {
        		GestionarMensaje('747', null, null, null); 
        		//focaliza(FORMULARIO+'.'+nombreElemento);
        		
        		var nombrelistado="listado1"; 
				var nombreCajaText="Orden"; 
				var indiceFila=FILAEVENTO;  
				eval(nombrelistado+".preparaCamposDR()"); 
				focaliza('frm'+nombrelistado+'.'+nombreCajaText+'_'+indiceFila,''); //Focalizo 
        		
        		return false; 
        	}
        }
}           
            
function compruebaOrden(){

	listado1.actualizaDat();
	var datos = listado1.datos;
	var i;
	var j;
	var orden = new Array(0);

	for (i = 0; i < datos.length; i++){
		for (j = 0; j < orden.length; j++){
			if ((allTrim(datos[i][6]) == allTrim(orden[j]))&&(allTrim(datos[i][6]) !=  "")){
				return i;
			}
		}
		orden[orden.length] = allTrim(datos[i][6]);
	}
	
	return 0;
}

function errorNoEnteroEnLista(lista,fila,columna)   {//Esta función solo valida, no focaliza ni da mensajes de error 
   var i = fila; 
   lista.actualizaDat(); 
   var datos = lista.datos; 
   var valor = datos[i][columna]; 
   if (valor.toString() != "") { 
      var val = allTrim(valor); 
      if ((ValidaInt(val.toString(),10000, 0)!="OK")||(val.toString() < 0)) 
         return true; 
      }   
   return false; 
   } 

function focalizaSiguiente(FILAEVENTO, TECLAEVENTO){
		if (FILAEVENTO == listado1.datos.length-1 && TECLAEVENTO == 9) {
			if (!errorNoEnteroEnLista(listado1,FILAEVENTO,6))   { 
				document.body.focus();
				setTimeout('listado1.form.Orden_0.focus();var tr=listado1.form.Orden_0.createTextRange();tr.execCommand("SelectAll");',5)
			}
		}
}



function focalizaAnterior(FILAEVENTO, TECLAEVENTO){
	if (TECLAEVENTO == 9 && FILAEVENTO == 0) {
		if (!errorNoEnteroEnLista(listado1,FILAEVENTO,6))   { 
			document.body.focus();
			setTimeout("eval('listado1.form.Orden_'+(listado1.datos.length-1)).focus();var tr=eval('listado1.form.Orden_' +(listado1.datos.length-1)).createTextRange();tr.execCommand('SelectAll');",5);
		}
	}
}

function lTrim(sStr){ 
while (sStr.charAt(0) == " ") 
sStr = sStr.substr(1, sStr.length - 1); 
return sStr; 
} 

function rTrim(sStr){ 
while (sStr.charAt(sStr.length - 1) == " ") 
sStr = sStr.substr(0, sStr.length - 1); 
return sStr; 
} 

function allTrim(sStr){ 
return rTrim(lTrim(sStr)); 
}
