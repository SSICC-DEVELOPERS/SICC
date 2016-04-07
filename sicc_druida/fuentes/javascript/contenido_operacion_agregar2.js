var varNoLimpiarSICC = true;
// -------------------------------------------------------------------------------------------------------------------------------------
function onLoadPag() {

   configurarMenuSecundario("frmContenido");
   fMostrarMensajeError();

   DrdEnsanchaConMargenDcho('listado1',12);
   document.all["Cplistado1"].style.visibility='visible';
   document.all["CpLin1listado1"].style.visibility='visible';
   document.all["CpLin2listado1"].style.visibility='visible';
   document.all["CpLin3listado1"].style.visibility='visible';
   document.all["CpLin4listado1"].style.visibility='visible';
   document.all["separaDiv"].style.visibility='visible';
   document.all["primera1Div"].style.visibility='visible';
   document.all["ret1Div"].style.visibility='visible';
   document.all["ava1Div"].style.visibility='visible';
   eval (ON_RSZ);  

	/* Deshabilita boton Buscar Producto  */
	deshabilitarHabilitarBoton('botonContenido', 'BuscarProd', 'D');

}

// -------------------------------------------------------------------------------------------------------------------------------------
function onChangeCodigoOperacion() {
	var opSeleccionada = get("frmContenido.cbCodOper");

	if ( opSeleccionada == "" )
	{
		/* Limpiamos el combo Tipo Operacion */
		var arrayVacio = ["",""];
		set_combo("frmContenido.cbCodTipoOper", arrayVacio);
	} else {
		/* Armamos el array del DTO */
		var array = new Array(); 
		array[0] = ['oid', opSeleccionada];
	
		/* Recargamos combo Tipo Operacion */ 
		recargaCombo('frmContenido.cbCodTipoOper',
							  'RECObtenerTiposOperacionAgregar', 
							  'es.indra.sicc.util.DTOOID', 
			                  array);	
	}
}

// -------------------------------------------------------------------------------------------------------------------------------------
function onClickAceptar() {
	if ( sicc_validaciones_generales() ) {
		var opSeleccionada = get("frmContenido.cbCodOper");
		var tipoOperacionSelecc = get("frmContenido.cbCodTipoOper");

		set("frmContenido.conectorAction", "LPPruebaSS"); 
		set("frmContenido.accion", "obtenerIndicadoresOperacion");
		set("frmContenido.oidOperacion", opSeleccionada);
		set("frmContenido.oidTipoOperacion", tipoOperacionSelecc);

		eval("frmContenido").oculto = "S";

		/* Luego de volver de la LP continua en "manejoAnulacion()" */ 
		enviaSICC("frmContenido");
	}
}

