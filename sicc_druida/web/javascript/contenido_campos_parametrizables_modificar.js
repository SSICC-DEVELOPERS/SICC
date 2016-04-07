  function onLoadPag()  {
    DrdEnsanchaConMargenDcho('listado1',12);
    document.all["Cplistado1"].style.visibility='hidden';
    document.all["CpLin1listado1"].style.visibility='hidden';
    document.all["CpLin2listado1"].style.visibility='hidden';
    document.all["CpLin3listado1"].style.visibility='hidden';
    document.all["CpLin4listado1"].style.visibility='hidden';
    document.all["primera1Div"].style.visibility='hidden';
    document.all["ava1Div"].style.visibility='hidden';
    document.all["ret1Div"].style.visibility='hidden';
    document.all["ModificarDiv"].style.visibility='hidden';
    document.all["ConsultarDiv"].style.visibility='hidden';
    eval (ON_RSZ);
    mostrarError();
  }

  function mostrarError() {
    if ( get('frmFormulario.errCodigo')!= "" )  {
      var errMsg = fMostrarMensajeError( get('frmFormulario.errCodigo'),get('frmFormulario.errDescripcion') );
    }
  }

  function ocultarLista()  {
    document.all["Cplistado1"].style.visibility='hidden';
    document.all["CpLin1listado1"].style.visibility='hidden';
    document.all["CpLin2listado1"].style.visibility='hidden';
    document.all["CpLin3listado1"].style.visibility='hidden';
    document.all["CpLin4listado1"].style.visibility='hidden';
    document.all["primera1Div"].style.visibility='hidden';
    document.all["ava1Div"].style.visibility='hidden';
    document.all["ret1Div"].style.visibility='hidden';
    document.all["ModificarDiv"].style.visibility='hidden';
    document.all["ConsultarDiv"].style.visibility='hidden';
  }


  function buscar() {
    
    ocultarLista();
     
    set('frmFormulario.accion', 'Buscar');
    
    if (get('frmFormulario.cbTipoCampo','T') == GestionarMensaje(982) )  {
      listado1.alternaVerColumna(0,false);
      listado1.alternaVerColumna(1,false);
      listado1.alternaVerColumna(5,false);
    } else {
      listado1.alternaVerColumna(0,true);
      listado1.alternaVerColumna(1,true);
      listado1.alternaVerColumna(5,true);
    }
    
    configurarPaginado(mipgndo1, 'MAEBuscarConfiguracionCampos', 'ConectorBuscarConfiguracionCampos', 
          'es.indra.sicc.dtos.mae.DTOBusquedaConfiguracionCampo', armarArray() );
    focaliza('frmFormulario.cbTipoCampo');
	}

  function armarArray()  {
    var array = new Array();
    var i = 0;
    array[i] = new Array('oidIdioma',get('frmFormulario.hOidIdioma'));
    array[i] = new Array('oidPais',get('frmFormulario.hOidPais'));

    if(get('frmFormulario.cbTipoCampo') != ''){
      i++;
      if (get('frmFormulario.cbTipoCampo') == '0'){
        array[i] = new Array('indClienteProducto','true');
      } else {
        array[i] = new Array('indClienteProducto','false');
      }
    }
    
    if (get('frmFormulario.cbTipoCliente') != '')  {
      i++;
      array[i] = new Array('tipoCliente',get('frmFormulario.cbTipoCliente'));
    }
    
    if (get('frmFormulario.cbSubTipoCliente') != '')  {
      i++;
      array[i] = new Array('subtipoCliente',get('frmFormulario.cbSubTipoCliente'));
    }
    
    if (get('frmFormulario.cbNombreCampo') != '')  {
      i++;
      array[i] = new Array('campo',get('frmFormulario.cbNombreCampo'));
    }
    
    if (get('frmFormulario.IngresoObligatorio') != '')  {
      i++;
      if (get('frmFormulario.IngresoObligatorio') == 'S')  {
        array[i] = new Array('obligatorio','true');
      } else {
        array[i] = new Array('obligatorio','false');
      }
    }
    
    if (get('frmFormulario.ModificableporUsuario') != '')  {
      i++;
      if (get('frmFormulario.ModificableporUsuario') == 'S')  {
        array[i] = new Array('modificable','true');
      } else {
        array[i] = new Array('modificable','false');
      }
    }
    
    if (get('frmFormulario.txtValorPorDefecto') != '')  {
      i++;
      array[i] = new Array('valorDefecto',get('frmFormulario.txtValorPorDefecto'));
    }
    return array;
  }

  function mostrarLista()  {
    document.all["Cplistado1"].style.visibility='visible';
    document.all["CpLin1listado1"].style.visibility='visible';
    document.all["CpLin2listado1"].style.visibility='visible';
    document.all["CpLin3listado1"].style.visibility='visible';
    document.all["CpLin4listado1"].style.visibility='visible';
    document.all["primera1Div"].style.visibility='visible';
    document.all["ava1Div"].style.visibility='visible';
    document.all["ret1Div"].style.visibility='visible';
    habilitarBotones();
  }

  function habilitarBotones()  {
    if ( get('frmFormulario.hCasoDeUso') == 'Modificar' )  {
      document.all["ModificarDiv"].style.visibility='visible';
      document.all["ConsultarDiv"].style.visibility='hidden';
    }
    if ( get('frmFormulario.hCasoDeUso') == 'Eliminar' )  {
      document.all["ModificarDiv"].style.visibility='hidden';
      document.all["ConsultarDiv"].style.visibility='visible';
      btnProxy(4, '1');
    }
    if ( get('frmFormulario.hCasoDeUso') == 'Consultar' )  {
      document.all["ModificarDiv"].style.visibility='hidden';
      document.all["ConsultarDiv"].style.visibility='visible';
    }
  }

	function eliminar()  {
		if (listado1.numSelecc() != 0)  {
			eliminarFilas(listado1.codSeleccionados(),"MAEEliminarConfiguracionCampos",mipgndo1);
			focaliza('frmFormulario.cbTipoCampo');
		} else {
			GestionarMensaje('1021');
		}
	}

  function fBorrar()  {
    eliminar();
  }

  function transformarLista( rowset) {
    if (rowset.length == 0) {
      ocultarLista();
      btnProxy(4, '0');
      return false;
    } else {
      var s = GestionarMensaje(84);
      var n = GestionarMensaje(86);
      for ( f=0; f<rowset.length; f++) {
        if ( rowset[f][4] == "1" ) rowset[f][4] = s;
        else rowset[f][4] = n;
        if ( rowset[f][5] == "1" ) rowset[f][5] = s;
        else rowset[f][5] = n;
      }
      listado1.setDatos(rowset);
      listado1.display();
      mostrarLista();
      return true;
    }
  }




	function datosPrevios()  {
		configurarMenuSecundario("frmFormulario");
		if ( get('frmFormulario.accion') == "" ) {
			focaliza('frmFormulario.cbTipoCampo');
			completarComboTipoCampo();
			set( 'frmFormulario.cbTipoCampo', [''] );
			accion( 'frmFormulario.cbSubTipoCliente', '.disabled=true' );
			completarComboNombreCampo();
		}
		mostrarError();
	}


  function mostrarError()  {
    if ( get('frmFormulario.errCodigo')!= "" )  {
      var errMsg = fMostrarMensajeError( get('frmFormulario.errCodigo'),get('frmFormulario.errDescripcion') );
    }
  }

   
  function operacionExitosa()  {
    var exito = get('frmFormulario.exito');
    if ( exito == "si")	 {
//      if ( get('frmFormulario.hCasoDeUso') == 'Eliminar' ) {alert('exito');fMostrarMensajeExito('eliminar');}
      set("frmFormulario.exito", "");
    }
  }



  function completarComboTipoCampo()  {
    var pro = GestionarMensaje(982);
    var cli = GestionarMensaje(983);
    combo_add('frmFormulario.cbTipoCampo', "0", cli);
    combo_add('frmFormulario.cbTipoCampo', "1", pro);
  
  }


