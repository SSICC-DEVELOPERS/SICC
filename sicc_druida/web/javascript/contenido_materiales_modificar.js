function onLoadPag()   {
	DrdEnsanchaConMargenDcho('lstresultados',12);
    document.all["Cplstresultados"].style.visibility='';
    document.all["CpLin1lstresultados"].style.visibility='';
    document.all["CpLin2lstresultados"].style.visibility='';
    document.all["CpLin3lstresultados"].style.visibility='';
    document.all["CpLin4lstresultados"].style.visibility='';
    document.all["prim1Div"].style.visibility='';
    document.all["ret1Div"].style.visibility='';
    document.all["ava1Div"].style.visibility='';
    document.all["ModificarDiv"].style.visibility='';
    eval (ON_RSZ);  
}
   
function ocultarLista(){
	DrdEnsanchaConMargenDcho('lstresultados',12);
    document.all["Cplstresultados"].style.visibility='hidden';
    document.all["CpLin1lstresultados"].style.visibility='hidden';
    document.all["CpLin2lstresultados"].style.visibility='hidden';
    document.all["CpLin3lstresultados"].style.visibility='hidden';
    document.all["CpLin4lstresultados"].style.visibility='hidden';
    document.all["prim1Div"].style.visibility='hidden';
    document.all["ret1Div"].style.visibility='hidden';
    document.all["ava1Div"].style.visibility='hidden';
    document.all["ModificarDiv"].style.visibility='hidden';  
    eval (ON_RSZ);  
}

function cargarPagina() {
	ocultarLista();
    configurarMenuSecundario("frmFormulario");

    focaliza('frmFormulario.txtCodSAP');
    completarComboIndicadorPS();

    if (get('frmFormulario.accion') == "Buscar" || get('frmFormulario.accion') == "Volver" )  {
		set('frmFormulario.R5',get('frmFormulario.hR5'));
		var chkIndicadorPS = new Array( [get('frmFormulario.hcbIndicadorPS')] );
		var chkMarca = new Array( [get('frmFormulario.hcbM')] );
		var chkUnidadNegocio = new Array( [get('frmFormulario.hcbUN')] );
		var chkNegocio = new Array( [get('frmFormulario.hcbNeg')] );
		var chkGenerico = new Array( [get('frmFormulario.hcbGeg')] );
		var chkSuperGenerico = new Array( [get('frmFormulario.hcbSNeg')] );
      
		set('frmFormulario.cbIndicadorPS',chkIndicadorPS);
      
		set('frmFormulario.cbM',chkMarca);
		set('frmFormulario.cbUN',chkUnidadNegocio);
		set('frmFormulario.cbNeg',chkNegocio);
		set('frmFormulario.cbGeg',chkGenerico);
		set('frmFormulario.cbSNeg',chkSuperGenerico);
	}
    if (get('frmFormulario.accion') == 'Volver')  {
		lstresultados.display2();
    }

	/*
    //Mueve la capa de resultados al lugar que corresponda
    if( get('frmFormulario.hMostrarResultado')=='S' ){
      
      moveTo('Resultado', 12, 370 );
    }
    else
      moveTo('Resultado', 12, 0 );
	*/    
    mostrarError();
}

function completarComboIndicadorPS()  {
	var producto = GestionarMensaje(1009);
    var servicio = GestionarMensaje(1008);
    
    combo_add('frmFormulario.cbIndicadorPS', "0", producto);
    combo_add('frmFormulario.cbIndicadorPS', "1", servicio);
  }

function realizarBusqueda()  {
	ocultarLista();
	var a = armarArray();
    configurarPaginado( mipgndo, "MAEBuscarMateriales", "ConectorBusquedaMaterialesPaginado", "es.indra.sicc.dtos.mae.DTOBusquedaMateriales", a );
}

function reemplazarValores(){
	var codigos;
    var valor;
    var i;

    codigos=lstresultados.codigos();

    if( codigos != null && codigos.length > 0 ){
		for( i = 0; i < codigos.length; i++ ){
			valor = codigos.extraeDato( codigos[i], '4' );
			if( valor == '0' ){
				insertaDato( codigos[i], 4, 'NO' );
			}else{
				insertaDato( codigos[i], 4, 'SI' );
			}
		}
	}
}

function mostrarError()  {
	if ( get('frmFormulario.errCodigo')!= "" )  {
		var errMsg = fMostrarMensajeError( get('frmFormulario.errCodigo'),get('frmFormulario.errDescripcion') );
	}
}

