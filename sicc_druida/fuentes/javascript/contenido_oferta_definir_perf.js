var arrCbIdCuadreMono = null;
var arrCbIdCuadreMulti = null;
var arrRegiones = null;
var arrZonas = null;

function onLoadPag() {
	configurarMenuSecundario("frmContenido");
	DrdEnsanchaConMargenDcho('listado1',12);
	DrdEnsanchaConMargenDcho('listado2',12);
	DrdEnsanchaConMargenDcho('listado3',12);
	window.setTimeout('eval (ON_RSZ)',200);
	ShowError();
	leeRegionesZonas();
	posicionaCombos();
	set('frmContenido.ckVentaExclusiva','N');
	cambioVentaExclusiva();
	configuraPagina();
	focalizaPosicion();

	dtoOferta = new Object();
}

function leeRegionesZonas() {
		arrRegiones = new Array();
		arrZonas = new Array();

		var lstRegiones = get('frmContenido.arrRegiones');
		var arrRegionesTemp = lstRegiones.split("|");
		for(var i=0;i<arrRegionesTemp.length;i++) {
			var arrRegionTemp = arrRegionesTemp[i].split("&");
			arrRegiones[arrRegionTemp[0]] = arrRegionTemp[1];
		}
		var lstZonas = get('frmContenido.arrZonas');
		var arrZonasTemp = lstZonas.split("|");
		for(var i=0;i<arrZonasTemp.length;i++) {
			var arrZonaTemp = arrZonasTemp[i].split("&");
			arrZonas[arrZonaTemp[0]] = new Array();
			arrZonas[arrZonaTemp[0]][0] = arrZonaTemp[1];//DescZona
			arrZonas[arrZonaTemp[0]][1] = arrZonaTemp[2];//OidRegion Referenciada
		}
}

function fLimpiar() {

	limpiarDtoOferta();
	vaciarListas();
	set('frmContenido.cbCatalogo','');
	set('frmContenido.ckVentaExclusiva','N');
	set('frmFormularioEnviar.sDatosGralesOferta','');
	set('frmFormularioEnviar.sDetallesOferta','');
	set('frmFormularioEnviar.sVentasExclusivas','');
	accionActivarVentaExclusiva('false');
	deshabilitaCombosPrincipales(false);
	limpiaDatosOferta();
	posicionaCombos();
	configuraPagina();
	focalizaPosicion();

}

function accionNumeroGruposIntroducido(){

	if (arrCbIdCuadreMono==null) {
		arrCbIdCuadreMono = new Array();
		arrCbIdCuadreMulti = new Array();

		var lstIdCuadresMono = get('frmContenido.hlstIdCuadresMono');
		arrCbIdCuadreMono = lstIdCuadresMono.split("|");		
		for(var i=0;i<arrCbIdCuadreMono.length;i++) {
			arrCbIdCuadreMono[i] = arrCbIdCuadreMono[i].split("#")[0].split("&");			
		}
		var lstIdCuadresMulti = get('frmContenido.hlstIdCuadresMulti');
		arrCbIdCuadreMulti = lstIdCuadresMulti.split("|");
		for(var i=0;i<arrCbIdCuadreMulti.length;i++) {
			arrCbIdCuadreMulti[i] = arrCbIdCuadreMulti[i].split("#")[0].split("&");
		}
	}

	var nroGrupos = null;
	
	if(!sicc_validaciones_generales("numGrupos")){
		return false;
	}
	
	nroGrupos = new Number(get('frmContenido.txtNGrupos'));	

	if (nroGrupos>0) {
		if (nroGrupos==1){
			set_combo('frmContenido.cbIdCuadre',arrCbIdCuadreMono);
		} else {
			set_combo('frmContenido.cbIdCuadre',arrCbIdCuadreMulti);
		}
	} else {
		set_combo('frmContenido.cbIdCuadre',new Array());
	}
} 

function vaciarListas() {

	len = listado1.codigos().length;

	if (len>0){
		listado1.eliminar(0,len);
	}

	len = listado2.codigos().length;

	if (len>0){
		listado2.eliminar(0,len);
	}

	len = listado3.codigos().length;

	if (len>0){
		listado3.eliminar(0,len);
	}
	/*listado1.setDatos(new Array());
	listado2.setDatos(new Array());
	listado3.setDatos(new Array());*/
}

function limpiaDatosOferta() {

	set('frmContenido.txtNGrupos','');
	set('frmContenido.txtNPaquetes','');	
	set('frmContenido.cbIdCuadre',new Array());
	set('frmContenido.cbFormaPago',new Array());
	set('frmContenido.txtNGrupCondicionantes','');
	set('frmContenido.txtNGrupCondicionados','');
	set('frmContenido.ckRecObligPedido','N');
	set('frmContenido.ckDespachoCompleto','N'); 

	set('frmContenido.rbCondicionantes','');
	set('frmContenido.rbCondicionados','');

	//depende de la estrategia seleccionada
	if(get('frmContenido.cvDespAuto')=='S'){
		set('frmContenido.ckDespachoAutomatico','S');                 
	} else if(get('frmContenido.cvDespAuto')=='N') {                     
		set('frmContenido.ckDespachoAutomatico','N');
	} else {
		set('frmContenido.ckDespachoAutomatico','N');
	}

	set_combo('frmContenido.cbIdCuadre',new Array());
}
    
function ShowError() {
  if (get('frmContenido.errCodigo') != ''){
		fMostrarMensajeError();
   }
}

function accionBuscarProductoPrincipal() {
		if(!sicc_validaciones_generales("catalogo")){
			return false;
		}
		cargarValoresPantallaDtoOferta();
		var parametros = new Object();     
		parametros.dtoOferta = dtoOferta;
		parametros.oidAcceso = get('frmContenido.cbAcceso','V');
		parametros.oidSubacceso = get('frmContenido.cbSubacceso','V');
		parametros.productoPrincipal = true;
		parametros.oidCatalogo = get('frmContenido.cbCatalogo','V');
		parametros.descripcionCatalogo = get('frmContenido.cbCatalogo','T');
		parametros.volverLPBuscarProducto = "LPDefinirOfertaPerf";
		parametros.multiseleccion = false;
		parametros.mostrarValoresAdicionales = true;
		
		var an = screen.availWidth;
		var al = screen.availHeight;

		var res = mostrarModalSICC("LPBuscarProductoPerf", "", parametros, an, al);

		if (dtoOferta.detalleOferta!=null&&dtoOferta.detalleOferta.length!=null) {
			var lon = new Number(dtoOferta.detalleOferta.length);
			for (var i=0;i<lon;i++){
				if (dtoOferta.detalleOferta[i].modificado=='nuevo') {
					dtoOferta.detalleOferta = miSplice(dtoOferta.detalleOferta,i);
					i--;
					lon--;
				}
			}
			pasaListaProductoPrincipal();
		}
		manejaCombos();
		focalizaPosicion();
}

