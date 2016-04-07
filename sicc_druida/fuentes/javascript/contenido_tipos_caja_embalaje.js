function onLoad() {
    configurarMenuSecundario('formulario');
    var acc = get('formulario.accion');

    if (acc == 'modificar') {
        completarValores();

        accion('formulario.txtCodTipoCaja', '.disabled = true');

		/*ciglesias incidencia 374 inicio*/
        //accion('formulario.cbLineaArmado', '.disabled = true');//ciglesias incidencia 385
        accion('formulario.cbCentroDistribucion', '.disabled = true');
		/*ciglesias incidencia 374 fin */

    }else if (acc == 'detalle') {
        completarValores();
        accion('formulario.cbCentroDistribucion', '.disabled = true');
        accion('formulario.txtCodTipoCaja', '.disabled = true');
        accion('formulario.txtDescripcion', '.disabled = true');
        //accion('formulario.cbLineaArmado', '.disabled = true');//ciglesias incidencia 385
        accion('formulario.cbUnidadMedidaCapacidad', '.disabled = true');
        accion('formulario.txtCapacidad', '.disabled = true');
        accion('formulario.txtCapacidadMinima', '.disabled = true');
        accion('formulario.chkCubicaje', '.disabled = true');
        accion('formulario.txtSeguridad', '.disabled = true');
        accion('formulario.txtNivelAplicacion', '.disabled = true');
        accion('formulario.txtNumEtiquetaCaja', '.disabled = true');
        accion('formulario.cbUnidadMedida', '.disabled = true');
        accion('formulario.txtAlto', '.disabled = true');
        accion('formulario.txtAncho', '.disabled = true');
        accion('formulario.txtLargo', '.disabled = true');
    }else{
        var opcionMenu = get("formulario.opcionMenu");
        if(opcionMenu!="InsertarTiposCajaEmbalaje") ocultarLista();
        setValoresPorDefecto();
    }
    focaliza('formulario.cbCentroDistribucion');
}

function onClickGuardar() {
    if (!sicc_validaciones_generales()) {
        return false;
    }
    var pctSeguridad = get('formulario.txtSeguridad')*1;
    if(pctSeguridad>=100){
        GestionarMensaje('APE048');
        return false;
    }
    
    capacidad = Number(get('formulario.txtCapacidad'));
    capacidadMin = Number(get('formulario.txtCapacidadMinima'));
    
    if(capacidadMin > capacidad){
        GestionarMensaje('APEUI062');
        return false;
    }
    
    set('formulario.lineasSeleccionadas', lineasArmadoSeleccionadas());
    set('formulario.oidCentroDistribucion', get('formulario.cbCentroDistribucion', 'V'));
    set('formulario.oidUnidadMedidaCapacidad', get('formulario.cbUnidadMedidaCapacidad', 'V'));
    set('formulario.oidUnidadMedida', get('formulario.cbUnidadMedida', 'V'));
    
    eval('formulario').oculto = 'S';
    set('formulario.conectorAction', 'LPMantenimientoTiposCajaEmbalaje');
    set('formulario.accion', 'guardar');
    var opcionMenu = get('formulario.opcionMenu');
    if ((opcionMenu == 'InsertarTiposCajaEmbalaje')) {
        enviaSICC('formulario');
        return;
    }else if (opcionMenu == 'ModificarTiposCajaEmbalaje') {
        enviaSICC('formulario', null, null, 'N');
        return;
    }
}

function onClickBuscar() {
    ocultarLista();
    
    var parametros = new Array();
    parametros[parametros.length] = new Array('oidIdioma', get('formulario.varIdioma'));
    parametros[parametros.length] = new Array('oidPais', get('formulario.varPais'));
    var centroDistribucion = get('formulario.cbCentroDistribucion','V');
    if (centroDistribucion != ''){
        parametros[parametros.length] = new Array('centroDistribucion', centroDistribucion);
    }
    var lineaArmado = get('formulario.cbLineaArmado','V');
    if (lineaArmado != ''){
        parametros[parametros.length] = new Array('lineaArmadoConsultada', lineaArmado);
    }
    var tipoCaja = get('formulario.txtCodTipoCaja');
    if (tipoCaja != ''){
        parametros[parametros.length] = new Array('tipoCaja', tipoCaja);
    }
    var descripcion = get('formulario.txtDescripcion');
    if (descripcion != ''){
        parametros[parametros.length] = new Array('descripcion', descripcion);
    }
    configurarPaginado(mipgndo,
        'APEBuscarTiposCajaEmbalaje',
        'ConectorBuscarTiposCajaEmbalaje',
        'es.indra.sicc.dtos.ape.DTOTiposCajaEmbalaje',
        parametros);
}

