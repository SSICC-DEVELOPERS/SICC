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


var FORMULARIO = 'formulario';

function onLoadPag(){
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
	document.all["separaDiv"].style.visibility='';
	document.all["primera1Div"].style.visibility='';
	document.all["ret1Div"].style.visibility='';
	document.all["ava1Div"].style.visibility='';
	document.all["btnVerFicha"].style.visibility='';
	eval (ON_RSZ);
	configurarMenuSecundario(FORMULARIO);
        focaliza(FORMULARIO+'.txtCodCliente');
}
function fnTestEnter(){
	if(event.keyCode!=13){return true;}
	codigoClienteOnChange();
	accionBuscar();
	return false;
}
function mostrarFichaAuto(){
	if(listado1 && listado1.datos.length==1){
		//lo marco y muestro la ficha de forma automatica
		window.setTimeout('listado1.selecciona(0);accionVerFicha();',1000);
	}
}

function fLimpiar(){
	//ocultaLista();
	habilitarTodos();
	borrarTodos();
	focaliza(FORMULARIO+'.txtCodCliente');
}

function borrarTodos(){
	set(FORMULARIO+'.txtCodCliente', '');
	set(FORMULARIO +'.cbTipoDoc',['']);
	set(FORMULARIO+'.txtDocIdentidad', '');
	set(FORMULARIO+'.txtApellido1', '');
	set(FORMULARIO+'.txtApellido2', '');
	set(FORMULARIO+'.txtApellidoCasada', '');
	set(FORMULARIO+'.txtNombre1', '');
	set(FORMULARIO+'.txtNombre2', '');
	set(FORMULARIO +'.cbMarca',['']);
	set(FORMULARIO +'.cbCanal',['']);
	set_combo(FORMULARIO +'.cbSubgerenciaVentas',['',''],['']);
	set_combo(FORMULARIO +'.cbRegion',['',''],['']);
	set_combo(FORMULARIO +'.cbZona',['',''],['']);
}

function habilitarTodos(){
	document.getElementById('txtCodCliente').disabled=false;
	document.getElementById('cbTipoDoc').disabled=false;
	document.getElementById('txtDocIdentidad').disabled=false; 
	document.getElementById('txtApellido1').disabled=false; 
	document.getElementById('txtApellido2').disabled=false; 
	document.getElementById('txtApellidoCasada').disabled=false; 
	document.getElementById('txtNombre1').disabled=false; 
	document.getElementById('txtNombre2').disabled=false; 
	document.getElementById('cbMarca').disabled=false;
	document.getElementById('cbCanal').disabled=false;
	document.getElementById('cbSubgerenciaVentas').disabled=false;
	document.getElementById('cbRegion').disabled=false;
	document.getElementById('cbZona').disabled=false;
}

function deshabilitarTodos(){
	document.getElementById('txtCodCliente').disabled=true;
	document.getElementById('cbTipoDoc').disabled=true;
	document.getElementById('txtDocIdentidad').disabled=true; 
	document.getElementById('txtApellido1').disabled=true; 
	document.getElementById('txtApellido2').disabled=true; 
	document.getElementById('txtApellidoCasada').disabled=true; 
	document.getElementById('txtNombre1').disabled=true; 
	document.getElementById('txtNombre2').disabled=true; 
	document.getElementById('cbMarca').disabled=true;
	document.getElementById('cbCanal').disabled=true;
	document.getElementById('cbSubgerenciaVentas').disabled=true;
	document.getElementById('cbRegion').disabled=true;
	document.getElementById('cbZona').disabled=true;
}

function fVolver(){
         window.close();
}

function visibleLista() {
	visibilidad('capaLista1','V');
	DrdEnsanchaConMargenDcho('listado1',12);
	eval (ON_RSZ);
}

function ocultaLista() {
	visibilidad('capaLista1','O');
}

