	function onLoadPag()   {
		ocultarLista();
		configurarMenuSecundario("formulario");
		fMostrarMensajeError();
		DrdEnsanchaConMargenDcho('listado1',12);
		eval (ON_RSZ);  
		focaliza('formulario.DescripcionMatriz');
	}

	function fBorrar(){
		accionEliminar();
	}

	function ocultarLista() {
		  document.all["Cplistado1"].style.visibility='hidden'; 
		  document.all["CpLin1listado1"].style.visibility='hidden';
		  document.all["CpLin2listado1"].style.visibility='hidden' ;
		  document.all["CpLin3listado1"].style.visibility='hidden' ;
		  document.all["CpLin4listado1"].style.visibility='hidden';
		  document.all["primera1Div"].style.visibility='hidden'; 
		  document.all["ret1Div"].style.visibility='hidden'; 
		  document.all["ava1Div"].style.visibility='hidden';   
		  document.all["separaDiv"].style.visibility='hidden';
        document.all["btnDetalleDiv"].style.visibility='hidden';
		  document.all["btnModificarDiv"].style.visibility='hidden';
	}

	function mostrarLista() {
			document.all["Cplistado1"].style.visibility='visible';
		 document.all["CpLin1listado1"].style.visibility='visible';
		 document.all["CpLin2listado1"].style.visibility='visible';
		 document.all["CpLin3listado1"].style.visibility='visible';
		 document.all["CpLin4listado1"].style.visibility='visible';
		 document.all["primera1Div"].style.visibility='visible';
		 document.all["ret1Div"].style.visibility='visible';
		 document.all["ava1Div"].style.visibility='visible';
		 document.all["separaDiv"].style.visibility='visible';
	     document.all["btnDetalleDiv"].style.visibility='visible';
		  document.all["btnModificarDiv"].style.visibility='hidden';

		 
	 if (get('formulario.casoDeUso')=='modificar' || get('formulario.casoDeUso')=='modifico' )
		 document.all["btnModificarDiv"].style.visibility='visible';

	 if(get('formulario.casoDeUso')=='eliminar')
		 btnProxy(4, '1');	
  }

	function fLimpiar(){
			set("formulario.DescripcionMatriz", "");
			set("formulario.cbMatrizActiva", "");
			focaliza("formulario.DescripcionMatriz");
	}

	function accionBuscar(){
		set("formulario.hidDesc",get("formulario.DescripcionMatriz"));
		set("formulario.hidMat",get("formulario.cbMatrizActiva"));
		var arra = new Array();
		var i = 0;

	   arra[i] = ["descripcionMatriz",get('formulario.DescripcionMatriz')];
		 i++;
		
		if((get("formulario.cbMatrizActiva"))!="")
				arra[i] = ["matrizActiva",get('formulario.cbMatrizActiva')];
		configurarPaginado(mipgndo,"DTOBuscarMatricesDescuentos","ConectorBuscarMatricesDescuentos","es.indra.sicc.dtos.dto.DTOBuscarMatricesDescuento", arra);
	}

	function modificar(){
      var codigos = new Array();
		codigos = listado1.codSeleccionados();
		var cant = codigos.length;
      var posicion = obtenerPosicionListaEditable(listado1.codSeleccionados(),listado1);
		set("formulario.hidOidMatriz", codigos[0]);
		
		 if (cant == 1){
					var obj = new Object();
					obj.hidOidMatriz=codigos[0];
					var salida = mostrarModalSICC('LPMantenimientoMatrizDescuentos',"modificar",obj);
					accionBuscar();
			}else	GestionarMensaje('50');
	}

	function detalle()	{
      var codigos = new Array();
		codigos = listado1.codSeleccionados();
		var cant = codigos.length;
      var posicion = obtenerPosicionListaEditable(listado1.codSeleccionados(),listado1);
		set("formulario.hidOidMatriz", codigos[0]);
		
		 if (cant == 1)	{
					var obj = new Object();
					obj.hidOidMatriz=codigos[0];
				
					mostrarModalSICC('LPMantenimientoMatrizDescuentos',"detalle",obj);
			}	else	GestionarMensaje('50');
	}

	function buscar()	{
		set("formulario.accion", "buscar");
		enviaSICC("LPMantenimientoMatrizDescuentos");
	}

	// Eliminar un conjunto de matriz de decuentos seleccionadas
	function accionEliminar()	{
		var arr = new Array();
		arr = listado1.codSeleccionados();
		eliminarFilas(arr,"DTOEliminarMatricesDescuento", mipgndo, 'resultadoOperacionMsgPersonalizado(datos)');
	}


	//funcion ejecutada por callback en eliminar filas   
	function resultadoOperacionMsgPersonalizado(datos) {
		// Seteo en true para que muestre el mensaje de exito   
		boolResultadoEliminacionSICC = true;   

		//Si hemos recibido un mensaje como resultado de la operación, lo personalizamos
		var mensajeError = "";
		if(datos != null && (typeof(datos)).toUpperCase() == "OBJECT"){
			mensajeError  = datos[0];
		}else if(datos != null && (typeof(datos)).toUpperCase() == "STRING"){
			mensajeError = datos;
		}
		//Personalizamos el mensaje, el cual esta definido por negocio, y no puede ser mosatrado desde parte servidora
		if (mensajeError != "") {
			// Codigo de Error DTO-0020: No se puede eliminar una matriz de descuentos en uso
			mensajeError = GestionarMensaje("DTO-0020");
		}

		if(mensajeError==""){
			if(boolResultadoEliminacionSICC){
				cdos_mostrarConfirm(GestionarMensaje("989"));
			}
		}else{
			mostrarErrorSubsistema(mensajeError );
			return false;
		}
		//Actualizamos los resultados de la búsqueda
		if (objetoPaginado != null) {
			  objetoPaginado.recargar()
		}
		return true;
	}


	function checkTable(){
		if(document.all["Cplistado1"].style.visibility == 'hidden') {
		  focalizaBotonHTML('botonContenido','btnBuscar');
		} else {
		  if(get('formulario.casoDeUso').toString() == "consultar" || get('formulario.casoDeUso').toString() == "eliminar")     
			focalizaBotonHTML('botonContenido','btnDetalle');
		 else
			focalizaBotonHTML('botonContenido','btnModificar');
		}
	}


	function checkTable2(){
		if(document.all["Cplistado1"].style.visibility == 'hidden') {
		  _foc('DescripcionMatriz');
		} else {
		  if(get('formulario.casoDeUso').toString() == "consultar" || get('formulario.casoDeUso').toString() == "eliminar")     
			focalizaBotonHTML('botonContenido','btnDetalle');
		 else
			focalizaBotonHTML('botonContenido','btnModificar');
		}
	}

	function _foc(id) { focaliza('formulario.' + id); }

	function muestraLista( ultima, rowset, error){
		 var tamano = rowset.length;
		 if (tamano > 0) {
		  mostrarLista();
		  var i;
		  var index = 3;
		  var si = GestionarMensaje(85);
		  var no = GestionarMensaje(87);
		
		  for( i = 0; i < rowset.length; i++ ){
			 if(rowset[i][index] == '0')  
			      rowset[i][index] = no;
			    else	if(rowset[i][index] == '1')	
				             rowset[i][index] = si;
				          else  rowset[i][index] = '';
		  }
		  eval (ON_RSZ);
		  focaliza("formulario.DescripcionMatriz"); 
		  return true;
		 } else {
		  focaliza("formulario.DescripcionMatriz");
		  ocultarLista();
		  return false;
		 }
	}

	function prueba(ultima, rowset, error){
    var tamano = rowset.length;
    
		if (tamano > 0) {

		 document.all["Cplistado1"].style.visibility='';
		 document.all["CpLin1listado1"].style.visibility='';
		 document.all["CpLin2listado1"].style.visibility='';
		 document.all["CpLin3listado1"].style.visibility='';
		 document.all["CpLin4listado1"].style.visibility='';
		 document.all["primera1Div"].style.visibility='';
		 document.all["ret1Div"].style.visibility='';
		 document.all["ava1Div"].style.visibility='';
		 document.all["separaDiv"].style.visibility='';
		 //document.all["DetalleDiv"].style.visibility='';
	     document.all["btnDetalleDiv"].style.visibility='visible';
		 eval (ON_RSZ);

		 if (get('formulario.casoDeUso')=='modificar' || get('formulario.casoDeUso')=='modifico' )
		    document.all["btnModificarDiv"].style.visibility='visible';

		 if(get('formulario.casoDeUso')=='eliminar')
			btnProxy(4, '1');	
				
		  var i;
		  var index = 3;
		  var si = GestionarMensaje(85);
		  var no = GestionarMensaje(87);
		
		  for( i = 0; i < rowset.length; i++ ){
			 //reemplazar los valores en matriz activa
			 if(rowset[i][index] == '0')  
			      rowset[i][index] = no;
			    else	if(rowset[i][index] == '1')	
				             rowset[i][index] = si;
				          else  rowset[i][index] = '';
		  }
		
		  return true;
		}  else {

		 document.all["Cplistado1"].style.visibility='hidden';
		 document.all["CpLin1listado1"].style.visibility='hidden';
		 document.all["CpLin2listado1"].style.visibility='hidden';
		 document.all["CpLin3listado1"].style.visibility='hidden';
		 document.all["CpLin4listado1"].style.visibility='hidden';
		 document.all["primera1Div"].style.visibility='hidden';
		 document.all["ret1Div"].style.visibility='hidden';
		 document.all["ava1Div"].style.visibility='hidden';
	     document.all["btnDetalleDiv"].style.visibility='hidden';
		 document.all["btnModificarDiv"].style.visibility='hidden';
         document.all["separaDiv"].style.visibility='hidden';
						
		  focaliza('formulario.DescripcionMatriz','');
		  cdos_mostrarAlert(error);
		  return false;
		}
  } 