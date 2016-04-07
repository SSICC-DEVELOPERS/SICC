function fLimpiar() {
	onLoadPag();
}

function onLoadPag() {  
	fMostrarMensajeError();
	configurarMenuSecundario("formulario");
    DrdEnsanchaConMargenDcho('listado1',12);     
    eval (ON_RSZ);  
	ocultaCapa();
	btnProxy(1, '0');

	if(get('formulario.hidOidDefecto')!="") {
		var hidOidDefecto = get("formulario.hidOidDefecto");  
        var oidSeleccionado = new Array();
        oidSeleccionado = hidOidDefecto.split(",");	    
        set("formulario.cbCentroDistribucion", oidSeleccionado);	
		onChangeCmbCentroDistribucion();
	}

	focoCentroDistribucion();
}

function ocultaCapa(){
	document.all["Cplistado1"].style.visibility='hidden';
    document.all["CpLin1listado1"].style.visibility='hidden';
    document.all["CpLin2listado1"].style.visibility='hidden';
    document.all["CpLin3listado1"].style.visibility='hidden';
    document.all["CpLin4listado1"].style.visibility='hidden';
    document.all["ava1Div"].style.visibility='hidden';
    document.all["ret1Div"].style.visibility='hidden';
    document.all["separaDiv"].style.visibility='hidden';
	document.all["primera1Div"].style.visibility='hidden';
    document.all["btnModificarDiv"].style.visibility='hidden';
    document.all["btnDetalleDiv"].style.visibility='hidden';
}

function muestraCapa() {
	document.all["Cplistado1"].style.visibility='';
    document.all["CpLin1listado1"].style.visibility='';
    document.all["CpLin2listado1"].style.visibility='';
    document.all["CpLin3listado1"].style.visibility='';
    document.all["CpLin4listado1"].style.visibility='';
    document.all["ava1Div"].style.visibility='';
    document.all["ret1Div"].style.visibility='';
    document.all["separaDiv"].style.visibility='';
	document.all["primera1Div"].style.visibility='';

	var casoUso = get("formulario.casoUso");
	if(casoUso == "consultar") {
		document.all["btnModificarDiv"].style.visibility='hidden';
		document.all["btnDetalleDiv"].style.visibility='';
	}
	else if(casoUso == "modificar") {
		document.all["btnModificarDiv"].style.visibility='';
		document.all["btnDetalleDiv"].style.visibility='hidden';
	}
	else if(casoUso == "eliminar") {
		document.all["btnModificarDiv"].style.visibility='hidden';
		document.all["btnDetalleDiv"].style.visibility='hidden';
		listado1.maxSel = "-1";
	}
}

function onClickBtnBuscar() {  
	var arr = new Array();
	arr[arr.length] = new Array("oidCentroDistribucion", get("formulario.cbCentroDistribucion")+"");
	arr[arr.length] = new Array("oidLineaArmado", get("formulario.cbLineaArmado")+"");
	arr[arr.length] = new Array("oidSublineaArmado", get("formulario.cbSublinea")+"");
	arr[arr.length] = new Array("oidPais", get("formulario.pais")+"");
	arr[arr.length] = new Array("oidIdioma", get("formulario.idioma")+"");        configurarPaginado(mipgndo,"APEConsultarFormatosEtiquetas","ConectorConsultarFormatosEtiquetas","es.indra.sicc.dtos.ape.DTODatosEtiqueta",arr);  
}

function muestraLista(ultima, rowset, error){
	var tamano = rowset.length;
    if (tamano > 0) {
		muestraCapa();
        eval(ON_RSZ);
        focaliza("formulario.cbCentroDistribucion");
        return true;
    }
    else {
		ocultaCapa();
        focaliza("formulario.cbCentroDistribucion");
        return false;
    }
}

