var FORMULARIO = 'frmFormulario';
var deshabilitadoAceptar = false;
var deshabilitadoEjecutar = false;
var filaEvento = null;
var nIdentificacion = 0;



var totalResultado = 0;

varNoLimpiarSICC = true;
// controladores de alertas de campo no válido para las listas editables
// si se pierde el foco en un campo no válido de la lista editable por enfocar otro campo de la lista editable, la validacion de formulario volverá a pasar el foco
// al campo no válido con lo que pierde el foco el campo y se realizaría una nueva validación del formulario, con estas variables se evita esta segunda validacion.
var filaInvalida = -1; 
var columnaInvalida = -1; 

var objsGen = new Object();
objsGen.subacceso = "";
objsGen.acceso = "";
objsGen.listaVisible ="";

function desbloquear(){

   if(get(FORMULARIO + '.errCodigo') != '230340061'){

      window.onbeforeunload = null;
      window.onunload = null;
   
      set(FORMULARIO + '.accion','borrarBloqueo');
      set(FORMULARIO + '.conectorAction',"LPAplicarCargosAbonos");
      eval(FORMULARIO).oculto = 'S';
      enviaSICC(FORMULARIO);                             
   }

}


function onLoadPag() {
         window.onunload = desbloquear;
		 window.onbeforeunload = desbloquear;

         var strCasoDeUso = get(FORMULARIO + '.casoUso');
        
         nIdentificacion = Number(get(FORMULARIO + '.NIdentificacion'));
		 try{
             gestionaError(strCasoDeUso);
			 menuSecundario();
		 }catch(e){
		 }

		 if(get(FORMULARIO + '.errCodigo') == '230340061'){
		    fSalir(true);
		 }


		

         /*if (window.dialogArguments) { // Si es modal (se abrió mediante showModalDialog) DBLG500000915
             btnProxy(2,1);  // boton 'volver', habilitado
             btnProxy(3,0);  // boton 'Ir a pantalla de inicio', deshabilitado
    }*/
         /* para que hacer esto si en el onload de la pagina tienen un visibility = hidden
         if(strCasoDeUso!="consultar"){
                  DrdEnsanchaConMargenDcho('listado4',12);
                  DrdEnsanchaConMargenDcho('listado3',12);
                  DrdEnsanchaConMargenDcho('listado2',12);
                  DrdEnsanchaConMargenDcho('listado1',12);
                  setTimeout('eval (ON_RSZ);');//[1]
                  //[1] ON_RSZ = '';

         } */

         objsGen.subacceso = get(FORMULARIO + '.subacceso'); //[1]
         if (strCasoDeUso != ''){
                  document.all['btnAceptar'].disabled = true;
                  deshabilitadoAceptar = true;
                  deshabilitadoEjecutar = true;
                  

         }else if (strCasoDeUso == 'gestionarCheques'){
                  deshabilitadoEjecutar = false;
                  document.all['btnAceptar'].disabled = true;
                  deshabilitadoAceptar = true;
                  seleccionarAcceso(); //[1]
         }
                    
         if (strCasoDeUso == ''){
                  focaliza(FORMULARIO + ".cbAplicacion");
                  seleccionarAcceso(); //[1]
         }else if (strCasoDeUso == 'gestionarCheques'){
                  accionAceptar();
                  focaliza(FORMULARIO + ".cbEmpresa");
         }else{
                  focaliza(FORMULARIO + ".cbEleccion");
         }
         
         if (strCasoDeUso == 'modificar') {
                  btnProxy(1, 1);
         }

    if (window.dialogArguments) { // Si es modal (se abrió mediante showModalDialog) DBLG500000915
             btnProxy(2,1);  // boton 'volver', habilitado
             btnProxy(3,0);  // boton 'Ir a pantalla de inicio', deshabilitado

    } 

}
//Selecciona valor por defecto para los combos acceso y subacceso
function preseleccionaValores() {
           canalOnChange();
           //[1] var subacceso = get(FORMULARIO + '.subacceso');
           //[1] var acceso = get(FORMULARIO + '.acceso');
           set(FORMULARIO + '.cbAcceso', [objsGen.acceso]);//[1][acceso]);
           accesoOnChange();
           set(FORMULARIO + '.cbSubacceso', [objsGen.subacceso]);//[1] [subacceso]);
} 
function menuSecundario() {
           configurarMenuSecundario(FORMULARIO);
}

function accionAceptar() {
         banderaConfirmarCierreInactividad = true;
         banderaConfirmarCierreGuardar = false;
	    

         if (!deshabilitadoAceptar) {
                  if (!sicc_validaciones_generales("grupo1")) return false;

                  var oid = get(FORMULARIO + '.cbAplicacion');

                  if (oid != "") {
                           var pais = get(FORMULARIO + '.pais');
                           var idioma = get(FORMULARIO + '.idioma');
                           recargaCombo(FORMULARIO + '.cbEleccion', 'CCCRecargaSubprocesos', 'es.indra.sicc.util.DTOOID', [["oidPais", pais], ["oidIdioma", idioma], ["oid", oid]]);
                  }
                  //bloquear boton aceptar
                  document.all['btnAceptar'].disabled = true;
                  deshabilitadoAceptar = true;
                  deshabilitaAceptar();
				  window.onbeforeunload = desbloquear;
		          window.onunload = desbloquear;
                  btnProxy(1,1);
                  //cargar numero de identificacion
                  set(FORMULARIO + '.accion','aceptar');
                  set(FORMULARIO + '.conectorAction',"LPAplicarCargosAbonos");
                  eval(FORMULARIO).oculto = 'S';
                  enviaSICC(FORMULARIO);                             					
         }
}

         
 function accionSeleccionarCliente() {
                    if (!deshabilitadoEjecutar) {
                                        //Abrimos un popup modal con la direccion de la LPBusquedaRapidaCliente
                                        //cuando se cierra el popup si el usuario ha seleleccionado un cliente se nos devuelven dos valores en un array.
                                        //Con el segundo rellenamos el campo codigoCliente
                                        var objParams = new Object();
                    var resultado = mostrarModalSICC('LPBusquedaRapidaCliente', '', objParams, null, null);
                    if (resultado != null && resultado.length > 1)
                                                                set(FORMULARIO + '.txtCodCliente', resultado[1]);
                    }
 }
 
 function canalOnChange() {
                    //recargamos el de accesos a partir de las listas ocultas
                    var canal =get(FORMULARIO + '.cbCanal');
                    if (canal != "") {
                                        var accesos = new Array();
                                        accesos[0] = ['', ''];
                                        //cargar acceso del array datosAcceso
                                        if (typeof(datosAccesos) != 'undefined') {
                                                                for (i=0; i < datosAccesos.length; i++) { 
                                                                                   if (datosAccesos[i][2] ==  canal) { 
                                                                                                      accesos [accesos.length] = [datosAccesos[i][0], datosAccesos[i][1]]; 
                                                                                   }
                                                                }
                                        }
                                        set_combo(FORMULARIO + '.cbAcceso', accesos, ['']);
                                        vaciaCombo(FORMULARIO + '.cbSubacceso');
                    } else {
                                        vaciaCombo(FORMULARIO + '.cbAcceso');
                                        vaciaCombo(FORMULARIO + '.cbSubacceso');
                    }	
 } 
          
 function accesoOnChange() {
                    //recargamos el de subaccesos a partir de las listas ocultas
                    var acceso =get(FORMULARIO + '.cbAcceso');
                    if (acceso != "") {
                                        //cargar subacceso del array datosSubacceso
                                        var subaccesos = new Array();
                                        subaccesos[0] = ['', ''];
                                        //cargar acceso del array datosAcceso
                                        if (typeof(datosSubaccesos) != 'undefined') {
                                                                for (i=0; i < datosSubaccesos.length; i++) { 
                                                                                   if (datosSubaccesos[i][2] ==  acceso) { 
                                                                                                      subaccesos [subaccesos.length] = [datosSubaccesos[i][0], datosSubaccesos[i][1]]; 
                                                                                   }
                                                                }
                                        }
                                        set_combo(FORMULARIO + '.cbSubacceso', subaccesos, ['']);
                    } else {
                                        vaciaCombo(FORMULARIO + '.cbSubacceso');
                    }	
 } 

