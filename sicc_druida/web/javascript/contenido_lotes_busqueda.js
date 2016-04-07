var FORMULARIO = 'frmCapturarCupon';
//varNoLimpiarSICC = true;
var visible = false;

function onLoadPag()   
{
	//Guarda en hidden el valor por defecto	para acceso pues no está en sesion (se deriva del subacceso por defecto)
	if (typeof(datosSubaccesos) != 'undefined') {
		var subacceso = get(FORMULARIO + '.subacceso');
		for (i=0; i < datosSubaccesos.length; i++) { 
			if (datosSubaccesos[i][0] ==  subacceso) { 
				set(FORMULARIO + '.acceso', datosSubaccesos[i][2]);
			}
		}
	}
	if (get(FORMULARIO+'.errDescripcion')!='') {		
		var wnd = fMostrarMensajeError(get(FORMULARIO+'.errCodigo'),get(FORMULARIO+'.errDescripcion'));
	}	
	preseleccionaValores();
	focaliza(FORMULARIO+'.textNumero');
	configurarMenuSecundario(FORMULARIO);
	DrdEnsanchaConMargenDcho('listado1',12);
	eval (ON_RSZ);  	
}
function visibleLista() {
	if (!get_visibilidad("capaLista")){
		visibilidad('capaLista','V');
		DrdEnsanchaConMargenDcho('listado1',12);
		eval (ON_RSZ);  
	}
}

function invisibleLista() {
	if (get_visibilidad("capaLista")){
		visibilidad('capaLista','O');
	}
}

	/*function visibleLista() {
		visibilidad('capaLista','V');
		visible = true;
	}

	function invisibleLista() {
		//vaciar lista
		alert("vacio LIsta");
		listado1.datos = null;
		listado1.reajusta();
		visibilidad('capaLista','O');
		visible = false;
	}*/
	//Selecciona valor por defecto para los combos acceso y subacceso
	function preseleccionaValores() {
		var canal = get(FORMULARIO + '.canal');
		set(FORMULARIO + '.cbCanal', [canal]);
		canalOnChange();
		//var subacceso = get(FORMULARIO + '.subacceso');
		//var acceso = get(FORMULARIO + '.acceso');
		//set(FORMULARIO + '.cbAcceso', [acceso]);
		//accesoOnChange();
		//set(FORMULARIO + '.cbSubacceso', [subacceso]);
	} 

	
function canalOnChange() {
	//recargamos el de accesos a partir de las listas ocultas
	var canal =get(FORMULARIO + '.cbCanal');
	vaciaCombo(FORMULARIO + '.cbAcceso');
	vaciaCombo(FORMULARIO + '.cbSubacceso');	
	if (canal != "") {
		var accesos = new Array();
		accesos[0] = ['', ''];
		//cargar acceso del array datosAccesos[oidAcceso, descripcion, oidcanal]
		if (typeof(datosAccesos) != 'undefined') {
			for (i=0; i < datosAccesos.length; i++) {
				if (datosAccesos[i][2] ==  canal) {
					accesos [accesos.length] = [datosAccesos[i][0], datosAccesos[i][1]];
				}
			}
		}
		set_combo(FORMULARIO + '.cbAcceso', accesos, ['']);
	} 
	
	
}

function accesoOnChange() {
	//recargamos el de subaccesos a partir de las listas ocultas
	var acceso =get(FORMULARIO + '.cbAcceso');
	vaciaCombo(FORMULARIO + '.cbSubacceso');
	if (acceso != "") {
		//cargar subacceso del array datosSubacceso[oid, descripcion,oidAcceso, oidCanal]
		var subaccesos = new Array();
		subaccesos[0] = ['', ''];
		//cargar acceso del array datosAcceso
		if (typeof(datosSubaccesos) != 'undefined') {
			for (i=0; i < datosSubaccesos.length; i++) {
				// Solo comprobamos el oidAcceso, pues es unico
				if (datosSubaccesos[i][2] ==  acceso) {
					subaccesos [subaccesos.length] = [datosSubaccesos[i][0],datosSubaccesos[i][1]];
				}
			}
		}
	set_combo(FORMULARIO + '.cbSubacceso', subaccesos, ['']);
	}
}

function vaciaCombo(combo) {
	set_combo(combo,[['','']],['']);
}

