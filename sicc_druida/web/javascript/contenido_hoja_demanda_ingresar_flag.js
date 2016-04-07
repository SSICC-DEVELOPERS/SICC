var FORMULARIO = 'formulario';

function onLoadPag()   {
	
	var errDescripcion = get(FORMULARIO +'.errDescripcion');
    if(errDescripcion != ''){
    	var errCodigo = get(FORMULARIO +'.errCodigo');
    	var wnd = fMostrarMensajeError(errCodigo,errDescripcion);
    }
    
    configurarMenuSecundario(FORMULARIO);
  
    DrdEnsanchaConMargenDcho('listado1',12);
   
    DrdEnsanchaConMargenDcho('listado2',12);
 
    paginadoFlagActuacion2();
    paginadoFlagActuacion4()
    
    eval (ON_RSZ);  

}

function paginadoFlagActuacion2() {
	
	var pais = get(FORMULARIO+'.pais');
	var idioma = get(FORMULARIO+'.idioma');
	var oidRegistroAbastecimientoCabecera = get(FORMULARIO+'.oidRegistroAbastecimientoCabecera');
	//alert(oidRegistroAbastecimientoCabecera);
	var oidTipoActuacion = 2;
	
	var dto = [ ["oidPais",pais], ["oidIdioma",idioma], ["oidRegistroAbastecimientoCabecera",oidRegistroAbastecimientoCabecera], ["oidTipoActuacion",oidTipoActuacion] ];
	configurarPaginado(mipgndo, "BELBuscarHDDetalleFlag", "ConectorBuscarHDDetalleFlag", "es.indra.sicc.dtos.bel.DTOEBuscarHDDetalleFlag",dto);
}

function paginadoFlagActuacion4() {
	var pais = get(FORMULARIO+'.pais');
	var idioma = get(FORMULARIO+'.idioma');
	var oidRegistroAbastecimientoCabecera = get(FORMULARIO+'.oidRegistroAbastecimientoCabecera');
	var oidTipoActuacion = 4;
	
	var dto = [ ["oidPais",pais], ["oidIdioma",idioma], ["oidRegistroAbastecimientoCabecera",oidRegistroAbastecimientoCabecera], ["oidTipoActuacion",oidTipoActuacion] ];
	configurarPaginado(mipgndo2, "BELBuscarHDDetalleFlag", "ConectorBuscarHDDetalleFlag", "es.indra.sicc.dtos.bel.DTOEBuscarHDDetalleFlag",dto);
}