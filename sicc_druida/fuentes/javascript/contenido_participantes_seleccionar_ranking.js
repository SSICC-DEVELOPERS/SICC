function fLimpiar() {
	onLoadPag();
  }

  function onLoadPag()   {    
 
    configurarMenuSecundario('formulario');
    DrdEnsanchaConMargenDcho('listado1',26);
    document.all["Cplistado1"].style.visibility='';
    document.all["CpLin1listado1"].style.visibility='';
    document.all["CpLin2listado1"].style.visibility='';
    document.all["CpLin3listado1"].style.visibility='';
    document.all["CpLin4listado1"].style.visibility='';
    document.all["separaDiv"].style.visibility='hidden';
    document.all["primera1Div"].style.visibility='hidden';
    document.all["ret1Div"].style.visibility='hidden';
    document.all["ava1Div"].style.visibility='hidden';
    document.all["btnExcluirDiv"].style.visibility='';
    document.all["btnExcluirTodosDiv"].style.visibility='';
    
    eval (ON_RSZ);
    
    
    btnProxy(1, 0);
    btnProxy(3, 0);
    btnProxy(4, 0);
    btnProxy(5, 0);
    btnProxy(7, 0);
	btnProxy(8, 0);
	btnProxy(9, 0);
     
    if (get('formulario.opcionMenu') == 'Consultar Concurso Ranking')  {
	        DrdEnsanchaConMargenDcho('listado2',26);
            document.all["Cplistado2"].style.visibility='';
            document.all["CpLin1listado2"].style.visibility='';
            document.all["CpLin2listado2"].style.visibility='';
            document.all["CpLin3listado2"].style.visibility='';
            document.all["CpLin4listado2"].style.visibility='';
            document.all["separa2Div"].style.visibility='hidden';
            document.all["primera2Div"].style.visibility='hidden';
            document.all["ret2Div"].style.visibility='hidden';
            document.all["ava2Div"].style.visibility='hidden';
            document.all["btnAnadirDiv"].style.visibility='';
            document.all["btnAnadirTodosDiv"].style.visibility='';
            deshabilitarHabilitarBoton('botonContenido','btnExcluir','D');
            deshabilitarHabilitarBoton('botonContenido','btnExcluirTodos','D');
            
            deshabilitarHabilitarBoton('botonContenido','btnAnadir','D');
            deshabilitarHabilitarBoton('botonContenido','btnAnadirTodos','D');
            
            eval (ON_RSZ);
            document.getElementById("btnAceptar").disabled = false;	 
            
       
     }
     else{
             DrdEnsanchaConMargenDcho('listado2',26);
             document.all["Cplistado2"].style.visibility='visible';
             document.all["CpLin1listado2"].style.visibility='visible';
             document.all["CpLin2listado2"].style.visibility='visible';
             document.all["CpLin3listado2"].style.visibility='visible';
             document.all["CpLin4listado2"].style.visibility='visible';
             document.all["separa2Div"].style.visibility='hidden';
             document.all["primera2Div"].style.visibility='hidden';
             document.all["ret2Div"].style.visibility='hidden';
             document.all["ava2Div"].style.visibility='hidden';
             document.all["btnAnadirDiv"].style.visibility='visible';
             document.all["btnAnadirTodosDiv"].style.visibility='visible';
             deshabilitarHabilitarBoton('botonContenido','btnExcluir','A');
             deshabilitarHabilitarBoton('botonContenido','btnExcluirTodos','A');
             eval (ON_RSZ);   
            
            focalizaBotonHTML('botonContenido','btnExcluir');        
       
    }
        
    
    if (get('formulario.lstClasificacionParticipantesConsultoras') != null){
                  cargaLista(listado1,get('formulario.lstClasificacionParticipantesConsultoras'));
    }    
    
    if (get('formulario.lstClasificacionParticipantes') != null)
                  cargaLista(listado2, get('formulario.lstClasificacionParticipantes'));
      
    
            
    if (listado1.datos.length > 0){        
		set('formulario.hidUltimoElementoEnLaLista', listado2.datos.length);
    }
    
    actualizarDatosListadoDos(listado2, get('formulario.lstClasificacionParticipantesConsultoras'), get('formulario.lstClasificacionParticipantes'));
      
} 



    function actualizarDatosListadoDos(listado2, listaItems, listaTotalDos){
    
        var items = listaItems;
        var total = listaTotalDos;
        var fila = listaItems.split('$');
        var datoTotal =listaTotalDos.split('$');
        var a = 0;
         
        for(i=0;i<fila.length;i++){
        
        
			if (fila[i] != ''){
            
            
				var newRow = new Array();
				newRow = fila[i].split("|");
                
                
              for(b=0;b<datoTotal.length;b++){
              
                
                
                if (datoTotal[i] !=""){
                
                
                    
                    var datoLista2 = new Array();
                    datoLista2 =datoTotal[b].split("|");
                                       
                    if (datoLista2[0] == newRow[2]){
                          // eliminar una o varias filas del listado
                          // eliminar (fila,cantidad) 
                        listado2.eliminar(0,1);  
                    }
                
                
                }//--datoTotal[i] !="")
               
               } 
                
			}
        }   
        
        
    
	}//--fin de la funcion de actualizarDatosListados 


   function cargaLista(lista, items)
   {
        if (items != null)
        {
            actualizaListado(lista, items);
        }
   }
   
 function accionExcluir(){
    excluyeEltosSel(listado1, listado2);
 }
   
 function accionExcluirTodos(){
      excluyeTodosLosEltos(listado1, listado2);
 }
   
 function accionAniadir(){
    aniadeEltosSel(listado2, listado1);
  }
   
 function accionAniadirTodos(){
     aniadeTodosLosEltos(listado2, listado1);
 }
   
 function accionAceptar(){
     //MODIFICADO SEGUN INCIDENCIA 20727
	 var datosGerentes = listado1.datos;

	 if(datosGerentes.length>0) {
		 var clasifParticConsul = listado1Tostring();
	     var clasifPartic = listado2Tostring();

		 var arr = new Array();
	     arr[0] = clasifParticConsul;
		 arr[1] = clasifPartic;
	     returnValue = arr;
		 close();
	 }
	 else {
		GestionarMensaje('INC035');
        return false;
	 }	      
}
   
   
//-------------------------------- Funciones auxiliares ---------------------------

