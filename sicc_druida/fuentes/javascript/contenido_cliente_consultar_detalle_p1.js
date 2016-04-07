// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function init() {

   fMostrarMensajeError();
   configurarMenuSecundario("frmInsertarCliente");

   DrdEnsanchaConMargenDcho('listado1', 12);
   document.all["Cplistado1"].style.visibility='visible';
   document.all["CpLin1listado1"].style.visibility='visible';
   document.all["CpLin2listado1"].style.visibility='visible';
   document.all["CpLin3listado1"].style.visibility='visible';
   document.all["CpLin4listado1"].style.visibility='visible';
   eval(ON_RSZ);

   manejaI18n();

}


// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function manejaI18n() {

		var si = GestionarMensaje("1010", null, null, null);
		var no = GestionarMensaje("1011", null, null, null);

		var persona = GestionarMensaje("1043", null, null, null);
		var empresa = GestionarMensaje("1050", null, null, null);

		var codigos = listado1.codigos();
		var cantFilas = codigos.length;

		//alert("codigos: " + codigos);
		for (var i = 0; i < cantFilas; i++)
		{
			// Documento Principal
			var SiNo = listado1.extraeDato(codigos[i], 2); 
			//alert("Fila " + i + ": " + SiNo);
			if (SiNo == "1")
			{
				listado1.insertaDato(codigos[i], 2, si);
				//alert("si: " + si);
			}
			else
			{
				listado1.insertaDato (codigos[i], 2, no);
				//alert("no: " + no);
			}

			// Persona o Empresa.
			var PersonaEmpresa = listado1.extraeDato(codigos[i], 3);
			if (PersonaEmpresa == "P")
				listado1.insertaDato(codigos[i], 3, persona);
			else
				listado1.insertaDato(codigos[i], 3, empresa);
		}
}

// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function siguientePestanya() {

	set('frmInsertarCliente.conectorAction', 'LPDetalleCliente');
	set('frmInsertarCliente.accion', 'pestanya2' );

	enviaSICC('frmInsertarCliente');  

}


// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function anteriorPestanya() {

	set('frmInsertarCliente.conectorAction', 'LPDetalleCliente');
	set('frmInsertarCliente.accion', 'pestanya0' );

	enviaSICC('frmInsertarCliente');  
}


// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function fVolver() {
	window.close();
}

