 // ----------------------------------------------------------------------------------------------------------------------------------------------------
function onLoadPag() {
   //[1] eval (ON_RSZ); 
   setTimeout('eval (ON_RSZ)',200);
   configurarMenuSecundario("frmUnico");
   fMostrarMensajeError();

   seteaComboTratamiento();
   muestraSeleccionAnterior();
   focaliza("frmUnico.textApellido1", "");

   if (window.dialogArguments) { // Si es modal (se abrió mediante showModalDialog) DBLG500000915
        btnProxy(2,1);  // boton 'volver', habilitado
        btnProxy(3,0);  // boton 'Ir a pantalla de inicio', deshabilitado
   }
}


// ----------------------------------------------------------------------------------------------------------------------------------------------------

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

      else if (pestanya == 1){
        set('frmUnico.accion', 'siguientePestanya1');
      }

      else if (pestanya == 3){   
         set('frmUnico.accion', 'siguientePestanya3');
      }

      else if(pestanya == 4){   
         set('frmUnico.accion', 'siguientePestanya4');
      }

		  var formatoValido = validarFormato();
		  if (formatoValido != false){
				seteaHiddens("frmUnico");
				enviaSICC("frmUnico");
		  }

   }

// ----------------------------------------------------------------------------------------------------------------------------------------------------
	function muestraSeleccionAnterior(){
			var txtApe1 = get("frmUnico.hidtextApellido1");
			var txtApe2 = get("frmUnico.hidtextApellido2");
			var txtApeCasada = get("frmUnico.hidtextApellidoCasada");
			var txtNombre1 = get("frmUnico.hidtextNombre1");
			var txtNombre2 = get("frmUnico.hidtextNombre2");
			var cbTratamiento = get("frmUnico.hidcbTratamiento");
			var rbSexo = get("frmUnico.hidrbSexo");
			var cbFormaPago = get("frmUnico.hidcbFormaPago");
			var txtFechaNacimiento = get("frmUnico.hidtextFechaNacimiento");
			var txtCodEmpleado = get("frmUnico.hidtextCodEmpleado");
			var cbNacionalidad = get("frmUnico.hidcbNacionalidad");
			var cbEstadoCivil = get("frmUnico.hidcbEstadoCivil");
			var textOcupacion = get("frmUnico.hidtextOcupacion");
			var textProfesion = get("frmUnico.hidtextProfesion");
			var textCentroTrabajo  = get("frmUnico.hidtextCentroTrabajo");	
			var textCargoDesempena = get("frmUnico.hidtextCargoDesempena");
			var cbNivelEstudios = get("frmUnico.hidcbNivelEstudios");
			var textCentroEstudios = get("frmUnico.hidtextCentroEstudios");
			var textNHijos = get("frmUnico.hidtextNHijos");
			var textNPersonasDependientes  = get("frmUnico.hidtextNPersonasDependientes");
			var cbNivelSocioEconomico = get("frmUnico.hidcbNivelSocioEconomico");
			var cbCicloVidaFamiliar = get("frmUnico.hidcbCicloVidaFamiliar");
			var rbDeseaCorrespondencia = get("frmUnico.hidrbDeseaCorrespondencia");
			var textImporteIngresoFamiliar = get("frmUnico.hidtextImporteIngresoFamiliar");
			var cbPaisVinculo = get("frmUnico.hidcbPaisVinculo");
			var textClienteVinculo = get("frmUnico.hidtextClienteVinculo");
			var cbTipoVinculo = get("frmUnico.hidcbTipoVinculo");
			var textFechaD = get("frmUnico.hidtextFechaD");
			var textFechaH = get("frmUnico.hidtextFechaH");
			var rbVinculoPrincipal = get("frmUnico.hidrbVinculoPrincipal");
			var cb = get("frmUnico.hidcb");
			var textDescripcion = get("frmUnico.hidtextDescripcion");
			var cbPaisContactado = get("frmUnico.hidcbPaisContactado");
			var textCodClienteContactado = get("frmUnico.hidtextCodClienteContactado");
			var cbTipoClienteContactado = get("frmUnico.hidcbTipoClienteContactado");
			var cbCodTipoContactado = get("frmUnico.hidcbCodTipoContactado");
			var textFechaContacto = get("frmUnico.hidtextFechaContacto");
			var textFecha1PedidoContacto = get("frmUnico.hidtextFecha1PedidoContacto");
			var textFechaSiguienteContacto = get("frmUnico.hidtextFechaSiguienteContacto");
			var txtFechaIngresoActual = get("frmUnico.hidtxtFechaIngresoActual");
			
			var comboMarca = get("frmUnico.hidcbMarcaContacto");
			var comboCanal = get("frmUnico.hidcbCanalContacto");
			var comboPeriodo = get("frmUnico.hidcbPeriodoPrimerPedido");

			set("frmUnico.textApellido1", txtApe1);
			set("frmUnico.textApellido2", txtApe2);
			set("frmUnico.textApellidoCasada", txtApeCasada);
			set("frmUnico.textNombre1", txtNombre1);
			set("frmUnico.textNombre2", txtNombre2);
			set("frmUnico.cbTratamiento", new Array(cbTratamiento) );
			set("frmUnico.rbSexo", rbSexo);
			set("frmUnico.cbFormaPago", new Array(cbFormaPago) );
			set("frmUnico.textFechaNacimiento", txtFechaNacimiento);
			set("frmUnico.textCodEmpleado", txtCodEmpleado);
			set("frmUnico.cbNacionalidad", new Array(cbNacionalidad ) );	
			set("frmUnico.cbEstadoCivil", new Array(cbEstadoCivil) );	
			set("frmUnico.textOcupacion", textOcupacion);	
			set("frmUnico.textProfesion", textProfesion );	
			set("frmUnico.textCentroTrabajo", textCentroTrabajo );	
			set("frmUnico.textCargoDesempena", textCargoDesempena);	
   		set("frmUnico.cbNivelEstudios", new Array( cbNivelEstudios) );
			set("frmUnico.textCentroEstudios", textCentroEstudios );	
			set("frmUnico.textNHijos", textNHijos );	
			set("frmUnico.textNPersonasDependientes", textNPersonasDependientes );	
			set("frmUnico.cbNivelSocioEconomico", new Array(cbNivelSocioEconomico) );	
			set("frmUnico.cbCicloVidaFamiliar", new Array(cbCicloVidaFamiliar) );	
			set("frmUnico.rbDeseaCorrespondencia", rbDeseaCorrespondencia );	
			set("frmUnico.textImporteIngresoFamiliar", textImporteIngresoFamiliar );	
			set("frmUnico.cbPaisVinculo", new Array(cbPaisVinculo) );	
			set("frmUnico.textClienteVinculo", textClienteVinculo );	
			set("frmUnico.cbTipoVinculo", new Array(cbTipoVinculo) );	
			set("frmUnico.textFechaD", textFechaD );	
			set("frmUnico.textFechaH", textFechaH );	
			set("frmUnico.rbVinculoPrincipal", rbVinculoPrincipal);	
			set("frmUnico.cb", new Array(cb) );	
			set("frmUnico.textDescripcion", textDescripcion );	
			set("frmUnico.cbPaisContactado", new Array(cbPaisContactado) );	
			set("frmUnico.textCodClienteContactado", textCodClienteContactado );	
			set("frmUnico.cbTipoClienteContactado", new Array(cbTipoClienteContactado) );	
			set("frmUnico.cbCodTipoContactado", new Array(cbCodTipoContactado) );	
			set("frmUnico.textFechaContacto", textFechaContacto );	
			set("frmUnico.textFecha1PedidoContacto", textFecha1PedidoContacto);	
			set("frmUnico.textFechaSiguienteContacto", textFechaSiguienteContacto);	
			set("frmUnico.txtFechaIngresoActual", txtFechaIngresoActual);

			set("frmUnico.cbMarca", new Array(comboMarca) );
			set("frmUnico.cbCanal", new Array(comboCanal) );

			cambiarPeriodoContacto("reentrando", "cbMarca");
			
			return;
	}