function actualizaListado(lista, listaItems){
	var fila = listaItems.split('$');
	
  for(i=0;i<fila.length;i++){
			if (fila[i] != ''){
				var newRow = new Array();
				newRow = fila[i].split("|");
                
				lista.insertar(newRow);
			}
	}   
}
    
 function listado1Tostring(){
        
  listado1.actualizaDat();
  var codigo = listado1.codigos();
  var total = "";
   
   for(var a = 0; a < codigo.length ; a++){
        var toAdd = "";
        toAdd = "oid:"+ codigo[a];
    
        if(listado1.extraeDato(codigo[a], 0)!= null && listado1.extraeDato(codigo[a], 0)!=""){
            toAdd = toAdd + "|" + "oPc:" + listado1.extraeDato(codigo[a], 0);    //oidParticipanteConsultora 
        }
        
        if(listado1.extraeDato(codigo[a], 1)!= null && listado1.extraeDato(codigo[a], 1)!=""){
            toAdd = toAdd + "|" + "oPar:" + listado1.extraeDato(codigo[a], 1);    //oidParticipante
        }
        
        if(listado1.extraeDato(codigo[a], 2)!= null && listado1.extraeDato(codigo[a], 2)!=""){
            toAdd = toAdd + "|" + "desc:" + listado1.extraeDato(codigo[a], 2);    //Descripcion 
        }    
        
        total = total + "$" + toAdd;
		}	
		return total;
 }  
  
    
 function listado2Tostring(){
     listado2.actualizaDat();
     var codigo = listado2.codigos();
     var total = "";
  
     for(var a = 0; a < codigo.length ; a++){
          var toAdd = "";
          toAdd = "oPar:"+ codigo[a];

          if(listado2.extraeDato(codigo[a], 0)!= null && listado2.extraeDato(codigo[a], 0)!=""){
                toAdd = toAdd + "|" + "desc:" + listado2.extraeDato(codigo[a], 0);    //Descripcion
          } 
         
          total = total + "$" + toAdd;
		}	
		return total;
}
    

