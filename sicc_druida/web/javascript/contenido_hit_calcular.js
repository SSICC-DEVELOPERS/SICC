var formName = "formulario";

function onLoadPag() {    
    	
	var errDescripcion = get('formulario.errDescripcion');
	if (errDescripcion !='') {		
		var errCodigo = get('formulario.errCodigo');
		var wnd = fMostrarMensajeError(errCodigo, errDescripcion);
	}

	configurarMenuSecundario('formulario');	
	DrdEnsanchaConMargenDcho('listado1',12);
	ocultarLista();
	ocultaBotonesRep();
	eval (ON_RSZ); 
	focaliza('formulario.cbCentroDistribucion');

	// C.Dist. Defecto
	var centDist = get("formulario.hCentDist");
	if( centDist != null &&  centDist != "" ){
		set('formulario.cbCentroDistribucion', [centDist]);
		onChangeCbCentroDistribucion();
	}
    
    /*
     * SPLATAS - 17/04/2006 -  Inc.BELC400000377
     * Se carga la fecha del sistema en el textbox 'FechaFacturacion'
     */
    var fecha = get('formulario.hFecha'); 
    set('formulario.txtFacturacion', fecha);
    

}

//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
function ocultarLista() {

	document.all["Cplistado1"].style.visibility='hidden';
	document.all["CpLin1listado1"].style.visibility='hidden';
	document.all["CpLin2listado1"].style.visibility='hidden';
	document.all["CpLin3listado1"].style.visibility='hidden';
	document.all["CpLin4listado1"].style.visibility='hidden';
	document.all["ret1Div"].style.visibility='hidden';
	document.all["ava1Div"].style.visibility='hidden';
	
}

//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
function mostrarLista() {

	document.all["Cplistado1"].style.visibility='';
	document.all["CpLin1listado1"].style.visibility='';
	document.all["CpLin2listado1"].style.visibility='';
	document.all["CpLin3listado1"].style.visibility='';
	document.all["CpLin4listado1"].style.visibility='';
	document.all["ret1Div"].style.visibility='';
	document.all["ava1Div"].style.visibility='';
	
}


//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
function ocultaBotonesRep(){

	document.all["btReporteAbast"].style.visibility='hidden';
	document.all["btReporteBalanceo"].style.visibility='hidden';
}

//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
function muestraBotonesRep(){

	document.all["btReporteAbast"].style.visibility='';
	document.all["btReporteBalanceo"].style.visibility='';
}

//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
function onChangeCbCentroDistribucion(){

	var centDist = get("formulario.cbCentroDistribucion");
	var idioma = get("formulario.hIdioma");

    var arr = new Array();
    arr[arr.length] = new Array("oid", centDist);
    arr[arr.length] = new Array("oidIdioma", idioma);
	recargaCombo('formulario.cbMapaCentroDistribucion', 'APEObtenerMapasCDPorCD', 'es.indra.sicc.util.DTOOID', arr);

	set_combo('formulario.cbMapaZonas', [['', '']], '');

}

//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
function onChangeCbMapaCentroDistribucion(){

	var centDist = get("formulario.cbCentroDistribucion");
	var mapaCD = get("formulario.cbMapaCentroDistribucion");
	var idioma = get("formulario.hIdioma");

    if( mapaCD != '' ){
		var arr = new Array();
		arr[arr.length] = new Array("oid", mapaCD);
		arr[arr.length] = new Array("oidIdioma", idioma);
		recargaCombo('formulario.cbMapaZonas', 'APEObtenerMapaZonaPorMapaCD', 'es.indra.sicc.util.DTOOID', arr);
	
	} else {
		set_combo('formulario.cbMapaZonas', [['', '']], '');
	}

}

//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
function onChangeCbMarca(){
    
    /*
     *  SPLATAS: Se elimina según Inc.BELC400000377
     *
     *   var marca = get("formulario.cbMarca");
     *   var pais = get("formulario.hPais");
     *
     *   var arr = new Array();
     *   arr[arr.length] = new Array("pais", pais);
     *   arr[arr.length] = new Array("marca", marca);
     * 
     *   recargaCombo('formulario.cbPeriodo', 'CRAObtienePeriodos', 'es.indra.sicc.dtos.cra.DTOPeriodo', arr);
     */
}

//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
function onChangeCbCanal(){
    
	/*
     *  SPLATAS: Se elimina según Inc.BELC400000377
     *
     *
     *  var canal = get("formulario.cbCanal");
	 *  var pais = get("formulario.hPais");
     *
     * var arr = new Array();
     * arr[arr.length] = new Array("canal", canal);
     * arr[arr.length] = new Array("pais", pais);
     *    
     * recargaCombo('formulario.cbPeriodo', 'CRAObtienePeriodos', 'es.indra.sicc.dtos.cra.DTOPeriodo', arr);
     */
}


//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
function onClickAceptar() {
    
    if(sicc_validaciones_generales()) {   
        var parametros = armarArray();

        configurarPaginado( mipgndo, 
            'APECalcularHit', 
            'ConectorCalcularHit',
            'es.indra.sicc.dtos.ape.DTOCalcularHit',
            parametros );
    }        
}


//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
function armarArray()  {
    
	var array = new Array();

    array[array.length] = new Array('oidCentroDistribucion', get('formulario.cbCentroDistribucion'));
    array[array.length] = new Array('oidMapaCentroDistribucion', get('formulario.cbMapaCentroDistribucion'));
    array[array.length] = new Array('oidMapaZona', get('formulario.cbMapaZonas'));
    
    array[array.length] = new Array('fechaFactu', get('formulario.txtFacturacion')); //'18-04-2007' );        //

    return array;
}

//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
function fLimpiar(){
	
	// C.Dist. Defecto
	var centDist = get("formulario.hCentDist");
	if( centDist != null &&  centDist != "" ){
		set('formulario.cbCentroDistribucion', [centDist]);
		onChangeCbCentroDistribucion();
	}

	set_combo('formulario.cbMapaCentroDistribucion', [['', '']], '');
	set_combo('formulario.cbMapaZonas', [['', '']], '');
	set('formulario.cbMarca', '');
	set('formulario.cbCanal', '');
	//set_combo('formulario.cbPeriodo', [['', '']], '');

	ocultarLista();
	ocultaBotonesRep();

}	

//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
function muestraLista(ultima, rowset, error){

    var tamano = rowset.length;
    if (tamano > 0) {
        
        mostrarLista();
        muestraBotonesRep();
        eval(ON_RSZ);
        return true;
    
    } else {
        
        ocultarLista();
        ocultaBotonesRep();
        focaliza("formulario.cbCentroDistribucion");
        return false;
    }

}
