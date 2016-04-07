var dtoOferta;

//Contadores para el campo NUM_RANG_INTE
//de la tabla PRE_RANGO_PROMO segun
//sea PRODUCTOS, LINEAS_NEGOCIO o RANGO_PAGINAS
var contadorProductos = 0;
var contadorLineasProductos = 0;
var contadorPaginas = 0;

function limpiarDtoOferta(){
	
	dtoOferta.oidOferta = null;
	dtoOferta.oidCabeceraMF = null;
	dtoOferta.numeroOrden = null;
	dtoOferta.oidEstrategia = null;
	dtoOferta.oidAcceso = null;
	dtoOferta.descripcionAcceso = "";
	dtoOferta.oidSubacceso = null;
	dtoOferta.descripcionSubacceso = "";
	dtoOferta.numeroOferta = null;
	dtoOferta.oidArgumentoVenta = null;
	dtoOferta.descripcionArgumentoVenta = "";
	dtoOferta.despachoCompleto = null;
	dtoOferta.despachoAutomatico = null;
	dtoOferta.numeroGrupos = null;
	dtoOferta.numeroPaquetes = null;
	dtoOferta.numeroGruposCondicionantes = null;
	dtoOferta.numeroGruposCondicionados = null;
	dtoOferta.condicionCondicionantes = "";
	dtoOferta.condicionCondicionados = "";
	dtoOferta.primeraPosicionRanking = null;
	dtoOferta.ultimaPosicionRanking = null;
	dtoOferta.codigoVentaGenerado = null;
	dtoOferta.matrizFacturacionGenerada = null;
	dtoOferta.oidFormaPago = null;
	dtoOferta.descripcionFormaPago = "";
	dtoOferta.recuperacionObligatoria = null;
	dtoOferta.registroEstadisticoGenerado = null;
	dtoOferta.ventaExclusiva = null;
	dtoOferta.promocion = null;
	dtoOferta.detalleOferta = null;
	dtoOferta.grupo = null;
	dtoOferta.oidIndCuadre = null;
	dtoOferta.matrizFacturada = null;
	dtoOferta.oidCatalogo = null;
	dtoOferta.descripcionCatalogo = "";
	dtoOferta.descripcionEstrategia = "";

	return dtoOferta;
}

function setear(x){
	if (x!=null)	{	
		return true;
	} else {
		return false;
	}
}

