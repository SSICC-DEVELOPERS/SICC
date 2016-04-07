function nombrar() {
	top.window.name = 'SICC Belcorp';
	document.onkeydown=null;
	document.onhelp=null;
	window.status="SICC Belcorp";	
}

function postForm() {
	var strUsuario = get("frmInicio.usuario");
	var contrasenia = get("frmInicio.contrasenia");
	var pais = get("frmInicio.cbPais");
	if(strUsuario==""){
		focaliza("frmInicio.usuario");
		window.status = "complete el usuario";
		return;
	}
	if( contrasenia == ""){
		focaliza("frmInicio.contrasenia")
		window.status = "complete la contraseña";
		return;
	}

	if( pais == ""){
		focaliza("frmInicio.cbPais")
		window.status = "seleccione el País";
		return;
	}

	set('frmInicio.oidPais', pais);

	eval('cbPaisURL').selectedIndex = eval('cbPais').selectedIndex;
	set('frmInicio.codigoPais', get('frmInicio.cbPaisURL'));

	envia('frmInicio',get('frmInicio.cbPaisURL','T'));
}

function setHook() {
  var obj = document.all('contrasenia');
  var pass;
  if (obj.length) {
	for (var i = 0; i < obj.length; i++) {
	  if (obj[i].type && obj[i].type.toUpperCase() == 'PASSWORD') {
		pass = obj[i];
		break;
	  }
	}
  }
  else pass = obj;
  if (pass) {
	try { pass.onfocus = selectedText; }
	catch(ex) {}
  }
}

function selectedText() {
  event.srcElement.select();
  event.returnValue = true;
  return true;
}

function isValid() {
  var TipoSalida = get('frmInicio.validado');
  //alert('TipoSalida: ' + TipoSalida);
	var salida = true;
	switch(TipoSalida.toUpperCase()){
		case "S":
		  // El usuario fue validado, le presento el menu
		  window.focus();
		  var strQueryString = '';
		  if (get('frmInicio.pantallaInicio') != '') {
			 strQueryString = get('frmInicio.pantallaInicio');
			 strQueryString = strQueryString.split('?').join('@@');
			 strQueryString = strQueryString.split('&').join('!!');
			 strQueryString = strQueryString.split('=').join('__');
			 strQueryString = '?contenido=' + strQueryString;
		  }
		  strQueryString += ((strQueryString == '') ? '?' : '&') + 'menu=LPPresentarMenuPrincipal' + '!' + '!'+ 'cdosIdioma__' + DrdIdioma();
		  if (opener && !opener.closed) {
				opener.top.location.href = '../principal.html' + strQueryString;
			} else {
				top.location.href = '../principal.html' + strQueryString;
			}
		  salida = false;			
		  break;
	  case "U":
			if(opener && !opener.closed){	
				opener.top.location.replace("../index_sustitucion_usuario.html");
			}else{
				window.top.location.replace("../index_sustitucion_usuario.html");
			}
			salida = false;
			break;
	  case "C":		  
			if(opener && !opener.closed){	
				opener.top.location.replace("../index_clave_acceso_cambiar.html");
			}else{
				window.top.location.replace("../index_clave_acceso_cambiar.html");
			}
			salida = false;
			break;
		case "E":
		  // Las credenciales del usuario expiraron, lo mando a cambio de clave
		  //fMostrarMensajeError();
		  if (opener && !opener.closed) {
			 opener.top.location.href = '../index_clave_acceso_cambiar.html';
		  } else {
			top.location.href = '../index_clave_acceso_cambiar.html';
		  }
		  salida = false;
	}
  return salida;
}


	function isEnter(){
		if (event.keyCode == 13){
			set('frmInicio.contrasenia', get('frmInicio.contrasenia'));
			event.returnValue = true;
			event.cancelBubble = true;
			window.setTimeout("postForm()",200);
			return true;
		}
	}

function fnErrores() {
  if (isValid()) {
	window.focus();
	var codigo = get('frmInicio.errCodigo');
	var descripcion = get('frmInicio.errDescripcion');
	var nombreD = get('frmInicio.nombreDevuelto');
	if (nombreD != '') {
		set('frmInicio.usuario', nombreD);
		}
	  if (descripcion != null && descripcion != '') {
		 if (descripcion.substr(0,4) == 'ERR_') 
			descripcion = GestionarMensaje(descripcion.split('_')[1]);
		 if (fMostrarMensajeError(codigo, descripcion) == 0) 
			postForm();
	  } else {
		focaliza('frmInicio.usuario', '');
	  }
  }
  if (opener) {
		if(!opener.closed){
		  try { opener.focaliza('frmInicio.usuario', ''); }
		  catch (ex) {}
		  window.close();			
		}else{
		  try { focaliza('frmInicio.usuario', ''); }
		  catch (ex) {}
		}
  }
}