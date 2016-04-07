/**
* Copyright 2005 © por Indra Sistemas,S.A.. Todos los derechos reservados.
* Avda. de Bruselas, 35
* Parque Empresarial Arroyo de la Vega
* 28108 Alcobendas, Madrid
* España
*
* Privado y Confidencial.
* La información contenida en este documento es propiedad de Indra sistemas.
* Para uso exclusivo de empleados autorizados no permitiéndose
* la distribución de este código sin permiso expreso.
*/ 


var FORMULARIO = 'formulario';
function onLoadPag()   { 
	if (get(FORMULARIO+'.errDescripcion')!='') {
	
	      var wnd = fMostrarMensajeError(get(FORMULARIO+'.errCodigo'),get(FORMULARIO+'.errDescripcion'));
	}
	
	focaliza(FORMULARIO + ".cbTipoPeriodo");

	

	
	
	ocultarOMostrar('hidden');
	eval (ON_RSZ);  
	
	configurarMenuSecundario(FORMULARIO);       
}


function ocultarOMostrar(visible) {
    	 
	DrdEnsanchaConMargenDcho('listado1',12);   	
   document.all["Cplistado1"].style.visibility=visible;
	document.all["CpLin1listado1"].style.visibility=visible;
	document.all["CpLin2listado1"].style.visibility=visible;
	document.all["CpLin3listado1"].style.visibility=visible;
	document.all["CpLin4listado1"].style.visibility=visible;
	document.all["separaDiv"].style.visibility=visible;
	document.all["primera1Div"].style.visibility=visible ;
	document.all["ret1Div"].style.visibility=visible;
	document.all["ava1Div"].style.visibility=visible;
	document.all["btnDetalleDiv"].style.visibility=visible;
	
}


function fVolver(){
	window.returnValue=get(FORMULARIO+'.oidContacto');
	window.close();            
}

function unLoadPag(){
            window.returnValue=get(FORMULARIO+'.oidContacto');
}
function onClickBuscar() {	
	/*
	Cuando se pulsa el botón btnBuscar. 
	Se carga la lista lstResultados con los pedidos no facturados que cumplen el criterio de búsqueda especificado por el usuario. 
	*/
	
	/*incidencia BELC300012599		 */
	if(sicc_validaciones_generales()){
		var periodo = get(FORMULARIO+'.cbPeriodo');
		var idioma = get(FORMULARIO+'.idioma');
		var pais = get(FORMULARIO+'.pais');
		var oidCliente =get(FORMULARIO+'.oidCliente'); 
		var DTOBuscarPedidosNoFacturados= "es.indra.sicc.dtos.cal.DTOBuscarPedidosNoFacturados";
		 /* incidencia BELC300022702 filtrado por oid de cliente y el país*/
		/*alert('el pais es ' + pais);
		alert('el cliente es'+oidCliente);
		alert(' el periodo es'+ periodo);				*/
		
		configurarPaginado(mipgndo, "CALBuscarPedidosNoFacturados", "ConectorBuscarPedidosNoFacturados", DTOBuscarPedidosNoFacturados, 
						[ ["oidPais", pais], 
						["oidIdioma", idioma], 
						["oidPeriodoCorpo", periodo],
						["oidCliente", oidCliente]	]);
		/*alert('hizo algo');	*/
	}				 

}

function onSeleccionaTipoPeriodo(){
	/*
	Este método javascript se ejecuta cuando se ha seleccionado un Tipo de Periodo. 

	Se carga el combo: 
	- cmbPeriodoCorpo 
	En función de cmbTipoPeriodo. 
	*/
	
	var tipoPeriodo = get(FORMULARIO+'.cbTipoPeriodo');
	var DTOPeriodosPorTipoPeriodo = "es.indra.sicc.dtos.seg.DTOPeriodosPorTipoPeriodo";
	set_combo(FORMULARIO + '.cbPeriodo',[['','']],['']);
	if (tipoPeriodo != ''){
		recargaCombo(FORMULARIO+'.cbPeriodo', 'SEGObtenerPeriodosPorTipoPeriodo', DTOPeriodosPorTipoPeriodo, 
				[['oidTipoPeriodo', tipoPeriodo]] );			
	}
}

