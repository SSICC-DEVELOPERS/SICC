function onLoadPag() {  
	fMostrarMensajeError();
	configurarMenuSecundario("formulario");  	

	ocultaCapa2();
	ocultaLista2();
	ocultaCapa3();
	ocultaLista1();

	if(get('formulario.oidCentroDistribucion')!="") {
		var hidOidDefecto = get("formulario.oidCentroDistribucion");  
        var oidSeleccionado = new Array();
        oidSeleccionado = hidOidDefecto.split(",");	    
        set("formulario.cbCentroDistribucion", oidSeleccionado);	
		onChangeCbCentroDistribucion();
	}
	else if(get('formulario.hOidCentroDistribucionDefecto')!="") {
		var hidOidDefecto = get("formulario.hOidCentroDistribucionDefecto");  
        var oidSeleccionado = new Array();
        oidSeleccionado = hidOidDefecto.split(",");	    
        set("formulario.cbCentroDistribucion", oidSeleccionado);	
		onChangeCbCentroDistribucion();
	}	

	if(get('formulario.opcionMenu')!="mantener") {
		document.getElementById("cbCentroDistribucion").disabled = true;
		document.getElementById("cbMapaCentroDistribucion").disabled = true;
	}

	focalizaBotonHTML('botonContenido','btnExpandirAnaquel');
}

function arrayVacio(){  
    var array = new Array();             
        array[0] = new Array('','');
  
    return array;
}

function muestraCapa2() {
	document.all["capa2"].style.visibility= "visible";
}

function ocultaCapa2() {
	document.all["capa2"].style.visibility= "hidden";
}

function muestraCapa3() {
	document.all["capa3"].style.visibility= "visible";
}

function ocultaCapa3() {
	document.all["capa3"].style.visibility= "hidden";
}

function ocultaLista1() {
	document.all["Cplistado1"].style.visibility='hidden';
    document.all["CpLin1listado1"].style.visibility='hidden';
    document.all["CpLin2listado1"].style.visibility='hidden';
    document.all["CpLin3listado1"].style.visibility='hidden';
    document.all["CpLin4listado1"].style.visibility='hidden';
    document.all["avaDiv"].style.visibility='hidden';
    document.all["retDiv"].style.visibility='hidden';
    document.all["separaDiv"].style.visibility='hidden';
	document.all["primeraDiv"].style.visibility='hidden';
	document.all["CpLin4listado1"].style.visibility='hidden';
	document.all["CpLin4listado1"].style.visibility='hidden';
	document.all["CpLin4listado1"].style.visibility='hidden';
    document.all["btAceptarDividirDiv"].style.visibility='hidden';
}

function muestraLista1() {
	DrdEnsanchaConMargenDcho('listado1',12);   
	document.all["Cplistado1"].style.visibility='';
    document.all["CpLin1listado1"].style.visibility='';
    document.all["CpLin2listado1"].style.visibility='';
    document.all["CpLin3listado1"].style.visibility='';
    document.all["CpLin4listado1"].style.visibility='';
    document.all["avaDiv"].style.visibility='';
    document.all["retDiv"].style.visibility='';
    document.all["separaDiv"].style.visibility='';
	document.all["primeraDiv"].style.visibility='';
    document.all["btAceptarDividirDiv"].style.visibility='';
    eval (ON_RSZ);  
}

function ocultaLista2() {
	document.all["Cplistado2"].style.visibility='hidden';
    document.all["CpLin1listado2"].style.visibility='hidden';
    document.all["CpLin2listado2"].style.visibility='hidden';
    document.all["CpLin3listado2"].style.visibility='hidden';
    document.all["CpLin4listado2"].style.visibility='hidden';
    document.all["btnAniadirDiv"].style.visibility='hidden';
	document.all["btnEliminarDiv"].style.visibility='hidden';
    document.all["btAceptarExpandirDiv"].style.visibility='hidden';
}

