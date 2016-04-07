function onLoadPag()   
	{
      configurarMenuSecundario("frmContenido");
      //ocultarLista();
      //Elimino las filas que esten en la lista
      listado1.eliminar(0, listado1.datos.length);
      mostrarCodigoError();

    }

   function mostrarCodigoError() {  
	     
		  var vErrCodigo = get('frmContenido.errCodigo');
		  var vErrDescrip = get('frmContenido.errDescripcion');

		  if (get('frmContenido.errDescripcion')!=''){
      		var wnd = fMostrarMensajeError( vErrCodigo,vErrDescrip);
	     }		
   }

  function mostrarLista() {
	    DrdEnsanchaConMargenDcho('listado1',12);
	    
	    document.all["Cplistado1"].style.visibility='visible';
	    document.all["CpLin1listado1"].style.visibility='visible';
	    document.all["CpLin2listado1"].style.visibility='visible';
	    document.all["CpLin3listado1"].style.visibility='visible';
	    document.all["CpLin4listado1"].style.visibility='visible';

	    document.all["primera1Div"].style.visibility='hidden';
	    document.all["ret1Div"].style.visibility='hidden';
	    document.all["ava1Div"].style.visibility='hidden';
	    document.all["separaDiv"].style.visibility='hidden';
      document.all["btnEliminarDiv"].style.visibility='visible';

	    eval (ON_RSZ);  
	    ON_RSZ = '';
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
    document.all["btnEliminarDiv"].style.visibility='hidden';

  }

	function onChangeTipoCliente() {
      //alert("onchange");
      if (get('frmContenido.cbTipoCliente') != "") {
        set('frmContenido.hChangeTipoCliente', get('frmContenido.cbTipoCliente'));
        var arr = new Array();
        arr[arr.length]=new Array('oid', get('frmContenido.cbTipoCliente'));
        arr[arr.length]=new Array('oidIdioma', get('frmContenido.hIdioma'));

        recargaCombo('frmContenido.cbSubTipoCliente','MAEobtenerSubtipos', 'es.indra.sicc.util.DTOOID', arr);
      } else {
        var aCombo = new Array(new Array("",""));
        set_combo('frmContenido.cbSubTipoCliente',aCombo, []);
        set_combo('frmContenido.cbTipoClasificacion',aCombo, []);
        set_combo('frmContenido.cbClasificacion',aCombo, []);
      }
		
	}

	function onChangeSubTipoCliente() {
      if (get('frmContenido.cbSubTipoCliente') != "") {
        set('frmContenido.hChangeSubTipoCliente', get('frmContenido.cbSubTipoCliente'));
        var arr = new Array();
        arr[arr.length]=new Array('oid', get('frmContenido.cbSubTipoCliente'));
        arr[arr.length]=new Array('oidIdioma', get('frmContenido.hIdioma'));

        recargaCombo('frmContenido.cbTipoClasificacion','MAEobtenerTipoClasificacion', 'es.indra.sicc.util.DTOOID', arr);
      } else {
        var aCombo = new Array(new Array("",""));
        set_combo('frmContenido.cbTipoClasificacion',aCombo, []);
        set_combo('frmContenido.cbClasificacion',aCombo, []);
      }
		
	}

	function onChangeTipoClasificacion() {
      if (get('frmContenido.cbTipoClasificacion') != "") {
        set('frmContenido.hChangeTipoClasificacion', get('frmContenido.cbTipoClasificacion'));
        var arr = new Array();
        arr[arr.length]=new Array('oid', get('frmContenido.cbTipoClasificacion'));
        arr[arr.length]=new Array('oidIdioma', get('frmContenido.hIdioma'));

        recargaCombo('frmContenido.cbClasificacion','MAEobtenerClasificacionesPorTipo', 'es.indra.sicc.util.DTOOID', arr);
      } else {
        var aCombo = new Array(new Array("",""));
        set_combo('frmContenido.cbClasificacion',aCombo, []);
      }
		
	}

  function anyadir() {
      if (!sicc_validaciones_generales("grupo1")) {
        return;
      }
      var fila = new Array();
      var cant = listado1.datos.length;
      fila[fila.length] = cant + "";  //id
      fila[fila.length] = get('frmContenido.txtOrden');  //orden
      fila[fila.length] = get('frmContenido.cbTipoCliente','T');  //tipo cliente
      fila[fila.length] = get('frmContenido.cbSubTipoCliente','T');  //subtipo cliente
      fila[fila.length] = get('frmContenido.cbTipoClasificacion','T');  //tipo clasificacion
      fila[fila.length] = get('frmContenido.cbClasificacion','T');  //clasificacion

      fila[fila.length] = get('frmContenido.cbTipoCliente');  //oid tipo cliente
      if (get('frmContenido.cbSubTipoCliente') == "") 
          fila[fila.length] = "-1";  //oid subtipo cliente
      else
          fila[fila.length] = get('frmContenido.cbSubTipoCliente');  //oid subtipo cliente

      if (get('frmContenido.cbTipoClasificacion') == "") 
          fila[fila.length] = "-1";  //oid tipo clasificacion
      else
          fila[fila.length] = get('frmContenido.cbTipoClasificacion');  //oid tipo clasificacion

      if (get('frmContenido.cbClasificacion') == "") 
          fila[fila.length] = "-1";  //oid clasificacion
      else
          fila[fila.length] = get('frmContenido.cbClasificacion');  //oid clasificacion

      if (listado1.datos.length == 0)
          mostrarLista();
     
      listado1.insertar(fila);
      listado1.repintaDat();
  }

  function eliminar(){
        if (listado1.numSelecc() > 0)
            listado1.eliminarSelecc();
  }


  function guardar(){
      if (!sicc_validaciones_generales("grupo1")) {
      }else{
        if (ordenRepetido()) {
          GestionarMensaje("UIPED022")
        }else{
          //preparo variable a mandar a LP......
          recolectarValor();
          
          set( 'frmContenido.conectorAction', 'LPMonitorTipificacion' );
          set( 'frmContenido.accion', 'guardar' );
          eval("frmContenido").oculto="S";
          enviaSICC('frmContenido', '', '', 'N');
        }            
      }
   }
   
   function fGuardar(){
     guardar();
   }

   function ordenRepetido() {
     //cargo array, ordeno y controlo......

     var orden = new Array();
     var valorAcomparar;
     
     orden.length = listado1.datos.length;
     
     for(var x=0;x<listado1.datos.length;x++)
     {
       orden[x] = listado1.datos[x][1];                                        
     }

     //comparo....

     for(var x1=0;x1<orden.length;x1++)
     {
       valorAcomparar = orden[x1];

       for(var x2=x1+1;x2<orden.length;x2++)
       {
         if (valorAcomparar == orden[x2]) {
           return true;
         }
       }
     
     }
     return false;
   }

   function recolectarValor(){
     var val = "";
     
     for(var x=0;x<listado1.datos.length;x++){

       //val=val + "h_orden_"          +       x + "=" + listado1.datos[x][1] +";" ;
       //val=val + "h_oidTipoCliente_" +       x + "=" + listado1.datos[x][6] +";" ;
       //val=val + "h_oidSubtipoCliente_" +    x + "=" + listado1.datos[x][7] +";" ;
       //val=val + "h_oidTipoClasificacion_" + x + "=" + listado1.datos[x][8] +";" ;
       //val=val + "h_oidClasificacion_" +     x + "=" + listado1.datos[x][9] +";" ;

       val=val + listado1.datos[x][1] +";" ;
       val=val + listado1.datos[x][6] +";" ;
       val=val + listado1.datos[x][7] +";" ;
       val=val + listado1.datos[x][8] +";" ;
       val=val + listado1.datos[x][9] +";" ;
        
     }
     set('frmContenido.elementosLista',val);

   }         

   function persistioOk() {
       eval('frmContenido').oculto = 'N';
   }  