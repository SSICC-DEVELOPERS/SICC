function init() {
    // splatas - 24/11/2005 - INC.21405
    configurarMenuSecundario("frmContenido");
}
 
	 function mostrarVentadaModal(url) {
		var parametros = new Object();  
	    var obj = mostrarModalSICC(url,"modificar", parametros, '710', '550');
		
		setCodCliente(obj.codClie)	;
	}

	function setCodCliente(codclie) {
		document.applets[0].setCodigoCliente(codclie);
	}

		function llamarFuncion() {
			document.applets[0].ejecutarJava();
			alert('Ver la consola java, se tuvo que haber mostrado el mensaje: "Se llamo a ejecutarJava"');
		}


function mostrarInsertarClienteBasico(url) {
	var parametros = new Object();  
	parametros.origen = "otro";
	var obj = mostrarModalSICC(url,'', parametros, '710', '550');
	if(obj != null) {
		document.applets[0].setCodigoCliente(obj[0]);
	}
}

function obtenerPagadorFactura(url) {
	var parametros = new Object();  
    var obj = mostrarModalSICC(url,'', parametros, '710', '550');
	if(obj != null) {
		document.applets[0].setPagadorFactura(obj[1]);
	}
}

function obtenerReceptorFactura(url) {
	var parametros = new Object();  
    var obj = mostrarModalSICC(url,'', parametros, '710', '550');
	if(obj != null) {
		document.applets[0].setReceptorFactura(obj[1]);
	}
}

function obtenerCodigoCliente(url) {
	var parametros = new Object();  
    var obj = mostrarModalSICC(url,'', parametros, '710', '550');
	if(obj != null) {
		document.applets[0].setCodigoCliente(obj[1]);
	}
}

function obtenerConsultoraRefencia(url) {
	var parametros = new Object();  
    var obj = mostrarModalSICC(url,'', parametros, '710', '550');
	if(obj != null) {
		document.applets[0].setConsultoraRefencia(obj[1]);
	}
}

function consultarModificarSolicitud(url, v_accion, v_operacion, v_oidCabeceraSolicitud) {
	var parametros = new Object();  
	//parametros.accion = v_accion;
	parametros.operacion = v_operacion;
	parametros.oidCabeceraSolicitud = v_oidCabeceraSolicitud;

    var obj = mostrarModalSICC(url,v_accion, parametros, '710', '550');

}

function cerrarVentana() {
	var hist = history.length;
	if(hist > 0) {
		history.go(-1);
	} else {
		parent.close();
	}
}

// splatas - 24/11/2005 - INC.21405
function fVolver(){
    window.close();
}
