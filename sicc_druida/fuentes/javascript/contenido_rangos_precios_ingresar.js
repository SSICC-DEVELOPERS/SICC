
var oidDetalle;
var posicionDetalle;

function onLoadPag()   {
	configurarMenuSecundario("formulario");	

	parametros = window.dialogArguments.parametros;
	dtoOferta = window.dialogArguments.parametros.dtoOferta;

	DrdEnsanchaConMargenDcho('listado1',24);
	document.all["Cplistado1"].style.visibility='';
	document.all["CpLin1listado1"].style.visibility='';
	document.all["CpLin2listado1"].style.visibility='';
	document.all["CpLin3listado1"].style.visibility='';
	document.all["CpLin4listado1"].style.visibility='';
	document.all["separaDiv"].style.visibility='hidden';
	document.all["primeraDiv"].style.visibility='hidden';
	document.all["retDiv"].style.visibility='hidden';
	document.all["avaDiv"].style.visibility='hidden';
	document.all["btnAnadirDiv"].style.visibility='';
	document.all["btnEliminarDiv"].style.visibility='';

	eval (ON_RSZ);  

	var an = screen.availWidth;
	var al = screen.availHeight;

	window.dialogWidth =an;
	window.dialogHeight =al;

	if (get('formulario.casoDeUso')=='modificar') {
		posicionDetalle = 0;
		dtoOferta.detalleOferta = new Object();
		dtoOferta.detalleOferta[posicionDetalle] = new Object();
		deserializarRangosPrecios();
		oidDetalle = get('formulario.hOidDetalle');
		parametros.precioPosicionamiento = get('formulario.hPrecioPosicionamiento');
	} else {
		posicionDetalle = parametros.posicion;
		oidDetalle = 'P'+parametros.oidSAP;//se asigna un oid provisorio porque el registro aun no existe en la BD.
	}

	cargarLista(oidDetalle);
	goToFirstField();
}
// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function deserializarRangosPrecios(){
		var rangosPrecios = get('formulario.hRangosSerializados');
		rangosPrecios = rangosPrecios.split("#");

		for (var i=0;i<(rangosPrecios.length-1);i++) {
				var rangoPrecios = rangosPrecios[i].split("&");
				if (rangoPrecios.length!=0) {
					var dtoRangoPrecios = new Object();
					for (var j=0;j<rangoPrecios.length;j++) {
								var propVal = rangoPrecios[j].split("¿");
								eval("dtoRangoPrecios."+propVal[0]+"="+propVal[1]);							
					}
					agregarRangoPrecios(dtoRangoPrecios, posicionDetalle);
				}
		}

}
// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function cargarLista(oidDetalle){
	if(dtoOferta.detalleOferta[posicionDetalle].rangosPrecios!=null&&dtoOferta.detalleOferta[posicionDetalle].rangosPrecios.length!=null){
		for (var i = 0; i < dtoOferta.detalleOferta[posicionDetalle].rangosPrecios.length ; i++) {
				if (oidDetalle==dtoOferta.detalleOferta[posicionDetalle].rangosPrecios[i].oidDetaOfer)	{
					var row = new Array();
					row[0] = dtoOferta.detalleOferta[posicionDetalle].rangosPrecios[i].oidDetaOferPrec;//oid
					row[1] = dtoOferta.detalleOferta[posicionDetalle].rangosPrecios[i].rangoDesde;//rango desde
					row[2] = dtoOferta.detalleOferta[posicionDetalle].rangosPrecios[i].rangoHasta;//rango hasta
					row[3] = numeroAsFormatoSICC(dtoOferta.detalleOferta[posicionDetalle].rangosPrecios[i].precioPosicionamiento);//precio posicionamiento
					row[4] = numeroAsFormatoSICC(dtoOferta.detalleOferta[posicionDetalle].rangosPrecios[i].precioCatalogo);//precio catalogo
			//		row[5] = dtoRangoPrecios.detalleOferta[posicionDetalle].oidDetaOfer;//oiddetalleoferta
			//		row[6] = dtoRangoPrecios.detalleOferta[posicionDetalle].numeroOrdenRango;//numeroordenrango

					listado1.insertar(row);
				}
		}
	}
}
// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function accionAnadir() {
	if(!sicc_validaciones_generales()){
	  return false;
	}                    

	var dtoRangoPrecios = new Object();

	dtoRangoPrecios.oidDetaOferPrec = nuevoOidDetaOferPrec();
	dtoRangoPrecios.rangoDesde = get('formulario.txtDesde');
	dtoRangoPrecios.rangoHasta = get('formulario.txtHasta');
	dtoRangoPrecios.precioPosicionamiento = get('formulario.txtPosic');
	dtoRangoPrecios.precioCatalogo = get('formulario.txtPrecioCat');
	dtoRangoPrecios.oidDetaOfer = oidDetalle;
	dtoRangoPrecios.modificado = 'nuevo';

	var precPos = numeroDeFormatoSICC(parametros.precioPosicionamiento, get("formulario.txtPrecioCat"));
	var precCata = numeroDeFormatoSICC(get("formulario.txtPrecioCat"), get("formulario.txtPrecioCat"));    

	if (parseInt(dtoRangoPrecios.rangoDesde)<=parseInt(dtoRangoPrecios.rangoHasta)) {	
		if (!superponeRangoPrecios(dtoRangoPrecios, posicionDetalle)){
			agregarRangoPrecios(dtoRangoPrecios, posicionDetalle);
			if (precCata>precPos) {
				 //En este caso muestro mensaje.
				 var res = GestionarMensaje('1289');       
				 if (res==false) return false;
			}
			var row = new Array();
			row[0] = dtoRangoPrecios.oidDetaOferPrec;//oid
			row[1] = dtoRangoPrecios.rangoDesde;//rango desde
			row[2] = dtoRangoPrecios.rangoHasta;//rango hasta
			row[3] = numeroAsFormatoSICC(dtoRangoPrecios.precioPosicionamiento);//precio posicionamiento
			row[4] = numeroAsFormatoSICC(dtoRangoPrecios.precioCatalogo);//precio catalogo

			listado1.insertar(row);

			set('formulario.txtDesde','');
			set('formulario.txtHasta','');
			set('formulario.txtPosic','');
			set('formulario.txtPrecioCat','');
			goToFirstField();
		} else {
			cdos_mostrarAlert(GestionarMensaje('256'));//msg "El Rango se superpone con uno ya existente."
		}
	} else {
		cdos_mostrarAlert(GestionarMensaje('257'));//msg "El campo 'Cantidad Desde' debe ser menor al valor del campo 'Cantidad Hasta'"
	}
}
// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function nuevoOidDetaOferPrec(){

	if(dtoOferta.detalleOferta[posicionDetalle].rangosPrecios!=null&&dtoOferta.detalleOferta[posicionDetalle].rangosPrecios.length!=null) {
		var lonRanPre = dtoOferta.detalleOferta[posicionDetalle].rangosPrecios.length;
		var oidRanPre = new Number(1);
		for (var i=0;i<lonRanPre;i++) {
			var oidRanPreDTO = new Number(dtoOferta.detalleOferta[posicionDetalle].rangosPrecios[i].oidDetaOferPrec);
			if (oidRanPreDTO>oidRanPre) {				
				oidRanPre = oidRanPreDTO;
			}
		}
		oidRanPre = oidRanPre + 1;
		return oidRanPre;
	} else {
		return new Number(1);
	}

}
// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function accionEliminar() {
  if (listado1.numSelecc()>0){
		if(GestionarMensaje("5")){
			var arrElim = new Array();
			var lon = dtoOferta.detalleOferta[posicionDetalle].rangosPrecios.length;
			var cods = listado1.codSeleccionados();
			for (var i=0;i<lon;i++){
				for (var j=0;j<cods.length;j++){
					if (dtoOferta.detalleOferta[posicionDetalle].rangosPrecios[i].oidDetaOferPrec==cods[j]) {
						arrElim[arrElim.length]=i;
					}
				}
			}
			for (var k=arrElim.length-1;k>=0;k--){
				dtoOferta.detalleOferta[posicionDetalle].rangosPrecios = miSplice(dtoOferta.detalleOferta[posicionDetalle].rangosPrecios,arrElim[k]);
			}
			listado1.eliminarSelecc();
		}
  } else {
		GestionarMensaje("4");
  }
}
// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function fBorrar() {
	accionEliminar();
}
// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function fLimpiar() {
		set('formulario.txtDesde','');
		set('formulario.txtHasta','');
		set('formulario.txtPosic','');
		set('formulario.txtPrecioCat','');
		if (dtoOferta.detalleOferta[posicionDetalle].rangosPrecios!=null&&dtoOferta.detalleOferta[posicionDetalle].rangosPrecios.length!=null) {
			var lon = new Number(dtoOferta.detalleOferta[posicionDetalle].rangosPrecios.length);
			var arrElim = new Array();
			for (var i=0;i<lon;i++){
				if (dtoOferta.detalleOferta[posicionDetalle].rangosPrecios[i].modificado=='nuevo') {
					dtoOferta.detalleOferta[posicionDetalle].rangosPrecios = miSplice(dtoOferta.detalleOferta[posicionDetalle].rangosPrecios,i);
					i--;
					lon--;
				}
			}

			len = listado1.codigos().length;

			if (len>0){
				listado1.eliminar(0,len);
			}

			for (var i=0;i<lon;i++){
				var row = new Array();
				row[0] = dtoOferta.detalleOferta[posicionDetalle].rangosPrecios[i].oidDetaOferPrec;//oid
				row[1] = dtoOferta.detalleOferta[posicionDetalle].rangosPrecios[i].rangoDesde;//rango desde
				row[2] = dtoOferta.detalleOferta[posicionDetalle].rangosPrecios[i].rangoHasta;//rango hasta
				row[3] = numeroAsFormatoSICC(dtoOferta.detalleOferta[posicionDetalle].rangosPrecios[i].precioPosicionamiento);//precio posicionamiento
				row[4] = numeroAsFormatoSICC(dtoOferta.detalleOferta[posicionDetalle].rangosPrecios[i].precioCatalogo);//precio catalogo
				listado1.insertar(row);
			}
		}	

		
}
// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function fVolver() {
	window.close();
}
// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function fGuardar(){
	guardar();
}
// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function guardar(){

	//ordenamiento de los rangos
	if(dtoOferta.detalleOferta[posicionDetalle].rangosPrecios!=null&&dtoOferta.detalleOferta[posicionDetalle].rangosPrecios.length!=null) {
		var lonRanPre = dtoOferta.detalleOferta[posicionDetalle].rangosPrecios.length;
		for (var i=1; i<lonRanPre; i++) {
			  for (var j=0 ; j<lonRanPre - 1; j++) {
				  if (parseInt(dtoOferta.detalleOferta[posicionDetalle].rangosPrecios[j].rangoDesde) > parseInt(dtoOferta.detalleOferta[posicionDetalle].rangosPrecios[j+1].rangoDesde)) {
						temp = dtoOferta.detalleOferta[posicionDetalle].rangosPrecios[j];
						dtoOferta.detalleOferta[posicionDetalle].rangosPrecios[j] = dtoOferta.detalleOferta[posicionDetalle].rangosPrecios[j+1];
						dtoOferta.detalleOferta[posicionDetalle].rangosPrecios[j+1] = temp;
				  }
			  }
		}


	}

	if(dtoOferta.detalleOferta[posicionDetalle].rangosPrecios!=null&&dtoOferta.detalleOferta[posicionDetalle].rangosPrecios.length!=null) {
		var lonRanPre = dtoOferta.detalleOferta[posicionDetalle].rangosPrecios.length;
		for(var i=0;i<lonRanPre;i++){
			dtoOferta.detalleOferta[posicionDetalle].rangosPrecios[i].numeroOrdenRango = (i+1);
			dtoOferta.detalleOferta[posicionDetalle].rangosPrecios[i].modificado = 'si';
		}
	}

	if (get('formulario.casoDeUso')=='modificar') {
		set('formulario.hRangosSerializados',serializarRangosPrecios(0));
		set("formulario.conectorAction", "LPDatosProducto");
		set("formulario.accion", "procesar Rangos");
		enviaSICC("formulario");
	}
	window.close();
}
// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function goToFirstField(){
	focaliza(getFirstField() ,'');
}
// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function goToLastField(){
	focaliza(getLastField() ,'');
}

// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// Para tenerlo en un solo lado 
function getFirstField(){
	return "formulario.txtDesde";
}
	
// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function getLastField(){
	return "formulario.txtPrecioCat";
}