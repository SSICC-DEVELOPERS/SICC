
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
    $Id: contenido_rangos_numeracion_imprimir.js,v 1.1 2009/12/03 19:02:19 pecbazalar Exp $
    DESC
*/
var FORMULARIO = 'frmFormulario';

	function onLoadPag()   { 
		if (get(FORMULARIO + '.errDescripcion')!='') {
			var wnd = fMostrarMensajeError(get(FORMULARIO + '.errCodigo'), get(FORMULARIO + '.errDescripcion'));
		}
		//Control del foco
		focaliza(FORMULARIO + ".textCodigoCliente");
	
		configurarMenuSecundario(FORMULARIO);
	}

	function validarDatos() {
		var cond1 = false;
		var cond2 = false;
		var numeroDesde = get(FORMULARIO + '.textRangoDesdeConsolidado');
		var numeroHasta = get(FORMULARIO + '.textRangoHastaConsolidado');
		var fechaDesde = get(FORMULARIO + '.textFechaFacturacionDesde');
		var fechaHasta = get(FORMULARIO + '.textFechaFacturacionHasta');

		if ( numeroDesde != "" && numeroHasta != "")
			cond1 = true; 

		if (fechaDesde != "" && fechaHasta != "")
			cond2 = true; 

		if (!cond1 && !cond2) {
			cdos_mostrarAlert(GestionarMensaje('UIFAC0011'));
			focaliza(FORMULARIO + '.textRangoDesdeConsolidado');
			return false;
		} else {
			if (cond1 && Number(numeroDesde) > Number(numeroHasta)) {
				cdos_mostrarAlert(GestionarMensaje('UIFAC0007'));
				focaliza(FORMULARIO + '.textRangoHastaConsolidado');
				return false;
			}
			if (cond2 && EsFechaValida(fechaDesde, fechaHasta, FORMULARIO, 'N') == 3) {
				cdos_mostrarAlert(GestionarMensaje('UIFAC0005'));
				focaliza(FORMULARIO + '.textFechaFacturacionHasta');
				return false;
			}
		}
		return true;
	} 

   
	function accionBuscar() {

		if (validarDatos()) { 

			/*- idBusiness: "FACConsultarConsolidado" 
			- ConectorConsultarConsolidado 
			- DTODatosDocMensajes */

			var codCliente = get(FORMULARIO + '.textCodigoCliente');
			var tipoSolicitud = get(FORMULARIO + '.cbTipoConsolidado');
			var canal = get(FORMULARIO + '.cbCanal');
			var acceso = get(FORMULARIO + '.cbAcceso');
			var subacceso = get(FORMULARIO + '.cbSubacceso');
			var numeroConsolidadoDesde = get(FORMULARIO + '.textRangoDesdeConsolidado');
			var numeroConsolidadoHasta = get(FORMULARIO + '.textRangoHastaConsolidado');
			var fechaFacturacionDesde = get(FORMULARIO + '.textFechaFacturacionDesde');
			var fechaFacturacionHasta = get(FORMULARIO + '.textFechaFacturacionHasta');
			
			var idioma = get(FORMULARIO+'.idioma');
			var pais = get(FORMULARIO+'.pais');

	//Validamos que hay al menos uno de los campos de búsqueda relleno de datos. 
	/*if (oidBanco == "" && fechaDesde == "" && oidCuentaCorriente == "" && fechaHasta == "")
		cdos_mostrarAlert(GestionarMensaje('1389', 1));
		focaliza(FORMULARIO+'.cbBanco');*/
 
			configurarPaginado(mipgndo, "FACConsultarConsolidado", "ConectorConsultarConsolidados", "es.indra.sicc.dtos.fac.DTODatosDocMensajes",
				[['codCliente', codCliente], 
				['canal', canal], 
				['acceso', acceso], 
				['subAcceso', subacceso], 
				['numeroConsolidadoDesde', numeroConsolidadoDesde], 
				['numeroConsolidadoHasta', numeroConsolidadoHasta], 
				['oidPais', pais], 
				['oidIdioma', idioma], 
				['tipoSolicitud', tipoSolicitud], 
				['fechaFacturacionDesde', fechaFacturacionDesde], 
				['fechaFacturacionHasta', fechaFacturacionHasta]]);
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
			focaliza(FORMULARIO + ".textCodigoCliente");
		  	return false;
		 }
	}

	function fLimpiar() {
		vaciaCombo(FORMULARIO + '.cbAcceso');
		vaciaCombo(FORMULARIO + '.cbSubacceso');
		focaliza(FORMULARIO + ".textCodigoCliente");
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

	//valida que el campo sea numerico
	function validaNumConsolidado (elemento) {
         
         var valor = get(FORMULARIO + '.' + elemento);
         if (valor != "") {
                  if (ValidaCaracteres(valor,'0123456789') != 'OK') {
                           var mensaje= DrdMsgCore(143) + '0123456789';
                           if (mensaje != "OK") {
                                    cdos_mostrarAlert(mensaje);
                                    focaliza(FORMULARIO + '.'+elemento);
                                    return false;
                           }  
                  }
         }
         return true;
	}


	function deseleccionaListado() {
		for (i = 0; i < listado1.datos.length; i++)
			listado1.deselecciona(i); 
	}

	function accionBTN_Imprimir() {
		// Se ejecuta cuando el usuario pulsa el botón 'btnImprimirr' 
		if (listado1.numSelecc() == 0) {
			// Muestra el mensaje: "Debe seleccionar al menos un elemento de la lista"
			GestionarMensaje('1021');
		} else {
			var casoUso = get(FORMULARIO + '.casoUso');
			if (casoUso == "casoUsoImprimirUltimasNoticias") 
				set(FORMULARIO + '.accion', 'imprimirUltimasNoticias');
			else if (casoUso == "casoUsoImprimirCartaConsultoras")
				set(FORMULARIO + '.accion', 'imprimirCartaConsultoras');
			else if (casoUso == "casoUsoImprimirBoletaDespacho")
				set(FORMULARIO + '.accion', 'imprimirBoletaDespacho');
			else if (casoUso == "casoUsoImprimirDocumentosContables")
				set(FORMULARIO + '.accion', 'imprimirDocumentosContables');

			var cadenaCodigos = "";
			var codigosSeleccionados = listado1.codSeleccionados();
			for (i = 0; i < codigosSeleccionados.length; i++) {
				cadenaCodigos += listado1.extraeDato(codigosSeleccionados[i], 0) + ",";
			}
			set(FORMULARIO + '.codigos', cadenaCodigos);
			set(FORMULARIO + '.conectorAction', "LPRangosNumeracionReimprimir");
			enviaSICC(FORMULARIO);
		}
	}
	
	function impresionCorrecta() {
		//Se lanza una pantalla de confirmacion con un boton aceptar con el siguiente texto "Operación realizada correctamente
		cdos_mostrarAlert(GestionarMensaje('UIFAC0008'));
		focaliza(FORMULARIO + '.textCodigoCliente');
		//fLimpiarGenericoSICC();
		//fLimpiar();
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
		document.all["separaDiv"].style.visibility='visible';
		document.all["btnImprimirDiv"].style.visibility='visible';
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
		document.all["separaDiv"].style.visibility='hidden';
		document.all["btnImprimirDiv"].style.visibility='hidden';
	}

	// Función que se ejecuta al buscar el código de un cliente.
	function accionSeleccionarCliente(){
		var objParametros = new Object();
		var arrCliente = mostrarModalSICC("LPBusquedaRapidaCliente", "", objParametros, null, null);
		if (arrCliente != null && arrCliente.length > 1) {
			set(FORMULARIO + '.textCodigoCliente', arrCliente[1].toString());
		}
	}

	function codigoClienteOnBlur() {
		var codigoCliente = get(FORMULARIO+'.textCodigoCliente').toString();
	    if (codigoCliente != '') {
	          codigoCliente = codigoCliente.toUpperCase();
	          var longitudCodigoCliente = get(FORMULARIO + '.longitudCodigoCliente').toString();
	          var longitud = codigoCliente.length;
	          set(FORMULARIO + '.textCodigoCliente', rellenaCeros(codigoCliente, longitudCodigoCliente, longitud))
	    }
	}

    function canalOnChange() {
         var canal = get(FORMULARIO + '.cbCanal');
         var idioma = get(FORMULARIO + '.idioma');
         var pais = get(FORMULARIO + '.pais');
         vaciaCombo(FORMULARIO + '.cbAcceso');
         vaciaCombo(FORMULARIO + '.cbSubacceso');
         if (canal != "")
			recargaCombo(FORMULARIO + '.cbAcceso', 'SEGObtenerAccesosPorCanal', 'es.indra.sicc.dtos.seg.DTOAccesosPorCanal',  [["oidPais", pais], ["oidIdioma", idioma], ["oidCanal", canal]]);
                 
     }

     function accesoOnChange() {
		var acceso = get(FORMULARIO + '.cbAcceso');
		var idioma = get(FORMULARIO + '.idioma');
		var pais = get(FORMULARIO + '.pais');
		vaciaCombo(FORMULARIO + '.cbSubacceso');
		if (acceso != "")
			recargaCombo(FORMULARIO + '.cbSubacceso', 'SegObtenerSubaccesosPorAcceso', 'es.indra.sicc.util.DTOOID',  [["oidPais", pais], ["oidIdioma", idioma], ["oid", acceso]] );
    }


	function vaciaCombo(combo) {
		set_combo(combo,[['','']],['']);
	}



function focalizaSiguienteBuscar(){
	if (listado1.datos.length > 0)
		document.all['btnImprimir'].focus();
	else
		focaliza(FORMULARIO +'.textCodigoCliente');
}

function focalizaAnteriorCodCliente(){
	if (listado1.datos.length > 0)
		document.all['btnImprimir'].focus();
	else
		document.all['btnBuscar'].focus();
}

function onShTabBtnImprimir(){
          document.all['btnBuscar'].focus();
}
