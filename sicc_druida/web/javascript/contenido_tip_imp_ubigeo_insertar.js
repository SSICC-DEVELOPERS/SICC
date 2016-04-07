var formName = "frmFormulario";
var ult_nivel = "";
var nivel1 = '';  
var varNoLimpiarSICC = false;

function onLoadPag(){

		configurarMenuSecundario('frmFormulario');

		var niveles = new Array();
		niveles = (get(formName + ".hidComboLabels").toString()).split("_");

		if(niveles.length > 0){
		   nivel1 = niveles[0];
		}
			
		if(niveles.length > 9) {
			ult_nivel = 9;
		}else{
			ult_nivel = niveles.length;
		}

		varNoLimpiarSICC = true;

		for(i = 0; i < ult_nivel;i ++)
			txt_to('lblNivel' + (i+1),niveles[i]);

		if (get("frmFormulario.casoDeUso")=='modificar') {

			parametros = window.dialogArguments.parametros;
			
			set("frmFormulario.hidOidTipoImp",parametros.oidTipoImpu);
			var aCanal = new Array(new Array("1",parametros.canal));
			var aAcceso = new Array(new Array("1",parametros.acceso));
			var aSubacceso = new Array(new Array("1",parametros.subacceso));
			set_combo('frmFormulario.cbCanal', aCanal, []); 
			set_combo('frmFormulario.cbAcceso', aAcceso, []); 
			set_combo('frmFormulario.cbSubacceso', aSubacceso, []); 

            var iSel = new Array();
            iSel[0] = '1';
            set('frmFormulario.cbCanal',iSel);   
            set('frmFormulario.cbAcceso',iSel);   
            set('frmFormulario.cbSubacceso',iSel);   

			var ubigeo = parametros.unidadGeografica;
			var ubigeos = ubigeo.split(',');
			for(i = 0; i < ult_nivel;i ++) {
				var n = i + 1;
				if (ubigeos[i]!=undefined) {				
					var div = ubigeos[i].split('/');
					var aCmb = new Array(new Array("1",div[1]));
					set_combo('frmFormulario.cbNivel'+n, aCmb, []);
					set('frmFormulario.cbNivel'+n,iSel);
				}
				var objCmb = document.getElementById('cbNivel'+n);				
				objCmb.disabled = true;
			}

			var objCanal = document.getElementById('cbCanal');
			var objAcceso = document.getElementById('cbAcceso');
			var objSbac = document.getElementById('cbSubacceso');

			objCanal.disabled = true;
			objAcceso.disabled = true;
			objSbac.disabled = true;
			
			var objImp = document.getElementById('cbIndImpuesto');
			
			for(i = 0; i < objImp.length;i ++) {
				if (objImp[i].text==parametros.impuesto) {
					var impOriginal = objImp[i].value;
					set('frmFormulario.hidOidTasaImpInicial',impOriginal);
					iSel[0] = impOriginal;
					set('frmFormulario.cbIndImpuesto',iSel); 
				}
			}

		} else {
				
			cargarComboPrincipal();

			focaliza('frmFormulario.cbCanal');
		}
				   
}

function cambioCanal(){
	 
		opcionesAcceso = new Array();     
		set_combo('frmFormulario.cbAcceso',opcionesAcceso);        
		tipoC1 = get('frmFormulario.cbCanal','V');
		combo_add('frmFormulario.cbAcceso', '', '');

		for(var k=0;k<lstAcceso.datos.longitud;k++) {
			for(var x=0;x<tipoC1.length;x++){
				if (lstAcceso.datos.ij(k,2) == tipoC1[x]){ 			 
					combo_add('frmFormulario.cbAcceso',lstAcceso.datos.ij(k,0),lstAcceso.datos.ij(k,1));
				}
			}
		}
		cambioAcceso();
}

function cambioAcceso(){
	 
		opcionesSubacceso = new Array();     
		set_combo('frmFormulario.cbSubacceso',opcionesSubacceso);        
		tipoA1 = get('frmFormulario.cbAcceso','V');
		combo_add('frmFormulario.cbSubacceso', '', '');

		for(var k=0;k<lstSubacceso.datos.longitud;k++) {
			for(var x=0;x<tipoA1.length;x++){
				if (lstSubacceso.datos.ij(k,2) == tipoA1[x]){ 			 
					combo_add('frmFormulario.cbSubacceso',lstSubacceso.datos.ij(k,0),lstSubacceso.datos.ij(k,1));
				}
			}
		}
} 

