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
    $Id: contenido_responsables_unidades_asignar.js,v 1.1 2009/12/03 19:02:07 pecbazalar Exp $
    DESC
*/
var FORMUL = 'frm'; 
var SUBGERENCIA = '1'; 
var REGION = '2'; 
var ZONA = '3'; 
var SECCION = '4'; 
var responsable = null;
var codigo = null;
// ------------------------------------------------------------------------------------------------------------------------------------------------------------
function onLoadPag() {
	 if (get(FORMUL + '.errDescripcion')!='') {
			  var wnd = fMostrarMensajeError(get(FORMUL + '.errCodigo'),get(FORMUL + '.errDescripcion'));
	 }

	configurarMenuSecundario(FORMUL);
	responsable = eval("document.all['rbResponsable']");
	responsable[0].checked = true;
	focaliza(FORMUL + ".cbMarca");
	visibilidadBotones('hidden');
    
    // splatas - DBLG400001087 - 27/04/2006
    accion(FORMUL + '.txtCodZona', '.disabled=true');
    
    //PER-SiCC-2011-0928 - Sergio Apaza - 12/04/2012
	document.getElementById("periodoActivo").innerHTML = get(FORMUL + '.hCodigoPeriodo'); 
}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------
function accionBuscar() {

	if (!sicc_validaciones_generales('B')) { return false; }
	 var idioma = get(FORMUL + '.idioma');
	 var pais = get(FORMUL + '.pais');
	 var marca = get(FORMUL + '.cbMarca');
	 var canal = get(FORMUL + '.cbCanal');
	 var rb = get(FORMUL + '.rbResponsable');
	 var indUA = '';
     
     //splatas - DBLG400001087 - 27/04/2006
     var codZona = get(FORMUL + '.txtCodZona');

	if (rb == SUBGERENCIA)
		indUA = get(FORMUL + '.cteSubgerencia');
	else if (rb == REGION )
		indUA = get(FORMUL + '.cteRegion');
	else if (rb == ZONA )
		indUA = get(FORMUL + '.cteZona');
	else if (rb == SECCION )
		indUA = get(FORMUL + '.cteSeccion');

	 // Modificado por ssantana, 28/11/2005, SICC-GCC-ZON-003
     // splatas - DBLG400001087 - 27/04/2006
	 configurarPaginado(mipgndo, 
								"ZONBuscarUnidadesAdministrativas", 
								"ConectorBuscarUnidadesAdministrativas", 
								"es.indra.sicc.dtos.zon.DTOBuscarUA", 
								[["oidMarca", marca], ["oidCanal", canal], ["oidPais", pais], ["indUA", indUA], ["oidIdioma", idioma], ["codZona", codZona]] );
}

function OnTabtxtCodClienteResponsable() {
	/*
	 *  SiCC-20070205 - sapaza, 12/04/2007
	 * Se deja ingresar codigo cliente vacio, si la unidad administrativa tiene asignado un responsable
	 */
    var codigoCliente = get(FORMUL + '.txtCodClienteResponsable').toString();
	var responsable = listaResultados.extraeDato(listaResultados.codSeleccionados()[0],1);

    if (codigoCliente != '' || responsable == '') {
		var longitudCodigoCliente = get(FORMUL + '.longitudCodigoCliente').toString();
	    var longitud = codigoCliente.length;
	    var cadena = rellenaCeros(codigoCliente, longitudCodigoCliente, longitud);
		set(FORMUL + '.txtCodClienteResponsable', cadena);
		set(FORMUL+ '.hidCodClienteTemp', cadena);
	}
	focalizaBotonHTML('botonContenido','btnAsignar');	
}

