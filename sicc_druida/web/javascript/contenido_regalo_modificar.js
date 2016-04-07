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

var FORMULARIO = 'formulario';

function onLoadPag(){
	
	if (get(FORMULARIO+'.errDescripcion')!='') {                    
		var wnd = fMostrarMensajeError(get(FORMULARIO+'.errCodigo'),get(FORMULARIO+'.errDescripcion'));
	}
	var casouso=get(FORMULARIO+'.casoUso')
	if ((casouso=="consultar")||(casouso=="eliminar")){
		document.all["DetalleDiv"].style.visibility='';
		document.all["ModificarDiv"].style.visibility='hidden';
	}
	if (casouso=="modificar"){
		document.all["DetalleDiv"].style.visibility='hidden';
		document.all["ModificarDiv"].style.visibility='';
	}

	DrdEnsanchaConMargenDcho('listado1',12);
	eval (ON_RSZ);
	
	focaliza (FORMULARIO+'.txtCodRegalo');
	configurarMenuSecundario(FORMULARIO);
}

function onClickBuscar(){
	/*
	Este método javascript se ejecuta cuando pulsa sobre btnBurcar. 

	Se carga la lista lstRegalos con los regalos que cumplen el criterio de búsqueda especificado por el usuario. 
	
	Proceso: 
	======= 
	configurarPaginado(lstRegalos, "EDUBusquedaRegalos", "ConectorConsultaRegalo", "DTOConsultaRegalo", [ ["codRegalo", get(txtCodRegalo)], ["codProducto", get(txtCodProducto)], ["oidPais", get(pais de la sesión)]] );
	*/
	
		
	var codRegalo = get(FORMULARIO+'.txtCodRegalo');
	var codProducto = get(FORMULARIO+'.txtCodProducto');
	var oidPais = get(FORMULARIO+'.idioma');
	var oidIdioma = get(FORMULARIO+'.pais');
	
	if (get(FORMULARIO+'.casoUso') == 'eliminar')
    		btnProxy(4, 0); 

	var DTOConsultaRegalo = 'es.indra.sicc.dtos.edu.DTOConsultaRegalo';
	
	configurarPaginado(mipgndo, "EDUBusquedaRegalo", "ConectorConsultaRegalo", DTOConsultaRegalo, 
	[ ["codRegalo",codRegalo],
	["codProducto",codProducto],
	["oidPais", oidPais],
	["oidIdioma", oidIdioma] ] );
	
}

function visibleLista() {
	DrdEnsanchaConMargenDcho('listado1',12);
	visibilidad('capaLista','V');
	eval (ON_RSZ);  
}

function invisibleLista() {
	visibilidad('capaLista','O');
}
function muestraLista(ultima, rowset){
          var tamano = rowset.length;
          if (tamano > 0) {
                    visibleLista();
                    if (get(FORMULARIO+'.casoUso') == 'eliminar')
                  		btnProxy(4, 1);

                    return true;
          } else {
                    invisibleLista();              
                    focaliza(FORMULARIO+'.txtCodRegalo');
                    //cdos_mostrarAlert("No se ha econtrado ningun resutado");
                    return false;
          }
}

