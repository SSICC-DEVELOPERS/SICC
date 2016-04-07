var FORMULARIOC = 'frmContenido';
var parametrosRecargaCombos = null;
var opcionMenu;
var SEPARADOR = "~"
function onLoadPag(){
         
     evaluaError();
     configurarMenuSecundario(FORMULARIOC);
     focaliza(FORMULARIOC + ".txtCodCli");    
     opcionMenu = get(FORMULARIOC + '.opcionMenu');
}

function evaluaError (){
         var errDescripcion = get(FORMULARIOC +'.errDescripcion');
    
    if (errDescripcion !='') {
         var errCodigo = get(FORMULARIOC+'.errCodigo');
         var wnd = fMostrarMensajeError(errCodigo, errDescripcion);
    }
}

function onClickGuardar() {
			var valido = null;
	 if ( sicc_validaciones_generales("grupo1") ){

			if((parseInt(get(FORMULARIOC + '.txtNumPuntos'),10)<=0)&&(get(FORMULARIOC + '.cbTipoM')=='1')){
			 	valido = GestionarMensaje('INC042');
			}else if((parseInt(get(FORMULARIOC + '.txtNumPuntos'),10)>=0)&&(get(FORMULARIOC + '.cbTipoM')!='1')){
				valido = GestionarMensaje('INC043');
			}

			if((parseInt(get(FORMULARIOC + '.txtNumExig'),10)<=0)&&(get(FORMULARIOC + '.cbTipoM')=='1')){
				valido = GestionarMensaje('INC044');
			}else if((parseInt(get(FORMULARIOC + '.txtNumExig'),10)>=0)&&(get(FORMULARIOC + '.cbTipoM')!='1')){
				valido = GestionarMensaje('INC045');
			}

/*			case 'INC042': return cdos_mostrarAlert("El valor del campo Puntos debe ser mayor que cero"); break;
			case 'INC043': return cdos_mostrarAlert("El valor del campo Puntos debe ser menor que cero"); break;
			case 'INC044': return cdos_mostrarAlert("El valor del campo Puntos Exigidos debe ser mayor que cero"); break;
			case 'INC045': return cdos_mostrarAlert("El valor del campo Puntos Exigidos debe ser menor que cero"); break;*/
			 if(valido==null){
			 var mensaje = GestionarMensaje('950');
			 

			if(mensaje){
				 set(FORMULARIOC + '.hFecha', get(FORMULARIOC + '.txtFecha'));
				 set(FORMULARIOC + '.hCodClie', get(FORMULARIOC + '.txtCodCli'));
				 set(FORMULARIOC + '.hMarca', get(FORMULARIOC + '.cbMarca'));
				 set(FORMULARIOC + '.hCanal', get(FORMULARIOC + '.cbCanal'));
				 set(FORMULARIOC + '.hConcurso', get(FORMULARIOC + '.cbConcurso'));
				 set(FORMULARIOC + '.hNumPuntos', get(FORMULARIOC + '.txtNumPuntos'));
				 set(FORMULARIOC + '.hNumExig', get(FORMULARIOC + '.txtNumExig'));
				 set(FORMULARIOC + '.hTipoM', get(FORMULARIOC + '.cbTipoM'));
				 set(FORMULARIOC + '.hPeriodo', get(FORMULARIOC + '.cbPeriodo'));
				 set(FORMULARIOC + '.hDescrip', get(FORMULARIOC + '.txtDescrip'));

				 set(FORMULARIOC+'.conectorAction', 'LPMovimientoCtaCtePuntosInsertar');
				 set(FORMULARIOC+'.accion', 'guardar');
				 eval(FORMULARIOC).oculto = "S";
				 enviaSICC(FORMULARIOC,null,null,"N");

			 } 
		}
	 }

}


