function onLoadPag() {
	focaliza('frmAnadirActividad.cbActividad');
	setMV('frmAnadirActividad.cbActividad','N');
	setMV('frmAnadirActividad.cbZona','N');
	setMV('frmAnadirActividad.txtDiasParaEjecucion','N');
	setMV('frmAnadirActividad.txtCadaCuantosDias','N');
	setMV('frmAnadirActividad.txtFechaFinal','N');
	configurarMenuSecundario("frmAnadirActividad");
	set('frmAnadirActividad.hlblActiFija',GestionarMensaje('1002'));
	set('frmAnadirActividad.hlblActiRefe',GestionarMensaje('1003'));
	btnProxy(1, '0');
	btnProxy(3, '0');

	accion('frmAnadirActividad.cbPeriodoReferencia', '.disabled = true');
}

function onChangeCbActividad() {

	var oidActiv = get('frmAnadirActividad.cbActividad', 'V')[0];
	if (oidActiv != '') {
		set('frmAnadirActividad.hOidActividad', oidActiv);
		set('frmAnadirActividad.accion', 'obtenerInfoActividad');
		set('frmAnadirActividad.conectorAction', 'LPMantieneCronograma');
		eval('frmAnadirActividad').oculto = 'S';

		enviaSICC('frmAnadirActividad');
	} else {
		set('frmAnadirActividad.hOidActividad', '');
		accion('frmAnadirActividad.cbPeriodoReferencia', '.disabled = true');
	}

}

function setInfoActividadOrigen(tipoActividad, oidActivOrigen, codActivOrigen, nombreActivOrigen, diasDesplazamiento) {
	set('frmAnadirActividad.hTipoActividad', tipoActividad);
	set('frmAnadirActividad.hOidActividadOrigen', oidActivOrigen);
	set('frmAnadirActividad.hCodActividadOrigen', codActivOrigen);
	set('frmAnadirActividad.hNombreActividadOrigen', nombreActivOrigen);
	set('frmAnadirActividad.hDiasDesplazamiento', diasDesplazamiento);

	if (tipoActividad == get('frmAnadirActividad.hConstanteActividadConRefeOtroPeriodo')) {
		accion('frmAnadirActividad.cbPeriodoReferencia', '.disabled = false');
	} else {
		accion('frmAnadirActividad.cbPeriodoReferencia', '.disabled = true');
	}
}


