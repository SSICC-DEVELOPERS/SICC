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
    $Id: contenido_cursos_insertar.js,v 1.1 2009/12/03 19:02:19 pecbazalar Exp $
    DESC
*/
	var esUltimoGeografico = false;
	var esPrimeroGeografico = false;
	var FORMULARIO = 'formularioInsertarCurso';
	var parametrosRecargaCombos = new Array();
	var DTODruidaBusqueda = 'es.indra.sicc.dtos.edu.DTODruidaBusqueda';

	

	function onLoadPag() {
		if (get('formularioInsertarCurso.errDescripcion') != '') {
				var wnd = fMostrarMensajeError(get('formularioInsertarCurso.errCodigo'), get('formularioInsertarCurso.errDescripcion'));
				window.close();
		}
	  	menuSecundario();

		//El combo cursos está cargado, sólo hay que seleccionar las opciones
		seleccionaStatusCursos();
		//recargarCombosDependientes();
		//alert (get('formularioInsertarCurso.hid_NumeroDecimales') + ' ' + get('formularioInsertarCurso.hid_SeparadorMiles') + ' - ' + get(FORMULARIO + '.hid_SeparadorDecimales'));
		cargaInicial();
		obligaRegalo();
		obligaConstancia();
		obligaVentas();
		if ((get('formularioInsertarCurso.casoUso') != 'consultar' && get('formularioInsertarCurso.casoUso') != 'eliminar') && get('formularioInsertarCurso.primero') != "") {
			focaliza("formularioInsertarCurso." + get('formularioInsertarCurso.primero'));
		}
		if (get('formularioInsertarCurso.casoUso') == 'consultar' || get('formularioInsertarCurso.casoUso') == 'eliminar') {

			//if (eval('document.formularioInsertarCurso.cbEstatusCursos') != undefined)
			//@ssaavedr se cambia por cbCursosExigidos @CHANGELOG 2005.11.17 GMIOTTI DT 

			if (eval('document.formularioInsertarCurso.cbCursosExigidos') != undefined)
				focaliza("formularioInsertarCurso.cbCursosExigidos");
		}
		
		if ((get('formularioInsertarCurso.casoUso') != 'consultar' && get('formularioInsertarCurso.casoUso') != 'eliminar') && get('formularioInsertarCurso.ultimo') != "") {
			if (get('formularioInsertarCurso.ultimo') == 'cbSubVentas') 
        			esUltimoGeografico = true;
			if (get('formularioInsertarCurso.ultimo') == 'cbSubVentas') 
        			esUltimoGeografico = true;
			if (get('formularioInsertarCurso.ultimo') == 'cbRegion') 
        			esUltimoGeografico = true;
			if (get('formularioInsertarCurso.ultimo') == 'cbZona') 
        			esUltimoGeografico = true;
			if (get('formularioInsertarCurso.ultimo') == 'cbSeccion') 
        			esUltimoGeografico = true;
			if (get('formularioInsertarCurso.ultimo') == 'cbTerritorio') 
        			esUltimoGeografico = true;
		}
		camposRequeridos();
    }
    
	function menuSecundario() {
	  	configurarMenuSecundario("formularioInsertarCurso");
	}

	function seleccionaStatusCursos() {
	
		// Se obtienen los cursos seleccionados 
		var statusCursos = get('formularioInsertarCurso.hcbCursosExigidos').toString();
		var seleccionados = statusCursos.split('|');
	
		if (statusCursos != '') {
			set('formularioInsertarCurso.cbCursosExigidos', seleccionados);
		} 
	}

	function cargaInicial() {
			
		//asignar valores a radiobuttons    	
		if (eval('document.formularioInsertarCurso.rbAlcanceGeoNacional') != undefined){
			var alcance = get('formularioInsertarCurso.rbAlcanceGeoNacional'); //por si estamos limpiando el formulario
	    	set('formularioInsertarCurso.rbAlcanceGeoNacional', get('formularioInsertarCurso.hrbAlcanceGeoNacional'));
	    	//si alcance geográfico no es N deshabilitar los combos, en caso contrario los dejamos tal y como los deja la LP (si no ha habido cambio y estamos limpiando el formulario)
	    	if (get('formularioInsertarCurso.hrbAlcanceGeoNacional') != "N")
				modificaAlcanceHabilita(true);
			else if (alcance == "S") //ha habido cambio (el hidden es N y el usuario cambió a S por lo que los combos se deshabilitaron)
				modificaAlcanceHabilita(true);
		}
    	
		if (eval('document.formularioInsertarCurso.rbAccesoSeleccion') != undefined)
    			set('formularioInsertarCurso.rbAccesoSeleccion', get('formularioInsertarCurso.hrbAccesoSeleccion'));
  		//modificaPathObligatorio();
  	
		if (eval('document.formularioInsertarCurso.rbBloqueo') != undefined)
    			set('formularioInsertarCurso.rbBloqueo', get('formularioInsertarCurso.hrbBloqueo'));
  	
		if (eval('document.formularioInsertarCurso.rbCondicionPedido') != undefined)
	    		set('formularioInsertarCurso.rbCondicionPedido', get('formularioInsertarCurso.hrbCondicionPedido'));
  	
		if (eval('document.formularioInsertarCurso.rbControlMorosidad') != undefined)
    			set('formularioInsertarCurso.rbControlMorosidad', get('formularioInsertarCurso.hrbControlMorosidad'));
	}

	function recargarCombosDependientes() {
		parametrosRecargaCombos = new Array();
	  	//recarga de combos dependientes
	    var idioma = get('formularioInsertarCurso.idioma').toString();
		var pais = get('formularioInsertarCurso.pais');
  	
	    var marca = get('formularioInsertarCurso.hcbMarca');
	    if (marca != "")
    		gestionaCombo('cbTipoCurso', 'CMNObtieneTiposCurso', 'es.indra.sicc.dtos.edu.DTODruidaBusqueda', [["oidPais", pais], ["oidIdioma", idioma], ["oidMarca", marca]], "seleccionaTipocurso(datos)");
   	
    	var canal = get('formularioInsertarCurso.hcbCanal');
    	if (canal != "")
    		gestionaCombo('cbAccesoInfo', 'CMNObtieneAccesos', 'es.indra.sicc.dtos.edu.DTODruidaBusqueda', [["oidPais", pais], ["oidIdioma", idioma], ["oidCanal", canal]], "seleccionaAccesos(datos)");
    	
    	if (canal != "" && marca != "")
    		recargaCombosDepCanalMarca(marca, canal, idioma, pais);
	
    	var subgerencia = get('formularioInsertarCurso.hcbSubVentas');
    	if (subgerencia != "")
    		gestionaCombo('cbRegion', 'CMNObtieneRegiones', 'es.indra.sicc.dtos.edu.DTODruidaBusqueda', [["oidPais", pais], ["oidIdioma", idioma], ["oidSubgerencia", subgerencia]], "seleccionaRegion(datos)");
    	
    	var region = get('formularioInsertarCurso.hcbRegion');
    	if (region != "")
    		gestionaCombo('cbZona', 'CMNObtieneZonas', 'es.indra.sicc.dtos.edu.DTODruidaBusqueda', [["oidPais", pais], ["oidIdioma", idioma], ["oidRegion", region]], "seleccionaZona(datos)");

    	var zona = get('formularioInsertarCurso.hcbZona');
    	if (zona != "")
    		gestionaCombo('cbSeccion', 'CMNObtieneSecciones', 'es.indra.sicc.dtos.edu.DTODruidaBusqueda', [["oidPais", pais], ["oidIdioma", idioma], ["oidZona", zona]], "seleccionaSeccion(datos)");

    	var seccion = get('formularioInsertarCurso.hcbSeccion');
    	if (seccion != "")
    		gestionaCombo('cbTerritorio', 'CMNObtieneTerritorios', 'es.indra.sicc.dtos.edu.DTODruidaBusqueda', [["oidPais", pais], ["oidIdioma", idioma], ["oidSeccion", seccion]], "seleccionaTerritorio(datos)");

    	var tipoCliente = get('formularioInsertarCurso.hcbTipoCliente');
    	if (tipoCliente != "")
    		gestionaCombo('cbSubtipoCliente', 'CMNObtieneSubtiposCliente', 'es.indra.sicc.dtos.edu.DTODruidaBusqueda', [["oidPais", pais], ["oidIdioma", idioma], ["oidTipoCliente", tipoCliente]], "seleccionaSubtipoCliente(datos)");

    	var subtipoCliente = get('formularioInsertarCurso.hcbSubtipoCliente');
    	if (subtipoCliente != "")
    		gestionaCombo('cbTipoClasificacion', 'CMNObtieneTiposClasificacion', 'es.indra.sicc.dtos.edu.DTODruidaBusqueda', [["oidPais", pais], ["oidIdioma", idioma], ["oidSubtipoCliente", subtipoCliente]], "seleccionaTipoClasificacion(datos)");

    	var tipoClasificacion = get('formularioInsertarCurso.hcbTipoClasificacion');
    	if (subtipoCliente != "" && tipoClasificacion != "")
    		gestionaCombo('cbClasificacion', 'CMNObtieneClasificaciones', 'es.indra.sicc.dtos.edu.DTODruidaBusqueda', [["oidPais", pais], ["oidIdioma", idioma], ["oidSubtipoCliente", subtipoCliente], ["oidTipoClasificacion", tipoClasificacion]], "seleccionaClasificacion(datos)");

    	var tipoCurso = get('formularioInsertarCurso.hcbTipoCurso');
	    if (tipoCurso != "") {
				gestionaCombo('cbCapacitador', 'CMNObtieneCapacitadores', 'es.indra.sicc.dtos.edu.DTODruidaBusqueda', [["oidPais", pais], ["oidIdioma", idioma], ["oidTipoCurso", tipoCurso]], "seleccionaCapacitador(datos)");
		}

		recargaComboMultiple(parametrosRecargaCombos); 
		parametrosRecargaCombos = new Array();
	
}


	function incluyeOpcionVacia(datos) {
		var datos2=new Array();
		datos2[0]=["",""];//La opción vacía
		for (var i=0;i<datos.length;i++)
    		datos2[datos2.length]=datos[i];
		return datos2;
	}


	function seleccionaClasificacion(datos) {
		var clasificacion = get('formularioInsertarCurso.hcbClasificacion');
		set_combo('formularioInsertarCurso.cbClasificacion', incluyeOpcionVacia(datos));
		set('formularioInsertarCurso.cbClasificacion', [clasificacion]);
	}

	function seleccionaTipoClasificacion(datos) {
		var tipoClasificacion = get('formularioInsertarCurso.hcbTipoClasificacion');
		set_combo('formularioInsertarCurso.cbTipoClasificacion', incluyeOpcionVacia(datos));
		set('formularioInsertarCurso.cbTipoClasificacion', [tipoClasificacion]);
	}

	function seleccionaSubtipoCliente(datos) {
		var subtipoCliente = get('formularioInsertarCurso.hcbSubtipoCliente');
		set_combo('formularioInsertarCurso.cbSubtipoCliente', incluyeOpcionVacia(datos));
		set('formularioInsertarCurso.cbSubtipoCliente', [subtipoCliente]);
	}

	function seleccionaTerritorio(datos) {
		var territorio = get('formularioInsertarCurso.hcbTerritorio');
		set_combo('formularioInsertarCurso.cbTerritorio', incluyeOpcionVacia(datos));
		set('formularioInsertarCurso.cbTerritorio', [territorio]);
	}

	function seleccionaSeccion(datos) {
		var seccion = get('formularioInsertarCurso.hcbSeccion');
		set_combo('formularioInsertarCurso.cbSeccion', incluyeOpcionVacia(datos));
		set('formularioInsertarCurso.cbSeccion', [seccion]);
	}

	function seleccionaZona(datos) {
		var zona = get('formularioInsertarCurso.hcbZona');
		set_combo('formularioInsertarCurso.cbZona', incluyeOpcionVacia(datos));
		set('formularioInsertarCurso.cbZona', [zona]);
	}

	function recargaCombosDepCanalMarca(marca, canal, idioma, pais) {
		//cbEstatusCursos, cbPeriodos, cmbSubgerencias 
		var cursos = get('formularioInsertarCurso.hcbCursosExigidos');
		//if (cursos != "" || (get('formularioInsertarCurso.casoUso') != 'consultar' && get('formularioInsertarCurso.casoUso') != 'eliminar'))
    	// SCS, se cambia el conector por: CMNObtieneTiposCurso gestionaCombo('cbCursosExigidos', 'CMNObtieneCursos', 'es.indra.sicc.dtos.edu.DTODruidaBusqueda', [["oidPais", pais], ["oidIdioma", idioma], ["oidCanal", canal], ["oidMarca", marca]], "seleccionaCursos(datos)");

        gestionaCombo('cbCursosExigidos', 'CMNObtieneTiposCurso', 'es.indra.sicc.dtos.edu.DTODruidaBusqueda', [["oidPais", pais], ["oidIdioma", idioma], ["oidCanal", canal], ["oidMarca", marca]], "seleccionaCursos(datos)");
    	gestionaCombo('cbPerConstInicio', 'CMNObtienePeriodos', 'es.indra.sicc.dtos.edu.DTODruidaBusqueda', [["oidPais", pais], ["oidIdioma", idioma], ["oidCanal", canal], ["oidMarca", marca]], "seleccionaPeriodos(datos)");
		if (eval('document.formularioInsertarCurso.rbAlcanceGeoNacional') != undefined && get('formularioInsertarCurso.rbAlcanceGeoNacional').toString() == "N")
    		gestionaCombo('cbSubVentas', 'CMNObtieneSubgerenciasVentas', 'es.indra.sicc.dtos.edu.DTODruidaBusqueda', [["oidPais", pais], ["oidIdioma", idioma], ["oidCanal", canal], ["oidMarca", marca]], "seleccionaSubVentas(datos)");
    	return true;
	}

	function seleccionaRegion(datos) {
		var region = get('formularioInsertarCurso.hcbRegion');
		set_combo('formularioInsertarCurso.cbRegion', incluyeOpcionVacia(datos));
		set('formularioInsertarCurso.cbRegion', [region]);
	}

	function seleccionaSubVentas(datos) {
		var subventas = get('formularioInsertarCurso.hcbSubVentas');
		set_combo('formularioInsertarCurso.cbSubVentas', incluyeOpcionVacia(datos));
		set('formularioInsertarCurso.cbSubVentas', [subventas]);
	}

	function seleccionaPeriodos(datos) {
		
		if (eval('document.formularioInsertarCurso.cbPerConstInicio') != undefined) {
			var periodos = get('formularioInsertarCurso.hcbPerConstInicio');
			set_combo('formularioInsertarCurso.cbPerConstInicio', incluyeOpcionVacia(datos));
			set('formularioInsertarCurso.cbPerConstInicio', [periodos]);
		}
		if (eval('document.formularioInsertarCurso.cbPerConstFin') != undefined) {
			var periodos = get('formularioInsertarCurso.hcbPerConstFin');
			set_combo('formularioInsertarCurso.cbPerConstFin', incluyeOpcionVacia(datos));
			set('formularioInsertarCurso.cbPerConstFin', [periodos]);
		}
		if (eval('document.formularioInsertarCurso.cbPerVentInicio') != undefined) {
			var periodos = get('formularioInsertarCurso.hcbPerVentInicio');
			set_combo('formularioInsertarCurso.cbPerVentInicio', incluyeOpcionVacia(datos));
			set('formularioInsertarCurso.cbPerVentInicio', [periodos]);
		}
		if (eval('document.formularioInsertarCurso.cbPerVentFin') != undefined) {
			var periodos = get('formularioInsertarCurso.hcbPerVentFin');
			set_combo('formularioInsertarCurso.cbPerVentFin', incluyeOpcionVacia(datos));
			set('formularioInsertarCurso.cbPerVentFin', [periodos]);
		}
		if (eval('document.formularioInsertarCurso.cbPerIngresoCondicion') != undefined) {
			var periodos = get('formularioInsertarCurso.hcbPerIngresoCondicion');
			set_combo('formularioInsertarCurso.cbPerIngresoCondicion', incluyeOpcionVacia(datos));
			set('formularioInsertarCurso.cbPerIngresoCondicion', [periodos]);
		}
	}

	function seleccionaCursos(datos) {
		var cursos = get('formularioInsertarCurso.hcbCursosExigidos');
		if (get('formularioInsertarCurso.casoUso') == 'consultar' || get('formularioInsertarCurso.casoUso') == 'eliminar') {
			var cursosSeleccion = cursos.split("|");
			var arraySeleccionados = new Array();
			for ( i = 0 ; i < datos.length; i++) {
				for (j = 0; j < cursosSeleccion.length; j++) {
					if (cursosSeleccion[j] == datos[i][0]) //opcion seleccionada
						arraySeleccionados[arraySeleccionados.length] = datos[i];
				}
			}
			datos = arraySeleccionados;
				set_combo('formularioInsertarCurso.cbCursosExigidos', datos);
				set('formularioInsertarCurso.cbCursosExigidos', cursos.split("|"));
		} else {
			set_combo('formularioInsertarCurso.cbCursosExigidos', datos);
			set('formularioInsertarCurso.cbCursosExigidos', cursos.split("|"));
		}
	}

	function seleccionaAccesos(datos) {
		var acceso = get('formularioInsertarCurso.hcbAccesoInfo');
		set_combo('formularioInsertarCurso.cbAccesoInfo', incluyeOpcionVacia(datos));
		set('formularioInsertarCurso.cbAccesoInfo', [acceso]);
	}


	function seleccionaCapacitador(datos) {
		var capacitador = get('formularioInsertarCurso.hcbCapacitador');
		set_combo('formularioInsertarCurso.cbCapacitador', incluyeOpcionVacia(datos));
		set('formularioInsertarCurso.cbCapacitador', [capacitador]);
	}


	function seleccionaTipocurso(datos) {
    	var tipoCurso = get('formularioInsertarCurso.hcbTipoCurso');
		set_combo('formularioInsertarCurso.cbTipoCurso', incluyeOpcionVacia(datos));
		set('formularioInsertarCurso.cbTipoCurso', [tipoCurso]);
	}

	function gestionaCapacitador(combo, idBusiness, dto, valoresEntrada, funcion) {
		if (eval('document.formularioInsertarCurso.'+combo) != undefined) {
			valoresSeleccion=get('formularioInsertarCurso.h'+combo);
			if ( valoresSeleccion != "")
				asignar([["COMBO", 'formularioInsertarCurso.'+combo, "ConectorDruidaTransactionQuery", 'dtoSalida.resultado_ROWSET', formarCadenaDT(idBusiness, dto, valoresEntrada), funcion]],"","");
			else
				recargaCombo('formularioInsertarCurso.'+combo, idBusiness, dto, valoresEntrada);
		}
	}

	//Utilizado para la recarga de combos dependientes al limpiar el formulario
	function gestionaCombo(combo, idBusiness, dto, valoresEntrada, funcion) {
		if (eval('document.formularioInsertarCurso.' + combo) != undefined) {
				var parametros = new Array();
     			parametros[0] = FORMULARIO + '.' + combo;   
     			parametros[1] = idBusiness;
     			parametros[2] = dto;
     			parametros[3] = arrayToString(valoresEntrada); //nos llegan como un array, debemos formatearlo a cadena
     			parametros[4] = funcion;
     			parametrosRecargaCombos[parametrosRecargaCombos.length] = parametros;
    	}
	}

