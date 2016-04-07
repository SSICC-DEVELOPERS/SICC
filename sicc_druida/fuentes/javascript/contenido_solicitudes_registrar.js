 var componenteAFocalizar = '';


function onLoadPag() {
		try{
			configurarMenuSecundario("frmFormulario");
		}catch(e){
			   ;
		}
		accion("frmFormulario.cbPeriodo", ".disabled=false");

    fMostrarMensajeError();
		DrdEnsanchaConMargenDcho('listado1',12);
	    document.all["Cplistado1"].style.visibility='';
	    document.all["CpLin1listado1"].style.visibility='';
	    document.all["CpLin2listado1"].style.visibility='';
	    document.all["CpLin3listado1"].style.visibility='';
	    document.all["CpLin4listado1"].style.visibility='';

	    document.all["primera1Div"].style.visibility='hidden';
	    document.all["ret1Div"].style.visibility='hidden';
	    document.all["ava1Div"].style.visibility='hidden';
	    document.all["separaDiv"].style.visibility='hidden';
	    eval (ON_RSZ);  
      
		posicionarCombos();

		var habilita =  get('frmFormulario.hLecturaClientes');
		if (habilita == 'S') {
			// Habilita la lista lstClientes y coloca el foco en la celda de la primera fila. 
			if(listado1.datos.length > 0 ){
					eval("listado1.preparaCamposDR()");
					focaliza('frmlistado1.Texto1_0','');
			}
			// Habilita el botón Guardar del menú secundario
			btnProxy(1, '1');   
		} else {
			deshabilitaListaClientes();
		}
    
    
	}


	function folcalizaListaEditableShTab() {
	     //  focalizaLista( 0, 'listado1', 'Texto1')	;
			if(listado1.datos.length > 0 ){
				 eval("listado1.preparaCamposDR()");
				 focaliza('frmlistado1.Texto1_' + (listado1.datos.length -1),'');
			}else{
				 focaliza('frmFormulario.cbPeriodo','');
			}
		 
	}

	function comboPeriodoOnTab() {
		if(listado1.datos.length > 0 ){
			 eval("listado1.preparaCamposDR()");
			 focaliza('frmlistado1.Texto1_' + 0,'');
		}else{
			 focaliza('frmFormulario.cbTipoSolicitud','');
		}
	}


	function deshabilitaListaClientes() {
			// Deshabilita la lista lstClientes y no habilito en boton guardar
			eval("listado1.preparaCamposDR()");
			var dehabilitado = "S";
			listado1.tiposCol[1][8] = dehabilitado;
			listado1.actualizaDat();
			listado1.repintaDat();
			focaliza('frmFormulario.cbTipoSolicitud','');
	}

   
	function obtenerNombre(campo){
			  var largo = objValidacionSICC.length;
			  for(var i = 0; i<largo;i++){
					   obj = objValidacionSICC[i];
					   if (campo == obj.nombre)  {
								return obj.mostrar;		
					   }
			  }
	}
    
    
	function obtenerFilasListado(){
         var datosDetalle = '';
         listado1.actualizaDat();
         var ok = false;
         for (var i=0; i < listado1.datos.length; i++)  {
               datosDetalle =  datosDetalle + listado1.datos[i][1] + '|';
               ok = true;                          			
         }
        
        set('frmFormulario.strDatosDetalle', datosDetalle.substring(0,datosDetalle.length-1));
        return ok;
    }
    

	function fLimpiar(){

				  limpiarHiddens();
				  set('frmFormulario.accion','');
				  enviaSICC('frmFormulario','','','N');        		                           

	}



	function limpiarHiddens(){
		  set('frmFormulario.accesoFisicoVD','');
		  set('frmFormulario.accesoFisicoHabilitado','');
		  set('frmFormulario.destinoVD','');
		  set('frmFormulario.destinoHabilitado','');
		  set('frmFormulario.tipoDespachoVD','');
		  set('frmFormulario.tipoDespachoHabilitado','');
		  set('frmFormulario.tipoDespachoObligatorioVD','');
		  set('frmFormulario.hOidTipoSolicitud','');
		  set('frmFormulario.hOidTipoDespacho','');
		  set('frmFormulario.hPeriodo','');
		  set('frmFormulario.hCodCliente','');
		  set('frmFormulario.hOidCliente','');
		  set('frmFormulario.hNumeroClientes','');
		  set('frmFormulario.hReceptorFac','');
		  set('frmFormulario.hOidReceptorFac','');
		  set('frmFormulario.hPagadorFac','');
		  set('frmFormulario.hOidPagadorFac','');
		  set('frmFormulario.hAccesoFisico','');
		  set('frmFormulario.hTipoDocumento','');
		  set('frmFormulario.hTipoDocumentoLegal','');
		  set('frmFormulario.hFormaPago','');
		  set('frmFormulario.hDestino','');
		  set('frmFormulario.hObservacion','');
		  set('frmFormulario.hIndicadorDigitacion','');
		  set('frmFormulario.strDatosDetalle','');
		  set('frmFormulario.hMarca','');
		  set('frmFormulario.hCanal','');
		  set('frmFormulario.hSubacceso','');
		  set('frmFormulario.hAcceso','');
		  set('frmFormulario.hFechaPrevistaFact','');
		  set('frmFormulario.hMoneda','');
		  set('frmFormulario.hAlmacen','');
		  set('frmFormulario.hModulo','');
		  set('frmFormulario.hTipoCliente','');
		  set('frmFormulario.hSociedad','');
		  set('frmFormulario.hTerritorio','');
		  set('frmFormulario.hZona','');
		  set('frmFormulario.hUsuario','');
		  set('frmFormulario.hNumeroSolicitud','');
		  set('frmFormulario.hFecha','');
		  set('frmFormulario.hPermiteUnionSol','');
		  set('frmFormulario.hIndPedidoPrueba','');
		  set('frmFormulario.hIndTSNoConsolidado','');
		  set('frmFormulario.hUbigeo','');
		  set('frmFormulario.hEstado','');
		  set('frmFormulario.hSubtipoCliente','');
		  set('frmFormulario.hClaseSolicitud','');
		  set('frmFormulario.hOperacion','');
		  set('frmFormulario.hProceso','');
		  set('frmFormulario.hOrdenCompra','');
		  set('frmFormulario.hTipoConsolidado','');
		  set('frmFormulario.hSubgerencia','');
		  set('frmFormulario.hRegion','');
		  set('frmFormulario.hSeccion','');
		  set('frmFormulario.hMonofacturacion','');
		  set('frmFormulario.hOK','');
		  set('frmFormulario.hMensajeError','');
		  set('frmFormulario.hIndMasSolicitudes','');
		  set('frmFormulario.hDestinatario','');
		  set('frmFormulario.hOidConcursoParametros','');
		  set('frmFormulario.hOidDocumentoReferencia','');
		  set('frmFormulario.hNumeroPremio','');
		  set('frmFormulario.hPermiteUnionSolicitudes','');
		  set('frmFormulario.hLongitudCodCliente','');
		  set('frmFormulario.lote','');
		  set('frmFormulario.numeroSolicitudes','');
		  set('frmFormulario.oidLote','');
		  set('frmFormulario.hNumeroClientes','');
		  set('frmFormulario.numeroSolicitudesRegistradas','');
		  set('frmFormulario.hLecturaClientes:','');
     
	}
  
  
  
	function accionTipoSolicitudOnChange() {
		// Método llamado al seleccionar un valor en cbTipoSolicitud 
		//accion = "Cambiar tipo solicitud" 
		var tipoSolicitud = get('frmFormulario.cbTipoSolicitud');
		if (tipoSolicitud != '') {

			accion("frmFormulario.cbPeriodo", ".disabled=true");
			set('frmFormulario.hOidTipoSolicitud', tipoSolicitud);
			set('frmFormulario.accion', 'Cambiar_tipo_solicitud');
			eval('frmFormulario').oculto = 'N';
			enviaSICC('frmFormulario','','','N');   
			
		}else{
		    set("frmFormulario.cbPeriodo", "");
			 deshabilitaListaClientes();
		}
    
    }
    
    
    function accionPeriodoOnChange() {
		// Método llamado al seleccionar un valor en cbPeriodo 
		var periodo = get('frmFormulario.cbPeriodo');
		if (periodo != '') {
			set('frmFormulario.hPeriodo', periodo);
			set('frmFormulario.accion','Cambiar_periodo');
			eval('frmFormulario').oculto = 'S';
			enviaSICC('frmFormulario','','','N');      
	    }else{
			 deshabilitaListaClientes();
		}
		
    }

	 function iniciarLote2() {
	 	  set('frmFormulario.lblNumeroSolicitudesRegistradasXX','0');
		  set('frmFormulario.numeroSolicitudesRegistradas','0');
		  set('frmFormulario.oidLote','');

	 }

	/**
	*
	*/
    function fGuardar(){
		accionGuardar();
	}


	/**
	*
	*/
    function accionGuardar(){
		// validamos campos requeridos
		if( ! sicc_validaciones_generales('grupoGrabar') ) {
			return false;
		}		

		if (obtenerFilasListado() != false) {
			set('frmFormulario.accion','Grabar_lote');
			set('frmFormulario.oidLote',get('frmFormulario.oidLote')); 
			var numeroSolicitudesRegistradas = get('frmFormulario.numeroSolicitudesRegistradas');
			set('frmFormulario.numeroSolicitudesRegistradas', parseInt(listado1.datos.length,10) + parseInt(numeroSolicitudesRegistradas,10)); 
			eval('frmFormulario').oculto = 'S';
			enviaSICC('frmFormulario','','','N');        
		}
	}


	/**
	* Se valida que el el número de clientes introducidos (número de filas) == Número de solicitudes por lote.
	*/
    function validarLote(){
        // Si el número de clientes introducidos (número de filas) == Número de solicitudes por lote (txtNumeroSolicitudesLote) 
    
    
		if ((listado1.datos.length) - 1 == get('frmFormulario.numeroSolicitudes')) {
    
			 if (obtenerFilasListado() != false){     
					set('frmFormulario.accion','Grabar_lote');
					eval('frmFormulario').oculto = 'S';
					enviaSICC('frmFormulario','','','N');
			 }
		}
    }


	/**
	* Luego de guardar de manera correcta, limpia la lista lstClientes.
	*/
	function guardarOK(numeroSol, lote) {

        var vLote = ''
        eval('frmFormulario').oculto = 'N';
        txt_to("lblNumeroSolicitudesRegistradasXX",numeroSol);
        if (lote != null)
            vLote = lote;
    
        set('frmFormulario.oidLote',vLote);
        //set('frmFormulario.lote',vLote);
        set('frmFormulario.numeroSolicitudesRegistradas',numeroSol);
        
		limpiarListaClientes();
		// Habilita el botón Guardar del menú secundario
		btnProxy(1, '1');   
	}


