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
    $Id: contenido_cuotas_cancelacion.js,v 1.1 2009/12/03 19:01:29 pecbazalar Exp $
    DESC
*/
var FORMULARIO = 'frmFormulario';
var varNoLimpiarSICC = true;
function onLoadPag()   { 
	if (get(FORMULARIO+'.errDescripcion')!='') {
	
		var wnd = fMostrarMensajeError(get(FORMULARIO+'.errCodigo'),get(FORMULARIO+'.errDescripcion'));
	}
	
	//Control del foco
	if (document.all['txtCodCliente'][0].disabled){
		//Esta desactivado, deshabilito la lupa y le paso el foco al siguiente
		//document.all['lupa'].onclick=function(){}
		//focaliza(FORMULARIO + ".txtIdCuota");
		focaliza(FORMULARIO + ".txtNumDocumento");
		
	}else {
		//Esta activo y le paso el foco
		focaliza(FORMULARIO + ".txtCodCliente");
		
	}
	
	configurarMenuSecundario(FORMULARIO);
	
	
}
   
function accionBuscar() {
	var identificadorCuota ='';
	var ejercicioCuota = '';
	var numeroOrdenCuota='';
	txt_to('lbTotalAplicar','');
	
	var nDoc = get(FORMULARIO+'.txtNumDocumento');
	//Identificador de cuota= 8 últimas posiciones del número de documento	
	//Ejercicio de cuota= 2 primera posiciones del número de documento. 
	if (nDoc != '') {
		identificadorCuota = nDoc.substr(2);
		ejercicioCuota = nDoc.substr(0, 2);
	}

	var cliente = get(FORMULARIO+'.txtCodCliente');
	var canal = get(FORMULARIO+'.cbCanal');
	var acceso = get(FORMULARIO+'.cbAcceso');
	var subacceso = get(FORMULARIO+'.cbSubacceso');
	
	var proceso = get(FORMULARIO+'.proceso');
	var empresa = get(FORMULARIO+'.empresa');
	var subproceso = get(FORMULARIO+'.subproceso');
	
	var idioma = get(FORMULARIO+'.idioma');
	var pais = get(FORMULARIO+'.pais');
	
	if (cliente == "" && nDoc == "" && canal == "" && acceso == "" && subacceso == "") {
		cdos_mostrarAlert(GestionarMensaje('1347'));
		focaliza(FORMULARIO+'.txtCodCliente');
	} else {            
		configurarPaginado(mipgndo,"CCCBuscarCuentasPendientesCancelacion",
			"ConectorBuscarCuentasPendientesCancelacion",
			"es.indra.sicc.dtos.ccc.DTOBuscarCuentasCorrientes",
			[['cliente', cliente], 
			['identificadorCuota', identificadorCuota], 
			['ejercicioCuota', ejercicioCuota], 
			['numeroOrdenCuota',numeroOrdenCuota],
			['proceso', proceso], 
			['subproceso', subproceso], 
			['empresa', empresa], 
			['oidIdioma', idioma], 
			['oidPais',pais], 
			['canal', canal], 
			['acceso', acceso], 
			['subacceso', subacceso] ]);
         
		// Se hace visible la lista con los resultados de la búsqueda
		
		if (!get_visibilidad("capaLista")) {
		        //Si la lista esta visible no se llama a visible
		      visibleLista();
		}
	}
}

function preseleccionaValores() {
	canalOnChange();
	var subacceso = get(FORMULARIO + '.hsubacceso');
	var acceso = get(FORMULARIO + '.hacceso');
	set(FORMULARIO + '.cbAcceso', [acceso]);
	accesoOnChange();
	set(FORMULARIO + '.cbSubacceso', [subacceso]);
} 


function bloquearColumna() {
	var casoUso = get(FORMULARIO+'.casoUso');
	if (casoUso !='provisiones'){
		var lacolumna=14; 
		var deshabilitado=false;  
   		listado1.tiposCol[lacolumna][8]=deshabilitado;
   		listado1.actualizaDat();
   		listado1.repinta();
 	}
}


