var formatoFechaUsuario = '';
var formName 			= 'frmFormulario.';
var formNameSinPunto    = 'frmFormulario';
var aVacio 		        = new Array();
var aVacio2 		    = new Array();
aVacio2[0] = ['',''];
var bInsertar 	= null;

var permitidos = "abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZ0123456789_";
			
var sociedadSeleccion = new Array();
var paisSeleccion = new Array();
var marcaSeleccion = new Array();
var canalSeleccion = new Array();
var accesoSeleccion = new Array();
var subAccesoSeleccion = new Array();
var subGerenciaVentasSeleccion = new Array();
var regionSeleccion = new Array();
var zonaSeleccion = new Array();
var seccionSeleccion = new Array();
var territorioSeleccion =new Array();

var paisDefectoSeleccion = new Array();
var SGVDefectoSeleccion = new Array();
var zonaDefectoSeleccion = new Array();
var regionDefectoSeleccion = new Array();
var seccionDefectoSeleccion = new Array();
var territorioDefectoSeleccion = new Array();
var sociedadDefectoSeleccion = new Array();
var marcaDefectoSeleccion = new Array();
var canalDefectoSeleccion = new Array();
var accesoDefectoSeleccion = new Array();
var subAccesoDefectoSeleccion = new Array();

var tipoUsuarioSeleccion = new Array();
var idiomaSeleccion = new Array();
var tipoRastreoSeleccion = new Array();
var pantallaInicioAsociadaSeleccion = new Array();


function fLimpiar()  {	
    set(formName + 'areatxtObservaciones','');
    
    set(formName + 'rbClaveInicial','S');
    set(formName + 'rbUsuarioHabilitado','S');
    set(formName + 'ckAdminNDG', 'N');
    set(formName + 'ckIndNDG', 'N');
    accion( formName + 'ckAdminNDG','.disabled=true');
    var a = new Array('cbSociedad', 'cbAcceso', 'cbSubacceso', 'cbSubgerenciaVentas', 'cbRegion', 'cbZona', 'cbSeccion', 'cbTerritorio', 'cbPaisPorDefecto', 'cbSGVPorDefecto', 'cbRegionPorDefecto', 'cbZonaPorDefecto', 'cbSeccionPorDefecto', 'cbTerritorioPorDefecto', 'cbSociedadPorDefecto', 'cbMarcaPorDefecto', 'cbCanalPorDefecto', 'cbAccesoPorDefecto', 'cbSubaccesoPorDefecto');
    for (var i = 0 ; i < a.length; i++) {
        set_combo(formName + a[i] ,aVacio2);
    }
    var casudeUso = get(formName + 'casoUso');
    if (casudeUso == 'modificar'){
        inicializar(false);
    }
    
    focaliza(formName + 'txtUsuario');
}

function reInicio()  {
    fLimpiarGenericoSICC();
    var a = new Array('cbSociedad', 'cbAcceso', 'cbSubacceso', 'cbSubgerenciaVentas', 'cbRegion', 'cbZona', 'cbSeccion', 'cbTerritorio', 'cbPaisPorDefecto', 'cbSGVPorDefecto', 'cbRegionPorDefecto', 'cbZonaPorDefecto', 'cbSeccionPorDefecto', 'cbTerritorioPorDefecto', 'cbSociedadPorDefecto', 'cbMarcaPorDefecto', 'cbCanalPorDefecto', 'cbAccesoPorDefecto', 'cbSubaccesoPorDefecto');
    inicializar(true);
    for (var i = 0 ; i < a.length; i++) {
        set_combo(formName + a[i] ,aVacio);
    }
}

function focalizaSiguiente() {
    try {
        focaliza(formName + 'ckAdminNDG');					
    } catch (x)	{
        focalizarSiguiente2();	
    }
}

function focalizaSiguiente() {
    try {
        focaliza(formName + 'txtUsuario');					
    } catch (x)	{
        focaliza(formName + 'rbClaveInicial');					
    }
}


function focalizaAnterior() {
    try {
        focaliza(formName + 'txtUsuario');					
    } catch (x)	{
        focalizaAnterior2();
    }
}

function focalizaAnterior2() {
    try {
        focaliza(formName + 'ckAdminNDG');					
    } catch (x)	{
        focaliza(formName + 'ckIndNDG');					
    }
}


function reConsulta() {
    //window.dialogArguments.parametros.window.enviarFormulario();
    window.returnValue = true;
    window.close();
}


function validarAlfanumericoConEspeciales(valor){
    var c;
    
    for(var i=0; i<valor.length; i++) 
    {
        c = valor.charAt(i);
        if (permitidos.indexOf(c) == -1 ) 
            return false;
    }
    return true;
}

function inicializar(bCasoDeUso){
    if(get(formName + 'casoUso')=='consultar'){
        allReadonly();
    }
    accion( formName + 'ckAdminNDG','.disabled=true');
    if (!fMostrarMensajeError()) {
        bInsertar = bCasoDeUso;
        llenarCombos();
        if(bInsertar){
            focaliza(formName + 'txtUsuario','');
        } else {
            if (ie) { 
                accion( formName + 'txtUsuario','.disabled=true'); 
            }
            //marcarSeleccionCombos();
            focaliza(formName + 'txtClaveAcceso','');
      }
    }
    habilitaRastreoySustitucion();				
    configurarMenuSecundario("frmFormulario");
} 

function verificarCamposRastreo(){
    if(get(formName + 'casoUso')=='consultar'){
        return;
    }
    var seleccionRastreo = get(formName + 'cbTipoRastreo');
    if (seleccionRastreo[0]=='NO' || seleccionRastreo[0]==null || seleccionRastreo[0]==''){
        accion( formName + 'txtFechaFinRastreo','.disabled=true');
        accion( formName + 'txtFechaInicioRastreo','.disabled=true');
        set( formName + 'txtFechaFinRastreo','');
        set( formName + 'txtFechaInicioRastreo','');
    } else {
        accion( formName + 'txtFechaFinRastreo','.disabled=false');
        accion( formName + 'txtFechaInicioRastreo','.disabled=false');
    }
}

function verificarCamposSust(){
    if(get(formName + 'casoUso')=='consultar'){
        return;
    }
    var seleccionSustitucion = get(formName + 'cbUsuarioSustitucion');
    if (seleccionSustitucion[0]!= null && seleccionSustitucion[0]!=''){
        accion( formName + 'txtFechaSustitucionDesde','.disabled=false');
        accion( formName + 'txtFechaSustitucionHasta','.disabled=false');
        accion( formName + 'areatxtObservaciones','.disabled=false');
    } else {
        accion( formName + 'txtFechaSustitucionDesde','.disabled=true');
        accion( formName + 'txtFechaSustitucionHasta','.disabled=true');
        accion( formName + 'areatxtObservaciones','.disabled=true');
        set( formName + 'txtFechaSustitucionDesde','');
        set( formName + 'txtFechaSustitucionHasta','');
        set( formName + 'areatxtObservaciones','');
    }
}

