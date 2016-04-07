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
var visible = false;
function onLoadPag() {
	inicioPagina();
	if (get(FORMULARIO+'.errDescripcion')!='') {		
		var wnd = fMostrarMensajeError(get(FORMULARIO+'.errCodigo'),get(FORMULARIO+'.errDescripcion'));
	}
	focaliza(FORMULARIO + ".textNumeroLote");
	//visibleLista();
		
} 
function inicioPagina(){
		
	if(get(FORMULARIO+'.casoUso')=='consultar'){   
		document.all["Cplistado1"].style.visibility='';
		document.all["CpLin1listado1"].style.visibility='';
		document.all["CpLin2listado1"].style.visibility='';
		document.all["CpLin3listado1"].style.visibility='';
		document.all["CpLin4listado1"].style.visibility='';
		document.all["primera1Div"].style.visibility='';
		document.all["ret1Div"].style.visibility='';
		document.all["ava1Div"].style.visibility='';
		document.all["separaDiv"].style.visibility='';
		document.all["modificarDiv"].style.visibility='hidden';
		document.all["ProcesadosDiv"].style.visibility='hidden';
		document.all["AplicarDiv"].style.visibility='hidden';
		document.all["detalleDiv"].style.visibility='';		
	}else if(get(FORMULARIO+'.casoUso')=='eliminar'){
		document.all["Cplistado1"].style.visibility='';
		document.all["CpLin1listado1"].style.visibility='';
		document.all["CpLin2listado1"].style.visibility='';
		document.all["CpLin3listado1"].style.visibility='';
		document.all["CpLin4listado1"].style.visibility='';
		document.all["primera1Div"].style.visibility='';
		document.all["ret1Div"].style.visibility='';
		document.all["ava1Div"].style.visibility='';
		document.all["separaDiv"].style.visibility='';
		document.all["modificarDiv"].style.visibility='hidden';
		document.all["ProcesadosDiv"].style.visibility='hidden';
		document.all["AplicarDiv"].style.visibility='hidden';
		document.all["detalleDiv"].style.visibility='';				
	}else if(get(FORMULARIO+'.casoUso')=='modificar'){
		document.all["Cplistado1"].style.visibility='';
		document.all["CpLin1listado1"].style.visibility='';
		document.all["CpLin2listado1"].style.visibility='';
		document.all["CpLin3listado1"].style.visibility='';
		document.all["CpLin4listado1"].style.visibility='';
		document.all["primera1Div"].style.visibility='';
		document.all["ret1Div"].style.visibility='';
		document.all["ava1Div"].style.visibility='';
		document.all["separaDiv"].style.visibility='';
		document.all["modificarDiv"].style.visibility='';
		document.all["ProcesadosDiv"].style.visibility='';
		document.all["AplicarDiv"].style.visibility='';
		document.all["detalleDiv"].style.visibility='hidden';				
	}
	
	configurarMenuSecundario(FORMULARIO);		
	DrdEnsanchaConMargenDcho('listado1',12);
	eval (ON_RSZ);  
}	
function accionBuscar(){
        
        	
        
      
                    var nume = 0;
                  
                  
		    var idioma = get(FORMULARIO+'.idioma');
		    var pais   = get(FORMULARIO+'.pais');
		   
		    var textAnyo = get(FORMULARIO+'.textAnyo');
		    var textMes = get(FORMULARIO+'.textMes');
		    var textNumeroLote = get(FORMULARIO+'.textNumeroLote');
		    var textCodigoClienteReclamante = get(FORMULARIO+'.textCodigoClienteReclamante');
		    
		    var textFechaDocumento = get(FORMULARIO+'.textFechaDocumento');
		    var cbBancoRecaudacion = get(FORMULARIO+'.cbBancoRecaudacion');
		    var cbSucursalRecaudacion = get(FORMULARIO+'.cbSucursalRecaudacion');
		    var cbCuenta = get(FORMULARIO+'.cbCuenta');
		    var textUsuarioSolicitante = get(FORMULARIO+'.cbUsuarioSolicitante','T').toString();//sacamos el txto no el oid
		    var textUsuarioGestorReclamoPrevisto =get(FORMULARIO+'.cbUsuarioGestorReclamoPrevisto').toString();
		    var textUsuarioGestorReclamoReal = get(FORMULARIO+'.cbUsuarioGestorReclamoReal').toString();
		    var cbSituacion = get(FORMULARIO+'.cbSituacion');
		    btnProxy(4, 0); 
		    
		    
                  if((textCodigoClienteReclamante != null)&&(textCodigoClienteReclamante != "")){
                           nume++;	
                  }
         
	         if((textAnyo != null)&&(textAnyo != "")){
	                           nume++;	
	                  }   
		 if((textMes != null)&&(textMes != "")){
			                           nume++;	
		 }         
		if((textNumeroLote != null)&&(textNumeroLote != "")){
			                           nume++;	
		  }         
		if((cbCuenta != null)&&(cbCuenta != "")){
			                           nume++;	
		 }         
		if((cbBancoRecaudacion != null)&&(cbBancoRecaudacion != "")){
			                           nume++;	
		 }         
		if((cbSucursalRecaudacion != null)&&(cbSucursalRecaudacion != "")){
			                           nume++;	
		  }         
		if((textFechaDocumento != null)&&(textFechaDocumento != "")){
			                           nume++;	
		 }
		if((textUsuarioSolicitante != null)&&(textUsuarioSolicitante != "")){
			                           nume++;	
		  } 
		if((textUsuarioGestorReclamoPrevisto != null)&&(textUsuarioGestorReclamoPrevisto != "")){
			                           nume++;	
		} 
		if((textUsuarioGestorReclamoReal != null)&&(textUsuarioGestorReclamoReal != "")){
			                           nume++;	
		} 
		if((cbSituacion != null)&&(cbSituacion != "")){
			nume++;	
		 }          
      		if(nume < 2){
                           //Muestra el mensaje:"Debe introducir al menos dos criterios de filtro" (UICCC008) 

                           GestionarMensaje('1405');
                  }else{


         
    		configurarPaginado(mipgndo, "CCCBuscarReclamos", "ConectorBuscarReclamos", "es.indra.sicc.dtos.ccc.DTOBuscarReclamos", [["oidIdioma", idioma],["oidPais", pais],["anio", textAnyo],["mes", textMes],["numeroIdentificacion", textNumeroLote],["codigoClienteReclamante", textCodigoClienteReclamante],["fechaDocumento", textFechaDocumento],["oidBanco", cbBancoRecaudacion],["oidSucursal", cbSucursalRecaudacion],["oidCuentaCorriente", cbCuenta],["usuarioSolicitante", textUsuarioSolicitante],["usuarioGestorReclamoPrevisto", textUsuarioGestorReclamoPrevisto],["usuarioGestorReclamoReal", textUsuarioGestorReclamoReal],["oidSituacion", cbSituacion]] );       
   		}//el del else
         
}

