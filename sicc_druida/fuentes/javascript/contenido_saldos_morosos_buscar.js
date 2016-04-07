var FORMULARIO = 'frmCapturarCupon';

function onLoadPag() {
	
	// Fatlaba todo esto
	 var errDescripcion = get(FORMULARIO +'.errDescripcion');
	 if (errDescripcion !='') {		
		var errCodigo = get(FORMULARIO+'.errCodigo');
		var wnd = fMostrarMensajeError(errCodigo, errDescripcion);
	 }
	    DrdEnsanchaConMargenDcho('listado1',12);	
	      document.all["Cplistado1"].style.visibility='';
	     document.all["CpLin1listado1"].style.visibility='';
	     document.all["CpLin2listado1"].style.visibility='';
	     document.all["CpLin3listado1"].style.visibility='';
	     document.all["CpLin4listado1"].style.visibility='';
	     document.all["primera1Div"].style.visibility='';
	     document.all["ret1Div"].style.visibility='';
	     document.all["ava1Div"].style.visibility='';
	     document.all["separaDiv"].style.visibility='';
	     document.all["AplicarIncobrablesDiv"].style.visibility='';
	     document.all["AnadirCuotasDiv"].style.visibility='';
	    eval (ON_RSZ);  
	
	focaliza(FORMULARIO + ".textFechaImputacionProceso");	
    configurarMenuSecundario(FORMULARIO);

}

function marcarLista(){
	for (var i=0;i<listado1.datos.length;i++){
		//listado1.selecciona(i);
		if(!listado1.selecc[i]) {
			listado1.selecciona(i);
		}
	}
}


// Función que se ejecuta al buscar el código de un cliente en cliente desde.
function seleccionarClienteDesde(){
	var objParametros = new Object();
	var arrCliente = mostrarModalSICC("LPBusquedaRapidaCliente", "", objParametros, null, null);
	if (typeof(arrCliente)!='undefined') set(FORMULARIO+'.textCodClienteD', arrCliente[1].toString());
}

// Función que se ejecuta al buscar el código de un cliente en cliente hasta.
function seleccionarClienteHasta(){
	var objParametros = new Object();
	var arrCliente = mostrarModalSICC("LPBusquedaRapidaCliente", "", objParametros, null, null);
	if (typeof(arrCliente)!='undefined') set(FORMULARIO+'.textCodClienteH', arrCliente[1].toString());
}

// Función para validar que importe desde tiene un formato correcto.
function importeDesdeOnBlur(){
	var importeDesde = get(FORMULARIO+'.textImporteD');

	if (importeDesde != '' && validaImporte('textImporteD',18)) {
		// Doy el formato correcto al importe.
		var separadorMiles = get(FORMULARIO + '.hid_SeparadorMiles');
		var separadorDecimales = get(FORMULARIO + '.hid_SeparadorDecimales');
		var numeroDecimales = get(FORMULARIO + '.hid_NumeroDecimales');

		var numImporte = obtieneNumeroDecimal(importeDesde, separadorDecimales);

		set(FORMULARIO+'.textImporteD', formateaImporte(numImporte, separadorMiles, separadorDecimales));
	}
}

// Función para validar que importe hasta tiene un formato correcto.
function importeHastaOnBlur(){
	var importeHasta = get(FORMULARIO+'.textImporteH');

	if (importeHasta != '' && validaImporte('textImporteH',18)) {
		// Doy el formato correcto al importe.
		var separadorMiles = get(FORMULARIO + '.hid_SeparadorMiles');
		var separadorDecimales = get(FORMULARIO + '.hid_SeparadorDecimales');
		var numeroDecimales = get(FORMULARIO + '.hid_NumeroDecimales');

		var numImporte = obtieneNumeroDecimal(importeHasta, separadorDecimales);

		set(FORMULARIO+'.textImporteH', formateaImporte(numImporte, separadorMiles, separadorDecimales));
	}
}

