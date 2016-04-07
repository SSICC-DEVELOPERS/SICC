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
	/*         
	Llamamos a configurarPaginado pasándole los siguientes parametros: 
	- Objeto paginado (lstResultados) 
	- idBusiness ("COMDetalleComisionesPagar") 
	- "ConectorDetalleComisionesPagar" 
	- "DTOOid" 
	- Parametros del DTOOIDPaginado: 
	- oidComision*/
	
	if (get(FORMULARIO+'.errDescripcion')!='') {
	      var wnd = fMostrarMensajeError(get(FORMULARIO+'.errCodigo'),get(FORMULARIO+'.errDescripcion'));
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
	document.all["btnPagarComisionDiv"].style.visibility='';
	
	eval (ON_RSZ);  
	
	//Se obtiene el oid
	var oid = get(FORMULARIO+'.oidComision');
  var fechaCalculo = get(FORMULARIO+'.txtFechaCalculo');
  var formatoFecha= get(FORMULARIO+'.hFormatoFechaPais');
	var oidPais = get(FORMULARIO+'.pais');
	var oidIdioma = get(FORMULARIO+'.idioma');         
	
	configurarPaginado(mipgndo,'COMDetalleComisionesPagar','ConectorDetalleComisionPagar','es.indra.sicc.dtos.com.DTODatosPagarComision',
  [['oidComision', oid],
  ["fechaCalculo", fechaCalculo],
  ["formatoFecha", formatoFecha],
  ["oidPais", oidPais],
  ["oidIdioma", oidIdioma]]);
	
	configurarMenuSecundario(FORMULARIO);     
	
	document.all["btnPagarComision"].focus();
	
}

function onClickPagarComision(){
	/*El usuario selecciona pagar la comision a todos los clientes del detalle. No se podrá seleccionar ningun registro, se paga a todos. 
	Llama a la LPPagarCOM con: 
	- oidComision 
	- accion="Pagar Comision"*/
	
	/*para coger todos los OIDs de una lista editable
	if(listado1.datos.length>0){
		var oids=new String (listado1.datos[0][0]);
		for(i=1;i<listado1.datos.length;i++){
			oids=oids+"|"+listado1.datos[i][0];			
		}				
		set(FORMULARIO+'.listaOids',oids);
	}	
	alert ("OIDS: "+oids);*/
	set(FORMULARIO+'.accion','Pagar');
	set(FORMULARIO+'.conectorAction','LPPagarCOM');
	enviaSICC(FORMULARIO);

}

function tabulador(){
	document.all["btnPagarComision"].focus();	
}

function fVolver(){
	window.close();	
}

function accionCorrecta(){
	window.returnValue = 'OK';
	window.close();	
}


function muestraLista(ultima, rowset){
     var tamano = rowset.length;
     if (tamano > 0) {
         deshabilitarHabilitarBoton('botonContenido','btnPagarComision','A');
         return true;
     } else {
         deshabilitarHabilitarBoton('botonContenido','btnPagarComision','D');
         return false;
     }
}