function vaciaCombo(combo) {
         if (combo_get(combo,'L') >1){
                  set_combo(combo,[['','']],['']);
         }	  
}
 
 function accionEjecutar() {
                    //[1] var numListadoVisible = get(FORMULARIO + '.listaVisible');
                    //Comprobar que se ha seleccionado un subproceso.
                    var subproceso = get(FORMULARIO + '.cbEleccion');
                    if (subproceso == "") {
                                                                GestionarMensaje('1087');
                                                                focaliza(FORMULARIO + '.cbEleccion');
                                                                return;
                    }
                    var proceso = get(FORMULARIO +'.cbAplicacion','T');
                    if(proceso == 'CCC004'){
                                        var cliente = get(FORMULARIO +'.txtCodCliente');
                                        if(cliente == ''){
                                                                GestionarMensaje('1372');
                                                                focaliza(FORMULARIO + '.txtCodCliente');
                                                                return;
                                        }
                    }
                    if (!deshabilitadoEjecutar) {
                                        //Los campos obligatorios de la cabecera deben haber sido rellenados;
                                        if (!sicc_validaciones_generales()) return false;
                                        //valida(form+'.'+campo, true, true) //para validar campo a campo
                                        //los deshabilitamos, de modo que sólo quedan habilitados los campos de las listas y el combo subproceso
                                        deshabilitaEjecutar();
                                        deshabilitadoEjecutar = true;
                    }		
                    visibilidad('capaImportes', 'V');
                    
                    //Guardamos en la variable listaVisible el nombre del componente lista que contiene la capa. 
                                        if (subproceso == '1') {
                                                                hacerInvisible(objsGen.listaVisible);
                                                                hacerVisible(1);
                                                                //set(FORMULARIO + '.listaVisible', '1');
                                                                objsGen.listaVisible = '1';
                                                                if (get(FORMULARIO + '.modificable') == 'true') {
                                                                                   var codigoCliente = get(FORMULARIO + '.txtCodCliente');
                                                                                   var proceso = get(FORMULARIO + '.cbAplicacion');
                                                                                   var empresa = get(FORMULARIO + '.cbEmpresa');
                                                                                   var canal = get(FORMULARIO + '.cbCanal');
                                                                                   var acceso = get(FORMULARIO + '.cbAcceso');
                                                                                   var subacceso = get(FORMULARIO + '.cbSubacceso');
                                                                                   //set(FORMULARIO + '.codigoCliente', codigoCliente);
                                                                                   //set(FORMULARIO + '.proceso', proceso);
                                                                                   //set(FORMULARIO + '.empresa', empresa);
                                                                                   //Ha seleccionado Cancelacion de cuotas. 
                                                                                   //Mostramos la capa de cancelacion de cuotas 
                                                                                   //Abrimos un popup direccionando a la LPCancelacionCuotas y le pasamos como parametros los valores de los campos codigoCliente, proceso y empresa 
                                                                                   var objParams = new Object();
                                                                         objParams.codigoCliente = codigoCliente;
                                                                         objParams.proceso = proceso;
                                                                         objParams.empresa = empresa;
                                                                         objParams.subproceso = subproceso;
                                                                         objParams.canal = canal;
                                                                         objParams.acceso = acceso;
                                                                         objParams.subacceso = subacceso;
                                                                                   var datos = mostrarModalSICC('LPCancelacionCuotas', '', objParams, null, null);
                                                                                   //datos = [['1', '1', 'AA1', '1', '123', '12/05/2004', '12/06/2004', 'Medio Pago 1', '7000', '500', '6500', 'Peso', '3500', '6500', '1', '2', '1', '']];
                                                                if (typeof(datos) != 'undefined') {
                                                                                                     if(listado1.datos.length > 0){
																										   var y = listado1.datos.length;
																										   for (var i=0;i<datos.length;i++) {	
																											  var bandera = true;
																											  for (var x=0;x<y;x++) {
																												 var fila = datos[i];
																												 if(listado1.datos[x][10] == fila[0]){
																													bandera = false;
																												break;
																												 }
																											  }
																											  if(bandera){
																											listado1.insertar(addVacioDatosAC(fila, 21));
																											  }
																										   }
																										}else{
																										   for (var i=0;i<datos.length;i++) {
																											  var fila = datos[i];
																											  listado1.insertar(addVacioDatosAC(fila, 21));
																										   }
																										}
        
                                                                                                      listado1.reajusta();
                                                                                                      btnProxy(4,1);
                                                                                   }
                                                                }
                                        } 

                                        if (subproceso == '2') {
                                                                hacerInvisible(objsGen.listaVisible);
                                                                hacerVisible(2);
                                                                //[1] set(FORMULARIO + '.listaVisible', '2');
                                                                objsGen.listaVisible='2';
                                                                if (get(FORMULARIO + '.modificable') == 'true') {
                                                                                   var codigoCliente = get(FORMULARIO + '.txtCodCliente');
                                                                                   var empresa = get(FORMULARIO + '.cbEmpresa');
                                                                                   //Ha seleccionado Aplicacion de cobros 
                                                                                   //Mostramos la capa de Aplicacion de cobros 
                                                                                   //Abrimos un popup direccionando a la LPAplicacionCobros y le pasamos como parametros los valores de los campos codigoCliente y empresa. 
                                                                                   var objParams = new Object();
                                        objParams.codigoCliente=codigoCliente;
                                        objParams.empresa=empresa;
                                                                var datos = mostrarModalSICC('LPAplicacionCobros', '', objParams, null, null);
                                                                                                      //datos =[['2', '', '', 'cuenta 1', '', '150000,69', '150000,69', '1', '2', '']];
                                                                if (typeof(datos) != 'undefined') {
																									  if(listado2.datos.length > 0){
																										 var y = listado2.datos.length;
																										 for (var i=0;i<datos.length;i++) {	
																										    var bandera = true;
																										    for (var x=0;x<y;x++) {
																											   var fila = datos[i];
																											   if(listado2.datos[x][10] == fila[0]){
																											      bandera = false;
																												  break;
																											   }
																										    }
																											if(bandera){
																												listado2.insertar(addVacioDatosAC(fila, 12));
																											}
																										 }
																						

																									  }else{
																										   for (var i=0;i<datos.length;i++) {
																											   var fila = datos[i];
																											   listado2.insertar(addVacioDatosAC(fila, 12));
																										   }
																									  
																									  }
                                                                                                      listado2.reajusta();
                                                                                                      btnProxy(4,1);
                                                                                   }
                                                                }
                                        } 
 
                                        if (subproceso == '3') {
                                                                hacerInvisible(objsGen.listaVisible);
                                                                hacerVisible(3);
                                                                //set(FORMULARIO + '.listaVisible', '3');
                                                                objsGen.listaVisible='3';
                                                                if (get(FORMULARIO + '.modificable') == 'true') {
                                                                                   var codigoCliente = get(FORMULARIO + '.txtCodCliente');
                                                                                   var proceso = get(FORMULARIO + '.cbAplicacion');
                                                                                   var empresa = get(FORMULARIO + '.cbEmpresa');
                                                                                   //Ha seleccionado Conceptos Gastos Abonos 
                                                                                   //Mostramos la capa de Conceptos Gastos Abonos 
                                                                                   //Abrimos un popup direccionando a la LPConceptosGastosAbonos y le pasamos como parametros los valores de los campos codigoCliente, empresa y proceso. 
                                                                                   var objParams = new Object();
                                        objParams.codigoCliente=codigoCliente;
                                        objParams.proceso=proceso;
                                        objParams.empresa=empresa;
                                                                var datos = mostrarModalSICC('LPConceptosGastosAbonos', '', objParams, null, null);
                                                                                   if (typeof(datos) != 'undefined') {
                                                                                                      listado3.insertar(addVacioDatos(datos, 11, true));
                                                                                   }
                                                                                   listado3.reajusta();
                                                                                   btnProxy(4,1);
                                                                }
                                        } 

                                        if (subproceso == '4') {
                                                                hacerInvisible(objsGen.listaVisible);
                                                                hacerVisible(4);
                                                                //set(FORMULARIO + '.listaVisible', '4');
                                                                objsGen.listaVisible='4';
                                                                if (get(FORMULARIO + '.modificable') == 'true') {
                                                                                   var codigoCliente = get(FORMULARIO + '.txtCodCliente');
                                                                                   var canal = get(FORMULARIO +'.cbCanal');
                                                                                   var acceso = get(FORMULARIO +'.cbAcceso');
                                                                                   var subacceso = get(FORMULARIO +'.cbSubacceso');
                                                                                   var canalDes = get(FORMULARIO +'.cbCanal','T');
                                                                                   var accesoDes = get(FORMULARIO +'.cbAcceso','T');
                                                                                   var subaccesoDes = get(FORMULARIO +'.cbSubacceso');
                                                                                   //Ha seleccionado GeneracionVencimientos 
                                                                                   //Mostramos la capa de Generacion de vencimientos 
                                                                                   //Abrimos un popup direccionando a la LPGeneracionVencimientos y le pasamos como parametro el campo codigoCliente.
                                                                                   var objParams = new Object();
                                                                                   objParams.codigoCliente=codigoCliente;
                                                                              objParams.canal = canal;
                                                                              objParams.acceso = acceso;
                                                                              objParams.subacceso = subacceso;
                                                                                   objParams.canalDes = canalDes;
                                                                                   objParams.accesoDes = accesoDes;
                                                                                    objParams.subaccesoDes = subaccesoDes;              		
                                                                                   /*var datos1 =['0', '00000000001', 'maraca', 'canala', 'acceso', 'subac', '0700000012', 'ref', '11/05/2004', '11/04/2004', 'MP', 'USD','20', '40', 'obnser', '1', '1', '1', '1', '1', '', ''];
                                                                                   listado4.insertar(datos1);*/
                                                                                   var datos = mostrarModalSICC('LPGeneracionVencimientos', '', objParams, null, null);
                                                                                   if (typeof(datos) != 'undefined') {
                                                                                                      for (var i=0;i<datos.length;i++) {
                                                                                                                                var fila = datos[i];
                                                                                                                                //alert("fila Tabla:" + fila);
                                                                                                                                listado4.insertar(addVacioDatos(fila, 22, true));
                                                                                                      }
                                                                                                      listado4.reajusta();
                                                                                                      btnProxy(4,1);
                                                                                   }
                                                                }
                                        }
                                        recalcular();
 }


function fBorrar() {
           //Quitamos las filas seleccionadas de la lista que esté mostrandose en primer plano (miramos la variable oculta listaVisible) 
           //var visible =  get(FORMULARIO + '.listaVisible');
           if (objsGen.listaVisible == '1'){
                              if (listado1.numSelecc() > 0 )
                                                      listado1.eliminarSelecc();
                              else
                                                      GestionarMensaje('50');
           } else if (objsGen.listaVisible == '2'){
                              if (listado2.numSelecc() > 0 )
                                                      listado2.eliminarSelecc();
                              else
                                                      GestionarMensaje('50');
           } else if (objsGen.listaVisible == '3'){
                              if (listado3.numSelecc() > 0 )
                                                      listado3.eliminarSelecc();
                              else
                                                      GestionarMensaje('50');
           } else if (objsGen.listaVisible == '4'){
                              if (listado4.numSelecc() > 0 )
                                                      listado4.eliminarSelecc();
                              else
                                                      GestionarMensaje('50');
           }
           if (listado1.datos.length == 0 && listado2.datos.length == 0 && listado3.datos.length == 0 && listado4.datos.length == 0)
         btnProxy(4, 0);

           recalcular();
}

                  /*=====================================*/

                   /* 11-07-2006 - mmaidana - se reemplazo el caracter @ por una constantes definida en LPAplicarCargosAbonos. */
