var FORMULARIO = 'frmFormulario';

function onLoadPag() {

	var errDescripcion = get(FORMULARIO + '.errDescripcion');
	if(errDescripcion != '') {
		var errCodigo = get(FORMULARIO +'.errCodigo');
		var wnd = fMostrarMensajeError(errCodigo, errDescripcion);
	}
	
	// se llama a las funcion de cambio de canal para que se carguen los combos
	// periodo y acceso. (por defecto)
	cargarValoresDefectoCombos();

	configurarMenuSecundario(FORMULARIO);	
}

function cargarValoresDefectoCombos(){
	set(FORMULARIO + '.cbCanal', [get(FORMULARIO + '.valorDefectoCanal')]);
	/* onChangeCanal(); */
	onChangeCanalValorDefecto();

	/* set(FORMULARIO + '.cbAcceso', [get(FORMULARIO + '.valorDefectoAcceso')]); */
	/* onChangeAcceso(); */
	/* set(FORMULARIO + '.cbSubAcceso', [get(FORMULARIO + '.valorDefectoSubAcceso')]); */
}

function onClickBuscar() {
	if (sicc_validaciones_generales()) {
		
		//set(FORMULARIO + '.oculto', 'S');
		FORMULARIO.oculto = 'S';
		
		// obtenemos los tipos de solicitud seleccionados del combo multiple cbTipoSolicitud
		// y los metemos en una cadena, separando los tipos por ','
		// Antes se utilizaba # pero daba problemas al hacer un configurarPaginado
		var tiposSolicSeleccionados = new String(get(FORMULARIO + '.cbTipoSolicitud'));

      set(FORMULARIO + '.listaTiposSolicitud', [tiposSolicSeleccionados]);
      
		// Llama a la LPCambiosDePrecios con un envio oculto del formulario y accion="buscar" 	
		set(FORMULARIO + '.accion', 'buscar');
		set(FORMULARIO + '.conectorAction', 'LPCambiosDePrecios');
		
		enviaSICC(FORMULARIO);
	}
}

// esta funcion sirve para cargar la pantalla emergente modal, y se ejecuta si el proceso de busqueda 
// ha sido correcto, es decir, se han validado los codigos de venta y se devuelve un DTO no nulo
function cargarPaginaDetalleJS() {
	
	// tengo que enviar como parametros algunos campos de la pagina
	var objParams = new Object();
	// numero generacion
	objParams.numGeneracion = get(FORMULARIO + '.valorNumeroGeneracion');
	// acceso
	objParams.oidAcceso = get(FORMULARIO + '.cbAcceso');
	// subacceso
	objParams.oidSubAcceso = get(FORMULARIO + '.cbSubAcceso');
	// periodo
	objParams.oidPeriodo = get(FORMULARIO + '.cbPeriodoReferencia');
	// observaciones
	objParams.observaciones = get(FORMULARIO + '.areatxtObservaciones');
	// TipoOperacion
	objParams.oidTipoOperacion = get(FORMULARIO + '.cbTipoOperacion');
	// arrayTipoSolicitud
	// obtenemos los tipos de solicitud seleccionados del combo multiple cbTipoSolicitud
	// y los metemos en una cadena, separando los tipos por ','
	// Antes se utilizaba # pero daba problemas al hacer un configurarPaginado
	var tiposSolicSeleccionados = new String(get(FORMULARIO + '.cbTipoSolicitud'));	
	objParams.tiposSolicSeleccionados = tiposSolicSeleccionados;
	// por incidencia BELC300019804 se pasa también la fechaGeneracion	
	objParams.fechaGeneracion = get(FORMULARIO + '.txtFechaGeneracion');
	
	mostrarModalSICC('LPCambiosDePrecios', 'cargarPaginaDetalle', objParams, null, null);
}

function onChangeCanal() {

	// Llamar al método recargaCombo utilizando el DTOOid y el idBusiness = "SEGObtieneAccesosPorCanal". 

	// Parametro del DTOOid: 
	// -DTOOid.oid=oid del valor seleccionado en la cbCanal 
	// Obtenemos un DTOSalida y cargamos el combo cbAcceso 

	if (get(FORMULARIO + '.cbCanal') != '') {
		recargaCombo(FORMULARIO + '.cbAcceso', 
						'SEGObtieneAccesosPorCanal',
						'es.indra.sicc.util.DTOOID', 
						[	
							["oid", get(FORMULARIO + '.cbCanal')],
							["oidPais",get(FORMULARIO + '.pais')],
							["oidIdioma",get(FORMULARIO + '.idioma')]
						]
						);	
		
	
		// Si hay un valor seleccionado en la cbMarca{ 
		marcaSeleccionada = get(FORMULARIO + '.cbMarca');
		if (marcaSeleccionada != '') {
			// Llamar al método recargaCombo utilizando el DTOPeriodo y el idBusiness = "CRAObtienePeriodos". 
		
			// Parametro del DTOPeriodo: (además del pais) 
			// -DTOPeriodo.marc_oid_marc=oid del valor seleccionado en la cbMarca 
			// -DTOPeriodo.periodo.cana_oid_cana=oid del valor seleccionado en la cbCanal
			// Obtenemos un DTOSalida y cargamos el combo cbPeriodo 
			
			canalSeleccionado = get(FORMULARIO + '.cbCanal');
			
			recargaCombo(FORMULARIO + '.cbPeriodoReferencia', 
							'CRAObtienePeriodos',
							'es.indra.sicc.dtos.cra.DTOPeriodo', 
							[	
								["oidPais", get(FORMULARIO + '.pais')],
								["oidIdioma",get(FORMULARIO + '.idioma')],
								["marca", marcaSeleccionada],
								["canal", canalSeleccionado]
							]
							);		
		}
	} else { // seleccionado vacio en combo canal, por lo que vaciamos los combos acceso y subacceso
		vaciaCombo(FORMULARIO + '.cbAcceso');
		vaciaCombo(FORMULARIO + '.cbSubAcceso');
	}
}

