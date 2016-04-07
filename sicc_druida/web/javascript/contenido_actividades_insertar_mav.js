			var form = 'frmInsertarActividades.';
			var elementos = new Array('txtDescripcionActividad', 'areatxtObservaciones', 'cbMarca', 'cbCanal', 'cbTipoCliente',
							'cbTipoOferta', 'cbCicloVida', 'cbTipoDespacho', 'cbEnvioSolicitud', 'cbTipoSolicitudOrigen',
							'cbTipoSolicitudDestino', 'cbTipoPosicionEnvio', 'cbSubtipoPosicionEnvio', 'cbSubtipoCliente',
							'cbEstado', 'cbCondicionPago', 'cbFormaPago', 'cbCriterioAsignacion', 'cbCampana', 
							'FacturaIntercompanias', 'txtCosto', 'cbRazonSocialFactura', 'txtRazonSocialF',
							'cbTipoSolicitudPago', 'cbTipoPosicionPago', 'cbSubtipoPosicionPago');
			
			function onLoad()
			{
					fMostrarMensajeError();
					configurarMenuSecundario('frmInsertarActividades');
//					alert('Accion: ' + get(form + 'accion') + ' CasoDeUso: ' + get(form + 'casodeuso') + ' X15');
					accion(form + 'txtRazonSocialF' , '.readOnly=true');
//					if( get(form + 'accion') == 'detalle' || get(form + 'accion') == 'modificar' ){
					if( get(form + 'casodeuso') == 'consultar' || get(form + 'casodeuso') == 'eliminar' ){
						setear();
//						canalOnChange();
						deshabilitarTodos();
					}

					// sapaza -- PER-SiCC-2010-0578 -- 06/10/2010
  				  // Deshabilita combo Forma de Pago (by ssantana, 19/11/2004, x inc. 10411).
					//accion(form + 'cbFormaPago', ".disabled=true");

					if( get(form + 'casodeuso') == 'modificar' ){
						setear();
						tipoDespachoOnChange();
						canalOnChange();
						tipoClienteOnChange();
						condicionPagoOnChange();

						// Agregado x ssantana, 11/12/2004.
						cargaCombo('cbEnvioSolicitud', 'envioConSolicitud' );

						focaliza(form + elementos[0]);
						if( get(form + 'cbTipoPosicionEnvio') == '' ){
							deshabilitar('cbSubtipoPosicionEnvio');
						}
						if( get(form + 'cbTipoPosicionPago') == '' ){
							deshabilitar('cbSubtipoPosicionPago');
						}	

					}

					if( get(form + 'casodeuso') == 'insertar' ){
						set(form + 'FacturaIntercompanias', 'N');
						deshabilitar('txtCosto');
						deshabilitar('cbTipoSolicitudOrigen');
						deshabilitar('cbTipoOferta');
						deshabilitar('cbTipoSolicitudDestino');
						deshabilitar('cbEnvioSolicitud');
						deshabilitar('cbTipoPosicionEnvio');
						deshabilitar('cbSubtipoCliente');
						deshabilitar('cbRazonSocialFactura');
						deshabilitar('cbTipoSolicitudPago');
						deshabilitar('cbTipoPosicionPago');
						deshabilitar('cbSubtipoPosicionEnvio');
						setRequerido('cbSubtipoPosicionEnvio', false);
						
						set(form + 'cbSubtipoPosicionPago', '');
						deshabilitar('cbSubtipoPosicionPago');
						setRequerido('cbSubtipoPosicionPago', false);

//						deshabilitar('cbSubtipoPosicionEnvio');
						focaliza(form + elementos[0]);
					}
			}

			function fGuardar()
			{
				set(form + "accion", "guardar");
				if(!sicc_validaciones_generales()){
					return false;
				}				

				// Modificacion x ssantana, inc. 10974
				// Si se seleccionó "" en Solicitud Origen, se toman TODOS los valores del combo. 
				// (Solamente si está habilitada la opción "Por solicitud" o "Por Pedido de Servicio")
				var tipoDespacho = get(form + "cbTipoDespacho");



//				var arrayDespachos = obtieneArrayDespachos(tipoDespacho); // Parseo la cadena con los Tipos de Despacho.

				// Ahora recorro el array de Tipos de Despacho
				for ( var i = 0; i < tipoDespacho.length; i++ )
				{
						var despachoActual = tipoDespacho[i];
						if ( despachoActual == 1 || despachoActual == 2)
						{
								var valorCombo = get(form + "cbTipoSolicitudOrigen");
								var cadenaOrigen = "";
								if (valorCombo == "")
									cadenaOrigen = obtieneValoresTipoSolicitudOrigen();
								else
								{
									for (var i = 0; i < valorCombo.length; i++)
									{
										if ( i != 0)
											cadenaOrigen = cadenaOrigen + "|";

										cadenaOrigen = cadenaOrigen + valorCombo[i];
									 }

								}
									
								set(form + "tipoSolicitudOrigen", cadenaOrigen);
						 } else
						 {
								set(form + "tipoSolicitudOrigen", "");
					 	 }

				}

				/*
				 * 23115 - dmorello, 09/05/2006
				 * Asigno a la variable subtiposCliente un String con los OIDs de subtipos seleccionados
				 * (o todos si está seleccionada la opción en blanco)
				 */
				var comboSubtiposCliente = form + 'cbSubtipoCliente';
				var subtiposCliente = "";
				if (get(comboSubtiposCliente) == '') {
					var longitud = combo_get(comboSubtiposCliente,'L');
					// Comienzo desde 1 ya que la primera posición corresponde a la opción en blanco
					for (var i = 1; i < longitud; ) {
						var subtipo = combo_get(comboSubtiposCliente,'V',i);
						subtiposCliente += subtipo;
						if (++i < longitud) {
							subtiposCliente += '|';
						}
					}
				} else {
					var seleccionados = get(comboSubtiposCliente).toString().split(',');
					for (var i = 0; i < seleccionados.length; ) {
						var subtipo = seleccionados[i];
						subtiposCliente += subtipo;
						if (++i < seleccionados.length) {
							subtiposCliente += '|';
						}
					}
				}
				set(form + 'subtiposCliente', subtiposCliente);
				/* Fin 23115 dmorello 09/05/2006 */

				
				//alert("TipoSolic: " + get(form + "tipoSolicitudOrigen") );
				enviaSICC("frmInsertarActividades");
			}


			// Modificacion x ssantana, inc. 10974
			// Se toman TODOS los valores (oids) del combo Tipo Solicitud Origen.
			function obtieneValoresTipoSolicitudOrigen()
			{

					var longCombo = combo_get("frmInsertarActividades.cbTipoSolicitudOrigen", "L", "");
					var cadena = "";

					for (var i = 1; i < longCombo; i++) 	
					{
						if ( i != 1)
							cadena = cadena + "|";

						cadena = cadena + combo_get("frmInsertarActividades.cbTipoSolicitudOrigen", "V", i);
					}

					return cadena;

			}



			// by Ssantana, 19/11/2004
			// Modif. x incidencia 10411
			function condicionPagoOnChange()
			{
					var valorCombo = get(form + "cbCondicionPago");
					if ( valorCombo == 1)
					{
						var arrayVacio = ["",""];
						
						// sapaza -- PER-SiCC-2010-0578 -- 06/10/2010
						//set_combo(form + "cbFormaPago", arrayVacio);
						accion(form + 'cbFormaPago', ".disabled=false");
						//set( form + "cbFormaPago", new Array("") );

						if (get(form + 'casodeuso') == 'insertar') {
							var oidFormaPagoGratis = get(form + 'oidFormaPagoGratis')
							set( form + "cbFormaPago", new Array(oidFormaPagoGratis) );
						}	
												
						setRequerido('cbFormaPago', false);					
						setMV(form + "cbFormaPago","c");
						
					} else if ( valorCombo == 2)
					{
						// sapaza -- PER-SiCC-2010-0578 -- 06/10/2010
						if (get(form + 'casodeuso') == 'insertar') {
							set( form + "cbFormaPago", new Array("") );
						}	
						
						accion(form + 'cbFormaPago', ".disabled=false");
						setRequerido('cbFormaPago', true);			
						setMV(form + "cbFormaPago","C"); 
					} else if ( valorCombo == "")
					{
						accion(form + 'cbFormaPago', ".disabled=true");
						set( form + "cbFormaPago", new Array("") );							
						setRequerido('cbFormaPago', false);					
					}

			}


                                                                
			function canalOnChange(){
				var elemento = 'cbTipoOferta';
				var varOculto = 'tipoOferta';
				var retorno = recargaCombo(form + 'cbTipoOferta', 'PREObtenerTiposOfertaPorCanal', 'es.indra.sicc.util.DTOOID', 
							[['oid', get(form + 'cbCanal')], ['oidIdioma', get(form + 'oidIdioma')]], 'tipoOferta(datos)' ); 
			}	

			function agregaBlanco(datos){
				var datosMasBlanco = new Array(datos.length + 1);
				datosMasBlanco[0] = new Array('', '');
				for(i = 0; i < datos.length; i++){
					datosMasBlanco[i+1] = new Array(2);
					datosMasBlanco[i+1][0] = datos[i][0];
					datosMasBlanco[i+1][1] = datos[i][1];
				}
				return datosMasBlanco;
			}
			

			function tipoOferta(datos){
				var datosMasBlanco = agregaBlanco(datos);
				set_combo(form + 'cbTipoOferta', datosMasBlanco);
				set(form + 'cbTipoOferta', '');
				cargaCombo('cbTipoOferta', 'tipoOferta');
				habilitar('cbTipoOferta');
				recargaCombos();
			}


			function cambiaRadioB(valor){
				if(valor == 'S'){
					set(form + 'FacturaIntercompanias', 'S');
					habilitar('txtCosto');
					habilitar('cbRazonSocialFactura');
					setRequerido('cbRazonSocialFactura', true);					
					setRequerido('txtRazonSocialF', true);

					habilitar('cbTipoSolicitudPago');
					setRequerido('cbTipoSolicitudPago', true);

					habilitar('cbTipoPosicionPago');
					setRequerido('cbTipoPosicionPago', true);

//					habilitar('cbSubtipoPosicionPago');

				} else {
					set(form + 'FacturaIntercompanias', 'N');
					set(form + 'txtCosto', '');
					deshabilitar('txtCosto');

					set(form + 'cbRazonSocialFactura', '');
					deshabilitar('cbRazonSocialFactura');
					setRequerido('cbRazonSocialFactura', false);

					set(form + 'txtRazonSocialF', '');
					set(form + 'oidCliente', '');
					setRequerido('txtRazonSocialF', false);

					set(form + 'cbTipoSolicitudPago', '');
					deshabilitar('cbTipoSolicitudPago');
					setRequerido('cbTipoSolicitudPago', false);

					set(form + 'cbTipoPosicionPago', '');
					deshabilitar('cbTipoPosicionPago');
					setRequerido('cbTipoPosicionPago', false);

					set(form + 'cbSubtipoPosicionPago', '');
					deshabilitar('cbSubtipoPosicionPago');
					setRequerido('cbSubtipoPosicionPago', false);
				}
			}


			function tipoDespachoOnChange(){
//				alert("Seleccion " + get(form + 'cbTipoDespacho'));
				var seleccionados = get(form + 'cbTipoDespacho');
				var cantSelecciones = seleccionados.length;

				set(form + 'cbEnvioSolicitud', '');
				set(form + 'cbTipoSolicitudOrigen', '');
				set(form + 'cbTipoSolicitudDestino', '');
				set(form + 'cbTipoPosicionEnvio', '');

				deshabilitar('cbEnvioSolicitud');

				deshabilitar('cbTipoSolicitudOrigen');
				setRequerido('cbTipoSolicitudOrigen', false);

				deshabilitar('cbTipoSolicitudDestino');
				setRequerido('cbTipoSolicitudDestino', false);

				deshabilitar('cbTipoPosicionEnvio');
				setRequerido('cbTipoPosicionEnvio', false);

				deshabilitar('cbSubtipoPosicionEnvio');
				setRequerido('cbSubtipoPosicionEnvio', false);
				
				for(var i=0; i < cantSelecciones; i++ ){
					if( seleccionados[i] == 1 ){
						habilitar('cbEnvioSolicitud');
						habilitar('cbTipoSolicitudOrigen');
						//setRequerido('cbTipoSolicitudOrigen', true);
					}
					if( seleccionados[i] == 2 ){
						habilitar('cbTipoSolicitudOrigen');
						//setRequerido('cbTipoSolicitudOrigen', true);
					}
					if( seleccionados[i] == 3 || seleccionados[i] == 4 ){
						habilitar('cbTipoSolicitudDestino');
						setRequerido('cbTipoSolicitudDestino', true);
						habilitar('cbTipoPosicionEnvio');						
						setRequerido('cbTipoPosicionEnvio', true);
						habilitar('cbSubtipoPosicionEnvio');						
						setRequerido('cbSubtipoPosicionEnvio', true);
					}

				}
			}			

			function prueba(datos){
					var datosNuevo = new Array();
					datosNuevo[0] = ["",""];
					for (var i = 0; i < datos.length; i++ )
						 datosNuevo[i+1]  = datos[i];
					set_combo("frmInsertarActividades.cbSubtipoCliente", datosNuevo);
					//set("frmInsertarActividades.cbSubtipoCliente","");

					// Modificado por ssantana, 11/12/2004, para que marque los valores corresp. en cbSubtipoCliente
					// a partir de lo levantado de la base (en la modificacion).
					cargaCombo('cbSubtipoCliente', 'subtipoCliente' );

			}

			function tipoClienteOnChange(){
				if( get(form + 'cbTipoCliente') != '' )
				{
					recargaCombo(form + 'cbSubtipoCliente', 'MAEobtenerSubtipos', 'es.indra.sicc.util.DTOOID',  [['oid', get(form + 'cbTipoCliente')], ['oidIdioma', get(form + 'oidIdioma')]], "prueba(datos)"); 
					habilitar('cbSubtipoCliente');
					// 23024 - dmorello, 25/04/2006: El campo Subtipo cliente NO ES OBLIGATORIO
					//setRequerido('cbSubtipoCliente', true);
					//if( get(form + 'casodeuso') != 'modificar' && get(form + 'casodeuso') != 'insertar'){ 
					if( get(form + 'casodeuso') != 'insertar'){ 
						cargaCombo('cbSubtipoCliente', 'subtipoCliente');
					}
				}
				else{
					deshabilitar('cbSubtipoCliente');
					setRequerido('cbSubtipoCliente', false);
					set_combo(form + 'cbSubtipoCliente', ['','']);
				}

				if( get(form + 'casodeuso') != 'modificar' ){
						recargaCombos();				
				}
			}
			

			function accionBuscarClientes(){
				if( get(form + 'casodeuso') == 'consultar' || get(form + 'casodeuso') == 'eliminar') return;
				var boton = get(form + 'FacturaIntercompanias');
				if( boton != 'N' && boton != '' && boton != null ){
					// lpDestino, accion, objParams, null, null		
					var obj = new Object();
					var winModal = mostrarModalSICC('LPBusquedaRapidaCliente', '', obj, null, 595);
					if( winModal != null && winModal[0] != '' ){
						codigo = new Number(winModal[1]);
						set(form + 'txtRazonSocialF', codigo);
						set(form + 'oidCliente', winModal[0]);
					} 
				}
			}


			function setear(){
				cargaCombo('cbMarca', 'marca');
				cargaCombo('cbCanal', 'canal');
				cargaCombo('cbTipoCliente', 'tipoCliente' );
				cargaCombo('cbTipoOferta', 'tipoOferta');
				cargaCombo('cbCicloVida', 'cicloVida' );
				cargaCombo('cbTipoDespacho', 'tipoDespacho' );
				//alert( get("frmInsertarActividades.envioConSolicitud") );
				cargaCombo('cbEnvioSolicitud', 'envioConSolicitud' );
				cargaCombo('cbTipoSolicitudOrigen', 'tipoSolicitudOrigen' );
				cargaCombo('cbTipoSolicitudDestino', 'tipoSolicitudDestino' );
				cargaCombo('cbTipoPosicionEnvio', 'tipoPosicionEnvio' );
				cargaCombo('cbSubtipoPosicionEnvio', 'subtipoPosicionEnvio' );
				cargaCombo('cbSubtipoCliente', 'subtipoCliente' );
				cargaCombo('cbEstado', 'estados' );
				cargaCombo('cbCondicionPago', 'condicionPago' );
				cargaCombo('cbFormaPago', 'formaPago' );
				cargaCombo('cbCriterioAsignacion', 'criterioAsignacion' );
				
				cargaCampaniaEvaluacion(get(form + 'campagnaEvaluacion'));
				
				if( get(form + 'isFacturaIntercompanias') == 'true' ){
					set(form + 'FacturaIntercompanias', 'S');
					cambiaRadioB("S");
				}else{
					set(form + 'FacturaIntercompanias', 'N');
					cambiaRadioB("N");
				}

				cargaCombo('cbRazonSocialFactura', 'razonSocialQueFactura' );
				cargaCombo('cbTipoSolicitudPago', 'tipoSolicitudParaPago' );
				cargaCombo('cbTipoPosicionPago', 'tipoPosicionParaPago' );
				cargaCombo('cbSubtipoPosicionPago', 'subtipoPosicionPago' );
			}	


			// Carga los combos a partir de una variable oculta que contiene
			// los valores separados por '|'.  En realidad el combo ya esta 
			// cargado, lo que hace es dejar solamente los valores que figuren
			// en la oculta, eliminando el resto.
			// EL flag indica si se eliminaran los demas o no.  Si es 0 los eli-
			// mina, en caso contrario, solo selecciona los de la variable ocul-
			// y deja el resto.			
			function cargaCombo(nombreCombo, variableOculta ){
				var nuevosValores = new Array();
				var seleccion = new Array();
	
				combo = form + nombreCombo;
				var valores = get(form + variableOculta);
					//alert(variableOculta + ": " + valores);
				if( valores == '' ){
					set(form + nombreCombo, '');
//					deshabilitar(nombreCombo);
					return;
				}
				var valoresSeparados = valores.split('|');
//				if( variableOculta == 'tipoDespacho' )
//					alert("ValoresSeparados: " + valoresSeparados);
				for(i=0, j=0; i < valoresSeparados.length; i++){
					if( valoresSeparados[i] != '' ){
						seleccion[j] = valoresSeparados[i];
						j++;
					}
				}

				if(seleccion.length > 0){
					set(combo, seleccion);
				}
			}


			function cargaCampaniaEvaluacion(valor){
				if( valor == '' ){
					valorFormateado = '+9';
				}else{
					if( valor > 0 ){
						valorFormateado = new String('+' + valor);
					}else{
						valorFormateado = new String(valor);			
					}
				}
				var seleccion = new Array(valorFormateado);				
				set(form + 'cbCampana', seleccion);
			}

			// Funcion que setea un campo como requerido o no, dependiendo
			// de la variable booleana esRequerido.
			// Parametros de entrada: 
			// campo es el elemento que se seteará como requerido o no, el mismo
			// no debe incluir el nombre del formulario.
			// esRequerido, es un valor booleano que indica si el elemento sera
			// requerido o no.
			function setRequerido(campo, esRequerido){
				if( campo == null ) return;
				if( esRequerido != true && esRequerido != false ){
					return;
				}
				for(var i=0; i < objValidacionSICC.length; i++){
					if(objValidacionSICC[i].nombre == campo){
						objValidacionSICC[i].requerido = esRequerido;
						return;
					}
				}
				return;
			}

			function deshabilitarTodos(){
				deshabilitar('txtDescripcionActividad');
				deshabilitar('areatxtObservaciones');
				deshabilitar('cbMarca');
				deshabilitar('cbCanal');
				deshabilitar('cbTipoCliente');
				accion(form + 'cbTipoOferta' , '.readOnly=true');
//				deshabilitar('cbCicloVida');
				accion(form + 'cbCicloVida' , '.readOnly=true');
//				deshabilitar('cbTipoDespacho');
				accion(form + 'cbTipoDespacho' , '.readOnly=true');
				deshabilitar('cbEnvioSolicitud');
//				deshabilitar('cbTipoSolicitudOrigen');
				accion(form + 'cbTipoSolicitudOrigen' , '.readOnly=true');
				deshabilitar('cbTipoSolicitudDestino');
				deshabilitar('cbTipoPosicionEnvio');
				deshabilitar('cbSubtipoPosicionEnvio');
//				deshabilitar('cbSubtipoCliente');
				accion(form + 'cbSubtipoCliente' , '.readOnly=true');
//				deshabilitar('cbEstado');
				accion(form + 'cbEstado' , '.readOnly=true');
				deshabilitar('cbCondicionPago');
				deshabilitar('cbFormaPago');
//				deshabilitar('cbCriterioAsignacion');
				accion(form + 'cbCriterioAsignacion' , '.readOnly=true');
				deshabilitar('cbCampana');
				
				document.all.FacturaIntercompanias[1].disabled='true';
				document.all.FacturaIntercompanias[0].disabled='true';

				deshabilitar('txtCosto');
				deshabilitar('cbRazonSocialFactura');
				deshabilitar('cbTipoSolicitudPago');
				deshabilitar('cbTipoPosicionPago');
				deshabilitar('cbSubtipoPosicionPago');
			}

