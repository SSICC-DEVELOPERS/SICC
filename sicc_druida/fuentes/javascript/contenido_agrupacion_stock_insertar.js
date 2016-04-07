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
    $Id: contenido_agrupacion_stock_insertar.js,v 1.1 2009/12/03 19:02:24 pecbazalar Exp $
    DESC
*/

var FORMULARIO = 'formulario';

function onLoadPag(){
	if (get(FORMULARIO+'.errDescripcion')!='') {
                  var wnd = fMostrarMensajeError(get(FORMULARIO+'.errCodigo'),get(FORMULARIO+'.errDescripcion'));
    }
	 DrdEnsanchaConMargenDcho('listado1',12);
          
          //Dependiendo del caso de uso mostramos los botones
          var casoUso = get(FORMULARIO + '.casoUso');
		  if((casoUso == 'consultar')||(casoUso == 'eliminar')){
		  		accion(FORMULARIO+'.txtCodAgrupacionStock','.disabled=true');
		  		accion(FORMULARIO+'.txtDescripcion','.disabled=true');
		  		accion(FORMULARIO+'.rbIndicadorDefecto','.disabled=true');
				document.all["btnAnadirDiv"].style.visibility='hidden';
    			document.all["btnModificarDiv"].style.visibility='hidden';
		  }else if(casoUso == 'insertar'){
				document.all["btnAnadirDiv"].style.visibility='';
    			document.all["btnModificarDiv"].style.visibility='';
    			set(FORMULARIO +'.rbIndicadorDefecto','N');
    			focaliza(FORMULARIO + ".txtCodAgrupacionStock");
		  }else if(casoUso == 'modificar'){
		  		accion(FORMULARIO+'.txtCodAgrupacionStock','.disabled=true');
		  		document.all["btnAnadirDiv"].style.visibility='';
    			document.all["btnModificarDiv"].style.visibility='';
    			focaliza(FORMULARIO + ".txtDescripcion");
    			varNoLimpiarSICC = true;
		  }
          
         eval (ON_RSZ);
    configurarMenuSecundario(FORMULARIO);
}

function accionAnadir(){
		set(FORMULARIO + '.accion',"anadirDetalle");
		var codigo = get(FORMULARIO +'.txtCodAgrupacionStock');
		var descripcion = get(FORMULARIO +'.txtDescripcion');
		var indicador = get(FORMULARIO +'.rbIndicadorDefecto');
		var casoUso = get(FORMULARIO +'.casoUso');
		var objParams = new Object();
		objParams.Cod = codigo;
		objParams.Descrip = descripcion;
		objParams.Indica = indicador;
		objParams.casoUso = casoUso;
		var oid = listado1.generaCodigo();
		objParams.oidEstadoMercancia = oid;
		var fila = mostrarModalSICC('LPMantenimientoAgrupacionStock','anadirDetalle', objParams, null, null);
		if(typeof(fila)!='undefined') {
        	if(fila.length!=0) {
        
        		//Insertamos la fila
        		listado1.insertar(fila);
        		listado1.reajusta();
            }
 		}
	}
	
function accionModificar(){
	set(FORMULARIO + '.accion',"modificarDetalle");
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
		var oidAgrupacionStockCabecera = get(FORMULARIO +'.oidAgrupacionStockCabecera');
		var casoUso = get(FORMULARIO +'.casoUso');
		var objParams = new Object();
		objParams.oidEstadoMercancia = seleccionados;
		objParams.casoUso = casoUso;
		listado1.actualizaDat();
		var datosFinal = listado1.datos;
		for (i = 0; i < datosFinal.length; i++) {
      		var fila = datosFinal[i];
      		if(fila[0]== seleccionados){
      			var descripcion = fila[1];
      			var operacion = fila[2];
      			var coddescrip = fila[3];
      			var codoperacion = fila[4];
      			objParams.descripcion = descripcion;
      			objParams.operacion = operacion;
      			objParams.codOperacion = codoperacion;
      			objParams.codDescrip = coddescrip;
      		}
		} //Bucle sobre las filas*/
	
		var fila = mostrarModalSICC('LPMantenimientoAgrupacionStock','modificarDetalle',objParams,null,null);
		set(FORMULARIO +'.oidAgrupacionStockCabecera',oidAgrupacionStockCabecera);
		if(typeof(fila)!='undefined') {
	        	if(fila.length!=0) {
        
    	    		//Modificamos la fila
					listado1.actualizaDat();
					var datosFinal = listado1.datos;
					for (i = 0; i < datosFinal.length; i++) {
      					var filaaux = datosFinal[i];
      					if(filaaux[0]== seleccionados){
      						filaaux[2] = fila[2];
      						filaaux[3] = fila[3];
      						filaaux[4] = fila[4];
      					}
      				}
        			listado1.reajusta();
            	}
 		}	
	}
}