function fGuardar() {
	     
		 window.onbeforeunload = null;
         window.onunload = null;
         

         var separadorColumnas = get(FORMULARIO + '.separadorColumnas');

         if (comprobarFecha(get(FORMULARIO + '.txtFechaValor')) != 'OK') {document.body.focus();return false;}
         if (!sicc_validaciones_generales()) { return false; }
         if (!ValidaForm(FORMULARIO, false)) { document.body.focus();return false; }

         codigoClienteOnBlur();
         recalcular();

         if (totalResultado != 0) {
                  cdos_mostrarAlert(GestionarMensaje('1348'));
                  return false;
         }

         //recuperar lsitados
         /* 11-07-2006 - mmaidana - se reemplazo el caracter @ por una constantes definida en LPAplicarCargosAbonos. */

         //separamos los campos de cada fila por el caracter @
         //separamos las filas por el caracter #
         //los campos vacíos se ponen a '-' para que con Stringtokenizer no se pierda la secuencia de columnas 

         /* LISTADO 1 */
         //listado1.actualizaDat(); //Actualiza el array 'datos'
         var cancelacionCuotasCadena = "";
         var datosFinal = listado1.datos;
         var arrayNombreCampos = new Array("oid", "Cód. cliente", "Canal", "Acceso", "Subacceso", "Nº documento", 
                  "Nº orden cuota", "Fecha doc.", "Fecha vencimiento", "Medio pago teórico", "Importe cuota", 
                  "Importe aplicado", "Importe pendiente", "Divisa", "Importe divisa", "Importe a aplicar", 
                  "medioPagoOid", "oidMovimiento", "oidDetalle");

         cancelacionCuotasCadena = listaToXML(arrayNombreCampos, datosFinal, 'cancelacionCuotas');
         //[1] set(FORMULARIO + '.cancelacionCuotas', cancelacionCuotasCadena);

         /* LISTADO 2 */
         //listado2.actualizaDat(); //Actualiza el array 'datos'
         var aplicacionCobrosCadena = "";
         datosFinal = listado2.datos;
         arrayNombreCampos = new Array("oid", "Cód. cliente", "Cuenta corriente bancaria", "Fecha pago", 
                  "Nº lote", "Consecutivo transacción", "Importe pago", "Importe pendiente", "Importe a aplicar", 
                  "cuentaCorrienteOid", "oidMovimiento", "oidDetalle");

         aplicacionCobrosCadena = listaToXML(arrayNombreCampos, datosFinal, 'aplicacionCobros');
         //[1] set(FORMULARIO + '.aplicacionCobros', aplicacionCobrosCadena);

         /* LISTADO 3 */
         //listado3.actualizaDat(); //Actualiza el array 'datos'
         var aplicacionGastosCadena = "";
         datosFinal = listado3.datos;
         arrayNombreCampos = new Array("oid", "Cód. cliente", "CCC", "Tipo abono", "Glosa contable", 
                  "Divisa", "Importe", "Importe divisa", "cuentaCorrienteOid", "tipoAbonoOid", "oidDetalle");

         aplicacionGastosCadena = listaToXML(arrayNombreCampos, datosFinal, 'aplicacionGastos');
         //[1] set(FORMULARIO + '.aplicacionGastos', aplicacionGastosCadena);

         /* LISTADO 4 */
         //listado4.actualizaDat(); //Actualiza el array 'datos'
         var generacionVencimientosCadena = "";
         datosFinal = listado4.datos;
         arrayNombreCampos = new Array("oid", "Cód. cliente", "Marca", "Canal", "Acceso", "Subacceso", 
                  "Nº documento", "Referencia externa", "Fecha valor", "Fecha vencimiento", "Medio pago teórico", 
                  "Divisa", "Importe", "Importe divisa", "Observaciones", "medioPagoOid", "marcaOid", "canalOid" , 
                  "accesoOid", "subaccesoOid" , "oidMovimiento", "oidDetalle");

         generacionVencimientosCadena = listaToXML(arrayNombreCampos, datosFinal, 'generacionVencimientos');
         //[1] set(FORMULARIO + '.generacionVencimientos', generacionVencimientosCadena);

         /* ENVIAR */
         //[1] set(FORMULARIO + '.accion','guardar');
         //[1] set(FORMULARIO + '.conectorAction',"LPAplicarCargosAbonos");
         //[1] enviaSICC(FORMULARIO);
         
         
         var objParam = new Object();
         objParam.cancelacionCuotas = cancelacionCuotasCadena;
         objParam.aplicacionCobros = aplicacionCobrosCadena;
         objParam.aplicacionGastos = aplicacionGastosCadena;
         objParam.generacionVencimientos = generacionVencimientosCadena;
         objParam.NIdentificacion = nIdentificacion;
         objParam.txtCodCliente = get(FORMULARIO+'.txtCodCliente');
         objParam.htxtFechaDocumento = get(FORMULARIO+'.htxtFechaDocumento');
         objParam.txtFechaValor = get(FORMULARIO + '.txtFechaValor');
         objParam.cbEmpresa = get(FORMULARIO + '.cbEmpresa');
         objParam.txtReferenciaExterna = get(FORMULARIO + '.txtReferenciaExterna');
         objParam.cbSubacceso =get(FORMULARIO + '.cbSubacceso');
         objParam.cbAcceso = get(FORMULARIO + '.cbAcceso');
         objParam.areatxtObservaciones = get(FORMULARIO + '.areatxtObservaciones');
         objParam.oid = get(FORMULARIO + '.oid');
         objParam.cbAplicacion = get(FORMULARIO + '.cbAplicacion');
         objParam.cbCanal = get(FORMULARIO + '.cbCanal');
         objParam.casoUso = get(FORMULARIO + '.casoUso');
         objParam.accion = 'guardar';
         
         var objEnvia = new Object();
         objEnvia.opener = window;
         objEnvia.destino ='LPAplicarCargosAbonos';
         objEnvia.conectorAction= 'LPAplicarCargosAbonos';
         objEnvia.parametros = objParam;
         setValues(objEnvia);
}

function listaToXML(arrayNombreCampos, datos, nombreCasoDeUso) {

         var cantFilas = datos.length;
         var ultimaLinea = parseInt(cantFilas, 10)-1;
         /* var separadorMiles = get("frmContenido.hSeparadorDecimalPais"); */
         var xmlDoc = "<?xml version='1.0' encoding='ISO-8859-1' standalone='yes'?>";

         xmlDoc = xmlDoc + "<DOC>";

         /* Recorre las filas */ 
         for (var i = 0; i < cantFilas; i++) {
                  var linea = datos[i]; 
                  var cantCampos = linea.length;
                  xmlDoc = xmlDoc + "<ROW>";

                  /* Recorre los campos dentro de la fila */
                  for (var j = 0; j < cantCampos; j++ ) {
                           /* Quito formato local de numero */ 
                           var campo = linea[j] + ''; 

                           // dmorello, 03/08/2006: Quito el formato del numero, segun el caso de uso...
                           if ((nombreCasoDeUso == 'cancelacionCuotas' && (j == 6 || (j >= 10 && j <= 12) || j == 14 || j == 15))
                                             || (nombreCasoDeUso == 'aplicacionCobros' && (j >= 5 && j <= 8))
                                             || (nombreCasoDeUso == 'aplicacionGastos' && (j == 6 || j == 7))
                                             || (nombreCasoDeUso == 'generacionVencimientos' && (j == 12 || j == 13))) {

                                    campo = '' + numeroDeFormatoSICC(campo);
                           }


                           xmlDoc = xmlDoc + "<CAMPO nombre='" + arrayNombreCampos[j] + "'>" + SICC_DrdEscXML(campo) + "</CAMPO>";
                  }

                  xmlDoc = xmlDoc + "</ROW>"

         }

         xmlDoc = xmlDoc + "</DOC>";
         
         return xmlDoc; 
}


