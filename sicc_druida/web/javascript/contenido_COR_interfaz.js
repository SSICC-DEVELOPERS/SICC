/**
* Copyright 2005 © por Indra Sistemas,S.A.. Todos los derechos reservados.
* Avda. de Bruselas, 35
* Parque Empresarial Arroyo de la Vega
* 28108 Alcobendas, Madrid
* España
*
* Privado y Confidencial.
* La información contenida en este documento es propiedad de Indra sistemas.
* Para uso exclusivo de empleados autorizados no permitiéndose
* la distribución de este código sin permiso expreso.
*/ 

var FORMULARIO = 'frmFormulario';

function onLoadPag()   {
	var errDescripcion = get(FORMULARIO +'.errDescripcion');
    if (errDescripcion !='') {           
         var errCodigo = get(FORMULARIO+'.errCodigo');
         var wnd = fMostrarMensajeError(errCodigo, errDescripcion);
    }
    configurarMenuSecundario(FORMULARIO);
    focaliza(FORMULARIO+'.txtFechaGenerar');
}

function shFecha() {
	//focaliza(FORMULARIO+'.ckConfirmacionPedidos');
	document.all['btnRecibirInterfaz'].focus(); 
}

function tabConfirmacion() {
	focaliza(FORMULARIO+'.txtFechaGenerar');
}

function onClickRecibirInterfaz() {
	//Comprobamos si alguno de los dos check estan seleccionados, pues si no, no debemos hacer nada. 
	if((get(FORMULARIO+'.ckConfirmacionPedidos')=='S')||(get(FORMULARIO+'.ckSeguimientoPedidos')=='S')) {
		 if(sicc_validaciones_generales()){
			set(FORMULARIO+'.accion','recepcionar');
                    	set(FORMULARIO+'.conectorAction','LPCOR');
                        enviaSICC(FORMULARIO);
                  }
	}else {
		//Muestra el mensaje: "Se debe seleccionar al menos un interfaz" (UIINT-002)
         	cdos_mostrarAlert(GestionarMensaje('1469'));
	}
}

function fLimpiar(){
	
	 fLimpiarGenericoSICC();
         set(FORMULARIO+'.ckConfirmacionPedidos','N');
         set(FORMULARIO+'.ckSeguimientoPedidos','N');
         
         set(FORMULARIO+'.areatxtObservaciones',''); 

         
          
	
}
function fechaValida(){
	
         var fecha = get(FORMULARIO+'.txtFechaGenerar');
         if(fecha != ""){
                  var resul = EsFechaValida(fecha,fecha, FORMULARIO,null);
                  if(resul==1 || resul==2){
            		GestionarMensaje('1006', get(FORMULARIO+'.hFormatoFechaPais'));
                           focaliza(FORMULARIO+'.txtFechaEmision');
                           return false;
             }
         }
}

function cerrarVentana(){
	
			//debugger
			var formulario = getFormularioSICC();
			set(formulario+".conectorAction","LPInicioBelcorp");
			set(formulario+".accion","");
			try{
				parent.frames['menu'].location.reload();
				parent.frames["iconos"].mostrarCapa();
			}catch(e){}
			eval(formulario).oculto = 'N';
			enviaSICC(formulario,'','','N');
		
		
	}