// -------------------------------------------------------------------------------------------------------------------------------------
function manejoAnulacion(params) {

		/* Params tiene el sig. formato "Ind1;Ind2;...", valores posibles: "0" o "1"
		   El orden de los indicadores es el sig. 
				- bIngresaDevuelve
				- bIngresaEnvia
				- bEnviaGeneraDevuelve
				- bDevuelveGeneraEnvia
				- bDevuelveFisicoFactura
				- bDevuelveFactura
				- bEnviaFactura
				- bAnulacion
				- bPerdida
				- sChequeoFisico
				- sPrecioEnvia, que devuelve C(atalago) o F(actura)
		*/

		/* Guardo los params en variables de formulario para posterior uso */
		var arrayParams = params.split(";");
		set("frmContenido.hIngresaDevuelve", arrayParams[0]); 
		set("frmContenido.hIngresaEnvia", arrayParams[1]);
		set("frmContenido.hEnviaGeneraDevuelve", arrayParams[2]); 
		set("frmContenido.hDevuelveGeneraEnvia", arrayParams[3]);
		set("frmContenido.hDevuelveFisicoFactura", arrayParams[4]);
		set("frmContenido.hDevuelveFactura", arrayParams[5]);
		set("frmContenido.hEnviaFactura", arrayParams[6]);
		set("frmContenido.hAnulacion", arrayParams[7]);
		set("frmContenido.hPerdida", arrayParams[8]);
		set("frmContenido.sChequeoFisico", arrayParams[9]);
		set("frmContenido.sPrecioEnvia", arrayParams[10]);

		/*alert("hAnulacion: " + arrayParams[7]);*/

		var anulacion = arrayParams[7]; 
		
		if ( anulacion == '1') {
			/* Chequea si ya existe una operacion */
			var existeOperacion = get("frmContenido.existeOperacion"); 
			if ( existeOperacion == 'true') {
				alert("No se puede ingresar una Operación de anulación al existir operaciones definidas en el Reclamo ");
				/* No se puede ingresar una Operación de anulación al existir operaciones definidas en el Reclamo */
				GestionarMensaje("REC027");
			} else { 
				/* Armo DTOOID */
				var pais = get('frmContenido.pais');
				var idioma = get('frmContenido.idioma');
				var numDocumento = get('frmContenido.oidNumDocumento');

				numDocumento = "3168";

				var array = new Array();
				array[0] = ['oid', numDocumento];
				array[1] = ['oidPais', pais];
				array[2] = ['oidIdioma', idioma];
				array[2] = ['tamanioPagina', 999999];


				//alert("array: " + array);

				/* Realizo Paginado */ 
				configurarPaginado( mipgndo, 
											 'RECBuscarProductosAnulacion', 
											 'ConectorBuscarProductosAnulacion',
											 'es.indra.sicc.cmn.negocio.comun.DTOComunes.DTOOIDPaginado',
											 array);
				/* (Continua ejecucion en "muestraLista()" )*/

			}
		
		} else {
			/* No es anulacion */ 
			deshabilitarHabilitarBoton('botonContenido', 'BuscarProd', 'A');
			var tipoOperacion = get("frmContenido.cbCodTipoOper");

			set("frmContenido.accion", "buscarCampanya");
			set("frmContenido.conectorAction", "LPPruebaSS");
			set("frmContenido.oidTipoOperacion", tipoOperacion);
			eval("frmContenido").oculto = "S";
			enviaSICC("frmContenido", null, null, "N");

		}

		/* Deshabilita capa de Datos Operacion*/
		manejoCapa("true");

}


// -------------------------------------------------------------------------------------------------------------------------------------
function esAnulacion(oidOperacion) {
	alert("datosAnulacion: " + datosAnulacion);

	var bMatch = false;
	var valor = null;

    for (var i = 0; (i < datosAnulacion.length) && (!bMatch); i++) {
        if (datosAnulacion[i][0] == oidOperacion) {
           alert("match en " + datosAnulacion[i][0]);
           valor = datosAnulacion[i][1];
		   bMatch = true;
        }
	}
	alert("valor para " + datosAnulacion[i][0] + ": " + valor);
	return valor; 
}

// -------------------------------------------------------------------------------------------------------------------------------------
function muestraLista(ultima,rowset,error) {

	/* Muestra capa de Importe */
	//alert("Muestra capa importe");
	var capa = document.getElementById("capa1");
	capa.style.visibility = 'visible';

	if ( rowset.length > 0 )
	{
		/*  TODO: Actualiza Suma de importes */ 

		/* "validarPerdida" necesita una lista con al menos 1 valor, asi que solo 
		 * se llama en ese caso */
    	setTimeout("validarPerdida()",50);
		return true;
	} else 
	{
		/*  TODO: Actualiza Suma de importes */ 
		return false;
	}
}

// -------------------------------------------------------------------------------------------------------------------------------------
function manejoCapa(estado) {
	accion("frmContenido.cbCodOper" , ".disabled=" + estado);
	accion("frmContenido.cbCodTipoOper" , ".disabled=" + estado);
	accion("frmContenido.cbMotivoBloq" , ".disabled=" + estado);

	if ( estado == 'true' ) {
		deshabilitarHabilitarBoton('botonContenido', 'btnAceptar', 'D');
	} else {
		deshabilitarHabilitarBoton('botonContenido', 'btnAceptar', 'A');
	}
	
}

