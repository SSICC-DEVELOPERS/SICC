 function onLoad(){
      configurarMenuSecundario('Formulario');
      fMostrarMensajeError();
      set('Formulario.txtFechaValorDesde', '01/01/2000');
      set('Formulario.txtFechaValorHasta', get('Formulario.fechaActual'));
      focaliza('Formulario.cbMarca');
	                   
   }
//------------------------------------------------------------------------------   
   function generar(formato){
      if(sicc_validaciones_generales()){
         if(validarFechasValor()){
                        
            var a = new Object();
            a.accion = 'generar';
            a.marca = quitarItemVacio(get('Formulario.cbMarca'));
            a.marcaDesc = quitarItemVacio(get('Formulario.cbMarca','T'));
            a.canal = quitarItemVacio(get('Formulario.cbCanal'));
            a.canalDesc = quitarItemVacio(get('Formulario.cbCanal','T'));
            a.fechaValorDesde = get('Formulario.txtFechaValorDesde');
            a.fechaValorHasta = get('Formulario.txtFechaValorHasta');  
            a.clase = quitarItemVacio(get('Formulario.cbClase'));
 		    a.claseDesc = quitarItemVacio(get('Formulario.cbClase', 'T'));
   		      
            var codProd = quitarItemVacio(get('Formulario.cbProducto', 'T'));
		    var codProducto = new String();

 		    for(var k=0;k<codProd.length;k++){
		       codProducto = codProducto + "'" + codProd[k] + "',";			   
		    }

		    codProdAux = codProducto.substring(0,codProducto.length-1);
   		    codProdFinal = codProdAux.substring(1,codProdAux.length-1);
		    a.codProdCabecera = quitarItemVacio(get('Formulario.cbProducto', 'T'));               

		    a.codProducto = codProdFinal;
		    a.region = quitarItemVacio(get('Formulario.cbRegion'));
            a.regionDesc = quitarItemVacio(get('Formulario.cbRegion','T'));
            a.zona = quitarItemVacio(get('Formulario.cbZona'));
            a.zonaDesc = quitarItemVacio(get('Formulario.cbZona','T'));
            a.seccion = quitarItemVacio(get('Formulario.cbSeccion'));
            a.seccionDesc = quitarItemVacio(get('Formulario.cbSeccion','T'));
            a.territorioDesde = get('Formulario.txtTerritorioDesde');
            a.territorioHasta = get('Formulario.txtTerritorioHasta');
            a.criterio = get('Formulario.cbCriterioSeleccion');
            a.criterioDesc = get('Formulario.cbCriterioSeleccion', 'T');
            a.tipoReporte = get('Formulario.cbTipoReporte');  
            a.tipoReporteDesc = get('Formulario.cbTipoReporte', 'T');  
            a.formatoSalida = formato;
            mostrarModalSICC('CCCMovAlmaFact','generar', a);  
            
         }      
      }
   }
//------------------------------------------------------------------------------   
  function quitarItemVacio(elemento){
      var elementoADevolver = new Array();
     
      for(var k=0;k<elemento.length;k++) {
          if (elemento[k] != ''){                            
             elementoADevolver[elementoADevolver.length] = elemento[k];
          }
      }
         
      return elementoADevolver;
      
   }


//------------------------------------------------------------------------------   
   function buscarProducto(){
     var obj = new Object();

      var whnd = mostrarModalSICC('BusquedaRapidaProducto','',obj);
    
      if(whnd==null){
      }else{
	     var longitud = combo_get('Formulario.cbProducto', 'L');

         for(var k=0;k<whnd.length;k++){
		   bandera = true;
		   for(var j=0;j<longitud;j++){ 
		      var codigo = combo_get('Formulario.cbProducto', 'T', j);
			   if(codigo == whnd[k]){
                 bandera = false;
                 break;
               }
		   }

           if(bandera){
              combo_add('Formulario.cbProducto', '1', whnd[k]);
           }
    
	     }
		 select_combo('Formulario.cbProducto');
      }		
   
   
   
   }
//------------------------------------------------------------------------------   

   function validarFechasValor(){
      
      var fechaDesde = get('Formulario.txtFechaValorDesde');
      var fechaHasta = get('Formulario.txtFechaValorHasta');
      var formatoFecha = get('Formulario.hFormatoFechaPais');
            
     
      if (! EsFechaValida_SICC(fechaDesde, "Formulario")){
          GestionarMensaje("1006", formatoFecha, null, null);
          focaliza("Formulario.txtFechaValorDesde");
          return false;
      }
     
      if(! EsFechaValida_SICC(fechaHasta, "Formulario")){
          GestionarMensaje("1006", formatoFecha, null, null);
          focaliza("Formulario.txtFechaValorHasta");
          return false;
      }
                 
      var errorLevel = EsFechaValida( fechaDesde, fechaHasta, "Formulario", "S");
      if ( errorLevel == 3){
          GestionarMensaje("1191");
          focaliza('Formulario.txtFechaValorDesde');
          return false;
      }
     
      return true;   
   
   }
   

   
//------------------------------------------------------------------------------  

