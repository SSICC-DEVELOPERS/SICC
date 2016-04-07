/**
* Copyright 2004 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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

function onLoadPag() {	
	var errDescripcion = get(FORMULARIO +'.errDescripcion');
    if (errDescripcion !='') {           
         var errCodigo = get(FORMULARIO+'.errCodigo');
         var wnd = fMostrarMensajeError(errCodigo, errDescripcion);
    }
    configurarMenuSecundario(FORMULARIO);

    eval (ON_RSZ); 
	accion('frmFormulario.textRangoHastaDocLegal', '.disabled = true')
	deshabilitarHabilitarBoton('botonContenido', 'btnConfirmar', 'D');
    
	cargaCanalPordefecto();
    focaliza(FORMULARIO+'.cbTipoDocumentoContable'); 

}

function canalOnChange(){
           var oidcanal = get(FORMULARIO+'.cbCanal');
        if (oidcanal != ""){
          var oidpais = get(FORMULARIO+'.pais');
          var oididioma = get(FORMULARIO+'.idioma'); 
          recargaCombo(FORMULARIO+'.cbAcceso', 'SEGObtieneAccesosPorCanal', 'es.indra.sicc.util.DTOOID', [['oidPais', oidpais], ['oidIdioma', oididioma], ['oid', oidcanal]]);
        }
}

function validarDatos() {
         
 var canal = get(FORMULARIO+'.cbCanal');
 var acceso = get(FORMULARIO+'.cbAcceso');
 var subacceso = get(FORMULARIO+'.cbSubacceso'); 
 var ejercicio = get(FORMULARIO+'.textEjercicio');
 var rangoDesdeDocInt = get(FORMULARIO+'.textRangoDesdeDocInterno');
 var rangoHastaDocInt = get(FORMULARIO+'.textRangoHastaDocInterno');
 var serieDoc = get(FORMULARIO+'.textSerieDocLegal');
 var rangoDesdeDocLegal = get(FORMULARIO+'.textRangoDesdeDocLegal');
   
 if (canal == ""){
    GestionarMensaje('21');
 }else if (acceso == ""){
	 GestionarMensaje('22');
 } else if (subacceso == "") {
	 GestionarMensaje('23');
 } else if (ejercicio == "") {
	 GestionarMensaje('3343');
 } else if (rangoDesdeDocInt == "") {
	 GestionarMensaje('3344');
 } else if (rangoHastaDocInt == "") {
	 GestionarMensaje('3345');
 } else if (serieDoc == "") {
	 GestionarMensaje('3346');
 } else if (rangoDesdeDocLegal == "") {
	 GestionarMensaje('3347');
 } else {
	  if (parseInt(rangoDesdeDocInt) > parseInt(rangoHastaDocInt)) {
		cdos_mostrarAlert(GestionarMensaje('1444'));
	    focaliza(FORMULARIO + '.textRangoHastaDocInterno');
		return false;
	 }
	 return true;
 }
         
}


function onClickAsignar() {
	 if(get(FORMULARIO+'.cbTipoDocumentoContable') =='') {
	 	//mensaje: El campo "Tipo Doc. Contable" es obligatorio
	 	cdos_mostrarAlert(GestionarMensaje('1453'));
	 	focaliza(FORMULARIO+'.cbTipoDocumentoContable');
	 } else if(validarDatos()){
                   
        set(FORMULARIO+'.accion','asignar');
        set(FORMULARIO+'.conectorAction','LPReasignarNumeroDocumentoContable');
  	    eval(FORMULARIO).oculto = "S";
        /* continua en cargarRangoHasta*/
    	enviaSICC(FORMULARIO);
		
     } 
}

