var objVarGen = new Object();
         objVarGen.hOidCliente = "";
         objVarGen.cbEtapa = "";
         objVarGen.cbSociedad= "";
         objVarGen.txtHoraSeguimiento="";
         objVarGen.txtHoraReprogramacion="";
         objVarGen.compromisosDePago="";
var arrVacio = new Array();              
         arrVacio[0] = new Array('','');


 function onLoad(){
           
      fMostrarMensajeError();
      
           // Combos deshabilitados
           //set_combo('frmFormulario.cbTipoCargo', arrVacio);
      //[1] accion('frmFormulario.cbTipoCargo', '.disabled=true');
           //set_combo('frmFormulario.cbSucursal', arrVacio);
      //[1] accion('frmFormulario.cbSucursal', '.disabled=true');

      set('frmFormulario.cbMarca', [get('frmFormulario.hCbMarca')]);
      set('frmFormulario.cbCanal', [get('frmFormulario.hCbCanal')]);

           deshabilitarCampos();


                  /*inicio modificado ciglesias incidencia BELC300024442*/
                  if ((get('frmFormulario.accion') == "crearSeguimientoTel") ||
                      (get('frmFormulario.accion') == "crear")) {
                           set('frmFormulario.cbMarca', [get('frmFormulario.hOidMarca')]);
                           set('frmFormulario.cbCanal', [get('frmFormulario.hOidCanal')]);

                           recargaCombo('frmFormulario.cbPeriodo', 'CRAObtienePeriodos', 
                                                        'es.indra.sicc.dtos.cra.DTOPeriodo', 
                                                         [['pais', get('frmFormulario.hPais')], 
                             		      ['marca', get('frmFormulario.hOidMarca')], 
                                                         ['canal', get('frmFormulario.hOidCanal')]],
                                                         "seteaValorPeriodo(datos);");

                           recargaCombo('frmFormulario.cbTipoCargo', 'COBObtenerTipoCargoPorEtapa', 
                                                        'es.indra.sicc.util.DTOOID', 
                                                         [['oid', get('frmFormulario.hOidEtapa')]],
                                                         "seteaValorTipoCargo(datos);");
                           
                           set('frmFormulario.cbEtapa', [get('frmFormulario.hOidEtapa')]);
                           set('frmFormulario.txtCodigoCliente', get('frmFormulario.hCodigoCliente'));
                  }
                  else
                  {
                                      recargaPeriodo();
                  }
                  /*fin modificado ciglesias incidencia BELC300024442*/

           // gPinda - V-COB006 - 30/01/2007
           objVarGen.cbEtapa = get('frmFormulario.hOidEtapa');
           objVarGen.hOidCliente = get('frmFormulario.hOidCliente');

           objVarGen.cbSociedad= get('frmFormulario.hCbSociedad');
           if( get('frmFormulario.accion') != "crear" )
                    set('frmFormulario.cbSociedad', [objVarGen.cbSociedad]);	 

           focaliza("frmFormulario.cbEtapa");
           setTimeout('configurarMenuSecundario("frmFormulario");',200);
    }

/*inicio modificado ciglesias incidencia BELC300024442*/
function seteaValorPeriodo(datos) {

         var datosNuevo = new Array();
         datosNuevo[0] = ["",""];

         for (var i = 0; i < datos.length; i++ )
                  datosNuevo[i+1]  = datos[i];

         set_combo("frmFormulario.cbPeriodo", datosNuevo);
         set('frmFormulario.cbPeriodo', [get('frmFormulario.hOidPeriodo')]);
}

function seteaValorTipoCargo(datos) {
         var datosNuevo = new Array();
         datosNuevo[0] = ["",""];

         for (var i = 0; i < datos.length; i++ )
                  datosNuevo[i+1]  = datos[i];

         set_combo("frmFormulario.cbTipoCargo", datosNuevo);
         set('frmFormulario.cbTipoCargo', [get('frmFormulario.hOidTipoCargoAbono')]);
}

