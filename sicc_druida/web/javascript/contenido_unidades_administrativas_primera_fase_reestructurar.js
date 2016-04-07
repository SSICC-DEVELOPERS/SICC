var FORMULARI = 'frm';
var valorRadioPeriodo = '0';
var periodoI = null;

         function onLoadPag() {
                  configurarMenuSecundario(FORMULARI);
                  var errDescripcion = get(FORMULARI +'.errDescripcion');
                  if (errDescripcion !='') {		
                           var errCodigo = get(FORMULARI+'.errCodigo');
                           var wnd = fMostrarMensajeError(errCodigo, errDescripcion);
                           accionAnular();
                  }
                  
                  accion(FORMULARI + '.cbPeriodo', '.disabled=true');
             periodoI = eval("document.all['RPerio']");
                  periodoI[0].checked = true;
                  periodoI[1].focus();
                  
         }

         function accionAceptar(){

                  if (!sicc_validaciones_generales()) return false;

                  var periodo = get(FORMULARI + '.oidPeriodoPropuesto')

                  if (valorRadioPeriodo == '1') 
                           periodo = get(FORMULARI + '.oidPeriodoSinSolapar')
                  else if (valorRadioPeriodo == '2') 
                           periodo = get(FORMULARI + '.cbPeriodo')

                  set(FORMULARI + '.oidPeriodo', periodo);
                  set(FORMULARI + '.accion', 'Rezonificar');
                  set(FORMULARI + '.conectorAction','LPReestructurarPrimeraFase');
                  enviaSICC(FORMULARI);

         }

         function mensajeProcesando(){
                  GestionarMensaje('M00047');
    
    if(get(FORMULARI + '.casoDeUso')=="ProcesarReestructuracionUA"){
         // Reinicio el CU Procesar Reestructuracion UA
         eval(FORMULARI).oculto = 'N';
         set(FORMULARI + '.conectorAction', 'LPEjecutarReestructuracionUA');
         set(FORMULARI + '.accion', '');
         enviaSICC(FORMULARI, null, null, 'N');
         
    } else {
         accionAnular();
    }
         }

         function fLimpiar() {
                  //Limpiar el formulario
                  valorRadioPeriodo = '0';
                  periodoI[0].checked = true;
                  habilitarPeriodo('0');
                  periodoI[0].focus();
         }

         function focalizarRadio() {
                  periodoI[Number(valorRadioPeriodo)].focus();
         }


         function habilitarPeriodo(valor) {
                  valorRadioPeriodo = valor;
                  //habilitar/deshabilitar cbPeriodo si seleccionado/deseleccionado opción 2
                  //Si se habilita el combo se debe hacer requerido
         
                  if (valor == '2') {
                           objValidacionSICC[0].requerido = true;
                           accion(FORMULARI + '.cbPeriodo', '.disabled=false');
                  } else {
                           objValidacionSICC[0].requerido = false;
                           set(FORMULARI + '.cbPeriodo', ['']);
                           accion(FORMULARI + '.cbPeriodo', '.disabled=true');
                  }
         }
         
         function accionAnular() {
                  set(FORMULARI + ".conectorAction", "LPInicioBelcorp");
                  set(FORMULARI + ".accion", "");
                  try{
                           //parent.frames['menu'].location.reload();
                           parent.frames["iconos"].mostrarCapa();
                  } catch(e) {}
                  eval(FORMULARI).oculto = 'N';
                  enviaSICC(FORMULARI, '', '', 'N');
         }
