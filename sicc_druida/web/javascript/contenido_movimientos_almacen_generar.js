var FORMULARIO = "formulario";
//varNoLimpiarSICC = true; no hace falta


function onLoadPag() {
	
	if (get(FORMULARIO+'.errDescripcion')!='') {                    
                  var wnd = fMostrarMensajeError(get(FORMULARIO+'.errCodigo'),get(FORMULARIO+'.errDescripcion'));
	}	
	
	DrdEnsanchaConMargenDcho("listado1", 12);
	eval (ON_RSZ);
	
	// pasar el foco al primer control de la pagina
	focaliza(FORMULARIO + ".cbMarca");
	
	//Visibilizar el combo AlmacenDestino si procede
	if (get(FORMULARIO + ".visualizarAlmacenDestino") == 'true') {
		document.all["almacenDestinoLabel"].style.visibility = 'visible';
		document.all["almacenDestino"].style.visibility = 'visible';
	}
	
	//Preseleccion de valores
	var marca = get(FORMULARIO + ".hid_marca"); //marca seleccionada por el usuario
	
	if ( marca == '') {
		marca = get(FORMULARIO + ".marca"); //marca por defecto
	} else {
		// se hacen visibles las 2 capas
		hacerVisibleCapa('capa1');
		hacerVisibleCapa('capaLista');
	}

	if ( marca != '')
		set(FORMULARIO + ".cbMarca", [marca]);


	var tipoMov = get(FORMULARIO + ".hid_tipoMovimiento"); //tipo movimiento seleccionado por el usuario
	if ( tipoMov != '') 
		set(FORMULARIO + ".cbTipoMovimiento", [tipoMov]);
        
   //-> cuando carga la pagina toma el el valor seteado en hid_FechaUsu y se lo asigna a formulario.txtFecha
   var fechaUsu = get(FORMULARIO + ".hid_FechaUsu"); //tipo movimiento seleccionado por el usuario

   if ( fechaUsu != ''){
        set(FORMULARIO + ".txtFecha", fechaUsu);
   }
				
	// configurar el menu secundario	ññññ
	configurarMenuSecundario(FORMULARIO);
}
	
	function fGuardar() {

	if (!validaFechaGuardar('txtFecha')) return false;		
	if (!validaNumeroDocumentoGuardar()) return false;		
		
		//añadido por incidencia BELC300007725
		if (get(FORMULARIO + ".visualizarAlmacenDestino") == 'true') {
			sicc_cambiar_estado("cbAlmacenDestino", true);
		}else{
			sicc_cambiar_estado("cbAlmacenDestino", false);
		}
		

		var movimientosDetalles = "";
		listado1.actualizaDat(); //Actualiza el array 'datos'
		var datosFinal = listado1.datos;
		if (validarDatos(datosFinal)) {
		
			for (i = 0; i < datosFinal.length; i++) {
				var fila = datosFinal[i];
				
				for (j = 0; j < fila.length; j++) {
					if(fila[j] == "") fila[j] = "-";
					if (j == 3 || j == 4 ){
		
						if (fila[j] != "-"){
							movimientosDetalles += obtieneNumeroDecimal(fila[j], get(FORMULARIO + '.hid_SeparadorDecimales')) + "@";
						}else{
							movimientosDetalles+="*@";
						}
					}else if (j == 2 ){
						movimientosDetalles += obtieneNumeroEntero(fila[j], get(FORMULARIO + '.hid_SeparadorMiles')) + "@";
					}else if (j != 1){
						movimientosDetalles += fila[j] + "@";
					}
				} 
				movimientosDetalles += "#";
			}
			
			set(FORMULARIO + '.detalles', movimientosDetalles);
		
			// llama a la LPGenerarMovimientosAlmacen con acción = "guardar"
			set(FORMULARIO + ".accion", "guardar");
			if (sicc_validaciones_generales()) {
				
				formulario.oculto = 'S';
				
				enviaSICC(FORMULARIO);
				
			}
		}
	}


function accionAceptar() {
	
	// llama a la lp LPGenerarMovimientosAlmacen con acción = "aceptar" en un envío en oculto 
	set(FORMULARIO + ".accion", "aceptar");
	set(FORMULARIO + ".descTipoMovimientoAlmacen", get(FORMULARIO + ".cbTipoMovimiento", "T"));
	
	
	if (sicc_validaciones_generales("grupo1")) { 
		formulario.oculto = 'N';
		//enviaSICC(FORMULARIO); 
		enviaSICC(FORMULARIO,null,null,'N');
	}
}


