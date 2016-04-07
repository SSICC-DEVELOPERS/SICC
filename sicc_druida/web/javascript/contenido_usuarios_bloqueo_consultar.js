function onLoad() {
         configurarMenuSecundario("formulario");
         foco("formulario.txtCodigoUsuario");
         fMostrarMensajeError();
         
         DrdEnsanchaConMargenDcho("listado1", 25);
         eval(ON_RSZ);
}

function onClickBuscar() {
    configurarPaginado(mipgndo, "MAEBuscarUsuariosBloqueo", "ConectorBuscarUsuariosBloqueo",
                          "es.indra.sicc.dtos.mae.DTOBuscarUsuariosBloqueo", armarArrayValoresDto());
}

function fBorrar() {
    var seleccionados = obtenerOidsFilasSeleccionadas();
    var cantSeleccionados = seleccionados.length;
    
    if (cantSeleccionados > 0) {
         eliminarFilas(seleccionados, "MAEEliminarUsuariosBloqueo", mipgndo);
         return true;
    } else {
         GestionarMensaje("4");
         return false;
    }
}

function fLimpiar() {
         ocultarLista();
         set("formulario.cbAccionPermitida", ['']);
         set("formulario.cbTipoBloqueo", ['']);
         set("formulario.txtCodigoUsuario", '');
         foco("formulario.txtCodigoUsuario");
}

function onClickDetalle() {
    var codigos = listado1.codSeleccionados();
    var cant = codigos.length;
    
    if (cant == 1) {
         var obj = new Object();
         obj.opcionMenu = get("formulario.opcionMenu");
         obj.oidUsuarioBloqueoSeleccionado  = listado1.extraeDato(codigos[0], 0); // OID_USUA_BLOQ
         obj.idUserSeleccionado              = listado1.extraeDato(codigos[0], 1); // IDUSER
         obj.codigoUsuarioSeleccionado      = listado1.extraeDato(codigos[0], 2); // COD_USUA
         obj.nombreUsuarioSeleccionado      = listado1.extraeDato(codigos[0], 3); // NOM_USUA
         obj.oidTipoBloqueoSeleccionado     = listado1.extraeDato(codigos[0], 4); // OID_TIPO_BLOQ
         obj.oidAccionPermitidaSeleccionado = listado1.extraeDato(codigos[0], 6); // OID_VALO_USUA_BLOQ
                  
         mostrarModalSICC("LPMantenimientoUsuariosBloqueo", "detalle", obj, 750, 350);
         focaliza("formulario.txtCodigoUsuario");
    } else if (cant < 1) {
         GestionarMensaje("50");
    } else if (cant > 1) {
         cdos_mostrarAlert(GestionarMensaje("240"));
    }
}

function onClickModificar() {
    var codigos = listado1.codSeleccionados();
    var cant = codigos.length;
    
    if (cant == 1) {
         var obj = new Object();
         obj.opcionMenu = get("formulario.opcionMenu");
         obj.oidUsuarioBloqueoSeleccionado  = listado1.extraeDato(codigos[0], 0); // OID_USUA_BLOQ
         obj.idUserSeleccionado              = listado1.extraeDato(codigos[0], 1); // IDUSER
         obj.codigoUsuarioSeleccionado      = listado1.extraeDato(codigos[0], 2); // COD_USUA
         obj.nombreUsuarioSeleccionado      = listado1.extraeDato(codigos[0], 3); // NOM_USUA
         obj.oidTipoBloqueoSeleccionado     = listado1.extraeDato(codigos[0], 4); // OID_TIPO_BLOQ
         obj.oidAccionPermitidaSeleccionado = listado1.extraeDato(codigos[0], 6); // OID_VALO_USUA_BLOQ
                  
         var arrayDevuelto = mostrarModalSICC("LPMantenimientoUsuariosBloqueo", "modificarDetalle", obj, 750, 350);
         
         if (arrayDevuelto != null && arrayDevuelto.length == 2) {
             listado1.insertaDato(codigos[0], 6, arrayDevuelto[0]); // OID_VALO_USUA_BLOQ
             listado1.insertaDato(codigos[0], 7, arrayDevuelto[1]); // Descripcion (Accion permitida)
         }
         focaliza("formulario.txtCodigoUsuario");
    } else if (cant < 1) {
         GestionarMensaje("50");
    } else if (cant > 1) {
         cdos_mostrarAlert(GestionarMensaje("240"));
    }
}