// Función que se ejecuta cuando el usuario pulsa el botón Buscar
function accionBuscar() {
	
	if (ValidaForm(FORMULARIO,true)) {
		var acceso = get(FORMULARIO+'.cbAcceso');
		var anho = get(FORMULARIO+'.textAno');
		var canal = get(FORMULARIO+'.cbCanal');
		var fechaImputacion = "";
		if (get(FORMULARIO+'.textFechaImputacion') != "")
			fechaImputacion = obtenerFormatoFecha(get(FORMULARIO+'.textFechaImputacion'));
		
		var mes = get(FORMULARIO+'.textMes');
		var numero=get(FORMULARIO+'.textNumero');
		var situacion = get(FORMULARIO+'.cbSituacion');
		var subacceso = get(FORMULARIO+'.cbSubacceso');
		var tipoCargoAbono = get(FORMULARIO+'.cbTipoAbono');
		var situacion = get(FORMULARIO+'.cbSituacion');
		var idioma = get(FORMULARIO+'.idioma');
    	var pais = get(FORMULARIO+'.pais');
    	var casoUso= get(FORMULARIO+'.casoUso');
    	
    	   	
   		if ((casoUso=='eliminar') || (casoUso=='modificar')) {
   			var valor=new Boolean(true);
   		} else {
   			var valor=new Boolean(false);
   		}	
   		
   		//comprobamos que al menos hayan introducido dos criterios de busqueda
   		if (!compruebaCriterios(acceso,anho,canal,fechaImputacion,mes,subacceso,tipoCargoAbono,numero,situacion)) {
   			GestionarMensaje('1389', 2);
   			return;
   		}
   			
    	var DTOBuscarLotes = 'es.indra.sicc.dtos.ccc.DTOBuscarLotes';
    		
    	//antiguo	
		//configurarPaginado(mipgndo, 'CCCBuscarLotes', 'ConectorBuscarLotes', 'es.indra.sicc.dtos.ccc.DTOBuscarLotes', [['acceso', acceso], ['anho', anho], ['canal', canal], ['fechaImputacion', fechaImputacion], ['mes', mes], ['numeroLote', numeroLote], ['situacion', situacion], ['subacceso', subacceso], ['tipoCargoAbono', tipoCargoAbono], ['oidIdioma',idioma], ['oidPais',pais], ['eliminar',valor] ] );
		
		configurarPaginado(mipgndo, 'CCCBuscarLotes', 'ConectorBuscarLotes', 'es.indra.sicc.dtos.ccc.DTOBuscarLotes', [['oidAcceso',acceso], ['anho', anho], ['oidCanal', canal], ['fechaImputacion', fechaImputacion], ['situacion', situacion], ['mes', mes],['oidSubacceso', subacceso], ['oidTipoCargoAbono', tipoCargoAbono], ['numero', numero],['oidIdioma',idioma], ['oidPais',pais], ['eliminar',valor] ] );
	} 
}

//Funcion que comprueba que el usuario al menos tenga introducido dos criterios de busqueda
function compruebaCriterios(acceso,anho,canal,fechaImputacion,mes,subacceso,tipoCargoAbono,numero,situacion) {
	
	var contador=0;
	
	if (acceso!='')
		contador++;
	if (anho!='') {
		contador++;
		if (contador>1)
			return true;
	}
	if (canal!='') {
		contador++;
		if (contador>1)
			return true;	
	}
	if (fechaImputacion!='') {
		contador++;
		if (contador>1)
			return true;
	}
	
	if (mes!='') {
		contador++;
		if (contador>1)
			return true;
	}
	
	if (subacceso!='') {
		contador++;
		if (contador>1)
			return true;
	}
	
	if (tipoCargoAbono!='') {
		contador++;
		if (contador>1)
			return true;
	}
	
	if (numero!='') {
		contador++;
		if (contador>1)
			return true;	
	}
	
	if (situacion!='') {
		contador++;
		if (contador>1)
			return true;
	}
	
	if (contador>1) {
		return true;
	} else {
		return false;
	}
	
}


// Función que se ejecuta cuando el usuario pulsa el botón Consultar
function accionDetalle() {
	
	if (listado1.numSelecc() == 0) {
		// Muestra el mensaje: "Debe seleccionar un elemento de la lista"
		GestionarMensaje('50');
	} else {
		if (listado1.numSelecc() != 1 ) {
			//Muesta el mensaje: "Debe seleccionar un solo registro"
			GestionarMensaje('8');
			var seleccion=listado1.codigos();
                  	var i=0;
                 	while(seleccion[i]!=null){
                  		listado1.deselecciona(i); 
                  		i++;           
                  	}
		} else {
			// Abrimos una ventana emergente y direccionamos a la LPAplicarCargosAbonos 
			// con la accion "consultar", pasandole el oid de la fila que ha selecionado 
			// el usuario.
			// Abrimos un popup con la url de la LPProvisionDepuracion y le pasamos como 
			// parametros el oid de la fila que ha seleccionado y el caso de uso en el que estamos.
			var objParams = new Object();
			objParams.oidSeleccionado = listado1.codSeleccionados();
			
			objParams.casoUso=get(FORMULARIO+'.casoUso');
		
			
			mostrarModalSICC('LPProvisionDepuracion', '', objParams, null, null);
			accionBuscar();
		}
	}
}

