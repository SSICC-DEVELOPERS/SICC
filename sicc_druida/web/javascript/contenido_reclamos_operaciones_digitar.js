var FORMULARIO = 'frmContenido';
var arrayLineasOperacion = new Array();
var arrayObjetosLineasOperacion = new Array();
var cabeceraBloqueada = false;
var clienteResponsableBloqueado = false;
var clienteSeguroBloqueado = false;
var numeroLinea = 1;
//var numero = 0;
  
function onLoadPag(){
	if(parent && parent.frames && parent.frames.length > 0){
		configurarMenuSecundario(FORMULARIO);
		var errDescripcion = get(FORMULARIO +'.errDescripcion');
		if (errDescripcion !='') {		
			var errCodigo = get(FORMULARIO+'.errCodigo');
			var wnd = fMostrarMensajeError(errCodigo, errDescripcion);
		}	
		//DrdEnsanchaConMargenDcho('listado1',12);
		//eval (ON_RSZ);
		focaliza(FORMULARIO+'.txtCodDocRef');
		if(get(FORMULARIO+".txtCodDocRef").length || get(FORMULARIO+".txtCodDocRef")!="" ){
			cargarExistente(false);
		}
		modificaLineas();
	}
}

function aceptarOnClick (){
	if(sicc_validaciones_generales('cabecera')) {
		//tareas asignadas del botón aceptar:		
		/*Deshabilita los campos: 
		- txtCodDocumentoReferencia 
		- txtNumeroReclamo 
		- txtCodCliente */
		//bloquearCabecera();
		/*Agregado Gacevedo*/
		//window.setTimeout("focaliza(FORMULARIO+'.cbCodOperacion')",200);
		/*Fin Agregado*/

		obtenerExistente();

	}
}



function codigoClienteOnBlur(txtCodCliente){
	var codigoCliente = get(FORMULARIO+'.'+txtCodCliente).toString();
	if (codigoCliente != '') {
		var longitudCodigoCliente = get(FORMULARIO+'.numDigitosCodigoCliente').toString();
		var longitud = codigoCliente.length;
		set(FORMULARIO + '.'+txtCodCliente, rellenaCeros(codigoCliente, longitudCodigoCliente, longitud))
	}
	return;
}

function validarNumerico(texto){
         var num = get(FORMULARIO+'.'+texto); 
    if(num != ""){
         var val = allTrim(num);                
         //Como no nos interesa validar el número de dígitos que tiene el 
         //entero ponemos uno suficientemente grande. 
         if ((ValidaInt(val.toString(),10000, 0)!="OK")||(val.toString() < 0)) {
                  GestionarMensaje('747', null, null, null);
             focaliza(FORMULARIO+'.'+texto);
             return false;
         }
    }
}
function allTrim(sStr){ 
	return rTrim(lTrim(sStr)); 
}
function lTrim(sStr){ 
    while (sStr.charAt(0) == " "){
         sStr = sStr.substr(1, sStr.length - 1); 
    }
    return sStr; 
} 
function rTrim(sStr){ 
    while (sStr.charAt(sStr.length - 1) == " ") {
         sStr = sStr.substr(0, sStr.length - 1); 
    }
    return sStr; 
}                                
function iconoCliente(txtCodCliente){
	if (txtCodCliente == 'txtCodCliente' && cabeceraBloqueada) return;
	if (txtCodCliente == 'txtCodClienteSeguro' && clienteSeguroBloqueado) return;
	if (txtCodCliente == 'txtCodCliResponsable' && clienteResponsableBloqueado) return;

    //Llamamos al proceso correspondiente Modal
    var objParams = new Object();
    var cliente = mostrarModalSICC('LPBusquedaRapidaCliente', '', objParams, null, null);           

    if (cliente != null && cliente.length > 1) {
    	var codigoCliente = cliente[1];
        set(FORMULARIO+'.'+txtCodCliente,codigoCliente);
    }
    return;
}

function cbOperacion_onChange(){

	/*Documentation
	// Selecciona una operación en cbOperacion 
	
	Llamar al método recargaCombo utilizando el DTOOID y el idBusiness = "RECObtenerCodigosTipoOperacion" 
	Parametros del DTOOID: 
	- DTOOID.pais = oid del pais activo 
	- DTOOID.idioma = oid del idioma activo 
	- DTOOID.oid = oid del valor seleccionado en cbOperacion 
	
	Obtenemos un DTOSalida y cargamos el combo cbTipoOperacion 
	*/
	
	/*Agregado GACEVEDO*/
	//document.onkeydown = null;
	ocultarCapasLineasOperacion();
	limpiarFormularioLineas();
	numeroLinea=1;
	txt_to('lblNumeroLineaX', numeroLinea);
	listado2.setDatos([]);
	/*FIN Agregado GACEVEDO*/
	
	var pais = get(FORMULARIO+'.pais');
	var idioma = get(FORMULARIO+'.idioma');
	var oid = get(FORMULARIO + '.cbCodOperacion');
	
	if (oid != ""){
		recargaCombo(FORMULARIO+'.cbCodTipoOperacion','RECObtenerCodigosTipoOperacion','es.indra.sicc.util.DTOOID',[['oidPais',pais ],['oidIdioma',idioma],['oid',oid]]);
	}else{
		set_combo(FORMULARIO + '.cbCodTipoOperacion', [['','']], ['']);
	}
	
	// Configura el resto de campos en función de la operación seleccionada
	var indicador = '';
	for (i = 0; i < codigosOperacion.length; i++) {
		if(codigosOperacion[i][0] == oid){
			indicador = codigosOperacion[i][1];
			break;
		}
	}
	if(indicador == 1){
		//Si indicador perdida == 1 
		//Habilita los campos: 
		accion(FORMULARIO + '.txtCodCliResponsable','.disabled=false');
		accion(FORMULARIO + '.cbAsumePerdida','.disabled=false');
		/*accion(FORMULARIO + '.txtCodArtPagado','.disabled=false');
		accion(FORMULARIO + '.txtMontoArt','.disabled=false');
		accion(FORMULARIO + '.txtCodClienteSeguro','.disabled=false');*/
		clienteResponsableBloqueado = false;
		//clienteSeguroBloqueado = false;
	} else {
	    	//Deshabilita los campos:
	    	deshabilitaCampos();
	}
	 
}

