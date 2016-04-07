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
    $Id: contenido_ordenes_chequeo_introducir_chequeo.js,v 1.1 2009/12/03 19:02:22 pecbazalar Exp $
    DESC
*/
var FORMULARIO = 'frmFormulario';
var SGV = 2;
var REGION = 4;
var ZONA = 6;
var SECCION = 8;
varNoLimpiarSICC = true;

	
	function onLoadPag() {

		if (get(FORMULARIO + '.errDescripcion')!='') {
			var wnd = fMostrarMensajeError(get(FORMULARIO + '.errCodigo'), get(FORMULARIO + '.errDescripcion'));
			window.close();
		}
		configurarMenuSecundario(FORMULARIO);
		DrdEnsanchaConMargenDcho('listado2', 24);
		eval (ON_RSZ);
		set(FORMULARIO + '.cblPeriodoInicialEvaluacion2', [get(FORMULARIO + '.periodoINI')])
		set(FORMULARIO + '.cbPeriodoFinalEvaluacion2', [get(FORMULARIO + '.periodoFIN')])
		set(FORMULARIO + '.cbPeriodoReclamoEvaluacion', [get(FORMULARIO + '.periodoRECLAMO')])

		focaliza(FORMULARIO + '.txtCantidadTotal');
	}
 
	function cbSubgerenciaVentasOnChange() {
		vaciaCombo(FORMULARIO + '.cbRegion2');
		vaciaCombo(FORMULARIO + '.cbZona2');
		vaciaCombo(FORMULARIO + '.cbSeccion2');
		
		if (get(FORMULARIO + '.cbSubgerenciaVentas2') != "")
			recargaRegion(get(FORMULARIO + '.cbSubgerenciaVentas2').toString());
	}

	function recargaRegion(subgerencia) {
		/*
		Llamar al método recargaCombo utilizando el DTOUnidadAdministrativa y el idBusiness = "ZONObtenerRegionesPorSGV". 
		
		Parametros del DTOUnidadAdministrativa: 
		- oidSGV = oid del valor seleccionado en cbSubgerenciaVentas 
		*/
		recargaCombo(FORMULARIO + '.cbRegion2', 'ZONRecargaRegiones', 'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa', [["oidPais", get(FORMULARIO + '.pais').toString()], ["oidIdioma", get(FORMULARIO + '.idioma').toString()], ["oidSGV", subgerencia]]);
	}

	function cbRegionOnChange() {
		vaciaCombo(FORMULARIO + '.cbZona2');
		vaciaCombo(FORMULARIO + '.cbSeccion2');
		if (get(FORMULARIO + '.cbRegion2') != "")
			recargaZona(get(FORMULARIO + '.cbRegion2').toString());
	}

	function recargaZona(region) {
		/*
		Llamar al método recargaCombo utilizando el DTOUnidadAdministrativa y el idBusiness = "ZONRecargaZonas". 
		
		Parametros del DTOUnidadAdministrativa: 
		- oidRegion = oid del valor seleccionado en cbRegion 
		*/
		recargaCombo(FORMULARIO + '.cbZona2', 'ZONRecargaZonas', 'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa', [["oidPais", get(FORMULARIO + '.pais').toString()], ["oidIdioma", get(FORMULARIO + '.idioma').toString()], ["oidRegion", region]]);
	}


	function cbZonaOnChange() {
		vaciaCombo(FORMULARIO + '.cbSeccion2');
		if (get(FORMULARIO + '.cbZona2') != "")
			recargaSeccion(get(FORMULARIO + '.cbZona2').toString());
	}

	function recargaSeccion(zona) {
		/*
		Llamar al método recargaCombo utilizando el DTOUnidadAdministrativa y el idBusiness = "ZONRecargaSecciones". 
		
		Parametros del DTOUnidadAdministrativa: 
		- oidZona = oid del valor seleccionado en cbZona 
		*/
		recargaCombo(FORMULARIO + '.cbSeccion2', 'ZONRecargaSecciones', 'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa', [["oidPais", get(FORMULARIO + '.pais').toString()], ["oidIdioma", get(FORMULARIO + '.idioma').toString()], ["oidZona", zona]]);
	}

	function vaciaCombo(combo) {
		set_combo(combo, [['','']], ['']);
	}



	function fLimpiar() {
		vaciaCombo(FORMULARIO + '.cbRegion2');
		vaciaCombo(FORMULARIO + '.cbZona2');
		vaciaCombo(FORMULARIO + '.cbSeccion2');
		set(FORMULARIO + '.cbSubgerenciaVentas2', [''])
		set(FORMULARIO + '.cblPeriodoInicialEvaluacion2', [get(FORMULARIO + '.periodoINI')])
		set(FORMULARIO + '.cbPeriodoFinalEvaluacion2', [get(FORMULARIO + '.periodoFIN')])
		set(FORMULARIO + '.cbPeriodoReclamoEvaluacion', [get(FORMULARIO + '.periodoRECLAMO')])
		set(FORMULARIO + '.chkConsultorasNuevas2', get(FORMULARIO + '.hid_chkConsultorasNuevas2'))
		set(FORMULARIO + '.txtCantidadTotal', get(FORMULARIO + '.cantidad'))

		listado2.load();
		listado2.reajusta();
		focaliza(FORMULARIO + '.txtCantidadTotal');
	}

	function fVolver() {
		window.close();
	}


	function btnAnyadirOnClick() {
		/*
		Añade una nueva fila a la lista lstZonas con los valores: 
		- Subgerencia de ventas = Descripción seleccionada en cbSubgerenciaVentas 
		- Region = Descripción seleccionada en cbRegion (Vacío si no hay selección) 
		- Zona = Descripción seleccionada en cbZona (Vacío si no hay selección) 
		- Seccion = Descripción seleccionada en cbSeccion (Vacío si no hay selección) 
		*/

		if (!sicc_validaciones_generales("GEO")) return false;
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

	//Valida que se puede agregar la fila a la tabla
	//Para ello se valida que no exista otro registro igual (sin tener en cuenta blancos). Es decir, si existe un registro: Subg. 1, Reg. 1, Zon. NULL, Secc. NULL y se intenta guardar Subg. 1 y el resto NULL, se dará como repetido, ya que se quiere abarcar toda la subgerencia 1 cuando ya hay algo mas especifico. 
	//Lo mismo ocurrirá en el caso contrario. Si tenemos un registro con Subg. 1, Reg. NULL, Zon. NULL, Secc. NULL e intentamos añadir Subg. 1, Reg. 1, Zon. 2, Secc. 1, dará error, ya que el registro existente abarca toda la subgerencia, y por tanto, al registro que queremos añadir 
	function validarFila() {
		/* 
		
		Para resolver esto comparamos los datos del registro que queremos insertar con los ya existentes en la lista para la misma subgerencia de ventas. Si el valor a insertar o el ya insertado es null, da error. Es decir, si para una subgerencia de ventas se encuentra en la lista el valor null para la región, no podemos insertar ningún registro más. Al contrario ocurre igual. Si se encuentra insertada la región 1 y pensamos insertar el valor null, da error. 
		Si para la misma subgerencia de ventas, los valores de region son diferentes, se inserta el registro. 
		Si para la misma subgerencia de ventas, los valores de region son iguales, pasamos a comparar las zonas. Y así sucesivamente. 
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

	function fBorrar() {
		if (listado2.numSelecc() == 0) {
			// Muestra el mensaje: "Debe seleccionar al menos un elemento de la lista"
			GestionarMensaje('1021');
		} else {
			listado2.eliminarSelecc();
		}
	}

	function fGuardar() {
		if (!sicc_validaciones_generales("CHEQUEO")) return false;

		set(FORMULARIO + '.zonas', recuperarZonas());
		set(FORMULARIO + '.accion', 'Guardar chequeo en campo');
		set(FORMULARIO + '.conectorAction', "LPIntroducirOrdenesChequeos");
		enviaSICC(FORMULARIO, null, null, 'N');
	}


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

	function inicializar() {
		window.returnValue = 'iniciar';
		window.close();
	}
	