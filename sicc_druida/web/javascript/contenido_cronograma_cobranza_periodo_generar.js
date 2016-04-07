var varNoLimpiarSICC = true;

// -----------------------------------------------------------------------------------------------------------------------------------------------------------------
function onLoadPag()   
{
 
		manejoLista();
		configurarMenuSecundario("frmFormulario");
		fMostrarMensajeError();


		var deshabilitaBoton = get("frmFormulario.deshabilitaBoton");
		//alert("DeshabilitaBoton: " + deshabilitaBoton);
		if ( deshabilitaBoton == "S")
				deshabilitarHabilitarBoton('botonContenido', 'Generar', 'D');
}

// ----------------------------------------------------------------------------------------------------------------------------------------------------------------
function manejoLista()
{
        DrdEnsanchaConMargenDcho('listado1',12);
	    
	    document.all["Cplistado1"].style.visibility='';
	    document.all["CpLin1listado1"].style.visibility='';
	    document.all["CpLin2listado1"].style.visibility='';
	    document.all["CpLin3listado1"].style.visibility='';
	    document.all["CpLin4listado1"].style.visibility='';

	    document.all["primera1Div"].style.visibility='';
	    document.all["ret1Div"].style.visibility='';
	    document.all["ava1Div"].style.visibility='';
	    document.all["separaDiv"].style.visibility='';

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
function accionGenerarCronograma()
{

	if ( sicc_validaciones_generales("todos") )
	{
			var codSeleccionados = listado1.codSeleccionados();
			var oidPeriodo = get("frmFormulario.cbPeriodo");

			if ( codSeleccionados.length == 0)
			{
				GestionarMensaje("4");
				//alert("Debe seleccionar 1 elemento de la lista al menos ");
				return;
			}

/*			set("frmFormulario.hOidPeriodo", oidPeriodo);
			set("frmFormulario.oidSeleccionados", codSeleccionados);
			set("frmFormulario.conectorAction", "LPGenerarCronogramaCOBPeriodo");
			set("frmFormulario.accion", "generarCronograma");

			enviaSICC("frmFormulario");		*/

			var obj = new Object();
			obj.hOidPeriodo = oidPeriodo;
			obj.oidSeleccionados = codSeleccionados;

			mostrarModalSICC('LPGenerarCronogramaCOBPeriodo', 'generarCronograma', obj);

	}

}



// ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function tabPeriodo()
{
	focaliza("frmFormulario.cbMarca", "");	
}

// ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

function shtabMarca()
{
	focaliza("frmFormulario.cbPeriodo", "");	
}

// ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function fLimpiar()
{
	// Reinicia del caso de uso.
	set("frmFormulario.conectorAction", "LPGenerarCronogramaCOBPeriodo");
	set("frmFormulario.accion", "");
	eval("frmFormulario").oculto = "N";

	enviaSICC("frmFormulario", "", "", "N");

}



