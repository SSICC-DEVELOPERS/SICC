function onLoad(){
         configurarMenuSecundario('formulario');
         DrdEnsanchaConMargenDcho('listado1',12);

         ocultaCapas();
         
		 fMostrarMensajeError();
         eval(ON_RSZ);

         focaliza('formulario.cbSubClasificacion');
}

//---------------------------------------------------------------------------------------------------

function onTab(campoActual) {

	if (campoActual == 'cbSubClasificacion') {
		focaliza('formulario.cbTipoCliente');
	} else if (campoActual == 'cbTipoCliente') {
		focaliza('formulario.cbSubTipoCliente');
	} else if (campoActual == 'cbSubTipoCliente') {
		focaliza('formulario.cbTipoClasificacion');
	} else if (campoActual == 'cbTipoClasificacion') {
		focaliza('formulario.cbClasificacion');
	} else if (campoActual == 'cbClasificacion') {
		focaliza('formulario.txtDescripcion');
	} else if (campoActual == 'txtDescripcion') {
		focalizaBotonHTML('botonContenido','btnBuscar');
	}else if (campoActual == 'btnBuscar') {
		if (document.all["Cplistado1"].style.visibility != 'hidden') {
			var opcionMenu = get('formulario.opcionMenu');
		
			if (opcionMenu == 'modificarTipoClienteCom') {
				focalizaBotonHTML('botonContenido','btnModificar');
			} else if (opcionMenu == 'consultarTipoClienteCom') {
				focalizaBotonHTML('botonContenido','btnDetalle');
			} else if (opcionMenu == 'eliminarTipoClienteCom') {
				focalizaBotonHTML('botonContenido','btnDetalle');
			}
		} else {
		focaliza('formulario.cbSubClasificacion');
		}
	} else if (campoActual == 'btnModificar' || campoActual == 'btnDetalle') {
		focaliza('formulario.cbSubClasificacion');
	}                                                
}

function onShiftTab(campoActual) {
	if (campoActual == 'cbSubClasificacion') {
		if (document.all["Cplistado1"].style.visibility != 'hidden') {
			var opcionMenu = get('formulario.opcionMenu');
	
			if (opcionMenu == 'consultarTipoClienteCom') {
				focalizaBotonHTML('botonContenido','btnDetalle');
			} else if (opcionMenu == 'modificarTipoClienteCom') {
				focalizaBotonHTML('botonContenido','btnModificar');
			} else if (opcionMenu == 'eliminarTipoClienteCom') {                                    
				focalizaBotonHTML('botonContenido','btnDetalle');
			}
		} else {
			focalizaBotonHTML('botonContenido','btnBuscar');
		}
	} else if (campoActual == 'txtDescripcion') {
		focaliza('formulario.cbClasificacion');
	} else if (campoActual == 'cbClasificacion') {
		focaliza('formulario.cbTipoClasificacion');
	} else if (campoActual == 'cbTipoClasificacion') {
		focaliza('formulario.cbSubTipoCliente');
	} else if (campoActual == 'cbSubTipoCliente') {
		focaliza('formulario.cbTipoCliente');
	} else if (campoActual == 'cbTipoCliente') {
		focaliza('formulario.cbSubClasificacion');         
	} else if (campoActual == 'btnBuscar') {
		focaliza('formulario.txtDescripcion');
	} else if (campoActual == 'btnModificar' || campoActual == 'btnDetalle') {
		focalizaBotonHTML('botonContenido','btnBuscar');
	}
}

//---------------------------------------------------------------------------------------------------

function ocultarLista() {
    document.all["Cplistado1"].style.visibility='hidden';
    document.all["CpLin1listado1"].style.visibility='hidden';
    document.all["CpLin2listado1" ].style.visibility='hidden';
    document.all["CpLin3listado1"].style.visibility='hidden';
    document.all["CpLin4listado1"].style.visibility='hidden';
    document.all["primera1Div"].style.visibility='hidden';
    document.all["ret1Div"].style.visibility='hidden';
    document.all["ava1Div"].style.visibility='hidden';
    document.all["separaDiv"].style.visibility='hidden';    
    document.all["btnDetalleDiv"].style.visibility='hidden';
    document.all["btnModificarDiv"].style.visibility='hidden';           
}

function ocultaCapas(){
	document.all["Cplistado1"].style.visibility='hidden';
	document.all["CpLin1listado1"].style.visibility='hidden';
	document.all["CpLin2listado1"].style.visibility='hidden';
	document.all["CpLin3listado1"].style.visibility='hidden';
	document.all["CpLin4listado1"].style.visibility='hidden';
	document.all["primera1Div"].style.visibility='hidden';
	document.all["ret1Div"].style.visibility='hidden';
	document.all["ava1Div"].style.visibility='hidden';
	document.all["separaDiv"].style.visibility='hidden';
	document.all["btnDetalleDiv"].style.visibility='hidden';
	document.all["btnModificarDiv"].style.visibility='hidden';         
}
         

