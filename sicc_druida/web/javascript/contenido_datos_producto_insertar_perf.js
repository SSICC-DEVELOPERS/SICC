// variables globales de la clase
var objTiposOfertas = null;
var objVariantes = null;
var posicion;
// funciones privadas

// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// Para tenerlo en un solo lado 
function getFirstField(){
	return "frmContenido.txtTextoBreve";
}
	
// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function getLastField(){
	return "frmContenido.cbCicloVida";
}

//-----------Agregado by enozigli, 25/10/2005, club priviledges-------------------------------------- 
function onChangeProgFide(){
	var oidProgFide = get('frmContenido.cbProgramaFidelizacion','V');
	var objVaria = document.getElementById('cbVariante');
	if (oidProgFide==null||oidProgFide==''){
		set('frmContenido.ocbVariante','');
		var array = new Array();
		array[0]=get("frmContenido.ocbVariante");
		set('frmContenido.cbVariante',array);
		objVaria.disabled = true;
	} else {
		objVaria.disabled = false;
	}
	onChangeVariante();
}
//-----------Agregado by enozigli, 25/10/2005, club priviledges-------------------------------------- 
function onChangeVariante(){
	var oidVariante = get('frmContenido.cbVariante','V');
	if (objVariantes==null)	{
		objVariantes = new Object();
		var lstVariantes = get('frmContenido.hlstVariantes');
		var arrayVariantes = lstVariantes.split("|");
		var arrayRegVariantes;
		for(var i=0;i<arrayVariantes.length;i++) {
			arrayRegVariantes = arrayVariantes[i].split("&");
			objVariantes[arrayRegVariantes[0]] = arrayRegVariantes;
		}		
	}
	
	//OID_VARI(0),IND_PUNT(1)
	if (objVariantes[oidVariante][1]=='1'){
		accion('frmContenido.txtPuntoFijo','.disabled=false');
		set("frmContenido.obligaPuntoFijo","true");
	} else {
	  set('frmContenido.txtPuntoFijo','');
	  accion('frmContenido.txtPuntoFijo','.disabled=true');
	  set("frmContenido.obligaPuntoFijo","false");
	}
} 

// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function onChangeTipoOferta(){

	var oidTipoOferta = get('frmContenido.cbTipoOferta','V');
	if (objTiposOfertas==null)	{
		objTiposOfertas = new Object();
		var lstTiposOferta = get('frmContenido.hlstTiposOferta');
		var arrayTiposOferta = lstTiposOferta.split("|");
		var arrayRegTipoOferta;
		for(var i=0;i<arrayTiposOferta.length;i++) {
			arrayRegTipoOferta = arrayTiposOferta[i].split("&");
			objTiposOfertas[arrayRegTipoOferta[0]] = arrayRegTipoOferta;
		}		
	}
	
	//Orden:
	//OID_TIPO_OFER(0), IND_COMI(1), IND_PUNT(2), IND_ESTA(3), IND_MONT_MINI(4), IND_APOR_MONT_ESCA(5)
	set('frmContenido.comis',objTiposOfertas[oidTipoOferta][1]);
	set('frmContenido.punta',objTiposOfertas[oidTipoOferta][2]);	
	set('frmContenido.estad',objTiposOfertas[oidTipoOferta][3]);	
	set('frmContenido.mmini',objTiposOfertas[oidTipoOferta][4]);	
	set('frmContenido.amesc',objTiposOfertas[oidTipoOferta][5]);	
				
	cambiaSINO();
} 
// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function accionCargarRangosPrecios() {

		var parametros = new Object();     
		parametros.dtoOferta = dtoOferta;
		parametros.posicion = posicion;
		parametros.oidDetalle = dtoOferta.detalleOferta[posicion].oidDetalleOferta;
		parametros.oidSAP = dtoOferta.detalleOferta[posicion].oidSAP;
		parametros.precioPosicionamiento =dtoOferta.detalleOferta[posicion].precioPosicionamiento;//formatear
		
		var an = screen.availWidth;
		var al = screen.availHeight;

		var res = mostrarModalSICC("LPDatosProductoPerf", "precios", parametros, an, al);

		if (dtoOferta.detalleOferta[posicion].rangosPrecios!=null&&dtoOferta.detalleOferta[posicion].rangosPrecios.length!=null) {
			var lon = new Number(dtoOferta.detalleOferta[posicion].rangosPrecios.length);
			var arrElim = new Array();
			for (var i=0;i<lon;i++){
				if (dtoOferta.detalleOferta[posicion].rangosPrecios[i].modificado=='nuevo') {
					dtoOferta.detalleOferta[posicion].rangosPrecios = miSplice(dtoOferta.detalleOferta[posicion].rangosPrecios,i);
					i--;
					lon--;
				}
			}
		}			
		goToFirstField();
}
// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function onLoadPag()   {
		configurarMenuSecundario("frmContenido");	
		
		parametros = window.dialogArguments.parametros;
		dtoOferta = window.dialogArguments.parametros.dtoOferta;

		eval (ON_RSZ);  

		var an = screen.availWidth;
		var al = screen.availHeight;

		window.dialogWidth =an;
		window.dialogHeight =al;


		posicion = obtenerPosicion();
		cargarDetalle(posicion);
		goToFirstField();
		accion('frmContenido.txtCodProducto','.disabled=true');
}

