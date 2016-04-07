	var FORMULARIO = 'formulario';

  	function onLoadPag() {		
		DrdEnsanchaConMargenDcho('listado1',12);
		eval(ON_RSZ);  

		if (get(FORMULARIO + '.errDescripcion') != '') {
			var wnd = fMostrarMensajeError(get(FORMULARIO + '.errCodigo'),get(FORMULARIO + '.errDescripcion'));
			if (get(FORMULARIO + '.casodeuso') != 'insertar')
				window.close();
		}

		menuSecundario();

		if (get(FORMULARIO + '.casodeuso') != "eliminar" && get(FORMULARIO + '.casodeuso') != "consultar")
			canalOnChange();
		if (get(FORMULARIO + '.casodeuso') == "eliminar" || get(FORMULARIO + '.casodeuso') == "consultar")
			if (get(FORMULARIO + '.casodeuso') == "consultar") {
				seleccionarConsultado();
			} else {
				bloquealista(); 
			}
		else {
			focaliza(FORMULARIO + ".cbCanal");
		}
	
   }
   
	function menuSecundario() {
		configurarMenuSecundario(FORMULARIO);
	}
   
	function accionEjecutada() {
		fMostrarMensajeExito("insertar");
		//fLimpiarGenericoSICC();
		fLimpiar();
	}

	function limpiaCombosDependientes() {
		vaciaCombo(FORMULARIO + '.cbAcceso');
		vaciaCombo(FORMULARIO + '.cbSubacceso');
		canalOnChange();
	}

	function fLimpiar() {
        var canal = get(FORMULARIO + '.canal');
		set(FORMULARIO + '.cbCanal', [canal]);
		limpiaCombosDependientes();
	}
	
	function fVolver() {
		window.close();
	}

	function canalOnChange() {
        var canal = get(FORMULARIO + '.cbCanal');
        var idioma = get(FORMULARIO + '.idioma');
        var pais = get(FORMULARIO + '.pais');
		vaciaCombo(FORMULARIO + '.cbAcceso');
		vaciaCombo(FORMULARIO + '.cbSubacceso');
		if (canal != "") 
			recargaCombo(FORMULARIO + '.cbAcceso', 'SEGObtenerAccesosPorCanal', 'es.indra.sicc.dtos.seg.DTOAccesosPorCanal',  [["oidPais", pais], ["oidIdioma", idioma], ["oidCanal", canal]], 'seleccionaAcceso(datos)');

	}

	function accesoOnChange() {
        var acceso = get(FORMULARIO + '.cbAcceso');
        var idioma = get(FORMULARIO + '.idioma');
        var pais = get(FORMULARIO + '.pais');
		vaciaCombo(FORMULARIO + '.cbSubacceso');
		if (acceso != "")
			recargaCombo(FORMULARIO + '.cbSubacceso', 'SegObtenerSubaccesosPorAcceso', 'es.indra.sicc.util.DTOOID',  [["oidPais", pais], ["oidIdioma", idioma], ["oid", acceso]], 'seleccionaSubacceso(datos)' );
	}


	function vaciaCombo(combo) {
		if (eval('document.'+combo) != undefined) 
			set_combo(combo,[['','']],['']);
		return true;
	}

	function fGuardar() {
		if (listado1.numSelecc() == 0) {
			//Mostramos mensaje de error 
			GestionarMensaje('50');
		} else if (sicc_validaciones_generales()) {
			//Llamar a la lp "LPMantenimientoMediosPagoBelcenter" con acción "guardar"
			set(FORMULARIO + '.accion','guardar');
			set(FORMULARIO + '.conectorAction',"LPMantenimientoMediosPagoBelcenter");
			enviaSICC(FORMULARIO);
		}
	}


	function seleccionarConsultado(){
		var  oidMediosPago = get(FORMULARIO + '.hOidMedioPago');
		listado1.actualizaDat();
		for (j = 0; j < listado1.datos.length; j++) {
				if (listado1.datos[j][0] == oidMediosPago) {
   					listado1.selecciona(j);
                    break;                               
   				}
   			listado1.desactiva(j);//Desactivamos la fila
		}
	}

	function bloquealista() {
		var  mediosPago = get(FORMULARIO + '.hmediosPago');
		var filasSeleccionadas = mediosPago.split(',');
		listado1.actualizaDat();
		for (j = 0; j < listado1.datos.length; j++) {
			for (i = 0; i < filasSeleccionadas.length; i++) {
				if (listado1.datos[j][0] == filasSeleccionadas[i]) {
   					listado1.selecciona(j);
                    break;                               
   				}
   			}
   			listado1.desactiva(j);//Desactivamos la fila

		}
   
	}
	
	function seleccionaAcceso(datos) {
		var acceso = get(FORMULARIO + '.acceso');
		set_combo(FORMULARIO+'.cbAcceso', incluyeOpcionVacia(datos));
		set(FORMULARIO + '.cbAcceso', [acceso]);
		accesoOnChange();
	}
		
	function seleccionaSubacceso(datos) {
		var subacceso = get(FORMULARIO + '.subacceso');
		set_combo(FORMULARIO+'.cbSubacceso', incluyeOpcionVacia(datos));
		set(FORMULARIO + '.cbSubacceso', [subacceso]);
	}
	
// Incluye la opcion vacia al principio del array 
function incluyeOpcionVacia(datos) {
	var datos2 = new Array();
	datos2[0] = ['',''];
	
	for (var i=0;i<datos.length;i++) {
    	datos2[i+1] = datos[i];
	}
	return datos2;
}
