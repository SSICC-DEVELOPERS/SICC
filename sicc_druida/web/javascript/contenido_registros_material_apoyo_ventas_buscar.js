
var datosDetalle = new Array();
var arrayGlobalClientes = new Array();
var arrayGlobalDespacho = new Array(); 
var arrayGlobalProducto = new Array();

var varNoLimpiarSICC = true;

// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function onLoadPag()
{

	configurarMenuSecundario("formulario");
    DrdEnsanchaConMargenDcho('listado4',12);
    DrdEnsanchaConMargenDcho('listado3',12);
    DrdEnsanchaConMargenDcho('listado1',12);
    eval (ON_RSZ);  
	btnProxy(1,0);   // Por defecto, deshabilita el boton Guardar.


	//Permite seleccionar solo 1 elementos en las listas
	listado1.maxSel = 1;
	listado3.maxSel = 1;
	listado4.maxSel = 1;
    var error = fMostrarMensajeError();

	visibilidadListas("Clientes", "hidden");
	visibilidadListas("Productos", "hidden");
	visibilidadListas("Despacho", "hidden");
	visibilidadAceptar("hidden");

	document.selection.empty();  // Vacia la seleccion en todos los controles.
	cargaComboEstadoAutorizacion();


	// Si el criterio de asignacion es distintos de "" nos indica
	// que se está reentrando a partir de accion "buscar"
	var reentrando = get("formulario.hidReentrandoBusqueda");
	//alert("Reentrando: " + reentrando);

	if ( reentrando == "S")  // Se está reentrando luego de cliquear "Buscar" x lo que recarga los combos de criterios.
	{
			var criterioAsig = get("formulario.hidSelCriterio");
			//alert("Criterio Asignacion Reentrando: " + criterioAsig);

			var marca = get("formulario.hidSelMarca");
			var canal = get("formulario.hidSelCanal");
			var estadoEnvio = get("formulario.hidSelEstadoEnvio");
			var estadoAutorizacion = get("formulario.hidSelEstadoAutorizacion");
			var tipoCliente = get("formulario.hidSelTipoCliente");
			var tipoDespacho = get("formulario.hidSelTipoDespacho");
			reloadContenidoProductos(); // Vuelve a setear en productos lo que se encontraba antes.
			var productos = get("formulario.hidSelTipoProductos");

			// Si vino algo en estas variables, genera un array para luego marca el combo con el/los valores corresp.
			if (tipoCliente != "")
				tipoCliente = tipoCliente.split(",");

			if ( tipoDespacho != "")
				tipoDespacho  = tipoDespacho.split(",");

			if ( productos != "")
				productos = productos.split(",");

			// Setea los campos como estaban en la pantalla antes de reenviar.
			set("formulario.rbOrdenacion", criterioAsig);
			set("formulario.cbEstadoEnvio", new Array(estadoEnvio) );
			set("formulario.cbEstadoAutorizacion", new Array(estadoAutorizacion) );
			set("formulario.cbTipoClientes", tipoCliente);
			set("formulario.cbTipoDespacho", tipoDespacho);
			set("formulario.cbProductos", productos);
			set("formulario.cbMarca", new Array(marca) );
			set("formulario.cbCanal", new Array(canal) );
			recargaCombos("reentrando");

			muestraCapaSEBA('reentrando'); // Para mostrar Combo respectivo de criterio de ordenacion. 

			if ( error == false )  // No hubo error, como por ejemplo, "No se encontraron registros" 
			{
					var casoUso = get("formulario.casoUso");
					if ( casoUso == "modificar")
						btnProxy(1,1);

					// Se maneja la visibilidad de listas, se muestra la que corresponde (se presupone que en este punto)
					// se devolvio algún registro en la busqueda y no hubo error, por lo que entonces una lista se tiene que mostrar).
					if ( criterioAsig == "Despacho")
					{
						visibilidadListas("Despacho", "visible");
						visibilidadListas("Clientes", "hidden");
						visibilidadListas("Productos", "hidden")	;
						visibilidadAceptar("visible");

						var casoUso = get("formulario.casoUso");
						if ( casoUso == "consultar")
						{
							 listado3.tiposCol[4][8]=true; 
						}
						listado1.actualizaDat();
						listado1.repinta();

						// Prepara el array Global de Despacho.
						// Formato: [Indice Fila, Lista Editable, Indicador Modificado (S o N)].
						arrayGlobalDespacho = new Array();
						//alert("Registros en listado Despacho: " + arrayGlobalDespacho);
						for (var i = 0; i < listado3.datos.length; i++ )
							arrayGlobalDespacho[i] = [i, null, "N"];

						//alert("Registros en listado Despacho luego: " + arrayGlobalDespacho);

/*						datosDetalle = new Array();
						for (var i = 0; i < listado3.datos.length; i++ )
							datosDetalle[i] = [i, null, "N"];*/

					}
					
					if ( criterioAsig == "Cliente")
					{
						visibilidadListas("Despacho", "hidden");
						visibilidadListas("Clientes", "visible");
						visibilidadListas("Productos", "hidden")	;
						visibilidadAceptar("visible");

						var casoUso = get("formulario.casoUso");
						if ( casoUso == "consultar")
						{
							 listado1.tiposCol[4][8]=true; 
						}
						listado1.actualizaDat();
						listado1.repinta();

						// Prepara el array Global de Cliente.
						// Formato: [Indice Fila, Lista Editable, Indicador Modificado (S o N)].
						//alert("cant registros de listado1: " + listado1.datos.length);
						arrayGlobalClientes = new Array();
						for (var i = 0; i < listado1.datos.length; i++ )
							arrayGlobalClientes[i] = [i, null, "N"];

						//alert("Registros en listado Clientes luego: " + arrayGlobalClientes);
/*						datosDetalle = new Array();
						for (var i = 0; i < listado3.datos.length; i++ )
							datosDetalle[i] = [i, null, "N"];*/

					}

					if ( criterioAsig == "Producto")
					{
						visibilidadListas("Despacho", "hidden");
						visibilidadListas("Clientes", "hidden");
						visibilidadListas("Productos", "visible")	;
						visibilidadAceptar("hidden");

						var casoUso = get("formulario.casoUso");
						if ( casoUso == "consultar" )
						{
							 listado4.tiposCol[8][8]=true; 
							 listado4.tiposCol[9][8]=true; 
							 listado4.tiposCol[11][8]=true; 
						}

   					    listado4.actualizaDat();
						listado4.repinta();

						// Prepara array de Productos. Setea todos los campos a "N".
						arrayGlobalProducto = new Array();
						for (var i = 0; i < listado4.datos.length; i++)
						    arrayGlobalProducto[i] = "N";

						i18nListaProductos();  // Internacionaliza campo Estado Envio

					 }
			} 



	} else {
    	    muestraCapaSEBA('');
	}
	evaluaCasoUso();

	focaliza("formulario.cbMarca", "");

}

// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function muestraCapaSEBA(reentrando)
{
	// Valores de capa de Combos
	// 
	// 1 - Muestra Tipo Clientes
	// 2 - Muestra Productos
	// 3 - Muestra Tipo Despacho

//	alert("aaaaaaaaa");
	var criterio = get("formulario.rbOrdenacion");
//	alert("criterio: " + criterio);

	if ( criterio == "Despacho")
	{
			document.getElementById("Productos").style.visibility = "hidden";
			document.getElementById("TipoDespacho").style.visibility = "visible";
			document.getElementById("TipoClientes").style.visibility = "hidden";
	} else if ( criterio == "Cliente")
	{
			document.getElementById("Productos").style.visibility = "hidden";
			document.getElementById("TipoDespacho").style.visibility = "hidden";
			document.getElementById("TipoClientes").style.visibility = "visible";
	} else if ( criterio == "Producto")
	{
			document.getElementById("Productos").style.visibility = "visible";
			document.getElementById("TipoDespacho").style.visibility = "hidden";
			document.getElementById("TipoClientes").style.visibility = "hidden";
	}

	// Oculta listas editables, limpia variable global, deshabilita botón guardar, en el caso que NO
	// se esté reentrando en la pagina luego de un buscar.
	//alert("reentrando: " + reentrando);
	if ( reentrando != 'reentrando' )
	{
		visibilidadListas("Clientes", "hidden");
		visibilidadListas("Productos", "hidden");
		visibilidadListas("Despacho", "hidden");
		visibilidadAceptar("hidden");
		//datosDetalle = new Array();
		//alert("Resetea arrays");
		var arrayGlobalClientes = new Array();
		var arrayGlobalDespacho = new Array(); 
		var arrayGlobalProducto = new Array();

		//alert("Entra a ocultar en muestraCapaSeba");
		btnProxy(1,0);  // Guardar, deshabilitado.
	}

}


// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function evaluaCasoUso()
{
	var casoUso = get("formulario.casoUso");
	//alert("caso de Uso: " + casoUso);

	if ( casoUso == "consultar")
	{
	} 

	if ( casoUso == "modificar")
	{
	}
}

// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function recargaCombos(reentrando)
{
	var marca = get("formulario.cbMarca");
	var canal = get("formulario.cbCanal");

	if ( marca != "" && canal != "" )
	{
	  if (reentrando == "reentrando")  // Se está reentrando (se viene de hacer click en Buscar);
	  {
		  recargaCombo('formulario.cbPeriodo', 'MAVObtienePeriodosBP', 'es.indra.sicc.dtos.cra.DTOPeriodo', armaArrayPeriodo(), "reloadPeriodos(datos)" );
		  recargaCombo('formulario.cbSubgerencia', 'ZONRecargaSubgerenciaVentas', 'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa', armaArraySubgerencia(), "reloadSubgerencia(datos)" ); 
		  recargaCombo('formulario.cbActividad', 'MAVObtieneActividadesMAV', 'es.indra.sicc.dtos.mav.DTOActividadMAV', armaArrayActividad(), "reloadActividad(datos)" ); 
	  } else
  	  {
		  recargaCombo('formulario.cbPeriodo', 'MAVObtienePeriodosBP', 'es.indra.sicc.dtos.cra.DTOPeriodo', armaArrayPeriodo() );
		  recargaCombo('formulario.cbSubgerencia', 'ZONRecargaSubgerenciaVentas', 'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa', armaArraySubgerencia() ); 
		  recargaCombo('formulario.cbActividad', 'MAVObtieneActividadesMAV', 'es.indra.sicc.dtos.mav.DTOActividadMAV', armaArrayActividad() ); 
		  limpiarCombos();
	  }
	} else
	{
		// Limpia todos los combos dependientes de marca y canal
/*		var arrayVacio = new Array();
		set_combo("formulario.cbSubgerencia", arrayVacio);
		set_combo("formulario.cbRegion", arrayVacio);
		set_combo("formulario.cbZona", arrayVacio);
		set_combo("formulario.cbActividad", arrayVacio);
		set_combo("formulario.cbPeriodo", arrayVacio); */
		limpiarCombos();
	}

}

// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function limpiarCombos()
{
		var arrayVacio = new Array();
		//arrayVacio[0] =["",""];
		set_combo("formulario.cbSubgerencia", arrayVacio);
		set_combo("formulario.cbRegion", arrayVacio);
		set_combo("formulario.cbZona", arrayVacio);
		set_combo("formulario.cbActividad", arrayVacio);
		set_combo("formulario.cbPeriodo", arrayVacio);
 	    //document.selection.empty();
}

// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function armaArrayPeriodo()
{
	var arrayPeriodos = new Array();

	var pais = get("formulario.oidPais");
	var marca = get("formulario.cbMarca");
	var canal = get("formulario.cbCanal");

	arrayPeriodos[0] = ["pais", parseInt(pais,10) ];
	arrayPeriodos[1] = ["marca", parseInt(marca,10)];
	arrayPeriodos[2] = ["canal", parseInt(canal,10) ];

	return arrayPeriodos;
}

// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function armaArraySubgerencia()
{
	var arraySubg = new Array();

	var pais = get("formulario.oidPais");
	var marca = get("formulario.cbMarca");
	var canal = get("formulario.cbCanal");

	arraySubg[0] = ["oidPais", parseInt(pais,10) ];
	arraySubg[1] = ["oidMarca", parseInt(marca,10)];
	arraySubg[2] = ["oidCanal", parseInt(canal,10) ];
	
	return arraySubg;
}

// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function armaArrayActividad()
{
	var arrayActividad = new Array();

	var pais = get("formulario.oidPais");
	var idioma = get("formulario.oidIdioma");
	var marca = get("formulario.cbMarca");
	var canal = get("formulario.cbCanal");


	arrayActividad[0] = ["oidPais", pais];
	arrayActividad[1] = ["oidMarca", marca];
	arrayActividad[2] = ["oidCanal", canal];
	arrayActividad[3] = ["oidIdioma", idioma];

	return arrayActividad;
}

// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function buscarProducto()
{

	//Abrir ventana Modal con llamada a "LPBuscarProductosDTO" con acción "" y pasando como parámetro 
	// la variable oculta "oidMarcaCorporativa" con el valor del oid seleccionado en el combo de marca, 
	// si no hubiera ninguno seleccionado entonces pasar un null. 
	var obj = new Object();

	var marca = get("formulario.cbMarca");
	if ( marca != "")
		obj.oidMarcaCorporativa = marca;
	else	
		obj.oidMarcaCorporativa = null;

	var producto = mostrarModalSICC("LPBuscarProductosDTO", '', obj);
	if ( producto != null)
	{
			producto = producto[0].split("$");
			var longProducto = producto.length;   // Cant de Filas.

			var arrayCombo = new Array();

			// Como la cadena empieza con $, el primer elemento no se toma. De ahi que sea de 1 a longProducto - 1, y no 
			// 0 a longProducto - 1;
			for (var i = 1; i < longProducto; i++)
			{
				var fila = producto[i];
				fila = fila.split("|");

				var oid = fila[0];
				var desc = fila[2];

				arrayCombo[arrayCombo.length] = [oid, desc];

			}

			var arrayASetear = interseccion(arrayCombo);

			// Toma el valor de elementos seleccionados por el usuario.
			var codSeleccionadosCombo = get("formulario.cbProductos");


			arrayASetear = agregaEspacioBlanco(arrayASetear); // Añade espacio en blanco al principio.
			set_combo("formulario.cbProductos", arrayASetear);
			ordenaCombo_SICC( document.getElementById("cbProductos") );

			// Vuelve a seleccionar los elementos seleccionados por el usuario.
			set("formulario.cbProductos", codSeleccionadosCombo);
	}	



}

// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function interseccion(arrayProductos)
{
	// Toma arrayProductos, realiza la inserseccion con lo que hay en el combo de productos, y
	// devuelve el array sin elementos repetidos.

	// En resumen, la funcion compara los valores existentes del combo con arrayProductos, y cuando
	// no encuentra coincidencia, va poniendo el valor (oid y desc) en un array temporal (nuevoArray).
	// Finalmente, luego de realizar todo el proceso, añade el array temporal al final del array de valores
	// del combo. Este array fusionado es el que se devuelve.

	var arrayCombo = obtieneOidsComboProductos();
	//alert("oids de combo Productos: " + arrayCombo);

	var nuevoArray = new Array();

	var match = false;
	var i = 0;
	var j = 0;

	for (var i = 0; i < arrayProductos.length; i++)
	{
		match = false;
		var valor = arrayProductos[i][0];
		for ( var j = 0; (j < arrayCombo.length) && (match == false); j++ )
		{	
			if (  arrayCombo[j][0] != "")
			{
				if ( parseInt(valor, 10) == parseInt(arrayCombo[j][0], 10) )
					match = true;
			}
		}
		if ( match == false)
		{
			 // No encontró coincidencia en los valores del combo, para este valor de arrayProductos - Lo agrega.al
			 // nuevoArray, que luego contendrá se agregará al final de arrayProductos.
			 nuevoArray[nuevoArray.length] = arrayProductos[i];
		}
	}

	for (var j = 0; j < nuevoArray.length; j++)
	{
		  var indice = arrayCombo.length; 
		  arrayCombo[indice] = nuevoArray[j];
	}

	//alert("Valores que tendrá el combo (ABSOLUTO): " + arrayCombo);
	return arrayCombo;


}


// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function obtieneOidsComboProductos()
{
	var cantElems = combo_get("formulario.cbProductos", "L", "");
	//alert("cantElems: " + cantElems);
	var oids = new Array();

	for (var i = 0; i < cantElems; i++)
	{
		var oid = combo_get("formulario.cbProductos", "V", i);
		var desc = combo_get("formulario.cbProductos", "T", i);
		if ( oid != "")
		{
			var array = new Array(oid, desc);
			oids[oids.length] = array;
		}
	}
	return oids;

}

// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function agregaEspacioBlanco(array)
{
	var nuevoArray = new Array();

	nuevoArray[0] = ["", ""];

	for (var i = 0; i < array.length; i++) {
		nuevoArray[i+1] = array[i];
	}

	return nuevoArray;

}

// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function eliminaProdSeleccionados()
{
	var codSeleccionados = get("formulario.cbProductos");
	var arrayCombo = obtieneOidsComboProductos();
	var match = false;
	var nuevoArray = new Array();

	if ( codSeleccionados.length > 0)
	{
		for (var i = 0; i < arrayCombo.length; i++)
		{
			match = false;
			for ( var j = 0; (j < codSeleccionados.length) && (match == false); j++)
			{
					if ( parseInt(arrayCombo[i][0],10) == parseInt( codSeleccionados[j], 10)  )
						match = true;
			}
			if ( match == false)
				nuevoArray[nuevoArray.length] = [ arrayCombo[i][0], arrayCombo[i][1] ];
		}
	}

	nuevoArray = agregaEspacioBlanco(nuevoArray);
	set_combo("formulario.cbProductos", nuevoArray );
	ordenaCombo_SICC( document.getElementById("cbProductos") );

}

// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function onChangeSubG()
{
	// Refresca combo Región a partir de lo seleccionado en el combo SubgV y el contenido de la lista oculta de Regiones.
	// Si no hay datos en la variable oculta que indica que se ha recargado la pag, toma por defecto los seleccionados
	// en el combo Region.
	var regionesRecarga = get("formulario.hidSelRegion");
	var codSeleccionadosRegion = "";
	
	if ( regionesRecarga != "")
	{
		regionesRecarga = regionesRecarga.split(",");
		codSeleccionadosRegion = regionesRecarga;
		set("formulario.hidSelRegion", ""); 
		// Es esencial limpiar "hidSelRegion" para evitar que cuando el usuario haga onchange, se vuelva 
  		// a entrar por este branch <--- Este branch se debe ejecutar una sola vez, al entrar a la pantalla
		// cuando se recarga.
	} else {
		codSeleccionadosRegion = get("formulario.cbRegion");  // Toma los codigos seleccionados de region (por si hay)
	}

	var codSeleccionadosSubg = get("formulario.cbSubgerencia"); // Los codigos seleccionados en combo subgerencia.
	//alert("Codigos Seleccionados Subg: " + codSeleccionadosSubg);

    var longListaRegiones = listaRegiones.datos.longitud;

	var arrayRegiones = new Array();
	
	for (var i = 0; i  < codSeleccionadosSubg.length; i++)
	{
		//var match = false;
		for (var j = 0; (j < longListaRegiones); j++)
		{
			if ( listaRegiones.datos.ij(j, 0) == codSeleccionadosSubg[i] )
			{
				//match = true;
				var oidRegion = listaRegiones.datos.ij(j,1);
				var descRegion = listaRegiones.datos.ij(j,2);
				arrayRegiones[arrayRegiones.length] = [oidRegion, descRegion];
			}
		}
	 }

	 arrayRegiones = agregaEspacioBlanco(arrayRegiones);
	 //alert("arrayRegiones: " + arrayRegiones);
	 set_combo("formulario.cbRegion", arrayRegiones);
	 ordenaCombo_SICC( document.getElementById("cbRegion") );

	 set("formulario.cbRegion", codSeleccionadosRegion ); // setea los valores seleccionados antes en Regiones (por si había alguno, para uqe no se pierda)
  	 onChangeRegiones();

}

// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function onChangeRegiones()
{
	// Refresca combo Zonas a partir de lo seleccionado en el combo Regiones y el contenido de la lista oculta de Zonas.
	var zonasRecarga = get("formulario.hidSelZona");
	var codSeleccionadosZonas = "";

	if (zonasRecarga != "")
	{
		zonasRecarga = zonasRecarga.split(",");
		codSeleccionadosZonas = zonasRecarga;
		set("formulario.hidSelZona", "");
	} else {
		codSeleccionadosZonas = get("formulario.cbZona");  // Toma los codigos seleccionados de Zonas (por si hay)
	}

	var codSeleccionadosRegion = get("formulario.cbRegion"); // Los codigos seleccionados en combo Region.
    var longListaZonas = listaZonas.datos.longitud;
	var arrayZonas = new Array();
	
	for (var i = 0; i  < codSeleccionadosRegion.length; i++)
	{
		//var match = false;
		for (var j = 0; (j < longListaZonas); j++)
		{
  		  /*alert("listaZonas.datos.ij(" + j + ", 1): " + listaZonas.datos.ij(j, 1) );
			alert("codSeleccionadosRegion[" + i + "]: " + codSeleccionadosRegion[i]);*/
			if ( listaZonas.datos.ij(j, 1) == codSeleccionadosRegion[i] )
			{

				//match = true;
				var oidZona = listaZonas.datos.ij(j,0);
				var descZona = listaZonas.datos.ij(j,2);
				arrayZonas[arrayZonas.length] = [oidZona, descZona];
				//alert("Match - " + oidZona + " - " + descZona);
			}
		}
	 }

	 //alert("arrayZonas: " + arrayZonas);
	 arrayZonas = agregaEspacioBlanco(arrayZonas);

	 set_combo("formulario.cbZona", arrayZonas);
	 ordenaCombo_SICC( document.getElementById("cbZona") );

	 set("formulario.cbZona",  codSeleccionadosZonas); // setea los valores seleccionados antes en Regiones (por si había alguno, para uqe no se pierda)

}

// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function accionBuscar()
{
	var criterio = get("formulario.rbOrdenacion");
	var casoUso = get("formulario.casoUso");
	//alert("Criterio: " + criterio);

	set("formulario.hidCriterioOrdenacion", criterio);
	set("formulario.accion", "buscarRegistros");
	set("formulario.conectorAction", "LPMantenimientoRegistrosMAV");
	seteaCamposSeleccion();
	eval("formulario").oculto = "N";
	enviaSICC("formulario");

}

// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 function visibilidadListas(lista, visibilidad)
 {
	if ( lista == "Clientes" )
	{
		document.all["Cplistado1"].style.visibility=visibilidad;
		document.all["CpLin1listado1"].style.visibility=visibilidad;
		document.all["CpLin2listado1"].style.visibility=visibilidad;
		document.all["CpLin3listado1"].style.visibility=visibilidad;
		document.all["CpLin4listado1"].style.visibility=visibilidad;
		document.all["primera1Div"].style.visibility=visibilidad;
		document.all["ret1Div"].style.visibility=visibilidad;
		document.all["ava1Div"].style.visibility=visibilidad;
		document.all["separa1Div"].style.visibility=visibilidad;
		//document.all["btnAceptar"].style.visibility=visibilidad;
		document.all["btnAceptar"].style.visibility='hidden';
	}

	if ( lista == "Despacho")
	{
		document.all["Cplistado3"].style.visibility=visibilidad;
		document.all["CpLin1listado3"].style.visibility=visibilidad;
		document.all["CpLin2listado3"].style.visibility=visibilidad;
		document.all["CpLin3listado3"].style.visibility=visibilidad;
		document.all["CpLin4listado3"].style.visibility=visibilidad;
		document.all["primera3Div"].style.visibility=visibilidad;
		document.all["ret3Div"].style.visibility=visibilidad;
		document.all["ava3Div"].style.visibility=visibilidad;
		document.all["separa3Div"].style.visibility=visibilidad;
		document.all["btnAceptar"].style.visibility='hidden';
	}

	if ( lista == "Productos")
	{
		document.all["Cplistado4"].style.visibility=visibilidad;
		document.all["CpLin1listado4"].style.visibility=visibilidad;
		document.all["CpLin2listado4"].style.visibility=visibilidad;
		document.all["CpLin3listado4"].style.visibility=visibilidad;
		document.all["CpLin4listado4"].style.visibility= visibilidad;
		document.all["primera4Div"].style.visibility=visibilidad;
		document.all["ret4Div"].style.visibility=visibilidad;
		document.all["ava4Div"].style.visibility=visibilidad;
		document.all["separa4Div"].style.visibility=visibilidad;
	}

	eval(ON_RSZ);
}

// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function visibilidadAceptar(visibilidad)
{
	document.all["btnAceptar2"].style.visibility=visibilidad;
	document.all["btnAceptar"].style.visibility='hidden';

}


// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function accionAceptar()
{
	//alert("Entro a aceptar");
	var obj = new Object();
	var casoUso = get("formulario.casoUso");
	var criterio = get("formulario.rbOrdenacion");
	//alert("criterio: " + criterio);

	// *********** Criterio Despacho
	if ( criterio == "Despacho")
	{
    	listado3.actualizaDat();
		obj.casoUso = casoUso;
		obj.criterio = criterio;
		var codSeleccionados = listado3.numSelecc();
		//alert("CodSeleccionados: " + codSeleccionados );
		//var codSeleccionados = listado3.codSeleccionados();

		if ( codSeleccionados == 1)
		{
			//var filasSeleccionadas = listado3.selecc;
			var indexFila = obtieneIndiceLE("Despacho");
			//alert("indice Fila: " + indexFila);
			var registroLeidoAnteriormente = arrayGlobalDespacho[indexFila];
			var fila = registroLeidoAnteriormente[1];
			//alert("fila: " + fila);

			if ( fila == null || casoUso == "consultar")  
			{
					// No se entro nunca a este registro o es caso de uso Consultar.
					// Obtiene los datos necesarios para buscar en la BD.
					var datosDespacho = obtieneDatosLE(indexFila, "Despacho");

					// Validacion de Fecha de Entrega realizada por ssantana, 2/3/2005
					// por inc. bloqueante MAV-08
					var fechaEntrega = datosDespacho[2];

					/*if ( fechaEntrega != "")
					{
					   
						var fechaValida = EsFechaValida_SICC(fechaEntrega, "formulario");
						// Ahora sabiendo si es Fecha Valida o no, si no es válida, focalizo.
						if ( !fechaValida )
						{
							sicc_focaliza_componente_LE("txtFechaEntrega3_" + indexFila, "listado3");
							//alert("No es Valida Fecha");
							return;
						}
					}*/

					obj.oidTipoDespacho = datosDespacho[0];
					obj.codCliente = datosDespacho[1];
					obj.fechaEntrega = datosDespacho[2];
					obj.oidTipoCliente = datosDespacho[3];
					obj.reentrando = "N";
			} else 
			{
					//alert("Filas a setear: " + fila);
					obj.reentrando = "S";
					obj.listaToSet = fila;
			}


			var retorno = mostrarModalSICC("LPMantenimientoRegistrosMAV", "detalle", obj);

			if ( retorno != null)
			{
				var arrayTemp = arrayGlobalDespacho[indexFila];
				//alert("arrayTemp: " + arrayTemp);
				arrayTemp[1] = retorno;
			}
			
		} else
		{
			GestionarMensaje("1413");
			//alert("Se debe seleccionar solo 1 registro");
			return;
		}

	}

	// *********** Criterio Cliente
	if (criterio == "Cliente")
	{
		listado1.actualizaDat();

		obj.casoUso = casoUso;
		obj.criterio = criterio;

		//var codSeleccionados = listado1.codSeleccionados();
		var codSeleccionados = listado1.numSelecc();

		if ( codSeleccionados== 1)
		{
			var indexFila = obtieneIndiceLE("Cliente");
			var registroLeidoAnteriormente = arrayGlobalClientes[indexFila];
			var fila = registroLeidoAnteriormente[1];

			if ( fila == null || casoUso == "consultar")
			{
				var datosCliente = obtieneDatosLE(indexFila, "Cliente");

				// Validacion de Fecha de Entrega realizada por ssantana, 2/3/2005
				// por inc. bloqueante MAV-08
				var fechaEntrega = datosCliente[2];

				/*if ( fechaEntrega != "")
				{
					//var fechaValida = EsFechaValida_SICC(fechaEntrega, "formulario");
					var fechaValida = validaFechaIndividualLista(fechaEntrega, "listado1");
					if ( !fechaValida )
					{
						//alert("No es Valida Fecha");
						sicc_focaliza_componente_LE("txtFechaEntrega1_" + indexFila, "listado1");
						return;
					}
				}*/

				obj.oidTipoCliente = datosCliente[0];
				obj.codCliente = datosCliente[1];
				obj.fechaEntrega = datosCliente[2];
				obj.oidTipoDespacho = datosCliente[3];
				obj.reentrando = "N";  
			 }	else {
				 //alert("Filas a setear: " + fila);
				 obj.reentrando = "S";
				 obj.listaToSet = fila;
			 }

 			 var retorno = mostrarModalSICC("LPMantenimientoRegistrosMAV", "detalle", obj);

			if ( retorno != null)
			{
				var arrayTemp = arrayGlobalClientes[indexFila];
				//alert("arrayTemp: " + arrayTemp);
				arrayTemp[1] = retorno;
			}

		} else
 		{
			GestionarMensaje("1413");
			//alert("Se debe seleccionar solo 1 registro");
			return;
		}

	}

}

// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
/*function validaFechaIndividualLista(fecha, nombreListado)
{
	var array = new Array();
	var subArray = new Array();

	subArray[0] = fecha;
	array[0] = subArray;

	var fechaValida = sicc_validar_fecha_LE(   "",    // Campo a focalizar, como no se focalizara en ningun fila, no impoorta
																  "",    // No se usa en esta funcion
																  "",    // Fecha Desde (no se necesita)
																  "",    // Fecha Hasta (idem)
																  "",    // Formato de Fecha de Usuario (idem)
																  "",    // Nombre de Lista (idem)
																  0,    // Posicion Columna (0 en este caso, es un Array Unidimensional)
																  "N",  // No pongo el foco si pincha 
																  array
                         									  );    

	 return fechaValida;

}*/

// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function obtieneIndiceLE(lista)
{
	// Obtiene el indice de la fila de la listaEditable <lista> a partir de la fila selecionada, y lo devuelve.
	// Si no lo encuentra devuelve -1.

	var filasSeleccionadas = null;
	if ( lista == "Cliente")
		filasSeleccionadas = listado1.selecc;

	if ( lista == "Despacho")
		filasSeleccionadas = listado3.selecc;

	var match = false;
	var index = -1;

	for (var i = 0; (i < filasSeleccionadas.length) && (match == false); i++ )
	{
		if (filasSeleccionadas[i] == 1)  // Fila Seleccionada
		{
			index = i;
			match = true;
		}
	}

	//alert("Indice a devolver: " + index);


/*	var datos = null;
	if (lista == "Cliente")
		datos = listado1.datos;

	if (lista == "Despacho")
		datos = listado3.datos;


	var match = false;
	var index = -1;
	for ( var i = 0; (i < datos.length) && (match == false); i++ )
	{
		var temp = datos[i];
		if ( parseInt(temp,10)  == parseInt(codigo,10) )
		{
			index = i;
			match = true;
		}
	} */

	return index;

}

// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function obtieneDatosLE(index, lista)
{
	var datos = null;
	var arrayToReturn = new Array();
	if (lista == "Cliente")
	{
		datos = listado1.datos;
		arrayToReturn[0] = datos[index][0];  // Oid Tipo Cliente.
		arrayToReturn[1] = datos[index][2];  // Codigo Cliente.
		//arrayToReturn[2] = datos[index][5];  // Fecha Entrega

		// Modific. x ssantana, 3/3/2005 - Se toma ahora la Fecha de Entrega de la columna oculta
		// para evitar que la cambie el usuario y debido a esto luego no traiga datos la modal.
		arrayToReturn[2] = datos[index][7];  // Fecha Entrega 

		arrayToReturn[3] = datos[index][6];  // Oid Tipo Despacho.
	}

	if (lista == "Despacho") 
	{
		datos = listado3.datos;
		arrayToReturn[0] = datos[index][0]; // Oid Tipo Despacho
		arrayToReturn[1] = datos[index][2]; // Codigo Cliente
		//arrayToReturn[2] = datos[index][5]; // Fecha Entrega

		// Modific. x ssantana, 3/3/2005 - Se toma ahora la Fecha de Entrega de la columna oculta
		// para evitar que la cambie el usuario y debido a esto luego no traiga datos la modal.
		arrayToReturn[2] = datos[index][7]; // Fecha Entrega

		arrayToReturn[3] = datos[index][6]; // Oid Cliente
	}

	return arrayToReturn;

}

// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function seteaCamposSeleccion()
{
	var marca = get("formulario.cbMarca");
	var canal = get("formulario.cbCanal");
	var subg = get("formulario.cbSubgerencia");
	var region = get("formulario.cbRegion");
	var zona = get("formulario.cbZona");
	var actividad = get("formulario.cbActividad");
	var periodo = get("formulario.cbPeriodo");
	var estadoEnvio = get("formulario.cbEstadoEnvio");  // "P" o "E"
	var estadoAutorizacion = get("formulario.cbEstadoAutorizacion");  // 1,2,3,4,5
	var criterio = get("formulario.rbOrdenacion");
	var tipoCliente = get("formulario.cbTipoClientes");
	var tipoDespacho = get("formulario.cbTipoDespacho");
	var productos = get("formulario.cbProductos");
	var contenidoCbProductos = obtieneOidsComboProductos();

	set("formulario.hidSelMarca", marca);
	set("formulario.hidSelCanal", canal);
	set("formulario.hidSelSubg", subg);
	set("formulario.hidSelRegion", region);
	set("formulario.hidSelZona", zona);
	set("formulario.hidSelActividad", actividad);
	set("formulario.hidSelPeriodo", periodo);
	set("formulario.hidSelEstadoEnvio", estadoEnvio);
	set("formulario.hidSelEstadoAutorizacion", estadoAutorizacion);
	set("formulario.hidSelCriterio", criterio);
	set("formulario.hidSelTipoCliente", tipoCliente);
	set("formulario.hidSelTipoDespacho", tipoDespacho);
	set("formulario.hidSelTipoProductos", productos);
	set("formulario.hidContenidoProductos", contenidoCbProductos);

}

// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function recargaCamposBusqueda()
{
	






}

// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function reloadPeriodos(datos)
{
	var newDatos = new Array();
	var periodoSeleccionado = get("formulario.hidSelPeriodo");

	newDatos[0] = ["", ""];

	for (var i = 0; i < datos.length; i++)
		newDatos[i+1] = datos[i];

	set_combo("formulario.cbPeriodo", newDatos);
	set("formulario.cbPeriodo", new Array(periodoSeleccionado) );
}

// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function reloadSubgerencia(datos)
{
	//alert("Reload Subgerencias");
	var newDatos = new Array();
	var subg = get("formulario.hidSelSubg");
	if (subg != "")
		subg = subg.split(",");

	newDatos[0] = ["", ""];

	for (var i = 0; i < datos.length; i++)
		newDatos[i+1] = datos[i];

	set_combo("formulario.cbSubgerencia", newDatos);
	set("formulario.cbSubgerencia", new Array(subg) );
	onChangeSubG();
}

// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function reloadActividad(datos)
{
	var newDatos = new Array();
	var activ = get("formulario.hidSelActividad");
	if (activ != "")
		activ = activ.split(",");

	newDatos[0] = ["", ""];

	for (var i = 0; i < datos.length; i++)
		newDatos[i+1] = datos[i];

	set_combo("formulario.cbActividad", newDatos);
	set("formulario.cbActividad", new Array(activ) );

}

// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function reloadContenidoProductos()
{
	var newDatos = new Array();
	var prods = get("formulario.hidContenidoProductos");

	if (prods != "")
	{
		prods = prods.split(",");
		var i = 0;
		while ( i < prods.length)
		{
			var cod = prods[i];
			var desc = prods[i+1];
			i = i + 2;
			newDatos[newDatos.length] = [cod, desc];
		}
	 }

	 //alert("Combo Productos reconstruido: " + newDatos);
	 set_combo("formulario.cbProductos", newDatos);

}

// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function tipoClienteChange(indiceFila)
{
	var arrayTemp = arrayGlobalClientes[indiceFila];
	arrayTemp[2] = "S";
	//alert("arrayGlobalClientes: " + arrayGlobalClientes);
	//alert("arrayTemp TipoCliente: " + arrayTemp);
}

// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function tipoDespachoChange(indiceFila)
{
	var arrayTemp = arrayGlobalDespacho[indiceFila];
	arrayTemp[2] = "S";
	//alert("arrayTemp Despacho: " + arrayTemp);
}

// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function productoChange(indiceFila)
{
	arrayGlobalProducto[indiceFila] = "S";
}

// ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function fGuardar()
{
	// Filas modificadas de la tabla de criterio.

	// Setea criterio ordenacion.
	var criterioOrden = get("formulario.rbOrdenacion");
	set("formulario.hidCriterioOrdenacion", criterioOrden);
	//alert("Criterio: " + criterioOrden);
	
	// ***************************** Cliente ***********************************
	if ( criterioOrden == "Cliente" )
	{
		listado1.actualizaDat();
		var ok = validaClientes();
		if ( ok )
		{
			var arrayClienteToSend = guardarClientes();
			var productosModal = obtieneProductosModal("Cliente");
			set("formulario.hidAgrupacionCliente", arrayClienteToSend); 
			set("formulario.hidProductosCD", productosModal);
		} else {
			return;
		}


	}

	// ***************************** Producto ***********************************
	if ( criterioOrden == "Producto")
	{
		listado4.actualizaDat();
		var ok = validaProductos();
		if ( ok )
		{
			var arrayProductoToSend = guardarProductos();
			set("formulario.hidAgrupacionProductos", arrayProductoToSend);
		} else{
			return;
		}
	}

	// ***************************** Despacho ***********************************
	if ( criterioOrden == "Despacho")
	{
		listado3.actualizaDat();
		var ok = validaDespacho();
		if (ok)
		{
			var arrayDespToSend = guardarDespacho();
			var productosModal = obtieneProductosModal("Despacho");
			set("formulario.hidAgrupacionDespacho", arrayDespToSend);
			set("formulario.hidProductosCD", productosModal);
		} else
		{
			return;
		}


	}

	eval("formulario").oculto = "S";
	set("formulario.conectorAction", "LPMantenimientoRegistrosMAV");
	set("formulario.accion", "guardar");
	enviaSICC("formulario");


}

// ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function guardarClientes()
{
	//alert("Entro a cliente");
	listado1.actualizaDat();
	validaClientes();  // TODO: implementar este metodo

	var longArrayCliente = arrayGlobalClientes.length;

	var arrayListaCliente = listado1.datos;
	var arrayToSend = new Array();

	for (var i = 0; i < longArrayCliente; i++)
	{
		var modificado = arrayGlobalClientes[i][2];
		//alert("Modificado: " + modificado);

		if (modificado == "S")
		{
			// Campos a enviar
			var oidTipoCliente = arrayListaCliente[i][0];
			var codCliente = arrayListaCliente[i][2];
			var fechaEntrega = arrayListaCliente[i][5];
			if (fechaEntrega == "")
				fechaEntrega = " ";
			var oidTipoDespacho = arrayListaCliente[i][6];
			//arrayToSend[arrayToSend.length] = [oidTipoCliente, fechaEntrega, oidTipoDespacho];
			arrayToSend[arrayToSend.length] = [oidTipoCliente, codCliente, fechaEntrega, oidTipoDespacho];
		}
		
	}
	//alert("arrayToSend: " + arrayToSend);

	return arrayToSend;

}

// ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function guardarDespacho()
{
	//alert("Entro a Despacho");

	var longArrayDespacho = arrayGlobalDespacho.length;
	listado3.actualizaDat();
	var arrayListaDespacho = listado3.datos;
	var arrayToSend = new Array();

	for (var i = 0; i < longArrayDespacho; i++)
	{
		var modificado = arrayGlobalDespacho[i][2];
		//alert("Modificado: " + modificado);

		if (modificado == "S")
		{
			// Campos necesarios
			var oidTipoDespacho = arrayListaDespacho[i][0];
			var codCliente = arrayListaDespacho[i][2];
			var fechaEntrega = arrayListaDespacho[i][5];
			if (fechaEntrega == "")
				fechaEntrega = " ";

			var oidTipoCliente = arrayListaDespacho[i][6];

			arrayToSend[arrayToSend.length] = [oidTipoCliente, codCliente, fechaEntrega, oidTipoDespacho];
		}

	}
	//alert("arrayToSend: " + arrayToSend);
	return arrayToSend;

}

// ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function guardarProductos()
{
	//alert("Entro a producto");
	listado4.actualizaDat();

	var longArrayProd = arrayGlobalProducto.length;

	var arrayListaProductos = listado4.datos;
	var arrayToSend = new Array();
	for (var i = 0; i < longArrayProd; i++)		
	{
		var modificado = arrayGlobalProducto[i];

		if (modificado == "S")
		{
			// Campos necesarios:
			var oidEnvio = arrayListaProductos[i][0];
			var fechaEntrega = arrayListaProductos[i][9];
			if (fechaEntrega == "")
				fechaEntrega = " ";
			var numUnidades = arrayListaProductos[i][10];
			var estadoEnvio = arrayListaProductos[i][12];

			arrayToSend[arrayToSend.length] = [oidEnvio, fechaEntrega, numUnidades, estadoEnvio];
		}
	}
	//alert("arrayToSend: " + arrayToSend);
	return arrayToSend;

}

// ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function obtieneProductosModal(tipoArray)
{
	// Obtiene el array de la pantalla modal . 
	//alert("Entro a obtieneProductosModal");
	//alert("Tipo Array: " + tipoArray);

	var retorno = "";
	var longitud = "";

	if ( tipoArray == "Cliente" )
		longitud = arrayGlobalClientes.length;
	 else if ( tipoArray = "Despacho")
		longitud = arrayGlobalDespacho.length;
	
	var variableFormulario = "";
	for (var i = 0; i < longitud; i++)
	{
		// Obtiene el array de Productos para la fila actual segun el criterio que corresponda
		var subArray = "";
		if ( tipoArray == "Cliente" )
			subArray = arrayGlobalClientes[i][1];
		 else if ( tipoArray = "Despacho")
			subArray = arrayGlobalDespacho[i][1];
	
		//alert("SubArray: " + subArray);
		if ( subArray != null )   // Si este array es distinto de null, toma los valores necesarios.
		{
				var arrayTemp = valoresArrayProductos(subArray);
				if (variableFormulario != "")
					variableFormulario = variableFormulario + ",";
				variableFormulario = variableFormulario + arrayTemp;
		}
	}
	//alert("Variable Formulario a setear: " + variableFormulario);
	retorno = variableFormulario;

	return retorno;

}

// ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function valoresArrayProductos(array)
{
	// Devuelve un array con los valores que se han cambiado en la modal de productos
	var longitud = array.length;
	var arrayToReturn = new Array();
	for (var i = 0; i < longitud; i++)
	{
		var modificado = array[i][6];

		if ( modificado == "S")
		{
			var oidEnvio = array[i][0];
			var unidades = array[i][3];
			var estadoEnvio = array[i][5];

			arrayToReturn[arrayToReturn.length] = [oidEnvio, unidades, estadoEnvio];
		}
	}

	//alert("Array de Modal a retornar: " + arrayToReturn);
	return arrayToReturn;

}

// ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function fLimpiar()
{
	
	var casoUso = get("formulario.casoUso");

	set("formulario.accion", "buscar");
	set("formulario.casoUso", casoUso);
	set("formulario.conectorAction", "LPMantenimientoRegistrosMAV");

	eval("formulario").oculto = "N";

	enviaSICC("formulario");

}

// -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function tabOrdenacion()
{
	// Dependiendo del criterio de ordenacion, focaliza el combo correspondiente.
	var criterioOrdenacion = get("formulario.rbOrdenacion");
	if ( criterioOrdenacion == "Cliente")
		focaliza("formulario.cbTipoClientes", "");
	
	if ( criterioOrdenacion == "Producto")
		focaliza("formulario.cbProductos", "");

	if ( criterioOrdenacion == "Despacho")
		focaliza("formulario.cbTipoDespacho", "");
}

// -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function focalizaBtnBuscar()
{
    focalizaBotonHTML('botonContenido','btnBuscar');
}

// -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function shTabBuscar()
{
	// On Shift Tab del boton Buscar
	var criterioOrdenacion = get("formulario.rbOrdenacion");
	if ( criterioOrdenacion == "Cliente")
		focaliza("formulario.cbTipoClientes", "");
	
	if ( criterioOrdenacion == "Producto")  // Focaliza boton eliminar
	    focalizaBotonHTML('botonContenido','btnEliminar');

	if ( criterioOrdenacion == "Despacho")
		focaliza("formulario.cbTipoDespacho", "");	
}

// -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function tabBuscar()
{
	// Se dipara al hacer tab en el boton buscar. 
	// Chequea si hay alguna lista mostrada. Si es así, focaliza el primer elemento. Si no, realizar wraparound y vuelve 
	// al comienzo de la pantalla.
	var capaListado1 = document.getElementById("Cplistado1");
	var capaListado3 = document.getElementById("Cplistado3");
	var capaListado4 = document.getElementById("Cplistado4");

	var visibilidad1 = capaListado1.style.visibility;   // Clientes
	var visibilidad3 = capaListado3.style.visibility;   // Despacho
 	var visibilidad4 = capaListado4.style.visibility;   // Productos
	//alert("Visibilidad1 (Clientes): " + visibilidad1);
	//alert("Visibilidad3 (Despacho): " + visibilidad3);
	//alert("Visibilidad4 (Productos): " + visibilidad4);

	if ( visibilidad1 == "visible" || visibilidad1 == "" || visibilidad1 == "inherit")  // Chequea visibilidad de lista Clientes
	{

		var hayFilas = hayElementos('listado1');
		if (hayFilas) 
		{
			listado1.preparaCamposDR();
			focaliza("frmlistado1.txtFechaEntrega1_0");
		} else  // Focaliza boton aceptar de listado1
		{
			focalizaBotonHTML_XY("btnAceptar");
		}

	} else if ( visibilidad3 == "visible" || visibilidad3 == "" || visibilidad3 == "inherit")  // Chequea visibilidad de lista Despacho
	{

		var hayFilas = hayElementos('listado3');
		if (hayFilas) 
		{
			listado3.preparaCamposDR();
			focaliza("frmlistado3.txtFechaEntrega3_0");
		} else    // Focaliza boton aceptar de listado3
		{
			focalizaBotonHTML_XY("btnAceptar2");
		}

	} else if ( visibilidad4 == "visible" || visibilidad4 == "" || visibilidad4 == "inherit")  // Cheque visibilidad de lista Productos
	{

		var hayFilas = hayElementos("listado4");
		if ( hayFilas )
		{
			listado4.preparaCamposDR();
			focaliza("frmlistado4.txtFechaEntrega4_0");
		} else  // Realiza Wraparound
		{
			//alert("WrapAround");
			focaliza("formulario.cbMarca", "");
		}

	} else  // Ejecuta wraparound
	{
			focaliza("formulario.cbMarca", "");
	}

}

