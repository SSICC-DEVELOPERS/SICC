/**
* Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
var FORMULARIO = 'frmUnica';
var acceso = '';
var esProceso = false;
var situacionOrig;

function onLoadPag() {
    configurarMenuSecundario(FORMULARIO); 
    if (get(FORMULARIO+'.errDescripcion')!='') {		
		var wnd = fMostrarMensajeError(get(FORMULARIO+'.errCodigo'),get(FORMULARIO+'.errDescripcion'));
	}

   	 if (window.dialogArguments) { // Si es modal (se abrió mediante showModalDialog) DBLG500000915
            btnProxy(2,1);  // boton 'volver', habilitado
            btnProxy(3,0);  // boton 'Ir a pantalla de inicio', deshabilitado
    }

    if(get(FORMULARIO+'.casoUso')=='insertar'){
		ocultarCapa('capa2');
		
    }
    if((get(FORMULARIO+'.casoUso')=='modificar')||(get(FORMULARIO+'.casoUso')=='consultar')){
		hacerVisibleCapa('capa2');
    }  
    if((get(FORMULARIO+'.casoUso')!='consultar')){
    	focaliza('frmUnica.cbEmpresa');	
	}

/*	alert("consSOLICITADO " + get(FORMULARIO+'.consSOLICITADO'));
	alert("consEN_PROCESO " + get(FORMULARIO+'.consEN_PROCESO'));
	alert("consRESUELTO " + get(FORMULARIO+'.consRESUELTO'));
	alert("consRECHAZADO " + get(FORMULARIO+'.consRECHAZADO'));	*/

	var situacion = get(FORMULARIO+'.cbSituacion');
	situacionOrig = get(FORMULARIO+'.cbSituacion');
//	alert("situacion " + situacion);

	if(situacion!=get(FORMULARIO+'.consEN_PROCESO')) {
		document.getElementById("cbSituacion").disabled = true;
	}
	else {
		esProceso = true;
	}
}

function cbSituacionOnChange() {
	var situacion = get(FORMULARIO+'.cbSituacion');
	
	if(esProceso==true && situacion==get(FORMULARIO+'.consSOLICITADO')) {
		//No se puede seleccionar el estado Solicitado
		GestionarMensaje('3348');
		set("frmUnica.cbSituacion", [situacionOrig]);
		return false;	
	}
}
   


function alfanumerico(){

         
          var str=get(FORMULARIO + '.textEjercicioCuota');
          //set(cadena,str.toUpperCase());
          set(FORMULARIO+'.textEjercicioCuota',str.toUpperCase());
            	   
         }
   
function canalOnChange() {
		//recargamos el de accesos a partir de las listas ocultas
		var canal =get(FORMULARIO + '.cbCanal');
		var pais =get(FORMULARIO + '.pais');
		var idioma =get(FORMULARIO + '.idioma');
		if (canal != "") {
			
			recargaCombo(FORMULARIO+'.cbAcceso','SEGObtenerAccesosPorCanal','es.indra.sicc.dtos.seg.DTOAccesosPorCanal',[["oidIdioma",idioma],["oidCanal",canal],["oidPais", pais]]);
			recargaCombo(FORMULARIO+'.cbPeriodoReclamante','SEGObtenerPeriodosPorCanal','es.indra.sicc.util.DTOOID',[["oidIdioma",idioma],["oid",canal],["oidPais", pais]]);

			
			vaciaCombo(FORMULARIO + '.cbSubacceso');
		} else {
			vaciaCombo(FORMULARIO + '.cbAcceso');
			vaciaCombo(FORMULARIO + '.cbSubacceso');
		}
}

function accesoOnChange() {
		//recargamos el de subaccesos a partir de las listas ocultas
		var acceso =get(FORMULARIO + '.cbAcceso');
		
		var pais =get(FORMULARIO + '.pais');
		var idioma =get(FORMULARIO + '.idioma');
		
		if (acceso != "") {
			//cargar subacceso del array datosSubacceso
			recargaCombo(FORMULARIO+'.cbSubacceso','SegObtenerSubaccesosPorAcceso','es.indra.sicc.util.DTOOID',[["oidIdioma",idioma],["oidPais",pais],["oid", acceso]]);
			
		} else {
			vaciaCombo(FORMULARIO + '.cbSubacceso');
		}
}