/*
	function completarComboNombreCampo()  {
		set_combo('frmFormulario.cbNombreCampo',[]);
		if ( get('frmFormulario.cbTipoCampo') == "" ){
			accion( 'frmFormulario.cbNombreCampo', '.disabled=true' );
		} else {
			accion( 'frmFormulario.cbNombreCampo', '.disabled=false' );
			combo_add('frmFormulario.cbNombreCampo', '', '');
			var tipoCliProd = get('frmFormulario.cbTipoCampo','T');
			for(var k=0;k<listaOcultaNC.datos.longitud;k++) {
				if ( listaOcultaNC.datos.ij(k,2) == tipoCliProd ) {
					combo_add('frmFormulario.cbNombreCampo',listaOcultaNC.datos.ij(k,0),listaOcultaNC.datos.ij(k,1));
				}
			}
			var seleccionComboNombreCampo = new Array();
			seleccionComboNombreCampo[ 0 ] = get('frmFormulario.hNombreCampo');
			set( 'frmFormulario.cbNombreCampo', seleccionComboNombreCampo );
		}
	}
*/



	function completarComboNombreCampo()  {
		set_combo('frmFormulario.cbNombreCampo',[]);
    
		if ( get('frmFormulario.cbTipoCampo').toString() == '' ){
			set( 'frmFormulario.cbTipoCliente', [''] );
      set( 'frmFormulario.cbSubTipoCliente', [''] );
      set('frmFormulario.txtValorPorDefecto', '');
			accion( 'frmFormulario.cbTipoCliente', '.disabled=true' );
			accion( 'frmFormulario.cbSubTipoCliente', '.disabled=true' );
			accion( 'frmFormulario.txtValorPorDefecto', '.disabled=true' );
			cargaNombreCampo();
		} else {
			accion( 'frmFormulario.cbTipoCliente', '.disabled=false' );
			accion( 'frmFormulario.txtValorPorDefecto', '.disabled=false' );
			cargaNombreCampo();
		}
	}

	function cargaNombreCampo(){
		combo_add('frmFormulario.cbNombreCampo', '', '');
		var tipoCliProd = get('frmFormulario.cbTipoCampo','T');

		for(var k=0;k<listaOcultaNC.datos.longitud;k++) {
			if ( listaOcultaNC.datos.ij(k,2) == tipoCliProd ) {
				combo_add('frmFormulario.cbNombreCampo', listaOcultaNC.datos.ij(k, 0), listaOcultaNC.datos.ij(k,1));
			}
		}
		var seleccionComboNombreCampo = new Array();
		seleccionComboNombreCampo[ 0 ] = get('frmFormulario.hNombreCampo');
		set( 'frmFormulario.cbNombreCampo', seleccionComboNombreCampo );
	}


  function habilitacionCombosCli()  {
    if ( get('frmFormulario.cbTipoCampo','T') == GestionarMensaje(982) )  {
			//set( 'frmFormulario.cbTipoCliente', [0] );
      //set( 'frmFormulario.cbSubTipoCliente', [0]);
     // accion( 'frmFormulario.cbTipoCliente', '.disabled=true' );
     // accion( 'frmFormulario.cbSubTipoCliente', '.disabled=true' );
     //   txt_to('lblTipoCliente','');
      //  accion('frmFormulario.cbTipoCliente', '.style.visibility=\"hidden\"');
       // txt_to('lblSubtipoCliente','');
       // accion('frmFormulario.cbSubTipoCliente', '.style.visibility=\"hidden\"');

      document.all["capaCbSubTipoCLiente"].style.visibility = 'hidden';
      document.all["capaCbTipoCLiente"].style.visibility = 'hidden';
      document.all["capaLblSubTipoCLiente"].style.visibility = 'hidden';
      document.all["capaLblTipoCLiente"].style.visibility = 'hidden';
      document.all["capaLblValorDefecto"].style.visibility = 'hidden';
      document.all["capaTxtValorDefecto"].style.visibility = 'hidden';

	  document.all.IngresoObligatorio[0].checked=false;
      document.all.IngresoObligatorio[1].checked=false;
      document.all.ModificableporUsuario[0].checked=false;
      document.all.ModificableporUsuario[1].checked=false; 
       
      return false;
    }
    else  {
    //  set( 'frmFormulario.cbTipoCliente', "" );
    //  set( 'frmFormulario.cbSubTipoCliente', "");
   //   var codTC = GestionarMensaje(986);
   //   var codSTC = GestionarMensaje(987);
    //  txt_to('lblTipoCliente',codTC);
  //    accion('frmFormulario.cbTipoCliente', '.style.visibility=\"visible\"');
   //   txt_to('lblSubtipoCliente',codSTC);
    //  accion('frmFormulario.cbSubTipoCliente', '.style.visibility=\"visible\"');
    //  accion( 'frmFormulario.cbTipoCliente', '.disabled=false' );

      document.all["capaCbSubTipoCLiente"].style.visibility = 'visible';
      document.all["capaCbTipoCLiente"].style.visibility = 'visible';
      document.all["capaLblSubTipoCLiente"].style.visibility = 'visible';
      document.all["capaLblTipoCLiente"].style.visibility = 'visible';
      document.all["capaLblValorDefecto"].style.visibility = 'visible';
      document.all["capaTxtValorDefecto"].style.visibility = 'visible';

	  document.all.IngresoObligatorio[0].checked=false;
      document.all.IngresoObligatorio[1].checked=false;
      document.all.ModificableporUsuario[0].checked=false;
      document.all.ModificableporUsuario[1].checked=false; 

      return true;
    }
  }


  function completarComboSubtipoCliente()  {
    set_combo('frmFormulario.cbSubTipoCliente',[]);
    if ( get('frmFormulario.cbTipoCliente') == "" ) accion( 'frmFormulario.cbSubTipoCliente', '.disabled=true' );
		else {
      accion( 'frmFormulario.cbSubTipoCliente', '.disabled=false' );
      combo_add('frmFormulario.cbSubTipoCliente', '', '');
      var tipoCliente = get('frmFormulario.cbTipoCliente','V');
      for(var k=0;k<listaOcultaSTC.datos.longitud;k++) {
				if ( listaOcultaSTC.datos.ij(k,1) == tipoCliente ) {
					combo_add('frmFormulario.cbSubTipoCliente',listaOcultaSTC.datos.ij(k,0),listaOcultaSTC.datos.ij(k,2));
        }
      }
      var seleccionComboSubtipoCliente = new Array();
			seleccionComboSubtipoCliente[ 0 ] = get('frmFormulario.hSubtipoCliente');
			set( 'frmFormulario.cbSubTipoCliente', seleccionComboSubtipoCliente );
		}
	}

  
  function focalizarOnTabTC()  {
    try { focaliza('frmFormulario.cbSubTipoCliente');
    }
    catch (e)  {
      focaliza('frmFormulario.cbNombreCampo');
    }
  }


  function focalizarOnTabVxD()  {
    focaliza('frmFormulario.cbTipoCampo');
  }


  function focalizarOnShTab()  {
    focaliza('frmFormulario.txtValorPorDefecto');
  }


  function modificar(){
      if ( listado1.codSeleccionados().length == 1 )  {
        set('frmFormulario.hOID', listado1.codSeleccionados().toString() );
        var parametros = new Object();
        parametros.clave0 = listado1.codSeleccionados();
		parametros.hCasoDeUso = get('frmFormulario.hCasoDeUso');
        mostrarModalSICC("LPModificarConfiguracionCampos","", parametros );
        buscar();
      } else {
          GestionarMensaje('2525');
          focaliza('frmFormulario.cbTipoCampo');
        }
  }

  function consultar()  {
    if (listado1.numSelecc() == 1) {
      set('frmFormulario.hOID', listado1.codSeleccionados().toString() );
      var parametros = new Object();
      parametros.clave0 = listado1.codSeleccionados();
	  parametros.hCasoDeUso = get('frmFormulario.hCasoDeUso');
      mostrarModalSICC("LPConsultaConfiguracionCampos","", parametros );
      focaliza('frmFormulario.cbTipoCampo');
    } else { 
        GestionarMensaje('2525');
        focaliza('frmFormulario.cbTipoCampo');
      }
  }


  function fVolver()  {
    set('frmFormulario.accion','');
    enviaSICC('frmFormulario');
  }

	function fLimpiar()  {
		focaliza('frmFormulario.cbTipoCampo');
		set( 'frmFormulario.cbTipoCampo', [''] );
		completarComboNombreCampo();
 		set( 'frmFormulario.cbNombreCampo', [] );
		set('frmFormulario.IngresoObligatorio', "");
		set('frmFormulario.ModificableporUsuario', "");
		set('frmFormulario.txtValorPorDefecto',"");

		if ( habilitacionCombosCli() )  {
			set( 'frmFormulario.cbTipoCliente', [] );
			set_combo("frmFormulario.cbSubTipoCliente", eval('[[""],[""]]'));		
			accion( 'frmFormulario.cbSubTipoCliente', '.disabled=true' );
		}
	}

