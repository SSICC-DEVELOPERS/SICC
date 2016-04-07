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
    $Id: contenido_producto_no_buscar.js,v 1.1 2009/12/03 19:01:55 pecbazalar Exp $
    DESC
	mamontie inc 21616 11/12/05
*/
var FORMULARIO = 'frmContenido';
var campoRequeridoMostrar = "";	//label internacionalizado de la columna unidades a reclamar
var filasSeleccionadas = new Array();	//se utiliza para mantener la seleccion de filas tras modificar detalle
var arrayProductos = null;
var numeroLinea = 0;
//var busquedaPrimera = true;
var filaValidandose = -1;
var aDatosComboMotivoDevolucion;

	function onLoadPag() {

		if (get(FORMULARIO + '.errDescripcion')!='') {
			var wnd = fMostrarMensajeError(get(FORMULARIO + '.errCodigo'), get(FORMULARIO + '.errDescripcion'));
			window.close();
		}

		configurarMenuSecundario(FORMULARIO);

		var visible = get(FORMULARIO + '.visible');

		//alert('visible ' + visible)

		if (visible == "DevuelveSi") {
			mostrarLista(2);
			btnProxy(5,0);
			document.all['Aceptar2'].focus();
		} else if (visible == "DevuelveNo"){
			mostrarLista1();
			focaliza(FORMULARIO + '.txtDescripcion');
		} else if (visible == "Envia") {
			mostrarLista(3);
			setTimeout("focalizaPrimeroListado()", 5);
			varNoLimpiarSICC = true;
			setCampoRequeridoMostrar();
		} else {
			GestionarMensaje('UIREC015');	
			window.close();
		}
		if (get(FORMULARIO + '.numeroLinea') != "") numeroLinea = Number(get(FORMULARIO + '.numeroLinea').toString());

		cargarComboMotivosDevolucion();
	}

	//Autor: Marcelo J. Maidana
	//Fecha: 12/12/2005
	//Creado por incidencia 21603.
	//Carga combo de lista editable (Motivo devolucion).
	function cargarComboMotivosDevolucion(){
		var aOidsMotivoDevolucion;
		var aDescsMotivoDevolucion;

		aOidsMotivoDevolucion = get('frmContenido.hOidsMotivoDevolucion').split(',');
		aDescsMotivoDevolucion = get('frmContenido.hDescsMotivoDevolucion').split(',');
		aDatosComboMotivoDevolucion = new Array();
		aDatosComboMotivoDevolucion[0] = new Array('', '');

		for (var i = 0; i < aOidsMotivoDevolucion.length; i++){
			aDatosComboMotivoDevolucion[i + 1] = new Array(aOidsMotivoDevolucion[i], aDescsMotivoDevolucion[i]);
		}
//mamontie inc 21616
		if (get(FORMULARIO + '.visible') == "DevuelveSi") {
			
			listado2.tiposCol[19][2] = aDatosComboMotivoDevolucion;			
			listado2.repinta();
		}else{
			listado1.tiposCol[14][2] = aDatosComboMotivoDevolucion;
			listado1.repinta();
		}
		return true;

	}

	//Autor: Marcelo J. Maidana
	//Fecha: 12/12/2005
	//Creado por incidencia 21603.
	//Obtiene la descripcion correspondiente al valor seleccionado en el combo Motivo devolucion.
	function obtenerDescMotivoDev(cod){
		var desc = '';

		for (var i = 0; i < aDatosComboMotivoDevolucion.length; i++){
			if (aDatosComboMotivoDevolucion[i][0] == cod){
				desc = aDatosComboMotivoDevolucion[i][1];
				break;
			}
		}
		
		return desc;
	}




	function onClickBuscar() {
		/*- Si (codigoProducto <> "" OR descripcion <> "") AND codigoVenta == "" 
		- Llamar a LPOperacionReclamo con: 
		- accion = "buscar codigoVenta No" 
		- oidNumDocumento recibido de pantalla llamante 
		
		- Si codigoVenta <> "" OR paginaCatalogo <> "" 
		- Llamar a LPOperacionReclamo con: 
		- accion = "buscar codigoVenta Si" 
		- oidNumDocumento recibido de pantalla llamante*/


			var codigoProducto = get(FORMULARIO + '.txtCodProducto');
			var descripcion = get(FORMULARIO + '.txtDescripcion');
			var codigoVenta = get(FORMULARIO + '.txtCodVenta');
			var paginaCatalogo = get(FORMULARIO + '.txtPagCat');
			var idioma = get(FORMULARIO+'.idioma');
			var pais = get(FORMULARIO + '.pais');
			var numDocumento = get(FORMULARIO + '.oidNumDocumento');
			//prueba
			//numDocumento = '1022';
			//prueba
			var operacion = get(FORMULARIO + '.oidOperacion');

			if (codigoVenta == '' && (descripcion != '' || codigoProducto != '')) { 
				var parametros = [ ["oidPais", pais], ["oidIdioma", idioma], ["descripcion", descripcion],
                      	["codigoVenta", codigoVenta], ["codigoProducto", codigoProducto], 
                      	["paginaCatalogo", paginaCatalogo], ["numDocumento", numDocumento],
 						["operacion", operacion] ];
				configurarPaginado(mipgndo, "RECObtenerProductosCodigoVentaNo", "ConectorObtenerProductosCodigoVentaNoREC", "es.indra.sicc.dtos.rec.DTOBuscarProductosDevuelveNoREC", parametros);
			} else if (codigoVenta != '' || paginaCatalogo != '') {
				var parametros = [ ["oidPais", pais], ["oidIdioma", idioma], ["descripcion", descripcion],
                      	["codigoVenta", codigoVenta], ["codigoProducto", codigoProducto], 
                      	["paginaCatalogo", paginaCatalogo], ["numDocumento", numDocumento],
 						["operacion", operacion]];
				configurarPaginado(mipgndo, "RECObtenerProductosCodigoVentaSi", "ConectorObtenerProductosCodigoVentaNoREC", "es.indra.sicc.dtos.rec.DTOBuscarProductosDevuelveNoREC", parametros);
			} else {
				GestionarMensaje('REC009');	
			}
	}

	function aceptarDevuelveNo() {

		listadoAux.actualizaDat();
		//No se comprueba número 15253
		arrayProductos = new Array();
		for (i = 0; i < listadoAux.datos.length; i++) {
			var arrayFila = new Array();
			arrayFila[arrayFila.length] = ++numeroLinea;	//numLinea + 1 (inicializado a 0)
			arrayFila[arrayFila.length] = numeroLinea;	//numLinea + 1 (inicializado a 0)
			arrayFila[arrayFila.length] = get(FORMULARIO + '.tipoMovimiento') + "";	//variable oculta tipoMovimiento  
			arrayFila[arrayFila.length] = get(FORMULARIO + '.oidTipoMovimiento') + "";	//ConstantesREC.TIPO_MOVIMIENTO_ENVIA 
			arrayFila[arrayFila.length] = listadoAux.datos[i][4];	//3  codigoVenta del registro seleccionado
			arrayFila[arrayFila.length] = listadoAux.datos[i][5];	//4  codigoProducto del registro seleccionado 
			arrayFila[arrayFila.length] = listadoAux.datos[i][1];	//1  descripcionProducto del registro seleccionadoo
			arrayFila[arrayFila.length] = listadoAux.datos[i][12];	//11 unidadesAReclamar del registro seleccionado


			//Inc. 21660
			if (get('frmContenido.ingresaDevuelve') == '1'){
				arrayFila[arrayFila.length] = listadoAux.datos[i][15];	//14 motivo de devolución del registro seleccionado
				arrayFila[arrayFila.length] = listadoAux.datos[i][16];	//15oidMotivoDevolucion = //BELC300014565
			} else if (get('frmContenido.ingresaEnvia') == '1'){
				arrayFila[arrayFila.length] = null;	//14 motivo de devolución del registro seleccionado
				arrayFila[arrayFila.length] = null;	//15oidMotivoDevolucion = //BELC300014565
			}
			//Fin Inc. 21660


			if (get(FORMULARIO + '.pagina') == "2")	
				arrayFila[arrayFila.length] = "0";	//precio 0
			else
				arrayFila[arrayFila.length] = listadoAux.datos[i][6];	//5precio del registro seleccionado

			if (get(FORMULARIO + '.pagina') == "2")	
				arrayFila[arrayFila.length] = "0";	//precio 0
			else
				arrayFila[arrayFila.length] = importeProducto(listadoAux.datos[i][6], listadoAux.datos[i][12]);	//importeCargo = precio * unidadesReclamadas o listado1.datos[i][8]
						
			arrayFila[arrayFila.length] = "0";	//importeAbono = 0			
			

			//Inc. 21660
			if (get('frmContenido.ingresaDevuelve') == '1'){
				arrayFila[arrayFila.length] = listadoAux.datos[i][14];	//13unidadesDevueltas
			} else if (get('frmContenido.ingresaEnvia') == '1'){
				arrayFila[arrayFila.length] = 0;	//13unidadesDevueltas
			}
			//Fin Inc. 21660


			arrayFila[arrayFila.length] = listadoAux.datos[i][7];	//6descuento
			arrayFila[arrayFila.length] = listadoAux.datos[i][8];	//7OIDMONEDA
			arrayFila[arrayFila.length] = listadoAux.datos[i][9];	//8 DESC MONEDA
			arrayFila[arrayFila.length] = listadoAux.datos[i][0];	//1 OID PRODUCTO
			arrayFila[arrayFila.length] = listadoAux.datos[i][10];	//9 OID COD VENTA
			arrayFila[arrayFila.length] = listadoAux.datos[i][11];	//10 OID TIPO OFERTA
			
			arrayProductos[arrayProductos.length] = arrayFila;
		}
		if (get(FORMULARIO + '.cerrar') == "N") {
			addFilasSeleccionadas(arrayProductos);
			set(FORMULARIO + '.numeroLinea', numeroLinea);
			set(FORMULARIO + '.accion', 'comprobar');
			set(FORMULARIO + '.conectorAction', "LPOperacionReclamos");
			enviaSICC(FORMULARIO);
		} else {
			preparaArrayADevolver(arrayProductos);
			window.close();
		}
	}


	function importeProducto(valor1, valor2, separadorDec, separadorMil) {
        if ( (valor1 != "" && valor2 != "") && (typeof(valor1) != 'undefined' && typeof(valor2) != 'undefined') ) {
			var precioTotal = redondea(obtieneNumeroDecimal(valor1, get(FORMULARIO + '.hid_SeparadorDecimales')) * obtieneNumeroDecimal(valor2, get(FORMULARIO + '.hid_SeparadorDecimales')), get(FORMULARIO + '.hid_NumeroDecimales'));
			return formateaImporte(precioTotal.toString(), get(FORMULARIO + '.hid_SeparadorMiles'), get(FORMULARIO + '.hid_SeparadorDecimales'));	//precio total
		}
		return "";
	}


	// incidencia 22273
	function aceptarDevuelveSi() {
		alert('aceptarDevuelveSi')
		// en este método se ha hecho lo siguiente. Como puede aparecer varias veces repetido un mismo OID de producto,
		// tenemos el problema de que el metodo codSeleccionados() si ve un OID repetido no lo devuelve. Luego 
		// si seleccionaramos por ejemplo 2 registros con OID 23, este metodo solo devolveria uno de ellos.
		// Lo que se ha hecho es cambiar el metodo DAOCapturaProcesoReclamos.obtenerProductosDevuelveSi (tambien se
		// ha cambiado el conector ConectorObtenerProductosDevuelveSiREC) para que la primera columna sea el numero 
		// de la fila, y usar este numero como OID y poder determinar que registros se han seleccionado.
		// Despues se crea una matriz igual a la recibida pero eliminando la primera columna, que contiene estos numeros
		// de fila. Y es esta matriz la que se procesa.
		
		var seleccionados = listado2.codSeleccionados();
		listado2.actualizaDat();

		var arrayIndicesSeleccionados = new Array();
		for (j = 0; j < seleccionados.length; j++) {
			for (var i = 0; i < listado2.datos.length; i++) {
				if (seleccionados[j] == listado2.datos[i][0]) {
					arrayIndicesSeleccionados[arrayIndicesSeleccionados.length] = i;
				}
			}
		}
		
		// datosIniciales es un array de arrays cuya primera columna contiene un número de fila
		// datosFinales es un array en el que se ha eliminado la primera columna
				
		var datosIniciales = listado2.datos;
		
		// ahora se crea una matriz datosFinales que tendrá los mismos datos que datosIniciales pero
		// eliminando la primera columna
		var datosFinales = new Array();
		for (i=0; i < datosIniciales.length; i++) {
			unaFila = new Array();
			for (j=1; j < datosIniciales[0].length; j++) {
				unaFila[unaFila.length] = datosIniciales[i][j];
			}
			datosFinales[datosFinales.length] = unaFila;
		}
		
		
		// se asigna la matriz con los datos finales a la lista editable.
		// se hace asi porque los indices de las columnas no contemplan la columna adicional
		// que llega desde negocio
		listado2.setDatos(datosFinales);
		
		arrayProductos = new Array();
		var indice;
		for (i = 0; i < arrayIndicesSeleccionados.length; i++) {
			var arrayFila = new Array();
				
			indice = arrayIndicesSeleccionados[i];
			
			arrayFila[arrayFila.length] = ++numeroLinea;	//numLinea + 1 (inicializado a 0)
			arrayFila[arrayFila.length] = numeroLinea;	//numLinea + 1 (inicializado a 0)
			arrayFila[arrayFila.length] = get(FORMULARIO + '.tipoMovimiento').toString();	
alert('listado2.datos[indice][0]  ' + listado2.datos[indice][0]);
alert('listado2.datos[indice][1]  ' + listado2.datos[indice][1]);
alert('listado2.datos[indice][2]  ' + listado2.datos[indice][2]);
alert('listado2.datos[indice][3]  ' + listado2.datos[indice][3]);
alert('listado2.datos[indice][5]  ' + listado2.datos[indice][4]);
alert('listado2.datos[indice][4]  ' + listado2.datos[indice][5]);
alert('listado2.datos[indice][6]  ' + listado2.datos[indice][6]);
alert('listado2.datos[indice][7]  ' + listado2.datos[indice][7]);
alert('listado2.datos[indice][8]  ' + listado2.datos[indice][8]);
alert('listado2.datos[indice][9]  ' + listado2.datos[indice][9]);
alert('listado2.datos[indice][10]  ' + listado2.datos[indice][10]);
alert('listado2.datos[indice][11]  ' + listado2.datos[indice][11]);
alert('listado2.datos[indice][12]  ' + listado2.datos[indice][12]);
alert('listado2.datos[indice][13]  ' + listado2.datos[indice][13]);
alert('listado2.datos[indice][14]  ' + listado2.datos[indice][14]);
alert('motivo de devolución 15 ' + listado2.datos[indice][15]);
alert('unidadesReclamadas 16 ' + listado2.datos[indice][16]);
alert('listado2.datos[indice][17]  ' + listado2.datos[indice][17]);
alert('listado2.datos[indice][18]  ' + listado2.datos[indice][18]);


			arrayFila[arrayFila.length] = listado2.datos[indice][6];	//5codigoVenta del registro seleccionado
			arrayFila[arrayFila.length] = listado2.datos[indice][7];	//6codigoProducto del registro seleccionado 
			arrayFila[arrayFila.length] = listado2.datos[indice][0];	//descripcionProducto del registro seleccionadoo

			if (typeof(listado2.datos[indice][17]) == 'undefined' || listado2.datos[indice][17] == '')
			{
				arrayFila[arrayFila.length] = 0;
			}else{
				arrayFila[arrayFila.length] = listado2.datos[indice][17];	//unidadesReclamadas del registro seleccionado
			}
			if (typeof(listado2.datos[indice][19]) == 'undefined' || listado2.datos[indice][19] == '')
			{
				arrayFila[arrayFila.length] = '';
			}else{
				//arrayFila[arrayFila.length] = listado2.datos[i][19];	//motivo de devolución del registro seleccionado
				
				arrayFila[arrayFila.length] = seteaDescripcion(listado2.datos[indice][19]);
			}

		    if (typeof(listado2.datos[indice][19]) == 'undefined' || listado2.datos[indice][19] == '')
			{
				arrayFila[arrayFila.length] = '';
			}else{
				arrayFila[arrayFila.length] = listado2.datos[indice][19]; //	//oidMotivoDevolucion del registro seleccionado
			}
								
			// incidencia 22272
			arrayFila[arrayFila.length] = listado2.datos[indice][8];	//precio del registro seleccionado (precio catálogo unitario)
			arrayFila[arrayFila.length] = "0";	//importeCargo = 0
			arrayFila[arrayFila.length] = importeProducto(listado2.datos[indice][8], listado2.datos[indice][12]);	//importeAbono = precio * unidadesReclamadas (precio catálogo unitario)


			if (typeof(listado2.datos[indice][18]) == 'undefined' || listado2.datos[indice][18] == '')
			{
				arrayFila[arrayFila.length] = 0;
			}else{
				arrayFila[arrayFila.length] = listado2.datos[indice][18];	//unidadesDevueltas del registro seleccionado
			}
			
			arrayFila[arrayFila.length] = listado2.datos[indice][9];	//descuento
			arrayFila[arrayFila.length] = listado2.datos[indice][14];	//OIDMONEDA
			arrayFila[arrayFila.length] = listado2.datos[indice][15];	//MONEDA

			arrayFila[arrayFila.length] = listado2.datos[indice][0];	//OID PRODUCTO
			arrayFila[arrayFila.length] = listado2.datos[indice][16];	//OID COD VENTA
			arrayFila[arrayFila.length] = listado2.datos[indice][4];	//OID TIPO OFERTA
				
			arrayProductos[arrayProductos.length] = arrayFila;
		}
		
		if (get(FORMULARIO + '.cerrar') == "N") {
			set(FORMULARIO + '.numeroLinea', numeroLinea);
			addFilasSeleccionadas(arrayProductos);
			set(FORMULARIO + '.accion', 'comprobar');
			set(FORMULARIO + '.conectorAction', "LPOperacionReclamos");
			enviaSICC(FORMULARIO);
		} else {
			preparaArrayADevolver(arrayProductos);
			window.close();
		}		
	}


	function seteaDescripcion(codigo){

	   var aOidsMotivoDevolucion = get('frmContenido.hOidsMotivoDevolucion').split(',');
	   var aDescsMotivoDevolucion = get('frmContenido.hDescsMotivoDevolucion').split(',');
	   var descripcionCb =""
	   for (var i = 0; i < aOidsMotivoDevolucion.length; i++){
		 
		  if(aOidsMotivoDevolucion[i]==codigo){
			 descripcionCb =  aDescsMotivoDevolucion[i];
		     break; 
		  }
        }
	   return descripcionCb;
     }





	function aceptarEnvia() {
		listado3.actualizaDat();
		if (validaNUnidadesRequerido())	{		
			var seleccionados = listado3.selecc;
			listado3.actualizaDat();
	
			arrayProductos = new Array();
			for (i = 0; i < seleccionados.length; i++) {
				if (seleccionados[i] == '1') {
					var arrayFila = new Array();
					arrayFila[arrayFila.length] = ++numeroLinea;	//numLinea + 1 (inicializado a 0)
					arrayFila[arrayFila.length] = numeroLinea;	//numLinea + 1 (inicializado a 0)
					arrayFila[arrayFila.length] = get(FORMULARIO + '.tipoMovimiento');	
					arrayFila[arrayFila.length] = get(FORMULARIO + '.oidTipoMovimiento') + "";	//ConstantesREC.TIPO_MOVIMIENTO_ENVIA
					arrayFila[arrayFila.length] = listado3.datos[i][5];	//codigoVenta del registro seleccionado
					arrayFila[arrayFila.length] = listado3.datos[i][6];	//codigoProducto del registro seleccionado 
					arrayFila[arrayFila.length] = listado3.datos[i][1];	//descripcionProducto del registro seleccionadoo
					arrayFila[arrayFila.length] = listado3.datos[i][14];	//unidadesAReclamar del registro seleccionado

					arrayFila[arrayFila.length] = "";	//motivo de devolución del registro seleccionado 
					arrayFila[arrayFila.length] = "";	//oidMotivoDevolucion del registro seleccionado

					arrayFila[arrayFila.length] = listado3.datos[i][7];	//precio del registro seleccionado
					arrayFila[arrayFila.length] = importeProducto(listado3.datos[i][7], listado3.datos[i][14]);	//importeCargo = precio * unidadesReclamadas
					arrayFila[arrayFila.length] = "0";	//importeAbono = 0
					arrayFila[arrayFila.length] = "0";	//unidadesDevueltas = 0
					arrayFila[arrayFila.length] = listado3.datos[i][10];	//descuento
					arrayFila[arrayFila.length] = listado3.datos[i][11];	//OID MONEDA
					arrayFila[arrayFila.length] = listado3.datos[i][12];	//MONEDA
			arrayFila[arrayFila.length] = listado3.datos[i][0];	//OID PRODUCTO
			arrayFila[arrayFila.length] = listado3.datos[i][13];	//OID COD VENTA
			arrayFila[arrayFila.length] = listado3.datos[i][4];	//OID TIPO OFERTA
					arrayProductos[arrayProductos.length] = arrayFila;
				}
			}
			if (get(FORMULARIO + '.cerrar') == "N") {
				addFilasSeleccionadas(arrayProductos);
				set(FORMULARIO + '.numeroLinea', numeroLinea);
				set(FORMULARIO + '.accion', 'comprobar');
				set(FORMULARIO + '.conectorAction', "LPOperacionReclamos");
				enviaSICC(FORMULARIO);
			} else {
				preparaArrayADevolver(arrayProductos);
				window.close();
			}
		}
	}

