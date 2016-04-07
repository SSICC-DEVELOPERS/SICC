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
    $Id: actividades_buscar.js,v 1.1 2009/12/03 19:02:15 pecbazalar Exp $
    DESC
*/
var FORM = 'frmConsultarActividades'; 


function inicializacion() {

	if(!fMostrarMensajeError()){

		//if ( get(FORM + '.hidErrDescripcion') != '' )
		//	fMostrarMensajeError( get(FORM + '.errCodigo'), get(FORM + '.errDescripcion'));
			//fMostrarMensajeError( get(FORM + '.hidErrCodigo'), get(FORM + '.hidErrDescripcion'));

			configurarMenuSecundario( FORM + '' );
			mostrarPantallaExito()
			setComboDefault( FORM + '.cbMarcas', FORM + '.hMarca' );
			setComboDefault( FORM + '.cbCanales', FORM + '.hCanal' );
			setComboDefault( FORM + '.cbActiv', FORM + '.hActividad' );
  
			//if (get( FORM + '.hMarca' ) == '')
			focaliza( FORM + '.cbMarcas' );
			/* else if ( ( get( FORM + '.hCanal' ) == '' ) )
			focaliza( FORM + '.cbCanales' );
			else
			focaliza( FORM + '.cbActiv' );*/

			//alert(get("frmConsultarActividades.hCasoDeUso"));
	}
}


function setComboDefault( cb, hid ) {
  iSeleccionado = new Array();
  iSeleccionado[ 0 ] = get( hid );
  set( cb, iSeleccionado );
}


function deshabilitarTodos() {
  accion( FORM + '.cbMarcas', '.disabled=true' );
  accion( FORM + '.cbCanales', '.disabled=true' );
  accion( FORM + '.cbActiv', '.disabled=true' );
  //accion( FORM + '.btnBuscar', '.disabled=true' );
}


function fLimpiar() {
  var aa = new Array();

//  set( FORM + '.cbCanales', '' );
  //set( FORM + '.cbMarcas', '' );
//  set_combo( FORM + '.cbActiv', aa,'');
  set(FORM + '.cbActiv','');
  accion( FORM + '.cbActiv', '.disabled=true' );
  set(FORM +'.hMarca','');
  set(FORM +'.hCanal','');
  setComboDefault( FORM + '.cbMarcas', FORM + '.hMarca' );
  setComboDefault( FORM + '.cbCanales', FORM + '.hCanal' );
  focaliza( FORM + '.cbMarcas' );
}


function modificarActividad() {
  if ( Lista1.getSeleccion() == "" ) {
    GestionarMensaje( '8' );
  } else {
    set( FORM + '.hActividad', Lista1.getSeleccion() );
    
    var str = get( FORM + '.hActividad');
    arr = str.split('|');
    
    set( FORM + '.hOidActiModi', arr[0] );
    set( FORM + '.hMarcaModi', arr[1] );
    set( FORM + '.hCanalModi', arr[2] );
    set( FORM + '.hCodActiModi', arr[3] );
    set( FORM + '.hNomActiModi', arr[4] );
    set( FORM + '.hTipoActModi', arr[5] );
    set( FORM + '.hCodActi2Modi', arr[6] );
    set( FORM + '.hDpteCodDptoModi', arr[7] );
    set( FORM + '.hEbelModi', arr[8] );
    set( FORM + '.hCampaAntelaModi', arr[9] );
    set( FORM + '.hTipoDirecModi', arr[10] );
    set( FORM + '.hTipoDiaModi', arr[11] );
    set( FORM + '.hDiasDespModi', arr[12] );
    
    // alert("hDiasDespModi: " + arr[12] );
    
    set( FORM + '.hCasoDeUso', 'modificar' );
    set( FORM + '.accion', "inicio" );
    set( FORM + '.conectorAction', "LPInsertarActividades" );
    set( FORM + '.hPasoActividad', Lista1.getSeleccion() );
    enviarFormulario();
  }
}


function mostrarMsgVal() {
  if ( get( FORM + '.txtDescripcion' ) == "" ) {
    GestionarMensaje( '708', FORM + '.txtDescripcion' );
    return ;
  }
}


function obtenerPaisMarcaCanal() {
  set( FORM + '.hCanal', get( FORM + '.cbCanales' ) );
  set( FORM + '.hMarca', get( FORM + '.cbMarcas' ) );
  set( FORM + '.descCanal', get( FORM + '.cbCanales', 'T' ) );
  set( FORM + '.descMarca', get( FORM + '.cbMarcas', 'T' ) );
}


function enviarFormulario() {
  obtenerPaisMarcaCanal();
  enviaSICC( FORM + '' );
}


function cargarActividades() {
  if (  get( FORM + '.cbMarcas' ) != "" && get( FORM + '.cbCanales' ) != "" ) {
    set( FORM + '.accion', 'consultar' );
    set( FORM + '.conectorAction', 'LPConsultarActividades' );
    deshabilitarTodos();
    enviarFormulario();
  }
}


function cargarListaActividades() {
  setTimeout( "cargarListaActividades2()", 100 );
}


function cargarListaActividades2() {
  if ( fValidarCOMBO( FORM + '.cbMarcas' ) && fValidarCOMBO( FORM + '.cbCanales' ) != "" ) {
    set( FORM + '.hActividad', get( FORM + '.cbActiv' ) );
    set( FORM + '.accion', 'cargarLista' );
    set( FORM + '.conectorAction', 'LPConsultarActividades' );    
    deshabilitarTodos();
    enviarFormulario();
  }
}

function fBorrar(){
	borrar();
}

function borrar() {
  if ( Lista1.getSeleccion() == "" ) {
    GestionarMensaje( '4' );
  } else {
    if ( GestionarMensaje( '5' ) ) {
      set( FORM + '.accion', "eliminar" );
      set( FORM + '.conectorAction', 'LPConsultarActividades' );
      set( FORM + '.hActividad', Lista1.getSeleccion() );
      enviarFormulario();
    }
  }
}

function mostrarPantallaExito() {  

		  if (get('frmConsultarActividades.exito')=='S')
		  {
		   fLimpiar()
		   var wnd = fMostrarMensajeExito("eliminar");
		   //enviaSICC('frmConsultarActividades');
     	  }
		  else
		  {
     	      if (get('frmConsultarActividades.exito')=='M')
				 {
       		     var wnd = fMostrarMensajeExito("modificar");
     	         }
     	   }
		set('frmConsultarActividades.exito','');	
}