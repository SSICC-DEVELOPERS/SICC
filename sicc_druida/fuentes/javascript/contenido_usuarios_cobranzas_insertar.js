var fechaTemp;

  function onLoadPag(){

				  configurarMenuSecundario("frmFormulario"); 

                  if(get('frmFormulario.casoDeUso') == "modificar")
                  {
                           btnProxy(1,1);
                  }
  	              
                  fMostrarMensajeError();		
                  
				  if(get('frmFormulario.cerrarVentana') == '1'){
                    close();
                  
				  }else{
                      if(get('frmFormulario.accion') == "insertar") {
                  			  focaliza("frmFormulario.txtCodUsuario");
                  	  }
                  
				      accion('frmFormulario.txtNombre', '.disabled=true');
                      fechaTemp = get('frmFormulario.txtFechaUltimoEstado');
                    
					   if(get('frmFormulario.casoDeUso') != "insertar"){				
                           var array = new Array();
                           array[0] = get('frmFormulario.oidEstadoUsuario');
                           set('frmFormulario.cbEstadoUsuario',array);
			            }

					   if(get('frmFormulario.hCerrar') == "1"){
						 registr();
						}
                   
						if(get('frmFormulario.casoDeUso') == "consultar"){

                              accion('frmFormulario.txtCodUsuario', '.disabled=true');
                              accion('frmFormulario.cbEstadoUsuario', '.disabled=true');
                              accion('frmFormulario.txtFechaUltimoEstado', '.disabled=true');
                              accion('frmFormulario.ckJefeCobranza', '.disabled=true');
                              accion('frmFormulario.ckUsuarioSupervisorEspecial', '.disabled=true');
                              accion('frmFormulario.ckUsuarioExterno', '.disabled=true');
                              accion('frmFormulario.txtTurnoHorarioEntrada', '.disabled=true');
                              accion('frmFormulario.txtTurnoHorarioSalida', '.disabled=true');
                              accion('frmFormulario.txtCodUsuarioSupervisor', '.disabled=true');
                              accion('frmFormulario.txtCodUsuarioRespaldo', '.disabled=true');
                              accion('frmFormulario.areatxtObservaciones', '.disabled=true');
						  }
                   
						 if(get('frmFormulario.casoDeUso') == "modificar"){
                              accion('frmFormulario.txtCodUsuario', '.disabled=true');
		                 }

						  if(get('frmFormulario.casoDeUso') == "consultar" || get('frmFormulario.casoDeUso') == "modificar"){
                                    btnProxy(2,1);
                                    btnProxy(3,0);
                                    btnProxy(5,0);
				          }
                      
						  if(get('frmFormulario.casoDeUso') == "insertar" || get('frmFormulario.casoDeUso') == "modificar"){
                             btnProxy(5,1);
						  }
					}//fin de ELSE
  }

//Agregado por Cristian Valenzuela
//22/2/2005
  function reInicio() {
         eval("frmFormulario").oculto= "N";
         fLimpiar();
         set("frmFormulario.cbEstadoUsuario","");
         focaliza("frmFormulario.txtCodUsuario");
  }

  function reModifica() {
         eval("frmFormulario").oculto= "N";
    window.close();
  }

  function fErrorAlGuardarI() 
  {
         set("frmFormulario.cbEstadoUsuario","");
         focaliza("frmFormulario.txtCodUsuario");
  }

  function fErrorAlGuardarM() {
             if(get('frmFormulario.casoDeUso') == "modificar")
                           {
                                    btnProxy(1,1);
                           }
  }
   
//Envia oculto agregado por Cristian Valenzuela
//22/2/2005
  
 function fGuardar(){
  
		    if(!sicc_validaciones_generales()){
			         return false;
			}

            eval('frmFormulario').oculto = 'S';
            set('frmFormulario.conectorAction', 'LPUsuariosCobranzas');
            set('frmFormulario.accion', 'guardar')
                       
           // enviaSICC('frmFormulario', null, null, 'N');
		    enviaSICC('frmFormulario');
			
 }  
  

  function onChangeCodUsuario()  
  {
                  eval('frmFormulario').oculto = 'S';
                  set('frmFormulario.conectorAction', 'LPUsuariosCobranzas');
                  set('frmFormulario.accion', 'recuperar nombre');	  
                  enviaSICC('frmFormulario', null, null, 'N');

  }

  function setear()
  {     
         set('frmFormulario.txtNombre', arguments[1]);
         set('frmFormulario.idUsuario', arguments[0]);

		// Focacalizar en cbEstadoUsuario
		focaliza('frmFormulario.cbEstadoUsuario');

        btnProxy(1,1);
        btnProxy(5,1)
  }

  function avisar()
  {
          set('frmFormulario.txtCodUsuario', '');
          btnProxy(1,1);
  }

  function fLimpiar(){

  var casoU =  get('frmFormulario.casoDeUso');
    if(get('frmFormulario.casoDeUso') == "insertar"){
				  
				  // agregado adiaz 25/08/2006
				  fechaTemp = get('frmFormulario.txtFechaUltimoEstado');

                  set('frmFormulario.txtCodUsuario',"");
                  set('frmFormulario.txtNombre',"");
                  set('frmFormulario.idUsuario',"");
                  set('frmFormulario.txtFechaUltimoEstado',fechaTemp);
                  set('frmFormulario.txtTurnoHorarioEntrada','');
                  set('frmFormulario.txtTurnoHorarioSalida','');
                  set('frmFormulario.txtCodUsuarioSupervisor','');
                  set('frmFormulario.txtCodUsuarioRespaldo','');
                  set('frmFormulario.areatxtObservaciones','');
                  
                  var arr = new Array(); arr[0] = "";
                  set('formulario.cbEstadoUsuario', arr);
                  set('frmFormulario.ckJefeCobranza', 'N');
                  set('frmFormulario.ckUsuarioSupervisorEspecial', 'N');
                  set('frmFormulario.ckUsuarioExterno', 'N');
                  focaliza("frmFormulario.txtCodUsuario");
     }else{

      returnValue = 'LIMPIAR';
           close();
     }
  }

  function fVolver(){ 
		window.close();  
  }
  
  function registr()
  {
         GestionarMensaje('1397');
         window.close();
  }
  
  function mostrarAlert(){		
		GestionarMensaje('UICAL0003');
		fLimpiar();		
		window.close();
  }