// ----------------------------------------------------------------------------------------------------------------------------------------------------
	function seteaHiddens(formName)
	{
			// Setea los valores en las variables, con los valores de los controles.
			var txtApe1 = get("frmUnico.textApellido1");
			var txtApe2 = get("frmUnico.textApellido2");
			var txtApeCasada = get("frmUnico.textApellidoCasada");
			var txtNombre1 = get("frmUnico.textNombre1");
			var txtNombre2 = get("frmUnico.textNombre2");
			var cbTratamiento = get("frmUnico.cbTratamiento");
			var rbSexo = get("frmUnico.rbSexo");
			var cbFormaPago = get("frmUnico.cbFormaPago");
			var txtFechaNacimiento = get("frmUnico.textFechaNacimiento");
			var txtCodEmpleado = get("frmUnico.textCodEmpleado");
			var cbNacionalidad = get("frmUnico.cbNacionalidad");	
			var cbEstadoCivil = get("frmUnico.cbEstadoCivil");	
			var textOcupacion = get("frmUnico.textOcupacion");	
			var textProfesion = get("frmUnico.textProfesion");	
			var textCentroTrabajo = get("frmUnico.textCentroTrabajo");	
			var textCargoDesempena = get("frmUnico.textCargoDesempena");	
			var cbNivelEstudios = get("frmUnico.cbNivelEstudios");	
			var textCentroEstudios = get("frmUnico.textCentroEstudios");	
			var textNHijos = get("frmUnico.textNHijos");	
			var textNPersonasDependientes = get("frmUnico.textNPersonasDependientes");	
			var cbNivelSocioEconomico = get("frmUnico.cbNivelSocioEconomico");	
			var cbCicloVidaFamiliar = get("frmUnico.cbCicloVidaFamiliar");	
			var rbDeseaCorrespondencia = get("frmUnico.rbDeseaCorrespondencia");	
			var textImporteIngresoFamiliar = get("frmUnico.textImporteIngresoFamiliar");	
			var cbPaisVinculo = get("frmUnico.cbPaisVinculo");	
			var textClienteVinculo = get("frmUnico.textClienteVinculo");	
			var cbTipoVinculo = get("frmUnico.cbTipoVinculo");	
			var textFechaD = get("frmUnico.textFechaD");	
			var textFechaH = get("frmUnico.textFechaH");	
			var rbVinculoPrincipal = get("frmUnico.rbVinculoPrincipal");	
			var cb = get("frmUnico.cb");	
			var textDescripcion = get("frmUnico.textDescripcion");	
			var cbPaisContactado = get("frmUnico.cbPaisContactado");	
			var textCodClienteContactado = get("frmUnico.textCodClienteContactado");	
			var cbTipoClienteContactado = get("frmUnico.cbTipoClienteContactado");	
			var cbCodTipoContactado = get("frmUnico.cbCodTipoContactado");	
			var textFechaContacto = get("frmUnico.textFechaContacto");	
			var textFecha1PedidoContacto = get("frmUnico.textFecha1PedidoContacto");	
			var textFechaSiguienteContacto = get("frmUnico.textFechaSiguienteContacto");	
			var txtFechaIngresoActual = get("frmUnico.txtFechaIngresoActual");

			var comboMarca = get("frmUnico.cbMarca");
			var comboCanal = get("frmUnico.cbCanal");
			var comboPeriodo = get("frmUnico.cbPeriodoPrimerPedido");

			set(formName + ".hidtextApellido1", txtApe1);
			set(formName + ".hidtextApellido2", txtApe2);
			set(formName + ".hidtextApellidoCasada", txtApeCasada);
			set(formName + ".hidtextNombre1", txtNombre1);
			set(formName + ".hidtextNombre2", txtNombre2);
			set(formName + ".hidcbTratamiento", new Array(cbTratamiento) );
			set(formName + ".hidrbSexo", rbSexo);
			set(formName + ".hidcbFormaPago", cbFormaPago);
			set(formName + ".hidtextFechaNacimiento", txtFechaNacimiento);
			set(formName + ".hidtextCodEmpleado", txtCodEmpleado);
			set(formName + ".hidcbNacionalidad", cbNacionalidad);
			set(formName + ".hidcbEstadoCivil", cbEstadoCivil);
			set(formName + ".hidtextOcupacion", textOcupacion);
			set(formName + ".hidtextProfesion", textProfesion);
			set(formName + ".hidtextCargoDesempena", textCargoDesempena);
			set(formName + ".hidcbNivelEstudios", cbNivelEstudios);
			set(formName + ".hidtextCentroEstudios", textCentroEstudios);
			set(formName + ".hidtextNHijos", textNHijos);
			set(formName + ".hidtextNPersonasDependientes", textNPersonasDependientes);
			set(formName + ".hidcbNivelSocioEconomico", cbNivelSocioEconomico);
			set(formName + ".hidcbCicloVidaFamiliar", cbCicloVidaFamiliar);
			set(formName + ".hidrbDeseaCorrespondencia", rbDeseaCorrespondencia);
			set(formName + ".hidtextImporteIngresoFamiliar", textImporteIngresoFamiliar);
			set(formName + ".hidcbPaisVinculo", cbPaisVinculo);
			set(formName + ".hidtextClienteVinculo", textClienteVinculo);
			set(formName + ".hidcbTipoVinculo", cbTipoVinculo);
			set(formName + ".hidtextFechaD", textFechaD);
			set(formName + ".hidtextFechaH", textFechaH);
			set(formName + ".hidrbVinculoPrincipal", rbVinculoPrincipal);
			set(formName + ".hidcb", cb);
			set(formName + ".hidtextDescripcion", textDescripcion);
			set(formName + ".hidcbPaisContactado", cbPaisContactado);
			set(formName + ".hidtextCodClienteContactado", textCodClienteContactado);
			set(formName + ".hidcbTipoClienteContactado", cbTipoClienteContactado);
			set(formName + ".hidcbCodTipoContactado", cbCodTipoContactado);
			set(formName + ".hidtextFechaContacto", textFechaContacto);
			set(formName + ".hidtextFecha1PedidoContacto", textFecha1PedidoContacto);
			set(formName + ".hidtextFechaSiguienteContacto", textFechaSiguienteContacto);
			set(formName + ".hidtxtFechaIngresoActual", txtFechaIngresoActual);

			set(formName + ".hidcbMarcaContacto", comboMarca);
			set(formName + ".hidcbCanalContacto", comboCanal);
			set(formName + ".hidcbPeriodoPrimerPedido", comboPeriodo);

	}

