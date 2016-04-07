var FORMULARIO = 'frmFormulario';

function onLoadPag() {
	
	var errDescripcion = get(FORMULARIO + '.errDescripcion');
	if(errDescripcion != '') {
		var errCodigo = get(FORMULARIO +'.errCodigo');
		var wnd = fMostrarMensajeError(errCodigo, errDescripcion);
	}

	// vbongiov -- Cambio 20080756 -- 29/04/2009
	accion('frmFormulario.txtCantidadMinima', '.disabled=true');
    accion('frmFormulario.txtCantidadPeriHaciaAtras', '.disabled=true');

	visibilidad('capaAniadir','O');
	visibilidad('capaEspacio','O');
	ocultarLista();
	
	// se cargan los combos marca y canal con los valores por defecto para el usuario
	// y se llama a un metodo de cambio de marca y canal para que se recargue el combo 
	// de subgerencia de ventas y los combos de periodo
	set(FORMULARIO + '.cbMarca', [get(FORMULARIO + '.marcaPorDefecto')]);
	set(FORMULARIO + '.cbCanal', [get(FORMULARIO + '.canalPorDefecto')]);
	cbMarcaOnChange();
	
	focaliza(FORMULARIO + '.chkConsultorasReincidentes');

	configurarMenuSecundario(FORMULARIO);	
}


// vbongiov -- Cambio 20080756 -- 29/04/2009
function onSelectedConsultorasReincidentes() {

	 var ckConsultorasReincidentes = get(FORMULARIO + '.chkConsultorasReincidentes');
    
    if (ckConsultorasReincidentes == 'S' ){
      accion('frmFormulario.txtCantidadMinima', '.disabled=false');
	  accion('frmFormulario.txtCantidadPeriHaciaAtras', '.disabled=false');
      
    } else {
          
	  set(FORMULARIO+'.txtCantidadMinima','');
	  set(FORMULARIO+'.txtCantidadPeriHaciaAtras','');

	  accion('frmFormulario.txtCantidadMinima', '.disabled=true');
	  accion('frmFormulario.txtCantidadPeriHaciaAtras', '.disabled=true');
    }
}


function cbMarcaOnChange() {
	// Si se han seleccionado valor para el combo cbCanal 
	// { 
	// recargaPeriodo() 
	// } 
	if (get(FORMULARIO + '.cbMarca') != '') {
	   if (get(FORMULARIO + '.cbCanal') != '') {
	   	recargaSubgerencia(); // incidencia 15960
	   }
	} else {
	   vaciaCombo(FORMULARIO + '.cbSubgerenciaVentas');
		vaciaCombo(FORMULARIO + '.cbRegion');
	   vaciaCombo(FORMULARIO + '.cbZona');
	   vaciaCombo(FORMULARIO + '.cbSeccion');	   
	}
}

function cbCanalOnChange() {
	// Si se han seleccionado valor para el combo cbMarca 
	// { 
	// recargaPeriodo() 
	// } 
	if (get(FORMULARIO + '.cbCanal') != '') {
	   if (get(FORMULARIO + '.cbMarca') != '') {
			recargaPeriodo();
			recargaSubgerencia(); // incidencia 15960
	   }
	} else {
	   vaciaCombo(FORMULARIO + '.cbSubgerenciaVentas');
		vaciaCombo(FORMULARIO + '.cbRegion');
	   vaciaCombo(FORMULARIO + '.cbZona');
	   vaciaCombo(FORMULARIO + '.cbSeccion');	   
	}
}

