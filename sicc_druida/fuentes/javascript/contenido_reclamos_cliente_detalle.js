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

var FORMULARIO = 'frmContenido';
var capa;

function onLoadPag()   { 
	
	if (get(FORMULARIO+'.errDescripcion')!='') {
		var wnd = fMostrarMensajeError(get(FORMULARIO+'.errCodigo'),get(FORMULARIO+'.errDescripcion'));
	}
		
	document.all["Cplistado1"].style.visibility='';
	document.all["CpLin1listado1"].style.visibility='';
	document.all["CpLin2listado1"].style.visibility='';
	document.all["CpLin3listado1"].style.visibility='';
	document.all["CpLin4listado1"].style.visibility='';
	document.all["Cplistado2"].style.visibility='';
	document.all["CpLin1listado2"].style.visibility='';
	document.all["CpLin2listado2"].style.visibility='';
	document.all["CpLin3listado2"].style.visibility='';
	document.all["CpLin4listado2"].style.visibility='';
	
	document.all["primera1Div"].style.visibility='';
	document.all["ret1Div"].style.visibility='';
	document.all["ava1Div"].style.visibility='';
	document.all["separa1Div"].style.visibility='';
	document.all["primera2Div"].style.visibility='';
	document.all["ret2Div"].style.visibility='';
	document.all["ava2Div"].style.visibility='';
	document.all["separa2Div"].style.visibility='';	
	
	configurarMenuSecundario(FORMULARIO);
    
    btnProxy(2, '1');
    
	/*
	Llamamos a configurarPaginado pasándole los siguientes parametros: 
	- Objeto paginado (lstReclamos) 
	- idBusiness ("RECConsultarReclamosCliente") 
	- "ConectorConsultarReclamosCliente" 
	- "DTOOidPaginado" 
	- Parametros del DTOOidPaginado: (además del pais y el idioma) 
	- oid = oidCliente */
	
	var oidCliente = get(FORMULARIO+'.oidCliente');
	var oidPais = get(FORMULARIO + '.pais');
	var oidIdioma = get(FORMULARIO + '.idioma');
	var IDBusiness = "RECConsultarReclamosCliente";
	var DTOOIDPaginado = 'es.indra.sicc.cmn.negocio.comun.DTOComunes.DTOOIDPaginado';
	capa = "capaLista";
	configurarPaginado(mipgndo, IDBusiness, "ConectorConsultarReclamosCliente", DTOOIDPaginado, 
	[["oid",oidCliente],
	["oidPais", oidPais],
	["oidIdioma", oidIdioma]]);
	window.setTimeout("repintaListas()",10);

}

function repintaListas(){
	DrdEnsanchaConMargenDcho('listado1',12);
	DrdEnsanchaConMargenDcho('listado2',12);
	eval (ON_RSZ); 
}



function onClickDetalle(){
	/*
	Si se ha seleccionado un registro de la lstReclamos { 
	Llamamos a configurarPaginado pasándole los siguientes parametros: 
	- Objeto paginado (lstDetalle) 
	- idBusiness ("RECConsultarDetalleReclamo") 
	- "ConectorConsultarDetalleReclamo" 
	- "DTOOidPaginado" 
	- Parametros del DTOOidPaginado: (además del pais y el idioma) 
	- oid = oidCabeceraReclamo del registro seleccionado 
	} 
	En otro caso { 
	Mostrar error correspondiente 
	}*/

	if (listado1.numSelecc() == 0) {
		// Muestra el mensaje: "Debe seleccionar un elemento de la lista"
		GestionarMensaje('50');
	} else {
		if (listado1.numSelecc() != 1 ) {
			//Muesta el mensaje: "Debe seleccionar un solo registro"
			GestionarMensaje('8');
		} else {
			var oidCabeceraReclamo = listado1.codSeleccionados();
			var oidPais = get(FORMULARIO+'.idioma');
			var oidIdioma = get(FORMULARIO+'.pais');	
			var IDBusiness = "RECConsultarDetalleReclamo";
			var DTOOIDPaginado = 'es.indra.sicc.cmn.negocio.comun.DTOComunes.DTOOIDPaginado';
			capa = "capaLista2";
			configurarPaginado(mipgndo2, IDBusiness, "ConectorConsultarDetalleReclamo", DTOOIDPaginado, 
			[ ["oid",oidCabeceraReclamo],
			["oidPais", oidPais],
			["oidIdioma", oidIdioma]]);
		}
	}
}

function visibleLista(capa) {
	if (capa=='capaLista'){
		DrdEnsanchaConMargenDcho('listado1',12);
	}else{
		DrdEnsanchaConMargenDcho('listado1',12);
		DrdEnsanchaConMargenDcho('listado2',12);
	}
		
	visibilidad(capa,'V');
	eval(ON_RSZ);  
	//ON_RSZ="";  
}

function invisibleLista(capa) {
	visibilidad(capa,'O');
}

function muestraLista(ultima, rowset, capa){
	var tamano = rowset.length;
	if (tamano > 0) {
		visibleLista(capa);
		if (capa=='capaLista') {
			document.all['Aceptar'].focus();
		}
		return true;
	} else {
		invisibleLista(capa);
		return false;
	}
}

function fVolver(){
    window.close();
}
