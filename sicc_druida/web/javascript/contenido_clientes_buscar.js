// -------------------------------------------------------------------------------------------------------------------------------------------
     function onLoadPag(){
	  setTimeout('eval (ON_RSZ)',200);
      //eval (ON_RSZ); 
      configurarMenuSecundario("frmbuscarCliente"); 
		
		  var hayErrores = chequeaErrores();
		  muestraSeleccionAnterior(); //[1]
		  if (hayErrores != true){
				// [1] muestraSeleccionAnterior();
				focaliza("frmbuscarCliente.textCriterioBusqueda1","");
				return;
		  }
		 // [1] muestraSeleccionAnterior();
		  focaliza("frmbuscarCliente.textCriterioBusqueda1","");

		if (window.dialogArguments) { // Si es modal (se abrió mediante showModalDialog) DBLG500000915
            btnProxy(2,1);  // boton 'volver', habilitado
            btnProxy(3,0);  // boton 'Ir a pantalla de inicio', deshabilitado
        }


     }

// -------------------------------------------------------------------------------------------------------------------------------------------
	function fVolver(){     
					  window.close();
	}

// -------------------------------------------------------------------------------------------------------------------------------------------
	 function siguientePestanya(pestanya){
      set('frmbuscarCliente.conectorAction', 'LPBusquedaCliente');
			if (pestanya == 0){
				set("frmbuscarCliente.accion", "siguienteTipoSubtipo");
      }

		else if (pestanya == 1){ //	[1] if (pestanya == 1){ 
			  set('frmbuscarCliente.accion', 'siguientePestanya1');
      }

		else 	if (pestanya == 2){ 	//[1] if (pestanya == 2){ 
			  set('frmbuscarCliente.accion', 'siguientePestanya2');
      }

		else 	 if (pestanya == 3){    //[1]  if (pestanya == 3){   
			  set('frmbuscarCliente.accion', 'siguientePestanya3');
      }

      else 	if (pestanya == 4){   //[1]if (pestanya == 4){   
		    set('frmbuscarCliente.accion', 'siguientePestanya4');
      }

			// Setea los valores de las variables propias de ESTA pantalla

			var criterioBusq1 = get("frmbuscarCliente.textCriterioBusqueda1");
			var criterioBusq2 = get("frmbuscarCliente.textCriterioBusqueda2");
			var casoDeUso = get("frmbuscarCliente.casoDeUso");
			set("frmbuscarCliente.hidCriterioBusqueda1", criterioBusq1);
			set("frmbuscarCliente.hidCriterioBusqueda2", criterioBusq2);
			set("frmbuscarCliente.casoDeUso", casoDeUso);            

	    enviaSICC('frmbuscarCliente');  

   }

// -------------------------------------------------------------------------------------------------------------------------------------------
	function muestraSeleccionAnterior(){
			var criterio1 = get("frmbuscarCliente.hidCriterioBusqueda1");
			var criterio2 = get("frmbuscarCliente.hidCriterioBusqueda2");

			set("frmbuscarCliente.textCriterioBusqueda1",  criterio1);
			set("frmbuscarCliente.textCriterioBusqueda2",  criterio2);
			return;
	}

// -------------------------------------------------------------------------------------------------------------------------------------------
	function busca(){

		duplicaFormulario();

		set("frmbuscarClienteBusq.conectorAction", "LPBusquedaCliente");
		set("frmbuscarClienteBusq.accion", "buscar");

		// Setea los valores de las variables propias de ESTA pantalla

		var criterioBusq1 = get("frmbuscarCliente.textCriterioBusqueda1");
		var criterioBusq2 = get("frmbuscarCliente.textCriterioBusqueda2");
		var casoDeUso = get("frmbuscarCliente.casoDeUso");

		set("frmbuscarClienteBusq.hidCriterioBusqueda1", criterioBusq1);
		set("frmbuscarClienteBusq.hidCriterioBusqueda2", criterioBusq2);
		set("frmbuscarClienteBusq.casoDeUso", casoDeUso);

		enviaSICC("frmbuscarClienteBusq");

	}

// -------------------------------------------------------------------------------------------------------------------------------------------
	function chequeaErrores(){
		var errCod = get("frmbuscarCliente.errCodigo");

		if (errCod != null){
				fMostrarMensajeError();
				return true;
		}

		return false;

	}

	
// -------------------------------------------------------------------------------------------------------------------------------------------
	function fLimpiar()	{
		//muestraSeleccionAnterior();
		set("frmbuscarCliente.textCriterioBusqueda1", "");
		set("frmbuscarCliente.textCriterioBusqueda2", "");
		focaliza("frmbuscarCliente.textCriterioBusqueda1","");
	}

