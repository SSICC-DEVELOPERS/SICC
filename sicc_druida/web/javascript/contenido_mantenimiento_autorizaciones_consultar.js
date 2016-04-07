function onLoadPag() {
	configurarMenuSecundario('formulario');
	DrdEnsanchaConMargenDcho('listado1',12);
	//var opcionMenu = get('formulario.opcionMenu');	
	ocultaCapas();
	
	eval(ON_RSZ);
	

	/*if (opcionMenu != 'ConsultarAutorizacion') {
		ocultarBotonDetalle();
	} else if (opcionMenu != 'ModificarAutorizacion') {
		ocultarBotonModificar();
	} else if (opcionMenu != 'EliminarAutorizacion') {
		ocultarBotonEliminar();
	}*/
}

//---------------------------------------------------------------------------------------------------

function ocultarBotonDetalle() {
	document.all["btnDetalleDiv"].style.visibility = 'hidden';
}

//---------------------------------------------------------------------------------------------------

function ocultarBotonModificar() {
	document.all["btnModificarDiv"].style.visibility = 'hidden';
}

//---------------------------------------------------------------------------------------------------

function ocultarBotonEliminar() {
	btnProxy(4,'0');
}

//---------------------------------------------------------------------------------------------------

function fBorrar() {
	accionEliminar();
}

//---------------------------------------------------------------------------------------------------

function onChangeOperacion() {
	if (get('formulario.cbCodOperacion') != '') {
		var array = new Array();
		array[array.length] = new Array('oid', get('formulario.cbCodOperacion', 'V'));
		array[array.length] = new Array('oidPais', get('formulario.varPais'));
		array[array.length] = new Array('oidIdioma',get('formulario.varIdioma'));

		recargaCombo('formulario.cbTipoOperacion',
					 'RECRecargaTipoOperacion',
					 'es.indra.sicc.util.DTOOID',
					 array,
					 'setearCbTipoOperacion(datos)');
	} else {
		set_combo('formulario.cbTipoOperacion', new Array(['','']));
	}

}

//---------------------------------------------------------------------------------------------------

function setearCbTipoOperacion(datos) {
	/* Modificacion por ssantana, 08/08/2006, DBLG500001103 */ 
	/* Se agrega un espacio en blanco, en el combo */ 

	var arrayNuevo = new Array();
	arrayNuevo[0] = ['', ''];
	arrayNuevo = arrayNuevo.concat(datos);
	set_combo("formulario.cbTipoOperacion", arrayNuevo);
	/* Fin Modificacion por ssantana, 08/08/2006, DBLG500001103 */ 

	
/*	set_combo("formulario.cbTipoOperacion", datos);*/
}

//---------------------------------------------------------------------------------------------------

function accionBuscar() {
	var parametros = new Array();
	parametros[0] = new Array('oidPais', get('formulario.varPais'));
	parametros[1] = new Array('oidIdioma', get('formulario.varIdioma'));

	var oidUsuario = get('formulario.cbCodUsuario','V');
	if (oidUsuario != null) {
		parametros[parametros.length] = new Array('oidUsuario',oidUsuario);
	}

	var oidOperacion = get('formulario.cbCodOperacion','V');
	if (oidOperacion != null) {
		parametros[parametros.length] = new Array('oidOperacion',oidOperacion);
	}

	var oidTipoOperacion = get('formulario.cbTipoOperacion','V');
	if (oidTipoOperacion != null) {
		parametros[parametros.length] = new Array('oidTipoOperacion',oidTipoOperacion);
	}

	configurarPaginado(mipgndo, 'RECBuscarAutorizaciones', 'ConectorBuscarAutorizaciones',
						'es.indra.sicc.dtos.rec.DTOAutorizacion', parametros);

}


//---------------------------------------------------------------------------------------------------

function accionDetalle() {

   var codigos = new Array();
      
   codigos = listado1.codSeleccionados();
      
   var cant = codigos.length;
      
   var posicion = obtenerPosicionListaEditable(listado1.codSeleccionados(),listado1);	

	if (cant == 1) {
		var obj = new Object();
		for (var i = 0; i < codigos.length; i++)
        {               
			   obj.hOidUsuario = listado1.extraeDato(codigos[i], 7); 
               obj.hOidOperacion = listado1.extraeDato(codigos[i], 8); 
			   //Aqui va la descripcion porque es el detalle nada mas	 
			   obj.hOidTipoOperacion = listado1.extraeDato(codigos[i], 2); 
               obj.hImporteMaximo = listado1.extraeDato(codigos[i], 3); 
               obj.hMontoMaximoDiferencia = listado1.extraeDato(codigos[i], 4); 
               obj.hIngreso = listado1.extraeDato(codigos[i], 5); 
               obj.hDesbloqueo = listado1.extraeDato(codigos[i], 6); 						
        }
		obj.opcionMenu = get('formulario.opcionMenu');
		obj.accion = 'detalle';
		mostrarModalSICC('LPMantenimientoAutorizacion', 'detalle', obj);
      } else    {
          GestionarMensaje('50');
      }
}
   

