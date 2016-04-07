/*
    INDRA/CAR/PROY
    $Id: contenido_periodos_eliminar.js,v 1.1 2009/12/03 19:01:31 pecbazalar Exp $
    DESC
*/
                     
    // Inicializacion de los parametros de la pantalla
    function inicializacion() {
      
           /*if (get('frmEliminarPeriodos.tipoBarra') == "eliminar")  {
                  cargarBarra('barra_periodos_eliminar', "A");                         
           } else {
                  cargarBarra('barra_periodos_eliminar');                         
           }*/
      txt_to('lblValorPais', get('frmEliminarPeriodos.hPaisDescripcion')); 

		configurarMenuSecundario("frmEliminarPeriodos");
           
      //accion('frmEliminarPeriodos.txtTodas','.disabled=true');
      //set('frmEliminarPeriodos.cbPaises','');
           posicionarCombo();

      set('frmEliminarPeriodos.txtAnio', get('frmEliminarPeriodos.hAnio'));
           focaliza('frmEliminarPeriodos.cbMarcas');

      //Validaciones si hay mensaje de error 
      if (get('frmEliminarPeriodos.errDescripcion')!='') {
             var wnd = fMostrarMensajeError(get('frmEliminarPeriodos.errCodigo'), get('frmEliminarPeriodos.errDescripcion'));
             if ((get('frmEliminarPeriodos.accion')) == 'buscar') {
                set('frmEliminarPeriodos.accion', '');

             } else if ((get('frmEliminarPeriodos.accion')) == 'eliminarPeriodo') {
                deshabilitarCombos();
             } else if ((get('frmEliminarPeriodos.accion')) == 'guardar') {
                deshabilitarCombos();
                visibilidad('capaResultado','V');
             }

      //Validaciones si no hay mensajes de error
      } else {
         if ((get('frmEliminarPeriodos.accion')) == 'buscar') {
           validacionPostAccionBuscar();
         } else if  ((get('frmEliminarPeriodos.accion')) == 'eliminarPeriodo') {
           validacionPostAccionEliminarPeriodo();  
         } else if  ((get('frmEliminarPeriodos.accion')) == 'recalcularPeriodos') {
           validacionPostAccionRecalcularPeriodos();
         } else if  ((get('frmEliminarPeriodos.accion')) == 'guardar') {
           set('frmEliminarPeriodos.accion', '');
         }
      }    
    }

    //Valida que haya periodos para mostrar en pantalla
    function validacionPostAccionBuscar () {
      if (ListaPeriodo.datos.longitud == 0) {
         //muestro el mensaje de "NO HAY DATOS" Y OCULTO LA CAPA DE PERIODOS
         visibilidad('capaResultado', 'O');
         GestionarMensaje('160','frmConsultarPeriodos.txtDescripcion');
         set('frmEliminarPeriodos.accion', '');
      } else {
         //Deshabilito los combos y el campo de texto
         deshabilitarCombos();
      }
    }


    //Muestra el mensaje para realizar Recalculo de Periodos
    function validacionPostAccionEliminarPeriodo() {
      deshabilitarCombos();
      //INTERNACIONALIZAR EL MENSAJE.....724
      if (GestionarMensaje('724')) {
         set('frmEliminarPeriodos.accion', 'recalcularPeriodos');
         envia('frmEliminarPeriodos');
      }
    }


    function validacionPostAccionRecalcularPeriodos(){
      deshabilitarCombos();
    }


    //Deshabilita los combos de la capa Busqueda
    function deshabilitarCombos() {
      /*
           accion('frmEliminarPeriodos.cbPaises','.disabled=true'); 
      accion('frmEliminarPeriodos.cbCanales','.disabled=true'); 
      accion('frmEliminarPeriodos.cbMarcas','.disabled=true'); 
      accion('frmEliminarPeriodos.txtAnio','.disabled=true'); 
           */
    }
                                
    // Se pulso el boton buscar                      
    function fBuscar() {
         if (fValidarCOMBO('frmEliminarPeriodos.cbMarcas') &&
             fValidarCOMBO('frmEliminarPeriodos.cbCanales')&&
             fValidarCTEXT('frmEliminarPeriodos.txtAnio')){

             obtenerPaisMarcaCanalAnio();
                                
             set('frmEliminarPeriodos.accion', 'buscar');
             envia('frmEliminarPeriodos');
         } 
    }
                                
    // Levanta los valores seleccionados para pais marca y canal
    function obtenerPaisMarcaCanalAnio(){
         //set('frmEliminarPeriodos.hPais', get('frmEliminarPeriodos.cbPaises'));
         set('frmEliminarPeriodos.hCanal', get('frmEliminarPeriodos.cbCanales'));
         set('frmEliminarPeriodos.hMarca', get('frmEliminarPeriodos.cbMarcas'));
         set('frmEliminarPeriodos.hAnio', get('frmEliminarPeriodos.txtAnio'));
    }
                                
    function posicionarCombo() {
		 /*
         var iSeleccionadoP = new Array();
         iSeleccionadoP[0] = get('frmEliminarPeriodos.hPais');
         set('frmEliminarPeriodos.cbPaises',iSeleccionadoP);
         */                       
         var iSeleccionadoM = new Array();
         iSeleccionadoM[0] = get('frmEliminarPeriodos.hMarca');
         set('frmEliminarPeriodos.cbMarcas',iSeleccionadoM);
                                
         var iSeleccionado = new Array();
         iSeleccionado[0] = get('frmEliminarPeriodos.hCanal');
         set('frmEliminarPeriodos.cbCanales',iSeleccionado);
    }
                                
    // Vacia todos los campos de la pantalla

	function fLimpiar() { 
        limpiarCampos();
   }

    function limpiarCampos() {
         set('frmEliminarPeriodos.cbCanales', '');
         set('frmEliminarPeriodos.cbMarcas', '');
         set('frmEliminarPeriodos.txtAnio', '');
         
                  //visibilidad('capaResultado', 'O');
                  //visibilidad('capaBotonEliminar', 'O');
                  //cargarBarra('barra_periodos_eliminar');   
                  focaliza('frmEliminarPeriodos.cbMarcas');
         
    }
                                

    
  function fBorrar() {

      if (ListaPeriodo.getSeleccion()!= '') {
         if (GestionarMensaje('131')) {
           set('frmEliminarPeriodos.accion', 'eliminarPeriodo');
           set('frmEliminarPeriodos.hPeriodoSeleccionado', ListaPeriodo.getSeleccion());
           envia('frmEliminarPeriodos');
         }
      } else {
         GestionarMensaje('416');
      }
  }

  function fGuardar() {
      if ( ((get('frmEliminarPeriodos.accion')) == 'recalcularPeriodos') ||
           ((get('frmEliminarPeriodos.accion')) == 'eliminarPeriodo') ) {
         set('frmEliminarPeriodos.accion', 'guardar');
         envia('frmEliminarPeriodos');
      }
  }                      