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
    if(get('formulario.restauraOidCD') != '') {
        restaurarSeleccionCombosPagina();
        deshabilitarCamposCabecera();
        visualizarLista();
    } else {
        ocultarLista();
        var defaultOidComboCD = get('formulario.defaultOidComboCD');
        if (defaultOidComboCD != '') {
            set('formulario.cbCentroDistribucion', [[defaultOidComboCD]]);
        }
        focaliza("formulario.cbCentroDistribucion");
    }
    fMostrarMensajeError();
}

// *** Recargas
function onChangeCbCentroDistribucion() {
    set_combo('formulario.cbMapaCentro', [['','']], [null]);
    var arra = new Array();
    arra[0] = ["oidPais", get('formulario.oidPais')];
    arra[1] = ["oidIdioma", get('formulario.oidIdioma')];
    arra[2] = ["oid", get('formulario.cbCentroDistribucion')];
    recargaCombo("formulario.cbMapaCentro", "APEObtenerMapasCDPorCD", "es.indra.sicc.util.DTOOID", arra);
    
    recargaVersiones();
}

function onChangeCbMapaCentroDistribucion() {    
    recargaVersiones();
}



function onChangeCbMarca() {
    cargarPeriodos();
    recargaVersiones();
}

function onChangeCbCanal() {
    cargarPeriodos();    
    recargaVersiones();
}

function onChangeCbPeriodo() {
    recargaVersiones();
}



// *** Acciones
function onClickAsignar() {
    if (!sicc_validaciones_generales("obligatoriosSinVersion") 
            || !sicc_validaciones_generales("version")) {
         return false;
    }
    
    deshabilitarCamposCabecera();
    visualizarLista();
    clickAniadir();
}

function onClickDesasignar() { // Inicia el CU: Desasignar Productos/Anaqueles
    if (!sicc_validaciones_generales("obligatoriosSinVersion") 
            || !sicc_validaciones_generales("version")) {
         return false;
    }
    var obj = new Object();
    obj.oidVersion = get('formulario.cbVersion');
    obj.descCentroDistribucion = get('formulario.cbCentroDistribucion', 'T');
    obj.descMapaCentroDistribucion = get('formulario.cbMapaCentro', 'T');
    obj.descMarca = get('formulario.cbMarca', 'T');
    obj.descCanal = get('formulario.cbCanal', 'T');
    obj.descPeriodo = get('formulario.cbPeriodo', 'T');
    obj.descVersion = get('formulario.cbVersion', 'T');
    
    mostrarModalSICC('LPMantenerAsignacionManualProductos', 'desasignar', obj, 750, 600);
    
    focalizaBotonHTML('botonContenido', 'btnDesasignar');
}

function onClickAniadir() {

    if (hayAnaquelRepetido()) {
        return false;
    }

    var codigos = listado1.codigos();
    var validaAnaquel="N";
    
    if(codigos.length!=0){    
        for(var i=0; i<codigos.length; i++){
            codigo = codigos[i];
            
            if(listado1.extraeDato(codigo, 2)=="" && listado1.extraeDato(codigo, 3)==""){
                validaAnaquel="S";
                // Valida obligatoriedad 
                if(listado1.extraeDato(codigo, 0)=="") {
                     GestionarMensaje('2587');
                     eval("listado1.preparaCamposDR()");
                     focaliza('frm'+'listado1'+'.'+'txtCodAnaquel'+'_'+i,'');
                     return;
                }
                
                if(listado1.extraeDato(codigo, 1)=="") {
                     GestionarMensaje('2588');
                     eval("listado1.preparaCamposDR()");
                     focaliza('frm'+'listado1'+'.'+'txtCodProducto'+'_'+i,'');
                     return;
                }
                
                set('formulario.hCodFilaAValidar', codigo);
                set('formulario.hCodAnaquelAValidar', listado1.extraeDato(codigo, 0));
                set('formulario.hCodProductoAValidar', listado1.extraeDato(codigo, 1));
                set('formulario.hBotonPresionado', "A");
                
                set('formulario.conectorAction', 'LPMantenerAsignacionManualProductos');
                set('formulario.accion', 'validarProductoAnaquel');
                eval('formulario').oculto = 'S';  
                enviaSICC('formulario');
            }
        }
        
        if(validaAnaquel=="N"){
            clickAniadir();
        }
        
    } else{
        clickAniadir();
    }
}

