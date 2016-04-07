var varNoLimpiarSICC = true;
 // -------------------------------------------------------------------------------------------------------------------------------------
function onLoadPag() {
	   //eval (ON_RSZ); 
	   setTimeout('eval (ON_RSZ)',200);
	   configurarMenuSecundario("frmUnico");
	   fMostrarMensajeError();
       muestraSeleccionAnterior();
	   //Cleal MAE-03
	   var geoRef = get("frmUnico.geoReferenciador");

	   if (geoRef != "N"){
			document.all["capaTextNombreVia"].style.visibility = 'visible';
			document.all["capaLblNombreVia"].style.visibility = 'visible';
            document.all["capaCbVia"].style.visibility = 'hidden';
            document.all["capaLblVia"].style.visibility = 'hidden';
	   } else{
			document.all["capaTextNombreVia"].style.visibility = 'hidden';
			document.all["capaLblNombreVia"].style.visibility = 'hidden';
            document.all["capaCbVia"].style.visibility = 'visible';
            document.all["capaLblVia"].style.visibility = 'visible';
	   }

   	   cargaComboDias();
       cargarComboIntervalo();
  	   focaliza("frmUnico.cbTipoDireccion", "");

	  if (window.dialogArguments) { // Si es modal (se abrió mediante showModalDialog) DBLG500000915
        btnProxy(2,1);  // boton 'volver', habilitado
        btnProxy(3,0);  // boton 'Ir a pantalla de inicio', deshabilitado
     }
}

// -------------------------------------------------------------------------------------------------------------------------------------
	function fVolver(){     
					  window.close();
	}