// Función que se ejecuta al buscar el código de un cliente.                                                                                                                                                   
function accionSeleccionarCliente(){                                                                           
          

    var arrCliente = mostrarModalSICC("LPBusquedaRapidaCliente", "", new Object(), null, null); 
          
    if (arrCliente != null && arrCliente.length > 1) {                                                 
         set(FORMULARIOC + '.txtCodCli', arrCliente[1].toString());                     
    }                                                                                                         
}

function codigoClienteOnBlur() { 
                                                                                                                                                                                                                     
         var codigoCliente = get(FORMULARIOC+'.txtCodCli').toString();                                      
    
    if (codigoCliente != '') {                                                                                            
         codigoCliente = codigoCliente.toUpperCase();                                                                
         var longitudCodigoCliente = get(FORMULARIOC + '.longitudCodigoCliente').toString();                    
         var longitud = codigoCliente.length;                                                                         
         
         set(FORMULARIOC + '.txtCodCli', rellenaCeros(codigoCliente, longitudCodigoCliente, longitud))
    }                                                                                                                         
} 

function fVolver(){
          window.close();
}

function onChangeMarca() {
                           
         var canal = get(FORMULARIOC + '.cbCanal');
    
    if (canal != ""){ 
         var marca = get(FORMULARIOC + '.cbMarca');
         
         if (marca != ""){
                  cargarCombosDep(marca, canal);
         } 
	}
}

function onChangeCanal() {
                           
    var marca = get(FORMULARIOC + '.cbMarca');
         
    if (marca != ""){ 
         var canal = get(FORMULARIOC + '.cbCanal');
                  
         if (canal != ""){
                  cargarCombosDep(marca, canal);
		 }
	}
}    

function arrayToString(valoresEntrada) {
	   var cadena = "[]";
	   if (valoresEntrada != null && valoresEntrada.length > 0) {
				 cadena = "[";
				 for (i = 0; i < valoresEntrada.length; i++) {
							cadena += "['" + valoresEntrada[i][0] + "', " + valoresEntrada[i][1] + "]";
							if (i < valoresEntrada.length-1) cadena += ", ";
				 }
				 cadena += "]";
	   }
	   return cadena	
}


function incluyeOpcionVacia(datos) {
	  var datos2 = new Array();
	  datos2[0] = ["", ""];//La opción vacía
	  for (var i = 0; i < datos.length; i++){
			   datos2[datos2.length] = datos[i];
	  }
	  return datos2;
}

function cargaPeriodos(datos) {
	  var opcionVacia = incluyeOpcionVacia(datos);
	  set_combo(FORMULARIOC + '.cbPeriodo', opcionVacia);
}
         
function cargaConcursos(datos) {
	  var opcionVacia = incluyeOpcionVacia(datos);
	  set_combo(FORMULARIOC + '.cbConcurso', opcionVacia);
}
function cargarCombosDep(marca, canal) {
	  var idioma = get(FORMULARIOC + '.idioma');
	  var pais = get(FORMULARIOC + '.pais');

	  parametrosRecargaCombos = new Array();

	  var parametros = new Array();
	  parametros[0] = FORMULARIOC + '.cbConcurso';   
	  parametros[1] = 'INCObtenerConcursosCombo';
	  parametros[2] = 'es.indra.sicc.dtos.inc.DTOBuscarConcursos';
	  parametros[3] = arrayToString([["oidPais", pais], ["oidMarca", marca], ["oidCanal", canal]]); //nos llegan como un array, debemos formatearlo a cadena
	  parametros[4] = 'cargaConcursos(datos)';
	  parametrosRecargaCombos[parametrosRecargaCombos.length] = parametros;

	  var parametros = new Array();
	  parametros[0] = FORMULARIOC + '.cbPeriodo';   
	  parametros[1] = 'CRAObtienePeriodos';
	  parametros[2] = 'es.indra.sicc.dtos.cra.DTOPeriodo';
	  parametros[3] = arrayToString([["pais", pais], ["marca", marca], ["canal", canal]]); //nos llegan como un array, debemos formatearlo a cadena
//	  parametros[4] = 'cargaPeriodos(datos)';
      parametros[4] = 'setearComboPeriodoValorActual(datos)';
	  parametrosRecargaCombos[parametrosRecargaCombos.length] = parametros;
	  recargaComboMultiple(parametrosRecargaCombos); 
}