function realizarModificacion()  {
	set('frmFormulario.accion','Modificar');
    set('frmFormulario.conectorAction','LPBusquedaMateriales');

    var parametros = new Object();  
    
    var seleccionados = lstresultados.codSeleccionados();
    
    if( seleccionados.length == 1 ){
		var seleccionado = seleccionados[0];
		set('frmFormulario.hOID', seleccionado );
		parametros.oIDSeleccionado = seleccionado;
		var modifiedData = mostrarModalSICC("LPModificarMateriales", "", parametros );
		realizarBusqueda();
    }else{ 
		if( seleccionados.length > 1 ){
			GestionarMensaje( '8' );
		}else{
			if( seleccionados.length < 1 ){
				GestionarMensaje( '4' );
			}
		}
	}
}

function focalizarOnTabCodSAP() {
	focaliza('frmFormulario.txtCodSAP');     
}

function focalizarOnShTabSuperGenerico()  {
	focaliza('frmFormulario.cbSNeg');
}

function fLimpiar()  {
	focaliza('frmFormulario.txtCodSAP',"");
    /*set('frmFormulario.txtAnt',"");
    set('frmFormulario.txtDSAP',"");
    set('frmFormulario.txtDCorta',"");
    set('frmFormulario.R5',"");
    
    //set('frmFormulario.cbIndicadorPS',"");
    
    set('frmFormulario.cbM',"");
    set('frmFormulario.cbUN',"");
    set('frmFormulario.cbNeg',"");
    set('frmFormulario.cbGeg',"");
    set('frmFormulario.cbSNeg',"");*/
}

function armarArray(){
	var arrDatos = new Array();
	var i = 0;

	if( get('frmFormulario.hIdioma') != '' ){
		arrDatos[i] = new Array('oidIdioma', get('frmFormulario.hIdioma'));
		i++;
	}

	if( get('frmFormulario.txtAnt') != '' ){
		arrDatos[i] = new Array('codAntiguo', get('frmFormulario.txtAnt'));
		i++;
	}

	if( get('frmFormulario.txtCodSAP') != '' ){
		arrDatos[i] = new Array('codSAP', get('frmFormulario.txtCodSAP'));
		i++;
	}

	if( get('frmFormulario.txtDCorta') != '' ){
		arrDatos[i] = new Array('descCorta', get('frmFormulario.txtDCorta'));
		i++;
	}

	if( get('frmFormulario.txtDSAP') != '' ){
		arrDatos[i] = new Array('descSAP', get('frmFormulario.txtDSAP'));
		i++;
	}
  

	if( get('frmFormulario.cbGeg') != '' ){
		arrDatos[i] = new Array('generico', get('frmFormulario.cbGeg'));
		i++;
	}

	var indLote = get('frmFormulario.cbIdLote');

	if( indLote=='1' ){
		arrDatos[i] = new Array('indLote', 'true');
		i++;
	}else{
		if(indLote=='2'){
			arrDatos[i] = new Array('indLote', 'false');
			i++;
		}
	} 

	var indPS = get('frmFormulario.cbIndicadorPS');
	var sIndPS = indPS[0];

	if(sIndPS=="1"){
		arrDatos[i] = new Array('indProductoServicio', 'true' );
		i++;
	}else{
		if(sIndPS=="0"){
			arrDatos[i] = new Array('indProductoServicio', 'false' );
			i++;
		}else{
			arrDatos[i] = new Array('indProductoServicio', '' );
			i++;
		}
	}

	if( get('frmFormulario.cbM') != '' ){
		arrDatos[i] = new Array('marca', get('frmFormulario.cbM'));
		i++;
	}

	if( get('frmFormulario.cbNeg') != '' ){
		arrDatos[i] = new Array('negocio', get('frmFormulario.cbNeg'));
		i++;
	}

	if( get('frmFormulario.cbSNeg') != '' ){
		arrDatos[i] = new Array('supergenerico', get('frmFormulario.cbSNeg'));
		i++;
	}

	if( get('frmFormulario.cbUN') != '' ){
		arrDatos[i] = new Array('unidadNegocio', get('frmFormulario.cbUN'));
		i++;
	}
	return arrDatos;
}

function fVolver(){
	window.close();
}

