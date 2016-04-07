var varNoLimpiarSICC = true;
// ------------------------------------------------------------------------------------------------------------------------------------------------------------
function onLoadPag()  
{
	  configurarMenuSecundario("frmContenido");
	  DrdEnsanchaConMargenDcho('listado1',12);
	  muestraListado("hidden");
	  fMostrarMensajeError();
	  focaliza('frmContenido.cbMarca','');
	  accion('frmContenido.cbActividad', '.disabled=true');
	  accion('frmContenido.cbPeriodo', '.disabled=true');
	  accion('frmContenido.cbTiposCliente', '.disabled=true');
}


// ------------------------------------------------------------------------------------------------------------------------------------------------------------
function muestraListado(oculto)
{
    DrdEnsanchaConMargenDcho('listado1',12);
    document.all["Cplistado1"].style.visibility=oculto;
    document.all["CpLin1listado1"].style.visibility=oculto;
    document.all["CpLin2listado1"].style.visibility=oculto;
    document.all["CpLin3listado1"].style.visibility=oculto;
    document.all["CpLin4listado1"].style.visibility=oculto;
    document.all["separaDiv"].style.visibility=oculto;
    document.all["primera1Div"].style.visibility=oculto;
    document.all["ret1Div"].style.visibility=oculto;
    document.all["ava1Div"].style.visibility=oculto;
    document.all["detalleDiv"].style.visibility=oculto;
    document.all["btnNuevaEntradaDiv"].style.visibility=oculto;
    document.all["btnDesactivaDiv"].style.visibility=oculto;
    eval (ON_RSZ);  


}
// ------------------------------------------------------------------------------------------------------------------------------------------------------------

function ocultarLista()
{
     document.all["Cplistado1"].style.visibility='hidden';
    document.all["CpLin1listado1"].style.visibility='hidden';
    document.all["CpLin2listado1"].style.visibility='hidden';
    document.all["CpLin3listado1"].style.visibility='hidden';
    document.all["CpLin4listado1"].style.visibility='hidden';
    document.all["separaDiv"].style.visibility='hidden';
    document.all["primera1Div"].style.visibility='hidden';
    document.all["ret1Div"].style.visibility='hidden';
    document.all["ava1Div"].style.visibility='hidden';
    document.all["detalleDiv"].style.visibility='hidden';
    document.all["btnNuevaEntradaDiv"].style.visibility='hidden';
    document.all["btnDesactivaDiv"].style.visibility='hidden';

}



// ------------------------------------------------------------------------------------------------------------------------------------------------------------
function onMarcaCanalChange()
{
	//alert("OnMarcaCanalChange");
	var marca = get("frmContenido.cbMarca");
	var canal = get("frmContenido.cbCanal");
	var arrayPeriodo = armarArrayPeriodo();

    if ( marca  != "" &&  canal != ""){
	  recargaCombo('frmContenido.cbPeriodo', 'MAVObtienePeriodosBPMAV', 'es.indra.sicc.dtos.cra.DTOPeriodo', arrayPeriodo );
	  accion('frmContenido.cbPeriodo', '.disabled=false');	//Agregado
	}			
    else
	  set_combo('frmContenido.cbPeriodo', new Array() );
  
}


