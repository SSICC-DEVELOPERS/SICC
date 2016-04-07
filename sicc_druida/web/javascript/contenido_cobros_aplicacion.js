var FORMULARIO = 'frmFormulario';
var nombresCampos = ['txtCodCliente|TEXT','cbCCC|COMBO'];

function onLoadPag() {
	var errDescripcion = get(FORMULARIO +'.errDescripcion');
	if (errDescripcion !='') {
		var errCodigo = get(FORMULARIO+'.errCodigo');
		var wnd = fMostrarMensajeError(errCodigo, errDescripcion);
	}
	
	if (get(FORMULARIO + '.txtCodCliente') != '') {
		focaliza(FORMULARIO + '.cbCCC'); 
	} else {
		focaliza(FORMULARIO + '.txtCodCliente');
	}
	configurarMenuSecundario(FORMULARIO);

}


//Para no dejar seleccionar un registro de la lista editable se este esta bloqueado
 function bloquealista() {
          listado1.actualizaDat();
          for (i = 0; i < listado1.datos.length; i++) {
                            if (listado1.datos[i][10] == "1") {
                                     listado1.desactiva(i);
                            }
          }
 }



// Función que se ejecuta cuando el usuario pulsa la imagen de la lupa
function accionSeleccionarCliente() {
	// Se muestra un cuadro de dialogo modal para que el usuario seleccione el
	// cliente
	var objParams = new Object();
	//var cliente = mostrarModalSICC('LPBusquedaRapidaCliente', '', objParams, null, null);
	//var codigoCliente = cliente[1];
	// Se rellena el campo de texto codigo de cliente con el seleccionado por
	// el usuario
	
	
	var cliente = mostrarModalSICC("LPBusquedaRapidaCliente", "", objParams, null, null);
	if (typeof(cliente)!='undefined') {
		var codigoCliente = cliente[1];
		set(FORMULARIO+'.txtCodCliente',codigoCliente);
	}
}


// Función que se ejecuta cuando se pulsa el botón Buscar
function accionBuscar() {
    var codigoCliente = get(FORMULARIO+'.txtCodCliente');
    var cuentaCorriente = get(FORMULARIO+'.cbCCC');
    var empresa = get(FORMULARIO+'.empresa');
    var idioma = get(FORMULARIO+'.idioma');
    var pais = get(FORMULARIO+'.pais');
    txt_to('lbTotalAplicar','');
   
    if (codigoCliente == "" && cuentaCorriente == "") {
		cdos_mostrarAlert(GestionarMensaje('1347',1));
		focaliza(FORMULARIO +'.txtCodCliente');
	} else {
    
    		
    		var DTOBuscarCuotasPendientes='es.indra.sicc.dtos.ccc.DTOBuscarCuotasPendientes';
    		
    		configurarPaginado(mipgndo, 'CCCBuscarCuotasPendientes', 'ConectorBuscarCuotasPendientes', 
			DTOBuscarCuotasPendientes, 
			[['codigoCliente', codigoCliente], 
			['cuota', cuentaCorriente], 
			['empresa', empresa], 
			['oidIdioma',idioma], 
			['oidPais',pais] ]);
	
		
                     visibleLista();
	}
	
}


// Función que se ejecuta cuando se pulsa el botón Añadir
function accionAnyadir() {
	
	if (listado1.numSelecc() == 0) {
		// Muestra el mensaje: "Debe seleccionar un elemento de la lista"
		GestionarMensaje('50');
	} else {
		
		
		var result = new Array();
		
		//desbloqueaFilasNoSeleccionadas();
	//}
	/*if (listado1.numSelecc() != 0 ) {
		var result[listado1.numSelecc()];
		alert('sdf');
	*/
		var codSeleccion = new String(listado1.codSeleccionados()); 
		var seleccionados =  codSeleccion.split(',');                      
		var datosLista = listado1.datos;
		var fila = new Array();
		
		for (i = 0; i < seleccionados.length; i++) {
			
			for (j = 0; j < datosLista.length; j++) {
	  			fila = datosLista[j];
  				if(fila[0]== seleccionados[i]){
  					result[i] = fila;		
				}
			}
		}
		window.returnValue = result;
		window.close();
	}
}



