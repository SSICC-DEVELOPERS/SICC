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

/*$Id*/



function initPagina()
{

	// Agregado by ssantana, 8/8/2005
	fMostrarMensajeError();
	// Fin agregado by ssantana, 8/8/2005

	var array = new Array();
	var listaOid = get("frmFichero.oidListaCreada");

	if ( listaOid == null || listaOid == "")
		array[0] = "";
	else
		array[0] = listaOid;


	returnValue = array[0];
	window.close();


}

function fVolver() 
{
	returnValue = null;
	window.close();

}


function fmCargarBarra() 
{
	
	document.body.onkeydown  = inhabilitaTab;
	configurarMenuSecundario("frmFichero");
	mostrarCodigoError();
}



function mostrarCodigoError()
{  
	     
		  var vErrCodigo = get('frmFichero.errCodigo');
		  var vErrDescrip = get('frmFichero.errDescripcion');

		  if (get('frmFichero.errDescripcion')!='')
		  {
				var wnd = fMostrarMensajeError( vErrCodigo,vErrDescrip);
				aceptar();			
     	  }
} 


function aceptar() {
         set('frmFichero.accion','');
         set('frmFichero.conectorAction','LPCargaListaClientes');
         enviaSICC('frmFichero');
}
