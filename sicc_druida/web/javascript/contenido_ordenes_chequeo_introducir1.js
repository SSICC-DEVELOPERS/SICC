/**
* Copyright 2005 © por Indra Sistemas,S.A.. Todos los derechos reservados.
* Avda. de Bruselas, 35
* Parque Empresarial Arroyo de la Vega
* 28108 Alcobendas, Madrid
* España
*
* Privado y Confidencial.
* La información contenida en este documento es propiedad de Indra sistemas.
* Para uso exclusivo de empleados autorizados no permitiéndose
* la distribución de este código sin permiso expreso.
*/ 


/*
    INDRA/CAR/PROY
    $Id: contenido_ordenes_chequeo_introducir1.js,v 1.1 2009/12/03 19:02:21 pecbazalar Exp $
    DESC
*/
var FORMULARIO = 'frmFormulario';
var SGV = 2;
var REGION = 4;
var ZONA = 6;
var SECCION = 8;
varNoLimpiarSICC = true;

var cargoPeriodoInicial = false;
var cargoPeriodoFinal = false;
var cargoPeriodoReclamo = false;
var cargoSGV = false;

/* ----------------------------------------------------------------------------------------------------------------- */
function onLoadPag() {

	if (get(FORMULARIO + '.errDescripcion')!='') {
		var wnd = fMostrarMensajeError(get(FORMULARIO + '.errCodigo'), get(FORMULARIO + '.errDescripcion'));
		window.close();
	}
	set(FORMULARIO + '.cbMarca', [get(FORMULARIO + '.marcaPorDefecto')])
	set(FORMULARIO + '.cbCanal', [get(FORMULARIO + '.canalPorDefecto')])
	cbMarcaOnChange();
	configurarMenuSecundario(FORMULARIO);
	focaliza(FORMULARIO + '.cbMarca');
	document.getElementById("capaChequeoEnCampo").style.display = 'none';
	muestraListado('none');
	setTimeout("manejoLista()", 200);
}
 
/* ----------------------------------------------------------------------------------------------------------------- */
function manejoLista() {
    DrdEnsanchaConMargenDcho('listado2', 24);
	eval(ON_RSZ);
}

/* ----------------------------------------------------------------------------------------------------------------- */
function muestraListado(oculto)
{
    document.all["Cplistado2"].style.display=oculto;
    document.all["CpLin1listado2"].style.display=oculto;
    document.all["CpLin2listado2"].style.display=oculto;
    document.all["CpLin3listado2"].style.display=oculto;
    document.all["CpLin4listado2"].style.display=oculto;
    DrdEnsanchaConMargenDcho('listado2', 24);
	eval(ON_RSZ);


}
/* ----------------------------------------------------------------------------------------------------------------- */
//para mostrar la capa de campos 'enLinea'
function cbMarcaOnChange() {
	vaciaCombo(FORMULARIO + '.cbPeriodo');
	if (get(FORMULARIO + '.cbMarca') != "" && get(FORMULARIO + '.cbCanal') != "")
		recargaPeriodo(get(FORMULARIO + '.cbMarca').toString(), get(FORMULARIO + '.cbCanal').toString());
}

/* ----------------------------------------------------------------------------------------------------------------- */
function recargaPeriodo(marca, canal) {
	/*
	Llamar al método recargaCombo utilizando el DTOPeriodo y el idBusiness = "CRAObtenerPeriodosPosteriores". 
	Parametros del DTOPeriodo: 
	- DTOPeriodo.oidPais = oid del pais activo 
	- DTOPeriodo.oidMarca = oid de la marca seleccionada 
	- DTOPeriodo.oidCanal = oid del canal seleccionado 
	*/
	recargaCombo(FORMULARIO + '.cbPeriodo', 'CRAObtenerPeriodosPosterioresActivos', 'es.indra.sicc.dtos.cra.DTOPeriodo', [["pais", get(FORMULARIO + '.pais').toString()], ["oidPais", get(FORMULARIO + '.pais').toString()], ["oidIdioma", get(FORMULARIO + '.idioma').toString()], ["marca", marca], ["canal", canal]]);
}

