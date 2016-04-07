function onLoad(){  
            eval('frmFormulario').oculto = 'N';
            if(get('frmFormulario.hcerrar')=='S'){
              window.close();
            }
            configurarMenuSecundario("frmFormulario");             
            //habilitarBotones();            
            habilitarCamposModificar();//si es indicado 
            posicionarCombos();
            //focaliza('frmFormulario.');            
            mostrarCodigoError();    
            if (get('frmFormulario.enablebtModificarPosiciones')=='S') {    
              focaliza('frmFormulario.cbAccesoFisico');
            }
       }
       function quitaOculto(){  
            eval('frmFormulario').oculto = 'N';
       }
       function mostrarCodigoError(){                       
          var vErrCodigo = get('frmFormulario.errCodigo');   
          var vErrDescrip = get('frmFormulario.errDescripcion');             
          if (get('frmFormulario.errDescripcion')!='') {   
                 var wnd = fMostrarMensajeError( vErrCodigo,vErrDescrip);  
          }             
       }
       function habilitarBotones(){
       
          if(get('frmFormulario.enablebtVisualizarPosiciones')=='S'){
             visibilidad('btnModificarPosicion','O');
          } else if (get('frmFormulario.enablebtModificarPosiciones')=='S'){
             visibilidad('btnVisualizarPosicion','O');
          }
       }
       function posicionarCombos(){
            if (get('frmFormulario.hcbAccesoFisico')!=''){   
              iSeleccionadob = new Array();             
              iSeleccionadob[0] = get('frmFormulario.hcbAccesoFisico');         
              set('frmFormulario.cbAccesoFisico',iSeleccionadob);                     
            }    
            if (get('frmFormulario.hcbTipoDespacho')!=''){   
              iSeleccionadob = new Array();             
              iSeleccionadob[0] = get('frmFormulario.hcbTipoDespacho');         
              set('frmFormulario.cbTipoDespacho',iSeleccionadob);                     
            }      
            if (get('frmFormulario.hcbDestino')!=''){   
              iSeleccionadob = new Array();             
              iSeleccionadob[0] = get('frmFormulario.hcbDestino');         
              set('frmFormulario.cbDestino',iSeleccionadob);                     
            }   
            if (get('frmFormulario.hcbTipoDocumentoIdentidad')!=''){   
              iSeleccionadob = new Array();             
              iSeleccionadob[0] = get('frmFormulario.hcbTipoDocumentoIdentidad');         
              set('frmFormulario.cbTipoDocumentoIdentidad',iSeleccionadob);                     
            }   
            if (get('frmFormulario.hcbFormaPago')!=''){   
              iSeleccionadob = new Array();             
              iSeleccionadob[0] = get('frmFormulario.hcbFormaPago');         
              set('frmFormulario.cbFormaPago',iSeleccionadob);
            }               
       }
       function onChangeCodCliente(orden){       
          var codCliente;
          if (orden=='C'){//consultora
              codCliente = get('frmFormulario.txtConsultoraReferencia');
          } else if (orden=='P'){//pagador
              codCliente = get('frmFormulario.txtPagadorFactura');
          } else if (orden=='R'){//receptor
              codCliente = get('frmFormulario.txtReceptorFactura');
          }
          
          if (codCliente.length != 0)  {
             codigoCompleto = validarLongCodCliene(codCliente);             
              if (orden=='C'){//consultora
                  set('frmFormulario.hIndicadorBusquedaCliente','C');
                  set('frmFormulario.txtConsultoraReferencia', codigoCompleto);
              } else if (orden=='P'){//pagador
                  set('frmFormulario.hIndicadorBusquedaCliente','P');
                  set('frmFormulario.txtPagadorFactura', codigoCompleto);
              } else if (orden=='R'){//receptor
                  set('frmFormulario.hIndicadorBusquedaCliente','R');
                  set('frmFormulario.txtReceptorFactura', codigoCompleto);
              }
             set('frmFormulario.accion', 'Modificar Codigo');
             eval('frmFormulario').oculto = 'S';
             enviaSICC('frmFormulario','','','N');
          }
       }
       function validarLongCodCliene(codCliente) {
          var longiCod = get('frmFormulario.hLongitudCodCliente');
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
       function errorCodigoBusqueda(indicador){       
        eval('frmFormulario').oculto = 'N';
        if (indicador == 'C')  {
            set('frmFormulario.txtConsultoraReferencia', '');
            set('frmFormulario.hoidConsultora', '');
            focaliza('frmFormulario.txtConsultoraReferencia');				
        } else if (indicador == 'P') {
            set('frmFormulario.txtPagadorFactura', '');
            set('frmFormulario.hoidPagador', '');			
            focaliza('frmFormulario.txtPagadorFactura');
        } else if (indicador == 'R') {
            set('frmFormulario.txtReceptorFactura', '');
            set('frmFormulario.hoidReceptor', '');	
            focaliza('frmFormulario.txtReceptorFactura');			  
        }
       }
       function asignarDatosCliente(oidCliente, indicador){
    
        if (indicador == 'C')  {
            if( oidCliente != '' ){
              set("frmFormulario.hoidConsultora", oidCliente);
            }else{
                 GestionarMensaje("UIPED029", null, null, null);
            }				
          
        } else if (indicador == 'P')  {
            if( oidCliente != '' ){
              set("frmFormulario.hoidPagador", oidCliente);
            }else{
                 GestionarMensaje("UIPED029", null, null, null);
            }				
          
        } else if (indicador == 'R')  {
            if( oidCliente != '' ){
              set("frmFormulario.hoidReceptor", oidCliente);
            }else{
                 GestionarMensaje("UIPED029", null, null, null);
            }				
        }
    
       }                    
       function accionVisualizarPosiciones(){
        /*Muestra la ventana emergente y modal PGInformacionPosicion, activando la LPConsultarModificarPosiciones con: 
          - opcionMenu = "Consultar" 
          - accion = "" 
          - oidCabeceraSolicitud 
          Se bloquea la ejecución hasta el cierre de la ventana emergente */ 
          if(get('frmFormulario.enablebtVisualizarPosiciones')=='S'){          
               var parametros = new Object();     
               parametros.opcionMenu = "Consultar";   
               parametros.accion = "";   
               parametros.oidCabeceraSolicitud = get('frmFormulario.hoidCabeceraSolicitud');                              
               var res = mostrarModalSICC("LPConsultarPosiciones", "", parametros, 830, 550);             
          }               
       }
       function accionModificarPosiciones(){
        /*Muestra la ventana emergente y modal PGModificarPosiciones, activando la LPModificarPosiciones con: 
          - accion = "" 
          - oidCabeceraSolicitud           
          Se bloquea la ejecución hasta el cierre de la ventana emergente */        
          if (get('frmFormulario.enablebtModificarPosiciones')=='S'){                          
               var parametros = new Object();           
               parametros.accion = "Posiciones";   
               parametros.oidCabeceraSolicitud = get('frmFormulario.hoidCabeceraSolicitud');  
               parametros.hoidAcceso = get('frmFormulario.hoidAcceso');  
               parametros.hoidSubacceso = get('frmFormulario.hoidSubacceso');  
               parametros.hoidPeriodo = get('frmFormulario.hoidPeriodo');  
               parametros.hoidMoneda = get('frmFormulario.hoidMoneda');  
               parametros.hnroSolicitud = get('frmFormulario.hnroSolicitud');  
               parametros.hoidGrupoProcesos = get('frmFormulario.hoidGrupoProcesos');  
               parametros.hoidEstadoSolicitud = get('frmFormulario.hoidEstadoSolicitud');  
               parametros.hcodCliente = get('frmFormulario.hcodCliente');  
               parametros.hoidProceso = get('frmFormulario.hoidProceso');                   
               parametros.hoidTipoSolicitud = get('frmFormulario.hoidTipoSolicitud');                 
               
               var res = mostrarModalSICC("LPConsultarModificarSolicitud", "Posiciones", parametros, 830, 550); 
          }    
       }
       function accionBuscarCliente(orden){     
         if(get('frmFormulario.enablebtVisualizarPosiciones')=='S'){
            return;
         }
         var oid;
         var obj = new Object();
         var whnd = mostrarModalSICC('LPBusquedaRapidaCliente','',obj);
         if(whnd==null){

         }else{
             var oid = whnd[0];
             var cod = whnd[1];
             if (orden=='1'){//txtConsultoraReferencia
               set("frmFormulario.hoidConsultora", oid);
               set("frmFormulario.txtConsultoraReferencia", cod);
             } else if(orden=='2'){//txtReceptorFactura
               set("frmFormulario.hoidReceptor", oid);
               set("frmFormulario.txtReceptorFactura", cod);             
             } else if(orden=='3'){//txtPagadorFactura
               set("frmFormulario.hoidPagador", oid);
               set("frmFormulario.txtPagadorFactura", cod);             
             }
         }
       }
       function accionGuardar(){
        /* Envia el formulario oculto 
        accion = "Modificar" 
        formulario.oculto = "S" 
        enviaSICC(formulario)*/
        
         if (!sicc_validaciones_generales("pest1")) {
            onClickPestana('1');
            return false;
         }       
         if (!sicc_validaciones_generales("pest3")) {
            onClickPestana('3');
            return false;
         }        
         if (!sicc_validaciones_generales("pest5")) {
            onClickPestana('5');
            return false;
         }         
         
         set('frmFormulario.accion','Modificar');         
         set('frmFormulario.conectorAction','LPConsultarModificarSolicitud');
       
         eval("frmFormulario").oculto="S";
         enviaSICC('frmFormulario', '', '', 'N');        
       }
       function habilitarCamposModificar(){
        if (get('frmFormulario.enableCamposModificar')=="S") {
            deshabilitarHabilitarBoton('botonContenido','btnVisualizarPosicion','D');
            deshabilitarHabilitarBoton('botonContenido','btnVisualizarPosicion2','D');
            deshabilitarHabilitarBoton('botonContenido','btnVisualizarPosicion3','D');
            deshabilitarHabilitarBoton('botonContenido','btnVisualizarPosicion4','D');
            deshabilitarHabilitarBoton('botonContenido','btnVisualizarPosicion5','D');

			accion('frmFormulario.cbAccesoFisico','.disabled=false');
			accion('frmFormulario.cbTipoDespacho','.disabled=false');
            accion('frmFormulario.txtConsultoraReferencia','.disabled=false');
            accion('frmFormulario.txtReceptorFactura','.disabled=false');
            accion('frmFormulario.txtPagadorFactura','.disabled=false');
            accion('frmFormulario.txtNumeroClientes','.disabled=false');
            accion('frmFormulario.cbDestino','.disabled=false');
            accion('frmFormulario.cbTipoDocumentoIdentidad','.disabled=false');
            accion('frmFormulario.cbFormaPago','.disabled=false');
            accion('frmFormulario.txtFechaPrevistaFacturacion','.disabled=false');            
        } else {   
            
            accion('frmFormulario.cbAccesoFisico','.disabled=true');
            accion('frmFormulario.cbTipoDespacho','.disabled=true');
            accion('frmFormulario.txtConsultoraReferencia','.disabled=true');
            accion('frmFormulario.txtReceptorFactura','.disabled=true');
            accion('frmFormulario.txtPagadorFactura','.disabled=true');
            accion('frmFormulario.txtNumeroClientes','.disabled=true');
            accion('frmFormulario.cbDestino','.disabled=true');
            accion('frmFormulario.cbTipoDocumentoIdentidad','.disabled=true');
            accion('frmFormulario.cbFormaPago','.disabled=true');
            accion('frmFormulario.txtFechaPrevistaFacturacion','.disabled=true');  
            //Los seteo para que no sean obligatorios
            setMV('frmFormulario.cbTipoDespacho','N');
            setMV('frmFormulario.txtReceptorFactura','N');
            setMV('frmFormulario.txtPagadorFactura','N');
            setMV('frmFormulario.cbDestino','N');
            setMV('frmFormulario.cbTipoDocumentoIdentidad','N');
            deshabilitarHabilitarBoton('botonContenido','btnModificarPosicion','D');
            deshabilitarHabilitarBoton('botonContenido','btnModificarPosicion2','D');
            deshabilitarHabilitarBoton('botonContenido','btnModificarPosicion3','D');
            deshabilitarHabilitarBoton('botonContenido','btnModificarPosicion4','D');
            deshabilitarHabilitarBoton('botonContenido','btnModificarPosicion5','D');
            
            
        }
       }
       function onClickPestana(nroPestana){
         var ultima = get('frmFormulario.hultimaPestana');         
         document.getElementById("lblPestana"+ultima).style.backgroundColor = "#F0F0F0";
         document.getElementById("lblPestana"+ultima).style.color = "#F0F0F0";
         document.getElementById("pestana"+ultima).style.backgroundColor = "#F0F0F0";
         document.getElementById("pestana"+ultima).style.color = "#F0F0F0";           
         document.all["capa"+eval(ultima)+""].style.visibility='hidden';
         document.all["capa"+nroPestana].style.visibility='visible';         
         set('frmFormulario.hultimaPestana',nroPestana);

         document.all["lblPestana"+nroPestana].style.backgroundColor = "#496A9A";
         document.all["lblPestana"+nroPestana].style.color = "#FFFFFF";
         document.getElementById("pestana"+nroPestana).style.backgroundColor = "#496A9A";
         document.getElementById("pestana"+nroPestana).style.color = "#FFFFFF";
         
       }
       function ocultarTodasLasCapas(){
         document.all["capa1"].style.visibility='hidden';
         document.all["capa2"].style.visibility='hidden';
         document.all["capa3"].style.visibility='hidden';
         document.all["capa4"].style.visibility='hidden';
         document.all["capa5"].style.visibility='hidden'; 
         document.getElementById("lblPestana1").style.backgroundColor = "#F0F0F0";
         document.getElementById("lblPestana1").style.color = "#F0F0F0";
         document.getElementById("pestana1").style.backgroundColor = "#F0F0F0";
         document.getElementById("pestana1").style.color = "#F0F0F0";  
         document.getElementById("lblPestana2").style.backgroundColor = "#F0F0F0";
         document.getElementById("lblPestana2").style.color = "#F0F0F0";
         document.getElementById("pestana2").style.backgroundColor = "#F0F0F0";
         document.getElementById("pestana2").style.color = "#F0F0F0";  
         document.getElementById("lblPestana3").style.backgroundColor = "#F0F0F0";
         document.getElementById("lblPestana3").style.color = "#F0F0F0";
         document.getElementById("pestana3").style.backgroundColor = "#F0F0F0";
         document.getElementById("pestana3").style.color = "#F0F0F0";  
         document.getElementById("lblPestana4").style.backgroundColor = "#F0F0F0";
         document.getElementById("lblPestana4").style.color = "#F0F0F0";
         document.getElementById("pestana4").style.backgroundColor = "#F0F0F0";
         document.getElementById("pestana4").style.color = "#F0F0F0";  
         document.getElementById("lblPestana5").style.backgroundColor = "#F0F0F0";
         document.getElementById("lblPestana5").style.color = "#F0F0F0";
         document.getElementById("pestana5").style.backgroundColor = "#F0F0F0";
         document.getElementById("pestana5").style.color = "#F0F0F0";           
       }  
      function poneMano(nombre) {
        var nombre = document.getElementById(nombre);
        nombre.style.cursor = "hand";
      }       
      function fVolver(){
        window.close();
      }
      function fGuardar(){
        accionGuardar();
      }
      function fLimpiar(){
        posicionarCombos();
        ocultarTodasLasCapas();
        onClickPestana('1');
      }
          function arrayComponentes(){
              var arr = new Array();              
              
              arr[arr.length]= new Array("cbAccesoFisico","","1");
              arr[arr.length]= new Array("cbTipoDespacho","",""); 

              arr[arr.length]= new Array("btnVisualizarPosicion","BOTON",""); 
              arr[arr.length]= new Array("btnModificarPosicion","BOTON","1");

              arr[arr.length]= new Array("btnVisualizarPosicion2","BOTON","2"); 
              arr[arr.length]= new Array("btnModificarPosicion2","BOTON","2");
              
              arr[arr.length]= new Array("txtConsultoraReferencia","","3");
              arr[arr.length]= new Array("txtReceptorFactura","","");
              arr[arr.length]= new Array("txtPagadorFactura","","");
              arr[arr.length]= new Array("txtNumeroClientes","","");              
              arr[arr.length]= new Array("cbDestino","","");
              arr[arr.length]= new Array("cbTipoDocumentoIdentidad","","");
              arr[arr.length]= new Array("cbFormaPago","","");

              arr[arr.length]= new Array("btnVisualizarPosicion3","BOTON",""); 
              arr[arr.length]= new Array("btnModificarPosicion3","BOTON","3");              

              arr[arr.length]= new Array("btnVisualizarPosicion4","BOTON","4"); 
              arr[arr.length]= new Array("btnModificarPosicion4","BOTON","4");        
              
              arr[arr.length]= new Array("txtFechaPrevistaFacturacion","","5");         

              arr[arr.length]= new Array("btnVisualizarPosicion5","BOTON",""); 
              arr[arr.length]= new Array("btnModificarPosicion5","BOTON","5");                 
              
              return arr;
          }
          function tabGenerico(nombreComp, tipotab){       
            var arr = arrayComponentes();
            var tabular = false;
            var nombreFormulario = getFormularioSICC();
            var j = 0;
            var k = arr.length;
            if (tipotab != "sh") {
                j = j-1;                
                k = k-1;
            }

            while(j<k){
                var t;
                if(tipotab == "sh"){
                  k--;
                  t = k;
                } else{
                  j++;
                  t = j;                  
                }
                  
                var nombre = arr[t][0];
                var tipo = arr[t][1];
                var pest = arr[t][2];
                if (tabular==false){
                  if (nombreComp==nombre){
                      tabular=true;
                      if (tipotab == "sh"){
                        if (k==0) k= arr.length;
                      } else {
                        if ((j+1)==arr.length)  j = -1;
                      }
                  }                
                } else {
                  try {
                    var name = nombreFormulario+"."+nombre;                    
                       
                    if (pest!=""){
                       onClickPestana(pest);
                    }
                    if (tipo=="BOTON") {
                       focalizaBotonHTML("botonContenido",nombre);
                    } else {
                       focaliza(name);
                       
                    }
                    return;
                  } catch (e) {
                  }
                }
            }
          }      