function muestraLista2() {
	DrdEnsanchaConMargenDcho('listado2',12);    
	document.all["Cplistado2"].style.visibility='';
    document.all["CpLin1listado2"].style.visibility='';
    document.all["CpLin2listado2"].style.visibility='';
    document.all["CpLin3listado2"].style.visibility='';
    document.all["CpLin4listado2"].style.visibility='';
    document.all["btnAniadirDiv"].style.visibility='';
	document.all["btnEliminarDiv"].style.visibility='';
	document.all["btAceptarExpandirDiv"].style.visibility='';
    eval (ON_RSZ);  
}

function rellenarCombosMapa(datos) {
	var arrayNuevo = new Array();
	arrayNuevo[0] = new Array('','');
	arrayNuevo = arrayNuevo.concat(datos);

	set_combo('formulario.cbMapaCentroDistribucion',arrayNuevo);

	if(get('formulario.hOidMapaGenerado')!="") {
		var hidOidDefecto = get("formulario.hOidMapaGenerado");  
        var oidSeleccionado = new Array();
        oidSeleccionado = hidOidDefecto.split(",");	    
        set("formulario.cbMapaCentroDistribucion", oidSeleccionado);	
	}
}

function onChangeCbCentroDistribucion() {
	if(get('formulario.cbCentroDistribucion')!="") {
		recargaCombo('formulario.cbMapaCentroDistribucion', 'APEObtenerMapasCDPorCD', 'es.indra.sicc.util.DTOOID', armarArrayComboCentroDistribucion(), 'rellenarCombosMapa(datos)');
	}
	else {
		set_combo('formulario.cbMapaCentroDistribucion', new Array(['','']));
	}
}

function armarArrayComboCentroDistribucion() {
	var idioma = get('formulario.idioma');
	var pais = get('formulario.pais');
	var oid = get('formulario.cbCentroDistribucion');
  
    var array = new Array();
    var index = 0;

    if( idioma != null && idioma != '' ){
		array[index] = new Array('oidIdioma', idioma);
        index++;
    }

	if( pais != null && pais != '' ){
		array[index] = new Array('oidPais', pais);
        index++;
    }

	if( oid != null && oid != '' ){
		array[index] = new Array('oid', oid);
        index++;
    }
  
    return array;
}

function onClickExpandirAnaquel() {
	if(sicc_validaciones_generales('expandirDividir')) {  
		document.getElementById("cbCentroDistribucion").disabled = true;
		document.getElementById("cbMapaCentroDistribucion").disabled = true;
		/*document.getElementById("cbMarca").disabled = true;
		document.getElementById("cbCanal").disabled = true;
		document.getElementById("cbPeriodo").disabled = true;*/
		document.getElementById("btnExpandirAnaquel").disabled = true;
		document.getElementById("btnDividirAnaquel").disabled = true;
		muestraCapa2();
		muestraLista2();

		recargaCombo('formulario.cbCodAnaquelDestino', 'APEObtenerNumerosAnaquelPorMapaCD', 'es.indra.sicc.util.DTOOID', armarArrayComboMapaCentroDistribucion(), 'rellenarCombos(datos)');
	}
}

function rellenarCombos(datos) {
	var arrayNuevo = new Array();
	arrayNuevo[0] = new Array('','');
	arrayNuevo = arrayNuevo.concat(datos);
	set_combo('formulario.cbCodAnaquelDestino',arrayNuevo);
    listado2.tiposCol[0][2]=arrayNuevo;
	onClickAnadirAnaquel();
	onClickAnadirAnaquel();
}

function armarArrayComboMapaCentroDistribucion() {
	var idioma = get('formulario.idioma');
	var pais = get('formulario.pais');
	var oid = get('formulario.cbMapaCentroDistribucion');
  
    var array = new Array();
    var index = 0;

    if( idioma != null && idioma != '' ){
		array[index] = new Array('oidIdioma', idioma);
        index++;
    }

	if( pais != null && pais != '' ){
		array[index] = new Array('oidPais', pais);
        index++;
    }

	if( oid != null && oid != '' ){
		array[index] = new Array('oid', oid);
        index++;
    }
  
    return array;
}