function limpiarListaClientes() {

				  listado1.setDatos (new Array());
 			          //listado1.insertar( (new Array(listado1.generaCodigo('')) ));
                //Incidencia DBLG500001183 pzerbino 10/8/2006                
                listado1.insertar( (new Array(listado1.generaCodigo(''),'','','') ));

}

	/**
	* Muestra los mensages de validacion en la segunda columna de la lista para cada cliente.
	*/
	function guardarKO(datosKO){

		eval('frmFormulario').oculto = 'N';
		var arr1 = new Array();
		arr1 = datosKO.split('|');

		limpiarMensajesValidacion();
		establecerMensajes(arr1);
	}


	/**
	* Arma la lista de mensages de validacion.
	*/
	function establecerMensajes(arrMensages) {
		var indexValidacion = 2;   
		//tomamos la lista actual del rowset   
		var listaClientes = listado1.datos;    
		//realizamos la tranformaion   
		for (var i=0; i < listaClientes.length; i++){
			//agergamos el mensage de valiacion
			if (arrMensages[i] != null){
        listaClientes[i][indexValidacion] = arrMensages[i];       
      }else{
        listaClientes[i][indexValidacion] = "";       
      }
		listado1.repinta();
  	}
  }  
	
    
	/**
	*
	*/
	function cambioPeriodo(){
          txt_to("lblLoteXX",get('frmFormulario.lote'));
          txt_to("lbNumeroSolicitudes",get('frmFormulario.numeroSolicitudes'));
    }

	
	/*
	* Al pulsar la tecla Enter (o al pasar un código de barras por el lector), se debe ejecutar este método 
	* Comprobamos en primer lugar que estamos introduciendo clientes. La lista lstClientes debe estar habilitada. 
	* Llamar al método validarLote()
	*/
	function accionEnter(fila) {   

		agregarFila(fila);

	}


	function agregarFila(fila) {
	  
         if (event.keyCode==13){
             if (listado1.datos.length == (fila+1)){
				  //rellenamos con ceros el codigo de cliente
				  rellenarClienteCeros(fila);
				  //vconte : se inserta una nueva fila vacia (antes aparecia undefined)
                  listado1.insertar( (new Array(listado1.generaCodigo(''),'','') ));
                  eval("listado1.preparaCamposDR()");
                  focaliza('frmlistado1.Texto1_' + (fila+1),'');
             }
             event.returnValue = false;
             event.cancelBubble = true;
             validarLote();
         } else if (event.keyCode==9) {
			 			   eval("listado1.preparaCamposDR()");
                           if (event.shiftKey )  {
							        if (fila > 0) {
										
										  rellenarClienteCeros(fila);
										 focaliza('frmlistado1.Texto1_' + (fila -1),'');   

							        }else{
										document.selection.empty();			
										focaliza('frmFormulario.cbPeriodo','');
										
									}
                           }else if (listado1.datos.length == (fila+1))	{	
							   	document.selection.empty();
							    focaliza('frmFormulario.cbTipoSolicitud','');
                             
                           } else {

							   rellenarClienteCeros(fila);
							   focaliza('frmlistado1.Texto1_' + (fila+1),'');

						   }
                                    
             event.returnValue = false;
             event.cancelBubble = true;
         }		   
         return true;             
    }

	 //Incidencia DBLG500001180

	  function rellenarClienteCeros(fila){

		  var codCliente = 	get('frmlistado1.Texto1_' + (fila));
		  var cantCeros = codCliente.length	;
		 
		  var codigos=  listado1.codigos();
		  var longitud = Number(get('frmFormulario.hLongitudCodCliente'));
		  listado1.insertaDato(codigos[fila], 0, rellenaCeros(codCliente,longitud,cantCeros));
   
	}



	/**
	* Limpia la lista de clientes.
	*/
	function limpiarListaClientes1() {
		var indexCliente = 1;   
		var indexValidacion = 2;   
		//tomamos la lista actual del rowset   
		var listaClientes = listado1.datos;    
		//realizamos la tranformaion   
		for (var i=0; i < listaClientes.length; i++){
			listaClientes[i][indexCliente] = "";   
			listaClientes[i][indexValidacion] = "";   
		}
		listado1.repinta();
		//focalizo en el primer campo de la lista
		 if (listado1.datos.length > 0) {
		   		eval("listado1.preparaCamposDR()");
				focaliza('frmlistado1.Texto1_0','');  
		 }

	}

	
	/**
	* Limpia la columna de validacion de la lista de clientes.
	*/
	function limpiarMensajesValidacion(){
		var indexValidacion = 2;   
		//tomamos la lista actual del rowset   
		var listaClientes = listado1.datos;    
		//realizamos la tranformaion   
		for (var i=0; i < listaClientes.length; i++){
			//limpia el el mensage de validacion
			listaClientes[i][indexValidacion] = "";   
		}
		listado1.repinta();
	}
  
  
	//Posicina los combos tipoSolicitud y periodos segun el seleccionado
	function posicionarCombos() { 
		//combo tipoSolicitud
		var iSeleccionadoTipoSol = new Array(); 
		iSeleccionadoTipoSol[0] = get('frmFormulario.hOidTipoSolicitud'); 
		set('frmFormulario.cbTipoSolicitud',iSeleccionadoTipoSol); 

		//combo periodos
		var iSeleccionadoPeriodo = new Array(); 
		iSeleccionadoPeriodo[0] = get('frmFormulario.hPeriodo'); 
		set('frmFormulario.cbPeriodo',iSeleccionadoPeriodo); 
	} 
