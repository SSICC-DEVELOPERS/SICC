var salidaEliminada = false;

function onLoadPag() {
    configurarMenuSecundario("formulario");
    fMostrarMensajeError();

    focaliza("formulario.cbCentroDistribucion");  
	visualizarLista('hidden', null);
	eval(ON_RSZ);
}

function onClickBuscar() {
	if(!sicc_validaciones_generales("validacion1")){
		return false;
	}
	

	configurarPaginado(	mipgndo, 
						"APEBuscarLineasArmado", 
						"ConectorBuscarLineasArmado",
						"es.indra.sicc.dtos.ape.DTOBuscarLineasArmado",
						[["oidPais", get("formulario.hPais")],
					 	 ["oidIdioma", get("formulario.hIdioma")],
						 ["codigoLinea", get("formulario.txtLineaArmado")],
						 ["descripcion", get("formulario.cbDescripcion","T")],
						 ["descripcionCD", get("formulario.cbCentroDistribucion","T")]]);

}


function onClickDetalle() {
	llamarLP("detalle");
}

function fBorrar(){
	var seleccionados = listado1.codSeleccionados();
	var cantSeleccionados = seleccionados.length;

	if (cantSeleccionados > 0) {
		//eliminarFilas(seleccionados, "APEEliminarLineasArmado", mipgndo, 'onChangeCbCentroDistribucion()');
		eliminarFilas(seleccionados, "APEEliminarLineasArmado", mipgndo,'resultadoOperacion(datos);onChangeCbCentroDistribucion();');
		salidaEliminada = true;
	} else {
		GestionarMensaje("4", null, null, null);
	}
	
}

function onClickModificar() {
    var descSelect = get('formulario.cbDescripcion','V');
	if(llamarLP("modificarDetalle") == true);
    onChangeCbCentroDistribucion(descSelect);
}

function llamarLP(accion) {
	var seleccionados = listado1.codSeleccionados();
	var cantSeleccionados = seleccionados.length;

	if (cantSeleccionados == 1) {
		var objParams = new Object();
		for (var i = 0; i < listado1.datos.length ; i++) {
			if (listado1.datos[i][0] == seleccionados[0]) {
				objParams.oid = listado1.datos[i][0];
				objParams.descripcionCD = listado1.datos[i][8];
				objParams.codigo = listado1.datos[i][2];
				objParams.descripcion = listado1.datos[i][3];
				objParams.lineaAFP = listado1.datos[i][4];
				objParams.defecto = listado1.datos[i][5];
				objParams.programa = listado1.datos[i][9];
				objParams.longitud = listado1.datos[i][6];
				objParams.numEtiquetas = listado1.datos[i][7];
			}
		}

		if(mostrarModalSICC("LPMantenimientoLineaArmado", accion, objParams, null, null) == true) {
			return true;
		} else {
			return false;
		}

	} else 	if (cantSeleccionados == 0) {
		GestionarMensaje("4", null, null, null);
		return false;
	} else {
		cdos_mostrarAlert(GestionarMensaje("240", null, null, null));
	}
}

function fLimpiar() {
	//set("formulario.cbDescripcion","");
	set("formulario.txtLineaArmado","");
	set("formulario.cbCentroDistribucion","");
    set_combo('formulario.cbDescripcion', new Array(['','']));
	listado1.datos = new Array();
	visualizarLista("hidden", null);
}

function onTab(campo) {
	if (campo == "cbCentroDistribucion") {
		focaliza('formulario.txtLineaArmado');

	} else if (campo == "txtLineaArmado") {
		focaliza('formulario.cbDescripcion');

	} else if (campo == "cbDescripcion") {
		 focalizaBotonHTML('botonContenido','btnBuscar')

	} else if (campo == "btnBuscar") {
		if (listado1.datos.length != 0) {

			if (document.formulario.opcionMenu == "modificar") {
				focalizaBotonHTML_XY("btnModificar");
			} else {
				focalizaBotonHTML_XY("btnDetalle");
			}

		} else {
			focaliza('formulario.cbCentroDistribucion');
		}

	} else if (campo == "btnDetalle") {
		focaliza('formulario.cbCentroDistribucion');

	} else if (campo == "btnModificar") {
		focaliza('formulario.cbCentroDistribucion');

	}
}

function onShTab(campo) {
	if (campo == "cbCentroDistribucion") {
		if (listado1.datos.length != 0) {

			if (document.formulario.opcionMenu == "modificar") {
				focalizaBotonHTML_XY("btnModificar");
			} else {
				focalizaBotonHTML_XY("btnDetalle");
			}

		} else {
		 focalizaBotonHTML('botonContenido','btnBuscar')
		}

	} else if (campo == "txtLineaArmado") {
		focaliza('formulario.cbCentroDistribucion');

	} else if (campo == "cbDescripcion") {
		focaliza('formulario.txtLineaArmado');

	} else if (campo == "btnBuscar") {
		focaliza('formulario.cbDescripcion');

	} else if (campo == "btnDetalle") {
		//focaliza('formulario.btnBuscar');
		 focalizaBotonHTML('botonContenido','btnBuscar')

	} else if (campo == "btnModificar") {
		//focaliza('formulario.btnBuscar');
		 focalizaBotonHTML('botonContenido','btnBuscar')

	}

}