function pasaListaProductoPrincipal() {
	len = listado1.codigos().length;

	if (len>0){
		listado1.eliminar(0,len);
	}

	var pos;
	for (var i=0;i<dtoOferta.detalleOferta.length ;i++ ){
		if (dtoOferta.detalleOferta[i].productoPrincipal==true) {
			pos=i;
			break;
		}
	}
	if (pos!=null){
		var row = new Array();
		row[0] = dtoOferta.detalleOferta[pos].oidSAP;
		row[1] = dtoOferta.detalleOferta[pos].codigoSAP;
		row[2] = dtoOferta.detalleOferta[pos].descripcion;
		row[3] = dtoOferta.detalleOferta[pos].descripcionTipoOferta;
		row[4] = dtoOferta.detalleOferta[pos].descripcionCicloVida;
		row[5] = dtoOferta.detalleOferta[pos].factorRepeticion;
		row[6] = numeroAsFormatoSICC(dtoOferta.detalleOferta[pos].precioCatalogo);
		row[7] = dtoOferta.detalleOferta[pos].atributo1;
		row[8] = dtoOferta.detalleOferta[pos].atributo2;
		row[9] = dtoOferta.detalleOferta[pos].atributo3;
		row[10] = dtoOferta.detalleOferta[pos].paginaCatalogo;
		row[11] = dtoOferta.detalleOferta[pos].posicionPagina;
		row[12] = dtoOferta.detalleOferta[pos].unidadesEstimadas;
		row[13] = dtoOferta.detalleOferta[pos].ventaNetaEstimada;
		row[14] = dtoOferta.detalleOferta[pos].precioPosicionamiento;
		row[15] = dtoOferta.detalleOferta[pos].costeEstandar;
		row[16] = dtoOferta.detalleOferta[pos].oidCatalogo;
		row[17] = dtoOferta.detalleOferta[pos].descripcionCatalogo;
		row[18] = dtoOferta.detalleOferta[pos].oidTipoOferta;
		row[19] = dtoOferta.detalleOferta[pos].oidCicloVida;
		row[20] = dtoOferta.detalleOferta[pos].centro;

		listado1.insertar(row);
	}
}

function pasaListaProductoAsociado() {

	len = listado2.codigos().length;

	if (len>0){
		listado2.eliminar(0,len);
	}

	for (var i=0;i<dtoOferta.detalleOferta.length ;i++ ){
		if (dtoOferta.detalleOferta[i].productoPrincipal==false||dtoOferta.detalleOferta[i].productoPrincipal==''||
			dtoOferta.detalleOferta[i].productoPrincipal==null) {
			var row = new Array();
			row[0] = dtoOferta.detalleOferta[i].oidSAP;
			row[1] = dtoOferta.detalleOferta[i].codigoSAP;
			row[2] = dtoOferta.detalleOferta[i].descripcion;
			row[3] = dtoOferta.detalleOferta[i].descripcionTipoOferta;
			row[4] = dtoOferta.detalleOferta[i].descripcionCicloVida;
			row[5] = dtoOferta.detalleOferta[i].factorRepeticion;
			row[6] = numeroAsFormatoSICC(dtoOferta.detalleOferta[i].precioCatalogo);
			row[7] = dtoOferta.detalleOferta[i].atributo1;
			row[8] = dtoOferta.detalleOferta[i].atributo2;
			row[9] = dtoOferta.detalleOferta[i].atributo3;
			row[10] = dtoOferta.detalleOferta[i].paginaCatalogo;
			row[11] = dtoOferta.detalleOferta[i].posicionPagina;
			row[12] = dtoOferta.detalleOferta[i].unidadesEstimadas;
			row[13] = dtoOferta.detalleOferta[i].ventaNetaEstimada;
			row[14] = dtoOferta.detalleOferta[i].precioPosicionamiento;
			row[15] = dtoOferta.detalleOferta[i].costeEstandar;
			row[16] = dtoOferta.detalleOferta[i].oidCatalogo;
			row[17] = dtoOferta.detalleOferta[i].descripcionCatalogo;
			row[18] = dtoOferta.detalleOferta[i].oidTipoOferta;
			row[19] = dtoOferta.detalleOferta[i].oidCicloVida;
			row[20] = dtoOferta.detalleOferta[i].centro;

			listado2.insertar(row);						
		}
	}
} 

function cargarValoresPantallaDtoOferta() {
		dtoOferta.oidAcceso =  get('frmContenido.cbAcceso','V');
		dtoOferta.descripcionAcceso =  get('frmContenido.cbAcceso','T');
		dtoOferta.oidSubacceso = get('frmContenido.cbSubacceso','V');
		dtoOferta.descripcionSubacceso = get('frmContenido.cbSubacceso','T');
}

function accionBuscarProductoAsociado() {
		if(!sicc_validaciones_generales("catalogo")) {
			return false;
		}

		var parametros = new Object();   
		parametros.dtoOferta = dtoOferta;					
		parametros.oidAcceso = get('frmContenido.cbAcceso','V');
		parametros.oidSubacceso = get('frmContenido.cbSubacceso','V');
		parametros.productoPrincipal = false;
		parametros.oidCatalogo = get('frmContenido.cbCatalogo','V');
		parametros.descripcionCatalogo = get('frmContenido.cbCatalogo','T');
		parametros.volverLPBuscarProducto = "LPDefinirOfertaPerf";
		parametros.multiseleccion = true;
		parametros.mostrarValoresAdicionales = false;

		var an = screen.availWidth;
		var al = screen.availHeight;
	
		var res = mostrarModalSICC("LPBuscarProductoPerf", "", parametros, an, al);   

		if (dtoOferta.detalleOferta!=null&&dtoOferta.detalleOferta.length!=null) {
			var lon = new Number(dtoOferta.detalleOferta.length);
			var arrElim = new Array();
			for (var i=0;i<lon;i++){
				if (dtoOferta.detalleOferta[i].modificado=='nuevo') {
					dtoOferta.detalleOferta = miSplice(dtoOferta.detalleOferta,i);
					i--;
					lon--;
				}
			}
			pasaListaProductoAsociado();
		}		
		manejaCombos();
		focalizaPosicion();
}      
           
