var FORMULARIO = 'frmFormulario';

function onLoadPag() {

	var errDescripcion = get(FORMULARIO + '.errDescripcion');
	if(errDescripcion != '') {
	         var errCodigo = get(FORMULARIO +'.errCodigo');
	         var wnd = fMostrarMensajeError(errCodigo, errDescripcion);
	}
	
	// se seleccionan la marca y el canal por defecto para el usuario
	set(FORMULARIO + '.cbMarca', [get(FORMULARIO + '.oidMarca')]);
   set(FORMULARIO + '.cbCanal', [get(FORMULARIO + '.oidCanal')]);
   
   cbMarcaOnChange();
		
	configurarMenuSecundario(FORMULARIO);
}

function ejecucionCorrecta() {
	// vbongiov -- Cambio 20080756 -- 29/04/2009
	GestionarMensaje("2638", null, null, null);

	//alert('se realizó correctamente la generación');
	set(FORMULARIO + '.cbMarca', [get(FORMULARIO + '.oidMarca')]);
	set(FORMULARIO + '.cbCanal', [get(FORMULARIO + '.oidCanal')]);
	
	cbMarcaOnChange();
}

function cbMarcaOnChange() {
	// Si se han seleccionado valor para el combo cbCanal 
	// { 
	// recargaPeriodo() 
	// } 
	if (get(FORMULARIO + '.cbMarca') != '') {
		if (get(FORMULARIO + '.cbCanal') != '') {
			recargaPeriodo();
		}
	} else {
		vaciaCombo(FORMULARIO + '.cbPeriodo');
	}
}

function cbCanalOnChange() {
	// Si se han seleccionado valor para el combo cbMarca 
	// { 
	// recargaPeriodo() 
	// } 
	if (get(FORMULARIO + '.cbCanal') != '') {
		if (get(FORMULARIO + '.cbMarca') != '') {
			recargaPeriodo();
		}
	} else {
		vaciaCombo(FORMULARIO + '.cbPeriodo');
	}
}

function recargaPeriodo() {
	// Llamar al método recargaCombo utilizando el DTOPeriodo y el idBusiness = "CRAObtenerPeriodos". 
	// Parametros del DTOPeriodo: 
	// - DTOPeriodo.oidPais = oid del pais activo 
	// - DTOPeriodo.oidMarca = oid de la marca seleccionada 
	// - DTOPeriodo.oidCanal = oid del canal seleccionado 
	// 
	// Obtenemos un DTOSalida y cargamos el combo: 
	// - cbPeriodo 
   recargaCombo(FORMULARIO + '.cbPeriodo', 
               'CRAObtenerPeriodos', 
               'es.indra.sicc.dtos.cra.DTOPeriodo', 
               [	
						["oidPais", get(FORMULARIO + '.pais')],
						["oidIdioma", get(FORMULARIO + '.idioma')],
						["marca", get(FORMULARIO + '.cbMarca')],
						["canal", get(FORMULARIO + '.cbCanal')]
               ]
               );
}

function btnGenerarOnClick() {
	// Pulsa sobre el botón Generar chequeos 
	// 
	// Comprueba que se ha seleccionado un valor en el combo cbPeriodo 
	// 
	// Envia a LPEvaluarClientesChequear los parámetros: 
	// - accion = "GenerarChequeos" 
	// - oidPeriodo = oid seleccionado en oidPeriodo 
	if (get(FORMULARIO + '.cbPeriodo') != '') {
		set(FORMULARIO + '.accion', 'generarChequeos');
		set(FORMULARIO + '.conectorAction', 'LPEvaluarClientesChequear');
		
		enviaSICC(FORMULARIO);
	}
}

function irComboMarca() {
	focaliza(FORMULARIO + '.cbMarca');
}

function irBotonGenerar() {
	document.all['btnGenerarChequeos'].focus();
}

function fLimpiar() {
   //vaciaCombo(FORMULARIO + '.cbPeriodo');

   set(FORMULARIO + '.cbMarca', [get(FORMULARIO + '.oidMarca')]);
   set(FORMULARIO + '.cbCanal', [get(FORMULARIO + '.oidCanal')]);
   
   cbMarcaOnChange();
   
   focaliza(FORMULARIO + '.cbMarca');
}

function vaciaCombo(combo) {
	set_combo(combo, [['','']], ['']);	
}

