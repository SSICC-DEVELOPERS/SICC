var FORMULARIO = "frmFormulario";

function onLoadPag()   {
  
    eval (ON_RSZ);  
    
    var errDescripcion = get(FORMULARIO +'.errDescripcion');
    
    configurarMenuSecundario(FORMULARIO);
    
    if (errDescripcion !='') {
         var errCodigo = get(FORMULARIO+'.errCodigo');
         var wnd = fMostrarMensajeError(errCodigo, errDescripcion);
    }
    
	if (get('frmFormulario.oidResultadoRevisionDef') != ''){
		set('frmFormulario.cbResultadoRevision', [get('frmFormulario.oidResultadoRevisionDef')]);
	}

	len = combo_get('frmFormulario.cbResultadoRevision', 'L');

	for(i = 0; i < len; i++){
		if (combo_get('frmFormulario.cbResultadoRevision', 'T', i) != ''){
			vMotivoDev = combo_get('frmFormulario.cbResultadoRevision', 'V', i);
			set('frmFormulario.cbResultadoRevision', [vMotivoDev])
			break;
		}
	}

    focaliza(FORMULARIO + '.cbResultadoRevision');
}

function aceptarOnClick(){
	set(FORMULARIO + '.accion', 'aceptarResultadoChequeo');
    set(FORMULARIO + '.conectorAction',"LPIntroducirResultadoChequeos");
    enviaSICC(FORMULARIO);
    //ejecutarCorrecta();
}

function obtenerIndicador(oid){
	for (i=0; i < datosAccesos.length; i ++){
		if (datosAccesos[i][0] == oid){
			return datosAccesos[i][2];
		}
	}
}

function ejecutarCorrecta(){
	var indicador = obtenerIndicador(get(FORMULARIO + '.cbResultadoRevision'));
	var cbResultadoRevisionText = get(FORMULARIO + '.cbResultadoRevision', 'T');
	var atxtObservaciones = get(FORMULARIO + '.atxtObservaciones');
	
	window.returnValue = [indicador, cbResultadoRevisionText, atxtObservaciones];
	window.close();
}

function cbResultadoOnShTab(){
	document.all['btnAceptar'].focus();
}

function aceptarOnTab(){
	focaliza(FORMULARIO + '.cbResultadoRevision');
}

function fVolver(){
	window.close();
}