// Función que se ejecuta cuando pierde el foco el campo Importe
function importeAplicarOnBlur(FILAEVENTO) {
	var columnaImporte = 8;
	var columnaImporteCuota = 7; //importeAplicar
	var i = FILAEVENTO;
	
	// Se obtienen los separadores
	var separadorDecimales = get(FORMULARIO + '.hid_SeparadorDecimales');
	var separadorMiles = get(FORMULARIO + '.hid_SeparadorMiles');
	var numeroDecimales = get(FORMULARIO + '.hid_NumeroDecimales');
	
	// Se obtienen los datos de la lista editable
	listado1.actualizaDat();
	var datos = listado1.datos;
	//var importe = datos[FILAEVENTO][columnaImporte];
	var importe = eval('listado1.form.Texto1_'+FILAEVENTO);
	
	//Validamos que el valor sea correcto
	if (importe.value != ''){
		var resultado = ValidaMilesDecimalesNegativo(importe.value,10,numeroDecimales,separadorMiles,
			separadorDecimales,0);
		if (resultado != 'OK') {
			cdos_mostrarAlert(resultado);
			//datos[FILAEVENTO][columnaImporte] = '';
			importe.value=datos[i][columnaImporteCuota];
			/*listado1.setDatos(datos);
			listado1.actualizaDat();*/
			focalizaLista(FILAEVENTO);			
			return false;
		}
	}else importe.value=datos[i][columnaImporteCuota];
	
	// Se formatea el importe
	var formateado = formateaImporte(obtieneNumeroDecimal(importe.value, separadorDecimales), separadorMiles, 
		separadorDecimales);
	//datos[FILAEVENTO][columnaImporte] = formateado;
	importe.value=formateado;
	
	var tempImporte = datos[i][columnaImporte];
	var tempCuota = datos[i][columnaImporteCuota];
	var importeAplicar = obtieneNumeroDecimal(tempImporte,separadorDecimales);
	var importeCuota = obtieneNumeroDecimal(tempCuota,separadorDecimales);

	if (((parseFloat(importeCuota) >= 0) && (parseFloat(importeAplicar)<0)) || ((parseFloat(importeCuota)<=0) && (parseFloat(importeAplicar)>0))){
			var temdatos = eval('listado1.form.Texto1_' +  FILAEVENTO);
			//El importe pendiente tiene signo diferente a importe a aplicar
			//mostramos mensaje de aviso UICCC016 -> 1433
			temdatos.focus();
			temdatos.value=importeCuota;
			var tr = temdatos.createTextRange();
			tr.execCommand("SelectAll");			 
			GestionarMensaje ('1433');
		return;
	}

	if (((parseFloat(importeCuota)< 0) && (((parseFloat(importeCuota)) - (parseFloat(importeAplicar))) > 0)) ||
				((parseFloat(importeCuota) > 0) && (((parseFloat(importeCuota)) - (parseFloat(importeAplicar))) < 0))){				
		var temdatos = eval('listado1.form.Texto1_' +  FILAEVENTO);
		//Si hemos tenido que cambiar algún campo { 
		//mostramos el mensaje de error CCC-0017 --> 1092(El importe a aplicar no puede ser 
		//mayor que el importe pendiente) 
		GestionarMensaje ('1092');
		temdatos.focus();
		temdatos.value=importeCuota;
		var tr = temdatos.createTextRange();
		tr.execCommand("SelectAll");			 
		return;
	}
	
	recalcular();
}


function recalcular(){
	listado1.actualizaDat();
	var seleccionados =  listado1.codSeleccionados();
	
	// Se obtienen los separadores
	var separadorDecimales = get(FORMULARIO + '.hid_SeparadorDecimales');
	var separadorMiles = get(FORMULARIO + '.hid_SeparadorMiles');
	var numeroDecimales = get(FORMULARIO + '.hid_NumeroDecimales');
	
	var sumaImporte = 0;
	for (var i=0;i<seleccionados.length; i++) {
		var codigo = seleccionados[i];		
		var tempImporte = listado1.extraeDato(codigo,7);
		
		if (tempImporte != ''){
			var importeAplicar = obtieneNumeroDecimal(tempImporte,separadorDecimales);
		}else var importeAplicar=tempImporte;
		if (importeAplicar != '') {
			sumaImporte += Number(importeAplicar);
		}
	}
	
	// Se muestra el importe total
	var resultado = formateaImporte(sumaImporte, separadorMiles, separadorDecimales);
	txt_to('lbTotalAplicar',resultado);
	
}

