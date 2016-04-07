	var FORMULARIO = 'formulario';
	var casoUso = null;

	//Un cambio para compilar
  	function onLoadPag() {
		casoUso = get(FORMULARIO + '.casodeuso');  	  
		if (get(FORMULARIO + '.errDescripcion') != '') {
			var wnd = fMostrarMensajeError(get(FORMULARIO + '.errCodigo'),get(FORMULARIO + '.errDescripcion'));
		}

		menuSecundario();
        focaliza(FORMULARIO+'.cbCanal','');
   }
   
	function menuSecundario() {
		configurarMenuSecundario(FORMULARIO);
	}
   

	function accionBuscar() {
		//Llamamos a configurarPaginado pasandole los siguientes parametros: el objeto paginado de la lista resultados, 
		//"BELBuscarMediosPagoBelcenter", 
		//"ConectorBuscarMediosPagoBelcenter", "DTOEBuscarMediosPagoBelcenter" y un 
		//array con los parametros del dto obteniendo los valores de los campos correspondientes de la pantalla. 
		var idioma = get(FORMULARIO+'.idioma');
		var pais = get(FORMULARIO+'.pais');
		var acceso = get(FORMULARIO+'.cbAcceso');
		var canal = get(FORMULARIO+'.cbCanal');
		var subacceso = get(FORMULARIO+'.cbSubacceso');
		var tipoMediosPago = get(FORMULARIO+'.cbTipoMediosPago');
		var codMedioPago = get(FORMULARIO+'.txtCodMedioPago');
		
		var descripcionMedioPago = get(FORMULARIO+'.txtDescripcionMedioPago');
		if (get(FORMULARIO+'.casodeuso') == 'eliminar')
    			btnProxy(4, 0); 

		configurarPaginado(mipgndo, "BELBuscarMediosPagoBelcenter", "ConectorBuscarMediosPagoBelcenter", "es.indra.sicc.dtos.bel.DTOEBuscarMediosPagoBelcenter", [["oidPais", pais], ["oidIdioma", idioma], ["oidCanal", canal], ["oidAcceso", acceso], ["oidTipoMedioPago", tipoMediosPago], ["oidSubacceso", subacceso], ["codigoMedioPago", codMedioPago], ["descripcion", descripcionMedioPago]]); 
	}

	function visibleLista() {
          visibilidad('capaLista','V');
          DrdEnsanchaConMargenDcho('listado1',12);
          eval (ON_RSZ);
	}

	function ocultaLista() {
		visibilidad('capaLista','O');
	}

	function muestraLista(ultima, rowset) {
          var tamano = rowset.length;
          if (tamano > 0) {
                    visibleLista();
    			if (get(FORMULARIO+'.casodeuso') == 'eliminar')
                  		btnProxy(4, 1);

                    return true;
          } else {
                    ocultaLista();
                    focaliza(FORMULARIO+'.cbCanal','');
                    return false;
          }
	}

	function fLimpiar() {
  		//ocultaLista();
  		//listado1.datos = new Array();
		limpiaCombosDependientes();
	}

	function limpiaCombosDependientes() {
		vaciaCombo(FORMULARIO + '.cbAcceso');
		vaciaCombo(FORMULARIO + '.cbSubacceso');
	}
	
	function fVolver() {
     	    	window.close();
	}

/*
SE ELIMINA EL BOTON DETALLE, INCIDENCIA 15580

	function accionDetalle() {
		if (listado1.numSelecc() == 0) {
			//Mostramos mensaje de error 
			GestionarMensaje('50');
			

		} else {
			if (listado1.numSelecc() != 1 ) {
				//Muesta el mensaje: "Debe seleccionar un solo registro"
				GestionarMensaje('8');
				//Se limpia la lista editable
		                  var seleccion=listado1.codigos();
		                  var i=0;
		                  while(seleccion[i]!=null){
		                  	listado1.deselecciona(i); 
		                  	i++;           
		                  }
			} else {
				//Obtenemos el oid seleccionados
				//set('frmFormulario.oidSeleccionado',listado1.codSeleccionados());
				//Llamos al proceso correspondiente Modal
				var objParams = new Object();
				objParams.listado1 = listado1.codSeleccionados();
				objParams.casodeuso = casoUso;
				mostrarModalSICC('LPMantenimientoMediosPagoBelcenter', 'detalle', objParams, null, null);	
			}
		}
	}

	*/
                   
   function fBorrar () {
		if (listado1.numSelecc() == 0) {
			//Mostramos mensaje de error 
			GestionarMensaje('50');
		} else {
				var oids = listado1.codSeleccionados();
				eliminarFilas(oids, "BELEliminarMediosPagoBelcenter", mipgndo);
		}
	}
  
	function canalOnChange() {
        var canal = get(FORMULARIO+'.cbCanal').toString();
        var idioma = get(FORMULARIO+'.idioma').toString();
        var pais = get(FORMULARIO+'.pais');
		vaciaCombo(FORMULARIO + '.cbAcceso');
		vaciaCombo(FORMULARIO + '.cbSubacceso');
		if (canal != "")
			recargaCombo(FORMULARIO + '.cbAcceso', 'SEGObtenerAccesosPorCanal', 'es.indra.sicc.dtos.seg.DTOAccesosPorCanal',  [["oidPais", pais], ["oidIdioma", idioma], ["oidCanal", canal]]);
	}

	function accesoOnChange() {
        var acceso = get(FORMULARIO+'.cbAcceso').toString();
        var idioma = get(FORMULARIO+'.idioma').toString();
        var pais = get(FORMULARIO+'.pais');
		vaciaCombo(FORMULARIO + '.cbSubacceso');
		if (acceso != "")
			recargaCombo(FORMULARIO + '.cbSubacceso', 'SegObtenerSubaccesosPorAcceso', 'es.indra.sicc.util.DTOOID',  [["oidPais", pais], ["oidIdioma", idioma], ["oid", acceso]]);
	}

	function vaciaCombo(combo) {
		if (eval('document.'+combo) != undefined) 
			set_combo(combo,[['','']],['']);
		return true;
	}

	function focalizaAnteriorCanal(combo) {
/*		if (get_visibilidad("capaLista"))  
			document.all['Detalle'].focus();
		else*/
			document.all['btnBuscar'].focus();
	}

	function focalizaSiguienteBuscar(combo) {
/*		if (get_visibilidad("capaLista"))  
			document.all['Detalle'].focus();
		else*/
            focaliza(FORMULARIO + ".cbCanal");
	}

function mayusculas(){
         var codigo = get(FORMULARIO +'.txtCodMedioPago');
         if(codigo != ""){
                  set(FORMULARIO +'.txtCodMedioPago',get(FORMULARIO +'.txtCodMedioPago').toUpperCase());
         }
}