var formName ="frmInsertarCliente"; 
var listaVincuLimpiar;
var listaPrefLimpiar;
var listaObservLimpiar;

var ape1Limpiar;
var ape2Limpiar;
var nom1Limpiar;
var nom2Limpiar;
var apeCasadaLimpiar;
var tratamientoLimpiar;
var sexoLimpiar;
var formaPagoLimpiar;
var fechaNacimientoLimpiar;
var codEmpleadoLimpiar;
var nacionalidadLimpiar;
var estadoCivilLimpiar;
var ocupacionLimpiar;
var profesionLimpiar;
var centroLimpiar;
var cargoLimpiar;
var nivelEstudiosLimpiar;
var centroEstudiosLimpiar;
var nHijosLimpiar;
var nPersonasDepLimpiar;
var NSELimpiar;
var cicloFamiliarLimpiar;
var correspLimpiar;
var importeIngresoLimpiar;
var codCContactadoLimpiar;
var tipoCContactadoLimpiar;
var codTipoContactoLimpiar;
var fechaContactoLimpiar;
var fechaPrimerPedidoLimpiar;
var fechaSigContactoLimpiar;

//      Agregado por HRCS - Fecha 11/04/2007 - Incidencia Sicc20070184
var OID_TIPO_CLIENTE_HIJADUPLA = '5';
var OID_SUBTIPO_CLIENTE_HIJADUPLA = '6';
//      Agregado por HRCS - Fecha 10/08/2007 - Cambio Sicc20070361
var tiposVinculo;
var COD_TIPO_VINCULO_DUPLACYZONE = '01';
var COD_TIPO_VINCULO_RECOMENDADAyDANTE = '03';

// Agregado por SICC20070433 - Rafael Romero - 21/09/2007
var fechaAyer;

//---------------------------------------------------------------------------------------------------------------------
function onLoadPag() {
          /* var tInicio = new Date();  */

          var tInicioLimpiar = null;
          var tFinLimpiar = null;

           configurarMenuSecundario(formName);

           //setTimeout("ensancha()", 100);
                    ensancha();

           accion('frmInsertarCliente.textCodClienteContactado', '.maxLength=' + document.all.hidlongCliente.value);
           var largo = get('frmInsertarCliente.hidlongCliente');
           listado1.tiposCol[0][3] = largo;

           if ( !fMostrarMensajeError() ) {
                      completarComboInbound();
                      loadComboTipoContacto();
                      if  (get('frmInsertarCliente.casoDeUso') == "ModificarCliente" && 
                                                             get('frmInsertarCliente.oidNull') == "" ) {
                                  seteaCamposModificables();
                                  completarComboTratamientoModificar();
                                  actualizaFechaNacimiento();
                                  loadElementos();//Cleal

                                  var valorSexo = get("frmInsertarCliente.h_rbSexo");
                                  if (valorSexo == "M") {
                                           set("frmInsertarCliente.rbSexo", "S");
                                  }else{
                                           set("frmInsertarCliente.rbSexo", "N");
                                  }

                                 var nacionalidad = get("frmInsertarCliente.h_cbNacionalidad");
                                 if (nacionalidad != "") {
                                          set("frmInsertarCliente.cbNacionalidad", new Array(nacionalidad) );
                                 }

                                  seteaVarsLimpiar();
                                  cambiarPeriodoContacto('reentrando');
                     }

                      if (get('frmInsertarCliente.casoDeUso') == "ModificarCliente" && 
                                                             get('frmInsertarCliente.oidNull')=="MAE-0019" ) {
                                  seteaCamposModificables();                  

                                  completarComboTratamientoModificar();                        
                                  loadElementos();
                                  actualizaFechaNacimiento();
                                  seteaVarsLimpiar();
                      }

             if(get('frmInsertarCliente.casoDeUso')=="Insertar Cliente"){
                                  seteaCamposModificables();
                    
                                  loadElementos();
//Cleal                        ocultarCbIndActivo();
                                  completarComboTratamiento();
                                  completarOtrosCombos();
                                  
//                                alert("***3");

                                  var datosP2 = get(formName + ".elementosP2" );

                                  if(datosP2!=""){
                                                             // hay que cargar los datos de la pantalla
                                                             // funcion de libreria que recarga los valores pasados en el string.
                                                             // el string contiene los nombres de los componentes  y sus valores
                                                             //recargarValoresInsertar(datosP2);
                                                             recuperaDatosHidden();
                                                             cambiarPeriodoContacto('reentrando');
                                                             
                                  }else{
                                                   seteaValoresDefecto();
                                                   cambiarPeriodoContacto("pordefecto"); 
                                         }
                                    
                                    foco();
                                    seteaVarsLimpiar();
             }

                              if (window.dialogArguments) { // Si es modal (se abrió mediante showModalDialog) DBLG500000915
                              btnProxy(2,1);  // boton 'volver', habilitado
                              btnProxy(3,0);  // boton 'Ir a pantalla de inicio', deshabilitado
                    }

           }
          
          /* var fechaFin =new Date();
    alert("Tiempo de ejecucion de onload BBBB:\n " + (fechaFin.getTime() - tInicio.getTime() ) + " milisegundos");*/
          /*alert("Tiempo de ejecucion de EvalOnRSZ():\n " + (tFinLimpiar.getTime() - tInicioLimpiar.getTime() ) + " milisegundos");*/


                  // Agregado por HRCS - 10/08/2007 - Cambio Sicc20070361
                  // Modificado por SiCC20070433 - Rafael Romero - 21/09/2007
                  var array = new Array();
                  array[0] = new Array('oidPais', get("frmInsertarCliente.paisUsuario") );
                  var param = formarCadenaDT('MAEObtenerTodosTiposVinculos', 'es.indra.sicc.util.DTOOID', array);
  
                  var arrayAyer = new Array(); 
    arrayAyer[arrayAyer.length] = ['oidPais', get('frmInsertarCliente.paisUsuario')]; 
    arrayAyer[arrayAyer.length] = ['cadena','-1!%!'+get('frmInsertarCliente.hFormatoFechaPais')]; 
    
    asignar([['COMBO', 'frmInsertarCliente.cbTemporal', 'ConectorDruidaTransactionQuery', 'dtoSalida.resultado_ROWSET', param, 'salidaBusqueda(datos);'], 
              ['COMBO', 'frmInsertarCliente.cbTemporal', 'ConectorDruidaTransactionQuery', 'dtoSalida.resultado_ROWSET', formarCadenaDT('MAEObtenerFechaSistema', 'es.indra.sicc.util.DTOString', arrayAyer), 'estableceFechaAyer(datos)']]); 
             
    // Fin modificado SiCC20070433 
}
//--------------------------------------------------------------------------------------------------------------------
/*Cleal - Inc 21251
function ocultarCbIndActivo(){
           document.getElementById("ckIndActivoP2").style.visibility='hidden';
           document.getElementById("lblIndActivo").style.visibility='hidden';
           //document.all['ckIndActivoP2'].style.visibility='hidden';
           //document.all[].style
//      document.getElementById("ckIndActivoP2").disabled = true;
           //getElement('ckIndActivoP2').style.display = 'none';
           //getElement('lblIndActivo').style.display = 'none';

}*/

//--------------------------------------------------------------------------------------------------------------------
  function seteaValoresDefecto(){
    /*var marcaDefecto = get('frmInsertarCliente.hidMarcaDefecto');
    var canalDefecto  = get('frmInsertarCliente.hidCanalDefecto');
    
          iSeleccionado = new Array();
    iSeleccionado[0] = marcaDefecto;
    set('frmInsertarCliente.cbMarca',iSeleccionado);

    iSeleccionado = new Array();
    iSeleccionado[0] = canalDefecto;
    set('frmInsertarCliente.cbCanal',iSeleccionado);

          setComboDefecto('cbMarca','Grupo Todas' );
          setComboDefecto('cbCanal','Venta Directa' );

          var tamanio = document.getElementById("cbTipoClienteContactado").options.length;
          for( var i = 0; i < tamanio; i++){
                    if ( combo_get( cboTipoDir, 'T', i) == "Consultor(a)" ){
                              set( cboTipoDir, [ combo_get( cboTipoDir, 'V', i) ]);
                    }
          }
          set("frmInsertarCliente.rbDeseaCorrespondencia", "S"); */
  
    set("frmInsertarCliente.textCodClienteContactado", "MIGRACION");
    set("frmInsertarCliente.textFechaContacto", get("frmInsertarCliente.hidFechaIngreso"));
    
          fecha = get('frmInsertarCliente.hidFechaIngreso');
    vfecha = fecha.split("/");
    fechaFutura = vfecha[0] + '/' + vfecha[1] + '/' + (parseInt(vfecha[2])+1) ;
    set("frmInsertarCliente.textFechaSiguienteContacto", fechaFutura);

          set( formName +".cbMarca", [ get( formName +".valDefMarca" ) ]);
          set( formName +".cbCanal", [ get( formName +".valDefCanal" ) ]);
          set( formName +".cbTipoClienteContactado", [ get( formName +".valDefTipoClie" ) ]);
  }
  
  
  //enozigli 12/07/2005 BELC300015374


 function loadComboTipoContacto(){
             if (get(formName +'.hidcbCodTipoContactado')!=''){
                     var array = new Array();
                     array[0] = get(formName +'.hidcbCodTipoContactado');
                     set(formName +'.cbCodTipoContactado',array)
             }   
 }

//---------------------------------------------------------------------------------------------------------------------

function accionInsertarP1(){
           var datosStr = recolectarValores();
           seteaDatosHidden();
           set('frmInsertarCliente.elementosP2', datosStr );
           set(formName + '.accion','Siguiente1');

           // Obtiene el Caso de Uso correspondiente
           var casoUso = get("frmInsertarCliente.casoDeUso");
           if ( casoUso == "ModificarCliente"){
                      set(formName + '.conectorAction','LPModificarCliente');
                                           listado1.actualizaDat();
                                           listado2.actualizaDat();
                                           listado3.actualizaDat();
                                           var hidListaVinculoSal = listaToXml('listado1');
                                           var hidListaPrefeSal  = listaToXml("listado2");
                                           var hidListaObservacionSal = listaToXml("listado3");
                                           set("frmInsertarCliente.hidListaVinculoSal", hidListaVinculoSal);
                                           set("frmInsertarCliente.hidListaPrefeSal", hidListaPrefeSal);
                                           set("frmInsertarCliente.hidListaObservacionSal", hidListaObservacionSal);
                      /*colectar("tabla1");
                      colectar("tabla2");
                      colectar("tabla3");*/
           } else {
                      set('frmInsertarCliente.hidFocusPrimerComponente', 'false');
                      set(formName + '.conectorAction','LPInsertarCliente');
           }
                    // Agregado por HRCS para que no salga error 'parent.frames.iconos' - Fecha 10/04/2007 - Incidencia Sicc200070184
                    eval('frmInsertarCliente').oculto = 'N';
           enviaSICC(formName);
}
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function fLimpiar(){
           //listado1.init();
   casoDeUso = get('frmInsertarCliente.casoDeUso');
   if(casoDeUso == 'ModificarCliente'){
      //alert('entro en limpiar modificar');

      set('frmInsertarCliente.hidPestanya', '0'); 
      set('frmInsertarCliente.hPestanya', '-1');
      set('frmInsertarCliente.dtoOid', get('frmInsertarCliente.hiddenOid'));
      //alert('el oid ' + get('frmInsertarCliente.hiddenOid'))
      set('frmInsertarCliente.hidCodigoCliente', get('frmInsertarCliente.hiddenCodigo'));
    //  alert('el codigo es '+  get('frmInsertarCliente.hiddenCodigo'));
      set('frmInsertarCliente.accion', '');
      set('frmInsertarCliente.conectorAction', 'LPModificarCliente');
      enviaSICC('frmInsertarCliente', '', '', 'N');
    }else{ 
      listado1.setDatos(listaVincuLimpiar);
      listado2.setDatos(listaPrefLimpiar);
      listado3.setDatos(listaObservLimpiar);

      listaVincuLimpiar = duplicaArray(listaVincuLimpiar);
      listaPrefLimpiar = duplicaArray(listaPrefLimpiar);
      listaObservLimpiar = duplicaArray(listaObservLimpiar);

      set("frmInsertarCliente.textApellido1", ape1Limpiar);
      set("frmInsertarCliente.textApellido2", ape2Limpiar);
      set("frmInsertarCliente.textNombre1", nom1Limpiar);
      set("frmInsertarCliente.textNombre2", nom2Limpiar);
      set("frmInsertarCliente.textApellidoCasada", apeCasadaLimpiar);
      set("frmInsertarCliente.cbTratamiento", new Array(tratamientoLimpiar) );
      set("frmInsertarCliente.rbSexo", sexoLimpiar);
      set("frmInsertarCliente.cbFormaPago", new Array(formaPagoLimpiar) ) ;
      set("frmInsertarCliente.textFechaNacimiento", fechaNacimientoLimpiar );
      set("frmInsertarCliente.textCodEmpleado", codEmpleadoLimpiar );
      set("frmInsertarCliente.cbNacionalidad", new Array(nacionalidadLimpiar) );
      set("frmInsertarCliente.cbEstadoCivil", new Array(estadoCivilLimpiar) );
      set("frmInsertarCliente.textOcupacion", ocupacionLimpiar );
      set("frmInsertarCliente.textProfesion", profesionLimpiar );
      set("frmInsertarCliente.textCentroTrabajo", centroLimpiar );
      set("frmInsertarCliente.textCargoDesempena", cargoLimpiar );
      set("frmInsertarCliente.cbNivelEstudios", new Array(nivelEstudiosLimpiar) );
      set("frmInsertarCliente.textCentroEstudios", centroEstudiosLimpiar);
      set("frmInsertarCliente.textNHijos", nHijosLimpiar );
      set("frmInsertarCliente.textNPersonasDependientes", nPersonasDepLimpiar );
      set("frmInsertarCliente.cbNivelSocioEconomico", new Array(NSELimpiar) );
      set("frmInsertarCliente.cbCicloVidaFamiliar", new Array(cicloFamiliarLimpiar) );
      set("frmInsertarCliente.rbDeseaCorrespondencia", correspLimpiar );
      set("frmInsertarCliente.textImporteIngresoFamiliar", importeIngresoLimpiar );
      set("frmInsertarCliente.textCodClienteContactado", codCContactadoLimpiar );
      set("frmInsertarCliente.cbTipoClienteContactado", new Array(tipoCContactadoLimpiar) );
      set("frmInsertarCliente.cbCodTipoContactado", new Array(codTipoContactoLimpiar) );   // Inbound-Outbound
      set("frmInsertarCliente.textFechaContacto", fechaContactoLimpiar );
      set("frmInsertarCliente.textFecha1PedidoContacto", fechaPrimerPedidoLimpiar );
      set("frmInsertarCliente.textFechaSiguienteContacto", fechaSigContactoLimpiar );
}

}

//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function validacionRequeridos(){

           // Es necesario llamar a este metodo ante de sicc_validaciones_generales() para asegurarse que si algun campo
           // obligatorio esta vacio, entonces el mensaje de error mostrado sea "Deben rellenarse todos los campos obligatorios por tipo y subtipo de cliente"
           // y no el generico de Gaston.. - by Ssantana, Inc. 9317.
           var retorno = innerValidacionRequeridos();

           if (retorno){
                  if(!sicc_validaciones_generales()){
                         retorno = false;
                                         }
           }

           return retorno;

