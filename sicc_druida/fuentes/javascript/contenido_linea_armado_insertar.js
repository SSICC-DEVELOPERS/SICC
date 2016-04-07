function onLoadPag() {

    configurarMenuSecundario("formulario");
    
	if (get('formulario.errCodigo') != "") {
		fMostrarMensajeError();
		window.close();
	}

	accion("formulario.txtLineaArmado", '.disabled=true');

	/*inicio habilita deshabilita campos*/
	accion('formulario.cbCentroDistribucion',  '.disabled=' + get("formulario.hDeshabilitar"));
	accion('formulario.cbProgramaCubicaje',  '.disabled=' + get("formulario.hDeshabilitar"));
	//accion('formulario.cbTiposSolicitudConsolidado',  '.disabled=' + get("formulario.hDeshabilitar"));
	accion('formulario.txtDescripcion',  '.disabled=' + get("formulario.hDeshabilitar"));
	accion('formulario.txtLongitudNroEtiqueta', '.disabled=' + get("formulario.hDeshabilitar"));
	//accion('formulario.txtFormatoEtiquetasAFP', '.disabled=' + get("formulario.hDeshabilitar"));//ciglesias incidencia 364
	accion('formulario.txtNumeroEtiquetasAFP', '.disabled=' + get("formulario.hDeshabilitar"));
	//accion('formulario.chkImprimirListaPicaoNivelLinea', '.disabled=' + get("formulario.hDeshabilitar")); //ciglesias incidencia 356
	accion('formulario.chkLineaAFP', '.disabled=' + get("formulario.hDeshabilitar"));
	accion('formulario.chkLineaDefault', '.disabled=' + get("formulario.hDeshabilitar"));
	/*fin habilita deshabilita campos*/
    

	if (get("formulario.casoUso") == "insertar"){//insercion
		fLimpiar();
		set("formulario.txtLineaArmado",get("formulario.htxtLineaArmado"));
		set("formulario.cbCentroDistribucion", [get("formulario.hValorDefecto")]);
		if (get("formulario.hValorDefecto") != "") {
			focaliza("formulario.txtDescripcion");
		} else {
			focaliza("formulario.cbCentroDistribucion");
		}
		onClickChkLineaAFP();

	} else {
			set("formulario.txtLineaArmado", get("formulario.htxtLineaArmado"));
			set("formulario.txtDescripcion", get("formulario.hDescripcion"));
			set("formulario.txtLongitudNroEtiqueta", get("formulario.hLongitud"));
			//set("formulario.txtFormatoEtiquetasAFP", get("formulario.hEtiquetas"));//ciglesias incidencia 364
			set("formulario.txtNumeroEtiquetasAFP", get("formulario.hNumEtiquetas"));

			set("formulario.cbCentroDistribucion", [get("formulario.hOidDescripcionCD")]);
			set("formulario.cbProgramaCubicaje", [get("formulario.hPrograma")]);

			set("formulario.cbTiposSolicitudConsolidado", functemp(get("formulario.hlstTipoSolicitudConsolidado")));

			var si = GestionarMensaje("1010", null, null, null);
			var no = GestionarMensaje("1011", null, null, null);


			if (get("formulario.hLineaAFP") == si) {
				set("formulario.chkLineaAFP", "S");
			} else {
				set("formulario.chkLineaAFP", "N");
			}

			/* ciglesias incidencias 356
			if (get("formulario.hImprimir") == si) {
				set("formulario.chkImprimirListaPicaoNivelLinea", "S");
			} else {
				set("formulario.chkImprimirListaPicaoNivelLinea", "N");
			}*/

			if (get("formulario.hDefecto") == si) {
				set("formulario.chkLineaDefault", "S");
			} else {
				set("formulario.chkLineaDefault", "N");
			}

			cargarLista(get("formulario.hlstUsuariosAlarmaProd"));

		if (get("formulario.casoUso")  == "detalle"){ //consulta
			document.all["btnAnyadirDiv"].style.visibility = "hidden";
			document.all["btnEliminarDiv"].style.visibility = "hidden";

			/*****************************************/
			var codigos = listado1.codigos();
			eval("listado1.preparaCamposDR()");

			for(var i=0; i<codigos.length; i++){
				//if(listado1.extraeDato(codigos[i], 4)!="BLANCO") {
				  accion('frmlistado1'+'.'+'txtMail'+'_'+i, '.disabled=true');
				//}
			}
			/*****************************************/


		} else if (get("formulario.casoUso")  == "modificarDetalle"){ //modificacion
            
            // Deshabilita Combo CD
            accion("formulario.cbCentroDistribucion", '.disabled=true');
            
		}
	}


	eval(ON_RSZ);
}

