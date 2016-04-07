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
    $Id: contenido_formas_pago_detalle_insertar.js,v 1.1 2009/12/03 19:01:34 pecbazalar Exp $
    DESC
*/
var FORMULARIO = 'formulario';

//Funcion que se ejecuta al cargar la pagina
function onLoadPag() {
    if (get(FORMULARIO+'.errDescripcion')!='') {
		var wnd = fMostrarMensajeError(get(FORMULARIO+'.errCodigo'),get(FORMULARIO+'.errDescripcion'));
    } 

    focaliza(FORMULARIO + ".cbFormaPago");
    var acci = get(FORMULARIO +'.accion');
	if(acci == 'insertar'){
		accion(FORMULARIO+'.txtNumDias','.disabled=true');	
		accion(FORMULARIO+'.cbActividad','.disabled=true');
		accion(FORMULARIO+'.cbMarca','.disabled=true');
		accion(FORMULARIO+'.cbCanal','.disabled=true');
	}
   	configurarMenuSecundario(FORMULARIO);
   	visibleLista();
}
//Funcion que se ejecuta cuando cambia el combo marca
function marcaOnChange() {
         
    //Cuando cambie el combo de marca recargamos el de actividad en función del primero. 
	var marca = get(FORMULARIO+'.cbMarca');
    var canal = get(FORMULARIO+'.cbCanal');
   
    if ((canal!='') && (marca!='')){
      	recargaCombo(FORMULARIO+'.cbActividad','BELRecargaComboActividad', 'es.indra.sicc.dtos.cra.DTOActividad',[["oidMarca", marca],["oidCanal", canal],["oidPais",get(FORMULARIO+'.pais')],["oidIdioma",get(FORMULARIO+'.idioma')]]);         
    	accion(FORMULARIO+'.cbActividad','.disabled=false');
    }else{
    	vaciaCombo('.cbActividad');
    }        
}

//Funcion que se ejecuta cuando cambia el combo canal
function canalOnChange() {
         
    //Cuando cambie el combo de canal recargamos el de actividad en función del primero.         
    var marca = get(FORMULARIO+'.cbMarca');
    var canal = get(FORMULARIO+'.cbCanal');
    if ((canal!='') && (marca!='')){
        recargaCombo(FORMULARIO+'.cbActividad','BELRecargaComboActividad', 'es.indra.sicc.dtos.cra.DTOActividad',[["oidMarca", marca],["oidCanal", canal],["oidPais",get(FORMULARIO+'.pais')],["oidIdioma",get(FORMULARIO+'.idioma')]]); 
    	accion(FORMULARIO+'.cbActividad','.disabled=false');
    }else{
    	vaciaCombo(".cbActividad");
    }
    
}

//Funcion que se ejecuta cuando cambia el combo forma de pago
function formaPagoCabeceraOnChange() {
                  		          
    //1. Mostrar el mensaje "UIGEN0003" ?????????????????????????????????????????????'
	//Si acepta entonces 
	//2. Se borra la lista "tablaDetalle" 
	//3. Se asigna el ConectorDTConsultarDetalleFormaPago a la lista "tablaDetalle" 
	//pasándole como parametro el valor del combo "formaPagoCabecera". 
	//Si no 
	//4. No hacer nada y mantener la selección anterior del combo 
	//Fin Si
	
	var formaPago =  get(FORMULARIO + ".cbFormaPago");
	var hmformaPago = get(FORMULARIO +'.hmformaPago');
	if(formaPago != "") {
			var datosFinal = listado1.datos;
			if (datosFinal.length > 0) {
				var retorno=cdos_mostrarConfirm(GestionarMensaje('1324')); 
				if (retorno) {
					//Hacemos invisibles las capas
		        	//Ponemos al estado inicial las listas (vacias)
		        	var datos = new Array();
		        	listado1.setDatos(datos);
		        	listado1.reajusta();
		        	btnProxy(4, 0);
		        	asignar([["LISTAEDITABLE","listado1","ConectorDTConsultarDetalleFormaPago","dtoSalida.resultado_ROWSET", formaPago, "carga(datos)"]]);
		        	set(FORMULARIO +'.hmformaPago',formaPago);
				}else{
					set(FORMULARIO +'.cbFormaPago',[hmformaPago]);
				}
			} else {
				asignar([["LISTAEDITABLE","listado1","ConectorDTConsultarDetalleFormaPago", "dtoSalida.resultado_ROWSET", formaPago, "carga(datos)"]]);
				set(FORMULARIO +'.hmformaPago', formaPago);
			}
	} else {
		var datos = new Array();
		listado1.setDatos(datos);
		listado1.reajusta();
		btnProxy(4, 0);

	}
}

