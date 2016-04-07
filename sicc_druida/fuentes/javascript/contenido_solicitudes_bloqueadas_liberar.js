var form = "frmContenido.";

	var objElem = new Object();
	// estructura del objeto [[opcion1 shtab, opcion2 shtab] ,[opcion1 tab, opcion2 tab]]
	objElem['cbMarca'] = [['Liberar','btnBuscar'],['cbCanal','']] ;
	objElem['cbCanal'] = [['cbMarca',''],['cbSubVentas','']] ;
	objElem['cbSubVentas'] =[['cbCanal',''],['cbRegion','']] ;
	objElem['cbRegion'] = [['cbSubVentas',''],['cbZona','']] ;
	objElem['cbZona'] =  [['cbRegion',''],['cbNJerarUsu','']];
	objElem['cbNJerarUsu'] = [['cbZona',''],['cbNivelRiesgo','']];
	objElem['cbNivelRiesgo'] = [['cbNJerarUsu',''],['chk1','']];
	objElem['chk1'] = [['cbNivelRiesgo',''],['chk2','']];
	objElem['chk2'] = [['chk1',''],['chk3','']];
	objElem['chk3'] = [['chk2',''],['chk4','']];
	objElem['chk4'] = [['chk3',''],['cbGrupoSolicitud','']];
	objElem['cbGrupoSolicitud'] = [['chk4',''],['cbEstatus','']];
	objElem['cbEstatus'] = [['cbGrupoSolicitud',''],['txtEjecutivoCuenta','']];
	objElem['txtEjecutivoCuenta'] = [['cbEstatus',''],['cbPeriodo','']];
	objElem['cbPeriodo'] = [['txtEjecutivoCuenta',''],['txtMontoOrdenDesde','']];
	objElem['txtMontoOrdenDesde'] = [['cbPeriodo',''],['txtMontoOrdenHasta','']];
	objElem['txtMontoOrdenHasta'] = [['txtMontoOrdenDesde',''],['txtMontoDeudaDesde','']];
	objElem['txtMontoDeudaDesde'] = [['txtMontoOrdenHasta',''],['txtMontoDeudaHasta','']];
	objElem['txtMontoDeudaHasta'] = [['txtMontoDeudaDesde',''],['btnBuscar','btnBuscar']] ;
	objElem['btnBuscar'] = [['txtMontoDeudaHasta',''],['Rechazar','cbMarca']];
	objElem['Rechazar'] = [['btnBuscar',''],['Reasignar','']];
	objElem['Reasignar'] = [['Rechazar',''],['Liberar','']];
	objElem['Liberar'] = [['Reasignar',''],['cbMarca','']];




	function onLoadPag(){
        fMostrarMensajeError();
		focaliza(form + 'cbMarca');
		setTimeout ('configurarMenuSecundario("frmContenido");',200);
		
	}

	function mostrarLista(){
	    DrdEnsanchaConMargenDcho('listado1',12);
		if (document.all["Cplistado1"].style.visibility != 'visible'){
			document.all["Cplistado1"].style.visibility='visible';
			document.all["CpLin1listado1"].style.visibility='visible';
			document.all["CpLin2listado1"].style.visibility='visible';
			document.all["CpLin3listado1"].style.visibility='visible';
			document.all["CpLin4listado1"].style.visibility='visible';
			document.all["primera1Div"].style.visibility='visible';
			document.all["ret1Div"].style.visibility='visible';
			document.all["ava1Div"].style.visibility='visible';
			document.all["separaDiv"].style.visibility='visible';
			document.all["RechazarDiv"].style.visibility='visible';
			document.all["ReasignarDiv"].style.visibility='visible';
			document.all["LiberarDiv"].style.visibility='visible';		
			setTimeout ('eval (ON_RSZ);',200);
		}
	   
	    //ON_RSZ = '';
	}

	function ocultarLista(){
	    DrdEnsanchaConMargenDcho('listado1',12);
		if (document.all["Cplistado1"].style.visibility != 'hidden'){
			document.all["Cplistado1"].style.visibility='hidden';
			document.all["CpLin1listado1"].style.visibility='hidden';
			document.all["CpLin2listado1"].style.visibility='hidden';
			document.all["CpLin3listado1"].style.visibility='hidden';
			document.all["CpLin4listado1"].style.visibility='hidden';
			document.all["primera1Div"].style.visibility='hidden';
			document.all["ret1Div"].style.visibility='hidden';
			document.all["ava1Div"].style.visibility='hidden';
			document.all["separaDiv"].style.visibility='hidden';
			document.all["RechazarDiv"].style.visibility='hidden';
			document.all["ReasignarDiv"].style.visibility='hidden';
			document.all["LiberarDiv"].style.visibility='hidden';	
			setTimeout ('eval (ON_RSZ);',200);
		}

	   // ON_RSZ = '';
	}

	function gestionaLista( ultima, rowset ){
		//var tamano = ;
		if (rowset.length > 0) {
			mostrarLista();
			return true;
		} else {
			ocultarLista();
			focaliza(form + 'cbMarca');
			return false;
		}
	}


	function buscar_click(){
		if( sicc_validaciones_generales() ){
			
			var formato = get(form + 'formato');
			montoOrdenHasta = numeroDeFormatoSICC(get(form + 'txtMontoOrdenHasta'), formato);
			montoOrdenDesde = numeroDeFormatoSICC(get(form + 'txtMontoOrdenDesde'), formato);

			if( montoOrdenHasta < montoOrdenDesde ){
				GestionarMensaje('UICAR004', null, null, null);
				focaliza( form + 'txtMontoOrdenDesde' );
				return;
			}

			montoDeudaHasta = numeroDeFormatoSICC(get(form + 'txtMontoDeudaHasta'), formato);
			montoDeudaDesde = numeroDeFormatoSICC(get(form + 'txtMontoDeudaDesde'), formato);

			if( montoDeudaHasta < montoDeudaDesde ){
				GestionarMensaje('UICAR005', null, null, null);
				focaliza( form + 'txtMontoDeudaDesde' );
				return;
			}
			configurarPaginado(mipgndo, "CARBuscarSolBloqueadas", "ConectorBuscarSolBloqueadas", 
								"es.indra.sicc.dtos.car.DTOBusquedaSolBloqueadas", armarArray(montoOrdenHasta,montoOrdenDesde
																							 ,montoDeudaHasta,montoDeudaDesde) );
			focaliza(form + 'cbMarca');
		}		
	}



	function armarArray(montoOrdenHasta, montoOrdenDesde ,montoDeudaHasta, montoDeudaDesde){	
		var hh = new Array();
		var i=0;
		if( get(form + 'cbMarca') != ''){
			hh[i] = new Array('oidMarca', get(form + 'cbMarca'));
            i++;
		}
		if( get(form + 'cbCanal') != ''){
			hh[i] = new Array('oidCanal', get(form + 'cbCanal'));
            i++;
		}
		if( get(form + 'cbSubVentas') != ''){
			hh[i] = new Array('oidSubgerencia', get(form + 'cbSubVentas'));
            i++;
		}
		if( get(form + 'cbRegion') != ''){
			hh[i] = new Array('oidRegion', get(form + 'cbRegion'));
            i++;
		}
		if( get(form + 'cbZona') != ''){
			hh[i] = new Array('oidZona', get(form + 'cbZona'));
            i++;
		}
		if( get(form + 'cbNJerarUsu') != ''){
			hh[i] = new Array('oidNivelJerarquico', get(form + 'cbNJerarUsu'));
            i++;
		}
		if( get(form + 'cbNivelRiesgo') != ''){
			hh[i] = new Array('oidNivelRiesgo', get(form + 'cbNivelRiesgo'));
            i++;
		}
		
		hh[i] = new Array('validacion1', get(form + 'chk1') == 'S' ? '0' : '1');
        i++;

		hh[i] = new Array('validacion2', get(form + 'chk2') == 'S' ? '0' : '1');
        i++;

		hh[i] = new Array('validacion3', get(form + 'chk3') == 'S' ? '0' : '1');
        i++;

		hh[i] = new Array('validacion4', get(form + 'chk4') == 'S' ? '0' : '1');
        i++;

		if( get(form + 'cbGrupoSolicitud') != ''){
			hh[i] = new Array('oidGrupoSolicitud', get(form + 'cbGrupoSolicitud'));
            i++;
		}

		//alert(hh);

		estatus = get(form + 'cbEstatus');
		var estatBloqueado  = get(form + 'ESTATUS_BLOQUEADO');
		var estatLiberado   = get(form + 'ESTATUS_LIBERADO');
		var estatReasignado = get(form + 'ESTATUS_REASIGNADO');
		var estatRechazado  = get(form + 'ESTATUS_RECHAZADO');

		if( estatus != ''){
			for( j=0; j < estatus.length; j++ ){
				switch( estatus[j] ){
					case estatBloqueado:
						hh[i] = new Array('estatusBloqueado', '1');
						break;
					case estatLiberado:
						hh[i] = new Array('estatusLiberado', '1');
						break;
					case estatReasignado:
						hh[i] = new Array('estatusReasignado', '1');
						break;
					case estatRechazado:
						hh[i] = new Array('estatusRechazado', '1');
						break;
				}
				i++;
			}
		}
		if( get(form + 'txtEjecutivoCuenta') != ''){
			hh[i] = new Array('ejecutivo', get(form + 'txtEjecutivoCuenta'));
            i++;
		}
		if( get(form + 'cbPeriodo') != ''){
			hh[i] = new Array('oidPeriodo', get(form + 'cbPeriodo'));
            i++;
		}
		
		if( get(form + 'txtMontoOrdenDesde') != ''){
			hh[i] = new Array('montoOrdenDesde', montoOrdenDesde );
            i++;
		}
		if( montoOrdenHasta != ''){
			hh[i] = new Array('montoOrdenHasta',montoOrdenHasta );
            i++;
		}
		if( get(form + 'txtMontoDeudaDesde') != ''){
			hh[i] = new Array('montoDeudaDesde', montoDeudaDesde );
            i++;
		}
		if( get(form + 'txtMontoDeudaHasta') != ''){
			hh[i] = new Array('montoDeudaHasta',montoDeudaHasta );
	        i++;
		}
		
		return hh;
	}


	function canal_onChange(){

		set_combo(form + 'cbRegion', ['',''] );
		set_combo(form + 'cbZona', ['',''] );

		var marca  = get(form + 'cbMarca');
		var canal = get(form + 'cbCanal');

		if( marca!= '' && canal != '' ){
			combo1 = form + 'cbSubVentas';
			combo2 = form + 'cbPeriodo';
			var pais = get (form + 'pais');
			recargaCombo(form + 'cbSubVentas', 'ZONRecargaSubgerenciaVentas', 
					'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa', [['oidMarca', marca], 
					['oidCanal', canal], ['oidPais', pais]], 'RCSetearDatos(datos, combo1)' );

			recargaCombo(form + 'cbPeriodo', 'CRAObtienePeriodos', 
					'es.indra.sicc.dtos.cra.DTOPeriodo', [['marca', marca], 
					['canal', canal], ['pais', pais]], 'RCSetearDatos(datos, combo2)' );
		} else {
			set_combo(form + 'cbSubVentas', ['',''] );
			set_combo(form + 'cbPeriodo', ['',''] );
		}

	}


	function marca_onChange(){
		canal_onChange();
	}


	function subgerencia_onChange(){
		
		set_combo(form + 'cbRegion', ['',''] );
		set_combo(form + 'cbZona', ['',''] );

		if( get(form + 'cbSubVentas') != '' ){
			combo = form + 'cbRegion';
			recargaCombo(form + 'cbRegion', 'ZONRecargaRegiones', 'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa',
						[['oidSGV', get(form + 'cbSubVentas')]], 'RCSetearDatos(datos, combo)');
			
		}
	}

	function region_onChange(){
		

		if( get(form + 'cbRegion') != '' ){
			recargaCombo(form + 'cbZona', 'ZONRecargaZonas', 'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa',
						[['oidRegion', get(form + 'cbRegion')]]);

		}else {
			set_combo(form + 'cbZona', ['',''] );
		}
	}


	function RCSetearDatos(datos, combo){
		if( datos.length == 0 ){
			set_combo(combo, ['','']);
		}else{
			var datosMasBlanco = new Array(datos.length + 1);
			datosMasBlanco[0] = new Array('', '');
			for( i=0; i < datos.length; i++ ){
				datosMasBlanco[i+1] = new Array(2);
				datosMasBlanco[i+1][0] = datos[i][0];
				datosMasBlanco[i+1][1] = datos[i][1];
			}
			set_combo(combo, datosMasBlanco);			
		}
	}


	function rechazar_click(){
		var valorSeteado = mipgndo.lista.codSeleccionados();
		if( valorSeteado != '' ){

			//[1] set(form + 'accion', 'rechazar');
			//[1] set(form + 'seleccion', valorSeteado);
			//[1] enviaSICC("frmContenido");
		
			var objParamsInt = new Object();
			var objForm = new Object();

			objParamsInt.opener = window;
			objParamsInt.conectorAction= 'LPSolicitudesBloqueadas';
			objForm.accion = 'rechazar'; 
			objForm.seleccion = valorSeteado;
			objParamsInt.parametros = objForm;
			setValues(objParamsInt);
			
		}else{
			GestionarMensaje('8', null, null, null);
		}
	}

	function reasignar_click(){
		var valorSeteado = mipgndo.lista.codSeleccionados();
		var filaSelecc = mipgndo.lista.filaSelecc;
		set(form + 'accion', 'reasignar');

		if( valorSeteado != '' ){
			var obj = new Object();
			obj.oidSolicitudBloqueada = valorSeteado;
			obj.NivelJerarquico  = mipgndo.lista.datos[filaSelecc][15];
			obj.EjecutivoCuenta = mipgndo.lista.datos[filaSelecc][16];
			var winModal = mostrarModalSICC('LPSolicitudesBloqueadas', 'reasignar', obj, null, null);
			buscar_click();
		}else{
			GestionarMensaje('8', null, null, null);
		}
	}

	function liberar_click(){	
		var valorSeteado = mipgndo.lista.codSeleccionados();
		var filaSelecc = mipgndo.lista.filaSelecc;
		if( valorSeteado != '' ){
			var oidJerarquia = mipgndo.lista.datos[filaSelecc][23];


			if( oidJerarquia <= get(form + 'varNivelJerarquiaUsuario') ){

				var obj = new Object();
				obj.oidSolicitudBloqueada = valorSeteado;
				obj.varEjecutivoCuenta = get(form + 'varEjecutivoCuenta');
				var winModal = mostrarModalSICC('LPSolicitudesBloqueadas', 'liberar', obj, null, null);
				buscar_click();
			}else{
				GestionarMensaje('UICAR006', null, null, null);
			}
		}else{
			GestionarMensaje('8', null, null, null);
		}
	}


	
	function tab(elemento){
		var tmpElemento = objElem[elemento][1][0];
		switch(elemento){
			case 'btnBuscar':
				try {
					focalizaBotonHTML('botonContenido', tmpElemento);
					
				}catch(e){
					focaliza(form + objElem[elemento][1][1]);	
				
				}
				break;
			case 'Rechazar':
				focalizaBotonHTML('botonContenido', tmpElemento);
				break;
			case 'Reasignar':
				focalizaBotonHTML('botonContenido', tmpElemento);
				break;
			case 'Liberar':
				focaliza(form + tmpElemento);
				break;
			default:
				try {
					focaliza(form + tmpElemento);		
				}catch(e){
					focalizaBotonHTML('botonContenido', objElem[elemento][1][1]);
				}
				break;
		}
	}

