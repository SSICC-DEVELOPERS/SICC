/**
* Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
    $Id: contenido_cursos_modificar.js,v 1.1 2009/12/03 19:02:12 pecbazalar Exp $
    DESC
*/
var FORMULARIO = 'frmFormulario'; 

  function onLoadPag() {
  	if (get(FORMULARIO+'.errDescripcion')!='') {
		var wnd = fMostrarMensajeError(get(FORMULARIO+'.errCodigo'),get(FORMULARIO+'.errDescripcion'));
	}
  	focaliza(FORMULARIO + ".cbMarca");
    configurarMenuSecundario(FORMULARIO);
 }

function accionBuscar() {
    	if (get(FORMULARIO+'.casoUso') == 'eliminar')
             btnProxy(4, 0);

    	var idioma = get(FORMULARIO+'.idioma');
     	var marca = get(FORMULARIO+'.cbMarca');
    	var canal = get(FORMULARIO+'.cbCanal');
    	var tipoCurso = get(FORMULARIO+'.cbTipoCurso');
    	var codigo = get(FORMULARIO+'.txtCodCurso');
    	var nombre = get(FORMULARIO+'.txtNombreCurso');

   	configurarPaginado(mipgndo,"EDUConsultaCurso","ConectorObtieneCursos","es.indra.sicc.dtos.edu.DTOConsultaCurso", [["marca", marca], ["canal", canal], ["tipoCurso", tipoCurso], ["codigo", codigo], ["nombre", nombre],["oidIdioma", idioma]] );  
   	// Se hace visible la lista con los resultados de la búsqueda
       /* if (!get_visibilidad("capaLista")) {
                  //Si la lista esta visible no se llama a visible
                  visibleLista();
         }*/
}

function accionDetalle() {

	// Se comprueba que se ha seleccionado un curso
         if (listado1.numSelecc() == 0) {
                  // Muestra el mensaje: "Debe seleccionar un elemento de la lista"
                  GestionarMensaje('50');
         } else {
                  if (listado1.numSelecc() != 1 ) {
                           //Muesta el mensaje: "Debe seleccionar un solo registro"
                           GestionarMensaje('8');
							//deseleccionar filas
							deseleccionaListado();
                  } else {
                        //Obtenemos el oid seleccionados
			//set('frmFormulario.oidSeleccionado',listado1.codSeleccionados());
			//Llamos al proceso correspondiente Modal
		    var objParams = new Object();
  			objParams.oidSeleccionado=listado1.codSeleccionados();
  			objParams.casoUso=get(FORMULARIO+'.casoUso')
  			mostrarModalSICC('LPConsultaCurso', 'detalle', objParams, null, null);		
			//set('frmFormulario.accion','detalle');
			//set('frmFormulario.conectorAction','LPConsultaCurso');
			//enviaSICC('frmFormulario');  
            }
         }
}

function accionModificar() {

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
			//Llamamos al proceso correspondiente Modal
			var objParams = new Object();
  			objParams.oid=listado1.codSeleccionados();
  			objParams.casoUso=get(FORMULARIO+'.casoUso')
  			mostrarModalSICC('LPModificaCurso', 'modificar', objParams, null, null);	
  			//Recargar los datos Modificados
 			accionBuscar();
			//set('frmFormulario.accion','modificar');
			//set('frmFormulario.conectorAction','LPModificaCurso');
			//enviaSICC('frmFormulario');
		 }
	}
}

function accionCopiar() {

	//Pulsacion del boton detalle
	//Comprobamos la seleccion de cursos
	if (listado1.numSelecc() == 0)
	{
		//Mostramos mensaje de error
		GestionarMensaje('50');
	}
	else
	{
		if (listado1.numSelecc() != 1 ){
			//Mostramos mensaje de error
			GestionarMensaje('8');
			deseleccionaListado();
		}
		else {
			//Llamamos a mostrar detalle
			//Obtenemos el oid seleccionados
			//set(FORMULARIO+'.oidSeleccionado',listado1.codSeleccionados());
			//Llamos al proceso correspondiente Modal
			var objParams = new Object();
  			objParams.oidSeleccionado=listado1.codSeleccionados();
  			objParams.casoUso=get(FORMULARIO+'.casoUso')
  			mostrarModalSICC('LPCopiaCurso', 'copiar', objParams, null, null);	
  			//Recargar los datos para que aparezca el curso copiado
 			accionBuscar();
			//set(FORMULARIO+'.accion','copiar');
			//set(FORMULARIO+'.conectorAction','LPCopiaCurso');
			//enviaSICC(FORMULARIO);
		}
	}	
}

