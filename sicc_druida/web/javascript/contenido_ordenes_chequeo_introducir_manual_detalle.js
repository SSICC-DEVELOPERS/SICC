function onLoadPag(){  
         
    configurarMenuSecundario('formulario');

	obtenerDetalle();
   
    mostrarLista();
    
    fMostrarMensajeError();
}

function mostrarLista(){

    DrdEnsanchaConMargenDcho('listado1',28);
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

function obtenerDetalle(){

	var arr = new Array();
	
	var idioma = get("formulario.idioma");
	arr[arr.length] = new Array("oidIdioma", idioma);		
	
	arr[arr.length] = new Array("oidPeriodoDesde", get("formulario.hOidPeriodoDesde"));  
	arr[arr.length] = new Array("oidPeriodoHasta", get("formulario.hOidPeriodoHasta")); 
	arr[arr.length] = new Array("codigoCliente", get("formulario.hCodCliente")); 
	arr[arr.length] = new Array("oidTipoRevision", get("formulario.hOidTipoChequeo")); 
	
	configurarPaginado(mipgndo,"RECObtenerChequeoManual","ConectorObtenerChequeoManual",
						 "es.indra.sicc.dtos.rec.DTOChequeoManual",arr);     
}

function fVolver(){
  close();
}