// Función que se ejecuta cuando pierde el foco el campo Codigo de cliente
function codigoClienteOnBlur() {
	var codigoCliente = get(FORMULARIO+'.txtCodCliente');
	if (codigoCliente != '') {
		var longitudCodigoCliente = get(FORMULARIO+'.longitudCodigoCliente');
		var longitud = codigoCliente.length;
		
		// Se rellena el código de cliente con ceros
		var codigoClienteCeros = rellenaCeros(codigoCliente,longitudCodigoCliente,
			longitud);
		set(FORMULARIO+'.txtCodCliente',codigoClienteCeros); 
	}	
}

// Muestra la capa que contiene la lista con los resultados
function visibleLista() {

	visibilidad('capaLista','V');
	visibilidad('capaImporte','V');
         
	DrdEnsanchaConMargenDcho('listado1',10);
	eval (ON_RSZ);  
}

// Oculta la capa que contiene la lista con los resultados
function novisibleLista() {
	visibilidad('capaLista','O');
	visibilidad('capaImporte','O');
         
}

function fLimpiar() {
	txt_to('lbTotalAplicar','');
	for (var i=0; i<nombresCampos.length;i++){
		var campo = FORMULARIO+'.'+nombresCampos[i].split('|')[0];
		
		switch(nombresCampos[i].split('|')[1]){
			case "COMBO":		
					set(campo,0);
					break;			
			case "TEXT":
				set(campo,"");
				break;
		}
	}
	
	set(FORMULARIO+'.txtCodCliente', get(FORMULARIO+'.codCliente'));
	if (get(FORMULARIO+'.codCliente') != '') {
		set(FORMULARIO + '.cbCCC', ['']);
		focaliza(FORMULARIO + '.cbCCC'); 
	} else {
		focaliza(FORMULARIO + '.txtCodCliente');	
	}	
}

function fVolver() {
	window.close();
}


function validaImporte(valor,enteros) {
	//Validamos que no inserte en un formato incorrecto
	if (valor != '') {
			return ValidaMilesDecimalesNegativo(valor, enteros, get(FORMULARIO + '.hid_NumeroDecimales'), 
				get(FORMULARIO + '.hid_SeparadorMiles'), get(FORMULARIO + '.hid_SeparadorDecimales'), 0);
	}
}
	