function llenarCombos(){
    asignarValoresCombo('cbTipoUsuario');
    asignarValoresCombo('cbTipoRastreo');
    asignarValoresCombo('cbUsuarioSustitucion');
    if(!bInsertar) { //es modificación
       recargarValoresCombos();
    }
}

//Carga los valores iniciales de los combos.
function asignarValoresCombo(combo){
    if (combo == 'cbUsuarioSustitucion'){
        var arr = new Array();
        arr[arr.length] = ['oidIdioma', get(formName + 'hIdioma')];
        var usuario = get(formName + 'txtUsuario');
        if (usuario!=''){
            arr[arr.length] = ['cadena', usuario];
        }
        recargaCombo(formName + "cbUsuarioSustitucion", "MENRecuperaUsuariosSustitucion", "es.indra.sicc.util.DTOString", arr, 'postRecarga("cbUsuarioSustitucion",datos);');
    }
    if (combo == 'cbTipoUsuario'){
        var opciones = new Array();
        
        opciones[0]=['',''];
        opciones[1]=['INTERACTIVO',GestionarMensaje('88',null,null,null)];
        opciones[2]=['TERCERO',GestionarMensaje('90',null,null,null)];
        opciones[3]=['BATCH',GestionarMensaje('89',null,null,null)];
        
        set_combo(formName + combo, opciones );
        ordenaCombo_SICC(eval(combo));
    }
                           
    if (combo == 'cbTipoRastreo'){
        var opciones = new Array();
        
        opciones[0]=['',''];
        opciones[1]=['ACCESO', GestionarMensaje('1090',null,null,null)];
        opciones[2]=['NO', GestionarMensaje('1011',null,null,null)];
        opciones[3]=['TOTAL', GestionarMensaje('1091',null,null,null)];
        
        set_combo(formName + combo, opciones );
        ordenaCombo_SICC(eval(combo));
    }
                           
    set(formName + combo,aVacio); //Deselecciono cualquier valor.
}

//Segun el combo clickeado actualiza los combos relacionados.
function actualizarSeleccion(cmbPadre){
    var opciones = null;
    guardoSeleccionados();
    if (cmbPadre == 'cbSociedad'){
        //cargarAsociado(cmbPadre, cmbPadre + 'PorDefecto');
        recargaSociedadDF();
    }
    if (cmbPadre == 'cbMarca'){
        recargaSGV();
        cargarAsociado(cmbPadre, cmbPadre+'PorDefecto');
    }
    if (cmbPadre == 'cbCanal'){
        recargaAcceso();
        recargaSGV();
        cargarAsociado(cmbPadre, cmbPadre+'PorDefecto');
    }
    if (cmbPadre == 'cbAcceso'){
        recargaSubAcceso();
        recargaAccesoDF();
        //cargarAsociado(cmbPadre, cmbPadre+'PorDefecto');
    }
    if (cmbPadre == 'cbSubacceso'){
        recargaSubAccesoDF();
        //cargarAsociado(cmbPadre, cmbPadre + 'PorDefecto');
    }
    if (cmbPadre == 'cbPais'){
        recargaSGV();
        recargaSociedad();
        cargarAsociado(cmbPadre, cmbPadre + 'PorDefecto');
    }
    if (cmbPadre == 'cbSubgerenciaVentas'){
        recargaRegion();
        recargaSGVDF();
        //cargarAsociado(cmbPadre, 'cbSGVPorDefecto');
    }
    if (cmbPadre == 'cbRegion'){
        recargaZona();
        recargaRegionDF();
        //cargarAsociado(cmbPadre, cmbPadre + 'PorDefecto');
    }
    if (cmbPadre == 'cbZona'){
        recargaSeccion();
        recargaZonaDF();
        //cargarAsociado(cmbPadre, cmbPadre + 'PorDefecto');
    }
    if (cmbPadre == 'cbSeccion'){
        recargaTerritorio();
        recargaSeccionDF();
        //cargarAsociado(cmbPadre, cmbPadre + 'PorDefecto');
    }
    if (cmbPadre == 'cbTerritorio'){
        recargaTerritorioDF();
        //cargarAsociado(cmbPadre, cmbPadre + 'PorDefecto');
    }
    if (cmbPadre == 'cbPerfil'){
        recargaPantallaInicio();
    }
    
    // No hay accion asociada a cambios en el combo cbSociedadPorDefecto
    //if (cmbPadre == 'cbSociedadPorDefecto'){
        // NULL
    //}
    if (cmbPadre == 'cbMarcaPorDefecto'){
        recargaSGVDF();
    }
    if (cmbPadre == 'cbCanalPorDefecto'){
        recargaAccesoDF();
        recargaSGVDF();
    }
    if (cmbPadre == 'cbAccesoPorDefecto'){
        recargaSubAccesoDF();
    }
    // No hay accion asociada a cambios en el combo cbSubaccesoPorDefecto
    //if (cmbPadre == 'cbSubaccesoPorDefecto'){
        // NULL
    //}
    if (cmbPadre == 'cbPaisPorDefecto'){
        recargaSGVDF();
        recargaSociedadDF();
    }
    if (cmbPadre == 'cbSGVPorDefecto'){
        recargaRegionDF();
    }
    if (cmbPadre == 'cbRegionPorDefecto'){
        recargaZonaDF();
    }
    if (cmbPadre == 'cbZonaPorDefecto'){
        recargaSeccionDF();
    }
    if (cmbPadre == 'cbSeccionPorDefecto'){
        recargaTerritorioDF();
    }
    // No hay accion asociada a cambios en el combo cbSubaccesoPorDefecto
    //if (cmbPadre == 'cbTerritorioPorDefecto'){
        // NULL
    //}
    
    //setearDefecto();
}

function recargaAcceso(){
    // Limpiar Combo
    set_combo(formName + 'cbAcceso',aVacio);
    combo_add(formName + 'cbAcceso', '', '');
    // Preparar valores
    var canales  = quitarItemVacio(get(formName + 'cbCanal'));
    var canaConc = new String();
    for(i=0;i<canales.length;i++){
        canaConc += canales[i] + "x";
    }
    // Recargar el combo si es necesario
    if(canaConc != ''){
        var arr = new Array();
        var peticion = "%"+canaConc.substring(0, canaConc.length-1)+"%z%%";
        arr[arr.length] = ['cadena', peticion];
        arr[arr.length] = ['oidIdioma', get(formName + 'hIdioma')];
        recargaCombo(formName + "cbAcceso", "MENRecargaAccesos", "es.indra.sicc.util.DTOString", arr, 'postRecarga("cbAcceso",datos);');
    }else{
        recargaSubAcceso();
    }
}

