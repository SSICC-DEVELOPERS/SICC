// --------------------------------------------------------------------------------------------------
function init()
{
		configurarMenuSecundario("frmVariablesVenta");
		fMostrarMensajeError();
		seteaPantalla();

		focaliza("frmVariablesVenta.txtNumUnidadesTotalesRepartir", "");
        
        // [1] Agregado por Rafael Romero / SiCC 20070189 - 24/04/2007
        var estadoProceso = get('frmVariablesVenta.varEstadoProceso');
        if(estadoProceso == "4"){
            accion("frmVariablesVenta.txtNumUnidadesTotalesRepartir" , ".disabled=true");
            accion("frmVariablesVenta.cbVariableVentas" , ".disabled=true");
            accion("frmVariablesVenta.cbCampanyaEvaluaFuenteVentas" , ".disabled=true");
        }
        // fin agregar [1]
        
}

// --------------------------------------------------------------------------------------------------
function aceptar()
{

	if ( sicc_validaciones_generales() )
	{
			var array = new Array();
			var numUnidades = get("frmVariablesVenta.txtNumUnidadesTotalesRepartir");
			var subcriterio = get("frmVariablesVenta.cbVariableVentas");
			var campanya = get("frmVariablesVenta.cbCampanyaEvaluaFuenteVentas");

			array[0] = subcriterio;
			array[1] = numUnidades;
			array[2] = campanya;

			returnValue = array;

			window.close();		
	}


}

// -------------------------------------------------------------------------------------------------------
function fVolver()
{
		window.close();
}

// -------------------------------------------------------------------------------------------------------
function shiftTab()
{
	document.selection.empty();
    focalizaBotonHTML('botonContenido', 'btnContinuar');
}

// -------------------------------------------------------------------------------------------------------
function fLimpiar()
{
	seteaPantalla();
	focaliza("frmVariablesVenta.txtNumUnidadesTotalesRepartir");
}

// -------------------------------------------------------------------------------------------------------
function seteaPantalla()
{
	var campanya = get("frmVariablesVenta.hidCampanyaFuente");
	set("frmVariablesVenta.cbCampanyaEvaluaFuenteVentas", new Array(campanya) );

	var numUnidadesTotales = get("frmVariablesVenta.hidNumUnidadesTotales");
	set("frmVariablesVenta.txtNumUnidadesTotalesRepartir", numUnidadesTotales);

	var subCriterio = get("frmVariablesVenta.hidSubcriterio");
	set("frmVariablesVenta.cbVariableVentas", new Array(subCriterio) );
}

