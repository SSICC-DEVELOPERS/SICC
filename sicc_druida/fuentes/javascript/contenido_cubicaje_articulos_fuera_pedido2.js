function onLoad(){
    configurarMenuSecundario('formulario');
}

function accionBtnAceptar(){
    if (!sicc_validaciones_generales()) {
        return false;
    }
    // Validar que la cantidad sea menor al numero de unidades
    var nuevaCantidad = get('formulario.txtNumUnidNuevaLinea')*1;
    var numUnidades = get('formulario.hNumUnidades')*1;
    if((nuevaCantidad >= numUnidades) || (nuevaCantidad < 1)){
        cdos_mostrarAlert(GestionarMensaje('3379'));  // El numero de unidades introducido no es correcto
        focaliza('formulario.txtNumUnidNuevaLinea');
        return;
    }
    // Indicando valor de retorno
    this.returnValue = nuevaCantidad;
    this.close();
}

function fVolver() {
    this.close();
}
