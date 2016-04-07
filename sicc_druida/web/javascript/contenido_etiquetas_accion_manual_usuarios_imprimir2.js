function onLoadPag() {
	configurarMenuSecundario('formulario');
	DrdEnsanchaConMargenDcho('listado1', 12);

	document.all["Cplistado1"].style.visibility='hidden';
	document.all["CpLin1listado1"].style.visibility='hidden';
	document.all["CpLin2listado1"].style.visibility='hidden';
	document.all["CpLin3listado1"].style.visibility='hidden';
	document.all["CpLin4listado1"].style.visibility='hidden';
	document.all["ret1Div"].style.visibility='hidden';
	document.all["ava1Div"].style.visibility='hidden';
	document.all["primera1Div"].style.visibility='hidden';
	document.all["separaDiv"].style.visibility='hidden';
	document.all["btnAnularDiv"].style.visibility='hidden';

	eval(ON_RSZ);
	focaliza('formulario.txtConsolidado');
}

//--------------------------------------------------------------------

function onClickBtnAceptar() {
	var consolidado = get('formulario.txtConsolidado');
	if (consolidado != '') {
		if (fValidarNumero(consolidado, 100, 0, 9999999999) != 'OK') {
			GestionarMensaje('747');
			return false;
		}
	}


	var parametros = new Array();
	parametros[0] = new Array('oidPais', get('formulario.varPais'));
	if (consolidado != '') {
		parametros[1] = new Array('nroSolicCabec', consolidado);
	}

	configurarPaginado(mipgndo,
	                   'APEBuscarEtiquetas',
	                   'ConectorBuscarEtiquetas',
                       'es.indra.sicc.dtos.ape.DTOBusquedaEtiqueta',
                       parametros);
}

//--------------------------------------------------------------------

function muestraLista(ultima, rowset) {
	var tamano = rowset.length;
	if (tamano > 0) {
		mostrarLista();
		return true; 
	}else{
		ocultarLista();
		focaliza('formulario.txtConsolidado');
		return false;  
	}
}   

//-------------------------------------------------------------------------------------

function mostrarLista(){

         DrdEnsanchaConMargenDcho('listado1',12);
         document.all["Cplistado1"].style.visibility='visible';
         document.all["CpLin1listado1"].style.visibility='visible';
         document.all["CpLin2listado1"].style.visibility='visible';
         document.all["CpLin3listado1"].style.visibility='visible';
         document.all["CpLin4listado1"].style.visibility='visible';
         document.all["btnAnularDiv"].style.visibility='visible';

         eval (ON_RSZ);
}

//-------------------------------------------------------------------------------------

function ocultarLista() {
    document.all["Cplistado1"].style.visibility='hidden';
    document.all["CpLin1listado1"].style.visibility='hidden';
    document.all["CpLin2listado1" ].style.visibility='hidden';
    document.all["CpLin3listado1"].style.visibility='hidden';
    document.all["CpLin4listado1"].style.visibility='hidden';
    document.all["btnAnularDiv"].style.visibility='hidden';
}

//--------------------------------------------------------------------

function onClickBtnAnular() {
	// Armo un String con los OIDs de etiquetas separados por pipes
	var seleccionados = listado1.codSeleccionados();
	if (seleccionados.length > 0) {
		var oids = '';
		for (var i = 0; i < seleccionados.length; ) {
			oids += seleccionados[i];
			if (++i < seleccionados.length) {
				oids  += ',';
			}
		}
		set('formulario.hOidsAnular', oids);

		eval('formulario').oculto = 'S';
		set('formulario.conectorAction', 'LPAnulacionEtiquetas');
		set('formulario.accion', 'anular');
		enviaSICC('formulario');
	} else {
		GestionarMensaje("4");
	}

}

//--------------------------------------------------------------------

function fLimpiar() {
	set('formulario.txtConsolidado', '');
	if (document.all["Cplistado1"].style.visibility != 'hidden') {
		ocultarLista();
	}
	focaliza('formulario.txtConsolidado');
}

//--------------------------------------------------------------------

function onTab(campo) {
	if (campo == 'txtConsolidado'){
		focalizaBotonHTML('botonContenido','btnAceptar');
	} else if (campo == 'btnAceptar') {
		if (document.all["Cplistado1"].style.visibility == 'hidden') {
			focaliza('formulario.txtConsolidado');
		} else {
			focalizaBotonHTML('botonContenido','btnAnular');
		}
	} else if (campo == 'btnAnular') {
		focaliza('formulario.txtConsolidado');
	}
}

//--------------------------------------------------------------------

function onShiftTab(campo) {
	if (campo == 'txtConsolidado') {
		if (document.all["Cplistado1"].style.visibility == 'hidden') {
			focalizaBotonHTML('botonContenido','btnAceptar');
		} else {
			focalizaBotonHTML('botonContenido','btnAnular');
		}
	} else if (campo == 'btnAceptar') {
		focaliza('formulario.txtConsolidado');
	} else if (campo == 'btnAnular') {
		focalizaBotonHTML('botonContenido','btnAceptar');
	}
}

//--------------------------------------------------------------------

function anulacionFinalizadaOK() {
	GestionarMensaje("APE026");
	onClickBtnAceptar();
}