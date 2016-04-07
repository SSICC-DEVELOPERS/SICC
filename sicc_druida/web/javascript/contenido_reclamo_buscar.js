//Modulo REC paquete 40 contenido_reclamo_buscar

var FORMULARIOC = 'frmContenido';
var parametrosRecargaCombos = null;
var opcionMenu;
function onLoadPag(){
	
	setTimeout('evaluaError();',200);
    
    setTimeout('configurarMenuSecundario(FORMULARIOC);',200);
	focaliza(FORMULARIOC + ".txtNRecla");    
	opcionMenu = get(FORMULARIOC + '.opcionMenu');
}

function evaluaError (){
	var errDescripcion = get(FORMULARIOC +'.errDescripcion');
    
    if (errDescripcion !='') {
    	var errCodigo = get(FORMULARIOC+'.errCodigo');
        var wnd = fMostrarMensajeError(errCodigo, errDescripcion);
    }
}

function onClickBuscar() {
	
	// Llamamos a configurarPaginado pasándole los siguientes parametros: 
	
	// - Objeto paginado (lstResultados) 
	// - idBusiness ("RECObtenerReclamos") 
	// - "ConectorObtenerReclamosREC" 
	// - "DTOBuscarReclamosREC" 
	
	var casoUso = get (FORMULARIOC + '.casoUSO');
	var opcionMenuTMP = opcionMenu;
	
	if (casoUso == "modificarReclamo")
	{
		opcionMenuTMP = "modificar";
	}
	if ( sicc_validaciones_generales() ){
	
   		configurarPaginado(mipgndo, 
            "RECObtenerReclamos",
            "ConectorObtenerReclamos",
            "es.indra.sicc.dtos.rec.DTOBuscarReclamosREC",
             [["oidPais", get(FORMULARIOC + '.pais')], 
               ["oidIdioma", get(FORMULARIOC + '.idioma')], 
               ["numReclamo", get(FORMULARIOC + '.txtNRecla')], 
               ["codCliente", get(FORMULARIOC + '.txtCodCli')],
               ["nombre", get(FORMULARIOC + '.txtNomCli')],
               ["apellidoPaterno", get(FORMULARIOC + '.txtApellidoPaterno')],
               ["apellidoMaterno", get(FORMULARIOC + '.txtApellidoMaterno')],
               ["oidMarca", get(FORMULARIOC + '.cbMarca')],
               ["oidCanal", get(FORMULARIOC + '.cbCanal')],
               ["oidSGV", get(FORMULARIOC + '.cbSubCli')],
               ["oidRegion", get(FORMULARIOC + '.cbRegCli')],
               ["oidZona", get(FORMULARIOC + '.cbZonCli')],
               ["oidSeccion", get(FORMULARIOC + '.cbSecCli')],
               ["oidTerritorio", get(FORMULARIOC + '.cbTerrCli')],
               ["oidPerDesdeRef", get(FORMULARIOC + '.cbPerRefD')],
               ["oidPerHastaRef", get(FORMULARIOC + '.cbPerRefH')],
               ["oidPerDesdeRecl", get(FORMULARIOC + '.cbPerRecD')],
               ["oidPerHastaRecl", get(FORMULARIOC + '.cbPerRecH')],
               ["opcionMenu", opcionMenuTMP]
            ]);


	 }       
            	
}

function mostrarLista() {
	
	//var opcionMenu = get(FORMULARIOC + '.opcionMenu');

	DrdEnsanchaConMargenDcho('listado1',12);
    document.all["Cplistado1"].style.visibility='visible';
    document.all["CpLin1listado1"].style.visibility='visible';
    document.all["CpLin2listado1"].style.visibility='visible';
    document.all["CpLin3listado1"].style.visibility='visible';
    document.all["CpLin4listado1"].style.visibility='visible';
    document.all["primera1Div"].style.visibility='visible';
    document.all["ret1Div"].style.visibility='visible';
    document.all["ava1Div"].style.visibility='visible';
    document.all["separaDiv"].style.visibility='visible';
    
    if( opcionMenu == 'consultar'){
    	
    	document.all["btnDetalleDiv"].style.visibility='visible';
		document.all["btnModificarDiv"].style.visibility='hidden';
	
	}else if( opcionMenu == 'modificar') {
		
		document.all["btnModificarDiv"].style.visibility='visible';
		document.all["btnDetalleDiv"].style.visibility='hidden';
	} 
    if(listado1.datos.length==1){
		onClickModificar();
	}
    setTimeout('eval (ON_RSZ);',200);
    //ON_RSZ = '';
}