//---------------------------------------------------------------------------------------------------
/*
 * Esta función habilita o deshabilita el botón de avance de la lista editable, según corresponda
 */
function deshabilitarBotonAvance() {
	var largo = listado1.datos.length;
	var ultimoReg = listado1.datos[largo-1][0];
	var totalReg = listado1.datos[0][12];
	if (ultimoReg == totalReg) {
		// Deshabilito el botón Avance
		mipgndo.ava.setTipo(0);
	}
}

//---------------------------------------------------------------------------------------------------

function fBorrar() {
	accionEliminar();
}

function accionBuscar() {
	configurarPaginado(mipgndo, 
		"COMBuscarTipoClienteComDetalle", 
		"ConectorBuscarTipoClienteComDetalle",
		"es.indra.sicc.dtos.com.DTOTipoClienteComDetalle",
		cargarArray());
}

function accionDetalle() {
	var codigos = new Array();
	codigos = listado1.codSeleccionados();
	var cant = codigos.length;
	var posicion = obtenerPosicionListaEditable(listado1.codSeleccionados(),listado1);       
	if (cant == 1) {
		var obj = new Object();
		for (var i = 0; i < codigos.length; i++) {                 
			obj.hOidSubClasificacion = listado1.extraeDato(codigos[i], 10); 
			obj.hOidTipoCliente = listado1.extraeDato(codigos[i], 6); 
			obj.hOidSubTipoCliente = listado1.extraeDato(codigos[i], 7); 
			obj.hOidTipoClasificacion = listado1.extraeDato(codigos[i], 8); 
			obj.hOidClasificacion = listado1.extraeDato(codigos[i], 9); 
			obj.htxtDescripcion = listado1.extraeDato(codigos[i], 5); 
			obj.hOidTipoClieDet = codigos[i];
		}
		obj.opcionMenu = get('formulario.opcionMenu');
		obj.accion = 'detalle';
		mostrarModalSICC('LPParamTipoClienteComDetalle', 'detalle', obj);
	} else{
		GestionarMensaje('50');
	}
}

function accionModificar() {
	var codigos = new Array();
	codigos = listado1.codSeleccionados();
	var cant = codigos.length;
	var posicion = obtenerPosicionListaEditable(listado1.codSeleccionados(),listado1);       
	if (cant == 1) {
		var obj = new Object();
		for (var i = 0; i < codigos.length; i++) {                 
			obj.hOidSubClasificacion = listado1.extraeDato(codigos[i], 10); 
			obj.hOidTipoCliente = listado1.extraeDato(codigos[i], 6); 
			obj.hOidSubTipoCliente = listado1.extraeDato(codigos[i], 7); 
			obj.hOidTipoClasificacion = listado1.extraeDato(codigos[i], 8); 
			obj.hOidClasificacion = listado1.extraeDato(codigos[i], 9); 
			obj.htxtDescripcion = listado1.extraeDato(codigos[i], 5); 
			obj.hOidTipoClieDet = codigos[i];
		}
		obj.opcionMenu = get('formulario.opcionMenu');
		obj.accion = 'detalleModificar';
		var retorno = mostrarModalSICC('LPParamTipoClienteComDetalle', 'detalleModificar', obj);
		if (retorno == "modificar"){             
			mipgndo.recargar();           
		}  
		accionBuscar();
	} else    {
		GestionarMensaje('50');
	}
}

function accionEliminar() {
	if (listado1.numSelecc() >= 1){
		var seleccionados = listado1.codSeleccionados();
		eliminarFilas(seleccionados, "COMEliminarTipoClienteComDetalle", mipgndo);
		return true;
	 }else{
		  GestionarMensaje('4',null,null,null);                        
	}    
/*
	var seleccionados = listado1.codSeleccionados();      
	var oids =  new Array();
	var cantSeleccionados = seleccionados.length;
	if (cantSeleccionados == 0){
		GestionarMensaje("4", null, null, null);      
		return;
	}
	for (var i = 0; i < seleccionados.length; i++) {                 
		oids[i] = listado1.extraeDato(seleccionados[i], 10); 
	}
*/
}

//---------------------------------------------------------------------------------------------------

