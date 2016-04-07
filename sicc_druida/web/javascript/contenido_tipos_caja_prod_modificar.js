/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
    ocultarLista();
    fMostrarMensajeError();
    focaliza("formulario.txtCodigoCaja");
}


function onClickBuscar() {
    configurarPaginado(mipgndo, "APEBuscarTipoCajaProducto", "ConectorBuscarTipoCajaProducto",
                       "es.indra.sicc.dtos.ape.DTOTipoCajaProducto", armarArrayValoresDto());
}


function onClickModificar() {
    var codigos = new Array();
    codigos = listado1.codSeleccionados();
    var cant = codigos.length;
    
    if (cant == 1) {
        var oidTipoCajaProducto = codigos[0];  // El oid del registro que modificaremos
        var obj = new Object();
        obj.oidTipoCajaProdu = oidTipoCajaProducto;
        obj.codigoTipoCajaProdu = listado1.extraeDato(oidTipoCajaProducto, 0);      // Codigo
        obj.descripcionTipoCajaProdu = listado1.extraeDato(oidTipoCajaProducto, 1); // Descripcion
        obj.opcionMenu = get('formulario.opcionMenu');
        var arrayDevuelto = mostrarModalSICC('LPMantenimientoTipoCajaProducto', 'detalle', obj, 750, 350);
        
        if (arrayDevuelto != null && arrayDevuelto.length == 2) {
            listado1.insertaDato(oidTipoCajaProducto, 0, arrayDevuelto[0]); // Codigo
            listado1.insertaDato(oidTipoCajaProducto, 1, arrayDevuelto[1]); // Descripcion
        }
        focaliza('formulario.txtCodigoCaja');
    } else if (cant < 1) {
         GestionarMensaje('50');
    } else if (cant > 1) {
         cdos_mostrarAlert(GestionarMensaje('240'));
    }
}


function onClickDetalle() {
    var codigos = new Array();
    codigos = listado1.codSeleccionados();
    var cant = codigos.length;

    if (cant == 1) {
         var obj = new Object();
         obj.oidTipoCajaProdu = codigos[0];
         obj.codigoTipoCajaProdu = listado1.extraeDato(codigos[0], 0);      // Codigo
         obj.descripcionTipoCajaProdu = listado1.extraeDato(codigos[0], 1); // Descripcion
         obj.opcionMenu = get('formulario.opcionMenu');
         mostrarModalSICC('LPMantenimientoTipoCajaProducto', 'detalle', obj, 750, 350);
         focaliza('formulario.txtCodigoCaja');
    } else if (cant < 1) {
         GestionarMensaje('50');
    } else if (cant > 1) {
         cdos_mostrarAlert(GestionarMensaje('240'));
    }
}


function fBorrar() { // Equivale a onClickEliminar
    var seleccionados = listado1.codSeleccionados();
    var cantSeleccionados = seleccionados.length;
     
    if (cantSeleccionados > 0) {
         eliminarFilas(seleccionados, "APEEliminarTipoCajaProducto", mipgndo);
         return true;
    } else {
         GestionarMensaje("4");
         return false;
    }
}


function fLimpiar() {
    set("formulario.txtCodigoCaja", "");
    set("formulario.txtDescripcion", "");
    ocultarLista();
    focaliza("formulario.txtCodigoCaja");
}


function onShtabCodigoCaja() {
    var visibListado = document.getElementById("Cplistado1").style.visibility;
    var visibBtnModificar = document.getElementById("btnModificarDiv").style.visibility;
    var visibBtnDetalle = document.getElementById("btnDetalleDiv").style.visibility;
    
    if (visibListado == 'hidden') {
        focalizaBotonHTML('botonContenido', 'btnBuscar');
    } else {
        var opcionMenu = get('formulario.opcionMenu');
        
        if ( (opcionMenu == 'consultar' || opcionMenu == 'eliminar') 
                && (visibBtnDetalle == 'visible' || visibBtnDetalle == '') ) {
            focalizaBotonHTML('botonContenido', 'btnDetalle');
        }
        
        if (opcionMenu == 'modificar' && (visibBtnModificar == 'visible' || visibBtnModificar == '') ) {
            focalizaBotonHTML('botonContenido', 'btnModificar');
        }
    }
}


function onTabBuscar() {
    var visibListado = document.getElementById("Cplistado1").style.visibility;
    var visibBtnModificar = document.getElementById("btnModificarDiv").style.visibility;
    var visibBtnDetalle = document.getElementById("btnDetalleDiv").style.visibility;
    
    if (visibListado == 'hidden') {
        focaliza("formulario.txtCodigoCaja");
    } else {
        var opcionMenu = get('formulario.opcionMenu');
        
        if ( (opcionMenu == 'consultar' || opcionMenu == 'eliminar') 
                && (visibBtnDetalle == 'visible' || visibBtnDetalle == '') ) {
            focalizaBotonHTML('botonContenido', 'btnDetalle');
        }
        
        if (opcionMenu == 'modificar' && (visibBtnModificar == 'visible' || visibBtnModificar == '') ) {
            focalizaBotonHTML('botonContenido', 'btnModificar');
        }
    }
}


function muestraLista(ultima, rowset) {
    var tamano = rowset.length;
    
    if (tamano > 0) {
         visualizarLista();
         return true;
    } else {
         ocultarLista();
         focaliza('formulario.txtCodigoCaja');
         return false;
    }
}


function visualizarLista() {
    DrdEnsanchaConMargenDcho('listado1', 25);

    document.all["Cplistado1"].style.visibility='';
    document.all["CpLin1listado1"].style.visibility='';
    document.all["CpLin2listado1"].style.visibility='';
    document.all["CpLin3listado1"].style.visibility='';
    document.all["CpLin4listado1"].style.visibility='';
    
    document.all["primera1Div"].style.visibility='';
    document.all["ret1Div"].style.visibility='';
    document.all["ava1Div"].style.visibility='';
    document.all["separaDiv"].style.visibility='';
    
    var opcionMenu = get('formulario.opcionMenu');
 
    if (opcionMenu =='modificar') {
        document.all["btnModificarDiv"].style.visibility='visible';
        document.all["btnDetalleDiv"].style.visibility='hidden';
    } else if (opcionMenu == 'consultar') {
        document.all["btnModificarDiv"].style.visibility='hidden';
        document.all["btnDetalleDiv"].style.visibility='visible';
    } else if (opcionMenu == 'eliminar') {
        document.all["btnModificarDiv"].style.visibility='hidden';
        document.all["btnDetalleDiv"].style.visibility='visible';
        btnProxy(4, 1);
    }
    
    eval(ON_RSZ);
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

    document.all["btnDetalleDiv"].style.visibility='hidden';
    document.all["btnModificarDiv"].style.visibility='hidden';
    
    if (get('formulario.opcionMenu') == 'eliminar') {
        btnProxy(4, 0);
    }
}


function armarArrayValoresDto() {
    var arrDatos = new Array();
    var i=0;
    
    arrDatos[i] = new Array('oidPais', get('formulario.oidPais'));
    i++;
    arrDatos[i] = new Array('oidIdioma', get('formulario.oidIdioma'));
    i++;
    
    if (get('formulario.txtCodigoCaja') != '') {
         arrDatos[i] = new Array('codigoCaja', get('formulario.txtCodigoCaja'));
         i++;
    }
    
    if (get('formulario.txtDescripcion') != '') {
         arrDatos[i] = new Array('descripcion', get('formulario.txtDescripcion'));
         i++;
    }
    
    return arrDatos;
}
