var varNoLimpiarSICC = true;

function fLimpiar() {   	  

	set('frmFichero.accion','');
    set('frmFichero.conectorAction','LPCargaListaClientes');
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
		
	set("frmFichero.msgCodigoPaisVacio", GestionarMensaje("error.codigoPaisVacio"));	
	set("frmFichero.msgCodigoClienteVacio", GestionarMensaje("error.codigoClienteVacio"));
	set("frmFichero.msgUnidadesVacio", GestionarMensaje("error.unidadesVacio"));
	set("frmFichero.msgNoRegistroFila", GestionarMensaje("error.noRegistroFila"));
	set("frmFichero.msgPaisNoActivo", GestionarMensaje("error.paisNoActivo"));
	set("frmFichero.msgNoExisteConsultora", GestionarMensaje("error.noExisteConsultora"));
	set("frmFichero.msgNoFormatoNumeroUnidades", GestionarMensaje("error.noFormatoNumeroUnidades"));		
	set("frmFichero.msgDuplicados", GestionarMensaje("error.existenDuplicados"));
}


// Funcion que nueve el archivo. 
function processFile(file) {	
	if (get("frmFichero.conectorAction")==''){
		set("frmFichero.conectorAction","LPCargaListaClientes");
	}	
	set("frmFichero.seleccion",file);
	set("frmFichero.accion","procesar");
	enviaSICC("frmFichero");
}

function aceptar() {
    set('frmFichero.accion','aceptar');
    set('frmFichero.conectorAction','LPCargaListaClientes');
    enviaSICC('frmFichero');
}

function cancelar() {
    set('frmFichero.accion','cancelar');
    set('frmFichero.conectorAction','LPCargaListaClientes');
    enviaSICC('frmFichero');
}
