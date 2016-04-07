var FORMULARIO = "frmRegistroVentas";

function onLoadPag(){
      	configurarMenuSecundario(FORMULARIO);
      	var errDescripcion = get(FORMULARIO +'.errDescripcion');
      	var mensajeError = get(FORMULARIO+'.mensajeError');
      	var registros = get(FORMULARIO+'.registros');
      	focaliza(FORMULARIO+'.textFechaEmisionD');
      	if(mensajeError!=''){
      		cdos_mostrarAlert(mensajeError);
      		set(FORMULARIO+'.mensajeError','');
      		if(get(FORMULARIO+'.textClienteD')!=''){
           		focaliza(FORMULARIO+'.textClienteD');
           	}else{
           		focaliza(FORMULARIO+'.textClienteH');
           	}
      	}
      	if(registros!=''){
      		//Mostramos un mensaje indicando el número de registros que se han actualizado. 1376
      		cdos_mostrarAlert(GestionarMensaje('1376',get(FORMULARIO+'.registros')));
      		set(FORMULARIO+'.registros','');
      		focaliza(FORMULARIO+'.textFechaEmisionD');
      	} 
      	if (errDescripcion !='') {        
        	var errCodigo = get(FORMULARIO+'.errCodigo');
           	var wnd = fMostrarMensajeError(errCodigo, errDescripcion);
           	if(get(FORMULARIO+'.textClienteD')!=''){
           		focaliza(FORMULARIO+'.textClienteD');
           	}else{
           		focaliza(FORMULARIO+'.textClienteH');
           	}
      	}	
}

function comprobarFecha(txtFecha){
	var fecha = get(FORMULARIO+'.'+txtFecha);
	if(fecha != ""){
    	var resul = EsFechaValida(fecha,fecha, FORMULARIO,null);
		if(resul==1 || resul==2){  
       		GestionarMensaje('1006', get(FORMULARIO+'.hFormatoFechaPais')); 
			focaliza(FORMULARIO+'.'+txtFecha);
			return ;
        }
    }
}

function desplazarOnTab(){
	focaliza(FORMULARIO+'.textFechaEmisionD');
}

function desplazarOnShTab(){
	document.all["btnCerrar"].focus();
}

function accionBTNIMG_BuscarClienteDesde(){
        //En diseño no viene nada
    	var objParams = new Object();
    	var cliente = mostrarModalSICC('LPBusquedaRapidaCliente', '', objParams, null, null);          
    	if(typeof cliente!='undefined') {
    		var codigoClienteDesde = cliente[1];
    		set(FORMULARIO+'.textClienteD',codigoClienteDesde);
    	}
}

function accionBTNIMG_BuscarClienteHasta(){
       	var objParams = new Object();
    	var cliente = mostrarModalSICC('LPBusquedaRapidaCliente', '', objParams, null, null);          
    	if(typeof cliente!='undefined') {
		var codigoClienteHasta = cliente[1];
    		set(FORMULARIO+'.textClienteH',codigoClienteHasta);
    	}
}

function accionBTN_CerrarPeriodo(){
	var fechaEmisionDesde = get(FORMULARIO+'.textFechaEmisionD');
	var fechaEmisionHasta = get(FORMULARIO+'.textFechaEmisionH');
	var clienteDesde = get(FORMULARIO+'.textClienteD');
	var clienteHasta = get(FORMULARIO+'.textClienteH');
	var impuestos = get(FORMULARIO+'.cbImpuesto');
	var fechaCierre = get(FORMULARIO+'.text');
	var contador = 0; 
	//Comprobamos si se han seleccionado al menos dos criterios de busqueda
	if(fechaEmisionDesde!=''){
		contador++;
	}
	if(fechaEmisionHasta!=''){
		contador++;
	}
	if(clienteDesde!=''){
		contador++;
	}
	if(clienteHasta!=''){
		contador++;
	}
	if(impuestos!=''){
		contador++;
	}
	if(contador<2){
		//mostramos el mensaje: "Debe seleccionar, al menos, 2 criterios de búsqueda" (UICCC008).
		//Codigo 1374
		cdos_mostrarAlert(GestionarMensaje('1374',2));
		focaliza(FORMULARIO+'.textFechaEmisionD');
	}else{
		if(fechaCierre==''){
			//"El campo de entrada 'Fecha de Cierre' es obligatorio" (UICCC009) 
			//Codigo 1377
			cdos_mostrarAlert(GestionarMensaje('1377'));
			focaliza(FORMULARIO+'.text');
		}else{
			var vRet = GestionarMensaje('1472',null,null,null);
			
			if (vRet){
				
				//Llamamos a LPCerrarRegistroVentas con el parámetro: accion="CerrarPeriodo"
				set(FORMULARIO+'.conectorAction',"LPCerrarRegistroVentas");
         		set(FORMULARIO+'.accion',"CerrarPeriodo");
         		enviaSICC(FORMULARIO);
         	}
		}
	}
}

// Función que se ejecuta en el OnBlur del campo textCodClienteD.
// Rellena con ceros el la parte izquierda de código de cliente.
function textCodClienteDOnBlur() {
         var codigoCliente = get(FORMULARIO+'.textClienteD').toString();
         if (codigoCliente != '') {
                  var longitudCodigoCliente = get(FORMULARIO+'.numDigitosCodigoCliente').toString();
                  var longitud = codigoCliente.length;
                  set(FORMULARIO+'.textClienteD',rellenaCeros(codigoCliente,longitudCodigoCliente,longitud))
         }
}

// Función que se ejecuta en el OnBlur del campo textCodClienteH.
// Rellena con ceros el la parte izquierda de código de cliente.
function textCodClienteHOnBlur() {
         var codigoCliente = get(FORMULARIO+'.textClienteH').toString();	
         if (codigoCliente != '') {
                  var longitudCodigoCliente = get(FORMULARIO+'.numDigitosCodigoCliente').toString();
                  var longitud = codigoCliente.length;
                  set(FORMULARIO+'.textClienteH',rellenaCeros(codigoCliente,longitudCodigoCliente,longitud))
         }
}