function OnBlurtxtCodClienteResponsable() {
	/*
	 *  SiCC-20070205 - sapaza, 12/04/2007
	 * Se deja ingresar codigo cliente vacio, si la unidad administrativa tiene asignado un responsable
	 */
    var codigoCliente = get(FORMUL + '.txtCodClienteResponsable').toString();
	var responsable = listaResultados.extraeDato(listaResultados.codSeleccionados()[0],1);

    if (codigoCliente != '' || responsable == '') {
		var longitudCodigoCliente = get(FORMUL + '.longitudCodigoCliente').toString();
		var longitud = codigoCliente.length;
		var cadena = rellenaCeros(codigoCliente, longitudCodigoCliente, longitud);
		set(FORMUL + '.txtCodClienteResponsable', cadena);
		set(FORMUL+ '.hidCodClienteTemp', cadena);
	}
}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------
// Método que se ejecuta al pulsar sobre el botón Asignar
function accionAsignar() {
	/*
	 * BELC300022921 - dmorello, 28/03/2006
	 * Se agrega el relleno del código de cliente con ceros.
	 */
	/*
	 *  SiCC-20070205 - sapaza, 12/04/2007
	 * Se deja ingresar codigo cliente vacio, si la unidad administrativa tiene asignado un responsable
	 */
	var rb = get(FORMUL + '.rbResponsable');
	var indUA = '';
	if (rb == SUBGERENCIA)
		indUA = get(FORMUL + '.cteSubgerencia');
	else if (rb == REGION )
		indUA = get(FORMUL + '.cteRegion');
	else if (rb == ZONA )
		indUA = get(FORMUL + '.cteZona');
	else if (rb == SECCION )
		indUA = get(FORMUL + '.cteSeccion');
	
	set(FORMUL + '.accion', 'Asignar');
    set(FORMUL + '.subgRegZonSecc', indUA);

	var codigoCliente = get(FORMUL + '.txtCodClienteResponsable').toString();
	var responsable = listaResultados.extraeDato(listaResultados.codSeleccionados()[0],1);
    if (codigoCliente != '' || responsable == '') {

		var longitudCodigoCliente = get(FORMUL + '.longitudCodigoCliente').toString();
		var longitud = codigoCliente.length;
		var cadena = rellenaCeros(codigoCliente, longitudCodigoCliente, longitud);
		set(FORMUL + '.txtCodClienteResponsable', cadena);
		set(FORMUL+ '.hidCodClienteTemp', cadena)
	}
	/**/

	//incidencia SiCC-20070205 - sapaza, 12/04/2007, no se valida que ingrese codigo de Cliente
	//if (!sicc_validaciones_generales('A')) { return false; }

	//Comprobamos la seleccion una fila
	 if (listaResultados.numSelecc() == 0) {
		  //Mostramos mensaje de error 
		  GestionarMensaje('50');
	 } else {
		var marca = get(FORMUL + '.cbMarca'); //inc 20289
		var canal = get(FORMUL + '.cbCanal'); //inc 20289
		var codigos = listaResultados.codSeleccionados();
		codigo = codigos[0];

	/*Incidencia 22532 pzerbino 08/03/2006 */ 
    // dmorello, 27/03/2006: Se extraerá el dato 0 (codUA) en lugar del 1 (codCliente)
    var codigoUat =listaResultados.extraeDato(codigo, 0);
    
		/*listaResultados.insertaDato (codigo, 1, get(FORMUL + '.txtCodClienteResponsable')); 
		listaResultados.reajusta();*/
		set(FORMUL + '.accion', 'Asignar');
		set(FORMUL + '.oidUA', codigo);
    
    /*Incidencia 22532 pzerbino 08/03/2006 */
    set(FORMUL + '.hcoddUA', codigoUat);
    
		set(FORMUL + '.indUA', listaResultados.extraeDato(codigo, 3));
    

		//añadido por incidencia 20289
		set(FORMUL + '.hMarca', marca);
		set(FORMUL + '.hCanal', canal);
		//fin añadido
		set(FORMUL + '.conectorAction', 'LPAsignarResponsable');

		enviaSICC(FORMUL, '', '', 'N');
	 }
}