function muestraLista(ultima, rowset) {
	var tamano = rowset.length;
	if (tamano > 0) {
		visibleLista();
		return true;
	} else {
		ocultaLista();
		//Después de cargar los registros se comprueba si existe algún registro 
		//Si no existe ningún registro 
		//llamar al C.U. Insertar clientes datos básicos de MAE 
		//Llamar a la LPInsertarClienteBasico con: ->INCIDENCIA BELC300014719
		//accion = "" 
     	//origen = "otro"
     
   /*Se bloquea la ejecución hasta el cierre de la pantalla emergente y modal

   Activar LPPresentarCientes con:
   - accion="Ver Ficha"
   - pais = pais activo
cliente*/

		//alert("conectorAction: " + get(FORMULARIO+'.conectorAction'));

// vbongiov -- Cambio RI 20080764 -- 9/10/2008
/*
		var objParams = new Object();
		objParams.origen = "otro";
		var datosCliente = mostrarModalSICC('LPInsertarClienteBasico', '', objParams, null, null);
		if (typeof(datosCliente) != 'undefined') {
			//Activar LPPresentarCientes con:
		   //- accion="Ver Ficha"
		   //- pais = pais activo
			//- oidCliente //variable de la posición 1 del array devuelto por el C.U. Insertar datos básicos cliente
			//- oidTipoCliente //variable de la posición 2 del array devuelto por el C.U. Insertar datos básicos cliente
		   
			objParams.oidCliente = datosCliente[1];
			objParams.oidTipoCliente = datosCliente[2];
			objParams.casoDeUso = 'Presentar'; 
			mostrarModalSICC('LPPresentarClientes', 'Ver Ficha', objParams, null, null);

		}
		*/
	}
}

function accionBuscar(){
//Obtiene de la página los criterios de búsqueda introducidos por el usuario: 
    var oidCliente = '';
    var codigoCliente = '';
    var oidTipoDocumento = '';
    var docIdentidad = '';
    var apellido1 = '';
    var apellido2 = '';
    var apellidoCasada = '';
    var nombre1 = '';
    var nombre2 = '';
    var oidMarca = '';
    var oidCanal = '';
    var oidSubgerenciaVentas = '';
    var oidRegion = '';
    var oidZona = '';
    var pais = '';
    var idioma = '';


    if(document.getElementById('oidCliente').disabled==false){
    	oidCliente = get(FORMULARIO+'.oidCliente');
    }
    if(document.getElementById('txtCodCliente').disabled==false){
	    codigoCliente = get(FORMULARIO+'.txtCodCliente');
    }
    if(document.getElementById('cbTipoDoc').disabled==false){
	    oidTipoDocumento = get(FORMULARIO+'.cbTipoDoc');
    }
    if(document.getElementById('txtDocIdentidad').disabled==false){
	    docIdentidad = get(FORMULARIO+'.txtDocIdentidad');
    }
    if(document.getElementById('txtApellido1').disabled==false){
	    apellido1 = get(FORMULARIO+'.txtApellido1');
    }
    if(document.getElementById('txtApellido2').disabled==false){
	    apellido2 = get(FORMULARIO+'.txtApellido2');
    }
    if(document.getElementById('txtApellidoCasada').disabled==false){
	    apellidoCasada = get(FORMULARIO+'.txtApellidoCasada');
    }
    if(document.getElementById('txtNombre1').disabled==false){
	    nombre1 = get(FORMULARIO+'.txtNombre1');
    }
    if(document.getElementById('txtNombre2').disabled==false){
	    nombre2 = get(FORMULARIO+'.txtNombre2');
    }
    if(document.getElementById('cbMarca').disabled==false){
	    oidMarca = get(FORMULARIO+'.cbMarca');
    }
    if(document.getElementById('cbCanal').disabled==false){
	    oidCanal = get(FORMULARIO+'.cbCanal');
    }
    if(document.getElementById('cbSubgerenciaVentas').disabled==false){
	    oidSubgerenciaVentas = get(FORMULARIO+'.cbSubgerenciaVentas');
    }
    if(document.getElementById('cbRegion').disabled==false){
	    oidRegion = get(FORMULARIO+'.cbRegion');
    }
    if(document.getElementById('cbZona').disabled==false){
	    oidZona = get(FORMULARIO+'.cbZona');
    }
    if(document.getElementById('pais').disabled==false){
	    pais = get(FORMULARIO+'.pais');
    }
    if(document.getElementById('idioma').disabled==false){
	    idioma = get(FORMULARIO+'.idioma');
    }

	//Los parametros no introducidos tendrán valor Null
	//Llamamos a configurarPaginado pasándole los siguientes parametros:
	configurarPaginado(mipgndo, //Objeto paginado (lstResultado)
				"CALObtenerClientes", //idBusiness ("CALObtenerClientes")
                              	"ConectorObtenerClientes", //"ConectorObtenerClientes" 
                              	"es.indra.sicc.dtos.cal.DTOCliente", //"DTOCliente"
                                                                [["oidPais", pais], 
                                                                ["oidIdioma", idioma], 
                                                                ["oidCliente", oidCliente], 
                                                                ["codCliente", codigoCliente],
                                                                ["oidTipoDocumento", oidTipoDocumento], 
                                                                ["docIdentidad", docIdentidad], 
                                                                ["apellido1", apellido1], 
                                                                ["apellido2", apellido2], 
                                                                ["apellidoCasada", apellidoCasada], 
                                                                ["nombre1", nombre1], 
                                                                ["nombre2", nombre2],
                                                                ["oidMarca", oidMarca], 
                                                                ["oidCanal", oidCanal], 
                                                                ["oidSubgerenciaVentas", oidSubgerenciaVentas], 
                                                                ["oidRegion", oidRegion], 
                                                                ["oidZona", oidZona] 
                                                                ]);
}

