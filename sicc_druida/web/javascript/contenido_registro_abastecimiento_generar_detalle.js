var FORMULARIO = 'formulario';

function onLoadPag() {
	
	
	var errDescripcion = get(FORMULARIO +'.errDescripcion');
   if (errDescripcion !='') {              
      var errCodigo = get(FORMULARIO+'.errCodigo');
      var wnd = fMostrarMensajeError(errCodigo, errDescripcion);
   }
                  
	DrdEnsanchaConMargenDcho('datosDeDetalle',12);
	eval (ON_RSZ);
	
	configurarMenuSecundario(FORMULARIO);
    
    
	// posicionamos el foco en el primer elemento habilitado de la pagina
	// Si hay datos en la lista el foco tiene que estar el la primera caja de texto
	// si no en el boton anadir
	if(datosDeDetalle.datos.length > 0) {
 		var nombrelistado= "datosDeDetalle";
   		var nombreCajaText= "Unidades";
   		datosDeDetalle.actualizaDat();
   		var datosLista = datosDeDetalle.datos; 
	   	eval(nombrelistado+".preparaCamposDR()");
	   	focaliza('frm'+nombrelistado+'.'+nombreCajaText+'_'+0,'');

   	} else { // ponemos foco en boton anadir
   		document.all['btnAnadir'].focus();
	}
}
  

function accionAnadir() {
	
	// Abrir ventana modal con un "windowOpen()" y mostrar la pantalla "PaginaGenerarRegistroAbastecimientoDetalle2" 
	// y mapear el valor de "oidSubacceso" en el campo oculto "oidSubacceso" de la pantalla
	// este mapeo lo hago en LPGenerarRegistroAbastecimiento
	var objParams = new Object();
	objParams.oidSubacceso = get(FORMULARIO + '.oidSubacceso');
	objParams.oidAlmacen = get(FORMULARIO + '.oidAlmacen');
  // vbongiov - inc 21741
  objParams.oidMarca = get(FORMULARIO + '.oidMarca');
	// Recuperar arreglo de datos de la pantalla modal 
	//var valorRecuperado = mostrarModalSICC('LPGenerarRegistroAbastecimiento', 'mostrarVentanaSeleccionProducto', objParams, null, null);	
	var arrayResultado = mostrarModalSICC('LPGenerarRegistroAbastecimiento', 'mostrarVentanaSeleccionProducto', objParams, null, null);	
	
	if(arrayResultado != null){
		// hay que comprobar si el producto ya está en la lista
		datosDeDetalle.actualizaDat();
		var datosEnLista = datosDeDetalle.datos;
		
		var productoYaExiste = false;
		
		for (i=0; i < datosEnLista.length; i++) {
			if (datosEnLista[i][1] == arrayResultado[1]) {
				productoYaExiste = true;
				break;
			}
		}
		
		if (typeof(arrayResultado) != 'undefined') {
			if (productoYaExiste == true) {
				// Mostrar mensaje con código de error "UIBEL0011" 
				GestionarMensaje('UIBEL0011');
			} else {
				// Añadir fila a la lista editable "datosDeDetalle" con los datos recuperados
				var arrayFormateada = adaptarArrayFormatoUsuario(arrayResultado);
				//datosDeDetalle.insertar(arrayResultado);
				datosDeDetalle.insertar(arrayFormateada);
				datosDeDetalle.reajusta();
			}
		}
	}
	
	// posicionamos el foco
	datosDeDetalle.actualizaDat();
	if(datosDeDetalle.datos.length > 0) {
 		var nombrelistado= "datosDeDetalle";
   		var nombreCajaText= "Unidades";
   		datosDeDetalle.actualizaDat();
   		var datosLista = datosDeDetalle.datos; 
	   	eval(nombrelistado+".preparaCamposDR()");
	   	document.body.focus();
	   	focaliza('frm'+nombrelistado+'.'+nombreCajaText+'_0','');
   	}else { // ponemos foco en boton anadir
   		document.all['btnAnadir'].focus();
	}
}