function deshabilitarCampos() {

         document.getElementById("txtFechaSeguimiento").disabled = true;
         document.getElementById("txtHoraSeguimiento").disabled = true;
         document.getElementById("txtHoraReprogramacion").disabled = true;
         document.getElementById("txtFechaReprogramacion").disabled = true;
         document.all.rbAportaPrueba[0].disabled= true;
         document.all.rbAportaPrueba[1].disabled= true;
         document.getElementById("txtDescripcionPrueba").disabled = true;
         document.getElementById("txtNumeroDocumentoSoporte").disabled = true;
         document.getElementById("txtNumeroDocumentoSoporte").disabled = true;
         document.getElementById("cbBanco").disabled = true;
         document.getElementById("txtNuevaDireccion").disabled = true;
         document.getElementById("txtNuevoTelefono").disabled = true;
         document.all.rbPasaAlAdministrador[0].disabled= true;
         document.all.rbPasaAlAdministrador[1].disabled= true;
         document.all.rbPeticionBloqueoAdministrativo[0].disabled= true;
         document.all.rbPeticionBloqueoAdministrativo[1].disabled= true;
         document.all.rbPeticionDesBloqueoAdministrativo[0].disabled= true;
         document.all.rbPeticionDesBloqueoAdministrativo[1].disabled= true;
         document.getElementById("areatxtObservaciones").disabled = true;
         document.getElementById("cbTipoBloqueo").disabled = true;

         if(get("frmFormulario.hIndFechaHoraSeguimiento") == "true") {
                  document.getElementById("txtFechaSeguimiento").disabled = false;
                  document.getElementById("txtHoraSeguimiento").disabled = false;
         }

         if(get("frmFormulario.hIndFechaHoraNuevoSeguimiento") == "true") {
                  document.getElementById("txtHoraReprogramacion").disabled = false;
                  document.getElementById("txtFechaReprogramacion").disabled = false;
         }

         if(get("frmFormulario.hIndAportaPrueba") == "true") {
                  document.all.rbAportaPrueba[0].disabled= false;
                  document.all.rbAportaPrueba[1].disabled= false;
         }

         if(get("frmFormulario.hIndDescripcionPrueba") == "true") {
                  document.getElementById("txtDescripcionPrueba").disabled = false;
         }

         if(get("frmFormulario.hIndNumeroDocumentoSoporte") == "true") {
                  document.getElementById("txtNumeroDocumentoSoporte").disabled = false;
         }

         if(get("frmFormulario.hIndTipoDocumentoPago") == "true") {
                  document.getElementById("txtNumeroDocumentoSoporte").disabled = false;
         }

         if(get("frmFormulario.hIndBancoSucursal") == "true") {
                  document.getElementById("cbBanco").disabled = false;
         }

         if(get("frmFormulario.hIndNuevaDireccion") == "true") {
                  document.getElementById("txtNuevaDireccion").disabled = false;
         }

         if(get("frmFormulario.hIndNuevoTelefono") == "true") {
                  document.getElementById("txtNuevoTelefono").disabled = false;
         }

         if(get("frmFormulario.hIndPasaAdministrador") == "true") {
                  document.all.rbPasaAlAdministrador[0].disabled= false;
                  document.all.rbPasaAlAdministrador[1].disabled= false;
         }
         
         if(get("frmFormulario.hIndPeticionBloqueoAdministrativo") == "true") {
                  document.all.rbPeticionBloqueoAdministrativo[0].disabled= false;
                  document.all.rbPeticionBloqueoAdministrativo[1].disabled= false;
                  document.getElementById("cbTipoBloqueo").disabled = false;
         }

         if(get("frmFormulario.hIndPeticionDesbloqueoAdministrativo") == "true") {
                  document.all.rbPeticionDesBloqueoAdministrativo[0].disabled= false;
                  document.all.rbPeticionDesBloqueoAdministrativo[1].disabled= false;
         }

         if(get("frmFormulario.hIndObservaciones") == "true") {
                  document.getElementById("areatxtObservaciones").disabled = false;
                  set("frmFormulario.areatxtObservaciones",get("frmFormulario.hObservaciones"));
         }
}
/*fin modificado ciglesias incidencia BELC300024442*/


function recargaPeriodo(){
         var canal = get('frmFormulario.cbCanal');
         var marca = get('frmFormulario.cbMarca');
         if(  canal!= '' && marca != ''){

                  recargaCombo('frmFormulario.cbPeriodo', 'CRAObtienePeriodos', 
                           'es.indra.sicc.dtos.cra.DTOPeriodo', [['pais', get('frmFormulario.hPais')], 
                     ['marca', marca], ['canal', canal]]);// ['marca', get('frmFormulario.cbMarca')], ['canal', get('frmFormulario.cbCanal')]]);

         } else {         
         
                  set_combo('frmFormulario.cbPeriodo', arrVacio);

         }
}