function cbAsumePerdida_onChange(){
                                                    
	/*Documentation                                        
	// Selecciona una operación en cbAsumePerdida       
	                                                    
	Obtiene el oid del valor seleccionado en el combo   
	*/
	var oid = get(FORMULARIO + '.cbAsumePerdida');
	var asumeSeguro = get(FORMULARIO + '.asumeSeguro');                                                 
	/*Si oid == ConstantesREC.ASUME_SEGURO{                                                   
	Habilita los campos:                                
	- txtCodArticuloPago                                
	- txtCodClienteSeguro                               
	- txtMontoArticulo                                  
	}                                                   
	sino                                                
	{                                                   
	Deshabilita los campos:                             
	- txtCodArticuloPago                                
	- txtCodClienteSeguro                               
	- txtMontoArticulo  
	}	
	*/
	if (oid == asumeSeguro) {
		accion(FORMULARIO+'.txtCodArtPagado','.disabled=false');
		accion(FORMULARIO+'.txtCodClienteSeguro','.disabled=false');
		accion(FORMULARIO+'.txtMontoArt','.disabled=false');
		clienteSeguroBloqueado = false;

	} else {
		set(FORMULARIO + '.txtMontoArt', '');
		set(FORMULARIO + '.txtCodArtPagado', '');
		set(FORMULARIO + '.txtCodClienteSeguro', '');		
		
		accion(FORMULARIO+'.txtCodArtPagado','.disabled=true');
		accion(FORMULARIO+'.txtCodClienteSeguro','.disabled=true');
		accion(FORMULARIO+'.txtMontoArt','.disabled=true');

		clienteSeguroBloqueado = true;
	}
}   

