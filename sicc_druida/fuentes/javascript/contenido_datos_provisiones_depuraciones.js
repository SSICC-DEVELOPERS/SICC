var FORMULARIO = 'frmCapturarCupon';
var hayDatos; //controla si en la lista editable hay datos o no

function onLoadPag() {
	
	/*var cerrarVentana = get(FORMULARIO +'.cerrarVentana');
	if (cerrarVentana != '') {
		window.close();
	}*/
	
	// Si se ha producido algún error, se muestra un mensaje
	var errDescripcion = get(FORMULARIO+'.errDescripcion');
	if (errDescripcion !='') {
		var errCodigo = get(FORMULARIO+'.errCodigo');
		var wnd = fMostrarMensajeError(errCodigo, errDescripcion);
	}
	
	//añadido por incidencia 8813
	var oidCabecera = get(FORMULARIO+'.oidCabecera');
	var pais = get(FORMULARIO+'.pais');
	var idioma = get(FORMULARIO+'.idioma');
	configurarPaginado(mipgndo, 'CCCObtenerDetalleDepuracion', 'ConectorObtenerDetalleDepuracion', 'es.indra.sicc.dtos.ccc.DTOOIDPAG', [['oidPais',pais], ['oidIdioma', idioma],['oid',oidCabecera]]);

	
	//fin añadido incidencia
	
	/*var mensajeError = get(FORMULARIO +'.mensajeError');
	if (mensajeError == 'CCC0016' ) {
		// Muestrael mensaje: "No se puede eliminar la depuración porque no se 
		// pudieron retroceder todos los movimientos" (CCC-0016)
		cdos_mostrarAlert(GestionarMensaje('1137'));
	}*/
	configurarMenuSecundario(FORMULARIO);
}

function mensajeError() {
	window.close();
}

function visualizarBotones() {
	var casoUso = get(FORMULARIO +'.casoUso');	
	if (casoUso == 'modificarDepuracion'){
		
		/*document.all["EliminarCuotasDiv"].style.visibility='visible';
		document.all["AprobarDiv"].style.visibility='hidden';
		document.all["RechazarDiv"].style.visibility='hidden';*/
		
		if (hayDatos==1) {
			document.all["EliminarCuotasDiv"].style.visibility='visible';
		}else {
			document.all["EliminarCuotasDiv"].style.visibility='hidden';
		}
		document.all["AprobarDiv"].style.visibility='hidden';
		document.all["RechazarDiv"].style.visibility='hidden';
	} else if (casoUso == 'eliminarDepuracion') {
		
		document.all["EliminarCuotasDiv"].style.visibility='hidden';
		document.all["AprobarDiv"].style.visibility='hidden';
		document.all["RechazarDiv"].style.visibility='hidden';
	} else if (casoUso == 'aprobarRechazar') {
		
		
		if (hayDatos==1) {
			
			document.all["AprobarDiv"].style.visibility='visible';
			document.all["RechazarDiv"].style.visibility='visible';
		}else{
			
			document.all["AprobarDiv"].style.visibility='hidden';
			document.all["RechazarDiv"].style.visibility='hidden';
		}
		document.all["EliminarCuotasDiv"].style.visibility='hidden';
		
	}else{
		
		document.all["EliminarCuotasDiv"].style.visibility='hidden';
		document.all["AprobarDiv"].style.visibility='hidden';
		document.all["RechazarDiv"].style.visibility='hidden';	
	}
}

function accionAprobar() {
	
	var oidCabecera = get(FORMULARIO+'.oidCabecera');
	set(FORMULARIO+'.accion','Aprobar');
	set(FORMULARIO+'.oidCabecera',oidCabecera);
	enviaSICC(FORMULARIO);
}

function accionRechazar() {
	var oidCabecera = get(FORMULARIO+'.oidCabecera');
	set(FORMULARIO + '.accion','Rechazar');
	set(FORMULARIO+'.oidCabecera',oidCabecera);
	enviaSICC(FORMULARIO);
}

function accionEliminar() {
	//modificado por la incidencia 8813
	/*var retorno = cdos_mostrarConfirm(GestionarMensaje('1213'));
	var oids = get(FORMULARIO +'.oidCabecera');
	alert("El oidCabecera es: " + oids);
	if(retorno){
		alert("Entra eliminar fila");
		eliminarFilas(oids, "CCCEliminarDepuracion", mipgndo);
	}*/
	var retorno = cdos_mostrarConfirm(GestionarMensaje(1213)); 
	if(retorno) {
		set(FORMULARIO + '.accion','Eliminar');
		enviaSICC(FORMULARIO);
	}
}
function fBorrar(){
	accionEliminar();
}
function accionEliminarCuotas() {
	//modificado por la incidencia 8813
	if (listado1.numSelecc() == 0) {
		// Muestra el mensaje: "Debe seleccionar un elemento de la lista"
		GestionarMensaje('50');
	} else {			
		//set(FORMULARIO + '.accion','EliminarCuotas');
		var oids = listado1.codSeleccionados();
		eliminarFilas(oids, "CCCDepuracionEliminarCuotas", mipgndo);
	}
}
function fVolver(){
	window.close();
	
	
}

function muestraLista( ultima, rowset){
		
         var tamano = rowset.length;
         if (tamano > 0) {
                  visibleLista();
                  hayDatos=1;
                  
                  //setTimeout("ponerBotones()", 5); //para que se ejecute antes lo de muestra lista antes
                  visualizarBotones();
                  return true;
         } else {
                  invisibleLista();	
                  hayDatos=0;	
                  
                  //setTimeout("ponerBotones()", 5); //para que se ejecute antes lo de muestra lista antes
                  visualizarBotones();
                  return false;
         }
}
function visibleLista() {
         if (!get_visibilidad("capaLista")){
                  visibilidad('capaLista','V');
                  DrdEnsanchaConMargenDcho('listado1',12);
                  eval (ON_RSZ);  
         }
}

function invisibleLista() {
         if (get_visibilidad("capaLista")){
                  visibilidad('capaLista','O');
         }
}

/*function accionEliminarCuotas() {
	var oids ="9";
	
	var retorno = cdos_mostrarConfirm(GestionarMensaje(1213)); 
	set(FORMULARIO + '.oids',oids);
	if(retorno) {
		set(FORMULARIO + '.accion','EliminarCuotas');
		enviaSICC(FORMULARIO);
	}
}*/