    //array de elementos que pueden tener el foco con TAB/SHTAB
  var elementos = new Array('txtFecDesd','txtFecHast','cbCanal', 'cbTipoOferta' );
    
  /**
  * @author Guido Pons
  * @date 29/08/2006
  * @function onLoadPag() 
  */
  function onLoadPag() {
         configurarMenuSecundario('formulario');
         DrdEnsanchaConMargenDcho('listado1',12);
         eval (ON_RSZ); 
         fMostrarMensajeError();
         focaliza('formulario.txtFecDesd');
 }
 
     /**
     * @author Guido Pons
     * @date 29/08/2006
     * @function canalOnChange() 
     * @descripcion Este método se activa al cambiar el valor de cbCanal 
 
    
     * --> Llamar al método recargaCombo con los parámetros: 
     *   - cbTipoOferta 
     *   - "PREObtenerTiposOfertaPorCanal" 
     *   - "DTOOID" 
     *   - Parametros del DTOOID 
     *   - DTOOID.oid = oid del Canal seleccionado en el combo cbCanal 
     *   - DTOOID.pais = Pais activo 
     *   - DTOOID.idioma = Idioma del usuario 
     * -->  Obtenemos un DTOSalida y cargamos el combo cbTipoOferta 
     */ 
     function canalOnChange(){
        var canal = get('formulario.cbCanal');
        if (canal != '') {
                              var pais = get('formulario.pais');
                              var idioma = get('formulario.idioma')

                              recargaCombo(
                                         'formulario.cbTipoOferta',
                                         'PREObtenerTiposOfertaPorCanal', 
                                         'es.indra.sicc.util.DTOOID',
                                         [["oid", canal],["oidPais", pais], ["oidIdioma", idioma]]                           
                              )
        }
     } 

    /**
     * @author Guido Pons
     * @date 29/08/2006
     * @function: btnModificarOnClick() 
     * @descripcion: Método que se activa al pulsar sobre el botón btModificar 
     *
     * --> Comprueba si se ha seleccionado un solo elemento de la lista resultado 
     * --> Muestra la ventana modal y emergente PGInsertarTipoOfertaExcluido 
     * --> Si ha seleccionado un solo elemento activa la LPMantenimientoTipoOfertaExcluido con: 
            - opcionMenu 
            - accion = "modificar
     */
     function btnModificarOnClick(){
             elementosSeleccionados("modificar");
      } 


     /**
     * @author Guido Pons
     * @date 29/08/2006
     * @function btnDetalleOnClick() 
     * @descripcion: Método que se activa al pulsar sobre el botón btModificar 
     */
     function btnDetalleOnClick() {
              elementosSeleccionados("detalle");
     }      
      

      /**
       * @author Guido Pons
       * @date 29/08/2006
       * @function elementosSeleccionados() 
       */
       function elementosSeleccionados(casoUsoSeleccionado) {
            var seleccionados = listado1.codSeleccionados();
            var cantSeleccionados = seleccionados.length;
            if (cantSeleccionados == 0) {
                cdos_mostrarAlert(GestionarMensaje("4", null, null, null));
                return false;
            }
            else if (casoUsoSeleccionado == "detalle" || casoUsoSeleccionado == "modificar") {
                  if (cantSeleccionados == 1) {
                            codigo = seleccionados[0];
                            var objParams = new Object();
                            objParams.oidTipoOfertaExc = seleccionados[0];
                            objParams.fdesde = listado1.extraeDato(codigo,0);
                            objParams.fhasta = listado1.extraeDato(codigo,1);
                            objParams.canal = listado1.extraeDato(codigo,2);
                            objParams.tipoOferta = listado1.extraeDato(codigo,3);
                            objParams.oidCanal = listado1.extraeDato(codigo,4);
                            objParams.oidTipoOferta = listado1.extraeDato(codigo,5);
                            objParams.opcionMenu = get('formulario.opcionMenu');                             
                           
                           if (casoUsoSeleccionado == "detalle") {
                                    mostrarModalSICC("LPMantenimientoTipoOfertaExcluido", "modificar", objParams, null, null);	
                           } else {
                                    mostrarModalSICC("LPMantenimientoTipoOfertaExcluido", "modificar", objParams, null, null);	
                                    btnBuscarOnClick();
                           }

                           return true;
                  } else {
                           cdos_mostrarAlert(GestionarMensaje("240", null, null, null));
                           return false;
                  }
            } else if (casoUsoSeleccionado == "eliminar") {
                    eliminarFilas(seleccionados, "FACEliminarTipoOfertaExcluido", mipgndo);
                    return true;
            }  
       }

 
     /**
     * @author Guido Pons
     * @date 29/08/2006
     * @function btnBuscarOnClick() 
     * @descripcion Método que se ejecuta al pulsar sobre el botón btBuscar 

        * --> Obtiene de la página los criterios de búsqueda introducidos por el usuario: 
        *    - oidCanal = oid del valor seleccionado en el cbCanal 
        *    - oidTipoOferta = oid del valor seleccionado en el cbTipoOferta 
        *    - fechaDesde = valor introducido en fechaDesde 
        *    - fechaHasta = valor introducido en fechaHasta 
        
        * Los parametros no introducidos tendrán valor Null 
        
        * --> Llamamos a configurarPaginado pasándole los siguientes parametros: 
        *   - Objeto paginado (lstResultado) 
        *   - idBusiness ("FACBuscarTiposOfertaExcluidos") 
        *   - "ConectorBuscarTiposOfertaExcluidos" 
        *   - "DTOTipoOfertaExcluido" 
        *   - Parametros del DTO: 
        *   - oidPais = Pais activo 
        *   - oidCanal 
        *   - oidTipoOferta 
        *   - fechaDesde 
        *   - fechaHasta 
        *   - idioma = Idioma del usuario 
        
        *   Si se obtuvo algún resultado 
        *       Si opcionMenu == "ModificarTipoOfertaExcluido" 
        *       -->  Mostrar el boton btModificar 
        *       Si opcionMenu == "EliminarTipoOfertaExcluido" 
        *       -->  Mostrar el boton btEliminar 
        *   Fin Si se obtuvo algún resultado 
     */
     function btnBuscarOnClick(){
         if (sicc_validaciones_generales()){
                  var idioma = get('formulario.idioma');
                  var pais = get('formulario.pais');
                  var canal = get('formulario.cbCanal');
                  var oidTipoOferta = get('formulario.cbTipoOferta');
                  var fechaDesde = get('formulario.txtFecDesd');
                  var fechaHasta = get('formulario.txtFecHast');

                  if(validacionfecHastfecDesd()){
                           configurarPaginado(mipgndo, 'FACBuscarTiposOfertaExcluidos', 'ConectorBuscarTiposOfertaExcluidos', 
                                             'es.indra.sicc.dtos.fac.DTOTipoOfertaExcluido', 
                                              [['oidIdioma',idioma],
                                              ['oidPais',pais],                                         
                                              ['oidCanal', canal], 
                                              ['fechaDesde', fechaDesde],
                                              ['fechaHasta',fechaHasta],
                                              ['oidTipoOferta',oidTipoOferta]]
                                             );
                  }
                  
       }
 }

