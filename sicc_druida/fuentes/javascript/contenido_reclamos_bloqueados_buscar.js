var FORMULARIO = 'frmContenido';
var motivoDesbloqueo = false;
var motivoRechazo = false;

function onLoadPag(){           

	focaliza(FORMULARIO + ".txtNatencion");
	
	var errDescripcion = get(FORMULARIO +'.errDescripcion');
    if (errDescripcion !='') {
     	var errCodigo = get(FORMULARIO+'.errCodigo');
        var wnd = fMostrarMensajeError(errCodigo, errDescripcion);
    }

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
	dehabilitarCombos();
	configurarMenuSecundario(FORMULARIO);
	
}

function onClickBuscar(){
	/*Llamamos a configurarPaginado pasándole los siguientes parametros: 
	- Objeto paginado (lstResultados) 
	- idBusiness ("RECObtenerReclamosGestion") 
	- "ConectorObtenerReclamosGestion" 
	- "DTOBuscarReclamosREC" 
	- Parametros del DTOBuscarReclamosREC: 
	- dto.numAtencion = numAtencion 
	- dto.numDocReferencia = numDocReferencia 
	- dto.codCliente = codCliente 
	- dto.oidsOperaciones = array formado por los oids de los valores seleccionados en el combo operacioReclamos 
	- dto.oidsTiposBloqueo = array formado por los oids de los valores seleccionados en el combo tipoBloqueo 
	- dto.mostrarSoloRechazadas = chkMostrarSoloRechazadas 
	- dto.fechaReclamoDesde = fechaReclamoDesde 
	- dto.fechaReclamoHasta = fechaReclamoHasta 
	- dto.reclamosEnLinea = chkReclamosEnLinea 
	- dto.reclamosDigitados = chkReclamosDigitados 
	- oidMarca = oid del valor seleccionado en la cbMarca 
	- oidCanal = oid del valor seleccionado en la cbCanal 
	- oidPerDesdeRef = oid del valor seleccionado en la cbPeriodoDesdeReferencia 
	- oidPerHastaRef = oid del valor seleccionado en la cbPeriodoHastaReferencia 
	*/
	var pais = get(FORMULARIO + '.pais');
    var idioma = get(FORMULARIO + '.idioma');
	var numAtencion = get(FORMULARIO +'.txtNatencion');
	var numDocReferencia = get(FORMULARIO +'.txtNumDocRef'); 
	var codCliente = get(FORMULARIO +'.txtCodCliente');
	
	var oidsOperaciones = new String(get(FORMULARIO+'.cbOperacion').toString());
	/*arrayOidsOp = oidsOp.split(",");
	var oidsOperaciones = '';
	for(i=0;i<arrayOidsOp.length;i++){
		oidsOperaciones += arrayOidsOp[i] + "#";
	}*/
	
	
	var oidsTiposBloqueo = new String(get(FORMULARIO+'.cbTipoBloqueo').toString());
	/*arrayOidsTB = oidsTB.split(",");
	var oidsTiposBloqueo = '';
	for(i=0;i<arrayOidsTB.length;i++){
		oidsTiposBloqueo += arrayOidsTB[i] + "#";
	}*/
	
		
	var mostrarSoloRechazadas = get(FORMULARIO +'.chkSoloRechazadas');
	if(mostrarSoloRechazadas == 'S')
		mostrarSoloRechazadas = 'true';
	else
		mostrarSoloRechazadas = 'false';		
	
	var fechaReclamoDesde = get(FORMULARIO +'.txtFechaRecDesde');
	var fechaReclamoHasta = get(FORMULARIO +'.txtFechaRecHasta');
	var reclamosEnLinea = get(FORMULARIO +'.chkRecLinea');
	if(reclamosEnLinea == 'S')
		reclamosEnLinea = 'true';
	else
		reclamosEnLinea = 'false';
		
	var reclamosDigitados = get(FORMULARIO +'.chkRecDigitados');
	if(reclamosDigitados == 'S')
		reclamosDigitados = 'true';
	else
		reclamosDigitados= 'false';

	var oidMarca = get(FORMULARIO +'.cbMarca');
	var oidCanal = get(FORMULARIO +'.cbCanal');
	var oidPerDesdeRef = get(FORMULARIO +'.cbPerRefDesde');
	var oidPerHastaRef = get(FORMULARIO +'.cbPerRefHasta');
		
	configurarPaginado(mipgndo,"RECObtenerReclamosGestion",
         "ConectorObtenerReclamosGestion","es.indra.sicc.dtos.rec.DTOBuscarReclamosREC",
         [["oidPais", pais], 
         ["oidIdioma", idioma], 
         ["numAtencion", numAtencion], 
         ["numDocReferencia", numDocReferencia],
         ["codCliente",codCliente],
         ["stringOperaciones",oidsOperaciones],
         ["stringTiposBloqueo",oidsTiposBloqueo],
         ["mostrarSoloRechazadas",mostrarSoloRechazadas],
         ["fechaReclamoDesde",fechaReclamoDesde],
         ["fechaReclamoHasta",fechaReclamoHasta],
         ["reclamosEnLinea",reclamosEnLinea],
         ["reclamosDigitados",reclamosDigitados],
         ["oidMarca",oidMarca],
         ["oidCanal",oidCanal],
         ["oidPerDesdeRef",oidPerDesdeRef],
         ["oidPerHastaRef",oidPerHastaRef] ]);
	
	focaliza(FORMULARIO + ".txtNatencion");
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
function codigoClienteOnBlur(){
	var codigoCliente = get(FORMULARIO+'.txtCodCliente').toString();
	if (codigoCliente != '') {
        var longitudCodigoCliente = get(FORMULARIO+'.numDigitosCodigoCliente').toString();
        var longitud = codigoCliente.length;
		set(FORMULARIO + '.txtCodCliente', rellenaCeros(codigoCliente, longitudCodigoCliente, longitud))
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

function onClickDetalle(){

	/*Documentation
	-> Comprobar que se ha seleccionado un registro de la lstResultados: 
	-> Mostrar ventana modal y emergente PgGestionarReclamosBloqueados, enviando: 
	- oid del registro seleccionado 
	- oids de los valores seleccionados en el combo operacioneReclamos 
	- oids de los valores seleccionados en el combo tipoBloqueo 
	*/
	//Incidencia 14401
	//-> Se invoca la LPGestionReclamos con accion="mostrarPgGestionarReclamosBloqueados"
	// Se bloquea la ejecución hasta el cierre de la ventana emergente 
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
            		aux += fila[1]+","+fila[2]+","+fila[3]+","+fila[4]+","+fila[5]+","+fila[6]+","+fila[7]+","+fila[8]+","+fila[9]+","+fila[10]+","+fila[11]+","+fila[12]+",";
            		break;	
            	}
            }
            
            objParams.oid = oid;
            objParams.fila = aux;
			objParams.oidsOperaciones = new String(get(FORMULARIO+'.cbOperacion').toString());
			objParams.oidsTiposBloqueo = new String(get(FORMULARIO+'.cbTipoBloqueo').toString());
			mostrarModalSICC('LPGestionReclamos', 'mostrarPgGestionarReclamosBloqueados', objParams, null, null);
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
    document.all["DetalleDiv"].style.visibility='visible';
	document.all["DesbloquearDiv"].style.visibility='visible';
	document.all["RechazarDiv"].style.visibility='visible';
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
    document.all["DetalleDiv"].style.visibility='hidden';
    document.all["DesbloquearDiv"].style.visibility='hidden';
	document.all["RechazarDiv"].style.visibility='hidden';
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
        focaliza(FORMULARIO + ".txtNatencion");                          
        return false;                                                               
    }                                                                             
}