/* ----------------------------------------------------------------------------------------------------------------- */
function vaciaCombo(combo) {
	set_combo(combo, [['','']], ['']);
}

/* ----------------------------------------------------------------------------------------------------------------- */
function fLimpiar() {

	/* Deshabilita los combos del "encabezado y boton" */
	accion(FORMULARIO + ".cbMarca", ".disabled=false");
	accion(FORMULARIO + ".cbCanal", ".disabled=false");
	accion(FORMULARIO + ".cbPeriodo", ".disabled=false");
	deshabilitarHabilitarBoton('botonContenido','btnAceptar','A')

	vaciaCombo(FORMULARIO + '.cbPeriodo');
	set(FORMULARIO + '.cbMarca', [get(FORMULARIO + '.marcaPorDefecto')])
	set(FORMULARIO + '.cbCanal', [get(FORMULARIO + '.canalPorDefecto')])

	document.getElementById("capaChequeoEnCampo").style.display = 'none';
	muestraListado('none');
	btnProxy(1,0); /* Habilito el fGuardar */ 
	btnProxy(4,0); /* Habilito el fBorrar */ 

	cbMarcaOnChange();
	focaliza(FORMULARIO + '.cbMarca');
}

/* ----------------------------------------------------------------------------------------------------------------- */
function fVolver() {
	window.close();
}

/* ----------------------------------------------------------------------------------------------------------------- */
function btnAceptarOnClick() {
/*
// Pulsa sobre el botón Aceptar 

Comprueba que se ha seleccionado un valor en el combo cbPeriodo 

Envia a LPIntroducirOrdenesChequeos los parámetros: 
- accion = "Selecciona periodo" 
- nombreChequeo = Valor de lbTipoOrdenChequeo 
- nombreMarca = Descripcion seleccionada en cbMarca 
- nombreCanal = Descripcion seleccionada en cbCanal 
- nombrePeriodo = Descripcion seleccionada en cbPeriodo 
- oidMarca = oid de la marca seleccionada 
- oidCanal = oid del canal seleccionado 
- oidPeriodo = oid seleccionado en oidPeriodo 
*/

	if (!sicc_validaciones_generales("encabezado")) { return false; }
	/* Deshabilita los combos del "encabezado y boton" */
	accion(FORMULARIO + ".cbMarca", ".disabled=true");
	accion(FORMULARIO + ".cbCanal", ".disabled=true");
	accion(FORMULARIO + ".cbPeriodo", ".disabled=true");
	deshabilitarHabilitarBoton('botonContenido','btnAceptar','D')

	cargaCombosChequeo(); 

	/*var datos = mostrarModalSICC('LPIntroducirOrdenesChequeos', 'Selecciona periodo', objParams, null, null);
	if (datos != null && datos == "iniciar")	 window.close();*/
}