function agregarDetalle(dtoDetalle, posicion){

	if (posicion==null)
	{
		if(dtoOferta.detalleOferta!=null&&dtoOferta.detalleOferta.length!=null){
			posicion = dtoOferta.detalleOferta.length;
		} else {
			posicion = 0;
			dtoOferta.detalleOferta = new Array();			
		}
		dtoOferta.detalleOferta[posicion]= new Object();
	}
	

	if (setear(dtoDetalle.oidDetalleOferta))
	{	dtoOferta.detalleOferta[posicion].oidDetalleOferta = dtoDetalle.oidDetalleOferta;
	}
	if (setear(dtoDetalle.lineaOferta))
	{	dtoOferta.detalleOferta[posicion].lineaOferta = dtoDetalle.lineaOferta;
	}
	if (setear(dtoDetalle.oidSAP))
	{	dtoOferta.detalleOferta[posicion].oidSAP = dtoDetalle.oidSAP;
	}
	if (setear(dtoDetalle.codigoSAP))
	{	dtoOferta.detalleOferta[posicion].codigoSAP = dtoDetalle.codigoSAP;
	}
	if (setear(dtoDetalle.descripcion))
	{	dtoOferta.detalleOferta[posicion].descripcion = dtoDetalle.descripcion;
	}
	if (setear(dtoDetalle.unidadesEstimadas))
	{	dtoOferta.detalleOferta[posicion].unidadesEstimadas = dtoDetalle.unidadesEstimadas;
	}
	if (setear(dtoDetalle.origen))
	{	dtoOferta.detalleOferta[posicion].origen = dtoDetalle.origen;
	}
	if (setear(dtoDetalle.factorRepeticion))
	{	dtoOferta.detalleOferta[posicion].factorRepeticion = dtoDetalle.factorRepeticion;
	}
	if (setear(dtoDetalle.atributo1))
	{	dtoOferta.detalleOferta[posicion].atributo1 = dtoDetalle.atributo1;
	}
	if (setear(dtoDetalle.atributo2))
	{	dtoOferta.detalleOferta[posicion].atributo2 = dtoDetalle.atributo2;
	}
	if (setear(dtoDetalle.atributo3))
	{	dtoOferta.detalleOferta[posicion].atributo3 = dtoDetalle.atributo3;
	}
	if (setear(dtoDetalle.digitable))
	{	dtoOferta.detalleOferta[posicion].digitable = dtoDetalle.digitable;
	}
	if (setear(dtoDetalle.impresionGP))
	{	dtoOferta.detalleOferta[posicion].impresionGP = dtoDetalle.impresionGP;
	}
	if (setear(dtoDetalle.posicionRanking))
	{	dtoOferta.detalleOferta[posicion].posicionRanking = dtoDetalle.posicionRanking;
	}
	if (setear(dtoDetalle.oidFormaPago))
	{	dtoOferta.detalleOferta[posicion].oidFormaPago = dtoDetalle.oidFormaPago;
	}
	if (setear(dtoDetalle.digitable))
	{	dtoOferta.detalleOferta[posicion].descripcionFormaPago = dtoDetalle.descripcionFormaPago;
	}
	if (setear(dtoDetalle.numeroGrupo))
	{	dtoOferta.detalleOferta[posicion].numeroGrupo = dtoDetalle.numeroGrupo;
	}
	if (setear(dtoDetalle.productoPrincipal))
	{	dtoOferta.detalleOferta[posicion].productoPrincipal = dtoDetalle.productoPrincipal;
	}
	if (setear(dtoDetalle.precioCatalogo))
	{	dtoOferta.detalleOferta[posicion].precioCatalogo = dtoDetalle.precioCatalogo;
	}
	if (setear(dtoDetalle.posicionPagina))
	{	dtoOferta.detalleOferta[posicion].posicionPagina = dtoDetalle.posicionPagina;
	}
	if (setear(dtoDetalle.precioPosicionamiento))
	{	dtoOferta.detalleOferta[posicion].precioPosicionamiento = dtoDetalle.precioPosicionamiento;
	}
	if (setear(dtoDetalle.costeEstandar))
	{	dtoOferta.detalleOferta[posicion].costeEstandar = dtoDetalle.costeEstandar;
	}
	if (setear(dtoDetalle.ventaNetaEstimada))
	{	dtoOferta.detalleOferta[posicion].ventaNetaEstimada = dtoDetalle.ventaNetaEstimada;
	}
	if (setear(dtoDetalle.oidCatalogo))
	{	dtoOferta.detalleOferta[posicion].oidCatalogo = dtoDetalle.oidCatalogo;
	}
	if (setear(dtoDetalle.paginaCatalogo))
	{	dtoOferta.detalleOferta[posicion].paginaCatalogo = dtoDetalle.paginaCatalogo;
	}
	if (setear(dtoDetalle.oidCondicionPromocion))
	{	dtoOferta.detalleOferta[posicion].oidCondicionPromocion = dtoDetalle.oidCondicionPromocion;
	}
	if (setear(dtoDetalle.oidTipoOferta))
	{	dtoOferta.detalleOferta[posicion].oidTipoOferta = dtoDetalle.oidTipoOferta;
	}
	if (setear(dtoDetalle.oidCicloVida))
	{	dtoOferta.detalleOferta[posicion].oidCicloVida = dtoDetalle.oidCicloVida;
	}
	if (setear(dtoDetalle.matrizFacturacionGenerada))
	{	dtoOferta.detalleOferta[posicion].matrizFacturacionGenerada = dtoDetalle.matrizFacturacionGenerada;
	}
	if (setear(dtoDetalle.oidGrupo))
	{	dtoOferta.detalleOferta[posicion].oidGrupo = dtoDetalle.oidGrupo;
	}
	if (setear(dtoDetalle.centro))
	{	dtoOferta.detalleOferta[posicion].centro = dtoDetalle.centro;
	}
	if (setear(dtoDetalle.codigoVentaGenerado))
	{	dtoOferta.detalleOferta[posicion].codigoVentaGenerado = dtoDetalle.codigoVentaGenerado;
	}
	if (setear(dtoDetalle.codigoVenta))
	{	dtoOferta.detalleOferta[posicion].codigoVenta = dtoDetalle.codigoVenta;
	}
	if (setear(dtoDetalle.tipoOperacion))
	{	dtoOferta.detalleOferta[posicion].tipoOperacion = dtoDetalle.tipoOperacion;
	}
	if (setear(dtoDetalle.programaFidelizacion))
	{	dtoOferta.detalleOferta[posicion].programaFidelizacion = dtoDetalle.programaFidelizacion;
	}
	if (setear(dtoDetalle.variantes))
	{	dtoOferta.detalleOferta[posicion].variantes = dtoDetalle.variantes;
	}	
	if (setear(dtoDetalle.puntajeFijo))
	{	dtoOferta.detalleOferta[posicion].puntajeFijo = dtoDetalle.puntajeFijo;
	}
	if (setear(dtoDetalle.precioUnitario))
	{	dtoOferta.detalleOferta[posicion].precioUnitario = dtoDetalle.precioUnitario;
	}
	//campos extras para manejo entre pantallas (no pertenecen al DTOOferta original)
	if (setear(dtoDetalle.descripcionCorta))
	{	dtoOferta.detalleOferta[posicion].descripcionCorta = dtoDetalle.descripcionCorta;
	}
	if (setear(dtoDetalle.descripcionSAP))
	{	dtoOferta.detalleOferta[posicion].descripcionSAP = dtoDetalle.descripcionSAP;
	}
	if (setear(dtoDetalle.descripcionTipoOferta))
	{	dtoOferta.detalleOferta[posicion].descripcionTipoOferta = dtoDetalle.descripcionTipoOferta;//para listaEditable de pantalla Definir Oferta
	}
	if (setear(dtoDetalle.descripcionCicloVida))
	{	dtoOferta.detalleOferta[posicion].descripcionCicloVida = dtoDetalle.descripcionCicloVida; //para listaEditable de pantalla Definir Oferta
	}
	if (setear(dtoDetalle.descripcionCatalogo))
	{	dtoOferta.detalleOferta[posicion].descripcionCatalogo = dtoDetalle.descripcionCatalogo;
	}
	if (setear(dtoDetalle.modificado))
	{	dtoOferta.detalleOferta[posicion].modificado = dtoDetalle.modificado;
	}
	if (setear(dtoDetalle.programaFidelizacionMAE))
	{	dtoOferta.detalleOferta[posicion].programaFidelizacionMAE = dtoDetalle.programaFidelizacionMAE;
	}
}