function onClickbtnDetalle() {
	/*
	Si hay una fila seleccionada en lstResultados 
	Se abre una ventana emergente modal y en la nueva ventana se invoca LPPresentarClientes con: 
	accion = "Datos adicionales Cabecera" 
	pais = país de la sesión 
	idioma = idioma de la sesión 
	oidSolicitudCabecera = oid de la solicitud seleccionada en lstResultados 
	Fin del Si
	*/
		
	if (listado1.numSelecc() == 0) {
		// Muestra el mensaje: "Debe seleccionar un elemento de la lista"
                  GestionarMensaje('50');
	}else{
		if (listado1.numSelecc() != 1 ) {
		       //Muesta el mensaje: "Debe seleccionar un solo registro"
		       GestionarMensaje('8');
		       deseleccionaListado();
		} else {
			/*Se abre una ventana emergente modal y en la nueva ventana se invoca LPPresentarClientes con:
			accion = "Datos adicionales Cabecera" 
			oidSolicitudCabecera = oid de la solicitud seleccionada en lstResultados 			*/
		     
			   var objParams = new Object();
		       
		       objParams.idioma= get(FORMULARIO+'.idioma');
		       objParams.pais = get(FORMULARIO+'.pais');

			   // Agregado por CAL-04
               objParams.oidCliente = get(FORMULARIO+'.oidCliente');
			   objParams.oidTipoCliente = get(FORMULARIO+'.oidTipoCliente');
			   objParams.indConsultoraInterna = get(FORMULARIO+'.indConsultoraInterna');
			   objParams.oidSubTipoCliente = get(FORMULARIO+'.oidSubTipoCliente');
			   // fin Agregado por CAL-04
		       
			   var codigoSeleccionado = listado1.codSeleccionados();
			   
			   objParams.oidSolicitudCabecera = listado1.codSeleccionados();

		    //   mostrarModalSICC('LPPresentarClientes', 'Datos adicionales Cabecera', objParams, null, null);
			     mostrarModalSICC('LPPresentarClientes', 'MostrarFichaPedidoNoFacturado', objParams, null, null);
			
		}		
	}
}

function focalizaBuscarOntab(){
	if (listado1.datos.length == 0) {
		//La lista no esta visible
		focaliza(FORMULARIO + ".cbTipoPeriodo");
	}else {
		//La lista esta visible pasamos el foco al boton correspondiente
		document.all['btnDetalle'].focus();
	}
}

function focalizaOnTab(){
	focaliza(FORMULARIO + ".cbTipoPeriodo");
}

function focalizaOnshTabCombo(){
	if (!get_visibilidad("capaLista")) {
		//La lista no esta visible
		document.all['btnBuscar'].focus();
	}else {
		//La lista esta visible pasamos el foco al boton correspondiente
		document.all['btnDetalle'].focus();
	}		
}

function visibleLista() {
         DrdEnsanchaConMargenDcho('listado1',12);
         visibilidad('capaLista','V');
         eval (ON_RSZ);  
}

function invisibleLista() {
         visibilidad('capaLista','O');
}
/*function muestraLista(ultima, rowset){
           var tamano = rowset.length;
           if (tamano > 0) {
                      visibleLista();
                      return true;
           } else {
                      invisibleLista();
                      return false;
           }
}	   */

function fLimpiar() {
	set_combo(FORMULARIO + '.cbPeriodo',[['','']],['']);
}

         function deseleccionaListado() {
                  for (i = 0; i < listado1.datos.length; i++)
                                    listado1.deselecciona(i); 
         }

		function muestraLista(ultima, rowset){
				
				if (rowset.length>0) {

				   ocultarOMostrar('visible');
				   
				   return true;
				}
				else{
					return false;
				}
		}