//--------------------------------------------------------------------------------------------------------------------

    function accionModificar() {

      var codigos = new Array();
      
      codigos = listado1.codSeleccionados();
      
      var cant = codigos.length;
      
      var posicion = obtenerPosicionListaEditable(listado1.codSeleccionados(),listado1);

	if (cant == 1) {
		var obj = new Object();
		for (var i = 0; i < codigos.length; i++)
        {      
			
			   obj.hOid = listado1.extraeDato(codigos[i], 10); 
			   obj.hOidUsuario = listado1.extraeDato(codigos[i], 7); 
               obj.hOidOperacion = listado1.extraeDato(codigos[i], 8); 
			   //Aqui va la descripcion porque es el detalle nada mas	 
			   obj.hOidTipoOperacion = listado1.extraeDato(codigos[i], 2); 
               obj.hImporteMaximo = listado1.extraeDato(codigos[i], 3); 
               obj.hMontoMaximoDiferencia = listado1.extraeDato(codigos[i], 4); 
               obj.hIngreso = listado1.extraeDato(codigos[i], 5); 
               obj.hDesbloqueo = listado1.extraeDato(codigos[i], 6); 						
        }
                  
     	obj.opcionMenu = get('formulario.opcionMenu');
		obj.accion = 'modificar';
	  	var retorno = mostrarModalSICC('LPMantenimientoAutorizacion', 'modificar', obj);
                    
          if (retorno == "modificar"){            
            mipgndo.recargar();          
          }          
      } else    {
          GestionarMensaje('50');
      }
  }
//---------------------------------------------------------------------------------------------------

function accionEliminar() {

      var seleccionados = listado1.codSeleccionados();      
      var oids =  new Array();
      var cantSeleccionados = seleccionados.length;
            
      if (cantSeleccionados == 0){
          GestionarMensaje("4", null, null, null);      
          return;
      }
      
      for (var i = 0; i < seleccionados.length; i++)
      {               
         oids[i] = listado1.extraeDato(seleccionados[i], 10); 
      }
      
      if (cantSeleccionados > 0) {
          eliminarFilas(oids, "RECEliminarAutorizacion", mipgndo);
		  accionBuscar();
      }  
}


//---------------------------------------------------------------------------------------------------

function onTab(elementoActual) {

	if (elementoActual == 'cbCodUsuario') {
		focaliza('formulario.cbCodOperacion');
	} else if (elementoActual == 'cbCodOperacion') {
		focaliza('formulario.cbTipoOperacion');
	} else if (elementoActual == 'cbTipoOperacion') {
        focalizaBotonHTML('botonContenido','btnBuscar');
	} else if (elementoActual == 'btnBuscar') {
		if (document.all["Cplistado1"].style.visibility != 'hidden') {
			var opcionMenu = get('formulario.opcionMenu');
			if (opcionMenu == 'ModificarAutorizacion') {
				focalizaBotonHTML('botonContenido','btnModificar');
			} else if (opcionMenu == 'ConsultarAutorizacion') {
				focalizaBotonHTML('botonContenido','btnDetalle');
			} else if (opcionMenu == 'EliminarAutorizacion') {
				focaliza('formulario.cbCodUsuario');

			}
		} else {
			focaliza('formulario.cbCodUsuario');
		}
	} else if (elementoActual == 'btnModificar' || elementoActual == 'btnDetalle') {
		focaliza('formulario.cbCodUsuario');
	}
}

//---------------------------------------------------------------------------------------------------

function onShiftTab(elementoActual) {
	if (elementoActual == 'cbCodUsuario') {
		if (document.all["Cplistado1"].style.visibility != 'hidden') {
			var opcionMenu = get('formulario.opcionMenu');
			if (opcionMenu == 'ConsultarAutorizacion') {
				focalizaBotonHTML('botonContenido','btnDetalle');
			} else if (opcionMenu == 'ModificarAutorizacion') {
				//focaliza('formulario.btnModificar');
				focalizaBotonHTML('botonContenido','btnModificar');
			} else if (opcionMenu == 'EliminarAutorizacion') {
				//focaliza('formulario.btnBuscar');
				focalizaBotonHTML('botonContenido','btnBuscar');
			}
		} else {
			focalizaBotonHTML('botonContenido','btnBuscar');
		}
	} else if (elementoActual == 'cbCodOperacion') {
		focaliza('formulario.cbCodUsuario');
	} else if (elementoActual == 'cbTipoOperacion') {
		focaliza('formulario.cbCodOperacion');
	} else if (elementoActual == 'btnBuscar') {
		focaliza('formulario.cbTipoOperacion');
	} else if (elementoActual == 'btnModificar' || elementoActual == 'btnDetalle') {
    	focalizaBotonHTML('botonContenido','btnBuscar');
	}
}



//---------------------------------------------------------------------------------------------------




