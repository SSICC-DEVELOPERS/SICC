	var FORMULARIO = 'frmContenido';
	function onloadPag() {
		
		if (get(FORMULARIO + '.errDescripcion')!='') {
			var wnd = fMostrarMensajeError(get(FORMULARIO + '.errCodigo'), get(FORMULARIO + '.errDescripcion'));
			window.close();
		}
		configurarMenuSecundario(FORMULARIO);
		focaliza(FORMULARIO + '.txtNumUnidadesReclamadas');
	}

	function cargarLista() {
		//-> Devolvemos los valores rellenados por el usuario (utilizando la propiedad window.returnValue del popup) a la ventana PgProductoReclamos
		if (!sicc_validaciones_generales()) return false;
		var unidadesReclamadas = get(FORMULARIO + '.unidadesReclamadas');
		var unidadesRecibidas = get(FORMULARIO + '.unidadesRecibidas');
		var arrayFila = new Array();
		

		arrayFila[0] = formatearUnidades(get(FORMULARIO + '.txtNumUnidadesReclamadas')) + "";	//unidades a reclamar
		arrayFila[1] = formatearUnidades(get(FORMULARIO + '.txtNumUnidadesDevueltas')) + "";	//unidades devueltas
		
		//alert ("UnidadesReclamadas: "+unidadesReclamadas);
		//alert("UnidadesRecibidas: "+unidadesRecibidas);
		//alert("Unidades a reclamar: "+arrayFila[0]);
		//alert("Unidades devueltas: "+arrayFila[1]);
		//arrayFila[1] > arrayFila[0] || parseInt(unidadesRecibidas) > arrayFila[0]  
		

 //       if ((unidadesReclamadas != "" && parseInt(arrayFila[1]) <= parseInt(unidadesReclamadas)) || (unidadesRecibidas != "" && parseInt(arrayFila[0]) <= parseInt(unidadesRecibidas))){ 	
		//unidadesRecibidas = unidadesRecibidas.replace(',',get(FORMULARIO + '.hid_SeparadorMiles'));
		//var unidadesRecibidasSinSeparadMil = obtieneNumeroDecimal(unidadesRecibidas, get(FORMULARIO + '.hid_SeparadorMiles'));
//		Incidencia Peru mamontie
		var unidadesRecibidasSinSeparadMil =  obtieneNumeroDecimal(unidadesRecibidas, get(FORMULARIO + '.hid_SeparadorDecimales'));

		if (( parseInt(arrayFila[1]) > parseInt(arrayFila[0]) )
			|| (unidadesRecibidas != "" && parseInt(arrayFila[0]) > parseInt(unidadesRecibidas))){
			GestionarMensaje('REC0003');
			return false;
		}
		arrayFila[2] = get(FORMULARIO + '.cbMotivoDevolucion', 'T') + "";	//motivo de devolucion
		arrayFila[3] = get(FORMULARIO + '.cbMotivoDevolucion') + "";	//oid motivo de devolucion
		window.returnValue = arrayFila;
		window.close();
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

	function formatearUnidades(valor){
		var valorNumerico = obtieneNumeroDecimal(valor, get(FORMULARIO + '.hid_SeparadorDecimales'));
		return formateaImporte(valorNumerico.toString(), get(FORMULARIO + '.hid_SeparadorMiles'), get(FORMULARIO + '.hid_SeparadorDecimales'));	//precio total
	}