// ----------------------------------------------------------------------------------------------------------------------------------------------------
	function seteaComboTratamiento(){
			var sr = GestionarMensaje("1031", null, null, null);
			var sra = GestionarMensaje("1032", null, null, null);
			var srta = GestionarMensaje("1033", null, null, null);

			var array = new Array();

			array[0] = new Array("0", sr);
			array[1] = new Array("1", sra);
			array[2] = new Array("2", srta);
			
			combo_add("frmUnico.cbTratamiento","1", sr);
			combo_add("frmUnico.cbTratamiento","2", sra);
			combo_add("frmUnico.cbTratamiento","3", srta);


	}

// ----------------------------------------------------------------------------------------------------------------------------------------------------
	function buscar(){
			duplicaFormulario();  // Para obtener los criterios de otras pestañas.
			set("frmUnicoBusq.conectorAction", "LPBusquedaCliente");
			set("frmUnicoBusq.accion", "buscar");

			var formatoValido = validarFormato();
			if (formatoValido != false){
					seteaHiddens("frmUnicoBusq");
					enviaSICC("frmUnicoBusq");
			}

	}

// ----------------------------------------------------------------------------------------------------------------------------------------------------
	function chequeaErrores(){
			var errCod = get("frmUnico.errCodigo");

			if (errCod != ""){
					fMostrarMensajeError();
					return true;
			}

			return false;

	}

	
