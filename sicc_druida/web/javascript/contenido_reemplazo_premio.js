var retorno = null;
function onLoadPag(){
			fMostrarMensajeError();
			configurarMenuSecundario('formulario');
			btnProxy(5,0);
			accion('formulario.txtValorCriterio', '.disabled=true');  
			if(get('formulario.opcionMenu') == 'detalleDefinirReemplazo'){
					visibilidad('capa2','O');
					focaliza("formulario.txtCodProducto");
					accion('formulario.cbCenServGar', '.disabled=true');  
					accion('formulario.txtNumMeses', '.disabled=true');  
					accion('formulario.areaObservaciones', '.disabled=true');
					accion('formulario.cbCenServEntrega', '.disabled=true'); 
					document.getElementById("cbZona").disabled = true;
					document.getElementById("cbRegion").disabled = true;
					txt_to('lbNumPremio1',get('formulario.Npremio'));
					txt_to('lbCodigo2',get('formulario.codigo'));			
					txt_to('lbDescripcion2',get('formulario.descripcionProducto'));
					accion('formulario.txtNumOrden', '.disabled=true');  
					accion('formulario.ChkIndicadorActivo', '.disabled=true');  
			}else if(get('formulario.opcionMenu') == 'modificarDefinirReemplazo'){							
					visibilidad('capa2','V');
					btnProxy(1,0);
					btnProxy(2,1);
					document.getElementById("cbZona").disabled = true;
					document.getElementById("cbRegion").disabled = true;
					var oidCriterioReemplazo = get('formulario.oidCriterioReemplazo');
					set('formulario.cbCriterioReemplazo', new Array(oidCriterioReemplazo));
					if( get('formulario.ChkIndCenServG') == "1" || get('formulario.ChkIndCenServG') == 'S'){
						set('formulario.ChkIndCenServGar','S');
						var oidCenServGar = get('formulario.oidCenServGar');
						set('formulario.cbCenServGar', new Array(oidCenServGar));
						accion('formulario.cbCenServGar', '.disabled=false');  
						accion('formulario.txtNumMeses', '.disabled=false');  
						accion('formulario.areaObservaciones', '.disabled=false');
					}else{
						set('formulario.ChkIndCenServGar','N');
						set('formulario.cbCenServGar', '');   
						set('formulario.txtNumMeses', '');   
						set('formulario.areaObservaciones', ''); 
          
						accion('formulario.cbCenServGar', '.disabled=true');  
						accion('formulario.txtNumMeses', '.disabled=true');  
						accion('formulario.areaObservaciones', '.disabled=true');  

					}					
					if(get('formulario.ArticuloDespacha4') == "1" || get('formulario.ArticuloDespacha4') == 'S'){
						set('formulario.ckArticuloDespacha4','S');
					}else{
						set('formulario.ckArticuloDespacha4','N');
					}			
					if(get('formulario.Comunicacion') == "1" || get('formulario.Comunicacion') == 'S'){
						set('formulario.ChkComunicacion','S');
					}else{
						set('formulario.ChkComunicacion','N');
					}
					if(get('formulario.TipoEntrega') =="B" ){
						 set('formulario.cbCenServEntrega', '');         
				         accion('formulario.cbCenServEntrega', '.disabled=true');   
					}else{
						  set('formulario.rdTipoEntrega', "C");	
						  accion('formulario.cbCenServEntrega', '.disabled=false');
						  var oidCenServEntrega = get('formulario.CenServEntrega');
						  set('formulario.cbCenServEntrega',new Array(oidCenServEntrega));
					}
					if( get('formulario.indicadorActivo') =="SI"){
						set('formulario.ChkIndicadorActivo', 'S');
					}else{
						set('formulario.ChkIndicadorActivo', 'N');
					}
					if(get('formulario.oidRegion') != "" && get('formulario.oidRegion') != "BLANCO"){
							document.getElementById("cbRegion").disabled = false;
							set('formulario.rbAlcanceGeografico',"R");
							var oidRegion = get('formulario.oidRegion');
							var  a = oidRegion.split(',');
							var arrayRegion = new Array();
							for(var i=0; i < a.length; i ++ ){							
								arrayRegion[i] = a[i];
						    }
							set('formulario.cbRegion', arrayRegion);						
							
					}else{
						
						document.getElementById("cbRegion").disabled = true;
					}
					if(get('formulario.oidZona') != "" && get('formulario.oidZona') != "BLANCO" ){				
						document.getElementById("cbZona").disabled = false;						
						set('formulario.rbAlcanceGeografico',"Z" );
						var oidZona = get("formulario.oidZona");						
						var a = oidZona.split(',');
						var arrayZona = new Array();
						for (var i = 0; i < a.length; i++)
						{
							arrayZona[i] = a[i];
						}			

						set('formulario.cbZona',arrayZona);		
					}else{
						
						document.getElementById("cbZona").disabled = true;
					}
					txt_to('lbNumPremio1',get('formulario.Npremio'));
					txt_to('lbCodigo2',get('formulario.codigo'));			
					txt_to('lbDescripcion2',get('formulario.descripcionProducto'));
                    accion('formulario.txtNumOrden', '.disabled=false');  
					accion('formulario.ChkIndicadorActivo', '.disabled=false');  						
				
				//	rbAlcanceGeografico		
			
			}else if(get('formulario.opcionMenu') == 'eliminar' || get('formulario.opcionMenu')== 'consultarDefinirReemplazo'){					
					var oidCriterioReemplazo = get('formulario.oidCriterioReemplazo');
					set('formulario.cbCriterioReemplazo', new Array(oidCriterioReemplazo));

					if( get('formulario.ChkIndCenServG') == "1" || get('formulario.ChkIndCenServG') == 'S'){
						set('formulario.ChkIndCenServGar','S');
						var oidCenServGar = get('formulario.oidCenServGar');
						set('formulario.cbCenServGar', new Array(oidCenServGar));
						accion('formulario.cbCenServGar', '.disabled=false');  
						accion('formulario.txtNumMeses', '.disabled=false');  
						accion('formulario.areaObservaciones', '.disabled=false');
					}else{
						set('formulario.ChkIndCenServGar','N');
						set('formulario.cbCenServGar', '');   
						set('formulario.txtNumMeses', '');   
						set('formulario.areaObservaciones', ''); 
          
						accion('formulario.cbCenServGar', '.disabled=true');  
						accion('formulario.txtNumMeses', '.disabled=true');  												
						accion('formulario.areaObservaciones', '.disabled=true');
						

					}					
					if(get('formulario.ArticuloDespacha4') == "1" || get('formulario.ArticuloDespacha4') == 'S'){
						set('formulario.ckArticuloDespacha4','S');
					}else{
						set('formulario.ckArticuloDespacha4','N');
					}			
					if(get('formulario.Comunicacion') == "1" || get('formulario.Comunicacion') == 'S'){
						set('formulario.ChkComunicacion','S');
					}else{
						set('formulario.ChkComunicacion','N');
					}
					
					if(get('formulario.TipoEntrega') =="B" ){
						 set('formulario.cbCenServEntrega', '');         
				         accion('formulario.cbCenServEntrega', '.disabled=true');   						 
						 document.all.rdTipoEntrega[0].disabled=true;
						 document.all.rdTipoEntrega[1].disabled=true;
						
					}else{
						  set('formulario.rdTipoEntrega', "C");	
						  accion('formulario.cbCenServEntrega', '.disabled=false');
						  var oidCenServEntrega = get('formulario.CenServEntrega');
						  set('formulario.cbCenServEntrega',new Array(oidCenServEntrega));
						 		
 						  document.all.rdTipoEntrega[0].disabled=true;
						  document.all.rdTipoEntrega[1].disabled=true;
						 
					}
					if( get('formulario.indicadorActivo') == "SI"){
						set('formulario.ChkIndicadorActivo', 'S');
					}else{
						set('formulario.ChkIndicadorActivo', 'N');
					}
					
					if(get('formulario.oidRegion') != "" && get('formulario.oidRegion') != "BLANCO"){
							document.getElementById("cbRegion").disabled = false;
							document.all.rbAlcanceGeografico[0].disabled=true;
							document.all.rbAlcanceGeografico[1].disabled=true;
							set('formulario.rbAlcanceGeografico',"R" );
							var oidRegion = get('formulario.oidRegion');
							var  a = oidRegion.split(',');
							var arrayRegion = new Array();
							for(var i=0; i < a.length; i ++ ){							
								arrayRegion[i] = a[i];
						    }
							set('formulario.cbRegion', arrayRegion);						
					}else{
						document.getElementById("cbRegion").disabled = true;
					}
					if(get('formulario.oidZona') != "" && get('formulario.oidZona') != "BLANCO" ){				
						document.getElementById("cbZona").disabled = false;						
						document.all.rbAlcanceGeografico[0].disabled=true;
						document.all.rbAlcanceGeografico[1].disabled=true;
						set('formulario.rbAlcanceGeografico',"Z" );
						var oidZona = get("formulario.oidZona");						
						var a = oidZona.split(',');
						var arrayZona = new Array();
						for (var i = 0; i < a.length; i++)
						{
							arrayZona[i] = a[i];
						}			

						set('formulario.cbZona',arrayZona);		

					}else{
						document.getElementById("cbZona").disabled = true;
					}
					
					txt_to('lbNumPremio1',get('formulario.Npremio'));
					txt_to('lbCodigo2',get('formulario.codigo'));			
					txt_to('lbDescripcion2',get('formulario.descripcionProducto'));
                    accion('formulario.txtNumOrden', '.disabled=false');  
					accion('formulario.ChkIndicadorActivo', '.disabled=false');  	
				
					
					accion('formulario.txtCodProducto', '.disabled=true');  					
					
					
					
					deshabilitarHabilitarBoton('botonContenido','btnBuscar','D');
					deshabilitarHabilitarBoton('botonContenido','btnAceptar','D');
					accion('formulario.ChkIndCenServGar', '.disabled=true');					
					accion('formulario.txtNumMeses', '.disabled=true');  
					accion('formulario.areaObservaciones', '.disabled=true');  
					accion('formulario.txtNumUnidades4', '.disabled=true');  
					accion('formulario.txtPrecioPublico4', '.disabled=true');  
					accion('formulario.ckArticuloDespacha4', '.disabled=true');  
					accion('formulario.rdTipoEntrega', '.disabled=true');  
					accion('formulario.txtValorCriterio', '.disabled=true');  
					accion('formulario.ChkComunicacion', '.disabled=true');  
					accion('formulario.txtNumOrden', '.disabled=true');  
					accion('formulario.ChkIndicadorActivo', '.disabled=true');  
					accion('formulario.rbAlcanceGeografico', '.disabled=true');  
					//accion('formulario.rbAlcanceGeografico2', '.disabled=true');  
					accion('formulario.cbCenServGar', '.disabled=true');  
					accion('formulario.cbCenServEntrega', '.disabled=true');  
					accion('formulario.cbCriterioReemplazo', '.disabled=true');  
					accion('formulario.cbRegion', '.disabled=true');  
					accion('formulario.cbZona', '.disabled=true');  					
					
			}


}
function accionBuscarProducto(){
		  var obj = new Object();
          obj.casoDeUso= 'buscarProducto' 
          obj.accion = '';
          obj.oidMarcaCorporativa = get('formulario.hOidMarca');
          var retorno = mostrarModalSICC('LPBuscarProductosDTO', '', obj, null, null);
          
          if(retorno!=null) {          
              // Productos seleccionados
              productosString = retorno[0];      
              productosString = productosString.substring(1,productosString.length);
              
              productos = productosString.split('$');
              //alert("productos: " + productos);
              
              // Verifica que se haya seleccionado un producto
              if(productos.length==1 ){
                    producto = productos[0].split('|');
                    set('formulario.txtCodProducto', producto[1]); 
                    set('formulario.oidProducto', producto[0]); 
					set('formulario.desProducto', producto[2]);
              } else {
                    set('formulario.txtCodProducto', ''); 
                    set('formulario.oidProdArticulos', ''); 
                    GestionarMensaje('1497');
              }
       }
}
function onclickIndCenServGar(){

    if(get('formulario.ChkIndCenServGar')=="S"){
          accion('formulario.cbCenServGar', '.disabled=false');  
          accion('formulario.txtNumMeses', '.disabled=false');  
          accion('formulario.areaObservaciones', '.disabled=false');
          
    } else if(get('formulario.ChkIndCenServGar')=="N"){    
          set('formulario.cbCenServGar', '');   
          set('formulario.txtNumMeses', '');   
          set('formulario.areaObservaciones', ''); 
          
          accion('formulario.cbCenServGar', '.disabled=true');  
          accion('formulario.txtNumMeses', '.disabled=true');  
          accion('formulario.areaObservaciones', '.disabled=true');  
    }
}

 function onclickRdTipoEntrega(){
  
    if(get('formulario.rdTipoEntrega')=="B"){
          set('formulario.cbCenServEntrega', '');         
          accion('formulario.cbCenServEntrega', '.disabled=true');   
          
    } else if(get('formulario.rdTipoEntrega')=="C"){    
          accion('formulario.cbCenServEntrega', '.disabled=false');   
    }
  }
  function onClickRbRegion() {
                  document.getElementById("cbZona").disabled = true;
                  document.getElementById("cbRegion").disabled = false;
                  return true;
         }
    
 function onClickRbZona(){
                  document.getElementById("cbRegion").disabled = true;
                  document.getElementById("cbZona").disabled = false;
                  return true;
 }
 function accionBtAceptar(){
		if(sicc_validaciones_generales()) {
			if(get('formulario.opcionMenu') == 'modificarDefinirReemplazo'){
				 set("formulario.oidProducto", "");
				 set("formulario.desProducto", "");
			}

			if(get('formulario.oidProducto') == ""){
				   eval('formulario').oculto = 'S';			       
				   set('formulario.conectorAction', 'LPMantenimientoRemplazoPremios');
				   set('formulario.accion', 'buscar'); 
				   enviaSICC('formulario'); 
			}
			if(get('formulario.codigo') != "" && get("formulario.txtCodProducto") != "" &&  get('formulario.txtNumUnidades4') != ""
					 && get("formulario.cbCriterioReemplazo") != "" ){		
							if(get('formulario.codigo') != get('formulario.txtCodProducto') && get('formulario.oidProducto') != "" ){				
									retorno = new Array();												 
									retorno[0] = get("formulario.codigo");//
									retorno[1] = get("formulario.oidProducto");//
									retorno[2] = get("formulario.txtCodProducto");//
									retorno[3] = get("formulario.desProducto");//
									retorno[4] = get("formulario.ChkIndCenServGar");//
									retorno[5] = get("formulario.cbCenServGar");//
									retorno[6] = get("formulario.cbCenServGar","T");//
									retorno[7] = get("formulario.txtNumMeses");//
									retorno[8] = get("formulario.areaObservaciones");//
									retorno[9] = get("formulario.txtNumUnidades4");//
									retorno[10] = get("formulario.txtPrecioPublico4");//
									retorno[11] = get("formulario.ckArticuloDespacha4");
									retorno[12] = get("formulario.rdTipoEntrega");//
									retorno[13] = get("formulario.cbCenServEntrega");//
									retorno[14] = get("formulario.cbCenServEntrega","T");//
									retorno[15] = get("formulario.cbCriterioReemplazo");//
									retorno[16] = get("formulario.cbCriterioReemplazo","T");//
									retorno[17] = get("formulario.txtValorCriterio");//
									retorno[18] = get("formulario.ChkComunicacion");//
									retorno[19] = get("formulario.codVentaFicticio");//
									if(get('formulario.rbAlcanceGeografico') == 'R'){
										retorno[20] = get("formulario.cbRegion");//
										retorno[21] = get("formulario.cbRegion","T");//
									}else{
										retorno[20] = "";
										retorno[21] = "";
									}
									if( get('formulario.rbAlcanceGeografico') == 'Z'){
										retorno[22] = get("formulario.cbZona");//
										retorno[23] = get("formulario.cbZona","T");//
									}else{
										retorno[22] = "";
										retorno[23] = "";
									}
									retorno[24] = get("formulario.Npremio");// 
									retorno[25] = get("formulario.descripcionProducto");//
									retorno[26] = get("formulario.rbAlcanceGeografico");//		
									retorno[27] = get('formulario.txtNumOrden');//
									retorno[28] = get('formulario.ChkIndicadorActivo');
									retorno[29] = get('formulario.oidArticuloLote');
									returnValue = retorno;
									close();				 
							}

					}  			
			
		}
 }
 function fverProducto(desProducto, oidProd){
		 set("formulario.oidProducto", oidProd);
		 set("formulario.desProducto", desProducto);
		 if(get('formulario.codigo') != "" && get("formulario.txtCodProducto") != "" &&  get('formulario.txtNumUnidades4') != ""
					 && get("formulario.cbCriterioReemplazo") != "" ){		
					 	
					if(get('formulario.codigo') != get('formulario.txtCodProducto') && get('formulario.oidProducto') != "" ){
						
						if((get('formulario.codigoReemplazoInicio') != get('formulario.txtCodProducto')) && get("formulario.posicionReemplazo") == "1" ){
								GestionarMensaje('3389');
								focaliza('formulario.txtCodProducto');
								set("formulario.oidProducto", "");
								set("formulario.desProducto", "");
								return;
						}
						
							retorno = new Array();												 
							retorno[0] = get("formulario.codigo");//
							retorno[1] = get("formulario.oidProducto");//
							retorno[2] = get("formulario.txtCodProducto");//
							retorno[3] = get("formulario.desProducto");//
							retorno[4] = get("formulario.ChkIndCenServGar");//
							retorno[5] = get("formulario.cbCenServGar");//
							retorno[6] = get("formulario.cbCenServGar","T");//
							retorno[7] = get("formulario.txtNumMeses");//
							retorno[8] = get("formulario.areaObservaciones");//
							retorno[9] = get("formulario.txtNumUnidades4");//
							retorno[10] = get("formulario.txtPrecioPublico4");//
							retorno[11] = get("formulario.ckArticuloDespacha4");
							retorno[12] = get("formulario.rdTipoEntrega");//
							retorno[13] = get("formulario.cbCenServEntrega");//
							retorno[14] = get("formulario.cbCenServEntrega","T");//
							retorno[15] = get("formulario.cbCriterioReemplazo");//
							retorno[16] = get("formulario.cbCriterioReemplazo","T");//
							retorno[17] = get("formulario.txtValorCriterio");//
							retorno[18] = get("formulario.ChkComunicacion");//
							retorno[19] = get("formulario.codVentaFicticio");//				
							if(get('formulario.rbAlcanceGeografico') == 'R'){
						 		    retorno[20] = get("formulario.cbRegion");//
									retorno[21] = get("formulario.cbRegion","T");//
							}else{
									retorno[20] = "";
									retorno[21] = "";
							}
							if( get('formulario.rbAlcanceGeografico') == 'Z'){
									retorno[22] = get("formulario.cbZona");//
									retorno[23] = get("formulario.cbZona","T");//
							}else{
									retorno[22] = "";
									retorno[23] = "";
							}				
							retorno[24] = get("formulario.Npremio");// 
							retorno[25] = get("formulario.descripcionProducto");//
							retorno[26] = get("formulario.rbAlcanceGeografico");//		
							retorno[27] = get('formulario.txtNumOrden');//
							retorno[28] = get('formulario.ChkIndicadorActivo');
							retorno[29] = get('formulario.oidArticuloLote');
							retorno[30] = get('formulario.rbAlcanceGeografico');
							retorno[31] = get('formulario.posicionReemplazo');
							returnValue = retorno;
							close();
				}else{

				    GestionarMensaje('2642');
					focaliza('formulario.txtCodProducto');
					set("formulario.oidProducto", "");
					set("formulario.desProducto", "");
				}
					
			}  			
 }

 function onTabTxtCodProducto(){
		focalizaBotonHTML('botonContenido','btnBuscar');
 }
 function onShTabTxtCodProducto(){
		focalizaBotonHTML('botonContenido','btnAceptar');
 }
 function onTabBtnBuscar(){

		if(get('formulario.ChkIndCenServGar')=="S"){
			focaliza('formulario.cbCenServGar');
		}else{
			focaliza('formulario.txtNumUnidades4');
		}
 }
 function onShTabBtnBuscar(){
		focaliza('formulario.txtCodProducto');
 } 
 function onTabCbCenServGar(){
		focaliza('formulario.txtNumMeses');
 }
 function onShTabCbCenServGar(){
		focalizaBotonHTML('botonContenido','btnBuscar');
 }
 function onTabTxtNumMeses(){
		focaliza('formulario.areaObservaciones');
 }
 function onShTabTxtNumMeses(){
		focaliza('formulario.cbCenServGar');
 }
 function onTabAreaObservaciones(){
		focaliza("formulario.txtNumUnidades4");
 }
 function onShTabAreaObservaciones(){
		focaliza('formulario.txtNumMeses');
 }