function btnAnyadirOperacion_onClick(){

	var oidOperacion = get(FORMULARIO + '.cbCodOperacion').toString();
	var codOperacion = get(FORMULARIO + '.cbCodOperacion', 'T').toString();
	var oidTipoOperacion = get(FORMULARIO + '.cbCodTipoOperacion').toString();
	var codTipoOperacion = get(FORMULARIO + '.cbCodTipoOperacion','T').toString();
	var codClienteResponsable = get(FORMULARIO + '.txtCodCliResponsable').toString();
	var asumePerdida = get(FORMULARIO + '.cbAsumePerdida').toString();
	var montoArticulo = get(FORMULARIO + '.txtMontoArt').toString();
	var codArticuloPago = get(FORMULARIO + '.txtCodArtPagado').toString();
	var codClienteSeguro = get(FORMULARIO + '.txtCodClienteSeguro').toString();
	
	
	if(sicc_validaciones_generales("operacion")) {
		
		// incidencia 21340
		// Buscar el valor correspondiente al indicadorAnulacion para el oidOperacion seleccionado 
		// en el combo cbOperacion dentro del array operacionesAnulacion. 
		var oid = get(FORMULARIO + '.cbCodOperacion');

		var indicadorAnulacion = '';
		
		for (i = 0; i < operacionesAnulacion.length; i++) {
			if (operacionesAnulacion[i][0] == oid) {
				indicadorAnulacion = operacionesAnulacion[i][1];
				break;
			}
		}
		//numero = listado1.datos.length+1;//get(FORMULARIO + '.numeroOperacion').toString(); 
		// incidencia 21340
		if (indicadorAnulacion != 1) { // no es de anulacion	
			//Muestra la ventana modal y emergente LineasOperacion activando la LPDigitarReclamos con: 
			//- accion = "Introducir lineas operacion" 
			//- numeroOperacion 
			cargarCombosLineas();
			mostrarCapasLineasOperacion();
			window.setTimeout("focaliza(FORMULARIO+'.cbTipoMov')",1000);
		}
		var numero = listado1.datos.length+1;//get(FORMULARIO + '.numeroOperacion').toString(); 
		var fila = [numero, numero, codOperacion, codTipoOperacion, oidTipoOperacion, codClienteResponsable, asumePerdida, montoArticulo, codArticuloPago, codClienteSeguro];
		//Insertamos la fila
		listado1.insertar(fila);
		listado1.reajusta();

		//Añade al array operacionesReclamo un array con los datos de la operación introducidos en pantalla: 
		//{numero operacion,oidTipoOperacion,codigo cliente responsable,oidAsumePerdida,monto articulo,codigo articulo,codigo cliente seguro} 
		btnProxy(4, 1);		
		limpiarFormulario();
		/*
		Deshabilita los campos: 
		- txtCodClienteResponsable 
		- cbAsumePerdida 
		- txtMontoArticulo 
		- txtCodArticuloPago 
		- txtCodClienteSeguro 
		*/
		deshabilitaCampos();
		//Incrementa el campo lbNumeroOperacion 
//		numero++;
		set(FORMULARIO+'.numeroOperacion',listado1.datos.length+1);
		txt_to('lblNOperacionX',listado1.datos.length+1);
		focaliza(FORMULARIO + '.cbCodOperacion');
	}

}

	function bloquearCabecera() {
		accion(FORMULARIO + '.txtCodDocRef','.disabled=true');
		accion(FORMULARIO + '.txtCodCliente','.disabled=true');
		accion(FORMULARIO + '.txtNumeroReclamo','.disabled=true');
		document.all['btnAceptar'].disabled = true;	
		cabeceraBloqueada = true;
		mostrarCapasOperacion();
	}

	function mostrarCapasOperacion() {
		//mostrar campos de operacion 
		document.all["capa1"].style.visibility='visible';
		DrdEnsanchaConMargenDcho('listado1',12);
		document.all["Cplistado1"].style.visibility='visible';
		document.all["CpLin1listado1"].style.visibility='visible';
		document.all["CpLin2listado1"].style.visibility='visible';
		document.all["CpLin3listado1"].style.visibility='visible';
		document.all["CpLin4listado1"].style.visibility='visible';
		eval (ON_RSZ);  
	}

	function ocultarCapasOperacion() {
		//ocultar campos de operacion 
		document.all["capa1"].style.visibility='hidden';
		document.all["Cplistado1"].style.visibility='hidden';
		document.all["CpLin1listado1"].style.visibility='hidden';
		document.all["CpLin2listado1" ].style.visibility='hidden';
		document.all["CpLin3listado1"].style.visibility='hidden';
		document.all["CpLin4listado1"].style.visibility='hidden';

	}

	function mostrarCapasLineasOperacion(){
		//mostrar campos de operacion 
		document.all["capa2"].style.visibility='visible';
		DrdEnsanchaConMargenDcho('listado2',12);
		document.all["Cplistado2"].style.visibility='visible';
		document.all["CpLin1listado2"].style.visibility='visible';
		document.all["CpLin2listado2"].style.visibility='visible';
		document.all["CpLin3listado2"].style.visibility='visible';
		document.all["CpLin4listado2"].style.visibility='visible';
		document.all["AceptarDiv"].style.visibility='visible';
		eval (ON_RSZ);  
	}

	function ocultarCapasLineasOperacion() {
		//ocultar campos de operacion 
		var obj = eval('cbCodTipoOperacion');
		if(obj.options.length==0){
			return;
		}
		document.all["capa2"].style.visibility='hidden';
		document.all["Cplistado2"].style.visibility='hidden';
		document.all["CpLin1listado2"].style.visibility='hidden';
		document.all["CpLin2listado2" ].style.visibility='hidden';
		document.all["CpLin3listado2"].style.visibility='hidden';
		document.all["CpLin4listado2"].style.visibility='hidden';
		document.all["AceptarDiv"].style.visibility='hidden';
	}

	

	function limpiarFormulario() {

		set(FORMULARIO + '.cbCodOperacion', ['']);
		set_combo(FORMULARIO + '.cbCodTipoOperacion', [['','']], ['']);
	}

	function deshabilitaCampos() {
		/*Limpia los campos de la página: 
		- cbOperacion 
		- cbTipoOperacion 
		- txtCodClienteResponsable 
		- cbAsumePerdida 
		- txtMontoArticulo 
		- txtCodArticuloPago 
		- txtCodClienteSeguro 
		*/
		set(FORMULARIO + '.txtCodCliResponsable', '');
		set(FORMULARIO + '.cbAsumePerdida', ['']);
		set(FORMULARIO + '.txtMontoArt', '');
		set(FORMULARIO + '.txtCodArtPagado', '');
		set(FORMULARIO + '.txtCodClienteSeguro', '');		
		
		accion(FORMULARIO + '.txtCodCliResponsable','.disabled=true');
		accion(FORMULARIO + '.cbAsumePerdida','.disabled=true');
		accion(FORMULARIO + '.txtMontoArt','.disabled=true');
		accion(FORMULARIO + '.txtCodArtPagado','.disabled=true');
		accion(FORMULARIO + '.txtCodClienteSeguro','.disabled=true');
		
		clienteResponsableBloqueado = true;
		clienteSeguroBloqueado = true;

	} 

function fGuardar(){
	btnGuardar_onClick();
}


