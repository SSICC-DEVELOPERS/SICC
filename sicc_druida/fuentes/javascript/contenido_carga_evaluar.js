function fVolver() {
	window.close();
}

function muestraLista1() {
	DrdEnsanchaConMargenDcho('listado1',12);   
	document.all["Cplistado1"].style.visibility='';
    document.all["CpLin1listado1"].style.visibility='';
    document.all["CpLin2listado1"].style.visibility='';
    document.all["CpLin3listado1"].style.visibility='';
    document.all["CpLin4listado1"].style.visibility='';
    eval (ON_RSZ);  
}

function onLoadPag() {  
	fMostrarMensajeError();
	configurarMenuSecundario("formulario");
	muestraLista1();
	//Cargar el combo cbSublínea
	if(get("formulario.lstSublineas")!="") {
		set_combo("formulario.cbSublinea", parseaCombo(get("formulario.lstSublineas")));
	}

	focaliza("formulario.cbSublinea");
}

function parseaCombo(str){	
	var arr = new Array();	
	var arrVacio = new Array();
	arrVacio[0] = "";
	arrVacio[1] = "";
	arr[0] = arrVacio;
    var filas = str.split('|');
	for(var i=0; i<filas.length; i++) {
		var campos = filas[i];
		var campo = campos.split("$");
		arrIn = new Array();
        arrIn[0] = campo[0];
        arrIn[1] = campo[1];                        
        arr[i+1] = arrIn;      		
	}
    return arr;
}  
function onChangeSublinea() {
	if(get("formulario.cbSublinea")!="") {
		//primero se vacia la lista
		var arrVacio = new Array();
		listado1.actualizaDat();
		listado1.setDatos(arrVacio);
		listado1.repintaDat();

		var oidSublinea = get("formulario.cbSublinea");
		var lstCargaSublineas = get("formulario.lstCargaSublineas");
     	var filas = lstCargaSublineas.split('|');

		//se recorren las filas
		for(var i=0; i<filas.length; i++) {
			var campos = filas[i];
			var campo = campos.split("$");			
			var zonas = campo[4];

			//Si el valor del combo es igual al oid de sublinea
			//de la fila
			if(oidSublinea == campo[0]) {
				//Se asignan valores a los labels
				var unidadesPromedio = obtieneNumeroDecimal(campo[3], get("formulario.hid_SeparadorDecimales"));
				var errorPromedio = obtieneNumeroDecimal(campo[2], get("formulario.hid_SeparadorDecimales"));

				txt_to('unidadesPromedio', unidadesPromedio);
				txt_to('errorPromedio', errorPromedio);	

				//se insertar registros a la lista
				if(zonas!="null") {
					var filasZonas = zonas.split("+");
					for(var j=0; j<filasZonas.length; j++) {
						var camposZonas = filasZonas[j];
						var campoZona = camposZonas.split("?");

						var idZona = campoZona[0];
						var unidadesAsignadas = obtieneNumeroDecimal(campoZona[1], get("formulario.hid_SeparadorDecimales"));
						var porcentaje = obtieneNumeroDecimal(campoZona[2], get("formulario.hid_SeparadorDecimales"));

						var array = new Array();
						array[0] = new String(idZona);
						array[1] = new String(idZona);
						array[2] = new String(unidadesAsignadas);
						array[3] = new String(porcentaje);

						listado1.actualizaDat();
						var datos = listado1.datos;
						datos[datos.length] = array; 
						listado1.setDatos(datos);
						listado1.repintaDat();
					}
				}
			}
		}
	}
	else { // si no selecciono ningun valor en el combo de sublinea			
		// se limpian los labels
		txt_to('unidadesPromedio', ""); 
		txt_to('errorPromedio', "");	
		// y se vacia la lista
		var arrVacio = new Array();
		listado1.actualizaDat();
		listado1.setDatos(arrVacio);
		listado1.repintaDat();
	}
}

function onSHTABcomboSublinea() {
	focaliza("formulario.cbSublinea");
}

function onTABcomboSublinea() {
	focaliza("formulario.cbSublinea");
}