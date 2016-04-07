    var sec=1;
	var objListado = new Object();
	function onLoadPag() {
		  
		  fMostrarMensajeError();
		  
		  // Combos deshabilitados	 
		  //set_combo('frmFormulario.cbSucursal', arrayVacio());
		  //accion('frmFormulario.cbSucursal', '.disabled=true');

		  rellenarLista();

		  DrdEnsanchaConMargenDcho('listado1',12);
			
		  /*document.all["Cplistado1"].style.visibility='';
		  document.all["CpLin1listado1"].style.visibility='';
		  document.all["CpLin2listado1"].style.visibility='';
		  document.all["CpLin3listado1"].style.visibility='';
		  document.all["CpLin4listado1"].style.visibility='';
		  document.all["primera1Div"].style.visibility='hidden';
		  document.all["ret1Div"].style.visibility='hidden';
		  document.all["ava1Div"].style.visibility='hidden';
		  document.all["separaDiv"].style.visibility='hidden';
		  */

		  setTimeout('eval (ON_RSZ);',200);
		  setTimeout('configurarMenuSecundario("frmFormulario");',200);
		  focaliza("frmFormulario.txtFechaPago");
	}


    function rellenarLista() {

		  compromisosDePago = get('frmFormulario.compromisosDePago');
		//  alert(compromisosDePago);  

		  if(compromisosDePago!="" && compromisosDePago!=null){

			  reg = compromisosDePago.split("|");

			  for (var i=0; i<reg.length ; i++){
				columna = reg[i].split("#");
				oid = listado1.generaCodigo(sec);
				sec = oid;
				var arrTmp = new Array(oid, columna[0], columna[1], columna[2], columna[3], columna[4], columna[5], columna[6], columna[7])
				listado1.insertar(arrTmp,true);
				objListado[oid] = arrTmp;
			  }
			  listado1.repinta();
		  }
	}


	function arrayVacio(){  
      var array = new Array();             
          array[0] = new Array('','');
  
      return array;
    }

	function bancoOnChange(){
		var banco = get('frmFormulario.cbBanco');
	  if(banco != ''){

        //[1] accion('frmFormulario.cbSucursal', '.disabled=false');

        recargaCombo('frmFormulario.cbSucursal', 'CCCRecargaSucursales', 
            'es.indra.sicc.util.DTOOID', [['oid', banco]]);

      } else {        
        
        set_combo('frmFormulario.cbSucursal', arrayVacio());
        //[1] accion('frmFormulario.cbSucursal', '.disabled=true');
      }
		
	}

	
	function aniadirOnClick(){
		 if(sicc_validaciones_generales("gAniadir")){
		    // Arma registro de la lista
			oid = listado1.generaCodigo(sec);
			sec = oid;
			fechaPago = get('frmFormulario.txtFechaPago');
			ImpPago = get('frmFormulario.txtImportePago');
			FechaSeg = get('frmFormulario.txtFechaSeguimientoPrevisto');
			bancoDesc = get('frmFormulario.cbBanco','T');
			sucursalDesc = get('frmFormulario.cbSucursal','T');
			obs = get('frmFormulario.areatxtObservaciones');
			fechCom = get('frmFormulario.hFechaCompromisoPago');
			oidSucursal = get('frmFormulario.cbSucursal');
            var arrTmp = new Array(oid, fechaPago, ImpPago, FechaSeg, bancoDesc, sucursalDesc, obs, fechCom, oidSucursal);
			listado1.insertar(arrTmp);
			objListado[oid] = arrTmp;
			// Limpia los campos
            set('frmFormulario.txtFechaPago','');
			set('frmFormulario.txtImportePago','');
			set('frmFormulario.txtFechaSeguimientoPrevisto','');

			set('frmFormulario.cbBanco','');
		    set_combo('frmFormulario.cbSucursal', arrayVacio());
		    //[1] accion('frmFormulario.cbSucursal', '.disabled=true');
			
		    set('frmFormulario.areatxtObservaciones','');
	   
		    focaliza("frmFormulario.txtFechaPago");

		 }
    }

    function eliminarOnClick(){
		 var cantElementos = listado1.codSeleccionados();

         if( cantElementos.length == 0 ){
                  GestionarMensaje("4", null, null, null);
         }else{
			 for(i=0;i<listado1.selecc.length;i++){
		         if (listado1.selecc[i]==1) {
					objListado[listado1.datos[i][0]]=  null;
	            }
		     }
             listado1.eliminarSelecc();
         }
    }


	function fGuardar(){
		 returnValue = armarDatosSalida();
		 close();

    }


	function fVolver(){	
	    returnValue = armarDatosSalida();
		window.close();
	}

	
	function armarDatosSalida(){	
		var codigos = listado1.codigos();
		  var cadena = "";
		  
		  for (var i=0; i<codigos.length ; i++){
			   if( i != 0){
					cadena = cadena + "|";
			   }
			   cadena = cadena + objListado[codigos[i]][1]  + "#"; //fechaPago
			   cadena = cadena + objListado[codigos[i]][2]  + "#"; //impotPago
			   cadena = cadena + objListado[codigos[i]][3]  + "#"; //fechaSeg
			   cadena = cadena + objListado[codigos[i]][4]  + "#"; //bancoDesc
			   cadena = cadena + objListado[codigos[i]][5]  + "#"; //sucursalDesc
			   cadena = cadena + objListado[codigos[i]][6]  + "#"; //obs         
			   cadena = cadena + objListado[codigos[i]][7]  + "#"; //fechaCom
			   cadena = cadena + objListado[codigos[i]][8] ;	   //oidSucursal
			   /*fechaPago = listado1.extraeDato(codigos[i], 0);
			   cadena = cadena + fechaPago + "#";

			   impotPago = listado1.extraeDato(codigos[i], 1);
			   cadena = cadena + impotPago + "#";

			   fechaSeg = listado1.extraeDato(codigos[i], 2);
			   cadena = cadena + fechaSeg + "#";

			   bancoDesc = listado1.extraeDato(codigos[i], 3);
			   cadena = cadena + bancoDesc + "#";

			   sucursalDesc = listado1.extraeDato(codigos[i], 4);
			   cadena = cadena + sucursalDesc + "#";

			   obs = listado1.extraeDato(codigos[i], 5);
			   cadena = cadena + obs + "#";

			   fechaCom = listado1.extraeDato(codigos[i], 6);
			   cadena = cadena + fechaCom + "#";

			   oidSucursal = listado1.extraeDato(codigos[i], 7);
			   cadena = cadena + oidSucursal;*/
		 }

         //alert("cadena:" + cadena);
		 return cadena;

	}


	function fLimpiar(){
	  // Combos deshabilitados	 
	  set_combo('frmFormulario.cbSucursal', arrayVacio());
      //[1] accion('frmFormulario.cbSucursal', '.disabled=true');

	  set('frmFormulario.areatxtObservaciones','');
   
	  focaliza("frmFormulario.txtFechaPago");
	}

	// Control de TAB
	function focalizaShTab(){
		focalizaBotonHTML_XY('btnEliminar')
	}

	function focalizaShTabEliminar(){
		focalizaBotonHTML('botonContenido','btnAnadir');
	}

	function focalizaTabAniadir(){
		focalizaBotonHTML_XY('btnEliminar')
	}

	function focalizaTabEliminar(){
		focaliza("frmFormulario.txtFechaPago");
	}