function aceptar() {
	if (!sicc_validaciones_generales("grupo1"))
		return;

	// Si la actividad es de tipo Referencia otro periodo,
	// verifico que el periodo de referencia no sea el mismo del cronograma que se esta modificando
	if (get('frmAnadirActividad.hTipoActividad') == get('frmAnadirActividad.hConstanteActividadConRefeOtroPeriodo')) {
		var oidPeriodoReferencia = get('frmAnadirActividad.cbPeriodoReferencia', 'V')[0]
		if (oidPeriodoReferencia == get('frmAnadirActividad.hOidPeriodo')) {
			GestionarMensaje('CRA001');
			return;
		} else if (oidPeriodoReferencia == '') {
			GestionarMensaje('CRA001.2')
		}
	}

	if (!validaNumero(get('frmAnadirActividad.txtDiasParaEjecucion'))) {
		GestionarMensaje('1297',sicc_obtenerDescripcion('txtDiasParaEjecucion'));
		focaliza('frmAnadirActividad.txtDiasParaEjecucion');       
		return;
	}
	if (!esHoraValida('frmAnadirActividad.txtHoraEjecucion')) {
		GestionarMensaje('2516');
		focaliza('frmAnadirActividad.txtHoraEjecucion');
		return;
	}
	if (!validaNumero(get('frmAnadirActividad.txtCadaCuantosDias'))) {
		//GestionarMensaje('1514',sicc_obtenerDescripcion('txtCadaCuantosDias'));
		GestionarMensaje('1297',sicc_obtenerDescripcion('txtCadaCuantosDias'));
		focaliza('frmAnadirActividad.txtCadaCuantosDias');       
		return;
	}
	if (!validaNumero(get('frmAnadirActividad.txtFechaFinal'))) {
		GestionarMensaje('1297',sicc_obtenerDescripcion('txtFechaFinal'));
		focaliza('frmAnadirActividad.txtFechaFinal');       
		return;
	}


	set('frmAnadirActividad.accion', 'guardarActividad');
	set('frmAnadirActividad.conectorAction', 'LPMantieneCronograma');
	set('frmAnadirActividad.casoDeUso', 'ModificaCronograma');
	set('frmAnadirActividad.hCbPais', get('frmAnadirActividad.hCbPais'));
	set('frmAnadirActividad.hMarca', get('frmAnadirActividad.hMarca'));
	set('frmAnadirActividad.hCanal', get('frmAnadirActividad.hCanal'));
	set('frmAnadirActividad.hCodPeriodo', get('frmAnadirActividad.hCodPeriodo'));
	set('frmAnadirActividad.hGrupoZona', get('frmAnadirActividad.hGrupoZona'));
	set('frmAnadirActividad.hSubgerencia', get('frmAnadirActividad.hSubgerencia'));
	set('frmAnadirActividad.hRegion', get('frmAnadirActividad.hRegion'));
	set('frmAnadirActividad.hZona', get('frmAnadirActividad.hZona'));

	set('frmAnadirActividad.hIdVista', get('frmAnadirActividad.cbActividad'));
	set('frmAnadirActividad.hZonaNue', get('frmAnadirActividad.cbZona'));
	set('frmAnadirActividad.hTextoAct', get( 'frmAnadirActividad.cbActividad', 'T'));
	set('frmAnadirActividad.hTextoZona', get( 'frmAnadirActividad.cbZona', 'T'));
	set('frmAnadirActividad.hRadioFija', get('frmAnadirActividad.rbActividadFija'));
	set('frmAnadirActividad.hHoraEjec', get('frmAnadirActividad.txtHoraEjecucion'));
	set('frmAnadirActividad.hRepetitiva', get('frmAnadirActividad.chkRepetitiva'));
	set('frmAnadirActividad.hCadaDias', get('frmAnadirActividad.txtCadaCuantosDias'));
	set('frmAnadirActividad.hFechaFin', get('frmAnadirActividad.txtFechaFinal'));
	set('frmAnadirActividad.hRadioAsoc', get('frmAnadirActividad.rbAnadirActividadesAsociadas'));
	set('frmAnadirActividad.hDiasEjec', get('frmAnadirActividad.txtDiasParaEjecucion'));

	set('frmAnadirActividad.hOidPeriodoReferencia', get('frmAnadirActividad.cbPeriodoReferencia', 'V')[0]);
	set('frmAnadirActividad.hNombrePeriodoReferencia', get('frmAnadirActividad.cbPeriodoReferencia', 'T')[0]);

	eval('frmAnadirActividad').oculto = 'N';
	enviaSICC('frmAnadirActividad');
}


function esHoraValida(campo) {
	var hora = get(campo);
	if (cdos_trim(hora) == "")
		return true;
	var numeros = "0123456789:";
	var c;
	var i;
	for (i = 0; i < hora.length; i++) {
		c = hora.charAt(i);
		if (numeros.indexOf(c) == -1) 
		return false;
	}
	var aHora = hora.split(':');
	//alert("aHora: "+aHora);
	if (aHora.length != 3) 
		return false;
	for (i = 0; i < aHora.length; i++) {
		if (aHora[i].length > 2 || aHora[i].length < 1)
			return false;
		if (!validaPositivo(aHora[i]))
			return false;
	}
	if (parseInt(aHora[0],10) < 0 || parseInt(aHora[0],10) > 23)
		return false;
	if (parseInt(aHora[1],10) < 0 || parseInt(aHora[1],10) > 59)
		return false;
	if (parseInt(aHora[2],10) < 0 || parseInt(aHora[2],10) > 59)
		return false;

	return true;
}