function btnGuardar_onClick(){
	//Comprueba que se ha añadido al menos una operación al reclamo 
	if (listado1.datos.length == 0) {
		// Muestra el mensaje: "Debe existir al menos una operación de reclamo"
		GestionarMensaje('REC005');
	} else {	
		//- lineasOperacion
		//Gacevedo
		//formateo desde el array de objetos al array original de la pantalla
		/*var filaFinal = new Array()
		filaFinal[0] = fila[0];	//numero de operacion
		filaFinal[1] = i;	//numero de linea
		filaFinal[2] = fila[6];	//oidTipoMovimiento
		filaFinal[3] = fila[2];	//codigo venta
		filaFinal[4] = obtieneNumeroDecimal(fila[3], get(FORMULARIO + '.hid_SeparadorDecimales'));	//unidades reclamadas
		filaFinal[5] = fila[7];	//oidMotivoDevolucion
		filaFinal[6] = fila[5];	//unidades devueltas
		if (filaFinal[5] == '') filaFinal[5] = '-';	//para que StringTokenicer no tenga que recuperar separador
		if (filaFinal[6] == '') filaFinal[6] = '-'; //para que StringTokenicer no tenga que recuperar separador
		datosFinal[datosFinal.length] = filaFinal;*/
		//[numeroLinea, tipoMovimiento, codigoVenta, unidadesReclamadas, motivoDevolucion, unidadesDevueltas, oidTipoMov, oidMotivoDev, oid]
		var largo = arrayObjetosLineasOperacion.length;
		for(var i=0; i< largo;i++){
			var fila = new Array();
			var objLinea = arrayObjetosLineasOperacion[i];
			fila[0]= objLinea.operacion;
			fila[1] = objLinea.numero;
			fila[2] = objLinea.tipoMovimiento;
			fila[3] = objLinea.codigoVenta;
			fila[4] = objLinea.unidadesReclamadas;
			fila[5] = objLinea.motivoDevolucion;
			fila[6] = objLinea.unidadesDevueltas;
			if (fila[5] == '') fila[5] = '-';	//para que StringTokenicer no tenga que recuperar separador
			if (fila[6] == '') fila[6] = '-'; //para que StringTokenicer no tenga que recuperar separador
			arrayLineasOperacion[arrayLineasOperacion.length] = fila;
		}
		//Ahora sigue la ejecucion normal;
		var arrayFilas = new Array();	//almacén temporal de los valores concatenados de línea 
		for (i = 0; i < arrayLineasOperacion.length; i++){
			arrayFilas[arrayFilas.length] = arrayLineasOperacion[i].join('@');
		}
		set(FORMULARIO + '.lineasOperacion', arrayFilas.join('#'));
		//alert(get(FORMULARIO + '.lineasOperacion'))
		//- operacionesReclamo 
		var cadenaOperaciones = "";
		for (i = 0; i < listado1.datos.length; i++) {
			var fila = listado1.datos[i];
			//poner vacíos a - para StringTokenicer:
			if (fila[5] == '') fila[5] = '-';
			if (fila[6] == '') fila[6] = '-';
			if (fila[7] == '')
				fila[7] = '-';
			else{
				//fila[7] = obtieneNumeroDecimal(fila[7], get(FORMULARIO + '.hid_SeparadorDecimales'));
				fila[7] = formateaCantidad(fila[7], get(FORMULARIO + '.hid_SeparadorMiles'),get(FORMULARIO + '.hid_NumeroDecimales'));
			}
			if (fila[8] == '') fila[8] = '-';
			if (fila[9] == '') fila[9] = '-';
			cadenaOperaciones = cadenaOperaciones + fila[1] + '@' + fila[4] + '@' + fila[5] + '@' + fila[6] + '@' + fila[7] + '@' + fila[8] + '@' + fila[9] + '#';
		}
		set(FORMULARIO + '.operacionesReclamo', cadenaOperaciones);
		
		//Llama a la LPDigitarReclamos con los parámetros: 
		//- accion = "Guardar" 
		set(FORMULARIO + '.accion','Guardar');
		set(FORMULARIO + '.conectorAction', 'LPDigitarReclamos');
		enviaSICC(FORMULARIO,null,null,'N');
	}
}

// recibe una cantidad como cadena de texto y la devuelve despues de quitar
// los separadores de miles, si aparecen  y convertir el separador de decimales en punto
// para trabajar en negocio con ese formato siempre
function formateaCantidad(cantidad, separadorMiles, separadorDecimales) {
         
         var resultado = '';

         for (i=0; i < cantidad.length; i++) {
                  car = cantidad.charAt(i)
                  if (car != separadorMiles) {
                           resultado += car;
                  }
         }
         resultado.replace(separadorDecimales,'.');
         
         return resultado;
}

function fBorrar(){

	//verifico si quiere eliminar del listado de las lineas de operacion
	if(listado2.numSelecc()>0){
		//simplemente elimino la seleccion
		listado2.eliminarSelecc();
		window.setTimeout("focaliza(FORMULARIO + '.cbTipoMov')",300);
		return;
	}else if (listado1.numSelecc() == 0) {
		// Muestra el mensaje: "Debe seleccionar un elemento de la lista"
		GestionarMensaje('50');
	} else {
		//var operacionSel = listado1.codSeleccionados().toString();
		var operacionSel = obtenerNumeroOperacion();
		var arrTemp = new Array();
		var largo = arrayObjetosLineasOperacion.length;
		for(var i = 0; i < largo; i++){
			if(arrayObjetosLineasOperacion[i].operacion != operacionSel){
				arrTemp[arrTemp.length] = arrayObjetosLineasOperacion[i];
			}
		}
		
		listado1.eliminarSelecc();
		listado2.setDatos([]);
		//Se resecuencian las operaciones y las lineas de operacion
		arrayObjetosLineasOperacion = arrTemp;
		resecuenciar();
		//document.onkeydown = null;
		ocultarCapasLineasOperacion();
		limpiarFormularioLineas();
		numeroLinea=1;
		txt_to('lblNumeroLineaX', numeroLinea);
		txt_to('lblNOperacionX', listado1.datos.length);
		window.setTimeout("focaliza(FORMULARIO+'.cbCodOperacion')",200);
		if (listado1.datos.length == 0) btnProxy(4, 0);
		listado1.repinta();
	}
}

function resecuenciar(){
	var largoLista = listado1.datos.length;
	for(var i=0; i<largoLista;i++){
		var numero = listado1.datos[i][0];
		listado1.datos[i][1] = i+1;
		listado1.datos[i][0] = i+1;
		//ahora relaciono las lineas con el nuevo numero de secuencia de la operacion
		var largoLineas = arrayObjetosLineasOperacion.length;
		for(var h=0; h< largoLineas; h++){
			if(parseInt(arrayObjetosLineasOperacion[h].operacion,10)==numero ){
				arrayObjetosLineasOperacion[h].operacion=i+1;
			}
		}
	}
}