function bancoOnChange() {
	var banco = get(FORMULARIO+'.cbBancoRecaudacion');
    if (banco != "") {
    	recargaCombo(FORMULARIO+'.cbSucursalRecaudacion',
    				'CCCRecargaSucursales', 'es.indra.sicc.util.DTOOID',[["oid", banco]]);       
    	vaciaCombo(FORMULARIO+'.cbCuenta'); 
    }
    else {
         vaciaCombo(FORMULARIO+'.cbSucursalRecaudacion');
         vaciaCombo(FORMULARIO+'.cbCuenta');
    }
}


function sucursalOnChange() {
	var sucursal = get(FORMULARIO+'.cbSucursalRecaudacion');
    if (sucursal != "") {//id: BELC300008980
    	recargaCombo(FORMULARIO+'.cbCuenta',
    				'CCCRecargaCuentas', 'es.indra.sicc.util.DTOOID',[["oid", sucursal]]);        
    }
    else {
         vaciaCombo(FORMULARIO+'.cbCuenta');
    }
}

function seleccionarCliente() {
    if(get(FORMULARIO+'.casoUso')!='consultarReclamo'){ 
	    var objParams = new Object();
	    var cliente = mostrarModalSICC('LPBusquedaRapidaCliente', '', objParams, null, null);	
	   
		if (typeof(cliente)!='undefined'){
			 var codigoCliente = cliente[1];
			set(FORMULARIO+'.textCodigoClienteReclamante',codigoCliente);
		}
	}
}

function codigoClienteOnBlur() {
         var codigoCliente = get(FORMULARIO+'.textCodigoClienteReclamante');
         if (codigoCliente != '') {
                  var longitudCodigoCliente = get(FORMULARIO+'.tamanio');
                  var longitud = codigoCliente.length;
                  
                  set(FORMULARIO+'.textCodigoClienteReclamante',rellenaCeros(codigoCliente,longitudCodigoCliente,longitud));
         }
}



function situacionOnChange() {
	
	var situacion = get(FORMULARIO+'.cbSituacion');
	
}

function vaciaCombo(combo) {
    if (eval('document.'+combo) != undefined) 
       set_combo(combo,[['','']],['']);
    return true;
}

function importeOnBlur() {
	var valor = get(FORMULARIO+'.textImporteReclamado');
	if(valor != "") {
			//Valida el importe insertado
			var mensaje = ValidaMilesDecimales(valor, 10, get(FORMULARIO + '.hid_NumeroDecimales'), get(FORMULARIO + '.hid_SeparadorMiles'), get(FORMULARIO + '.hid_SeparadorDecimales'), 0);
			if (mensaje != 'OK') {
				cdos_mostrarAlert(mensaje);
                focaliza(FORMULARIO+'.textImporteReclamado');
                return false;
			}
			//Formateamos el valor
			//Obtenemos los separadores
			var separadorDecimales = get(FORMULARIO + '.hid_SeparadorDecimales');
			var separadorMiles = get(FORMULARIO + '.hid_SeparadorMiles');
			var formateado = formateaImporte(obtieneNumeroDecimal(valor, separadorDecimales), separadorMiles, separadorDecimales);
			set(FORMULARIO+'.textImporteReclamado',formateado);
	}
}

