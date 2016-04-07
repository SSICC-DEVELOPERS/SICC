    var LST_PRODUCTO_OID = 0;  
    var LST_PRODUCTO_DESC_PRODUCTO = 1; 
    var LST_PRODUCTO_PERIODO = 2;
	var LST_PRODUCTO_DESC_TIPO_OFERTA = 3;
    var LST_PRODUCTO_OID_TIPO_OFERTA = 4;
    var LST_PRODUCTO_CODIGO_VENTA = 8;
    var LST_PRODUCTO_OID_COD_VENTA = 9;
    var LST_PRODUCTO_CODIGO_PRODUCTO = 10;
    var LST_PRODUCTO_OID_PRODUCTO = 11;
    var LST_PRODUCTO_PRECIO_UNITARIO = 12;
    var LST_PRODUCTO_UNIDADES_ATENDIDAS = 13;
    var LST_PRODUCTO_UNIDADES_RECLAMADAS = 14;
    var LST_PRODUCTO_UNIDADES_A_RECLAMAR = 15;
   	var LST_PRODUCTO_OID_SOLI_POSI = 16;
	/*var LST_PRODUCTO_DESCUENTO = 11;
    var LST_PRODUCTO_OID_MONEDA = 12;
    var LST_PRODUCTO_MONEDA = 13; */

	/* ========================================================= */
	/* las siguientes constantes se utilizan para convertir a String los valores de */
	/* lstProducto en onClickAceptar, y asi poder asignar dichos valores a un VAR. */
	/* Esto es necesario en el caso de Operacion "Devuelve Envia" ya que en este caso*/
	/* es necesario mantener en memoria los datos de lstProductos seleccionados */
	/* por el usuario, cuando se pasa de la pantalla de Devuelve a la de Envia */
	var OBJLINEA_OID = 0;
	var OBJLINEA_DESC = 1;
	var OBJLINEA_PERI = 2;
	var OBJLINEA_DESC_TIPO_OFER = 3;
	var OBJLINEA_OID_TIPO_OFER = 4;
	var OBJLINEA_COD_VENT = 5;
	var OBJLINEA_OID_COD_VENT = 6;
	var OBJLINEA_COD_PROD = 7;
	var OBJLINEA_OID_PROD = 8;
	var OBJLINEA_PREC_CATA_UNIT = 9;
	var OBJLINEA_DESC_UNIT = 10;
	var OBJLINEA_PREC_FACT_UNIT = 11;
	var OBJLINEA_UNID_ATEN = 12;
	var OBJLINEA_UNID_DISP = 13;
	var OBJLINEA_UNID_A_RECL = 14;
	var OBJLINEA_PREC_TOTA = 15;
	var OBJLINEA_UNID_A_DEVO = 16;
	var OBJLINEA_OID_MOTI_DEVO = 17;
	var OBJLINEA_DESC_MOTI_DEVO = 18;
	var OBJLINEA_DESC_TIPO_MOVI = 19;
	var OBJLINEA_OID_TIPO_MOVI = 20;
	var OBJLINEA_UNID_RECL = 21;
	var OBJLINEA_IMPO_CARG = 22;
	var OBJLINEA_IMPO_ABON = 23;
	var OBJLINEA_SOLI_POSI = 24;
	/* ========================================================= */



    function onLoadPag(){

        var pais;
        var idioma;
        
		var parametros = new Array();
        var numDocumento = get("frmContenido.oidNumDocumento");
        var oidCliente = get("frmContenido.oidCliente");
		var oidOperacion = get("frmContenido.oidOperacion");

		accion("frmContenido.txtPagCat", ".disabled=true");

        pais = get('frmContenido.pais');
        idioma = get('frmContenido.idioma');

        tipoMovimiento = get('frmContenido.tipoMovimiento');
        oidTipoMovimiento = get('frmContenido.oidTipoMovimiento');

		if (get('frmContenido.errDescripcion') != '') {
			var wnd = fMostrarMensajeError(get('frmContenido.errCodigo'), get('frmContenido.errDescripcion'));
			window.close();
		}

		configurarMenuSecundario("frmContenido");

		if (get('frmContenido.indBuscar') != '1'){

			parametros = [["tamanioPagina", "10"], ["indicadorSituacion", "0"], 
                ["oidPais", pais], ["oidIdioma", idioma], ["oidNumDocumento", numDocumento], 
                ["oidCliente", oidCliente], ["oidOperacion", oidOperacion]];
			configurarPaginado(mipgndo, "RECObtenerProductosEnvia", "ConectorObtenerProductosEnviaREC", 
                "es.indra.sicc.dtos.rec.DTOBuscarEnvia", parametros);

			deshabilitaCamposBusqueda();
		}

        mostrarListas();
    }
    
    /* Autor: Marcelo J. Maidana */
    /* Fecha: 11/03/2006 */
    function deshabilitaCamposBusqueda(){
		accion("frmContenido.txtDescripcion", ".disabled=true");
		accion("frmContenido.txtCodVenta", ".disabled=true");
		accion("frmContenido.txtCodProducto", ".disabled=true");
		accion("frmContenido.txtPagCat", ".disabled=true");
		deshabilitarHabilitarBoton('botonContenido', 'btnBuscar', 'D');
    }

	function buscarIndiceCodigo(cod, arrDatos){
		for (var i = 0; i < arrDatos.length; i++){
			if (cod == arrDatos[i][0]){
				return i;
			}
		}
	}
    
	function onClickEliminar(){
        if (lstProductos.numSelecc() == 0) {
			// Muestra el mensaje: "Debe seleccionar al menos un elemento de la lista"
			GestionarMensaje('1021');
		} else {
			lstProductos.eliminarSelecc();
		}
	}
    
    /* yyy */
    /* completar esta funcion */
    function muestraLista(ultima, rowset){
			if (rowset != null && rowset.length > 0){
			for (var i = 0; i < rowset.length; i++){
				if (rowset[i][13] == undefined) {
					rowset[i][13] = ' ';
				} 
				if (rowset[i][14] == undefined) {
					rowset[i][14] = ' ';
				} 
			}
		
			return true;
		} else {
			return false;
		}
    }
    
    function mostrarListas(){
        mostrarListaResultado();
        mostrarListaProductos();
		eval (ON_RSZ); 
    }

	function mostrarListaResultado() {
		DrdEnsanchaConMargenDcho('lstResultado', 12);
	}

	function mostrarListaProductos() {
		DrdEnsanchaConMargenDcho('lstProductos', 12);
	}

    /* autor: Marcelo J. Maidana */
    /* Fecha: 09/03/2006 */
    function onClickBuscar(){


		if (!sicc_validaciones_generales('CuadroBusqueda')){
			return;
		}

		/* Oculta la columna Tipo de Oferta */
		lstResultado.alternaVerColumna(2, false, true);
		lstProductos.alternaVerColumna(2, false, true);

        var codigoProducto = get('frmContenido.txtCodProducto');
		var descripcion = get('frmContenido.txtDescripcion');
		var codigoVenta = get('frmContenido.txtCodVenta');
		var paginaCatalogo = get( 'frmContenido.txtPagCat');
		var idioma = get('frmContenido.idioma');
		var pais = get('frmContenido.pais');
		var numDocumento = get('frmContenido.oidNumDocumento');
		var operacion = get('frmContenido.oidOperacion');
        var parametros = new Array();
        
		if (codigoVenta == '' && (descripcion != '' || codigoProducto != '')) { 
        

            parametros = [ 
                ["oidPais", pais], 
                ["oidIdioma", idioma], 
                ["descripcion", descripcion],
                /* ["codigoVenta", codigoVenta], */ /* codigoVenta no se utiliza en la query */ 
                ["codigoProducto", codigoProducto], 
                /* ["paginaCatalogo", paginaCatalogo], */ /* paginaCatalogo no se utiliza en la query */
                ["numDocumento", numDocumento],
                ["operacion", operacion] ];
                    
			configurarPaginado(mipgndo, "RECObtenerProductosCodigoVentaNo", 
                "ConectorObtenerProductosCodigoVentaNoREC", 
                "es.indra.sicc.dtos.rec.DTOBuscarProductosDevuelveNoREC", parametros);

        } else if (codigoVenta != '' || paginaCatalogo != '') {


            parametros = [ 
                /* ["oidPais", pais], */ /* no se usa */
                ["oidIdioma", idioma], 
                /* ["descripcion", descripcion], */ /* no se usa */
                ["codigoVenta", codigoVenta], 
                /* ["codigoProducto", codigoProducto], */ /* no se usa */
                ["paginaCatalogo", paginaCatalogo], 
                ["numDocumento", numDocumento],
 				["operacion", operacion]];
                
			configurarPaginado(mipgndo, "RECObtenerProductosCodigoVentaSi", 
                "ConectorObtenerProductosCodigoVentaNoREC", 
                "es.indra.sicc.dtos.rec.DTOBuscarProductosDevuelveNoREC", parametros);
        } else {


            GestionarMensaje('REC009');	
        }
    }
    
    /* Autor: Marcelo J. Maidana */
    /* Fecha: 09/03/2006 */
    function onClickAnyadir(){
        var fila;
		var desc;

		lstResultado.actualizaDat();

		if (lstResultado.numSelecc() == 0) {
            GestionarMensaje('1021');
		} else {
			var seleccionados = lstResultado.codSeleccionados();
			var matDatos1 = lstResultado.datos;
			var indiceMatriz;

			for (j = 0; j < seleccionados.length; j++){
				encontrado = false;
				indiceMatriz = buscarIndiceCodigo(seleccionados[j], matDatos1);
                fila = matDatos1[indiceMatriz];
				for (k=0; k < lstProductos.datos.length; k++) {
					/*if (    fila[LST_PRODUCTO_CODIGO_PRODUCTO] == lstProductos.datos[k][LST_PRODUCTO_CODIGO_PRODUCTO]){  */
					if (comparaLinea(fila, lstProductos.datos[k])){ 
						encontrado = true;
						break;
					}
				 }
             
				if (!eval(encontrado)){
                    /* Se agrega valor vacio en la celda 15 */
                    var posi = fila[LST_PRODUCTO_UNIDADES_A_RECLAMAR]/* pero antes tomamos el valor de 15 y lo ponemos en 16*/
					fila[LST_PRODUCTO_UNIDADES_A_RECLAMAR] = '';
					fila[LST_PRODUCTO_OID_SOLI_POSI] = posi;
					lstProductos.insertar(fila);
					lstProductos.reajusta();
					lstResultado.reajusta();
				}
			}//fin for
			
			eval("lstProductos.preparaCamposDR()");
		}
    }


	function comparaLinea(linea1, linea2) {

		var longLinea = linea1.length;
		var bEqual = true;
		var campoLinea1 = null;
		var campoLinea2 = null;

		for (var i = 1; (i < longLinea) && (bEqual); i++) {
				campoLinea1 = linea1[i];
				campoLinea2 = linea2[i];
				if ( campoLinea1 != campoLinea2) {
					bEqual = false;
				}
		}

		return bEqual;
	}

    
    function onClickAceptar(){

        var objNumeroLinea = new Number(get('frmContenido.numeroLinea')); /*???????????*/
        var numeroLinea = objNumeroLinea.valueOf();										/*???????????*/
        var objLinea = new Object();
        var unidadesReclamadas = new Number();
        var precioProducto = new Number();
        var primUnidadesReclamadas = 0;
        var primPrecioProducto = 0;
    
        /* Se hacen las validaciones */
        /* validar que haya registros */
        if (lstProductos.datos.length == 0){
            /* - Mostrar el mensaje de error REC013: "Se debe añadir a la lista al menos un registro" */
            GestionarMensaje('REC013');
            return;
        }
        
        var datosProductos = lstProductos.datos;
        /* Se valida que se haya ingresado Nro. de unidades a reclamar */
        for (var i = 0; i < datosProductos.length; i++){
           if (datosProductos[i][LST_PRODUCTO_UNIDADES_A_RECLAMAR] == null ||    
                    datosProductos[i][LST_PRODUCTO_UNIDADES_A_RECLAMAR] == ''){           
                GestionarMensaje('REC026');
                return;
            }  
        }

        /* Se obtiene la descripcion internacionalizada de los campos a validar */
		/*???????????*/
        var obj = new Object();
        var desUnidAReclamar;
        for (var i = 0; i < objValidacionSICC.length; i++){
            obj = objValidacionSICC[i];
       
            if (obj.nombre == 'xxx'){
                desUnidAReclamar = obj.mostrar;
            }
        }


        /* Se valida que el valor ingresado en Nro. de unidades a reclamar sea entero y positivo */
        if (!sicc_valida_numero_LE("txtNUnidR", desUnidAReclamar, '1', '', 'Entero', "lstProductos", LST_PRODUCTO_UNIDADES_A_RECLAMAR)){
            return;
        }
        
        /*Si se pasan las validaciones, se obtienen los registros de lstProductos*/
        /*para enviarlos a la pagina de Agregar operacion.*/

        /*var objRegLineas = new Array();*/
		var objRegLineas = new Array();

		if (get('frmContenido.indicadorDevuelveProcesado') == '1'){
			objRegLineas = obtenerProductosDevuelve();
		}

        var precioCatalogo = new Number();
        var primPrecioCatalogo = 0;

        for (var j = 0; j < datosProductos.length; j++){
            objLinea = new Object();
            
			objLinea.oid = ++numeroLinea;
			objLinea.descripcion = datosProductos[j][LST_PRODUCTO_DESC_PRODUCTO];
			objLinea.periodo = datosProductos[j][LST_PRODUCTO_PERIODO];
			objLinea.descripcionTipoOferta = datosProductos[j][LST_PRODUCTO_DESC_TIPO_OFERTA];
			objLinea.oidTipoOferta = datosProductos[j][LST_PRODUCTO_OID_TIPO_OFERTA];
			objLinea.codigoVenta = datosProductos[j][LST_PRODUCTO_CODIGO_VENTA];
			objLinea.oidCodVenta = datosProductos[j][LST_PRODUCTO_OID_COD_VENTA];
			objLinea.codigoProducto = datosProductos[j][LST_PRODUCTO_CODIGO_PRODUCTO];
			objLinea.oidProducto = datosProductos[j][LST_PRODUCTO_OID_PRODUCTO];
			objLinea.precioCatalogoUnitario = datosProductos[j][LST_PRODUCTO_PRECIO_UNITARIO];
			objLinea.descuentoUnitario = '0' ; 
			objLinea.precioFacturaUnitario = datosProductos[j][LST_PRODUCTO_PRECIO_UNITARIO];
			objLinea.unidadesAtendidas = datosProductos[j][LST_PRODUCTO_UNIDADES_ATENDIDAS];
			objLinea.unidadesYaReclamadas = "";
			objLinea.unidadesDisponibles = "";
			objLinea.unidadesAReclamar = datosProductos[j][LST_PRODUCTO_UNIDADES_A_RECLAMAR];
			objLinea.precioTotal = "";        
			objLinea.unidadesADevolver = 0;
			objLinea.motivoDevolucion = "";
			objLinea.tipoMovimiento = get('frmContenido.tipoMovimiento');
			objLinea.oidTipoMovimiento = get('frmContenido.oidTipoMovimiento');
			objLinea.oidOperacion =  get('frmContenido.oidOperacion');
			objLinea.unidadesReclamadas = datosProductos[j][LST_PRODUCTO_UNIDADES_A_RECLAMAR];
			objLinea.unidadesDevueltas = 0;
			objLinea.oidPosicion = datosProductos[j][LST_PRODUCTO_OID_SOLI_POSI];
			precioUnitario = datosProductos[j][LST_PRODUCTO_PRECIO_UNITARIO];

			if (objLinea.unidadesReclamadas == '') {
				uindReclama = '0';
			} else {
				uindReclama = objLinea.unidadesReclamadas;
			}

            unidadesReclamadas = new Number(obtieneNumeroDecimal(uindReclama,get('frmContenido.hSeparadorDecimalPais')));
            precioProducto = new Number(obtieneNumeroDecimal(precioUnitario,get('frmContenido.hSeparadorDecimalPais')));

			objLinea.importeCargo = '' + unidadesReclamadas * precioProducto;
			objLinea.importeAbono = '0';

			objRegLineas[objRegLineas.length] = objLinea;
        }

		var objReturn = new Object();

		objReturn.arrayLineas  = objRegLineas;
		objReturn.controlProductosDevuelve  = new Array("");
		objReturn.oidOperacion = get('frmContenido.oidOperacion');
		objReturn.devuelveFactura = get('frmContenido.devuelveFactura');
        
		window.returnValue = objReturn;
        window.close();
    }


	/* Autor: Marcelo J. Maidana */
	/* Fecha: 29/03/2006 */
	/* Se obtienen los datos recibidos de la pantalla de Devuelve */
	/* (en el caso de que la operacion sea Envia - Devuelve) */
	function obtenerProductosDevuelve(){

		var datosListaDevuelve = get('frmContenido.datosListaDevuelve');

		var lineas = new Array();
		var lineas = datosListaDevuelve.split('|');
		var linea = '';
		var arrayLinea = new Array();
		var arrayDatos = new Array();
		var objLinea = new Object();

		for (var i = 0; i < lineas.length; i++){

			linea = lineas[i];

			arrayLinea = linea.split(',');

			objLinea = new Object();
            objLinea.oid = arrayLinea[OBJLINEA_OID];
            objLinea.descripcion = arrayLinea[OBJLINEA_DESC];
            objLinea.periodo = arrayLinea[OBJLINEA_PERI];
            objLinea.descripcionTipoOferta = arrayLinea[OBJLINEA_DESC_TIPO_OFER];
            objLinea.oidTipoOferta = arrayLinea[OBJLINEA_OID_TIPO_OFER];
            objLinea.codigoVenta = arrayLinea[OBJLINEA_COD_VENT];
            objLinea.oidCodVenta = arrayLinea[OBJLINEA_OID_COD_VENT];
            objLinea.codigoProducto = arrayLinea[OBJLINEA_COD_PROD];
            objLinea.oidProducto = arrayLinea[OBJLINEA_OID_PROD];
            objLinea.precioCatalogoUnitario = arrayLinea[OBJLINEA_PREC_CATA_UNIT];
            objLinea.descuentoUnitario = arrayLinea[OBJLINEA_DESC_UNIT];
            objLinea.precioFacturaUnitario = arrayLinea[OBJLINEA_PREC_FACT_UNIT];
            objLinea.unidadesAtendidas = arrayLinea[OBJLINEA_UNID_ATEN];
            objLinea.unidadesDisponibles = arrayLinea[OBJLINEA_UNID_DISP];
			objLinea.unidadesAReclamar = arrayLinea[OBJLINEA_UNID_A_RECL];
            objLinea.precioTotal = arrayLinea[OBJLINEA_PREC_TOTA];
            objLinea.unidadesADevolver = arrayLinea[OBJLINEA_UNID_A_DEVO];
            objLinea.oidMotivoDevolucion = arrayLinea[OBJLINEA_OID_MOTI_DEVO];
            objLinea.motivoDevolucion = arrayLinea[OBJLINEA_DESC_MOTI_DEVO];
            objLinea.tipoMovimiento = arrayLinea[OBJLINEA_DESC_TIPO_MOVI];
            objLinea.oidTipoMovimiento = arrayLinea[OBJLINEA_OID_TIPO_MOVI];
			objLinea.unidadesReclamadas = arrayLinea[OBJLINEA_UNID_RECL];
			objLinea.importeCargo = arrayLinea[OBJLINEA_IMPO_CARG];
            objLinea.importeAbono = arrayLinea[OBJLINEA_IMPO_ABON];
            objLinea.oidPosicion = arrayLinea[OBJLINEA_SOLI_POSI];

			arrayDatos[arrayDatos.length] = objLinea;
		}

		return arrayDatos;
	}



    function validar(fila){
        lstProductos.actualizaDat();
    }
    
    function validaUnidades(valor, enteros){}

	function mayusculas(nombreElemento) {
		var cadena = get('frmContenido.' + nombreElemento);
		
		if (cadena != ""){
			set('frmContenido.' + nombreElemento, cadena.toUpperCase());
		}
	}

	function fVolver(){
		window.close();
	}

	function fLimpiar(){


		if (get_visibilidad('capaContenido')){
			set('frmContenido.txtDescripcion', '');
			set('frmContenido.txtCodVenta', '');
			set('frmContenido.txtCodProducto', '');
			set('frmContenido.txtPagCat', '');
		}
	}


	function focalizaSiguienteLista(fila, tecla){

	}


	function focalizaAnteriorLista(fila, tecla){
	}


	function ontab_eliminar(){
		if (get('frmContenido.indBuscar') == '1') {
			focaliza('frmContenido.txtDescripcion');
		} else {
			focalizaBotonHTML('botonContenido', 'anadir');
		}
	}

	function onshtab_aceptar(){
		var cantFilas = lstProductos.datos.length;
		if (cantFilas > 0) {
			focaliza('frmlstProductos.txtNUnidR_' + (cantFilas-1));
		} else {
			focalizaBotonHTML('botonContenido', 'anadir');
		}
	}

	function ontab_anyadir(){
		var cantFilas = lstProductos.datos.length;
		if (cantFilas > 0) {
			focaliza('frmlstProductos.txtNUnidR_' + '0');
		} else {
			focalizaBotonHTML('botonContenido', 'aceptar');
		}
	}

	function onshtab_anyadir(){
		if (get('frmContenido.indBuscar') == '1') {
			focalizaBotonHTML('botonContenido', 'buscar');
		} else {
			focalizaBotonHTML('botonContenido', 'eliminar');		
		}
	}

	function onshtab_Descripcion(){
		focalizaBotonHTML('botonContenido', 'eliminar');		
	}