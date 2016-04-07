function onLoadPag(){
	configurarMenuSecundario('formulario');
		var accion = get('formulario.accion');
		var opcionMenu = get('formulario.opcionMenu');

	if (get('formulario.opcionMenu') == 'ConsultarAutorizacion') {
		// Deshabilito el boton Guardar		
		btnProxy(1,'0');		
	}

	var si = GestionarMensaje(84);
	var no = GestionarMensaje(86);


	if (accion == 'modificar') {
       cargarCombosUsuario();              
       cargarCombosOperacion();
       cargarCombosTipoOperacionDetalle();

       set('formulario.txtImporteMax',get('formulario.hImporteMaximo'));
       set('formulario.txtMontoMaxDiferencia',get('formulario.hMontoMaximoDiferencia'));

	   var ingr = get('formulario.hIngreso');
   	  var desb = get('formulario.hDesbloqueo');
	  if (ingr == si) {
			set('formulario.rbIngreso','S');
	  }else if (ingr == no || ingr == '') {
			set('formulario.rbIngreso','N');
	  }	

	  if (desb == si) {
			set('formulario.rbDesbloqueo','S');
	  }else if (desb == no || desb == '') {
			set('formulario.rbDesbloqueo','N');		
	  }

       deshabilitarCombos();
       focaliza('formulario.txtImporteMax');

	} else if (accion == 'detalle') {
	   cargarCombosUsuario();              
       cargarCombosOperacion();
       cargarCombosTipoOperacionDetalle();
       set('formulario.txtImporteMax',get('formulario.hImporteMaximo'));
       set('formulario.txtMontoMaxDiferencia',get('formulario.hMontoMaximoDiferencia'));

	   var ingr = get('formulario.hIngreso');
   	  var desb = get('formulario.hDesbloqueo');
	  if (ingr == si) {
			set('formulario.rbIngreso','S');
	  }else if (ingr == no || ingr == '') {
			set('formulario.rbIngreso','N');
	  }	

	  if (desb == si) {
			set('formulario.rbDesbloqueo','S');
	  }else if (desb == no || desb == '') {
			set('formulario.rbDesbloqueo','N');		
	  }
	  
	   deshabilitarTodos();	
	} else if (accion == '') {		
		    set('formulario.rbIngreso','N');
			set('formulario.rbDesbloqueo','N');
			focaliza('formulario.cbCodUsuario');
	}
}

  function cargarCombosUsuario(){
    iSeleccionado = new Array(); 
    iSeleccionado[0] = get('formulario.hOidUsuario'); 
	set('formulario.cbCodUsuario',iSeleccionado); 
  }

  function cargarCombosOperacion(){
    iSeleccionado = new Array(); 
    iSeleccionado[0] = get('formulario.hOidOperacion'); 
    set('formulario.cbCodOperacion',iSeleccionado); 
  }

  function cargarCombosTipoOperacionDetalle(){
    var iSeleccionado = get('formulario.hOidTipoOperacion'); 
	//set_combo('F1.C1', [ ["cod0","Si"],["cod1","No"] ], ["cod1"]) 
    //set_combo(nombreCombo, arrayDeOpciones, arrayDeOpcionesSeleccionadas)
	set_combo('formulario.cbTipoOperacion',[["1",iSeleccionado]],["1"]);	
	
  }



//------------------------------------------------------------------------------------------------------------

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


//------------------------------------------------------------------------------------------------------------

function setearCbTipoOperacion(datos) {
	set_combo("formulario.cbTipoOperacion", datos);
}


//------------------------------------------------------------------------------------------------------------

function fGuardar(){

	if (! sicc_validaciones_generales()) {
		return false;
	}

	// Paso los valores de los campos a las variables hidden
	set('formulario.hOidUsuario', get('formulario.cbCodUsuario', 'V'));
	set('formulario.hOidOperacion', get('formulario.cbCodOperacion', 'V'));
	set('formulario.hOidTipoOperacion', get('formulario.cbTipoOperacion', 'V'));
	set('formulario.hImporteMaximo', numeroDeFormatoSICC(get('formulario.txtImporteMax')));
	set('formulario.hMontoMaximoDiferencia', numeroDeFormatoSICC(get('formulario.txtMontoMaxDiferencia')));
	set('formulario.hIngreso', get('formulario.rbIngreso'));
	set('formulario.hDesbloqueo', get('formulario.rbDesbloqueo'));


	// Envio el formulario
	eval('formulario').oculto = 'S';
	set('formulario.conectorAction',"LPMantenimientoAutorizacion");
	set('formulario.accion','guardar');
	enviaSICC('formulario');
}

//------------------------------------------------------------------------------------------------------------

/*
 * Esta funcion se ocupa de deshabilitar los combos cbCodUsuario, cbCodOperacion y cbTipoOperacion
 * y focaliza el campo txtImporteMax
 */
function deshabilitarCombos() {
	accion('formulario.cbCodUsuario','.disabled = true');
	accion('formulario.cbCodOperacion','.disabled = true');
	accion('formulario.cbTipoOperacion','.disabled = true');
}

//------------------------------------------------------------------------------------------------------------

/*
 * Esta funcion se ocupa de deshabilitar los combos cbCodUsuario, cbCodOperacion y cbTipoOperacion
 * y focaliza el campo txtImporteMax
 */
