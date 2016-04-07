var oidNuevaVersion;

function onClickReporteAbastecimiento () {
	/* Pendiente definicion funcional Incidencia BELC400000012 	*/
}

function onClickReporteBalanceo () {
	/* Pendiente definicion funcional Incidencia BELC400000012	*/
}

function ocultaLista1() {
	document.all["Cplistado1"].style.visibility='hidden';
    document.all["CpLin1listado1"].style.visibility='hidden';
    document.all["CpLin2listado1"].style.visibility='hidden';
    document.all["CpLin3listado1"].style.visibility='hidden';
    document.all["CpLin4listado1"].style.visibility='hidden';
    document.all["btnEjecutarBalanceoDiv"].style.visibility='hidden';
    document.all["btnReporteAbastecimientoDiv"].style.visibility='hidden';
    document.all["btnReporteBalanceoDiv"].style.visibility='hidden';
}

function muestraLista1() {
	DrdEnsanchaConMargenDcho('listado1',12);   
	document.all["Cplistado1"].style.visibility='';
    document.all["CpLin1listado1"].style.visibility='';
    document.all["CpLin2listado1"].style.visibility='';
    document.all["CpLin3listado1"].style.visibility='';
    document.all["CpLin4listado1"].style.visibility='';
    document.all["btnEjecutarBalanceoDiv"].style.visibility='';
    document.all["btnReporteAbastecimientoDiv"].style.visibility='';
    document.all["btnReporteBalanceoDiv"].style.visibility='';
    eval (ON_RSZ);  
}

function onLoadPag() {  
	fMostrarMensajeError();
	configurarMenuSecundario("formulario");
	ocultaLista1();

	if(get('formulario.hOidCentroDistribucionDefecto')!="" &&
		get('formulario.opcionMenu')=="ejecutar") {
		var hidOidDefecto = get("formulario.hOidCentroDistribucionDefecto");  
        var oidSeleccionado = new Array();
        oidSeleccionado = hidOidDefecto.split(",");	    
        set("formulario.comboCentro", oidSeleccionado);	
        
    accion('formulario.comboPeriodo', '.disabled=true');
    accion('formulario.comboVersion', '.disabled=true');
    accion('formulario.comboOrdenAnaqueles', '.disabled=true');
    
		onChangeCbCentroDistribucion();
	}
  
  focaliza("formulario.comboCentro");  
}

function onChangeCbCentroDistribucion() {
	if(get('formulario.comboCentro')!="") {
    accion('formulario.comboLinea', '.disabled=false');
    
    accion('formulario.comboMapaCentro', '.disabled=true');
		set_combo('formulario.comboMapaCentro', new Array(['','']));
    
		recargaCombo('formulario.comboLinea', 'APEObtenerLineasArmadoCD', 'es.indra.sicc.util.DTOOID', armarArrayComboCentroDistribucion(),'rellenarComboLinea(datos)');
	}
	else {
    accion('formulario.comboLinea', '.disabled=true');
		set_combo('formulario.comboLinea', new Array(['','']));
    accion('formulario.comboMapaCentro', '.disabled=true');
		set_combo('formulario.comboMapaCentro', new Array(['','']));
	}
}

