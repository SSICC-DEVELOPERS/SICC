var cantSalto = 8;

document.onkeypress=function(){

	valor = event.keyCode;
    
	if((valor >= 48 && valor <= 57) || valor ==127 || valor == 8 || valor == 13) {

		consolLeng = document.getElementById("txtNroConsolidado").value.length;
	      cajaLeng = document.getElementById("txtNroCaja").value.length;
	

		if(document.getElementById("txtNroConsolidado").value.length == cantSalto){
	       document.getElementById("txtNroCaja").focus();
	
		}

		if((consolLeng + cajaLeng) == 11 && event.keyCode == 13){
			onClickBuscar();
		} 

		return true;

	} else {
		return false;
	}
}


function onLoad(){  
	
    configurarMenuSecundario('formulario');

    fMostrarMensajeError();
    
    if(get('formulario.accion')=="buscarCaja" && get('formulario.hBuscarCajaDatos')=="S"){
        
        // Deshabilita busqueda        
        accion('formulario.txtNroCaja', '.disabled=true'); 
        accion('formulario.txtNroConsolidado', '.disabled=true'); 
   	    accion('formulario.cbOrdenVisualChuqueo', '.disabled=true'); 
		var rad = get('formulario.radioButton');

		// vbongiov -- Cambio SICC 20090839 -- 13/11/2009 
		if(rad == 'A'){
			set('formulario.RBOreden', 'A');		
		}else if(rad == 'D'){
			set('formulario.RBOreden', 'D');		
		}

		var cod = get('formulario.codigoOrden');
		set('formulario.cbOrdenVisualChuqueo', new Array(cod));
	    document.all.RBOreden[0].disabled=true;
        document.all.RBOreden[1].disabled=true;

        deshabilitarHabilitarBoton('botonContenido','btnBuscar','D');
            
        // Setea cabecera
        txt_to('NroConsolidado', get('formulario.hNumConsolidado'));
        txt_to('TurnoChequeo', get('formulario.hTurnoChequeo'));
        txt_to('EstadoPedido', get('formulario.hEstadoPed'));
        txt_to('EstadoCaja', get('formulario.hEstadoCaj'));
        txt_to('TipoChequeo', get('formulario.hTipoChequeo'));
        txt_to('OrigenChequeo', get('formulario.hOrigenChequeo'));
        txt_to('Caja', get('formulario.hCaja') + "/" + get('formulario.hTotalCaja'));
        txt_to('NroTotalProductos', get('formulario.hTotalProd'));
        txt_to('NroUnidadesCaja', get('formulario.hNumUnidCaj'));
        txt_to('UnidadesPicadas', get('formulario.hUnidPicadas'));
        
        DrdEnsanchaConMargenDcho('listado1',28);
        eval (ON_RSZ);   
        
        deshabilitarHabilitarBoton('botonContenido','btnFinalizarChequeo','D');
        deshabilitarHabilitarBoton('botonContenido','btnAgregarSobrante','D');
     
        visibilidad('capaCabecera','V');
        visibilidad('capaLista','V');
        
        focalizaBotonHTML_XY('btnIniciarChequeo');
        
    } else {
        
        visibilidad('capaCabecera','O');
        visibilidad('capaLista','O');
        
        focaliza("formulario.txtNroConsolidado");
        //sb
        
        var rad = get('formulario.radioButton');
		//  
		if(rad == 'A'){
			set('formulario.RBOreden', 'A');		
		}else if(rad == 'D'){
			set('formulario.RBOreden', 'D');		
		}

		var cod = get('formulario.codigoOrden');
		set('formulario.cbOrdenVisualChuqueo', new Array(cod));
        
        if(get('formulario.hBuscarCajaDatos')=="N"){
            GestionarMensaje('APEUI056');
        }
    }
}

function onClickFinalizarChequeo(){

    fechaFinDate = new Date();
    
    fechaFin = fechaFinDate.getDate() + "/" +  (fechaFinDate.getMonth() + 1) + "/" + fechaFinDate.getFullYear() + " " +
                   fechaFinDate.getHours() + ":" +  fechaFinDate.getMinutes() + ":" + fechaFinDate.getSeconds();
                   
    set('formulario.hHoraFinChequeo', fechaFin); 
    
    eval('formulario').oculto = 'S';
    set('formulario.listaDetalles', armarListaDetalles()); 
    set('formulario.accion', 'actualizarCaja');
    set('formulario.conectorAction', 'LPChequearCajas');
    enviaSICC('formulario', null, null, 'N');
}