/*function recalcular() {
           //Nota: todas las sumas tienen en cuenta el signo de cada sumando 
           //Hacemos la suma de los elementos en la columna importeAplicar de la lista cancelacionCuotas y ponemos el resultado en el label importeCuotasCancelar 
           listado1.actualizaDat(); //Actualiza el array 'datos'
           var datos = listado1.datos;
           var suma = 0;
           var total = 0;
           var separaDecim = get(FORMULARIO + '.hid_SeparadorDecimales');
           var separaMiles = get(FORMULARIO + '.hid_SeparadorMiles');

           for (i = 0; i < datos.length; i++) {
                              var fila = datos[i];
                              if (fila[15] != "") {//importeAplicar
                                                      suma += obtieneNumeroDecimal(fila[15], separaDecim);
                              }
           }
           if (suma != 0){
                    // Modificado por splatas - BELC300023075 - 30/05/2006
                    //txt_to('lblvalorImporteCuotas', formateaImporte(suma.toString(), get(FORMULARIO + '.hid_SeparadorMiles'), get(FORMULARIO + '.hid_SeparadorDecimales')));
                    txt_to('lblvalorImporteCuotas', 
                             formatImport(suma.toString(), 
                                      separaMiles, 
                                      separaDecim);
           } else {
                              txt_to('lblvalorImporteCuotas', suma);
           }                              
           total += suma;

           //Hacemos la suma de los elementos en la columna importe de la lista aplicacionCobros y ponemos el resultado en el label importeCobrosAplicar 
           listado2.actualizaDat(); //Actualiza el array 'datos'
           datos = listado2.datos;
           suma = 0;
           for (i = 0; i < datos.length; i++){
                           valor = datos[i][8];
                           if (valor != ""){
                                    suma += obtieneNumeroDecimal(valor, separaDecim);
                           }
                                                      
           }
           if (suma != 0){
                           txt_to('lblvalorImporteCobros', formateaImporte(suma.toString(), separaMiles, separaDecim);
           }else{
                      txt_to('lblvalorImporteCobros', suma);
           }
           total -= suma;
           
           
           //Hacemos la suma de los elementos en la columna importeAplicar de la lista conceptosGastosAbonos y ponemos el resultado en el label importeConceptosGastosAbonos. 
           listado3.actualizaDat(); //Actualiza el array 'datos'
           datos = listado3.datos;
           suma = 0;
           for (i = 0; i < datos.length; i++){
                              if (datos[i][6] != ""){
                                                      suma += obtieneNumeroDecimal(datos[i][6], separaMiles);
                                    }
           }
           if (suma != 0){
                              txt_to('lblvalorImporteConceptos', formateaImporte(suma.toString(), separaMiles, separaDecim);
           }else{
                              txt_to('lblvalorImporteConceptos', suma);
           }
           
           total -= suma;
           
           //Hacemos la suma de los elementos en la columna importeCuota de la lista generacionVencimientos y ponemos el resultado en el label importeGeneracionVencimientos. 
           listado4.actualizaDat(); //Actualiza el array 'datos'
           datos = listado4.datos;
           suma = 0;
           for (i = 0; i < datos.length; i++){
                     if (datos[i][12] != ""){
                                             suma += obtieneNumeroDecimal(datos[i][12], separaDecim);
                     }
           }
           if (suma != 0){
                              txt_to('lblvalorImporteGeneracion', formateaImporte(suma.toString(), separaMiles, separaDecim);
           }else{
                              txt_to('lblvalorImporteGeneracion', suma);
           }
           
           total -= suma;
           
           if (total != 0){
                    // splatas - BELC300023075 - 30/05/2006 
                    //txt_to('lblvalorResultado', formateaImporte(total.toString(), get(FORMULARIO + '.hid_SeparadorMiles'), get(FORMULARIO + '.hid_SeparadorDecimales')));
                    txt_to('lblvalorResultado', 
                           formatImport(total.toString(), 
                                                        separaMiles
                                                        separaDecim);
           
           } else {
                    txt_to('lblvalorResultado', total);
           }    
           
           totalResultado = total;
}
*/
          function recalcular() {
                    //Nota: todas las sumas tienen en cuenta el signo de cada sumando 
                    //Hacemos la suma de los elementos en la columna importeAplicar de la lista cancelacionCuotas y ponemos el resultado en el label importeCuotasCancelar 
                    listado1.actualizaDat(); //Actualiza el array 'datos'
                    var datos = listado1.datos;
                    var suma = 0;
                    var total = 0;
                                      var separadorDecimales =get(FORMULARIO + '.hid_SeparadorDecimales');
                                      var separadorMiles = get(FORMULARIO + '.hid_SeparadorMiles');

                    for (i = 0; i < datos.length; i++) {
                              var fila = datos[i];
                              if (fila[15] != "") {//importeAplicar
                                         suma += obtieneNumeroDecimal(fila[15], separadorDecimales );
                              }
                    }

                                      suma=(Math.round(suma * 100) / 100)

                    if (suma != 0){                                              
                         // Modificado por splatas - BELC300023075 - 30/05/2006
                         //txt_to('lblvalorImporteCuotas', formateaImporte(suma.toString(), get(FORMULARIO + '.hid_SeparadorMiles'), get(FORMULARIO + '.hid_SeparadorDecimales')));
                         txt_to('lblvalorImporteCuotas', 
                             formatImport(suma.toString(), separadorMiles, separadorDecimales));
                    } else {
                              txt_to('lblvalorImporteCuotas', suma);
                    }              
                                      
                    total += suma;

                    //Hacemos la suma de los elementos en la columna importe de la lista aplicacionCobros y ponemos el resultado en el label importeCobrosAplicar 
                    listado2.actualizaDat(); //Actualiza el array 'datos'
                    datos = listado2.datos;
                    suma = 0;
                    for (i = 0; i < datos.length; i++){
                    valor = datos[i][8];
                              if (valor != "")
                                         suma += obtieneNumeroDecimal(valor, separadorDecimales);
                                         
                    }

                                      suma=(Math.round(suma * 100) / 100)

                    if (suma != 0)
                              txt_to('lblvalorImporteCobros', formateaImporte(suma.toString(), separadorMiles, separadorDecimales));
                    else
                              txt_to('lblvalorImporteCobros', suma);
                    
                    total -= suma;                    
                    
                    //Hacemos la suma de los elementos en la columna importeAplicar de la lista conceptosGastosAbonos y ponemos el resultado en el label importeConceptosGastosAbonos. 
                    listado3.actualizaDat(); //Actualiza el array 'datos'
                    datos = listado3.datos;
                    suma = 0;
                    for (i = 0; i < datos.length; i++)
                              if (datos[i][6] != "")
                                         suma += obtieneNumeroDecimal(datos[i][6], separadorDecimales);

                                      suma=(Math.round(suma * 100) / 100)

                    if (suma != 0)
                              txt_to('lblvalorImporteConceptos', formateaImporte(suma.toString(), separadorMiles, separadorDecimales));
                    else
                              txt_to('lblvalorImporteConceptos', suma);
                    
                    total -= suma;
                    
                    //Hacemos la suma de los elementos en la columna importeCuota de la lista generacionVencimientos y ponemos el resultado en el label importeGeneracionVencimientos. 
                    listado4.actualizaDat(); //Actualiza el array 'datos'
                    datos = listado4.datos;
                    suma = 0;
                    for (i = 0; i < datos.length; i++)
                              if (datos[i][12] != "")
                                         suma += obtieneNumeroDecimal(datos[i][12], separadorDecimales);
                                      
                                      suma=(Math.round(suma * 100) / 100)

                    if (suma != 0)
                              txt_to('lblvalorImporteGeneracion', formateaImporte(suma.toString(), separadorMiles, separadorDecimales));
                    else
                              txt_to('lblvalorImporteGeneracion', suma);
                    
                    total -= suma;
                    
                    if (total != 0){
                         // splatas - BELC300023075 - 30/05/2006 
                         //txt_to('lblvalorResultado', formateaImporte(total.toString(), get(FORMULARIO + '.hid_SeparadorMiles'), get(FORMULARIO + '.hid_SeparadorDecimales')));
                         txt_to('lblvalorResultado', 
                           formatImport(total.toString(), 
                                          separadorMiles, 
                                          separadorDecimales));
                    
                    } else {
                         txt_to('lblvalorResultado', total);
                    }    

                    totalResultado = total;
          }
//Añade los datos de la matriz datosAñadir a la matriz datosInicial (las columnas para las que no llegue valor se ponen a cadena vacía)
function incluyeVacioDatos(datosInicial, datosAñadir, longitud) {
           //debemos recibir un array en el que cada fila es un array con los campos para rellenar una fila de la lista (si faltan columnas se dejan vacías las últimas ññññ);
           // debemos añadir un primer elemento vacío para que vaya en la columna oculta que tienen las listas editables 
           /*var datos2 = datosInicial;
           for (i = 0; i < datosAñadir.length; i++) {
                              fila = new Array();
                              //fila[0] = [""];
                              for (j = 0; j < datosAñadir[i].length; j++)
                                                      fila[fila.length] = datosAñadir[i][j];
                              // rellenar con vacios la fila
                              for (j = fila.length; j < longitud; j++)
                                                      fila[fila.length] = [""];
                                                      
                              datos2[datos2.length] = fila;
           }
           return datos2;*/
}

//Añade los datos de la matriz datosAñadir a la matriz datosInicial (las columnas para las que no llegue valor se ponen a cadena vacía)
function addVacioDatos(datos, longitud, addPrimeraColumna) {
           //debemos recibir un array en el que cada fila es un array con los campos para rellenar una fila de la lista ();
           // debemos añadir un primer elemento vacío para que vaya en la columna oculta que tienen las listas editables 
           var filaNueva = new Array();
           if (addPrimeraColumna != null && addPrimeraColumna) 
                                                                          filaNueva[0] = '0';
           for (i = 0; i < datos.length; i++) {
                                                      filaNueva[filaNueva.length] = datos[i];
           }
           for (j = filaNueva.length; j < longitud; j++) {
                                                      filaNueva[filaNueva.length] = "";
           }
           filaNueva[0] = '0';
           return filaNueva;
}


function codigoClienteOnBlur() {
           var codigoCliente = get(FORMULARIO+'.txtCodCliente').toString();

           if (codigoCliente != '') {
                              var longitudCodigoCliente = get(FORMULARIO+'.longitudCodigoCliente').toString();
                              var longitud = codigoCliente.length;

                              // Se rellena el código de cliente con ceros
                              var cadena = rellenaCeros(codigoCliente, longitudCodigoCliente, longitud);
                              set(FORMULARIO+'.txtCodCliente', cadena);
           }
}

//hace visible la listaeditable listadoX donde X es el parámetro numero
function hacerVisible(numero) {
           if (numero ==1) {
                           if (document.all["Cplistado1"].style.visibility!='visible'){
                              DrdEnsanchaConMargenDcho('listado1',12);
                              document.all["Cplistado1"].style.visibility='visible';
                              document.all["CpLin1listado1"].style.visibility='visible';
                              document.all["CpLin2listado1"].style.visibility='visible';
                              document.all["CpLin3listado1"].style.visibility='visible';
                              document.all["CpLin4listado1"].style.visibility='visible';
                           }
           } else if (numero ==2) {
                           if (document.all["Cplistado2"].style.visibility!='visible'){
                           
                              DrdEnsanchaConMargenDcho('listado2',12);
                              document.all["Cplistado2"].style.visibility='visible';
                              document.all["CpLin1listado2"].style.visibility='visible';
                              document.all["CpLin2listado2"].style.visibility='visible';
                              document.all["CpLin3listado2"].style.visibility='visible';
                              document.all["CpLin4listado2"].style.visibility='visible';
                           }
           } else if (numero == 3) {
                           if (document.all["Cplistado3"].style.visibility!='visible'){
                              DrdEnsanchaConMargenDcho('listado3',12);
                              document.all["Cplistado3"].style.visibility='visible';
                              document.all["CpLin1listado3"].style.visibility='visible';
                              document.all["CpLin2listado3"].style.visibility='visible';
                              document.all["CpLin3listado3"].style.visibility='visible';
                              document.all["CpLin4listado3"].style.visibility='visible';
                           }
           } else if (numero ==4) {
                           if (document.all["Cplistado4"].style.visibility!='visible'){
                           
                              DrdEnsanchaConMargenDcho('listado4',12);
                              document.all["Cplistado4"].style.visibility='visible';
                              document.all["CpLin1listado4"].style.visibility='visible';
                              document.all["CpLin2listado4"].style.visibility='visible';
                              document.all["CpLin3listado4"].style.visibility='visible';
                              document.all["CpLin4listado4"].style.visibility='visible';
                           }
           }

           setTimeout('eval (ON_RSZ);',200);
           //ON_RSZ = '';
}