/* valida decimales (formato con separador de miles y de decimales)
	 * valor es una cadena con el numero decimal
	 * enteros -> numero de digitos que como máximo tendrá la parte entera
	 * decimales -> numero de digitos que como máximo tendrá la parte decimal
	 * separadorMiles -> carácter de separador de miles
	 * separadorDecimales -> carácter de separador de decimales
	 * min -> valor minimo que tendrá el número
	 * max -> valor maximo que tendrá el número (se puede omitir)
	 */
	function ValidaMilesDecimales(valor, enteros, decimales, separadorMiles, separadorDecimales, min, max) {
		var ok;
		var valoresPrimario = null;
		if (ValidaCaracteres(valor,'0123456789' + separadorMiles + separadorDecimales)!='OK') {return DrdMsgCore(143) + separadorMiles + separadorDecimales + '0123456789';}
		
		//empieza por separadordecimales
		if (valor.indexOf(separadorDecimales) == 0) {return DrdMsgCore(101);}

		//termina por separadordecimales
		if (valor.indexOf(separadorDecimales) == valor.length-1) {return DrdMsgCore(101);}
		
		//empieza por separadormiles
		if (valor.indexOf(separadorMiles) == 0) {return DrdMsgCore(101);}

		//termina por separadormiles
		if (valor.indexOf(separadorMiles) == valor.length-1) {return DrdMsgCore(101);}
		
		valoresPrimario = valor.split(separadorDecimales);
		if (valoresPrimario.length > 0 && valoresPrimario.length < 3 && valoresPrimario[0].length > 0 ) {
			//parte entera no está vacía
			var valores = valoresPrimario[0].split(separadorMiles);
			if (valores.length > 1) {
				if (valores[0].length < 1 || valores[0].length > 3 ){return DrdMsgCore(101);}
				for (i = 1; i < valores.length; i++)
					if(valores[i].length < 3 ){return DrdMsgCore(101);}
			}
			var entornoSeparador = (separadorDecimales == ",")?true:false;
			var valorSinSeparadorMiles = valoresPrimario[0];
			while (valorSinSeparadorMiles.indexOf(separadorMiles) != -1) {
				valorSinSeparadorMiles = valorSinSeparadorMiles.replace(separadorMiles, '');
			}
			if (valoresPrimario.length == 2) {
				valorSinSeparadorMiles += separadorDecimales;
				valorSinSeparadorMiles += valoresPrimario[1];
			}
			ok=ValidaFloat(valorSinSeparadorMiles, enteros, decimales, entornoSeparador, min, max);

		} else {return DrdMsgCore(101);}
	
		return ok;
	}

//formatea un decimal a cadena con separadores de miles, separador de decimales
         //el número decimal debe tener la parte decimal en el formato adecuado
         function formateaImporte(numeroDecimal, separadorMiles, separadorDecimales){
                  var dineroEntrada = "" + numeroDecimal;
                  var negativo = false;
                  if (dineroEntrada.indexOf('-') == 0) {
                           dineroEntrada = dineroEntrada.replace('-', '');
                           negativo = true;
                  }
                  var tokens = dineroEntrada.split('.');
                  var bufferEntero = tokens[0];// almacena la parte entera.
                  var bufferDinero = "";//almacena el resultado
                  var bufferDecimales = "";//almacena la parte decimal
                  if (tokens.length > 1)
                           bufferDecimales = tokens[1];

                  while (bufferEntero.length > 0) {
                           if (bufferEntero.length > 3) {
                                    bufferDinero = separadorMiles + bufferEntero.substr(bufferEntero.length-3) + bufferDinero ;
                                    bufferEntero = bufferEntero.substr(0, bufferEntero.length-3);
                           } else {
                                    bufferDinero = bufferEntero.substr(0) + bufferDinero ;
                                    bufferEntero = "";
                           }
                  }
                  if (bufferDecimales != "") {
                           if (bufferDecimales != "0" && bufferDecimales != "00") {
                                    bufferDinero = bufferDinero + separadorDecimales + bufferDecimales;
                           }
                  }
                  if (negativo)
                                    bufferDinero = '-' + bufferDinero;
                  return bufferDinero;
         }

//valida la fecha si el campo es modificable y no vacío  hay que cambiar esto ya 
function validaFecha(fecha) {
	if(get(FORMULARIO+'.'+fecha)!="") {
         if (EsFechaValida(get(FORMULARIO+'.'+fecha),get(FORMULARIO+'.'+fecha), FORMULARIO, null)) {
             var strCaja = FORMULARIO+'.'+fecha;
             focaliza(strCaja);
             GestionarMensaje('1006', get(FORMULARIO+'.hFormatoFechaPais'));
             focaliza(strCaja);
             return false;
          }
    }
}

function inserccionCorrecta() {
	//fLimpiar();
	
	//Llamamos a la funcion que implementa el boton limpiar de los iconos
	window.parent.frames['iconos'].foc_btnBarra5(); 
	
	fLimpiarGenericoSICC();
	//alert('estoy apunto de quitarle el aculto al formulario');
	//frmUnica.oculto='N'; //el nombre del formulario no la variable FORMULARIO esa
	//alert('hecho');
	//set(FORMULARIO +'.accion','');
 	//set(FORMULARIO +'.conectorAction',"LPMantenimientoReclamos"); 
	//EnviaSICC(FORMULARIO); 
	//alert('enviado');

	

}