function accionSeleccionarCliente() {

		//Abrimos un popup modal con la direccion de la LPBusquedaRapidaCliente, 
		//cuando se cierra el popup si el usuario ha seleleccionado un cliente 
		//se nos devuelven dos valores en un array. 
		//Con el segundo valor rellenamos el campo codigoCliente

        //Llamamos al proceso correspondiente Modal
        var objParams = new Object();
        var cliente = mostrarModalSICC('LPBusquedaRapidaCliente', '', objParams, null, null);	
        
        if (typeof(cliente)!='undefined') {
        	var codigoCliente = cliente[1];
        	set(FORMULARIO+'.txtCodCliente',codigoCliente);
        }
}

function canalOnChange() {
/*
*Utilizando el "<<subsystem:soporte>> RecargaCombos" pasándole los parámetros: 
*idBusiness="SEGObtenerAccesosPorCanal" 
*DTOOID (Contiene el oid del canal)
*
*- Obtenemos un "dtoSalida:DTOSalida" 
*- Con el "dtoSalida.resultado" obtenido cargamos el COMBO "acceso"
*/
	var canal =get(FORMULARIO + '.cbCanal');
	set(FORMULARIO +'.hcanal',canal);
	if (canal != ""){
		var idBusiness="SEGObtenerAccesosPorCanal";
		var dtoapc= "es.indra.sicc.dtos.seg.DTOAccesosPorCanal";		
              var oididioma = get(FORMULARIO+'.idioma');               
		recargaCombo(FORMULARIO+'.cbAcceso', idBusiness, dtoapc, [['oidIdioma',oididioma],["oidCanal", canal]]);		
	}else{
		vaciaCombo(FORMULARIO + '.cbAcceso');
		vaciaCombo(FORMULARIO + '.cbSubacceso');
	}
	
}


function accesoOnChange() {

/*Para ello utilizamos el "<<subsystem:soporte>> RecargaCombos" pasándole los parámetros: 
*idBusiness="SEGObtenerSubaccesosPorAcceso" 
*DTOOID (Contendrá el oid del Acceso seleccionado) 
*
*- Obtenemos un "dtoSalida:DTOSalida" 
*- Con el "dtoSalida.resultado" obtenido cargamos el COMBO "subAcceso	
*/
	var acceso =get(FORMULARIO + '.cbAcceso');
	set(FORMULARIO +'.hacceso',acceso);
	if (acceso!=""){		
		var idBusiness="SegObtenerSubaccesosPorAcceso";
		var dtooid = "es.indra.sicc.util.DTOOID";
		var oidpais = get(FORMULARIO+'.pais');
              var oididioma = get(FORMULARIO+'.idioma'); 
              
		recargaCombo(FORMULARIO+'.cbSubacceso', idBusiness, dtooid, [['oidPais',oidpais],['oidIdioma',oididioma],["oid", acceso]]);
		
	}else{
		vaciaCombo(FORMULARIO + '.cbSubacceso');
	}
	
}