function onClickAnadirAnaquel() {	
	var array = new Array();
	var datos = listado2.datos;
	longitudActual = datos.length;
	array[0] = longitudActual + 1;
	array[1] = "";
	listado2.insertar(array);
}

function onClickEliminarAnaquel () {
	listado2.actualizaDat();
	var datos = listado2.datos;
	var longitud = datos.length;
	if(longitud>2) {
		var elegidos = listado2.codSeleccionados();
		var elegidosUsuario = elegidos.length;
		var resultado = longitud - elegidosUsuario;
		if(resultado>=2) {
			listado2.eliminarSelecc();
		}
	}	
}

function onClickAceptarExpandir () {
	if(sicc_validaciones_generales('aceptarExpandir')) {  	
		for(var i=0;i<listado2.datos.length;i++) {
			var anaquelOrigen = document.getElementById("comboAnaquelOrigen_" + i);
			if(anaquelOrigen.value=="") {
				GestionarMensaje("APE046"); 
				anaquelOrigen.focus();
				return false;
			}
		}

		if(validarExpandir()) {
			var oidsAnaquelesOrigen = obtenerOidsAnaquelesOrigen();
			eval("formulario").oculto= "S";
			set("formulario.oidAnaquelDestino", get("formulario.cbCodAnaquelDestino"));
			set("formulario.oidPeriodo", get("formulario.cbPeriodo"));
			set("formulario.capacidad", get("formulario.txtCapacidad"));
			set("formulario.oidsAnaquelesOrigen", oidsAnaquelesOrigen);
			set("formulario.conectorAction", "LPMantenimientoMapaCentroDistribucion");
			set("formulario.accion", "expandir");
			enviaSICC("formulario");
		}
	}
}

function expandirAnaquelOK(mostrarMensaje) {
	eval("formulario").oculto= "N";
	if(mostrarMensaje=="true") {
		//Hay productos asignados a los anaqueles manipulados.
    // vbongiov -- 15/08/2007
    ocultaCapa2();
    ocultaCapa3();
    ocultaLista1();
    ocultaLista2();
		GestionarMensaje("APE045", null, null, null);
    
    set('formulario.cbMarca', '');  
    set('formulario.cbCanal', ''); 
    set_combo('formulario.cbPeriodo', arrayVacio());
    set('formulario.cbCodAnaquelDestino', '');  
    set('formulario.txtCapacidad', ''); 
    listado2.limpia();
		
    onClickExpandirAnaquel();
	}
	else {
		GestionarMensaje("APE015", null, null, null);
	}
}

function moverExpandirOK() {
	eval("formulario").oculto= "N";
}

function moverExpandirERR() {
	eval("formulario").oculto= "N";
}

function expandirAnaquelERR() {
	eval("formulario").oculto= "N";
}

function obtenerOidsAnaquelesOrigen() {
	var oidAnaquelDestino = get("formulario.cbCodAnaquelDestino");
	var oids = "";
	for(var i=0;i<listado2.datos.length;i++) {
		var anaquelOrigen = document.getElementById("comboAnaquelOrigen_" + i);		
		if(oids=="") {
			if(oidAnaquelDestino!=anaquelOrigen.value) {
				oids = anaquelOrigen.value;
			}
		}
		else {
			if(oidAnaquelDestino!=anaquelOrigen.value) {
				oids = oids + "|" + anaquelOrigen.value;
			}
		}		
	}

	return oids;
}

