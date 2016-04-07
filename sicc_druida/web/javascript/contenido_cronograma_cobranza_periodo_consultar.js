var varNoLimpiarSICC = true;

// -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function onLoadPag()   
{
	manejoLista('hidden');
	configurarMenuSecundario("frmFormulario");
	fMostrarMensajeError();
  focaliza('frmFormulario.cbMarca');
}

// -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function manejoLista(valor)
{
	DrdEnsanchaConMargenDcho('listado1',12);

	document.all["Cplistado1"].style.visibility=valor;
	document.all["CpLin1listado1"].style.visibility=valor;
	document.all["CpLin2listado1"].style.visibility=valor;
	document.all["CpLin3listado1"].style.visibility=valor;
	document.all["CpLin4listado1"].style.visibility=valor;

	document.all["primera1Div"].style.visibility=valor;
	document.all["ret1Div"].style.visibility=valor;
	document.all["ava1Div"].style.visibility=valor;
	document.all["separaDiv"].style.visibility=valor;

	eval (ON_RSZ);  
}

// -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function recargaPeriodo()
{
	var marca = get("frmFormulario.cbMarca");
	var canal = get("frmFormulario.cbCanal");

	if ( marca != "" && canal != "")
	{
		recargaCombo("frmFormulario.cbPeriodo", "CRAObtienePeriodos", "es.indra.sicc.dtos.cra.DTOPeriodo", armarArrayPeriodo() );
	} else
	{
		var array = new Array();
		array[0] = ["", ""];
		set_combo("frmFormulario.cbPeriodo", array);
	}
}

// -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function armarArrayPeriodo()
{
	var pais = get("frmFormulario.hPais");
	var marca = get("frmFormulario.cbMarca");
	var canal = get("frmFormulario.cbCanal");

	var array = new Array();

	array[0] = ["pais", pais];
	array[1] = ["marca", marca];
	array[2] = ["canal", canal];

	return array;

}
// -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function accionBuscar()
{
	configurarPaginado(mipgndo, 
									"COBBuscarCronogramaCOBPeriodo", 
									"ConectorBuscarCronogramaCOBPeriodo", 
									"es.indra.sicc.dtos.cob.DTOEBuscarCronogramaCOBPeriodo", 
									armarArrayPaginado());
}

// -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function armarArrayPaginado()
{

	var pais = get("frmFormulario.hPais");
	var idioma = get("frmFormulario.hIdioma");
	var marca = get("frmFormulario.cbMarca");
	var canal = get("frmFormulario.cbCanal");
	var periodo= get("frmFormulario.cbPeriodo");
	var array = new Array();

	array[0] = ["oidPais", pais];
	array[1] = ["oidIdioma", idioma];
	array[2] = ["marca", marca];
	array[3] = ["canal", canal];
	array[4] = ["periodo",  periodo];
	array[5] = ["paginado", true];

	return array;

}

// -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function muestraLista(ultima, rowset)
{
  rows = rowset.length;
  
  if (rows>0) {
    manejoLista('visible');
	focaliza("frmFormulario.cbMarca");  
	return true;
  } else {
    manejoLista('hidden');
	focaliza("frmFormulario.cbMarca");  
	return false;
  }	
	
}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function fLimpiar()
{
	listado1.setDatos(new Array() );
	manejoLista('hidden');

	var array = new Array();
	array[0] = ["", ""];
	set_combo("frmFormulario.cbPeriodo", array);

	set("frmFormulario.cbMarca", new Array("") );
	set("frmFormulario.cbCanal", new Array("") );

}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function onshTabMarca()
{
	focalizaBotonHTML("botonContenido", "btnBuscar");
}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function onTabBuscar()
{
	focaliza("frmFormulario.cbMarca");
}