/* ----------------------------------------------------------------------------------------------------------------- */
 function cargaCombosChequeo() {
		var marca = get(FORMULARIO + '.cbMarca');
		var canal = get(FORMULARIO + '.cbCanal');
		var periodo = get(FORMULARIO + '.cbPeriodo');
	    var pais = get(FORMULARIO + '.pais');
		var idioma = get(FORMULARIO + '.idioma');

		var arrayPeriodo = new Array();
		arrayPeriodo[0] = ['oidPais', pais];
		arrayPeriodo[1] = ['pais', pais];
		arrayPeriodo[2] = ['oidIdioma', idioma];
		arrayPeriodo[3] = ['marca', marca[0]];
		arrayPeriodo[4] = ['canal', canal[0]];

		var arrayBelcorp = new Array();
		arrayBelcorp[0] = ['oidPais', pais];
		arrayBelcorp[1] = ['oidIdioma', idioma];

		var arrayDTOUA = new Array();
		arrayDTOUA[0] = ['oidPais', pais];
		arrayDTOUA[1] = ['oidMarca', marca];
		arrayDTOUA[2] = ['oidCanal', canal];
 
		recargaCombo(FORMULARIO + '.cblPeriodoInicialEvaluacion2', 
					 'CRAObtenerPeriodos', 
					 'es.indra.sicc.dtos.cra.DTOPeriodo', 
					 arrayPeriodo,
					 "chequeaCargaCombos(datos, 1);");

		recargaCombo(FORMULARIO + '.cbPeriodoFinalEvaluacion2', 
					 'CRAObtenerPeriodos', 
					 'es.indra.sicc.dtos.cra.DTOPeriodo', 
					 arrayPeriodo,
					 "chequeaCargaCombos(datos, 2);");

		recargaCombo(FORMULARIO + '.cbPeriodoReclamoEvaluacion', 
					 'RECObtenerPeriodosReclamo', 
					 'es.indra.sicc.util.DTOBelcorp', 
					 arrayBelcorp,
					 "chequeaCargaCombos(datos, 3);");
	
		recargaCombo(FORMULARIO + '.cbSubgerenciaVentas2', 
					 'ZONRecargaSubgerenciaVentas', 
					 'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa', 
					 arrayDTOUA,
					 "chequeaCargaCombos(datos, 4);");
 }

/* ----------------------------------------------------------------------------------------------------------------- */
function chequeaCargaCombos(datos, combo) {
    datos = agregaElementoVacio(datos);
	if (combo == "1") {
	   set_combo(FORMULARIO + '.cblPeriodoInicialEvaluacion2', datos);
	   cargoPeriodoInicial = true;
	}

	if (combo == "2") {
	   set_combo(FORMULARIO + '.cbPeriodoFinalEvaluacion2', datos);
	   cargoPeriodoFinal = true;
	}

	if (combo == "3") {
	   set_combo(FORMULARIO + '.cbPeriodoReclamoEvaluacion', datos);
	   cargoPeriodoReclamo = true;
	}

	if (combo == "4") {
	   set_combo(FORMULARIO + '.cbSubgerenciaVentas2', datos);
	   cargoSGV = true;
	   cbSubgerenciaVentasOnChange();
	}

	if (cargoPeriodoInicial && cargoPeriodoFinal &&
					cargoPeriodoReclamo && cargoSGV) {
		obtenerChequeo();
		/* Todos los combos cargados, reseteo los valores para la proxima vez */ 
		cargoPeriodoInicial = false;
		cargoPeriodoFinal = false;
		cargoPeriodoReclamo = false;
		cargoSGV = false;
	}

}

/* ----------------------------------------------------------------------------------------------------------------- */
function agregaElementoVacio(array) {
	var arrayRetorno = new Array(); 

	arrayRetorno[0] = ['',''];
	arrayRetorno = arrayRetorno.concat(array);

	return arrayRetorno;
}


/* ----------------------------------------------------------------------------------------------------------------- */
function obtenerChequeo() {
	eval(FORMULARIO).oculto = "S";

	var periodo = get(FORMULARIO + ".cbPeriodo");

	set(FORMULARIO + ".conectorAction", "LPIntroducirOrdenesChequeos");
	set(FORMULARIO + ".accion", "obtenerChequeo");
	set(FORMULARIO + ".periodo", periodo);

	enviaSICC(FORMULARIO, null, null, "N");
}


