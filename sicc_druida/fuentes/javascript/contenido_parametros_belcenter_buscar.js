var lpMantenimiento = 'LPMantenimientoParametrosBel';
var formulario = 'frmParametrosBelcenterBuscar';
var vCasoUso = formulario + '.casoUso';
var vIdioma = formulario + '.idioma';
var vPais = formulario + '.pais';
var vCbCanal = formulario + '.cbCanal';
var vCbAcceso = formulario + '.cbAcceso';
var vCbSubacceso = formulario + '.cbSubAcceso';
var vlistado1 = formulario + '.listado1';
var vBtnBuscar = formulario + '.btnBuscar';
var vBtnDetalle = formulario + '.btnDetalle';
var vBtnModificar = formulario + '.btnModificar';

var hCbCanal = formulario + '.hCbCanal';
var hCbAcceso = formulario + '.hCbAcceso';
var hCbSubAcceso = formulario + '.hCbSubAcceso';
var hBusquedaHecha = formulario + '.hBusquedaHecha';

function onLoad() {
	visualizarLista('hidden', null);
	eval(ON_RSZ);
	fMostrarMensajeError();
	configurarMenuSecundario(formulario);
	focalizarComponente(vCbCanal);
}

function btnBuscarOnClick() {
	hCbCanal = get(vCbCanal);
	hCbAcceso = get(vCbAcceso);
	hCbSubAcceso = get(vCbSubacceso);

	/*
	 * Llamamos a configurarPaginado pasándole los siguientes parametros: 
	 * - Objeto paginado (lstResultado)
	 * - idBusiness ("BELObtenerParametrosBEL")
	 * - "ConectorObtenerParametrosBEL"
	 * - "DTOBusquedaParametrosBEL"
	 * - Parametros del DTO:
	 * - canal
	 * - acceso
	 * - subacceso
	 * - idioma = Idioma del usuario
	 * - pais = el de sesión 
	 */
	
	 /* set(hBusquedaHecha, 0); */

	 configurarPaginado(mipgndo, "BELObtenerParametrosBEL", "ConectorObtenerParametrosBEL",
		"es.indra.sicc.dtos.bel.DTOBusquedaParametrosBEL",
		[["oidPais", get(vPais)],
		 ["oidIdioma", get(vIdioma)], 
		 ["canal", hCbCanal],
		 ["acceso", hCbAcceso],
		 ["subacceso", hCbSubAcceso]]);

     /*
	 if (mipgndo != null) {
		set(hBusquedaHecha,1);
	 } else {
		set(hBusquedaHecha,0);
	 }
	 */
}

function btnDetalleOnClick() {
	elementosSeleccionados("consultar");
}

function btnModificarOnClick() {
	elementosSeleccionados("modificar");
}

function cbCanalOnChange() {
	vaciarCombo(vCbSubacceso);
	vaciarCombo(vCbAcceso);
	recargaCombo(vCbAcceso, 
                 "SEGObtieneAccesosPorCanal", 
				 "es.indra.sicc.util.DTOOID", 
				 [["oidPais", get(vPais)],
				  ["oidIdioma", get(vIdioma)], 
                  ["oid", get(vCbCanal)]]);
}

function cbAccesoOnChange() {
	vaciarCombo(vCbSubacceso);
	recargaCombo(vCbSubacceso, 
                 "SegObtenerSubaccesosPorAcceso", 
				 "es.indra.sicc.util.DTOOID", 
				 [["oidPais", get(vPais)], 
		          ["oidIdioma", get(vIdioma)], 
				  ["oid", get(vCbAcceso)]]);
}

function fLimpiar() {
	vaciarCombo(vCbSubacceso);
	vaciarCombo(vCbAcceso);
    set(vCbCanal, 0);

	focaliza(vCbCanal);
}

function fBorrar() {
	elementosSeleccionados("eliminar");
	btnBuscarOnClick();
}

function vaciarCombo(combo) {
	set_combo(combo, [['', '']], ['']);
}

function muestraLista(ultima, rowset) {
	var tamano = rowset.length;

	if (tamano > 0) {
		visualizarLista("visible", get(vCasoUso));
        return true;
    } else {
		visualizarLista("hidden", null);
		focalizarComponente(vCbCanal);
        return false;
    }
}

