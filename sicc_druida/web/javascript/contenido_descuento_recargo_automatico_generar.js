/**
* Copyright 2005 © por Indra Sistemas,S.A.. Todos los derechos reservados.
* Avda. de Bruselas, 35
* Parque Empresarial Arroyo de la Vega
* 28108 Alcobendas, Madrid
* España
*
* Privado y Confidencial.
* La información contenida en este documento es propiedad de Indra sistemas.
* Para uso exclusivo de empleados autorizados no permitiéndose
* la distribución de este código sin permiso expreso.
*/ 

var FORMULARIO = "frmCapturarCupon";
var POSICIONOID = 0;
var POSICIONENTIDADES = 14;

function onLoadPag(){
	configurarMenuSecundario(FORMULARIO);
	window.onunload = desbloquear;
    window.onbeforeunload = desbloquear;

	var errDescripcion = get(FORMULARIO +'.errDescripcion');
	if(get(FORMULARIO + '.errCodigo') == '230340061'){
	   GestionarMensaje('2630',errDescripcion);
	   fSalir(true);
	}else{
	   if (errDescripcion !='') {		
		  var errCodigo = get(FORMULARIO+'.errCodigo');
		  var wnd = fMostrarMensajeError(errCodigo, errDescripcion);
	   }  
	}

	

	DrdEnsanchaConMargenDcho('listado1',12);
	document.all["Cplistado1"].style.visibility='';
	document.all["CpLin1listado1"].style.visibility='';
	document.all["CpLin2listado1"].style.visibility='';
	document.all["CpLin3listado1"].style.visibility='';
	document.all["CpLin4listado1"].style.visibility='';
	// Elementos de la lista editable paginada. Como no lo es, no existen.
	//document.all["primera1Div"].style.visibility='';
	//document.all["ret1Div"].style.visibility='';
	//document.all["ava1Div"].style.visibility='';
	//document.all["separaDiv"].style.visibility='';
	eval(ON_RSZ);
	visibilidad('capaLista','V');
  	focaliza(FORMULARIO+'.cbEmpresa');
}

function btnInsertarOnTab(){
	focaliza(FORMULARIO + ".cbEmpresa");		
}

function btnConfirmarOnshTab(){
	focaliza(FORMULARIO+'.textImporteFijo');
}

function cbEmpresaOnShTab(){
	if (get_visibilidad("capaLista")) {
		document.all['Insertar'].focus();
	}else{
		document.all['btnBuscar'].focus();
	}	
}

function onTabImpFijo(){
	document.all['Confirmar'].focus();
}

function vaciaCombo(combo) {
	set_combo(combo,[['','']],['']);
}

function textCodClienteOnBlur(nombreElemento){
	var codigoCliente = get(FORMULARIO+'.'+nombreElemento).toString();
	if (codigoCliente != '') {
		var longitudCodigoCliente = get(FORMULARIO+'.longitudCodigoCliente').toString();
		var longitud = codigoCliente.length;
		set(FORMULARIO+'.'+nombreElemento,rellenaCeros(codigoCliente,longitudCodigoCliente,longitud))
	}
}

function canalOnChange() {
	var canal =get(FORMULARIO + '.cbCanal');
	vaciaCombo(FORMULARIO + '.cbAcceso');
	vaciaCombo(FORMULARIO + '.cbSubacceso');
	if (canal != ""){
		var oididioma = get(FORMULARIO+'.idioma');    
		var oidpais = get(FORMULARIO+'.pais');                             
		recargaCombo(FORMULARIO+'.cbAcceso', 'SEGObtieneAccesosPorCanal', 'es.indra.sicc.util.DTOOID', [['oidIdioma',oididioma],['oidPais',oidpais],['oid', canal]]);
	}
}

function accesoOnChange() {
	/*Para ello utilizamos el "<<subsystem:soporte>> RecargaCombos" pasándole los parámetros: 
	*idBusiness="SEGObtenerSubaccesosPorAcceso" 
	*DTOOID (Contendrá el oid del Acceso seleccionado) 
	*
	*- Obtenemos un "dtoSalida:DTOSalida" 
	*- Con el "dtoSalida.resultado" obtenido cargamos el COMBO "subAcceso   
	*/
	var acceso =get(FORMULARIO + '.cbAcceso');
	vaciaCombo(FORMULARIO + '.cbSubacceso');
	if (acceso!=""){		
		var idBusiness="SegObtenerSubaccesosPorAcceso";
		var dtooid = "es.indra.sicc.util.DTOOID";
		var oidpais = get(FORMULARIO+'.pais');
		var oididioma = get(FORMULARIO+'.idioma'); 
		recargaCombo(FORMULARIO+'.cbSubacceso', idBusiness, dtooid, [['oidPais',oidpais],['oidIdioma',oididioma],['oid', acceso]]);
	}
}

