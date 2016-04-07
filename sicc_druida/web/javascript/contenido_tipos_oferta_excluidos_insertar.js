    //array de elementos que pueden tener el foco con TAB/SHTAB
    var elementos = new Array('txtFecDesd','txtFecHast','cbCanal', 'cbTipoOferta' );
                           

    /**
     * @author Guido Pons
     * @date 29/08/2006
     * @function onLoadPag() 
     */
     function onLoadPag() {
              configurarMenuSecundario('formulario');
              posicionaCombo();
              disabledInput();
              fMostrarMensajeError();
              focaliza('formulario.txtFecDesd');
     }

     function disabledInput() {
           if (   (get('formulario.opcionMenu') == "ConsultarTipoOfertaExcluido")
               || (get('formulario.opcionMenu') == "EliminarTipoOfertaExcluido") ) {
              accion('formulario.txtFecDesd','.disabled=true');  
              accion('formulario.txtFecHast','.disabled=true');  
              accion('formulario.cbCanal','.disabled=true');  
              accion('formulario.cbTipoOferta','.disabled=true');  
              
           }     
     
     }
     function posicionaCombo(){
                  var array = new Array();
 
                  array = new Array();
                  array[0]=get("formulario.pais");
                  set('formulario.cbPais',array);	
                  
                  array = new Array();
                  array[0]=get("formulario.hCbanal");
                  set('formulario.cbCanal',array);
                  
                  onChangeCanal();
	    

     }


    /**
     * @author Guido Pons
     * @date 29/08/2006
     * @function onChangeCanal()
     * @descripcion: Este método se activa al cambiar el valor de cbCanal 
     *
     *  --> Llamar al método recargaCombo con los parámetros: 
            - cbTipoOferta 
            - "PREObtenerTiposOfertaPorCanal" 
            - "DTOOID" 
            - Parametros del DTOOID 
            - DTOOID.oid = oid del Canal seleccionado en el combo cbCanal 
            - DTOOID.pais = Pais activo 
            - DTOOID.idioma = Idioma del usuario 
    *   --> Obtenemos un DTOSalida y cargamos el combo cbTipoOferta 
     */
     function onChangeCanal(){
        var canal = get('formulario.cbCanal');
        if (canal != '') {
                              var pais = get('formulario.pais');
                              var idioma = get('formulario.idioma');

                              recargaCombo(
                                         'formulario.cbTipoOferta',
                                         'PREObtenerTiposOfertaPorCanal', 
                                         'es.indra.sicc.util.DTOOID',
                                         [["oid", canal],["oidPais", pais], ["oidIdioma", idioma]],
                                         'marcaCombo(datos)'
                              );



        }
     } 
     
     
     function marcaCombo(datos) {
            var sel = new Array();
            sel[0]=get("formulario.hCbTipoOferta");
            set_combo('formulario.cbTipoOferta',datos, sel);
     }

    /**
     * @author Guido Pons
     * @date 29/08/2006
     * @function accionGuardar()
     * @descripcion: Se ejecuta cuando se pulsa el botón Guardar 
     *
     * @implementación: :
     * Si se ingresaron todos los campos obligatorios de la pantalla 
     *     Si fechaHasta < fechaDesde 
     *            --> Mostrar el mensaje UIGEN0002: "La fecha desde debe ser menor o igual que la fecha hasta" 
     *     Sino 
     *            --> Llamar a la LPMantenimientoTipoOfertaExcluido con: 
     *                 accion = "guardar" 
     *                opcionMenu 
     *     Fin Sino 
     * Sino 
     *     -->Mostrar el mensaje generico: El campo xxx es obligatorio 
     */


  function guardar(){
     
      if(sicc_validaciones_generales()){
        if(validacionfecHastfecDesd()){      
            validacionfecHastfecDesd();
            eval('formulario').oculto = "S";
            set('formulario.hCbTipoOferta',get('formulario.cbTipoOferta'));
            set('formulario.hCbanal',get('formulario.cbCanal'));
            set('formulario.oidTipoOfertaExcluida',get('formulario.oidTipoOfertaExcluida'));
            set('formulario.conectorAction','LPMantenimientoTipoOfertaExcluido'); 
            set('formulario.accion','guardar');
            enviaSICC('formulario');
        }
      }
  }

  function guardarCorrecto() {
           if (get('formulario.opcionMenu') == "InsertarTipoOfertaExcluido") {
               fLimpiar();   
           }
           else {
                window.close();
           }
           
  }

  function guardarError() {
  }  
 
 
		//funcion para fecHast y su validación con fecDesd
  function validacionfecHastfecDesd(){
			if ((get('formulario.txtFecHast','T').toString()=="") || 
			(get('formulario.txtFecDesd','T').toString()==""))
				//en este caso no hay alguno de los valores introducidos y no se puede realizar la verificación.
				return true;
			
				var errorLevel = EsFechaValida(get('formulario.txtFecDesd','T') ,get('formulario.txtFecHast','T') , "formulario", "N");
				
			
			if ( errorLevel == 3){
			     cdos_mostrarAlert(GestionarMensaje("FacTipoOfertExclu.fecHastfecDesd.message"));
                 focaliza('formulario.txtFecDesd');                 
                 return false
			}else
			     return true;
		}    

/*************** Funciones TOOLBAR ****************/

    function fGuardar() {
        guardar();
    } 
    
    function fLimpiar() {
        set("formulario.txtFecDesd", ""); 
        set("formulario.txtFecHast", ""); 

        set("formulario.cbTipoOferta","");    
        set("formulario.cbCanal","");    
        
        focaliza('formulario.txtFecDesd');
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