function aniadeEltosSel(listaOr, listaDe){
      listaOr.actualizaDat();
      listaDe.actualizaDat();
      var cantElementosL1 = listaOr.codSeleccionados();		

      if (cantElementosL1.length == 0){
            GestionarMensaje("4", null, null, null);
            return;
      }
        
      var codigo = listaOr.codSeleccionados();
		  var total = "";
      lon = codigo.length;
        
		  for(var a = 0; a < lon ; a++){
            if (isInListado1(codigo[a], listaDe) == 0){
                var posi = parseInt(get('formulario.hidUltimoElementoEnLaLista'), 10);
                var iPos = listaDe.generaCodigo( posi );
                
                toAdd = iPos + "|" + null;
                toAdd = toAdd + "|" + codigo[a]  + "|" + listaOr.extraeDato(codigo[a], 0);
                
                var newRow = new Array();
                newRow = toAdd.split("|");
                listaDe.insertar(newRow);
                
                set('formulario.hidUltimoElementoEnLaLista', iPos);
            }
        }
        listaOr.eliminarSelecc();
 }
 
 /*function aniadeTodosLosEltos (listaOr, listaDe){

    listaOr.actualizaDat();
    listaDe.actualizaDat();
    var codigo = listaOr.codigos();
    lon =  codigo.length;
        
		for(var a = 0; a < lon ; a++){
           if (isInListado1(codigo[a], listaDe) == 0){
                
                var posi = parseInt(get('formulario.hidUltimoElementoEnLaLista'), 10);
                var iPos = listaDe.generaCodigo(posi);
            
                toAdd = iPos + "|" + null  + "|" + codigo[a]  + "|" + listaOr.extraeDato(codigo[a], 0);
                var newRow = new Array();
                newRow = toAdd.split("|");
                listaDe.insertar(newRow);
                set('formulario.hidUltimoElementoEnLaLista', iPos);
            }
    }
    var nuevos_datos = new Array();
    listaOr.setDatos(nuevos_datos);
}*/



    function aniadeTodosLosEltos(listaOr, listaDe){


         listaOr.actualizaDat();
         listaDe.actualizaDat();
         var codigo = listaOr.codigos();
         lon =  codigo.length;
         
                  for(var a = 0; a < lon ; a++){
             if (isInListado1(codigo[a], listaDe) == 0) 
             {// no esta en la lista
             
                  var posi = parseInt(get('formulario.hidUltimoElementoEnLaLista'), 10);
                  var iPos = listaDe.generaCodigo( posi );
             
                  toAdd = iPos + "|" + null  + "|" + codigo[a]  + "|" + listaOr.extraeDato(codigo[a], 0);
                  var newRow = new Array();
                  newRow = toAdd.split("|");
                  listaDe.insertar(newRow);
                  set('formulario.hidUltimoElementoEnLaLista', iPos);
             }
         }
         var nuevos_datos = new Array();
         listaOr.setDatos(nuevos_datos);
   }



 function isInListado1(item, listaDestino){
   
    listaDestino.actualizaDat();
    var codListD = listaDestino.codigos();
    var lonLisD = listaDestino.datos.length;
        
    var estaEnLista = 0;
        
    for(var b = 0; b < lonLisD ; b++){
    
      var vDestino = listaDestino.extraeDato(codListD[b], 1);
      if (item == vDestino){
          estaEnLista = 1;    
      }
    }
      return estaEnLista;
 }
   
 function fVolver(){
      window.close();
 }
    

  function excluyeEltosSel(listaOr, listaDe){
      listaOr.actualizaDat();
      listaDe.actualizaDat();
      var cantElementosL1 = listaOr.codSeleccionados();		
        
      if (cantElementosL1.length == 0){
          GestionarMensaje("4", null, null, null);
          return;
      }
        
      var codigo = listaOr.codSeleccionados();
		  var total = "";
      lon =  codigo.length;
      
      for(var a = 0; a < lon ; a++){
            var item = listaOr.extraeDato(codigo[a], 1); 
            if (isInListado2(item, listaDe) == 0){
                toAdd = listaOr.extraeDato(codigo[a], 1);
                toAdd = toAdd + "|" + listaOr.extraeDato(codigo[a], 2);
                var newRow = new Array();
                newRow = toAdd.split("|");
                listaDe.insertar(newRow);
            }
        } 
      listaOr.eliminarSelecc();
  }
   
 function excluyeTodosLosEltos(listaOr, listaDe){
  
        listaOr.actualizaDat();
        listaDe.actualizaDat();
        var codigo = listaOr.codigos();
        lon =  codigo.length;
        
        for(var a = 0; a < lon ; a++){
            
            var item = listaOr.extraeDato(codigo[a], 1); 
            if (isInListado2(item, listaDe) == 0){
                toAdd = listaOr.extraeDato(codigo[a], 1);
                toAdd = toAdd + "|" + listaOr.extraeDato(codigo[a], 2);
                var newRow = new Array();
                newRow = toAdd.split("|");
                listaDe.insertar(newRow);
            }
        } 
        var nuevos_datos = new Array();
        listaOr.setDatos(nuevos_datos);
 }
   
 function isInListado2(item, listaDestino){
    listaDestino.actualizaDat();
    var codListD = listaDestino.codigos();
    var lonLisD = listaDestino.datos.length;
        
    var estaEnLista = 0;
        
    for(var b = 0; b < lonLisD ; b++){
        if (item == codListD[b]){
              estaEnLista = 1;    
        }
    }
        
    return estaEnLista;
  }

