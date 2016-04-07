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


/*
    INDRA/CAR/PROY
    $Id: contenido_regalo_insertar.js,v 1.1 2009/12/03 19:02:24 pecbazalar Exp $
    DESC
*/
var FORMULARIO = 'Formulario';

function onLoad(){
  
	DrdEnsanchaConMargenDcho('listado1',12);
	eval (ON_RSZ);  
		
	if (get(FORMULARIO+'.errDescripcion')!='') {                    
		var wnd = fMostrarMensajeError(get(FORMULARIO+'.errCodigo'),get(FORMULARIO+'.errDescripcion'));
	}

	if (get(FORMULARIO+'.casoUso')=='insertar'){ 
		 focaliza(FORMULARIO+'.txtCodRegalo');
	}
	if (get(FORMULARIO+'.casoUso')=='modificar'){ 
		focaliza(FORMULARIO+'.txtDescripcion');
	}
	
	if ((get(FORMULARIO+'.casoUso')=='detalle')||(get(FORMULARIO+'.casoUso')=='modificar')){ 
		if (get(FORMULARIO+'.casoUso')=='detalle'){
			//ocultando botones
			document.all["btnBuscarProductoDiv"].style.visibility='hidden';
			document.all["btnEliminarProductoDiv"].style.visibility='hidden';	
		}
		var oidRegalo=get(FORMULARIO+'.oidRegalo');
		var idioma=get(FORMULARIO+".idioma");
		var pais=get(FORMULARIO+".pais");
		var DTOOIDRegalo = 'es.indra.sicc.dtos.edu.DTOOIDRegalo';

		configurarPaginado(mipgndo, 'EDUProductosRegalo', 'ConectorConsultaProductos', DTOOIDRegalo, 
		[['oidRegalo',oidRegalo], //oidRegalo
		['oidIdioma',idioma], 
		['oidPais',pais] ] );
	}	
	configurarMenuSecundario(FORMULARIO);
}

function focalizaOntab(){
	if (get(FORMULARIO+'.casoUso')=='modificar'){
		focaliza(FORMULARIO+".txtDescripcion");
	}else{
		focaliza(FORMULARIO+".txtCodRegalo");
	}
}

function focalizaOnshtab(){
	if  (get(FORMULARIO+'.casoUso')=='modificar'){
		document.all['btnEliminarProducto'].focus();
	}else{
		focaliza(FORMULARIO+".txtCodRegalo");
	}
}


function onClickBuscar(){
	var ok=true;       
	var oid = listado1.generaCodigo();
	var objParams = new Object();         
	objParams.oidProductos = oid;
	objParams.casoDeUso = "buscarProducto";
	var result=mostrarModalSICC('LPBuscarProductosDTO', '',objParams, null, null);

	var rstdatos= new String (result[0]);
	var splitFila=rstdatos.split("$");
	for (i=1;i < splitFila.length;i++){
		var filaString = new String(splitFila[i]);
		var fila = filaString.split("|");
		if(typeof(fila)!='undefined') {
			if(fila.length!=0) {			
				listado1.actualizaDat();
				var datosFinal = listado1.datos;
				if (datosFinal != null){
					for (j = 0; j < datosFinal.length; j++) {
					        var filaaux = datosFinal[j];
					        if(filaaux[0]== fila[0]){
							ok=false;
					        }
					}
					if (ok){
						listado1.insertar(fila);
				    	listado1.reajusta();
					}else{
						ok=true;
						// El producto seleccionado ya se encuentra en la lista
						GestionarMensaje('1228');				
					}
				}
		    	}
	 	}
	 }
}



function onClickQuitar(){
	//Se eliminan de la lista lstProductos aquellas filas que estén seleccionadas.
	if (listado1.numSelecc() == 0) {
		// Muestra el mensaje: "Debe seleccionar un elemento de la lista"
		GestionarMensaje('50');
	} else {	
		//elimina de la lista los seleccionados
		listado1.eliminarSelecc();
	}
}