//------------------------------------------------------------------------------          
   function cambioMarcaCanal(){
         
     opcionesRegion = new Array();     
     set_combo('Formulario.cbRegion',opcionesRegion);        
     tipoM1 = get('Formulario.cbMarca','V');
     tipoC1 = get('Formulario.cbCanal','V');
     combo_add('Formulario.cbRegion', '', '');

     for(var k=0;k<lstRegion.datos.longitud;k++) {
        for(var y=0;y<tipoM1.length;y++){
          for(var x=0;x<tipoC1.length;x++){
             if ((lstRegion.datos.ij(k,2) == tipoM1[y])&&
                 (lstRegion.datos.ij(k,3) == tipoC1[x])){ 			 
                combo_add('Formulario.cbRegion',lstRegion.datos.ij(k,0),lstRegion.datos.ij(k,1));
      
             }
           }
        }
    }
    cambioRegionMarcaCanal();
  } 
//------------------------------------------------------------------------------   
   
   /*function cambioRegionMarcaCanal(){
         
     opcionesNZona = new Array();   
     var aCombo = new Array(new Array("",""));
  
     set_combo('Formulario.cbZona', aCombo, []); 
     set_combo('Formulario.cbSeccion', aCombo, []); 
     
     set_combo('Formulario.cbZona',opcionesNZona);        
  
	 tipoM = get('Formulario.cbMarca','V');
     tipoC = get('Formulario.cbCanal','V');
     tipoR = get('Formulario.cbRegion','V');          
     combo_add('Formulario.cbZona', '', '');
       
     for(var k=0;k<lstZona.datos.longitud;k++) {
        for(var y=0;y<tipoM.length;y++){
          for(var x=0;x<tipoC.length;x++){
            for(var z=0;z<tipoR.length;z++){              
               if ((lstZona.datos.ij(k,3) == tipoM[y])&&
                   (lstZona.datos.ij(k,4) == tipoC[x])&&
                   (lstZona.datos.ij(k,1) == tipoR[z])){
                  combo_add('Formulario.cbZona',lstZona.datos.ij(k,0),lstZona.datos.ij(k,2));
        
               }
             }
           }
        }
    }  
  } */

 //------------------------------------------------------------------------------
 // agregado por HRCS (Fecha 06/01/2007)
  function cambioRegionMarcaCanal(){
    
    opciones = new Array();
    set_combo('Formulario.cbZona',opciones);
    set_combo('Formulario.cbSeccion',opciones);
        
    combo_add('Formulario.cbZona', '', '');
	combo_add('Formulario.cbSeccion', '', '');

    var regiones = quitarItemVacio(get('Formulario.cbRegion'));
    //var pais = get('Formulario.cbPais');
	var pais = get('Formulario.pais');
    var regionConc = new String();
    
    for(i=0;i<regiones.length;i++){
        regionConc += regiones[i] + "x";
    }
         
    regionConc = regionConc.substring(0, regionConc.length-1);

    
    var arr = new Array();
    arr[arr.length] = ['cadena', regionConc];
    arr[arr.length] = ['oidPais', pais]
    
    if(regionConc != ''){
        recargaCombo("Formulario.cbZona", "REPRecargaZonas", "es.indra.sicc.util.DTOString",arr);
    }     
    
  }

//------------------------------------------------------------------------------     

   function cambioCanal(){
    cambioMarcaCanal();
  }    

//------------------------------------------------------------------------------               
   function cambioZona(){
     /*opciones = new Array();
     set_combo('Formulario.cbSeccion',opciones);              
     var zona = get('Formulario.cbZona','V');
     combo_add('Formulario.cbSeccion', '', '');
     
     for(var k=0;k<lstSecciones.datos.longitud;k++) {
        for(var y=0;y<zona.length;y++){
           if (lstSecciones.datos.ij(k,0) == zona[y]){ 			 
              combo_add('Formulario.cbSeccion',lstSecciones.datos.ij(k,1),lstSecciones.datos.ij(k,2));
           }
        }
     }*/
     opciones = new Array();
     set_combo('Formulario.cbSeccion',opciones);
        
     combo_add('Formulario.cbSeccion', '', '');
     var zonas = quitarItemVacio(get('Formulario.cbZona'));
     //var pais = get('Formulario.cbPais');
	 var pais = get('Formulario.pais');
     var zonaConc = new String();
    
     for(i=0;i<zonas.length;i++){
        zonaConc += zonas[i] + "x";
     }
         
     zonaConc = zonaConc.substring(0, zonaConc.length-1);

     var arr = new Array();
     arr[arr.length] = ['cadena', zonaConc];
     arr[arr.length] = ['oidPais', pais]
    
     if(zonaConc != ''){
        recargaCombo("Formulario.cbSeccion", "REPRecargaSecciones", "es.indra.sicc.util.DTOString",arr);
     }
   }
   
//------------------------------------------------------------------------------   
   function fLimpiar(){
     var aCombo = new Array(new Array("",""));
     set('Formulario.txtFechaValorDesde', '');
     set('Formulario.txtFechaValorHasta', '');
     set_combo('Formulario.cbRegion', aCombo, []); 
     set_combo('Formulario.cbZona', aCombo, []); 
     set_combo('Formulario.cbSeccion', aCombo, []); 
     set_combo('Formulario.cbProducto',aCombo, []);
     set('Formulario.txtTerritorioDesde', '');
     set('Formulario.txtTerritorioHasta', '');
   
     focaliza('Formulario.cbMarca');
   }
   
  