function armarListaDetalles(){    
      /*
      oidListaPicadoDetalle
      oidProducto
      oidMapaCDDetalle
      cantChequeada
      oidCodigoErrorChequeo
      */
      var codigos = listado1.codigos();
      var cadena = "";
      
      for (var i=0; i<codigos.length ; i++){
          if( i!= 0)
            cadena = cadena + "|";

          oidListaPicadoDetalle = listado1.extraeDato(codigos[i], 10)==""?"BLANCO":listado1.extraeDato(codigos[i], 10);
          cadena = cadena + oidListaPicadoDetalle + "#";
          
          oidProducto = listado1.extraeDato(codigos[i], 9)==""?"BLANCO":listado1.extraeDato(codigos[i], 9);
          cadena = cadena + oidProducto + "#";
          
          oidMapaCDDetalle = listado1.extraeDato(codigos[i], 8)==""?"BLANCO":listado1.extraeDato(codigos[i], 8);
          cadena = cadena + oidMapaCDDetalle + "#";
          
          if(listado1.extraeDato(codigos[i], 4)=="" && listado1.extraeDato(codigos[i], 4)!=0){
              cantChequeada = "BLANCO";
          } else {
              cantChequeada = listado1.extraeDato(codigos[i], 4);
          }
                    
          cadena = cadena + cantChequeada + "#";
          
          oidCodigoErrorChequeo = listado1.extraeDato(codigos[i], 7)==""?"BLANCO":listado1.extraeDato(codigos[i], 7);
          cadena = cadena + oidCodigoErrorChequeo;       
          
      }
      return cadena;
}


function onClickCancelarChequeo(){

    visibilidad('capaCabecera','O');
    visibilidad('capaLista','O');
    
    set('formulario.txtNroCaja','');
    set('formulario.txtNroConsolidado','');    
	set('formulario.cbOrdenVisualChuqueo','');    
    accion('formulario.txtNroCaja', '.disabled=false'); 
    accion('formulario.txtNroConsolidado', '.disabled=false'); 
	accion('formulario.cbOrdenVisualChuqueo', '.disabled=false'); 
	document.all.RBOreden[0].disabled=false;
    document.all.RBOreden[1].disabled=false;
    
    deshabilitarHabilitarBoton('botonContenido','btnBuscar','A');
    deshabilitarHabilitarBoton('botonContenido','btnIniciarChequeo','A');
    deshabilitarHabilitarBoton('botonContenido','btnFinalizarChequeo','A');
    deshabilitarHabilitarBoton('botonContenido','btnCancelarChequeo','A');    
    deshabilitarHabilitarBoton('botonContenido','btnAgregarSobrante','A');
    
    listado1.limpia();
        
    focaliza("formulario.txtNroCaja");  	
}


function onClickAgregarSobrante(){retorno

    obj = new Object();
    obj.accion = 'agregarSobrante';

	// BELC400000722 - dmorello, 12/09/2007
	obj.hOidPeriodo = get('formulario.hOidPeriodo');

    var retorno = mostrarModalSICC('LPChequearCajas', 'agregarSobrante', obj, '800', '550');
    /* Retorna
    - descripcionProducto
    - anaquel
    - cantidadChequeada
    - oidMapaCDDetalle
    - oidProducto
    */    
    if(retorno!=null){
        var codigos = listado1.codigos();
        ultValor = Number(codigos[codigos.length-1]);
        
        nuevoValor = ultValor + 1;
    
        listado1.insertar(new Array(nuevoValor, "", retorno[0] , retorno[1] , "0", retorno[2], retorno[2], 
                                    get('formulario.COD_ERROR_SOBRANTE_NO_FACTURADO'), get('formulario.OID_ERROR_SOBRANTE_NO_FACTURADO'),
                                    retorno[3], retorno[4],""));       
    }
}

