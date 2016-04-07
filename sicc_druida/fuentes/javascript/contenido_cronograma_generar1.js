
	var idVista = "";
	var objActividadClick=null;

	function onLoadPag()   {
		try{
			tdContenedor.onresize();
		}catch(e){
			;
		}
		if (document.all.capaBotones) {
			//alert(document.getElementById('capaBotones').innerHTML);
			document.getElementById('miscroll').style.border = '1px solid #999999'
			document.getElementById('capaBotones').style.clip = 'rect(0 100% 21 0)';
			document.getElementById('capaBotones').style.top = '319';
			document.getElementById('capaBotones').style.border = '0';
		}
		configurarMenuSecundario("frmGenerarCronograma");
		set('frmGenerarCronograma.hlblActiFija',GestionarMensaje('1002'));
		set('frmGenerarCronograma.hlblActiRefe',GestionarMensaje('1003'));

		if (get('frmGenerarCronograma.hMostrarFuera') == '1') {
        if (get('frmGenerarCronograma.hEsZona') != '1') {
            document.all.CpScrolllistado2.attachEvent ('onpropertychange', verificaResultado);
        }
        mostrarListaFuera();
        mostrarListaReferenciaPeridos();
		} else {
        ocultarListaFuera();
        ocultarListaReferenciaPeriodos();
    }
    inicializaCombos();

	  mostrarCodigoError();

		focaliza('frmGenerarCronograma.cbMarcas');

	}

  function verificaResultado() {
      if (event.propertyName == "innerHTML") {
          listado2.txtCab[0] = GestionarMensaje(1244);
          //alert(listado2.txtCab);
      }
  }


  function errorExiste() {
   		focaliza('frmGenerarCronograma.cbMarcas');
  }

  function mostrarCodigoError() {  
	     
		  var vErrCodigo = get('frmGenerarCronograma.errCodigo');
		  var vErrDescrip = get('frmGenerarCronograma.errDescripcion');

		  if (get('frmGenerarCronograma.errDescripcion')!=''){
      		var wnd = fMostrarMensajeError( vErrCodigo,vErrDescrip);
				btnProxy(1, '1');
	     }		
   }

	function inicializaCombos() {
		var aCombo = new Array();         
		aCombo[0] = get('frmGenerarCronograma.hMarca');	       
		set('frmGenerarCronograma.cbMarcas',aCombo);      

		aCombo[0] = get('frmGenerarCronograma.hCanal');	       
		set('frmGenerarCronograma.cbCanales',aCombo);      

		set('frmGenerarCronograma.txtCodPeriod',get('frmGenerarCronograma.hCodPeriodo'));     

    if (get('frmGenerarCronograma.hPaisDesc') != "") {
  			txt_to("lblCodPais",get('frmGenerarCronograma.hPaisDesc'));
    }

	   setMV('frmGenerarCronograma.cbMarcas','N');
	   setMV('frmGenerarCronograma.cbCanales','N');
	   setMV('frmGenerarCronograma.txtCodPeriod','N');

	}

  function fLimpiar() {
        if (get('frmGenerarCronograma.hPaisDesc') != "") {
        		txt_to("lblCodPais",get('frmGenerarCronograma.hPaisDesc'));
        }
  }

	function vueltaGenerica(existe) {
        //alert("volvio");
		if (existe == '1') { //Se encontro el cronograma
            //var acepta = cdos_mostrarConfirm("El cronograma existe. Desea Continuar?.");
			var acepta = GestionarMensaje("1229");
			if (acepta){
				//obtieneTipoFacturacion();
                genera();
            }
		} else {
			//obtieneTipoFacturacion();
            genera();
		}
	}

    //No se usa mas, inc. 17371, se reemplaza por genera().
	function obtieneTipoFacturacion() {
		generarArrayDiasSemana();
		generarArrayMeses();
		set('frmGenerarCronograma.accion', 'obtieneTiposFacturacion');
		set('frmGenerarCronograma.conectorAction', 'LPMantieneCronograma');
		set('frmGenerarCronograma.hMarca', get('frmGenerarCronograma.cbMarcas'));
		set('frmGenerarCronograma.hCanal', get('frmGenerarCronograma.cbCanales'));
		set('frmGenerarCronograma.hCodPeriodo', get('frmGenerarCronograma.txtCodPeriod'));
		set('frmGenerarCronograma.hlblActiFija',GestionarMensaje('1002'));
		set('frmGenerarCronograma.hlblActiRefe',GestionarMensaje('1003'));
		//if (get('frmGenerarCronograma.casoDeUso') != 'Fase 2')
			eval("frmGenerarCronograma.oculto = 'N'");
		enviaSICC('frmGenerarCronograma');
	}


    function genera(){
		generarArrayDiasSemana();
		generarArrayMeses();
    
    
    
		set('frmGenerarCronograma.accion', 'generaFase1');
		set('frmGenerarCronograma.conectorAction', 'LPMantieneCronograma');
		eval("frmGenerarCronograma.oculto = 'N'");
		enviaSICC('frmGenerarCronograma');
    }


	function fGuardar() {
		set('frmGenerarCronograma.accion', 'guardaCronograma');
		set('frmGenerarCronograma.casoDeUso', 'GenerarCronograma');
		set('frmGenerarCronograma.conectorAction', 'LPMantieneCronograma');
		set('frmGenerarCronograma.hMarca', get('frmGenerarCronograma.hMarca'));
		set('frmGenerarCronograma.hCanal', get('frmGenerarCronograma.hCanal'));
		set('frmGenerarCronograma.hCodPeriodo', get('frmGenerarCronograma.hCodPeriodo'));
		//eval("frmGenerarCronograma.oculto = 'S'"); 
		eval("frmGenerarCronograma.oculto = 'N'"); 
		enviaSICC('frmGenerarCronograma');
	}


  function mostrarListaFuera() {
    DrdEnsanchaConMargenDcho('listado2',12);

	 document.all["Cplistado2"].style.visibility='';
    document.all["CpLin1listado2"].style.visibility='';
    document.all["CpLin2listado2"].style.visibility='';
    document.all["CpLin3listado2"].style.visibility='';
    document.all["CpLin4listado2"].style.visibility='';

    document.all["primera2Div"].style.visibility='';
    document.all["ret2Div"].style.visibility='';
    document.all["ava2Div"].style.visibility='';
    document.all["separa2Div"].style.visibility='';

    eval (ON_RSZ);  
   }

  function ocultarListaFuera() {
	 document.all["Cplistado2"].style.visibility='hidden';
    document.all["CpLin1listado2"].style.visibility='hidden';
    document.all["CpLin2listado2"].style.visibility='hidden';
    document.all["CpLin3listado2"].style.visibility='hidden';
    document.all["CpLin4listado2"].style.visibility='hidden';

    document.all["primera2Div"].style.visibility='hidden';
    document.all["ret2Div"].style.visibility='hidden';
    document.all["ava2Div"].style.visibility='hidden';
    document.all["separa2Div"].style.visibility='hidden';
    document.all["btnCambiarFecha2"].style.visibility='hidden';

   }


  function mostrarListaReferenciaPeridos() {
		DrdEnsanchaConMargenDcho('listado3',12);
		document.all["Cplistado3"].style.visibility='';
		document.all["CpLin1listado3"].style.visibility='';
		document.all["CpLin2listado3"].style.visibility='';
		document.all["CpLin3listado3"].style.visibility='';
		document.all["CpLin4listado3"].style.visibility='';

		document.all["primera3Div"].style.visibility='';
		document.all["ret3Div"].style.visibility='';
		document.all["ava3Div"].style.visibility='';
		document.all["separa3Div"].style.visibility='';

		eval (ON_RSZ);  
   }


  function ocultarListaReferenciaPeriodos() {
		document.all["Cplistado3"].style.visibility='hidden';
		document.all["CpLin1listado3"].style.visibility='hidden';
		document.all["CpLin2listado3"].style.visibility='hidden';
		document.all["CpLin3listado3"].style.visibility='hidden';
		document.all["CpLin4listado3"].style.visibility='hidden';

		document.all["primera3Div"].style.visibility='hidden';
		document.all["ret3Div"].style.visibility='hidden';
		document.all["ava3Div"].style.visibility='hidden';
		document.all["separa3Div"].style.visibility='hidden';
		document.all["btnCambiarFecha3"].style.visibility='hidden';
   }


	function seleccionaActividad(id) {
		idVista = id;
		//ver el manejo del color al seleccionar la actividad (Incidencia 4460)
		if(objActividadClick!=null){
			objActividadClick.style.color = objActividadClick.normalColor;
		}
		objActividadClick = event.srcElement;
		objActividadClick.normalColor = objActividadClick.style.color;
		objActividadClick.style.color = "#0000FF";
	}

	function Generar() {
		//alert("Existe Gen: "+get('frmGenerarCronograma.hExisteCrono'));
		if (!sicc_validaciones_generales("grupo1"))
			return;
		set('frmGenerarCronograma.accion', 'existeFase');
		set('frmGenerarCronograma.conectorAction', 'LPMantieneCronograma');
		set('frmGenerarCronograma.hMarca', get('frmGenerarCronograma.cbMarcas'));
		set('frmGenerarCronograma.hCanal', get('frmGenerarCronograma.cbCanales'));
		set('frmGenerarCronograma.hCodPeriodo', get('frmGenerarCronograma.txtCodPeriod'));
		enviaSICC('frmGenerarCronograma');
	}

	function cambiarFecha() {
		//alert("Cambio fecha"+idVista);
		if (idVista == "") {
			GestionarMensaje('407');
			return;
		}
		set('frmGenerarCronograma.accion', 'modificaFechaActividad');
		set('frmGenerarCronograma.conectorAction', 'LPMantieneCronograma');
		set('frmGenerarCronograma.hMarca', get('frmGenerarCronograma.hMarca'));
		set('frmGenerarCronograma.hCanal', get('frmGenerarCronograma.hCanal'));
		set('frmGenerarCronograma.hCodPeriodo', get('frmGenerarCronograma.hCodPeriodo'));
		set('frmGenerarCronograma.hIdVista', idVista);
		enviaSICC('frmGenerarCronograma');
	}

  function camFechFuera() {
      if (listado2.numSelecc() == 1)
      {		
          var arrAux = new Array();
          arrAux = listado2.codSeleccionados();
          var posicion = obtenerPosicionListaEditable(listado2.codSeleccionados(),listado2);		
          set('frmGenerarCronograma.accion', 'modificaFechaActividad');
          set('frmGenerarCronograma.conectorAction', 'LPMantieneCronograma');
          set('frmGenerarCronograma.hMarca', get('frmGenerarCronograma.hMarca'));
          set('frmGenerarCronograma.hCanal', get('frmGenerarCronograma.hCanal'));
          set('frmGenerarCronograma.hCodPeriodo', get('frmGenerarCronograma.hCodPeriodo'));
          var idVistaFuera = listado2.datos[posicion][7];
          set('frmGenerarCronograma.hIdVista', idVistaFuera);
          enviaSICC('frmGenerarCronograma');
      } else {
           GestionarMensaje('4');
           focalizaBotonHTML('botonContenido','btnCambiarFecha2');
           return;
      }
  }   

  function camFechRefeOtroPeri() {
      if (listado3.numSelecc() == 1)
      {		
          var arrAux = new Array();
          arrAux = listado3.codSeleccionados();
          var posicion = obtenerPosicionListaEditable(listado3.codSeleccionados(),listado3);		
          set('frmGenerarCronograma.accion', 'modificaFechaActividad');
          set('frmGenerarCronograma.conectorAction', 'LPMantieneCronograma');
          set('frmGenerarCronograma.hMarca', get('frmGenerarCronograma.hMarca'));
          set('frmGenerarCronograma.hCanal', get('frmGenerarCronograma.hCanal'));
          set('frmGenerarCronograma.hCodPeriodo', get('frmGenerarCronograma.hCodPeriodo'));
          var idVistaRefeOtroPeri = listado3.datos[posicion][8];
          set('frmGenerarCronograma.hIdVista', idVistaRefeOtroPeri);
          enviaSICC('frmGenerarCronograma');
      } else {
           GestionarMensaje('4');
           focalizaBotonHTML('botonContenido','btnCambiarFecha3');
           return;
      }
  }   
  

	function aceptaModificaFecha(esFija, idV) {
		//alert("aceptaModificaFecha");
		if (esFija == '1') { //Es actividad fija
			var acepta = GestionarMensaje("1288");
			if (acepta) 
				modificaFecha(idV);
		} else {
			modificaFecha(idV);			
		}
	}

	function modificaFecha(idV) {
		set('frmGenerarCronograma.accion', 'aceptaModificarFija');
		set('frmGenerarCronograma.conectorAction', 'LPMantieneCronograma');
		set('frmGenerarCronograma.hMarca', get('frmGenerarCronograma.hMarca'));  //Por si cambian el combo y despues hacen modificar fecha sin generar
		set('frmGenerarCronograma.hCanal', get('frmGenerarCronograma.hCanal'));  //Idem
		set('frmGenerarCronograma.hCodPeriodo', get('frmGenerarCronograma.hCodPeriodo'));  //Idem
		//set('frmGenerarCronograma.hIdVista', idVista);
		set('frmGenerarCronograma.hIdVista', idV);
		eval("frmGenerarCronograma.oculto = 'N'");
		enviaSICC('frmGenerarCronograma');
	}

	function generarArrayMeses() {
		var meses = '';
		var i;
		for(i = 0; i < 12; i++) {
			meses = meses + GestionarMensaje((1231+i)+'');
			if (i < 11) 
				meses = meses + '|';
		}
		set('frmGenerarCronograma.hVecMeses',meses);
	}

	function generarArrayDiasSemana() {
		var dias = '';
		var i;
		for(i = 0; i < 7; i++) {
			dias = dias + GestionarMensaje((1034+i)+'');
			if (i < 6) 
				dias = dias + '|';
		}
		set('frmGenerarCronograma.hVecDiasSemana',dias);
	}

	function focoTabBotonGenera() {
		if (get_visibilidad('capaTablaGrafica'))
         focalizaBotonHTML('botonContenido','btnCambiarFecha');
		else
			focaliza('frmGenerarCronograma.cbMarcas');
	}

	function focoShTabCbMarcas() {
		if (get_visibilidad('capaTablaGrafica')) {
        if (get('frmGenerarCronograma.hMostrarFuera') == '1') {
            focalizaBotonHTML('botonContenido','btnCambiarFecha3');
        } else {
            focalizaBotonHTML('botonContenido','btnCambiarFecha');
        }
		} else {
         focalizaBotonHTML('botonContenido','btnGenerar');
    }
	}

  function focoTabBtnCrono() {
        if (get('frmGenerarCronograma.hMostrarFuera') == '1') {
            focalizaBotonHTML('botonContenido','btnCambiarFecha2');
        } else {
      			focaliza('frmGenerarCronograma.cbMarcas');
        }
  }
	