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
    $Id: actividades_insertar.js,v 1.1 2009/12/03 19:02:18 pecbazalar Exp $
    DESC
*/



function comboToStr( campo ) {
  var l = combo_get( campo, 'L' );
  var arrai = new Array();
  var datos = '';
  for ( var i = 0;i < l;i++ ) {
    datos += combo_get( campo, 'V', i ) + '|';
  }
  return datos;
}

function comboToStr_Asig( flag ) {
  //flag puede valer 'V' o 'T'
  var l = combo_get( 'frmInsertarActividades.cbProcAsig', 'L' );
  var arrai = new Array();
  for ( var i = 0;i < l;i++ ) {
    arrai[ i ] = combo_get( 'frmInsertarActividades.cbProcAsig', flag, i );
  }
  return arrai.toString();
}

function comboToStr_Disp( flag ) {
  //flag puede valer 'V' o 'T'
  var l = combo_get( 'frmInsertarActividades.cbProcDisp', 'L' );
  var arrai = new Array();
  for ( var i = 0;i < l;i++ ) {
    arrai[ i ] = combo_get( 'frmInsertarActividades.cbProcDisp', flag, i );
   
  }
  return arrai.toString();
}


function revisionActividadOrigen() {
  if ( get( 'frmInsertarActividades.cboTpAct', 'T' ) == 'Fija' ) {
    set( 'frmInsertarActividades.txtActRef', '' );
  }
}


function fGuardar() {
  var bandera = 'S';
  
  if (  fValidarCOMBO( 'frmInsertarActividades.cboMarcas' ) &&
        fValidarCOMBO( 'frmInsertarActividades.cboCanales' ) &&
        fValidarCTEXT( 'frmInsertarActividades.txtcdActividad' ) &&
        fValidarCTEXT( 'frmInsertarActividades.txtdesActividad' ) &&
        fValidarCOMBO( 'frmInsertarActividades.cboTpAct' ) ) {

    if (get('frmInsertarActividades.RebelNoticias')=='S'){
      if (!fValidarCOMBO( 'frmInsertarActividades.cbTipoDirec' ))
        return;
    }


    if ( get( 'frmInsertarActividades.cboTpAct', 'T' ) != 'Fija' && 
         !fValidarCTEXT( 'frmInsertarActividades.txtActRef' ) ) {
      bandera = 'N'
    }

    if (  bandera == "S" 
          && fValidarCOMBO( 'frmInsertarActividades.cboAreaResp' ) 
          //&& fValidarCTEXT( 'frmInsertarActividades.txtDias' ) // incidencia 1448

        ){
      if ( bandera == 'S' ) {
        setearDisAsig()
        set( 'frmInsertarActividades.hEbel', get( 'frmInsertarActividades.RebelNoticias' ) );
        set( 'frmInsertarActividades.hTipoDia', get( 'frmInsertarActividades.rbTipoDias' ) );

        //alert(get('frmInsertarActividades.hEbel'));
        //alert(get('frmInsertarActividades.hTipoDia'));
        set( 'frmInsertarActividades.hComboProc', comboToStr( 'frmInsertarActividades.cbProcAsig' ) );
        set( 'frmInsertarActividades.accion', 'guardar' );

        if ( get( 'frmInsertarActividades.hCasoDeUso' ) == 'modificar' ) {
          if ( GestionarMensaje( '938' ) ) {
            set( 'frmInsertarActividades.conectorAction', 'LPInsertarActividades' );
          }
        } else {
          if ( get( 'frmInsertarActividades.txtcdActividad' ) == get( 'frmInsertarActividades.txtActRef' ) ) {
            GestionarMensaje( '945' );
            setTimeout( "focaliza('frmInsertarActividades.txtActRef','')", 100 );
            return ;
          }
          set( 'frmInsertarActividades.conectorAction', 'LPInsertarActividades' );
        }

        enviaSICC( 'frmInsertarActividades' );
      }
    }
  }
}

