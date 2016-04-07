var FORMULARIO = "frmFormulario"; 
var casoDeUso = ""; 

function onLoadPag(){

	var errDescripcion = get(FORMULARIO + '.errDescripcion');
	if(errDescripcion != '') {
		var errCodigo = get(FORMULARIO +'.errCodigo');
		var wnd = fMostrarMensajeError(errCodigo, errDescripcion);
	}
	casoDeUso = get(FORMULARIO +'.casoUso');
	
	if(casoDeUso=="modificar"){
		document.all["lblEstadoGeneracion"].style.visibility='hidden';		
		document.all.tags("SELECT")["cbEstadoGeneracion"].style.visibility='hidden' ;
		document.all["Detalle"].disabled=true ;
		document.all["Detalle"].style.visibility='hidden';
	}else{
		document.all["Aceptar"].disabled=true ;
		document.all["Aceptar"].style.visibility='hidden' ;
	}
	
	focaliza(FORMULARIO + ".txtNumeroGeneracion");
		
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
	

	eval (ON_RSZ);  
	onChangeCanal();
	//onChangeMarca();
	
	configurarMenuSecundario(FORMULARIO);
}

function focalizaAnterior(){
	if (listado1.datos.length > 0)
        document.all['Aceptar'].focus();
    else
    	document.all['btnBuscar'].focus();
	
}

function aMayusculas(campo){
         if (get(FORMULARIO+'.'+campo)!='') {
         set(FORMULARIO+'.'+campo,get(FORMULARIO+'.'+campo).toUpperCase());
    }
}

function codigoClienteOnBlur(){
	var codigoCliente = get(FORMULARIO+'.txtCodigoCliente').toString();
	if (codigoCliente != '') {
	var longitudCodigoCliente = get(FORMULARIO+'.numDigitosCodigoCliente').toString();
	var longitud = codigoCliente.length;
	         set(FORMULARIO + '.txtCodigoCliente', rellenaCeros(codigoCliente, longitudCodigoCliente, longitud))
	}
}

function validarNumerico(texto){
         var num = get(FORMULARIO+'.'+texto); 
    if(num != ""){
         var val = allTrim(num);                
         //Como no nos interesa validar el número de dígitos que tiene el 
         //entero ponemos uno suficientemente grande. 
         if ((ValidaInt(val.toString(),10000, 0)!="OK")||(val.toString() < 0)) {
                  GestionarMensaje('747', null, null, null);
             focaliza(FORMULARIO+'.'+texto);
             return false;
         }
    }
}
function allTrim(sStr){ 
         return rTrim(lTrim(sStr)); 
}
function lTrim(sStr){ 
         while (sStr.charAt(0) == " "){
         sStr = sStr.substr(1, sStr.length - 1); 
    }
    return sStr; 
} 
function rTrim(sStr){ 
         while (sStr.charAt(sStr.length - 1) == " ") {
         sStr = sStr.substr(0, sStr.length - 1); 
    }
    return sStr; 
}  

function comprobarFecha(txtFecha){
	var fecha = get(FORMULARIO+'.'+txtFecha);
	if(fecha != ""){
		var resul = EsFechaValida(fecha,fecha, FORMULARIO,null);
	    if(resul==1 || resul==2){  
	 		GestionarMensaje('1006', get(FORMULARIO+'.hFormatoFechaPais')); 
	        focaliza(FORMULARIO+'.'+txtFecha);
	        return ;
		}
    }
} 

function mostrarLista(){
    
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
    /*document.all["AceptarDiv"].style.visibility='visible';*/
	/*document.all["DetalleDiv"].style.visibility='visible';*/
	
	/* ------------ */
	if (casoDeUso == "modificar"){
		document.all["AceptarDiv"].style.visibility='visible';
	} else {
		/* visibilidad ('capaDetalle', 'hidden'); */
		document.all["DetalleDiv"].style.visibility='visible';
	}
	/* ------------ */

    eval (ON_RSZ);
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
    document.all["AceptarDiv"].style.visibility='hidden';
    document.all["DetalleDiv"].style.visibility='hidden';
}

