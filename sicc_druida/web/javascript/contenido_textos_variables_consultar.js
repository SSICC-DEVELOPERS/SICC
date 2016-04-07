function fLimpiar() {
	onLoadPag();
}

function onLoadPag() {  
	fMostrarMensajeError();
	configurarMenuSecundario("formulario");
	DrdEnsanchaConMargenDcho('listado1',12);     
    eval (ON_RSZ);  
	ocultaCapa();
	
	var oidSeleccionado = new Array();    
    set("formulario.comboTipoCliente", oidSeleccionado);	
	set_combo('formulario.comboSubtipoCliente', new Array(['','']));
	set_combo('formulario.comboTipoClasificacion', new Array(['','']));
	set_combo('formulario.comboClasificacion', new Array(['','']));	
	focaliza("formulario.comboTipoCliente");
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

function onChangeCmbTipoCliente() {
	if(get('formulario.comboTipoCliente')!="") {
		set_combo('formulario.comboSubtipoCliente', new Array(['','']));
		set_combo('formulario.comboTipoClasificacion', new Array(['','']));
		set_combo('formulario.comboClasificacion', new Array(['','']));

		recargaCombo('formulario.comboSubtipoCliente', 'MAEobtenerSubtipos', 'es.indra.sicc.util.DTOOID', armarArrayComboTipoCliente());
	}
	else {
		set_combo('formulario.comboSubtipoCliente', new Array(['','']));
		set_combo('formulario.comboTipoClasificacion', new Array(['','']));
		set_combo('formulario.comboClasificacion', new Array(['','']));
	}
}

function armarArrayComboTipoCliente() {
	var idioma = get('formulario.idioma');
	var oid = get('formulario.comboTipoCliente');
  
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

function onChangeSubtipoCliente(){ 
	if(get('formulario.comboSubtipoCliente')!="") {
		set_combo('formulario.comboTipoClasificacion', new Array(['','']));
		set_combo('formulario.comboClasificacion', new Array(['','']));

		recargaCombo('formulario.comboTipoClasificacion', 'MAEobtenerTipoClasificacion', 'es.indra.sicc.util.DTOOID', 	armarArrayComboSubtipoCliente());
	}
	else {
		set_combo('formulario.comboTipoClasificacion', new Array(['','']));
		set_combo('formulario.comboClasificacion', new Array(['','']));
	}
}

function armarArrayComboSubtipoCliente() {
	var idioma = get('formulario.idioma');
	var oid = get('formulario.comboSubtipoCliente');
  
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

function onChangeTipoClasificacion() {
	if(get('formulario.comboTipoClasificacion')!="") {
		set_combo('formulario.comboClasificacion', new Array(['','']));
		recargaCombo('formulario.comboClasificacion', 'MAEobtenerClasificacionesPorTipo', 'es.indra.sicc.util.DTOOID', armarArrayComboTipoClasificacion());
	}
	else {
		set_combo('formulario.comboClasificacion', new Array(['','']));
	}
}

function armarArrayComboTipoClasificacion() {
	var idioma = get('formulario.idioma');
	var oid = get('formulario.comboTipoClasificacion');
  
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

function onClickBtnBuscar() {
	if(sicc_validaciones_generales()) {  
		var arr = new Array();
		arr[arr.length] = new Array("oidTipoCliente", get("formulario.comboTipoCliente")+"");
		arr[arr.length] = new Array("oidSubtipoCliente", get("formulario.comboSubtipoCliente")+"");
		arr[arr.length] = new Array("oidTipoClasificacion", get("formulario.comboTipoClasificacion")+"");
		arr[arr.length] = new Array("oidClasificacion", get("formulario.comboClasificacion")+"");
		arr[arr.length] = new Array("oidPais", get("formulario.pais")+"");
		arr[arr.length] = new Array("oidIdioma", get("formulario.idioma")+"");       
		configurarPaginado(mipgndo,"APEConsultarConfiguracionTextoVariable","ConectorConsultarConfiguracionTextoVariable","es.indra.sicc.dtos.ape.DTODatosTextoVariable",arr);  
	}
}

function muestraLista(ultima, rowset, error){
	var tamano = rowset.length;
    if (tamano > 0) {
		muestraCapa();
        eval(ON_RSZ);
        focaliza("formulario.comboTipoCliente");
        return true;
    }
    else {
		ocultaCapa();
        focaliza("formulario.comboTipoCliente");
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

    obj.oidSeleccionado = listado1.datos[posicion][0];           
    obj.oidTipoCliente = listado1.datos[posicion][6];    
    obj.oidSubtipoCliente = listado1.datos[posicion][7];    
    obj.oidTipoClasificacion = listado1.datos[posicion][8];    
    obj.oidClasificacion = listado1.datos[posicion][9];
	obj.textoVariable = listado1.datos[posicion][5];
      
    mostrarModalSICC('LPConfiguracionTextosVariables','detalle',obj);
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

    obj.oidSeleccionado = listado1.datos[posicion][0];           
    obj.oidTipoCliente = listado1.datos[posicion][6];    
    obj.oidSubtipoCliente = listado1.datos[posicion][7];    
    obj.oidTipoClasificacion = listado1.datos[posicion][8];    
    obj.oidClasificacion = listado1.datos[posicion][9];
	obj.textoVariable = listado1.datos[posicion][5];
      
    mostrarModalSICC('LPConfiguracionTextosVariables','modificacion',obj);
	onClickBtnBuscar();
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

function fBorrar() {
    if (listado1.numSelecc()== 0) {
		GestionarMensaje('1021',null,null,null);
        return false;
    }
	else {
		eliminarFilas(listado1.codSeleccionados(),"APEEliminarConfiguracionTextosVariables", mipgndo);
	}   
}

function onShTabComboTipoCliente() {
	var estado = document.all["Cplistado1"].style.visibility;
    if(estado=='hidden') {
		focalizaBotonHTML('botonContenido','btnBuscar');	
	}
	else {
		if(get("formulario.casoUso")=="consultar"){
			focalizaBotonHTML_XY('btnDetalle');
		}
		else if(get("formulario.casoUso")=="modificar"){
			focalizaBotonHTML_XY('btnModificar');	
		}
		else if(get("formulario.casoUso")=="eliminar"){
			focalizaBotonHTML('botonContenido','btnBuscar');	
		}
	}	
}

function onTabComboTipoCliente() {
	focaliza("formulario.comboSubtipoCliente");
}

function onShTabComboSubtipoCliente() {
	focaliza("formulario.comboTipoCliente");
}

function onTabComboSubtipoCliente() {
	focaliza("formulario.comboTipoClasificacion");
}

function onShTabComboTipoClasificacion() {
	focaliza("formulario.comboSubtipoCliente");
}

function onTabComboTipoClasificacion() {
	focaliza("formulario.comboClasificacion");
}

function onShTabComboClasificacion() {
	focaliza("formulario.comboTipoClasificacion");
}

function onTabComboClasificacion() {
	focalizaBotonHTML('botonContenido','btnBuscar');	
}

function onTabBuscar() {
	var estado = document.all["Cplistado1"].style.visibility;
    if(estado=='hidden') {
		focaliza("formulario.comboTipoCliente");
		return;
    }  

    var casoUso = get('formulario.casoUso');
    if(casoUso=='consultar'){
		focalizaBotonHTML_XY('btnDetalle');
    }
	else if(casoUso=='modificar'){
		focalizaBotonHTML_XY('btnModificar');		
    }
	else if(casoUso=='eliminar'){
		focaliza("formulario.comboTipoCliente");
    }
}

function onShTabBuscar() {
	focaliza("formulario.comboClasificacion");
}

function ontabBotonDetalle() {
	focaliza("formulario.comboTipoCliente");
}

function onshtabBotonDetalle() {
	focalizaBotonHTML('botonContenido','btnBuscar');
}

function ontabBotonModificar() {
	focaliza("formulario.comboTipoCliente");
}

function onshtabBotonModificar() {
	focalizaBotonHTML('botonContenido','btnBuscar');
}