function onClickModificar() {
    var opcionMenu = get("formulario.opcionMenu");
    var obj = new Object();
    listado1.actualizaDat();
    var datos = listado1.datos;
    codSeleccionados = listado1.codSeleccionados();
    if (codSeleccionados.length > 1) {
        GestionarMensaje('8');
        return;
    }
    if ( codSeleccionados.length < 1) {
        GestionarMensaje('4');
        return;
    }
    //var filaMarcada = listado1.filaSelecc;
    //obj.oid = datos[filaMarcada][1];
    obj.oidTiposCajaEmbalaje = listado1.extraeDato(codSeleccionados[0], 0);
    obj.opcionMenu = opcionMenu;
    var retorno = mostrarModalSICC('LPMantenimientoTiposCajaEmbalaje', 'modificar', obj);
    onClickBuscar();
}

//--------------------------------------------------------------------------------------------------------

function onClickDetalle() {
    var opcionMenu = get("formulario.opcionMenu");
    var obj = new Object();
    listado1.actualizaDat();
    var datos = listado1.datos;
    codSeleccionados = listado1.codSeleccionados();
    if (codSeleccionados.length > 1) {
        GestionarMensaje('8');
        return;
    }
    if ( codSeleccionados.length < 1) {
        GestionarMensaje('4');
        return;
    }
    //var filaMarcada = listado1.filaSelecc;
    obj.oidTiposCajaEmbalaje = listado1.extraeDato(codSeleccionados[0], 0);
    obj.opcionMenu = opcionMenu;
    var retorno = mostrarModalSICC('LPMantenimientoTiposCajaEmbalaje', 'detalle', obj);
    //onClickBuscar();
}

function onClickEliminar() {
    if (listado1.numSelecc()== 0) {
        GestionarMensaje('1021',null,null,null);
        return false;
    } else {
        listado1.actualizaDat();
        datos = listado1.datos;
        var codSeleccionados = listado1.codSeleccionados();
        /*if (codSeleccionados.length > 1) {
            GestionarMensaje('8');
            return;
        }
        if ( codSeleccionados.length < 1) {
            GestionarMensaje('4');
            return;
        }*/
        var detallesEliminados = "";
        for (var i=0; i<codSeleccionados.length ; i++){   
            if(listado1.extraeDato(codSeleccionados[i], 1)!="BLANCO") {
                if(detallesEliminados==""){
                    detallesEliminados = detallesEliminados + listado1.extraeDato(codSeleccionados[i], 0);
                } else {
                    detallesEliminados = detallesEliminados + "," + listado1.extraeDato(codSeleccionados[i], 0);
                }
            }
        }
        //ocultarLista();
        eliminarFilas(detallesEliminados.split(","),"APEEliminarTiposCajaEmbalaje", mipgndo);
    }
}

function onChangeCbCentroDistribucion() {
    var oidCentro = get('formulario.cbCentroDistribucion', 'V');
    if (oidCentro != '') {
        var array = new Array();
        array[0] = new Array('oid',oidCentro);
        array[1] = new Array('oidIdioma',get('formulario.varIdioma'));
        set_combo('formulario.cbLineaArmado', arrayVacio());
        recargaCombo('formulario.cbLineaArmado',
            'APEObtenerLineasArmadoCD',
            'es.indra.sicc.util.DTOOID',
            array,
            'setearCbLineaArmado(datos)');
    } else {
        set_combo('formulario.cbLineaArmado', new Array(['','']));
    }
}

function setearCbLineaArmado(datos) {
    var arrayNuevo = new Array();
    arrayNuevo[0] = new Array('','');
    arrayNuevo = arrayNuevo.concat(datos);
    set_combo('formulario.cbLineaArmado',arrayNuevo);

    var acc = get('formulario.accion');

    if ( (acc == 'modificar') || (acc == 'detalle') ) {
        //Obtengo los valores que mando la LP
        var lineasAnteriores = get('formulario.lineasAnteriores');
        if(lineasAnteriores!=''){
            // Asigno los valores
            set('formulario.cbLineaArmado', lineasAnteriores.split(","));
        }
    }
}

function lineasArmadoSeleccionadas(){
    var codigos = get('formulario.cbLineaArmado','V');
    var cadena = '';
    for (var i=0; i<codigos.length ; i++){
        scodigo = codigos[i];
        if(scodigo !=  '' ){
            cadena = cadena + scodigo + ',';
        }
    }
    cadena = cadena.substring(0,cadena.length-1);
    return cadena;    
}

function cerrarModal(){
    var retorno = new Array();
    retorno[0] = "OK";
    returnValue = retorno;
    close();
}

function fVolver() {
    this.close();
}

function fGuardar(){
    onClickGuardar();
}

function fBorrar() {
    onClickEliminar();
}

