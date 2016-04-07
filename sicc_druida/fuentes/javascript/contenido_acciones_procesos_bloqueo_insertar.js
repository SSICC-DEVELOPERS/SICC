function onLoad() {
         configurarMenuSecundario("formulario");
         
         var opcionMenu = get("formulario.opcionMenu");
         
         if (opcionMenu == "insertar") {
                  foco("formulario.cbTipoBloqueo");
         }
         
         fMostrarMensajeError();
}

function recargarComboAcciones() {
         recargaCombo("formulario.cbAccionBloqueo", "MAEObtenerAccionesBloqueo", 
                                     "es.indra.sicc.util.DTOOID", 
                                     [ ["oidPais", get("formulario.oidPais")], 
                                        ["oidIdioma", get("formulario.oidIdioma")], 
                                        ["oid", get("formulario.cbProcesoBloqueo")] ]);
}

function fGuardar() {
         if (!sicc_validaciones_generales()) {
                  return;
         }
         
    set("formulario.conectorAction", "LPMantenimientoAccionesProcesosBloqueos");
    set("formulario.accion", "guardar");
         eval('formulario').oculto = 'S';
    enviaSICC("formulario");
}

function fLimpiar() {
         if (get("formulario.opcionMenu") == "insertar") {
                  set_combo("formulario.cbAccionBloqueo", [['','']]);
                  set("formulario.cbProcesoBloqueo", ['']);
                  set("formulario.cbTipoBloqueo", ['']);
                  foco("formulario.cbTipoBloqueo");
         }
}

function fVolver() {
         this.close();
}

function guardarOk() {
         fLimpiar();
}

function guardarError() {
         foco("formulario.cbTipoBloqueo");
}