// ------------------------------------------------------------------------------------------------------------------------------------------------------------
function visibleLista() {
		 
	//visibilidad('capa2', 'V');
	
	DrdEnsanchaConMargenDcho('listaResultados',12);

	document.all["CplistaResultados"].style.visibility='visible';
	document.all["CpLin1listaResultados"].style.visibility='visible';
	document.all["CpLin2listaResultados"].style.visibility='visible';
	document.all["CpLin3listaResultados"].style.visibility='visible';
	document.all["CpLin4listaResultados"].style.visibility='visible';
	document.all["primera1Div"].style.visibility='visible';
	document.all["ret1Div"].style.visibility='visible';
	document.all["ava1Div"].style.visibility='visible';
	document.all["separaDiv"].style.visibility='visible';
	eval (ON_RSZ);  
		  
}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------
function ocultaLista() {
	//visibilidad('capa2','O');
	document.all["CplistaResultados"].style.visibility='hidden';
	document.all["CpLin1listaResultados"].style.visibility='hidden';
	document.all["CpLin2listaResultados"].style.visibility='hidden';
	document.all["CpLin3listaResultados"].style.visibility='hidden';
	document.all["CpLin4listaResultados"].style.visibility='hidden';
	document.all["primera1Div"].style.visibility='hidden';
	document.all["ret1Div"].style.visibility='hidden';
	document.all["ava1Div"].style.visibility='hidden';
	document.all["separaDiv"].style.visibility='hidden';
}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------
function fLimpiar() {
	set(FORMUL + '.cbMarca', ['']);
	set(FORMUL + '.cbCanal', ['']);
	set(FORMUL + '.txtCodClienteResponsable','');
	responsable[0].checked = true;
	focaliza(FORMUL + ".cbMarca");
    
    //splatas - DBLG400001087 - 27/04/2006
    set(FORMUL + '.txtCodZona', '');
}


// ------------------------------------------------------------------------------------------------------------------------------------------------------------
function muestraLista(ultima, rowset) {
	var tamano = rowset.length;
	set(FORMUL + ".txtCodClienteResponsable", "");
	if (tamano > 0) {
		visibleLista();
		// Deshabilita botón modificar (ya que no hay ninguna fila seleccionada). 
		deshabilitarHabilitarBoton('botonContenido','Modificar', 'D');
		visibilidadBotones('visible');
		return true;
	} else {
		ocultaLista();
		focaliza(FORMUL + '.cbMarca','');
		visibilidadBotones('hidden');
		return false;
	}
}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------			
function accionSeleccionarCliente() {
	
		//Abrimos un popup modal con la direccion de la LPBusquedaRapidaCliente
		//cuando se cierra el popup si el usuario ha seleleccionado un cliente se nos devuelven dos valores en un array.
		//Con el segundo rellenamos el campo codigoCliente
		var objParams = new Object();
		var resultado = mostrarModalSICC('LPBusquedaRapidaCliente', '', objParams, null, null);
		//alert("resultado: " + resultado);
		if (resultado != null && resultado.length > 1) {
			set(FORMUL + '.txtCodClienteResponsable', resultado[1]);

			// Agregado por ssantana, 30/11/2005, SICC-GCC-ZON-003
			set(FORMUL + '.hidOidClienteBusquedaRapida', resultado[0]);
			// Fin agregado por ssantana, 30/11/2005, SICC-GCC-ZON-003
		}
}


// ------------------------------------------------------------------------------------------------------------------------------------------------------------         
function focalizaSiguientebuscar() {
	if (!get_visibilidad("capa2"))
		focaliza(FORMUL + ".cbMarca");
	else 
		focaliza(FORMUL + ".txtCodClienteResponsable");
}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------     
function focalizarAnteriorMarca() {
	if (!get_visibilidad("capa2"))
		document.all['btnbuscar'].focus();
	else 
		document.all['btnAsignar'].focus();
}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------
function retornoError() {
	//listaResultados.seleccionaCod(codigo)
	//listaResultados.insertaDato (codigo, 1, ''); 
}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------
function retornoAsignar() {
	visibilidad('capa2', 'O');
	mipgndo.recargar();
}