function arrayToString(valoresEntrada) {
	var cadena = "[]";
	if (valoresEntrada != null && valoresEntrada.length > 0) {
		cadena = "[";
		for (i = 0; i < valoresEntrada.length; i++) {
			cadena += "['" + valoresEntrada[i][0] + "', " + valoresEntrada[i][1] + "]";
			if (i < valoresEntrada.length-1) cadena += ", ";
		}
		cadena += "]";
	}
	return cadena
}
	//si existe valor a seleccionar para el combo almacenado en campo oculto, se recarga y selecciona.
	//Si no existe,se realiza una recarga simple
	function gestionaComboRO(combo, idBusiness, dto, valoresEntrada, funcion) {
		if (eval('document.formularioInsertarCurso.'+combo) != undefined) {
			if(get('formularioInsertarCurso.'+combo+'RO') == "S")
    			asignar([["COMBO", 'formularioInsertarCurso.'+combo, "ConectorDruidaTransactionQuery", 'dtoSalida.resultado_ROWSET', formarCadenaDT(idBusiness, dto, valoresEntrada), funcion]],"","");
    		else
    			recargaCombo('formularioInsertarCurso.'+combo, idBusiness, dto, valoresEntrada);
    	}
	}

	//onSeleccionaMarca: 
	function cargaCombosDepMarca() {
		//cbTiposCurso, cbEstatusCursos, cbPeriodos, cbSubgerencias (marca)
		vaciaCombo('formularioInsertarCurso.cbCapacitador');
    	vaciaCombo('formularioInsertarCurso.cbTipoCurso');
		vaciaCombosDepCanalMarca();

    	var marca = get(FORMULARIO + '.cbMarca');
    	var canal = get(FORMULARIO + '.cbCanal');
    	var idioma = get(FORMULARIO + '.idioma');
    	var pais = get(FORMULARIO + '.pais');

    	if (marca != "") {
			parametrosRecargaCombos = new Array();
    		if (canal != "") {
    			cargaCombosDepCanalMarca();
    		}
    		//cbTiposCurso
    		if (eval('document.' + FORMULARIO + '.cbTipoCurso') != undefined) {
				var parametros = new Array();
     			parametros[0] = FORMULARIO + '.cbTipoCurso';   
     			parametros[1] = "CMNObtieneTiposCurso";
     			parametros[2] = DTODruidaBusqueda;
     			parametros[3] = "[['oidMarca', " + marca + "], ['oidIdioma'," + idioma + "], ['oidPais'," + pais + "]]";
     			parametros[4] = "seleccionaTipoCursoRO(datos)";
     			parametrosRecargaCombos[parametrosRecargaCombos.length] = parametros;
    		}
			recargaComboMultiple(parametrosRecargaCombos); 
			parametrosRecargaCombos = new Array();
    	} 
    	
        return true;
	}

	//onSeleccionaCanal: 
	function cargaCombosDepCanal() {
		//cbEstatusCursos, cmbAccesos, cmbPeriodos, cmbSubgerencias 
		vaciaCombo(FORMULARIO + '.cbAccesoInfo');
		vaciaCombosDepCanalMarca();

    	var marca = get(FORMULARIO + '.cbMarca');
    	var canal = get(FORMULARIO + '.cbCanal').toString();
    	var idioma = get(FORMULARIO + '.idioma').toString();
    	var pais = get(FORMULARIO + '.pais');

    	if (canal != "") {
			parametrosRecargaCombos = new Array();
    		if (marca != "")
    			cargaCombosDepCanalMarca();
	    	//cmbAccesos 
			if (eval('document.' + FORMULARIO + '.cbAccesoInfo') != undefined) {
				var parametros = new Array();
     			parametros[0] = FORMULARIO + '.cbAccesoInfo';   
     			parametros[1] = "CMNObtieneAccesos";
     			parametros[2] = DTODruidaBusqueda;
     			parametros[3] = "[['oidCanal', " + canal + "], ['oidIdioma'," + idioma + "], ['oidPais'," + pais + "]]";
     			if(get(FORMULARIO + '.cbAccesoInfoRO') == "S")
     				parametros[4] = "seleccionaAccesosRO(datos)";
     			parametrosRecargaCombos[parametrosRecargaCombos.length] = parametros;
    		}
			recargaComboMultiple(parametrosRecargaCombos); 
			parametrosRecargaCombos = new Array();
	    } 
        return true;
	}


	// Carga los combos que dependen de marca y canal
	function cargaCombosDepCanalMarca() {
		
		var idioma = get(FORMULARIO+'.idioma').toString();
		var pais = get(FORMULARIO+'.pais').toString();

		var marca = get(FORMULARIO+'.cbMarca').toString();
		var canal = get(FORMULARIO+'.cbCanal').toString();
		
		var parametros = new Array(5);
		//cbEstatusCursos, cbPeriodos, cmbSubgerencias 
		if (eval('document.formularioInsertarCurso.cbCursosExigidos') != undefined) {
     		parametros[0] = FORMULARIO+'.cbCursosExigidos';   
     		//SCS se cambia por: CMNObtieneTiposCurso parametros[1] = "CMNObtieneCursos";
			parametros[1] = "CMNObtieneTiposCurso";
     		parametros[2] = DTODruidaBusqueda;
     		parametros[3] = "[['oidMarca', " + marca + "], ['oidCanal', " + canal + "], ['oidIdioma'," + idioma + "], ['oidPais'," + pais + "]]";
     		parametros[4] = "seleccionaCursosRO(datos)";
     		parametrosRecargaCombos[parametrosRecargaCombos.length] = parametros;
       }
         	
		parametros = new Array(5);
     	parametros[0] = FORMULARIO+'.cbPerConstInicio';   
     	parametros[1] = "CMNObtienePeriodos";
     	parametros[2] = DTODruidaBusqueda;
     	parametros[3] = "[['oidMarca', " + marca + "], ['oidCanal', " + canal + "], ['oidIdioma'," + idioma + "], ['oidPais'," + pais + "]]";
     	parametros[4] = "cargaPeriodosRO(datos)";
     	parametrosRecargaCombos[parametrosRecargaCombos.length] = parametros;

		if (eval('document.formularioInsertarCurso.cbSubVentas') != undefined && eval('document.formularioInsertarCurso.rbAlcanceGeoNacional') != undefined && get('formularioInsertarCurso.rbAlcanceGeoNacional').toString() == "N") {
			parametros = new Array(5);
     		parametros[0] = FORMULARIO+'.cbSubVentas';   
     		parametros[1] = "CMNObtieneSubgerenciasVentas";
     		parametros[2] = DTODruidaBusqueda;
     		parametros[3] = "[['oidMarca', " + marca + "], ['oidCanal', " + canal + "], ['oidIdioma'," + idioma + "], ['oidPais'," + pais + "]]";
     		parametros[4] = "seleccionaSubVentasRO(datos)";
     		parametrosRecargaCombos[parametrosRecargaCombos.length] = parametros;
	    }
	    return true;
	}

	function cargaPeriodosRO(datos) {
		
		if (eval('document.formularioInsertarCurso.cbPerConstInicio') != undefined) {
			set_combo('formularioInsertarCurso.cbPerConstInicio', incluyeOpcionVacia(datos));
			if (get('formularioInsertarCurso.cbPerConstInicioRO') == "S" && typeof(datos) != 'undefined' && datos.length > 0)
				set('formularioInsertarCurso.cbPerConstInicio', [datos[0][0]]);
		}
		if (eval('document.formularioInsertarCurso.cbPerConstFin') != undefined) {
			set_combo('formularioInsertarCurso.cbPerConstFin', incluyeOpcionVacia(datos));
			if (get('formularioInsertarCurso.cbPerConstFinRO') == "S" && typeof(datos) != 'undefined' && datos.length > 0) 
				set('formularioInsertarCurso.cbPerConstFin', [datos[0][0]]);
		}
		if (eval('document.formularioInsertarCurso.cbPerVentInicio') != undefined) {
			set_combo('formularioInsertarCurso.cbPerVentInicio', incluyeOpcionVacia(datos));
			if (get('formularioInsertarCurso.cbPerVentInicioRO') == "S" && typeof(datos) != 'undefined' && datos.length > 0) 
				set('formularioInsertarCurso.cbPerVentInicio', [datos[0][0]]);
		}
		if (eval('document.formularioInsertarCurso.cbPerVentFin') != undefined) {
			set_combo('formularioInsertarCurso.cbPerVentFin', incluyeOpcionVacia(datos));
			if (get('formularioInsertarCurso.cbPerVentFinRO') == "S" && typeof(datos) != 'undefined' && datos.length > 0) 
				set('formularioInsertarCurso.cbPerVentFin', [datos[0][0]]);
		}
		if (eval('document.formularioInsertarCurso.cbPerIngresoCondicion') != undefined) {
			set_combo('formularioInsertarCurso.cbPerIngresoCondicion', incluyeOpcionVacia(datos));
			if (get('formularioInsertarCurso.cbPerIngresoCondicionRO') == "S" && typeof(datos) != 'undefined' && datos.length > 0) 
				set('formularioInsertarCurso.cbPerIngresoCondicion', [datos[0][0]]);
		}
	}


	function vaciaCombo(combo) {
		if (eval('document.'+combo) != undefined) 
			set_combo(combo,[['','']],['']);
		return true;
	}

	function vaciaCombosDepCanalMarca() {
		//cbEstatusCursos, cbPeriodos, cmbSubgerencias 
		vaciaCombo('formularioInsertarCurso.cbCursosExigidos');
		vaciaCombo('formularioInsertarCurso.cbPerConstInicio');
		vaciaCombo('formularioInsertarCurso.cbPerConstFin');
		vaciaCombo('formularioInsertarCurso.cbPerVentInicio');
		vaciaCombo('formularioInsertarCurso.cbPerVentFin');
		vaciaCombo('formularioInsertarCurso.cbPerIngresoCondicion');
		vaciaCombo('formularioInsertarCurso.cbSubVentas');
		vaciaCombo('formularioInsertarCurso.cbRegion');
		vaciaCombo('formularioInsertarCurso.cbZona');
		vaciaCombo('formularioInsertarCurso.cbSeccion');
		vaciaCombo('formularioInsertarCurso.cbTerritorio');
		return true;
	}

	//onSeleccionaTipoCliente: 
	function cargaComboSubtiposCliente() {

		vaciaCombo('formularioInsertarCurso.cbTipoClasificacion');
		vaciaCombo('formularioInsertarCurso.cbClasificacion');
		var tipoCliente = get('formularioInsertarCurso.cbTipoCliente');
		var pais = get('formularioInsertarCurso.pais');
		var idioma = get('formularioInsertarCurso.idioma');
	    if (tipoCliente != "") {
        	if (eval('document.formularioInsertarCurso.cbSubtipoCliente') != undefined)
				gestionaComboSubtipoClienteRO('cbSubtipoCliente', 'CMNObtieneSubtiposCliente', 'es.indra.sicc.dtos.edu.DTODruidaBusqueda', [["oidPais", pais], ["oidIdioma", idioma], ["oidTipoCliente", tipoCliente]], "seleccionaSubtipoClienteRO(datos)");
		} else 
			vaciaCombo('formularioInsertarCurso.cbSubtipoCliente');
	    return true;
	}

	//onSeleccionaSubtipoCliente: 
	function cargaComboTipoClasificacion() {

		vaciaCombo('formularioInsertarCurso.cbClasificacion');
		var subtipoCliente = get('formularioInsertarCurso.cbSubtipoCliente').toString();
	    var idioma = get('formularioInsertarCurso.idioma').toString();
	    var pais = get('formularioInsertarCurso.pais').toString();
	    if (subtipoCliente != "") {
			if (eval('document.formularioInsertarCurso.cbTipoClasificacion') != undefined)
				gestionaComboTipoClasificacionRO('cbTipoClasificacion', 'CMNObtieneTiposClasificacion', 'es.indra.sicc.dtos.edu.DTODruidaBusqueda', [["oidPais", pais], ["oidIdioma", idioma], ["oidSubtipoCliente", subtipoCliente]], "seleccionaTipoClasificacionRO(datos)");
		} else
			vaciaCombo('formularioInsertarCurso.cbTipoClasificacion');
	    return true;
	}

	//onSeleccionaTipoClasificacion: 
	function cargaComboClasificacion() {

		var subtipoCliente = get('formularioInsertarCurso.cbSubtipoCliente').toString();
		var tipoClasificacion = get('formularioInsertarCurso.cbTipoClasificacion').toString();
	    var idioma = get('formularioInsertarCurso.idioma').toString();
	    var pais = get('formularioInsertarCurso.pais').toString();
	    if (subtipoCliente != "" && tipoClasificacion != "") {
			if (eval('document.formularioInsertarCurso.cbClasificacion') != undefined)
				gestionaComboRO('cbClasificacion', 'CMNObtieneClasificaciones', 'es.indra.sicc.dtos.edu.DTODruidaBusqueda', [["oidPais", pais], ["oidIdioma", idioma], ["oidSubtipoCliente", subtipoCliente], ["oidTipoClasificacion", tipoClasificacion]], "seleccionaClasificacionRO(datos)");
		} else
			vaciaCombo('formularioInsertarCurso.cbClasificacion');
	    return true;
	}

	//onSeleccionaSubgerencia: 
	function cargaComboRegion() {
        vaciaCombo('formularioInsertarCurso.cbZona');
        vaciaCombo('formularioInsertarCurso.cbSeccion');
        vaciaCombo('formularioInsertarCurso.cbTerritorio');
	    var idioma = get('formularioInsertarCurso.idioma').toString();
	    var pais = get('formularioInsertarCurso.pais').toString();

		var subgerencia = get('formularioInsertarCurso.cbSubVentas');
		var regionSel = get('formularioInsertarCurso.hcbRegion');
	    if (subgerencia != "") {
			if (eval('document.formularioInsertarCurso.cbRegion') != undefined)
				gestionaComboRegionRO('cbRegion', 'CMNObtieneRegiones', 'es.indra.sicc.dtos.edu.DTODruidaBusqueda', [["oidPais", pais], ["oidIdioma", idioma], ["oidSubgerencia", subgerencia]], "seleccionaRegionRO(datos)");
		} else 
			vaciaCombo('formularioInsertarCurso.cbRegion');
	    return true;
	}

	//onSeleccionaRegion: 
	function cargaComboZona() {
		vaciaCombo('formularioInsertarCurso.cbSeccion');
        vaciaCombo('formularioInsertarCurso.cbTerritorio');
	    var idioma = get('formularioInsertarCurso.idioma').toString();
	    var pais = get('formularioInsertarCurso.pais').toString();

		var region = get('formularioInsertarCurso.cbRegion').toString();
	    if (region != "") {
        	if (eval('document.formularioInsertarCurso.cbZona') != undefined)
				gestionaComboZonaRO('cbZona', 'CMNObtieneZonas', 'es.indra.sicc.dtos.edu.DTODruidaBusqueda', [["oidPais", pais], ["oidIdioma", idioma], ["oidRegion", region]], "seleccionaZonaRO(datos)");
		} else
			vaciaCombo('formularioInsertarCurso.cbZona');
       	return true;
	}

	//onSeleccionaZona: 
	function cargaComboSeccion() {

        vaciaCombo('formularioInsertarCurso.cbTerritorio');
		var zona = get('formularioInsertarCurso.cbZona').toString();
	    var idioma = get('formularioInsertarCurso.idioma').toString();
	    var pais = get('formularioInsertarCurso.pais').toString();
	    if (zona != "") {
        	if (eval('document.formularioInsertarCurso.cbSeccion') != undefined)
				gestionaComboSeccionRO('cbSeccion', 'CMNObtieneSecciones', 'es.indra.sicc.dtos.edu.DTODruidaBusqueda', [["oidPais", pais], ["oidIdioma", idioma], ["oidZona", zona]], "seleccionaSeccionRO(datos)");
		} else
			vaciaCombo('formularioInsertarCurso.cbSeccion');
	    return true;
	}

	//onSeleccionaSeccion: 
	function cargaComboTerritorio() {

	    var idioma = get('formularioInsertarCurso.idioma').toString();
	    var pais = get('formularioInsertarCurso.pais').toString();
		var seccion = get('formularioInsertarCurso.cbSeccion').toString();
     	if (seccion != "") {
	        if (eval('document.formularioInsertarCurso.cbTerritorio') != undefined)
				gestionaComboRO('cbTerritorio', 'CMNObtieneTerritorios', 'es.indra.sicc.dtos.edu.DTODruidaBusqueda', [["oidPais", pais], ["oidIdioma", idioma], ["oidSeccion", seccion]], "seleccionaTerritorioRO(datos)");
		} else
			vaciaCombo('formularioInsertarCurso.cbTerritorio');
        return true;
	}

	//onSeleccionaTipoCurso
	function cargaComboCapacitador() {

		var tipoCurso = get('formularioInsertarCurso.cbTipoCurso').toString();
    	var idioma = get('formularioInsertarCurso.idioma').toString();
	    var pais = get('formularioInsertarCurso.pais').toString();
     	if (tipoCurso != "") {
        	if (eval('document.formularioInsertarCurso.cbCapacitador') != undefined)
				gestionaComboRO('cbCapacitador', 'CMNObtieneCapacitadores', 'es.indra.sicc.dtos.edu.DTODruidaBusqueda', [["oidPais", pais], ["oidIdioma", idioma], ["oidTipoCurso", tipoCurso]], "seleccionaCapacitadorRO(datos)");
		} else
			vaciaCombo('formularioInsertarCurso.cbCapacitador');
	        return true;
	}


	//onSeleccionaCapacitador
	function cargaValoresOcultosCapacitador() {
	    
	}

	//valida la fecha si el campo es modificable y no vacío 
	function validaFecha(fecha) {
		if(eval('formularioInsertarCurso.'+fecha+'RO') != "S"){
			if (get('formularioInsertarCurso.'+fecha).toString() != ""){
				var resul = EsFechaValida(get('formularioInsertarCurso.'+fecha),get('formularioInsertarCurso.'+fecha), FORMULARIO,null);
	 			if(resul==1 || resul==2){  
         			var strCaja = 'formularioInsertarCurso.'+fecha;
					GestionarMensaje('947', null);
					focaliza(strCaja);
					return false;
				}
			}       			
		} 
		
	}

	//valida la fecha si el campo es modificable y no vacío 
	function validaFechaGuardar(fecha) {
		if(eval('formularioInsertarCurso.' + fecha + 'RO') != "S"){
			if (get('formularioInsertarCurso.' + fecha).toString() != "") {
				var resul = EsFechaValida(get('formularioInsertarCurso.'+fecha),get('formularioInsertarCurso.' + fecha), FORMULARIO,null);
	 			if(resul == 1 || resul == 2) {  
         			//var strCaja = 'formularioInsertarCurso.'+fecha;
					//GestionarMensaje('947', null);
					//focaliza(strCaja);
					document.body.focus();
					return false;
				}
			}       			
		}
		return true;
		
	}


	//valida entero si el campo es modificable y no vacío 
	function validaEntero(nombreElemento) {
		if (eval('formularioInsertarCurso.'+nombreElemento+'RO') != "S") {
			if (get('formularioInsertarCurso.'+nombreElemento).toString() != "")
				//Como no nos interesa validar el número de dígitos que tiene el entero ponemos uno suficientemente grande.
				if (ValidaInt(get('formularioInsertarCurso.'+nombreElemento).toString(), 10000, 0)!="OK") {
					GestionarMensaje('747', null, null, null);
					focaliza('formularioInsertarCurso.'+nombreElemento);
					return false;
				} 
		} 
	}


	//valida entero si el campo es modificable y no vacío 
	function validaEnteroGuardar(nombreElemento) {
		if (eval('formularioInsertarCurso.'+nombreElemento+'RO') != "S") {
			if (get('formularioInsertarCurso.'+nombreElemento).toString() != "")
				//Como no nos interesa validar el número de dígitos que tiene el entero ponemos uno suficientemente grande.
				if (ValidaInt(get('formularioInsertarCurso.'+nombreElemento).toString(), 10000, 0)!="OK") {
					document.body.focus();
					return false;
				} 
		} 
		return true;
	}

	//Si alcance es "N" se habilitan los siguientes campos (para los casos de uso que no sean 'consultar')
	function modificaAlcanceHabilita(limpiando){
  		if (get('formularioInsertarCurso.casoUso') != "consultar" ) {
  				vaciaCombo('formularioInsertarCurso.cbRegion');
				vaciaCombo('formularioInsertarCurso.cbZona');
				vaciaCombo('formularioInsertarCurso.cbSeccion');
				vaciaCombo('formularioInsertarCurso.cbTerritorio');

			if (get('formularioInsertarCurso.rbAlcanceGeoNacional').toString() == "N") {
				//habilitar
				for (var i = 0; i < objValidacionSICC.length; i++) {
						if (objValidacionSICC[i].nombre == 'cbSubVentas' ||
								objValidacionSICC[i].nombre == 'cbRegion' ||
								objValidacionSICC[i].nombre == 'cbZona' ||
								objValidacionSICC[i].nombre == 'cbSeccion' ||
								objValidacionSICC[i].nombre == 'cbTerritorio') {

								//objValidacionSICC[i].requerido = true; //Modif x Incidencia Loca

								var	requerido = get('formularioInsertarCurso.' + objValidacionSICC[i].nombre + 'REQ');
   								if (requerido == "S") {
					     			objValidacionSICC[i].requerido = true;
					     		}
																
						}		  
     				}	 


        		if (eval('document.formularioInsertarCurso.cbSubVentas') != undefined && get('formularioInsertarCurso.cbSubVentasRO') == "N") {
        			accion('formularioInsertarCurso.cbSubVentas', '.disabled=false')
				} 
        		if (eval('document.formularioInsertarCurso.cbRegion') != undefined && get('formularioInsertarCurso.cbRegionRO') == "N") {
        			accion('formularioInsertarCurso.cbRegion', '.disabled=false')
				} 
        		if (eval('document.formularioInsertarCurso.cbZona') != undefined && get('formularioInsertarCurso.cbZonaRO') == "N") {
        			accion('formularioInsertarCurso.cbZona', '.disabled=false')
				} 
        		if (eval('document.formularioInsertarCurso.cbSeccion') != undefined && get('formularioInsertarCurso.cbSeccionRO') == "N") {
        			accion('formularioInsertarCurso.cbSeccion', '.disabled=false')
				} 
        		if (eval('document.formularioInsertarCurso.cbTerritorio') != undefined && get('formularioInsertarCurso.cbTerritorioRO') == "N") {
        			accion('formularioInsertarCurso.cbTerritorio', '.disabled=false')
				}

				if (!limpiando) {
					//incidencia 5746
					parametrosRecargaCombos = new Array();
					if (eval('document.formularioInsertarCurso.cbSubVentas') != undefined ) {
		    			var marca = get(FORMULARIO + '.cbMarca');
	    				var canal = get(FORMULARIO + '.cbCanal');
	    				var idioma = get(FORMULARIO + '.idioma');
	    				var pais = get(FORMULARIO + '.pais');
	    				if (marca != "" && canal != "") {
							parametros = new Array(5);
	     					parametros[0] = FORMULARIO+'.cbSubVentas';   
	     					parametros[1] = "CMNObtieneSubgerenciasVentas";
	     					parametros[2] = DTODruidaBusqueda;
	     					parametros[3] = "[['oidMarca', " + marca + "], ['oidCanal', " + canal + "], ['oidIdioma'," + idioma + "], ['oidPais'," + pais + "]]";
	     					parametros[4] = "seleccionaSubVentasRO(datos)";
	     					parametrosRecargaCombos[parametrosRecargaCombos.length] = parametros;
	     				}
		    		}
					recargaComboMultiple(parametrosRecargaCombos); 
					parametrosRecargaCombos = new Array();
				}

				//Este código pasa a ejecutarse una vez cargado el combo subventas
				/*
				//si hay combos de solo lectura debemos seleccionar el primer valor
				if (eval('document.formularioInsertarCurso.cbSubVentas') != undefined) {
					var dependienteRO = false;
					if(get('formularioInsertarCurso.cbSubVentasRO') == "S") dependienteRO=true;
					if(get('formularioInsertarCurso.cbRegionRO') == "S") dependienteRO=true;
					if(get('formularioInsertarCurso.cbZonaRO') == "S") dependienteRO=true;
					if(get('formularioInsertarCurso.cbSeccionRO') == "S") dependienteRO=true;
					if(get('formularioInsertarCurso.cbTerritorioRO') == "S") dependienteRO=true;

    					if (dependienteRO) {
    						document.all['cbSubVentas'][0].selectedIndex = 1;
    						set('formularioInsertarCurso.cbSubVentas', null);
	         				cargaComboRegion();
	         			}
	         	}
				*/

			} else {
				//deshabilitar
        		if (eval('document.formularioInsertarCurso.cbSubVentas') != undefined) {
					set('formularioInsertarCurso.cbSubVentas', "")
        			accion('formularioInsertarCurso.cbSubVentas', '.disabled=true')
					vaciaCombo('formularioInsertarCurso.cbSubVentas');
				} 
        		if (eval('document.formularioInsertarCurso.cbRegion') != undefined) {
					set('formularioInsertarCurso.cbRegion', "")
        			accion('formularioInsertarCurso.cbRegion', '.disabled=true')
					vaciaCombo('formularioInsertarCurso.cbRegion');
				} 
        		if (eval('document.formularioInsertarCurso.cbZona') != undefined) {
					set('formularioInsertarCurso.cbZona', "")
        			accion('formularioInsertarCurso.cbZona', '.disabled=true')
					vaciaCombo('formularioInsertarCurso.cbZona');
				} 
        		if (eval('document.formularioInsertarCurso.cbSeccion') != undefined) {
					set('formularioInsertarCurso.cbSeccion', "")
        			accion('formularioInsertarCurso.cbSeccion', '.disabled=true')
					vaciaCombo('formularioInsertarCurso.cbSeccion');
				} 
        		if (eval('document.formularioInsertarCurso.cbTerritorio') != undefined) {
					set('formularioInsertarCurso.cbTerritorio', "")
        			accion('formularioInsertarCurso.cbTerritorio', '.disabled=true')
					vaciaCombo('formularioInsertarCurso.cbTerritorio');
				}

/*cortaberria: se elimina la obligatoriedad a los campos, segun lo pedido en incidencia BELC300018076*/
					for (var i = 0; i < objValidacionSICC.length; i++) {
						if (objValidacionSICC[i].nombre == 'cbSubVentas' ||
								objValidacionSICC[i].nombre == 'cbRegion' ||
								objValidacionSICC[i].nombre == 'cbZona' ||
								objValidacionSICC[i].nombre == 'cbSeccion' ||
								objValidacionSICC[i].nombre == 'cbTerritorio') {
     						objValidacionSICC[i].requerido = false;
						}
     				}
				
			}
		}
	}

	function focalizaRBAlcanceTab() {
		var primero = get('formularioInsertarCurso.primero');
		if ( primero != "" && esUltimoGeografico && get('formularioInsertarCurso.rbAlcanceGeoNacional') != "N")
				focaliza('formularioInsertarCurso.' + primero);
		else if (eval('document.formularioInsertarCurso.cbSubVentas') != undefined){
			focaliza('formularioInsertarCurso.cbSubVentas');
		}
	}
	function focalizaUltimo (){
		var ultimo = get('formularioInsertarCurso.ultimo');
		if ( esUltimoGeografico && get('formularioInsertarCurso.rbAlcanceGeoNacional') != "N")
				focaliza('formularioInsertarCurso.rbAlcanceGeoNacional');
		else if (ultimo != "")
			focaliza('formularioInsertarCurso.' + ultimo);
	}
	
	function focalizaPrimero (){
		var primero = get('formularioInsertarCurso.primero');
		if (primero != "")
			focaliza('formularioInsertarCurso.' + primero);
	}
	

	//Excluyentes entre sí los tres campos siguientes
	function validaIngreso(opcion){
		if (opcion == 1 ) {
			if (get('formularioInsertarCurso.cbPerIngresoCondicion') != "") {
				//excluir txtFechaIngresoCondicion txtNPeriodosCondicion
        		if (eval('document.formularioInsertarCurso.txtFechaIngresoCondicion') != undefined) {
					set('formularioInsertarCurso.txtFechaIngresoCondicion', '');
				}
        		if (eval('document.formularioInsertarCurso.txtNPeriodosCondicion') != undefined) {
					set('formularioInsertarCurso.txtNPeriodosCondicion', '');
				}
			} 
		} else if (opcion == 2) {
			if (get('formularioInsertarCurso.txtFechaIngresoCondicion') != "") {
				//excluir cbPerIngresoCondicion txtNPeriodosCondicion
        		if (eval('document.formularioInsertarCurso.cbPerIngresoCondicion') != undefined) {
					set('formularioInsertarCurso.cbPerIngresoCondicion', '');
				}
        		if (eval('document.formularioInsertarCurso.txtNPeriodosCondicion') != undefined) {
					set('formularioInsertarCurso.txtNPeriodosCondicion', '');
				}
			} 
		} else if (opcion == 3 && get('formularioInsertarCurso.txtNPeriodosCondicion') != "") {
			//excluir cbPerIngresoCondicion txtFechaIngresoCondicion
        	if (eval('document.formularioInsertarCurso.cbPerIngresoCondicion') != undefined) {
				set('formularioInsertarCurso.cbPerIngresoCondicion', '');
			}
        	if (eval('document.formularioInsertarCurso.txtFechaIngresoCondicion') != undefined) {
				set('formularioInsertarCurso.txtFechaIngresoCondicion', '');
			}
		}
	}

	//Si el campo "Producto a entregar" está relleno entonces es obligatorio dar un valor momento entrega y unidades de regalo 
	function obligaRegalo() {
		if (eval('document.formularioInsertarCurso.cbProductoAEntregar') != undefined) {
			if (get('formularioInsertarCurso.cbProductoAEntregar').toString() != "") {
	        	if (eval('document.formularioInsertarCurso.cbMomentoEntrega') != undefined) {
					setMV('formularioInsertarCurso.cbMomentoEntrega', 'C');
					for (var i = 0; i < objValidacionSICC.length; i++) {
						if (objValidacionSICC[i].nombre == 'cbMomentoEntrega')
     						objValidacionSICC[i].requerido = true;
     				}
				}
        		if (eval('document.formularioInsertarCurso.txtUniRegalo') != undefined) {
					setMV('formularioInsertarCurso.txtUniRegalo', 'C');
					for (var i = 0; i < objValidacionSICC.length; i++) {
						if (objValidacionSICC[i].nombre == 'txtUniRegalo')
     						objValidacionSICC[i].requerido = true;
     				}
				}
			} else {
	        	if (eval('document.formularioInsertarCurso.cbMomentoEntrega') != undefined) {
					setMV('formularioInsertarCurso.cbMomentoEntrega', 'c');
					for (var i = 0; i < objValidacionSICC.length; i++) {
						if (objValidacionSICC[i].nombre == 'cbMomentoEntrega')
     						objValidacionSICC[i].requerido = false;
     				}
				}
        		if (eval('document.formularioInsertarCurso.txtUniRegalo') != undefined) {
					setMV('formularioInsertarCurso.txtUniRegalo', 'c');
					for (var i = 0; i < objValidacionSICC.length; i++) {
						if (objValidacionSICC[i].nombre == 'txtUniRegalo')
     						objValidacionSICC[i].requerido = false;
     				}
				}
			}
		}
	}

	
	//Si el campo "Nº Ordenes" está relleno entonces es obligatorio dar un valor periodosconstancia 
	function obligaConstancia() {
		if (eval('document.formularioInsertarCurso.txtNOrdenes') != undefined) {
			if (get('formularioInsertarCurso.txtNOrdenes').toString() != "") {
	        	if (eval('document.formularioInsertarCurso.cbPerConstInicio') != undefined) {
					setMV('formularioInsertarCurso.cbPerConstInicio', 'C');
					for (var i = 0; i < objValidacionSICC.length; i++) {
						if (objValidacionSICC[i].nombre == 'cbPerConstInicio')
     						objValidacionSICC[i].requerido = true;
     				}
				}
        		if (eval('document.formularioInsertarCurso.cbPerConstFin') != undefined) {
					setMV('formularioInsertarCurso.cbPerConstFin', 'C');
					for (var i = 0; i < objValidacionSICC.length; i++) {
						if (objValidacionSICC[i].nombre == 'cbPerConstFin')
     						objValidacionSICC[i].requerido = true;
     				}
				}
			} else {
	        	if (eval('document.formularioInsertarCurso.cbPerConstInicio') != undefined) {
					setMV('formularioInsertarCurso.cbPerConstInicio', 'c');
					for (var i = 0; i < objValidacionSICC.length; i++) {
						if (objValidacionSICC[i].nombre == 'cbPerConstInicio')
     						objValidacionSICC[i].requerido = false;
     				}
				}
        		if (eval('document.formularioInsertarCurso.cbPerConstFin') != undefined) {
					setMV('formularioInsertarCurso.cbPerConstFin', 'c');
					for (var i = 0; i < objValidacionSICC.length; i++) {
						if (objValidacionSICC[i].nombre == 'cbPerConstFin')
     						objValidacionSICC[i].requerido = false;
     				}
				}
			}
		}
	}

	//Si el campo "Monto" está relleno entonces es obligatorio dar un valor periodosventas 
	function obligaVentas() {
		if (eval('document.formularioInsertarCurso.txtMontoVentasComp') != undefined) {
			if (get('formularioInsertarCurso.txtMontoVentasComp').toString() != "") {
	        	if (eval('document.formularioInsertarCurso.cbPerVentInicio') != undefined) {
					setMV('formularioInsertarCurso.cbPerVentInicio', 'C');
					for (var i = 0; i < objValidacionSICC.length; i++) {
						if (objValidacionSICC[i].nombre == 'cbPerVentInicio')
     						objValidacionSICC[i].requerido = true;
     				}
				}
        		if (eval('document.formularioInsertarCurso.cbPerVentFin') != undefined) {
					setMV('formularioInsertarCurso.cbPerVentFin', 'C');
					for (var i = 0; i < objValidacionSICC.length; i++) {
						if (objValidacionSICC[i].nombre == 'cbPerVentFin')
     						objValidacionSICC[i].requerido = true;
     				}
				}
			} else {
	        	if (eval('document.formularioInsertarCurso.cbPerVentInicio') != undefined) {
					setMV('formularioInsertarCurso.cbPerVentInicio', 'c');
					for (var i = 0; i < objValidacionSICC.length; i++) {
						if (objValidacionSICC[i].nombre == 'cbPerVentInicio')
     						objValidacionSICC[i].requerido = false;
     				}
				}
        		if (eval('document.formularioInsertarCurso.cbPerVentFin') != undefined) {
					setMV('formularioInsertarCurso.cbPerVentFin', 'c');
					for (var i = 0; i < objValidacionSICC.length; i++) {
						if (objValidacionSICC[i].nombre == 'cbPerVentFin')
     						objValidacionSICC[i].requerido = false;
     				}
				}
			}
		}
	}

	//Muestra los datos que inicialmente aparecían
	function limpiaFormulario()  {

		limpiaI18N('formularioInsertarCurso', '1');

	  	// valores iniciales en Campos de texto
		limpiaCamposTexto();
		cargaInicial();
		 
	  	//seleccion inicial en combos independientes

		//Combo marca siempre estará visible
	    var marca = get('formularioInsertarCurso.hcbMarca');
	    if (get('formularioInsertarCurso.cbMarca') != marca)
			set('formularioInsertarCurso.cbMarca', [marca]);

		//Combo canal siempre estará visible
    	var canal = get('formularioInsertarCurso.hcbCanal');
    	if (canal != get('formularioInsertarCurso.cbCanal'))
			set('formularioInsertarCurso.cbCanal', [canal]);
    	
        if (eval('document.formularioInsertarCurso.cbTipoCliente') != undefined) {
	    	var tipoCliente = get('formularioInsertarCurso.hcbTipoCliente');
    		if (tipoCliente != get('formularioInsertarCurso.cbTipoCliente')) 
				set('formularioInsertarCurso.cbTipoCliente', [tipoCliente]);
		}

	    if (eval('document.formularioInsertarCurso.cbEstatusCli') != undefined) {
    		var estatusCli = get('formularioInsertarCurso.hcbEstatusCli');
    		if (estatusCli != get('formularioInsertarCurso.cbEstatusCli')) 
				set('formularioInsertarCurso.cbEstatusCli', [estatusCli]);
		}

        if (eval('document.formularioInsertarCurso.cbProductoAEntregar') != undefined) {
	    	var productoAEntregar = get('formularioInsertarCurso.hcbProductoAEntregar');
    		if (productoAEntregar != "") 
				set('formularioInsertarCurso.cbProductoAEntregar', [productoAEntregar]);
	    	else
				set('formularioInsertarCurso.cbProductoAEntregar', "");
		}

        if (eval('document.formularioInsertarCurso.cbFrecuenciaDictado') != undefined) {
	    	var frecuenciaDictado = get('formularioInsertarCurso.hcbFrecuenciaDictado');
    		if (frecuenciaDictado != "") 
				set('formularioInsertarCurso.cbFrecuenciaDictado', [frecuenciaDictado]);
	    	else
				set('formularioInsertarCurso.cbFrecuenciaDictado', "");
		}
	

		if (eval('document.formularioInsertarCurso.cbMomentoEntrega') != undefined) {
			var momentoEntrega = get('formularioInsertarCurso.hcbMomentoEntrega');
			if (momentoEntrega != "")
				set('formularioInsertarCurso.cbMomentoEntrega', [momentoEntrega]);
	    	else
				set('formularioInsertarCurso.cbMomentoEntrega', "");
		}

		//vaciar combos dependientes
		vaciaCombo('formularioInsertarCurso.cbAccesoInfo');
		vaciaCombo('formularioInsertarCurso.cbTipoCurso');
		vaciaCombo('formularioInsertarCurso.cbCapacitador');
		vaciaCombosDepCanalMarca();
		vaciaCombo('formularioInsertarCurso.cbRegion');
		vaciaCombo('formularioInsertarCurso.cbZona');
		vaciaCombo('formularioInsertarCurso.cbSeccion');
		vaciaCombo('formularioInsertarCurso.cbTerritorio');
		vaciaCombo('formularioInsertarCurso.cbSubtipoCliente');
		vaciaCombo('formularioInsertarCurso.cbTipoClasificacion');
		vaciaCombo('formularioInsertarCurso.cbClasificacion');
 	
		recargarCombosDependientes();	
		obligaRegalo();
		obligaConstancia();
		obligaVentas();
		focaliza("formularioInsertarCurso." + get('formularioInsertarCurso.primero'));
	}

	function limpiaCamposTexto() {
		set('formularioInsertarCurso.txtNombreCurso', get('formularioInsertarCurso.htxtNombreCurso'));
		if (eval('document.formularioInsertarCurso.txtObjetivoCurso') != undefined)
			set('formularioInsertarCurso.txtObjetivoCurso', get('formularioInsertarCurso.htxtObjetivoCurso'));
                  
		if (eval('document.formularioInsertarCurso.txtContenidoCurso') != undefined)
			set('formularioInsertarCurso.txtContenidoCurso', get('formularioInsertarCurso.htxtContenidoCurso'));
                  
		if (eval('document.formularioInsertarCurso.txtPath') != undefined)
			set('formularioInsertarCurso.txtPath', get('formularioInsertarCurso.htxtPath'));
         
		if (eval('document.formularioInsertarCurso.txtFechaDisponible') != undefined)
			set('formularioInsertarCurso.txtFechaDisponible', get('formularioInsertarCurso.htxtFechaDisponible'));

		if (eval('document.formularioInsertarCurso.txtFechaLanzamiento') != undefined)
			set('formularioInsertarCurso.txtFechaLanzamiento', get('formularioInsertarCurso.htxtFechaLanzamiento'));

		if (eval('document.formularioInsertarCurso.txtFechaFinalizacion') != undefined)
			set('formularioInsertarCurso.txtFechaFinalizacion', get('formularioInsertarCurso.htxtFechaFinalizacion'));

		if (eval('document.formularioInsertarCurso.txtOptimoParticipantes') != undefined)
			set('formularioInsertarCurso.txtOptimoParticipantes', get('formularioInsertarCurso.htxtOptimoParticipantes'));

		if (eval('document.formularioInsertarCurso.txtMaterialAEmplear') != undefined)
			set('formularioInsertarCurso.txtMaterialAEmplear', get('formularioInsertarCurso.htxtMaterialAEmplear'));

		if (eval('document.formularioInsertarCurso.txtNOrdenes') != undefined)
			set('formularioInsertarCurso.txtNOrdenes', get('formularioInsertarCurso.htxtNOrdenes'));

		if (eval('document.formularioInsertarCurso.txtMontoVentasComp') != undefined)
			set('formularioInsertarCurso.txtMontoVentasComp', get('formularioInsertarCurso.htxtMontoVentasComp'));

		if (eval('document.formularioInsertarCurso.txtFechaIngresoCondicion') != undefined)
			set('formularioInsertarCurso.txtFechaIngresoCondicion', get('formularioInsertarCurso.htxtFechaIngresoCondicion'));

		if (eval('document.formularioInsertarCurso.txtNPeriodosCondicion') != undefined)
			set('formularioInsertarCurso.txtNPeriodosCondicion', get('formularioInsertarCurso.htxtNPeriodosCondicion'));

		if (eval('document.formularioInsertarCurso.txtFechaUltimo') != undefined)
			set('formularioInsertarCurso.txtFechaUltimo', get('formularioInsertarCurso.htxtFechaUltimo'));

		if (eval('document.formularioInsertarCurso.txtUniRegalo') != undefined)
			set('formularioInsertarCurso.txtUniRegalo', get('formularioInsertarCurso.htxtUniRegalo'));

		if (eval('document.formularioInsertarCurso.areaDescDetallada') != undefined)
			set('formularioInsertarCurso.areaDescDetallada', get('formularioInsertarCurso.hareaDescDetallada'));
	}

	function ejecutaLimpia() {
		//fMostrarMensajeExito("insertar");
		limpiaFormulario();
	}

	function fGuardar() {
		if (eval('document.formularioInsertarCurso.txtFechaDisponible') != undefined)
			if (!validaFechaGuardar('txtFechaDisponible')) return false;
		if (eval('document.formularioInsertarCurso.txtFechaLanzamiento') != undefined)
			if (!validaFechaGuardar('txtFechaLanzamiento')) return false;
		if (eval('document.formularioInsertarCurso.txtFechaFinalizacion') != undefined)
			if (!validaFechaGuardar('txtFechaFinalizacion')) return false;
		if (eval('document.formularioInsertarCurso.txtFechaUltimo') != undefined)
			if (!validaFechaGuardar('txtFechaUltimo')) return false;
		if (eval('document.formularioInsertarCurso.txtFechaIngresoCondicion') != undefined)
			if (!validaFechaGuardar('txtFechaIngresoCondicion')) return false;
		
		if (eval('document.formularioInsertarCurso.txtOptimoParticipantes') != undefined)
			if (!validaEnteroGuardar('txtOptimoParticipantes')) return false;
		if (eval('document.formularioInsertarCurso.txtNOrdenes') != undefined)
			if (!validaEnteroGuardar('txtNOrdenes')) return false;
		if (eval('document.formularioInsertarCurso.txtMontoVentasComp') != undefined)
			if (!validaMontoGuardar('txtMontoVentasComp')) return false;
		if (eval('document.formularioInsertarCurso.txtNPeriodosCondicion') != undefined)
			if (!validaEnteroGuardar('txtNPeriodosCondicion')) return false;
		if (eval('document.formularioInsertarCurso.txtUniRegalo') != undefined)
			if (!validaEnteroGuardar('txtUniRegalo')) return false;

		validaIngreso(1);
		validaIngreso(2);
		validaIngreso(3);
		obligaRegalo();
		obligaConstancia();
		obligaVentas();
		if (!validaPeriodoConstancia()) return false;
		if (!validaPeriodoVentas()) return false;

			if (get('formularioInsertarCurso.rbAlcanceGeoNacional').toString() == "S") {
  				vaciaCombo('formularioInsertarCurso.cbRegion');
				vaciaCombo('formularioInsertarCurso.cbZona');
				vaciaCombo('formularioInsertarCurso.cbSeccion');
				vaciaCombo('formularioInsertarCurso.cbTerritorio');
			}

	  	if (get('formularioInsertarCurso.casoUso') == "insertar") {
			set('formularioInsertarCurso.accion','guardar');
			set('formularioInsertarCurso.conectorAction',"LPInsertaCurso");
			if (sicc_validaciones_generales())
				enviaSICC('formularioInsertarCurso');
        } else if (get('formularioInsertarCurso.casoUso') == "modificar" || get('formularioInsertarCurso.casoUso') == "copiar"){
			set('formularioInsertarCurso.accion','guardar');
			set('formularioInsertarCurso.conectorAction',"LPModificaCurso");
			if (sicc_validaciones_generales())
				enviaSICC('formularioInsertarCurso');
        }
   	}
   
	function camposRequeridos() {
		for (var i = 0; i < objValidacionSICC.length; i++) {
			var	requerido = get('formularioInsertarCurso.' + objValidacionSICC[i].nombre + 'REQ');
   			if (requerido == "S") {
     			objValidacionSICC[i].requerido = true;
     		}
     	}

	}


	function fLimpiar() {
  		limpiaFormulario();
	}
	
	function fVolver() {
     	    	window.close();
	}

	/* comprueba si es fecha válida y la completa con ceros el dia y el mes 
 	* primer parámetro el nombre de la caja de texto
 	* segundo parámetro el nombre del formulario
 	*/
	function EsFechaValida_SICCFormateada(fecha, formName) {
		var formatoFecha = get(formName + ".hFormatoFechaPais");
		var delim  = obtieneDelimitador(formName);
		var fechaSpliteada = "";

		// Valida que fecha no esté no esten VACIO.
		var valorFecha = get(formName + "." + fecha);
		if ( !valorFecha )
			return false;
	  
		fechaCortada = valorFecha.split(delim);
		fechaSpliteada = formatoFecha.split(delim);

		// Valida que haya las 3 partes de la fecha luego de splitear x el delimitador.
		if ( fechaCortada.length != 3 )
		  return false;
  
		// Chequea cuál es el año (Y o y), al resto (mes o dia, le agrega ceros si es necesario).
		var formatoArray = new Array(3);
		for (var i = 0; i<3; i++ ) {
			formatoArray[i] = parseaFormato(i, formName);
		}	

		var diaMesAgno = "";
		for (var i = 0; i<3 ; i++) {
			diaMesAgno = formatoArray[i];
			switch (diaMesAgno) {
				case 1:
					NDiaD = fechaCortada[i];
					break;
				case 2:
					NMesD = fechaCortada[i];
					break;
				case 3: 
					NAnoD = fechaCortada[i];
					break;
			}
		}

		NDiaD = AgregaCero(NDiaD);
		NMesD = AgregaCero(NMesD);

		var longAgno = obtieneLongAgno(formName);
	  
		if (NDiaD >31 || NMesD > 12 || NAnoD.length != longAgno) return false;  // Valores no validos en Desde. 

		if( ! EsDiaValido(parseInt(NDiaD, 10), parseInt(NMesD, 10), parseInt(NAnoD, 10)) ) return false;

		var ND = NAnoD + NMesD + NDiaD;

		var fechaFormateada = NDiaD + delim + NMesD + delim + NAnoD ;
		if (formatoFecha.indexOf("d") != 0)
			 fechaFormateada = NMesD + delim + NDiaD + delim + NAnoD ;
		set(formName + "." + fecha, fechaFormateada);
		return true;
	}
	
	//valida entero (formato con separador de miles) si el campo es modificable y no vacío 
	function validaMonto(nombreElemento) {
		if (eval('formularioInsertarCurso.'+nombreElemento+'RO') != "S") {
			if (get('formularioInsertarCurso.'+nombreElemento) != "") {
				var mensaje = ValidaMilesDecimales(get('formularioInsertarCurso.'+nombreElemento).toString(), 10, get(FORMULARIO + '.hid_NumeroDecimales'), get('formularioInsertarCurso.hid_SeparadorMiles'), get(FORMULARIO + '.hid_SeparadorDecimales'), 0);
				if (mensaje != "OK") {
					cdos_mostrarAlert(mensaje);
					focaliza('formularioInsertarCurso.'+nombreElemento);
					return false;
				} 
			}
		} 
	}

	
	//valida entero (formato con separador de miles) si el campo es modificable y no vacío 
	function validaMontoGuardar(nombreElemento) {
		if (eval('formularioInsertarCurso.'+nombreElemento+'RO') != "S") {
			if (get('formularioInsertarCurso.'+nombreElemento) != "") {
				var mensaje = ValidaMilesDecimales(get('formularioInsertarCurso.'+nombreElemento).toString(), 10, get(FORMULARIO + '.hid_NumeroDecimales'), get('formularioInsertarCurso.hid_SeparadorMiles'), get(FORMULARIO + '.hid_SeparadorDecimales'), 0);
				if (mensaje != "OK") {
					document.body.focus();
					return false;
				} 
			}
		}
		return true;
	}

	//si es de solo lectura se recarga y selecciona.
	//Si no, se realiza una recarga simple
	function gestionaComboRegionRO(combo, idBusiness, dto, valoresEntrada, funcion) {
		if (eval('document.formularioInsertarCurso.'+combo) != undefined) {
			var dependienteRO = false;
			if(get('formularioInsertarCurso.'+combo+'RO') == "S") dependienteRO=true;
			if(get('formularioInsertarCurso.cbZonaRO') == "S") dependienteRO=true;
			if(get('formularioInsertarCurso.cbSeccionRO') == "S") dependienteRO=true;
			if(get('formularioInsertarCurso.cbTerritorioRO') == "S") dependienteRO=true;
			if(dependienteRO)
    			asignar([["COMBO", 'formularioInsertarCurso.'+combo, "ConectorDruidaTransactionQuery", 'dtoSalida.resultado_ROWSET', formarCadenaDT(idBusiness, dto, valoresEntrada), funcion]],"","");
    		else
    			recargaCombo('formularioInsertarCurso.'+combo, idBusiness, dto, valoresEntrada);
    	}
	}

	//si es de solo lectura se recarga y selecciona.
	//Si no, se realiza una recarga simple
	function gestionaComboZonaRO(combo, idBusiness, dto, valoresEntrada, funcion) {
		if (eval('document.formularioInsertarCurso.'+combo) != undefined) {
			var dependienteRO = false;
			if(get('formularioInsertarCurso.'+combo+'RO') == "S") dependienteRO=true;
			if(get('formularioInsertarCurso.cbSeccionRO') == "S") dependienteRO=true;
			if(get('formularioInsertarCurso.cbTerritorioRO') == "S") dependienteRO=true;
			if(dependienteRO)
    			asignar([["COMBO", 'formularioInsertarCurso.'+combo, "ConectorDruidaTransactionQuery", 'dtoSalida.resultado_ROWSET', formarCadenaDT(idBusiness, dto, valoresEntrada), funcion]],"","");
    		else
    			recargaCombo('formularioInsertarCurso.'+combo, idBusiness, dto, valoresEntrada);
    	}
	}


	//si es de solo lectura se recarga y selecciona.
	//Si no, se realiza una recarga simple
	function gestionaComboSeccionRO(combo, idBusiness, dto, valoresEntrada, funcion) {
		if (eval('document.formularioInsertarCurso.'+combo) != undefined) {
			var dependienteRO = false;
			if(get('formularioInsertarCurso.'+combo+'RO') == "S") dependienteRO=true;
			if(get('formularioInsertarCurso.cbTerritorioRO') == "S") dependienteRO=true;
			if(dependienteRO)
    			asignar([["COMBO", 'formularioInsertarCurso.'+combo, "ConectorDruidaTransactionQuery", 'dtoSalida.resultado_ROWSET', formarCadenaDT(idBusiness, dto, valoresEntrada), funcion]],"","");
    		else
    			recargaCombo('formularioInsertarCurso.'+combo, idBusiness, dto, valoresEntrada);
    	}
	}

	//si es de solo lectura se recarga y selecciona.
	//Si no, se realiza una recarga simple
	function gestionaComboSubtipoClienteRO(combo, idBusiness, dto, valoresEntrada, funcion) {
		if (eval('document.formularioInsertarCurso.'+combo) != undefined) {
			var dependienteRO = false;
			if(get('formularioInsertarCurso.'+combo+'RO') == "S") dependienteRO=true;
			if(get('formularioInsertarCurso.cbTipoClasificacionRO') == "S") dependienteRO=true;
			if(get('formularioInsertarCurso.cbClasificacionRO') == "S") dependienteRO=true;
			if(dependienteRO)
    			asignar([["COMBO", 'formularioInsertarCurso.'+combo, "ConectorDruidaTransactionQuery", 'dtoSalida.resultado_ROWSET', formarCadenaDT(idBusiness, dto, valoresEntrada), funcion]],"","");
    		else
    			recargaCombo('formularioInsertarCurso.'+combo, idBusiness, dto, valoresEntrada);
    	}
	}


	//si es de solo lectura se recarga y selecciona.
	//Si no, se realiza una recarga simple
	function gestionaComboTipoClasificacionRO(combo, idBusiness, dto, valoresEntrada, funcion) {
		if (eval('document.formularioInsertarCurso.'+combo) != undefined) {
			var dependienteRO = false;
			if(get('formularioInsertarCurso.'+combo+'RO') == "S") dependienteRO=true;
			if(get('formularioInsertarCurso.cbClasificacionRO') == "S") dependienteRO=true;
			if(dependienteRO)
    			asignar([["COMBO", 'formularioInsertarCurso.'+combo, "ConectorDruidaTransactionQuery", 'dtoSalida.resultado_ROWSET', formarCadenaDT(idBusiness, dto, valoresEntrada), funcion]],"","");
    		else
    			recargaCombo('formularioInsertarCurso.'+combo, idBusiness, dto, valoresEntrada);
    	}
	}

	function seleccionaClasificacionRO(datos) {
		set_combo('formularioInsertarCurso.cbClasificacion', incluyeOpcionVacia(datos));
		if (typeof(datos) != 'undefined' && datos.length > 0)
			set('formularioInsertarCurso.cbClasificacion', [datos[0][0]]);
	}

	function seleccionaTipoClasificacionRO(datos) {
		set_combo('formularioInsertarCurso.cbTipoClasificacion', incluyeOpcionVacia(datos));
		if (typeof(datos) != 'undefined' && datos.length > 0) {
			set('formularioInsertarCurso.cbTipoClasificacion', [datos[0][0]]);
			cargaComboClasificacion();
		}
	}

	function seleccionaSubtipoClienteRO(datos) {
		set_combo('formularioInsertarCurso.cbSubtipoCliente', incluyeOpcionVacia(datos));
		if (typeof(datos) != 'undefined' && datos.length > 0) {
			set('formularioInsertarCurso.cbSubtipoCliente', [datos[0][0]]);
			cargaComboTipoClasificacion();
		}
	}

	function seleccionaTerritorioRO(datos) {
		set_combo('formularioInsertarCurso.cbTerritorio', incluyeOpcionVacia(datos));
		if (typeof(datos) != 'undefined' && datos.length > 0) 
			set('formularioInsertarCurso.cbTerritorio', [datos[0][0]]);
	}

	function seleccionaSeccionRO(datos) {
		set_combo('formularioInsertarCurso.cbSeccion', incluyeOpcionVacia(datos));
		if (typeof(datos) != 'undefined' && datos.length > 0 ) {
			set('formularioInsertarCurso.cbSeccion', [datos[0][0]]);
			cargaComboTerritorio();
		}
	}

	function seleccionaZonaRO(datos) {
		set_combo('formularioInsertarCurso.cbZona', incluyeOpcionVacia(datos));
		if (typeof(datos) != 'undefined' && datos.length > 0) {
			set('formularioInsertarCurso.cbZona', [datos[0][0]]);
			cargaComboSeccion();
		}
	}
	function seleccionaRegionRO(datos) {
		set_combo('formularioInsertarCurso.cbRegion', incluyeOpcionVacia(datos));
		if (typeof(datos) != 'undefined' && datos.length > 0) {
			set('formularioInsertarCurso.cbRegion', [datos[0][0]]);
			cargaComboZona();
		}
	}

	function seleccionaSubVentasRO(datos) {
		set_combo('formularioInsertarCurso.cbSubVentas', incluyeOpcionVacia(datos));
		var dependienteRO = false;
		if(get('formularioInsertarCurso.cbSubVentasRO') == "S") dependienteRO=true;
		if(get('formularioInsertarCurso.cbRegionRO') == "S") dependienteRO=true;
		if(get('formularioInsertarCurso.cbZonaRO') == "S") dependienteRO=true;
		if(get('formularioInsertarCurso.cbSeccionRO') == "S") dependienteRO=true;
		if(get('formularioInsertarCurso.cbTerritorioRO') == "S") dependienteRO=true;

		if (typeof(datos) != 'undefined' && datos.length > 0 && get('formularioInsertarCurso.rbAlcanceGeoNacional') == "N" && dependienteRO) {
			set('formularioInsertarCurso.cbSubVentas', [datos[0][0]]);
			cargaComboRegion();
		}
	}



	function seleccionaCursosRO(datos) {
		set_combo('formularioInsertarCurso.cbCursosExigidos', datos);
		if (typeof(datos) != 'undefined' && datos.length > 0 && get(FORMULARIO + '.cbCursosExigidosRO') == "S")
			set('formularioInsertarCurso.cbCursosExigidos', [datos[0][0]]);
	}

	function seleccionaAccesosRO(datos) {
		set_combo('formularioInsertarCurso.cbAccesoInfo', incluyeOpcionVacia(datos));
		if (typeof(datos) != 'undefined' && datos.length > 0)
			set('formularioInsertarCurso.cbAccesoInfo', [datos[0][0]]);
	}


	function seleccionaTipoCursoRO(datos) {
		set_combo('formularioInsertarCurso.cbTipoCurso', incluyeOpcionVacia(datos));
		
		if (typeof(datos) != 'undefined' && datos.length > 0 && get(FORMULARIO + '.cbTipoCursoRO') == "S") {
			set('formularioInsertarCurso.cbTipoCurso', [datos[0][0]]);
			cargaComboCapacitador();
		}
	}

	function seleccionaCapacitadorRO(datos) {

		set_combo('formularioInsertarCurso.cbCapacitador', incluyeOpcionVacia(datos));
		if (typeof(datos) != 'undefined' && datos.length > 0 && get(FORMULARIO + '.cbCapacitadorRO') == "S") {
			set('formularioInsertarCurso.cbCapacitador', [datos[0][0]]);
		}
	}
	
 