function muestraLista(ultima, rowset) {
        var tamano = rowset.length;
        if (tamano > 0) {
			mostrarLista();
			var i;
			var index = 6;
			var si = GestionarMensaje(84);
			var no = GestionarMensaje(86);
  
			for( i = 0; i < rowset.length; i++ ){
				if(rowset[i][index] == '0')  
					rowset[i][index] = no;
				else if(rowset[i][index] == '1') 
						rowset[i][index] = si;
					 else  rowset[i][index] = '';
			}
 
			index = 7;
			for( i = 0; i < rowset.length; i++ ){
				if(rowset[i][index] == '0')  
					rowset[i][index] = no;
				else if(rowset[i][index] == '1') 
						rowset[i][index] = si;
					 else  rowset[i][index] = '';
			}
			return true; 
        }else{
			   ocultarLista();
			   focaliza('formulario.cbCodUsuario');
               return false;  
        }
 }   

// -------------------------------------------------------------------------------------------------------------------------------------------------------
function reemplazarValores(){
	var codigos = new Array();
    var valor;
    var i;

    codigos=listado1.codigos();

    if( codigos != null && codigos.length > 0 ){
		for( i = 0; i < codigos.length; i++ ){
			valor = codigos.extraeDato( codigos[i], '6' );
			if( valor == '0' ){
				insertaDato( codigos[i], 6, 'NO' );
			}else{
				insertaDato( codigos[i], 6, 'SI' );
			}
		}
		for( i = 0; i < codigos.length; i++ ){
			valor = codigos.extraeDato( codigos[i], '7' );
			if( valor == '0' ){
				insertaDato( codigos[i], 7, 'NO' );
			}else{
				insertaDato( codigos[i], 7, 'SI' );
			}
		}
	}
}


//---------------------------------------------------------------------------------------------------

function mostrarLista(){

	// Cambio los valores 1 y 0 por SI y NO en las columnas Ingreso y Desbloqueo
	
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
    
	if (get('formulario.opcionMenu')=='ConsultarAutorizacion'){ // Para ver detalle
             document.all["btnModificarDiv"].style.visibility='hidden';
             document.all["btnDetalleDiv"].style.visibility='visible';             
    }

    if (get('formulario.opcionMenu')=='ModificarAutorizacion'){ // Para modificar
           document.all["btnModificarDiv"].style.visibility='visible';
           document.all["btnDetalleDiv"].style.visibility='hidden';
    }

    if (get('formulario.opcionMenu')=='EliminarAutorizacion'){ // Para ver detalle
            document.all["btnModificarDiv"].style.visibility='hidden';
            document.all["btnDetalleDiv"].style.visibility='visible';
			btnProxy(4,1);

     }
	
    eval (ON_RSZ);
}

//---------------------------------------------------------------------------------------------------

function ocultarLista() {
    document.all["Cplistado1"].style.visibility='hidden';
    document.all["CpLin1listado1"].style.visibility='hidden';
    document.all["CpLin2listado1" ].style.visibility='hidden';
    document.all["CpLin3listado1"].style.visibility='hidden';
    document.all["CpLin4listado1"].style.visibility='hidden';
    document.all["primera1Div"].style.visibility='hidden';
    document.all["ret1Div"].style.visibility='hidden';
    document.all["ava1Div"].style.visibility='hidden';
    document.all["separaDiv"].style.visibility='hidden';    
    document.all["btnDetalleDiv"].style.visibility='hidden';
    document.all["btnModificarDiv"].style.visibility='hidden';          
    
}


//---------------------------------------------------------------------------------------------------
	
	function ocultaCapas(){
	    document.all["Cplistado1"].style.visibility='hidden';
	    document.all["CpLin1listado1"].style.visibility='hidden';
	    document.all["CpLin2listado1"].style.visibility='hidden';
	    document.all["CpLin3listado1"].style.visibility='hidden';
	    document.all["CpLin4listado1"].style.visibility='hidden';
	    document.all["primera1Div"].style.visibility='hidden';
	    document.all["ret1Div"].style.visibility='hidden';
	    document.all["ava1Div"].style.visibility='hidden';
	    document.all["separaDiv"].style.visibility='hidden';
        document.all["btnDetalleDiv"].style.visibility='hidden';
        document.all["btnModificarDiv"].style.visibility='hidden';        

	}


//---------------------------------------------------------------------------------------------------

function fLimpiar() {

	set('formulario.cbCodUsuario', new Array(''));
	set('formulario.cbCodOperacion', new Array(''));
	//set('formulario.cbTipoOperacion', new Array(''));
	onChangeOperacion();
}


//---------------------------------------------------------------------------------------------------

/*
 * dmorello, 10/07/2006
 * Esta función habilita o deshabilita el botón de avance de la lista editable, según corresponda
 */
function deshabilitarBotonAvance() {
	var largo = listado1.datos.length;
	var ultimoReg = listado1.datos[largo-1][0];
	var totalReg = listado1.datos[0][12];
	if (ultimoReg == totalReg) {
		// Deshabilito el botón Avance
		mipgndo.ava.setTipo(0);
	}
}