// -------------------------------------------------------------------------------------------------------------------------------------
function onClickBuscarProducto() {
	/* Muestra Modal Busqueda Productos */ 
	var obj = new Object(); 
	obj.oidOperacion = get("frmContenido.cbCodOper"); 
	obj.oidTipoOperacion = get("frmContenido.cbCodTipoOper");
	obj.oidNumDocumento = get("frmContenido.oidNumDocumento");
	obj.oidCliente = get("frmContenido.oidCliente");
	obj.numeroLinea = 	obtieneNumeroLinea();
	obj.ingresaDevuelve = get("frmContenido.hIngresaDevuelve");
	obj.ingresaEnvia = get("frmContenido.hIngresaEnvia");
	obj.enviaGeneraDevuelve = get("frmContenido.hEnviaGeneraDevuelve");
	obj.devuelveGeneraEnvia = get("frmContenido.hDevuelveGeneraEnvia");
	obj.devuelveFisicoFactura = get("frmContenido.hDevuelveFisicoFactura");
	obj.devuelveFactura = get("frmContenido.hDevuelveFactura");
	obj.enviaFactura = get("frmContenido.hEnviaFactura");
	obj.precioEnvia = get("frmContenido.sPrecioEnvia");

	/* Invoca a Buscar Productos */ 
	var retorno = mostrarModalSICC("LPOperacionReclamos", "buscarProducto", obj);

	/* Maneja datos de Salida de Buscar Productos */ 
	if (retorno != null && retorno != undefined) {
		 var cantProductos = retorno.length;
		 var objLinea = null;
		 var datosToAdd = new Array();
		 var datosLista = listado1.datos;
		 var existeLinea = false;

		 for (var i = 0; i < cantProductos; i++ ) {
			 objLinea = retorno[i];
			 var filaNueva = [objLinea.numeroLinea,
								    objLinea.numeroLinea,
									objLinea.tipoMovimiento,
								    objLinea.codigoVenta,
								    objLinea.codigoProducto,
                                    objLinea.descripcionProducto,
									objLinea.unidadesAReclamar,
								    objLinea.motivoDevolucion,
									objLinea.precioUnitario,
									objLinea.importeCargo,
									objLinea.importeAbono,
									objLinea.unidadesDevueltas,
									"", // Monto Perdida,
									"", // Val_tota_paga_xxx
									objLinea.oidTipoMovimiento, // OidTipoMovimiento
									objLinea.oidTipoOferta, // OidTipoOferta
									objLinea.oidCodVenta,  // MFCA_OID_CABE
									objLinea.oidProducto, // Oid Producto
									"", // Oid MotivoDevolucion
									objLinea.descuentoUnitario, // Descuento
									objLinea.precioCatalogoUnitario];  // Precio Perdida

			  existeLinea = this.chequeaExistenciaProducto(filaNueva);
			  if (!existeLinea) {
				  datosLista[datosLista.length] = filaNueva;
			  }
		 }
		 listado1.setDatos(datosLista);
		 validarPerdida();
	}

}

// -------------------------------------------------------------------------------------------------------------------------------------
function chequeaExistenciaProducto(lineaAChequear) {
	/* Chequea linea por linea de la ListaEditable, 
	   e indica si la linea de entrada ya se ha insertado anteriormente */ 
	var datos = listado1.datos; 
	var cantFilas = datos.length; 
	var bEquality = true;

	if ( cantFilas > 0) {
		/* Si ya existen Lineas en la Lista Editable, busca que no se repita */ 
		var lineaExistente = null;
		for (var i = 0; (i < cantFilas) && (bEquality); i++ ) {
			lineaExistente = datos[i];
			bEquality = this.comparaLinea(lineaExistente, lineaAChequear); 
		}
	} else {
		/* Si no existen lineas en la Lista Editable, indica q la linea no existe */ 
		bEquality = false;
	}

	return bEquality;

}

