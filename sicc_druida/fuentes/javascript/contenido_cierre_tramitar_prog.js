var FORMULARIO = 'frmFormulario';

function onLoadPag() {
	configurarMenuSecundario(FORMULARIO);
        var errDescripcion = get(FORMULARIO +'.errDescripcion');
         if (errDescripcion !='') {            
                  var errCodigo = get(FORMULARIO+'.errCodigo');
                  var wnd = fMostrarMensajeError(errCodigo, errDescripcion);
         }
	
	
	//focaliza(FORMULARIO + ".cbMarca");

  set(FORMULARIO + '.cbMarca', [2003]);
  set(FORMULARIO + '.cbCanal', [2001]);
	
	// al cargar la pagina los combos marca y canal estaran preseleccionados.
	// tendran los valores por defecto para el usuario actual
	// llamo a marcaOnChange para que se cargue el combo cbPeriodo
	marcaOnChange();

	//PER-SiCC-2011-0544
	accion(FORMULARIO+'.cbMarca', '.disabled=true');
	accion(FORMULARIO+'.cbCanal', '.disabled=true');
	
	//accion(FORMULARIO+'.cbRegiones', '.disabled=true');
	//accion(FORMULARIO+'.cbZonas', '.disabled=true');
	
	//PER-SiCC-2011-0079 - Sergio Apaza - 15/02/2011
	document.getElementById("fecha").innerHTML = get(FORMULARIO+'.hFecha');
	document.all['btnCerrar'].disabled=true;
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
			[["pais", pais]],
			'setearPeriodo(datos)'			
		);

	    // vaciar 'cbRegiones', 'cbZonas'
		vaciaCombo(FORMULARIO + '.cbRegiones');
		vaciaCombo(FORMULARIO + '.cbZonas');
	}
}

function setearPeriodo(datos){
	if(datos.length > 0){
		asignarArrayACombo(datos, 'cbPeriodo');
		set(FORMULARIO + '.cbPeriodo', [get(FORMULARIO + '.hOidPeriodo')]);
		accion(FORMULARIO + '.cbPeriodo', '.disabled=true');
	}
}