function armarArrayComboCentroDistribucion() {
	var idioma = get('formulario.idioma');
	var pais = get('formulario.pais');
	var oid = get('formulario.comboCentro');
  
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

function rellenarComboLinea(datos) {
	var arrayNuevo = new Array();
	arrayNuevo[0] = new Array('','');
	arrayNuevo = arrayNuevo.concat(datos);
	set_combo('formulario.comboLinea',arrayNuevo);

	var longitudCombo1 = combo_get('formulario.comboLinea', 'L');
	var oidsLineasDef1 = get('formulario.hOidsLineasArmadoDefecto').split('|');
	for (var i = 1; i < longitudCombo1; i++) {
		var value = combo_get('formulario.comboLinea', 'V', i);
		for (var j = 0; j < oidsLineasDef1.length; j++) {
			if (value == oidsLineasDef1[j]) {
				set('formulario.comboLinea', new Array(value));
				j = oidsLineasDef1.length;
				i = longitudCombo1;
			}
		}
	}

	onChangeCbLineaArmado();
}

function onChangeCbLineaArmado() {
	if(get('formulario.comboLinea')!="") {
    accion('formulario.comboMapaCentro', '.disabled=false');
		recargaCombo('formulario.comboMapaCentro', 'APEObtenerMapaCDPorCDYLinea', 'es.indra.sicc.dtos.ape.DTOMantenerConfiguracionBalanceo', armarArrayComboLineaArmado(), 'rellenarComboMapaCentro(datos)');
	}
	else {
    accion('formulario.comboMapaCentro', '.disabled=true');
		set_combo('formulario.comboMapaCentro', new Array(['','']));
	}
}

function rellenarComboMapaCentro(datos) {
	var arrayNuevo = new Array();
	arrayNuevo[0] = new Array('','');
	arrayNuevo = arrayNuevo.concat(datos);
	set_combo('formulario.comboMapaCentro',arrayNuevo);
}

function armarArrayComboLineaArmado() {
	var idioma = get('formulario.idioma');
	var pais = get('formulario.pais');
	var oidCentroDistribucion = get('formulario.comboCentro');
	var oidLineaArmado = get('formulario.comboLinea');
  
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

	if( oidCentroDistribucion != null && oidCentroDistribucion != '' ){
		array[index] = new Array('oidCentroDistribucion', oidCentroDistribucion);
        index++;
    }

	if( oidLineaArmado != null && oidLineaArmado != '' ){
		array[index] = new Array('oidLineaArmado', oidLineaArmado);
        index++;
    }
  
    return array;
}



function onChangeVersion() {
	if(get('formulario.comboVersion')!="") {
    accion('formulario.comboOrdenAnaqueles', '.disabled=false');
		recargaCombo('formulario.comboOrdenAnaqueles', 'APEObtenerMapasOrdenPorMapaZonas', 'es.indra.sicc.util.DTOOID', armarArrayComboVersion());
	}
	else {
    accion('formulario.comboOrdenAnaqueles', '.disabled=true');
		set_combo('formulario.comboOrdenAnaqueles', new Array(['','']));
	}
}

function armarArrayComboVersion() {
	var idioma = get('formulario.idioma');
	var pais = get('formulario.pais');
	var oid = get('formulario.comboVersion');
  
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

function onChangeCbMarca() {
	if(get('formulario.comboCanal')!="" && get('formulario.comboMarca')!="") {
    accion('formulario.comboPeriodo', '.disabled=false');
    
    accion('formulario.comboVersion', '.disabled=true');
		set_combo('formulario.comboVersion', new Array(['','']));
    accion('formulario.comboOrdenAnaqueles', '.disabled=true');
    set_combo('formulario.comboOrdenAnaqueles', new Array(['','']));
    
		recargaCombo('formulario.comboPeriodo', 'CRAObtenerPeriodos', 'es.indra.sicc.dtos.cra.DTOPeriodo', armarArray());
	}
	else {
    accion('formulario.comboPeriodo', '.disabled=true');
		set_combo('formulario.comboPeriodo', new Array(['','']));
    
    accion('formulario.comboVersion', '.disabled=true');
		set_combo('formulario.comboVersion', new Array(['','']));
    
    accion('formulario.comboOrdenAnaqueles', '.disabled=true');
    set_combo('formulario.comboOrdenAnaqueles', new Array(['','']));
	}
}

function onChangeCbCanal() {
	if(get('formulario.comboCanal')!="" && get('formulario.comboMarca')!="") {
    accion('formulario.comboPeriodo', '.disabled=false');
    
    accion('formulario.comboVersion', '.disabled=true');
		set_combo('formulario.comboVersion', new Array(['','']));
    accion('formulario.comboOrdenAnaqueles', '.disabled=true');
    set_combo('formulario.comboOrdenAnaqueles', new Array(['','']));
    
		recargaCombo('formulario.comboPeriodo', 'CRAObtenerPeriodos', 'es.indra.sicc.dtos.cra.DTOPeriodo', armarArray());
	}
	else {
		accion('formulario.comboPeriodo', '.disabled=true');
		set_combo('formulario.comboPeriodo', new Array(['','']));
    
    accion('formulario.comboVersion', '.disabled=true');
		set_combo('formulario.comboVersion', new Array(['','']));
    
    accion('formulario.comboOrdenAnaqueles', '.disabled=true');
    set_combo('formulario.comboOrdenAnaqueles', new Array(['','']));
	}
}

function armarArray() {
	var idioma = get('formulario.idioma');
	var pais = get('formulario.pais');
	var canal = get('formulario.comboCanal');
	var marca = get('formulario.comboMarca');
  
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


function onChangeMapaCentroDistribucion() {
    onChangeCbPeriodo();
}

/* vbongiov -- BELC400000598 -- 25/07/2007
function onClickNuevaVersion() {
	if(sicc_validaciones_generales('grupoNuevaVersion')) {
		var o = new Object();	
		o.casoDeUso = "EjecutarBalanceo";
		o.oidMapaCentroDistribucion = get('formulario.comboMapaCentro');
		o.oidMapaZona = get('formulario.comboMapaZonas');
		o.oidPeriodo = get('formulario.comboPeriodo');

		var whnd = mostrarModalSICC("LPMantenerBalanceo", "nuevaVersion", o, '795', '200');
		if(whnd!=null){
			//Este nuevo oid es el que se acaba de generar en la tabla APE_ASIGN_PRODU_ANAQU_CABEC
			oidNuevaVersion = whnd[0];
			//Se recarga el combo version para que traiga la nueva version que el usuario
			//acaba de insertar
			recargaCombo('formulario.comboVersion', 'APEObtenerVersionesAsignacion', 'es.indra.sicc.dtos.ape.DTOMantenerAsignacionProductosAnaqueles', armarArrayComboPeriodo(), 'setearNuevoOidVersion(datos)');
		}
		else {
			oidNuevaVersion = null;
		}
	}
}
*/

function setearNuevoOidVersion(datos) {
	var arrayNuevo = new Array();
	arrayNuevo[0] = new Array('','');
	arrayNuevo = arrayNuevo.concat(datos);
	set_combo('formulario.comboVersion',arrayNuevo);
	//Se setea el nuevo oid en el combo version
	set('formulario.comboVersion', new Array(oidNuevaVersion));
}

function onChangeCbPeriodo() {
	/* BELC400000692 - dmorello, 30/08/2007
	 * Se agrega la verificacion de comboLinea != '' */
	if(get('formulario.comboPeriodo')!="" && get('formulario.comboMapaCentro')!=""
		&& get('formulario.comboLinea') != "") {
  
    accion('formulario.comboVersion', '.disabled=false');
    
    accion('formulario.comboOrdenAnaqueles', '.disabled=true');
    set_combo('formulario.comboOrdenAnaqueles', new Array(['','']));
    
		recargaCombo('formulario.comboVersion', 'APEObtenerVersionesAsignacion', 'es.indra.sicc.dtos.ape.DTOMantenerAsignacionProductosAnaqueles', armarArrayComboPeriodo());
	}
	else {
    accion('formulario.comboVersion', '.disabled=true');
		set_combo('formulario.comboVersion', new Array(['','']));
    accion('formulario.comboOrdenAnaqueles', '.disabled=true');
    set_combo('formulario.comboOrdenAnaqueles', new Array(['','']));
	}
}

function armarArrayComboPeriodo() {
	var idioma = get('formulario.idioma');
	var pais = get('formulario.pais');
	var oidPeriodo = get('formulario.comboPeriodo');
	var oidMapaCentroDistribucion = get('formulario.comboMapaCentro');
  
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

	if( oidMapaCentroDistribucion != null && oidMapaCentroDistribucion != '' ){
		array[index] = new Array('oidMapaCentroDistribucion', oidMapaCentroDistribucion);
        index++;
    }

	if( oidPeriodo != null && oidPeriodo != '' ){
		array[index] = new Array('oidPeriodo', oidPeriodo);
        index++;
    }

	/* BELC400000692 - dmorello, 30/08/2007 */
	var oidLinea = get('formulario.comboLinea');
	if (oidLinea != null && oidLinea != '') {
		array[index++] = new Array('oidLineaArmado', oidLinea);
	}
	/* Fin BELC400000692 - dmorello, 30/08/2007 */
  
    return array;
}


function onClickAceptar () {
	if(sicc_validaciones_generales('grupoBusqueda')) {
		set("formulario.oidLineaArmado", get("formulario.comboLinea"));
		eval("formulario").oculto= "S";
		set("formulario.conectorAction", "LPMantenerBalanceo");
		set("formulario.accion", "aceptar");
		enviaSICC("formulario");
	}
}

function recuperarSublineasOK(cadena) {
	eval("formulario").oculto= "N";
	rellenarLista(cadena);
  deshabilitarCab();
}

function rellenarLista(str){	
	var arrVacio = new Array();
	listado1.actualizaDat();
	listado1.setDatos(arrVacio);
	listado1.repintaDat();

	var arr = new Array();	
    var filas = str.split('|');
	for(var i=0; i<filas.length; i++) {
		var campos = filas[i];
		var campo = campos.split(",");
		arrIn = new Array();
        arrIn[0] = campo[0];
        arrIn[1] = campo[1];   
        arrIn[2] = "";          
        arr[i] = arrIn;      		
	}
	if(arr.length>0) {
		muestraLista1();
	}

	listado1.actualizaDat();
	listado1.setDatos(arr);
	listado1.repintaDat();
}  

function deshabilitarCab() {
    accion('formulario.comboCentro', '.disabled=true');
    accion('formulario.comboLinea', '.disabled=true');
    accion('formulario.comboMapaCentro', '.disabled=true');
    accion('formulario.comboOrdenAnaqueles', '.disabled=true');
    accion('formulario.comboMarca', '.disabled=true');
    accion('formulario.comboCanal', '.disabled=true');
    accion('formulario.comboPeriodo', '.disabled=true');
    accion('formulario.comboVersion', '.disabled=true');
    deshabilitarHabilitarBoton('botonContenido','btnNuevaVersion','D')
    accion('formulario.comboOrigenDatos', '.disabled=true');
    accion('formulario.comboOrdenacionProductos', '.disabled=true');
}

function recuperarSublineasERR() {
	eval("formulario").oculto= "N";
}

function onClickEjecutarBalanceo() {
	if(sicc_validaciones_generales('grupoEjecutar')) {
		var validarPorcentaje=false;
		listado1.actualizaDat();
		listado1.repintaDat();
		var porcentaje = 0;
		var datos = listado1.datos;	
		for(var i=0;i<datos.length;i++) {		
			//Primero se valida que se ingrese un valor para la columna Porcentaje productos
			var devuelto = sicc_valida_requerido_LE('txtPorcentaje', GestionarMensaje("3361"), 
			'listado1', 2);

			if(devuelto==true) {
				//Despues se valida el tipo de dato de la columna Porcentaje productos
				var retorno = sicc_valida_numero_LE('txtPorcentaje', GestionarMensaje("3361"), 0, 100, 'Numerico', 'listado1', 2);
				if(retorno!=true) {
					return false;
				}
			}
			else {
				return false;
			}
			porcentaje = porcentaje + parseFloat(datos[i][2]);		
		}

		porcentaje = Math.round(Number(porcentaje) * 100) / 100;

		if(porcentaje==100) {
			validarPorcentaje=true;
		}

		if(validarPorcentaje==true) {  				
			var listaValores = obtenerListaValores();

			set("formulario.oidCentroDistribucion", get("formulario.comboCentro"));
			set("formulario.oidLineaArmado", get("formulario.comboLinea"));
			set("formulario.oidMapaCentroDistribucion", get("formulario.comboMapaCentro"));
			set("formulario.oidOrdenAnaqueles", get("formulario.comboOrdenAnaqueles"));
			set("formulario.oidPeriodo", get("formulario.comboPeriodo"));
			set("formulario.oidAsignacionProductosAnaqueles", get("formulario.comboVersion"));
			set("formulario.oidOrigenDatos", get("formulario.comboOrigenDatos"));
			set("formulario.oidOrdenacionProductos", get("formulario.comboOrdenacionProductos"));
			set("formulario.version", get("formulario.comboVersion", "T"));
			set("formulario.lstPorcentajeSublineas", listaValores);		

			eval("formulario").oculto= "S";
			set("formulario.conectorAction", "LPMantenerBalanceo");
			set("formulario.accion", "ejecutar");
			enviaSICC("formulario"); 
		}
		else {
			//"El porcentaje total de distribución entre sublíneas ha de ser del 100%" 
			GestionarMensaje("APE013"); 
		}
	}
}

function obtenerListaValores() {
	var datos = listado1.datos;
	var lista = "";
	for(var i=0; i<datos.length; i++) {
		if(i==0) {
			lista = lista + datos[i][0] + "|" + datos[i][2];
		}
		else {
			lista = lista + "&" + datos[i][0] + "|" + datos[i][2];
		}
	}
	return lista;
}

function ejecutarBalanceoOK(codigoError) {
	eval("formulario").oculto= "N";
	
	if(codigoError=="0013") {
		//No se pudieron asignar todos los productos al llenarse todos los anaqueles
		GestionarMensaje("APE039"); 
	}
	
	levantarModalEvaluarCarga();
}

function ejecutarBalanceoERR() {
	eval("formulario").oculto= "N";
}

function levantarModalEvaluarCarga() {
	var o = new Object();
	var whnd = mostrarModalSICC("LPMantenerBalanceo", "evaluarCarga", o);
  
  eval("formulario").oculto= "N";
  set("formulario.conectorAction", "LPMantenerBalanceo");
  set("formulario.accion", "");
  enviaSICC("formulario"); 
}

//****** funciones para el foco *********

function OnShtabComboCentro() {
  if(listado1.codigos().length!=0){
      focalizaBotonHTML_XY('btnReporteBalanceo');
  } else {
      focalizaBotonHTML('botonContenido','btnAceptar');
  }
}

function onTabAceptar() {
  if(listado1.codigos().length!=0){
      eval("listado1.preparaCamposDR()");
      focaliza('frm'+'listado1'+'.'+'txtPorcentaje'+'_0','');
  } else {
      focaliza("formulario.comboCentro");
  }
}

function onShTabAceptar() {
  if(listado1.codigos().length!=0){
     focalizaBotonHTML_XY('btnReporteBalanceo');
  } else {
      focaliza("formulario.comboOrdenacionProductos");
  }
}


function focalizaListaTab(FILAEVENTO) {
    if(FILAEVENTO == (listado1.datos.length - 1)) {
      setTimeout("focalizaBotonHTML_XY('btnEjecutarBalanceo')",10); 
    }
}

function focalizaListaShTab(FILAEVENTO) {
    if(FILAEVENTO == 0){     	
        setTimeout("focalizaBotonHTML('btnAceptar')",10); 
    }        
}

function OnTabReporteBalanceo() {
  focalizaBotonHTML('botonContenido','btnAceptar');  
}

function OnShTabBotonEjecutar() {
    var indiceFila = listado1.datos.length - 1;
    eval("listado1.preparaCamposDR()");
    focaliza('frm'+'listado1'+'.'+'txtPorcentaje'+'_'+indiceFila,'');       
}