function miSplice(arr, pos){
	var newArray = new Array();
	var j=0;
	for (var i=0;i<arr.length;i++){
		if (pos!=i)	{			
			newArray[j] = arr[i];
			j++;
		}
	}
	return newArray;
}

function agregarVentaExclusiva(dtoVentaExclusiva, posicion){

	if (posicion==null)
	{
		if(dtoOferta.ventaExclusiva!=null&&dtoOferta.ventaExclusiva.length!=null){
			posicion = dtoOferta.ventaExclusiva.length;
		} else {
			posicion = 0;
			dtoOferta.ventaExclusiva = new Array();			
		}
		dtoOferta.ventaExclusiva[posicion]= new Object();
	}
	
	if (setear(dtoVentaExclusiva.oidVentaExclusiva))
	{	dtoOferta.ventaExclusiva[posicion].oidVentaExclusiva = dtoVentaExclusiva.oidVentaExclusiva;
	}
	if (setear(dtoVentaExclusiva.oidTipoCliente))
	{	dtoOferta.ventaExclusiva[posicion].oidTipoCliente = dtoVentaExclusiva.oidTipoCliente;
	}
	if (setear(dtoVentaExclusiva.descripcionTipoCliente))
	{	dtoOferta.ventaExclusiva[posicion].descripcionTipoCliente = dtoVentaExclusiva.descripcionTipoCliente;
	}
	if (setear(dtoVentaExclusiva.oidSubtipoCliente))
	{	dtoOferta.ventaExclusiva[posicion].oidSubtipoCliente = dtoVentaExclusiva.oidSubtipoCliente;
	}
	if (setear(dtoVentaExclusiva.descripcionSubtipoCliente))
	{	dtoOferta.ventaExclusiva[posicion].descripcionSubtipoCliente = dtoVentaExclusiva.descripcionSubtipoCliente;
	}
	if (setear(dtoVentaExclusiva.oidTipoClasificacion))
	{	dtoOferta.ventaExclusiva[posicion].oidTipoClasificacion = dtoVentaExclusiva.oidTipoClasificacion;
	}
	if (setear(dtoVentaExclusiva.descripcionTipoClasificacion))
	{	dtoOferta.ventaExclusiva[posicion].descripcionTipoClasificacion = dtoVentaExclusiva.descripcionTipoClasificacion;
	}
	if (setear(dtoVentaExclusiva.oidClasificacion))
	{	dtoOferta.ventaExclusiva[posicion].oidClasificacion = dtoVentaExclusiva.oidClasificacion;
	}
	if (setear(dtoVentaExclusiva.descripcionClasificacion))
	{	dtoOferta.ventaExclusiva[posicion].descripcionClasificacion = dtoVentaExclusiva.descripcionClasificacion;
	}
	if (setear(dtoVentaExclusiva.oidEstatus))
	{	dtoOferta.ventaExclusiva[posicion].oidEstatus = dtoVentaExclusiva.oidEstatus;
	}
	if (setear(dtoVentaExclusiva.descripcionEstatus))
	{	dtoOferta.ventaExclusiva[posicion].descripcionEstatus = dtoVentaExclusiva.descripcionEstatus;
	}
	if (setear(dtoVentaExclusiva.estatus2))
	{	dtoOferta.ventaExclusiva[posicion].estatus2 = dtoVentaExclusiva.estatus2;
	}
	if (setear(dtoVentaExclusiva.oidRegion))
	{	dtoOferta.ventaExclusiva[posicion].oidRegion = dtoVentaExclusiva.oidRegion;
	}
	if (setear(dtoVentaExclusiva.descripcionRegion))
	{	dtoOferta.ventaExclusiva[posicion].descripcionRegion = dtoVentaExclusiva.descripcionRegion;
	}
	if (setear(dtoVentaExclusiva.oidZona))
	{	dtoOferta.ventaExclusiva[posicion].oidZona = dtoVentaExclusiva.oidZona;
	}
	if (setear(dtoVentaExclusiva.descripcionZona))
	{	dtoOferta.ventaExclusiva[posicion].descripcionZona = dtoVentaExclusiva.descripcionZona;
	}
	if (setear(dtoVentaExclusiva.tipoOperacion))
	{	dtoOferta.ventaExclusiva[posicion].tipoOperacion = dtoVentaExclusiva.tipoOperacion;
	}
}

function existeVentaExclusiva(dtoVentaExclusiva){

	if(dtoOferta.ventaExclusiva!=null&&dtoOferta.ventaExclusiva.length!=null) {
		var lonVenExc = dtoOferta.ventaExclusiva.length;
		var existeEnVtaExc = false;
		for (var i=0;i<lonVenExc;i++) {
			if (comparaVentaExclusiva(dtoOferta.ventaExclusiva[i], dtoVentaExclusiva)) {
				existeEnVtaExc = true;
			}
		}
		return existeEnVtaExc;
	} else {
		return false;
	}
}

