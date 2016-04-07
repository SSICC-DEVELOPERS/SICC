var FORMULARIO = "frmContenido"

function onLoadPag()   
{
    
    configurarMenuSecundario(FORMULARIO);
	var opcion = get(FORMULARIO+'.opcionMenu');
    DrdEnsanchaConMargenDcho('listado1',12);
	    
    document.all["Cplistado1"].style.visibility='';
    document.all["CpLin1listado1"].style.visibility='';
    document.all["CpLin2listado1"].style.visibility='';
    document.all["CpLin3listado1"].style.visibility='';
    document.all["CpLin4listado1"].style.visibility='';

    document.all["primera1Div"].style.visibility='';
    document.all["ret1Div"].style.visibility='';
    document.all["ava1Div"].style.visibility='';
    document.all["separaDiv"].style.visibility='';

	visibilidad('capaSeguro','O');
	visibilidad('capaPerdida1','O');
	visibilidad('capaPerdida2','O');
	visibilidad('capaLista','O');
	document.all["cbAsumePerdida"][0].disabled = true;
	focaliza(FORMULARIO + '.txtCodCliente');

    eval (ON_RSZ);  
}

function onClickBuscar(){
	/*Se comprueba que se han seleccionado al menos dos de los criterios de búsqueda de la pantalla: 
	Llamamos a configurarPaginado pasándole los siguientes parametros: 
	- Objeto paginado (lstResultado) 
	- idBusiness ("RECObtenerClientes") 
	- "ConectorObtenerClientesREC" 
	- "DTOBuscarClientesREC" --> RECObtenerClientesIntroducir
	- Parametros del DTOBuscarClientesREC: 
	- codigoCliente = codigoCliente 
	- nombre = nombre 
	- apellidoPaterno = apellidoPaterno 
	- apellidoMaterno = apellidoMaterno 
	- oidTipoCliente= oid del valor seleccionado en la cbTipoCliente*/
	
	
	var codigoCliente = get(FORMULARIO + '.txtCodCliente');
	var nombre = get(FORMULARIO + '.txtNomCliente');
	var apellidoPaterno = get(FORMULARIO + '.txtApellidoPaterno');
	var apellidoMaterno = get(FORMULARIO + '.txtApellidoMaterno');
	var oidTipoCliente = get(FORMULARIO + '.cbTipoCliente');
	
	var datosFormulario = [codigoCliente, nombre, apellidoPaterno, apellidoMaterno, oidTipoCliente];
	
	var contador = 0;
	if(codigoCliente != '') contador ++;
	if(nombre != '') contador ++;
	if(apellidoPaterno != '') contador ++;
	if(apellidoMaterno != '') contador ++;
	if(oidTipoCliente != '') contador ++;
	
	
	var pais = get(FORMULARIO + '.pais');
	var idioma = get(FORMULARIO + '.idioma');

	if (contador >=2){
	
		configurarPaginado(mipgndo,"RECObtenerClientes","ConectorObtenerClientesREC",
			"es.indra.sicc.dtos.rec.DTOBuscarClientesREC",
			[["oidPais", pais], ["oidIdioma", idioma], ["codigoCliente", codigoCliente],
			["nombre", nombre], ["apellidoPaterno", apellidoPaterno], 
			["apellidoMaterno", apellidoMaterno], ["oidTipoCliente", oidTipoCliente]]);
		
	} else{
		GestionarMensaje('1389','dos','','');
	}
}

function visibleLista() {
        
    visibilidad('capaLista','V');
    DrdEnsanchaConMargenDcho('listado1',12);
    eval (ON_RSZ);  
    visibilidad('capaPerdida1','V');
	visibilidad('capaPerdida2','V');
}

function noVisibleLista() {
    visibilidad('capaLista','O');
    visibilidad('capaPerdida1','O');
	visibilidad('capaPerdida2','O');
}

function muestraLista( ultima, rowset){
          
    var tamano = rowset.length;
    if (tamano > 0) {
         visibleLista();
         return true;
    } else {
         noVisibleLista();
         // No se ha encontrado ningún elemento con los criterios especificados
         //Control del foco
         focaliza(FORMULARIO+'.txtCodCliente');
         return false;
    }
}

function onSelectedLstResultado(){
	if (listado1.numSelecc() > 1){
	    //Muesta el mensaje: "Debe seleccionar un solo registro"
		GestionarMensaje('8');
	
		var seleccion=listado1.codigos();
		document.all["cbAsumePerdida"][0].disabled = true;
		var i=0;
		while(seleccion[i]!=null){
			listado1.deselecciona(i); 
			i++; 
		}
	} else if (listado1.numSelecc() == 1){
		document.all["cbAsumePerdida"][0].disabled = false;
	} else{
		document.all["cbAsumePerdida"][0].disabled = true;
	}
	if (listado1.numSelecc() != 1){
		set(FORMULARIO + '.cbPrecioCalculo',[]);
		visibilidad('capaSeguro', 'O');
		visibilidad('capaCliente', 'O');
	}
}

