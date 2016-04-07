function onLoadPag(){
         configurarMenuSecundario("formulario");
         DrdEnsanchaConMargenDcho('listado1',12);
         document.all["Cplistado1"].style.visibility = '';
         document.all["CpLin1listado1"].style.visibility = '';
         document.all["CpLin2listado1"].style.visibility = '';
         document.all["CpLin3listado1"].style.visibility = '';
         document.all["CpLin4listado1"].style.visibility = '';
         document.all["separaDiv"].style.visibility = '';

         eval (ON_RSZ);  
    focaliza("formulario.cbEnviarA");
    
    if (get('formulario.errDescripcion')!='') {
                  var wnd = fMostrarMensajeError(get('formulario.errCodigo'), 
                  get('formulario.errDescripcion'));
         }    

         accion("formulario.txtCodMensaje", ".disabled=true");         
    var errorINC =  get("formulario.errCarga");
         
    if(errorINC == 'INC-0015'){
             GestionarMensaje('INC-0015',null,null,null);	
         focaliza("formulario.cbEnviarA");
    }
}//--Fin de onload
  
function fLimpiar(){
    set("formulario.cbEnviarA", "");
    set("formulario.txtUnidades", "");
    set("formulario.cbMotivo", "");
    set("formulario.atxtObservaciones", "");
    set("formulario.ckDespachaArticulo", "");
    set("formulario.ckComunicacion", "");
    set("formulario.txtCodMensaje", "");
    accion("formulario.txtCodMensaje", ".disabled=true");        
         var datosNuevos = new Array();
         listado1.actualizaDat();
         listado1.setDatos(datosNuevos);
         listado1.repintaDat();
    focaliza("formulario.cbEnviarA");
} //--fin fLimpiar

function onChangechkComunicacion(){
         var comunicacion = get("formulario.ckComunicacion");
         
    if (comunicacion == "S"){
                  set("formulario.txtCodMensaje", "INC07");         
                  accion("formulario.txtCodMensaje", ".disabled=false");
    }
         else{
                  set("formulario.txtCodMensaje", ""); 
                  accion("formulario.txtCodMensaje", ".disabled=true");
    }   
}//-- fin onChangechkComunicacion
  
function onChangecbEnviarA(){    
         set("formulario.clientesSeleccionados", "");
    set("formulario.nroConcursoSeleccionados", "");
    set("formulario.clientesFicheroSeleccionados", "");
         
    var envia = get("formulario.cbEnviarA");      
    var fichero = get("formulario.constanteCapturaFichero");         
    var cliente = get("formulario.constanteClientes");         
    var concurso = get("formulario.constanteNumeroConcurso");
         
    if (envia == concurso){
                  var obj = new Object();
         obj.accion = "Concurso";             
             
                  var concursoModal =  mostrarModalSICC('LPAsignarPremiosConsuelo','Concurso',obj,null,510);
             
         if (concursoModal != null && concursoModal != undefined) {                 
                           set("formulario.nroConcursoSeleccionados", concursoModal);
         }
    }
         
         if (envia == cliente){
                  var obj = new Object();
         obj.accion = "Cliente";             
             
                  var clienteModal =  mostrarModalSICC('LPAsignarPremiosConsuelo','Cliente',obj,null,510);         
             
         if (clienteModal != null && clienteModal != undefined) {
                           clienteModal = clienteModal;                  
             set("formulario.clientesSeleccionados", clienteModal);
         }             
     }
        
          if (envia == fichero){
                   var obj = new Object();
          obj.accion = "Fichero";             
             
                   var ficheroModal = mostrarModalSICC('LPAsignarPremiosConsuelo','Fichero',obj,null,510);
             
          if (ficheroModal != null && ficheroModal != undefined) {
                            set("formulario.clientesFicheroSeleccionados", ficheroModal);
          }            
     }
}//--fin onChangecbEnviarA
    
