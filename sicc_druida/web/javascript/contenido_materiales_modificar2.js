varNoLimpiarSICC = true;
	
function cargarPagina() {
	configurarMenuSecundario("frmFormulario");
	verificarModificables();
    
	//
	asignarIdLoteReq();

	//Focalizar en primer campo habilitado
	if(hayCampoHabilitado('')==1){	
		focalizaEnPrimerCampoHabilitado();
	}
	
	completarComboSituacion();
	completarComboIndDentroCaja();
	completarComboIndicadorPS();
      
	//Completa el combo Codigo Pago Fraccionado
	//Este combo no existe mas.
	//completarComboIndicadorDC();

	//-------------------------------------------------
	//yyy CREAR FUNCION PARA CARGAR EL COMBO FORMA PAGO
	//-------------------------------------------------

	if (get('frmFormulario.accion') == "")  {
		completarCampos();
	}

	if (get('frmFormulario.accion') == "Guardar")  {
		completarCampos();
	}

	//Se asigna al radio ind lote
	if( get('frmFormulario.hIndLote')=='S' || get('frmFormulario.hIndLote')=='N' ){
		set( 'frmFormulario.rbIdLote', get('frmFormulario.hIndLote') );
	}

	iSeleccionado10 = new Array(); 
	iSeleccionado10[0] = get('frmFormulario.hcbSituac');
	set('frmFormulario.cbSituac',iSeleccionado10);
}


function fErrorAlModificar(){
	if(hayCampoHabilitado('')==1){	
		focalizaEnPrimerCampoHabilitado();
	}
}


function asignarIdLoteReq(){
	var idLoteReq = get('frmFormulario.hIdLoteReq');
	var tdRadio = document.getElementById('tdRadio');

	if( idLoteReq == 'S' ){
		tdRadio.all.tags('IMG')[0].style.display = 'inline';
	}else{
		setMV('frmFormulario.rbIdLote','N'); 
		tdRadio.all.tags('IMG')[0].style.display = 'none';
	}
}

function focalizaEnPrimerCampoHabilitado(){
	if( txtAnt.disabled == false ){
		focaliza('frmFormulario.txtAnt');
	}else{
		setTabFocus('txtAnt');
	}
}

function validacion(){
	if(!sicc_validaciones_generales()){
		return false;
	}else{
		return true;
	}
}

function fGuardar()  {    
	if(validacion()){
		set('frmFormulario.accion','Guardar');
		set('frmFormulario.conectorAction','LPModificarMateriales');
		enviaSICC('frmFormulario');  
	}
}
    
function ParcheComboLinea()  {       
	var si = GestionarMensaje(1010, "", "", "");
	var no = GestionarMensaje(1011, "", "", "");
	combo_add('frmFormulario.cbLin', "0", si);
	combo_add('frmFormulario.cbLin', "1", no);
}
    
function focalizarOnTabVxD() {      
	focaliza('frmFormulario.txtAnt');       
}
    
function focalizarOnShTab()  {
	focaliza('frmFormulario.txtPrecioContable');
}
    