function functemp(cadena) {
	var salida = cadena.split("|||");
	return salida;
}


function onClickChkLineaAFP() {
	if (get("formulario.chkLineaAFP") == "S") {
		//accion("formulario.txtFormatoEtiquetasAFP", '.disabled=false');//ciglesias incidencia 364
		accion("formulario.txtNumeroEtiquetasAFP", '.disabled=false');
	} else {
		//accion("formulario.txtFormatoEtiquetasAFP", '.disabled=true');//ciglesias incidencia 364
		accion("formulario.txtNumeroEtiquetasAFP", '.disabled=true');
		//set("formulario.txtFormatoEtiquetasAFP","");//ciglesias incidencia 364
		set("formulario.txtNumeroEtiquetasAFP","");
	}
}


function onClickAnyadirUsuarioAlarma() {
	var nuevaFila = new Array();

	nuevaFila[0] = "g";
	nuevaFila[1] = "";
	listado1.insertar(nuevaFila);
	listado1.repintaDat();
	eval("listado1.preparaCamposDR();");
	focaliza('frmlistado1.txtMail_' + (listado1.datos.length -1));
}

function onClickEliminarUsuarioAlarma() {
	var listToDel = devuelveCodigosEliminados();
	if(!listado1.numSelecc() == 0){	

		for (var i = 0; i < listToDel.length ; i++) {
			var elemToDel = listToDel[i];
			if (elemToDel != "g"){
				var buffer = get("formulario.hEliminados");
				if (buffer != 0) {
					buffer = buffer + "," + elemToDel;
				} else {
					buffer = elemToDel;
				}
				set("formulario.hEliminados", buffer);
			}
		}


		listado1.eliminarSelecc();
	}else{
		GestionarMensaje("50");
	}	 
}

function fGuardar() {
	if(!sicc_validaciones_generales("validacion1")){
		return false;
	}

	if (get("formulario.chkLineaAFP") == "S") {
		if(!sicc_validaciones_generales("validacion2")){
			return false;
		}
	}
	
    quitarFilasVacias(listado1);
	
	var hListaUsuarios = listaToXml('listado1');
	//alert(hListaUsuarios);
	set("formulario.hListaUsuarios", hListaUsuarios);

	set('formulario.conectorAction','LPMantenimientoLineaArmado');
	set('formulario.accion','guardar');
	eval('formulario').oculto = "S";
	enviaSICC('formulario');
}

function fLimpiar() {
		set('formulario.cbCentroDistribucion', '');
		set('formulario.cbProgramaCubicaje', '');
		set('formulario.cbTiposSolicitudConsolidado', '');

		set('formulario.txtDescripcion', '');
		set('formulario.txtLongitudNroEtiqueta', '');
		//set('formulario.txtFormatoEtiquetasAFP', '');//ciglesias incidencia 364
		set('formulario.txtNumeroEtiquetasAFP', '');

		//set('formulario.chkImprimirListaPicaoNivelLinea', ''); //ciglesias incidencia 356
		set('formulario.chkLineaAFP', '');
		set('formulario.chkLineaDefault', '');

		listado1.datos = new Array();
		listado1.repinta();

		limpiaI18N("formulario", "1");
}