function recargaPeriodo() {

   // Llamar al método recargaCombo utilizando el DTOPeriodo y el idBusiness = "CRAObtenerPeriodosPosteriores". 
   // Parametros del DTOPeriodo: 
   // - DTOPeriodo.oidPais = oid del pais activo 
   // - DTOPeriodo.oidMarca = oid de la marca seleccionada 
   // - DTOPeriodo.oidCanal = oid del canal seleccionado 

   // Obtenemos un DTOSalida y cargamos el combo: 
   // - cbPeriodo 
   // - cbPeriodoInicial 
	// - cbPeriodoFinal 
	var dtoPeriodo = [         
		                  ["pais", get(FORMULARIO + '.pais')],
		                  ["oidPais", get(FORMULARIO + '.pais')], 
		                  ["oidIdioma", get(FORMULARIO + '.idioma')],
		                  ["marca", get(FORMULARIO + '.cbMarca')],
		                  ["canal", get(FORMULARIO + '.cbCanal')]
				     		];

   // Antes se utilizaba CRAObtenerPeriodosPosteriores, 20080560 
   recargaCombo(FORMULARIO + '.cbPeriodo', 
				     'CRAObtenerPeriodosPosterioresActivos', 
				     'es.indra.sicc.dtos.cra.DTOPeriodo', 
				     dtoPeriodo
				     );
   // BELC300020479. Antes se utilizaba CRAObtenerPeriodosPosteriores
   recargaCombo(FORMULARIO + '.cblPeriodoInicialEvaluacion', 
				     'CRAObtenerPeriodos', 
				     'es.indra.sicc.dtos.cra.DTOPeriodo', 
				     dtoPeriodo 
				     );
   
   // BELC300020479. Antes se utilizaba CRAObtenerPeriodosPosteriores
   recargaCombo(FORMULARIO + '.cbPeriodoFinalEvaluacion', 
				     'CRAObtenerPeriodos', 
				     'es.indra.sicc.dtos.cra.DTOPeriodo', 
				     dtoPeriodo 
				     );
}		     				     

// por incidencia BELC300015966 se utiliza "ZONRecargaRegiones"
function cbSubgerenciaVentasOnChange() {
	// Llamar al método recargaCombo utilizando el DTOUnidadAdministrativa y el idBusiness = "ZONObtenerRegionesPorSGV". 

	// Parametros del DTOUnidadAdministrativa: 
	// - oidSGV = oid del valor seleccionado en cbSubgerenciaVentas 

	// Obtenemos un DTOSalida y cargamos el combo cbRegion	
	if (get(FORMULARIO + '.cbSubgerenciaVentas') != '') {
		
	   vaciaCombo(FORMULARIO + '.cbZona');
	   vaciaCombo(FORMULARIO + '.cbSeccion');
		
	   recargaCombo(FORMULARIO + '.cbRegion', 
					     'ZONRecargaRegiones', 
					     'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa', 
					     [         
		                  ["oidPais", get(FORMULARIO + '.pais')],
		                  ["oidIdioma", get(FORMULARIO + '.idioma')],
		                  ["oidSGV", get(FORMULARIO + '.cbSubgerenciaVentas')]
					     ]
					     );	
	} else {
		vaciaCombo(FORMULARIO + '.cbRegion');
	   vaciaCombo(FORMULARIO + '.cbZona');
	   vaciaCombo(FORMULARIO + '.cbSeccion');
	}
}

function cbRegionOnChange() {
	// Llamar al método recargaCombo utilizando el DTOUnidadAdministrativa y el idBusiness = "ZONRecargaZonas". 

	// Parametros del DTOUnidadAdministrativa: 
	// - oidRegion = oid del valor seleccionado en cbRegion 

	// Obtenemos un DTOSalida y cargamos el combo cbZona
	if (get(FORMULARIO + '.cbRegion') != '') {
		
		vaciaCombo(FORMULARIO + '.cbSeccion');
	   
	   recargaCombo(FORMULARIO + '.cbZona', 
					     'ZONRecargaZonas', 
					     'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa', 
					     [         
		                  ["oidPais", get(FORMULARIO + '.pais')],
		                  ["oidIdioma", get(FORMULARIO + '.idioma')],
		                  ["oidRegion", get(FORMULARIO + '.cbRegion')]
					     ]
					     );	
	} else {
	   vaciaCombo(FORMULARIO + '.cbZona');
	   vaciaCombo(FORMULARIO + '.cbSeccion');
	}
}

