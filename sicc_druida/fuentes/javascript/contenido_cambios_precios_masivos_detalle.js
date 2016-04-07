var FORMULARIO = 'frmFormulario';

// Columnas de las listas
var OIDPOSICIONSOLICITUD = 0;

// BELC300014886
function onLoadPag() {
	
	var errDescripcion = get(FORMULARIO + '.errDescripcion');
	if(errDescripcion != '') {
		var errCodigo = get(FORMULARIO +'.errCodigo');
		var wnd = fMostrarMensajeError(errCodigo, errDescripcion);
	}
	
   DrdEnsanchaConMargenDcho('listado1', 12);
    
	/*document.all["Cplistado1"].style.visibility='';
	document.all["CpLin1listado1"].style.visibility='';
	document.all["CpLin2listado1"].style.visibility='';
	document.all["CpLin3listado1"].style.visibility='';
	document.all["CpLin4listado1"].style.visibility='';
	
	document.all["primera1Div"].style.visibility='';
	document.all["ret1Div"].style.visibility='';
	document.all["ava1Div"].style.visibility='';
	document.all["separaDiv"].style.visibility='';
	document.all["GenerarReclamosDiv"].style.visibility='';
	document.all["AnadirDiv"].style.visibility='';
	document.all["ModificarDiv"].style.visibility='hidden';
	document.all["AnularDiv"].style.visibility='hidden';*/

	DrdEnsanchaConMargenDcho('listado2', 12);

	/*document.all["Cplistado2"].style.visibility='';
	document.all["CpLin1listado2"].style.visibility='';
	document.all["CpLin2listado2"].style.visibility='';
	document.all["CpLin3listado2"].style.visibility='';
	document.all["CpLin4listado2"].style.visibility='';
	
	document.all["primera2Div"].style.visibility='hidden';
	document.all["ret2Div"].style.visibility='hidden';
	document.all["ava2Div"].style.visibility='hidden';
	document.all["separa2Div"].style.visibility='hidden';
	document.all["EliminarDiv"].style.visibility='';*/
	eval (ON_RSZ);  	
	
	
	if(get(FORMULARIO+'.modificar') == "true"){
		
		document.all["AnularDiv"].style.visibility='visible';
		if(get(FORMULARIO+'.consultar') == "true"){
			document.all["Anadir"].style.visibility='hidden';
			document.all["Excluir"].style.visibility='hidden';
			document.all["Anular"].style.visibility='hidden';
			document.all["GenerarReclamos"].style.visibility='hidden';
			document.all["Eliminar"].style.visibility='hidden';
		}
		/*Llamamos a configurarPaginado pasándole los siguientes parametros: 
		- Objeto paginado (lstResultados) 
		- idBusiness ("RECRecuperarDetalleGeneracion") 
		- "ConectorRecuperarDetalleGeneracion" 
		- "DTOCargaListas" 
		- Parametros del DTOCargaListas: (además del pais y el idioma) 
		- oidCabecera = oidCabecera 
		- indicador = 1 */
		var oidCabecera = get(FORMULARIO+'.oidCabecera');
		
		// BELC300020340: se carga la lista de detalles con todos los detalles independientemente 
		// de su indicador de seleccion. Ya no se informa el atributo indicador de DTOCargaListas

		// BELC300024293 - va indicador en 1.
		var indicador = 1;
		configurarPaginado(mipgndo, 
					         "RECRecuperarDetalleGeneracion",
					         "ConectorRecuperarDetalleGeneracion",
					         "es.indra.sicc.dtos.rec.DTOCargaListas",
					         [["oidCabecera", oidCabecera], ["indicador", indicador]]);
		
		//eliminada porque en el diseño no viene y por inc 22297
		//set(FORMULARIO + '.guardado', false);

	}else{		
	
		// Llamamos a configurarPaginado pasándole los siguientes parametros: 
		// - Objeto paginado (lstResultados) 
		// - idBusiness ("RECObtenerDetalleGeneracion") 
		// - "ConectorObtenerDetalleGeneracion" 
		// - "DTODetallePreRec" 
		// - Parametros del DTODetallePreRec: (además del pais y el idioma) 
		// - oidPeriodo = oidPeriodo 
		// - oidSubAcceso = oidSubAcceso 
		// - stringSolicitudes = Concatenamos en un String los oids contenidos en la variable arrayTipoSolicitud, 
		// separandolos con una ','
		// Antes se utilizaba '#' pero daba problemas al hacer un configurarPaginado 
		// - oidPrecioEnvia = oidPrecioEnvia
		
		var valorPrecioCatalogoDestino;
		if (typeof(get(FORMULARIO + '.precioCatalogoDestino')) != 'undefined') {
			valorPrecioCatalogoDestino = get(FORMULARIO + '.precioCatalogoDestino');
		} else {
			valorPrecioCatalogoDestino = '';
		}
    	
		// BELC300014874: se añade el atributo preciocatalogoDestino
		// BELC300019830: se añaden los atributos: codigoVentaAnterior y detalleOfertaAnterior
		configurarPaginado(mipgndo, 
					         "RECObtenerDetalleGeneracion",
					         "ConectorObtenerDetalleGeneracion",
					         "es.indra.sicc.dtos.rec.DTODetallePreRec",
					         [	
					         	["oidPais", get(FORMULARIO + '.pais')], 
			                  ["oidIdioma", get(FORMULARIO + '.idioma')], 
			                  ["oidPeriodo", get(FORMULARIO + '.oidPeriodo')],
			                  ["oidSubAcceso", get(FORMULARIO + '.oidSubAcceso')],
			                  ["stringSolicitudes", get(FORMULARIO + '.arrayTipoSolicitud')],
			                  ["oidPrecioEnvia", get(FORMULARIO + '.oidPrecioEnvia')],
			                  ["preciocatalogoDestino", valorPrecioCatalogoDestino],
			                  ["codigoVentaAnterior", get(FORMULARIO + '.codVentaOrigen')],
			                  ["detalleOfertaAnterior", get(FORMULARIO + '.oidDetalleOfertaOrigen')]
					         ]);
		
		
		// Ponemos la variable boolean de la pantalla a false	
		set(FORMULARIO + '.guardado', false);
	}
	// si algún caso de uso quiere mostrar los botones Modificar o Anular, descomentar las siguientes lineas:
   // document.all["ModificarDiv"].style.visibility='visible';
   // document.all["AnularDiv"].style.visibility='visible';
	// tb se podría usar creo una funcion:  visibilidad(capa, ‘V’) 

	configurarMenuSecundario(FORMULARIO);	
	if(get(FORMULARIO+'.consultar') == "true"){
			btnProxy(1,0);
			btnProxy(5,0); 
	}
}

	
function muestraLista( ultima, rowset ){
		var tamano = rowset.length;
		
		if (tamano > 0) {			
			listado1.setDatos(rowset);
			//incidencia DBLG4000000548  BELC300021343 mamontie 18/11/05
			return true;
		}
	}