function recargaSubAcceso(){
    // Limpiar Combo
    set_combo(formName + 'cbSubacceso',aVacio);
    combo_add(formName + 'cbSubacceso', '', '');
    // Preparar valores
    var accesos  = quitarItemVacio(get(formName + 'cbAcceso'));
    var acceConc = new String();
    for(i=0;i<accesos.length;i++){
        acceConc += accesos[i] + "x";
    }
    // Recargar el combo si es necesario
    if(acceConc != ''){
        var arr = new Array();
        var peticion = "%"+acceConc.substring(0, acceConc.length-1)+"%z%%";
        arr[arr.length] = ['cadena', peticion];
        arr[arr.length] = ['oidIdioma', get(formName + 'hIdioma')];
        recargaCombo(formName + "cbSubacceso", "MENRecargaSubAccesos", "es.indra.sicc.util.DTOString", arr, 'postRecarga("cbSubacceso", datos);');
    }
}

function recargaSociedad(){
    // Limpiar Combo
    set_combo(formName + 'cbSociedad',aVacio);
    combo_add(formName + 'cbSociedad', '', '');
    // Preparar valores
    var paises   = quitarItemVacio(get(formName + 'cbPais'));
    var paisConc = new String();
    for(i=0;i<paises.length;i++){
        paisConc += paises[i] + "x";
    }
    // Siempre se recargan las sociedades
    var arr = new Array();
    arr[arr.length] = ['oidIdioma', get(formName + 'hIdioma')];
    if(paisConc != ''){
        var peticion = "%"+paisConc.substring(0, paisConc.length-1)+"%z%%";
        arr[arr.length] = ['cadena', peticion];
    }
    recargaCombo(formName + "cbSociedad", "MENRecargaSociedades", "es.indra.sicc.util.DTOString", arr, 'postRecarga("cbSociedad", datos);');
}

function recargaSGV(){
    // Limpiar Combo
    set_combo(formName + 'cbSubgerenciaVentas',aVacio);
    combo_add(formName + 'cbSubgerenciaVentas', '', '');
    // Preparar valores
    var marcas   = quitarItemVacio(get(formName + 'cbMarca'));
    var canales  = quitarItemVacio(get(formName + 'cbCanal'));
    var paises   = quitarItemVacio(get(formName + 'cbPais'));

    var marcConc = new String();
    for(i=0;i<marcas.length;i++){
        marcConc += marcas[i] + "x";
    }

    var canaConc = new String();
    for(i=0;i<canales.length;i++){
        canaConc += canales[i] + "x";
    }

    var paisConc = new String();
    for(i=0;i<paises.length;i++){
        paisConc += paises[i] + "x";
    }
    
    // Recargar el combo si es necesario
    if(marcConc != '' && canaConc != '' && paisConc != ''){
        marcConc = marcConc.substring(0, marcConc.length-1);
        canaConc = canaConc.substring(0, canaConc.length-1);
        paisConc = paisConc.substring(0, paisConc.length-1);
        var arr = new Array();
        var peticion = '%'+marcConc+'%z%'+canaConc+'%z%'+paisConc+'%z%%'
        arr[arr.length] = ['cadena', peticion];
        recargaCombo(formName + "cbSubgerenciaVentas", "MENRecargaSGVs", "es.indra.sicc.util.DTOString", arr, 'postRecarga("cbSubgerenciaVentas", datos);');
    }else{
        recargaRegion();
    }
}

function recargaRegion(){
    // Limpiar Combo
    set_combo(formName + 'cbRegion',aVacio);
    combo_add(formName + 'cbRegion', '', '');
    // Preparar valores
    var sgvs = quitarItemVacio(get(formName + 'cbSubgerenciaVentas'));
    var sgvsConc = new String();
    for(i=0;i<sgvs.length;i++){
        sgvsConc += sgvs[i] + "x";
    }
    // Recargar el combo si es necesario
    if(sgvsConc != ''){
        var arr = new Array();
        var peticion = '%'+sgvsConc.substring(0, sgvsConc.length-1)+'%z%%';
        arr[arr.length] = ['cadena', peticion];
        recargaCombo(formName + "cbRegion", "MENRecargaRegiones", "es.indra.sicc.util.DTOString", arr, 'postRecarga("cbRegion", datos);');
    }else{
        recargaZona();
    }
}

function recargaZona(){
    // Limpiar Combo
    set_combo(formName + 'cbZona',aVacio);
    combo_add(formName + 'cbZona', '', '');
    // Preparar valores
    var regiones = quitarItemVacio(get(formName + 'cbRegion'));
    var regionConc = new String();
    for(i=0;i<regiones.length;i++){
        regionConc += regiones[i] + "x";
    }
    // Recargar el combo si es necesario
    if(regionConc != ''){
        var arr = new Array();
        var peticion = '%'+regionConc.substring(0, regionConc.length-1)+'%z%%';
        arr[arr.length] = ['cadena', peticion];
        recargaCombo(formName + "cbZona", "MENRecargaZonas", "es.indra.sicc.util.DTOString", arr, 'postRecarga("cbZona", datos);');
    }else{
        recargaSeccion();
    }
}

function recargaSeccion(){
    // Limpiar Combo
    set_combo(formName + 'cbSeccion', aVacio);
    combo_add(formName + 'cbSeccion', '', '');
    // Preparar valores
    var zonas = quitarItemVacio(get(formName + 'cbZona'));
    var zonaConc = new String();
    for(i=0;i<zonas.length;i++){
        zonaConc += zonas[i] + "x";
    }
    // Recargar el combo si es necesario 
    if(zonaConc != ''){
        var arr = new Array();
        var peticion = '%'+zonaConc.substring(0, zonaConc.length-1)+'%z%%';
        arr[arr.length] = ['cadena', peticion];
        recargaCombo(formName + "cbSeccion", "MENRecargaSecciones", "es.indra.sicc.util.DTOString", arr, 'postRecarga("cbSeccion", datos);');
    }else{
        recargaTerritorio();
    }
}

