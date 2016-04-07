/**************************************************************************************************************************************
  Este archivo es un template para las funciones javascript que deban generarse.
  Descomentar y completar las funciones a implementar.
 **************************************************************************************************************************************/

/*

function limpiarCampos() {
  focaliza ('frmXXXXXXXX.cboXXXXXXXX', '');

  iSeleccionado = new Array ();
  iSeleccionado[0] = "0";

  setTimeout ('set(\'frmXXXXXXXX.cboXXXXXXXX\',iSeleccionado)', 100);

  set ('frmXXXXXXXX.campoX1', '');
  set ('frmXXXXXXXX.campoX2', '');
}

*/

/*

function inicializacion() {
  if (get ('frmXXXXXXXX.hCasoDeUso') == "Eliminar")
      cargarBarra ("contenido_matriz_dias_no_grafico_insertar", "A");
  else
      cargarBarra ("contenido_matriz_dias_no_grafico_insertar");

  focaliza ('frmXXXXXXXX.cboXXXXXXXX', '');
  mostrarCodigoError ();
}

*/

/*

function enviarFormulario() {
  envia ('frmXXXXXXXX');
}

*/

/*

function arreglarBotones() {
  if (get_visibilidad ("capaResultado")) {
      if (get ('frmXXXXXXXX.hCasoDeUso') == "Modificar") {
           visibilidad ('capaBotonM', 'V');
      } else if (get ('frmXXXXXXXX.hCasoDeUso') == "Eliminar") {
                   visibilidad ('capaBotonE', 'V');
              }
  }
}

*/

/*

function btnClick() {
  if (get ('frmXXXXXXXX.hCasoDeUso') == "Modificar")
      modificar ();
  else {
      if (get ('frmXXXXXXXX.hCasoDeUso') == "Eliminar")
           borrar ();
  }
}

*/

/*

function borrar() {
  if (lstBuscarAcceso.seleccion.longitud >= 1) {
      if (GestionarMensaje ('5', null, null, null)) {
           set ('frmXXXXXXXX.elementosSeleccionados',
                 lstBuscarAcceso.getSeleccion ());

           set ('frmXXXXXXXX.accion', 'Eliminar');
           set ('frmXXXXXXXX.conectorAction', 'LPEliminacionXXXX');

           envia ('frmXXXXXXXX');
     }
  }  else  {
           GestionarMensaje ('4', null, null, null);

           return;
  }
}

*/

/*

function modificar() {

  if (lstBuscarAcceso.seleccion.longitud == 1) {
      var posicion = obtenerPosicionLista (lstBuscarAcceso.getSeleccion (), lstBuscarAcceso);

      set ('frmXXXXXXXX.elementosSeleccionados', lstBuscarAcceso.getSeleccion ());
      set ('frmXXXXXXXX.accion', '');
      set ('frmXXXXXXXX.conectorAction', 'LPModificarAcceso');

      //Guardo todos los datos en el formulario a enviar a la pŒ·ŒıŒ›gina de modificaciŒ·ŒıŒÂn.
      set ( 'frmXXXXXXXX.txt_codigoAcceso', lstBuscarAcceso.datos.ij (posicion, 1));
      set ('frmXXXXXXXX.txt_descripcion', lstBuscarAcceso.datos.ij (posicion, 2));
      set ('frmXXXXXXXX.elementosSeleccionados', lstBuscarAcceso.getSeleccion ());

      envia ('frmXXXXXXXX');
  } else {
      GestionarMensaje ('8', null, null, null);

      return;
  }
}

*/

/*

function mostrarCodigoError() {
  var parametros = new Object ();

  parametros.errCodigo = get ('frmXXXXXXXX.errCodigo');
  parametros.errDescripcion = get ('frmXXXXXXXX.errDescripcion');

  if (get ('frmXXXXXXXX.errDescripcion') != '') {
      var wnd = fMostrarMensajeError (get ('frmXXXXXXXX.errCodigo'),
                                           get ('frmXXXXXXXX.errDescripcion'));

      if (get ('frmXXXXXXXX.accion') == 'reintentarEliminar') {
           if (wnd == 0)
                reintentarEliminar ();
           else
                cancelarEliminar ();
      } else {
           if (wnd == 0)
                reintentar ();
           else
                cancelar ();
      }
  }
}

*/

/*

function reintentar() {
  set ('frmXXXXXXXX.accion', 'reintentar');
  set ('frmXXXXXXXX.conectorAction', 'LPBuscarXXXX');
  envia ('frmXXXXXXXX');
}

*/

/*

function cancelar() {
  set ('frmXXXXXXXX.accion', '');
  set ('frmXXXXXXXX.conectorAction', 'LPPreparacionMantenimientoXXXX');
  envia ('frmXXXXXXXX');
}

*/

/*

function reintentarEliminar() {
  set ('frmXXXXXXXX.accion', 'Reintentar');
  set ('frmXXXXXXXX.conectorAction', 'LPEliminacionXXXX');
  envia ('frmXXXXXXXX');
}

*/

/*

function cancelarEliminar() {
  set ('frmXXXXXXXX.c', '');
  set ('frmXXXXXXXX.conectorAction', 'LPXXXXXXXX');
  set ('frmXXXXXXXX.hCasoDeUso', 'Eliminar');
  envia ('frmXXXXXXXX');
}

*/

/*

function posicionarCombo() {
  var iSeleccionado = new Array ();

  iSeleccionado[0] = get ('frmXXXXXXXX.hCanales')
  set ('frmXXXXXXXX.cboXXXXXXXX', iSeleccionado);
}

*/