/*    var retorno = true;

           var oblig = get("frmInsertarCliente.obligatorio");
//      alert("Obligatorio: " + oblig);

           if (oblig != "")
           {
                      oblig = oblig.split(",");
                      for (var i = 0; (i < oblig.length) && (retorno == true) ; i++ )
                      {
                                    var valor = eval("get('frmInsertarCliente." + oblig[i] + "');");
           //                  alert("Valor: " + valor);
                                    if (valor == "")
                                  {
                                                retorno = false;
                                                //alert("CAMPO " + oblig[i] + " vacio");
                                                GestionarMensaje("1419");
                                                eval("focaliza('frmInsertarCliente." + oblig[i] + "', '');");
                                  }

                      }
           }

           return retorno;

*/


//           return true;
}

//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function innerValidacionRequeridos()
{
                      // Se llama para validar los requeridos, en base al contenido de la variable obligatorios.
                      var retorno = true;

                      var oblig = get("frmInsertarCliente.obligatorio");

                      if (oblig != "")
                      {
                                  oblig = oblig.split(",");
                                  for (var i = 0; (i < oblig.length) && (retorno == true) ; i++ )
                                  {
                                                var valor = eval("get('frmInsertarCliente." + oblig[i] + "');");
                                                if (valor == "")
                                                {
                                                           retorno = false;

                                                           GestionarMensaje("1419");
                                                           eval("focaliza('frmInsertarCliente." + oblig[i] + "', '');");
                                                                                                                    break;
                                                 }

                                  }
                      }

                      return retorno;

}

//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function accionInsertarP3() {
         // Contenido movido a nuevaAccionInsertarP3();
}

function continuaAccionInsertarP3()     {
                    var datosStr = recolectarValores();
                    if(get('frmInsertarCliente.casoDeUso')=="ModificarCliente" ) {  
                                              set(formName + '.accion','Siguiente3_Validar');
                                              set(formName + '.conectorAction','LPModificarCliente');
                                              set(formName + '.h_cbFormaPago',get('frmInsertarCliente.cbFormaPago'));
                                              set(formName + '.h_cbNacionalidad',get('frmInsertarCliente.cbNacionalidad'));
                                              set(formName + '.h_cbEstadoCivil',get('frmInsertarCliente.cbEstadoCivil'));
                                              set(formName + '.h_cbNivelEstudios',get('frmInsertarCliente.cbNivelEstudios'));
                                              set(formName + '.h_cbNivelSocioEconomico',get('frmInsertarCliente.cbNivelSocioEconomico'));
                                              set(formName + '.h_cbCicloVidaFamiliar',get('frmInsertarCliente.cbCicloVidaFamiliar'));
                                              set(formName + '.h_cbPaisContactado',get('frmInsertarCliente.cbPaisContactado'));
                                              set(formName + '.h_cbTipoClienteContactado',get('frmInsertarCliente.cbTipoClienteContactado'));
                                              set(formName + '.hidcbCodTipoContactado', get('frmInsertarCliente.cbCodTipoContactado'));

                                              set( formName + ".hidMarcaContacto", get('frmInsertarCliente.cbMarca') );
                                              set( formName + ".hidCanalContacto", get('frmInsertarCliente.cbCanal') );
                                              set( formName + ".hidPeriodoContacto", get('frmInsertarCliente.cbPeriodoPrimerPedido') );

                                              set( formName + ".descTratamiento", obtieneDescTratamiento() );

                                              if (get("frmInsertarCliente.rbSexo")  == "S") {
                                                                                                                                                   set(formName + ".h_rbSexo", "M");
                                                                                                                                           } else {
                                                      set(formName + ".h_rbSexo", "F");
                                                                                                                                           }

                                              set(formName + ".h_cbTratamiento", get("frmInsertarCliente.cbTratamiento") );

                                              set('frmInsertarCliente.elementosP2', datosStr );

                                                                                                                                           listado1.actualizaDat();
                                                                                                                                           listado2.actualizaDat();
                                                                                                                                           listado3.actualizaDat();

                                                                                                                                           var hidListaVinculoSal = listaToXml('listado1');
                                                                                                                                           var hidListaPrefeSal  = listaToXml("listado2");
                                                                                                                                           var hidListaObservacionSal = listaToXml("listado3");
                                                                                                                                           set("frmInsertarCliente.hidListaVinculoSal", hidListaVinculoSal);
                                                                                                                                           set("frmInsertarCliente.hidListaPrefeSal", hidListaPrefeSal);
                                                                                                                                           set("frmInsertarCliente.hidListaObservacionSal", hidListaObservacionSal);

                                                      // Agregado por SICC20070433 - Rafael Romero - 25/09/2007
                                                      set( "frmInsertarCliente.hidEdad"  , getElement("lblEdadActual").innerText);
                                                      // Fin agregado SICC20070433
                                                      
                                                                                     eval('frmInsertarCliente').oculto = 'S';
                                              enviaSICC(formName);
                                              return true;
                    }

                    seteaDatosHidden();
                    set('frmInsertarCliente.elementosP2', datosStr );
                    set(formName + '.accion','Siguiente3_Validar');
                    eval('frmInsertarCliente').oculto = 'S';
                    set('frmInsertarCliente.hidFocusPrimerComponente', 'true');
                    set(formName + '.conectorAction','LPInsertarCliente');
                    enviaSICC(formName);
                    return true;
}

//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function validaContacto(){
           // Valida que si hay un codigo de cliente contacto, haya seleccionado tipo de contacto. 
  var clienteContacto = get("frmInsertarCliente.textCodClienteContactado");
  var tipoClienteContactado = get("frmInsertarCliente.cbTipoClienteContactado");
  var tipoContacto = get("frmInsertarCliente.cbTipoClienteContactado");
  var fechaContacto = get("frmInsertarCliente.textFechaContacto");
  var fechaSiguienteContacto = get("frmInsertarCliente.textFecha1PedidoContacto");
  var marcaContacto = get("frmInsertarCliente.cbMarca");
  var canalContacto = get("frmInsertarCliente.cbCanal");
  var periodoContacto = get("frmInsertarCliente.cbPeriodoPrimerPedido");
  
  var concatena = tipoContacto + fechaContacto + fechaSiguienteContacto + marcaContacto + canalContacto + periodoContacto;
  
  //Incidencia BELC300022295 pzerbino 19/1/2006
  //Para que guarde los datos del contacto
  
  if (concatena != ""){
     if (clienteContacto == ""){
           GestionarMensaje("MAE0036");
           focaliza("frmInsertarCliente.textCodClienteContactado");           
           return false;
     }else{  
                        if(tipoClienteContactado == ""){

                GestionarMensaje("MAE0036");
                focaliza("frmInsertarCliente.cbTipoClienteContactado");
                return false
            }                
     }      
  }else{    
    if (clienteContacto != "")
    {      
      if (tipoClienteContactado == "")
      {

             GestionarMensaje("1416");
             focaliza("frmInsertarCliente.cbTipoClienteContactado");
             //alert("Tiene que seleccionar un subtipo de cliente");
             return false;
      }
    }
   } 

           return true;

}

//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 function validoOk(paramHijaDupla){
    //alert('entro a enviar de nuevo');
                  // Modificado por SICC20070433 - Rafael Romero - 24/09/2007 
    if(!pasoValidacionHijaDupla(paramHijaDupla)){ 
          return; 
    } 
    // Fin modifcado SiCC20070433 
    var datosStr = recolectarValores();
    seteaDatosHidden();
    set('frmInsertarCliente.elementosP2', datosStr );
    set(formName + '.accion','Siguiente3');
    eval('frmInsertarCliente').oculto = 'N';
    set('frmInsertarCliente.hidFocusPrimerComponente', 'true');
    set(formName + '.conectorAction','LPInsertarCliente');
    enviaSICC(formName);
                                  
 }

//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 function noValido(){

 }

//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 function validoOkModificar(paramHijaDupla){
    //alert("esta aca");
    // Modificado por SICC20070433 - Rafael Romero - 24/09/2007 
    if(!pasoValidacionHijaDupla(paramHijaDupla)){ 
          return; 
    } 
    // Fin modifcado SiCC20070433 

             var datosStr = recolectarValores();
    set(formName + '.accion','Siguiente3');
    set(formName + '.conectorAction','LPModificarCliente');
    set(formName + '.h_cbFormaPago',get('frmInsertarCliente.cbFormaPago'));
    set(formName + '.h_cbNacionalidad',get('frmInsertarCliente.cbNacionalidad'));
    set(formName + '.h_cbEstadoCivil',get('frmInsertarCliente.cbEstadoCivil'));
    set(formName + '.h_cbNivelEstudios',get('frmInsertarCliente.cbNivelEstudios'));
    set(formName + '.h_cbNivelSocioEconomico',get('frmInsertarCliente.cbNivelSocioEconomico'));
    set(formName + '.h_cbCicloVidaFamiliar',get('frmInsertarCliente.cbCicloVidaFamiliar'));
    set(formName + '.h_cbPaisContactado',get('frmInsertarCliente.cbPaisContactado'));
    set(formName + '.h_cbTipoClienteContactado',get('frmInsertarCliente.cbTipoClienteContactado'));
    set(formName + '.hidcbCodTipoContactado', get('frmInsertarCliente.cbCodTipoContactado'));

           set( formName + ".hidMarcaContacto", get('frmInsertarCliente.cbMarca') );
           set( formName + ".hidCanalContacto", get('frmInsertarCliente.cbCanal') );
           set( formName + ".hidPeriodoContacto", get('frmInsertarCliente.cbPeriodoPrimerPedido') );

    if ( get("frmInsertarCliente.rbSexo")  == "S"){
          set(formName + ".h_rbSexo"          , "M");
    }else{
          set(formName + ".h_rbSexo"          , "F");
    }
    
    set(formName + ".h_cbTratamiento", get("frmInsertarCliente.cbTratamiento") );

    set('frmInsertarCliente.elementosP2', datosStr );

    ////alert("colectar Tabla1");
/*    colectar("tabla1");
    colectar("tabla2");
    colectar("tabla3");*/

          listado1.actualizaDat();
          listado2.actualizaDat();
          listado3.actualizaDat();
          var hidListaVinculoSal = listaToXml('listado1');
          var hidListaPrefeSal  = listaToXml("listado2");
          var hidListaObservacionSal = listaToXml("listado3");
          set("frmInsertarCliente.hidListaVinculoSal", hidListaVinculoSal);
          set("frmInsertarCliente.hidListaPrefeSal", hidListaPrefeSal);
          set("frmInsertarCliente.hidListaObservacionSal", hidListaObservacionSal);

    eval('frmInsertarCliente').oculto = 'N';
    //alert('antes de enviar');
    enviaSICC(formName);
                                  
    
 }





//-------------------------------------------------------------------------------------------------------------------
function validarVinculo(){

                    // Agregado por HRCS - Fecha 13/08/2007 - Cambio Sicc20070361
                    // Codigo para obtener el OID del tipo de vinculo recomendante/recomendada
                    var oidTVRecomen = obtenerOidTipoVinculo(COD_TIPO_VINCULO_RECOMENDADAyDANTE);

                    // no estaba en el modelo, pero la BD no perfmite tipo vinculo ni codigo null
           listado1.actualizaDat();

                    var cont = 0;
                    var reco = 0;

           for(var t=0;t<listado1.datos.length;t++){
                      var tipoVinc= document.getElementById("comboTipoVinculo_" + t);
                      var textVinc= document.getElementById("TextoClienteVinculo_" + t);
                      // Modificado por SICC20070431 - Rafael Romero - 25/09/2007 
                      if(textVinc.value==get("frmInsertarCliente.codigoCliente")){ 
                          GestionarMensaje('MAE0047'); 
                          document.getElementById("TextoClienteVinculo_" + t).focus(); 
                          return false; 
                      } 
                      // Fin modificado SICC20070431 

                                             //if(tipoVinc.value == '9'){
                                             if(tipoVinc.value == oidTVRecomen){
                                                 cont = cont + 1;
                                                 if ( validarTipoVinculoEsRecomendante(tipoVinc.value)==1 )	{
                                                                reco = reco + 1;
                                                 }
                                             }

                      //vinculado
                      var codi = listado1.datos[t][1];
                      if(codi == ''){
                                  //alert("codigo de cliente vinculo no puede ser vacio");
                                  GestionarMensaje("2545");
                                  textVinc.focus();
                                  return false;
                      }
                      //tipo de vinculo
                      if((tipoVinc.selectedIndex == '')||(tipoVinc.value == '')){
                                  //alert("tipo vinculo no puede ser vacio");
                                  GestionarMensaje("2546");
                                  tipoVinc.focus();
                                  return false;
                      }

           }
                    for(var m=0;m<listado1.datos.length;m++){
                            for(var n=m+1;n<listado1.datos.length;n++){
                                      if(listado1.datos[m][1] == listado1.datos[n][1]){
                                              GestionarMensaje('1344');
                                              return false;
                                      }     
                            }
                    }

                    if(cont > 1){
              cdos_mostrarAlert('Sólo se permite un Tipo Vínculo Recomendante/Recomendada.');
                        return false;
                    }
      
                    // Agregado por HRCS - Fecha 10/08/2007 - Cambio Sicc20070361
                    if (reco > 0)	{
                             if(!validaSoloUnVinculoPrincipal()) {return false;}
                    }
                    // Agregado por HRCS - Fecha 27/08/2007 - Cambio Sicc20070361
                    if (!validarNingunVinculoPrincipalDuplaCyzone()) {return false;}

                    return true;
}

function validaSoloUnVinculoPrincipal(){
    var cont = 0;   
    var princDifTipoRecomyDante = 0;
    
            for(var x=0;x<listado1.datos.length;x++){
                    
                  var radio="CKVinculoPrincipal_"+x;
                  var radio = document.getElementById(radio);
                  var tipoVinc= document.getElementById("comboTipoVinculo_" + x);
                  
                  if(radio.checked==true){
                        cont = cont + 1;
                  }
                  
                  // vbongiov -- SiCC20070455 MAE -- 11/12/2007
                  if(radio.checked==true && tipoVinc.value != get('frmInsertarCliente.OID_TIPO_VINCULO_RECOMENDANTE_RECOMENDADA')){
                        princDifTipoRecomyDante = princDifTipoRecomyDante + 1;
                  }
            }          

            if ((cont != 1 ) && (listado1.datos.length > 0)){
            
                GestionarMensaje('1199');
                return false;     
            }
            
            // vbongiov -- SiCC20070455 MAE -- 11/12/2007
            if (princDifTipoRecomyDante == 1){            
                GestionarMensaje('2612');
                return false;     
            }
            
    return true;
}

//-------------------------------------------------------------------------------------------------------------------
function validarPreferencias(){
           // no estaba en el modelo, pero la BD no perfmite tipo prefe null
           listado2.actualizaDat();
           for(var t=0;t<listado2.datos.length;t++){
                      var tipoPrefe= document.getElementById("comboTipoPreferencia_" + t);
                      //tipo prefe
                      if((tipoPrefe.selectedIndex == '')||(tipoPrefe.value == '')){
                                  //alert("tipo prefe no puede ser vacio");
                                  GestionarMensaje("2547");
                                  tipoPrefe.focus();
                                  return false;
                      }
           }

  for(var m=0;m<listado2.datos.length;m++){
     for(var n=m+1;n<listado2.datos.length;n++){
           if(listado2.datos[m][1] == listado2.datos[n][1]){
              GestionarMensaje('1344');
              
              return false;
           }     
     }
  }
  
           return true;
}
//-------------------------------------------------------------------------------------------------------------------
function validarObservaciones(){
           // no estaba en el modelo, pero la BD no perfmite tipo prefe null
           listado3.actualizaDat();
           for(var t=0;t<listado3.datos.length;t++){
                      var cboMarca= document.getElementById("comboMarca_" + t);
                      //marca
                      if((cboMarca.selectedIndex == '')||(cboMarca.value == '')){
                                  //alert("marca no puede ser vacio");
                                  GestionarMensaje("2548");
                                  cboMarca.focus();
                                  return false;
                      }
           }
           return true;
}
//---------------------------------------------------------------------------------------------------------------------