function obtenerPosicion(){
	var tam = dtoOferta.detalleOferta.length;
	var p;

	// busco el primero no modificado
	for(var i=0;i<tam;i++) {
		if (dtoOferta.detalleOferta[i].modificado=='no'||dtoOferta.detalleOferta[i].modificado=='nuevo') {
			p = i;
			break;
		}
	}
	if (p==null){
		return false;
	}
	return p;
}
// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function cargarDetalle(pos){
	
	var precioPosicionamiento = dtoOferta.detalleOferta[pos].precioPosicionamiento;//formatear
	if (precioPosicionamiento!=null) {
		set('frmContenido.txtPrecioPos',numeroAsFormatoSICC(precioPosicionamiento));
		set('frmContenido.precioPosX',numeroAsFormatoSICC(precioPosicionamiento));
	} else {
		set('frmContenido.txtPrecioPos','');
		set('frmContenido.precioPosX','');
	}
	var costeEstandar = dtoOferta.detalleOferta[pos].costeEstandar;//formatear
	if (costeEstandar!=null) {
		set('frmContenido.txtCosteEstandar',numeroAsFormatoSICC(costeEstandar));
	} else {
		set('frmContenido.txtCosteEstandar','');
	}
	var descripcionCatalogo = dtoOferta.detalleOferta[pos].descripcionCatalogo;
	if (descripcionCatalogo!=null) {
		set('frmContenido.txtCatalogo',descripcionCatalogo);
	} else {
		set('frmContenido.txtCatalogo','');
	}
	var centro = dtoOferta.detalleOferta[pos].centro;
	if (centro!=null) {
		set('frmContenido.txtCentro',centro);
	} else {
		set('frmContenido.txtCentro','');
	}
	var codigoSAP = dtoOferta.detalleOferta[pos].codigoSAP;
	if (codigoSAP!=null) {
		set('frmContenido.txtCodProducto',codigoSAP);
	} else {
		set('frmContenido.txtCodProducto','');
	}
	var descripcion = dtoOferta.detalleOferta[pos].descripcion;
	if (descripcion!=null) {
		set('frmContenido.txtTextoBreve',descripcion);
	} else {
		set('frmContenido.txtTextoBreve','');
	}
	var unidadesEstimadas = dtoOferta.detalleOferta[pos].unidadesEstimadas;
	if (unidadesEstimadas!=null) {
		set('frmContenido.txtUniEstimadas',numeroAsFormatoSICC(unidadesEstimadas,'S'));
	} else {
		set('frmContenido.txtUniEstimadas','');
	}
	var factorRepeticion = dtoOferta.detalleOferta[pos].factorRepeticion;
	if (factorRepeticion!=null) {
		set('frmContenido.txtFactorRepeticion',factorRepeticion);
	} else {
		set('frmContenido.txtFactorRepeticion','');
	}
	var precioCatalogo = dtoOferta.detalleOferta[pos].precioCatalogo;//formatear
	if (precioCatalogo!=null) {
		set('frmContenido.txtPrecioCat',numeroAsFormatoSICC(precioCatalogo));
	} else {
		set('frmContenido.txtPrecioCat','');
	}
	var unidadesEstimadas = dtoOferta.detalleOferta[pos].unidadesEstimadas;//formatear
	if (unidadesEstimadas!=null) {
		set('frmContenido.txtUniEstimadas2',numeroAsFormatoSICC(unidadesEstimadas,'S'));
	} else {
		set('frmContenido.txtUniEstimadas2','');
	}
	var ventaNetaEstimada = dtoOferta.detalleOferta[pos].ventaNetaEstimada;//formatear
	if (ventaNetaEstimada!=null) {
		set('frmContenido.txtVentaNetaEstimada',numeroAsFormatoSICC(ventaNetaEstimada));
	} else {
		set('frmContenido.txtVentaNetaEstimada','');
	}
	var paginaCatalogo = dtoOferta.detalleOferta[pos].paginaCatalogo;
	if (paginaCatalogo!=null) {
		set('frmContenido.txtNPagCatalogo',paginaCatalogo);
	} else {
		set('frmContenido.txtNPagCatalogo','');
	}	
	var posicionPagina = dtoOferta.detalleOferta[pos].posicionPagina;
	if (posicionPagina!=null) {
		set('frmContenido.txtPosPagina',posicionPagina);
	} else {
		set('frmContenido.txtPosPagina','');
	}

	if((get('frmContenido.multiseleccion')!=null)&&
	   (get('frmContenido.multiseleccion')!='')&&
  	   (get('frmContenido.multiseleccion')=='true')&&
	   (get('frmContenido.hTipoEstrategia')==get('frmContenido.hCompuestaFija'))){
		set('frmContenido.enabledigitable','false');
		set('frmContenido.digitable','N');
	} else {
		if (get('frmContenido.hdigitable')!=null&&get('frmContenido.hdigitable')!='') {
			set('frmContenido.digitable',get('frmContenido.hdigitable'));
		} else {
			set('frmContenido.digitable','N');
		}
		if (get('frmContenido.henabledigitable')!=null&&get('frmContenido.henabledigitable')!=''&&get('frmContenido.henabledigitable')=='true') {
			set('frmContenido.enabledigitable','true');
		} else {
			set('frmContenido.enabledigitable','false');
		}
	}

	//*1 Seteo de digitable e imprimible con valores de BD para caso de insercion.
	if((get('frmContenido.multiseleccion')!=null)&&
	   (get('frmContenido.multiseleccion')!='')&&
  	   (get('frmContenido.multiseleccion')=='true')&&
	   (get('frmContenido.hTipoEstrategia')==get('frmContenido.hCompuestaFija'))){
		set('frmContenido.enableimprimible','false');
		set('frmContenido.imprimible','N');
	} else {
		if (get('frmContenido.himprimible')!=null&&get('frmContenido.himprimible')!='') {
			set('frmContenido.imprimible',get('frmContenido.hdigitable'));
		} else {
			set('frmContenido.imprimible','N');
		}
		if (get('frmContenido.henableimprimible')!=null&&get('frmContenido.henableimprimible')!=''&&get('frmContenido.henableimprimible')=='true') {
			set('frmContenido.enableimprimible','true');
		} else {
			set('frmContenido.enableimprimible','false');
		}
	}

	var digitable = dtoOferta.detalleOferta[pos].digitable;
	if (digitable!=null) {
		if (digitable=='true') {
			set('frmContenido.digitable','S');
		} else {
			set('frmContenido.digitable','N');
		}
	} else {
		//En este caso no va nada para no pisar los valores que seteo *1
	}

	var imprimible = dtoOferta.detalleOferta[pos].impresionGP;
	if (imprimible!=null) {
		if (imprimible=='true') {
			set('frmContenido.imprimible','S');
		} else {
			set('frmContenido.imprimible','N');
		}
	} else {
		//En este caso no va nada para no pisar los valores que seteo *1
	}

	var puntajeFijo = dtoOferta.detalleOferta[pos].puntajeFijo;
	if (puntajeFijo!=null) {
		set('frmContenido.txtPuntoFijo',puntajeFijo);
	} else {
		set('frmContenido.txtPuntoFijo','');
	}
	var oidTipoOferta = dtoOferta.detalleOferta[pos].oidTipoOferta;
	if (oidTipoOferta!=null) {
		set('frmContenido.ocbTipoOferta',oidTipoOferta);
	} else {
		set('frmContenido.ocbTipoOferta','');
	}
	var oidCondicionPromocion = dtoOferta.detalleOferta[pos].oidCondicionPromocion;
	if (oidCondicionPromocion!=null) {
		set('frmContenido.ocbCondicionPromo',oidCondicionPromocion);
	} else {
		set('frmContenido.ocbCondicionPromo','');
	}
	var oidCicloVida = dtoOferta.detalleOferta[pos].oidCicloVida;
	if (oidCicloVida!=null) {
		set('frmContenido.ocbCicloVida',oidCicloVida);
	} else {
		set('frmContenido.ocbCicloVida','');
	}

	//Club Priviledges
	var oidProgFideMaeProd = dtoOferta.detalleOferta[pos].programaFidelizacionMAE;
	var oidProgFide = dtoOferta.detalleOferta[pos].programaFidelizacion;
	var variantes = dtoOferta.detalleOferta[pos].variantes;

	if (oidProgFideMaeProd!=null&&oidProgFideMaeProd!='') {
		set('frmContenido.hFideHabilita',"S");
	} else {
		set('frmContenido.hFideHabilita',"N");
	}

	if(oidProgFide!=null&&oidProgFide!=''){
		if (get('frmContenido.htipoOperacion')==get('frmContenido.htipoOperacionMODIFICACION')){
			set('frmContenido.ocbProgramaFidelizacion',oidProgFide);
		} else {				
			set('frmContenido.ocbProgramaFidelizacion',oidProgFideMaeProd);
		}
	}else{
		set('frmContenido.ocbProgramaFidelizacion',oidProgFideMaeProd);		
	}
			
	if(variantes!=null&&variantes!=''){
		if (get('frmContenido.htipoOperacion')==get('frmContenido.htipoOperacionMODIFICACION')){  
			set('frmContenido.ocbVariante',variantes);
		} else {
			if (oidProgFideMaeProd!=null&&oidProgFideMaeProd!='') {
				set('frmContenido.ocbVariante','2');
			}
		}
	} else {
		if (get('frmContenido.htipoOperacion')==get('frmContenido.htipoOperacionMODIFICACION')){  			
		} else {
			if (oidProgFideMaeProd!=null&&oidProgFideMaeProd!='') {
				set('frmContenido.ocbVariante','2');
			}
		}
	}

	this.manejaHabilitacionCampos();
	this.posicionaCombo();
	this.onChangeTipoOferta();//esto debe ir despues de posicionaCombo()
	this.gestionarRButtons();//imprimible digitable
	this.onChangeProgFide();
}
// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function fLimpiar() {
	cargarDetalle(posicion);
    focaliza('frmContenido.txtTextoBreve');
}

// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function cambiaSINO(){
	var si = GestionarMensaje('MMGGlobal.checkbox.yes.message');
	var no = GestionarMensaje('MMGGlobal.checkbox.no.message');


	if(get("frmContenido.comis") == 1){
		txt_to('lblComisionableX',si);
	}else{
		txt_to('lblComisionableX',no);   
	}

	if(get("frmContenido.punta") == '1'){
		txt_to('lblPuntajeX',si);
	}else{
		txt_to('lblPuntajeX',no);   
	}

	if(get("frmContenido.estad") == '1'){
		txt_to('lblEstadisticableX',si);
	}else{
		txt_to('lblEstadisticableX',no);   
	}

	if(get("frmContenido.mmini") == '1'){
		txt_to('lblMontoMinimoX',si);
	}else{
		txt_to('lblMontoMinimoX',no);   
	}

	if(get("frmContenido.amesc") == '1'){
		txt_to('lblAportaMontoX',si);
	}else{
		txt_to('lblAportaMontoX',no);   
	}
}  

// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------  
function gestionarRButtons(){  
	set("frmContenido.ckDigitable",get("frmContenido.digitable"));	
	set("frmContenido.ckImprimible",get("frmContenido.imprimible"));
	if (get('frmContenido.enableimprimible')=='true'){
		document.all.ckImprimible[0].disabled=false;                           
	} else {
		document.all.ckImprimible[0].disabled=true;          
	}
	if (get('frmContenido.enabledigitable')=='true'){
		document.all.ckDigitable[0].disabled=false;          
	} else {
		document.all.ckDigitable[0].disabled=true;          
	}      
}
  
// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function fGuardar(){
	guardar();
}

// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function posicionaCombo(){
	var array = new Array();
	array[0]=get("frmContenido.ocbTipoOferta");
	set('frmContenido.cbTipoOferta',array);
	array = new Array();
	array[0]=get("frmContenido.ocbCondicionPromo");
	set('frmContenido.cbCondicionPromo',array);
	array = new Array();
	array[0]=get("frmContenido.ocbCicloVida");
	set('frmContenido.cbCicloVida',array);		
	array = new Array();
	array[0]=get("frmContenido.ocbProgramaFidelizacion");
	set('frmContenido.cbProgramaFidelizacion',array);		
	array = new Array();
	array[0]=get("frmContenido.ocbVariante");
	set('frmContenido.cbVariante',array);		    
}

// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function guardar(){

	//validaciones
	if(!sicc_validaciones_generales("gral")){
		return false;
	}  
	if (get("frmContenido.cbProgramaFidelizacion")!=''){
		if(!sicc_validaciones_generales("priviledges")){
		  return false;
		}
	}

	if (get("frmContenido.obligaPuntoFijo")=="true"){
		if(!sicc_validaciones_generales("priviledges2")){
			return false;
		}        
	}

	var precPos = numeroDeFormatoSICC(get('frmContenido.precioPosX'), get("frmContenido.txtPrecioCat"));
	var precCata = numeroDeFormatoSICC(get("frmContenido.txtPrecioCat"), get("frmContenido.txtPrecioCat"));    

	if ((arguments.length == 0) && (precCata>precPos)) {
		 //En este caso muestro mensaje.
		 var res = GestionarMensaje('1289');       
		 if (res==false) return false;
	}

	//SE AGREGA VALIDACIONES ADICIONALES AL INGRESO DEL PRODUCTO DE LA OFERTA
	if(arguments.length == 0) {
		var oidTipoOferta = get("frmContenido.cbTipoOferta","V");
		set('frmContenido.ocbTipoOferta',oidTipoOferta);
		
		set('frmContenido.accion', 'validaciones');
		eval('frmContenido').oculto = 'S';
		enviaSICC('frmContenido','','','N');
		return;
	}
	
	//almacenamiento del dtoDetalle en objeto dtoOferta js en la posicion "posicion" de la variable global

	dtoOferta.detalleOferta[posicion].numeroGrupo =	parametros.grupoActual;

	var txtTextoBreve = get("frmContenido.txtTextoBreve");
	dtoOferta.detalleOferta[posicion].descripcion =	txtTextoBreve;

	var txtPrecioCat = get("frmContenido.txtPrecioCat");
	dtoOferta.detalleOferta[posicion].precioCatalogo = numeroDeFormatoSICC(txtPrecioCat);

	var txtNPagCatalogo = get("frmContenido.txtNPagCatalogo");
	dtoOferta.detalleOferta[posicion].paginaCatalogo = txtNPagCatalogo;

	var cbTipoOfertaDesc = get("frmContenido.cbTipoOferta","T").toString();
	dtoOferta.detalleOferta[posicion].descripcionTipoOferta = cbTipoOfertaDesc;

	var cbCicloVidaDesc = get('frmContenido.cbCicloVida','T').toString();
	dtoOferta.detalleOferta[posicion].descripcionCicloVida = cbCicloVidaDesc;

	var txtPosPagina = get("frmContenido.txtPosPagina");
	dtoOferta.detalleOferta[posicion].posicionPagina = txtPosPagina;

	var txtUniEstimadas2 = get("frmContenido.txtUniEstimadas2");
	dtoOferta.detalleOferta[posicion].unidadesEstimadas = numeroDeFormatoSICC(txtUniEstimadas2);

	var txtFactorRepeticion = get("frmContenido.txtFactorRepeticion");
	dtoOferta.detalleOferta[posicion].factorRepeticion = txtFactorRepeticion;

	var txtVentaNetaEstimada = get("frmContenido.txtVentaNetaEstimada");
	dtoOferta.detalleOferta[posicion].ventaNetaEstimada = numeroDeFormatoSICC(txtVentaNetaEstimada);

	var oidCondicionPromo = get("frmContenido.cbCondicionPromo","V").toString();
	dtoOferta.detalleOferta[posicion].oidCondicionPromocion = oidCondicionPromo;

	var oidTipoOferta = get("frmContenido.cbTipoOferta","V").toString();
	dtoOferta.detalleOferta[posicion].oidTipoOferta = oidTipoOferta;

	var oidCicloVida = get("frmContenido.cbCicloVida","V").toString();
	dtoOferta.detalleOferta[posicion].oidCicloVida = oidCicloVida;

	var ckDigitable = get("frmContenido.ckDigitable");

	if (ckDigitable=='S') {
		dtoOferta.detalleOferta[posicion].digitable = 'true';
	} else {
		dtoOferta.detalleOferta[posicion].digitable = 'false';
	}

	var ckImprimible = get("frmContenido.ckImprimible");

	if (ckImprimible=='S') {
		dtoOferta.detalleOferta[posicion].impresionGP = 'true';
	} else {
		dtoOferta.detalleOferta[posicion].impresionGP = 'false';
	}

	// Se obtiene si los sig. controles están habilitados o no
	var oPrecioPos = document.getElementById("txtPrecioPos");  
	var oCosteEstandar = document.getElementById("txtCosteEstandar");  
	var oCentro = document.getElementById("txtCentro");

	var precioPosicionamientoDisabled = oPrecioPos.disabled;
	var costeEstandarDisabled = oCosteEstandar.disabled;
	var centroDisabled = oCentro.disabled;

	if (!precioPosicionamientoDisabled) { // No esta deshabilitado el campo
		var precioPosicionamiento = get("frmContenido.txtPrecioPos");
		dtoOferta.detalleOferta[posicion].precioPosicionamiento = numeroDeFormatoSICC(precioPosicionamiento);
	}      

	if (!costeEstandarDisabled) { // No esta deshabilitado el campo
		var costeEstandar = get("frmContenido.txtCosteEstandar");
		dtoOferta.detalleOferta[posicion].costeEstandar = numeroDeFormatoSICC(costeEstandar);
	}

	if (centroDisabled=="false") {
		var centro = get("frmContenido.txtCentro");
		dtoOferta.detalleOferta[posicion].centro = centro;
	}

	// club priviledges
	var sprogramaFidel = get("frmContenido.cbProgramaFidelizacion","V").toString();
	dtoOferta.detalleOferta[posicion].programaFidelizacion = sprogramaFidel;

	var svariante = get("frmContenido.cbVariante","V").toString();
	dtoOferta.detalleOferta[posicion].variantes = svariante;

	var spuntoFijo = get("frmContenido.txtPuntoFijo");
	dtoOferta.detalleOferta[posicion].puntajeFijo = spuntoFijo;

	// otros valores
	dtoOferta.detalleOferta[posicion].productoPrincipal = parametros.productoPrincipal;

	if (dtoOferta.generadorClaveUnicaInterna==null||dtoOferta.generadorClaveUnicaInterna=='') {
		dtoOferta.generadorClaveUnicaInterna = 1;
	} else {
		dtoOferta.generadorClaveUnicaInterna = dtoOferta.generadorClaveUnicaInterna + 1;
	}

	dtoOferta.detalleOferta[posicion].claveUnicaInterna = new Number(dtoOferta.generadorClaveUnicaInterna);

	dtoOferta.detalleOferta[posicion].modificado='si';

	//si hay un producto principal de antes lo elimino para que quede el nuevo solamente
	if (parametros.productoPrincipal==true) {
		var lon = new Number(dtoOferta.detalleOferta.length);
		for (var i=0;i<lon;i++){
			if (dtoOferta.detalleOferta[i].productoPrincipal==true&&i!=posicion) {
				dtoOferta.detalleOferta = miSplice(dtoOferta.detalleOferta,i);
				break;
			}
		}
	}
	  
	// cargo el siguiente producto
	posicion = obtenerPosicion();
	if (posicion==false){ 
		window.close();
	} else {
		cargarDetalle(posicion);
	}
}

// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function mostrarMensajeNumerico(campo){
	var msg = sicc_obtenerDescripcion(campo);
	focaliza("frmContenido."+campo);
	cdos_mostrarAlert(GestionarMensaje("000000000000100", "\""+msg+"\""));
}

// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function goToFirstField(){
	focaliza(getFirstField() ,'');
}

// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function toButton(){
  //nombre="btnAnadir" ID="botonContenido"
  focalizaBotonHTML("botonContenido","btnAnadir");
}

// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function goToLastField(){
	focaliza(getLastField() ,'');
}

// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function manejaHabilitacionCampos() {

	var indicadorDeshabilitacion = get('frmContenido.hidDeshabilitarTrioCampos');
	var objPrecioPos = document.getElementById('txtPrecioPos');
	var objCosteEstandar = document.getElementById('txtCosteEstandar');
	var objCentro = document.getElementById('txtCentro');

	var objCatal = document.getElementById('txtCatalogo');
	objCatal.disabled = true;


	if ( indicadorDeshabilitacion == 'true') {
		 // Deshabilita los campos 
         // Agregado por cambio SiCC 20070299 - Rafael Romero - 15/06/2007
         if(parametros.volverLPBuscarProducto!="LPDefinirOfertaPerf" && parametros.volverLPBuscarProducto!="LPCrearGrupoPerf"){
             objPrecioPos.disabled = true;
             objCosteEstandar.disabled = true;
         }
		 objCentro.disabled = true;
	 } else {
		 // Habilita los campos. Innecesaria, pero se deja para claridad de código.
		 objPrecioPos.disabled = false;
		 objCosteEstandar.disabled = false;
		 objCentro.disabled = false;
	 }

	//enoziglia habilitacion prog fide
	var indicadorHabProgFide = get('frmContenido.hFideHabilita');
	var objProgFide = document.getElementById('cbProgramaFidelizacion');
	var objVaria = document.getElementById('cbVariante');
	var objPuntoFijo = document.getElementById('txtPuntoFijo');

	if ( indicadorHabProgFide == 'N') {
		 // Deshabilita los campos 
		 objProgFide.disabled = true;
		 objVaria.disabled = true;
		 objPuntoFijo.disabled = true;
	} else {
		 // Habilita los campos.
		 objProgFide.disabled = false;
		 objVaria.disabled = false;
		 objPuntoFijo.disabled = false;
	}
}

function mostrarValidaciones(mensaje){
	eval('frmContenido').oculto = 'N';
	
	if(mensaje == "") {
		guardar('validaciones');
	} else {
		cdos_mostrarAlert(mensaje);
		set("frmContenido.cbTipoOferta", "");
		focaliza('frmContenido.cbTipoOferta');
	}
}	