// ----------------------------------------------------------------------------------------------------------------------------------------------------
	function fLimpiar(){
			//muestraSeleccionAnterior();
			set("frmUnico.textApellido1", "");
			set("frmUnico.textApellido2", "");
			set("frmUnico.textApellidoCasada", "");
			set("frmUnico.textNombre1", "");
			set("frmUnico.textNombre2", "");
			set("frmUnico.cbTratamiento", new Array() );
			set("frmUnico.rbSexo", "");
			set("frmUnico.cbFormaPago", new Array() );
			set("frmUnico.textFechaNacimiento", "");
			set("frmUnico.textCodEmpleado", "");
			set("frmUnico.cbNacionalidad", new Array() );	
			set("frmUnico.cbEstadoCivil", new Array() );	
			set("frmUnico.textOcupacion", "");	
			set("frmUnico.textProfesion", "");	
			set("frmUnico.textCentroTrabajo", "" );	
			set("frmUnico.textCargoDesempena", "");	
   		set("frmUnico.cbNivelEstudios", new Array() );
			set("frmUnico.textCentroEstudios", "" );	
			set("frmUnico.textNHijos", "");	
			set("frmUnico.textNPersonasDependientes", "" );	
			set("frmUnico.cbNivelSocioEconomico", new Array() );	
			set("frmUnico.cbCicloVidaFamiliar", new Array() );	
			set("frmUnico.rbDeseaCorrespondencia", "" );	
			set("frmUnico.textImporteIngresoFamiliar", "" );	
			set("frmUnico.cbPaisVinculo", new Array() );	
			set("frmUnico.textClienteVinculo", "" );	
			set("frmUnico.cbTipoVinculo", new Array() );	
			set("frmUnico.textFechaD", "" );	
			set("frmUnico.textFechaH", "" );	
			set("frmUnico.rbVinculoPrincipal", "");	
			set("frmUnico.cb", new Array() );	
			set("frmUnico.textDescripcion", "" );	
			set("frmUnico.cbPaisContactado", new Array() );	
			set("frmUnico.textCodClienteContactado", "" );	
			set("frmUnico.cbTipoClienteContactado", new Array() );	
			set("frmUnico.cbCodTipoContactado", new Array() );	
			set("frmUnico.textFechaContacto", "" );	
			set("frmUnico.textFecha1PedidoContacto", "");	
			set("frmUnico.textFechaSiguienteContacto", "");	
			set("frmUnico.txtFechaIngresoActual", "");

			set("frmUnico.cbMarca", new Array() );
			set("frmUnico.cbCanal", new Array() );
			set_combo("frmUnico.cbPeriodoPrimerPedido", new Array() );
			focaliza("frmUnico.textApellido1", "");
	}