function setTabFocus( campo ){
	if( campo == 'cbTipoCampo' ){
		if( cbTipoCliente.disabled == false && document.all["capaCbTipoCLiente"].style.visibility != 'hidden' ){
			focaliza('frmFormulario.cbTipoCliente');
		}else{
			focaliza('frmFormulario.cbNombreCampo');
		}
	}else if(campo =='cbTipoCliente'){
		if( cbSubTipoCliente.disabled == false && document.all["capaCbSubTipoCLiente"].style.visibility != 'hidden' ){
			focaliza('frmFormulario.cbSubTipoCliente');
		}else{
			focaliza('frmFormulario.cbNombreCampo');
		}
	}else if(campo =='cbSubTipoCliente'){
		focaliza('frmFormulario.cbNombreCampo');
	}else if(campo =='cbNombreCampo'){
		focaliza('frmFormulario.IngresoObligatorio');
	}else if(campo =='txtValorPorDefecto'){
		document.selection.empty();
		focalizaBotonHTML('botonContenido', 'btnBuscar');
	}else if(campo =='IngresoObligatorio'){
		document.all.tags("INPUT").ModificableporUsuario[0].focus();
	}else if(campo =='ModificableporUsuario'){

		if(txtValorPorDefecto.disabled == false && document.all["capaTxtValorDefecto"].style.visibility != 'hidden' ){
			focaliza('frmFormulario.txtValorPorDefecto');
		}else{
			focalizaBotonHTML('botonContenido', 'btnBuscar');
		}
	}else if(campo == 'btnBuscar'){
		if(document.all["ModificarDiv"].style.visibility != 'hidden'){
			focalizaBotonHTML_XY('Modificar');
		}else if(document.all["ConsultarDiv"].style.visibility != 'hidden'){
			focalizaBotonHTML_XY('Consultar');
		}else{
			focaliza('frmFormulario.cbTipoCampo');
		}
	}else if(campo == 'Modificar' || campo == 'Consultar'){
			focaliza('frmFormulario.cbTipoCampo');
	}
}

