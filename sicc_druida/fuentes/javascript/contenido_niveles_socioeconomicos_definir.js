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
  Modulo:            SEG
  Submódulo:         Seguridad
  Componente:        JS
  Fecha:             30/10/2003
  Observaciones:     
  @version           
  @autor             Viviana Bongiovanni
 */

/*$Id: contenido_niveles_socioeconomicos_definir.js,v 1.1 2009/12/03 19:01:52 pecbazalar Exp $*/

var varNoLimpiarSICC = true;

function fLimpiar() {   	  
    eval('frmDefinirNiveles').oculto = 'N';
    
	  set('frmDefinirNiveles.accion','');
    set('frmDefinirNiveles.conectorAction','LPDefinirNivelesSocioeconomicos');

    sicc_cambiar_estado('comboNSEBelcorp', false);
    sicc_cambiar_estado('comboNSEPais', false);

    enviaSICC('frmDefinirNiveles');
}


function fmCargarBarra() {

    configurarMenuSecundario("frmDefinirNiveles");
    // Asignación de los valores de los combos
    iSeleccionado = new Array(); 
    iSeleccionado[0] = get('frmDefinirNiveles.hidPais');
    set('frmDefinirNiveles.comboPais',iSeleccionado);
    //alert(get('frmDefinirNiveles.SICC_TOOLBAR_CONFIG'));
    mostrarCodigoError();
    //mostrarPantallaExito();
    focaliza('frmDefinirNiveles.comboPais');      
}


function cargarDefinirNiveles() {

    set('frmDefinirNiveles.hidPais', get('frmDefinirNiveles.comboPais'));	
  	set('frmDefinirNiveles.accion','seleccion de pais');
    set('frmDefinirNiveles.conectorAction','LPDefinirNivelesSocioeconomicos');

		sicc_cambiar_estado('comboNSEBelcorp', false);
    sicc_cambiar_estado('comboNSEPais', false);
    
    enviaSICC('frmDefinirNiveles');
	
}

function fGuardar() {   	

  if (!sicc_validaciones_generales()) {
  } else {
    set('frmDefinirNiveles.accion','guardar');
    set('frmDefinirNiveles.conectorAction','LPDefinirNivelesSocioeconomicos');
    eval('frmDefinirNiveles').oculto = 'S';
    enviaSICC('frmDefinirNiveles', '', '', 'N');   

  }

}


function focalizaComponente() {   
   document.selection.empty();
   focaliza('frmDefinirNiveles.comboPais');       
}


function focalizaComponenteShift() {    
    document.selection.empty();
	focaliza('frmDefinirNiveles.comboNSEPais');       
}

function mostrarCodigoError() {  
		  var vErrCodigo = get('frmDefinirNiveles.errCodigo');
		  var vErrDescrip = get('frmDefinirNiveles.errDescripcion');
		  if (get('frmDefinirNiveles.errDescripcion')!=''){
      		var wnd = fMostrarMensajeError( vErrCodigo,vErrDescrip);
	        //aceptar();			
     	  }
} 

function aceptar() {
         set('frmDefinirNiveles.accion','');
         set('frmDefinirNiveles.conectorAction','LPDefinirNivelesSocioeconomicos');
         enviaSICC('frmDefinirNiveles');
}


function mostrarPantallaExito() {  
      if (get('frmDefinirNiveles.exito')=='S'){
        //var wnd = fMostrarMensajeExito("insertar");
        set('frmDefinirNiveles.conectorAction','LPDefinirNivelesSocioeconomicos');		
        set('frmDefinirNiveles.accion','seleccion de pais');						
        enviaSICC('frmDefinirNiveles');
      }
} 


function persistioOk(p1) {

	set("frmDefinirNiveles.hidPais", p1);
	set('frmDefinirNiveles.accion','seleccion de pais');
  set('frmDefinirNiveles.conectorAction','LPDefinirNivelesSocioeconomicos');

  eval('frmDefinirNiveles').oculto = 'N';
  enviaSICC('frmDefinirNiveles');
  
}

function noPersistio() {
  eval('frmDefinirNiveles').oculto = 'N';
  focaliza('frmDefinirNiveles.comboPais');
}