function adaptarArrayFormatoUsuario(arrayResultado) {
	
	var separadorMiles = get(FORMULARIO + '.hid_SeparadorMiles');

	// stock actual
	arrayResultado[3] = ponerSeparadorMiles(arrayResultado[3], separadorMiles);
	// Stock mínimo
	arrayResultado[4] = ponerSeparadorMiles(arrayResultado[4], separadorMiles);
	// Stock máximo
	arrayResultado[5] = ponerSeparadorMiles(arrayResultado[5], separadorMiles);
	// unidades reposición
	arrayResultado[6] = ponerSeparadorMiles(arrayResultado[6], separadorMiles);
	
	return arrayResultado;
}

// recibe una cantidad como cadena de texto y la devuelve despues de introducir en ella
// los separadores de miles
function ponerSeparadorMiles(cantidad, separadorMiles) {
	
	if (cantidad.indexOf(separadorMiles) == -1) {
		var cantidadFormateadaInversa = '';
    	
		contador=0;
		for (i=cantidad.length -1; i >= 0; i--) {
			contador++;
			cantidadFormateadaInversa += cantidad.charAt(i);
			if ((contador % 3) == 0 && i > 0) {
				cantidadFormateadaInversa += separadorMiles;
			}
		}
		
		var cantidadFormateada = '';
		for (i=0; i < cantidadFormateadaInversa.length; i++) {
			cantidadFormateada += cantidadFormateadaInversa.charAt(cantidadFormateadaInversa.length - i -1);
		}
		
		return cantidadFormateada;
	}
	return cantidad;
}


// recibe una cantidad como cadena de texto y la devuelve despues de quitar
// los separadores de miles, si aparecen
function quitarSeparadorMiles(cantidad, separadorMiles) {
	
	var resultado = '';

	for (i=0; i < cantidad.length; i++) {
		car = cantidad.charAt(i)
		if (car != separadorMiles) {
			resultado += car;
		}
	}
	
	return resultado;
}	


function accionEliminar (){//1
	
	//Eliminar las líneas seleccionadas en la lista editable "datosDeDetalle"
	if (datosDeDetalle.numSelecc() > 0 ) {//2
	
		datosDeDetalle.eliminarSelecc();
             	//Modificamos posicionDetalle
             	datosDeDetalle.actualizaDat(); 
                  var datosFinal = datosDeDetalle.datos;
                  if (datosFinal.length == 0) btnProxy(4, 0);
                  /*for (i = 0; i < datosFinal.length; i++) {//3
                           var posicionDetalle = i + 1;
                           datosFinal[i][0]= posicionDetalle;
                           datosFinal[i][2]= posicionDetalle;
                  }//3
                  var datos = new Array();
                           datosDeDetalle.setDatos(datos);
                           datosDeDetalle.reajusta();
                           datosDeDetalle.actualizaDat();
                           for(j = 0; j < datosFinal.length; j++){//4
                                    var fila = datosFinal[j];
                                    datosDeDetalle.insertar(fila);
                           }//4
                           
                  //datosDeDetalle.setDatos(datosFinal);*/
                  datosDeDetalle.reajusta();
	//2
	}else{//5
		GestionarMensaje('50');
	}//5
		
}//1