/* -------------------------------------------------------------------------------------------------------------------------------------------- */

 
 function siguientePestanya(pestanya){
      
      set('frmUnico.conectorAction', 'LPBusquedaCliente');
      
		if (pestanya == -1){
		  set('frmUnico.accion', "");
        }else if (pestanya == 0){
	      set('frmUnico.accion', "siguienteTipoSubtipo");
        }else 	  if (pestanya == 1){   
		  set('frmUnico.accion', 'siguientePestanya1');
      }else if (pestanya == 2){
          set('frmUnico.accion', 'siguientePestanya2');
        }else 	if(pestanya == 4){   
		  set('frmUnico.accion', 'siguientePestanya4');
		}

		var formatoValido = validarFormato();
		if (formatoValido != false){
		   seteaHiddens("frmUnico");
		   enviaSICC("frmUnico");
		}

   }

 // -------------------------------------------------------------------------------------------------------------------------------------
	function muestraSeleccionAnterior()
	{
		//alert("Muestra Seleccion Anterior");
		var cbTipoDireccion = get("frmUnico.hidcbTipoDireccion");		
		//alert("cbTipoDireccion: " + cbTipoDireccion);
		var cbTipoVia = get("frmUnico.hidcbTipoVia");
		var textNombreVia = get("frmUnico.hidtextNombreVia");
		var textNPrincipal = get("frmUnico.hidtextNPrincipal");
		var textCodPostal = get("frmUnico.hidtextCodPostal");
/*		var textInterior = get("frmUnico.hidtextInterior");			
		var textManzana = get("frmUnico.hidtextManzana");			
		var textLote = get("frmUnico.hidtextLote");			
		var textKm = get("frmUnico.hidtextKm");			*/
		var rbDireccionPrincipal = get("frmUnico.hidrbDireccionPrincipal");			
		var textObservaciones = get("frmUnico.hidtextObservaciones");			
		var cbTipoComunicacion = get("frmUnico.hidcbTipoComunicacion");			
		var cbDiaComunicacion = get("frmUnico.hidcbDiaComunicacion");			
		var rbComunicacionPrincipal = get("frmUnico.hidrbComunicacionPrincipal");			
		var textHoraDesde = get("frmUnico.hidtextHoraDesde");			
		var textHoraHasta = get("frmUnico.hidtextHoraHasta");			
		var cbIntervalorComunicacion = get("frmUnico.hidcbIntervaloComunicacion");			
		var textTextoComunicacion = get("frmUnico.hidtextTextoComunicacion");			
		var cbMarca = get("frmUnico.hidcbMarca");	
		var cbVia = get("frmUnico.hidcbVia");

		set("frmUnico.cbTipoDireccion", new Array(cbTipoDireccion) );		
		set("frmUnico.cbTipoVia", new Array(cbTipoVia) );
		set("frmUnico.textNombreVia", textNombreVia);
		set("frmUnico.textNPrincipal", textNPrincipal);
		set("frmUnico.textCodPostal", textCodPostal );
/*		set("frmUnico.textInterior", textInterior );			
		set("frmUnico.textManzana", textManzana );			
		set("frmUnico.textLote", textLote );			
		set("frmUnico.textKm", textKm );			*/
		set("frmUnico.rbDireccionPrincipal", rbDireccionPrincipal );			
		set("frmUnico.textObservaciones", textObservaciones );			
		set("frmUnico.cbTipoComunicacion", new Array(cbTipoComunicacion) );			
		set("frmUnico.cbDiaComunicacion", new Array(cbDiaComunicacion) );			
		set("frmUnico.rbComunicacionPrincipal", rbComunicacionPrincipal );			
		set("frmUnico.textHoraDesde", textHoraDesde );			
		set("frmUnico.textHoraHasta", textHoraHasta );			
		set("frmUnico.cbIntervaloComunicacion", new Array(cbIntervaloComunicacion) );			
		set("frmUnico.textTextoComunicacion", textTextoComunicacion );			
		set("frmUnico.cbMarca", new Array(cbMarca) );			
		set("frmUnico.cbVia", new Array(cbVia) );

	}

 // -------------------------------------------------------------------------------------------------------------------------------------
	function seteaHiddens(formName){
		var cbVia = get("frmUnico.cbVia");
		var TextCbVia = "";
		if (cbVia != ""){
				var indice = getIndiceSeleccionado( cbVia );
				if (indice != -1)
					TextCbVia = combo_get("frmUnico.cbVia", "T", indice);
		}

		set(formName + ".hibTextCbVia", TextCbVia);
		var cbTipoDireccion = get("frmUnico.cbTipoDireccion");
		//alert("cbTipoDireccion: " + cbTipoDireccion);
		var cbTipoVia = get("frmUnico.cbTipoVia");
		//alert("cbTipoVia: " + cbTipoVia);
		var textNombreVia = get("frmUnico.textNombreVia");
		var textNPrincipal = get("frmUnico.textNPrincipal");
		var textCodPostal = get("frmUnico.textCodPostal");
/*		var textInterior = get("frmUnico.textInterior");
		var textManzana = get("frmUnico.textManzana");
		var textLote = get("frmUnico.textLote");
		var textKm = get("frmUnico.textKm");*/
		var rbDireccionPrincipal = get("frmUnico.rbDireccionPrincipal");
		var textObservaciones = get("frmUnico.textObservaciones");
		var cbTipoComunicacion = get("frmUnico.cbTipoComunicacion");
		var cbDiaComunicacion = get("frmUnico.cbDiaComunicacion");
		var rbComunicacionPrincipal = get("frmUnico.rbComunicacionPrincipal");
		var textHoraDesde = get("frmUnico.textHoraDesde");
		var textHoraHasta = get("frmUnico.textHoraHasta");
		var cbIntervaloComunicacion = get("frmUnico.cbIntervaloComunicacion");
		var textTextoComunicacion = get("frmUnico.textTextoComunicacion");
		var cbMarca = get("frmUnico.cbMarca");


		set(formName + ".hidcbTipoDireccion", cbTipoDireccion );		
		set(formName + ".hidcbTipoVia", cbTipoVia );
		set(formName + ".hidtextNombreVia", textNombreVia);
		set(formName + ".hidtextNPrincipal", textNPrincipal);
		set(formName + ".hidtextCodPostal", textCodPostal );
/*		set(formName + ".hidtextInterior", textInterior );			
		set(formName + ".hidtextManzana", textManzana );			
		set(formName + ".hidtextLote", textLote );			
		set(formName + ".hidtextKm", textKm );			*/
		set(formName + ".hidrbDireccionPrincipal", rbDireccionPrincipal );			
		set(formName + ".hidtextObservaciones", textObservaciones );			
		set(formName + ".hidcbTipoComunicacion", cbTipoComunicacion );			
		set(formName + ".hidcbDiaComunicacion", cbDiaComunicacion );			
		set(formName + ".hidrbComunicacionPrincipal", rbComunicacionPrincipal );			
		set(formName + ".hidtextHoraDesde", textHoraDesde );			
		set(formName + ".hidtextHoraHasta", textHoraHasta );			
		set(formName + ".hidcbIntervaloComunicacion", cbIntervaloComunicacion );			
		set(formName + ".hidtextTextoComunicacion", textTextoComunicacion );			
		set(formName + ".hidcbMarca", cbMarca );			
		set(formName + ".hidcbVia", cbVia);

	}

 // -------------------------------------------------------------------------------------------------------------------------------------
  function cargarComboIntervalo(){
     
     opciones = new Array(); 
     opciones[0]=["",""];
     opciones[1]=['false',GestionarMensaje('1503')];
     opciones[2]=['true',GestionarMensaje('1504')];
     
     set_combo('frmUnico.cbIntervaloComunicacion', opciones);
  }

 // -------------------------------------------------------------------------------------------------------------------------------------
	function cargaComboDias()	{
			var dias = new Array();
			var iniciales =  new Array();

			iniciales[0] = "D";
			iniciales[1] = "L";
			iniciales[2] = "M";
			iniciales[3] = "I";
			iniciales[4] = "J";
			iniciales[5] = "V";
			iniciales[6] = "S";


			for ( var i = 0; i < 7; i++){
				var codigo = 1034 + i;
				combo_add("frmUnico.cbDiaComunicacion",  iniciales[i], GestionarMensaje( codigo, null, null, null) );
			}

	}

 // -------------------------------------------------------------------------------------------------------------------------------------
	function buscar(){
			duplicaFormulario();
			set("frmUnicoBusq.conectorAction", "LPBusquedaCliente");
			set("frmUnicoBusq.accion", "buscar");
			var formatoValido = validarFormato();
			if (formatoValido != false){

					seteaHiddens("frmUnicoBusq");
					seteaHiddens("frmUnico");
   				enviaSICC("frmUnicoBusq");
			}

	}

 // -------------------------------------------------------------------------------------------------------------------------------------
	function  chequeaErrores(){
		var errCod = get("frmUnico.errCodigo");

		if (errCod != null){
				fMostrarMensajeError();
				return true;
		}

		return false;

	}

 // -------------------------------------------------------------------------------------------------------------------------------------
	
	function fLimpiar()
	{
		var arrayVacio = new Array("","");
		set("frmUnico.cbTipoDireccion", new Array() );		
		set("frmUnico.cbTipoVia", new Array() );
		set("frmUnico.textNombreVia", "");
		set("frmUnico.textNPrincipal", "");
		set("frmUnico.textCodPostal", "");
/*		set("frmUnico.textInterior", "");			
		set("frmUnico.textManzana", "");			
		set("frmUnico.textLote", "");			
		set("frmUnico.textKm", "");			*/
		set("frmUnico.rbDireccionPrincipal", "" );			
		set("frmUnico.textObservaciones", "");			
		set("frmUnico.cbTipoComunicacion", new Array() );			
		set("frmUnico.cbDiaComunicacion", new Array() );			
		set("frmUnico.rbComunicacionPrincipal", "");			
		set("frmUnico.textHoraDesde", "");			
		set("frmUnico.textHoraHasta", "");			
		set("frmUnico.cbIntervaloComunicacion", new Array("") );			
		set("frmUnico.textTextoComunicacion", "");			
		set("frmUnico.cbMarca", new Array() );			
		set_combo("frmUnico.cbVia", arrayVacio );

		focaliza("frmUnico.cbTipoDireccion", "");
	}

 // -------------------------------------------------------------------------------------------------------------------------------------
	function validarFormato()
	{
			var valido = true;
			var permitidos = "0123456789";
			var txtNroPrincipal = get("frmUnico.textNPrincipal");
/*			var txtInterior = get("frmUnico.textInterior");
			var txtManzana = get("frmUnico.textManzana");
			var txtLote = get("frmUnico.textLote");
			var txtKM = get("frmUnico.textKm");*/
			var txtHoraDesde = get("frmUnico.textHoraDesde");
			var txtHoraHasta = get("frmUnico.textHoraHasta");

			// Valida que Nro Principal sea numerico
			if (txtNroPrincipal != ""){
				valido = validar(txtNroPrincipal, permitidos);
				if (valido == false){
					focaliza("frmUnico.textNPrincipal");
					GestionarMensaje("1514", GestionarMensaje("1518", null, null, null), null, null);
					return valido;
				}

			}

			// Valida que Interior sea numerico. 
	/*		if (txtInterior != ""){
				valido = validar(txtInterior, permitidos);
				if (valido == false){
					focaliza("frmUnico.textInterior");
					GestionarMensaje("1514", GestionarMensaje("1519", null, null, null), null, null);
					return valido;
				}

			}

			// Valida que Manzana sea numerico.
			if  (txtManzana != ""){
				valido = validar(txtManzana, permitidos);
				if (valido == false){
					focaliza("frmUnico.textManzana");
					GestionarMensaje("1514", GestionarMensaje("1520", null, null, null), null, null);
					return valido;
				}
					
			}
			
			// Valida que Lote sea numérico.
			if  (txtLote != ""){
				valido = validar(txtLote, permitidos);
				if (valido == false){
					focaliza("frmUnico.textLote");
					GestionarMensaje("1514", GestionarMensaje("1521", null, null, null), null, null);
					return valido;
				}
					
			}

			// Valida que KM sea numérico.
			if  (txtKM != ""){
				valido = validar(txtKM, permitidos);
				if (valido == false){
					focaliza("frmUnico.textKm");
					GestionarMensaje("1514", GestionarMensaje("1522", null, null, null), null, null);
					return valido;
				}
					
			}
			*/

			// Valida que Hora Desde sea numérico.
			if (txtHoraDesde != "")
			{	
				valido = validaFormatoHora(txtHoraDesde);
				if ( valido == false)
				{
					focaliza("frmUnico.textHoraDesde");
					GestionarMensaje("1514", null, null, null);
					return valido;
				}
			}

			// Valida que Hora Hasta sea numérico
			if (txtHoraHasta != "")
			{
				valido = validaFormatoHora(txtHoraHasta);
				if (valido == false)
				{
					focaliza("frmUnico.textHoraHasta");
					GestionarMensaje("1514", null, null, null);
					return valido;
				}
			}


/*			if  (txtHoraDesde != ""){
				valido = validar(txtHoraDesde, permitidos);
				if (valido == false){
					focaliza("frmUnico.textHoraDesde");
					GestionarMensaje("1514", GestionarMensaje("1195", null, null, null), null, null);
					return valido;
				}
					
			}

			// Valida que Hora Hasta sea numérico.
			if  (txtHoraHasta != ""){
				valido = validar(txtHoraHasta, permitidos);
				if (valido == false){
					focaliza("frmUnico.textHoraHasta");
					GestionarMensaje("1514", GestionarMensaje("1196", null, null, null), null, null);
					return valido;
				}
					
			}*/

			return valido;
	}

 // -------------------------------------------------------------------------------------------------------------------------------------
	function validar(valor, caracteres){
		var permitidos = caracteres;
		var c;

		for(var i=0; i<valor.length; i++){
				c = valor.charAt(i);
				if (permitidos.indexOf(c) == -1 ){ 
					return false;
        }
		}
		return true;
	 }

 // -------------------------------------------------------------------------------------------------------------------------------------
	 function cambioTipoVia(){
			var geoRef = get("frmUnico.geoReferenciador");

			if ( geoRef == "N"){
					var valorClavePadre = get("frmUnico.cbTipoVia");
					if ( valorClavePadre != ""){
						var parametros = new Array([],[]);
						parametros[0][0] = "oid";
						parametros[0][1] = ""+valorClavePadre;// clave del tipoVia
						parametros[1][0] = "oidPais";
						parametros[1][1] = get("frmUnico.hidPais");
						//asignar([['LISTA', '', 'ConectorDruidaTransactionQuery', 'dtoSalida.resultado_ROWSET', formarCadenaDT("MAERecargarVias", "es.indra.sicc.util.DTOOID", parametros),'loadDATA(datos,' + valorClavePadre +');']],'','');			
						//asignar([['COMBO', '', 'ConectorDruidaTransactionQuery', 'dtoSalida.resultado_ROWSET', formarCadenaDT("MAERecargarVias", "es.indra.sicc.util.DTOOID", parametros),'loadDATA(datos,' + valorClavePadre +');']],'','');			
						recargaCombo("frmUnico.cbVia", "MAERecargarVias", "es.indra.sicc.util.DTOOID", parametros);
					}
			} 
	 }

 // -------------------------------------------------------------------------------------------------------------------------------------
	 function getIndiceSeleccionado(codigo){

				var longCombo = combo_get("frmUnico.cbVia", "L");
				var n = 0;
				var flag = true;
				var cod = "";

				while ( n < longCombo && flag){
						cod = combo_get("frmUnico.cbVia", "V", n);
						if (cod == codigo){
								flag = false;
						}else{
							n++;
						}
				 }

				 if (flag){			// No se encontro registro. 
						n = -1;
				 }

				 return n;

	  }

