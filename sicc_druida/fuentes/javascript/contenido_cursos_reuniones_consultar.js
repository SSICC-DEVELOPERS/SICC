var FORMULARIO = "formulario";

function onLoadPag()   { 

        configurarMenuSecundario(FORMULARIO);	

	DrdEnsanchaConMargenDcho('listado1',12);	 
	document.all["Cplistado1"].style.visibility='';
	document.all["CpLin1listado1"].style.visibility='';
	document.all["CpLin2listado1"].style.visibility='';
	document.all["CpLin3listado1"].style.visibility='';
	document.all["CpLin4listado1"].style.visibility='';
	document.all["separaDiv"].style.visibility='hidden';
	document.all["primera1Div"].style.visibility='hidden';
	document.all["ret1Div"].style.visibility='hidden';
	document.all["ava1Div"].style.visibility='hidden';
	document.all["btnDetalleDiv"].style.visibility='';
	eval (ON_RSZ);  
	
        if (get(FORMULARIO + '.errDescripcion')!='') {
                 var wnd = fMostrarMensajeError(get(FORMULARIO + '.errCodigo'), get(FORMULARIO + '.errDescripcion'));
        }	                                   

        /*- configurarPaginado(lstResultados, "CALConsultarCursosReuniones", 
        "ConectorConsultarCursosReuniones", "DTOBuscarCursosReuniones", 
        [ ["pais", get(pa�s de la sesi�n)], ["idioma", get(idioma de la sesi�n)], 
        ["oidCliente", get(varOidCliente)] );
        */

        var oidCliente = get(FORMULARIO + '.oidCliente');
        var idioma = get(FORMULARIO+'.idioma');
        var pais = get(FORMULARIO+'.pais');	
		
        configurarPaginado(mipgndo, "CALConsultarCursosReuniones", "ConectorConsultarCursosReuniones", "es.indra.sicc.dtos.cal.DTOBuscarCursosReuniones",
                 [['oidCliente', oidCliente], 
                 ['oidPais', pais], 
                 ['oidIdioma', idioma]]);	   
	                                          
}	
function onClickDetalle() {
	   // M�todo que se ejecuta al pulsar sobre el bot�n Datos adicionales de la Cabecera de pedidos 
	   // Se comprueba que se ha seleccionado un registro
	   if (listado1.numSelecc() == 0) {
	            // Muestra el mensaje: "Debe seleccionar un elemento de la lista"
	            GestionarMensaje('50');
	   } else {
	            if (listado1.numSelecc() != 1 ) {
	                   //Muesta el mensaje: "Debe seleccionar un solo registro"
	                   GestionarMensaje('8');
	                   //deseleccionar filas
	                   deseleccionaListado();
	            } else {
	                     var objParams = new Object();	                    
	                     seleccionados = listado1.codSeleccionados();
	                     objParams.objetivo = listado1.extraeDato(seleccionados[0],9);
	                     mostrarModalSICC('LPCursosReuniones', 'detalle', objParams, null, null);		
	            }
	   }
}

         function deseleccionaListado() {
                  for (i = 0; i < listado1.datos.length; i++)
                                    listado1.deselecciona(i); 
         }


function fVolver(){
	window.returnValue=get(FORMULARIO+'.oidContacto');
	window.close();            
}
	
	
	
function unLoadPag(){
	window.returnValue=get(FORMULARIO+'.oidContacto');
}

