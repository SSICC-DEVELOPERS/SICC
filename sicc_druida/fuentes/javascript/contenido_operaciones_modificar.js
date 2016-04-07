var FORMULARIO = 'frmFormulario';



function onLoadPag(){
	
	
	configurarMenuSecundario(FORMULARIO);
	var opcion = get(FORMULARIO+'.opcionMenu');
	
	DrdEnsanchaConMargenDcho('listado1',12);
	eval (ON_RSZ);
	
	//alert("opcion: " + opcion);
	 
	if( opcion == 'modificar operacion'){
		
		document.all["btnDetalleDiv"].style.visibility='hidden';
		document.all["btnModificarDiv"].style.visibility='';
	}else{
		
		document.all["btnModificarDiv"].style.visibility = 'hidden';
		document.all["btnDetalleDiv"].style.visibility = '';
	}
	
	focaliza(FORMULARIO + ".txtCodigoOperacion");
  
}

function onClickBuscar(){
	
	/*Llamamos a configurarPaginado pasándole los siguientes parametros: 
	- Objeto paginado (lstResultados) 
	- idBusiness ("CALobtenerOperaciones")  //sera RECObtenerOperaciones
	- "ConectorObtenerOperaciones" 
	- "DTOBusqueda" 
	- Parametros del DTOBusqueda: 
	- codOperacion = codOperacion 
	- descripcionCorta= descripcionCorta*/
	
	var codOperacion = get(FORMULARIO + '.txtCodigoOperacion');
	var descripcionCorta = get(FORMULARIO + '.txtDescripcionCorta');
	var pais = get(FORMULARIO + '.pais');
	var idioma = get(FORMULARIO + '.idioma');
	var opcionMenu = get(FORMULARIO+'.opcionMenu');
	
	if(opcionMenu == "eliminar operacion"){
		btnProxy(4, 0);
	}
	
	configurarPaginado(lstResultados,"RECObtenerOperaciones",
        "ConectorObtenerOperaciones","es.indra.sicc.dtos.rec.DTOBusqueda",
        [["oidPais", pais], ["oidIdioma", idioma], ["codOperacion", codOperacion], ["descripcionCorta", descripcionCorta]]);
	
}

function onClickModificar(){

	/*Si solo se ha seleccionado un registro de la lstResultados: 
	Se llama en una ventana emergente y modal a la LPOperacion con: 
	- accion= "modificar operacion" 
	- oid del registro seleccionado en la lstResultados 
	Sino se muestra el mensaje de error correspondiente.*/
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
  			set(FORMULARIO+'.accion', 'modificar operacion');
  			var accion = get( FORMULARIO +'.accion');
  			var objParams = new Object();
  			var seleccionados = listado1.codSeleccionados();
			objParams.oidOperacion = listado1.codSeleccionados();
			objParams.accion = accion;
			objParams.opcionMenu = "modificar operacion";
			objParams.idioma = get(FORMULARIO+'.idioma');
			objParams.pais= get(FORMULARIO+'.pais');
			var seleccionados = listado1.codSeleccionados();
			var fila = mostrarModalSICC('LPOperacion', 'modificar operacion', objParams, null, null);
			// se actualiza la lista con el registro modificado
			//alert("fila = "+fila);
			if(typeof(fila)!='undefined') {
            	if(fila.length!=0) {   
                	listado1.actualizaDat();
                    var datosFinal = listado1.datos;
                    for (i = 0; i < datosFinal.length; i++) {
                    	var filaaux = datosFinal[i];
                        if(filaaux[0]== seleccionados){
                        	filaaux[1] = fila[0];
                            filaaux[2] = fila[1];
                            filaaux[3] = fila[2];                                                            
                        }
                    }
                    listado1.reajusta();
                }
            }                              
                                                      
                                                     
    	} 
    }

}

function aMayusculas(campo){
    if (get(FORMULARIO+'.'+campo)!='') {
         set(FORMULARIO+'.'+campo,get(FORMULARIO+'.'+campo).toUpperCase());
    }
}


function onClickDetalle(){

	/*Si solo se ha seleccionado un registro de la lstResultados: 
	Se muestra la ventana emergente y modal PgOperacion y 
	Llama a la LPOperacion con: 
	- accion="detalle operacion" 
	- oid del registro seleccionado*/
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
		}else{
                  
        	set(FORMULARIO+ '.accion', 'detalle operacion');
        	var accion = get( FORMULARIO+'.accion');
        	var objParams = new Object();
			objParams.oidOperacion = listado1.codSeleccionados();
			//alert("oid = "+listado1.codSeleccionados());
			objParams.accion = accion;
			objParams.opcionMenu = "detalle operacion";
			objParams.idioma = get(FORMULARIO +'.idioma');
			objParams.pais= get(FORMULARIO +'.pais');
			mostrarModalSICC('LPOperacion', 'detalle operacion', objParams, null, null);
        }
	}
	
}
/*
function onCLickEliminar(){

	
}*/

function fBorrar(){//Sustituye a la accion onCLickEliminar
	
	/*Obtenemos los valores de los campos oid de las filas seleccionadas por el usuario 
	Llamamos a eliminarFilas pasandole el idBusiness="EliminarOperaciones", 
	los oids que hemos obtenido y el objeto paginado.*/
	
	if (listado1.numSelecc() == 0) {
		//Muestra el mensaje: "Debe seleccionar un elemento de la lista"
        GestionarMensaje('50');
	}else{
		var seleccionados = listado1.codSeleccionados();
		eliminarFilas(seleccionados,"RECEliminarOperaciones",lstResultados);
		focaliza(FORMULARIO + ".txtCodigoOperacion");
		onClickBuscar();
	}
	
}


function visibleLista() {
         
         visibilidad('capaListado1','V');     
}
 
function invisibleLista() {
         visibilidad('capaListado1','O');
}

function muestraLista(ultima, rowset){
           
    var opcionMenu = get(FORMULARIO+'.opcionMenu');                            
                  
	var tamano = rowset.length;
	if (tamano > 0) {
		visibleLista();
	    if(opcionMenu == "eliminar operacion"){
			btnProxy(4, 1);                    
		}  
	    return true;
	} else {   
		invisibleLista();                
	    return false;
    }
}

function onShTabCodigoOperacion(){
	
	
	if(get_visibilidad('capaListado1')){
		
		if( get(FORMULARIO + '.opcionMenu') == 'modificar operacion'){	
			document.all['btnModificar'].focus();
		}else{
			document.all['btnDetalle'].focus();
		}	
	}else{
		document.all['btnBuscar'].focus();	
	}
}

function onTabBuscar(){
	
	if(get_visibilidad('capaListado1')){
			
		if( get( FORMULARIO + '.opcionMenu' ) == 'modificar operacion'){	
			document.all['btnModificar'].focus();
		}else{
			document.all['btnDetalle'].focus();
		}	
	}else{
		focaliza(FORMULARIO + ".txtCodigoOperacion");	
	}
}

function onTabDetalle(){

	focaliza(FORMULARIO + ".txtCodigoOperacion");
}

function onTabModificar(){

	focaliza(FORMULARIO + ".txtCodigoOperacion");
}

function onShTabModificar(){
	
	document.all['btnBuscar'].focus();
}

function onShTabDetalle(){
	
	document.all['btnBuscar'].focus();
}
function fLimpiar(){
	set(FORMULARIO + ".txtCodigoOperacion", '');
	set(FORMULARIO + ".txtDescripcionCorta", '');
}
	