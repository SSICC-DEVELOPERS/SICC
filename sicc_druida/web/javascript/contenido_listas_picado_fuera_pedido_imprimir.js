function onLoad(){
    configurarMenuSecundario('formulario');
    fMostrarMensajeError();
    ocultarLista();
    focaliza('formulario.cbMarca');
}

function onchangeMarcaCanal(){
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
        recargaCombo('formulario.cbZona', 'ZONRecargaZonas', 'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa',arr);
        var aCombo = new Array(new Array("",""));
        set_combo('formulario.cbSeccion', aCombo, []);
        
    }else{
        var aCombo = new Array(new Array("",""));
        set_combo('formulario.cbZona', aCombo, []); 
        set_combo('formulario.cbSeccion', aCombo, []); 
    }
}

function onchangeZona(){

    var zona = get('formulario.cbZona');
    
    if(zona!=''){
    
        // Inicializa combo
        var opciones = new Array();
        set_combo('formulario.cbSeccion',opciones);                         
        combo_add('formulario.cbSeccion', '', '');

        // Recarga combo
        var arr = new Array();
        arr[arr.length] = ["oidIdioma", get('formulario.varIdioma')]; 
        arr[arr.length] = ["oidPais", get('formulario.varPais')]; 
        arr[arr.length] = ["oidZona", zona];
        recargaCombo("formulario.cbSeccion", "ZONRecargaSecciones", "es.indra.sicc.dtos.zon.DTOUnidadAdministrativa",arr);
        
    }else{
        var aCombo = new Array(new Array("",""));
        set_combo('formulario.cbSeccion', aCombo, []); 
    }
}


function accionImprimir(){
	var seleccionados = listado1.codSeleccionados();
	if (seleccionados.length == 0) {
		GestionarMensaje("4", null, null, null);
		return;
	}
	// Extraigo de la lista los OIDs 
	var oids = new Array();
	for (var i = 0; i < seleccionados.length; i++) {
		var oidLinea = listado1.extraeDato(seleccionados[i], 5);
		oids[oids.length] = oidLinea;
	}
	//eliminarFilas(oidsLineas, "APEEliminarConfiguracionBalanceo", mipgndo);
	//Llamar a la LPImpresionListaPicadoFP con accion ="imprimir
	var hListasPicado = listaSeleccionadaToXml('listado1');
	//alert(hListaUsuarios);
	set("formulario.hListasPicado", hListasPicado);

	set('formulario.conectorAction','LPImpresionListaPicadoFP');
	set('formulario.accion','imprimir');
	eval('formulario').oculto = "S";
	enviaSICC('formulario');

}

function listaSeleccionadaToXml(listado) {
	var xmlDoc = "<?xml version='1.0' encoding='ISO-8859-1' standalone='yes'?>";
	xmlDoc = xmlDoc + "<DOC>";
	var datos = eval(listado + ".datos;");
	var codSeleccionados = eval(listado + ".codSeleccionados();");
	var cantFilas = datos.length;
	/* Recorre las filas */ 	
	for (var i=0; i<codSeleccionados.length; i++){
		//alert("codSeleccionados:" + codSeleccionados[i] + ",i:" + i);
		for (var j=0; j<cantFilas ; j++){
			var linea = datos[j]; 
			if(codSeleccionados[i]==DrdEscXML(linea[0])){
				xmlDoc = xmlDoc + "<ROW>";
				/* Recorre los campos dentro de la fila */
				var cantCampos = linea.length;
				for (var k = 0; k < cantCampos; k++ ) {
					/* Quito formato local de numero */ 
					var campo = linea[k];
					//alert("DrdEscXML(campo):" + DrdEscXML(campo) + ",k:" + k);
					xmlDoc = xmlDoc + "<CAMPO>" + DrdEscXML(campo) + "</CAMPO>";
				}
				xmlDoc = xmlDoc + "</ROW>"
			}
		}
	}
	xmlDoc = xmlDoc + "</DOC>";
	//alert(xmlDoc);
	return xmlDoc; 
}

function accionBuscar(){

    if (!sicc_validaciones_generales()) {
        return false;
    }

    var parametros = new Array();
    parametros[parametros.length] = new Array('oidIdioma', get('formulario.varIdioma'));
    parametros[parametros.length] = new Array('oidPais', get('formulario.varPais'));
    var fechaArmado = get('formulario.txtFechaArmado','V');
    var oidMarca = get('formulario.cbMarca','V');
    var oidCanal = get('formulario.cbCanal','V');
    var oidZona = get('formulario.cbZona','V');
    var oidSeccion = get('formulario.cbSeccion','V');
    
    if (fechaArmado != ''){
         parametros[parametros.length] = new Array('fechaArmado', fechaArmado);
    }
    if (oidMarca != ''){
         parametros[parametros.length] = new Array('oidMarca', oidMarca);
    }
    if (oidCanal != ''){
         parametros[parametros.length] = new Array('oidCanal', oidCanal);
    }
    if (oidZona != ''){
         parametros[parametros.length] = new Array('oidZona', oidZona);
    }
    if (oidSeccion != ''){
         parametros[parametros.length] = new Array('oidSeccion', oidSeccion);
    }
    configurarPaginado(mipgndo,
         'APEBuscarListaPicadoCabeceraFP',
         'ConectorBuscarListaPicadoCabeceraFP',
         'es.indra.sicc.dtos.ape.DTOBusquedaListaPicadoFP',
         parametros);
}

function muestraLista(ultima, rowset) {
    var tamano = rowset.length;
    if (tamano > 0) {
        mostrarLista();
        return true; 
    }else{
        ocultarLista();
        focaliza('formulario.cbMarca');
        return false;  
    }
}

function mostrarLista(){
    DrdEnsanchaConMargenDcho('listado1',12);
    document.all["Cplistado1"].style.visibility='visible';
    document.all["CpLin1listado1"].style.visibility='visible';
    document.all["CpLin2listado1"].style.visibility='visible';
    document.all["CpLin3listado1"].style.visibility='visible';
    document.all["CpLin4listado1"].style.visibility='visible';
    document.all["primera1Div"].style.visibility='visible';
    document.all["ret1Div"].style.visibility='visible';
    document.all["ava1Div"].style.visibility='visible';
    document.all["separaDiv"].style.visibility='visible';
    document.all["ImprimirDiv"].style.visibility='visible';
    eval(ON_RSZ);
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
    document.all["ImprimirDiv"].style.visibility='hidden';
}

function ejecutaBien(){
	 ocultarLista();
}

function ejecutaMal(){
	// NO HAY FLLUJO ALTERNATIVO
}
