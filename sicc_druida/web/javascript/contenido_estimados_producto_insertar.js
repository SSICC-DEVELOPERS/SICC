//array de elementos que pueden tener el foco con TAB/SHTAB
var elementos = new Array('cbCentroDistribucion','cbLineaArmado','cbMarca',
                'cbCanal', 'cbPeriodo', 'txtCodigoProducto', 
                'txtUnidadesEstimadas', 'ChkFueraPedido', 'cbProcedencia');
                
/*------------------------------------------------------------------------------------------------- */
     function onLoadPag() {
            configurarMenuSecundario('formulario');      
            cargaPantalla();
            disabledInput();
            fMostrarMensajeError();
            focaliza('formulario.cbCentroDistribucion');               
            accion('formulario.txtDescripcionProducto', '.disabled=true');			
			var opcionMenu = get('formulario.opcionMenu');
			if (opcionMenu == 'modificar') {
				accion('formulario.cbCentroDistribucion', '.disabled=true');
                accion('formulario.cbLineaArmado', '.disabled=true');
                accion('formulario.cbMarca', '.disabled=true');
                accion('formulario.cbCanal', '.disabled=true');
                accion('formulario.cbPeriodo', '.disabled=true');				
                accion('formulario.txtCodigoProducto', '.disabled=true');                
			}
     }
/*--------------------------------------------------------------------------------------------------------*/

     function disabledInput() {
              
              accion('formulario.cbProcedencia', '.disabled=true');
              var acc = get('formulario.accion');
              if (acc != 'detalleModificar'){
                  accion('formulario.cbPeriodo', '.disabled=true');
              }
              if (acc == 'detalle') {
                  //Deshabilita inputs
                  accion('formulario.cbCentroDistribucion', '.disabled=true');
                  accion('formulario.cbLineaArmado', '.disabled=true');
                  accion('formulario.cbMarca', '.disabled=true');
                  accion('formulario.cbCanal', '.disabled=true');
                  accion('formulario.cbProcedencia', '.disabled=true');
                  accion('formulario.txtCodigoProducto', '.disabled=true');
                  accion('formulario.txtUnidadesEstimadas', '.disabled=true');
				  /* BELC400000345 - dmorello, 24/04/2007: Se quitó ChkFueraPedido */
                  //accion('formulario.ChkFueraPedido', '.disabled=true');
                  
              }
     }
  
/*--------------------------------------------------------------------------------------------------------*/
     function cargaPantalla(){
                   var opcionMenu = get('formulario.opcionMenu');
                   if (opcionMenu == 'insertar') {
                      set('formulario.cbCentroDistribucion',new Array(get('formulario.hOidCentroDistribucionDefecto')));
                   }   
                   else {
                      set('formulario.cbCentroDistribucion', new Array(get('formulario.hCbCentroDistribucion')));
                      set('formulario.cbMarca',new Array(get('formulario.hCbMarca')));
                      set('formulario.cbCanal',new Array(get('formulario.hCbCanal')));
                      onChangeCbMarca();
                      set('formulario.txtCodigoProducto', get('formulario.htxtCodigoProducto'));                   
                      set('formulario.txtUnidadesEstimadas', get('formulario.htxtUnidadesEstimadas'));
					  /* BELC400000345 - dmorello, 24/04/2007: Se eliminó ChkFueraPedido */
                      //var fueraPedido = get('formulario.hChkFueraPedido');
                      //fueraPedido = (fueraPedido=="No") ? "N" : "S";
                      //set('formulario.ChkFueraPedido', fueraPedido);
					  /* Fin BELC400000345 dmorello 24/04/2007 */
                   }  
                   onChangeCbCentroDistribucion();
                   set('formulario.cbProcedencia',new Array(get('formulario.hCbProcedencia')));                                     
     }
     

/*--------------------------------------------------------------------------------------------------------*/
 function onChangeCbCentroDistribucion() {
 
        centroDistribucion = get('formulario.cbCentroDistribucion');
        if (centroDistribucion != '') {
                              var idioma = get('formulario.idioma');

                              recargaCombo(
                                         'formulario.cbLineaArmado',
                                         'APEObtenerLineasArmadoCD', 
                                         'es.indra.sicc.util.DTOOID',
                                         [["oid", centroDistribucion], ["oidIdioma", idioma]],
                                         'setearCbLineaArmado(datos)'
                              );



        }
     } 