function muestraLista( ultima, rowset){                                                        
                                                                                                    
         var tamano = rowset.length;                                                           
    if (tamano > 0) {                                                                      
         mostrarLista();                                                              
         return true;                                                                  
    } else {                                                                                 
         ocultarLista();                                                              
         // No se ha encontrado ningún elemento con los criterios especificados
         //Control del foco                                                                     
         focaliza(FORMULARIO + ".txtNumeroGeneracion");                             
         return false;                                                                        
    }                                                                                        
}                          

function focalizaSiguienteBuscar(){
	if (listado1.datos.length > 0)
		document.all['Aceptar'].focus();
    else
    	focaliza(FORMULARIO +'.txtNumeroGeneracion');
}

function iconoCliente(){    
    //Llamamos al proceso correspondiente Modal
    var objParams = new Object();
    var cliente = mostrarModalSICC('LPBusquedaRapidaCliente', '', objParams, null, null);           

    if (cliente != null && cliente.length > 1) {
          var codigoCliente = cliente[1];
          set(FORMULARIO+'.txtCodigoCliente',codigoCliente);
    }
}

function onClickBuscar(){


	/*Llamamos a configurarPaginado pasándole los siguientes parametros: 
	- Objeto paginado (lstResultados) 
	- idBusiness ("REC") 
	- "ConectorBuscarCambiosPrecios" 
	- "DTODetallePreRec" 
	- Parametros del DTOBuscarCambiosPrecios: (además del pais y el idioma) 
	- numGenreacion 
	- oidMarca 
	- oidCanal 
	- oidAcceso 
	- oidSubAcceso 
	- stringTipoSolicitud: concatenamos los oids de los valores seleccionados en la cbTipoSolicitud, separados por # 
	- numSolicitud 
	- oidPeriodoReferencia 
	- codCliente 
	- codVenta 
	- codVentaGenerar 
	- oidOperacion 
	- oidTipoOperacion 
	- fechaGeneracion 
	- oidEstadoGeneracion */
	var pais = get(FORMULARIO + '.pais');
    var idioma = get(FORMULARIO + '.idioma');
    var numGeneracion = get(FORMULARIO + '.txtNumeroGeneracion');
    var oidMarca = get(FORMULARIO + '.cbMarca');
    var oidCanal = get(FORMULARIO + '.cbCanal');
    var oidAcceso = get(FORMULARIO + '.cbAcceso');
    var oidSubAcceso = get(FORMULARIO + '.cbSubAcceso');		
    var stringTipoSolicitud = get(FORMULARIO + '.cbTipoSolicitud');
	var numSolicitud = get(FORMULARIO + '.txtNumeroSolicitud');
    var oidPeriodoReferencia = get(FORMULARIO + '.cbPeriodoReferencia');
    var codCliente = get(FORMULARIO + '.txtCodigoCliente');
    var codVenta = get(FORMULARIO + '.txtCodigoVenta');
    var codVentaGenerar = get(FORMULARIO + '.txtCodigoVentaGenerar');
    var oidOperacion = get(FORMULARIO + '.cbCodigoOperacionReclamos');
	var oidTipoOperacion = get(FORMULARIO + '.cbTipoOperacion');
	var fechaGeneracion = get(FORMULARIO + '.txtFechaGeneracion');
	var oidEstadoGeneracion =  get(FORMULARIO + '.cbEstadoGeneracion');
//		Eliminado por   BELC300015924 y agregado por 24040
   
	
	var stringTS='';
	if(stringTipoSolicitud.length>0){
		stringTS = stringTipoSolicitud[0];
	}
	for( i = 1; i < stringTipoSolicitud.length; i++ ){
		stringTS =  stringTS + ',' + stringTipoSolicitud[i];
	}
	var valido = "";	
	if(casoDeUso=="modificar"){
		valido = sicc_validaciones_generales('modificar');
	}else{
		valido = sicc_validaciones_generales();	
	}

	if(valido){
		configurarPaginado(mipgndo,"RECBuscarCambiosPrecios",
			  "ConectorBuscarCambiosPrecios","es.indra.sicc.dtos.rec.DTOBuscarCambiosPrecios",
			  [["oidPais", pais], 
			  ["oidIdioma", idioma], 
			  ["numGeneracion", numGeneracion], 
			  ["oidMarca", oidMarca],
			  ["oidCanal",oidCanal],
			  ["oidAcceso",oidAcceso],
			  ["oidSubAcceso",oidSubAcceso],
			//  ["stringTipoSolicitud",stringTipoSolicitud],
		["stringTipoSolicitud",stringTS],	
			  ["numSolicitud",numSolicitud],
			  ["oidPeriodo",oidPeriodoReferencia],
			  ["codCliente",codCliente],
			  ["codVenta",codVenta],
			  ["codVentaGenerar",codVentaGenerar],
			  ["oidOperacion",oidOperacion],
			  ["oidTipoOperacion",oidTipoOperacion],
			  ["fechaGeneracion",fechaGeneracion] ,
			  ["oidEstadoGeneracion",oidEstadoGeneracion]  //Eliminado por BELC300015924 agregado por la 24040
			  ]);    
	   
		
	/*	   var arr = new Array();
	 
		   arr[arr.length] = ["oidPais", pais];
		   arr[arr.length] = ["oidIdioma", idioma];
		   arr[arr.length] = ["oidMarca", oidMarca];
		   arr[arr.length] = ["oidCanal",oidCanal];
		   arr[arr.length] = ["oidAcceso",oidAcceso];
		   arr[arr.length] = ["oidSubAcceso",oidSubAcceso];
		   arr[arr.length] = ["stringTipoSolicitud",stringTipoSolicitud];
		   arr[arr.length] = ["numSolicitud",numSolicitud];
		   arr[arr.length] = ["oidPeriodo",oidPeriodoReferencia];
			arr[arr.length] = ["codCliente",codCliente];
		   arr[arr.length] = ["codVenta",codVenta];
		   arr[arr.length] = ["codVentaGenerar",codVentaGenerar];
		   arr[arr.length] = ["oidOperacion",oidOperacion];
		   arr[arr.length] = ["oidTipoOperacion",oidTipoOperacion];
		   arr[arr.length] = ["fechaGeneracion",fechaGeneracion];
		  
			
			 configurarPaginado(mipgndo,"RECBuscarCambiosPrecios",
			   "ConectorBuscarCambiosPrecios","es.indra.sicc.dtos.rec.DTOBuscarCambiosPrecios", arr);
	 */



		focaliza(FORMULARIO + ".txtNumeroGeneracion");
	}
}



