 function onLoadPag(){
	
	  configurarMenuSecundario('frmFormulario');
      
	
	 // [1] ocultarListaAcciones();
	 // [1] ocultarListaConsultoras();
	 // [1] visibilidad('capa3', 'O'); 

	  //[1] llenarProcesos();

      set('frmFormulario.cbMarca', [get('frmFormulario.hCbMarca')]);
      set('frmFormulario.cbCanal', [get('frmFormulario.hCbCanal')]);

  
	   recargaPeriodo();
       muestraTotales('0','0');

	   focaliza("frmFormulario.cbEtapa");
	   setTimeout('llenarProcesos();',200); //[1]
	   setTimeout('fMostrarMensajeError();',200); //[1]
	
	}

	function llenarProcesos(){
		opciones = new Array();

		/*  - LLamada con IVR
			- Crear Gestión
			- Consultar Datos Cliente
			- Consultar Consultoras por Compromiso de Pago
			- Consultar Consultoras por Tipo de Acción
			- Consultar Consultoras por Gestión de Pago
			- Consultar Histórico Deuda
			- Consultar Histórico Cobranza
			- Consultar Guías Argumentales
		*/

        opciones[0] = ['', ''];
		opciones[1] = ['LlamarIVR', GestionarMensaje('1475')];
		opciones[2] = ['LPCrearGestion', GestionarMensaje('1476')];
		opciones[3] = ['LPConsultarDatosCliente', GestionarMensaje('1477')];
		opciones[4] = ['LPConsultarConsultorasPorCPago', GestionarMensaje('1478')];
		opciones[5] = ['LPConsultarConsultorasPorTipoAccion', GestionarMensaje('1479')];
		opciones[6] = ['LPConsultarConsultorasPorGestionPago', GestionarMensaje('1480')];
//		opciones[7] = ['LPConsultarHistoricoDeuda', GestionarMensaje('1481')];
		opciones[7] = ['CCCConsultaCC', GestionarMensaje('1481')];
		opciones[8] = ['LPConsultarHistoricoCobranza', GestionarMensaje('1482')];
		opciones[9] = ['CobGuionArgumDetalLPStartUpQuery', GestionarMensaje('1483')];
						
		set_combo('frmFormulario.cbEjecucion',opciones); 
	}


	function ocultarListaConsultoras() {

		if (document.all["Cplistado1"].style.visibility != 'hidden'){
			document.all["Cplistado1"].style.visibility='hidden';
			document.all["CpLin1listado1"].style.visibility='hidden';
			document.all["CpLin2listado1"].style.visibility='hidden';
			document.all["CpLin3listado1"].style.visibility='hidden';
			document.all["CpLin4listado1"].style.visibility='hidden';
			document.all["primera1Div"].style.visibility='hidden';
			document.all["ret1Div"].style.visibility='hidden';
			document.all["ava1Div"].style.visibility='hidden';
			document.all["separa1Div"].style.visibility='hidden';
			document.all["VerAccion1Div"].style.visibility='hidden';
			document.all["EjecutarDiv"].style.visibility='hidden';
		}
		setTimeout('eval (ON_RSZ)',200);//eval (ON_RSZ);  
    }

	function mostrarListaConsultoras() {
	    DrdEnsanchaConMargenDcho('listado1',12);

		if (document.all["Cplistado1"].style.visibility != 'visible'){

			document.all["Cplistado1"].style.visibility='visible';
			document.all["CpLin1listado1"].style.visibility='visible';
			document.all["CpLin2listado1"].style.visibility='visible';
			document.all["CpLin3listado1"].style.visibility='visible';
			document.all["CpLin4listado1"].style.visibility='visible';
			document.all["primera1Div"].style.visibility='visible';
			document.all["ret1Div"].style.visibility='visible';
			document.all["ava1Div"].style.visibility='visible';
			document.all["separa1Div"].style.visibility='visible';
			document.all["VerAccion1Div"].style.visibility='visible';
			document.all["EjecutarDiv"].style.visibility='visible';
		}
		setTimeout('eval (ON_RSZ)',200);//eval (ON_RSZ);  
    }

	function ocultarListaAcciones() {
		if (document.all["Cplistado2"].style.visibility!='hidden'){
		
			document.all["Cplistado2"].style.visibility='hidden';
			document.all["CpLin1listado2"].style.visibility='hidden';
			document.all["CpLin2listado2"].style.visibility='hidden';
			document.all["CpLin3listado2"].style.visibility='hidden';
			document.all["CpLin4listado2"].style.visibility='hidden';
			document.all["primera2Div"].style.visibility='hidden';
			document.all["ret2Div"].style.visibility='hidden';
			document.all["ava2Div"].style.visibility='hidden';
			document.all["separa2Div"].style.visibility='hidden';
			document.all["Detalle2Div"].style.visibility='hidden';
			document.all["CompromisoPago2Div"].style.visibility='hidden';
		}
		setTimeout('eval (ON_RSZ)',200);//eval (ON_RSZ);  
		
    }

	function mostrarListaAcciones() {
	    DrdEnsanchaConMargenDcho('listado2',12);

		if (document.all["Cplistado2"].style.visibility!='visible'){

			document.all["Cplistado2"].style.visibility='visible';
			document.all["CpLin1listado2"].style.visibility='visible';
			document.all["CpLin2listado2"].style.visibility='visible';
			document.all["CpLin3listado2"].style.visibility='visible';
			document.all["CpLin4listado2"].style.visibility='visible';
			document.all["primera2Div"].style.visibility='visible';
			document.all["ret2Div"].style.visibility='visible';
			document.all["ava2Div"].style.visibility='visible';
			document.all["separa2Div"].style.visibility='visible';
			document.all["Detalle2Div"].style.visibility='visible';
			document.all["CompromisoPago2Div"].style.visibility='visible';
		}
		//setTimeout('eval (ON_RSZ)',200);//eval (ON_RSZ);  
    }

