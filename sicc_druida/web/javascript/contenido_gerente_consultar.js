var FORMULARIO = 'formulario';

function onLoadPag(){
	
	configurarMenuSecundario(FORMULARIO);
}
	
	
function fVolver(){
	window.returnValue=get(FORMULARIO+'.oidContacto');
	window.close();            
}

 

function unLoadPag(){
	window.returnValue=get(FORMULARIO+'.oidContacto');
}