/*
function modificacionCorrecta(){
         var casouso=get(FORMULARIO+'.casoUso');
        var codigo=get(FORMULARIO+'.txtCodTipoMovimiento');
        var descripcion=get(FORMULARIO+'.txtDescripcion');
        if (casouso!='insertar'){
                 window.returnValue = [codigo,descripcion];
                 window.close();
         }    	
}


*/
function modificacionCorrecta(){
	
	
	
	var numero=get(FORMULARIO+'.nIdentificacion').toString();
	var ano=get(FORMULARIO+'.hAnyo').toString();
	var mes=get(FORMULARIO+'.hPeriodoMes').toString();
	var situacion=get(FORMULARIO+'.cbSituacion','T').toString();
	

	var banco = get(FORMULARIO+'.cbBancoRecaudacion','T').toString();
    	
    	var sucursal = get(FORMULARIO+'.cbSucursalRecaudacion','T').toString();
    	
    	var cuenta = get(FORMULARIO+'.cbCuenta','T').toString();
	var cod_cliente=get(FORMULARIO+'.textCodigoClienteReclamante').toString();
	var fecha=get(FORMULARIO+'.fecdoc').toString();
	var importe=get(FORMULARIO+'.textImporteReclamado').toString();
	
	 
                 window.returnValue = [numero,ano,mes,situacion,banco,sucursal,cuenta,cod_cliente,fecha,importe];
                 window.close();
            	
		
	}


//convierte a numero decimal una cadena con formato de miles y decimales	
function obtieneNumeroDecimal(cadena, separadorDecimales) {

	if (cadena != "") {
		//eliminar separador de miles
		if (separadorDecimales == ".") {
			cadena = cadena.replace(/,/g,'');
		} else {
			cadena = cadena.replace(/\./g,'');
			//sustituir separador decimal por punto
			cadena = cadena.replace(/,/g,'.');
		}
		return Number(cadena);
	}
	else {
		return 0;
	}
}

