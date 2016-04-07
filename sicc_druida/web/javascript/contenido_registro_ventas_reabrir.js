var FORMULARIO = 'Formulario';

//var FORMULARIO = 'frmRegistroVentas';      
function onLoadPag() {
	 configurarMenuSecundario(FORMULARIO);
	 var errDescripcion = get(FORMULARIO +'.errDescripcion');
	 if (errDescripcion !='') {		
		var errCodigo = get(FORMULARIO+'.errCodigo');
		var wnd = fMostrarMensajeError(errCodigo, errDescripcion);
	 }	
	focaliza(FORMULARIO+'.txtFechaCierre');
	if(get(FORMULARIO +'.accion')=='salida'){
		/*  Mostramos un mensaje indicando el número de registros que 
   		 * se han actualizado: "Se han actualizado {numero} registros" (UICCC012),                  
     	 * siendo "numero=numeroRegistrosActualizados", parámetro devuelto por el método                            
      	 * invocado con el idBusiness="CCCReabrirRegistroVentas" (MONRegistroVentas.reabrirRegistrosVentas():DTONumRegistros).
     	 */ 
		registros = get(FORMULARIO+'.numRegistros');
		cdos_mostrarAlert(GestionarMensaje('1376',registros));
	}
	eval (ON_RSZ);  	
}

function accionBTN_ReabrirPeriodo(){
	
	/*Si el campo de búsqueda está en blanco mostramos una mensaje:                               
    * "Debe seleccionar, al menos, {numero} criterios de búsqueda" (UICCC008).                                  
   	* Siendo numero=1.
   	*/
   
   // HACER COMPROBACION
    
    if(sicc_validaciones_generales()){   
	    var opcion = cdos_mostrarConfirm(GestionarMensaje('1375')); 
	    if (opcion){
	    	set(FORMULARIO+'.opcion',"S");
	    }else{
	       	set(FORMULARIO+'.opcion',"N");
	    }                     
	    set(FORMULARIO+'.conectorAction',"LPReabrirPeriodo");
	    set(FORMULARIO+'.accion',"reabrir");
	    enviaSICC(FORMULARIO);     
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
 