function fLimpiar()  {
	set('frmFormulario.txtAnt',       get('frmFormulario.hTxtAnt'));
	set('frmFormulario.txtDSAP',      get('frmFormulario.hTxtDSap'));
	set('frmFormulario.txtDCorta',    get('frmFormulario.hTxtDCorta'));
	set('frmFormulario.R5',           get('frmFormulario.hR5'));

	iSeleccionado = new Array();
	iSeleccionado[0] = get( 'frmFormulario.hIndLote' );
	set( 'frmFormulario.rbIdLote', iSeleccionado[0].toUpperCase() );

	iSeleccionado = new Array(); 
	iSeleccionado[0] = get('frmFormulario.hcbIndicadorPS');
	set('frmFormulario.cbIdPS',iSeleccionado);

	iSeleccionado1 = new Array();
	iSeleccionado1[0] = get('frmFormulario.hcbM');
	set('frmFormulario.cbM',iSeleccionado1);

	iSeleccionado2 = new Array(); 
	iSeleccionado2[0] = get('frmFormulario.hcbUN');
	set('frmFormulario.cbUN',iSeleccionado2);

	iSeleccionado3 = new Array(); 
	iSeleccionado3[0] = get('frmFormulario.hcbNeg');
	set('frmFormulario.cbNeg',iSeleccionado3);

	iSeleccionado4 = new Array(); 
	iSeleccionado4[0] = get('frmFormulario.hcbGenr');
	set('frmFormulario.cbGenr',iSeleccionado4);

	iSeleccionado5 = new Array(); 
	iSeleccionado5[0] = get('frmFormulario.hcbSuperGeg');
	set('frmFormulario.cbSuperGeg',iSeleccionado5);
          
	set('frmFormulario.txtJ1',        get('frmFormulario.hTxtJ1'));
	set('frmFormulario.txtJ2',        get('frmFormulario.hTxtJ2'));
	set('frmFormulario.txtJ3',        get('frmFormulario.hTxtJ3'));

	iSeleccionado6 = new Array(); 
	iSeleccionado6[0] = get('frmFormulario.hcbLin');
	set('frmFormulario.cbLin',iSeleccionado6);
    
	set('frmFormulario.txtA1',        get('frmFormulario.hTxtA1'));
	set('frmFormulario.txtA2',        get('frmFormulario.hTxtA2'));
	set('frmFormulario.txtA3',        get('frmFormulario.hTxtA3'));
	set('frmFormulario.txtDA',        get('frmFormulario.hTxtDA'));
	set('frmFormulario.txtDL',        get('frmFormulario.hTxtDL'));
	set('frmFormulario.txtDAL',       get('frmFormulario.hTxtDAL'));
    
	iSeleccionado7 = new Array(); 
	iSeleccionado7[0] = get('frmFormulario.hcbUNMedidaDimensiones');
	set('frmFormulario.cbUNMedidaDimensiones',iSeleccionado7);

	set('frmFormulario.txtVoluA',     get('frmFormulario.hTxtVoluA'));
    
	iSeleccionado8 = new Array(); 
	iSeleccionado8[0] = get('frmFormulario.hcbUDV');
	set('frmFormulario.cbUDV',iSeleccionado8);
    
	set('frmFormulario.txtPeso',      get('frmFormulario.hTxtPeso'));
  
	iSeleccionado9 = new Array(); 
	iSeleccionado9[0] = get('frmFormulario.hcbUDP');
	set('frmFormulario.cbUDP',iSeleccionado9);

	set('frmFormulario.txtUnidDentroPedido',get('frmFormulario.hTxtUnidDentroPedido'));
	set('frmFormulario.txtUDC',       get('frmFormulario.hTxtUDC'));
	set('frmFormulario.txtCosteEstandar',get('frmFormulario.hTxtCosteEstandar'));
	set('frmFormulario.txtPPos',get('frmFormulario.hTxtPPos'));
  

	iSeleccionado10 = new Array(); 
	iSeleccionado10[0] = get('frmFormulario.hcbSituac');
	set('frmFormulario.cbSituac',iSeleccionado10);
  
	iSeleccionado11 = new Array(); 
	iSeleccionado11[0] = get('frmFormulario.hcbSProd');
	set('frmFormulario.cbSProd',iSeleccionado11);

	iSeleccionado12 = new Array(); 
	iSeleccionado12[0] = get('frmFormulario.hFormaPago');
	set('frmFormulario.cbFormaPago',iSeleccionado12);

	
	if( get('frmFormulario.hcbSCaja') == 'C' ){
		set('frmFormulario.cbSCaja', ['C']);
	}else{
		if( get('frmFormulario.hcbSCaja') == 'B' ){
			set('frmFormulario.cbSCaja', ['B']);
		} else {
			set('frmFormulario.cbSCaja', '');
		}
	}

	set('frmFormulario.txtCodImpuesto',get('frmFormulario.hTxtCodImpuesto'));
	set('frmFormulario.txtPrecioCatalogo',get('frmFormulario.hTxtPrecioCatalogo'));
	set('frmFormulario.txtPrecioContable',get('frmFormulario.hTxtPrecioContable'));
	set('frmFormulario.txtGrupoArticulos',get('frmFormulario.hTxtGrupoArticulos'));
      
	//Focalizar en primer campo habilitado
	if (hayCampoHabilitado('')==1)	
		focalizaEnPrimerCampoHabilitado();
}
    
function MostrarPantallaExito()  {
	if (get('frmFormulario.exito') == 'si' & get('frmFormulario.accion') == 'Guardar')  {
		var wnd = fMostrarMensajeExito(get('frmFormulario.casoDeUso').toLowerCase());
		set('frmFormulario.exito',"");
		fVolver();
	}
	if (get('frmFormulario.exito') == 'no' & get('frmFormulario.accion') == 'Guardar')  {
		fMostrarMensajeError();
	}
}
    
function fVolver()  {
	set('frmFormulario.conectorAction','LPModificarMateriales');
    set('frmFormulario.accion','Volver');
    window.close();

    //----------------------------------------------------------
    //yyy ACTUALIZAR LA LISTA EDITABLE CON LOS DATOS MODIFICADOS
    //----------------------------------------------------------
}
    
function completarComboIndicadorPS()  {
	var producto = GestionarMensaje(1009);
	var servicio = GestionarMensaje(1008);
	combo_add('frmFormulario.cbIdPS', "0", producto);
	combo_add('frmFormulario.cbIdPS', "1", servicio);
}
    
function completarComboIndicadorDC()  {
	var si = GestionarMensaje(1010);
	var no = GestionarMensaje(1011);
	combo_add('frmFormulario.cbCodPagoFraccionado', "0", si);
	combo_add('frmFormulario.cbCodPagoFraccionado', "1", no);     
}

function completarComboSituacion()  {
	var activo = GestionarMensaje(156);
	var inactivo = GestionarMensaje(157);
	combo_add('frmFormulario.cbSituac', "A", activo);
	combo_add('frmFormulario.cbSituac', "I", inactivo);
}

function completarComboIndDentroCaja(){
	var caja = GestionarMensaje(1012);
	var bolsa = GestionarMensaje(1013);
	combo_add('frmFormulario.cbSCaja', "B", bolsa);
	combo_add('frmFormulario.cbSCaja', "C", caja);
}