function carga(datos) {
	listado1.setDatos(datos);
	listado1.reajusta();
	if (datos.length > 0)
		btnProxy(4, 1);
}

function accionAnadir() {
	
	//1. Se valida que los campos obligatorios no estén vacíos. 
	//2. Se añade una línea al final de la tabla con los datos de pantalla: 
	//formaPagoCabecera, posicionDetalle, medioPago, porcentajePago, indicadorDeDias, numeroDeDias, marca, 
	//canal y actividad (oids en oculto y descripciones para los datos de los combos). 
	//3. La posición se generará dinámicamente sumando 1 a la posición de la último registro 
	//existente en la tabla, si no tiene ninguno la posición será 1. 
	//4. Se guardarán en columnas ocultas los oid de los campos 
	//formaPagoCabecera, medioPago, marca, canal y actividad, que servirán para 
	//el guardado de cada registro de detalle de forma de pago.
	
if (sicc_validaciones_generales()) {
		
		var formaPagoCabecera = get(FORMULARIO+'.cbFormaPago','T');
		//Calculamos la posicion
     		listado1.actualizaDat(); 
        	var datos = listado1.datos;
        	var posicionDetalle = datos.length + 1;
		var medioPago = get(FORMULARIO+'.cbCodigoMedioPago','T');
		var porcentajePago = get(FORMULARIO+'.txtPorcentajePago');
		var indicadorDeDias = get(FORMULARIO+'.cbIndicadorDias');
		var desIndicadorDeDias = get(FORMULARIO+'.cbIndicadorDias','T');
		var numeroDeDias = get(FORMULARIO+'.txtNumDias');
		var marca = get(FORMULARIO+'.cbMarca','T');
		var canal = get(FORMULARIO+'.cbCanal','T');
		var actividad = get(FORMULARIO+'.cbActividad','T');
		//Oids ocultos
		var oidFormaPagoDetalle = get(FORMULARIO+'.cbFormaPago');
		var oidmedioPago = get(FORMULARIO+'.cbCodigoMedioPago');
		var oidmarca = get(FORMULARIO+'.cbMarca');
		var oidcanal = get(FORMULARIO+'.cbCanal');
		var oidactividad = get(FORMULARIO+'.cbActividad');
		var fila = [posicionDetalle,formaPagoCabecera,posicionDetalle,porcentajePago,medioPago,desIndicadorDeDias,numeroDeDias,marca,canal,actividad,oidFormaPagoDetalle,oidmedioPago,oidmarca,oidcanal,oidactividad,indicadorDeDias];
		listado1.insertar(fila);
		if (listado1.datos.length > 0)
				btnProxy(4, 1);

	}
}

function accionModificar() {
	
	//1. Cuando se pulsa el botón "modificar" se debe haber seleccionado 
	//un registro en la lista "tablaDetalle" 
	//2. Se abre una ventana modal haciendo una llamada a la lp 
	//LPMantenimientoFormaPagoDetalle con acción "modificar"
    if (listado1.numSelecc() == 0) {
        //Mostramos mensaje de error 
        GestionarMensaje('50');
    } else {
          if (listado1.numSelecc() != 1 ) {
              //Muesta el mensaje: "Debe seleccionar un solo registro"
              GestionarMensaje('1217');
              //Se limpia la lista editable
                //var seleccion=listado1.codigos();
                for ( i = 0; i < listado1.codigos().length; i++) {
                    listado1.deselecciona(i); 
                }

          } else {
      		       //Obtenemos los datos del seleccionado y los insertamos
      		        listado1.actualizaDat();	
			var codigo = listado1.codSeleccionados();
			var objParams = new Object();	
	 		objParams.posicionDetalle = codigo; 
	 		objParams.descripcionFormaPagoCabecera = listado1.extraeDato(codigo,0); 
	 		objParams.posicionDetalle = listado1.extraeDato(codigo,1); 
	 		objParams.porcentajePago = listado1.extraeDato(codigo,2); 
			objParams.medioPago = listado1.extraeDato(codigo,3); 
			objParams.DesIndicadorDeDias = listado1.extraeDato(codigo,4); 
			objParams.numeroDeDias = listado1.extraeDato(codigo,5); 
			objParams.marca = listado1.extraeDato(codigo,6); 
			objParams.canal = listado1.extraeDato(codigo,7); 
			objParams.actividad = listado1.extraeDato(codigo,8); 
			objParams.oidFormaPagoDetalle = listado1.extraeDato(codigo,9); 
			objParams.oidMedioPago = listado1.extraeDato(codigo,10);
			objParams.oidMarca = listado1.extraeDato(codigo,11); 
			objParams.oidCanal = listado1.extraeDato(codigo,12); 
			objParams.oidActividad = listado1.extraeDato(codigo,13); 
			objParams.indicadorDeDias = listado1.extraeDato(codigo,14);
			objParams.idioma = get(FORMULARIO+'.idioma');
			objParams.idioma = get(FORMULARIO+'.pais');		 				
			
					
			//Recogemos el array nuevo con las modificaciones de la fila editada
			
           		var fila = mostrarModalSICC('LPMantenimientoFormasPagoDetalle', 'modificar', objParams, null, null);	
           		if(typeof(fila)!='undefined') {
	        		if(fila.length!=0) {
    	    			//Modificamos la fila
						listado1.actualizaDat();
						var datosFinal = listado1.datos;
						for (i = 0; i < datosFinal.length; i++) {
      						var filaaux = datosFinal[i];
      						if(filaaux[0]== codigo){
      							for(j = 0; j < fila.length; j++){
      								filaaux[j] = fila[j];
      							}
      						}
      					}
        				listado1.reajusta();
            		}
 				}
               		               		
           }
         }
}