function onSeleccionaMarca() {
   	var marca = get(FORMULARIO+'.cbMarca');
	var idioma = get(FORMULARIO+'.idioma');
	if (marca != "") {
            recargaCombo(FORMULARIO+'.cbTipoCurso',
		'CMNObtieneTiposCurso', 'es.indra.sicc.dtos.edu.DTODruidaBusqueda',
		[["oidIdioma", idioma], ["oidMarca", marca]]);
   	}
    else {
    	del_combo(FORMULARIO+'.cbTipoCurso',-1,0);
    }
}

//valida entero si el campo es modificable y no vacío 
function validaEntero(nombreElemento) {
 if (eval(FORMULARIO+'.'+nombreElemento+'RO') != "S") {  
 	if (get(FORMULARIO+'.'+nombreElemento).toString() != "") { 
 		//Como no nos interesa validar el número de dígitos que tiene el 
 		//entero ponemos uno suficientemente grande.  
 		if (ValidaInt(get(FORMULARIO+'.'+nombreElemento).toString(),10000, 0)!="OK") {
			GestionarMensaje('747', null, null, null); focaliza(FORMULARIO+'.'+nombreElemento);
			return false;
		}
 	}
 }
}

function visibleLista() {
	
	// visibilidad('capaTitulo','V');
         visibilidad('capaLista','V');
         
         DrdEnsanchaConMargenDcho('listado1',12);
         
         //Dependiendo del caso de uso mostramos los botones
         var casoUso = get(FORMULARIO+'.casoUso');
          if (casoUso == 'modificar') {
             	document.all["DetalleDiv"].style.visibility='hidden';
             	document.all["CopiarDiv"].style.visibility='hidden';
         } else if (casoUso == 'eliminar') {
             	document.all["ModificarDiv"].style.visibility='hidden';
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

	function ocultaLista() {
		//visibilidad('capaTitulo','O');
		visibilidad('capaLista','O');
	}


function fBorrar() {
         //Obtenemos los valores de los campos oid de las filas seleccionadas por el usuario 
         //Llamamos a eliminarFilas pasandole el idBusiness="EDUEliminaCurso", los oids que hemos obtenido.
         if (listado1.numSelecc() > 0) {
                  var oids = listado1.codSeleccionados();
                  eliminarFilas(oids, "EDUEliminaCurso", mipgndo)
         } else {
                  // Se muestra el mensaje: "Debe seleccionar un elemento de la lista"
                  GestionarMensaje('50');
         }
}

function fLimpiar() {

	//Limpiar el formulario
	set(FORMULARIO+'.cbMarca','');
	set(FORMULARIO+'.cbCanal','');
	set(FORMULARIO+'.cbTipoCurso','');
	set(FORMULARIO+'.txtCodCurso','');
	set(FORMULARIO+'.txtNombreCurso','');
}

function focalizaTabAux(origen) {
	//Funcion auxiliar para focalizar botones
	//Si hay algun boton visible le pasamos el foco (Modificar, Detalle, Copiar)
	//Si no pasa al primer combo
	if (!get_visibilidad("capaLista")) {
    	//La lista no esta visible
    	//Si el origen es cbMarca -> focalizar el btnBuscar
    	if(origen == 'cbMarca') {
    		document.all['btnBuscar'].focus();
    	}
    	//Si el origen es btnBuscar -> focalizar el cbMarca
    	if(origen == 'btnBuscar') {
    		focaliza(FORMULARIO + ".cbMarca");
    	}
    }
    else {
    	//La lista esta visible pasamos el foco al boton correspondiente
    	//Dependiendo del caso de uso mostramos los botones
        var casoUso = get(FORMULARIO+'.casoUso');
          if (casoUso == 'modificar') {
             	document.all['Modificar'].focus();
         } else if (casoUso == 'eliminar') {
             	document.all['Detalle'].focus();
         } else if (casoUso == 'consultar') {
             	document.all['Detalle'].focus();
         } else if (casoUso == 'copiar') {
         		document.all['Copiar'].focus();
         }
    }
}

function fVolver(){
	
	//El boton volver del menu secundario estara activo
	//cuando estemos en una ventana modal simplemente cerramos
    window.close();
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
                  focaliza(FORMULARIO+'.cbMarca','');
                  return false;
         }
}

	function deseleccionaListado() {
		for (i = 0; i < listado1.datos.length; i++)
				listado1.deselecciona(i); 
	}