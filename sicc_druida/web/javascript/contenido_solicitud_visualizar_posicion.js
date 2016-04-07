function onLoadPag()   
    {           
      configurarMenuSecundario('frmFormulario');
	  
	  DrdEnsanchaConMargenDcho('listado1',12); 
      DrdEnsanchaConMargenDcho('listado2',12); 
      DrdEnsanchaConMargenDcho('listado3',12); 
      DrdEnsanchaConMargenDcho('listado4',12); 
     
      document.all["Cplistado1"].style.visibility='hidden'; 
      document.all["CpLin1listado1"].style.visibility='hidden';  
      document.all["CpLin2listado1"].style.visibility='hidden'; 
      document.all["CpLin3listado1"].style.visibility='hidden';
      document.all["CpLin4listado1"].style.visibility='hidden'; 
      
      document.all["Cplistado2"].style.visibility='hidden'; 
      document.all["CpLin1listado2"].style.visibility='hidden';  
      document.all["CpLin2listado2"].style.visibility='hidden'; 
      document.all["CpLin3listado2"].style.visibility='hidden';
      document.all["CpLin4listado2"].style.visibility='hidden'; 
      
      document.all["Cplistado3"].style.visibility='hidden'; 
      document.all["CpLin1listado3"].style.visibility='hidden';  
      document.all["CpLin2listado3"].style.visibility='hidden'; 
      document.all["CpLin3listado3"].style.visibility='hidden';
      document.all["CpLin4listado3"].style.visibility='hidden'; 
      
      /*document.all["Cplistado4"].style.visibility=''; 
      document.all["CpLin1listado4"].style.visibility='';  
      document.all["CpLin2listado4"].style.visibility=''; 
      document.all["CpLin3listado4"].style.visibility='';
      document.all["CpLin4listado4"].style.visibility='';  */

	  document.all["Cplistado4"].style.visibility='hidden'; 
      document.all["CpLin1listado4"].style.visibility='hidden';  
      document.all["CpLin2listado4"].style.visibility='hidden'; 
      document.all["CpLin3listado4"].style.visibility='hidden';
      document.all["CpLin4listado4"].style.visibility='hidden';  
      
      
      document.all["primera1Div"].style.visibility='hidden'; 
      document.all["ret1Div"].style.visibility='hidden';
      document.all["ava1Div"].style.visibility='hidden';  
      document.all["separa1Div"].style.visibility='hidden'; 
      
      document.all["primera2Div"].style.visibility='hidden'; 
      document.all["ret2Div"].style.visibility='hidden';
      document.all["ava2Div"].style.visibility='hidden';  
      document.all["separa2Div"].style.visibility='hidden'; 
      
      document.all["primera3Div"].style.visibility='hidden'; 
      document.all["ret3Div"].style.visibility='hidden';
      document.all["ava3Div"].style.visibility='hidden';  
      document.all["separa3Div"].style.visibility='hidden'; 
      
      /*document.all["primera4Div"].style.visibility=''; 
      document.all["ret4Div"].style.visibility='';
      document.all["ava4Div"].style.visibility='';  
      document.all["separa4Div"].style.visibility=''; */

	  document.all["primera4Div"].style.visibility='hidden'; 
      document.all["ret4Div"].style.visibility='hidden';
      document.all["ava4Div"].style.visibility='hidden';  
      document.all["separa4Div"].style.visibility='hidden';
          
      eval (ON_RSZ);   
      ON_RSZ = '';
         
    }

    function mostrarListado()
	{
       var _v_ = (arguments[1])?'visible':'hidden';
	   prev = arguments[0];
	   //alert(arguments[0]);
	     document.all["Cplistado"+arguments[0]].style.visibility=_v_; 
         document.all["CpLin1listado"+arguments[0]].style.visibility=_v_;  
         document.all["CpLin2listado"+arguments[0]].style.visibility=_v_; 
         document.all["CpLin3listado"+arguments[0]].style.visibility=_v_;
         document.all["CpLin4listado"+arguments[0]].style.visibility=_v_;  
         document.all["primera"+arguments[0]+"Div"].style.visibility=_v_; 
         document.all["ret"+arguments[0]+"Div"].style.visibility=_v_;
         document.all["ava"+arguments[0]+"Div"].style.visibility=_v_;  
         document.all["separa"+arguments[0]+"Div"].style.visibility=_v_;
		 if(_v_=="visible"){
			 return true;
		 }else{
			 return false;
		 }
	}

	function cargarPosicion()
	{		
		/*DTOConsultarPosicionesSolicitud 
		- Parametros del DTO: 
		- oidCabeceraSolicitud (Recibido desde la LP) 
		- oidTipoInformacion: oid del valor seleccionado en cbBloqueInformacion */

		var arr = new Array();
		arr[arr.length] = new Array("oidCabeceraSolicitud",get('frmFormulario.hOidCabeceraSolicitud').toUpperCase());
		//arr[arr.length] = new Array("oidCabeceraSolicitud",'48');
		arr[arr.length] = new Array("oidTipoInformacion",arguments[0]);	
		
		//alert("arguments[1], es: " + arguments[1]);
		//alert("arr, es: " + arr);

		switch(arguments[1])
		{
		   case '1':
		        //alert("cargando posicion 1 - UNO: " + arr);
				configurarPaginado(mipgndo1,
								  'PEDConsultarPosicionesSolicitud',
								  'ConectorConsultarPosiciones1',
								  'es.indra.sicc.dtos.ped.DTOConsultarPosicionesSolicitud',
								  arr);
				//alert(mipgndo1.lista.datos);
				break;
	       case '2':
				configurarPaginado(mipgndo2,
								  'PEDConsultarPosicionesSolicitud',
								  'ConectorConsultarPosiciones2',
								  'es.indra.sicc.dtos.ped.DTOConsultarPosicionesSolicitud',
								  arr);
			    break;
		   case '3':
				configurarPaginado(mipgndo3,
								  'PEDConsultarPosicionesSolicitud',
								  'ConectorConsultarPosiciones3',
								  'es.indra.sicc.dtos.ped.DTOConsultarPosicionesSolicitud',
								  arr);
				break;
			case '4':
			    //alert("cargando posicion 1 - UNO: " + arr);
				configurarPaginado(mipgndo4,
								  'PEDConsultarPosicionesSolicitud',
								  'ConectorConsultarPosiciones4',
								  'es.indra.sicc.dtos.ped.DTOConsultarPosicionesSolicitud',
								  arr);
				break;
		 }
	}
	
	var prev = 4;
    function accionAceptar()
	{	  
	   var val = get('frmFormulario.cbBloqueInformacion');	   
       if(val == "") 
	     fValidarCOMBO('frmFormulario.cbBloqueInformacion'); //GestionarMensaje('27','frmFormulario.cbBloqueInformacion');
	   else
	   {
			   //alert("Valor combo:   " + val);
			   if(prev != 0)	    
				  mostrarListado(prev,false); 
			   if(val == get('frmFormulario.hInformacionBasicaPosicion') )
			   {					
					cargarPosicion(val,'1');
					mostrarListado(1,true);					
			   }
			   if(val == get('frmFormulario.hInformacionProductosPosicion') )
			   {
					cargarPosicion(val,'2');
					mostrarListado(2,true);
					
			   }
			   if(val == get('frmFormulario.hInformacionCantidadesPosicion') )
			   {
					cargarPosicion(val,'3');
					mostrarListado(3,true);					
			   }
			   if(val == get('frmFormulario.hInformacionEconomicaPosicion') )
			   {
					cargarPosicion(val,'4');
					mostrarListado(4,true);					
			   }
		}   
	}
	function focButton(){ document.all[arguments[0]].focus(); }

	function fVolver(){
		window.close();
	}