// -------------------------------------------------------------------------------------------------------------------------------------
function comparaLinea(linea1, linea2) {
	/* Las Lineas tienen el sig. formato: 
			N° Linea (oculto) 0 
			Nº línea 
			Tipo movimiento 
			Cód. venta 
			Cód. producto 
			Descripción producto 5
			Nº unid. reclamadas 
			Motivo devolución 
			Precio producto 
			Importe cargo 
			Importe abono 10 
			Nº unid. devueltas 

			Precio Perdida 
			Monto Perdida 
			Val_tota_paga_xxx
			OidTipoMovimiento  15
			OidTipoOferta
			MFCA_OID_CABE
			Oid Producto 
			Oid MotivoDevolucion
			Descuento  20
			Precio Perdida 	
			
		Nota: No se toman en cuenta los dos campos "N° Linea" ni "Monto Perdida"	*/

	var longLinea = linea1.length;
	var bEqual = true;
	var campoLinea1 = null;
	var campoLinea2 = null;

	/* Comienzo en indice 2 (Tipo Movimiento). */
	for (var i = 2; (i < longLinea) && (bEqual); i++) {
		/* Salteo indice 13 (Monto Perdida)  */		
		if (i != 13) {
			campoLinea1 = linea1[i];
			campoLinea2 = linea2[i];
			if ( campoLinea1 != campoLinea2) {
/*				alert("Son distintos en "  + campoLinea1 + " y " + campoLinea2 );*/
				bEqual = false;
			}
		}
	}
	return bEqual;
}

// -------------------------------------------------------------------------------------------------------------------------------------
function obtieneNumeroLinea() {
	listado1.actualizaDat();
	var cantRegistros = listado1.codigos().length;
	return cantRegistros;
}


// -------------------------------------------------------------------------------------------------------------------------------------
function validarPerdida() {
	var oidOperacion = get("frmContenido.cbCodOper");
	var indPerdida = get("frmContenido.hPerdida");
/*	alert("IndPerdida: " + indPerdida);*/

	/* Solamente chequeo perdida si la operacion es de Perdida */ 
	if (indPerdida == "1" ) {

		/* Chequeo si ya existen datos de perdida para esa operacion */ 
		var arrayRetorno = existenDatosPerdida(oidOperacion);
/*		alert("arrayREtorno en existenDatosPerdida: " + arrayRetorno);*/
		if ( arrayRetorno == null ) {
			/* Si no existen datos Perdida para la operacion, levanto el caso de uso Introducir Datos Perdida */ 
			var obj = new Object();
			arrayRetorno = mostrarModalSICC("LPCapturaProcesoReclamos", "buscar", obj);
		}

		/* Chequeo que arrayRetorno no sea null (si es null, indica q se ha llamado a
		  Introducir Datos Perdida y no se ha completado correctamente la ejecucion del mismo */
		
		if ( arrayRetorno == null || arrayRetorno == undefined) {
			GestionarMensaje("REC029", null, null, null); 
			fLimpiar();
		} else {
/*			alert("listado1.datos antes de calcularmontoPerdida: " + listado1.datos);*/
			calcularMontoPerdida(arrayRetorno);
/*			alert("listado1.datos despues de calcularmontoPerdida: " + listado1.datos);
			alert("Agrego Op a Lista Perdida");*/
			agregaOpListaPerdida(oidOperacion, arrayRetorno);
		}

		/* Almacena los datos de la operacion en la Lista "listaOperacionesPerdida" */
	}

}

// -------------------------------------------------------------------------------------------------------------------------------------
function existenDatosPerdida(oidOperacion) {
/*	alert("existenDatosPerdida()");*/
	var longListaOperaciones = lstOperacionesPerdida.length;
	var arrayRetorno = null;
	var bMatch = false;

	for (var i = 0; (i < longListaOperaciones) && (!bMatch); i++)	{
		 var oidOperacionLista = lstOperacionesPerdida[i][0];
		 if (parseInt(oidOperacion, 10) == parseInt(oidOperacionLista, 10) ) {
			 arrayRetorno = new Array();
			 arrayRetorno[0] = lstOperacionesPerdida[i][1]; /* OidCliente */
			 arrayRetorno[1] = lstOperacionesPerdida[i][2]; /* OidAsumePerdida */
			 arrayRetorno[2] = lstOperacionesPerdida[i][3]; /* Precio Calculo */ 
			 arrayRetorno[3] = lstOperacionesPerdida[i][4]; /* PorcentajeRecargo */
			 arrayRetorno[4] = lstOperacionesPerdida[i][5]; /* OidProductoSeguro */
			 arrayRetorno[5] = lstOperacionesPerdida[i][6];  /* OidClienteSeguro */
			 arrayRetorno[6] = lstOperacionesPerdida[i][7];  /* ImporteSeguro */
			 bMatch = true;
		 }
	}
/*	alert("arrayRetorno: " + arrayRetorno);*/
	return arrayRetorno;
	
}

