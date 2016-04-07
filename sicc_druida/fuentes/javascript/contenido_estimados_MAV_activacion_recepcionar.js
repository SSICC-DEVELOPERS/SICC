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
	focaliza(FORMULARIO + ".Descripcion");
	configurarMenuSecundario(FORMULARIO);
	
}

function onClickRecepcionar(){
	
	if(!sicc_validaciones_generales()){
		return;		
	}
	var lpDestino=get(FORMULARIO+'.casoUso');	
	set(FORMULARIO+'.accion','recepcionar');
	set(FORMULARIO+'.conectorAction',lpDestino);
	enviaSICC(FORMULARIO);	
	
	
}

function onShTab(){                                                                         
           document.all['btnRecepcionar'].focus();                                         
} 
                                                                                              
function onTab(){
           focaliza(FORMULARIO+'.Descripcion');
}   

function cerrarVentana(){

         var formulario = getFormularioSICC();
         set(formulario+".conectorAction","LPInicioBelcorp");
         set(formulario+".accion","");
         try{
                  //parent.frames['menu'].location.reload();
                  parent.frames["iconos"].mostrarCapa();
         }catch(e){
         
         }
         eval(formulario).oculto = 'N';
         enviaSICC(formulario,'','','N');
         
}

function fLimpiar(){
           fLimpiarGenericoSICC();
           set(FORMULARIO+'.areatxtObservaciones','');           
           
}