function getElement(name){
           return document.getElementById(name);
}
//---------------------------------------------------------------------------------------------------------------------

function seteaDatosHidden(){

           var tempElement = getElement("lblFechaIngresoActual" );
           set( formName + ".hidFechaIngreso"  , tempElement.innerText  );

           // datos basicos
           tempElement = getElement("textApellido1" );
           set( formName + ".hidtextApellido1"  , tempElement.value);

           tempElement = getElement("textApellido2" );
           set( formName + ".hidtextApellido2"  , tempElement.value);

           tempElement = getElement("textApellidoCasada" );
           set( formName + ".hidtextApellidoCasada"  , tempElement.value);

           tempElement = getElement("textNombre1" );
           set( formName + ".hidtextNombre1"  , tempElement.value);

           tempElement = getElement("textNombre2" );
           set( formName + ".hidtextNombre2"  , tempElement.value);

           tempElement = getElement("cbTratamiento" );
           set( formName + ".hidcbTratamiento"  , tempElement.value);

           set( formName + ".hidrbSexo"  , get(formName + ".rbSexo"));

           tempElement = getElement("cbFormaPago" );
           set( formName + ".hidcbFormaPago"  , tempElement.value);

           // datos adicionales
           tempElement = getElement("textFechaNacimiento" );
           set( formName + ".hidtextFechaNacimiento"  , tempElement.value);

           tempElement = getElement("lblEdadActual" );
           set( formName + ".hidEdad"  , tempElement.innerText);

           //set( formName + ".hidEdad", tempElement.innerText);
           tempElement = getElement("textCodEmpleado" );
           set( formName + ".hidtextCodEmpleado"  , tempElement.value);

           tempElement = getElement("cbNacionalidad" );
           set( formName + ".hidcbNacionalidad"  , tempElement.value);

           tempElement = getElement("cbEstadoCivil" );
           set( formName + ".hidcbEstadoCivil"  , tempElement.value);

           tempElement = getElement("textOcupacion" );
           set( formName + ".hidtextOcupacion"  , tempElement.value);

           tempElement = getElement("textProfesion" );
           set( formName + ".hidtextProfesion"  , tempElement.value);

           tempElement = getElement("textCentroTrabajo" );
           set( formName + ".hidtextCentroTrabajo"  , tempElement.value);

           tempElement = getElement("textCargoDesempena" );
           set( formName + ".hidtextCargoDesempena"  , tempElement.value);

           tempElement = getElement("cbNivelEstudios" );
           set( formName + ".hidcbNivelEstudios"  , tempElement.value);

           tempElement = getElement("textCentroEstudios" );
           set( formName + ".hidtextCentroEstudios"  , tempElement.value);

           tempElement = getElement("textNHijos" );
           set( formName + ".hidtextNHijos"  , tempElement.value);

           tempElement = getElement("textNPersonasDependientes" );
           set( formName + ".hidtextNPersonasDependientes"  , tempElement.value);

           tempElement = getElement("cbNivelSocioEconomico" );
           set( formName + ".hidcbNivelSocioEconomico"  , tempElement.value);

           tempElement = getElement("cbCicloVidaFamiliar" );
           set( formName + ".hidcbCicloVidaFamiliar"  , tempElement.value);

           set( formName + ".hidrbDeseaCorrespondencia"  , get(formName + ".rbDeseaCorrespondencia"));

           tempElement = getElement("textImporteIngresoFamiliar" );
           set( formName + ".hidtextImporteIngresoFamiliar"  , tempElement.value);

           tempElement = getElement("textCodClienteContactado" );
           set( formName + ".hidtextCodClienteContactado"  , tempElement.value);

           tempElement = getElement("cbTipoClienteContactado" );
           set( formName + ".hidcbTipoClienteContactado"  , tempElement.value);

           tempElement = getElement("cbCodTipoContactado" );
           set( formName + ".hidcbCodTipoContactado"  , tempElement.value);

           tempElement = getElement("textFechaContacto" );
           set( formName + ".hidtextFechaContacto"  , tempElement.value);

           tempElement = getElement("cbMarca");
           set( formName + ".hidMarcaContacto"  , tempElement.value);

           tempElement = getElement("cbCanal");
           set( formName + ".hidCanalContacto"  , tempElement.value);

           tempElement = getElement("cbPeriodoPrimerPedido");
           set( formName + ".hidPeriodoContacto"  , tempElement.value);
          

           tempElement = getElement("textFechaSiguienteContacto" );

           set( formName + ".hidtextFechaSiguienteContacto"  , tempElement.value);
   tempElement = getElement
           //grupo vinculos


           listado1.actualizaDat();

                    if( listado1.datos.length!=0){
                                          var listavinculos = recolectarValoresLista(document.getElementById("tblDatlistado1" ));
                                          set( formName + ".hidListaVinculo"  ,listavinculos);

                    }

                     //grupo preferencia
                    if( listado2.datos.length!=0){
                              var listaprefe = recolectarValoresLista(document.getElementById("tblDatlistado2" ));
                                set( formName + ".hidListaPrefe"  ,listaprefe );
                                          
                    }
                     // grupo obserbaciones

          if(listado3.datos.length){
                     var listaobser = recolectarValoresLista(document.getElementById("tblDatlistado3" ));
           set( formName + ".hidListaObservacion"  ,listaobser);

          }

}
//---------------------------------------------------------------------------------------------------------------------

function recuperaDatosHidden(){
           // datos basicos
           //alert("RecuperaDatosHidden");
           var tempElement = getElement("textApellido1" );
           tempElement.value = get( formName + ".hidtextApellido1");
           tempElement = getElement("textApellido2" );
           tempElement.value = get( formName + ".hidtextApellido2");
           tempElement = getElement("textApellidoCasada" );
           tempElement.value = get( formName + ".hidtextApellidoCasada");
           tempElement = getElement("textNombre1" );
           tempElement.value = get( formName + ".hidtextNombre1");
           tempElement = getElement("textNombre2" );
           tempElement.value = get( formName + ".hidtextNombre2");
           tempElement = getElement("cbTratamiento" );
           tempElement.value = get( formName + ".hidcbTratamiento");
           tempElement = getElement("rbSexo" );
           set( formName + ".rbSexo" , get( formName + ".hidrbSexo" ));
           
           tempElement = getElement("cbFormaPago" );
           tempElement.value = get( formName + ".hidcbFormaPago"  );
           // datos adicionales
           tempElement = getElement("textFechaNacimiento" );
           tempElement.value = get( formName + ".hidtextFechaNacimiento" );
           tempElement = getElement("lblEdadActual" );
           txt_to("lblEdadActual", get( formName + ".hidEdad" ));
           tempElement = getElement("textCodEmpleado" );
           tempElement.value=get( formName + ".hidtextCodEmpleado");
           tempElement = getElement("cbNacionalidad" );
           tempElement.value = get( formName + ".hidcbNacionalidad" );
           tempElement = getElement("cbEstadoCivil" );
           tempElement.value = get( formName + ".hidcbEstadoCivil"  );
           tempElement = getElement("textOcupacion" );
           tempElement.value =  get( formName + ".hidtextOcupacion");
           tempElement = getElement("textProfesion" );
           tempElement.value = get( formName + ".hidtextProfesion"  );
           tempElement = getElement("textCentroTrabajo" );
           tempElement.value = get( formName + ".hidtextCentroTrabajo"  );
           tempElement = getElement("textCargoDesempena" );
           tempElement.value= get( formName + ".hidtextCargoDesempena"  );
           tempElement = getElement("cbNivelEstudios" );
           tempElement.value = get( formName + ".hidcbNivelEstudios"  );
           tempElement = getElement("textCentroEstudios" );
           tempElement.value =   get( formName + ".hidtextCentroEstudios");
           tempElement = getElement("textNHijos" );
           tempElement.value = get( formName + ".hidtextNHijos" );
           tempElement = getElement("textNPersonasDependientes" );
           tempElement.value = get( formName + ".hidtextNPersonasDependientes" );
           tempElement = getElement("cbNivelSocioEconomico" );
           tempElement.value = get( formName + ".hidcbNivelSocioEconomico"  );
           tempElement = getElement("cbCicloVidaFamiliar" );
           tempElement.value = get( formName + ".hidcbCicloVidaFamiliar"  );
//      tempElement = getElement("rbDeseaCorrespondencia" );
//      tempElement.checked = get( formName + ".hidrbDeseaCorrespondencia" );
           set( formName + ".rbDeseaCorrespondencia" , get( formName + ".hidrbDeseaCorrespondencia" ));
           tempElement = getElement("textImporteIngresoFamiliar" );
           tempElement.value = get( formName + ".hidtextImporteIngresoFamiliar"  );
           tempElement = getElement("textCodClienteContactado" );
           tempElement.value = get( formName + ".hidtextCodClienteContactado");
           tempElement = getElement("cbTipoClienteContactado" );
           tempElement.value = get( formName + ".hidcbTipoClienteContactado"  );
           
           tempElement = getElement("cbCodTipoContactado" );
           tempElement.value = get( formName + ".hidcbCodTipoContactado"  );

           tempElement = getElement("textFechaContacto" );
           tempElement.value = get( formName + ".hidtextFechaContacto" );

           tempElement = getElement("cbMarca" );
           tempElement.value = get( formName + ".hidMarcaContacto" );
           //alert("Marca: " + get( formName + ".hidMarcaContacto" ) );
/*      //Cleal
           tempElement = getElement("ckIndActivoP2");
           tempElement.value = get( formName + ".hIndActivoP2" );
//      alert("Ind Activo: " + get( formName + ".hIndActivoP2" ) );
*/
           tempElement = getElement("cbCanal" );
           tempElement.value = get( formName + ".hidCanalContacto" );
           //alert("Canal: " + get( formName + ".hidCanalContacto" ) );

           //tempElement = getElement("textFecha1PedidoContacto" );
           //tempElement.value = get( formName + ".hidtextFecha1PedidoContacto" );

           tempElement = getElement("textFechaSiguienteContacto" );
           tempElement.value = get( formName + ".hidtextFechaSiguienteContacto"  );
           recargarVinculos();
      listado1.actualizaDat();
           recargarPreferencias();
      listado2.actualizaDat();
           recargarObservacion();
      listado3.actualizaDat();

           deshabilitarFechaHastaVinculo();	// Agregado por HRCS - Fecha 22/08/2007 - Cambio Sicc20070361
}

//---------------------------------------------------------------------------------------------------------------------
/*Cleal - Inc 21251
function actualizaChkIndActivo(){
//      alert(get("frmInsertarCliente.hIndActivoP2"));
           if(get("frmInsertarCliente.hIndActivoP2")== "1"){
//                    alert("*** En 1 - modificar");
                      set('frmInsertarCliente.ckIndActivoP2','S');
                      
           } else{
//                                alert("*** En 0 - modificar");         
                                  set('frmInsertarCliente.ckIndActivoP2','N');
                                              
           }
           
           document.getElementById("ckIndActivoP2").disabled = true;
}
*/
//---------------------------------------------------------------------------------------------------------------------
function Validar(){
           ////alert('valkidar');
}
//---------------------------------------------------------------------------------------------------------------------

function completarComboTratamiento(){
           /*var sr = GestionarMensaje(1047);
           var sra = GestionarMensaje(1048);
           var srta = GestionarMensaje(1049);*/
                    //Cleal - BELC300022757
                     var array = new Array(); 
                     array[0] = ["", ""];
                     array[1] = ["1", GestionarMensaje(1047)];
                     array[2] = ["2", GestionarMensaje(1048)];
                     array[3] = ["3", GestionarMensaje(1049)];

                     set_combo('frmInsertarCliente.cbTratamiento', array, new Array(get('frmInsertarCliente.valDefTratamiento')) );
     setComboDefecto('cbTratamiento',get('frmInsertarCliente.valDefTratamiento'));
}

function completarComboTratamientoModificar(){
           var sr = GestionarMensaje(1047);
           var sra = GestionarMensaje(1048);
           var srta = GestionarMensaje(1049);
                    //Cleal - BELC300022757
                     var array = new Array(); 
                     array[0] = ["", ""];
                     array[1] = ["1", GestionarMensaje(1047)];
                     array[2] = ["2", GestionarMensaje(1048)];
                     array[3] = ["3", GestionarMensaje(1049)];

                     //set_combo('frmInsertarCliente.cbTratamiento', array, new Array(get('frmInsertarCliente.h_cbTratamiento')) );
                     set_combo('frmInsertarCliente.cbTratamiento', array, [2] );
           // ------------ Setea el combo Tratamiento
         /*   set('frmInsertarCliente.cbTratamiento', new Array (get('frmInsertarCliente.valDefTratamiento'))); */
}

