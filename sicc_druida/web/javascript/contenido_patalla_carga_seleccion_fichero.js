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
  Fecha:             2/12/2003
  Observaciones:     
  @version           
  @autor             
 */

/*$Id: contenido_patalla_carga_seleccion_fichero.js,v 1.1 2009/12/03 19:02:02 pecbazalar Exp $*/

var varNoLimpiarSICC = true;
var procesarArchivo = false;

function fLimpiar() {  

	fichero1.reset();
}


function fmCargarBarra() {

	configurarMenuSecundario("frmFichero");
	fMostrarMensajeError();
	fichero1.focaliza();
	
}


// Funcion que nueve el archivo. 
function processFile(file) {	
	if(!procesarArchivo) {
		if (get("frmFichero.conectorAction")==''){
			set("frmFichero.conectorAction","LPCargaFichero");
		}	
		set("frmFichero.seleccion",file);
		set("frmFichero.accion","procesar");

		// Solo se inhibe multiples procesamientos cuando son ficheros de P0003
		if(get("frmFichero.procesarArchivoP0003")=='S'){
			procesarArchivo = true;
		}
		enviaSICC("frmFichero");
	}
}


/*function mostrarCodigoError() {  
	     
		  var vErrCodigo = get('frmFichero.errCodigo');
		  var vErrDescrip = get('frmFichero.errDescripcion');

		  if (get('frmFichero.errDescripcion')!=''){
      		var wnd = fMostrarMensajeError( vErrCodigo,vErrDescrip);
     		
	        aceptar();			

     	  }
} */


function aceptar() {
         set('frmFichero.accion','');
         set('frmFichero.conectorAction','LPCargaFichero');
         enviaSICC('frmFichero');
}


function mensajeProcesando(){
	GestionarMensaje('M00047');
}
