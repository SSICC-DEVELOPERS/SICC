
var datosOnLoad = new Array();
var datosLimpiar = new Array();
var varNoLimpiarSICC = true;
// ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function onLoadPag()  
{
        
	configurarMenuSecundario("formulario");
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
	fMostrarMensajeError();

	var casoUso = get("formulario.casoUso");
	//alert("caso Uso: " + casoUso);
	if ( casoUso == "consultar")  // Deshabilita columnas con controles.
	{
		 listado2.tiposCol[2][8]=true; 
		 listado2.tiposCol[4][8]=true; 
		 listado2.actualizaDat();
		 listado2.repinta();
		 btnProxy(1,0);
	} else
		btnProxy(1,1);

	//datosOnLoad = listado2.datos;  // Se usa para comparar en fGuardar qué registro cambio.y setearle el indicador Modificado.
	//alert(listado2.datos);
	i18nListaProductos();
	var arrayLista = listado2.datos;
	datosLimpiar = duplicaArray(arrayLista);

}

// ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function fGuardar()
{
	// Toma la lista Editable Completa y genera un array con ella. 
	listado2.actualizaDat();

	var ok = validaProductos();
	if (ok)
	{
		var datosLista = listado2.datos;
		//alert("Datos a devolver: " + datosLista);
		returnValue = datosLista;
		window.close();
	}
}

// ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function cambiaUnidades(indiceFila)
{
	// Setea indicador de fila modificada en campo oculto..
	listado2.actualizaDat();
	var datos = listado2.datos;
	datos[indiceFila][6] = "S";
	listado2.setDatos(datos);
//	listado2.repintaDat();

}

// ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function estadoAutorizacion(indiceFila)
{
	// Setea indicador de fila modificada en campo oculto..
	listado2.actualizaDat();
	var datos = listado2.datos;
	datos[indiceFila][6] = "S";
//	listado2.repintaDat();
	listado2.setDatos(datos);

}   

// ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function validaProductos()
{
    //alert("Valida Productos");
    var ok = sicc_valida_requerido_LE("txtNumUnidades2", GestionarMensaje("1408", null, null, null), "listado2", 3);
	if (ok)
		ok = sicc_valida_numero_LE("txtNumUnidades2", GestionarMensaje("1408", null, null, null), "0", "999999999", "Entero", "listado2", 3);

	return ok;

}

// -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function i18nListaProductos()
{
	// Internacionaliza el campo Estado Envío (columna 3) de la lista Productos.
	var datos = listado2.datos;

	var pendiente = GestionarMensaje("1411", null, null, null);
	var estado = GestionarMensaje("1412", null, null, null);

	for (var i = 0; i < datos.length; i++ )
	{
		var valor = datos[i][4];
		if (valor == "E")
			datos[i][4] = estado;

		if (valor == "P")
			datos[i][4] = pendiente;
	}

	listado2.setDatos(datos);
	return;
}

// -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function fVolver()
{
	window.close();
}

// -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function fLimpiar()
{
	listado2.setDatos(datosLimpiar);
	datosLimpiar = duplicaArray(datosLimpiar);   // Ya que si no, vuelve a estar por referencia y se modifica.
}

// -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
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