function validarExpandir() {     
	var texto = new String(get("formulario.cbCodAnaquelDestino", "T"));
	var letraSublinea = texto.substring(0,1);

	//--------------------Agregado por incidencia 485 
	var bahia = texto.substring(1,3);
	var mismaBahia = true;
	//--------------------Agregado por incidencia 485 

	var mismaSublinea = true;
	var mismoAnaquel = false;	
	var lstAnaquelesOrigen = new Array();

	for(var i=0;i<listado2.datos.length;i++) {
		var anaquelOrigen = document.getElementById("comboAnaquelOrigen_" + i);
		lstAnaquelesOrigen[i] = anaquelOrigen.options[anaquelOrigen.selectedIndex].text;		
	}

	for(var j=0 ;j<lstAnaquelesOrigen.length && mismaSublinea==true; j++) {
		var valor = lstAnaquelesOrigen[j];
		var letraSublineaActual = valor.substring(0,1);
		var bahiaActual = valor.substring(1,3);

		if(valor==texto) {
			mismoAnaquel = true;	
		}
		if(letraSublineaActual!=letraSublinea) {
			mismaSublinea = false;
		}

		//--------------------Agregado por incidencia 485 
		if(bahiaActual!=bahia) {
			mismaBahia = false;
		}
		//--------------------Agregado por incidencia 485 
	}

	//--------------------Agregado por incidencia 485 
	if(mismaBahia==false) {
		GestionarMensaje("APEUI057"); 
		return false;
	}
	//--------------------Agregado por incidencia 485 
	if(mismaSublinea==false) {
		GestionarMensaje("APE019"); 
		return false;
	}
	if(mismoAnaquel==false) {
		GestionarMensaje("APE018"); 
		return false;
	}

	return true;
}


function onClickDividirAnaquel() {
	if(sicc_validaciones_generales('Dividir')) {  
		document.getElementById("cbCentroDistribucion").disabled = true;
		document.getElementById("cbMapaCentroDistribucion").disabled = true;
		/*document.getElementById("cbMarca").disabled = true;
		document.getElementById("cbCanal").disabled = true;
		document.getElementById("cbPeriodo").disabled = true;*/
		document.getElementById("btnExpandirAnaquel").disabled = true;
		document.getElementById("btnDividirAnaquel").disabled = true;
		muestraCapa3();

		recargaCombo('formulario.cbCodigoAnaquelOrigen', 'APEObtenerNumerosAnaquelPorMapaCD', 'es.indra.sicc.util.DTOOID', armarArrayComboMapaCentroDistribucion());
	}
}

function onClickAceptar () {
	if(sicc_validaciones_generales('busquedaDividir')) {  
		var arr = new Array();
		arr[arr.length] = new Array("oid", get("formulario.cbCodigoAnaquelOrigen")+"");
		arr[arr.length] = new Array("oidPais", get("formulario.pais")+"");
		arr[arr.length] = new Array("oidIdioma", get("formulario.idioma")+"");		    
		configurarPaginado(mipgndo,"APEBuscarAnaquelesExpandidos","ConectorBuscarAnaquelesExpandidos","es.indra.sicc.util.DTOOID",arr);  
	}	
}

function muestraLista(ultima, rowset, error){
	var tamano = rowset.length;
    if (tamano > 0) {
		eval (ON_RSZ);
		muestraLista1();
        return true;
     }
     else {
 	    ocultaLista1();
		return false;
     }
}

function onClickAceptarDividir() {
	/* BELC400000660 - dmorello, 05/09/2007 */
	//if (listado1.numSelecc()== 0) {
	//	GestionarMensaje('1021',null,null,null);
    //    return false;
    //}

	eval("formulario").oculto= "S";
	//var oidsAnaqueles = obtenerOids();
	var codigos = listado1.codigos();
	var oidsAnaqueles = '';
	for (var i = 0; i < codigos.length; i++) {
		if (i != 0) oidsAnaqueles += '|';
		oidsAnaqueles += codigos[i];
	}
	/* Fin BELC400000660 - dmorello, 05/09/2007 */
	set("formulario.oidsAnaqueles", oidsAnaqueles);
	set("formulario.conectorAction", "LPMantenimientoMapaCentroDistribucion");
	set("formulario.accion", "dividir");
	enviaSICC("formulario"); 
}