//	Modificado por HRCS - Fecha 31/05/2007 - Cambio Sicc20070258
function cargarRangoHasta(rangoHasta, cantDocNoImp, numRegNoNulo){

   set('frmFormulario.textRangoHastaDocLegal', rangoHasta);
   
   accion('frmFormulario.cbTipoDocumentoContable', '.disabled = true');
   accion('frmFormulario.cbCanal', '.disabled = true');
   accion('frmFormulario.cbAcceso', '.disabled = true');
   accion('frmFormulario.cbSubacceso', '.disabled = true');
   accion('frmFormulario.textEjercicio', '.disabled = true');
   accion('frmFormulario.textRangoDesdeDocInterno', '.disabled = true');
   accion('frmFormulario.textRangoHastaDocInterno', '.disabled = true');
   accion('frmFormulario.textSerieDocLegal', '.disabled = true');
   accion('frmFormulario.textRangoDesdeDocLegal', '.disabled = true');
  
   deshabilitarHabilitarBoton('botonContenido', 'btnConfirmar', 'A');
   deshabilitarHabilitarBoton('botonContenido', 'btnAsignar', 'D');
   if (parseInt(get(FORMULARIO+'.textRangoDesdeDocLegal')) > parseInt(get(FORMULARIO+'.textRangoHastaDocLegal'))){
			GestionarMensaje('3341');
			cancelaConfirmar();
   } else {
		if ( (parseInt(get(FORMULARIO+'.textRangoHastaDocLegal')) - parseInt(get(FORMULARIO+'.textRangoDesdeDocLegal'))) != 
			 ((parseInt(get(FORMULARIO+'.textRangoHastaDocInterno')) - parseInt(get(FORMULARIO+'.textRangoDesdeDocInterno')))-cantDocNoImp)
			) {
			GestionarMensaje('3342');
			cancelaConfirmar();
		}
		//	Agregado por HRCS - Fecha 30/05/2007 - Cambio Sicc20070258
		if ( numRegNoNulo != 0 )	{
			var r = GestionarMensaje('FAC0001', numRegNoNulo );
			if ( !r )
			{
				cancelaConfirmar();
			}
		}
	}
}

//	Agregado por HRCS - Fecha 30/05/2007 - Cambio Sicc20070258
function cancelaConfirmar()	{
	   accion('frmFormulario.cbTipoDocumentoContable', '.disabled = false');
	   accion('frmFormulario.cbCanal', '.disabled = false');
	   accion('frmFormulario.cbAcceso', '.disabled = false');
	   accion('frmFormulario.cbSubacceso', '.disabled = false');
	   accion('frmFormulario.textEjercicio', '.disabled = false');
	   accion('frmFormulario.textRangoDesdeDocInterno', '.disabled = false');
	   accion('frmFormulario.textRangoHastaDocInterno', '.disabled = false');
	   accion('frmFormulario.textSerieDocLegal', '.disabled = false');
	   accion('frmFormulario.textRangoDesdeDocLegal', '.disabled = false');
	  
	   deshabilitarHabilitarBoton('botonContenido', 'btnConfirmar', 'D');
	   deshabilitarHabilitarBoton('botonContenido', 'btnAsignar', 'A');
}

function confirmarCorrecto() {
		 cdos_mostrarAlert(GestionarMensaje('1449'));
		 fLimpiarConfirmar();
}

function fLimpiarConfirmar(){
   accion('frmFormulario.cbTipoDocumentoContable', '.disabled = false');
   accion('frmFormulario.cbCanal', '.disabled = false');
   accion('frmFormulario.cbAcceso', '.disabled = false');
   accion('frmFormulario.cbSubacceso', '.disabled = false');
   accion('frmFormulario.textEjercicio', '.disabled = false');
   accion('frmFormulario.textRangoDesdeDocInterno', '.disabled = false');
   accion('frmFormulario.textRangoHastaDocInterno', '.disabled = false');
   accion('frmFormulario.textSerieDocLegal', '.disabled = false');
   accion('frmFormulario.textRangoDesdeDocLegal', '.disabled = false');
  
   deshabilitarHabilitarBoton('botonContenido', 'btnConfirmar', 'D');
   deshabilitarHabilitarBoton('botonContenido', 'btnAsignar', 'A');
   set(FORMULARIO+'.textEjercicio','');
   set(FORMULARIO+'.textRangoDesdeDocInterno','');
   set(FORMULARIO+'.textRangoHastaDocInterno','');
   set(FORMULARIO+'.textSerieDocLegal','');
   set(FORMULARIO+'.textRangoDesdeDocLegal','');
   set(FORMULARIO+'.textRangoHastaDocLegal','');
   cargaCanalPordefecto();	
   set(FORMULARIO+'.cbTipoDocumentoContable','');
   fLimpiarGenericoSICC();
   focaliza('frmFormulario.cbTipoDocumentoContable');
}

function onClickConfirmar() {
        set(FORMULARIO+'.accion','confirmar');
        set(FORMULARIO+'.conectorAction','LPReasignarNumeroDocumentoContable');
  	    eval(FORMULARIO).oculto = "S";

    	enviaSICC(FORMULARIO);
		confirmarCorrecto();
}



function fLimpiar(){
   fLimpiarConfirmar();          
}

function validarNumerico(texto){ 
                                                     
           var num = get(FORMULARIO+'.'+texto); 
           if(num != ""){
                      var val = allTrim(num);                  
           //Como no nos interesa validar el número de dígitos que tiene el 
           //entero ponemos uno suficientemente grande. 
                      if ((ValidaInt(val.toString(),10000, 0)!="OK")||(val.toString() < 0)) {
                                  GestionarMensaje('747', null, null, null);
                                  focaliza(FORMULARIO+'.'+texto);
                                  return false;
                      }
           } 
}
 
