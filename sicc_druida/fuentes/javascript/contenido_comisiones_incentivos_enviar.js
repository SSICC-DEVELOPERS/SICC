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

function onClickEnviar(){     
	if(!sicc_validaciones_generales()){
		return;		
	}
	if(get(FORMULARIO+".ckComisiones")=='N'&&get(FORMULARIO+".ckIncentivos")=='N'){
		GestionarMensaje('UIINT-002');
		return;
	}	
	fechaHasta = get(FORMULARIO+'.FechaHasta');
        fechaDesde = get(FORMULARIO+'.FechaDesde');
	diaHasta=obtenerDiaFecha(fechaHasta);
	diaDesde=obtenerDiaFecha(fechaDesde);
	if(diaDesde!='21'){
		if(!GestionarMensaje('UIINT-003')){
			focaliza(FORMULARIO+'.FechaDesde');
			return;
		}
	}
	if(fechaDesde!=get(FORMULARIO+'.fechaInterfaz')){
		if(!GestionarMensaje('UIINT-004')){
			focaliza(FORMULARIO+'.FechaDesde');
			return;
		}		
	}
	if(diaHasta!='20'){
		if(!GestionarMensaje('UIINT-005')){
			focaliza(FORMULARIO+'.FechaHasta');
			return;
		}
	}	
	if(!comprobarFechas()){
		GestionarMensaje('UIINT-001');
		return;
	}	
	set(FORMULARIO+'.accion','enviar');
	set(FORMULARIO+'.conectorAction','LPAdam');
	enviaSICC(FORMULARIO);
}
function obtenerDiaFecha(fechaEntrada){
	formatoFechaUser=new String(get(FORMULARIO+'.hFormatoFechaPais'));
	delim = obtieneDelimitador(FORMULARIO);
	var numeroDia="";
	arrayFormatoFecha=formatoFechaUser.split(delim);
	arrayFechaEntrada=fechaEntrada.split(delim);
	for(i=0;i<arrayFormatoFecha.length;i++){
		if(arrayFormatoFecha[i]=='dd'||arrayFormatoFecha[i]=='DD'){
			numeroDia=arrayFechaEntrada[i];
		}
		
	}	
	return numeroDia;
}


function fechaValida(fechaEntrada){
         
          var fecha = get(FORMULARIO+'.'+fechaEntrada);
          if(fecha != ""){
                    var resul = EsFechaValida(fecha,fecha, FORMULARIO,null);
                    if(resul==1 || resul==2){
                           GestionarMensaje('1006', get(FORMULARIO+'.hFormatoFechaPais'));
                              focaliza(FORMULARIO+'.'+fechaEntrada);
                              return false;
              }
          }
}


function fLimpiar(){
          fLimpiarGenericoSICC();
          set(FORMULARIO+'.areatxtObservaciones','');          
          set(FORMULARIO+'.ckComisiones','S');          
          set(FORMULARIO+'.ckIncentivos','S');
}


function onShTab(){                                                                
          document.all['btnEnviar'].focus();                                    
} 
                                                                                   
function onTab(){
          focaliza(FORMULARIO+'.Descripcion');
}   
  
function comprobarFechas(){
         
         fechaHasta = get(FORMULARIO+'.FechaHasta');
         fechaDesde = get(FORMULARIO+'.FechaDesde');
         var aux = EsFechaValida(fechaDesde,fechaHasta,FORMULARIO,null);
         // EsFechaValida devuelve un 3 si fechaDesde es mayor que fechaHasta
         
         if(aux == 3){
                  return false;
         } else{
                  return true;
         }
}

function cerrarVentana(){

	var formulario = getFormularioSICC();
	set(formulario+".conectorAction","LPInicioBelcorp");
	set(formulario+".accion","");
	try{
		parent.frames['menu'].location.reload();
		parent.frames["iconos"].mostrarCapa();
	}catch(e){
	
	}
	eval(formulario).oculto = 'N';
	enviaSICC(formulario,'','','N');
	
}