              function onLoadPagina(){               
                 configurarMenuSecundario('frmContenido');   
                              fMostrarMensajeError();   
                 //si se esta recargando la pagina, se recargan los combos   
                 if( get( 'frmContenido.accion' )=='cargarCalendario' ){   
                                     var marca = get( 'frmContenido.hMarca' );   
                                     var canal = get( 'frmContenido.hCanal' );   
                                     var gruposZonas = get( 'frmContenido.hGrupoDeZona' );   
                                     var actividades = get( 'frmContenido.hActividad' );   
                                     var aMarca = new Array( marca );   
                                     var aCanal = new Array( canal );   
                                     var aGruposZonas = gruposZonas.split( ',' );   
                                     var aActividades = actividades.split( ',' );   
    
                                     set( 'frmContenido.cmbMarca', aMarca );   
                                     set( 'frmContenido.cmbCanal', aCanal );   
                                     set( 'frmContenido.cmbGruposZonas', aGruposZonas );   
                                     set( 'frmContenido.cmbActividades', aActividades );   
    
                   var a = makeParameter();   
                   recargaCombo('frmContenido.cmbGruposZonas', 'CRAObtieneGruposZonas', 'es.indra.sicc.dtos.cra.DTOGrupoZonas', a, 'asignarGZ(datos)' );   
                   recargaCombo('frmContenido.cmbActividades', 'CRAObtieneActividad', 'es.indra.sicc.dtos.cra.DTOActividad', a, 'asignarActividad(datos)' );
                   if (get('frmContenido.errCodigo')!=''){
                      btnProxy(1,0);
                   }

						 //Se redefine las funciones del calendario por falencias que el mismo presenta
						 //Establezco los anios para cada uno de los tres calendarios
						 //alert(document.all['mical0'].innerHTML);
						 mical.setAnno(parseInt(get('frmContenido.txtAnio'),10),true);
						 mical.setMes(1,true);
						 mical.display();

						 micalanterior.setAnno(parseInt(get('frmContenido.txtAnio'),10)-1,true);
						 //micalanterior.yM = parseInt(get('frmContenido.txtAnio'),10)-1;
						 micalanterior.setMes(12,true);
						 micalanterior.incrementaAnno=CalenAntIncr;
						 micalanterior.incrementaMes=CalenAntIncr;
						 micalanterior.display();

						 micalsiguiente.setAnno(parseInt(get('frmContenido.txtAnio'),10),true);
						 //micalsiguiente.ym = parseInt(get('frmContenido.txtAnio'),10)+1;
						 micalsiguiente.setMes(2,true);
						 micalsiguiente.decrementaAnno=CalenSigDecr;
						 micalsiguiente.decrementaMes=CalenSigDecr;
						 micalsiguiente.incrementaAnno=CalenSigIncrAnno;
						 micalsiguiente.incrementaMes=CalenSigIncrMes;
						 micalsiguiente.display();
						 //FIN DE: Se redefine las funciones del calendario por falencias que el mismo presenta
                 }                  
                 else{   
                     cargarMarcaCanalDefecto(); 
                     btnProxy(1,0);
                     //recargarCombosGruposZonasActividades();   
                 }   
					  if (get('frmContenido.hAnioCreado') != "") {
				    		accion('frmContenido.txtAnio','.disabled=true');
		               focaliza( 'frmContenido.cmbMarca' );   
					  } else {
	                 focaliza( 'frmContenido.txtAnio' );   
					  }
              }   
    
   		//Se redefine las funciones del calendario por falencias que el mismo presenta
			//Funciones agregadas para mantener la secuencialidad de los tres calendarios
			function CalenAntIncr() {
				if (mical.m == 1) {
					micalanterior.setMes(12);
					micalanterior.setAnno(mical.a - 1);
				} else {
					micalanterior.setAnno(mical.a);
					micalanterior.setMes(mical.m - 1);
				}
			}

			function CalenSigDecr() {
				if (mical.m == 12) {
					micalsiguiente.setAnno(mical.a + 1);
					micalsiguiente.setMes(1);
				} else {
					micalsiguiente.setAnno(mical.a);
					micalsiguiente.setMes(mical.m + 1);
				}
			}

			function CalenSigIncrAnno() {
				if (mical.m == 12) {
					if ((mical.yM - 1) == mical.a) {
						micalsiguiente.setMes(2);
					} else {
						micalsiguiente.setMes(mical.m + 1);
					}
					micalsiguiente.setAnno(mical.a + 1);
				} else {
					micalsiguiente.setAnno(mical.a);
					micalsiguiente.setMes(mical.m + 1);
				}
			}

			function CalenSigIncrMes() {
				if (mical.m == 12) {
					micalsiguiente.setAnno(mical.a + 1);
					micalsiguiente.setMes(1);
				} else {
					micalsiguiente.setMes(mical.m + 1);
					micalsiguiente.setAnno(mical.a);
				}
			}
   		//FIN DE: Se redefine las funciones del calendario por falencias que el mismo presenta

          function cargarMarcaCanalDefecto(){   
            var marcaDefecto = get( 'frmContenido.hMarcaDefecto' );   
            var canalDefecto = get( 'frmContenido.hCanalDefecto' );   
            var aMarca = new Array( marcaDefecto );   
            var aCanal = new Array( canalDefecto );   
    
            //if( get( 'frmContenido.accion' ) == 'muestraModificacion' ){   
              set( 'frmContenido.cmbMarca', aMarca );   
              set( 'frmContenido.cmbCanal', aCanal );   
              changeComboMarcaCanal();   
            //}   
          }   
    
              function asignarGZ( datos ){   
                 //alert( 'todos los gz: ' + datos );   
                 //set( 'frmContenido.cmbGruposZonas', datos );   
    
                 var gruposZonas = get( 'frmContenido.hGrupoDeZona' );   
                 var aGruposZonas = gruposZonas.split( ',' );   
    
                 set_combo( 'frmContenido.cmbGruposZonas', datos, aGruposZonas );   
              }   
    
              function asignarActividad( datos ){   
                 //alert( 'todas las actividades: ' + datos );   
                 //set( 'frmContenido.cmbActividades', datos );   
    
                 var actividades = get( 'frmContenido.hActividad' );   
                 var aActividades = actividades.split( ',' );   
    
                 set_combo( 'frmContenido.cmbActividades', datos, aActividades );   
              }   
    
              function changeComboMarcaCanal(){   
                   if (get('frmContenido.cmbMarca')!='' && get('frmContenido.cmbCanal')!=''){   
                       recargarCombosGruposZonasActividades();   
                   }   
              }   
    
              function recargarCombosGruposZonasActividades(){   
                 var a = makeParameter();   
                 recargaCombo('frmContenido.cmbGruposZonas', 'CRAObtieneGruposZonas', 'es.indra.sicc.dtos.cra.DTOGrupoZonas', a );   
                                 
                 recargaCombo('frmContenido.cmbActividades', 'CRAObtieneActividad', 'es.indra.sicc.dtos.cra.DTOActividad', a );   
              }   
             
              function makeParameter(){   
                 var marca = get( 'frmContenido.cmbMarca' );   
                 var canal = get( 'frmContenido.cmbCanal' );   
                 var pais = get( 'frmContenido.hPais' );   
                 var idioma = get( 'frmContenido.hIdioma' );   
                 var programa = get( 'frmContenido.hPrograma' );   
                 var IPCliente = get( 'frmContenido.hIPCliente' );   
    
                 var array = new Array();   
                 var i=0;   
    
                 array[i] = new Array('oidMarca', marca);   
                 i++;   
                    
                 array[i] = new Array('oidCanal', canal);   
                 i++;   
        
                 array[i] = new Array('oidPais', pais);   
                 i++;   
                    
                 array[i] = new Array('oidIdioma', idioma);   
                 i++;   
        
                 array[i] = new Array('programa', programa);   
                 i++;   
        
                 array[i] = new Array('ipCliente', IPCliente);   
                    
                 return array;   
              }   
    
              function accionCargaCalendario(){   
            if(!sicc_validaciones_generales()){   
            return false;   
            }   
                                     //validar campos   
                                     if( fValidarCTEXT( 'frmContenido.txtAnio' ) &&   
                                     fValidarCOMBO( 'frmContenido.cmbMarca' ) &&   
                                     fValidarCOMBO( 'frmContenido.cmbCanal' ) &&   
                                     fValidarCOMBO( 'frmContenido.cmbGruposZonas' ) ){   
                                              if( esNumero( get( 'frmContenido.txtAnio' ) )=='OK' ){   
                                                       copiarHiddens();   
                                                       set( 'frmContenido.accion', 'cargarCalendario' );   
                                                       //set( 'frmContenido.hCasoDeUso', 'Modificar' );   
                                                       set( 'frmContenido.conectorAction', 'LPMantieneCalendario' );   
                                                       enviaSICC( 'frmContenido' );   
                                              }   
                                              else{   
                                                       GestionarMensaje( '2555' );   
                                              }   
                                     }   
              }   
    
              function fGuardar(){   
            if(!sicc_validaciones_generales()){   
            return false;   
            }   
                                     //validar campos   
                                     if( fValidarCTEXT( 'frmContenido.txtAnio' ) &&   
                                     fValidarCOMBO( 'frmContenido.cmbMarca' ) &&   
                                     fValidarCOMBO( 'frmContenido.cmbCanal' ) &&   
                                     fValidarCOMBO( 'frmContenido.cmbGruposZonas' ) ){   
    
                                              if( esNumero( get( 'frmContenido.txtAnio' ) )=='OK' ){   
                                                       copiarHiddens();   
    
                                                       // Se obtiene la lista de festivos seleccionados y se guarda en    
                                                       // un VAR para mandar a la LP Modificar.   
                                                       set('frmContenido.listaFestivos', listaDeFestivos());   
                                                       set('frmContenido.listaTipoFestivos', listaTipoFestivos());   

													   set( 'frmContenido.conectorAction', 'LPMantieneCalendario' );   
                                                       set( 'frmContenido.accion', 'modificar' );   
                                                       enviaSICC( 'frmContenido' );   
                                              }   
                                              else{   
                                                       GestionarMensaje( '2555' );   
                                              }   
                                     }   
              }   
    
              function copiarHiddens(){   
                 set( 'frmContenido.hMarca', get( 'frmContenido.cmbMarca' ) );   
                 set( 'frmContenido.hCanal', get( 'frmContenido.cmbCanal' ) );   
                 set( 'frmContenido.hActividad', get( 'frmContenido.cmbActividades' ) );   
                 set( 'frmContenido.hGrupoDeZona', get( 'frmContenido.cmbGruposZonas' ) );   
              }   
    
              function listaDeFestivos() {   
                 var strFechasFestivos = '';   
                                    
                 for(var i = 0; i < mical.festivos.longitud; i++) {   
                   strFechasFestivos += mical.festivos.ij(i,0);  // Dia   
                   strFechasFestivos += '/' + mical.festivos.ij(i,1); // Mes   
                   strFechasFestivos += '/' + mical.festivos.ij(i,2); // Anio   
                   strFechasFestivos += '|';   
                 }   
                 return strFechasFestivos;   
              }   
    
              function listaTipoFestivos(){   
                 //El siguiente sera un string separado por pipes que contendra   
                 //si es laborable ( DON ), o festivo ( F ).   
                 var strTiposFestivos = '';    
    
                 for(var i = 0; i < mical.festivos.longitud; i++) {   
                   strTiposFestivos += mical.festivos.ij(i,3);   
                   strTiposFestivos += '|';   
                 }   
                 return strTiposFestivos;   
              }   
    

              /*
			  * Cuando se pulsa sobre un día del calendario se produce este evento. El proceso a realizar es el siguiente: 
			  * - Si el día es LABORABLE pasa a ser FESTIVO (rojo) 
			  * - Si el día es FESTIVO (rojo) pasa a ser NO LABORABLE (azul)
			  * - Si el día es NO LABORABLE (azul) pasa a ser LABORABLE
			  * Segun Incidencia 6615.
			  */
              function diaOnClick() {   
                 var caso = get('frmContenido.hCasoDeUso') ;   
    
						//alert(document.all['micalsiguiente0'].childNodes(10).innerHTML);
						//alert(mical.addFestivo);

                 if(caso == 'Modificar') {   
                   var d, m, a;   
    
                   d  = mical.getDiaSeleccionado();   
                   m  = mical.getMes();   
                   a  = mical.getAnno();   
    
                   if (a == get('frmContenido.txtAnio')) {   
                     var idFest = mical.getFestivoID(d,m,a);   

                     if ( idFest == '' ) { 
								// - Si el día es LABORABLE pasa a ser FESTIVO (rojo)
								mical.addFestivo(d,m,a,'F');   
                     }   
                     else if ( idFest == 'F' ) { 
								// - Si el día es FESTIVO (rojo) pasa a ser NO LABORABLE (azul)
								mical.delFestivo(d,m,a);   
								mical.addFestivo(d,m,a,'DON');   
								//Parche por falencia del calendario
								//no deja bien seteado el no laborable en los calendarios anterior y siguiente
								var arNoL = new Array();
								arNoL[0] = d;
								arNoL[1] = m;
								arNoL[2] = a;
								arNoL[3] = 'DON';
								micalsiguiente.delFestivo(d,m,a);
								micalsiguiente.festivos[micalsiguiente.festivos.length] = arNoL;
								micalanterior.delFestivo(d,m,a);
								micalanterior.festivos[micalanterior.festivos.length] = arNoL;
                     }   
                     else{ 
								// Si el día es NO LABORABLE (azul) pasa a ser LABORABLE
								mical.delFestivo(d,m,a);   
								micalsiguiente.delFestivo(d,m,a);
								micalanterior.delFestivo(d,m,a);
                     }   

                     //repintar el calendario   
                     mical.display();   
                   }   
                 }   
              }   
    
              function fLimpiar(){   
                 var aMarca = new Array( get( 'frmContenido.hMarcaDefecto' ) );   
                 var aCanal = new Array( get( 'frmContenido.hCanalDefecto' ) );   
                 set( 'frmContenido.cmbMarca', aMarca );   
                 set( 'frmContenido.cmbCanal', aCanal );   
                 set( 'frmContenido.txtAnio', '' );   
                 changeComboMarcaCanal();
					  if (get('frmContenido.hAnioCreado') != "") {
		               focaliza( 'frmContenido.cmbMarca' );   
					  } else {
	                 focaliza( 'frmContenido.txtAnio' );   
					  }
              }   

				  function tabCmbActividades() {
		           focalizaBotonHTML('botonContenido','btnCargarCalendario');
				  }

				  function shTabCmbMarca() {
					  if (get('frmContenido.hAnioCreado') != "") {
			           focalizaBotonHTML('botonContenido','btnCargarCalendario');
					  } else {
	                 focaliza('frmContenido.txtAnio');   
					  }
				  }
            
				  function tabBoton() {
					  if (get('frmContenido.hAnioCreado') != "") {
	                 focaliza('frmContenido.cmbMarca');   
					  } else {
	                 focaliza('frmContenido.txtAnio');   
					  }
				  }