function recargaTerritorio(){
    // Limpiar combo
    set_combo(formName + 'cbTerritorio',aVacio);
    combo_add(formName + 'cbTerritorio', '', '');
    // Preparar valores
    var secciones = quitarItemVacio(get(formName + 'cbSeccion'));
    var seccionConc = new String();
    for(i=0;i<secciones.length;i++){
        seccionConc += secciones[i] + "x";
    }
    // Recargar el combo si es necesario
    if(seccionConc != ''){
        var arr = new Array();
        var peticion = '%'+seccionConc.substring(0, seccionConc.length-1)+'%z%%';
        arr[arr.length] = ['cadena', peticion];
        recargaCombo(formName + "cbTerritorio", "MENRecargaTerritorio", "es.indra.sicc.util.DTOString", arr, 'postRecarga("cbTerritorio", datos);');
    }
}

function recargaPantallaInicio(){
    opciones = new Array();
    set_combo(formName + 'cbPantallaInicioAsociada',opciones);
    combo_add(formName + 'cbPantallaInicioAsociada', '', '');
    var items = quitarItemVacio(get(formName + 'cbPerfil'));
    var idioma = get(formName + 'hIdioma');
    var strConc = new String();
    for(i=0;i<items.length;i++){
        strConc += items[i].toUpperCase() + "x";
    }
    strConc = strConc.substring(0, strConc.length-1);
    var arr = new Array();
    arr[arr.length] = ['cadena', strConc];
    arr[arr.length] = ['oidIdioma', idioma]
    if(strConc != ''){
        recargaCombo(formName + 'cbPantallaInicioAsociada', "MENRecargaFuncionesMenu", "es.indra.sicc.util.DTOString",arr,'asignaComboPantalla(datos)');
    }     
}

////////////////////////////////////////////////


function recargaAccesoDF(){
    // Limpiar Combo
    set_combo(formName + 'cbAccesoPorDefecto',aVacio);
    combo_add(formName + 'cbAccesoPorDefecto', '', '');
    // Preparar valores
    var canalDF  = quitarItemVacio(get(formName + 'cbCanalPorDefecto'));
    var accesos  = quitarItemVacio(get(formName + 'cbAcceso'));
    var canaDFConc = new String();
    var acceConc = new String();
    for(i=0;i<canalDF.length;i++){
        canaDFConc += canalDF[i] + "x";
    }
    for(i=0;i<accesos.length;i++){
        acceConc += accesos[i] + "x";
    }
    // Recargar el combo si es necesario
    if(canaDFConc != '' && acceConc != ''){
        var arr = new Array();
        var peticion = '%'+canaDFConc.substring(0, canaDFConc.length-1)+'%z%'+acceConc.substring(0, acceConc.length-1)+'%';
        arr[arr.length] = ['cadena', peticion];
        arr[arr.length] = ['oidIdioma', get(formName + 'hIdioma')];
        recargaCombo(formName + "cbAccesoPorDefecto", "MENRecargaAccesos", "es.indra.sicc.util.DTOString", arr, 'postRecarga("cbAccesoPorDefecto",datos);');
    }else{
        recargaSubAccesoDF();
    }
}

function recargaSubAccesoDF(){
    // Limpiar Combo
    set_combo(formName + 'cbSubaccesoPorDefecto',aVacio);
    combo_add(formName + 'cbSubaccesoPorDefecto', '', '');
    // Preparar valores
    var accesoDF  = quitarItemVacio(get(formName + 'cbAccesoPorDefecto'));
    var subaccesos  = quitarItemVacio(get(formName + 'cbSubacceso'));
    var acceDFConc = new String();
    var sbacConc = new String();
    for(i=0;i<accesoDF.length;i++){
        acceDFConc += accesoDF[i] + "x";
    }
    for(i=0;i<subaccesos.length;i++){
        sbacConc += subaccesos[i] + "x";
    }
    // Recargar el combo si es necesario
    if(acceDFConc != '' && sbacConc != ''){
        var arr = new Array();
        var peticion = '%'+acceDFConc.substring(0, acceDFConc.length-1)+'%z%'+sbacConc.substring(0, sbacConc.length-1)+'%';
        arr[arr.length] = ['cadena', peticion];
        arr[arr.length] = ['oidIdioma', get(formName + 'hIdioma')];
        recargaCombo(formName + "cbSubaccesoPorDefecto", "MENRecargaSubAccesos", "es.indra.sicc.util.DTOString", arr, 'postRecarga("cbSubaccesoPorDefecto", datos);');
    }
}

function recargaSociedadDF(){
    // Limpiar Combo
    set_combo(formName + 'cbSociedadPorDefecto',aVacio);
    combo_add(formName + 'cbSociedadPorDefecto', '', '');
    // Preparar valores
    var paisDF   = quitarItemVacio(get(formName + 'cbPaisPorDefecto'));
    var sociedades = quitarItemVacio(get(formName + 'cbSociedad'));
    var paisDFConc = new String();
    var sociConc = new String();
    for(i=0;i<paisDF.length;i++){
        paisDFConc += paisDF[i] + "x";
    }
    for(i=0;i<sociedades.length;i++){
        sociConc += sociedades[i] + "x";
    }
    // Siempre se recargan las sociedades
    if(paisDFConc != '' && sociConc != ''){
        var peticion = '%'+paisDFConc.substring(0, paisDFConc.length-1)+'%z%'+sociConc.substring(0, sociConc.length-1)+'%';
        var arr = new Array();
        arr[arr.length] = ['oidIdioma', get(formName + 'hIdioma')];
        arr[arr.length] = ['cadena', peticion];
        recargaCombo(formName + "cbSociedadPorDefecto", "MENRecargaSociedades", "es.indra.sicc.util.DTOString", arr, 'postRecarga("cbSociedadPorDefecto", datos);');
    }
}