function visualizarLista(visibilidad, casoUsoSeleccionado) {
	DrdEnsanchaConMargenDcho("listado1", 12);

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

function elementosSeleccionados(casoUsoSeleccionado) {
    var seleccionados = listado1.codSeleccionados();
    var cantSeleccionados = seleccionados.length;

	if (cantSeleccionados == 0) {
        GestionarMensaje("4", null, null, null);
        return false;
	} else if (casoUsoSeleccionado == "consultar" || casoUsoSeleccionado == "modificar") {
		if (cantSeleccionados == 1) {
			var objParams = new Object();
			objParams.oidParametrosBel = seleccionados[0];

			if (casoUsoSeleccionado == "consultar") {
				mostrarModalSICC(lpMantenimiento, "consultarParametros", objParams, null, null);	
			} else {
				var resultado = mostrarModalSICC(lpMantenimiento, "modificarParametros", objParams, null, null);	
				btnBuscarOnClick();
			}

			return true;
		} else {
			cdos_mostrarAlert(GestionarMensaje("240", null, null, null));
			return false;
		}
	} else if (casoUsoSeleccionado == "eliminar") {
         eliminarFilas(seleccionados, "BELEliminarParametros", mipgndo);
         return true;
	}
}

function focalizarComponente(componente) {
	var nombre = componente.replace(formulario + '.', '');
	var tipoComponente = nombre.substring(0, 2);

	if (tipoComponente == 'bt') {
		focalizaBotonHTML("botonContenido", nombre);
	} else if (tipoComponente == 'cb') {
		focaliza(componente);
	}
}

function tabulacion(componente, direccion) {
	var componenteFormulario = formulario + '.' + componente;
	var btnDetalleDiv = vBtnDetalle.replace(formulario + '.', '') + 'Div';
	var btnModificarDiv = vBtnModificar.replace(formulario + '.', '') + 'Div';

	if (componenteFormulario == vCbCanal && direccion == 'retroceder') {
		if (document.all[btnDetalleDiv].style.visibility != 'hidden') {
			focalizarComponente(vBtnDetalle);
		} else if (document.all[btnModificarDiv].style.visibility != 'hidden') {
			focalizarComponente(vBtnModificar);
		} else {
			focalizarComponente(vBtnBuscar);
		}

		return true;
	}

	if (componenteFormulario == vCbSubacceso && direccion == 'avanzar') {
		focalizarComponente(vBtnBuscar);

		return true;
	}

	if (componenteFormulario == vBtnBuscar && direccion == 'avanzar') {
		if (document.all[btnDetalleDiv].style.visibility != 'hidden') {
			focalizarComponente(vBtnDetalle);
		} else if (document.all[btnModificarDiv].style.visibility != 'hidden') {
			focalizarComponente(vBtnModificar);
		} else {
			focalizarComponente(vCbCanal);
		}

		return true;
	}

	if (componenteFormulario == vBtnBuscar && direccion == 'retroceder') {
		focalizarComponente(vCbSubacceso);

		return true;
	}
	
	if (componenteFormulario == vBtnDetalle || componenteFormulario == vBtnModificar) {
		if (direccion == 'avanzar') {
			focalizarComponente(vCbCanal);
		} else if (direccion == 'retroceder') {
			focalizarComponente(vBtnBuscar);
		}

		return true;
	}
}

/*
function focoBel(campo) {
	focaliza('frmParametrosBelcenterBuscar.' + campo);
}
function setOnTab(name) {
	if (name == "cbCanal") {
		focoBel("cbAcceso");
	} else 	if (name == "cbAcceso") {
		focoBel("cbSubAcceso");
	} else 	if (name == "cbSubAcceso") {
		focoBel("btnBuscar");
	} else 	if (name == "btnBuscar") {

		if (hBusquedaHecha == 0) {
			focoBel("cbCanal");
		} else {
			if (get(vCasoUso) == "consultar") {
				focalizaBotonHTML_XY("btnDetalle");
			} else if (get(vCasoUso) == "modificar") {
				focalizaBotonHTML_XY("btnModificar");
			} else if (get(vCasoUso) == "eliminar") {
				focoBel("cbCanal");
			}
		}

	} else 	if (name == "btnModificar") {
		focoBel("cbCanal");
	} else 	if (name == "btnDetalle") {
		focoBel("cbCanal");
	} else 	if (name == "btnEliminar") {
		focoBel("cbCanal");
	}
}

function setOnShTab(name) {
	if (name == "cbCanal") {
	
		if (hBusquedaHecha == 0) {
			focoBel("btnBuscar");
		} else {
			if (get(vCasoUso) == "consultar") {
				focalizaBotonHTML_XY("btnDetalle");
			} else if (get(vCasoUso) == "modificar") {
				focalizaBotonHTML_XY("btnModificar");
			} else if (get(vCasoUso) == "eliminar") {
				focoBel("btnBuscar");
			}
		}

	} else 	if (name == "cbAcceso") {
		focoBel("cbCanal");
	} else 	if (name == "cbSubAcceso") {
		focoBel("cbAcceso");
	} else 	if (name == "btnBuscar") {
		focoBel("cbSubAcceso");
	} else 	if (name == "btnModificar") {
		focoBel("btnBuscar");
	} else 	if (name == "btnDetalle") {
		focoBel("btnBuscar");
	} else 	if (name == "btnEliminar") {
		focoBel("btnBuscar");
	}
}
*/