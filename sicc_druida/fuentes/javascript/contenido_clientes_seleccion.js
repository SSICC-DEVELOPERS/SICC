var FORMULARIO = "formulario";
function onLoadPag(){
	configurarMenuSecundario(FORMULARIO);
	focaliza('formulario.cbSeleccion');
	
}
function ontabPag(){
	focaliza('formulario.cbSeleccion');
}
function onshtabPag(){
	if (!get_visibilidad("capa2"))
		document.all['btnAceptar'].focus(); 
	else
		document.all['btnVerFicha'].focus(); 
}

function siguienteAceptar() {
	if (!get_visibilidad("capa2"))
		focaliza('formulario.cbSeleccion');
	else
		focaliza(FORMULARIO+'.txtCodCliente');
}

function accionAceptar() {
	if(get(FORMULARIO + '.cbSeleccion')== get(FORMULARIO + '.cteLlamadaDirecta')) { //ConstantesCAL.LLAMADA_DIRECTA necesito un hidden para llamarlo lo considero que se llama llamadaDirecta		
		//Mostrar capa2
		visibilidad('capa2', 'V'); 
	} else { 
		//Ocultar capa2
		visibilidad('capa2', 'O'); 
		//Llamar a la LPRecepcionLlamadas con: 
		/*set(FORMULARIO + '.conectorAction', "LPRecepcionLlamadas");
		set(FORMULARIO + '.accion', "Buscar");
		enviaSICC(FORMULARIO);*/
		var objParams = new Object();
		objParams.casoDeUso = "Presentar";
		mostrarModalSICC('LPRecepcionLlamadas', 'Buscar', objParams, null, null);          
	}
	
}



function codClienteOnBlur() {
			
           var codigoCliente = get(FORMULARIO+'.txtCodCliente').toString();
    if (codigoCliente != '') {
    		
           codigoCliente = codigoCliente.toUpperCase();
           var longitudCodigoCliente = get(FORMULARIO+'.numDigitosCodigoCliente').toString();
           var longitud = codigoCliente.length;
           set(FORMULARIO+'.txtCodCliente',rellenaCeros(codigoCliente,longitudCodigoCliente,longitud))
    }
}



function accionVerFicha() {
	if (!sicc_validaciones_generales()) { return false; }

	var objParams = new Object();
	objParams.codigoCliente = get(FORMULARIO + '.txtCodCliente');
	  //incidencia  	 BELC300022702  	se agrega atributo oidCliente
	objParams.oidCliente = get(FORMULARIO + '.oidCliente');

	objParams.indConsultaInterna = "N";
	objParams.casoDeUso = "Presentar";
	mostrarModalSICC('LPPresentarClientes', 'Comprobar Cliente', objParams, null, null);          
}

function mostrarCAL0003(){
	cdos_mostrarAlert(GestionarMensaje('UICAL0003'));
}
 

function accionBuscarCliente() {
	 /*Llamamos al proceso correspondiente Modal		 */
    var objParams = new Object();
    var cliente = mostrarModalSICC('LPBusquedaRapidaCliente', '', objParams, null, null);           
     /*alert(cliente);*/
	if (cliente != null && cliente.length > 1) {
		/* alert(cliente[0]);	*/
		 /*incidencia  	 BELC300022702  	se agrega atributo oidCliente	  */
         set(FORMULARIO + '.oidCliente', cliente[0]);
		 set(FORMULARIO + '.txtCodCliente', cliente[1]);
    }

}



function fLimpiar() {
 	set(FORMULARIO + '.txtCodCliente', "");
 	set(FORMULARIO + '.cbSeleccion', ['']);
	visibilidad('capa2', 'O'); 
}