//hace invisible la listaeditable listadoX donde X es el parámetro numero
function hacerInvisible(numero) {
           //DrdEnsanchaConMargenDcho('listado' + numero,12);
           if (numero ==1) {
                    if (document.all["Cplistado1"].style.visibility!='hidden'){
                              document.all["Cplistado1"].style.visibility='hidden';
                              document.all["CpLin1listado1"].style.visibility='hidden';
                              document.all["CpLin2listado1" ].style.visibility='hidden';
                              document.all["CpLin3listado1"].style.visibility='hidden';
                              document.all["CpLin4listado1"].style.visibility='hidden';
                    }
           } else if (numero ==2) {
                    if (document.all["Cplistado2"].style.visibility!='hidden'){
                    
                              document.all["Cplistado2"].style.visibility='hidden';
                              document.all["CpLin1listado2"].style.visibility='hidden';
                              document.all["CpLin2listado2" ].style.visibility='hidden';
                              document.all["CpLin3listado2"].style.visibility='hidden';
                              document.all["CpLin4listado2"].style.visibility='hidden';
                    }
           } else if (numero ==3) {
                           if (document.all["Cplistado3"].style.visibility!='hidden'){
                              document.all["Cplistado3"].style.visibility='hidden';
                              document.all["CpLin1listado3"].style.visibility='hidden';
                              document.all["CpLin2listado3" ].style.visibility='hidden';
                              document.all["CpLin3listado3"].style.visibility='hidden';
                              document.all["CpLin4listado3"].style.visibility='hidden';
                           }
           } else if (numero ==4) {
                           if (document.all["Cplistado4"].style.visibility!='hidden'){
                           
                              document.all["Cplistado4"].style.visibility='hidden';
                              document.all["CpLin1listado4"].style.visibility='hidden';
                              document.all["CpLin2listado4" ].style.visibility='hidden';
                              document.all["CpLin3listado4"].style.visibility='hidden';
                              document.all["CpLin4listado4"].style.visibility='hidden';
                           }
           }

}

function deshabilitaAceptar(){
           document.all['btnAceptar'].onfocus=function(){this.blur();}
           //accion(FORMULARIO + '.btnAceptar', '.disabled=true') 
           accion(FORMULARIO + '.cbAplicacion', '.disabled=true') 
}

function deshabilitaEjecutar(){
           accion(FORMULARIO + '.txtCodCliente','.disabled=true');
           accion(FORMULARIO + '.txtFechaValor','.disabled=true');
           accion(FORMULARIO + '.txtReferenciaExterna','.disabled=true');
           accion(FORMULARIO + '.areatxtObservaciones','.disabled=true');

           
           accion(FORMULARIO + '.cbEmpresa','.disabled=true');
           accion(FORMULARIO + '.cbCanal','.disabled=true');
           accion(FORMULARIO + '.cbAcceso','.disabled=true');
           accion(FORMULARIO + '.cbSubacceso','.disabled=true');

}

function habilita(){
           accion(FORMULARIO + '.txtCodCliente','.disabled=false');
           accion(FORMULARIO + '.txtFechaValor','.disabled=false');
           accion(FORMULARIO + '.txtReferenciaExterna','.disabled=false');
           accion(FORMULARIO + '.areatxtObservaciones','.disabled=false');
           
           if (get(FORMULARIO + '.casoUso') == '')
                              accion(FORMULARIO + '.cbAplicacion','.disabled=false');
                              
           accion(FORMULARIO + '.cbEmpresa','.disabled=false');
           accion(FORMULARIO + '.cbCanal','.disabled=false');
           accion(FORMULARIO + '.cbAcceso','.disabled=false');
           accion(FORMULARIO + '.cbSubacceso','.disabled=false');
           document.all['btnAceptar'].onfocus=function(){}
}

function ejecutaLimpia() {
           fMostrarMensajeExito("guardar");
}

function focalizaAceptar() {
           document.all['btnAceptar'].focus();
}

function focalizaEjecutar() {
           document.all['btnEjecutar'].focus();
}

function focalizaAnteriorEmpresa() {
           if (deshabilitadoAceptar)
                              document.all['btnEjecutar'].focus();
           else
                              document.all['btnAceptar'].focus();
}

function focalizaAnteriorEleccion() {
           if (deshabilitadoEjecutar) {
                     var numListadoVisible = objsGen.listaVisible;//[1] get(FORMULARIO + '.listaVisible');
                     if (numListadoVisible != "")
                                             focalizaUltimoListado(numListadoVisible); 
                     else
                                             document.all['btnEjecutar'].focus();
           } else
                     focaliza('frmFormulario.areatxtObservaciones');
}

function focalizaSiguienteEjecutar() {
           if (deshabilitadoAceptar){
                              //[1] var numListadoVisible = get(FORMULARIO + '.listaVisible');
                              var casoUso = get(FORMULARIO + '.casoUso');
                              if (objsGen.listaVisible != "" && casoUso != "consultar")
                                                      focalizaPrimeroListado(objsGen.listaVisible); 
                              else if (deshabilitadoEjecutar)
                                                                          focaliza('frmFormulario.cbEleccion');
                              else
                                                                          focaliza('frmFormulario.cbEmpresa');
           }else
                              focaliza('frmFormulario.cbAplicacion');
}

function focalizaPrimeroListado(numeroLista) {
           var nombreListado = 'listado' + numeroLista;
           var nombreCajaText = 'Texto' + numeroLista;
           if (numeroLista == 4)
                              nombreCajaText = 'Texto5';
           eval(nombreListado + '.actualizaDat()');
           var datos = eval(nombreListado + '.datos');
           if (datos.length > 0) {
                              eval(nombreListado + ".preparaCamposDR()");
                              focaliza('frm' + nombreListado + '.' + nombreCajaText + '_0', '');
           } else {
                              focaliza('frmFormulario.cbEleccion');
           }
}

function focalizaUltimoListado(numeroLista) {
           var nombreListado = 'listado' + numeroLista;
           var nombreCajaText = 'Texto' + numeroLista;
           if (numeroLista == 3)
                              nombreCajaText = 'Texto4';
           if (numeroLista == 4)
                              nombreCajaText = 'Texto6';
           eval(nombreListado + '.actualizaDat()');
           var datos = eval(nombreListado + '.datos');
           if (datos.length > 0) {
                              var numeroFila = datos.length - 1;
                              eval(nombreListado + ".preparaCamposDR()");
                              focaliza('frm' + nombreListado + '.' + nombreCajaText + '_' + numeroFila, '');
           } else {
                              document.all['btnEjecutar'].focus();
           }
}

//valida la fecha si el campo es modificable y no vacío 
function validaFecha(fecha) {
           if(eval(FORMULARIO + '.' + fecha + 'RO') != "S"){
                              if (get(FORMULARIO + '.' + fecha).toString() != "")
                                                      var resul = EsFechaValida(get(FORMULARIO + '.' + fecha), get(FORMULARIO + '.' + fecha), FORMULARIO, null);
                                                      if (resul == 1 || resul == 2) {  
                                                                          var strCaja = FORMULARIO + '.' + fecha;
                                                                          GestionarMensaje('1006', get(FORMULARIO + '.hFormatoFechaPais'));
                                                                          focaliza(strCaja);
                                                                          return false;
                                                      }
           } 
}

//aplicar cargos abonos
function fVolver() {
           window.close();
}

function insercionIncorrecta() {
           btnProxy(4,1);
           btnProxy(1,1);
}

function fLimpiar()  {
           limpiaFormulario();
           focaliza(FORMULARIO + ".cbAplicacion");
           set(FORMULARIO + '.cbAplicacion', ['']);		

}

function limpiaFormulario()  {
           //reestablecer el formulario insertar
           if (get(FORMULARIO + '.casoUso') == '' || get(FORMULARIO + '.casoUso') == 'gestionarCheques') {
                              habilita();
                              //fecha a sistema
           set(FORMULARIO + '.txtFechaValor', get(FORMULARIO + '.htxtFechaValor'));
           //resto de campos a opcion vacía o valor por defecto
                              if (get(FORMULARIO + '.casoUso') == '') {
                              set(FORMULARIO + '.cbAplicacion', '');
                              vaciaCombo(FORMULARIO + '.cbEleccion'); 
           } else {
                              set(FORMULARIO + '.cbEleccion', '');
           }
           set(FORMULARIO + '.txtCodCliente', '');
           set(FORMULARIO + '.txtReferenciaExterna', '');
           var canal = get(FORMULARIO + '.canal');
           set(FORMULARIO + '.cbCanal', [canal]);
                              preseleccionaValores();
           set(FORMULARIO + '.areatxtObservaciones', '');
           var empresa = get(FORMULARIO + '.empresa');
           set(FORMULARIO + '.cbEmpresa', [empresa]);

                              //habilitar botones
                              if (get(FORMULARIO + '.casoUso') == '') {
                                                      document.all['btnAceptar'].disabled = false;
                                                      deshabilitadoAceptar = false;
                              }
                              deshabilitadoEjecutar = false;
           }
           
           if (get(FORMULARIO + '.casoUso') != 'modificar') 
                              visibilidad('capaImportes', 'O');
           //lista editable invisible
           //restaurar listas
           restableceListados();
           recalcular();

}

function restableceListados() {
           /*listado1.load();
           listado1.reajusta();
           listado2.load();
           listado3.load();
           listado4.load();*/
           hacerInvisible(1);
           hacerInvisible(2);
           hacerInvisible(3);
           hacerInvisible(4);
           if (listado1.datos.length == 0 && listado2.datos.length == 0 && listado3.datos.length == 0 && listado4.datos.length == 0) {
                  if (get(FORMULARIO + '.casoUso') == '' || get(FORMULARIO + '.casoUso') == 'gestionarCheques'){
                           btnProxy(1,0);
                  }
                  btnProxy(4,0);
           } else{
                           btnProxy(4, 1);
           }

}

