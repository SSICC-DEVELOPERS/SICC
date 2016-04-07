function onLoadPag() {
	configurarMenuSecundario('formulario');
	var acc = get('formulario.accion');
	var opcionMenu = get('formulario.opcionMenu');

	if (opcionMenu == 'insertar') {
		var oidCentroDist = get('formulario.hOidCentroDistribucionDefecto');
		set('formulario.cbCentroDistribucion', new Array(oidCentroDist));
		onChangeCbCentroDistribucion();
		set('formulario.hOidCentroAnterior', oidCentroDist);
		focaliza('formulario.cbCentroDistribucion');
	} else if (opcionMenu == 'modificar') {

		// Cargo cbCentroDistribucion con el valor que viene de la LP y lo deshabilito
		var oidCentroDist = get('formulario.hOidCentroDistribucion');
		var descCentroDist = get('formulario.hDescCentroDistribucion');
		set_combo('formulario.cbCentroDistribucion', new Array([oidCentroDist, descCentroDist]));
		set('formulario.cbCentroDistribucion', new Array(oidCentroDist));
		accion('formulario.cbCentroDistribucion', '.disabled = true');

		// Cargo cbLineaArmado con el valor que viene de la LP y lo deshabilito
		var oidLineaArmado = get('formulario.hOidLineaArmado');
		var descLineaArmado = get('formulario.hDescLineaArmado');
		set_combo('formulario.cbLineaArmado', new Array([oidLineaArmado, descLineaArmado]));
		set('formulario.cbLineaArmado', new Array(oidLineaArmado));
		accion('formulario.cbLineaArmado', '.disabled = true');

		// Seteo el porcentaje que manda la LP
		var porcentaje = get('formulario.hPorcentajeVariacion');
		set('formulario.txtPorcentajeVariacion', porcentaje);

		// Cargo cbFuncionDistribucion y selecciono el valor matching
		var oidFuncion = get('formulario.hOidFuncionDistribucion');
		set('formulario.cbFuncionDistribucion', new Array(oidFuncion));
		focaliza('formulario.txtPorcentajeVariacion');
	}

	if (acc == 'detalle') {
		// Obtengo los valores que mando la LP
		var descCentroDist = get('formulario.hDescCentroDistribucion');
		var descLineaArmado = get('formulario.hDescLineaArmado');
		var porcentaje = get('formulario.hPorcentajeVariacion');
		var descFuncion = get('formulario.hDescFuncionDistribucion');

		// Asigno los valores
		set_combo('formulario.cbCentroDistribucion', new Array(['', descCentroDist]));
		set_combo('formulario.cbLineaArmado', new Array(['', descLineaArmado]));
		set('formulario.txtPorcentajeVariacion', porcentaje);
		set_combo('formulario.cbFuncionDistribucion', new Array(['', descFuncion]));

		// Deshabilito todo
		accion('formulario.cbCentroDistribucion', '.disabled = true');
		accion('formulario.cbLineaArmado', '.disabled = true');
		accion('formulario.txtPorcentajeVariacion', '.disabled = true');
		accion('formulario.cbFuncionDistribucion', '.disabled = true');
	}
}

//--------------------------------------------------------------------------------------------------------