function recargaSGVDF(){
    // Limpiar Combo
    set_combo(formName + 'cbSGVPorDefecto',aVacio);
    combo_add(formName + 'cbSGVPorDefecto', '', '');
    // Preparar valores
    var marcaDF   = quitarItemVacio(get(formName + 'cbMarcaPorDefecto'));
    var canalDF  = quitarItemVacio(get(formName + 'cbCanalPorDefecto'));
    var paisDF   = quitarItemVacio(get(formName + 'cbPaisPorDefecto'));
    var sgvs   = quitarItemVacio(get(formName + 'cbSubgerenciaVentas'));

    var marcDFConc = new String();
    for(i=0;i<marcaDF.length;i++){
        marcDFConc += marcaDF[i] + "x";
    }

    var canaDFConc = new String();
    for(i=0;i<canalDF.length;i++){
        canaDFConc += canalDF[i] + "x";
    }

    var paisDFConc = new String();
    for(i=0;i<paisDF.length;i++){
        paisDFConc += paisDF[i] + "x";
    }
    
    var sgvConc = new String();
    for(i=0;i<sgvs.length;i++){
        sgvConc += sgvs[i] + "x";
    }
    
    // Recargar el combo si es necesario
    if(marcDFConc != '' && canaDFConc != '' && paisDFConc != '' && sgvConc != ''){
        marcDFConc = marcDFConc.substring(0, marcDFConc.length-1);
        canaDFConc = canaDFConc.substring(0, canaDFConc.length-1);
        paisDFConc = paisDFConc.substring(0, paisDFConc.length-1);
        sgvConc = sgvConc.substring(0, sgvConc.length-1);
        var arr = new Array();
        var peticion = '%'+marcDFConc+'%z%'+canaDFConc+'%z%'+paisDFConc+'%z%'+sgvConc+'%';
        arr[arr.length] = ['cadena', peticion];
        recargaCombo(formName + "cbSGVPorDefecto", "MENRecargaSGVs", "es.indra.sicc.util.DTOString", arr, 'postRecarga("cbSGVPorDefecto", datos);');
    }else{
        recargaRegionDF();
    }
}

function recargaRegionDF(){
    // Limpiar Combo
    set_combo(formName + 'cbRegionPorDefecto',aVacio);
    combo_add(formName + 'cbRegionPorDefecto', '', '');
    // Preparar valores
    var sgvsDF = quitarItemVacio(get(formName + 'cbSGVPorDefecto'));
    var regiones = quitarItemVacio(get(formName + 'cbRegion'));
    var sgvsDFConc = new String();
    var regiConc = new String();
    for(i=0;i<sgvsDF.length;i++){
        sgvsDFConc += sgvsDF[i] + "x";
    }
    for(i=0;i<regiones.length;i++){
        regiConc += regiones[i] + "x";
    }
    // Recargar el combo si es necesario
    if(sgvsDFConc != '' && regiConc != ''){
        var arr = new Array();
        var peticion = '%'+sgvsDFConc.substring(0, sgvsDFConc.length-1)+'%z%'+regiConc.substring(0, regiConc.length-1)+'%';
        arr[arr.length] = ['cadena', peticion];
        recargaCombo(formName + "cbRegionPorDefecto", "MENRecargaRegiones", "es.indra.sicc.util.DTOString", arr, 'postRecarga("cbRegionPorDefecto", datos);');
    }else{
        recargaZonaDF();
    }
}

function recargaZonaDF(){
    // Limpiar Combo
    set_combo(formName + 'cbZonaPorDefecto',aVacio);
    combo_add(formName + 'cbZonaPorDefecto', '', '');
    // Preparar valores
    var regionDF = quitarItemVacio(get(formName + 'cbRegionPorDefecto'));
    var zonas = quitarItemVacio(get(formName + 'cbZona'));
    var regionDFConc = new String();
    var zonaConc = new String();
    for(i=0;i<regionDF.length;i++){
        regionDFConc += regionDF[i] + "x";
    }
    for(i=0;i<zonas.length;i++){
        zonaConc += zonas[i] + "x";
    }
    // Recargar el combo si es necesario
    if(regionDFConc != '' && zonaConc != ''){
        var arr = new Array();
        var peticion = '%'+regionDFConc.substring(0, regionDFConc.length-1)+'%z%'+zonaConc.substring(0, zonaConc.length-1)+'%';
        arr[arr.length] = ['cadena', peticion];
        recargaCombo(formName + "cbZonaPorDefecto", "MENRecargaZonas", "es.indra.sicc.util.DTOString", arr, 'postRecarga("cbZonaPorDefecto", datos);');
    }else{
        recargaSeccionDF();
    }
}

function recargaSeccionDF(){
    // Limpiar Combo
    set_combo(formName + 'cbSeccionPorDefecto', aVacio);
    combo_add(formName + 'cbSeccionPorDefecto', '', '');
    // Preparar valores
    var zonaDF = quitarItemVacio(get(formName + 'cbZonaPorDefecto'));
    var secciones = quitarItemVacio(get(formName + 'cbSeccion'));
    var zonaDFConc = new String();
    var seccionConc = new String();
    for(i=0;i<zonaDF.length;i++){
        zonaDFConc += zonaDF[i] + "x";
    }
    for(i=0;i<secciones.length;i++){
        seccionConc += secciones[i] + "x";
    }
    // Recargar el combo si es necesario 
    if(zonaDFConc != '' && seccionConc != ''){
        var arr = new Array();
        var peticion = '%'+zonaDFConc.substring(0, zonaDFConc.length-1)+'%z%'+seccionConc.substring(0, seccionConc.length-1)+'%';
        arr[arr.length] = ['cadena', peticion];
        recargaCombo(formName + "cbSeccionPorDefecto", "MENRecargaSecciones", "es.indra.sicc.util.DTOString", arr, 'postRecarga("cbSeccionPorDefecto", datos);');
    }else{
        recargaTerritorioDF();
    }
}

function recargaTerritorioDF(){
    // Limpiar combo
    set_combo(formName + 'cbTerritorioPorDefecto',aVacio);
    combo_add(formName + 'cbTerritorioPorDefecto', '', '');
    // Preparar valores
    var seccionDF = quitarItemVacio(get(formName + 'cbSeccionPorDefecto'));
    var territorios = quitarItemVacio(get(formName + 'cbTerritorio'));
    var seccionDFConc = new String();
    var terriConc = new String();
    for(i=0;i<seccionDF.length;i++){
        seccionDFConc += seccionDF[i] + "x";
    }
    for(i=0;i<territorios.length;i++){
        terriConc += territorios[i] + "x";
    }
    // Recargar el combo si es necesario
    if(seccionDFConc != '' && terriConc != ''){
        var arr = new Array();
        var peticion = '%'+seccionDFConc.substring(0, seccionDFConc.length-1)+'%z%'+terriConc.substring(0, terriConc.length-1)+'%';
        arr[arr.length] = ['cadena', peticion];
        recargaCombo(formName + "cbTerritorioPorDefecto", "MENRecargaTerritorio", "es.indra.sicc.util.DTOString", arr, 'postRecarga("cbTerritorioPorDefecto", datos);');
    }
}


////////////////////////////////////////////////