function accionBuscarCliente () {
	// Método que se ejecuta al pulsar sobre el icono de búsqueda rápida del campo Cod.cliente 
	//Invocamos al subsistema de soporte Búsqueda rápida de clientes (Activando la LPBusquedaRapidaCliente) 
	//y recibimos un array con (oid, codigo, nombre1, nombre2, apellido1, apellido2). 
	//Mostramos: 
	//- codigo en txtCodigoCliente 
	//Se almacena: 
	//- oid en la variable de la página oidCliente 
	var objParams = new Object();
	var cliente = mostrarModalSICC('LPBusquedaRapidaCliente', '', objParams, null, null);
	if (cliente != null && cliente.length > 1) {
		set(FORMULARIO+'.txtCodCliente', cliente[1].toString());
		set(FORMULARIO+'.oidCliente', cliente[0].toString());
	}
}

function accionVerFicha () {
	//se invoca al CU Presentar clientes 
	//si se ha llegado a la página por accion "Buscar" 
	if (listado1.numSelecc() == 0) {
                  // "Debe seleccionar un elemento de la lista"
                  GestionarMensaje('50');
         } else {
		if (listado1.numSelecc() != 1 ) {
		//Muesta el mensaje: "Debe seleccionar un solo registro"
		GestionarMensaje('8');
		} else{
			//Resto de parámetros: 
			//- pais = pais activo 
			//- oidCliente //variable de la página 
			//- codigoCliente //elemento de la lista lstResultado.codigoCliente 
			//- oidTipoCliente //elemento de la lista lstResultado.oidTipoCliente 
			//- codigoTipoCliente //elemento de la lista lstResultado.codigoTipoCliente
			var codigosSeleccionados = listado1.codSeleccionados();
			/*set(FORMULARIO+'.oidCliente',codigosSeleccionados[0]);
			set(FORMULARIO+'.codigoCliente',listado1.extraeDato(codigosSeleccionados[0],0));
			set(FORMULARIO+'.oidTipoCliente',listado1.extraeDato(codigosSeleccionados[0],1));
			set(FORMULARIO+'.codigoTipoCliente',listado1.extraeDato(codigosSeleccionados[0],2));*/
			if(get(FORMULARIO+'.accion')=="Buscar") {
				//Activar LPPresentarCientes con: 
				//- accion="Ver Ficha Consulta Interna" 
				/*set(FORMULARIO +'.accion','Ver Ficha Consulta Interna');
				set(FORMULARIO +'.conectorAction',"LPPresentarClientes");
				enviaSICC(FORMULARIO); */
				var objParams = new Object();
				objParams.oidCliente=listado1.extraeDato(codigosSeleccionados[0],0);
				objParams.codigoCliente=listado1.extraeDato(codigosSeleccionados[0],1);
				objParams.oidTipoCliente=listado1.extraeDato(codigosSeleccionados[0],2);
				objParams.codigoTipoCliente=listado1.extraeDato(codigosSeleccionados[0],3);
				objParams.casoDeUso='Presentar'; 
				mostrarModalSICC('LPPresentarClientes', 'Ver Ficha Consulta Interna', objParams, null, null);
			}else {
				//Activar LPPresentarCientes con: 
				//- accion="Ver Ficha desde Página" 
				/*set(FORMULARIO +'.accion','Ver Ficha desde Página');
				set(FORMULARIO +'.conectorAction',"LPPresentarClientes");
				enviaSICC(FORMULARIO);*/
				var objParams = new Object();
				objParams.oidCliente=listado1.extraeDato(codigosSeleccionados[0],0);
				objParams.codigoCliente=listado1.extraeDato(codigosSeleccionados[0],1);
				objParams.oidTipoCliente=listado1.extraeDato(codigosSeleccionados[0],2);
				objParams.codigoTipoCliente=listado1.extraeDato(codigosSeleccionados[0],3);
				mostrarModalSICC('LPPresentarClientes', 'Ver Ficha desde Página', objParams, null, null);
			}
		}
	}
}

