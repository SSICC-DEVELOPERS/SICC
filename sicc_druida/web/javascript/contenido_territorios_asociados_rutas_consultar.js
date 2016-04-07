var FORMULARIO = 'frmFormulario';

function onLoadPag(){

	var errDescripcion = get(FORMULARIO +'.errDescripcion');
        if (errDescripcion !='') {		
                var errCodigo = get(FORMULARIO+'.errCodigo');
        	var wnd = fMostrarMensajeError(errCodigo, errDescripcion);
        }

	DrdEnsanchaConMargenDcho('listado1',12);
	
	document.all["prim1Div"].style.visibility='';
	document.all["ret1Div"].style.visibility='';
	document.all["ava1Div"].style.visibility='';
	document.all["separa1Div"].style.visibility='';
	configurarMenuSecundario(FORMULARIO);	
	focaliza(FORMULARIO+'.cbRuta');
	eval (ON_RSZ);  

}

function allTrim(sStr){ 
          return rTrim(lTrim(sStr)); 
}

function lTrim(sStr){ 
          while (sStr.charAt(0) == " "){
                    sStr = sStr.substr(1, sStr.length - 1); 
          }
          return sStr; 
} 

function rTrim(sStr){ 
          while (sStr.charAt(sStr.length - 1) == " ") {
                    sStr = sStr.substr(0, sStr.length - 1); 
          }
          return sStr; 
}

function validarNumericoTerritorios(territorio){                                  
         var num = get(FORMULARIO+'.'+territorio);
         if(num != ""){
         var val = allTrim(num); 
         //Como no nos interesa validar el número de dígitos que tiene el 
         //entero ponemos uno suficientemente grande. 
                  if ((ValidaInt(val.toString(),10000, 0)!="OK")||(val.toString() < 0)) {
                           cdos_mostrarAlert(GestionarMensaje('1417'));
			   focaliza(FORMULARIO+'.'+territorio);
                           return false;
                  }else {
                  	   return true;
                  }
         }                                   
}

function accionBuscar() {
	if(sicc_validaciones_generales()){ 
		var pais = get(FORMULARIO+'.pais');
		var idioma = get(FORMULARIO+'.idioma');
		var cbRuta = get(FORMULARIO+'.cbRuta');
		var territorioDesde  = get(FORMULARIO+'.txtTerritorioDesde');
		var territorioHasta = get(FORMULARIO+'.txtTerritorioHasta');
		if(territorioDesde!=""){
			if(!validarNumericoTerritorios('txtTerritorioDesde')){
				return false;	
			}
		}
		if(territorioHasta!=""){
			if(!validarNumericoTerritorios('txtTerritorioHasta')){
				return false;	
			}
		}
		configurarPaginado(mipgndo, "APPConsultarTerritoriosAsociados", "ConectorConsultarTerritoriosAsociados", "es.indra.sicc.dtos.app.DTOTerritorio", [["oidPais", pais], ["oidIdioma", idioma], ["oidRuta",cbRuta], ["territorioDesde", territorioDesde], ["territorioHasta", territorioHasta]]); 
		document.all["btnBuscar"].focus();
	}
}

function visibleLista() {
	visibilidad('capaLista','V');
	DrdEnsanchaConMargenDcho('listado1',12);
	eval (ON_RSZ);
}

function ocultaLista() {
	visibilidad('capaLista','O');
}

function muestraLista(ultima, rowset) {
	var tamano = rowset.length;
	if (tamano > 0) {
        	visibleLista();
        	return true;
   	} else {
        	ocultaLista();
        	focaliza(FORMULARIO+'.cbRuta','');
        	return false;
   	}
}

function onTabBtnBuscar() {
	focaliza(FORMULARIO+'.cbRuta');
}

function onShTabCbRuta() {
	document.all["btnBuscar"].focus();
}