function fLimpiar() {
	limpiar();
}

function limpiar(){

	var niveles = new Array();
	niveles = (get(formName + ".hidComboLabels").toString()).split("_");

	if(niveles.length > 0){
	   nivel1 = niveles[0];
	}
		
	if(niveles.length > 9) {
		ult_nivel = 9;
	}else{
		ult_nivel = niveles.length;
	}

	for(i = 0; i < ult_nivel;i ++)
		txt_to('lblNivel' + (i+1),niveles[i]);
	if (get("frmFormulario.casoDeUso")=='modificar') {

        var iSel = new Array();
        iSel[0] = get('frmFormulario.hidOidTasaImpInicial');
		set('frmFormulario.cbIndImpuesto',iSel); 

		focaliza('frmFormulario.cbIndImpuesto');

	} else {
		var aCombo = new Array(new Array("",""));
		set_combo('frmFormulario.cbAcceso', aCombo, []); 
		set_combo('frmFormulario.cbSubacceso', aCombo, []); 
		set('frmFormulario.cbCanal', '');
		set('frmFormulario.cbNivel1', '');
		set('frmFormulario.cbIndImpuesto', '');
		set_combo('frmFormulario.cbNivel2',aCombo, []);
		set_combo('frmFormulario.cbNivel3',aCombo, []);
		set_combo('frmFormulario.cbNivel4',aCombo, []);
		set_combo('frmFormulario.cbNivel5',aCombo, []);
		set_combo('frmFormulario.cbNivel6',aCombo, []);
		set_combo('frmFormulario.cbNivel7',aCombo, []);
		set_combo('frmFormulario.cbNivel8',aCombo, []);
		set_combo('frmFormulario.cbNivel9',aCombo, []);

		focaliza('frmFormulario.cbCanal');
	}
}


function cargarComboDeNivel(nivel,codigo){
	var oid = get(formName + '.cbNivel'+(nivel-1)).toString();
	for(var i = nivel; i < 10;i++) {
	   set_combo(formName + '.cbNivel'+i,'');
	}
	if(oid != "") {
		if(nivel <= ult_nivel) {
		   recargaCombo(formName + ".cbNivel" + nivel, "MAERecargaComboUBIGEO", "es.indra.sicc.util.DTOOID", makeParameters(oid));
		}
	}
}

function makeParameters(oid) {
	var parametros = new Array([],[]);
	parametros[0][0] = "oid";
	parametros[0][1] = oid;
	parametros[1][0] = "oidPais";
	parametros[1][1] = get(formName + ".pais").toString();
	return parametros;
}

function formarCadena(idBusiness , dto, parametros) {
	var cadena = idBusiness + "|" + dto + "|";
	//concateno los parámetros en parejas separadas por ampersand (como en una url).
	for(i=0;i<parametros.length;i++) {
		cadena += parametros[i][0] + "=" + parametros[i][1];
		if (i!= parametros.length-1) {
		   cadena += "&";
		}
	}
	return cadena;
}

function recargaCombo(combo, idBusiness, dto, parametros) {
	asignar([['COMBO', combo, 'ConectorDruidaTransactionQuery', 'dtoSalida.resultado_ROWSET',formarCadena(idBusiness, dto, parametros)]]);
}

function cargarComboPrincipal() {
	var parametros = new Array([],[]);
	parametros[0][0] = "oid";
	parametros[0][1] = "";
	parametros[1][0] = "oidPais";
	parametros[1][1] = get(formName + ".pais").toString();
	recargaCombo(formName + ".cbNivel1", "MAERecargaComboUBIGEO", "es.indra.sicc.util.DTOOID", parametros);
}

function fGuardar() {
	 if (!sicc_validaciones_generales()) {

	 }else{
		if (get("frmFormulario.casoDeUso")=='modificar') {

		   set('frmFormulario.accion','guardarModificar');

		} else {

		   set('frmFormulario.accion','guardar');

		}	   
	   set('frmFormulario.conectorAction','LPMantenimientoTiposImpuestosPorUbigeo');
	 
	   eval("frmFormulario").oculto="S";
	   enviaSICC('frmFormulario', '', '', 'N');
	 }
}

function guardarCorrecto() {
	if (get("frmFormulario.casoDeUso")=='modificar') {
		window.returnValue = 'guardo'; 
		window.close();
	} else {
		limpiar();
	}
}

function guardarError() {
}

function fVolver() {	
	window.close();
}