function arrayVacio(){  
         var array = new Array();              
         array[0] = new Array('','');
         return array;
}

         
function marcaOnChange(){
         recargaPeriodo();
}

function canalOnChange(){
         recargaPeriodo();
}

function bancoOnChange(){
         var banco = get('frmFormulario.cbBanco');
         if(banco != ''){
                  //[1]accion('frmFormulario.cbSucursal', '.disabled=false');
                  recargaCombo('frmFormulario.cbSucursal', 'CCCRecargaSucursales', 
                           'es.indra.sicc.util.DTOOID', [['oid', banco]]);
         } else {         
                  set_combo('frmFormulario.cbSucursal', arrVacio);
                  //[1]accion('frmFormulario.cbSucursal', '.disabled=true');
         }
}

function etapaDeudaOnChange(){
         var cbEtapa = get('frmFormulario.cbEtapa');
         if( cbEtapa!= ''){
                  //[1] accion('frmFormulario.cbTipoCargo', '.disabled=false');
                  objVarGen.cbEtapa = cbEtapa;
                  recargaCombo('frmFormulario.cbTipoCargo', 'COBObtenerTipoCargoPorEtapa', 
                           'es.indra.sicc.util.DTOOID', [['oid', cbEtapa]]);
         } else {         
                  set_combo('frmFormulario.cbTipoCargo', arrVacio);
                  //[1] accion('frmFormulario.cbTipoCargo', '.disabled=true');
         }
}

    // Autocompletar Cod de cliente
function onchange_codCliente(){
         var codCliente = get('frmFormulario.txtCodigoCliente');
         if (codCliente.length != 0)  {
                  codigoCompleto = validarLongCodCliene(codCliente);
                  set('frmFormulario.txtCodigoCliente', codigoCompleto);
                  //set('frmFormulario.hIndicadorBusquedaCliente','C');
                  /*set('frmFormulario.txtCodigoCliente', codigoCompleto);	
                  
                  set('frmFormulario.conectorAction', 'LPCrearGestion');


                  eval('frmFormulario').oculto = 'S';
                  enviaSICC('frmFormulario', '', '', 'N');  */
                  var objParamsInt = new Object();
                  objParamsInt.opener = window;
                  objParamsInt.destino ='LPCrearGestion';
                  objParamsInt.conectorAction= 'LPCrearGestion';
                  
                  var obj = new Object();
                  obj.txtCodigoCliente = codigoCompleto;
                  if(get('frmFormulario.accion')=="crearSeguimientoTel") {
                           obj.accion = 'validarClienteSeguimientoTel';
                  } else { 
                           obj.accion = 'validarCliente';
                  }
                  objParamsInt.parametros = obj;
                  setValues(objParamsInt);
         }
}

function asignarDatosCliente(oidCliente){
         //[1] set('frmFormulario.hOidCliente', oidCliente);	
         objVarGen.hOidCliente = oidCliente;
}

function errorCliente(){
         //set('frmFormulario.hOidCliente', '');
         objVarGen.hOidCliente ="";
         set('frmFormulario.txtCodigoCliente', '');
         focaliza("frmFormulario.txtCodigoCliente");
}


