function onLoad() {
         configurarMenuSecundario('formulario');
         var acc = get('formulario.accion');
         var opcionMenu = get('formulario.opcionMenu');
        
         if ((opcionMenu == 'InsertarOrdenAnaqueles')) {
				  //Traer valor defecto si fuera el caso
                  focaliza('formulario.cbMagnitud');
         }
         if (acc == 'modificar') {
                  /*btnProxy(2,1);
                  btnProxy(3,0);
                  btnProxy(5,0);*/
                  set('formulario.cbMagnitud', [get('formulario.oidMagnitud')]);
                  set('formulario.cbUnidMedOrigen', [get('formulario.oidUnidMedOrigen')]);
				  set('formulario.cbUnidMedDestino', [get('formulario.oidcbUnidMedDestino')]);
					
                  accion('formulario.cbMagnitud', '.disabled = true');
				  accion('formulario.cbUnidMedOrigen', '.disabled = true');
				  accion('formulario.cbUnidMedDestino', '.disabled = true');
         }
         if (acc == 'detalle') {
                  /*btnProxy(2,1);
                  btnProxy(3,0);*/
                 set('formulario.cbMagnitud', [get('formulario.oidMagnitud')]);
                  set('formulario.cbUnidMedOrigen', [get('formulario.oidUnidMedOrigen')]);
				  set('formulario.cbUnidMedDestino', [get('formulario.oidcbUnidMedDestino')]);
					
                  accion('formulario.cbMagnitud', '.disabled = true');
				  accion('formulario.cbUnidMedOrigen', '.disabled = true');
				  accion('formulario.cbUnidMedDestino', '.disabled = true');
				  accion('formulario.txtFactor', '.disabled = true');
         }
    //focaliza('formulario.txtCodigoCaja');
}


function accionGuardar() { // Equivale a onClickGuardar
    if (!sicc_validaciones_generales()) {
         return false;
    }
         // Envio el formulario
         eval('formulario').oculto = 'S';
         set('formulario.conectorAction', 'LPMantenimientoFactoresConversion');
         set('formulario.accion', 'guardar');
         //enviaSICC('formulario');
		 var opcionMenu = get('formulario.opcionMenu');
		 if ((opcionMenu == 'InsertarFactoresConversion')) {
			enviaSICC('formulario');
			return;
         }
         else if (opcionMenu == 'ModificarFactoresConversion') {
			 enviaSICC('formulario', null, null, 'N');
			 return;
		 }
}

function onChangeMagnitud () {
  var oidMagnitud = get('formulario.cbMagnitud', 'V');
  set('formulario.oidMagnitud', oidMagnitud); 
  if (oidMagnitud != '') {
    var array = new Array();
    array[0] = new Array('oid',oidMagnitud);
    array[1] = new Array('oidIdioma',get('formulario.varIdioma'));
    array[2] = new Array('oidPais',get('formulario.varPais'));
    set_combo('formulario.cbUnidMedOrigen', arrayVacio());
		set_combo('formulario.cbUnidMedDestino', arrayVacio());
    recargaCombo('formulario.cbUnidMedOrigen',
      'APEObtenerUnidadesMedidaPorMagnitud',
      'es.indra.sicc.util.DTOOID',
      array,
      'setearcbUnidMedOrigen(datos)');
    recargaCombo('formulario.cbUnidMedDestino',
      'APEObtenerUnidadesMedidaPorMagnitud',
      'es.indra.sicc.util.DTOOID',
      array,
      'setearcbUnidMedDestino(datos)');
  } else {
    set_combo('formulario.cbUnidMedOrigen', arrayVacio());
    set_combo('formulario.cbUnidMedDestino', arrayVacio());
  }
}

function arrayVacio(){  
    var array = new Array();             
    array[0] = new Array('','');
    return array;
}

function fLimpiar() {
  var acc = get('formulario.accion');
  if (acc == 'modificar') {
    //Solo limpiar el texto habilitado: txtFactorconversion
    set('formulario.txtFactor', '');
  }else{
    set('formulario.cbMagnitud', '');        
    set_combo('formulario.cbUnidMedOrigen', arrayVacio());
    set_combo('formulario.cbUnidMedDestino', arrayVacio());
    set('formulario.txtFactor', '');
  }
}

function setearcbUnidMedOrigen(datos) {
  var arrayNuevo = new Array();
  arrayNuevo[0] = new Array('','');
  arrayNuevo = arrayNuevo.concat(datos);
  set_combo('formulario.cbUnidMedOrigen',arrayNuevo);
}

function setearcbUnidMedDestino(datos) {
         var arrayNuevo = new Array();
         arrayNuevo[0] = new Array('','');
         arrayNuevo = arrayNuevo.concat(datos);
         set_combo('formulario.cbUnidMedDestino',arrayNuevo);
}

function fVolver() {
    this.close();
}

function fGuardar(){
	accionGuardar();
}

function cerrarModal(){
   
     var retorno = new Array();
     retorno[0] = "OK";
    
     returnValue = retorno;
     close();
}

function onChangeUniMedOrig(){
  set('formulario.oidUnidMedOrigen', get('formulario.cbUnidMedOrigen')); 
}

function onChangeUniMedDest(){
  set('formulario.oidcbUnidMedDestino', get('formulario.cbUnidMedDestino')); 
}