/*
* pperanzola - 07/10/2005 - [2] cambios segun SICC-DMCO-PRE_MAE_INT-GCC-001
*/
function completarCampos()  {
    
	set('frmFormulario.R5',get('frmFormulario.hR5'));
	var chkIndicadorPS = new Array( [get('frmFormulario.hcbIndicadorPS')] );
	set('frmFormulario.cbIdPS',chkIndicadorPS);
	var chkMarca = new Array( [get('frmFormulario.hcbM')] );
	set('frmFormulario.cbM',chkMarca);
	var chkUnidadNegocio = new Array( [get('frmFormulario.hcbUN')] );
	set('frmFormulario.cbUN',chkUnidadNegocio);
	var chkNegocio = new Array( [get('frmFormulario.hcbNeg')] );
	set('frmFormulario.cbNeg',chkNegocio);
	var chkGenerico = new Array( [get('frmFormulario.hcbGenr')] );
	set('frmFormulario.cbGenr',chkGenerico);
	var chkSuperGenerico = new Array( [get('frmFormulario.hcbSuperGeg')] );
	set('frmFormulario.cbSuperGeg',chkSuperGenerico);
	chkLinea = new Array();
	chkLinea[0] = get('frmFormulario.hcbLin');
	set('frmFormulario.cbLin',chkLinea);
	chkUMD = new Array();
	chkUMD[0] = get('frmFormulario.hcbUNMedidaDimensiones');
	set('frmFormulario.cbUNMedidaDimensiones',chkUMD);
	chkUDV = new Array();
	chkUDV[0] = get('frmFormulario.hcbUDV');
	set('frmFormulario.cbUDV',chkUDV);
	chkUDP = new Array();
	chkUDP[0] = get('frmFormulario.hcbUDP');
	set('frmFormulario.cbUDP',chkUDP);
      
	if ( get('frmFormulario.hcbSituac') == 'A' ){
		set('frmFormulario.cbSituac', ['A']);
	}else{
		set('frmFormulario.cbSituac', ['I']);
	}

	chkStatus = new Array();
	chkStatus[0]=get('frmFormulario.hcbSProd');
	set('frmFormulario.cbSProd',chkStatus);

	//Combo Ind. dentro caja
	if( get('frmFormulario.hcbSCaja') == 'C' ){
		set('frmFormulario.cbSCaja', ['C']);
	}else if( get('frmFormulario.hcbSCaja') == 'B' ){
		set('frmFormulario.cbSCaja', ['B']);
	}

	//Combo Forma Pago
	set('frmFormulario.cbFormaPago', [ get('frmFormulario.hFormaPago') ]);
	set('frmFormulario.cbProgFidelizacion', [ get('frmFormulario.hcbProgFide') ]); //[2]
}

function actualizarHiddenRadio(){
	var t = get( 'frmFormulario.rbIdLote' ) ;
	set( 'frmFormulario.hR5', t );
}

function cerrarModal(){
	var obj = new Object();
	obj.codSAP = get( 'frmFormulario.hCodSap' );
	obj.codAntiguo = get( 'frmFormulario.txtAnt' );
	obj.descSAP = get( 'frmFormulario.txtDSAP' );
	obj.descCorta = get( 'frmFormulario.txtDCorta' );

	if( get( 'frmFormulario.hR5' ) == 'S' || get( 'frmFormulario.hR5' ) == 's' ){
		obj.indLote = '1';
	}else if (get( 'frmFormulario.hR5' ) == 'N' || get( 'frmFormulario.hR5' ) == 'n' ){
		obj.indLote = '0';
	}else{
		obj.indLote = '';
	}

	if( get( 'frmFormulario.cbIdPS' ) == null ){
		obj.indPS = ' ';
	}else{
		var idps = get( 'frmFormulario.cbIdPS');
		if( idps.length >= 1 ){
			obj.indPS = idps[0];
		}
	}

	var aMarca = get( 'frmFormulario.cbM', 'T' );

	if( aMarca != null ){
		obj.marca = aMarca[0];
	}else{
		obj.marca = ' ';
	}

	if( get( 'frmFormulario.cbUN' ) == null ){
		obj.unidadNegocio = ' ';
	}else{
		var aUN = get( 'frmFormulario.cbUN' );
		if( aUN.length >= 1 ){
			obj.unidadNegocio = aUN[0];
		}else{
			obj.unidadNegocio = ' ';
		}
	}

	if( get( 'frmFormulario.cbNeg' ) == null ){
		obj.negocio = ' ';
	}else{
		var aN = get( 'frmFormulario.cbNeg' );
		if( aN.length >= 1 ){
			obj.negocio = aN[0];
		}else{
			obj.negocio = ' ';
		}
	}

	if( get( 'frmFormulario.cbGenr' ) == null ){
		obj.generico = ' ';
	}else{
		var aGen = get( 'frmFormulario.cbGenr' );
		if( aGen.length >= 1 ){
			obj.generico = aGen[0];
		}else{
			obj.generico = ' ';
		}
	}
      
	if( get( 'frmFormulario.cbSuperGeg' ) == null ){
		obj.superGenerico = ' ';
	}else{
		var aSGen = get( 'frmFormulario.cbSuperGeg' );
		if( aSGen.length >= 1 ){
			obj.superGenerico = aSGen[0];
		}else{
			obj.superGenerico = ' ';
		}
	}
	window.returnValue = obj ;
	window.close();
}

