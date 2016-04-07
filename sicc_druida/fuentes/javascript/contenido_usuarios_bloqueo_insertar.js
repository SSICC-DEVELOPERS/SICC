function onLoad() {
         configurarMenuSecundario("formulario");
         
         var opcionMenu = get("formulario.opcionMenu");
         
         if (opcionMenu == "insertar") {
         txt_to("nombreUsuario", "");
         txt_to("lblNombreUsuario", "");
                  foco("formulario.txtCodigoUsuario");
         }
         
         fMostrarMensajeError();
}

function validarCodigoUsuario() {
    set("formulario.idUser", "");
    txt_to("nombreUsuario", "");
    
    if ("formulario.txtCodigoUsuario" == '') {
                  return;
         }
         
    set("formulario.conectorAction", "LPMantenimientoUsuariosBloqueo");
    set("formulario.accion", "validarCodigoUsuario");
         eval('formulario').oculto = 'S';
    enviaSICC("formulario");
    return;
}

function fGuardar() {
         if (!sicc_validaciones_generales()) {
                  return;
         }
         
    set("formulario.conectorAction", "LPMantenimientoUsuariosBloqueo");
    set("formulario.accion", "guardar");
         eval('formulario').oculto = 'S';
    enviaSICC("formulario");
    return;
}

function fLimpiar() {
    
         if (get("formulario.opcionMenu") == "insertar") {
         set("formulario.idUser", '');
         
                  set("formulario.cbAccionPermitida", ['']);
                  set("formulario.cbTipoBloqueo", ['']);
                  set("formulario.txtCodigoUsuario", '');

         txt_to("nombreUsuario", "");

                  foco("formulario.txtCodigoUsuario");

         } else if (get("formulario.opcionMenu") == "modificar") {
                  set("formulario.cbAccionPermitida", [get("formulario.oidAccionPermitida")]);
                  foco("formulario.cbAccionPermitida");
         }

}

function fVolver() {
         this.close();
}

function guardarOk() {
    if (get('formulario.opcionMenu') == "modificar") {
         var arrayParaDevolver = new Array();
         
         arrayParaDevolver[0] = get('formulario.cbAccionPermitida');
         arrayParaDevolver[1] = get('formulario.cbAccionPermitida', 'T');
         
         window.returnValue = arrayParaDevolver;
    }
    
         fLimpiar();
}

function guardarError() {
         foco("formulario.cbAccionPermitida");
}

function validacionUsuarioOk(idUser, nombreCompleto) {
    set("formulario.idUser", idUser);
         if (get('formulario.opcionMenu') != 'insertar') {
             txt_to("nombreUsuario", nombreCompleto);
         }
    foco("formulario.cbTipoBloqueo");
}

function validacionUsuarioError(codigoUsuario) {
    GestionarMensaje('MAE0051', codigoUsuario); // Código Usuario no existe, introduzca otro valor
         set("formulario.idUser", ''); // dmorello, 13/11/2007
         set("formulario.txtCodigoUsuario", '');
    foco("formulario.txtCodigoUsuario");
}

function onTabAccionPermitida() {
    if (get("formulario.opcionMenu") == "insertar") {
         foco('formulario.txtCodigoUsuario');
    }
}