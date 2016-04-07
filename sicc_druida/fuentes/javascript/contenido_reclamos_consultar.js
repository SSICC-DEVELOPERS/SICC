var FORMULARIO = 'frmContenido';

function onLoadPag(){
		
	var errDescripcion = get(FORMULARIO +'.errDescripcion');
	if (errDescripcion !='') {
    	var errCodigo = get(FORMULARIO+'.errCodigo');
        var wnd = fMostrarMensajeError(errCodigo, errDescripcion);
    }
	configurarMenuSecundario(FORMULARIO);
	   
	//Llamamos a configurarPaginado pasándole los siguientes parametros: 
	//Objeto paginado (lstResultados) 
	//idBusiness ("RECObtenerDetalleReclamos") 
	//"ConectorObtenerDetalleReclamosREC" 
	//"DTODetalleReclamosREC" 
	//Parametro del DTODetalleReclamosREC: 
	//oid recibido 
	
	var pais = get(FORMULARIO + '.pais');
    var idioma = get(FORMULARIO + '.idioma');
    var oidReclamo = get(FORMULARIO + '.oidReclamo');
            
    configurarPaginado(mipgndo, 
    	"RECObtenerDetalleReclamos",
        "ConectorObtenerDetalleReclamosREC", 
        "es.indra.sicc.dtos.rec.DTODetalleReclamosREC",
        	[["oidPais", pais], 
            ["oidIdioma", idioma] , 
            ["oidReclamo", oidReclamo]]);
					
}

function muestraLista( ultima, rowset){                                                 
                                                                                        
	mostrarLista(); 
	return true;
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
    setTimeout('eval (ON_RSZ)',200);
}

function fVolver(){
         window.close();
}