function verificarModificables(){
	if(get('frmFormulario.hModtxtAnt') == 'S'){
		accion('frmFormulario.txtAnt', '.disabled=true');
	}

	if( get('frmFormulario.hModtxtDSAP') == 'S' ){
		accion('frmFormulario.txtDSAP', '.disabled=true');
	}

	if(get('frmFormulario.hModtxtDCorta') == 'S'){
		accion('frmFormulario.txtDCorta', '.disabled=true');
	}

	if(get('frmFormulario.hModrbIdLote') == 'S'){	
		 document.all.rbIdLote[0].disabled = true;
		 document.all.rbIdLote[1].disabled = true;
	}

	if(get('frmFormulario.hModcbIndicadorPS') == 'S'){
		accion('frmFormulario.cbIdPS', '.disabled=true');
	}

	if(get('frmFormulario.hModcbM') == 'S'){
		accion('frmFormulario.cbM', '.disabled=true');
	}

	if(get('frmFormulario.hModcbUN') == 'S'){
		accion('frmFormulario.cbUN', '.disabled=true');
	}

	if(get('frmFormulario.hModcbNeg') == 'S'){
		accion('frmFormulario.cbNeg', '.disabled=true');
	}

	if(get('frmFormulario.hModcbGenr') == 'S'){
		accion('frmFormulario.cbGenr', '.disabled=true');
	}

	if(get('frmFormulario.hModcbSuperGeg') == 'S'){
		accion('frmFormulario.cbSuperGeg', '.disabled=true');
	}

	if(get('frmFormulario.hModtxtJ1') == 'S'){
		accion('frmFormulario.txtJ1', '.disabled=true');
	}

	if(get('frmFormulario.hModtxtJ2') == 'S'){
		accion('frmFormulario.txtJ2', '.disabled=true');
	}

	if(get('frmFormulario.hModtxtJ3') == 'S'){
		accion('frmFormulario.txtJ3', '.disabled=true');
	}

	if(get('frmFormulario.hModcbLin') == 'S'){
		accion('frmFormulario.cbLin', '.disabled=true');
	}

	if(get('frmFormulario.hModtxtA1') == 'S'){
		accion('frmFormulario.txtA1', '.disabled=true');
	}

	if(get('frmFormulario.hModtxtA2') == 'S'){
		accion('frmFormulario.txtA2', '.disabled=true');
	}

	if(get('frmFormulario.hModtxtA3') == 'S'){
		accion('frmFormulario.txtA3', '.disabled=true');
	}

	if(get('frmFormulario.hModtxtDA') == 'S'){
		accion('frmFormulario.txtDA', '.disabled=true');
	}

	if(get('frmFormulario.hModtxtDL') == 'S'){
		accion('frmFormulario.txtDL', '.disabled=true');
	}

	if(get('frmFormulario.hModtxtDAL') == 'S'){
		accion('frmFormulario.txtDAL', '.disabled=true');
	}

	if(get('frmFormulario.hModcbUNMedidaDimensiones') == 'S'){
		accion('frmFormulario.cbUNMedidaDimensiones', '.disabled=true');
	}

	if(get('frmFormulario.hModtxtVoluA') == 'S'){
		accion('frmFormulario.txtVoluA', '.disabled=true');
	}

	if(get('frmFormulario.hModcbUDV') == 'S'){
		accion('frmFormulario.cbUDV', '.disabled=true');
	}

	if(get('frmFormulario.hModtxtPeso') == 'S'){
		accion('frmFormulario.txtPeso', '.disabled=true');
	}

	if(get('frmFormulario.hModcbUDP') == 'S'){
		accion('frmFormulario.cbUDP', '.disabled=true');
	}

	if(get('frmFormulario.hModtxtUnidDentroPedido') == 'S'){
		accion('frmFormulario.txtUnidDentroPedido', '.disabled=true');
	}

	if(get('frmFormulario.hModtxtUDC') == 'S'){
		accion('frmFormulario.txtUDC', '.disabled=true');
	}

	if(get('frmFormulario.hModtxtCosteEstandar') == 'S'){
		accion('frmFormulario.txtCosteEstandar', '.disabled=true');
	}
   
	if(get('frmFormulario.hModtxtPPos') == 'S'){
		accion('frmFormulario.txtPPos', '.disabled=true');
	}

	if(get('frmFormulario.hModcbSituac') == 'S'){
		accion('frmFormulario.cbSituac', '.disabled=true');
	}

	if(get('frmFormulario.hModcbSProd') == 'S'){
		accion('frmFormulario.cbSProd', '.disabled=true');
	}

	if(get('frmFormulario.hModcbSCaja') == 'S'){
		accion('frmFormulario.cbSCaja', '.disabled=true');
	}

	if(get('frmFormulario.hModcbFormaPago') == 'S'){
		accion('frmFormulario.cbFormaPago', '.disabled=true');
	}

	if(get('frmFormulario.hModtxtCodImpuesto') == 'S'){
		accion('frmFormulario.txtCodImpuesto', '.disabled=true');
	}

	if(get('frmFormulario.hModtxtPrecioCatalogo') == 'S'){
		accion('frmFormulario.txtPrecioCatalogo', '.disabled=true');
	}

	if(get('frmFormulario.hModtxtPrecioContable') == 'S'){
		accion('frmFormulario.txtPrecioContable', '.disabled=true');
	}

	if(get('frmFormulario.hModtxtGrupoArticulos') == 'S'){
		accion('frmFormulario.txtGrupoArticulos', '.disabled=true');
	}
}

