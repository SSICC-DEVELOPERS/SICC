function onLoadCargarBarra() {
         configurarMenuSecundario("frmConsultarListaConsultoras");
                 
         fMostrarMensajeError();
         
      	// alert("Caso de uso inicial: " + get('frmConsultarListaConsultoras.hCasoDeUso'));
         if( get('frmConsultarListaConsultoras.hCasoDeUso') == 'Consultar mensaje' ||
             get('frmConsultarListaConsultoras.hCasoDeUso') == "Eliminar mensaje" ){
             habilitarBotonAceptar();
             deshabilitarTodos();
             posicionarCombo();
             tipoPeriodoOnChange();
                  
             
         }else if( get('frmConsultarListaConsultoras.hCasoDeUso') == 'Modificar mensaje' ){
                   posicionarCombo();
                   tipoPeriodoOnChange();
                   permanenciaMensajeOnChange();
                   estadoExclusionTipologia();
				   accion('frmConsultarListaConsultoras.txtCodigoMensaje','.disabled=true');
               } else{ // si es insertar
                        permanenciaMensajeOnChange();
                        accion('frmConsultarListaConsultoras.chkExclusionTipologia','.disabled=true');
                        if( cbModulo.disabled == false ){
                           focaliza('frmConsultarListaConsultoras.TextoFijo','');
                        }
			   }

               //para ventanas modales no se usa envia oculto
               if( get('frmConsultarListaConsultoras.hCasoDeUso') != 'Insertar mensaje' ){
                  eval( 'frmConsultarListaConsultoras' ).oculto = 'N';
               }

      }
      
//------------------------------------------------------------------------------

      function habilitarBotonAceptar(){
         a = get( 'frmConsultarListaConsultoras.hAsignacionDestinatarios' ).toString().split(',');
         var cons = get('frmConsultarListaConsultoras.cteOidConsultora');
         var ped  = get('frmConsultarListaConsultoras.cteOidPedido');

         for(var i=0;i<a.length;i++){
            if( (a[i] == cons) ||(a[i] == ped) ){
               document.all['capaBotonAceptar'].style.visibility = 'hidden';
            }
         }
      }

//------------------------------------------------------------------------------
      function deshabilitarTodos(){

		cargarAsignaciones();
        var tFijo = document.getElementById('TextoFijo');
        tFijo.readOnly = true;

        accion('frmConsultarListaConsultoras.cbMetacaracteresControlFormato','.disabled=true');
        accion('frmConsultarListaConsultoras.cbModulo','.disabled=true');
        accion('frmConsultarListaConsultoras.txtCodigoMensaje','.disabled=true');
        accion('frmConsultarListaConsultoras.cbTipoMensaje','.disabled=true');
        accion('frmConsultarListaConsultoras.cbPermanenciaMensaje','.disabled=true');
        accion('frmConsultarListaConsultoras.cbTipoPeriodo','.disabled=true');
        accion('frmConsultarListaConsultoras.cbPeriodoDesde','.disabled=true');
        accion('frmConsultarListaConsultoras.cbPeriodoHasta','.disabled=true');
        accion('frmConsultarListaConsultoras.txtBloqueGrupo','.disabled=true');
        accion('frmConsultarListaConsultoras.txtPermanenciaDesde','.disabled=true');
        accion('frmConsultarListaConsultoras.txtPermanenciaHasta','.disabled=true');
        accion('frmConsultarListaConsultoras.chkExclusionTipologia','.disabled=true');

        var descripcion = document.getElementById('atDescripcion');
        descripcion.readOnly = true;
               
      }

