  function onLoadPag() {
    
      if (get('frmClientesAnteriores.cerrar') == "S") {
          window.close();
      }
    
      if (get('frmClientesAnteriores.opcionMenu') == "InsertarCodigoAnterior") {
      		  
            focaliza('frmClientesAnteriores.cbPaisNuevo');

      } else { // Para consultar y modificar
	      ocultarImagen('lupa');
          if (get('frmClientesAnteriores.opcionMenu') == "ConsultarCodigoAnterior") {
              
                set('frmClientesAnteriores.txtClienteNuevo',get('frmClientesAnteriores.CLIENTENUEVO'));
                set('frmClientesAnteriores.txtClienteAntiguo',get('frmClientesAnteriores.CLIENTEANTI'));
                set('frmClientesAnteriores.txtSistemaProcedencia',get('frmClientesAnteriores.SISTEMA'));
                cargarCombos();              
          }
		  
		    if (get('frmClientesAnteriores.opcionMenu') == "EliminarCodigoAnterior") {
              
                set('frmClientesAnteriores.txtClienteNuevo',get('frmClientesAnteriores.CLIENTENUEVO'));
                set('frmClientesAnteriores.txtClienteAntiguo',get('frmClientesAnteriores.CLIENTEANTI'));
                set('frmClientesAnteriores.txtSistemaProcedencia',get('frmClientesAnteriores.SISTEMA'));
                cargarCombos();              
          }	  

          if (get('frmClientesAnteriores.opcionMenu') == "ModificarCodigoAnterior") {
                accion('frmClientesAnteriores.txtClienteNuevo','.disabled=true');

                set('frmClientesAnteriores.txtClienteNuevo',get('frmClientesAnteriores.CLIENTENUEVO'));
                set('frmClientesAnteriores.txtClienteAntiguo',get('frmClientesAnteriores.CLIENTEANTI'));
                set('frmClientesAnteriores.txtSistemaProcedencia',get('frmClientesAnteriores.SISTEMA'));
                cargarCombos();

                focaliza('frmClientesAnteriores.cbPaisNuevo');
          }
      }
      
      configurarMenuSecundario("frmClientesAnteriores");
	  btnProxy(3,0);    // Deshabilito el boton Salir
      eval (ON_RSZ);
      fMostrarMensajeError();
      
  }
        

  function cargarCombos(){
    iSeleccionado = new Array(); 
    iSeleccionado[0] = get('frmClientesAnteriores.PAIS_OID_PAIS'); 
    set('frmClientesAnteriores.cbPaisNuevo',iSeleccionado); 
  }
  
  function seleccionarClienteContactado() {
      var obj = new Object();
      
      if (get('frmClientesAnteriores.opcionMenu') == "InsertarCodigoAnterior" ){
            var whnd = mostrarModalSICC('LPBusquedaRapidaCliente','',obj);
            if(whnd==null){
      
            }else{
          
              var oidclie = whnd[0];
              var cod = whnd[1];
          
              set("frmClientesAnteriores.txtClienteNuevo", cod);
              set("frmClientesAnteriores.hoidCliente", oidclie);
              
            }
      }
  }
  
    function fGuardar() {
    
      accionGuardar();
    }
  
    function accionGuardar() {

      if(!sicc_validaciones_generales()){
          return false;
      }

      eval('frmClientesAnteriores').oculto = "S";

      set('frmClientesAnteriores.conectorAction','LPMantenimientoCodigosAnteriores');

      set('frmClientesAnteriores.accion','guardar');

      set('frmClientesAnteriores.CLIENTENUEVO', get('frmClientesAnteriores.txtClienteNuevo'));

      set('frmClientesAnteriores.CLIENTEANTI', get('frmClientesAnteriores.txtClienteAntiguo'));

      set('frmClientesAnteriores.SISTEMA', get('frmClientesAnteriores.txtSistemaProcedencia'));

      set('frmClientesAnteriores.PAIS_OID_PAIS', get('frmClientesAnteriores.cbPaisNuevo'));
            
      enviaSICC('frmClientesAnteriores');
      
  }
  
  
  function guardoCorrectamente(opcionMenu){
      
      eval('frmClientesAnteriores').oculto = "N";
      if (opcionMenu == "ModificarCodigoAnterior"){                
                returnValue = "modificar";
                window.close();
      }else{
            fLimpiar();
      }      
  }
  

    function noPudoGuardar(){
        
    }
    
    function fLimpiar() {
        if (get('frmClientesAnteriores.opcionMenu') == "InsertarCodigoAnterior") {
            set('frmClientesAnteriores.cbPaisNuevo', '');
            set('frmClientesAnteriores.txtClienteNuevo', '');
            set('frmClientesAnteriores.txtClienteAntiguo', '');
            set('frmClientesAnteriores.txtSistemaProcedencia', '');

            set('frmClientesAnteriores.hoidCliente', '');
            set('frmClientesAnteriores.CLIENTENUEVO', '');
            set('frmClientesAnteriores.CLIENTEANTI', '');
            set('frmClientesAnteriores.SISTEMA', '');
            set('frmClientesAnteriores.PAIS_OID_PAIS', '');
            set('frmClientesAnteriores.OID_CLIE', '');
            set('frmClientesAnteriores.OID_CODI_CLIE_ANTE', '');
        }
        if (get('frmClientesAnteriores.opcionMenu') == "ModificarCodigoAnterior") {
			cargarCombos(); // Toma el valor para el 'cbPaisNuevo' del var PAIS del formulario
			set('frmClientesAnteriores.txtClienteNuevo', get('frmClientesAnteriores.CLIENTENUEVO'));
            set('frmClientesAnteriores.txtClienteAntiguo', get('frmClientesAnteriores.CLIENTEANTI'));
            set('frmClientesAnteriores.txtSistemaProcedencia', get('frmClientesAnteriores.SISTEMA'));
        }
		focaliza('frmClientesAnteriores.cbPaisNuevo');

    }

  
    function onchange_codCliente(){
      
      if (get("frmClientesAnteriores.txtClienteNuevo") != ""){

          campo = validarLongCodCliene(get("frmClientesAnteriores.txtClienteNuevo"));      
          set("frmClientesAnteriores.txtClienteNuevo", campo); 
      }  
    }
    
    function onchange_codClienteAnt(){
      if(get("frmClientesAnteriores.txtClienteAntiguo") != ""){
        campo = validarLongCodCliene(get("frmClientesAnteriores.txtClienteAntiguo"));                  
      }  
    }
    
  function validarLongCodCliene(codCliente) {
          var longiCod = get('frmClientesAnteriores.hLongitudCodCliente');
          var faltantes = longiCod -  codCliente.length;
          var resultCod = new String("");
          if(faltantes > 0){
               for(var t = 0 ; t<faltantes; t++){
                        resultCod = resultCod + "0";
               }
               resultCod = resultCod + codCliente;
               return resultCod;
          }
          return codCliente;

    }
  
  