// -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function hayElementos(listado)
{
	// Devuelve true si hay alguna fila en la lista <listado>

	var datos = eval(listado + ".datos;");

	if ( datos == null || datos.length == 0)
		return false;
	else
		return true;

}

// -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function shTabMarca()
{
	//  OnShiftTab en Combo Marca. Si alguna lista esta visible, chequea si es tipo Cliente o Despacho
	var capaListado1 = document.getElementById("Cplistado1");
	var capaListado3 = document.getElementById("Cplistado3");
	var capaListado4 = document.getElementById("Cplistado4");

	var visibilidad1 = capaListado1.style.visibility;   // Clientes
	var visibilidad3 = capaListado3.style.visibility;   // Despacho
 	var visibilidad4 = capaListado4.style.visibility;   // Productos
	//alert("Visibilidad1 (Clientes): " + visibilidad1);
	//alert("Visibilidad3 (Despacho): " + visibilidad3);
	//alert("Visibilidad4 (Productos): " + visibilidad4);

	if ( visibilidad1 == "visible" || visibilidad1 == "" || visibilidad1 == "inherit")  // Chequea visibilidad de lista Clientes
	{
		focalizaBotonHTML_XY("btnAceptar");
	} else if ( visibilidad3 == "visible" || visibilidad3 == "" || visibilidad3 == "inherit")  // Chequea visibilidad de lista Despacho
	{
		focalizaBotonHTML_XY("btnAceptar2");
	} else if ( visibilidad4 == "visible" || visibilidad4 == "" || visibilidad4 == "inherit")  // Chequea visibilidad de lista Producto
	{
		var hayFilas = hayElementos("listado4");
		if ( hayFilas )  // Focaliza la ultima fila, campo Fecha Entrega
		{
			var cantFilas = listado4.datos.length;
			listado4.preparaCamposDR();
			focaliza("frmlistado4.cbEstadoAutorizacion4_" + (cantFilas-1));
		}
	} else  // Si ninguna lista esta visible, focaliza Boton Buscar.
	{
	    focalizaBotonHTML('botonContenido','btnBuscar');
	}

}

// -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function onShTabBtnAceptar(listado)
{
	// On Shift Tab Boton Aceptar.
	var hayFilas = hayElementos(listado);
	if (hayFilas)  // Focaliza la ultima caja de texto de la lista.
	{
		if (listado == 'listado1')  // Lista Clientes
		{
			var cantFilas = listado1.datos.length;
			listado1.preparaCamposDR();
			focaliza("frmlistado1.txtFechaEntrega1_" + (cantFilas-1) );
		} 

		if ( listado == 'listado3' ) // Lista Despacho
		{
			var cantFilas = listado3.datos.length;
			listado3.preparaCamposDR();
			focaliza("frmlistado3.txtFechaEntrega3_" + (cantFilas-1) );
		}


	} else  // Focaliza el boton buscar
	{
	    focalizaBotonHTML('botonContenido','btnBuscar');		
	}




}

// -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function validaProductos()
{
	//alert("Valida Productos");
	var ok = sicc_validar_fecha_LE("txtFechaEntrega4", GestionarMensaje("1410",null,null,null), "", "", "", "listado4", 9, "S");
	if (ok)
        ok = sicc_valida_requerido_LE("txtNumUnidades4", GestionarMensaje("1408", null, null, null), "listado4", 10);
	if (ok)
		ok = sicc_valida_numero_LE("txtNumUnidades4", GestionarMensaje("1408", null, null, null), 0, 999, "Entero", "listado4", 10);

	return ok;
	// Valida que numero de Unidades sea numerico, y no este vacio.
/*	alert("Valida Productos");
	datos = listado4.datos;
	var flagBreak = true;
	for (var i = 0; (i < datos.length) && (flagBreak); i++ )
	{
		var unidades = datos[i][10];
		alert("Unidades: " + unidades);
		if ( unidades == null || unidades == "")  // Cheque que no sea vacio
		{
			alert("Nulo o vacio");	
			GestionarMensaje("1534", GestionarMensaje("1408", null, null, null),  null, null);
			listado4.preparaCamposDR();
			focaliza('frmlistado4.txtNumUnidades4_'+i, ''); 
			flagBreak = false;
		} else  // Chequea que sea numerico.
		{
			flagBreak = validar(unidades, "0123456789");
			if (!flagBreak)
			{
				alert("Numero No valido");	
				GestionarMensaje("000000000000100", GestionarMensaje("1408", null, null, null),  null, null);
				listado4.preparaCamposDR();
				focaliza('frmlistado4.txtNumUnidades4_'+i, ''); 
			}
		 }

	}

	return flagBreak;*/
}

// -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function validaDespacho()
{
	//alert("Valida Despacho");
	var ok = sicc_validar_fecha_LE("txtFechaEntrega3", GestionarMensaje("1410",null,null,null), "", "", "", "listado3", 5, "S");
	return ok;
}

// -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function validaClientes()
{
	//alert("Valida Clientes");
	var ok = sicc_validar_fecha_LE("txtFechaEntrega1", GestionarMensaje("1410",null,null,null), "", "", "", "listado1", 5, "S");
	return ok;
}

// -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function validar(valor, caracteres)
{
	var permitidos = caracteres;
	var c;

	for(var i=0; i<valor.length; i++) 
	{
			c = valor.charAt(i);
			if (permitidos.indexOf(c) == -1 ) 
				return false;
	}
	return true;
}

// -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function cargaComboEstadoAutorizacion()
{

	var datos = new Array();
	datos[0] = ["", ""];
	datos[1] = ["P", GestionarMensaje("1411", null,null,null) ];
	datos[2] = ["E", GestionarMensaje("1412", null,null,null) ];

	set_combo("formulario.cbEstadoEnvio", datos);

}

// -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function i18nListaProductos()
{
	// Internacionaliza el campo Estado Envío (columna 11) de la lista Productos.
	var datos = listado4.datos;

	var pendiente = GestionarMensaje("1411", null, null, null);
	var estado = GestionarMensaje("1412", null, null, null);

	for (var i = 0; i < datos.length; i++ )
	{
		var valor = datos[i][11];
		if (valor == "E")
			datos[i][11] = estado;

		if (valor == "P")
			datos[i][11] = pendiente;
	}

	listado4.setDatos(datos);
	return;

}

