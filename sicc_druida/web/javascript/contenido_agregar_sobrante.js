function onLoad(){  
	
    configurarMenuSecundario('formulario');

	fMostrarMensajeError();
    
	ocultarLista();
	
	focaliza("formulario.txtCodigoProducto"); 
	
}


function onClickAceptar(){
    var codigo = listado1.codSeleccionados();
        
    if(codigo==""){
        GestionarMensaje('4',null,null,null);           
        focaliza("formulario.txtCodigoProducto");
        return;
    }
   
    // Valida obligatoriedad de Unidades caja
    if(listado1.extraeDato(codigo, 3)=="") {
         GestionarMensaje('2586');
         eval("listado1.preparaCamposDR()");
         focaliza('frm'+'listado1'+'.'+'UnidadesEnLaCaja'+'_'+DrIndiceEnArray(listado1.datos,codigo,0),'');
         return;
    }
    
    // Valida formato de UnidadesEnLaCaja
    if(!sicc_valida_numero_lista(listado1.extraeDato(codigo, 3), GestionarMensaje('2589'),1, 99999999)) {
         eval("listado1.preparaCamposDR()");
         focaliza('frm'+'listado1'+'.'+'UnidadesEnLaCaja'+'_'+DrIndiceEnArray(listado1.datos,codigo,0),'');
         return;
    }
    
    /* Devuelve
    - descripcionProducto
    - anaquel
    - cantidadChequeada
    - oidMapaCDDetalle
    - oidProducto
    */
    var retorno = new Array();
    retorno[0] = listado1.extraeDato(codigo, 1);
    retorno[1] = listado1.extraeDato(codigo, 2);
    retorno[2] = listado1.extraeDato(codigo, 3);
    retorno[3] = listado1.extraeDato(codigo, 4);
    retorno[4] = listado1.extraeDato(codigo, 5);
    
    returnValue = retorno;
    close();   
}


function onClickBuscar(){
     
         ocultarLista();
         var arr = new Array();
         
         arr[arr.length] = new Array("codigoProducto", get("formulario.txtCodigoProducto"));  
         arr[arr.length] = new Array("descripcionProducto", get("formulario.txtDescripcionProducto")); 

		 // BELC400000722 - dmorello, 12/09/2007
		 arr[arr.length] = new Array("oidPeriodo", get("formulario.hOidPeriodo"));
         
         configurarPaginado(mipgndo,"APEBuscarProducto","ConectorBuscarProducto",
                            "es.indra.sicc.dtos.ape.DTOBuscarProducto",arr);
}

function muestraLista(ultima, rowset) {

    var tamanio = rowset.length;

    if (tamanio > 0) {
       mostrarLista();
       return true;
   } else {
       ocultarLista();
       listado1.limpia();
       return false;
   }
} 


function ocultarLista(){
    document.all["Cplistado1"].style.visibility='hidden'; 
    document.all["CpLin1listado1"].style.visibility='hidden';  
    document.all["CpLin2listado1"].style.visibility='hidden'; 
    document.all["CpLin3listado1"].style.visibility='hidden';
    document.all["CpLin4listado1"].style.visibility='hidden';  
    
    document.all["ret1Div"].style.visibility='hidden';
    document.all["ava1Div"].style.visibility='hidden';  
    document.all["btnAceptarDiv"].style.visibility='hidden';
}
  
  
function mostrarLista(){

    DrdEnsanchaConMargenDcho('listado1',28);
    document.all["Cplistado1"].style.visibility=''; 
    document.all["CpLin1listado1"].style.visibility='';  
    document.all["CpLin2listado1"].style.visibility=''; 
    document.all["CpLin3listado1"].style.visibility='';
    document.all["CpLin4listado1"].style.visibility='';  
    
    document.all["ret1Div"].style.visibility='';
    document.all["ava1Div"].style.visibility='';  
    document.all["btnAceptarDiv"].style.visibility='';
    
    eval (ON_RSZ);     
}


function fLimpiar(){

    set('formulario.txtCodigoProducto','');
    set('formulario.txtDescripcionProducto','');    
    
    ocultarLista();
    
    listado1.limpia();
    
    focaliza("formulario.txtCodigoProducto"); 
}

function fVolver(){
  close();
}

function focalizaTab(campo){
    
    // Vengo del boton buscar
    if(campo==1){
        if(listado1.codigos().length!=0){
            eval("listado1.preparaCamposDR()");
            focaliza('frm'+'listado1'+'.'+'UnidadesEnLaCaja'+'_0','');            
        } else {           
            focaliza('formulario.txtCodigoProducto','');           
        }
    } 
    
    // Vengo del boton aceptar
    if(campo==2){
       focaliza('formulario.txtCodigoProducto','');       
    }
}

