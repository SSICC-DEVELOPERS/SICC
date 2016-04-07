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
	focaliza(FORMULARIO + ".cbMarca");
	configurarMenuSecundario(FORMULARIO);
}

function marcaOnChange(){
	recargaPeriodo();
}

function canalOnChange(){
	var oid = get(FORMULARIO + '.cbCanal');			
	
	if (oid != "") {
		var idBusiness="SEGObtieneAccesosPorCanal";
		var dtoOid= "es.indra.sicc.util.DTOOID";	
		var oidPais = get(FORMULARIO+'.pais');		
		var oidIdioma = get(FORMULARIO+'.idioma'); 			
		recargaCombo(FORMULARIO+'.cbAcceso', idBusiness, dtoOid,[["oid",oid],["oidIdioma",oidIdioma],["oidPais",oidPais]]);
		recargaPeriodo();
	}else{
		vaciaCombo(FORMULARIO + '.cbAcceso');
		vaciaCombo(FORMULARIO + '.cbPeriodo');
	}
	
}

function recargaPeriodo(){
	var oidCanal = get(FORMULARIO + '.cbCanal');	
	var oidMarca = get(FORMULARIO + '.cbMarca');	
	if(oidCanal!=""&&oidMarca!=""){
		var idBusiness="CRAObtienePeriodos";
		var dtoPeriodo= "es.indra.sicc.dtos.cra.DTOPeriodo";
		var oidPais = get(FORMULARIO+'.pais');		
		var oidIdioma = get(FORMULARIO+'.idioma'); 				
		recargaCombo(FORMULARIO+'.cbPeriodo', idBusiness, dtoPeriodo, [["oidIdioma",oidIdioma],["oidPais",oidPais],["pais",oidPais],[ 'marca', oidMarca ], [ 'canal', oidCanal ]] ); 
	}else{
		vaciaCombo(FORMULARIO + '.cbPeriodo');
	}
}

function onClickEnviar(){     
        
	if(!sicc_validaciones_generales()){
		return;		
	}
	
	set(FORMULARIO+'.accion','enviar');
	set(FORMULARIO+'.conectorAction','LPEnviarInterfaces');
	enviaSICC(FORMULARIO);
         
}

function vaciaCombo(combo){
           set_combo(combo,[['','']],['']);
}

function fLimpiar(){
         fLimpiarGenericoSICC();   
         set(FORMULARIO+'.areatxtObservaciones','');             
         vaciaCombo(FORMULARIO + '.cbAcceso');  
         vaciaCombo(FORMULARIO + '.cbPeriodo');  

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