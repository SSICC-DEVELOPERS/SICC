/**
* Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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


/*
    INDRA/CAR/PROY
    $Id: contenido_tipo_movimiento_almacen_insertar.js,v 1.1 2009/12/03 19:01:38 pecbazalar Exp $
    DESC
*/
var FORMULARIO = 'formularios';
//Funcion que se ejecuta al cargar la pagina
function onLoadPag(){
	if (get(FORMULARIO+'.errDescripcion')!='') {                  
		var wnd = fMostrarMensajeError(get(FORMULARIO+'.errCodigo'),get(FORMULARIO+'.errDescripcion'));
	}                 
	if ((get(FORMULARIO+'.hoperacion1')!='') && (get(FORMULARIO+'.casoUso')!='insertar')) {
		set(FORMULARIO+'.cbOperacion1',[get(FORMULARIO+'.hoperacion1')]);
	}
	if ((get(FORMULARIO+'.hoperacion2')!='') && (get(FORMULARIO+'.casoUso')!='insertar')) {
		set(FORMULARIO+'.cbOperacion2',[get(FORMULARIO+'.hoperacion2')]);
	}
	
	if(get(FORMULARIO+'.casoUso')=='insertar') {
		focaliza(FORMULARIO + ".txtCodTipoMovimiento");
		//habilitaEntreAlmacenes();
	}
	if (get(FORMULARIO+'.casoUso')=='modificar') {
		focaliza(FORMULARIO + ".txtDescripcion");
		//habilitaEntreAlmacenes();
	}
	configurarMenuSecundario(FORMULARIO);
}

function aMayusculas(campo){
	if (get(FORMULARIO+'.'+campo)!='') {
		set(FORMULARIO+'.'+campo,get(FORMULARIO+'.'+campo).toUpperCase());
	}
}

function fGuardar() {
	var casouso = get(FORMULARIO+'.casoUso');
	aMayusculas('txtCodTipoMovimiento');
	aMayusculas('txtCodMovimientoSAP');
	if(sicc_validaciones_generales()){
		if (casouso!='modificar'){
			set(FORMULARIO+'.accion','guardar');
		}else {
			set(FORMULARIO+'.accion','guardarModificar');
		}
		set(FORMULARIO+'.conectorAction','LPMantenimientoTiposMovimientosAlmacen');
		enviaSICC(FORMULARIO);
	}
}

function fVolver(){
	window.close();
}

function fLimpiar(){
	var hMovimientoAlmacenes = get (FORMULARIO + '.hMovimientoAlmacenes');
	var hMantieneMovimientos = get (FORMULARIO + '.hMantieneMovimientos');
	var hIndicadorSAP = get (FORMULARIO + '.hIndicadorSAP');
	var hOperacion1 = get(FORMULARIO+'.hoperacion1');
	var hOperacion2 = get(FORMULARIO+'.hoperacion2');
	var hEstadoMerc1 = get(FORMULARIO+'.hEstadoMerc1');
	var hEstadoMerc2 = get(FORMULARIO+'.hEstadoMerc2');
	
	if (get(FORMULARIO+'.casoUso')=='insertar'){
		set(FORMULARIO+'.rbMovimientoAlmacenes','N');
		set(FORMULARIO+'.rbMantieneMovimientos','S');
		set(FORMULARIO+'.ckIndicadorSAP','N');
		/* inc BELC300023319 cdos gPineda 13/06/2006 - INICIO */
		set(FORMULARIO+'.txtCodTipoMovimiento','');
		set(FORMULARIO+'.txtDescripcion','');
		set(FORMULARIO+'.txtCodMovimientoSAP','');
		set(FORMULARIO+'.cbEstado1','');
		set(FORMULARIO+'.cbOperacion1','');
		set(FORMULARIO+'.cbOperacion2','');
		set(FORMULARIO+'.cbEstado1','');
		set(FORMULARIO+'.cbEstado2','');
		/* inc BELC300023319 cdos gPineda 13/06/2006 -  FIN   */
	}else{
		set(FORMULARIO+'.cbOperacion1',[hOperacion1]);
		set(FORMULARIO+'.cbOperacion2',[hOperacion2]);	
		set(FORMULARIO+'.cbEstado1',[hEstadoMerc1]);	
		set(FORMULARIO+'.cbEstado2',[hEstadoMerc2]);
		set(FORMULARIO+'.rbMovimientoAlmacenes',hMovimientoAlmacenes);
		set(FORMULARIO+'.rbMantieneMovimientos',hMantieneMovimientos);
		set(FORMULARIO+'.ckIndicadorSAP',hIndicadorSAP);
	}
	//habilitaEntreAlmacenes();

	/*DBLG500000960 gpons 25/07/2004 */
	limpiaI18N(FORMULARIO , 1)
}

function modificacionCorrecta(){
	var casouso=get(FORMULARIO+'.casoUso');
       var codigo=get(FORMULARIO+'.txtCodTipoMovimiento');
       var descripcion=get(FORMULARIO+'.txtDescripcion');
       if (casouso!='insertar'){
	       window.returnValue = [codigo,descripcion];
	       window.close();
    	}    	
}

function insercionCorrecta(){
	fLimpiarGenericoSICC();
	set(FORMULARIO+'.rbMovimientoAlmacenes','N');
	set(FORMULARIO+'.rbMantieneMovimientos','S');
	set(FORMULARIO+'.ckIndicadorSAP','N');
	/* inc BELC300023319 cdos gPineda 15/06/2006 */
	fLimpiar();
}

function focalizaOnshtab(){
	var casouso=get(FORMULARIO+'.casoUso');
	if (casouso!='insertar'){
		focaliza('formularios.cbOperacion2');	
	}else{
		focaliza('formularios.txtCodTipoMovimiento');
	}
}

function focalizaOntab(){
	var casouso=get(FORMULARIO+'.casoUso');
	if (casouso!='insertar'){
		focaliza('formularios.txtDescripcion');	
	}else{
		focaliza('formularios.txtCodTipoMovimiento');
	}
}

function habilitaEntreAlmacenes() {
	if (get(FORMULARIO+'.rbMovimientoAlmacenes') =='N') {
		set(FORMULARIO+'.cbOperacion2',[""]);	
		set(FORMULARIO+'.cbEstado2',[""]);
		accion(FORMULARIO+'.cbOperacion2', '.disabled=true');
		accion(FORMULARIO+'.cbEstado2', '.disabled=true');
	} else {
		accion(FORMULARIO+'.cbOperacion2', '.disabled=false');
		accion(FORMULARIO+'.cbEstado2', '.disabled=false');
		
	}
}