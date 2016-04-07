
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
    $Id: contenido_pagos_reasignar.js,v 1.1 2009/12/03 19:01:52 pecbazalar Exp $
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

	if(!sicc_validaciones_generales()){
		return;
	}
	//verificamos que se rellenen al menos 3 criterios de busqueda...
	if(cuentaCriterios()<3){
		GestionarMensaje("UIPED030");
		focaliza(FORMULARIO+'.cbBanco');
		return;
	}
	if(get(FORMULARIO + ".importeDesde").toString()!=""){//verificamos los montos desde/hasta
		if(get(FORMULARIO + ".importeHasta").toString()!=""){
			var desde = new Number(get(FORMULARIO + ".importeDesde"));
			var hasta = new Number(get(FORMULARIO + ".importeHasta"));
			if(desde > hasta){
				cdos_mostrarAlert(GestionarMensaje("CobEtapaDeuda.impHastimpDesd.message"));
				focaliza(FORMULARIO + ".importeDesde");
				return;
			}
		}
	}
	//Invocamos el "subsystema:paginacion" con IdBusiness="CCCBuscarConfirmarMovBanc"  DTOBuscarConfirmarMovBanc 
	var params = obtenerParametros();
	configurarPaginado(mipgndo, "CCCObtenerMovimientosReasignar", "ConectorBuscarMovimientosReasignar", "es.indra.sicc.dtos.ccc.DTOBuscarMovimientosReasignacion", params);
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
	set(FORMULARIO + ".cbBanco","");
	set(FORMULARIO + ".cbRegion","");
	set(FORMULARIO + ".FechaMov","");
	set(FORMULARIO + ".NLote","");
	set(FORMULARIO + ".consecutivoTransaccion","");
	set(FORMULARIO + ".codigoCliente","");
	set(FORMULARIO + ".nroCupon","");
	set(FORMULARIO + ".nroBoletaFactura","");
	set(FORMULARIO + ".importeDesde","");
	set(FORMULARIO + ".importeHasta","");
	ocultarLista();
	vaciaCombo(FORMULARIO + '.cbCCC');
	vaciaCombo(FORMULARIO + '.cbZona');
	focaliza(FORMULARIO + ".cbBanco");
}

function fVolver(){
	window.close();
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

	function regionOnChange(){
		var region = get(FORMULARIO + '.cbRegion');
		if (region != "") {
			var idioma = get(FORMULARIO + '.idioma');
			var pais = get(FORMULARIO + '.pais');
			recargaCombo(FORMULARIO + '.cbZona', 'ZONObtenerZonasSinFiltro', 'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa',  [["oidPais", pais], ["oidIdioma", idioma], ["oidRegion", region]], '');
		}else{
			vaciaCombo(FORMULARIO + '.cbZona');
		}
	}

	function vaciaCombo(combo) {
		set_combo(combo, [['','']], ['']);
	}


	function consultarDetalle() {
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
				objParams.numeroMovimiento = listado1.codSeleccionados();
				mostrarModalSICC('LPReasignacionPagos', 'detalle', objParams, null, null);
			} 
		}
	}

	function limpiarLista() {
		listado1.setDatos(new Array);
		ocultarLista();
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
		document.all["DetalleDiv"].style.visibility='visible';
		document.all["ConsultaDiv"].style.visibility='visible';
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
		document.all["DetalleDiv"].style.visibility='hidden';
		document.all["ConsultaDiv"].style.visibility='hidden';
	}

function focalizaPagina(componente){
	if(componente==null||componente.split(" ").join("")==""){return;}
	if(componente=="Confirmar"){//si no puedo ir a este voy al buscar
		try{
			focaliza(FORMULARIO +"."+componente);
		}catch(e){
			try{
				document.all.tags("INPUT")["btnBuscar"].focus();
			}catch(e){
				;//alert(e.description);
			}
		}
	}else if(componente=="Detalle"){//si no puedo ir a este voy al combo de bancos
		try{
			focaliza(FORMULARIO +"."+componente);
		}catch(e){
			try{
				focaliza(FORMULARIO + ".cbBanco");
			}catch(e){
				;//alert(e.description);
			}
		}
		
	}
}