// -----------------------------------------------------------------------------------------------------------------------------------------------
function completarOtrosCombos(){

             sexo = "";
             if(get('frmInsertarCliente.valDefSexo')=="F") {
                         sexo="N";
             } else if(get('frmInsertarCliente.valDefSexo')=="M") {
                         sexo="S";
             }

      set('frmInsertarCliente.rbSexo', sexo);
             
      if(get('frmInsertarCliente.valDefNacionalidad') != ''){

            var combo = combo_get('frmInsertarCliente.cbNacionalidad', 'L');
            var descripciones = new Array();
            var oids = new Array();
            var valDef = get('frmInsertarCliente.valDefNacionalidad');

            for (var i = 0; i<combo; i++ ){
                descripciones[descripciones.length] = combo_get('frmInsertarCliente.cbNacionalidad', 'T', i); 
                oids[oids.length] = combo_get('frmInsertarCliente.cbNacionalidad', 'V', i);
            }

            for(var j = 0; j<descripciones.length; j++ ){
                if(valDef == descripciones[j]){
                     set('frmInsertarCliente.cbNacionalidad',new Array(oids[j]));
                     break;
                }
            }
   
      }

      if(get('frmInsertarCliente.valDefEstCivil') != ''){
            var combo2 = combo_get('frmInsertarCliente.cbEstadoCivil', 'L');
            var descripciones2 = new Array();
            var oids2 = new Array();
            var valDef2 = get('frmInsertarCliente.valDefEstCivil');

            for (var i = 0; i<combo2; i++ ){
                descripciones2[descripciones2.length] = combo_get('frmInsertarCliente.cbEstadoCivil', 'T', i); 
                oids2[oids2.length] = combo_get('frmInsertarCliente.cbEstadoCivil', 'V', i);
            }

            for(var j = 0; j<descripciones2.length; j++ ){
                if(valDef2 == descripciones2[j]){
                     set('frmInsertarCliente.cbEstadoCivil',new Array(oids2[j]));
                     break;
                }
            }
 
      }

      if(get('frmInsertarCliente.valDefNivEst') != ''){
            var combo3 = combo_get('frmInsertarCliente.cbNivelEstudios', 'L');
            var descripciones3 = new Array();
            var oids3 = new Array();
            var valDef3 = get('frmInsertarCliente.valDefNivEst');

            for (var i = 0; i<combo3; i++ ){
                descripciones3[descripciones3.length] = combo_get('frmInsertarCliente.cbNivelEstudios', 'T', i); 
                oids3[oids3.length] = combo_get('frmInsertarCliente.cbNivelEstudios', 'V', i);
            }

            for(var j = 0; j<descripciones3.length; j++ ){
                if(valDef3 == descripciones3[j]){
                     set('frmInsertarCliente.cbNivelEstudios',new Array(oids3[j]));
                     break;
                }
            }
      }

      if(get('frmInsertarCliente.valDefNivSocEco') != ''){
            var combo4 = combo_get('frmInsertarCliente.cbNivelSocioEconomico', 'L');
            var descripciones4 = new Array();
            var oids4 = new Array();
            var valDef4 = get('frmInsertarCliente.valDefNivSocEco');

            for (var i = 0; i<combo4; i++ ){
                descripciones4[descripciones4.length] = combo_get('frmInsertarCliente.cbNivelSocioEconomico', 'T', i); 
                oids4[oids4.length] = combo_get('frmInsertarCliente.cbNivelSocioEconomico', 'V', i);
            }

            for(var j = 0; j<descripciones4.length; j++ ){
                if(valDef4 == descripciones4[j]){
                     set('frmInsertarCliente.cbNivelSocioEconomico',new Array(oids4[j]));
                     break;
                }
            } 
      }

      if(get('frmInsertarCliente.valDefCicVidFam') != ''){
            var combo5 = combo_get('frmInsertarCliente.cbCicloVidaFamiliar', 'L');
            var descripciones5 = new Array();
            var oids5 = new Array();
            var valDef5 = get('frmInsertarCliente.valDefCicVidFam');

            for (var i = 0; i<combo5; i++ ){
                descripciones5[descripciones5.length] = combo_get('frmInsertarCliente.cbCicloVidaFamiliar', 'T', i); 
                oids5[oids5.length] = combo_get('frmInsertarCliente.cbCicloVidaFamiliar', 'V', i);
            }

            for(var j = 0; j<descripciones5.length; j++ ){
                if(valDef5 == descripciones5[j]){
                     set('frmInsertarCliente.cbCicloVidaFamiliar',new Array(oids5[j]));
                     break;
                }
            } 
          
      }

      if(get('frmInsertarCliente.valDefFormPago') != ''){
            var combo6 = combo_get('frmInsertarCliente.cbFormaPago', 'L');
            var descripciones6 = new Array();
            var oids6 = new Array();
            var valDef6 = get('frmInsertarCliente.valDefFormPago');

            for (var i = 0; i<combo6; i++ ){
                descripciones6[descripciones6.length] = combo_get('frmInsertarCliente.cbFormaPago', 'T', i); 
                oids6[oids6.length] = combo_get('frmInsertarCliente.cbFormaPago', 'V', i);
            }

            for(var j = 0; j<descripciones6.length; j++ ){
                if(valDef6 == descripciones6[j]){
                     set('frmInsertarCliente.cbFormaPago',new Array(oids6[j]));
                     break;
                }
            } 
      }
      
     deseaCorrespondencia = "";
     if(get('frmInsertarCliente.valDefDeseaCorrespondencia')=="Si") {
         deseaCorrespondencia="S";
     } else if(get('frmInsertarCliente.valDefDeseaCorrespondencia')=="No") {
         deseaCorrespondencia="N";
     }

      set('frmInsertarCliente.rbDeseaCorrespondencia', deseaCorrespondencia);
      
}
//---------------------------------------------------------------------------------------------------------------------
function completarComboInbound(){
           var Inbound = "Inbound";// GestionarMensaje(1047);
           var Outbound = "Outbound";//GestionarMensaje(1048);

           var array = new Array();
           array[0] = ["", ""];
           array[1] = ["I", Inbound];
           array[2] = ["O", Outbound];

          /* combo_add(formName + '.cbCodTipoContactado', new Array("",""));
           combo_add(formName + '.cbCodTipoContactado', "I" , Inbound);
           combo_add(formName + '.cbCodTipoContactado', "O" , Outbound);*/
           set_combo("frmInsertarCliente.cbCodTipoContactado", array);
}

//---------------------------------------------------------------------------------------------------------------------
function actualizaFechaNacimiento(){
                     /* var ini = new Date(); */
           var campoFecha = document.getElementById("textFechaNacimiento" );
           var edad = 0;
           if(campoFecha.value !="" && !EsFechaValida_SICC(campoFecha.value, formName)){
                      // no es valida la fecha
                      GestionarMensaje('1006',get(formName + '.hFormatoFechaPais')); 
                      txt_to('lblEdadActual','');   
                      focaliza(formName + '.'  + campoFecha.name);
                      return;
           }else{
                      if(campoFecha.value == "" ){
                      txt_to('lblEdadActual','');   
                                  return;
                      }
                      // la fecha es valida. asi que veo como calculo la edad.
                      var fecha = campoFecha.value;
                      var today = new Date();
                      var todayDay = today.getDate();
                      var todayMonth = (today.getMonth() + 1);
                      var todayYear = today.getFullYear();
                      var formatoFecha = get(formName + ".hFormatoFechaPais" );
                var delim  = obtieneDelimitador(formName);
                var fechaSpliteada = "";
                FechaCortada = fecha.split(delim);
                fechaSpliteada = formatoFecha.split(delim);
                            // Chequea cuál es el año (Y o y), al resto (mes o dia, le agrega ceros si es necesario).
              var formatoArray = new Array(3);
              for (var i = 0; i<3; i++ ){
                            formatoArray[i] = parseaFormato(i, formName);
              }    

             var diaMesAgno = "";
             for (var i = 0; i<3; i++){
                         diaMesAgno = formatoArray[i];
                         switch (diaMesAgno)
                         {
                         case 1:
                                         NDiaD = FechaCortada[i];
                                         break;
                         case 2:
                                         NMesD = FechaCortada[i];
                                         break;
                         case 3: 
                                  NAnoD = FechaCortada[i];
                                         break;
                         }
             }
                ////alert("Dia:"  + NDiaD +"  Mes:"  + NMesD + " Anio:"  + NAnoD );
                ////alert("Dia:"  + todayDay +"  Mes:"  + todayMonth + " Anio:"  + todayYear );
                edad= todayYear - NAnoD;
                if(todayMonth>NMesD){
                                  // no hago nada
                }else if (todayMonth<NMesD){
                                  // resto un anio a la edad porque todavia no se cumplio
                                  edad= edad - 1;
                }else if (todayMonth==NMesD){
                                  // si son iguales debo comprobar los dias
                                  if(todayDay>NDiaD){
                                              // no hago nada
                                  }else if(todayDay<NDiaD){
                                              edad = edad - 1;
                                  }
                }
           }
  //set(formName + '.hidEdad', edad)
           txt_to('lblEdadActual',edad);  
                     /* var fin = new Date(); */

                     /* alert("Tiempo de ejecucion de actualizaFechaNacimiento():\n " + (fin - ini) ); */
/*                                  alert("Tiempo de ejecucion de onload:\n " + (fechaFin.getMilliseconds() - tInicio.getMilliseconds() ) + " milisegundos");*/
                  
}

//---------------------------------------------------------------------------------------------------------------------
//function masVinculos () {}
//function masObservaciones () {}
//function masPreferencias () {}
//function accionSiguiente3 () { 
           // reemplazado por otro
           // accionInsertarP3();
//}
//---------------------------------------------------------------------------------------------------------------------
function clienteContactadoOnBlur () {

           var longiCod = get(formName + ".hidlongCliente");
           var elTexto= get(formName + ".textCodClienteContactado");
           if(elTexto.length!=0){
           //     alert(elTexto+ " debe tener " + longiCod + " caracteres de largo") ;
                      var faltantes = longiCod -  elTexto.length;
                      var resultCod=new String("");
                      if(faltantes > 0){
                                  for(var t = 0 ; t<faltantes; t++){
                                              resultCod = resultCod + "0";
                                  }
                      }
                      resultCod = resultCod + elTexto;
                      set(formName + ".textCodClienteContactado", resultCod);
           }
}
//---------------------------------------------------------------------------------------------------------------------

function clienteVinculoOnBlur (objetoCampo ) {
           if(objetoCampo.value.length!=0){
                      var longiCod = get(formName + ".hidlongCliente");
                      //alert(objetoCampo.value + " debe tener " + longiCod + " caracteres de largo") ;
                      var faltantes = longiCod -  objetoCampo.value.length;
                      var resultCod=new String("");
                      if(faltantes > 0){
                                  for(var t = 0 ; t<faltantes; t++){
                                              resultCod = resultCod + "0";
                                  }
                      }
                      resultCod = resultCod + objetoCampo.value;
                      //alert(resultCod);
                      var indTemp = objetoCampo.name.split("_");
                      var indexTemp = Math.abs(indTemp[1]);
                      listado1.datos[indexTemp][1]=resultCod;
                      listado1.repintaDat();
                      //var cbAEnfocar = document.getElementById("comboTipoVinculo_" + indexTemp);
                      //cbAEnfocar.focus();

                                             //	Agregado por HRCS - Fecha 04/04/2006 - Incidencia Sicc20070184
                                             seteaVinculoPorTipoCliente();
           }
}


//###################Carga Combos y Radios###########################/
//---------------------------------------------------------------------------------------------------------------------

function analizaCombo(obj,comp)
{
           var indice =obj.options;
                     var absComp = Math.abs(get('frmInsertarCliente.'+comp));
           for(var i=0;i<indice.length;i++){
                      if(indice.item(i).value==absComp){
                                  indice.item(i).selected=true;
                      }
           }
                      
}
//---------------------------------------------------------------------------------------------------------------------

function loadElementos()
{
           ////alert(get('frmInsertarCliente.h_cbFormaPago'));

           var el = document.getElementById("cbTratamiento");
           analizaCombo(el, 'h_cbTratamiento');

           var el=document.getElementById("cbFormaPago" );
           //var indice=el.options.item(Math.abs(get('frmInsertarCliente.h_cbFormaPago'))).selected=true;
           analizaCombo(el,'h_cbFormaPago');
           var el=document.getElementById("cbNacionalidad" );
           //var indice=el.options.item(Math.abs(get('frmInsertarCliente.h_cbNacionalidad'))).selected=true;
           analizaCombo(el,'h_cbNacionalidad');
           var el=document.getElementById("cbEstadoCivil" );
           //var indice=el.options.item(Math.abs(get('frmInsertarCliente.h_cbEstadoCivil'))).selected=true;
           analizaCombo(el,'h_cbEstadoCivil');
           
           var el=document.getElementById("cbNivelEstudios" );
           //var indice=el.options.item(Math.abs(get('frmInsertarCliente.h_cbNivelEstudios'))).selected=true;
           analizaCombo(el,'h_cbNivelEstudios');

           var el=document.getElementById("cbNivelSocioEconomico" );
           //var indice=el.options.item(Math.abs(get('frmInsertarCliente.h_cbNivelSocioEconomico'))).selected=true;
           analizaCombo(el,'h_cbNivelSocioEconomico');

           var el=document.getElementById("cbCicloVidaFamiliar" );
           //var indice=el.options.item(Math.abs(get('frmInsertarCliente.h_cbCicloVidaFamiliar'))).selected=true;
           analizaCombo(el,'h_cbCicloVidaFamiliar');

           //var el=document.getElementById("cbPaisContactado" );
           //var indice=el.options.item(Math.abs(get('frmInsertarCliente.h_cbPaisContactado'))).selected=true;
           //analizaCombo(el,'h_cbPaisContactado');
           set('frmInsertarCliente.rbSexo',get('frmInsertarCliente.h_rbSexo'));
           set('frmInsertarCliente.rbDeseaCorrespondencia',get('frmInsertarCliente.h_rbDeseaCorrespondencia'));
           var el=document.getElementById("cbTipoClienteContactado" );
           //alert(get('frmInsertarCliente.h_cbTipoClienteContactado'));
           //var indice=el.options.item(Math.abs(get('frmInsertarCliente.h_cbTipoClienteContactado'))).selected=true;
           analizaCombo(el,'h_cbTipoClienteContactado');

           // ---------- Setea el RadioB Sexo.
           var sexo = get("frmInsertarCliente.h_rbSexo");
           if (sexo != ""){
                      if (sexo == "M"){
                                  set("frmInsertarCliente.rbSexo", "S");
                      }else if (sexo == "F"){
                                  set("frmInsertarCliente.rbSexo", "N");
                      }
           }
           // ------------ Setea el RadioB deseaCorrespondencia
           var deseaCorrespondencia = get("frmInsertarCliente.h_rbDeseaCorrespondencia");
           if ( deseaCorrespondencia != "")
           {      
                      if (deseaCorrespondencia == "true"){
                                  set("frmInsertarCliente.rbDeseaCorrespondencia", "S");
                      }else if (deseaCorrespondencia == "false"){
                                  set("frmInsertarCliente.rbDeseaCorrespondencia", "N");
                      }
           }

           // -------------- Combo Marca -----------------------------------------
           var el=document.getElementById("cbMarca");
           analizaCombo(el,'hidMarcaContacto');

           // ------------ Combo Canal --------------------------------------------
           var el=document.getElementById("cbCanal");
           analizaCombo(el,'hidCanalContacto');

}
//---------------------------------------------------------------------------------------------------------------------

