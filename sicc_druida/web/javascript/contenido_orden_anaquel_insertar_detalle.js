var var_NO = GestionarMensaje('1011');
var var_SI = GestionarMensaje('1010');

function onLoadPag(){
    configurarMenuSecundario('formulario');
    
     if(fMostrarMensajeError()){
         close();
    } else {
         if(get('formulario.opcionMenu') == 'consultar' || get('formulario.opcionMenu') == "eliminar"){  
             deshabilitarPantalla();
             mostrarLista();   
             
         } else {
             mostrarLista();
             
             eval("listado1.preparaCamposDR()");
             focaliza('frm'+'listado1'+'.'+'txtNroOrden'+'_0','');
         }
    }
}


function deshabilitarPantalla(){   
      
      listado1.tiposCol[1][8]=true;    
      listado1.actualizaDat();
      
      // Menu secundario en la modal
      btnProxy(2, '1');
      btnProxy(3, '0');
      btnProxy(4, '0');
      btnProxy(5, '0');
      btnProxy(7, '0');
      btnProxy(8, '0');
      btnProxy(9, '0');
}


function mostrarLista(){

    internacionalizacionIndExpAnaq();
    
    DrdEnsanchaConMargenDcho('listado1',28);
    document.all["Cplistado1"].style.visibility='visible';
    document.all["CpLin1listado1"].style.visibility='visible';
    document.all["CpLin2listado1"].style.visibility='visible';
    document.all["CpLin3listado1"].style.visibility='visible';
    document.all["CpLin4listado1"].style.visibility='visible';
    
    if(get('formulario.pagina')==1){
         deshabilitarHabilitarBoton('botonContenido','Anterior','D');
    } else {
         deshabilitarHabilitarBoton('botonContenido','Anterior','A');
    }
    
    if(get('formulario.pagina')!= get('formulario.cantPaginas')){
         deshabilitarHabilitarBoton('botonContenido','Siguiente','A');
    } else {
         deshabilitarHabilitarBoton('botonContenido','Siguiente','D');
    }         
    
    if(get('formulario.opcionMenu') == 'insertar' && get('formulario.pagina')!= get('formulario.cantPaginas')){
         deshabilitarHabilitarBoton('botonContenido','Aceptar','D');
    } else if(get('formulario.opcionMenu') == 'consultar' || get('formulario.opcionMenu') == "eliminar"){  
         deshabilitarHabilitarBoton('botonContenido','Aceptar','D');
    } else {
         deshabilitarHabilitarBoton('botonContenido','Aceptar','A');
    }     
    
    eval (ON_RSZ);  
}

function internacionalizacionIndExpAnaq(){
  
  var codigos = listado1.codigos();
         for(var i=0; i<codigos.length; i++){
  
      if(listado1.extraeDato(codigos[i],2)=="1"){
           listado1.insertaDato(codigos[i],2, var_SI,true);
      } else if(listado1.extraeDato(codigos[i],2)=="0"){
           listado1.insertaDato(codigos[i],2, var_NO,true);
      }
  }
}

function fLimpiar(){
  eval('formulario').oculto = 'N';
  set('formulario.paginaAMostrar', get('formulario.pagina'));  
  set('formulario.conectorAction', 'LPMantenimientoOrdenAnaqueles');
  set('formulario.accion', 'limpiarAnaquelPagina');
  enviaSICC('formulario', null, null, 'N');  
}


function cargaArray(datos){
    var seteo = new Array(datos.length + 1);
    seteo[0] = ['' , '']
    for(i = 0; i < datos.length; i++){
      seteo[i+1] = [ datos[i][0], datos[i][1] ]
    }
    return seteo;
}

function arrayVacio(){  
    var array = new Array();              
         array[0] = new Array('','');
  
    return array;
}


function bntSiguiente() {

  if(validaBlancosYRepetidos()){

      eval('formulario').oculto = 'S';
      set('formulario.ordenPagina', armarListaPag());   
      set('formulario.conectorAction', 'LPMantenimientoOrdenAnaqueles');
      set('formulario.accion', 'verificarAnaquelPaginaSiguiente');
      enviaSICC('formulario', null, null, 'N');
  }  
}