function comparaVentaExclusiva(dtoVentaExclusiva1,dtoVentaExclusiva2){

	if (((dtoVentaExclusiva1.oidClasificacion[0]==dtoVentaExclusiva2.oidClasificacion[0])||(dtoVentaExclusiva1.oidClasificacion==null&&dtoVentaExclusiva2.oidClasificacion==null))&&
		((dtoVentaExclusiva1.oidTipoClasificacion[0]==dtoVentaExclusiva2.oidTipoClasificacion[0])||(dtoVentaExclusiva1.oidTipoClasificacion==null&&dtoVentaExclusiva2.oidTipoClasificacion==null))&&
		((dtoVentaExclusiva1.oidTipoCliente[0]==dtoVentaExclusiva2.oidTipoCliente[0])||(dtoVentaExclusiva1.oidClasificacion==null&&dtoVentaExclusiva2.oidClasificacion==null))&&
		((dtoVentaExclusiva1.oidSubtipoCliente[0]==dtoVentaExclusiva2.oidSubtipoCliente[0])||(dtoVentaExclusiva1.oidSubtipoCliente==null&&dtoVentaExclusiva2.oidSubtipoCliente==null))&&
		((dtoVentaExclusiva1.oidZona==dtoVentaExclusiva2.oidZona)||(dtoVentaExclusiva1.oidZona==null&&dtoVentaExclusiva2.oidZona==null))&&
		((dtoVentaExclusiva1.oidRegion==dtoVentaExclusiva2.oidRegion)||(dtoVentaExclusiva1.oidRegion==null&&dtoVentaExclusiva2.oidRegion==null))&&
		((dtoVentaExclusiva1.oidEstatus[0]==dtoVentaExclusiva2.oidEstatus[0])||(dtoVentaExclusiva1.oidEstatus==null&&dtoVentaExclusiva2.oidEstatus==null))){
		return true;
	} else {
		return false;
	}
}

function nuevoOidVentaExclusiva(){

	if(dtoOferta.ventaExclusiva!=null&&dtoOferta.ventaExclusiva.length!=null) {
		var lonVenExc = dtoOferta.ventaExclusiva.length;
		var oidVtaExcl = new Number(0);
		for (var i=0;i<lonVenExc;i++) {
			var oidVtaExclDTO = new Number(dtoOferta.ventaExclusiva[i].oidVentaExclusiva);
			if (oidVtaExclDTO>oidVtaExcl) {				
				oidVtaExcl = oidVtaExclDTO;
			}
		}
		oidVtaExcl = oidVtaExcl + 1;
		return oidVtaExcl;
	} else {
		return new Number(0);
	}

}

function serializarDatGenOferta(){
	var toAdd = "";

	toAdd = "oidOferta=" + dtoOferta.oidOferta;
	toAdd = toAdd + "|" + "oidCabeceraMF=" + dtoOferta.oidCabeceraMF;
	toAdd = toAdd + "|" + "numeroOrden=" + dtoOferta.numeroOrden;
	toAdd = toAdd + "|" + "oidEstrategia=" + dtoOferta.oidEstrategia;
	toAdd = toAdd + "|" + "oidAcceso=" + dtoOferta.oidAcceso;
	toAdd = toAdd + "|" + "descripcionAcceso=" + dtoOferta.descripcionAcceso;
	toAdd = toAdd + "|" + "oidSubacceso=" + dtoOferta.oidSubacceso;
	toAdd = toAdd + "|" + "descripcionSubacceso=" + dtoOferta.descripcionSubacceso;
	toAdd = toAdd + "|" + "numeroOferta=" + dtoOferta.numeroOferta;
	toAdd = toAdd + "|" + "oidArgumentoVenta=" + dtoOferta.oidArgumentoVenta;
	toAdd = toAdd + "|" + "descripcionArgumentoVenta=" + dtoOferta.descripcionArgumentoVenta;
	toAdd = toAdd + "|" + "despachoCompleto=" + dtoOferta.despachoCompleto;
	toAdd = toAdd + "|" + "despachoAutomatico=" + dtoOferta.despachoAutomatico;
	if (get('frmContenido.condicionada')=='S') {
		var nroCndtes = new Number(dtoOferta.numeroGruposCondicionantes);
		var nroCndos = new Number(dtoOferta.numeroGruposCondicionados);
		var nroGrps = nroCndtes + nroCndos;
		toAdd = toAdd + "|" + "numeroGrupos=" + nroGrps;
	} else {
		toAdd = toAdd + "|" + "numeroGrupos=" + dtoOferta.numeroGrupos;
	}	
	toAdd = toAdd + "|" + "numeroPaquetes=" + dtoOferta.numeroPaquetes;
	toAdd = toAdd + "|" + "numeroGruposCondicionantes=" + dtoOferta.numeroGruposCondicionantes;
	toAdd = toAdd + "|" + "numeroGruposCondicionados=" + dtoOferta.numeroGruposCondicionados;
	toAdd = toAdd + "|" + "condicionCondicionantes=" + dtoOferta.condicionCondicionantes;
	toAdd = toAdd + "|" + "condicionCondicionados=" + dtoOferta.condicionCondicionados;
	toAdd = toAdd + "|" + "primeraPosicionRanking=" + dtoOferta.primeraPosicionRanking;
	toAdd = toAdd + "|" + "ultimaPosicionRanking=" + dtoOferta.ultimaPosicionRanking;
	toAdd = toAdd + "|" + "codigoVentaGenerado=" + dtoOferta.codigoVentaGenerado;
	toAdd = toAdd + "|" + "matrizFacturacionGenerada=" + dtoOferta.matrizFacturacionGenerada;
	toAdd = toAdd + "|" + "oidFormaPago=" + dtoOferta.oidFormaPago;
	toAdd = toAdd + "|" + "descripcionFormaPago=" + dtoOferta.descripcionFormaPago;
	toAdd = toAdd + "|" + "recuperacionObligatoria=" + dtoOferta.recuperacionObligatoria;
	toAdd = toAdd + "|" + "registroEstadisticoGenerado=" + dtoOferta.registroEstadisticoGenerado;
	toAdd = toAdd + "|" + "oidIndCuadre=" + dtoOferta.oidIndCuadre;
	toAdd = toAdd + "|" + "matrizFacturada=" + dtoOferta.matrizFacturada;
	toAdd = toAdd + "|" + "oidCatalogo=" + dtoOferta.oidCatalogo;
	toAdd = toAdd + "|" + "descripcionCatalogo=" + dtoOferta.descripcionCatalogo;
	toAdd = toAdd + "|" + "descripcionEstrategia=" + dtoOferta.descripcionEstrategia;

	return toAdd;
}

