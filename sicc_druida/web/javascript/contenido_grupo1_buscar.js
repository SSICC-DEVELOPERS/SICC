// -------------------------------------------------------------------------------------------------------------------------------------------
	function onLoadPag(){

      //[1] eval (ON_RSZ); 
	   setTimeout('eval (ON_RSZ)',200);
      configurarMenuSecundario("frmUnico");
      accion('frmUnico.textCodCliente', '.maxLength=' + document.all.hidlongCodCliente.value);
	   fMostrarMensajeError();

		// Manejo de errores. En principio, seria igual codigo si hay o no error <<---- CHEQUEAR!

		cargaComboPersona();
		muestraSeleccionAnterior();
		focaliza("frmUnico.textCodCliente","");

	  if (window.dialogArguments) { // Si es modal (se abrió mediante showModalDialog) DBLG500000915
        btnProxy(2,1);  // boton 'volver', habilitado
        btnProxy(3,0);  // boton 'Ir a pantalla de inicio', deshabilitado
     }
	}

// -------------------------------------------------------------------------------------------------------------------------------------------

	function fVolver(){     
					  window.close();
	}

/* -------------------------------------------------------------------------------------------------------------------------------------------- */

 
 function siguientePestanya(pestanya){
      
    set('frmUnico.conectorAction', 'LPBusquedaCliente');
      
		if (pestanya == -1){
		   set('frmUnico.accion', "");
    }

		else if (pestanya == 0){
   	   set('frmUnico.accion', "siguienteTipoSubtipo");
    }

	else 	if (pestanya == 1){
   	   set('frmUnico.accion', "siguientePestanya1");  // Esta pestaña
    }

    else if (pestanya == 2){
       set('frmUnico.accion', 'siguientePestanya2');
    }

	else  if (pestanya == 3){   
       set('frmUnico.accion', 'siguientePestanya3');
    }

   else  if(pestanya == 4){   
       set('frmUnico.accion', 'siguientePestanya4');
    }

		// Lee los distintos valores seleccionados en la pagina y los setea en las variables corresp.
		// [1] se comenta porque el método validarFormato lo unico que hace es retornar True
		// [1] var formatoValido = validarFormato();

		// [1] if (formatoValido != false){
				//alert("*** En siguientePestanya");
		seteaHiddens("frmUnico");
		enviaSICC("frmUnico");
		// [1]}

   }


// -------------------------------------------------------------------------------------------------------------------------------------------
	function muestraSeleccionAnterior(){

		var txtCodCliente = get("frmUnico.hidtextCodCliente");
		var cbTipoDocID =  get("frmUnico.hidcbTipoDocId");
		var txtNDocID = get("frmUnico.hidtextNDocId");
		var rbDocPrincipal = get("frmUnico.hidrbDocPrincipal");
		var cbPersonaCliente = get("frmUnico.hidcbPersonaCliente");
		//Cleal
		var indiceActi = get("frmUnico.hidIndActivo");
		if(indiceActi==""){

			set("frmUnico.cbIndActivo", new Array(["1"]));
		}else{
			set("frmUnico.cbIndActivo", new Array([indiceActi]));

		}
		//
		set("frmUnico.textCodCliente", txtCodCliente);
		set("frmUnico.textNDocId", txtNDocID);
		set("frmUnico.cbPersonaCliente", new Array(cbPersonaCliente) );
		set("frmUnico.cbTipoDocId", new Array(cbTipoDocID) );
		set("frmUnico.rbDocPrincipal", rbDocPrincipal);

	}

// -------------------------------------------------------------------------------------------------------------------------------------------
	function cargaComboPersona(){
		var personaCliente = new Array();
		personaCliente[0] = ["E", GestionarMensaje("1050", null, null, null)];
		personaCliente[1] = ["P", GestionarMensaje("1043", null, null, null)];

		set_combo("frmUnico.cbPersonaCliente", personaCliente);
	}

