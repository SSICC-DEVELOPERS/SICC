													   var listadoVisible = false;
	  

 	function onLoadPag()   
	{
     
      DrdEnsanchaConMargenDcho('listado1',12);
      eval (ON_RSZ);      
      ocultarLista(); 
      configurarMenuSecundario('frmContenido');   
      focaliza("frmContenido.cbUsuOri");

      if (get('frmContenido.errDescripcion')!='') {
				 var wnd = fMostrarMensajeError(get('frmContenido.errCodigo'), get('frmContenido.errDescripcion'));
		  }
      
      if ( get('frmContenido.activacionExterna') == "true" ){
            onchange_codCliente();
            accion('frmContenido.txtPorCli','.disabled=true');
            accion('frmContenido.txtCodCli','.disabled=true');
            accion('frmContenido.txtNumCli','.disabled=true');
            accion('frmContenido.cbTipoCli','.disabled=true');
            accion('frmContenido.cbSubtipoCli','.disabled=true');
            set ('frmContenido.rbSeleccion','3');
		
			/*Deshabilitamos los radio buttons con el nombre rbSeleccion que son 4 */
	
			accion('frmContenido.rbSeleccion','[3].disabled=true');
			accion('frmContenido.rbSeleccion','[2].disabled=true');
			accion('frmContenido.rbSeleccion','[1].disabled=true');			   
		    accion('frmContenido.rbSeleccion','[0].disabled=true');		
         }else{
                accion('frmContenido.txtPorCli','.disabled=true');
                accion('frmContenido.txtCodCli','.disabled=true');
                accion('frmContenido.txtNumCli','.disabled=false');
                accion('frmContenido.cbTipoCli','.disabled=true');
                accion('frmContenido.cbSubtipoCli','.disabled=true');
                accion('frmContenido.cbSubtipoCli','.disabled=true');
                set ('frmContenido.rbSeleccion','1');
              
              }
         
            
      }
 
 