function shtab(elemento){
	var tmpElemento = objElem[elemento][0][0];
	switch(elemento){
		case 'btnBuscar':
			focaliza(form + tmpElemento);			
			break;
		case 'Rechazar':
			focalizaBotonHTML('botonContenido', tmpElemento);
			break;
		case 'Reasignar':
			focalizaBotonHTML('botonContenido', tmpElemento);
			break;
		case 'Liberar':
			focalizaBotonHTML('botonContenido', tmpElemento);
			break;
		case 'cbMarca':
			try {
				focalizaBotonHTML('botonContenido', tmpElemento);
			}catch(e){
				focalizaBotonHTML('botonContenido', objElem[elemento][0][1]);
			}
			break
		default:
			focaliza(form + tmpElemento);
			break;
	}
}

function fLimpiar(){
	set_combo(form + 'cbSubVentas', ['',''] );
	set_combo(form + 'cbRegion', ['',''] );
	set_combo(form + 'cbZona', ['',''] );
	set_combo(form + 'cbPeriodo', ['',''] );
	set(form + 'chk1', 'N');
	set(form + 'chk2', 'N');
	set(form + 'chk3', 'N');
	set(form + 'chk4', 'N');		
	focaliza(form + 'cbMarca');
}

function setValues(objParams){
	if(objParams.parametros){

		var atributos;
		//Limpio todos los campos insertados del frm que envio
		eliminaElementosDinamicos();
		for(atributos in objParams.parametros){
			if(atributos != "window" && atributos != "length"){
				var hidden = document.createElement("INPUT");
				hidden.type = "hidden";
				hidden.insertado = "1";
				hidden.name = atributos;
				hidden.value = (objParams.parametros[atributos]==null)?"":objParams.parametros[atributos];
				document.forms["frmContenidoEnvia"].appendChild(hidden);
			}
		}
		set('frmContenidoEnvia.conectorAction', objParams.conectorAction);
		enviaSICC("frmContenidoEnvia");
	}
	
}

function eliminaElementosDinamicos(){
	var elementos = document.forms["frmContenidoEnvia"].elements;
	var longitud = elementos.length;
	for ( i = 0;i < longitud; i++ ){
		var oChild=document.forms["frmContenidoEnvia"].children(i);	
		if (oChild!= null && oChild.insertado=="1"){
			document.forms["frmContenidoEnvia"].removeChild(oChild);
			i = i-1;
		}
	}
}
