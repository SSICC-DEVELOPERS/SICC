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
var oidCliente="";
var codCliente="";
var nombreApellidos="";
var numeroZona="";
var estadoCliente="";
var oidTerriAdmin="";
function onLoadPag() {
	DrdEnsanchaConMargenDcho('listado1',12);
	DrdEnsanchaConMargenDcho('listado2',12);
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


	
	eval (ON_RSZ);  
	if (get(FORMULARIO+'.errDescripcion')!='') {
		var wnd = fMostrarMensajeError(get(FORMULARIO+'.errCodigo'),get(FORMULARIO+'.errDescripcion'));
	}
	configurarMenuSecundario(FORMULARIO);

	document.all['Aceptar2'].disabled=true;
	document.all['Buscar'].disabled=true;
	datos = get(FORMULARIO + '.oidCliente').split('@@');
	if (datos.length <= 1){
		paginadoClientes();
	} else{
		oidCliente = datos[0];
		codCliente= datos[2];
		nombreApellidos= datos[3];
		nombreApellidos = nombreApellidos.replace("¿?","'");// SiCC 20070200
		numeroZona= datos[4];
		estadoCliente= datos[5];
		oidTerriAdmin= datos[1];
		visibilidad('capaClientes','O');
		
		document.all["Cplistado2"].style.top = "12px";
		document.all["CpLin1listado2"].style.top = "12px";
		document.all["CpLin2listado2"].style.top = "12px";
		document.all["CpLin3listado2"].style.top = "328px";
		document.all["CpLin4listado2"].style.top = "12px";
		document.all["primera2Div"].style.top= "310px";
		document.all["ret2Div"].style.top= "310px";
		document.all["ava2Div"].style.top= "310px";
		document.all["separa2Div"].style.top= "306px";
		document.all["Aceptar2Div"].style.top= "307px";

		paginadoDocumento(oidCliente);
		
		
	}
	
}

function paginadoClientes(){

	var idioma=get(FORMULARIO+'.idioma');
	var pais=get(FORMULARIO+'.pais');
	var hTxtCodCliente=get(FORMULARIO+'.hTxtCodCliente');
	var hTxtNombre=get(FORMULARIO+'.hTxtNombre');
	var hTxtApellidoPaterno=get(FORMULARIO+'.hTxtApellidoPaterno');
	var hTxtApellidoMaterno=get(FORMULARIO+'.hTxtApellidoMaterno');
	var hTxtNumeroDocumento=get(FORMULARIO+'.hTxtNumeroDocumento');
	configurarPaginado(mipgndo1, 
					   "RECObtenerClientesIntroducir", 
					   "ConectorObtenerClientesRECLin",
		               "es.indra.sicc.dtos.rec.DTOBuscarClientesREC", 
					   [ ["oidPais",pais],
		                 ["oidIdioma",idioma],
		                 ["codigoCliente",hTxtCodCliente],
		                 ["nombre",hTxtNombre],
		                 ["apellidoPaterno",hTxtApellidoPaterno],
		                 ["apellidoMaterno",hTxtApellidoMaterno],
		                 ["numDocumento",hTxtNumeroDocumento]
		                ]);	
	
}

function buscarDocumento(){
	/* Por ssantana, 09/05/2006, inc. DBLG500000594 y DBLG500000595 - 
	 * Se agrega "numDocumento" al filtro del paginado, si existe */
	var idioma=get(FORMULARIO+'.idioma');
	var pais=get(FORMULARIO+'.pais');	
	var numDocumento = get(FORMULARIO + ".hTxtNumeroDocumento");
	var arrayParam = new Array(); 

	if (listado1.numSelecc() == 0) {
	   GestionarMensaje('50');	
	   return;
	} else if (listado1.numSelecc() != 1 ) {	
	   GestionarMensaje('8');
	   var seleccion=listado1.codigos();
	   var i=0;
	   while(seleccion[i]!=null){
		   listado1.deselecciona(i); 
		   i++;             
	   }
	   return;
    }
	var oid = listado1.codSeleccionados();
	oidCliente=oid;	
	codCliente=listado1.extraeDato(oid,0);
	nombreApellidos=listado1.extraeDato(oid,1);
	numeroZona=listado1.extraeDato(oid,2);
	estadoCliente=listado1.extraeDato(oid,3);      
	oidTerriAdmin=listado1.extraeDato(oid,4);  

	arrayParam[0] = ["oidPais", pais];
	arrayParam[1] = ["oidIdioma", idioma];
	arrayParam[2] = ["oidCliente", oidCliente];

	if (numDocumento != '') {
	  	arrayParam[3] = ["numDocumento", numDocumento];
	}

	configurarPaginado(mipgndo2, 
					   "RECObtenerDocumento", 
		               "ConectorObtenerDocumentoPagREC",
		               "es.indra.sicc.dtos.rec.DTOBuscarClientesREC", 
		               arrayParam);	
	
}

