var FORMULARIO = 'frmContenido';
var numeroLinea = 1;

function onLoadPag(){
	
	focaliza(FORMULARIO+'.cbTipoMov');
	if (get(FORMULARIO+'.errDescripcion')!='') {                      
       	var wnd = fMostrarMensajeError(get(FORMULARIO+'.errCodigo'),get(FORMULARIO+'.errDescripcion'));
       	window.close();
    }
    DrdEnsanchaConMargenDcho('listado1',12);
	eval (ON_RSZ);  
	focaliza(FORMULARIO + '.cbTipoMov');
	configurarMenuSecundario(FORMULARIO);

	//Asignar valor por defecto al combo 'Motivo devolucion'.
	
	var vMotivoDev;
	var i;
	var len;

	len = combo_get('frmContenido.cbMotivoDev', 'L');

	//alert('ALERTA');

	for(i = 0; i < len; i++){
		if (combo_get('frmContenido.cbMotivoDev', 'T', i) != ''){
			vMotivoDev = combo_get('frmContenido.cbMotivoDev', 'V', i);
			set('frmContenido.cbMotivoDev', [vMotivoDev])
			break;
		}
	}

}

function btnAnyadir_onClick(){

	//Documentation
	// Pulsa sobre el botón Añadir 
	var oidTipoMov = get(FORMULARIO+'.cbTipoMov').toString();
	var tipoMovimiento = get(FORMULARIO+'.cbTipoMov','T').toString();
	var codigoVenta = get(FORMULARIO+'.txtCodVenta').toString();
	var unidadesReclamadas = get(FORMULARIO + '.txtNUniReclamadas').toString();
	var oidMotivoDev = get(FORMULARIO+'.cbMotivoDev').toString();
	var motivoDevolucion = get(FORMULARIO+'.cbMotivoDev','T').toString();
	var unidadesDevueltas = get(FORMULARIO+'.txtNUniDevueltas').toString();

	if(sicc_validaciones_generales()) {
		var oid = get(FORMULARIO + '.numeroOperacion');
		var fila = [oid, tipoMovimiento, codigoVenta, unidadesReclamadas, motivoDevolucion, unidadesDevueltas, oidTipoMov, oidMotivoDev];
		//Insertamos la fila
		listado1.insertar(fila);
		listado1.reajusta();
		numeroLinea++;
		set(FORMULARIO + '.numeroLinea', numeroLinea);
		txt_to('lblNumeroLineaX', numeroLinea);
		limpiarFormulario();	
	}
	focaliza(FORMULARIO + '.cbTipoMov');
	
}

function btnAceptar_onclick(){

	//Documentation
	// Pulsa sobre el botón btnAceptar 

	//Devolvemos el array lineasOperacion (utilizando la propiedad window.returnValue del popup)
	//Añade una nueva fila al array lineasOperacion con los datos de la línea: 
	//- {numero operacion, numero línea, oidTipoMovimiento, codigo venta, unidades reclamadas, oidMotivoDevolucion, unidades devueltas} 
	var datosFinal = new Array();
	for (i = 0; i < listado1.datos.length; i++) {
		var fila = listado1.datos[i];
		var filaFinal = new Array()
		filaFinal[0] = fila[0];	//numero de operacion
		filaFinal[1] = i;	//numero de linea
		filaFinal[2] = fila[6];	//oidTipoMovimiento
		filaFinal[3] = fila[2];	//codigo venta
		filaFinal[4] = obtieneNumeroDecimal(fila[3], get(FORMULARIO + '.hid_SeparadorDecimales'));	//unidades reclamadas
		filaFinal[5] = fila[7];	//oidMotivoDevolucion
		filaFinal[6] = fila[5];	//unidades devueltas
		if (filaFinal[5] == '') filaFinal[5] = '-';	//para que StringTokenicer no tenga que recuperar separador
		if (filaFinal[6] == '') filaFinal[6] = '-'; //para que StringTokenicer no tenga que recuperar separador
		datosFinal[datosFinal.length] = filaFinal;
	}
	window.returnValue = datosFinal;	
    window.close();
}

function fBorrar (){

	//Documentation
	// Pulsa sobre el botón eliminar del menú secundario 
	
	//Comprueba que se ha seleccionado alguna fila de la lista 
	if (listado1.numSelecc() == 0) {
		// Muestra el mensaje: "Debe seleccionar un elemento de la lista"
        GestionarMensaje('50');
    } else {                        
		//Elimina de la lista las lineas de operación seleccionadas 
    	listado1.eliminarSelecc();
   		if (listado1.datos.length == 0) btnProxy(4, 0);
		numeroLinea = listado1.datos.length + 1;
		set(FORMULARIO + '.numeroLinea', numeroLinea);
		txt_to('lblNumeroLineaX', numeroLinea);
	}
}

	function limpiarFormulario() {
		set(FORMULARIO + '.cbTipoMov', ['']);
		set(FORMULARIO + '.txtCodVenta', '');
		set(FORMULARIO + '.txtNUniReclamadas', '');
		set(FORMULARIO + '.cbMotivoDev', ['']);
		set(FORMULARIO + '.txtNUniDevueltas', '');
		btnProxy(4, 1);
	}

	function fLimpiar() {
		listado1.setDatos(new Array());
		btnProxy(4, 0);
		listado1.reajusta();
		numeroLinea = 1;
		set(FORMULARIO + '.numeroLinea', numeroLinea);
		txt_to('lblNumeroLineaX', numeroLinea);
		focaliza(FORMULARIO + '.cbTipoMov');
	}
	
	function validaUnidades(nombreElemento, enteros) {
		var valor = get(FORMULARIO + '.' + nombreElemento);
		if(valor != "") {
			var msg = ValidaCaracteres(valor,'0123456789' + get(FORMULARIO + '.hid_SeparadorMiles'));
			if (msg != "OK") {
				cdos_mostrarAlert(DrdMsgCore(143) + get(FORMULARIO + '.hid_SeparadorMiles') + '0123456789');
				focaliza(FORMULARIO + '.' + nombreElemento);
				return false;
			}

			msg = ValidaMilesDecimales(valor, enteros, 0, get(FORMULARIO + '.hid_SeparadorMiles'), get(FORMULARIO + '.hid_SeparadorDecimales'), 0);
			if (msg != "OK") {
				cdos_mostrarAlert(msg);
				focaliza(FORMULARIO + '.' + nombreElemento);
			}
		}
	}
	
	function fVolver() {
		window.close();
	}
	
	function mayusculas(nombreElemento) {
         var cadena = get(FORMULARIO + '.' + nombreElemento);
         if (cadena != "")
                  set(FORMULARIO + '.' + nombreElemento, cadena.toUpperCase());
	}
