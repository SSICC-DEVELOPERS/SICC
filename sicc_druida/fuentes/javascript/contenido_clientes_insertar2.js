var varNoLimpiarSICC = true;

		function cargarPagina(){
    

      DrdEnsanchaConMargenDcho('listado1',12);
		  document.all["CpLin1listado1"].style.visibility='';
		  document.all["CpLin2listado1"].style.visibility='';
		  document.all["CpLin3listado1"].style.visibility='';
		  document.all["CpLin4listado1"].style.visibility='';

		  	setTimeout('eval (ON_RSZ)',200);

			configurarMenuSecundario("frmContenido");

			var hayErrores = chequeaErrores();
			recargaCombos();
			if (hayErrores != true){
					//recargaCombos();
					focaliza("frmContenido.cbTipoCliente", "");
					return;
			}
			//recargaCombos();
			focaliza("frmContenido.cbTipoCliente");

		if (window.dialogArguments) { // Si es modal (se abrió mediante showModalDialog) DBLG500000915
			btnProxy(2,1);  // boton 'volver', habilitado
			btnProxy(3,0);  // boton 'Ir a pantalla de inicio', deshabilitado
		}

	}


  //----------------------------------------------------------------------------

 	function fVolver(){     
					  window.close();
	}

/* -------------------------------------------------------------------------------------------------------------------------------------------- */

  function refreshSubTipo(){

			var oidSubTipo = get("frmContenido.oidSubTipo");
			var descSubTipo = get("frmContenido.descSubTipo");
			var padreSubTipo = get("frmContenido.padreSubTipo");

			var oidTipo = get("frmContenido.cbTipoCliente");

			oidSubTipo = oidSubTipo.split(",");
			descSubTipo = descSubTipo.split(",");
			padreSubTipo = padreSubTipo.split(",");

			var opciones = new Array();
			var longitud = oidSubTipo.length;

			opciones[0] = ["",""];
			var j = 1;

			for ( var i=1 ;  i < longitud; i++){
					if (padreSubTipo[i] == oidTipo){
						opciones[j] = [ oidSubTipo[i], descSubTipo[i] ];
						j++;
					}
			}
			set_combo("frmContenido.cbSubtipoCliente", opciones);
		}
  

// ------------------------------------------------------------------------------

 function siguientePestanya(pestanya){
      
    set("frmContenido.conectorAction", "LPBusquedaCliente");
      
		if (pestanya == -1){
		  set('frmContenido.accion', "");
    } else if (pestanya == 1){
   	   set('frmContenido.accion', "siguientePestanya1");
    }else if (pestanya == 2){
       set('frmContenido.accion', 'siguientePestanya2');
    }else if (pestanya == 3){   
       set('frmContenido.accion', 'siguientePestanya3');
    }else if(pestanya == 4){   
       set('frmContenido.accion', 'siguientePestanya4');
    }
			
	set("frmContenido.conectorAction", "LPBusquedaCliente");
    recolectarValor();
	enviaSICC('frmContenido');  

  }

//--------------------------------------------------------------------------------

  function seteaHiddens(){
		// Setea Hiddens
		//var tipo = get("frmContenido.cbTipoCliente");
		//var subTipo = get("frmContenido.cbSubtipoCliente");

		set("frmContenido.hidTipo", get("frmContenido.cbTipoCliente"));
		set("frmContenido.hidSubTipo", get("frmContenido.cbSubtipoCliente"));

	}
//--------------------------------------------------------------------------------

  function recargaCombos(){
	/*	var tipo = get("frmContenido.hidTipo");
		var subTipo = get("frmContenido.hidSubTipo");
		//alert("Tipo seleccionado anteriormente: " + tipo);

		set("frmContenido.cbTipoCliente", new Array(tipo) );
		refreshSubTipo();

		set("frmContenido.cbSubtipoCliente", new Array(subTipo) );*/

	  var val = get('frmContenido.hidTipoSubtipo');
	  var elems = val.split(";");
	  var cant = Math.round((elems.length-1) / 4);
	  var listaTipoSubtipo = new Array(cant);

	  for(var t=0;t<cant;t++){
		   listaTipoSubtipo[t] = new Array(5);
		   listaTipoSubtipo[t][0] = t+1;
	  }

	  for(var x=0;x<elems.length;x++){
		   var line = elems[x].split("=");
		   //line[0] = h_comboTipo_0
		   //line[1] = 1 - codigo o valor
		   var elem = line[0].split("_");
		  //elem[0] tiene h
		  //elem[1] tiene comboTipoCliente
		  //elem[2] el indice del combo
		  var ind = Math.abs(elem[2]);

		  if(elem[1]=="descTipoCliente"){
			listaTipoSubtipo[ind][1]= line[1];
		  }else if(elem[1]=="descSubtipoCliente"){
			listaTipoSubtipo[ind][2]= line[1];
		  }else if(elem[1]=="comboTipoCliente"){
			listaTipoSubtipo[ind][3]= line[1];
		  }else if(elem[1]=="comboSubtipoCliente"){
			listaTipoSubtipo[ind][4]= line[1];
		  }
	  }

	  for(var g=0;g<cant;g++){
		  listado1.insertar(listaTipoSubtipo[g], true); // [1] pongo true para que no repinte con cada insercion
	  }

    listado1.repinta();

	}