function onTabTxtNumUnidades4(){
	focaliza('formulario.txtPrecioPublico4')
}
function onShTabTxtNumUnidades4(){
	if(get('formulario.ChkIndCenServGar')=="S"){
		focaliza('formulario.txtNumMeses');
	}else{
		focalizaBotonHTML('botonContenido','btnBuscar');
	}
	
}
function onTabTxtPrecioPublico4(){
	if(get('formulario.rdTipoEntrega')=="C"){
		focaliza('formulario.cbCenServEntrega');
	}else{
		focaliza('formulario.cbCriterioReemplazo');
	}
}
function onShTabTxtPrecioPublico4(){
	focaliza('formulario.txtNumUnidades4');
}
function onTabCbCenServEntrega(){
	focaliza('formulario.cbCriterioReemplazo');
}
function onShTabCbCenServEntrega(){
	focaliza('formulario.txtPrecioPublico4');
}
function onTabCbCriterioReemplazo(){
	focaliza('formulario.txtValorCriterio');
}
function onShTabCbCriterioReemplazo(){
	if(get('formulario.rdTipoEntrega')=="C"){
		focaliza('formulario.cbCenServEntrega');
	}else{
		focaliza('formulario.txtPrecioPublico4');
	}
}
function onTabTxtValorCriterio(){
	focalizaBotonHTML('botonContenido','btnAceptar');
}
function onTabShTxtValorCriterio(){
	focaliza('formulario.cbCriterioReemplazo');
}
function onTabBtnAceptar(){
	focaliza('formulario.txtCodProducto');
}
function onShTabBtnAceptar(){
	focaliza('formulario.txtValorCriterio');
}
function onTabChkIndCenServGar(){
	if(get('formulario.ChkIndCenServGar')=="S"){
		focaliza('formulario.cbCenServGar');
	}else{
		focaliza('formulario.txtNumUnidades4');
	}
}
function onShTabChkIndCenServGar(){
	focalizaBotonHTML('botonContenido','btnBuscar');	
}
function fVolver() {
    window.close();
}
function fLimpiar(){
						
					/*	 Set("formulario.codigo" );//
						 set("formulario.oidProducto" );//
						 set("formulario.txtCodProducto");//
					     set("formulario.desProducto");//
						 set("formulario.ChkIndCenServGar");//
						 set("formulario.cbCenServGar");//
						 set("formulario.cbCenServGar","T");//
						 st("formulario.txtNumMeses");//
						 set("formulario.areaObservaciones");//
						 set("formulario.txtNumUnidades4");//
					     set("formulario.txtPrecioPublico4");//
						 set("formulario.ckArticuloDespacha4");
						 set("formulario.rdTipoEntrega");//
						 set("formulario.cbCenServEntrega");//
						 set("formulario.cbCenServEntrega","T");//
						 set("formulario.cbCriterioReemplazo");//
						 set("formulario.cbCriterioReemplazo","T");//
						 set("formulario.txtValorCriterio");//
						 set("formulario.ChkComunicacion");//
						 set("formulario.rbAlcanceGeografico");//				
						 ser('formulario.cbRegion");//
						 set("formulario.cbRegion","T");//
						 set("formulario.cbZona");//
						 set("formulario.cbZona","T");//				
						 Set("formulario.Npremio");//
						 set("formulario.descripcionProducto");*/
 }
 function onChangeCbCriterioReemplazo(){
	if(get('formulario.cbCriterioReemplazo') == 2){
			accion('formulario.txtValorCriterio', '.disabled=false');  	
	}else{
			accion('formulario.txtValorCriterio', '.disabled=true');  
			set('formulario.txtValorCriterio', "");
	}
		
 }
function fBuscar(desProducto, oidProd){
		 
   set("formulario.oidProducto", oidProd);
   set("formulario.desProducto", desProducto);
}
function fBuscarErr(){
	focaliza('formulario.txtCodProducto');
	set('formulario.txtCodProducto', '');	
}