function onClickModificar(){
	/*
	Cuando se pulsa el botón btnModificar, si hay un regalo seleccionado en la lista lstRegalos, se abre una ventana emergente modal y en la nueva ventana se invoca a la LPMantenimientoRegalos con accion="MuestraPantalla" 
	oid = el oid del regalo seleccionado en lstRegalos
	*/
	if (listado1.numSelecc() == 0) {
		// Muestra el mensaje: "Debe seleccionar un elemento de la lista"
		GestionarMensaje('50');

	} else {
		if (listado1.numSelecc() != 1 ) {
			//Muesta el mensaje: "Debe seleccionar un solo registro"
			GestionarMensaje('8');
			//Se limpia la lista editable
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
			objParams.casoUso="modificar";
			var seleccionados = listado1.codSeleccionados();                        
			var fila=mostrarModalSICC('LPMantenimientoRegalos', 'MuestraPantalla', objParams, null, null);
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
	}
}

function onClickDetealle(){
	/*
	Cuando se pulsa el botón btnDetalle, si hay un regalo seleccionado en la lista lstRegalos, se abre una ventana emergente modal y en la nueva ventana se invoca a la LPMantenimientoRegalos con accion="MuestraPantallaConsulta" 
	oid = el oid del regalo seleccionado en lstRegalos
	*/
	if (listado1.numSelecc() == 0) {
		// Muestra el mensaje: "Debe seleccionar un elemento de la lista"
		GestionarMensaje('50');
		
	} else {
		if (listado1.numSelecc() != 1 ) {
			//Muesta el mensaje: "Debe seleccionar un solo registro"
			GestionarMensaje('8');
			//Se limpia la lista editable
			var seleccion=listado1.codigos();
			var i=0;
			while(seleccion[i]!=null){
				listado1.deselecciona(i); 
				i++;           
			}
		} else {
			//Obtenemos el oid seleccionados
			//Llamos al proceso correspondiente Modal
			var casoUso = get(FORMULARIO +'.casoUso');
			var objParams = new Object();
			objParams.oidSeleccionado=listado1.codSeleccionados();     
			objParams.casoUso= casoUso;                                              
			mostrarModalSICC('LPMantenimientoRegalos', 'MuestraPantallaConsulta', objParams, null, null);
			
		}
	}
}

function fBorrar(){
	onClickEliminar();
}
		
function onClickEliminar(){
	/*
	Cuando se pulsa el botón bntEliminar, si hay algún regalo seleccionado en lstRegalos: 
	Se invoca a LPMantenimientoRegalos mediante un EnviarOculto con accion="Eliminar" 	
	Se quitan de la lista lstRegalos los elementos seleccionados
	*/
	if(listado1.numSelecc() == 0){ 
		GestionarMensaje('50');
	}else{
		if (cdos_mostrarConfirm("¿Desea eliminar los elemento seleccionados?")){
			set(FORMULARIO+'.hOids',listado1.codSeleccionados());
			set(FORMULARIO+'.accion','Eliminar');
			set(FORMULARIO+'.conectorAction','LPMantenimientoRegalos');
			enviaSICC(FORMULARIO);
		}
		
	}	
}

function focalizaOntabBuscar(){
	if (!get_visibilidad("capaLista")){
		focaliza(FORMULARIO+'.txtCodRegalo');
	}else {
		if (get(FORMULARIO+'.casoUso')!=''){
			if ((get(FORMULARIO+'.casoUso')=='consultar')||(get(FORMULARIO+'.casoUso')=='eliminar')){
				document.all['Detalle'].focus();
			}else{
				document.all['Modificar'].focus();
			}
		}
	}	
}

function focalizaOnshtabCod(){
	if (!get_visibilidad("capaLista")){
		document.all['btnBuscar'].focus();
	}else{
		if (get(FORMULARIO+'.casoUso')!=''){
			if ((get(FORMULARIO+'.casoUso')=='consultar')||(get(FORMULARIO+'.casoUso')=='eliminar')){
				document.all['Detalle'].focus();
			}else{
				document.all['Modificar'].focus();
			}
		}
	}
}

function focalizaOntab(){
	focaliza(FORMULARIO+'.txtCodRegalo');
}

function focalizaOnshtab(){
	document.all['btnBuscar'].focus();
}

function validarCodRegalo(){
	var num = get(FORMULARIO+'.txtCodRegalo'); 
	if(num != ""){
		var val = allTrim(num);
		set(FORMULARIO+'.txtCodRegalo',val);             
    	//Como no nos interesa validar el número de dígitos que tiene el 
    	//entero ponemos uno suficientemente grande. 
		if ((ValidaInt(val.toString(),10000, 0)!="OK")||(val.toString() < 0)) {
			GestionarMensaje('747', null, null, null);
			focaliza(FORMULARIO+'.txtCodRegalo');
			
		} 
	}
}

function noEspaciosCodProd() {
	var num = get(FORMULARIO+'.txtCodProducto');
	if (num != ""){
		var val = allTrim(num);
		set(FORMULARIO+'.txtCodProducto',val);
	}
}

function noFocoCodProd() {
	mayusculas();
	noEspaciosCodProd();
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

function eliminacionCorrecta(){
	listado1.eliminarSelecc();
	focaliza(FORMULARIO+".txtCodRegalo");
}                                            

function mayusculas(){
	var codigo = get(FORMULARIO +'.txtCodProducto');                                                             	
   if(codigo != ""){                                                                                          
         set(FORMULARIO +'.txtCodProducto',get(FORMULARIO +'.txtCodProducto').toUpperCase());
    }   
}                                                                                                       