//-------------------------------------------------------------------------------

  function buscar(){
		duplicaFormulario();

		set("frmContenidoBusq.conectorAction", "LPBusquedaCliente");
		set("frmContenidoBusq.accion", "buscar");

		//var tipo = get("frmContenido.cbTipoCliente");
		//var subTipo = get("frmContenido.cbSubtipoCliente");
    recolectarValor();
		var casoDeUso = get("frmContenido.casoDeUso");

		//set("frmContenidoBusq.hidTipo", tipo);
		//set("frmContenidoBusq.hidSubTipo", subTipo);
		set("frmContenidoBusq.casoDeUso", casoDeUso);
		
		enviaSICC("frmContenidoBusq");

	}

//-------------------------------------------------------------------------------

  function chequeaErrores(){
		var errCod = get("frmContenido.errCodigo");

		if (errCod != null){
				fMostrarMensajeError();
				return true;
		}

		return false;

	}

//-------------------------------------------------------------------------------

  function fLimpiar(){
		//recargaCombos();
		set("frmContenido.cbTipoCliente", new Array() );
		set("frmContenido.cbSubtipoCliente", new Array() );
		listado1.setDatos( new Array() );
		//listaTipoSubtipo.repintaDat();

		focaliza("frmContenido.cbTipoCliente", "");
	}

