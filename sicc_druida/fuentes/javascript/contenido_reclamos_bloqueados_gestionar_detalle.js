var FORMULARIO = 'frmContenido';

function onLoadPag(){
	
	var errDescripcion = get(FORMULARIO +'.errDescripcion');
	if (errDescripcion !='') {
		var errCodigo = get(FORMULARIO+'.errCodigo');
		var wnd = fMostrarMensajeError(errCodigo, errDescripcion);
	}
	
	DrdEnsanchaConMargenDcho('listado1',12);
	document.all["Cplistado1"].style.visibility='';
	document.all["CpLin1listado1"].style.visibility='';
	document.all["CpLin2listado1"].style.visibility='';
	document.all["CpLin3listado1"].style.visibility='';
	document.all["CpLin4listado1"].style.visibility='';
	
	document.all["primera1Div"].style.visibility='';
	document.all["ret1Div"].style.visibility='';
	document.all["ava1Div"].style.visibility='';
	document.all["separaDiv"].style.visibility='';
	
	eval (ON_RSZ);  
	
	/*Documentation                                                      
	Llamamos a configurarPaginado pasándole los siguientes parametros: 
	- Objeto paginado (lstLineas)                                      
	- idBusiness ("RECObtenerLineasOperacion")                         
	- "ConectorObtenerLineasOperacionREC"                              
	- "DTOOID"                                                         
	- Parametros del DTOE:                                             
	DTOE.oid = oidOperacion recibido   
	*/
	var pais = get(FORMULARIO + '.pais');
	var idioma = get(FORMULARIO + '.idioma');
	var oid = get(FORMULARIO + '.oid');
	
	configurarPaginado(mipgndo,"RECObtenerLineasOperacion",
			"ConectorObtenerLineasOperacionREC","es.indra.sicc.cmn.negocio.comun.DTOComunes.DTOOIDPaginado",
			[["oidPais", pais], 
			["oidIdioma", idioma], 
			["oid",oid]]);
	
	configurarMenuSecundario(FORMULARIO);
	btnProxy(5,0); //se deshabilita limpiar
}    

function fVolver(){
	window.close();	
}                            