function validaPositivo(sNum) {
	sNum = cdos_trim(sNum);
	var numeros = "0123456789";
	var c;
	var j;
	for (j = 0; j < sNum.length; j++) {
		c = sNum.charAt(j);
		if (numeros.indexOf(c) == -1) 
			return false;
	}
	return true;
}


function validaNumero(sNum) {
	sNum = cdos_trim(sNum);
	var numeros = "0123456789";
	var c = sNum.charAt(0);
	var j;
	if (numeros.indexOf(c) == -1 && c != "-")
		return false;
	if (c == "-" && sNum.length == 1)
		return false;
	for (j = 1; j < sNum.length; j++) {
		c = sNum.charAt(j);
		if (numeros.indexOf(c) == -1) 
			return false;
	}
	return true;
}

function fVolver() {
	history.back();
}

function fLimpiar() {
	document.all["rbAnadirActividadesAsociadas"][0].checked = true;
	document.all["rbActividadFija"][0].checked = true;
	document.all["chkRepetitiva"][0].checked = false;
}

function onTab(campo) {
	if (campo == 'cbActividad') {
		focaliza('frmAnadirActividad.cbZona');
	} else if (campo == 'cbZona') {
		focaliza('frmAnadirActividad.txtDiasParaEjecucion');
	} else if (campo == 'txtDiasParaEjecucion') {
		focaliza('frmAnadirActividad.txtHoraEjecucion');
	} else if (campo == 'txtHoraEjecucion') {
		focaliza('frmAnadirActividad.cbPeriodoReferencia');
	} else if (campo == 'cbPeriodoReferencia') {
		focaliza('frmAnadirActividad.chkRepetitiva');
	} else if (campo == 'chkRepetitiva') {
		focaliza('frmAnadirActividad.txtCadaCuantosDias');
	} else if (campo == 'txtCadaCuantosDias') {
		focaliza('frmAnadirActividad.txtFechaFinal');
	} else if (campo == 'txtFechaFinal') {
		focaliza('frmAnadirActividad.rbAnadirActividadesAsociadas');
	} else if (campo == 'rbAnadirActividadesAsociadas') {
		focaliza('frmAnadirActividad.rbActividadFija');
	} else if (campo == 'rbActividadFija') {
		focalizaBotonHTML('botonContenido', 'btnAceptar');
	} else if (campo == 'btnAceptar') {
		focaliza('frmAnadirActividad.cbActividad');
	}
}

function onShiftTab(campo) {
	if (campo == 'cbActividad') {
		focalizaBotonHTML('botonContenido', 'btnAceptar');
	} else if (campo == 'cbZona') {
		focaliza('frmAnadirActividad.cbActividad');
	} else if (campo == 'txtDiasParaEjecucion') {
		focaliza('frmAnadirActividad.cbZona');
	} else if (campo == 'txtHoraEjecucion') {
		focaliza('frmAnadirActividad.txtDiasParaEjecucion');
	} else if (campo == 'cbPeriodoReferencia') {
		focaliza('frmAnadirActividad.txtHoraEjecucion');
	} else if (campo == 'chkRepetitiva') {
		focaliza('frmAnadirActividad.cbPeriodoReferencia');
	} else if (campo == 'txtCadaCuantosDias') {
		focaliza('frmAnadirActividad.chkRepetitiva');
	} else if (campo == 'txtFechaFinal') {
		focaliza('frmAnadirActividad.txtCadaCuantosDias');
	} else if (campo == 'rbAnadirActividadesAsociadas') {
		focaliza('frmAnadirActividad.txtFechaFinal');
	} else if (campo == 'rbActividadFija') {
		focaliza('frmAnadirActividad.rbAnadirActividadesAsociadas');
	} else if (campo == 'btnAceptar') {
		focaliza('frmAnadirActividad.rbActividadFija');
	}
}