function muestraLista(ultima, rowset) {
    var tamano = rowset.length;
    
    if (tamano > 0) {
         visualizarLista();
         return true;
    } else {
         ocultarLista();
         focaliza("formulario.txtCodigoUsuario");
         return false;
    }
}

function armarArrayValoresDto() {
         var array = new Array();
         array[0] = ["oidPais", get("formulario.oidPais")];
         array[1] = ["oidIdioma", get("formulario.oidIdioma")];
         
         if (get("formulario.txtCodigoUsuario") != "") {
                  array.push(["codigoUsuario", get("formulario.txtCodigoUsuario")]);
         }
         
         if (get("formulario.cbTipoBloqueo") != "") {
                  array.push(["oidTipoBloqueo", get("formulario.cbTipoBloqueo")]);
         }
         
         if (get("formulario.cbAccionPermitida") != "") {
                  array.push(["oidAccionPermitida", get("formulario.cbAccionPermitida")]);
         }
    
         return array;
}

function visualizarLista() {
         visibilidad("capaLista1", "V"); // "O" Oculta y "V" Hace visible
    
         var opcionMenu = get("formulario.opcionMenu");

    if (opcionMenu =='modificar') {
         document.all["btnModificarDiv"].style.visibility='visible';
         document.all["btnDetalleDiv"].style.visibility='hidden';
    } else if (opcionMenu == 'consultar') {
         document.all["btnModificarDiv"].style.visibility='hidden';
         document.all["btnDetalleDiv"].style.visibility='visible';
    } else if (opcionMenu == 'eliminar') {
         document.all["btnModificarDiv"].style.visibility='hidden';
         document.all["btnDetalleDiv"].style.visibility='visible';
         btnProxy(4, 1);
    }
}

function ocultarLista() {
    document.all["btnDetalleDiv"].style.visibility='hidden';
    document.all["btnModificarDiv"].style.visibility='hidden';
         visibilidad("capaLista1", "O");
         
    if (get("formulario.opcionMenu") == "eliminar") {
         btnProxy(4, 0);
    }
}

function onShTabTxtCodigoUsuario() {
         if (document.getElementById("btnDetalleDiv").style.visibility == 'visible') {
                  focalizaBotonHTML("botonContenido", "btnDetalle");
         
         } else if (document.getElementById("btnModificarDiv").style.visibility == 'visible') {
                  focalizaBotonHTML("botonContenido", "btnModificar");
         
         } else {
                  focalizaBotonHTML("botonContenido", "btnBuscar");
         
         }
}

function onTabBuscar() {
         if (document.getElementById("btnDetalleDiv").style.visibility == 'visible') {
                  focalizaBotonHTML("botonContenido", "btnDetalle");
         
    } else if (document.getElementById("btnModificarDiv").style.visibility == 'visible') {
                  focalizaBotonHTML("botonContenido", "btnModificar");
         
         } else {
                  foco("formulario.txtCodigoUsuario");
         
         }
}

function obtenerOidsFilasSeleccionadas() {
    var codSeleccionados = listado1.codSeleccionados(); // Tiene los Rownum de las filas
    var cantFilasSeleccionadas = codSeleccionados.length;
    
    var oidsSeleccionados = new Array();
    
    for (var i = 0; i < cantFilasSeleccionadas; i++) {
          codFilaListado = codSeleccionados[i];
          oidSeleccionado = listado1.extraeDato(codFilaListado, 0);
          oidsSeleccionados.push(oidSeleccionado); // Agregamos el oid al Array
    }
    return oidsSeleccionados;
}