var descripcion = "";

function fLimpiar() {
	onLoadPag();
}

function onLoadPag() {  
	fMostrarMensajeError();
	configurarMenuSecundario("formulario");

	if(get('formulario.hOidCentroDistribucionDefecto')!="") {
		var hidOidDefecto = get("formulario.hOidCentroDistribucionDefecto");  
        var oidSeleccionado = new Array();
        oidSeleccionado = hidOidDefecto.split(",");	    
        set("formulario.cbCentroDistribucion", oidSeleccionado);	
	}

	txt_to('lblCodigoMapaCentroDistribucionValor', get("formulario.codigoMapa")); 

	if(get("formulario.habilitoBotonMantener")=="false") {
		document.getElementById("btnMantenerMapa").disabled = true;
	}

	set("formulario.txtDescripcion", "");
	focaliza("formulario.cbCentroDistribucion");
}

function onClickCrear() {
	if(sicc_validaciones_generales()) {  
		set("formulario.oidCentroDistribucion", get("formulario.cbCentroDistribucion"));
		set("formulario.descripcion", get('formulario.txtDescripcion'));	
		descripcion = get('formulario.txtDescripcion');
		var codigoMapa = document.getElementById("lblCodigoMapaCentroDistribucionValor").innerText;
		set("formulario.codigoMapa", codigoMapa);			
		eval("formulario").oculto= "S";
		set("formulario.conectorAction", "LPMantenimientoMapaCentroDistribucion");
		set("formulario.accion", "crear");
		enviaSICC("formulario"); 
	}
}

function fGenerarOK(oid, codigoMapa) {
	set("formulario.hOidMapaGenerado", oid);
	document.getElementById("btnMantenerMapa").disabled = false;
	eval("formulario").oculto= "N";
	GestionarMensaje("APE014", descripcion, codigoMapa, null);

	// dmorello, 06/11/2007 - Por error reportado via mail
	set('formulario.conectorAction', 'LPMantenimientoMapaCentroDistribucion');
	set('formulario.accion', '');
	enviaSICC("formulario");
}

function fGenerarERR() {
	eval("formulario").oculto= "N";
}

function onClickMantener() {
	set("formulario.oidCentroDistribucion", get("formulario.cbCentroDistribucion"));
	set("formulario.hOidMapaGenerado", get('formulario.hOidMapaGenerado'));
	set("formulario.conectorAction", "LPMantenimientoMapaCentroDistribucion");
	set("formulario.accion", "mantener");
	enviaSICC("formulario"); 
}

function onTabComboCentro() {
	focaliza("formulario.txtDescripcion");
}

function onTabDescripcion() {
	focalizaBotonHTML('botonContenido','btnCrear');
}

function onTabBotonCrear() {
	if(document.getElementById("btnMantenerMapa").disabled == true) {
		focaliza("formulario.cbCentroDistribucion");
	}
	else {
		focalizaBotonHTML('botonContenido','btnMantenerMapa');
	}
}

function onTabBotonMantener() {
	focaliza("formulario.cbCentroDistribucion");
}

function onShtabComboCentro() {
	if(document.getElementById("btnMantenerMapa").disabled == true) {
		focalizaBotonHTML('botonContenido','btnCrear');
	}
	else {
		focalizaBotonHTML('botonContenido','btnMantenerMapa');
	}
}

function onShtabDescripcion() {
	focaliza("formulario.cbCentroDistribucion");
}

function onShTabBotonCrear() {
	focaliza("formulario.txtDescripcion");
}

function onShTabBotonMantener() {
	focalizaBotonHTML('botonContenido','btnCrear');
}