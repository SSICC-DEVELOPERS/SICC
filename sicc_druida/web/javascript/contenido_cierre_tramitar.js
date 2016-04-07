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

// modificado por incidencia BELC300011486
function marcaOnChange() {
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

   		// Si( cbTipoCierre == ConstantesFAC.CB_ZONA OR cbTipoCierre == ConstantesFAC.CB_REGION )
   		// - Se carga 'cbRegion'
		// Crear un objeto DTOUnidadAdministrativa con:
 		// - oidPais = el pais activo
 		// - oidMarca = el seleccionado en 'cbMarca'
 		// - oidCanal = el seleccionado en 'cbCanal'
		// Llamar al método 'recargaCombo' con DTOUnidadAdministrativa y el IDBusiness="ZONRecargaRegiones"
		// Con el DTOSalida obtenido, se carga el control 'cbRegion'
	    
	    var tipoCierre = get(FORMULARIO+'.cbTipoCierre','T');
	    if (tipoCierre == get(FORMULARIO+'.ConstantesFAC_TIPO_CIERRE_REGION') || tipoCierre == get(FORMULARIO+'.ConstantesFAC_TIPO_CIERRE_ZONA')) {
			recargaCombo(
				FORMULARIO + '.cbRegiones',
				'ZONRecargaRegiones', 
				'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa', 
				[["oidPais", pais], ["oidMarca", marca], ["oidCanal", canal]]			
			);		
	    }
	    
	    // vaciar 'cbZonas'
		vaciaCombo(FORMULARIO + '.cbZonas');
	}
}


// modificado por incidencia BELC300011486
function canalOnChange() {

	var canal = get(FORMULARIO+'.cbCanal');
	
	if (canal != '') {
		var marca = get(FORMULARIO+'.cbMarca');
		if (marca != '') {
			var pais = get(FORMULARIO+'.pais');

			recargaCombo(
				FORMULARIO + '.cbPeriodo',
				'CRAObtienePeriodos', 
				'es.indra.sicc.dtos.cra.DTOPeriodo', 
				[["pais", pais], ["marca", marca], ["canal", canal]]			
			);
		
	   		// Si( cbTipoCierre == ConstantesFAC.CB_ZONA OR cbTipoCierre == ConstantesFAC.CB_REGION )
	   		// - Se carga 'cbRegion'
			// Crear un objeto DTOUnidadAdministrativa con:
	 		// - oidPais = el pais activo
	 		// - oidMarca = el seleccionado en 'cbMarca'
	 		// - oidCanal = el seleccionado en 'cbCanal'
			// Llamar al método 'recargaCombo' con DTOUnidadAdministrativa y el IDBusiness="ZONRecargaRegiones"
			// Con el DTOSalida obtenido, se carga el control 'cbRegion'
		    
		    var tipoCierre = get(FORMULARIO+'.cbTipoCierre','T');
		    if (tipoCierre == get(FORMULARIO+'.ConstantesFAC_TIPO_CIERRE_REGION') || tipoCierre == get(FORMULARIO+'.ConstantesFAC_TIPO_CIERRE_ZONA')) {
				recargaCombo(
					FORMULARIO + '.cbRegiones',
					'ZONRecargaRegiones', 
					'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa', 
					[["oidPais", pais], ["oidMarca", marca], ["oidCanal", canal]]			
				);		
		    }
		    
		    // vaciar 'cbZonas'
			vaciaCombo(FORMULARIO + '.cbZonas');
		}
	}
}


function tipoCierreOnChange() {
	var tipoCierre = get(FORMULARIO+'.cbTipoCierre','T');
	set(FORMULARIO+'.codTipoCierre',get(FORMULARIO+'.cbTipoCierre','T'));
	if (tipoCierre == get(FORMULARIO+'.ConstantesFAC_TIPO_CIERRE_PERIODO')) {
		
		// desactivar control 'cbRegion'
		accion(FORMULARIO+'.cbRegiones', '.disabled=true');
		// desactivar control 'cbZona' 
		accion(FORMULARIO+'.cbZonas', '.disabled=true');

	} else if (tipoCierre == get(FORMULARIO+'.ConstantesFAC_TIPO_CIERRE_REGION')) {
		
		// activar control 'cbRegion' 
		accion(FORMULARIO+'.cbRegiones', '.disabled=false');
		// desactivar control 'cbZona' 
		accion(FORMULARIO+'.cbZonas', '.disabled=true');
		
		// Se carga 'cbRegion' 
		// Crear un objeto DTOUnidadAdministrativa con: 
		// oidPais = el pais activo 
		// oidMarca = el seleccionado en 'cbMarca' 
		// oidCanal = el seleccionado en 'cbCanal' 
		// Llamar al mÚtodo 'recargaCombo' con DTOUnidadAdministrativa y el IDBusiness="ZONRecargaRegiones" 
		// Con el DTOSalida obtenido, se carga el control 'cbRegion' 
		var marca = get(FORMULARIO+'.cbMarca');
		if (marca != '') {
			var canal = get(FORMULARIO+'.cbCanal');
			if (canal != '') {
				var pais = get(FORMULARIO+'.pais');

				recargaCombo(
					FORMULARIO + '.cbRegiones',
					'ZONRecargaRegiones', 
					'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa', 
					[["oidPais", pais], ["oidMarca", marca], ["oidCanal", canal]]			
				);		
			}
		}

	} else if (tipoCierre == get(FORMULARIO+'.ConstantesFAC_TIPO_CIERRE_ZONA')) {
		
		// activar control 'cbRegion'
		accion(FORMULARIO+'.cbRegiones', '.disabled=false');
		// activar control 'cbZona'
		accion(FORMULARIO+'.cbZonas', '.disabled=false'); 

		// // Se carga 'cbRegion' 
		// Crear un objeto DTOUnidadAdministrativa con: 
		// oidPais = el pais activo 
		// oidMarca = el seleccionado en 'cbMarca' 
		// oidCanal = el seleccionado en 'cbCanal' 
		// Llamar al mÚtodo 'recargaCombo' con DTOUnidadAdministrativa y el IDBusiness="ZONRecargaRegiones" 
		// Con el DTOSalida obtenido, se carga el control 'cbRegion' 		
		var marca = get(FORMULARIO+'.cbMarca');
		if (marca != '') {
			var canal = get(FORMULARIO+'.cbCanal');
			if (canal != '') {
				var pais = get(FORMULARIO+'.pais');

				recargaCombo(
					FORMULARIO + '.cbRegiones',
					'ZONRecargaRegiones', 
					'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa', 
					[["oidPais", pais], ["oidMarca", marca], ["oidCanal", canal]]			
				);		
			}
		}		
	}
}

