var FORMULARIO = 'formulario';

function onLoadPag() {
	
	configurarMenuSecundario(FORMULARIO);
		
	// para que se redimensione correctamente la lista editable
	DrdEnsanchaConMargenDcho('datosHojaDemanda',12);
	eval (ON_RSZ);
	
	// para que se muestren las posibles excepciones
	var errDescripcion = get(FORMULARIO +'.errDescripcion');
	if (errDescripcion != '') {		
		var errCodigo = get(FORMULARIO + '.errCodigo');
		var wnd = fMostrarMensajeError(errCodigo, errDescripcion); // si no funciona asi probar con fMostrarMensajeError
	}
	
	// se pasa el foco al boton actualizar
	document.all['btnActualizar'].focus();
}


function accionActualizar() {

	// (1) Si se ha seleccionado m�s de una l�nea en la lista "datosHojaDemanda" entonces 
	// Mostrar el mensaje gen�rico de error que informe al usuario de que s�lo se puede seleccionar una l�nea 
	if (datosHojaDemanda.numSelecc() != 1 ) {
      GestionarMensaje('1022');
   } else {
   	// Llamar a la lp "LPActualizarHojaDemanda" con acci�n = "actualizar" 

		var codigosSeleccionados = datosHojaDemanda.codSeleccionados();

		// asigno a un campo oculto el oid del registro seleccionado
		set(FORMULARIO + ".oidSeleccionado", codigosSeleccionados);
      
      set(FORMULARIO + ".accion", "actualizar");
      set(FORMULARIO + ".conectorAction", "LPActualizarHojaDemanda");
      enviaSICC(FORMULARIO);
	}
}


function dejarFocoEnBoton() {
	document.all['btnActualizar'].focus();
}