function cbZonaOnChange() {
	// Llamar al método recargaCombo utilizando el DTOUnidadAdministrativa y el idBusiness = "ZONRecargaSecciones". 
	// Parametros del DTOUnidadAdministrativa: 
	// - oidZona = oid del valor seleccionado en cbZona 
	// Obtenemos un DTOSalida y cargamos el combo cbSeccion 	
	if (get(FORMULARIO + '.cbZona') != '') {
	   // Incidencia Sicc20080559
	   recargaCombo(FORMULARIO + '.cbSeccion', 
					     'ZONRecargaSecciones', 
					     'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa', 
					     [         
		                  ["oidPais", get(FORMULARIO + '.pais')],
		                  ["oidIdioma", get(FORMULARIO + '.idioma')],
		                  ["oidZona", get(FORMULARIO + '.cbZona')]
					     ]
					     );	
	} else {
		vaciaCombo(FORMULARIO + '.cbSeccion');
	}
}

// vbongiov -- Cambio 20080756 -- 29/04/2009
function btnDetalleOnClick() {

	if(sicc_validaciones_generales("gDetalle")) {

	     var arr = new Array();
         
		 var idioma = get("formulario.idioma");
		 arr[arr.length] = new Array("oidIdioma", idioma);		

		 arr[arr.length] = new Array("oidTipoRevision", get(FORMULARIO + '.tipoOrdenChequeo'));          
		 arr[arr.length] = new Array("oidSubgerenciaVentas", get(FORMULARIO + '.cbSubgerenciaVentas'));  
		 arr[arr.length] = new Array("oidRegion", get(FORMULARIO + '.cbRegion')); 
		 arr[arr.length] = new Array("oidZona", get(FORMULARIO + '.cbZona')); 
		 arr[arr.length] = new Array("oidSeccion", get(FORMULARIO + '.cbSeccion')); 

         visibilidad('capaAniadir','V');
		 visibilidad('capaEspacio','V');
		 mostrarLista();
		 
		 configurarPaginado(mipgndo,"RECObtenerChequeoLineaCampo","ConectorObtenerChequeoLinea",
														"es.indra.sicc.dtos.rec.DTOChequeoZona",arr);     

  }
}

function onClickAniadir() {

	if(sicc_validaciones_generales("gDetalle")) {

		  var obj = new Object();
	 
		  obj.accion = 'aniadirLineaCampo';
		  obj.oidTipoChequeo = get(FORMULARIO + '.tipoOrdenChequeo');
		  obj.oidMarca = get(FORMULARIO + '.cbMarca');
		  obj.oidCanal = get(FORMULARIO + '.cbCanal');
		  obj.oidSubgerencia = get(FORMULARIO + '.cbSubgerenciaVentas');
		  obj.oidRegion = get(FORMULARIO + '.cbRegion');
		  obj.oidZona = get(FORMULARIO + '.cbZona');
		  obj.oidSeccion = get(FORMULARIO + '.cbSeccion');
		  
		  var retorno = mostrarModalSICC('LPIntroducirOrdenesChequeos', 'aniadirLineaCampo', obj, '500', '200');
	}
}

// vbongiov -- Cambio 20080756 -- 29/04/2009
function mostrarLista(){

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
    
    eval (ON_RSZ);    
}

// vbongiov -- Cambio 20080756 -- 29/04/2009
function ocultarLista(){

    DrdEnsanchaConMargenDcho('listado1',12);
    document.all["Cplistado1"].style.visibility='hidden'; 
    document.all["CpLin1listado1"].style.visibility='hidden';  
    document.all["CpLin2listado1"].style.visibility='hidden'; 
    document.all["CpLin3listado1"].style.visibility='hidden';
    document.all["CpLin4listado1"].style.visibility='hidden';  
    
    document.all["primera1Div"].style.visibility='hidden'; 
    document.all["ret1Div"].style.visibility='hidden';
    document.all["ava1Div"].style.visibility='hidden';  
    document.all["separaDiv"].style.visibility='hidden'; 
    
    eval (ON_RSZ);    
}