// ----------------------------------------------------------------------------------------------------------------------------------------------------
	function validarFormato()	{
			var formatoFecha = get("frmUnico.hFormatoFechaPais");
			var valido = true;
			var permitidos = "0123456789";
			var nroHijos = get("frmUnico.textNHijos");
			var nroPersonasDep = get("frmUnico.textNPersonasDependientes");
			var fechaNacimiento = get("frmUnico.textFechaNacimiento");
			var fechaSigContacto = get("frmUnico.textFechaSiguienteContacto");
			var fechaContacto = get("frmUnico.textFechaContacto");
			var fecha1PedidoContacto = get("frmUnico.textFecha1PedidoContacto");
			var fechaDesdeVincu = get("frmUnico.textFechaD");
			var fechaHastaVincu = get("frmUnico.textFechaH");
			var fechaIngreso = get("frmUnico.	txtFechaIngresoActual");

			// Valida Fecha Ingreso
			if ( fechaIngreso  != ""){
				if (! EsFechaValida_SICC(fechaIngreso , "frmUnico")){
					//alert("La fecha es inválida. Fecha 1 Pedido Contacto debe tener el formato " + get("frmUnico.hFormatoFechaPais"));
					GestionarMensaje("1006", formatoFecha, null, null);
					focaliza("frmUnico.txtFechaIngresoActual");
					return false;
				}
			}

			// Valida que Nro de Hijos sea numerico. 
			if (nroHijos != ""){
				valido = validar(nroHijos, permitidos);
				if (valido == false){
					focaliza("frmUnico.textNHijos");
					GestionarMensaje("1514", GestionarMensaje("1516", null, null, null), null, null);
					return valido;
				}
			}

			// Valida que Nro de Personas Dependientes sea numerico.
			if  (nroPersonasDep != ""){
				valido = validar(nroPersonasDep, permitidos);
				if (valido == false){
					focaliza("frmUnico.textNPersonasDependientes");
					GestionarMensaje("1514", GestionarMensaje("1517", null, null, null), null, null);
					return valido;
				}
			}

			// Valida formato de Fecha de Nacimiento
			if  (fechaNacimiento != ""){
				if ( ! EsFechaValida_SICC(fechaNacimiento, "frmUnico")){
					//alert("La fecha es inválida. Fecha Nacimiento debe tener el formato " + get("frmUnico.hFormatoFechaPais"));
				   GestionarMensaje("1006", formatoFecha, null, null);
					focaliza("frmUnico.textFechaNacimiento");
					return false;
				}
			}

      //Valida que importe ingreso familiar sea 8 digitos 2 decimales

       var importeValidado = fValidarFloat(get("frmUnico.textImporteIngresoFamiliar"), 8, 2, false, 0, 999999999999999, false);

       if(importeValidado != 'OK'){    
    
          cdos_mostrarAlert(importeValidado);
          focaliza("frmUnico.textImporteIngresoFamiliar");
          return false;
    
      }

			// Valida Fecha Desde Vinculos 
			if ( fechaDesdeVincu  != ""){
				if (! EsFechaValida_SICC(fechaDesdeVincu , "frmUnico")){
					//alert("La fecha es inválida. Fecha Desde Vinculo debe tener el formato " + get("frmUnico.hFormatoFechaPais"));
					GestionarMensaje("1006", formatoFecha, null, null);
					focaliza("frmUnico.textFechaD");
					return false;
				}
			}

			// Valida Fecha Hasta Vinculos
			if ( fechaHastaVincu  != ""){
				if (! EsFechaValida_SICC(fechaHastaVincu , "frmUnico")){
					//alert("La fecha es inválida. Fecha Desde debe tener el formato " + get("frmUnico.hFormatoFechaPais"));
					GestionarMensaje("1006", formatoFecha, null, null);
					focaliza("frmUnico.textFechaH");
					return false;
				}
			}

			// Valida Fecha Contacto 
			if ( fechaContacto != ""){
				if (! EsFechaValida_SICC(fechaContacto, "frmUnico")){
					//alert("La fecha es inválida. Fecha Sig. Contacto debe tener el formato " + get("frmUnico.hFormatoFechaPais"));
  				   GestionarMensaje("1006", formatoFecha, null, null);
					focaliza("frmUnico.textFechaContacto");
					return false;
				}
			}

			// Valida Fecha 1er PedidoContacto
			if ( fecha1PedidoContacto  != ""){
				if (! EsFechaValida_SICC(fecha1PedidoContacto , "frmUnico")){
					//alert("La fecha es inválida. Fecha 1 Pedido Contacto debe tener el formato " + get("frmUnico.hFormatoFechaPais"));
					GestionarMensaje("1006", formatoFecha, null, null);
					focaliza("frmUnico.textFecha1PedidoContacto");
					return false;
				}
			}

			// Valida FechaSiguiente Contacto
			if ( fechaSigContacto != ""){
				if (! EsFechaValida_SICC(fechaSigContacto, "frmUnico")){
					//alert("La fecha es inválida. Fecha Sig. Contacto debe tener el formato " + get("frmUnico.hFormatoFechaPais"));
					GestionarMensaje("1006", formatoFecha, null, null);
					focaliza("frmUnico.textFechaSiguienteContacto");
					return false;
				}
			}

		return valido;
	}

