var posicion = 1;
var datosListaTemp = new Array();	

function fVolver() {
	window.close();
}

function onLoadPag() {  
	configurarMenuSecundario("formulario");
	asignarDatosPantallaInicio();
	pasarStringToMatriz();
	focaliza("formulario.txtUnidEnCaja");
}

function asignarDatosPantallaInicio() {
	var datosLista = get("formulario.datosLista");
	if(datosLista!="") {
		var filasTemp = datosLista.split("?");
		var columnasTemp = filasTemp[0].split("|");
		var desProd = columnasTemp[2];
		var unidsol = columnasTemp[3];
		var unidcaja = columnasTemp[4];
		var obser = columnasTemp[9];		
		txt_to('DescripcionProducto', desProd);
		txt_to('UnidSolicitadas', unidsol);
		set("formulario.txtUnidEnCaja", unidcaja);  
		set("formulario.Observaciones", obser);  
	}
}


function pasarStringToMatriz() {
	var datos = new Array();
	var datosLista = get("formulario.datosLista");
	var filasTemp = datosLista.split("?");
	for(var i=0; i<filasTemp.length ; i++) {
		var columnasTemp = filasTemp[i].split("|");
		datos[i] = columnasTemp;
	}	
	datosListaTemp = datos;
}

function onClickAceptar() {
	revisarDetallesAceptar();
}


function revisarDetallesAceptar() {
 
  if(sicc_validaciones_generales()) {
        // revision vbongiov
		if(validar(datosListaTemp[posicion-1][3], get("formulario.txtUnidEnCaja")) == 0 ){ 
			 //actualiza la lista 

			datosListaTemp[posicion-1][4] = get("formulario.txtUnidEnCaja");
			datosListaTemp[posicion-1][9] = get("formulario.Observaciones"); 
			datosListaTemp[posicion-1][13] = get("formulario.txtUnidEnCaja");

			if(posicion < datosListaTemp.length) {
					//Setea nuevos datos a mostrar 
					txt_to('DescripcionProducto', datosListaTemp[posicion][2]);
					txt_to('UnidSolicitadas', datosListaTemp[posicion][3]);
					set("formulario.txtUnidEnCaja", datosListaTemp[posicion][4]);  
					set("formulario.Observaciones", datosListaTemp[posicion][9]);  

			  } else {    

					eval("formulario").oculto= "S";
					var datosLista = obtenerDatosLista();
					set("formulario.datosLista", datosLista);
					set("formulario.conectorAction", "LPRevisionInconsistenciaChequeo");
					set("formulario.accion", "guardarDetalle");
					enviaSICC("formulario");
					
					
			}
		} else {
			
				if(validar(datosListaTemp[posicion-1][3], get("formulario.txtUnidEnCaja")) == 1 ){ 				
					var unidades = Number(datosListaTemp[posicion-1][3]) - Number(get("formulario.txtUnidEnCaja"));
					//Agregado por cambio 20090839			
					GestionarMensaje('APE052', unidades);
					datosListaTemp[posicion-1][4] = get("formulario.txtUnidEnCaja");
					datosListaTemp[posicion-1][9] = get("formulario.Observaciones"); 
					datosListaTemp[posicion-1][13] = get("formulario.txtUnidEnCaja");
					if(posicion < datosListaTemp.length) {
							//Setea nuevos datos a mostrar 
							txt_to('DescripcionProducto', datosListaTemp[posicion][2]);
							txt_to('UnidSolicitadas', datosListaTemp[posicion][3]);
							set("formulario.txtUnidEnCaja", datosListaTemp[posicion][4]);  
							set("formulario.Observaciones", datosListaTemp[posicion][9]);  

					}else{
						
						eval("formulario").oculto= "S";
						var datosLista = obtenerDatosLista();
						set("formulario.datosLista", datosLista);
						set("formulario.conectorAction", "LPRevisionInconsistenciaChequeo");
						set("formulario.accion", "guardarDetalle");
						enviaSICC("formulario");						
					}
					
					//return;
				}else{

					if(validar(datosListaTemp[posicion-1][3], get("formulario.txtUnidEnCaja")) == 2 ){ 
						var unidades = Number(get("formulario.txtUnidEnCaja") - Number(datosListaTemp[posicion-1][3]));
						
						//Agregado por cambio 20090839
						GestionarMensaje('APE053', unidades);
						datosListaTemp[posicion-1][4] = get("formulario.txtUnidEnCaja");
						datosListaTemp[posicion-1][9] = get("formulario.Observaciones"); 
						datosListaTemp[posicion-1][13] = get("formulario.txtUnidEnCaja");
						if(posicion < datosListaTemp.length) {
								//Setea nuevos datos a mostrar 
								txt_to('DescripcionProducto', datosListaTemp[posicion][2]);
								txt_to('UnidSolicitadas', datosListaTemp[posicion][3]);
								set("formulario.txtUnidEnCaja", datosListaTemp[posicion][4]);  
								set("formulario.Observaciones", datosListaTemp[posicion][9]);  
	
						}else{
								eval("formulario").oculto= "S";
								var datosLista = obtenerDatosLista();
								set("formulario.datosLista", datosLista);
								set("formulario.conectorAction", "LPRevisionInconsistenciaChequeo");
								set("formulario.accion", "guardarDetalle");
								enviaSICC("formulario");							
						}
						
						//return;
					}
				}//fin 	
		}
        
        posicion = posicion + 1; 
  }
}