function quitarItemVacio(elemento){
    var elementoADevolver = new Array();
    for(var k=0;k<elemento.length;k++) {
        if (elemento[k] != ''){ 			 
            elementoADevolver[elementoADevolver.length] = elemento[k];
        }
    }
    return elementoADevolver;
}

            
function postRecarga(combo, datos){
    set_combo(formName + combo, armarArray(datos));
    if(combo == 'cbSociedad'){
        set(formName+'cbSociedad',sociedadSeleccion); 
        recargaSociedadDF();
    }
    if(combo == 'cbAcceso'){
        set(formName+'cbAcceso',accesoSeleccion);
        recargaAccesoDF();
        recargaSubAcceso();
    }
    if(combo == 'cbSubacceso'){
        set(formName+'cbSubacceso',subAccesoSeleccion);
        recargaSubAccesoDF();
    }
    if(combo == 'cbSubgerenciaVentas'){
        set(formName+'cbSubgerenciaVentas',subGerenciaVentasSeleccion); 
        recargaSGVDF();
        recargaRegion();
    }
    if(combo == 'cbRegion'){
        set(formName+'cbRegion',regionSeleccion);
        recargaRegionDF();
        recargaZona();
    }
    if(combo == 'cbZona'){
        set(formName+'cbZona',zonaSeleccion);
        recargaZonaDF();
        recargaSeccion();
    }
    if(combo == 'cbSeccion'){
        set(formName+'cbSeccion',seccionSeleccion);
        recargaSeccionDF();
        recargaTerritorio();
    }
    if(combo == 'cbTerritorio'){
        set(formName+'cbTerritorio',territorioSeleccion);
        recargaTerritorioDF();
    }
    if(combo == 'cbUsuarioSustitucion'){
        if(!bInsertar) { //es modificación
            set(formName + 'cbUsuarioSustitucion', get(formName + 'hUsuarioSustitucion').split('|'));
            verificarCamposSust();
        }
    }


    if(combo == 'cbSociedadPorDefecto'){
        set(formName+combo,sociedadDefectoSeleccion); 
    }
    if(combo == 'cbAccesoPorDefecto'){
        set(formName+combo,accesoDefectoSeleccion);
        recargaSubAccesoDF();
    }
    if(combo == 'cbSubaccesoPorDefecto'){
        set(formName+combo,subAccesoDefectoSeleccion);
    }
    if(combo == 'cbSGVPorDefecto'){
        set(formName+combo,SGVDefectoSeleccion);
        recargaRegionDF();
    }
    if(combo == 'cbRegionPorDefecto'){
        set(formName+combo,regionDefectoSeleccion);
        recargaZonaDF();
    }
    if(combo == 'cbZonaPorDefecto'){
        set(formName+combo,zonaDefectoSeleccion);
        recargaSeccionDF();
    }
    if(combo == 'cbSeccionPorDefecto'){
        set(formName+combo,seccionDefectoSeleccion);
        recargaTerritorioDF();
    }
    if(combo == 'cbTerritorioPorDefecto'){
        set(formName+combo,territorioDefectoSeleccion);
    }
    
}

//Carga los combos PorDefecto de cada elemento que se le pasa por parámetro.
function cargarAsociado(cmbOrigen, cmbDestino){
    var listaCodigos = get(formName + cmbOrigen);
    var listaDescripciones = get(formName + cmbOrigen,'T');
    var opciones = new Array();
    for (var z=0; z<listaCodigos.length; z++){
        opciones[z] = [ listaCodigos[z] , listaDescripciones[z] ];
    }
    set_combo(formName + cmbDestino, opciones);
    ordenaCombo_SICC(eval(cmbDestino));
    set(formName + cmbDestino, aVacio );
}


function recargarValoresCombos(){
    
    sociedadSeleccion = get(formName + 'hSociedad').split('|');
    paisSeleccion = get(formName + 'hPais').split('|');
    marcaSeleccion = get(formName + 'hMarca').split('|');
    canalSeleccion = get(formName + 'hCanal').split('|');
    accesoSeleccion = get(formName + 'hAcceso').split('|');
    subAccesoSeleccion = get(formName + 'hSubnivelAcceso').split('|');
    subGerenciaVentasSeleccion = get(formName + 'hSubgerenciaVentas').split('|');
    regionSeleccion = get(formName + 'hRegion').split('|');
    zonaSeleccion = get(formName + 'hZona').split('|');
    seccionSeleccion = get(formName + 'hSeccion').split('|');
    territorioSeleccion = get(formName + 'hTerritorio').split('|');
    
    pantallaInicioAsociadaSeleccion = get(formName + 'hFuncionDirecta').split('|');
    
    sociedadDefectoSeleccion = get(formName + 'hSociedadPorDefecto').split('|');
    paisDefectoSeleccion = get(formName + 'hPaisPorDefecto').split('|');
    SGVDefectoSeleccion = get(formName + 'hSGVPorDefecto').split('|');
    zonaDefectoSeleccion = get(formName + 'hZonaPorDefecto').split('|');
    regionDefectoSeleccion = get(formName + 'hRegionPorDefecto').split('|');
    seccionDefectoSeleccion = get(formName + 'hSeccionPorDefecto').split('|');
    territorioDefectoSeleccion = get(formName + 'hTerritorioPorDefecto').split('|');
    marcaDefectoSeleccion = get(formName + 'hMarcaPorDefecto').split('|');
    canalDefectoSeleccion = get(formName + 'hCanalPorDefecto').split('|');
    accesoDefectoSeleccion = get(formName + 'hAccesoPorDefecto').split('|');
    subAccesoDefectoSeleccion = get(formName + 'hSubaccesoPorDefecto').split('|');
    idiomaSeleccion = get(formName + 'hIdioma').split('|');
    tipoUsuarioSeleccion = get(formName + 'hTipoUsuario').split('|');
    tipoRastreoSeleccion = get(formName + 'hTipoRastreo').split('|');
    
    set(formName + 'cbMarca', marcaSeleccion);
    set(formName + 'cbCanal', canalSeleccion);
    set(formName + 'cbPais', paisSeleccion);
    set(formName + 'cbPerfil', get(formName + 'hPerfil').split('|'));
    set(formName + 'cbTipoUsuario', tipoUsuarioSeleccion);
    set(formName + 'cbIdioma', idiomaSeleccion);
    set(formName + 'cbTipoRastreo', tipoRastreoSeleccion);
    set(formName + 'cbDepartamento', get(formName + 'hDepartamento').split('|'));
    // Combo de usuario de sustitucion se establece en el post de su respectivo recarga combo
    // Combo de pantalla de Inicio Asociada se establece en el post de su respectivo recarga combo

    cargarAsociado('cbMarca', 'cbMarcaPorDefecto');
    cargarAsociado('cbCanal', 'cbCanalPorDefecto');
    cargarAsociado('cbPais', 'cbPaisPorDefecto');
    
    set(formName + 'cbMarcaPorDefecto', marcaDefectoSeleccion);
    set(formName + 'cbCanalPorDefecto', canalDefectoSeleccion);
    set(formName + 'cbPaisPorDefecto', paisDefectoSeleccion);
    
    recargaAcceso();
    recargaSociedad();
    recargaSGV();
    //recargaAccesoDF();
    //recargaSociedadDF();
    //recargaSGVDF();
    recargaPantallaInicio();
    
    // Debe verificarse los campos de rastro segun el valor en el combo establecido antes
    verificarCamposRastreo();

    checked= get(formName + 'hIndNDG')==""?"N":get(formName + 'hIndNDG');
    set(formName + 'ckIndNDG',checked);
    if (checked == "S") {
        if(get(formName + 'casoUso')!='consultar'){
            accion( formName + 'ckAdminNDG','.disabled=false');
        }
    }

    try {
        checked= get(formName + 'hIndAdmNDG')==""?"N":get(formName + 'hIndAdmNDG');
        set(formName + 'ckAdminNDG',checked);
    } catch (x)	{}

    checked= get(formName + 'hIndicacionClaveInicial')==""?"S":get(formName + 'hIndicacionClaveInicial');
    set(formName + 'rbClaveInicial',checked);

    checked= get(formName + 'hUsuarioHabilitado')==""?"S":get(formName + 'hUsuarioHabilitado');
    set(formName + 'rbUsuarioHabilitado',checked);
}