function renumerarObservacion(){
           for(var f=0;f<listado3.datos.length;f++){
                      var gg= new String("");
                      gg =(f + 1) +"";
                      listado3.datos[f][2] =  gg;   //fila 1, columna 2
           }
           listado3.repinta();
}
//---------------------------------------------------------------------------------------------------------------------
function colectar(tabla)
{
           var cadena="";
           var nombre;
           var valor;
           var hid;
           if( tabla == "tabla1" )          {
                      // Actualizo los datos con lo que hay en pantalla, por las dudas.
                      listado1.actualizaDat();
                      // Obtengo datos
                      var datosLista = listado1.datos;
                      var longLista = listado1.codigos().length;
                      ////alert("entre en 1" );
                      //alert("datosLista: " + datosLista);

                      var campos = new Array();
                      campos[0] = "h_oidVinculo_";
                      //campos[1] = "h_paisVinculo_";
                      campos[1] = "h_clienteVinculo_";
                      campos[2] = "h_tipoVinculo_";
                      campos[3] = "h_fechaDesde_";
                      campos[4] = "h_fechaHasta_";
                      campos[5] = "h_principal_";

                      for ( var i = 0; i < longLista; i++){
                                  if ( i != 0){
                                              cadena = cadena + "|";
                                  }

                                  for ( var j = 0; j < campos.length; j++)     {
                                              if (j != 0){
                                                          cadena = cadena + ";";
                                              }

                                              cadena = cadena + campos[j]+ i + "=" + datosLista[i][j];
                                  }
                      }
                      //alert("cadenas Lista1: " + cadena);
                      set('frmInsertarCliente.hidListaVinculoSal', cadena);

           }else if(tabla=="tabla2" ){
                      ////alert("entre en 2" );

                      // Actualizo los datos con lo que hay en pantalla, por las dudas.
                      listado2.actualizaDat();

                      var datosLista = listado2.datos;
                      var longLista = listado2.codigos().length;

                      ////alert("entre en 2" );
                      //alert("datosLista: " + datosLista);

                      var campos = new Array();
                      campos[0] = "h_oidPref_";
                      campos[1] = "h_tipoPref_";
                      campos[2] = "h_descPref_";

                      for ( var i = 0; i < longLista; i++){
                                  if ( i != 0){
                                              cadena = cadena + "|";
                                  }
                                  for ( var j = 0; j < 3; j++){
                                              if (j != 0){
                                                          cadena = cadena + ";";
                                              }
                                              cadena = cadena + campos[j] + i + "=" + datosLista[i][j];
                                  }
                      }
                      //alert("cadena Lista2: " + cadena);
                      set("frmInsertarCliente.hidListaPrefeSal", cadena);
                      //hid="hidListaPrefeSal";
           }else if(tabla=="tabla3" ){
                      ////alert("entre en 3" );

                      // Actualizo los datos con lo que hay en pantalla, por las dudas.
                      listado3.actualizaDat();

                      var datosLista = listado3.datos;
                      var longLista = listado3.codigos().length;

                      //alert("datosLista: " + datosLista);

                      var campos = new Array();
                      campos[0] = "h_oidObserv_";
                      campos[1] = "h_marca_";
                      campos[2] = "h_nroObserv_";
                      campos[3] = "h_textoObserv_";

                      for ( var i = 0; i < longLista; i++)
                      {
                                  if ( i != 0){
                                              cadena = cadena + "|";
                                  }
                                  for ( var j = 0; j < 4; j++){
                                              if (j != 0){
                                                          cadena = cadena + ";";
                                              }
                                              cadena = cadena + campos[j] + i + "=" + datosLista[i][j];
                                  }
                                  //alert("cadena: " + cadena);
                      }

                      //alert("cadena Lista3: " + cadena);
                      set('frmInsertarCliente.hidListaObservacionSal', cadena);
           }
}
//---------------------------------------------------------------------------------------------------------------------

 function agregarFila(nombreLista, oid)
{

           // ******* Agrega una fila en blanco en la lista correspondiente.
           // **********************************************************************

           var nuevaFila = new Array();

           if (nombreLista == "listado1" ){
                      if (oid != ""){    // Se genera una fila nueva con el oid especificado
                                  nuevaFila[0] = oid;
                      }else{
                                  //nuevaFila[0] = "g" + listado1.datos.length;
                                  nuevaFila[0] = "g";
                      }
                      nuevaFila[1] = "";
                      nuevaFila[2] = "";
                                             //	Modificado por HRCS - Fecha 10/08/2007 - Cambio Sicc20070361
                                             if (get('frmInsertarCliente.cbTipo')==OID_TIPO_CLIENTE_HIJADUPLA && get('frmInsertarCliente.cbSTipo')==OID_SUBTIPO_CLIENTE_HIJADUPLA)
                                             {
                                                      nuevaFila[3] = get("frmInsertarCliente.hidFechaIngreso");
             nuevaFila[4] = "";
                                                      //	Validacion que debe permitir un solo vinculo de DuplaCyzone
                                                      if (listado1.datos.length>1)
                                                      {
                                                                GestionarMensaje('MAE0044');
                                                                return;
                                                      }
                                             }
                                             else
                                             {
             // vbongiov -- SiCC20070455 MAE -- 11/12/2007             
                                                      nuevaFila[3] = get("frmInsertarCliente.hidFechaIngreso");
             nuevaFila[4] = get("frmInsertarCliente.hidFechaHasta");
                                             }
                   
                      nuevaFila[5] = "";
                      /*nuevaFila[6] = "N";*/
    
                                             //alert(listado1.tiposCol[0]);
                                             listado1.insertar(nuevaFila,true);
                                             listado1.repinta();
                                             //document.getElementById("TextoClienteVinculo_0").focus();
                      document.getElementById("TextoClienteVinculo_"+Math.abs(listado1.datos.length - 1)).focus();
                                             var ctexto = "TextoClienteVinculo_" + Math.abs(listado1.datos.length - 1);
                                             // alert(document.all['TextoClienteVinculo_0'].maxlength); 
                                             //accion('frmInsertarCliente.' + ctexto, '.maxLength=' + document.all.hidlongCliente.value);

                                             //	Agregado por HRCS - Fecha 04/04/2006 - Incidencia Sicc20070184
                                             seteaVinculoPorTipoCliente();
                      return;
                      //agregarOnChangeVinculoPrincipal();
           }else if (nombreLista == "listado2" ){
                      if (oid != ""){    // Se genera una fila nueva con el oid especificado
                                  nuevaFila[0] = oid;
                      }else{
                                  nuevaFila[0] = "g";
                      }
                      nuevaFila[1] = "";
                      nuevaFila[2] = "";
                      listado2.insertar(nuevaFila);
                         document.getElementById("comboTipoPreferencia_" + Math.abs(listado2.datos.length - 1)).focus();
           }else  if (nombreLista == "listado3" ){          
              if (oid != ""){    // Se genera una fila nueva con el oid especificado
                           nuevaFila[0] = oid;
              }else{
                           nuevaFila[0] = "g";
              }
              nuevaFila[1] = "";
              nuevaFila[2] = listado3.datos.length + 1;
              nuevaFila[3] = "";
              //  alert("agregando");
              listado3.insertar(nuevaFila);
             document.getElementById("comboMarca_" + Math.abs(listado3.datos.length - 1)).focus();
              //  alert("agregado");
           }
} 
//---------------------------------------------------------------------------------------------------------------------
function seleccionarClienteContactado() 
{
           var obj = new Object();
           var whnd = mostrarModalSICC('LPBusquedaRapidaCliente','',obj);
           if(whnd!=null){
                                 var cod = whnd[1];
                                 set("frmInsertarCliente.textCodClienteContactado", cod);
           }
}
//---------------------------------------------------------------------------------------------------------------------
function parsingLista1(param)
{
           //alert("param Lista1: " + param);
           var elemen=new String(param);
           var cadenas = new Array();
           var subCadenas = new Array();
           var index=0;
           var k=0;
           //********************************************

           cadenas = elemen.split("|" );
           index = cadenas.length;

           for (var i = 0; i < cadenas.length; i++){
                      subCadenas[i] = cadenas[i].split(";");
           }
           var datosLista = new Array();
           for(var y=0; y<subCadenas.length; y++){
                      //alert("subCadenas[]: " + subCadenas[y] );
                      var buffer = "";

                      var arrayBuffer = new Array();
                      for (var z = 0; z < subCadenas[y].length; z++)
                      {
                                  buffer = subCadenas[y][z];
                                  buffer = buffer.split("=");
                                  arrayBuffer[z] = buffer[1];
/*                                if ( z != (subCadenas[y].length - 1) ){
                                              arrayBuffer[z] = buffer[1];
                                  } else{   // True o False. Setea 1 o 0. 
                                              //alert("T o F: " + buffer[1]);
                                              if (buffer[1] == "true"){
                                                          arrayBuffer[z] = 'S';
                                              }else{
                                                          arrayBuffer[z] = 'N';
                                              } 
                                  }*/
                      }
                      ////alert("********* arrayBuffer: " + arrayBuffer);
                      datosLista[y] = arrayBuffer;
                      ////alert("datosLista en bulce " + y + ": " + datosLista);
           }
           ////alert(" ----------------------- datosLista: " + datosLista);
           listado1.setDatos(datosLista);
           listado1.repintaDat();
}
//---------------------------------------------------------------------------------------------------------------------
function parsingLista2(param)
{
           //alert("param: " + param);
           var elemen=new String(param);
           var cadenas = new Array();
           var subCadenas = new Array();
           var index=0;
           var k=0;
           //********************************************
           cadenas = elemen.split("|" );
           index = cadenas.length;

           for (var i = 0; i < cadenas.length; i++){
                      subCadenas[i] = cadenas[i].split(";");
           }
           var datosLista = new Array();
           for(var y=0; y<subCadenas.length; y++){
                      ////alert("subCadenas[" + y + "]: " + subCadenas[y] );
                      var buffer = "";
                      ////alert("long. de subcadena: " + subCadenas[y].length );
                      var arrayBuffer = new Array();
                      for (var z = 0; z < subCadenas[y].length; z++){
                                  ////alert("z: " + z + " - buffer: " + buffer);
                                  buffer = subCadenas[y][z];
                                  buffer = buffer.split("=");
                                  arrayBuffer[z] = buffer[1];
                      }
                      ////alert("********* arrayBuffer: " + arrayBuffer);
                      datosLista[y] = arrayBuffer;
           }
           //alert(" ----------------------- datosLista: " + datosLista);
           listado2.setDatos(datosLista);
           listado2.repintaDat();

}
//---------------------------------------------------------------------------------------------------------------------
function parsingListaObservaciones(param)
{

           //alert("param Observaciones: " + param); 
           var elemen=new String(param);
           var cadenas = new Array();
           var subCadenas = new Array();
           var index=0;
           var k=0;

           cadenas = elemen.split("|");
           index = cadenas.length;

           for (var i = 0; i < cadenas.length; i++){
                      subCadenas[i] = cadenas[i].split(";");
                     }

           var listaDatos = new Array();

           for(var y=0; y< subCadenas.length; y++)
           {
                      var arrayBuffer = new Array();

                      // oid
                      var buffer = subCadenas[y][0];
                      buffer = buffer.split("=");
                      arrayBuffer[0] = buffer[1];

                      // marca
                      var buffer = subCadenas[y][1];
                      buffer = buffer.split("=");
                      arrayBuffer[1] = buffer[1];

                      // numero observacion
                      var buffer = subCadenas[y][2];
                      buffer = buffer.split("=");
                      arrayBuffer[2] = buffer[1];

                      // texto
                      var buffer = subCadenas[y][3];
                      buffer = buffer.split("=");
                      arrayBuffer[3] = buffer[1];

              listaDatos[y] = arrayBuffer;
  }
 

           listado3.setDatos(listaDatos );
}   

//---------------------------------------------------------------------------------------------------------------------
function eliminarSelecc(listado)
{
           if (listado == "listado1"){
                      // Si es uno de las filas que vinieron de la base, guardar para despues notificarle al MON 
                      // que debe dar de baja. Para determinar si es una recien agregada, o una de la base, 
                      // se chequea si el oid (campo oculto) es igual a "g". Si es así, fue agregada por el usuario en el momento.

                      var elemToDel = devuelveCodigosEliminados("listado1");

                      if(!listado1.numSelecc() == 0){         
                                  if (elemToDel != ""){
                                              var buffer = get("frmInsertarCliente.elementosEliminadosVincu");
                                              //alert("Elementos eliminados de Vinculos, antes: " + buffer);
                                              if (buffer != 0)
                                                          buffer = buffer + "," + elemToDel;
                                              else
                                                          buffer = elemToDel;
                                              //alert("Elementos eliminados de Vinculos, despues: " + buffer);
                                              set("frmInsertarCliente.elementosEliminadosVincu", buffer);
                                  }
                                  listado1.eliminarSelecc();
                                  //set("frmInsertarCliente.elementosEliminadosVincu", elemToDel);

                      }else{
                                  GestionarMensaje("50");
                      }      
                      //agregarFilaListado1();
                                             deshabilitarFechaHastaVinculo();	// Agregado por HRCS - Fecha 22/08/2007 - Cambio Sicc20070361

           }else   if (listado == "listado2"){
                                var elemToDel = devuelveCodigosEliminados("listado2");

                                if(!listado2.numSelecc() == 0){    
                                                   if (elemToDel != ""){
                                                        var buffer = get("frmInsertarCliente.elementosEliminadosPrefe");

                                                        if (buffer != 0){
                                                                 buffer = buffer + "," + elemToDel;
                                                        }else{
                                                                 buffer = elemToDel;
                                                        }
                                                        set("frmInsertarCliente.elementosEliminadosPrefe", buffer);
                                                   }
                                                   listado2.eliminarSelecc();
                                                   //set("frmInsertarCliente.elementosEliminadosPrefe", elemToDel);
                                }else{
                                          GestionarMensaje("50");
                                }
                    }else if (listado == "listado3"){
              var elemToDel = devuelveCodigosEliminados("listado3");
                              if(!listado3.numSelecc() == 0){      
                   if(listado3.codSeleccionados().length!=0)
                           {
                                         if (elemToDel != "")
                                                   {
                                                                         var buffer = get("frmInsertarCliente.elementosEliminadosObser");
                                                                           //alert("Elementos eliminados de Observaciones, antes: " + buffer);
                                                                           if (buffer != 0)
                                                                                      buffer = buffer + "," + elemToDel;
                                                                           else
                                                                                      buffer = elemToDel;

                                                                           //alert("Elementos eliminados de Observaciones, despues: " + buffer);
                                                                           set("frmInsertarCliente.elementosEliminadosObser", buffer);
                                                   }
 
                                  listado3.eliminarSelecc();
                                         //set("frmInsertarCliente.elementosEliminadosObser", elemToDel);
                                         listado3.actualizaDat();
                                           renumerarObservacion();
                           }
                              }else{
                                         GestionarMensaje("50");
                     
                              }
         }
}


//---------------------------------------------------------------------------------------------------------------------
function validaFechaVinculos(){
/*Gracias a Dios que Santana fue a hacer codigo basura a otro lado*/
         var fechaDesde;
         var fechaHasta; 
         var continuar; 

         listado1.actualizaDat(); // Me aseguro que los datos coincidan con lo que se muestra en pantalla. 
         var datosLista = listado1.datos;

         continuar = true;
         var i = 0;
         var formatoFecha = get("frmInsertarCliente.hFormatoFechaPais");

         while( i < datosLista.length && continuar == true){
                  fechaDesde = datosLista[i][3];
                  fechaHasta = datosLista[i][4];

                  listado1.preparaCamposDR();

                  //	Agregado por HRCS - Fecha 14/08/2007 - Cambio Sicc20070361
                  if (get('frmInsertarCliente.cbTipo')==OID_TIPO_CLIENTE_HIJADUPLA && get('frmInsertarCliente.cbSTipo')==OID_SUBTIPO_CLIENTE_HIJADUPLA)	{

                           var errorLevel = EsFechaValida_SICC(fechaDesde, "frmInsertarCliente");
                           if ( errorLevel == 0 )	{
                              GestionarMensaje("1006", formatoFecha, null, null);
                                    //alert("Fecha Desde de Vinculo inválida. El formato debe ser " + formatoFecha);
                                    continuar = false;
                                    focaliza("frmlistado1.TextoFechaDesde_"+ i, "");
                           }
                  }
                  else	{	//	En caso no sea Hija Dupla, continua procesando como antes:
                           
                           var errorLevel = EsFechaValida( fechaDesde, fechaHasta, "frmInsertarCliente", "S");
                           
                           if ( errorLevel == 1 ){
                              GestionarMensaje("1006", formatoFecha, null, null);
                                    //alert("Fecha Desde de Vinculo inválida. El formato debe ser " + formatoFecha);
                                    continuar = false;
                                    focaliza("frmlistado1.TextoFechaDesde_"+ i, "");
                           }
                           
                           if ( errorLevel == 2 ){
                              GestionarMensaje("1006", formatoFecha, null, null);
                              //alert("Fecha Hasta de Vinculo inválida. El formato debe ser " + formatoFecha);
                              continuar = false;
                              focaliza("frmlistado1.TextoFechaHasta_"+ i, "");
                           }

                           if ( errorLevel == 3){
                              GestionarMensaje("1191");
                                    //alert("Fecha Desde VInculo es mayor que Fecha Hasta Vinculo");
                              continuar = false;
                              focaliza("frmlistado1.TextoFechaDesde_"+ i, "");
                           }
      
      // vbongiov -- SiCC20070455 MAE -- 11/12/2007
      if(EsFechaValida( fechaDesde, get("frmInsertarCliente.hidFechaIngreso"), "frmInsertarCliente", "N")){
           GestionarMensaje("2613");
                                    //alert("Fecha Desde VInculo es mayor que Fecha Hasta Vinculo");
                              continuar = false;
                              focaliza("frmlistado1.TextoFechaDesde_"+ i, "");
      }
                  }

             i++;
   }
   return continuar; // True si no se encontro error. 

}
//---------------------------------------------------------------------------------------------------------------------
function validaFechaPedidos()
{
           var hayError = true;
           var fechaPedidoD = get("frmInsertarCliente.textFecha1PedidoContacto");
           var fechaPedidoH = get("frmInsertarCliente.textFechaSiguienteContacto");

           var formatoFecha = get("frmInsertarCliente.hFormatoFechaPais");

           var errorLevel = EsFechaValida( fechaPedidoD, fechaPedidoH, "frmInsertarCliente", "S");
           if ( errorLevel == 1 ){
    GestionarMensaje("1006", formatoFecha, null, null);
           //     alert("Fecha Primer Pedido Contacto inválida. El formato debe ser " + formatoFecha);
                      hayError = false;
                      focaliza("frmInsertarCliente.textFecha1PedidoContacto", "");
           }

           if ( errorLevel == 2 ){
    GestionarMensaje("1006", formatoFecha, null, null);
                      //alert("Fecha Siguiente Pedido Contacto inválida. El formato debe ser " + formatoFecha);
                      hayError = false;
                      focaliza("frmInsertarCliente.textFechaSiguienteContacto", "");
           }

           if ( errorLevel == 3){
    GestionarMensaje("1216");
                      //alert("Fecha Primer Pedido Contacto es mayor que Fecha de Siguiente Pedido de Contacto");
                      hayError = false;
                      focaliza("frmInsertarCliente.textFecha1PedidoContacto", "");
           }
           ////alert("Sale de validaFechaPedidos");
           return hayError;
}  