//------------------------------------------------------------------------------      

   function cargarAsignaciones(){

      //esta funcion primero obtiene los oids y descripcion del combo
      //despues lo guarda en una matriz
      //despues lo matchea contra el hidden que tiene lo que selecciono el usuario
      //y solo carga el combo con esa seleccion
	    var cantElems = combo_get("frmConsultarListaConsultoras.cbAsignacionDestinatarios", "L", "");
      var oids = new Array();

	    for (var i = 0; i < cantElems; i++){
         var oid  = combo_get("frmConsultarListaConsultoras.cbAsignacionDestinatarios", "V", i);
         var desc = combo_get("frmConsultarListaConsultoras.cbAsignacionDestinatarios", "T", i);
         if ( oid != ""){
      
	          var array = new Array(oid, desc);
	          oids[oids.length] 
     	      var desc = combo_get("frmConsultarListaConsultoras.cbAsignacionDestinatarios", "T", i);

	          if ( oid != ""){
	             var array = new Array(oid, desc);
	             oids[oids.length] = array;
	          }
	       }
      }
     
      var asignaSelec = get('frmConsultarListaConsultoras.hAsignacionDestinatarios');
      var asignaFinal   = asignaSelec.split(','); 
      var valoresCombo   = oids;
      var dato = new Array();
      var descripcion = new Array();
      
      for (var i = 0; i < valoresCombo.length; i++){
          dato = valoresCombo[i];
     
          for(var x = 0; x < asignaFinal.length; x++){
             if(dato[0] == asignaFinal[x]){
               var desc = descripcion.length;
               var temp =  new Array();
               temp[0] = dato[0];
               temp[1] = dato[1];
               descripcion[desc] =  temp;
               
             }
          }
          
      }       
      set_combo('frmConsultarListaConsultoras.cbAsignacionDestinatarios', descripcion);
   }
  
//------------------------------------------------------------------------------
                  
      function posicionarCombo(){
               var a = null;
                        
               if( get( 'frmConsultarListaConsultoras.hModuloSeleccionado' ).toString() != '' ){
                        a = new Array( get( 'frmConsultarListaConsultoras.hModuloSeleccionado' ) );
                        set( 'frmConsultarListaConsultoras.cbModulo', a );
               }

               if( get( 'frmConsultarListaConsultoras.hTipoMensajeSeleccionado' ).toString() != '' ){
                        a = new Array( get( 'frmConsultarListaConsultoras.hTipoMensajeSeleccionado' ) );
                        set( 'frmConsultarListaConsultoras.cbTipoMensaje', a );
               }

             
               if( get( 'frmConsultarListaConsultoras.hPermanenciaMensajeSeleccionado' ).toString() != '' ){
                        a = new Array( get( 'frmConsultarListaConsultoras.hPermanenciaMensajeSeleccionado' ) );
                        set( 'frmConsultarListaConsultoras.cbPermanenciaMensaje', a );
               }

            /*   if( get( 'frmConsultarListaConsultoras.hTipoPeriodoDesdeSeleccionado' ).toString() != '' ){
                        a = new Array( get( 'frmConsultarListaConsultoras.hTipoPeriodoDesdeSeleccionado' ) );
                        set( 'frmConsultarListaConsultoras.cbPeriodoDesde', a );
               }

              if( get( 'frmConsultarListaConsultoras.hTipoPeriodoHastaSeleccionado' ).toString() != '' ){
                        a = new Array( get( 'frmConsultarListaConsultoras.hTipoPeriodoHastaSeleccionado' ) );
                        set( 'frmConsultarListaConsultoras.cbPeriodoHasta', a );
               }*/


               if( get( 'frmConsultarListaConsultoras.hTipoPeriodoSeleccionado' ).toString() != '' ){
                        a = new Array( get( 'frmConsultarListaConsultoras.hTipoPeriodoSeleccionado' ) );
                        set( 'frmConsultarListaConsultoras.cbTipoPeriodo', a );
               }

               if( get( 'frmConsultarListaConsultoras.hAsignacionDestinatarios' ).toString() != '' ){
                       //alert(get( 'frmConsultarListaConsultoras.hAsignacionDestinatarios'));
                        a = get( 'frmConsultarListaConsultoras.hAsignacionDestinatarios' ).toString().split(',');
                        set( 'frmConsultarListaConsultoras.cbAsignacionDestinatarios', a );
               }
      }