/*			function cargaSubTipoCliente(){
				var valores = new Array();
				posc = 0;
				var CantElemListSubtipoCliente = lstSubtipoCliente.datos.longitud;
				for(i=0; i < CantElemListSubtipoCliente; i++){
					valores[posc] = [lstSubtipoCliente.datos.ij(i,0),lstSubtipoCliente.datos.ij(i,2)];
					posc++;
				}
				set_combo(form + 'cbSubtipoCliente', valores);
			}*/

			function fLimpiar(){
				focaliza(form + elementos[0]);
				if( get(form + 'accion') == 'detalle' || get(form + 'accion') == 'modificar' ){
					setear();
					canalOnChange(); 
					cargaCombo('cbSubtipoCliente', 'subtipoCliente' );
					cargaCombo('cbEnvioSolicitud', 'envioConSolicitud' );
					cargaCombo('cbTipoSolicitudOrigen', 'tipoSolicitudOrigen' );
					cargaCombo('cbTipoSolicitudDestino', 'tipoSolicitudDestino' );
					cargaCombo('cbTipoPosicionEnvio', 'tipoPosicionDestino' );
					cambiaRadioB(get(form + 'isFacturaIntercompanias'));
				
					if(get(form + 'accion') == 'modificar'){
						set(form + 'oidCliente', get(form + 'oidClienteAnterior'));
					}
				}else{
					borrarTodo();				
				}
			}

			function deshabilitar(elemento){
				accion(form + elemento , '.disabled=true');
			}

			function habilitar(elemento){
				accion(form + elemento , '.disabled=false');
			}

			function borrarTodo(){
				for(i=0; i < elementos.length; i++){
					if(elementos[i] != 'cbCampana'){
						set(form + elementos[i], '' );
					}					
				}				
				
				set(form + 'txtRazonSocialF', '');
				set(form + 'oidCliente', '');
				deshabilitar('cbEnvioSolicitud');
				deshabilitar('cbTipoSolicitudOrigen');
				deshabilitar('cbTipoSolicitudDestino');
				deshabilitar('cbTipoPosicionEnvio');
				
				deshabilitar('txtCosto');
				deshabilitar('cbRazonSocialFactura');
				deshabilitar('txtRazonSocialF');
				deshabilitar('cbTipoSolicitudPago');
				deshabilitar('cbTipoPosicionPago');
				
			}

			function fVolver(){
				if( get(form + 'accion') != 'insertar' )
					window.close();
			}

