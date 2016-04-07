var fechaActual = '';

function onLoad(){
    configurarMenuSecundario('formulario');
	fechaActual = get('formulario.txtFecha','V')
    ocultarLista();
    focaliza('formulario.cbCentroDistribucion');
}

function onChangeMarcaCanal(){
    var marca  = get('formulario.cbMarca');
    var canal  = get('formulario.cbCanal');
    if(marca != '' && canal != ''){
         // Inicializa combo
         var opciones = new Array();
         set_combo('formulario.cbZona',opciones);                            
         combo_add('formulario.cbZona', '', '');
         // Recarga combo
         var arr = new Array();
         arr[arr.length] = ['oidIdioma', get('formulario.varIdioma')]; 
         arr[arr.length] = ['oidPais', get('formulario.varPais')]; 
         arr[arr.length] = ['oidMarca', marca];
         arr[arr.length] = ['oidCanal', canal];
         recargaCombo('formulario.cbRegion', 'ZONRecargaRegiones', 'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa',arr);
         // Pone en blanco combos dependientes
         var aCombo = new Array(new Array('',''));
         set_combo('formulario.cbZona', aCombo, []);
         set_combo('formulario.cbSeccion', aCombo, []);
    }else{
         var aCombo = new Array(new Array('',''));
         set_combo('formulario.cbRegion', aCombo, []);
         set_combo('formulario.cbZona', aCombo, []); 
         set_combo('formulario.cbSeccion', aCombo, []); 
    }
}

function onChangeRegion(){
    var region = get('formulario.cbRegion');
    if(region!=''){
         // Inicializa combo
         var opciones = new Array();
         set_combo('formulario.cbZona',opciones);                            
         combo_add('formulario.cbZona', '', '');
         // Recarga combo
         var arr = new Array();
         arr[arr.length] = ["oidIdioma", get('formulario.varIdioma')]; 
         arr[arr.length] = ["oidPais", get('formulario.varPais')]; 
         arr[arr.length] = ["oidRegion", region];
         recargaCombo('formulario.cbZona', 'ZONRecargaZonas', 'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa', arr);
         // Pone en blanco combos dependientes
         var aCombo = new Array(new Array('',''));
         set_combo('formulario.cbSeccion', aCombo, []);
    }else{
         var aCombo = new Array(new Array('',''));
         set_combo('formulario.cbZona', aCombo, []);
         set_combo('formulario.cbSeccion', aCombo, []);
    }
}

function onChangeZona(){
    var zona = get('formulario.cbZona');
    if(zona!=''){
         // Inicializa combo
         var opciones = new Array();
         set_combo('formulario.cbSeccion',opciones);                            
         combo_add('formulario.cbSeccion', '', '');
         // Recarga combo
         var arr = new Array();
         arr[arr.length] = ['oidIdioma', get('formulario.varIdioma')]; 
         arr[arr.length] = ['oidPais', get('formulario.varPais')]; 
         arr[arr.length] = ['oidZona', zona];
         recargaCombo('formulario.cbSeccion', 'ZONRecargaSecciones', 'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa', arr);
    }else{
         var aCombo = new Array(new Array('',''));
         set_combo('formulario.cbSeccion', aCombo, []); 
    }
}