function recargaComboMultiple(parametros) {
var i;
var instruccion = "asignar([";

for (i=0; i < parametros.length; ++i) {
	  instruccion = instruccion + "['COMBO', '" + parametros[i][0] + 
						 "', 'ConectorDruidaTransactionQuery', 'dtoSalida.resultado_ROWSET', " +
									 "formarCadenaDT('" + parametros[i][1] + "', '" + parametros[i][2] + 
									 "', " + parametros[i][3] + ")";
		if (parametros[i].length == 5)
				  instruccion = instruccion + ", '" + parametros[i][4] + "'";

		instruccion = instruccion + "]";
		if (i != parametros.length -1) {
		//Si no es la ultima fila ponemos la coma que separa del siguiente array                
				  instruccion = instruccion + ", ";
		}
}

instruccion = instruccion + "]);";
if (parametros.length > 0)
	  eval(instruccion);
}

function onTabBtnGuardar(){

		 focaliza(FORMULARIOC + ".txtFecha");
}

function onShTabBtnGuardar(){
                  
         focaliza(FORMULARIOC + ".cbPeriodo");
}

function fLimpiar(){
                  
        set(FORMULARIOC + '.cbCanal',[0]);
		set(FORMULARIOC + '.cbMarca',[0]);
		set(FORMULARIOC + '.cbTipoM',[0]);
		
		 vaciaCombo(FORMULARIOC + '.cbConcurso');
		 vaciaCombo(FORMULARIOC + '.cbPeriodo');
         set(FORMULARIOC + '.txtFecha','');
         set(FORMULARIOC + '.txtCodCli','');
         set(FORMULARIOC + '.txtNumPuntos','');
         set(FORMULARIOC + '.txtNumExig','');
         set(FORMULARIOC + '.txtDescrip','');
		 
}

function vaciaCombo(combo) {
         if (combo_get(combo,'L') >1){
                  set_combo(combo,[['','']],['']);
         }
}

function onShTabtxtFecha(){
	focaliza(FORMULARIOC + ".btnGuardar");
}

function vaciaGuardar(){
	fLimpiar();
}


function setearComboPeriodoValorActual(datos) {

	cargaPeriodos(datos);
	
	if(get(FORMULARIOC+'.hPeriodosActualesDefault')!="") {
        var oidPeriodoActualDefault = getPeriodoActualDefault(get(FORMULARIOC+'.cbMarca'), get(FORMULARIOC+'.cbCanal'));
		
        if (oidPeriodoActualDefault == null) {
			return;
        }

		set(FORMULARIOC+'.cbPeriodo', [[oidPeriodoActualDefault]]);
        
		
	}
}

function getPeriodoActualDefault(marca, canal) {
	var arrPeriodosActuales = periodosActualesToArray(get(FORMULARIOC+'.hPeriodosActualesDefault'));
	var cantPeriodos = arrPeriodosActuales.length;
	
	for (var i = 0; i < cantPeriodos; i++) {
		if (arrPeriodosActuales[i][0] == marca && arrPeriodosActuales[i][1] == canal) {
			return arrPeriodosActuales[i][2]; // el oidPeriodo
		}
	}
    return null;
}

function periodosActualesToArray(strMarcaCanalPeriodo) {
    var arrPeriodos = new Array();
	
	var arrayPeriodosAux = new Array();
    
    arrayPeriodosAux = strMarcaCanalPeriodo.split("|");
	var cantPeriodos = arrayPeriodosAux.length;
	
	for (var i = 0; i < cantPeriodos; i++) {
		arrPeriodos[i] = arrayPeriodosAux[i].split(",");
	}
	return arrPeriodos;
}