// ----------------------------------------------------------------------------------------------------------------------------------------------------
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

// ----------------------------------------------------------------------------------------------------------------------------------------------------
function actualizaFechaNacimiento(){
	var formName = "frmUnico";
	var campoFecha = document.getElementById("textFechaNacimiento");
	var edad = 0;
	if(campoFecha.value!=""&&!EsFechaValida_SICC(campoFecha.value, formName)){
		// no es valida la fecha
		GestionarMensaje('1006',get(formName + '.hFormatoFechaPais')); 
		txt_to('lblEdadActual','');	
		focaliza(formName + '.'  + campoFecha.name);
		return;
	}else{
		if(campoFecha.value==""){
			txt_to('lblEdadActual','');	
			return;
		}
		// la fecha es valida. asi que veo como calculo la edad.
		var fecha = campoFecha.value;
		var today = new Date();
		var todayDay = today.getDate() ;
		var todayMonth = (today.getMonth() + 1);
		var todayYear = today.getFullYear();
		var formatoFecha = get(formName + ".hFormatoFechaPais");
            var delim  = obtieneDelimitador(formName);
            var fechaSpliteada = "";
            FechaCortada = fecha.split(delim);
            fechaSpliteada = formatoFecha.split(delim);
		    // Chequea cuál es el año (Y o y), al resto (mes o dia, le agrega ceros si es necesario).
           var formatoArray = new Array(3);
           for (var i = 0; i<3; i++ ){
              formatoArray[i] = parseaFormato(i, formName);
           }	

          var diaMesAgno = "";
          for (var i = 0; i<3 ; i++){
                  diaMesAgno = formatoArray[i];
                  switch (diaMesAgno){
                  case 1:
                            NDiaD = FechaCortada[i];
                            break;
                  case 2:
                            NMesD = FechaCortada[i];
                            break;
                  case 3: 
                        NAnoD = FechaCortada[i];
                            break;
                  }
          }
	    //alert("Dia:" + NDiaD +" Mes:" + NMesD + " Anio:" + NAnoD );
	    //alert("Dia:" + todayDay +" Mes:" + todayMonth + " Anio:" + todayYear );
	    edad= todayYear - NAnoD;
	    if(todayMonth>NMesD){
			// no hago nada
	    }else if (todayMonth<NMesD){
			         // resto un anio a la edad porque todavia no se cumplio
			         edad= edad - 1;
	          }else if (todayMonth==NMesD){
			               // si son iguales debo comprobar los dias
				             if(todayDay>NDiaD){
					              // no hago nada
				             }else if(todayDay<NDiaD){
					                    edad = edad - 1;
                           }
	                }
	       }
	txt_to('lblEdadActual',edad);	
}