function vaciaCombo(combo) {
	set_combo(combo, [['','']], ['']);	
}

function onChangeAcceso(){

	/*Documentation
	Llamar al método recargaCombo utilizando el DTOOid y el idBusiness = "SEGObtenerSubccesosPorAcceso". 
	Parametro del DTOOid: 
	-DTOOid.oid=oid del valor seleccionado en la cbAcceso 
	Obtenemos un DTOSalida y cargamos el combo cbSubAcceso
	*/
	        
	accesoSeleccionado = get(FORMULARIO + '.cbAcceso');
	
	if (accesoSeleccionado != '') {
		recargaCombo(FORMULARIO + '.cbSubAcceso', 'SegObtenerSubaccesosPorAcceso','es.indra.sicc.util.DTOOID', 
	                 [["oid", accesoSeleccionado],
	                  ["oidPais", get(FORMULARIO + '.pais')],
	                  ["oidIdioma",get(FORMULARIO + '.idioma')]]
	                 );
	} else { // se ha seleccionado un acceso vacio
		vaciaCombo(FORMULARIO + '.cbSubAcceso');
	}
}

function onChangeCanal(){

	/*Llamar al método recargaCombo utilizando el DTOOid y el idBusiness = "SEGObtieneAccesosPorCanal". 
	Parametro del DTOOid: 
	-DTOOid.oid=oid del valor seleccionado en la cbCanal 
	Obtenemos un DTOSalida y cargamos el combo cbAcceso 
	*/
	if (get(FORMULARIO + '.cbCanal') != '') {
    	recargaCombo(FORMULARIO + '.cbAcceso','SEGObtieneAccesosPorCanal','es.indra.sicc.util.DTOOID', 
                     [["oid", get(FORMULARIO + '.cbCanal')],
                      ["oidPais",get(FORMULARIO + '.pais')],
                      ["oidIdioma",get(FORMULARIO + '.idioma')]]);	
                  
        // Si hay un valor seleccionado en la cbMarca 
        marcaSeleccionada = get(FORMULARIO + '.cbMarca');
        if (marcaSeleccionada != '') {
        	// Llamar al método recargaCombo utilizando el DTOPeriodo y el idBusiness = "CRAObtienePeriodos". 
        	
        	// Parametro del DTOPeriodo: (además del pais) 
        	// -DTOPeriodo.marc_oid_marc=oid del valor seleccionado en la cbMarca 
        	// -DTOPeriodo.periodo.cana_oid_cana=oid del valor seleccionado en la cbCanal
        	// Obtenemos un DTOSalida y cargamos el combo cbPeriodo 
        	canalSeleccionado = get(FORMULARIO + '.cbCanal');
        		//pzerbino 20/10/2006 Incidencia DBLG700000109	
       	/*recargaCombo(FORMULARIO + '.cbPeriodoReferencia', 'CRAObtienePeriodosRecMasivos','es.indra.sicc.dtos.cra.DTOPeriodo', 
                         [["oidPais", get(FORMULARIO + '.pais')],
                          ["oidIdioma",get(FORMULARIO + '.idioma')],
                          ["marca", marcaSeleccionada],
                          ["canal", canalSeleccionado],
                          ["duracion", "21"] //variabe seteado por 21 que es duracion de periodos a caragr en el combo
                         ]
                         );	*/
		recargaCombo(FORMULARIO + '.cbPeriodoReferencia', 'CRAObtienePeriodos','es.indra.sicc.dtos.cra.DTOPeriodo', 
                         [["oidPais", get(FORMULARIO + '.pais')],
                          ["oidIdioma",get(FORMULARIO + '.idioma')],
                          ["marca", marcaSeleccionada],
                          ["canal", canalSeleccionado]
                         ]
                         );	
        }
	} else { // seleccionado vacio en combo canal, por lo que vaciamos los combos acceso y subacceso
    	vaciaCombo(FORMULARIO + '.cbAcceso');
        vaciaCombo(FORMULARIO + '.cbSubAcceso');
    }
}