function vaciaCombo(combo) {
	set_combo(combo,[['','']],['']);
}

function fLimpiar() {
	vaciaCombo(FORMULARIO + '.cbPeriodo');
	vaciaCombo(FORMULARIO + '.cbRegiones');
	vaciaCombo(FORMULARIO + '.cbZonas');
	if(get(FORMULARIO + '.marca') != '') {
		set(FORMULARIO + '.cbMarca', [get(FORMULARIO + '.marca')]);
	}
	if(get(FORMULARIO + '.canal') != '') {
		set(FORMULARIO + '.cbCanal', [get(FORMULARIO + '.canal')]);
	}
	if (get(FORMULARIO + '.cbMarca') != '' && get(FORMULARIO + '.cbCanal') != '') {
		marcaOnChange();
	}

	focaliza(FORMULARIO + ".cbMarca");
}

function fVolver() {
	window.close();
}

function focalizaSiguiente(elemento) {
	focaliza(elemento);
}

function focalizaAnterior() {
	document.all['btnCerrar'].focus();
}

function cerrarOnClick() {
	
	// se comprueba que se han introducido todos los valores obligatorios	
	if (!sicc_validaciones_generales()) { 
		return false; 
	}
		
	if (datosCorrectos()) {
		set(FORMULARIO + ".accion", "cerrar");
		set(FORMULARIO + '.conectorAction', "LPCierreFacturacion");
		enviaSICC(FORMULARIO);
		
	} 
}

// modificado por incidencia BELC300011487
function regionOnSelect() {

	var tipoCierre = get(FORMULARIO+'.cbTipoCierre','T');

	if (tipoCierre == get(FORMULARIO+'.ConstantesFAC_TIPO_CIERRE_ZONA')) {
		// Se recarga 'lstZonas' 
		// Crear un objeto DTOUnidadAdministrativa con: 
		// - oidPais = el pais activo 
		// - oidMarca = el seleccionado en 'cbMarca' 
		// - oidCanal = el seleccionado en 'cbCanal' 
		// - oidRegion = el seleccionado en 'lstRegiones' 
	    // 
		// Llamar al metodo 'recargaCombo' con DTOUnidadAdministrativa y el IDBusiness="ZONRecargarZonas" 
        // 
		// Con el DTOSalida obtenido, se carga el control 'lstZonas' 

		var marca = get(FORMULARIO+'.cbMarca');
		if (marca != '') {
			var canal = get(FORMULARIO+'.cbCanal');
			if (canal != '') {
				var pais = get(FORMULARIO+'.pais');

				// hay que comprobar que solo se ha elegido una region
				// si no es asi habra que mostrar mensaje de aviso y salir del metodo

				var regionesSeleccionadas = new String(get(FORMULARIO+'.cbRegiones'));
				var listaTemporal = regionesSeleccionadas.split(",");
	
				var regionElegida = '';
				var numeroRegiones = 0;
				
				for (i=0; i<listaTemporal.length; i++) {
					if (listaTemporal[i] != '') {
						numeroRegiones++;
						if (numeroRegiones == 1) {
							regionElegida = listaTemporal[i];
						}
						if (numeroRegiones > 1) {
							break;
						}
					}
				}
				
				if (numeroRegiones != 1) { // lstRegiones tiene cero o mas de una seleccion
					// mensaje de error: "Cierre de Zonas: sólo puede seleccionarse una región"
					GestionarMensaje('UIFAC0009');
					return;
				} else {
					recargaCombo(
						FORMULARIO + '.cbZonas',
						'ZONRecargaZonas', 
						'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa', 
						[["oidPais", pais], ["oidMarca", marca], ["oidCanal", canal], ["oidRegion", regionElegida]]			
					);					
				}
			}
		}
	}
}


