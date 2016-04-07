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
  Sistema:           Belcorp
  Modulo:            ZON
  Submódulo:         Zonificación
  Componente:        JS
  Fecha:             4/12/2003
  Observaciones:     
  @version           
  @autor             
 */

/*$Id: contenido_patalla_carga_resultado_fichero.js,v 1.1 2009/12/03 19:02:23 pecbazalar Exp $*/


function fVolver() {
         set('frmFichero.accion','');
         set('frmFichero.conectorAction','LPCargaFichero');
         enviaSICC('frmFichero');
}


function fmCargarBarra() {
	
	document.body.onkeydown  = inhabilitaTab;

	configurarMenuSecundario("frmFichero");

	onLoadPag();

    // Muestra los datos
	txt_to('lblIdProcesoX',get('frmFichero.hidIdProcesoX'));
	txt_to('lblTipoProcesoX',get('frmFichero.hidTipoProcesoX'));
	txt_to('lblFechaReporteX',get('frmFichero.hidFechaReporteX'));
	txt_to('lblMensajeEstatusX',get('frmFichero.hidMensajeEstatusX'));
	txt_to('lblMensajeEstatusX',estatus(get('frmFichero.hidMensajeEstatusX')));

	mostrarCodigoError();
}



function mostrarCodigoError() {  
	     
		  var vErrCodigo = get('frmFichero.errCodigo');
		  var vErrDescrip = get('frmFichero.errDescripcion');

		  if (get('frmFichero.errDescripcion')!=''){
      		var wnd = fMostrarMensajeError( vErrCodigo,vErrDescrip);
     		
	        aceptar();			

     	  }
} 


function aceptar() {
         set('frmFichero.accion','');
         set('frmFichero.conectorAction','LPCargaFichero');
         enviaSICC('frmFichero');
}


/* Estatus
	-1 En Ejecución
	-2 Procesamiento Finalizado OK
	-3 No Iniciado
	-4 Procesamiento Finalizado Error
	-5 Sin Estatus
*/
function estatus(est) {
  
	mensaje = "";

	if(est == -1) {
		mensaje = GestionarMensaje('971');  
	} else if (est == -2) {
		mensaje = GestionarMensaje('972'); 
	} else if (est == -3) {
		mensaje = GestionarMensaje('973'); 
	} else if (est == -4) {
		mensaje = GestionarMensaje('974'); 
	} else if (est == -5) {
		mensaje = GestionarMensaje('975');
	}

    return mensaje;
}