function seleccionarFilas() {
  var largo = listado1.datos.length;
  for(var i = 0; i < largo; i++){
    listado1.selecc[i] = 1;
  }
}


// por BELC300020340 si la opcion es modificar se pasa también la lista de detalle
function fGuardar() {
	
	
	
	// Este método se ejecuta cuando se pulsa el botón "guardar" del menú secundario 
	/*if (modificar) { //Estamos modificando un reclamo 

	Llama a la LPCambiosPreciosRec con un envio oculto y: 
	- accion= "guardar" 
	- oidCabecera 
	- lstNoGenerar 


	}else { 

	
	// Llama a la LPCambiosDePrecios con accion="guardar" y un envio oculto de los siguientes campos del formulario: 
	// - codVentaOrigen 
	// - descripcionOrigen 
	// - precioCatalogoOrigen 
	// - codVentaDestino 
	// - descripcionDestino 
	// - precioCatalogoDestino 
	// - lstNoGenerar 
	// - numGeneracion 
	// - oidAcceso 
	// - oidSubAcceso 
	// - oidPeriodo 
	// - oidTipoSOlicitud 
	// - oidDetalleOfertaOrigen 
	// - oidDetalleOfertaDestino 
	// - observaciones
	

   // metemos los registros de la lista de reclamos no generados en un campo de la pagina para que puedan
   // ser recuperados en la LPCambiosDePrecios
   // separamos los campos de cada fila con el caracter @
   // separamos las filas con el caracter #
   // los campos vacíos se ponen a '-' para que con Stringtokenizer no se pierda la secuencia de columnas
	}
   */
	var modificar  = get(FORMULARIO+'.modificar');
   
	if(modificar == "true"){
		
		var fila;
		var cadenaAgnadir;
		var registrosEnLista;
		var datosFinal;
		
		
		///////////////////////////////////////////////////////////////////// lista detalle
   	registrosEnLista = '';
		listado1.actualizaDat(); //Actualiza el array 'datos'
		datosFinal = listado1.datos;
		
		if(datosFinal.length != 0) {
			
			for (i = 0; i < datosFinal.length; i++) {
			    
				 fila = datosFinal[i];
			                  
			    for (j = 0; j < fila.length; j++) {
			               
			    	  // si se recoge de la lista una columna vacia hay que meter algun valor para que 
			        // en la LP se pueda utilizar correctamente el StringTokenizer. Añado un -
			        if (fila[j] == '') { 
					  		cadenaAgnadir = '-';
			        } else {
							cadenaAgnadir = fila[j];	
			        }
			        registrosEnLista += cadenaAgnadir;
			
			        // se añade la separacion entre columnas
			        if (j < fila.length - 1) {
						registrosEnLista += '@';
			        }
			    }
			  
				// se añade la separacion entre filas
				if (i < datosFinal.length - 1) {
					registrosEnLista += '#';
				}
			}
		}
		set(FORMULARIO + '.reclamosDetalle', registrosEnLista);
		
   	
   	///////////////////////////////////////////////////////////////////// lista no generar
   	registrosEnLista = '';
		listado2.actualizaDat(); //Actualiza el array 'datos'
		datosFinal = listado2.datos;
		
		if(datosFinal.length != 0) {
			
			for (i = 0; i < datosFinal.length; i++) {
			    
				 fila = datosFinal[i];
			                  
			    for (j = 0; j < fila.length; j++) {
			               
			    	// si se recoge de la lista una columna vacia hay que meter algun valor para que 
			        // en la LP se pueda utilizar correctamente el StringTokenizer. Añado un -
			        if (fila[j] == '') { 
						cadenaAgnadir = '-';
			        } else {
						cadenaAgnadir = fila[j];	
			        }
			        registrosEnLista += cadenaAgnadir;
			
			        // se añade la separacion entre columnas
			        if (j < fila.length - 1) {
						registrosEnLista += '@';
			        }
			    }
			  
				// se añade la separacion entre filas
				if (i < datosFinal.length - 1) {
					registrosEnLista += '#';
				}
			}
			
		}
		set(FORMULARIO + '.reclamosNoGenerar', registrosEnLista);
			
		set(FORMULARIO + '.accion', 'guardar');
		set(FORMULARIO + '.conectorAction', 'LPCambiosPreciosRec');
			
		enviaSICC(FORMULARIO);
	
	} else { // modificar == false
   
   
			var registrosEnLista = '';
			listado2.actualizaDat(); //Actualiza el array 'datos'
			var datosFinal = listado2.datos;
			
			if(datosFinal.length != 0) {
			
				for (i = 0; i < datosFinal.length; i++) {
			    
			      var fila = datosFinal[i];
			      var cadenaAgnadir;
			                  
			      for (j = 0; j < fila.length; j++) {
			               
			         // si se recoge de la lista una columna vacia hay que meter algun valor para que 
			         // en la LP se pueda utilizar correctamente el StringTokenizer. Añado un -
			         if (fila[j] == '') { 
							cadenaAgnadir = '-';
			         } else {
							cadenaAgnadir = fila[j];	
			         }
			         registrosEnLista += cadenaAgnadir;
			
			         // se añade la separacion entre columnas
			         if (j < fila.length - 1) {
							registrosEnLista += '@';
			         }
			      }
			  
					// se añade la separacion entre filas
					if (i < datosFinal.length - 1) {
						registrosEnLista += '#';
					}
				}
			
			}
			
			set(FORMULARIO + '.reclamosNoGenerar', registrosEnLista);
			
			set(FORMULARIO + '.accion', 'guardar');
			set(FORMULARIO + '.conectorAction', 'LPCambiosDePrecios');
			
			enviaSICC(FORMULARIO);																										
	}	
	// Ponemos la variable boolean de la pantalla a true
	// esto se hace mediante la salida generica. Cuando se ejecuta correctamente la 
	// accion de guardar se llama a la funcion ponerGuardadoTrue()
}

