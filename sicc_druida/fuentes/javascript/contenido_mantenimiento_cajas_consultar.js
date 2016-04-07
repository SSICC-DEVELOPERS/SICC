
		function onLoadPag() {
			configurarMenuSecundario("formulario");
			fMostrarMensajeError();
			ocultaLista();


		}

/* ------------------------------------------------------------------------------------*/
		 function visibleLista() {
			   visibilidad('capaLista','V');
			   DrdEnsanchaConMargenDcho('listado1',12);
			   eval (ON_RSZ);

				document.all["primera1Div"].style.visibility = 'visible';
				document.all["ret1Div"].style.visibility = 'visible';
				document.all["ava1Div"].style.visibility = 'visible';
				document.all["separaDiv"].style.visibility = 'visible';

			   	if(get('formulario.casoUso') == "ConsultarCaja"){
						document.all["DetalleDiv"].style.visibility = 'visible';
						document.all["ModificarDiv"].style.visibility = 'hidden';
				} else {
				   if(get('formulario.casoUso') == "ModificarCaja"){
						document.all["ModificarDiv"].style.visibility = 'visible';
						document.all["DetalleDiv"].style.visibility = 'hidden';
				   } else {
				       	if(get('formulario.casoUso') == "EliminarCaja"){
							document.all["ModificarDiv"].style.visibility = 'hidden';
							document.all["DetalleDiv"].style.visibility = 'hidden';
							btnProxy(4,1); 
						}
				   }
				}
		 }

/* ------------------------------------------------------------------------------------*/
		 function ocultaLista() {
				visibilidad('capaLista','O');
				document.all["primera1Div"].style.visibility = 'hidden';
				document.all["ret1Div"].style.visibility = 'hidden';
				document.all["ava1Div"].style.visibility = 'hidden';
				document.all["separaDiv"].style.visibility = 'hidden';

				document.all["ModificarDiv"].style.visibility='hidden';
				document.all["DetalleDiv"].style.visibility='hidden';

				btnProxy(4,0); 
		 }

/* ------------------------------------------------------------------------------------*/
		 function muestraLista(ultima, rowset) {
			   var tamano = rowset.length;
			   if (tamano > 0) {
						  visibleLista();
						  return true;
			   } else {
						  ocultaLista();
						  focaliza('formulario.cbCanal','');
						  return false;
			   }
		 }

/* ------------------------------------------------------------------------------------*/
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

/* ------------------------------------------------------------------------------------*/	
	function seleccionaComboAcceso(datos){

		// Setea espacio en blanco.
		var datosNuevo = new Array();
		datosNuevo[0] = ["",""];

		for (var i = 0; i < datos.length; i++ )
		datosNuevo[i+1]  = datos[i];

		// Procede a setear valores en el combo.

		set_combo("formulario.cbAcceso", datosNuevo);

	}

/* ------------------------------------------------------------------------------------*/
	function accesoOnChange() {
	    var tipoAcceso= get("formulario.cbAcceso")[0];
		var idioma = get('formulario.idioma')	;

		var arraySubacceso = new Array();	
		arraySubacceso[0] = ["oid", tipoAcceso];
		arraySubacceso[1] = ["oidIdioma", idioma];
		recargaCombo('formulario.cbAcceso', 'SegObtenerSubaccesosPorAcceso', 'es.indra.sicc.util.DTOOID', arraySubacceso, "seleccionaComboSubacceso(datos);" );	
			
	}
  
/* ------------------------------------------------------------------------------------*/
	function seleccionaComboSubacceso(datos) {
	    // Setea espacio en blanco.
		var datosNuevo = new Array();
		datosNuevo[0] = ["",""];

		for (var i = 0; i < datos.length; i++ )
		datosNuevo[i+1]  = datos[i];

		// Procede a setear valores en el combo.

		set_combo("formulario.cbSubacceso", datosNuevo);


	}

/* ------------------------------------------------------------------------------------*/
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



/* ------------------------------------------------------------------------------------*/
function onClickBuscar(){
		

        ocultaLista();
		configurarPaginado(mipgndo,"BELBuscarCajas",
                              "ConectorBuscarCajas",
                              "es.indra.sicc.dtos.bel.DTOMantenimientoCaja",
                              armaArray());

}

/*----------------------------------------------------------------------------------*/