/**********************************************************************************
*           Funciones de soporte
***********************************************************************************/
    
 function muestraLista(ultima, rowset) {
             var tamano = rowset.length;
             if (tamano > 0) {
                 listado1.setDatos(rowset);
                 visibleLista();
                  //Si se obtuvo algún resultado 
                  var opcionMenu = get('formulario.opcionMenu'); 
                  btnProxy(4, 0);
                  mipgndo.lista.maxSel = 1;                    
                  if (opcionMenu == "ModificarTipoOfertaExcluido"){
                     document.all["btnDetalle"].style.visibility='hidden';                   
                     document.all["btnModificar"].style.visibility='visible'; 
                  }
                  else {
                     document.all["btnDetalle"].style.visibility='visible';                   
                     document.all["btnModificar"].style.visibility='hidden';                   
                  }
                  if (opcionMenu == "EliminarTipoOfertaExcluido"){
                     btnProxy(4, 1);
                     mipgndo.lista.maxSel = -1;                    
                  }
                  return true;
             } else {
                invisibleLista();
                btnProxy(4, 0);
                document.all["btnDetalle"].style.visibility='hidden';                                   
                document.all["btnModificar"].style.visibility='hidden';                                   
                focaliza('formulario.txtFecDesd');
                return false;
             }
 }




 function visibleLista(){
         if (!get_visibilidad('capaLista')){
         visibilidad('capaLista','V');
    }
 }

 function invisibleLista() {
         if (get_visibilidad('capaLista')){
         visibilidad('capaLista','O');
    }
 }  
 
 
/*************** Funciones TOOLBAR ****************/


    /**
     * @author Guido Pons
     * @date 29/08/2006
     * @function accionEliminar() 
     * @descripcion: Este método se ejecuta al pulsar sobre el botón btEliminar 
     *
     * --> Comprueba que hay, al menos, un elemento seleccionado en la lista resultados 
     * -->Si hay algún valor seleccionado 
     * { 
     * -->DTOOIDs = Se crea un DTOOIDs con los oids de las filas seleccionadas 
     * --> Llamamos a eliminarFilas y le pasamos: 
     *      - idBusiness = "FACEliminarTipoOfertaExcluido" 
     *      - DTOOIDs 
     *      - El objeto paginado (lstResultado). 
     * }
     */
     function fBorrar(){
              elementosSeleccionados("eliminar");
     }

/**
 * @author Guido Pons
 * @date 29/08/2006
 * @function fLimpiar() 
 */
    function fLimpiar() {
        set("formulario.txtFecDesd", ""); 
        set("formulario.txtFecHast", ""); 

        set("formulario.cbTipoOferta","");    
        set("formulario.cbCanal","");    

        focaliza('formulario.txtFecDesd');
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