function setearDisAsig(){
        set( 'frmInsertarActividades.hVProcAsig', comboToStr_Asig( 'V' ) );
        set( 'frmInsertarActividades.hTProcAsig', comboToStr_Asig( 'T' ) );
        set( 'frmInsertarActividades.hVProcDisp', comboToStr_Disp( 'V' ) );
        set( 'frmInsertarActividades.hTProcDisp', comboToStr_Disp( 'T' ) );
}
function focalizaUltimo() {

  if ( get( 'frmInsertarActividades.hCasoDeUso' ) != 'modificar' ) {
    focaliza( 'frmInsertarActividades.cboMarcas' );
  } else {
    focaliza( 'frmInsertarActividades.txtdesActividad' );
  }
}


function focalizaDesc() {
  if ( get( 'frmInsertarActividades.hCasoDeUso' ) != 'modificar' ) {
    focaliza( 'frmInsertarActividades.txtcdActividad' );
  } else {
    focaliza( 'frmInsertarActividades.cbProcDisp' );
  }
}



function fLimpiar() {

  //alert("CU " + get('frmInsertarActividades.hCasoDeUso'));
  if ( get( 'frmInsertarActividades.hCasoDeUso' ) != 'modificar' ) {

    focaliza( 'frmInsertarActividades.cboMarcas', '' );

    iSeleccionado = new Array();
    iSeleccionado[ 0 ] = ( get( 'frmInsertarActividades.hPaisOrigen' ) );
    setTimeout( 'set(\'frmInsertarActividades.cboMarcas\',iSeleccionado)', 100 );

    set( 'frmInsertarActividades.cboCanales', '' );
    set( 'frmInsertarActividades.txtcdActividad', '' );
    set( 'frmInsertarActividades.txtdesActividad', '' );
    set( 'frmInsertarActividades.cboTpAct', '' );
    set( 'frmInsertarActividades.txtActRef', '' );
    set( 'frmInsertarActividades.cboAreaResp', '' );
    set( 'frmInsertarActividades.RebelNoticias', 'N' );
    set( 'frmInsertarActividades.txtDias', '' );
    set( 'frmInsertarActividades.txtCampaAntela', '' );
    set( 'frmInsertarActividades.cbTipoDirec', '' );
    set( 'frmInsertarActividades.cboTipoDias', '' );
    
    set_combo( 'frmInsertarActividades.cbProcAsig', new Array() );

	//Comentado para resolucion de inc. 845
    //set_combo( 'frmInsertarActividades.cbProcDisp', new Array() );

    focaliza( 'frmInsertarActividades.cboMarcas', '' );
    
  } else {
/*
    iSeleccionado = new Array();

    //Nombre Actividad
    set( 'frmInsertarActividades.txtdesActividad', get( 'frmInsertarActividades.hNomActi' ) );

    //Tipo Actividad
    iSeleccionado[ 0 ] = ( get( 'frmInsertarActividades.hTipoAct' ) );
    set( 'frmInsertarActividades.cboTpAct', iSeleccionado );

    if ( get( 'frmInsertarActividades.cboTpAct', 'T' ) == 'Fija' ) {
      accion( 'frmInsertarActividades.txtActRef', '.disabled=true' );
    } else {
      accion( 'frmInsertarActividades.txtActRef', '.disabled=false' );
    }

    //Actividad Origen
    set( 'frmInsertarActividades.txtActRef', get( 'frmInsertarActividades.hCactCodActi' ) );

    //Tipo Dia
    if ( get( 'frmInsertarActividades.hTipoDia' ) == "L" ) {
      set( 'frmInsertarActividades.rbTipoDias', 'L' );
    } else {
      set( 'frmInsertarActividades.rbTipoDias', 'C' );
    }

    //Dias Desplazamiento
    set( 'frmInsertarActividades.txtDias', get( 'frmInsertarActividades.hDiasDesp' ) );

    //Ebel Noticia
    if ( get( 'frmInsertarActividades.hEbel' ) == "No" ) {
      set( 'frmInsertarActividades.RebelNoticias', 'N' );
    } else {
      set( 'frmInsertarActividades.RebelNoticias', 'S' );
    }

    //Area Responsable
    iSeleccionado[ 0 ] = ( get( 'frmInsertarActividades.hDpteCodDpto' ) );
    set( 'frmInsertarActividades.cboAreaResp', iSeleccionado );


    //Procesos Asignados

    var i;
    var strV = new String( get( 'frmInsertarActividades.hVProcAsig' ) );
    var sArrayV ;
    var sArrayT;
    if ( strV.length > 0 ) { //Esta pregunta se hace porque el SPLIT siempre devuelve un Array con la menos 1 elemento.
      sArrayV = strV.split( '|' );
    } else {
      sArrayV = new Array();
    }
    var strT = new String( get( 'frmInsertarActividades.hTProcAsig' ) );
    if ( strT.length > 0 ) {
      sArrayT = strT.split( '|' );
    } else {
      sArrayT = new Array();
    }
    var sArray = new Array();

    for ( i = 0; i < sArrayV.length; i++ ) {
      var par = new Array();
      par[ 0 ] = sArrayV[ i ];
      par[ 1 ] = sArrayT[ i ];
      sArray[ i ] = par;
    }

    set_combo( 'frmInsertarActividades.cbProcAsig', sArray );

    //Procesos Disponibles

    strV = new String( get( 'frmInsertarActividades.hVProcDisp' ) );
    if ( strV.length > 0 ) { //Esta pregunta se hace porque el SPLIT siempre devuelve un Array con la menos 1 elemento.
      sArrayV = strV.split( '|' );
    } else {
      sArrayV = new Array();
    }

    strT = new String( get( 'frmInsertarActividades.hTProcDisp' ) );
    if ( strT.length > 0 ) {
      sArrayT = strT.split( '|' );
    } else {
      sArrayT = new Array();
    }

    sArray = new Array();

    for ( i = 0; i < sArrayV.length; i++ ) {
      var par = new Array();
      par[ 0 ] = sArrayV[ i ];
      par[ 1 ] = sArrayT[ i ];
      sArray[ i ] = par;
    }
    set_combo( 'frmInsertarActividades.cbProcDisp', sArray );

    //focalizo en el primer campo editable
    focaliza( 'frmInsertarActividades.txtdesActividad', '' );
 */ 
    set( 'frmInsertarActividades.accion', 'inicio' );
    enviaSICC( 'frmInsertarActividades' );
    }
}


