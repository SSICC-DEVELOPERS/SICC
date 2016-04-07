function onLoadPag() {
    configurarMenuSecundario("formulario");
    ocultarLista();
    fMostrarMensajeError();
    focaliza("formulario.cbCodComision");
    
    btnProxy(1,0);
    btnProxy(2,0);
    btnProxy(3,1);
    btnProxy(4,0);
    btnProxy(5,1);
    btnProxy(6,1);
    btnProxy(7,1);
    btnProxy(8,1);
    btnProxy(9,1);
    btnProxy(10,1);
}

function onSeleccionaCodigo() {
    recargaCombo('formulario.cbVersion', 'COMVersionesComision','es.indra.sicc.dtos.com.DTOCodigoComision',[['codComision', get("formulario.cbCodComision", "T")]]);
}

function onClickBuscar() {
    var arr = [ ["oidPais", get("formulario.varOidPais")], 
                ["oidIdioma", get("formulario.varOidIdioma")], 
                ["descripcion", get("formulario.txtDescripcionComision")], 
                ["oidCanal", get("formulario.cbCanal")], 
                ["oidAcceso", get("formulario.cbAcceso")], 
                ["oidMarca", get("formulario.cbMarca")], 
                ["codigo", get("formulario.cbCodComision", "T")], 
                ["version", get("formulario.cbVersion")], 
                ["oidTipoComision", get("formulario.cbTipoComision")] ];
    configurarPaginado(mipgndo, 
                       "COMBuscarMarcarModificar", 
                       "ConectorBuscarMarcarModificar", 
                       "es.indra.sicc.dtos.com.DTOBuscarMarcarModificar", 
                       arr);
}

function onClickMarcar() {
    var cantSeleccionados = listado1.numSelecc();
    
    if(cantSeleccionados == 1) {
        var posicion = obtenerPosicionListaEditable(listado1.codSeleccionados(),listado1);
        set('formulario.oidComision',listado1.datos[posicion][1]); 
        set('formulario.oidCanal',listado1.datos[posicion][10]); 
        eval('formulario').oculto = 'S';
        set('formulario.conectorAction', 'LPMantenimientoComisiones');
        set('formulario.accion', 'MarcarModificar');
        enviaSICC('formulario', null, null, 'N');
    } else if (cantSeleccionados > 1) {
        cdos_mostrarAlert(GestionarMensaje("240"));          
    } else if (cantSeleccionados < 1) {
        GestionarMensaje("4");
    }
}

function resetButtons(){
    btnProxy(1,0);
    btnProxy(4,0);
}

function fLimpiar() {
    var arr = new Array(); 
    arr[0] = "";
    set('formulario.cbCodComision', arr);
    set_combo('formulario.cbVersion', [['','']], [null]);
    set('formulario.cbTipoComision', arr);
    set('formulario.cbMarca', arr);
    set('formulario.cbCanal', arr);
    set('formulario.cbAcceso', arr);
    set('formulario.txtDescripcionComision', '');
    focaliza('formulario.cbCodComision');
    ocultarLista();
}

function toDetalle() {
    if (document.all["btnSolicitarModificacionDiv"].style.visibility == 'visible') {
        focalizaBotonHTML('botonContenido','btnSolicitarModificacion');
    } else { 
        if (arguments[0]) {
            focalizaBotonHTML('botonContenido','btnBuscar');
        } else {
            focaliza('formulario.cbCodComision');
        }
    }
}

function muestraLista(ultima, rowset) {
    var tamano = rowset.length;
            
    if (tamano > 0) {
        visualizarLista();
        return true;
    } else {
        // No se ha encontrado ningún elemento con los criterios especificados
        ocultarLista();
        focaliza('formulario.cbCodComision');
        return false;
    }
}

function visualizarLista() {
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
    
    document.all["btnSolicitarModificacionDiv"].style.visibility='visible';

    eval (ON_RSZ);
}

function ocultarLista() {
    document.all["Cplistado1"].style.visibility='hidden';
    document.all["CpLin1listado1"].style.visibility='hidden';
    document.all["CpLin2listado1"].style.visibility='hidden';
    document.all["CpLin3listado1"].style.visibility='hidden';
    document.all["CpLin4listado1"].style.visibility='hidden';

    document.all["primera1Div"].style.visibility='hidden';
    document.all["ret1Div"].style.visibility='hidden';
    document.all["ava1Div"].style.visibility='hidden';
    document.all["separaDiv"].style.visibility='hidden';

    document.all["btnSolicitarModificacionDiv"].style.visibility='hidden';
}