function fGuardar() {		
	//alert("fGuardar");

	var ejercicioCuota = get(FORMULARIO+'.textEjercicioCuota');
	var numeroIdentificadorCuota = get(FORMULARIO+'.textNumeroIdentificadorCuota');
	var numeroOrdenCuota = get(FORMULARIO+'.textNumeroOrdenCuota');
	var subacceso = get(FORMULARIO+'.cbSubacceso');
	var acceso  = get(FORMULARIO+'.cbAcceso');

	if(get(FORMULARIO+'.casoUso')=='insertar'){
		var empresa = get(FORMULARIO+'.cbEmpresa');
		var canal = get(FORMULARIO+'.cbCanal');
		var codigoCliente = get(FORMULARIO+'.textCodigoClienteReclamante');
		var fechaValor = get(FORMULARIO+'.textFechaValor');				
		var separadorDecimales = get(FORMULARIO + '.hid_SeparadorDecimales');
		var importe = get(FORMULARIO+'.textImporteReclamado');	
		var formateado = obtieneNumeroDecimal(importe, separadorDecimales)
		set(FORMULARIO+'.hid_importe',formateado);

		if (sicc_validaciones_generales('grupo1')){				
			//Modificado por cvalenzu - Incidencia bloqueante - 14/12/2006
			//if(ejercicioCuota =="" || numeroIdentificadorCuota =="" || numeroOrdenCuota =="" || subacceso=="" || acceso=="" ){ 
			
			//alert("paso grupo1");
			if(ejercicioCuota !="" || numeroIdentificadorCuota !="" || numeroOrdenCuota !=""){ 
				//alert("primer if");

				if(ejercicioCuota !="" && numeroIdentificadorCuota !="" && numeroOrdenCuota !="" 
					&& subacceso!="" && acceso!="" ){ 

					//alert("segundo if-ok");
					
				}
				else {
					/*'1436': "Para identificar un movimiento en cuenta corriente debe completar los siguientes campos: acceso, subacceso, ejercicio cuota, número identificador cuota y número orden cuota."*/
					//alert("else - mensaje");

					GestionarMensaje('1436');
					focaliza(FORMULARIO+'.textEjercicioCuota');
					return false;
				}
			}     

			//alert("fin");
			
			set(FORMULARIO+'.accion','guardar_menu_sec');
			set(FORMULARIO+'.conectorAction','LPMantenimientoReclamos');			
			enviaSICC(FORMULARIO,null,null,'N'); 
		}		
	}	
	else if(get(FORMULARIO+'.casoUso')=='modificar'){
		if(get(FORMULARIO+'.activDesact')!='0'){
					
			if (sicc_validaciones_generales('grupo1')&&sicc_validaciones_generales('grupo2')){
				// INCIDENCIA 10612
				/*
			  	  "Si ejercicioCuota <> null ó numeroIdentificadorCuota <> null ó numeroOrdenCuota <> null
					Si subacceso == null ó ejercicioCuota == null ó numeroIdentificadorCuota == null ó numeroOrdenCuota == null
						Aviso (javascript:alert() ): UICCC018 - "Para identificar un movimiento en cuenta corriente debe completar los
						siguientes campos: acceso, subacceso, ejercicio cuota, número identificador cuota y número orden cuota".
					Fin del Si
			  	  Fin del Si"
				*/
				if(ejercicioCuota != null || numeroIdentificadorCuota != null || numeroOrdenCuota != null){
					if(ejercicioCuota != "" || numeroIdentificadorCuota != "" || numeroOrdenCuota != ""){
						if(subacceso == null || subacceso == "" || ejercicioCuota == null || ejercicioCuota=="" || numeroIdentificadorCuota == null || numeroIdentificadorCuota=="" || numeroOrdenCuota == null || numeroOrdenCuota==""){
							GestionarMensaje('1436');
							focaliza(FORMULARIO+'.textEjercicioCuota');
							return false;
						}
					}
				}
				// Fin INCIDENCIA 10612
				set(FORMULARIO+'.accion','guardar_menu_sec');
				set(FORMULARIO+'.conectorAction','LPMantenimientoReclamos');
				enviaSICC(FORMULARIO,null,null,'N'); 
				
			}		
	     	}else {	
	     		if (sicc_validaciones_generales('grupo1')&&sicc_validaciones_generales('grupo2')&&sicc_validaciones_generales('grupo3')){
	     			// INCIDENCIA 10612
				/*
			  	  "Si ejercicioCuota <> null ó numeroIdentificadorCuota <> null ó numeroOrdenCuota <> null
					Si subacceso == null ó ejercicioCuota == null ó numeroIdentificadorCuota == null ó numeroOrdenCuota == null
						Aviso (javascript:alert() ): UICCC018 - "Para identificar un movimiento en cuenta corriente debe completar los
						siguientes campos: acceso, subacceso, ejercicio cuota, número identificador cuota y número orden cuota".
					Fin del Si
			  	  Fin del Si"
				*/
				if(ejercicioCuota != null || numeroIdentificadorCuota != null || numeroOrdenCuota != null){
					if(ejercicioCuota != "" || numeroIdentificadorCuota != "" || numeroOrdenCuota != ""){
						if(subacceso == null || subacceso == "" || ejercicioCuota == null || ejercicioCuota=="" || numeroIdentificadorCuota == null || numeroIdentificadorCuota=="" || numeroOrdenCuota == null || numeroOrdenCuota==""){
							GestionarMensaje('1436');
							focaliza(FORMULARIO+'.textEjercicioCuota');
							return false;
						}
					}
				}
				// Fin INCIDENCIA 10612
	     			set(FORMULARIO+'.accion','guardar_menu_sec');
				set(FORMULARIO+'.conectorAction','LPMantenimientoReclamos');
				enviaSICC(FORMULARIO);
	     		
	     		}
	     		
	     		
	     	} 		//si esta a uno los campos deben de estar hanilitados
	}
     
}

