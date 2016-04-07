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
var fechaSistema;

function onLoad() {
    configurarMenuSecundario("formulario");
    
    DrdEnsanchaConMargenDcho('listado1', 24);
    gestionarVisibilidadLista('hidden');
    eval(ON_RSZ);
    
    foco("formulario.cmbCentroDistribucion");
    fechaSistema = get('formulario.txtFecha');
    fMostrarMensajeError();
}

function onChangeCmbCentroDistribucion() {
    set_combo('formulario.cmbLineaArmado', [['','']], [null]);
    
    var pais  = get('formulario.oidPais');
    var idioma  = get('formulario.oidIdioma');
    var oidCD = get('formulario.cmbCentroDistribucion');
    
    if (pais != '' && oidCD != '') {
        var arrayDtoOid = new Array();
        arrayDtoOid[0] = ["oidPais",  pais];
        arrayDtoOid[1] = ["oidIdioma",  idioma];
        arrayDtoOid[2] = ["oid", oidCD];
        recargaCombo('formulario.cmbLineaArmado', 'APEObtenerLineasArmadoCDAFP',
                     'es.indra.sicc.util.DTOOID', arrayDtoOid, 'autoseleccionarLineaUnica(datos);');
    }
}

function onChangeCmbMarca() {
    recargaRegiones();
}

function onChangeCmbCanal() {
    recargaRegiones();
}

function onChangeCmbRegion() {
    recargaZonas();
}

function onChangeCmbZona() {
    recargaSecciones();
}

function onClickBuscar() {
    if ( !sicc_validaciones_generales() ) {
        return false;
    }
    
    d3ocupado_ver('d3general', 'C');
    var arra = new Array();
    arra[0] = ["oidPais", get('formulario.oidPais')];
    arra[1] = ["oidIdioma", get('formulario.oidIdioma')];
    arra[2] = ["oidCentroDistribucion", get('formulario.cmbCentroDistribucion')];
    arra[3] = ["oidLineaArmado", get('formulario.cmbLineaArmado')];
    arra[4] = ["oidMarca", get('formulario.cmbMarca')];
    arra[5] = ["oidCanal", get('formulario.cmbCanal')];
    arra[6] = ["oidRegion", get('formulario.cmbRegion')];
    arra[7] = ["oidZona", get('formulario.cmbZona')];
    arra[8] = ["oidSeccion", get('formulario.cmbSeccion')];
    arra[9] = ["fecha", get('formulario.txtFecha')];
    configurarPaginado(mipgndo, "APEBuscarEtiquetasFP", "ConectorBuscarEtiquetasFP",
                       "es.indra.sicc.dtos.ape.DTOImpresionFP", arra);
}

function onClickBtnImprimir() {
    var seleccionados = listado1.codSeleccionados();
    var cantSeleccionados = seleccionados.length;
    
    if (cantSeleccionados > 0) {
        eval('formulario').oculto = 'S';
        set('formulario.hOidsListasPicadoAImprimir', seleccionados.toString()); // Son los oid de Listas de Picado separados por coma
        set('formulario.conectorAction', 'LPImpresionEtiquetasFueraPedido');
        set('formulario.accion', 'imprimir');
        enviaSICC('formulario', null, null, 'N');
        
    } else {
        GestionarMensaje("4");
        return false;
    }
}

function recargaRegiones() {
    set_combo('formulario.cmbRegion', [['','']], [null]);
    set_combo('formulario.cmbZona', [['','']], [null]);
    set_combo('formulario.cmbSeccion', [['','']], [null]);
    
    var pais  = get('formulario.oidPais');
    var marca = get('formulario.cmbMarca');
    var canal = get('formulario.cmbCanal');
    
    if (pais != '' && marca != '' && canal != '') {
        var arrayDtoUA = new Array();
        arrayDtoUA[0] = ["oidPais",  pais];
        arrayDtoUA[1] = ["oidMarca", marca];
        arrayDtoUA[2] = ["oidCanal", canal];
        recargaCombo("formulario.cmbRegion", "ZONRecargaRegiones", "es.indra.sicc.dtos.zon.DTOUnidadAdministrativa", arrayDtoUA);
    }
}

function recargaZonas() {
    set_combo('formulario.cmbZona', [['','']], [null]);
    set_combo('formulario.cmbSeccion', [['','']], [null]);
    
    var pais  = get('formulario.oidPais');
    var region = get('formulario.cmbRegion');
    
    if (pais != '' && region != '') {
        var arrayDtoUA = new Array();
        arrayDtoUA[0] = ["oidPais",  pais];
        arrayDtoUA[1] = ["oidRegion", region];
        recargaCombo("formulario.cmbZona", "ZONRecargaZonas", "es.indra.sicc.dtos.zon.DTOUnidadAdministrativa", arrayDtoUA);
    }
}

