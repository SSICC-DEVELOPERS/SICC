var esMultiple=true;
var strConector="";
var strDTO="";
var arrAppend = null;


function cargaPagina(){
     configurarMenuSecundario("frmContenido");
     
     visibilidad('capaDetalle','O');
     limpiarDetalle();
     
     var objParams = parent.params;
     if(objParams.parametros.datos){
           if(!objParams.parametros.datos.esMultiple){
                     esMultiple=false;
           }
           if(objParams.parametros.datos.dto!=null){
                     strDTO = objParams.parametros.datos.dto;
           }
           if(objParams.parametros.datos.conector!=null){
                     strConector = objParams.parametros.datos.conector;
           }
           
           arrAppend = objParams.parametros.datos.array;
           
           if(objParams.parametros.datos.buscarInicio){
                     btnBuscar_onClick();
           }
     }
     
     focaliza("frmContenido.txtCodigo");         
}

function limpiarDetalle(){
    set('frmContenido.ChkIndCenServGar', 'N');         
    set('frmContenido.cbCenServGar', '');   
    set('frmContenido.txtNumMeses', '');   
    set('frmContenido.areaObservaciones', '');   
    
    accion('frmContenido.cbCenServGar', '.disabled=true');  
    accion('frmContenido.txtNumMeses', '.disabled=true');  
    accion('frmContenido.areaObservaciones', '.disabled=true');  
    
    set('frmContenido.rdTipoEntrega', 'B');         
    set('frmContenido.cbCenServEntrega', '');   
    
    accion('frmContenido.cbCenServEntrega', '.disabled=true');  
}

function onclickIndCenServGar(){

    if(get('frmContenido.ChkIndCenServGar')=="S"){
         accion('frmContenido.cbCenServGar', '.disabled=false');  
         accion('frmContenido.txtNumMeses', '.disabled=false');  
         accion('frmContenido.areaObservaciones', '.disabled=false');
         
    } else if(get('frmContenido.ChkIndCenServGar')=="N"){    
         set('frmContenido.cbCenServGar', '');   
         set('frmContenido.txtNumMeses', '');   
         set('frmContenido.areaObservaciones', ''); 
         
         accion('frmContenido.cbCenServGar', '.disabled=true');  
         accion('frmContenido.txtNumMeses', '.disabled=true');  
         accion('frmContenido.areaObservaciones', '.disabled=true');  
    }
}

function onclickRdTipoEntrega(){

    if(get('frmContenido.rdTipoEntrega')=="B"){
         set('frmContenido.cbCenServEntrega', '');        
         accion('frmContenido.cbCenServEntrega', '.disabled=true');   
         
    } else if(get('frmContenido.rdTipoEntrega')=="C"){    
         accion('frmContenido.cbCenServEntrega', '.disabled=false');   
    }
}

function btnAceptar_onclick(){
          if(listado1.codSeleccionados().length==0){
                    GestionarMensaje("50",null,null,null);
                    return;
          }
          if(!esMultiple && listado1.codSeleccionados().length>1){
                    cdos_mostrarAlert( GestionarMensaje("240",null,null,null) );
                    return;
          }
          
          if((get('frmContenido.ChkIndCenServGar')=="N" || sicc_validaciones_generales("gCenServGar"))
          && (get('frmContenido.rdTipoEntrega')=="B" || sicc_validaciones_generales("gCenServEntrega"))) {
          
              var detalle = armarDetalle();
          
              var arrSalida = new Array();
              var arrSel = listado1.codSeleccionados();
              var largoSel = listado1.codSeleccionados().length;
              var largoDatos = listado1.datos.length;
              var largoReg = listado1.datos[0].length;
              for(var i=0;i<largoSel;i++){
                         for(var j=0;j<largoDatos;j++){
                                   if(arrSel[i]==listado1.datos[j][0]){
                                             var subArr = new Array();
                                             for(var n=0;n<largoReg;n++){
                                                        subArr[n]=listado1.datos[j][n]
                                             }
                                             subArr[n]= detalle;
                                             arrSalida[arrSalida.length] = subArr;
                                             break;
                                   }
                         }
              }
              //alert(arrSalida);
              window.returnValue = arrSalida;
              window.close();
          }
}