// ----------------------------------------------------------------------------------------------------------------------------------------------------
	function seleccionarClienteContactado(flag){
			// flag = "V" - Setea vinculo
			// flag = "C" - Setea contacto.

         var obj = new Object();

         var whnd = mostrarModalSICC('LPBusquedaRapidaCliente','',obj);
         if(whnd!=null){
			var cod = whnd[1];
			//alert(cod);
			if ( flag == "C"){
				set("frmUnico.textCodClienteContactado", cod);
            }else if (flag == "V"){
			    set("frmUnico.textClienteVinculo", cod);
            }
         }
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
		//seteaHiddens();

		set("frmUnico.conectorAction", "LPBusquedaCliente");
		set("frmUnico.accion", "buscarPagina");			

		// Setea los valores en las variables, con los valores de los controles.
		var txtApe1 = get("frmUnico.textApellido1");
		var txtApe2 = get("frmUnico.textApellido2");
		var txtApeCasada = get("frmUnico.textApellidoCasada");
		var txtNombre1 = get("frmUnico.textNombre1");
		var txtNombre2 = get("frmUnico.textNombre2");
		var cbTratamiento = get("frmUnico.cbTratamiento");
		var rbSexo = get("frmUnico.rbSexo");
		var cbFormaPago = get("frmUnico.cbFormaPago");
		var txtFechaNacimiento = get("frmUnico.textFechaNacimiento");
		var txtCodEmpleado = get("frmUnico.textCodEmpleado");
		var cbNacionalidad = get("frmUnico.cbNacionalidad");	
		var cbEstadoCivil = get("frmUnico.cbEstadoCivil");	
		var textOcupacion = get("frmUnico.textOcupacion");	
		var textProfesion = get("frmUnico.textProfesion");	
		var textCentroTrabajo = get("frmUnico.textCentroTrabajo");	
		var textCargoDesempena = get("frmUnico.textCargoDesempena");	
		var cbNivelEstudios = get("frmUnico.cbNivelEstudios");	
		var textCentroEstudios = get("frmUnico.textCentroEstudios");	
		var textNHijos = get("frmUnico.textNHijos");	
		var textNPersonasDependientes = get("frmUnico.textNPersonasDependientes");	
		var cbNivelSocioEconomico = get("frmUnico.cbNivelSocioEconomico");	
		var cbCicloVidaFamiliar = get("frmUnico.cbCicloVidaFamiliar");	
		var rbDeseaCorrespondencia = get("frmUnico.rbDeseaCorrespondencia");	
		var textImporteIngresoFamiliar = get("frmUnico.textImporteIngresoFamiliar");	
		var cbPaisVinculo = get("frmUnico.cbPaisVinculo");	
		var textClienteVinculo = get("frmUnico.textClienteVinculo");	
		var cbTipoVinculo = get("frmUnico.cbTipoVinculo");	
		var textFechaD = get("frmUnico.textFechaD");	
		var textFechaH = get("frmUnico.textFechaH");	
		var rbVinculoPrincipal = get("frmUnico.rbVinculoPrincipal");	
		var cb = get("frmUnico.cb");	
		var textDescripcion = get("frmUnico.textDescripcion");	
		var cbPaisContactado = get("frmUnico.cbPaisContactado");	
		var textCodClienteContactado = get("frmUnico.textCodClienteContactado");	
		var cbTipoClienteContactado = get("frmUnico.cbTipoClienteContactado");	
		var cbCodTipoContactado = get("frmUnico.cbCodTipoContactado");	
		var textFechaContacto = get("frmUnico.textFechaContacto");	
		var textFecha1PedidoContacto = get("frmUnico.textFecha1PedidoContacto");	
		var textFechaSiguienteContacto = get("frmUnico.textFechaSiguienteContacto");	
		var txtFechaIngresoActual = get("frmUnico.txtFechaIngresoActual");

		var comboMarca = get("frmUnico.cbMarca");
		var comboCanal = get("frmUnico.cbCanal");
		var comboPeriodo = get("frmUnico.cbPeriodoPrimerPedido");

		set("frmUnico.hidtextApellido1", txtApe1);
		set("frmUnico.hidtextApellido2", txtApe2);
		set("frmUnico.hidtextApellidoCasada", txtApeCasada);
		set("frmUnico.hidtextNombre1", txtNombre1);
		set("frmUnico.hidtextNombre2", txtNombre2);
		set("frmUnico.hidcbTratamiento", new Array(cbTratamiento) );
		set("frmUnico.hidrbSexo", rbSexo);
		set("frmUnico.hidcbFormaPago", cbFormaPago);
		set("frmUnico.hidtextFechaNacimiento", txtFechaNacimiento);
		set("frmUnico.hidtextCodEmpleado", txtCodEmpleado);
		set("frmUnico.hidcbNacionalidad", cbNacionalidad);
		set("frmUnico.hidcbEstadoCivil", cbEstadoCivil);
		set("frmUnico.hidtextOcupacion", textOcupacion);
		set("frmUnico.hidtextProfesion", textProfesion);
		set("frmUnico.hidtextCargoDesempena", textCargoDesempena);
		set("frmUnico.hidcbNivelEstudios", cbNivelEstudios);
		set("frmUnico.hidtextCentroEstudios", textCentroEstudios);
		set("frmUnico.hidtextNHijos", textNHijos);
		set("frmUnico.hidtextNPersonasDependientes", textNPersonasDependientes);
		set("frmUnico.hidcbNivelSocioEconomico", cbNivelSocioEconomico);
		set("frmUnico.hidcbCicloVidaFamiliar", cbCicloVidaFamiliar);
		set("frmUnico.hidrbDeseaCorrespondencia", rbDeseaCorrespondencia);
		set("frmUnico.hidtextImporteIngresoFamiliar", textImporteIngresoFamiliar);
		set("frmUnico.hidcbPaisVinculo", cbPaisVinculo);
		set("frmUnico.hidtextClienteVinculo", textClienteVinculo);
		set("frmUnico.hidcbTipoVinculo", cbTipoVinculo);
		set("frmUnico.hidtextFechaD", textFechaD);
		set("frmUnico.hidtextFechaH", textFechaH);
		set("frmUnico.hidrbVinculoPrincipal", rbVinculoPrincipal);
		set("frmUnico.hidcb", cb);
		set("frmUnico.hidtextDescripcion", textDescripcion);
		set("frmUnico.hidcbPaisContactado", cbPaisContactado);
		set("frmUnico.hidtextCodClienteContactado", textCodClienteContactado);
		set("frmUnico.hidcbTipoClienteContactado", cbTipoClienteContactado);
		set("frmUnico.hidcbCodTipoContactado", cbCodTipoContactado);
		set("frmUnico.hidtextFechaContacto", textFechaContacto);
		set("frmUnico.hidtextFecha1PedidoContacto", textFecha1PedidoContacto);
		set("frmUnico.hidtextFechaSiguienteContacto", textFechaSiguienteContacto);
		set("frmUnico.hidtxtFechaIngresoActual", txtFechaIngresoActual);

		set("frmUnico.hidcbMarcaContacto", comboMarca);
		set("frmUnico.hidcbCanalContacto", comboCanal);
		set("frmUnico.hidcbPeriodoPrimerPedido", comboPeriodo);


		set("frmUnico.hCadenaParams", cadenaParams);


		enviaSICC("frmUnico");

}


