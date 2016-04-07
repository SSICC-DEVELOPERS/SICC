function fLimpiar() {
	set('formulario.oidProgramaEtiquetas', '');
	onLoadPag();
}

function fVolver() {
	window.close();
}

function onLoadPag() {  
	//fMostrarMensajeError();
	configurarMenuSecundario("formulario");

	if(get('formulario.casoUso')=="insertar" && get('formulario.hidOidDefecto')!="") {
		var hidOidDefecto = get("formulario.hidOidDefecto");  
        var oidSeleccionado = new Array();
        oidSeleccionado = hidOidDefecto.split(",");	    
        set("formulario.cbCentroDistribucion", oidSeleccionado);	
		/* BELC300024733 - dmorello, 17/04/2007 */
	    //set("formulario.txtFormato", "");	
		set('formulario.cbFormato', new Array(get('formulario.oidProgramaEtiquetas')));
		/* Fin BELC300024733 dmorello 17/04/2007 */
		onChangeCmbCentroDistribucion();
	}

	if(get('formulario.casoUso')=="detalle" ||
		get('formulario.casoUso')=="modificacion") {
		btnProxy(5, '1');
		configurarBotonesModal();
		reasignarDatosPantalla();
	}

	if(get('formulario.casoUso')=="detalle") {
		document.getElementById("cbCentroDistribucion").disabled = true;
		document.getElementById("cbLineaArmado").disabled = true;
		document.getElementById("cbSublinea").disabled = true;
		/* BELC300024733 - dmorello, 17/04/2007 */
		//document.getElementById("txtFormato").disabled = true;
		document.getElementById("cbFormato").disabled = true;
		/* Fin BELC300024733 dmorello 17/04/2007 */
		document.getElementById("btnAceptar").disabled = true;
 	    set("formulario.hidOidDefecto", "");	
	}

	if(get('formulario.casoUso')!="detalle") {
		focaliza("formulario.cbCentroDistribucion");
	}
}

function configurarBotonesModal() {
	if(get('formulario.casoUso')=="detalle") {
		btnProxy(1, '0');
	}
	btnProxy(2, '1');
	btnProxy(3, '0');
	btnProxy(5, '0');
	btnProxy(7, '0');
	btnProxy(8, '0');
	btnProxy(9, '0');
}

function reasignarDatosPantalla() {

	/*
	 * dmorello, 19/04/2007
	 * Si estoy en Detalle, en lugar de OIDs vienen descripciones
	 * Se utilizan las mismas variables hidden que para los OIDs
	 * Las asigno a los campos sin hacer recarga de combos
	 */
	if (get('formulario.casoUso') == 'detalle') {
		set_combo('formulario.cbCentroDistribucion', new Array(['', get('formulario.oidCentroDistribucion')]));
		set_combo('formulario.cbLineaArmado', new Array(['', get('formulario.oidLineaArmado')]));
		set_combo('formulario.cbSublinea', new Array(['', get('formulario.oidSublineaArmado')]));
		set_combo('formulario.cbFormato', new Array(['', get('formulario.oidProgramaEtiquetas')]));
		return;
	}

	//1 - Se setea el valor para el campo Formato
	/*
	 * BELC300024733 - dmorello, 11/04/2007
	 * Se cambia el textbox "formato" por el combo "cbFormato"
	 */
	//var formato = get("formulario.formato");
    //set("formulario.txtFormato", formato);
	var programa = get("formulario.oidProgramaEtiquetas");
	set('formulario.cbFormato', new Array(programa));
	/* Fin BELC300024733 dmorello 11/04/2007 */

	//1- a) El combo Centro distribucion se cargo en la LP
	
	//1- b) Se selecciona el valor para el combo Centro distribucion
	var oidCentroDistribucion = get("formulario.oidCentroDistribucion");  
	var oidSeleccionado = new Array();
    oidSeleccionado = oidCentroDistribucion.split(",");	    
    set("formulario.cbCentroDistribucion", oidSeleccionado);	

	//2- a) Se carga el combo Linea armado
	recargaComboLineaArmado();
}

function recargaComboLineaArmado(){
	recargaCombo('formulario.cbLineaArmado', 'APEObtenerLineasArmadoCD', 'es.indra.sicc.util.DTOOID', armarArrayComboCentroDistribucion(), 'rellenarComboLineaArmado(datos)');
}

function rellenarComboLineaArmado(datos) {
	var arrayNuevo = new Array();
	arrayNuevo[0] = new Array('','');
	arrayNuevo = arrayNuevo.concat(datos);
	set_combo('formulario.cbLineaArmado',arrayNuevo);

	//2- b) Se selecciona el valor para el combo Linea armado
	var oidLineaArmado = get("formulario.oidLineaArmado");  
    var oidSeleccionado = new Array();
    oidSeleccionado = oidLineaArmado.split(",");	    
    set("formulario.cbLineaArmado", oidSeleccionado);	

	//3-a) Se carga el combo Sublinea armado
	recargaComboSubLineaArmado();
}

function recargaComboSubLineaArmado() {
	recargaCombo('formulario.cbSublinea', 'APEObtenerSubLineasArmadoCD', 'es.indra.sicc.util.DTOOID', 
	armarArrayComboLineaArmado(), 'rellenarComboSublineaArmado(datos)');
}

function rellenarComboSublineaArmado(datos) {
	var arrayNuevo = new Array();
	arrayNuevo[0] = new Array('','');
	arrayNuevo = arrayNuevo.concat(datos);
	set_combo('formulario.cbSublinea',arrayNuevo);

	//3- b) Se selecciona el valor para el combo sublinea armado
	var oidSublineaArmado = get("formulario.oidSublineaArmado");  
    var oidSeleccionado = new Array();
    oidSeleccionado = oidSublineaArmado.split(",");	    
    set("formulario.cbSublinea", oidSeleccionado);	
}

