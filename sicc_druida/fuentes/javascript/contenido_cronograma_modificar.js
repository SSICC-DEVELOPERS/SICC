	var idVista = "";
	var objActividadClick=null;

	function onLoadPag()   {
		try{
			tdContenedor.onresize();
		}catch(e){
			;
		}
		if (get('frmModificarCronograma.casoDeUso') == "eliminaCronograma")
			document.title = GestionarMensaje('1311');
		else {
			if (get('frmModificarCronograma.casoDeUso') == "consulta")
				document.title = GestionarMensaje('1312');
		}
  		configurarMenuSecundario("frmModificarCronograma");
    	set('frmModificarCronograma.hlblActiFija',GestionarMensaje('1002'));
  		set('frmModificarCronograma.hlblActiRefe',GestionarMensaje('1003'));
	   //document.all["capaTablas"].style.visibility='hidden';
		if (get('frmModificarCronograma.hMostrarCrono') == '1') {
         //document.all["capaTablas"].style.visibility='';
        document.getElementById('miscroll').style.border = '1px solid #999999';
        document.getElementById('capaBotones').style.clip = 'rect(0 100% 23 0)';
        document.getElementById('capaBotones').style.border = '1px solid #999999';
        if (get('frmModificarCronograma.casoDeUso') == 'consulta' ||
           get('frmModificarCronograma.casoDeUso') == 'eliminaCronograma') {
              //document.all["capaBotones"].style.visibility='hidden';
              document.all["btnEliminarActividad2"].style.visibility='hidden';
              document.all["CambiarFecha2"].style.visibility='hidden';
         			listado2.maxSel = 0;
        }
		} else {
        document.all["capaTablas"].style.visibility='hidden';
        btnProxy(1, '0');
		}
		if (get('frmModificarCronograma.hMostrarFuera') == '1') {
			mostrarListaFuera();
			mostrarListaReferenciaPeridos();
			//listado2.maxSel = 0;
		} else {
			ocultarListaFuera();
			ocultarListaReferenciaPeriodos();
			document.all["imgAltoTablas"].height='340';
		}
		inicializaCombos();

		mostrarCodigoError();
		focaliza('frmModificarCronograma.cbPaises');

		if (get('frmModificarCronograma.casoDeUso') == "eliminaCronograma" &&
			 !get_visibilidad('capaTablas')) {
			btnProxy(4, '0');
		}


	}

   function mostrarCodigoError() {  
	     
		  var vErrCodigo = get('frmModificarCronograma.errCodigo');
		  var vErrDescrip = get('frmModificarCronograma.errDescripcion');

		  if (get('frmModificarCronograma.errDescripcion')!=''){
      		var wnd = fMostrarMensajeError( vErrCodigo,vErrDescrip);
	     }		
   }


	function inicializaCombos() {
		var aCombo = new Array();         
		aCombo[0] = get('frmModificarCronograma.hCbPais');	       
		set('frmModificarCronograma.cbPaises',aCombo);      

		aCombo[0] = get('frmModificarCronograma.hMarca');	       
		set('frmModificarCronograma.cbMarcas',aCombo);      

		aCombo[0] = get('frmModificarCronograma.hCanal');	       
		set('frmModificarCronograma.cbCanales',aCombo);      

		set('frmModificarCronograma.txtCodPeriod',get('frmModificarCronograma.hCodPeriodo'));      

		aCombo[0] = get('frmModificarCronograma.hGrupoZona');	       
		set('frmModificarCronograma.cbGrupoZonas',aCombo);      

		aCombo[0] = get('frmModificarCronograma.hSubgerencia');	       
		set('frmModificarCronograma.cbSubgerenciaVentas',aCombo);      

    if (get('frmModificarCronograma.hGrupoZona') != "")
    		accion('frmModificarCronograma.cbSubgerenciaVentas','.disabled=true');
    if (get('frmModificarCronograma.hSubgerencia') != "")
    		accion('frmModificarCronograma.cbGrupoZonas','.disabled=true');

		aCombo[0] = get('frmModificarCronograma.hRegion');	       
		set('frmModificarCronograma.cbRegion',aCombo);      

		aCombo[0] = get('frmModificarCronograma.hZona');	       
		set('frmModificarCronograma.cbZona',aCombo);      

	   setMV('frmModificarCronograma.cbPaises','N');
	   setMV('frmModificarCronograma.cbMarcas','N');
	   setMV('frmModificarCronograma.cbCanales','N');
	   setMV('frmModificarCronograma.txtCodPeriod','N');

	}


	function mostrarListaFuera() {
    //DrdEnsanchaConMargenDcho('listado1',24);
    DrdEnsanchaConMargenDcho('listado2',24);

    /*document.all["Cplistado1"].style.visibility='';
    document.all["CpLin1listado1"].style.visibility='';
    document.all["CpLin2listado1"].style.visibility='';
    document.all["CpLin3listado1"].style.visibility='';
    document.all["CpLin4listado1"].style.visibility='';*/
    
    document.all["Cplistado2"].style.visibility='';
    document.all["CpLin1listado2"].style.visibility='';
    document.all["CpLin2listado2"].style.visibility='';
    document.all["CpLin3listado2"].style.visibility='';
    document.all["CpLin4listado2"].style.visibility='';

    /*document.all["primera1Div"].style.visibility='';
    document.all["ret1Div"].style.visibility='';
    document.all["ava1Div"].style.visibility='';*/
    
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

    document.all["btnEliminarActividad2"].style.visibility='hidden';
    document.all["CambiarFecha2"].style.visibility='hidden';

   }

  function mostrarListaReferenciaPeridos() {
		DrdEnsanchaConMargenDcho('listado3',24);
		document.all["Cplistado3"].style.visibility='';
		document.all["CpLin1listado3"].style.visibility='';
		document.all["CpLin2listado3"].style.visibility='';
		document.all["CpLin3listado3"].style.visibility='';
		document.all["CpLin4listado3"].style.visibility='';

		document.all["primera3Div"].style.visibility='';
		document.all["ret3Div"].style.visibility='';
		document.all["ava3Div"].style.visibility='';
		document.all["separa3Div"].style.visibility='';

		if (get('frmModificarCronograma.casoDeUso') == 'eliminaCronograma') {
			document.all["btnCambiarFecha3Div"].style.visibility = 'hidden'
		} else {
			document.all["btnCambiarFecha3Div"].style.visibility = ''
		}

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


	function ocultarCronograma() {
	 document.all["capaTablas"].style.visibility='hidden';
     document.all["miscroll"].style.visibility='hidden';
	 document.all["capaBotones"].style.visibility='hidden';

   }

	function onChangeMarca() {
		set('frmModificarCronograma.hChangePaisMC', get('frmModificarCronograma.cbPaises'));
		set('frmModificarCronograma.hChangeMarcaMC', get('frmModificarCronograma.cbMarcas'));
		set('frmModificarCronograma.hChangeCanalMC', get('frmModificarCronograma.cbCanales'));
		var arr = new Array();
		arr[arr.length]=new Array('oidPais', get('frmModificarCronograma.cbPaises'));
		arr[arr.length]=new Array('oidCanal', get('frmModificarCronograma.cbCanales'));
		arr[arr.length]=new Array('oidMarca', get('frmModificarCronograma.cbMarcas'));
		arr[arr.length]=new Array('oidIdioma', get('frmModificarCronograma.hIdioma'));

		recargaCombo('frmModificarCronograma.cbGrupoZonas', 'CRAObtieneGruposZonas', 
						 'es.indra.sicc.dtos.cra.DTOGrupoZonas', arr);

		arr = new Array();
		arr[arr.length]=new Array('oidPais', get('frmModificarCronograma.cbPaises'));
		arr[arr.length]=new Array('oidCanal', get('frmModificarCronograma.cbCanales'));
		arr[arr.length]=new Array('oidMarca', get('frmModificarCronograma.cbMarcas'));
		arr[arr.length]=new Array('oidIdioma', get('frmModificarCronograma.hIdioma'));

		recargaCombo('frmModificarCronograma.cbSubgerenciaVentas', 'ZONRecargaSubgerenciaVentas', 
						 'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa', arr);

		accion('frmModificarCronograma.cbGrupoZonas','.disabled=false');
		accion('frmModificarCronograma.cbSubgerenciaVentas','.disabled=false');
		var aCombo = new Array(new Array("",""));
		set_combo('frmModificarCronograma.cbRegion',aCombo, []);
		set_combo('frmModificarCronograma.cbZona',aCombo, []);
		set('frmModificarCronograma.hChangeGrupo', '');
		set('frmModificarCronograma.hChangeSub', '');
		set('frmModificarCronograma.hChangeRegion', '');

	}

	function onChangeCanal() {
		set('frmModificarCronograma.hChangePaisMC', get('frmModificarCronograma.cbPaises'));
		set('frmModificarCronograma.hChangeMarcaMC', get('frmModificarCronograma.cbMarcas'));
		set('frmModificarCronograma.hChangeCanalMC', get('frmModificarCronograma.cbCanales'));
		var arr = new Array();
		arr[arr.length]=new Array('oidPais', get('frmModificarCronograma.cbPaises'));
		arr[arr.length]=new Array('oidCanal', get('frmModificarCronograma.cbCanales'));
		arr[arr.length]=new Array('oidMarca', get('frmModificarCronograma.cbMarcas'));
		arr[arr.length]=new Array('oidIdioma', get('frmModificarCronograma.hIdioma'));

		recargaCombo('frmModificarCronograma.cbGrupoZonas', 'CRAObtieneGruposZonas', 
						 'es.indra.sicc.dtos.cra.DTOGrupoZonas', arr);

		arr = new Array();
		arr[arr.length]=new Array('oidPais', get('frmModificarCronograma.cbPaises'));
		arr[arr.length]=new Array('oidCanal', get('frmModificarCronograma.cbCanales'));
		arr[arr.length]=new Array('oidMarca', get('frmModificarCronograma.cbMarcas'));
		arr[arr.length]=new Array('oidIdioma', get('frmModificarCronograma.hIdioma'));

		recargaCombo('frmModificarCronograma.cbSubgerenciaVentas', 'ZONRecargaSubgerenciaVentas', 
						 'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa', arr);

		accion('frmModificarCronograma.cbGrupoZonas','.disabled=false');
		accion('frmModificarCronograma.cbSubgerenciaVentas','.disabled=false');
		var aCombo = new Array(new Array("",""));
		set_combo('frmModificarCronograma.cbRegion',aCombo, []);
		set_combo('frmModificarCronograma.cbZona',aCombo, []);
		set('frmModificarCronograma.hChangeGrupo', '');
		set('frmModificarCronograma.hChangeSub', '');
		set('frmModificarCronograma.hChangeRegion', '');

	}

	function onChangeGrupo() {
		if (get('frmModificarCronograma.cbGrupoZonas') != "") {
			set('frmModificarCronograma.hChangeGrupo', get('frmModificarCronograma.cbGrupoZonas'));
			set('frmModificarCronograma.hChangeSub', '');
			accion('frmModificarCronograma.cbSubgerenciaVentas','.disabled=true');
			accion('frmModificarCronograma.cbRegion','.disabled=true');
			var aCombo = new Array(new Array("",""));
			set_combo('frmModificarCronograma.cbRegion',aCombo, []);
			set_combo('frmModificarCronograma.cbZona',aCombo, []);
			set('frmModificarCronograma.hChangeRegion', '');

			iSeleccionado = new Array(); 
			iSeleccionado[0] = "";
			set('frmModificarCronograma.cbSubgerenciaVentas',iSeleccionado);
			set('frmModificarCronograma.cbRegion',iSeleccionado);

			var arr = new Array();
			arr[arr.length]=new Array('oid', get('frmModificarCronograma.cbGrupoZonas'));
			arr[arr.length]=new Array('oidIdioma', get('frmModificarCronograma.hIdioma'));

			recargaCombo('frmModificarCronograma.cbZona','CRAObtieneZonasGrupo', 
							 'es.indra.sicc.util.DTOOID', arr);
		} else {
			accion('frmModificarCronograma.cbSubgerenciaVentas','.disabled=false');
			accion('frmModificarCronograma.cbRegion','.disabled=false');
			var aCombo = new Array(new Array("",""));
			set_combo('frmModificarCronograma.cbZona',aCombo, []);
			set('frmModificarCronograma.hChangeRegion', '');
			set('frmModificarCronograma.hChangeGrupo', '');
		}
	}

	function onChangeSubgerencia() {
		if (get('frmModificarCronograma.cbSubgerenciaVentas') != "") {
			set('frmModificarCronograma.hChangeSub', get('frmModificarCronograma.cbSubgerenciaVentas'));
			set('frmModificarCronograma.hChangeGrupo', '');
			accion('frmModificarCronograma.cbGrupoZonas','.disabled=true');
			accion('frmModificarCronograma.cbRegion','.disabled=false');
			var aCombo = new Array(new Array("",""));
			set_combo('frmModificarCronograma.cbRegion',aCombo, []);
			set_combo('frmModificarCronograma.cbZona',aCombo, []);
			set('frmModificarCronograma.hChangeRegion', '');

			iSeleccionado = new Array(); 
			iSeleccionado[0] = "";
			set('frmModificarCronograma.cbGrupoZonas',iSeleccionado);

			var arr = new Array();
			arr[arr.length]=new Array('oidPais', get('frmModificarCronograma.cbPaises'));
			arr[arr.length]=new Array('oidCanal', get('frmModificarCronograma.cbCanales'));
			arr[arr.length]=new Array('oidMarca', get('frmModificarCronograma.cbMarcas'));
			arr[arr.length]=new Array('oidIdioma', get('frmModificarCronograma.hIdioma'));
			arr[arr.length]=new Array('oidSGV', get('frmModificarCronograma.cbSubgerenciaVentas'));

			recargaCombo('frmModificarCronograma.cbRegion','ZONRecargaRegiones', 
							 'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa', arr);
		} else {
			accion('frmModificarCronograma.cbGrupoZonas','.disabled=false');
			var aCombo = new Array(new Array("",""));
			set_combo('frmModificarCronograma.cbRegion',aCombo, []);
			set_combo('frmModificarCronograma.cbZona',aCombo, []);
			set('frmModificarCronograma.hChangeRegion', '');
			set('frmModificarCronograma.hChangeSub', '');
		}
	}

	function onChangeRegion() {
		if (get('frmModificarCronograma.cbRegion') != "") {
			set('frmModificarCronograma.hChangeRegion', get('frmModificarCronograma.cbRegion'));
			var arr = new Array();
			arr[arr.length]=new Array('oidPais', get('frmModificarCronograma.cbPaises'));
			arr[arr.length]=new Array('oidCanal', get('frmModificarCronograma.cbCanales'));
			arr[arr.length]=new Array('oidMarca', get('frmModificarCronograma.cbMarcas'));
			arr[arr.length]=new Array('oidIdioma', get('frmModificarCronograma.hIdioma'));
			arr[arr.length]=new Array('oidSGV', get('frmModificarCronograma.cbSubgerenciaVentas'));
			arr[arr.length]=new Array('oidRegion', get('frmModificarCronograma.cbRegion'));

			recargaCombo('frmModificarCronograma.cbZona','ZONRecargaZonas', 
							 'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa', arr);
		} else {
			var aCombo = new Array(new Array("",""));
			set_combo('frmModificarCronograma.cbZona',aCombo, []);
			set('frmModificarCronograma.hChangeRegion', '');
		}
		
	}

	function buscar() {
		if (!sicc_validaciones_generales("grupo1"))
			return;
		generarArrayDiasSemana();
		generarArrayMeses();
		set('frmModificarCronograma.hlblActiFija',GestionarMensaje('1002'));
		set('frmModificarCronograma.hlblActiRefe',GestionarMensaje('1003'));
		set('frmModificarCronograma.accion', 'obtieneCronograma');
		set('frmModificarCronograma.conectorAction', 'LPMantieneCronograma');
		set('frmModificarCronograma.casoDeUso', get('frmModificarCronograma.casoDeUso'));
		set('frmModificarCronograma.hCbPais', get('frmModificarCronograma.cbPaises'));
		set('frmModificarCronograma.hMarca', get('frmModificarCronograma.cbMarcas'));
		set('frmModificarCronograma.hCanal', get('frmModificarCronograma.cbCanales'));
		set('frmModificarCronograma.hCodPeriodo', get('frmModificarCronograma.txtCodPeriod'));
		set('frmModificarCronograma.hGrupoZona', get('frmModificarCronograma.cbGrupoZonas'));
		set('frmModificarCronograma.hSubgerencia', get('frmModificarCronograma.cbSubgerenciaVentas'));
		set('frmModificarCronograma.hRegion', get('frmModificarCronograma.cbRegion'));
		set('frmModificarCronograma.hZona', get('frmModificarCronograma.cbZona'));
		eval("frmModificarCronograma.oculto = 'N'");
		enviaSICC('frmModificarCronograma');
	
	
	}

	function generarArrayMeses() {
		var meses = '';
		var i;
		for(i = 0; i < 12; i++) {
			meses = meses + GestionarMensaje((1231+i)+'');
			if (i < 11) 
				meses = meses + '|';
		}
		set('frmModificarCronograma.hVecMeses',meses);
	}

	function generarArrayDiasSemana() {
		var dias = '';
		var i;
		for(i = 0; i < 7; i++) {
			dias = dias + GestionarMensaje((1034+i)+'');
			if (i < 6) 
				dias = dias + '|';
		}
		set('frmModificarCronograma.hVecDiasSemana',dias);
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

	function cambiarFecha() {
		if (idVista == "") {
			GestionarMensaje('407');
			return;
		}
		set('frmModificarCronograma.accion', 'modificaFechaActividad');
		set('frmModificarCronograma.conectorAction', 'LPMantieneCronograma');
		set('frmModificarCronograma.hIdVista', idVista);
		eval("frmModificarCronograma.oculto = 'S'");
		enviaSICC('frmModificarCronograma');
	}

  function camFechFuera() {
      if (listado2.numSelecc() == 1)
      {		
          var arrAux = new Array();
          arrAux = listado2.codSeleccionados();
          var posicion = obtenerPosicionListaEditable(listado2.codSeleccionados(),listado2);		
          set('frmModificarCronograma.accion', 'modificaFechaActividad');
          set('frmModificarCronograma.conectorAction', 'LPMantieneCronograma');
          set('frmModificarCronograma.hMarca', get('frmModificarCronograma.hMarca'));
          set('frmModificarCronograma.hCanal', get('frmModificarCronograma.hCanal'));
          set('frmModificarCronograma.hCodPeriodo', get('frmModificarCronograma.hCodPeriodo'));
          var idVistaFuera = listado2.datos[posicion][7];
          //alert(idVistaFuera);
          set('frmModificarCronograma.hIdVista', idVistaFuera);
      		eval("frmModificarCronograma.oculto = 'S'");
          enviaSICC('frmModificarCronograma');
      } else {
            if (listado2.numSelecc() > 1) {
                 GestionarMensaje('2525');
                 var cant = listado2.numSelecc();
                 var arrSel = listado2.codSeleccionados();
                 var fila;
                 var i;
                 for (i = 0; i < cant; i ++) {
                    fila=DrIndiceEnArray(listado2.datos,arrSel[i],0);
                    listado2.deselecciona(fila);
                 }
            } else {
                 GestionarMensaje('4');
            }
            focalizaBotonHTML('botonContenido','btnCambiarFecha2');
      }
  }   

   
  function camFechRefeOtroPeri() {
      if (listado3.numSelecc() == 1)
      {		
          var arrAux = new Array();
          arrAux = listado3.codSeleccionados();
          var posicion = obtenerPosicionListaEditable(listado3.codSeleccionados(),listado3);		
          set('frmModificarCronograma.accion', 'modificaFechaActividad');
          set('frmModificarCronograma.conectorAction', 'LPMantieneCronograma');
          set('frmModificarCronograma.hMarca', get('frmModificarCronograma.hMarca'));
          set('frmModificarCronograma.hCanal', get('frmModificarCronograma.hCanal'));
          set('frmModificarCronograma.hCodPeriodo', get('frmModificarCronograma.hCodPeriodo'));
          var idVistaFuera = listado3.datos[posicion][9];
          //alert(idVistaFuera);
          set('frmModificarCronograma.hIdVista', idVistaFuera);
      		eval("frmModificarCronograma.oculto = 'S'");
          enviaSICC('frmModificarCronograma');
      } else {
            if (listado3.numSelecc() > 1) {
                 GestionarMensaje('2525');
                 var cant = listado3.numSelecc();
                 var arrSel = listado3.codSeleccionados();
                 var fila;
                 var i;
                 for (i = 0; i < cant; i ++) {
                    fila=DrIndiceEnArray(listado3.datos,arrSel[i],0);
                    listado3.deselecciona(fila);
                 }
            } else {
                 GestionarMensaje('4');
            }
            focalizaBotonHTML('botonContenido','btnCambiarFecha3');
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
		set('frmModificarCronograma.accion', 'aceptaModificarFija');
		set('frmModificarCronograma.conectorAction', 'LPMantieneCronograma');
		set('frmModificarCronograma.casoDeUso', 'ModificaCronograma');
		set('frmModificarCronograma.hCbPais', get('frmModificarCronograma.hCbPais'));  //Por si cambian el combo y despues hacen modificar fecha sin generar
		set('frmModificarCronograma.hMarca', get('frmModificarCronograma.hMarca'));  //Idem
		set('frmModificarCronograma.hCanal', get('frmModificarCronograma.hCanal'));
		set('frmModificarCronograma.hCodPeriodo', get('frmModificarCronograma.hCodPeriodo'));
		set('frmModificarCronograma.hGrupoZona', get('frmModificarCronograma.hGrupoZona'));
		set('frmModificarCronograma.hSubgerencia', get('frmModificarCronograma.hSubgerencia'));
		set('frmModificarCronograma.hRegion', get('frmModificarCronograma.hRegion'));
		set('frmModificarCronograma.hZona', get('frmModificarCronograma.hZona'));
		set('frmModificarCronograma.hIdVista', idV);
		eval("frmModificarCronograma.oculto = 'N'");
		enviaSICC('frmModificarCronograma');
	}

	function eliminaActividad() {
      if (idVista == "") {
        GestionarMensaje('407');
        return;
      }
      set('frmModificarCronograma.accion', 'confirmaActividadCronograma');
      set('frmModificarCronograma.conectorAction', 'LPMantieneCronograma');
      set('frmModificarCronograma.casoDeUso', 'ModificaCronograma');
      set('frmModificarCronograma.hIdVista', idVista);
  		eval("frmModificarCronograma.oculto = 'S'");
      enviaSICC('frmModificarCronograma');

  }

	function eliminaActFuera() {
      if (listado2.numSelecc() == 1)
      {		
          var arrAux = new Array();
          arrAux = listado2.codSeleccionados();
          var posicion = obtenerPosicionListaEditable(listado2.codSeleccionados(),listado2);		
          set('frmModificarCronograma.accion', 'confirmaActividadCronograma');
          set('frmModificarCronograma.conectorAction', 'LPMantieneCronograma');
          set('frmModificarCronograma.casoDeUso', 'ModificaCronograma');
          var idVistaFuera = listado2.datos[posicion][7];
          set('frmModificarCronograma.hIdVista', idVistaFuera);
      		eval("frmModificarCronograma.oculto = 'S'");
          enviaSICC('frmModificarCronograma');
      } else {
           GestionarMensaje('4');
           focalizaBotonHTML('botonContenido','btnEliminarActividad2');
           return;
      }
  }


	function vueltaEliminaActividad(esFija, idV) {
      if (esFija == "1") {
          GestionarMensaje("1435")
          //cdos_mostrarAlert("La actividad que desea eliminar está marcada como fija. No se puede completar la acción");
          return;
      }
      var acepta = GestionarMensaje("1269");
      if (acepta) {
        set('frmModificarCronograma.accion', 'eliminarActividad');
        set('frmModificarCronograma.conectorAction', 'LPMantieneCronograma');
        set('frmModificarCronograma.casoDeUso', 'ModificaCronograma');
        set('frmModificarCronograma.hCbPais', get('frmModificarCronograma.hCbPais'));  //Por si cambian el combo y despues hacen modificar fecha sin generar
        set('frmModificarCronograma.hMarca', get('frmModificarCronograma.hMarca'));  //Idem
        set('frmModificarCronograma.hCanal', get('frmModificarCronograma.hCanal'));
        set('frmModificarCronograma.hCodPeriodo', get('frmModificarCronograma.hCodPeriodo'));
        set('frmModificarCronograma.hGrupoZona', get('frmModificarCronograma.hGrupoZona'));
        set('frmModificarCronograma.hSubgerencia', get('frmModificarCronograma.hSubgerencia'));
        set('frmModificarCronograma.hRegion', get('frmModificarCronograma.hRegion'));
        set('frmModificarCronograma.hZona', get('frmModificarCronograma.hZona'));
        set('frmModificarCronograma.hIdVista', idV);
     		eval("frmModificarCronograma.oculto = 'N'");
        enviaSICC('frmModificarCronograma');
      }
	}

	function insertaActividad() {
		set('frmModificarCronograma.accion', 'insertaActividad');
		set('frmModificarCronograma.conectorAction', 'LPMantieneCronograma');
		set('frmModificarCronograma.casoDeUso', 'ModificaCronograma');
		set('frmModificarCronograma.hCbPais', get('frmModificarCronograma.hCbPais'));  //Por si cambian el combo y despues hacen modificar fecha sin generar
		set('frmModificarCronograma.hMarca', get('frmModificarCronograma.hMarca'));  //Idem
		set('frmModificarCronograma.hCanal', get('frmModificarCronograma.hCanal'));
		set('frmModificarCronograma.hCodPeriodo', get('frmModificarCronograma.hCodPeriodo'));
		set('frmModificarCronograma.hGrupoZona', get('frmModificarCronograma.hGrupoZona'));
		set('frmModificarCronograma.hSubgerencia', get('frmModificarCronograma.hSubgerencia'));
		set('frmModificarCronograma.hRegion', get('frmModificarCronograma.hRegion'));
		set('frmModificarCronograma.hZona', get('frmModificarCronograma.hZona'));
		set('frmModificarCronograma.hIdVista', idVista);
		eval("frmModificarCronograma.oculto = 'N'");
		enviaSICC('frmModificarCronograma');
	}

	function focoShTabPaises() {
      if (get('frmModificarCronograma.hMostrarCrono') == '1') {
          //if (document.all["capaBotones"].style.visibility != 'hidden') {
          if (get('frmModificarCronograma.casoDeUso') != 'consulta' &&
                get('frmModificarCronograma.casoDeUso') != 'eliminaCronograma' ) {        
              if (get('frmModificarCronograma.hMostrarFuera') == '1') {
                     focalizaBotonHTML('botonContenido','CambiarFecha2');
              } else {
                 focalizaBotonHTML('botonContenido','AnadirTablaGrafica');
              }
          } else {
              focalizaBotonHTML('botonContenido','btnBuscar');
          }
      } else {
           focalizaBotonHTML('botonContenido','btnBuscar');
      }
	}

	function focoTabBuscar() {
    if (get('frmModificarCronograma.hMostrarCrono') == '1') {
        //if (document.all["capaBotones"].style.visibility != 'hidden') {
        if (get('frmModificarCronograma.casoDeUso') != 'consulta' &&
                get('frmModificarCronograma.casoDeUso') != 'eliminaCronograma' ) {        
            focalizaBotonHTML('botonContenido','btnEliminarActividad');
        } else {
            focaliza('frmModificarCronograma.cbPaises');
        }
		} else {
         focaliza('frmModificarCronograma.cbPaises');
    }
		
	}

  function focoTabBtnCrono() {
        if (get('frmModificarCronograma.hMostrarFuera') == '1') {
            focalizaBotonHTML('botonContenido','btnEliminarActividad2');
        } else {
      			focaliza('frmModificarCronograma.cbPaises');
        }
  }
	
	function fGuardar() {
		set('frmModificarCronograma.accion', 'guardaCronograma');
		set('frmModificarCronograma.conectorAction', 'LPMantieneCronograma');
		set('frmModificarCronograma.casoDeUso', 'ModificaCronograma');
		set('frmModificarCronograma.hCbPais', get('frmModificarCronograma.hCbPais'));  //Por si cambian el combo y despues hacen modificar fecha sin generar
		set('frmModificarCronograma.hMarca', get('frmModificarCronograma.hMarca'));  //Idem
		set('frmModificarCronograma.hCanal', get('frmModificarCronograma.hCanal'));
		set('frmModificarCronograma.hCodPeriodo', get('frmModificarCronograma.hCodPeriodo'));
		set('frmModificarCronograma.hGrupoZona', get('frmModificarCronograma.hGrupoZona'));
		set('frmModificarCronograma.hSubgerencia', get('frmModificarCronograma.hSubgerencia'));
		set('frmModificarCronograma.hRegion', get('frmModificarCronograma.hRegion'));
		set('frmModificarCronograma.hZona', get('frmModificarCronograma.hZona'));
		eval("frmModificarCronograma.oculto = 'N'");  //Porque si se hace oculto no se actualiza el TAD
		enviaSICC('frmModificarCronograma');
	}

	function fBorrar(){
		if (get('frmModificarCronograma.casoDeUso') =="eliminaCronograma") {
			var acepta = GestionarMensaje("1290");
			if (acepta) {
				set('frmModificarCronograma.accion', 'eliminarCronograma');
				set('frmModificarCronograma.conectorAction', 'LPMantieneCronograma');
				eval("frmModificarCronograma.oculto = 'S'");
				enviaSICC('frmModificarCronograma');
			}
			focaliza('frmModificarCronograma.cbPaises');
		}

	}

	function vueltaEliminaCrono() {
		//alert("Vuelta Elimina");
		focaliza('frmModificarCronograma.cbPaises');
		ocultarListaFuera();
		ocultarCronograma();
		btnProxy(4, '0');
	}

	function fLimpiar() {
		var aCombo = new Array(new Array("",""));
		set_combo('frmModificarCronograma.cbGrupoZonas',aCombo, []);
		set_combo('frmModificarCronograma.cbRegion',aCombo, []);
		set_combo('frmModificarCronograma.cbZona',aCombo, []);
		set_combo('frmModificarCronograma.cbSubgerenciaVentas',aCombo, []);
	}

