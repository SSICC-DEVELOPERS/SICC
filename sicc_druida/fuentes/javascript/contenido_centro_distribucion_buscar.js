
function onLoadPag() {
    configurarMenuSecundario("formulario");
	fMostrarMensajeError();
	
    focaliza("formulario.cbCentroDistribucion");  
	visualizarLista('hidden', null);
}

function onClickBuscar() {
	var arrayDTOConfCD = new Array();
	arrayDTOConfCD[0] = ["oidPais", get("formulario.hPais")];
	arrayDTOConfCD[1] = ["oidIdioma", get("formulario.hIdioma")];
	//arrayDTOConfCD[2] = ["oidCentroDistribucion", get("formulario.cbDescripcion")];
	arrayDTOConfCD[2] = ["descripcion", get("formulario.cbDescripcion","T")];
	arrayDTOConfCD[3] = ["codigoCentroDistribucion", get("formulario.cbCentroDistribucion","T")];

	configurarPaginado(	mipgndo, "APEBuscarCentroDistribucion", 
						"ConectorBuscarCentroDistribucion",
						"es.indra.sicc.dtos.ape.DTOConfiguracionCentroDistribucion",
						arrayDTOConfCD);
}

function onClickDetalle() {

	var seleccionados = listado1.codSeleccionados();
	var cantSeleccionados = seleccionados.length;

	if (cantSeleccionados == 1) {
		var objParams = new Object();
		for (var i = 0; i < listado1.datos.length ; i++) {
			if (listado1.datos[i][0] == seleccionados[0]) {
				objParams.oid = listado1.datos[i][0];
				objParams.codigo = listado1.datos[i][1];
				objParams.descripcion = listado1.datos[i][2];
				objParams.ckdef = listado1.datos[i][3];
				objParams.outsourcing = listado1.datos[i][4];
				objParams.ordenListaPicado = listado1.datos[i][6];
				objParams.ordenAscDesc = listado1.datos[i][8];
				objParams.textoChequeo = listado1.datos[i][10];
				objParams.textoPrimPedido = listado1.datos[i][11];
				objParams.agrupacionAFP = listado1.datos[i][12];
				//Agregado por cambio 20090839
				objParams.impresionDatosBc = listado1.datos[i][14];
				objParams.oidVisualChequeo = listado1.datos[i][15];
				objParams.CodigoVisualChequeo = listado1.datos[i][16];
				objParams.ordenVisualCheque = listado1.datos[i][17];
                break;
			}
		}

		mostrarModalSICC("LPMantenimientoCentroDistribucion", "detalle", objParams, null, null);	
		return true;

	} else 	if (cantSeleccionados == 0) {
		GestionarMensaje("4", null, null, null);
		return false;
	} else {
		cdos_mostrarAlert(GestionarMensaje("240", null, null, null));
        return false;
	}
}

function fBorrar(){
	var seleccionados = listado1.codSeleccionados();
	var cantSeleccionados = seleccionados.length;

	if (cantSeleccionados > 0) {
		if (listado1.datos.length == cantSeleccionados) {
			borroUltimos = true;
		} else {
			borroUltimos = false;
		}

		eliminarFilas(seleccionados, "APEEliminarCentroDistribucion", mipgndo, 'postEliminar(datos)');
		return true;

	} else {
		GestionarMensaje("4", null, null, null);
		return false;
	}
}