function reintentar(){
    if (bInsertar){
        set(formName + 'conectorAction','LPInsertarUsuarios');
        enviaSICC(formNameSinPunto,null,null,'N');
    } else {
        set(formName + 'conectorAction','LPModificarUsuarios');
        envia(formNameSinPunto,null,null,'N');
    }
}

                  function validaDatos() {

							if (!sicc_validaciones_generales()) {
								return false;
							}

                           var resultado = true;

                           var idUsuario = get(formName + "txtUsuario").toUpperCase();
							//alert(idUsuario);
							if (idUsuario.length == 0){ 
								GestionarMensaje("54", null, null, null);
								focaliza(formName + "txtUsuario", '');
								return false;
							}

                           if ( !validarAlfanumericoConEspeciales(idUsuario ) )
                           {
                                    //alert("Hay caracteres invalidos");
                                    GestionarMensaje("995", null, null, null);
                                    focaliza(formName + "txtUsuario", '');
                                    return false;
                           }

                           if ( resultado &&  ( get(formName + 'txtClaveAcceso')!=get(formName + 'txtConfirmarClaveAcceso') )  )
                                    {
                              GestionarMensaje('195',null,null,null);
                              focaliza(formName + 'txtConfirmarClaveAcceso','');
                              resultado = false;
                           }

							if (resultado &&  (get(formName + 'txtClaveAcceso').toUpperCase() == idUsuario)) {
								resultado = false;
								//cdos_mostrarAlert( GestionarMensaje(sMensaje,null,null,null) );
								cdos_mostrarAlert(GestionarMensaje('134',null,null,null));
	                            focaliza(formName + 'txtClaveAcceso','');
								//asignarAtributo("VAR", "mensaje", "valor", "134"); //clave = identificador
							}

                           //alert("Validacion");	
                           if ( resultado )
                           {
                                    var nErrorCode = EsFechaValida( get(formName + 'txtValidezDesde'), get(formName + 'txtValidezHasta'), formNameSinPunto );
                                    //alert("Validacion, errorLevel: " + nErrorCode);
                                    resultado = manejoErroresFechaValida(nErrorCode, 'txtValidezDesde', 'txtValidezHasta', formNameSinPunto);
                           }


                           if ( resultado )
                           {
                                    var seleccionRastreo = get(formName + 'cbTipoRastreo');  
                                    if ( seleccionRastreo[0]!='NO'  &&  seleccionRastreo[0]!=null  &&  seleccionRastreo[0]!='')
                                    {
                                                      // Solo si el combo de rastreo indica que se debe hacer rastreo. 
                                                      var nErrorCode = EsFechaValida( get(formName + 'txtFechaInicioRastreo'), get(formName + 'txtFechaFinRastreo'), formNameSinPunto );
                                                      //alert("Validacion, errorLevel: " + nErrorCode);
                                                      resultado = manejoErroresFechaValida(nErrorCode, 'txtFechaInicioRastreo', 'txtFechaFinRastreo', formNameSinPunto);
                                    }

                           }
                           if (resultado)
                           {
                           var seleccionSustitucion = get(formName + 'cbUsuarioSustitucion');
                                if ( seleccionSustitucion[0]!= null && seleccionSustitucion[0]!='') 
                                    {
                                             // Solamente chequea fecha de sustitucion si hay un usuario en el combo.
                                             var nErrorCode = EsFechaValida( get(formName + 'txtFechaSustitucionDesde'), get(formName + 'txtFechaSustitucionHasta'), formNameSinPunto );
                                             //alert("Validacion, errorLevel: " + nErrorCode);
                                             resultado = manejoErroresFechaValida(nErrorCode, 'txtFechaSustitucionDesde', 'txtFechaSustitucionHasta', formNameSinPunto);
                                    }

                           }

                           return resultado;		
                  }

                  function fGuardar(){
                           if ( validaDatos() )
                           {
									enviaSICC(formNameSinPunto);
                           }
						   //else{alert('Fecha invalida');}
                           
                  }

      function fVolver(){
		  window.close();
      }


	  function obtenerTerritorios(colID, colDESC, colPADRESecci, colPADREPais){
		var i = 0;
		var opciones = new Array();
		var opcionesSecci = new Array();
		var selecSeccion = get(formName + "cbSeccion");
		var selecPais = get(formName + "cbPais");

		opciones[i] = ['',''];

		for (var j=0; j< eval('vTerritorio').length; j++ ){
				 for (var k=1; k <= selecSeccion.length; k++) {
					  if (selecSeccion[k-1] == eval('vTerritorio')[j][colPADRESecci]) {
								opcionesSecci[i] = [ eval('vTerritorio')[j][colID], eval('vTerritorio')[j][colDESC], 
										eval('vTerritorio')[j][colPADREPais]];
								i++;
					  }
				 }
		}
		i = 1;
		for (var j=0; j< opcionesSecci.length; j++ ){
			for (var k=1; k <= selecPais.length; k++) {
				if (selecPais[k-1] == opcionesSecci[j][2]) {
					opciones[i] = [ opcionesSecci[j][0], opcionesSecci[j][1]];
					i++;
				}
			}
		}
		return opciones;		
	  }

	function habilitaRastreoySustitucion() {
        if(bInsertar) { //NO es modificación
            verificarCamposRastreo();
            verificarCamposSust();
        }
	}

	function habilita() {
		var valor = get( formName + 'ckIndNDG');
		if (valor == "S") {
			accion( formName + 'ckAdminNDG','.disabled=false');
		} else {
			accion( formName + 'ckAdminNDG','.disabled=true');
			set( formName + 'ckAdminNDG','N');
		}
	}