function onClickBtnDetalle() {
	if (listado1.numSelecc()!= 1) {
		GestionarMensaje('1022',null,null,null);
		return false;
	}

    var arrAux = new Array();
    arrAux = listado1.codSeleccionados();
    var posicion = obtenerPosicionListaEditable(listado1.codSeleccionados(),listado1);
    var obj = new Object();

    obj.oidFormatoEtiqueta = listado1.datos[posicion][0];           
    /* BELC300024733 - dmorello, 17/04/2007: Paso el OID de programa de etiqueta */
	//obj.formato = listado1.datos[posicion][4];
	/* dmorello, 19/04/2007: en lugar de OIDs se enviarán directamente las descripciones */
	//obj.oidProgramaEtiquetas = listado1.datos[posicion][8];
	obj.oidProgramaEtiquetas = listado1.datos[posicion][4];
	/* Fin BELC300024733 dmorello 17/04/2007 */
    //obj.oidCentroDistribucion = listado1.datos[posicion][5];
	obj.oidCentroDistribucion = listado1.datos[posicion][1];
    //obj.oidLineaArmado = listado1.datos[posicion][6];
	obj.oidLineaArmado = listado1.datos[posicion][2];
    //obj.oidSublineaArmado = listado1.datos[posicion][7];
	obj.oidSublineaArmado = listado1.datos[posicion][3];
	/* Fin dmorello 19/04/2007 */
      
    mostrarModalSICC('LPFormatosEtiquetas','detalle',obj);
}

function obtenerPosicionListaEditable(clave, lista){
	this.posicion = 0;
    if (lista.codSeleccionados().length > 0){
		for(var k=0;k<lista.datos.length;k++) {
			if (lista.datos[k][0] == clave) {
				posicion=k;
                break;
            }
		 }         
	     return posicion;
	}
}

function onClickBtnModificar() {
	if (listado1.numSelecc()!= 1) {
		GestionarMensaje('1022',null,null,null);
		return false;
	}

    var arrAux = new Array();
    arrAux = listado1.codSeleccionados();
    var posicion = obtenerPosicionListaEditable(listado1.codSeleccionados(),listado1);
    var obj = new Object();

    obj.oidFormatoEtiqueta = listado1.datos[posicion][0];           
    /* BELC300024733 - dmorello, 19/04/2007: Se reemplaza formato por programa etiquetas */
	//obj.formato = listado1.datos[posicion][4];
	obj.oidProgramaEtiquetas = listado1.datos[posicion][8];
	/* Fin BELC300024733 dmorello 19/04/2007 */
    obj.oidCentroDistribucion = listado1.datos[posicion][5];    
    obj.oidLineaArmado = listado1.datos[posicion][6];    
    obj.oidSublineaArmado = listado1.datos[posicion][7];
      
    mostrarModalSICC('LPFormatosEtiquetas','modificacion',obj);
	onClickBtnBuscar();
}

function fBorrar() {
    if (listado1.numSelecc()== 0) {
		GestionarMensaje('1021',null,null,null);
        return false;
    }
	else {
		//NOTA: No se utiliza este mensaje, debido que el subsistema de eliminacion
		//ya posee un mensaje de confirmacion.
		//¿Confirma eliminar los formatos etiqueta seleccionados?
		//var resp = GestionarMensaje('APE024');
		//if(resp == true) {
			eliminarFilas(listado1.codSeleccionados(),"APEFormatosEtiquetasEliminar", mipgndo);
		//}
	}   
}

function setearCbLineaArmado(datos) {
	var arrayNuevo = new Array();
	arrayNuevo[0] = new Array('','');
	arrayNuevo = arrayNuevo.concat(datos);
	set_combo('formulario.cbLineaArmado',arrayNuevo);

	var longitudCombo = combo_get('formulario.cbLineaArmado', 'L');
	var oidsLineasDef = get('formulario.hOidsLineasArmadoDefecto').split('|');
	for (var i = 1; i < longitudCombo; i++) {
		var value = combo_get('formulario.cbLineaArmado', 'V', i);
		for (var j = 0; j < oidsLineasDef.length; j++) {
			if (value == oidsLineasDef[j]) {
				set('formulario.cbLineaArmado', new Array(value));
				j = oidsLineasDef.length;
				i = longitudCombo;
			}
		}
	}

	onChangeCmbLineaArmado();
}