function onChangeCanalValorDefecto() {

	// Llamar al método recargaCombo utilizando el DTOOid y el idBusiness = "SEGObtieneAccesosPorCanal". 

	// Parametro del DTOOid: 
	// -DTOOid.oid=oid del valor seleccionado en la cbCanal 
	// Obtenemos un DTOSalida y cargamos el combo cbAcceso 

	if (get(FORMULARIO + '.cbCanal') != '') {
		recargaCombo(FORMULARIO + '.cbAcceso', 
						'SEGObtieneAccesosPorCanal',
						'es.indra.sicc.util.DTOOID', 
						[	
							["oid", get(FORMULARIO + '.cbCanal')],
							["oidPais",get(FORMULARIO + '.pais')],
							["oidIdioma",get(FORMULARIO + '.idioma')]
						], 'asignarAccesoValorDefecto(datos)'
						);	
		
	
		// Si hay un valor seleccionado en la cbMarca{ 
		marcaSeleccionada = get(FORMULARIO + '.cbMarca');
		if (marcaSeleccionada != '') {
			// Llamar al método recargaCombo utilizando el DTOPeriodo y el idBusiness = "CRAObtienePeriodos". 
		
			// Parametro del DTOPeriodo: (además del pais) 
			// -DTOPeriodo.marc_oid_marc=oid del valor seleccionado en la cbMarca 
			// -DTOPeriodo.periodo.cana_oid_cana=oid del valor seleccionado en la cbCanal
			// Obtenemos un DTOSalida y cargamos el combo cbPeriodo 
			
			canalSeleccionado = get(FORMULARIO + '.cbCanal');
			
			recargaCombo(FORMULARIO + '.cbPeriodoReferencia', 
							'CRAObtienePeriodos',
							'es.indra.sicc.dtos.cra.DTOPeriodo', 
							[	
								["oidPais", get(FORMULARIO + '.pais')],
								["oidIdioma",get(FORMULARIO + '.idioma')],
								["marca", marcaSeleccionada],
								["canal", canalSeleccionado]
							]
							);		
		}
	} else { // seleccionado vacio en combo canal, por lo que vaciamos los combos acceso y subacceso
		vaciaCombo(FORMULARIO + '.cbAcceso');
		vaciaCombo(FORMULARIO + '.cbSubAcceso');
	}
}

function asignarAccesoValorDefecto(datos){
	var sel = new Array();
	sel[0] = get(FORMULARIO + '.valorDefectoAcceso');
	set_combo(FORMULARIO + '.cbAcceso', datos, sel);
	onChangeAccesoValorDefecto();
}

function onChangeAcceso() {
	// Llamar al método recargaCombo utilizando el DTOOid y el idBusiness = "SEGObtenerSubccesosPorAcceso". 

	// Parametro del DTOOid: 
	// -DTOOid.oid=oid del valor seleccionado en la cbAcceso 
	// Obtenemos un DTOSalida y cargamos el combo cbSubAcceso	
	
	accesoSeleccionado = get(FORMULARIO + '.cbAcceso');
	
	if (accesoSeleccionado != '') {
		recargaCombo(FORMULARIO + '.cbSubAcceso', 
					'SegObtenerSubaccesosPorAcceso',
					'es.indra.sicc.util.DTOOID', 
					[	
						["oid", accesoSeleccionado],
						["oidPais", get(FORMULARIO + '.pais')],
						["oidIdioma",get(FORMULARIO + '.idioma')]
					]
					);
	} else { // se ha seleccionado un acceso vacio
		vaciaCombo(FORMULARIO + '.cbSubAcceso');
	}
}

