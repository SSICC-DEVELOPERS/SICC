var FORMULARIO = 'frmFormulario';
var nombresCampos = ['txtNIdentificacion|TEXT','txtCodCliente|TEXT','txtFechaDocumento|TEXT'];

function onLoadPag() {
	var errDescripcion = get(FORMULARIO +'.errDescripcion');
	if (errDescripcion !='') {
		var errCodigo = get(FORMULARIO+'.errCodigo');
		var wnd = fMostrarMensajeError(errCodigo, errDescripcion);
	}

	focaliza(FORMULARIO+'.txtNIdentificacion');
	configurarMenuSecundario(FORMULARIO);
}


// Función que se ejecuta cuando el usuario pulsa la imagen de la lupa
function accionSeleccionarCliente() {
	// Se muestra un cuadro de dialogo modal para que el usuario seleccione el
	// cliente
	var objParams = new Object();
	var cliente = mostrarModalSICC('LPBusquedaRapidaCliente', '', objParams, null, null);

        if (cliente != null && cliente.length > 1) {
                  set(FORMULARIO+'.txtCodCliente', cliente[1].toString());
         }

}


// Función que se ejecuta cuando el usuario pulsa el botón Buscar
function accionBuscar() {
	if (ValidaForm(FORMULARIO,true)) {
		var nume = 0;
		
		var codigoCliente = get(FORMULARIO+'.txtCodCliente');
		if((codigoCliente != null)&&(codigoCliente != "")){
			nume++;	
		}
    	var numeroIdentificacion = get(FORMULARIO+'.txtNIdentificacion');
    	if((numeroIdentificacion != null)&&(numeroIdentificacion != "")){
			nume++;	
		}
    	var ejercicio = get(FORMULARIO +'.txtEjercicio');
    	if((ejercicio != null)&&(ejercicio != "")){
			nume++;	
		}
    	var mes = get(FORMULARIO +'.txtMes');
    	if((mes != null)&&(mes != "")){
			nume++;	
		}
    	var proceso = get(FORMULARIO +'.cbProceso');
    	if((proceso != null)&&(proceso != "")){
			nume++;	
		}
    	
    	var fechaDocumento = get(FORMULARIO+'.txtFechaDocumento');
    	var fecha = '';
    	if (fechaDocumento != '') {
    		fecha = obtenerFormatoFecha(fechaDocumento);
    		nume++;
    	}	
    	var idioma = get(FORMULARIO +'.idioma');
    	var pais = get(FORMULARIO +'.pais');
  		if(nume < 2){
  			//Muestra el mensaje:"Debe introducir al menos dos criterios de filtro" (UICCC005)
  			GestionarMensaje('1405');
  		}else{
    		var DTOBuscarCargosAbonos = 'es.indra.sicc.dtos.ccc.DTOBuscarCargosAbonos';
    		
			configurarPaginado(mipgndo, 'CCCBuscarCargosAbonos', 'ConectorBuscarCargosAbonos', 
				DTOBuscarCargosAbonos, [['numeroIdentificacion', numeroIdentificacion],['codigoCliente', codigoCliente] , 
				['fechaDocumento', fecha],['proceso',proceso],['mes',mes],['ejercicio',ejercicio], ['oidIdioma',idioma], ['oidPais',pais] ] );
	    	
			// Se muestra la lista editable con los resultados de la búsqueda
			//visibleLista();
		}
	} 
}


// Función que se ejecuta cuando el usuario pulsa el botón Modificar
function accionModificar() {
	if (listado1.numSelecc() == 0) {
		// Muestra el mensaje: "Debe seleccionar un elemento de la lista"
		GestionarMensaje('50');
	} else {
		if (listado1.numSelecc() != 1 ) {
			//Muesta el mensaje: "Debe seleccionar un solo registro"
			GestionarMensaje('8');
			deseleccionaListado();
		} else {
			// Abrimos una ventana emergente y direccionamos a la LPAplicarCargosAbonos 
			// con la accion "modificar", pasandole el oid de la fila que ha selecionado 
			// el usuario.
			var objParams = new Object();
			objParams.oid = listado1.codSeleccionados();
			mostrarModalSICC('LPAplicarCargosAbonos', 'modificar', objParams, null, null);
		}
	}
}


// Función que se ejecuta cuando el usuario pulsa el botón Consultar
function accionConsultar() {
	if (listado1.numSelecc() == 0) {
		// Muestra el mensaje: "Debe seleccionar un elemento de la lista"
		GestionarMensaje('50');
	} else {
		if (listado1.numSelecc() != 1 ) {
			//Muesta el mensaje: "Debe seleccionar un solo registro"
			GestionarMensaje('8');
			deseleccionaListado();
		} else {
			// Abrimos una ventana emergente y direccionamos a la LPAplicarCargosAbonos 
			// con la accion "consultar", pasandole el oid de la fila que ha selecionado 
			// el usuario.
			var objParams = new Object();
			objParams.oid = listado1.codSeleccionados();
			objParams.casoUso = get(FORMULARIO +'.casoUso');
			mostrarModalSICC('LPAplicarCargosAbonos', 'consultar', objParams, null, null);
		}
	}
}

	function deseleccionaListado() {
		for (i = 0; i < listado1.datos.length; i++)
			listado1.deselecciona(i); 
	}