function prueba( ultima, rowset, error){
	var tamano = rowset.length;

	if (tamano > 0) {
		//document.all["DetalleDiv"].style.visibility='hidden';	    
		document.all["ModificarDiv"].style.visibility='';
		document.all["Cplstresultados"].style.visibility='';
		document.all["CpLin1lstresultados"].style.visibility='';
		document.all["CpLin2lstresultados"].style.visibility='';
		document.all["CpLin3lstresultados"].style.visibility='';
		document.all["CpLin4lstresultados"].style.visibility='';
		document.all["ava1Div"].style.visibility='';
		document.all["ret1Div"].style.visibility='';
		//document.all["separa1Div"].style.visibility='';
		document.all["prim1Div"].style.visibility='';

		eval (ON_RSZ);
		focaliza('frmFormulario.txtCodSAP','');
		
		var i;
		var indexIndLote = 5;
		var indexPS = 6;
		var producto = GestionarMensaje(1009);
		var servicio = GestionarMensaje(1008);
		var si = GestionarMensaje(84);
		var no = GestionarMensaje(86);
	
		for( i = 0; i < rowset.length; i++ ){
			//reemplazar los valores en indicador lote
			if(rowset[i][indexIndLote] == '0'){
				rowset[i][indexIndLote] = no;
			}else{
				if(rowset[i][indexIndLote] == '1'){
					rowset[i][indexIndLote] = si;
	   			}else{
					rowset[i][indexIndLote] = '';
				}
			}
	
			//reemplazar los valores en producto servicio
			if( rowset[i][indexPS] == '0')
				rowset[i][indexPS] = producto;
			else if(rowset[i][indexPS] == '1')
				rowset[i][indexPS] = servicio;
		}
	
		return true;
	}else{
		document.all["ModificarDiv"].style.visibility='hidden';
		document.all["Cplstresultados"].style.visibility='hidden';
		document.all["CpLin1lstresultados"].style.visibility='hidden';
		document.all["CpLin2lstresultados"].style.visibility='hidden';
		document.all["CpLin3lstresultados"].style.visibility='hidden';
		document.all["CpLin4lstresultados"].style.visibility='hidden';
		document.all["ava1Div"].style.visibility='hidden';
		document.all["ret1Div"].style.visibility='hidden';
		document.all["prim1Div"].style.visibility='hidden';
					
        focaliza('frmFormulario.txtCodSAP','');
		cdos_mostrarAlert(error);
		return false;
	}
}

function muestraListaAA(error, ultima, rowset){
	var tamano = rowset.length;

	if (tamano > 0) {
		reemplazarValores();

		//document.all["DetalleDiv"].style.visibility='hidden';	    
		document.all["ModificarDiv"].style.visibility='';
		document.all["Cplstresultados"].style.visibility='';
		document.all["CpLin1lstresultados"].style.visibility='';
		document.all["CpLin2lstresultados"].style.visibility='';
		document.all["CpLin3lstresultados"].style.visibility='';
		document.all["CpLin4lstresultados"].style.visibility='';
		document.all["ava1Div"].style.visibility='';
		document.all["ret1Div"].style.visibility='';
		//document.all["separa1Div"].style.visibility='';
		//document.all["primera1Div"].style.visibility='';

		eval (ON_RSZ);
		focaliza('frmFormulario.txtCodSAP','');
		return true;
	}else{
		document.all["ModificarDiv"].style.visibility='hidden';
		document.all["Cplstresultados"].style.visibility='hidden';
		document.all["CpLin1lstresultados"].style.visibility='hidden';
		document.all["CpLin2lstresultados"].style.visibility='hidden';
		document.all["CpLin3lstresultados"].style.visibility='hidden';
		document.all["CpLin4lstresultados"].style.visibility='hidden';
		document.all["ava1Div"].style.visibility='hidden';
		document.all["ret1Div"].style.visibility='hidden';
					
        focaliza('frmFormulario.txtCodSAP','');
		cdos_mostrarAlert(error);
		return false;
	}
}

