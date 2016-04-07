var filasKO = new Array();
         var varNoLimpiarSICC = true;
         var listadoVisible = false;
         
         function onLoadPag() {
         configurarMenuSecundario('frmFormulario');
             DrdEnsanchaConMargenDcho('listado1',12);
             
                  focaliza('frmFormulario.cbTipoSolicitud','');

                  document.all["capa2"].style.visibility='hidden';
             document.all["Cplistado1"].style.visibility='hidden';
             document.all["CpLin1listado1"].style.visibility='hidden';
             document.all["CpLin2listado1"].style.visibility='hidden';
             document.all["CpLin3listado1"].style.visibility='hidden';
             document.all["CpLin4listado1"].style.visibility='hidden';

             document.all["primera1Div"].style.visibility='hidden';
             document.all["ret1Div"].style.visibility='hidden';
             document.all["ava1Div"].style.visibility='hidden';
             document.all["separaDiv"].style.visibility='hidden';
             document.all["SeleccionarSolicitudDiv"].style.visibility='hidden';
                  // MODIFICACION -------------------------------
                  // Autor: Maximiliano Dello Russo (grusso).
                  // Motivo: Incidencia BELC300010043.  Se comenta la siguiente línea.
                  //
//                accion( 'frmFormulario.txtCodCliente', '.disabled=true' );
                  // FIN MODIFICACION ---------------------------
//                  accion( 'frmFormulario.txtReceptorFactura', '.disabled=true' );		
//                  accion( 'frmFormulario.txtPagadorFactura', '.disabled=true' );		

                  if (get('frmFormulario.accesoFisicoVD') != "")  {
                  var iSeleccionado = new Array(); 
                  iSeleccionado[0] = get('frmFormulario.accesoFisicoVD'); 
                  set('frmFormulario.cbAccesoFisico',iSeleccionado);                                  
                  }
                  if (get('frmFormulario.accesoFisicoHabilitado') == "N")
                           accion('frmFormulario.cbAccesoFisico', '.disabled=true');

                  if (get('frmFormulario.destinoHabilitado') == "N")
                           accion( 'frmFormulario.cbDestino', '.disabled=true' );
                           
                  if (get('frmFormulario.tipoDespachoVD') != "")  {
                  var iSeleccionado = new Array(); 
                  iSeleccionado[0] = get('frmFormulario.tipoDespachoVD'); 
                  set('frmFormulario.cbTipoDespacho',iSeleccionado);                                  
                  }
                  if (get('frmFormulario.tipoDespachoHabilitado') == "N")  {
                           accion( 'frmFormulario.cbTipoDespacho', '.disabled=true' );
                  }

         if (get('frmFormulario.accion') == '')  {
             if (get('frmFormulario.hOidTipoSolicitud') != '')  {
                  var iSeleccionado = new Array(); 
                  iSeleccionado[0] = get('frmFormulario.hOidTipoSolicitud'); 
                  set('frmFormulario.cbTipoSolicitud',iSeleccionado);
             }
             if (get('frmFormulario.hPeriodo') != '')  {
                  var iSeleccionado = new Array(); 
                  iSeleccionado[0] = get('frmFormulario.hPeriodo'); 
                  set('frmFormulario.cbPeriodo',iSeleccionado);
             }
         }
                  
        if (get('frmFormulario.hCanalAccesosErroneo') == 'S') {
            GestionarMensaje('1463');
            set('frmFormulario.cbTipoSolicitud','');
            focaliza('frmFormulario.cbTipoSolicitud');
        }
        
             eval (ON_RSZ);  
         }


    function accionBuscarCliente() {

         var oid;
         var obj = new Object();
         var whnd = mostrarModalSICC('LPBusquedaRapidaCliente','',obj);
         if(whnd==null){

         }else{

			 var oid = whnd[0];
             var cod = whnd[1];
             var nombre1 = whnd[2];
             var apellido1 = whnd[4];
             set("frmFormulario.txtCodCliente", cod);
             set("frmFormulario.hOidCliente", oid);
             set("frmFormulario.hOidReceptorFac", oid);
             set("frmFormulario.hOidPagadorFac", oid);
             txt_to("lbldtNombre",nombre1);
             txt_to("lbdtApellido1",apellido1);
             set("frmFormulario.txtReceptorFactura", cod);
             set("frmFormulario.txtPagadorFactura", cod);

             var arr = new Array();
             arr[arr.length] = new Array("oidPais", get('frmFormulario.hPais'));
             arr[arr.length] = new Array("oidIdioma", get('frmFormulario.hIdioma'));
             arr[arr.length] = new Array("oid", whnd[0]);

			 asignar([['COMBO','frmFormulario.cbTipoDocumento',
                                'ConectorDruidaTransactionQuery',
                                'dtoSalida.resultado_ROWSET',
                                 formarCadenaDT('MAEObtenerTiposDocumentoCliente', 
                                'es.indra.sicc.util.DTOOID', arr), 
								'cargarTipoDocumento(datos);']]);                            

			 asignar([['COMBO','frmFormulario.cbDestino',
                                'ConectorDruidaTransactionQuery',
                                'dtoSalida.resultado_ROWSET',
                                 formarCadenaDT('MAEObtenerTiposDireccionCliente', 
                                'es.indra.sicc.util.DTOOID', arr), 
								'recargarDestino2(datos);']]);                            
         }
    }


         function cargarTipoDocumento(datos){
			var  arr = new Array();
			arr[arr.length] = new Array([''],['']);

			for (var i=0 ;i< datos.length ; i++)  {
					arr[arr.length] = datos[i];
			}
			set_combo('frmFormulario.cbTipoDocumento',arr);

			var documLegal = datos[0,0]; 
			var iSeleccionado = new Array(); 
			iSeleccionado[0] = documLegal[0];
			set('frmFormulario.cbTipoDocumento',iSeleccionado);
	
			asignar([['LISTA','', 'ConectorDruidaTransactionQuery', 
								'dtoSalida.resultado_ROWSET', 
								formarCadenaDT('PEDObtenerTipoDocumentoLegal', 
																	'es.indra.sicc.util.DTOOID',
																	parametroTipoDL()),
		   'recargarDocumentoLegal(datos);']] );				

         }


         function recargarDestino(datos){
                  var  arr = new Array();

                   arr[arr.length] = new Array([''],['']);
                   for (var i=0 ;i< datos.length ; i++)  {
                            arr[arr.length] = datos[i];
                   }

                   set_combo('frmFormulario.cbDestino',arr);

                  if (get('frmFormulario.destinoVD') != "")  {
                            var iSeleccionado = new Array(); 
                            var oidDestino = get('frmFormulario.destinoVD');
                            iSeleccionado[0] = oidDestino;
                            set('frmFormulario.cbDestino',iSeleccionado);
                  }
         }

   function recargarDestino2(datos){
        var  arr = new Array();

        arr[arr.length] = new Array([''],['']);
        for (var i=0 ;i< datos.length ; i++)  {
            arr[arr.length] = datos[i];
        }

        set_combo('frmFormulario.cbDestino',arr);
        //alert("En recargar Destino 2... destinoVD es_" + get('frmFormulario.destinoVD'));

        if (get('frmFormulario.destinoVD') != "")  {
			var elemCbDestino       = document.getElementById("cbDestino");
			var opcionesCbDestino   = elemCbDestino.options;
            for (var i=0 ; i< opcionesCbDestino.length ; i++)  {
			    //alert("opcionDestino_"+i);
				if (get('frmFormulario.destinoVD') == opcionesCbDestino[i].text) {
                    //alert("El valor coincide... value es_" + opcionesCbDestino[i].value);
                    var iSeleccionado = new Array(); 
                    var oidDestino = opcionesCbDestino[i].value;
                    iSeleccionado[0] = oidDestino;
                    set('frmFormulario.cbDestino',iSeleccionado);
				}
            }
                            
        }
    }

    function accionBuscarReceptorFactura() {
         var cod;
         var obj = new Object();
         var whnd = mostrarModalSICC('LPBusquedaRapidaCliente','',obj);

		if(whnd==null){

         }else{
			oid = whnd[0];
            cod = whnd[1];
            set("frmFormulario.txtReceptorFactura", cod);
            set("frmFormulario.hOidReceptorFac", oid);
         }

		if ((get("frmFormulario.txtReceptorFactura")) != (get("frmFormulario.txtCodCliente")))  {
			GestionarMensaje('1346');
		}


    }

    function accionBuscarPagadorFactura(){
                  var oid;
         var cod;
         var obj = new Object();
         var whnd = mostrarModalSICC('LPBusquedaRapidaCliente','',obj);

         if(whnd==null){

         }else{
                           oid = whnd[0];
             cod = whnd[1];
             set("frmFormulario.txtPagadorFactura", cod);
             set("frmFormulario.hOidPagadorFac", oid);
         }
                  if ((get("frmFormulario.txtPagadorFactura")) != (get("frmFormulario.txtCodCliente")))  {
                           GestionarMensaje('1345');
                  }


    }

    function accionAceptar(){
         // Método que se ejecuta al pulsar sobre el botón btAceptar 
         //
         //accion = "Aceptar cabecera" 
         //
         // Envia el formulario oculto 
         //formulario.oculto = "S" 
         //enviaSICC(formulario)
                  var numeroCliente;
                  var validacionNumeroCliente = true;
                  
         if (sicc_validaciones_generales())  {
                           numeroCliente = get('frmFormulario.txtNumeroClientes');
                           if(numeroCliente != ''){
                                    if(fValidarNumero(numeroCliente, 200, 0, 9999)!='OK'){
                                             GestionarMensaje('405'); 
                                             focaliza('frmFormulario.txtNumeroClientes');
                                             validacionNumeroCliente = false;
                                    }
                           }
                           if (validacionNumeroCliente == true)  {
                                    cargarParametrosFormulario();
                                    set('frmFormulario.accion','Aceptar_cabecera');
                                    eval('frmFormulario').oculto = 'S';
                                    enviaSICC('frmFormulario');                          					
                           }			
         }
    }


    function validacionOK(parametros) {
			eval('frmFormulario').oculto = 'N';
			setearVariablesHidden(parametros);
			if (get('frmFormulario.hIndMasSolicitudes') == 'true')  {
				GestionarMensaje('1373');
			}
			document.all["capa2"].style.visibility='';

             document.all["Cplistado1"].style.visibility='';
             document.all["CpLin1listado1"].style.visibility='';
             document.all["CpLin2listado1"].style.visibility='';
             document.all["CpLin3listado1"].style.visibility='';
             document.all["CpLin4listado1"].style.visibility='';
             if (get('frmFormulario.hBotonSeleccionHabilitado') == 'SI')  {
                document.all["SeleccionarSolicitudDiv"].style.visibility='';
             }
             
             
			  btnProxy(1, '1');
			  listadoVisible = true;
			  txt_to("lbldtFechaPrevistaFacturacion",get('frmFormulario.hFechaPrevistaFact'));
    }

         function setearVariablesHidden(parametros){
                  var arr = parametros.split('|');
                  
                  if (arr[0] != 'null')  {
                           set('frmFormulario.hOidTipoSolicitud',arr[0]);
                  }
                  if (arr[1] != 'null')  {
                           set('frmFormulario.hOidTipoDespacho',arr[1]);
                  }
                  if (arr[2] != 'null')  {
                           set('frmFormulario.hMoneda',arr[2]);
                  }
                  if (arr[3] != 'null')  {
                           set('frmFormulario.hAlmacen',arr[3]);
                  }
                  if (arr[4] != 'null')  {
                           set('frmFormulario.hModulo',arr[4]);
                  }
                  if (arr[5] != 'null')  {
                           set('frmFormulario.hPeriodo',arr[5]);
                  }
                  if (arr[6] != 'null')  {
                           set('frmFormulario.hCodCliente',arr[6]);
                  }
                  if (arr[7] != 'null')  {
                           set('frmFormulario.hOidCliente',arr[7]);
                  }
                  if (arr[8] != 'null')  {
                           set('frmFormulario.hNumeroClientes',arr[8]);
                  }
                  if (arr[9] != 'null')  {
                           set('frmFormulario.hReceptorFac',arr[9]);
                  }
                  if (arr[10] != 'null')  {
                           set('frmFormulario.hOidReceptorFac',arr[10]);
                  }
                  if (arr[11] != 'null')  {
                           set('frmFormulario.hPagadorFac',arr[11]);
                  }
                  if (arr[12] != 'null')  {
                           set('frmFormulario.hOidPagadorFac',arr[12]);
                  }
                  if (arr[13] != 'null')  {
                           set('frmFormulario.hAccesoFisico',arr[13]);
                  }
                  if (arr[14] != 'null')  {
                           set('frmFormulario.hTipoDocumento',arr[14]);
                  }
                  if (arr[15] != 'null')  {
                           set('frmFormulario.hTipoDocumentoLegal',arr[15]);
                  }
                  if (arr[16] != 'null')  {
                           set('frmFormulario.hDestino',arr[16]);
                  }
                  if (arr[17] != 'null')  {
                           set('frmFormulario.hObservaciones',arr[17]);
                  }
                  if (arr[18] != 'null')  {
                           set('frmFormulario.hIndicadorDigitacion',arr[18]);
                  }
                  if (arr[19] != 'null')  {
                           set('frmFormulario.hMarca',arr[19]);
                  }
                  if (arr[20] != 'null')  {
                           set('frmFormulario.hCanal',arr[20]);
                  }
                  if (arr[21] != 'null')  {
                           set('frmFormulario.hAcceso',arr[21]);
                  }
                  if (arr[22] != 'null')  {
                           set('frmFormulario.hSubacceso',arr[22]);
                  }
                  if (arr[23] != 'null')  {
                           set('frmFormulario.hSociedad',arr[23]);
                  }
                  if (arr[24] != 'null')  {
                           set('frmFormulario.hFormaPago',arr[24]);
                  }
                  if (arr[25] != 'null')  {
                           set('frmFormulario.hEstado',arr[25]);
                  }
                  if (arr[26] != 'null')  {
                           set('frmFormulario.hSubgerencia',arr[26]);
                  }
                  if (arr[27] != 'null')  {
                           set('frmFormulario.hTerritorio',arr[27]);
                  }
                  if (arr[28] != 'null')  {
                           set('frmFormulario.hZona',arr[28]);
                  }
                  if (arr[29] != 'null')  {
                           set('frmFormulario.hNumeroSolicitud',arr[29]);
                  }
                  if (arr[30] != 'null')  {
                           set('frmFormulario.hUsuario',arr[30]);
                  }
                  if (arr[31] != 'null')  {
                           set('frmFormulario.hFecha',arr[31]);
                  }
                  if (arr[32] != 'null')  {
                           set('frmFormulario.hPermiteUnionSolicitudes',arr[32]);
                  }
                  if (arr[33] != 'null')  {
                           set('frmFormulario.hIndPedidoPrueba',arr[33]);
                  }
                  if (arr[34] != 'null')  {
                           set('frmFormulario.hIndTSNoConsolidado',arr[34]);
                  }
                  if (arr[35] != 'null')  {
                           set('frmFormulario.hUbigeo',arr[35]);
                  }
                  if (arr[36] != 'null')  {
                           set('frmFormulario.hSubtipoCliente',arr[36]);
                  }
                  if (arr[37] != 'null')  {
                           set('frmFormulario.hClaseSolicitud',arr[37]);
                  }
                  if (arr[38] != 'null')  {
                           set('frmFormulario.hOperacion',arr[38]);
                  }
                  if (arr[39] != 'null')  {
                           set('frmFormulario.hProceso',arr[39]);
                  }
                  if (arr[40] != 'null')  {
                           set('frmFormulario.hOrdenCompra',arr[40]);
                  }
                  if (arr[41] != 'null')  {
                           set('frmFormulario.hTipoConsolidado',arr[41]);
                  }
                  if (arr[42] != 'null')  {
                           set('frmFormulario.hRegion',arr[42]);
                  }
                  if (arr[43] != 'null')  {
                           set('frmFormulario.hSeccion',arr[43]);
                  }
                  if (arr[44] != 'null')  {
                           set('frmFormulario.hOK',arr[44]);
                  }
                  if (arr[45] != 'null')  {
                           set('frmFormulario.hMensajeError',arr[45]);
                  }
                  if (arr[46] != 'null')  {
                           set('frmFormulario.hIndMasSolicitudes',arr[46]);
                  }
                  if (arr[47] != 'null')  {
                           set('frmFormulario.hDestinatario',arr[47]);
                  }
                  if (arr[48] != 'null')  {
                           set('frmFormulario.hOidConcursoParametros',arr[48]);
                  }
                  if (arr[49] != 'null')  {
                           set('frmFormulario.hOidDocumentoReferencia',arr[49]);
                  }
                  if (arr[50] != 'null')  {
                           set('frmFormulario.hNumeroPremio',arr[50]);
                  }
                  if (arr[51] != 'null')  {
                           set('frmFormulario.hFechaPrevistaFact',arr[51]);
                  }
                  if (arr[52] != 'null')  {
                           set('frmFormulario.hTipoCliente',arr[52]);
                  }
                  if (arr[53] != 'null')  {
                           set('frmFormulario.hOidTerritorioAdministrativo',arr[53]);
                  }
				  if (arr[54] != 'null')  {
                              set('frmFormulario.hTipoCambio',arr[54]);
                    }


         }

    function validacionKO(codigo) {
         eval('frmFormulario').oculto = 'N';
                  GestionarMensaje(codigo);
    }

         function guardarOK(){
                  eval('frmFormulario').oculto = 'N';
                  set('frmFormulario.accion','Recargar_pagina');
                  enviaSICC('frmFormulario');                          
         }

         function guardarKO(datosKO){
         eval('frmFormulario').oculto = 'N';
                  var arr1 = new Array();
                  arr1 = datosKO.split('|');

                  limpiarMensajes();
                  for (var i=0; i<arr1.length; i++)  {
                           var arr2 = new Array();		
                           arr2 = arr1[i].split(',');
                           establecerMensajes(arr2);
                  }
                  btnProxy(1, '1');
         }

         function establecerMensajes(arr2){
         for (var i=0; i < listado1.datos.length; i++){
             if (listado1.datos[i][1] == arr2[0]){
                                    listado1.insertaDato(listado1.datos[i][0],2,arr2[1]);
                                    listado1.repinta();
                           }
                  }
         }

    function cargarParametrosFormulario(){
         set('frmFormulario.hOidTipoSolicitud', get('frmFormulario.cbTipoSolicitud'));
         set('frmFormulario.hOidTipoDespacho', get('frmFormulario.cbTipoDespacho'));
         set('frmFormulario.hPeriodo', get('frmFormulario.cbPeriodo'));
         set('frmFormulario.hCodCliente', get('frmFormulario.txtCodCliente'));
         set('frmFormulario.hNumeroClientes', get('frmFormulario.txtNumeroClientes'));
         set('frmFormulario.hReceptorFac', get('frmFormulario.txtReceptorFactura'));
         set('frmFormulario.hPagadorFac', get('frmFormulario.txtPagadorFactura'));
         set('frmFormulario.hAccesoFisico', get('frmFormulario.cbAccesoFisico'));
         set('frmFormulario.hTipoDocumento', get('frmFormulario.cbTipoDocumento'));
         set('frmFormulario.hFormaPago', get('frmFormulario.cbFormaPago'));
         set('frmFormulario.hDestino', get('frmFormulario.cbDestino'));
         set('frmFormulario.hObservacion', get('frmFormulario.areatxtObservaciones'));
    }

    function accionTipoSolicitudOnChange() {
         // Método llamado al seleccionar un valor en cbTipoSolicitud 
         //accion = "Cambiar tipo solicitud" 
         set('frmFormulario.hOidTipoSolicitud',get('frmFormulario.cbTipoSolicitud'));
         set('frmFormulario.accion','Cambiar_tipo_solicitud');
		 // dmorello, 11/04/2006   
		 eval('frmFormulario').oculto = 'N';
         enviaSICC('frmFormulario','','','N');        
    }

    function accionTipoDocumentoOnChange(){
                  if (get('frmFormulario.cbTipoDocumento') != '')  {
                           asignar([['LISTA','', 'ConectorDruidaTransactionQuery', 
                                                'dtoSalida.resultado_ROWSET', 
                                                formarCadenaDT('PEDObtenerTipoDocumentoLegal', 
                                                                                    'es.indra.sicc.util.DTOOID',
                                                                                    parametroTipoDL()),
                           'recargarDocumentoLegal(datos);']] );				
                  } else {
                           txt_to('lbldtTipoDocumentoLegal', '');
                           set('frmFormulario.hTipoDocumentoLegal', '');
                  }
         }

    function parametroTipoDL(){
         var arrParam = new Array();
         arrParam[arrParam.length] = [ "oid", get('frmFormulario.cbTipoDocumento')];
         arrParam[arrParam.length] = [ "oidIdioma", get('frmFormulario.hIdioma')];
         return arrParam;
    }

    function recargarDocumentoLegal(datos){
         txt_to('lbldtTipoDocumentoLegal', datos[0][1]);
         set('frmFormulario.hTipoDocumentoLegal', datos[0][0]);
    }


    function accionPeriodoOnChange(){
         if (GestionarMensaje('1339'))  {
             set('frmFormulario.accion','Cambiar_periodo');
             set('frmFormulario.hPeriodo', get('frmFormulario.cbPeriodo'));
                           eval('frmFormulario').oculto = 'S';
             enviaSICC('frmFormulario','','','N');        
         }else{
             var iSeleccionado = new Array(); 
             iSeleccionado[0] = get('frmFormulario.hPeriodo'); 
             set('frmFormulario.cbPeriodo',iSeleccionado);
         }
    }

    function fGuardar(){
         accionGuardar();
    }

    function accionGuardar(){
         // Método que se llama al pulsar sobre el botón Guardar del menú secundario 
         //
         //accion = "Guardar solicitud" 
         //
         // Envia el formulario oculto 
         //formulario.oculto = "S" 
         //enviaSICC(formulario) 
                  if (obtenerFilasListado() != false)  {
                           set('frmFormulario.accion','Guardar_solicitud');
                           eval('frmFormulario').oculto = 'S';
                           enviaSICC('frmFormulario','','','N');        		
                  }

    }

		function agregarFila(fila){

			if (event.keyCode==13){
				if (listado1.datos.length == (fila+1)){
					var arr = new Array(4);
					arr[0] = listado1.generaCodigo('');
					for (var j=1; j < arr.length; j++){
						arr[j] = "";
					}
					/*listado1.insertar((new Array(listado1.generaCodigo('')) ));*/
					listado1.insertar(arr);
					eval("listado1.preparaCamposDR()");
					focaliza('frmlistado1.Texto1_' + (fila+1),'');
				}
				event.returnValue = false;
				event.cancelBubble = true;
			} else if (event.keyCode==9) {
				if (event.shiftLeft == true)  {
					focaliza('frmlistado1.Texto1_' + (fila),'');
				}else if (listado1.datos.length == (fila+1))				
					focaliza('frmFormulario.cbTipoSolicitud','');
				else
					focaliza('frmlistado1.Texto1_' + (fila+1),'');
				event.returnValue = false;
				event.cancelBubble = true;
			}
			return true;             
		}

    function obtenerFilasListado(){
         var datosDetalle = '';
         listado1.actualizaDat();
                  var ok = false;

         for (var i=0; i < listado1.datos.length; i++)  {
                           if (listado1.datos[i][1] == '' && listado1.datos[i][2] != '')  {
                                    sicc_valida_requerido("Texto1",obtenerNombre('Texto1'));
                                    document.all['Texto1_' + i].focus();
                                    return false;
                           }
                           if (listado1.datos[i][2] == '' && listado1.datos[i][1] != '')  {
                                    sicc_valida_requerido("Texto2",obtenerNombre('Texto2'));
                                    document.all['Texto2_' + i].focus();
                                    return false;
                           }			
                           
                           if (listado1.datos[i][1] != '' && listado1.datos[i][2] != '')  {
                                    if (fValidarNumero(listado1.datos[i][2],200,-999999,9999999) != 'OK')  {
                                                      GestionarMensaje('405'); 		
                                                      document.all['Texto2_' + i].focus();
                                                      return false;
                                    }
                                    datosDetalle =  datosDetalle + listado1.datos[i][1] + ',';
                                    datosDetalle =  datosDetalle + listado1.datos[i][2] + '|';										
                                    ok = true;
                           }			
         }
         set('frmFormulario.strDatosDetalle', datosDetalle.substring(0,datosDetalle.length-1));
                  return ok;
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

    function fVolver(){
    }

    function fBorrar(){
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
		  set('frmFormulario.hOidTerritorioAdministrativo','');
	      set('frmFormulario.hTipoCambio','');
	 }

	 function limpiarMensajes(){
		  for (var i=0; i < listado1.datos.length; i++){
			   listado1.insertaDato(listado1.datos[i][0],2,'');
			   listado1.repinta();
		  }
	 }

    function ontab_Aceptar(){
                  if (listadoVisible == false)
                  focaliza('frmFormulario.cbTipoSolicitud','');
                  else
                           focaliza('frmlistado1.Texto1_0');
                           
    }

    function onshtab_TipoSolicitud(){
                  if (listadoVisible == false){
                           focalizaBotonHTML('botonContenido', 'btnAceptar');
                  } else {
                           var ultimaFila = listado1.datos.length - 1;
                           focaliza('frmlistado1.Texto2_' + ultimaFila);
                  }
                  
    }

	 function validarLongCodCliene(codCliente) {
		  var longiCod = get('frmFormulario.hLongitudCodCliente');
		  var faltantes = longiCod -  codCliente.length;
		  var resultCod = new String("");
		  if(faltantes > 0){
			   for(var t = 0 ; t<faltantes; t++){
						resultCod = resultCod + "0";
			   }
			   resultCod = resultCod + codCliente;
			   return resultCod;
		  }
		  return codCliente;

	 }

	 function onchange_codCliente(){
		  var codCliente = get('frmFormulario.txtCodCliente');
		  if (codCliente.length != 0)  {
			   codigoCompleto = validarLongCodCliene(codCliente);
			   set('frmFormulario.hIndicadorBusquedaCliente','C');
			   set('frmFormulario.txtCodCliente', codigoCompleto);
			   // MODIFICACION -------------------------------
			   // Autor: Maximiliano Dello Russo (grusso).
			   // Motivo: Incidencia BELC300010043.  Se agregan las siguientes líneas
			   //
			   set('frmFormulario.accion', 'Modificar cliente');
			   eval('frmFormulario').oculto = 'S';
			   enviaSICC('frmFormulario','','','N');
			   // FIN MODIFICACION ---------------------------
		  }
	 }
         
	 function onchange_receptorFactura(){
		  var codCliente = get('frmFormulario.txtReceptorFactura');
		  if (codCliente.length != 0)  {
			   codigoCompleto = validarLongCodCliene(codCliente);
			   set('frmFormulario.hIndicadorBusquedaCliente','R');
			   set('frmFormulario.txtReceptorFactura', codigoCompleto);
			   set('frmFormulario.accion', 'Modificar cliente');
			   eval('frmFormulario').oculto = 'S';
			   enviaSICC('frmFormulario','','','N');
		  }
	 }

	 function onchange_pagadorFactura(){
		  var codCliente = get('frmFormulario.txtPagadorFactura');
		  if (codCliente.length != 0)  {
			   codigoCompleto = validarLongCodCliene(codCliente);
			   set('frmFormulario.hIndicadorBusquedaCliente','P');
			   set('frmFormulario.txtPagadorFactura', codigoCompleto);
			   set('frmFormulario.accion', 'Modificar cliente');
			   eval('frmFormulario').oculto = 'S';
			   enviaSICC('frmFormulario','','','N');
		  }
	 }
         
	 // MODIFICACION -------------------------------
	 // Autor: Maximiliano Dello Russo (grusso).
	 // Motivo: Incidencia BELC300010043.  Se agregan las siguientes líneas
	 //		 
	 function asignarDatosCliente(oidCliente, nombreUsuario, apellidoUsuario, indicador){

		if (indicador == 'C')  {
			  eval('frmFormulario').oculto = 'N';
			  txt_to("lbldtTipoDocumentoLegal", '');				
			  set('frmFormulario.hTipoDocumentoLegal','');				  
			  if( oidCliente != '' ){
				   txt_to("lbldtNombre", nombreUsuario);
				   txt_to("lbdtApellido1", apellidoUsuario);
				   set('frmFormulario.hOidCliente', oidCliente);
				   codCliente = get('frmFormulario.txtCodCliente');
				   set('frmFormulario.txtReceptorFactura', codCliente);
				   set('frmFormulario.txtPagadorFactura', codCliente);
				   set('frmFormulario.hOidReceptorFac', oidCliente);
				   set('frmFormulario.hOidPagadorFac', oidCliente);		
				   recargarTipoDocumento();
				   CargarDestino();
			  }else{
					   GestionarMensaje("UIPED029", null, null, null);
			  }				
		} else if (indicador == 'P')  {
			  if( oidCliente != '' ){
					// dmorello, 12/04/2006: Se corrige oid por oidCliente
					set("frmFormulario.hOidPagadorFac", oidCliente);
					if ((get("frmFormulario.txtPagadorFactura")) != (get("frmFormulario.txtCodCliente")))
						GestionarMensaje('1345');
			  }else{
					   GestionarMensaje("UIPED029", null, null, null);
			  }				
			
		} else if (indicador == 'R')  {
			  if( oidCliente != '' ){
					set("frmFormulario.hOidReceptorFac", oidCliente);
					if ((get("frmFormulario.txtReceptorFactura")) != (get("frmFormulario.txtCodCliente")))
						GestionarMensaje('1346');
			  }else{
					   GestionarMensaje("UIPED029", null, null, null);
			  }				
		}

	 }

	 function recargarTipoDocumento(){
			  // Carga los tipos de documentos 
			  // Llamar al método recargaCombo utilizando unDTOOID y el idBusiness = "MAEObtenerTiposDocumentoCliente". 
			  // Parametros del DTOOID: 
			  // - oid: oid del cliente seleccionado en txtCliente 
			 var arr = new Array();
			 arr[arr.length] = new Array("oidPais", get('frmFormulario.hPais'));
			 arr[arr.length] = new Array("oidIdioma", get('frmFormulario.hIdioma'));
			 arr[arr.length] = new Array("oid", get('frmFormulario.hOidCliente'));
			 asignar([['COMBO','frmFormulario.cbTipoDocumento',
								'ConectorDruidaTransactionQuery',
								'dtoSalida.resultado_ROWSET',
								 formarCadenaDT('MAEObtenerTiposDocumentoCliente', 
								'es.indra.sicc.util.DTOOID', arr), 
								'cargarTipoDocumento(datos);']]);      
				
			  // Obtenemos un DTOSalida y cargamos el combo cbTipoDocumento 
	 }

	 function CargarDestino(){
			  // Carga los destinos 
			  // Llamar al método recargaCombo utilizando unDTOOID y el idBusiness = "MAEObtenerTiposDireccionCliente". 
			  // Parametros del DTOOID: 
			  // - oid: oid del cliente seleccionado en txtCliente 
			  var arr = new Array();
			  arr[arr.length] = new Array("oidPais", get('frmFormulario.hPais'));
			  arr[arr.length] = new Array("oidIdioma", get('frmFormulario.hIdioma'));
			  arr[arr.length] = new Array("oid", get('frmFormulario.hOidCliente'));

			  recargaCombo('frmFormulario.cbDestino','MAEObtenerTiposDireccionCliente',
										  'es.indra.sicc.util.DTOOID',arr, 'recargarDestino2(datos)'); 
			  // Obtenemos un DTOSalida y cargamos el combo cbDestino 
			  // Seleccionamos en cbDestino el valor correspondiente a valorDefectoDestino (Recibido desde la LP)
	 }

	 function errorClienteBusqueda(indicador){
		eval('frmFormulario').oculto = 'N';
		if (indicador == 'C')  {
			  set('frmFormulario.txtCodCliente', '');
			  set('frmFormulario.hOidCliente', '');	
			  set('frmFormulario.txtReceptorFactura', '');
			  set('frmFormulario.hOidReceptorFac', '');	
			  set('frmFormulario.txtPagadorFactura', '');
			  set('frmFormulario.hOidPagadorFac', '');			
			  txt_to("lbldtNombre", '');
			  txt_to("lbdtApellido1", '');
			  txt_to("lbldtTipoDocumentoLegal", '');
			  set('frmFormulario.hTipoDocumentoLegal','');				  
			  set_combo('frmFormulario.cbTipoDocumento', [[''],['']]);
			  set_combo('frmFormulario.cbDestino', [[''],['']]);
			  focaliza('frmFormulario.txtCodCliente');				
		} else if (indicador == 'P') {
			  set('frmFormulario.txtPagadorFactura', '');
			  set('frmFormulario.hOidPagadorFac', '');			
			  focaliza('frmFormulario.txtPagadorFactura');
		} else if (indicador == 'R') {
			  set('frmFormulario.txtReceptorFactura', '');
			  set('frmFormulario.hOidReceptorFac', '');	
			  focaliza('frmFormulario.txtReceptorFactura');			  
		}
	 }
         
         // FIN MODIFICACION ---------------------------

    function accionSeleccionarSolicitud(){
          if (obtenerFilasListado2() != false)  {
                   set('frmFormulario.accion','Guardar_solicitud');
                   set('frmFormulario.verificacion', 'SI');
		 
                   eval('frmFormulario').oculto = 'S';
                   enviaSICC('frmFormulario','','','N');        		
          }
    
    }


    function obtenerFilasListado2(){
         var datosDetalle = '';
         listado1.actualizaDat();
         var ok = false;

         for (var i=0; i < listado1.datos.length; i++)  {
                           if (listado1.datos[i][1] == '' && listado1.datos[i][2] != '')  {
                                    sicc_valida_requerido("Texto1",obtenerNombre('Texto1'));
                                    document.all['Texto1_' + i].focus();
                                    return false;
                           }
                           if (listado1.datos[i][2] == '' && listado1.datos[i][1] != '')  {
                                    sicc_valida_requerido("Texto2",obtenerNombre('Texto2'));
                                    document.all['Texto2_' + i].focus();
                                    return false;
                           }			
                           
                           if (listado1.datos[i][1] != '' && listado1.datos[i][2] != '')  {
                                    if (fValidarNumero(listado1.datos[i][2],200,-999999,9999999) != 'OK')  {
                                                      GestionarMensaje('405'); 		
                                                      document.all['Texto2_' + i].focus();
                                                      return false;
                                    }
                                    datosDetalle =  datosDetalle + listado1.datos[i][1] + '|';
                                    datosDetalle =  datosDetalle + listado1.datos[i][2] + '#';										
                                    ok = true;
                           }			
         }
         set('frmFormulario.hPosicionesDigitacion', datosDetalle.substring(0,datosDetalle.length-1));
         return ok;
    }
	
    function validacionKOMensaje(codigo, arg1) {
         eval('frmFormulario').oculto = 'N';
         GestionarMensaje(codigo, arg1);
    }
	