function obtenerOids() {
	var oidsRespuesta = "";
	var oids = listado1.codSeleccionados();

	for(var i=0;i<oids.length;i++) {
		if(i==0) {
			oidsRespuesta = oids[i];
		}
		else {
			oidsRespuesta = oidsRespuesta + "|" + oids[i];
		}		
	}

	return oidsRespuesta;
}

function dividirAnaquelOK() {
	eval("formulario").oculto= "N";
	/* BELC400000660 - dmorello, 05/09/2007 */
	document.getElementById("btnExpandirAnaquel").disabled = false;
	document.getElementById("btnDividirAnaquel").disabled = false;
	document.getElementById("cbCentroDistribucion").disabled = false;
	document.getElementById("cbMapaCentroDistribucion").disabled = false;
	onLoadPag();
	/* Fin BELC400000660 - dmorello, 05/09/2007 */
}

function dividirAnaquelERR() {
	eval("formulario").oculto= "N";
}

function onChangeCbMarca() {
	if(get('formulario.cbCanal')!="" && get('formulario.cbMarca')!="") {
		recargaCombo('formulario.cbPeriodo', 'CRAObtenerPeriodos', 'es.indra.sicc.dtos.cra.DTOPeriodo', armarArray());
	}
	else {
		set_combo('formulario.cbPeriodo', new Array(['','']));
	}
}

function onChangeCbCanal() {
	if(get('formulario.cbCanal')!="" && get('formulario.cbMarca')!="") {
		recargaCombo('formulario.cbPeriodo', 'CRAObtenerPeriodos', 'es.indra.sicc.dtos.cra.DTOPeriodo', armarArray());
	}
	else {
		set_combo('formulario.cbPeriodo', new Array(['','']));
	}
}

function armarArray() {
	var idioma = get('formulario.idioma');
	var pais = get('formulario.pais');
	var canal = get('formulario.cbCanal');
	var marca = get('formulario.cbMarca');
  
    var array = new Array();
    var index = 0;

    if( idioma != null && idioma != '' ){
		array[index] = new Array('oidIdioma', idioma);
        index++;
    }

	if( pais != null && pais != '' ){
		array[index] = new Array('oidPais', pais);
        index++;
    }

	if( canal != null && canal != '' ){
		array[index] = new Array('canal', canal);
        index++;
    }

	if( marca != null && marca != '' ){
		array[index] = new Array('marca', marca);
        index++;
    }
  
    return array;
}

//********************************************* funciones para el foco ********

function onTabCentro() {
	focaliza("formulario.cbMapaCentroDistribucion");	
}

function onShTabCentro() {
	focalizaBotonHTML('botonContenido','btnDividirAnaquel');
}

function onTabMapa() {
	focalizaBotonHTML('botonContenido','btnExpandirAnaquel');
}

function onShTabMapa() {
	focaliza("formulario.cbCentroDistribucion");	
}

function onTabExpandir() {
	focalizaBotonHTML('botonContenido','btnDividirAnaquel');
}

function onShTabExpandir() {
	focaliza("formulario.cbMapaCentroDistribucion");	
}

function onTabDividir() {
	if(document.all["capa2"].style.visibility=="hidden" &&
		document.all["capa3"].style.visibility=="hidden") {
		focaliza("formulario.cbCentroDistribucion");	
	}
	else {
		if(document.all["capa2"].style.visibility!="hidden") {
			focaliza("formulario.cbCodAnaquelDestino");	
		}
		else {
			focaliza("formulario.cbCodigoAnaquelOrigen");	
		}
	}
}

function onShTabDividir() {
	focalizaBotonHTML('botonContenido','btnExpandirAnaquel');
}