function setTabFocus( campo ){
	document.selection.empty();

	if(campo == 'txtCodSAP'){
		if( txtAnt.disabled == false ){
			focaliza('frmFormulario.txtAnt');
		}else{
			setTabFocus('txtAnt');
		}
	}else if(campo == 'txtAnt'){
		if( txtDSAP.disabled == false ){
			focaliza('frmFormulario.txtDSAP');
		}else{
			setTabFocus('txtDSAP');
		}
	}else if(campo == 'txtDSAP'){
		if( txtDCorta.disabled == false ){
			focaliza('frmFormulario.txtDCorta');
		}else{
			setTabFocus('txtDCorta');
		}
	}else if(campo == 'txtDCorta'){
		if( cbIdLote.disabled == false ){
			focaliza('frmFormulario.cbIdLote');
		}else{
			setTabFocus('cbIdLote');
		}
	}else if(campo == 'cbIdLote'){
		if( cbIndicadorPS.disabled == false ){
			focaliza('frmFormulario.cbIndicadorPS');
		}else{
			setTabFocus('cbIndicadorPS');
		}
	}else if(campo == 'cbIndicadorPS'){
		if( cbM.disabled == false ){
			focaliza('frmFormulario.cbM');
		}else{
			setTabFocus('cbM');
		}
	}else if(campo == 'cbM'){
		if( cbUN.disabled == false ){
			focaliza('frmFormulario.cbUN');
		}else{
			setTabFocus('cbUN');
		}
	}else if(campo == 'cbUN'){
		if( cbNeg.disabled == false ){
			focaliza('frmFormulario.cbNeg');
		}else{
			setTabFocus('cbNeg');
		}
	}else if(campo == 'cbNeg'){
		if( cbGeg.disabled == false ){
			focaliza('frmFormulario.cbGeg');
		}else{
			setTabFocus('cbGeg');
		}
	}else if(campo == 'cbGeg'){
		if( cbSNeg.disabled == false ){
			focaliza('frmFormulario.cbSNeg');
		}else{
			setTabFocus('cbSNeg');
		}
	}else if(campo == 'cbSNeg'){
		focalizaBotonHTML('botonContenido','Buscar');
	}else if(campo == 'Buscar'){
		if( document.all["ModificarDiv"].style.visibility != 'hidden' ){
			focalizaBotonHTML_XY('Modificar');
		}else{
			setTabFocus('Modificar');
		}
	}else if(campo == 'Modificar'){
		if( txtCodSAP.disabled == false ){
			focaliza('frmFormulario.txtCodSAP');
		}else{
			setTabFocus('txtCodSAP');
		}
	}
}

function setSHTabFocus( campo ){
	if(campo == 'txtCodSAP'){
		if( document.all["ModificarDiv"].style.visibility != 'hidden' ){
			focalizaBotonHTML_XY('Modificar');
		}else{
			setSHTabFocus('Modificar');
		}
	}else if(campo == 'txtAnt'){
		if( txtCodSAP.disabled == false ){
			focaliza('frmFormulario.txtCodSAP');
		}else{
			setTabFocus('txtCodSAP');
		}
	}else if(campo == 'txtDSAP'){
		if( txtAnt.disabled == false ){
			focaliza('frmFormulario.txtAnt');
		}else{
			setTabFocus('txtAnt');
		}
	}else if(campo == 'txtDCorta'){
		if( txtDSAP.disabled == false ){
			focaliza('frmFormulario.txtDSAP');
		}else{
			setTabFocus('txtDSAP');
		}
	}else if(campo == 'cbIdLote'){
		if( txtDCorta.disabled == false ){
			focaliza('frmFormulario.txtDCorta');
		}else{
			setTabFocus('txtDCorta');
		}
	}else if(campo == 'cbIndicadorPS'){
		if( cbIdLote.disabled == false ){
			focaliza('frmFormulario.cbIdLote');
		}else{
			setTabFocus('cbIdLote');
		}
	}else if(campo == 'cbM'){
		if( cbIndicadorPS.disabled == false ){
			focaliza('frmFormulario.cbIndicadorPS');
		}else{
			setTabFocus('cbIndicadorPS');
		}
	}else if(campo == 'cbUN'){
		if( cbM.disabled == false ){
			focaliza('frmFormulario.cbM');
		}else{
			setTabFocus('cbM');
		}
	}else if(campo == 'cbNeg'){
		if( cbUN.disabled == false ){
			focaliza('frmFormulario.cbUN');
		}else{
			setTabFocus('cbUN');
		}
	}else if(campo == 'cbGeg'){
		if( cbNeg.disabled == false ){
			focaliza('frmFormulario.cbNeg');
		}else{
			setTabFocus('cbNeg');
		}
	}else if(campo == 'cbSNeg'){
		if( cbGeg.disabled == false ){
			focaliza('frmFormulario.cbGeg');
		}else{
			setTabFocus('cbGeg');
		}
	}else if(campo == 'Buscar'){
		if( cbSNeg.disabled == false ){
			focaliza('frmFormulario.cbSNeg');
		}else{
			setTabFocus('cbSNeg');
		}
	}else if(campo == 'Modificar'){
		focalizaBotonHTML('botonContenido','Buscar');
	}
}