function validarLongCodCliene(codCliente) {
         var longiCod = get('frmFormulario.hLongitudCodCliente');
         var faltantes = longiCod -  codCliente.length;
         var resultCod = new String("");
         if(faltantes > 0){
                  for(var t = 0 ; t<faltantes; t++){
                           resultCod = resultCod + "0";
                  }
                  resultCod = resultCod + codCliente;
                  return resultCod;
         }
         return codCliente;

}


    // Busqueda rapida de cliente
         function accionBuscarCliente() {

           var oid;
           var obj = new Object();
           var whnd = mostrarModalSICC('LPBusquedaRapidaCliente','',obj);

           if(whnd!=null){

                var oid = whnd[0];
                var cod = whnd[1];
                //var nombre1 = whnd[2];
                //var apellido1 = whnd[4];

                set("frmFormulario.txtCodigoCliente", cod);
                objVarGen.hOidCliente = oid;//[1] set("frmFormulario.hOidCliente", oid);
                    }
    }

    // Control de radio button
         function pasaAlAdministradorOnClick(){
                  if(get('frmFormulario.rbPasaAlAdministrador')=='S'){
                           set('frmFormulario.rbPeticionBloqueoAdministrativo','N');
                           set('frmFormulario.rbPeticionDesBloqueoAdministrativo','N');
                  }
         }

         function peticionBloqueoAdministrativoOnClick(){
                  if(get('frmFormulario.rbPeticionBloqueoAdministrativo')=='S'){
                           set('frmFormulario.rbPasaAlAdministrador','N');
                           set('frmFormulario.rbPeticionDesBloqueoAdministrativo','N');
                  }
         }

         function peticionDesbloqueoAdministrativoOnClick(){
                  if(get('frmFormulario.rbPeticionDesBloqueoAdministrativo')=='S'){
                           set('frmFormulario.rbPasaAlAdministrador','N');
                           set('frmFormulario.rbPeticionBloqueoAdministrativo','N');
                  }
         }


    function fLimpiar(){
           // Combos deshabilitados
           set_combo('frmFormulario.cbTipoCargo', arrVacio);
      //[1] accion('frmFormulario.cbTipoCargo', '.disabled=true');
           set_combo('frmFormulario.cbSucursal', arrVacio);
      //[1] accion('frmFormulario.cbSucursal', '.disabled=true');

           set('frmFormulario.areatxtObservaciones','');

      // Limpia los radios button
           document.all.rbAportaPrueba[0].checked= false;
           document.all.rbAportaPrueba[1].checked= false;

      document.all.rbPasaAlAdministrador[0].checked= false;
           document.all.rbPasaAlAdministrador[1].checked = false;
           document.all.rbPeticionBloqueoAdministrativo[0].checked= false;
           document.all.rbPeticionBloqueoAdministrativo[1].checked= false;
           document.all.rbPeticionDesBloqueoAdministrativo[0].checked= false;
           document.all.rbPeticionDesBloqueoAdministrativo[1].checked= false;

      set('frmFormulario.cbMarca', [get('frmFormulario.hCbMarca')]);
      set('frmFormulario.cbCanal', [get('frmFormulario.hCbCanal')]);
           objVarGen.cbSociedad= get('frmFormulario.hCbSociedad');
           set('frmFormulario.cbSociedad', [objVarGen.cbSociedad]);

      recargaPeriodo();

           focaliza("frmFormulario.cbEtapa");
         }


    // Control de TAB
         function focalizaShTab(){
                  focalizaBotonHTML('botonContenido','btnCompromisoPago');
         }

         function focalizaTab(){
                  focaliza("frmFormulario.cbEtapa");
         }


         function compromisoPagoOnClick(){

                  var obj = new Object();
                  obj.codCliente = get('frmFormulario.txtCodigoCliente');
                  obj.compromisosDePago = get('frmFormulario.compromisosDePago');
                  obj.accion = 'aniadirCompromisosPago';
                  var retorno = mostrarModalSICC('LPCrearGestion', 'aniadirCompromisosPago', obj, null, null);

                  //alert("retorno:" + retorno);

                  if(retorno!=null) {
                      //alert("guarda valor");
                           set('frmFormulario.compromisosDePago', retorno);
                  }

                  focaliza("frmFormulario.cbEtapa");
                           
         }


         function fGuardar(){
                  var horaSeguimiento;
                  if(sicc_validaciones_generales("gGuardar")){	
                           objVarGen.txtHoraSeguimiento = get('frmFormulario.txtHoraSeguimiento');
                     if(objVarGen.txtHoraSeguimiento !="") {
                              if ( validaFormatoHora(objVarGen.txtHoraSeguimiento) == false) {
                                             GestionarMensaje("1514", null, null, null);
                                             focaliza("frmFormulario.txtHoraSeguimiento");
                                             return;
                              }
                     }
                     objVarGen.txtHoraReprogramacion = get('frmFormulario.txtHoraReprogramacion');
                     /* gPineda - 05/02/2007 - Siempre exige la hora, por mas que se encuentre inhabilitada
                     if(objVarGen.horaReprogramacion!="") {*/
                     if(objVarGen.txtHoraReprogramacion!="") {
                              if ( validaFormatoHora(objVarGen.txtHoraReprogramacion) == false) {
                                             GestionarMensaje("1514", null, null, null);
                                             focaliza("frmFormulario.txtHoraReprogramacion");
                                             return;
                              }
                     }

                     var accionPagina = get('frmFormulario.accion');
                     var accionLP;
                     if(accion=="crearSeguimientoTel" || accion=="validarClienteSeguimientoTel") {
                                    accionLP  ='crearGestionSeguimientoTel';
                     } else {
                                    accionLP  = 'crearGestion';
                     }
                  
                     /*set('frmFormulario.conectorAction', 'LPCrearGestion');

                     if(get('frmFormulario.accion')=="crearSeguimientoTel" || get('frmFormulario.accion')=="validarClienteSeguimientoTel") {
                                    set('frmFormulario.accion', 'crearGestionSeguimientoTel');
                     } else {
                                    set('frmFormulario.accion', 'crearGestion');
                     }
                     eval('frmFormulario').oculto = 'S';
                     enviaSICC('frmFormulario');*/
                     var FORMULARIO = "frmFormulario";
                     var objParamsInt = new Object();
                     objParamsInt.opener = window;
                     objParamsInt.destino ='LPCrearGestion';
                     objParamsInt.conectorAction= 'LPCrearGestion';
                           
                           var obj = new Object();
                           obj.accion = accionLP;
                           obj.hOidAccionCob = get(FORMULARIO+".hOidAccionCob");
                           obj.hOidCliente = objVarGen.hOidCliente;
                           obj.cbEtapa = objVarGen.cbEtapa ;
                           obj.cbPeriodo = get(FORMULARIO+".cbPeriodo");
                           obj.cbSociedad = objVarGen.cbSociedad;
                           obj.cbTipoCargo = get(FORMULARIO+".cbTipoCargo") ;
                           obj.txtFechaSeguimiento = get(FORMULARIO+".txtFechaSeguimiento");
                           obj.txtHoraSeguimiento = objVarGen.txtHoraSeguimiento;
                           obj.txtFechaReprogramacion = get(FORMULARIO+".txtFechaReprogramacion");
                           obj.txtHoraReprogramacion = objVarGen.txtHoraReprogramacion;
                           obj.rbAportaPrueba = get(FORMULARIO+".rbAportaPrueba");
                           obj.txtDescripcionPrueba = get(FORMULARIO+".txtDescripcionPrueba");
                           obj.txtNumeroDocumentoSoporte = get(FORMULARIO+".txtNumeroDocumentoSoporte");
                           obj.cbMedioPago = get(FORMULARIO+".cbMedioPago");
                           obj.cbSucursal = get(FORMULARIO+".cbSucursal");
                           obj.txtNuevaDireccion = get(FORMULARIO+".txtNuevaDireccion"); 
                           obj.txtNuevoTelefono = get(FORMULARIO+".txtNuevoTelefono"); 
                           obj.rbPasaAlAdministrador = get(FORMULARIO+".rbPasaAlAdministrador"); 
                           obj.rbPeticionBloqueoAdministrativo = get(FORMULARIO+".rbPeticionBloqueoAdministrativo"); 
                           obj.rbPeticionDesBloqueoAdministrativo = get(FORMULARIO+".rbPeticionDesBloqueoAdministrativo"); 
                           obj.cbMotivoNoCobro = get(FORMULARIO+".cbMotivoNoCobro"); 
                           obj.areatxtObservaciones = get(FORMULARIO+".areatxtObservaciones"); 
                           obj.compromisosDePago = get('frmFormulario.compromisosDePago');
                           obj.oidTipoBloqueo = get('frmFormulario.cbTipoBloqueo');

                           objParamsInt.parametros = obj;
                           setValues(objParamsInt);
                  }

    }

         function errorAlGuardar(){  	    
                  focaliza("frmFormulario.cbEtapa");		
         }

         function paginaIncial(){  	 
                  var accionLP;
                  var accion = get('frmFormulario.accion');

                  if(accion=="crearGestionSeguimientoTel") {
                           accionLP= 'ejecutarSeguimientoTel';
                  } else if(accion=="crearGestion") {
                           accionLP= '';
                  }
                  
                  var objParamsInt = new Object();
                  objParamsInt.opener = window;
                  objParamsInt.destino ='LPCrearGestion';
                  objParamsInt.conectorAction= 'LPCrearGestion';
                  
                  var obj = new Object();
                  obj.accion = accionLP;
                  objParamsInt.parametros = obj;
                  eval('frmContenidoEnvia').oculto = 'N';
                  setValues(objParamsInt);
                 
                     /*set('frmFormulario.conectorAction', 'LPCrearGestion');
                     var accion = get('frmFormulario.accion');
                     
                     
                     eval('frmFormulario').oculto = 'N';
                     enviaSICC('frmFormulario');*/
         }