// ----------------------------------------------------------------------------------------------------------------------------------------
function cambiarPeriodoContacto(reentrando, comboCambiado)
{
	// Llamada cuando se cambia el valor de Marca o Canal (en Contacto),
	// o en el Onload (en cuyo caso reentrando debe ser = "reentrando").
	var marcaContacto = get("frmUnico.cbMarca");
	var canalContacto = get("frmUnico.cbCanal");
	var pais = get("frmUnico.paisUsuario");
	var idioma = get("frmUnico.idiomaUsuario");


	//alert("cambiar");

	if ( marcaContacto != "" && canalContacto != "")
	{
		var array = armaArrayPeriodo(idioma, pais, marcaContacto, canalContacto);
		
		//alert("array: " + array);
		if ( reentrando != "reentrando")
			recargaCombo('frmUnico.cbPeriodoPrimerPedido', 'MAEBuscarPeriodos', 'es.indra.sicc.dtos.mae.DTOBusquedaPeriodos', array);
		else
			recargaCombo('frmUnico.cbPeriodoPrimerPedido', 'MAEBuscarPeriodos', 'es.indra.sicc.dtos.mae.DTOBusquedaPeriodos', array, 'cargaPeriodoContacto(datos);' );
	} else  
	{
			// Incluido por Inc. 9648. Si marca no tiene nada, entonces se limpia Canal y Periodo.
			// Si canal no tiene nada, se limpia periodo.

/*			alert("marca: " + marcaContacto);
			alert("canal: " + canalContacto);*/

			if (comboCambiado == 'cbMarca' && marcaContacto == "")  
			{
					set("frmUnico.cbCanal", new Array() );
					set_combo("frmUnico.cbPeriodoPrimerPedido", new Array() );
			}

			if (comboCambiado == 'cbCanal' && canalContacto == "")
					set_combo("frmUnico.cbPeriodoPrimerPedido", new Array() );
			
	}



}

// ----------------------------------------------------------------------------------------------------------------------------------------
function armaArrayPeriodo(idioma, pais, marca, canal)
{

	var array = new Array();

	array[0] = ["oidIdioma", idioma]; 
	array[1] = ["oidPais", pais]; 
	array[2] = ["marca", marca];
	array[3] = ["canal", canal];

	//alert("Array: " + array);

	return array;

}

// ----------------------------------------------------------------------------------------------------------------------------------------
function cargaPeriodoContacto(datos)
{
	var periodo = get("frmUnico.hidcbPeriodoPrimerPedido");
	//alert("periodo Seleccionado: " + periodo);

	// Setea espacio en blanco.
	var datosNuevo = new Array();
	datosNuevo[0] = ["",""];

	for (var i = 0; i < datos.length; i++ )
		datosNuevo[i+1]  = datos[i];


	set_combo("frmUnico.cbPeriodoPrimerPedido", datosNuevo);
	set("frmUnico.cbPeriodoPrimerPedido", new Array(periodo) );

}