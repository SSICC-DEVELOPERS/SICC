function onLoadPag(){  
	
    configurarMenuSecundario('formulario');
    
    btnProxy(1,0);
    
    focaliza("formulario.cbCentroDistribucion");     
    
    ocultarLista();
    
    if(!fMostrarMensajeError()){
        set('formulario.cbCentroDistribucion', [get('formulario.hCbCentroDistribucion')]);
    }
    
    focaliza("formulario.cbCentroDistribucion");  	
}

function visualizaBotones(){  

    opcionMenu = get('formulario.opcionMenu');
    
    if(opcionMenu == "ModificarParametrosArmado"){
        document.all["ModificarDiv"].style.visibility='';
        document.all["DetalleDiv"].style.visibility='hidden';
   } else if(opcionMenu == "ConsultarParametrosArmado"){
        document.all["ModificarDiv"].style.visibility='hidden';
        document.all["DetalleDiv"].style.visibility='';
    } else if(opcionMenu == "EliminarParametrosArmado"){
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
    if(opcionMenu == "EliminarParametrosArmado"){
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


function btnBuscarOnClick(){
     if(sicc_validaciones_generales("gBuscar")) {
     
         ocultarLista();
         var arr = new Array();
         
         var pais = get("formulario.hPais");
         var idioma = get("formulario.hIdioma");
         arr[arr.length] = new Array("oidPais", pais);
         arr[arr.length] = new Array("oidIdioma", idioma);
         
         arr[arr.length] = new Array("oidCentroDistribucion", get("formulario.cbCentroDistribucion"));  
         arr[arr.length] = new Array("descAgrupacionEspecifica", get("formulario.txtAgrupacioEspecifica")); 
         
         configurarPaginado(mipgndo,"APERecuperarConfiguracionesAFP","ConectorRecuperarConfiguracionesAFP",
                            "es.indra.sicc.dtos.ape.DTOAgrupacionEspecifica",arr);
     }
}

function muestraLista(ultima, rowset) {

    var tamanio = rowset.length;

    if (tamanio > 0) {
       mostrarLista();
       return true;
   } else {
       ocultarLista();
       return false;
   }
} 


function fBorrar(){
    if (listado1.numSelecc() >= 1){
         var oids = listado1.codSeleccionados();
         //alert("Codigos:"+oids);
         eliminarFilas(oids,"APEEliminarParametrosArmado",mipgndo);
    }else{
         GestionarMensaje('4',null,null,null);                     
    }    
}


function btnModificarOnClick(){
    if (listado1.numSelecc() >= 1){
       if (listado1.numSelecc() == 1){   
           var obj = new Object();
           codigo = listado1.codSeleccionados();
           
           obj.opcionMenu = get('formulario.opcionMenu')
           obj.accion = 'modificar';
           obj.oidCabeceraListaAFP = codigo;
           obj.txtAgrupacioEspecificaModif = listado1.extraeDato(codigo, 1);
           obj.oidCentroDistribucionModif = listado1.extraeDato(codigo, 2);
           obj.oidMarcaModif = listado1.extraeDato(codigo, 3);
           obj.oidCanalModif = listado1.extraeDato(codigo, 4);
           
           var retorno = mostrarModalSICC('LPMantenimientoParametrosArmado', 'modificar', obj, '800', '595');
           
       } else{
         GestionarMensaje('8',null,null,null);
       }
    } else{
         GestionarMensaje('4',null,null,null);                   
    } 
}

function btnDetalleOnClick(){
    if (listado1.numSelecc() >= 1){
       if (listado1.numSelecc() == 1){   
           var obj = new Object();
           codigo = listado1.codSeleccionados();
           
           obj.opcionMenu = get('formulario.opcionMenu')
           obj.accion = 'detalle';
           obj.oidCabeceraListaAFP = codigo;
           obj.txtAgrupacioEspecificaModif = listado1.extraeDato(codigo, 1);
           obj.oidCentroDistribucionModif = listado1.extraeDato(codigo, 2);
           obj.oidMarcaModif = listado1.extraeDato(codigo, 3);
           obj.oidCanalModif = listado1.extraeDato(codigo, 4);
           
           var retorno = mostrarModalSICC('LPMantenimientoParametrosArmado', 'detalle', obj, '800', '595');
              
       } else{
         GestionarMensaje('8',null,null,null);
       }
    } else{
         GestionarMensaje('4',null,null,null);                   
    } 
}

function fLimpiar(){
    set('formulario.cbCentroDistribucion', '');
    set('formulario.txtAgrupacioEspecifica', '');
    
    listado1.limpia();
    ocultarLista();
    
    focaliza("formulario.cbCentroDistribucion");
    
}

function focalizaTab(campo){
    opcionMenu = get('formulario.opcionMenu');
    
    if(campo=='1'){
        if(document.all.Cplistado1.style.visibility =='hidden'){
            focaliza("formulario.cbCentroDistribucion");
        } else {
            if(opcionMenu == "ModificarParametrosArmado"){
                focalizaBotonHTML_XY('Modificar');
            } else {
                focalizaBotonHTML_XY('Detalle');
            }
        }
    } else {
        focaliza("formulario.cbCentroDistribucion");
    }
}

function focalizaShTab(campo){
    opcionMenu = get('formulario.opcionMenu');
    
    if(campo=='1'){
        if(document.all.Cplistado1.style.visibility =='hidden'){
            focalizaBotonHTML('botonContenido','btnBuscar');
        } else {
            if(opcionMenu == "ModificarParametrosArmado"){
                focalizaBotonHTML_XY('Modificar');
            } else {
                focalizaBotonHTML_XY('Detalle');
            }
        }
    } else {
        focalizaBotonHTML('botonContenido','btnBuscar');
    }
}