function deshabilitarDetallesValidados(){  
    var codigos = listado1.codigos();
    eval("listado1.preparaCamposDR()");
    
    for(var i=0; i<codigos.length; i++){
        if(listado1.extraeDato(codigos[i], 2)!="") {
          accion('frm'+'listado1'+'.'+'txtCodAnaquel'+'_'+i, '.disabled=true');
          accion('frm'+'listado1'+'.'+'txtCodProducto'+'_'+i, '.disabled=true');
        }
    }
}

function focalizaLineaValidar(idFila) {
    var indiceActual = obtenerIndiceFila(idFila);
    eval("listado1.preparaCamposDR()");
    focaliza('frm'+'listado1'+'.'+'txtCodAnaquel'+'_'+indiceActual,'');
}


function filaDetalleValidadaOk(idFila, codAnaquel, codProducto, oidAnaquel, oidProducto, unidEstimadas ,botonPresionado) {
    var indiceActual = obtenerIndiceFila(idFila);
    if (indiceActual == -1) { // La fila ya no esta en la lista
        return true; // La fila era valida pero fue eliminada de la lista por el usuario
    }
    listado1.insertaDato(idFila, 0, codAnaquel);
    listado1.insertaDato(idFila, 1, codProducto);
    listado1.insertaDato(idFila, 2, oidAnaquel);
    listado1.insertaDato(idFila, 3, oidProducto);
    listado1.insertaDato(idFila, 4, unidEstimadas);
    
    GestionarMensaje('APE040', codProducto, codAnaquel);
   
    focalizaLineaValidar(idFila);
    
    deshabilitarDetallesValidados();
    
    if(botonPresionado=="A"){
        clickAniadir();
    } else if (botonPresionado=="G"){
        clickGuardar();
    }
}

function hayAnaquelRepetido() {
    listado1.actualizaDat();
    var cantFilas = listado1.datos.length;
    var codAnaquel;
    var codAnaquelAux;
    var codProducto;
    var codProductoAux;

    for (var i = 0; i < cantFilas; i++) {
        for (var j = i+1; j < cantFilas; j++) {
            codAnaquel = listado1.datos[i][1];
            codAnaquelAux = listado1.datos[j][1];
            
            if (codAnaquel != '' && codAnaquelAux != '' && codAnaquel == codAnaquelAux) {
                var resp = GestionarMensaje('APE028', codAnaquel);
                return true;
            }
        }
    }
    return false;
}

function clickAniadir() {

    // Agrega la linea
    var filaNueva = new Array();
    
    filaNueva[0] = listado1.generaCodigo(); // id de la fila (Ej. "cod8")
    filaNueva[1] = "";  // codigo de anaquel
    filaNueva[2] = "";  // codigo de producto
    filaNueva[3] = "";  // oidAnaquel
    filaNueva[4] = "";  // oidProducto
    filaNueva[5] = "";  // unidEstimadas
    
    listado1.insertar(filaNueva);
    listado1.repintaDat();
    
    eval("listado1.preparaCamposDR()");
    focaliza('frmlistado1.txtCodAnaquel_' + (listado1.datos.length -1));
}

function onClickGuardar() {
    if (!sicc_validaciones_generales("obligatoriosSinVersion")
            || !sicc_validaciones_generales("version")) {
         return false;
    }
    
    if (hayAnaquelRepetido()) {
        return false;
    }

    var codigos = listado1.codigos();
    var validaAnaquel="N";
    
    for(var i=0; i<codigos.length; i++){
	    codigo = codigos[i];
	    
	    if(listado1.extraeDato(codigo, 2)=="" && listado1.extraeDato(codigo, 3)==""){
          validaAnaquel="S";
          // Valida obligatoriedad 
          if(listado1.extraeDato(codigo, 0)=="") {
               GestionarMensaje('2587');
               eval("listado1.preparaCamposDR()");
               focaliza('frm'+'listado1'+'.'+'txtCodAnaquel'+'_'+i,'');
               return;
          }
          
          if(listado1.extraeDato(codigo, 1)=="") {
               GestionarMensaje('2588');
               eval("listado1.preparaCamposDR()");
               focaliza('frm'+'listado1'+'.'+'txtCodProducto'+'_'+i,'');
               return;
          }
          
          set('formulario.hCodFilaAValidar', codigo);
          set('formulario.hCodAnaquelAValidar', listado1.extraeDato(codigo, 0));
          set('formulario.hCodProductoAValidar', listado1.extraeDato(codigo, 1));
          set('formulario.hBotonPresionado', "G");
          
          set('formulario.conectorAction', 'LPMantenerAsignacionManualProductos');
          set('formulario.accion', 'validarProductoAnaquel');
          eval('formulario').oculto = 'S';  
          enviaSICC('formulario');
      }
    } 
    
    if(validaAnaquel=="N"){
        clickGuardar();
    }    
}