function serializarDetallesOferta(){
	var toAdd = "";

	var constantePREMF = get('frmContenido.hCtePREMF');
	var oidFormaPago = get('frmContenido.cbFormaPago','V');
	var descFormaPago = get('frmContenido.cbFormaPago','T');

	if(dtoOferta.detalleOferta!=null&&dtoOferta.detalleOferta.length!=null) {
		for (var i=0;i<dtoOferta.detalleOferta.length;i++) {
			toAdd = toAdd + "oidDetalleOferta=" + dtoOferta.detalleOferta[i].oidDetalleOferta;
			toAdd = toAdd + "|" + "lineaOferta=" + (i + 1);
			toAdd = toAdd + "|" + "oidSAP=" + dtoOferta.detalleOferta[i].oidSAP;
			toAdd = toAdd + "|" + "codigoSAP=" + dtoOferta.detalleOferta[i].codigoSAP;
			toAdd = toAdd + "|" + "descripcion=" + dtoOferta.detalleOferta[i].descripcion;
			toAdd = toAdd + "|" + "unidadesEstimadas=" + dtoOferta.detalleOferta[i].unidadesEstimadas;
			toAdd = toAdd + "|" + "origen=" + constantePREMF;
			toAdd = toAdd + "|" + "factorRepeticion=" + dtoOferta.detalleOferta[i].factorRepeticion;
			toAdd = toAdd + "|" + "atributo1=" + dtoOferta.detalleOferta[i].atributo1;
			toAdd = toAdd + "|" + "atributo2=" + dtoOferta.detalleOferta[i].atributo2;
			toAdd = toAdd + "|" + "atributo3=" + dtoOferta.detalleOferta[i].atributo3;
			toAdd = toAdd + "|" + "digitable=" + dtoOferta.detalleOferta[i].digitable;
			toAdd = toAdd + "|" + "impresionGP=" + dtoOferta.detalleOferta[i].impresionGP;
			toAdd = toAdd + "|" + "posicionRanking=" + dtoOferta.detalleOferta[i].posicionRanking;
			toAdd = toAdd + "|" + "oidFormaPago=" + oidFormaPago;
			toAdd = toAdd + "|" + "descripcionFormaPago=" + descFormaPago;
			toAdd = toAdd + "|" + "numeroGrupo=" + dtoOferta.detalleOferta[i].numeroGrupo;
			toAdd = toAdd + "|" + "productoPrincipal=" + dtoOferta.detalleOferta[i].productoPrincipal;
			toAdd = toAdd + "|" + "precioCatalogo=" + dtoOferta.detalleOferta[i].precioCatalogo;
			toAdd = toAdd + "|" + "posicionPagina=" + dtoOferta.detalleOferta[i].posicionPagina;
			toAdd = toAdd + "|" + "precioPosicionamiento=" + dtoOferta.detalleOferta[i].precioPosicionamiento;
			toAdd = toAdd + "|" + "costeEstandar=" + dtoOferta.detalleOferta[i].costeEstandar;
			toAdd = toAdd + "|" + "ventaNetaEstimada=" + dtoOferta.detalleOferta[i].ventaNetaEstimada;
			toAdd = toAdd + "|" + "oidCatalogo=" + dtoOferta.detalleOferta[i].oidCatalogo;
			toAdd = toAdd + "|" + "paginaCatalogo=" + dtoOferta.detalleOferta[i].paginaCatalogo;
			toAdd = toAdd + "|" + "oidCondicionPromocion=" + dtoOferta.detalleOferta[i].oidCondicionPromocion;
			toAdd = toAdd + "|" + "oidTipoOferta=" + dtoOferta.detalleOferta[i].oidTipoOferta;
			toAdd = toAdd + "|" + "oidCicloVida=" + dtoOferta.detalleOferta[i].oidCicloVida;
			toAdd = toAdd + "|" + "matrizFacturacionGenerada=false";
			toAdd = toAdd + "|" + "oidGrupo=" + dtoOferta.detalleOferta[i].oidGrupo;
			toAdd = toAdd + "|" + "centro=" + dtoOferta.detalleOferta[i].centro;
			toAdd = toAdd + "|" + "codigoVentaGenerado=false";
			toAdd = toAdd + "|" + "codigoVenta=" + dtoOferta.detalleOferta[i].codigoVenta;
			toAdd = toAdd + "|" + "tipoOperacion=" + dtoOferta.detalleOferta[i].tipoOperacion;
			toAdd = toAdd + "|" + "programaFidelizacion=" + dtoOferta.detalleOferta[i].programaFidelizacion;
			toAdd = toAdd + "|" + "variantes=" + dtoOferta.detalleOferta[i].variantes;
			toAdd = toAdd + "|" + "puntajeFijo=" + dtoOferta.detalleOferta[i].puntajeFijo;
			toAdd = toAdd + "|" + "precioUnitario=" + dtoOferta.detalleOferta[i].precioUnitario;
			toAdd = toAdd + "|" + "descripcionCorta=" + dtoOferta.detalleOferta[i].descripcionCorta;
			toAdd = toAdd + "|" + "descripcionSAP=" + dtoOferta.detalleOferta[i].descripcionSAP;
			toAdd = toAdd + "|" + "descripcionTipoOferta=" + dtoOferta.detalleOferta[i].descripcionTipoOferta;
			toAdd = toAdd + "|" + "descripcionCicloVida=" + dtoOferta.detalleOferta[i].descripcionCicloVida;
			toAdd = toAdd + "|" + "descripcionCatalogo=" + dtoOferta.detalleOferta[i].descripcionCatalogo;
			toAdd = toAdd + "|" + "modificado=" + dtoOferta.detalleOferta[i].modificado;
			toAdd = toAdd + "|" + "programaFidelizacionMAE=" + dtoOferta.detalleOferta[i].programaFidelizacionMAE;
			toAdd = toAdd + "|" + "rangosPrecios=" + serializarRangosPrecios(i);
			toAdd = toAdd + "$";//separador de detalles
		}
	}

	return toAdd;
}