function codigoClienteOnTab() {
	var codigoCliente = get(FORMULARIO+'.txtCodCliente');
	if(codigoCliente!=""){
		document.all['btnBuscar'].focus();
	}else{
		focaliza(FORMULARIO+'.cbTipoDoc');
	}
}

function codigoClienteOnShTab() {
	if(listado1.datos.length==0){ //lista oculta pq no hay datos
		document.all['btnBuscar'].focus();
	}else{ //lista visible
		document.all['btnVerFicha'].focus();
	}
}

function buscarOnTab() {
	if(listado1.datos.length==0){ //lista oculta pq no hay datos
		if(document.getElementById('txtCodCliente').disabled==true){
			focaliza(FORMULARIO+'.cbTipoDoc');
		}else{
			focaliza(FORMULARIO+'.txtCodCliente');
		}
	}else{ //lista visible
		document.all['btnVerFicha'].focus();
	}
}

function buscarOnShTab() {
	if(document.getElementById('cbZona').disabled==false){
		focaliza(FORMULARIO+'.cbZona');
	}else{
		if(document.getElementById('txtDocIdentidad').disabled==false){
			focaliza(FORMULARIO+'.txtDocIdentidad');
		}else{
			focaliza(FORMULARIO+'.txtCodCliente');
		}
	}
}

function docIdentidadOnTab() {
	var docIdentidad = get(FORMULARIO+'.txtDocIdentidad');
	var tipoDoc = get(FORMULARIO+'.cbTipoDoc');
	if(docIdentidad!="" && tipoDoc!=""){
		document.all['btnBuscar'].focus();
	}else{
		focaliza(FORMULARIO+'.txtApellido1');
	}
}

function tipoDocOnShTab() {
	var oidTipoDocumento = get(FORMULARIO+'.cbTipoDoc');
	var docIdentidad = get(FORMULARIO+'.txtDocIdentidad');
	if(oidTipoDocumento!="" && docIdentidad!=""){
		if(listado1.datos.length==0){ //lista no visible
			document.all['btnBuscar'].focus();
		}else{ //lista visible
			document.all['btnVerFicha'].focus();
		}
	}else{
		focaliza(FORMULARIO+'.txtCodCliente');
	}
}

function verFichaOnTab() {
	if(document.getElementById('txtCodCliente').disabled==false){
		focaliza(FORMULARIO+'.txtCodCliente');
	}else{
		focaliza(FORMULARIO+'.cbTipoDoc');
	}
}

function verFichaOnShTab() {
	document.all['btnBuscar'].focus();
}

function codigoClienteOnChange() {
	//Si se ha rellenado el campo txtCodigoCliente con algún valor
	//Deshabilitar el resto de campos de la PGBuscarClientes
	var codigoCliente = get(FORMULARIO+'.txtCodCliente');
	codigoCliente=codigoCliente.toUpperCase();
	set(FORMULARIO+'.txtCodCliente', codigoCliente);
	if(codigoCliente!=""){
		var longitudCodigoCliente = get(FORMULARIO + '.longitudCodigoCliente').toString();
		var longitud = codigoCliente.length;
		deshabilitarTodos();
		borrarTodos();
		document.getElementById('txtCodCliente').disabled=false;
		set(FORMULARIO + '.txtCodCliente', rellenaCeros(codigoCliente, longitudCodigoCliente, longitud));
	}else{
		habilitarTodos();
	}
}

function tipoDocumentoOnChange() {
	//Si se ha seleccionado algún elemento en la cbTipoDocumento 
	//y existe algún valor en el campo txtDocIdentidad 
	//Deshabilitar el resto de campos de la PGBuscarClientes: 
	var oidTipoDocumento = get(FORMULARIO+'.cbTipoDoc');
	var docIdentidad = get(FORMULARIO+'.txtDocIdentidad');
	if(oidTipoDocumento!="" && docIdentidad!=""){
		deshabilitarTodos();	
		borrarTodos();
		document.getElementById('cbTipoDoc').disabled=false;
		document.getElementById('txtDocIdentidad').disabled=false;
		set(FORMULARIO + '.cbTipoDoc', oidTipoDocumento);
		set(FORMULARIO + '.txtDocIdentidad', docIdentidad);
	}else{
		habilitarTodos();
	}
}