function armarDetalle(){
    var detalle = get('frmContenido.ChkIndCenServGar');
    
    if(get('frmContenido.cbCenServGar')!=""){
         detalle = detalle + "#" + get('frmContenido.cbCenServGar'); 
    } else {
         detalle = detalle + "#" + "BLANCO";
    }
    
    if(get('frmContenido.txtNumMeses')!=""){
         detalle = detalle + "#" + get('frmContenido.txtNumMeses'); 
    } else {
         detalle = detalle + "#" + "BLANCO";
    }
    
    if(get('frmContenido.areaObservaciones')!=""){
         detalle = detalle + "#" + get('frmContenido.areaObservaciones'); 
    } else {
         detalle = detalle + "#" + "BLANCO";
    }
    
    detalle = detalle + "#" + get('frmContenido.rdTipoEntrega'); 
    
    if(get('frmContenido.cbCenServEntrega')!=""){
         detalle = detalle + "#" + get('frmContenido.cbCenServEntrega'); 
    } else {
         detalle = detalle + "#" + "BLANCO";
    }
    
    //alert(detalle);
    return detalle;
}



function btnBuscar_onClick(){
          //configuramos el paginado
          configurarPaginado(mipgndo1,"CMNBusquedaGenerica","ConectorGENBusquedaProducto",
          "es.indra.sicc.cmn.negocio.comun.DTOComunes.DTOGenBusquedaProducto",armaArray());
          
          visibilidad('capaDetalle','V');
}

function armaArray(){
   var arrDatos = new Array();
   var objParams = parent.params;

   arrDatos[arrDatos.length] = new Array('oidIdioma',"0");
   arrDatos[arrDatos.length] = new Array('oidPais',"0");
   arrDatos[arrDatos.length] = new Array("esPaginado","true");
   if (get('frmContenido.txtCodigo')!=''){
                                  if (isNaN(get('frmContenido.txtCodigo'))) {
                                            arrDatos[arrDatos.length] = new Array('strCodigo',get('frmContenido.txtCodigo'));
                                  }else{
                                            arrDatos[arrDatos.length] = new Array('codigo',get('frmContenido.txtCodigo'));
                                  }
   }
   if (get('frmContenido.txtDescripcion')!=''){
             arrDatos[arrDatos.length] = new Array('descripcion',get('frmContenido.txtDescripcion'));
   }
          
   if(arrAppend != null){
         for(var i = 0; i < arrAppend.length ;i++){
                   arrDatos[arrDatos.length] = arrAppend[i         ];
                }
   }

   return arrDatos;
}

function mostrarListado(rowset){
   if(rowset.length==0){
             mostrarOcultar("hidden");
             return false;
   }else{
      DrdEnsanchaConMargenDcho('listado1',12);
      mostrarOcultar("visible");
      eval (ON_RSZ);  
      return true;
   }
}

function mostrarOcultar(estado){
          document.all["Cplistado1"].style.visibility=estado;
          document.all["CpLin1listado1"].style.visibility=estado;
          document.all["CpLin2listado1"].style.visibility=estado;
          document.all["CpLin3listado1"].style.visibility=estado;
          document.all["CpLin4listado1"].style.visibility=estado;
          document.all["ret1Div"].style.visibility=estado;
          document.all["ava1Div"].style.visibility=estado;
}

function fLimpiar(){
          set("frmContenido.txtCodigo","");
          set("frmContenido.txtDescripcion","");
          mostrarOcultar("hidden");
          
          visibilidad('capaDetalle','O');          
          limpiarDetalle();
}
function fVolver(){
          window.close();
}


function focalizaTab(campo){
  if(campo==1){
      if(listado1.codigos().length==0){
           focaliza("frmContenido.txtCodigo"); 
      } else {
           focaliza("frmContenido.ChkIndCenServGar"); 
      }
  } else if(campo==2){
      focaliza("frmContenido.txtCodigo"); 
  }
}


function focalizaShTab(campo){
  if(campo==1){
     if(listado1.codigos().length==0){
            focalizaBotonHTML('botonContenido','btnBuscar');
      } else {
            focalizaBotonHTML('botonContenido','btnAceptar');
      }
  } else if(campo==2){
      focalizaBotonHTML('botonContenido','btnBuscar');
  }
}