function accionEliminar() {
	//Se eliminan de la lista los registros seleccionados, y se reenumeran 
	//los registros que quedan en la lista de 1 a n en el orden en que se 
	//hayan introducido o recuperado. Para persistir la eliminación de los 
	//registros el usuario tiene que pulsar el botón "guardar" del menú secundario.
	fBorrar();
}
//Funcion se ejecuta cuando se pulsa borrar en la botonera
function fBorrar() { 

      //Quitamos las filas seleccionadas de la lista y reenumeramos los registros
               
	   if (listado1.numSelecc() > 0 ) {
	    	listado1.eliminarSelecc();
	    	//Modificamos posicionDetalle
	    	listado1.actualizaDat(); 
        	var datosFinal = listado1.datos;
        	if (datosFinal.length == 0) btnProxy(4, 0);
        	for (i = 0; i < datosFinal.length; i++) {
        		var posicionDetalle = i + 1;
        		datosFinal[i][0]= posicionDetalle;
        		datosFinal[i][2]= posicionDetalle;
        	}
        	var datos = new Array();
			listado1.setDatos(datos);
			listado1.reajusta();
			listado1.actualizaDat();
			for(j = 0; j < datosFinal.length; j++){
				var fila = datosFinal[j];
				listado1.insertar(fila);
			}
			
        	//listado1.setDatos(datosFinal);
        	listado1.reajusta();
	   }
	   else {
	        GestionarMensaje('50');
	   }
}

function validarPorcentajes() {
	//Este método valida que la suma de los porcentajes de la lista "tablaDetalle" 
	//sea igual a 100, si no se cumple lanzar un mensaje de error 
	//con el código de error UIBEL0001
	//Obtenemos los datos

	//listado1.actualizar();
	var suma = 0;	
	var datos = listado1.datos;
	for (var i=0;i<datos.length;i++) { 		
         var p = datos[i][3];
         suma = Number(suma) + Number(p);
       }
     if(suma != 100) {
     	focaliza(FORMULARIO +'.txtPorcentajePago');
     	return false;
    }else{
    	
    	return true;
    }
}
function fGuardar(){
	
accionGuardar();	

}

function accionGuardar() {
	//Llamar a LPMantenimientoFormasPagoDetalle con acción "guardar"
	//Se obtienen todos los datos de la lista editable y se guardan en una cadena
	if (validarPorcentajes()){
			var cadena = "";
			listado1.actualizaDat(); //Actualiza el array 'datos'
			var datosFinal = listado1.datos;
			for (i = 0; i < datosFinal.length; i++) {
				var fila = datosFinal[i];
				for (j = 0; j < fila.length; j++) {
					if(fila[j] == "") fila[j] = "-";
					
						cadena += fila[j] + "@";
				} 
				cadena += "#";
			}

	
            set(FORMULARIO + '.oidFormaPago', get(FORMULARIO+'.cbFormaPago'));
		    set(FORMULARIO + '.descFormaPago', get(FORMULARIO+'.cbFormaPago','T'));
            set(FORMULARIO + '.cadena', cadena);
            set(FORMULARIO + '.accion', 'guardar');
		    set(FORMULARIO + '.conectorAction', 'LPMantenimientoFormasPagoDetalle');
           	              	    
           enviaSICC(FORMULARIO);		
           
    }else{
       	cdos_mostrarAlert(GestionarMensaje('1325'));
   	}
     
} 

