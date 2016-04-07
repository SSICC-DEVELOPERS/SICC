function onLoadPag()  {           
      configurarMenuSecundario('frmFormulario'); 
      focaliza('frmFormulario.areatxtMotivoBloqueoDesbloqueo');
    
      btnProxy(1,1);
      btnProxy(2,1);
      
      if (get('frmFormulario.errDescripcion')!='') {
				 var wnd = fMostrarMensajeError(get('frmFormulario.errCodigo'), get('frmFormulario.errDescripcion'));
      }
	  if(get('frmFormulario.hIndBloqueo')=='1'){
			cargaBloqueo();
    		document.getElementById("areatxtObsDesbloqueo").disabled = true;

	  }
	  if(get('frmFormulario.hIndDesBloqueo')=='1'){
		  
			var datosNuevo = new Array();
			datosNuevo[0] = [get('frmFormulario.oidTipoBloqueo'),get('frmFormulario.desTipoBloqueo')];

			set_combo("frmFormulario.cbTipoBloqueo", datosNuevo);

		  
    	  document.getElementById("areatxtMotivoBloqueoDesbloqueo").disabled = true;		  
		  document.getElementById("areatxtObsBloqueo").disabled = true;		  
          document.getElementById("cbTipoBloqueo").disabled = true;

		  set("frmFormulario.areatxtMotivoBloqueoDesbloqueo",get('frmFormulario.hMotivo'));

		  set("frmFormulario.areatxtObsBloqueo",get('frmFormulario.hObsBloqueo'));
	  }
	  if(get('frmFormulario.hCierraVentana')=='1'){
		this.errorTipoBloqueo();
	  }
	  
 }

function  fLimpiar(){
    set("frmFormulario.areatxtMotivoBloqueoDesbloqueo", "");
}

function fGuardar(){      
	
	if(get('frmFormulario.hIndBloqueo')=='1'){
		if(!sicc_validaciones_generales()){
			return;
		}
	}
	if (GestionarMensaje("950", null, null, null)){
		
		set("frmFormulario.oidTipoBloqueo", get('frmFormulario.cbTipoBloqueo'));
		set("frmFormulario.hMotivo",get('frmFormulario.areatxtMotivoBloqueoDesbloqueo'));
		set("frmFormulario.hObsBloqueo",get('frmFormulario.areatxtObsBloqueo'));
		set("frmFormulario.hObsDesBloq",get('frmFormulario.areatxtObsDesbloqueo'));
		set("frmFormulario.conectorAction","LPTratarSolicitudBloqueo");
    	set("frmFormulario.accion","grabar");						
		enviaSICC("frmFormulario"); 

	}else{
		if(GestionarMensaje("UICOB0007", null, null, null)){
			set("frmFormulario.oidTipoBloqueo", get('frmFormulario.cbTipoBloqueo'));
			set("frmFormulario.hMotivo",get('frmFormulario.areatxtMotivoBloqueoDesbloqueo'));
			set("frmFormulario.hObsBloqueo",get('frmFormulario.areatxtObsBloqueo'));
			set("frmFormulario.hObsDesBloq",get('frmFormulario.areatxtObsDesbloqueo'));
			set("frmFormulario.conectorAction","LPTratarSolicitudBloqueo");
			set("frmFormulario.accion","anular");			
			enviaSICC("frmFormulario"); 
		}
	}

}


function errorAlGuardar(){ 	  
  btnProxy(0,1);
  btnProxy(2,1);
	focaliza("frmFormulario.areatxtMotivoBloqueoDesbloqueo");
 }

function fVolver(){	
	window.close();
}

function cerrarVentana(){
	window.returnValue = true;
}

function cargaBloqueo(){
		
		recargaCombo('frmFormulario.cbTipoBloqueo', 'COBObtenerTipoBloqueos', 
			'es.indra.sicc.util.DTOOID',[['oidPais', get('frmFormulario.hPais')],['oidIdioma',get('frmFormulario.hIdioma')]],
			"seteaValorTipoBloqueo(datos);");
}

function seteaValorTipoBloqueo(datos){
	var datosNuevo = new Array();
	datosNuevo[0] = ["",""];

	for (var i = 0; i < datos.length; i++ )
		datosNuevo[i+1]  = datos[i];

	set_combo("frmFormulario.cbTipoBloqueo", datosNuevo);
	// vbongiov -- 4/06/2008 
    set("frmFormulario.cbTipoBloqueo", [get('frmFormulario.oidTipoBloqueo')]); 

}

function asignarDatosTipoBloqueo(datos){
	var objR = datos.split("|");

	var objt = objR[0].split(";");
	
	var datosNuevo = new Array();
	datosNuevo[0] = [objt[0],objt[1]];

	set_combo("frmFormulario.cbTipoBloqueo", datosNuevo);

	set("frmFormulario.areatxtMotivoBloqueoDesbloqueo",objR[1]);

	set("frmFormulario.areatxtObsBloqueo",objR[2]);
	
}

function errorTipoBloqueo(){
	window.close();
}