function focalizaShTab(campo){
    
    // Vengo del boton Eliminar
    if(campo==1){
        if(listado1.codigos().length!=0){
           focalizaBotonHTML_XY('btnAceptar');         
        } else {
           focalizaBotonHTML('botonContenido','btnBuscar');
        }
    } 
    
    // Vengo de boton aceptar
    if(campo==2){
        var indiceFila = listado1.datos.length - 1;
        eval("listado1.preparaCamposDR()");
        focaliza('frm'+'listado1'+'.'+'UnidadesEnLaCaja'+'_'+indiceFila,'');  
    }    
}

function focalizaListaShTab(FILAEVENTO) {    
    if(FILAEVENTO == 0){     	
      setTimeout("focalizaBotonHTML('botonContenido','btnBuscar')",10);  
    }            
}

function sicc_valida_numero_lista(strValor, strMostrar, valorMinimo, valorMaximo) {
          var formulario_local = getFormularioSICC();
          var valorTest = strValor;
          if(valorTest==""){
                    return true;
          }        
                  
          strCantDec="0";
          strSepDec = get(formulario_local+".hSeparadorDecimalPais");
          strSepMil = get(formulario_local+".hSeparadorMilesPais");
          

          //Primero me fijo si es un numero, para eso
          //le saco todos los separadores
          var strCleaned = valorTest.split(strSepDec).join("");
          strCleaned = strCleaned.split(strSepMil).join("")+"";
          
          if(!parseInt(strCleaned.substr(0,1),10) && parseInt(strCleaned.substr(0,1),10)!=0){//si el primero no es un numero, puede ser solo el simbolo negativo
                    if(strCleaned.substr(0,1)!="-"){
                              cdos_mostrarAlert(GestionarMensaje("000000000000100" ,  strMostrar));
                              return false;
                    }else{//tambien lo saco para testear el numero
                              strCleaned = strCleaned.substr(1);
                    }
          }

          var RegInteger = /^\d+$/; //Solo numeros
          if(!RegInteger.test(strCleaned)){
                    cdos_mostrarAlert(GestionarMensaje("000000000000100" ,  strMostrar));
                    return false;
          }
          
          //Ahora se que es un numero, primero valido los decimales
          //el ultimo debe ser un numero
          if(isNaN(parseInt(valorTest.substr(valorTest.length-1),10))){
                              cdos_mostrarAlert(GestionarMensaje("000000000000100" ,  strMostrar));
                              return false;
          }

          //me fijo el largo de los decimales
          var arrTest = valorTest.split(strSepDec);
          if(arrTest.length ==2 && arrTest[1]!=null && arrTest[1]!=""){//si tiene decimales
                    if(parseInt(strCantDec,10)==0){
                              cdos_mostrarAlert(GestionarMensaje("000000000000104"));
                              return false;
                    }
                    var strDecimales = arrTest[arrTest.length-1]+"";
                    if(strDecimales.length > parseInt(strCantDec,10)){//me fijo cuantos son
                              cdos_mostrarAlert(GestionarMensaje("000000000000101" ,  strMostrar,parseInt(strCantDec,10)));
                              return false;
                    }
          }else{
                    if(arrTest.length > 2){//sino
                              cdos_mostrarAlert(GestionarMensaje("000000000000102" ,  strMostrar));
                              return false;
                    }
          }
          //ahora voy por la parte entera

          var strInteger = arrTest[0]+"";
          
          if(strInteger.indexOf(strSepMil) >- 1){//si tiene separadores de miles
                    var arrInteger = strInteger.split(strSepMil);
                    //en todo el array los numero son de a 3 digitos
                    //excepto en la primera posicion, 
                    //donde solo no pueden ser 4 digitos
                    for(var i=0; i < arrInteger.length; i++){
                              if(i==0){
                                         if((arrInteger[i]+"").length>3){
                                                   cdos_mostrarAlert(GestionarMensaje("000000000000100" ,  strMostrar));
                                                   return false;
                                         }
                              }else{
                                         if((arrInteger[i]+"").length!=3){
                                                   cdos_mostrarAlert(GestionarMensaje("000000000000105",strSepMil));
                                                   return false;
                                         }
                              }
                    }
          }


          //por ultimo valido el rango del valor
          //saco el separador de miles
          var strNumeroTest = valorTest.split(strSepMil).join("");
          //si el separador decimal es el punto, lo dejo, sino, lo reemplazo por el punto
          if(strSepDec!="."){
                    strNumeroTest  = strNumeroTest.split(strSepDec).join(".")
          }
          
          if(valorMinimo!=""){
                    if(parseFloat(strNumeroTest )<parseFloat(valorMinimo)){
                              cdos_mostrarAlert(GestionarMensaje("000000000000103" ,  strMostrar,parseFloat(valorMinimo),parseFloat(valorMaximo)));                              
                              return false;
                    }
          }      
          if(valorMaximo!=""){
                    if(parseFloat(strNumeroTest)>parseFloat(valorMaximo)){
                              cdos_mostrarAlert(GestionarMensaje("000000000000103" ,  strMostrar,parseFloat(valorMinimo),parseFloat(valorMaximo)));                              
                              return false;
                    }
          }
          return true;
  }