//------------------------------------------------------------------------------      

     function fLimpiar(){
              
		    if( get('frmConsultarListaConsultoras.hCasoDeUso') == 'Modificar mensaje' ){
		      posicionarCombo();
		      tipoPeriodoOnChange();
		      permanenciaMensajeOnChange();
		      var texto = get('frmConsultarListaConsultoras.hTextoFijo');
		      set('frmConsultarListaConsultoras.TextoFijo', texto);
		      var descripcion = get('frmConsultarListaConsultoras.hDescripcion');
		      set('frmConsultarListaConsultoras.atDescripcion', descripcion);
		    }else{
			     if(TextoFijo.disabled == false){
				     focaliza('frmConsultarListaConsultoras.TextoFijo');
			     }

			     if(TextoFijo.disabled == false){
			     	 set('frmConsultarListaConsultoras.TextoFijo', '');
			     }
                          
			     if( atDescripcion.disabled == false ){
					   set( 'frmConsultarListaConsultoras.atDescripcion', '' );
			     }
		    }
    }

//------------------------------------------------------------------------------      


     // -----------------------------------------------------------------------
     // ------ METODOS DEL DISENO ---------------------------------------------
     // -----------------------------------------------------------------------

     function accionIncluir(){
        var contenido = get('frmConsultarListaConsultoras.TextoFijo');
        var metacaracter = document.getElementById('cbMetacaracteresControlFormato');
        var textMetacaracter = metacaracter.options[metacaracter.selectedIndex].value;
        var newText = contenido + textMetacaracter;
        set('frmConsultarListaConsultoras.TextoFijo', newText);
     }


//------------------------------------------------------------------------------     

     function asignacionDestinatariosOnChange(){

		estadoExclusionTipologia();

       // Generación de pedido
        var constPed  = get('frmConsultarListaConsultoras.cteOidPedido');
        var constCons = get('frmConsultarListaConsultoras.cteOidConsultora');
        var cbAsignac = get('frmConsultarListaConsultoras.cbAsignacionDestinatarios');
        var arr = new Array();
        arr = cbAsignac;

        for(var i=0;i<arr.length;i++){

		  if(arr[i] == constPed){
			 /*  inicio CAMBIO MSG 002 - pperez  */
             if(!validarDestinatarioPedido()){
                GestionarMensaje('1398');
                arr2 = new Array();

                for(var i=0;i<arr.length;i++){
                   if(arr[i] != constPed){
                      arr2[arr2.length] = arr[i];
                   }
				   set('frmConsultarListaConsultoras.cbAsignacionDestinatarios', arr2);
                }
                return;
             }
			 /*  fin CAMBIO MSG 002 - pperez  */
		  }
         
          if(arr[i] == constCons){
             if(contarSeleccionados()){
                GestionarMensaje('1399');
                arr2 = new Array();

                for(var i=0;i<arr.length;i++){
                   if(arr[i] != constCons){
                      arr2[arr2.length] = arr[i];
                      set('frmConsultarListaConsultoras.cbAsignacionDestinatarios', arr2);
                   }
                }
                return;
             }
          }
        }
     }

//------------------------------------------------------------------------------     


function tipoMensajeOnChange() {
	estadoExclusionTipologia();
}

/*
* Habilita el checkbox de exclusion tipologia si tipoMensaje es G2 y tipo Asignacion es Tipo Cliente.
*/
function estadoExclusionTipologia() {
	var arr = new Array();
	var constTipoCli = get('frmConsultarListaConsultoras.cteOidClasiClien');
	var constOidG2 = get('frmConsultarListaConsultoras.cteOidTipoG2');
    var cbAsignac = get('frmConsultarListaConsultoras.cbAsignacionDestinatarios');
    var tipoMens = get('frmConsultarListaConsultoras.cbTipoMensaje');
    arr = cbAsignac;
	var asignacionTipoCliente = false;

	for(var i=0;i<arr.length;i++){
		if (arr[i] == constTipoCli) {
			asignacionTipoCliente = true;
		}		  
	}

	if (asignacionTipoCliente && (constOidG2 == tipoMens)) {
		accion('frmConsultarListaConsultoras.chkExclusionTipologia','.disabled=false');
	} else {
		document.all["chkExclusionTipologia"][0].checked = false;
		accion('frmConsultarListaConsultoras.chkExclusionTipologia','.disabled=true');
	}
}


/*  incicio CAMBIO MSG 002 - pperez  */

