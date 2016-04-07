var arrayFilaModificada = new Array();  // Se usa para mantener un registro de las filas que fueron modificadas. 
var varNoLimpiarSICC = true;

// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function onLoadPag()   
{
	manejaLista('hidden');
	configurarMenuSecundario("frmFormulario");
	fMostrarMensajeError();
	focaliza("frmFormulario.cbMarca");
}

// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function manejaLista(valor)
{
	DrdEnsanchaConMargenDcho('listado1',12);

	document.all["Cplistado1"].style.visibility=valor;
	document.all["CpLin1listado1"].style.visibility=valor;
	document.all["CpLin2listado1"].style.visibility=valor;
	document.all["CpLin3listado1"].style.visibility=valor;
	document.all["CpLin4listado1"].style.visibility=valor;

	document.all["primera1Div"].style.visibility='hidden';
	document.all["ret1Div"].style.visibility='hidden';
	document.all["ava1Div"].style.visibility='hidden';
	document.all["separaDiv"].style.visibility='hidden';

	eval (ON_RSZ);  
}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------------
function recargaPeriodo()
{
         var marca = get("frmFormulario.cbMarca");
         var canal = get("frmFormulario.cbCanal");

         if ( marca != "" && canal != "")
                  recargaCombo("frmFormulario.cbPeriodo", "CRAObtienePeriodos", 'es.indra.sicc.dtos.cra.DTOPeriodo', armarArray() );
         else
         {
                  // Limpia Combo Periodo, asi no quedan inconsistencias.
                  var arrayVacio = ["", ""];
                  set_combo("frmFormulario.cbPeriodo", arrayVacio);
         }

}


// ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function armarArray()
{
         var arrayToReturn = new Array();
         
         var hPais = get("frmFormulario.hPais");
         var marca = get("frmFormulario.cbMarca");
         var canal = get("frmFormulario.cbCanal");
         
         arrayToReturn[0] = ["pais", hPais];
         arrayToReturn[1] = ["marca", marca];
         arrayToReturn[2] = ["canal", canal];

         return arrayToReturn;
}

// ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function accionBuscar()
{
	// Limpia las variables de formulario ocultas para evitar que se pisen cuando se usen los datos
	// nuevos provenientes de esta busqueda.
	set("frmFormulario.oidFilaModificada", "");
	set("frmFormulario.hFechaCierre", "");
	set("frmFormulario.hFechaEvaluacion", "");
	set("frmFormulario.hFechaAuditoria", "");
	var arrayFilaModificada = new Array();  

	// Oculta y limpia la lista
	manejaLista('hidden');
	listado1.setDatos(new Array() );

	// Invoca a la Busqueda
	var periodo = get("frmFormulario.cbPeriodo");
	var marca = get("frmFormulario.cbMarca");
	var canal = get("frmFormulario.cbCanal");

	set("frmFormulario.hPeriodo", periodo);
	set("frmFormulario.hMarca", marca);
	set("frmFormulario.hCanal", canal);
	set("frmFormulario.accion", "buscar");
	set("frmFormulario.conectorAction", "LPCronogramaCOBPeriodoModificar");
	eval("frmFormulario").oculto = "S";

	enviaSICC("frmFormulario");
}

// ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function llenaLista(valoresLista)
{
	// Se ejecuta desde la LP con el envia oculto. 
	// Si llega acá, entonces al menos un registro hay (ya que en el MON si no se obtienen registros
	// lanza una excepcion), por lo que no se necesitaria verificar si valoresLista es "".
	// Desparsea "valoresLista" para poder mostrar datos.

	// Puebla la lista.
	var arrayFilas = valoresLista.split("|");
	var datosALista = new Array();

	for (var i = 0; i < arrayFilas.length; i++ )
	{
		var filaActual = arrayFilas[i]; 
		var arrayCampos = filaActual.split("@");
		datosALista[i] = arrayCampos;
	}

	// Quita los posibles espacios en blanco " " en los campos de Fecha. 
	for (var i = 0; i < datosALista.length; i++ )
	{
		for (var j = 13; j < 16 ; j++ )
		{
			if ( datosALista[i][j] == " ")
 				   datosALista[i][j] = "";
		}
		
		if ( datosALista[i][18] == " ") {
 				   datosALista[i][18] = "";  
		}
	}

    arrayFilaModificada = new Array(datosALista.length);  // Incrementa la capacidad de arrayFilaModificada a la cant. de
																				  // registros de la ListaEditable
	listado1.setDatos(datosALista);
	manejaLista('visible');

	btnProxy('1', '1');
	
}

// ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function seteaModificado(indiceFila)
{
	listado1.actualizaDat();
    arrayFilaModificada[indiceFila] = "S";
}

// ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function fGuardar()
{
	 // Chequea si se ha modificado algun registro. Si no, entonces tira un mensaje de error.
	 // De paso, para aquellas filas que tenga un registro modificado, guarda su indice para luego
	 // tomar los valores de las mismas. 
	 var hayRegistroModificado = false;
	 var arrayIndicesModificados = new Array();
	 
	 for (var i = 0; i < arrayFilaModificada.length; i++)
	 {
		 if ( arrayFilaModificada[i] == "S")
		 {
			hayRegistroModificado = true;
			arrayIndicesModificados[arrayIndicesModificados.length] = i;
		 }
	 }

	 if ( !hayRegistroModificado )  // Muestra mensaje de error
		    GestionarMensaje("1468");
	 else 
	 {
			listado1.actualizaDat();
			var datos = listado1.datos;
		    //alert("datos: " + datos);

			// ACA VAN Validaciones de ListaEditable.
			// Valida que los formatos sean correctos
	
			// 
			if ( !sicc_validar_fecha_LE("FechaCierre", "", "", "", "", "listado1", 13, "S") )
                return;

			if ( !sicc_validar_fecha_LE("FechaEvaluacion", "", "", "", "", "listado1", 14, "S") )
				return;

			if ( !sicc_validar_fecha_LE("FechaAuditoria", "", "", "", "", "listado1", 15, "S") )
                return;

			if ( !sicc_valida_requerido_LE("FechaCierre", GestionarMensaje("1473", null, null, null), "listado1", 13) )
				return;
			
/*			if (!sicc_valida_requerido_LE("txtNumUnidades4", GestionarMensaje("1408", null, null, null), "listado1", 10); )
			{
			}*/
			// Recorre el array de Indices Modificados "arrayIndicesModificados",
			// por c\ elemento obtiene el oid oculto de la lista para ese Indice, y añade en las variables de formulario
			// "hFechaCierre", "hFechaEvaluacion" y "hFechaAuditoria" las fechas correspondientes a ese indice. 
			var cadenaOids = "";
			var cadenaFechaCierre = "";
			var cadenaFechaEvaluacion = "[";   // Le agrego "[" porque puede el primer o ultimo elemento venir vacio.
			var cadenaFechaAuditoria = "["; // Le agrego "[" porque puede el primer o ultimo elemento venir vacio.
			
			var cadenaEdadInicial= ""
			var cadenaEdadFinal = ""
			var cadenaFechaFacturacion = ""
			
			for (var i = 0; i < arrayIndicesModificados.length; i++ )
			{
					var indice = arrayIndicesModificados[i];
					var oid = datos[indice][0];
					var fechaCierre = datos[indice][13];
					var fechaEvaluacion = datos[indice][14];
					var fechaAuditoria = datos[indice][15];
					var edadInicial = datos[indice][16];
                    var edadFinal = datos[indice][17];
					var fechaFacturacion = datos[indice][18];
                    
                    /*chequea que F.Evaluación y F.Auditoría sean menor o igual q' F.Cierre
                      INC.21453 - splatas - 11/11/2005
					  vconte - se corrige validacion, ya que la funcion EsFechaValida() no retorna valores booleanos */
                   /* if(EsFechaValida(fechaCierre, fechaEvaluacion, 'frmFormulario', 'S') !=0 ||
					   EsFechaValida(fechaCierre, fechaAuditoria, 'frmFormulario', 'S') !=0){
							return GestionarMensaje("1466");
                    }	*/
										
					// Arma Cadena de Oids a Modificar
					if ( i != 0)
					{
							cadenaOids = cadenaOids + ",";
							cadenaFechaCierre = cadenaFechaCierre + ",";
							cadenaFechaEvaluacion = cadenaFechaEvaluacion + ",";
							cadenaFechaAuditoria = cadenaFechaAuditoria + ",";
							cadenaEdadInicial = cadenaEdadInicial +",";
						    cadenaEdadFinal = cadenaEdadFinal +",";
							cadenaFechaFacturacion  = cadenaFechaFacturacion  +",";

					 }


					cadenaOids = cadenaOids + oid;   
					cadenaFechaCierre = cadenaFechaCierre + fechaCierre;  // Fecha Cierre es obligatorio.
					cadenaEdadFinal = cadenaEdadFinal +edadFinal;
					cadenaEdadInicial = cadenaEdadInicial +	 edadInicial;
					cadenaFechaFacturacion = cadenaFechaFacturacion +  fechaFacturacion;

					if (fechaEvaluacion != "")
						cadenaFechaEvaluacion = cadenaFechaEvaluacion +  fechaEvaluacion;
				    else
						cadenaFechaEvaluacion = cadenaFechaEvaluacion +  " ";

					// Fecha Auditoria no es obligatorio.
					if (fechaAuditoria != "")
						cadenaFechaAuditoria = cadenaFechaAuditoria +  fechaAuditoria;
				    else
						cadenaFechaAuditoria = cadenaFechaAuditoria +  " ";

			}  // Fin For.

			cadenaFechaAuditoria = cadenaFechaAuditoria + "]";
			cadenaFechaEvaluacion = cadenaFechaEvaluacion  + "]";
			/*cadenaFechaCierre = cadenaFechaCierre + "]";
			 alert("cadenaOids: " + cadenaOids);
			 alert("cadenaFechaCierre: " + cadenaFechaCierre);
			 alert("cadenaFechaCierre: " + cadenaFechaEvaluacion);
			 alert("cadenaFechaCierre: " + cadenaFechaAuditoria);
			 cadenaEdadInicial = cadenaEdadInicial +"";
			 cadenaEdadFinal = cadenaEdadFinal +"";
			 cadenaFechaFacturacion  = cadenaFechaFacturacion  +"";	 */

			set("frmFormulario.oidFilaModificada", cadenaOids);
			set("frmFormulario.hFechaCierre", cadenaFechaCierre);
			set("frmFormulario.hFechaEvaluacion", cadenaFechaEvaluacion);
			set("frmFormulario.hFechaAuditoria", cadenaFechaAuditoria);

			set("frmFormulario.hEdadInicial", cadenaEdadInicial);
			set("frmFormulario.hEdadFinal", cadenaEdadFinal);
			set("frmFormulario.hFechaFacturacion", cadenaFechaFacturacion);
	

			set("frmFormulario.conectorAction", "LPCronogramaCOBPeriodoModificar");
        	set("frmFormulario.accion", "guardarCronograma");
			eval("frmFormulario").oculto = "S";

			enviaSICC("frmFormulario");

	 } // Fin If

}

// ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function fLimpiar()
{
	// Deja el caso de uso como si se hubiera entrado por 1ra vez.

	// Limpia array Global.
	arrayFilaModificada = new Array();

	// Limpia y reinicializa lista.
	listado1.setDatos( new Array() );
	manejaLista('hidden');


	// Limpia variables ocultas
	set("frmFormulario.oidFilaModificada", "");
	set("frmFormulario.hFechaCierre", "");
	set("frmFormulario.hFechaEvaluacion", "");
	set("frmFormulario.hFechaAuditoria", "");


	// Reinicializa Combos
	set("frmFormulario.cbMarca", new Array("") );
	set("frmFormulario.cbCanal", new Array("") );
	var arrayVacio = ["", ""];
	set_combo("frmFormulario.cbPeriodo", arrayVacio);
	focaliza("frmFormulario.cbMarca");

}

// ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function onShTabMarca()
{
	// Si no esta visible la lista, focaliza el boton Buscar. 
	// Si esta visible la lista, focaliza el ultimo elemento (se asume que la lista si esta visible, siempre
	// contendrá datos)
	var capaLista = document.getElementById("Cplistado1");
	var visibilidad = capaLista.style.visibility;

	if ( visibilidad == 'hidden')   // Focaliza boton "Buscar"
		focalizaBotonHTML('botonContenido', 'btnBuscar');
	else
	{
		// Obtiene el indice de la ultima fila y focaliza la ultima caja de texto de la lista.
	
		listado1.actualizaDat();
		var datos = listado1.datos;
		var lastIndex = datos.length;

		focalizaLista("FechaAuditoria", lastIndex - 1);
		/*var stringFocalizado = "frmlistado1.FechaAuditoria_" + (lastIndex - 1) ;

		listado1.preparaCamposDR();
		focaliza(stringFocalizado);*/
	}

}

// ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function tabBtnBuscar()
{
	// Si no esta visible la lista, focaliza el combo cbMarca simulando wraparound.
	// Si esta visible la lista, focaliza el primer elemento (se asume que la lista si esta visible, siempre
	// contendrá datos)

	var capaLista = document.getElementById("Cplistado1");
    var visibilidad = capaLista.style.visibility;

	if ( visibilidad == 'hidden')
		focaliza("frmFormulario.cbMarca");
	else {
		// Focaliza la primer caja de texto de la lista.
		focalizaLista("FechaCierre", 0);
	}

}

// ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function focalizaLista(nombreCampo, indice)
{
		// nombreCampo: Nombre de campo a focalizar (por ejemplo, 'FechaAuditoria')
		// indice: Valor  posicion a focalizar (debe ser 0-based)
		var stringFocalizado = "frmlistado1." + nombreCampo + "_" + indice;
		listado1.preparaCamposDR();
		focaliza(stringFocalizado);
}

// ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function errorAlBuscar()
{
	// Si se produjo un error al Buscar en  la LP (se invoca a esta funcion cuando se ejecuta el envia Oculto)
	btnProxy("1", "0");
}

/*-------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
function errorAlGuardar(esError,filaErronea,cajaTexto) {
    if(esError){
		GestionarMensaje("UICOB0001");
		
		if (cajaTexto == "fechaCierre") {
			focalizaLista("FechaCierre", filaErronea-1);
		}else{
			if (cajaTexto == "fechaEval") {
				focalizaLista( 'FechaEvaluacion',filaErronea-1);
				
			}else{
			   focalizaLista( 'FechaAuditoria',filaErronea-1);
			}
	   }

		btnProxy("1", "1");
	} else{
	  	 accionBuscar();
    }
	
}