function setTabFocus( campo ){
	document.selection.empty();

	if( campo == 'txtAnt' ){
		if( txtDSAP.disabled == false ){
			focaliza('frmFormulario.txtDSAP');
		}else{
			setTabFocus('txtDSAP');
		}
	}else if( campo == 'txtDSAP' ){
		if( txtDCorta.disabled == false ){
			focaliza('frmFormulario.txtDCorta');
		}else{
			setTabFocus('txtDCorta');
		}
	}else if( campo == 'txtDCorta' ){
		if( document.all.rbIdLote[0].disabled == false ){
			focaliza('frmFormulario.rbIdLote');
		}else{
			setTabFocus('rbIdLote');
		}
	}else if( campo == 'rbIdLote' ){
		if( cbIdPS.disabled == false ){
			focaliza('frmFormulario.cbIdPS');
		}else{
			setTabFocus('cbIdPS');
		}
	}else if( campo == 'cbIdPS' ){
		if( cbM.disabled == false ){
			focaliza('frmFormulario.cbM');
		}else{
			setTabFocus('cbM');
		}
	}else if( campo == 'cbM' ){
		if( cbUN.disabled == false ){
			focaliza('frmFormulario.cbUN');
		}else{
			setTabFocus('cbUN');
		}
	}else if( campo == 'cbUN' ){
		if( cbNeg.disabled == false ){
			focaliza('frmFormulario.cbNeg');
		}else{
			setTabFocus('cbNeg');
		}
	}else if( campo == 'cbNeg' ){
		if( cbGenr.disabled == false ){
			focaliza('frmFormulario.cbGenr');
		}else{
			setTabFocus('cbGenr');
		}
	}else if( campo == 'cbGenr' ){
		if( cbSuperGeg.disabled == false ){
			focaliza('frmFormulario.cbSuperGeg');
		}else{
			setTabFocus('cbSuperGeg');
		}
	}else if( campo == 'cbSuperGeg' ){
		if( txtJ1.disabled == false ){
			focaliza('frmFormulario.txtJ1');
		}else{
			setTabFocus('txtJ1');
		}
	}else if( campo == 'txtJ1' ){
		if( txtJ2.disabled == false ){
			focaliza('frmFormulario.txtJ2');
		}else{
			setTabFocus('txtJ2');
		}
	}else if( campo == 'txtJ2' ){
		if( txtJ3.disabled == false ){
			focaliza('frmFormulario.txtJ3');
		}else{
			setTabFocus('txtJ3');
		}
	}else if( campo == 'txtJ3' ){
		if( cbLin.disabled == false ){
			focaliza('frmFormulario.cbLin');
		}else{
			setTabFocus('cbLin');
		}
	}else if( campo == 'cbLin' ){
		if( txtA1.disabled == false ){
			focaliza('frmFormulario.txtA1');
		}else{
			setTabFocus('txtA1');
		}
	}else if( campo == 'txtA1' ){
		if( txtA2.disabled == false ){
			focaliza('frmFormulario.txtA2');
		}else{
			setTabFocus('txtA2');
		}
	}else if( campo == 'txtA2' ){
		if( txtA3.disabled == false ){
			focaliza('frmFormulario.txtA3');
		}else{
			setTabFocus('txtA3');
		}
	}else if( campo == 'txtA3' ){
		if( txtDA.disabled == false ){
			focaliza('frmFormulario.txtDA');
		}else{
			setTabFocus('txtDA');
		}
	}else if( campo == 'txtDA' ){
		if( txtDL.disabled == false ){
			focaliza('frmFormulario.txtDL');
		}else{
			setTabFocus('txtDL');
		}
	}else if( campo == 'txtDL' ){
		if( txtDAL.disabled == false ){
			focaliza('frmFormulario.txtDAL');
		}else{
			setTabFocus('txtDAL');
		}
	}else if( campo == 'txtDAL' ){
		if( cbUNMedidaDimensiones.disabled == false ){
			focaliza('frmFormulario.cbUNMedidaDimensiones');
		}else{
			setTabFocus('cbUNMedidaDimensiones');
		}
	}else if( campo == 'cbUNMedidaDimensiones' ){
		if( txtVoluA.disabled == false ){
			focaliza('frmFormulario.txtVoluA');
		}else{
			setTabFocus('txtVoluA');
		}
	}else if( campo == 'txtVoluA' ){
		if( cbUDV.disabled == false ){
			focaliza('frmFormulario.cbUDV');
		}else{
			setTabFocus('cbUDV');
		}
	}else if( campo == 'cbUDV' ){
		if( txtPeso.disabled == false ){
			focaliza('frmFormulario.txtPeso');
		}else{
			setTabFocus('txtPeso');
		}
	}else if( campo == 'txtPeso' ){
		if( cbUDP.disabled == false ){
			focaliza('frmFormulario.cbUDP');
		}else{
			setTabFocus('cbUDP');
		}
	}else if( campo == 'cbUDP' ){
		if( txtUnidDentroPedido.disabled == false ){
			focaliza('frmFormulario.txtUnidDentroPedido');
		}else{
			setTabFocus('txtUnidDentroPedido');
		}
	}else if( campo == 'txtUnidDentroPedido' ){
		if( txtUDC.disabled == false ){
			focaliza('frmFormulario.txtUDC');
		}else{
			setTabFocus('txtUDC');
		}
	}else if( campo == 'txtUDC' ){
		if( txtCosteEstandar.disabled == false ){
			focaliza('frmFormulario.txtCosteEstandar');
		}else{
			setTabFocus('txtCosteEstandar');
		}
	}else if( campo == 'txtCosteEstandar' ){
		if( txtPPos.disabled == false ){
			focaliza('frmFormulario.txtPPos');
		}else{
			setTabFocus('txtPPos');
		}
	}else if( campo == 'txtPPos' ){
		if( cbSituac.disabled == false ){
			focaliza('frmFormulario.cbSituac');
		}else{
			setTabFocus('cbSituac');
		}
	}else if( campo == 'cbSituac' ){
		if( cbSProd.disabled == false ){
			focaliza('frmFormulario.cbSProd');
		}else{
			setTabFocus('cbSProd');
		}
	}else if( campo == 'cbSProd' ){
		if( cbSCaja.disabled == false ){
			focaliza('frmFormulario.cbSCaja');
		}else{
			setTabFocus('cbSCaja');
		}
	}else if( campo == 'cbSCaja' ){
		if( cbFormaPago.disabled == false ){
			focaliza('frmFormulario.cbFormaPago');
		}else{
			setTabFocus('cbFormaPago');
		}
	}else if( campo == 'cbFormaPago' ){
		if( txtCodImpuesto.disabled == false ){
			focaliza('frmFormulario.txtCodImpuesto');
		}else{
			setTabFocus('txtCodImpuesto');
		}
	}else if( campo == 'txtCodImpuesto' ){
		if( txtPrecioCatalogo.disabled == false ){
			focaliza('frmFormulario.txtPrecioCatalogo');
		}else{
			setTabFocus('txtPrecioCatalogo');
		}
	}else if( campo == 'txtPrecioCatalogo' ){
		if( txtPrecioContable.disabled == false ){
			focaliza('frmFormulario.txtPrecioContable');
		}else{
			setTabFocus('txtPrecioContable');
		}
	}else if( campo == 'txtPrecioContable' ){
		if( txtGrupoArticulos.disabled == false ){
			focaliza('frmFormulario.txtGrupoArticulos');
		}else{
			setTabFocus('txtGrupoArticulos');
		}
	}else if( campo == 'txtGrupoArticulos' ){ // /* [1]
		if( txtAnt.disabled == false ){
			focaliza('frmFormulario.cbProgFidelizacion');
		}else{
			setTabFocus('cbProgFidelizacion');
		}
	}else if( campo == 'cbProgFidelizacion' ){
		if( txtAnt.disabled == false ){
			focaliza('frmFormulario.txtAnt');
		}else{
			setTabFocus('txtAnt');
		}
	} // */ [1]
}


