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
//var ultimoOrdenamiento; // Guardamos el ultimo orden y sentido Ej. -1 (por anaquel descendiente)

function onLoadPag() {
    configurarMenuSecundario('formulario');
    fMostrarMensajeError();
    DrdEnsanchaConMargenDcho('listado1', 25);
    //var oidCabeceraAsignacion = get('formulario.oidAsignacionProductoAnaquel');
    //var codOrdenamiento = get('formulario.ORDEN_POR_PRODUCTO');
    
    //consultarListaDetalle(oidCabeceraAsignacion, codOrdenamiento);
	// eiraola - 11/Jun/2007 - Por Inc. 490 ya no se permite cambiar de orden (default es cod producto sap ascendente)
	consultarListaDetalle();
    eval(ON_RSZ);
}

function onClickDesasignar() {
    var seleccionados = obtenerOidsFilasSeleccionadas();
    var cantSeleccionados = seleccionados.length;
    
    if (cantSeleccionados > 0) {
        //eliminarFilas(seleccionados, "APEEliminarAsignacionProductosAnaqueles", mipgndo, null, true);
        eval('formulario').oculto = 'S';
        set('formulario.hOidsDetallesAEliminar', seleccionados.toString()); // Son los oid separados por coma
        set('formulario.conectorAction', 'LPMantenerAsignacionManualProductos');
        set('formulario.accion', 'eliminarAsignaciones');
        enviaSICC('formulario', null, null, 'N');
        
    } else {
        GestionarMensaje("4");
        return false;
    }
}

/*function onClickOrdenarAnaquel() {
    ultimoOrdenamiento = ordenarLista(get('formulario.ORDEN_POR_ANAQUEL'), ultimoOrdenamiento);
}*/

/*function onClickOrdenarProducto() {
    ultimoOrdenamiento = ordenarLista(get('formulario.ORDEN_POR_PRODUCTO'), ultimoOrdenamiento);
}*/

function consultarListaDetalle() {
    d3ocupado_ver('d3general', 'C');
    configurarPaginado(mipgndo, 
                       "APEConsultarAsignacionProductosAnaqueles", 
                       "ConectorConsultarAsignacionProductosAnaqueles",
                       "es.indra.sicc.dtos.ape.DTODesasignarProductosAnaqueles",
                       armaArray());
}

function armaArray(){ 
      var arrDatos = new Array();
      var i=0;

      if (get('formulario.oidAsignacionProductoAnaquel')!=''){
           arrDatos[i] = new Array('oid',get('formulario.oidAsignacionProductoAnaquel'));
           i++;
      }

      if (get('formulario.txtCodAnaq')!=''){
           arrDatos[i] = new Array('numAnaq',get('formulario.txtCodAnaq'));
           i++;
      }

      if (get('formulario.txtCodSAP')!=''){
           arrDatos[i] = new Array('codSAP',get('formulario.txtCodSAP'));
           i++;
      }

      if (get('formulario.txtDescripcion')!=''){
           arrDatos[i] = new Array('descripcion',get('formulario.txtDescripcion'));
           i++;
      }

	  return arrDatos;
}
/*function ordenarLista(criterio, criterioAnterior) {
    if (Math.abs(ultimoOrdenamiento) == criterio) {
        criterio = criterio * (-1);
    }
    
    var oidCabeceraAsignacion = get('formulario.oidAsignacionProductoAnaquel');
    
    consultarListaDetalle(oidCabeceraAsignacion, criterio);
    return criterio;
}*/

function muestraLista(ultima, rowset) {
    var tamano = rowset.length;
    d3ocupado_ocultar('d3general');
    
    gestionarVisibilidadLista('visible');
    if (tamano > 0) {
        deshabilitarHabilitarBoton('botonContenido','btnDesasignar','A');
        focalizaBotonHTML('botonContenido', 'btnDesasignar');
        return true;
    } else {
        deshabilitarHabilitarBoton('botonContenido','btnDesasignar','D');
        //deshabilitarHabilitarBoton('botonContenido','btnOrdenarAnaquel','D');
        //deshabilitarHabilitarBoton('botonContenido','btnOrdenarProducto','D');
        return true;
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
    
    document.all["btnDesasignarDiv"].style.visibility=visibilidad;
    //document.all["btnOrdenarAnaquelDiv"].style.visibility=visibilidad;
    //document.all["btnOrdenarProductoDiv"].style.visibility=visibilidad;
}

function obtenerOidsFilasSeleccionadas() {
    var codSeleccionados = listado1.codSeleccionados(); // Tiene los Rownum de las filas
    var cantFilasSeleccionadas = codSeleccionados.length;
    
    var oidsSeleccionados = new Array();
    
    for (var i = 0; i < cantFilasSeleccionadas; i++) {
        codFilaListado = codSeleccionados[i];
        oidSeleccionado = listado1.extraeDato(codFilaListado, 0);
        oidsSeleccionados.push(oidSeleccionado); // Agregamos el oid al Array
    }
    return oidsSeleccionados;
}

function fVolver() {
    window.close();
}

function mensajeEliminacionExitosa() {
    GestionarMensaje('APE025');
    window.close();
}

function botonBuscar() {
	
	var numAnaq = get('formulario.txtCodAnaq');
	var codSAP = get('formulario.txtCodSAP');
	var descripcion = get('formulario.txtDescripcion');

	if (numAnaq!=null&&numAnaq!='') {
		if (codSAP!=null&&codSAP!='') {
			 GestionarMensaje('3384');
			 focaliza('formulario.txtCodAnaq');
			 return;
		}
		if (descripcion!=null&&descripcion!='') {
			 GestionarMensaje('3384');
			 focaliza('formulario.txtCodAnaq');
			 return;
		}
	} else {
		if (codSAP!=null&&codSAP!='') {
			if (descripcion!=null&&descripcion!='') {
				 GestionarMensaje('3384');
				 focaliza('formulario.txtCodAnaq');
				 return;
			}
		}
	}
	
	consultarListaDetalle();
}