function fVolver(){     
         window.close();
}

function setValues(objParams){
         if(objParams.parametros){

                  var atributos;
                  //Limpio todos los campos insertados del frm que envio
                  eliminaElementosDinamicos();
                  for(atributos in objParams.parametros){
                           if(atributos != "window" && atributos != "length"){
                                    var hidden = document.createElement("INPUT");
                                    hidden.type = "hidden";
                                    hidden.insertado = "1";
                                    hidden.name = atributos;
                                    hidden.value = (objParams.parametros[atributos]==null)?"":objParams.parametros[atributos];
                                    document.forms["frmContenidoEnvia"].appendChild(hidden);
                           }
                  }
                  set('frmContenidoEnvia.conectorAction', objParams.conectorAction);
                  enviaSICC("frmContenidoEnvia");
         }
         
}

/*Limpio todos los campos insertados 
dinámicamente porque sino crea otros con el mismo nombre
*/
function eliminaElementosDinamicos(){
         var elementos = document.forms["frmContenidoEnvia"].elements;
         var longitud = elementos.length;
         for ( i = 0;i < longitud; i++ ){
                  var oChild=document.forms["frmContenidoEnvia"].children(i);	
                  if (oChild!= null && oChild.insertado=="1"){
                           document.forms["frmContenidoEnvia"].removeChild(oChild);
                           i = i-1;
                  }
         }
}