function accionBuscar(){
    if (!sicc_validaciones_generales()) {
         return false;
    }
    var parametros = new Array();
    parametros[parametros.length] = new Array('oidIdioma', get('formulario.varIdioma'));
    parametros[parametros.length] = new Array('oidPais', get('formulario.varPais'));
    var oidCentroDistribucion = get('formulario.cbCentroDistribucion','V');
    var fecha = get('formulario.txtFecha','V');
    var oidMarca = get('formulario.cbMarca','V');
    var oidCanal = get('formulario.cbCanal','V');
    var oidRegion = get('formulario.cbRegion','V');
    var oidZona = get('formulario.cbZona','V');
    var oidSeccion = get('formulario.cbSeccion','V');
    // Completando DTO
    if (oidCentroDistribucion != ''){
          parametros[parametros.length] = new Array('oidCentroDistribucion', oidCentroDistribucion);
    }
    if (fecha != ''){
          parametros[parametros.length] = new Array('fecha', fecha);
    }
    if (oidMarca != ''){
          parametros[parametros.length] = new Array('oidMarca', oidMarca);
    }
    if (oidCanal != ''){
          parametros[parametros.length] = new Array('oidCanal', oidCanal);
    }
    if (oidRegion != ''){
          parametros[parametros.length] = new Array('oidRegion', oidRegion);
    }
    if (oidZona != ''){
          parametros[parametros.length] = new Array('oidZona', oidZona);
    }
    if (oidSeccion != ''){
          parametros[parametros.length] = new Array('oidSeccion', oidSeccion);
    }
    // Carga de lista editable
    configurarPaginado(mipgndo,
          'APEBuscarListaPicadoCubicaje',
          'ConectorBuscarListaPicadoCubicaje',
          'es.indra.sicc.dtos.ape.DTOImpresionFP',
          parametros);
}

function accionAsignarPallet(){
    if (!sicc_validaciones_generales()) {
         return false;
    }
    listado1.actualizaDat();
    var codSeleccionados = listado1.codSeleccionados();
    if (codSeleccionados.length > 1) {
        GestionarMensaje('1022');
        return;
    }
    if ( codSeleccionados.length < 1) {
        GestionarMensaje('4');
        return;
    }
    
    var obj = new Object();
    obj.oidListaPicadoCabecera = codSeleccionados[0];
    
    var retorno = mostrarModalSICC('LPCubicajeAFP', 'buscarListaDatosPallet', obj);
}

function accionVerDatosAgrup(){
    if (!sicc_validaciones_generales()) {
         return false;
    }
    listado1.actualizaDat();
    var codSeleccionados = listado1.codSeleccionados();
    if (codSeleccionados.length > 1) {
        GestionarMensaje('1022');
        return;
    }
    if ( codSeleccionados.length < 1) {
        GestionarMensaje('4');
        return;
    }
    
    var obj = new Object();
    obj.oidCentroDistribucion = get('formulario.cbCentroDistribucion','V');
    obj.codAgrupacion = listado1.extraeDato(codSeleccionados[0], 4);
    //obj.marca
    //obj.canal
    //obj.region
    //obj.zona
    //obj.seccion
    var retorno = mostrarModalSICC('LPCubicajeAFP', 'datosAgrupacionVer', obj);
}

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
    document.all["AsignarPalletDiv"].style.visibility='hidden';
    document.all["VerDatosAgrupDiv"].style.visibility='hidden';
}

function mostrarLista(){

    DrdEnsanchaConMargenDcho('listado1',12);
    document.all["Cplistado1"].style.visibility='visible';
    document.all["CpLin1listado1"].style.visibility='visible';
    document.all["CpLin2listado1"].style.visibility='visible';
    document.all["CpLin3listado1"].style.visibility='visible';
    document.all["CpLin4listado1"].style.visibility='visible';
    document.all["primera1Div"].style.visibility='hidden';
    document.all["ret1Div"].style.visibility='hidden';
    document.all["ava1Div"].style.visibility='hidden';
    document.all["separaDiv"].style.visibility='hidden';
    document.all["AsignarPalletDiv"].style.visibility='visible';
    document.all["VerDatosAgrupDiv"].style.visibility='visible';
    eval (ON_RSZ);
}

function muestraLista(ultima, rowset) {
    if (rowset && rowset!=null && rowset.length > 0) {
        mostrarLista();
        return true; 
    }else{
        ocultarLista();
        focaliza('formulario.cbCentroDistribucion');
        return false;  
    }
}

function fLimpiar() {
    ocultarLista();
    set('formulario.txtFecha', fechaActual);
    
    set_combo('formulario.cbSeccion', new Array(['','']));
    set_combo('formulario.cbZona', new Array(['','']));
    set_combo('formulario.cbRegion', new Array(['','']));
    
    set("formulario.cbCanal", ['']);
    set("formulario.cbMarca", ['']);
    set("formulario.cbCentroDistribucion", ['']);
    
	focaliza('formulario.cbCentroDistribucion');
}

