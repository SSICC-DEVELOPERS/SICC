function onLoadPag() {  
	configurarMenuSecundario("formulario");
    DrdEnsanchaConMargenDcho('listado1',12);     
	eval (ON_RSZ);  
	muestraLista1();
	focalizaBotonHTML_XY('btnRevisarError');
}

function muestraLista1() {
	document.all["Cplistado1"].style.visibility='';
    document.all["CpLin1listado1"].style.visibility='';
    document.all["CpLin2listado1"].style.visibility='';
    document.all["CpLin3listado1"].style.visibility='';
    document.all["CpLin4listado1"].style.visibility='';
    document.all["avaDiv"].style.visibility='';
    document.all["retDiv"].style.visibility='';
    document.all["separaDiv"].style.visibility='';
	document.all["primeraDiv"].style.visibility='';    
	document.all["btnRevisarErrorDiv"].style.visibility='';
	document.all["btnRevisarTodoDiv"].style.visibility='';
}

function obtenerDatosLista() {
	var datosLista = "";
	listado1.actualizaDat();
	var datos = listado1.datos;
	var cant = datos.length;
	for(var i=0; i<cant;i++) {
		var datoFila = "";
		var filas = datos[i];
		var cantFilas = filas.length;
		for(var j=0; j<cantFilas; j++) {
			var dato = filas[j];
			if(j==0) {
				datoFila = datoFila + dato;
			}
			else {
				datoFila = datoFila + "|" + dato;
			}
		}
		if(i==0) {
			datosLista = datosLista + datoFila;
		}
		else {
			datosLista = datosLista + "?" + datoFila;
		}
	}
	return datosLista;
}

function obtenerDatosListaError() {
	var datosLista = "";
	listado1.actualizaDat();
	var datos = listado1.datos;
	var cant = datos.length;
	for(var i=0; i<cant;i++) {
		var datoFila = "";
		var filas = datos[i];
		var cantFilas = filas.length;		
		
		for(var j=0; j<cantFilas; j++) {
			// BELC400000735 - dmorello, 14/09/2007
			//if(filas[6]=="0") {
			if (filas[12] == null || filas[12] == '') {
				break;
			}

			var dato = filas[j];
			if(j==0) {
				datoFila = datoFila + dato;
			}
			else {
				datoFila = datoFila + "|" + dato;
			}
		}

		if(datoFila!="") {
			if(datosLista=="") {
				datosLista = datosLista + datoFila;
			}
			else {
				datosLista = datosLista + "?" + datoFila;
			}
		}		
	}
	return datosLista;
}

function onClickRevisarTodosDetalles() {
	listado1.actualizaDat();
	var datos = listado1.datos;
	var cant = datos.length;
	if(cant>0) {
	    var obj = new Object();
		obj.datosLista = obtenerDatosLista();
	    var retorno =  mostrarModalSICC('LPRevisionInconsistenciaChequeo','revisarTodosDetalles',obj);

		if(retorno!=null){       
			var retorno = new Array();
			retorno[0] = "OK";
			   
			returnValue = retorno;
			close();
		}
	}
}

function onClickRevisarDetalleError() {
	listado1.actualizaDat();
	var datos = listado1.datos;
	var cant = datos.length;
	if(cant>0) {
		var obj = new Object();
		var datLista = obtenerDatosListaError();
    
    if(datLista!=""){
        obj.datosLista = datLista;        
        var retorno = mostrarModalSICC('LPRevisionInconsistenciaChequeo','revisarDetallesError',obj);	

		if(retorno!=null){       
			var retorno = new Array();
			retorno[0] = "OK";
			   
			returnValue = retorno;
			close();
		}

    } else {
        GestionarMensaje('2590',null,null,null);              
    }
	}
}

function onTABBotonError() {
	focalizaBotonHTML_XY('btnRevisarTodo');
}

function onSHTABBotonError() {
	focalizaBotonHTML_XY('btnRevisarTodo');
}

function onTABBotonTodo() {
	focalizaBotonHTML_XY('btnRevisarError');
}

function onSHTABBotonRevisar() {
	focalizaBotonHTML_XY('btnRevisarError');
}

function fVolver() {
	window.close();
}
