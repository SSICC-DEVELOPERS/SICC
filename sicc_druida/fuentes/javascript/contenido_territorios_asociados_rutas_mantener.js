var FORMULARIO = 'frmFormulario'
function onLoadPag(){

	configurarMenuSecundario(FORMULARIO);
        var errDescripcion = get(FORMULARIO +'.errDescripcion');
	var accion = get(FORMULARIO+'.accion');
	if (errDescripcion !='') {         

		var errCodigo = get(FORMULARIO+'.errCodigo');
		var wnd = fMostrarMensajeError(errCodigo, errDescripcion);
	}
	
	DrdEnsanchaConMargenDcho('listado1',24);
	DrdEnsanchaConMargenDcho('listado2',12);
	eval (ON_RSZ);
	if(document.getElementById('cbRuta').disabled){
		document.all['btnSeleccionar'].focus();
	}else{
		focaliza(FORMULARIO+'.cbRuta');
	}
}

function fLimpiar(){
	visibilidad('capaLista1','O');
	visibilidad('capaLista2','O');
	visibilidad('capa2','O');
	if(document.getElementById('cbRuta').disabled){
		document.getElementById('cbRuta').disabled=false;
	}
}

function visibleLista() {
   visibilidad('capaLista1','V');
   DrdEnsanchaConMargenDcho('listado1',12);
   eval (ON_RSZ);
 }

 function ocultaLista() {
        visibilidad('capaLista1','O');
 }

 function muestraLista(ultima, rowset) {
   var tamano = rowset.length;
   if (tamano > 0) {
              visibleLista();
              return true;
   } else {
              ocultaLista();
              focaliza(FORMULARIO+'.txtTerritorioDesde','');
              return false;
   }
 }
 
function onShTabRuta(){ 
	if(get_visibilidad("capaLista1")){
		document.all['btnAnadir'].focus();
	}else{
		document.all['btnSeleccionar'].focus();
	}
}

function onTabSeleccionar(){
	var nombrelistado= "listado2";
	var nombreCajaText= "Texto1";
	listado2.actualizaDat();
	var datosLista = listado2.datos; 
	var contador = 0;
	for (i = 0; i < datosLista.length; i++) {
		contador++;
	}
	if(get_visibilidad("capaLista2")&& contador != 0){
		eval(nombrelistado+".preparaCamposDR()"); 
		focaliza('frm'+nombrelistado+'.'+nombreCajaText+'_'+0,'');
	}else if(get_visibilidad("capaLista2")&& contador==0){
		focaliza(FORMULARIO+'.txtTerritorioDesde');
	}else{
		focaliza(FORMULARIO+'.cbRuta');
	}
}

function onShTabSeleccionar(){
	if(document.getElementById('cbRuta').disabled){
		document.all['btnAnadir'].focus();
	}else{
		focaliza('frmFormulario.cbRuta','');
	}
}

function onTabAnadir(){
	document.all['btnSeleccionar'].focus();
}

function focalizaSig(FILAEVENTO,TECLAEVENTO){
        if (FILAEVENTO == listado2.datos.length-1 && TECLAEVENTO == 9) {
        	document.body.focus();
                setTimeout("focaliza('"+FORMULARIO+".txtTerritorioDesde');",5)
	}
}

function focalizaAnt(FILAEVENTO,TECLAEVENTO){
	if(FILAEVENTO == 0 && TECLAEVENTO == 9) {
		document.body.focus();
		setTimeout("document.all['btnSeleccionar'].focus();",5);
        }
}

function anterior(){
	var nombrelistado= "listado2";
	var nombreCajaText= "Texto1";
	listado2.actualizaDat();
	var datosLista = listado2.datos; 
	var fila= listado2.datos.length-1;
	var contador = 0;
	for (i = 0; i < datosLista.length; i++) {
		contador++;
	}
	if(contador != 0){
		eval(nombrelistado+".preparaCamposDR()");
		focaliza('frm'+nombrelistado+'.'+nombreCajaText+'_'+fila,'');
	}
	else{
		document.all['btnSeleccionar'].focus();
	}
}