function onClickIniciarChequeo(){

    fechaInicialDate = new Date();
    
    fechaInicial = fechaInicialDate.getDate() + "/" +  (fechaInicialDate.getMonth() + 1) + "/" + fechaInicialDate.getFullYear() + " " +
                   fechaInicialDate.getHours() + ":" +  fechaInicialDate.getMinutes() + ":" + fechaInicialDate.getSeconds();
                   
    set('formulario.hHoraInicioChequeo', fechaInicial);          
                   
    deshabilitarHabilitarBoton('botonContenido','btnCancelarChequeo','D');
    
    // Lenvanta una modal por cada detalle    
     var codigos = listado1.codigos();
     var obj = "";     
                    
     for (var i=0; i<codigos.length ; i++){
     
        cantidadReq = listado1.extraeDato(codigos[i], 3);
     
        obj = new Object();
        obj.accion = 'chequearUnidades';
        obj.descProd = listado1.extraeDato(codigos[i], 1);
        obj.cantidadRequerida = cantidadReq;
   
        var retorno = mostrarModalSICC('LPChequearCajas', 'chequearUnidades', obj, '600', '250');
        
        if(retorno!=null){
            /* Valores de retorno
            retorno[0] = unidadesCaja;
            retorno[1] = oidCodigoError;
            retorno[2] = codigoError;
            */     
            unidadesChequeada= Number(retorno[0]);
            diferencia = cantidadReq - unidadesChequeada;
            
            listado1.insertaDato(codigos[i],4,retorno[0]);
            listado1.insertaDato(codigos[i],5,diferencia);
            listado1.insertaDato(codigos[i],6,retorno[2]);
            listado1.insertaDato(codigos[i],7,retorno[1]);        
            
        } else {
            return;
        }
     }
     
     deshabilitarHabilitarBoton('botonContenido','btnFinalizarChequeo','A');
     deshabilitarHabilitarBoton('botonContenido','btnAgregarSobrante','A');
}


function onClickBuscar(){

     // Para que tome el valor al ingresarlo desde la lectora de barras
     set('formulario.txtNroCaja',get('formulario.txtNroCaja'));
     
     if(sicc_validaciones_generales("gBuscar")) {
     
        fecha = new Date();        
        set('formulario.hAnio', fecha.getYear());
     
        eval('formulario').oculto = 'N';
        set('formulario.conectorAction', 'LPChequearCajas');
        set('formulario.accion', 'buscarCaja');
        enviaSICC('formulario', null, null, 'N');
     }
}


function focalizaFC(){
     focalizaBotonHTML_XY('btnFinalizarChequeo');
}

function fLimpiar(){

    visibilidad('capaCabecera','O');
    visibilidad('capaLista','O');
    
    set('formulario.txtNroCaja','');
    set('formulario.txtNroConsolidado','');    
    accion('formulario.txtNroCaja', '.disabled=false'); 
    accion('formulario.txtNroConsolidado', '.disabled=false'); 
    //Agregado por cambio 20090839
	accion('formulario.cbOrdenVisualChuqueo', '.disabled=false'); 
    document.all.RBOreden[0].disabled=false;
    document.all.RBOreden[1].disabled=false;
	set('formulario.RBOreden', 'A');		
    
    deshabilitarHabilitarBoton('botonContenido','btnBuscar','A');
    deshabilitarHabilitarBoton('botonContenido','btnIniciarChequeo','A');
    deshabilitarHabilitarBoton('botonContenido','btnFinalizarChequeo','A');
    deshabilitarHabilitarBoton('botonContenido','btnCancelarChequeo','A');    
    deshabilitarHabilitarBoton('botonContenido','btnAgregarSobrante','A');
    
    listado1.limpia();
        
    focaliza("formulario.txtNroConsolidado");  	
}


function isBotonDisable(IDBoton,NombreBoton){        
                  var btns=document.all[IDBoton];
                  var boton=null;

                  if (!btns)
                           return
                  else if (!btns.length)
                           boton=btns;
                  else {
                       for (var f=0; f<btns.length;f++)   {
                            if (btns[f].name && btns[f].name==NombreBoton)   {
                              boton=btns[f];
                              break;
                            }
                       }
                  }

                  if (boton)
                          return boton.disabled;
                           
 }



