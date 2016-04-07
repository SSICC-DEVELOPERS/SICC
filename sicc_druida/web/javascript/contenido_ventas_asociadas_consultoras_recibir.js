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

function fLimpiar(){
         set(FORMULARIO+'.areatxtObservaciones',"");
}

function fGuardar(){
	accionGuardar();
}

function accionGuardar(){
	//Invocar la LPECM , enviando oculto el formulario, con accion = "guardar"
	
	set(FORMULARIO+'.accion','guardar');
	set(FORMULARIO+'.conectorAction','LPECM');
	enviaSICC(FORMULARIO);
}

function ejecucionCorrecta(){
	Salir();
}

function Salir(){
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

function ontab(){
	focaliza(FORMULARIO + ".Descripcion");
}

function onshtab(){
	focaliza(FORMULARIO + ".areatxtObservaciones");
}