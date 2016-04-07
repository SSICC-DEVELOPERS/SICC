var FORMULARIO = 'frmContenido';
var motivoDesbloqueo = false;
var motivoRechazo = false;     

function onLoadPag(){
	
	var errDescripcion = get(FORMULARIO +'.errDescripcion');
	if (errDescripcion !='') {
		var errCodigo = get(FORMULARIO+'.errCodigo');
		var wnd = fMostrarMensajeError(errCodigo, errDescripcion);
	}

	document.all['Desbloquear'].focus();
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
	
	dehabilitarCombos();
	
	/*Llamamos a configurarPaginado pasándole los siguientes parametros: 
	- Objeto paginado (lstLineas) 
	- idBusiness ("RECObtenerOperacionesReclamo") 
	- "ConectorObtenerOperacionesREC" 
	- "DTOBuscarReclamosREC" 
	- Parametros del DTOE: 
	DTOE.oidsReclamo[] <- oid Reclamo recibido (1 solo oid) 
	DTOE.oidsOperaciones[] <- oids recibidos de los valores seleccionados en el combo operacionReclamos de la pantalla llamante 
	DTOE.oidsTiposBloqueo[] <- oids recibidos de los valores seleccionados en tipoBloqueo de la pantalla llamante 
	*/
	
	var pais = get(FORMULARIO + '.pais');
	var idioma = get(FORMULARIO + '.idioma');
	var oid = get(FORMULARIO + '.oid');
	
	var oidsOperaciones = get(FORMULARIO + '.oidsOperaciones');
	var oidsTiposBloqueo = get(FORMULARIO + '.oidsTiposBloqueo');
	    
	
	configurarPaginado(mipgndo,"RECObtenerOperacionesReclamo",
         "ConectorObtenerOperacionesREC","es.indra.sicc.dtos.rec.DTOBuscarReclamosREC",
         [["oidPais", pais],
         ["oidIdioma", idioma],
         ["oid",oid],
         ["stringOperaciones",oidsOperaciones],
         ["stringTiposBloqueo",oidsTiposBloqueo]]);
	
	
	configurarMenuSecundario(FORMULARIO);
}

function onClickDesbloquear(){

	/*Documentation
	-> Comprobar que se ha seleccionado algún registro de la lstResultados: 
	-> Si hay seleccionado algun registro de la lista: habilitar el combo cbMotivoDesbloqueo 
	*/
	if (listado1.numSelecc() == 0) {   
    	// Muestra el mensaje: "Debe seleccionar un elemento de la lista"
    	GestionarMensaje('50');
    }else {                                                                                                    
    	accion(FORMULARIO+'.cbMotivoDesbloqueo','.disabled=false');
		accion(FORMULARIO+'.cbMotivoRechazo','.disabled=true');
		set(FORMULARIO+'.cbMotivoRechazo',['']);
		motivoDesbloqueo = true;
		motivoRechazo = false;
	}
	
}
function onClickRechazar(){

	/*Documentation
	-> Comprobar que se ha seleccionado algun registro de la lstResultados: 
	-> Si hay seleccionado algun registro de la lista: habilitar el combo cbMotivoRechazo
	*/
	if (listado1.numSelecc() == 0) {   
    	// Muestra el mensaje: "Debe seleccionar un elemento de la lista"
    	GestionarMensaje('50');
    }else {                                                                                                    
    	accion(FORMULARIO+'.cbMotivoRechazo','.disabled=false');
		accion(FORMULARIO+'.cbMotivoDesbloqueo','.disabled=true');
		set(FORMULARIO+'.cbMotivoRechazo',['']);
		motivoRechazo = true;
		motivoDesbloqueo = false;
	}
} 

