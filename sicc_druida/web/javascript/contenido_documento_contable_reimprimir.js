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

function onLoadPag()   {
  
    DrdEnsanchaConMargenDcho('listado1',12);
    
    var errDescripcion = get(FORMULARIO +'.errDescripcion');
    if (errDescripcion !='') {           
         var errCodigo = get(FORMULARIO+'.errCodigo');
         var wnd = fMostrarMensajeError(errCodigo, errDescripcion);
    }
    configurarMenuSecundario(FORMULARIO);

    document.all["Cplistado1"].style.visibility='';
    document.all["CpLin1listado1"].style.visibility='';
    document.all["CpLin2listado1"].style.visibility='';
    document.all["CpLin3listado1"].style.visibility='';
    document.all["CpLin4listado1"].style.visibility='';

    document.all["primera1Div"].style.visibility='';    document.all["ret1Div"].style.visibility='';
    document.all["ava1Div"].style.visibility='';
    document.all["separaDiv"].style.visibility='';
    if(get(FORMULARIO+'.casoDeUso')=='anular') {
         document.all["btnAnularDiv"].style.visibility='';
         document.all["btnRegenerarDiv"].style.visibility='hidden';
         document.all["btnImprimirDiv"].style.visibility='hidden';
    }else if(get(FORMULARIO+'.casoDeUso')=='regenerar') {
         document.all["btnAnularDiv"].style.visibility='hidden';
         document.all["btnRegenerarDiv"].style.visibility='';
         document.all["btnImprimirDiv"].style.visibility='hidden';
    }else if(get(FORMULARIO+'.casoDeUso')=='imprimir') {
         document.all["btnAnularDiv"].style.visibility='hidden';
         document.all["btnRegenerarDiv"].style.visibility='hidden';
         document.all["btnImprimirDiv"].style.visibility='';
    }
    //document.all["btnDetalleDiv"].style.visibility=''; se elimina boton detalle        
    eval (ON_RSZ); 
    focaliza(FORMULARIO+'.textCodigoCliente'); 

}

function visibleLista() {
         
    visibilidad('capaLista','V');
    DrdEnsanchaConMargenDcho('listado1',12);
    eval (ON_RSZ);  
}

function noVisibleLista() {
          visibilidad('capaLista','O');
}

function muestraLista( ultima, rowset){
           
         var tamano = rowset.length;
         if (tamano > 0) {
                  visibleLista();
                  return true;
         } else {
                  noVisibleLista();
                  // No se ha encontrado ningún elemento con los criterios especificados
                  //Control del foco
                  focaliza(FORMULARIO+'.textCodigoCliente');
                  return false;
         }
}

function codClienteOnBlur() {
          var codigoCliente = get(FORMULARIO+'.textCodigoCliente').toString();
    if (codigoCliente != '') {
          codigoCliente = codigoCliente.toUpperCase();
          var longitudCodigoCliente = get(FORMULARIO+'.numDigitosCodigoCliente').toString();
          var longitud = codigoCliente.length;
          set(FORMULARIO+'.textCodigoCliente',rellenaCeros(codigoCliente,longitudCodigoCliente,longitud))
    }
}

function buscarCliente(){
   
    //Llamamos al proceso correspondiente Modal
    var objParams = new Object();
    var cliente = mostrarModalSICC('LPBusquedaRapidaCliente', '', objParams, null, null);            

    if(typeof cliente!='undefined') {
           var codigoCliente = cliente[1];
           set(FORMULARIO+'.textCodigoCliente',codigoCliente);
    }
}

function desplazar(){
                     
    if(get_visibilidad("capaLista")){
         if(get(FORMULARIO+'.casoDeUso')=='anular') {
                  document.all['btnAnular'].focus();
         } else if(get(FORMULARIO+'.casoDeUso')=='regenerar') {
                  document.all['btnRegenerar'].focus();
         } else if(get(FORMULARIO+'.casoDeUso')=='imprimir') {
                  document.all['btnImprimir'].focus();
         }
    }else{
          focaliza(FORMULARIO+'.textCodigoCliente');
    }
}

function desplazarSift(){    
   if(get_visibilidad("capaLista")){
         
         if(get(FORMULARIO+'.casoDeUso')=='anular') {
                  document.all['btnAnular'].focus();
         } else if(get(FORMULARIO+'.casoDeUso')=='regenerar') {
                  document.all['btnRegenerar'].focus();
         } else if(get(FORMULARIO+'.casoDeUso')=='imprimir') {
                  document.all['btnImprimir'].focus();
         }
   }else{
         document.all['btnBuscar'].focus();           
   }
}

function desplazarONStab(){
          document.all['btnBuscar'].focus();
}

