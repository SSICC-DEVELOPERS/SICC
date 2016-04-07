var arrLimpia = new Array();
var arrCbIdCuadre = null;

// ------------------------------------------------------------------------------------------------------------------------------------------------
function fGuardar() { 

	//Valido que haya ind cuadre si esta habilitado
	if (get('frmContenido.hDeshabilitarCombo')!='S'){
		if(!sicc_validaciones_generales("indCuadre")){
			return false;
		}
	}
	//Valido que haya Porducto  
	if (listado1.datos.length<1) {
		//alert("Debe ingresar un al menos un producto");
		GestionarMensaje('194');    
		return;
	}
	if (get('frmContenido.hDeshabilitarFactorCuadre')!='S'){
		//cambia por incidencia DBLG700000034
		if (get('frmContenido.cbIndicadorCuadre','V')=='4') {//Por Monto
		  if(!sicc_validaciones_generales("factCuadreDec")){
			 return false;
		  }
		} else {//Por Unidades
		  if(!sicc_validaciones_generales("factCuadre")){
			 return false;
		  }
		}
	}

	//Almaceno el grupo
	var dtoGrupo = new Object();

	dtoGrupo.numeroGrupo = new Object(parametros.grupoActual);
	dtoGrupo.factorCuadre = get('frmContenido.txtFactorCuadre');
	if (parametros.indicadorGrupo=='true') {
		dtoGrupo.indicadorGrupo = 'true';
	} else {
		dtoGrupo.indicadorGrupo = 'false';
	}
	if (parametros.condicionante=='true') {
		dtoGrupo.condicionante = 'true';
	} else {
		dtoGrupo.condicionante = 'false';
	}
	if (parametros.condicionado=='true') {
		dtoGrupo.condicionado = 'true';
	} else {
		dtoGrupo.condicionado = 'false';
	}	
	dtoGrupo.oidIndicadorCuadre = get('frmContenido.cbIndicadorCuadre','V');
	dtoGrupo.descripcionIndicadorCuadre = get('frmContenido.cbIndicadorCuadre','T');
  
	agregarGrupo(dtoGrupo);

	//Resuelvo que tipo de grupo es
	var numeroGrupos = new Number(parametros.numeroGrupos);
	var numeroPaquetes = new Number(parametros.numeroPaquetes);
	var grupoActual = new Number(parametros.grupoActual);
	if (numeroGrupos>0) {
		if (grupoActual<numeroGrupos) {
			parametros.grupoActual = grupoActual+1;
		} else {
			window.close();
			return;
		}
	} else {
		if (grupoActual<numeroPaquetes) {
			parametros.grupoActual = grupoActual+1;
		} else {
			window.close();
			return;
		}
	}

	cargarSiguienteGrupo();
	fLimpiar();
}

// ------------------------------------------------------------------------------------------------------------------------------------------------
function tabBoton(){

    if( get('frmContenido.hDeshabilitarCombo') == 'S' ) {
		focaliza('frmContenido.txtFactorCuadre','');
    } else {
		focaliza('frmContenido.cbIndicadorCuadre','');
    }
}

// ------------------------------------------------------------------------------------------------------------------------------------------------
function shTabBoton(){

    if( get('frmContenido.hDeshabilitarFactorCuadre') == 'S' ) {
		focaliza('frmContenido.cbIndicadorCuadre','');
    } else {
		focaliza('frmContenido.txtFactorCuadre','');
    }
}

// ------------------------------------------------------------------------------------------------------------------------------------------------
function shTabFactor(){

    if( get('frmContenido.hDeshabilitarCombo') == 'S' ) {
		document.all.BuscarDiv.focus();
    } else {
		focaliza('frmContenido.cbIndicadorCuadre','');
    }
}

