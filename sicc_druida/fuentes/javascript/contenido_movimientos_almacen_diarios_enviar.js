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
	
	focaliza(FORMULARIO + ".areatxtObservaciones");	
	configurarMenuSecundario(FORMULARIO);
}

function canalOnChange() {
	var canal =get(FORMULARIO + '.cbCanal');
	var acceso = get(FORMULARIO + '.cbAcceso');
	set(FORMULARIO +'.hcanal',canal);
	if (canal != ""){
		var idBusiness="SEGObtenerAccesosPorCanal";
		var dtoapc= "es.indra.sicc.dtos.seg.DTOAccesosPorCanal";		
		var oididioma = get(FORMULARIO+'.idioma');   
		recargaCombo(FORMULARIO+'.cbAcceso', idBusiness, dtoapc, [['oidIdioma',oididioma],["oidCanal", canal]]);		
	}else{
		vaciaCombo(FORMULARIO + '.cbAcceso');
		vaciaCombo(FORMULARIO + '.cbSubacceso');
	}
	
	if (acceso != ""){
		var idBusiness="SegObtenerSubaccesosPorAcceso";
		var dtooid = "es.indra.sicc.util.DTOOID";
		var oidpais = get(FORMULARIO+'.pais');
		var oididioma = get(FORMULARIO+'.idioma');
		recargaCombo(FORMULARIO+'.cbSubacceso', idBusiness, dtooid, [['oidPais',oidpais],['oidIdioma',oididioma],["oid", acceso]]);
	}
}

function accesoOnChange() {
	var acceso =get(FORMULARIO + '.cbAcceso');
	set(FORMULARIO +'.hacceso',acceso);
	if (acceso!=""){		
		var idBusiness="SegObtenerSubaccesosPorAcceso";
		var dtooid = "es.indra.sicc.util.DTOOID";
		var oidpais = get(FORMULARIO+'.pais');
		var oididioma = get(FORMULARIO+'.idioma'); 
		
		recargaCombo(FORMULARIO+'.cbSubacceso', idBusiness, dtooid, [['oidPais',oidpais],['oidIdioma',oididioma],["oid", acceso]]);	
	}else{
		vaciaCombo(FORMULARIO + '.cbSubacceso');
	}         
}

/**
    * Sistema:     Belcorp
    * Modulo:      INTSYS
    * Fecha:       11/10/2005
    * @version     1.0
    * @autor       Cristian Valenzuela
	* Cambios:     Se pasa a la LP el valor del nuevo combo tipo movimiento
    */   

function enviarOnClick(){	
	if(!sicc_validaciones_generales('tipoMovimiento')) {
		return;
	}

	var tiposMovimiento = get("frmFormulario.cbTipoMovimiento");
	set(FORMULARIO+'.tiposMovimiento', tiposMovimiento);

	var subaccesos = get("frmFormulario.cbSubacceso");
	set(FORMULARIO+'.subaccesos', subaccesos);

	set(FORMULARIO+'.accion','enviar');
	set(FORMULARIO+'.conectorAction','LPEnviarMovimientosAlmacenDiarios');
	enviaSICC(FORMULARIO);
}

function onShTab(){                                                 
	document.all['btnEnviar'].focus();                            
} 
                                                                
function onTab(){
	focaliza(FORMULARIO+'.areatxtObservaciones');
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

function vaciaCombo(combo){
	set_combo(combo,[['','']],['']);
}