// -------------------------------------------------------------------------------------------------------------------------------------------
function noHayRegistros(){
	//alert("No hay nada");
}

// -------------------------------------------------------------------------------------------------------------------------------------------
function hayRegistros(cadenaParams){
		set("frmUnico.conectorAction", "LPBusquedaCliente");
		set("frmUnico.accion", "buscarPagina");			

/*		var cbVia = get("frmUnico.cbVia");
		if (cbVia != ""){
				var indice = getIndiceSeleccionado( cbVia );
				var TextCbVia = combo_get("frmUnico.cbVia", "T", indice);
				set("frmUnico.hibTextCbVia", TextCbVia);
		}

		set("frmUnico.textNombreVia", TextCbVia);


		var cbTipoDireccion = get("frmUnico.cbTipoDireccion");
		var cbTipoVia = get("frmUnico.cbTipoVia");
		var textNombreVia = get("frmUnico.textNombreVia");
		var textNPrincipal = get("frmUnico.textNPrincipal");
		var textCodPostal = get("frmUnico.textCodPostal");
		var textInterior = get("frmUnico.textInterior");
		var textManzana = get("frmUnico.textManzana");
		var textLote = get("frmUnico.textLote");
		var textKm = get("frmUnico.textKm");
		var rbDireccionPrincipal = get("frmUnico.rbDireccionPrincipal");
		var textObservaciones = get("frmUnico.textObservaciones");
		var cbTipoComunicacion = get("frmUnico.cbTipoComunicacion");
		var cbDiaComunicacion = get("frmUnico.cbDiaComunicacion");
		var rbComunicacionPrincipal = get("frmUnico.rbComunicacionPrincipal");
		var textHoraDesde = get("frmUnico.textHoraDesde");
		var textHoraHasta = get("frmUnico.textHoraHasta");
		var cbIntervaloComunicacion = get("frmUnico.cbIntervaloComunicacion");
		var textTextoComunicacion = get("frmUnico.textTextoComunicacion");
		var cbMarca = get("frmUnico.cbMarca");

		set("frmUnico.hidcbTipoDireccion", cbTipoDireccion );		
		set("frmUnico.hidcbTipoVia", cbTipoVia );
		set("frmUnico.hidtextNombreVia", textNombreVia);
		set("frmUnico.hidtextNPrincipal", textNPrincipal);
		set("frmUnico.hidtextCodPostal", textCodPostal );
		set("frmUnico.hidtextInterior", textInterior );			
		set("frmUnico.hidtextManzana", textManzana );			
		set("frmUnico.hidtextLote", textLote );			
		set("frmUnico.hidtextKm", textKm );			
		set("frmUnico.hidrbDireccionPrincipal", rbDireccionPrincipal );			
		set("frmUnico.hidtextObservaciones", textObservaciones );			
		set("frmUnico.hidcbTipoComunicacion", cbTipoComunicacion );			
		set("frmUnico.hidcbDiaComunicacion", cbDiaComunicacion );			
		set("frmUnico.hidrbComunicacionPrincipal", rbComunicacionPrincipal );			
		set("frmUnico.hidtextHoraDesde", textHoraDesde );			
		set("frmUnico.hidtextHoraHasta", textHoraHasta );			
		set("frmUnico.hidcbIntervaloComunicacion", cbIntervaloComunicacion );			
		set("frmUnico.hidtextTextoComunicacion", textTextoComunicacion );			
		set("frmUnico.hidcbMarca", cbMarca );			
		set("frmUnico.hidcbVia", cbVia);*/


   	    set("frmUnico.hCadenaParams", cadenaParams);
		//alert("Hay Registros");
		seteaHiddens("frmUnico");

		enviaSICC("frmUnico");

}


