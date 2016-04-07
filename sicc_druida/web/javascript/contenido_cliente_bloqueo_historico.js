function onLoadPag() {

	configurarMenuSecundario('formulario');
	txt_to('lblTxtCodCliente', get('formulario.hCodCliente'));
	txt_to('lblTxtNombre1', get('formulario.hNombre1'));
	txt_to('lblTxtNombre2', get('formulario.hNombre2'));
	txt_to('lblTxtApellido1', get('formulario.hApellido1'));
	txt_to('lblTxtApellido2', get('formulario.hApellido2'));

	accion('formulario.chkBloqueado', '.disabled = true');

	DrdEnsanchaConMargenDcho('listado1', 12);
	eval(ON_RSZ);
	
	var parametros = new Array();
	parametros[0] = new Array('oidPais', get('formulario.varPais'));
	parametros[1] = new Array('oidIdioma', get('formulario.varIdioma'));
	parametros[2] = new Array('oid', get('formulario.hOidCliente'));

	configurarPaginado(mipgndo,'MAEConsultarHistoricoBloqueosCliente',
	                   'ConectorConsultarHistoricoBloqueosCliente',
	                   'es.indra.sicc.util.DTOOID',
	                   parametros);
	
}

function muestraLista(ultima,rowset) {
	var tamano = rowset.length;
	if (tamano > 0) {
		return true; 
	} else {
		fVolver();
		return false;  
	}
}

function fVolver() {
	window.close();
}