// -------------------------------------------------------------------------------------------------------------------------------------------
function noHayRegistros(){
	//alert("No hay nada");
}

// -------------------------------------------------------------------------------------------------------------------------------------------
function hayRegistros(cadenaParams){
		//alert("Hay Registros");

		set("frmbuscarCliente.conectorAction", "LPBusquedaCliente");
		set("frmbuscarCliente.accion", "buscarPagina");

		set("frmbuscarCliente.hCadenaParams", cadenaParams);
	
		// Setea los valores de las variables propias de ESTA pantalla
	
		var criterioBusq1 = get("frmbuscarCliente.textCriterioBusqueda1");
		var criterioBusq2 = get("frmbuscarCliente.textCriterioBusqueda2");
		var casoDeUso = get("frmbuscarCliente.casoDeUso");
		//alert("caso de Uso: " + casoDeUso);

		set("frmbuscarCliente.hidCriterioBusqueda1", criterioBusq1);
		set("frmbuscarCliente.hidCriterioBusqueda2", criterioBusq2);
		set("frmbuscarCliente.casoDeUso", casoDeUso);
	
		enviaSICC("frmbuscarCliente");	 
	
}

// -------------------------------------------------------------------------------------------------------------------------------------------
function duplicaFormulario(){
	frmbuscarClienteBusq.innerHTML = frmbuscarCliente.innerHTML;

		// Duplica formulario
  	/*set("frmbuscarClienteBusq.accion", get("frmbuscarCliente.accion") );
		set("frmbuscarClienteBusq.conectorAction", get("frmbuscarCliente.conectorAction") );
		set("frmbuscarClienteBusq.errCodigo", get("frmbuscarCliente.errCodigo") );
		set("frmbuscarClienteBusq.errDescripcion", get("frmbuscarCliente.errDescripcion") );
		set("frmbuscarClienteBusq.errSeverity", get("frmbuscarCliente.errSeverity") );
		set("frmbuscarClienteBusq.casoDeUso", get("frmbuscarCliente.casoDeUso") );
		set("frmbuscarClienteBusq.hidCriterioBusqueda1", get("frmbuscarCliente.hidCriterioBusqueda1") );
		set("frmbuscarClienteBusq.hidCriterioBusqueda2", get("frmbuscarCliente.hidCriterioBusqueda2") );
		set("frmbuscarClienteBusq.hidCriterioBusqueda2", get("frmbuscarCliente.hidCriterioBusqueda2") );
		set("frmbuscarClienteBusq.hidTipoSubtipo", get("frmbuscarCliente.hidTipoSubtipo") );
    set("frmbuscarClienteBusq.hiddenTipoCliente" ,get("frmbuscarCliente.hiddenTipoCliente") );
    set("frmbuscarClienteBusq.hiddenSubTipoCliente" ,get("frmbuscarCliente.hiddenSubTipoCliente") );
		set("frmbuscarClienteBusq.hidSubTipo", get("frmbuscarCliente.hidSubTipo") );
		set("frmbuscarClienteBusq.hidtextCodCliente", get("frmbuscarCliente.hidtextCodCliente") );
		set("frmbuscarClienteBusq.hidcbTipoDocId", get("frmbuscarCliente.hidcbTipoDocId") );
		set("frmbuscarClienteBusq.hidtextNDocId", get("frmbuscarCliente.hidtextNDocId") );
		set("frmbuscarClienteBusq.hidrbDocPrincipal", get("frmbuscarCliente.hidrbDocPrincipal") );
		set("frmbuscarClienteBusq.hidcbPersonaCliente", get("frmbuscarCliente.hidcbPersonaCliente") );
		set("frmbuscarClienteBusq.hidtextApellido1", get("frmbuscarCliente.hidtextApellido1") );
		set("frmbuscarClienteBusq.hidtextApellido2", get("frmbuscarCliente.hidtextApellido2") );
		set("frmbuscarClienteBusq.hidtextApellidoCasada", get("frmbuscarCliente.hidtextApellidoCasada") );
		set("frmbuscarClienteBusq.hidtextNombre1", get("frmbuscarCliente.hidtextNombre1") );
		set("frmbuscarClienteBusq.hidtextNombre2", get("frmbuscarCliente.hidtextNombre2") );
		set("frmbuscarClienteBusq.hidcbTratamiento", get("frmbuscarCliente.hidcbTratamiento") );
		set("frmbuscarClienteBusq.hidrbSexo", get("frmbuscarCliente.hidrbSexo") );
		set("frmbuscarClienteBusq.hidcbFormaPago", get("frmbuscarCliente.hidcbFormaPago") );
		set("frmbuscarClienteBusq.hidtextFechaNacimiento", get("frmbuscarCliente.hidtextFechaNacimiento") );
		set("frmbuscarClienteBusq.hidtextCodEmpleado", get("frmbuscarCliente.hidtextCodEmpleado") );
		set("frmbuscarClienteBusq.hidcbNacionalidad", get("frmbuscarCliente.hidcbNacionalidad") );
		set("frmbuscarClienteBusq.hidcbEstadoCivil", get("frmbuscarCliente.hidcbEstadoCivil") );
		set("frmbuscarClienteBusq.hidtextOcupacion", get("frmbuscarCliente.hidtextOcupacion") );
		set("frmbuscarClienteBusq.hidtextProfesion", get("frmbuscarCliente.hidtextProfesion") );
		set("frmbuscarClienteBusq.hidtextCentroTrabajo", get("frmbuscarCliente.hidtextCentroTrabajo") );
		set("frmbuscarClienteBusq.hidtextCargoDesempena", get("frmbuscarCliente.hidtextCargoDesempena") );
		set("frmbuscarClienteBusq.hidcbNivelEstudios", get("frmbuscarCliente.hidcbNivelEstudios") );
		set("frmbuscarClienteBusq.hidtextCentroEstudios", get("frmbuscarCliente.hidtextCentroEstudios") );
		set("frmbuscarClienteBusq.hidtextNHijos", get("frmbuscarCliente.hidtextNHijos") );
		set("frmbuscarClienteBusq.hidtextNPersonasDependientes", get("frmbuscarCliente.hidtextNPersonasDependientes") );
		set("frmbuscarClienteBusq.hidcbNivelSocioEconomico", get("frmbuscarCliente.hidcbNivelSocioEconomico") );
		set("frmbuscarClienteBusq.hidcbCicloVidaFamiliar", get("frmbuscarCliente.hidcbCicloVidaFamiliar") );
		set("frmbuscarClienteBusq.hidrbDeseaCorrespondencia", get("frmbuscarCliente.hidrbDeseaCorrespondencia") );
		set("frmbuscarClienteBusq.hidtextImporteIngresoFamiliar", get("frmbuscarCliente.hidtextImporteIngresoFamiliar") );
		set("frmbuscarClienteBusq.hidcbPaisVinculo", get("frmbuscarCliente.hidcbPaisVinculo") );
		set("frmbuscarClienteBusq.hidtextClienteVinculo", get("frmbuscarCliente.hidtextClienteVinculo") );
		set("frmbuscarClienteBusq.hidcbTipoVinculo", get("frmbuscarCliente.hidcbTipoVinculo") );
		set("frmbuscarClienteBusq.hidtextFechaD", get("frmbuscarCliente.hidtextFechaD") );
		set("frmbuscarClienteBusq.hidtextFechaH", get("frmbuscarCliente.hidtextFechaH") );
		set("frmbuscarClienteBusq.hidrbVinculoPrincipal", get("frmbuscarCliente.hidrbVinculoPrincipal") );
		set("frmbuscarClienteBusq.hidcb", get("frmbuscarCliente.hidcb") );
		set("frmbuscarClienteBusq.hidtextDescripcion", get("frmbuscarCliente.hidtextDescripcion") );
		set("frmbuscarClienteBusq.hidcbPaisContactado", get("frmbuscarCliente.hidcbPaisContactado") );
		set("frmbuscarClienteBusq.hidtextCodClienteContactado", get("frmbuscarCliente.hidtextCodClienteContactado") );
		set("frmbuscarClienteBusq.hidcbTipoClienteContactado", get("frmbuscarCliente.hidcbTipoClienteContactado") );
		set("frmbuscarClienteBusq.hidcbCodTipoContactado", get("frmbuscarCliente.hidcbCodTipoContactado") );
		set("frmbuscarClienteBusq.hidtextFechaContacto", get("frmbuscarCliente.hidtextFechaContacto") );
		set("frmbuscarClienteBusq.hidtextFecha1PedidoContacto", get("frmbuscarCliente.hidtextFecha1PedidoContacto") );
		set("frmbuscarClienteBusq.hidtextFechaSiguienteContacto", get("frmbuscarCliente.hidtextFechaSiguienteContacto") );
		set("frmbuscarClienteBusq.hidtxtFechaIngresoActual", get("frmbuscarCliente.hidtxtFechaIngresoActual") ); 

		set("frmbuscarClienteBusq.hidcbTipoDireccion", get("frmbuscarCliente.hidcbTipoDireccion") ); 
		set("frmbuscarClienteBusq.hidcbTipoVia", get("frmbuscarCliente.hidcbTipoVia") ); 
		set("frmbuscarClienteBusq.hidtextNombreVia", get("frmbuscarCliente.hidtextNombreVia") ); 
		set("frmbuscarClienteBusq.hidtextNPrincipal", get("frmbuscarCliente.hidtextNPrincipal") ); 
		set("frmbuscarClienteBusq.hidtextCodPostal", get("frmbuscarCliente.hidtextCodPostal") ); 
		set("frmbuscarClienteBusq.hidtextInterior", get("frmbuscarCliente.hidtextInterior") ); 
		set("frmbuscarClienteBusq.hidtextManzana", get("frmbuscarCliente.hidtextManzana") ); 
		set("frmbuscarClienteBusq.hidtextLote", get("frmbuscarCliente.hidtextLote") ); 
		set("frmbuscarClienteBusq.hidtextKm", get("frmbuscarCliente.hidtextKm") ); 
		set("frmbuscarClienteBusq.hidrbDireccionPrincipal", get("frmbuscarCliente.hidrbDireccionPrincipal") ); 
		set("frmbuscarClienteBusq.hidtextObservaciones", get("frmbuscarCliente.hidtextObservaciones") ); 
		set("frmbuscarClienteBusq.hidcbTipoComunicacion", get("frmbuscarCliente.hidcbTipoComunicacion") ); 
		set("frmbuscarClienteBusq.hidcbDiaComunicacion", get("frmbuscarCliente.hidcbDiaComunicacion") ); 
		set("frmbuscarClienteBusq.hidrbComunicacionPrincipal", get("frmbuscarCliente.hidrbComunicacionPrincipal") ); 
		set("frmbuscarClienteBusq.hidtextHoraDesde", get("frmbuscarCliente.hidtextHoraDesde") ); 
		set("frmbuscarClienteBusq.hidtextHoraHasta", get("frmbuscarCliente.hidtextHoraHasta") ); 
		set("frmbuscarClienteBusq.hidcbIntervaloComunicacion", get("frmbuscarCliente.hidcbIntervaloComunicacion") ); 
		set("frmbuscarClienteBusq.hidtextTextoComunicacion", get("frmbuscarCliente.hidtextTextoComunicacion") ); 
		set("frmbuscarClienteBusq.hidcbMarca", get("frmbuscarCliente.hidcbMarca") ); 
		set("frmbuscarClienteBusq.hidcbVia", get("frmbuscarCliente.hidcbVia") ); 

		set("frmbuscarClienteBusq.hidcbTipoTarjeta", get("frmbuscarCliente.hidcbTipoTarjeta") ); 
		set("frmbuscarClienteBusq.hidcbClasesTarjeta", get("frmbuscarCliente.hidcbClasesTarjeta") ); 
		set("frmbuscarClienteBusq.hidcbEntidadBancaria", get("frmbuscarCliente.hidcbEntidadBancaria") ); 
		set("frmbuscarClienteBusq.hidcbMarcaPestanya4", get("frmbuscarCliente.hidcbMarcaPestanya4") ); 
		set("frmbuscarClienteBusq.hidcbCanal", get("frmbuscarCliente.hidcbCanal") ); 
		set("frmbuscarClienteBusq.hidcbTipoClasificacion", get("frmbuscarCliente.hidcbTipoClasificacion") ); 
		set("frmbuscarClienteBusq.hidcbTipoProblema", get("frmbuscarCliente.hidcbTipoProblema") ); 
		set("frmbuscarClienteBusq.hidrbSolucion", get("frmbuscarCliente.hidrbSolucion") ); 
		set("frmbuscarClienteBusq.hidcbTipoSolucion", get("frmbuscarCliente.hidcbTipoSolucion") ); 
		set("frmbuscarClienteBusq.hidtextDescripcionProblema", get("frmbuscarCliente.hidtextDescripcionProblema") ); 
		set("frmbuscarClienteBusq.hidtextDescripcionSolucion", get("frmbuscarCliente.hidtextDescripcionSolucion") ); 
		set("frmbuscarClienteBusq.hidcbClasificacion", get("frmbuscarCliente.hidcbClasificacion") ); 
		set("frmbuscarClienteBusq.hidtextNegocioProducto", get("frmbuscarCliente.hidtextNegocioProducto") ); 
		set("frmbuscarClienteBusq.ListaComboClasificacion", get("frmbuscarCliente.ListaComboClasificacion") ); 

		set("frmbuscarClienteBusq.hidcbMarcaContacto", get("frmbuscarCliente.hidcbMarcaContacto") ); 
		set("frmbuscarClienteBusq.hidcbCanalContacto", get("frmbuscarCliente.hidcbCanalContacto") ); 
		set("frmbuscarClienteBusq.hidcbPeriodoPrimerPedido", get("frmbuscarCliente.hidcbPeriodoPrimerPedido") ); 
	*/

}