function validarDestinatarioPedido(){

	var constPed  = get('frmConsultarListaConsultoras.cteOidPedido');
	var constOidUA  = get('frmConsultarListaConsultoras.cteOidUA');
	var constOidClasiClien  = get('frmConsultarListaConsultoras.cteOidClasiClien');

	var arr = new Array();
	arr = get('frmConsultarListaConsultoras.cbAsignacionDestinatarios');

	var valido;
	valido = false;


   /*   compruebo si se seleccionó  el Destinatario Generacion de pedidos*/
	for(var i=0;i<arr.length;i++){
		if (arr[i]  == constPed) {
			valido = true;
			break;
		}
	}

    /*  si se selecciono compruebo que no se haya sekeccionado otra cosa que no sea constOidUA, o  constOidClasiClien */
	if (valido) {
		for(var i=0;i<arr.length;i++){
			if ((arr[i] != constPed) &&
				(arr[i] != constOidUA) &&
				(arr[i] != constOidClasiClien)  ) {
				  valido = false;
				  break;
			}	
		}
	}

	return valido;
}

/*  fin CAMBIO MSG 002 - pperez  */




//------------------------------------------------------------------------------     

     function contarSeleccionados(){
        var arr = new Array();
        arr = get('frmConsultarListaConsultoras.cbAsignacionDestinatarios');

        if(arr.length > 1 ){
           return true;
        }

        //alert('la longitud del array es ' + arr.length);
     }

//------------------------------------------------------------------------------          
    
     function tipoPeriodoOnChange() {
       var tipoPeriodo = get( 'frmConsultarListaConsultoras.cbTipoPeriodo' );
       var array = new Array();
       array[0] = new Array( 'oidTipoPeriodo', tipoPeriodo );


      //SEGRecuperarPeriodosPorTipoPeriodo
       if( get('frmConsultarListaConsultoras.hCasoDeUso') == 'Consultar mensaje' ||
           get('frmConsultarListaConsultoras.hCasoDeUso') == "Eliminar mensaje" ||
           get('frmConsultarListaConsultoras.hCasoDeUso') == "Modificar mensaje"){

              recargaCombo( 'frmConsultarListaConsultoras.cbPeriodoDesde', 'SEGObtenerPeriodosPorTipoPeriodo',
              'es.indra.sicc.dtos.seg.DTOPeriodosPorTipoPeriodo', array, 'cargaPeriodosDesde(datos)' );

              recargaCombo( 'frmConsultarListaConsultoras.cbPeriodoHasta', 'SEGObtenerPeriodosPorTipoPeriodo',
              'es.indra.sicc.dtos.seg.DTOPeriodosPorTipoPeriodo', array, 'cargaPeriodosHasta(datos)' );

       }else{

             recargaCombo( 'frmConsultarListaConsultoras.cbPeriodoDesde', 'SEGObtenerPeriodosPorTipoPeriodo',
             'es.indra.sicc.dtos.seg.DTOPeriodosPorTipoPeriodo', array );

             recargaCombo( 'frmConsultarListaConsultoras.cbPeriodoHasta', 'SEGObtenerPeriodosPorTipoPeriodo',
             'es.indra.sicc.dtos.seg.DTOPeriodosPorTipoPeriodo', array );
       }
     }

//------------------------------------------------------------------------------     
    
      function cargaPeriodosDesde(datos){
      var array = new Array( get( 'frmConsultarListaConsultoras.hTipoPeriodoDesdeSeleccionado' ) );
               set_combo('frmConsultarListaConsultoras.cbPeriodoDesde', datos, array);
      }

//------------------------------------------------------------------------------      

      function cargaPeriodosHasta(datos){
      var array = new Array( get( 'frmConsultarListaConsultoras.hTipoPeriodoHastaSeleccionado' ) );
               set_combo('frmConsultarListaConsultoras.cbPeriodoHasta', datos, array);
      }