function onClickAceptarError() {
	var cant = datosListaTemp.length;
    alert('onClickAceptarError '+ cant);
	while(posicion < cant) {
				   //undidades solicitadas 	********** Unidades chequeadas
		if(validar(datosListaTemp[posicion-1][3], get("formulario.txtUnidEnCaja")) == 0 ){ 
			//actualiza la lista 
			datosListaTemp[posicion-1][13] = get("formulario.txtUnidEnCaja");
			datosListaTemp[posicion-1][9] = get("formulario.Observaciones"); 

			//Setea nuevos datos a mostrar 
			txt_to('DescripcionProducto', datosListaTemp[posicion][2]);
			txt_to('UnidSolicitadas', datosListaTemp[posicion][3]);
			set("formulario.txtUnidEnCaja", datosListaTemp[posicion][4]);  
			set("formulario.Observaciones", datosListaTemp[posicion][9]);  
		}
		else {
			if(validar(datosListaTemp[posicion-1][3], get("formulario.txtUnidEnCaja")) == 1 ){ 				
							//Unidades Solicitadas	          ****unidades chequeadas 
        var unidades = Number(datosListaTemp[posicion-1][3]) - Number(get("formulario.txtUnidEnCaja"));
				GestionarMensaje('APE052', unidades);
				return;
			}

			if(validar(datosListaTemp[posicion-1][3], get("formulario.txtUnidEnCaja")) == 2 ){ 
					//Unidades chequeadas  *********************  unidades   solicitadas 
        var unidades = Number(get("formulario.txtUnidEnCaja") - Number(datosListaTemp[posicion-1][3]));
				GestionarMensaje('APE053', unidades);
				return;
			}
		}
		posicion = posicion + 1;
	}

	//Validacion para el caso en que haya un solo registro
	//y para el ultimo registro cuando entra al while	
	if(validar(datosListaTemp[posicion-1][3], get("formulario.txtUnidEnCaja")) == 1 ){ 			
    var unidades = Number(datosListaTemp[posicion-1][3]) - Number(get("formulario.txtUnidEnCaja"));
		GestionarMensaje('APE052', unidades);
		return;
	}

	if(validar(datosListaTemp[posicion-1][3], get("formulario.txtUnidEnCaja")) == 2 ){ 
    var unidades = Number(get("formulario.txtUnidEnCaja") - Number(datosListaTemp[posicion-1][3]));
		GestionarMensaje('APE053', unidades);
		return;
	}

	//actualiza la lista 
	datosListaTemp[posicion-1][13] = get("formulario.txtUnidEnCaja");
	datosListaTemp[posicion-1][9] = get("formulario.Observaciones"); 

	eval("formulario").oculto= "S";
	var datosLista = obtenerDatosLista();
	set("formulario.datosLista", datosLista);
	set("formulario.conectorAction", "LPRevisionInconsistenciaChequeo");
	set("formulario.accion", "guardarDetalle");
	enviaSICC("formulario");
}

function fGuardarOK() {
	eval("formulario").oculto= "N";
 
    var retorno = new Array();
	retorno[0] = "OK";
	   
	returnValue = retorno;
	close();

}

function fGuardarERR() {
	eval("formulario").oculto= "N";

	var retorno = new Array();
	retorno[0] = "OK";
	   
	returnValue = retorno;
	close();
}	

function obtenerDatosLista() {
	var datosLista = "";
	var cant = datosListaTemp.length;
	for(var i=0; i<cant;i++) {
		var datoFila = "";
		var filas = datosListaTemp[i];
		var cantFilas = filas.length;
		for(var j=0; j<cantFilas; j++) {
			var dato = filas[j];
			if(dato=="") {
				dato = " ";
			}
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

function validar(unidadesSolicitadas, unidadesChequeadas) {
	if(unidadesSolicitadas==unidadesChequeadas) {
		return 0;
	}
	else {
		if(unidadesSolicitadas>unidadesChequeadas) {
			return 1;
		}
		else {
			return 2;
		}
	}
}

function onTABUnidadesCaja() {
	focaliza("formulario.Observaciones");
}

function onSHTABUnidadesCaja() {
	focalizaBotonHTML('botonContenido','btnAceptar');
}

function onTABObservaciones() {
	focalizaBotonHTML('botonContenido','btnAceptar');
}

function onSHTABObservaciones() {
	focaliza("formulario.txtUnidEnCaja");
}

function onTABBotonAceptar() {
	focaliza("formulario.txtUnidEnCaja");
}

function onSHTABBotonAceptar() {
	focaliza("formulario.Observaciones");
}