function fLimpiar() {
    set('formulario.cbCentroDistribucion', '');
    set_combo('formulario.cbLineaArmado', arrayVacio());
    set('formulario.cbUnidadMedidaCapacidad', '');
    set('formulario.cbUnidadMedida', '');
    set('formulario.txtNroPedidoArmado', '');
    set('formulario.txtNroUnidades', '');
    set('formulario.txtParamDistrib', '');
    set('formulario.txtCodTipoCaja', '');
    set('formulario.txtDescripcion', '');
    set('formulario.txtCapacidad', '');
    set('formulario.txtCapacidadMinima', '');
    set('formulario.chkCubicaje', 'N');
    set('formulario.txtSeguridad', '');
    set('formulario.txtNivelAplicacion', '');
    set('formulario.txtNumEtiquetaCaja', '');
    set('formulario.txtAlto', '');
    set('formulario.txtAncho', '');
    set('formulario.txtLargo', '');
    
    var opcionMenu = get("formulario.opcionMenu");
    var accion = get("formulario.accion");
    
    if (opcionMenu != "InsertarTiposCajaEmbalaje") {
        ocultarLista();
    }
    if ( opcionMenu == "InsertarTiposCajaEmbalaje" 
        || (opcionMenu == "ModificarTiposCajaEmbalaje" && accion == "modificar") ) {
        limpiaI18N("formulario", "1");
    }
    
    setValoresPorDefecto();
    
}

function arrayVacio(){
    var array = new Array();
    array[0] = new Array('','');
    return array;
}

function completarValores(){
    set('formulario.cbCentroDistribucion', [get('formulario.oidCentroDistribucion')]);
    onChangeCbCentroDistribucion();
    set('formulario.cbUnidadMedidaCapacidad', [get('formulario.oidUnidadMedidaCapacidad')]);
    set('formulario.cbUnidadMedida', [get('formulario.oidUnidadMedida')]);
}

function muestraLista(ultima, rowset) {
    var tamano = rowset.length;
    if (tamano > 0) {
        mostrarLista();
        return true; 
    }else{
        ocultarLista();
        focaliza('formulario.cbCentroDistribucion');
        return false;  
    }
}

function mostrarLista(){
    DrdEnsanchaConMargenDcho('listado1',12);
    document.all["Cplistado1"].style.visibility='visible';
    document.all["CpLin1listado1"].style.visibility='visible';
    document.all["CpLin2listado1"].style.visibility='visible';
    document.all["CpLin3listado1"].style.visibility='visible';
    document.all["CpLin4listado1"].style.visibility='visible';
    document.all["primera1Div"].style.visibility='visible';
    document.all["ret1Div"].style.visibility='visible';
    document.all["ava1Div"].style.visibility='visible';
    document.all["separaDiv"].style.visibility='visible';
    var opcionMenu = get('formulario.opcionMenu');
    if (opcionMenu == 'ModificarTiposCajaEmbalaje') {
        document.all["btnModificarDiv"].style.visibility='visible';
    } else if (opcionMenu = 'ConsultarTiposCajaEmbalaje' || opcionMenu == 'EliminarTiposCajaEmbalaje') {
        document.all["btnDetalleDiv"].style.visibility='visible';
    }
    if (get('formulario.opcionMenu')=='EliminarTiposCajaEmbalaje') {
        btnProxy(4,1);
    }
    eval (ON_RSZ);
}

function ocultarLista() {
	document.all["Cplistado1"].style.visibility='hidden';
	document.all["CpLin1listado1"].style.visibility='hidden';
	document.all["CpLin2listado1" ].style.visibility='hidden';
	document.all["CpLin3listado1"].style.visibility='hidden';
	document.all["CpLin4listado1"].style.visibility='hidden';
	document.all["primera1Div"].style.visibility='hidden';
	document.all["ret1Div"].style.visibility='hidden';
	document.all["ava1Div"].style.visibility='hidden';
	document.all["separaDiv"].style.visibility='hidden';    
	document.all["btnDetalleDiv"].style.visibility='hidden';
	document.all["btnModificarDiv"].style.visibility='hidden';
	btnProxy(4,0);
}

function setValoresPorDefecto(){
    var oidCentroVD = get('formulario.centroDistribucionVD');
    if (oidCentroVD!=''){
        set('formulario.cbCentroDistribucion', [get('formulario.centroDistribucionVD')]);
        onChangeCbCentroDistribucion();
    }
}

function onChangeLA() {
	if ((get("formulario.accion") == "modificar") || (get("formulario.accion") == "detalle")){
        var lineasAnteriores = get('formulario.lineasAnteriores');
        if(lineasAnteriores!=''){
            // Asigno los valores
            set('formulario.cbLineaArmado', lineasAnteriores.split(","));
        }
	}
}

function onClickLA() {
	if ((get("formulario.accion") == "modificar") || (get("formulario.accion") == "detalle")){
        var lineasAnteriores = get('formulario.lineasAnteriores');
        if(lineasAnteriores!=''){
            // Asigno los valores
            set('formulario.cbLineaArmado', lineasAnteriores.split(","));
        }
	}
}

function onFocusLA() {
	if ((get("formulario.accion") == "modificar") || (get("formulario.accion") == "detalle")){
        var lineasAnteriores = get('formulario.lineasAnteriores');
        if(lineasAnteriores!=''){
            // Asigno los valores
            set('formulario.cbLineaArmado', lineasAnteriores.split(","));
        }
	}
}