function fGuardar(){                 
         if(sicc_validaciones_generales()){
                  var concurso = get("formulario.nroConcursoSeleccionados");
    var clientes = get("formulario.clientesSeleccionados");  
    var fichero = get("formulario.clientesFicheroSeleccionados");
                  var comunicacion = get("formulario.ckComunicacion");  
    var txtCodMensaje = get("formulario.txtCodMensaje");

                  if(listado1.datos.length<1) {
                           GestionarMensaje('INC061', null, null, null);                  
                           return;
                  }
           
    if ((concurso =="") && (clientes =="") && (fichero =="") ){
                      GestionarMensaje('3333', null, null, null);             
                           return;
    }else{
                      if ((comunicacion == "S") && (txtCodMensaje =="")){
           GestionarMensaje('1584', null, null, null);                  
           return;
         } else{
           //var desCombo = get("formulario.cbPremiosConsuelo", "T");
           var desCombo = obtenerCodigosProductos();
           desCombo = desCombo + "|"; 
           //alert("desCombo " + desCombo);
           set("formulario.desPremioConsuelo", desCombo);                                    
  
           var oidsProductos = obtenerOidsProductos();
           //alert("oidsProductos " + oidsProductos);
           set("formulario.premiosConsuelo", oidsProductos);     
           
           set("formulario.premiosDetalles", obtenerDetalles());            

           eval("formulario").oculto= "S";
           set("formulario.accion","guardar");   
           set("formulario.conectorAction","LPAsignarPremiosConsuelo");                                                                           
           enviaSICC('formulario', '', '', 'N');        
                           }
         }           
         } //--sicc_validaciones_generales
}

function obtenerDetalles(){    
      var codigos = listado1.codigos();
      var cadena = "";
      
      for (var i=0; i<codigos.length ; i++){
           if( i!= 0)
             cadena = cadena + "|";
             
           cadena = cadena + codigos[i] + "&";  

           detalle = listado1.extraeDato(codigos[i], 2);
           cadena = cadena + detalle;           
      }
      
      //alert(cadena);
      return cadena;
}

function obtenerCodigosProductos() {
         var codigos = "";
         var datos = listado1.datos;

         for(var i=0; i<datos.length; i++) {
                  if(i==0) {
                           codigos = datos[i][1];
                  }
                  else {
                           codigos = codigos + "," + datos[i][1];
                  }
         }

         return codigos;
}

function obtenerOidsProductos() {
         var oids = "";
         var datos = listado1.datos;

         for(var i=0; i<datos.length; i++) {
                  if(i==0) {
                           oids = datos[i][0];
                  }
                  else {
                           oids = oids + "|" + datos[i][0];
                  }
         }

         return oids;
}    
    
function errorCantNoProcesados(cantNoProcesados){         
         GestionarMensaje('INC0039', cantNoProcesados, null, null); 
    fLimpiar();
}
    
function borrarTodo(){
         fLimpiar();
}


function onClickBuscar() {      
         var datos = new Object();     
  datos.esMultiple = true;    
  
  var objParams = new Object();
  var strAccion = "busqueda";
  objParams.accion=strAccion;
  if(datos){
      objParams.datos = datos;
  }
   
  var salida = mostrarModalSICC("LPAsignarPremiosConsuelo",strAccion,objParams, '790', '700');

         if(salida!=undefined) {
                  if(salida.length>0) {
                           listado1.actualizaDat();
                           var datos = listado1.datos;

                           for(var i=0; i<salida.length;i++) {
                                    var fila = new Array();
                                    fila[0] = salida[i][0];
                                    fila[1] = salida[i][1];
                                    fila[2] = salida[i][2];
         fila[3] = salida[i][3];
         
                                    var existe = "false";
         
                                    for(var j=0; j<datos.length; j++) {
                                             if(datos[j][0] == salida[i][0]) {
                                                      existe = "true";
                                             }
                                    }
         
                                    if(existe == "false") {
                                             datos[datos.length] = fila;
                                             listado1.setDatos(datos);
                                    }
                           }

                           listado1.repintaDat();	
                  }			
         }	
  
  //alert(listado1.datos);
}

function onClickEliminar() {
    if (listado1.numSelecc() > 0) {
                  var array = listado1.codSeleccionados();
                  var datos = listado1.datos;
                  var datosNuevos = new Array();
                  var f = 0;

                  for(var i=0; i<datos.length; i++) {
                           var existe = "false";

                           for(var j=0; j<array.length; j++) {
                                    if(datos[i][0]==array[j]) {
                                             existe = "true";
                                    }
                           }

                           if(existe == "false") {
                                    datosNuevos[f] = datos[i];
                                    f++;
                           }
                  }

                  listado1.actualizaDat();
                  listado1.setDatos(datosNuevos);
                  listado1.repintaDat();
         }
    else
             GestionarMensaje('4');
}