function onSelectedDevuelveNo(FILAEVENTO) {//listado1
	/*-> Si el campo del registro seleccionado unidadesAreclamar = ""{ 
	- mostrar ventana modal y emergente PgDetalleBuscarProducto} 
	
	 Se bloquea la ejecución hasta el cierre de la ventana emergente  
	
	-> se rellenan los campos unidadesAReclamar, unidadesDevueltas , motivoDevolucion del registro seleccionado con los valores devueltos por la pantalla emergente: 
	- unidadesAReclamar = uAReclamar 
	- unidadesDevueltas = uDevueltas 
	- motivoDevolucion = valor seleccionado en cbMotivoDevolucion 
	- oidMotivoDevolucion = oid del valor seleccionado en cbMotivoDevolucion 
	- precioTotal = uAReclamar * precioUnitario*/

	listado1.actualizaDat(); //Actualiza el array 'datos'
	var item6 = eval('listado1.datos[FILAEVENTO][11]');
	if (typeof(item6) == 'undefined' || item6 == '') {
		guardaSeleccion(listado1.selecc);
		var objParams = new Object();
		//objParams.codigoCliente = '';
		objParams.unidadesReclamadas = '';
		objParams.unidadesDisponibles = '';
		var datos = mostrarModalSICC('LPOperacionReclamos', 'detalle producto', objParams, null, null);	
		//var datos = mostrarModalSICC('GTFLPOR', 'detalle producto', objParams, null, null);	//prueba ñññ descomentar anterior
        //datos = ['1', '1', 'AA1', '1'];
		if (typeof(datos) != 'undefined') {
			listado1.datos[FILAEVENTO][11]= datos[0];	//unidades a reclamar
			listado1.datos[FILAEVENTO][13]= datos[1];	//unidades devueltas
			listado1.datos[FILAEVENTO][14]= datos[2];	//motivo de devolucion
			listado1.datos[FILAEVENTO][15]= datos[3]; //oid motivo de devolucion
			listado1.datos[FILAEVENTO][12] = importeProducto(listado1.datos[FILAEVENTO][5], datos[0]);	//precio total
			listado1.reajusta();
			recuperaSeleccion(listado1);
		} else listado1.deselecciona(FILAEVENTO);
	}
}

