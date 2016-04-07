/*----------------------------------------------------------------------------------------------------------- */
  function onLoadPag() {
	//DrdEnsanchaConMargenDcho('capa1',24);
	eval (ON_RSZ);
	configurarMenuSecundario("frmFormulario");
	fMostrarMensajeError(); 
	if (get('frmFormulario.hidMostarMensajeExito') == 'true') {
	  GestionarMensaje('264', null , null, null);
	}

	//se llama al metodo limpiar para que cargue los valores por defecto del usuario
	fLimpiar();
  }

/*----------------------------------------------------------------------------------------------------------- */
  function accionGenerar() {
	if(sicc_validaciones_generales() && validaFechas()	  ){
		if (validaIndicadorPago() == 1) {
		  //Llamar a la lp LPGenerarPagoIntercompañias con accion = "generar"
		  set('frmFormulario.accion', 'generar');
		  enviaSICC('frmFormulario');
		  //alert("esta todo ok");
		} else {
		  GestionarMensaje("MAV-003", null, null, null);
		}
	}
  }

/*----------------------------------------------------------------------------------------------------------- */
  function validaFechas(){
	var i = EsFechaValida(get('frmFormulario.txtFechaDesde'), get('frmFormulario.txtFechaHasta'), 'frmFormulario');
	if( i == 0){
	  return true;
	}else if ( i == 1){
	  GestionarMensaje('947',null,null,null);
	  focaliza('frmFormulario.txtFechaDesde');
	  return false;
	}else if( i == 2 ){
	  GestionarMensaje('947',null,null,null);
	  focaliza('frmFormulario.txtFechaHasta');
	  return false;
	}else if( i == 3 ){
	  GestionarMensaje("1007");
	  focaliza('frmFormulario.txtFechaDesde');
	  return false;
	}
}

/*----------------------------------------------------------------------------------------------------------- */
  function marcaOnChange() {
	//if (get('frmFormulario.cbMarca', 'V') != '')      
	  recargaCombos();
  }

/*----------------------------------------------------------------------------------------------------------- */
function canalOnChange() {
	//if (get('frmFormulario.cbCanal', 'V') != '')      
	  recargaCombos();        
  }


/*----------------------------------------------------------------------------------------------------------- */
  function recargaCombos() {

	if (get('frmFormulario.cbCanal', 'V') != '' && get('frmFormulario.cbMarca', 'V') != '') {

		/* Inc. 23074, ssantana, 11/05/2006 */ 
		/* Cuando se termina de ejecutar el enviaOculto, se invoca a "recargaComboActividad"*/ 
		eval("frmFormulario").oculto = "S";
		set("frmFormulario.conectorAction", "LPGenerarPagoIntercompanias");
		set("frmFormulario.accion", "recargarActividades");

		enviaSICC("frmFormulario", null, null, "N");
	  /*recargaCombo('frmFormulario.cbActividad', 
				   'MAVObtieneActividadesMAV', 
				'es.indra.sicc.dtos.mav.DTOActividadMAV', 
				[ ['oidPais', get('frmFormulario.hidPais')], 
				  ['oidIdioma', get('frmFormulario.hidIdioma')],
				  ['oidMarca', get('frmFormulario.cbMarca') ], 
				  ['oidCanal', get('frmFormulario.cbCanal')] ] );*/
	} 
  }

/*----------------------------------------------------------------------------------------------------------- */
 function recargaComboActividad(listaOculta) { 

	 if (listaOculta != null) {
 	    var arrayFinal = new Array();
	    var arrayCombo = new Array();
		var arrayTemp = new Array();
		var array = listaOculta.split("|");
		for (var i=0; i<array.length; i++) {
			var fila = array[i];
			var arrayFila = fila.split(",");
			if (arrayFila[0] == " ") {
				arrayFila[0] = "";
			}
			if (arrayFila[1] == " ") {
				arrayFila[1] = "";
			}
			if (arrayFila[2] == " ") {
				arrayFila[2] = "";
			}

			arrayFinal[i] = [arrayFila[0], arrayFila[1], arrayFila[2] ]; 
			arrayTemp[i] = [arrayFila[0], arrayFila[1] ];
		}
		arrayCombo[0] = ['', ''];
		arrayCombo = arrayCombo.concat(arrayTemp);
		lstActividades = arrayFinal;
		set_combo("frmFormulario.cbActividad", arrayCombo);
	} else {
		/* No hay resultados, limpia el combo Actividades */
		var arrayNuevo = new Array();
		arrayNuevo[0] = ['',''];
		set_combo("frmFormulario.cbActividad", arrayNuevo );
	}
 }

/*----------------------------------------------------------------------------------------------------------- */
  function onBotonTab() {
	focaliza('frmFormulario.cbMarca');
  }

/*----------------------------------------------------------------------------------------------------------- */
  function onShTabMarca() {      
	document.all['btnGenerar'].focus();
  }

/*----------------------------------------------------------------------------------------------------------- */
  function fLimpiar()  {
	/* Limpia las cajas de texto */
	set('frmFormulario.txtFechaDesde', '');
	set('frmFormulario.txtFechaHasta', '');

	var array = new Array();
	array[0] = get('frmFormulario.hidMarca');
	set('frmFormulario.cbMarca',array);
	array = new Array();
	array[0] = get('frmFormulario.hidCanal');
	set('frmFormulario.cbCanal',array);
	focaliza('frmFormulario.cbMarca');
	recargaCombos();

  }

/*----------------------------------------------------------------------------------------------------------- */
  function fGuardar() {      
	accionGenerar();
  }


/*----------------------------------------------------------------------------------------------------------- */
function validaIndicadorPago() {
	/* Nota: Recorre "lstActividades" y recupera el indicador de Pago Intercompanias para la 
	         actividad seleccionada en el Combo. Presupone que siempre habrá un match.. */
	var oidSeleccionado = get("frmFormulario.cbActividad");
	var indPagoIntercompanyas = 0;

	if (oidSeleccionado.length > 0) {
		oidSeleccionado = oidSeleccionado[0];
		/* Busco el oid en lstActividades y obtengo el indicador de de Pago Intercompañias */
		var cantActividades = lstActividades.length;
		var oidEnArray = null;
		var bMatch = false;
		for (var i=0; (i<cantActividades) && (!bMatch); i++) {
			oidEnArray = lstActividades[i][0];
			if (parseInt(oidEnArray, 10) == parseInt(oidSeleccionado, 10)) {
				indPagoIntercompanyas = lstActividades[i][2];
				bMatch = true;
			}
		}
	}
	/*alert("PAgo Intercompañias para actividad " + oidSeleccionado + ": " +indPagoIntercompanyas);*/
	return indPagoIntercompanyas;
}

