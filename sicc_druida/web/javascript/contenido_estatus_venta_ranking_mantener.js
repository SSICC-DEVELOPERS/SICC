function onLoadPag(){  

        DrdEnsanchaConMargenDcho('listado1',12);
        document.all["Cplistado1"].style.visibility='';
        document.all["CpLin1listado1"].style.visibility='';
        document.all["CpLin2listado1"].style.visibility='';
        document.all["CpLin3listado1"].style.visibility='';
        document.all["CpLin4listado1"].style.visibility='';
        document.all["separaDiv"].style.visibility='hidden';
        document.all["primera1Div"].style.visibility='hidden';
        document.all["ret1Div"].style.visibility='hidden';
        document.all["ava1Div"].style.visibility='hidden';
        document.all["btnAceptar1Div"].style.visibility='';
        eval (ON_RSZ);  
        
        
        configurarMenuSecundario('formulario');
        btnProxy(1,'0');
        btnProxy(2,'1');
        
        if (get("formulario.opcionMenu") == "Modificar Concurso Ranking"){
          
            btnProxy(7, 0);
			btnProxy(8, 0);
			btnProxy(9, 0);
        }
                
        if ( get('formulario.hidLstEstatusVta')!= null ) {
            var listaItems = get('formulario.hidLstEstatusVta');
        }        
        actualizaListado(listaItems);            
        
        if ( get('formulario.opcionMenu') == 'Consultar Concurso Ranking') {
            deshabilitarHabilitarBoton('botonContenido','btnAnadir','D');            
			document.getElementById("btnAceptar1").disabled = true;	        
			document.getElementById("cbEstatusVentaMAE").disabled = true;	        
			document.getElementById("cbPeriodoDesde").disabled = true;	        
			document.getElementById("cbPeriodoHasta").disabled = true;	  
			
			btnProxy(4, 0);			
			btnProxy(5, 0);
			btnProxy(7, 0);
			btnProxy(8, 0);
			btnProxy(9, 0);
		}
		else {
			focaliza('formulario.cbEstatusVentaMAE');
		}
	}
   
   function accionAniadir()
   {
        var vOidEstatusVtaMae = get('formulario.cbEstatusVentaMAE','V');       
        var vOidPeridoD  = get('formulario.cbPeriodoDesde','V');
        var vOidPeridoH  = get('formulario.cbPeriodoHasta','V');        
        var vEstatusVtaMae = get('formulario.cbEstatusVentaMAE','T');
        var vPeridoD  = get('formulario.cbPeriodoDesde','T');
        var vPeridoH  = get('formulario.cbPeriodoHasta','T');
        
        if(sicc_validaciones_generales("g1")){
        
            var posi = parseInt(get('formulario.hidUltimoElementoEnLaLista'), 10);
            var codigo = listado1.generaCodigo( posi );
            var datos = codigo + "|" + null ;  
            
            datos = datos + "|" + vOidEstatusVtaMae + "|" + vOidPeridoD + "|" + vOidPeridoH;
           
            datos = datos + "|" + vEstatusVtaMae + "|" + vPeridoD + "|" + vPeridoH;
          
            if (!existeFila(datos))
            {
                var newRow = new Array();
                newRow = datos.split("|");
                
                listado1.insertar(newRow);                
                set('formulario.hidUltimoElementoEnLaLista', codigo);
                
                seteaCombosAniadir();
   
             }else{             
             }                        
        }    
    }   
   
   function accionAceptar()
   {
        var datosAplanados = listado1Tostring();   
        var arr = new Array();
        arr[0] = datosAplanados;
        arr[1] = listado1.datos;        
        
        set("formulario.hidLstEstatusVta", arr); 
        
        returnValue = arr;        
        close();
   }
   
   function fBorrar()
   {
        accionEliminar();
   }
   
   function actualizaListado(listaItems){
        //listaItems = get('formulario.hidLstEstatusVta');
		var fila = listaItems.split('$');
		for(i=0;i<fila.length;i++){
			if (fila[i] != ''){
                //fila[i] = i + '|' + fila[i];
				var newRow = new Array();
				newRow = fila[i].split("|");
				listado1.insertar(newRow);
			}
		}
	}
   
    function listado1Tostring(){      
        var codigo = listado1.codigos();
		var total = "";
        lon = listado1.datos.length
		for(var a = 0; a < lon ; a++){
      		//var toAdd = "";   
			//toAdd = codigo[a]; // oid
            
            var toAdd = "";
            toAdd = "oid:"+ codigo[a];
            
			if(listado1.extraeDato(codigo[a], 0)!= null && listado1.extraeDato(codigo[a], 0)!="")
				toAdd = toAdd + "|" + "oEv:" + listado1.extraeDato(codigo[a], 0);    //oidEstatusVenta
                
            if(listado1.extraeDato(codigo[a], 1)!= null && listado1.extraeDato(codigo[a], 1)!="")
				toAdd = toAdd + "|" + "oEM:" + listado1.extraeDato(codigo[a], 1);    //oidEstatusVentaMAE
            if(listado1.extraeDato(codigo[a], 2)!= null && listado1.extraeDato(codigo[a], 2)!="")
				toAdd = toAdd + "|" + "oPd:" + listado1.extraeDato(codigo[a], 2);    //oidPeriodoDesde   
			if(listado1.extraeDato(codigo[a], 3)!= null && listado1.extraeDato(codigo[a], 3)!="")
				toAdd = toAdd + "|" + "oPh:"  + listado1.extraeDato(codigo[a], 3);    //oidPeriodoHasta
			if(listado1.extraeDato(codigo[a], 4)!= null && listado1.extraeDato(codigo[a], 4)!="")
                toAdd = toAdd + "|" + "dEv:"  + listado1.extraeDato(codigo[a], 4);    //DesEstatusVtaMAE
                
			if(listado1.extraeDato(codigo[a], 5)!= null && listado1.extraeDato(codigo[a], 5)!="")
                toAdd = toAdd + "|" + "dPd:"  + listado1.extraeDato(codigo[a], 5);    //desPeriodoDesde
			if(listado1.extraeDato(codigo[a], 6)!= null && listado1.extraeDato(codigo[a], 6)!="")
                toAdd = toAdd + "|" + "dPh:"  + listado1.extraeDato(codigo[a], 6);    //desPeriodoHasta

			total = total + "$" + toAdd;
      
      
		}		
		return total;
	}
    
    function accionEliminar()
    {

        var vMostrarMensaje ='';
        var cantElementosL1 = listado1.codSeleccionados();		
        
        if ( cantElementosL1.length == 0){
            GestionarMensaje("4", null, null, null);
            return;
        }
        if ( cantElementosL1.length > 0 )
            listado1.eliminarSelecc();
    }
    
    function fBorrar()
    {
        accionEliminar();
        focaliza("cbEstatusVentaMAE");
        
    }
   
    function fVolver()
    {
        window.close();
    }
    
    
    function existeFila(datos)
    {
        listado1.actualizaDat();
        var codigo ="";
        
        var dat = listado1.datos;
         
        if (listado1.codigos() !="")
           codigo = listado1.codigos(); 
            
        var newRow = new Array();
        newRow = datos.split("|");
        
        var flag = false;
        var a = 0;
        
        var dato1= newRow[2];
        var dato2= newRow[3];
        var dato3= newRow[4];
        
        if (dat != ""){
            var datoLista1 = listado1.extraeDato(codigo[a], 1);        
            var datoLista2 = listado1.extraeDato(codigo[a], 2);
            var datoLista3 = listado1.extraeDato(codigo[a], 3);
           
            if ((dato1 == datoLista1) && (dato2 == datoLista2) && (dato3 == datoLista3)){
                
                set("formulario.cbEstatusVentaMAE"," ");
                set("formulario.cbPeriodoDesde"," ");
                set("formulario.cbPeriodoHasta"," ");     
                
                focaliza("formulario.cbEstatusVentaMAE"); 
                
                flag = true;
            }else{
            }
            
        }
        return flag;
    }
  
    
    
    function seteaCombosAniadir(){
        set("formulario.cbEstatusVentaMAE"," ");
        set("formulario.cbPeriodoDesde"," ");
        set("formulario.cbPeriodoHasta"," ");     
        
        focaliza("formulario.cbEstatusVentaMAE");     
    }
    
    
    function fLimpiar(){
        if(get('formulario.opcionMenu')!="Modificar Concurso Ranking"){  
            set("formulario.cbEstatusVentaMAE"," ");
            set("formulario.cbPeriodoDesde"," ");
            set("formulario.cbPeriodoHasta"," ");     
            
            focaliza("formulario.cbEstatusVentaMAE"); 
        
        } else {
            set('formulario.conectorAction', 'LPMantenerParametrosConsultorasRanking'); 
            set('formulario.accion', 'cargar estatus venta ranking');
            eval('formulario').oculto = 'N';
            enviaSICC('formulario',null,null,'N');
        }
    
    }