function fLimpiar(){
	var casoUso = get(FORMULARIO +'.casoUso');
	if(casoUso == 'insertar'){

		//cdos gPineda 03/08/06 BELC300023329
		limpiaI18N(FORMULARIO, '1');
		set(FORMULARIO + '.txtDescripcion','');
		set(FORMULARIO + '.txtCodRegalo','');

		var datos = new Array();
	   	listado1.setDatos(datos);
	   	listado1.reajusta();
		focaliza(FORMULARIO +'.txtCodRegalo');
	}
	if(casoUso == 'modificar'){
		
		var oidRegalo=get(FORMULARIO+'.oidRegalo');
		var idioma=get(FORMULARIO+".idioma");
		var pais=get(FORMULARIO+".pais");
		var DTOOIDRegalo = 'es.indra.sicc.dtos.edu.DTOOIDRegalo';
		
		configurarPaginado(mipgndo, 'EDUProductosRegalo', 'ConectorConsultaProductos', DTOOIDRegalo, 
		[['oidRegalo',oidRegalo], //oidRegalo
		['oidIdioma',idioma], 
		['oidPais',pais] ] );
		
		focaliza(FORMULARIO +'.txtDescripcion');
	}
}

function fVolver(){
	window.close();
}

function fGuardar(){
	var num = get(FORMULARIO+'.txtCodRegalo');
	validado=validarCodRegalo(num);
	if (validado==0 || num==''){
		onClickGuardar();
	}
}

function onClickGuardar(){
/*
Cuando se pulsa el botón Guardar del menú secundario, si lstProductos tiene información: 

Si txtCodRegalo está habilitado 
Se llama a LPMantenimientoRegalos con accion="Insertar" 
Fin del Si 

Si txtCodRegalo está deshabilitado 
Se llama a LPMantenimientoRegalos con accion="Modificar" a través de un enviar oculto. 
Fin del Si 
*/	
	var result;
	var casoUso=get(FORMULARIO+'.casoUso');
	if(listado1.datos != 0){ 
		if(sicc_validaciones_generales()){
			var lstProductos = listado1.datos;
			for (i = 0; i < lstProductos.length; i++) {
				var fila = lstProductos[i];
				if (lstProductos.length==1){
					result = fila[0];
				}else{
					 if (i==0){
						result = fila[0];
					}else{
						 result= result +',' + fila[0];
					}
				}
			}

			set (FORMULARIO+'.hOids',result);
			if (casoUso=='insertar'){
				//LPMantenimientoRegalos con accion="Insertar"	
				set(FORMULARIO+'.accion','Insertar');	
			}
			if (casoUso=='modificar'){
				//LPMantenimientoRegalos con accion="Modificar" Oculto
				set(FORMULARIO+'.accion','Modificar');
			}

			set(FORMULARIO+'.conectorAction','LPMantenimientoRegalos');
			enviaSICC(FORMULARIO);
		}
	}else {
		//El regalo debe tener productos asociados (1329)
		GestionarMensaje('1329');		
	}

}

function insercionCorrecta(){
	
	fLimpiarGenericoSICC();
	fLimpiar();

}

function modificacionCorrecta(){
	var codigo = get(FORMULARIO+'.txtCodRegalo');
	var descripcion = get(FORMULARIO+'.txtDescripcion');
	
	if (get(FORMULARIO+'.casoUso')=='modificar'){
		window.returnValue = [codigo,descripcion];
		window.close();
	}
}


function validarCodRegalo(num){ 
	if(num != ""){
		var val = allTrim(num);             
    	//Como no nos interesa validar el número de dígitos que tiene el 
    	//entero ponemos uno suficientemente grande. 
		if ((ValidaInt(val.toString(),10000, 0)!="OK")||(val.toString() < 0)) {
			GestionarMensaje('747', null, null, null);
			focaliza(FORMULARIO+'.txtCodRegalo');
			return 1;
		} else {
			set(FORMULARIO+'.txtCodRegalo',allTrim(num));
			return 0;
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