function onChangeCbCentroDistribucion() {
	var oidCentro = get('formulario.cbCentroDistribucion', 'V');

	/* dmorello, 23/01/2007 */
	if (get('formulario.hOidCentroAnterior') == get('formulario.hOidCentroDistribucionDefecto')) {
		/* dmorello, 14/03/2007: Se pasa el siguiente bloque a una funcion aparte */
		//var comboLineasCentroDefecto = ''; 
		//var longInicComboLineas = combo_get('formulario.cbLineaArmado', 'L'); 
		//for (var i = 1; i < longInicComboLineas; ) { 
		//	var value = combo_get('formulario.cbLineaArmado', 'V', i); 
		//	var tag = combo_get('formulario.cbLineaArmado', 'T', i); 
		//	comboLineasCentroDefecto += value + '\t' + tag; 
		//	if (++i < longInicComboLineas) { 
		//		comboLineasCentroDefecto += '\t' 
		//	} 
		//} 
		//set('formulario.hDatosComboLineasCentroDefecto', comboLineasCentroDefecto); 
		guardarHiddenLineasCDPorDefecto();
		/* Fin dmorello 14/03/2007 */
	}
	/* Fin dmorello 23/01/2007 */ 
	
	if (oidCentro != '') {

		var array = new Array();
		array[0] = new Array('oid',oidCentro);
		array[1] = new Array('oidIdioma',get('formulario.varIdioma'));

		recargaCombo('formulario.cbLineaArmado',
 					'APEObtenerLineasArmadoCD',
 					'es.indra.sicc.util.DTOOID',
 					array,
 					'setearCbLineaArmado(datos)');

		/* TODO: Seleccionar linea de armado por defecto */

	} else {
		set_combo('formulario.cbLineaArmado', new Array(['','']));
	}

	// dmorello, 23/01/2007
	set('formulario.hOidCentroAnterior', oidCentro);

}

//--------------------------------------------------------------------------------------------------------

function setearCbLineaArmado(datos) {
	var arrayNuevo = new Array();
	arrayNuevo[0] = new Array('','');
	arrayNuevo = arrayNuevo.concat(datos);
	set_combo('formulario.cbLineaArmado',arrayNuevo);

	/* dmorello, 19/01/2007: Se agrega la seleccion de la linea por defecto */
	var longitudCombo = combo_get('formulario.cbLineaArmado', 'L');
	var oidsLineasDef = get('formulario.hOidsLineasArmadoDefecto').split('|');
	// Comienzo desde 1 para obviar la primera linea, que se que esta en blanco
	for (var i = 1; i < longitudCombo; i++) {
		var value = combo_get('formulario.cbLineaArmado', 'V', i);
		for (var j = 0; j < oidsLineasDef.length; j++) {
			if (value == oidsLineasDef[j]) {
				set('formulario.cbLineaArmado', new Array(value));
				// Salgo de los FOR anidados
				j = oidsLineasDef.length;
				i = longitudCombo;
			}
		}
	}
	/* Fin dmorello 19/01/2007 */
}

//--------------------------------------------------------------------------------------------------------

function onTab(campo) {

	if (campo == 'cbCentroDistribucion') {
		focaliza('formulario.cbLineaArmado');
	} else if (campo == 'cbLineaArmado') {
		focaliza('formulario.txtPorcentajeVariacion');
	} else if (campo == 'txtPorcentajeVariacion') {
		focaliza('formulario.cbFuncionDistribucion');
	} else if (campo == 'cbFuncionDistribucion') {
		if (get('formulario.opcionMenu') == 'insertar') {
			focaliza('formulario.cbCentroDistribucion');
		} else {
			focaliza('formulario.txtPorcentajeVariacion');
		}
	}

}

//--------------------------------------------------------------------------------------------------------

function onClickGuardar() {
	if (! sicc_validaciones_generales()) {
		  return false;
	}

	// Paso los valores de los campos a las variables hidden
	set('formulario.hOidCentroDistribucion', get('formulario.cbCentroDistribucion', 'V'));
	set('formulario.hOidLineaArmado', get('formulario.cbLineaArmado', 'V'));
	// dmorello, 27/09/2007
	var txtPorcentaje = get('formulario.txtPorcentajeVariacion');
	if (txtPorcentaje != '') {
		var porcentaje = numeroDeFormatoSICC(txtPorcentaje); // Quito el formato
		set('formulario.hPorcentajeVariacion', porcentaje);
	} else {
		set('formulario.hPorcentajeVariacion', txtPorcentaje);
	}
	// Fin dmorello 27/09/2007
	set('formulario.hOidFuncionDistribucion', get('formulario.cbFuncionDistribucion', 'V'));

	/* dmorello, 14/03/2007
	 * Si no se seleccionó un CD diferente del CD por defecto, guardo el contenido del combo de lineas
	 */
	if (get('formulario.cbCentroDistribucion') == get('formulario.hOidCentroDistribucionDefecto')
				&& get('formulario.hDatosComboLineasCentroDefecto') == '') {

		guardarHiddenLineasCDPorDefecto();
	}
	/* Fin dmorello 14/03/2007 */

	// Envio el formulario
	eval('formulario').oculto = 'S';
	set('formulario.conectorAction', 'LPMantenerConfiguracionBalanceo');
	set('formulario.accion', 'guardar');
	// dmorello, 27/09/2007
	set('formulario.casoDeUso', get('formulario.opcionMenu'));
	// Fin dmorello 27/09/2007
	enviaSICC('formulario');
}

