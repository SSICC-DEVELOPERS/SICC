var FORMULARIO = 'formulario';

function onLoadPag() {
	
	var errDescripcion = get(FORMULARIO + '.errDescripcion');
	if(errDescripcion != '') {
		var errCodigo = get(FORMULARIO +'.errCodigo');
		var wnd = fMostrarMensajeError(errCodigo, errDescripcion);
	}
	
	configurarMenuSecundario(FORMULARIO);
	
	DrdEnsanchaConMargenDcho('listado1',12);
  	eval (ON_RSZ);
    
	// Lo siguiente aparece en metodo cargarPagina() de la LPGenerarRegistroAbastecimiento, que se ejecuta cuando
	// la accion = "". Yo lo ejecuto aqui
	// El array "agrupacionPorDefecto" y el combo "agrupacionStock" son paralelos, 
	// y se seleccionará en el combo el valor cuyo valor paralelo en el array "agrupacionPorDefecto" valga "1" 
	// que es igual a "true"
	
	var indice;
	var longitud = agrupacionPorDefecto.length;

	for (var i = 0; i < longitud; i++) {
		if (agrupacionPorDefecto[i] == 1) {
			indice = i;
			break;
		}
	}
	
	// seleccionar el elemento del combo "cbAgrupacionStock" en la posicion "indice"
	// ponemos el valor en un hidden para cargarlo despues
	set(FORMULARIO + '.indiceHidden', indice); 
	
	focaliza(FORMULARIO + '.cbRegistroAbastecimiento'); //Pasamos el foco al combo al cargar la pagina
}

function accionAceptar() {
	
	var accion = get(FORMULARIO + '.cbRegistroAbastecimiento');
	
	if (accion == 1) { // crear un nuevo registro
	
		// Mostrar la capa que contiene los campos "marca" y "agrupacionDeStock" y el botón "rellenar" 
		// si esta visible la capa3 la hago oculta
		if (get_visibilidad('capa3') == true) {
			visibilidad('capa3', 'O');
		}
		// si la capa2 ya era visible no se realiza ninguna accion respecto a su estado
		if (get_visibilidad('capa2') == false) {
			visibilidad('capa2', 'V');
		}
		
		var oidMarca = get(FORMULARIO +'.marca');
		set(FORMULARIO +'.cbMarca',[oidMarca]);
		
		var indice;
		var longitud = agrupacionPorDefecto.length;

		for (var i = 0; i < longitud; i++) {
			if (agrupacionPorDefecto[i] == 1) {
				indice = i;
				break;
				}
		}

		if(typeof(indice) != 'undefined') {
			
			//document.all['cbAgrupacionStock'][0].selectedIndex = indice; Dijo gracia que esto tb funciona
			var combo = document.getElementById("cbAgrupacionStock");
			
			//alert(document.forms[FORMULARIO].cbAgrupacionStock.options); // no existe
			//document.forms[FORMULARIO].cbAgrupacionStock.options.selectedIndex = 1;
			//document.forms[FORMULARIO].cbAgrupacionStock.options.selectedIndex = parseInt(indice);
			set(FORMULARIO + '.cbAgrupacionStock', [combo.options[indice + 1].value]);
			//alert("combo5");
			//set(FORMULARIO + '.cbAgrupacionStock', [parseInt(indice)]);
		}
	} else if (accion == 2) { // recuperar un registro existente
		// Ejecutar "accionPaginacion()" con página 1
		accionPaginacion();
		
		// Mostrar la capa que contiene los campos "listaRecuperacion" y el botón "cargar" 
		// si la capa2 esta visible la oculto
		if (get_visibilidad('capa2') == true) {
			visibilidad('capa2', 'O');
		}
		// si la capa3 ya era visible no se realiza ninguna accion respecto a su estado
		if (get_visibilidad('capa3') == false) {
			visibilidad('capa3', 'V');
			document.all['btnCargar'].focus();
		}		
		
	}
}

function accionRellenar() {
	if (sicc_validaciones_generales()){
		// Llamar a la lp "LPGenerarRegistroAbastecimiento" con acción = "rellenarRegistroAbastecimiento"	
		set(FORMULARIO + '.accion', 'rellenarRegistroAbastecimiento');
		set(FORMULARIO + '.conectorAction', 'LPGenerarRegistroAbastecimiento');
	
		enviaSICC(FORMULARIO);
	}
}

