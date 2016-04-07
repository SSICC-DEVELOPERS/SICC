var FORMULARIO = 'frmContenido';

function onLoadPag()   
{
    configurarMenuSecundario(FORMULARIO);
	//var opcion = get(FORMULARIO+'.opcionMenu');
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
}

function visibleLista() {
        
    visibilidad('capaLista','V');
    DrdEnsanchaConMargenDcho('listado1',12);
    eval (ON_RSZ);  
}

function noVisibleLista() {
    visibilidad('capaLista','O');
}

function muestraLista( ultima, rowset){
	var tamano = rowset.length;
    if (tamano > 0) {
         visibleLista();
         return true;
    } else {
         noVisibleLista();
         // No se ha encontrado ningún elemento con los criterios especificados
         //Control del foco
         focaliza(FORMULARIO+'.txtProducto');
         return false;
    }
}

function onClickBuscar(){
	/*- Objeto paginado (lstResultados) 
- idBusiness ("RECObtenerProductos") 
- "ConectorObtenerProductosREC" 
- "DTOBuscarProductosREC" 
- Parametros del DTOBuscarProductosREC: 
- codigoProducto = producto 
- descripcionProducto = descripcionProducto */

	var codigoProducto = get(FORMULARIO + '.txtProducto');
	var descripcionProducto = get(FORMULARIO + '.txtDescProducto');
	var pais = get(FORMULARIO + '.pais');
	var idioma = get(FORMULARIO + '.idioma');

	configurarPaginado(mipgndo,"RECObtenerProductos","ConectorBuscarProductosREC",
			"es.indra.sicc.dtos.rec.DTOBuscarProductosREC",
			[["oidPais", pais], ["oidIdioma", idioma], ["codigoProducto", codigoProducto],
			["descripcionProducto", descripcionProducto]]);
}

function onClickAceptar(){
	if (listado1.numSelecc() == 0) {
		// Muestra el mensaje: "Debe seleccionar un elemento de la lista"
      	GestionarMensaje('50');
  	}else {                                                                                        
		if (listado1.numSelecc() != 1 ) {                                    
	        //Muesta el mensaje: "Debe seleccionar un solo registro"
	 		GestionarMensaje('8');
	 
			var seleccion=listado1.codigos();
			var i=0;
			while(seleccion[i]!=null){
				listado1.deselecciona(i); 
				i++; 
			}          
    	}else {
    		var fila = listado1.codSeleccionados();
    		window.returnValue = listado1.extraeDato(listado1.codSeleccionados(),0);
    		window.close();
    	}
    }
}