function onSelectedDevuelveSi(FILAEVENTO) {	//listado2
	/*Documentation
	-> Si el campo del registro seleccionado unidadesAreclamar = ""{ 
	- mostrar ventana modal y emergente PgDetalleBuscarProducto} 
	
	 Se bloquea la ejecución hasta el cierre de la ventana emergente  
	
	-> se rellenan los campos unidadesAReclamar, unidadesDevueltas , motivoDevolucion del registro seleccionado con los valores devueltos por la pantalla emergente: 
	- unidadesAReclamar = uAReclamar 
	- unidadesDevueltas = uDevueltas 
	- motivoDevolucion = valor seleccionado en cbMotivoDevolucion 
	- oidMotivoDevolucion = oid del valor seleccionado en cbMotivoDevolucion*/
	
	listado2.actualizaDat(); //Actualiza el array 'datos'
	var item13 = eval('listado2.datos[FILAEVENTO][16]');

	if (typeof(item13) == 'undefined' || item13 == '') {
		guardaSeleccion(listado2.selecc);
		var objParams = new Object();
		objParams.codigoCliente = '';
		
		objParams.unidadesReclamadas = listado2.datos[FILAEVENTO][11];
		objParams.unidadesRecibidas = listado2.datos[FILAEVENTO][12];
		var datos = mostrarModalSICC('LPOperacionReclamos', 'detalle producto', objParams, null, null);
		//var datos = mostrarModalSICC('GTFLPOR', 'detalle producto', objParams, null, null);	//prueba ñññ descomentar anterior
        //datos = ['1', '1', 'AA1', '1'];
		if (typeof(datos) != 'undefined') {
			alert('datos[0] ' + datos[0]);
			alert('datos[1] ' + datos[1]);
			alert('datos[2] ' + datos[2]);
			alert('datos[3] ' + datos[3]);
			listado2.datos[FILAEVENTO][14]= datos[0];	// 16 unidades a reclamar
			listado2.datos[FILAEVENTO][15]= datos[1];	//17 unidades devueltas
			listado2.datos[FILAEVENTO][17]= datos[2];	//18 motivo de devolucion
			listado2.datos[FILAEVENTO][18]= datos[3]; //19 oid motivo de devolucion
			listado2.reajusta();
			recuperaSeleccion(listado2);
		} else  listado2.deselecciona(FILAEVENTO);
	}
}

	function guardaSeleccion(seleccion) {
		filasSeleccionadas = new Array();
		for (i = 0; i < seleccion.length; i++) {
			if (seleccion[i] == '1') filasSeleccionadas[filasSeleccionadas.length] = '1';
			else filasSeleccionadas[filasSeleccionadas.length] = '0';
		}
	}

	function recuperaSeleccion(listado) {
		for (i = 0; i < filasSeleccionadas.length; i++)
			if (filasSeleccionadas[i] == '1')
				listado.selecciona(i);
	}

	function muestraLista( ultima, rowset){
			//busquedaPrimera = false;
			//mostrarLista1();
         	//Control del foco
			focaliza(FORMULARIO + ".txtDescripcion");
			cargarComboMotivosDevolucion();
			return true;
	}

	
	//para mostrar las listas listado2 y listado3
	function mostrarLista(valor) {
		DrdEnsanchaConMargenDcho('listado' + valor,12);
		document.all["Cplistado" + valor].style.visibility='visible';
		document.all["CpLin1listado" + valor].style.visibility='visible';
		document.all["CpLin2listado" + valor].style.visibility='visible';
		document.all["CpLin3listado" + valor].style.visibility='visible';
		document.all["CpLin4listado" + valor].style.visibility='visible';
		document.all["Aceptar" + valor + "Div"].style.visibility='visible';
		eval (ON_RSZ); 
		if(valor==2){
			cargarComboMotivosDevolucion();
		}
	}
	
	function mostrarLista1() {

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
		document.all["Anadir1Div"].style.visibility='visible';

		/* Agregado por Inc. 21660 */
		if (get('frmContenido.ingresaEnvia') == '1'){
			listado1.alternaVerColumna(13, false, false);
			listado1.alternaVerColumna(14, false, false);
		}
		/* Fin Agregado por Inc. 21660 */

		DrdEnsanchaConMargenDcho('listadoAux',12);
		document.all["CplistadoAux"].style.visibility='visible';
		document.all["CpLin1listadoAux"].style.visibility='visible';
		document.all["CpLin2listadoAux"].style.visibility='visible';
		document.all["CpLin3listadoAux"].style.visibility='visible';
		document.all["CpLin4listadoAux"].style.visibility='visible';
		document.all["AceptarDiv"].style.visibility='visible';
		document.all["EliminarDiv"].style.visibility='visible';
		
		/* Agregado por Inc. 21660 */
		if (get('frmContenido.ingresaEnvia') == '1'){
			listadoAux.alternaVerColumna(13, false, false);
			listadoAux.alternaVerColumna(14, false, false);
		}
		/* Fin Agregado por Inc. 21660 */

		eval (ON_RSZ);
	}

	function ocultarLista1() {
		document.all["Cplistado1"].style.visibility='hidden';
		document.all["CpLin1listado1"].style.visibility='hidden';
		document.all["CpLin2listado1" ].style.visibility='hidden';
		document.all["CpLin3listado1"].style.visibility='hidden';
		document.all["CpLin4listado1"].style.visibility='hidden';
		document.all["primera1Div"].style.visibility='hidden';
		document.all["ret1Div"].style.visibility='hidden';
		document.all["ava1Div"].style.visibility='hidden';
		document.all["separaDiv"].style.visibility='hidden';
		document.all["Anadir1Div"].style.visibility='hidden';

		document.all["CplistadoAux"].style.visibility='visible';
		document.all["CpLin1listadoAux"].style.visibility='visible';
		document.all["CpLin2listadoAux"].style.visibility='visible';
		document.all["CpLin3listadoAux"].style.visibility='visible';
		document.all["CpLin4listadoAux"].style.visibility='visible';
		document.all["AceptarDiv"].style.visibility='visible';
		document.all["EliminarDiv"].style.visibility='visible';

	}

	
	function focalizaAnteriorDescripcion() {
		//if (!busquedaPrimera)
			document.all['Eliminar'].focus();
		//else
			//document.all['btnBuscar'].focus();
	}

