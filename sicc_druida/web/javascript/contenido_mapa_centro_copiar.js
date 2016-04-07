function onLoad() {
	fMostrarMensajeError();
	configurarMenuSecundario("formulario");  	

	if(get('formulario.hOidCentroDistribucionDefecto')!="") {
		var hidOidDefecto = get("formulario.hOidCentroDistribucionDefecto");  
        var oidSeleccionado = new Array();
        oidSeleccionado = hidOidDefecto.split(",");	    
        set("formulario.cbCentroDistribucion", oidSeleccionado);	
		onChangeCbCentroDistribucion();
	}
	set("formulario.txtDescripcion", "");
	focaliza("formulario.cbCentroDistribucion");
}

function onChangeCbCentroDistribucion() {
	if(get('formulario.cbCentroDistribucion')!="") {
		recargaCombo('formulario.cbMapaCentroDistribucion', 'APEObtenerMapasCDPorCD', 'es.indra.sicc.util.DTOOID', armarArrayComboCentroDistribucion());
	}
	else {
		set_combo('formulario.cbMapaCentroDistribucion', new Array(['','']));
	}
}

function armarArrayComboCentroDistribucion() {
	var idioma = get('formulario.idioma');
	var pais = get('formulario.pais');
	var oid = get('formulario.cbCentroDistribucion');
  
    var array = new Array();
    var index = 0;

    if( idioma != null && idioma != '' ){
		array[index] = new Array('oidIdioma', idioma);
        index++;
    }

	if( pais != null && pais != '' ){
		array[index] = new Array('oidPais', pais);
        index++;
    }

	if( oid != null && oid != '' ){
		array[index] = new Array('oid', oid);
        index++;
    }
  
    return array;
}

function onClickCopiar() {
	if(sicc_validaciones_generales()) {  
		set("formulario.oid", get("formulario.cbMapaCentroDistribucion"));		
		eval("formulario").oculto= "S";
		set("formulario.conectorAction", "LPMantenimientoMapaCentroDistribucion");
		set("formulario.accion", "copiar");
		enviaSICC("formulario"); 
	}
}

function copiarOK() {
	eval("formulario").oculto= "N";
	GestionarMensaje("APE015bis", null, null, null);
	onLoad();
}

function copiarERR() {
	eval("formulario").oculto= "N";
}

function onTabCentro() {
	focaliza("formulario.cbMapaCentroDistribucion");
}

function onShTabCentro() {
	focalizaBotonHTML('botonContenido','btnCopiar');
}

function onTabMapa() {
	focaliza("formulario.txtDescripcion");
}

function onShTabMapa() {
	focaliza("formulario.cbCentroDistribucion");
}

function onTabDescripcion() {
	focalizaBotonHTML('botonContenido','btnCopiar');
}

function onShTabDescripcion() {
	focaliza("formulario.cbMapaCentroDistribucion");
}

function onTabBotonCopiar() {
	focaliza("formulario.cbCentroDistribucion");
}

function onShTabBotonCopiar() {
	focaliza("formulario.txtDescripcion");
}

function fLimpiar() {
	var oidCDDefault = get("formulario.hOidCentroDistribucionDefecto");
	set("formulario.cbCentroDistribucion", [oidCDDefault]);
	onChangeCbCentroDistribucion();
	
	set("formulario.txtDescripcion", "");
	focaliza("formulario.cbCentroDistribucion");
}