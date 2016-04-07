var FORMULARIO = "formulario";

function onLoadPag()   {
  
    var errDescripcion = get(FORMULARIO +'.errDescripcion');
    if(errDescripcion != ''){
    	var errCodigo = get(FORMULARIO +'.errCodigo');
    	var wnd = fMostrarMensajeError(errCodigo,errDescripcion);
    }
    
    configurarMenuSecundario(FORMULARIO);
    
    accionPaginado();  
    
    DrdEnsanchaConMargenDcho('datosDeDetalle',12);
    eval (ON_RSZ);
    
    document.all['btnAnadir'].focus();

   }
   
function accionAnadir(){
	var objParams = new Object();
	var oidCabecera = get(FORMULARIO +'.oidRegistroAbastecimientoCabecera');
	objParams.oidRegistroAbastecimientoCabecera = oidCabecera;
  var datosFinal = datosDeDetalle.datos;
  var codigoProductos;
  for (i = 0; i < datosFinal.length; i++) {
   	var fila = datosFinal[i];
      	var codProd =  fila[1];
        codigoProductos = codigoProductos + "#" + codProd;
  } //Bucle sobre las filas*/
  
  objParams.arrCodigosProductos = codigoProductos;
  
	mostrarModalSICC('LPIngresoFisicoHojaDemanda','añadir',objParams,null,null);	
	accionPaginado();
}

function accionModificar(){
	if (datosDeDetalle.numSelecc() == 0)  {
    	// Muestra el mensaje: "Debe seleccionar un elemento de la lista"
    	GestionarMensaje('50');
    }else {                                                                             
		if (datosDeDetalle.numSelecc() != 1 ) {                                
	   	         //Muesta el mensaje: "Debe seleccionar un solo registro"
    	         GestionarMensaje('1022');                               
    	} else { 
    		var objParams = new Object();
    		var seleccionado = datosDeDetalle.codSeleccionados();
    		var oidCabecera = get(FORMULARIO +'.oidRegistroAbastecimientoCabecera');
    		datosDeDetalle.actualizaDat();
            var datosFinal = datosDeDetalle.datos;
            for (i = 0; i < datosFinal.length; i++) {
            	var fila = datosFinal[i];
            	if(fila[0]== seleccionado){
            		var codProd =  fila[1];
            		var descrCort = fila[2];
            		var uniAten =  fila[5];
            		var uniEnvi =  fila[3];
            		var uniConf =  fila[4];
            		var oidProd = fila[7]; 
            		objParams.codigoProducto = codProd;
            		objParams.descripcionCorta = descrCort;
            		objParams.unidadesAtendidas = uniAten;
            		objParams.unidadesEnviadas = uniEnvi;
            		objParams.unidadesCofirmadas = uniConf;
            		objParams.oidProducto = oidProd;
            	}
            } //Bucle sobre las filas*/
			
			objParams.oidDetalle = seleccionado;
			objParams.oidRegistroAbastecimientoCabecera = oidCabecera;
			mostrarModalSICC('LPIngresoFisicoHojaDemanda','modificar',objParams,null,null);
			accionPaginado();	
    	}
	}
}


function accionPaginado(){

	var pais = get(FORMULARIO +'.pais');
	var idioma = get(FORMULARIO +'.idioma');
	var oidRegistroAbastecimientoCabecera = get(FORMULARIO +'.oidRegistroAbastecimientoCabecera');

	configurarPaginado(mipgndo,"BELBuscarHojaDemandaDetalle",
								"ConectorBuscarHojaDemandaDetalle",
								"es.indra.sicc.dtos.bel.DTOEBuscarHojaDemandaDetalle",
								[['oidPais',pais],
								['oidIdioma',idioma],
								['oidRegistroAbastecimientoCabecera',oidRegistroAbastecimientoCabecera]]);
	
}

function fGuardar(){

	set(FORMULARIO + '.accion','guardar');
    set(FORMULARIO + '.conectorAction',"LPIngresoFisicoHojaDemanda");
    enviaSICC(FORMULARIO);
	
}

function fVolver(){
	window.close();	
}

function focotabModificar(){
	document.all['btnAnadir'].focus();	
}

function focoshAnadir(){
	document.all['btnModificar'].focus();
}

function Correcto(){
	//alert('inserción correcta');
	formulario.oculto = 'N';
	//alert('mandamos el formulario');
	set(FORMULARIO + '.accion','mostrar');
    set(FORMULARIO + '.conectorAction',"LPIngresoFisicoHojaDemanda");
    enviaSICC(FORMULARIO);
		
}