//------------------------------------------------------------------------------

       // Método que se ejecuta al pulsar sobre el botón btAceptar
       function accionAceptar() {

	      var bandera = true;
		  var cbPermMen       = get('frmConsultarListaConsultoras.cbPermanenciaMensaje');
   	      var oidPermanenciaR = get('frmConsultarListaConsultoras.hOidPermanenciaR');

          if( get( 'frmConsultarListaConsultoras.opcionMenu' ) == 'Modificar mensaje' ||
              get( 'frmConsultarListaConsultoras.opcionMenu' ) == 'Insertar mensaje' ){ 

              var correcto = comprobarDatosPrincipales(); 
             
          }else{
             correcto = true;
          }
          
          if(correcto){
          
              var permanenciaDesde = get( 'frmConsultarListaConsultoras.txtPermanenciaDesde' );
              var permanenciaHasta = get( 'frmConsultarListaConsultoras.txtPermanenciaHasta' );


              if( get( 'frmConsultarListaConsultoras.hCasoDeUso' ) == 'Eliminar mensaje' ||
                  get( 'frmConsultarListaConsultoras.hCasoDeUso' ) == 'Consultar mensaje' ){

                  enviarFormulario();

              }else {
			     if(cbPermMen == oidPermanenciaR){
	  			     if(permanenciaDesde == ''){
						GestionarMensaje("MSG012");
						focaliza( 'frmConsultarListaConsultoras.txtPermanenciaDesde' );
						bandera = false;
						return;
					 }
					 
					 if(permanenciaHasta == ''){
						GestionarMensaje("MSG012");
						focaliza( 'frmConsultarListaConsultoras.txtPermanenciaHasta' );
						bandera = false;
						return;
					 }
					 
					 var codigo = EsFechaValida(permanenciaDesde, permanenciaHasta, 'frmConsultarListaConsultoras' )
					 var formatoFecha = get('frmConsultarListaConsultoras.hFormatoFechaPais');
						   
					 if(codigo == 1){
						GestionarMensaje('1006', formatoFecha.replace(/y/g,'a') , null, null);
						focaliza( 'frmConsultarListaConsultoras.txtPermanenciaDesde' );
						bandera = false;
						return;
					 }
					  
					 if(codigo == 2){
						GestionarMensaje('1006', formatoFecha.replace(/y/g,'a') , null, null);
						focaliza( 'frmConsultarListaConsultoras.txtPermanenciaHasta' );
						bandera = false;
						return;
					 }

					 if(codigo == 3){
						GestionarMensaje("MSG011");
						focaliza( 'frmConsultarListaConsultoras.txtPermanenciaDesde' );
						bandera = false;
						return;
					  }
				 }
							
				 if(bandera){
				    enviarFormulario();
				 }
			  }
               
			}
		}
//------------------------------------------------------------------------------

   function comprobarDatosPrincipales(){

      if(!sicc_validaciones_generales()){
         return false;

      }else{

         var oidPermanenciaH = get('frmConsultarListaConsultoras.hOidPermanenciaH');
         var oidPermanenciaR = get('frmConsultarListaConsultoras.hOidPermanenciaR');
         var cbPermMen       = get('frmConsultarListaConsultoras.cbPermanenciaMensaje');
         var tipoPeriodo     = get('frmConsultarListaConsultoras.cbTipoPeriodo');
         var periodoDesde    = get('frmConsultarListaConsultoras.cbPeriodoDesde');
         var periodoHasta    = get('frmConsultarListaConsultoras.cbPeriodoHasta');
    
         if(cbPermMen == oidPermanenciaH){

            if(tipoPeriodo == ''){
               GestionarMensaje('MSG009');
               focaliza('frmConsultarListaConsultoras.cbTipoPeriodo');
               return false;
            }
            if( periodoDesde == ''){
               GestionarMensaje('MSG009');
               focaliza('frmConsultarListaConsultoras.cbPeriodoDesde');
               return false; 
            } 

            if(periodoHasta == ''){      
               GestionarMensaje('MSG009');
               focaliza('frmConsultarListaConsultoras.cbPeriodoHasta');
               return false; 
            }
         }

		 
         

         var oidTipoMensaje = get('frmConsultarListaConsultoras.cbTipoMensaje'); 
         var constCons      = get('frmConsultarListaConsultoras.cteOidConsultora');
         var constPed       = get('frmConsultarListaConsultoras.cteOidPedido'); 
         var oidG1          = get('frmConsultarListaConsultoras.cteOidTipoG1'); 
         var oidG2          = get('frmConsultarListaConsultoras.cteOidTipoG2');
         var destinatario   = get('frmConsultarListaConsultoras.cbAsignacionDestinatarios');
        
         if( (oidTipoMensaje == oidG2) && ( (destinatario == constCons)|| validarDestinatarioPedido() ) ){  /*  CAMBIO MSG 002 - pperez  */
            GestionarMensaje('MSG008');
            return false;
         }else if((oidTipoMensaje == oidG1) && ( (destinatario != constCons) && (!validarDestinatarioPedido()) ) ){   /*  CAMBIO MSG 002 - pperez  */
                  GestionarMensaje('MSG007');
                  return false;
               }else{
                  return true;
               }
      }

   }
