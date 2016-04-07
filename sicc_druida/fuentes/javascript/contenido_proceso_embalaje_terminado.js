document.onkeypress=function(){

         valor = event.keyCode;
    
         if((valor >= 48 && valor <= 57) || valor ==127 || valor == 8 || valor == 13) {

                  consolLeng = document.getElementById("txtCodigoBarraEtiqueta").value.length;
                                   
                  if((consolLeng) == 11 && event.keyCode == 13){
                           onClickBtnProcesar();
                  } 

                  return true;

         } else {
                  return false;
         }
}

function onLoadPag(){
	fMostrarMensajeError();
    configurarMenuSecundario('formulario');
	//focalizaBotonHTML('botonContenido','btnProcesar');
	focaliza("formulario.txtCodigoBarraEtiqueta");
}

function onChangeTxtCodigoBarraEtiqueta() {
	txt_to('Mensajes', '');
}

function onClickBtnProcesar(){
	txt_to("Mensajes", "");
	set('formulario.codigoBarraEtiqueta', get('formulario.txtCodigoBarraEtiqueta'));
	if(sicc_validaciones_generales("gBuscar")){
		fecha = new Date();
		set('formulario.varAnio', fecha.getYear());
		eval('formulario').oculto = 'S';
        set('formulario.conectorAction', 'LPProcesoEmbalajeTerminado');
        set('formulario.accion', 'procesar'); 
        enviaSICC('formulario');
	}
}
function fProcesoOK(codigoBarraEtiqueta){

         set('formulario.txtCodigoBarraEtiqueta', '');
		 var mensaje = GestionarMensaje('2627', codigoBarraEtiqueta);
		 txt_to("Mensajes", mensaje);
		 focaliza("formulario.txtCodigoBarraEtiqueta");	     	
    
}
function fProcesaERR(){
	   eval('formulario').oculto= 'N';
}

function fLimpiar(){
	set('formulario.txtCodigoBarraEtiqueta', '');
	txt_to("Mensajes", "");
}

function onTab(campo) {
	if (campo == 'txtCodigoBarraEtiqueta') {
		focalizaBotonHTML('botonContenido', 'btnProcesar');
	} else if (campo == 'btnProcesar') {
		focaliza('formulario.txtCodigoBarraEtiqueta');
	}
}

function onShiftTab(campo) {
	if (campo == 'txtCodigoBarraEtiqueta') {
		focalizaBotonHTML('botonContenido', 'btnProcesar');
	} else if (campo == 'btnProcesar') {
		focaliza('formulario.txtCodigoBarraEtiqueta');
	}
}
	