function validarNumerico(campo, fila){                                  
         var num=campo[2];
         var nombrelistado= "listado2";
	 var nombreCajaText= "Texto1";
         if(num != ""){
                  var val = allTrim(num);              
         //Como no nos interesa validar el número de dígitos que tiene el 
         //entero ponemos uno suficientemente grande. 
                  if ((ValidaInt(val.toString(),10000, 0)!="OK")||(val.toString() < 0)) {
                           GestionarMensaje('747', null, null, null);
                           eval(nombrelistado+".preparaCamposDR()");
			   focaliza('frm'+nombrelistado+'.'+nombreCajaText+'_'+fila,'');
                           return false;
                  }else {
                  	   return true;
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

function accionSeleccionar(){
	var cbRuta = get(FORMULARIO+'.cbRuta');
	//Se comprueba que se ha introducido un valor en la combo cbRuta
	if(cbRuta==''){
		//Si no se ha seleccionado un valor mostrar mensaje: APP003
		//Codigo 1396
		GestionarMensaje('1396');
		focaliza('frmFormulario.cbRuta','');
	}else{  //en otro caso
		//Obtiene de la página el criterio de búsqueda introducido por el usuario: 
		//- oidRuta = correspondiente al valor seleccionado en la combo cbRuta 
		//Llamamos a la LPMantenimientoTerritoriosRutas con opcionMenu, accion="Seleccionar", oidRuta
		frmFormulario.oculto = 'N';
		set(FORMULARIO+'.oidRuta',cbRuta);
		set(FORMULARIO+'.accion','Seleccionar');
                set(FORMULARIO+'.conectorAction','LPMantenimientoTerritoriosRutas');
                enviaSICC(FORMULARIO);
	}
}
function validarNumericoTerritorios(territorio){                                  
         var num = get(FORMULARIO+'.'+territorio);
         if(num != ""){
         var val = allTrim(num);              
         //Como no nos interesa validar el número de dígitos que tiene el 
         //entero ponemos uno suficientemente grande. 
                  if ((ValidaInt(val.toString(),10000, 0)!="OK")||(val.toString() < 0)) {
                           cdos_mostrarAlert(GestionarMensaje('1417'));
			   focaliza(FORMULARIO+'.'+territorio);
                           return false;
                  }else {
                  	   return true;
                  }
         }                                   
} 
function accionBuscar(){
	
	//Obtiene de la página los criterios de búsqueda introducidos por el usuario: 
	//- territorioDesde = valor de txtTerritorioDesde 
	//- territorioHasta = valor de txtTerritorioHasta 
	//Los parametros no introducidos tendrán valor Null
	if(sicc_validaciones_generales()){	
		var txtTerritorioDesde = get(FORMULARIO+'.txtTerritorioDesde');
		var txtTerritorioHasta = get(FORMULARIO+'.txtTerritorioHasta');
		if(txtTerritorioDesde!=""){
			if(!validarNumericoTerritorios('txtTerritorioDesde')){
				return false;	
			}
		}
		if(txtTerritorioHasta!=""){
			if(!validarNumericoTerritorios('txtTerritorioHasta')){
				return false;	
			}
		}	
	
		var cbRuta = get(FORMULARIO+'.cbRuta');
		//Llamamos a configurarPaginado pasándole los siguientes parametros: 
		//- Objeto paginado (listaTerritorios) 
		//- idBusiness ("APPBuscarTerritorios") //es APPBuscarTerritoriosNoAsociados
		//- "ConectorBuscarTerritorios" //es ConectorBuscarTerritoriosNoAsociados
		//- "DTOTerritorio" 
		//- Parametros del DTO: 
		//- pais activo 
		//- idioma activo 
		//- territorioDesde 
		//- territorioHasta
		var idioma = get(FORMULARIO+'.idioma');
	        var pais = get(FORMULARIO+'.pais');
		configurarPaginado(mipgndo, "APPBuscarTerritoriosNoAsociados", "ConectorBuscarTerritoriosNoAsociados","es.indra.sicc.dtos.app.DTOTerritorio",[["oidPais", pais],["oidIdioma", idioma],["oidRuta",cbRuta],["territorioDesde", txtTerritorioDesde],["territorioHasta", txtTerritorioHasta]]); 
		visibilidad('capaLista1','V');
	}
}

function fGuardar(){
	var correcto = comprobarSecuencia();
	var lista='';
	if(correcto==true){
		listado2.actualizaDat();
		var datosLista = listado2.datos;
         	for (i = 0; i < datosLista.length; i++) {
                    	
                	//metemos en la variable fila una tupla de la lista
                  	var fila = datosLista[i];     
                  	if (fila[3] == '1'){     	//campo modificado corresponde a fila[3]
                  		if(!validarNumerico(fila, i)){
                  			return false;	   
                  		}else{               	
                  			//añadimos una fila, ponemos separadores para distinguir celdas y tuplas   
	                  		lista = lista + fila[0] + "@";
	                  		lista = lista + allTrim(fila[2]) + "@";
	                  		lista = lista + fila[4] + "#";
	                	}
                	 }
                            	                      
         	}
         	set(FORMULARIO+'.listaRegistros',lista);
		// Envia el formulario oculto
		//Llamar a la LPMantenimientoTerritoriosRutas con:
		//opcionMenu
		//accion="Guardar"
		frmFormulario.oculto = 'S';
		set(FORMULARIO+'.accion', 'Guardar');
		set(FORMULARIO+'.conectorAction', 'LPMantenimientoTerritoriosRutas');
		enviaSICC(FORMULARIO);
	}
}

function comprobarSecuencia(){
	//Se comprueba que todos los elementos de la "listaTerritoriosAsociados" tienen un 
	//número de secuencia asociado y no está repetido 
	//Para cada elemento de la "listaTerritoriosAsociados" comprobar que el campo 
	//numeroSecuencia no es nulo y además no existe ningún numero de secuencia repetido 
	//Si existe algún número de secuencia nulo 
	//{ 
	//mostrar mensaje: APP001 
	//devuelve false 
	//} 
	//en otro caso 
	//{ 
	//Si hay números de secuencia duplicados 
	//{ 
	//mostrar mensaje: APP002 
	//devuelve false 
	//} 
	//en otro caso 
	//devuelve true 
	//}
	listado2.actualizaDat();
	var datosLista = listado2.datos; 
	var numSecuenciaExis = '';
	var error = 'false'; 
	var nuevaVariable;//contendrá un array con todos los números
	var repetido= 0;//si es 2 o más es que está repetido
   	//rellenamos el hidden con los campos de los numeros de secuencia
	for (i = 0; i < datosLista.length; i++) { 
		var fila = datosLista[i]; 
 		numSecuenciaExis = numSecuenciaExis + allTrim(fila[2]) + '*';
	}
	for (j = 0; j < datosLista.length; j++) { 
        	var fila = datosLista[j]; 
                nuevaVariable =numSecuenciaExis.split("*");
                for(k = 0; k < nuevaVariable.length; k++){   
                	if(fila[2]== nuevaVariable [k]){ //campo numeroSecuencia corresponde a fila[2]    
                		repetido = repetido +1;
                	}
			if(repetido >= 2){
   				error = 'duplicados'; 
                	}
                	if(fila[2]==''){ //campo numeroSecuencia corresponde a fila[2]    
                		error = 'nulo'; 
                	}
         	}
       		repetido = 0; 
        }
	if(error == 'duplicados'){ 
		GestionarMensaje('1400'); //Número de secuencia repetido 
		return false; 
	}else{ 
		if(error == 'nulo'){ 
			GestionarMensaje('1401'); //Hay territorios sin número de secuencia asignado 
			return false; 
		}else{ 
			return true; 
		}
	}
}
function fBorrar(){
          
           accionEliminar();
}
function accionEliminar(){
	//Comprueba que hay, al menos, un elemento selecionado en la "listaTerritoriosAsociados" 
	if (listado2.numSelecc() == 0) {
        	// "Debe seleccionar un elemento de la lista"
         	GestionarMensaje('50');
        } else {
        	//Para cada elemento seleccionado en la lista, se obtiene su oid y se pasa a la LPMantenimientoTerritoriosRutas
        	//Envia el formulario oculto 
        	//Llamamos a la LPMantenimientoTerritoriosRutas con 
        	//opcionMenu 
		//accion="Eliminar" 
		//oids de los elementos seleccionados en la lista 
		//set(FORMULARIO+'.oids', listado2.codSeleccionados());
		frmFormulario.oculto = 'S';
		set(FORMULARIO+'.accion', 'Eliminar');
		set(FORMULARIO+'.conectorAction', 'LPMantenimientoTerritoriosRutas');
		enviaSICC(FORMULARIO);
	}
}

//Codigo para quitar un territorio asociado de esa lista y añadirlo en la lista de territorios asociados
function accionAnadir(){	
	if (listado1.numSelecc() == 0) {
        	// "Debe seleccionar un elemento de la lista"
         	GestionarMensaje('50');
        } else {
		var codSeleccion = new String(listado1.codSeleccionados());
		var seleccion = codSeleccion.split(',');
		//seleccion tiene que ser un array con todos los codigos
		for (i = 0; i < seleccion.length; i++) { 

        		var codTerritorio = listado1.extraeDato(seleccion[i],0);
        		var existe = "false"; 
        		var datosLista = listado2.datos;

	  		for (j = 0; j < datosLista.length; j++) {  
	  			 
	  			var fila = datosLista[j]; 
	  		
	  			if(fila[1]==codTerritorio){
	  				existe = "true";
	  				break;
	  			}	
	  		
	  		}     	        	
        		if(existe != "true"){
        		
	        		var nuevaFila =new Array(5);
	        		
	        		nuevaFila[0] = "0";//insertamos todos con el mismo oid porque no vamos a necesitar que sean distintos
	        		nuevaFila[1] = codTerritorio;
	        		nuevaFila[2] = "";//numero de secuencia
	        		nuevaFila[3] = "";//modificado
	        		nuevaFila[4] = seleccion[i];//oidTerritorio
	        		listado2.insertar(nuevaFila); 
			}
    
        	}
        	listado2.reajusta();
		listado1.eliminarSelecc();
	}
}


function listaTerritoriosAsociados_SecuenciaOnChange(filaEvento){
	//Se recupera la fila modificada de la lista "listaTerritoriosAsociados" y se asigna a la columna "modificado" el valor 1
	//indica que ese elemento de la lista ha sido modificado 
	listado2.datos[filaEvento][3] = '1';//campo modificado corresponde a [3]
}

function postGuardar() {
	fLimpiarGenericoSICC();
	fLimpiar();
}

function postEliminar() {
	listado2.eliminarSelecc();
	listado2.repinta();
}