// -------------------------------------------------------------------------------------------------------------------------------------
function agregaOpListaPerdida(oidOperacion, params) {
	/* Similar a existenDatosPerdida, agrega la parametrizacion de la operacion si no 
		existe en la lista "listaOperacionesPerdida" */ 
	var longListaOperaciones = lstOperacionesPerdida.length;
	var bMatch = false;
/*	alert("Chequeo existencia operacion");*/
	/* Chequea la existencia de la operacion */
	for (var i = 0; (i < longListaOperaciones) && (!bMatch); i++)	{
		 var oidOperacionLista = lstOperacionesPerdida[i][0];
		 if (parseInt(oidOperacion, 10) == parseInt(oidOperacionLista, 10) ) {
			 bMatch = true;
		 }
	}
/*	alert("bMatch2: " + bMatch);*/
	/* No hubo coincidencias, asi q agrega la operacion junto con su parametrizacion de Perdida, 
		en la lista */
	if ( !bMatch) {
		/*var datosLista = listaOperacionesPerdida.datos;
		alert("datosLista: " + datosLista);*/
/*		alert("lstOperacionesPerdida: " + lstOperacionesPerdida);*/
		lstOperacionesPerdida[lstOperacionesPerdida.length] = [oidOperacion,
													   params[0], /* OidCliente */
													   params[1], /* OidAsumePerdida */ 
													   params[2], /* Precio Calculo */ 
													   params[3], /* Porcentaje Recargo */ 
													   params[4], /* OidProductoSeguro */ 
													   params[5], /* OidClienteSeguro */ 
													   params[6]]; /*  Importe Seguro */ 
		//listaOperacionesPerdida.setDatos(datosLista);
    }

}

// -------------------------------------------------------------------------------------------------------------------------------------
function calcularMontoPerdida(params) {
	var oidAsumeCliente = get("frmContenido.constantesAsumeCliente");
	var oidPrecioPerdida = get("frmContenido.constantesPrecioPerdida");

	var oidAsumePerdida = params[1];
	var precioCalculo = params[2];

/*	alert("precioCalculo: " + precioCalculo + "  --------- oidPrecioPerdida: " + oidPrecioPerdida);*/

	if (oidAsumePerdida == oidAsumeCliente ) {
		 var separadorMiles = get("frmContenido.hSeparadorDecimalPais");
		 var datos = listado1.datos;
		 var cantRegistros = datos.length;
		 
		 var porcentajeRecargo = obtieneNumeroDecimal(params[3], separadorMiles);

		 if ( precioCalculo  == oidPrecioPerdida ) {
			 for (var i = 0; i < cantRegistros; i++) {
				  var precioCatalogoUnit = obtieneNumeroDecimal(datos[i][20], separadorMiles);
				  var dtoUnitario = obtieneNumeroDecimal(datos[i][19], separadorMiles);
				  var nroUnidadesReclamadas = obtieneNumeroDecimal(datos[i][6], separadorMiles);
				  var montoPerdida = (precioCatalogoUnit - dtoUnitario) * nroUnidadesReclamadas * porcentajeRecargo / 100;
				  /*alert("(" + precioCatalogoUnit  + " - " + dtoUnitario + ") * " + nroUnidadesReclamadas + " * " + porcentajeRecargo + " / 100;");*/

				  datos[i][12] = montoPerdida;
			 }
		 } else {
			 for (var i = 0; i < cantRegistros; i++) {
				  var precioCatalogoUnit = obtieneNumeroDecimal(datos[i][20], separadorMiles);
				  var nroUnidadesReclamadas = obtieneNumeroDecimal(datos[i][6], separadorMiles);
				  var montoPerdida = precioCatalogoUnit * nroUnidadesReclamadas * porcentajeRecargo / 100;
				  /*alert(precioCatalogoUnit + " * " + nroUnidadesReclamadas + " * " + porcentajeRecargo + " / 100;");*/

				  datos[i][12] = montoPerdida;
			 }
		 }
	 }

}