function guardoSeleccionados(){
    sociedadSeleccion = get(formName + 'cbSociedad');
    paisSeleccion = get (formName + 'cbPais');
    marcaSeleccion = get (formName + 'cbMarca');
    canalSeleccion = get (formName + 'cbCanal');	
    accesoSeleccion = get (formName + 'cbAcceso');
    subAccesoSeleccion = get (formName + 'cbSubacceso');
    subGerenciaVentasSeleccion = get (formName + 'cbSubgerenciaVentas');
    regionSeleccion = get (formName + 'cbRegion');
    zonaSeleccion = get (formName + 'cbZona');
    seccionSeleccion = get (formName + 'cbSeccion');	
    territorioSeleccion = get (formName + 'cbTerritorio');	
    paisDefectoSeleccion = get (formName + 'cbPaisPorDefecto');	
    regionDefectoSeleccion = get (formName + 'cbRegionPorDefecto');	
    SGVDefectoSeleccion = get (formName + 'cbSGVPorDefecto');	
    zonaDefectoSeleccion = get (formName + 'cbZonaPorDefecto');	 
    seccionDefectoSeleccion = get (formName + 'cbSeccionPorDefecto');	 
    territorioDefectoSeleccion = get (formName + 'cbTerritorioPorDefecto');	 
    sociedadDefectoSeleccion = get (formName + 'cbSociedadPorDefecto');	 
    marcaDefectoSeleccion = get (formName + 'cbMarcaPorDefecto');	 
    canalDefectoSeleccion = get (formName + 'cbCanalPorDefecto');
    accesoDefectoSeleccion = get (formName + 'cbAccesoPorDefecto');	 
    subAccesoDefectoSeleccion = get (formName + 'cbSubaccesoPorDefecto');	 
    tipoUsuarioSeleccion = get (formName + 'cbTipoUsuario');	 
    idiomaSeleccion = get (formName + 'cbIdioma');	 
    tipoRastreoSeleccion = get (formName + 'cbTipoRastreo');	 
    pantallaInicioAsociadaSeleccion = get (formName + 'cbPantallaInicioAsociada');
}

function quitarItemVacio(elemento){
    var elementoADevolver = new Array();
    for(var k=0;k<elemento.length;k++) {
        if (elemento[k] != ''){                            
            elementoADevolver[elementoADevolver.length] = elemento[k];
        }
    }
    return elementoADevolver;
}

function asignaComboPantalla(datos){
    var sel = new Array();
    sel[0] = '';//get( 'frmContenido.hZona' );
    set_combo(formName + 'cbPantallaInicioAsociada', armarArray(datos), sel);
    if(!bInsertar) { //es modificación
        set(formName + 'cbPantallaInicioAsociada', pantallaInicioAsociadaSeleccion);
    }
}

function armarArray(datos){
    var valores = new Array();
    valores[0] = ['', ''];
    for(i=0; i < datos.length; i++ ){
        valores[i+1] = datos[i];
    }
    return valores;
}

function allReadonly(){
    setEstado("rbClaveInicial", 0, 0);
    setEstado("rbClaveInicial", 1, 0);
    setEstado("txtClaveAcceso", 0, 0);
    setEstado("txtConfirmarClaveAcceso", 0, 0);
    setEstado("cbPerfil", 0, 0);
    setEstado("rbUsuarioHabilitado", 0, 0);
    setEstado("rbUsuarioHabilitado", 1, 0);
    setEstado("txtPrimerApellido", 0, 0);
    setEstado("txtSegundoApellido", 0, 0);
    setEstado("txtApellidoCasada", 0, 0);
    setEstado("txtPrimerNombre", 0, 0);
    setEstado("txtSegundoNombre", 0, 0);
    setEstado("txtEmail", 0, 0);
    setEstado("txtTelefono", 0, 0);
    setEstado("cbDepartamento", 0, 0);
    setEstado("txtIdentificadorPC", 0, 0);
    setEstado("txtValidezDesde", 0, 0);
    setEstado("txtValidezHasta", 0, 0);
    setEstado("cbSociedad", 0, 0);
    setEstado("cbMarca", 0, 0);
    setEstado("cbCanal", 0, 0);
    setEstado("cbAcceso", 0, 0);
    setEstado("cbSubacceso", 0, 0);
    setEstado("cbPais", 0, 0);
    setEstado("cbSubgerenciaVentas", 0, 0);
    setEstado("cbRegion", 0, 0);
    setEstado("cbZona", 0, 0);
    setEstado("cbSeccion", 0, 0);
    setEstado("cbTerritorio", 0, 0);
    setEstado("cbPaisPorDefecto", 0, 0);
    setEstado("cbSGVPorDefecto", 0, 0);
    setEstado("cbRegionPorDefecto", 0, 0);
    setEstado("cbZonaPorDefecto", 0, 0);
    setEstado("cbSeccionPorDefecto", 0, 0);
    setEstado("cbTerritorioPorDefecto", 0, 0);
    setEstado("cbSociedadPorDefecto", 0, 0);
    setEstado("cbMarcaPorDefecto", 0, 0);
    setEstado("cbCanalPorDefecto", 0, 0);
    setEstado("cbAccesoPorDefecto", 0, 0);
    setEstado("cbSubaccesoPorDefecto", 0, 0);
    setEstado("cbTipoUsuario", 0, 0);
    setEstado("cbIdioma", 0, 0);
    setEstado("cbTipoRastreo", 0, 0);
    setEstado("txtFechaInicioRastreo", 0, 0);
    setEstado("txtFechaFinRastreo", 0, 0);
    setEstado("cbPantallaInicioAsociada", 0, 0);
    setEstado("cbUsuarioSustitucion", 0, 0);
    setEstado("txtFechaSustitucionDesde", 0, 0);
    setEstado("txtFechaSustitucionHasta", 0, 0);
    setEstado("areatxtObservaciones", 0, 0);
    setEstado("ckIndNDG", 0, 0);
    setEstado("ckAdminNDG", 0, 0);
}

function setEstado(componente, indice, estado){
    if(indice==null){
        if(estado == 1){
            document.all(componente).disabled=false;
        }else if(estado == 0){
            document.all(componente).disabled=true;
        }
    }else{
        if(estado == 1){
            document.all(componente)[indice].disabled=false;
        }else if(estado == 0){
            document.all(componente)[indice].disabled=true;
        }
    }
}