function muestraLista( ultima, rowset){
	
	var tamano = rowset.length;
	if (tamano > 0) {
		visibleLista();
		if (get(FORMULARIO+'.casoUso') == 'eliminar')
                  		btnProxy(4, 1);

		return true;
	} else {
		invisibleLista();		
		focaliza(FORMULARIO+'.textNumeroLote','');
		return false;
	}
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
function validarAnyo() {
	if(get(FORMULARIO+'.textAnyo')!=''){
		var esNumeroA=esNumero(get(FORMULARIO+'.textAnyo'));
		if(esNumeroA=='-1'){		
			GestionarMensaje('747', null, null, null);
			focaliza(FORMULARIO+'.textAnyo');
			return;			
		}
		
		if(get(FORMULARIO+'.textAnyo').length!=2){
			//GestionarMensaje('1112', null, null, null);

			//Modificado por inc 19074.
			GestionarMensaje('1582', null, null, null);

			focaliza(FORMULARIO+'.textAnyo');
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
function validarNumeroLote(){
	if(get(FORMULARIO+'.textNumeroLote')!=''){
		var esNumeroA=esNumero(get(FORMULARIO+'.textNumeroLote'));
		if(esNumeroA=='-1'){		
			GestionarMensaje('747', null, null, null);
			focaliza(FORMULARIO+'.textNumeroLote');
			return;			
		}
	}	
}

function validarFechaDocumento() {

	if (get(FORMULARIO+'.textFechaDocumento').toString() != ""){
		if (!EsFechaValida_SICC(get(FORMULARIO+'.textFechaDocumento'), FORMULARIO)) {		
			GestionarMensaje('1006', get(FORMULARIO+'.hFormatoFechaPais'));
			focaliza(FORMULARIO+'.textFechaDocumento');
			return false;
		} 
	}
}
function anumeroLote(){
		focaliza('frmUnica.textNumeroLote');
	}

function tabulacionNumero(){
	/*if(get(FORMULARIO+'.casoUso')=='consultar'){   
		 if (!get_visibilidad("capaLista")) {
			document.all['btnBuscar'].focus();		
		}else{
			document.all['btnBuscar'].focus();		
		}
	}else if(get(FORMULARIO+'.casoUso')=='eliminar'){
		 if (!get_visibilidad("capaLista")) {
			document.all['btnBuscar'].focus();		
		}else{
			document.all['btnBuscar'].focus();
		}
	}else if(get(FORMULARIO+'.casoUso')=='modificar'){
		 if (!get_visibilidad("capaLista")) {
			document.all['btnBuscar'].focus();		
		}else{
			document.all['btnBuscar'].focus();		
		}
	}
	*/
	document.all['btnBuscar'].focus();
	
		
}
function tabulacionBuscar(){
	if(get(FORMULARIO+'.casoUso')=='consultar'){   		
		if (!get_visibilidad("capaLista")) {
			focaliza('frmUnica.textNumeroLote');
		}else{
			document.all['detalle'].focus();
		}
	}else if(get(FORMULARIO+'.casoUso')=='eliminar'){
		if (!get_visibilidad("capaLista")) {
			focaliza('frmUnica.textNumeroLote');
		}else{
			document.all['detalle'].focus();
		}
	}else if(get(FORMULARIO+'.casoUso')=='modificar'){
		if (!get_visibilidad("capaLista")) {
			focaliza('frmUnica.textNumeroLote');
		}else{
			document.all['modificar'].focus();
		}
	}		
}
function sifTabNumero(){
	//Si hay lista y es caso de uso consultar o eliminar debe de ria al botobn buscar
	//Si no hay lista debe de ir al boton buscar
	if((get(FORMULARIO+'.casoUso')=='consultar')||(get(FORMULARIO+'.casoUso')=='eliminar')){   		
		if (!get_visibilidad("capaLista")) {//no hay lista
			document.all['btnBuscar'].focus();
		}else{
			document.all['detalle'].focus();
		}
	}else if(get(FORMULARIO+'.casoUso')=='modificar'){
		if(get(FORMULARIO+'.casoUso')=='modificar'){
			if (!get_visibilidad("capaLista")) {//no hay lista
				document.all['btnBuscar'].focus();
			}else{
				document.all['detalle'].focus();
			}
		}
	
	}
}


function busquedaRapidaCliente(){
	var objParams = new Object();
	var resultado = mostrarModalSICC('LPBusquedaRapidaCliente', '',objParams, null, null);
	if (typeof(resultado)!='undefined'){ 
		var codigoCliente = resultado[1];
		set(FORMULARIO + '.textCodigoClienteReclamante', codigoCliente);
	}
	/*
	var cliente = mostrarModalSICC("LPBusquedaRapidaCliente", "", objParametros, null, null);
	if (typeof(cliente)!='undefined') var codigoCliente = cliente[1]

	
	*/
	
}
/*funcion textCodClienteOnBlur() {
         var codigoCliente = get(FORMULARIO+'.textCodigoClienteReclamante').toString();
         if (codigoCliente != '') {
                  var longitudCodigoCliente = get(FORMULARIO+'.numDigitosCodigoCliente').toString();
                  var longitud = codigoCliente.length;
                  set(FORMULARIO+'.txtCodCliente',rellenaCeros(codigoCliente,longitudCodigoCliente,longitud))
         }
}
//tienes que poner esto en el Xml para que te pille la funcion rellenaCeros
//<JS src="ccc_util.js"/> */

function textCodClienteOnBlur() {
         var codigoCliente = get(FORMULARIO+'.textCodigoClienteReclamante').toString();
        
         if (codigoCliente != '') {
                  var longitudCodigoCliente = get(FORMULARIO+'.longitudCodigoCliente').toString();
                  var longitud = codigoCliente.length;
                  set(FORMULARIO+'.textCodigoClienteReclamante',rellenaCeros(codigoCliente,longitudCodigoCliente,longitud))
         }
}

/*
function codigoClienteOnBlur() {
	
	var codigoCliente = get(FORMULARIO+'.textCodigoClienteReclamante').toString();

	if (codigoCliente != '') {
		var longitudCodigoCliente = get(FORMULARIO+'.longitudCodigoCliente').toString();
		var longitud = codigoCliente.length;

		// Se rellena el código de cliente con ceros
		if (Number(longitud) < Number(longitudCodigoCliente)) {
			var diferencia = longitudCodigoCliente-longitud;
			var ceros = '';
			for (var i=0; i<diferencia;i++) {
				ceros += '0';
		}
		var cadena = ceros + codigoCliente;
		set(FORMULARIO+'.textCodigoClienteReclamante',cadena);
		}
	}
}
*/
function bancoOnChange() {
	set_combo(FORMULARIO+'.cbCuenta',[['','']],['']);		
	set_combo(FORMULARIO+'.cbSucursalRecaudacion',[['','']],['']);	
	if(get(FORMULARIO+'.cbBancoRecaudacion')!=''){
		recargaCombo(FORMULARIO+'.cbSucursalRecaudacion','CCCRecargaSucursales', 'es.indra.sicc.util.DTOOID', [[ 'oid', get(FORMULARIO+'.cbBancoRecaudacion') ]] );
	}
	
}

function sucursalOnChange() {
	set_combo(FORMULARIO+'.cbCuenta',[['','']],['']);	
	if(get(FORMULARIO+'.cbSucursalRecaudacion')!=''){	
		recargaCombo(FORMULARIO+'.cbCuenta','CCCRecargaCuentas', 'es.indra.sicc.util.DTOOID', [[ 'oid', get(FORMULARIO+'.cbSucursalRecaudacion') ]] );
	}
	
}
function fBorrar(){
	accionEliminar();
}
function accionEliminar(){
		
	if(listado1.numSelecc() == 0){	
		GestionarMensaje('50');
	}else{

		var oids = listado1.codSeleccionados();
		eliminarFilas(oids, "CCCEliminarReclamos", mipgndo);
		
	}

}
function accionBTN_Detalle(){
	
	
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
			//Obtenemos el oid seleccionados
			//Llamos al proceso correspondiente Modal
			var objParams = new Object();
			objParams.oidSeleccionado=listado1.codSeleccionados();
			objParams.cu=get(FORMULARIO+'.casoUso');
			//objParams.casoUso=get(FORMULARIO+'.casoUso');						
			mostrarModalSICC('LPMantenimientoReclamos', 'consultar_btn', objParams, null, null);//LPMantenimintoReclamos			
			focaliza('frmUnica.textAnyo');
		}
	}	
}
function accionBTN_CambiarAProcesado(){
	var oidEstado = get(FORMULARIO+'.estado');
	if(listado1.numSelecc() == 0){	
		GestionarMensaje('50');
	}else{			
		var oids=listado1.codSeleccionados();
		var estado="";
		for (i =1; i <= oids.length; i++){
			estado = listado1.extraeDato(oids[i-1],10); 
			if (estado!=oidEstado){
				//"Sólo se pueden pasar a procesados los reclamos en estado solicitado"
				GestionarMensaje('UICCC0015');
				return;
			}
		}
		set(FORMULARIO + '.oidses', oids);
		set(FORMULARIO+'.accion','procesar_btn');
		set(FORMULARIO+'.conectorAction','LPMantenimientoReclamos');
		enviaSICC(FORMULARIO);	
		
		accionBuscar();
	     }
}

/*

<<JavaScript>> accionBTN_CambiarAProcesado (), in Class BuscarReclamos
Documentation
Obtenemos los valores de los campos oid de las filas seleccionadas por el usuario. 
Invocamos LPMantenimientoReclamos pasándole como parámetros: 
- accion="procesar_btn". 
- array de oids de las filas seleccionadas de la lista. 
*/

//function accionPasarAProcesado (){
//	if(listado1.numSelecc() == 0){	
//		GestionarMensaje('50');
//	}else{	
//		asignar([["TEXT","","ConectorProcesarTransaction","resultado",listado1.codSeleccionados(),"resultadoProcesar(datos);"]]);
//	}

//}
//function resultadoProcesar(datos){
//	GestionarMensaje(datos);
//	accionBuscar();	
//}

function accionCargosAbonos(){
	eval(FORMULARIO).oculto="N";
	set(FORMULARIO+'.accion','');
	set(FORMULARIO+'.conectorAction','LPAplicarCargosAbonos');
	enviaSICC(FORMULARIO);	
} 

function fLimpiar(){ 	
	set(FORMULARIO+'.textAnyo','');
	set(FORMULARIO+'.textMes','');
	set(FORMULARIO+'.textNumeroLote','');
	set(FORMULARIO+'.textCodigoClienteReclamante','');
	set(FORMULARIO+'.textFechaDocumento','');
	set(FORMULARIO+'.cbSituacion','');			
	set(FORMULARIO+'.textUsuarioSolicitante','');
	set(FORMULARIO+'.textUsuarioGestorReclamoPrevisto','');
	set(FORMULARIO+'.textUsuarioGestorReclamoReal','');
	set_combo(FORMULARIO+'.cbCuenta',[['','']],['']);		
	set_combo(FORMULARIO+'.cbSucursalRecaudacion',[['','']],['']);
	set(FORMULARIO+'.cbBancoRecaudacion','');	
}

function accionModificar() {
	// Se comprueba que se ha seleccionado un curso
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
			//Obtenemos el oid seleccionados
			//Llamos al proceso correspondiente Modal
			set(FORMULARIO+'.accion','');
			var objParams = new Object();
			objParams.oidSeleccionado=listado1.codSeleccionados();
			objParams.casoUso=get(FORMULARIO+'.casoUso');	
			var seleccionados = listado1.codSeleccionados();						
			var fila=mostrarModalSICC('LPMantenimientoReclamos','modificar_btn', objParams, null, null);
			
			if(typeof(fila)!='undefined') {
			    if(fila.length!=0) { 
				
				listado1.actualizaDat();
				var datosFinal = listado1.datos;
				for (i = 0; i < datosFinal.length; i++) {
					var filaaux = datosFinal[i];
					if(filaaux[0]== seleccionados){
											
						
						//filaaux[1] = fila[0];//al ser etiquetas nunca cambiaran
						//filaaux[2] = fila[1];
						//filaaux[3] = fila[2];
						
						
						filaaux[4] = fila[3];
						filaaux[5] = fila[4];
						filaaux[6] = fila[5];
						filaaux[7] = fila[6];
						filaaux[8] = fila[7];
						filaaux[9] = fila[8];
						filaaux[10] = fila[9];
						
					}
				}//for
			   listado1.reajusta();
			   
			   }
		     }
				 			
		}
	}	
}


/*

else {
	               //Obtenemos el oid seleccionados
	               //Llamos al proceso correspondiente Modal
	               var objParams = new Object();
	               objParams.oidSeleccionado=listado1.codSeleccionados();
	               objParams.casoUso=get(FORMULARIO+'.casoUso');
	               var seleccionados = listado1.codSeleccionados();			
	               var fila=mostrarModalSICC('LPMantenimientoTiposMovimientosAlmacen', 'detalleModificar', objParams, null, null);
		if(typeof(fila)!='undefined') {
			if(fila.length!=0) { 
				//Insertamos la fila
				listado1.actualizaDat();
				var datosFinal = listado1.datos;
				for (i = 0; i < datosFinal.length; i++) {
					var filaaux = datosFinal[i];
					if(filaaux[0]== seleccionados){
						filaaux[2] = fila[1];
					}
			       }
				listado1.reajusta();
			}
		}
	      }


*/