//---------------------------------------------------------------------------------------------------------------------
function validaFechaContacto()
{
           var hayError = true;
           var fechaPedidoD = get("frmInsertarCliente.textFechaContacto");
           var fechaPedidoH = get("frmInsertarCliente.textFechaSiguienteContacto");

           var formatoFecha = get("frmInsertarCliente.hFormatoFechaPais");

           var errorLevel = EsFechaValida( fechaPedidoD, fechaPedidoH, "frmInsertarCliente", "S");
           if ( errorLevel == 1 )
           {
    GestionarMensaje("1006", formatoFecha, null, null);
           //     alert("Fecha Primer Pedido Contacto inválida. El formato debe ser " + formatoFecha);
                      hayError = false;
                      focaliza("frmInsertarCliente.textFechaContacto", "");
           }

           if ( errorLevel == 2 )
           {
    GestionarMensaje("1006", formatoFecha, null, null);
                      //alert("Fecha Siguiente Pedido Contacto inválida. El formato debe ser " + formatoFecha);
                      hayError = false;
                      focaliza("frmInsertarCliente.textFechaSiguienteContacto", "");
           }

           if ( errorLevel == 3)
           {
    GestionarMensaje("1192");
                      //alert("Fecha Contacto es mayor que Fecha de Siguiente Pedido de Contacto");
                      hayError = false;
                      focaliza("frmInsertarCliente.textFechaContacto", "");
           }

           return hayError;


}

//---------------------------------------------------------------------------------------------------------------------
function seteaCamposModificables(){
           var camposMod = get("frmInsertarCliente.modificabilidad");

           if (camposMod != "") {
                    camposMod = camposMod.split(",");
                    var cantElems = camposMod.length;
                    for (var i = 0; i < cantElems; i++){
                        accion("frmInsertarCliente." + camposMod[i], ".disabled=true");
                    }
           }
                      
}
//---------------------------------------------------------------------------------------------------------------------
           function cambiaChecks( filaCambiada )
           {
                                  
            // Primero deselecciono todos los check
                                  listado1.actualizaDat();
                                  var listadoDatos = listado1.datos;
                                  var cantCodigos = listado1.codigos().length;

                                  listado1.actualizaDat();

                                  for ( var i = 0; i < cantCodigos; i++)
                                  {
                                                          if ( i != filaCambiada)
                                                                     listadoDatos[i][5] = "N";                                          
                                  }
                                  listado1.setDatos(listadoDatos); 
                                  
           }
//---------------------------------------------------------------------------------------------------------------------
           function validarFormato()
           {
                                  //alert("ValidarFormato");
                                  var formatoFecha = get("frmInsertarCliente.hFormatoFechaPais");
                                  var valido = true;
                                  var permitidos = "0123456789";
                                  var nroHijos = get("frmInsertarCliente.textNHijos");
                                  var nroPersonasDep = get("frmInsertarCliente.textNPersonasDependientes");
                                  var fechaNacimiento = get("frmInsertarCliente.textFechaNacimiento");
                                  var fechaContacto = get("frmInsertarCliente.textFechaContacto");
                                  var fecha1PedidoContacto = get("frmInsertarCliente.textFecha1PedidoContacto");
                                  var fechaSigContacto = get("frmInsertarCliente.textFechaSiguienteContacto");
                                                                     
                                  var fechaDesdeVincu = get("frmInsertarCliente.textFechaD");
                                  var fechaHastaVincu = get("frmInsertarCliente.textFechaH");
                                  var fechaIngreso = get("frmInsertarCliente.txtFechaIngresoActual");

                                  // Valida Fecha Ingreso
                                  if ( fechaIngreso  != "")
                                  {
                                              if (! EsFechaValida_SICC(fechaIngreso , "frmInsertarCliente") )
                                              {
                                                          GestionarMensaje("1006", formatoFecha, null, null);
                                                          focaliza("frmInsertarCliente.txtFechaIngresoActual");
                                                          return false;
                                              }
                                  }

                                  // Valida que Nro de Hijos sea numerico. 
                                  if (nroHijos != "")
                                  {
                                              valido = validar(nroHijos, permitidos);
                                              if (valido == false)
                                              {
                                                          focaliza("frmInsertarCliente.textNHijos");
                                                          cdos_mostrarAlert(GestionarMensaje("000000000000100", GestionarMensaje("1516", null, null, null), null, null) );
                                                          return valido;
                                              }
                                  }

                                  // Valida que Nro de Personas Dependientes sea numerico.
                                  if  (nroPersonasDep != "")
                                  {
                                              valido = validar(nroPersonasDep, permitidos);
                                              if (valido == false)
                                              {
                                                          focaliza("frmInsertarCliente.textNPersonasDependientes");
                                                          cdos_mostrarAlert( GestionarMensaje("000000000000100", GestionarMensaje("1517", null, null, null), null, null) );
                                                          return valido;
                                              }
                                  }

                                  // Valida formato de Fecha de Nacimiento
                                  if  (fechaNacimiento != "")
                                  {
                                              if ( ! EsFechaValida_SICC(fechaNacimiento, "frmInsertarCliente") )
                                              {
                                                          ////alert("La fecha es inválida. Fecha Nacimiento debe tener el formato " + get("frmInsertarCliente.hFormatoFechaPais"));
                                                   GestionarMensaje("1006", formatoFecha, null, null);
                                                          focaliza("frmInsertarCliente.textFechaNacimiento");
                                                          return false;
                                              }
                                  }

                                  // Valida Fecha Desde Vinculos 
                                  if ( fechaDesdeVincu  != "")
                                  {
                                              if (! EsFechaValida_SICC(fechaDesdeVincu , "frmInsertarCliente") )
                                              {
                                                          GestionarMensaje("1006", formatoFecha, null, null);
                                                          focaliza("frmInsertarCliente.textFechaD");
                                                          return false;
                                              }
                                  }

                                  // Valida Fecha Hasta Vinculos
                                  if ( fechaHastaVincu  != "")
                                  {
                                              if (! EsFechaValida_SICC(fechaHastaVincu , "frmInsertarCliente") )
                                              {
                                                          GestionarMensaje("1006", formatoFecha, null, null);
                                                          focaliza("frmInsertarCliente.textFechaH");
                                                          return false;
                                              }
                                  }

                //alert(fechaContacto);
                                  // Valida Fecha Contacto 
                                  if ( fechaContacto != "")
                                  {
                                              if (! EsFechaValida_SICC(fechaContacto, "frmInsertarCliente") )
                                              {
                                                   GestionarMensaje("1006", formatoFecha, null, null);
                                                          focaliza("frmInsertarCliente.textFechaContacto");
                                                          return false;
                                              }
                                  }

                                  // Valida Fecha 1er PedidoContacto
                                  if ( fecha1PedidoContacto  != "")
                                  {
                                              if (! EsFechaValida_SICC(fecha1PedidoContacto , "frmInsertarCliente") )
                                              {
                                                          ////alert("La fecha es inválida. Fecha 1 Pedido Contacto debe tener el formato " + get("frmInsertarCliente.hFormatoFechaPais"));
                                                          GestionarMensaje("1006", formatoFecha, null, null);
                                                          focaliza("frmInsertarCliente.textFecha1PedidoContacto");
                                                          return false;
                                              }
                                  }

                                  // Valida FechaSiguiente Contacto
                                  if ( fechaSigContacto != "")
                                  {
                                              if (! EsFechaValida_SICC(fechaSigContacto, "frmInsertarCliente") )
                                              {
                                                          ////alert("La fecha es inválida. Fecha Sig. Contacto debe tener el formato " + get("frmInsertarCliente.hFormatoFechaPais"));
                                                          GestionarMensaje("1006", formatoFecha, null, null);
                                                          focaliza("frmInsertarCliente.textFechaSiguienteContacto");
                                                          return false;
                                              }
                                  }

                                  // Valida que fecha de contacto sea menor que fecha sig. contacto (si ambas son != "")
                                  // Ya se validó el formato mas arriba, se valida rango (formato no se tiene en cuenta acá)
                                  if ( fechaContacto != "" && fechaSigContacto != "")
                                  {
                                                var retorno = EsFechaValida(fechaContacto, fechaSigContacto, "frmInsertarCliente", "S");
                                                if (retorno == 3)  // Desde mayor que hasta
                                                {
                                                           GestionarMensaje("1414");
                                                           return false;
                                                } 
                                  }




                      return valido;
           }
           //---------------------------------------------------------------------------------------------------------------------
           function validar(valor, caracteres)
           {
                      var permitidos = caracteres;
                      var c;

                      for(var i=0; i<valor.length; i++) 
                      {
                                              c = valor.charAt(i);
                                              if (permitidos.indexOf(c) == -1 ) 
                                                          return false;
                      }
                      return true;
           }
           //---------------------------------------------------------------------------------------------------------------------
           function agregarFilaListado1()
           {
                                  // En caso que no haya ningun elemento, agrega una fila.
                                  var codigosLista1 = listado1.codigos();
                                  if (codigosLista1.length == 0)
                                  {
                                                                     var nuevaFila = new Array();
                                                                     nuevaFila[0] = "g";
                                                                     //nuevaFila[0] = "g" + listado1.datos.length
                                                                     nuevaFila[1] = "";
                                                                     nuevaFila[2] = "";
                                                                     nuevaFila[3] = "";
                                                                     nuevaFila[4] = "";
                                                                     nuevaFila[5] = "";
                                                                     nuevaFila[6] = "N";

                                                                     listado1.insertar(nuevaFila);
                                              }
           }
           //---------------------------------------------------------------------------------------------------------------------
           function devuelveCodigosEliminados(nombreLista)
           {
                                  // Funcion que devuelve los codigos de las listas eliminados, siempre y cuando no sean 
                                  // "g" (ya que se usa para denotar una fila generada por el usuario. 
                                  // Las filas traídas de la base van a tener un codigo numérico siempre ya que corresponde con el Oid. 
                                  // Estos codigos se usan luego para indicarle al MON qué tuplas hay que dar de baja. 

                                  var codigos = eval(nombreLista + ".codSeleccionados()");
                                  var elemAEliminar = new Array();
                                  var j = 0;

                                  //alert("codigos: " + codigos);

                                  for (var i = 0; i < codigos.length; i++)
                                  {
                                              if ( codigos[i] != "g")
                                              {
                                                          elemAEliminar[j] = codigos[i];
                                                          j++;
                                              }
                                  }
                                  
                                  return elemAEliminar;

           }
//---------------------------------------------------------------------------------------------------------------------


function buscarClienteVinculo()
{

                      // ***** Llama al subistema de carga rapida de clientes. Solo debe dejar cuando hay seleccionada 1 fila

                      //var codigosSelec = listado1.codSeleccionados();
                      var codigosSelec = listado1.numSelecc();
                      //alert("Cant Elem. Seleccionados: " + codigosSelec);


                      //alert("codigosSelec = " + codigosSelec + " | codigosSelec.length = " + codigosSelec.length);
                      //if (codigosSelec.length == 0)
                      if (parseInt(codigosSelec,10) == 0)
                      {
                                              GestionarMensaje("4", null, null, null);
                                              //alert("Debe seleccionar un elemento");
                      }
                      else if ( parseInt(codigosSelec,10) > 1)
                      {
                                              GestionarMensaje("240", null, null, null);
                                              //alert("Debe seleccionar solo UN elemento");

                      }
                      else
                      {
                                              var indiceFilaSeleccionada = listado1.filaSelecc;
                                              //alert("listado1.  filaSelecc: " + listado1.filaSelecc);
                                              
                                              var obj = new Object();

                                              var whnd = mostrarModalSICC('LPBusquedaRapidaCliente','',obj);
                                              if(whnd==null){
                                                                                   ////alert("result == null");
                                              }else{
                                                                     
                                                                                   var cod = whnd[1];
                                                                                   listado1.datos[indiceFilaSeleccionada][1] = cod;
                                                                                   listado1.repintaDat();
                                              }                                  

                      }


}