function codigoClienteOnBlur() {
		
		//Si el campo no está vacio y el número de caracteres 
		//es menor que el valor del campo oculto longitudNumeroCliente 
		//ponemos ceros a la izquierda hasta completar el tamaño indicado por el campo oculto. 

		var codigoCliente = get(FORMULARIO+'.txtCodCliente').toString();
		
		if (codigoCliente != '') {
		       var longitudCodigoCliente = get(FORMULARIO+'.longitudCodigoCliente').toString();
		       var longitud = codigoCliente.length;
		
		       // Se rellena el código de cliente con ceros
		       var cadena = rellenaCeros(codigoCliente, longitudCodigoCliente, longitud);
		       set(FORMULARIO+'.txtCodCliente', cadena);
		}

} 
// Función que se ejecuta cuando pierde el foco el campo Importe
function importeAplicarOnBlur(FILAEVENTO) {

		//Obtenemos los separadores
		var separadorDecimales = get(FORMULARIO + '.hid_SeparadorDecimales');
		var separadorMiles = get(FORMULARIO + '.hid_SeparadorMiles');
		var numeroDecimales = get(FORMULARIO + '.hid_NumeroDecimales');
		var j = FILAEVENTO;
		var tempImport = eval('listado1.form.Texto1_' +  FILAEVENTO);
		listado1.actualizaDat(); 
 		var datos = listado1.datos;
		var importe = datos[j][15];
		
		//Validamos que el valor sea correcto
		//if (importe != "" && !ValidaForm(FORMULARIO,true)) {
/*		if (importe != "" && soloNumeros(importe)) {
			alert("Debe ser numerico");
			//GestionarMensaje ('405');
			tempImport.focus();
			return false;
		}*/
		//Validamos que el valor sea correcto
		if (tempImport.value != ''){
			var resultado = ValidaMilesDecimalesNegativo(tempImport.value,10,numeroDecimales,separadorMiles,separadorDecimales,0);
			if (resultado != 'OK') {
				cdos_mostrarAlert(resultado);
				//datos[FILAEVENTO][columnaImporte] = '';
				tempImport.value= datos[j][12];
				/*listado1.setDatos(datos);
				listado1.actualizaDat();*/
				focalizaLista(FILAEVENTO);
			
				return false;
			}
		}else tempImport.value="0";
		
		//Se formatea el importe
		var formateado = formateaImporte(obtieneNumeroDecimal(tempImport.value, separadorDecimales), separadorMiles, 
		separadorDecimales);
		//datos[FILAEVENTO][columnaImporte] = formateado;
		tempImport.value=formateado;
		/*
		//Formateamos el valor
		var formateado = formateaImporte(obtieneNumeroDecimal(importe, separadorDecimales), separadorMiles, separadorDecimales);
		//datos[i][16]=formateado;
		tempImport.value=formateado;
		*/
		//Recorremos la columna importeAplicar haciendo la siguiente comprobacion: 
		//for (var i=0;i<datos.length;i++) {	
			var tempAplicar = datos[j][15];
			var tempPendiente = datos[j][12];
			var importeAplicar = obtieneNumeroDecimal(tempAplicar,separadorDecimales);
			var importePendiente = obtieneNumeroDecimal(tempPendiente,separadorDecimales);
			
			if (((parseFloat(importePendiente) >= 0) && (parseFloat(importeAplicar)<0)) || ((parseFloat(importePendiente)<=0) && (parseFloat(importeAplicar)>0))){
				//El importe pendiente tiene signo diferente a importe a aplicar
				//mostramos mensaje de aviso UICCC016 -> 1433
				GestionarMensaje ('1433');
			}
			if (((parseFloat(importePendiente)< 0) && (((parseFloat(importePendiente)) - (parseFloat(importeAplicar))) > 0)) ||
				((parseFloat(importePendiente) > 0) && (((parseFloat(importePendiente)) - (parseFloat(importeAplicar))) < 0))){
				//Si tiene un valor mayor que el del campo importe pendiente { 
	   			//ponemos en importe a aplicar el importe pendiente 
	   			//Insertamos tempPendiente porque ya esta formateado
	   		 	var temdatos = eval('listado1.form.Texto1_' +  FILAEVENTO);
	   		 	temdatos.value= formateaImporte(importePendiente, separadorMiles, separadorDecimales);
	   		 	//Si hemos tenido que cambiar algún campo { 
				//mostramos el mensaje de error CCC-0017 --> 1092(El importe a aplicar no puede ser 
				//mayor que el importe pendiente) 
				GestionarMensaje ('1092');
				temdatos.focus();
				temdatos.value=importePendiente;
				var tr = temdatos.createTextRange();
				tr.execCommand("SelectAll");			 
				return;
			}
		//}

		totalImp();
}
////////////////////////////////

function esValorNumerico(cajaTexto){
	var separadorMiles = get(FORMULARIO+'.hid_SeparadorMiles');
	var separadorDecimales = get(FORMULARIO+'.hid_SeparadorDecimales');
	
	var valor=cajaTexto.value;
	if (!soloNumeros(valor)){
		GestionarMensaje('1256');
		cajaTexto.focus();
		var tr = cajaTexto.createTextRange();
		tr.execCommand("SelectAll");
		return;
	}
	var cont=0;
	if (valor.length>0){
		for (i=0;i<valor.length;i++){
			if (valor.charAt(i)==','){
				cont = cont +1;
			}
				
		}
		if ((cont == 0)||(cont == 1)){
			var base = obtieneNumeroDecimal(valor,separadorDecimales);
			cajaTexto.value=formateaImporte(base, separadorMiles, separadorDecimales);
			//set(FORMULARIO+'.hid_'+cajaTexto,base);		
		}else {
			GestionarMensaje('1256');
			cajaTexto.focus();
			var tr = cajaTexto.createTextRange();
			tr.execCommand("SelectAll");			 
			return;
		}
		
	}
}