function onClickDesbloquear(){

	/*Documentation
	-> Comprobar que se ha seleccionado algún registro de la lstResultados: 
	-> Si hay seleccionado algun registro de la lista: habilitar el combo cbMotivoDesbloqueo 
	*/
	if (listado1.numSelecc() == 0) {   
    	// Muestra el mensaje: "Debe seleccionar un elemento de la lista"
    	GestionarMensaje('50');
    }else {                                                                                                    
    	accion(FORMULARIO+'.cbMotivoDesbloqueo','.disabled=false');
		accion(FORMULARIO+'.cbMotivoRechazo','.disabled=true');
		set(FORMULARIO+'.cbMotivoRechazo',['']);
		motivoDesbloqueo = true;
		motivoRechazo = false;
	}
	
}

function onClickRechazar(){

	/*Documentation
	-> Comprobar que se ha seleccionado algun registro de la lstResultados: 
	-> Si hay seleccionado algun registro de la lista: habilitar el combo cbMotivoRechazo
	*/
	if (listado1.numSelecc() == 0) {   
    	// Muestra el mensaje: "Debe seleccionar un elemento de la lista"
    	GestionarMensaje('50');
    }else {                                                                                                    
    	accion(FORMULARIO+'.cbMotivoRechazo','.disabled=false');
		accion(FORMULARIO+'.cbMotivoDesbloqueo','.disabled=true');
		set(FORMULARIO+'.cbMotivoDesbloqueo',['']);
		motivoRechazo = true;
		motivoDesbloqueo = false;
		
	}
}

