var datosListaInicio = null;
var varNoLimpiarSICC = true;

// ------------------------------------------------------------------------------------------------------------------------------------------------------------
function onLoadPag()   
{
	manejaLista();
	configurarMenuSecundario("frmFormulario");
	fMostrarMensajeError();

	
	// Si hay un valor en "hMensaje", lo muestra
	var mensaje  = get("frmFormulario.hMensaje");
	if ( mensaje != null && mensaje != "")
		cdos_mostrarAlert(mensaje);


	// Si la lista esta vacia, entonces deshabilita boton "Guardar"
	listado1.actualizaDat();
	var datos = listado1.datos;


	if (datos.length == 0)
		btnProxy("1", "0");

   // Toma los datos de la LE para poder luego, al Limpiar, reestablecer la lista a su condición original.
	datosListaInicio = duplicaArray(datos);  

}


// ------------------------------------------------------------------------------------------------------------------------------------------------------------
function manejaLista()
{
	DrdEnsanchaConMargenDcho('listado1',12);
	
	document.all["Cplistado1"].style.visibility='';
	document.all["CpLin1listado1"].style.visibility='';
	document.all["CpLin2listado1"].style.visibility='';
	document.all["CpLin3listado1"].style.visibility='';
	document.all["CpLin4listado1"].style.visibility='';

	document.all["primera1Div"].style.visibility='hidden';
	document.all["ret1Div"].style.visibility='hidden';
	document.all["ava1Div"].style.visibility='hidden';
	document.all["separaDiv"].style.visibility='hidden';

	eval (ON_RSZ);  
}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------
function fGuardar()
{
		listado1.actualizaDat();

		// Valida la columna FechaCierre
		if (!sicc_validar_fecha_LE("FechaCierre", "", "", "", "", "listado1", 13, "S",null,[16,17])  )
			return;

		// Valida la columna FechaEvaluacion
		if ( !sicc_validar_fecha_LE("FechaEvaluacion", "", "", "", "", "listado1", 14, "S",null,[16,17])  )
			return;

		// Valida la columna FechaAuditoria
		if ( !sicc_validar_fecha_LE("FechaAuditoria", "", "", "", "", "listado1", 15, "S",null,[16,17])  )
			return;

		if ( !sicc_valida_requerido_LE("FechaCierre", GestionarMensaje("1473", null, null, null), "listado1", 13) )
			return;

		
		var cadenaFechaCierre = generaCadenaFechas(13);
//		alert("Fecha Cierre: " + cadenaFechaCierre);

		var cadenaFechaEvaluacion = generaCadenaFechas(14);
//		alert("Fecha Evaluacion: " + cadenaFechaEvaluacion);

		var cadenaFechaAuditoria = generaCadenaFechas(15);
//		alert("Fecha Auditoria: " + cadenaFechaAuditoria );

		set("frmFormulario.hFechaCierre", cadenaFechaCierre);
		set("frmFormulario.hFechaEvaluacion", cadenaFechaEvaluacion);
		set("frmFormulario.hFechaAuditoria", cadenaFechaAuditoria);

		set("frmFormulario.conectorAction", "LPGenerarCronogramaCOBPeriodo");
		set("frmFormulario.accion", "guardarCronograma");
	    eval("frmFormulario").oculto = "S";

		enviaSICC("frmFormulario");

//		alert("GRABAAAAAAAAAAAAAAAAAA");
}


// ------------------------------------------------------------------------------------------------------------------------------------------------------------
function terminoOK()
{
	//alert("Termino todo ok");
/*	set("frmFormulario.conectorAction", "LPGenerarCronogramaCOBPeriodo");
	set("frmFormulario.accion", "");
    eval("frmFormulario").oculto = "N";
	enviaSICC("frmFormulario");*/
	window.close();

}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------
function generaCadenaFechas(col)
{
	// Genera la cadena de Fechas correspondiente a los valores de la columna "col" de la listaEditable.
	// Formato de Cadena generado: [Fecha1,Fecha2,....]

	listado1.actualizaDat();
	var datos = listado1.datos;
	var cadena = "[";

	if ( datos.length == 0){
		cadena = cadena + " ]";
	} else
	{
			for ( var i = 0; i < datos.length; i++)
			{
				var fecha = datos[i][col];

				if ( i != 0)
					cadena = cadena + ",";

				// Si no hay Fecha, entonces pone un espacio en blanco.
				if (fecha == "")  
					cadena = cadena + " ";
				else // Si hay, concatena Fecha
					cadena = cadena + fecha;
			}
			cadena = cadena + "]";
	}

	return cadena;

}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------
function fVolver()
{
	window.close();
}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------
function fLimpiar()
{
	listado1.setDatos(datosListaInicio);
	datosListaInicio = duplicaArray(datosListaInicio);
}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------
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