function soloNumeros(cantidad){
	var str=cantidad;
	var s;
	var sepMil = get(FORMULARIO+'.hid_SeparadorMiles');
	var sepDec = get(FORMULARIO+'.hid_SeparadorDecimales');
	var numero = true;
	for(var i=0;i<str.length;i++){
	       s=str.charAt(i);
	       if((s!=sepDec)&&(s!=sepMil)&&(s!='-')&&(isNaN(parseInt(s)))){
	                numero = false;
	        }
	}
	return(numero);
}

/////////////////////////////////////////


function totalImp(){
    
		var separadorDecimales = get(FORMULARIO + '.hid_SeparadorDecimales');
		var separadorMiles = get(FORMULARIO + '.hid_SeparadorMiles');
		
		//Sumamos los valores de todos los campos importeAplicar de las 
		//filas que estén seleccionadas y ponemos el resultado en la etiqueta "totalAplicar" 
		var seleccionados = listado1.codSeleccionados();

		var suma = 0;	
		for (var i=0; i < seleccionados.length; i++) {
			var codigo = seleccionados[i];
			var valor = listado1.extraeDato(codigo,14);
			var tempFormateado = obtieneNumeroDecimal(valor,separadorDecimales);
			suma = Number(suma) + Number(tempFormateado);
		}
		if(suma != '0') {
			var resultado = formateaImporte(suma, separadorMiles, separadorDecimales);
			txt_to('lbTotalAplicar',resultado);
		}else{
			txt_to('lbTotalAplicar','');
		}
}

//convierte a numero decimal una cadena con formato de miles y decimales	
function obtieneNumeroDecimal(cadena, separadorDecimales) {

	if (cadena != "") {
		//eliminar separador de miles
		if (separadorDecimales == ".") {
			cadena = cadena.replace(/,/g,'');
		} else {
			cadena = cadena.replace(/\./g,'');
			//sustituir separador decimal por punto
			cadena = cadena.replace(/,/g,'.');
		}
		return Number(cadena);
	}
	else {
		return 0;
	}
}

//Funcion que se ejecuta cuando se valida el formulario en la caja de texto de la caja
function validaImporte(valor,enteros) {
	
	//Validamos que no inserte en un formato incorrecto
	if(valor != "") {
			return ValidaMilesDecimales(valor, enteros, get(FORMULARIO + '.hid_NumeroDecimales'), get(FORMULARIO + '.hid_SeparadorMiles'), get(FORMULARIO + '.hid_SeparadorDecimales'), 0);
	}
}

//Funcion que se ejecuta cuando se pulsa el boton añadir
function accionAnadir() {
	if (listado1.numSelecc() == 0) {
		// Muestra el mensaje: "Debe seleccionar un elemento de la lista"
		GestionarMensaje('50');
	} else {
        devolverDatos();
	}
}


//formatea un decimal a cadena con separadores de miles, separador de decimales
//el número decimal debe tener la parte decimal en el formato adecuado
// Modificado por splatas - BELC300023075 - 30/05/2006
function formateaImporte(numeroDecimal, separadorMiles, separadorDecimales){
  
  var dineroEntrada = "" + numeroDecimal;
  var negativo = false;
  var decimales;
  
  if (dineroEntrada.indexOf('-') == 0) {
      dineroEntrada = dineroEntrada.replace('-', '');
      negativo = true;
  }
  
  var tokens = dineroEntrada.split('.');
  var bufferEntero = tokens[0];// almacena la parte entera.
  var bufferDinero = "";//almacena el resultado
  var bufferDecimales = "";//almacena la parte decimal
  
  if (tokens.length > 1){
      bufferDecimales = tokens[1];
     
     if( bufferDecimales.length > 2 ){ 
        
        var digito = parseInt( bufferDecimales.charAt(3) );

        if( digito > 5 ){   
            var temp = new Number( parseInt( bufferDecimales.substring(0,1) ) ); 
            temp = temp + 1;
            decimales = "" + temp;
        
        } else {
            if(bufferDecimales.charAt(2) == "0"){
              decimales = bufferDecimales.substring(0,1) ;
            } else {
              decimales = bufferDecimales.substring(0,2) ;
            }
        }
       
     } else { 
         if(bufferDecimales.charAt(2) == "0"){
            decimales = bufferDecimales.substring(0,1) ;
         } else {
            decimales = bufferDecimales.substring(0,2) ;           
         }
     }
     

  }
  
  while (bufferEntero.length > 0) {
      if (bufferEntero.length > 3) {
          bufferDinero = separadorMiles + bufferEntero.substr(bufferEntero.length-3) + bufferDinero ;
          bufferEntero = bufferEntero.substr(0, bufferEntero.length-3);
      } else {
          bufferDinero = bufferEntero.substr(0) + bufferDinero ;
          bufferEntero = "";
      }
  }
  
  if (decimales != "0" && decimales != "00" && decimales != undefined) {
      bufferDinero = bufferDinero + separadorDecimales + decimales;
  }
  
  if (negativo){
      bufferDinero = '-' + bufferDinero;
  }
  
  return bufferDinero;
}