/*			function tipoOfertaOnchange(){
				cargaCombo('cbTipoOferta', 'tipoOferta');
			}*/

			function marcaOnChange(){
				recargaCombos();
			}

			function tipoSolicitudDestinoOnChange(){
				if( get(form + 'cbTipoSolicitudDestino') != null ){
					recargaCombo(form + 'cbTipoPosicionEnvio', 'PEDObtieneTipoPosicionOperacion', 
						'es.indra.sicc.dtos.ped.DTOTipoPosicionOperacion', 
						[['oidTipoSolicitudPais', get(form + 'cbTipoSolicitudDestino')],
						['oidMarca', get(form + 'cbMarca')], ['oidCanal', get(form + 'cbCanal')],
						['oidIdioma', get(form + 'oidIdioma')],
						['oidTipoCliente', get(form + 'cbTipoCliente')], 
						['oidOperacion', get(form + 'operacionMAV012')]], 'tipoPosicionEnvio(datos)' ); 				
				}
			}

			function tipoPosicionEnvio(datos){
				seteo = agregaBlanco(datos);
//				alert("Seteando: " + seteo);
				set_combo(form + 'cbTipoPosicionEnvio', seteo);
//				alert("TipoPosicionEnvio: " + get(form + 'tipoPosicionEnvio'));
				cargaCombo('cbTipoPosicionEnvio', 'tipoPosicionEnvio');
				if( get(form + 'casodeuso') == 'modificar' ){
					tipoPosicionEnvioOnChange();
				}
			}

			function tipoPosicionEnvioOnChange()
			{
//				alert("Seteado a: " + get(form + 'cbTipoPosicionEnvio'));
				if( get(form + 'cbTipoPosicionEnvio') != '' )
				{
					habilitar('cbSubtipoPosicionEnvio');
					setRequerido(form + 'cbSubtipoPosicionEnvio', true);
					recargaCombo(form + 'cbSubtipoPosicionEnvio', 'PEDconsultaSubtiposTipo', 'es.indra.sicc.util.DTOOID', 
							[[ 'oid', get(form + 'cbTipoPosicionEnvio') ],
							[ 'oidIdioma', get(form + 'oidIdioma') ]] , 'subtipoPosicionEnvioCarga(datos)');
				} else
				{
					var arrayVacio = new Array();
					arrayVacio[0] = ["",""];

					set_combo(form + 'cbSubtipoPosicionEnvio', arrayVacio);
					set(form + 'cbSubtipoPosicionEnvio', new Array("") );
					deshabilitar('cbSubtipoPosicionEnvio');
					setRequerido(form + 'cbSubtipoPosicionEnvio', false);

				}

//				deshabilitar('cbSubtipoPosicionEnvio');
//				setRequerido(form + 'cbSubtipoPosicionEnvio', false);
			}

			function subtipoPosicionEnvioCarga(datos){
				seteo = cargaArray(datos);
				set_combo(form + 'cbSubtipoPosicionEnvio', seteo);
				cargaCombo('cbSubtipoPosicionEnvio', 'subtipoPosicionEnvio');				
			}

			function tipoSolicitudParaPagoOnChange(){
				if( get(form + 'cbTipoSolicitudPago') != '' ){
					recargaCombo(form + 'cbTipoPosicionPago', 'PEDObtieneTipoPosicionOperacion', 
							'es.indra.sicc.dtos.ped.DTOTipoPosicionOperacion', 
							[['oidTipoSolicitudPais', get(form + 'cbTipoSolicitudPago')],
							['oidMarca', get(form + 'cbMarca')], ['oidCanal', get(form + 'cbCanal')],
							['oidIdioma', get(form + 'oidIdioma')],
							['oidTipoCliente', get(form + 'cbTipoCliente')], 
							['oidOperacion', get(form + 'operacionMAV023')]], 'tipoPosicionPago(datos)' ); 
				} 
			}

			function tipoPosicionPago(datos){
				seteo = cargaArray(datos);
				set_combo(form + 'cbTipoPosicionPago', seteo);
				if( get(form + 'casodeuso') == 'modificar' ){
					cargaCombo('cbTipoPosicionPago', 'tipoPosicionParaPago');
					tipoPosicionParaPagoOnChange();
				}
			}

			function tipoPosicionParaPagoOnChange()
			{
					// Modif x ssantana, 27/11/2004. 
					// Si es vacío Tipo Posicion Pago, deshabilita subTipo Posicion Pago. 
					// Si no, lo recarga.
					if( get(form + 'cbTipoPosicionPago') != '' ){
						habilitar("cbSubtipoPosicionPago");
						recargaCombo(form + 'cbSubtipoPosicionPago', 'PEDconsultaSubtiposTipo', 'es.indra.sicc.util.DTOOID', 
							[[ 'oid', get(form + 'cbTipoPosicionPago')],
							[ 'oidIdioma', get(form + 'oidIdioma')]], 'subtipoPosicionPago(datos)' );
					} else   
					{
						var comboVacio = new Array();
						comboVacio[0] = ["", ""];
						set(form + "cbTipoPosicionPago", new Array("") );
						deshabilitar('cbSubtipoPosicionPago');

					}


			}
			
			function subtipoPosicionPago(datos){
				seteo = cargaArray(datos);
				set_combo(form + 'cbSubtipoPosicionPago', seteo);
				if( get(form + 'casodeuso') == 'modificar' )
					cargaCombo('cbSubtipoPosicionPago', 'subtipoPosicionPago');
			}

			function recargaCombos(){
				if( get(form + 'cbMarca') != '' && get(form + 'cbCanal') != '' && get(form + 'cbTipoCliente') != '' ){
					recargaCombo(form + 'cbTipoSolicitudOrigen', 'PEDObtieneTipoSolicitudOperacion', 
								'es.indra.sicc.dtos.ped.DTOTipoSolicitudOperacion', 
								[['oidMarca', get(form + 'cbMarca')], ['oidCanal', get(form + 'cbCanal')],
								['oidIdioma', get(form + 'oidIdioma')],
								['oidTipoCliente', get(form + 'cbTipoCliente')]], "tipoSolOrigenRecarga(datos)" );
					recargaCombo(form + 'cbTipoSolicitudDestino', 'PEDObtieneTipoSolicitudProceso',
								'es.indra.sicc.dtos.ped.DTOTipoSolicitudOperacion', 
								[['oidMarca', get(form + 'cbMarca')], ['oidCanal', get(form + 'cbCanal')],
								['oidTipoCliente', get(form + 'cbTipoCliente')],
								['oidIdioma', get(form + 'oidIdioma')],
								['oidOperacion', get(form + 'operacionMAV012')]], 'tipoSolicitudDestino(datos)' ); 
					recargaCombo(form + 'cbTipoSolicitudPago', 'PEDObtieneTipoSolicitudProceso', 
								'es.indra.sicc.dtos.ped.DTOTipoSolicitudOperacion', 
								[['oidMarca', get(form + 'cbMarca')], ['oidCanal', get(form + 'cbCanal')],
								['oidTipoCliente', get(form + 'cbTipoCliente')], 
								['oidIdioma', get(form + 'oidIdioma')],
								['oidOperacion', get(form + 'operacionMAV023')]], 'tipoSolicitudPago(datos)' ); 
				}
		
			}

			function tipoSolOrigenRecarga(datos)
			{

				seteo = cargaArray(datos);
				set_combo(form + 'cbTipoSolicitudOrigen', seteo);
				//alert("aaaaaaaaaaaa");
				var casoUso = get(form + 'casodeuso');
				var tipoDespacho = get(form + "cbTipoDespacho"); 
				cargaCombo('cbTipoSolicitudOrigen', 'tipoSolicitudOrigen' );
			}

			function tipoSolicitudDestino(datos){
				//alert("A");
				seteo = cargaArray(datos);
				set_combo(form + 'cbTipoSolicitudDestino', seteo);
				if( get(form + 'casodeuso') == 'modificar' )
				{
					//alert(" Tipo Solicitud Destino: " + get(form + 'tipoSolicitudDestino' ) );
					cargaCombo('cbTipoSolicitudDestino', 'tipoSolicitudDestino');
					tipoSolicitudDestinoOnChange();
				}
			}

			function tipoSolicitudPago(datos){
//				alert("B");
				seteo = cargaArray(datos);
				set_combo(form + 'cbTipoSolicitudPago', seteo);
				if( get(form + 'casodeuso') == 'modificar' ){
					cargaCombo('cbTipoSolicitudPago', 'tipoSolicitudParaPago');
					tipoSolicitudParaPagoOnChange();
				}
			}

			function cargaArray(datos){
				var seteo = new Array(datos.length + 1);
				seteo[0] = ['' , '']
				for(i = 0; i < datos.length; i++){
					seteo[i+1] = [ datos[i][0], datos[i][1] ]
				}
				return seteo;
			}

			function tab(elemento){
				try{
					for(i=0; i < elementos.length; i++){
						if( elementos[i] == elemento ){
							if( i == elementos.length - 1 ) i = 0;
							else i++;
							document.selection.empty();
							if( elementos[i] == 'FacturaIntercompanias' ){
								if( get(form + 'FacturaIntercompanias') == 'S' )
									document.all.FacturaIntercompanias[0].focus();
								else
									document.all.FacturaIntercompanias[1].focus();
							}else{
								if( elementos[i] == 'txtRazonSocialF' ) i++;
								focaliza(form + elementos[i]);								
							}
							return;
						}
					}
				}catch(e){
					tab(elementos[i]);
				}
			}

			function shtab(elemento){
				try{
					for(i=elementos.length - 1; i >= 0 ; i--){
						if( elementos[i] == elemento ){
							if( i == 0 ) i = elementos.length - 1;
							else i--;
							document.selection.empty();
							focaliza(form + elementos[i]);
							return;
						}
					}
				}catch(e){
					shtab(elementos[i]);
				}
			}
		
