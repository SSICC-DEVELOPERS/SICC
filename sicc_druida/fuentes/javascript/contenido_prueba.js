function onLoadPag(){  
         
    configurarMenuSecundario('formulario');
    fMostrarMensajeError();
}

function onClickAceptar(){
     eval('formulario').oculto = 'S';   
     set('formulario.conectorAction', 'LPPruebaServ');
     set('formulario.accion', 'lanzar');
     enviaSICC('formulario', null, null, 'N');
}

function ejecutarOK(){
    GestionarMensaje("264", null, null, null);
}

function ejecutarKO(){
    alert("error");
}

function perderFoco(){
  alert("Vi1");
  return;
}