function datosCorrectos() {
	// Valida los datos de la pantalla "PantallaCierreFacturacion" 
	var tipoCierre = get(FORMULARIO+'.cbTipoCierre','T');
	
	if (tipoCierre == '') {
		// mensaje: "Debe completar datos"
		GestionarMensaje('UIFAC0010');
		return false;
	}

	var listaRegiones = '';
	var listaZonas = '';
				
	// Se muestra el mensaje "Tipo de cierre: " + tipoCierre 
	cdos_mostrarAlert("Tipo de cierre: " + get(FORMULARIO+'.cbTipoCierre','T'));
	 
	var regionesSeleccionadas = new String(get(FORMULARIO+'.cbRegiones'));
	var listaTemporal = regionesSeleccionadas.split(",");
	
	for (i=0; i<listaTemporal.length; i++)
	
	if (tipoCierre == get(FORMULARIO+'.ConstantesFAC_TIPO_CIERRE_REGION')) {
		if (listaTemporal.length == 1 && listaTemporal[0] == '') { // lstRegiones no tiene selecciones 
			// mensaje de error: "Debe completar datos"
			GestionarMensaje('UIFAC0010');
			return false;
		}
		
		/*ponerSeparador = false;
		for (i=0; i<listaTemporal.length; i++) {
			if (listaTemporal[i] != '') {
				alert('se añade: ' + listaTemporal[i]);				
				if (ponerSeparador) {
					listaRegiones += '|';
				}
				if (!ponerSeparador) {
					ponerSeparador = true;
				}
				listaRegiones += listaTemporal[i];
			}
		}*/
		listaRegiones = obtenerListaFormateada(listaTemporal);
		set(FORMULARIO+'.listaRegiones', [listaRegiones]);
		return true;		
	
	} else if (tipoCierre == get(FORMULARIO+'.ConstantesFAC_TIPO_CIERRE_ZONA')) {

		if (listaTemporal.length == 1 && listaTemporal[0] != '') { // lstRegiones tiene 1 una seleccion

			/*ponerSeparador = false;
			for (i=0; i<listaTemporal.length; i++) {
				if (listaTemporal[i] != '') {
					alert('se añade: ' + listaTemporal[i]);				
					if (ponerSeparador) {
						listaRegiones += '|';
					}
					if (!ponerSeparador) {
						ponerSeparador = true;
					}
					listaRegiones += listaTemporal[i];
				}
			}*/
			listaRegiones = obtenerListaFormateada(listaTemporal);

			var zonasSeleccionadas = new String(get(FORMULARIO+'.cbZonas'));
			listaTemporal = zonasSeleccionadas.split(",");	
			
			if (listaTemporal.length == 1 && listaTemporal[0] == '') { // no se ha seleccionado ninguna zona
				// cargar todas las zonas de 'lstZonas' en 'listaZonas'
				var todasLasZonas = document.all['cbZonas'][0].options;
				
				ponerSeparador = false;
				for (i=0; i<todasLasZonas.length; i++) {
					if (todasLasZonas[i].value != '') {
						if (ponerSeparador) {
							listaZonas += '|';
						}
						if (!ponerSeparador) {
							ponerSeparador = true;
						}
						listaZonas += todasLasZonas[i].value;
					}
				}
			} else {
				// se agnade la lista de zonas seleccionadas a 'listaZonas'
				/*ponerSeparador = false;
				for (i=0; i<listaTemporal.length; i++) {
					if (listaTemporal[i] != '') {
						alert('se añade: ' + listaTemporal[i]);				
						if (ponerSeparador) {
							listaZonas += '|';
						}
						if (!ponerSeparador) {
							ponerSeparador = true;
						}
						listaZonas += listaTemporal[i];
					}
				}*/
				listaZonas = obtenerListaFormateada(listaTemporal);
			}
			set(FORMULARIO+'.listaRegiones', [listaRegiones]);
			set(FORMULARIO+'.listaZonas', [listaZonas]);
			return true;
			
		} else { // lstRegiones tiene cero o mas de una seleccion
			// mensaje de error: "Cierre de Zonas: sólo puede seleccionarse una región"
			GestionarMensaje('UIFAC0009');
			return false;
		}
	}
	return true;
}

// recibe un Array con los elementos seleccionados en un combo multiple
// el primer elemento del Array puede ser vacio
// devuelve una lista con los elementos seleccionados distintos de vacio y separados por el caracter | 
function obtenerListaFormateada(listaSinFormato) {
	var listaConFormato = '';
	
	ponerSeparador = false;
	
	for (i=0; i<listaSinFormato.length; i++) {
		if (listaSinFormato[i] != '') {
			if (ponerSeparador) {
				listaConFormato += '|';
			}
			if (!ponerSeparador) {
				ponerSeparador = true;
			}
			listaConFormato += listaSinFormato[i];
		}
	}
	return listaConFormato;
}