function inicializacion() {
  configurarMenuSecundario( "frmInsertarActividades" );
  if ( get('frmInsertarActividades.hCasoDeUso') == "modificar" ) {

    txtcdActividad.disabled = true;
    cboMarcas.disabled = true;
    cboCanales.disabled = true;

    var strV = '';
    var strT = '';
    var i;
    var longitud = combo_get( 'frmInsertarActividades.cbProcAsig', 'L' );

    if ( longitud > 0 ) {
      strV = combo_get( 'frmInsertarActividades.cbProcAsig', 'V', 0 );
      strT = combo_get( 'frmInsertarActividades.cbProcAsig', 'T', 0 );
    }

    for ( i = 1; i < longitud; i++ ) {
      strV += '|' + combo_get( 'frmInsertarActividades.cbProcAsig', 'V', i );
      strT += '|' + combo_get( 'frmInsertarActividades.cbProcAsig', 'T', i );
    }

    set( 'frmInsertarActividades.hVProcAsig', strV );
    set( 'frmInsertarActividades.hTProcAsig', strT );

    strV = '';
    strT = '';

    longitud = combo_get( 'frmInsertarActividades.cbProcDisp', 'L' );

    if ( longitud > 0 ) {
      strV = combo_get( 'frmInsertarActividades.cbProcDisp', 'V', 0 );
      strT = combo_get( 'frmInsertarActividades.cbProcDisp', 'T', 0 );
    }

    for ( i = 1; i < longitud; i++ ) {
      strV += '|' + combo_get( 'frmInsertarActividades.cbProcDisp', 'V', i );
      strT += '|' + combo_get( 'frmInsertarActividades.cbProcDisp', 'T', i );
    }

    set( 'frmInsertarActividades.hVProcDisp', strV );
    set( 'frmInsertarActividades.hTProcDisp', strT );

    focaliza( 'frmInsertarActividades.txtdesActividad', '' );

  } else {

    if ( get( 'frmInsertarActividades.hCanales' ) != "" ) {
      focaliza( 'frmInsertarActividades.txtcdActividad' );
    } else {
      focaliza( 'frmInsertarActividades.cboMarcas', '' );
    }
	mostrarPantallaExito();

  }
  
  
/*  if ( get( 'frmInsertarActividades.hTipoAct' ) == '0' ) {
    accion( 'frmInsertarActividades.txtActRef', '.disabled=true' );
  }
  else {
    accion( 'frmInsertarActividades.txtActRef', '.disabled=false' );
  }
*/
  inicializacionRadioB();
  posicionarCombo();
  habilitaTipoDireccion();

  mostrarCodigoError();

  if(( get( 'frmInsertarActividades.cboTpAct', 'T' ) == 'Fija' ) ||
     ( get( 'frmInsertarActividades.cboTpAct', 'T' ) == '' )){
    accion( 'frmInsertarActividades.txtActRef', '.disabled=true' );
  } else {
    accion( 'frmInsertarActividades.txtActRef', '.disabled=false' );
  }
  
}