function onChangeMarca(){
                                                                                                                                                                         
	/*Si hay un valor seleccionado en la cbMarca{                                                    
	Llamar al método recargaCombo utilizando el DTOPeriodo y el idBusiness = "CRAObtienePeriodos". 
	                                                                                               
	Parametro del DTOPeriodo: (además del pais)                                                    
	-DTOPeriodo.marc_oid_marc=oid del valor seleccionado en la cbMarca                             
	-DTOPeriodo.periodo.cana_oid_cana=oid del valor seleccionado en la cbCanal                     
	                                                                                               
	Obtenemos un DTOSalida y cargamos el combo cbPeriodo 
	*/
	marcaSeleccionada = get(FORMULARIO + '.cbMarca');
    if (marcaSeleccionada != '') {
                               
    	canalSeleccionado = get(FORMULARIO + '.cbCanal');
		//pzerbino 20/10/2006 Incidencia DBLG700000109
        /*recargaCombo(FORMULARIO + '.cbPeriodoReferencia', 'CRAObtienePeriodosRecMasivos', 'es.indra.sicc.dtos.cra.DTOPeriodo', 
                     [	
                      ["oidPais", get(FORMULARIO + '.pais')],
                      ["oidIdioma",get(FORMULARIO + '.idioma')],
                      ["marca", marcaSeleccionada],
                      ["canal", canalSeleccionado],
                      ["duracion", "21"] //variabe seteado por 21 que es duracion de periodos a caragr en el combo
                     ]);*/

		recargaCombo(FORMULARIO + '.cbPeriodoReferencia', 'CRAObtienePeriodos', 'es.indra.sicc.dtos.cra.DTOPeriodo', 
                     [	
                      ["oidPais", get(FORMULARIO + '.pais')],
                      ["oidIdioma",get(FORMULARIO + '.idioma')],
                      ["marca", marcaSeleccionada],
                      ["canal", canalSeleccionado]
                     ]);
    } else { // vaciamos el combo cbPeriodoReferencia
    	vaciaCombo(FORMULARIO + '.cbPeriodoReferencia');
    }                                          
}