// -------------------------------------------------------------------------------------------------------------------------------------
function cambiarCampanya(flag) {
	/* Se invoca desde la LPOperacionReclamos, a través de un asignar("VAR", "ejecutar"...); */

/*	alert("flag: " + flag);*/
	if ( flag == "1"){
/*		alert("Flag CambiarCampanya true");*/
		 /* "El tipo de operacion permite la seleccion de otra campaña, ¿desea cambiarla? "  */
        var mensaje = GestionarMensaje('REC008');
        var  cambiarCampanya = cdos_mostrarConfirm(mensaje);

		if ( cambiarCampanya ) {

			var obj = new Object();
			var tipoOperacion = get("frmContenido.cbCodTipoOper");
			var oidNumDoc = get("frmContenido.oidNumDocumento");
			var oidCliente = get("frmContenido.oidCliente"); 

/*			alert("tipoOperacion: " + tipoOperacion);
			alert("oidNumDoc:" + oidNumDoc);
			alert("oidCliente: " + oidCliente);*/

			/* Hardcodeo */ 
			oidCliente = 2382;
			/* Hardcodeo */ 

			obj.tipoOperacion = tipoOperacion;
			obj.oidNumDoc = oidNumDoc;
			obj.oidCliente = oidCliente;

			var retorno = mostrarModalSICC("LPPruebaSS", "cambiar campanya", obj);
/*			alert("retorno: " + retorno);*/
			if (retorno != undefined && retorno != null) {
				/* Asigno a oidNumDocumento el valor del Oid Doc. seleccionado en la pantalla anterior */
				var array = retorno.split("|");
				var oidNuevoDoc = array[0];
				var codNuevoDoc = array[1];
				set("frmContenido.oidNumDocumento", oidNuevoDoc);
			}
		}
	}

}

// -------------------------------------------------------------------------------------------------------------------------------------
function fGuardar() {
	var codOperacion = get("frmContenido.cbCodOper");
	var xmlLista = this.listaToXML();
	var datosPerdidaOperacion = this.existenDatosPerdida(codOperacion);
/*	alert("AAA");*/
	set("frmContenido.oidOperacion", codOperacion); 
	set("frmContenido.conectorAction", "LPPruebaSS");
	set("frmContenido.accion", "guardar operacion");
	set("frmContenido.hListaLineasOperacion", xmlLista);

	eval("frmContenido").oculto = "S";
/*	alert("enviaSICC1111");*/
	enviaSICC("frmContenido", null, null, "N");

}

// -------------------------------------------------------------------------------------------------------------------------------------
function listaToXML() {

	var arrayNombreCampos = new Array();
	arrayNombreCampos[0] = "N. línea";
	arrayNombreCampos[1] = "N. línea";
	arrayNombreCampos[2] = "Tipo movimiento";
	arrayNombreCampos[3] = "Cod. venta";
	arrayNombreCampos[4] = "Cod. producto";
	arrayNombreCampos[5] = "Descripcion producto";
	arrayNombreCampos[6] = "N. unid. reclamadas";
	arrayNombreCampos[7] = "Motivo devolucion";
	arrayNombreCampos[8] = "Precio producto";
	arrayNombreCampos[9] = "Importe cargo";
	arrayNombreCampos[10] = "Importe abono";
	arrayNombreCampos[11] = "N. unid. devueltas";
	arrayNombreCampos[12] = "Monto Perdida";
	arrayNombreCampos[13] = "Val_tota_paga";
	arrayNombreCampos[14] = "OidTipoMovimiento";
	arrayNombreCampos[15] = "OidTipoOferta";
	arrayNombreCampos[16] = "MFCA_OID_CABE";
	arrayNombreCampos[17] = "Oid Producto";
	arrayNombreCampos[18] = "Oid MotivoDevolucion";
	arrayNombreCampos[19] = "Descuento";
	arrayNombreCampos[20] = "Precio Perdida";

	var xmlDoc = "<?xml version='1.0' encoding='ISO-8859-1' standalone='no'?>";
	xmlDoc = xmlDoc + "<DOC>";
	var datos = listado1.datos;
	var cantFilas = datos.length;
	/* Recorre las filas */ 
	for (var i = 0; i < cantFilas; i++) {
		var linea = datos[i]; 
		xmlDoc = xmlDoc + "<ROW>";
		/* Recorre los campos dentro de la fila */
		var cantCampos = linea.length;
		for (var j = 0; j < cantCampos; j++ ) {
			var campo = linea[j]; 
			xmlDoc = xmlDoc + "<CAMPO nombre='" + arrayNombreCampos[i] + "'>" + campo + "</CAMPO>";
		}
		xmlDoc = xmlDoc + "</ROW>"
	}
	xmlDoc = xmlDoc + "</DOC>";

	return xmlDoc; 
}