function visibleLista() {
         
          visibilidad('capaLista','V');
          visibilidad('capaEspacio','V');
          
          DrdEnsanchaConMargenDcho('listado1',12);
		  eval (ON_RSZ);
}
function focalizaTabAux2(origen){
	//Se pulas onshtab de txtIdCuota
	//Comprobamos el estado del codigo cliente
	
	if (origen == 'txtNumDocumento'){
		if (!document.all['txtCodCliente'][0].disabled) {
			//Esta activo y le paso el foco
			focaliza(FORMULARIO + ".txtCodCliente");
		}
	    	else {
			//No activo, le paso el foco al siguiente, 
			//El boton buscar o el añadir de la lista
			if (!get_visibilidad("capaLista")) {
	         	//La lista no esta visible, pasamos al boton buscar
				document.all['btnBuscar'].focus();
			} 
			else {
				//La capa esta visible, pasamos al boton añadir
				document.all['Anadir'].focus();
			}
		}
	}else if (origen == 'btnAnadir'){
		var nombrelistado = "listado1";
		eval(nombrelistado+".preparaCamposDR()"); 
		var ultimo = listado1.datos.length - 1;
		focaliza('frmlistado1.Texto1_'+ultimo, '');
	}
}

function focalizaTabAux(origen) {
        //Funcion auxiliar para focalizar botones 
        //Si hay algun boton visible le pasamos el foco (Añadir)
        //Si no pasa al primer combo
        if (!get_visibilidad("capaLista")) {
         	//La lista no esta visible
         	//Si el origen es txtCodCliente -> focalizar el btnBuscar
        	if(origen == 'txtCodCliente') {
                  	document.all['btnBuscar'].focus();
         	}
         	//Si el origen es btnBuscar -> focalizar el codigo cliente
         	if(origen == 'btnBuscar') {
         			
         			//Pero si el codigo cliente esta readonly pasa al siguiente                  	
                  	if (!document.all['txtCodCliente'][0].disabled) {
						//Esta activo y le paso el foco
    					focaliza(FORMULARIO + ".txtCodCliente");
  					}
   				    else {
    					//No activo, le paso el foco al siguiente
    					//focaliza(FORMULARIO + ".txtIdCuota");
    					focaliza(FORMULARIO + ".txtNumDocumento");
    				}
    		}
    	}
    	else {
        	 //La lista esta visible pasamos el foco al boton correspondiente
        	 if(origen == 'btnAnadir') {
        	 		//Pero si el codigo cliente esta readonly pasa al siguiente                  	
                  	if (!document.all['txtCodCliente'][0].disabled) {
						//Esta activo y le paso el foco
    					focaliza(FORMULARIO + ".txtCodCliente");
  					}
   				    else {
    					//No activo, le paso el foco al siguiente
    					//focaliza(FORMULARIO + ".txtIdCuota");
    					focaliza(FORMULARIO + ".txtNumDocumento");
    				}
        	 }
        	 else if(origen == 'btnBuscar'){
        	 		var nombrelistado = "listado1";
        	 		eval(nombrelistado+".preparaCamposDR()"); 
             			focaliza('frmlistado1.Texto1_0', '');
             }else{
             		document.all['Anadir'].focus();
             }
    	}
}

function fLimpiar() {

	//Limpiar el formulario
	if (!document.all['cbCanal'][0].disabled) {
		//Esta activo y le limpiamos
		set(FORMULARIO+'.cbCanal','');
	}
	if (!document.all['cbAcceso'][0].disabled) {
		//Esta activo y le limpiamos
		set(FORMULARIO+'.cbAcceso','');
		set_combo(FORMULARIO+'.cbAcceso',[['','']],['']);	
	}
	if (!document.all['cbSubacceso'][0].disabled) {
		//Esta activo y le limpiamos
		set(FORMULARIO+'.cbSubacceso','');
		set_combo(FORMULARIO+'.cbSubacceso',[['','']],['']);
	}
	set(FORMULARIO+'.txtNumDocumento','');
	if (!document.all['txtCodCliente'][0].disabled) {
		//Esta activo y le limpiamos
		set(FORMULARIO+'.txtCodCliente','');
		focaliza(FORMULARIO+'.txtCodCliente');
	}else{focaliza(FORMULARIO+'.txtNumDocumento');}
	
}

