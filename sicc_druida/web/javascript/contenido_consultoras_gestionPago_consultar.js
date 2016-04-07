      
	function onLoadPag(){
		fMostrarMensajeError();

		//ocultarLista();

        if(get('frmFormulario.accion')==""){
			focaliza("frmFormulario.txtCodigoCliente");
		} else{
		     // Deshabilitar CodigoCliente
			accion('frmFormulario.txtCodigoCliente','.disabled=true');      
            document.all.lupa.onclick= "";

			focaliza("frmFormulario.cbEstado");
		}
		setTimeout('configurarMenuSecundario("frmFormulario");',200);
	}

	function ocultarLista() {
		document.all["Cplistado1"].style.visibility='hidden';
	    document.all["CpLin1listado1"].style.visibility='hidden';
	    document.all["CpLin2listado1"].style.visibility='hidden';
	    document.all["CpLin3listado1"].style.visibility='hidden';
	    document.all["CpLin4listado1"].style.visibility='hidden';

	    document.all["primera1Div"].style.visibility='hidden';
	    document.all["ret1Div"].style.visibility='hidden';
	    document.all["ava1Div"].style.visibility='hidden';
	    document.all["separaDiv"].style.visibility='hidden';

	    setTimeout('eval (ON_RSZ);',200);
    }

	function mostrarLista() {
	    DrdEnsanchaConMargenDcho('listado1',12);

		document.all["Cplistado1"].style.visibility='visible';
	    document.all["CpLin1listado1"].style.visibility='visible';
	    document.all["CpLin2listado1"].style.visibility='visible';
	    document.all["CpLin3listado1"].style.visibility='visible';
	    document.all["CpLin4listado1"].style.visibility='visible';

	    document.all["primera1Div"].style.visibility='visible';
	    document.all["ret1Div"].style.visibility='visible';
	    document.all["ava1Div"].style.visibility='visible';
	    document.all["separaDiv"].style.visibility='visible';

	    setTimeout('eval (ON_RSZ);',200);
    }

	 // Autocompletar Cod de cliente
    function onchange_codCliente(){
		var codCliente = get('frmFormulario.txtCodigoCliente');
		if (codCliente.length != 0)  {
				  codigoCompleto = validarLongCodCliene(codCliente);
				  //set('frmFormulario.hIndicadorBusquedaCliente','C');
				  set('frmFormulario.txtCodigoCliente', codigoCompleto);	
				  
				  set('frmFormulario.conectorAction', 'LPCrearGestion');
				  set('frmFormulario.accion', 'validarCliente');
				  eval('frmFormulario').oculto = 'S';
				  enviaSICC('frmFormulario', '', '', 'N');   

				  
		}
    }

	function asignarDatosCliente(oidCliente){
		set('frmFormulario.hOidCliente', oidCliente);	
	}

	function errorCliente(){
	    set('frmFormulario.hOidCliente', '');
		set('frmFormulario.txtCodigoCliente', '');
		focaliza("frmFormulario.txtCodigoCliente");
	}


	function validarLongCodCliene(codCliente) {
		var longiCod = get('frmFormulario.hLongitudCodCliente');
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


    // Busqueda rapida de cliente
	function accionBuscarCliente() {

          var oid;
          var obj = new Object();
          var whnd = mostrarModalSICC('LPBusquedaRapidaCliente','',obj);

          if(whnd!=null){

              var oid = whnd[0];
              var cod = whnd[1];
              var nombre1 = whnd[2];
              var apellido1 = whnd[4];

              set("frmFormulario.txtCodigoCliente", cod);
              set("frmFormulario.hOidCliente", oid);
		  }
    }


	function buscarOnClick() {

	    //ocultarLista();

		// Prepara los filtros
		var arrDatos = new Array();
        var i=0;
        
        arrDatos[i] = new Array('oidPais',get('frmFormulario.hPais'));
		i++;
		arrDatos[i] = new Array('oidIdioma',get('frmFormulario.hIdioma'));
		i++;
		arrDatos[i] = new Array('codigoCliente', get('frmFormulario.txtCodigoCliente'));
		i++;
		arrDatos[i] = new Array('estadoAsignacion', get('frmFormulario.cbEstado'));
		i++;

        // Invoca a la busqueda
		configurarPaginado(mipgndo,'COBBuscarConsultorasPorGestionPago','ConectorBuscarConsultorasPorGestionPago',
            'es.indra.sicc.dtos.cob.DTOEBuscarConsultorasTelecobranza',arrDatos);
	}

	function muestraLista( ultima, rowset, error){

		if (rowset.length > 0){
				  mostrarLista();
				  return true;
		} else {
			   
		  ocultarLista();
		 // cdos_mostrarAlert(error);
		  return false;
		 }
    }



	function fLimpiar(){
      
	  set('frmFormulario.hOidCliente','');

	  if(get('frmFormulario.accion')==""){
		focaliza("frmFormulario.txtCodigoCliente");
	  } else {
		focaliza("frmFormulario.cbEstado");
	  }
	  
	}


	// Control de TAB
	function focalizaShTab(tab){
	    if(tab==1){
			focalizaBotonHTML('botonContenido','btnBuscar');
		} else if(tab==2 && get('frmFormulario.accion')==""){
			focaliza("frmFormulario.txtCodigoCliente");
		} else if(tab==2 && get('frmFormulario.accion')!=""){
			focalizaBotonHTML('botonContenido','btnBuscar');
		}
	}

	
	function focalizaTab(){
		if(get('frmFormulario.accion')==""){
			focaliza("frmFormulario.txtCodigoCliente");
		}else {
			focaliza("frmFormulario.cbEstado");
		}
	}

	function fVolver(){	
		window.close();
	}