// -------------------------------------------------------------------------------------------------------------------------------------------------------------
function duplicaFormulario(){
		// Duplica formulario
			frmUnicoBusq.innerHTML = frmUnico.innerHTML;
  		/*set("frmUnicoBusq.accion", get("frmUnico.accion") );
		set("frmUnicoBusq.conectorAction", get("frmUnico.conectorAction") );
		set("frmUnicoBusq.errCodigo", get("frmUnico.errCodigo") );
		set("frmUnicoBusq.errDescripcion", get("frmUnico.errDescripcion") );
		set("frmUnicoBusq.errSeverity", get("frmUnico.errSeverity") );
		set("frmUnicoBusq.casoDeUso", get("frmUnico.casoDeUso") );
    set("frmUnicoBusq.hiddenTipoCliente" ,get("frmUnico.hiddenTipoCliente") );
    set("frmUnicoBusq.hiddenSubTipoCliente" ,get("frmUnico.hiddenSubTipoCliente") );
		set("frmUnicoBusq.hidCriterioBusqueda1", get("frmUnico.hidCriterioBusqueda1") );
		set("frmUnicoBusq.hidCriterioBusqueda2", get("frmUnico.hidCriterioBusqueda2") );
		set("frmUnicoBusq.hidCriterioBusqueda2", get("frmUnico.hidCriterioBusqueda2") );
		set("frmUnicoBusq.hidTipoSubtipo", get("frmUnico.hidTipoSubtipo") );
		set("frmUnicoBusq.hidtextCodCliente", get("frmUnico.hidtextCodCliente") );
		set("frmUnicoBusq.hidcbTipoDocId", get("frmUnico.hidcbTipoDocId") );
		set("frmUnicoBusq.hidtextNDocId", get("frmUnico.hidtextNDocId") );
		set("frmUnicoBusq.hidrbDocPrincipal", get("frmUnico.hidrbDocPrincipal") );
		set("frmUnicoBusq.hidcbPersonaCliente", get("frmUnico.hidcbPersonaCliente") );
		set("frmUnicoBusq.hidtextApellido1", get("frmUnico.hidtextApellido1") );
		set("frmUnicoBusq.hidtextApellido2", get("frmUnico.hidtextApellido2") );
		set("frmUnicoBusq.hidtextApellidoCasada", get("frmUnico.hidtextApellidoCasada") );
		set("frmUnicoBusq.hidtextNombre1", get("frmUnico.hidtextNombre1") );
		set("frmUnicoBusq.hidtextNombre2", get("frmUnico.hidtextNombre2") );
		set("frmUnicoBusq.hidcbTratamiento", get("frmUnico.hidcbTratamiento") );
		set("frmUnicoBusq.hidrbSexo", get("frmUnico.hidrbSexo") );
		set("frmUnicoBusq.hidcbFormaPago", get("frmUnico.hidcbFormaPago") );
		set("frmUnicoBusq.hidtextFechaNacimiento", get("frmUnico.hidtextFechaNacimiento") );
		set("frmUnicoBusq.hidtextCodEmpleado", get("frmUnico.hidtextCodEmpleado") );
		set("frmUnicoBusq.hidcbNacionalidad", get("frmUnico.hidcbNacionalidad") );
		set("frmUnicoBusq.hidcbEstadoCivil", get("frmUnico.hidcbEstadoCivil") );
		set("frmUnicoBusq.hidtextOcupacion", get("frmUnico.hidtextOcupacion") );
		set("frmUnicoBusq.hidtextProfesion", get("frmUnico.hidtextProfesion") );
		set("frmUnicoBusq.hidtextCentroTrabajo", get("frmUnico.hidtextCentroTrabajo") );
		set("frmUnicoBusq.hidtextCargoDesempena", get("frmUnico.hidtextCargoDesempena") );
		set("frmUnicoBusq.hidcbNivelEstudios", get("frmUnico.hidcbNivelEstudios") );
		set("frmUnicoBusq.hidtextCentroEstudios", get("frmUnico.hidtextCentroEstudios") );
		set("frmUnicoBusq.hidtextNHijos", get("frmUnico.hidtextNHijos") );
		set("frmUnicoBusq.hidtextNPersonasDependientes", get("frmUnico.hidtextNPersonasDependientes") );
		set("frmUnicoBusq.hidcbNivelSocioEconomico", get("frmUnico.hidcbNivelSocioEconomico") );
		set("frmUnicoBusq.hidcbCicloVidaFamiliar", get("frmUnico.hidcbCicloVidaFamiliar") );
		set("frmUnicoBusq.hidrbDeseaCorrespondencia", get("frmUnico.hidrbDeseaCorrespondencia") );
		set("frmUnicoBusq.hidtextImporteIngresoFamiliar", get("frmUnico.hidtextImporteIngresoFamiliar") );
		set("frmUnicoBusq.hidcbPaisVinculo", get("frmUnico.hidcbPaisVinculo") );
		set("frmUnicoBusq.hidtextClienteVinculo", get("frmUnico.hidtextClienteVinculo") );
		set("frmUnicoBusq.hidcbTipoVinculo", get("frmUnico.hidcbTipoVinculo") );
		set("frmUnicoBusq.hidtextFechaD", get("frmUnico.hidtextFechaD") );
		set("frmUnicoBusq.hidtextFechaH", get("frmUnico.hidtextFechaH") );
		set("frmUnicoBusq.hidrbVinculoPrincipal", get("frmUnico.hidrbVinculoPrincipal") );
		set("frmUnicoBusq.hidcb", get("frmUnico.hidcb") );
		set("frmUnicoBusq.hidtextDescripcion", get("frmUnico.hidtextDescripcion") );
		set("frmUnicoBusq.hidcbPaisContactado", get("frmUnico.hidcbPaisContactado") );
		set("frmUnicoBusq.hidtextCodClienteContactado", get("frmUnico.hidtextCodClienteContactado") );
		set("frmUnicoBusq.hidcbTipoClienteContactado", get("frmUnico.hidcbTipoClienteContactado") );
		set("frmUnicoBusq.hidcbCodTipoContactado", get("frmUnico.hidcbCodTipoContactado") );
		set("frmUnicoBusq.hidtextFechaContacto", get("frmUnico.hidtextFechaContacto") );
		set("frmUnicoBusq.hidtextFecha1PedidoContacto", get("frmUnico.hidtextFecha1PedidoContacto") );
		set("frmUnicoBusq.hidtextFechaSiguienteContacto", get("frmUnico.hidtextFechaSiguienteContacto") );
		set("frmUnicoBusq.hidtxtFechaIngresoActual", get("frmUnico.hidtxtFechaIngresoActual") ); 

		set("frmUnicoBusq.hidcbTipoDireccion", get("frmUnico.hidcbTipoDireccion") ); 
		set("frmUnicoBusq.hidcbTipoVia", get("frmUnico.hidcbTipoVia") ); 
		set("frmUnicoBusq.hidtextNombreVia", get("frmUnico.hidtextNombreVia") ); 
		set("frmUnicoBusq.hidtextNPrincipal", get("frmUnico.hidtextNPrincipal") ); 
		set("frmUnicoBusq.hidtextCodPostal", get("frmUnico.hidtextCodPostal") ); 
		set("frmUnicoBusq.hidrbDireccionPrincipal", get("frmUnico.hidrbDireccionPrincipal") ); 
		set("frmUnicoBusq.hidtextObservaciones", get("frmUnico.hidtextObservaciones") ); 
		set("frmUnicoBusq.hidcbTipoComunicacion", get("frmUnico.hidcbTipoComunicacion") ); 
		set("frmUnicoBusq.hidcbDiaComunicacion", get("frmUnico.hidcbDiaComunicacion") ); 
		set("frmUnicoBusq.hidrbComunicacionPrincipal", get("frmUnico.hidrbComunicacionPrincipal") ); 
		set("frmUnicoBusq.hidtextHoraDesde", get("frmUnico.hidtextHoraDesde") ); 
		set("frmUnicoBusq.hidtextHoraHasta", get("frmUnico.hidtextHoraHasta") ); 
		set("frmUnicoBusq.hidcbIntervaloComunicacion", get("frmUnico.hidcbIntervaloComunicacion") ); 
		set("frmUnicoBusq.hidtextTextoComunicacion", get("frmUnico.hidtextTextoComunicacion") ); 
		set("frmUnicoBusq.hidcbMarca", get("frmUnico.hidcbMarca") ); 
		set("frmUnicoBusq.hidcbVia", get("frmUnico.hidcbVia") ); 

		set("frmUnicoBusq.hidcbTipoTarjeta", get("frmUnico.hidcbTipoTarjeta") ); 
		set("frmUnicoBusq.hidcbClasesTarjeta", get("frmUnico.hidcbClasesTarjeta") ); 
		set("frmUnicoBusq.hidcbEntidadBancaria", get("frmUnico.hidcbEntidadBancaria") ); 
		set("frmUnicoBusq.hidcbMarcaPestanya4", get("frmUnico.hidcbMarcaPestanya4") ); 
		set("frmUnicoBusq.hidcbCanal", get("frmUnico.hidcbCanal") ); 
		set("frmUnicoBusq.hidcbTipoClasificacion", get("frmUnico.hidcbTipoClasificacion") ); 
		set("frmUnicoBusq.hidcbTipoProblema", get("frmUnico.hidcbTipoProblema") ); 
		set("frmUnicoBusq.hidrbSolucion", get("frmUnico.hidrbSolucion") ); 
		set("frmUnicoBusq.hidcbTipoSolucion", get("frmUnico.hidcbTipoSolucion") ); 
		set("frmUnicoBusq.hidtextDescripcionProblema", get("frmUnico.hidtextDescripcionProblema") ); 
		set("frmUnicoBusq.hidtextDescripcionSolucion", get("frmUnico.hidtextDescripcionSolucion") ); 
		set("frmUnicoBusq.hidcbClasificacion", get("frmUnico.hidcbClasificacion") ); 
		set("frmUnicoBusq.hidtextNegocioProducto", get("frmUnico.hidtextNegocioProducto") ); 
		set("frmUnicoBusq.ListaComboClasificacion", get("frmUnico.ListaComboClasificacion") ); 

		set("frmUnicoBusq.hidcbMarcaContacto", get("frmUnico.hidcbMarcaContacto") ); 
		set("frmUnicoBusq.hidcbCanalContacto", get("frmUnico.hidcbCanalContacto") ); 
		set("frmUnicoBusq.hidcbPeriodoPrimerPedido", get("frmUnico.hidcbPeriodoPrimerPedido") ); 
*/
}


// -------------------------------------------------------------------------------------------------------------------------------------
function validaFormatoHora(hora)
{
		// Valida hora con el formato establecido para la hora: HH:mm (Hora de 0 a 23, min de 00 a 59, ":" separa ambos numeros)
		var horaArray = hora.split(":");

		if (horaArray.length != 2)
			return false;

		// ------------------------- Hora ------------------------------------------------------------------------------------
		// Valida que hora sea un numero y de 1 o 2 digitos.
		if (esNumero(horaArray[0]) == -1 || (horaArray[0].length != 1 && horaArray[0].length != 2))
			return false;

		// Valida que hora este entre 0 y 23
		if ( parseInt(horaArray[0], 10) > 23 )
					return false;

		// ---------------------------------- Minutos ----------------------------------------------------
		// Valida que minuto sea numerico y tenga 2 digitos siempre
		if ( esNumero(horaArray[1]) == -1 || horaArray[1].length != 2)
					return false;

		// Valida que minuto este entre 0 y 59
		if ( parseInt(horaArray[1], 10) > 59 )
					return false;

		return true;

}