function deseaContinuar() {
    var mensaje = GestionarMensaje('ZON001');
    var SiNoComela = cdos_mostrarConfirm(mensaje);
	if ( SiNoComela ) {
	    continuoAsignacion();
	}else{
		set(FORMUL + '.txtCodClienteResponsable','');
        focaliza(FORMUL + ".txtCodClienteResponsable");
	}
}

// desea continua: SI, se continúa con la siguiente actividad (actividad 10);
function continuoAsignacion() {
	 var codigoCliente = get(FORMUL + '.txtCodClienteResponsable').toString();
 	 var responsable = listaResultados.extraeDato(listaResultados.codSeleccionados()[0],1);
     if (codigoCliente != '' || responsable == '') {
		 var longitudCodigoCliente = get(FORMUL + '.longitudCodigoCliente').toString();
		 var longitud = codigoCliente.length;
		 var cadena = rellenaCeros(codigoCliente, longitudCodigoCliente, longitud);
		 set(FORMUL + '.txtCodClienteResponsable', cadena);
	     set(FORMUL+ '.hidCodClienteTemp', cadena)
 	 }
	 if (listaResultados.numSelecc() == 0) {
		  GestionarMensaje('50');
	 } else {
		var marca = get(FORMUL + '.cbMarca'); //inc 20289
		var canal = get(FORMUL + '.cbCanal'); //inc 20289
		var codigos = listaResultados.codSeleccionados();
		codigo = codigos[0];

        var codigoUat =listaResultados.extraeDato(codigo, 0);
    
		set(FORMUL + '.accion', 'continuarAsignar');
		set(FORMUL + '.oidUA', codigo);
        
        set(FORMUL + '.hcoddUA', codigoUat);
    
		set(FORMUL + '.indUA', listaResultados.extraeDato(codigo, 3));
    
		set(FORMUL + '.hMarca', marca);
		set(FORMUL + '.hCanal', canal);
		set(FORMUL + '.conectorAction', 'LPAsignarResponsable');

		enviaSICC(FORMUL, '', '', 'N');
	 }
}


// ------------------------------------------------------------------------------------------------------------------------------------------------------------
/*
 * BELC300022921 - dmorello, 28/03/2006
 * Se elimina la siguiente función
 */
/*
function codigoClienteOnBlur() {
	  var codigoCliente = get(FORMUL + '.txtCodClienteResponsable').toString();

	  if (codigoCliente != '') {
		   var longitudCodigoCliente = get(FORMUL + '.longitudCodigoCliente').toString();
		   var longitud = codigoCliente.length;

		   // Se rellena el código de cliente con ceros
		   var cadena = rellenaCeros(codigoCliente, longitudCodigoCliente, longitud);
		   set(FORMUL + '.txtCodClienteResponsable', cadena);
		   // Evalua si existe el codigo de cliente en MAE_CLIEN
		   set(FORMUL + '.conectorAction', 'LPAsignarResponsable');
		   set(FORMUL+ '.hidCodClienteTemp', cadena);
           set(FORMUL+ '.accion', 'validarCliente');
		   deshabilitarHabilitarBoton('botonContenido','btnAsignar', 'D');
		   eval(FORMUL).oculto = 'S';
		   enviaSICC(FORMUL,'','','N');
		   
	  }
}
*/