function accionActivarVentaExclusiva(estado) {
	if (estado=='true'){
		accion('frmContenido.cbTipoCliente','.disabled=false');
		accion('frmContenido.cbSubtipoCliente','.disabled=false');
		accion('frmContenido.cbTipoClasificacion','.disabled=false');
		accion('frmContenido.cbClasificacion','.disabled=false');
		accion('frmContenido.cbEstatusCliente','.disabled=false');
		accion('frmContenido.txtEstatus2','.disabled=false');
		//Unidad Administrativa
		accion('frmContenido.cbRegion','.disabled=false');
		accion('frmContenido.cbZona','.disabled=false');
		accion('frmContenido.rbRegion','.disabled=false');
		accion('frmContenido.rbZona','.disabled=false');
		accion('frmContenido.rbRegion','.checked=true');
		onClickRegion();
		
	}else{
		set('frmContenido.cbTipoCliente','');
		set('frmContenido.cbSubtipoCliente','');
		set('frmContenido.cbTipoClasificacion','');
		set('frmContenido.cbClasificacion','');
		set('frmContenido.cbEstatusCliente','');
		set('frmContenido.txtEstatus2','');
		var arr = new Array();
		set_combo('frmContenido.cbIdCuadre',arr);
		set_combo('frmContenido.cbSubtipoCliente',arr);
		set_combo('frmContenido.cbTipoClasificacion',arr);
		set_combo('frmContenido.cbClasificacion',arr);
		accion('frmContenido.cbTipoCliente','.disabled=true');
		accion('frmContenido.cbSubtipoCliente','.disabled=true');
		accion('frmContenido.cbTipoClasificacion','.disabled=true');
		accion('frmContenido.cbClasificacion','.disabled=true');
		accion('frmContenido.cbEstatusCliente','.disabled=true');
		accion('frmContenido.txtEstatus2','.disabled=true');
		//Unidad Administrativa
		accion('frmContenido.cbRegion','.disabled=true');
		accion('frmContenido.cbZona','.disabled=true');
		accion('frmContenido.rbRegion','.disabled=true');
		accion('frmContenido.rbZona','.disabled=true');
		iRegion = new Array();
		iZona = new Array();
		set('frmContenido.cbRegion', iRegion);
		set('frmContenido.cbZona', iZona);
		/*set_combo('frmContenido.cbRegion',arr);
		set_combo('frmContenido.cbZona',arr);*/
	}
}

function accionAniadirVentaExclusiva(){
	if (get('frmContenido.ckVentaExclusiva')!='S')
		return;
		
	if(!sicc_validaciones_generales("vexcl")){
	  return false;
	}                    
	if (fValidarCOMBO("frmContenido.cbTipoCliente")){

		var dtoVentaExclusiva = new Object();

		var arrRegionesSelecc = get('frmContenido.cbRegion','V');
		var arrZonasSelecc = get('frmContenido.cbZona','V');
		if (arrRegionesSelecc.length>0) {	
			var arrDescRegionesSelecc = get('frmContenido.cbRegion','T');
			var algunoExiste = false;
			for (var r=0; r<arrRegionesSelecc.length; r++) {
				dtoVentaExclusiva = new Object();
				dtoVentaExclusiva.oidVentaExclusiva = nuevoOidVentaExclusiva();
				dtoVentaExclusiva.oidTipoCliente = get('frmContenido.cbTipoCliente','V');
				dtoVentaExclusiva.descripcionTipoCliente = get('frmContenido.cbTipoCliente','T');
				dtoVentaExclusiva.oidSubtipoCliente = get('frmContenido.cbSubtipoCliente','V');
				dtoVentaExclusiva.descripcionSubtipoCliente = get('frmContenido.cbSubtipoCliente','T');
				dtoVentaExclusiva.oidTipoClasificacion = get('frmContenido.cbTipoClasificacion','V');
				dtoVentaExclusiva.descripcionTipoClasificacion = get('frmContenido.cbTipoClasificacion','T');
				dtoVentaExclusiva.oidClasificacion = get('frmContenido.cbClasificacion','V');
				dtoVentaExclusiva.descripcionClasificacion = get('frmContenido.cbClasificacion','T');
				dtoVentaExclusiva.oidEstatus = get('frmContenido.cbEstatusCliente','V');
				dtoVentaExclusiva.descripcionEstatus = get('frmContenido.cbEstatusCliente','T');
				dtoVentaExclusiva.estatus2 = get('frmContenido.txtEstatus2');
				dtoVentaExclusiva.oidRegion = arrRegionesSelecc[r];
				dtoVentaExclusiva.descripcionRegion = arrDescRegionesSelecc[r];

				if (!existeVentaExclusiva(dtoVentaExclusiva)){
					agregarVentaExclusiva(dtoVentaExclusiva);
					var row = new Array();
					row[0] = dtoVentaExclusiva.oidVentaExclusiva;
					row[1] = dtoVentaExclusiva.descripcionTipoCliente;
					row[2] = dtoVentaExclusiva.descripcionSubtipoCliente;
					row[3] = dtoVentaExclusiva.descripcionTipoClasificacion;
					row[4] = dtoVentaExclusiva.descripcionClasificacion;
					row[5] = dtoVentaExclusiva.descripcionEstatus;
					row[6] = dtoVentaExclusiva.estatus2;
					row[7] = dtoVentaExclusiva.descripcionRegion;
					row[8] = '';

					listado3.insertar(row);
				} else {
					algunoExiste = true;
				}
			}
			if (algunoExiste==true) {
				GestionarMensaje("PRE0047");
			}
		} else if (arrZonasSelecc.length>0) {
			var arrDescZonasSelecc = get('frmContenido.cbZona','T');
			var algunoExiste = false;
			for (var z=0; z<arrZonasSelecc.length; z++)	{
				dtoVentaExclusiva = new Object();
				dtoVentaExclusiva.oidVentaExclusiva = nuevoOidVentaExclusiva();
				dtoVentaExclusiva.oidTipoCliente = get('frmContenido.cbTipoCliente','V');
				dtoVentaExclusiva.descripcionTipoCliente = get('frmContenido.cbTipoCliente','T');
				dtoVentaExclusiva.oidSubtipoCliente = get('frmContenido.cbSubtipoCliente','V');
				dtoVentaExclusiva.descripcionSubtipoCliente = get('frmContenido.cbSubtipoCliente','T');
				dtoVentaExclusiva.oidTipoClasificacion = get('frmContenido.cbTipoClasificacion','V');
				dtoVentaExclusiva.descripcionTipoClasificacion = get('frmContenido.cbTipoClasificacion','T');
				dtoVentaExclusiva.oidClasificacion = get('frmContenido.cbClasificacion','V');
				dtoVentaExclusiva.descripcionClasificacion = get('frmContenido.cbClasificacion','T');
				dtoVentaExclusiva.oidEstatus = get('frmContenido.cbEstatusCliente','V');
				dtoVentaExclusiva.descripcionEstatus = get('frmContenido.cbEstatusCliente','T');
				dtoVentaExclusiva.estatus2 = get('frmContenido.txtEstatus2');
				var zonReg = arrZonasSelecc[z].split("x");
				dtoVentaExclusiva.oidZona = zonReg[0];
				dtoVentaExclusiva.descripcionZona = arrDescZonasSelecc[z];
				if (arrRegiones[arrZonas[zonReg[0]][1]]==undefined) {
					dtoVentaExclusiva.descripcionRegion = '';
				} else {
					dtoVentaExclusiva.oidRegion = arrZonas[zonReg[0]][1];
					dtoVentaExclusiva.descripcionRegion = arrRegiones[arrZonas[zonReg[0]][1]];//= descripcion , arrZonasSelecc[z] = oidZona , arrZonas[arrZonasSelecc[z]][1] = oidRegion que referencia
				}

				if (!existeVentaExclusiva(dtoVentaExclusiva)){
					agregarVentaExclusiva(dtoVentaExclusiva);
					var row = new Array();
					row[0] = dtoVentaExclusiva.oidVentaExclusiva;
					row[1] = dtoVentaExclusiva.descripcionTipoCliente;
					row[2] = dtoVentaExclusiva.descripcionSubtipoCliente;
					row[3] = dtoVentaExclusiva.descripcionTipoClasificacion;
					row[4] = dtoVentaExclusiva.descripcionClasificacion;
					row[5] = dtoVentaExclusiva.descripcionEstatus;
					row[6] = dtoVentaExclusiva.estatus2;
					row[7] = dtoVentaExclusiva.descripcionRegion;
					row[8] = dtoVentaExclusiva.descripcionZona;

					listado3.insertar(row);
				} else {
					algunoExiste = true;
				}
			}
			if (algunoExiste==true) {
				GestionarMensaje("PRE0047");
			}
		} else {
			dtoVentaExclusiva.oidVentaExclusiva = nuevoOidVentaExclusiva();
			dtoVentaExclusiva.oidTipoCliente = get('frmContenido.cbTipoCliente','V');
			dtoVentaExclusiva.descripcionTipoCliente = get('frmContenido.cbTipoCliente','T');
			dtoVentaExclusiva.oidSubtipoCliente = get('frmContenido.cbSubtipoCliente','V');
			dtoVentaExclusiva.descripcionSubtipoCliente = get('frmContenido.cbSubtipoCliente','T');
			dtoVentaExclusiva.oidTipoClasificacion = get('frmContenido.cbTipoClasificacion','V');
			dtoVentaExclusiva.descripcionTipoClasificacion = get('frmContenido.cbTipoClasificacion','T');
			dtoVentaExclusiva.oidClasificacion = get('frmContenido.cbClasificacion','V');
			dtoVentaExclusiva.descripcionClasificacion = get('frmContenido.cbClasificacion','T');
			dtoVentaExclusiva.oidEstatus = get('frmContenido.cbEstatusCliente','V');
			dtoVentaExclusiva.descripcionEstatus = get('frmContenido.cbEstatusCliente','T');
			dtoVentaExclusiva.estatus2 = get('frmContenido.txtEstatus2');

			if (!existeVentaExclusiva(dtoVentaExclusiva)){
				agregarVentaExclusiva(dtoVentaExclusiva);
				var row = new Array();
				row[0] = dtoVentaExclusiva.oidVentaExclusiva;
				row[1] = dtoVentaExclusiva.descripcionTipoCliente;
				row[2] = dtoVentaExclusiva.descripcionSubtipoCliente;
				row[3] = dtoVentaExclusiva.descripcionTipoClasificacion;
				row[4] = dtoVentaExclusiva.descripcionClasificacion;
				row[5] = dtoVentaExclusiva.descripcionEstatus;
				row[6] = dtoVentaExclusiva.estatus2;
				row[7] = '';
				row[8] = '';

				listado3.insertar(row);
			} else {
				GestionarMensaje("PRE0047");
			}
		}
	}                
}

