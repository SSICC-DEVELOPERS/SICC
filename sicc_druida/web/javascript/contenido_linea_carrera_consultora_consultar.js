/**
* Copyright 2005 � por Indra Sistemas,S.A.. Todos los derechos reservados.
* Avda. de Bruselas, 35
* Parque Empresarial Arroyo de la Vega
* 28108 Alcobendas, Madrid
* Espa�a
*
* Privado y Confidencial.
* La informaci�n contenida en este documento es propiedad de Indra sistemas.
* Para uso exclusivo de empleados autorizados no permiti�ndose
* la distribuci�n de este c�digo sin permiso expreso.
*/ 

var FORMULARIO = 'formulario';

function onLoadPag()   {
  
	if (get(FORMULARIO+'.errDescripcion')!='') {	
		var wnd = fMostrarMensajeError(get(FORMULARIO+'.errCodigo'),get(FORMULARIO+'.errDescripcion'));
	}
	
	
	DrdEnsanchaConMargenDcho('listado1',12);
	eval (ON_RSZ);  
	configurarMenuSecundario(FORMULARIO);       
		
} 

  function fVolver(){
    window.returnValue=get(FORMULARIO+'.oidContacto');
 	window.close();            
 }
  function unLoadPag(){
     window.returnValue=get(FORMULARIO+'.oidContacto');
 }

 