function asignarArrayACombo(datos, combo){
	if( datos != null && datos.length > 0 ){
        //combo_add('formulario.cbPeriodo', '', '');
        for(i = 0; i < datos.length; i++){
			combo_add(FORMULARIO + '.' + combo, datos[i][0], datos[i][1]);
        }
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
	
	document.all['btnCerrar'].disabled=true;
	vaciaCombo(FORMULARIO + '.cbRegiones');
	vaciaCombo(FORMULARIO + '.cbZonas');
	
	if (tipoCierre == get(FORMULARIO+'.ConstantesFAC_TIPO_CIERRE_PERIODO')) {
		
		// desactivar control 'cbRegion'
		//accion(FORMULARIO+'.cbRegiones', '.disabled=true');
		// desactivar control 'cbZona' 
		//accion(FORMULARIO+'.cbZonas', '.disabled=true');

		// Se carga 'cbPeriodo' 
		var oidPeriodo = get(FORMULARIO+'.hOidPeriodo');
		var fecha = get(FORMULARIO+'.hFecha');
		var formatoFecha = get(FORMULARIO+'.hFormatoFecha');

		recargaCombo(
			FORMULARIO + '.cbRegiones',
			'FACObtenerDatosPeriodo', 
			'es.indra.sicc.dtos.fac.DTODatosProgramaCierre', 
			[["oidPeriodo", oidPeriodo], ["fecha", fecha], ["formatoFecha", formatoFecha],["tipoCierre", "P"]],
			'setearTipoCierrePeriodo(datos)');

	} else if (tipoCierre == get(FORMULARIO+'.ConstantesFAC_TIPO_CIERRE_REGION')) {
		// activar control 'cbRegion' 
		//accion(FORMULARIO+'.cbRegiones', '.disabled=false');
		// desactivar control 'cbZona' 
		//accion(FORMULARIO+'.cbZonas', '.disabled=true');
		
		// Se carga 'cbRegion' 
		var oidPeriodo = get(FORMULARIO+'.hOidPeriodo');
		var fecha = get(FORMULARIO+'.hFecha');
		var formatoFecha = get(FORMULARIO+'.hFormatoFecha');

		recargaCombo(
			FORMULARIO + '.cbRegiones',
			'FACObtenerRegiones', 
			'es.indra.sicc.dtos.fac.DTODatosProgramaCierre', 
			[["oidPeriodo", oidPeriodo], ["fecha", fecha], ["formatoFecha", formatoFecha],["tipoCierre", "R"]],
			'setearTipoCierreRegion(datos)'			
		);		

	} else if (tipoCierre == get(FORMULARIO+'.ConstantesFAC_TIPO_CIERRE_ZONA')) {
		
		// activar control 'cbRegion'
		//accion(FORMULARIO+'.cbRegiones', '.disabled=false');
		// activar control 'cbZona'
		//accion(FORMULARIO+'.cbZonas', '.disabled=false'); 

		// // Se carga 'cbZona' 
		var oidPeriodo = get(FORMULARIO+'.hOidPeriodo');
		var fecha = get(FORMULARIO+'.hFecha');
		var formatoFecha = get(FORMULARIO+'.hFormatoFecha');
		
		recargaCombo(
			FORMULARIO + '.cbZonas',
			'FACObtenerZonas', 
			'es.indra.sicc.dtos.fac.DTODatosProgramaCierre', 
			[["oidPeriodo", oidPeriodo], ["fecha", fecha], ["formatoFecha", formatoFecha],["tipoCierre", "Z"]],
			'setearTipoCierreZona(datos)'			
		);		
	}
}

function setearTipoCierrePeriodo(datos){
	if (datos.length > 0) {
		document.all['btnCerrar'].disabled=false;
	} else {
		GestionarMensaje('3388');
		return;
	}
}

function setearTipoCierreRegion(datos){
	if (datos.length > 0) {
		asignarArrayACombo(datos, 'cbRegiones');
		document.all['btnCerrar'].disabled=false;
	} else {
		GestionarMensaje('3387');
		return;
	}
}

function setearTipoCierreZona(datos){
	if (datos.length > 0) {
		asignarArrayACombo(datos, 'cbZonas');
		document.all['btnCerrar'].disabled=false;
	} else {
		GestionarMensaje('3386');
		return;
	}
}

function vaciaCombo(combo) {
	set_combo(combo,[['','']],['']);
	noCambioRegion();
	noCambioZona();
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
	 
	var regionesSeleccionadas = new String(getTodos('cbRegiones'));
	var listaTemporal = regionesSeleccionadas.split(",");
	
	if (tipoCierre == get(FORMULARIO+'.ConstantesFAC_TIPO_CIERRE_REGION')) {
		listaRegiones = obtenerListaFormateada(listaTemporal);
		set(FORMULARIO+'.listaRegiones', [listaRegiones]);
		return true;		
	
	} else if (tipoCierre == get(FORMULARIO+'.ConstantesFAC_TIPO_CIERRE_ZONA')) {
		listaRegiones = obtenerListaFormateada(listaTemporal);

		var zonasSeleccionadas = new String(getTodos('cbZonas'));
		listaTemporal = zonasSeleccionadas.split(",");	
		listaZonas = obtenerListaFormateada(listaTemporal);

		set(FORMULARIO+'.listaRegiones', [listaRegiones]);
		set(FORMULARIO+'.listaZonas', [listaZonas]);
		return true;
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

function getTodos(combo) {
	var token=new Array();
	var valor="";
	var contador=0;
	var auxcombo = document.getElementById(combo);

	for(var j=1;j<auxcombo.length;j++) {
		token[contador++]=auxcombo.options[j].value;
	}
	valor = token;
	return valor;
}	

function noCambioRegion() {
	var combo_region = document.getElementById('cbRegiones');
	combo_region.selectedIndex = -1;
}

function noCambioZona() {
	var combo_region = document.getElementById('cbZonas');
	combo_region.selectedIndex = -1;
}
	