
/**
* Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
    $Id: contenido_movimientos_bancarios_historicos_depurar.js,v 1.1 2009/12/03 19:01:36 pecbazalar Exp $
    DESC
*/
var FORMULARIO = 'frmFormulario';

function onLoadPag()   { 
	if (get(FORMULARIO+'.errDescripcion')!='') {
		var wnd = fMostrarMensajeError(get(FORMULARIO+'.errCodigo'), get(FORMULARIO+'.errDescripcion'));
	}
	
	//Control del foco
	focaliza(FORMULARIO + ".cbBanco");

	configurarMenuSecundario(FORMULARIO);
		
}
   
function accionBuscar() {

	var oidBanco = get(FORMULARIO+'.cbBanco');
	var fechaDesde = get(FORMULARIO+'.FechaMovimientoDesde');
	var fechaHasta = get(FORMULARIO+'.FechaMovimientoHasta');
	var oidCuentaCorriente = get(FORMULARIO+'.cbCCC');
	
	var idioma = get(FORMULARIO+'.idioma');
	var pais = get(FORMULARIO+'.pais');
	//Validamos que hay al menos uno de los campos de búsqueda relleno de datos. 
	
	if (oidBanco == "" && fechaDesde == "" && oidCuentaCorriente == "" && fechaHasta == "") {
		GestionarMensaje('1389', 1);
		focaliza(FORMULARIO+'.cbBanco');
	} else { 
		//Invocamos el "subsystema:paginacion" con IdBusiness="CCCBuscarConfirmarMovBanc"  DTOBuscarConfirmarMovBanc 
		configurarPaginado(mipgndo, "CCCBuscarMovBancDepurar", "ConectorBuscarMovBancDepurar", "es.indra.sicc.dtos.ccc.DTOBuscarMovBancDepurar",
			[['oidBanco', oidBanco], 
			['oidCuentaCorriente', oidCuentaCorriente], 
			['fechaMovDesde', fechaDesde], 
			['oidPais', pais], 
			['oidIdioma', idioma], 
			['fechaMovHasta', fechaHasta]]);
	}
}

	function muestraLista( ultima, rowset){

		var tamano = rowset.length;
		if (tamano > 0) {
			mostrarLista();
			return true;
		} else {
			ocultarLista();
			// No se ha encontrado ningún elemento con los criterios especificados
         	//Control del foco
			focaliza(FORMULARIO + ".cbBanco");
		  	return false;
		 }
	}


	function fLimpiar() {
		vaciaCombo(FORMULARIO + '.cbCCC');
		focaliza(FORMULARIO + ".cbBanco");
	}

	function fVolver(){
     	window.close();
	}


	//valida la fecha si el campo es modificable y no vacío 
	function validaFecha(fecha) {
		if (get(FORMULARIO + '.' + fecha) != "") {
			var resul = EsFechaValida(get(FORMULARIO + '.' + fecha), get(FORMULARIO + '.' + fecha), FORMULARIO, null);
			if (resul == 1 || resul == 2) {  
				GestionarMensaje('1006', get(FORMULARIO + '.hFormatoFechaPais'));
				focaliza(FORMULARIO + '.' + fecha);
				return false;
			}
		}
	} 

	function bancoOnChange() {

		var banco = get(FORMULARIO + '.cbBanco');
		if (banco != "") {
			var idioma = get(FORMULARIO + '.idioma');
			var pais = get(FORMULARIO + '.pais');
			recargaCombo(FORMULARIO + '.cbCCC', 'CCCRecargarCCBancos', 'es.indra.sicc.util.DTOOID',  [["oidPais", pais], ["oidIdioma", idioma], ["oid", banco]], '');		
		} else {
			vaciaCombo(FORMULARIO + '.cbCCC');
		}
	}

	function vaciaCombo(combo) {
		set_combo(combo, [['','']], ['']);
	}


	function accionBTN_Detalle() {
		if (listado1.numSelecc() == 0) {
			// Muestra el mensaje: "Debe seleccionar un elemento de la lista"
			GestionarMensaje('50');
		} else {
			if (listado1.numSelecc() != 1 ) {
				//Muesta el mensaje: "Debe seleccionar un solo registro"
				GestionarMensaje('8');
				deseleccionaListado();
			} else {
				var objParams = new Object();
				objParams.oid = listado1.codSeleccionados(); //campo oculto de la fila seleccionada
	            mostrarModalSICC('LPDepurarMovBancHist', 'detalle', objParams, null, null);
			} 
		}
	}


	function deseleccionaListado() {
		for (i = 0; i < listado1.datos.length; i++)
			listado1.deselecciona(i); 
	}

	function accionBTN_Traspasar() {
		
		if (listado1.numSelecc() == 0) {
			// Muestra el mensaje: "Debe seleccionar al menos un elemento de la lista"
			GestionarMensaje('1021');
		} else {
			var cadenaOids = "";
			var codigosSeleccionados = listado1.codSeleccionados();
			for (i = 0; i < codigosSeleccionados.length; i++)
				cadenaOids += codigosSeleccionados[i] + "#";

	        set(FORMULARIO + '.oidsMovimiento', cadenaOids);
			set(FORMULARIO + '.accion', 'traspasar');
			set(FORMULARIO + '.conectorAction', "LPDepurarMovBancHist");
			enviaSICC(FORMULARIO);
		}
	}
	
	function traspasoCorrecto() {
		fLimpiarGenericoSICC();
		fLimpiar();
        listado1.limpia();
	}
	
	function accionBTN_Marcar () {
		for (i = 0; i < listado1.datos.length; i++)
			listado1.selecciona(i);
	}
	
	function accionBTN_Desmarcar () {
		for (i = 0; i < listado1.datos.length; i++)
			listado1.deselecciona(i);
	}
	

	function mostrarLista() {
		DrdEnsanchaConMargenDcho('listado1',12);
		document.all["Cplistado1"].style.visibility='visible';
		document.all["CpLin1listado1"].style.visibility='visible';
		document.all["CpLin2listado1"].style.visibility='visible';
		document.all["CpLin3listado1"].style.visibility='visible';
		document.all["CpLin4listado1"].style.visibility='visible';
		document.all["primera1Div"].style.visibility='visible';
		document.all["ret1Div"].style.visibility='visible';
		document.all["ava1Div"].style.visibility='visible';
		document.all["separa1Div"].style.visibility='visible';
		document.all["TraspasarDiv"].style.visibility='visible';
		document.all["DetalleDiv"].style.visibility='visible';
		eval (ON_RSZ);  
	}

	function ocultarLista() {
		document.all["Cplistado1"].style.visibility='hidden';
		document.all["CpLin1listado1"].style.visibility='hidden';
		document.all["CpLin2listado1" ].style.visibility='hidden';
		document.all["CpLin3listado1"].style.visibility='hidden';
		document.all["CpLin4listado1"].style.visibility='hidden';
		document.all["primera1Div"].style.visibility='hidden';
		document.all["ret1Div"].style.visibility='hidden';
		document.all["ava1Div"].style.visibility='hidden';
		document.all["separa1Div"].style.visibility='hidden';
		document.all["TraspasarDiv"].style.visibility='hidden';
		document.all["DetalleDiv"].style.visibility='hidden';
	}



function focalizaSiguienteBuscar(){
	if (listado1.datos.length > 0)
		document.all['Detalle'].focus();
	else
		focaliza(FORMULARIO +'.cbBanco');
}

function focalizaAnteriorBanco(){
	if (listado1.datos.length > 0)
		document.all['Traspasar'].focus();
	else
		document.all['btnBuscar'].focus();
}
