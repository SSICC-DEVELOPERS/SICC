 
 var varNoLimpiarSICC = true;
 

//--------------------------------------------------------------------------------------------------      
function onLoadPag(){

    DrdEnsanchaConMargenDcho('listado1',12);
    eval (ON_RSZ);       
    ocultarLista();
    
    
    btnProxy("1", 0);
    btnProxy("3", 1);
    
    configurarMenuSecundario('frmFormulario');   
    
    focaliza("frmFormulario.cbUsuarioCobranza");
  
    if (get('frmFormulario.errDescripcion')!='') {
        var wnd = fMostrarMensajeError( get('frmFormulario.errCodigo'), 
                                        get('frmFormulario.errDescripcion'));
    }

}

//--------------------------------------------------------------------------------------------------
function  fLimpiar(){

    set("frmFormulario.cbUsuarioCobranza", "");
    set("frmFormulario.cbMarca", "");
    set("frmFormulario.cbCanal", "");
    set("frmFormulario.cbPeriodo", "");
    set("frmFormulario.cbTipoCargo", "");
    set("frmFormulario.txtCodigoCliente", "");
    focaliza("frmFormulario.cbUsuarioCobranza");
}

//--------------------------------------------------------------------------------------------------
function llenarDigitos(){  

    var txt  = document.getElementsByName("txtCodigoCliente").item(0);
    
    if(get('frmFormulario.txtCodigoCliente') != ''){
        
        txt.value = get('frmFormulario.txtCodigoCliente');
        var uno = txt.value;            
        var primero = uno;
             
        for (var i= 0; i<primero.length; i++){
            var a = primero.charAt(i);                  
                 
            if (a == "%"){                   
                return false;
            }
        }           
                 
        var valor = new Array(10);
        var valoraux = new Array();
                   
        valor = txt.value;

		// V-COB-013
		//var con = Math.abs(11);
		var longMax = get('frmFormulario.hLongCliente');
		var con = Math.abs(longMax);

		var dif = con-valor.length;
             
        if(valor.length == con){    return;     }
              
        if(valor.length < con){
            
            for(var i=0; i<dif;i++){
                valoraux= valoraux + '0';
            }                    
                  
            set('frmFormulario.txtCodigoCliente', valoraux + uno );
        
        }else{
            txt.value= "";
        }
    }

}

//--------------------------------------------------------------------------------------------------  
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
    
    document.all["BloqueoDesbloqueo"].style.visibility='hidden';
    document.all["Asignar"].style.visibility='hidden';
    document.all["HistoricoGestion"].style.visibility='hidden';
    
    eval (ON_RSZ);
}
  
//--------------------------------------------------------------------------------------------------  
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
    
    
    document.all["BloqueoDesbloqueo"].style.visibility='';
    document.all["Asignar"].style.visibility='';
    document.all["HistoricoGestion"].style.visibility='';
    eval (ON_RSZ);
}
  
//--------------------------------------------------------------------------------------------------  
function buscarCliente(){	
    var obj = new Object();
    var whnd = mostrarModalSICC('LPBusquedaRapidaCliente','',obj);

    if(whnd==null){
    }else{
        var oid = whnd[0];
        var cod = whnd[1];
        set("frmFormulario.txtCodigoCliente", cod);
        set("frmFormulario.oids", oid);
    }
}

//--------------------------------------------------------------------------------------------------
function focalizaTab(){
    if(document.all["Cplistado1"].style.visibility=='hidden'){
        focaliza("frmFormulario.cbUsuarioCobranza");
    
    }else{
        focalizaBotonHTML_XY('BloqueoDesbloqueo');
    }
}
  
//--------------------------------------------------------------------------------------------------
function focalizaShTab(){  
    if(document.all["Cplistado1"].style.visibility=='hidden'){
        focalizaBotonHTML('botonContenido','btnBuscar');
	
    }else{
        focalizaBotonHTML_XY('HistoricoGestion');
	}
}
  
//--------------------------------------------------------------------------------------------------  
function marcaOnChange(){
    recargarPeriodo();  
}
  
//--------------------------------------------------------------------------------------------------  
function canalOnChange(){
    recargarPeriodo();   
}
  
//--------------------------------------------------------------------------------------------------  
function recargarPeriodo(){

    var pais = get("frmFormulario.hPais");
    var idioma = get("frmFormulario.hIdioma");    
    var arr = new Array();
    
    if(get("frmFormulario.cbMarca") !=""){
              
        arr[arr.length] = new Array("pais", pais );
        arr[arr.length] = new Array("oidIdioma", idioma );
        arr[arr.length] = new Array("marca", get("frmFormulario.cbMarca")+"");
        arr[arr.length] = new Array("canal", get("frmFormulario.cbCanal")+"");          
             
        recargaCombo('frmFormulario.cbPeriodo', 'CRAObtienePeriodos', 
                     'es.indra.sicc.dtos.cra.DTOPeriodo',arr);

    }

 }
  