// ------------------------------------------------------------------------------------------------------------------------------------------------
function tabCombo(){

    if( get('frmContenido.hDeshabilitarFactorCuadre') == 'S' ) {
		document.all.BuscarDiv.focus();
    } else {
		focaliza('frmContenido.txtFactorCuadre','');
    }
}

// ------------------------------------------------------------------------------------------------------------------------------------------------
function fLimpiar(){

	var len = listado1.codigos().length;

	if (dtoOferta.detalleOferta!=null&&dtoOferta.detalleOferta.length!=null) {
		var lon = new Number(dtoOferta.detalleOferta.length);
		var arrElim = new Array();
		for (var i=0;i<lon;i++){
			if (dtoOferta.detalleOferta[i].numeroGrupo==parametros.grupoActual) {
				dtoOferta.detalleOferta = miSplice(dtoOferta.detalleOferta,i);
				i--;
				lon--;
			}
		}
		listado1.eliminar(0,len);
	}

    if( get('frmContenido.hDeshabilitarFactorCuadre') != 'S' ) {
		set('frmContenido.txtFactorCuadre',arrLimpia[1]);
	}
    if( get('frmContenido.hDeshabilitarCombo') == 'S' ){
		focaliza('frmContenido.txtFactorCuadre','');
    } else {
		set('frmContenido.cbIndicadorCuadre',arrLimpia[0]);
		focaliza('frmContenido.cbIndicadorCuadre','');
    }
	asignarCombo();
}


// ------------------------------------------------------------------------------------------------------------------------------------------------
function fBorrar(){

	var codigo = "";
	codigo = listado1.codSeleccionados();
	var i = 0;

	if (listado1.numSelecc() < 1){
		GestionarMensaje('4');
		return;
	}

	if (listado1.numSelecc()>0) {
		if(GestionarMensaje("5")) {
			var arrElim = new Array();
			var lon = dtoOferta.detalleOferta.length;
			var cods = listado1.codSeleccionados();
			var dif = dtoOferta.detalleOferta.length - listado1.selecc.length; //V_PRE_32, eliminar solo lo seleccionado
			for (var i=0;i<lon;i++){
				for (var j=0;j<cods.length;j++){
					var key = dtoOferta.detalleOferta[i].oidSAP+dtoOferta.detalleOferta[i].descripcionTipoOferta+dtoOferta.detalleOferta[i].claveUnicaInterna;
					if (key==cods[j]&&dtoOferta.detalleOferta[i].numeroGrupo==parametros.grupoActual 
					    && listado1.selecc[i-dif]==1) { //V_PRE_32, eliminar solo lo seleccionado						
						arrElim[arrElim.length]=i;
					}
				}
			}
			for (var k=arrElim.length-1;k>=0;k--) {
				dtoOferta.detalleOferta = miSplice(dtoOferta.detalleOferta,arrElim[k]);
			}
			listado1.eliminarSelecc();
		}
	}
	if (listado1.datos.length > 0) {
		btnProxy(4, '1');
	} else {
		btnProxy(4, '0');
	}

}

// ------------------------------------------------------------------------------------------------------------------------------------------------
function onLoadPag()   {

	varNoLimpiarSICC=true;
	configurarMenuSecundario('frmContenido');

	parametros = window.dialogArguments.parametros;
	dtoOferta = window.dialogArguments.parametros.dtoOferta;

	if(get('frmContenido.casoDeUso')=='modificar'){
		btnProxy(2,"0");
		btnProxy(7,"0");
		btnProxy(8,"0");
	}
	DrdEnsanchaConMargenDcho('listado1',12);
	eval (ON_RSZ);  

	cargarSiguienteGrupo();

	asignarCombo();

	if( get('frmContenido.hDeshabilitarCombo') == 'S' ){
		accion('frmContenido.cbIndicadorCuadre', '.disabled="true"');
		focaliza('frmContenido.txtFactorCuadre');
	}
	if( get('frmContenido.hDeshabilitarFactorCuadre') == 'S' ){
		accion('frmContenido.txtFactorCuadre', '.disabled="true"');
		if( get('frmContenido.hDeshabilitarCombo') != 'S' )
			focaliza('frmContenido.cbIndicadorCuadre');
	}  
	if (listado1.datos.length > 0) {
		btnProxy(4, '1');
	} else {
		btnProxy(4, '0');
	}
	arrLimpia[0]= get('frmContenido.cbIndicadorCuadre');
	arrLimpia[1]= get('frmContenido.txtFactorCuadre');
	//set( 'frmContenido.txtFactorCuadre', get('frmContenido.hFactorCuadre') );
}