//------------------------------------------------------------------------------    

       function enviarFormulario(){
                pasarCombosAHiddens();
                set( 'frmConsultarListaConsultoras.conectorAction', 'LPMantenimientoMensajes');
                set( 'frmConsultarListaConsultoras.accion', 'Aceptar mensaje' );

                if( get('frmConsultarListaConsultoras.hCasoDeUso') == 'Consultar mensaje' ||
                    get('frmConsultarListaConsultoras.hCasoDeUso') == "Eliminar mensaje" ){
                    eval('frmConsultarListaConsultoras').oculto = 'N';
                }else{
                   eval('frmConsultarListaConsultoras').oculto = 'S';
                }
                enviaSICC( 'frmConsultarListaConsultoras' );
       }

//------------------------------------------------------------------------------       

       function insertoPedidoOk(){
          limpiarFormulario();
       }

//------------------------------------------------------------------------------       

       function modificoPedidoOk(){
          this.close();
          //limpiarFormulario();
       }       

//------------------------------------------------------------------------------

       function enviar(p1,p2,p3,p4,p5,p6,p7,p8,p9,p10){
		  GestionarMensaje('MSG015');
		  eval('frmConsultarListaConsultoras').oculto = 'N';
          set('frmConsultarListaConsultoras.conectorAction', 'LPDestinatarios');
          set('frmConsultarListaConsultoras.accion', '');
         
          set('frmConsultarListaConsultoras.opcionMenu', p1);
          set('frmConsultarListaConsultoras.oidMensaje', p2);
          set('frmConsultarListaConsultoras.oidTipoMensaje', p3);
          set('frmConsultarListaConsultoras.unidadAdministrativa', p4);
          set('frmConsultarListaConsultoras.tipoCliente', p5);
          set('frmConsultarListaConsultoras.marca', p6);
          set('frmConsultarListaConsultoras.codigoVenta', p7);
          set('frmConsultarListaConsultoras.pedido', p8);
          set('frmConsultarListaConsultoras.consultoras', p9);
          
          if(get('frmConsultarListaConsultoras.pedido') == 'S' &&
			 get('frmConsultarListaConsultoras.unidadAdministrativa') == '' &&
			 get('frmConsultarListaConsultoras.tipoCliente') == ''){
             limpiarFormulario();
             return;
          }                       
          enviaSICC('frmConsultarListaConsultoras');
          
       }

//------------------------------------------------------------------------------

   function errorPeriodos(){
      focaliza('frmConsultarListaConsultoras.cbPeriodoDesde');
   }
//------------------------------------------------------------------------------

   function enviarConsultoras(oid){
     // alert('el oid es ' + oid); 
      eval('frmConsultarListaConsultoras').oculto = 'N';
      set('frmConsultarListaConsultoras.conectorAction', 'LPMantenimientoConsultoras');
      set('frmConsultarListaConsultoras.accion', '' );
      set('frmConsultarListaConsultoras.oidMensaje', oid);
	  //alert('Opcion Menu: ' +  get( 'frmConsultarListaConsultoras.opcionMenu' ));
	  if (get( 'frmConsultarListaConsultoras.opcionMenu' ) == 'Modificar mensaje'){
		set( 'frmConsultarListaConsultoras.flagModificar','true');
	  }

      set('frmConsultarListaConsultoras.opcionMenu', 'Insertar mensaje');
      
      enviaSICC('frmConsultarListaConsultoras');
   }