function focalizaSiguienteBuscar(){
	if (listado1.datos.length > 0)
		document.all['Aceptar'].focus();
	else
		focaliza(FORMULARIO + '.txtDescripcion');
}



	function focalizaPrimeroListado() {
		listado3.actualizaDat();
		var datos = listado3.datos;
		if (listado3.datos.length > 0) {
			listado3.preparaCamposDR();
			focaliza('frmlistado3.txtNUnidR_0', '');
		} else {
			document.all['Aceptar3'].focus();
		}
	}

	function focalizaUltimoListado() {
		listado3.actualizaDat();
		var datos = listado3.datos;
		if (listado3.datos.length > 0) {
			var numeroFila = datos.length - 1;
			listado3.preparaCamposDR();
			focaliza('frmlistado3.txtNUnidR_'+ numeroFila, '');
		} else {
			document.all['Aceptar3'].focus();
		}
	}
         
                  
	function focalizaSiguienteLista(FILAEVENTO, TECLAEVENTO) {
		if (FILAEVENTO == listado3.datos.length-1 && TECLAEVENTO == 9) {
			if (ValidaForm(FORMULARIO, false)) {
				//document.body.focus();
				setTimeout("document.all['Aceptar3'].focus();tr=document.body.createTextRange();tr.execCommand('Unselect');", 5);
			} 
		}
	}


	function focalizaAnteriorLista(FILAEVENTO, TECLAEVENTO) {
		if (FILAEVENTO == 0 && TECLAEVENTO == 9) {
			if (ValidaForm(FORMULARIO, false)) {
				//document.body.focus();
				setTimeout("document.all['Aceptar3'].focus();tr=document.body.createTextRange();tr.execCommand('Unselect');", 5);
			} 
		}
	}
	
	function validar(fila) {
		if (filaValidandose == -1 || filaValidandose == fila) {
			if (ValidaForm(FORMULARIO, true) == true)  filaValidandose = -1;
			else filaValidandose = fila;
		}
	}

	//Funcion que se ejecuta cuando se valida el formulario en la caja de texto de la caja
	function validaUnidades(valor,enteros) {
                  
		//Validamos que no inserte en un formato incorrecto
		if(valor != "") {
			var msg = ValidaCaracteres(valor,'0123456789' + get(FORMULARIO + '.hid_SeparadorMiles'));
			if (msg != "OK") {
				return DrdMsgCore(143) + get(FORMULARIO + '.hid_SeparadorMiles') + '0123456789';
			}
			return ValidaMilesDecimales(valor, enteros, 0, get(FORMULARIO + '.hid_SeparadorMiles'), get(FORMULARIO + '.hid_SeparadorDecimales'), 0);
		}
	}