function fBorrar(){
	if(listado1.numSelecc() == 0){
			// "Debe seleccionar un elemento de la lista"
			GestionarMensaje('50');
	}else{
		var seleccionados = listado1.codSeleccionados();
		eliminarFilas(seleccionados,'',mipgndo);
	}
}

function fGuardar(){
	set(FORMULARIO +'.accion','guardar');
	var cadena = "";
    listado1.actualizaDat(); //Actualiza el array 'datos'
    var datosFinal = listado1.datos;
    for (i = 0; i < datosFinal.length; i++) {
             var fila = datosFinal[i];
             for (j = 1; j < fila.length; j++) {
                      if(fila[j] == ""){ 
                               fila[j] = "-";
                      }else{
                      	cadena += fila[j] + "@";
                      }
             }
             cadena += "#";
    }
    set(FORMULARIO + '.lista', cadena);
	var lista = get(FORMULARIO +'.lista');
	var descrip = get(FORMULARIO +'.txtDescripcion');
	if (sicc_validaciones_generales()){
		window.returnValue = [descrip];
		enviaSICC(FORMULARIO);
	}
}

function fLimpiar(){
	var casoUso = get(FORMULARIO +'.casoUso');
	if(casoUso == 'insertar'){
		limpiaI18N(FORMULARIO,1);
		set(FORMULARIO +'.rbIndicadorDefecto','N');
		var datos = new Array();
		listado1.setDatos(datos);
		listado1.reajusta();
	}else if(casoUso == 'modificar'){
		var indicadorDef = get(FORMULARIO +'.indicadorDef');
		var descripcion = get(FORMULARIO +'.descripcion');
		limpiaI18N(FORMULARIO,1);
		set(FORMULARIO +'.txtDescripcion',descripcion);
		set(FORMULARIO +'.rbIndicadorDefecto',indicadorDef);
		listado1.load(); 
		listado1.reajusta();
	}
}

function focoboton(){
	document.all['btnModificar'].focus();	
}

function fVolver(){
         window.close();
}

function fGuardadoCorrecto(){
	var casoUso = get(FORMULARIO + '.casoUso');
	if(casoUso == 'insertar'){
		fLimpiarGenericoSICC();
	 	fLimpiar();
	}
}

function focobotonModificar(){
	var accion = get(FORMULARIO +'.casoUso');
	if(accion == 'modificar'){
		document.all['btnModificar'].focus();
	}else{
		focaliza(FORMULARIO +'.txtCodAgrupacionStock');
	}
}

function foco(){
	var casoUso = get(FORMULARIO +'.casoUso');	
	if(casoUso == 'modificar'){
		focaliza(FORMULARIO +'.txtDescripcion');
	}else{
		focaliza(FORMULARIO +'.txtCodAgrupacionStock');
	}
}

function focoAnadir(){
	document.all['btnAnadir'].focus();
}

function focoRadio(){
	focaliza(FORMULARIO +'.rbIndicadorDefecto');	
}

function mayusculas(){
	var codigo = get(FORMULARIO +'.txtCodAgrupacionStock');
	if(codigo != ""){
		set(FORMULARIO +'.txtCodAgrupacionStock',get(FORMULARIO +'.txtCodAgrupacionStock').toUpperCase());
	}
}