function onTabAnaquelDestino() {
	focaliza("formulario.txtCapacidad");		
}

function onShTabAnaquelDestino() {
	focaliza("formulario.cbPeriodo");	
}

function onTabCapacidad() {
	focalizaBotonHTML_XY('btnAniadir');
}

function onShTabCapacidad() {
	focaliza("formulario.cbCodAnaquelDestino");	
}

function onTabBotonAceptarExpandir() {
	focaliza("formulario.cbMarca");	
}

function onTabAnaquelOrigen() {
	focalizaBotonHTML('botonContenido','btnAceptar');
}

function onShTabAnaquelOrigen() {
	if(document.all["Cplistado1"].style.visibility=='hidden') {
		focalizaBotonHTML('botonContenido','btnAceptar');
	}
	else {
		focalizaBotonHTML_XY('btAceptarDividir');
	}
}

function onTabBotonAceptar() {
	if(document.all["Cplistado1"].style.visibility=='hidden') {
		focaliza("formulario.cbCodigoAnaquelOrigen");	
	}
	else {
		focalizaBotonHTML_XY('btAceptarDividir');
	}
}

function onShTabBotonAceptar() {
	focaliza("formulario.cbCodigoAnaquelOrigen");	
}

function onTabBotonAceptarDividir() {
	focaliza("formulario.cbCodigoAnaquelOrigen");
}

function onShTabBotonAceptarDividir() {
	focalizaBotonHTML('botonContenido','btnAceptar');
}

function onTABComboMarca() {
	focaliza("formulario.cbCanal");	
}

function onSHTABComboMarca() {
 	focalizaBotonHTML_XY('btAceptarExpandir');
}

function onTABComboCanal() {
	focaliza("formulario.cbPeriodo");	
}

function onSHTABComboCanal() {
	focaliza("formulario.cbMarca");	
}

function onTABComboPeriodo() {
	focaliza("formulario.cbCodAnaquelDestino");	
}

function onSHTABComboPeriodo() {
	focaliza("formulario.cbCanal");	
}

function fLimpiar() {
	// Fieldset "Expandir anaquel"
	visibilidad('capa2','O'); // 'O' oculta y 'V' hace visible
	set_combo('formulario.cbPeriodo', new Array(['','']));
	set("formulario.cbMarca", ['']);
	set("formulario.cbCanal", ['']);
	set("formulario.cbCodAnaquelDestino", ['']);
	set('formulario.txtCapacidad', '');
	
	// Lista editable "Cod. anaquel origen"
	listado2.setDatos(new Array());
	ocultaLista2();
	
	// Fieldset "Dividir anaquel"
	visibilidad('capa3','O'); // 'O' oculta y 'V' hace visible
	set("formulario.cbCodigoAnaquelOrigen", ['']);
	
	// Lista editable "Cod. anaquel origen" | "Capacidad"
	listado1.setDatos(new Array());
	ocultaLista1();
	
	deshabilitarHabilitarBoton('botonContenido',  'btnExpandirAnaquel', 'A'); // 'D' deshabilita y 'A' habilita
	deshabilitarHabilitarBoton('botonContenido',  'btnDividirAnaquel',  'A');
	
	if (get('formulario.opcionMenu') == 'mantener') {
		// Fieldset "Seleccion de mapa"
		var oidCDDefault = get('formulario.hOidCentroDistribucionDefecto');
		set("formulario.cbCentroDistribucion", [oidCDDefault]);
		onChangeCbCentroDistribucion();
		
		accion('formulario.cbCentroDistribucion',     '.disabled=false');
		accion('formulario.cbMapaCentroDistribucion', '.disabled=false');
		foco("formulario.cbCentroDistribucion");
		
	} else if (get('formulario.opcionMenu') == 'generar') {
		// Fieldset "Seleccion de mapa"
		focalizaBotonHTML('botonContenido','btnExpandirAnaquel');
	}
}