//valida numero decimal (formato con separador de miles y de decimales)
//devuelve false si no es vacío y no es válido, true en caso contrario
function validaMonto(monto, enteros) {
           monto = monto + "";
           if (monto != "") {
                              return ValidaMilesDecimalesNegativo(monto, enteros, get(FORMULARIO + '.hid_NumeroDecimales'), get(FORMULARIO + '.hid_SeparadorMiles'), get(FORMULARIO + '.hid_SeparadorDecimales'), 0);
           } 
           return 'OK';
}

function focalizaLista(indiceFila, nombreListado, nombreCajaTexto) {
if (nombreListado == null) {
                  nombreListado = 'listado1';
}

if (nombreCajaTexto == null) {
                  nombreCajaTexto = 'Texto1';
}

eval(nombreListado+'.preparaCamposDR()');
focaliza('frm'+nombreListado+'.'+nombreCajaTexto+'_'+indiceFila,''); 
}

function importeAplicarCancelacionCuotasOnBlur(FILAEVENTO){
           var separadorDecimales = get(FORMULARIO + '.hid_SeparadorDecimales');
         var separadorMiles = get(FORMULARIO + '.hid_SeparadorMiles');
           //Este evento está asociado a la perdida de foco de la columa importeAplicar de la lista cancelacionCuotas
           var i = FILAEVENTO; // dtar la fila
           listado1.actualizaDat(); //Actualiza el array 'datos'
           var datos = listado1.datos;
           var monto = datos[i][15];// importeAplicar
           var textoImporte = eval('listado1.form.Texto1_' +  FILAEVENTO);
           if (monto != "") {
                              if (filaInvalida == -1 || filaInvalida == i) {
                                                      filaInvalida = i;
                                                      esValorNumerico(textoImporte);
                              }
           } 
           if (filaInvalida == i) filaInvalida = -1;
           if (filaInvalida == -1) {
                              
                              var tempAplicar = monto; //datos[i][15];
                              var tempPendiente = datos[i][12];
                              var importeAplicar = obtieneNumeroDecimal(tempAplicar,separadorDecimales);
                              var importePendiente = obtieneNumeroDecimal(tempPendiente,separadorDecimales);
                              
                              if (((parseFloat(importePendiente) >= 0) && (parseFloat(importeAplicar)<0)) || ((parseFloat(importePendiente)<=0) && (parseFloat(importeAplicar)>0))){
                                                      //El importe pendiente tiene signo diferente a importe a aplicar
                                                      //mostramos mensaje de aviso UICCC016 -> 1433
                                                      textoImporte.value=importePendiente;
                                                      textoImporte.focus();
                                                      var tr = textoImporte.createTextRange();
                                                      tr.execCommand("SelectAll");
                                                      GestionarMensaje ('1433');
                                                      return;
                              }
                              if (((parseFloat(importePendiente)< 0) && (((parseFloat(importePendiente)) - (parseFloat(importeAplicar))) > 0)) ||
                                                      ((parseFloat(importePendiente) > 0) && (((parseFloat(importePendiente)) - (parseFloat(importeAplicar))) < 0))){
                                                      //Si tiene un valor mayor que el del campo importe pendiente 
                                                      //ponemos en importe a aplicar el importe pendiente 
                                                      //Insertamos tempPendiente porque ya esta formateado
                                                      //textoImporte.value= formateaImporte(importePendiente, separadorMiles, separadorDecimales);
                                                      //Si hemos tenido que cambiar algún campo 
                                                      textoImporte.value=importePendiente;
                                                      textoImporte.focus();
                                                      var tr = textoImporte.createTextRange();
                                                      tr.execCommand("SelectAll");
                                                      //mostramos el mensaje de error CCC-0017 --> 1092(El importe a aplicar no puede ser 
                                                      //mayor que el importe pendiente) 
                                                      GestionarMensaje ('1092');
                                                      return;
                              }			
                              
                              recalcular();
           }
}


function esValorNumerico(cajaTexto){
           var separadorMiles = get(FORMULARIO+'.hid_SeparadorMiles');
           var separadorDecimales = get(FORMULARIO+'.hid_SeparadorDecimales');
           
           var valor=cajaTexto.value;
           if (!soloNumeros(valor)){
                              GestionarMensaje('1256');
                              cajaTexto.focus();
                              var tr = cajaTexto.createTextRange();
                              tr.execCommand("SelectAll");
                              return;
           }
           var cont=0;
           if (valor.length>0){
                              for (i=0;i<valor.length;i++){
                                                      if (valor.charAt(i)==','){
                                                                          cont = cont +1;
                                                      }
                                                                          
                              }
                              if ((cont == 0)||(cont == 1)){
                                                      var base = obtieneNumeroDecimal(valor,separadorDecimales);
                                                      cajaTexto.value=formateaImporte(base, separadorMiles, separadorDecimales);
                                                      //set(FORMULARIO+'.hid_'+cajaTexto,base);		
                              }else {
                                                      GestionarMensaje('1256');
                                                      cajaTexto.focus();
                                                      var tr = cajaTexto.createTextRange();
                                                      tr.execCommand("SelectAll");			 
                                                      return;
                              }
                              
           }
}
          
function soloNumeros(cantidad){
           var str=cantidad;
           var s;
           var sepMil = get(FORMULARIO+'.hid_SeparadorMiles');
           var sepDec = get(FORMULARIO+'.hid_SeparadorDecimales');
           var numero = true;
           for(var i=0;i<str.length;i++){
                             s=str.charAt(i);
                             if((s!=sepDec)&&(s!=sepMil)&&(s!='-')&&(isNaN(parseInt(s)))){
                                                      numero = false;
                              }
           }
           return(numero);
}

/////////////////////////////////////////

function importeCobrosOnBlur(FILAEVENTO) {
           // Se obtienen los separadores
           var separadorDecimales = get(FORMULARIO + '.hid_SeparadorDecimales');
           var separadorMiles = get(FORMULARIO + '.hid_SeparadorMiles');
           var numeroDecimales = get(FORMULARIO + '.hid_NumeroDecimales');	
                              
           var columnaImporte = 8;
           var columnaImporteCuota = 7;
           //Este evento está asociado la columna importe de la lista aplicacionCobros
           var i = FILAEVENTO; // dtar la fila
           listado2.actualizaDat(); //Actualiza el array 'datos'
           var datos = listado2.datos;
           var monto = datos[i][8];
           var textoImporte = eval('listado2.form.Texto2_' +  FILAEVENTO);
           if (monto != ''){
                              var resultado = ValidaMilesDecimalesNegativo(textoImporte.value,10,numeroDecimales,separadorMiles,
                                                      separadorDecimales,0);
                              if (resultado != 'OK') {
                                                      cdos_mostrarAlert(resultado);
                                                      //datos[FILAEVENTO][columnaImporte] = '';
                                                      textoImporte.value=datos[i][columnaImporteCuota];
                                                      /*listado1.setDatos(datos);
                                                      listado1.actualizaDat();*/
                                                      focalizaLista(FILAEVENTO);			
                                                      return false;
                              }
           }else textoImporte.value=datos[i][columnaImporteCuota];		
           if (filaInvalida == i) filaInvalida = -1;

           if (filaInvalida == -1) {
                              var tempImporte = datos[i][columnaImporte]; 
                              var tempCuota = datos[i][columnaImporteCuota]; 
                              var importeAplicar = obtieneNumeroDecimal(tempImporte,separadorDecimales); 
                              var importeCuota = obtieneNumeroDecimal(tempCuota,separadorDecimales); 
                              /*
                              Recorremos la columna importeAplicar haciendo la siguiente comprobacion:   
                                    Si (importePendiente >= 0 y importeAplicar < 0) ó (importePendiente <= 0 y importeAplicar > 0)
                                    Se muestra el mensaje de aviso UICCC016 (Importe pendiente tiene signo diferente a importe a
                                    aplicar) y se continúa con el flujo del método.
                   Fin del Si
                   
                   */
                   if ((( Number(importeCuota) >= 0 && Number(importeAplicar) < 0) || 
                           (Number(importeCuota) <= 0 && Number(importeAplicar) > 0 ))){
                                                      GestionarMensaje('1433');
                                                      textoImporte.focus();
                                                      textoImporte.value=importeCuota;
                                                      var tr = textoImporte.createTextRange();
                                                      tr.execCommand("SelectAll");                                
                                                      return;
                                    }
                              
                              
                              
                              /*Si (importePendiente < 0 y (importePendiente - importeAplicar > 0)) ó (importePendiente > 0 y
                                                      (importePendiente - importeAplicar < 0))
                                                      Mostramos el mensaje de error CCC-0035 (El importe a aplicar no puede ser superior al importe
                                                      pendiente).
                              */
                              
                              if (( Number(importeCuota) < 0 && (Number(importeCuota) - Number(importeAplicar) > 0))||
                                                      ( Number(importeCuota) > 0 && ( Number(importeCuota) - Number(importeAplicar) < 0 ))){
                                                      // Muestra el mensaje: "El importe a aplicar no puede ser mayor que el importe pendiente
                                                      GestionarMensaje('1092');
                                                      textoImporte.focus();
                                                      textoImporte.value=importeCuota;
                                                      var tr = textoImporte.createTextRange();
                                                      tr.execCommand("SelectAll");                                
                                                      return;
                              }				
                              recalcular();
           }
}

function importeConceptosOnBlur(FILAEVENTO){
                              //Este evento se asocia a la columna importe de la lista conceptosGastosAbonos
                              var i = FILAEVENTO; // dtar la fila
                              listado3.actualizaDat(); //Actualiza el array 'datos'
                              var datos = listado3.datos;
                              var monto = datos[i][6];
         var textoImporteDivisa = eval('listado3.form.Texto4_' +  FILAEVENTO);
                              if (monto != "") {
                                                      if ((columnaInvalida == -1 && filaInvalida == -1) || (filaInvalida == i && columnaInvalida == 1)) {
                                                                          filaInvalida = i;
                                                                          columnaInvalida = 1;
                                                                          if (!ValidaForm(FORMULARIO,true)) {
                                                                                             return false;
                                                                          }
                                                      }
                              } 
                              if (filaInvalida == i && columnaInvalida == 1) {
                                                      filaInvalida = -1;
                                                      columnaInvalida = -1;
                              }
                              if (columnaInvalida == -1 && filaInvalida == -1) {
                                                      if (monto == "") {
                                    textoImporteDivisa.value = "";
                                                      } else {
                                                                          var tasa = get(FORMULARIO + '.tasaCambioMonedaAlternativa');
                                                                          var divisa = datos[i][5];
                           if (divisa != "" && tasa != "") {
                                             //multiplicamos el valor del campo por el de la variable oculta tasaCambioMonedaAlternativa y ponemos el resultado en la columna importeDivisa de la misma fila.
                                    var importeDivisa = obtieneNumeroDecimal(monto, get(FORMULARIO + '.hid_SeparadorDecimales')) * Number(tasa);
                                    textoImporteDivisa.value = formateaImporte(redondea(importeDivisa, get(FORMULARIO + '.hid_NumeroDecimales')), get(FORMULARIO + '.hid_SeparadorMiles'), get(FORMULARIO + '.hid_SeparadorDecimales'));
                           }
                  }
                                                      recalcular();
                              }
}