/* ----------------------------------------------------------------------------------------------------------------- */
function luegoObtenerChequeo(cantidad, periodoINI, periodoFIN, 
							 periodoRECLAMO, consultoraNueva, oidChequeo,
							 lista) {


	if (oidChequeo == ''){ oidChequeo = 0; }
	set(FORMULARIO + ".txtCantidadTotal", cantidad);
	set(FORMULARIO + ".cblPeriodoInicialEvaluacion2", new Array(periodoINI) );
	set(FORMULARIO + ".cbPeriodoFinalEvaluacion2", new Array(periodoFIN) );
	set(FORMULARIO + ".cbPeriodoReclamoEvaluacion", new Array(periodoRECLAMO) );
	set(FORMULARIO + ".chkConsultorasNuevas2", consultoraNueva);
	set(FORMULARIO + ".oidChequeo", oidChequeo);

	if (lista != '') {
		var nuevaLista = new Array();
		var arrayFilas = lista.split("|");
		var cantFilas = arrayFilas.length;
		var cantCampos = 10;
		var fila = null;
		var campo = null;
		var arrayCampos = null;

		for (var i=0; i<cantFilas; i++) {
			fila = arrayFilas[i];
			arrayCampos = fila.split("~");
			for (var j=0; j<cantCampos; j++) {
				campo = arrayCampos[j];
				if (campo == " ") {
					arrayCampos[j] = "";
				}
			}
			nuevaLista[i] = arrayCampos;
		}
		listado2.setDatos(nuevaLista);
	}

	document.getElementById("capaChequeoEnCampo").style.display = 'inline';
	muestraListado('inline');
	btnProxy(1,1); /* Habilito el fGuardar */ 
	btnProxy(4,1); /* Habilito el fBorrar */ 
	focaliza(FORMULARIO + ".txtCantidadTotal");


}


/* ---------------------------- Funciones Modal -------------------------------------------------------------------- */
function vaciaCombo(combo) {
	set_combo(combo, [['','']], ['']);
}

/* ----------------------------------------------------------------------------------------------------------------- */
function cbSubgerenciaVentasOnChange() {
	vaciaCombo(FORMULARIO + '.cbRegion2');
	vaciaCombo(FORMULARIO + '.cbZona2');
	vaciaCombo(FORMULARIO + '.cbSeccion2');
	
	if (get(FORMULARIO + '.cbSubgerenciaVentas2') != "") {
		recargaRegion(get(FORMULARIO + '.cbSubgerenciaVentas2').toString());
	}
}

/* ----------------------------------------------------------------------------------------------------------------- */
function cbRegionOnChange() {
	vaciaCombo(FORMULARIO + '.cbZona2');
	vaciaCombo(FORMULARIO + '.cbSeccion2');
	if (get(FORMULARIO + '.cbRegion2') != "")
		recargaZona(get(FORMULARIO + '.cbRegion2').toString());
}

/* ----------------------------------------------------------------------------------------------------------------- */
function cbZonaOnChange() {
	vaciaCombo(FORMULARIO + '.cbSeccion2');
	if (get(FORMULARIO + '.cbZona2') != "") {
		recargaSeccion(get(FORMULARIO + '.cbZona2').toString());
	}
}

/* ----------------------------------------------------------------------------------------------------------------- */
function recargaRegion(subgerencia) {
	/*
	Llamar al método recargaCombo utilizando el DTOUnidadAdministrativa y 
	el idBusiness = "ZONObtenerRegionesPorSGV". 
	
	Parametros del DTOUnidadAdministrativa: 
	- oidSGV = oid del valor seleccionado en cbSubgerenciaVentas 
	*/

	var arrayRegiones = new Array();
	arrayRegiones[0] = ['oidPais', get(FORMULARIO + '.pais')];
	arrayRegiones[1] = ['oidIdioma', get(FORMULARIO + '.idioma')];
	arrayRegiones[2] = ['oidSGV', subgerencia];

	recargaCombo(FORMULARIO + '.cbRegion2', 
				 'ZONRecargaRegiones', 
				 'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa', 
		         arrayRegiones);
}


