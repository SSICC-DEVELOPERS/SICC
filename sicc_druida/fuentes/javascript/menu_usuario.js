function callMenu(){
	//parent.frames(3).location.href='sicc0000jg?ON='+arguments[0]+'&fromMenu=true';
//	alert(arguments[0].split("&")[0]);
	var arrFuncion = arguments[0].split("&");
	var arrIdFuncion = arrFuncion[1].split("=");
	var idFuncion = arrIdFuncion[1];
	var nom = arguments[0].split("&")[0];
//	alert(nom);

	top.framesOn = true; //Oculto el frame de menú.

	parent.document.all["frameMenu"].cols="0,*"; 

	set("frmSalida.hidIdFuncion",idFuncion);
	set("frmSalida.idFuncion",idFuncion);
	set("frmSalida.clean","true");
	//parent.frames(3).location.href='sicc0000jg?ON='+arguments[0]+'&fromMenu=true'
	set('frmSalida.conectorAction', nom);
	envia('frmSalida', '', 'contenido'); 
}

function getIdFuncion(){
	return get("frmSalida.hidIdFuncion");
}

function getPantallaInicio(){
	return parent.getPantallaInicio();
}

function carga() {
	if (parent.menuCargado) {
		 var pantallaInicio = "";
		 pantallaInicio = getPantallaInicio().split("=")[1];
//		 alert(pantallaInicio);
		 set('frmSalida.conectorAction', pantallaInicio);
		 envia('frmSalida', '', 'contenido'); 
		 parent.menuCargado = false;
	 }
  }

function recarga(){
	set("frmSalida.conectorAction", "LPPresentarMenuPrincipal");
	envia("frmSalida");
	return;
}