/**
* Copyright 2003 � por Indra Sistemas,S.A.. Todos los derechos reservados.
* Avda. de Bruselas, 35
* Parque Empresarial Arroyo de la Vega
* 28108 Alcobendas, Madrid
* Espa�a
*
* Privado y Confidencial.
* La informaci�n contenida en este documento es propiedad de Indra sistemas.
* Para uso exclusivo de empleados autorizados no permiti�ndose
* la distribuci�n de este c�digo sin permiso expreso.
*/ 


/*
    INDRA/CAR/PROY
    $Id: contenido_movimiento_bancario_mantenimiento.js,v 1.1 2009/12/03 19:02:28 pecbazalar Exp $
    DESC
*/
var FORMULARIO = 'frmFormulario';

function onLoadPag() { 
	configurarMenuSecundario(FORMULARIO);

	
	if (get(FORMULARIO+'.errDescripcion') != '') {
		var wnd = fMostrarMensajeError(get(FORMULARIO+'.errCodigo'), get(FORMULARIO+'.errDescripcion'));
		window.close();
	}
	mostrarLista();
		
		var numeroLote = get(FORMULARIO+'.oid');
		
		if (numeroLote == "") numeroLote = get(FORMULARIO+'.numeroLote');
		
		
		var idioma = get(FORMULARIO+'.idioma');
		var pais = get(FORMULARIO+'.pais');

	if (get(FORMULARIO+'.cu') == "confirmar" || get(FORMULARIO+'.casoDeUso') == "confirmar") {

		
		//Invocamos el "subsystema:paginacion" con IdBusiness="CCCDetalleConfirmarMovBanc"  DTONumeroLote 
		configurarPaginado(mipgndo, "CCCDetalleConfirmarMovBanc", "ConectorDetalleConfirmarMovBanc", "es.indra.sicc.dtos.ccc.DTONumeroLote",
			[['oidPais', pais], 
			['oidIdioma', idioma], 
			['numeroLote', numeroLote]]);
		

	}  else if (get(FORMULARIO + '.cu') == "consultar" || get(FORMULARIO + '.cu') == "depurar" || get(FORMULARIO + '.casoDeUso') == "consultar" || get(FORMULARIO + '.casoDeUso') == "depurar") {
			
		//Invocamos al <<subsystem:paginaci�n>> con un "DTOMovBanc" que contendr� el oidMovimientoBancario recibido como par�metro. IdBusiness="CCCDetalleMovBanc". 
		configurarPaginado(mipgndo, "CCCDetalleMovBanc", "ConectorDetalleMovBanc", "es.indra.sicc.dtos.ccc.DTOMovBanc",
			[['oidPais', pais], 
			['oidIdioma', idioma], 
			['oid', numeroLote]]);
	} 

	else if (get(FORMULARIO + '.cu') == "detalle") {
		mostrarLista();
	}

		
}


	function muestraLista( ultima, rowset) {
 /*   	DrdEnsanchaConMargenDcho('listado1', 12);
		eval (ON_RSZ); */

		var tamano = rowset.length;
		if (tamano > 0) {
			mostrarLista();
			return true;
		} 
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
		document.all["separa1Div"].style.visibility='visible';
		eval (ON_RSZ);  
	}


	function fVolver() {
     	window.close();
	}