function accionAnadir() {
	
	// Abrir una ventana Modal haciendo una llamada a la LPGenerarMovimientosAlmacen con acción = "añadir" 
	// Recuperar arreglo con los datos "oid", "producto" (descripción del combo de productos), cantidad, 
	// precioVentaNeto y precioContable
	set(FORMULARIO + ".accion", "anadir");
	var objParams = new Object();
 
    var datosIntroducidos = mostrarModalSICC('LPGenerarMovimientosAlmacen', 'anadir', objParams, null, null);
	if (typeof(datosIntroducidos) != 'undefined') {
          
    


	
	// añadir nueva línea con estos datos a la lista editable "grupoDetalle" 
	// si no existe ya un producto con el mismo oid en la lista, en cuyo caso se suma la cantidad recibida 
	// a la cantidad del registro que ya existe en la lista editable.
	oid = datosIntroducidos[0];

	var listaOIDs = listado1.codigos();
	
	var yaExiste = "N";
	
	for (var i=0; i < listaOIDs.length; i++) {
		if (listaOIDs[i] == oid) {
			yaExiste = "S";
			break;
		}
	}
	
	listado1.actualizaDat(); //Actualiza el array 'datos'

	if (yaExiste == "N") {
		listado1.insertar(datosIntroducidos); 
		
	} else {
		// cantidad es la columna 2 en la lista editable y es el tercer elemento del array devuelto al cerrar ventana modal
		/*var cantidadActual = listado1.extraeDato(oid, 1);
		alert('cantidadActual: ' + cantidadActual);
		var cantidadNueva = parseInt(cantidadActual) + parseInt(datosIntroducidos[2]);
		alert('cantidadNueva: ' + cantidadNueva);*/
		
		var cantidadActual=listado1.extraeDato(oid, 1);
		//la formateamos para quitarle el separador de miles
		cantidadActual=obtieneNumeroDecimal(cantidadActual,get(FORMULARIO + '.hid_SeparadorDecimales'));
		
		var cantidadNueva=datosIntroducidos[2];
		//la formateamos para quitarle el separador de miles
		cantidadNueva=obtieneNumeroDecimal(cantidadNueva,get(FORMULARIO + '.hid_SeparadorDecimales'));
		
		var suma=cantidadActual + cantidadNueva;
		
		//lo formateamos para ponerle el separador de miles
		suma=formateaImporte(suma,get(FORMULARIO + '.hid_SeparadorMiles'),get(FORMULARIO + '.hid_SeparadorDecimales'));
		
		listado1.insertaDato(oid, 1, suma.toString());
	}
}
}


function limpiarCabecera() {
	if (get(FORMULARIO + ".txtFecha") != '')
		set(FORMULARIO + ".txtFecha", "");
	if (get(FORMULARIO + ".txtNumDocumento") != '')
		set(FORMULARIO + ".txtNumDocumento", "");
	vaciaCombo(FORMULARIO + ".cbAlmacenOrigen");
	vaciaCombo(FORMULARIO + ".cbAlmacenDestino");
	if (get(FORMULARIO + ".atxtObservaciones") != '')
		set(FORMULARIO + ".atxtObservaciones", "");
	document.all["almacenDestinoLabel"].style.visibility = 'hidden';
	document.all["almacenDestino"].style.visibility = 'hidden';
}


function limpiarInicio() {
	var marca = get(FORMULARIO + ".marca"); //marca por defecto
	if ( marca != '') 
		set(FORMULARIO + ".cbMarca", [marca]);
	set(FORMULARIO + ".cbTipoMovimiento", ['']);
}


	function validarDatos(lista) {
    	if (lista.length == 0) {
			//AÑADIDO POR INCIDENCIA 7702
			// Muestra el mensaje: "El Grupo Detalle debe contener al menos una línea" (BEL-0004)
			cdos_mostrarAlert(GestionarMensaje('1371'));
			return false;
		}
    	return true;
	}


function vaciaCombo(combo) {
    if (eval('document.'+combo) != undefined) 
        set_combo(combo, [['','']], ['']);
    return true;
}

function limpiarLista() {
	var datos = new Array();
   	listado1.setDatos(datos);
   	listado1.reajusta();
}


function validaFecha(nombreElemento) {
	var fecha = get(FORMULARIO + '.' + nombreElemento);
    if (fecha != '') {
    	var resul = EsFechaValida(fecha,fecha, FORMULARIO,null);
	 	if(resul==1 || resul==2){  
        	cdos_mostrarAlert(GestionarMensaje('1395', get(FORMULARIO+'.hFormatoFechaPais'))); 
			focaliza(FORMULARIO+'.'+nombreElemento);
			return false;
		} 	
	}
	return true;
}

         //valida la fecha si el campo es modificable y no vacío 
         function validaFechaGuardar(fecha) {
                  if(eval(FORMULARIO + '.' + fecha + 'RO') != "S"){
                           if (get(FORMULARIO + '.' + fecha).toString() != "") {
                                    var resul = EsFechaValida(get(FORMULARIO + '.'+fecha),get(FORMULARIO + '.' + fecha), FORMULARIO,null);
          							if(resul == 1 || resul == 2) {  
                                             document.body.focus();
                                             return false;
                                    }
                           }        			
                  }
                  return true;
         }