function paginadoDocumento(oid){
	/* Por ssantana, 09/05/2006, inc. DBLG500000594 y DBLG500000595 - 
	 * Se agrega "numDocumento" al filtro del paginado, si existe */
	var idioma=get(FORMULARIO+'.idioma');
	var pais=get(FORMULARIO+'.pais');
	var numDocumento = get(FORMULARIO + ".hTxtNumeroDocumento")
	var arrayParam = new Array(); 

	arrayParam[0] = ["oidPais", pais];
	arrayParam[1] = ["oidIdioma", idioma];
	arrayParam[2] = ["oidCliente", oid];

	if (numDocumento != '') {
	  	arrayParam[3] = ["numDocumento", numDocumento];
	}

	configurarPaginado(mipgndo2, 
					   "RECObtenerDocumento", 
		               "ConectorObtenerDocumentoPagREC",
		               "es.indra.sicc.dtos.rec.DTOBuscarClientesREC", 
		               arrayParam);
}
function fVolver(){
	
	window.returnValue=undefined;
	window.close();			
		
}
function onClickAceptar(){
	var idioma=get(FORMULARIO+'.idioma');
	var pais=get(FORMULARIO+'.pais');	
         if (listado2.numSelecc() == 0) {
                  GestionarMensaje('50');	
                  return;
         } else if (listado2.numSelecc() != 1 ) {	
                  GestionarMensaje('8');
                  var seleccion=listado2.codigos();
                  var i=0;
                  while(seleccion[i]!=null){
                           listado2.deselecciona(i); 
                           i++;             
                  }
                  return;
         }
	var oid = new String(listado2.codSeleccionados()); 
	objeto=new Object();
	objeto.oidDocumento=oid;
	objeto.codigoOperacion=listado2.extraeDato(oid,1);
	objeto.canal=listado2.extraeDato(oid,7);
	objeto.acceso=listado2.extraeDato(oid,8);
	objeto.subAcceso=listado2.extraeDato(oid,9);
	objeto.oidPeriodo=listado2.extraeDato(oid,10);
	objeto.codigoCliente=codCliente;
	objeto.nombreApellidos=nombreApellidos;
	objeto.numeroZona=numeroZona;
	objeto.estadoCliente=estadoCliente;  
	objeto.oidCliente=oidCliente;
	objeto.oidTerriAdmin=oidTerriAdmin;
	objeto.moneda = listado2.extraeDato(oid,11);
	objeto.hFechaIngreso = listado2.extraeDato(oid,12);
	window.returnValue=objeto;
	window.close();
         	
}

function muestraLista( ultima, rowset){
                  
         var tamano = rowset.length;
         if (tamano > 0) {
                  //visibleLista();
                  document.all['Buscar'].disabled=false;
                  return true;
         } else {
         	document.all['Buscar'].disabled=true;
                  //novisibleLista();
                  //cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
                  //window.close();   
                  //document.all['Aceptar2'].disabled=true;
                  //document.all['Buscar'].disabled=true;
                  return true;
         }
         
}

function muestraLista2(ultima, rowset){
         var tamano = rowset.length;
         if (tamano > 0) {
                  //visibleLista();
				  if ( tamano == 1) {
					 objeto=new Object();
					 objeto.oidDocumento = rowset[0][0];
					 objeto.codigoOperacion = rowset[0][2];
					 objeto.canal = rowset[0][8]; 
					 objeto.acceso = rowset[0][9];
					 objeto.subAcceso = rowset[0][10];
					 objeto.oidPeriodo = rowset[0][11];
					 objeto.codigoCliente = codCliente;
					 objeto.nombreApellidos=nombreApellidos;
					 objeto.numeroZona=numeroZona;
					 objeto.estadoCliente=estadoCliente;  
					 objeto.oidCliente=oidCliente;
					 objeto.oidTerriAdmin=oidTerriAdmin;
					 objeto.hFechaIngreso = rowset[0][13];
					 window.returnValue=objeto;
					 window.close();
					 return false;
				  }
                  document.all['Aceptar2'].disabled=false;
                  return true;
         } else {
                  //novisibleLista();extraeDato(oid,numCol)
                  //cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
                  //window.close();   
                  document.all['Aceptar2'].disabled=true;                 
                  return false;
         }	
}