// Función que valida si un importe es válido, longitudMax debería ser el max del TEXT o CTEXTO.
function validaImporte(nombreElemento, longitudMax) {

	var valor = get(FORMULARIO+'.'+nombreElemento);
	var numeroDecimales = get(FORMULARIO + '.hid_NumeroDecimales');
	var separadorMiles = get(FORMULARIO + '.hid_SeparadorMiles');
	var separadorDecimales = get(FORMULARIO + '.hid_SeparadorDecimales');
	var numeroEnteros = longitudMax -  numeroDecimales -1;

	//Agregado por cvalenzu - V-CCC-033 - 20/12/2006
	//Debe permitir valores negativos
	if(valor.substring(0,1)=="-") valor = valor.substring(1,valor.toString().length);
	//FIN - Agregado por cvalenzu - V-CCC-033 - 20/12/2006

	var resultado = ValidaMilesDecimales(valor, numeroEnteros, numeroDecimales, separadorMiles, separadorDecimales,0);
	if (resultado != 'OK') {
		set(FORMULARIO+'.'+nombreElemento,'');
		focaliza(FORMULARIO+'.'+nombreElemento);
		return false;
	}
	return true;
}

// Función para validar las fechas.
function validaFecha(nombreElemento) {
	var fecha = get(FORMULARIO+'.'+nombreElemento);

	if (fecha != '') {
		if (!EsFechaValida_SICC(fecha, FORMULARIO)) {
			// Muestra el mensaje: La fecha es incorrecta
			GestionarMensaje('947',FORMULARIO+'.'+nombreElemento);
			focaliza(FORMULARIO+'.'+nombreElemento);
			return false;
		}
	}
}


 
//Se comprueba que, al menos, se han seleccionado dos criterios de búsqueda de 
//entre los disponibles: codigoClienteDesde, codigoClienteHasta, fechaDocDesde, 
//fechaDocHasta, fechaVtoDesde, fechaVtoHasta, periodoDesde, periodoHasta, 
//ImporteDesde, ImporteHasta. 
//En caso contrario se mostrará un mensaje de error: "Se debe seleccionar, al menos, dos criterios de búsqueda". Código Error: UICCC008. 




// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function accionBuscar(){
	var numDigitosCodigoCliente = get(FORMULARIO + '.numDigitosCodigoCliente');
	var clienteDesde = get(FORMULARIO + '.textCodClienteD');
	var clienteHasta = get(FORMULARIO + '.textCodClienteH');
	var canal = get(FORMULARIO+'.cbCanal');
	var empresa = get(FORMULARIO+'.cbEmpresa');
	var tipoCargoAbono = get(FORMULARIO+'.cbTipoAbono');
	var fechaDocumentoDesde = (get(FORMULARIO+'.textFechaDocD')=="")?"":obtenerFormatoFecha(get(FORMULARIO+'.textFechaDocD'));
	var fechaDocumentoHasta = (get(FORMULARIO+'.textFechaDocH')=="")?"":obtenerFormatoFecha(get(FORMULARIO+'.textFechaDocH'));
	var fechaVencimientoDesde = (get(FORMULARIO+'.textFechaVenD')=="")?"":obtenerFormatoFecha(get(FORMULARIO+'.textFechaVenD'));
	var fechaVencimientoHasta = (get(FORMULARIO+'.textFechaVenH')=="")?"":obtenerFormatoFecha(get(FORMULARIO+'.textFechaVenH'));

	if (numDigitosCodigoCliente!=''){
		if ((clienteDesde!="")&&(clienteDesde.toString().length > numDigitosCodigoCliente)){
			cdos_mostrarAlert(GestionarMensaje('1136'));
			focaliza(FORMULARIO + '.textCodClienteD');
			return false;
		}
		if ((clienteHasta!="")&&(clienteHasta.toString().length > numDigitosCodigoCliente)){
			cdos_mostrarAlert(GestionarMensaje('1136'));
			focaliza(FORMULARIO + '.textCodClienteH');
			return false;
		}
	}
	if (!sicc_validaciones_generales()) return false;
	//if (ValidaForm(FORMULARIO,true)){
		var acceso = get(FORMULARIO+'.cbAcceso');
		var empresa = get(FORMULARIO+'.cbEmpresa');
		var subacceso = get(FORMULARIO+'.cbSubacceso');
		var fechaImputacion = (get(FORMULARIO+'.textFechaImputacionProceso')=="")?"":obtenerFormatoFecha(get(FORMULARIO+'.textFechaImputacionProceso'));
		var referenciaExterna = get(FORMULARIO+'.textReferenciaExterna');
		var periodoDesde = get(FORMULARIO+'.cbPeriododD');	//18252
		var periodoHasta = get(FORMULARIO+'.cbPeriodoH');	//18252
		var importeDesde = get(FORMULARIO+'.textImporteD');
		var importeHasta = get(FORMULARIO+'.textImporteH');
		var observaciones = get(FORMULARIO+'.textObservaciones');
		var oidIdioma = get(FORMULARIO+'.hid_OidIdioma');
		var oidPais = get(FORMULARIO+'.hid_OidPais');
	
		// Guardo en los campos ocultos los valores del criterio de búsqueda.
		set(FORMULARIO + '.hid_numDigitosCodigoCliente',numDigitosCodigoCliente);
		set(FORMULARIO+'.hid_cbCanal',canal);
		set(FORMULARIO+'.hid_cbEmpresa',empresa);
		set(FORMULARIO+'.hid_cbAcceso',acceso);
		set(FORMULARIO+'.hid_cbSubacceso',subacceso);
		set(FORMULARIO+'.hid_cbTipoAbono',tipoCargoAbono);
		set(FORMULARIO+'.hid_textFechaImputacionProceso',fechaImputacion);
		set(FORMULARIO+'.hid_textReferenciaExterna',referenciaExterna);
		set(FORMULARIO+'.hid_textCodClienteD',clienteDesde);
		set(FORMULARIO+'.hid_textCodClienteH',clienteHasta);
		set(FORMULARIO+'.hid_textFechaDocD',fechaDocumentoDesde);
		set(FORMULARIO+'.hid_textFechaDocH',fechaDocumentoHasta);
		set(FORMULARIO+'.hid_textPeriodoD', get(FORMULARIO+'.cbPeriododD', 'T').toString());
		set(FORMULARIO+'.hid_textPeriodoH',get(FORMULARIO+'.cbPeriodoH', 'T').toString());
		set(FORMULARIO+'.hid_textImporteD',importeDesde);
		set(FORMULARIO+'.hid_textImporteH',importeHasta);
		set(FORMULARIO+'.hid_textObservaciones',observaciones);
		set(FORMULARIO+'.hid_textFechaVenD',fechaVencimientoDesde);
		set(FORMULARIO+'.hid_textFechaVenH',fechaVencimientoHasta);


		//Llamamos a configurarPaginado pasandole los siguientes parametros: el objeto paginado de la lista resultados, CCCBuscarSaldosMorosos, ConectorBuscarSaldosMorosos, DTOBuscarSaldosMorosos y un array con los parametros del dto obteniendo los valores de los campos correspondientes de la pantalla. 		 
		/*configurarPaginado(mipgndo,"CCCBuscarSaldosMorosos","ConectorBuscarSaldosMorosos","es.indra.sicc.dtos.ccc.DTOBuscarSaldosMorosos",
		 [["acceso", acceso], ["canal", canal],["empresa", empresa], ["subacceso", subacceso], ["tipoCargoAbono", tipoCargoAbono], ["fechaImputacion", fechaImputacion],
		 ["referenciaExterna", referenciaExterna], ["clienteDesde", clienteDesde], ["clienteHasta", clienteHasta], ["fechaDocumentoDesde", fechaDocumentoDesde], ["fechaDocumentoHasta", fechaDocumentoHasta],
		 ["periodoDesde", periodoDesde], ["periodoHasta", periodoHasta], ["importeDesde", importeDesde], ["importeHasta", importeHasta], ["observaciones", observaciones],
		 ["fechaVencimientoDesde", fechaVencimientoDesde], ["fechaVencimientoHasta", fechaVencimientoHasta], ["oidPais",oidPais],["oidIdioma",oidIdioma]] );  */

		configurarPaginado(mipgndo,"CCCBuscarSaldosMorosos","ConectorBuscarSaldosMorosos","es.indra.sicc.dtos.ccc.DTOBuscarSaldosMorosos",
		 [["acceso", acceso], ["canal", canal],["empresa", empresa], ["subacceso", subacceso], ["clienteDesde", clienteDesde], ["clienteHasta", clienteHasta], ["fechaDocumentoDesde", fechaDocumentoDesde], ["fechaDocumentoHasta", fechaDocumentoHasta],
		 ["oidPeriodoDesde", periodoDesde], ["oidPeriodoHasta", periodoHasta], ["importeDesde", obtenerNumero(importeDesde)], ["importeHasta", obtenerNumero(importeHasta)], ["observaciones", observaciones],
		 ["fechaVencimientoDesde", fechaVencimientoDesde], ["fechaVencimientoHasta", fechaVencimientoHasta], ["oidPais",oidPais],["oidIdioma",oidIdioma]] );  

		//Las filas del array devuelto cuyo campo bloqueado="1" se mostrarán 
		//deshabilitadas. 

		//Llamamos a recalcular(); 	
		//recalcular(); --> Se llama en el muestralista para no tener problema en si los datos estan listos o no
	//}
}


// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// by ssantana, 4/8/2005, inc. 19032
function retornaLPOK()
{
 	 // Incrementa en 1 el valor actual de Numero de Lote. 
     var numLote = get(FORMULARIO + ".hid_textNumLote");
	 numLote = parseInt(numLote, 10) + 1;

	 txt_to("lblNLoteActual", numLote);
	 set(FORMULARIO + ".hid_textNumLote", numLote);

     // Ahora si invoco a this.accionBuscar();
     accionBuscar(); 
}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function obtenerNumero(numero){
	var separadorDecimales =get(FORMULARIO + '.hid_SeparadorDecimales');
	var separadorMiles = get(FORMULARIO + '.hid_SeparadorMiles');
	var result = "";
	var arr  = new Array();
	var parteEntera  = new Array();
	var aux = "";
	
	arr =  numero.split(separadorDecimales);
	parteEntera =  arr[0].split(separadorMiles);
	for (var i=0; i < parteEntera.length; i++){
		aux += parteEntera[i];
	}

	result = aux 
	if (arr.length == 2)
		result += "." + arr[1];

	return result;
}



function fLimpiar() {
	//Limpiar el formulario
	vaciaCombo(FORMULARIO + '.cbAcceso');
	vaciaCombo(FORMULARIO + '.cbPeriododD');
	vaciaCombo(FORMULARIO + '.cbPeriodoH');
	vaciaCombo(FORMULARIO + '.cbSubacceso');
	set(FORMULARIO+'.cbCanal','');
	set(FORMULARIO+'.idioma','');
	set(FORMULARIO+'.cbSubacceso','');
	set(FORMULARIO+'.cbTipoAbono','');
	set(FORMULARIO+'.textFechaImputacionProceso','');
	set(FORMULARIO+'.textReferenciaExterna','');
	set(FORMULARIO+'.textCodClienteD','');
	set(FORMULARIO+'.textCodClienteH','');
	set(FORMULARIO+'.textFechaDocD','');
	set(FORMULARIO+'.textFechaDocH','');
	set(FORMULARIO+'.textPeriodoD','');
	set(FORMULARIO+'.textPeriodoH','');
	set(FORMULARIO+'.textImporteD','');
	set(FORMULARIO+'.textImporteH','');
	set(FORMULARIO+'.textObservaciones','');
	set(FORMULARIO+'.textFechaVenD','');
	set(FORMULARIO+'.textFechaVenH','');
	//set(FORMULARIO+'.cbMarca','');
	set(FORMULARIO+'.cbEmpresa','');
}

function btnBuscarOnTab(){
	if (get_visibilidad("capaLista")) {
		document.all['AplicarIncobrables'].focus();
	}else{
		focaliza(FORMULARIO + ".textFechaImputacionProceso");
	}
}

function AnadirCuotasOnTab(){
	focaliza(FORMULARIO + ".textFechaImputacionProceso");		
}

function AnadirCuotasOnshTab(){
	document.all['AplicarIncobrables'].focus();
}

function fecImputacionPOnShTab(){
	document.body.focus();
	if (get_visibilidad("capaLista")) {
		document.all['AnadirCuotas'].focus();
	}else{
		document.all['btnBuscar'].focus();
	}	
}

function AplicarIncobrablesOnShTab(){
	document.all['btnBuscar'].focus();
}

function AplicarIncobrablesOnTab(){
	document.all['AnadirCuotas'].focus();
}


