var secArtProd = 1;
var estado = 'A'; 

function onLoadPag(){
	fMostrarMensajeError();
    configurarMenuSecundario('formulario');
		
	deshabilitarHabilitarBoton('botonContenido','btnVerFaltantes','D');

    if(get('formulario.opcionMenu') == 'insertar'){
		focaliza('formulario.cbConcurso');
    }
	btnProxy(1,0);
	DrdEnsanchaConMargenDcho('listado1',12);     	
	DrdEnsanchaConMargenDcho('listado2',12);  
	deshabilitarHabilitarBoton('botonContenido','btnConsultar','D');
	deshabilitarHabilitarBoton('botonContenido','btnModificar','D');
	deshabilitarHabilitarBoton('botonContenido','btnEliminar','D');	
	
	muestraCapa();
	muestraCapa2();
	eval (ON_RSZ);

}
function accionBTNBuscar(){   
		 if( sicc_validaciones_generales()	){
			  set('formulario.posicionesEliminadas', "");
			  var arr = new Array();
			  arr[arr.length] = new Array("oid", get("formulario.cbConcurso")+"");          
			  configurarPaginado(mipgndo,"INCBuscarPremioConcurso","ConectorBuscarPremioConcurso","es.indra.sicc.util.DTOOID",arr); 
			  listado2.actualizaDat();
			  listado2.repinta();
			  configurarPaginado(mipgndo2,"INCObtenerReemplazo","ConectorObtenerReemplazo","es.indra.sicc.util.DTOOID",arr);  
		 }
} 