function serializarGrupos(){
	var toAdd = "";

	if(dtoOferta.grupo!=null&&dtoOferta.grupo.length!=null) {
		for (var i=0;i<dtoOferta.grupo.length;i++) {
			toAdd = toAdd + "numeroGrupo=" + dtoOferta.grupo[i].numeroGrupo;
			toAdd = toAdd + "|" + "factorCuadre=" + dtoOferta.grupo[i].factorCuadre;
			toAdd = toAdd + "|" + "indicadorGrupo=" + dtoOferta.grupo[i].indicadorGrupo;
			toAdd = toAdd + "|" + "condicionante=" + dtoOferta.grupo[i].condicionante;
			toAdd = toAdd + "|" + "condicionado=" + dtoOferta.grupo[i].condicionado;
			toAdd = toAdd + "|" + "oidIndicadorCuadre=" + dtoOferta.grupo[i].oidIndicadorCuadre;
			toAdd = toAdd + "|" + "descripcionIndicadorCuadre=" + dtoOferta.grupo[i].descripcionIndicadorCuadre;
			toAdd = toAdd + "$";
		}
	}

	return toAdd;
}

function serializarRangosPrecios(posicion){
	var toAdd = "";

	if(dtoOferta.detalleOferta[posicion].rangosPrecios!=null&&dtoOferta.detalleOferta[posicion].rangosPrecios.length!=null) {
		for (var i=0;i<dtoOferta.detalleOferta[posicion].rangosPrecios.length;i++) {
			toAdd = toAdd + "oidDetaOferPrec¿" + dtoOferta.detalleOferta[posicion].rangosPrecios[i].oidDetaOferPrec;
			toAdd = toAdd + "&" + "rangoDesde¿" + dtoOferta.detalleOferta[posicion].rangosPrecios[i].rangoDesde;
			toAdd = toAdd + "&" + "rangoHasta¿" + dtoOferta.detalleOferta[posicion].rangosPrecios[i].rangoHasta;
			toAdd = toAdd + "&" + "precioPosicionamiento¿" + dtoOferta.detalleOferta[posicion].rangosPrecios[i].precioPosicionamiento;
			toAdd = toAdd + "&" + "precioCatalogo¿" + dtoOferta.detalleOferta[posicion].rangosPrecios[i].precioCatalogo;
			toAdd = toAdd + "&" + "oidDetaOfer¿" + dtoOferta.detalleOferta[posicion].rangosPrecios[i].oidDetaOfer;
			toAdd = toAdd + "&" + "numeroOrdenRango¿" + dtoOferta.detalleOferta[posicion].rangosPrecios[i].numeroOrdenRango;
			toAdd = toAdd + "#";//separador de rangos de precios
		}
	}
	return toAdd;
}

function serializarVtasExclusivas(){
	var toAdd = "";

	if(dtoOferta.ventaExclusiva!=null&&dtoOferta.ventaExclusiva.length!=null) {
		for (var i=0;i<dtoOferta.ventaExclusiva.length;i++) {
			toAdd = toAdd + "oidVentaExclusiva=" + dtoOferta.ventaExclusiva[i].oidVentaExclusiva;
			toAdd = toAdd + "|" + "oidTipoCliente=" + dtoOferta.ventaExclusiva[i].oidTipoCliente;
			toAdd = toAdd + "|" + "descripcionTipoCliente=" + dtoOferta.ventaExclusiva[i].descripcionTipoCliente;
			toAdd = toAdd + "|" + "oidSubtipoCliente=" + dtoOferta.ventaExclusiva[i].oidSubtipoCliente;
			toAdd = toAdd + "|" + "descripcionSubtipoCliente=" + dtoOferta.ventaExclusiva[i].descripcionSubtipoCliente;
			toAdd = toAdd + "|" + "oidTipoClasificacion=" + dtoOferta.ventaExclusiva[i].oidTipoClasificacion;
			toAdd = toAdd + "|" + "descripcionTipoClasificacion=" + dtoOferta.ventaExclusiva[i].descripcionTipoClasificacion;
			toAdd = toAdd + "|" + "oidClasificacion=" + dtoOferta.ventaExclusiva[i].oidClasificacion;
			toAdd = toAdd + "|" + "descripcionClasificacion=" + dtoOferta.ventaExclusiva[i].descripcionClasificacion;
			toAdd = toAdd + "|" + "oidEstatus=" + dtoOferta.ventaExclusiva[i].oidEstatus;
			toAdd = toAdd + "|" + "descripcionEstatus=" + dtoOferta.ventaExclusiva[i].descripcionEstatus;
			toAdd = toAdd + "|" + "estatus2=" + dtoOferta.ventaExclusiva[i].estatus2;
			toAdd = toAdd + "|" + "oidRegion=" + dtoOferta.ventaExclusiva[i].oidRegion;
			toAdd = toAdd + "|" + "descripcionRegion=" + dtoOferta.ventaExclusiva[i].descripcionRegion;
			toAdd = toAdd + "|" + "oidZona=" + dtoOferta.ventaExclusiva[i].oidZona;
			toAdd = toAdd + "|" + "descripcionZona=" + dtoOferta.ventaExclusiva[i].descripcionZona;
			toAdd = toAdd + "|" + "tipoOperacion=" + dtoOferta.ventaExclusiva[i].tipoOperacion;
			toAdd = toAdd + "$";//separador de ventas excl
		}
	}

	return toAdd;
}