function onChangecodOperacion(){
                                                                                                                                                                                                                                                                                             
	/*Llamar al método recargaCombo utilizando el DTOOid y el idBusiness = "RECObtenerTiposOperacionAgregar".                                                                                                 
	Parametro del DTOOid:                                                                                   
	-DTOOid.oid=oid del valor seleccionado en la cbCodOperacion                                             	                                                                                                        
	Obtenemos un DTOSalida y cargamos el combo cbTipoOperacion    
	*/
	if (get(FORMULARIO + '.cbCodigoOperacionReclamos') != '') {

    	recargaCombo(FORMULARIO + '.cbTipoOperacion', 'RECObtenerTiposOperacionAgregar','es.indra.sicc.util.DTOOID', 
                     [	
                      ["oid", get(FORMULARIO + '.cbCodigoOperacionReclamos')],
                      ["oidPais", get(FORMULARIO + '.pais')],
                      ["oidIdioma",get(FORMULARIO + '.idioma')]
                     ] );	
    } else { // si se ha elegido el codigo vacio se vacia el combo de tipo operacion
    	vaciaCombo(FORMULARIO + '.cbTipoOperacion');
    }
} 
function onClickDetalle(){

 onClickAceptar();

}
function onClickAceptar(){

	/*El susuario selecciona un registro de la lstResultados y le da a aceptar 
	Si solo se ha seleccionado un registro de la lstResultados { 
	Muestra ventana emergente y modal y llama a la LPCabiosPreciosRec con: 
	- accion = "modificar" 
	- los campos del registro seleccionado 
	} 
	Otro caso { 
	Mostrar el error correspondiente 
	} 
	// Al retornar de la ventana emergente y modal 
	Refrescar la lstResultados */


	if (listado1.numSelecc() == 0) {   
         // Muestra el mensaje: "Debe seleccionar un elemento de la lista"
         GestionarMensaje('50');
    }else {                                                                                                                  
    	if (listado1.numSelecc() != 1 ) {                                              
        	//Muesta el mensaje: "Debe seleccionar un solo registro"
            GestionarMensaje('8');
            var seleccion=listado1.codigos();
            var i=0;
            while(seleccion[i]!=null){
            	listado1.deselecciona(i); 
                i++; 
             }            
		}else {
        	var objParams = new Object();
            var aux = '';
            var codVenta = '';
            var codVentaGen = ''; 
            var oid = listado1.codSeleccionados();
       		
    		listado1.actualizaDat(); //Actualiza el array 'datos'
            datosFinal = listado1.datos;
            for(i = 0; i < datosFinal.length; i++) {
            	var fila = datosFinal[i];
            	for(j=0;j<fila.length;j++){
            		if (fila[j] == "" ){
                		fila[j] = "-";
                	}
            	}	 
                if(fila[0] == oid){
                	aux += fila[1]+","+fila[2]+","+fila[3]+","+fila[4]+","+fila[5]+",";
                	codVenta = fila[2];
                	codVentaGen = fila[3];
                    break;	
                }
            }
            objParams.oid = oid;
            objParams.fila = aux;
            objParams.codVenta = codVenta;   
            objParams.codVentaGen = codVentaGen;
       
			if(casoDeUso=="consultar"){ 
			    objParams.consulta = "true";
			}
			mostrarModalSICC('LPCambiosPreciosRec', 'modificar', objParams, null, null);
    		mipgndo.recargar();
        }
    
    }
}

                                         