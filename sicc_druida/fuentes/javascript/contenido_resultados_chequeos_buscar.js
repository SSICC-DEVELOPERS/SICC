var FORMULARIO = "frmFormulario";

function onLoadPag()   
{
    eval (ON_RSZ); 
    focaliza(FORMULARIO + '.txtCodigoCliente'); 
    
    var errDescripcion = get(FORMULARIO +'.errDescripcion');
    
    if (errDescripcion !='') {
         var errCodigo = get(FORMULARIO+'.errCodigo');
         var wnd = fMostrarMensajeError(errCodigo, errDescripcion);
    }

    configurarMenuSecundario(FORMULARIO);
	
	if (window.dialogArguments) { // Si es modal (se abrió mediante showModalDialog) DBLG500000915
            btnProxy(2,1);  // boton 'volver', habilitado
            btnProxy(3,0);  // boton 'Ir a pantalla de inicio', deshabilitado
    } 
}

 function fVolver() {
           window.close();
 }

function buscarClienteOnClick(){
    //Llamamos al proceso correspondiente Modal
    var objParams = new Object();
    var cliente = mostrarModalSICC('LPBusquedaRapidaCliente', '', objParams, null, null);            

    if(typeof cliente!='undefined') {
           var codigoCliente = cliente[1];
           set(FORMULARIO+'.txtCodigoCliente',codigoCliente);
           set(FORMULARIO+'.oidCliente',cliente[0]);
           set(FORMULARIO+'.nombre1',cliente[2]);
           set(FORMULARIO+'.nombre2',cliente[3]);
           set(FORMULARIO+'.apellido1',cliente[4]);
           set(FORMULARIO+'.apellido2',cliente[5]);
    }
}

function aceptarOnClick(){
	if (!sicc_validaciones_generales()) return false;
	if (get(FORMULARIO + '.casoUso') == 'Buscar_resultado_chequeos'){
		set(FORMULARIO + '.accion', 'aceptar');
	    set(FORMULARIO + '.conectorAction',"LPIntroducirResultadoChequeos");
	    enviaSICC(FORMULARIO);
	} else if (get(FORMULARIO + '.casoUso') == 'consultarInforme'){
		set(FORMULARIO + '.accion', 'consultar reclamo');
	    set(FORMULARIO + '.conectorAction',"LPConsultarInforme");
	    enviaSICC(FORMULARIO);
	}
}

function codigoClienteOnBlur() {
	var codigoCliente = get(FORMULARIO+'.txtCodigoCliente').toString();
    if (codigoCliente != '') {
          codigoCliente = codigoCliente.toUpperCase();
          var longitudCodigoCliente = get(FORMULARIO + '.longitudCodigoCliente');
          var longitud = codigoCliente.length;
          set(FORMULARIO + '.txtCodigoCliente', rellenaCeros(codigoCliente, longitudCodigoCliente, longitud))
    }
	
}

function rellenaCeros(codigoCliente, longitudCodigoCliente, longitud){
	for (i = longitud; i < longitudCodigoCliente; i++){
		codigoCliente = '0' + codigoCliente;
	}
	
	return codigoCliente;
}

function codigoClienteOnShTab(){
	document.all['btnAceptar'].focus();
}

function aceptarOnTab(){
	focaliza(FORMULARIO + '.txtCodigoCliente');
}