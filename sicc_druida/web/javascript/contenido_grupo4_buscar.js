
var varNoLimpiarSICC = true;
 // -----------------------------------------------------------------------------------------------------------------------------------------------
function onLoadPag()
{
  	//alert("oids: " + get("frmUnico.clasOid") );
    setTimeout('eval (ON_RSZ)',200);
    configurarMenuSecundario("frmUnico");
	fMostrarMensajeError();

    muestraSeleccionAnterior();
    focaliza("frmUnico.cbTipoTarjeta", "");

   if (window.dialogArguments) { // Si es modal (se abrió mediante showModalDialog) DBLG500000915
        btnProxy(2,1);  // boton 'volver', habilitado
        btnProxy(3,0);  // boton 'Ir a pantalla de inicio', deshabilitado
    }
		
}

 // -----------------------------------------------------------------------------------------------------------------------------------------------
	function fVolver(){     
					  window.close();
	}

/* -------------------------------------------------------------------------------------------------------------------------------------------- */

 function siguientePestanya(pestanya) {
      
    set('frmUnico.conectorAction', 'LPBusquedaCliente');
      
		if (pestanya == -1){
		  set('frmUnico.accion', "");
       }else if (pestanya == 0){
   	  set('frmUnico.accion', "siguienteTipoSubtipo");
    }else  if(pestanya == 1){   
      set('frmUnico.accion', 'siguientePestanya1');
    }else if (pestanya == 2){
       set('frmUnico.accion', 'siguientePestanya2');
    }else if (pestanya == 3){   
       set('frmUnico.accion', 'siguientePestanya3');
    }

	  seteaHiddens("frmUnico");
            
      enviaSICC('frmUnico');  
   }


 // -----------------------------------------------------------------------------------------------------------------------------------------------
  //funcion que setea el combo clasificaciones en base a la opcion elegida en el combo tipo_clasi
  function buscoClasificaciones() { 
        var combo    = get('frmUnico.cbTipoClasificacion');
        var id       = get('frmUnico.clasOid');
        var desc     = get('frmUnico.clasDesc');
        var tipocla  = get('frmUnico.clasTipoClas');
        id           = id.split(",");
        desc         = desc.split(",");
        tipocla      = tipocla.split(",");
        var longitud = tipocla.length;
        var opciones = new Array();
        var j = 1;

		  //alert(combo);

		  if (combo != ""){
  			  opciones[0] = ["",""];
			  for (i = 0; i < longitud; i++){
					if (tipocla[i] == combo){
						 opciones[j] = [id[i],desc[i]];
						 j++;
					}
			  }
			  if (opciones.length > 0){
					set_combo('frmUnico.cbClasificacion',opciones);
			  } 
		  }else{
				opciones = new Array();
				opciones[0] = ["",""];
				set_combo('frmUnico.cbClasificacion',  opciones);
		  }
                

   }

 // -----------------------------------------------------------------------------------------------------------------------------------------------
	function busca(){
		duplicaFormulario();
		set("frmUnicoBusq.conectorAction", "LPBusquedaCliente")
		set("frmUnicoBusq.accion", "buscar")
		seteaHiddens("frmUnicoBusq");
    //alert('el tipo ' + get('frmUnicoBusq.hiddenTipoCliente'))
    //alert('el subtipo ' + get('frmUnicoBusq.hiddenSubTipoCliente'))
		enviaSICC("frmUnicoBusq");

	}

 // -----------------------------------------------------------------------------------------------------------------------------------------------
  function seteaHiddens(formName) {

  //alert("Setea HIDDENS");
	
	var cbTipoTarjeta = get("frmUnico.cbTipoTarjeta");
	var cbClasesTarjeta = get("frmUnico.cbClasesTarjeta");
	var cbEntidadBancaria = get("frmUnico.cbEntidadBancaria");
	var cbMarcaPestanya4 = get("frmUnico.cbMarca");
	var cbCanal = get("frmUnico.cbCanal");
  var cbTipoClasificacion = get("frmUnico.cbTipoClasificacion");
	var cbTipoProblema = get("frmUnico.cbTipoProblema");
	var rbSolucion = get("frmUnico.rbSolucion");
	var cbTipoSolucion = get("frmUnico.cbTipoSolucion");
	var textDescripcionProblema = get("frmUnico.textDescripcionProblema");
	var textDescripcionSolucion = get("frmUnico.textDescripcionSolucion");
  //alert('la clas antes ' + get("frmUnico.cbClasificacion"));
	var cbClasificacion = get("frmUnico.cbClasificacion");
  //alert('clas ' + cbClasificacion);
	var textNegocioProducto = get("frmUnico.textNegocioProducto");
  var cbTipoCliente       = get("frmUnico.cbTipoCliente");
  var cbSubtipoCliente    = get("frmUnico.cbSubtipoCliente");

	set(formName + ".hidcbTipoTarjeta", cbTipoTarjeta);
	set(formName + ".hidcbClasesTarjeta", cbClasesTarjeta);
	set(formName + ".hidcbEntidadBancaria", cbEntidadBancaria);
	//alert("cbMarcaPestanya4: " + cbMarcaPestanya4);
	set(formName + ".hidcbMarcaPestanya4", cbMarcaPestanya4);
	set(formName + ".hidcbCanal", cbCanal);
	set(formName + ".hidcbTipoClasificacion", cbTipoClasificacion);
	set(formName + ".hidcbTipoProblema", cbTipoProblema);
	set(formName + ".hidrbSolucion", rbSolucion);
	set(formName + ".hidcbTipoSolucion", cbTipoSolucion);
	set(formName + ".hidtextDescripcionProblema", textDescripcionProblema);
	set(formName + ".hidtextDescripcionSolucion", textDescripcionSolucion);
	set(formName + ".hidcbClasificacion", cbClasificacion);
	set(formName + ".hidtextNegocioProducto", textNegocioProducto);
  set(formName + ".hiddenTipoCliente", cbTipoCliente);
  set(formName + ".hiddenSubTipoCliente", cbSubtipoCliente);
  //alert('el tipo ' + get(formName + ".hiddenTipoCliente"));
  //alert('el subtipo ' + get(formName + ".hiddenSubTipoCliente"));
  

  }

 // -----------------------------------------------------------------------------------------------------------------------------------------------
  function muestraSeleccionAnterior(){
	//alert("Muestra Anterior");
	var cbTipoTarjeta = get("frmUnico.hidcbTipoTarjeta");
	var cbClasesTarjeta = get("frmUnico.hidcbClasesTarjeta");
	var cbEntidadBancaria = get("frmUnico.hidcbEntidadBancaria");
	var cbMarcaPestanya4 = get("frmUnico.hidcbMarcaPestanya4");
	var cbCanal = get("frmUnico.hidcbCanal");
	var cbTipoClasificacion = get("frmUnico.hidcbTipoClasificacion");
	var cbTipoProblema = get("frmUnico.hidcbTipoProblema");
	var rbSolucion = get("frmUnico.hidrbSolucion");
	var cbTipoSolucion = get("frmUnico.hidcbTipoSolucion");
	var textDescripcionProblema = get("frmUnico.hidtextDescripcionProblema");
	var textDescripcionSolucion = get("frmUnico.hidtextDescripcionSolucion");
	var cbClasificacion = get("frmUnico.hidcbClasificacion");
	var textNegocioProducto = get("frmUnico.hidtextNegocioProducto");
	

	set("frmUnico.cbTipoTarjeta", new Array(cbTipoTarjeta) );
	set("frmUnico.cbClasesTarjeta", new Array(cbClasesTarjeta) );
	set("frmUnico.cbEntidadBancaria", new Array(cbEntidadBancaria) );
	//alert("cbMarcaPestanya4: " + cbMarcaPestanya4);
	set("frmUnico.cbMarca", new Array(cbMarcaPestanya4) );
	set("frmUnico.cbCanal", new Array(cbCanal) );
	set("frmUnico.cbTipoClasificacion", new Array(cbTipoClasificacion) );
	set("frmUnico.cbTipoProblema", new Array(cbTipoProblema) );
	set("frmUnico.rbSolucion", rbSolucion);
	set("frmUnico.cbTipoSolucion", new Array(cbTipoSolucion) );
	set("frmUnico.textDescripcionProblema", textDescripcionProblema);
	set("frmUnico.textDescripcionSolucion", textDescripcionSolucion);
	set("frmUnico.cbClasificacion", new Array(cbClasificacion) );
	set("frmUnico.textNegocioProducto", textNegocioProducto);
  seteaTipoSubtipo();

  }

  function seteaTipoSubtipo(){

     var tipo              = get('frmUnico.hiddenTipoCliente');
     var subTipo           = get('frmUnico.hiddenSubTipoCliente');
     var tipoClasificacion = get('frmUnico.hidcbTipoClasificacion');
     var clasificacion     = get('frmUnico.hidcbClasificacion');

     if(tipo != ''){
        set('frmUnico.cbTipoCliente',new Array(tipo));
        onChangeTipo();
        set('frmUnico.cbSubtipoCliente',new Array(subTipo));

        if(subTipo != ''){
           onChangeSubtipo();
           set('frmUnico.cbTipoClasificacion',new Array(tipoClasificacion));
           
           if(tipoClasificacion != ''){
              onChangeTipoClasificacion();
              set('frmUnico.cbClasificacion',new Array(clasificacion));
           }
        }
        
     }

  }

 // -----------------------------------------------------------------------------------------------------------------------------------------------
	function chequeaErrores(){
		var errCod = get("frmUnico.errCodigo");

		if (errCod != null){
				fMostrarMensajeError();
				return true;
		}

		return false;

	}

 
 // -----------------------------------------------------------------------------------------------------------------------------------------------
	function fLimpiar(){

		set("frmUnico.cbTipoTarjeta", new Array() );
		set("frmUnico.cbClasesTarjeta", new Array() );
		set("frmUnico.cbEntidadBancaria", new Array() );
		set("frmUnico.cbMarca", new Array() );
		set("frmUnico.cbCanal", new Array() );
		set("frmUnico.cbTipoClasificacion", new Array("") );
		set("frmUnico.cbTipoProblema", new Array("") );
		set("frmUnico.rbSolucion", "");
		set("frmUnico.cbTipoSolucion", new Array() );
		set("frmUnico.textDescripcionProblema", "");
		set("frmUnico.textDescripcionSolucion", "");
		set("frmUnico.cbClasificacion", new Array("") );
		set("frmUnico.textNegocioProducto", "");
      set('frmUnico.cbTipoCliente', new Array() );
      set_combo('frmUnico.cbSubtipoCliente', new Array("","") );
      set_combo('frmUnico.cbTipoClasificacion', new Array("","") );
      set_combo('frmUnico.cbClasificacion', new Array("","") );

		focaliza("frmUnico.cbTipoTarjeta", "");
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

// -------------------------------------------------------------------------------------------------------------------------------------------
function noHayRegistros(){
	//alert("No hay nada");
}

// -------------------------------------------------------------------------------------------------------------------------------------------
function hayRegistros(cadenaParams){
		set("frmUnico.conectorAction", "LPBusquedaCliente");
		set("frmUnico.accion", "buscarPagina");			

		var cbTipoTarjeta = get("frmUnico.cbTipoTarjeta");
		var cbClasesTarjeta = get("frmUnico.cbClasesTarjeta");
		var cbEntidadBancaria = get("frmUnico.cbEntidadBancaria");
		var cbMarcaPestanya4 = get("frmUnico.cbMarca");
		var cbCanal = get("frmUnico.cbCanal");
		var cbTipoClasificacion = get("frmUnico.cbTipoClasificacion");
		var cbTipoProblema = get("frmUnico.cbTipoProblema");
		var rbSolucion = get("frmUnico.rbSolucion");
		var cbTipoSolucion = get("frmUnico.cbTipoSolucion");
		var textDescripcionProblema = get("frmUnico.textDescripcionProblema");
		var textDescripcionSolucion = get("frmUnico.textDescripcionSolucion");
		var cbClasificacion = get("frmUnico.cbClasificacion");
		var textNegocioProducto = get("frmUnico.textNegocioProducto");
    var tipoCliente         = get("frmUnico.cbTipoCliente");
    var subTipoCliente      = get("frmUnico.cbSubtipoCliente");

		set("frmUnico.hidcbTipoTarjeta", cbTipoTarjeta);
		set("frmUnico.hidcbClasesTarjeta", cbClasesTarjeta);
		set("frmUnico.hidcbEntidadBancaria", cbEntidadBancaria);
		set("frmUnico.hidcbMarcaPestanya4", cbMarcaPestanya4);
		set("frmUnico.hidcbCanal", cbCanal);
		set("frmUnico.hidcbTipoClasificacion", cbTipoClasificacion);
		set("frmUnico.hidcbTipoProblema", cbTipoProblema);
		set("frmUnico.hidrbSolucion", rbSolucion);
		set("frmUnico.hidcbTipoSolucion", cbTipoSolucion);
		set("frmUnico.hidtextDescripcionProblema", textDescripcionProblema);
		set("frmUnico.hidtextDescripcionSolucion", textDescripcionSolucion);
		set("frmUnico.hidcbClasificacion", cbClasificacion);
		set("frmUnico.hidtextNegocioProducto", textNegocioProducto);
    set("frmUnico.hiddenTipoCliente", tipoCliente);
    set("frmUnico.hiddenSubTipoCliente", subTipoCliente);

   	    set("frmUnico.hCadenaParams", cadenaParams);

		enviaSICC("frmUnico");

}

/**************************recarga de subtipo******************************************/

        function onChangeTipo(){

          // var combo= window.event.srcElement.getAttribute("NAME");
            
           // var option = window.event.srcElement.options;

            var combo= document.getElementById('cbTipoCliente');
            
            var option = combo.options;
            
            for(var i=0;i<option.length;i++){
              if(option.item(i).getAttribute("selected")){
                         
                  set('frmUnico.nameComboSelectedTipo',combo);
                  set('frmUnico.valueComboSelectedTipo',option.item(i).getAttribute("value"));
                  //alert('el value es ' + get('frmUnico.valueComboSelectedTipo'));
                  var aCombo = new Array(new Array("",""));
                  set_combo('frmUnico.cbSubtipoCliente',aCombo, []);
                  set_combo('frmUnico.cbClasificacion',aCombo, []);
                  set_combo('frmUnico.cbTipoClasificacion',aCombo, []);
             
                  cargarComboSubtipo();
               }
            }
        }

          
        function cargarComboSubtipo(){
           var name = get('frmUnico.nameComboSelectedTipo');
           var cad = new String();
           cad=name;
           var largo = cad.length;
           var Lista  = document.getElementById("cbSubtipoCliente");
                       
           
           for(var k=0;k<listaSubtipos.datos.longitud;k++) {
            if (listaSubtipos.datos.ij(k,0) == get('frmUnico.valueComboSelectedTipo')) {
                        
                 var option = document.createElement("OPTION");
                 Lista.options.add(option);
                 option.innerText=listaSubtipos.datos.ij(k,2);
                 option.value= listaSubtipos.datos.ij(k,1);
              }
           }
                   
        }
       

/**************************************************************************************/
/**************************recarga de tipo clasificacion******************************************/

        function onChangeSubtipo(){
        
            var combo = document.getElementById('cbSubtipoCliente');
            
            var option = combo.options;
            
            for(var i=0;i<option.length;i++){
              if(option.item(i).getAttribute("selected")){
              
                      
                  set('frmUnico.nameComboSelectedSubtipo',combo);
                  set('frmUnico.valueComboSelectedSubtipo',option.item(i).getAttribute("value"));
                  //alert('el value es ' + get('frmUnico.valueComboSelectedTipo'));
                  var aCombo = new Array(new Array("",""));
                  set_combo('frmUnico.cbClasificacion',aCombo, []);
                  set_combo('frmUnico.cbTipoClasificacion',aCombo, []);
                  
                  cargarComboTipoClasificacion();
               }
            }
        }

          
        function cargarComboTipoClasificacion(){
           var name = get('frmUnico.nameComboSelectedSubtipo');
           var cad = new String();
           cad=name;
           var largo = cad.length;
           var Lista  = document.getElementById("cbTipoClasificacion");
           //alert('esta en cargar');
                     
           for(var k=0;k<ListaTipoClasi.datos.longitud;k++) {
            if (ListaTipoClasi.datos.ij(k,1) == get('frmUnico.valueComboSelectedSubtipo')) {
            
                
                 var option = document.createElement("OPTION");
                 Lista.options.add(option);
                 option.innerText=ListaTipoClasi.datos.ij(k,2);
                 option.value= ListaTipoClasi.datos.ij(k,0);
              }
           }
                   
        }
       

/**************************************************************************************/

 /*******************************************************************/
        function onChangeTipoClasificacion(){
            var combo = document.getElementById('cbTipoClasificacion');
            
            var option = combo.options;
            
            for(var i=0;i<option.length;i++){
              if(option.item(i).getAttribute("selected")){
                      
                  set('frmUnico.nameComboSelected',combo);
                  set('frmUnico.valueComboSelected',option.item(i).getAttribute("value"));
                  var aCombo = new Array(new Array("",""));
                  set_combo('frmUnico.cbClasificacion',aCombo, []);
                                    
                  cargarComboClasificacion();
               }
            }
        }

          
        function cargarComboClasificacion(){
           var name = get('frmUnico.nameComboSelected');
           var cad = new String();
           cad=name;
           var largo = cad.length;
           var Lista  = document.getElementById("cbClasificacion");
           //var optionVacia = document.createElement("OPTION");
           //Lista.options.add(optionVacia);
           //optionVacia.innerText = '';
           //optionVacia.value = -1;
           
           
           for(var k=0;k<Lista1.datos.longitud;k++) {
            if (Lista1.datos.ij(k,1) == get('frmUnico.valueComboSelected')) {
                
                 var option = document.createElement("OPTION");
                 Lista.options.add(option);
                 option.innerText=Lista1.datos.ij(k,2);
                 option.value= Lista1.datos.ij(k,0);
              }
           }
                   
        }
       

/*****************************************************************************************************************/        