function lVolver() {
	close();
}

function onTab(campo) {
	if (campo == "cbCentroDistribucion") {
		focaliza('formulario.txtDescripcion');

	} else if (campo == "txtDescripcion") {
		/*ciglesias incidencia 356
		focaliza('formulario.chkImprimirListaPicaoNivelLinea');

	} else if (campo == "chkImprimirListaPicaoNivelLinea") {
		*/focaliza('formulario.cbProgramaCubicaje');

	} else if (campo == "cbProgramaCubicaje") {
		focaliza('formulario.txtLongitudNroEtiqueta');

	} else if (campo == "txtLongitudNroEtiqueta") {
		focaliza('formulario.cbTiposSolicitudConsolidado');

	} else if (campo == "cbTiposSolicitudConsolidado") {
		focaliza('formulario.chkLineaAFP');

	} else if (campo == "chkLineaAFP") {
		if (get("formulario.chkLineaAFP") == "S") {
			focaliza('formulario.txtNumeroEtiquetasAFP');
			//focaliza('formulario.txtFormatoEtiquetasAFP');//ciglesias incidencia 364
		} else {
			focaliza('formulario.chkLineaDefault');
		}

	/* ciglesias incidencia 364
	} else if (campo == "txtFormatoEtiquetasAFP") {
		focaliza('formulario.txtNumeroEtiquetasAFP');
	*/

	} else if (campo == "txtNumeroEtiquetasAFP") {
		focaliza('formulario.chkLineaDefault');

	} else if (campo == "chkLineaDefault") {
		focalizaBotonHTML('botonContenido','btnAnyadir')

	} else if (campo == "btnAnyadir") {
		focalizaBotonHTML('botonContenido','btnEliminar')

	} else if (campo == "btnEliminar") {
		focaliza('formulario.cbCentroDistribucion');

	}
}

function onShTab(campo) {
	if (campo == "cbCentroDistribucion") {
		focalizaBotonHTML('botonContenido','btnEliminar')

	} else if (campo == "txtDescripcion") {
		focaliza('formulario.cbCentroDistribucion');
/* ciglesias 356
	} else if (campo == "chkImprimirListaPicaoNivelLinea") {
		focaliza('formulario.txtDescripcion');
*/
	} else if (campo == "cbProgramaCubicaje") {
		focaliza('formulario.txtDescripcion');

	} else if (campo == "txtLongitudNroEtiqueta") {
		focaliza('formulario.cbProgramaCubicaje');

	} else if (campo == "cbTiposSolicitudConsolidado") {
		focaliza('formulario.txtLongitudNroEtiqueta');

	} else if (campo == "chkLineaAFP") {
		focaliza('formulario.cbTiposSolicitudConsolidado');

	/*ciglesias incidencia 364
	} else if (campo == "txtFormatoEtiquetasAFP") {
		focaliza('formulario.chkLineaAFP');
	*/

	} else if (campo == "txtNumeroEtiquetasAFP") {
		focaliza('formulario.chkLineaAFP');
		//focaliza('formulario.txtFormatoEtiquetasAFP');//ciglesias incidencia 364

	} else if (campo == "chkLineaDefault") {
		if (get("formulario.chkLineaAFP") == "S") {
			focaliza('formulario.txtNumeroEtiquetasAFP');
		} else {
			focaliza('formulario.chkLineaAFP');
		}

	} else if (campo == "btnAnyadir") {
		focaliza('formulario.chkLineaDefault');

	} else if (campo == "btnEliminar") {
		focalizaBotonHTML('botonContenido','btnAnyadir')

	}
}


function devuelveCodigosEliminados() {
	var codigos = eval("listado1.codSeleccionados()");
	var elemAEliminar = new Array();
	var j = 0;

	for (var i = 0; i < codigos.length; i++) {
		if ( codigos[i] != "") {
			elemAEliminar[j] = codigos[i];
			j++;
		}
	}
	return elemAEliminar;
}

