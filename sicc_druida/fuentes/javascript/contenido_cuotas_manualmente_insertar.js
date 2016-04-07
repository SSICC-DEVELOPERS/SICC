/**
* Copyright 2005 � por Indra Sistemas,S.A.. Todos los derechos reservados.
* Avda. de Bruselas, 35
* Parque Empresarial Arroyo de la Vega
* 28108 Alcobendas, Madrid
* Espa�a
*
* Privado y Confidencial.
* La informaci�n contenida en este documento es propiedad de Indra sistemas.
* Para uso exclusivo de empleados autorizados no permiti�ndose
* la distribuci�n de este c�digo sin permiso expreso.
*/ 

var FORMULARIO = 'Formulario';

function onLoadPag(){
    var errDescripcion = get(FORMULARIO +'.errDescripcion');
    if (errDescripcion !='') {                         
         var errCodigo = get(FORMULARIO+'.errCodigo');
         var wnd = fMostrarMensajeError(errCodigo, errDescripcion);
    }
         
         
	    DrdEnsanchaConMargenDcho('listado1',12);
	    document.all['Cplistado1'].style.visibility='';
	    document.all['CpLin1listado1'].style.visibility='';
	    document.all['CpLin2listado1'].style.visibility='';
	    document.all['CpLin3listado1'].style.visibility='';
	    document.all['CpLin4listado1'].style.visibility='';
	    // Elementos de la lista editable paginada.
	    //document.all['primera1Div'].style.visibility='';
	    //document.all['ret1Div'].style.visibility='';
	    //document.all['ava1Div'].style.visibility='';
	    //document.all['separaDiv'].style.visibility='';
		             
        eval (ON_RSZ);  
        configurarMenuSecundario(FORMULARIO);
         
        focaliza(FORMULARIO+'.textCodCliente');
}

function accionBTN_Buscar(){
	// Documentacion
	// Se crea un DTOBuscarCuotasDtoRecargo (dtoB) que se carga con:
	// dtoB.pais = pa�s de la sesi�n, dtoB.oidEmpresa = oidEmpresa, 
	// dtoB.oidSubproceso = oidSubproceso, dtoB.diasCadencia = diasCadencia
	// dtoB.diasCorte = diasCorte, dtoB.tipoInteres = tipoInteres
	// dtoB.importeFijo = importeFijoDtoRecargo, dtoB.codigoCliente = codigoCliente
	//
	// Invocamos al subsistema:Paginaci�n con:
	// IdBusiness="CCCBuscarCuotasDtoRecargo" ConectorBuscarCuotasDtoRecargo
	// dtoB (DTOBuscarCuotasDtoRecargo)
	//
	// Con el DTOSalida llenamos las filas de la lista "resultados".
	if(sicc_validaciones_generales()) {

		var oidEmpresa = get(FORMULARIO+'.oidEmpresa');
		var oidSubproceso = get(FORMULARIO+'.oidSubproceso');
		var diasCadencia = get(FORMULARIO+'.diasCadencia');
		var diasCorte = get(FORMULARIO+'.diasCorte');
		var tipoInteres = get(FORMULARIO+'.tipoInteres');
		var importeFijoDtoRecargo = get(FORMULARIO+'.importeFijoDtoRecargo');
		var codigoCliente = get(FORMULARIO+'.textCodCliente');

		var pais = get(FORMULARIO+'.pais');
		var idioma = get(FORMULARIO+'.idioma');

		// Esta opci�n es sin el configurarPaginado
		/*set(FORMULARIO+'.accion','rellenar');
		set(FORMULARIO+'.conectorAction', 'LPGenerarDtoRecargo');
		enviaSICC(FORMULARIO);*/
		configurarPaginado(mipgndo,"CCCBuscarCuotasDtoRecargo",
                           "ConectorBuscarCuotasDtoRecargo",
                           "es.indra.sicc.dtos.ccc.DTOBuscarCuotasDtoRecargo", 
							[["oidEmpresa", oidEmpresa],
							["oidSubproceso", oidSubproceso], 
							["diasCadencia", diasCadencia], 
							["diasCorte", diasCorte], 
							["tipoInteres", tipoInteres], 
							["importeFijo", importeFijoDtoRecargo], 
							["codigoCliente", codigoCliente],
							["oidPais", pais],
							["oidIdioma", idioma]]);
	}
}

// Nueva versi�n de accionBTN_Anadir
function accionBTN_Anadir(){
	if (listado1.numSelecc() == 0) {
        	// "Debe seleccionar un elemento de la lista"
		GestionarMensaje('50');
	} else {
		//Se obtienen los c�digos de las filas seleccionadas
		var seleccionados = listado1.codSeleccionados();
		//Se actualiza el array con los datos de la lista editable
		listado1.actualizaDat();
		
		arrayResultados = new Array();
		for (var j = 0; j < seleccionados.length; j++) {
		         for (var i = 0; i < listado1.datos.length; i++) {
		                  if (seleccionados[j] == listado1.datos[i][0]) {
		                           arrayResultados[arrayResultados.length] = listado1.datos[i];
		                           break;
		                  }
		         }
		}
		window.returnValue = arrayResultados;
		window.close();
	}
}

function muestraLista(ultima, rowset){
	var tamano = rowset.length;
	if (tamano > 0) {
		visibleLista();
		DrdEnsanchaConMargenDcho('listado1',12);
		eval (ON_RSZ);
		return true;
   	} else {
		invisibleLista();                      
         	return false;
	}
}

function visibleLista(){
    if (!get_visibilidad('capaLista')){
         visibilidad('capaLista','V');
    }
}

function invisibleLista() {
    if (get_visibilidad('capaLista')){
         visibilidad('capaLista','O');
    }
}  

function accionBTN_BuscarCliente(){    
    var objParams = new Object();
    var cliente = mostrarModalSICC('LPBusquedaRapidaCliente', '', objParams, null, null);           

    if(typeof cliente!='undefined') {
          var codigoClienteHasta = cliente[1];
          set(FORMULARIO+'.textCodCliente',codigoClienteHasta);
    }    
}

function textCodClienteOnBlur() {
    var codigoCliente = get(FORMULARIO+'.textCodCliente').toString();
    if (codigoCliente != '') {
         var longitudCodigoCliente = get(FORMULARIO+'.longitudCodigoCliente').toString();
         var longitud = codigoCliente.length;
         set(FORMULARIO+'.textCodCliente',rellenaCeros(codigoCliente,longitudCodigoCliente,longitud))
    }
}

function fLimpiar(){
	focaliza(FORMULARIO+'.textCodCliente','');                    
}

function fVolver(){
	window.close();
}

function ontabBtnBuscar(){
		// Si la lista es visible voy al siguiente elemento. Si no al principio
		if(!get_visibilidad('capaLista')){
			focaliza(FORMULARIO+'.textCodCliente');
		}
}

function ontabAnadir(){
        focaliza(FORMULARIO+'.textCodCliente');
}

function onshtabTextCodCliente(){
		// Si la lista es visible voy al final de la lista. 
		if(get_visibilidad('capaLista')){
			document.all['anadir'].focus();			
		} else {
			document.all['btnBuscar'].focus();			
		}
}