function clickGuardar() {
    var strLista = listaToXml();
    set('formulario.hListado1', strLista);
    
    set('formulario.conectorAction', 'LPMantenerAsignacionManualProductos');
    set('formulario.accion', 'guardar');
    eval('formulario').oculto = 'N';  // Importante para que recargue la pagina en la ventana
    enviaSICC('formulario');
}

function onClickNuevaVersion() {
    if (!sicc_validaciones_generales("obligatoriosSinVersion")) {
         return false;
    }
    var obj = new Object();
    obj.oidMapaCentroDistribucion = get('formulario.cbMapaCentro');
    obj.oidPeriodo = get('formulario.cbPeriodo');
    
    var arrayDevuelto = mostrarModalSICC('LPMantenerAsignacionManualProductos', 'nuevaVersion', obj, 750, 200);
    
    if (arrayDevuelto != null) {
        var oidVersionNueva = arrayDevuelto[0];
        var descVersionNueva = arrayDevuelto[1];
        combo_add('formulario.cbVersion', oidVersionNueva, descVersionNueva);
        set('formulario.cbVersion', [oidVersionNueva]);
        deshabilitarHabilitarBoton('botonContenido','btnNuevaVersion','D');
    }
    focaliza('formulario.cbVersion')
}


// *** Basicas (Gen)
function fLimpiar() {
    var iSeleccionado = new Array();
    iSeleccionado[0] = new Array();
    set('formulario.cbMarca', iSeleccionado);
    set('formulario.cbCanal', iSeleccionado);

    var defaultOidCD = get('formulario.defaultOidComboCD');
    var actualOidCD = get('formulario.cbCentroDistribucion');
    
    if (defaultOidCD != '') {
        if (defaultOidCD == actualOidCD) {
            set('formulario.cbMapaCentro', iSeleccionado);
        } else {
            set('formulario.cbCentroDistribucion', [[defaultOidCD]]);
            onChangeCbCentroDistribucion();
        }
    } else {
        set('formulario.cbCentroDistribucion', iSeleccionado);
        set_combo('formulario.cbMapaCentro', [['','']], [null]);
    }
    
    set_combo('formulario.cbPeriodo', [['','']], [null]);
    set_combo('formulario.cbVersion', [['','']], [null]);
    
    habilitarCamposCabecera();
    
    listado1.limpia(false);
    ocultarLista();
    set('formulario.hListado1', '');
    foco('formulario.cbCentroDistribucion');
}

function fGuardar() {
    onClickGuardar();
}




// *** Utilidades
function onTabBtnDesasignar() {
    var visibListado = document.getElementById("Cplistado1").style.visibility;
    var visibBtnAniadir = document.getElementById("btnAniadirDiv").style.visibility;
    
    if (visibListado == 'hidden') {
        foco('formulario.cbCentroDistribucion');
    } else if (visibBtnAniadir == 'visible' || visibBtnAniadir == '') {
        if(listado1.datos.length > 0) {
            eval("listado1.preparaCamposDR()");
            focaliza('frmlistado1.txtCodAnaquel_0');
        } else {
            focalizaBotonHTML('botonContenido', 'btnAniadir');
        }
    }
}

