function onLoadPag(){
	configurarMenuSecundario('frmFormulario');
	//set('frmFormulario.atxtVisualizador',get('frmFormulario.textFactura'));
	//alert(get('frmFormulario.textFactura'));
	//txt_to('etiqueta',get('frmFormulario.textFactura'));
	//asignarDoc();
}

function asignarDoc(){
	document.writeln('<PRE><b>'+document.frmFormulario.textFactura.value+'</b></PRE>');
	}