function serializarPromocion(){
	var toAdd = "";

	if(dtoOferta.promocion!=null&&dtoOferta.promocion.length!=null) {
		for (var i=0;i<dtoOferta.promocion.length;i++) {

			toAdd = toAdd + "oidPromocion=" + dtoOferta.promocion[i].oidPromocion;
			toAdd = toAdd + "|" + "numeroCondicion=" + dtoOferta.promocion[i].numeroCondicion;
			toAdd = toAdd + "|" + "oidIndicadorCuadre=" + dtoOferta.promocion[i].oidIndicadorCuadre;
			toAdd = toAdd + "|" + "descripcionIndicadorCuadre=" + dtoOferta.promocion[i].descripcionIndicadorCuadre;
			toAdd = toAdd + "|" + "factorCuadre=" + dtoOferta.promocion[i].factorCuadre;
			toAdd = toAdd + "|" + "tipoOperacion=" + dtoOferta.promocion[i].tipoOperacion;
			toAdd = toAdd + "|" + "lineaPromocion=" + serializarLineaPromocion(i);
			toAdd = toAdd + "$";//separador de detalles
		}
	}
	
	return toAdd;
}

function serializarLineaPromocion(i) {
	var toAdd = "";

	if(dtoOferta.promocion[i].lineaPromocion!=null &&
		dtoOferta.promocion[i].lineaPromocion.length!=null) {

		for (var j=0;j<dtoOferta.promocion[i].lineaPromocion.length;j++) {			

			toAdd = toAdd + "oidLineaPromocion¿" + 
			dtoOferta.promocion[i].lineaPromocion[j].oidLineaPromocion;

			toAdd = toAdd + "&" + "oidCatalogo¿" + 
			dtoOferta.promocion[i].lineaPromocion[j].oidCatalogo;
			
			toAdd = toAdd + "&" + "descripcionCatalogo¿" + 
			dtoOferta.promocion[i].lineaPromocion[j].descripcionCatalogo;
			
			toAdd = toAdd + "&" + "tipoRango¿" + 
			dtoOferta.promocion[i].lineaPromocion[j].tipoRango;
			
			if(dtoOferta.promocion[i].lineaPromocion[j].tipoRango=='P') {
				toAdd = toAdd + "&" + "numeroRangoInterno¿" + contadorProductos;
				contadorProductos++;
			}
			else if(dtoOferta.promocion[i].lineaPromocion[j].tipoRango=='L') {
				toAdd = toAdd + "&" + "numeroRangoInterno¿" + contadorLineasProductos;
				contadorLineasProductos++;
			}
			else {
				toAdd = toAdd + "&" + "numeroRangoInterno¿" + contadorPaginas;
				contadorPaginas++;
			}		
			
			toAdd = toAdd + "&" + "indicadorExclusion¿" + 
			dtoOferta.promocion[i].lineaPromocion[j].indicadorExclusion;
			
			toAdd = toAdd + "&" + "valorDesde¿" + 
			dtoOferta.promocion[i].lineaPromocion[j].valorDesde;
			
			toAdd = toAdd + "&" + "valorHasta¿" + 
			dtoOferta.promocion[i].lineaPromocion[j].valorHasta;
			
			toAdd = toAdd + "&" + "descripcionLineaProducto¿" + 
			dtoOferta.promocion[i].lineaPromocion[j].descripcionLineaProducto;
			
			toAdd = toAdd + "&" + "descripcionProducto¿" + 
			dtoOferta.promocion[i].lineaPromocion[j].descripcionProducto;
			
			toAdd = toAdd + "&" + "codigoProducto¿" + 
			dtoOferta.promocion[i].lineaPromocion[j].codigoProducto;
			
			toAdd = toAdd + "&" + "codigoLineaProducto¿" + 
			dtoOferta.promocion[i].lineaPromocion[j].codigoLineaProducto;
			
			toAdd = toAdd + "&" + "tipoOperacion¿" + 
			dtoOferta.promocion[i].lineaPromocion[j].tipoOperacion;

			toAdd = toAdd + "#";//separador de detalles
		}
	}

	return toAdd;
}



