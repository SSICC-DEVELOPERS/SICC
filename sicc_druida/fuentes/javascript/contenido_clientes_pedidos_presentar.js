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


/*
    INDRA/CAR/PROY
    $Id: contenido_clientes_pedidos_presentar.js,v 1.1 2009/12/03 19:02:08 pecbazalar Exp $
    DESC
*/
	var FORMULARIO = 'formulario';
	var visibleLista = 'false';
	var cargado = false;
	
	function onLoadPag()   { 
		configurarMenuSecundario(FORMULARIO);	
		
		cargado = true;
		
		DrdEnsanchaConMargenDcho('listado1',12);
		document.all["Cplistado1"].style.visibility='visible';
		document.all["CpLin1listado1"].style.visibility='visible';
		document.all["CpLin2listado1"].style.visibility='visible';
		document.all["CpLin3listado1"].style.visibility='visible';
		document.all["CpLin4listado1"].style.visibility='visible';
		document.all["primera1Div"].style.visibility='visible';
		document.all["ret1Div"].style.visibility='visible';
		document.all["ava1Div"].style.visibility='visible';
		document.all["separaDiv"].style.visibility='visible';
	    document.all["btnDatosAdicionales1Div"].style.visibility='visible';
	    document.all["btnDetallePedidoDiv"].style.visibility='visible';
		eval (ON_RSZ);  	

		if (get(FORMULARIO + '.errDescripcion')!='') {
			var wnd = fMostrarMensajeError(get(FORMULARIO + '.errCodigo'), get(FORMULARIO + '.errDescripcion'));
		}	
		
		//configurarMenuSecundario(FORMULARIO);

		/*- Llamamos a configurarPaginado pasándole los siguientes parametros: 

			- Objeto paginado (lstCabecera) 
			- idBusiness ("CALObtenerCabeceraPedidos") 
			- "ConectorObtenerCabeceraPedidos" 
			- "DTOOID" 
			- Parametros del DTO: 
			- pais activo 
			- idioma activo 
			- oidCliente
		*/

		//modificado por CAL-04
		
		var indNoFacturado = get(FORMULARIO + '.indNoFacturado');
		
        if(indNoFacturado != "NoFacturado"){

			var oid = get(FORMULARIO + '.oidCliente');
			var idioma = get(FORMULARIO+'.idioma');
			var pais = get(FORMULARIO+'.pais');						
			
			configurarPaginado(mipgndo, "CALObtenerCabeceraPedidos", "ConectorObtenerCabeceraPedidos", "es.indra.sicc.cmn.negocio.comun.DTOComunes.DTOOIDPaginado",
				[['oid', oid], 
				['oidPais', pais], 
				['oidIdioma', idioma]]);	
				
				//esperamos el tiempo suficiente para cargar la lista
				//luego, asignamos el foco	
				setTimeout("document.all['btnDatosAdicionales1'].focus()",1);
		}else{
			
    		 var oidSolicitud = get(FORMULARIO + '.oidSolicitudCabecera');
	         var idioma = get(FORMULARIO+'.idioma');
			 var pais = get(FORMULARIO+'.pais');

			
			configurarPaginado(mipgndo, "CALObtenerCabeceraPedidoNoFacturado", "ConectorObtenerCabeceraPedidoNoFacturado", "es.indra.sicc.cmn.negocio.comun.DTOComunes.DTOOIDPaginado",
				[['oid', oidSolicitud], 
				['oidPais', pais], 
				['oidIdioma', idioma]]);
								
		}
		//fin de modificado CAL-04


			//esperamos el tiempo suficiente para cargar la lista
			//luego, asignamos el foco	
		    //setTimeout("document.all['btnDatosAdicionales1'].focus()",1);
	}	

	function muestraLista2( ultima, rowset){
			
	    	visibleLista = 'true';	
	    	DrdEnsanchaConMargenDcho('listado2',12);
	    	document.all["Cplistado2"].style.visibility='visible';
	    	document.all["CpLin1listado2"].style.visibility='visible';
	    	document.all["CpLin2listado2"].style.visibility='visible';
	    	document.all["CpLin3listado2"].style.visibility='visible';
	    	document.all["CpLin4listado2"].style.visibility='visible';
	    	document.all["separa2Div"].style.visibility='visible';
	    	document.all["primera2Div"].style.visibility='visible';
	    	document.all["ret2Div"].style.visibility='visible';
	    	document.all["ava2Div"].style.visibility='visible';
	    	document.all["btnDatosAdicionales2Div"].style.visibility='visible';	
			eval (ON_RSZ);  
		    
		return true;
	}
	function tabular(boton){
		if (visibleLista == 'false' && boton == 'btnDatosAdicionales1' ){
			document.all['btnDetallePedido'].focus();	
		}
		if (visibleLista == 'true' && boton == 'btnDatosAdicionales1' ){
			document.all['btnDatosAdicionales2'].focus();
		}
		if (visibleLista == 'false' && boton == 'btnDetallePedido' ){
			navPestana('lblVinculos');	
		}
		if (visibleLista == 'true' && boton == 'btnDetallePedido' ){
			document.all['btnDatosAdicionales2'].focus();
		}		
		if(boton == 'btnDatosAdicionales2tab'){
			document.all['btnDatosAdicionales1'].focus();
		}
		if(boton == 'btnDatosAdicionales2shtab'){
			document.all['btnDetallePedido'].focus();
		}
	}

	function navPestana(label) {
         if (typeof(parent.pestanas) != undefined )
         	parent.pestanas.onClickPestana(label);
	}


	function accionDatosAdicionalesCab() {
		// Método que se ejecuta al pulsar sobre el botón Datos adicionales de la Cabecera de pedidos 
		// Se comprueba que se ha seleccionado un registro
		if (listado1.numSelecc() == 0) {
			// Muestra el mensaje: "Debe seleccionar un elemento de la lista"
			GestionarMensaje('50');
		} else {
			if (listado1.numSelecc() != 1 ) {
                              //Muesta el mensaje: "Debe seleccionar un solo registro"
                              GestionarMensaje('8');
                              //deseleccionar filas
                              deseleccionaListado1();
			} else {
				
				var objParams = new Object();
				var codigosSeleccionados = listado1.codSeleccionados();
				objParams.oidSolicitudCabecera = listado1.extraeDato(codigosSeleccionados[0], 0);
				objParams.oidCliente = get(FORMULARIO + '.oidCliente');
				objParams.oidTipoCliente = get(FORMULARIO + '.oidTipoCliente');
				objParams.oidSubTipoCliente = get(FORMULARIO + '.oidSubTipoCliente');	
				objParams.indConsultoraInterna = get(FORMULARIO + '.indConsultoraInterna'); 
				/*Muestra la ventana emergente y modal PGDatosAdicionalesCabecera y activa la LPPresentarCliente con: 
				accion ="Datos adicionales Cabecera" 
				oidSolicitudCabecera 
				oidCliente 
				oidTipoCliente*/
				mostrarModalSICC('LPPresentarClientes', 'Datos adicionales Cabecera', objParams, null, null);		
			}
		}
	}
	
	//Modificado por incidencia 12536
	function accionDetallePedido (){		
		// Método que se ejecuta al pulsar sobre el botón Datos adicionales de la Cabecera de pedidos 
		// Se comprueba que se ha seleccionado un registro
		if (listado1.numSelecc() == 0) {
			// Muestra el mensaje: "Debe seleccionar un elemento de la lista"
			GestionarMensaje('50');
		} else {
			if (listado1.numSelecc() != 1 ) {
                              //Muesta el mensaje: "Debe seleccionar un solo registro"
                              GestionarMensaje('8');
                              //deseleccionar filas
                        deseleccionaListado1();
			} else {
				//Se obtiene el oidSolicitudCabecera del elemento seleccionado 
				var codigosSeleccionados = listado1.codSeleccionados();
				var oid = listado1.extraeDato(codigosSeleccionados[0], 0);
				/*Llamamos a configurarPaginado pasándole los siguientes parametros: 							
					 Objeto paginado (lstDetalle) 
					- idBusiness ("CALObtenerDetalleCabecera") 
					- "ConectorObtenerDetalleCabecera" 
					- "DTOOID"   --> "DTOOIDPaginado" por incidencia 12536
					- Parametros del DTO: 
					- pais activo 
					- idioma activo 
					- oidSolicitudCabecera 
				*/
				var idioma = get(FORMULARIO+'.idioma');
				var pais = get(FORMULARIO+'.pais');
			
			configurarPaginado(mipgndo2, "CALObtenerDetalleCabecera", "ConectorObtenerDetalleCabecera", "es.indra.sicc.cmn.negocio.comun.DTOComunes.DTOOIDPaginado",
				[['oid', oid], 
				['oidPais', pais], 
				['oidIdioma', idioma]]);
			
			muestraLista2();
				
			}
	}
	
}

