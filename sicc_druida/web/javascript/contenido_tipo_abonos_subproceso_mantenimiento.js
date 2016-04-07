 function onLoadPag(){   
        
        configurarMenuSecundario("formulario");
        DrdEnsanchaConMargenDcho('listado1',12);
        eval(ON_RSZ);
        focaliza("formulario.cbProceso");       
        ocultarLista();
        
        
        if (get('formulario.errDescripcion')!='') {
		     var wnd = fMostrarMensajeError(get('formulario.errCodigo'), get('formulario.errDescripcion'));
			 ocultarLista();            
	    }
        
        var opcion = get("formulario.opcionMenu");        
        var ultAcc = get("formulario.ultimaAccion");        
        
        if(opcion=="Eliminar")
            btnProxy(4,'0');
            
        if(opcion=="Modificar")
            btnProxy(1,'0');
            
            
        var desh = get("formulario.Des");        
       
        if (opcion =="Insertar")            
            document.getElementById("btnBuscar").style.visibility='hidden'; 
     
        
        if (ultAcc == "Modificar"){ 
           btnProxy(1,'1');
            document.getElementById("btnBuscar").style.visibility='hidden'; 
            var oidP = get("formulario.oidPr");
            var oidS = get("formulario.oidSubPr");
            var oidT = get("formulario.oidTipoAB");
            var oidC = get("formulario.oidCC");
            
            var uno = get("formulario.oidTipoAbonoSubproceso");
            
            
            set("formulario.cbProceso",new Array(oidP));            
            var arr = new Array();
            arr[arr.length] = new Array("oid", oidP);        
            recargaCombo('formulario.cbSubproceso', 'CCCobtieneSubprocesos', 'es.indra.sicc.util.DTOOID', arr, 'setearSubtipo(datos)');
                       
            set("formulario.cbTipoAbono",new Array(oidT));
            set("formulario.cbCuentaContable",new Array(oidC));  
      
          } 
         
         if (ultAcc == "Detalle"){                  
            
            var oidP = get("formulario.oidPr");           
            var oidS = get("formulario.oidSubPr");
            var oidT = get("formulario.oidTipoAB");
            var oidC = get("formulario.oidCC");            
           
            set("formulario.cbProceso",new Array(oidP)); 
            
            
            var arr = new Array();
            arr[arr.length] = new Array("oid", oidP);
        
            recargaCombo('formulario.cbSubproceso', 'CCCobtieneSubprocesos', 'es.indra.sicc.util.DTOOID', arr, 'setearSubtipo(datos)');
             
            set("formulario.cbTipoAbono",new Array(oidT));
            set("formulario.cbCuentaContable", new Array(oidC));
            
            document.getElementById("btnBuscar").style.visibility='hidden'; 
            
            accion("formulario.cbProceso", ".disabled=true");
            accion("formulario.cbSubproceso", ".disabled=true");
            accion("formulario.cbTipoAbono", ".disabled=true");
            accion("formulario.cbCuentaContable", ".disabled=true");
            
          }
          
          if (ultAcc == "Eliminar"){ 
          
            var oidP = get("formulario.oidPr");
            var oidS = get("formulario.oidSubPr");
            var oidT = get("formulario.oidTipoAB");
            var oidC = get("formulario.oidCC");
            
            btnProxy(4,'0');
            
            set("formulario.cbProceso",new Array(oidP)); 
            var arr = new Array();
            arr[arr.length] = new Array("oid", oidP);
        
            recargaCombo('formulario.cbSubproceso', 'CCCobtieneSubprocesos', 'es.indra.sicc.util.DTOOID', arr, 'setearSubtipo(datos)');
          
            set("formulario.cbTipoAbono",new Array(oidT));
            set("formulario.cbCuentaContable",new Array(oidC));  
            document.getElementById("btnBuscar").style.visibility='hidden';
           
           
            accion("formulario.cbProceso", ".disabled=true");
            accion("formulario.cbSubproceso", ".disabled=true");
            accion("formulario.cbTipoAbono", ".disabled=true");
            accion("formulario.cbCuentaContable", ".disabled=true");
          } 
  }
  
  
  function setearSubtipo(datos){
 	seteo = cargaArray(datos);
    set_combo('formulario.cbSubproceso',datos, []);				   
    set('formulario.cbSubproceso', [get('formulario.oidSubPr')]); 
}

    function cargaArray(datos){
		var seteo = new Array(datos.length + 1);
		seteo[0] = ['' , '']
		for(i = 0; i < datos.length; i++){
			seteo[i+1] = [ datos[i][0], datos[i][1] ]
		}
		return seteo;
    }


    function cerrarVentana(){     
		window.returnValue = true;
    }
    
         
    function buscar(){
        set("formulario.accion", "buscar");
		var arr = new Array();
        
        arr[arr.length] = new Array("oidProceso", get("formulario.cbProceso")+"");
        arr[arr.length] = new Array("oidSubproceso", get("formulario.cbSubproceso")+"");
        arr[arr.length] = new Array("oidCuentaContable", get("formulario.cbCuentaContable")+"");
        arr[arr.length] = new Array("oidTipoAbono", get("formulario.cbTipoAbono")+"");               
            
        configurarPaginado(mipgndo,"CCCBuscarTiposAbonoSubproceso","ConectorBuscarTiposAbonoSubproceso","es.indra.sicc.dtos.ccc.DTOBuscarTiposAbonoSubproceso",arr);
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
		 document.all["Cplistado1"].style.visibility='visible';
		 document.all["CpLin1listado1"].style.visibility='visible';
		 document.all["CpLin2listado1"].style.visibility='visible';
		 document.all["CpLin3listado1"].style.visibility='visible';
		 document.all["CpLin4listado1"].style.visibility='visible';
		 document.all["primera1Div"].style.visibility='visible';
		 document.all["ret1Div"].style.visibility='visible';
		 document.all["ava1Div"].style.visibility='visible';
		 document.all["separaDiv"].style.visibility='visible';
         
         var opcion = get("formulario.opcionMenu");
         
         
         if ((opcion == "Buscar") || (opcion == "Eliminar" )){
            document.all["DetalleDiv"].style.visibility='';
            document.all["ModificarDiv"].style.visibility='hidden';
        }
        
        if(opcion =="Modificar"){
                document.all["ModificarDiv"].style.visibility='';
                document.all["DetalleDiv"].style.visibility='hidden';
         }           
    }
    
      
    
    function focalizaTab(){
        focaliza("formulario.cbSubproceso");
    
    }
    
    
    function focalizaTab2(){

        if(document.all["Cplistado1"].style.visibility=='hidden'){
                focaliza("formulario.cbProceso");
        }else{
        
                if(get('formulario.opcionMenu') == 'Modificar' ){
                    focalizaBotonHTML_XY('Modificar');
                }else{
                    focalizaBotonHTML_XY('Detalle');
                }
    
            }	
    }

    function focalizaShTab(){  
        
        var opcion = get("formulario.opcionMenu");
        
        if ((opcion =="Insertar" ) || (opcion== "Modificar") || (opcion=="Detalle")){
            focaliza("formulario.cbCuentaContable");        
        }else{
               
                if(document.all["Cplistado1"].style.visibility=='hidden'){
                    focalizaBotonHTML('botonContenido','btnBuscar');
                }else{
                    if(get('formulario.casoDeUso') == 'Modificar' ){
                        focalizaBotonHTML_XY('Modificar');
                    }else{
                        focalizaBotonHTML_XY('Detalle');
                    }
        
                }       
        }
    }
    
    
    
    function muestraLista(ultima, rowset) {

        var tamanio = rowset.length;

        if (tamanio > 0 && rowset[0].length>0) {
			mostrarLista();
            
			if(get('formulario.opcionMenu') == 'Eliminar'){
				btnProxy(4, 1);
				mipgndo.lista.maxSel = -1;
			}else{
				btnProxy(4, 0);
				mipgndo.lista.maxSel = 1;
			}
			return true;
		 } else {
			ocultarLista();
			btnProxy(4, 0);
			return false;
		 }
    }



    function onClickDetalle(){
    
        var codigos = listado1.codSeleccionados();    
        var valorSeteado = mipgndo.lista.codSeleccionados();
    
        if( valorSeteado != '' ){ /*2	  */
        
                if( valorSeteado.length == 1 ){
    
                    var obj = new Object();
                    obj.seleccion = valorSeteado[0];
                    var sel = valorSeteado;

                    obj.proce = listado1.extraeDato(codigos[0],7);
                    obj.subProce =  listado1.extraeDato(codigos[0],1);   
                    
                    obj.tAbono = listado1.extraeDato(codigos[0],3);
                    obj.cContable = listado1.extraeDato(codigos[0],5);                 
                    obj.opcionMenu = get("formulario.opcionMenu");
                    
                    var opcion = get("formulario.opcionMenu");
                    
                    if (opcion =="Eliminar"){
                        obj.ultimaAccion ="Eliminar";
                    
                    }else{
                            obj.ultimaAccion ="Detalle";
                   }
                    
                    var winModal = mostrarModalSICC('LPMantenimientoTiposAbonoSubproceso', 'Detalle', obj, null, null);
    
        
                } else {
                            GestionarMensaje('8',null,null,null);
                 }
            }		
            else{
                    GestionarMensaje('4', null, null, null);
           }		
    }
    
    
    
    function onClickModificar(){
    
        var codigos = listado1.codSeleccionados();
        var valorSeteado = mipgndo.lista.codSeleccionados();

        if (listado1.numSelecc()!= 1) {
            GestionarMensaje('1022',null,null,null);
            return false;
        }

        if( valorSeteado != '' ){      
           	    var obj = new Object();
                    obj.seleccion = valorSeteado[0];
                    var sel = valorSeteado;

                    obj.proce = listado1.extraeDato(codigos[0],7);
                    obj.subProce =  listado1.extraeDato(codigos[0],1);   
                    
                    obj.tAbono = listado1.extraeDato(codigos[0],3);
                    obj.cContable = listado1.extraeDato(codigos[0],5);                 
                    
                    obj.oidTipoAbonoSubproceso = codigos[0];
                    obj.opcionMenu = get("formulario.opcionMenu");
                    
                   /* var opcion = get("formulario.opcionMenu");	   */
                    
                    var retorno = mostrarModalSICC('LPMantenimientoTiposAbonoSubproceso', 'Detalle', obj, null, null);
                   
                    if( retorno != null && retorno == true ){
                        buscar();
                    }
                  
        
      }else{
					GestionarMensaje('4', null, null, null);
	}
    }
    
    
    
    function fVolver(){	
		window.close();
    }
    
    function borrarTodo(){
         fLimpiar();
    }
    
    function onChangeProceso(){
    
        var proceso= get("formulario.cbProceso");
        var arr = new Array();
        arr[arr.length] = new Array("oid", proceso);
        
		recargaCombo('formulario.cbSubproceso', 'CCCobtieneSubprocesos', 'es.indra.sicc.util.DTOOID', arr);    
    
    }
    
    function fLimpiar(){
    
        set("formulario.cbProceso",new Array(''));
        set("formulario.cbSubproceso",new Array("",""), []);
        set("formulario.cbTipoAbono",new Array(''));
        set("formulario.cbCuentaContable",new Array(''));
        
        focaliza("formulario.cbProceso");
    
    }
    
    function focalizaOnTAB(){
    
        var opcion = get("formulario.opcionMenu");
        
        if( (opcion =="Insertar") || (opcion=="Modificar")|| (opcion == "Detalle")){
            focaliza("formulario.cbProceso");
        } else{
               focalizaBotonHTML('botonContenido','btnBuscar');        
        }
    }
    
   
    function fGuardar(){
        	if (sicc_validaciones_generales()){ 
                set("formulario.oidTipoAbonoSubproceso",get("formulario.oidTipoAbonoSubproceso"));
                set("formulario.conectorAction","LPMantenimientoTiposAbonoSubproceso");
				set("formulario.accion","Guardar");		
                
				enviaSICC("formulario");            
            } 
    
    }   
    
    function fBorrar(){
      if (listado1.numSelecc()== 0) {
       GestionarMensaje('1021',null,null,null);
       return false;
      }
      if(GestionarMensaje('131',null,null,null) == true) {
            
                 var codigo = listado1.codSeleccionados();
                 var toAdd = "";
                 for(var a = 0; a < codigo.length ; a++){
                    toAdd = toAdd + codigo[a] + ",";    
                 } 
                    codigo= toAdd;
                    set("formulario.oidsDetalle" , codigo);
                    set("formulario.conectorAction","LPMantenimientoTiposAbonoSubproceso");
                    set("formulario.accion","Eliminar");						
                    enviaSICC("formulario");
      }
    }
    
    function focalizaShTaAB(){
    
        var opcion = get("formulario.opcionMenu");

        if(opcion =="Insertar"){
            focaliza("formulario.cbTipoAbono");
        } else{
              focaliza("formulario.cbTipoAbono");
        }        

    }
    
    function cerrarEliminar(esError){
        if(esError){
			GestionarMensaje('UICCC0024');	
		}
		buscar();
    
    }