function listaToXml(listado) {
	var xmlDoc = "<?xml version='1.0' encoding='ISO-8859-1' standalone='yes'?>";
	xmlDoc = xmlDoc + "<DOC>";
	var datos = eval(listado + ".datos;");
	var cantFilas = datos.length;
	/* Recorre las filas */ 
	for (var i = 0; i < cantFilas; i++) {
		var linea = datos[i]; 
		xmlDoc = xmlDoc + "<ROW>";
		/* Recorre los campos dentro de la fila */
		var cantCampos = linea.length;
		for (var j = 0; j < cantCampos; j++ ) {
			/* Quito formato local de numero */ 
			var campo = linea[j];
			xmlDoc = xmlDoc + "<CAMPO>" + DrdEscXML(campo) + "</CAMPO>";
		}
		xmlDoc = xmlDoc + "</ROW>"
	}
	xmlDoc = xmlDoc + "</DOC>";
	return xmlDoc; 
}


function txtMailOnChange(objetoCampo) {
	var indTemp = objetoCampo.name.split("_");
	var indexTemp = Math.abs(indTemp[1]);
	listado1.datos[indexTemp][1]=objetoCampo.value;
	listado1.repintaDat();
}

function bienGuardado(codLineaArmado) {
	set('formulario.', '');
	fLimpiar();
	set("formulario.txtLineaArmado", codLineaArmado);
	set("formulario.cbCentroDistribucion", [get("formulario.hValorDefecto")]);
	return true;
}

function malGuardado() {
	return false;
}

function cargarLista(cadena) {
	if (cadena != null) {
		var lista = cadena.split("|||");
		for(var i = 0; i < lista.length; i++) {
			var valores = lista[i].split("|,|");

			var nuevaFila = new Array();
			nuevaFila[0] = valores[0];
			nuevaFila[1] = valores[1];
			listado1.insertar(nuevaFila);
		}
	}
}


function onChangeTSL() {
	if (get("formulario.casoUso") == "detalle"){
		set("formulario.cbTiposSolicitudConsolidado", functemp(get("formulario.hlstTipoSolicitudConsolidado")));
	}
}

function onClickTSL() {
	if (get("formulario.casoUso") == "detalle"){
		set("formulario.cbTiposSolicitudConsolidado", functemp(get("formulario.hlstTipoSolicitudConsolidado")));
	}
}

function onFocusTSL() {
	if (get("formulario.casoUso") == "detalle"){
		set("formulario.cbTiposSolicitudConsolidado", functemp(get("formulario.hlstTipoSolicitudConsolidado")));
	}
}

function quitarFilasVacias(listado1) {
    var datosCompletos = new Array();
    var datosOriginal = listado1.datos;

    var cantFilasOriginal = datosOriginal.length;
	var direccionEmail = null;
    
    for (var i = 0; i < cantFilasOriginal; i++) {
        direccionEmail = datosOriginal[i][1];
        direccionEmail = direccionEmail.replace(/^\s*/, "").replace(/\s*$/, ""); // Trim blanks (iniciales y finales)
		
        if (direccionEmail != "") { // Si no esta vacio el campo del e-mail
            datosCompletos[datosCompletos.length] = datosOriginal[i];
        } else { // El e-mail esta vacio
            // No lo agregamos a datosCompletos, pero ademas registramos la baja si es 'Modificar'
            if (datosOriginal[i][0] != "g") { // Esta vacio pero proviene de la BBDD
                var buffer = get("formulario.hEliminados");
				buffer = buffer + "," + datosOriginal[i][0];
				set("formulario.hEliminados", buffer);
            }
        }
    }
    listado1.setDatos(datosCompletos);
}

function fVolver() {
	window.close();
}