function fBorrar(){
	if (listado2.numSelecc()>0){
		accionEliminarProductosAsociados();              
	} else if (listado3.numSelecc()>0){
		accionEliminarVentaExclusiva();
	} else {
		GestionarMensaje(4);
	}
}

function accionEliminarProductosAsociados(){
  if (listado2.numSelecc()>0){
	  if(GestionarMensaje("5")){
			var arrElim = new Array();
			var lon = dtoOferta.detalleOferta.length;
			var cods = listado2.codSeleccionados();
			for (var i=0;i<lon;i++){
				for (var j=0;j<cods.length;j++){
					if (dtoOferta.detalleOferta[i].oidSAP==cods[j]) {
						arrElim[arrElim.length]=i;
					}
				}
			}
			for (var k=arrElim.length-1;k>=0;k--){
				dtoOferta.detalleOferta = miSplice(dtoOferta.detalleOferta,arrElim[k]);
			}
			listado2.eliminarSelecc();
	  }
  }
}

function accionEliminarVentaExclusiva(){//falta saber a que lista pertenece
  if (listado3.numSelecc()>0){
	  if(GestionarMensaje("5")){
			var arrElim = new Array();
			var lon = dtoOferta.ventaExclusiva.length;
			var cods = listado3.codSeleccionados();
			for (var i=0;i<lon;i++){
				for (var j=0;j<cods.length;j++){
					if (dtoOferta.ventaExclusiva[i].oidVentaExclusiva==cods[j]) {
						arrElim[arrElim.length]=i;
					}
				}
			}
			for (var k=arrElim.length-1;k>=0;k--){
				dtoOferta.ventaExclusiva = miSplice(dtoOferta.ventaExclusiva,arrElim[k]);
			}
			listado3.eliminarSelecc();
	  }
  } 
}
           
function accesoOnChange(){
	accion('frmContenido.cbSubacceso','.disabled=false');
	var arr = new Array();
	arr[arr.length]= new Array("oidPais","1");
	arr[arr.length]= new Array("oidIdioma","1");
	arr[arr.length]= new Array("oid",get('frmContenido.cbAcceso'));
	var acc1 = get('frmContenido.cbAcceso');

	if (acc1=="") {	
		accion('frmContenido.cbSubacceso','.disabled=true');
		set ('frmContenido.cbSubacceso',new Array());
		return;
	}
	accion('frmContenido.cbSubacceso','.disabled=false');
	recargaCombo("frmContenido.cbSubacceso", "SegObtenerSubaccesosPorAcceso", 
	"es.indra.sicc.util.DTOOID", arr, "configuraSubacceso(datos)");
}

function tipoClienteOnChange(){
  accion('frmContenido.cbSubtipoCliente','.disabled=false');
  recargaCombo('frmContenido.cbSubtipoCliente', 'MAEobtenerSubtipos', 
			   'es.indra.sicc.util.DTOOID', makeParameter('oid',get('frmContenido.cbTipoCliente')));
  set_combo('frmContenido.cbTipoClasificacion',new Array()); 
  set_combo('frmContenido.cbClasificacion',new Array()); 
}

function subtipoClienteOnChange(){
  accion('frmContenido.cbTipoClasificacion','.disabled=false');
  recargaCombo('frmContenido.cbTipoClasificacion', 'MAEobtenerTipoClasificacion', 
			   'es.indra.sicc.util.DTOOID', makeParameter('oid',get('frmContenido.cbSubtipoCliente')));
  set_combo('frmContenido.cbClasificacion',new Array()); 
}