function onClickAceptar(){

	/*Documentation
	-> Si cbMotivoDesbloqueo esta habilitado { 
	Si se ha seleccionado un valor en cbMotivoDesbloqueo { 
	- Inhabilitar combo cbMotivoDesbloqueo 
	- // Enviar el formulario oculto 
	formulario.oculto = "S" 
	enviaSICC(formulario) 
	- Llamar a la LPGestionReclamos con: 
	- accion="desbloquear" y opcion = "operacion" 
	- oids de los registros seleccionados en lstOperaciones // oid operacion de reclamo 
	- oid del valor seleccionado en cbMotivoDesbloqueo } 
	Si no { 
	- Mostrar mensaje generico para seleccionar un valor del combo } 
	} 
	*/
	if (listado1.numSelecc() == 0) {   
	    	// Muestra el mensaje: "Debe seleccionar un elemento de la lista"
    		GestionarMensaje('50');
    }else {
		
		if(motivoDesbloqueo == true){
			
			if(sicc_validaciones_generales("desbloqueo")){	
					
				set(FORMULARIO+'.conectorAction',"LPGestionReclamos");
				set(FORMULARIO+'.accion',"desbloquear");
				set(FORMULARIO+'.opcion',"operacion");
    	    	set(FORMULARIO+'.oidsLista', listado1.codSeleccionados());
				set(FORMULARIO+'.oidMotivoDesbloqueo', get(FORMULARIO+'.cbMotivoDesbloqueo'));
				accion(FORMULARIO+'.cbMotivoDesbloqueo','.disabled=true');
				enviaSICC(FORMULARIO,null,null,"N");      
			}
		}
		
		/*
		-> Si cbMotivoRechazo esta habilitado { 
		Si se ha seleccionado un valor en dicho combo { 
		- Inhabilitar combo cbMotivoRechazo 
		- // Enviar el formulario oculto 
		formulario.oculto = "S" 
		enviaSICC(formulario) 
		-> Llamar a la LPGestionReclamos con: 
		- accion="rechazar" y opcion = "oeracion" 
		- oids de los registros seleccionados en lstOperaciones // oid operacion de reclamo 
		- oid del valor seleccionado en cbMotivoRechazo } 
		Si no { 
		- Mostrar mensaje generico para seleccionar un valor del combo } 
		}
		*/
		else{
			
			if( motivoRechazo == true){
				if(sicc_validaciones_generales("rechazo")){				
					set(FORMULARIO+'.conectorAction',"LPGestionReclamos");
					set(FORMULARIO+'.accion',"rechazar");
					set(FORMULARIO+'.opcion',"operacion");
					set(FORMULARIO+'.oidsLista', listado1.codSeleccionados());
					set(FORMULARIO+'.oidMotivoRechazo', get(FORMULARIO+'.cbMotivoRechazo'));
					accion(FORMULARIO+'.cbMotivoRechazo','.disabled=true');
					enviaSICC(FORMULARIO,null,null,"N");      
				}
			}
		}
	}
}

function onClickDetalle(){
	
	/*Documentation
	- Validar que se ha seleccionado un elemento de la lista 
	- Mostrar la ventana modal y emergente PgDetalleReclamosBloqueados , enviando el valor del oid del registro seleccionado en lstOperaciones 
	// Se bloquea la ejecución hasta el cierre de la ventana emergente 
	*/
	
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
			
			var objParams = new Object();
			objParams.oid = listado1.codSeleccionados();
			mostrarModalSICC('LPGestionReclamos', 'detalle', objParams, null, null);
		}
	}
}

function focalizaSiguiente(){
	
	if(motivoDesbloqueo == true){
		focaliza(FORMULARIO+'.cbMotivoDesbloqueo');
	}else{
		document.all['btnAceptar'].focus();
	}	
}	

function shtabAceptar(){
	
	if(motivoRechazo == true)
		focaliza(FORMULARIO+'.cbMotivoRechazo');
	else
		document.all['Detalle'].focus();
	
}

function dehabilitarCombos(){
	if (listado1.numSelecc() == 0) {
		accion(FORMULARIO+'.cbMotivoDesbloqueo','.disabled=true');
		accion(FORMULARIO+'.cbMotivoRechazo','.disabled=true');
		motivoRechazo = false;
		motivoDesbloqueo = false;				
	}
}

function fVolver(){
	window.close();	
}     

function correctoOperacion(){
	set(FORMULARIO+'.cbMotivoDesbloqueo',['']);
	set(FORMULARIO+'.cbMotivoRechazo',['']);
	//mipgndo.recargar(); 
	listado1.eliminarSelecc(); 
}                