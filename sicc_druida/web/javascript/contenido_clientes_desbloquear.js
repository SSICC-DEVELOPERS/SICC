var FORMULARIO = 'frmDesbloquearClientes';


// nombres de los campos para limpiar
var nombresCampos = ["textCodCliente", "textNombre1", "textNombre2", "textApellido1", "textApellido2", "textDocumentoIdentidadCliente"];


function onLoadPag() {
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
	document.all["btnEjecutarDiv"].style.visibility='';

	// configurar el menu secundario	
	configurarMenuSecundario(FORMULARIO);
	
	// pasar el foco al primer control de la pagina
	focaliza(FORMULARIO + ".cbSeleccionarOpcion");

	eval (ON_RSZ);
}



function accionBuscar() {
	// BELC300003494
	// Llamamos a configurarPaginado pasandole los siguientes parametros: el objeto paginado de la
	// lista resultados, CCCBuscarClientesBloqueados, ConectorEjemplo, DTOBuscarClienteBloqueo y
    	// un array con los parametros del dto obteniendo los valores de los campos correspondientes de la
    	// pantalla.

	if(listado1.datos.length==1 && get_visibilidad('capaLista') == true) {
		fLimpiar();
		visibilidad('capaLista', 'O');
        focaliza(FORMULARIO + '.cbSeleccionarOpcion');
        set(FORMULARIO + '.cbSeleccionarOpcion', "");
		onLoadPag();
	}
	else {
	
	var opcion = get(FORMULARIO+'.cbSeleccionarOpcion');
	if (sicc_validaciones_generales()){
		var codigo = get(FORMULARIO + ".textCodCliente");
		var nombre1 = get(FORMULARIO + ".textNombre1");
		var nombre2 = get(FORMULARIO + ".textNombre2");
		var apellido1 = get(FORMULARIO + ".textApellido1");
		var apellido2 = get(FORMULARIO + ".textApellido2");
        
		var documentoIdentificacion = get(FORMULARIO + ".textDocumentoIdentidadCliente");
		var contador = 0; 
         	//Comprobamos si se han seleccionado al menos dos criterios de busqueda		
		if(codigo != ''){
			contador++;
		}
		if(nombre1 != ''){
			contador++;
		}
		if(nombre2 != ''){
			contador++;
		}
		if(apellido1 != ''){
			contador++;
		}
		if(apellido2 != ''){
			contador++;
		}
		if(documentoIdentificacion != ''){
			contador++;
		}
				
		if(contador<2){
                  //mostramos el mensaje: "Debe introducir al menos dos criterios de filtro" (UICCC005) <- BELC300011338.
                  //Codigo 1405
                  GestionarMensaje('1405');
                  focaliza(FORMULARIO+'.textCodCliente');
         	}else{
		
		
			if (opcion == 0){
				/*Si opcionBloqueo==0 (Desbloqueo) 
				{ 
				Llamamos a configurarPaginado pasandole los siguientes parametros: el objeto paginado de la lista resultados, 
				CCCBuscarClientesBloqueados, 
				ConectorBuscarClientesBloqueados, 
				DTOBuscarClienteBloqueo 
				y un array con los parametros del dto obteniendo los valores de los campos correspondientes de la pantalla. 
				}*/
                    configurarPaginado(mipgndo,
	    					"CCCBuscarClientesBloqueados",
	    					"ConectorBuscarClientesBloqueados",
	    					"es.indra.sicc.dtos.mae.DTOBuscarClienteBloqueo",
	    					[
	    					 	["codigo", codigo], 
	    						["nombre1", nombre1], 
	    						["nombre2", nombre2], 
	    						["apellido1", apellido1], 
	    						["apellido2", apellido2], 
	    						["documentoIdentificacion", documentoIdentificacion],  
	    						["oidIdioma", get(FORMULARIO + ".idioma")], 
	    						["oidPais", get(FORMULARIO + ".pais")]    
	    					]
	    			);
			
			}else{
			   if (opcion == 1){
				/*Si opcionBloqueo==1 (Bloqueo) 
				{ 
				Llamamos a configurarPaginado pasandole los siguientes parametros: el objeto paginado de la lista resultados, 
				CCCBuscarClientesDesbloqueados, 
				ConectorBuscarClientesDesbloqueados, 
				DTOBuscarClienteBloqueo 
				y un array con los parametros del dto obteniendo los valores de los campos correspondientes de la pantalla. 
				} */
			    	configurarPaginado(mipgndo,
	    					"CCCBuscarClientesDesbloqueados",
	    					"ConectorBuscarClientesDesbloqueados",
	    					"es.indra.sicc.dtos.mae.DTOBuscarClienteBloqueo",
	    					[
	    					 	["codigo", codigo], 
	    						["nombre1", nombre1], 
	    						["nombre2", nombre2], 
	    						["apellido1", apellido1], 
	    						["apellido2", apellido2], 
	    						["documentoIdentificacion", documentoIdentificacion],  
	    						["oidIdioma", get(FORMULARIO + ".idioma")], 
	    						["oidPais", get(FORMULARIO + ".pais")]    
	    					]
	    			);
	    		   }
			}
			// se hace visible la lista editable, que esta incluida en una capa
			//visibleLista();
		}
	}

	}
}