function onClickAceptar(){

	/*Documentation
	-> Si cbMotivoDesbloqueo esta habilitado { // Se ha pulsado Aceptar tras seleccionar un motivo de desbloqueo 
	Si se ha seleccionado un valor en cbMotivoDesbloqueo { 
	- // Enviar el formulario oculto 
	formulario.oculto = "S" 
	enviaSICC(formulario) 
	-> Llamar a la LPGestionReclamos con: 
	- accion="desbloquear" y opcion = "reclamo" 
	- oids de los registros seleccionados en lstResultados // oid cabecera de reclamo 
	- oid del valor seleccionado en cbMotivoDesbloqueo 
	-> Inhabilitar combo cbMotivoDesbloqueo } 
	Si no { 
	- Mostrar mensaje generico para seleccionar un valor del combo } 
	} 
	*/
	if (listado1.numSelecc() == 0) {   
	    	// Muestra el mensaje: "Debe seleccionar un elemento de la lista"
    		GestionarMensaje('50');
    }else {
		
		if(motivoDesbloqueo == true){
			
			if(sicc_validaciones_generales("desbloqueo")){	
						
				set(FORMULARIO+'.conectorAction',"LPGestionReclamos");
				set(FORMULARIO+'.accion',"desbloquear");
				set(FORMULARIO+'.opcion',"reclamo");
				set(FORMULARIO+'.oidsLista', listado1.codSeleccionados());
				set(FORMULARIO+'.oidMotivoDesbloqueo', get(FORMULARIO+'.cbMotivoDesbloqueo'));
				accion(FORMULARIO+'.cbMotivoDesbloqueo','.disabled=true');
				enviaSICC(FORMULARIO,null,null,"N");      
			}
		}
		
		/*
		-> Si cbMotivoRechazo esta habilitado { 
		Si se ha seleccionado un valor en dicho combo { 
		- // Enviar el formulario oculto 
		formulario.oculto = "S" 
		enviaSICC(formulario) 
		-> Llamar a la LPGestionReclamos con: 
		- accion="rechazar" y opcion = "reclamo" 
		- oids de los registros seleccionados en lstResultados // oid cabecera de reclamo 
		- oid del valor seleccionado en cbMotivoRechazo 
		-> Inhabilitar combo cbMotivoRechazo } 
		Si no { 
		- Mostrar mensaje generico para seleccionar un valor del combo } 
		}
		*/
		else{
			
			if( motivoRechazo == true){
				if(sicc_validaciones_generales("rechazo")){				
					set(FORMULARIO+'.conectorAction',"LPGestionReclamos");
					set(FORMULARIO+'.accion',"rechazar");
					set(FORMULARIO+'.opcion',"reclamo");
					set(FORMULARIO+'.oidsLista', listado1.codSeleccionados());
					set(FORMULARIO+'.oidMotivoRechazo', get(FORMULARIO+'.cbMotivoRechazo'));
					accion(FORMULARIO+'.cbMotivoRechazo','.disabled=true');
					enviaSICC(FORMULARIO,null,null,"N");      
				}
			}
		}
	}
}

