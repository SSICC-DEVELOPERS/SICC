var FORMULARIO = 'frmFormulario';

function onLoadPag(){
	
	if (get(FORMULARIO+'.errDescripcion')!='') {
	  var wnd = fMostrarMensajeError(get(FORMULARIO+'.errCodigo'),get(FORMULARIO+'.errDescripcion'));
	}	
	setTimeout("comprobarBatch();",5000);
}

function comprobarBatch(){
	
	frmFormulario.oculto='S';	
	set(FORMULARIO+'.accion','comprobar_batch');
	set(FORMULARIO+'.conectorAction','LPAdam');
	enviaSICC(FORMULARIO);	
	
}

function vueltaIgual(){	

	setTimeout("comprobarBatch();",5000);	
}

function cerrarVentana(correcto,estado){
	//se devuelve el numero de lote, si ha existido error y el estado.
	var vuelta=correcto+"|"+estado+"|"+get(FORMULARIO+'.hNumeroLote');
	window.returnValue = vuelta.split("|");
	window.close();
	
}