//valida entero si el campo es modificable y no vacío 
function validaEntero(nombreElemento) {
		if (get(FORMULARIO + '.' + nombreElemento).toString() != "")
			//Como no nos interesa validar el número de dígitos que tiene el entero ponemos uno suficientemente grande.
			if (ValidaInt(get(FORMULARIO + '.' + nombreElemento).toString(), 10000, 0) != "OK") {
				GestionarMensaje('747', null, null, null);
				focaliza(FORMULARIO + '.' + nombreElemento);
				return false;
			} 
}

function mayusculas(nombreElemento) {
	var cadena = get(FORMULARIO + '.' + nombreElemento);
	if (cadena != "")
		set(FORMULARIO + '.' + nombreElemento, cadena.toUpperCase());
}

	function fLimpiar() {
		//lista editable si
		var visible = get(FORMULARIO + '.visible');
		if (visible == "Envia") {
			listado3.load();
			listado3.reajusta();
		}
	}


function validaNUnidadesRequerido() {
	for (i = 0; i < listado3.selecc.length; i++) 
		if (listado3.selecc[i] == 1) //seleccionado
			if (!listado_valida_requerido(listado3.datos[i][14], i))
				return false;
	return true;
}

function setCampoRequeridoMostrar() {
	campoRequeridoMostrar = objValidacionSICC[0].mostrar;
}