function onClickModificar() {
	var seleccionados = listado1.codSeleccionados();
	var cantSeleccionados = seleccionados.length;

	if (cantSeleccionados == 1) {
        var oidConfigCD = seleccionados[0];  // El oid del registro que modificaremos
        
		var objParams = new Object();
		for (var i = 0; i < listado1.datos.length ; i++) {
			if (listado1.datos[i][0] == seleccionados[0]) {
				objParams.oid = listado1.datos[i][0];
				objParams.codigo = listado1.datos[i][1];
				objParams.descripcion = listado1.datos[i][2];
				objParams.ckdef = listado1.datos[i][3];
				objParams.outsourcing = listado1.datos[i][4];
                objParams.ordenListaPicado = listado1.datos[i][6];
				objParams.ordenAscDesc = listado1.datos[i][8];
				objParams.textoChequeo = listado1.datos[i][10];
				objParams.textoPrimPedido = listado1.datos[i][11];
				objParams.agrupacionAFP = listado1.datos[i][12];
				//Agregado por cambio 20090839
				objParams.impresionDatosBc = listado1.datos[i][14];
				objParams.oidVisualChequeo = listado1.datos[i][15];
				objParams.CodigoVisualChequeo = listado1.datos[i][16];
				objParams.ordenVisualCheque = listado1.datos[i][17];

				objParams.opcionMenu = "modificar";
			}
		}
		
        var arrayDevuelto = mostrarModalSICC("LPMantenimientoCentroDistribucion", "detalle", objParams, null, null);
		
        if (arrayDevuelto != null) {
          /*  listado1.insertaDato(oidConfigCD, 1, arrayDevuelto[0]); // Descripcion
            listado1.insertaDato(oidConfigCD, 2, arrayDevuelto[1]); // CD x default
            listado1.insertaDato(oidConfigCD, 3, arrayDevuelto[2]); // Nivel outsourcing (oid)
            listado1.insertaDato(oidConfigCD, 4, arrayDevuelto[3]); // Nivel outsourcing (desc)
            listado1.insertaDato(oidConfigCD, 5, arrayDevuelto[4]); // Orden Lista Picad (oid)
            listado1.insertaDato(oidConfigCD, 6, arrayDevuelto[5]); // Orden Lista Picad (desc)
            listado1.insertaDato(oidConfigCD, 7, arrayDevuelto[6]); // Orden Prod (oid)
            listado1.insertaDato(oidConfigCD, 8, arrayDevuelto[7]); // Orden Prod (desc)
            listado1.insertaDato(oidConfigCD, 9, arrayDevuelto[8]); // Txt cheq
            listado1.insertaDato(oidConfigCD, 10, arrayDevuelto[9]); // Txt prim ped
            listado1.insertaDato(oidConfigCD, 11, arrayDevuelto[10]); // Agrup Afp (oid)
            listado1.insertaDato(oidConfigCD, 12, arrayDevuelto[11]); // Agrup Afp (desc)
			listado1.insertaDato(oidConfigCD, 14, arrayDevuelto[12]); // chkImpresionDatosBC 
			listado1.insertaDato(oidConfigCD, 15, arrayDevuelto[13]); // cbCodigoVisualChequeo (oid)
			listado1.insertaDato(oidConfigCD, 16, arrayDevuelto[14]); // cbCodigoVisualChequeo (desc)
			listado1.insertaDato(oidConfigCD, 17, arrayDevuelto[15]); // RBOreden (desc)*/
			onClickBuscar();
			
        }
		recargaCombo('formulario.cbDescripcion', 'APEObtenerDescripcionesCD', 'es.indra.sicc.util.DTOBelcorp', 
						[["oidPais", get("formulario.hPais")], ["oidIdioma", get("formulario.hIdioma")]]);
		return true;

	} else 	if (cantSeleccionados == 0) {
		GestionarMensaje("4", null, null, null);
		return false;
	} else {
		cdos_mostrarAlert(GestionarMensaje("240", null, null, null));
	}
}

function muestraLista(ultima, rowset) {
	var tamano = rowset.length;

	if (tamano > 0) {
		visualizarLista("", get("formulario.casoUso"));
        eval(ON_RSZ);
        return true;
    } else {
		visualizarLista("hidden", null);
		focaliza("formulario.cbCentroDistribucion");  
        return false;
    }
}

function visualizarLista(visibilidad, casoUsoSeleccionado) {
	DrdEnsanchaConMargenDcho("listado1", 24);

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

function onTab(campo) {
	if (campo == "cbDescripcion") {
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
	} else if (campo == "cbDescripcion") {
		focaliza('formulario.cbCentroDistribucion');
	} else if (campo == "btnBuscar") {
		focaliza('formulario.cbDescripcion');
	} else if (campo == "btnDetalle") {
		 focalizaBotonHTML('botonContenido','btnBuscar')
	} else if (campo == "btnModificar") {
		 focalizaBotonHTML('botonContenido','btnBuscar')

	}
}

function fLimpiar() {
	set("formulario.cbDescripcion","");
	set("formulario.cbCentroDistribucion","");

	listado1.datos = new Array();
	visualizarLista("hidden", null);
}

function postEliminar(datos) {
	var resultado = resultadoOperacion(datos)
	
	if (resultado) {
		recargaCombo('formulario.cbCentroDistribucion', 'APEObtenerCodigoCentrosDistribucion',
					'es.indra.sicc.util.DTOBelcorp', [["oidPais", get("formulario.hPais")], ["oidIdioma", get("formulario.hIdioma")]]);
		
		recargaCombo('formulario.cbDescripcion', 'APEObtenerDescripcionesCD',
					'es.indra.sicc.util.DTOBelcorp', [["oidPais", get("formulario.hPais")], ["oidIdioma", get("formulario.hIdioma")]]);
	}
    return resultado;
}