function accionEjecutar() {

	if (listado1.numSelecc() == 0) {
		// Muestra el mensaje: "Debe seleccionar al menos un elemento de la lista"
		GestionarMensaje('1021');
	} else {
		var opcion = get(FORMULARIO+'.cbSeleccionarOpcion');
		set(FORMULARIO+'.oidsSeleccionados',listado1.codSeleccionados());
		if (opcion == 0){
			// BELC300003494
			//La accionDesbloquear de la pantalla se debe enviar de forma oculta
			
			// se establece la accion
			set(FORMULARIO + '.accion', 'desbloquear');
			set(FORMULARIO+'.conectorAction','LPDesbloquearClientes');
			// se llamara a la LP con la accion desbloquear
			enviaSICC(FORMULARIO);
			
			// una vez hecho esto ejecutamos la accion ="buscar" para que se 
			// recargue la pantalla con el efecto de la operación ejecutada (BELC300003494)
			//accionBuscar();
		}else{
			// BELC300003494
			//La accionDesbloquear de la pantalla se debe enviar de forma oculta
			var lista = listado1.datos;
			
			//para una lista con nombre "listado1"
            var seleccion=listado1.codSeleccionados();
            
            var dat ="";               
            var i=0;
            var obse= "";
            var longObse = 0;
            while(seleccion[i]!=null){
                obse= listado1.extraeDato(seleccion[i],6);
                if( obse.length > 100 ){     
                    longObse = 1;
                    break;
                }
                dat = dat+seleccion[i]+","+listado1.extraeDato(seleccion[i],5)+","+obse+";";
                i++;           
            }
            
            if( longObse != 1 ){ 
                set(FORMULARIO+'.listaCompleta',listado1.datos);
			
                set(FORMULARIO+'.datos',dat);
                // se establece la accion
                set(FORMULARIO + '.accion', 'bloquear');
                set(FORMULARIO+'.conectorAction','LPDesbloquearClientes');
                // se llamara a la LP con la accion desbloquear
                enviaSICC(FORMULARIO);
                
            } else {
                GestionarMensaje('3340');
            }
            
            
			// una vez hecho esto ejecutamos la accion ="buscar" para que se 
			// recargue la pantalla con el efecto de la operación ejecutada (BELC300003494)
			//accionBuscar();
		}

	}
}


/*
function accionDesbloquear() {
	
	if (listado1.numSelecc() == 0) {
		// Muestra el mensaje: "Debe seleccionar al menos un elemento de la lista"
		GestionarMensaje('1021');
	} else {
		// BELC300003494
		//La accionDesbloquear de la pantalla se debe enviar de forma oculta
		
		// se establece la accion
		set(FORMULARIO + ".accion", "desbloquear");
		set(FORMULARIO + ".accion", "desbloquear");
		// se llamara a la LP con la accion desbloquear
		enviaSICC(FORMULARIO);
		
		// una vez hecho esto ejecutamos la accion ="buscar" para que se 
		// recargue la pantalla con el efecto de la operación ejecutada (BELC300003494)
		accionBuscar();
	}
}*/


function fLimpiar() {
	for (var i=0; i < nombresCampos.length; i++) {
		var campo = FORMULARIO + "." + nombresCampos[i];
		set(campo, "");
	}
	focaliza(FORMULARIO + ".cbSeleccionarOpcion");	
}


function focalizaShiftTabComboOpcion() {
	if (get_visibilidad('capaLista') == true) {
		document.all['btnEjecutar'].focus();
	} else {
		document.all['btnBuscar'].focus();
	}	
}

/*function focalizaTabBtnBuscar() { 
	if (get_visibilidad('capaLista') == true) {
		document.all['btnEjecutar'].focus();
	} else {
		focaliza(FORMULARIO + ".cbSeleccionarOpcion");	
	}
}*/


function focalizaTabBtnBuscar(){
         var nombrelistado= "listado1";
         var nombreCajaText= "txtMotivo";
         listado1.actualizaDat();
         var datosLista = listado1.datos; 
         var fila= 0;

 	 if (get_visibilidad('capaLista') == true) {
                  eval(nombrelistado+".preparaCamposDR()");
                  focaliza('frm'+nombrelistado+'.'+nombreCajaText+'_'+fila,'');
	 } else {
		focaliza(FORMULARIO + ".cbSeleccionarOpcion");	
	 }
}
	
function focalizaShTabBtnEjecutar(){
         var nombrelistado= "listado1";
         var nombreCajaText= "atxtObservaciones";
         listado1.actualizaDat();
         var datosLista = listado1.datos; 
         var fila= listado1.datos.length-1;

 	 if (get_visibilidad('capaLista') == true) {
                  eval(nombrelistado+".preparaCamposDR()");
                  focaliza('frm'+nombrelistado+'.'+nombreCajaText+'_'+fila,'');
	 } else {
		document.all['btnBuscar'].focus();
	 }
}
	
	

function muestraLista(ultima, rowset) {
		var tamano = rowset.length;
		if (tamano > 0) {
			visibilidad('capaLista', 'V');
			DrdEnsanchaConMargenDcho('listado1', 12);
			eval (ON_RSZ);
			return true;
		} else {
			visibilidad('capaLista', 'O');
		        focaliza(FORMULARIO + '.cbSeleccionarOpcion');
		  	return false;
	 	}
}



function focalizaSig(FILAEVENTO,TECLAEVENTO){
         if (FILAEVENTO == listado1.datos.length-1 && TECLAEVENTO == 9) {
                  document.body.focus();
                  setTimeout("document.all['btnEjecutar'].focus();",5);
         }
}

function focalizaAnt(FILAEVENTO,TECLAEVENTO){
         if(FILAEVENTO == 0 && TECLAEVENTO == 9) {
                  document.body.focus();
                  setTimeout("document.all['btnBuscar'].focus();",5);
         }
}

function codigoClienteOnBlur() {
         var codigoCliente = get(FORMULARIO+'.textCodCliente');
         if (codigoCliente != '') {
                  var longitudCodigoCliente = get(FORMULARIO+'.tamanio');
                  var longitud = codigoCliente.length;
                  set(FORMULARIO+'.textCodCliente',rellenaCeros(codigoCliente,longitudCodigoCliente,longitud));
         }
}