function accionDatosAdicionalesDet() {
		// Método que se ejecuta al pulsar sobre el botón Datos adicionales del Detalle de pedidos  
		// Se comprueba que se ha seleccionado un registro
		if (listado2.numSelecc() == 0) {
			// Muestra el mensaje: "Debe seleccionar un elemento de la lista"
			GestionarMensaje('50');
		} else {
			if (listado2.numSelecc() != 1 ) {
                              //Muesta el mensaje: "Debe seleccionar un solo registro"
                              GestionarMensaje('8');
                              //deseleccionar filas
                              deseleccionaListado2();
			} else {
				// Recuperar el oidSolicitudPosicion del elemento seleccionado 
				var objParams = new Object();
				objParams.oidSolicitudPosicion = listado2.codSeleccionados();
				objParams.oidCliente = get(FORMULARIO + '.oidCliente');
				objParams.oidTipoCliente = get(FORMULARIO + '.oidTipoCliente');
				objParams.oidSubTipoCliente = get(FORMULARIO + '.oidSubTipoCliente');
				objParams.indConsultoraInterna = get(FORMULARIO + '.indConsultoraInterna'); 
				/*Muestra la ventana emergente y modal PGDatosAdicionalesDetalle y activa la LPPresentarCliente con: 
				accion ="Datos adicionales Detalle" 
				oidSolicitudPosicion 
				oidCliente 
				oidTipoCliente */
				mostrarModalSICC('LPPresentarClientes', 'Datos adicionales Detalle', objParams, null, null);		
			}
		}
	}