//Recarga multiples combos, para ello recibe un array con tantas filas como combos a cargar
// cada fila debe tener las siguientes columnas: combo, idBusiness, dto, parametros
function recargaComboMultiple(parametros) {
	  var i;
	  var instruccion = "asignar([";

  	  for (i=0; i < parametros.length; ++i) {
	  	instruccion = instruccion + "['COMBO', '" + parametros[i][0] + 
	  	               "', 'ConectorDruidaTransactionQuery', 'dtoSalida.resultado_ROWSET', " +
  				      "formarCadenaDT('" + parametros[i][1] + "', '" + parametros[i][2] + 
  				      "', " + parametros[i][3] + ")";
		if (parametros[i].length == 5)
			instruccion = instruccion + ", '" + parametros[i][4] + "'";

		instruccion = instruccion + "]";
  		if (i != parametros.length -1) {
  		//Si no es la ultima fila ponemos la coma que separa del siguiente array  		
  			instruccion = instruccion + ", ";
  		}
  	  }
  	  instruccion = instruccion + "]);";
  	  if (parametros.length > 0)
  	  	eval(instruccion);
}

function validaPeriodoConstancia() {
	var informadoPeriodoIni = false;
	var informadoPeriodoFin = false;
	if (eval('document.formularioInsertarCurso.cbPerConstInicio') != undefined	&& get('formularioInsertarCurso.cbPerConstInicio') != "")  informadoPeriodoIni = true;
	if (eval('document.formularioInsertarCurso.cbPerConstFin') != undefined && get('formularioInsertarCurso.cbPerConstFin') != "")  informadoPeriodoFin = true;
	
	//comprobación de que si viene señalado uno de los combos Período de inicio Constancia
	// o Período Fin Constancia venga el otro y el periodo de fin sea mayor que es de inicio

	//Si el campo"Número de órdenes de Constancia" está informado {
	if (eval('document.formularioInsertarCurso.txtNOrdenes') != undefined && get('formularioInsertarCurso.txtNOrdenes') != "") {
	
		//Si ambos combos Período de inicio Constancia o Período Fin Constancia son distintos de null {
		if (informadoPeriodoIni && informadoPeriodoFin) {
			//Validamos que el periodo fin sea mayor que el de inicio
		    if (!comprobarPeriodos(get('formularioInsertarCurso.cbPerConstInicio', 'T').toString(), get('formularioInsertarCurso.cbPerConstFin', 'T').toString())) {
		       	//Si No correcto { //Si el periodo fin no es mayor que el periodo inicio
				//mostrar error: UIEDU0005 ("El Período Fin Constancia debe ser mayor que el Período Inicio
				//Constancia ")
				GestionarMensaje('UIEDU0005', null);
				focaliza(FORMULARIO + '.cbPerConstInicio')
				return false;
		    }
		} else if (informadoPeriodoIni ^ informadoPeriodoFin) {
		    /*Si uno de ellos es null y el otro no {
			mostrar error: UIEDU0003 ("No puede informarse el Período Inicio Constancia sin Período Fin Constancia o viceversa")*/
			GestionarMensaje('UIEDU0003', null);
			focaliza(FORMULARIO + '.cbPerConstInicio')
			return false;
		}
	
	}
	return true;
}

