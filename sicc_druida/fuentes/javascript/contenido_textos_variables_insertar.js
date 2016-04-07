function fLimpiar() {
	onLoadPag();
}

function fVolver() {
	window.close();
}

function configurarBotonesModal() {
	if(get('formulario.casoUso')=="modificacion") {
		btnProxy(1, '1');
	}

	btnProxy(2, '1');
	btnProxy(3, '0');
	btnProxy(5, '1');
	btnProxy(7, '0');
	btnProxy(8, '0');
	btnProxy(9, '0');
}

function onLoadPag() {  
	fMostrarMensajeError();
	configurarMenuSecundario("formulario");

	if(get('formulario.casoUso')=="modificacion" || 
	get('formulario.casoUso')=="detalle") {
		configurarBotonesModal();
		reasignarDatosPantalla();
	}

	if(get('formulario.casoUso')=="detalle") {
		document.getElementById("comboTipoCliente").disabled = true;
		document.getElementById("comboSubtipoCliente").disabled = true;
		document.getElementById("comboTipoClasificacion").disabled = true;
		document.getElementById("comboClasificacion").disabled = true;
		document.getElementById("txtTextoVariable").disabled = true;	
		document.getElementById("btnAceptar").disabled = true;
	}

	if(get('formulario.casoUso')=="modificacion") {
		document.getElementById("comboTipoCliente").disabled = true;
	}

	if(get('formulario.casoUso')!="detalle") {
		focaliza("formulario.comboTipoCliente");
	}
}

function reasignarDatosPantalla() {
	//1 Se setea el valor para texto variable
	var textoVariable = get("formulario.textoVariable");  
    set("formulario.txtTextoVariable", textoVariable);	

	//2 El combo tipo cliente se carga desde la lp

	//3 Se deja seleccionado el tipo cliente elegido por el usuario
	var oidTipoCliente = get("formulario.oidTipoCliente");  
	var oidSeleccionado = new Array();
    oidSeleccionado = oidTipoCliente.split(",");	    
    set("formulario.comboTipoCliente", oidSeleccionado);	

	//4 Se carga el combo subtipo cliente
	recargaComboSubtipoCliente();
}

function recargaComboSubtipoCliente() {
	recargaCombo('formulario.comboSubtipoCliente', 'MAEobtenerSubtipos', 'es.indra.sicc.util.DTOOID', armarArrayComboTipoCliente(),'rellenarComboSubtipoCliente(datos)');
}

function rellenarComboSubtipoCliente(datos) {
	var arrayNuevo = new Array();
	arrayNuevo[0] = new Array('','');
	arrayNuevo = arrayNuevo.concat(datos);
	set_combo('formulario.comboSubtipoCliente',arrayNuevo);

	//5 Si existe oid subtipo cliente se deja seleccionado
	//y se carga el combo Tipo clasificacion
	if(get("formulario.oidSubtipoCliente")!="") {
		var oidSubtipoCliente = get("formulario.oidSubtipoCliente");  
		var oidSeleccionado = new Array();
		oidSeleccionado = oidSubtipoCliente.split(",");	    
	    set("formulario.comboSubtipoCliente", oidSeleccionado);	
		
		recargaComboTipoClasificacion();
	}
}

function recargaComboTipoClasificacion(){
	recargaCombo('formulario.comboTipoClasificacion', 'MAEobtenerTipoClasificacion', 'es.indra.sicc.util.DTOOID', 	armarArrayComboSubtipoCliente(), 'rellenarComboTipoClasificacion(datos)');
}

function rellenarComboTipoClasificacion(datos) {
	var arrayNuevo = new Array();
	arrayNuevo[0] = new Array('','');
	arrayNuevo = arrayNuevo.concat(datos);
	set_combo('formulario.comboTipoClasificacion',arrayNuevo);

	//6 Si existe oid tipo clasificacion se deja seleccionado
	//y se carga el combo clasificacion
	if(get("formulario.oidTipoClasificacion")!="") {
		var oidTipoClasificacion = get("formulario.oidTipoClasificacion");  
		var oidSeleccionado = new Array();
		oidSeleccionado = oidTipoClasificacion.split(",");	    
	    set("formulario.comboTipoClasificacion", oidSeleccionado);	
		
		recargaComboClasificacion();
	}
}

function recargaComboClasificacion() {
	recargaCombo('formulario.comboClasificacion', 'MAEobtenerClasificacionesPorTipo', 'es.indra.sicc.util.DTOOID', armarArrayComboTipoClasificacion(), 'rellenarComboClasificacion(datos)');
}