function accionCargar() {
	if (listado1.numSelecc() == 0) {
                  // Muestra el mensaje: "Debe seleccionar un elemento de la lista"
                  GestionarMensaje('50');
         } else {
                  if (listado1.numSelecc() != 1 ) {
                           //Muesta el mensaje: "Debe seleccionar un solo registro"
                           GestionarMensaje('8');
                  } else {

		
						// Llamar a la lp "LPGenerarRegistroAbastecimiento" con acción = "cargarRegistroAbastecimiento"
						set(FORMULARIO + '.accion', 'cargarRegistroAbastecimiento');
						set(FORMULARIO + '.conectorAction', 'LPGenerarRegistroAbastecimiento');
						set(FORMULARIO + '.listaRecuperacion', listado1.codSeleccionados());
						var listaRecuperacion = listado1.codSeleccionados();
						enviaSICC(FORMULARIO, null, null, 'N');    
				}
		}
}

function accionPaginacion() {
	
	// configurarPaginado(listaRecuperacion, "BELRecuperarRegistroAbastecimiento", 
	// "ConectorRecuperarRegistroAbastecimiento", "DTOERecuperarRegistroAbastecimiento", 
	// [ ["pais", get(pais de sesion)], ["idioma", get(idioma de sesión)], 
	// [ ["subacceso", get(oidSubacceso)], ["estado", get(oidEstadoCreado)] );
	var pais = get(FORMULARIO + '.pais');
	var idioma = get(FORMULARIO + '.idioma');
	var subacceso = get(FORMULARIO + '.oidSubacceso');
	var estado = get(FORMULARIO + '.oidEstadoCreado');
	configurarPaginado(mipgndo, 
		"BELRecuperarRegistroAbastecimiento",
		"ConectorRecuperarRegistroAbastecimiento",
		"es.indra.sicc.dtos.bel.DTOERecuperarRegistroAbastecimiento",
		[	["oidPais", pais], 
			["oidIdioma", idioma], 
			["subacceso", subacceso], 
			["estado", estado]
		]);
		
}

function fLimpiar() {
	// poner en el combo cbRegistroAbastecimiento el valor por defecto "Crear registro de abastecimiento"
	set(FORMULARIO + '.cbRegistroAbastecimiento', ['']);
	
	if (get_visibilidad('capa2') == true) {
			visibilidad('capa2', 'O');
	}
	set(FORMULARIO + '.indiceHidden',get(FORMULARIO+'.cbAgrupacionStock'));
	/*
	if (get_visibilidad('capa2') == true) {
		// se pone en el combo marca el valor por defecto para el usuario
		set(FORMULARIO + '.cbMarca', [get(FORMULARIO + '.marca')]);

		// se vacia el combo cbAgrupacionStock
		var indice = get(FORMULARIO + '.indiceHidden');
		set(FORMULARIO+'.cbAgrupacionStock', [indice]);
	}*/
}

function focalizaSiguiente(elemento) {
	switch(elemento) {
	
		case "cbRegistroAbastecimiento": 
			document.all['btnAceptar'].focus();	
			break;
		case "btnAceptar": 
			if (get_visibilidad('capa2') == true){
				focaliza(FORMULARIO + '.cbMarca');
			} else {
				if (get_visibilidad('capa3') == true) {
					document.all['btnCargar'].focus();
				} else {
					focaliza(FORMULARIO + '.cbRegistroAbastecimiento');
				}
			}
			break;
		case "cbMarca":
			focaliza(FORMULARIO + '.cbAgrupacionStock'); 
			break;
		case "cbAgrupacionStock":
			document.all['btnRellenar'].focus(); 
			break;
		case "btnRellenar":
			focaliza(FORMULARIO + '.cbRegistroAbastecimiento'); 
			break;
		case "btnCargar":
			focaliza(FORMULARIO + '.cbRegistroAbastecimiento'); 
			break;
		default: 
			break;
	}
}

function focalizaAnterior(elemento) {
		
	switch(elemento){
	
		case "cbRegistroAbastecimiento": 
			if(get_visibilidad('capa2') == true) {
				document.all['btnRellenar'].focus();
			} else {
				if(get_visibilidad('capa3') == true) {
					document.all['btnCargar'].focus();
				} else {
					document.all['btnAceptar'].focus();
				}
			}
			break;
			
		case "btnAceptar": 
			focaliza(FORMULARIO + '.cbRegistroAbastecimiento'); 
			break;
		case "cbMarca":
			document.all['btnAceptar'].focus(); 
			break;
		case "cbAgrupacionStock":
			focaliza(FORMULARIO + '.cbMarca');  
			break;
		case "btnRellenar":
			focaliza(FORMULARIO + '.cbAgrupacionStock'); 
			break;
		case "btnCargar":
			document.all['btnAceptar'].focus(); 
			break;
		default: 
			break;
	}
}

function muestraLista(ultima, rowset) {
          var tamano = rowset.length;
          if (tamano > 0) {
                    return true;
          } else {
                    return false;
          }
}