// ------------------------------------------------------------------------------------------------------------------------------------------------------------
function onCanalChange()
{
	// Se cambio el combo cbCanal. Debe recargar Periodo (onMarcaCanalChange) y 
	// Actividad. 

	if ( get('frmContenido.cbCanal')!="")
	{
			onMarcaCanalChange();
			var arrayActividad = armarArrayActividad();
			//alert("Carga Actividad");
			recargaCombo('frmContenido.cbActividad', 'MAVObtieneActividadesMAV', 'es.indra.sicc.dtos.mav.DTOActividadMAV', arrayActividad ); 
			accion('frmContenido.cbActividad', '.disabled=false');//Agregado
	} else
	{
		set_combo('frmContenido.cbPeriodo', new Array() );
		set_combo("frmContenido.cbActividad", new Array() );
		set_combo("frmContenido.cbTiposCliente", new Array() );
		
	}

}
// ------------------------------------------------------------------------------------------------------------------------------------------------------------
function accionDesActiva()
{
	if( !sicc_validaciones_generales("grupo1") ) 
		return;
	
	if( !sicc_validaciones_generales("grupo2") ) 
		return;

	if (listado1.numSelecc()<1) 
	{
		  GestionarMensaje('1021');
		  return false;
	}
	if (listado1.numSelecc()> 1) 
	{
		  GestionarMensaje('1022');
		  return false;
	}

    eval('frmContenido').oculto = 'S'; 
    set('frmContenido.conectorAction', 'LPCompletaDatosBP'); 
    set('frmContenido.accion', 'desactiva'); 
    set('frmContenido.oid', listado1.codSeleccionados()[0]);
    enviaSICC('frmContenido', null, null, 'N'); 
    accionBuscar();
}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------
function accionNuevaEntrada()
{

	if( !sicc_validaciones_generales("grupo1") ) 
		return;
	
	if( !sicc_validaciones_generales("grupo2") ) 
		return;
	
	var obj = new Object();

	obj.oidMarca = get("frmContenido.cbMarca");
	obj.oidCanal = get("frmContenido.cbCanal");
	obj.oidActividad = get("frmContenido.cbActividad");
	obj.oidPeriodo = get("frmContenido.cbPeriodo");
	obj.oidTipoCliente = get("frmContenido.cbTiposCliente");

	var desc =  obtieneDescCombo("frmContenido.cbMarca", get("frmContenido.cbMarca") );
	obj.descMarca = desc;

	desc =  obtieneDescCombo("frmContenido.cbCanal", get("frmContenido.cbCanal") );
	obj.descCanal = desc;

	desc =  obtieneDescCombo("frmContenido.cbActividad", get("frmContenido.cbActividad") );
	obj.descActividad = desc;
	
	desc= obtieneDescCombo("frmContenido.cbPeriodo", get("frmContenido.cbPeriodo") );
	obj.descPeriodo = desc;

	desc = obtieneDescCombo("frmContenido.cbTiposCliente", get("frmContenido.cbTiposCliente") );
	obj.descTipoCliente = desc;

	var hacePaginado = mostrarModalSICC('LPCompletaDatosBP', 'nueva', obj);
	

	if ( hacePaginado == 'hacePaginado') {
		accionBuscar();
	}

}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------
function accionDetalle()
{

	if( !sicc_validaciones_generales("grupo1") ) 
		return;
	
	if( !sicc_validaciones_generales("grupo2") ) 
		return;

	if (listado1.numSelecc()<1) 
	{
		  GestionarMensaje('1021');
		  return false;
	}
	if (listado1.numSelecc()> 1) 
	{
		  GestionarMensaje('1022');
		  return false;
	}

	var codigos = listado1.codigos();  // Tiene el formato nnn,nnn,nnn,nnn (o sea, los numeros son iguales como tantas tuplas haya
													// para este oid.).
	
	var obj = new Object(); 

	var oid = listado1.codSeleccionados();
    obj.oid = oid;

//	Modificado por ssantana, Martes 28/12/2004 - 
//  Nota: 
//          Se quita la toma de Actividad en el Detalle, porque ya se seteó
//          cuando damos al boton "Buscar" (esto es para que luego de obtener Detalles de Interface x una Activ. determinada, 
//          no se cambie la Actividad al Completar, y tengamos problemas en la pantalla siguiente con el Combo Tipo Oferta
//          y Ciclo de Vida

//	set("frmContenido.oidActividad", get("frmContenido.cbActividad") );
//	desc =  obtieneDescCombo("frmContenido.cbActividad", get("frmContenido.cbActividad") );
//	set("frmContenido.descActividad", desc);

	obj.oidActividad = get("frmContenido.oidActividad");
	obj.oidMarca = get("frmContenido.cbMarca");
	obj.oidCanal = get("frmContenido.cbCanal");
	obj.oidPeriodo = get("frmContenido.cbPeriodo");
	obj.oidTipoCliente = get("frmContenido.cbTiposCliente");

	var desc =  obtieneDescCombo("frmContenido.cbMarca", get("frmContenido.cbMarca") );
	obj.descMarca = desc;

	desc =  obtieneDescCombo("frmContenido.cbCanal", get("frmContenido.cbCanal") );
	obj.descCanal = desc;
	
	desc = obtieneDescCombo("frmContenido.cbPeriodo", get("frmContenido.cbPeriodo") );
	obj.descPeriodo = desc;

	desc = obtieneDescCombo("frmContenido.cbTiposCliente", get("frmContenido.cbTiposCliente") );
	obj.descTipoCliente = desc;

	obj.descActividad = get('frmContenido.descActividad');
	//alert("get('frmContenido.descActividad'): " + get('frmContenido.descActividad'));
	//alert("obj.descActividad: " + obj.descActividad);

	var hacePaginado = mostrarModalSICC('LPCompletaDatosBP', 'detalle', obj);
	//alert("hacePaginado: " + hacePaginado);

	if ( hacePaginado == 'hacePaginado') {
		accionBuscar();
	}

}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------
function accionBuscar()
{
	ocultarLista();
	if ( sicc_validaciones_generales('grupo2') )
	{
	  //muestraLista("visible");
	  configurarPaginado(mipgndo,"MAVObtieneDetallesMAV","ConectorObtieneDetallesMAV","es.indra.sicc.dtos.mav.DTODetalleMAV", armarArray());
  	  set("frmContenido.oidActividad", get("frmContenido.cbActividad") );
 	  desc =  obtieneDescCombo("frmContenido.cbActividad", get("frmContenido.cbActividad") );
	  //alert("desc:" + desc);
 	  set("frmContenido.descActividad", desc);

	}

}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------
function armarArray()
{
	  // Arma el array correspondiente para llamar al configurarPaginado.
	  var arrDatos = new Array();
	  var i=0;
	  if (get('frmContenido.cbPeriodo')!='') 
	  {
			arrDatos[i] = new Array('periodo',get('frmContenido.cbPeriodo'));
			i++;         
	  }
	  if (get('frmContenido.cbActividad')!='') 
	  {
			arrDatos[i] = new Array('actividad',get('frmContenido.cbActividad'));
			i++;         
	  }
	  if (get('frmContenido.cbTiposCliente')!='') 
	  {
			arrDatos[i] = new Array('tipoCliente',get('frmContenido.cbTiposCliente'));
            i++;
	  }
      // Agregado por SiCC 20070270 - Rafael Romero - 29/05/2007
	  if (get('frmContenido.txtCodProducto')!='') 
	  {
			arrDatos[i] = new Array('prodCodSAP',get('frmContenido.txtCodProducto'));
            i++;
	  }
	  if (get('frmContenido.txtUnidades')!='') 
	  {
			arrDatos[i] = new Array('unidadesEstimadas',get('frmContenido.txtUnidades'));
            i++;
	  }
      // Fin agregado SiCC 20070270

	  return arrDatos;
}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------
function armarArrayPeriodo()
{
	  var arrDatos = new Array();
	  var i=0;
	  if (get('frmContenido.cbMarca')!='')
	  {
			//arrDatos[i] = new Array('oidMarca',get('frmContenido.cbMarca'));
			arrDatos[i] = new Array('marca',get('frmContenido.cbMarca'));
			i++;
	  }
	  if (get('frmContenido.cbCanal')!='') {
			arrDatos[i] = new Array('canal',get('frmContenido.cbCanal'));
			i++;
	  }

	  arrDatos[i] = new Array( 'pais', get("frmContenido.hidPais") );

	  return arrDatos;
}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------
function armarArrayActividad()
{
	// Arma el array de datos correspondiente, para luego cargar el combo cbActividades
	var arrDatos = new Array();
	var i = 0;

	 if (get('frmContenido.cbCanal')!='') 
	 {
		  arrDatos[i] = new Array( 'oidCanal',  get('frmContenido.cbCanal')  );
		  i++;
	 }
	 arrDatos[i] = new Array( 'oidIdioma', get("frmContenido.hidIdioma")  );  
	 i++;
	 arrDatos[i] = new Array( 'oidPais', get("frmContenido.hidPais") );

	 return arrDatos;

}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------
function obtieneDescCombo(combo, codigo)
{
		// Obtiene descripcion de combo
		//alert("combo: " + combo);
		var longCombo = combo_get(combo, "L", "");
		var i = 0; 
		var match = false;
		var desc = "";
		while ( (match == false) && (i < longCombo) )
		{
			  if ( combo_get(combo, "V", i)  ==codigo )
			  {
					// Match 
					match = true;
					desc = combo_get(combo, "T", i);
					return desc;
			  }
			  i++;
		}

		return desc;

}