function onClickAceptar(){
	var oid = get(FORMULARIO + '.cbAsumePerdida');
	visibilidad('capaSeguro', 'O');
	visibilidad('capaCliente', 'O');
	
	if (oid == get(FORMULARIO + '.asumeBelcorp')){
		devuelveDatos();
	}else{
		if (oid == get(FORMULARIO + '.asumeCliente')){
			//- cbPrecioCalculo = valor del campo 'precioCalculo' (y su oid asociado) del registro seleccionado en lstResultado 
			set(FORMULARIO + '.cbPrecioCalculo',[listado1.extraeDato(listado1.codSeleccionados(),6)]);
			//- porcentRecargo = valor del campo 'porcentRecargo' del registro seleccionado en lstResultado 
			set(FORMULARIO + '.txtPorcentajeRecargo', listado1.extraeDato(listado1.codSeleccionados(),8));

			visibilidad('capaCliente', 'V');
			//-> Si el campo 'paramModificacion' del registro seleccionado en lstResultado es 'True' habilitar los campos de la capa 'Datos del Cliente'. 
			//-> Si no, mostrarlos deshabilitados. 
		
			var paramModificacion = listado1.extraeDato(listado1.codSeleccionados(),9);
			if (paramModificacion){
				document.all["cbPrecioCalculo"][0].disabled = false;
				document.all["txtPorcentajeRecargo"][0].disabled = false;
				document.all["btnCalcularPerdida"].disabled = false;
			} else{
				document.all["cbPrecioCalculo"][0].disabled = true;
				document.all["txtPorcentajeRecargo"][0].disabled = true;
				document.all["btnCalcularPerdida"].disabled = true;
			}
		}
		else{
			if (oid == get(FORMULARIO + '.asumeSeguro')){
				visibilidad('capaSeguro', 'V');
			}
		}
	}
}

function onClickBuscarProducto(){
	set(FORMULARIO + '.accion','buscarProducto');
	var accion = get( FORMULARIO +'.accion');
	var objParams = new Object();
	objParams.accion = accion;
	objParams.opcionMenu = "modificar operacion";
	objParams.idioma = get(FORMULARIO+'.idioma');
	objParams.pais= get(FORMULARIO+'.pais');

	var codigoProducto = mostrarModalSICC('LPCapturaProcesoReclamos', 'buscarProducto', objParams, null, null);
	if(typeof codigoProducto!='undefined') {
		set(FORMULARIO + '.txtProducto', codigoProducto);
    }
}

function onClickCalcular(){
	devuelveDatos();
}

function fGuardar(){
	onAccionCerrarGuardar();
}

function fVolver(){
  	window.close();
}

function onAccionCerrarGuardar(){
	var oid = get(FORMULARIO + '.cbAsumePerdida');
	if (listado1.numSelecc() == 0) {
			// Muestra el mensaje: "Debe seleccionar un elemento de la lista"
	      	GestionarMensaje('50');
  	}else {                                                                                        
		if (listado1.numSelecc() != 1 ) {                                    
	        //Muesta el mensaje: "Debe seleccionar un solo registro"
	 		GestionarMensaje('8');
	 	}else if (oid == get(FORMULARIO + '.asumeSeguro')){
			if (sicc_validaciones_generales('grupo2')){
				set(FORMULARIO + '.accion', 'comprobarProducto');
				set(FORMULARIO + '.conectorAction',"LPCapturaProcesoReclamos");
				enviaSICC(FORMULARIO);
			}
		} else{
			if (sicc_validaciones_generales('grupo1')){
				devuelveDatos();
			}
		}
	}
}

function ejecutarCorrecta(oidProducto, oidCliente){
	if (oidProducto == 'null'){
		GestionarMensaje('150001');
	} else if (oidCliente == 'null'){
		cdos_mostrarAlert(GestionarMensaje('UICAL0003'));
	}
	else{
		set(FORMULARIO + '.oidProducto', oidProducto);
		set(FORMULARIO + '.oidClienteSeguro', oidCliente);
		devuelveDatos();
	}
}

function devuelveDatos(){
	var oid = listado1.codSeleccionados();
	var cbAsumePerdida = get(FORMULARIO + '.cbAsumePerdida');
	var cbPrecioCalculo = get(FORMULARIO + '.cbPrecioCalculo');
	var txtPorcentajeRecargo = get(FORMULARIO + '.txtPorcentajeRecargo');
	var txtProducto = get(FORMULARIO + '.oidProducto');
	var txtCodClienteSeguro = get(FORMULARIO + '.oidClienteSeguro');
	var txtImporte = get(FORMULARIO + '.txtImporte');
	
	window.returnValue = [oid, cbAsumePerdida, cbPrecioCalculo, txtPorcentajeRecargo, txtProducto, txtCodClienteSeguro, txtImporte];
	window.close();
}