function validaMonto(nombreElemento, enteros) {
	var valor = get(FORMULARIO + '.' + nombreElemento);
	if(valor != "") {
		var msg = ValidaCaracteres(valor,'0123456789' + get(FORMULARIO + '.hid_SeparadorMiles') + get(FORMULARIO + '.hid_SeparadorDecimales')); //puede llevar separador decimal ñññññ?
		if (msg != "OK") {
			cdos_mostrarAlert(DrdMsgCore(143) + get(FORMULARIO + '.hid_SeparadorMiles') + '0123456789');
			focaliza(FORMULARIO + '.' + nombreElemento);
			return false;
		}
		msg = ValidaMilesDecimales(valor, enteros, get(FORMULARIO + '.hid_NumeroDecimales'), get(FORMULARIO + '.hid_SeparadorMiles'), get(FORMULARIO + '.hid_SeparadorDecimales'), 0);
		if (msg != "OK") {
			cdos_mostrarAlert(msg);
			focaliza(FORMULARIO + '.' + nombreElemento);
		}
	}
}

function mayusculas(nombreElemento) {
     var cadena = get(FORMULARIO + '.' + nombreElemento);
     if (cadena != "")
              set(FORMULARIO + '.' + nombreElemento, cadena.toUpperCase());
}

function fLimpiar() {
	btnProxy(4, 0);
	set_combo(FORMULARIO + '.cbCodTipoOperacion', [['','']], ['']);
	desbloquearCabecera();
	deshabilitaCampos();
	
	//reinicia el campo lbNumeroOperacion 
	//numero = 1;
	set(FORMULARIO + '.numeroOperacion', listado1.datos.length+1);
	txt_to('lblNOperacionX', listado1.datos.length+1);

	//limpiar lista operaciones
	listado1.setDatos(new Array());
	listado1.reajusta();
	
	//limpiar lista lineas-operacion
	//document.onkeydown = null;
	numeroLinea=1;
	set(FORMULARIO + '.numeroLinea', numeroLinea);
	txt_to('lblNumeroLineaX', numeroLinea);
	limpiarFormularioLineas();
	ocultarCapasLineasOperacion();
	listado2.setDatos([]);
	arrayLineasOperacion = new Array();
	arrayObjetosLineasOperacion = new Array();
	focaliza(FORMULARIO + '.txtCodDocRef');
	
}

function desbloquearCabecera() {
	accion(FORMULARIO + '.txtCodDocRef','.disabled=false');
	accion(FORMULARIO + '.txtCodCliente','.disabled=false');
	accion(FORMULARIO + '.txtNumeroReclamo','.disabled=false');
	document.all['btnAceptar'].disabled = false;
	ocultarCapasOperacion();
}

function focalizaAnteriorCodOperacion() {
	if(cabeceraBloqueada) document.all['btnAnadirOperacion'].focus();
	else focaliza(FORMULARIO + '.txtNumeroReclamo');
}

function focalizaSiguienteAdd() {
	if(cabeceraBloqueada) focaliza(FORMULARIO + '.cbCodOperacion'); 
	else focaliza(FORMULARIO + '.txtCodDocRef');
}

function aceptarOntab(){
	focaliza(FORMULARIO + '.txtCodDocRef');
}

function onshtabCodRefe(){
	document.all['btnAceptar'].focus();
}


function insercionCorrecta(){
	fLimpiar();
	limpiarFormulario();
	set(FORMULARIO + '.txtCodDocRef','');
	set(FORMULARIO + '.txtCodCliente','');
	set(FORMULARIO + '.txtNumeroReclamo','');	
	focaliza(FORMULARIO + '.txtCodDocRef');
}

