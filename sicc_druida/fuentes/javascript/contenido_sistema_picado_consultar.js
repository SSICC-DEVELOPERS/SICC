function onLoad() {
    configurarMenuSecundario("formulario");
	
	if (get('formulario.errCodigo') != "") {
		fMostrarMensajeError();
		window.close();
	}

	configurarPaginado(	mipgndo, 
						"APEConsultarSistemaPicado", 
						"ConectorConsultarSistemaPicado",
						"es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion",
						[["oidPais", get("formulario.hPais")],
						 ["oidIdioma", get("formulario.hIdioma")]]);
}

function muestraLista(ultima, rowset) {
	var tamano = rowset.length;

	if (tamano > 0) {
		visualizarLista("");
        return true;
    } else {
		visualizarLista("hidden");
        return false;
    }
}

function visualizarLista(visibilidad) {
	DrdEnsanchaConMargenDcho("listado1", 12);

    document.all["Cplistado1"].style.visibility = visibilidad;
    document.all["CpLin1listado1"].style.visibility = visibilidad;
    document.all["CpLin2listado1"].style.visibility = visibilidad;
    document.all["CpLin3listado1"].style.visibility = visibilidad;
    document.all["CpLin4listado1"].style.visibility = visibilidad;

    document.all["ret1Div"].style.visibility = 'hidden';
    document.all["ava1Div"].style.visibility = 'hidden';
}
 