function consultarCC(){
	if (listado1.numSelecc() == 0) {
			// Muestra el mensaje: "Debe seleccionar un elemento de la lista"
			GestionarMensaje('50');
	} else {
		if (listado1.numSelecc() != 1 ) {
			//Muesta el mensaje: "Debe seleccionar un solo registro"
			GestionarMensaje('8');
			// por los requisitos generales se deseleccionan todos los registros
			for (i = 0; i < listado1.datos.length; i++){
				listado1.deselecciona(i);
			}
		} else {
			var objParams=new Object();
			var seleccion = listado1.codSeleccionados();
			for(i=0;i<listado1.datos.length;i++){
				if(listado1.datos[i][0]==seleccion){
					objParams.codigoConsultora = listado1.datos[i][2];
					break;
				}
			}
			objParams.casoDeUso="reasignarPagos";
			mostrarModalSICC('CCCConsultaCC', 'generarConsulta', objParams, null, null);
		} 
	}
	
}

function cuentaCriterios(){
	//contamos los criterios de busqueda con valor y devolvemos la suma
	var criterio = 0;
	if(get(FORMULARIO + ".cbBanco").toString()!=""){criterio+=1;}
	if(get(FORMULARIO + ".cbCCC").toString()!=""){criterio+=1;}
	if(get(FORMULARIO + ".FechaMov").toString()!=""){criterio+=1;}
	if(get(FORMULARIO + ".NLote").toString()!=""){criterio+=1;}
	if(get(FORMULARIO + ".consecutivoTransaccion").toString()!=""){criterio+=1;}
	if(get(FORMULARIO + ".codigoCliente").toString()!=""){criterio+=1;}
	if(get(FORMULARIO + ".cbRegion").toString()!=""){criterio+=1;}
	if(get(FORMULARIO + ".cbZona").toString()!=""){criterio+=1;}
	if(get(FORMULARIO + ".nroCupon").toString()!=""){criterio+=1;}
	if(get(FORMULARIO + ".nroBoletaFactura").toString()!=""){criterio+=1;}
	if(get(FORMULARIO + ".importeDesde").toString()!=""){criterio+=1;}
	if(get(FORMULARIO + ".importeHasta").toString()!=""){criterio+=1;}
	return criterio;
}

function buscarCliente(){
	var objParams = new Object();
	var cliente = mostrarModalSICC('LPBusquedaRapidaCliente', '', objParams, null, null);
	if (cliente != null && cliente.length > 1) {
		set(FORMULARIO+'.codigoCliente', cliente[1].toString());
		set(FORMULARIO+'.oidCliente', cliente[0].toString());
	}
}