function tipoClasificacionOnChange(){
  accion('frmContenido.cbClasificacion','.disabled=false');
  recargaCombo('frmContenido.cbClasificacion', 'MAEobtenerClasificacionesPorTipo', 
			   'es.indra.sicc.util.DTOOID', makeParameter('oid',get('frmContenido.cbTipoClasificacion')));
}

function posicionaCombos(){
	var array = new Array();
	if (get('frmContenido.hAccesoDef')!=''){
	  array[0] = get('frmContenido.hAccesoDef');
	  set('frmContenido.cbAcceso',array)
	  if (get('frmContenido.hAccesoDef')!=''){
		  accesoOnChange();
	  }
	}
  
	array = new Array();                
	if (get('frmContenido.argumentoVta')!=""){
	  array[0] = get('frmContenido.argumentoVta');
	  set('frmContenido.cbArgumentoVenta',array);    
	}
}

function configuraSubacceso(datos){
	var arr = new Array();
	if (datos.length>0){              
		arr[arr.length]=new Array("","");
		for (var i=0;i<datos.length;i++){
			arr[arr.length]=datos[i];
		}
	}
	set_combo('frmContenido.cbSubacceso', arr, []);
	var array = new Array();
	if (get('frmContenido.hSubaccesoDef')!=''){
		array[0] = get('frmContenido.hSubaccesoDef');
		set('frmContenido.cbSubacceso',array);
		get('frmContenido.hSubaccesoDef','');
	} 
	if (arr.length ==0){
		accion('frmContenido.cbSubacceso','.disabled=true');
	}
}

function cambioVentaExclusiva(){
	if (get('frmContenido.ckVentaExclusiva')=='S'){
		accionActivarVentaExclusiva('true');
	}else{
		accionActivarVentaExclusiva('false');
	}
}
        
function configuraPagina(){
	if (get('frmContenido.accion')==''){
	  if (get('frmContenido.cbAcceso')=='')
		  accion('frmContenido.cbSubacceso','.disabled=true');
	}
	if (get('frmContenido.numGrupos')=='false'){
		accion('frmContenido.txtNGrupos','.disabled=true');
	} else {
		accion('frmContenido.txtNGrupos','.disabled=false');
	}
	if (get('frmContenido.numPaqu')=='false'){
		accion('frmContenido.txtNPaquetes','.disabled=true');
	} else {
		accion('frmContenido.txtNPaquetes','.disabled=false');
	}
	if (get('frmContenido.indCuadre')=='false'){
		accion('frmContenido.cbIdCuadre','.disabled=true');
	} else {
		accion('frmContenido.cbIdCuadre','.disabled=false');
	}
	if (get('frmContenido.numGrupCondtes')=='false'){
		accion('frmContenido.txtNGrupCondicionantes','.disabled=true');
	} else {
		accion('frmContenido.txtNGrupCondicionantes','.disabled=false');
	}
	if (get('frmContenido.numGrupCondos')=='false'){
		accion('frmContenido.txtNGrupCondicionados','.disabled=true');
	} else {
		accion('frmContenido.txtNGrupCondicionados','.disabled=false');
	}
	if (get('frmContenido.condCondos')=='false'){
	  document.all.rbCondicionados[0].disabled=true;
	  document.all.rbCondicionados[1].disabled=true;                  
	}

	if (get('frmContenido.condCondtes')=='false'){
	  document.all.rbCondicionantes[0].disabled=true;
	  document.all.rbCondicionantes[1].disabled=true;             
	}
	if (get('frmContenido.despAuto')=='false'){
	  document.all.ckDespachoAutomatico[0].disabled=true;
	}
	set('frmContenido.ckDespachoAutomatico',get('frmContenido.cvDespAuto'));
	
	if (get('frmContenido.despCompl')=='false'){
	  document.all.ckDespachoCompleto[0].disabled=true;
	}
	if (get('frmContenido.btnBPPpal')=='false'){
	  document.all["Buscar1Div"].style.visibility='hidden'
	}
	if (get('frmContenido.btnBPAsoc')=='false'){
	  document.all["Buscar2Div"].style.visibility='hidden'
	} 

	if (get('frmContenido.numGrupos')=='true'||get('frmContenido.numPaqu')=='true'||
		get('frmContenido.numGrupCondos')=='true'||get('frmContenido.numGrupCondtes')=='true'){
		document.all["btnGrupos"].style.visibility='';
		deshabilitarHabilitarBoton('botonContenido','btnGrupos','A');
	} else {
		document.all["btnGrupos"].style.visibility='hidden';
	}

	if (get('frmContenido.ranking')=='S'){
		document.all["btnRanking"].style.visibility='';
		deshabilitarHabilitarBoton('botonContenido','btnRanking','A');
	} else {
		document.all["btnRanking"].style.visibility='hidden';
	}

	if (get('frmContenido.promociones')=='S'){
		document.all["btnCondicion"].style.visibility='';
		deshabilitarHabilitarBoton('botonContenido','btnCondicion','A');
	} else {
		document.all["btnCondicion"].style.visibility='hidden';
	}
}