function onshTabCampos(campoV) {
          //var firstCampoFocalizable = get("frmInsertarCliente.campoToFocalizar");
          var camposFocaliza = "cbPaisNuevo,txtClienteNuevo,txtClienteAntiguo,txtSistemaProcedencia";
          camposFocaliza =  camposFocaliza.split(",");

                    var match = false;

                    // Obtengo el indice del campo campoV en el array camposFocaliza.
                    var i = 0;
                    while ( match == false )
                    {     
                              if ( camposFocaliza[i] == campoV)
                                         match = true;
                              else
                                         i++;
                    }

                    var indiceCampoV = i;

                    // Ahora con ese indice voy de indice a 0, en camposFocaliza, tomando el valor del control a
                    // focalizar, y tratando de setear el foco. La primera vez que no tire excepcion (o sea, no entre en el catch)
                    // implica que ese control esta habilitado y por lo tanto sale del bucle. 

                    var campitos = camposFocaliza;
                    var catcheo = true;
                    i = campitos.length;
                    indiceCampoV = indiceCampoV - 1; // empieza con el campo anterior al actual. 

                    while (catcheo == true && indiceCampoV >= 0)
                    {
                  var valorCampoAFocalizar = camposFocaliza[indiceCampoV];
                                 var deshabilitado = document.getElementById(valorCampoAFocalizar).disabled;
                                 if ( deshabilitado == false)
                                 {
                                                   focaliza("frmClientesAnteriores." + valorCampoAFocalizar, "");
                                         catcheo = false;    
                                 } 
                                 indiceCampoV--;
                    }

                    // Si catcheo permanece en true luego del while, entonces se termino el bucle y estaban todos los controles anteriores
                    // a campoV deshabilitados, por lo que campoV tiene que ser el control que focalice el boton Anterior.
                    /*if ( catcheo )  
                                focalizaBotonHTML('botonContenido', 'btnAnterior' );*/
                  
}


    function focoEnTxtSistemaProcedencia(){
      focaliza('frmClientesAnteriores.txtSistemaProcedencia');
    }
    
    function focoEnCbPaisNuevo(){
      focaliza('frmClientesAnteriores.cbPaisNuevo');
    }
    
	function ocultarImagen(nombre) {
        if ( get('frmClientesAnteriores.opcionMenu') != "InsertarCodigoAnterior" ) {
             var obj = document.getElementById(nombre);         
             obj.height = "0";
             obj.width = "0";
        }
    }

    function poneManito(nombre) {
        if ( get('frmClientesAnteriores.opcionMenu') == "InsertarCodigoAnterior" ) {
             var obj = document.getElementById(nombre);
             obj.style.cursor = "hand";
        }
    }

	function fVolver() {
        if (get('frmClientesAnteriores.opcionMenu') != "InsertarCodigoAnterior") {
            window.returnValue = null; // Para que no actualice el LISTADO si no se 'guardó' correctamente.
            window.close();
        }
    }

