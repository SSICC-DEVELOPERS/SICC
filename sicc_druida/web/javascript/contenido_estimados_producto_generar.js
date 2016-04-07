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
		onChangeCbCentroDistribucion();
	}

	var oidSeleccionado = new Array();    
    set("formulario.cbCanal", oidSeleccionado);	
    set("formulario.cbMarca", oidSeleccionado);	
	set_combo('formulario.cbPeriodo', new Array(['','']));
	focaliza("formulario.cbMarca");
}

function onChangeCbCentroDistribucion() {
	if(get('formulario.cbCentroDistribucion')!="") {
		recargaCombo('formulario.cbLineasEstimadosVenta', 'APEObtenerLineasArmadoCDNoAFP', 'es.indra.sicc.util.DTOOID', armarArrayComboCentroDistribucion(),'rellenarCombosLineas(datos)');
	}
	else {
		set_combo('formulario.cbLineasEstimadosVenta', new Array(['','']));
		set_combo('formulario.cbLineasEstimadosMav', new Array(['','']));
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

function rellenarCombosLineas(datos) {
	var arrayNuevo = new Array();
	arrayNuevo[0] = new Array('','');
	arrayNuevo = arrayNuevo.concat(datos);

	set_combo('formulario.cbLineasEstimadosVenta',arrayNuevo);
	set_combo('formulario.cbLineasEstimadosMav',arrayNuevo);

	var longitudCombo1 = combo_get('formulario.cbLineasEstimadosVenta', 'L');
	var oidsLineasDef1 = get('formulario.hOidsLineasArmadoDefecto').split('|');
	for (var i = 1; i < longitudCombo1; i++) {
		var value = combo_get('formulario.cbLineasEstimadosVenta', 'V', i);
		for (var j = 0; j < oidsLineasDef1.length; j++) {
			if (value == oidsLineasDef1[j]) {
				set('formulario.cbLineasEstimadosVenta', new Array(value));
				j = oidsLineasDef1.length;
				i = longitudCombo1;
			}
		}
	}

	var longitudCombo2 = combo_get('formulario.cbLineasEstimadosMav', 'L');
	var oidsLineasDef2 = get('formulario.hOidsLineasArmadoDefecto').split('|');
	for (var i = 1; i < longitudCombo2; i++) {
		var value = combo_get('formulario.cbLineasEstimadosMav', 'V', i);
		for (var j = 0; j < oidsLineasDef2.length; j++) {
			if (value == oidsLineasDef2[j]) {
				set('formulario.cbLineasEstimadosMav', new Array(value));
				j = oidsLineasDef2.length;
				i = longitudCombo2;
			}
		}
	}
}

function onClickGenerar() {
	if(sicc_validaciones_generales()) {  
		if(get('formulario.cbLineasEstimadosVenta')!="" || get('formulario.cbLineasEstimadosMav')!="") {
			set("formulario.oidEstimado", get('formulario.oidEstimado'));
			set("formulario.oidPeriodo", get('formulario.cbPeriodo'));
			set("formulario.oidLineaVenta", get('formulario.cbLineasEstimadosVenta'));
			set("formulario.oidLineaMav", get('formulario.cbLineasEstimadosMav'));

			eval("formulario").oculto= "S";
			set("formulario.conectorAction", "LPMantenerEstimadosProducto");
			set("formulario.accion", "generar");
			enviaSICC("formulario"); 
		}
		else {
			//Se debe seleccionar al menos un valor para Lineas de Armado
			GestionarMensaje("APE023", null, null, null);
		}
	}
}

function onChangeCbMarca() {
	if(get('formulario.cbCanal')!="" && get('formulario.cbMarca')!="") {
		recargaCombo('formulario.cbPeriodo', 'CRAObtenerPeriodos', 'es.indra.sicc.dtos.cra.DTOPeriodo', armarArray());
	}
	else {
		set_combo('formulario.cbPeriodo', new Array(['','']));
	}
}

function onChangeCbCanal() {
	if(get('formulario.cbCanal')!="" && get('formulario.cbMarca')!="") {
		recargaCombo('formulario.cbPeriodo', 'CRAObtenerPeriodos', 'es.indra.sicc.dtos.cra.DTOPeriodo', armarArray());
	}
	else {
		set_combo('formulario.cbPeriodo', new Array(['','']));
	}
}

function armarArray() {
	var idioma = get('formulario.idioma');
	var pais = get('formulario.pais');
	var canal = get('formulario.cbCanal');
	var marca = get('formulario.cbMarca');
  
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

	if( canal != null && canal != '' ){
		array[index] = new Array('canal', canal);
        index++;
    }

	if( marca != null && marca != '' ){
		array[index] = new Array('marca', marca);
        index++;
    }
  
    return array;
}

function fGenerarOK(mensaje) {
	eval("formulario").oculto= "N";

	if(mensaje=="true") {
		//Ya se ha generado previamente la lista de estimados de la campaña. ¿Desea rescribirla?
		var resp = GestionarMensaje("APE043", null, null, null);
		if(resp==true) {
			//¿Desea conservar los datos introducidos manualmente?
			var resp2 = GestionarMensaje("APE044", null, null, null);
			if(resp2==true) {
				set("formulario.mantenerEstimadosManuales", "true");	
			}
			else {
				set("formulario.mantenerEstimadosManuales", "false");
			}

			set("formulario.oidEstimado", get('formulario.oidEstimado'));
			set("formulario.oidPeriodo", get('formulario.cbPeriodo'));
			set("formulario.oidLineaVenta", get('formulario.cbLineasEstimadosVenta'));
			set("formulario.oidLineaMav", get('formulario.cbLineasEstimadosMav'));
			eval("formulario").oculto= "S";
			set("formulario.conectorAction", "LPMantenerEstimadosProducto");
			set("formulario.accion", "sobreEscribir");
			enviaSICC("formulario"); 
		}
	}	
	else {
  	    GestionarMensaje("APE009", null, null, null);
		onLoadPag();
	}
}

function fGenerarERR() {
	eval("formulario").oculto= "N";
}

function fSobreEscribirOK() {
	eval("formulario").oculto= "N";
	GestionarMensaje("APE009", null, null, null);
	onLoadPag();
}

function fSobreEscribirERR() {
	eval("formulario").oculto= "N";
}

function onShTabComboMarca() {
	focalizaBotonHTML('botonContenido','btnGenerar');
}

function onTabComboMarca() {
	focaliza("formulario.cbCanal");
}

function onShTabComboCanal() {
	focaliza("formulario.cbMarca");
}

function onTabComboCanal() {
	focaliza("formulario.cbPeriodo");
}

function onShTabComboPeriodo() {
	focaliza("formulario.cbCanal");
}

function onTabComboPeriodo() {
	focaliza("formulario.cbCentroDistribucion");
}

function onShTabComboCentro() {
	focaliza("formulario.cbPeriodo");
}

function onTabComboCentro() {
	focaliza("formulario.cbLineasEstimadosVenta");
}

function onShTabComboLinea() {
	focaliza("formulario.cbCentroDistribucion");
}

function onTabComboLinea() {
	focaliza("formulario.cbLineasEstimadosMav");
}

function onShTabComboLineaMav() {
	focaliza("formulario.cbLineasEstimadosVenta");
}

function onTabComboLineaMav() {
	focalizaBotonHTML('botonContenido','btnGenerar');
}

function onTabBotonGenerar() {
	focaliza("formulario.cbMarca");
}

function onShTabBotonGenerar() {
	focaliza("formulario.cbLineasEstimadosMav");
}