function muestraLista(ultima, rowset, error){                   
                    muestraCapa();
                    eval(ON_RSZ);
                    focaliza("formulario.cbConcurso");
                    return true;          
}
function muestraCapa(){

	  document.all["Cplistado1"].style.visibility='';
	  document.all["CpLin1listado1"].style.visibility='';
	  document.all["CpLin2listado1"].style.visibility='';
	  document.all["CpLin3listado1"].style.visibility='';
	  document.all["CpLin4listado1"].style.visibility='';  
	  document.all["ava1Div"].style.visibility='hidden';
	  document.all["ret1Div"].style.visibility='hidden';
	  

}
function ocultaCapa(){
	  
	  document.all["Cplistado1"].style.visibility='hidden';
	  document.all["CpLin1listado1"].style.visibility='hidden';
	  document.all["CpLin2listado1"].style.visibility='hidden';
	  document.all["CpLin3listado1"].style.visibility='hidden';
	  document.all["CpLin4listado1"].style.visibility='hidden';	  
	  document.all["ava1Div"].style.visibility='hidden';
	  document.all["ret1Div"].style.visibility='hidden';
	 
	  
	  

}
function muestraLista2(ultima, rowset, error){
					var tamano = rowset.length;						
					if (tamano > 0){	    					
						muestraCapa2();	
						deshabilitarHabilitarBoton('botonContenido','btnConsultar','A');
						deshabilitarHabilitarBoton('botonContenido','btnModificar','A');
						deshabilitarHabilitarBoton('botonContenido','btnEliminar','A');
						eval(ON_RSZ);
						estado = 'A';
						focaliza("formulario.cbConcurso");											
						return true;	

					}else{
						estado = 'D';	
					}
}
function muestraCapa2(){

	  document.all["Cplistado2"].style.visibility='';
	  document.all["CpLin1listado2"].style.visibility='';
	  document.all["CpLin2listado2"].style.visibility='';
	  document.all["CpLin3listado2"].style.visibility='';
	  document.all["CpLin4listado2"].style.visibility='';	  	   
	  document.all["ava2Div"].style.visibility='hidden';
	  document.all["ret2Div"].style.visibility='hidden';  
	  

}
function ocultaCapa2(){	  
	  document.all["Cplistado2"].style.visibility='hidden';
	  document.all["CpLin1listado2"].style.visibility='hidden';
	  document.all["CpLin2listado2"].style.visibility='hidden';
	  document.all["CpLin3listado2"].style.visibility='hidden';
	  document.all["CpLin4listado2"].style.visibility='hidden'; 
	  document.all["ava2Div"].style.visibility='hidden';
	  document.all["ret2Div"].style.visibility='hidden';  

}
function accionBTN_DefinirRemplazo(){
		  var opcionMenu = get('formulario.opcionMenu');
          var oidPlantilla = null;
          var numPlantilla = null;
          var oidParamGrales = null;
          var filaMarcada = null;
          var codSeleccionados = null;
          var datos = null;
          var obj = new Object();		 
		  var datos2 = null;
		  var codigosSeleccionados2 = null;

          listado1.actualizaDat();
		  listado2.actualizaDat();
          datos = listado1.datos;
		  datos2 = listado2.datos;
		  

          codSeleccionados = listado1.codSeleccionados();
		  codSeleccionados2 = listado2.codSeleccionados();	
          if (codSeleccionados.length > 1) {
                    GestionarMensaje('1022');
                    return;
          }
          if ( codSeleccionados.length < 1) {
                    GestionarMensaje('4');
                    return;
          }
          
          asignarObjyMostrarModal(obj, listado1,listado2,codSeleccionados,codSeleccionados2,opcionMenu,'definirReemplazo');

             	
}
function asignarObjyMostrarModal(obj, listado1, listado2,codSeleccionados,codSeleccionados2, opcionMenu, accion){
          
		  obj.seleccionado = codSeleccionados[0];           
          obj.numPremio = listado1.extraeDato(codSeleccionados[0], 1); 
          obj.codigoProducto = listado1.extraeDato(codSeleccionados[0], 2); 
          obj.descripcion = listado1.extraeDato(codSeleccionados[0], 3);          
		  obj.oidArticuloLote =  listado1.extraeDato(codSeleccionados[0], 5);   
		  obj.numeroOrden = listado1.extraeDato(codSeleccionados[0], 9);   		  
          obj.opcionMenu = opcionMenu;		  
		  var retorno = new Array();	
          retorno[0] =  mostrarModalSICC('LPMantenimientoRemplazoPremios', accion, obj);
		
		 if(retorno[0] != null) {          
                     reemplazo77 = retorno[0];                       
					this.anadirListado2(reemplazo77);
					btnProxy(1,1);					
					deshabilitarHabilitarBoton('botonContenido','btnConsultar','A');
					deshabilitarHabilitarBoton('botonContenido','btnModificar','A');
					deshabilitarHabilitarBoton('botonContenido','btnEliminar','A');	
					
         } 
       
		  //alert("retorno: " + retorno);

}
function onTabCbConcurso(){
	focalizaBotonHTML('botonContenido','btnBuscar');
}
function onShTabCbConcurso(){
	focalizaBotonHTML('botonContenido','btnDefinirRemplazo');
}
function onTabBtnBuscar(){
	focalizaBotonHTML('botonContenido','btnDefinirRemplazo');
}
function onShTabBtnBuscar(){
	focaliza('formulario.cbConcurso');
}
function onTabBtnDefinirRemplazo(){
	   if(!estado == 'A' ){
			focaliza('formulario.cbConcurso');
	   }else{
			focalizaBotonHTML('botonContenido','btnConsultar');	
	   }
}
function onShTabBtnDefinirRemplazo(){
		focalizaBotonHTML('botonContenido','btnBuscar');
}
function fVolver() {
    window.close();
}
function accionBTN_Consultar(){
	      var opcionMenu = 'modificarDefinirReemplazo';
          var oidPlantilla = null;
          var numPlantilla = null;
          var oidParamGrales = null;
          var filaMarcada = null;
          var codSeleccionados = null;
          var datos = null;
          var obj = new Object();

          listado2.actualizaDat();
          datos = listado2.datos;

          codSeleccionados = listado2.codSeleccionados();
          if (codSeleccionados.length > 1) {
                    GestionarMensaje('1022');
                    return;
          }
          if ( codSeleccionados.length < 1) {
                    GestionarMensaje('4');
                    return;
          }
          
          tomarValoresModificar();
		  obj.opcionMenu = opcionMenu;
		  obj.oidReemplazoArticLote = listado2.extraeDato(codSeleccionados[0], 11); 	          
		  obj.valoresLista1 = get('formulario.valoresLista1');
		  mostrarModalSICC('LPMantenimientoRemplazoPremios', 'consultar', obj);
}
function accionBTN_Modificar(){
	      var opcionMenu = 'modificarDefinirReemplazo';
          var oidPlantilla = null;
          var numPlantilla = null;
          var oidParamGrales = null;
          var filaMarcada = null;
          var codSeleccionados = null;
          var datos = null;
          var obj = new Object();
		  var aux = null;

          listado2.actualizaDat();
          datos = listado2.datos;

          codSeleccionados = listado2.codSeleccionados();
          if (codSeleccionados.length > 1) {
                    GestionarMensaje('1022');
                    return;
          }
          if ( codSeleccionados.length < 1) {
                    GestionarMensaje('4');
                    return;
          }         
		  tomarValoresModificar();
		  aux = listado2.extraeDato(codSeleccionados[0], 11);	
		  obj.opcionMenu = opcionMenu;
		  obj.oidReemplazoArticLote = aux; 	          
		  obj.valoresLista1 = get('formulario.valoresLista1');
		   var retorno = new Array();	
		   retorno[0] =  mostrarModalSICC('LPMantenimientoRemplazoPremios', 'modificar', obj);	
		   if(retorno[0] != null) { 
					btnProxy(1,1);
					listado2.eliminarSelecc();		
                    reemplazo77 = retorno[0];                       
					this.anadirListado2(reemplazo77, aux);			
					listado2.actualizaDat();
					listado2.repinta();
         } 
       
		 //alert("retorno: " + retorno);
}
function accionBTN_Elimiar(){

			var e = get('formulario.posicionesEliminadas');
			btnProxy(1,1);
    		var cantElementosL1 = listado2.codSeleccionados();		
            var	codigoSeleccionado = listado2.codSeleccionados();
			var producto = listado2.extraeDato(codigoSeleccionado, 0);


			if ( cantElementosL1.length == 0){
				GestionarMensaje("4", null, null, null);
				return;
			}

			var elim = new Array();
			var sele = listado2.codSeleccionados();
			
			for(var i=0; i < sele.length; i++){
				var posicionReemplazo = listado2.extraeDato(codigoSeleccionado, 12);
				
				if(posicionReemplazo == "1") {
					GestionarMensaje('3390');
					return;
				}
			}
			
			var j = 0;
			if(producto.charAt(0) != "a"){
				for(var i=0; i < sele.length; i++){
					if(sele[i].charAt(0) != "a"  )
						 elim[j] = sele[i];
						 j++
				}
			}
		    if(e.length > 0)
			elim = e + "," + elim;
			set('formulario.posicionesEliminadas',elim);      
			if ( cantElementosL1.length > 0 )
				listado2.eliminarSelecc(); 
			if(listado2.codigos().length == 0)
				btnProxy(1,0);

}
function fGuardar(){

			 var datos = null;
			 var codSeleccionados = null;
			 var codSeleccionados2 = null;
			 
			 if(GestionarMensaje('2639')){
			 		 btnProxy(1,0); 		
					 listado2.actualizaDat();
					 listado1.actualizaDat();
					 datos = listado2.datos;
                     codSeleccionados  = listado2.codSeleccionados();	
					 codSeleccionados2 = listado1.codSeleccionados();	    					  					
					 tomarValoresLista2();	
					
					 eval('formulario').oculto = 'S';
					 set('formulario.conectorAction', 'LPMantenimientoRemplazoPremios');
				     set('formulario.accion', 'guardar'); 
					 enviaSICC('formulario');
				
			}else{
					focaliza('formulario.cbConcurso');
			}
}
function fGuardarOK(){
         if(get('formulario.opcionMenu') == 'insertar'){	
		 		 btnProxy(1,0); 
				 set('formulario.valoresLista2', "");
				 set('formulario.posicionesEliminadas', "");
				 fActualizarGrilla();
				 validarBolsaDeFaltante();
		  } else {							
						
				 window.returnValue = true;
		  }	        

}
function validarBolsaDeFaltante(){
			eval('formulario').oculto = 'S';
			set('formulario.conectorAction', 'LPMantenimientoRemplazoPremios');
			set('formulario.accion', 'validarBolsaFaltante'); 
    		enviaSICC('formulario');
}

