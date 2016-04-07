  function onLoadPag() { 
	configurarMenuSecundario("formulario");
	ocultaLista1();
	document.all["btnModificarDiv"].style.visibility='hidden';
    eval(ON_RSZ);	
	fMostrarMensajeError();	  
	focaliza("formulario.txtCodCentroServ");
  }

   function onClickBuscar() {
	 configurarPaginado(mipgndo,'INCBuscarCentrosServicios',
	                            'ConectorObtenerCentroServicio',
								'es.indra.sicc.dtos.inc.DTOCentroServicio', armarArray());	 
	 muestraLista1();
   }

   function armarArray() {
     var vArray = new Array();
	 var i = 0;
	 vArray[i] = new Array('codigo',get('formulario.txtCodCentroServ'));
	 i++;
	 vArray[i] = new Array('descripcion',get('formulario.txtDescripcion'));
	 return vArray; 
   }
      
   function onClickModificar() {
       if(listado1.numSelecc() == 1) {    
             var arrAux = new Array();
			 var obj = new Object();
			 arrAux = listado1.codSeleccionados();
			 var posicion = obtenerPosicionListaEditable(listado1.codSeleccionados(),listado1);
			 var oid = listado1.datos[posicion][0];
			 var codCentroServ = listado1.datos[posicion][1];
			 var descripcion = listado1.datos[posicion][2];
			 var observac = listado1.datos[posicion][3];
			 var casoDeUso = get('formulario.casoDeUso');
			 obj.oid = oid;
			 obj.codCentroServ = codCentroServ;
			 obj.descripcion = descripcion;
			 obj.observac = observac;
			 obj.casoDeUso = casoDeUso;
			 var vWnd = mostrarModalSICC('LPCentrosServicios','modificar centro',obj);
			 if(vWnd != 'LIMPIAR')
 			      onClickBuscar();
       } else {  
		   if(listado1.numSelecc() > 1)
	         cdos_mostrarAlert(GestionarMensaje("240"));          
		   else {
			   if(listado1.numSelecc() < 1)
                  GestionarMensaje("4");
           }
       }
   }
   
   function fBorrar() {
	  if(listado1.numSelecc() < 1)
         GestionarMensaje("4"); // Debe seleccionar al menos un elemento de la lista
      else
	  {
		eliminarFilas(listado1.codSeleccionados(),'INCEliminarCentroServicio',mipgndo);
		//onClickBuscar();
	  }
   }

   function fLimpiar() {     
	   set('formulario.txtCodCentroServ',"");
	   set('formulario.txtDescripcion',"");
       focaliza('formulario.txtCodCentroServ');
   }

   function muestraLista( ultima, rowset, error) {
	    var tamano = rowset.length;
		if (tamano > 0) {  
		   muestraLista1();
		   if(get('formulario.casoDeUso') == 'modificar')
				document.all["btnModificarDiv"].style.visibility='visible';
		   eval (ON_RSZ);      
		   return true;
		} else {
		   ocultaLista1();
		   if(get('formulario.casoDeUso') == 'modificar')
				document.all["btnModificarDiv"].style.visibility='hidden';
		   eval (ON_RSZ);                      
		   return false;
		} 
   }

   function muestraLista1()   {
		DrdEnsanchaConMargenDcho('listado1',12);	    
	    document.all["Cplistado1"].style.visibility='visible';
	    document.all["CpLin1listado1"].style.visibility='visible';
	    document.all["CpLin2listado1"].style.visibility='visible';
	    document.all["CpLin3listado1"].style.visibility='visible';
	    document.all["CpLin4listado1"].style.visibility='visible';
	    document.all["primera1Div"].style.visibility='visible';
	    document.all["ret1Div"].style.visibility='visible';
	    document.all["ava1Div"].style.visibility='visible';
	    document.all["separaDiv"].style.visibility='visible';
	}


	function ocultaLista1()	{
		DrdEnsanchaConMargenDcho('listado1',12);	    
	    document.all["Cplistado1"].style.visibility='hidden';
	    document.all["CpLin1listado1"].style.visibility='hidden';
	    document.all["CpLin2listado1"].style.visibility='hidden';
	    document.all["CpLin3listado1"].style.visibility='hidden';
	    document.all["CpLin4listado1"].style.visibility='hidden';
	    document.all["primera1Div"].style.visibility='hidden';
	    document.all["ret1Div"].style.visibility='hidden';
	    document.all["ava1Div"].style.visibility='hidden';
	    document.all["separaDiv"].style.visibility='hidden';
	}

	function toDetalle1() {
	   if(document.all["btnModificarDiv"].style.visibility == 'visible')           
		   focalizaBotonHTML('botonContenido', 'btnModificar'); 
	   else 
		   focaliza('formulario.txtCodCentroServ');
	   }

	function toDetalle2() {
	   if(document.all["btnModificarDiv"].style.visibility == 'visible')           
		   focalizaBotonHTML('botonContenido', 'btnModificar'); 
	   else 
		   focalizaBotonHTML('botonContenido','btnBuscar')
	   }