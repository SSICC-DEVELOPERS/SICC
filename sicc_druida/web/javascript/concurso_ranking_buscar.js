function onLoadPag(){          
    
      configurarMenuSecundario("formulario");      
      focaliza("formulario.cbNumConcurso");
      ocultarLista();
      if (get("formulario.errDescripcion")!='') {
		     var wnd = fMostrarMensajeError(get("formulario.errCodigo"), get("formulario.errDescripcion"));
			 ocultarLista();
	  }		

      DrdEnsanchaConMargenDcho('listado1',12);   
      eval (ON_RSZ);  
      btnProxy(1,0);
      btnProxy(2,0);      
      btnProxy(3,1);
      btnProxy(7,1);
      btnProxy(8,1);
      btnProxy(9,1);

      
      
      if (get("formulario.opcionMenu") == "Consultar Concurso Ranking"){
          focaliza("formulario.cbNumConcurso");
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
      
  }
  
  
  function mostrarLista(){
      document.all["Cplistado1"].style.visibility=''; 
      document.all["CpLin1listado1"].style.visibility='';  
      document.all["CpLin2listado1"].style.visibility=''; 
      document.all["CpLin3listado1"].style.visibility='';
      document.all["CpLin4listado1"].style.visibility='';  
      
      document.all["primera1Div"].style.visibility=''; 
      document.all["ret1Div"].style.visibility='';
      document.all["ava1Div"].style.visibility='';  
      document.all["separaDiv"].style.visibility=''; 
      
           
      if( get('formulario.opcionMenu') == 'Modificar Concurso Ranking' ){
		 document.all["ModificarDiv"].style.visibility='';
	     document.all["DetalleDiv"].style.visibility='hidden';
       } 
       
	  if( get('formulario.opcionMenu') == 'Consultar Concurso Ranking' ){
        document.all["ModificarDiv"].style.visibility='hidden';
	    document.all["DetalleDiv"].style.visibility='';      
      }       
  }
  
  function fLimpiar(){
  
    set("formulario.cbNumConcurso", "");
    set("formulario.textNombreConcurso", "");
    set("formulario.cbMarca", "");
    set("formulario.cbCanal", "");
    focaliza("formulario.cbNumConcurso");
  
  }
  

  function accionBuscar(){

     var arr = new Array();
     
     var pais = get("formulario.hPais");
     var idioma = get("formulario.hIdioma");
     ocultarLista();
     
     arr[arr.length] = new Array("oidPais", pais);
	   arr[arr.length] = new Array("oidIdioma", idioma);
     
     arr[arr.length] = new Array("nroConcurso", get("formulario.cbNumConcurso")+"");  
     arr[arr.length] = new Array("nombreConcurso", get("formulario.textNombreConcurso")+""); 
     arr[arr.length] = new Array("oidMarca", get("formulario.cbMarca")+"");  
     arr[arr.length] = new Array("oidCanal", get("formulario.cbCanal")+"");
     
     if(get('formulario.opcionMenu') == 'Modificar Concurso Ranking' ){
        arr[arr.length] = new Array("indActivo", "false");    
     } else {
        arr[arr.length] = new Array("indActivo", "true"); // Se visualizan todos los concursos activos e inactivos
     }
     
     arr[arr.length] = new Array("tamanioPagina", 10);
     arr[arr.length] = new Array("indicadorSituacion", 0);
     configurarPaginado(mipgndo,"INCBuscarConcursosRanking","ConectorBuscarConcursosRanking","es.indra.sicc.dtos.inc.DTOBuscarConcursos",arr);

   }
  
  
   function muestraLista(ultima, rowset) {

       var tamanio = rowset.length;

       if (tamanio > 0) {
           mostrarLista();
		   mipgndo.lista.maxSel = 1;
		   return true;
		 } else {
			ocultarLista();
			return false;
		 }
    } 
  
  
  
    function focalizaShTab(){ 
    
		if(document.all["Cplistado1"].style.visibility=='hidden'){
			focalizaBotonHTML('botonContenido','btnBuscar');
		}else{
		    
            if(get('formulario.opcionMenu') == 'Modificar Concurso Ranking' ){
				focalizaBotonHTML_XY('Modificar');
			}else{
				focalizaBotonHTML_XY('Detalle');
			}

		}
    }


  function accionDetalle(){  
    
	valorSeteado = listado1.codSeleccionados();
	codigos = listado1.codSeleccionados();     
    var datos  = listado1.datos;
    
    if( valorSeteado != '' ){ //2
        
        if( valorSeteado.length == 1 ){

				var obj = new Object();
				obj.seleccion = valorSeteado[0];
                
                obj.accion = ' ';
                obj.oidConcurso = listado1.codSeleccionados();
                obj.opcionMenu = get("formulario.opcionMenu");
				obj.numeroConcurso =  listado1.extraeDato(codigos,0);
                obj.version =  listado1.extraeDato(codigos,1);
                obj.descripcion =  listado1.extraeDato(codigos,2);
                obj.marca =  listado1.extraeDato(codigos,3);
                obj.canal =  listado1.extraeDato(codigos,4);
                
                var winModal = mostrarModalSICC('LPMantenerConcursosRanking','', obj, null, null);
        }else{
              GestionarMensaje('8',null,null,null);
        }
     }else{
              GestionarMensaje('4', null, null, null);      
     }       
    
    
  } //--Fin de la funcion 
  
  
  function focalizaTab(){  
		if(document.all["Cplistado1"].style.visibility=='hidden'){
			focaliza("formulario.cbNumConcurso");
		}else{
		    if(get('formulario.casoDeUso') == 'modifica' ){
				focalizaBotonHTML_XY('Modificar');
			}else{
				focalizaBotonHTML_XY('Detalle');
			}
		}
    }
  
  
    function onClickModificar(){
    
        var codigos = listado1.codSeleccionados();
        var valorSeteado = mipgndo.lista.codSeleccionados();
        var datos  = listado1.datos;
        
        
        if (listado1.numSelecc()!= 1) {
            GestionarMensaje('1022',null,null,null);
            return false;
        }
    
        if( valorSeteado.length == 1 ){

				var obj = new Object();
				obj.seleccion = valorSeteado[0];
                codigos = listado1.codSeleccionados();
                obj.accion = ' ';
                obj.oidConcurso = codigos;                
                obj.opcionMenu = get("formulario.opcionMenu");				
                
               var winModal = mostrarModalSICC('LPMantenerConcursosRanking','', obj, null, null);
               accionBuscar();
               
        }else{
             GestionarMensaje('4', null, null, null);
        }
   }  