//-------------------------------------------------------------------------------

 function duplicaFormulario(){
		// Duplica formulario 
		frmContenidoBusq.innerHTML = frmContenido.innerHTML;
/*  		set("frmContenidoBusq.accion", get("frmContenido.accion") );
		set("frmContenidoBusq.conectorAction", get("frmContenido.conectorAction") );
		set("frmContenidoBusq.errCodigo", get("frmContenido.errCodigo") );
		set("frmContenidoBusq.errDescripcion", get("frmContenido.errDescripcion") );
		set("frmContenidoBusq.errSeverity", get("frmContenido.errSeverity") );
		set("frmContenidoBusq.casoDeUso", get("frmContenido.casoDeUso") );
		set("frmContenidoBusq.hidCriterioBusqueda1", get("frmContenido.hidCriterioBusqueda1") );
		set("frmContenidoBusq.hidCriterioBusqueda2", get("frmContenido.hidCriterioBusqueda2") );
		set("frmContenidoBusq.hidCriterioBusqueda2", get("frmContenido.hidCriterioBusqueda2") );
		set("frmContenidoBusq.hidTipoSubtipo", get("frmContenido.hidTipoSubtipo") );
    set("frmContenidoBusq.hiddenTipoCliente" ,get("frmContenido.hiddenTipoCliente") );
    set("frmContenidoBusq.hiddenSubTipoCliente" ,get("frmContenido.hiddenSubTipoCliente") );
		set("frmContenidoBusq.hidtextCodCliente", get("frmContenido.hidtextCodCliente") );
		set("frmContenidoBusq.hidcbTipoDocId", get("frmContenido.hidcbTipoDocId") );
		set("frmContenidoBusq.hidtextNDocId", get("frmContenido.hidtextNDocId") );
		set("frmContenidoBusq.hidrbDocPrincipal", get("frmContenido.hidrbDocPrincipal") );
		set("frmContenidoBusq.hidcbPersonaCliente", get("frmContenido.hidcbPersonaCliente") );
		set("frmContenidoBusq.hidtextApellido1", get("frmContenido.hidtextApellido1") );
		set("frmContenidoBusq.hidtextApellido2", get("frmContenido.hidtextApellido2") );
		set("frmContenidoBusq.hidtextApellidoCasada", get("frmContenido.hidtextApellidoCasada") );
		set("frmContenidoBusq.hidtextNombre1", get("frmContenido.hidtextNombre1") );
		set("frmContenidoBusq.hidtextNombre2", get("frmContenido.hidtextNombre2") );
		set("frmContenidoBusq.hidcbTratamiento", get("frmContenido.hidcbTratamiento") );
		set("frmContenidoBusq.hidrbSexo", get("frmContenido.hidrbSexo") );
		set("frmContenidoBusq.hidcbFormaPago", get("frmContenido.hidcbFormaPago") );
		set("frmContenidoBusq.hidtextFechaNacimiento", get("frmContenido.hidtextFechaNacimiento") );
		set("frmContenidoBusq.hidtextCodEmpleado", get("frmContenido.hidtextCodEmpleado") );
		set("frmContenidoBusq.hidcbNacionalidad", get("frmContenido.hidcbNacionalidad") );
		set("frmContenidoBusq.hidcbEstadoCivil", get("frmContenido.hidcbEstadoCivil") );
		set("frmContenidoBusq.hidtextOcupacion", get("frmContenido.hidtextOcupacion") );
		set("frmContenidoBusq.hidtextProfesion", get("frmContenido.hidtextProfesion") );
		set("frmContenidoBusq.hidtextCentroTrabajo", get("frmContenido.hidtextCentroTrabajo") );
		set("frmContenidoBusq.hidtextCargoDesempena", get("frmContenido.hidtextCargoDesempena") );
		set("frmContenidoBusq.hidcbNivelEstudios", get("frmContenido.hidcbNivelEstudios") );
		set("frmContenidoBusq.hidtextCentroEstudios", get("frmContenido.hidtextCentroEstudios") );
		set("frmContenidoBusq.hidtextNHijos", get("frmContenido.hidtextNHijos") );
		set("frmContenidoBusq.hidtextNPersonasDependientes", get("frmContenido.hidtextNPersonasDependientes") );
		set("frmContenidoBusq.hidcbNivelSocioEconomico", get("frmContenido.hidcbNivelSocioEconomico") );
		set("frmContenidoBusq.hidcbCicloVidaFamiliar", get("frmContenido.hidcbCicloVidaFamiliar") );
		set("frmContenidoBusq.hidrbDeseaCorrespondencia", get("frmContenido.hidrbDeseaCorrespondencia") );
		set("frmContenidoBusq.hidtextImporteIngresoFamiliar", get("frmContenido.hidtextImporteIngresoFamiliar") );
		set("frmContenidoBusq.hidcbPaisVinculo", get("frmContenido.hidcbPaisVinculo") );
		set("frmContenidoBusq.hidtextClienteVinculo", get("frmContenido.hidtextClienteVinculo") );
		set("frmContenidoBusq.hidcbTipoVinculo", get("frmContenido.hidcbTipoVinculo") );
		set("frmContenidoBusq.hidtextFechaD", get("frmContenido.hidtextFechaD") );
		set("frmContenidoBusq.hidtextFechaH", get("frmContenido.hidtextFechaH") );
		set("frmContenidoBusq.hidrbVinculoPrincipal", get("frmContenido.hidrbVinculoPrincipal") );
		set("frmContenidoBusq.hidcb", get("frmContenido.hidcb") );
		set("frmContenidoBusq.hidtextDescripcion", get("frmContenido.hidtextDescripcion") );
		set("frmContenidoBusq.hidcbPaisContactado", get("frmContenido.hidcbPaisContactado") );
		set("frmContenidoBusq.hidtextCodClienteContactado", get("frmContenido.hidtextCodClienteContactado") );
		set("frmContenidoBusq.hidcbTipoClienteContactado", get("frmContenido.hidcbTipoClienteContactado") );
		set("frmContenidoBusq.hidcbCodTipoContactado", get("frmContenido.hidcbCodTipoContactado") );
		set("frmContenidoBusq.hidtextFechaContacto", get("frmContenido.hidtextFechaContacto") );
		set("frmContenidoBusq.hidtextFecha1PedidoContacto", get("frmContenido.hidtextFecha1PedidoContacto") );
		set("frmContenidoBusq.hidtextFechaSiguienteContacto", get("frmContenido.hidtextFechaSiguienteContacto") );
		set("frmContenidoBusq.hidtxtFechaIngresoActual", get("frmContenido.hidtxtFechaIngresoActual") ); 

		set("frmContenidoBusq.hidcbTipoDireccion", get("frmContenido.hidcbTipoDireccion") ); 
		set("frmContenidoBusq.hidcbTipoVia", get("frmContenido.hidcbTipoVia") ); 
		set("frmContenidoBusq.hidtextNombreVia", get("frmContenido.hidtextNombreVia") ); 
		set("frmContenidoBusq.hidtextNPrincipal", get("frmContenido.hidtextNPrincipal") ); 
		set("frmContenidoBusq.hidtextCodPostal", get("frmContenido.hidtextCodPostal") ); 
		set("frmContenidoBusq.hidtextInterior", get("frmContenido.hidtextInterior") ); 
		set("frmContenidoBusq.hidtextManzana", get("frmContenido.hidtextManzana") ); 
		set("frmContenidoBusq.hidtextLote", get("frmContenido.hidtextLote") ); 
		set("frmContenidoBusq.hidtextKm", get("frmContenido.hidtextKm") ); 
		set("frmContenidoBusq.hidrbDireccionPrincipal", get("frmContenido.hidrbDireccionPrincipal") ); 
		set("frmContenidoBusq.hidtextObservaciones", get("frmContenido.hidtextObservaciones") ); 
		set("frmContenidoBusq.hidcbTipoComunicacion", get("frmContenido.hidcbTipoComunicacion") ); 
		set("frmContenidoBusq.hidcbDiaComunicacion", get("frmContenido.hidcbDiaComunicacion") ); 
		set("frmContenidoBusq.hidrbComunicacionPrincipal", get("frmContenido.hidrbComunicacionPrincipal") ); 
		set("frmContenidoBusq.hidtextHoraDesde", get("frmContenido.hidtextHoraDesde") ); 
		set("frmContenidoBusq.hidtextHoraHasta", get("frmContenido.hidtextHoraHasta") ); 
		set("frmContenidoBusq.hidcbIntervaloComunicacion", get("frmContenido.hidcbIntervaloComunicacion") ); 
		set("frmContenidoBusq.hidtextTextoComunicacion", get("frmContenido.hidtextTextoComunicacion") ); 
		set("frmContenidoBusq.hidcbMarca", get("frmContenido.hidcbMarca") ); 
		set("frmContenidoBusq.hidcbVia", get("frmContenido.hidcbVia") ); 

		set("frmContenidoBusq.hidcbTipoTarjeta", get("frmContenido.hidcbTipoTarjeta") ); 
		set("frmContenidoBusq.hidcbClasesTarjeta", get("frmContenido.hidcbClasesTarjeta") ); 
		set("frmContenidoBusq.hidcbEntidadBancaria", get("frmContenido.hidcbEntidadBancaria") ); 
		set("frmContenidoBusq.hidcbMarcaPestanya4", get("frmContenido.hidcbMarcaPestanya4") ); 
		set("frmContenidoBusq.hidcbCanal", get("frmContenido.hidcbCanal") ); 
		set("frmContenidoBusq.hidcbTipoClasificacion", get("frmContenido.hidcbTipoClasificacion") ); 
		set("frmContenidoBusq.hidcbTipoProblema", get("frmContenido.hidcbTipoProblema") ); 
		set("frmContenidoBusq.hidrbSolucion", get("frmContenido.hidrbSolucion") ); 
		set("frmContenidoBusq.hidcbTipoSolucion", get("frmContenido.hidcbTipoSolucion") ); 
		set("frmContenidoBusq.hidtextDescripcionProblema", get("frmContenido.hidtextDescripcionProblema") ); 
		set("frmContenidoBusq.hidtextDescripcionSolucion", get("frmContenido.hidtextDescripcionSolucion") ); 
		set("frmContenidoBusq.hidcbClasificacion", get("frmContenido.hidcbClasificacion") ); 
		set("frmContenidoBusq.hidtextNegocioProducto", get("frmContenido.hidtextNegocioProducto") ); 
		set("frmContenidoBusq.ListaComboClasificacion", get("frmContenido.ListaComboClasificacion") ); 

		set("frmContenidoBusq.hidcbMarcaContacto", get("frmContenido.hidcbMarcaContacto") ); 
		set("frmContenidoBusq.hidcbCanalContacto", get("frmContenido.hidcbCanalContacto") ); 
		set("frmContenidoBusq.hidcbPeriodoPrimerPedido", get("frmContenido.hidcbPeriodoPrimerPedido") ); 

*/
}
//-------------------------------------------------------------------------------

  function noHayRegistros(){
	  //alert("No hay nada");
  }