function canalOnChange() {
	//recargamos el de accesos a partir de las listas ocultas
	var canal =get(FORMULARIO + '.cbCanal');
	vaciaCombo(FORMULARIO + '.cbAcceso');
	vaciaCombo(FORMULARIO + '.cbSubacceso');
	vaciaCombo(FORMULARIO + '.cbPeriododD');
	vaciaCombo(FORMULARIO + '.cbPeriodoH');
	if (canal != "") {
		var accesos = new Array();
		accesos[0] = ['', ''];
		//cargar acceso del array datosAcceso
		if (typeof(datosAccesos) != 'undefined') {
			for (i=0; i < datosAccesos.length; i++) {
				if (datosAccesos[i][2] ==  canal) {
					accesos [accesos.length] = [datosAccesos[i][0], datosAccesos[i][1]];
				}
			}
		}
		set_combo(FORMULARIO + '.cbAcceso', accesos, ['']);
		// Incidencia: BELC300008804 FALTAN COSAS
		//recargaCombo('frmCapturarCupon.cbPeriododD','SEGObtenerPeriodosPorCanal','es.indra.sicc.util.DTOOID',[['oidPais', get(FORMULARIO+'.hid_OidPais')], ['oidIdioma', get(FORMULARIO+'.hid_OidIdioma')], ['oid', canal]]);
		//18252
 		asignar([["COMBO", 'frmCapturarCupon.cbPeriododD', "ConectorDruidaTransactionQuery", 'dtoSalida.resultado_ROWSET', formarCadenaDT('SEGObtenerPeriodosPorCanal', 'es.indra.sicc.util.DTOOID', [['oidPais', get(FORMULARIO+'.hid_OidPais')], ['oidIdioma', get(FORMULARIO+'.hid_OidIdioma')], ['oid', canal]]), 'cargaPeriodos(datos)']],"","");
	}
}

	function incluyeOpcionVacia(datos) {
		var datos2=new Array();
		datos2[0]=["",""];//La opción vacía
		for (var i=0;i<datos.length;i++)
		datos2[datos2.length]=datos[i];
		return datos2;
	}

	function cargaPeriodos(datos) {
		set_combo('frmCapturarCupon.cbPeriododD', incluyeOpcionVacia(datos));
		set_combo('frmCapturarCupon.cbPeriodoH', incluyeOpcionVacia(datos));
	}


function accesoOnChange() {
	//recargamos el de subaccesos a partir de las listas ocultas
	var acceso =get(FORMULARIO + '.cbAcceso');
	vaciaCombo(FORMULARIO + '.cbSubacceso');
	if (acceso != "") {
		//cargar subacceso del array datosSubacceso
		var subaccesos = new Array();
		subaccesos[0] = ['', ''];
		//cargar acceso del array datosAcceso
		if (typeof(datosSubaccesos) != 'undefined') {
			for (i=0; i < datosSubaccesos.length; i++) {
				if (datosSubaccesos[i][2] ==  acceso) {
					subaccesos [subaccesos.length] = [datosSubaccesos[i][0], datosSubaccesos[i][1]];
				}
			}
		}
		set_combo(FORMULARIO + '.cbSubacceso', subaccesos, ['']);
	}
}

function vaciaCombo(combo) {
	set_combo(combo,[['','']],['']);
}

// Función que se ejecuta en el OnBlur del campo textCodClienteD.
// Rellena con ceros el la parte izquierda de código de cliente.
function textCodClienteDOnBlur() {
	var codigoCliente = get(FORMULARIO+'.textCodClienteD').toString();
	if (codigoCliente != '') {
		var longitudCodigoCliente = get(FORMULARIO+'.numDigitosCodigoCliente').toString();
		var longitud = codigoCliente.length;
		set(FORMULARIO+'.textCodClienteD',rellenaCeros(codigoCliente,longitudCodigoCliente,longitud))
	}
}

// Función que se ejecuta en el OnBlur del campo textCodClienteH.
// Rellena con ceros el la parte izquierda de código de cliente.
function textCodClienteHOnBlur() {
	var codigoCliente = get(FORMULARIO+'.textCodClienteH').toString();	
	if (codigoCliente != '') {
		var longitudCodigoCliente = get(FORMULARIO+'.numDigitosCodigoCliente').toString();
		var longitud = codigoCliente.length;
		set(FORMULARIO+'.textCodClienteH',rellenaCeros(codigoCliente,longitudCodigoCliente,longitud))
	}
}


