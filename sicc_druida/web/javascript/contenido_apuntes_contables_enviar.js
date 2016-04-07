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
         if (get(FORMULARIO+'.errDescripcion')!='') {
                var wnd = fMostrarMensajeError(get(FORMULARIO+'.errCodigo'),get(FORMULARIO+'.errDescripcion'));
         }
         //Control del foco
         focaliza(FORMULARIO + ".Descripcion");
         configurarMenuSecundario(FORMULARIO);
}

function cerrarVentana(){
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


function enviarOnClick(){
         //Se hace un envío oculto del formulario, con accion = "enviar"
		 if (validaFechasHasta()) { //se valida fechaHasta, incidencia SiCC-20070233 (Sapaza) 
			 set(FORMULARIO+'.accion','enviar');
			 set(FORMULARIO+'.conectorAction','LPEnviarApuntesContables');
			 enviaSICC(FORMULARIO);
		 }
}

function onShTab(){                                                        
         document.all['btnEnviar'].focus();                                
} 
                                                                         
function onTab(){
         focaliza(FORMULARIO+'.Descripcion');
}     

function fLimpiar(){
	 fLimpiarGenericoSICC();
         set(FORMULARIO+'.areatxtObservaciones','');
}

function validaFechasHasta() {
   if (cdos_trim(get(FORMULARIO+'.FechaHasta')) != "") {
		if (!EsFechaValida_SICC(get(FORMULARIO+'.FechaHasta'), FORMULARIO)) {
			GestionarMensaje('947',FORMULARIO+'.FechaHasta');
			focaliza(FORMULARIO+'.FechaHasta')
			return false;
		}
   }         
   return true;    
}