function hayCampoHabilitado(campo){
    if( campo == '' ){
		if( txtAnt.disabled == false ){
			return 1;
		}else{
			return hayCampoHabilitado('txtAnt');
		}
	}else if( campo == 'txtAnt' ){
		if( txtDSAP.disabled == false ){
			return 1;
		}else{
			return hayCampoHabilitado('txtDSAP');
		}
	}else if( campo == 'txtDSAP' ){
		if( txtDCorta.disabled == false ){
			return 1;
		}else{
			return hayCampoHabilitado('txtDCorta');
		}
	}else if( campo == 'txtDCorta' ){
		if( document.all.rbIdLote[0].disabled == false ){
			return 1;
		}else{
			return hayCampoHabilitado('rbIdLote');
		}
	}else if( campo == 'rbIdLote' ){
		if( cbIdPS.disabled == false ){
			return 1;
		}else{
			return hayCampoHabilitado('cbIdPS');
		}
	}else if( campo == 'cbIdPS' ){
		if( cbM.disabled == false ){
			return 1;
		}else{
			return hayCampoHabilitado('cbM');
		}
	}else if( campo == 'cbM' ){
		if( cbUN.disabled == false ){
			return 1;
		}else{
			return hayCampoHabilitado('cbUN');
		}
	}else if( campo == 'cbUN' ){
		if( cbNeg.disabled == false ){
			return 1;
		}else{
			return hayCampoHabilitado('cbNeg');
		}
	}else if( campo == 'cbNeg' ){
		if( cbGenr.disabled == false ){
			return 1;
		}else{
			return hayCampoHabilitado('cbGenr');
		}
	}else if( campo == 'cbGenr' ){
		if( cbSuperGeg.disabled == false ){
			return 1;
		}else{
			return hayCampoHabilitado('cbSuperGeg');
		}
	}else if( campo == 'cbSuperGeg' ){
		if( txtJ1.disabled == false ){
			return 1;
		}else{
			return hayCampoHabilitado('txtJ1');
		}
	}else if( campo == 'txtJ1' ){
		if( txtJ2.disabled == false ){
			return 1;
		}else{
			return hayCampoHabilitado('txtJ2');
		}
	}else if( campo == 'txtJ2' ){
		if( txtJ3.disabled == false ){
			return 1;
		}else{
			return hayCampoHabilitado('txtJ3');
		}
	}else if( campo == 'txtJ3' ){
		if( cbLin.disabled == false ){
			return 1;
		}else{
			return hayCampoHabilitado('cbLin');
		}
	}else if( campo == 'cbLin' ){
		if( txtA1.disabled == false ){
			return 1;
		}else{
			return hayCampoHabilitado('txtA1');
		}
	}else if( campo == 'txtA1' ){
		if( txtA2.disabled == false ){
			return 1;
		}else{
			return hayCampoHabilitado('txtA2');
		}
	}else if( campo == 'txtA2' ){
		if( txtA3.disabled == false ){
			return 1;
		}else{
			return hayCampoHabilitado('txtA3');
		}
	}else if( campo == 'txtA3' ){
		if( txtDA.disabled == false ){
			return 1;
		}else{
			return hayCampoHabilitado('txtDA');
		}
	}else if( campo == 'txtDA' ){
		if( txtDL.disabled == false ){
			return 1;
		}else{
			return hayCampoHabilitado('txtDL');
		}
	}else if( campo == 'txtDL' ){
		if( txtDAL.disabled == false ){
			return 1;
		}else{
			return hayCampoHabilitado('txtDAL');
		}
	}else if( campo == 'txtDAL' ){
		if( cbUNMedidaDimensiones.disabled == false ){
			return 1;
		}else{
			return hayCampoHabilitado('cbUNMedidaDimensiones');
		}
	}else if( campo == 'cbUNMedidaDimensiones' ){
		if( txtVoluA.disabled == false ){
			return 1;
		}else{
			return hayCampoHabilitado('txtVoluA');
		}
	}else if( campo == 'txtVoluA' ){
		if( cbUDV.disabled == false ){
			return 1;
		}else{
			return hayCampoHabilitado('cbUDV');
		}
	}else if( campo == 'cbUDV' ){
		if( txtPeso.disabled == false ){
			return 1;
		}else{
			return hayCampoHabilitado('txtPeso');
		}
	}else if( campo == 'txtPeso' ){
		if( cbUDP.disabled == false ){
			return 1;
		}else{
			return hayCampoHabilitado('cbUDP');
		}
	}else if( campo == 'cbUDP' ){
		if( txtUnidDentroPedido.disabled == false ){
			return 1;
		}else{
			return hayCampoHabilitado('txtUnidDentroPedido');
		}
	}else if( campo == 'txtUnidDentroPedido' ){
		if( txtUDC.disabled == false ){
			return 1;
		}else{
			return hayCampoHabilitado('txtUDC');
		}
	}else if( campo == 'txtUDC' ){
		if( txtCosteEstandar.disabled == false ){
			return 1;
		}else{
			return hayCampoHabilitado('txtCosteEstandar');
		}
	}else if( campo == 'txtCosteEstandar' ){
		if( txtPPos.disabled == false ){
			return 1;
		}else{
			return hayCampoHabilitado('txtPPos');
		}
	}else if( campo == 'txtPPos' ){
		if( cbSituac.disabled == false ){
			return 1;
		}else{
			return hayCampoHabilitado('cbSituac');
		}
	}else if( campo == 'cbSituac' ){
		if( cbSProd.disabled == false ){
			return 1;
		}else{
			return hayCampoHabilitado('cbSProd');
		}
	}else if( campo == 'cbSProd' ){
		if( cbSCaja.disabled == false ){
			return 1;
		}else{
			return hayCampoHabilitado('cbSCaja');
		}
	}else if( campo == 'cbSCaja' ){
		if( cbFormaPago.disabled == false ){
			return 1;
		}else{
			return hayCampoHabilitado('cbFormaPago');
		}
	}else if( campo == 'cbFormaPago' ){
		if( txtCodImpuesto.disabled == false ){
			return 1;
		}else{
			return hayCampoHabilitado('txtCodImpuesto');
		}
	}else if( campo == 'txtCodImpuesto' ){
		if( txtPrecioCatalogo.disabled == false ){
			return 1;
		}else{
			return hayCampoHabilitado('txtPrecioCatalogo');
		}
	}else if( campo == 'txtPrecioCatalogo' ){
		if( txtPrecioContable.disabled == false ){
			return 1;
		}else{
			return hayCampoHabilitado('txtPrecioContable');
		}
	}else if( campo == 'txtPrecioContable' ){
		if( txtGrupoArticulos.disabled == false ){
			return 1;
		}else{
			return hayCampoHabilitado('txtGrupoArticulos');
		}
	}else if( campo == 'txtGrupoArticulos' ){
		if( txtAnt.disabled == false ){
			return 1;
		}else{
			return 0;
		}
	}
}