// -------------------------------------------------------------------------------------------------------------------------------------
function fLimpiar() {
	listado1.setDatos( new Array() );
	set("frmContenido.cbCodOper", new Array("") );
	set("frmContenido.cbMotivoBloq", new Array("") );
	this.onChangeCodigoOperacion();
	this.manejoCapa("false"); /* Habilita la capa. */

}

// -------------------------------------------------------------------------------------------------------------------------------------
function funcionRetorno(sVarExisteAnulacion, sChequeoFisico, sDatosBloqueo, sDatosLista) {
	var objRetorno = new Object(); 

	/* Manejo de existencia de operacin de Anulacion */ 
    objRetorno.sExisteOperacionAnulacion = sVarExisteAnulacion;

	/* Datos de Operacion / Tipo Operacion seleccionada */ 
	var oidOperacion = get("frmContenido.cbCodOper"); 
	var oidTipoOperacion = get("frmContenido.cbCodTipoOper");
	var oidMotivoBloqueo = get("frmContenido.cbMotivoBloq");
	var descOperacion = this.obtieneDescOperacion(oidOperacion);

	objRetorno.oidOpSeleccionada = oidOperacion;
	objRetorno.oidTipoOpSeleccionada = oidTipoOperacion;
	objRetorno.oidMotivoBloqueo = oidMotivoBloqueo;
	objRetorno.descRetorno = descOperacion;

	/* Chequeo Fisico */ 
	obj.chequeoFisico = sChequeoFisico; 

	/* lstOperacionesPerdida */
	var arrayOperaciones = this.armaObjetoOperacionesPerdida();
	objRetorno.operacionesPerdida = arrayOperaciones;

	/* Datos Bloqueo */ 
	var objDatosBloqueo = new Object();
	var datosBloqueo = sDatosBloqueo.split(";");

	objDatosBloqueo.oidMotivoBloqueo = datosBloqueo[0];
	objDatosBloqueo.oidEstadoOperacion = datosBloqueo[1];
	objDatosBloqueo.tipoBloqueo = datosBloqueo[2];

	objRetorno.datosBloqueo = objDatosBloqueo; 

	returnValue = objRetorno;
	window.close();

	
}

// -------------------------------------------------------------------------------------------------------------------------------------
function armaObjetoOperacionesPerdida() {
	/* Retorna un Object con */ 
	var cantOperaciones = lstOperacionesPerdida.length;
	var arrayOperaciones = new Array();

	var objOperacion = null;
	for (var i = 0; i < cantOperaciones; i++ ) {
		objOperacion = new Object(); 

		objOperacion.oidCliente = lstOperacionesPerdida[i][0];
		objOperacion.oidAsumePerdida = lstOperacionesPerdida[i][1];
		objOperacion.precioCalculo = lstOperacionesPerdida[i][2];
		objOperacion.porcentajeRecargo = lstOperacionesPerdida[i][3];
		objOperacion.oidProductoSeguro = lstOperacionesPerdida[i][4];
		objOperacion.oidClienteSeguro = lstOperacionesPerdida[i][5];
		objOperacion.importeSeguro = lstOperacionesPerdida[i][6]; 

		arrayOperaciones[i] = objOperacion;
	}
	return arrayOperaciones;
}

// -------------------------------------------------------------------------------------------------------------------------------------
function obtieneDescOperacion(oidOperacion) {
	var cantOps = lsOperacion.length;
	var bMatch = false;
	var descRetorno = "";
	for (var i = 0; (i < cantOps) && (!bMatch); i++ ) {
		var oidOperacionArray = lsOperacion[i][0];
		if (parseInt(oidOperacionArray, 10)  == parseInt(oidOperacion, 10)  ) {
			descRetorno = lsOperacion[i][2];
			bMatch = true;
		}	
	}
	return descRetorno;
}