function accionBuscarCliente(){     

		if(!sicc_validaciones_generales("gr1")){
			return false;
		}  


		if (get('frmContenido.rbSeleccion') == "3"){
			 var oid;
			 var obj = new Object();
			 var whnd = mostrarModalSICC('LPBusquedaRapidaCliente','',obj);
			 if(whnd==null){
			 }else{
				 var oid = whnd[0];
				 var cod = whnd[1];
				 set('frmContenido.hoidCliente', oid);
				 set('frmContenido.txtCodCli', cod);
			 }
		}
  
  }    
      

   function muestraLista(ultima, rowset) {
        var tamano = rowset.length;
        if (tamano > 0) {
			mostrarLista();
			return true;
        }else{
			ocultarLista();
			return false;
        }
	}   
	
	
	function ocultarLista()   
	{    	    
      
	    document.all["Cplistado1"].style.visibility='hidden';
	    document.all["CpLin1listado1"].style.visibility='hidden';
	    document.all["CpLin2listado1"].style.visibility='hidden';
	    document.all["CpLin3listado1"].style.visibility='hidden';
	    document.all["CpLin4listado1"].style.visibility='hidden';
	    document.all["primera1Div"].style.visibility='hidden';
	    document.all["ret1Div"].style.visibility='hidden';
	    document.all["ava1Div"].style.visibility='hidden';
	    document.all["separaDiv"].style.visibility='hidden';	     
      document.all["Reasignar"].style.visibility='hidden';	     
	
  }
  
  function mostrarLista()   
	{    
	    
	    document.all["Cplistado1"].style.visibility='';
	    document.all["CpLin1listado1"].style.visibility='';
	    document.all["CpLin2listado1"].style.visibility='';
	    document.all["CpLin3listado1"].style.visibility='';
	    document.all["CpLin4listado1"].style.visibility='';
	    document.all["primera1Div"].style.visibility='';
	    document.all["ret1Div"].style.visibility='';
	    document.all["ava1Div"].style.visibility='';
	    document.all["separaDiv"].style.visibility='';	     
      document.all["Reasignar"].style.visibility='';	     
      
	}
  
  
     function usuarioOrigenOnChange() {
            var arra = new Array();
           
            arra[0] = ["oidPais",get('frmContenido.oidPais')];
            arra[1] = ["oidIdioma",get('frmContenido.oidIdioma')];      
            arra[2] = ["oid",get('frmContenido.cbUsuOri')];
            recargaCombo("frmContenido.cbUsuDest","COBObtenerUsuariosCobComboMenos1","es.indra.sicc.util.DTOOID",arra);
            recargaCombo("frmContenido.cbCodEtDeuda","COBObtenerEtapasUsuarioCOB","es.indra.sicc.util.DTOOID",arra);
      }
       function recargaPeriodo(){
         var arra = new Array();
         arra[0] = ["pais",get('frmContenido.oidPais')];
		 // V-COB-015 - gPineda - 07/02/2007
		 arra[1] = ["canal",get('frmContenido.cbCanal')];
         arra[2] = ["marca",get('frmContenido.cbMarca')];
         
         recargaCombo("frmContenido.cbCodPer","CRAObtienePeriodos","es.indra.sicc.dtos.cra.DTOPeriodo",arra);
      }
      
      
       function recargaSubTipoCliente(){
         var arra = new Array();
         arra[0] = ["oidIdioma",get('frmContenido.oidIdioma')];
         arra[1] = ["oid",get('frmContenido.cbTipoCli')];
         recargaCombo("frmContenido.cbSubtipoCli","MAEobtenerSubtipos","es.indra.sicc.util.DTOOID",arra); 
         
      }
      
      
       function  buscar(){
        if(!sicc_validaciones_generales("gr")){
                return false;
            }  
       
            quitaOculto();
            //mostrarLista();
            configurarPaginado(mipgndo,
                               "COBBuscarAsignacionesCobranza",
                               "ConectorBuscarAsignacionesCobranza",
                               "es.indra.sicc.dtos.cob.DTOAsignacionesCobranza", armarArray());
           
      }   
      
        function armarArray(){

            var arra = new Array();
            var pos = 0;
            
            if(get("frmContenido.cbUsuOri")!="" && get("frmContenido.cbUsuOri")!=null){
                arra[pos] = ["usuarioOrigen",get('frmContenido.cbUsuOri')];
                set ('frmContenido.usuarioOrigen',get('frmContenido.cbUsuOri'));
                pos++;
             }
             
             if(get("frmContenido.cbUsuDest")!="" && get("frmContenido.cbUsuDest")!=null){
                arra[pos] = ["usuarioDestino",get('frmContenido.cbUsuDest')];
                set ('frmContenido.usuarioDestino',get('frmContenido.cbUsuDest'));
                pos++;
             }
             
             
             if(get("frmContenido.cbCodEtDeuda")!="" && get("frmContenido.cbCodEtDeuda")!=null){
                arra[pos] = ["etapaDeuda",get('frmContenido.cbCodEtDeuda')];
                set ('frmContenido.etapaDeuda',get('frmContenido.cbCodEtDeuda'));
                pos++;
             }
             
             
             if(get("frmContenido.cbMarca")!="" && get("frmContenido.cbMarca")!=null){
                arra[pos] = ["marca",get('frmContenido.cbMarca')];
                set ('frmContenido.marca',get('frmContenido.cbMarca'));
                pos++;
             }
             
             
             if(get("frmContenido.cbCanal")!="" && get("frmContenido.cbCanal")!=null){
                arra[pos] = ["canal",get('frmContenido.cbCanal')];
                set ('frmContenido.canal',get('frmContenido.cbCanal'));
                pos++;
             }
             
             
             if(get("frmContenido.cbCodPer")!="" && get("frmContenido.cbCodPer")!=null){
                arra[pos] = ["periodo",get('frmContenido.cbCodPer')];
                set ('frmContenido.periodo',get('frmContenido.cbCodPer'));
                pos++;
             }
             
             
             if(get("frmContenido.cbTipoCli")!="" && get("frmContenido.cbTipoCli")!=null){
                arra[pos] = ["tipoCliente",get('frmContenido.cbTipoCli')];
                set ('frmContenido.tipoCliente',get('frmContenido.cbTipoCli'));
                pos++;
             }
             
             
             if(get("frmContenido.cbSubtipoCli")!="" && get("frmContenido.cbSubtipoCli")!=null){
                arra[pos] = ["subtipoCliente",get('frmContenido.cbSubtipoCli')];
                set ('frmContenido.subTipoCliente',get('frmContenido.cbSubtipoCli'));
                pos++;
             }
             
             if(get("frmContenido.txtCodCli")!="" && get("frmContenido.txtCodCli")!=null){
                arra[pos] = ["codigoCliente",get('frmContenido.txtCodCli')];
                set ('frmContenido.codCliente',get('frmContenido.txtCodCli'));
                pos++;
             }
             
             if(get("frmContenido.txtNumCli")!="" && get("frmContenido.txtNumCli")!=null){
                arra[pos] = ["numeroClientes",get('frmContenido.txtNumCli')];
                set ('frmContenido.numCliente',get('frmContenido.txtNumCli'));
                pos++;
             }
             
             
             if(get("frmContenido.txtPorCli")!="" && get("frmContenido.txtPorCli")!=null){
                arra[pos] = ["porcentajeClientes",get('frmContenido.txtPorCli')];
                set ('frmContenido.porCliente',get('frmContenido.txtPorCli'));
                pos++;
             }
             
             arra[pos] = ["paginado","1"];
             set ('frmContenido.territorio',get('frmContenido.txtTerritorio'));
             
         									  
      return arra;
    }
    

	 function validarLongCodCliene(codCliente) {
		  var longiCod = get('frmContenido.hLongitudCodCliente');
		  var faltantes = longiCod -  codCliente.length;
		  var resultCod = new String("");
		  if(faltantes > 0){
			   for(var t = 0 ; t<faltantes; t++){
						resultCod = resultCod + "0";
			   }
			   resultCod = resultCod + codCliente;
			   return resultCod;
		  }
		  return codCliente;

	 }


