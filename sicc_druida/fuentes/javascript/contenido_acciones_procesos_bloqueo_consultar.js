function onLoad() {
         configurarMenuSecundario("formulario");
         foco("formulario.cbTipoBloqueo");
         fMostrarMensajeError();
         
         DrdEnsanchaConMargenDcho("listado1", 25);
         eval(ON_RSZ);
}

function recargarComboAcciones() {
         recargaCombo("formulario.cbAccionBloqueo", "MAEObtenerAccionesBloqueo", 
                                     "es.indra.sicc.util.DTOOID", 
                                     [ ["oidPais", get("formulario.oidPais")], 
                                        ["oidIdioma", get("formulario.oidIdioma")],
                                        ["oid", get("formulario.cbProcesoBloqueo")] ]);
}

function onClickBuscar() {
    configurarPaginado(mipgndo, "MAEBuscarAccionesProcesosBloqueo", "ConectorBuscarAccionesProcesosBloqueo",
                          "es.indra.sicc.dtos.mae.DTOBuscarAccionesProcesosBloqueo", armarArrayValoresDto());
}

function fBorrar() {
    var seleccionados = obtenerOidsFilasSeleccionadas();
    var cantSeleccionados = seleccionados.length;
    
    if (cantSeleccionados > 0) {
         eliminarFilas(seleccionados, "MAEEliminarAccionesProcesosBloqueo", mipgndo);
         return true;
    } else {
         GestionarMensaje("4");
         return false;
    }
}

function fLimpiar() {
         ocultarLista();
         set_combo("formulario.cbAccionBloqueo", [['','']]);
         set("formulario.cbProcesoBloqueo", ['']);
         set("formulario.cbTipoBloqueo", ['']);
         foco("formulario.cbTipoBloqueo");
}

function onClickDetalle() {
    var codigos = listado1.codSeleccionados();
    var cant = codigos.length;

    if (cant == 1) {
         var obj = new Object();
         obj.oidAccionProcesoBloqueoSeleccionado = listado1.extraeDato(codigos[0], 0); // OID_ACCI_PROC_BLOQ
         obj.oidTipoBloqueoSeleccionado           = listado1.extraeDato(codigos[0], 1); // OID_TIPO_BLOQ
         obj.oidProcesoBloqueoSeleccionado        = listado1.extraeDato(codigos[0], 3); // OID_PROC_BLOQ
         obj.oidAccionBloqueoSeleccionado         = listado1.extraeDato(codigos[0], 5); // OID_ACCI_BLOQ
                  
         mostrarModalSICC("LPMantenimientoAccionesProcesosBloqueos", "detalle", obj, 750, 350);
         focaliza("formulario.cbTipoBloqueo");
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
         focaliza("formulario.cbTipoBloqueo");
         return false;
    }
}

function armarArrayValoresDto() {
         var array = new Array();
         array[0] = ["oidPais", get("formulario.oidPais")];
         array[1] = ["oidIdioma", get("formulario.oidIdioma")];
         
         if (get("formulario.cbTipoBloqueo") != "") {
                  array.push(["oidTipoBloqueo", get("formulario.cbTipoBloqueo")]);
         }
         
         if (get("formulario.cbProcesoBloqueo") != "") {
                  array.push(["oidProcesoBloqueo", get("formulario.cbProcesoBloqueo")]);
         }
         
         if (get("formulario.cbAccionBloqueo") != "") {
                  array.push(["oidAccionBloqueo", get("formulario.cbAccionBloqueo")]);
         }

         return array;
}

function visualizarLista() {
         visibilidad("capaLista1", "V"); // "O" Oculta y "V" Hace visible
         visibilidad("btnDetalle", "V");
         
         if (get("formulario.opcionMenu") == "eliminar") {
         btnProxy(4, 1);
    }
}

function ocultarLista() {
         visibilidad("btnDetalle", "O"); // "O" Oculta y "V" Hace visible
         visibilidad("capaLista1", "O");
         
    if (get("formulario.opcionMenu") == "eliminar") {
         btnProxy(4, 0);
    }
}

function onShTabComboTipoBloqueo() {
         if (get_visibilidad("btnDetalle")) {
                  focalizaBotonHTML("botonContenido", "btnDetalle");
         } else {
                  focalizaBotonHTML("botonContenido", "btnBuscar");
         }
}

function onTabBuscar() {
         if (get_visibilidad("btnDetalle")) {
                  focalizaBotonHTML("botonContenido", "btnDetalle");
         } else {
                  foco("formulario.cbTipoBloqueo");
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