function obtenerParametros(){
	var salida = new Array();
	salida[salida.length] = ['oidPais', get(FORMULARIO+'.pais')];
	salida[salida.length] = ['oidIdioma', get(FORMULARIO+'.idioma')];
	if(get(FORMULARIO+'.cbBanco')!=null && get(FORMULARIO+'.cbBanco').toString()!=""){
		salida[salida.length] = ['oidBanco', get(FORMULARIO+'.cbBanco').toString()];
	}
	if(get(FORMULARIO+'.cbCCC')!=null && get(FORMULARIO+'.cbCCC').toString()!=""){
		salida[salida.length] = ['oidCuentaCorrienteBancaria', get(FORMULARIO+'.cbCCC').toString()];
	}
	if(get(FORMULARIO+'.FechaMov')!=null && get(FORMULARIO+'.FechaMov').toString()!=""){
		salida[salida.length] = ['fechaPago', get(FORMULARIO+'.FechaMov').toString()];
	}
	if(get(FORMULARIO+'.NLote')!=null && get(FORMULARIO+'.NLote').toString()!=""){
		salida[salida.length] = ['numeroLote', get(FORMULARIO+'.NLote').toString()];
	}
	if(get(FORMULARIO+'.consecutivoTransaccion')!=null && get(FORMULARIO+'.consecutivoTransaccion').toString()!=""){
		salida[salida.length] = ['numeroConsecutivoTransaccion', get(FORMULARIO+'.consecutivoTransaccion').toString()];
	}
	if(get(FORMULARIO+'.oidCliente')!=null && get(FORMULARIO+'.oidCliente').toString()!=""){
		salida[salida.length] = ['oidCliente', get(FORMULARIO+'.oidCliente').toString()];
	}
	if(get(FORMULARIO+'.cbRegion')!=null && get(FORMULARIO+'.cbRegion').toString()!=""){
		salida[salida.length] = ['oidRegion', get(FORMULARIO+'.cbRegion').toString()];
	}
	if(get(FORMULARIO+'.cbZona')!=null && get(FORMULARIO+'.cbZona').toString()!=""){
		salida[salida.length] = ['oidZona', get(FORMULARIO+'.cbZona').toString()];
	}
	if(get(FORMULARIO+'.nroCupon')!=null && get(FORMULARIO+'.nroCupon').toString()!=""){
		salida[salida.length] = ['numeroCupon', get(FORMULARIO+'.nroCupon').toString()];
	}
	if(get(FORMULARIO+'.nroBoletaFactura')!=null && get(FORMULARIO+'.nroBoletaFactura').toString()!=""){
		salida[salida.length] = ['numeroBolFact', get(FORMULARIO+'.nroBoletaFactura').toString()];
	}
	if(get(FORMULARIO+'.importeDesde')!=null && get(FORMULARIO+'.importeDesde').toString()!=""){
		salida[salida.length] = ['importePagoDesde', get(FORMULARIO+'.importeDesde').toString()];
	}
	if(get(FORMULARIO+'.importeHasta')!=null && get(FORMULARIO+'.importeHasta').toString()!=""){
		salida[salida.length] = ['importePagoHasta', get(FORMULARIO+'.importeHasta').toString()];
	}
	if(get(FORMULARIO+'.codigoCliente')!=null && get(FORMULARIO+'.codigoCliente').toString()!=""){
		salida[salida.length] = ['codigoCliente', get(FORMULARIO+'.codigoCliente').toString()];
	}
	return salida;
}

function completarCodigoCliente(){
	set(FORMULARIO+'.oidCliente', '');
	var codigoActual = get(FORMULARIO +'.codigoCliente');
	if((codigoActual+"")==""){return;}
	var longitud = get(FORMULARIO +'.longitudCodigo');
	if(isNaN(parseInt(longitud,10))){return;}
	longitud = new Number(longitud);//forzamos la conversion a numero
	var largoActual = codigoActual.length;
	if(largoActual==longitud){return;}
	var salida = "";
	for(var i=0; i<longitud;i++){
		if(i+largoActual<longitud){
			salida = salida+"0";
		}else{
			salida = (salida+"")+(codigoActual+"");
			break;
		}
	}
	set(FORMULARIO+'.codigoCliente',salida);
	return true;
}

function buscarReceptor(){
	if (listado1.numSelecc() == 0) {
			// Muestra el mensaje: "Debe seleccionar un elemento de la lista"
			GestionarMensaje('50');
	} else {
		if (listado1.numSelecc() != 1 ) {
			//Muesta el mensaje: "Debe seleccionar un solo registro"
			GestionarMensaje('8');
			// por los requisitos generales se deseleccionan todos los registros
			for (i = 0; i < listado1.datos.length; i++){
				listado1.deselecciona(i);
			}
		} else {
			var objParams=new Object();
			var seleccion = listado1.codSeleccionados();
			for(i=0;i<listado1.datos.length;i++){
				if(listado1.datos[i][0]==seleccion){
					objParams.datosSeleccionados = listado1.datos[i];
					break;
				}
			}
			objParams.casoDeUso="reasignarPagos";
			var salida = mostrarModalSICC('LPReasignacionPagos', 'reasignar_paso_previo', objParams, null, null);
			if(salida){
				fLimpiar();
			}
		} 
	}
}