//--------------------------------------------------------------------------------------------------------

        function setearCbLineaArmado(datos) {
            
            var opcionMenu = get('formulario.opcionMenu');
            var arrayNuevo = new Array();
            if (opcionMenu != 'insertar') {
               arrayNuevo[0]=get("formulario.hCbLineaArmado");
               set_combo('formulario.cbLineaArmado',datos, arrayNuevo);
               return;
            }   

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

/*--------------------------------------------------------------------------------------------------------*/     
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


/*---------------------------------------------------------------------------------------------------------
Invocar a la LPMantenerEstimadosProducto con accion = "guardar" pasando con envio oculto los 
valores de pantalla
*/
    function guardar(){
     
        if(sicc_validaciones_generales()){
            eval('formulario').oculto = "S";

            set('formulario.hCbCentroDistribucion',get('formulario.cbCentroDistribucion'));
            set('formulario.hCbLineaArmado',get('formulario.cbLineaArmado'));
            set('formulario.hCbMarca',get('formulario.cbMarca'));
            set('formulario.hCbCanal',get('formulario.cbCanal'));            
            set('formulario.hCbPeriodo',get('formulario.cbPeriodo'));
            set('formulario.hCbProcedencia',get('formulario.cbProcedencia'));
            set('formulario.txtCodigoProducto',get('formulario.txtCodigoProducto'));
            set('formulario.txtUnidadesEstimadas',get('formulario.txtUnidadesEstimadas'));
            set('formulario.ChkFueraPedido',get('formulario.ChkFueraPedido'));            
            
            set('formulario.conectorAction','LPMantenerEstimadosProducto'); 
            set('formulario.accion','guardar');
            enviaSICC('formulario');
          }
    }

  function guardarCorrecto() {
           if (get('formulario.opcionMenu') == "insertar") {
               fLimpiar();   
           }
           else {
                window.close();
           }
  }

  function guardarError() {
  }  
 
/*--------------------------------------------------------------------------------------------------------*/
/*************** Funciones TOOLBAR ****************/

    function fGuardar() {
        guardar();
    } 
    
    function fLimpiar() {

        
        var opcionMenu = get('formulario.opcionMenu');
        if (opcionMenu == 'insertar') {
            set('formulario.cbCentroDistribucion', new Array(get('formulario.hOidCentroDistribucionDefecto')));
            onChangeCbCentroDistribucion();
        
            set("formulario.cbMarca","");    
            set("formulario.cbCanal","");    
            set("formulario.txtCodigoProducto","");    
            set("formulario.txtUnidadesEstimadas",""); 
            set("formulario.ChkFueraPedido","");                
            set("formulario.cbPeriodo","");    
            set("formulario.cbPeriodo", new Array(''));
            accion('formulario.cbPeriodo', '.disabled=true');
			set("formulario.txtDescripcionProducto","");

        } else if (opcionMenu == 'modificar') {
            //set('formulario.cbCentroDistribucion',new Array(get('formulario.hCbCentroDistribucion')));
            //set('formulario.cbLineaArmado',new Array(get('formulario.hCbLineaArmado')));                
            //set('formulario.cbMarca',new Array(get('formulario.hCbMarca')));    
            //set('formulario.cbCanal',new Array(get('formulario.hCbCanal')));  
            //GestionarComboPeriodo();
            //set('formulario.cbPeriodo',new Array(get('formulario.hCbPeriodo')));  
            //set('formulario.txtCodigoProducto', get('formulario.htxtCodigoProducto'));  
            set('formulario.txtUnidadesEstimadas', get('formulario.htxtUnidadesEstimadas'));  
			/* BELC400000345 - dmorello, 24/04/2007: Se eliminó ChkFueraPedido */
            //set('formulario.ChkFueraPedido', get('formulario.hChkFueraPedido'));  
        }
        
        focaliza('formulario.cbCentroDistribucion');
    }    
 
    function fVolver() {	
		window.close();
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
	function descripcionProducto(){
  	    eval('formulario').oculto = 'S';			        
        set('formulario.conectorAction', 'LPMantenerEstimadosProducto');
        set('formulario.accion', 'buscar'); 
        enviaSICC('formulario'); 
	}
	function fverProducto(desProducto){
			set('formulario.txtDescripcionProducto',desProducto);		
	}
	function fProductoERR(){
		focaliza('formulario.txtCodigoProducto');
        set('formulario.txtDescripcionProducto', '');	

	}
	
	