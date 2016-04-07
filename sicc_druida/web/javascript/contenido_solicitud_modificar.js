function onLoadPag(){       
      if(get('formulario.fin')=='S')
        fVolver();
      focaliza('formulario.txtCodVenta');
      configurarMenuSecundario("formulario");
      fMostrarMensajeError();   
      DrdEnsanchaConMargenDcho('listado1',12); 
      document.all["Cplistado1"].style.visibility=''; 
      document.all["CpLin1listado1"].style.visibility='';  
      document.all["CpLin2listado1"].style.visibility=''; 
      document.all["CpLin3listado1"].style.visibility='';
      document.all["CpLin4listado1"].style.visibility=''; 
      document.all["primera1Div"].style.visibility='hidden'; 
      document.all["ret1Div"].style.visibility='hidden';
      document.all["ava1Div"].style.visibility='hidden';  
      document.all["separa1Div"].style.visibility='hidden'; 
      eval (ON_RSZ);   
      ON_RSZ = '';
	
    }
    
    function accionAnadir(){
        if(sicc_validaciones_generales()){
            var newRow = new Array();
            var lista = listado1.datos;
            var lon = lista.length;
            var regi = lista[lon-1];
            var posi = "a" + get('formulario.secuencia');
            set('formulario.secuencia',parseInt(get('formulario.secuencia'), 10) + 1);
            
            
            if (lista.length == 0){
				newRow = [posi,"","",0,get("formulario.txtCodVenta"),"","","","",get("formulario.txtUnidadesDemandadas"),""];
			} else {
				// Por Incidencia 13198
				// Como esta ordenado de mayor a menor.
				//var regi = lista [lon-1];
				//var a = new Number (regi[3]);
				var a = new Number (0);
				for(var n=0; n < lista.length;n++ ){
					if(a < parseInt(lista[n][3],10)){
						a = new Number(lista[n][3]);
					}
				}
				newRow = [posi,"","",a+10,get("formulario.txtCodVenta"),"","","","",get("formulario.txtUnidadesDemandadas"),""];
				
			}
            listado1.insertar(newRow);
        }
    }
    
    function accionEliminar(){
      var e = get('formulario.posicionesEliminadas');
    
			var cantElementosL1 = listado1.codSeleccionados();		
			if ( cantElementosL1.length == 0){
				GestionarMensaje("4", null, null, null);
				return;
			}
      var elim = new Array();
      var sele = listado1.codSeleccionados();
      var j = 0;
       for(var i=0; i < sele.length; i++){
          if(sele[i].charAt(0) != "a")
            elim[j] = sele[i];
            j++
       }
      if(e.length > 0)
        elim = e + "," + elim;
      
      set('formulario.posicionesEliminadas',elim);
      //set('formulario.posicionesEliminadas',listado1.codSeleccionados());      
			if ( cantElementosL1.length > 0 )
				listado1.eliminarSelecc();    
    }
    
    function accionGuardar(){
         var elim = get('formulario.posicionesEliminadas'); 
         var valo = tomarValoresLista();
         
         //var valo = tomarValoresLista2();
         if(valo==0 && elim.length==0)
           var p = "nada";
         else{
           set("formulario.accion", "guardar");
           set('formulario.conectorAction','LPModificarPosiciones');
           enviaSICC("formulario",null,null,"N");
         }
    }
    
    function tomarValoresLista(){
        var arr = new Array();
        listado1.actualizaDat();
        var lista = listado1.datos;
        
        var x = 0
        for(var i = 0; i < lista.length; i++){
          var regis = lista[i]; 
          arr[x] = regis[0];
          x++;
          

          // este estaba
          if(regis[4]=="" || regis[4]==undefined)
            arr[x] = "undef";
          else
            arr[x] = regis[4];
          x++;
          
          
          if(regis[9]==undefined)
            arr[x] = "undef";
          else
            arr[x] = regis[9];
          x++; 
          
          if(regis[3]==undefined)
            arr[x] = "undef";
          else
            arr[x] = regis[3];
          x++; 
          
          
        }
       set('formulario.valores',arr);
	   
	    listado1.datos = new Array();
        return arr.length;
    }

	 function tomarValoresLista2(){
        var arr ="";
        var lista = listado1.datos;
        for(var i = 0; i < lista.length; i++){
          var regis = lista[i]; 
          arr = arr + regis[0] + ",";
			 if(regis[1]!="")
	          arr = arr + regis[1] + ",";
			 else arr = arr + "undef,";
			 if(regis[2]!="")
		       arr = arr + regis[2] + ",";
			 else arr = arr + "undef,";
			 if(regis[3]!="")
			    arr = arr + regis[3] + ",";
			 else arr = arr + "undef,";
			 if(regis[4]!="")
				 arr = arr + regis[4] + ",";
			 else arr = arr + "undef,";
			 if(regis[5]!="")
	          arr = arr + regis[5] + ",";
			 else arr = arr + "undef,";
			 if(regis[6]!="")
		       arr = arr + regis[6] + ",";
			 else arr = arr + "undef,";
			 if(regis[7]!="")
			    arr = arr + regis[7] + ",";
			 else arr = arr + "undef,";
			 if(regis[8]!="")
				 arr = arr + regis[8] + ",";
			 else arr = arr + "undef,";
			 //+ regis[1] + "," +regis[2] + "," +regis[3] + "," +regis[4] + "," +regis[5] + "," +regis[6] + "," +regis[7] + "," +regis[8] + ",";
          if(regis[9]==undefined)  arr = arr + "undef";
						else  arr = arr + regis[9];
			arr = arr + "|";
        }
			//alert(arr);
		  set('formulario.valores',arr);
        return arr.length;
    }
    
    function fGuardar(){
        accionGuardar();
    }
    
    function fVolver(){
      window.close();
    }