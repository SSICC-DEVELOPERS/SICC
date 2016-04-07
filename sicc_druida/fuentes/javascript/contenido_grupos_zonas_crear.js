      var oldSalir;     /*Incidencia 6590*/
      var oldSalirMenu; /*Incidencia 6590*/
      
       function inicia(){
          /*Incidencia 6590*/
            oldSalir = parent.frames["cabecera"].salirAplicacion;
            parent.frames["cabecera"].salirAplicacion=fSalirApp;
            oldSalirMenu=parent.frames["iconos"].foc_btnBarra3;
            parent.frames["iconos"].foc_btnBarra3=foc_btnBarra3;
          /*Incidencia 6590*/

		
		  for (var i= 0;i<objValidacionSICC.length ; i++)
		  {
				if (objValidacionSICC[i].nombre == 'txtNombreDeGrupo')
				{
					objValidacionSICC[i].caracteres = "a-z,A-Z, ,0-9,\\(,\\)";
				}
		  }
		   

            configurarMenuSecundario("frmInsertarGruposZonas");   
            accion('frmInsertarGruposZonas.cbRegion','.disabled=true');   
            accion('frmInsertarGruposZonas.cbZonasDisponibles','.disabled=true');   
            posicionarCombos();   
            recuperarValoresSiHay();   
            focaliza('frmInsertarGruposZonas.cbMarcas');
            
            mostrarCodigoError();             
       }   
    
       function recuperarValoresSiHay(){   
            set('frmInsertarGruposZonas.txtCodigoDeGrupo',get('frmInsertarGruposZonas.hCodigoDeGrupo'));   
            set('frmInsertarGruposZonas.txtNombreDeGrupo',get('frmInsertarGruposZonas.hNombreDeGrupo'));   
            if (get('frmInsertarGruposZonas.hZonasSeleccionadas')!=''){   
                   var strZonasSeleccionadas = get('frmInsertarGruposZonas.hZonasSeleccionadas');   
                   var strDescSeleccionadas = get('frmInsertarGruposZonas.hDescSeleccionadas');   
                   var arr = new Array();   
                   var arrvalues = strZonasSeleccionadas.split('|');   
                   var arrdesc = strDescSeleccionadas.split('|');   
                   for (var z=0;z<arrvalues.length;z++){   
                     arr[arr.length]=new Array(arrvalues[z],arrdesc[z]);                       
                   }   
                   set_combo('frmInsertarGruposZonas.cbZonasSeleccionadas',arr,[]);                     
            }   
            if (get('frmInsertarGruposZonas.hTipoDeFacturacion')!=''){   
                 iSeleccionadob = new Array();             
                 iSeleccionadob[0] = get('frmInsertarGruposZonas.hTipoDeFacturacion');         
                 set('frmInsertarGruposZonas.cbTipoFacturacion',iSeleccionadob);                 
            }   
       }   
    
       function posicionarCombos(){   
            if (get('frmInsertarGruposZonas.hMarca')!=''){   
              iSeleccionadob = new Array();             
              iSeleccionadob[0] = get('frmInsertarGruposZonas.hMarca');         
              set('frmInsertarGruposZonas.cbMarcas',iSeleccionadob);                     
            } else if (get('frmInsertarGruposZonas.hMarcaDefecto')!=''){   
              iSeleccionadob = new Array();             
              iSeleccionadob[0] = get('frmInsertarGruposZonas.hMarcaDefecto');         
              set('frmInsertarGruposZonas.cbMarcas',iSeleccionadob);        
            }   
            if (get('frmInsertarGruposZonas.hCanal')!=''){   
              iSeleccionadob = new Array();             
              iSeleccionadob[0] = get('frmInsertarGruposZonas.hCanal');         
              set('frmInsertarGruposZonas.cbCanales',iSeleccionadob);                     
            } else if (get('frmInsertarGruposZonas.hCanalDefecto')!=''){   
              iSeleccionadob = new Array();             
              iSeleccionadob[0] = get('frmInsertarGruposZonas.hCanalDefecto');         
              set('frmInsertarGruposZonas.cbCanales',iSeleccionadob);               
            }   
            if ((get('frmInsertarGruposZonas.cbCanales')!='')&&   
                 (get('frmInsertarGruposZonas.cbMarcas')!='')){   
                      cmbMarcaOnChange();                
                  }   
       }   
       function mostrarCodigoError() {     
                  
          var vErrCodigo = get('frmInsertarGruposZonas.errCodigo');   
          var vErrDescrip = get('frmInsertarGruposZonas.errDescripcion');   
          //alert(vErrCodigo);   
          if (get('frmInsertarGruposZonas.errDescripcion')!='') {   
                 var wnd = fMostrarMensajeError( vErrCodigo,vErrDescrip);   
                 /*if (get('frmInsertarGruposZonas.errCodigo')=='260020002')   
                       focaliza('frmInsertarGruposZonas.');*/   
          }   
             
       }       
       function cmbRegionOnChange(){   
         // alert(get("frmInsertarGruposZonas.hPais"));   
            //if (get('frmInsertarGruposZonas.cbRegion')!=''){   
            var arr = new Array();   
            arr[arr.length]=new Array("oidPais", get("frmInsertarGruposZonas.hPais"));   
            arr[arr.length]=new Array("oidMarca", get('frmInsertarGruposZonas.cbMarcas'));   
            arr[arr.length]=new Array("oidCanal", get('frmInsertarGruposZonas.cbCanales'));   
            arr[arr.length]=new Array("oidRegion", get('frmInsertarGruposZonas.cbRegion'));   
                      
            recargaCombo("frmInsertarGruposZonas.cbZonasDisponibles", "CRAObtenerZonasNoAsignadasPorRegion",    
                          "es.indra.sicc.dtos.cra.DTOGrupoZonas", arr , "filtrarCombo(datos)");   
            /*} else {   
              var arr = new Array();                
              set_combo('frmInsertarGruposZonas.cbZonasDisponibles', arr);                
              accion('frmInsertarGruposZonas.cbZonasDisponibles','.disabled=true');                
            }*/   
       }        
    
       function cmbMarcaOnChange(){   
          if (get('frmInsertarGruposZonas.cbCanales')!=''&&   
              get('frmInsertarGruposZonas.cbMarcas')!=''){   
            var arr = new Array();   
            arr[arr.length]=new Array("oidPais", get("frmInsertarGruposZonas.hPais"));   
            arr[arr.length]=new Array("oidMarca", get('frmInsertarGruposZonas.cbMarcas'));   
            arr[arr.length]=new Array("oidCanal", get('frmInsertarGruposZonas.cbCanales'));   
          
            recargaCombo('frmInsertarGruposZonas.cbRegion', 'ZONRecargaRegiones', 'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa',arr, 'comboRegiones(datos)');   
          } else if (get('frmInsertarGruposZonas.cbMarcas')=='') {   
            var arr = new Array();   
            set_combo('frmInsertarGruposZonas.cbRegion', arr);   
            set_combo('frmInsertarGruposZonas.cbZonasDisponibles', arr);   
            accion('frmInsertarGruposZonas.cbRegion','.disabled=true');   
            accion('frmInsertarGruposZonas.cbZonasDisponibles','.disabled=true');   
          }   
          arr = new Array();   
          set_combo('frmInsertarGruposZonas.cbZonasSeleccionadas', arr);             
       }   
          
       function filtrarCombo(datos){   
                 var lcomboGrupo = combo_get('frmInsertarGruposZonas.cbZonasSeleccionadas','L');   
                 var arrComboGrupo = new Array();   
                 for (var i=0; i<lcomboGrupo;i++){   
                     arrComboGrupo[arrComboGrupo.length]= new Array(combo_get('frmInsertarGruposZonas.cbZonasSeleccionadas','V',i),combo_get('frmInsertarGruposZonas.cbZonasSeleccionadas','T',i));   
                 }   
    
                 var arrResultado = new Array();   
                 var aniadir = "si";   
                 for (var j=0; j<datos.length;j++){   
                     aniadir = "si";   
                     for (var k=0; k<arrComboGrupo.length;k++){                            
                          if (datos[j][0]==arrComboGrupo[k][0])   
                              aniadir = "no";   
                     }   
                     if (aniadir=="si")   
                          arrResultado[arrResultado.length]= datos[j];   
                 }   
                 accion('frmInsertarGruposZonas.cbZonasDisponibles','.disabled=false');   
                 set_combo('frmInsertarGruposZonas.cbZonasDisponibles',arrResultado, []);   
       }   
          
       function cmbCanalOnChange(){   
          var arr = new Array();   
          if (get('frmInsertarGruposZonas.cbMarcas')!=''&&   
              get('frmInsertarGruposZonas.cbCanales')!=''){              
            arr[arr.length]=new Array("oidPais", get("frmInsertarGruposZonas.hPais"));   
            arr[arr.length]=new Array("oidMarca", get('frmInsertarGruposZonas.cbMarcas'));   
            arr[arr.length]=new Array("oidCanal", get('frmInsertarGruposZonas.cbCanales'));   
    
            //ZONRecargaRegiones   
            recargaCombo('frmInsertarGruposZonas.cbRegion', 'ZONRecargaRegiones', 'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa',arr, 'comboRegiones(datos)');            
               
          } else if (get('frmInsertarGruposZonas.cbCanales')=='') {              
            set_combo('frmInsertarGruposZonas.cbRegion', arr);   
            set_combo('frmInsertarGruposZonas.cbZonasDisponibles', arr);              
            accion('frmInsertarGruposZonas.cbRegion','.disabled=true');   
            accion('frmInsertarGruposZonas.cbZonasDisponibles','.disabled=true');   
          }   
          arr = new Array();   
          set_combo('frmInsertarGruposZonas.cbZonasSeleccionadas', arr);    
       }   
       function comboRegiones(datos){   
            if (datos!=''){   
              var arrRes = new Array();   
              arrRes[arrRes.length] = new Array();   
              for(var i=0; i<datos.length;i++){   
                   arrRes[arrRes.length] = datos[i];   
              }   
              accion('frmInsertarGruposZonas.cbRegion','.disabled=false');   
              set_combo('frmInsertarGruposZonas.cbRegion',arrRes, []);   
                 
              if (get('frmInsertarGruposZonas.hRegionDefecto')!=''){   
                 iSeleccionadob = new Array();             
                 iSeleccionadob[0] = get('frmInsertarGruposZonas.hRegionDefecto');         
                 set('frmInsertarGruposZonas.cbRegion',iSeleccionadob);               
              }   
                 
              cmbRegionOnChange();   
            } else {   
              var arrRes = new Array();   
              set_combo('frmInsertarGruposZonas.cbRegion',arrRes, []);   
              set_combo('frmInsertarGruposZonas.cbZonasDisponibles',arrRes, []);   
              accion('frmInsertarGruposZonas.cbRegion','.disabled=true');   
              accion('frmInsertarGruposZonas.cbZonasDisponibles','.disabled=true');   
            }   
       }   
       function fGuardar(){   
            accionGuardar();              
       }   
    
       function fLimpiar(){   
            set('frmInsertarGruposZonas.hMarca','');   
            set('frmInsertarGruposZonas.hCanal','');   
            set('frmInsertarGruposZonas.txtCodigoDeGrupo','');   
            set('frmInsertarGruposZonas.txtNombreDeGrupo','');   
            set('frmInsertarGruposZonas.cbTipoFacturacion','');   
            var arr = new Array();   
            set_combo('frmInsertarGruposZonas.cbZonasSeleccionadas',arr);   
            posicionarCombos();   
            limpiaI18N('frmInsertarGruposZonas','1');   
       }   
    
       function accionGuardar(){              
            if(!sicc_validaciones_generales()){   
            return false;    
            }
            var arr = new Array();
            arr[arr.length]=new Array("oidPais", get("frmInsertarGruposZonas.hPais"));   
            arr[arr.length]=new Array("oidMarca", get('frmInsertarGruposZonas.cbMarcas'));   
            arr[arr.length]=new Array("oidCanal", get('frmInsertarGruposZonas.cbCanales'));   
    
            recargaCombo("frmInsertarGruposZonas.cbZonasDisponibles", "CRAObtenerZonasNoAsignadasPorRegion",    
                          "es.indra.sicc.dtos.cra.DTOGrupoZonas", arr , "guardar2(datos)");
            
        }

			//tipo es T o V
			function obtieneDatosCbo(campo, tipo) { 
				var l=combo_get(campo,'L');
				var ar=new Array();
				for(var i=0;i<l;i++) {
					ar[i]=combo_get(campo,tipo,i);
				}
				return ar;
			}

			function armaDatosCbo(campo, tipo) { 
				var l=combo_get(campo,'L');
				var s="";
				for(var i=0;i<l;i++) {
					s = s + combo_get(campo,tipo,i) + "|";
				}
				return s;
			}

        function guardar2(datos){
            if (datos.length>0){
					var arSel = obtieneDatosCbo('frmInsertarGruposZonas.cbZonasSeleccionadas', 'V');
					
					//Recorro los vectores para verificar la pertenencia
					var i;
					var j;
					var oid;
					var encontre;
					for (i = 0; i<datos.length; i++) {
						oid = datos[i][0];
						encontre = false;
						for (j = 0; j<arSel.length; j++) {
							if (arSel[j] == oid) {
								encontre = true;
								break;
							}
						}
						if (!encontre) 
							break;
					}

					if (!encontre) {
						if (!GestionarMensaje('45789')){
							  return false;
						}
					}
            }

				if (combo_get('frmInsertarGruposZonas.cbZonasSeleccionadas','L')>0){   
                setMV('frmInsertarGruposZonas.cbZonasSeleccionadas','N');
            }
            var strZonasSeleccionadas = '';   
            var strDescSeleccionadas = '';   
            var longitud = combo_get('frmInsertarGruposZonas.cbZonasSeleccionadas','L');   
          
            if (longitud > 0) {   
             //strZonasSeleccionadas = combo_get('frmInsertarGruposZonas.cbZonasSeleccionadas','V',0);   
             //strDescSeleccionadas = combo_get('frmInsertarGruposZonas.cbZonasSeleccionadas','T',0);   
             strZonasSeleccionadas = armaDatosCbo('frmInsertarGruposZonas.cbZonasSeleccionadas', 'V');   
             strDescSeleccionadas = armaDatosCbo('frmInsertarGruposZonas.cbZonasSeleccionadas', 'T');
            }   
            set('frmInsertarGruposZonas.hZonasSeleccionadas',strZonasSeleccionadas);   
            set('frmInsertarGruposZonas.hDescSeleccionadas',strDescSeleccionadas);    
            set('frmInsertarGruposZonas.hCodigoDeGrupo',get('frmInsertarGruposZonas.txtCodigoDeGrupo'));   
            set('frmInsertarGruposZonas.hNombreDeGrupo',get('frmInsertarGruposZonas.txtNombreDeGrupo'));   
            set('frmInsertarGruposZonas.hTipoDeFacturacion',get('frmInsertarGruposZonas.cbTipoFacturacion'));   
            set('frmInsertarGruposZonas.accion','guardar');             
            set('frmInsertarGruposZonas.conectorAction','LPMantieneGruposZonas');   
            envia('frmInsertarGruposZonas');            
        }
             /*if (combo_get('frmInsertarGruposZonas.cbZonasSeleccionadas','L')>0){   
                  setMV('frmInsertarGruposZonas.cbZonasSeleccionadas','N');    
             if (fValidarCOMBO('frmInsertarGruposZonas.cbMarcas')&&   
                  fValidarCOMBO('frmInsertarGruposZonas.cbCanales')&&   
                  fValidarCTEXT('frmInsertarGruposZonas.txtCodigoDeGrupo')&&   
                  fValidarCTEXT('frmInsertarGruposZonas.txtNombreDeGrupo')&&   
                  fValidarCOMBO('frmInsertarGruposZonas.cbTipoFacturacion')){   
             if ((esNumero(get('frmInsertarGruposZonas.txtCodigoDeGrupo'))=='OK')&&   
                  (ValidaRango(get('frmInsertarGruposZonas.txtCodigoDeGrupo'),'0','999')=='OK')){//inc 4070   
    
                     
                   var strZonasSeleccionadas = '';   
                   var strDescSeleccionadas = '';   
                   var longitud = combo_get('frmInsertarGruposZonas.cbZonasSeleccionadas','L');   
     
                   if (longitud > 0) {   
                     strZonasSeleccionadas = combo_get('frmInsertarGruposZonas.cbZonasSeleccionadas','V',0);   
                     strDescSeleccionadas = combo_get('frmInsertarGruposZonas.cbZonasSeleccionadas','T',0);   
                   }   
    
                   for(var i = 1;i < longitud;i++){   
                     strZonasSeleccionadas += '|' + combo_get('frmInsertarGruposZonas.cbZonasSeleccionadas','V',i);   
                     strDescSeleccionadas += '|' + combo_get('frmInsertarGruposZonas.cbZonasSeleccionadas','T',i);   
                   }   
                   set('frmInsertarGruposZonas.hZonasSeleccionadas',strZonasSeleccionadas);   
                   set('frmInsertarGruposZonas.hDescSeleccionadas',strDescSeleccionadas);    
                   set('frmInsertarGruposZonas.hCodigoDeGrupo',get('frmInsertarGruposZonas.txtCodigoDeGrupo'));   
                   set('frmInsertarGruposZonas.hNombreDeGrupo',get('frmInsertarGruposZonas.txtNombreDeGrupo'));   
                   set('frmInsertarGruposZonas.hTipoDeFacturacion',get('frmInsertarGruposZonas.cbTipoFacturacion'));   
                   set('frmInsertarGruposZonas.accion','guardar');             
                   set('frmInsertarGruposZonas.conectorAction','LPMantieneGruposZonas');   
                   envia('frmInsertarGruposZonas');   
              } else {   
                 GestionarMensaje('2556');   
                 focaliza('frmInsertarGruposZonas.txtCodigoDeGrupo');   
              }   
            }   
            } else {   
              var msg = objValidacionSICC[objValidacionSICC.length-1].mostrar;   
              cdos_mostrarAlert(GestionarMensaje("1534" ,  "\""+msg+"\""));   
              strFoc = 'focaliza(\''+getFormularioSICC()+"."+objValidacionSICC[objValidacionSICC.length-1].nombre+'\',\'\')';   
              window.setTimeout(strFoc,200);   
              return false;                     
            }   */
          
       //Pasa un elemento de la lista de disponibles a la de seleccionados   
       function agregando(){   
           traspasar('frmInsertarGruposZonas.cbZonasDisponibles','frmInsertarGruposZonas.cbZonasSeleccionadas');             
       }   
          
       function eliminando(){   
          vectorValue = get('frmInsertarGruposZonas.cbZonasSeleccionadas','V');   
          for (var i=0;i <= vectorValue.length - 1;i++){   
              del_combo('frmInsertarGruposZonas.cbZonasSeleccionadas','V', vectorValue[i]);   
          }                 
                 cmbRegionOnChange();   
       }   
       //Pasa un elemento de la lista origen a la destino   
       function traspasar(listaOrigen,listaDestino){   
          vectorValue = get(listaOrigen,'V');   
          vectorDesc = get(listaOrigen,'T');   
    
          for (var i=0;i <= vectorValue.length - 1;i++){   
            if ((vectorValue[i] != null) && (vectorValue[i] != '')){   
              del_combo(listaOrigen,'V', vectorValue[i]);   
              combo_add(listaDestino,vectorValue[i],vectorDesc[i]);   
            }   
          }   
       }   

