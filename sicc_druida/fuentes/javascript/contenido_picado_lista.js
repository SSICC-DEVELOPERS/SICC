//array de elementos que pueden tener el foco con TAB/SHTAB
var elementos = new Array('cbCentroDistribucion','cbLineaArmado','cbMarca', 'cbCanal',
'cbPeriodo', 'txtFechaDesde', 'txtFechaHasta', 'txtTerritorio','cbTerritoriosAniadidos');



function onLoadPag(){  
    configurarMenuSecundario('formulario');    
    opcionMenu = get('formulario.opcionMenu');
    eval (ON_RSZ); 
    fMostrarMensajeError();
    set('formulario.cbCentroDistribucion',new Array(get('formulario.hOidCentroDistribucionDefecto')));

    onChangeCentroDistribucion();


}


function onChangeCentroDistribucion(){
    if(get('formulario.cbCentroDistribucion') != ''){
        accion('formulario.cbLineaArmado', '.disabled=false');
        recargaCombo('formulario.cbLineaArmado', 'APEObtenerLineasArmadoCD', 
          'es.indra.sicc.util.DTOOID', 
          [['oid', get('formulario.cbCentroDistribucion')], 
          ['oidIdioma', get('formulario.idioma')]], 
          'setearCbLineaArmado(datos)' );
    } else {
        set_combo('formulario.cbLineaArmado', arrayVacio());
    }
}


        function setearCbLineaArmado(datos) {
            
            var opcionMenu = get('formulario.opcionMenu');
            var arrayNuevo = new Array();

			arrayNuevo[0] = new Array('','');
            arrayNuevo = arrayNuevo.concat(datos);
            set_combo('formulario.cbLineaArmado',arrayNuevo);
        
            /* Se agrega la seleccion de la linea por defecto */
            var longitudCombo = combo_get('formulario.cbLineaArmado', 'L');
            var oidsLineasDef = get('formulario.hOidsLineasArmadoDefecto').split('|');
            // Comienzo desde 1 para obviar la primera linea, que se que esta en blanco
            for (var i = 1; i < longitudCombo; i++) {
                var value = combo_get('formulario.cbLineaArmado', 'V', i);
                for (var j = 0; j < oidsLineasDef.length; j++) {
                    if (value == oidsLineasDef[j]) {
                        set('formulario.cbLineaArmado', new Array(value));
                        // Salgo de los FOR anidados
                        j = oidsLineasDef.length;
                        i = longitudCombo;
                    }
                }
            }
        }

    function onChangeCbMarca(){
    	GestionarComboPeriodo();
    }


    function onChangeCanal(){
    	GestionarComboPeriodo();
    }

    function GestionarComboPeriodo() {
        if( get('formulario.cbMarca')=='' || get('formulario.cbCanal')=='' ){
    		if( combo_get('formulario.cbPeriodo', 'L') > 0 ){
                set_combo('formulario.cbPeriodo', arrayVacio());
            }
            accion('formulario.cbPeriodo', '.disabled=true');
        }else{
            accion('formulario.cbPeriodo', '.disabled=false');
            set_combo('formulario.cbPeriodo', arrayVacio());
            recargaComboPeriodo();
        }
    }

    function arrayVacio(){
    	var array = new Array();
    	array[0] = new Array('','');
    	return array;
    }

    function recargaComboPeriodo(){
    	recargaCombo('formulario.cbPeriodo', 'CRAObtenerPeriodos', 'es.indra.sicc.dtos.cra.DTOPeriodo', armarArrayDTOPeriodo(), 'marcaCbPeriodo(datos)');
    }

    function marcaCbPeriodo(datos){
    	    var sel = new Array();
            sel[0]=get("formulario.hCbPeriodo");
            set_combo('formulario.cbPeriodo',datos, sel);
    }

    function asignarArrayACombo(datos){
    	if( datos != null && datos.length > 0 ){
            for(i = 0; i < datos.length; i++){
    			combo_add('formulario.cbPeriodo', datos[i][0], datos[i][1]);
            }
        }
    }

    function armarArrayDTOPeriodo(){
        var marca = get('formulario.cbMarca');
        var canal = get('formulario.cbCanal');
        var array = new Array();
        var index = 0;
    
        if( marca != null && marca[0] != null && marca[0] != '' ){
            array[index] = new Array('marca', marca[0]);
            index++;
        }
    
        if( canal != null && canal[0] != null && canal[0] != '' ){
            array[index] = new Array('canal', canal[0]);
            index++;
        }
    
        var pais = get("formulario.pais");
        array[index] = ["pais", pais];
        return array;
    }