// Función que se ejecuta cuando el usuario pulsa el botón Eliminar
function accionEliminar() {
	// Obtenemos los valores de los campos oid de las filas seleccionadas 
	// por el usuario 
	// Llamamos a eliminarFilas pasandole el idBusiness="CCCEliminarCargosAbonos",  
	// los oids que hemos obtenido y el objeto paginado
	if (listado1.numSelecc() == 0) {
		// Muestra el mensaje: "Debe seleccionar un elemento de la lista"
		GestionarMensaje('50');
	} else {
		var oids = listado1.codSeleccionados();
		eliminarFilas(oids, "CCCEliminarCargosAbonos", mipgndo);
	}	
}


// Función que se ejecuta cuando pierde el foco el campo Codigo de cliente
function codigoClienteOnBlur() {
	var codigoCliente = get(FORMULARIO+'.txtCodCliente');
	
	if (codigoCliente != '') {
		var longitudCodigoCliente = get(FORMULARIO+'.longitudCodigoCliente');
		var longitud = codigoCliente.length;
		
		// Se rellena el código de cliente con ceros
		var codigoClienteCeros = rellenaCeros(codigoCliente,longitudCodigoCliente,
			longitud);
			
		set(FORMULARIO+'.txtCodCliente',codigoClienteCeros); 
		
	}	
}

function fBorrar() {
	accionEliminar();
}

function visibleLista() {
	visibilidad('capaLista','V');
         
	DrdEnsanchaConMargenDcho('listado1',12);
         
	//Dependiendo del caso de uso mostramos los botones
	var casoUso = get(FORMULARIO+'.casoUso');
	
	if (casoUso == 'consultar' || casoUso == 'eliminar') {
		document.all["ModificarDiv"].style.visibility='hidden';
		document.all["DetalleDiv"].style.visibility='visible';
	} else if (casoUso == 'modificar') {
		document.all["ModificarDiv"].style.visibility='visible';
		document.all["DetalleDiv"].style.visibility='hidden';
	}
	eval (ON_RSZ);  
}

function ocultaLista() {
	visibilidad('capaLista','O');
		document.all["ModificarDiv"].style.visibility='hidden';
		document.all["DetalleDiv"].style.visibility='hidden';
         
}

function validaFecha(nombreElemento) {
	var fecha = get(FORMULARIO+'.'+nombreElemento);

	if (fecha != '') {
		var resul = EsFechaValida(fecha,fecha, FORMULARIO,null)
		if(resul==1 || resul==2){  
			// Muestra el mensaje: La fecha es incorrecta
			GestionarMensaje('947',FORMULARIO+'.'+nombreElemento);
			focaliza(FORMULARIO+'.'+nombreElemento);
		}
	}
}

function fLimpiar() {
	for (var i=0; i<nombresCampos.length;i++){
		var campo = FORMULARIO+'.'+nombresCampos[i].split('|')[0];
		
		switch(nombresCampos[i].split('|')[1]){
			case "COMBO":		
					set(campo,0);	
					break;			
			case "TEXT":
				set(campo,"");
				break;
		}
	}
	focaliza(FORMULARIO+'.txtNIdentificacion');	
}

function muestraLista(ultima, rowset) {
          var tamano = rowset.length;
          if (tamano > 0) {
                    visibleLista();
                    var casoUso = get(FORMULARIO +'.casoUso');
	    			if(casoUso == 'eliminar'){
	    				btnProxy(4,1);	
	   				}
                    return true;
          } else {
                    ocultaLista();
                    focaliza(FORMULARIO+'.txtNIdentificacion','');
                    return false;
          }
}

function onBlurMes(){
	var mes = get(FORMULARIO +'.txtMes');
	if(mes != ""){
		if((mes < 1) || (mes > 12)){
			GestionarMensaje('1368');
			focaliza(FORMULARIO +'.txtMes');
		}
		if (isNaN(mes)){
			GestionarMensaje('1256');
			focaliza(FORMULARIO +'.txtMes');
        }                                             
    }
}

function onshBoton(){
	if(get_visibilidad("capaLista")){
		var casoUso = get(FORMULARIO +'.casoUso');
		if((casoUso == 'eliminar')||(casoUso == 'consultar')){
			document.all['Detalle'].focus();
		}else{
			document.all['Modificar'].focus();
		}
	}else{
		document.all['btnBuscar'].focus();
	}
}

function focoBuscar(){
	if(get_visibilidad("capaLista")){
		var casoUso = get(FORMULARIO +'.casoUso');
		if((casoUso == 'eliminar')||(casoUso == 'consultar')){
			document.all['Detalle'].focus();
		}else{
			document.all['Modificar'].focus();
		}
	}else{
		focaliza(FORMULARIO +'.txtNIdentificacion');
	}	
}

function ontabDetalle(){
	focaliza(FORMULARIO +'.txtNIdentificacion');	
}

function onshtabDetalle(){
	document.all['btnBuscar'].focus();	
}

	function onBlurNIdentificacion(){
		/*if (isNaN(get(FORMULARIO +'.txtNIdentificacion'))){
			GestionarMensaje('1256');
			focaliza(FORMULARIO +'.txtNIdentificacion');
        } */
        
        if(get(FORMULARIO+'.txtNIdentificacion')!=''){
                  var esNumeroA=esNumero(get(FORMULARIO+'.txtNIdentificacion'));
                  if(esNumeroA=='-1'){		
                           GestionarMensaje('747', null, null, null);
                           focaliza(FORMULARIO+'.txtNIdentificacion');
                           return;			
                  }
         }	
                                            
	}

	function onBlurEjercicio(){
		if (isNaN(get(FORMULARIO +'.txtEjercicio'))){
			GestionarMensaje('1256');
			focaliza(FORMULARIO +'.txtEjercicio');
        }                                             
	}
