// -------------------------------------------------------------------------------------------------------------------------------------
function onLoadPag(){

	/* 
	 * Si se llegó a mostrar esta pagina, es porque hubo un Error o no es Perdida
	 * Solo debe cerrarse 
	 */ 
	fMostrarMensajeError();
	returnValue = null;
	window.close();
}