// -----------------------------------------------------------------------------------------------------------------------------------------------------------
function obtieneArrayDespachos(arrayDespachos)
{
		// Parsea string de formato "x,y,z..." y pone los valores en un array.
		var array = new Array();

		if ( arrayDespachos != "")
			array = arrayDespachos.split(",");

		return array;
}



function cerrarVentana(){
		window.returnValue = true;
}



function errorAlGuardar(){
	GestionarMensaje('50011', null, null, null);
}


/*   
 * 23024 - dmorello, 03/05/2006   
 * Se limpian los datos introducibles por pantalla para que el usuario realice una nueva inserción
 */ 
function limpiarDatos() {
	set(form + 'txtDescripcionActividad','');   
	set(form + 'areatxtObservaciones', '');   
	set(form + 'cbMarca', '');  
	set(form + 'cbCanal', '');
	set(form + 'cbTipoCliente', '');   
	set(form + 'cbCicloVida','');   
	set(form + 'cbTipoDespacho','');   

	set_combo(form + 'cbTipoSolicitudOrigen', new Array(""));
	deshabilitar('cbTipoSolicitudOrigen');

	set_combo(form + 'cbTipoSolicitudDestino', new Array(""));
	deshabilitar('cbTipoSolicitudDestino');

	set_combo(form + 'cbTipoPosicionEnvio', new Array(""));
	deshabilitar('cbTipoPosicionEnvio');

	set_combo(form + 'cbSubtipoPosicionEnvio', new Array(""));
	deshabilitar('cbSubtipoPosicionEnvio');

	set(form + 'cbEstado', '');

	set(form + 'cbCondicionPago', '');

	set(form + 'cbCriterioAsignacion', '');   
	// Asigno al combo cbCampana el primero de sus valores posibles, que es el que tenía al cargarse incialmente la página
	var primeraCampana = combo_get(form + 'cbCampana', 'V', 0);
	set(form + 'cbCampana', new Array(primeraCampana));

	set(form + 'FacturaIntercompanias', 'N');   

	condicionPagoOnChange();	// Con esto limpio el combo cbFormaPago   
	tipoClienteOnChange();		// Con esto limpio el combo Subtipo cliente   
	tipoDespachoOnChange();		// Con esto limpio el combo cbEnvioSolicitud   
	canalOnChange();			// Con esto limpio el combo múltiple cbTipoOferta   
	
	cambiaRadioB('N'); 

	// Recargo la página
	onLoad();
}