function tab(elemento){
            try{
                     for(i=0; i < elementos.length; i++){
                              if( elementos[i] == elemento ){
                                        if( i == elementos.length - 1 )   i = 0;
                                        else   i++;
                                        document.selection.empty();
                                        focaliza('formulario.' + elementos[i]);	
                                        return;
                                }
                     }
                 }
            catch(e){
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
                                        focaliza('formulario.' + elementos[i]);
                                        return;
                              }
                     }
            }catch(e){
                     shtab(elementos[i]);
            }
}

   function generar(formato){
      if(sicc_validaciones_generales('grupo1')){
		  if(validarFechas()){

                           
             var a = new Object();
             a.accion = 'generar';

			 a.centroDist = get('formulario.cbCentroDistribucion');
			 a.centroDistDesc = get('formulario.cbCentroDistribucion','T');

			 a.lineaArmado = get('formulario.cbLineaArmado');
 			 a.lineaArmadoDesc = get('formulario.cbLineaArmado','T');
						 
 			 a.periodo = get('formulario.cbPeriodo');
             a.periodoDesc = get('formulario.cbPeriodo','T');

			 a.fechaValorDesde = get('formulario.txtFechaDesde');
             a.fechaValorHasta = get('formulario.txtFechaHasta');  

             select_combo('formulario.cbTerritoriosAniadidos');
			 a.territorio = get('formulario.cbTerritoriosAniadidos','T');

			 //var elementos = get('formulario.cbTerritoriosAniadidos','V')
			 //for (var i=0; i<=elementos - 1; i++){
			 //	a.territorio[i] = get('formulario.cbTerritoriosAniadidos','T')[i];
			 //}

			 a.formatoSalida = formato;
             mostrarModalSICC('LPVisualizarListaPicado','generar', a);  
		  }             
      }      
   }

        function validarTerritorio(){
			if (get('formulario.txtTerritorio') != null && get('formulario.txtTerritorio') != ''){
				if(sicc_validaciones_generales('grupo2')){
					 eval('formulario').oculto = "S";
					 set('formulario.conectorAction','LPVisualizarListaPicado'); 
					 set('formulario.accion','validar');
					 enviaSICC('formulario');
				}
			}
		}
		function noExisteTerritorio(){
			GestionarMensaje("APEUI066", get('formulario.txtTerritorio',null, null));
		    set('formulario.txtTerritorio', '');  
		}

		function existeTerritorio(){
				 //Pasa un elemento de la lista de disponibles a la de seleccionados   
				 traspasar('formulario.txtTerritorio','formulario.cbTerritoriosAniadidos');              
		}

        function eliminando(){
			validarTerritorio();
			focaliza("formulario.txtTerritorio");
        }   
           
        function agregando(){   
           vectorValue = get('formulario.cbTerritoriosAniadidos','V');   
           for (var i=0;i <= vectorValue.length - 1;i++){   
                del_combo('formulario.cbTerritoriosAniadidos','V', vectorValue[i]);
           }                   
   		   focaliza("formulario.txtTerritorio");
        }   

		//Pasa un elemento de la lista origen a la destino   
        function traspasar(listaOrigen,listaDestino){   
           txtValue = get(listaOrigen,'V');   
           if ((txtValue != null) && (txtValue != '')){   
				var codigos = combo_get(listaDestino,'L')
				combo_add(listaDestino,codigos,txtValue);   
                set(listaOrigen,'');
           }   
        }

		function fLimpiar(){
				set('formulario.txtFechaDesde', '');        
                set('formulario.txtFechaHasta', '');        
			    set('formulario.txtTerritorio', '');  
		        set('formulario.cbCentroDistribucion',new Array(get('formulario.hOidCentroDistribucionDefecto')));
				onChangeCentroDistribucion();       
				focaliza("formulario.cbCentroDistribucion");
		}

	   function validarFechas(){
		  var fechaDesde = get('formulario.txtFechaDesde');
		  var fechaHasta = get('formulario.txtFechaHasta');
		  var periodo = get('formulario.cbPeriodo');
		  var formatoFecha = get('formulario.hFormatoFechaPais');

		  if ((fechaDesde == '' || fechaDesde == null) && (periodo  == '' || periodo  == null)){
				GestionarMensaje("APEUI067");
				focaliza("formulario.cbPeriodo");
				return false;
		  }
			  
		  if(fechaDesde != ''){
			 if (! EsFechaValida_SICC(fechaDesde , "formulario")){
				GestionarMensaje("1006", formatoFecha, null, null);
				focaliza("formulario.txtFechaDesde");
				return false;
			 }
		  }
		  
		  if(fechaHasta != ''){
			 if (! EsFechaValida_SICC(fechaHasta , "formulario")){
				GestionarMensaje("1006", formatoFecha, null, null);
				focaliza("formulario.txtFechaHasta");
				return false;
			 }
		  }
		  
		  if(fechaDesde != '' && fechaHasta != ''){
			  var errorLevel = EsFechaValida( fechaDesde, fechaHasta, "formulario", "S");
			  if ( errorLevel == 3){
				 GestionarMensaje("1191");
				 focaliza('formulario.txtFechaDesde');
				 return false;
			  }
			 
		  }
		  return true;   
	   }