// ------------------------------------------------------------------------------------------------------------------------------------------------------------
function tabCompletar()
{
	var capaLista = document.getElementById("Cplistado1");
	if (capaLista.style.visibility == 'hidden')
		focaliza("frmContenido.cbMarca", "");
    else
		focalizaBotonHTML_XY('detalle');

}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------
function onshTabMarca()
{
	var capaLista = document.getElementById("Cplistado1");
	if (capaLista.style.visibility == 'hidden')
		focalizaBotonHTML('botonContenido','btnCompletar')
    else
		focalizaBotonHTML_XY('btnNuevaEntrada');

}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------
function fLimpiar()
{
	set("frmContenido.conectorAction", "LPCompletaDatosBP");
	set("frmContenido.accion", "");	
	setMV("frmContenido.cbActividad", "c");
	setMV("frmContenido.cbPeriodo", "c");
	setMV("frmContenido.cbTiposCliente", "c");
	enviaSICC("frmContenido");

}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------
function muestraLista( ultima, rowset){
	focaliza("frmContenido.cbMarca", "");
	muestraListado("visible");
	return true;
}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------
function onChangeActividad()
{
	var oidActividad = get('frmContenido.cbActividad');

	if ( oidActividad != '' )
	{
		var array = new Array();
		array[0] = ['oid', get('frmContenido.cbActividad')];
		array[1] = ['oidIdioma', get('frmContenido.hidIdioma')];
		recargaCombo('frmContenido.cbTiposCliente', 'MAVObtieneTiposClienteActividad', 'es.indra.sicc.util.DTOOID', array );
 	    accion('frmContenido.cbTiposCliente', '.disabled=false');
	} else
	{
		var arrayVacio = ['', ''];
		set_combo('frmContenido.cbTiposCliente', arrayVacio, '');
 	    accion('frmContenido.cbTiposCliente', '.disabled=true');
	}


}
// ------------------------------------------------------------------------------------------------------------------------------------------------------------
function noHayError()
{
 //alert("OK");
}
// ------------------------------------------------------------------------------------------------------------------------------------------------------------
function errorAlDesActivar()
{
 //alert("ERROR");
}