function ponerGuardadoTrue() {
	
	// esta funcion se ejecuta si el codigo que se genera al guardar en la salida generica es correcto
	// LPCambiosDePrecios.guardar()
		
	// Ponemos la variable boolean de la pantalla a true
	set(FORMULARIO + '.guardado', true);	
}


// incidencia BELC300014913
function onClickGenerarReclamos() {
	
	if (eval(get(FORMULARIO + '.guardado'))) { //Si la variable guardado está a true (hemos guardado previamente)
		//alert('Se implentará esta acción en próximos paquetes');	
	
		// Llama a la LPGenerarReclamos con acción = "generar" 
		set(FORMULARIO + '.accion', 'generar');
		set(FORMULARIO + '.conectorAction', 'LPGenerarReclamos'); 
	
		enviaSICC(FORMULARIO);		
		
	
	} else { // la variable guardado esta a false (No hemos guardado previamente) 
		// Muestra error: REC007 
		GestionarMensaje('REC007');	
	}
}


function onClickAniadir() {
	// El usuario selecciona uno o varios registros de la lstResultados y selecciona no generar 
	// un reclamo para dichos clientes.
	// Añadimos los registros seleccionados a la lstNoGenerar
	
	var encontrado = false;

	if (listado1.numSelecc() == 0) {
		// Muestra el mensaje: "Debe seleccionar al menos un elemento de la lista"
		GestionarMensaje('1021');
   } else {
	
		var matDatos1 = listado1.datos;
		var listalimpia = new Array();

		var seleccionadosListado1 = listado1.codSeleccionados();
		var a=0;		
		
		for (i=0; i < matDatos1.length; i++) {
			for (j=0; j < seleccionadosListado1.length; j++) {
				if (matDatos1[i][0] == seleccionadosListado1[j]) {
					// hay que comprobar que no se ha insertado ya el registro que se quiere aniadir
					// BELC300019647. Se diferencian los registros por su solicitud de cabecera y por su posicion de solicitud
					encontrado = false;
					for (k=0; k < listado2.datos.length; k++) {
						if (matDatos1[i][0] == listado2.datos[k][0]
							&& matDatos1[i][OIDPOSICIONSOLICITUD] == listado2.datos[k][OIDPOSICIONSOLICITUD]) 
						{
							encontrado = true;
							break;
						}
					}
					if (! eval(encontrado)){
						 listado2.insertar(matDatos1[i]);						
						break;
					}
				}
			}
		}
			
		// se refresca la lista
		listado2.repintaDat(); 		
		listado1.eliminarSelecc();
		
	}
}

