/**
* Copyright 2004 © por Indra Sistemas,S.A.. Todos los derechos reservados.
* Avda. de Bruselas, 35
* Parque Empresarial Arroyo de la Vega
* 28108 Alcobendas, Madrid
* España
*
* Privado y Confidencial.
* La información contenida en este documento es propiedad de Indra sistemas.
* Para uso exclusivo de empleados autorizados no permitiéndose
* la distribución de este código sin permiso expreso.
*/ 
/*
    INDRA/CAR/PROY
    $Id: contenido_plantilla_cursos_modificar.js,v 1.1 2009/12/03 19:02:10 pecbazalar Exp $
    DESC
*/
var FORMULARIO = 'frmFormulario'; 

function onLoadPag()
{	
	if (get(FORMULARIO+'.errDescripcion')!='') {
		var wnd = fMostrarMensajeError(get(FORMULARIO+'.errCodigo'),get(FORMULARIO+'.errDescripcion'));
	}
    var casoUso = get(FORMULARIO+'.casoUso');
	//if (casoUso == 'modificar' || casoUso == 'eliminar' || casoUso == 'copiar') {
		focaliza(FORMULARIO + ".txtNombrePlantilla");
	//}
	configurarMenuSecundario(FORMULARIO);	
}	


// Función que se ejecuta al pulsar el botón Buscar
function accionBuscar() 
{
    if (get(FORMULARIO+'.casoUso') == 'eliminar')
        btnProxy(4, 0);
    var nombrePlantilla = get(FORMULARIO+'.txtNombrePlantilla');
	 
    var idioma = get(FORMULARIO+'.idioma').toString();
    var nombre = get(FORMULARIO+'.txtNombrePlantilla').toString();
   
    configurarPaginado(mipgndo, "EDUConsultaPlantilla", "ConectorObtienePlantilla", "es.indra.sicc.dtos.edu.DTOPlantillaCurso", [["oidIdioma", idioma],["nombre", nombre]] );   
    
    // Se hace visible la lista con los resultados de la búsqueda. Dependiendo
    // del caso de uso se activan los botones correspondientes
    /*var casoUso = get(FORMULARIO+'.casoUso');
    if (casoUso == 'modificar' || casoUso == 'eliminar' || casoUso == 'consultar' || casoUso == 'copiar') {
    	if (!get_visibilidad("capaLista")) {
		//Si la lista esta visible no se llama a visible
    		visibleLista();
    	}
    }*/ 
    
}


// Función que se ejecuta al pulsar el botón Modificar
function accionModificar()
{	
	//Comprobamos la seleccion una plantilla
	if (listado1.numSelecc() == 0) {
		//Mostramos mensaje de error 
		GestionarMensaje('50');
	} else {
		if (listado1.numSelecc() != 1 ) {
                        //Muesta el mensaje: "Debe seleccionar un solo registro"
                        GestionarMensaje('8');
						deseleccionaListado();
                  } else {
	
			//Obtenemos el oid seleccionados
			//set('frmFormulario.oidSeleccionado',listado1.codSeleccionados());
			//Llamos al proceso correspondiente Modal
			var objParams = new Object();
  			objParams.oid=listado1.codSeleccionados();
  			objParams.casoUso=get(FORMULARIO+'.casoUso');
  			mostrarModalSICC('LPModificaPlantilla', 'modificar', objParams, null, null);	
  			//Recargar los datos Modificados
 			accionBuscar();
			//set('frmFormulario.accion','modificar');
			//set('frmFormulario.conectorAction','LPModificaPlantilla');
			//enviaSICC('frmFormulario');
		 }
	}	
}

function accionDetalle() { 
	// Se comprueba que se ha seleccionado una plantilla de la lista
	if (listado1.numSelecc() == 0) {
		// Muestra el mensaje: "Debe seleccionar un elemento de la lista"
		GestionarMensaje('50');
	} else {
		if (listado1.numSelecc() != 1 ) {
			//Muesta el mensaje: "Debe seleccionar un solo registro"
			GestionarMensaje('8');
			deseleccionaListado();
		} else {
			//Obtenemos el oid seleccionado
			//set(FORMULARIO+'.oidSeleccionado',listado1.codSeleccionados());
			//Llamos al proceso correspondiente Modal
			var objParams = new Object();
  			objParams.oidSeleccionado=listado1.codSeleccionados();
  			objParams.casoUso=get(FORMULARIO+'.casoUso');
  			mostrarModalSICC('LPConsultaPlantilla', 'detalle', objParams, null, null);
			//set(FORMULARIO+'.accion','detalle');
			//set(FORMULARIO+'.conectorAction','LPConsultaPlantilla');
			//enviaSICC(FORMULARIO); 
		}
	}	
}

