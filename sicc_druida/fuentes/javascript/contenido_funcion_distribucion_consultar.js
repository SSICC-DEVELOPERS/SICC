function fLimpiar() {
	onLoadPag();
}

function onLoadPag() {  
	fMostrarMensajeError();
	configurarMenuSecundario("formulario");
	btnProxy(5, '0');
	DrdEnsanchaConMargenDcho('listado1',12);     
    eval (ON_RSZ);  
	muestraCapa();
}

function muestraCapa() {
	document.all["Cplistado1"].style.visibility='';
    document.all["CpLin1listado1"].style.visibility='';
    document.all["CpLin2listado1"].style.visibility='';
    document.all["CpLin3listado1"].style.visibility='';
    document.all["CpLin4listado1"].style.visibility='';
}