/* ----------------------------------------------------------------------------------------------------------------- */
function recargaSeccion(zona) {
	/*
	Llamar al método recargaCombo utilizando el DTOUnidadAdministrativa y el idBusiness = "ZONRecargaSecciones". 
	
	Parametros del DTOUnidadAdministrativa: 
	- oidZona = oid del valor seleccionado en cbZona 
	*/
	var arraySecciones = new Array();
	arraySecciones[0] = ['oidPais', get(FORMULARIO + '.pais')];
	arraySecciones[1] = ['oidIdioma', get(FORMULARIO + '.idioma')];
	arraySecciones[2] = ['oidZona', zona];
	recargaCombo(FORMULARIO + '.cbSeccion2', 
				 'ZONRecargaSecciones', 
				 'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa', 
		         arraySecciones);
}


/* ----------------------------------------------------------------------------------------------------------------- */
function recargaZona(region) {
	/*
	Llamar al método recargaCombo utilizando el DTOUnidadAdministrativa y 
	el idBusiness = "ZONRecargaZonas". 
	
	Parametros del DTOUnidadAdministrativa: 
	- oidRegion = oid del valor seleccionado en cbRegion 
	*/
	var arrayZonas = new Array();
	arrayZonas[0] = ['oidPais', get(FORMULARIO + '.pais')];
	arrayZonas[1] = ['oidIdioma', get(FORMULARIO + '.idioma')];
	arrayZonas[2] = ['oidRegion', region];

	recargaCombo(FORMULARIO + '.cbZona2', 
				 'ZONRecargaZonas', 
		         'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa', 
		         arrayZonas);
}

/* ----------------------------------------------------------------------------------------------------------------- */
function btnAnyadirOnClick() {
	/*
	Añade una nueva fila a la lista lstZonas con los valores: 
	- Subgerencia de ventas = Descripción seleccionada en cbSubgerenciaVentas 
	- Region = Descripción seleccionada en cbRegion (Vacío si no hay selección) 
	- Zona = Descripción seleccionada en cbZona (Vacío si no hay selección) 
	- Seccion = Descripción seleccionada en cbSeccion (Vacío si no hay selección) 
	*/

	 if (!sicc_validaciones_generales("GEO")) return false;
	/* if (!sicc_validaciones_generales("CHEQUEO")) { return false; }*/

	if (!validarFila()) {
		GestionarMensaje('UIREC010');
		return false;
	}
	listado2.insertar([listado2.generaCodigo(), 
			'',
			get(FORMULARIO + '.cbSubgerenciaVentas2').toString(),
			get(FORMULARIO + '.cbSubgerenciaVentas2', 'T').toString(),
			get(FORMULARIO + '.cbRegion2').toString(),
			get(FORMULARIO + '.cbRegion2', 'T').toString(),
			get(FORMULARIO + '.cbZona2').toString(),
			get(FORMULARIO + '.cbZona2', 'T').toString(),
			get(FORMULARIO + '.cbSeccion2').toString(),
			get(FORMULARIO + '.cbSeccion2', 'T').toString()]);
	listado2.reajusta();
}


/* ----------------------------------------------------------------------------------------------------------------- */
/* Valida que se puede agregar la fila a la tabla
   Para ello se valida que no exista otro registro igual (sin tener en cuenta blancos). 
   Es decir, si existe un registro: Subg. 1, Reg. 1, Zon. NULL, Secc. NULL y se intenta guardar Subg. 1 y el resto NULL, 
   se dará como repetido, ya que se quiere abarcar toda la subgerencia 1 cuando ya hay algo mas especifico. 
   Lo mismo ocurrirá en el caso contrario. Si tenemos un registro con Subg. 1, Reg. NULL, Zon. NULL, 
   Secc. NULL e intentamos añadir Subg. 1, Reg. 1, Zon. 2, Secc. 1, dará error, ya que el registro existente abarca 
   toda la subgerencia, y por tanto, al registro que queremos añadir */