//--------------------------------------------------------------------------------------------------
function accionBuscar(){
 
    ocultarLista();     
    var pais = get("frmFormulario.hPais");
    var idioma = get("frmFormulario.hIdioma");
    
    var cobranza = get("frmFormulario.cbUsuarioCobranza");
    var marca = get("frmFormulario.cbMarca");
    var canal = get("frmFormulario.cbCanal");
    var periodo  = get("frmFormulario.cbPeriodo");
    var cargo = get("frmFormulario.cbTipoCargo" );
    var cliente = get("frmFormulario.txtCodigoCliente" );
    
    var arr = new Array();	
    arr[arr.length] = new Array("oidPais", pais);
    arr[arr.length] = new Array("oidIdioma", idioma);
    arr[arr.length] = new Array("usuarioCobranzas", cobranza);
    arr[arr.length] = new Array("marca", marca);
    arr[arr.length] = new Array("canal", canal);
    arr[arr.length] = new Array("periodo", periodo);
    arr[arr.length] = new Array("tipoCargo", cargo);
    arr[arr.length] = new Array("codCliente", cliente);      
    arr[arr.length] = new Array("tamanioPagina", 10);
    arr[arr.length] = new Array("indicadorSituacion", 0);
    
    configurarPaginado(mipgndo,
                       "COBBuscarGestionesDeCobranza",
                       "ConectorBuscarGestionesDeCobranzaSB",
                       "es.indra.sicc.dtos.cob.DTOBuscarGestionesDeCobranza",
                       arr);
}   
  
  
//--------------------------------------------------------------------------------------------------  
function accionBloqueoDesbloqueo(){
    if (listado1.numSelecc()== 1){
    
        var arrAux = new Array();
        arrAux = listado1.codSeleccionados();     
          
        var posicion = obtenerPosicionListaEditable(listado1.codSeleccionados(),listado1);
        var codigos = listado1.codigos(); 
        
        var uno = listado1.datos[posicion][3];
    
        var obj = new Object();
        //  var codigoCliente = listado1.extraeDato(codigos,3);
        obj.uno = uno;
        obj.oidRegis =listado1.datos[posicion][0]; 
		obj.indBloqueo =listado1.datos[posicion][6]; 
		obj.indDesbloqueo =listado1.datos[posicion][7]; 
		obj.oidTipoBloqueo =listado1.datos[posicion][9]; 
		obj.hOidCliente=listado1.datos[posicion][10]; 
        //set("frmFormulario.oidRegis", codigos);     
        set("frmFormulario.oidRegis" , uno);
        
        mostrarModalSICC('LPTratarSolicitudBloqueo','bloqueoDesbloqueo', obj);

		accionBuscar();
      
    } else {
        GestionarMensaje('8', null, null, null);
    }
     
}
  
//--------------------------------------------------------------------------------------------------  
function accionAsignar(){  

    if (listado1.numSelecc()== 1){
    
        var arrAux = new Array();
        arrAux = listado1.codSeleccionados();
        var posicion = obtenerPosicionListaEditable(listado1.codSeleccionados(),listado1);
        var codigos = listado1.codigos();				
        var obj = new Object();
        
        //var codigoCliente = listado1.extraeDato(codigos,2);    
        obj.oid =listado1.datos[posicion][3];   

        set("frmFormulario.oid", codigos);
        set("frmFormulario.accion", "activacionExterna");
        
        mostrarModalSICC('LPReasignarCarteraConsultoras','activacionExterna', obj);

    } else {
        GestionarMensaje('8', null, null, null);
    }  

}
   
//--------------------------------------------------------------------------------------------------   
function accionHistoricoGestion(){
    /*
     El Sistema llama al caso de uso Se llama a la LPConsultarHistoricoCobranza  
     con accion = "clienteSeleccionado" pasandole como parametro el código de 
     cliente       
    */													
     var longitud = listado1.codSeleccionados().length;
    //var codigos = listado1.codigos();	
     
    if (longitud ==1){
        var posicion = obtenerPosicionListaEditable(listado1.codSeleccionados(),listado1);
        var  codigoCliente = listado1.datos[posicion][3];
        /* Incidencia BELC300022785 : Se llama a la 
        LPConsultarHistoricoCobranza con accion = "clienteSeleccionado" 
        pasandole como parametro el código de cliente, periodo, canal y
        marca seleccionados*/
        set('frmFormulario.marcaH',get('frmFormulario.cbMarca'));
        set('frmFormulario.canalH',get('frmFormulario.cbCanal'));
        set('frmFormulario.periodoH',get('frmFormulario.cbPeriodo'));
        set("frmFormulario.conectorAction","LPConsultarHistoricoCobranza");
        set("frmFormulario.accion","clienteSeleccionado");	
        set("frmFormulario.oid",codigoCliente);
        enviaSICC("frmFormulario");   

    } else {
        GestionarMensaje('50');
    }
}
  
//--------------------------------------------------------------------------------------------------    
function muestraLista( ultima, rowset){
    var tamano = rowset.length;
   
    if (tamano > 0) {
        mostrarLista();
    
    } else {
        ocultarLista();
		btnProxy(4,0);	
		return false;
    }
      
    focaliza("frmFormulario.cbUsuarioCobranza");	
	return true;
}
  
//--------------------------------------------------------------------------------------------------
function onClickAnular(){
	set("frmFormulario.conectorAction","LPTratarSolicitudBloqueo");
	set("frmFormulario.accion","anular");	
    enviaSICC("frmFormulario");   
}