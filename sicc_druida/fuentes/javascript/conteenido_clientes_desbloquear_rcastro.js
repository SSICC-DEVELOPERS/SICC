var FORMULARIO='frmDesbloquearClientes';
function onLoadPag(){
	//alert('Que pasa?');
	focaliza(FORMULARIO+'.textCodCliente');
}
function accionBuscar(){
	//Mustra la capa	
	visibilidad('capaLista','V');
	//Ensancha la lista editable
	DrdEnsanchaConMargenDcho('listado1',12);
	eval (ON_RSZ);
}

function copiar(){
	set(FORMULARIO+'.textNombre2',get(FORMULARIO+'.textNombre1'));	

}