//Agregados de Gacevedo para la eliminacion de la pantalla modal,
//pasando toda la funcionalidad de la misma a esta única pantalla

	function cargarCombosLineas(oidParam) {
		var idioma = get(FORMULARIO + '.idioma');
	    var pais = get(FORMULARIO + '.pais');
		var oidOperacion;
		if(oidParam==null) {
			oidOperacion = get(FORMULARIO + '.cbCodOperacion').toString();
		}else{
			oidOperacion = oidParam;
		}

		parametrosRecargaCombos = new Array();
		var parametros = new Array();
		parametros[0] = FORMULARIO + '.cbTipoMov';   
		parametros[1] = 'RECObtenerTiposMovimientoRecarga';
		parametros[2] = 'es.indra.sicc.util.DTOOID';
		parametros[3] = arrayToString([["oidIdioma", idioma], ["oidPais", pais], ["oid", oidOperacion]]); //nos llegan como un array, debemos formatearlo a cadena
		parametrosRecargaCombos[parametrosRecargaCombos.length] = parametros;
	
		var parametros = new Array();
		parametros[0] = FORMULARIO + '.cbMotivoDev';   
		parametros[1] = 'RECObtenerMotivosDevolucionOperacionRecarga';
		parametros[2] = 'es.indra.sicc.util.DTOOID';
		parametros[3] = arrayToString([["oidIdioma", idioma], ["oidPais", pais], ["oid", oidOperacion]]); //nos llegan como un array, debemos formatearlo a cadena
		parametrosRecargaCombos[parametrosRecargaCombos.length] = parametros;
        recargaComboMultiple(parametrosRecargaCombos); 
	}

	function recargaComboMultiple(parametros) {
           var i;
           var instruccion = "asignar([";

           for (i=0; i < parametros.length; ++i) {
           	instruccion = instruccion + "['COMBO', '" + parametros[i][0] + 
           	                 "', 'ConectorDruidaTransactionQuery', 'dtoSalida.resultado_ROWSET', " +
                                           "formarCadenaDT('" + parametros[i][1] + "', '" + parametros[i][2] + 
                                           "', " + parametros[i][3] + ")";
                  if (parametros[i].length == 5)
                           instruccion = instruccion + ", '" + parametros[i][4] + "'";

                  instruccion = instruccion + "]";
                  if (i != parametros.length -1) {
                  //Si no es la ultima fila ponemos la coma que separa del siguiente array  		
                           instruccion = instruccion + ", ";
                  }
           }
           instruccion = instruccion + "]);";
			//alert(instruccion);
           if (parametros.length > 0)
           	eval(instruccion);
	}

	function arrayToString(valoresEntrada) {
	         var cadena = "[]";
	         if (valoresEntrada != null && valoresEntrada.length > 0) {
	                  cadena = "[";
	                  for (i = 0; i < valoresEntrada.length; i++) {
	                           cadena += "['" + valoresEntrada[i][0] + "', " + valoresEntrada[i][1] + "]";
	                           if (i < valoresEntrada.length-1) cadena += ", ";
	                  }
	                  cadena += "]";
	         }
	         return cadena
	}
	
	function btnAnyadir_onClick(){
		var oidTipoMov = get(FORMULARIO+'.cbTipoMov').toString();
		var tipoMovimiento = get(FORMULARIO+'.cbTipoMov','T').toString();
		var codigoVenta = get(FORMULARIO+'.txtCodVenta').toString();
		var unidadesReclamadas = get(FORMULARIO + '.txtNUniReclamadas').toString();
		var oidMotivoDev = get(FORMULARIO+'.cbMotivoDev').toString();
		var motivoDevolucion = get(FORMULARIO+'.cbMotivoDev','T').toString();
		var unidadesDevueltas = get(FORMULARIO+'.txtNUniDevueltas').toString();
		var numeroLineaReal = listado2.datos.length+1;
		if(sicc_validaciones_generales("linea")) {

			var numero = obtenerNumeroOperacion();

			//var fila = [oid, tipoMovimiento, codigoVenta, unidadesReclamadas, motivoDevolucion, unidadesDevueltas, oidTipoMov, oidMotivoDev];
			var fila = [numeroLineaReal, tipoMovimiento, codigoVenta, unidadesReclamadas, motivoDevolucion, unidadesDevueltas, oidTipoMov, oidMotivoDev, numero];
			listado2.insertar(fila);
			listado2.reajusta();
			numeroLinea++;
			set(FORMULARIO + '.numeroLinea', numeroLinea);
			txt_to('lblNumeroLineaX', numeroLinea);
			limpiarFormularioLineas();	
			window.setTimeout("focaliza(FORMULARIO + '.cbTipoMov')",300);
		}
	}

	
	function obtenerNumeroOperacion(){
		var numeroTemp = listado1.codSeleccionados().toString();
		var numero = "";

		if(numeroTemp!="" && !isNaN(numeroTemp)){
			for(var i=0; i<listado1.datos.length;i++){
				if(listado1.datos[i][0]==numeroTemp){
					numero = listado1.datos[i][1];
				}
			}
		}else{
			numero = numeroTemp;
		}
		if(numero=="" || isNaN(numero)){
			//no es una modificacion, es el ultimo de la lista
			numero = listado1.datos[listado1.datos.length-1][1];
		}
		return numero;
	}

	
	function validaUnidades(nombreElemento, enteros) {
		var valor = get(FORMULARIO + '.' + nombreElemento);
		if(valor != "") {
			var msg = ValidaCaracteres(valor,'0123456789' + get(FORMULARIO + '.hid_SeparadorMiles'));
			if (msg != "OK") {
				cdos_mostrarAlert(DrdMsgCore(143) + get(FORMULARIO + '.hid_SeparadorMiles') + '0123456789');
				focaliza(FORMULARIO + '.' + nombreElemento);
				return false;
			}

			msg = ValidaMilesDecimales(valor, enteros, 0, get(FORMULARIO + '.hid_SeparadorMiles'), get(FORMULARIO + '.hid_SeparadorDecimales'), 0);
			if (msg != "OK") {
				cdos_mostrarAlert(msg);
				focaliza(FORMULARIO + '.' + nombreElemento);
			}
		}
	}
	
	
	function btnAceptar_onclick(){
	
		var numero = obtenerNumeroOperacion();
		extrarDatosLineas(numero);

		//document.onkeydown = null;
		ocultarCapasLineasOperacion();
		limpiarFormularioLineas();
		numeroLinea=1;
		txt_to('lblNumeroLineaX', numeroLinea);
		window.setTimeout("focaliza(FORMULARIO+'.cbCodOperacion')",200);
		listado2.setDatos([]);
		
		//desmarco la seleccion en el listado1, si es que existe.
		desmarcaListadoOperacion();
		return true;
	}
	
	function extrarDatosLineas(numOperacion){
		//busco las lineas de operacion usando el codigo de operacion que se selecciono
		//con anterioridad, a fin de mantener el estado de las mismas.
		if(listado2.datos && listado2.datos.length > 0){
			var oidOperacion = listado2.datos[0][8];
			//saco las lineas de operacion viejas
			var arrTemp = new Array();
			var largoLineasViejas = arrayObjetosLineasOperacion.length;
			for(var i = 0; i < largoLineasViejas; i++){
				if(parseInt(arrayObjetosLineasOperacion[i].operacion,10) != parseInt(oidOperacion,10)){
					arrTemp[arrTemp.length] = arrayObjetosLineasOperacion[i];
				}
			}
			arrayObjetosLineasOperacion = arrTemp;
		}
		//var datosFinal = new Array();
		var largo = listado2.datos.length
		for (i = 0; i < largo; i++) {
			var fila = listado2.datos[i];
			/*var filaFinal = new Array()
			filaFinal[0] = fila[0];	//numero de operacion
			filaFinal[1] = i;	//numero de linea
			filaFinal[2] = fila[6];	//oidTipoMovimiento
			filaFinal[3] = fila[2];	//codigo venta
			filaFinal[4] = obtieneNumeroDecimal(fila[3], get(FORMULARIO + '.hid_SeparadorDecimales'));	//unidades reclamadas
			filaFinal[5] = fila[7];	//oidMotivoDevolucion
			filaFinal[6] = fila[5];	//unidades devueltas
			if (filaFinal[5] == '') filaFinal[5] = '-';	//para que StringTokenicer no tenga que recuperar separador
			if (filaFinal[6] == '') filaFinal[6] = '-'; //para que StringTokenicer no tenga que recuperar separador
			datosFinal[datosFinal.length] = filaFinal;*/
			//[numeroLinea, tipoMovimiento, codigoVenta, unidadesReclamadas, motivoDevolucion, unidadesDevueltas, oidTipoMov, oidMotivoDev, oid]
			var objLinea = new Object();
			objLinea.numero = fila[0];
			objLinea.operacion = fila[8];
			objLinea.tipoMovimiento = fila[6];
			objLinea.tipoMovimientoDesc = fila[1];
			objLinea.codigoVenta = fila[2];
			objLinea.unidadesReclamadas = obtieneNumeroDecimal(fila[3], get(FORMULARIO + '.hid_SeparadorDecimales'));
			objLinea.motivoDevolucion = fila[7];
			objLinea.motivoDevolucionDesc = fila[4];
			objLinea.unidadesDevueltas = fila[5];
			arrayObjetosLineasOperacion[arrayObjetosLineasOperacion.length] = objLinea;
		}
	}


	function limpiarFormularioLineas() {
		set(FORMULARIO + '.cbTipoMov', ['']);
		set(FORMULARIO + '.txtCodVenta', '');
		set(FORMULARIO + '.txtNUniReclamadas', '');
		set(FORMULARIO + '.cbMotivoDev', ['']);
		set(FORMULARIO + '.txtNUniDevueltas', '');
	}
	
	function fnVerTeclaRapida(){
		var keyAlt = event.altKey;
		var keyValue = event.keyCode;
		var keyText = String.fromCharCode(keyValue);
		if(keyAlt){
			//&& document.all["AceptarDiv"].style.visibility!='hidden'
			if(keyText.toUpperCase()=="L" ){
				btnAceptar_onclick();
			}
		}
		return true;
	}
	
	function modificarOperacion(){
		var numeroOperacionSel = listado1.codSeleccionados().toString();
		if(numeroOperacionSel=="" || isNaN(numeroOperacionSel)){
			return;
		}

		if(listado2.datos && listado2.datos.length){
			extrarDatosLineas(listado2.datos[0][8]);
		}

		//busco el texto del codigo de operacion
		var textoCodOperacion=null;
		var largoDatos = listado1.datos.length;
		for(var i=0; i< largoDatos;i++){
			if(listado1.datos[i][0]==numeroOperacionSel){
				textoCodOperacion=listado1.datos[i][2];
				break;
			}
		}
		//busco el oid del codigo de operacion
		var oidCodOperacion=-1;
		var objSelect = document.all.tags("SELECT")["cbCodOperacion"];
		var largoOptions = objSelect.options.length;
		for(var i=0; i< largoOptions; i++){
			if(objSelect.options[i].text == textoCodOperacion){
				oidCodOperacion = objSelect.options[i].value;
				break;
			}
		}



		for (i = 0; i < operacionesAnulacion.length; i++) {
			if (operacionesAnulacion[i][0] == oidCodOperacion) {
				if(operacionesAnulacion[i][1]==1){//es una anulacion
					listado2.setDatos([]);
					ocultarCapasLineasOperacion();
					limpiarFormularioLineas();
					numeroLinea=1;
					txt_to('lblNumeroLineaX', numeroLinea);
					window.setTimeout("focaliza(FORMULARIO+'.cbCodOperacion')",200);
					return;
				}else{
					break;
				}
			}
		}

		//limpio el listado
		listado2.setDatos(armarArrayLineas(obtenerNumeroOperacion()));

		cargarCombosLineas(oidCodOperacion);
		set(FORMULARIO+'.numeroOperacion',numeroOperacionSel);
		numeroLinea=listado2.datos.length+1;
		txt_to('lblNumeroLineaX', numeroLinea);
		mostrarCapasLineasOperacion();
		//document.onkeydown = fnVerTeclaRapida;
		window.setTimeout("if(document.all['capa2'].style.visibility=='visible'){focaliza(FORMULARIO+'.cbTipoMov')}",1000);
	}
	
	function armarArrayLineas(numeroOperacion){
		//Modelo del Array de la lista de lineas
		//[numeroLinea, tipoMovimiento, codigoVenta, unidadesReclamadas, motivoDevolucion, unidadesDevueltas, oidTipoMov, oidMotivoDev, oid]
		var largo = arrayObjetosLineasOperacion.length;
		var arrSalida = new Array();
		var operacionTemp = ((numeroOperacion==null)?-1:numeroOperacion);
		for(var i = 0; i<largo;i++){
			var objLinea = arrayObjetosLineasOperacion[i];
			if(operacionTemp == -1 || objLinea.operacion == operacionTemp){
				var fila = new Array();
				fila[0] = objLinea.numero
				fila[8] = objLinea.operacion;
				fila[6]  = objLinea.tipoMovimiento;
				fila[1] = objLinea.tipoMovimientoDesc;
				fila[2] = objLinea.codigoVenta;
				fila[3] = objLinea.unidadesReclamadas;
				fila[7] = objLinea.motivoDevolucion;
				fila[4] = objLinea.motivoDevolucionDesc;
				fila[5] = objLinea.unidadesDevueltas;
				arrSalida[arrSalida.length]= fila;
			}
		}
		/*if(operacionTemp != -1){
			var arrTemp = new Array();
			var largo = arrayObjetosLineasOperacion.length;
			for(var i = 0; i < largo; i++){
				if(arrayObjetosLineasOperacion[i].operacion != operacionTemp){
					arrTemp[arrTemp.length] = arrayObjetosLineasOperacion[i];
				}
			}
			arrayObjetosLineasOperacion = arrTemp;
		}*/
		return arrSalida;
	}
	
	function desmarcaListadoOperacion(){
		//desmarco la seleccion en el listado1, si es que existe.
		var operacionSel = listado1.codSeleccionados().toString();
		var indice = null;
		if(operacionSel!="" && !isNaN(operacionSel)){
			var largo = listado1.datos.length;
			for(var i=0; i< largo; i++){
				if(listado1.datos[i][0]==operacionSel){
					indice = i;
					break;
				}
			}
			if(indice!=null){
				listado1.deselecciona(indice);
			}
		}
	}