function ocultarLista() {
    document.all["Cplistado1"].style.visibility='hidden';
    document.all["CpLin1listado1"].style.visibility='hidden';
    document.all["CpLin2listado1" ].style.visibility='hidden';
    document.all["CpLin3listado1"].style.visibility='hidden';
    document.all["CpLin4listado1"].style.visibility='hidden';
    document.all["primera1Div"].style.visibility='hidden';
    document.all["ret1Div"].style.visibility='hidden';
    document.all["ava1Div"].style.visibility='hidden';
    document.all["separaDiv"].style.visibility='hidden';
    document.all["btnDetalleDiv"].style.visibility='hidden';
	document.all["btnModificarDiv"].style.visibility='hidden';
}

function muestraLista( ultima, rowset){                                                 
                                                                                        
	//var tamano = rowset.length;
    
    if (rowset.length > 0) {                                                             
    	mostrarLista();                                                       
        return true;                                                          
    } else {                                                                       
        ocultarLista();                                                       
        // No se ha encontrado ningún elemento con los criterios especificados
        //Control del foco                                                             
        focaliza(FORMULARIOC + ".txtNRecla");                          
        return false;                                                               
    }                                                                             
}

// Función que se ejecuta al buscar el código de un cliente.                                                                                                                                 
function accionSeleccionarCliente(){                                                                  
         
	//var objParametros = new Object();                                                            
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

function onChangeMarca() {
			
	var canal = get(FORMULARIOC + '.cbCanal');
    
    if (canal != ""){ 
    	var marca = get(FORMULARIOC + '.cbMarca');
        
        if (marca != "")
        	cargarCombosDep(marca, canal);
 	} 
 	
	vaciaCombo(FORMULARIOC + '.cbSubCli');
	vaciaCombo(FORMULARIOC + '.cbRegCli');
	vaciaCombo(FORMULARIOC + '.cbZonCli');
	vaciaCombo(FORMULARIOC + '.cbSecCli');
	vaciaCombo(FORMULARIOC + '.cbTerrCli');
	vaciaCombo(FORMULARIOC + '.cbPerRefD');
	vaciaCombo(FORMULARIOC + '.cbPerRefH');
	vaciaCombo(FORMULARIOC + '.cbPerRecD');
	vaciaCombo(FORMULARIOC + '.cbPerRecH');

}

function onChangeCanal() {
			
	var marca = get(FORMULARIOC + '.cbMarca');
    	
    if (marca != ""){ 
    	var canal = get(FORMULARIOC + '.cbCanal');
          	
        if (canal != "")
        	cargarCombosDep(marca, canal);
 	}
 	
	vaciaCombo(FORMULARIOC + '.cbSubCli');
	vaciaCombo(FORMULARIOC + '.cbRegCli');
	vaciaCombo(FORMULARIOC + '.cbZonCli');
	vaciaCombo(FORMULARIOC + '.cbSecCli');
	vaciaCombo(FORMULARIOC + '.cbTerrCli');
	vaciaCombo(FORMULARIOC + '.cbPerRefD');
	vaciaCombo(FORMULARIOC + '.cbPerRefH');
	vaciaCombo(FORMULARIOC + '.cbPerRecD');
	vaciaCombo(FORMULARIOC + '.cbPerRecH');

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
		set_combo(FORMULARIOC + '.cbPerRefD', opcionVacia);
		set_combo(FORMULARIOC + '.cbPerRefH', opcionVacia);
		set_combo(FORMULARIOC + '.cbPerRecD', opcionVacia);
		set_combo(FORMULARIOC + '.cbPerRecH', opcionVacia);
	}

	function cargaSubgerencias(datos) {
		set_combo(FORMULARIOC + '.cbSubCli', incluyeOpcionVacia(datos));
	}

	function cargarCombosDep(marca, canal) {
		var idioma = get(FORMULARIOC + '.idioma');
	    var pais = get(FORMULARIOC + '.pais');
	
		parametrosRecargaCombos = new Array();

		var parametros = new Array();
		parametros[0] = FORMULARIOC + '.cbSubCli';   
		parametros[1] = 'ZONRecargaSubgerenciaVentas';
		parametros[2] = 'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa';
		parametros[3] = arrayToString([["oidIdioma", idioma], ["oidPais", pais], ["oidMarca", marca], ["oidCanal", canal]]); //nos llegan como un array, debemos formatearlo a cadena
		parametros[4] = 'cargaSubgerencias(datos)';
		parametrosRecargaCombos[parametrosRecargaCombos.length] = parametros;
	
		var parametros = new Array();
		parametros[0] = FORMULARIOC + '.cbPerRefD';   
		parametros[1] = 'CRAObtienePeriodos';
		parametros[2] = 'es.indra.sicc.dtos.cra.DTOPeriodo';
		parametros[3] = arrayToString([["oidIdioma", idioma], ["pais", pais], ["marca", marca], ["canal", canal]]); //nos llegan como un array, debemos formatearlo a cadena
		parametros[4] = 'cargaPeriodos(datos)';
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

function onChangeSGV() {

	vaciaCombo(FORMULARIOC + '.cbRegCli');
	vaciaCombo(FORMULARIOC + '.cbZonCli');
	vaciaCombo(FORMULARIOC + '.cbSecCli');
	vaciaCombo(FORMULARIOC + '.cbTerrCli');

	var SubgerenciaVenta = get(FORMULARIOC + '.cbSubCli');
	var pais = get(FORMULARIOC + '.pais');
	
	if (SubgerenciaVenta != ""){
		recargaCombo(FORMULARIOC + '.cbRegCli', 
         				'ZONRecargaRegiones', 
         				'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa',  
         				[["oidPais", pais], ["oidSGV", SubgerenciaVenta]]);	
   }
}
 
function onChangeRegion() {

	vaciaCombo(FORMULARIOC + '.cbZonCli');
	vaciaCombo(FORMULARIOC + '.cbSecCli');
	vaciaCombo(FORMULARIOC + '.cbTerrCli');


	var region = get(FORMULARIOC + '.cbRegCli');
	var pais = get(FORMULARIOC + '.pais');
	var idioma = get(FORMULARIOC + '.idioma');
	
	if (region != ""){ 
		
		parametrosRecargaCombos = new Array();

		var parametros = new Array();
		parametros[0] = FORMULARIOC + '.cbZonCli';   
		parametros[1] = 'ZONRecargaZonas';
		parametros[2] = 'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa';
		parametros[3] = arrayToString([["oidIdioma", idioma], ["oidPais", pais], ["oidRegion", region]]); //nos llegan como un array, debemos formatearlo a cadena
		parametros[4] = 'cargaZonas(datos)';
		parametrosRecargaCombos[parametrosRecargaCombos.length] = parametros;
	
		var parametros = new Array();
		parametros[0] = FORMULARIOC + '.cbSecCli';   
		parametros[1] = 'ZONRecargaSecciones';
		parametros[2] = 'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa';
		parametros[3] = arrayToString([["oidIdioma", idioma], ["oidPais", pais], ["oidRegion", region]]); //nos llegan como un array, debemos formatearlo a cadena
		parametros[4] = 'cargaSecciones(datos)';
		parametrosRecargaCombos[parametrosRecargaCombos.length] = parametros;
        recargaComboMultiple(parametrosRecargaCombos); 
    }
}  

	function cargaZonas(datos) {
		set_combo(FORMULARIOC + '.cbZonCli', incluyeOpcionVacia(datos));
	}

	function cargaSecciones(datos) {
		set_combo(FORMULARIOC + '.cbSecCli', incluyeOpcionVacia(datos));
	}

function onChangeSeccion() {

 	vaciaCombo(FORMULARIOC + '.cbTerrCli');

	var seccion = get(FORMULARIOC + '.cbSecCli');
 	var pais = get(FORMULARIOC + '.pais');
 	
 	if (seccion != ""){ 
		recargaCombo(FORMULARIOC + '.cbTerrCli', 
         				'ZONRecargaTerritorios', 
         				'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa',  
         				[["oidPais", pais], ["oidSeccion", seccion]]);
    }
}   

function onClickDetalle() {
	//llamamos al modificar para ahorrar codigo , hacia lo mismo que el boton detalle
onClickModificar();
} 

function onClickModificar(){
	/*
	Si opcion de menu = "modificar" 
	Se muestra la ventana emergente y modal PgModificarReclamo con boton "generar" deshabilitado. 
	Llama a la LPMantenerReclamos con: 
	accion="detalleReclamo" 
	oid del registro seleccionado  
	*/
	
	numSelec = listado1.codSeleccionados();//listado1.numSelecc();
	if (numSelec.length == 0) {
		// Muestra el mensaje: "Debe seleccionar un elemento de la lista"
		GestionarMensaje('50'); 
	} else {
		if (numSelec.length != 1 ) {
    		//Muesta el mensaje: "Debe seleccionar un solo registro"
        	GestionarMensaje('8');
        	//deseleccionaListado();
    	} else {
        	// Abrimos una ventana emergente y direccionamos a la LPMantenerReclamos 
        	// con la accion "modificar", pasandole el oid de la fila que ha selecionado 
        	// el usuario.
        	var objParams = new Object();
        	var aux = '';
        	//var oid = listado1.codSeleccionados();
        	var oid = numSelec;
        	//Actualiza el array 'datos'
        	//listado1.actualizaDat(); 
        	datosFinal = listado1.datos;
        	var indice = DrIndiceEnArray(listado1.datos,numSelec[0],0);

        	/*for(i = 0; i < datosFinal.length; i++) {
        		var fila = datosFinal[i];
        		
            	if(fila[0] == oid){
            		aux = fila;
                	break;   
             	}
			}*/
			aux = listado1.datos[indice];
			for(j = 0; j < aux.length; j++) {
            	if(aux[j] == ""){
            		aux[j] = " ";
             	}
			}
			
        	objParams.oid = oid;
        	objParams.fila = aux;
        	objParams.opcionMenu = opcionMenu;//get(FORMULARIOC +'.opcionMenu');
        	
        	mostrarModalSICC('LPReclamosEnLinea', '', objParams, null, null);

   		}
	}
	

                  
}

function onTabBtnBuscar(){
	
	//var opcionMenu = get(FORMULARIOC + '.opcionMenu'); 
	
	if ( opcionMenu = 'consultar'){
    	if (listado1.datos.length > 0)
        	document.all['btnDetalle'].focus();
        else
        	focaliza(FORMULARIOC + ".txtNRecla");
	} else {
		if (listado1.datos.length > 0)
        	document.all['btnModificar'].focus();
        else
        	focaliza(FORMULARIOC + ".txtNRecla");
		
	} 
}

function onShTabBtnBuscar(){
		
	focaliza(FORMULARIOC + ".cbPerRecH");
}

function onTabBtnDetalle(){
		
	focaliza(FORMULARIOC + ".txtNRecla");
}

function onShTabBtnDetalle() {
		  
	if (listado1.datos.length > 0)
    	document.all['btnBuscar'].focus();
    else
    	document.all['btnBuscar'].focus();
}

function onTabBtnModificar(){
	
	focaliza(FORMULARIOC + ".txtNRecla");
}

function onShTabBtnModificar() {
	
	if (listado1.datos.length > 0)
    	document.all['btnBuscar'].focus();
    else
        document.all['btnBuscar'].focus();
}

function onShTabtxtNRecla(){
	//var opcionMenu = get(FORMULARIOC + '.opcionMenu'); 
	 
	if ( opcionMenu = 'consultar'){
    	if (listado1.datos.length > 0)
                    document.all['btnDetalle'].focus();
        else
                    document.all['btnBuscar'].focus();
	} else {
		if (listado1.datos.length > 0)
                    document.all['btnModificar'].focus();
        else
                    document.all['btnBuscar'].focus();
		
	} 
}

function fLimpiar(){
		
	vaciaCombo(FORMULARIOC + '.cbSubCli');
 	vaciaCombo(FORMULARIOC + '.cbRegCli');
 	vaciaCombo(FORMULARIOC + '.cbZonCli');
 	vaciaCombo(FORMULARIOC + '.cbSecCli');
 	vaciaCombo(FORMULARIOC + '.cbTerrCli');
 	vaciaCombo(FORMULARIOC + '.cbPerRefD');
 	vaciaCombo(FORMULARIOC + '.cbPerRefH');
 	vaciaCombo(FORMULARIOC + '.cbPerRecD');
 	vaciaCombo(FORMULARIOC + '.cbPerRecH');
}


function vaciaCombo(combo) {
	if (combo_get(combo,'L') >1){
		set_combo(combo,[['','']],['']);
	}

}