function onClickEliminar() {
         
   //Eliminar las líneas seleccionadas en la lista editable "listado2"
   if (listado2.numSelecc() > 0) {
	  //inc DBLG400000549
	  var encontrado = false;  	  
		var matDatos2 = listado2.datos;		
		var seleccionadosListado2 = listado2.codSeleccionados();		
		for (i=0; i < matDatos2.length; i++) {
			for (j=0; j < seleccionadosListado2.length; j++) {
				if (matDatos2[i][0] == seleccionadosListado2[j]) {
					// hay que comprobar que no se ha insertado ya el registro que se quiere aniadir
					// BELC300019647. Se diferencian los registros por su solicitud de cabecera y por su posicion de solicitud
					encontrado = false;
					for (k=0; k < listado1.datos.length; k++) {
						if (matDatos2[i][0] == listado1.datos[k][0]
							&& matDatos2[i][OIDPOSICIONSOLICITUD] == listado1.datos[k][OIDPOSICIONSOLICITUD]) 
						{
							encontrado = true;
							break;
						}
					}
					if (! eval(encontrado)){
						listado1.insertar(matDatos2[i]);
						break;
					}
				}
			}
	
		// se refresca la lista
		listado1.repintaDat(); 
	}
	 //fin inc DBLG400000549
      listado2.eliminarSelecc();
      listado2.actualizaDat(); 
	  listado2.reajusta();

	} else { // Muestra el mensaje: "Debe seleccionar al menos un elemento de la lista"
		GestionarMensaje('1021');
	}
}

function irBoton(boton) {
	document.all[boton].focus();
}

function onClickAnular(){

	//El usuario selecciona anular el reclamo 
	//Llama a la LPCambiosPreciosRec con: 
	//- accion = "anular" 
	//- oidCabecera  --> se recoge en la LP de un hidden
	set(FORMULARIO + '.accion', 'anular');
	set(FORMULARIO + '.conectorAction', 'LPCambiosPreciosRec');
	enviaSICC(FORMULARIO);		
}

function fVolver(){
	window.close();	
}