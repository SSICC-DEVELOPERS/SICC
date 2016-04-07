var FORMULARIO = "formulario";
var indexFilaSeleccionada = -1;
function onLoadPag(){
		configurarMenuSecundario(FORMULARIO); 
	    DrdEnsanchaConMargenDcho('listado1',12);	
	    document.all["Cplistado1"].style.visibility='';
	    document.all["CpLin1listado1"].style.visibility='';
	    document.all["CpLin2listado1"].style.visibility='';
	    document.all["CpLin3listado1"].style.visibility='';
	    document.all["CpLin4listado1"].style.visibility='';
	    eval (ON_RSZ); 
	    document.all['btnVerFicha'].focus(); 
}

function accionVerFicha(){
	
	//Se comprueba que se ha seleccionado un sólo elemento de la lista 

	/*Si se ha seleccionado un elemento                                                            
	Llamar a la LPPresentarClientes con los siguientes parámetros: 											
	accion = "Ver Ficha desde Página"                              											
	pais = pais activo                                             											
	oidCliente = lstTiposCliente.oidCliente                        											
	codigoCliente = lstTiposCliente.codigoCliente                  											
	oidTipoCliente = lstTiposCliente.oidTipoCliente                											
	codigoTipoCliente = lstTiposCliente.codigoTipoCliente          											
	 */
	var oidCliente = "";
	var codigoCliente = "";
	var oidTipoCliente = "";
	var codigoTipoCliente ="";
	
	if (listado1.numSelecc() == 0) {
          //Mostramos mensaje de error 
          GestionarMensaje('50');
    /*} else {
    	if (listado1.numSelecc()!=1) {
        	//Muesta el mensaje: "Debe seleccionar un solo registro"
            GestionarMensaje('8');
            //Se limpia la lista editable
            var seleccion=listado1.codigos();
            var i=0;
            while(seleccion[i]!=null){
            	listado1.deselecciona(i); 
                i++;            
            }*/
		}else {
        	var fila = listado1.datos[indexFilaSeleccionada];
          	oidCliente = fila[0];
          	codigoCliente = fila[1];
           	oidTipoCliente = fila[2];  // pendiente de incidencia BELC300012594
          	codigoTipoCliente = fila[3];

			var objParams = new Object();
			objParams.oidCliente = oidCliente; 
			objParams.oidTipoCliente = oidTipoCliente; 
			objParams.codigoCliente = codigoCliente; 
			objParams.codigoTipoCliente = codigoTipoCliente;
			objParams.casoDeUso = "Presentar";
			mostrarModalSICC('LPPresentarClientes', 'Ver Ficha desde Página', objParams, null, null);           

/*		set(FORMULARIO+'.oidCliente', oidCliente);
		set(FORMULARIO+'.codigoCliente', codigoCliente);
		set(FORMULARIO+'.oidTipoCliente', oidTipoCliente);
		set(FORMULARIO+'.codigoTipoCliente', codigoTipoCliente);	
		set(FORMULARIO+'.conectorAction',"LPPresentarClientes");       
		set(FORMULARIO+'.accion',"Ver Ficha desde Página");                     
		enviaSICC(FORMULARIO);  */                                   
	}
			 
}           

function fVolver(){
    window.close();              
}  

function seleccionaFila(FILAEVENTO){
	indexFilaSeleccionada = FILAEVENTO;
}                                                 