function importeDivisaConceptosOnBlur(FILAEVENTO){
                              //Este evento se asocia a la columna importeDivisa de la lista conceptosGastosAbonos
                              //Este evento se asocia a la columna importeDivisa en las listas de conceptosGastosAbonos
                              var i = FILAEVENTO; // dtar la fila
                              listado3.actualizaDat(); //Actualiza el array 'datos'
                              var datos = listado3.datos;
                              var divisa = datos[i][6];
                              var monto = datos[i][7];
         var textoImporte = eval('listado3.form.Texto3_' +  FILAEVENTO);
         var textoImporteDivisa = eval('listado3.form.Texto4_' +  FILAEVENTO);

                              /*if (monto != "" && (typeof(divisa) == 'undefined' || divisa == "")) {
                                                      alert('FUNCIONA');
                                                      //textoImporteDivisa.value = "";
                           //listado3.setDatos(datos);
                                                                          //listado3.reajusta();
                              }else {*/
                                                      if (monto != "") {
                                                                          if ((columnaInvalida == -1 && filaInvalida == -1) || (filaInvalida == i && columnaInvalida == 2)) {
                                                                                             filaInvalida = i;
                                                                                             columnaInvalida = 2;
                                                                                             /*if (isNaN(monto)){
                                                                                                                //alert("Debe ser numerico");
                                                                                                                GestionarMensaje ('405');
                                                                                                                textoImporte.focus();
                                                                                                                var tr = textoImporte.createTextRange();
                                                                                                                      tr.execCommand("SelectAll");
                                                                                                                return false;							
                                                                                             }*/
                                                                                             if (!ValidaForm(FORMULARIO,true)) {
                                                                                                                      return false;
                                                                                             } 
                                                                          }
                                                      } 		
                                                      if (filaInvalida == i && columnaInvalida == 2) {
                                                                          filaInvalida = -1;
                                                                          columnaInvalida = -1;
                                                      }
                                                      if (columnaInvalida == -1 && filaInvalida == -1) {
                                                                          var divisaOid = datos[i][5];
                                                                          var tasa = get(FORMULARIO + '.tasaCambioMonedaAlternativa');
                           if (divisaOid != "" && tasa != "") {
                                                                                             if (monto == "") {
                                                                                  textoImporte.value = "";
                                                                                             } else {
                                                                                  // dividimos el valor del campo por el de la variable oculta tasaCambioMonedaAlternativa y ponemos el resultado en la columna importe de la misma fila.
                                             var importe = obtieneNumeroDecimal(monto, get(FORMULARIO + '.hid_SeparadorDecimales')) / Number(tasa);
                                             textoImporte.value = formateaImporte(redondea(importe, get(FORMULARIO + '.hid_NumeroDecimales')), get(FORMULARIO + '.hid_SeparadorMiles'), get(FORMULARIO + '.hid_SeparadorDecimales'));
                                    }
                                                                                             recalcular();
                           }
                                                      }
                              //}
}

function importeVencimientosOnBlur(FILAEVENTO) {
                              //Este evento se asocia a la columna importeCuota de la lista generacionVencimientos
                              var i = FILAEVENTO; // dtar la fila
                              listado4.actualizaDat(); //Actualiza el array 'datos'
                              var datos = listado4.datos;
                              var monto = datos[i][12];
         var textoImporteDivisa = eval('listado4.form.Texto6_' +  FILAEVENTO);
                              if (monto != "") {
                                                      if ((columnaInvalida == -1 && filaInvalida == -1) || (filaInvalida == i && columnaInvalida == 1)) {
                                                                          filaInvalida = i;
                                                                          columnaInvalida = 1;						
                                                                          if (!ValidaForm(FORMULARIO,true)) {
                                                                                             return false;
                                                                          } 
                                                      }
                              } 
                              if (filaInvalida == i && columnaInvalida == 1) {
                                                      filaInvalida = -1;
                                                      columnaInvalida = -1;
                              }

                              if (columnaInvalida == -1 && filaInvalida == -1) {
                                                      if (monto == "") {
                                    textoImporteDivisa.value = "";
                                                      } else {
                                                                          var divisaOid = datos[i][11];
                                                                          var tasa = get(FORMULARIO + '.tasaCambioMonedaAlternativa');
                           if (divisaOid != "" && tasa != "") {
                                             //multiplicamos el valor del campo por el de la variable oculta tasaCambioMonedaAlternativa y ponemos el resultado en la columna importeDivisa de la misma fila.
                                    var importeDivisa = obtieneNumeroDecimal(monto, get(FORMULARIO + '.hid_SeparadorDecimales')) * Number(tasa);
                                    textoImporteDivisa.value = formateaImporte(redondea(importeDivisa, get(FORMULARIO + '.hid_NumeroDecimales')), get(FORMULARIO + '.hid_SeparadorMiles'), get(FORMULARIO + '.hid_SeparadorDecimales'));
                           }
                  }
                                                      //Copiamos el valor del campo a la columna importePendiente
                  /*var textoImportePendiente = eval('listado4.form.Texto7_' +  FILAEVENTO);
                  textoImportePendiente.value = monto;*/
                                                      recalcular();
                              }
}

function importeDivisaVencimientosOnBlur(FILAEVENTO) {
                              //Este evento se asocia a la columna importeDivisa de la lista generacionVencimientos
                              var i = FILAEVENTO; // dtar la fila
                              listado4.actualizaDat(); //Actualiza el array 'datos'
                              var datos = listado4.datos;
                              var divisa = datos[i][11];
         var textoImporte = eval('listado4.form.Texto5_' +  FILAEVENTO);
         var textoImporteDivisa = eval('listado4.form.Texto6_' +  FILAEVENTO);
         //var textoImportePendiente = eval('listado4.form.Texto7_' +  FILAEVENTO);
                              if (textoImporteDivisa.value != "" && (typeof(divisa) == 'undefined' || divisa == "")) {
                                                      textoImporteDivisa.value = "";
                              } else {
                                                      if (textoImporteDivisa.value != "") {
                                                                          if ((columnaInvalida == -1 && filaInvalida == -1) || (filaInvalida == i && columnaInvalida == 2)) {
                                                                                             filaInvalida = i;
                                                                                             columnaInvalida = 2;				
                                                                                             if (!ValidaForm(FORMULARIO,true)) {
                                                                                                                      return false;
                                                                                             } 
                                                                          }
                                                      } 
                                                      if (filaInvalida == i && columnaInvalida == 2) {
                                                                          filaInvalida = -1;
                                                                          columnaInvalida = -1;
                                                      }
                                                      
                                                      if (columnaInvalida == -1 && filaInvalida == -1) {
                                                                          var tasa = get(FORMULARIO + '.tasaCambioMonedaAlternativa');
                                                                          if (divisa != "" && tasa != "") {
                                                                                             if (textoImporteDivisa.value == "") {
                                                                         textoImporte.value = "";
                                                                                                                      //textoImportePendiente.value = "";
                                                                                             } else {
                                             // dividimos el valor del campo por el de la variable oculta tasaCambioMonedaAlternativa y ponemos el resultado en las columnas importeCuota e importePendiente de la misma fila.
                                             var importe = obtieneNumeroDecimal(textoImporteDivisa.value, get(FORMULARIO + '.hid_SeparadorDecimales')) / Number(tasa);
                                             textoImporte.value = formateaImporte(redondea(importe, get(FORMULARIO + '.hid_NumeroDecimales')), get(FORMULARIO + '.hid_SeparadorMiles'), get(FORMULARIO + '.hid_SeparadorDecimales'));
                                             //textoImportePendiente.value = textoImporte.value;
                                                                                             }
                                                                                             recalcular();
                           }
                                                      }
                              }
}

//Funcion que se ejecuta cuando se valida el formulario en la caja de texto de la caja
function validaImporteNegativo(valor,enteros) {
           
           //Validamos que no inserte en un formato incorrecto
           if(valor != "") {
                                                      return ValidaMilesDecimalesNegativo(valor, enteros, get(FORMULARIO + '.hid_NumeroDecimales'), get(FORMULARIO + '.hid_SeparadorMiles'), get(FORMULARIO + '.hid_SeparadorDecimales'), 0);
           }
}

function addVacioDatosCC(datos, longitud, addPrimeraColumna) {
           
           //debemos recibir una fila es un array con los campos para rellenar una fila de la lista (si faltan columnas se dejan vacías las últimas ññññ);
           // debemos añadir un primer elemento vacío para que vaya en la columna oculta que tienen las listas editables 
           var filaNueva = new Array();
           if (addPrimeraColumna != null && addPrimeraColumna) 
                                                                          filaNueva[0] = '0';
           for (i = 0; i < datos.length -1 ; i++) {	//length -1, el último campo (bloqueo) no nos hace falta
                                                      filaNueva[filaNueva.length] = datos[i];
           }
           for (j = filaNueva.length; j < longitud; j++) {
                                                      filaNueva[filaNueva.length] = "";
           }
           filaNueva[0] = '0';
           /*if (filaNueva[11] != '')
           filaNueva[11] = formateaImporte(filaNueva[11], get(FORMULARIO + '.hid_SeparadorMiles'), get(FORMULARIO + '.hid_SeparadorDecimales'));
           if (filaNueva[12] != '')
           filaNueva[12] = formateaImporte(filaNueva[12], get(FORMULARIO + '.hid_SeparadorMiles'), get(FORMULARIO + '.hid_SeparadorDecimales'));
           if (filaNueva[13] != '')
           filaNueva[13] = formateaImporte(filaNueva[13], get(FORMULARIO + '.hid_SeparadorMiles'), get(FORMULARIO + '.hid_SeparadorDecimales'));
           if (filaNueva[15] != '')
           filaNueva[15] = formateaImporte(filaNueva[15], get(FORMULARIO + '.hid_SeparadorMiles'), get(FORMULARIO + '.hid_SeparadorDecimales'));
           if (filaNueva[16] != '')
           filaNueva[16] = formateaImporte(filaNueva[16], get(FORMULARIO + '.hid_SeparadorMiles'), get(FORMULARIO + '.hid_SeparadorDecimales'));
           */
           if (filaNueva[8] != '')
           filaNueva[8] = filaNueva[8];
           if (filaNueva[9] != '') 
           filaNueva[9] = filaNueva[9];
           return filaNueva;
}