function vaciaCombo(combo) {
    if (eval('document'+combo) != 'undefined'){
        set_combo(FORMULARIO + combo,[['','']],['']);
    }
    return true;
}
//Funcion para hacer visible la capa
function visibleLista() {
          
    visibilidad('capaListado','V');
    DrdEnsanchaConMargenDcho('listado1',12);
    eval (ON_RSZ);
}

//Funcion para no visible la capa
function novisibleLista() {
          
    visibilidad('capaListado','O');
}
function fLimpiar(){
	vaciaCombo('.cbActividad');
	var tipo = get(FORMULARIO +'.tipoAccion');
	if(tipo == 'insertar'){
		var datos = new Array();
		listado1.setDatos(datos);
		listado1.reajusta();
		btnProxy(4, 0);

	}
	focaliza(FORMULARIO + ".cbFormaPago");
	accion(FORMULARIO+'.txtNumDias','.disabled=true');
	accion(FORMULARIO+'.cbMarca','.disabled=true');
	accion(FORMULARIO+'.cbCanal','.disabled=true');
	accion(FORMULARIO+'.cbActividad','.disabled=true');
}

function focoBoton(){
	document.all['btnModificar'].focus();
}

function fGuardadoCorrecto(){
	var tipo = get(FORMULARIO +'.tipoAccion');
	if(tipo == 'insertar'){
		fLimpiarGenericoSICC();
		fLimpiar();
	}
}

function fGuardadoInCorrecto(){
	btnProxy(4, 1)
}

function activarDias() {
	var indicador = get(FORMULARIO +'.cbIndicadorDias','T');
	if (indicador == 'N') {
		accion(FORMULARIO+'.txtNumDias','.disabled=false');
	} else {
		set(FORMULARIO +'.txtNumDias','');
		accion(FORMULARIO+'.txtNumDias','.disabled=true');
	}

	if (indicador == 'N'){
			for (var i = 0; i < objValidacionSICC.length; i++) {
				if (objValidacionSICC[i].nombre == 'txtNumDias')
					objValidacionSICC[i].requerido = true;
			}
	} else {
			for (var i = 0; i < objValidacionSICC.length; i++) {
				if (objValidacionSICC[i].nombre == 'txtNumDias')
					objValidacionSICC[i].requerido = false;
			}
	}

	if (indicador == 'A') {
		for (var i = 0; i < objValidacionSICC.length; i++) {
			if (objValidacionSICC[i].nombre == 'cbMarca' || objValidacionSICC[i].nombre == 'cbCanal' || objValidacionSICC[i].nombre == 'cbActividad')
				objValidacionSICC[i].requerido = true;
		}

		accion(FORMULARIO+'.cbMarca','.disabled=false');
		accion(FORMULARIO+'.cbCanal','.disabled=false');
		set(FORMULARIO +'.cbMarca',[get(FORMULARIO +'.marcaPorDefecto')]);		
		set(FORMULARIO +'.cbCanal',[get(FORMULARIO +'.canalPorDefecto')]);
		if (get(FORMULARIO +'.cbMarca') == '')	//puede haber problemas de evidencia de foco	
			set(FORMULARIO +'.cbMarca', ['']);
		if (get(FORMULARIO +'.cbCanal') == '')		
			set(FORMULARIO +'.cbCanal', ['']);
		marcaOnChange();		
	} else {
		for (var i = 0; i < objValidacionSICC.length; i++) {
			if (objValidacionSICC[i].nombre == 'cbMarca' || objValidacionSICC[i].nombre == 'cbCanal' || objValidacionSICC[i].nombre == 'cbActividad')
				objValidacionSICC[i].requerido = false;
		}
		accion(FORMULARIO+'.cbActividad','.disabled=true');
		set(FORMULARIO +'.cbMarca', ['']);
		set(FORMULARIO +'.cbCanal', ['']);
		accion(FORMULARIO+'.cbMarca','.disabled=true');
		accion(FORMULARIO+'.cbCanal','.disabled=true');
		vaciaCombo('.cbActividad');
	}
}

function onBlurPorcentaje(){
	var porcentaje = get(FORMULARIO+'.txtPorcentajePago');
	if(esNumero(porcentaje) == '-1'){
		GestionarMensaje('747');
		focaliza(FORMULARIO+'.txtPorcentajePago');
	}
}

function onBlurDias(){
	var dias = get(FORMULARIO +'.txtNumDias');
	if(esNumero(dias) == '-1'){
		GestionarMensaje('747');
		focaliza(FORMULARIO +'.txtNumDias');	
	}
}

function focoAnadir(){
	document.all['btnAnadir'].focus();
}