function fGuardar(){


	if(!sicc_validaciones_generales("grgral")){
	  return false;
	}
	
	if (get('frmContenido.condCondtes')=='true'){
		if (get('frmContenido.rbCondicionantes')==""){
			GestionarMensaje('721');
			return;
		}
	}
	if (get('frmContenido.condCondos')=='true'){
		if (get('frmContenido.rbCondicionados')==""){
			GestionarMensaje('722');
			return;
		}
	}
	if (get('frmContenido.btnBPPpal')=='true'){//Valido que haya Porducto principal
		if (listado1.datos.length<1){
			GestionarMensaje('235');
			return;
		}
	} else {
		if(!sicc_validaciones_generales("catalogo")){
		  return false;
		}                    
	}
	if (get('frmContenido.btnBPAsoc')=='true'){//Valido que haya Porducto asociado
		if (listado2.datos.length<1){
			GestionarMensaje('720');
			return;
		}
	} else {
	  if(!sicc_validaciones_generales("catalogo")){
		return false;
	  }      
	}
//      sbonanno - 20/06/2006 - BELC300023389  
//      if (!fValidarCOMBO('frmContenido.cbFormaPago')){return;}
	if (get('frmContenido.ckVentaExclusiva')=='S'){//verifico que haya al menos una venta exclusiva
		if (listado3.datos.length<1){
			GestionarMensaje('2524');
			return;
		}
	}//enozigli 27/09/2005 BELC300021032

	//valido que se hayan completado los grupos
	if (get('frmContenido.numGrupos')=='true'||get('frmContenido.numPaqu')=='true'||
		get('frmContenido.numGrupCondos')=='true'||get('frmContenido.numGrupCondtes')=='true'){
		if(dtoOferta.grupo!=null&&dtoOferta.grupo.length!=null){
			tamanio = dtoOferta.grupo.length;
			if (get('frmContenido.numGrupos')=='true'){
				var nroGrp = new Number(get('frmContenido.txtNGrupos'));
				if (nroGrp>tamanio) {
					GestionarMensaje('PRE1001');
					return;
				}
			}
			if (get('frmContenido.numPaqu')=='true'){
				var nroPaq = new Number(get('frmContenido.txtNPaquetes'));
				if (nroPaq>tamanio) {
					GestionarMensaje('PRE1001');
					return;
				}
			}
			if (get('frmContenido.numGrupCondos')=='true'){
				var nroGrp = new Number(get('frmContenido.txtNGrupos'));
				if (nroGrp>tamanio) {
					GestionarMensaje('PRE1001');
					return;
				}
			}
		} else {
			GestionarMensaje('PRE1001');
			return;
		}
	}

	//valido que se hayan completado los grupos (a pedido del cliente)	
	if (get('frmContenido.promociones')=='S'){
		if(dtoOferta.promocion!=null&&dtoOferta.promocion.length!=null){
			var nroPromo = new Number(dtoOferta.promocion.length);
			if (nroPromo>0)	{
				//Este es el caso correcto debe haber al menos una condicion de promocion.
			} else {
				GestionarMensaje('PRE1003');
				return;
			}
		} else {
			GestionarMensaje('PRE1003');
			return;
		}
	}

	if (get('frmContenido.ranking')=='S'){
		if (dtoOferta.primeraPosicionRanking==null||dtoOferta.primeraPosicionRanking=='') {
			GestionarMensaje('PRE1006');
			return;
		}
	}

	set('frmContenido.descCatalogo',get('frmContenido.cbCatalogo','T'));

	cargarTodosValoresPantDtoOferta();

	set('frmFormularioEnviar.sDatosGralesOferta',serializarDatGenOferta());
	set('frmFormularioEnviar.sDetallesOferta',serializarDetallesOferta());
	set('frmFormularioEnviar.sVentasExclusivas',serializarVtasExclusivas());
	set('frmFormularioEnviar.sPromociones',serializarPromocion());
	set('frmFormularioEnviar.sGrupos',serializarGrupos());

	set('frmFormularioEnviar.conectorAction', "LPDefinirOfertaPerf");
	set('frmFormularioEnviar.accion', "Guardar oferta");
	enviaSICC("frmFormularioEnviar");
}

function cargarTodosValoresPantDtoOferta(){

	dtoOferta.oidOferta = '';
	dtoOferta.oidCabeceraMF = get('frmContenido.oidCabeceraMF');
	dtoOferta.numeroOrden = '';
	dtoOferta.oidEstrategia = get('frmContenido.oidEstrategia');
	cargarValoresPantallaDtoOferta();
	dtoOferta.numeroOferta = '';
	dtoOferta.oidArgumentoVenta = get('frmContenido.cbArgumentoVenta','V');
	dtoOferta.descripcionArgumentoVenta = get('frmContenido.cbArgumentoVenta','T');
	if (get('frmContenido.ckDespachoCompleto')=='S') {
		dtoOferta.despachoCompleto = 'true';
	} else {
		dtoOferta.despachoCompleto = 'false';
	}

	if (get('frmContenido.ckDespachoAutomatico')=='S') {
		dtoOferta.despachoAutomatico = 'true';
	} else {
		dtoOferta.despachoAutomatico = 'false';
	}
	dtoOferta.numeroGrupos = get('frmContenido.txtNGrupos');
	dtoOferta.numeroPaquetes = get('frmContenido.txtNPaquetes');
	dtoOferta.numeroGruposCondicionantes = get('frmContenido.txtNGrupCondicionantes');
	dtoOferta.numeroGruposCondicionados = get('frmContenido.txtNGrupCondicionados');
	if (get('frmContenido.rbCondicionantes')=='N') {
		dtoOferta.condicionCondicionantes = 'O';
	} else if (get('frmContenido.rbCondicionantes')=='S') {
		dtoOferta.condicionCondicionantes = 'Y';
	} else {
		dtoOferta.condicionCondicionantes = '';
	}

	if (get('frmContenido.rbCondicionados')=='N') {
		dtoOferta.condicionCondicionados = 'O';
	} else if (get('frmContenido.rbCondicionados')=='S') {
		dtoOferta.condicionCondicionados = 'Y';
	} else {
		dtoOferta.condicionCondicionados = '';
	}
	if (dtoOferta.primeraPosicionRanking==null||dtoOferta.primeraPosicionRanking=='undefined') {
		dtoOferta.primeraPosicionRanking= '';//se debe setear en el boton de ranking
	}
	if (dtoOferta.ultimaPosicionRanking==null||dtoOferta.ultimaPosicionRanking=='undefined') {
		dtoOferta.ultimaPosicionRanking= '';//se debe setear en el boton de ranking
	}
	dtoOferta.codigoVentaGenerado = 'false';
	dtoOferta.matrizFacturacionGenerada = 'false';
	dtoOferta.oidFormaPago = get('frmContenido.cbFormaPago','V');
	dtoOferta.descripcionFormaPago = get('frmContenido.cbFormaPago','T');
	if (get('frmContenido.ckRecObligPedido')=='S') {
		dtoOferta.recuperacionObligatoria = 'true';
	} else {
		dtoOferta.recuperacionObligatoria = 'false';
	}
	dtoOferta.registroEstadisticoGenerado = 'false';
	dtoOferta.oidIndCuadre = get('frmContenido.cbIdCuadre','V');
	dtoOferta.matrizFacturada= '';
	dtoOferta.oidCatalogo = get('frmContenido.cbCatalogo','V');
	dtoOferta.descripcionCatalogo = get('frmContenido.cbCatalogo','T');
	dtoOferta.descripcionEstrategia= '';

}

function makeParameter(nombre, oid){
	var array = new Array();
	var i=0;
	array[i] = new Array('oidPais','1');
	i++;
	array[i] = new Array('oidIdioma','1');
	i++;
	array[i] = new Array(nombre,oid)
	return array;
}

function sumarYPoner(){
	if (get('frmContenido.txtNGrupCondicionados')!=''&&get('frmContenido.txtNGrupCondicionantes')!='') {
		if(!sicc_validaciones_generales("numGrupoCnd")){
			return false;
		}
		
		var ncondos = get('frmContenido.txtNGrupCondicionados');
		var ncondtes = get('frmContenido.txtNGrupCondicionantes');            
		var res = new Number(ncondos)+new Number(ncondtes);
		set('frmContenido.txtNGrupos',res);
		accionNumeroGruposIntroducido(); 
	}
}

function mostrarMensajeNumerico(campo){
	var msg = sicc_obtenerDescripcion(campo);                
	focaliza("frmContenido."+campo);
	cdos_mostrarAlert(GestionarMensaje("000000000000100" ,  "\""+msg+"\""));                
}