function popupCliente(nombreElemento){
	var objParams = new Object();
	var cliente = mostrarModalSICC('LPBusquedaRapidaCliente', '', objParams, null, null);   
	if (typeof(cliente)!='undefined') {
		var codigoCliente = cliente[1];
		set(FORMULARIO+'.'+nombreElemento,codigoCliente);
	}
}


function validaFecha(nombreElemento) {
	var fecha = get(FORMULARIO+'.'+nombreElemento);
	if (fecha != '') {
		var resul = EsFechaValida(fecha,fecha, FORMULARIO,null);
		if(resul==1 || resul==2){  
		// Muestra el mensaje: La fecha es incorrecta
			GestionarMensaje('947',FORMULARIO+'.'+nombreElemento);
			focaliza(FORMULARIO+'.'+nombreElemento);
			return false;
		}
	}
}

// Modificado por el cambio de diseño
function btnInsertar() {
	// Validamos si los datos insertados son válidos
	if(sicc_validaciones_generales()){
		var oidEmpresa = get(FORMULARIO+'.cbEmpresa');
		var oidSubproceso = get(FORMULARIO+'.cbSubproceso');
		var diasCadencia = get(FORMULARIO+'.textDiasCadencia');
		var diasCorte = get(FORMULARIO+'.textDiasCorte');
		var tipoInteres = get(FORMULARIO+'.textTipoInteres');
		var importeFijoDtoRecargo = get(FORMULARIO+'.textImporteFijo');
		var objParams = new Object();
   		/*var datos = [['oidEmpresa', oidEmpresa], ['oidSubproceso', oidSubproceso], 
					['diasCarencia', diasCarencia], ['diasCorte', diasCorte], 
					['tipoInteres', tipoInteres], ['importeFijoDtoRecargo', importeFijoDtoRecargo]];
		*/
		objParams.oidEmpresa = oidEmpresa;
		objParams.oidSubproceso = oidSubproceso;
		objParams.diasCadencia = diasCadencia;
		objParams.diasCorte = diasCorte;
		objParams.tipoInteres = tipoInteres;
		objParams.importeFijoDtoRecargo = importeFijoDtoRecargo;
		var elementosDevueltos = mostrarModalSICC('LPGenerarDtoRecargo', 'insertar', objParams, null, null);
		if((elementosDevueltos==null)||(typeof(elementosDevueltos)=='undefined')||
								(elementosDevueltos.length==0)){
			return false;
		}
		// Si no estaban ya en la lista, los añadimos
		var tamElementosDevueltos = elementosDevueltos.length;
		var encontrado;
		var tamDatos = listado1.datos.length;
		var i;
		var j;

		// Recorremos todos los elementos de la lista
		for(i = 0; i<tamElementosDevueltos; i++) {
			encontrado = false;
			
			// Busco el elemento i en los elementos que ya están en la lista
			for(j = 0; j<tamDatos; j++){
				// Compruebo si está en la lista
				if((listado1[j][POSICIONOID] == elementosDevueltos[i][POSICIONOID])&&
					(listado1[j][POSICIONENTIDADES] == elementosDevueltos[i][POSICIONENTIDADES])){
					encontrado = true;
					break;
				}
			}

			// Si no lo hemos encontrado, lo añadimos
			if(encontrado==false){
				listado1.insertar(elementosDevueltos[i]);
			}
		}
        listado1.reajusta();
	}
}

function soloNumeros(cantidad){
	var str=cantidad;
	var s;
	var sepMil = get(FORMULARIO+'.hid_SeparadorMiles');
	var sepDec = get(FORMULARIO+'.hid_SeparadorDecimales');
	var numero = true;
	for(var i=0;i<str.length;i++){
		s=str.charAt(i);
		if((s!=sepDec)&&(s!=sepMil)&&(isNaN(parseInt(s)))){
			numero = false;
		}
	}
	return(numero);
}


function validarTipoInteres(){
	if(sicc_validaciones_generales("gTipoInteres")){
		return;
	}
}


function esValorNumerico(cajaTexto, enteros){
	
	var separadorMiles = get(FORMULARIO + '.hid_SeparadorMiles');
	var separadorDecimales = get(FORMULARIO + '.hid_SeparadorDecimales');
	var valor = get(FORMULARIO + '.' + cajaTexto);
                  
	if (valor != "") {
		var mensaje = ValidaMilesDecimales(valor, enteros, get(FORMULARIO + '.hid_NumeroDecimales'), separadorMiles, separadorDecimales, 0);
	    if (mensaje != 'OK') {
	    	cdos_mostrarAlert(mensaje);
			focaliza(FORMULARIO + '.' + cajaTexto);
			return;
	    }
		var base = obtieneNumeroDecimal(valor, separadorDecimales);
		set(FORMULARIO + '.' + cajaTexto, formateaImporte(base, separadorMiles, separadorDecimales));
		set(FORMULARIO+'.hid_'+cajaTexto, base);
	} 

}