// -------------------------------------------------------------------------------------------------------------------------------------------
	function buscar(){
			duplicaFormulario();
			set("frmUnicoBusq.accion", "buscar");
			set("frmUnicoBusq.conectorAction", "LPBusquedaCliente");
			// [1] se comenta porque el método validarFormato lo unico que hace es retornar True
			//[1]var formatoValido = validarFormato();
			//[1]if (formatoValido != false){
					//alert("***En Buscar()");
					seteaHiddens("frmUnicoBusq");
					enviaSICC("frmUnicoBusq");
			//[1]}

	}

// -------------------------------------------------------------------------------------------------------------------------------------------
	function seteaHiddens(formName){
		/* [1]
		var txtCodCliente = get("frmUnico.textCodCliente");
		var cbTipoDoc = get("frmUnico.cbTipoDocId");
		var txtNroDoc = get("frmUnico.textNDocId");
		var rbDocPpal = get("frmUnico.rbDocPrincipal");
		var cbPersonaCliente = get("frmUnico.cbPersonaCliente");
		//cleal
		var indiceActi = get("frmUnico.cbIndActivo");
		[1]*/

		set(formName + ".hidtextCodCliente", get("frmUnico.textCodCliente"));
		set(formName + ".hidcbTipoDocId", get("frmUnico.cbTipoDocId"));
		set(formName + ".hidtextNDocId", get("frmUnico.textNDocId"));
		set(formName + ".hidrbDocPrincipal", get("frmUnico.rbDocPrincipal"));
		set(formName + ".hidcbPersonaCliente", get("frmUnico.cbPersonaCliente"));
		//cleal
		set(formName + ".hidIndActivo", get("frmUnico.cbIndActivo"));


//		set("frmUnicoBusq.hidtextCodCliente", txtCodCliente );
//		set("frmUnicoBusq.hidcbTipoDocId",  cbTipoDoc);
//		set("frmUnicoBusq.hidtextNDocId", txtNroDoc);
//		set("frmUnicoBusq.hidrbDocPrincipal", rbDocPpal);
//		set("frmUnicoBusq.hidcbPersonaCliente", cbPersonaCliente);

	}

// -------------------------------------------------------------------------------------------------------------------------------------------
	function chequeoErrores()	{
		var errCodigo = get("frmUnico.errCodigo");
		if (errCodigo != ""){
			fMostrarMensajeError();
			return true;
		} 

		return false;

   }


	
// -------------------------------------------------------------------------------------------------------------------------------------------
	function fLimpiar(){
			//muestraSeleccionAnterior();

			set("frmUnico.textCodCliente", "");
			set("frmUnico.cbTipoDocId", new Array() );
			set("frmUnico.textNDocId", "" );
			set("frmUnico.rbDocPrincipal", "" );
			set("frmUnico.cbPersonaCliente", new Array() );

			focaliza("frmUnico.textCodCliente","");
	}

// -------------------------------------------------------------------------------------------------------------------------------------------
	function validarFormato(){
			var valido = true;
			/*var permitidos = "0123456789";
			var nroDoc = get("frmUnico.textNDocId");

			if (nroDoc != ""){
				valido = validar(nroDoc, permitidos);
				if (valido == false){
					focaliza("frmUnico.textNDocId");
					GestionarMensaje("1514", "Nro de Documento", null, null); 
					return valido;
				}

			}*/
			return valido;
	}

// -------------------------------------------------------------------------------------------------------------------------------------------
    function validar(valor, caracteres) {
			var permitidos = caracteres;
			var c;
	
			for(var i=0; i<valor.length; i++){
					c = valor.charAt(i);
					if (permitidos.indexOf(c) == -1){ 
						return false;
          }
			}
			return true;
	  }

// -------------------------------------------------------------------------------------------------------------------------------------------
	function seleccionarClienteContactado(){
         var obj = new Object();

         var whnd = mostrarModalSICC('LPBusquedaRapidaCliente','',obj);
         if(whnd!=null){
			var cod = whnd[1];
			set("frmUnico.textCodCliente", cod);
         }
	}

