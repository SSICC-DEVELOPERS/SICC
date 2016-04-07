var FORMULARIO = 'frmFormulario';

function onLoadPag() {
	configurarMenuSecundario(FORMULARIO);
        var errDescripcion = get(FORMULARIO +'.errDescripcion');
         if (errDescripcion !='') {            
                  var errCodigo = get(FORMULARIO+'.errCodigo');
                  var wnd = fMostrarMensajeError(errCodigo, errDescripcion);
         }
	
	
	focaliza(FORMULARIO + ".cbMarca");
	
	// al cargar la pagina los combos marca y canal estaran preseleccionados.
	// tendran los valores por defecto para el usuario actual
	// llamo a marcaOnChange para que se cargue el combo cbPeriodo
	marcaOnChange();
}

function marcaOnChange() {
	cambiarPeriodo();
	cambiarActividad();
}

function canalOnChange() {
	cambiarPeriodo();
	cambiarActividad();
}

function tipoDespachoOnChange() {
	cambiarActividad();
}

function cambiarPeriodo() {
	// Llamar al mÚtodo 'recargaCombo' utilizando DTOPeriodo y el idBusiness = "CRAObtienePeriodos". 
	// Parametros del DTOPeriodo: 
	//	- pais = pais activo 
	//	- marca = la seleccionada en el control 'cbMarca' 
	//	- canal = el seleccionado en el control 'cbCanal' 
	//Se obtiene un DTOSalida y se carga el combo cbPeriodo.
	
	var pais = get(FORMULARIO+'.pais');
	var marca = get(FORMULARIO+'.cbMarca');
	var canal = get(FORMULARIO+'.cbCanal');

	if (marca != '' && canal != '') {
		recargaCombo(
			FORMULARIO + '.cbPeriodo',
			'CRAObtienePeriodos', 
			'es.indra.sicc.dtos.cra.DTOPeriodo', 
			[["pais", pais], ["marca", marca], ["canal", canal]]			
		);
	}
	else {
		vaciaCombo(FORMULARIO + '.cbPeriodo');
	}
}


function cambiarActividad() {
	// Llamar al mÚtodo 'recargaCombo' utilizando DTOEBuscarActividadesMAV y el idBusiness = "MAVObtenerActividadesTipoDespacho". 
	// Parametros del DTOPeriodo: 
	//	- pais = pais activo 
	//	- idioma = idioma del pais
	//	- marca = la seleccionada en el control 'cbMarca' 
	//	- canal = el seleccionado en el control 'cbCanal' 
	//	- despacho = el seleccionado en el control 'cbTipoDespacho' 
	//Se obtiene un DTOSalida y se carga el combo cbPeriodo.
	
	var pais = get(FORMULARIO+'.pais');
	var idioma = get(FORMULARIO+'.idioma');

	var marca = get(FORMULARIO+'.cbMarca');
	var canal = get(FORMULARIO+'.cbCanal');
	var despacho = get(FORMULARIO+'.cbTipoDespacho');

	if (marca != '' && canal != '' && despacho != '') {
		recargaCombo(
			FORMULARIO + '.cbActividad',
			'MAVObtenerActividadesTipoDespacho', 
			'es.indra.sicc.dtos.mav.DTOEBuscarActividadesMAV', 
			[["oidPais", pais], ["oidIdioma", idioma], ["marca", marca], ["canal", canal], ["codigo", despacho]]			
		);
	}
	else {
		vaciaCombo(FORMULARIO + '.cbActividad');
	}
}

function vaciaCombo(combo) {
	set_combo(combo,[['','']],['']);
}

function fVolver() {
	window.close();
}

function focalizaSiguiente(elemento) {
	focaliza(elemento);
}

function focalizaAnterior() {
	document.all['btnAceptar'].focus();
}

function aceptarOnClick() {
	
	// se comprueba que se han introducido todos los valores obligatorios	
	if (!sicc_validaciones_generales()) { 
		return false; 
	}

    eval(FORMULARIO).oculto = 'S';
	set(FORMULARIO + '.hActividades', get(FORMULARIO + '.cbActividad'));		
	set(FORMULARIO + ".accion", "aceptar");
	set(FORMULARIO + '.conectorAction', "LPEnvioIniFinPeriodo");
	enviaSICC(FORMULARIO);
}

function cerrarVentana(){
	  set(FORMULARIO+".conectorAction","LPInicioBelcorp");
	  set(FORMULARIO+".accion","");
	  try{
				parent.frames['menu'].location.reload();
				parent.frames["iconos"].mostrarCapa();
	  }catch(e){
	  
	  }
	  eval(FORMULARIO).oculto = 'N';
	  enviaSICC(FORMULARIO,'','','N');
}