function validaBlancosYRepetidos() {
  //recorro los combos para impedir algun blanco seleccionado en ellos  
         var codigos = listado1.codigos();
  var numOrden1 = new Array();
  
         for(var i=0; i<codigos.length; i++){
                  codigo = codigos[i];
                  orden = listado1.extraeDato(codigo, 1);
    numOrden1[i]= orden;
    
                  if (orden==""){
                      GestionarMensaje('2583');
         eval("listado1.preparaCamposDR()");
         focaliza('frm'+'listado1'+'.'+'txtNroOrden'+'_'+ i,''); 
         return false;
                  }
    
    if(!sicc_valida_numero_lista(orden, GestionarMensaje('2620'),0, 99999)) {
         eval("listado1.preparaCamposDR()");
         focaliza('frm'+'listado1'+'.'+'txtNroOrden'+'_'+ i,''); 
         return false;
    }    
         }
  
  var numOrden2 = numOrden1;
  var orden1="";
  //Verifico que no se hayan introducidos numOrden repetidos en la pagina  
         for(var i=0; i<codigos.length; i++){
                  orden1 = numOrden1[i];
    
    for(var j=(i+1); j<codigos.length; j++){
    
         if (orden1==numOrden2[j]){
             GestionarMensaje('2582');
             eval("listado1.preparaCamposDR()");
             focaliza('frm'+'listado1'+'.'+'txtNroOrden'+'_'+ j,''); 
             return false;
         }
    }
         }
  
  return true;
}

function verificacionNoOK(posicion) {
    eval("listado1.preparaCamposDR()");
    focaliza('frm'+'listado1'+'.'+'txtNroOrden'+'_'+ posicion,''); 
    return;    
}

function okSiguiente() {
  eval('formulario').oculto = 'N';
  set('formulario.paginaAMostrar', Number(get('formulario.pagina')) + 1);   
  set('formulario.ordenPagina', armarListaPag());   
  set('formulario.conectorAction', 'LPMantenimientoOrdenAnaqueles');
  set('formulario.accion', 'guardarAnaquelPagina');
  enviaSICC('formulario', null, null, 'N');  
  
}


function bntAnterior() {
         
  if(validaBlancosYRepetidos()){
      eval('formulario').oculto = 'S';
      set('formulario.ordenPagina', armarListaPag());   
      set('formulario.conectorAction', 'LPMantenimientoOrdenAnaqueles');
      set('formulario.accion', 'verificarAnaquelPaginaAnterior');
      enviaSICC('formulario', null, null, 'N');  
  }
}

function okAnterior() {
           
  eval('formulario').oculto = 'N';
  set('formulario.paginaAMostrar', Number(get('formulario.pagina')) - 1);   
  set('formulario.ordenPagina', armarListaPag());   
  set('formulario.conectorAction', 'LPMantenimientoOrdenAnaqueles');
  set('formulario.accion', 'guardarAnaquelPagina');
  enviaSICC('formulario', null, null, 'N');  
}


function bntAceptar() {

         if(validaBlancosYRepetidos()){
      eval('formulario').oculto = 'S';
      set('formulario.ordenPagina', armarListaPag());   
      set('formulario.conectorAction', 'LPMantenimientoOrdenAnaqueles');
      set('formulario.accion', 'verificarAnaquelPaginaAceptar');
      enviaSICC('formulario', null, null, 'N');
  }  
}

function okAceptar() {
           
  eval('formulario').oculto = 'S';
  set('formulario.ordenPagina', armarListaPag());   
  set('formulario.conectorAction', 'LPMantenimientoOrdenAnaqueles');
  set('formulario.accion', 'guardarAnaquelPaginaAceptar');
  enviaSICC('formulario', null, null, 'N');  
}

function retornarDetalleSubLinea(detalleSubLinea) {

  var retorno = new Array();
  retorno[0] = detalleSubLinea;
   
  returnValue = retorno;
  close();
  
}

function focalizaNroOrden() {
   eval("listado1.preparaCamposDR()");
   focaliza('frm'+'listado1'+'.'+'txtNroOrden'+'_0',''); 
}



function yaExisteUnOrdenAnaqPorDef(descCD, descMapaCD, descMapaZona, descMapaAnaq) {
         eval("formulario").oculto= "N";
         var objParametros = new Object();
         objParametros.CD = descCD;
         objParametros.MapaCD = descMapaCD;
         objParametros.MapaZona = descMapaZona;
         objParametros.MapaAnaquel = descMapaAnaq;
         
    GestionarMensaje('APEUI060', objParametros); // Antes era '2580' (casi igual pero no parametrizado)
         btnProxy(1, '1');
         return;
}

function noExisteUnOrdenAnaqDefault() {
         GestionarMensaje('APEUI059');
         btnProxy(1, '1');
         return;
}

function noHayAnaqSinExpand(){
         eval("formulario").oculto= "N";
    GestionarMensaje('2581');
         return;
}


function ocultarLista(){
         DrdEnsanchaConMargenDcho('listado1',12);
         document.all["Cplistado1"].style.visibility='hidden';
         document.all["CpLin1listado1"].style.visibility='hidden';
         document.all["CpLin2listado1"].style.visibility='hidden';
         document.all["CpLin3listado1"].style.visibility='hidden';
         document.all["CpLin4listado1"].style.visibility='hidden';
         focaliza('formulario.cbCentroDistribucion');
         eval (ON_RSZ);  
}                                                              