//Funcion que se ejecuta cuando se pincha sobre cancelación de cuotas
function cancelacionCuotas(){
	
	//Abrimos un popup modal con la direccion de la LPCancelacionCuotas, 
	//cuando se cierra el popup si resultado es null o un array sin filas  
	//salimos de la función.
	//Si es un array de dos dimensiones generamos una cadena de oids de movimiento
	//separados por un espacio en blanco. 

    //Llamamos al proceso correspondiente Modal
    var objParams = new Object();
    var proceso = get(FORMULARIO+'.proceso');
    objParams.proceso = proceso;
    var subproceso = get(FORMULARIO+'.subproceso');
    objParams.subproceso = subproceso;
    var empresa = get(FORMULARIO+'.cbEmpresa');
    objParams.empresa = empresa;
    

    var datosCancelacion = mostrarModalSICC('LPAgregarCuotas', '', objParams, null, null);
          
	// Si datos es null o un array sin datos.
	if((datosCancelacion==null)||(typeof(datosCancelacion)=='undefined')||(datosCancelacion.length==0)){ return false};
	
	// datosCancelacion es bidimensional y el dato de la penúltima columna de cada fila es el oid de movimiento.
	

	for(var i=0;i<datosCancelacion.length;i++){
		var fila = new Array();
		fila[0] = datosCancelacion[i][17];
		//fila[1] = datosCancelacion[i][j];
		fila[1] = get(FORMULARIO+'.cbEmpresa','T').toString();
		fila[2] = datosCancelacion[i][2];
		fila[3] = datosCancelacion[i][3];
		fila[4] = datosCancelacion[i][4];
		
		var nDoc = datosCancelacion[i][5];
 		//Identificador de cuota= 8 últimas posiciones del número de documento 
 		//Ejercicio de cuota= 2 primera posiciones del número de documento. 
 		if (nDoc != '') {
  			identificadorCuota = nDoc.substr(2);
  			ejercicioCuota = nDoc.substr(0, 2);
			fila[5] = identificadorCuota;
			fila[6] = ejercicioCuota;
		}else{
			fila[5] = '';
			fila[6] = '';
 		}
	
		fila[7] = datosCancelacion[i][6];
		fila[8] = datosCancelacion[i][1];
		fila[9] = datosCancelacion[i][7];
		fila[10] = datosCancelacion[i][8];
		fila[11] = datosCancelacion[i][9];
		fila[12] = datosCancelacion[i][12];

/*		fila[0] = datosCancelacion[i][19];
		//fila[1] = datosCancelacion[i][j];
		fila[1] = 'Empresa';
		fila[2] = 'Canal';
		fila[3] = 'Acceso';
		fila[4] = 'Subacceso';
		fila[5] = 'num iden cuot';
		fila[6] = 'ejercicio cuot';
		fila[7] = 'cod cliente';;
		fila[8] = 'fecha doc';
		fila[9] = 'fecha ven';
		fila[10] = 'medio pag';
		fila[11] = 'importe pend';*/
	
		listado1.insertar(fila);
	}
	setTimeout("recalcular()", 5);
	listado1.reajusta();
	
    // Ejecutamos una Druida Transaction que ejecutará agregarFilas(datos).
	//asignar([["COMBO","form.combo","ConectorDruidaTransactionConsulta","dtoSalida.resultado_ROWSET", oids,"agregarFilas(datos);"]],"",""); 
}

function accionBTN_AplicarIncobrables(){
	
	//Es necesario que se seleccione al menos una fila, 
	//Invocamos la LPSeleccionarProvisionesDepuraciones pasándole la accion="aplicarIncobrables"
	// y el formulario de forma oculta.
	
	if (listado1.numSelecc() == 0) {
		// Muestra el mensaje "Debe seleccionar los registros que formarán el lote de depuración. "
		cdos_mostrarAlert(GestionarMensaje('1262'));
	} else {
			// Desbloqueo de registros no seleccionados
			//desbloqueaFilasNoSeleccionadas();
			
			var canal = get(FORMULARIO+'.cbCanal');
			var acceso = get(FORMULARIO+'.cbAcceso');
			var subacceso = get(FORMULARIO+'.cbSubacceso');
			var empresa = get(FORMULARIO+'.cbEmpresa');
	
			set(FORMULARIO+'.hid_cbCanal',canal);
			set(FORMULARIO+'.hid_cbAcceso',acceso);
			set(FORMULARIO+'.hid_cbSubacceso',subacceso);
			set(FORMULARIO+'.hid_cbEmpresa',empresa);
			
			
		    	set(FORMULARIO + '.datos', listado1.codSeleccionados());
			set(FORMULARIO + '.accion', 'aplicarIncobrables');
			set(FORMULARIO+'.conectorAction','LPSeleccionarProvisionesDepuraciones');
			enviaSICC(FORMULARIO);
	}
}