function deshabilitarTodos() {
	deshabilitarCombos();
	accion('formulario.txtImporteMax','.disabled = true');
	accion('formulario.txtMontoMaxDiferencia','.disabled = true');
	accion('formulario.rbIngreso','[1].disabled = true');
	accion('formulario.rbIngreso','[0].disabled = true');
	accion('formulario.rbDesbloqueo','[1].disabled = true');
	accion('formulario.rbDesbloqueo','[0].disabled = true');


}


//------------------------------------------------------------------------------------------------------------

function fVolver() {
	window.close();
}

//------------------------------------------------------------------------------------------------------------

function onTab(campoActual) {

	if (campoActual == 'cbCodUsuario') {
		focaliza('formulario.cbCodOperacion');
	} else if (campoActual == 'cbCodOperacion') {
		focaliza('formulario.cbTipoOperacion');
	} else if (campoActual == 'cbTipoOperacion') {
		focaliza('formulario.txtImporteMax');
	} else if (campoActual == 'txtImporteMax') {
		focaliza('formulario.txtMontoMaxDiferencia');
	} else if (campoActual == 'txtMontoMaxDiferencia') {
		focaliza('formulario.rbIngreso');
	} else if (campoActual == 'rbIngreso') {
		focaliza('formulario.rbDesbloqueo');
	} else if (campoActual == 'rbDesbloqueo') {
		if (get('formulario.opcionMenu') == 'InsertarAutorizacion') {
			focaliza('formulario.cbCodUsuario');
		} else {
			focaliza('formulario.txtImporteMax');
		}
	}
}


//------------------------------------------------------------------------------------------------------------

function onShiftTab(campoActual) {
	if (campoActual == 'cbCodUsuario') {
		focaliza('formulario.rbDesbloqueo');
	} else if (campoActual == 'cbCodOperacion') {
		focaliza('formulario.cbCodUsuario');
	} else if (campoActual == 'cbTipoOperacion') {
		focaliza('formulario.cbCodOperacion');
	} else if (campoActual == 'txtImporteMax') {
		if (get('formulario.opcionMenu') == 'InsertarAutorizacion') {
			focaliza('formulario.cbTipoOperacion');
		} else {
			focaliza('formulario.rbDesbloqueo');
		}
	} else if (campoActual == 'txtMontoMaxDiferencia') {
		focaliza('formulario.txtImporteMax');
	} else if (campoActual == 'rbIngreso') {
		focaliza('formulario.txtMontoMaxDiferencia');
	} else if (campoActual == 'rbDesbloqueo') {
		focaliza('formulario.rbIngreso');
	}
}

//------------------------------------------------------------------------------------------------------------

function fLimpiar() {

	// Seteo los campos al estado dado por los vars

	if (get('formulario.opcionMenu') == 'InsertarAutorizacion') {
		set('formulario.cbCodUsuario', new Array(get('formulario.hOidUsuario')));
		set('formulario.cbCodOperacion', new Array(get('formulario.hOidOperacion')));
	
		onChangeOperacion();
		var tipoOper = get('formulario.hOidTipoOperacion');
		if (tipoOper != '') {
			  set('formulario.cbTipoOperacion', new Array(tipoOper));
		}
	}

	set('formulario.txtImporteMax', get('formulario.hImporteMaximo'));
	set('formulario.txtMontoMaxDiferencia', get('formulario.hMontoMaximoDiferencia'));

	var ingreso = get('formulario.hIngreso');
	var desbloqueo = get('formulario.hDesbloqueo');
	
	var si = GestionarMensaje(84);
	var no = GestionarMensaje(86);

	  if (ingreso == si) {
			set('formulario.rbIngreso','S');
	  }else if (ingreso == no || ingreso == '') {
			set('formulario.rbIngreso','N');
	  }	

	  if (desbloqueo == si) {
			set('formulario.rbDesbloqueo','S');
	  }else if (desbloqueo == no || desbloqueo == '') {
			set('formulario.rbDesbloqueo','N');		
	  }
/*
	if (ingreso != '') {
		  set('formulario.rbIngreso', ingreso);
	} else {
		set('formulario.rbIngreso', 'S');
	}

	if (desbloqueo != '') {
		  set('formulario.rbDesbloqueo', desbloqueo);
	} else {
		set('formulario.rbDesbloqueo', 'S');
	}
*/
 }

//------------------------------------------------------------------------------------------------------------

function limpiarVars() {
	set('formulario.hOid', '');
	set('formulario.hOidUsuario', '');
	set('formulario.hOidOperacion', '');
	set('formulario.hOidTipoOperacion', '');
	set('formulario.hImporteMaximo', '');
	set('formulario.hMontoMaximoDiferencia', '');
	set('formulario.hIngreso', '');
	set('formulario.hDesbloqueo', '');
}

//------------------------------------------------------------------------------------------------------------

function limpiarCampos() {
	limpiarVars();
	fLimpiar();
}

//------------------------------------------------------------------------------------------------------------

function fErrorAlGuardar() {
	if (get('formulario.accion') == 'modificar') {
		// Estoy modificando, los 3 combos estan bloqueados, el foco va a importe maximo
		focaliza('formulario.txtImporteMax');
	} else if (get('formulario.accion') == '') {
		// Estoy insertando, el foco va al combo de usuarios
		focaliza('formulario.cbCodUsuario');
	}
}

  function guardoCorrectamente(opcionMenu){
      
      eval('formulario').oculto = "N";
      if (opcionMenu == "ModificarAutorizacion"){                
                returnValue = "modificar";
                window.close();
      }else{
//            fLimpiar();
			limpiarCampos();
      }      
  }
  

    function noPudoGuardar(){
        
    }