function muestraLista(ultima, rowset) {
	var tamano = rowset.length;
	if (tamano > 0) {
	       visibleLista();
	       setTimeout("bloquealista()", 5);
	       return true;
	} else {
		novisibleLista();
		// No se ha encontrado ningún elemento con los criterios especificados
		//Control del foco
		if (document.all['txtCodCliente'][0].disabled)
		{
			//Esta desactivado, deshabilito la lupa y le paso el foco al siguiente
			//document.all['imgBuscarCliente'].onclick=function(){}
			//focaliza(FORMULARIO + ".txtIdCuota");
			focaliza(FORMULARIO + ".cbCCC");
		}else {
			//Esta activo y le paso el foco
			focaliza(FORMULARIO + ".txtCodCliente");
		}
		return false;
	}

	
	
	
	/*var tamano = rowset.length;
	if (tamano > 0) {
		visibleLista();
		bloquealista();
		return true;
	} else {
		novisibleLista();
		focaliza(FORMULARIO+'.txtCodCliente','');
		return false;
	}*/
}

	
/*

	function desbloqueaFilasNoSeleccionadas() {
		//Creamos un DTOOIDs con los oids de Mov.CC. 
		//idBusiness = "CCCEliminarBloqueosMovCC" 
		//Llamamos al "ConectorEliminarBloqueosMovCC" con el dto y el idBusiness 
			
		 var codSelecc = new String(listado1.codSeleccionados());
                  var  codigosSeleccionados = codSelecc.split(',');
                  var cods = new String(listado1.codigos());
                  var codigos = cods.split(',');
                  var filasADesbloquear = new Array();
                  listado1.actualizaDat();
                  for (j = 0; j < codigos.length; j++) {
                           var anyadir = true;
                           if (listado1.datos[j][10] == "1") {
                                    anyadir = false;
                           } else {
                                    for (i = 0; i < codigosSeleccionados.length; i++) {
                                    /*
                                    alert ("DATOS LINEA["+j+"]: "+ listado1.datos[j]);
                                    alert ("CAMPO BLOQUEADO 20:"+ listado1.datos[j][20]);
                                    alert ("CODIGOS["+j+"]: "+codigos[j]+" == "+codigosSeleccionados[i]+" :COD SELECC["+i+"] || LISTADO1.DATOS["+j+"][20]: "+listado1.datos[j][20]+" == 1");
                                    *//*
                                             if ((codigos[j] == codigosSeleccionados[i])) {
                                                      anyadir = false;
                                                      break;                                        
                                             } //else filasADesbloquear[filasADesbloquear.length] = codigos[j];
                                    }
                           }
                           if (anyadir) filasADesbloquear[filasADesbloquear.length] = codigos[j];
                  }
                  

                  if (filasADesbloquear.length > 0) {
                           //desbloquear filas
                          desbloqueaFilas(filasADesbloquear, "CCCEliminarBloqueosMovBanc", "ConectorEliminarBloqueosMovBanc", "filasDesbloqueadas(datos)");
                           devolverDatos();
                  }
				
	}

	function desbloqueaFilas(oids, idBusiness, conector, funcionSalida) {
		//Formamos una cadena con los elementos que se van a eliminar
			
		asignar([["TEXT", "", conector, "resultado", formarCadenaDesbloquear(oids, idBusiness), funcionSalida]]);
	}

	function formarCadenaDesbloquear(oids, idBusiness) {
		var i;
		var cadena;
		
		cadena = idBusiness + '|';
		for (i=0; i<oids.length; i++) {
       		cadena = cadena + oids[i];
       		if (i != oids.length -1) {
       		cadena = cadena + ",";
       		}		
		}
		return cadena;	
	}

	  function filasDesbloqueadas(datos) {
                  //Función que se ejecuta cuando se pulsa el botón Añadir function accionAnyadir() tras desbloquear filas {
                  //Si hemos recibido un mensaje como resultado de la operación lo mostramos
                  var mensajeError = "";
                  if(datos != null && (typeof(datos)).toUpperCase() == "OBJECT") {
                           mensajeError  = datos[0];
                  }else if(datos != null && (typeof(datos)).toUpperCase() == "STRING") {
             	mensajeError = datos;
                  }
                  if (mensajeError != "") {
                           mostrarErrorSubsistema(mensajeError);
                           return false;
                  } 
                  //devolverDatos();
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
*/	
	function ontabBuscar(){
		var nombrelistado= "listado1";
         	var nombreCajaText= "Texto1";
         	listado1.actualizaDat();
         	var datosLista = listado1.datos; 
		if(get_visibilidad("capaLista")){
			eval(nombrelistado+".preparaCamposDR()"); 
                  	focaliza('frm'+nombrelistado+'.'+nombreCajaText+'_'+0,'');
		}else{
			if (get(FORMULARIO+'.codCliente') != '') {
				focaliza(FORMULARIO + '.cbCCC'); 
			} else {
				focaliza(FORMULARIO + '.txtCodCliente');	
			}
		}	
	}
	
	function onshtabCliente(){
		if(get_visibilidad("capaLista")){
			document.all['Anadir'].focus();
		}else{
			document.all['btnBuscar'].focus();
		}	
	}
	
	function onshtabCb() {
		if (get(FORMULARIO+'.codCliente') != '') {
			if(get_visibilidad("capaLista")){
				document.all['Anadir'].focus();
			}else{
				document.all['btnBuscar'].focus();
			}
		} else {
			focaliza(FORMULARIO + '.txtCodCliente');	
		}
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

	
	function focalizaSig(FILAEVENTO,TECLAEVENTO){
        	if (FILAEVENTO == listado1.datos.length-1 && TECLAEVENTO == 9) {
        		if (!errorNoEnteroEnLista(listado1,FILAEVENTO,8))   { 
        			document.body.focus();
					setTimeout("document.all['Anadir'].focus();",5);
				}
		}
	}

	function focalizaAnt(FILAEVENTO,TECLAEVENTO){
         	if(FILAEVENTO == 0 && TECLAEVENTO == 9) {
         		if (!errorNoEnteroEnLista(listado1,FILAEVENTO,8))   { 
                  	document.body.focus();
                  	setTimeout("document.all['btnBuscar'].focus();",5);
                }
         	}
	}

	function anteriorAnyadir(){
		var nombrelistado= "listado1";
         	var nombreCajaText= "Texto1";
         	listado1.actualizaDat();
         	var fila= listado1.datos.length-1;
         	eval(nombrelistado+".preparaCamposDR()");
                focaliza('frm'+nombrelistado+'.'+nombreCajaText+'_'+fila,'');
	}
	
	function siguienteAnyadir(){
		if(document.getElementById('txtCodCliente').disabled){
			focaliza(FORMULARIO+'.cbCCC');
		}else{
			focaliza(FORMULARIO+'.txtCodCliente');
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
	