//-------------------------------------------------------------------------------

  function hayRegistros(cadenaParams){
		seteaHiddens();

		set("frmContenido.conectorAction", "LPBusquedaCliente");
		set("frmContenido.accion", "buscarPagina");			
		set("frmContenido.hCadenaParams", cadenaParams);
		//alert("contenido_clientes_insertar2, cadenaParams: " + cadenaParams);

	  recolectarValor();
		var casoDeUso = get("frmContenido.casoDeUso");
		
		set("frmContenido.casoDeUso", casoDeUso);
		
		enviaSICC("frmContenido");
}

//-------------------------------------------------------------------------------

  function aniadirFila(){
      var linea = new Array(); 
      linea.length = 4;
      var comboTipoCliente    = document.getElementById('cbTipoCliente');
      var comboSubTipoCliente = document.getElementById('cbSubTipoCliente');

      if((comboSubTipoCliente.value == '')||(comboTipoCliente.value == '')){
         return ;
      }
      var tipoStr    = comboTipoCliente.options[comboTipoCliente.selectedIndex].text;
      var subTipoStr = comboSubTipoCliente.options[comboSubTipoCliente.selectedIndex].text;
      var oidTipo    = comboTipoCliente.options[comboTipoCliente.selectedIndex].value;
      var oidSubTipo = comboSubTipoCliente.options[comboSubTipoCliente.selectedIndex].value;
      var repetido = false;
      linea[0] = listado1.generaCodigo('');
      linea[1] = tipoStr;
      linea[2] = subTipoStr;
      linea[3] = oidTipo;
      linea[4] = oidSubTipo;

      if((oidTipo == -1)|| (oidSubTipo == -1)){
         return;
      }

      for(var i =0;i < listado1.datos.length;i++) {
         if(oidTipo == listado1.datos[i][3]){
            repetido = true;
			break;
         }
      }

      if(!repetido){
         listado1.insertar(linea,true);
         listado1.repinta();
         comboTipoCliente.selectedIndex = -1;
         var aCombo = new Array(new Array("",""));
         set_combo('frmContenido.cbSubtipoCliente',aCombo, []);
      }else{
         GestionarMensaje('MAE0013');
                  //alert('MAE-0013. El tipo de cliente seleccionado ya se está utilizando para otro subtipo');
      }
      document.getElementById("cbTipoCliente").setActive();
  }

  //----------------------------------------------------------------------------

  function recolectarValor(){
     var valTipoSubTipo = "";
     
	   for(var x=0;x<listado1.datos.length;x++){
	      valTipoSubTipo = valTipoSubTipo + "h_comboTipoCliente_"+x + "=" + listado1.datos[x][3] +";" ;
        if(listado1.datos[x][4] == ""){
           //alert('entro al if');
           valTipoSubTipo = valTipoSubTipo + "h_comboSubtipoCliente_"+x + "= ;" ;
           //alert(valTipoSubTipo);
        }else{
           //alert('entro al else');
           valTipoSubTipo = valTipoSubTipo + "h_comboSubtipoCliente_"+x + "=" + listado1.datos[x][4] +";" ;
        }
        valTipoSubTipo = valTipoSubTipo + "h_descTipoCliente_"+x + "=" + listado1.datos[x][1] +";" ;
        if(listado1.datos[x][2] == ""){
          valTipoSubTipo = valTipoSubTipo + "h_descSubtipoCliente_"+x + "= ;" ;
        }else{
          valTipoSubTipo = valTipoSubTipo + "h_descSubtipoCliente_"+x + "=" + listado1.datos[x][2] +";" ;
        }
        
     }

     //alert('los tipos son ' + valTipoSubTipo);
     set('frmContenido.hidTipoSubtipo', valTipoSubTipo );
     set('frmContenidoBusq.hidTipoSubtipo', valTipoSubTipo );
     //alert(get('frmContenidoBusq.hidTipoSubtipo'));
         	
}

  //----------------------------------------------------------------------------

  function fBorrar()
  {
     if(!listado1.numSelecc() == 0){		
        listado1.eliminarSelecc();        
     }else{
		    GestionarMensaje('50');
	   }   
  }