function fLimpiar() {
	
		//Dejamos el formulario como al principio
		//Seleccionamos los valores
	
		set(FORMULARIO+'.cbEmpresa', [get(FORMULARIO+'.empresa')]);	
		set(FORMULARIO+'.cbCanal', [get(FORMULARIO+'.canal')]);
		canalOnChange();
		set(FORMULARIO+'.acceso',acceso);
		set(FORMULARIO+'.cbAcceso', [get(FORMULARIO+'.acceso')]);
		accesoOnChange();
		set(FORMULARIO+'.cbSubacceso', [get(FORMULARIO+'.subacceso')]);
		set(FORMULARIO+'.cbSituacion', [get(FORMULARIO+'.situacion')]);
		set(FORMULARIO+'.textObservacionesAreaReclamos','');			
		set(FORMULARIO+'.textObservacionesClienteReclamante','');			
		set(FORMULARIO+'.atxtObservacionesResolucionReclamos',''); 
		
		if(get(FORMULARIO+'.casoUso')=='modificarReclamo'){					
			set(FORMULARIO+'.textObservacionesAreaReclamos',get(FORMULARIO+'.observacionesAreaReclamos'));			
			set(FORMULARIO+'.textObservacionesClienteReclamante',get(FORMULARIO+'.observacionesClienteReclamante'));			
			set(FORMULARIO+'.atxtObservacionesResolucionReclamos',get(FORMULARIO+'.observacionesResolucionReclamos')); 
			set(FORMULARIO+'.cbMedioPago', [get(FORMULARIO+'.medioPago')]);			
			set(FORMULARIO+'.cbPeriodoReclamante',[get(FORMULARIO+'.periodoReclamante')]);			
			set(FORMULARIO+'.cbCodigoSolucionRechazo',[get(FORMULARIO+'.codigoSolucionRechazo')]);			
			set(FORMULARIO+'.cbSituacion', [get(FORMULARIO+'.situacion')]); 			
			situacionOnChange();
			set(FORMULARIO+'.cbBancoRecaudacion', [get(FORMULARIO+'.bancoRecaudacion')]); 		
			cargaSucursal();
			cargaCuentaCorriente();			
		}	
}

function fVolver() {	                     
	
	if(get(FORMULARIO+'.casoUso')=='modificarReclamo'){
		var retorno = cdos_mostrarConfirm(GestionarMensaje(1063)); 
		if(retorno) {
			 window.close(); 
		}
	}else{
		window.close();
	}
}
/*
function cargaSucursal(){
	var dto='es.indra.sicc.util.DTOOID';
	gestionaCombo(FORMULARIO+'.cbSucursalRecaudacion', 'CCCRecargaSucursales', dto,[['oid', get(FORMULARIO+'.bancoRecaudacion')]], 'setSucursal(datos)');
}
function cargaCuentaCorriente(){
	var dto='es.indra.sicc.util.DTOOID';
	gestionaCombo(FORMULARIO+'.cbCuenta', 'CCCRecargaCuentas', dto,[['oid', get(FORMULARIO+'.sucursalRecaudacion')]], 'setCuentaCorriente(datos)');	
}
function setSucursal(datos){	
         set_combo(FORMULARIO+'.cbSucursalRecaudacion', incluyeOpcionVacia(datos));
         set(FORMULARIO+'.cbSucursalRecaudacion', [get(FORMULARIO+'.sucursalRecaudacion')]);	
}
function setCuentaCorriente(datos){
	set_combo(FORMULARIO+'.cbCuenta', incluyeOpcionVacia(datos));
	set(FORMULARIO+'.cbCuenta', [get(FORMULARIO+'.cuenta')]);	
}

function gestionaCombo(combo, idBusiness, dto, valoresEntrada, funcion) {  
	asignar([["COMBO", combo, "ConectorDruidaTransactionQuery", 'dtoSalida.resultado_ROWSET', formarCadenaDT(idBusiness, dto, valoresEntrada), funcion]],"","");                  
}

function incluyeOpcionVacia(datos) {
         var datos2 = new Array();
         datos2[0] = ['',''];
         
         for (var i=0;i<datos.length;i++) {
         datos2[i+1] = datos[i];
         }
         return datos2;
}
*/
function validarMes(){
	if(get(FORMULARIO+'.txtMesCargoAbonoDirecto')!=''){
		var esNumeroA=esNumero(get(FORMULARIO+'.txtMesCargoAbonoDirecto'));
		if(esNumeroA=='-1'){
			focaliza(FORMULARIO+'.txtMesCargoAbonoDirecto');
			GestionarMensaje('747', null, null, null);
			focaliza(FORMULARIO+'.txtMesCargoAbonoDirecto');
			return;
		}

		var mes=get(FORMULARIO+'.txtMesCargoAbonoDirecto');

		if(mes>12||mes==0){
			focaliza(FORMULARIO+'.txtMesCargoAbonoDirecto');
			GestionarMensaje('1113');
			focaliza(FORMULARIO+'.txtMesCargoAbonoDirecto');
			return;
		}

		if(get(FORMULARIO+'.txtMesCargoAbonoDirecto').length!=2){
			set(FORMULARIO+'.txtMesCargoAbonoDirecto','0'+get(FORMULARIO+'.txtMesCargoAbonoDirecto'));
		}
	}
}

