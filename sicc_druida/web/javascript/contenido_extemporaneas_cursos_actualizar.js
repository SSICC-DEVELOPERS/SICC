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
    $Id: contenido_extemporaneas_cursos_actualizar.js,v 1.1 2009/12/03 19:01:56 pecbazalar Exp $
    DESC
*/
var FORMULARIO="frm";
var contador = 0;

// ------------------------------------------------------------------------------------------------------------------------------------------------------------------
function onLoadPag()   
{           
	if (get(FORMULARIO+'.errDescripcion')!='') {
		var wnd = fMostrarMensajeError(get(FORMULARIO+'.errCodigo'),get(FORMULARIO+'.errDescripcion'));
	} 
	DrdEnsanchaConMargenDcho('listado1',12); 
	configurarMenuSecundario(FORMULARIO);
	document.all["Cplistado1"].style.visibility=''; 
	document.all["CpLin1listado1"].style.visibility='';  
	document.all["CpLin2listado1"].style.visibility=''; 
	document.all["CpLin3listado1"].style.visibility='';
	document.all["CpLin4listado1"].style.visibility='';  
	
	document.all["primera1Div"].style.visibility=''; 
	document.all["ret1Div"].style.visibility='';
	document.all["ava1Div"].style.visibility='';  
	document.all["separaDiv"].style.visibility=''; 
	eval (ON_RSZ);  
	
}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------------
//Cortaberria - se valida que se haya seleccionado algun registro - 30/06/2005 Inc. BELC300019099
// SSantana - Se envía toda la listaEditable, no solamente los seleccionados. Además, se cambian los índices y datos
//                  a enviar. - 7/12/2005, SICC-GCC-EDU-009
function onClickAceptar(){
	//Al pulsar sobre btnAceptar, se llama a LPExtemporaneas a través de EnviarOculto con accion="Registrar"
	//guardamos los datos de la lista editable

	var cadena = "";
	listado1.actualizaDat(); //Actualiza el array 'datos'
	datosFinal = listado1.datos;
	//alert("datosFinal: " + datosFinal);
	for (i = 0; i < datosFinal.length; i++) {
		var fila = datosFinal[i];
		//alert("fila: " + fila);
		//sólo nos interesan : 0-Nro.Registro, 2-Fecha, 7- OidCliente.
		/*for (j = 0; j < fila.length; j++) {
			if (fila[j] == "" ){
				fila[j] = "-";
			}
	    }*/
		cadena += fila[0] + "@" + fila[2] + "@" + fila[7] + "#";
		//alert("cadena: " + cadena);
	}
	set(FORMULARIO+'.lista', cadena);
	set(FORMULARIO+'.conectorAction',"LPExtemporaneas");
	set(FORMULARIO+'.accion',"Registrar");
	enviaSICC(FORMULARIO);      

}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------------
function insercionCorrecta(codigoError, codigosAResaltar){

	if ( codigoError != '' ) {
		GestionarMensaje(codigoError);
		var nroRegistro = codigosAResaltar.split(",");

		for (var i = 0; i < nroRegistro.length; i++) {
			var indice = obtieneIndicePorCodigo(nroRegistro[i], 'listado1');
			//alert("indice: " + indice);
			if ( indice != -1) {
				listado1.ponColorFondoFila(indice, 'red');
			}
		}
	}
}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------------
function obtieneIndicePorCodigo(codigo, lista) {
   eval(lista	 + ".actualizaDat();");
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


function resaltaFila(indice, color) {
	listado1.ponColorFondoFila(indice, 'red');
}



// ------------------------------------------------------------------------------------------------------------------------------------------------------------------
function validaFormularioOnBlur(fila){
    validaFecha(fila);
}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------------
function validaFecha(numFila) {
	var resul = 0;
	var fecha = "";
	listado1.actualizaDat();
	datosFinal = listado1.datos;
	var fila = datosFinal[numFila];
	fecha=fila[4];
	if(fecha != ""){
		resul = EsFechaValida(fecha,fecha, FORMULARIO,null);
	 	if(resul==1 || resul==2){  
        	GestionarMensaje('1006', get(FORMULARIO+'.hFormatoFechaPais')); 
			mandaElFoco(numFila);
			return false;
        } else{
    		return true;
    	}
        
    }	
}	

// ------------------------------------------------------------------------------------------------------------------------------------------------------------------
function mandaElFoco(fila){  // focaliza una caja de texto
   var nombrelistado="listado1"; 
   var nombreCajaText="Texto1"; 
   var indiceFila=fila;   //Empezando desde 0 
   eval(nombrelistado+".preparaCamposDR()"); 
   focaliza('frm'+nombrelistado+'.'+nombreCajaText+'_'+indiceFila,''); //Focalizo 
   
} 

// ------------------------------------------------------------------------------------------------------------------------------------------------------------------
function fLimpiar(){
	listado1.actualizaDat();
    var datosFinal = listado1.datos;
    for (i = 0; i < datosFinal.length; i++) {
    	datosFinal[i][4] = ''; 
    }
    listado1.reajusta();
    mandaElFoco(0);
    
}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------------
function fVolver(){
	//cerramos la ventana
    window.close();		
}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------------
function muestraLista( ultima, rowset){
	var tamano = rowset.length;
	if (tamano > 0) {
	        //visibleLista();
	        return true;
	} else {
	             
	        window.close();	
	        return false;
	}
}

/*function visibleLista(){                                 
	visibilidad('capaLista','V'); 
	DrdEnsanchaConMargenDcho('listado1',12);
    eval (ON_RSZ);  
	document.body.focus();
    setTimeout('listado1.form.Texto1_0.focus();var tr=listado1.form.Texto1_0.createTextRange();tr.execCommand("SelectAll");',5)   
}

function noVisibleLista() { 
         visibilidad('capaLista','O');
}*/

// ------------------------------------------------------------------------------------------------------------------------------------------------------------------
function focalizaAnterior(FILAEVENTO, TECLAEVENTO){
	if (TECLAEVENTO == 9 && FILAEVENTO == 0) {
    	//document.all['Aceptar'].focus();
    }
}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------------
// SSantana, 5/12/2005, SICC-GCC-EDU-009
function accionBuscar() {

	var obj = new Object();
	var busquedaRapida = mostrarModalSICC('LPBusquedaRapidaCliente', '', obj);
	//alert("busquedaRapida: " + busquedaRapida);

	if ( busquedaRapida != null && busquedaRapida != undefined) {
		var oidCliente = busquedaRapida[0];
		var codCliente = busquedaRapida[1];
		var nombre1 =    busquedaRapida[2];
		var nombre2 =    busquedaRapida[3];
		var apellido1 =  busquedaRapida[4];
		var apellido2 =  busquedaRapida[5];

		/*alert("oidCliente: " + oidCliente);
		alert("codCliente: " + codCliente);
		alert("nombre1: " + nombre1);
		alert("nombre2: " + nombre2);
		alert("apellido1: " + apellido1);
		alert("apellido2: " + apellido2);*/

		set(FORMULARIO + '.oidCliente', oidCliente);
		set(FORMULARIO + '.txtCodigoCliente', codCliente);
		set(FORMULARIO + '.nombre1', nombre1);
		set(FORMULARIO + '.nombre2', nombre2);
		set(FORMULARIO + '.apellido1', apellido1);
		set(FORMULARIO + '.apellido2', apellido2);
	}
}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------------
// SSantana, 5/12/2005, SICC-GCC-EDU-009
function accionAniadir() {
	var oidCliente = get(FORMULARIO + '.oidCliente');

	if ( sicc_validaciones_generales('grupoPPal') ) {
		if ( oidCliente == null || oidCliente == undefined || oidCliente == '') {
			// Busco los datos del cliente para el Código de Cliente ingresado. 
			eval(FORMULARIO).oculto="S";
			codCliente = get(FORMULARIO + '.txtCodigoCliente');
			set(FORMULARIO + '.codigoCliente', codCliente);
			set(FORMULARIO + '.conectorAction', 'LPExtemporaneas');
			set(FORMULARIO + '.accion', 'Obtener Datos Cliente');
			enviaSICC(FORMULARIO);
		} else {
			var nuevaFila = new Array();

			listado1.actualizaDat();
			var oidCliente = get(FORMULARIO + '.oidCliente');
			var codCliente = get(FORMULARIO + '.txtCodigoCliente');
			var nombre1 = get(FORMULARIO + '.nombre1');
			var nombre2 = get(FORMULARIO + '.nombre2');
			var apellido1 = get(FORMULARIO + '.apellido1');
			var apellido2 = get(FORMULARIO + '.apellido2');
			var fecha = get(FORMULARIO  + '.txtFechaAsistenciaCurso');
			
			nuevaFila[0] = contador;
			nuevaFila[1] = codCliente;
			nuevaFila[2] = fecha;
			if(apellido1 == 'null'){
				nuevaFila[3] = '';
		    }else{
				nuevaFila[3] = apellido1;
			}

			if(apellido2 == 'null'){
				nuevaFila[4] = '';
		    }else{
				nuevaFila[4] = apellido2;
			}

			if(nombre1 == 'null'){
				nuevaFila[5] = '';
		    }else{
				nuevaFila[5] = nombre1;
			}
            
			if(nombre2 == 'null'){
				nuevaFila[6] = '';
		    }else{
				nuevaFila[6] = nombre2;
			}

		
			nuevaFila[7] = oidCliente;
			listado1.insertar(nuevaFila);
			contador++;
		}
	}

}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------
// SSantana, 5/12/2005, SICC-GCC-EDU-009
function codigoClienteOnBlur() {
    var codigoCliente = get(FORMULARIO + '.txtCodigoCliente').toString();

    if (codigoCliente != '') {
 		 var longitudCodigoCliente = get(FORMULARIO + '.longitudCodigoCliente').toString();
		 var longitud = codigoCliente.length;
		 //alert("longitudCodigoCliente: " + longitudCodigoCliente);
		 var cadena = rellenaCeros(codigoCliente, longitudCodigoCliente, longitud);
		 set(FORMULARIO + '.txtCodigoCliente', cadena);
    }
}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------
// SSantana, 5/12/2005, SICC-GCC-EDU-009
function limpiaVarsOcultas() {
	set(FORMULARIO + '.oidCliente', '');
	set(FORMULARIO + '.nombre1', '');
	set(FORMULARIO + '.nombre2', '');
	set(FORMULARIO + '.apellido1', '');
	set(FORMULARIO + '.apellido2', '');
}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------
// SSantana, 6/12/2005, SICC-GCC-EDU-009
function anyadeCampoALista(oidCliente, nombre1, nombre2, apellido1, apellido2) {
	// Tomo codigoCliente de la caja de texto.
	var codigoCliente = get(FORMULARIO + '.txtCodigoCliente');

	if(validarCodigoCliente(codigoCliente)){
	// Tomo fecha. 
	var fecha = get(FORMULARIO + '.txtFechaAsistenciaCurso');
	listado1.actualizaDat();
	var nuevaFila = new Array();
	nuevaFila[0] = contador;
	nuevaFila[1] = codigoCliente;
	nuevaFila[2] = fecha;
	if(apellido1 == 'null'){
		nuevaFila[3] = '';
	}else{
		nuevaFila[3] = apellido1;
	}

	if(apellido2 == 'null'){
		nuevaFila[4] = '';
	}else{
		nuevaFila[4] = apellido2;
	}

	if(nombre1 == 'null'){
		nuevaFila[5] = '';
	}else{
		nuevaFila[5] = nombre1;
	}
	
	if(nombre2 == 'null'){
		nuevaFila[6] = '';
	}else{
		nuevaFila[6] = nombre2;
	}

		
	nuevaFila[7] = oidCliente;
//	alert("nuevaFila: " + nuevaFila);
	var datos = listado1.datos;
	datos[datos.length] = nuevaFila;
	//listado1.insertar(nuevaFila);
	listado1.setDatos(datos);

	set(FORMULARIO + '.oidCliente', '');
	set(FORMULARIO + '.txtCodigoCliente', '');
	set(FORMULARIO + '.txtFechaAsistenciaCurso', '');
	set(FORMULARIO + '.codigoCliente', '');
	set(FORMULARIO + '.nombre1', '');
	set(FORMULARIO + '.nombre2', '');
	set(FORMULARIO + '.apellido1', '');
	set(FORMULARIO + '.apellido2', '');

	focaliza(FORMULARIO + ".txtCodigoCliente");

	contador++;
	}
}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------
   function validarCodigoCliente(codigoCliente){
      listado1.actualizaDat(); //Actualiza el array 'datos'
	  datosFinal = listado1.datos;
	
	  for (i = 0; i < datosFinal.length; i++) {
	     var codCliente = datosFinal[i][1];
         if(codigoCliente == codCliente) {
		   cdos_mostrarAlert('El codigo de cliente ya existe en la lista.')
		   return false;
		 }
	   }
      return true;
   }

// ------------------------------------------------------------------------------------------------------------------------------------------------------------
// SSantana, 6/12/2005, SICC-GCC-EDU-009
function errorBusquedaCliente() {
	focaliza(FORMULARIO + ".txtCodigoCliente");
}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------
// SSantana, 6/12/2005, SICC-GCC-EDU-009
function fBorrar() {

	var codSelec = listado1.codSeleccionados();
	var cantCodigos = codSelec.length;
	//alert('codSelec.length: ' + codSelec.length);

	if (cantCodigos > 0) {
		listado1.eliminarSelecc();
	} else {
		GestionarMensaje('UIEDU0008');
	}

}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------
// SSantana, 6/12/2005, SICC-GCC-EDU-009
function fGuardar() {
	onClickAceptar();
}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------
// SSantana, 6/12/2005, SICC-GCC-EDU-009
function errorRegistraAsistencia() {

}