function fVolver(){
         
	 //El boton volver del menu secundario estara activo
	 //cuando estemos en una ventana modal simplemente cerramos
     window.close();
}

	function muestraLista( ultima, rowset){

		var tamano = rowset.length;
		if (tamano > 0) {
			visibleLista();
			setTimeout("bloquealista()", 5);
			setTimeout("bloquearColumna()", 5);
			return true;
		} else {
			novisibleLista();
			// No se ha encontrado ningún elemento con los criterios especificados
         	//Control del foco
			    if (document.all['txtCodCliente'][0].disabled)
				{
					//Esta desactivado, deshabilito la lupa y le paso el foco al siguiente
			    	document.all['lupa'].onclick=function(){}
			    	//focaliza(FORMULARIO + ".txtIdCuota");
				focaliza(FORMULARIO + ".txtNumDocumento");
			    }
			    else {
		    		//Esta activo y le paso el foco
			    	focaliza(FORMULARIO + ".txtCodCliente");
			    }
		  	return false;
		 }
	}

	function bloquealista() {
		listado1.actualizaDat();
		for (i = 0; i < listado1.datos.length; i++) {
				if (listado1.datos[i][20] == "1") {
					listado1.desactiva(i);
				}
		}
	}


	function devolverDatos() {

		//Se obtienen los códigos de las filas seleccionadas
		var seleccionados = listado1.codSeleccionados();
		//Se actualiza el array con los datos de la lista editable
		listado1.actualizaDat();

		arrayCobros = new Array();
		for (j = 0; j < seleccionados.length; j++) {
			for (var i = 0; i < listado1.datos.length; i++) {
				if (seleccionados[j] == listado1.datos[i][0]) {
					arrayCobros[arrayCobros.length] = listado1.datos[i];
					break;
				}
			}
		}
		window.returnValue = arrayCobros;
		window.close();
	}	


function novisibleLista(){
	visibilidad('capaLista','O');
	visibilidad('capaEspacio','O');
}

function onblurNumeroDoc() {

	var nDoc = get(FORMULARIO+'.txtNumDocumento');
	if(nDoc != '' ){
		var esNumeroA=esNumero(nDoc);
              if(esNumeroA=='-1'){		
                       GestionarMensaje('747', null, null, null);
                       focaliza(FORMULARIO+'.txtNumDocumento');
                       return;			
              }		
		if (nDoc.length != 10){
			cdos_mostrarAlert(GestionarMensaje('1128')+" "+get(FORMULARIO+'.txtNumDocumento').toString());
			focaliza(FORMULARIO +'.txtNumDocumento');
		}
	}
}

function focalizaSiguiente(FILAEVENTO, TECLAEVENTO){
	if (FILAEVENTO == listado1.datos.length-1 && TECLAEVENTO == 9) {
		if (!errorNoEnteroEnLista(listado1,FILAEVENTO,15))   { 
			document.body.focus();
			setTimeout("document.all['Anadir'].focus();",5);
		}
	}
}



function focalizaAnterior(FILAEVENTO, TECLAEVENTO){
	if (TECLAEVENTO == 9 && FILAEVENTO == 0) {
		if (!errorNoEnteroEnLista(listado1,FILAEVENTO,15))   { 
			document.body.focus();
			setTimeout("document.all['btnBuscar'].focus();",5);
		}
	}
}

function vaciaCombo(combo){
 set_combo(combo,[['','']],['']);
}

function errorNoEnteroEnLista(lista,fila,columna)   {//Esta función solo valida, no focaliza ni da mensajes de error 
   		var i = fila; 
   		lista.actualizaDat(); 
   		var datos = lista.datos; 
   		var valor = datos[i][columna]; 
   		if (valor.toString() != "") { 
	      		var val = allTrim(valor); 
	      		if ((ValidaInt(val.toString(),10000, 0)!="OK")) {
	          		return true; 
	          	}
      		}
   		return false; 
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
