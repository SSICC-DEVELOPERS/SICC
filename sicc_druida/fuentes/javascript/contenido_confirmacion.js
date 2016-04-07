function carga()
{
	//alert("Entrando en carga");
	var hayErrores = fnErrores();
	//alert("Salio de fnErrores - " + hayErrores);
	if (hayErrores == false)
	{

		var accion = get("frmMain.accion");
		//alert("accion: " + accion);
		if (accion=="")
		{
			//alert("Accion vacio");
			var pais = get("frmMain.nombrePais");
			var nRetorno = GestionarMensaje("957",  pais, null, null);
			//alert("nRetorno: " + nRetorno);
			if ( nRetorno == true )
			{
				set("frmMain.accion", "aceptar")
				enviaSICC("frmMain");

			} else
			{
				set("frmMain.accion", "volver");
				enviaSICC("frmMain");
			}
		 } else if ( accion == "aceptar")
		 {
			var exito = get("frmMain.exito");
			if ( exito == "SI")
                cdos_mostrarAlert(GestionarMensaje("989"));
			set("frmMain.accion", "volver");
			enviaSICC("frmMain");
 	 	    //alert("Aca entro por Aceptar. Mostraría un mensaje sobre si la operación se realizo correctamente o no.");
		 } 
	} else  // hubo errores. Vuelve a la pantalla inicial
	{
		set("frmMain.accion", "volver");
		enviaSICC("frmMain");
	}
}

function fnErrores()
{
	var codigo = get("frmMain.errCodigo");
	var descripcion = get("frmMain.errDescripcion");

	//alert("Codigo error: " + codigo);
	
	if (codigo != "")	{
			//alert("hay error");
			// Hay error. 
			cdos_mostrarAlert(descripcion);
			return true;
	} 
	//alert("No hay error");
	return false;

}

