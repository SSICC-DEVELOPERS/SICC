var FORMULARIO = "frmFormulario";
function onLoadPag()   {
  
    DrdEnsanchaConMargenDcho('listado1',12);
    
    eval (ON_RSZ);  
    
    var errDescripcion = get(FORMULARIO +'.errDescripcion');
    
    configurarMenuSecundario(FORMULARIO);
    
    if (errDescripcion !='') {
         var errCodigo = get(FORMULARIO+'.errCodigo');
         var wnd = fMostrarMensajeError(errCodigo, errDescripcion);
    } else{
    	paginado();
	}
    
}

function paginado(){
	var oid = get(FORMULARIO + '.oidSolicitud');
	var pais = get(FORMULARIO + '.pais');
	var idioma = get(FORMULARIO + '.idioma');

	configurarPaginado(mipgndo, "RECObtenerPosicionesSolicitudChequeo", 
						"ConectorObtenerPosicionesSolicitudChequeo", 
						"es.indra.sicc.cmn.negocio.comun.DTOComunes.DTOOIDPaginado", 
						[ ["oid", oid], ["oidPais", pais], ["oidIdioma", idioma] ] );
}

function fVolver(){
	window.close();
}

function muestraLista( ultima, rowset){	
  var tamano = rowset.length;
	if (tamano > 0)
	{ 
    eval (ON_RSZ);  
	  return true;
	}
  else 
	{  
	  return false;
	}
}