/*
	pperanzola - 07/10/2005 - [1] cambios segun SICC-DMCO-PRE_MAE_INT-GCC-001
*/
function setSHTabFocus( campo ){
	if( campo == 'txtAnt' ){
		if( txtGrupoArticulos.disabled == false ){ ///* [1]
			focaliza('frmFormulario.cbProgFidelizacion'); 
		}else{
			setTabFocus('cbProgFidelizacion'); //*/ [1]
		}
	}else if( campo == 'txtDSAP' ){
		if( txtAnt.disabled == false ){
			focaliza('frmFormulario.txtAnt');
		}else{
			setTabFocus('txtAnt');
		}
	}else if( campo == 'txtDCorta' ){
		if( txtDSAP.disabled == false ){
			focaliza('frmFormulario.txtDSAP');
		}else{
			setTabFocus('txtDSAP');
		}
	}else if( campo == 'rbIdLote' ){
		if( txtDCorta.disabled == false ){
			focaliza('frmFormulario.txtDCorta');
		}else{
			setTabFocus('txtDCorta');
		}
	}else if( campo == 'cbIdPS' ){
		if( document.all.rbIdLote[0].disabled == false ){
			focaliza('frmFormulario.rbIdLote');
		}else{
			setTabFocus('rbIdLote');
		}
	}else if( campo == 'cbM' ){
		if( cbIdPS.disabled == false ){
			focaliza('frmFormulario.cbIdPS');
		}else{
			setTabFocus('cbIdPS');
		}
	}else if( campo == 'cbUN' ){
		if( cbM.disabled == false ){
			focaliza('frmFormulario.cbM');
		}else{
			setTabFocus('cbM');
		}
	}else if( campo == 'cbNeg' ){
		if( cbUN.disabled == false ){
			focaliza('frmFormulario.cbUN');
		}else{
			setTabFocus('cbUN');
		}
	}else if( campo == 'cbGenr' ){
		if( cbNeg.disabled == false ){
			focaliza('frmFormulario.cbNeg');
		}else{
			setTabFocus('cbNeg');
		}
	}else if( campo == 'cbSuperGeg' ){
		if( cbGenr.disabled == false ){
			focaliza('frmFormulario.cbGenr');
		}else{
			setTabFocus('cbGenr');
		}
	}else if( campo == 'txtJ1' ){
		if( cbSuperGeg.disabled == false ){
			focaliza('frmFormulario.cbSuperGeg');
		}else{
			setTabFocus('cbSuperGeg');
		}
	}else if( campo == 'txtJ2' ){
		if( txtJ1.disabled == false ){
			focaliza('frmFormulario.txtJ1');
		}else{
			setTabFocus('txtJ1');
		}
	}else if( campo == 'txtJ3' ){
		if( txtJ2.disabled == false ){
			focaliza('frmFormulario.txtJ2');
		}else{
			setTabFocus('txtJ2');
		}
	}else if( campo == 'cbLin' ){
		if( txtJ3.disabled == false ){
			focaliza('frmFormulario.txtJ3');
		}else{
			setTabFocus('txtJ3');
		}
	}else if( campo == 'txtA1' ){
		if( cbLin.disabled == false ){
			focaliza('frmFormulario.cbLin');
		}else{
			setTabFocus('cbLin');
		}
	}else if( campo == 'txtA2' ){
		if( txtA1.disabled == false ){
			focaliza('frmFormulario.txtA1');
		}else{
			setTabFocus('txtA1');
		}
	}else if( campo == 'txtA3' ){
		if( txtA2.disabled == false ){
			focaliza('frmFormulario.txtA2');
		}else{
			setTabFocus('txtA2');
		}
	}else if( campo == 'txtDA' ){
		if( txtA3.disabled == false ){
			focaliza('frmFormulario.txtA3');
		}else{
			setTabFocus('txtA3');
		}
	}else if( campo == 'txtDL' ){
		if( txtDA.disabled == false ){
			focaliza('frmFormulario.txtDA');
		}else{
			setTabFocus('txtDA');
		}
	}else if( campo == 'txtDAL' ){
		if( txtDL.disabled == false ){
			focaliza('frmFormulario.txtDL');
		}else{
			setTabFocus('txtDL');
		}
	}else if( campo == 'cbUNMedidaDimensiones' ){
		if( txtDAL.disabled == false ){
			focaliza('frmFormulario.txtDAL');
		}else{
			setTabFocus('txtDAL');
		}
	}else if( campo == 'txtVoluA' ){
		if( cbUNMedidaDimensiones.disabled == false ){
			focaliza('frmFormulario.cbUNMedidaDimensiones');
		}else{
			setTabFocus('cbUNMedidaDimensiones');
		}
	}else if( campo == 'cbUDV' ){
		if( txtVoluA.disabled == false ){
			focaliza('frmFormulario.txtVoluA');
		}else{
			setTabFocus('txtVoluA');
		}
	}else if( campo == 'txtPeso' ){
		if( cbUDV.disabled == false ){
			focaliza('frmFormulario.cbUDV');
		}else{
			setTabFocus('cbUDV');
		}
	}else if( campo == 'cbUDP' ){
		if( txtPeso.disabled == false ){
			focaliza('frmFormulario.txtPeso');
		}else{
			setTabFocus('txtPeso');
		}
	}else if( campo == 'txtUnidDentroPedido' ){
		if( cbUDP.disabled == false ){
			focaliza('frmFormulario.cbUDP');
		}else{
			setTabFocus('cbUDP');
		}
	}else if( campo == 'txtUDC' ){
		if( txtUnidDentroPedido.disabled == false ){
			focaliza('frmFormulario.txtUnidDentroPedido');
		}else{
			setTabFocus('txtUnidDentroPedido');
		}
	}else if( campo == 'txtCosteEstandar' ){
		if( txtUDC.disabled == false ){
			focaliza('frmFormulario.txtUDC');
		}else{
			setTabFocus('txtUDC');
		}
	}else if( campo == 'txtPPos' ){
		if( txtCosteEstandar.disabled == false ){
			focaliza('frmFormulario.txtCosteEstandar');
		}else{
			setTabFocus('txtCosteEstandar');
		}
	}else if( campo == 'cbSituac' ){
		if( txtPPos.disabled == false ){
			focaliza('frmFormulario.txtPPos');
		}else{
			setTabFocus('txtPPos');
		}
	}else if( campo == 'cbSProd' ){
		if( cbSituac.disabled == false ){
			focaliza('frmFormulario.cbSituac');
		}else{
			setTabFocus('cbSituac');
		}
	}else if( campo == 'cbSCaja' ){
		if( cbSProd.disabled == false ){
			focaliza('frmFormulario.cbSProd');
		}else{
			setTabFocus('cbSProd');
		}
	}else if( campo == 'cbFormaPago' ){
		if( cbSCaja.disabled == false ){
			focaliza('frmFormulario.cbSCaja');
		}else{
			setTabFocus('cbSCaja');
		}
	}else if( campo == 'txtCodImpuesto' ){
		if( cbFormaPago.disabled == false ){
			focaliza('frmFormulario.cbFormaPago');
		}else{
			setTabFocus('cbFormaPago');
		}
	}else if( campo == 'txtPrecioCatalogo' ){
		if( txtCodImpuesto.disabled == false ){
			focaliza('frmFormulario.txtCodImpuesto');
		}else{
			setTabFocus('txtCodImpuesto');
		}
	}else if( campo == 'txtPrecioContable' ){
		if( txtPrecioCatalogo.disabled == false ){
			focaliza('frmFormulario.txtPrecioCatalogo');
		}else{
			setTabFocus('txtPrecioCatalogo');
		}
	}else if( campo == 'txtGrupoArticulos' ){
		if( txtPrecioContable.disabled == false ){
			focaliza('frmFormulario.txtPrecioContable');
		}else{
			setTabFocus('txtPrecioContable');
		}
	}else if( campo == 'cbProgFidelizacion' ){ // /*[1]
		if( cbProgFidelizacion.disabled == false ){
			focaliza('frmFormulario.txtGrupoArticulos');
		}else{
			setTabFocus('txtGrupoArticulos');// */[1]
		}
	}
}
