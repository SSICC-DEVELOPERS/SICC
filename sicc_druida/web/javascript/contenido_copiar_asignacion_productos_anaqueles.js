/**
 * Copyright 2007 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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

function onLoadPag() {
    configurarMenuSecundario("formulario");
    gestionarVisibilidadLista('hidden');
    
    var defaultOidComboCD = get('formulario.defaultOidComboCD');
    if (defaultOidComboCD != '') {
        set('formulario.cbCentroDistribucion', [[defaultOidComboCD]]);
        foco("formulario.cbMarca");
    } else {
        foco("formulario.cbCentroDistribucion");
    }
    fMostrarMensajeError();
}

function onBuscar() {
    if ( !sicc_validaciones_generales() ) {
        return false;
    }
    
    d3ocupado_ver('d3general', 'C');
    var arra = new Array();
    arra[0] = ["oidPais", get('formulario.oidPais')];
    arra[1] = ["oidIdioma", get('formulario.oidIdioma')];
    arra[2] = ["oidCentroDistribucion", get('formulario.cbCentroDistribucion')];
    arra[3] = ["oidPeriodo", get('formulario.cbPeriodo')];
    configurarPaginado(mipgndo, "APEConsultarVersionesAsignacion", "ConectorConsultarVersionesAsignacion",
                       "es.indra.sicc.dtos.ape.DTOMantenerAsignacionProductosAnaqueles", arra);
}

function onCopiar() {
    if ( !sicc_validaciones_generales() ) {
        return false;
    }
    
    var codigos = new Array();
    codigos = listado1.codSeleccionados();
    var cant = codigos.length;
    
    if (cant != 1) {
        GestionarMensaje('50');
        return false;
    }
    set('formulario.oidAPACOrigenSeleccionado', codigos[0]);
    set('formulario.oidMapaCDOrigenSeleccionado', listado1.extraeDato(codigos[0], 4)); // oidMapaCentroDistribucion
    set('formulario.oidMapaZonaOrigenSeleccionado', listado1.extraeDato(codigos[0], 5)); // oidMapaDeZonas
    
    set('formulario.conectorAction', 'LPCopiarAsignacionProductosAnaqueles');
    set('formulario.accion', 'copiar');
    eval('formulario').oculto = 'S';
    enviaSICC('formulario');
}

function onChangeCbMarca() {
    cargarPeriodos();
}

function onChangeCbCanal() {
    cargarPeriodos();
}

function cargarPeriodos() {
    set_combo('formulario.cbPeriodo', [['','']], [null]);
    
    var pais  = get('formulario.oidPais');
    var marca = get('formulario.cbMarca');
    var canal = get('formulario.cbCanal');
    
    if (pais != '' && marca != '' && canal != '') {
        var arrayDtoPeriodo = new Array();
        arrayDtoPeriodo[0] = ["pais",  pais];
        arrayDtoPeriodo[1] = ["marca", marca];
        arrayDtoPeriodo[2] = ["canal", canal];
        arrayDtoPeriodo[3] = ["oidIdioma", get('formulario.oidIdioma')];
        recargaCombo("formulario.cbPeriodo", "CRAObtienePeriodos", "es.indra.sicc.dtos.cra.DTOPeriodo", arrayDtoPeriodo);
    }
}

function shTabCentroDistribucion() {
    var visibBtnCopiar = document.getElementById("btnCopiarDiv").style.visibility;
    
    if (visibBtnCopiar == 'hidden') {
        focalizaBotonHTML('botonContenido', 'btnBuscar');
    } else {
        focalizaBotonHTML('botonContenido', 'btnCopiar');
    }
}

function tabBtnBuscar() {
    var visibBtnCopiar = document.getElementById("btnCopiarDiv").style.visibility;
    
    if (visibBtnCopiar == 'hidden') {
        foco('formulario.cbCentroDistribucion');
    } else {
        focalizaBotonHTML('botonContenido', 'btnCopiar');
    }
}

function muestraLista(ultima, rowset) {
    var tamano = rowset.length;
    d3ocupado_ocultar('d3general');
    
    if (tamano > 0) {
        gestionarVisibilidadLista('visible');
		deshabilitarCamposBusqueda();
        return true;
    } else {
        gestionarVisibilidadLista('hidden');
        habilitarCamposBusqueda();
        focaliza('formulario.cbCentroDistribucion');
        return false;
    }
}

function mostrarMensajeCopiaExitosa(codVersionDestino) {
    GestionarMensaje('APE038', codVersionDestino);
    
    set('formulario.conectorAction', 'LPCopiarAsignacionProductosAnaqueles');
    set('formulario.accion', '');
    eval('formulario').oculto = 'N';
    enviaSICC('formulario');
}

function mostrarMensajeCopiaErronea() {
    focaliza('formulario.txtVersionDestino');
}

function fLimpiar() {
    set('formulario.oidAPACOrigenSeleccionado', '');
    set('formulario.oidMapaCDOrigenSeleccionado', '');
    set('formulario.oidMapaZonaOrigenSeleccionado', '');
    
    var defaultOidComboCD = get('formulario.defaultOidComboCD');
    set('formulario.cbCentroDistribucion', [[defaultOidComboCD]]);
    
    set_combo('formulario.cbPeriodo', [['','']], [null]);
    
    var iSeleccionado = new Array();
    iSeleccionado[0] = new Array();
    set('formulario.cbMarca', iSeleccionado);
    set('formulario.cbCanal', iSeleccionado);
    
    set('formulario.txtVersionDestino', '');
    
    gestionarVisibilidadLista('hidden');
    
    habilitarCamposBusqueda();
    
    if (defaultOidComboCD != '') {
        foco('formulario.cbMarca');
    } else {
        foco('formulario.cbCentroDistribucion');
    }
    
}

function gestionarVisibilidadLista(visibilidad) {
    DrdEnsanchaConMargenDcho('listado1', 24);
    
    document.all["Cplistado1"].style.visibility=visibilidad;
    document.all["CpLin1listado1"].style.visibility=visibilidad;
    document.all["CpLin2listado1"].style.visibility=visibilidad;
    document.all["CpLin3listado1"].style.visibility=visibilidad;
    document.all["CpLin4listado1"].style.visibility=visibilidad;
    
    document.all["primera1Div"].style.visibility=visibilidad;
    document.all["ret1Div"].style.visibility=visibilidad;
    document.all["ava1Div"].style.visibility=visibilidad;
    document.all["separaDiv"].style.visibility=visibilidad;
    
    document.all["btnCopiarDiv"].style.visibility=visibilidad;
    
    eval(ON_RSZ);
}

function deshabilitarCamposBusqueda() {
    accion('formulario.cbCentroDistribucion','.disabled=true');
    accion('formulario.cbMarca',             '.disabled=true');
    accion('formulario.cbCanal',             '.disabled=true');
    accion('formulario.cbPeriodo',           '.disabled=true');
    deshabilitarHabilitarBoton('botonContenido','btnBuscar','D');
}

function habilitarCamposBusqueda() {
    accion('formulario.cbCentroDistribucion','.disabled=false');
    accion('formulario.cbMarca',             '.disabled=false');
    accion('formulario.cbCanal',             '.disabled=false');
    accion('formulario.cbPeriodo',           '.disabled=false');
    deshabilitarHabilitarBoton('botonContenido','btnBuscar','A');
}