function validarFila() {
	/* 
	Para resolver esto comparamos los datos del registro que queremos insertar 
	con los ya existentes en la lista para la misma subgerencia de ventas. 
	Si el valor a insertar o el ya insertado es null, da error. Es decir, 
	si para una subgerencia de ventas se encuentra en la lista el valor null para la región, 
	no podemos insertar ningún registro más. Al contrario ocurre igual. 
	Si se encuentra insertada la región 1 y pensamos insertar el valor null, da error. 
	Si para la misma subgerencia de ventas, los valores de region son diferentes, se inserta el registro. 
	Si para la misma subgerencia de ventas, los valores de region son iguales, pasamos a comparar las zonas.
	Y así sucesivamente. 
	*/
	var oidSV = get(FORMULARIO + '.cbSubgerenciaVentas2').toString(); 
	var oidRegion = get(FORMULARIO + '.cbRegion2').toString(); 
	var oidZona = get(FORMULARIO + '.cbZona2').toString(); 
	var oidSeccion = get(FORMULARIO + '.cbSeccion2').toString(); 
	listado2.actualizaDat();
	var datosZonas = listado2.datos;
	for (i = 0; i < datosZonas.length; i++) {
		if(datosZonas[i][SGV] == oidSV) {
			if (datosZonas[i][REGION] == '' || oidRegion == '') return false;
			if (oidRegion == datosZonas[i][REGION] ) {
				if (datosZonas[i][ZONA] == '' || oidZona == '') return false;
				if (datosZonas[i][ZONA] == oidZona) {
					if (datosZonas[i][SECCION] == '' || oidSeccion == '') return false;
					if (datosZonas[i][SECCION] == oidSeccion) return false;
				}// Fin Si oidZona == lista[i].oidZona
			}// Fin Si oidRegion == lista[i].oidRegion
		}//Si oidSV == listaZonas[i].oidSubgerenciaVentas
	}
	return true;
}

/* ----------------------------------------------------------------------------------------------------------------- */
function fGuardar() {
	if (!sicc_validaciones_generales("CHEQUEO")) { return false; }

	set(FORMULARIO + '.zonas', recuperarZonas());
	set(FORMULARIO + '.accion', 'Guardar chequeo en campo');
	set(FORMULARIO + '.conectorAction', "LPIntroducirOrdenesChequeos");
	enviaSICC(FORMULARIO, null, null, 'N');

}

/* ----------------------------------------------------------------------------------------------------------------- */
function recuperarZonas() {
	listado2.actualizaDat(); //Actualiza el array 'datos'
	var datosFinal = listado2.datos;
	var resultado = "";
	for (i = 0; i < datosFinal.length; i++) {
		var fila = datosFinal[i];

		var region = fila[REGION];
		if (region == '') region = '-';

		var zona = fila[ZONA];
		if (zona == '') zona = '-';

		var seccion = fila[SECCION];
		if (seccion == '') seccion = '-';
		
		resultado += fila[SGV] + "@" + region + "@" + zona + "@" + seccion + "#";
	}
	return resultado;
}

/* ----------------------------------------------------------------------------------------------------------------- */
function fBorrar() {
	if (listado2.numSelecc() == 0) {
		// Muestra el mensaje: "Debe seleccionar al menos un elemento de la lista"
		GestionarMensaje('1021');
	} else {
		listado2.eliminarSelecc();
	}
}

/* ----------------------------------------------------------------------------------------------------------------- */
//Funcion que se ejecuta cuando se valida el formulario en la caja de texto de la caja
function validaTotal(enteros) {
	var valor = get(FORMULARIO + '.txtCantidadTotal').toString();
	//Validamos que no inserte en un formato incorrecto
	if(valor != "") {
		var msg = ValidaCaracteres(valor,'0123456789');
		if (msg != "OK") {
			cdos_mostrarAlert(DrdMsgCore(143) + '0123456789');
		} else {
			msg = ValidaMilesDecimales(valor, enteros, 0, get(FORMULARIO + '.hid_SeparadorMiles'), get(FORMULARIO + '.hid_SeparadorDecimales'), 0);
			if (msg != "OK") 
				cdos_mostrarAlert(msg);
		}
		if (msg != "OK") 
			focaliza(FORMULARIO + '.txtCantidadTotal');
	}
}