function allTrim(sStr){ 
            return rTrim(lTrim(sStr)); 
}

function lTrim(sStr){ 
            while (sStr.charAt(0) == " "){
                         sStr = sStr.substr(1, sStr.length - 1); 
            }
            return sStr; 
}

function rTrim(sStr){ 
            while (sStr.charAt(sStr.length - 1) == " ") {
                         sStr = sStr.substr(0, sStr.length - 1); 
            }
            return sStr; 
}

function serieDocLegalOnBlur(){
          set(FORMULARIO + '.textSerieDocLegal',get(FORMULARIO + '.textSerieDocLegal').toUpperCase());
}

function accesoOnChange(){

          var oidAcceso = get(FORMULARIO+'.cbAcceso');
          if(oidAcceso != ""){ 
                    var oidpais = get(FORMULARIO+'.pais');
          var oididioma = get(FORMULARIO+'.idioma'); 
          recargaCombo(FORMULARIO+'.cbSubacceso', 'SegObtenerSubaccesosPorAcceso', 'es.indra.sicc.util.DTOOID', [['oidPais', oidpais], ['oidIdioma', oididioma], ['oid', oidAcceso]]);
          }
         
}


function cargaCanalPordefecto(){
		 iSeleccionado = new Array(); 
		 iSeleccionado[0] = get(FORMULARIO+'.canalDefecto');
		 set(FORMULARIO+'.cbCanal', iSeleccionado);
         if(iSeleccionado[0] != ''){

		 asignar([['COMBO','frmFormulario.cbAcceso',
                             'ConectorDruidaTransactionQuery',
                             'dtoSalida.resultado_ROWSET',
                             formarCadenaDT('SEGObtieneAccesosPorCanal', 
                                 'es.indra.sicc.util.DTOOID', 
                                makeParametersAcceso()), 
                                                         'recargarAcceso(datos);']]);	
		 }
		 var d = new Date();
		 var anio = d.getYear().toString();  
		 anio = anio.substr(2, anio.length - 1);
         set('frmFormulario.textEjercicio',anio)
}

function makeParametersAcceso(){
   var arr = new Array();
   var canal = get('frmFormulario.cbCanal');
   arr[arr.length] = new Array("oidPais", get('frmFormulario.pais'));
   arr[arr.length] = new Array("oidIdioma", get('frmFormulario.idioma'));
   arr[arr.length] = new Array("oid", canal);
   return arr;

}

 function recargarAcceso(datos){
         
         var  arr = new Array();

         arr[arr.length] = new Array([''],['']);
         for (var i=0 ;i< datos.length ; i++)  {
             arr[arr.length] = datos[i];
         }      
         set_combo('frmFormulario.cbAcceso',arr);

         var iSeleccionado = new Array(); 
         var oidAcceso = get('frmFormulario.accesoDefecto');
         iSeleccionado[0] = oidAcceso ;

         set('frmFormulario.cbAcceso',iSeleccionado);

		 if(iSeleccionado[0] != ''){		
			 asignar([['COMBO','frmFormulario.cbSubacceso',
								 'ConectorDruidaTransactionQuery',
								 'dtoSalida.resultado_ROWSET',
								 formarCadenaDT('SegObtenerSubaccesosPorAcceso', 
									'es.indra.sicc.util.DTOOID', 
									makeParametersSubac()), 
															 'recargaSubac(datos);']]);	

		 }                   
    }

function makeParametersSubac(){
   var arr = new Array();

   var oidAcceso = get('frmFormulario.cbAcceso');

   arr[arr.length] = new Array("oidPais", get('frmFormulario.pais'));
   arr[arr.length] = new Array("oidIdioma", get('frmFormulario.idioma'));
   arr[arr.length] = new Array("oid", oidAcceso);
   return arr;

}


function recargaSubac(datos){
	 var  arr = new Array();

	 arr[arr.length] = new Array([''],['']);
	 for (var i=0 ;i< datos.length ; i++)  {
		 arr[arr.length] = datos[i];
	 }

	 set_combo('frmFormulario.cbSubacceso',arr);
	 
	 var iSeleccionado = new Array(); 
	 var oidSubacceso = get('frmFormulario.subaccesoDefecto');
	 iSeleccionado[0] = oidSubacceso;
	 set('frmFormulario.cbSubacceso',iSeleccionado);
}

 

/*
 * DBLG500001037 - dmorello, 20/07/2006
 * Selecciona todas las filas de la lista de resultados
 */
function seleccionarFilas() {
	var numFilas = listado1.datos.length;
	for (var i = 0; i < numFilas; i++) {
		listado1.selecc[i] = 1;
	}
}