function tabNOrden(){
	if (get('frmContenido.btnBPPpal')=="true"){
		focalizaBotonHTML_XY("Buscar1");
	} else {
		tabNextBtn();
	}
}
function tabNextBtn(){
	if (get('frmContenido.btnBPAsoc')=="true") {
		focalizaBotonHTML_XY("Buscar2");
	} else {
		tabDatosOferta();
	}
}

function arrayComponentes(){
	var arr = new Array();
	arr[arr.length]= new Array("cbAcceso","");
	arr[arr.length]= new Array("cbSubacceso","");
	arr[arr.length]= new Array("cbCatalogo","");
	arr[arr.length]= new Array("cbArgumentoVenta","");
	//arr[arr.length]= new Array("txtNOrden","");

	arr[arr.length]= new Array("Buscar1","BOTONXY");
	arr[arr.length]= new Array("Buscar2","BOTONXY");

	arr[arr.length]= new Array("txtNGrupos","");
	arr[arr.length]= new Array("txtNPaquetes","");
	arr[arr.length]= new Array("cbIdCuadre","");

	arr[arr.length]= new Array("txtNGrupCondicionantes","");
	arr[arr.length]= new Array("rbCondicionantes","");
	arr[arr.length]= new Array("txtNGrupCondicionados","");
	arr[arr.length]= new Array("rbCondicionados","");

	arr[arr.length]= new Array("ckDespachoCompleto","");
	arr[arr.length]= new Array("ckDespachoAutomatico","");
	arr[arr.length]= new Array("ckRecObligPedido","");
	arr[arr.length]= new Array("cbFormaPago","");
	arr[arr.length]= new Array("btnGrupos","BOTON");
	arr[arr.length]= new Array("btnCondicion","BOTON");
	arr[arr.length]= new Array("btnRanking","BOTON");

	arr[arr.length]= new Array("ckVentaExclusiva","");
	arr[arr.length]= new Array("cbTipoCliente","");
	arr[arr.length]= new Array("cbSubtipoCliente","");
	arr[arr.length]= new Array("cbTipoClasificacion","");
	arr[arr.length]= new Array("cbClasificacion","");
	arr[arr.length]= new Array("cbEstatusCliente","");
	arr[arr.length]= new Array("txtEstatus2","");

	arr[arr.length]= new Array("btnAnadir","BOTON");

	arr[arr.length]= new Array("Anadir","BOTONXY");             

	return arr;
}

function tabGenerico(nombreComp, tipotab){       
	var arr = arrayComponentes();
	var tabular = false;
	var nombreFormulario = getFormularioSICC();
	var j = 0;
	var k = arr.length;
	if (tipotab != "sh") {
		j = j-1;                
		k = k-1;
	}

	while(j<k){
		var t;
		if(tipotab == "sh"){
		  k--;
		  t = k;
		} else{
		  j++;
		  t = j;                  
		}
		  
		var nombre = arr[t][0];
		var tipo = arr[t][1];
		if (tabular==false){
		  if (nombreComp==nombre){
			  tabular=true;
			  if (tipotab == "sh"){
				if (k==0) k= arr.length;
			  } else {
				if ((j+1)==arr.length)  j = -1;
			  }
		  }                
		} else {
		  try {
			var name = nombreFormulario+"."+nombre;
			if (tipo=="BOTONXY"){
			   focalizaBotonHTML_XY(nombre);
			} else if (tipo=="BOTON") {
			   focalizaBotonHTML("botonContenido",nombre)
			} else {
			   focaliza(name);
			}
			return;
		  } catch (e) {
		  }
		}
	}
}

function manejaCombos(){			
	  if ((listado1.datos.length>0)||
		  (listado2.datos.length)){
		  deshabilitaCombosPrincipales(true);
	  }
}

function deshabilitaCombosPrincipales(choice){
	if (choice) {
	  accion('frmContenido.cbAcceso','.disabled=true');
	  accion('frmContenido.cbSubacceso','.disabled=true');
	  accion('frmContenido.cbCatalogo','.disabled=true');
	} else {
	  accion('frmContenido.cbAcceso','.disabled=false');
	  accion('frmContenido.cbSubacceso','.disabled=false');
	  accion('frmContenido.cbCatalogo','.disabled=false');
	}
}

function focalizaPosicion(){
	if ((listado1.datos.length==0)&&
		(listado2.datos.length==0)){
		focaliza('frmContenido.cbAcceso','');
	} else {
		focaliza('frmContenido.cbArgumentoVenta','');
	}
}