// ------------------------------------------------------------------------------------------------------------------------------------------------
function cargarSiguienteGrupo() {

	var numeroGrupos = new Number(parametros.numeroGrupos);
	var numeroPaquetes = new Number(parametros.numeroPaquetes);
	var numeroGruposCondicionantes = new Number(parametros.numeroGruposCondicionantes);
	var numeroGruposCondicionados = new Number(parametros.numeroGruposCondicionados);
	var grupoActual = new Number(parametros.grupoActual);
	var cuadreGrupos = parametros.cuadreGrupos;
	var grupoCondicionado = false;

	parametros.condicionante = 'false';
	parametros.indicadorGrupo = 'false';
	parametros.condicionado = 'false';

    if( numeroGrupos > 0 ) {
		txt_to('lblNGrupoX',parametros.grupoActual+' de '+parametros.numeroGrupos);
        if( grupoActual<=numeroGruposCondicionantes ){
			txt_to('lblTipoGrupoX','Grupo_condicionante');
			parametros.condicionante = 'true';
        } else if( grupoActual<=(numeroGruposCondicionantes+numeroGruposCondicionados) ){
            grupoCondicionado = true;
			txt_to('lblTipoGrupoX','Grupo_condicionado');
			parametros.condicionado = 'true';
        } else {
			txt_to('lblTipoGrupoX','Grupo');
			parametros.indicadorGrupo = 'true';
        }
		cargarIdCuadres(parametros.cargaComboIdCuadre,grupoCondicionado);
    } else {
		txt_to('lblNGrupoX',parametros.grupoActual+' de '+parametros.numeroPaquetes);
		txt_to('lblTipoGrupoX','Paquete');		
		set('frmContenido.hDeshabilitarFactorCuadre','S');
    }

	if (cuadreGrupos=='false'){
		set('frmContenido.hDeshabilitarCombo','S');
		set('frmContenido.valorCombo',parametros.oidIndCuadre);
	}
}

function cargarIdCuadres(lstIdCuadres,condicionado){

	if (arrCbIdCuadre==null) {
		arrCbIdCuadre = new Array();

		arrCbIdCuadre = lstIdCuadres.split("|");		
		for(var i=0;i<arrCbIdCuadre.length;i++) {
			var reg = arrCbIdCuadre[i].split("#");
			if (condicionado == false || (condicionado == true&&reg[1]!=get('frmContenido.cteCuadreTotalMontos'))){
				arrCbIdCuadre[i] = reg[0].split("&");
			}
		}
	}

	set_combo('frmContenido.cbIndicadorCuadre',arrCbIdCuadre);
} 

// ------------------------------------------------------------------------------------------------------------------------------------------------
function asignarCombo(){

	var seleccionados = new Array();

	seleccionados[0] = get('frmContenido.valorCombo');
	set('frmContenido.cbIndicadorCuadre', seleccionados);
}