function recargaPeriodo(){
    var canal = get('frmFormulario.cbCanal');
    var marca = get('frmFormulario.cbMarca');
    if( canal != '' && marca != ''){
        recargaCombo('frmFormulario.cbPeriodo', 'CRAObtienePeriodos', 
            'es.indra.sicc.dtos.cra.DTOPeriodo', 
            [['pais', get('frmFormulario.hPais')], 
             ['marca', marca], 
             ['canal', canal]]);
        recargaCombo('frmFormulario.cbRegion', 'ZONRecargaRegiones', 
            'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa',
            [['oidPais', get('frmFormulario.hPais')], 
             ['oidIdioma', get('frmFormulario.hIdioma')], 
             ['oidMarca', marca], 
             ['oidCanal', canal]]);

    } else {        
        set_combo('frmFormulario.cbPeriodo', arrayVacio());
        set_combo('frmFormulario.cbRegion', arrayVacio());
    }
}

	function arrayVacio(){  
      var array = new Array();             
          array[0] = new Array('','');
  
      return array;
    }

	function marcaOnChange(){
		recargaPeriodo();
	}

	function canalOnChange(){
		recargaPeriodo();
	}


    function buscarOnClick(){

	// Prepara los filtros
		var arrDatos = new Array();
        var i=0;
        
        arrDatos[i] = new Array('oidPais',get('frmFormulario.hPais'));
		i++;
		arrDatos[i] = new Array('oidIdioma',get('frmFormulario.hIdioma'));
		i++;
		arrDatos[i] = new Array('etapaDeuda', get('frmFormulario.cbEtapa'));
		i++;
		arrDatos[i] = new Array('marca', get('frmFormulario.cbMarca'));
		i++;
		arrDatos[i] = new Array('canal', get('frmFormulario.cbCanal'));
		i++;
		arrDatos[i] = new Array('periodo', get('frmFormulario.cbPeriodo'));
		i++;
		arrDatos[i] = new Array('paginado', true);
		i++;
		arrDatos[i] = new Array('ordenacion', get('frmFormulario.cbOrdenacion'));
		i++;
        if(get('frmFormulario.cbRegion')!=''){
            arrDatos[arrDatos.length] = new Array('region', get('frmFormulario.cbRegion'));
        }
		// [1] mostrarListaConsultoras();
		// alert(arrDatos);
        // Invoca a la busqueda
		configurarPaginado(mipgndo1,'COBBuscarAsignacionesCobranzaTC','ConectorBuscarAsignacionesCobranzaTC',
            'es.indra.sicc.dtos.cob.DTOAsignacionesCobranza',arrDatos);
            
        // Invocar calculo de totales
        txt_to('lblValNumConsultoras','0');
        txt_to('lblValSaldoXCobrar','0');

		set('frmFormulario.conectorAction','LPRealizarSeguimientoTelecobranza');
		set('frmFormulario.accion','ObtenerTotales');
		frmFormulario.oculto = 'S';
		enviaSICC('frmFormulario');
		
		ocultarListaAcciones();
	}


	function verAccionOnClick(){
		var codigo = listado1.codSeleccionados();

		//alert(codigo);
		

		if (codigo.length > 1) {
			    GestionarMensaje('1022');
				return;
		}
		if(codigo.length < 1 ){
				GestionarMensaje('4');
				return;
	    }
					

	    if(codigo != ''){	

		        var etapaDeuda = listado1.extraeDato(codigo, 23);
				var periodo = listado1.extraeDato(codigo, 24);
				var codigoCliente = listado1.extraeDato(codigo, 1);
				 
				//alert("etapaDeuda: " + etapaDeuda);
				//alert("periodo: " + periodo);
			    //alert("codigoCliente: " +codigoCliente);

				// Prepara los filtros
				var arrDatos = new Array();
				var i=0;
				
				arrDatos[i] = new Array('oidPais',get('frmFormulario.hPais'));
				i++;
				arrDatos[i] = new Array('oidIdioma',get('frmFormulario.hIdioma'));
				i++;
				arrDatos[i] = new Array('etapaDeuda', etapaDeuda);
				i++;
				arrDatos[i] = new Array('codCliente', codigoCliente);
				i++;		
				arrDatos[i] = new Array('periodo', periodo);
				i++;

				//alert(arrDatos);

				

				// Invoca a la busqueda
				configurarPaginado(mipgndo2,'COBBuscarGestionesDeCobranzaTC','ConectorBuscarGestionesDeCobranzaTC',
					'es.indra.sicc.dtos.cob.DTOBuscarGestionesDeCobranza',arrDatos);


		}else{
			
		}

	}


	function ejecutarOnClick(){
		
		var filaLista;
		lp = get('frmFormulario.cbEjecucion');
		modal = false;

		if( lp != '' ){
			var obj = new Object();		
			
			// Opciones a ejecutar
			if(lp=='LPCrearGestion'){
			    modal= true;
				obj.accion = 'ejecutarSeguimientoTel';	

				/*inicio modificado ciglesias incidencia BELC300024442*/
                var codigo = listado1.codSeleccionados();
				if( codigo != '' ){
					filaLista = DrIndiceEnArray(listado1.datos,codigo,0);
					obj.oidEtapa = listado1.extraeDato(codigo,23);
					obj.oidCliente = listado1.extraeDato(codigo,27);
					obj.codigoCliente = listado1.extraeDato(codigo,1);
					obj.oidPeriodo = listado1.extraeDato(codigo,24);
					obj.oidMarca = listado1.extraeDato(codigo,30);
					obj.oidCanal = listado1.extraeDato(codigo,31);
					obj.oidTipoCargoAbono = listado1.extraeDato(codigo,32);
				}
				/*fin modificado ciglesias incidencia BELC300024442*/

			} else if(lp=='CobGuionArgumDetalLPStartUpQuery'){
			    modal= true;
				obj.accion = '';
			} else if(lp=='LlamarIVR'){
                var codigo = listado1.codSeleccionados();

				if( codigo != '' ){
				  /*set('frmFormulario.hOidUsuarioCobranza', listado1.extraeDato(codigo,22));    
					set('frmFormulario.hOidTipoCargoAbonoUltimo', listado1.extraeDato(codigo,23));    
					set('frmFormulario.hOidCliente', listado1.extraeDato(codigo,24));
					set('frmFormulario.hOidRegion', listado1.extraeDato(codigo,25));
					set('frmFormulario.hOidZona', listado1.extraeDato(codigo,26));
					set('frmFormulario.hTelefono1', listado1.extraeDato(codigo,4));    
					set('frmFormulario.hOidPeriodo', listado1.extraeDato(codigo,21));    
					set('frmFormulario.hOidEtapadeuda', listado1.extraeDato(codigo,20));    
					set('frmFormulario.conectorAction','LPRealizarSeguimientoTelecobranza');
					set('frmFormulario.accion','LlamarIVR');
					eval('frmFormulario').oculto = 'S';
					enviaSICC('frmFormulario');
					*/
					filaLista = DrIndiceEnArray(listado1.datos,codigo,0);

					var objParamsEnvia = new Object();
					var listaPams = new Object();
					objParamsEnvia.opener = window;
					objParamsEnvia.destino ='LPRealizarSeguimientoTelecobranza';
					objParamsEnvia.conectorAction= 'LPRealizarSeguimientoTelecobranza';
					objParamsEnvia.accion= 'LlamarIVR';
					/*listaPams.hOidUsuarioCobranza = listado1.extraeDato(codigo,22); 
					listaPams.hOidTipoCargoAbonoUltimo = listado1.extraeDato(codigo,23);
					listaPams.hOidCliente = listado1.extraeDato(codigo,24);
					listaPams.hOidRegion = listado1.extraeDato(codigo,25);
					listaPams.hOidZona = listado1.extraeDato(codigo,26);
					listaPams.hTelefono1 = listado1.extraeDato(codigo,4);
					listaPams.hOidPeriodo = listado1.extraeDato(codigo,21);
					listaPams.hOidEtapadeuda = listado1.extraeDato(codigo,20);*/
					listaPams.hOidUsuarioCobranza = listado1.datos[filaLista][26];
					listaPams.hOidTipoCargoAbonoUltimo = listado1.datos[filaLista][27];
					listaPams.hOidCliente = listado1.datos[filaLista][28];
					listaPams.hOidRegion = listado1.datos[filaLista][29];
					listaPams.hOidZona = listado1.datos[filaLista][30];
					listaPams.hTelefono1 = listado1.datos[filaLista][4];
					listaPams.hOidPeriodo = listado1.datos[filaLista][25];
					listaPams.hOidEtapadeuda = listado1.datos[filaLista][24];
					objParamsEnvia.parametros = listaPams;

					setValues(objParamsEnvia);


				}else{
					GestionarMensaje('8', null, null, null);
				}

                
			} else if(lp=='LPConsultarConsultorasPorGestionPago' || lp=='LPConsultarDatosCliente' || lp=='CCCConsultaCC'
			          || lp=='LPConsultarHistoricoCobranza' || lp=='LPConsultarConsultorasPorTipoAccion' || lp=='LPConsultarConsultorasPorCPago'){

				var codigo = listado1.codSeleccionados();

				if( codigo != '' ){
				    modal= true;
					filaLista = DrIndiceEnArray(listado1.datos,codigo,0);

					if(lp=='LPConsultarConsultorasPorGestionPago') {
						obj.accion = 'clienteSeleccionado';
						obj.txtCodigoCliente = listado1.datos[filaLista][2];
					}
					
					if(lp=='LPConsultarDatosCliente') {
						obj.accion = '';
						obj.codigoCliente = listado1.datos[filaLista][2];
					}
					
					if(lp=='CCCConsultaCC' || lp=='LPConsultarHistoricoCobranza' || lp=='LPConsultarConsultorasPorCPago'
					   || lp=='LPConsultarConsultorasPorTipoAccion'){
						obj.accion = 'clienteSeleccionado';
						obj.codigoCliente = listado1.datos[filaLista][2];
						obj.codCliente = obj.codigoCliente;
					}


				}else{
					GestionarMensaje('8', null, null, null);
				}
			} 
			
			if(modal) {
				var retorno = mostrarModalSICC(lp, obj.accion, obj, null, null);
				//alert("retorne ejecutar");
			}

		}
	}


	function detalleOnClick(){
	    var valorSeleccionado = listado2.codSeleccionados();

		if( valorSeleccionado != '' ){
			var obj = new Object();
			obj.hOidGestionCobranza = valorSeleccionado;
			obj.accion = 'detalle';
			var retorno = mostrarModalSICC('LPConsultarConsultorasPorTipoAccion', 'detalle', obj, null, null);
			
			//alert("retorne detalle");

		}else{
			GestionarMensaje('8', null, null, null);
		}
		
	}

	function compromisoPagoOnClick(){
		var valorSeleccionado = listado2.codSeleccionados();

		if( valorSeleccionado != '' ){
			var obj = new Object();			
			obj.hOidGestionCobranza = valorSeleccionado;
			obj.accion = 'compromisoPago';
			var retorno = mostrarModalSICC('LPConsultarConsultorasPorTipoAccion', 'compromisoPago', obj, null, null);
			
			//alert("retorne compromisoPago");

		}else{
			GestionarMensaje('8', null, null, null);
		}
	}


	function fLimpiar(){
      
	  set('frmFormulario.cbEtapa', ['']);
	  set('frmFormulario.cbOrdenacion', ['']);
	  set('frmFormulario.cbMarca', [get('frmFormulario.hCbMarca')]);
	  set('frmFormulario.cbCanal', [get('frmFormulario.hCbCanal')]);

	  recargaPeriodo();

	  if(get_visibilidad('capa3')){
		  set('frmFormulario.cbEjecucion', ['']);
	  }
		
	  focaliza("frmFormulario.cbEtapa");	 

	}


	function focalizaTab(tab){
		var visCapa3= get_visibilidad('capa3'); //[1]
	    if(tab==1 && visCapa3==false) {//[1] get_visibilidad('capa3')==false) {
			focaliza("frmFormulario.cbEtapa");	 
		} else if(tab==1 &&  visCapa3==true) {//[1] get_visibilidad('capa3')==true) {
			focalizaBotonHTML_XY('VerAccion1');
		} else if(tab==2 && document.all.Cplistado2.style.visibility == "hidden") {
			focaliza("frmFormulario.cbEtapa");	 
		} else if(tab==2 && document.all.Cplistado2.style.visibility != "hidden") {
			focalizaBotonHTML_XY('Detalle2');
		} else if(tab==3){
			focaliza("frmFormulario.cbEtapa");	
		} else if(tab==4){//  [1] Casos especiales
			focaliza("frmFormulario.cbEjecucion");       
		} else if(tab==5){
			focalizaBotonHTML_XY('Ejecutar');
		}
		
	}

	function focalizaShTab(tab){
		var visCapa3= get_visibilidad('capa3'); //[1]
		if(tab==1 && !visCapa3){//[1] !get_visibilidad('capa3')){
			focalizaBotonHTML('botonContenido','btnBuscar');
		}else if(tab==1 &&  visCapa3 ==true && document.all.Cplistado2.style.visibility == "hidden"){//[1] get_visibilidad('capa3')==true && document.all.Cplistado2.style.visibility == "hidden"){
			focalizaBotonHTML_XY('Ejecutar');
		} else if(tab==1 && visCapa3==true && document.all.Cplistado2.style.visibility != "hidden"){//[1] get_visibilidad('capa3')==true && document.all.Cplistado2.style.visibility != "hidden"){
			focalizaBotonHTML_XY('CompromisoPago2');
		} else if(tab==2){
			focalizaBotonHTML('botonContenido','btnBuscar');
		} else if(tab==3){
			focalizaBotonHTML('botonContenido','Ejecutar');
		} else if(tab==4){  // [1] Casos especiales
			focaliza("frmFormulario.cbEjecucion");  
		} else if(tab==5){			
			focalizaBotonHTML_XY('VerAccion1');
		}

    }


  function muestraLista( ultima, rowset){   
    if (rowset.length > 0){
	  mostrarListaConsultoras();
	  visibilidad('capa3', 'V');
	  return true;
    }else{
	  ocultarListaConsultoras();
	  visibilidad('capa3', 'O');
	  return false;
	}
  }  