function accionDefinirGrupos(){

	if(!sicc_validaciones_generales("catalogo")){
		return false;
	}

	if (get('frmContenido.numGrupos')=='true'){
		if(!sicc_validaciones_generales("grngrup")){
		  return false;
		} else if (!sicc_validaciones_generales("numGrupos")) {
		  return false;
		}
		if (get('frmContenido.maxGrupo')!=''){
		  if(get('frmContenido.maxGrupo')<get('frmContenido.txtNGrupos')){
			  GestionarMensaje('716');
			  return;
		  }
		}
	}                    
	if (get('frmContenido.numPaqu')=='true'){
		if(!sicc_validaciones_generales("grnpaq")){
			return false;
		} else if (!sicc_validaciones_generales("numPaq")) {
			return false;
		}
		if (get('frmContenido.maxGrupo')!=''){
		  if(get('frmContenido.maxGrupo')<get('frmContenido.txtNPaquetes')){
			  GestionarMensaje('717');
			  return;
		  }
		}
	}
	if (get('frmContenido.numGrupCondtes')=='true' &&
		get('frmContenido.numGrupCondos')=='true'){
		if(!sicc_validaciones_generales("grcond")){
		return false;
		}                        
		if (get('frmContenido.maxGruposCondicionantes')!=''){
		  if (get('frmContenido.txtNGrupCondicionantes')>
			  get('frmContenido.maxGruposCondicionantes')){
			  GestionarMensaje('718');
			  return;
		  }
		}
		if (get('frmContenido.maxGruposCondicionados')!=''){
		  if (get('frmContenido.txtNGrupCondicionados')>
			  get('frmContenido.maxGruposCondicionados')){
			  GestionarMensaje('719');
			  return;
		  }
		}
		var ncondo = new Number(get('frmContenido.txtNGrupCondicionados'));
		var ncontes = new Number(get('frmContenido.txtNGrupCondicionantes'));
		
		if (get('frmContenido.maxGrupo')!=''){
		  if (ncondo+ncontes>get('frmContenido.maxGrupo')){
			  GestionarMensaje('234');
			  return;
		  }
		}
	}

	if (get('frmContenido.indCuadre')=='true'){
	  if(!sicc_validaciones_generales("idCuadre")){
		return false;
	  }                
	}

	cargarValoresPantallaDtoOferta();
	var parametros = new Object();     
	parametros.dtoOferta = dtoOferta;
	parametros.oidAcceso = get('frmContenido.cbAcceso','V');
	parametros.oidSubacceso = get('frmContenido.cbSubacceso','V');
	parametros.oidCatalogo = get('frmContenido.cbCatalogo','V');
	parametros.descripcionCatalogo = get('frmContenido.cbCatalogo','T');
	parametros.numeroGrupos =  get('frmContenido.txtNGrupos');

	if(dtoOferta.grupo!=null&&dtoOferta.grupo.length!=null){
		parametros.grupoActual = dtoOferta.grupo.length+1;
	} else {
		parametros.grupoActual = 1;
	}

	parametros.numeroPaquetes =  get('frmContenido.txtNPaquetes');
	parametros.numeroGruposCondicionantes =  get('frmContenido.txtNGrupCondicionantes');
	parametros.numeroGruposCondicionados =  get('frmContenido.txtNGrupCondicionados');
	parametros.cuadreGrupos = get('frmContenido.cuadreGrupos');
	parametros.oidIndCuadre = get('frmContenido.cbIdCuadre','V');

	var numeroGrupos = new Number(get('frmContenido.txtNGrupos'));
	if (numeroGrupos>0) {
		if (get('frmContenido.cuadreGrupos')=='false'){
			parametros.cargaComboIdCuadre = "|"+get('frmContenido.cbIdCuadre','V')+"&"+get('frmContenido.cbIdCuadre','T')+"# ";
		} else {
			if (numeroGrupos==1){
				parametros.cargaComboIdCuadre = get('frmContenido.hlstIdCuadresMono');
			} else {
				parametros.cargaComboIdCuadre = get('frmContenido.hlstIdCuadresMulti');
			}
		}
	}

	var an = screen.availWidth;
	var al = screen.availHeight;

	var res = mostrarModalSICC("LPCrearGrupoPerf", "", parametros, an, al);

	deshabilitaCombosPrincipales(true);
	accion('frmContenido.txtNGrupos','.disabled=true');
	accion('frmContenido.txtNPaquetes','.disabled=true');
	accion('frmContenido.txtNGrupCondicionantes','.disabled=true');
	accion('frmContenido.txtNGrupCondicionados','.disabled=true');
	accion('frmContenido.cbIdCuadre','.disabled=true');

	var numeroGrupos = new Number(parametros.numeroGrupos);
	var numeroPaquetes = new Number(parametros.numeroPaquetes);
	var cantIngresados = new Number(0);

	if(dtoOferta.grupo!=null&&dtoOferta.grupo.length!=null){
		cantIngresados = new Number(dtoOferta.grupo.length);
	}

	//elimino los detalles de los grupos superiores a cantIngresados ya que no fueron guardados
	if (dtoOferta.detalleOferta!=null&&dtoOferta.detalleOferta.length!=null) {
		var lon = new Number(dtoOferta.detalleOferta.length);
		for (var i=0;i<lon;i++){
			var nroGrupo = new Number(dtoOferta.detalleOferta[i].numeroGrupo);
			if (nroGrupo>cantIngresados) {
				dtoOferta.detalleOferta = miSplice(dtoOferta.detalleOferta,i);
				i--;
				lon--;
			}
		}
	}

	if (numeroGrupos>0) {
		if (cantIngresados<numeroGrupos) {
			//se deja el boton habilitado para que luego se continue llenando
		} else {
			deshabilitarHabilitarBoton('botonContenido','btnGrupos','D');
		}
	} else {
		if (cantIngresados<numeroPaquetes) {
			//se deja el boton habilitado para que luego se continue llenando
		} else {
			deshabilitarHabilitarBoton('botonContenido','btnGrupos','D');
		}
	}
	focalizaPosicion();
}

function accionDefinirCondicion(){

	cargarValoresPantallaDtoOferta();
	var parametros = new Object();     
	parametros.dtoOferta = dtoOferta;
	parametros.oidAcceso = get('frmContenido.cbAcceso','V');
	parametros.oidSubacceso = get('frmContenido.cbSubacceso','V');
	
	var an = screen.availWidth;
	var al = screen.availHeight;

	var res = mostrarModalSICC("LPDefinirCondicionOfertaPerf", "", parametros, an, al);

	//deshabilitarHabilitarBoton('botonContenido','btnCondicion','D'); se comenta por ahora
	focalizaPosicion();
}

function accionEvaluarRanking(){

	if (get('frmContenido.numGrupos')=='true'||get('frmContenido.numPaqu')=='true'||
		get('frmContenido.numGrupCondos')=='true'||get('frmContenido.numGrupCondtes')=='true'){
		if(dtoOferta.grupo!=null&&dtoOferta.grupo.length!=null){
			tamanio = dtoOferta.grupo.length;
			if (get('frmContenido.numGrupos')=='true'){
				var nroGrp = new Number(get('frmContenido.txtNGrupos'));
				if (nroGrp>tamanio) {
					GestionarMensaje('PRE1004');
					return;
				}
			}
			if (get('frmContenido.numPaqu')=='true'){
				var nroPaq = new Number(get('frmContenido.txtNPaquetes'));
				if (parametros.numeroPaquetes>tamanio) {
					GestionarMensaje('PRE1004');
					return;
				}
			}
			if (get('frmContenido.numGrupCondos')=='true'){
				var nroGrp = new Number(get('frmContenido.txtNGrupos'));
				if (nroGrp>tamanio) {
					GestionarMensaje('PRE1004');
					return;
				}
			}
		} else {
			GestionarMensaje('PRE1004');
			return;
		}
	}

	cargarValoresPantallaDtoOferta();
	var parametros = new Object();     
	parametros.dtoOferta = dtoOferta;
	parametros.oidAcceso = get('frmContenido.cbAcceso','V');
	parametros.oidSubacceso = get('frmContenido.cbSubacceso','V');


	var res = mostrarModalSICC("LPEvaluarRankingPorDemandaPerf", "", parametros, 720, 380);

	
	deshabilitarHabilitarBoton('botonContenido','btnRanking','D');
	focalizaPosicion();
}


	function onClickRegion(){
    	set('frmContenido.cbRegion', '');
		set('frmContenido.hZona', '');
		set('frmContenido.hRegion', 'S');
		accion('frmContenido.rbZona', '.checked=false');
		set('frmContenido.cbZona', '');	
		accion('frmContenido.cbZona', '.disabled=true');	
		accion('frmContenido.cbRegion', '.disabled=false');
	}

	function onClickZona(){
		accion('frmContenido.rbRegion', '.checked=false');
		set('frmContenido.hZona', 'S');
		set('frmContenido.hRegion', '');
		set('frmContenido.cbRegion', '');
		accion('frmContenido.cbRegion', '.disabled=true');
		accion('frmContenido.cbZona', '.disabled=false');	
	}