function validaPeriodoVentas(){
	var informadoPeriodoIni = false;
	var informadoPeriodoFin = false;
	if (eval('document.formularioInsertarCurso.cbPerVentInicio') != undefined	&& get('formularioInsertarCurso.cbPerVentInicio') != "")  informadoPeriodoIni = true;
	if (eval('document.formularioInsertarCurso.cbPerVentFin') != undefined && get('formularioInsertarCurso.cbPerVentFin') != "")  informadoPeriodoFin = true;
	
	//comprobación de que si viene señalado uno de los combos Período de inicio Constancia
	// o Período Fin Constancia venga el otro y el periodo de fin sea mayor que es de inicio

	//Si el campo "Monto de ventas comparativo" está informado {
	if (eval('document.formularioInsertarCurso.txtMontoVentasComp') != undefined && get('formularioInsertarCurso.txtMontoVentasComp') != "") {
	
		//Si ambos combos Período de inicio Constancia o Período Fin Constancia son distintos de null {
		if (informadoPeriodoIni && informadoPeriodoFin) {
			//Validamos que el periodo fin sea mayor que el de inicio
		    if (!comprobarPeriodos(get('formularioInsertarCurso.cbPerVentInicio', 'T').toString(), get('formularioInsertarCurso.cbPerVentFin', 'T').toString())) {
		       	//Si No correcto { //Si el periodo fin no es mayor que el periodo inicio
				//mostrar error: UIEDU0006 ("El Período Fin Ventas debe ser mayor que el Período Inicio Ventas ")
				GestionarMensaje('UIEDU0006', null);
				focaliza(FORMULARIO + '.cbPerVentInicio')
				return false;
		    }
		} else if (informadoPeriodoIni ^ informadoPeriodoFin) {
		    /*Si uno de ellos es null y el otro no {
			mostrar error: UIEDU0004 ("No puede informarse el Período Inicio Ventas sin Período Fin Ventas o viceversa")*/
			GestionarMensaje('UIEDU0004', null);
			focaliza(FORMULARIO + '.cbPerVentInicio')
			return false;
		}
	
	}
	return true;
}

	function comprobarPeriodos(periodoIni, periodoFin) {
		var inicioIni = periodoIni.substr(periodoIni.length-6, 4);
		var inicioFin = periodoFin.substr(periodoFin.length-6, 4);
		var correcto = false;
		//Si los 4 primeros digitos de la cmbPeriodoFin > los 4 primeros digitos de la cmbPeriodoInicio => correcto
		if (inicioFin > inicioIni) correcto = true;
		else if (inicioFin == inicioIni) {
		//- Si los 4 primeros digitos de la cmbPeriodoFin = los 4 primeros digitos de la cmbPeriodoInicio 
	   	// - Si los 2 ultimos digitos de la cmbPeriodoFin >= los 2 ultimos digitos de la cmbPeriodoInicio 
	   		var finIni = periodoIni.substr(periodoIni.length - 2);
			var finFin = periodoFin.substr(periodoFin.length - 2);
			if (finFin >= finIni) correcto = true;
		}
		return correcto;
	}