function soloDias(cajaTexto){
	var str=get(FORMULARIO+'.'+cajaTexto);
	var numero = true;
	var s;
	for(var i=0;i<str.length;i++){
		s=str.charAt(i);
		if(isNaN(parseInt(s))){
			numero = false;
		}
	}
                  
	if (!numero){
		GestionarMensaje('1256');
		focaliza(FORMULARIO+'.'+cajaTexto);
		return;
	}
}

// Nueva versión del btnConfirmar
function btnConfirmar(){
	if(sicc_validaciones_generales()){
		var contador = 0;
		var lista = '';
		if(get(FORMULARIO+'.cbCanal')!='')
			contador ++;
		if(get(FORMULARIO+'.cbAcceso')!='')
			contador ++;
		if(get(FORMULARIO+'.cbSubacceso')!='')
			contador ++;
		if(get(FORMULARIO+'.textClienteD')!='')
			contador ++;
		if(get(FORMULARIO+'.textClienteH')!='')
			contador ++;
		if(get(FORMULARIO+'.textFechaDocD')!='')
			contador ++;
		if(get(FORMULARIO+'.textFechaDocH')!='')
			contador ++;
		if(get(FORMULARIO+'.textFechaVenD')!='')
			contador ++;
		if(get(FORMULARIO+'.textFechaVenH')!='')
			contador ++;
		if(contador<4) {
			//mostramos el mensaje: "Debe seleccionar, al menos, {numero} criterios de búsqueda".(UICCC008). Siendo numero=4. 
                	//Codigo 1374
                  	cdos_mostrarAlert(GestionarMensaje('1374',4));
                  	focaliza(FORMULARIO+'.cbCanal');
		}else {
			var entidades = new Array();
			var oids = new Array();
			//Se actualiza el array con los datos de la lista editable
			listado1.actualizaDat();
			var tam = listado1.datos.length;
			var i;
			var temporal;
			// Inserto los oids de la lista en el hidden
			for(i = 0; i<tam; i++){
				temporal = listado1.datos[i];
				oids[i] = temporal[POSICIONOID];
			}
			set(FORMULARIO+'.oids', oids);
			// Inserto las entidades de la lista en el hidden
			for(i = 0; i<tam; i++){
				temporal = listado1.datos[i];
				entidades[i] = temporal[POSICIONENTIDADES];
			}
			set(FORMULARIO+'.entidades', entidades);
			//pasamos la lista editable a la LP->No hay q hacerlo
			/*var datosLista = listado1.datos;
                  	for (i = 0; i < datosLista.length; i++) {
                  		//metemos en la variable fila una tupla de la lista
                        	var fila = datosLista[i];
                        	//añadimos una fila, ponemos separadores para distinguir celdas y tuplas   
                             	lista = lista + fila[0] + "@"; //oid -> oculto
                             	lista = lista + fila[1] + "@";
                             	lista = lista + fila[2] + "@";
                             	lista = lista + fila[3] + "@";
                             	lista = lista + fila[4] + "@";
                             	lista = lista + fila[5] + "@";
                             	lista = lista + fila[6] + "@";
                             	lista = lista + fila[7] + "@";
                             	lista = lista + fila[8] + "@";
                             	lista = lista + fila[9] + "@";
                             	lista = lista + fila[10] + "@";
                             	lista = lista + fila[11] + "@";
                             	lista = lista + fila[12] + "@";
                             	lista = lista + fila[13] + "@";
                             	lista = lista + fila[14] + "#"; //entidad -> oculto
                  	}
                  	set(FORMULARIO+'.listaRegistros',lista);*/
			// Establecemos la acción y la LP
			set(FORMULARIO+'.accion', 'confirmar');
			set(FORMULARIO+'.conectorAction', 'LPGenerarDtoRecargo');
			// Enviamos el formulario
			enviaSICC(FORMULARIO);
		}
	}
}

function desbloquear(){

   if(get(FORMULARIO + '.errCodigo') != '230340061'){

      window.onbeforeunload = null;
      window.onunload = null;
   
      set(FORMULARIO + '.accion','borrarBloqueo');
      set(FORMULARIO + '.conectorAction',"LPGenerarDtoRecargo");
      eval(FORMULARIO).oculto = 'S';
      enviaSICC(FORMULARIO);                             
   }

}