// ------------------------------------------------------------------------------------------------------------------------------------------------------------
// Agregado por ssantana, 28/11/2005, SICC-GCC-ZON-003
function accionDetalle() {

	// Chequea que se haya seleccionado una unica fila. 
   if (listaResultados.numSelecc() == 0) {
    	  //Mostramos mensaje de error 
    	  GestionarMensaje('UIZON005');
   } else {
		  // Obtenemos el código seleccionado. 
		  var codigosSeleccionados = listaResultados.codSeleccionados(); 
		  var codigo =   codigosSeleccionados[0]; 
		  //alert("CodigosSeleccionados: " + codigosSeleccionados);
		  var oidCliente = listaResultados.extraeDato(codigo, 4);
		  if (oidCliente != undefined && oidCliente != '' ) {
			   var obj = new Object(); 
			   obj.oidResponsableLista = oidCliente;
			   var retornoModal = mostrarModalSICC('LPAsignarResponsable','Detalle',obj);
		  } else {
			   GestionarMensaje("UIZON006"); 
		  }

	}
	 
}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------
function accionModificar() {
	// ssantana, 28/11/2005, SICC-GCC-ZON-003

	// Chequea que se haya seleccionado una unica fila.
    if (listaResultados.numSelecc() == 0) {
   	   // Mostramos mensaje de error 
  	   GestionarMensaje('UIZON005');
    } else {
		// Deshabilitar botón "Modificar"
		deshabilitarHabilitarBoton('botonContenido','Modificar', 'D');

		// Muestro la capa de "Asignar"
		visibilidad('capa2', 'V');
	}

}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------
function onChangeLista(nroFila) {

	// Se dispara cuando se selecciona o deselecciona una fila de la listaEditable.
	// Si se ha seleccionado una fila, habilita el botón Modificar. 
	// Si se ha deseleccionado una fila, lo deshabilita (y oculta la capa de "Asignacion");
	var numSelec = listaResultados.numSelecc();
	var ultimaFilaSelec = listaResultados.filaSelecc;
	//alert("ultimaFilaSelec: " + ultimaFilaSelec + "| nroFila: " + nroFila);

	// Limpia y Oculta capa "Asignacion Responsable"
	set(FORMUL + ".txtCodClienteResponsable", "");
	visibilidad('capa2', 'O');

	if ( parseInt(numSelec, 10) == 1)	{
		// Habilita Botón Modificar
		deshabilitarHabilitarBoton('botonContenido','Modificar', 'A');
	} else if ( parseInt(numSelec, 10) == 0) {
    	// Deshabilita Botón Modificar
		deshabilitarHabilitarBoton('botonContenido','Modificar', 'D');
	} 
}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------
/*
 * BELC300022921 - dmorello, 28/03/2006
 * Se elimina la siguiente función.
 */
/*
function errorClienteBusqueda() {
	set(FORMUL + '.txtCodClienteResponsable', '');
	focaliza(FORMUL + '.txtCodClienteResponsable');
	deshabilitarHabilitarBoton('botonContenido','btnAsignar', 'A');
}
*/

// ------------------------------------------------------------------------------------------------------------------------------------------------------------
/*
 * BELC300022921 - dmorello, 28/03/2006
 * Se elimina la siguiente función.
 */
/*
function validoCliente(oidCliente) {
  set(FORMUL + '.hidOidClienteBusquedaRapida', oidCliente);
  deshabilitarHabilitarBoton('botonContenido','btnAsignar', 'A');
}
*/

// ------------------------------------------------------------------------------------------------------------------------------------------------------------
function visibilidadBotones(estado) {
	var botonDetalle = document.getElementById("Detalle");
	var botonModificar = document.getElementById("Modificar");
	botonDetalle.style.visibility = estado;
	botonModificar.style.visibility = estado;
}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------
//splatas - DBLG400001087 - 27/04/2006
function codZonaOnOff(){
    var rb = get(FORMUL + '.rbResponsable');

    if( rb == "1" || rb == "2"){
        set(FORMUL + '.txtCodZona', '');
        accion(FORMUL + '.txtCodZona', '.disabled=true'); 
        
    }else {
        accion(FORMUL + '.txtCodZona', '.disabled=false');
    }
    
    return true;
}