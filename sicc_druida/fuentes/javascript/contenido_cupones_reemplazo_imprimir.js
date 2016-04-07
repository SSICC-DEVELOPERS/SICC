 var FORMULARIO = 'frmFormulario';
 var matriz = new Array();

 function onLoadPag()   {
 
        var errDescripcion = get(FORMULARIO +'.errDescripcion');
    	if (errDescripcion !='') {           
        	var errCodigo = get(FORMULARIO+'.errCodigo');
         	var wnd = fMostrarMensajeError(errCodigo, errDescripcion);
    	}
			
    	focaliza(FORMULARIO + ".cbMarca");
    	
    	configurarMenuSecundario(FORMULARIO);
  	
	DrdEnsanchaConMargenDcho('listado1',12);
    	eval (ON_RSZ);  

   }
     
   
function onShTabBtnBuscar(){
	focaliza(FORMULARIO + ".cbMarca");
}

function onShTabCbMarca() {
         if (listado1.datos.length > 0)
                  document.all['btnImprimir'].focus();
         else
                  document.all['btnBuscar'].focus();
}

function onTabBuscar(){
         if (listado1.datos.length > 0) {
                              document.all['btnImprimir'].focus();
                    }else{                                        
                              focaliza(FORMULARIO + ".cbMarca");              
                    }     
}

function onShTabBtnImprimir(){
	 document.all['btnBuscar'].focus();
}

function onTabBtnImprimir(){
	 focaliza(FORMULARIO + ".cbMarca");
}

/* Modificado por incidencia DBLG500000515 - dmorello, 10/05/2006 */
function muestraLista(ultima, rowset) {
            var tamano = rowset.length;
            if (tamano > 0) {
                //return true;
				listado1.setDatos(rowset);
				//for (var i = 0; i < tamano; i++) {
				//	listado1.selecciona(i);	
				//}
                visibleLista();
				return true;
            } else {
                         invisibleLista();
                         focaliza(FORMULARIO + ".cbMarca");
                         return false;
            }
}

function visibleLista(){
            
	if (!get_visibilidad('capaLista')){
        visibilidad('capaLista','V');
    }
}

function invisibleLista() {
            
	if (get_visibilidad('capaLista')){
        visibilidad('capaLista','O');
    }
}  

function canalOnChange(){
	
	var canal = get(FORMULARIO+'.cbCanal');
         
         if (canal != '') {
                  var marca = get(FORMULARIO+'.cbMarca');
                  if (marca != '') {
                           var pais = get(FORMULARIO+'.pais');

                           recargaCombo(
                                    FORMULARIO + '.cbPeriodo',
                                    'CRAObtienePeriodos', 
                                    'es.indra.sicc.dtos.cra.DTOPeriodo', 
                                    [["pais", pais], ["marca", marca], ["canal", canal]]			
                           )

		}
	}
}

function marcaOnChange(){
	 
	 var pais = get(FORMULARIO+'.pais');
         var marca = get(FORMULARIO+'.cbMarca');
         var canal = get(FORMULARIO+'.cbCanal');
	
         if (marca != '' && canal != '') {
                  recargaCombo(
                           FORMULARIO + '.cbPeriodo',
                           'CRAObtienePeriodos', 
                           'es.indra.sicc.dtos.cra.DTOPeriodo', 
                           [["pais", pais], ["marca", marca], ["canal", canal]]			
                  )

	}
}

