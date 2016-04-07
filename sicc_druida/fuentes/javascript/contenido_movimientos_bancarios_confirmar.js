
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
    $Id: contenido_movimientos_bancarios_confirmar.js,v 1.1 2009/12/03 19:02:06 pecbazalar Exp $
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
	var fechaMovimiento = get(FORMULARIO+'.FechaMov');
	var oidCuentaCorriente = get(FORMULARIO+'.cbCCC');
	var numeroLote = get(FORMULARIO+'.NLote');
	
	var idioma = get(FORMULARIO+'.idioma');
	var pais = get(FORMULARIO+'.pais');
	//Validamos que hay al menos uno de los campos de búsqueda relleno de datos. 
	
	if (oidBanco == "" && fechaMovimiento == "" && oidCuentaCorriente == "" && numeroLote == "") {
		GestionarMensaje('1389', 1);
		focaliza(FORMULARIO+'.cbBanco');
	} else { 
		//Invocamos el "subsystema:paginacion" con IdBusiness="CCCBuscarConfirmarMovBanc"  DTOBuscarConfirmarMovBanc 
		configurarPaginado(mipgndo, "CCCBuscarConfirmarMovBanc", "ConectorBuscarMovBancConfirmar", "es.indra.sicc.dtos.ccc.DTOBuscarConfirmarMovBanc",
			[['oidBanco', oidBanco], 
			['oidCuentaCorriente', oidCuentaCorriente], 
			['fechaMovimiento', fechaMovimiento], 
			['oidPais', pais], 
			['oidIdioma', idioma], 
			['numeroLote',numeroLote]]);
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
	function validaFecha() {
		if (get(FORMULARIO + '.FechaMov') != "") {
			var resul = EsFechaValida(get(FORMULARIO + '.FechaMov'), get(FORMULARIO + '.FechaMov'), FORMULARIO, null);
			if (resul == 1 || resul == 2) {  
				GestionarMensaje('1006', get(FORMULARIO + '.hFormatoFechaPais'));
				focaliza(FORMULARIO + '.FechaMov');
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
				// por los requisitos generales se deseleccionan todos los registros
				for (i = 0; i < listado1.datos.length; i++)
					listado1.deselecciona(i);
			} else {
				var objParams = new Object();
				objParams.numeroLote = listado1.codSeleccionados();
	            mostrarModalSICC('LPConfirmarMovBanc', 'detalle', objParams, null, null);
			} 
		}
	}

	function accionBTN_Conf_Simular(accion) {
		
		if (listado1.numSelecc() == 0) {
			// Muestra el mensaje: "Debe seleccionar al menos un elemento de la lista"
			GestionarMensaje('1021');
		} else {
			var cadenaNLote = "";
			var codigosSeleccionados = listado1.codSeleccionados();
			for (i = 0; i < codigosSeleccionados.length; i++)
				cadenaNLote += codigosSeleccionados[i] + "#";

			// vbongiov -- SiCC 20080622 -- 24/06/2008  
			if(accion.toUpperCase()=="CONFIRMAR"){ 
				deshabilitarHabilitarBoton('botonContenido','Simular','D'); 
			} 

    	    set(FORMULARIO + '.numerosLote', cadenaNLote);
			set(FORMULARIO + '.accion', accion);
			set(FORMULARIO + '.conectorAction', "LPConfirmarMovBanc");
			enviaSICC(FORMULARIO);			
		}
	}

	function simulacionCorrecta() {
		fLimpiarGenericoSICC();
		fLimpiar();
		limpiarLista(); //10016
	}

	function limpiarLista() {
		listado1.setDatos(new Array);
		ocultarLista();
	}
	
	function confirmacionCorrecta() {
		fLimpiarGenericoSICC();
		fLimpiar();
		limpiarLista();
	}
	
	function accionBTN_Marcar () {
		var codigosSeleccionados = listado1.codSeleccionados();
		
		var yaSeleccionado;
		for (i = 0; i < listado1.datos.length; i++) {
			yaSeleccionado = false;
			for (j = 0; j < codigosSeleccionados.length; j++) {
				if (listado1.datos[i][0] == codigosSeleccionados[j]) {
					yaSeleccionado = true;
					break;
				}
			}
			if (yaSeleccionado == false) {
				listado1.selecciona(i);
			}
		}
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
		document.all["ConfirmarDiv"].style.visibility='visible';
		document.all["SimularDiv"].style.visibility='visible';
		document.all["DetalleDiv"].style.visibility='visible';
		document.all["MarcarDiv"].style.visibility='visible';
		document.all["DesmarcarDiv"].style.visibility='visible';
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
		document.all["ConfirmarDiv"].style.visibility='hidden';
		document.all["SimularDiv"].style.visibility='hidden';
		document.all["DetalleDiv"].style.visibility='hidden';
		document.all["MarcarDiv"].style.visibility='hidden';
		document.all["DesmarcarDiv"].style.visibility='hidden';
	}

	function onBlurNLote(){
		if(get(FORMULARIO +'.NLote')==''){
			return;
		}
		if(esNumero(get(FORMULARIO +'.NLote')) == '-1'){
			GestionarMensaje('747');
			focaliza(FORMULARIO + '.NLote');	
		}
	}


function focalizaSiguienteBuscar(){
	if (listado1.datos.length > 0)
		document.all['Detalle'].focus();
	else
		focaliza(FORMULARIO +'.cbBanco');
}

function focalizaAnteriorBanco(){
	if (listado1.datos.length > 0)
		document.all['Desmarcar'].focus();
	else
		document.all['btnBuscar'].focus();
}