function generarNuevaSolicitud(rta){			
		//var cantidad= 0;	
		  if(rta == 'si'){
		  	  btnProxy(1,0);
			  set('formulario.valoresLista2', "");
			  set('formulario.posicionesEliminadas', "");
					if (GestionarMensaje('2640')){ 
						  eval('formulario').oculto = 'S';
						  set('formulario.conectorAction', 'LPMantenimientoRemplazoPremios');
						  set('formulario.accion', 'generarNuevaSolicitudReemplazo'); 
						  enviaSICC('formulario');
									
					} else {							
									
									window.returnValue = true;
					}		
				 //  fActualizarGrilla();
				  /* var codigos = listado2.codigos();
				   for(var i=0; i<codigos.length ; i++){
					    indicadorActivo = listado2.extraeDato(codigos[i], 10)==""?"BLANCO":listado2.extraeDato(codigos[i], 10);
						alert(indicadorActivo);
						if(indicadorActivo == 'NO'){
							
							cantidad = cantidad + 1;
						}
				   }*/	
				  
				  validarBolsaDeFaltanteModificar();
				  
		   }
		
          

}
function validarBolsaDeFaltanteModificar(){
			var cantidad= 0;
			var codigos = listado2.codigos();
			//alert(codigos.length);
			for(var i=0; i<codigos.length; i++){
			     indicadorActivo = listado2.extraeDato(codigos[i], 10)==""?"BLANCO":listado2.extraeDato(codigos[i], 10);
			    // alert(indicadorActivo);
						if(indicadorActivo == 'NO'){
							
							cantidad = cantidad + 1;
						}
		   }	
			if(cantidad > 0){
				eval('formulario').oculto = 'S';
				set('formulario.conectorAction', 'LPMantenimientoRemplazoPremios');
				set('formulario.accion', 'validarBolsaFaltanteModificar'); 
    			enviaSICC('formulario');
			}
}
function generarNuevaSolicitudModificar(rta){
		if(rta == 'si'){
			  set('formulario.valoresLista2', "");
			  set('formulario.posicionesEliminadas', "");
					if (GestionarMensaje('2644')){ 
						  eval('formulario').oculto = 'S';
						  set('formulario.conectorAction', 'LPMantenimientoRemplazoPremios');
						  set('formulario.accion', 'generarNuevaSolicitudReemplazoModificado'); 
						  enviaSICC('formulario');
									
					} else {							
									
									window.returnValue = true;
					}		
					fActualizarGrilla();
					//validarBolsaDeFaltanteModificar();
		   }
}
function generarNuevaSolicitudModificadoERR(){
        eval("formulario").oculto= "N";
		set('formulario.posicionesEliminadas', "");	
}
function generarNuevaSolicitudERR(){

            eval("formulario").oculto= "N";
			set('formulario.posicionesEliminadas', "");	
			btnProxy(1,0);

}
function fActualizarGrilla(){
		  btnProxy(1,0);
	      var arr = new Array();
          arr[arr.length] = new Array("oid", get("formulario.cbConcurso")+"");                    
		  configurarPaginado(mipgndo2,"INCObtenerReemplazo","ConectorObtenerReemplazo","es.indra.sicc.util.DTOOID",arr);  
}
function fActualizarErr(){
		eval("formulario").oculto= "N";
}