//------------------------------------------------------------------------------
function recargarObservacion(){
            var listaObse = get( formName + ".hidListaObservacion");
            // limpio lista
            //comboMarca_0=1;comboMarca_1=7;AreaTxtTexto_0=marca1;AreaTxtTexto_1=marca7;··
           listado3.datos= new Array();
           //alert(listaObse);
           var lineasParaAgregar = new Array();
           var linea = listaObse.split(";");
           for(var f=0;f<linea.length;f++){
                      var elems = linea[f].split("=");
                      //elems[0] = comboMarca_0
                      //elems[1] = 1
                      var tempArray = elems[0].split("_");
                      //tempArray[0] = comboMarca
                      //tempArray[1] = 0    -> indice 
                      var ind= Math.abs(tempArray[1]);

                      if(lineasParaAgregar[ind]==null){
                                  lineasParaAgregar[ind] = new Array(4);
                                  lineasParaAgregar[ind][0] = "codigo"; 
                                  lineasParaAgregar[ind][1] = "-1"; 
                                  lineasParaAgregar[ind][2] = " "; 
                      }
                      if(tempArray[0]=="comboMarca"){
                                  lineasParaAgregar[ind][1] = elems[1] ;
                      }else if(tempArray[0]=="AreaTxtTexto"){
                                  lineasParaAgregar[ind][3] = elems[1] ;
                      }
           }

           for(var ff=0;ff<lineasParaAgregar.length;ff++){
                      //alert(lineasParaAgregar[ff]);
                      listado3.insertar(lineasParaAgregar[ff],true);
           }
                     listado3.repinta();
           renumerarObservacion();
}
//------------------------------------------------------------------------------
function recargarPreferencias(){
            var listaprefe = get( formName + ".hidListaPrefe");
            // limpio lista
           listado2.datos= new Array();
//      alert(listaprefe);
           var lineasParaAgregar = new Array();
           var linea = listaprefe.split(";");
           for(var f=0;f<linea.length;f++){
                      var elems = linea[f].split("=");
                      //elems[0] = TextoDescripcion_0
                      //elems[1] = 000000000000003
                      var tempArray = elems[0].split("_");
                      //tempArray[0] = TextoDescripcion
                      //tempArray[1] = 0    -> indice 
                      var ind= Math.abs(tempArray[1]);

                      if(lineasParaAgregar[ind]==null){
                                  lineasParaAgregar[ind] = new Array(3);
                                  lineasParaAgregar[ind][1] = "-1";
                                  lineasParaAgregar[ind][2]  = "";
                                  lineasParaAgregar[ind][0] = "codigo"; 
                      }
                      if(tempArray[0]=="comboTipoPreferencia"){
                                  lineasParaAgregar[ind][1] = elems[1] ;
                      }else if(tempArray[0]=="TextoDescripcion"){
                                  lineasParaAgregar[ind][2] = elems[1] ;
                      }
           }

           for(var ff=0;ff<lineasParaAgregar.length;ff++){
                      //alert(lineasParaAgregar[ff]);
                      listado2.insertar(lineasParaAgregar[ff],true);
           }
                     listado2.repinta();

}
//------------------------------------------------------------------------------
function recargarVinculos()
{
            var listavinculos = get( formName + ".hidListaVinculo");
            // limpio lista
           listado1.datos= new Array();
           //alert(listavinculos);
           var lineasParaAgregar = new Array();
           var linea = listavinculos.split(";");
           for(var f=0;f<linea.length;f++)
           {
                      var elems = linea[f].split("=");
                      //elems[0] = TextoClienteVinculo_0
                      //elems[1] = 000000000000003
                      var tempArray = elems[0].split("_");
                      //tempArray[0] = TextoClienteVinculo
                      //tempArray[1] = 0    -> indice 
                      var ind= Math.abs(tempArray[1]);

                      if(lineasParaAgregar[ind]==null){
                                  lineasParaAgregar[ind] = new Array(7);
                                  lineasParaAgregar[ind][0] = "codigo"; 
                                  lineasParaAgregar[ind][1] = "";
                                  lineasParaAgregar[ind][2] = "-1";
                                  lineasParaAgregar[ind][3] = "";
                                  lineasParaAgregar[ind][4] = "";
                                  lineasParaAgregar[ind][5] = "N";
                                  lineasParaAgregar[ind][6] = "";
                      }
                      
                      if(tempArray[0]=="TextoClienteVinculo"){
                                  lineasParaAgregar[ind][1] = elems[1] ;
                      }else if(tempArray[0]=="comboTipoVinculo"){
                                  lineasParaAgregar[ind][2] = elems[1] ;
                      }else if(tempArray[0]=="TextoFechaDesde"){
                                  lineasParaAgregar[ind][3] = elems[1] ;                             
                      }else if(tempArray[0]=="TextoFechaHasta"){
                                  lineasParaAgregar[ind][4] = elems[1] ;                             
                      }else  if(tempArray[0]=="CKVinculoPrincipal"){
                                  if(elems[1] =="true"){
                                              lineasParaAgregar[ind][5] ="S";                           
                                  }
                      }
                      //_0=000000000000003;TextoFechaDesde_0=12/12/2000;TextoFechaHasta_0=12/12/2001;comboTipoVinculo_0=1;··
           }
           for(var ff=0;ff<lineasParaAgregar.length;ff++){
                      //alert(lineasParaAgregar[ff]);
                      // vbongiov -- 21/12/2007
                      listado1.insertar(lineasParaAgregar[ff]);
           }
           
}

 function foco(){
            var foco = get('frmInsertarCliente.hidFocusPrimerComponente');
            
            if(foco == 'false'){
                focalizaBotonHTML('botonContenido','btnSiguiente');
            }else{
                var campos = new Array();
                var flag = false;
                campos[0] = 'textApellido1';
                campos[1] = 'textApellido2';
                campos[2] = 'textApellidoCasada';
                campos[3] = 'textNombre1';
                campos[4] = 'textNombre2';
                campos[5] = 'cbTratamiento';
                campos[6] = 'rbSexo';
                campos[7] = 'cbFormaPago';
                
                

                for(var i=0;i<campos.length;i++){

                    try{
                        focaliza('frmInsertarCliente.' + campos[i]);
                        flag = true;
                        break;
                    }catch (exception){
                     
                    }
                }

                if(flag == false){
                    focalizaBotonHTML('botonContenido','btnSiguiente');
                }
             
            }
      }


//-------------------------------------------------------------------------------
function focalizaProximoDesdeImporte(){
           if(listado1.datos.length>0){
                      document.getElementById("TextoClienteVinculo_0").focus();
                      return;
           }
           document.getElementById("masDatos1").focus();

}
//-------------------------------------------------------------------------------

function fVolver()
{
                      //if ( get("frmInsertarCliente.casoDeUso") == "ModificarCliente") 
                      //{
                                  window.close();
                         //         return;
                      //}
}

// -------------------------------------------------------------------------------
function duplicaArray(param)
{
           var valorToReturn = new Array();
           if ( param != "")
           {
                      var cantFilas = param.length;
                      var cantCols = param[0].length;

                      for (var i = 0; i < cantFilas; i++)
                      {
                                  var nuevaFila = new Array();
                                  for (var j = 0; j < cantCols; j++)
                                  {    
                                              var dato = param[i][j];
                                              nuevaFila[j] = dato;
                                  }
                                  valorToReturn[i] = nuevaFila;
                      }
           }
           return valorToReturn;

}

// -------------------------------------------------------------------------------
function seteaVarsLimpiar()
{
           // Llena las variables de listas (variables de jscript globales) que se usan para el limpiar (para inc. 4904)
           // by ssantana

           listaVincuLimpiar = duplicaArray(listado1.datos);
           listaPrefLimpiar = duplicaArray(listado2.datos);
           listaObservLimpiar = duplicaArray(listado3.datos);

           ape1Limpiar = get("frmInsertarCliente.textApellido1");
           ape2Limpiar = get("frmInsertarCliente.textApellido2");
           nom1Limpiar = get("frmInsertarCliente.textNombre1");
           nom2Limpiar = get("frmInsertarCliente.textNombre2");
           apeCasadaLimpiar = get("frmInsertarCliente.textApellidoCasada");
           tratamientoLimpiar = get("frmInsertarCliente.cbTratamiento");
           sexoLimpiar = get("frmInsertarCliente.rbSexo");
           formaPagoLimpiar = get("frmInsertarCliente.cbFormaPago");
           fechaNacimientoLimpiar = get("frmInsertarCliente.textFechaNacimiento");
           codEmpleadoLimpiar = get("frmInsertarCliente.textCodEmpleado");
           nacionalidadLimpiar = get("frmInsertarCliente.cbNacionalidad");
           estadoCivilLimpiar = get("frmInsertarCliente.cbEstadoCivil");
           ocupacionLimpiar = get("frmInsertarCliente.textOcupacion");
           profesionLimpiar = get("frmInsertarCliente.textProfesion");
           centroLimpiar = get("frmInsertarCliente.textCentroTrabajo");
           cargoLimpiar = get("frmInsertarCliente.textCargoDesempena");
           nivelEstudiosLimpiar = get("frmInsertarCliente.cbNivelEstudios");
           centroEstudiosLimpiar = get("frmInsertarCliente.textCentroEstudios");
           nHijosLimpiar = get("frmInsertarCliente.textNHijos");
           nPersonasDepLimpiar = get("frmInsertarCliente.textNPersonasDependientes");
           NSELimpiar = get("frmInsertarCliente.cbNivelSocioEconomico");
           cicloFamiliarLimpiar = get("frmInsertarCliente.cbCicloVidaFamiliar");
           correspLimpiar = get("frmInsertarCliente.rbDeseaCorrespondencia");
           importeIngresoLimpiar = get("frmInsertarCliente.textImporteIngresoFamiliar");
           codCContactadoLimpiar = get("frmInsertarCliente.textCodClienteContactado");
           tipoCContactadoLimpiar = get("frmInsertarCliente.cbTipoClienteContactado");
           codTipoContactoLimpiar = get("frmInsertarCliente.cbCodTipoContactado");   // Inbound-Outbound
           fechaContactoLimpiar = get("frmInsertarCliente.textFechaContacto");
           fechaPrimerPedidoLimpiar = get("frmInsertarCliente.textFecha1PedidoContacto");
           fechaSigContactoLimpiar = get("frmInsertarCliente.textFechaSiguienteContacto");


}

// ----------------------------------------------------------------------------------------------------------------------------------------
function cambiarPeriodoContacto(reentrando)
{
           // Llamada cuando se cambia el valor de Marca o Canal (en Contacto),
           // o en el Onload (en cuyo caso reentrando debe ser = "reentrando").
           var marcaContacto = get("frmInsertarCliente.cbMarca");
           var canalContacto = get("frmInsertarCliente.cbCanal");
           var pais = get("frmInsertarCliente.paisUsuario");;
           var idioma = get("frmInsertarCliente.idiomaUsuario");

           //alert("marca: " + marcaContacto);
           //alert("canal: " + canalContacto);

           //alert("cambiar");

           if ( marcaContacto != "" && canalContacto != "")
           {
                      var array = armaArrayPeriodo(idioma, pais, marcaContacto, canalContacto);
                      
                      //alert("array: " + array);
                      if( reentrando == "pordefecto") {
                           recargaCombo('frmInsertarCliente.cbPeriodoPrimerPedido', 'MAEBuscarPeriodos', 'es.indra.sicc.dtos.mae.DTOBusquedaPeriodos', array, 'periodoDefecto(datos);' );
                             }  
                      else {
                         if ( reentrando != "reentrando")
                                  recargaCombo('frmInsertarCliente.cbPeriodoPrimerPedido', 'MAEBuscarPeriodos', 'es.indra.sicc.dtos.mae.DTOBusquedaPeriodos', array);
                         else
                                  recargaCombo('frmInsertarCliente.cbPeriodoPrimerPedido', 'MAEBuscarPeriodos', 'es.indra.sicc.dtos.mae.DTOBusquedaPeriodos', array, 'cargaPeriodoContacto(datos);' );
                      }            
           }



}

// ----------------------------------------------------------------------------------------------------------------------------------------
function armaArrayPeriodo(idioma, pais, marca, canal)
{

           var array = new Array();

           array[0] = ["oidIdioma", idioma]; 
           array[1] = ["oidPais", pais]; 
           array[2] = ["marca", marca];
           array[3] = ["canal", canal];

           //alert("Array: " + array);

           return array;

}

// ----------------------------------------------------------------------------------------------------------------------------------------
function cargaPeriodoContacto(datos)
{
           var periodo = get("frmInsertarCliente.hidPeriodoContacto");
           //alert("periodo Seleccionado: " + periodo);

           // Setea espacio en blanco.
           var datosNuevo = new Array();
           datosNuevo[0] = ["",""];

           for (var i = 0; i < datos.length; i++ ){
                      datosNuevo[i+1]  = datos[i];
                     }


           set_combo("frmInsertarCliente.cbPeriodoPrimerPedido", datosNuevo);
           set("frmInsertarCliente.cbPeriodoPrimerPedido", new Array(periodo) );

}

// ----------------------------------------------------------------------------------------------------------------------------------------
function obtieneDescTratamiento()
{
                      var codigo = get("frmInsertarCliente.cbTratamiento");
                      var desc = "";
                      if ( codigo != "")
                                              desc = cargaDesc("cbTratamiento", codigo);
                      
                      return desc;

}

//--------------------------------------------------------------------------------------------------------------------
function cargaDesc(combo, codigo)
{
             var longCombo = combo_get("frmInsertarCliente." + combo, "L", "" );

             var match = true;
             var desc = "";
             for ( var  i = 0; (i < longCombo) && (match==true); i++)
             {
                                  var codigoCombo = combo_get("frmInsertarCliente." + combo, "V", i );
                                  if (parseInt(codigoCombo,10) == parseInt(codigo,10))
                                  {
                                              match = true;
                                              desc = combo_get("frmInsertarCliente." + combo, "T", i );
                                  }
             }

             return desc;

}


// ----------------------------------------------------------------------------------------------------------------------------------------------------
function onshTabCampos(campoV)
{
           var firstCampoFocalizable = get("frmInsertarCliente.campoToFocalizar");
           var camposFocaliza = "textApellido1,textApellido2,textApellidoCasada,textNombre1,textNombre2,cbTratamiento,rbSexo,cbFormaPago,textCodClienteContactado";
           camposFocaliza =  camposFocaliza.split(",");

                      var match = false;

                      // Obtengo el indice del campo campoV en el array camposFocaliza.
                      var i = 0;
                      while ( match == false )
                      {     
                                  if ( camposFocaliza[i] == campoV)
                                              match = true;
                                  else
                                              i++;
                      }

                      var indiceCampoV = i;

                      // Ahora con ese indice voy de indice a 0, en camposFocaliza, tomando el valor del control a
                      // focalizar, y tratando de setear el foco. La primera vez que no tire excepcion (o sea, no entre en el catch)
                      // implica que ese control esta habilitado y por lo tanto sale del bucle. 

                      var campitos = camposFocaliza;
                      var catcheo = true;
                      i = campitos.length;
                      indiceCampoV = indiceCampoV - 1; // empieza con el campo anterior al actual. 

                      while (catcheo == true && indiceCampoV >= 0)
                      {
                    var valorCampoAFocalizar = camposFocaliza[indiceCampoV];
                                     var deshabilitado = document.getElementById(valorCampoAFocalizar).disabled;
                                     if ( deshabilitado == false)
                                     {
                                                          focaliza("frmInsertarCliente." + valorCampoAFocalizar, "");
                                              catcheo = false;        
                                     } 
                                     indiceCampoV--;
                      }

                      // Si catcheo permanece en true luego del while, entonces se termino el bucle y estaban todos los controles anteriores
                      // a campoV deshabilitados, por lo que campoV tiene que ser el control que focalice el boton Anterior.
                      if ( catcheo )  
                                    focalizaBotonHTML('botonContenido', 'btnAnterior' );

           
           
}

// ----------------------------------------------------------------------------------------------------------------------------------------------------
function ontabBotonAnterior()
{
           // *****************************************************************************************************************************************
           //  Determina cual es el primer control habilitado. Ese control será el que se focaliza al hacer Tab en el boton Anterior.
           // NOTA: Si todos los controles de camposFocaliza están deshabilitados, focalizar en Campo Cod. Cliente Contactado.
           // *****************************************************************************************************************************************

           var camposFocaliza = "textApellido1,textApellido2,textApellidoCasada,textNombre1,textNombre2,cbTratamiento,rbSexo,cbFormaPago";
           camposFocaliza = camposFocaliza.split(",");

           var i = 0; 
           var habilitado = false;
           var campoToFocalizar = "";
           while ( i < camposFocaliza.length && habilitado == false)
           {
                      var valorCampo = camposFocaliza[i];
                var deshabilitado = document.getElementById(valorCampo).disabled;
                      if ( deshabilitado == false ) // Esta habilitado
                      {
                                  campoToFocalizar = valorCampo;
                                  habilitado = true;
                      }
                      i++;
           }

           // Si habilitado esta en false luego del while, entonces todos los campos estaban deshabilitados.
           // Por lo tanto, focaliza en el campo Cod. Cliente Contactado
           if (habilitado == false)
                      focaliza("frmInsertarCliente.textCodClienteContactado", "");
           else // O se focaliza en el campo que se obtuvo a traves del while.
                      focaliza("frmInsertarCliente." + campoToFocalizar, "");


}

/* ------------------------------------------------------------------------------------------------------------------------------------------ */
function listaToXml(listado) {
          var xmlDoc = "<?xml version='1.0' encoding='ISO-8859-1' standalone='yes'?>";
          xmlDoc = xmlDoc + "<DOC>";
          var datos = eval(listado + ".datos;");
          var cantFilas = datos.length;
          /* Recorre las filas */ 
          for (var i = 0; i < cantFilas; i++) {
                    var linea = datos[i]; 
                    xmlDoc = xmlDoc + "<ROW>";
                    /* Recorre los campos dentro de la fila */
                    var cantCampos = linea.length;
                    for (var j = 0; j < cantCampos; j++ ) {
                              /* Quito formato local de numero */ 
                              var campo = linea[j];
                              xmlDoc = xmlDoc + "<CAMPO>" + DrdEscXML(campo) + "</CAMPO>";
                    }
                    xmlDoc = xmlDoc + "</ROW>"
          }
          xmlDoc = xmlDoc + "</DOC>";
          return xmlDoc; 
}