function inicializacionRadioB() {
  if (  get( 'frmInsertarActividades.hEbel' ) == 'N' || 
        get( 'frmInsertarActividades.hEbel' ) == '' || 
        get( 'frmInsertarActividades.hEbel' ) == '0' ) {
    set( 'frmInsertarActividades.RebelNoticias', 'N' );
  } else {
    set( 'frmInsertarActividades.RebelNoticias', 'S' );
  }
}

function enviarFormulario() {
  if (  fValidarCOMBO( 'frmInsertarActividades.cboCanales' ) &&
        fValidarCOMBO( 'frmInsertarActividades.cboMarcas' ) )
    enviaSICC( 'frmInsertarActividades' );
}


function mostrarCodigoError(){
  var parametros = new Object();
  
  parametros.errCodigo = get('frmInsertarActividades.errCodigo');
  parametros.errDescripcion = get('frmInsertarActividades.errDescripcion');
  
  if (get('frmInsertarActividades.errDescripcion') != '' ){
    var wnd = fMostrarMensajeError(get( 'frmInsertarActividades.errCodigo' ), 
                                   get( 'frmInsertarActividades.errDescripcion' ));
    fLimpiar();
  }
  
}


function limpiarCombos(){
  set( "frmInsertarActividades.hPais", "" );
  set( "frmInsertarActividades.hCanales", "" );
  set( "frmInsertarActividades.hMarcas", "" );
}


function posicionarCombo() {

  var iSeleccionadoM = new Array();
  iSeleccionadoM[ 0 ] = get( 'frmInsertarActividades.hMarcas' );
  set( 'frmInsertarActividades.cboMarcas', iSeleccionadoM );

  var iSeleccionado = new Array();
  iSeleccionado[ 0 ] = get( 'frmInsertarActividades.hCanales' );
  set( 'frmInsertarActividades.cboCanales', iSeleccionado );

  var iSeleccionado = new Array();
  iSeleccionado[ 0 ] = get( 'frmInsertarActividades.hTipoAct' );
  set( 'frmInsertarActividades.cboTpAct', iSeleccionado );

  var iSeleccionado = new Array();
  iSeleccionado[ 0 ] = get( 'frmInsertarActividades.hDpteCodDpto' );
  set( 'frmInsertarActividades.cboAreaResp', iSeleccionado );

  /*var iSeleccionadoDD = new Array();
  iSeleccionadoDD[ 0 ] = get( 'frmInsertarActividades.hDiasDesp' );
  set( 'frmInsertarActividades.txtDias', iSeleccionadoDD );*/


  var iSeleccionado = new Array();
  iSeleccionado[ 0 ] = get( 'frmInsertarActividades.hTipoDia' );
  set( 'frmInsertarActividades.cboTipoDias', iSeleccionado );

  var iSeleccionado = new Array();
  iSeleccionado[ 0 ] = get( 'frmInsertarActividades.hTipoDirec' );
  set( 'frmInsertarActividades.cbTipoDirec', iSeleccionado );
//  habilitarCampos();
}