//Función que agrega filas a la lista
function agregarFilas(datos){
	if ((datos!=null)&&(typeof(datos)!='undefined')&&(datos.length>0)){
		for(var i=0;i<datos.length;i++){
			listado1.insertar(datos[i]);
		}
		// Selecciono todas las filas de la lista.
		for (var i=0;i<listado1.datos.length;i++){
			if(!listado1.selecc[i])listado1.selecciona(i);
		}
	}
}



function recalcular(){
//El importe pendiente tendrá un totalizador al pie de pantalla 
//Sumamos el campo "pendiente" de todas las filas del array y obtenemos 
//un total que colocamos al pie de página en el campo totalPendiente (CLabel).
	var seleccion=listado1.codigos();
	var suma=0;
	var i=0;
	var separadorMiles = get(FORMULARIO+'.hid_SeparadorMiles');
        var separadorDecimales = get(FORMULARIO+'.hid_SeparadorDecimales');
	
	while(seleccion[i]!=null){
        	var importe = listado1.extraeDato(seleccion[i],11);	
			var aux = obtenerNumero(importe);
			if((aux != null) && (aux != '')) {
	        	suma = Number(suma)+Number(aux);
			}
          	i++;            
        }
	txt_to('lbldtTotalPendiente',formateaImporte(suma, separadorMiles, separadorDecimales)); 
}

/*Cortaberria
 estaba comentada la parte de seleccionado de registros de la grilla. Incidencia BELC300019086
*/
function resultadosOnLoad(ultima, rowset) {
	var tamano = rowset.length;
	if (tamano > 0) {
		visibilidad('capaLista','V');
		DrdEnsanchaConMargenDcho('listado1',12);
		eval (ON_RSZ);
		
		setTimeout("recalcular()", 5);
		setTimeout("marcarLista()", 5);

		// Selecciono todos los elementos de la lista.
		//for (var i=0;i<listado1.datos.length;i++){
		//	listado1.selecciona(i);
		//}
		
		return true;
	} else {
		visibilidad('capaLista','O');
		focaliza(FORMULARIO+'.textFechaImputacionProceso','');
		return false;
	}
}

function listado1OnAfterSetDatos(){
	for (var i=0;i<listado1.datos.length;i++){
		listado1.selecc[i]=1; 
	}
}

function desbloqueaFilasNoSeleccionadas() {
                  //Creamos un DTOOIDs con los oids de Mov.CC. 
                  //idBusiness = "CCCEliminarBloqueosMovCC" 
                  //Llamamos al "ConectorEliminarBloqueosMovCC" con el dto y el idBusiness 
                  var codSelecc = new String(listado1.codSeleccionados());
                  var  codigosSeleccionados = codSelecc.split(',');
                  var cods = new String(listado1.codigos());
                  var codigos = cods.split(',');
                  var filasADesbloquear = new Array();
                  listado1.actualizaDat();
                  for (j = 0; j < codigos.length; j++) {
                           var anyadir = true;
                           if (listado1.datos[j][20] == "1") {
                                    anyadir = false;
                           } else {
                                    for (i = 0; i < codigosSeleccionados.length; i++) {
                                             if ((codigos[j] == codigosSeleccionados[i])) {
                                                      anyadir = false;
                                                      break;                                        
                                             } //else filasADesbloquear[filasADesbloquear.length] = codigos[j];
                                    }
                           }
                           if (anyadir) filasADesbloquear[filasADesbloquear.length] = codigos[j];
                  }
                  

                  if (filasADesbloquear.length > 0) {
                           //desbloquear filas
                           desbloqueaFilas(filasADesbloquear, "CCCEliminarBloqueosMovCC", "ConectorEliminarBloqueosMovCC", "filasDesbloqueadas(datos)");
                  }
                 //devolverDatos();
}
