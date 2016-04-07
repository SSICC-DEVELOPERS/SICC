var varNoLimpiarSICC = true;

function fLimpiar() {   	  

	set('frmFichero.accion','');
    set('frmFichero.conectorAction','LPCargaListaRegionZonas');
    enviaSICC('frmFichero');
}


function fmCargarBarra() {

	configurarMenuSecundario("frmFichero");
	fMostrarMensajeError();
	fichero1.focaliza();
	
	var hidValido = get("frmFichero.hidValido");
	if (hidValido == "1") {
		document.getElementById("lblFormatoArchivoInvalido").style.visibility = "hidden";
	}
	else {
		document.getElementById("lblFormatoArchivoValido").style.visibility = "hidden";
		document.all["AceptarDiv"].style.visibility='hidden';
	}	

	set("frmFichero.msgCodigoRegionVacio", GestionarMensaje("error.codigoRegionVacio"));	
	set("frmFichero.msgCodigoZonaVacio", GestionarMensaje("error.codigoZonaVacio"));
	set("frmFichero.msgUnidadesVacio", GestionarMensaje("error.unidadesVacio"));
	set("frmFichero.msgNoRegistroFila", GestionarMensaje("error.noRegistroFila"));
	set("frmFichero.msgNoExisteRegion", GestionarMensaje("error.noExisteRegion"));
	set("frmFichero.msgNoExisteZona", GestionarMensaje("error.noExisteZona"));
	set("frmFichero.msgNoFormatoNumeroUnidades", GestionarMensaje("error.noFormatoNumeroUnidades"));
	
}


// Funcion que nueve el archivo. 
function processFile(file) {	
	if (get("frmFichero.conectorAction")==''){
		set("frmFichero.conectorAction","LPCargaListaRegionZonas");
	}	
	set("frmFichero.seleccion",file);
	set("frmFichero.accion","procesar");
	enviaSICC("frmFichero");
}

function aceptar() {
	var numRegistrosError = get("frmFichero.lbldtNumRegistrosError");
	
    if(numRegistrosError>0) {           
	  if(!GestionarMensaje("carga.valido.errores", null, null, null)) {
   	  	return;
      }
	}else{
	  if(!GestionarMensaje("carga.valido.valido", null, null, null)) {
	  	return;
	  }            
	 }
	
    set('frmFichero.accion','aceptar');
    set('frmFichero.conectorAction','LPCargaListaRegionZonas');
    enviaSICC('frmFichero');
}

function cancelar() {
    set('frmFichero.accion','cancelar');
    set('frmFichero.conectorAction','LPCargaListaRegionZonas');
    enviaSICC('frmFichero');
}