function focalizaPrimero() {
  focaliza( 'frmInsertarActividades.cboMarcas', '' );
}


function ordenar( lista ) {
  box = eval( 'document.' + lista );
  quickSort( box, 0, box.options.length - 1 );
}


function quickSort( box, inicio, fin ) {
  primero = inicio;
  ultimo = fin;
  if ( primero >= ultimo ) {
    return ;
  }
  textoMedio = box.options[ parseInt( ( ( primero + ultimo ) / 2 ).toString() ) ].text;
  while ( primero < ultimo ) {
    while ( primero < ultimo && ( comparar( box.options[ primero ].text, textoMedio ) == -1 ) ) {
      primero++;
    }
    for ( ; primero < ultimo && ( comparar( box.options[ ultimo ].text, textoMedio ) == 1 ); ultimo-- ) { }
    if ( primero < ultimo ) {
      opcionPrimero = crearOpcion( box, primero );
      opcionUltimo = crearOpcion( box, ultimo );
      box.options[ primero ] = opcionUltimo;
      box.options[ ultimo ] = opcionPrimero;
    }
  }
  if ( ultimo < primero ) {
    aux = ultimo;
    ultimo = primero;
    primero = aux;
  }
  quickSort( box, inicio, primero );
  quickSort( box, primero != inicio ? primero : primero + 1, fin );
}


function traspasar( listaOrigen, listaDestino ) {
  var vecDestValue = get( listaDestino, 'V' );
  vectorValue = get( listaOrigen, 'V' );
  vectorDesc = get( listaOrigen, 'T' );
  for ( var i = 0; i <= vectorValue.length - 1; i++ ) {
    if ( ( vectorValue[ i ] != null ) && ( vectorValue[ i ] != '' ) ) {
      del_combo( listaOrigen, 'V', vectorValue[ i ] );
      combo_add( listaDestino, vectorValue[ i ], vectorDesc[ i ] );
    }
  }
}


function agregando() {
  traspasar( 'frmInsertarActividades.cbProcAsig', 'frmInsertarActividades.cbProcDisp' );
}


function eliminando() {
  traspasar( 'frmInsertarActividades.cbProcDisp', 'frmInsertarActividades.cbProcAsig' );
}


function canalSeleccionado() {
  setearDisAsig();
  if ( ( get( 'frmInsertarActividades.cboMarcas' ) != '' ) &&
       ( get( 'frmInsertarActividades.cboCanales' ) != '' ) ) {
      

//    set( 'frmInsertarActividades.accion', 'canalSeleccionado' );
//    enviaSICC( 'frmInsertarActividades' );
  }
}


function habilitarCampos() {
  if ( ( get( 'frmInsertarActividades.cboMarcas' ) != '' ) &&
       ( get( 'frmInsertarActividades.cboCanales' ) != '' ) ) {
    accion( 'frmInsertarActividades.cboAreaResp', '.disabled=false' );
  }
}


function deshabilitarActRef() {
  if ( get( 'frmInsertarActividades.cboTpAct' ) == '0' ) {
    accion( 'frmInsertarActividades.txtActRef', '.disabled=true' );
  }
  else {
    accion( 'frmInsertarActividades.txtActRef', '.disabled=false' );
  }
} 
  
function habilitaTipoDireccion(){
  if (get('frmInsertarActividades.RebelNoticias')=='S'){
    accion( 'frmInsertarActividades.cbTipoDirec', '.disabled=false' );
    var iSeleccionado = new Array();
    iSeleccionado[ 0 ] = get( 'frmInsertarActividades.hTipoDirec' );
    set( 'frmInsertarActividades.cbTipoDirec', iSeleccionado );
  } else {
    accion( 'frmInsertarActividades.cbTipoDirec', '.disabled=true' );
    var iSeleccionado = new Array();
    iSeleccionado[ 0 ] = ""
    set( 'frmInsertarActividades.cbTipoDirec', iSeleccionado );
  }
}

function mostrarPantallaExito() {  

		  if (get('frmInsertarActividades.exito')=='S'){
			
      		var wnd = fMostrarMensajeExito("insertar");
     	  }
		  
     	  
} 