function docIdentidadOnChange () {
	//Si se ha seleccionado algún elemento en la cbTipoDocumento 
	//y existe algún valor en el campo txtDocIdentidad 
	//Deshabilitar el resto de campos de la PGBuscarClientes: 
	tipoDocumentoOnChange();
}

function marcaOnChange () {
	//Si se ha seleccionado un registro en la combo cbMarca y en la combo cbCanal 
	var oidMarca = get(FORMULARIO+'.cbMarca');
	var oidCanal = get(FORMULARIO+'.cbCanal');
	
	set_combo(FORMULARIO +'.cbSubgerenciaVentas',['',''],['']);
	set_combo(FORMULARIO +'.cbRegion',['',''],['']);
	set_combo(FORMULARIO +'.cbZona',['',''],['']);


	if(oidMarca!="" && oidCanal!=""){
		var idBusiness="ZONRecargaSubgerenciaVentas";
		var dtoUnidAdmin= "es.indra.sicc.dtos.zon.DTOUnidadAdministrativa";
		recargaCombo(FORMULARIO+'.cbSubgerenciaVentas', idBusiness, dtoUnidAdmin, [['oidMarca',oidMarca],["oidCanal", oidCanal]]);
	}
}

function canalOnChange () {
	//Si se ha seleccionado un registro en la combo cbMarca y en la combo cbCanal: 
	var oidMarca = get(FORMULARIO+'.cbMarca');
	var oidCanal = get(FORMULARIO+'.cbCanal');

	set_combo(FORMULARIO +'.cbSubgerenciaVentas',['',''],['']);
	set_combo(FORMULARIO +'.cbRegion',['',''],['']);
	set_combo(FORMULARIO +'.cbZona',['',''],['']);

		
	if(oidMarca!="" && oidCanal!=""){
		var idBusiness="ZONRecargaSubgerenciaVentas";
		var dtoUnidAdmin= "es.indra.sicc.dtos.zon.DTOUnidadAdministrativa";
		recargaCombo(FORMULARIO+'.cbSubgerenciaVentas', idBusiness, dtoUnidAdmin, [['oidMarca',oidMarca],["oidCanal", oidCanal]]);
	}
}

function subgerenciaVentasOnChange () {
	//Si se ha seleccionado un registro en la combo cbMarca y en la combo cbCanal 
	var oidMarca = get(FORMULARIO+'.cbMarca');
	var oidCanal = get(FORMULARIO+'.cbCanal');
	var oidSGV = get(FORMULARIO+'.cbSubgerenciaVentas');

	set_combo(FORMULARIO +'.cbRegion',['',''],['']);
	set_combo(FORMULARIO +'.cbZona',['',''],['']);

	if(oidMarca!="" && oidCanal!="" && oidSGV!=""){
		var idBusiness="ZONRecargaRegiones";
		var dtoUnidAdmin= "es.indra.sicc.dtos.zon.DTOUnidadAdministrativa";
		recargaCombo(FORMULARIO+'.cbRegion', idBusiness, dtoUnidAdmin, [['oidMarca',oidMarca],["oidCanal", oidCanal],["oidSGV", oidSGV]]);
	}
}

function regionOnChange () {
	//Si se ha seleccionado un registro en la combo cbMarca y en la combo cbCanal
	var oidMarca = get(FORMULARIO+'.cbMarca');
	var oidCanal = get(FORMULARIO+'.cbCanal');
	var oidSGV = get(FORMULARIO+'.cbSubgerenciaVentas');
	var oidRegion = get(FORMULARIO+'.cbRegion');

	set_combo(FORMULARIO +'.cbZona',['',''],['']);	

	if(oidMarca!="" && oidCanal!="" && oidRegion!="" ){
		var idBusiness="ZONRecargaZonas";
		var dtoUnidAdmin= "es.indra.sicc.dtos.zon.DTOUnidadAdministrativa";
		recargaCombo(FORMULARIO+'.cbZona', idBusiness, dtoUnidAdmin, [['oidMarca',oidMarca],["oidCanal", oidCanal],["oidSGV", oidSGV],["oidRegion", oidRegion]]);
	}
}

function accionBuscarClientePropia(){
    // Si la caja de texto del código cliente está deshabilitada, no muestro la modal
    // de búsqueda de cliente

    if(document.getElementById('txtCodCliente').disabled==false){
        accionBuscarCliente();
    }
}