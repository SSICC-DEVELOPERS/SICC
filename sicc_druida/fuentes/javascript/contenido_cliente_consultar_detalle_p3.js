// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function init() {

	configurarMenuSecundario('frmInsertarCliente'); 
	fMostrarMensajeError();

   DrdEnsanchaConMargenDcho('listado5', 12);
   DrdEnsanchaConMargenDcho('listado6', 12);
   DrdEnsanchaConMargenDcho('listado7', 12);

   document.all["Cplistado5"].style.visibility='visible';
   document.all["CpLin1listado5"].style.visibility='visible';
   document.all["CpLin2listado5"].style.visibility='visible';
   document.all["CpLin3listado5"].style.visibility='visible';
   document.all["CpLin4listado5"].style.visibility='visible';

   document.all["Cplistado6"].style.visibility='visible';
   document.all["CpLin1listado6"].style.visibility='visible';
   document.all["CpLin2listado6"].style.visibility='visible';
   document.all["CpLin3listado6"].style.visibility='visible';
   document.all["CpLin4listado6"].style.visibility='visible';

   document.all["Cplistado7"].style.visibility='visible';
   document.all["CpLin1listado7"].style.visibility='visible';
   document.all["CpLin2listado7"].style.visibility='visible';
   document.all["CpLin3listado7"].style.visibility='visible';
   document.all["CpLin4listado7"].style.visibility='visible';

	eval(ON_RSZ);

	i18n();

}


// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function siguientePestanya() {

	set('frmInsertarCliente.conectorAction', 'LPDetalleCliente');
	set('frmInsertarCliente.accion', 'pestanya4' );

	enviaSICC('frmInsertarCliente');  

}


// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function anteriorPestanya() {

	set('frmInsertarCliente.conectorAction', 'LPDetalleCliente');
	set('frmInsertarCliente.accion', 'pestanya2' );

	enviaSICC('frmInsertarCliente');  


}

// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function i18n() {

	// -------------- Lista Tipo de Comunicacion ----------------------
	var codigos = listado6.codigos();
	var cantElem = codigos.length;

	var si = GestionarMensaje("1010", null, null, null);
	var no = GestionarMensaje("1011", null, null, null);

	var LunesAViernes = GestionarMensaje('1332', null, null, null)
	var LunesADomingo = GestionarMensaje('1333', null, null, null)

	var dias = new Array();
	for (var i = 0; i < 7; i++)
		dias[i] = GestionarMensaje(1034 + i, null, null, null);

	var iniciales = new Array();
	iniciales[0] = "D";
	iniciales[1] = "L";
	iniciales[2] = "M";
	iniciales[3] = "I";
	iniciales[4] = "J";
	iniciales[5] = "V";
	iniciales[6] = "S";

	for (var i = 0; i < cantElem; i++)
	{
			// Internacionaliza SI/No,  Dias de la Semana e Intervalo Comunicacion.
		var SiNo = listado6.extraeDato(codigos[i], 3); 
		if (SiNo == "1")
			listado6.insertaDato(codigos[i], 3, si);
		else
			listado6.insertaDato(codigos[i], 3, no);

		for (var j = 0; j < 7; j++)
		{
			var inicialDia = listado6.extraeDato(codigos[i], 1); 
			if ( inicialDia == iniciales[j] )
				listado6.insertaDato(codigos[i], 1, dias[j]);									
		}

		var intervalo = listado6.extraeDato(codigos[i], 6);
		if ( intervalo == "1")
			listado6.insertaDato(codigos[i], 6, LunesADomingo);
		else
			listado6.insertaDato(codigos[i], 6, LunesAViernes);

		
	}

	// ------------- Lista Direcciones -----------------------

	var codigos = listado5.codigos();
	var cantElem = codigos.length;

	var si = GestionarMensaje("1010", null, null, null);
	var no = GestionarMensaje("1011", null, null, null);

	for (var i = 0; i < cantElem; i++)
	{//Cleal - MAE-005
		var SiNo = listado5.extraeDato(codigos[i], 7); 
		//alert("FIla " + i + ": " + SiNo);
		if (SiNo == "1")
			listado5.insertaDato(codigos[i], 7, si);
		else
			listado5.insertaDato(codigos[i], 7, no);
	}
}

// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function fVolver() {
	window.close();
}