function canalOnChange(){
          /*Documentation
Llamar al método recargaCombo utilizando el DTOOID y el idBusiness = "SEGObtenerAccesosPorCanal". 
Parametros del DTOOID: 
- DTOOID.oid = oid del canal seleccionado en cbCanal 

Obtenemos un DTOSalida y cargamos el combo */
          vaciaAcceso();
          var oidcanal = get(FORMULARIO+'.cbCanal');
          //alert("canal = "+oidcanal);
          if (oidcanal != ""){
          var oidpais = get(FORMULARIO+'.pais');
          var oididioma = get(FORMULARIO+'.idioma'); 
          recargaCombo(FORMULARIO+'.cbAcceso', 'SEGObtieneAccesosPorCanal', 'es.indra.sicc.util.DTOOID', [['oidPais', oidpais], ['oidIdioma', oididioma], ['oid', oidcanal]]);
          }
}

function validarDatos() {
         
         var ejercicio = get(FORMULARIO+'.textEjercicio');
         var rangoDesdeDocInt = get(FORMULARIO+'.textRangoDesdeDocInterno');
         var rangoHastaDocInt = get(FORMULARIO+'.textRangoHastaDocInterno');
         var serieDoc = get(FORMULARIO+'.textSerieDocLegal');
         var rangoDesdeDocLegal = get(FORMULARIO+'.textRangoDesdeDocLegal');
         var rangoHastaDocLegal = get(FORMULARIO+'.textRangoHastaDocLegal');
         var canal = get(FORMULARIO+'.cbCanal');
         var acceso = get(FORMULARIO+'.cbAcceso');
         var subacceso = get(FORMULARIO+'.cbSubacceso');
         var numConsolidadoDesde = get(FORMULARIO+'.textNumeroConsolidadoDesde');
         var numConsolidadoHasta = get(FORMULARIO+'.textNumeroConsolidadoHasta');
         var fechaFactDesde = get(FORMULARIO+'.textFechaFacturacionDesde');
         var fechaFactHasta = get(FORMULARIO+'.textFechaFacturacionHasta');
         var fechaProcDesde = get(FORMULARIO+'.textFechaProcesoDesde');
         var fechaProcHasta = get(FORMULARIO+'.textFechaProcesoHasta');
         
         var cond1 = (ejercicio != "" && rangoDesdeDocInt != "" && rangoHastaDocInt != "" );
         var cond2 = (serieDoc != "" && rangoDesdeDocLegal != "" && rangoHastaDocLegal != "" );
         var cond3 = (canal != "" && acceso != "" && subacceso != "" && numConsolidadoDesde != "" && numConsolidadoHasta != "" );
         
         if(!(cond1 || cond2 || cond3)) {
                  // Muestra el mensaje: "Debe introducir al menos un criterio de selección: Ejercicio, Rango Desde Documento Interno, 
                  //Rango Hasta Documento Interno O Serie Documento Legal, Rango Desde Documento Legal, Rango Hasta Documento Legal O 
                  //Canal/Acceso/Subacceso, Número Consolidado Desde, Número Consolidado Hasta" (UIFAC0002)
                  cdos_mostrarAlert(GestionarMensaje('1443'));
                  //return false;
         }else {
                  if (parseInt(rangoDesdeDocInt) > parseInt(rangoHastaDocInt)) {
                           //Muestra el mensaje: "Rango Desde de documento interno debe ser menor o igual que Rango Hasta" (UIFAC0003)
                           cdos_mostrarAlert(GestionarMensaje('1444'));
							focaliza(FORMULARIO + '.textRangoHastaDocInterno');
                           return false;
                  }
                  if (parseInt(rangoDesdeDocLegal) > parseInt(rangoHastaDocLegal)) {
                           //Muestra el mensaje: "Rango Desde de documento legal debe ser menor o igual que Rango Hasta" (UIFAC0004)
                           cdos_mostrarAlert(GestionarMensaje('1445'));
							focaliza(FORMULARIO + '.textRangoHastaDocLegal');
                           return false; 
                  }
                  if (!(fechamayor(fechaFactDesde,fechaFactHasta))) {
                           //Muestra el mensaje: "Fecha Facturación Desde debe ser menor o igual que Fecha Facturación Hasta" (UIFAC0005)
                           cdos_mostrarAlert(GestionarMensaje('1446'));
							focaliza(FORMULARIO + '.textFechaFacturacionHasta');
                           return false;
                  }
                  if (!(fechamayor(fechaProcDesde,fechaProcHasta))) {
                           //Muestra el mensaje: "Fecha Proceso Desde debe ser menor o igual que Fecha Proceso Hasta" (UIFAC0006)
                           cdos_mostrarAlert(GestionarMensaje('1447'));
							focaliza(FORMULARIO + '.textFechaProcesoHasta');
                           return false;
                  }
                  if (parseInt(numConsolidadoDesde) > parseInt(numConsolidadoHasta)) {
                           //Muestra el mensaje: "Número Consolidado Desde debe ser menor o igual que Número Consolidado Hasta" (UIFAC0007)
                           cdos_mostrarAlert(GestionarMensaje('1448'));
							focaliza(FORMULARIO + '.textNumeroConsolidadoHasta');
                           return false;
                  }
                  return true;
         }
         
}