function focalizaTab(campo){
    
    // Vengo del boton buscar
    if(campo==1){
        if(listado1.codigos().length!=0){
           if(isBotonDisable('botonContenido','btnIniciarChequeo')==false){
              focalizaBotonHTML_XY('btnIniciarChequeo');
           } else if(isBotonDisable('botonContenido','btnFinalizarChequeo')==false){
              focalizaBotonHTML_XY('btnFinalizarChequeo');
           } else if(isBotonDisable('botonContenido','btnCancelarChequeo')==false){
              focalizaBotonHTML_XY('btnCancelarChequeo');
           } else if(isBotonDisable('botonContenido','btnAgregarSobrante')==false){
              focalizaBotonHTML_XY('btnAgregarSobrante');
           } else {
              focalizaBotonHTML_XY('btnIniciarChequeo');        
           }           
        } else {           
            focaliza('formulario.txtNroConsolidado','');           
        }
    } 
    
    // Vengo del boton btnIniciarChequeo
    if(campo==2){
       if(isBotonDisable('botonContenido','btnFinalizarChequeo')==false){
          focalizaBotonHTML_XY('btnFinalizarChequeo');
       } else if(isBotonDisable('botonContenido','btnCancelarChequeo')==false){
          focalizaBotonHTML_XY('btnCancelarChequeo');
       } else if(isBotonDisable('botonContenido','btnAgregarSobrante')==false){
          focalizaBotonHTML_XY('btnAgregarSobrante');
       } else {
          focalizaBotonHTML_XY('btnIniciarChequeo'); 
       }                 
    }
    
    // Vengo del boton btnFinalizarChequeo
    if(campo==3){
       if(isBotonDisable('botonContenido','btnCancelarChequeo')==false){
          focalizaBotonHTML_XY('btnCancelarChequeo');
       } else if(isBotonDisable('botonContenido','btnAgregarSobrante')==false){
          focalizaBotonHTML_XY('btnAgregarSobrante');
       } else {
          focalizaBotonHTML_XY('btnIniciarChequeo'); 
       }                 
    }
    
    // Vengo del boton btnCancelarChequeo
    if(campo==4){
       if(isBotonDisable('botonContenido','btnAgregarSobrante')==false){
          focalizaBotonHTML_XY('btnAgregarSobrante');
       } else {
          focalizaBotonHTML_XY('btnIniciarChequeo');         
       }                 
    }
    
    // Vengo del boton btnAgregarSobrante
    if(campo==5){
      focalizaBotonHTML_XY('btnIniciarChequeo');     
    }
}

function focalizaShTab(campo){
    
    // Vengo del Nro Caja
    if(campo==1){
      focalizaBotonHTML('botonContenido','btnBuscar');
    }
    
    // Vengo del boton btnAgregarSobrante
    if(campo==2){
       if(isBotonDisable('botonContenido','btnCancelarChequeo')==false){
          focalizaBotonHTML_XY('btnCancelarChequeo');
       } else if(isBotonDisable('botonContenido','btnFinalizarChequeo')==false){
          focalizaBotonHTML_XY('btnFinalizarChequeo');
       } else {
          focalizaBotonHTML_XY('btnIniciarChequeo'); 
       }   
    }
    
    // Vengo del boton btnCancelarChequeo
    if(campo==3){
      if(isBotonDisable('botonContenido','btnFinalizarChequeo')==false){
          focalizaBotonHTML_XY('btnFinalizarChequeo');
       } else {
          focalizaBotonHTML_XY('btnIniciarChequeo'); 
       }   
    }
    
    // Vengo del boton btnFinalizarChequeo
    if(campo==4){
          focalizaBotonHTML_XY('btnIniciarChequeo');        
    }
    
    // Vengo del boton btnIniciarChequeo
    if(campo==5){
       if(isBotonDisable('botonContenido','btnAgregarSobrante')==false){
          focalizaBotonHTML_XY('btnAgregarSobrante');
       } else if(isBotonDisable('botonContenido','btnCancelarChequeo')==false){
          focalizaBotonHTML_XY('btnCancelarChequeo');
       } else if(isBotonDisable('botonContenido','btnFinalizarChequeo')==false){
          focalizaBotonHTML_XY('btnFinalizarChequeo');
       } else {
          focalizaBotonHTML_XY('btnIniciarChequeo'); 
       }   
    }
}
