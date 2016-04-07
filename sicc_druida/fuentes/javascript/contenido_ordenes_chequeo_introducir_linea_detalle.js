var FORMULARIO = 'formulario';

function onLoadPag(){  
          
    configurarMenuSecundario('formulario');

    obtenerDetalle();
   
    mostrarLista();
    
    fMostrarMensajeError();

	focalizaBotonHTML('botonContenido','Aniadir');
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

		 arr[arr.length] = new Array("oidTipoRevision", get("formulario.hOidTipoChequeo"));          
         arr[arr.length] = new Array("oidSubgerenciaVentas", get("formulario.hOidSubgerencia"));  
         arr[arr.length] = new Array("oidRegion", get("formulario.hOidRegion")); 
         arr[arr.length] = new Array("oidZona", get("formulario.hOidZona")); 
         arr[arr.length] = new Array("oidSeccion", get("formulario.hOidSeccion")); 
         
         configurarPaginado(mipgndo,"RECObtenerChequeoLineaCampo","ConectorObtenerChequeoLinea",
                                                        "es.indra.sicc.dtos.rec.DTOChequeoZona",arr);     
}


function onClickAniadir() {

	  var obj = new Object();
 
	  obj.accion = 'aniadirLineaCampo';
	  obj.oidTipoChequeo = get(FORMULARIO + '.hOidTipoChequeo');
	  obj.oidMarca = get(FORMULARIO + '.hOidMarca');
	  obj.oidCanal = get(FORMULARIO + '.hOidCanal');
	  obj.oidSubgerencia = get(FORMULARIO + '.hOidSubgerencia');
	  obj.oidRegion = get(FORMULARIO + '.hOidRegion');
	  obj.oidZona = get(FORMULARIO + '.hOidZona');
	  obj.oidSeccion = get(FORMULARIO + '.hOidSeccion');
	  
	  var retorno = mostrarModalSICC('LPIntroducirOrdenesChequeos', 'aniadirLineaCampo', obj, '500', '200');

	  if(retorno!=null){
          close();
      }
}

function fVolver(){
  close();
}

function focalizaBoton(){
  focalizaBotonHTML('botonContenido','Aniadir');
}