function onChangeMarca(){

	/*Documentation
	regargaCombo('cbPeriodoReferenciaDesde', 'CRAObtienePeriodos', 'DTOPeriodo', 
	[ 
	[ 'oidPais', get(pais) ] 	[ 'oidMarca', get(marca) ] (si get(marca)<>"") 	[ 'oidCanal', get(canal) ] (si get(canal)<>"") 	] ); 
	
	[si get(marca) o get(canal) es igual a vacio (no hay ningun valor seleccionado, el valor no debe enviarse en la llamada] 
	*/
	vaciaCombo(FORMULARIO+'.cbPerRefDesde');
	vaciaCombo(FORMULARIO+'.cbPerRefHasta');
	var marca = get(FORMULARIO+'.cbMarca');
	var canal = get(FORMULARIO+'.cbCanal');
	var pais = get(FORMULARIO+'.pais'); 
	if(marca != ''){
		if(canal != ''){
			
			recargaCombo(FORMULARIO+'.cbPerRefDesde','CRAObtienePeriodos','es.indra.sicc.dtos.cra.DTOPeriodo',[['oidPais',pais ],['marca',marca],['canal',canal]]);
		}else{
			
			recargaCombo(FORMULARIO+'.cbPerRefDesde','CRAObtienePeriodos','es.indra.sicc.dtos.cra.DTOPeriodo',[['oidPais',pais ],['marca',marca]]);
		}
	}else{
		if(canal != ''){
			
			recargaCombo(FORMULARIO+'.cbPerRefDesde','CRAObtienePeriodos','es.indra.sicc.dtos.cra.DTOPeriodo',[['oidPais',pais ],['canal',canal]]);
		}else{
			
			recargaCombo(FORMULARIO+'.cbPerRefDesde','CRAObtienePeriodos','es.indra.sicc.dtos.cra.DTOPeriodo',[['oidPais',pais ]]);
		}
	}
		
	/*regargaCombo('cbPeriodoReferenciaHasta', 'CRAObtienePeriodos', 'DTOPeriodo', 
	[ 
	[ 'oidPais', get(pais) ] 	[ 'oidMarca', get(marca) ] (si get(marca)<>"") 	[ 'oidCanal', get(canal) ] (si get(canal)<>"") ] ); 
	
	[si get(marca) o get(canal) es igual a vacio (no hay ningun valor seleccionado, el valor no debe enviarse en la llamada] 
	*/
	if(marca != ''){
		if(canal != ''){
			recargaCombo(FORMULARIO+'.cbPerRefHasta','CRAObtienePeriodos','es.indra.sicc.dtos.cra.DTOPeriodo',[['oidPais',pais ],['marca',marca],['canal',canal]]);
		}else{
			recargaCombo(FORMULARIO+'.cbPerRefHasta','CRAObtienePeriodos','es.indra.sicc.dtos.cra.DTOPeriodo',[['oidPais',pais ],['marca',marca]]);
		}
	}else{
		if(canal != ''){
			recargaCombo(FORMULARIO+'.cbPerRefHasta','CRAObtienePeriodos','es.indra.sicc.dtos.cra.DTOPeriodo',[['oidPais',pais ],['canal',canal]]);
		}else{
			recargaCombo(FORMULARIO+'.cbPerRefHasta','CRAObtienePeriodos','es.indra.sicc.dtos.cra.DTOPeriodo',[['oidPais',pais ]]);
		}
	}
}
function vaciaCombo(combo) {
         set_combo(combo,[['','']],['']);
}

