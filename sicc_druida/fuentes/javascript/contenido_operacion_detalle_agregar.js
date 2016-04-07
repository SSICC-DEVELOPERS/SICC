var FORMULARIO = "frmContenido"      

function onLoadPag() {

	if (get(FORMULARIO + '.errDescripcion')!='') {
		var wnd = fMostrarMensajeError(get(FORMULARIO + '.errCodigo'), get(FORMULARIO + '.errDescripcion'));
		window.close();
	}
	configurarMenuSecundario(FORMULARIO);

	/*Llamamos a configurarPaginado pasándole los siguientes parametros: 
	- idBusiness ("RECObtenerDocumentosReferencia") 
	- "ConectorObtenerDocumentosReferenciaREC" 
	- "DTODocumentoReferenciaREC" 
	- Parametros del DTOBuscarDocumentosReferenciaREC: 
	DTOE.oidSolicitud = lbOidNumDocumento recibido de pantalla llamante 
	DTOE.fechaFiltro = fechaFiltro 
	DTOE.oidCliente = oidCliente recibido de pantalla llamante */
	var pais = get(FORMULARIO + '.pais').toString();
	var idioma = get(FORMULARIO + '.idioma').toString();
	var fechaFiltro = get(FORMULARIO + '.fechaFiltro').toString();
	
	var oidCliente = get(FORMULARIO + '.oidCliente').toString();
	var oidSolicitud = get(FORMULARIO + '.oidNumDocumento').toString();

	configurarPaginado(mipgndo, "RECObtenerDocumentosReferencia", "ConectorObtenerDocumentosReferenciaREC", "es.indra.sicc.dtos.rec.DTODocumentoReferenciaREC", [["oidIdioma", idioma], ["oidPais", pais], ["fechaFiltro", fechaFiltro], ["oidCliente", oidCliente], ["oidSolicitud", oidSolicitud]] );     
}

function muestraLista( ultima, rowset){
		mostrarLista();
		//listado1.actualizaDat();
		//- Se muestra seleccionado el registro de lstResultado correspondiente al Documento de Referencia de Cabecera 
		setTimeout("seleccionarDocumentoRef()", 50);
		return true;
}

function seleccionarDocumentoRef() {
	var numSolicitud = get(FORMULARIO + '.oidNumDocumento');
	var cods = listado1.codigos();
	for (i = 0; i < cods.length; i++) {
		if (cods[i] == numSolicitud) {
			listado1.seleccionaCod(numSolicitud);
			break;
		}
	}
	document.all['Aceptar'].focus();
}

function mostrarLista() {
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
	document.all["AceptarDiv"].style.visibility='visible';
	eval (ON_RSZ);
}


function onClickAceptar() {
	/*, - Se valida que se ha seleccionado un registro de la lista 
		- Se asigna a la variable oculta PgAgregarOperacion.oidNumDocumento el oid del registro seleccionado en la lista*/
	if (listado1.numSelecc() > 0 ) {
		var codigo = listado1.codSeleccionados();
		window.returnValue = codigo[0] + '|' + listado1.extraeDato(codigo[0], 1);
		window.close();
	} else GestionarMensaje('50');

}

function fVolver(){
	 window.close();
}