function recargaSecciones() {
    set_combo('formulario.cmbSeccion', [['','']], [null]);
    
    var pais  = get('formulario.oidPais');
    var zona = get('formulario.cmbZona');
    
    if (pais != '' && zona != '') {
        var arrayDtoUA = new Array();
        arrayDtoUA[0] = ["oidPais",  pais];
        arrayDtoUA[1] = ["oidZona", zona];
        recargaCombo("formulario.cmbSeccion", "ZONRecargaSecciones", "es.indra.sicc.dtos.zon.DTOUnidadAdministrativa", arrayDtoUA);
    }
}

function fLimpiar() {
    set('formulario.hOidsListasPicadoAImprimir', '');
    gestionarVisibilidadLista('hidden');
    
    var iSeleccionado = new Array();
    iSeleccionado[0] = new Array();
    set('formulario.cmbCentroDistribucion', iSeleccionado);
    set('formulario.cmbMarca', iSeleccionado);
    set('formulario.cmbCanal', iSeleccionado);
    
    set_combo('formulario.cmbLineaArmado', [['','']], [null]);
    set_combo('formulario.cmbRegion', [['','']], [null]);
    set_combo('formulario.cmbZona', [['','']], [null]);
    set_combo('formulario.cmbSeccion', [['','']], [null]);
    set('formulario.txtFecha', fechaSistema);
    
    
    foco('formulario.cmbCentroDistribucion');
}

function tabBtnBuscar() {
    var visibBtnImprimir = document.getElementById("btnImprimirDiv").style.visibility;
    
    if (visibBtnImprimir == 'hidden') {
        foco('formulario.cmbCentroDistribucion');
    } else {
        focalizaBotonHTML('botonContenido', 'btnImprimir');
    }
}

function shTabCentroDistribucion() {
    var visibBtnImprimir = document.getElementById("btnImprimirDiv").style.visibility;
    
    if (visibBtnImprimir == 'hidden') {
        focalizaBotonHTML('botonContenido', 'btnBuscar');
    } else {
        focalizaBotonHTML('botonContenido', 'btnImprimir');
    }
}

function muestraLista(ultima, rowset) {
    var tamano = rowset.length;
    d3ocupado_ocultar('d3general');
    
    if (tamano > 0) {
        gestionarVisibilidadLista('visible');
        return true;
    } else {
        gestionarVisibilidadLista('hidden');
        focaliza('formulario.cmbCentroDistribucion');
        return false;
    }
}

function gestionarVisibilidadLista(visibilidad) {    
    document.all["Cplistado1"].style.visibility=visibilidad;
    document.all["CpLin1listado1"].style.visibility=visibilidad;
    document.all["CpLin2listado1"].style.visibility=visibilidad;
    document.all["CpLin3listado1"].style.visibility=visibilidad;
    document.all["CpLin4listado1"].style.visibility=visibilidad;
    
    document.all["primera1Div"].style.visibility=visibilidad;
    document.all["ret1Div"].style.visibility=visibilidad;
    document.all["ava1Div"].style.visibility=visibilidad;
    document.all["separaDiv"].style.visibility=visibilidad;
    
    document.all["btnImprimirDiv"].style.visibility=visibilidad;
    document.all["btnReImprimirDiv"].style.visibility='hidden'; // TODO
}

function impresionLanzadaExitosamente() {
    /* BELC400000354 - dmorello, 12/04/2007 */
	//fLimpiar();
	GestionarMensaje('APEUI048');
}

function autoseleccionarLineaUnica(datos) {
    if (datos!='') {
        var oidLineaUnica = '';
        var cantOpciones = datos.length;
        var arrRes = new Array();
        arrRes[arrRes.length] = new Array();
        
        for (var i=0; i<cantOpciones;i++) {
            arrRes[arrRes.length] = datos[i];
            
            if (datos[i][0] != '') {
                oidLineaUnica = datos[i][0];
            }
        }
        set_combo('formulario.cmbLineaArmado', arrRes, []);
        
        if (cantOpciones == 1) { // Una unica Linea de Armado (y además como siempre opcion vacia)
            set('formulario.cmbLineaArmado', [[oidLineaUnica]]);
        }
    }
}