// cuando viene el codigo seteado
	 function onchange_codCliente(){
      
		if(!sicc_validaciones_generales("gr1")){
			return false;
		} 
		  var codCliente = get('frmContenido.txtCodCli');
      if (codCliente.length != 0)  {
			   codigoCompleto = validarLongCodCliene(codCliente);
			   set('frmContenido.txtCodCli', codigoCompleto);
         set('frmContenido.codCliente', codigoCompleto);
         set('frmContenido.accion', 'Modificar cliente');
			   eval('frmContenido').oculto = 'S';
			   enviaSICC('frmContenido','','','N');
			   // FIN MODIFICACION ---------------------------
		  }
	 }


   function asignarDatosCliente(oidCliente){
		  
      alert (oidCliente);
      if( oidCliente != '' ){
            set("frmContenido.oidCliente", oidCliente);
  		}
	 }
   
	 function errorClienteBusqueda(indicador){
        eval('frmContenido').oculto = 'N';
        //set('frmContenido.txtCodCli', '');
        set('frmContenido.oidCliente', '');	
        focaliza('frmContenido.txtCodCli');			  
		}

   function click(){
    
      if (get('frmContenido.rbSeleccion') == "1"){
            accion('frmContenido.txtPorCli','.disabled=true');
            accion('frmContenido.txtCodCli','.disabled=true');
            accion('frmContenido.txtNumCli','.disabled=false');
            accion('frmContenido.cbTipoCli','.disabled=true');
            accion('frmContenido.cbSubtipoCli','.disabled=true');
            set('frmContenido.txtPorCli','');
            set('frmContenido.txtCodCli','');
            set('frmContenido.cbTipoCli','');
            set('frmContenido.cbSubtipoCli','');
            
      }else if (get('frmContenido.rbSeleccion') == "2"){
                accion('frmContenido.txtPorCli','.disabled=false');
                accion('frmContenido.txtCodCli','.disabled=true');
                accion('frmContenido.txtNumCli','.disabled=true');
                accion('frmContenido.cbTipoCli','.disabled=true');
                accion('frmContenido.cbSubtipoCli','.disabled=true');
                set('frmContenido.txtNumCli','');
                set('frmContenido.txtCodCli','');
                set('frmContenido.cbTipoCli','');
                set('frmContenido.cbSubtipoCli','');
                
                
          }else if (get('frmContenido.rbSeleccion') == "3"){
                    accion('frmContenido.txtPorCli','.disabled=true');
                    accion('frmContenido.txtCodCli','.disabled=false');
                    accion('frmContenido.txtNumCli','.disabled=true');
                    accion('frmContenido.cbTipoCli','.disabled=true');
                    accion('frmContenido.cbSubtipoCli','.disabled=true');
                    set('frmContenido.txtPorCli','');
                    set('frmContenido.txtNumCli','');
                    set('frmContenido.cbTipoCli','');
                    set('frmContenido.cbSubtipoCli','');
                    
          }
            else if (get('frmContenido.rbSeleccion') == "4"){
                    accion('frmContenido.txtPorCli','.disabled=true');
                    accion('frmContenido.txtCodCli','.disabled=true');
                    accion('frmContenido.txtNumCli','.disabled=true');
                    accion('frmContenido.cbTipoCli','.disabled=false');
                    accion('frmContenido.cbSubtipoCli','.disabled=false');
                    set('frmContenido.txtPorCli','');
                    set('frmContenido.txtNumCli','');
                    set('frmContenido.txtCodCli','');
            }
   }
   
  function reasignarOnClick(){
    set('frmContenido.accion','reasignar');
    set('frmContenido.conectorAction','LPReasignarCarteraConsultoras');

    eval("frmContenido").oculto="S";
    enviaSICC('frmContenido', '', '', 'N');     
    
    // splatas - 22/05/2006
    /*
    buscar();
    
    if ( get('frmContenido.activacionExterna') == "true" ){
        window.close();
    }
    */
    
    
  }
  function quitaOculto(){
    eval("frmContenido").oculto="N";
  }
  
  
  function onchange_numClie(){
  		if(!sicc_validaciones_generales("gr1")){
			return false;
		}  
  }

  function onchange_porClie() {
  		if(!sicc_validaciones_generales("gr1")){
			return false;
		}    
  }

    function ontab_Reasignar(){
        focaliza('frmContenido.cbUsuOri','');
    }
    
    function onshtab_Reasignar(){
        focalizaBotonHTML('botonContenido', 'btnBuscar');
    }
   

    function ontab_Buscar(){
          if (listadoVisible == false){
               focaliza('frmContenido.cbUsuOri','');
          } else {
               focalizaBotonHTML('botonContenido', 'Reasignar');
          }    
    }
    
    function onShifTab_UsuarioOrigen(){
          if (listadoVisible == false){
               focalizaBotonHTML('botonContenido', 'btnBuscar');
          } else {
               focalizaBotonHTML('botonContenido', 'Reasignar');
          }
    }
    
 function fVolver(){
	 window.close();
 }
