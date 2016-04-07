 function frmCargarBarra(){
    configurarMenuSecundario("frmContenido");	
 }

function verificarVolverLogin() {
    var valor = get('frmContenido.volverAlLogin');
    if(valor=='true'){
	//fSalir(true);
	fSalirAplicacion(true);
    }
}

function doInit_Clave_acceso_cambiar() {
    focaliza('frmContenido.txtClaveNueva');
    
    if(fMostrarMensajeError()){
      try{
	frmCargarBarra();
	habilitarMenu();
      }catch(e){;}
      return;
    }

    var sMensaje =  get('frmContenido.mensaje');
    if ( (sMensaje!='') && (sMensaje.length > 0) ){
	cdos_mostrarAlert( GestionarMensaje(sMensaje,null,null,null) );
	verificarVolverLogin();
    }else{
      var recargaMenu = get('frmContenido.recargaMenu');
      if (recargaMenu) {
	  frmCargarBarra();
	  habilitarMenu();
      }
    }
}

function cambiarEstado() {
  if(!window.dialogArguments){
    btnProxy(2,'0');
  } 
}

function habilitarMenu() {
  btnProxy(1,'1');
  btnProxy(5,'1');
  if(!window.dialogArguments){
    btnProxy(2,'0');
  } else {
    btnProxy(2,'1');
  }
}

function fLimpiar() {
  focaliza('frmContenido.txtClaveNueva');
  set('frmContenido.txtClaveNueva', '');
  set('frmContenido.txtConfirmarClaveNueva', '');
}
  
function validaDatos() {
  if (get('frmContenido.txtClaveNueva') != get('frmContenido.txtConfirmarClaveNueva')) {
    GestionarMensaje('28', null, null, null);
    cdosFC('frmContenido.txtConfirmarClaveNueva');
    return false;
  }
  if (get('frmContenido.txtClaveNueva') == '') {
    GestionarMensaje('29', null, null, null);
    cdosFC('frmContenido.txtClaveNueva');
    return false;
  }
  if (get('frmContenido.txtConfirmarClaveNueva') == '') {
    GestionarMensaje('31', null, null, null);
    cdosFC('frmContenido.txtConfirmarClaveNueva');
    return false;
  }
  return true;
}


function fGuardar() {
  if (validaDatos()) {
    if(parent.frames["menu"] == null){
      set('frmContenido.volverAlLogin','true');
    }
    set('frmContenido.accion', 'CambiarClave');
    set('frmContenido.conectorAction', 'LPCambiarClave');
    enviaSICC('frmContenido');
  }
}


function fVolver(){
  window.close();
}

function focoClave() {
  focaliza('frmContenido.txtClaveNueva');
}

function focoClaveNueva() {
  focaliza('frmContenido.txtConfirmarClaveNueva');
}