function fGuardar() {
	
	if(sicc_validaciones_generales("gDetalle") && sicc_validaciones_generales("gGuardar")) {
		
		  set(FORMULARIO + '.accion', 'Guardar chequeo en linea');
		  set(FORMULARIO + '.conectorAction', "LPIntroducirOrdenesChequeos");
          enviaSICC(FORMULARIO, null, null, 'N');
	}
}

function fLimpiar() {
	
   set(FORMULARIO + '.cbMarca', [get(FORMULARIO + '.marcaPorDefecto')]);
   set(FORMULARIO + '.cbCanal', [get(FORMULARIO + '.canalPorDefecto')]);
   cbMarcaOnChange();
   
   vaciaCombo(FORMULARIO + '.cbRegion');
   vaciaCombo(FORMULARIO + '.cbZona');
   vaciaCombo(FORMULARIO + '.cbSeccion');
	
   set(FORMULARIO + '.chkConsultorasReincidentes', 'N');	
   set(FORMULARIO+'.txtCantidadMinima','');
   set(FORMULARIO+'.txtCantidadPeriHaciaAtras','');

   accion('frmFormulario.txtCantidadMinima', '.disabled=true');
   accion('frmFormulario.txtCantidadPeriHaciaAtras', '.disabled=true');

   set(FORMULARIO + '.chkConsultorasNuevas', 'N');

   focaliza(FORMULARIO + '.cbMarca');
}

function vaciaCombo(combo) {
	set_combo(combo, [['','']], ['']);	
}

function validarCantidad() {
	if (get(FORMULARIO + '.txtCantidadMinima') != '') {
		if (isNaN(get(FORMULARIO + '.txtCantidadMinima'))) {
			// se muestra mensaje '1256': "Debe ingresar numeros en este campo"
			GestionarMensaje('1256');
			focaliza(FORMULARIO + '.txtCantidadMinima');
		}
	}
}


function fVolver() {
	window.close();
}

// creado por incidencia 15960
function recargaSubgerencia() {
	// Llamar al método recargaCombo utilizando el DTOUnidadAdministrativa y el 
	// idBusiness = "ZONRecargaSubgerenciaVentas". 

	// Parametros del DTOUnidadAdministrativa: 
	// - DTOUnidadAdministrativa.oidPais = oid del pais activo 
	// - DTOUnidadAdministrativa.oidMarca = oid de la marca seleccionada 
	// - DTOUnidadAdministrativa.oidCanal = oid del canal seleccionado 

	// Obtenemos un DTOSalida y cargamos el combo: 
	// - cbSubgerenciaVentas
   recargaCombo(FORMULARIO + '.cbSubgerenciaVentas', 
				     'ZONRecargaSubgerenciaVentas', 
				     'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa', 
				     [         
	                  ["oidPais", get(FORMULARIO + '.pais')],
	                  ["oidIdioma", get(FORMULARIO + '.idioma')],
	                  ["oidMarca", get(FORMULARIO + '.cbMarca')],
	                  ["oidCanal", get(FORMULARIO + '.cbCanal')]
				     ]
				     );	
}

function focalizaChkConsultorasReincidentes(){
	if(get_visibilidad('capaAniadir')){
		focalizaBotonHTML('botonContenido','Aniadir');
	} else {
		focaliza(FORMULARIO + '.chkConsultorasReincidentes');
	}
}

function focalizaShTab(){
	if(get_visibilidad('capaAniadir')){
		focalizaBotonHTML('botonContenido','Aniadir');
	} else {
		focalizaBotonHTML('botonContenido','btnDetalle');
	}
}

function focalizaShBoton(){
  focalizaBotonHTML('botonContenido','btnDetalle');
}

function focalizaConsultorasReincidentes(){	
	focaliza(FORMULARIO + '.chkConsultorasReincidentes');
}