function validaFecha(nombreElemento) {
	
	var fecha= get(FORMULARIO+'.'+nombreElemento);
	if(fecha != ""){
		var resul = EsFechaValida(fecha,fecha, FORMULARIO,null);
		if(resul==1 || resul==2){  
       		GestionarMensaje('1006', get(FORMULARIO+'.hFormatoFechaPais')); 
	 		focaliza(FORMULARIO+'.'+nombreElemento);      	
     	}
	}
}



	function fVolver()  {
		var retorno = cdos_mostrarConfirm(GestionarMensaje(1063));
		if(retorno) {
			window.close();
		}
	}

	function fLimpiar()  {
			
		limpiaFormulario();
	}

	function limpiaFormulario()  {
		
		//invisibleLista();	
		var cu = get(FORMULARIO+'.casoUso');
		var situacion = get(FORMULARIO+'.situacion');
		if (cu=="aprobarRechazar") {
			//El combo situacion tendrá como valor seleccionado por 
			//defecto: CCCConstantes.INCOBRABLE_SITUACION_SOLICITADO. Y no se podrá cambiar. 
			set(FORMULARIO+'.cbSituacion',[situacion]);
		}
		set_combo(FORMULARIO+'.cbAcceso',[['','']],['']);		
		set_combo(FORMULARIO+'.cbSubacceso',[['','']],['']);		

		//Guarda en hidden el valor por defecto	para acceso pues la variable oculta se ha reseteado (se deriva del subacceso por defecto)
		if (typeof(datosSubaccesos) != 'undefined') {
			var subacceso = get(FORMULARIO + '.subacceso');
			for (i=0; i < datosSubaccesos.length; i++) { 
				if (datosSubaccesos[i][0] ==  subacceso) { 
					set(FORMULARIO + '.acceso', datosSubaccesos[i][2]);
				}
			}
		}		
	}

	function focalizaAnteriorNumero() {
		if (get_visibilidad('capaLista') == true) 
				document.all['detalle'].focus();
		else
				document.all['btnBuscar'].focus();
	}
	

	function focalizaSiguienteBuscar() {
		if (get_visibilidad('capaLista') == true)
				document.all['detalle'].focus();
		else
				focaliza(FORMULARIO + '.textNumero');
	}
	
	function focalizaSiguienteDetalle(){
		focaliza(FORMULARIO + '.textNumero');
	}
	
	function focalizaAnteriorDetalle() {
		document.all['btnBuscar'].focus();
	}
	
         
function validarAnyo() {
	if(get(FORMULARIO+'.textAno')!=''){
		var esNumeroA=esNumero(get(FORMULARIO+'.textAno'));
		if(esNumeroA=='-1'){		
			GestionarMensaje('747', null, null, null);
			focaliza(FORMULARIO+'.textAno');
			return;			
		}
		if(get(FORMULARIO+'.textAno').length!=2){
			set(FORMULARIO+'.textAno','0'+get(FORMULARIO+'.textAno'));			
		}		

		
		
	}
}

function validarMes(){
	if(get(FORMULARIO+'.textMes')!=''){
		var esNumeroA=esNumero(get(FORMULARIO+'.textMes'));
		if(esNumeroA=='-1'){		
			GestionarMensaje('747', null, null, null);
			focaliza(FORMULARIO+'.textMes');
			return;			
		}
		
		var mes=get(FORMULARIO+'.textMes');
		
		if(mes>12||mes==0){
			GestionarMensaje('1113');
			focaliza(FORMULARIO+'.textMes');
			return;
		}
		
		if(get(FORMULARIO+'.textMes').length!=2){
			set(FORMULARIO+'.textMes','0'+get(FORMULARIO+'.textMes'));			
		}
	}
	
}
function validarNumero(){
	if(get(FORMULARIO+'.textNumero')!=''){
		var esNumeroA=esNumero(get(FORMULARIO+'.textNumero'));
		if(esNumeroA=='-1'){		
			GestionarMensaje('747', null, null, null);
			focaliza(FORMULARIO+'.textNumero');
			return;			
		}
	}	
}
function muestraLista( ultima, rowset){
	var tamano = rowset.length;
	if (tamano > 0) {
		visibleLista();
		return true;
	} else {
		invisibleLista();		
		focaliza(FORMULARIO+'.textNumero','');
		return false;
	}
}