function armaArray(){ 
      var arrDatos = new Array();
      var i=0;

	   if (get('formulario.pais')!=''){
           arrDatos[i] = new Array('oidPais',get('formulario.pais'));
           i++;
	  }
      if (get('formulario.idioma')!=''){
           arrDatos[i] = new Array('oidIdioma',get('formulario.idioma'));
           i++;
	  }
	  if (get('formulario.cbCanal')!=''){
           arrDatos[i] = new Array('oidCanal',get('formulario.cbCanal'));
           i++;
	  }

	  if (get('formulario.cbAcceso')!=''){
           arrDatos[i] = new Array('oidAcceso',get('formulario.cbAcceso')[0]);
           i++;
	  }
	  if (get('formulario.cbSubacceso')!=''){
           arrDatos[i] = new Array('oidSubacceso',get('formulario.cbSubacceso'));
           i++;
	  }
	 if (get('formulario.txtCodigoCaja')!=''){
           arrDatos[i] = new Array('codigoCaja',get('formulario.txtCodigoCaja'));
           i++;
	  }
	 if (get('formulario.cbRespCierreCaja')!=''){
           arrDatos[i] = new Array('oidRespCierreCaja',get('formulario.cbRespCierreCaja'));
           i++;
	  }
	 if (get('formulario.cbTipoCaja')!=''){
           arrDatos[i] = new Array('oidTipoCaja',get('formulario.cbTipoCaja'));
           i++;
	  }

      return arrDatos;
                    
  }

/*----------------------------------------------------------------------------------*/
  function onClickDetalle(){
	   var seleccionados = listado1.codSeleccionados();


		if( seleccionados.length == 1 ){
			var obj =  completarObjeto();
			mostrarModalSICC('LPMantenimientoCaja',"detalle",obj,800,350);
		
		}else if( seleccionados.length > 1 ){
			GestionarMensaje('8');
		}else{
			GestionarMensaje('4');
		}
  }

  /*----------------------------------------------------------------------------------*/
  function completarObjeto()  {

  		var codigos = new Array();
		codigos = listado1.codSeleccionados();

		var obj = new Object();
		 obj.opcionMenu = get('formulario.opcionMenu');
		 obj.idioma =get('formulario.idioma');
	    obj.codCaja = listado1.extraeDato (codigos[0],3);
		obj.oidCaja =	listado1.extraeDato (codigos[0],12); 	   
		obj.oidPais=listado1.extraeDato (codigos[0],11); 
		obj.oidCanal=	listado1.extraeDato (codigos[0],6); 
		obj.oidAcceso=	listado1.extraeDato (codigos[0],7); 
		obj.oidSubacceso=listado1.extraeDato (codigos[0],8);
		obj.oidRespCierreCaja = listado1.extraeDato (codigos[0],9);
		obj.oidTipoCaja = listado1.extraeDato (codigos[0],10);

		return obj;
  }

  /*----------------------------------------------------------------------------------*/
function  onClickModificar() {

	 	 var seleccionados = listado1.codSeleccionados();
		if( seleccionados.length == 1 ){
			var obj =  completarObjeto();
			
			var resultado = mostrarModalSICC('LPMantenimientoCaja',"modificar",obj,800,350);
			actualizarLista(resultado, seleccionados);

		}else if( seleccionados.length > 1 ){
			GestionarMensaje('8');
		}else{
			GestionarMensaje('4');
		}
 }
  /*----------------------------------------------------------------------------------*/
	function fBorrar(){
		var seleccionados = listado1.codSeleccionados();

		if (seleccionados.length == 0){
			GestionarMensaje("4", null, null, null);
			return;
		}

		var  hOidsEliminar = new Array();
		for(var i=0 ;i<seleccionados.length;i++)	{
			hOidsEliminar[i] = listado1.extraeDato (seleccionados[i],12); 	
		}

		eval("formulario").oculto="S";
		set("formulario.hOidsEliminar","[" + hOidsEliminar + "]");

		set("formulario.conectorAction", "LPMantenimientoCaja");
		set("formulario.accion", "eliminar");
		enviaSICC("formulario");

	}

   /*----------------------------------------------------------------------------------*/
	function actualizarLista(resultado, seleccionados){
		var oidFilaAModificar = seleccionados[0];  
		  if (resultado != null ) {
             listado1.insertaDato(oidFilaAModificar, 10, resultado.oidTipoCaja); //codigoCliente
             listado1.insertaDato(oidFilaAModificar, 9, resultado.oidRespCierreCaja); //pregunta
             listado1.insertaDato(oidFilaAModificar, 4, resultado.respCierreCaja); //respuesta
			 listado1.insertaDato(oidFilaAModificar, 5, resultado.tipoCaja); //respuesta
         }

	}