function deseleccionaListado1() {
	for (i = 0; i < listado1.datos.length; i++)
		listado1.deselecciona(i); 
}
function deseleccionaListado2() {
	for (i = 0; i < listado2.datos.length; i++)
		listado2.deselecciona(i); 
}

function accionFicha() { 
	set(FORMULARIO + '.accion', 'Ver Ficha Solo');
	set(FORMULARIO + '.conectorAction', "LPPresentarClientes");
	enviaSICC(FORMULARIO);
}

function accionContactos() { 
	set(FORMULARIO + '.accion', '');
	set(FORMULARIO + '.conectorAction', "LPGestionarContactos");
	enviaSICC(FORMULARIO);
}

function accionCuentasCorrientes() { 
	set(FORMULARIO + '.accion', 'Cuentas corrientes');
	set(FORMULARIO + '.conectorAction', "LPPresentarClientes");
	enviaSICC(FORMULARIO);
}

function accionPedidos() {
    // No realizar nada pues ya estamos en la pestanya Pedidos
}

function accionVinculos() { 
	set(FORMULARIO + '.accion', 'Vinculos');
	set(FORMULARIO + '.conectorAction', "LPPresentarClientes");
	enviaSICC(FORMULARIO);
}

function accionDocumentos() { 
	set(FORMULARIO + '.accion', 'Documentos');
	set(FORMULARIO + '.conectorAction', "LPPresentarClientes");
	enviaSICC(FORMULARIO);
}

function accionDireccion() { 
	set(FORMULARIO + '.accion', 'Direccion');
	set(FORMULARIO + '.conectorAction', "LPPresentarClientes");
	enviaSICC(FORMULARIO);
}

function configurarMenuSecundario(strFrame){
        /*
                   Este funcion se encarga de configurar la botonera, para ello
                   parsea el contenido del var configuracion.
        */
        //obtengo el String con la configuracion a aplicar

        var strCodigos = get(strFrame+".SICC_TOOLBAR_CONFIG");
        if(strCodigos!=null && strCodigos.split(" ").join("")!="" ){
                   //obtengo un array con cada elemento configurable.
                   //arrCodigos = strCodigos.split(",");
                   strCodigos = strCodigos.split("[").join("");
                   strCodigos = strCodigos.split("]").join("");
                   var arrCodigos = strCodigos.split(",");
                   var etiqueta;
                   if((arrCodigos[0]+"")!="-1"){
                               etiqueta = document.title;
                   }else{
                               etiqueta = "Belcorp";
                   }
                   var guardar = arrCodigos[1]+"";
                   var volver = arrCodigos[2]+"";
                   var salir = arrCodigos[3]+"";
                   var borrar = arrCodigos[4]+"";
                   var limpiar = arrCodigos[5]+"";
                   var imprimir = arrCodigos[6]+"";
                   var clave = arrCodigos[7]+"";
                   var favoritos = arrCodigos[8]+"";
                   var pais = arrCodigos[9]+"";
                   var ayuda = arrCodigos[10]+"";
                   
                   //seteo el titulo
                   parent.parent.frames["iconos"].txt_to("etiqueta1",etiqueta);
                   //seteo el estado de los botones
                   btnProxy(1,guardar);
                   btnProxy(2,volver);
                   btnProxy(3,salir);
                   btnProxy(4,borrar);
                   btnProxy(5,limpiar);
                   btnProxy(6,imprimir);
                   btnProxy(7,clave);
                   btnProxy(8,favoritos);
                   btnProxy(9,pais);
                   btnProxy(10,ayuda);
                   parent.parent.frames["iconos"].ocultarCapa();
        }
        parent.parent.frames["iconos"].setActive(true);
}
function btnProxy(ordinalBoton, estadoBoton){
        parent.parent.frames["iconos"].set_estado_botonera("btnBarra",ordinalBoton,convertEstado(estadoBoton));
}

function clickButton(number) {
        var imagenes = parent.parent.frames["iconos"].document.getElementsByTagName("IMG");
        for(var i=0; i< imagenes.length;i++){
                   var imagen = imagenes[i];
                   if (imagen.name && imagen.name.toUpperCase() == ("BTNBARRA"+number)) {
                       imagen.parentElement.click();
                               break;
                   }
        }
        return false;
}