// ------------------------------------------------------------------------------------------------------------------------------------------------
function buscar() {

	parametros.productoPrincipal = false;
	parametros.volverLPBuscarProducto = "LPCrearGrupoPerf";
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
		pasaListaProductosGrupo();
	}
	if (listado1.datos.length > 0) {
		btnProxy(4, '1');
	} else {
		btnProxy(4, '0');
	}
	focalizaPosicion();
}
// ------------------------------------------------------------------------------------------------------------------------------------------------
function focalizaPosicion(){
	if( get('frmContenido.hDeshabilitarCombo') == 'S' ) {
		focaliza('frmContenido.txtFactorCuadre');
	}
	if( get('frmContenido.hDeshabilitarFactorCuadre') == 'S' ) {
		if( get('frmContenido.hDeshabilitarCombo') != 'S' )
			focaliza('frmContenido.cbIndicadorCuadre');
	}  
}
// ------------------------------------------------------------------------------------------------------------------------------------------------
function pasaListaProductosGrupo() {

	len = listado1.codigos().length;

	if (len>0) {
		listado1.eliminar(0,len);
	}

	for (var i=0;i<dtoOferta.detalleOferta.length ;i++ ) {
		if (dtoOferta.detalleOferta[i].numeroGrupo==parametros.grupoActual) {
			var row = new Array();
			row[0] = dtoOferta.detalleOferta[i].oidSAP+dtoOferta.detalleOferta[i].descripcionTipoOferta+dtoOferta.detalleOferta[i].claveUnicaInterna;
			row[1] = dtoOferta.detalleOferta[i].codigoSAP;
			row[2] = dtoOferta.detalleOferta[i].descripcion;
			row[3] = dtoOferta.detalleOferta[i].descripcionTipoOferta;
			row[4] = dtoOferta.detalleOferta[i].descripcionCicloVida;
			row[5] = dtoOferta.detalleOferta[i].factorRepeticion;
			row[6] = numeroAsFormatoSICC(dtoOferta.detalleOferta[i].precioCatalogo);
			row[7] = dtoOferta.detalleOferta[i].atributo1;
			row[8] = dtoOferta.detalleOferta[i].atributo2;
			row[9] = dtoOferta.detalleOferta[i].atributo3;

			listado1.insertar(row);						
		}
	}
} 

// ------------------------------------------------------------------------------------------------------------------------------------------------
function arrayComponentes(){

	var arr = new Array();
	arr[arr.length]= new Array("cbIndicadorCuadre","");
	arr[arr.length]= new Array("txtFactorCuadre","");      
	arr[arr.length]= new Array("Buscar","BOTONXY");
	arr[arr.length]= new Array("Modificar","BOTONXY");
							
	return arr;
}

// ------------------------------------------------------------------------------------------------------------------------------------------------
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
			  if (tipotab == "sh") {if (k==0) k= arr.length;} else 
			  {if ((j+1)==arr.length)  j = -1;}                    
			}
		 }
	}
 }


// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// Añadida por ssantana, 5/10/2005
// Por cambio GCC-PRE-001.
 function accionModificarProducto() {

	 var codSeleccionados = listado1.codSeleccionados();

	 if ( codSeleccionados.length == 0) {
			GestionarMensaje("PRE0025", null, null, null);   // Debe seleccionar un producto.
	 } else {
		var lon = new Number(dtoOferta.detalleOferta.length);
		var loncodsel = new Number(codSeleccionados.length);
		for (var i=0;i<lon;i++){
			for (var j=0;j<loncodsel;j++){
				var key =dtoOferta.detalleOferta[i].oidSAP+dtoOferta.detalleOferta[i].descripcionTipoOferta+dtoOferta.detalleOferta[i].claveUnicaInterna;
				if (key==codSeleccionados[j]) {
					dtoOferta.detalleOferta[i].modificado = 'no';
				}
			}
		}
		parametros.productoPrincipal = false;
		parametros.volverLPBuscarProducto = "LPCrearGrupoPerf";
		parametros.multiseleccion = true;
		parametros.mostrarValoresAdicionales = false;

		var res = mostrarModalSICC("LPDatosProductoPerf", "", parametros, 1020, 410);   

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
			pasaListaProductosGrupo();
		}
		focalizaPosicion();
	 }
 }