//Agregado del agregado de Gacevedo por Gacevedo
//Se implanta la posibilidad de modificar los reclamos
//-----------------------------------------------------

function obtenerExistente(){
	set("frmConsultaExistencia.codDocRef",get(FORMULARIO+".txtCodDocRef"));
	set("frmConsultaExistencia.codClie",get(FORMULARIO+".txtCodCliente"));
	set("frmConsultaExistencia.numRecla",get(FORMULARIO+".txtNumeroReclamo"));
	enviaSICC("frmConsultaExistencia",null,null,'N');
}

function cargarExistente(existeDigitado){
	if(!existeDigitado){
		bloquearCabecera();
		window.setTimeout("focaliza(FORMULARIO+'.cbCodOperacion')",200);
	}else{
		//voy a buscar la data
		set(FORMULARIO + '.accion','Cargar');
		set(FORMULARIO + '.conectorAction', 'LPDigitarReclamos');
		eval(FORMULARIO + ".oculto='N'");
		enviaSICC(FORMULARIO);
	}
}

function modificaLineas(){
	
	if(eval(get(FORMULARIO+".modificacionDigitados"))){
		txt_to('lblNOperacionX',listado1.datos.length+1);
		btnProxy(4, 1);
	}
	if(!lineasDeOperacionModificacion || 
		!lineasDeOperacionModificacion.length ||
		!lineasDeOperacionModificacion.length > 0){
		return;
	}
	var largo = lineasDeOperacionModificacion.length
	for (i = 0; i < largo; i++) {
		var fila = lineasDeOperacionModificacion[i];
		/*var filaFinal = new Array()
		filaFinal[0] = fila[0];	//numero de operacion
		filaFinal[1] = i;	//numero de linea
		filaFinal[2] = fila[6];	//oidTipoMovimiento
		filaFinal[3] = fila[2];	//codigo venta
		filaFinal[4] = obtieneNumeroDecimal(fila[3], get(FORMULARIO + '.hid_SeparadorDecimales'));	//unidades reclamadas
		filaFinal[5] = fila[7];	//oidMotivoDevolucion
		filaFinal[6] = fila[5];	//unidades devueltas
		if (filaFinal[5] == '') filaFinal[5] = '-';	//para que StringTokenicer no tenga que recuperar separador
		if (filaFinal[6] == '') filaFinal[6] = '-'; //para que StringTokenicer no tenga que recuperar separador
		datosFinal[datosFinal.length] = filaFinal;*/
		//[numeroLinea, tipoMovimiento, codigoVenta, unidadesReclamadas, motivoDevolucion, unidadesDevueltas, oidTipoMov, oidMotivoDev, oid]
		var objLinea = new Object();
		objLinea.numero = fila[0];
		//objLinea.operacion = fila[8];
		objLinea.operacion = buscarNumeroOperacion(fila[8]);
		objLinea.tipoMovimiento = fila[6];
		objLinea.tipoMovimientoDesc = fila[1];
		objLinea.codigoVenta = fila[2];
		objLinea.unidadesReclamadas = obtieneNumeroDecimal(fila[3], get(FORMULARIO + '.hid_SeparadorDecimales'));
		objLinea.motivoDevolucion = fila[7];
		objLinea.motivoDevolucionDesc = fila[4];
		objLinea.unidadesDevueltas = fila[5];
		arrayObjetosLineasOperacion[arrayObjetosLineasOperacion.length] = objLinea;
	}
	resecuenciar();
}


function buscarNumeroOperacion(oidOperacion){
	var numeroSalida = 0;
	for(var i=0; i< listado1.datos.length;i++){
		if(listado1.datos[i][0] == oidOperacion){
			numeroSalida = listado1.datos[i][1];
			break;
		}
	}
	return numeroSalida;
}
