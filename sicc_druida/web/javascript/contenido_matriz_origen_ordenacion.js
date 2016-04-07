function onLoadPag()   
{
    configurarMenuSecundario("frmPBuscarTiposError");
	DrdEnsanchaConMargenDcho('listado1',12);
	document.all["Cplistado1"].style.visibility='visible';
	document.all["CpLin1listado1"].style.visibility='visible';
	document.all["CpLin2listado1"].style.visibility='visible';
	document.all["CpLin3listado1"].style.visibility='visible';
	document.all["CpLin4listado1"].style.visibility='visible';
	document.all["primera1Div"].style.visibility='visible';
	document.all["ret1Div"].style.visibility='visible';
	document.all["ava1Div"].style.visibility='visible';
	document.all["separaDiv"].style.visibility='visible';
	document.all["CrearDiv"].style.visibility='visible';
	eval (ON_RSZ);  
}

/*
	Funciones para resolver el menu secundario
*/
	function fGuardar()
	{
		alert("Boton Guardar");
	}

	function fVolver()
	{
		alert("Boton Volver");
	}

	function fBorrar()
	{
		alert("Boton Eliminar");
	}
	
	function fLimpiar()
	{
		alert("Boton Limpiar");
		listado1.load();
	}

/*
	Fin funciones para menu secundario
*/


	function accionCrear()
	{

//		alert("accionCrear");
		if(listado1.datos.length != 0)
		{
			var orden = listado1.codSeleccionados();
			alert("Linea seleccionada " + orden);
			set('frmPBuscarTiposError.oidCabeceraMatriz', orden);
			set('frmPBuscarTiposError.accion', 'crear');
			enviaSICC('frmPBuscarTiposError');

		}else
		{
			alert("no hay seleccion: " + listado1.datos.length);
		}
	}

//
// No se sabe quien la llama
//
    function accionBuscar ()
    {
         configurarPaginado (mipgndo,'DTOBuscarMatricesDTOActivas','ConectorBuscarMatricesDTOActivas',
            'es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion', armarArray());
    }

    function armarArray()
    {
         var vArray = new Array();
         vArray[0] = new Array('oidIdioma','1');
         vArray[1] = new Array('oidPais','1');         
         return vArray;
    }