function onShTabBtnAsignar() {
    var visibListado = document.getElementById("Cplistado1").style.visibility;
    var visibBtnAniadir = document.getElementById("btnAniadirDiv").style.visibility;
    
    if (visibListado == 'hidden') {
        focalizaBotonHTML('botonContenido', 'btnNuevaVersion');
    } else if (visibBtnAniadir == 'visible' || visibBtnAniadir == '') {
        focalizaBotonHTML('botonContenido', 'btnEliminar');
    }
}

function onShTabBtnAniadir() {
    if(listado1.datos.length > 0) {
        var indiceFila = listado1.datos.length - 1;
        eval("listado1.preparaCamposDR()");
        focaliza('frm'+'listado1'+'.'+'txtCodProducto'+'_'+indiceFila,'');   
        
    } else {
        focalizaBotonHTML('botonContenido', 'btnDesasignarProd');
    }
    
}

function onShTabTxtCodAnaquel(numeroFila) {
    if (numeroFila == 0) {
        setTimeout("focalizaBotonHTML('botonContenido', 'btnDesasignarProd')", 100);
    }
}

function onTabTxtCodProducto(numeroFila) {
    if ( numeroFila == (listado1.datos.length - 1) ) {
        setTimeout("focalizaBotonHTML('botonContenido', 'btnAniadir')", 100);
    }
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

function cargarVersiones() {
    set_combo('formulario.cbVersion', [['','']], [null]);
    var centroDistribucion = get('formulario.cbCentroDistribucion');
    var mapaCentro = get('formulario.cbMapaCentro');
    var periodo = get('formulario.cbPeriodo');
    
    if (centroDistribucion != '' && mapaCentro != '' && periodo != '') {
        var arra = new Array();
        arra[0] = ["oidPais", get('formulario.oidPais')];
        arra[1] = ["oidIdioma", get('formulario.oidIdioma')];
        arra[2] = ["oidCentroDistribucion", get('formulario.cbCentroDistribucion')];
        arra[3] = ["oidMapaCentroDistribucion", get('formulario.cbMapaCentro')];
        arra[4] = ["oidPeriodo", get('formulario.cbPeriodo')];
        recargaCombo("formulario.cbVersion", "APEObtenerVersionesAsignacion", "es.indra.sicc.dtos.ape.DTOMantenerAsignacionProductosAnaqueles", arra);
    }
}

function ocultarLista() {
    document.all["Cplistado1"].style.visibility = 'hidden';
    document.all["CpLin1listado1"].style.visibility = 'hidden';
    document.all["CpLin2listado1"].style.visibility = 'hidden';
    document.all["CpLin3listado1"].style.visibility = 'hidden';
    document.all["CpLin4listado1"].style.visibility = 'hidden';
    document.all["btnAniadirDiv"].style.visibility = 'hidden';
    document.all["btnEliminarDiv"].style.visibility = 'hidden';
    btnProxy(1, 0);
}

function visualizarLista() {
    DrdEnsanchaConMargenDcho('listado1', 23);

    document.all["Cplistado1"].style.visibility = 'visible';
    document.all["CpLin1listado1"].style.visibility = 'visible';
    document.all["CpLin2listado1"].style.visibility = 'visible';
    document.all["CpLin3listado1"].style.visibility = 'visible';
    document.all["CpLin4listado1"].style.visibility = 'visible';
    document.all["btnAniadirDiv"].style.visibility = 'visible';
    document.all["btnEliminarDiv"].style.visibility = 'visible';
    btnProxy(1, 1);
    
    eval(ON_RSZ);
}

function deshabilitarCamposCabecera() {
    accion('formulario.cbCentroDistribucion','.disabled=true');
    accion('formulario.cbMapaCentro',        '.disabled=true');
    accion('formulario.cbMarca',             '.disabled=true');
    accion('formulario.cbCanal',             '.disabled=true');
    accion('formulario.cbPeriodo',           '.disabled=true');
    accion('formulario.cbVersion',           '.disabled=true');
    deshabilitarHabilitarBoton('botonContenido','btnNuevaVersion','D');
}

function habilitarCamposCabecera() {
    accion('formulario.cbCentroDistribucion','.disabled=false');
    accion('formulario.cbMapaCentro',        '.disabled=false');
    accion('formulario.cbMarca',             '.disabled=false');
    accion('formulario.cbCanal',             '.disabled=false');
    accion('formulario.cbPeriodo',           '.disabled=false');
    accion('formulario.cbVersion',           '.disabled=false');
    deshabilitarHabilitarBoton('botonContenido','btnNuevaVersion','A');
}

function limpiaOidsFilaDetalle(numeroFila) {
    var datos = listado1.datos;
    datos[numeroFila][3] = ''; // oidAnaquel
    datos[numeroFila][4] = ''; // oidProducto
    listado1.datos = datos;
}

function recargaVersiones() {
    var centroDist = get('formulario.cbCentroDistribucion');
    var mapaCD = get('formulario.cbMapaCentro');
    var marca = get('formulario.cbMarca');
    var canal = get('formulario.cbCanal');
    var periodo = get('formulario.cbPeriodo');

    if (centroDist == '' || mapaCD == '' 
            || marca == '' || canal == '' || periodo == '') {
        set_combo('formulario.cbVersion', [['','']], [null]);
    } else {
        cargarVersiones();
    }
}


function listaToXml() {
    var arrayNombreCampos = new Array(5);
    arrayNombreCampos[0] = "codFila";
    arrayNombreCampos[1] = "codAnaquel";
    arrayNombreCampos[2] = "codProducto";
    arrayNombreCampos[3] = "oidAnaquel";
    arrayNombreCampos[4] = "oidProducto";
    // vbongiov -- BELC400000594 -- 26/07/2007
    arrayNombreCampos[5] = "unidEstimadas";
    
    var xmlDoc = "<?xml version='1.0' encoding='ISO-8859-1' standalone='yes'?>";
    xmlDoc = xmlDoc + "<DOC>";
    var datos = listado1.datos;
    var cantFilas = datos.length;
    /* Recorre las filas */ 
    for (var i = 0; i < cantFilas; i++) {
        var linea = datos[i]; 
        xmlDoc = xmlDoc + "<ROW>";
        /* Recorre los campos dentro de la fila */
        var cantCampos = linea.length;
        for (var j = 0; j < cantCampos; j++ ) {
            /* Quito formato local de numero y caracteres especiales */
            var campo = linea[j];
            xmlDoc = xmlDoc + "<CAMPO nombre='" + arrayNombreCampos[j] + "'>" + DrdEscXML(campo) + "</CAMPO>";
        }
        xmlDoc = xmlDoc + "</ROW>"
    }
    xmlDoc = xmlDoc + "</DOC>";
    
    return xmlDoc; 
}

function restaurarSeleccionCombosPagina() {
    set('formulario.cbCentroDistribucion', [[get('formulario.restauraOidCD')]]);
    set('formulario.cbMapaCentro', [[get('formulario.restauraOidMapaCD')]]);
    set('formulario.cbMarca', [[get('formulario.restauraOidMarca')]]);
    set('formulario.cbCanal', [[get('formulario.restauraOidCanal')]]);
    set('formulario.cbPeriodo', [[get('formulario.restauraOidPeriodo')]]);
    set('formulario.cbVersion', [[get('formulario.restauraOidVersion')]]);

    set('formulario.restauraOidCD', '');
    set('formulario.restauraOidMapaCD', '');
    set('formulario.restauraOidMarca', '');
    set('formulario.restauraOidCanal', '');
    set('formulario.restauraOidPeriodo', '');
    set('formulario.restauraOidVersion', '');
}

function eliminarFilas() {
    if (listado1.numSelecc() > 0) {
        listado1.eliminarSelecc();
    } else {
        GestionarMensaje("4");
    }
}

function obtenerIndiceFila(codFila) {
    var cantFilas = listado1.datos.length;
    
    for (var i = 0; i < cantFilas; i++) {
        if (listado1.datos[i][0] == codFila) {
            return i;
        }
    }
    return -1;
}

function cantidadDetallesIncompletos() {
    var lista = listado1.datos;
    var cantFilas = lista.length;
    var cantFilasIncompletas = 0;
    
    for (var i = 0; i < cantFilas; i++) {
        if (lista[i][1] == '' || lista[i][2] == '') { // Alguno de los códigos no fue ingresado
            cantFilasIncompletas++;
        }
    }
    return cantFilasIncompletas;
}
