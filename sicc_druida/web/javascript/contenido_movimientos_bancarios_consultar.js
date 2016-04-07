
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
    $Id: contenido_movimientos_bancarios_consultar.js,v 1.1 2009/12/03 19:01:34 pecbazalar Exp $
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

	var oidBanco = get(FORMULARIO + '.cbBanco');
	var fechaMov = get(FORMULARIO + '.FechaMov');
	var checkMov = get(FORMULARIO + '.CheckMov');
	var saldoInicial = get(FORMULARIO + '.SaldoInicial');
	var oidCuentaCorriente = get(FORMULARIO + '.cbCCC');
	var tipoTransaccion = get(FORMULARIO + '.cbTipoTransaccion');
	var codCliente = get(FORMULARIO + '.CodCliente');
	
	var idioma = get(FORMULARIO+'.idioma');
	var pais = get(FORMULARIO+'.pais');
	//Validamos que hay al menos uno de los campos de búsqueda relleno de datos. 
	var criterios = 0;
	if (oidBanco != "") criterios++;
	if (tipoTransaccion != "") criterios++;
	if (oidCuentaCorriente != "") criterios++;
	if (fechaMov != "") criterios++;
	if (codCliente != "") criterios++;
	if (checkMov != "") criterios++;
	if (saldoInicial != "") criterios++;

	//if (checkMov == "N") checkMov="0";
	//if (checkMov == "S") checkMov="1";



	if ( criterios < 2) {
		//cdos_mostrarAlert(GestionarMensaje('1389', 2));
		GestionarMensaje('1389', 2);
		focaliza(FORMULARIO+'.cbBanco');
	} else { 
		//Invocamos el "subsystema:paginacion" con IdBusiness="CCCBuscarConfirmarMovBanc"  DTOBuscarConfirmarMovBanc 
		configurarPaginado(mipgndo, "CCCBuscarMovBancConsultar", "ConectorBuscarMovBancConsultar", "es.indra.sicc.dtos.ccc.DTOBuscarMovBancConsultar",
			[['oidBanco', oidBanco], 
			['oidCuentaCorriente', oidCuentaCorriente], 
			['fechaMovimiento', fechaMov], 
			['oidPais', pais], 
			['codigoCliente', codCliente], 
			['tipoTransaccion', tipoTransaccion], 
			['movActualizado', checkMov], 
			['saldoInicial', saldoInicial],
			['oidIdioma', idioma]]);
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

	// moficaciones: 27/06/2005 - inc BELC300017626 - pperanzola
	function fLimpiar() {
		vaciaCombo(FORMULARIO + '.cbCCC');
		set(FORMULARIO + '.CheckMov', '');
		set(FORMULARIO + '.SaldoInicial', '');
		listado1.limpia(true);
		ocultarLista();
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
				var codigos = listado1.codSeleccionados();				
				//alert("Posicion 0: " + listado1.extraeDato(codigos[0], 0));
				objParams.oid = listado1.extraeDato(codigos[0], 0); //campo oculto de la fila seleccionada, se pagina por numero de linea
	            mostrarModalSICC('LPConsultarMovBanc', 'detalle', objParams, null, null);
			} 
		}
	}

	function deseleccionaListado() {
		for (i = 0; i < listado1.datos.length; i++)
			listado1.deselecciona(i); 
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
		document.all['Detalle'].focus();
	else
		document.all['btnBuscar'].focus();
}

// Función que se ejecuta al buscar el código de un cliente.
function accionSeleccionarCliente(){
	var objParametros = new Object();
	var arrCliente = mostrarModalSICC("LPBusquedaRapidaCliente", "", objParametros, null, null);
	if (arrCliente != null && arrCliente.length > 1) {
		set(FORMULARIO + '.CodCliente', arrCliente[1].toString());
	}
}

// Función que se ejecuta en el OnBlur del campo codigoCliente.
function codigoClienteOnBlur() {
         var codigoCliente = get(FORMULARIO + '.CodCliente').toString();

         if (codigoCliente != '') {
                  var longitudCodigoCliente = get(FORMULARIO + '.longitudCodigoCliente').toString();
                  var longitud = codigoCliente.length;
                  set(FORMULARIO + '.CodCliente', rellenaCeros(codigoCliente, longitudCodigoCliente, longitud))
         }
}