function onChangeAccesoValorDefecto() {
	// Llamar al método recargaCombo utilizando el DTOOid y el idBusiness = "SEGObtenerSubccesosPorAcceso". 

	// Parametro del DTOOid: 
	// -DTOOid.oid=oid del valor seleccionado en la cbAcceso 
	// Obtenemos un DTOSalida y cargamos el combo cbSubAcceso	
	
	accesoSeleccionado = get(FORMULARIO + '.cbAcceso');

	if (accesoSeleccionado != '') {
		recargaCombo(FORMULARIO + '.cbSubAcceso', 
					'SegObtenerSubaccesosPorAcceso',
					'es.indra.sicc.util.DTOOID', 
					[	
						["oid", accesoSeleccionado],
						["oidPais", get(FORMULARIO + '.pais')],
						["oidIdioma",get(FORMULARIO + '.idioma')]
					], 'asignarSubAccesoValorDefecto(datos)'
					);
	} else { // se ha seleccionado un acceso vacio
		vaciaCombo(FORMULARIO + '.cbSubAcceso');
	}
}

function asignarSubAccesoValorDefecto(datos){
	var sel = new Array();
	sel[0] = get(FORMULARIO + '.valorDefectoSubAcceso');
	set_combo(FORMULARIO + '.cbSubAcceso', datos, sel);
}

function onChangeMarca() {
	// Si hay un valor seleccionado en la cbMarca
	marcaSeleccionada = get(FORMULARIO + '.cbMarca');

	if (marcaSeleccionada != '') {
		// Llamar al método recargaCombo utilizando el DTOPeriodo y el idBusiness = "CRAObtienePeriodos".
	
		// Parametro del DTOPeriodo: (además del pais) 
		// -DTOPeriodo.marc_oid_marc=oid del valor seleccionado en la cbMarca 
		// -DTOPeriodo.periodo.cana_oid_cana=oid del valor seleccionado en la cbCanal 
		// Obtenemos un DTOSalida y cargamos el combo cbPeriodo 
		
		canalSeleccionado = get(FORMULARIO + '.cbCanal');
		
		recargaCombo(FORMULARIO + '.cbPeriodoReferencia', 
						'CRAObtienePeriodos', 
						'es.indra.sicc.dtos.cra.DTOPeriodo', 
						[	
							["oidPais", get(FORMULARIO + '.pais')],
							["oidIdioma",get(FORMULARIO + '.idioma')],
							["marca", marcaSeleccionada],
							["canal", canalSeleccionado]
						]
						);
	} else { // vaciamos el combo cbPeriodoReferencia
		vaciaCombo(FORMULARIO + '.cbPeriodoReferencia');
	}
}

function onChangeCodOperacion() {
	// Llamar al método recargaCombo utilizando el DTOOid y el idBusiness = "RECObtenerTiposOperacionAgregar". 

	// Parametro del DTOOid: 
	// -DTOOid.oid=oid del valor seleccionado en la cbCodOperacion 
	// Obtenemos un DTOSalida y cargamos el combo cbTipoOperacion
	
	if (get(FORMULARIO + '.cbCodigoOperacionReclamos') != '') {

		recargaCombo(FORMULARIO + '.cbTipoOperacion', 
						'RECObtenerTiposOperacionAgregar',
						'es.indra.sicc.util.DTOOID', 
						[	
							["oid", get(FORMULARIO + '.cbCodigoOperacionReclamos')],
							["oidPais", get(FORMULARIO + '.pais')],
							["oidIdioma",get(FORMULARIO + '.idioma')]
						]
						);	
	} else { // si se ha elegido el codigo vacio se vacia el combo de tipo operacion
		vaciaCombo(FORMULARIO + '.cbTipoOperacion');
	}

}

function irComboMarca() {
	focaliza(FORMULARIO + '.cbMarca');
}

function irBotonBuscar() {
	document.all['btnBuscar'].focus();
}

function validarFecha() {
	var fecha= get(FORMULARIO + '.txtFechaGeneracion');
	if(fecha != "") {
	var resul = EsFechaValida(fecha, fecha, FORMULARIO, null);
		if(resul==1 || resul==2){  
      	GestionarMensaje('1006', get(FORMULARIO + '.hFormatoFechaPais')); 
	 		focaliza(FORMULARIO + '.txtFechaGeneracion');      	
		}
	}
}

function fLimpiar() {
		
	vaciaCombo(FORMULARIO + '.cbSubAcceso');

	set(FORMULARIO + '.txtCodigoVenta', '');
	set(FORMULARIO + '.txtCodigoVentaGenerar', '');
	
	vaciaCombo(FORMULARIO + '.cbTipoOperacion');
	set(FORMULARIO + '.areatxtObservaciones', '');
	set(FORMULARIO + '.txtFechaGeneracion', get(FORMULARIO + '.valorFechaGeneracion'));

	set(FORMULARIO + '.cbMarca', [get(FORMULARIO + '.oidMarca')]);
	set(FORMULARIO + '.cbCanal', [get(FORMULARIO + '.oidCanal')]);
	onChangeCanal();
	
	focaliza(FORMULARIO + ".cbMarca");
}

function vaciaCombo(combo) {
	set_combo(combo, [['','']], ['']);	
}

function convertirAMayusculas(cajaTexto) {
	set(FORMULARIO + '.' + cajaTexto, [new String(get(FORMULARIO + '.' + cajaTexto)).toUpperCase()]);
}