function onChangeCanal(){

	/*Documentation
	regargaCombo('cbPeriodoReferenciaDesde', 'CRAObtienePeriodos', 'DTOPeriodo', 
	[ 
	[ 'oidPais', get(pais) ] 	[ 'oidMarca', get(marca) ] (si get(marca)<>"") 	[ 'oidCanal', get(canal) ] (si get(canal)<>"") 	] ); 
	
	[si get(marca) o get(canal) es igual a vacio (no hay ningun valor seleccionado, el valor no debe enviarse en la llamada]  
	*/
	vaciaCombo(FORMULARIO+'.cbPerRefDesde');
	vaciaCombo(FORMULARIO+'.cbPerRefHasta');
	var marca = get(FORMULARIO+'.cbMarca');
	var canal = get(FORMULARIO+'.cbCanal');
	var pais = get(FORMULARIO+'.pais'); 
	
	if(canal != ''){
		if(marca != ''){
			recargaCombo(FORMULARIO+'.cbPerRefDesde','CRAObtienePeriodos','es.indra.sicc.dtos.cra.DTOPeriodo',[['oidPais',pais ],
				['marca',marca],['canal',canal]]);
		}else{
			recargaCombo(FORMULARIO+'.cbPerRefDesde','CRAObtienePeriodos','es.indra.sicc.dtos.cra.DTOPeriodo',[['oidPais',pais ],
				['canal',canal]]);
		}
	}else{
		if(marca != ''){
			recargaCombo(FORMULARIO+'.cbPerRefDesde','CRAObtienePeriodos','es.indra.sicc.dtos.cra.DTOPeriodo',[['oidPais',pais ],
				['marca',marca]]);
		}else{
			recargaCombo(FORMULARIO+'.cbPerRefDesde','CRAObtienePeriodos','es.indra.sicc.dtos.cra.DTOPeriodo',[['oidPais',pais ]]);
		}
	}
	/*
	regargaCombo('cbPeriodoReferenciaHasta', 'CRAObtienePeriodos', 'DTOPeriodo', 
	[ 
	[ 'oidPais', get(pais) ] 	[ 'oidMarca', get(marca) ] (si get(marca)<>"") 	[ 'oidCanal', get(canal) ] (si get(canal)<>"") ] ); 
	
	[si get(marca) o get(canal) es igual a vacio (no hay ningun valor seleccionado, el valor no debe enviarse en la llamada] 
	*/
	if(canal != ''){
		if(marca != ''){
			recargaCombo(FORMULARIO+'.cbPerRefHasta','CRAObtienePeriodos','es.indra.sicc.dtos.cra.DTOPeriodo',[['oidPais',pais ],
				['marca',marca],['canal',canal]]);
		}else{
			recargaCombo(FORMULARIO+'.cbPerRefHasta','CRAObtienePeriodos','es.indra.sicc.dtos.cra.DTOPeriodo',[['oidPais',pais ],
				['canal',canal]]);
		}
	}else{
		if(marca != ''){
			recargaCombo(FORMULARIO+'.cbPerRefHasta','CRAObtienePeriodos','es.indra.sicc.dtos.cra.DTOPeriodo',[['oidPais',pais ],
				['marca',marca]]);
		}else{
			recargaCombo(FORMULARIO+'.cbPerRefHasta','CRAObtienePeriodos','es.indra.sicc.dtos.cra.DTOPeriodo',[['oidPais',pais ]]);
		}
	}
		
}

function iconoCliente(){    
    //Llamamos al proceso correspondiente Modal
    var objParams = new Object();
    var cliente = mostrarModalSICC('LPBusquedaRapidaCliente', '', objParams, null, null);          

    if (cliente != null && cliente.length > 1) {
         var codigoCliente = cliente[1];
         set(FORMULARIO+'.txtCodCliente',codigoCliente);
    }
}

function focalizaSiguienteBuscar(){
	if (listado1.datos.length > 0)
    	document.all['Detalle'].focus();
    else
		focaliza(FORMULARIO +'.txtNatencion');
}
function focalizaAnteriorNAtencion(){
	if (listado1.datos.length > 0)
    	document.all['btnAceptar'].focus();
    else
		document.all['btnBuscar'].focus();
}

function onShTabBtnDetalle(){
	document.all['btnBuscar'].focus();
}

function focalizaSiguiente(){
	
	if(motivoDesbloqueo == true){
		focaliza(FORMULARIO+'.cbMotivoDesbloqueo');
	}else{
		document.all['btnAceptar'].focus();
	}	
}
function shtabAceptar(){
	
	if(motivoRechazo == true)
		focaliza(FORMULARIO+'.cbMotivoRechazo');
	else
		document.all['Rechazar'].focus();
	
}

function dehabilitarCombos(){
	if (listado1.numSelecc() == 0) {
		accion(FORMULARIO+'.cbMotivoDesbloqueo','.disabled=true');
		accion(FORMULARIO+'.cbMotivoRechazo','.disabled=true');
		motivoRechazo = false;
		motivoDesbloqueo = false;		
	}
}

function correcto(){
	
	set(FORMULARIO+'.cbMotivoDesbloqueo',['']);
	set(FORMULARIO+'.cbMotivoRechazo',['']);
	mipgndo.recargar();
}