function muestraLista(ultima, rowset) {
	var tamano = rowset.length;

	/*if (salidaEliminada == true) {
		salidaEliminada = false;

		recargaCombo(	'formulario.cbDescripcion', 
						'APEObtenerDescripcionesLineas', 
						'es.indra.sicc.util.DTOBelcorp', 
						[['oidIdioma', get('formulario.hIdioma')], 
						 ['oidPais', get('formulario.hPais')]]);
		set("formulario.cbDescripcion","");
		set("formulario.txtLineaArmado","");
		set("formulario.cbCentroDistribucion","");
		listado1.datos = new Array();
		mipgndo.clear();
		visualizarLista("hidden", null);

	} else {

		if (tamano > 0) {
			visualizarLista("", get("formulario.casoUso"));
			i18n();
			return true;
		} else {
			visualizarLista("hidden", null);
			focaliza("formulario.cbCentroDistribucion");  
			cdos_mostrarAlert("No existen registros que cumplan con los criterios de búsqueda");
			return false;
		}
	}*/
    
	if (tamano > 0) {
		visualizarLista("", get("formulario.casoUso"));
    // vbongiov -- LG_V400000011 -- 17/09/2007
    if(get("formulario.casoUso") == "eliminar"){
        btnProxy(4,'1');
    }
		i18n(rowset);
		return true;
	} else {
		visualizarLista("hidden", null);
		btnProxy(4,'0');
		focaliza("formulario.cbCentroDistribucion");  
		cdos_mostrarAlert("No existen registros que cumplan con los criterios de búsqueda");
		return false;
	}
    
}

function i18n(lista) {
         listado1.actualizaDat();

         var datos = lista;
         var cantRegistros = datos.length;

         var si = GestionarMensaje("1010", null, null, null);
         var no = GestionarMensaje("1011", null, null, null);

		 for ( var i = 0; i < cantRegistros; i++ ) {
			 for (var j = 4 ; j < 6 ; j++) {
                  var campo = datos[i][j];
                  var campoValor = parseInt(campo, 10);
                  if (campoValor == 1) {
                           campo = si;
                  } else if (campoValor == 0) {
                           campo = no;
                  }
                  datos[i][j] = campo;
			 }
         }

         listado1.setDatos(datos);
		 listado1.repinta();
}

	
function visualizarLista(visibilidad, casoUsoSeleccionado) {
	DrdEnsanchaConMargenDcho("listado1", 15);

    document.all["Cplistado1"].style.visibility = visibilidad;
    document.all["CpLin1listado1"].style.visibility = visibilidad;
    document.all["CpLin2listado1"].style.visibility = visibilidad;
    document.all["CpLin3listado1"].style.visibility = visibilidad;
    document.all["CpLin4listado1"].style.visibility = visibilidad;

    document.all["primera1Div"].style.visibility = visibilidad;
    document.all["ret1Div"].style.visibility = visibilidad;
    document.all["ava1Div"].style.visibility = visibilidad;
    document.all["separaDiv"].style.visibility = visibilidad;

	if (visibilidad == "hidden") {
		document.all["btnModificarDiv"].style.visibility = visibilidad;
		document.all["btnDetalleDiv"].style.visibility = visibilidad;
	} else {
		if (casoUsoSeleccionado == "consultar") {
			document.all["btnModificarDiv"].style.visibility = "hidden";
			document.all["btnDetalleDiv"].style.visibility = visibilidad;
		} else if (casoUsoSeleccionado == "modificar") {
			document.all["btnModificarDiv"].style.visibility = visibilidad;
			document.all["btnDetalleDiv"].style.visibility = "hidden";
		}
	}
}


function eliminarDeLista(){
	var codigosSelec = listado1.codSeleccionados();
	var allCodes = listado1.codigos();
	var listSize = listado1.codigos().length;

	if (codigosSelec != ""){
		for (var i = 0; i < codigosSelec.length; i++){
			for (var j = 0; j < listSize; j++){
				if (allCodes[j] == codigosSelec[i])
					listado1.deselecciona(j);
			}
		}
	}
}

//--------------------------------------------------------------------------------------------------------

function onChangeCbCentroDistribucion(varIni) {
    if(arguments.length==0){
        var varIni = '';
    }
	var oidCentro = get('formulario.cbCentroDistribucion', 'V');
	if (oidCentro != '') {
		var array = new Array();
		array[0] = new Array('oid',oidCentro);
		array[1] = new Array('oidIdioma',get('formulario.hIdioma'));
		set_combo('formulario.cbDescripcion', new Array(['','']));
		recargaCombo('formulario.cbDescripcion',
 					'APEObtenerLineasArmadoCD',
 					'es.indra.sicc.util.DTOOID',
 					array,
 					'setearCbLineaArmado(datos,"'+varIni+'")');
		/* VER COMO SOLUCIONO EL TEMA DE LA LINEA DE ARMADO POR DEFECTO */
	} else {
		set_combo('formulario.cbDescripcion', new Array(['','']));
	}
}

//--------------------------------------------------------------------------------------------------------

function setearCbLineaArmado(datos, descSelect) {
	var arrayNuevo = new Array();
	arrayNuevo[0] = new Array('','');
	arrayNuevo = arrayNuevo.concat(datos);
	set_combo('formulario.cbDescripcion',arrayNuevo);
    if(descSelect.length>0){
        set('formulario.cbDescripcion',[descSelect]);
        onClickBuscar();
    }
}


