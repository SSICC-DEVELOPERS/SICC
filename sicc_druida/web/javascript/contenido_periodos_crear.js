
          function onLoadPag()   {        
                   DrdEnsanchaConMargenDcho('listado1',12);                    
                   if (get('frmCrearPeriodo.hListadoDisponible') == "SI") {   
                            mostrarListaEditable();   
                   } else {    
                            ocultarListaEditable();   
                   }
				   if(get('frmCrearPeriodo.hCasoDeUso') == "modificar"){
						visibilidad('CAPA1','O');
						visibilidad('CAPA2','O');
				   }
				   
                   eval (ON_RSZ);     
          }   
    
    
          // Inicializacion de los parametros de la pantalla    
          function inicializacion() {   
                   txt_to('lblValorPais', get('frmCrearPeriodo.hPaisDescripcion'));    
                   configurarMenuSecundario("frmCrearPeriodo");   
                   if(get('frmCrearPeriodo.hCasoDeUso') == 'modificar'){    
                            if(get('frmCrearPeriodo.errCodigo')!='') {    
                                     GestionarMensaje(get('frmCrearPeriodo.errCodigo'), 'frmConsultarPeriodos.txtDescripcion');    
                            }   
                   }    
                   posicionarCombo();    
                   set('frmCrearPeriodo.Anio', get('frmCrearPeriodo.hAnio'));    
                   if (get('frmCrearPeriodo.errDescripcion')!='') {    
                            var wnd = fMostrarMensajeError(get('frmCrearPeriodo.errCodigo'), get('frmCrearPeriodo.errDescripcion'));   
                   }   
                   focaliza('frmCrearPeriodo.comboMarca','');   
    
                   //actualizo el listado de periodos.   
                   listado1.save();   
                   listado1.repintaDat();   
    
                   //transforma datos de periodos antes de ser mostrado   
                   listado1.datos = adecuarListaVisible(listado1.datos);   
    
                   //se verifican cruces, es necesario si se recalculo   
                   compruebaCruces();   
    
                   //actualizo el listado de periodos.   
                   listado1.save();   
                   listado1.repintaDat();   
    
                   set('frmCrearPeriodo.hListaPeriodos', listado1.datos);    
    
                   //por defecto si no hay ninguno ponemos el primero de la lista de periodos.   
                   if ( get('frmCrearPeriodo.hIndicePeriodoModificado') == "") {   
                            set('frmCrearPeriodo.hIndicePeriodoModificado', '0');
                   }   
    
                   //alert("accion: " + get('frmCrearPeriodo.accion'));    
                   //alert('datos:' + listado1.datos );   
          }    
    
     
          // Se pulso el boton buscar                              
          function fBuscar() {    
                   if(!sicc_validaciones_generales()){   
                            return false;   
                   }     
                   if (fValidarCOMBO('frmCrearPeriodo.comboMarca') &&    
                                     fValidarCOMBO('frmCrearPeriodo.comboCanal') &&   
                                     fValidarCTEXT('frmCrearPeriodo.Anio')) {    
                            obtenerPaisMarcaCanalAnio();    
    
                            var casoUso = get('frmCrearPeriodo.hCasoDeUso');   
                            //alert('CU ' + casoUso);   
    
                            // if (get('frmCrearPeriodo.hCasoDeUso') == 'modificar') { //Sin Paginado   
                            //  set('frmCrearPeriodo.conectorAction', 'LPModificaPeriodo'); //Sin Paginado   
                            // }   
                            // set('frmCrearPeriodo.accion', 'buscar'); //Sin Paginado   
                            // enviaSICC('frmCrearPeriodo'); //Sin Paginado   
    
                            mostrarListaEditable();   
    
                            if (casoUso == 'modificar') {   
                                     configurarPaginado(mipgndo, 'CRAConsultarPeriodos', 'ConectorObtenerTodosPeriodosConsulta',   
                                                                                   'es.indra.sicc.dtos.cra.DTOCriteriosPeriodo', armarArrayParametrosDTO());   
                            } else {   
                                     //cu insertar   
                                     configurarPaginado(mipgndo, 'CRAObtienePeriodosInsertar', 'ConectorObtienePeriodosInsertar',   
                                                                          'es.indra.sicc.dtos.cra.DTOAsociadosAPeriodo', armarArrayParametrosDTO());   
                            }   
    
                            //habilita el boton de guardar en menu secundario   
                            btnProxy(1, '1');   
                   }    
          }    
    
     
          // Levanta los valores seleccionados para pais marca y canal    
          function obtenerPaisMarcaCanalAnio(){    
                   set('frmCrearPeriodo.hCanal', get('frmCrearPeriodo.comboCanal'));    
                   set('frmCrearPeriodo.hMarca', get('frmCrearPeriodo.comboMarca'));    
                   set('frmCrearPeriodo.hAnio', get('frmCrearPeriodo.Anio')); 
				   set('frmCrearPeriodo.hAcceso', get('frmCrearPeriodo.comboAcceso'));
          }    
     
    
          function posicionarCombo() {    
                   var iSeleccionadoM = new Array();    
                   iSeleccionadoM[0] = get('frmCrearPeriodo.hMarca');    
                   set('frmCrearPeriodo.comboMarca',iSeleccionadoM);    
    
                   var iSeleccionado = new Array();    
                   iSeleccionado[0] = get('frmCrearPeriodo.hCanal');    
                   set('frmCrearPeriodo.comboCanal',iSeleccionado);    
          }    
              
    
          // Vacia todos los campos de la pantalla    
          function fLimpiar() {    
                   set('frmCrearPeriodo.comboCanal', '');    
                   set('frmCrearPeriodo.comboMarca', '');    
                   set('frmCrearPeriodo.Anio', '');    
                   set('frmCrearPeriodo.hListadoDisponible', '');  
				   set('frmCrearPeriodo.hAcceso', '');
				   txt_to('lblValorPais', get('frmCrearPeriodo.hPaisDescripcion')); 
                   focaliza('frmCrearPeriodo.comboMarca','');   
          }    
     
             
          // Permite guardar los periodos para un anio    
          function fGuardar() {   
				   setTimeout("guardarDos()",100);   
          }   
    
          function guardarDos() {    
									   
					//Agregado CRA-03. actualizo el listado de periodos para tomar los cambios   
                   listado1.save();   
                   listado1.repintaDat();
					//fin Agregado CRA-03
					
     			    //seteamos la lista de periodos   
                   set('frmCrearPeriodo.hListaPeriodos', listado1.datos);    
                        
                   //aplica validaciones   
                   if ( ! aplicarCambios() ) {
						return false;
				   }
        
                   //aplica validaciones generales
                   if(!sicc_validaciones_generales()){   
                            return false;   
                   }   
    
                   if ( fValidarCOMBO('frmCrearPeriodo.comboMarca') &&    
                                     fValidarCOMBO('frmCrearPeriodo.comboCanal') &&									   
                                     fValidarCTEXT('frmCrearPeriodo.Anio')) {   
                            obtenerPaisMarcaCanalAnio();    
    
                            if(get('frmCrearPeriodo.hCasoDeUso')=='modificar'){
							         set('frmCrearPeriodo.conectorAction', 'LPModificaPeriodo');   
							
                            }   
    
                            //transforma datos sobre hListaPeriodos antes de ser enviados   
                            adecuarListaOculta();   
    
                            set('frmCrearPeriodo.accion', 'grabar');   
                            enviaSICC('frmCrearPeriodo');    
                   }    
          }    
     
    
          //Chequea quedo alguna validacion a informar   
          function aplicarCambios() {   
                   var msgValida = get('frmCrearPeriodo.msgValidaDatos');   
                   if ( msgValida != '') {   
                            cdos_mostrarAlert(msgValida);
							set('frmCrearPeriodo.msgValidaDatos','');
							return false;
                   }
				return true;
          }   
    
    
		  // El campo nombrePeriodo ha cambiado, se dispara desde el onchange.             
          function cambioNombrePeriodo() {   
                   //info sobre nombrePeriodo que cambio   
                   var elNombrePeriodo = window.event.srcElement;   
                   var nombrePeriodo = elNombrePeriodo.name;   
                   var arrayNombreIndice = nombrePeriodo.split('_');   
                   var indiceFilaCambio = Math.abs(arrayNombreIndice[1]);   
                   var laDuracion = document.getElementById('txtNombrePeriodo_' + indiceFilaCambio);    
    
                   //Verifica que no se deje en blanco   
                   if ( ! fValidarCTEXTListaEditable(elNombrePeriodo) ) {   
						//focalizo sobre lista editable
						eval("listado1"+".preparaCamposDR()");
						focaliza('frm'+'listado1'+'.'+'txtNombrePeriodo'+'_'+indiceFilaCambio,''); 
                   }   
          }   
		  
		  // El campo Duracion ha cambiado, se dispara desde el onchange.   
          // Hay que validar que no este vacio y que la fecha sea correcta, luego Calcula la fecha de fin.
		  // @autor gdmarzi. ---.Metodo muy sensible de mantener.---
          function cambioDuracion() {   

				// info sobre la duracion que cambio   
				var elTxtDuracion = window.event.srcElement;   
				var nombreTxtDuracion = elTxtDuracion.name;   
				var arrayNombreIndice = nombreTxtDuracion.split('_');   
				var indiceFilaCambio = Math.abs(arrayNombreIndice[1]);   
				var valorTxtDuracion = elTxtDuracion.value;   

				// info sobre la fecha fin a actualizar   
				var laFechaFin = document.getElementById('txtFfin_' + indiceFilaCambio );   
				var valorFechaFin = laFechaFin.value;   

				// info sobre la fecha inicio   
				var laFechaInicio = document.getElementById('txtFinicio_' + indiceFilaCambio );   
				var valorFechaInicio = laFechaInicio.value;   

    
				// Valido que no quede vacia la caja de texto duracion (no utilizo la funcion por los threads)
				var pValor = new String( valorTxtDuracion + "");
				if ( cdos_trim( pValor ) == "" ) {   
						// no dejamos salir de la caja de texto y lanza mensaje
						event.returnValue=false;   
						event.cancelBubble=true;   
						GestionarMensaje('27',  pValor);   

				} else {
					/* cambiamos la fecha de fin */   
					var nuevaDuracion = valorTxtDuracion;   
					
					// Valida que la duracion sea un numero
					var msgValidaDurac = ValidaNum(nuevaDuracion);   

					if (msgValidaDurac != 'OK') {   
						  // seteo un flag para NO permitir recalcular o grabar.
						  set('frmCrearPeriodo.errorValidaDatos', 'errorDuracion');   
						  set('frmCrearPeriodo.msgValidaDatos', msgValidaDurac);   

						  // no dejamos salir de la caja de texto y lanza mensaje
						  event.returnValue=false;
						  event.cancelBubble=true;   
						  cdos_mostrarAlert(msgValidaDurac);

					} else {
						// seteo un flag para permiter recalcular o grabar. 
						set('frmCrearPeriodo.msgValidaDatos', '');   
						set('frmCrearPeriodo.errorValidaDatos', '');   

						// pasamos valorFechaInicio al formato dd/mm/aaaaa   
						// alert('hFormatoFechaPais   ' + get('frmCrearPeriodo.hFormatoFechaPais'));   
						var fecha1 = obtenerFormatoFecha(valorFechaInicio);   
						var d1,d2;   
						var dias = 0;   

						var arrFecha = fecha1.split("/");   
						d1 = new Date(arrFecha[2],arrFecha[1]-1,arrFecha[0]);   
						dias = (nuevaDuracion-1) * 86400000;   
						d2 = dias + d1.getTime(); // milisegundos   
						var fecha2 = new Date();   
						fecha2.setTime(d2);   

						var anio = fecha2.getFullYear();   
						var m0   = fecha2.getMonth() + 1; // meses de 0..11   
						var mes  = (m0 < 10)?('0'+m0):m0;   
						var dia  = (fecha2.getDate() < 10) ? ('0'+fecha2.getDate()) : fecha2.getDate();   
						var fecha3 = dia+'/'+mes+'/'+anio;   

						//asigno la nueva fecha de fin   
						laFechaFin.value = obtenerFormatoFecha(fecha3);   
						set('frmCrearPeriodo.msgValidaDatos', '');   
						set('frmCrearPeriodo.errorValidaDatos', '');   

						//actualizo el listado de periodos.   
						listado1.save();   
						listado1.repintaDat();   

						//identificar el indice del periodo que cambio   
						set('frmCrearPeriodo.hIndicePeriodoModificado', indiceFilaCambio);   

						//Al cambiar la duracion comprueba cruces entre fechas
						compruebaCruces();

					} //fin valida duracion 

				} //fin valida caja texto vacia

				//focalizo sobre lista editable
				eval("listado1"+".preparaCamposDR()");
				focaliza('frm'+'listado1'+'.'+'txtDuracionPeriodo'+'_'+indiceFilaCambio,''); 
				return;	
		  }   



          // El campo Fecha de Inicio ha cambiado, se dispara desde el onchange.   
          // Hay que validar que no este vacio y que la fecha sea correcta, para luego ajustar la duración.
		  // @autor gdmarzi. ---.Metodo muy sensible de mantener.---
          function cambioFechaInicio( ) {   

				// info sobre la fecha de inicio que cambio   
				var laFechaInicio = window.event.srcElement;   
				var nombreFechaInicio = laFechaInicio.name;   
				var arrayNombreIndice = nombreFechaInicio.split('_');   
				var indiceFilaCambio = Math.abs(arrayNombreIndice[1]);   
				var valorFechaInicio = laFechaInicio.value;   

				// info sobre la duracion a actualizar   
				var laDuracion = document.getElementById('txtDuracionPeriodo_' + indiceFilaCambio);   
				var valorDuracion = laDuracion.value;   

				// info sobre la fecha fin   
				var laFechaFin = document.getElementById('txtFfin_' + indiceFilaCambio);   
				var valorFechaFin = laFechaFin.value;   

				// Valido que no quede vacia la caja de texto fechaInicio (no utilizo la funcion por los threads)
				var pValor = new String( valorFechaInicio + "");
				if ( cdos_trim( pValor ) == "" ) {   
						// no dejamos salir de la caja de texto y lanza mensaje
						event.returnValue=false;   
						event.cancelBubble=true;   
						GestionarMensaje('27',  pValor);   

				} else {
					// pasamos las fecha al formato dd/mm/aaaaa   
					var fechaInicio = obtenerFormatoFecha(valorFechaInicio);   
					var fechaFin = obtenerFormatoFecha(valorFechaFin);   

					// Valida el formato de la fecha 
					var msgValidaFecha = ValidaFecha(fechaInicio,'D/M/Y',fechaInicio,fechaFin);   

					if (msgValidaFecha != 'OK') {   
						  // seteo un flag para NO permitir recalcular o grabar.
						  set('frmCrearPeriodo.errorValidaDatos', 'errorFechaInicio');   
						  set('frmCrearPeriodo.msgValidaDatos', msgValidaFecha);   

						  // no dejamos salir de la caja de texto y lanza mensaje
						  event.returnValue=false;
						  event.cancelBubble=true;   
						  cdos_mostrarAlert(msgValidaFecha);

					} else {
						// seteo un flag para permiter recalcular o grabar. 
						set('frmCrearPeriodo.msgValidaDatos', '');   
						set('frmCrearPeriodo.errorValidaDatos', '');   

						// ajusto duracion   
						var dif = DiferenciaFechas(fechaInicio,fechaFin,'D/M/Y') + 1;   
						// asigno duracion   
						laDuracion.value = dif;   

						//actualizo el listado de periodos.   
						listado1.save();   
						listado1.repintaDat();   

						//identificar el periodo que cambio   
						set('frmCrearPeriodo.hIndicePeriodoModificado', indiceFilaCambio);   

						//Al cambiar la fecha comprueba cruces entre fechas
						compruebaCruces();

					} //fin valida formato fecha  

				} //fin valida caja texto vacia

				//focalizo sobre lista editable
				eval("listado1"+".preparaCamposDR()");
				focaliza('frm'+'listado1'+'.'+'txtFinicio'+'_'+indiceFilaCambio,''); 
				return;	
		  }  



          // El campo Fecha de Fin ha cambiado, se dispara desde el onchange.   
          // Hay que validar que no este vacio y que la fecha sea correcta, para luego ajustar la duración.
		  // @autor gdmarzi. ---.Metodo muy sensible de mantener.---
          function cambioFechaFin() {   
				// info sobre la fecha de fin que cambio   
				var laFechaFin = window.event.srcElement;   
				var nombreFechaFin = laFechaFin.name;   
				var arrayNombreIndice = nombreFechaFin.split('_');   
				var indiceFilaCambio = Math.abs(arrayNombreIndice[1]);   
				var valorFechaFin = laFechaFin.value;   

				// info sobre la duracion a actualizar   
				var laDuracion = document.getElementById('txtDuracionPeriodo_' + indiceFilaCambio);   
				var valorDuracion = laDuracion.value;   

				// info sobre la fecha fin   
				var laFechaIncio = document.getElementById('txtFinicio_' + indiceFilaCambio);   
				var valorFechaInicio = laFechaIncio.value;   

				// Valido que no quede vacia la caja de texto fechaFin (no utilizo la funcion por los threads)
				var pValor = new String( valorFechaFin + "");
				if ( cdos_trim( pValor ) == "" ) {   
						// no dejamos salir de la caja de texto y lanza mensaje
						event.returnValue=false;   
						event.cancelBubble=true;   
						GestionarMensaje('27',  pValor);   

				} else {
					// pasamos las fecha al formato dd/mm/aaaaa   
					var fechaInicio = obtenerFormatoFecha(valorFechaInicio);   
					var fechaFin = obtenerFormatoFecha(valorFechaFin);   
    
					// Valida el formato de la fecha 
					var msgValidaFecha = ValidaFecha(fechaFin,'D/M/Y',fechaInicio,fechaFin);   
    
					if (msgValidaFecha != 'OK') {   
						  // seteo un flag para NO permitir recalcular o grabar.
						  set('frmCrearPeriodo.errorValidaDatos', 'errorFechaFin');   
						  set('frmCrearPeriodo.msgValidaDatos', msgValidaFecha);   

						  // no dejamos salir de la caja de texto y lanza mensaje
						  event.returnValue=false;
						  event.cancelBubble=true;   
						  cdos_mostrarAlert(msgValidaFecha);

					} else {

						// seteo un flag para permiter recalcular o grabar
						set('frmCrearPeriodo.msgValidaDatos', '');
						set('frmCrearPeriodo.errorValidaDatos', ''); 

						// ajusto duracion   
						var dif = DiferenciaFechas(fechaInicio,fechaFin,'D/M/Y') + 1;   
						// asigno duracion
						laDuracion.value = dif;

						//actualizo el listado de periodos
						listado1.save();
						listado1.repintaDat();

						//identificar el periodo que cambio
						set('frmCrearPeriodo.hIndicePeriodoModificado', indiceFilaCambio);

						//Al cambiar la fecha comprueba cruces entre fechas
						compruebaCruces();

					} //fin valida formato fecha  

				} //fin valida caja texto vacia

				//focalizo sobre lista editable
				eval("listado1"+".preparaCamposDR()");
				focaliza('frm'+'listado1'+'.'+'txtFfin'+'_'+indiceFilaCambio,''); 
				return;	
		  }   
    

	
          // Recalculo de Periodos    
          function recalcularPeriodosPosteriores() {    

                   /*
				    * 22888 - dmorello, 10/07/2006:
					* Se exigirá que haya una línea de la lista SELECCIONADA
					* para recalcular los períodos posteriores al que hay en ella
					*/
				   var seleccionados = listado1.codSeleccionados();
				   if (seleccionados.length != 1) {
						GestionarMensaje('41');
						return;
				   } // Fin dmorello 10/07/2006

                   obtenerPaisMarcaCanalAnio();   
    
                   if (get('frmCrearPeriodo.hCasoDeUso') == 'modificar') {   
                            set('frmCrearPeriodo.conectorAction', 'LPModificaPeriodo');   
                   }   
    
                   //actualizo el listado de periodos para tomar los cambios   
                   listado1.save();   
                   listado1.repintaDat();   
    
                   //seteamos la lista de periodos   
                   set('frmCrearPeriodo.hListaPeriodos', listado1.datos);    
    
                   //seteamos el periodoModificado   
                   /* 22888 - dmorello, 10/07/2006: El indice se obtendra de la lista y no del VAR */
				   //var indicePeriodoCambio = get('frmCrearPeriodo.hIndicePeriodoModificado');
				   // Hallo el índice del período seleccionado a partir de su OID
				   var indicePeriodoCambio = 0;
				   while (listado1.datos[indicePeriodoCambio][0] != seleccionados[0]) {
						indicePeriodoCambio++;
				   }
				   /* Fin 22888 dmorello 10/07/2006 */

                   var periodoCambio = listado1.datos[indicePeriodoCambio];   
                   periodoCambio = adecuarPeriodoOculto(periodoCambio);   
                   set('frmCrearPeriodo.hPeriodoModificado', periodoCambio);   
                      
                   //transforma datos sobre hListaPeriodos antes de ser enviados   
                   adecuarListaOculta();   
    
                   //recalcular periodods   
                   set('frmCrearPeriodo.accion', 'recalculaPeriodos');    
                   enviaSICC('frmCrearPeriodo');    
          }    
    
    
          //Comprueba los cruces en los periodos, actualizando el listado   
          function compruebaCruces() {   
                   var periodos = listado1.datos;   
                   var indexFechaFin = 6;   
                   var indexFechaInicio = 5;   
                   var indexPeriodoCruce = 9;   
                   var fechaFinActual;   
                   var fechaInicioSiguiente;   
                   var fechaFinActualMilis;   
                   var fechaInicioSiguienteMilis;   
                   var si = GestionarMensaje(84);   
                   var no = GestionarMensaje(86);   
    
                   //chequeo desde el primero con el segundo hasta el anteultimo con el ultimo   
                   for (var i=0; i < (periodos.length - 1); i++) {   
                            fechaFinActual = periodos[i][indexFechaFin];   
                            fechaInicioSiguiente = periodos[i+1][indexFechaInicio];   
                            fechaFinActualMilis = dameMilis(fechaFinActual);   
                            fechaInicioSiguienteMilis = dameMilis(fechaInicioSiguiente);   
                            //alert("fechaFinActualMilis " + fechaFinActualMilis);   
                            //alert("fechaInicioSiguienteMilis " + fechaInicioSiguienteMilis);   
    
                            if (fechaFinActualMilis >= fechaInicioSiguienteMilis) {   
                                     //periodo con cruce    
                                     periodos[i][indexPeriodoCruce] = si;   
                            } else {   
                                     //periodo sin cruce   
                                     periodos[i][indexPeriodoCruce] = no;   
                            }   
                   }   
                   //ademas el ultimo es periodo sin cruce   
                   if (periodos.length != 0) {   
                            periodos[periodos.length-1][indexPeriodoCruce] = no;   
                   }   
    
                   //setamos la lista actualizada   
                   listado1.datos = periodos;   
    
                   //actualizo el listado de periodos.   
                   listado1.save();   
                   listado1.repintaDat();   
          }   
    
    
          // transforma el indicador de periodo corto y el indicador de cruce (para enviar)   
          function adecuarListaOculta() {   
                   var i;   
                   var indexCorto = 8;   
                   var indexCruce = 9;   
                   var si = GestionarMensaje(84);   
                   var no = GestionarMensaje(86);   
                   //tomamos la lista actual del rowset   
                   var listaPeriodos = listado1.datos;    
                   //realizamos la tranformaion   
                   for( i = 0; i < listaPeriodos.length; i++ ){   
                            //reemplazar los valores en indicador periodo corto (checkbox)   
                            if( listaPeriodos[i][indexCorto] == 'N')   
                                     listaPeriodos[i][indexCorto] = 'false';   
                            else   
                                     listaPeriodos[i][indexCorto] = 'true';   
                            //reemplazar los valores en indicador periodo cruce (i18n)   
                            if( listaPeriodos[i][indexCruce] == no)   
                                     listaPeriodos[i][indexCruce] = 'false';   
                            else   
                                     listaPeriodos[i][indexCruce] = 'true';   
                   }   
                   //setamos la lista oculta actualizada   
                   set('frmCrearPeriodo.hListaPeriodos', listaPeriodos);    
          }   
    
    
          // transforma el indicador de cruce (para mnstrar)   
          // el indicador de periodo corto se debe transformar en la LP   
          function adecuarListaVisible(rowset) {   
                   var i;   
                   var indexCorto = 8;   
                   var indexCruce = 9;   
                   var si = GestionarMensaje(84);   
                   var no = GestionarMensaje(86);   
                   for( i = 0; i < rowset.length; i++ ){   
                            //reemplazar los valores en indicador periodo cruce (i18n)   
                            if( rowset[i][indexCruce] == 'false')   
                                     rowset[i][indexCruce] = no;   
                            else   
                                     rowset[i][indexCruce] = si;   
                   }   
                   return rowset;   
          }   
    
    
          //funcion llamada al cargar el paginado para actulizar la lista editable   
          function prueba(ultima, rowset){   
                   var i;   
                   var indexCorto = 8;   
                   var indexCruce = 9;   
                   var si = GestionarMensaje(84);   
                   var no = GestionarMensaje(86);   
                   var tamano = rowset.length;   
                   if (tamano > 0) {   
                      mostrarListaEditable();   
                      eval (ON_RSZ);                        
                   } else {   
                       ocultarListaEditable();   
                       focaliza("frmCrearPeriodo.comboMarca");    
                       return false;   
                   }   
                   for( i = 0; i < rowset.length; i++ ){   
                            //reemplazar los valores en indicador periodo corto (checkbox)   
                            if( rowset[i][indexCorto] == 'false')   
                                     rowset[i][indexCorto] = 'N';   
                            else   
                                     rowset[i][indexCorto] = 'S';   
                            //reemplazar los valores en indicador periodo cruce (i18n)   
                            if( rowset[i][indexCruce] == 'false')   
                                     rowset[i][indexCruce] = no;   
                            else   
                                     rowset[i][indexCruce] = si;   
                   }                     
                   focaliza("frmCrearPeriodo.comboMarca");   
                   return true;   
          }   
    
          // transforma el indicador de periodo corto y el indicador de cruce (para enviar)   
          function adecuarPeriodoOculto(periodo) {   
                   var indexCorto = 8;   
                   var indexCruce = 9;   
                   var si = GestionarMensaje(84);   
                   var no = GestionarMensaje(86);   
                   //reemplazar los valores en indicador periodo corto (checkbox)   
                   if( periodo[indexCorto] == 'N')   
                            periodo[indexCorto] = 'false';   
                   else   
                            periodo[indexCorto] = 'true';   
                   //reemplazar los valores en indicador periodo cruce (i18n)   
                   if( periodo[indexCruce] == no)   
                            periodo[indexCruce] = 'false';   
                   else   
                            periodo[indexCruce] = 'true';   
                   return periodo;    
          }   
    
    
          //Dada una fecha retorna los milisegundos   
          function dameMilis( valorFecha ) {   
                   // pasamos valorFechaInicio al formato dd/mm/aaaaa   
                   // alert('hFormatoFechaPais   ' + get('frmCrearPeriodo.hFormatoFechaPais'));   
                   var fecha1 = obtenerFormatoFecha(valorFecha);   
                   var d1,d2;   
                   var dias = 0;   
                   var arrFecha = fecha1.split("/");   
                   d1 = new Date(arrFecha[2],arrFecha[1]-1,arrFecha[0]);   
                   d2 = d1.getTime(); // milisegundos    
                   return d2;   
          }   
    
    
          function ocultarListaEditable() {   
                   document.all["Cplistado1"].style.visibility='hidden';   
                   document.all["CpLin1listado1"].style.visibility='hidden';   
                   document.all["CpLin2listado1"].style.visibility='hidden';   
                   document.all["CpLin3listado1"].style.visibility='hidden';   
                   document.all["CpLin4listado1"].style.visibility='hidden';   
                   //document.all["prim1Div"].style.visibility='hidden';   
                   document.all["ret1Div"].style.visibility='hidden';   
                   document.all["ava1Div"].style.visibility='hidden';   
                   //document.all["separaDiv"].style.visibility='hidden';   
                   document.all["RecalcularDiv"].style.visibility='hidden';   
          }   
    
    
          function mostrarListaEditable() {   
                   document.all["Cplistado1"].style.visibility='visible';   
                   document.all["CpLin1listado1"].style.visibility='visible';   
                   document.all["CpLin2listado1"].style.visibility='visible';   
                   document.all["CpLin3listado1"].style.visibility='visible';   
                   document.all["CpLin4listado1"].style.visibility='visible';   
                   //document.all["prim1Div"].style.visibility='visible';   
                   document.all["ret1Div"].style.visibility='visible';   
                   document.all["ava1Div"].style.visibility='visible';   
                   //document.all["separaDiv"].style.visibility='visible';   
                   document.all["RecalcularDiv"].style.visibility='visible';   
          }   
    
    
          function armarArrayParametrosDTO()  {   
                   var array = new Array();   
                   var i = 0;   
                   array[i] = new Array('oidIdioma',get('frmCrearPeriodo.hIdioma'));   
    
                   if (get('frmCrearPeriodo.hPais') != '')  {   
                            i++;   
                            array[i] = new Array('pais',get('frmCrearPeriodo.hPais'));   
                   }   
                   if (get('frmCrearPeriodo.comboMarca') != '')  {   
                            i++;   
                            array[i] = new Array('marca',get('frmCrearPeriodo.comboMarca'));   
                   }   
                   if (get('frmCrearPeriodo.comboCanal') != '')  {   
                            i++;   
                            array[i] = new Array('canal',get('frmCrearPeriodo.comboCanal'));   
                   }   
                   if (get('frmCrearPeriodo.Anio') != '')  {   
                            i++;   
                            array[i] = new Array('anio',get('frmCrearPeriodo.Anio'));   
                   }   
    
                   //alert(array);   
                   return array;   
          }   
    
    
          //Valida ingreso de valor en una campo de texto de una lista editable.   
          function fValidarCTEXTListaEditable( objElement ) {   
                   /*   
                   Parametros:   
                            objElement = Es el objeto CTEXTO de la lista editable"   
                   Retorna:   
                            true --- si se ingresaron datos en el campo.   
                            false --- si NO se ingresaron datos en el campo.   
                   Nota:   
                            Se realizar un TRIM de los espacios   
                   */   
                   var pValor = new String( objElement.value + "");   
    
                   if ( cdos_trim( pValor ) == "" ){   
                            event.returnValue=false;   
                            event.cancelBubble=true;   
							GestionarMensaje('27',  pValor);   
                            try{   
                                     objElement.focus();   
                            }   
                            catch(e){   
                            }   
                            return false;   
                   }   
                               
                   return true;   
          }   

    
    
          // Envia el periodo seleccionado a modificar, por LPModificarPeriodo.    
          // --DEPRECATED. ahora se utiliza la lista editable.   
          function modificarPeriodos() {    
                   obtenerPaisMarcaCanalAnio();    
    
                   var periodoSeleccionado = ListaPeriodo.getSeleccion();    
                   //if (periodoSeleccionado == '') {    
                   if (ListaPeriodo.seleccion.longitud!=1) {    
                            GestionarMensaje('8');   
                   } else {   
                            if(get('frmCrearPeriodo.hCasoDeUso')=='modificar') {   
                                     set('frmCrearPeriodo.conectorAction', 'LPModificaPeriodo');   
                            }   
    
                            set('frmCrearPeriodo.hPeriodoSeleccionado',ListaPeriodo.getSeleccion());    
    
                            set('frmCrearPeriodo.accion', 'modificarPeriodo');    
                            enviaSICC('frmCrearPeriodo');    
                   }   
          }
		  
 function onChangeCanal() {
          var oidCanal = get('frmCrearPeriodo.comboCanal', 'V');
          set('frmCrearPeriodo.hCanal', oidCanal); 
          if (oidCanal != '') {
			  set('frmCrearPeriodo.hIdioma', 1);
                    var array = new Array();
                    array[0] = new Array('oid',oidCanal);
                    array[1] = new Array('oidIdioma',get('frmCrearPeriodo.hIdioma'));
                                  
                    set_combo('frmCrearPeriodo.comboAcceso', arrayVacio());
                    recargaCombo('frmCrearPeriodo.comboAcceso',
                                                   'SEGObtieneAccesosPorCanal',
                                                   'es.indra.sicc.util.DTOOID',
                                                   array,
                                                   'setearcbAcceso(datos)');                   
                                      

          } else {
                    set_combo('frmCrearPeriodo.comboAcceso', arrayVacio());
                                      
          }
}
function arrayVacio(){  
    var array = new Array();              
         array[0] = new Array('','');
  
    return array;
}
function setearcbAcceso(datos) {
          var arrayNuevo = new Array();
          arrayNuevo[0] = new Array('','');
          arrayNuevo = arrayNuevo.concat(datos);
          set_combo('frmCrearPeriodo.comboAcceso',arrayNuevo);
}