//------------------------------------------------------------------------------


	function limpiarFormulario(){
		//fLimpiarGenericoSICC();
		set('frmConsultarListaConsultoras.TextoFijo', '');
		set('frmConsultarListaConsultoras.atDescripcion', '');
		set('frmConsultarListaConsultoras.cbMetacaracteresControlFormato', '');
		set('frmConsultarListaConsultoras.cbModulo', '');
		set('frmConsultarListaConsultoras.cbTipoMensaje', '');
		set('frmConsultarListaConsultoras.cbPermanenciaMensaje', '');
		set('frmConsultarListaConsultoras.txtCodigoMensaje', '');
		set('frmConsultarListaConsultoras.txtPermanenciaDesde', '');
		set('frmConsultarListaConsultoras.txtPermanenciaHasta', '');
		set_combo('frmConsultarListaConsultoras.cbPeriodoDesde', new Array(new Array("","")), []);
		set_combo('frmConsultarListaConsultoras.cbPeriodoHasta', new Array(new Array("","")), []);
		focaliza('frmConsultarListaConsultoras.TextoFijo');
	}

//------------------------------------------------------------------------------      

       function mostrarMensajeNumerico(campo){
         var msg = sicc_obtenerDescripcion(campo);
         focaliza("frmConsultarListaConsultoras." + campo);
         cdos_mostrarAlert(GestionarMensaje("000000000000100" ,  "\"" + msg + "\""));
       }

//------------------------------------------------------------------------------       

       function validarCampos(){
                if( !sicc_validaciones_generales() ){
                         return false;
                }
       }

//------------------------------------------------------------------------------

       function permanenciaMensajeOnChange() {
                var aSelec = get( 'frmConsultarListaConsultoras.cbPermanenciaMensaje' );
                var selec = aSelec[0];

                if( selec == get( 'frmConsultarListaConsultoras.hOidPermanenciaH' ) ){
                         set('frmConsultarListaConsultoras.txtPermanenciaDesde', '');
                         set('frmConsultarListaConsultoras.txtPermanenciaHasta', '');
                         accion('frmConsultarListaConsultoras.cbTipoPeriodo','.disabled=false');
                         accion('frmConsultarListaConsultoras.cbPeriodoDesde','.disabled=false');
                         accion('frmConsultarListaConsultoras.cbPeriodoHasta','.disabled=false');
                         accion('frmConsultarListaConsultoras.txtPermanenciaDesde','.disabled=true');
                         accion('frmConsultarListaConsultoras.txtPermanenciaHasta','.disabled=true');
                } else if( selec == get( 'frmConsultarListaConsultoras.hOidPermanenciaR' ) ){

                         accion('frmConsultarListaConsultoras.cbTipoPeriodo','.disabled=true');
                         accion('frmConsultarListaConsultoras.cbPeriodoDesde','.disabled=true');
                         accion('frmConsultarListaConsultoras.cbPeriodoHasta','.disabled=true');
                         accion('frmConsultarListaConsultoras.txtPermanenciaDesde','.disabled=false');
                         accion('frmConsultarListaConsultoras.txtPermanenciaHasta','.disabled=false');
						             set_combo('frmConsultarListaConsultoras.cbPeriodoDesde', new Array(new Array("","")), []);
						             set_combo('frmConsultarListaConsultoras.cbPeriodoHasta', new Array(new Array("","")), []);
				 		             set('frmConsultarListaConsultoras.cbTipoPeriodo', new Array(""));

                } else{
						       set_combo('frmConsultarListaConsultoras.cbPeriodoDesde', new Array(new Array("","")), []);
                   set_combo('frmConsultarListaConsultoras.cbPeriodoHasta', new Array(new Array("","")), []);
                   set('frmConsultarListaConsultoras.txtPermanenciaDesde', '');
                   set('frmConsultarListaConsultoras.txtPermanenciaHasta', '');
						       set('frmConsultarListaConsultoras.cbTipoPeriodo', new Array(""));
                   accion('frmConsultarListaConsultoras.cbTipoPeriodo','.disabled=true');
                   accion('frmConsultarListaConsultoras.cbPeriodoDesde','.disabled=true');
                   accion('frmConsultarListaConsultoras.cbPeriodoHasta','.disabled=true');
                   accion('frmConsultarListaConsultoras.txtPermanenciaDesde','.disabled=true');
                   accion('frmConsultarListaConsultoras.txtPermanenciaHasta','.disabled=true');
                }
       }

