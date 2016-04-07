function init() {
        configurarMenuSecundario("frmContenido");
        fMostrarMensajeError();
        if (get('frmContenido.cartel')=="1")
          {
            var obj = new Object();
            obj.accion = "Reporte";
            mostrarModalSICC('LPValidaFaltantes','Reporte',obj,830,495); 
          }
        focaliza('frmContenido.cbSeleccioneOpcion','');
    }

    function fVolver(){
        window.close();
    }

    function fLimpiar(){
        focaliza('frmContenido.cbSeleccioneOpcion','');
    }

    function aceptar(){
        if(!sicc_validaciones_generales()){
            return false;
        }
        if((get('frmContenido.cbSeleccioneOpcion')=='ver')||
           (get('frmContenido.cbSeleccioneOpcion')=='aprobar')){
           if ((get('frmContenido.varOidLoteReporteFaltantes')==null)||
               (get('frmContenido.varOidLoteReporteFaltantes')=='')){
               GestionarMensaje("PED009", null, null, null);
               return false;
           }
        }
        set ('frmContenido.accion',get('frmContenido.cbSeleccioneOpcion'));
        enviaSICC('frmContenido');
    }