function buscarCliente(){
	//Llamamos al proceso correspondiente Modal
    var objParams = new Object();
    var cliente = mostrarModalSICC('LPBusquedaRapidaCliente', '', objParams, null, null);           

    if(typeof cliente!='undefined') {
          var codigoCliente = cliente[1];
          set(FORMULARIO+'.txtCodCliente',codigoCliente);
    }
}

function buscarClienteSeguro(){
	//Llamamos al proceso correspondiente Modal
    var objParams = new Object();
    var cliente = mostrarModalSICC('LPBusquedaRapidaCliente', '', objParams, null, null);           

    if(typeof cliente!='undefined') {
          var codigoCliente = cliente[1];
          var oidClienteSeguro = cliente[0];
          set(FORMULARIO+'.txtCodClienteSeguro',codigoCliente);
          set(FORMULARIO+'.oidClienteSeguro',oidClienteSeguro);
    }
}

function validaMonto(monto, enteros) {
    monto = monto + "";
    if (monto != "") {
    	return ValidaMilesDecimalesNegativo(monto, enteros, get(FORMULARIO + '.hid_NumeroDecimales'), get(FORMULARIO + '.hid_SeparadorMiles'), get(FORMULARIO + '.hid_SeparadorDecimales'), 0);
    } 
    return 'OK';
}

function fLimpiar(){
	visibilidad('capaSeguro','O');
	document.all["cbAsumePerdida"][0].disabled = true;
	visibilidad('capaCliente','O');
	focaliza(FORMULARIO + '.txtCodCliente');
}

function shTabCliente(){
	if (get_visibilidad('capaCliente')){
		document.all['btnCalcularPerdida'].focus();
	}else if (get_visibilidad('capaSeguro')){
		document.all['btnBuscarProducto'].focus();
	}else if (get_visibilidad('capaPerdida2')){
		document.all['btnAceptar'].focus();
	}else{
		document.all['btnBuscar'].focus();
	}
}

function tabBuscar(){
	if (get_visibilidad('capaPerdida2')){
		focaliza(FORMULARIO + '.cbAsumePerdida');
	}else{
		focaliza(FORMULARIO + '.txtCodCliente');
	}
}

function tabAceptar(){
	if (get_visibilidad('capaCliente')){
		focaliza(FORMULARIO + '.cbPrecioCalculo');
	}else if (get_visibilidad('capaSeguro')){
		focaliza(FORMULARIO + '.txtProducto');
	}else{
		focaliza(FORMULARIO + '.txtCodCliente');
	}
}

function textCodClienteOnBlur() {
    var codigoCliente = get(FORMULARIO+'.txtCodCliente').toString();
    if (codigoCliente != '') {
          var longitudCodigoCliente = get(FORMULARIO+'.longitudCodigoCliente').toString();
          var longitud = codigoCliente.length;
          set(FORMULARIO+'.txtCodCliente',rellenaCeros(codigoCliente,longitudCodigoCliente,longitud))
    }
}

function textCodClienteOnBlur2() {
    var codigoCliente = get(FORMULARIO+'.txtCodClienteSeguro').toString();
    if (codigoCliente != '') {
          var longitudCodigoCliente = get(FORMULARIO+'.longitudCodigoCliente').toString();
          var longitud = codigoCliente.length;
          set(FORMULARIO+'.txtCodClienteSeguro',rellenaCeros(codigoCliente,longitudCodigoCliente,longitud))
    }
}


function onChangeCliente(){
	set(FORMULARIO + '.accion', 'comprobarCliente');
	set(FORMULARIO + '.conectorAction',"LPCapturaProcesoReclamos");
	enviaSICC(FORMULARIO,'','','N');
}

function onChangeProducto(){
	set(FORMULARIO + '.accion', 'modificarProducto');
	set(FORMULARIO + '.conectorAction',"LPCapturaProcesoReclamos");
	enviaSICC(FORMULARIO,'','','N');
}

function asignarDatosCliente(oid){
	if (oid != 'null'){
		set(FORMULARIO + '.oidClienteSeguro', oid);
	}else{
		//No creo que esto sea asi
		GestionarMensaje('REC016');
	}
}

function asignarDatosProducto(oid){
	if (oid != 'null'){
		set(FORMULARIO + '.oidProducto', oid);
	}else{
		//No creo que esto sea asi
		GestionarMensaje('REC017');
		focaliza(FORMULARIO + '.txtProducto');
	}
}