function validaNumeroDocumentoGuardar() {
	
	var numero = get(FORMULARIO + '.txtNumDocumento');
	
	set(FORMULARIO + '.txtNumDocumento', numero.toUpperCase());
	
	if (numero!='' && numero.length != 10) {
		document.body.focus();
        return false;
	}
	return true;
}



function validaNumeroDocumento() {
	
	var numero = get(FORMULARIO + '.txtNumDocumento');
	
	set(FORMULARIO + '.txtNumDocumento', numero.toUpperCase());
	
	if (numero!='' && numero.length != 10) {
    	// Muestra el mensaje: El numero de documento introducido no tiene 10 caracteres
		cdos_mostrarAlert(GestionarMensaje('1128', FORMULARIO+'.txtNumDocumento'));
        focaliza(FORMULARIO+'.txtNumDocumento');
        return false;
	}
	return true;
}





function hacerVisibleCapa(nombreCapa) {
	//alert('visible');
	visibilidad(nombreCapa, 'V');
	
	//DrdEnsanchaConMargenDcho('listado1', 12);
	
	eval (ON_RSZ);
}


function focalizaShiftTabCbMarca() {
	if (get_visibilidad('capa1') == true) {
		document.all['btnAnadir'].focus();
	} else {
		document.all['btnAceptar'].focus();
	}	
}


function focalizaTabBtnAceptar() { 
	
	if (get_visibilidad('capa1') == true) {
		
		//document.all['txtFecha'].focus();
		focaliza(FORMULARIO + ".txtFecha");
	} else {
		
		focaliza(FORMULARIO + ".cbMarca");	
	}
}

function focalizaTabAreaObservaciones() {
	//para que desde el campo observaciones tabule al boton añadir
	//focaliza(FORMULARIO + ".btnAnadir");	
	document.all['btnAnadir'].focus();
}

function focalizaShiftBtnAnadir(){
	//para que desde el boton añadir tabule a observaciones
	focaliza(FORMULARIO + ".atxtObservaciones");
}

function fLimpiar() {

	focaliza(FORMULARIO + ".cbMarca");
	ocultarCapa('capa1');
	ocultarCapa('capaLista');
	
	limpiarInicio();
	limpiarLista();	
	limpiarCabecera();
	
	//Preseleccion de valores
	var marca = get(FORMULARIO + ".hid_marca"); //marca seleccionada por el usuario
	
	if ( marca == '') {
		marca = get(FORMULARIO + ".marca"); //marca por defecto
	}

	if ( marca != '')
		set(FORMULARIO + ".cbMarca", [marca]);
	
}

function ocultarCapa(nombreCapa) {
	visibilidad(nombreCapa, 'O');
}

	//convierte a numero decimal una cadena con formato de miles y decimales
	function obtieneNumeroDecimal(cadena, separadorDecimales) {
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
         
	//convierte a numero decimal una cadena con formato de miles y decimales
	function obtieneNumeroEntero(cadena, separadorMiles) {
		//eliminar separador de miles
		if (separadorMiles == ",")
			cadena = cadena.replace(/,/g,'');
		else
			cadena = cadena.replace(/\./g,'');
		return Number(cadena);
	}         

	function fBorrar() {
		//Quitamos las filas seleccionadas de la lista que esté mostrandose en primer plano (miramos la variable oculta listaVisible) 
		if (listado1.numSelecc() > 0 )
			listado1.eliminarSelecc();
		else
			GestionarMensaje('50');
	}   
	
//formatea un decimal a cadena con separadores de miles, separador de decimales
//el número decimal debe tener la parte decimal en el formato adecuado
 function formateaImporte(numeroDecimal, separadorMiles, separadorDecimales){
          var dineroEntrada = "" + numeroDecimal;
          var negativo = false;
          if (dineroEntrada.indexOf('-') == 0) {
                   dineroEntrada = dineroEntrada.replace('-', '');
                   negativo = true;
          }
          var tokens = dineroEntrada.split('.');
          var bufferEntero = tokens[0];// almacena la parte entera.
          var bufferDinero = "";//almacena el resultado
          var bufferDecimales = "";//almacena la parte decimal
          if (tokens.length > 1)
                   bufferDecimales = tokens[1];

          while (bufferEntero.length > 0) {
                   if (bufferEntero.length > 3) {
                            bufferDinero = separadorMiles + bufferEntero.substr(bufferEntero.length-3) + bufferDinero ;
                            bufferEntero = bufferEntero.substr(0, bufferEntero.length-3);
                   } else {
                            bufferDinero = bufferEntero.substr(0) + bufferDinero ;
                            bufferEntero = "";
                   }
          }
          if (bufferDecimales != "") {
                   if (bufferDecimales != "0" && bufferDecimales != "00") {
                            bufferDinero = bufferDinero + separadorDecimales + bufferDecimales;
                   }
          }
          if (negativo)
                            bufferDinero = '-' + bufferDinero;
          return bufferDinero;
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
 }
 
 function accionEjecutada() {
	fLimpiarGenericoSICC();
 	fLimpiar(); 	
}
