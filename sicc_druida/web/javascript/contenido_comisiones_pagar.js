/**
* Copyright 2005 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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

	
	focaliza(FORMULARIO+'.txtCodComision');
	
	configurarMenuSecundario(FORMULARIO);   
}

function fechaValida(){
         
      var fecha = get(FORMULARIO+'.txtFechaCalculo');
      if(fecha != ""){
                var resul = EsFechaValida(fecha,fecha, FORMULARIO,null);
                if(resul==1 || resul==2){
                       GestionarMensaje('1006', get(FORMULARIO+'.hFormatoFechaPais'));
                          focaliza(FORMULARIO+'.txtFechaCalculo');
                          return false;
          }
      }
}



function onClickBuscar(){
	/*Llamamos a configurarPaginado pasándole los siguientes parametros: 
	- Objeto paginado (lstResultados) 
	- idBusiness ("COMBuscarComisionesPagar") 
	- "ConectorBuscarComisionesPagar" 
	- "DTOBuscarComisionesPagar" 
	- Parametros del DTOBuscarComisionesPagar: 
	- codComision = codComision 
	- descripcion = descripcion 
	- fechaCalculo = fechaCalculo*/	
	var codComision = get(FORMULARIO+'.txtCodComision');
	var descripcion = get(FORMULARIO+'.txtDescripcion');
	var fechaCalculo = get(FORMULARIO+'.txtFechaCalculo');
  var formatoFecha= get(FORMULARIO+'.hFormatoFechaPais');
	var oidPais = get(FORMULARIO+'.pais');
	var oidIdioma = get(FORMULARIO+'.idioma');     
        
	configurarPaginado(mipgndo, "COMBuscarComisionesPagar", "ConectorBuscarComisionesPagar", 'es.indra.sicc.dtos.com.DTOBuscarComisionesPagar', 
	[["codComision",codComision],
	["descripcion",descripcion],
	["fechaCalculo",fechaCalculo],
  ["formatoFecha",formatoFecha],
	["oidPais", oidPais],
	["oidIdioma", oidIdioma]] );	

}

function onClickDetalle(){
	/*
	Llama a la LPPagarCOM con: 
	- accion="detalle" 
	- oidComision*/

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
			var seleccionado = listado1.codSeleccionados();      
      var oidComision = listado1.extraeDato(seleccionado, 12);
      var fechaCalculo = get(FORMULARIO+'.txtFechaCalculo');
      
			var objParams = new Object();
			objParams.oidComision = oidComision;
      objParams.fechaCalculo = fechaCalculo;
			var resultado = mostrarModalSICC('LPPagarCOM', 'Detalle', objParams, null, null); 
			if (resultado != null)   mipgndo.go();
      
	  }        
	}	
}

function onClickPagarComision(){
	/*
	Si solo se ha seleccionado un registro de la lstResultados { 
	Llama a la LPPagarCOM con: 
	- oidComision del registro seleccionado de la lstResultados 
	- accion="Pagar" 
	} 
	En otro caso { 
	Mostrar el error correspondiente 
	}*/

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
			var seleccionado = listado1.codSeleccionados();
      var oidComision = listado1.extraeDato(seleccionado, 12);
      
			set(FORMULARIO+'.oidComision',oidComision);
			set(FORMULARIO+'.accion','Pagar');
			set(FORMULARIO+'.conectorAction','LPPagarCOM');
			enviaSICC(FORMULARIO);			
	      }
	}	
	
}

function ontab(dato){
	if (!get_visibilidad("capaLista")){
		focaliza(FORMULARIO+'.txtCodComision');
	}else {
		if (dato=='buscar'){
			document.all['btnDetalle'].focus();
		}else{
			focaliza(FORMULARIO+'.txtCodComision');
		}
	}
}

function onshtab(){
	if (!get_visibilidad("capaLista")){
		document.all['btnBuscar'].focus();
	}else {
		document.all['btnPagarComision'].focus();
	}	
}

function muestraLista(ultima, rowset){
         var tamano = rowset.length;
         if (tamano > 0) {
                    visibleLista();
                    return true;
         } else {
                    invisibleLista();                  
                    focaliza(FORMULARIO+'.txtCodComision');
                    return false;
         }
}

function visibleLista(){
	DrdEnsanchaConMargenDcho('listado1',12);
	visibilidad('capaLista','V');
	eval (ON_RSZ);  
}


function invisibleLista(){
	visibilidad('capaLista','O');
}

function accionCorrecta(){
	onClickBuscar();	
}