function onClickBuscar(){
		
	if (sicc_validaciones_generales()){
		var idioma = get(FORMULARIO +'.idioma');
		var pais = get(FORMULARIO+'.pais');
		var marca = get(FORMULARIO+'.cbMarca');
		var canal = get(FORMULARIO+'.cbCanal');
		var periodo = get(FORMULARIO+'.cbPeriodo');
		var fechaFacturacion = get(FORMULARIO+'.textFechaFacturacionDesde');
		
		var codCliente = "";
	    for (i=0; i<matriz.length ; i++){
				codCliente +=  "'" + matriz[i][0] + "',";
			
		}
		codCliente = codCliente.substring(0,codCliente.length-1);
				
		var regionDesde = get(FORMULARIO+'.textRegionDesde');
		var regionHasta = get(FORMULARIO+'.textRegionHasta');
		var zonaDesde = get(FORMULARIO+'.textZonaDesde');
		var zonaHasta = get(FORMULARIO+'.textZonaHasta');
		var seccionDesde = get(FORMULARIO+'.textSeccionDesde');
		var seccionHasta = get(FORMULARIO+'.textSeccionHasta');
		var territorioDesde = get(FORMULARIO+'.textTerritorioDesde');
		var territorioHasta = get(FORMULARIO+'.textTerritorioHasta');
		
		if(validarDatos()){
			configurarPaginado(mipgndo, 'FACConsultarConsolidadoCupones', 'ConectorConsultarConsolidadosCupones', 
                                        'es.indra.sicc.dtos.fac.DTODatosCupones', 
                                         [['oidIdioma',idioma],
                                         ['oidPais',pais],                                    
                                         ['marca', marca],
                                         ['canal', canal], 
                                         ['periodo', periodo],
                                         ['fechaFacturacion',fechaFacturacion],
                                         ['codCliente',codCliente],
                                         ['regionDesde',regionDesde],
                                         ['regionHasta',regionHasta] ,                                   
                                         ['zonaDesde',zonaDesde],
                                         ['zonaHasta',zonaHasta],
                                         ['seccionDesde',seccionDesde],
                                         ['seccionHasta',seccionHasta],
                                         ['territorioDesde',territorioDesde],
                                         ['territorioHasta',territorioHasta]] );
       
      }

	}
	       
}

function onClickImprimir(){
	// Se ejecuta cuando el usuario pulsa el botón 'btnImprimirr' 
        if (listado1.numSelecc() == 0) {
        	// Muestra el mensaje: "Debe seleccionar al menos un elemento de la lista"
                GestionarMensaje('1021');
        } else {
		set(FORMULARIO+'.accion','imprimir');
        	set(FORMULARIO+'.conectorAction','LPImprimirCuponesReemplazo');	

		var cadenaCodigos = "";
		var codigosSeleccionados = listado1.codSeleccionados();
		for (i = 0; i < codigosSeleccionados.length; i++) {
			cadenaCodigos += listado1.extraeDato(codigosSeleccionados[i], 0) + ",";
		}

				set(FORMULARIO + '.codigos', cadenaCodigos);                                  
             	enviaSICC(FORMULARIO,null,null,'N');
	}
}

function operacionCorrecta() {
         //Muestra el mensaje: "Operación realizada correctamente" (UIFAC0008)
         cdos_mostrarAlert(GestionarMensaje('1449'));
         focaliza(FORMULARIO + ".cbMarca");
}

// Función que se ejecuta al buscar el código de un cliente.
function accionSeleccionarCliente(){
	var objParametros = new Object();
        var arrCliente = mostrarModalSICC("LPBusquedaRapidaCliente", "", objParametros, null, null);
        
        if (arrCliente != null && arrCliente.length > 1) {
        	set(FORMULARIO + '.textCodigoCliente', arrCliente[1].toString());
        }
}

function anyadir(){
	
	var codigo = get(FORMULARIO + '.textCodigoCliente');
	var flag = 1;	
	
    	for (i=0; i < matriz.length; i++) { 
        	if (matriz[i][0] != codigo) { 
                	flag = 1;
        	} else {
        		flag = 0;
        		break;
        	}
        }
        
        if (flag){
          matriz[matriz.length] = [codigo,codigo];
    	  set_combo(FORMULARIO + '.cbCodCliente', matriz, ['']);
        }
}

function eliminar(){
	
	var codigo = get(FORMULARIO + '.cbCodCliente');
	var matrizAux = new Array();
        
        for (i=0; i < matriz.length; i++) { 
        	if (matriz[i][1] !=  codigo) { 
                	matrizAux [matrizAux.length] = [matriz[i][0], matriz[i][1]]; 
        	}
        }
       	matriz = matrizAux;
        set_combo(FORMULARIO + '.cbCodCliente', matrizAux, ['']);
	
}

function fVolver(){
	window.close();
}

