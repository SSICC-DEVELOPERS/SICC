var ultimoValorOidLista = 0; // Ultimo valor del oid en Listas Editables. Se usa para generacion de nuevo registro.
var listaEditableLimpiar = null;
var varNoLimpiarSICC = true;

function onLoadPag()  
{
  		DrdEnsanchaConMargenDcho('listado1',12);
		document.all["Cplistado1"].style.visibility='hidden';
		document.all["CpLin1listado1"].style.visibility='hidden';
		document.all["CpLin2listado1"].style.visibility='hidden';
		document.all["CpLin3listado1"].style.visibility='hidden';
		document.all["CpLin4listado1"].style.visibility='hidden';
		document.all["primera1Div"].style.visibility='hidden';
		document.all["ret1Div"].style.visibility='hidden';
		document.all["ava1Div"].style.visibility='hidden';
		document.all["separaDiv"].style.visibility='hidden';


		DrdEnsanchaConMargenDcho('listado2',12);
		document.all["Cplistado2"].style.visibility='hidden';
		document.all["CpLin1listado2"].style.visibility='hidden';
		document.all["CpLin2listado2"].style.visibility='hidden';
		document.all["CpLin3listado2"].style.visibility='hidden';
		document.all["CpLin4listado2"].style.visibility='hidden';
		document.all["primera2Div"].style.visibility='hidden';
		document.all["ret2Div"].style.visibility='hidden';
		document.all["ava2Div"].style.visibility='hidden';
		document.all["separa2Div"].style.visibility='hidden';

		eval (ON_RSZ);  
		i18nPestanyas(); // Internacionaliza los valores de los <DIV> correspondientes a las pestañas.
		configurarMenuSecundario("formulario");
		fMostrarMensajeError();
		
		cambiaPestanya(1);
		muestraListaPorTipoProducto();
		obtieneValoresParaLimpiar();
		recargaControles();


		var cadena = this.get("formulario.camposDeshabilitados");
		deshabilitaControles(cadena);
		deshabilitaTextoMensaje();

		focaliza('formulario.cbMarcaProducto');
    
    var menu = get("formulario.opcionMenu");
  
  
  if(menu =="Consultar Concurso Ranking"){
   deshabilitaCampos();
    btnProxy(1, 0);
    btnProxy(4, 0);
    btnProxy(5, 0);
  }

}



function deshabilitaCampos(){

  accion("formulario.cbPeriodoDesde", ".disabled=true");
  accion("formulario.cbPeriodoHasta", ".disabled=true");
  /* vbongiov -- inc 21867
  accion("formulario.txtPuntosUnidad", ".disabled=true");
  accion("formulario.txtFactorMultiplicidad", ".disabled=true");
  accion("formulario.txtUnidadesExigidas", ".disabled=true");
  accion("formulario.txtMontoExigido", ".disabled=true");
  accion("formulario.txtPuntosExigidos", ".disabled=true");
 */
  accion("formulario.cbMarcaProducto", ".disabled=true");
  accion("formulario.cbUnidadNegocio", ".disabled=true");
  accion("formulario.cbNegocio", ".disabled=true");
  accion("formulario.cbSupergenerico", ".disabled=true");
  accion("formulario.cbGenerico", ".disabled=true");
  accion("formulario.cbTipoOferta", ".disabled=true");
  
  accion("formulario.cbCicloVida", ".disabled=true");
  accion("formulario.txtCodProducto", ".disabled=true");
  accion("formulario.cbTipoOferta2", ".disabled=true");
  accion("formulario.cbCicloVida2", ".disabled=true");
  accion("formulario.ckComunicacion", ".disabled=true");
  accion("formulario.txtMensaje", ".disabled=true");
  
  
  //--Faltan deshabilitar los botones!!!

 deshabilitarHabilitarBoton('botonContenido','btnAnadir1','D');
 deshabilitarHabilitarBoton('botonContenido','btnBuscar','D');
 deshabilitarHabilitarBoton('botonContenido','btnAceptar','D');
  
}

// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function i18nPestanyas()
{
	var lblpBloqueNegocio = document.getElementById("lblpBloqueNegocio");
	var lblpBloqueOferta = document.getElementById("lblpBloqueOferta");
	var lblpBloqueProducto = document.getElementById("lblpBloqueProducto");

	var bloqueNegocio = GestionarMensaje("1554", null, null, null);
	var bloqueOferta = GestionarMensaje("1555", null, null, null);
	var bloqueProducto = GestionarMensaje("1553", null, null, null);

	lblpBloqueNegocio.innerText = bloqueNegocio;
	lblpBloqueOferta.innerText = bloqueOferta;
	lblpBloqueProducto.innerText = bloqueProducto;

}


// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function cambiaPestanya(pestanya)
{

	var capa2 = document.getElementById('capa2');
	var capa3 = document.getElementById('capa3');
	var capa4 = document.getElementById('capa4');

	var tabla1 = document.getElementById("tabla1");
	var tabla2 = document.getElementById("tabla2");
	var tabla3 = document.getElementById("tabla3");

	var celda1 = document.getElementById("celda1");
	var celda2 = document.getElementById("celda2");


	var lblpBloqueNegocio = document.getElementById("lblpBloqueNegocio");
	var lblpBloqueOferta = document.getElementById("lblpBloqueOferta");
	var lblpBloqueProducto = document.getElementById("lblpBloqueProducto");

	if ( parseInt(pestanya, 10) == 1)  // Bloque Negocio
	{

		capa2.style.visibility = 'visible';
		capa3.style.visibility = 'hidden';
		capa4.style.visibility = 'hidden';
		tabla1.bgColor = "#496A9A";
		tabla2.bgColor = "";
		tabla3.bgColor = "";

		cambiaEstilo(lblpBloqueNegocio, "blanca");
		cambiaEstilo(lblpBloqueOferta, "negrita");
		cambiaEstilo(lblpBloqueProducto, "negrita");

		limpiaBloque("Productos");
		limpiaBloque("Oferta");
	} 

	if ( parseInt(pestanya, 10) == 2) // Bloque Oferta
	{
	
		capa2.style.visibility = 'hidden';
		capa3.style.visibility = 'visible';
		capa4.style.visibility = 'hidden';

		tabla1.bgColor = "";
		tabla2.bgColor = "#496A9A";
		tabla3.bgColor = "";

		cambiaEstilo(lblpBloqueNegocio, "negrita");
		cambiaEstilo(lblpBloqueOferta, "blanca");
		cambiaEstilo(lblpBloqueProducto, "negrita");


		limpiaBloque("Productos");
		limpiaBloque("Negocio");
	}

	if ( parseInt(pestanya, 10) == 3)  // Bloque Productos
	{
		capa2.style.visibility = 'hidden';
		capa3.style.visibility = 'hidden';
		capa4.style.visibility = 'visible';

		tabla1.bgColor = "";
		tabla2.bgColor = "";
		tabla3.bgColor = "#496A9A";

		cambiaEstilo(lblpBloqueNegocio, "negrita");
		cambiaEstilo(lblpBloqueOferta, "negrita");
		cambiaEstilo(lblpBloqueProducto, "blanca");

		limpiaBloque("Oferta");
		limpiaBloque("Negocio");
	}

}

// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function cambiaEstilo(objeto, estilo)
{
	if (estilo == "blanca") {
		objeto.style.color =  "#FFFFFF"; 
	} else {
		objeto.style.color =  "#000000"; 
	}
}



// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function deshabilitaControles(cadena)
{
		// Deshabilita los campos indicados en "cadena".
		// "cadena" tiene el formato    "campo1,campo2,campo3,.....,campoN"

		if ( cadena != "") {
				var arrayControles = cadena.split(",");

				for (var i = 0; i < arrayControles.length; i++)
					accion("formulario." + arrayControles[i], ".disabled=true");
		}
}


// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function accionAniadir()
{
	// Deshabilita el boton hasta que se añada la fila (para evitar solapamientos)
	deshabilitarHabilitarBoton('botonContenido', 'btnAnadir1', 'D');
	// Primero chequea cuál capa está visible (de esa capa, tomará los datos para añadir)
	var capa2 = document.getElementById('capa2');
	var capa3 = document.getElementById('capa3');
	var capa4 = document.getElementById('capa4');

	var bloqueNegocio = capa2.style.visibility;
	var bloqueOferta = capa3.style.visibility;
	var bloqueProducto = capa4.style.visibility;
	

	// Ahora, añade un registro a la listaEditable en cuestion
	// ***************************************************************
	
	// Primero chequea qué lista Editable corresponde usar. 
	var listaEditable = this.obtenerLEActiva();
	// Obtiene el juego de datos de la LE activa para añadirle un registro
	eval(listaEditable + ".actualizaDat();");
	var datos = eval(listaEditable + ".datos;");
	if (datos == null || datos == undefined || datos ==  "")   // Por las dudas.
		datos = new Array();

	var nuevoOid = obtenerSiguienteOid();  

	// Valores comunes. 
	var periodoDesde = get("formulario.cbPeriodoDesde");
	var periodoHasta = get("formulario.cbPeriodoHasta");
	/* vbongiov -- inc 21867
	var txtPuntosUnidad = get("formulario.txtPuntosUnidad");
	var txtFactorMultiplicidad = get("formulario.txtFactorMultiplicidad");
	var txtUnidadesExigidas = get("formulario.txtUnidadesExigidas");
	var txtMontoExigido = get("formulario.txtMontoExigido");
	var txtPuntosExigidos = get("formulario.txtPuntosExigidos");
	*/
	var descPeriodoDesde = get("formulario.cbPeriodoDesde", "T");
	var descPeriodoHasta = get("formulario.cbPeriodoHasta", "T");

	var oidTipoProducto = get("formulario.oidTipoProducto");

	// ---------------------------------------- Capa Bloque Negocio -------------------------------------------------------------------------------------
	if ( bloqueNegocio == 'visible'  || bloqueNegocio == 'inherit' )  
	{
		if ( sicc_validaciones_generales("bloqueNegocio") )
		{
			var marcaProducto = get("formulario.cbMarcaProducto");
			var uNegocio = get("formulario.cbUnidadNegocio");
			var negocio = get("formulario.cbNegocio");
			var superGenerico = get("formulario.cbSupergenerico");
			var generico = get("formulario.cbGenerico");

			var descMarcaProducto = get("formulario.cbMarcaProducto", "T");
			var descUNegocio = get("formulario.cbUnidadNegocio", "T");
			var descNegocio = get("formulario.cbNegocio", "T");
			var descSuperGenerico = get("formulario.cbSupergenerico", "T");
			var descGenerico = get("formulario.cbGenerico", "T");

			// **** Arma la nueva linea ************************************
			var nuevaFila = null;
			if ( listaEditable == "listado1")  // Lista productos validados
			{
					 nuevaFila = ["" + nuevoOid, 
											"" + descMarcaProducto, 
											"" + descUNegocio, 
											"" + descNegocio, 
											"" + descSuperGenerico, 
											"" + descGenerico, 
											"",
											"",
											"", 
											"", 
											"", 
											"" + marcaProducto, 
											"" + uNegocio,
											"" + negocio, 
											"" + superGenerico,
											"" + generico,
											"",
											"",
											"",
											"",
											""

										];

			} else if ( listaEditable == "listado2")   // Lista productos excluidos
			{
					nuevaFila = ["" + nuevoOid,
									   "" + descMarcaProducto,
									   "" + descUNegocio, 
									   "" + descNegocio, 
									   "" + descSuperGenerico, 
									   "" + descGenerico,				    // Fin Bloque Negocio
									   "", 
									   "",											// Fin Bloque Oferta
									   "",
									   "",
									   "",											// Fin Bloque Producto
									   "" + descPeriodoDesde, 
									   "" + descPeriodoHasta,			// Fin Datos asociados
									   "" + marcaProducto,
									   "" + uNegocio, 
									   "" + negocio, 
									   "" + superGenerico, 
									   "" + generico,							// Fin Bloque Negocio Oculto
									   "", 
									   "",											// Fin Bloque Oferta Oculto
									   "",
									   "",
									   "",											// Fin Bloque Producto Oculto
									   "" + periodoDesde, 
									   "" + periodoHasta];					// Fin Datos asociados Ocultos
			}

			 // Se valida que no se hayan ingresado los mismos datos en otra fila.
			 var cadenaToCheck = "";
			 for ( var n = 1; n < nuevaFila.length; n++ )
			 {
				 if ( n != 1)
					 cadenaToCheck = cadenaToCheck + ",";
			
				 cadenaToCheck = cadenaToCheck + nuevaFila[n];
			 }

			var yaExisteFila = validaFilaExistente(cadenaToCheck, listaEditable);
			if ( yaExisteFila )
			{
				deshabilitarHabilitarBoton('botonContenido', 'btnAnadir1', 'A');
				return;
			}

			datos[datos.length] = nuevaFila;
			eval(listaEditable + ".setDatos(datos);");
 		    // Limpia los campos usados para ingresar datos.
			limpiarDespuesAnyadir();

		} // Fin if bloque 


	} 

	// ---------------------------------------- Capa Bloque Oferta -------------------------------------------------------------------------------------
	if ( bloqueOferta == 'visible' || bloqueOferta == 'inherit' )  // Se toman los datos del BloqueOferta
	{
		if ( sicc_validaciones_generales("bloqueOferta") )
		{
			var oidTipoOferta = get("formulario.cbTipoOferta");
			var oidCicloVida = get("formulario.cbCicloVida");
			var descTipoOferta = get("formulario.cbTipoOferta", "T");
			var descCicloVida = get("formulario.cbCicloVida", "T");

			var nuevaFila = null;
			if ( listaEditable == "listado1")  
			{
				nuevaFila = ["" + nuevoOid,
								 	    "", 
					                    "",
			              			    "",
										"",
										"",
										"" + descTipoOferta,
										"" + descCicloVida,	
										"", 
									    "", 
					                    "", 
								 	    "", 
					                    "",
				          			    "",
										"",
										"",
										"" + oidTipoOferta,
					                    "" + oidCicloVida,
										"", 
					                    "", 
						                ""];
			 } else if ( listaEditable == "listado2" )   // Lista Productos Excluidos
			 {
					nuevaFila = ["" + nuevoOid,
									   "",
									   "", 
									   "", 
									   "", 
									   "",									// Fin Bloque Negocio
									   "" + descTipoOferta, 
									   "" + descCicloVida,			// Fin Bloque Oferta
									   "",
									   "",
									   "",									// Fin Bloque Producto
									   "" + descPeriodoDesde, 
									   "" + descPeriodoHasta,  // Fin Datos asociados
									   "",
									   "", 
									   "", 
									   "", 
									   "",    // Fin Bloque Negocio Oculto
									   "" + oidTipoOferta, 
									   "" + oidCicloVida,    // Fin Bloque Oferta Oculto
									   "",
									   "",
									   "",   // Fin Bloque Producto Oculto
									   "" + periodoDesde, 
									   "" + periodoHasta];  // Fin Datos asociados Ocultos

			 }

			  // Se valida que no se hayan ingresado los mismos datos en otra fila.
			  var cadenaToCheck = "";
			  for ( var n = 1; n < nuevaFila.length; n++ )
			  {
				  if ( n != 1)
			 		  cadenaToCheck = cadenaToCheck + ",";
			
				  cadenaToCheck = cadenaToCheck + nuevaFila[n];
			  }

			  //var cadenaToCheck = "" + nuevaFila;
			  var yaExisteFila = validaFilaExistente(cadenaToCheck, listaEditable);
			  if ( yaExisteFila )
			  {
				  deshabilitarHabilitarBoton('botonContenido', 'btnAnadir1', 'A');
				  return;
			  }


			 datos[datos.length] = nuevaFila;
			 eval(listaEditable + ".setDatos(datos);");
			 // Limpia los campos usados para ingresar datos.
			 limpiarDespuesAnyadir();

		}

	}

	// ---------------------------------------- Capa Bloque Producto -------------------------------------------------------------------------------------
	if ( bloqueProducto == 'visible' || bloqueProducto == 'inherit' )  // Se toman los datos de Bloque Producto 
	{
		if ( sicc_validaciones_generales("bloqueProducto") )
		{
			 var codigoProducto = get("formulario.txtCodProducto");
 			 var oidProducto = get("formulario.hoidProducto");
			 var oidTipoOferta = get("formulario.cbTipoOferta2");
			 var oidCicloVida = get("formulario.cbCicloVida2");
			 var descTipoOferta = get("formulario.cbTipoOferta2", "T");
			 var descCicloVida = get("formulario.cbCicloVida2", "T");

  			 var nuevaFila = null;
			 if ( listaEditable == "listado1" )  // Tipo Producto Valido
			 {
					 nuevaFila = ["" + nuevoOid, 
												"", 
												"",
												"",
												"",
												"",
												"",
												"",
												"" + codigoProducto, 
												"" + descTipoOferta, 
												"" + descCicloVida, 
												"", 
												"",
												"",
												"",
												"",
												"",
												"",
												"" + oidProducto, 
												"" + oidTipoOferta, 
												"" + oidCicloVida
											 ];

  			   } else if ( listaEditable == "listado2")  // Lista productos excluidos
			   {
					nuevaFila = ["" + nuevoOid,
									   "",
									   "", 
									   "", 
									   "", 
									   "",										// Fin Bloque Negocio
									   "", 
									   "",										// Fin Bloque Oferta
									   "" + codigoProducto,
									   "" + descTipoOferta,
									   "" + descCicloVida,				// Fin Bloque Producto
									   "" + descPeriodoDesde, 
									   "" + descPeriodoHasta,		// Fin Datos asociados
									   "",
									   "", 
									   "", 
									   "", 
									   "",										// Fin Bloque Negocio Oculto
									   "", 
									   "",										// Fin Bloque Oferta Oculto
									   "" + oidProducto,
									   "" + oidTipoOferta,
									   "" + oidCicloVida,				// Fin Bloque Producto Oculto
									   "" + periodoDesde, 
									   "" + periodoHasta];				// Fin Datos asociados Ocultos
	  		   } 

			   // Se valida que no se hayan ingresado los mismos datos en otra fila.
			   var cadenaToCheck = "";
			   for ( var n = 1; n < nuevaFila.length; n++ )
			   {
			  	    if ( n != 1)
					   cadenaToCheck = cadenaToCheck + ",";
				
				    cadenaToCheck = cadenaToCheck + nuevaFila[n];
			   }

				//var cadenaToCheck = "" + nuevaFila;
				var yaExisteFila = validaFilaExistente(cadenaToCheck, listaEditable);
				if ( yaExisteFila )
				{
					  deshabilitarHabilitarBoton('botonContenido', 'btnAnadir1', 'A');
					  return;
				}

			    datos[datos.length] = nuevaFila;
			    eval(listaEditable + ".setDatos(datos);");
				// Limpia los campos usados para ingresar datos.
				limpiarDespuesAnyadir();

		}

	}

	// Habilita el botón "añadir" nuevamente
	deshabilitarHabilitarBoton('botonContenido', 'btnAnadir1', 'A');

}

// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function obtenerLEActiva()
{
	var tipoProductoUsado = get("formulario.listadoAMostrar");
	var LEActiva = "";

	if ( tipoProductoUsado == "pValidos")
		LEActiva = "listado1";

	if ( tipoProductoUsado == "pExcluidos" )
		LEActiva = "listado2";

/*	if ( tipoProductoUsado == "pBonificados" )
		LEActiva = "listado3";

	if ( tipoProductoUsado == "pExigidos" )
		LEActiva = "listado4";	*/


	return LEActiva;

}


// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function muestraListaPorTipoProducto()
{
		// Muestra la lista Editable correspondiente al tipo de producto. 
	var tipoProductoUsado = get("formulario.listadoAMostrar");
	var LEActiva = "";

	if ( tipoProductoUsado == "pValidos")
	{
		manejaLista("1", "visible");
		manejaLista("2", "hidden");
		/*manejaLista("3", "hidden");
		manejaLista("4", "hidden");*/
		LEActiva = "listado1";
	}

	if ( tipoProductoUsado == "pExcluidos" )
	{
		manejaLista("1", "hidden");
		manejaLista("2", "visible");
		/*manejaLista("3", "hidden");
		manejaLista("4", "hidden");*/
		LEActiva = "listado2";
	}

/*	if ( tipoProductoUsado == "pBonificados" )
	{
		manejaLista("1", "hidden");
		manejaLista("2", "hidden");
		manejaLista("3", "visible");
		manejaLista("4", "hidden");
		LEActiva = "listado3";
	}

	if ( tipoProductoUsado == "pExigidos" )
	{
		manejaLista("1", "hidden");
		manejaLista("2", "hidden");
		manejaLista("3", "hidden");
		manejaLista("4", "visible");
		LEActiva = "listado4";	
	}*/
		
}

// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function manejaLista(numero, estado)
{
		document.all["Cplistado" + numero].style.visibility=estado;
		document.all["CpLin1listado" + numero].style.visibility=estado;
		document.all["CpLin2listado" + numero].style.visibility=estado;
		document.all["CpLin3listado" + numero].style.visibility=estado;
		document.all["CpLin4listado" + numero].style.visibility=estado;
		document.all["primera" + numero + "Div"].style.visibility='hidden';
		document.all["ret" + numero + "Div"].style.visibility='hidden';
		document.all["ava" + numero + "Div"].style.visibility='hidden';
		document.all["separaDiv"].style.visibility='hidden';
}


// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function obtenerSiguienteOid()
{	
	// Obtiene siguiente Oid a usar para LE (se usa al agregar filas)
	var retorno = "n" + ultimoValorOidLista;
	ultimoValorOidLista++;
	return retorno;

}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function limpiarDespuesAnyadir()
{
	// Limpia todos los controles luego de añadir un elemento en la ListaEditable.

	var arrayVacio = new Array("","");
	set("formulario.cbPeriodoDesde", arrayVacio );
	set("formulario.cbPeriodoHasta", arrayVacio);
	/* vbongiov -- inc 21867
	set("formulario.txtPuntosUnidad", "");
	set("formulario.txtFactorMultiplicidad", "");
	set("formulario.txtUnidadesExigidas", "");
	set("formulario.txtMontoExigido", "");
	set("formulario.txtPuntosExigidos", "");
    */

	set("formulario.cbMarcaProducto", arrayVacio);
	set("formulario.cbUnidadNegocio", arrayVacio);
	set("formulario.cbNegocio", arrayVacio);
	set("formulario.cbSupergenerico", arrayVacio);
	set("formulario.cbGenerico", arrayVacio);

	set("formulario.cbTipoOferta", arrayVacio);
	set("formulario.cbCicloVida", arrayVacio);

	set("formulario.txtCodProducto", "");
	set("formulario.cbTipoOferta2", arrayVacio);
	set("formulario.cbCicloVida2", arrayVacio);


}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function fBorrar()
{
		// Elimina registros en la tabla activa
		var listaActiva = obtenerLEActiva();

		var codigos = eval(listaActiva + ".codSeleccionados();");
		if (codigos != null && codigos.length > 0 )
			eval(listaActiva + ".eliminarSelecc();");

}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function recargaControles()
{
		// Se usa para recargar el valor de los controles de las capas. 
		var marcaProducto = get("formulario.hcbMarcaProducto");
		var uNegocio = get("formulario.hcbUnidadNegocio");
		var negocio = get("formulario.hcbNegocio");
		var sGenerico = get("formulario.hcbSupergenerico");
		var generico = get("formulario.hcbGenerico");

		var tipoOferta = get("formulario.hcbTipoOferta");
		var cicloVida = get("formulario.hcbCicloVida");

		var oidProducto = get("formulario.hoidProducto");
		var codigoProducto = get("formulario.htxtCodigoProducto");

		var periodoDesde = get("formulario.hcbPeriodoDesde");
		var periodoHasta = get("formulario.hcbPeriodoHasta");
		/* vbongiov -- inc 21867
		var puntosUnidad = get("formulario.htxtPuntosUnidad");
		var factorMultiplicidad = get("formulario.htxtFactorMultiplicidad");
		var unidadesExigidas = get("formulario.htxtUnidadesExigidas");
		var montoExigido = get("formulario.htxtMontoExigido");
		var puntosExigidos = get("formulario.htxtPuntosExigidos");
        */

		var chkComunicacion = get("formulario.hchkComunicacion");
		var codigoMensaje = get("formulario.htxtCodigoMensaje");

		set("formulario.cbMarcaProducto", new Array(marcaProducto) );
		set("formulario.cbUnidadNegocio", new Array(uNegocio) );
		set("formulario.cbNegocio", new Array(negocio) );
		set("formulario.cbSupergenerico", new Array(sGenerico) );
		set("formulario.cbGenerico", new Array(generico) );

		set("formulario.cbTipoOferta", new Array(tipoOferta) );
		set("formulario.cbTipoOferta2", new Array(tipoOferta) );
		set("formulario.cbCicloVida", new Array(cicloVida) );
		set("formulario.cbCicloVida2", new Array(cicloVida) );
		
		set("formulario.txtCodProducto", codigoProducto);

		set("formulario.cbPeriodoDesde", new Array(periodoDesde) );
		set("formulario.cbPeriodoHasta", new Array(periodoHasta) );

		/* vbongiov -- inc 21867
		set("formulario.txtPuntosUnidad", puntosUnidad );
		set("formulario.txtFactorMultiplicidad", factorMultiplicidad );

		set("formulario.txtUnidadesExigidas", unidadesExigidas);
		set("formulario.txtMontoExigido", montoExigido);
		set("formulario.txtPuntosExigidos", puntosExigidos);
        */
		
		set("formulario.txtCodigoMensaje", codigoMensaje); 

		if ( chkComunicacion == "1")
			set("formulario.ckComunicacion", "S");
		else
			set("formulario.ckComunicacion", "N");

		set("formulario.txtMensaje", codigoMensaje);

}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function accionBuscarProducto()
{
	var params = new Object();
  params.casoDeUso= 'buscarProducto' 
  params.accion = '';
  params.oidMarcaCorporativa = get('formulario.hOidMarca');
	var arrayProductos = this.mostrarModalSICC('LPBuscarProductosDTO', '', params);

	if ( arrayProductos != null && arrayProductos != undefined)
	{
			// ArrayProductos[0] contiene la cadena de Oid|Desc separados por $
			// Le hago un split por $ para saber cuantos registros tengo.

			var cadena = arrayProductos[0];
			var arrayNuevo = cadena.split("$");

			if ( arrayNuevo.length != 2){
				GestionarMensaje("1497", null, null, null);
				focalizaBotonHTML('botonContenido','btnBuscar');
			} else {
				var valores = arrayNuevo[1];
				var elementos = valores.split("|");
				var oidProducto = elementos[0];
				var codProducto = elementos[1];

				//oidProducto = oidProducto.substring(1,oidProducto.length);

				set("formulario.txtCodProducto", codProducto);
				set("formulario.hoidProducto", oidProducto);
			}
	}

}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function accionAceptar()
{
	var datosObligatorios = comprobarDatosObligatorios();
	var esProdValido = esTipoProductoValido();

	// Si la datosObligatorios es false, y se está validando un Producto Valido, entonces
	// quiere decir que la lista Producto Valido no contiene ninguna entrada. 
	//alert("datosObligatorios: " + datosObligatorios);
	if ( datosObligatorios || !esProdValido )
	{
				//alert("datosObligatorios: " + datosObligatorios);
				var indComunicacion = get("formulario.ckComunicacion");
				var codigoMensaje = get("formulario.txtMensaje");
				var lista = generarListaParseada();

				// Chequea que si el checkbox comunicacion está habilitado, haya un valor en la caja de texto
				// Mensaje. 
				if ( indComunicacion == "S") {
					var validado = sicc_validaciones_generales("txtMensaje");
					if ( !validado ) { return ;}
				}

				set("formulario.datosObligatorios", datosObligatorios);
				set("formulario.conectorAction", "LPMantenerProductosRanking");
				set("formulario.accion", "almacenar");
				set("formulario.hlstProductos", lista);
				set("formulario.hchkComunicacion", indComunicacion);
				set("formulario.htxtCodigoMensaje", codigoMensaje);
				eval("formulario").oculto = "S";

				enviaSICC("formulario", null, null, "N");
	}

}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function comprobarDatosObligatorios()
{
	/*var oidTipoProductoValido = get("formulario.oidTipoProductoValidos");
	var tipoProductoActual = get("formulario.oidTipoProducto");*/
	var retorno = false;
	var esProdValido = esTipoProductoValido();

//	if ( parseInt(tipoProductoActual, 10) == parseInt(oidTipoProductoValido, 10)  )
	if ( esProdValido )
	{
		// Chequea si la Lista de Productos Validas está vacía.
		listado1.actualizaDat();
		var datos = listado1.datos;
		//alert("datos.length: " + datos.length);
		if ( datos != null && datos.length == 0)
		{
			GestionarMensaje("1495", null, null, null);  //alert("La lista de productos válidos debe contener al menos un elemento");
			retorno = false;
		}
		else {
			retorno = true;
		}
	} else
	{
		// Para comrpobar Datos Obligatorios en la otras listas, me fijo si se ha introducido una fila en la lista corresp. 
		// Si, es así, seteo el ind. por true. Si no, retorno false. 
		var listaActiva = obtenerLEActiva();

		eval(listaActiva + ".actualizaDat();");
		var datos = eval(listaActiva + ".datos;");
		if ( datos.length > 0 )
			retorno = true;
		else
			retorno = false;

	}

	return retorno;

}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function generarListaParseada()
{

	// Obtiene la Lista Activa (la que está mostrando) y luego genera una cadena con el contenido de esta lista. 
	var cadenaGenerada = "[";
	var lista = obtenerLEActiva();

	eval(lista + ".actualizaDat();");
	var datos = eval(lista + ".datos;");

	if ( datos != null && datos.length > 0 )
	{
		// Procesa filas.
		for ( var i = 0; i < datos.length; i++ )
		{
			var fila = datos[i];
			if ( i != 0)
				  cadenaGenerada = cadenaGenerada + "|";

			// Procesa las celdas. 
			for ( var j = 0; j < fila.length; j++ )
			{
			    var valor = fila[j];
				if ( j != 0)
				  cadenaGenerada = cadenaGenerada + "@";
	
 			    if ( valor != "")  // Si existe algún valor, lo concatena
					  cadenaGenerada = cadenaGenerada + valor;
				else               // Si no existe ningún valor, pone espacio. " ".
 					  cadenaGenerada = cadenaGenerada + " ";

			}
		}
	}

	cadenaGenerada = cadenaGenerada + "]";
	//alert("cadenaGenerada: " + cadenaGenerada);

	return cadenaGenerada;

}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function mouseOver(pestanya)
{
	var objCelda = document.getElementById(pestanya);
	objCelda.style.cursor = "hand";

}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function focalizaAceptar()
{
 	focalizaBotonHTML('botonContenido','btnAceptar');	
}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function focalizaAnyadir()
{
	focalizaBotonHTML('botonContenido','btnAnadir1');	
}


// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function tabAceptar()
{
		// Al hacer tab en el Boton Aceptar. 
		// Determina qué capa se está mostrando en la cabecera, y focaliza su botón correspondiente.

		var capaActiva = obtieneCapaCabeceraActiva();
		//alert("capaActiva: " + capaActiva);
		if (  capaActiva == "capa2") {
			 // Focaliza el combo MarcaProducto
			 focaliza("formulario.cbMarcaProducto");
		}

		if ( capaActiva == "capa3") {
			// Focaliza el Combo TipoOferta de la capa intermedia 
			focaliza("formulario.cbTipoOferta");
		}

		if ( capaActiva == "capa4") {
			// Focaliza el Combo TipoOferta2 de la capa Bloque Producto
			focaliza("formulario.txtCodProducto");
		}

}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function obtieneCapaCabeceraActiva()
{
		var capa2 = document.getElementById('capa2');
		var capa3 = document.getElementById('capa3');
		var capa4 = document.getElementById('capa4');

		if ( capa2.style.visibility == 'visible' || capa2.style.visibility == 'inherit' )
			return "capa2";

		if ( capa3.style.visibility == 'visible' || capa3.style.visibility == 'inherit' )
			return "capa3";

		if ( capa4.style.visibility == 'visible' || capa4.style.visibility == 'inherit' )
			return "capa4";
}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function tabDatosAsociados()
{
	// ---- Se dispara cuando se intenta focalizar hacie un componente del Frame "Datos Asociados"
	var camposAsociados = new Array();
	camposAsociados[0] = "cbPeriodoDesde";
	camposAsociados[1] = "cbPeriodoHasta";

	/* vbongiov -- inc 21867
	camposAsociados[2] = "txtPuntosUnidad";
	camposAsociados[3] = "txtFactorMultiplicidad";
	camposAsociados[4] = "txtUnidadesExigidas";
	camposAsociados[5] = "txtMontoExigido";
	camposAsociados[6] = "txtPuntosExigidos";
	*/

	var campoAFocalizar = "";

	for (var i = 0; (i < camposAsociados.length) && (campoAFocalizar == ""); i++) {
		var obj = document.getElementById(camposAsociados[i]); 			
		if ( obj.disabled != true) 
			campoAFocalizar = camposAsociados[i];
	}

	if ( campoAFocalizar == "") {
		// Focaliza boton
	 	focalizaBotonHTML('botonContenido','btnAnadir1');	
	} else {
		// Focaliza control
		focaliza("formulario." + campoAFocalizar);
	}


}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function shTabPeriodoDesde()
{
	var capaActiva = obtieneCapaCabeceraActiva();
    if (  capaActiva == "capa2") {
			 // Focaliza el combo cbGenerico
			 focaliza("formulario.cbGenerico");
	}

	if ( capaActiva == "capa3") {
			 // Focaliza el combo cbCicloVida
			focaliza("formulario.cbCicloVida");
	}

	if  ( capaActiva == "capa4") {
			 // Focaliza el combo cbCicloVida2
			focaliza("formulario.cbCicloVida2");
	}

}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
String.prototype.trim = function()
{
    return this.replace(/(^\s*)|(\s*$)/g, "");
}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function obtieneValoresParaLimpiar()
{
	var listaActiva = obtenerLEActiva();

	eval(listaActiva + ".actualizaDat();");
	var datos = eval(listaActiva + ".datos;");
	
	listaEditableLimpiar = duplicaArray(datos);

}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function duplicaArray(param)
{
	var valorToReturn = new Array();
	if ( param != "")
	{
		var cantFilas = param.length;
		var cantCols = param[0].length;

		for (var i = 0; i < cantFilas; i++)
		{
			var nuevaFila = new Array();
			for (var j = 0; j < cantCols; j++)
			{	
				var dato = param[i][j];
				nuevaFila[j] = dato;
			}
			valorToReturn[i] = nuevaFila;
		}
	}
	return valorToReturn;

}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function fLimpiar() {
    if(get('formulario.opcionMenu')!="Modificar Concurso Ranking"){  
        // Deja la pantalla tal como estaba al ingresar. 
        set("formulario.cbMarcaProducto", new Array() );
        set("formulario.cbUnidadNegocio", new Array() );
        set("formulario.cbNegocio", new Array() );
        set("formulario.cbSupergenerico", new Array() );
        set("formulario.cbGenerico", new Array() );
        set("formulario.cbTipoOferta", new Array() );
        set("formulario.cbCicloVida", new Array() );
        set("formulario.txtCodProducto", new Array() );
        set("formulario.cbTipoOferta2", new Array() );
        set("formulario.cbCicloVida2", new Array() );
      
	    /* vbongiov -- inc 21867
        set("formulario.txtUnidadesExigidas", "");
        set("formulario.txtMontoExigido", "");
        set("formulario.txtPuntosExigidos", "");
        set("formulario.txtPuntosUnidad", "");
        set("formulario.txtFactorMultiplicidad", "");
        */

        set("formulario.cbPeriodoDesde", new Array() );
        set("formulario.cbPeriodoHasta", new Array() );
      
        var listaActiva = obtenerLEActiva();
        eval(listaActiva + ".setDatos(listaEditableLimpiar);");
        listaEditableLimpiar = duplicaArray(listaEditableLimpiar);
      
        var chkComunicacion = get("formulario.hchkComunicacion");
        if ( chkComunicacion == "1")
            set("formulario.ckComunicacion", "S");
          else
            set("formulario.ckComunicacion", "N");
      
        var txtMensaje = get("formulario.htxtCodigoMensaje");
        set("formulario.txtMensaje", txtMensaje);
        
        cambiaPestanya(1);
        
        focaliza('formulario.cbMarcaProducto');
  
    } else {
    
        set('formulario.conectorAction', 'LPMantenerProductosRanking');
        set('formulario.accion', 'mantener');
        set('formulario.oidCombo', get("formulario.oidTipoProducto"));
        set('formulario.descCombo', get("formulario.descTipoProducto"));
        eval('formulario').oculto = 'N';
        enviaSICC('formulario', null, null, 'N');
    }

}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function fVolver()
{
	window.close();
}


// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function deshabilitaTextoMensaje()
{
	// Si el checkBox esta marcado, entonces habilita la caja de Texto mensaje
	// Si no, lo deshabilita y limpia.

	var valorCheck = get("formulario.ckComunicacion");
	if ( valorCheck == "S") {
		accion("formulario.txtMensaje", ".disabled=false");
	} else{
		set("formulario.txtMensaje", "");
		accion("formulario.txtMensaje", ".disabled=true");
	}
}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function limpiaBloque(bloque)
{
	// Limpia todos los campos correspondientes al bloque en cuestion
	if (bloque == "Negocio")  // Limpia Bloque Negocio
	{
		set("formulario.cbMarcaProducto", new Array() );
		set("formulario.cbUnidadNegocio", new Array() );
		set("formulario.cbNegocio", new Array() );
		set("formulario.cbSupergenerico", new Array() );
		set("formulario.cbGenerico", new Array() );
	}

	if ( bloque == "Productos" ) // Limpia Bloque Productos
	{
		set("formulario.txtCodProducto", "");
		set("formulario.hoidProducto", "");
		set("formulario.cbTipoOferta2", new Array() );
		set("formulario.cbCicloVida2", new Array() );
	}

	if ( bloque == "Oferta") // Limpia Bloque Oferta
	{
		set("formulario.cbTipoOferta", new Array() );
		set("formulario.cbCicloVida", new Array() );
	}
}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function limpiaOidOculto()
{
	set("formulario.hoidProducto", "");
}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function esTipoProductoValido()
{
	// Determina si el tipo de Producto mostrado es Tipo Producto Valido.
	// Si es así, retorna true
	// Si no, false.
	var oidTipoProductoValido = get("formulario.oidTipoProductoValidos");
	var tipoProductoActual = get("formulario.oidTipoProducto");
	var retorno = false;

	if ( parseInt(tipoProductoActual, 10) == parseInt(oidTipoProductoValido, 10)  )
		retorno = true;

	return retorno; 

}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function validaFilaExistente(cadenaToCheck, listado)
{
	// Recorre la lista en listado 
	var datosLista = eval(listado).datos;
	var seRepite = false;

	// Por cada Fila de Lista y mientras no se haya encontrado fila con los mismos valores que "cadenaToCheck". 
	for ( var i = 0; (i < datosLista.length) && (!seRepite); i++ )
	{
		// Concatena los campos de la fila en un solo string, para luego compararlo con la entrada. 
		// No tomo el Oid, ya que cadenaToCheck no lo incluye (por eso se empieza con j = 1)
		var cadenaFila = "";
		for (var j = 1; j < datosLista[i].length; j++ )
		{
			if ( j != 1)
				cadenaFila = cadenaFila + ",";

			var campo = datosLista[i][j];
				cadenaFila = cadenaFila + datosLista[i][j];
		}

		//alert("cadenaFila: " + cadenaFila + "\n" + "cadenaToCheck: " + cadenaToCheck);
		if ( cadenaToCheck == cadenaFila ){
			seRepite = true;
			//alert("Match - aborta");
		}

	}

	return seRepite;

}