// poner lo siguiente en la columna con la caja de texto
// <!--onBlur="datosDeDetalleOnChange(FILAEVENTO);"-->
function datosDeDetalleOnChange(FILAEVENTO) {
	
	/** PaginaGenerarRegistroAbastecimientoDetalle.datosDeDetalleOnChange() */ 
	// Este método se ejecuta cuando se modifica el campo "unidadesReposicion" de la lista editable
	
	//////////////////////////////////////////////////////////
	// hay que validar que el numero introducido es correcto
	datosDeDetalle.actualizaDat();
	var unidadesReposicion = datosDeDetalle.datos[FILAEVENTO][6];
	
	var separaMiles = get(FORMULARIO + '.hid_SeparadorMiles');
	var sepaDecimal	= get(FORMULARIO + '.hid_SeparadorDecimales');
	var nombrelistado = "datosDeDetalle";
	var nombreCajaText= "Unidades";
		if(unidadesReposicion != ""){
			// la caja de texto tiene como maximo 10 caracteres
			// estamos tratando con cantidades enteras, por lo que no tenemos decimales
			//var resultado = validarCantidad(unidadesReposicion, 10, separaMiles);
			var minimo = new Number(0);
			var enteros = new Number(10);
			var decimales = new Number(0);
			var resultado = ValidaMilesDecimalesOriginal(unidadesReposicion, enteros, decimales, separaMiles, null, null);
			
			if (resultado != 'OK') {
				if(resultado == 0){
				// mostramos el mensaje
					GestionarMensaje('1465');
				}else{
					cdos_mostrarAlert(resultado);
				}
				// ponemos el foco en la caja de texto
			   	//eval(nombrelistado+".preparaCamposDR()");
			   	focaliza('frmdatosDeDetalle.Unidades_'+FILAEVENTO,'');
			   
				// salimos de la funcion
				return;
			}
			
			// debemos trabajar con las cantidades de stock maximo y unidades reposicion
			// quitamos los separadores de miles si aparecen
			
			var stockMaximo = quitarSeparadorMiles(datosDeDetalle.datos[FILAEVENTO][5], separaMiles);
			var unidReposSinSeparadores = quitarSeparadorMiles(datosDeDetalle.datos[FILAEVENTO][6], separaMiles);
			
			// corrección indicada por DT en incidencia de pruebas BELC300016421
			// antes se comprobaba si el stockMaximo >= 0
			if(stockMaximo > 0) {
				
				//Si (datosDeDetalle.unidadesReposicion > datosDeDetalle.stockMaximo) entonces
				if(new Number(unidReposSinSeparadores) > new Number(stockMaximo)){
					//Mostrar mensaje con código de mensaje "UIBEL0010"
					//Se corregirán Unidades de Reposición al ser mayor que Stock Máximo
					GestionarMensaje('UIBEL0010');
					//datosDeDetalle.unidadesReposicion = datosDeDetalle.stockMaximo
					datosDeDetalle.datos[FILAEVENTO][6] = datosDeDetalle.datos[FILAEVENTO][5];
					datosDeDetalle.repinta();
					//Para actualizar la lista
					datosDeDetalle.actualizaDat();
					datosDeDetalle.reajusta();
					focaliza('frm'+nombrelistado+'.'+nombreCajaText+'_'+ FILAEVENTO,'');
				}
			}
		}
}

function fGuardar() {
	
	// Este método se ejecuta cuando se pulsa el botón "guardar" del menú secundario 
	// Proceso: 
	//-> Llamar a la lp "LPGenerarRegistroAbastecimiento" con acción "guardar"
	
	//recuperar listados
	//separamos los campos de cada fila con el caracter @
	//separamos las filas con el caracter #
	//los campos vacíos se ponen a '-' para que con Stringtokenizer no se pierda la secuencia de columnas
	var detallesEnLista = "";
	datosDeDetalle.actualizaDat(); //Actualiza el array 'datos'
	var datosFinal = datosDeDetalle.datos;
	
	if(datosFinal.length != 0){
	
	
		for (i = 0; i < datosFinal.length; i++) {
    	    
			var fila = datosFinal[i];
			var cadenaAgnadir;
			
			for (j = 0; j < fila.length; j++) {
				
				// si se recoge de la lista una columna vacia hay que meter algun valor para que 
				// en la LP se pueda utilizar correctamente el StringTokenizer. Añado un -
				if (fila[j] == '') { 
					cadenaAgnadir = "-";
				} else {
					cadenaAgnadir = fila[j];	
				}
				detallesEnLista += cadenaAgnadir;
    	
				// se añade la separacion entre columnas
				if (j < fila.length - 1) {
					detallesEnLista += "@";
				}
			}
    	  
    	  // se añade la separacion entre filas
    	  if (i < datosFinal.length - 1) {
				detallesEnLista += "#"
			}
    	  
		}
		
		set(FORMULARIO + '.detallesEnLista', detallesEnLista);
		set(FORMULARIO + '.accion', 'guardar');
		set(FORMULARIO + '.conectorAction', 'LPGenerarRegistroAbastecimiento');
		enviaSICC(FORMULARIO);
	}else{
		//Debe añadir al menos un detalle a la hoja de demanda. 
		GestionarMensaje('1470');
	}
}

