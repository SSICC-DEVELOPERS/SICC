function onLoadPag(){  
         
    configurarMenuSecundario('formulario');
    
    btnProxy(1,0);
   
    ocultarLista();
    
    fMostrarMensajeError();
    
    focaliza("formulario.codAlma");     
}

function visualizaBotones(){  

    opcionMenu = get('formulario.opcionMenu');
    
    if(opcionMenu == "modificar"){
         document.all["ModificarDiv"].style.visibility='';
         document.all["DetalleDiv"].style.visibility='hidden';
   } else if(opcionMenu == "consultar"){
         document.all["ModificarDiv"].style.visibility='hidden';
         document.all["DetalleDiv"].style.visibility='';
    } else if(opcionMenu == "eliminar"){
         document.all["ModificarDiv"].style.visibility='hidden';
         document.all["DetalleDiv"].style.visibility='';
         
         btnProxy(4,1);
    }
}

function ocultarLista(){
    document.all["Cplistado1"].style.visibility='hidden'; 
    document.all["CpLin1listado1"].style.visibility='hidden';  
    document.all["CpLin2listado1"].style.visibility='hidden'; 
    document.all["CpLin3listado1"].style.visibility='hidden';
    document.all["CpLin4listado1"].style.visibility='hidden';  
    
    document.all["primera1Div"].style.visibility='hidden'; 
    document.all["ret1Div"].style.visibility='hidden';
    document.all["ava1Div"].style.visibility='hidden';  
    document.all["separaDiv"].style.visibility='hidden'; 
    document.all["DetalleDiv"].style.visibility='hidden'; 
    document.all["ModificarDiv"].style.visibility='hidden';
    
    opcionMenu = get('formulario.opcionMenu');
    if(opcionMenu == "eliminar"){
         btnProxy(4,0);
    }    
}
  
  
function mostrarLista(){

    DrdEnsanchaConMargenDcho('listado1',28);
    document.all["Cplistado1"].style.visibility=''; 
    document.all["CpLin1listado1"].style.visibility='';  
    document.all["CpLin2listado1"].style.visibility=''; 
    document.all["CpLin3listado1"].style.visibility='';
    document.all["CpLin4listado1"].style.visibility='';  
    
    document.all["primera1Div"].style.visibility=''; 
    document.all["ret1Div"].style.visibility='';
    document.all["ava1Div"].style.visibility='';  
    document.all["separaDiv"].style.visibility=''; 
    
    eval (ON_RSZ);          
    
    visualizaBotones();
}


function onClickBuscar(){
     
        ocultarLista();
        var arr = new Array();
        
        var pais = get("formulario.hPais");
        var idioma = get("formulario.hIdioma");
        arr[arr.length] = new Array("oidPais", pais);
        arr[arr.length] = new Array("oidIdioma", idioma);
        
        if(get("formulario.indInfoSap")=="S"){
           infoSap = true;
        } else {
           infoSap = false;
        }
        
        arr[arr.length] = new Array("codAlmacen", get("formulario.codAlma"));  
        arr[arr.length] = new Array("descripcion", get("formulario.txtDescripcion")); 
        arr[arr.length] = new Array("infSAP", infoSap);  
        arr[arr.length] = new Array("oidCentroDistribucion", get("formulario.cbCentroDistribucion")); 
        
        configurarPaginado(mipgndo,"APEBuscarAlmacen","ConectorBuscarAlmacen",
                             "es.indra.sicc.dtos.bel.DTOAlmacen",arr);     
}

function muestraLista(ultima, rowset) {

    var tamanio = rowset.length;

    if (tamanio > 0) {
        mostrarLista();
        return true;
   } else {
        ocultarLista();
            GestionarMensaje('2596',null,null,null);
        return false;
   }
} 

function fBorrar(){
    if (listado1.numSelecc() >= 1){
          var oids = listado1.codSeleccionados();
          //alert("Codigos:"+oids);
          eliminarFilas(oids,"APEEliminarAlmacen",mipgndo);
    }else{
          GestionarMensaje('4',null,null,null);                        
    }    
}

function onClickModificar(){
    if (listado1.numSelecc() >= 1){
        if (listado1.numSelecc() == 1){   
            var obj = new Object();
            codigo = listado1.codSeleccionados();
            
            obj.opcionMenu = get('formulario.opcionMenu')
            obj.accion = 'modificar';
            obj.oidAlmacen = codigo;
            
            var retorno = mostrarModalSICC('LPMantenimientoAlmacenes', 'modificar', obj, '800', '300');
            
            onClickBuscar();
            
        } else{
          GestionarMensaje('8',null,null,null);
        }
    } else{
          GestionarMensaje('4',null,null,null);                     
    } 
}

function onClickDetalle(){
    if (listado1.numSelecc() >= 1){
        if (listado1.numSelecc() == 1){   
            var obj = new Object();
            codigo = listado1.codSeleccionados();
            
            if(get('formulario.opcionMenu')=='eliminar'){
                opcionMenu = "consultar"
                vaccion = 'detalleEliminar';
            } else {
                opcionMenu = get('formulario.opcionMenu');
                vaccion = 'detalle';
            }
            
            obj.opcionMenu = opcionMenu;          
            obj.accion = vaccion;
            obj.oidAlmacen = codigo;
            
            var retorno = mostrarModalSICC('LPMantenimientoAlmacenes', vaccion, obj, '800', '300');
                
        } else{
          GestionarMensaje('8',null,null,null);
        }
    } else{
          GestionarMensaje('4',null,null,null);                     
    } 
}

function fLimpiar(){
    
    set('formulario.codAlma', '');      
    set('formulario.txtDescripcion', '');    
    set('formulario.indInfoSap', 'N');  
    set('formulario.cbCentroDistribucion', '');  
    
    listado1.limpia();
    ocultarLista();
    
    btnProxy(1,0);
    if(get('formulario.opcionMenu')=="eliminar"){
         btnProxy(4,1);
    }
    
    focaliza("formulario.codAlma");
}

function focalizaCod(){
    focaliza("formulario.codAlma");
}

function focalizaTab(){
  opcionMenu = get('formulario.opcionMenu');
  
    if(document.all.Cplistado1.style.visibility =='hidden'){
         focaliza("formulario.codAlma");
    } else {
         if(opcionMenu == "modificar"){
             focalizaBotonHTML_XY('Modificar');
         } else {
             focalizaBotonHTML_XY('Detalle');
         }
  }
}

function focalizaShTabBuscar(){
  focalizaBotonHTML('botonContenido','btnBuscar');
}

function focalizaShTab(){
  opcionMenu = get('formulario.opcionMenu');
    
  if(document.all.Cplistado1.style.visibility =='hidden'){
    focalizaBotonHTML('botonContenido','btnBuscar');
  } else {
         if(opcionMenu == "modificar"){
             focalizaBotonHTML_XY('Modificar');
         } else {
             focalizaBotonHTML_XY('Detalle');
         }
  }
}