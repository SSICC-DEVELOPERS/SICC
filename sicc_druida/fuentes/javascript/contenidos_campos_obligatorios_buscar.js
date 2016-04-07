
  function datosPrevios()  {
    configurarMenuSecundario("frmDatos");
    if ( get('frmDatos.accion') == "" ) {
      focaliza('frmDatos.comboTipo');
      completarComboTipo();
			set( 'frmDatos.comboTipo', [1] );
			accion( 'frmDatos.comboSubtipoCliente', '.disabled=true' );
			completarComboNombreCampo();
		}
 		else  {
      focaliza('frmDatos.comboTipo');
      completarComboTipo();
 			var seleccionComboTipo = new Array();
			seleccionComboTipo[ 0 ] = get('frmDatos.hTipo');
			set( 'frmDatos.comboTipo', seleccionComboTipo );
      
			completarComboNombreCampo();

      set('frmDatos.RDObligatorio', get('frmDatos.hObligatorio'));
      set('frmDatos.RDModificable', get('frmDatos.hModificable'));
      
      if ( habilitacionCombosCli() )  {
        var seleccionComboTipoCliente = new Array();
        seleccionComboTipoCliente[ 0 ] = get('frmDatos.hTipoCliente');
        set( 'frmDatos.comboTipoCliente', seleccionComboTipoCliente );
        completarComboSubtipoCliente();
      }
      transformarListaResultados();
		}

    operacionExitosa();
    mostrarError();
	}


  function mostrarError()  {
    if ( get('frmDatos.errCodigo')!= "" )  {
      var errMsg = fMostrarMensajeError( get('frmDatos.errCodigo'),get('frmDatos.errDescripcion') );
    }
  }

   
  function operacionExitosa()  {
    var exito = get('frmDatos.exito');
    if ( exito == "si")	 {
      if ( get('frmDatos.hCasoDeUso')=='Eliminar' ) fMostrarMensajeExito('eliminar');
      set("frmDatos.exito", "");
    }
  }


  function completarComboTipo()  {
      var pro = GestionarMensaje(982);
      var cli = GestionarMensaje(983);
      combo_add('frmDatos.comboTipo', "0", pro);
      combo_add('frmDatos.comboTipo', "1", cli);
  }


	function completarComboNombreCampo()  {
    set_combo('frmDatos.comboNombreCampo',[]);
    if ( get('frmDatos.comboTipo') == "" ) accion( 'frmDatos.comboNombreCampo', '.disabled=true' );
		else {
      accion( 'frmDatos.comboNombreCampo', '.disabled=false' );
      combo_add('frmDatos.comboNombreCampo', '', '');
			var tipoCliProd = get('frmDatos.comboTipo','T');
      for(var k=0;k<listaOcultaNC.datos.longitud;k++) {
				if ( listaOcultaNC.datos.ij(k,2) == tipoCliProd ) {
					combo_add('frmDatos.comboNombreCampo',listaOcultaNC.datos.ij(k,0),listaOcultaNC.datos.ij(k,1));
        }
      }
      var seleccionComboNombreCampo = new Array();
			seleccionComboNombreCampo[ 0 ] = get('frmDatos.hNombreCampo');
			set( 'frmDatos.comboNombreCampo', seleccionComboNombreCampo );
    }
	}


  function habilitacionCombosCli()  {
    if ( get('frmDatos.comboTipo','T') == GestionarMensaje(982) )  {
			set( 'frmDatos.comboTipoCliente', [0] );
      set( 'frmDatos.comboSubtipoCliente', [0]);
      accion( 'frmDatos.comboTipoCliente', '.disabled=true' );
      accion( 'frmDatos.comboSubtipoCliente', '.disabled=true' );
        txt_to('lblTipoCliente','');
        accion('frmDatos.comboTipoCliente', '.style.visibility=\"hidden\"');
        txt_to('lblSubtipoCliente','');
        accion('frmDatos.comboSubtipoCliente', '.style.visibility=\"hidden\"');
      return false;
    }
    else  {
      set( 'frmDatos.comboTipoCliente', "" );
      set( 'frmDatos.comboSubtipoCliente', "");
      var codTC = GestionarMensaje(986);
      var codSTC = GestionarMensaje(987);
      txt_to('lblTipoCliente',codTC);
      accion('frmDatos.comboTipoCliente', '.style.visibility=\"visible\"');
      txt_to('lblSubtipoCliente',codSTC);
      accion('frmDatos.comboSubtipoCliente', '.style.visibility=\"visible\"');
      accion( 'frmDatos.comboTipoCliente', '.disabled=false' );
      return true;
    }
  }


  function completarComboSubtipoCliente()  {
    set_combo('frmDatos.comboSubtipoCliente',[]);
    if ( get('frmDatos.comboTipoCliente') == "" ) accion( 'frmDatos.comboSubtipoCliente', '.disabled=true' );
		else {
      accion( 'frmDatos.comboSubtipoCliente', '.disabled=false' );
      combo_add('frmDatos.comboSubtipoCliente', '', '');
      var tipoCliente = get('frmDatos.comboTipoCliente','V');
      for(var k=0;k<listaOcultaSTC.datos.longitud;k++) {
				if ( listaOcultaSTC.datos.ij(k,1) == tipoCliente ) {
					combo_add('frmDatos.comboSubtipoCliente',listaOcultaSTC.datos.ij(k,0),listaOcultaSTC.datos.ij(k,2));
        }
      }
      var seleccionComboSubtipoCliente = new Array();
			seleccionComboSubtipoCliente[ 0 ] = get('frmDatos.hSubtipoCliente');
			set( 'frmDatos.comboSubtipoCliente', seleccionComboSubtipoCliente );
		}
	}

  
  function buscar()  {
    if ( fValidarCOMBO('frmDatos.comboTipo') )  {
      set('frmDatos.accion', 'Buscar');
      enviaSICC('frmDatos');
    }
	}


  function transformarListaResultados()  {
    var s = GestionarMensaje(84);
    var n = GestionarMensaje(86);
    if ( get('frmDatos.hTipo') == '0' )  {
      var arrayListaResProd = new Array();
      for (var f=0; f<ListaResultaProd.datos.longitud; f++) {
        arrayListaResProd[f] = new Array();
        for (var c=0; c<5; c++) {
          arrayListaResProd[f][c] = ListaResultaProd.datos.ij(f,c);
        }
      }
      for ( f=0; f<ListaResultaProd.datos.longitud; f++) {
        if ( arrayListaResProd[f][2] == "1" ) arrayListaResProd[f][2] = s;
        else arrayListaResProd[f][2] = n;
        if ( arrayListaResProd[f][3] == "1" ) arrayListaResProd[f][3] = s;
        else arrayListaResProd[f][3] = n;
      }
      ListaResultaProd.setDatos(arrayListaResProd);
      ListaResultaProd.display();
    }
    else if ( get('frmDatos.hTipo') == '1' )  {
      var arrayListaResCli = new Array();
      for (var f=0; f<ListaResultaCli.datos.longitud; f++) {
        arrayListaResCli[f] = new Array();
        for (var c=0; c<7; c++) {
          arrayListaResCli[f][c] = ListaResultaCli.datos.ij(f,c);
        }
      }
      for ( f=0; f<ListaResultaCli.datos.longitud; f++) {
        if ( arrayListaResCli[f][4] == "1" ) arrayListaResCli[f][4] = s;
        else arrayListaResCli[f][4] = n;
        if ( arrayListaResCli[f][5] == "1" ) arrayListaResCli[f][5] = s;
        else arrayListaResCli[f][5] = n;
      }
      ListaResultaCli.setDatos(arrayListaResCli);
      ListaResultaCli.display();
    }
  }


  function focalizarOnTabTC()  {
    try { focaliza('frmDatos.comboSubtipoCliente');
    }
    catch (e)  {
      focaliza('frmDatos.comboTipo');
    }
  }


  function focalizarOnTabVxD()  {
    try { focaliza('frmDatos.comboTipoCliente');
    }
    catch (e)  {
      focaliza('frmDatos.comboTipo');
    }
  }


  function focalizarOnShTab()  {
    if ( get('frmDatos.comboTipo','T') == GestionarMensaje(982) )
      focaliza('frmDatos.txtValorDefecto');
    else  {
      try { focaliza('frmDatos.comboSubtipoCliente');
      }
      catch (e)  {
        focaliza('frmDatos.comboTipoCliente');
      }
    }
  }


  function modificar()  {
    if ( get('frmDatos.hTipo') == '0' )  {
      if ( ListaResultaProd.seleccion.longitud == 1 )  {
        set('frmDatos.hOID',ListaResultaProd.getSeleccion());
        set('frmDatos.accion', 'Modificar');
        enviaSICC('frmDatos');        
      }
      else { GestionarMensaje('8'); focaliza('frmDatos.comboTipo'); }
    }
    else if ( get('frmDatos.hTipo') == '1' )  {
      if ( ListaResultaCli.seleccion.longitud == 1 )  {
        set('frmDatos.hOID',ListaResultaCli.getSeleccion())
        set('frmDatos.accion', 'Modificar');
        enviaSICC('frmDatos');        
      }
      else { GestionarMensaje('8'); focaliza('frmDatos.comboTipo'); }
    }
  }


  function eliminar()  {
    if ( get('frmDatos.hTipo') == '0' )  {
      if ( ListaResultaProd.seleccion.longitud >= 1 )  {
        if (GestionarMensaje('5'))  {
          set('frmDatos.hOID', ListaResultaProd.getSeleccion());
          set('frmDatos.accion', 'Eliminar');
          enviaSICC('frmDatos');
        }
        else focaliza('frmDatos.comboTipo');
      } 
      else { GestionarMensaje('4'); focaliza('frmDatos.comboTipo'); }
    }
    else if ( get('frmDatos.hTipo') == '1' )  {
      if ( ListaResultaCli.seleccion.longitud >= 1 )  {
        if (GestionarMensaje('5'))  {
          set('frmDatos.hOID', ListaResultaCli.getSeleccion());
          set('frmDatos.accion', 'Eliminar');
          enviaSICC('frmDatos');
        }
        else focaliza('frmDatos.comboTipo');
      } 
      else { GestionarMensaje('4'); focaliza('frmDatos.comboTipo'); }
    }
  }


  function consultar()  {
    if ( get('frmDatos.hTipo') == '0' )  {
      if ( ListaResultaProd.seleccion.longitud == 1 )  {
        set('frmDatos.hOID',ListaResultaProd.getSeleccion());
        set('frmDatos.accion', 'Consultar');
        enviaSICC('frmDatos');
      }
      else { GestionarMensaje('8'); focaliza('frmDatos.comboTipo'); }
    }
    else if ( get('frmDatos.hTipo') == '1' )  {
      if ( ListaResultaCli.seleccion.longitud == 1 )  {
        set('frmDatos.hOID',ListaResultaCli.getSeleccion());
        set('frmDatos.accion', 'Consultar');
        enviaSICC('frmDatos');
      }
      else { GestionarMensaje('8'); focaliza('frmDatos.comboTipo'); }
    }
  }


  function fVolver()  {
    set('frmDatos.accion','');
    enviaSICC('frmDatos');
  }


  function fBorrar()  {
    eliminar();
  }


  function fLimpiar()  {
      focaliza('frmDatos.comboTipo');
			set( 'frmDatos.comboTipo', [1] );
      completarComboNombreCampo();
 			set( 'frmDatos.comboNombreCampo', [] );
      set('frmDatos.RDObligatorio', "");
      set('frmDatos.RDModificable', "");
      set('frmDatos.txtValorDefecto',"");
      if ( habilitacionCombosCli() )  {
        set( 'frmDatos.comboTipoCliente', [] );
        accion( 'frmDatos.comboSubtipoCliente', '.disabled=true' );
      }
  
  }
