/**
* Copyright 2004 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
    $Id: contenido_agrupacion_stock_modificar.js,v 1.1 2009/12/03 19:02:15 pecbazalar Exp $
    DESC
*/

var FORMULARIO = 'formulario';

function onLoadPag()   {
	if (get(FORMULARIO+'.errDescripcion')!='') {
                  var wnd = fMostrarMensajeError(get(FORMULARIO+'.errCodigo'),get(FORMULARIO+'.errDescripcion'));
    }
	configurarMenuSecundario(FORMULARIO);
  	focaliza(FORMULARIO+'.txtCodAgrupacionStock','');
}

function accionBuscar(){
	var codigo = get(FORMULARIO +'.txtCodAgrupacionStock');
	var descripcion = get(FORMULARIO +'.txtDescripcion');
	var DTOEBuscarAgrupacionStock = 'es.indra.sicc.dtos.bel.DTOEBuscarAgrupacionStock';
	 if (get(FORMULARIO+'.casoUso') == 'eliminar')
    		btnProxy(4, 0); 

	configurarPaginado(mipgndo,"BELBuscarAgrupacionStock","ConectorBuscarAgrupacionStock",DTOEBuscarAgrupacionStock,
	[['codigoAgrupacionStock',codigo],['descripcion',descripcion]]);
}

function accionModificar(){
	set(FORMULARIO + '.accion','detalle');
	if(listado1.numSelecc() == 0){
		// "Debe seleccionar un elemento de la lista"
		GestionarMensaje('50');
	}else if(listado1.numSelecc() >1){
		// "Debe seleccionar solo un elemento de la lista"
		GestionarMensaje('1217');
		//Se limapa la lista editable
		var seleccion=listado1.codigos();
                var i=0;
                while(seleccion[i]!=null){
                  listado1.deselecciona(i); 
                  i++;           
                }
	}else{
		var seleccionados = listado1.codSeleccionados();
		set(FORMULARIO +'.oidAgrupacionStock',seleccionados);
		var oidAgrupacionStock = get(FORMULARIO +'.oidAgrupacionStock');
		var casoUso = get(FORMULARIO +'.casoUso');
		var objParams = new Object();
		objParams.seleccionados = seleccionados;
		objParams.accion = accion;
		objParams.oidAgrupacionStock = oidAgrupacionStock;
		objParams.casoUso = casoUso;
		var fila = mostrarModalSICC('LPMantenimientoAgrupacionStock','detalle',objParams,null,null);
		if(typeof(fila)!='undefined') {
	        	if(fila.length!=0) {
    	    		//Modificamos la fila
					listado1.actualizaDat();
					var datosFinal = listado1.datos;
					for (i = 0; i < datosFinal.length; i++) {
      					var filaaux = datosFinal[i];
      					if(filaaux[0]== seleccionados){
      						filaaux[2] = fila[0];
      					}
      				}
        			listado1.reajusta();
            	}
 		}	
	}
}

function accionDetalle(){
	set(FORMULARIO + '.accion','detalle');
	if(listado1.numSelecc() == 0){
		// "Debe seleccionar un elemento de la lista"
		GestionarMensaje('50');
	}else if(listado1.numSelecc() >1){
		// "Debe seleccionar solo un elemento de la lista"
		GestionarMensaje('1217');
		//Se limapa la lista editable
		var seleccion=listado1.codigos();
                var i=0;
                while(seleccion[i]!=null){
                  listado1.deselecciona(i); 
                  i++;           
                }
	}else{
		var seleccionados = listado1.codSeleccionados();
		set(FORMULARIO +'.oidAgrupacionStock',seleccionados);
		var oidAgrupacionStock = get(FORMULARIO +'.oidAgrupacionStock');
		var casoUso = get(FORMULARIO +'.casoUso');
		var objParams = new Object();
		objParams.seleccionados = seleccionados;
		objParams.accion = accion;
		objParams.oidAgrupacionStock = oidAgrupacionStock;
		objParams.casoUso = casoUso;
		var fila = mostrarModalSICC('LPMantenimientoAgrupacionStock','detalle',objParams,null,null);
	}	
}

function fBorrar(){
	
	if(listado1.numSelecc() == 0){
		// "Debe seleccionar un elemento de la lista"
		GestionarMensaje('50');
	
	}else{
		var seleccionados = listado1.codSeleccionados();
		eliminarFilas(seleccionados,"BELEliminarAgrupacionStock",mipgndo);
	}	
}

function visibleLista() {
          DrdEnsanchaConMargenDcho('listado1',12);
         	
          visibilidad('capaLista','V');

          //Dependiendo del caso de uso mostramos los botones
          var acci = get(FORMULARIO +'.accion');
          if(acci == 'modificar'){
    			document.all["btnModificarDiv"].style.visibility='';
    			document.all["btnDetalleDiv"].style.visibility='hidden';
   		 }
    	 if((acci == 'consultar')||(acci == 'eliminar')){
    			document.all["btnModificarDiv"].style.visibility='hidden';
    			document.all["btnDetalleDiv"].style.visibility='';
   		 }
          
         eval (ON_RSZ);
}

function ocultaLista() {
    visibilidad('capaLista','O');
}

function muestraLista(ultima, rowset) {
          var tamano = rowset.length;
          if (tamano > 0) {
                visibleLista();
        	if (get(FORMULARIO+'.casoUso') == 'eliminar')
                btnProxy(4, 1);

                    return true;
          } else {
                    ocultaLista();
                    focaliza(FORMULARIO+'.txtCodAgrupacionStock','');
                    return false;
          }
}

function focoboton(){
	var casoUso = get(FORMULARIO +'.casoUso');
	if(get_visibilidad("capaLista")){
		if(casoUso == 'modificar'){
			document.all['btnModificar'].focus();
		}else{
			document.all['btnDetalle'].focus();
		}
	}else{
		document.all['btnBuscar'].focus();
	}
}

function focobotonBuscar(){
	var casoUso = get(FORMULARIO +'.casoUso');
	if(get_visibilidad("capaLista")){
		if(casoUso == 'modificar'){
			document.all['btnModificar'].focus();
		}else{
			document.all['btnDetalle'].focus();
		}
	}else{
		focaliza(FORMULARIO+'.txtCodAgrupacionStock');
	}
}

function focoBuscar(){
	document.all['btnBuscar'].focus();
}

function mayusculas(){
	var codigo = get(FORMULARIO +'.txtCodAgrupacionStock');
	if(codigo != ""){
		set(FORMULARIO +'.txtCodAgrupacionStock',get(FORMULARIO +'.txtCodAgrupacionStock').toUpperCase());
	}
}