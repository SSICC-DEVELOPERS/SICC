function onLoadPag(){  
    configurarMenuSecundario('formulario');    
    opcionMenu = get('formulario.opcionMenu');
    
    if(!fMostrarMensajeError()){
        if(opcionMenu == "insertar"){
           focaliza("formulario.codAlma");
        } if(opcionMenu == "modificar" || opcionMenu == "consultar"){
           onLoadPagModificarConsultar();
        }
    }
}

function onLoadPagModificarConsultar(){  
   
    set('formulario.indInfoSap', get('formulario.infSAP_detalle'));
    set('formulario.cbCentroDistribucion', [get('formulario.oidCentroDistribucion_detalle')]);
    
    opcionMenu = get('formulario.opcionMenu');
    
    if(opcionMenu == "modificar"){
         accion('formulario.codAlma', '.disabled=true');
         focaliza("formulario.txtDescripcion");
                  
    } else if(opcionMenu == "consultar"){
         accion('formulario.codAlma', '.disabled=true');
         accion('formulario.txtDescripcion', '.disabled=true');
         accion('formulario.indInfoSap', '.disabled=true');
         accion('formulario.cbCentroDistribucion', '.disabled=true');
    }
}

function arrayVacio(){  
    var array = new Array();              
         array[0] = new Array('','');
  
    return array;
}

function fGuardar(){

    if(sicc_validaciones_generales("gAlmacen")) {
         
         eval('formulario').oculto = 'S';
         set('formulario.conectorAction', 'LPMantenimientoAlmacenes');
         set('formulario.accion', 'guardar');
         enviaSICC('formulario', null, null, 'N');
    }
}

function cerrarModal(){
   
     var retorno = new Array();
     retorno[0] = "OK";
    
     returnValue = retorno;
     close();
}

function fLimpiar(){
    opcionMenu = get('formulario.opcionMenu');
    
    if(opcionMenu == "insertar"){
         set('formulario.codAlma', '');         
         
         set('formulario.txtDescripcion', '');         
         limpiaI18N('formulario', 1);
         
         set('formulario.indInfoSap', 'N');  
         set('formulario.cbCentroDistribucion', '');  
         
         focaliza("formulario.codAlma");
         
    } else if(opcionMenu == "modificar"){
           eval('formulario').oculto = 'N';
           set('formulario.conectorAction', 'LPMantenimientoAlmacenes');
           set('formulario.accion', 'modificar');
           enviaSICC('formulario', null, null, 'N');
    }
}

function focalizaCod(){
    focaliza("formulario.codAlma");
}

function focalizaDesc(){
    focaliza("formulario.txtDescripcion");
}


function fVolver(){
  close();
}

function focalizaTab(){
  opcionMenu = get('formulario.opcionMenu');
    
  if(opcionMenu == "insertar"){
      focaliza("formulario.codAlma");
  } else {
      focaliza("formulario.txtDescripcion");
  }
}

function focalizaShTab(num){
  opcionMenu = get('formulario.opcionMenu');
    
  if(opcionMenu == "insertar" && num=="1"){
      focaliza("formulario.cbCentroDistribucion");
  }else if(opcionMenu == "insertar" && num=="2"){
      focaliza("formulario.codAlma");
  }else if(opcionMenu == "modificar" && num=="1"){
      focaliza("formulario.cbCentroDistribucion");
  }
}