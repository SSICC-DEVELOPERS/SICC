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
    $Id: contenido_fechas_cronograma_consultar.js,v 1.1 2009/12/03 19:01:56 pecbazalar Exp $
    DESC
*/
var FORMULARIO = 'formulario';
function onLoadPag()   { 
	if (get(FORMULARIO+'.errDescripcion')!='') {
	
	      var wnd = fMostrarMensajeError(get(FORMULARIO+'.errCodigo'),get(FORMULARIO+'.errDescripcion'));
	}
	
	configurarMenuSecundario(FORMULARIO);
	
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
	
	var idioma = get(FORMULARIO+'.idioma');
	var pais = get(FORMULARIO+'.pais');
	var oidPeriodo = get(FORMULARIO+'.oidPeriodo');
	var oidZona = get(FORMULARIO+'.oidZona');
	var DTOConsultarFechasCronograma = "es.indra.sicc.dtos.cal.DTOConsultarFechasCronograma";
	configurarPaginado(mipgndo, "CALConsultarFechasCronograma", "ConectorConsultarFechasCronograma", DTOConsultarFechasCronograma, 
			[["oidPais", pais], 
			  ["oidIdioma", idioma], 
			  ["oidPeriodo", oidPeriodo], 
			  ["oidZona", oidZona]] );
			  
	eval (ON_RSZ);
	
}

function fVolver(){
	window.returnValue=get(FORMULARIO+'.oidContacto');
	window.close();            
}

 

function unLoadPag(){
            window.returnValue=get(FORMULARIO+'.oidContacto');
}


function visibleLista() {
         DrdEnsanchaConMargenDcho('listado1',12);
         visibilidad('capaLista','V');
         eval (ON_RSZ);  
}

/* Se elimina por incidencia 13078
function invisibleLista() {
         visibilidad('capaLista','V');
}*/

function muestraLista(ultima, rowset){
	var tamano = rowset.length;
	//if (tamano > 0) {
	visibleLista();
	if (tamano>0) {
		 return true;
	}else {
		 return false;
	}
			 
	/*} else {
		invisibleLista();
		return false;
	}*/
}