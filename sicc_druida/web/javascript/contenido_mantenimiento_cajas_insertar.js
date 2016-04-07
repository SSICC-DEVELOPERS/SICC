 
	function onLoadPag() {
		configurarMenuSecundario("formulario");
		fMostrarMensajeError();

		var oidCanal =  get("formulario.oidCanal");
		if (oidCanal != '') {
		     set("formulario.cbCanal",[oidCanal]);
			 set("formulario.oidCanal",'');
			  canalOnChange();
		}

		var oidRespCierreCaja =  get("formulario.oidRespCierreCaja");
		if (oidRespCierreCaja != '') {
		 set("formulario.cbRespCierreCaja",[oidRespCierreCaja]);
		 set("formulario.oidRespCierreCaja",'');

		}

		var oidTipoCaja =  get("formulario.oidTipoCaja");
		if (oidTipoCaja != '') {
		 set("formulario.cbTipoCaja",[oidTipoCaja]);
		 set("formulario.oidTipoCaja",'');
		}

		if (get('formulario.accion') == "modificar") {
		     deshabilitarControlesModificar();
		}else if (get('formulario.accion') == "detalle")  {
			deshabilitarControlesDetalle();
		}
	
	}

	function deshabilitarControlesModificar() {
	    accion('formulario.txtCodigoCaja','.disabled=true');
  		accion('formulario.cbCanal','.disabled=true');
		accion('formulario.cbAcceso','.disabled=true');
		accion('formulario.cbSubacceso','.disabled=true');
	}

	function deshabilitarControlesDetalle() {
		deshabilitarControlesModificar();
		accion('formulario.cbRespCierreCaja','.disabled=true');
		accion('formulario.cbTipoCaja','.disabled=true');
	}

	function canalOnChange(){
		var datosNuevo = new Array();
		datosNuevo[0] = ["",""];
		set_combo("formulario.cbSubacceso", datosNuevo);
		set_combo("formulario.cbAcceso", datosNuevo);

		var tipoCanal = get("formulario.cbCanal")[0];
		var idioma = get('formulario.idioma')	;
		var arrayAcceso = new Array();

		arrayAcceso[0] = ["oidCanal", tipoCanal];
		arrayAcceso[1] = ["oidIdioma", idioma];

		recargaCombo('formulario.cbAcceso', 'SEGObtenerAccesosPorCanal', 'es.indra.sicc.dtos.seg.DTOAccesosPorCanal', arrayAcceso, "seleccionaComboAcceso(datos);" );	
			
	}
	
	function seleccionaComboAcceso(datos){

		// Setea espacio en blanco.
		var datosNuevo = new Array();
		datosNuevo[0] = ["",""];

		for (var i = 0; i < datos.length; i++ ) {
		datosNuevo[i+1]  = datos[i];
		}
		// Procede a setear valores en el combo.

		set_combo("formulario.cbAcceso", datosNuevo);
		var acceso  = get("formulario.oidAcceso");
		if (acceso != '') {
		       set("formulario.cbAcceso",[acceso]);
			   set("formulario.oidAcceso",'') ;
			   accesoOnChange();
		}
	}

	function accesoOnChange() {
	    var tipoAcceso= get("formulario.cbAcceso")[0];
		var idioma = get('formulario.idioma')	;

		var arraySubacceso = new Array();	
		arraySubacceso[0] = ["oid", tipoAcceso];
		arraySubacceso[1] = ["oidIdioma", idioma];
		recargaCombo('formulario.cbAcceso', 'SegObtenerSubaccesosPorAcceso', 'es.indra.sicc.util.DTOOID', arraySubacceso, "seleccionaComboSubacceso(datos);" );	
			
	}

	function seleccionaComboSubacceso(datos) {
	    // Setea espacio en blanco.
		var datosNuevo = new Array();
		datosNuevo[0] = ["",""];

		for (var i = 0; i < datos.length; i++ ) {
		datosNuevo[i+1]  = datos[i];
		}
		// Procede a setear valores en el combo.

		set_combo("formulario.cbSubacceso", datosNuevo);
		var subacceso  = get("formulario.oidSubacceso");
		if (subacceso != '') {
		       set("formulario.cbSubacceso",[subacceso]);
			   set("formulario.oidSubacceso", '');
		}
	}

	function fGuardar(){
		/* 
			Si se completaron todos los campos obligatorios de la pantalla{ 
			Llamamos a la LPMantenimientoCaja con accion = "guardar" 
			} Sino{ 
			Se muestra el mensaje de error "El campo XXX es obligatorio" 
			}
		*/

		if( sicc_validaciones_generales() )	 {
			
			eval("formulario").oculto="S";
			set("formulario.conectorAction", "LPMantenimientoCaja");
			set("formulario.accion", "guardar");
			enviaSICC("formulario");
		}
	}

	function reiniciar(opcionMenu) {
			if (opcionMenu == "insertar") {
			      fLimpiar();
			}else{
				 fVolver();
			}
	
	}

	function fLimpiar() {

		var datosNuevo = new Array();
		datosNuevo[0] = ["",""];
		set_combo("formulario.cbSubacceso", datosNuevo);
		set_combo("formulario.cbAcceso", datosNuevo);
	    
		 set("formulario.oidCanal",'');
		 set("formulario.cbCanal",'');

		 set("formulario.oidRespCierreCaja",'');
		 set("formulario.cbRespCierreCaja",'');

		 set("formulario.oidTipoCaja",'');
		 set("formulario.cbTipoCaja",'');

		 set("formulario.oidAcceso",'');
		 set("formulario.cbAcceso",'');

		 
		 set("formulario.oidSubacceso",'');
		 set("formulario.cbSubacceso",'');

		 set("formulario.oidCaja",'');
		 set("formulario.txtCodigoCaja",'');
	}

	function fVolver() {

		if (get('formulario.opcionMenu') == "modificar" && get('formulario.accion')=='guardar' ) {
		     	var obj= completarObjeto();
				window.returnValue= obj  ;	
		}
		window.close();
	}

	  function completarObjeto()  {

		var obj = new Object();
		obj.opcionMenu = get('formulario.opcionMenu');
		obj.idioma =get('formulario.idioma');
		obj.oidRespCierreCaja = get('formulario.cbRespCierreCaja' );
		obj.oidTipoCaja = get('formulario.cbTipoCaja'); 
		obj.respCierreCaja = get('formulario.cbRespCierreCaja','T' );
		obj.tipoCaja = get('formulario.cbTipoCaja', 'T'); 
		return obj;
  }