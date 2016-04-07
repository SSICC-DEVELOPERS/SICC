var FORMULARIO = "formulario";

function onLoadPag()   {
	
	var errDescripcion = get(FORMULARIO +'.errDescripcion');
    if(errDescripcion != ''){
    	var errCodigo = get(FORMULARIO +'.errCodigo');
    	var wnd = fMostrarMensajeError(errCodigo,errDescripcion);
    }
	// configurar el menu secundario	
    configurarMenuSecundario(FORMULARIO);
    
    DrdEnsanchaConMargenDcho("datosHojaDemanda", 12);
    eval (ON_RSZ);
    
    document.all['btnIngresar'].focus();
   }
   
function accionIngresar(){
	if (datosHojaDemanda.numSelecc() == 0) {
    	// Muestra el mensaje: "Debe seleccionar un elemento de la lista"
    	GestionarMensaje('50');
    }else {                                                                             
		if (datosHojaDemanda.numSelecc() != 1 ) {                                
	   	         //Muesta el mensaje: "Debe seleccionar un solo registro"
    	         GestionarMensaje('8');                                 
    	} else { 
    		
    		/*var seleccionado = datosHojaDemanda.codSeleccionados();
    		var oidCabecera = datosHojaDemanda.extraeDato(seleccionado,1);
    		alert(oidCabecera);
    		
    		set(FORMULARIO +'.oidRegistroAbastecimientoCabecera',oidCabecera);*/
    		
    		set(FORMULARIO + '.accion','ingresar');
    		set(FORMULARIO + '.conectorAction',"LPIngresoFisicoHojaDemanda");
    		enviaSICC(FORMULARIO,null,null,'N');
    	} 
    }
}

function focalizaBoton(){
	document.all['btnIngresar'].focus();	
}   
                                               