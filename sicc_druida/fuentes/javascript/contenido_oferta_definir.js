function onLoadPag(){
                configurarMenuSecundario("frmContenido");
                DrdEnsanchaConMargenDcho('listado1',12);
                DrdEnsanchaConMargenDcho('listado2',12);
                DrdEnsanchaConMargenDcho('listado3',12);
                window.setTimeout('eval (ON_RSZ)',200);
                ShowError();
                posicionaCombos();
                posicionaRadioButtons();
                configuraPagina();
                if ((listado1.datos.length==0)&&
                    (listado2.datos.length==0)){
                    focaliza('frmContenido.cbAcceso','');
                } else {
                    focaliza('frmContenido.cbArgumentoVenta','');
                }
           }
           function fLimpiar(){
              setMV('frmContenido.cbCatalogo','N');
              set('frmContenido.accion','Limpiar');
              enviaSICC('frmContenido');
           }
           function limpia(){
                set('frmContenido.hAcceso','');
                set('frmContenido.hSubacceso','');
                set('frmContenido.hCatalogoSel','');
                set('frmContenido.cbSubacceso','');
                set('frmContenido.hTipoCliente','');
                set('frmContenido.hSubtipoCliente','');
                set('frmContenido.hTipoClasificacion','');
                set('frmContenido.hClasificacion','');
                set('frmContenido.cbEstatusCliente','');
                set('frmContenido.txtEstatus2','');
                set('frmContenido.hArgumentoVenta','');
                set('frmContenido.hFormaPago','');
                //set('frmContenido.txtNOrden','');
                set('frmContenido.txtNGrupos','');
                set('frmContenido.txtNGrupCondicionantes','');
                set('frmContenido.txtNGrupCondicionados','');
                
                set('frmContenido.ckVentaExclusiva','N');

                set('frmContenido.ckRecObligPedido','N');

                set('frmContenido.cbIdCuadre',new Array());
                
                if(get('frmContenido.cvDespAuto')=='S'){
                  set('frmContenido.ckDespachoAutomatico','S');                 
                } else if(get('frmContenido.cvDespAuto')=='N') {                     
                  set('frmContenido.ckDespachoAutomatico','N');
                } else {
                  set('frmContenido.ckDespachoAutomatico','N');
                }

                var arr = new Array();
                set_combo('frmContenido.cbIdCuadre',arr);
                set_combo('frmContenido.cbSubtipoCliente',arr);
                set_combo('frmContenido.cbTipoClasificacion',arr);
                set_combo('frmContenido.cbClasificacion',arr);
                set('frmContenido.cbEstatusCliente','');

                accionActivarVentaExclusiva('false');
                
                listado3.setDatos(new Array());
                
                posicionaCombos();
                configuraPagina();                
           }
    
           function ShowError(){
              if (get('frmContenido.errCodigo') != ''){
                    fMostrarMensajeError();
               }
           }

           function accionBuscarProductoPrincipal(){
                    if(!sicc_validaciones_generales("catalogo")){
                        return false;
                    }
                    set('frmContenido.descCatalogo',get('frmContenido.cbCatalogo','T'));
                    set('frmContenido.accion','Buscar producto principal');
                    enviaSICC('frmContenido');
           }
           
           function accionBuscarProductoAsociado(){
                    if(!sicc_validaciones_generales("catalogo")){
                        return false;
                    }           
                    set('frmContenido.descCatalogo',get('frmContenido.cbCatalogo','T'));
                    set('frmContenido.accion','Buscar producto asociado');
                    enviaSICC('frmContenido');
           }
           
           function accionActivarVentaExclusiva(estado){
                if (estado=='true'){
                    accion('frmContenido.cbTipoCliente','.disabled=false');
                    accion('frmContenido.cbSubtipoCliente','.disabled=false');
                    accion('frmContenido.cbTipoClasificacion','.disabled=false');
                    accion('frmContenido.cbClasificacion','.disabled=false');
                    accion('frmContenido.cbEstatusCliente','.disabled=false');
                    accion('frmContenido.txtEstatus2','.disabled=false');
                    
                }else{
                    set('frmContenido.cbTipoCliente','');
                    set('frmContenido.cbSubtipoCliente','');
                    set('frmContenido.cbTipoClasificacion','');
                    set('frmContenido.cbClasificacion','');
                    set('frmContenido.cbEstatusCliente','');
                    set('frmContenido.txtEstatus2','');
                    accion('frmContenido.cbTipoCliente','.disabled=true');
                    accion('frmContenido.cbSubtipoCliente','.disabled=true');
                    accion('frmContenido.cbTipoClasificacion','.disabled=true');
                    accion('frmContenido.cbClasificacion','.disabled=true');
                    accion('frmContenido.cbEstatusCliente','.disabled=true');
                    accion('frmContenido.txtEstatus2','.disabled=true');
                }
           }
           
           function accionNumeroGruposIntroducido(){
                setMV('frmContenido.cbAcceso','N');
                setMV('frmContenido.cbSubacceso','N');
                setMV('frmContenido.cbArgumentoVenta','N');
                setMV('frmContenido.cbCatalogo','N');
                var validar = esNumero(get('frmContenido.txtNGrupos'));
                if( validar != 'OK'){         
                  return false;
                }           
                set('frmContenido.accion','Numero de grupos introducido');
                accion('frmContenido.cbIdCuadre','.disabled=false');
                enviaSICC('frmContenido');
           }
           
           function accionModificarOferta(){
                set('frmContenido.accion','modificarOferta');
                enviaSICC('frmContenido');
           }

           function accionAniadirVentaExclusiva(){
                if (get('frmContenido.ckVentaExclusiva')!='S')
                    return;
                    
                if(!sicc_validaciones_generales("vexcl")){
                  return false;
                }                    
                if (fValidarCOMBO("frmContenido.cbTipoCliente")){
                    
                    set('frmContenido.hDesTipoCliente',get('frmContenido.cbTipoCliente','T'));
                    set('frmContenido.hDesSubtipoCliente',get('frmContenido.cbSubtipoCliente','T'));
                    set('frmContenido.hDesTipoClasificacion',get('frmContenido.cbTipoClasificacion','T'));
                    set('frmContenido.hDesClasificacion',get('frmContenido.cbClasificacion','T'));
                    set('frmContenido.hDesEstatusCliente',get('frmContenido.cbEstatusCliente','T'));
                    
                    set('frmContenido.accion','Añadir venta exclusiva');
                    enviaSICC('frmContenido');
                }                
           }
           function fBorrar(){
              if (listado2.numSelecc()>0){
                  accionEliminarProductosAsociados();              
              } else if (listado3.numSelecc()>0){
                  accionEliminarVentaExclusiva();
              } else {
                  GestionarMensaje(4);
              }
           }
           
           function accionEliminarProductosAsociados(){
              if (listado2.numSelecc()>0){
                  if(GestionarMensaje("5")){
                      set('frmContenido.accion','Eliminar productos asociados');
                      set('frmContenido.elemSelecc',listado2.codSeleccionados());
                      enviaSICC('frmContenido');
                  }
              }
           }
           
           function accionEliminarVentaExclusiva(){//falta saber a que lista pertenece
              if (listado3.numSelecc()>0){
                  if(GestionarMensaje("5")){
                      set('frmContenido.accion','Eliminar venta exclusiva');
                      set('frmContenido.elemSelecc',listado3.codSeleccionados());
                      enviaSICC('frmContenido');
                  }
              } 
           }
           
           function accesoOnChange(){
              accion('frmContenido.cbSubacceso','.disabled=false');
      	      var arr = new Array();
	      arr[arr.length]= new Array("oidPais","1");
	      arr[arr.length]= new Array("oidIdioma","1");
	      arr[arr.length]= new Array("oid",get('frmContenido.cbAcceso'));
		  var acc1 = get('frmContenido.cbAcceso');

				if (acc1=="")
				{	
					accion('frmContenido.cbSubacceso','.disabled=true');
					set ('frmContenido.cbSubacceso',new Array());
					return
					
				}
				accion('frmContenido.cbSubacceso','.disabled=false');
              recargaCombo("frmContenido.cbSubacceso", "SegObtenerSubaccesosPorAcceso", 
                           "es.indra.sicc.util.DTOOID", arr, "configuraSubacceso(datos)");
           }

           function tipoClienteOnChange(){
              accion('frmContenido.cbSubtipoCliente','.disabled=false');
              recargaCombo('frmContenido.cbSubtipoCliente', 'MAEobtenerSubtipos', 
                           'es.indra.sicc.util.DTOOID', makeParameter('oid',get('frmContenido.cbTipoCliente')));
           }
           
           function subtipoClienteOnChange(){
              accion('frmContenido.cbTipoClasificacion','.disabled=false');
              recargaCombo('frmContenido.cbTipoClasificacion', 'MAEobtenerTipoClasificacion', 
                           'es.indra.sicc.util.DTOOID', makeParameter('oid',get('frmContenido.cbSubtipoCliente')));
           }
           
           function tipoClasificacionOnChange(){
              accion('frmContenido.cbClasificacion','.disabled=false');
              recargaCombo('frmContenido.cbClasificacion', 'MAEobtenerClasificacionesPorTipo', 
                           'es.indra.sicc.util.DTOOID', makeParameter('oid',get('frmContenido.cbTipoClasificacion')));
           }
           
           function posicionaCombos(){
                var array = new Array();
                //alert(get('frmContenido.hAccesoDef'));
                if (get('frmContenido.hAccesoDef')!=''){
                  array[0] = get('frmContenido.hAccesoDef');
                  set('frmContenido.cbAcceso',array)
                  if (get('frmContenido.hAccesoDef')!=''){
                      accesoOnChange();
                  }                    ;
                  set('frmContenido.hAccesoDef','');
                  //alert("aa");
                } else {
                  array[0] = get('frmContenido.hAcceso');
                  set('frmContenido.cbAcceso',array);
                  if (get('frmContenido.hAcceso')!=''){
                      accesoOnChange();
                  }                    
                }
              
                array = new Array();
                array[0] = get('frmContenido.hFormaPago');
                set('frmContenido.cbFormaPago',array);
                array = new Array();                
                if (get('frmContenido.hArgumentoVenta')!=""){
                  array[0] = get('frmContenido.hArgumentoVenta');
                  set('frmContenido.cbArgumentoVenta',array);
                } else {
                  array[0] = get('frmContenido.argumentoVta');
                  set('frmContenido.cbArgumentoVenta',array);                
                }
                array = new Array();
                if (get('frmContenido.hCatalogoSel')!=""){
                  array[0] = get('frmContenido.hCatalogoSel');
                  set('frmContenido.cbCatalogo',array);
                }                
                array = new Array();
                array[0] = get('frmContenido.hIndCuadre');
                set('frmContenido.cbIdCuadre',array);
           }

           function configuraSubacceso(datos){
           var arr = new Array();
            if (datos.length>0){              
              arr[arr.length]=new Array("","");
              for (var i=0;i<datos.length;i++){
                  arr[arr.length]=datos[i];
              }
            }
            set_combo('frmContenido.cbSubacceso', arr, []);
                  var array = new Array();
                  if (get('frmContenido.hSubaccesoDef')!=''){
                    array[0] = get('frmContenido.hSubaccesoDef');
                    set('frmContenido.cbSubacceso',array);
                    get('frmContenido.hSubaccesoDef','');
                  } else {                  
                    array[0] = get('frmContenido.hSubacceso');
                    set('frmContenido.cbSubacceso',array);
                  }
            if (arr.length ==0){
            accion('frmContenido.cbSubacceso','.disabled=true');
            }
				

           }

           function cambioVentaExclusiva(){
                if (get('frmContenido.ckVentaExclusiva')=='S'){
                    accionActivarVentaExclusiva('true');
                }else{
                    accionActivarVentaExclusiva('false');
                }
           }

           function posicionaRadioButtons(){
                set('frmContenido.rbCondicionantes',get('frmContenido.hrbCondicionantes'));
                set('frmContenido.rbCondicionados',get('frmContenido.hrbCondicionados'));
                set('frmContenido.ckDespachoCompleto',get('frmContenido.hrbDespachoCompleto'));
                set('frmContenido.ckDespachoAutomatico',get('frmContenido.hrbDespachoAutomatico'));
                set('frmContenido.ckRecObligPedido',get('frmContenido.hrbRecObligPedido'));
                set('frmContenido.ckVentaExclusiva',get('frmContenido.hrbVentaExclusiva'));
                cambioVentaExclusiva();
           }
           
           function configuraPagina(){
              if (get('frmContenido.accion')==''){
                  if (get('frmContenido.cbAcceso')=='')
                      accion('frmContenido.cbSubacceso','.disabled=true');
              }
              if (get('frmContenido.numGrupos')=='false'){
                  accion('frmContenido.txtNGrupos','.disabled=true');
              }
              if (get('frmContenido.numPaqu')=='false'){
                  accion('frmContenido.txtNPaquetes','.disabled=true');
              }
              if (get('frmContenido.indCuadre')=='false'){
                  accion('frmContenido.cbIdCuadre','.disabled=true');
              }
              if (get('frmContenido.numGrupCondtes')=='false'){
                  accion('frmContenido.txtNGrupCondicionantes','.disabled=true');
              }
              if (get('frmContenido.numGrupCondos')=='false'){
                  accion('frmContenido.txtNGrupCondicionados','.disabled=true');
              }
              if (get('frmContenido.condCondos')=='false'){
                  document.all.rbCondicionados[0].disabled=true;
                  document.all.rbCondicionados[1].disabled=true;                  
              }
              if (get('frmContenido.condCondtes')=='false'){
                  document.all.rbCondicionantes[0].disabled=true;
                  document.all.rbCondicionantes[1].disabled=true;             
              }
              if (get('frmContenido.despAuto')=='false'){
                  document.all.ckDespachoAutomatico[0].disabled=true;
                  //document.all.ckDespachoAutomatico[1].disabled=true;
              }
              if (get('frmContenido.primeraEjecucion')=='true'){
                  set('frmContenido.ckDespachoAutomatico',get('frmContenido.cvDespAuto'));
              }
              
              if (get('frmContenido.despCompl')=='false'){
                  document.all.ckDespachoCompleto[0].disabled=true;
                  //document.all.ckDespachoCompleto[1].disabled=true;
              }
              if (get('frmContenido.btnBPPpal')=='false'){
                  document.all["Buscar1Div"].style.visibility='hidden'
              }
              if (get('frmContenido.btnBPAsoc')=='false'){
                  document.all["Buscar2Div"].style.visibility='hidden'
              } 
              if ((listado1.datos.length>0)||
                  (listado2.datos.length)){
                  accion('frmContenido.cbAcceso','.disabled=true');
                  accion('frmContenido.cbSubacceso','.disabled=true');
                  accion('frmContenido.cbCatalogo','.disabled=true');
              }
           }

           function fGuardar(){
                if (get('frmContenido.indCuadre')=='true'){
                  if(!sicc_validaciones_generales("idCuadre")){
                    return false;
                  }                
                }
                
                if(!sicc_validaciones_generales("grgral")){
                  return false;
                }
                if (fValidarCOMBO("frmContenido.cbArgumentoVenta")){
                    if (get('frmContenido.numGrupos')=='true'){
                        if(!sicc_validaciones_generales("grngrup")){
                          return false;
                        }
                        if (!fValidarCTEXT('frmContenido.txtNGrupos')){
                            return;
                        }
                        if (get('frmContenido.maxGrupo')!=''){
                          if(get('frmContenido.maxGrupo')<get('frmContenido.txtNGrupos')){
                              GestionarMensaje('716');
                              return;
                          }
                        }
                    }                    
                    if (get('frmContenido.numPaqu')=='true'){
                        if(!sicc_validaciones_generales("grnpaq")){
                        return false;
                        }
                        if (!fValidarCTEXT('frmContenido.txtNPaquetes')){
                            return;
                        }
                        if (get('frmContenido.maxGrupo')!=''){
                          if(get('frmContenido.maxGrupo')<get('frmContenido.txtNPaquetes')){
                              GestionarMensaje('717');
                              return;
                          }
                        }
                    }
                    if (get('frmContenido.numGrupCondtes')=='true' &&
                        get('frmContenido.numGrupCondos')=='true'){
                        if(!sicc_validaciones_generales("grcond")){
                        return false;
                        }                        
                        if(!fValidarCTEXT('frmContenido.txtNGrupCondicionantes')||
                           !fValidarCTEXT('frmContenido.txtNGrupCondicionados')){
                            return;
                        }
                        if (get('frmContenido.maxGruposCondicionantes')!=''){
                          if (get('frmContenido.txtNGrupCondicionantes')>
                              get('frmContenido.maxGruposCondicionantes')){
                              GestionarMensaje('718');
                              return;
                          }
                        }
                        if (get('frmContenido.maxGruposCondicionados')!=''){
                          if (get('frmContenido.txtNGrupCondicionados')>
                              get('frmContenido.maxGruposCondicionados')){
                              GestionarMensaje('719');
                              return;
                          }
                        }
                        var ncondo = new Number(get('frmContenido.txtNGrupCondicionados'));
                        var ncontes = new Number(get('frmContenido.txtNGrupCondicionantes'));
                        
                        if (get('frmContenido.maxGrupo')!=''){
                          if (ncondo+ncontes>get('frmContenido.maxGrupo')){
                              GestionarMensaje('234');
                              return;
                          }
                        }
                    }
                    if (get('frmContenido.condCondtes')=='true'){
                        if (get('frmContenido.rbCondicionantes')==""){
                            GestionarMensaje('721');
                            return;
                        }
                    }
                    if (get('frmContenido.condCondos')=='true'){
                        if (get('frmContenido.rbCondicionados')==""){
                            GestionarMensaje('722');
                            return;
                        }
                    }
                    if (get('frmContenido.btnBPPpal')=='true'){//Valido que haya Porducto principal
                        if (listado1.datos.length<1){
                            GestionarMensaje('235');
                            return;
                        }
                    } else {
                        if(!sicc_validaciones_generales("catalogo")){
                          return false;
                        }                    
                    }
                    if (get('frmContenido.btnBPAsoc')=='true'){//Valido que haya Porducto asociado
                        if (listado2.datos.length<1){
                            GestionarMensaje('720');
                            return;
                        }
                    } else {
                      if(!sicc_validaciones_generales("catalogo")){
                        return false;
                      }      
                    }
//                    sbonanno - 20/06/2006 - BELC300023389  
//                    if (!fValidarCOMBO('frmContenido.cbFormaPago')){return;}
                    if (get('frmContenido.ckVentaExclusiva')=='S'){//verifico que haya al menos una venta exclusiva
                        if (listado3.datos.length<1){
                            GestionarMensaje('2524');
                            return;
                        }
                    }
                    //enozigli 27/09/2005 BELC300021032
                    set('frmContenido.descCatalogo',get('frmContenido.cbCatalogo','T'));
                    
                    set('frmContenido.accion',"Crear oferta");
                    enviaSICC('frmContenido');
                }
           }
           
           function formarCadena(idBusiness , dto, parametros) {
                var cadena = idBusiness + "|" + dto + "|"; 
                for(i=0;i<parametros.length;i++) {
                    cadena += parametros[i][0] + "=" + parametros[i][1];
                    if (i!= parametros.length-1) {
                        cadena += "&";
                     }
                }
               return cadena;
          }
          
          function makeParameter(nombre, oid){
              var array = new Array();
              var i=0;
              array[i] = new Array('oidPais','1');
              i++;
              array[i] = new Array('oidIdioma','1');
              i++;
              array[i] = new Array(nombre,oid)
              return array;
          }

          function focalizaVentaExclusiva(){
              if (get('frmContenido.ckVentaExclusiva')=='S'){
                  focaliza('frmContenido.cbTipoCliente','');
              }else{
                if ((listado1.datos.length==0)&&
                    (listado2.datos.length==0)){
                    focaliza('frmContenido.cbAcceso','');
                } else {
                    focaliza('frmContenido.cbArgumentoVenta','');
                }
              }
          }

          function focalizaCBAcceso(){
              if (get('frmContenido.ckVentaExclusiva')=='S'){
                  focaliza('frmContenido.txtEstatus2','');
              }else{
                  focaliza('frmContenido.ckVentaExclusiva','');
              }
          }

          function sumarYPoner(){
            setMV('frmContenido.cbAcceso','N');
            setMV('frmContenido.cbSubacceso','N');
            setMV('frmContenido.cbArgumentoVenta','N');
            setMV('frmContenido.cbCatalogo','N');
            var validar = esNumero(get('frmContenido.txtNGrupCondicionantes'));
            if( validar != 'OK'){         
              return false;
            }
            var validar = esNumero(get('frmContenido.txtNGrupCondicionados'));
            if( validar != 'OK'){
              return false;
            }         
            var ncondos = get('frmContenido.txtNGrupCondicionados');
            var ncondtes =get('frmContenido.txtNGrupCondicionantes');            
            var res = new Number(ncondos)+new Number(ncondtes);
            set('frmContenido.txtNGrupos',res);
            accionNumeroGruposIntroducido(); 
          }
          function mostrarMensajeNumerico(campo){
                var msg = sicc_obtenerDescripcion(campo);                
                focaliza("frmContenido."+campo);
                cdos_mostrarAlert(GestionarMensaje("000000000000100" ,  "\""+msg+"\""));                
          }
          function saledeCondiciona(){
            var validar = esNumero(get('frmContenido.txtNGrupCondicionantes'));
            if( validar != 'OK'){
              mostrarMensajeNumerico("txtNGrupCondicionantes");              
              return false;
            }
            var validar = esNumero(get('frmContenido.txtNGrupCondicionados'));
            if( validar != 'OK'){
              mostrarMensajeNumerico("txtNGrupCondicionados");
              return false;
            }      
          }
          function saleDe(nombre){
            var validar = esNumero(get('frmContenido.'+nombre));
            if( validar != 'OK'){
              mostrarMensajeNumerico(nombre);
              return false;
            }            
          }
          function tabNOrden(){
              if (get('frmContenido.btnBPPpal')=="true"){
                  focalizaBotonHTML_XY("Buscar1");
              } else {
                  tabNextBtn();
              }
          }
          function tabNextBtn(){
             if (get('frmContenido.btnBPAsoc')=="true") {
                  focalizaBotonHTML_XY("Buscar2");
              } else {
                tabDatosOferta();
              }
          }
          function arrayComponentes(){
              var arr = new Array();
              arr[arr.length]= new Array("cbAcceso","");
              arr[arr.length]= new Array("cbSubacceso","");
              arr[arr.length]= new Array("cbCatalogo","");
              arr[arr.length]= new Array("cbArgumentoVenta","");
              //arr[arr.length]= new Array("txtNOrden","");

              arr[arr.length]= new Array("Buscar1","BOTONXY");
              arr[arr.length]= new Array("Buscar2","BOTONXY");

              arr[arr.length]= new Array("txtNGrupos","");
              arr[arr.length]= new Array("txtNPaquetes","");
              arr[arr.length]= new Array("cbIdCuadre","");

              arr[arr.length]= new Array("txtNGrupCondicionantes","");
              arr[arr.length]= new Array("rbCondicionantes","");
              arr[arr.length]= new Array("txtNGrupCondicionados","");
              arr[arr.length]= new Array("rbCondicionados","");

              arr[arr.length]= new Array("ckDespachoCompleto","");
              arr[arr.length]= new Array("ckDespachoAutomatico","");
              arr[arr.length]= new Array("ckRecObligPedido","");
              arr[arr.length]= new Array("cbFormaPago","");

              arr[arr.length]= new Array("ckVentaExclusiva","");
              arr[arr.length]= new Array("cbTipoCliente","");
              arr[arr.length]= new Array("cbSubtipoCliente","");
              arr[arr.length]= new Array("cbTipoClasificacion","");
              arr[arr.length]= new Array("cbClasificacion","");
              arr[arr.length]= new Array("cbEstatusCliente","");
              arr[arr.length]= new Array("txtEstatus2","");

              arr[arr.length]= new Array("btnAnadir","BOTON");

              arr[arr.length]= new Array("Anadir","BOTONXY");             
              
              return arr;
          }
          function tabGenerico(nombreComp, tipotab){       
            var arr = arrayComponentes();
            var tabular = false;
            var nombreFormulario = getFormularioSICC();
            var j = 0;
            var k = arr.length;
            if (tipotab != "sh") {
                j = j-1;                
                k = k-1;
            }

            while(j<k){
                var t;
                if(tipotab == "sh"){
                  k--;
                  t = k;
                } else{
                  j++;
                  t = j;                  
                }
                  
                var nombre = arr[t][0];
                var tipo = arr[t][1];
                if (tabular==false){
                  if (nombreComp==nombre){
                      tabular=true;
                      if (tipotab == "sh"){
                        if (k==0) k= arr.length;
                      } else {
                        if ((j+1)==arr.length)  j = -1;
                      }
                  }                
                } else {
                  try {
                    var name = nombreFormulario+"."+nombre;
                    if (tipo=="BOTONXY"){
                       focalizaBotonHTML_XY(nombre);
                    } else if (tipo=="BOTON") {
                       focalizaBotonHTML("botonContenido",nombre)
                    } else {
                       focaliza(name);
                    }
                    return;
                  } catch (e) {
                  }
                }
            }
          }