function cargarArray(){

	var arrDatos = new Array();
	var i=0;

	arrDatos[i] = new Array('oidIdioma',get('formulario.idioma'));      
	i++;
	arrDatos[i] = new Array('oidPais',get('formulario.pais'));
	i++;

	if (get('formulario.cbSubClasificacion')!=''){
		arrDatos[i] = new Array('idSubclasificacion',get('formulario.cbSubClasificacion'));
		i++;
	}
	if (get('formulario.cbTipoCliente')!=''){
		arrDatos[i] = new Array('oidTipoCliente',get('formulario.cbTipoCliente'));
		i++;
	}

	if (get('formulario.cbSubTipoCliente')!=''){
		arrDatos[i] = new Array('oidSubtipoCliente',get('formulario.cbSubTipoCliente'));
		i++;
	}

	if (get('formulario.cbTipoClasificacion')!=''){
		arrDatos[i] = new Array('oidTipoClasificacion',get('formulario.cbTipoClasificacion'));
		i++;
	}      

	if (get('formulario.cbClasificacion')!=''){
		arrDatos[i] = new Array('oidClasificacion',get('formulario.cbClasificacion'));
		i++;
	}

	if (get('formulario.txtDescripcion')!=''){
		arrDatos[i] = new Array('descripcion',get('formulario.txtDescripcion'));
		i++;
	}      

	return arrDatos;
}

//---------------------------------------------------------------------------------------------------



function muestraLista(ultima, rowset) {
	var tamano = rowset.length;
	if (tamano > 0) {
		visualizarLista();
		return true;
	} else {
		ocultarLista();
		// No se ha encontrado ningún elemento con los criterios especificados
		focaliza('formulario.cbSubClasificacion');
		return false;
	}
}

function visualizarLista() {
	DrdEnsanchaConMargenDcho('listado1',12);

	document.all["Cplistado1"].style.visibility='';
	document.all["CpLin1listado1"].style.visibility='';
	document.all["CpLin2listado1"].style.visibility='';
	document.all["CpLin3listado1"].style.visibility='';
	document.all["CpLin4listado1"].style.visibility='';

	document.all["primera1Div"].style.visibility='';
	document.all["ret1Div"].style.visibility='';
	document.all["ava1Div"].style.visibility='';
	document.all["separaDiv"].style.visibility='';


	if (get('formulario.opcionMenu')=='consultarTipoClienteCom'){ // Para ver detalle
		document.all["btnModificarDiv"].style.visibility='hidden';
		document.all["btnDetalleDiv"].style.visibility='visible';              
	}

	if (get('formulario.opcionMenu')=='modificarTipoClienteCom'){ // Para modificar
		document.all["btnModificarDiv"].style.visibility='visible';
		document.all["btnDetalleDiv"].style.visibility='hidden';
	}

	if (get('formulario.opcionMenu')=='eliminarTipoClienteCom'){ // Para ver detalle
		document.all["btnModificarDiv"].style.visibility='hidden';
		document.all["btnDetalleDiv"].style.visibility='visible';             
		btnProxy(4,1);
	}

	eval (ON_RSZ);
}

function cbTipoClienteOnChange() {
	recargaCombo('formulario.cbSubTipoCliente', 
	'MAEobtenerSubtipos', 
	'es.indra.sicc.util.DTOOID', 
	[["oid", get('formulario.cbTipoCliente')],
	 ["oidIdioma", get('formulario.idioma')],
	 ["oidPais", get('formulario.pais')]]);
}

function cbSubtipoClienteOnChange() {
	recargaCombo('formulario.cbTipoClasificacion', 
	'MAEobtenerTipoClasificacion', 
	'es.indra.sicc.util.DTOOID', 
	[["oid", get('formulario.cbSubTipoCliente')],
	 ["oidIdioma", get('formulario.idioma')],
	 ["oidPais", get('formulario.pais')]]);
}

function cbTipoClasificacionOnChange() {
	recargaCombo('formulario.cbClasificacion', 
	'MAEobtenerClasificacionesPorTipo', 
	'es.indra.sicc.util.DTOOID', 
	[["oid", get('formulario.cbTipoClasificacion')],
	 ["oidIdioma", get('formulario.idioma')],
	 ["oidPais", get('formulario.pais')]]);
}


function fLimpiar() {
	set('formulario.cbTipoCliente', '');
	set('formulario.cbSubClasificacion', '');
	set_combo('formulario.cbSubTipoCliente', [['','']],['']);
	set_combo('formulario.cbTipoClasificacion', [['','']],['']);
	set_combo('formulario.cbClasificacion', [['','']],['']);
	set('formulario.txtDescripcion', '');
	limpiaI18N('formulario', '1');
}


//------------------------------------------------------------------------------------------------------------

function fVolver() {
		window.returnValue = null; // Para que no actualice el LISTADO si no se 'guardó' correctamente.
		window.close();
}

//------------------------------------------------------------------------------------------------------------
