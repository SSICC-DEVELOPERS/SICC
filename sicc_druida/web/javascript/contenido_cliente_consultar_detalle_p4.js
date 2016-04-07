function init() {

   fMostrarMensajeError();
   configurarMenuSecundario("frmInsertarCliente");

   DrdEnsanchaConMargenDcho('listado8', 12);
   DrdEnsanchaConMargenDcho('listado9', 12);
   DrdEnsanchaConMargenDcho('listado10', 12);
   DrdEnsanchaConMargenDcho('listado11', 12);
   document.all["Cplistado8"].style.visibility='visible';
   document.all["CpLin1listado8"].style.visibility='visible';
   document.all["CpLin2listado8"].style.visibility='visible';
   document.all["CpLin3listado8"].style.visibility='visible';
   document.all["CpLin4listado8"].style.visibility='visible';

   document.all["Cplistado9"].style.visibility='visible';
   document.all["CpLin1listado9"].style.visibility='visible';
   document.all["CpLin2listado9"].style.visibility='visible';
   document.all["CpLin3listado9"].style.visibility='visible';
   document.all["CpLin4listado9"].style.visibility='visible';

   document.all["Cplistado10"].style.visibility='visible';
   document.all["CpLin1listado10"].style.visibility='visible';
   document.all["CpLin2listado10"].style.visibility='visible';
   document.all["CpLin3listado10"].style.visibility='visible';
   document.all["CpLin4listado10"].style.visibility='visible';

   document.all["Cplistado11"].style.visibility='visible';
   document.all["CpLin1listado11"].style.visibility='visible';
   document.all["CpLin2listado11"].style.visibility='visible';
   document.all["CpLin3listado11"].style.visibility='visible';
   document.all["CpLin4listado11"].style.visibility='visible';

   eval(ON_RSZ);
   i18n();
}

// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function anteriorPestanya() {

	set('frmInsertarCliente.conectorAction', 'LPDetalleCliente');
	set('frmInsertarCliente.accion', 'pestanya3' );

	enviaSICC('frmInsertarCliente');  
}

// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function i18n() { 
	// Internacionaliza Si / No de Lista Problema - Solucion 
	var codigos = listado10.codigos();
	var cantElem = codigos.length;

	var si = GestionarMensaje("1010", null, null, null);
	var no = GestionarMensaje("1011", null, null, null);

	// Por cada fila de la lista. 	
	for (var i = 0; i < cantElem; i++)
	{
			// Internacionaliza SI/No y Dias de la Semana.
		var SiNo = listado10.extraeDato(codigos[i], 2); 
		if (SiNo == "true")
			listado10.insertaDato(codigos[i], 2, si);
		else
			listado10.insertaDato(codigos[i], 2, no);
	}
}


// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function fVolver() {
	window.close();
}
