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
    $Id: contenido_tipo_movimiento_almacen_modificar.js,v 1.1 2009/12/03 19:02:01 pecbazalar Exp $
    DESC*/

var FORMULARIO = 'formulario';

//Funcion que se ejecuta al cargar la pagina
function onLoadPag(){
	DrdEnsanchaConMargenDcho('listado1',12);
	document.all["Cplistado1"].style.visibility='';
	document.all["CpLin1listado1"].style.visibility='';
	document.all["CpLin2listado1"].style.visibility='';
	document.all["CpLin3listado1"].style.visibility='';
	document.all["CpLin4listado1"].style.visibility='';
	document.all["separaDiv"].style.visibility='';
	document.all["primera1Div"].style.visibility='';
	document.all["ret1Div"].style.visibility='';
	document.all["ava1Div"].style.visibility='';
	
	if(get(FORMULARIO+'.casoUso')=='consultar'){  
    		document.all["btnModificarDiv"].style.visibility='hidden';
    		document.all["btnDetalleDiv"].style.visibility='';		
	}else if(get(FORMULARIO+'.casoUso')=='eliminar'){		
    		document.all["btnModificarDiv"].style.visibility='hidden';
    		document.all["btnDetalleDiv"].style.visibility='';		
	}else if(get(FORMULARIO+'.casoUso')=='modificar'){		
    		document.all["btnModificarDiv"].style.visibility='';
    		document.all["btnDetalleDiv"].style.visibility='hidden';		
	}		

	eval (ON_RSZ);  
	
	if (get(FORMULARIO+'.errDescripcion')!='') {                  
		var wnd = fMostrarMensajeError(get(FORMULARIO+'.errCodigo'),get(FORMULARIO+'.errDescripcion'));
	}   
	if ((get(FORMULARIO+'.casoUso')!="")){
		focaliza(FORMULARIO + ".txtCodTipoMovimiento");
	}
	
    configurarMenuSecundario(FORMULARIO);  
}

function codigoOnBlur(campo){
	if (get(FORMULARIO+'.'+campo)!='') {
		set(FORMULARIO+'.'+campo,get(FORMULARIO+'.'+campo).toUpperCase());
	}
}

function focalizaTP(){
	
	if (!get_visibilidad("capaLista")) {
		document.all['btnBuscar'].focus();
		tr=document.body.createTextRange(); 
        tr.execCommand("Unselect"); 


	}else{
		if((get(FORMULARIO+'.casoUso')=='consultar')||(get(FORMULARIO+'.casoUso')=='eliminar')){
			document.all['btnDetalle'].focus();
		}else{
			document.all['btnModificar'].focus();
		}
	}		
}

function focalizaBotonBuscar(){
	if (!get_visibilidad("capaLista")) {
		focaliza('formulario.txtCodTipoMovimiento');
	}else{
		if((get(FORMULARIO+'.casoUso')=='consultar')||(get(FORMULARIO+'.casoUso')=='eliminar')){
			document.all['btnDetalle'].focus();
		}else{
			document.all['btnModificar'].focus();
		}
	}			
}

function accionBuscar(){
    	if (get(FORMULARIO+'.casoUso') == 'eliminar')
             btnProxy(4, 0);
	
	var idioma = get(FORMULARIO+'.hIdioma');
	var pais   = get(FORMULARIO+'.hPais');
	var codigo=get(FORMULARIO+'.txtCodTipoMovimiento');
	var descripcion=get(FORMULARIO+'.txtDescripcion');
            
	configurarPaginado(mipgndo, "BELBuscarTiposMovimientosAlmacen", 
	"ConectorBuscarTiposMovimientosAlmacen", 
	"es.indra.sicc.dtos.bel.DTOEBuscarTiposMovimientosAlmacen", 
	[["oidIdioma", idioma],
	["oidPais", pais],
	["codigo", codigo],
	["descripcion", descripcion]] );        
	
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
function muestraLista( ultima, rowset){
	var tamano = rowset.length;
	if (tamano > 0) {
	      visibleLista();
    	if (get(FORMULARIO+'.casoUso') == 'eliminar')
             btnProxy(4, 1);
	      return true;
	} else {
	      invisibleLista();		
	      focaliza(FORMULARIO+'.txtCodTipoMovimiento');
	      //cdos_mostrarAlert("No se ha econtrado ningun resutado");
	      return false;
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
	      eliminarFilas(oids, "BELEliminarTiposMovimientosAlmacen", mipgndo);
	}
}
function accionConsultar() {
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
	               objParams.casoUso=get(FORMULARIO+'.casoUso');						
	               mostrarModalSICC('LPMantenimientoTiposMovimientosAlmacen', 'detalle', objParams, null, null);			
	               focaliza(FORMULARIO + ".txtCodTipoMovimiento");
	      }
	}	
}
function accionModificar() {
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
	}	
}