//--------------------------------------------------------------------------------------------------------

function onShiftTab(campo) {
	if (campo == 'cbCentroDistribucion') {
		focaliza('formulario.cbFuncionDistribucion');
	} else if (campo == 'cbLineaArmado') {
		focaliza('formulario.cbCentroDistribucion');
	} else if (campo == 'txtPorcentajeVariacion') {
		if (get('formulario.opcionMenu') == 'insertar') {
			focaliza('formulario.cbLineaArmado');
		} else {
			focaliza('formulario.cbFuncionDistribucion');
		}
	} else if (campo == 'cbFuncionDistribucion') {
		focaliza('formulario.txtPorcentajeVariacion');
	}
}

//--------------------------------------------------------------------------------------------------------

function guardoCorrectamente(opcionMenu) {
	if (opcionMenu == 'insertar') {
		fLimpiar();
	}
}

//--------------------------------------------------------------------------------------------------------

function fGuardar() {
	onClickGuardar();
}

//--------------------------------------------------------------------------------------------------------

function fLimpiar() {
	var opcionMenu = get('formulario.opcionMenu');
	if (opcionMenu == 'insertar') {
		set('formulario.cbCentroDistribucion', new Array(get('formulario.hOidCentroDistribucionDefecto')));
		/* dmorello, 23/01/2007: Mejora para evitar acceder a BD al limpiar */ 
		//onChangeCbCentroDistribucion(); 
		var comboLineasCentroDefecto = get('formulario.hDatosComboLineasCentroDefecto'); 
		var arrayDatosCombo = new Array(); 
		var elementosCombo = comboLineasCentroDefecto.split('\t'); 
		for (var i = 0; i < elementosCombo.length; ) { 
			var value = elementosCombo[i++]; 
			var tag = elementosCombo[i++]; 
			arrayDatosCombo[arrayDatosCombo.length] = new Array(value, tag); 
		} 
		setearCbLineaArmado(arrayDatosCombo);
		set('formulario.hOidCentroAnterior', get('formulario.hOidCentroDistribucionDefecto'));

		/* Fin dmorello 23/01/2007 */ 

		set('formulario.txtPorcentajeVariacion', '');
		set('formulario.cbFuncionDistribucion', new Array(''));
	} else if (opcionMenu == 'modificar') {
		set('formulario.txtPorcentajeVariacion', get('formulario.hPorcentajeVariacion'));
		set('formulario.cbFuncionDistribucion', new Array(get('formulario.hOidFuncionDistribucion')));
	}
}

//--------------------------------------------------------------------------------------------------------

function fVolver() {
	window.close();
}

//--------------------------------------------------------------------------------------------------------

function guardarHiddenLineasCDPorDefecto() {
	var comboLineasCentroDefecto = ''; 
	var longInicComboLineas = combo_get('formulario.cbLineaArmado', 'L'); 
	for (var i = 1; i < longInicComboLineas; ) { 
		var value = combo_get('formulario.cbLineaArmado', 'V', i); 
		var tag = combo_get('formulario.cbLineaArmado', 'T', i); 
		comboLineasCentroDefecto += value + '\t' + tag; 
		if (++i < longInicComboLineas) { 
			comboLineasCentroDefecto += '\t' 
		} 
	} 
	set('formulario.hDatosComboLineasCentroDefecto', comboLineasCentroDefecto); 
}