function mostrarCapaCabecera() {
         document.all["capa1"].style.visibility= "visible";
}


function fVolver() {
    close();
}

/*
// Recorro los combos para ver que no se haya seleccionado el mismo valor
// en otro.
function onChangeComboNAnaquel(fila) {
         /* // [Inicio] Eliminado BELC400000521 - eiraola 22/06/2007 - por problema de performance
         //recorro los combos para ver que no se haya seleccionado el mismo valor
         //en otro
         var codigos = listado1.codigos();

         //el dato que selecciono en el combo que cambio
         cambioA = listado1.extraeDato(fila, 0);
         //alert("cambioA: " + cambioA);
         for(var i=0; i<codigos.length; i++){
                  codigo = codigos[i];
                  //alert("codigo: " + codigo);
                  combo = listado1.extraeDato(codigo, 0);
                  //alert("combo: " + combo);
                  if ((fila!=codigo) && (combo!=0)) //salteo la linea en la q' estoy parado de la lista/no me interesa si cambio a blanco
                  {
             if (cambioA == combo)
             {
                                    GestionarMensaje('2582');
                   eval("listado1.preparaCamposDR()");
                                     focaliza('frmlistado1.comboNAnaquel_' + fila);

                                     //var comboAnaq = document.getElementById('frmlistado1.comboNAnaquel_' + fila);
                                     //comboAnaq.selectedIndex = 0;
                                     //listado1.tiposCol[0][2].selectedIndex = 0
                                     //eval('frmlistado1.comboNAnaquel_' + fila).selectedIndex = 0;
                                     //eval(('frmlistado1.comboNAnaquel_' + fila).selectedIndex = 0);

                                     //document.all['comboNAnaquel'][0].selectedIndex = 0;

                                     //alert("peteeeeeeeeeeeeeeeeeeeeeeee: " + document.getElementById('comboNAnaquel'+'_' + fila).options[document.getElementById('comboNAnaquel'+'_' + fila).selectedIndex].text);

                                     document.getElementById('comboNAnaquel'+'_' + fila).selectedIndex = 0;


                   return;
             }   
                  }
         }
         
         // [Inicio] Agregado BELC400000521 - eiraola 22/06/2007
         // El dato que selecciono en el combo que cambio

         var cambioA = listado1.extraeDato(fila, 0);
  
         if (cambioA != "") { // Solo me interesa validar si cambio a distinto de blanco

    var cantFilas = listado1.datos.length;
    
    for (var i = 0; i < cantFilas; i++) {
      if (cambioA == listado1.datos[i][1] && i != fila) { // Salteo la linea en la q' estoy parado de la lista
         GestionarMensaje('2582');
         eval("listado1.preparaCamposDR()");
         focaliza('frmlistado1.comboNAnaquel_' + fila);
         document.getElementById('comboNAnaquel'+'_' + fila).selectedIndex = 0;
         return;
      }
    }
    // [Fin] Agregado BELC400000521 - eiraola 22/06/2007
  }
}
*/

function bntDetalleAnaqueles() {
         //recorro los combos para impedir algun blanco seleccionado en ellos  
         var codigos = listado1.codigos();
         for(var i=0; i<codigos.length; i++){
                  codigo = codigos[i];
                  combo = listado1.extraeDato(codigo, 0);
    
                  if (combo != "") { 
         anaquel = combo.split("-");
         
         if(anaquel[1]=="1"){
             indAnaqExp = var_SI;
             anaquelDest = anaquel[2];
         } else {
             indAnaqExp = var_NO;
             anaquelDest = "";
         }
    
         listado1.insertaDato(codigo,2,indAnaqExp,true);
         listado1.insertaDato(codigo,3,anaquelDest,true);
    
    } else {
      listado1.insertaDato(codigo,2,"",true);
      listado1.insertaDato(codigo,3,"",true);
    }
  }
  
  listado1.repinta();  
}


function armarListaPag(){                                                                            
      var codigos = listado1.codigos();
      var cadena = "";
      
      for (var i=0; i<codigos.length ; i++){
         if( i!= 0)
           cadena = cadena + "|";

                    codigo = codigos[i];
         orden = listado1.extraeDato(codigo, 1);
         cadena = cadena + orden;
      }  
      return cadena;
}

function focalizaListaTab(FILAEVENTO) {
    if(FILAEVENTO == (listado1.datos.length - 1)) {
      setTimeout("focalizaBotonHTML_XY('DetalleAnaqueles')",10); 
    }
}

function focalizaListaShTab(FILAEVENTO) {
    if(FILAEVENTO == 0){    
         setTimeout("focalizaBotonHTML_XY('Aceptar')",10);  
    }         
}

function focalizaTab() {
   eval("listado1.preparaCamposDR()");
   focaliza('frm'+'listado1'+'.'+'comboNAnaquel'+'_0',''); 
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