function rellenarComboClasificacion(datos) {
	var arrayNuevo = new Array();
	arrayNuevo[0] = new Array('','');
	arrayNuevo = arrayNuevo.concat(datos);
	set_combo('formulario.comboClasificacion',arrayNuevo);

	//7 Si existe oid clasificacion se deja seleccionado
	if(get("formulario.oidClasificacion")!="") {
		var oidClasificacion = get("formulario.oidClasificacion");  
		var oidSeleccionado = new Array();
		oidSeleccionado = oidClasificacion.split(",");	    
	    set("formulario.comboClasificacion", oidSeleccionado);	
	}
}

function onChangeCmbTipoCliente() {
	if(get('formulario.comboTipoCliente')!="") {
		recargaCombo('formulario.comboSubtipoCliente', 'MAEobtenerSubtipos', 'es.indra.sicc.util.DTOOID', armarArrayComboTipoCliente());
	}
	else {
		set_combo('formulario.comboSubtipoCliente', new Array(['','']));
		set_combo('formulario.comboTipoClasificacion', new Array(['','']));
		set_combo('formulario.comboClasificacion', new Array(['','']));
	}
}

function armarArrayComboTipoCliente() {
	var idioma = get('formulario.idioma');
	var oid = get('formulario.comboTipoCliente');
  
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

function onChangeSubtipoCliente(){ 
	if(get('formulario.comboSubtipoCliente')!="") {
		recargaCombo('formulario.comboTipoClasificacion', 'MAEobtenerTipoClasificacion', 'es.indra.sicc.util.DTOOID', 	armarArrayComboSubtipoCliente());
	}
	else {
		set_combo('formulario.comboTipoClasificacion', new Array(['','']));
		set_combo('formulario.comboClasificacion', new Array(['','']));
	}
}

function armarArrayComboSubtipoCliente() {
	var idioma = get('formulario.idioma');
	var oid = get('formulario.comboSubtipoCliente');
  
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

function onChangeTipoClasificacion() {
	if(get('formulario.comboTipoClasificacion')!="") {
		recargaCombo('formulario.comboClasificacion', 'MAEobtenerClasificacionesPorTipo', 'es.indra.sicc.util.DTOOID', armarArrayComboTipoClasificacion());
	}
	else {
		set_combo('formulario.comboClasificacion', new Array(['','']));
	}
}

function armarArrayComboTipoClasificacion() {
	var idioma = get('formulario.idioma');
	var oid = get('formulario.comboTipoClasificacion');
  
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

function onClickBtnAceptar() {
	fGuardar();
}

function fGuardar() {	
	if(sicc_validaciones_generales()) {  
		set("formulario.oidSeleccionado", get("formulario.oidSeleccionado"));
		set("formulario.oidTipoCliente", get('formulario.comboTipoCliente'));
		set("formulario.oidSubtipoCliente", get('formulario.comboSubtipoCliente'));
		set("formulario.oidTipoClasificacion", get('formulario.comboTipoClasificacion'));
		set("formulario.oidClasificacion", get('formulario.comboClasificacion'));		
		set("formulario.textoVariable", get('formulario.txtTextoVariable'));				
		eval("formulario").oculto= "S";
		set("formulario.conectorAction", "LPConfiguracionTextosVariables");
		set("formulario.accion", "guardar");
		enviaSICC("formulario"); 
	}
}

function fGuardarOK() {
	eval("formulario").oculto= "N";			
	var oidSeleccionado = new Array();    
    set("formulario.comboTipoCliente", oidSeleccionado);		
	set_combo('formulario.comboSubtipoCliente', new Array(['','']));
	set_combo('formulario.comboTipoClasificacion', new Array(['','']));
	set_combo('formulario.comboClasificacion', new Array(['','']));
	set("formulario.txtTextoVariable", "");	
	onLoadPag();
}

function fGuardarERR() {
	eval("formulario").oculto= "N";
}

function onShTabComboTipoCliente() {
	focalizaBotonHTML('botonContenido','btnAceptar');
}

function onTabComboTipoCliente() {
	focaliza("formulario.comboSubtipoCliente");
}

function onShTabComboSubtipoCliente() {
	focaliza("formulario.comboTipoCliente");
}

function onTabComboSubtipoCliente() {
	focaliza("formulario.comboTipoClasificacion");
}

function onShTabComboTipoClasificacion() {
	focaliza("formulario.comboSubtipoCliente");
}

function onTabComboTipoClasificacion() {
	focaliza("formulario.comboClasificacion");
}

function onShTabComboClasificacion() {
	focaliza("formulario.comboTipoClasificacion");
}

function onTabComboClasificacion() {
	focaliza("formulario.txtTextoVariable");
}

function onTabTextoVariable() {
	focalizaBotonHTML('botonContenido','btnAceptar');
}

function onShTabTextoVariable() {
	focaliza("formulario.comboClasificacion");
}

function onTabAceptar() {
	focaliza("formulario.comboTipoCliente");
}

function onShTabAceptar() {
	focaliza("formulario.txtTextoVariable");
}