function onChangeCmbCentroDistribucion(){
	if(get('formulario.cbCentroDistribucion')!='') {
		recargaCombo('formulario.cbLineaArmado', 'APEObtenerLineasArmadoCD', 'es.indra.sicc.util.DTOOID', armarArrayComboCentroDistribucion(), 'setearCbLineaArmado(datos)');
	}
	else {
		set_combo('formulario.cbLineaArmado', new Array(['','']));
		set_combo('formulario.cbSublinea', new Array(['','']));
	}
}

function armarArrayComboCentroDistribucion() {
	var idioma = get('formulario.idioma');
	var oid = get('formulario.cbCentroDistribucion');
  
    var array = new Array();
    var index = 0;

    if( idioma != null && idioma != '' ){
		array[index] = new Array('oidIdioma', idioma);
        index++;
    }

	if( oid != null && oid != '' ){
		array[index] = new Array('oid', oid);
        index++;
    }
  
    return array;
}

function setearCbSublineaArmado(datos) {
	var arrayNuevo = new Array();
	arrayNuevo[0] = new Array('','');
	arrayNuevo = arrayNuevo.concat(datos);
	set_combo('formulario.cbSublinea',arrayNuevo);
}

function onChangeCmbLineaArmado() {
	if(get('formulario.cbLineaArmado')!='') {
		recargaCombo('formulario.cbSublinea', 'APEObtenerSubLineasArmadoCD', 'es.indra.sicc.util.DTOOID', 
		armarArrayComboLineaArmado(), 'setearCbSublineaArmado(datos)');
	}
	else {
		set_combo('formulario.cbSublinea', new Array(['','']));
	}
}

function armarArrayComboLineaArmado() {
	var idioma = get('formulario.idioma');
	var oid = get('formulario.cbLineaArmado');
  
    var array = new Array();
    var index = 0;

    if( idioma != null && idioma != '' ){
		array[index] = new Array('oidIdioma', idioma);
        index++;
    }

	if( oid != null && oid != '' ){
		array[index] = new Array('oid', oid);
        index++;
    }
  
    return array;
}

function focoCentroDistribucion() {
	focaliza("formulario.cbCentroDistribucion");
}

function focoLineaArmado() {
	focaliza("formulario.cbLineaArmado");
}

function focoSublineaArmado() {
	focaliza("formulario.cbSublinea");
}

function focoBotonBuscar() {
	focalizaBotonHTML('botonContenido','btnBuscar');
}

function focoBotonDetalle() {
	focalizaBotonHTML_XY('btnDetalle');
}

function focoBotonModificar() {
	focalizaBotonHTML_XY('btnModificar');
}

function onTabCentro() {
	focoLineaArmado();
}

function onShtabCentro() {
	var estado = document.all["Cplistado1"].style.visibility;
    if(estado=='hidden') {
		focoBotonBuscar();
	}
	else {
		if(get("formulario.casoUso")=="consultar"){
			focoBotonDetalle();
		}
		else if(get("formulario.casoUso")=="modificar"){
			focoBotonModificar();
		}
		else if(get("formulario.casoUso")=="eliminar"){
			focoBotonBuscar();
		}
	}
}

function onTabLinea(){
	focoSublineaArmado();
}

function onShtabLinea() {
	focoCentroDistribucion();
}

function onTabSublinea() {
	focoBotonBuscar();
}

function onShtabSublinea() {
	focoLineaArmado();
}

function onTabBotonBuscar() {
	var estado = document.all["Cplistado1"].style.visibility;
    if(estado=='hidden') {
		focoCentroDistribucion();
		return;
    }  

    var casoUso = get('formulario.casoUso');
    if(casoUso=='consultar'){
		focoBotonDetalle();
    }
	else if(casoUso=='modificar'){
		focoBotonModificar();
    }
	else if(casoUso=='eliminar'){
		focoCentroDistribucion();
    }
}

function ontabBotonDetalle() {
	focoCentroDistribucion();
}

function onshtabBotonDetalle() {
	focoBotonBuscar();
}

function ontabBotonModificar() {
	focoCentroDistribucion();
}

function onshtabBotonModificar() {
	focoBotonBuscar();
}