function addVacioDatosAC(datos, longitud, addPrimeraColumna) {
           
           //debemos recibir un array en el que cada fila es un array con los campos para rellenar una fila de la lista (si faltan columnas se dejan vacías las últimas ññññ);
           // debemos añadir un primer elemento vacío para que vaya en la columna oculta que tienen las listas editables 
           var filaNueva = new Array();
           if (addPrimeraColumna != null && addPrimeraColumna) 
                                                                          filaNueva[0] = '0';
           for (i = 0; i < datos.length - 1; i++) { //length -1, el último campo (bloqueo) no nos hace falta
                                                      filaNueva[filaNueva.length] = datos[i];
           }
           for (j = filaNueva.length; j < longitud; j++) {
                                                      filaNueva[filaNueva.length] = "";
           }
           filaNueva[0] = '0';
           /*
           if (filaNueva[6] != '')
           filaNueva[6] = formateaImporte(filaNueva[6], get(FORMULARIO + '.hid_SeparadorMiles'), get(FORMULARIO + '.hid_SeparadorDecimales'));
           if (filaNueva[7] != '')
           filaNueva[7] = formateaImporte(filaNueva[7], get(FORMULARIO + '.hid_SeparadorMiles'), get(FORMULARIO + '.hid_SeparadorDecimales'));
           
           if (filaNueva[8] != '')
           filaNueva[8] = formateaImporte(filaNueva[8], get(FORMULARIO + '.hid_SeparadorMiles'), get(FORMULARIO + '.hid_SeparadorDecimales'));*/
           if (filaNueva[3] != '')
                              filaNueva[3] = filaNueva[3];
           filaNueva[10] = datos[0];
           return filaNueva;
}

function formateaFechaDATE(fecha) {
           //debemos recibir un array en el que cada fila es un array con los campos para rellenar una fila de la lista (si faltan columnas se dejan vacías las últimas ññññ);
           // debemos añadir un primer elemento vacío para que vaya en la columna oculta que tienen las listas editables 
           var dia = fecha.substring(8);
           var mes = fecha.substring(5,7);
           var anyo = fecha.substring(0,4);
           return dia + '/' + mes + '/' + anyo;
}

function focalizaSiguienteLista(FILAEVENTO, TECLAEVENTO) {
          // [1] var numListadoVisible = get(FORMULARIO + '.listaVisible');
           var listado = eval("listado" + objsGen.listaVisible);

           if (FILAEVENTO == listado.datos.length-1 && TECLAEVENTO == 9) {
                              if (ValidaForm(FORMULARIO, false)) {
                                                      document.body.focus();
                                                      setTimeout("focaliza('frmFormulario.cbEleccion')", 5);
                              }
           }
}


function focalizaAnteriorLista(FILAEVENTO, TECLAEVENTO) {
           if (FILAEVENTO == 0 && TECLAEVENTO == 9) {
                              if (ValidaForm(FORMULARIO, false)) {
                                                      document.body.focus();
                                                      setTimeout("document.all['btnEjecutar'].focus();tr=document.body.createTextRange();tr.execCommand('Unselect');", 5);
                              }
           }
} 

function validarFecha(FILAEVENTO) {
                              var fecha = eval('listado4.form.Fechavalor_' + FILAEVENTO);
                              if (fecha.value != "") {
                                                      var resul = EsFechaValida(fecha.value, fecha.value, FORMULARIO, null);
                                                      if (resul == 1 || resul == 2) {  
                                                                          GestionarMensaje('1006', get(FORMULARIO+'.hFormatoFechaPais'));
                                                                          fecha.focus();
                                                                          var tr = fecha.createTextRange();
                                                                          tr.execCommand("SelectAll");
                                                      }
                                     
                              }
}

function validarFechaVenc(FILAEVENTO) {
                              var fecha = eval('listado4.form.Fechavencimiento_' + FILAEVENTO);
                              if (fecha.value != "") {
                                                      var resul = EsFechaValida(fecha.value, fecha.value, FORMULARIO, null);
                                                      if (resul == 1 || resul == 2) {  
                                                                          GestionarMensaje('1006', get(FORMULARIO+'.hFormatoFechaPais')); 
                                                                          fecha.focus();
                                                                          var tr = fecha.createTextRange();
                                                                          tr.execCommand("SelectAll");
                                                      }
                                     
                              }
           //ValidaForm(FORMULARIO, true);
}


function comprobarFecha(valor){ 
           if (valor != "") {
                              var resul = EsFechaValida(valor, valor, FORMULARIO, null);
                              if (resul == 1 || resul == 2) {  
                                                      return GestionarMensaje('1395', get(FORMULARIO+'.hFormatoFechaPais')); 
                              }
           }
           return 'OK';
}

//necesario para la navegacion ontab/shtab entre las columnas importe e importe divisa
//en el onblur de una se asigna valor a la otra con lo que el foco de esta deja de ser evidente
function restauraFocoLista(fila, nombreColumna) {
           if (ValidaForm(FORMULARIO, false)) {
                              var cajaTxt = eval(nombreColumna + '_' +  fila);
                              var tr = cajaTxt.createTextRange();
                              tr.execCommand("SelectAll");
           }
}

//en el onblur de una se asigna valor a la otra con lo que el foco de esta deja de ser evidente
function restauraFocoLista3(fila, nombreColumna) {
           if (ValidaForm(FORMULARIO, false)) {
                              var cajaTxt = eval(nombreColumna + '_' +  fila);
                              var tr = cajaTxt.createTextRange();
                              tr.execCommand("SelectAll");
           }
}

                

//  splatas - BELC300023075 - 30/05/2006
function formatImport(numeroDecimal, separadorMiles, separadorDecimales){

  var dineroEntrada = "" + numeroDecimal;
  var negativo = false;
  var decimales;
  
  if (dineroEntrada.indexOf('-') == 0) {
      dineroEntrada = dineroEntrada.replace('-', '');
      negativo = true;
  }
  
  var tokens = dineroEntrada.split('.');
  var bufferEntero = tokens[0];// almacena la parte entera.
  var bufferDinero = "";//almacena el resultado
  var bufferDecimales = "";//almacena la parte decimal
  
  if (tokens.length > 1){
      bufferDecimales = tokens[1];
     
     if( bufferDecimales.length > 2 ){ 
         
         var digito = parseInt( bufferDecimales.charAt(3) );

         if( digito > 5 ){   
             var temp = new Number( parseInt( bufferDecimales.substring(0,1) ) ); 
             temp = temp + 1;
             decimales = "" + temp;
         
         } else {
             if(bufferDecimales.charAt(2) == "0"){
                decimales = bufferDecimales.substring(0,1) ;
             } else {
                decimales = bufferDecimales.substring(0,2) ;
             }
         }
        
     } else { 
          if(bufferDecimales.charAt(2) == "0"){
             decimales = bufferDecimales.substring(0,1) ;
          } else {
             decimales = bufferDecimales.substring(0,2) ;            
          }
     }
     

  }
  
  while (bufferEntero.length > 0) {
      if (bufferEntero.length > 3) {
           bufferDinero = separadorMiles + 
                bufferEntero.substr(bufferEntero.length-3) + bufferDinero ;
           bufferEntero = bufferEntero.substr(0, bufferEntero.length-3);
      } else {
           bufferDinero = bufferEntero.substr(0) + bufferDinero ;
           bufferEntero = "";
      }
  }
  
  if (decimales != "0" && decimales != "00" && decimales != undefined) {
      bufferDinero = bufferDinero + separadorDecimales + decimales;
  }
  
  if (negativo){
      bufferDinero = '-' + bufferDinero;
  }
  
  return bufferDinero;
}


///*[1]
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


function gestionaError (strCasoDeUso){
         if (get(FORMULARIO + '.errDescripcion') != '') {
                  var wnd = fMostrarMensajeError(get(FORMULARIO + '.errCodigo'),get(FORMULARIO + '.errDescripcion'));
                  if (strCasoDeUso != ''){
                           window.close();
                  }
         }
}

//Guarda en hidden el valor por defecto para acceso pues no está en sesion (se deriva del subacceso por defecto)
function seleccionarAcceso(){
         var i;
         if (typeof(datosSubaccesos) != 'undefined') {
                  //[1]var subacceso = get(FORMULARIO + '.subacceso');
                  for (i=0; i < datosSubaccesos.length; i++) { 
                           if (datosSubaccesos[i][0] == objsGen.subacceso){ //[1]subacceso) { 
                                    //set(FORMULARIO + '.acceso', datosSubaccesos[i][2]);
                                    objsGen.acceso =  datosSubaccesos[i][2];
                                    break;
                           }
                  }
         }
         preseleccionaValores();
                  
}

function postGuardado(numeroIdentif){
         fLimpiar();
         nIdentificacion = numeroIdentif;
         txt_to('lblvalorNIdentificacion',numeroIdentif);

}

function postAceptar(numeroIdentif) {
         nIdentificacion = numeroIdentif;
         txt_to('lblvalorNIdentificacion',numeroIdentif);
         set(FORMULARIO + '.NIdentificacion',nIdentificacion);
         btnProxy(1,1);
}

//*/[1]