function onClickBuscar() {

	 if(get(FORMULARIO+'.cbTipoDocumentoContable') =='') {
	 	//mensaje: El campo "Tipo Doc. Contable" es obligatorio
	 	cdos_mostrarAlert(GestionarMensaje('1453'));
	 	focaliza(FORMULARIO+'.cbTipoDocumentoContable');
	 } else if(validarDatos()){
                    var rangoDesdeDocInt = get(FORMULARIO+'.textRangoDesdeDocInterno');
                    var rangoHastaDocInt = get(FORMULARIO+'.textRangoHastaDocInterno');
                    var serieDoc = get(FORMULARIO+'.textSerieDocLegal');
                    var rangoDesdeDocLegal = get(FORMULARIO+'.textRangoDesdeDocLegal');
                    var rangoHastaDocLegal = get(FORMULARIO+'.textRangoHastaDocLegal');
                    var fechaFactDesde = get(FORMULARIO+'.textFechaFacturacionDesde');
                    var fechaFactHasta = get(FORMULARIO+'.textFechaFacturacionHasta');
                    var fechaProcDesde = get(FORMULARIO+'.textFechaProcesoDesde');
                    var fechaProcHasta = get(FORMULARIO+'.textFechaProcesoHasta');
                    var idioma = get(FORMULARIO+'.idioma');
                    var pais = get(FORMULARIO+'.pais');
                    var codCliente = get(FORMULARIO+'.textCodigoCliente');
                    var tipoDocCont = get(FORMULARIO+'.cbTipoDocumentoContable');
                    var ejercicio = get(FORMULARIO+'.textEjercicio');
                    var canal = get(FORMULARIO+'.cbCanal');
                    var acceso = get(FORMULARIO+'.cbAcceso');
                    var subacceso = get(FORMULARIO+'.cbSubacceso');
                    var numConsolidadoD = get(FORMULARIO+'.textNumeroConsolidadoDesde');
                    var numConsolidadoH = get(FORMULARIO+'.textNumeroConsolidadoHasta');
                                                                         
                    var dto = [ ["oidPais",pais], ["pais", pais], ["oidIdioma",idioma], ["codigoCliente",codCliente], ["tipoDocumentoContable",tipoDocCont],
                                  ["ejercicio",ejercicio], ["rangoDesdeDocumentoInterno",rangoDesdeDocInt], ["rangoHastaDocumentoInterno",rangoHastaDocInt],
                                  ["serieDocumentoLegal",serieDoc], ["rangoDesdeDocumentoLegal",rangoDesdeDocLegal],
                                  ["rangoHastaDocumentoLegal",rangoHastaDocLegal], ["canal",canal], ["acceso",acceso],
                                  ["subacceso",subacceso], ["numeroConsolidadoDesde",numConsolidadoD], ["numeroConsolidadoHasta",numConsolidadoH],
                                  ["fechaFacturacionDesde",fechaFactDesde], ["fechaFacturacionHasta",fechaFactHasta],
                                  ["fechaProcesoDesde",fechaProcDesde], ["fechaProcesoHasta",fechaProcHasta] ];
                                                                         
                    
                    configurarPaginado(mipgndo, "FACConsultarFacturasReversion", "ConectorBuscarFacturasReversion", "es.indra.sicc.dtos.fac.DTOFACConsultaFacturas",dto);
         } 
                            
}

function imprimirCorrecto() {
         fLimpiarGenericoSICC();
         vaciaSubacceso();
         vaciaAcceso();
		 // DBLG500001038 - dmorello, 20/07/2006: Muestra el cartel que indica que la operacion se realizo OK.
		 cdos_mostrarAlert(GestionarMensaje('1449'));
		 focaliza('frmFormulario.textCodigoCliente');
}

function operacionCorrecta() {
         //Muestra el mensaje: "Operación realizada correctamente" (UIFAC0008)
         cdos_mostrarAlert(GestionarMensaje('1449'));
         fLimpiarGenericoSICC();
         noVisibleLista();
         vaciaSubacceso();
         vaciaAcceso();        
}