//------------------------------------------------------------------------------
         
       function pasarCombosAHiddens(){
                var textoFijo               = get('frmConsultarListaConsultoras.TextoFijo');
                var modulo                  = get('frmConsultarListaConsultoras.cbModulo' );
                var codigoMensaje           = get('frmConsultarListaConsultoras.txtCodigoMensaje');
                var tipoMensaje             = get('frmConsultarListaConsultoras.cbTipoMensaje');
                var descTipoMensaje         = get('frmConsultarListaConsultoras.cbTipoMensaje', 'T'); 
                var descMensaje             = get('frmConsultarListaConsultoras.atDescripcion');
                
                var bloque                  = get('frmConsultarListaConsultoras.txtBloqueGrupo');
                var permanenciaMensaje      = get('frmConsultarListaConsultoras.cbPermanenciaMensaje' );
                var tipoPeriodo             = get('frmConsultarListaConsultoras.cbTipoPeriodo' );
                var periodoDesde            = get('frmConsultarListaConsultoras.cbPeriodoDesde' );
                var periodoHasta            = get('frmConsultarListaConsultoras.cbPeriodoHasta' );
                var asignacionDestinatarios = get('frmConsultarListaConsultoras.cbAsignacionDestinatarios' );
				var exclusionTipologia		= get('frmConsultarListaConsultoras.chkExclusionTipologia');


                set('frmConsultarListaConsultoras.hTextoFijo', textoFijo)
                set('frmConsultarListaConsultoras.hModulo', modulo );
                set('frmConsultarListaConsultoras.hCodigoMensaje', codigoMensaje )
                set('frmConsultarListaConsultoras.hTipoMensaje', tipoMensaje );
                set('frmConsultarListaConsultoras.hDescTipoMensaje', descTipoMensaje);
                set('frmConsultarListaConsultoras.hDescMensaje', descMensaje);
                set('frmConsultarListaConsultoras.hBloqueGrupo', bloque);
                set('frmConsultarListaConsultoras.hPermanenciaMensaje', permanenciaMensaje );
                set( 'frmConsultarListaConsultoras.hTipoPeriodo', tipoPeriodo );
                set( 'frmConsultarListaConsultoras.hPeriodoDesde', periodoDesde );
                set( 'frmConsultarListaConsultoras.hPeriodoHasta', periodoHasta );
                               
                if( (get('frmConsultarListaConsultoras.hCasoDeUso') == 'Insertar mensaje') || 
                    (get('frmConsultarListaConsultoras.hCasoDeUso') == 'Modificar mensaje') ){
						set( 'frmConsultarListaConsultoras.hAsignacionDestinatarios', asignacionDestinatarios );
                }
                set( 'frmConsultarListaConsultoras.hDescTipoMensaje', descTipoMensaje );
                set('frmConsultarListaConsultoras.hExclusionTipologia', exclusionTipologia );
       }

//------------------------------------------------------------------------------      


       //FUNCIONES PARA POSICIONAR COMBOS

       function PosicionarComboUnidadesAdministrativas( cmb, tab ){
                           
                //cmb puede valer:
                //region, zona, seccion o territorio
                //que representa el combo que invoco a esta funcion en el onchange()

                //tab puede valer:
                //ontab
                //onshtab

                if( tab == 'ontab' ){
                         if( cmb == 'region' ){
                                             
                         } else if( cmb == 'zona' ){
                                             
                         } else if( cmb == 'seccion' ){
                                             
                         } else if( cmb == 'territorio' ){
                                             
                         }
                } else if( tab == 'onshtab' ){
                         if( cmb == 'region' ){
                                             
                         } else if( cmb == 'zona' ){
                                             
                         } else if( cmb == 'seccion' ){
                                             
                         } else if( cmb == 'territorio' ){
                                             
                         }
                }
       }


//------------------------------------------------------------------------------       

       function fVolver(){
                window.close();
       }

//------------------------------------------------------------------------------       

       function focalizaComboModulo(){
                if( cbModulo.disabled == false ){
                         focaliza('frmConsultarListaConsultoras.cbModulo');
                }
       }

//------------------------------------------------------------------------------       