/* ------------------------------------------------------------------------------------------------------------------------------------------ */
function ensancha() {
           DrdEnsanchaConMargenDcho('listado1',12);      
           DrdEnsanchaConMargenDcho('listado2',12);
           DrdEnsanchaConMargenDcho('listado3',12);         
           eval (ON_RSZ);
}
/* ------------------------------------------------------------------------------------------------------------------------------------------ */
function setComboDefecto( nombreCombo, valorDefecto){
          var combo = "frmInsertarCliente."+ nombreCombo;
          var tamanio = document.getElementById(nombreCombo).options.length;
          for( var i = 0; i < tamanio; i++){
                    if ( combo_get( combo, 'T', i) == valorDefecto ){
                              set( combo, [ combo_get( combo, 'V', i) ]);
                    }
          }
}

function periodoDefecto(datos) {
    var periodo = get("frmInsertarCliente.valDefPeriodo");
    //alert("periodo Seleccionado: " + periodo);

    // Setea espacio en blanco.
    var datosNuevo = new Array();
    datosNuevo[0] = ["",""];

    for (var i = 0; i < datos.length; i++ ){
                datosNuevo[i+1]  = datos[i];
              }


    set_combo("frmInsertarCliente.cbPeriodoPrimerPedido", datosNuevo);
    set("frmInsertarCliente.cbPeriodoPrimerPedido", new Array(periodo) );

}

//      Agregado por HRCS - Fecha 04/04/2007 - Incidencia Sicc200070184
function seteaVinculoPorTipoCliente()   {
                  //	Obtiene los tipo y subtipo de cliente
                  if (get('frmInsertarCliente.cbTipo')==OID_TIPO_CLIENTE_HIJADUPLA && get('frmInsertarCliente.cbSTipo')==OID_SUBTIPO_CLIENTE_HIJADUPLA)
                  {
                           var ctexto2 = "comboTipoVinculo_" + Math.abs(listado1.datos.length - 1);
                           //	Modificado por HRCS - Fecha 13/08/2007 - Cambio Sicc20070361
                           var oidTVDupla = obtenerOidTipoVinculo(COD_TIPO_VINCULO_DUPLACYZONE);
                           document.getElementById(ctexto2).value = oidTVDupla;	// Seteamos el TipoVinculo = DUPLA CYZONE
                  }

                  deshabilitarFechaHastaVinculo();	// Agregado por HRCS - Fecha 22/08/2007 - Cambio Sicc20070361
}
/* ------------------------------------------------------------------------------------------------------------------------------------------ */

function mensajeValidacionRecteError()  {
         //alert('Cliente no es valido porque ya tiene un tipo de vinculo \"Dupla Cyzone\" o es de tipo \"Hija Dupla\"');
         GestionarMensaje('MAE0038');
         document.getElementById("TextoClienteVinculo_0").focus();
}
/* ------------------------------------------------------------------------------------------------------------------------------------------ */

/* 
Funcion modificada SiCC20070433 - Rafael Romero - 21/09/2007 
Se reorganiza todo el javascript de validacion, para hacer una sola llamada a la parte servidora 
*/ 
function nuevaAccionInsertarP3() {

         if(todaValidacionOK()){
                  continuaAccionInsertarP3();
         }
}
/* ------------------------------------------------------------------------------------------------------------------------------------------ */

//      Agregado por HRCS - Fecha 13/08/2007 - Cambio Sicc20070361
//      Metodo que recupera los tipos vinculos y los setea en una matriz
function salidaBusqueda(datos)  {
         tiposVinculo = new Array();
         var codigo;
         var indReco;
  
         for(var i = 0; i<datos.length; i++)	{

                  var desc = datos[i][1];
                  var separacion = 0;
                  var cadTempo = '';
                  for(var j=0; j<=desc.length; j++) {

                           var caracter = desc.charAt(j) ;

                           if (caracter != '|')	cadTempo = cadTempo + caracter;
                           else	separacion = 1;

                           if (separacion == 1)	{
                                    codigo = cadTempo;
                                    cadTempo = '';
                                    separacion = 2;
                           }
                           if (separacion == 2)	{
                                    indReco = cadTempo;
                           }
                  }
                  tiposVinculo[i] = new Array( datos[i][0], codigo, indReco);
         }
  
         // Agregado por HRCS - 28/08/2007 - Cambio Sicc20070361
         if (get('frmInsertarCliente.casoDeUso') == "ModificarCliente") {
                  //alert('listado1.datos.length: '+listado1.datos.length);
                  var oidTVDuplaCyzone = obtenerOidTipoVinculo(COD_TIPO_VINCULO_DUPLACYZONE);
                  for(var x=listado1.datos.length;x>0;x--){

                                      var tipoVinc = document.getElementById("comboTipoVinculo_"+(x-1));
                                      var fecHasta = document.getElementById("TextoFechaHasta_"+(x-1));
                                      var fechaString = '['+fecHasta.value+']';
                                      if(tipoVinc.value==oidTVDuplaCyzone && fechaString!='[]'){
                                                 listado1.eliminar((x-1),1);
                                      }
                  }
         }
         //	Agregado aqui para deshabilitar al final la fechaHasta del GrupoVinculos
         deshabilitarFechaHastaVinculo();
         return false;
}
/* ------------------------------------------------------------------------------------------------------------------------------------------ */

function obtenerOidTipoVinculo(codigo)  {

         for(var i=0; i<tiposVinculo.length; i++)	{
                  if (tiposVinculo[i][1] == codigo)	{
                           return ''+tiposVinculo[i][0];
                  }
         }
         return '-1';
}
/* ------------------------------------------------------------------------------------------------------------------------------------------ */

function validarTipoVinculoEsRecomendante(oid)  {

         for(var i=0; i<tiposVinculo.length; i++)	{
                  if (tiposVinculo[i][0] == oid)	{
                           if (tiposVinculo[i][2]==1)	{
                                    return 1;
                           }
                  }
         }
         return -1;
}

function validarEdadHijaDupla() {
    //Modificado por SICC20070433 - Rafael Romero - 20/09/2007 
    var formulario = getFormularioSICC(); 
    var fechaNac = get(formulario+'.textFechaNacimiento'); 
    // Se valida que la fecha de nacimiento no este en blanco  
    if((fechaNac!=null) && (fechaNac.length > 0)){ 
    // y que no sea mayor igual a hoy 
          if(fechaAyer!=null && ValidaFecha(fechaAyer,'')=='OK'){ 
              var mensaje = ValidaFecha(fechaNac, '','',fechaAyer); 
              if(mensaje=='OK'){ 
                    return true; 
              }else{ 
                    cdos_mostrarAlert(mensaje); 
                    document.getElementById("textFechaNacimiento").focus(); 
                    return false; 
              } 
          } 
    }else{ 
          GestionarMensaje('MAE0046'); 
          document.getElementById("textFechaNacimiento").focus(); 
          return false; 
    } 
    //Fin modificaciones 
} 
  
function deshabilitarFechaHastaVinculo()          { 
        var edad = getElement("lblEdadActual" ).innerText;            for(var ii=0;ii<listado1.datos.length;ii++) { 
            if (get('frmInsertarCliente.cbTipo')==OID_TIPO_CLIENTE_HIJADUPLA && get('frmInsertarCliente.cbSTipo')==OID_SUBTIPO_CLIENTE_HIJADUPLA) 
            { 
                     var nombreCampo = "TextoFechaHasta_"+Math.abs(ii); 
                     document.getElementById(nombreCampo).disabled=true; 
            } 
          } 
} 

function validarNingunVinculoPrincipalDuplaCyzone(){ 
         var cont = 0; 
         // Si es tipo de vinculo DuplaCyzone 
         if (get('frmInsertarCliente.cbTipo')==OID_TIPO_CLIENTE_HIJADUPLA && get('frmInsertarCliente.cbSTipo')==OID_SUBTIPO_CLIENTE_HIJADUPLA) { 
                  for(var x=0;x<listado1.datos.length;x++){   
                           var radio="CKVinculoPrincipal_"+x; 
                           var radio = document.getElementById(radio);
                           if(radio.checked==true){ 
                                    cont = cont + 1; 
      } 
    } 
                  if (cont > 0 ) { 
           	GestionarMensaje('MAE0045'); 
             return false; 
                  } 
         } 
  return true; 
}
/* ------------------------------------------------------------------------------------------------------------------------------------------ */

// Modificado por SICC20070433 - Rafael Romero - 24/09/2007 
function estableceFechaAyer(datos){ 
    fechaAyer = datos[0][1]; 
    return false; 
} 

// vbongiov -- SiCC 20080702 -- 8/09/2008
function validarCaracteresValidos(str){ 
	//alert(str);
	for(var i=0; i < str.length; i++) {
		if(str.charAt(i)=="'" || str.charAt(i)=="<" || str.charAt(i)==">" || str.charAt(i)==";" || str.charAt(i)=="\n"){
			GestionarMensaje('2629'); 
			return false;
		}
	}
	return true;
}

// vbongiov -- SiCC 20080702 -- 8/09/2008
function validarCaracteresValidosGrupo2(){ 

	if(!validarCaracteresValidos(get('frmInsertarCliente.textApellido1'))){
		focaliza("frmInsertarCliente.textApellido1"); 
		return false;
	}

	if(!validarCaracteresValidos(get('frmInsertarCliente.textApellido2'))){
		focaliza("frmInsertarCliente.textApellido2"); 
		return false;
	}

	if(!validarCaracteresValidos(get('frmInsertarCliente.textApellidoCasada'))){
		focaliza("frmInsertarCliente.textApellidoCasada"); 
		return false;
	}

	if(!validarCaracteresValidos(get('frmInsertarCliente.textNombre1'))){
		focaliza("frmInsertarCliente.textNombre1"); 
		return false;
	}

	if(!validarCaracteresValidos(get('frmInsertarCliente.textNombre2'))){
		focaliza("frmInsertarCliente.textNombre2"); 
		return false;
	}

	return true;
}

    
function todaValidacionOK(){ 
 
          if(!validarVinculo()){ 
          return false; 
          } 
     
    if(!validacionRequeridos()){ 
          return false; 
    } 

	// vbongiov -- SiCC 20080702 -- 26/08/2008
	if(!validarCaracteresValidosGrupo2()){ 
          return false; 
    } 
 
    var importeValidado = fValidarFloat(get("frmInsertarCliente.textImporteIngresoFamiliar"), 8, 2, false, 0, 999999999999999, false); 
 
    if(importeValidado != 'OK')  {     
          cdos_mostrarAlert(importeValidado); 
          focaliza("frmInsertarCliente.textImporteIngresoFamiliar"); 
          return false; 
    } 
 
    if(!validaFechaVinculos()){ 
          return false; 
    } 
    if(!validarPreferencias()){ 
          return false; 
    } 
    if(!validarObservaciones()){ 
          return false;  
    } 
    if (!validarFormato()) { 
          return false; 
    } 
    if (!validaContacto()) { 
          return false; 
    } 
     
    // Agregado por HRCS - Fecha 10/08/2007 - Cambio Sicc20070361 
    if (get('frmInsertarCliente.cbTipo')==OID_TIPO_CLIENTE_HIJADUPLA && get('frmInsertarCliente.cbSTipo')==OID_SUBTIPO_CLIENTE_HIJADUPLA) 
    { 
          if (listado1.datos.length>0) 
          { 
              if(!validarEdadHijaDupla()){ 
                    return false; 
              } 
          } 
          else    { 
              GestionarMensaje('MAE0044'); 
              return false; 
          } 
    } 
 
    return true 
 
} 
 
function pasoValidacionHijaDupla(paramHijaDupla){ 
         var subTipo  = get('frmInsertarCliente.cbSTipo'); 
         var casoDeUso = get('frmInsertarCliente.casoDeUso'); 
         var cteSubTipoHijaDupla; 
         try{ 
                  cteSubTipoHijaDupla = paramHijaDupla[0]; 
         }catch(err){ 
                  return true; 
         } 
         if (subTipo == cteSubTipoHijaDupla){ // Verificar estado de validacion de edad 
                  var nivelValidacionEdadHijaDupla; 
                  var nivelValidacionTipoHijaDupla; 
                  try{ 
                           nivelValidacionEdadHijaDupla = paramHijaDupla[1]; 
                  }catch(err){ 
                           nivelValidacionEdadHijaDupla = 0; 
                  } 
                  try{ 
                           nivelValidacionTipoHijaDupla = paramHijaDupla[2]; 
                  }catch(err){ 
                           nivelValidacionTipoHijaDupla = 0; 
                  } 
     
    /* 
    nivelValidacionEdadHijaDupla 
    ============================ 
    0: Indica que se han superado la validacion de edad 
    1: Indica que la edad no esta en el rango apropiado 
           
    nivelValidacionTipoHijaDupla 
    ============================ 
    0: Indica que se han superado la validacion de tipo 
    1: Indica que el codigo del vinculo no existe en entidad Cliente_Tipo_Subtipo 
    2: Indica que el codigo del vinculo corresponde a un tipo HijaDupla 
    3: Indica que el codigo del vinculo no es Consultora 
    */ 
     
    if(nivelValidacionEdadHijaDupla==1){ 
                           if (casoDeUso == "Insertar Cliente"){
                                    if ( GestionarMensaje('MAE0039') ){
                                             document.getElementById("textFechaNacimiento").focus();
                                             return false;
                                    }else{
                                             //	Cancelamos saliendo de la pantalla de ingreso
                                             var formulario = getFormularioSICC();
                                             set(formulario+".conectorAction","LPInicioBelcorp");
                                             set(formulario+".accion","");
                                             try{
                                                      parent.frames['menu'].location.reload();
                                                      parent.frames["iconos"].mostrarCapa();
                                                      resizeMenu();
                                             }catch(e){}
                                             eval(formulario).oculto = 'N';
                                             enviaSICC(formulario,'','','N');

                                             //	Envia el mensaje de rechazo de Dupla al buzon del cliente
                                             var textVinc= document.getElementById("TextoClienteVinculo_0");
                                             set(formName + '.accion','EnviaMensajeRechazo');
                                             set(formName + '.codigoClienteValidar', textVinc.value );
                                             set(formName + '.conectorAction','LPInsertarCliente');
                                             eval('frmInsertarCliente').oculto = 'S';
                                             set(formName + '.casoDeUso', get('frmInsertarCliente.casoDeUso') );
                                             enviaSICC(formName);
                                             return false;
                                    }
                           }else{
                                    if ( GestionarMensaje('MAE0040') )	{
                                             document.getElementById("textFechaNacimiento").focus();
                                             return false;
                                    }else{
                                             // Elije continuar
                                    }
                           }
                  }
                  if(nivelValidacionTipoHijaDupla!=0){ 
      if(nivelValidacionTipoHijaDupla==1){
                                    GestionarMensaje('MAE0043'); 
                           }
                           if(nivelValidacionTipoHijaDupla==2){
                                    GestionarMensaje('MAE0041');
                           }
                           if(nivelValidacionTipoHijaDupla==3){
                                    GestionarMensaje('MAE0042');
                           }
                           document.getElementById("TextoClienteVinculo_0").focus();
                           return false;
                  }
         }
  return true;
}
// Fin modificado SICC20070433