function onClickBloqueo(){
                  if (get('frmFormulario.rbPeticionBloqueoAdministrativo')=='S'){
                           // vbongiov --26/05/2008
                           set('frmFormulario.rbPasaAlAdministrador','N');
                           set('frmFormulario.rbPeticionDesBloqueoAdministrativo','N');

                           recargaCombo('frmFormulario.cbTipoBloqueo', 'COBObtenerTipoBloqueos', 
                                    'es.indra.sicc.util.DTOOID',[['oidPais', get('frmFormulario.hPais')],['oidIdioma',get('frmFormulario.hIdioma')]],
                                    "seteaValorTipoBloqueo(datos);");
                  }else{
                     set_combo("frmFormulario.cbTipoBloqueo",new Array());
                  }
         
}

function onClickDesbloqueo(){
   if(get('frmFormulario.rbPeticionDesBloqueoAdministrativo')=='S'){

            var codCliente = get('frmFormulario.txtCodigoCliente');
                   if (codCliente.length != 0)  {

                  /*	recargaCombo('frmFormulario.cbTipoBloqueo', 'COBObtenerTipoBloqueos', 
                                    'es.indra.sicc.util.DTOOID',[['oid',  ],['oidPais', get('frmFormulario.hPais')],
                                    ['oidIdioma',get('frmFormulario.hIdioma')]],"seteaValorTipoBloqueo(datos);");*/
                  
                           var objParamsInt = new Object();
                           objParamsInt.opener = window;
                           objParamsInt.destino ='LPCrearGestion';
                           objParamsInt.conectorAction= 'LPCrearGestion';
                           
                           var obj = new Object();
                           obj.oidCliente = objVarGen.hOidCliente ;
                           obj.accion = 'obtenerBloqueoCliente';
                           objParamsInt.parametros = obj;
                           setValues(objParamsInt);	

                  }else{
                           GestionarMensaje('742', null, null, null);
                           set('frmFormulario.rbPeticionDesBloqueoAdministrativo','N');
                  }
   }else{
            set_combo("frmFormulario.cbTipoBloqueo",new Array());
   }

}

function seteaValorTipoBloqueo(datos){
         var datosNuevo = new Array();
         datosNuevo[0] = ["",""];

         for (var i = 0; i < datos.length; i++ )
                  datosNuevo[i+1]  = datos[i];

         set_combo("frmFormulario.cbTipoBloqueo", datosNuevo);
}

function asignarDatosTipoBloqueo(datos){
         // vbongiov --26/05/2008
         set('frmFormulario.rbPasaAlAdministrador','N');
         set('frmFormulario.rbPeticionBloqueoAdministrativo','N');

         var objt = datos.split(";");

         var datosNuevo = new Array();
         datosNuevo[0] = [objt[0],objt[1]];

         set_combo("frmFormulario.cbTipoBloqueo", datosNuevo);
}

function errorTipoBloqueo(){
         set('frmFormulario.rbPeticionDesBloqueoAdministrativo','N');
}