/*Incidencia 6590*/
        function fSalirApp()
        {
            controlarZonas(false);
        }

        function fSalirPant()
        {
            controlarZonas(true);
        }

        function controlarZonas(pant){
            if ((get('frmInsertarGruposZonas.cbMarcas')!='')&&(get('frmInsertarGruposZonas.cbCanales')!=''))
            {
                var arr = new Array();
                arr[arr.length]=new Array("oidPais", get("frmInsertarGruposZonas.hPais"));
                arr[arr.length]=new Array("oidMarca", get('frmInsertarGruposZonas.cbMarcas'));
                arr[arr.length]=new Array("oidCanal", get('frmInsertarGruposZonas.cbCanales'));
                arr[arr.length]=new Array("oidRegion", '');
	
                recargaCombo("frmInsertarGruposZonas.cbZonasDisponibles", "CRAObtenerZonasNoAsignadasPorRegion", 
                "es.indra.sicc.dtos.cra.DTOGrupoZonas", arr , "validar(datos,"+pant+")");
            } 
            else 
            {
                if(pant){
                    fSalir();
                } 
                else {//salir aplicacion
                        fSalirAplicacion();
                    }
            }
        }

        function validar(datos,pant){
            var lcomboGrupo = combo_get('frmInsertarGruposZonas.cbZonasSeleccionadas','L');
            var arrComboGrupo = new Array();
            for (var i=0; i<lcomboGrupo;i++){
                 arrComboGrupo[arrComboGrupo.length]= new Array(combo_get('frmInsertarGruposZonas.cbZonasSeleccionadas','V',i),combo_get('frmInsertarGruposZonas.cbZonasSeleccionadas','T',i));
            }

            var arrResultado = new Array();
            var aniadir = "si";
            for (var j=0; j<datos.length;j++){
                aniadir = "si";
                for (var k=0; k<arrComboGrupo.length;k++)
                {                      
                    if (datos[j][0]==arrComboGrupo[k][0])
                        aniadir = "no";
                }
                if (aniadir=="si")
                    arrResultado[arrResultado.length]= datos[j];
            }
            
            if (arrResultado!='')
            { //aca debo preguntar si desea continuar porque hay zonas sin asignar
                var res = GestionarMensaje('2518');     
                if (res==false) 
                {//no salir
                    //alert("no salir");
                    return false;
                }
            }
	      //salir
	      //alert("salir");
            if(pant)
            {
                    fSalir();
            } else { //salir aplicacion
                    fSalirAplicacion();
            }
      }


        function fUnload()
        {
            parent.frames["cabecera"].salirAplicacion=oldSalir;
            parent.frames["iconos"].foc_btnBarra3=oldSalirMenu;
        }

        function foc_btnBarra3() 
        {
            if (parent.frames["iconos"].btnBarra.estado[3]) 
            {
                DrdGuardaTraza("EV-USU, pulsado en <BOTONERA nombre=\"btnBarra\"/> el btn en posicion 3 <BTN funcion=\"llamarContenido('APP_CONTENIDO.fSalirPant()');\"/>");
                parent.frames["iconos"].llamarContenido('APP_CONTENIDO.fSalirPant()'); 
            }
        }
/*Incidencia 6590*/


 