function setSHTabFocus( campo ){
	if( campo == 'cbTipoCampo' ){
		if(document.all["ModificarDiv"].style.visibility != 'hidden'){
			focalizaBotonHTML_XY('Modificar');
		}else if(document.all["ConsultarDiv"].style.visibility != 'hidden'){
			focalizaBotonHTML_XY('Consultar');
		}else{
			focalizaBotonHTML('botonContenido', 'btnBuscar');
		}
	}else if(campo =='cbTipoCliente'){
		focaliza('frmFormulario.cbTipoCampo');
	}else if(campo =='cbSubTipoCliente'){
		focaliza('frmFormulario.cbTipoCliente');
	}else if(campo =='cbNombreCampo'){
		if( cbSubTipoCliente.disabled == false && document.all["capaCbSubTipoCLiente"].style.visibility != 'hidden' ){
			focaliza('frmFormulario.cbSubTipoCliente');
		}else if( cbTipoCliente.disabled == false && document.all["capaCbTipoCLiente"].style.visibility != 'hidden' ){
			focaliza('frmFormulario.cbTipoCliente');
		}else{
			focaliza('frmFormulario.cbTipoCampo');
		}
	}else if(campo =='txtValorPorDefecto'){
		document.selection.empty();
		focaliza('frmFormulario.ModificableporUsuario');
		//document.all.ModificableporUsuario.focus();
	}else if(campo =='IngresoObligatorio'){
		focaliza('frmFormulario.cbNombreCampo');
	}else if(campo =='ModificableporUsuario'){
		focaliza('frmFormulario.IngresoObligatorio');
		//document.all.IngresoObligatorio.focus();
	}else if(campo =='btnBuscar'){
		if(txtValorPorDefecto.disabled == false && document.all["capaTxtValorDefecto"].style.visibility != 'hidden' ){
			focaliza('frmFormulario.txtValorPorDefecto');
		}else{
			focaliza('frmFormulario.ModificableporUsuario');
			//document.all.ModificableporUsuario.focus();
		}
	}else if(campo == 'Modificar' || campo == 'Consultar'){
		focalizaBotonHTML('botonContenido', 'btnBuscar');
	}

}
