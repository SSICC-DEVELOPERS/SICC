function onLoadPag() {
  configurarMenuSecundario("formularios");
  //alert("estoy aca" + get('formularios.errCodigo'));
  if (get('formularios.errCodigo') == '30006'){
    
    set('formularios.accion','Salir');    
    set('formularios.conectorAction','LPCerrarCajasBelcenter');
    //enviaSICC('formularios','','','N'); 
    enviaSICC('formularios'); 
  }
  
  DrdEnsanchaConMargenDcho('listado1',24);
	    
	document.all["Cplistado1"].style.visibility='';
	document.all["CpLin1listado1"].style.visibility='';
	document.all["CpLin2listado1"].style.visibility='';
	document.all["CpLin3listado1"].style.visibility='';
	document.all["CpLin4listado1"].style.visibility='';
	document.all["primera1Div"].style.visibility='hidden';
	document.all["ret1Div"].style.visibility='hidden';
	document.all["ava1Div"].style.visibility='hidden';
	document.all["separaDiv"].style.visibility='hidden';  
  
	eval (ON_RSZ);

  datosCabecera();
  focoBotonResumen();

  if (get('formularios.errDescripcion')!='') {
        var wnd = fMostrarMensajeError(get('formularios.errCodigo'), get('formularios.errDescripcion'));
  }
}

function accionResumenPorEmpleado() {
  //no modal
  //set("formularios.conectorAction", "LPCerrarCajasBelcenter");
  //set("formularios.accion", "resumen");
  //enviaSICC("formularios");

  //modal
  var obj = new Object();
  mostrarModalSICC('LPCerrarCajasBelcenter','resumen',obj,800,600);
}

function datosCabecera() {
  var canal = get("formularios.varCanal");
  var acceso = get("formularios.varAcceso");
  var subacceso = get("formularios.varSubacceso");
  var fecha = get("formularios.varFecha");
  var estado = get("formularios.varEstado");
  
  txt_to("lbldtCanal", canal);
  txt_to("lbldtAcceso", acceso);
  txt_to("lbldtSubacceso", subacceso);
  txt_to("lbldtFecha", fecha);
  txt_to("lbldtEstado", estado);         
}

function focoBotonResumen() {
  focalizaBotonHTML('botonContenido','btnResumenEmpleado');
}