function listado_valida_requerido(valor, fila) {
	if (valor + "" == "") {
		cdos_mostrarAlert(GestionarMensaje("1534", campoRequeridoMostrar));
		focaliza('frmlistado3.txtNUnidR_' + fila, '');;
		return false;    
	}
    return true;
}

	function fVolver() {
		window.close();
	}

	function addFilasSeleccionadas (arrayFilasSeleccionadas) {
		var arrayFilas = new Array();	//almacén temporal de los valores concatenados de cada fila seleccionada 
		for (i = 0; i < arrayFilasSeleccionadas.length; i++)
			arrayFilas[arrayFilas.length] = arrayFilasSeleccionadas[i].join('@');
		if (get(FORMULARIO + '.arrayList') != "")
			set(FORMULARIO + '.arrayList', get(FORMULARIO + '.arrayList') + '#' + arrayFilas.join('#'));
		else
			set(FORMULARIO + '.arrayList', arrayFilas.join('#'));
	}

	function preparaArrayADevolver(arrayFilasSeleccionadas) {
		var cadena = get(FORMULARIO + '.arrayList');
		var arrayFinal = new Array();
		if (cadena != "") {
			var filas = cadena.split('#');
			for (i = 0; i < filas.length; i++)
				arrayFinal[arrayFinal.length] = filas[i].split('@');
		}
		for (i = 0; i < arrayFilasSeleccionadas.length; i++)
			arrayFinal[arrayFinal.length] = arrayFilasSeleccionadas[i];
		window.returnValue = arrayFinal;
	}
	

	function buscarIndiceCodigo(cod, arrDatos){
		for (var i = 0; i < arrDatos.length; i++){
			if (cod == arrDatos[i][0]){
				return i;
			}
		}
	}

	function onCLickAdd() {

		var fila;
		var desc;

		listado1.actualizaDat();

		if (listado1.numSelecc() == 0) {
			// Muestra el mensaje: "Debe seleccionar al menos un elemento de la lista"
			GestionarMensaje('1021');
		} else {
			var seleccionados = listado1.codSeleccionados();
			var matDatos1 = listado1.datos;
			var indiceMatriz;

			for (j = 0; j < seleccionados.length; j++){
				encontrado = false;
				indiceMatriz = buscarIndiceCodigo(seleccionados[j], matDatos1);
				for (k=0; k < listadoAux.datos.length; k++) {
					if (matDatos1[indiceMatriz][4] == listadoAux.datos[k][4]){
						encontrado = true;
						break;
					}
				 }
             
				if (!eval(encontrado)){
					
					fila = listado1.datos[indiceMatriz];
					//Se reemplaza el id de motivo devolucion por su descripcion.
					//y se asigna el oid a la columna oculta.
					//fila[15] = obtenerDescMotivoDev(fila[15]);

					desc = obtenerDescMotivoDev(fila[15]);
					fila[16] = fila[15];
					fila[15] = desc;

					listadoAux.insertar(fila);
					listadoAux.reajusta();
					listado1.reajusta();
					break;
				}
			}//fin for
		}
	}




	function onClickEliminar() {
		if (listadoAux.numSelecc() == 0) {
			// Muestra el mensaje: "Debe seleccionar al menos un elemento de la lista"
			GestionarMensaje('1021');
		} else {
			listadoAux.eliminarSelecc();
		}
	}
