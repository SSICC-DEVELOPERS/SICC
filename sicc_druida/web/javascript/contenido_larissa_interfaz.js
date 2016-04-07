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
         focaliza(FORMULARIO + ".cbMarca");
         //Deshabilitamos el combo de interfaces
         accion(FORMULARIO + '.cbInterfaz', '.disabled=true') 
         
         configurarMenuSecundario(FORMULARIO);
}

function onChangeCanal() {
	/*
	Si( cbMarca tiene valor seleccionado ) 
	{ 
	Llamar al método 'recargaCombo' utilizando DTOPeriodo y el idBusiness = "CRAObtienePeriodos". 
	
	Parametros del DTOPeriodo: 
	- pais = pais activo 
	- marca = la seleccionada en el control 'cbMarca' 
	- canal = el seleccionado en el control 'cbCanal' 
	
	Se obtiene un DTOSalida y se carga el combo cbPeriodo 
	}
	*/
	
	var marca = get(FORMULARIO + '.cbMarca');
	var canal = get(FORMULARIO + '.cbCanal');
	
	set(FORMULARIO +'.hmarca',marca);
	if ((marca != "")&&(canal != "")) {
	      var idBusiness="CRAObtienePeriodos";
	      var dtoPeri= "es.indra.sicc.dtos.cra.DTOPeriodo";
	      var oidPais = get(FORMULARIO+'.pais');
	      recargaCombo(FORMULARIO+'.cbPeriodo', idBusiness, dtoPeri, 
	      		[["marca",marca],
	      		["pais",oidPais],
	      		["canal",canal]]);
	}else{
		vaciaCombo(FORMULARIO + '.cbPeriodo');
	}
}

function onChangeMarca() {
	/*
	Si( cbCanal tiene valor seleccionado ) 
	{ 
	Llamar al método 'recargaCombo' utilizando DTOPeriodo y el idBusiness = "CRAObtienePeriodos". 
	
	Parametros del DTOPeriodo: 
	- pais = pais activo 
	- marca = la seleccionada en el control 'cbMarca' 
	- canal = el seleccionado en el control 'cbCanal' 
	
	Se obtiene un DTOSalida y se carga el combo cbPeriodo 
	}
	*/
	var canal = get(FORMULARIO + '.cbCanal');
	var marca = get(FORMULARIO + '.cbMarca');
	set(FORMULARIO +'.hcanal',canal);
	if ((canal != "")&&(marca != "")){
	      var idBusiness="CRAObtienePeriodos";
	      var dtoPeri= "es.indra.sicc.dtos.cra.DTOPeriodo";		
	      //var oididioma = get(FORMULARIO+'.idioma');
	      var oidPais = get(FORMULARIO+'.pais');
	      recargaCombo(FORMULARIO+'.cbPeriodo', idBusiness, dtoPeri, 
	      		[["pais",oidPais],
	      		["canal",canal],
	      		["marca",marca]]);
	}else{
	      vaciaCombo(FORMULARIO + '.cbPeriodo');
	}
}

function onClickEnviar(){
	/*
		- se construye un objeto DTOINTCargaInicialLarissa y se guardan el él los valores de la pantalla 
		- se invoca a LPInterfazLarissa.ejecución, con accion="enviar"
	*/
	set(FORMULARIO+'.hEstimados',get(FORMULARIO+'.ckProductosEstimados'));
	set(FORMULARIO+'.accion','enviar');
	set(FORMULARIO+'.conectorAction','LPInterfazLarissa');
	enviaSICC(FORMULARIO);
}

function onShTab(){                                                        
         document.all['btnEnviar'].focus();                                
} 
                                                                         
function onTab(){
         focaliza(FORMULARIO+'.cbMarca');
}

function fLimpiar(){
	vaciaCombo(FORMULARIO + '.cbPeriodo');
	set(FORMULARIO+'.areatxtObservaciones',"");
}

function vaciaCombo(combo){
         set_combo(combo,[['','']],['']);
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