function validarAnyo() {
	if(get(FORMULARIO+'.txtAnoCargoAbonoDirecto')!=''){
		var esNumeroA=esNumero(get(FORMULARIO+'.txtAnoCargoAbonoDirecto'));
		if(esNumeroA=='-1'){
			focaliza(FORMULARIO+'.txtAnoCargoAbonoDirecto');
			GestionarMensaje('747', null, null, null);
			focaliza(FORMULARIO+'.txtAnoCargoAbonoDirecto');
			return;
		}

		if(get(FORMULARIO+'.txtAnoCargoAbonoDirecto').length!=2){
			set(FORMULARIO+'.txtAnoCargoAbonoDirecto','0'+get(FORMULARIO+'.txtAnoCargoAbonoDirecto'));
		}
	}
}

//valida entero si el campo es modificable y no vacío 
function validaEntero(nombreElemento) {
 
     if (get(FORMULARIO+'.'+nombreElemento).toString() != "") { 
              //Como no nos interesa validar el número de dígitos que tiene el 
              //entero ponemos uno suficientemente grande.  
              if (ValidaInt(get(FORMULARIO+'.'+nombreElemento).toString(),10000, 0)!="OK") {
                       focaliza(FORMULARIO+'.'+nombreElemento);
                       GestionarMensaje('747', null, null, null); 
                       focaliza(FORMULARIO+'.'+nombreElemento);
                       return false;
              }
     }
 
}
function tabulacionNumero(){
	if(get(FORMULARIO+'.casoUso')=='consultar'){   
		 if (!get_visibilidad("capaLista")) {
			document.all['btnBuscar'].focus();		
		}else{
			document.all['detalle'].focus();		
		}
	}else if(get(FORMULARIO+'.casoUso')=='eliminar'){
		 if (!get_visibilidad("capaLista")) {
			document.all['btnBuscar'].focus();		
		}else{
			document.all['detalle'].focus();
		}
	}else if(get(FORMULARIO+'.casoUso')=='modificar'){
		 if (!get_visibilidad("capaLista")) {
			document.all['btnBuscar'].focus();		
		}else{
			document.all['modificar'].focus();		
		}
	}	
}



function tabcapa(){//tabulador desde areaReclmoas
	
	if (!get_visibilidad("capa2")) {//no es visible 
			focaliza('frmUnica.cbEmpresa');	
		}else{
			focaliza('frmUnica.cbSituacion');		
		}
	
	/*if(get(FORMULARIO+'.casoUso')=='insertar'){  
		//la capa no es visible
		focaliza(FORMULARIO+'.'+cbEmpresa);
	
	}
	if(get(FORMULARIO+'.casoUso')=='modificar'){  
		//la capa es visible
		focaliza(FORMULARIO+'.'+ cbSituacion);
	}
	*/
}
	
function ontabcapa(){//cbEmpresa hacia atras
	if (!get_visibilidad("capa2")) {//no es visible 
		
			focaliza('frmUnica.textObservacionesAreaReclamos');	
		}else{
			focaliza('frmUnica.atxtObservacionesResolucionReclamos');		
		}
	/*if(get(FORMULARIO+'.casoUso')=='insertar'){
	
		//la capa no es visible
		focaliza(FORMULARIO+'.'+textObservacionesAreaReclamos);
	
	}
	if(get(FORMULARIO+'.casoUso')=='modificar'){
		//la capa es visible
		focaliza(FORMULARIO+'.'+ atxtObservacionesResolucionReclamos);
	}
	*/
	
}
function tabResolucion(){//tabulador desde areaReclmoas
	
	focaliza('frmUnica.cbEmpresa');	
}




function hacerVisibleCapa(nombreCapa) {
	visibilidad(nombreCapa, 'V');
	//DrdEnsanchaConMargenDcho('listado1', 12);
	eval (ON_RSZ);
}
function ocultarCapa(nombreCapa) {
	visibilidad(nombreCapa, 'O');
}