function agregarGrupo(dtoGrupo, posicion){

	if (posicion==null)
	{
		if(dtoOferta.grupo!=null&&dtoOferta.grupo.length!=null){
			posicion = dtoOferta.grupo.length;
		} else {
			posicion = 0;
			dtoOferta.grupo = new Array();			
		}
		dtoOferta.grupo[posicion]= new Object();
	}
	

	if (setear(dtoGrupo.numeroGrupo))
	{	dtoOferta.grupo[posicion].numeroGrupo = dtoGrupo.numeroGrupo;
	}
	if (setear(dtoGrupo.factorCuadre))
	{	dtoOferta.grupo[posicion].factorCuadre = dtoGrupo.factorCuadre;
	}
	if (setear(dtoGrupo.indicadorGrupo))
	{	dtoOferta.grupo[posicion].indicadorGrupo = dtoGrupo.indicadorGrupo;
	}
	if (setear(dtoGrupo.condicionante))
	{	dtoOferta.grupo[posicion].condicionante = dtoGrupo.condicionante;
	}
	if (setear(dtoGrupo.condicionado))
	{	dtoOferta.grupo[posicion].condicionado = dtoGrupo.condicionado;
	}
	if (setear(dtoGrupo.oidIndicadorCuadre))
	{	dtoOferta.grupo[posicion].oidIndicadorCuadre = dtoGrupo.oidIndicadorCuadre;
	}
	if (setear(dtoGrupo.descripcionIndicadorCuadre))
	{	dtoOferta.grupo[posicion].descripcionIndicadorCuadre = dtoGrupo.descripcionIndicadorCuadre;
	}
	if (setear(dtoGrupo.oidGrupo))
	{	dtoOferta.grupo[posicion].oidGrupo = dtoGrupo.oidGrupo;
	}
}

function agregarRangoPrecios(dtoRangoPrecios, posicionDetalle, posicion){

	if (posicion==null)
	{
		if(dtoOferta.detalleOferta[posicionDetalle].rangosPrecios!=null&&dtoOferta.detalleOferta[posicionDetalle].rangosPrecios.length!=null){
			posicion = dtoOferta.detalleOferta[posicionDetalle].rangosPrecios.length;
		} else {
			posicion = 0;
			dtoOferta.detalleOferta[posicionDetalle].rangosPrecios = new Array();			
		}
		dtoOferta.detalleOferta[posicionDetalle].rangosPrecios[posicion]= new Object();
	}
	
	if (setear(dtoRangoPrecios.oidDetaOferPrec))
	{	dtoOferta.detalleOferta[posicionDetalle].rangosPrecios[posicion].oidDetaOferPrec = dtoRangoPrecios.oidDetaOferPrec;
	}
	if (setear(dtoRangoPrecios.rangoDesde))
	{	dtoOferta.detalleOferta[posicionDetalle].rangosPrecios[posicion].rangoDesde = dtoRangoPrecios.rangoDesde;
	}
	if (setear(dtoRangoPrecios.rangoHasta))
	{	dtoOferta.detalleOferta[posicionDetalle].rangosPrecios[posicion].rangoHasta = dtoRangoPrecios.rangoHasta;
	}
	if (setear(dtoRangoPrecios.precioPosicionamiento))
	{	dtoOferta.detalleOferta[posicionDetalle].rangosPrecios[posicion].precioPosicionamiento = dtoRangoPrecios.precioPosicionamiento;
	}
	if (setear(dtoRangoPrecios.precioCatalogo))
	{	dtoOferta.detalleOferta[posicionDetalle].rangosPrecios[posicion].precioCatalogo = dtoRangoPrecios.precioCatalogo;
	}
	if (setear(dtoRangoPrecios.oidDetaOfer))
	{	dtoOferta.detalleOferta[posicionDetalle].rangosPrecios[posicion].oidDetaOfer = dtoRangoPrecios.oidDetaOfer;
	}
	if (setear(dtoRangoPrecios.numeroOrdenRango))
	{	dtoOferta.detalleOferta[posicionDetalle].rangosPrecios[posicion].numeroOrdenRango = dtoRangoPrecios.numeroOrdenRango;
	}
	if (setear(dtoRangoPrecios.modificado))
	{	dtoOferta.detalleOferta[posicionDetalle].rangosPrecios[posicion].modificado = dtoRangoPrecios.modificado;
	}
	
}

function superponeRangoPrecios(dtoRangoPrecios, posicion){

	if(dtoOferta.detalleOferta[posicion].rangosPrecios!=null&&dtoOferta.detalleOferta[posicion].rangosPrecios.length!=null) {
		var lonRanPre = dtoOferta.detalleOferta[posicion].rangosPrecios.length;
		for (var i=0;i<lonRanPre;i++) {
			if (superponeEsteRangoPrecios(dtoOferta.detalleOferta[posicion].rangosPrecios[i], dtoRangoPrecios)) {
				return true;
			}
		}
	} else {
		return false;
	}
}

function superponeEsteRangoPrecios(dtoRangoPrecios1,dtoRangoPrecios2){

	if((dtoRangoPrecios1.oidDetaOfer==dtoRangoPrecios2.oidDetaOfer) && ((parseInt(dtoRangoPrecios1.rangoDesde)<=parseInt(dtoRangoPrecios2.rangoDesde)) && (parseInt(dtoRangoPrecios1.rangoHasta)>=parseInt(dtoRangoPrecios2.rangoDesde)) ||
	   (parseInt(dtoRangoPrecios1.rangoDesde)<=parseInt(dtoRangoPrecios2.rangoHasta)) && (parseInt(dtoRangoPrecios1.rangoHasta)>=parseInt(dtoRangoPrecios2.rangoHasta)) ||
	   (parseInt(dtoRangoPrecios1.rangoDesde)>=parseInt(dtoRangoPrecios2.rangoDesde)) && (parseInt(dtoRangoPrecios1.rangoHasta)<=parseInt(dtoRangoPrecios2.rangoHasta)))) {
		return true;
	} else {
		return false;
	}

}