function fGuardar() {
	if(sicc_validaciones_generales()) {  
		set("formulario.oidFormatoEtiqueta", get("formulario.oidFormatoEtiqueta"));
		set("formulario.oidCentroDistribucion", get('formulario.cbCentroDistribucion'));
		set("formulario.oidLineaArmado", get('formulario.cbLineaArmado'));
		set("formulario.oidSublineaArmado", get('formulario.cbSublinea'));
		/* BELC300024733 - dmorello, 11/04/2007 - Cambia textbox formato por combo cbFormato */
		//set("formulario.formato", get('formulario.txtFormato'));
		set("formulario.oidProgramaEtiquetas", get("formulario.cbFormato", "V"));
		/* Fin BELC300024733 dmorello 11/04/2007 */
		eval("formulario").oculto= "S";
		set("formulario.conectorAction", "LPFormatosEtiquetas");
		set("formulario.accion", "guardar");
		enviaSICC("formulario"); 
	}
}

function onClickBtnAceptar() {
	fGuardar();
}

function setearCbLineaArmado(datos) {
	var arrayNuevo = new Array();
	arrayNuevo[0] = new Array('','');
	arrayNuevo = arrayNuevo.concat(datos);
	set_combo('formulario.cbLineaArmado',arrayNuevo);

	var longitudCombo = combo_get('formulario.cbLineaArmado', 'L');
	var oidsLineasDef = get('formulario.hOidsLineasArmadoDefecto').split('|');
	for (var i = 1; i < longitudCombo; i++) {
		var value = combo_get('formulario.cbLineaArmado', 'V', i);
		for (var j = 0; j < oidsLineasDef.length; j++) {
			if (value == oidsLineasDef[j]) {
				set('formulario.cbLineaArmado', new Array(value));
				j = oidsLineasDef.length;
				i = longitudCombo;
			}
		}
	}

	onChangeCmbLineaArmado();
}

function onChangeCmbCentroDistribucion(){
	if(get('formulario.cbCentroDistribucion')!='') {
		recargaCombo('formulario.cbLineaArmado', 'APEObtenerLineasArmadoCD', 'es.indra.sicc.util.DTOOID', armarArrayComboCentroDistribucion(), 'setearCbLineaArmado(datos)');
	}
	else {
		set_combo('formulario.cbLineaArmado', new Array(['','']));
		set_combo('formulario.cbSublinea', new Array(['','']));
	}
}

function armarArrayComboCentroDistribucion() {
	var idioma = get('formulario.idioma');
	var oid = get('formulario.cbCentroDistribucion');
  
    var array = new Array();
    var index = 0;

    if( idioma != null && idioma != '' ){
		array[index] = new Array('oidIdioma', idioma);
        index++;
    }

	if( oid != null && oid != '' ){
		array[index] = new Array('oid', oid);
        index++;
    }
  
    return array;
}

function setearCbSublineaArmado(datos) {
	var arrayNuevo = new Array();
	arrayNuevo[0] = new Array('','');
	arrayNuevo = arrayNuevo.concat(datos);
	set_combo('formulario.cbSublinea',arrayNuevo);
}

function onChangeCmbLineaArmado() {
	if(get('formulario.cbLineaArmado')!='') {
		recargaCombo('formulario.cbSublinea', 'APEObtenerSubLineasArmadoCD', 'es.indra.sicc.util.DTOOID', 
		armarArrayComboLineaArmado(), 'setearCbSublineaArmado(datos)');
	}
	else {
		set_combo('formulario.cbSublinea', new Array(['','']));
	}
}

function armarArrayComboLineaArmado() {
	var idioma = get('formulario.idioma');
	var oid = get('formulario.cbLineaArmado');
  
    var array = new Array();
    var index = 0;

    if( idioma != null && idioma != '' ){
		array[index] = new Array('oidIdioma', idioma);
        index++;
    }

	if( oid != null && oid != '' ){
		array[index] = new Array('oid', oid);
        index++;
    }
  
    return array;
}

function fGuardarOK() {
	eval("formulario").oculto= "N";	
	set_combo('formulario.cbLineaArmado', new Array(['','']));
	set_combo('formulario.cbSublinea', new Array(['','']));
	/* BELC300024733 - dmorello, 17/04/2007*/
	//set("formulario.txtFormato", "");	
	set("formulario.oidProgramaEtiquetas", "");	
	/* Fin BELC300024733 dmorello 17/04/2007 */
	onLoadPag();
}

function fGuardarERR() {
	eval("formulario").oculto= "N";
}

function ontabCentro() {
	focaliza("formulario.cbLineaArmado");
}

function onshtabCentro() {
	focalizaBotonHTML('botonContenido','btnAceptar');
}

function ontabLinea() {
	focaliza("formulario.cbSublinea");
}

function onshtabLinea() {
	focaliza("formulario.cbCentroDistribucion");
}

function ontabSublinea() {
	focaliza("formulario.cbFormato");
}

function onshtabSublinea() {
	focaliza("formulario.cbLineaArmado");
}


/*
 * BELC300024733 - dmorello, 11/04/2007
 * Se reemplaza textbox "formato" por combo "programa"
 */

//function ontabFomato() {
//	focalizaBotonHTML('botonContenido','btnAceptar');
//}

//function onshtabFormato() {
//	focaliza("formulario.cbSublinea");
//}

function onTabCbFormato() {
	focalizaBotonHTML('botonContenido','btnAceptar');
}

function onShiftTabCbFormato() {
	focaliza("formulario.cbSublinea");
}

/* Fin BELC300024733 dmorello 11/04/2007 */

function ontabBotonAceptar() {
	focaliza("formulario.cbCentroDistribucion");
}