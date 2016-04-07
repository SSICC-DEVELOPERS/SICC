
function onLoadPag() {
	configurarMenuSecundario("formulario");
	fMostrarMensajeError();
	var casoUso = get("formulario.casoUso");
	
	if (casoUso == "insertar") {
        // No mostrar columna de Codigo
        show_hide_column(3, false);
        show_hide_column(1, false);
        
		fLimpiar();
		
	} else if (casoUso == "detalle" || casoUso == "modificarDetalle") {
        // Mostrar columna de Codigo
        show_hide_column(3, true);
        show_hide_column(1, true);
		
		var iSeleccionado = new Array();
		
		iSeleccionado[0] = get("formulario.hOutsourcing");
		set('formulario.cbNivelOursourcing', iSeleccionado);
		iSeleccionado[0] = get("formulario.hOrdenListaPicado");
		set('formulario.cbOrdenListaPicado', iSeleccionado);
		iSeleccionado[0] = get("formulario.hOrden");
		set('formulario.cbOrden', iSeleccionado);
		iSeleccionado[0] = get("formulario.hAgrupacionParaAFP");
		set('formulario.cbAgrupacionParaAFP', iSeleccionado);
		iSeleccionado[0] = get("formulario.hoidCodigoVisual");
		set('formulario.cbCodigoVisualChequeo', iSeleccionado);
		if(get('formulario.hradioButton')== "Ascendente"){
			set('formulario.RBOreden',"A" );
		}else{
			set('formulario.RBOreden',"D" );
		}
		if(get('formulario.hck77') == "1"  || get('formulario.hck77') == "SI" ){
			set('formulario.chkImpresionDatosBC', 'S');
		}else{
			set('formulario.chkImpresionDatosBC', 'N');
		}
		limpiaI18N("formulario", "1");
	}

	if (casoUso != "detalle") {
		focaliza("formulario.txtDescripcion");
	}

}

function fGuardar() {
	if(!sicc_validaciones_generales()){
		return false;
	}
	
	set('formulario.conectorAction','LPMantenimientoCentroDistribucion');
	set('formulario.accion','guardar');
	eval('formulario').oculto = "S";
	enviaSICC('formulario');
}

function fLimpiar() {
    if (get("formulario.casoUso") == "insertar") {
		set('formulario.txtDescripcion', '');
		set('formulario.cbNivelOursourcing', '');
		set('formulario.chkCentroDefault', 'N');
		set('formulario.cbOrdenListaPicado', '');
		set('formulario.cbOrden', '');
		set('formulario.txtChequeoListaPicado', '');
		set('formulario.txtPrimeroPicado', '');
		set('formulario.cbAgrupacionParaAFP', '');
		set('formulario.cbCodigoVisualChequeo', '');
		set('formulario.RBOreden',"A" );
		set('formulario.chkImpresionDatosBC', 'N');

	} else {
		set('formulario.txtDescripcion', get("formulario.hDescripcionCD"));
		set('formulario.cbNivelOursourcing', [get("formulario.hOutsourcing")]);
		set('formulario.chkCentroDefault', get("formulario.hDefault"));
		set('formulario.cbOrdenListaPicado', [get("formulario.hOrdenListaPicado")]);
		set('formulario.cbOrden', [get("formulario.hOrden")]);
		set('formulario.txtChequeoListaPicado', get("formulario.hTextoChequeoListaPicado"));
		set('formulario.txtPrimeroPicado', get("formulario.hTextoPrimeroPicado"));
		set('formulario.cbAgrupacionParaAFP', [get("formulario.hAgrupacionParaAFP")]);
		set('formulario.cbCodigoVisualChequeo', [get("formulario.hoidCodigoVisual")]);
		if(get('formulario.hradioButton')== "Ascendente"){
			set('formulario.RBOreden',"A" );
		}else{
			set('formulario.RBOreden',"D" );
		}
		if(get('formulario.hck77') == "1"  || get('formulario.hck77') == "SI" ){
			set('formulario.chkImpresionDatosBC', 'S');
		}else{
			set('formulario.chkImpresionDatosBC', 'N');
		}

    }
	limpiaI18N("formulario", "1");
}

function fVolver() {
	window.close();
}

function onTab(campo) {
	if (campo == "cbAgrupacionParaAFP") {
		focaliza('formulario.txtDescripcion');
	}
}

function onShTab(campo) {
	if (campo == "txtDescripcion") {
		focaliza('formulario.cbAgrupacionParaAFP');
	}
}

function bienGuardado() {
    if (get("formulario.casoUso") == "modificarDetalle") {
        var arrayParaDevolver = new Array();
        arrayParaDevolver[0] = get('formulario.txtDescripcion');
        arrayParaDevolver[1] = get('formulario.chkCentroDefault');
        arrayParaDevolver[2] = get('formulario.cbNivelOursourcing');
        arrayParaDevolver[3] = get('formulario.cbNivelOursourcing', 'T');
        arrayParaDevolver[4] = get('formulario.cbOrdenListaPicado');
        arrayParaDevolver[5] = get('formulario.cbOrdenListaPicado', 'T');
        arrayParaDevolver[6] = get('formulario.cbOrden');
        arrayParaDevolver[7] = get('formulario.cbOrden', 'T');
        arrayParaDevolver[8] = get('formulario.txtChequeoListaPicado');
        arrayParaDevolver[9] = get('formulario.txtPrimeroPicado');
        arrayParaDevolver[10] = get('formulario.cbAgrupacionParaAFP');
        arrayParaDevolver[11] = get('formulario.cbAgrupacionParaAFP', 'T');
		arrayParaDevolver[12] = get('formulario.chkImpresionDatosBC');
		arrayParaDevolver[13] = get('formulario.cbCodigoVisualChequeo');
		arrayParaDevolver[14] = get('formulario.cbCodigoVisualChequeo', 'T');
		arrayParaDevolver[15] = get('formulario.RBOreden');
        window.returnValue = arrayParaDevolver;
    } else {
  	    fLimpiar();
	    return true;
    }
}

function malGuardado() {
	return false;
}

function show_hide_column(col_no, do_show) {
	showHideCell(1,col_no,do_show);
	showHideCell(5,col_no,do_show);
}

function showHideCell(row,col_no,do_show){
    var stl;
    var tbl  = document.getElementById('primeraFila');
    var rows = tbl.getElementsByTagName('tr');

    if (do_show){
        stl = 'block';
    }else{
        stl = 'none';
    }
    var cels = rows[row].getElementsByTagName('td')
    cels[col_no].style.display=stl;
}