function setValues(objParams){
	if(objParams.parametros){

		var atributos;
		//Limpio todos los campos insertados del frm que envio
		eliminaElementosDinamicos();
		for(atributos in objParams.parametros){
			if(atributos != "window" && atributos != "length"){
				var hidden = document.createElement("INPUT");
				hidden.type = "hidden";
				hidden.insertado = "1";
				hidden.name = atributos;
				hidden.value = (objParams.parametros[atributos]==null)?"":objParams.parametros[atributos];
				document.forms["frmFormularioEnviar"].appendChild(hidden);
			}
		}
		set('frmFormularioEnviar.conectorAction', objParams.conectorAction);
		set('frmFormularioEnviar.accion', objParams.accion);
		enviaSICC("frmFormularioEnviar");
	}
	
}

function eliminaElementosDinamicos(){
	var elementos = document.forms["frmFormularioEnviar"].elements;
	var longitud = elementos.length;
	for ( i = 0;i < longitud; i++ ){
		var oChild=document.forms["frmFormularioEnviar"].children(i);	
		if (oChild!= null && oChild.insertado=="1"){
			document.forms["frmFormularioEnviar"].removeChild(oChild);
			i = i-1;
		}
	}
}

function muestraTotales(totalConsultoras,totalSaldoXCobrar){
    txt_to('lblValNumConsultoras',totalConsultoras);
    txt_to('lblValSaldoXCobrar',totalSaldoXCobrar);
}

function errorEnTotales(){
    alert('Error');
}
 function muestraLista2( ultima, rowset){   
    if (rowset.length > 0){
			 mostrarListaAcciones();
			 eval(ON_RSZ);
			 return true;
    }else{
			ocultarListaAcciones();			
			return false;
	}
  }  