function fLimpiar() {
	vaciaCombo(FORMULARIO + '.cbCodCliente');
        vaciaCombo(FORMULARIO + '.cbPeriodo');
        focaliza(FORMULARIO + ".cbMarca");
}

//valida la fecha si el campo es modificable y no vacío 
function validaFecha(fecha) {
	if (get(FORMULARIO + '.' + fecha) != "") {
        	var resul = EsFechaValida(get(FORMULARIO + '.' + fecha), get(FORMULARIO + '.' + fecha), FORMULARIO, null);
                	if (resul == 1 || resul == 2) { 
                        	GestionarMensaje('1006', get(FORMULARIO + '.hFormatoFechaPais'));
                                focaliza(FORMULARIO + '.' + fecha);
                                return false;
                        }
        }
} 

function vaciaCombo(combo) {
	set_combo(combo,[['','']],['']);
	matriz = new Array();
}

function codigoClienteOnBlur() {
	var codigoCliente = get(FORMULARIO+'.textCodigoCliente').toString();
        if (codigoCliente != '') {
        	codigoCliente = codigoCliente.toUpperCase();
                var longitudCodigoCliente = get(FORMULARIO + '.longitudCodigoCliente').toString();
               	var longitud = codigoCliente.length;
                set(FORMULARIO + '.textCodigoCliente', rellenaCeros(codigoCliente, longitudCodigoCliente, longitud))
        }
}

function validarDatos() {
	
	var regionDesde = get(FORMULARIO+'.textRegionDesde');
	var regionHasta = get(FORMULARIO+'.textRegionHasta');
	var zonaDesde = get(FORMULARIO+'.textZonaDesde');
	var zonaHasta = get(FORMULARIO+'.textZonaHasta');
	var seccionDesde = get(FORMULARIO+'.textSeccionDesde');
	var seccionHasta = get(FORMULARIO+'.textSeccionHasta');
	var territorioDesde = get(FORMULARIO+'.textTerritorioDesde');
	var territorioHasta = get(FORMULARIO+'.textTerritorioHasta');
	
	if (regionDesde > regionHasta) {
        //Muestra el mensaje: "Región (ó zona ó sección ó territorio) desde debe ser menor o igual que hasta" (UIFAC0012)
     	cdos_mostrarAlert(GestionarMensaje('UIFAC0012'));
     	focaliza(FORMULARIO + '.textRegionDesde');
     	return false;
    }else if (zonaDesde > zonaHasta) {
    	//Muestra el mensaje: "Región (ó zona ó sección ó territorio) desde debe ser menor o igual que hasta" (UIFAC0012)
        cdos_mostrarAlert(GestionarMensaje('UIFAC0012'));
        focaliza(FORMULARIO + '.textZonaDesde');
        return false; 
    }else if (seccionDesde > seccionHasta) {
    	//Muestra el mensaje: "Región (ó zona ó sección ó territorio) desde debe ser menor o igual que hasta" (UIFAC0012)
        cdos_mostrarAlert(GestionarMensaje('UIFAC0012'));
        focaliza(FORMULARIO + '.textSeccionDesde');
        return false; 
    }else if (territorioDesde > territorioHasta) {
    	//Muestra el mensaje: "Región (ó zona ó sección ó territorio) desde debe ser menor o igual que hasta" (UIFAC0012)
        cdos_mostrarAlert(GestionarMensaje('UIFAC0012'));
        focaliza(FORMULARIO + '.textTerritorioDesde');
        return false; 
    }else {
    	return true;
    }


}


/*
 * DBLG500000515 - dmorello, 18/05/2006: Esta función selecciona todas las filas de la lista.
 * Se llama desde la página luego de setear los datos de la misma.
 */
function seleccionarFilas() {
  var largo = listado1.datos.length;
  for(var i = 0; i < largo; i++){
    listado1.selecc[i] = 1;
  }
  // dmorello, 06/06/2006: Se deshabilita el botón de avance si estamos en la última página
  if(listado1.datos[largo-1][0]==listado1.datos[largo-1][12]){
	mipgndo.ava.setTipo(0);
  }
}