// Función que se ejecuta al pulsar el botón Copiar
function accionCopiar()
{	
	// Se comprueba que se ha seleccionado una plantilla de la lista
	if (listado1.numSelecc() == 0) {
		// Muestra el mensaje: "Debe seleccionar un elemento de la lista"
		GestionarMensaje('50');
	} else {
		if (listado1.numSelecc() != 1 ) {
			//Muesta el mensaje: "Debe seleccionar un solo registro"
			GestionarMensaje('8');
			deseleccionaListado();
		} else {
			//Obtenemos el oid seleccionado
			//set(FORMULARIO+'.oidSeleccionado',listado1.codSeleccionados());
			//Llamos al proceso correspondiente Modal
			var objParams = new Object();
  			objParams.oidSeleccionado=listado1.codSeleccionados();
  			objParams.casoUso=get(FORMULARIO+'.casoUso');
  			mostrarModalSICC('LPCopiaPlantilla', 'copiar', objParams, null, null);	
  			//Recargar los datos Modificados
 			accionBuscar();
			//set(FORMULARIO+'.accion','copiar');
			//set(FORMULARIO+'.conectorAction','LPCopiaPlantilla');
			//enviaSICC(FORMULARIO);
		}
	}
}

function visibleLista() {
	//visibilidad('capaTitulo','V');
	visibilidad('capaLista','V');
	
	DrdEnsanchaConMargenDcho('listado1',12);
	
 	//Dependiendo del caso de uso mostramos los botones
    	var casoUso = get(FORMULARIO+'.casoUso');
   	 if (casoUso == 'modificar') {
	    	document.all["DetalleDiv"].style.visibility='hidden';
	    	document.all["CopiarDiv"].style.visibility='hidden';
    	} else if (casoUso == 'eliminar') {
	    	document.all["ModificarDiv"].style.visibility='hidden';
	    	//document.all["DetalleDiv"].style.visibility='hidden';
	    	document.all["CopiarDiv"].style.visibility='hidden';
    	} else if (casoUso == 'consultar') {
	    	document.all["ModificarDiv"].style.visibility='hidden';
	    	document.all["CopiarDiv"].style.visibility='hidden';
    	} else if (casoUso == 'copiar') {
    		document.all["ModificarDiv"].style.visibility='hidden';
	    	document.all["DetalleDiv"].style.visibility='hidden';
    	}
    	eval (ON_RSZ);  
}

function fBorrar() {
	//Obtenemos los valores de los campos oid de las filas seleccionadas por el usuario 
	//Llamamos a eliminarFilas pasandole el idBusiness="EDUEliminaCurso", los oids que hemos obtenido.
	
	if (listado1.numSelecc() > 0) {
		var oids = listado1.codSeleccionados();
		eliminarFilas(oids, "EDUEliminaPlantilla", mipgndo)
	} else {
		// Se muestra el mensaje: "Debe seleccionar un elemento de la lista"
		GestionarMensaje('50');
	}
}

function fLimpiar() {

	//Limpiar el formulario
	set(FORMULARIO+'.txtNombrePlantilla','');
}

function focalizaTabAux(origen) {
	//Funcion auxiliar para focalizar botones
	//Si hay algun boton visible le pasamos el foco (Modificar, Detalle, Copiar)
	//Si no pasa al primer combo
	if (!get_visibilidad("capaLista")) {
    	//La lista no esta visible
    	//Si el origen es txtNombrePlantilla -> focalizar el btnBuscar
    	if(origen == 'txtNombrePlantilla') {
    		document.all['btnBuscar'].focus();
    		var tr = document.body.createTextRange(); 
        	tr.execCommand("Unselect"); 

    	}
    	//Si el origen es btnBuscar -> focalizar el txtNombrePlantilla
    	if(origen == 'btnBuscar') {
    		focaliza(FORMULARIO + ".txtNombrePlantilla");
    	}
    }
    else {
    	//La lista esta visible pasamos el foco al boton correspondiente
    	//Dependiendo del caso de uso mostramos los botones
        var casoUso = get(FORMULARIO+'.casoUso');
          if (casoUso == 'modificar') {
             	document.all['Modificar'].focus();
	    		var tr = document.body.createTextRange(); 
	        	tr.execCommand("Unselect"); 
         } else if (casoUso == 'eliminar') {
             	document.all['Detalle'].focus();
	    		var tr = document.body.createTextRange(); 
	        	tr.execCommand("Unselect"); 
         } else if (casoUso == 'consultar') {
             	document.all['Detalle'].focus();
         } else if (casoUso == 'copiar') {
         		document.all['Copiar'].focus();
	    		var tr = document.body.createTextRange(); 
	        	tr.execCommand("Unselect"); 
         }
    }
}

function fVolver(){
	
	//El boton volver del menu secundario estara activo
	//cuando estemos en una ventana modal simplemente cerramos
    window.close();
}

	function ocultaLista() {
		//visibilidad('capaTitulo','O');
		visibilidad('capaLista','O');
	}


function muestraLista(ultima, rowset) {
         var tamano = rowset.length;
         if (tamano > 0) {
                  visibleLista();
    			if (get(FORMULARIO+'.casoUso') == 'eliminar')
                  		btnProxy(4, 1);
                  return true;
         } else {
                  ocultaLista();
                  focaliza(FORMULARIO+'.txtNombrePlantilla','');
                  return false;
         }
}

	function deseleccionaListado() {
		for (i = 0; i < listado1.datos.length; i++)
				listado1.deselecciona(i); 
	}