function focalizaSig(FILAEVENTO,TECLAEVENTO) {
	var nombrelistado = "datosDeDetalle";
	datosDeDetalle.actualizaDat();
  	var unidadesReposicion = datosDeDetalle.datos[FILAEVENTO][6];
	
	var separaMiles = get(FORMULARIO + '.hid_SeparadorMiles');
	var sepaDecimal	= get(FORMULARIO + '.hid_SeparadorDecimales');
   	var minimo = new Number(0);
   	var enteros = new Number(10);
   	var decimales = new Number(0);
   	var resultado = ValidaMilesDecimalesOriginal(unidadesReposicion, enteros, decimales, separaMiles, minimo, null);
   	if(resultado == 'OK'){
		if (FILAEVENTO == datosDeDetalle.datos.length-1 && TECLAEVENTO == 9) {
      		document.body.focus(); //pa que focalice en la pagina
      		setTimeout("document.all['btnAnadir'].focus();",5)
   		}
   	}
}

function focalizaAnt(FILAEVENTO,TECLAEVENTO) {
   	var nombrelistado = "datosDeDetalle";
   	datosDeDetalle.actualizaDat();
  	var unidadesReposicion = datosDeDetalle.datos[FILAEVENTO][6];
	
	var separaMiles = get(FORMULARIO + '.hid_SeparadorMiles');
	var sepaDecimal	= get(FORMULARIO + '.hid_SeparadorDecimales');
   	var minimo = new Number(0);
   	var enteros = new Number(10);
   	var decimales = new Number(0);
   	var resultado = ValidaMilesDecimalesOriginal(unidadesReposicion, enteros, decimales, separaMiles, minimo, null);
   	if(resultado == 'OK'){
   		if(FILAEVENTO == 0 && TECLAEVENTO == 9) {
      		document.body.focus();
      		setTimeout("document.all['btnEliminar'].focus();",5); 
   		}
   	}
}

function onShTabAnadir() {
	
	//Si hay datos en la lista el foco tiene que estar el la primera caja de texto
	var tamanoLista = datosDeDetalle.datos.length;
	if(tamanoLista > 0){ 
 		var nombrelistado= "datosDeDetalle";
   		var nombreCajaText= "Unidades";
   		datosDeDetalle.actualizaDat();
   		
	   	eval(nombrelistado+".preparaCamposDR()");
	   	focaliza('frm'+nombrelistado+'.'+nombreCajaText+'_'+(tamanoLista - 1),'');
	} else {
		document.all['btnEliminar'].focus();
	}
}

function onTabEliminar() {

	// Si hay datos en la lista el foco tiene que estar el la primera caja de texto
	// Y si no focalizamos el boton
	if(datosDeDetalle.datos.length > 0) {
    		
 		var nombrelistado= "datosDeDetalle";
   		var nombreCajaText= "Unidades";
	   	focaliza('frm'+nombrelistado+'.'+nombreCajaText+'_'+0,'');
	} else { 
		document.all['btnAnadir'].focus();
	}
}

function ValidaMilesDecimalesOriginal(valor, enteros, decimales, separadorMiles, min, max) {
		var ok= 'OK';
		var valoresPrimario = null;
		if (ValidaCaracteres(valor,'0123456789' + separadorMiles)!='OK') {return DrdMsgCore(143) + separadorMiles + '0123456789';}
		
		//empieza por separadormiles
		if (valor.indexOf(separadorMiles) == 0) {return DrdMsgCore(101);}

		//termina por separadormiles
		if (valor.indexOf(separadorMiles) == valor.length-1) {return DrdMsgCore(101);}
		
		var valorSeparador = valor.split(separadorMiles);
		var separador = false;
		for(i=1; i<valorSeparador.length; i++){
			separador = true;
			if(valorSeparador[i].length != 3){
				return 0;	
			}
		}
		if((valorSeparador[0].length > 3)&&(separador)){
			return 0;
		}
	
		return ok;
	}
	
function Correcto(){
	
	formulario.oculto = 'N';
	set(FORMULARIO + '.accion', '');
	set(FORMULARIO + '.conectorAction', 'LPGenerarRegistroAbastecimiento');
	enviaSICC(FORMULARIO);
}