function fGuardarERR(){
            eval("formulario").oculto= "N";
			set('formulario.posicionesEliminadas', "");

}

function tomarValoresLista2(){
       var codigos = listado2.codigos();
       var cadena = "";
	   for (var i=0; i<codigos.length ; i++ )
	   {
					
					cadena = cadena + codigos[i] + ";";
					productoReemplazado = listado2.extraeDato(codigos[i], 0)==""?"BLANCO":listado2.extraeDato(codigos[i], 0);
                    cadena = cadena + productoReemplazado + ";";

					oidProductoReemplazodo = listado2.extraeDato(codigos[i], 1)==""?"BLANCO":listado2.extraeDato(codigos[i], 1);
                    cadena = cadena + oidProductoReemplazodo + ";";

					productoReemplazo = listado2.extraeDato(codigos[i], 2)==""?"BLANCO":listado2.extraeDato(codigos[i], 2);
                    cadena = cadena + productoReemplazo + ";";

					descripcion = listado2.extraeDato(codigos[i], 3)==""?"BLANCO":listado2.extraeDato(codigos[i], 3);
                    cadena = cadena + descripcion + ";";
					
					unidades = listado2.extraeDato(codigos[i], 4)==""?"BLANCO":listado2.extraeDato(codigos[i], 4);
                    cadena = cadena + unidades + ";";

					codVentaFic = listado2.extraeDato(codigos[i], 5)==""?"BLANCO":listado2.extraeDato(codigos[i], 5);
                    cadena = cadena + codVentaFic + ";";

					oidCriterioRemplazo = listado2.extraeDato(codigos[i], 6)==""?"BLANCO":listado2.extraeDato(codigos[i], 6);
                    cadena = cadena + oidCriterioRemplazo + ";";

					criterioRemplazo = listado2.extraeDato(codigos[i], 7)==""?"BLANCO":listado2.extraeDato(codigos[i], 7);
                    cadena = cadena + criterioRemplazo + ";";

					valorCriterio = listado2.extraeDato(codigos[i], 8)==""?"BLANCO":listado2.extraeDato(codigos[i], 8);
                    cadena = cadena + valorCriterio + ";";

					numOrden = listado2.extraeDato(codigos[i], 9)==""?"BLANCO":listado2.extraeDato(codigos[i], 9);
                    cadena = cadena + numOrden + ";";

					indicadorActivo = listado2.extraeDato(codigos[i], 10)==""?"BLANCO":listado2.extraeDato(codigos[i], 10);
                    cadena = cadena + indicadorActivo + ";";

					oidReemplazoArticuloLote = listado2.extraeDato(codigos[i], 11)==""?"BLANCO":listado2.extraeDato(codigos[i], 11);
                    cadena = cadena + oidReemplazoArticuloLote + ";";

          posicionesReemplazo = listado2.extraeDato(codigos[i], 12)==""?"BLANCO":listado2.extraeDato(codigos[i], 12);
                    cadena = cadena + posicionesReemplazo + ";" ;

					IndCenServG = listado2.extraeDato(codigos[i], 13)==""?"BLANCO":listado2.extraeDato(codigos[i], 13);
                    cadena = cadena + IndCenServG + ";";

					oidCenServGar = listado2.extraeDato(codigos[i], 14)==""?"BLANCO":listado2.extraeDato(codigos[i], 14);
                    cadena = cadena + oidCenServGar + ";";

					NumMeses = listado2.extraeDato(codigos[i], 15)==""?"BLANCO":listado2.extraeDato(codigos[i], 15);
                    cadena = cadena + NumMeses + ";";

					Observaciones = listado2.extraeDato(codigos[i], 16)==""?"BLANCO":listado2.extraeDato(codigos[i], 16);
                    cadena = cadena + Observaciones + ";";

					PrecioPublico4 = listado2.extraeDato(codigos[i], 17)==""?"BLANCO":listado2.extraeDato(codigos[i], 17);
                    cadena = cadena + PrecioPublico4 + ";";

					ArticuloDespacha = listado2.extraeDato(codigos[i], 18)==""?"BLANCO":listado2.extraeDato(codigos[i], 18);
                    cadena = cadena + ArticuloDespacha + ";";

					TipoEntrega = listado2.extraeDato(codigos[i], 19)==""?"BLANCO":listado2.extraeDato(codigos[i], 19);
                    cadena = cadena + TipoEntrega + ";";

					CenServEntrega = listado2.extraeDato(codigos[i], 20)==""?"BLANCO":listado2.extraeDato(codigos[i], 20);
                    cadena = cadena + CenServEntrega + ";";

					Comunicacion = listado2.extraeDato(codigos[i], 21)==""?"BLANCO":listado2.extraeDato(codigos[i], 21);
                    cadena = cadena + Comunicacion + ";";		

					numeroPremio = listado2.extraeDato(codigos[i], 22)==""?"BLANCO":listado2.extraeDato(codigos[i], 22);
                    cadena = cadena + numeroPremio + ";";		

					descripcionProductoReemplazado = listado2.extraeDato(codigos[i], 23)==""?"BLANCO":listado2.extraeDato(codigos[i], 23);
                    cadena = cadena + descripcionProductoReemplazado + ";";		
					
					oidRegion = listado2.extraeDato(codigos[i], 24)==""?"BLANCO":listado2.extraeDato(codigos[i], 24);
					cadena = cadena + oidRegion + ";";		
				
				
					oidZona = listado2.extraeDato(codigos[i], 25)==""?"BLANCO":listado2.extraeDato(codigos[i], 25);
					cadena = cadena + oidZona + ";" ;		
				
					oidArticuloLote = listado2.extraeDato(codigos[i], 26)==""?"BLANCO":listado2.extraeDato(codigos[i], 26);
                    cadena = cadena + oidArticuloLote + ";" ;		
                    


	   }
	   set('formulario.valoresLista2',cadena);	   
	   
    }

	 function tomarValoresLista1(){
    
       set('formulario.valores',arr);	   
    }
 function anadirListado2(reemplazo77 ,aux){
		

				var newRow = new Array();
				var lista = listado2.datos;
				var lon = lista.length;	
				var oidRempla =  listado2.codSeleccionados();
				var productoReemplazado ="";
				var oid = aux;	
				var numeroOreden = 1;
				var indicadorActivo = "NO";
				if( aux == undefined){
					oid =  'a' + listado2.generaCodigo(secArtProd);
					secArtProd =  oid;               					
				}
				productoReemplazado =  + reemplazo77[0];
				oidProductoReemplazo = reemplazo77[1];
				productoReemplazo = reemplazo77[2];
				descripcion = reemplazo77[3];
                IndCenServG = reemplazo77[4];					
				oidCenServGar = reemplazo77[5];
				set('formulario.CenServGar', reemplazo77[6]);
				NumMeses = reemplazo77[7];					
				Observaciones = reemplazo77[8];
				unidades = reemplazo77[9];				
				PrecioPublico4 = reemplazo77[10];					
				ArticuloDespacha = reemplazo77[11];		     		
				TipoEntrega = reemplazo77[12];					
				CenServEntrega = reemplazo77[13];
				set('formulario.CenServEntrega', reemplazo77[14]);
				
				oidCriterioRemplazo= reemplazo77[15];
				criterioRemplazo = reemplazo77[16];
				valorCriterio = reemplazo77[17];
				Comunicacion = reemplazo77[18];
				codVentaFic = reemplazo77[19]; 
				set('formulario.oidRegion', reemplazo77[20]);//
				oidRegion = get('formulario.oidRegion');
				set('formulario.Region', reemplazo77[21]);				
				set('formulario.oidZona', reemplazo77[22]);//				
				oidZona =get('formulario.oidZona');
				 
				set('formulario.Zona', reemplazo77[23]);				
				
				oidReemplazoArticuloLote = aux;				
				set('formulario.nroPremio', reemplazo77[24]); 
				set('formulario.codigo', productoReemplazado);
				descripcionProductoReemplazado = reemplazo77[25];
				set('formulario.descripcionProducto', descripcionProductoReemplazado ); 
				set('formulario.rbAlcanceGeografico', reemplazo77[26] );
				numeroPremio = get('formulario.nroPremio');
				numeroOreden= reemplazo77[27];
				if(aux == undefined){						
					
							indicadorActivo = "SI";
				}else{
							if(reemplazo77[28] == "N"){
								indicadorActivo = "NO";
							}else{
								indicadorActivo = "SI";
							}
				}
				oidArticuloLote = reemplazo77[29];
				set('formulario.rbAlcanceGeografico', reemplazo77[30]);
					
				posicionReemplazo = reemplazo77[31];	
				
				if (lista.length == 0){

				    newRow = [oid,  productoReemplazado, oidProductoReemplazo,  productoReemplazo, descripcion, unidades, codVentaFic,	
							  oidCriterioRemplazo, criterioRemplazo, valorCriterio, 1, indicadorActivo, oidReemplazoArticuloLote, posicionReemplazo, IndCenServG, 
							  oidCenServGar, NumMeses, Observaciones, PrecioPublico4, ArticuloDespacha, TipoEntrega, CenServEntrega, Comunicacion, numeroPremio, descripcionProductoReemplazado, oidRegion, oidZona, oidArticuloLote];	

						
				}else{
						var a = new Number (0);							
					    for(var n=0; n < lista.length;n++ ){
						   if(lista[n][1] == productoReemplazado){
							 if(parseInt(lista[n][10],10) > a){
				    				a = new Number(lista[n][10]); 						    					
								}

							  }										
						 }
						
						if(numeroOreden != "" ){
								 newRow = [oid,  productoReemplazado, oidProductoReemplazo,  productoReemplazo, descripcion, unidades, codVentaFic,	
								 oidCriterioRemplazo, criterioRemplazo, valorCriterio, numeroOreden, indicadorActivo, oidReemplazoArticuloLote, posicionReemplazo, IndCenServG, 
							     oidCenServGar, NumMeses, Observaciones, PrecioPublico4, ArticuloDespacha, TipoEntrega, CenServEntrega, Comunicacion, numeroPremio, descripcionProductoReemplazado,  oidRegion, oidZona, oidArticuloLote];	
						}else{						
				   	  
				
							newRow = [oid, productoReemplazado, oidProductoReemplazo, productoReemplazo, descripcion,  unidades,   codVentaFic,	
							 oidCriterioRemplazo, criterioRemplazo, valorCriterio,  a+1,  indicadorActivo, oidReemplazoArticuloLote, posicionReemplazo, IndCenServG, 
							oidCenServGar,  NumMeses, Observaciones, PrecioPublico4, ArticuloDespacha, TipoEntrega, CenServEntrega, Comunicacion, numeroPremio, descripcionProductoReemplazado, oidRegion, oidZona, oidArticuloLote];	
				
				       }
			   }
				
            listado2.insertar(newRow);
        }
	function tomarValoresModificar(){
					var codigos = listado2.codigos();
					var cadena = "";
					codigoSeleccionado = listado2.codSeleccionados();					
					cadena = cadena +  codigoSeleccionado + ";";
					productoReemplazado = listado2.extraeDato(codigoSeleccionado, 0)==""?"BLANCO":listado2.extraeDato(codigoSeleccionado, 0);
                    cadena = cadena + productoReemplazado + ";";

					oidProductoReemplazodo = listado2.extraeDato(codigoSeleccionado, 1)==""?"BLANCO":listado2.extraeDato(codigoSeleccionado, 1);
                    cadena = cadena + oidProductoReemplazodo + ";";

					productoReemplazo = listado2.extraeDato(codigoSeleccionado, 2)==""?"BLANCO":listado2.extraeDato(codigoSeleccionado, 2);
                    cadena = cadena + productoReemplazo + ";";

					descripcion = listado2.extraeDato(codigoSeleccionado, 3)==""?"BLANCO":listado2.extraeDato(codigoSeleccionado, 3);
                    cadena = cadena + descripcion + ";";
					
					unidades = listado2.extraeDato(codigoSeleccionado, 4)==""?"BLANCO":listado2.extraeDato(codigoSeleccionado, 4);
                    cadena = cadena + unidades + ";";

					codVentaFic = listado2.extraeDato(codigoSeleccionado, 5)==""?"BLANCO":listado2.extraeDato(codigoSeleccionado, 5);
                    cadena = cadena + codVentaFic + ";";

					oidCriterioRemplazo = listado2.extraeDato(codigoSeleccionado, 6)==""?"BLANCO":listado2.extraeDato(codigoSeleccionado, 6);
                    cadena = cadena + oidCriterioRemplazo + ";";

					criterioRemplazo = listado2.extraeDato(codigoSeleccionado, 7)==""?"BLANCO":listado2.extraeDato(codigoSeleccionado, 7);
                    cadena = cadena + criterioRemplazo + ";";

					valorCriterio = listado2.extraeDato(codigoSeleccionado, 8)==""?"BLANCO":listado2.extraeDato(codigoSeleccionado, 8);
                    cadena = cadena + valorCriterio + ";";

					numOrden = listado2.extraeDato(codigoSeleccionado, 9)==""?"BLANCO":listado2.extraeDato(codigoSeleccionado, 9);
                    cadena = cadena + numOrden + ";";

					indicadorActivo = listado2.extraeDato(codigoSeleccionado, 10)==""?"BLANCO":listado2.extraeDato(codigoSeleccionado, 10);
                    cadena = cadena + indicadorActivo + ";";

					oidReemplazoArticuloLote = listado2.extraeDato(codigoSeleccionado, 11)==""?"BLANCO":listado2.extraeDato(codigoSeleccionado, 11);
                    cadena = cadena + oidReemplazoArticuloLote + ";";
					
          posicionesReemplazo = listado2.extraeDato(codigoSeleccionado, 12)==""?"BLANCO":listado2.extraeDato(codigoSeleccionado, 12);
          					cadena = cadena + posicionesReemplazo + ";" ;
					
					IndCenServG = listado2.extraeDato(codigoSeleccionado, 13)==""?"BLANCO":listado2.extraeDato(codigoSeleccionado, 13);
                    cadena = cadena + IndCenServG + ";";

					oidCenServGar = listado2.extraeDato(codigoSeleccionado, 14)==""?"BLANCO":listado2.extraeDato(codigoSeleccionado, 14);
                    cadena = cadena + oidCenServGar + ";";

					NumMeses = listado2.extraeDato(codigoSeleccionado, 15)==""?"BLANCO":listado2.extraeDato(codigoSeleccionado, 15);
                    cadena = cadena + NumMeses + ";";

					Observaciones = listado2.extraeDato(codigoSeleccionado, 16)==""?"BLANCO":listado2.extraeDato(codigoSeleccionado, 16);
                    cadena = cadena + Observaciones + ";";

					PrecioPublico4 = listado2.extraeDato(codigoSeleccionado, 17)==""?"BLANCO":listado2.extraeDato(codigoSeleccionado, 17);
                    cadena = cadena + PrecioPublico4 + ";";

					ArticuloDespacha = listado2.extraeDato(codigoSeleccionado, 18)==""?"BLANCO":listado2.extraeDato(codigoSeleccionado, 18);
                    cadena = cadena + ArticuloDespacha + ";";

					TipoEntrega = listado2.extraeDato(codigoSeleccionado, 19)==""?"BLANCO":listado2.extraeDato(codigoSeleccionado, 19);
                    cadena = cadena + TipoEntrega + ";";

					CenServEntrega = listado2.extraeDato(codigoSeleccionado, 20)==""?"BLANCO":listado2.extraeDato(codigoSeleccionado, 20);
                    cadena = cadena + CenServEntrega + ";";

					Comunicacion = listado2.extraeDato(codigoSeleccionado, 21)==""?"BLANCO":listado2.extraeDato(codigoSeleccionado, 21);
                    cadena = cadena + Comunicacion + ";";		

					numeroPremio = listado2.extraeDato(codigoSeleccionado, 22)==""?"BLANCO":listado2.extraeDato(codigoSeleccionado, 22);
                    cadena = cadena + numeroPremio + ";";		

					descripcionProductoReemplazado = listado2.extraeDato(codigoSeleccionado, 23)==""?"BLANCO":listado2.extraeDato(codigoSeleccionado, 23);
                    cadena = cadena + descripcionProductoReemplazado + ";";		

					oidRegion = listado2.extraeDato(codigoSeleccionado, 24)==""?"BLANCO":listado2.extraeDato(codigoSeleccionado, 24);
                    cadena = cadena + oidRegion + ";";		

					oidZona = listado2.extraeDato(codigoSeleccionado, 25)==""?"BLANCO":listado2.extraeDato(codigoSeleccionado, 25);
                    cadena = cadena + oidZona + ";";	

					oidArticuloLote = listado2.extraeDato(codigoSeleccionado, 26)==""?"BLANCO":listado2.extraeDato(codigoSeleccionado, 26);
                    cadena = cadena + oidArticuloLote + ";" ;	
                    
    				set('formulario.valoresLista1', cadena);	   
	
	}
	function onTabConsultar(){
		focalizaBotonHTML('botonContenido','btnModificar');
	}
	function onShTabConsultar(){
		focalizaBotonHTML('botonContenido','btnDefinirRemplazo');
	}
	
    function onTabModificar(){
			focalizaBotonHTML('botonContenido','btnEliminar');
	
	}
	function onShTabModificar(){
			focalizaBotonHTML('botonContenido','btnConsultar');
	}
	function onTabEliminar(){
			focaliza('formulario.cbConcurso');
	}
	function onShTabEliminar(){
			focalizaBotonHTML('botonContenido','btnModificar');
	}


function accionBTNVerFaltantes()
{
	var obj = new Object();
	obj.oidConcurso = get("formulario.cbConcurso");
	obj.nombreConcurso = get("formulario.cbConcurso", "T");
	
	var array = mostrarModalSICC('LPMantenimientoRemplazoPremios','obtenerPendientesBolsaFaltantes',obj);
	return;
}

function habilitarBotonFaltante() {
	var concurso = get("formulario.cbConcurso");
	
	if(concurso=="")
		deshabilitarHabilitarBoton('botonContenido','btnVerFaltantes','D');
	else
		deshabilitarHabilitarBoton('botonContenido','btnVerFaltantes','A');	
}
	