function onClickAnular() {
          if (listado1.numSelecc() == 0) {
                    // Muestra el mensaje: "Debe seleccionar un elemento de la lista"
                    GestionarMensaje('50');
          } else {
                    set(FORMULARIO+'.accion','anular');
                    set(FORMULARIO+'.conectorAction','LPRangosNumeracionATratar');
                    var codSelecionados = listado1.codSeleccionados();
                    var tam = listado1.numSelecc(); 
                    set(FORMULARIO+'.listaOids',codSelecionados);
                    set(FORMULARIO+'.tamOids',tam);
                    enviaSICC(FORMULARIO);
         }
}

function onClickImprimir() {
         if (listado1.numSelecc() == 0) {
                    // Muestra el mensaje: "Debe seleccionar un elemento de la lista"
                    GestionarMensaje('50');
          } else {
                  set(FORMULARIO+'.accion','imprimir');
                  set(FORMULARIO+'.conectorAction','LPRangosNumeracionATratar');
                  var codSelecionados = new String(listado1.codSeleccionados());
                  var tam = new String(listado1.numSelecc());
                  set(FORMULARIO+'.listaOids',codSelecionados);
                  set(FORMULARIO+'.tamOids',tam);
                  enviaSICC(FORMULARIO);  
          }
}

function onClickRegenerar() {
          if (listado1.numSelecc() == 0) {
                    // Muestra el mensaje: "Debe seleccionar un elemento de la lista"
                    GestionarMensaje('50');
          } else {
                  set(FORMULARIO+'.accion','regenerar');
                  set(FORMULARIO+'.conectorAction','LPRangosNumeracionATratar');
                  var codSelecionados = new String(listado1.codSeleccionados());
                  var tam = new String(listado1.numSelecc()); 
                  set(FORMULARIO+'.listaOids',codSelecionados);
                  set(FORMULARIO+'.tamOids',tam);
                  enviaSICC(FORMULARIO);
         }
}

function fLimpiar(){
          canalOnChange();
          accesoOnChange();
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

/*Documentation
Llamar al método recargaCombo utilizando el DTOOID y el idBusiness = "SEGObtenerSubccesosPorAcceso". 
Parametros del DTOOID: 
- DTOOID.oid = oid del acceso seleccionado en cbAcceso 

Obtenemos un DTOSalida y cargamos el combo cbSubacceso 
*/
          vaciaSubacceso();
          var oidAcceso = get(FORMULARIO+'.cbAcceso');
          if(oidAcceso != ""){ 
                    var oidpais = get(FORMULARIO+'.pais');
          var oididioma = get(FORMULARIO+'.idioma'); 
          recargaCombo(FORMULARIO+'.cbSubacceso', 'SegObtenerSubaccesosPorAcceso', 'es.indra.sicc.util.DTOOID', [['oidPais', oidpais], ['oidIdioma', oididioma], ['oid', oidAcceso]]);
          }
}

function vaciaSubacceso(){
            set_combo(FORMULARIO+'.cbSubacceso',[['','']],['']);
}
function vaciaAcceso(){
            set_combo(FORMULARIO+'.cbAcceso',[['','']],['']);
            vaciaSubacceso();
}
function vaciaCanal(){
            set_combo(FORMULARIO+'.cbCanal',[['','']],['']);
            vaciaAcceso();
}

function comprobarFecha(txtFecha){ 
           
          var fecha = get(FORMULARIO+'.'+txtFecha);
           
          if(fecha != ""){
                  var resul = EsFechaValida(fecha,fecha, FORMULARIO,null);
                  if(resul==1 || resul==2){  
                           GestionarMensaje('1006', get(FORMULARIO+'.hFormatoFechaPais')); 
                           focaliza(FORMULARIO+'.'+txtFecha);
                           return false;
                   }
          }
}

function fechamayor(fecha,fech)
{
          /*************************************************************************/
          // Devuelve true si la segunda fecha es mayor que la primera. False en caso contrario
          /*************************************************************************/
          if (fecha!=fech)
          {
                    //Comprobar q no sea mayor q la fecha actual  
                    fecha2=fecha.split("/");
                    fech2=fech.split("/");
                    if (fecha2[2]<=fech2[2])
                    {
                              if (fecha2[2]==fech2[2])
                              {
                                         if (fecha2[1]<=fech2[1])
                                         {
                                                   if (fecha2[1]==fech2[1])
                                                   {
                                                             if (fecha2[0]<=fech2[0])
                                                             {
                                                                         return true;
                                                             }
                                                             else
                                                             {
                                                                         //alert('fecha de fin');
                                                                         return false;
                                                             }
                                                   }
                                                   else
                                                   {
                                                             return true;
                                                   }
                                         }
                                         else
                                         {
                                                   //alert('La fecha ');
                                                   return false;
                                         }
                              }
                              else
                              {
                                         return true;
                              }
                    }
                    else
                    {
                              //alert('o no puede ser mayor q');
                              return false;
                    }
          
          }
          return true;
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