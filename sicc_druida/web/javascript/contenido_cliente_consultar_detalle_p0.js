// --------------------------------------------------------------------------------------------------------------------------------------------
function init() { 

   fMostrarMensajeError(); 		  
   configurarMenuSecundario("frmInsertarCliente");

   DrdEnsanchaConMargenDcho('listado0',12);
   document.all["Cplistado0"].style.visibility='visible';
   document.all["CpLin1listado0"].style.visibility='visible';
   document.all["CpLin2listado0"].style.visibility='visible';
   document.all["CpLin3listado0"].style.visibility='visible';
   document.all["CpLin4listado0"].style.visibility='visible';

   eval(ON_RSZ);  	    
}

// --------------------------------------------------------------------------------------------------------------------------------------------
function siguientePestanya() {

	set('frmInsertarCliente.conectorAction', 'LPDetalleCliente');
	set('frmInsertarCliente.accion', 'pestanya1' );

	enviaSICC('frmInsertarCliente');  

}

// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function fVolver() {
	window.close();
}