// -------------------------------------------------------------------------------------------------------------------------------------------
function noHayRegistros(){
	;
}

// -------------------------------------------------------------------------------------------------------------------------------------------
function hayRegistros(cadenaParams){
                  //alert("***En hayRegistros()");
                  seteaHiddens("frmUnico");
				  
                  set("frmUnico.conectorAction", "LPBusquedaCliente");
                  set("frmUnico.accion", "buscarPagina");			

                  /* [1]
				  Esto lo comento porque estos set se hacen en el "seteaHiddens()"
				  var txtCodCliente = get("frmUnico.textCodCliente");
                  var cbTipoDoc = get("frmUnico.cbTipoDocId");
                  var txtNroDoc = get("frmUnico.textNDocId");
                  var rbDocPpal = get("frmUnico.rbDocPrincipal");
                  var cbPersonaCliente = get("frmUnico.cbPersonaCliente");
                  //cleal
                  var indiceActi = get("frmUnico.cbIndActivo");
                  //alert("hayRegistros - indiceActi: "+indiceActi);
                  //alert(indiceActi);

                  set("frmUnico.hidtextCodCliente", txtCodCliente );
                  set("frmUnico.hidcbTipoDocId",  cbTipoDoc);
                  set("frmUnico.hidtextNDocId", txtNroDoc);
                  set("frmUnico.hidrbDocPrincipal", rbDocPpal);
                  set("frmUnico.hidcbPersonaCliente", cbPersonaCliente);
                  //cleal
                  set("frmUnico.hidIndActivo", indiceActi);
				  [1] */
		    	  set("frmUnico.hCadenaParams", cadenaParams);
				  //alert("grupo1_buscar, cadenaParams: " + cadenaParams);
                  //alert("frmUnico.hidIndActivo: "+get("frmUnico.hidIndActivo"));
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
		set("frmUnicoBusq.hidCriterioBusqueda1", get("frmUnico.hidCriterioBusqueda1") );
		set("frmUnicoBusq.hidCriterioBusqueda2", get("frmUnico.hidCriterioBusqueda2") );
		set("frmUnicoBusq.hidCriterioBusqueda2", get("frmUnico.hidCriterioBusqueda2") );

		//Cleal hidIndActivo
		set("frmUnicoBusq.hidIndActivo", get("frmUnico.hidIndActivo") );
		//alert("***En DuplicarFormulario()");
		//alert(get("frmUnico.hidIndActivo"));
		//alert(get("frmUnicoBusq.hidIndActivo"));

	  set("frmUnicoBusq.hidTipoSubtipo", get("frmUnico.hidTipoSubtipo") );
    set("frmUnicoBusq.hiddenTipoCliente" ,get("frmUnico.hiddenTipoCliente") );
    set("frmUnicoBusq.hiddenSubTipoCliente" ,get("frmUnico.hiddenSubTipoCliente") );
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
		set("frmUnicoBusq.hidtextInterior", get("frmUnico.hidtextInterior") ); 
		set("frmUnicoBusq.hidtextManzana", get("frmUnico.hidtextManzana") ); 
		set("frmUnicoBusq.hidtextLote", get("frmUnico.hidtextLote") ); 
		set("frmUnicoBusq.hidtextKm", get("frmUnico.hidtextKm") ); 
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



// --------------------------------------------------------
   /*
    FUNCIONES PARA VALIDAR LONGITUD COD CLIENTE
   */   
  function onchange_codCliente(){

        if(!sicc_validaciones_generales("gr")){
            return false;
        }    

        var codCliente = get('frmUnico.textCodCliente');

        if (codCliente.length != 0)  {    
            codigoCompleto = validarLongCodCliene(codCliente);
            set('frmUnico.textCodCliente', codigoCompleto);
        }
  }
  
  
   function validarLongCodCliene(codCliente) {

	  var longiCod = get('frmUnico.hidlongCodCliente');
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