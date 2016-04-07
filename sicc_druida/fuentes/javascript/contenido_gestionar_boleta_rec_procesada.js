function onLoadPag(){  
          
    configurarMenuSecundario('formulario');
    
    llenaCbEstadoBoleta();    
    
    fMostrarMensajeError();
    
    set('formulario.txtFecCaptura', get('formulario.hTxtFecCaptura'));
    set('formulario.cbEstado', [get('formulario.hOidEstado')]);
    
    if(get("formulario.cbEstado")!=""){         
         onClickBuscar();
    } else {
         ocultarLista();
    }
    
    focaliza("formulario.txtFecCaptura");     
}

function llenaCbEstadoBoleta(){

    var array = new Array();              
    array[0] = new Array('','');
    array[1] = new Array('0',GestionarMensaje('2615'));
    array[2] = new Array('1',GestionarMensaje('2614'));

    set_combo('formulario.cbEstadoBoleta', array);
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
    document.all["EliminarDiv"].style.visibility='hidden'; 
  
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
    document.all["EliminarDiv"].style.visibility=''; 
    
    eval (ON_RSZ);           
}


function onClickBuscar(){

    if(sicc_validaciones_generales("gBuscar")){
    
         ocultarLista();
         var arr = new Array();
         
         var pais = get("formulario.hPais");
         var idioma = get("formulario.hIdioma");
         arr[arr.length] = new Array("oidPais", pais);
         arr[arr.length] = new Array("oidIdioma", idioma);
                  
         arr[arr.length] = new Array("fechaCaptura", get("formulario.txtFecCaptura"));  
         arr[arr.length] = new Array("formatoFechaPais", get("formulario.hFormatoFechaPais"));  
         arr[arr.length] = new Array("oidEstadoRecojo", get("formulario.cbEstado")); 
         arr[arr.length] = new Array("validacion", get("formulario.cbEstadoBoleta")); 
         arr[arr.length] = new Array("orden", get("formulario.rdOrden")); 
         
         configurarPaginado(mipgndo,"RECBuscarBolRecProcesadas","ConectorBuscarBolRecProcesadas",
                                 "es.indra.sicc.dtos.rec.DTOBuscarBolRecProcesadas",arr);     
              
    }
}

function internalizacion(rowset) {
    var tamanio = rowset.length;
    
    for(var i=0; i<tamanio; i++){     
      reg = rowset[i];
    
      if(reg[3]=="1"){
            reg[3]= GestionarMensaje('2614');
      } else{
            reg[3]= GestionarMensaje('2615');
      }
    }  
}

function muestraLista(ultima, rowset) {

    var tamanio = rowset.length;
    
    if (tamanio > 0) {    
         mostrarLista();
         internalizacion(rowset);
         return true;
   } else {
         ocultarLista();
         GestionarMensaje('2596',null,null,null);
         return false;
   }
} 

function onClickEliminar(){
    if (listado1.numSelecc() >= 1){
           var oids = listado1.codSeleccionados();
           //alert("Codigos:"+oids);
           eliminarFilas(oids,"RECEliminarBolRecProcesadas",mipgndo);
    }else{
           GestionarMensaje('4',null,null,null);                           
    }    
}


function fLimpiar(){
    
    set('formulario.txtFecCaptura', get('formulario.hTxtFecCaptura'));
    set('formulario.cbEstado', [get('formulario.hOidEstado')]); 
    set('formulario.cbEstadoBoleta', '');  
    set('formulario.rdOrden', 'I');  
    
    if(get("formulario.cbEstado")!=""){         
         onClickBuscar();
    } else {
         ocultarLista();
    }
    
    focaliza("formulario.txtFecCaptura");
}

function onClickEliminarBolRecOK(){

    eval('formulario').oculto = 'S'; 
    set('formulario.conectorAction', 'LPGestionarBoletaRecProcesada');
    set('formulario.accion', 'eliminarBolRecojoOK');
    enviaSICC('formulario', null, null, 'N');
}


function fVolver(){
  close();
}

function focalizaFechaCaptura(){
    focaliza("formulario.txtFecCaptura");
}

function focalizaTab(){
  
    if(document.all.Cplistado1.style.visibility =='hidden'){
         focaliza("formulario.txtFecCaptura");
    } else {         
         focalizaBotonHTML_XY('Eliminar');
    }
}

function focalizaShTabEliminarOK(){
  focalizaBotonHTML('botonContenido','btnEliminarBolRecOK');
}

function focalizaShTab(){

  if(document.all.Cplistado1.style.visibility =='hidden'){
      focalizaBotonHTML('botonContenido','btnEliminarBolRecOK');
  } else {
      focalizaBotonHTML_XY('Eliminar');
  }
}

