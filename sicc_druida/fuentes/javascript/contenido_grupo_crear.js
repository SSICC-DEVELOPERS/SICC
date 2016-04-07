   /*function onLoadPag(){
    DrdEnsanchaConMargenDcho('listado1',12); 
    eval (ON_RSZ);
   }*/
	var arrLimpia = new Array();


// ------------------------------------------------------------------------------------------------------------------------------------------------
   function fGuardar() { 

  //Valido que haya ind cuadre si esta habilitado
  if (get('frmContenido.hDeshabilitarCombo')!='S'){
      if(!sicc_validaciones_generales("indCuadre")){
         return false;
      }
  }
  //Valido que haya Porducto  
  if (listado1.datos.length<1){

    //alert("Debe ingresar un al menos un producto");
    GestionarMensaje('194');
    
    return;
  }
  if (get('frmContenido.hDeshabilitarFactorCuadre')!='S'){
	//cambia por incidencia DBLG700000034
	if (get('frmContenido.cbIndicadorCuadre','V')=='4') {//Por Monto
      if(!sicc_validaciones_generales("factCuadreDec")){
         return false;
      }
	} else {//Por Unidades
      if(!sicc_validaciones_generales("factCuadre")){
         return false;
      }
	}
  }

	set( 'frmContenido.textoCombo', get('frmContenido.cbIndicadorCuadre','T' ));
	set( 'frmContenido.valorCombo', get('frmContenido.cbIndicadorCuadre' ));
	set('frmContenido.hFactorCuadre', get('frmContenido.txtFactorCuadre' ));
	set('frmContenido.accion', 'Guardar');
	if(get('frmContenido.casoDeUso')=='modificar'){
		set('frmContenido.conectorAction', 'LPModificarGrupo');
	}else{
		set('frmContenido.conectorAction', 'LPCrearGrupo');
	}

	enviaSICC('frmContenido');
	
}

// ------------------------------------------------------------------------------------------------------------------------------------------------
function tabBoton(){

    if( get('frmContenido.hDeshabilitarCombo') == 'S' ){
      focaliza('frmContenido.txtFactorCuadre','');
    }
    else{
      focaliza('frmContenido.cbIndicadorCuadre','');
    }
}

// ------------------------------------------------------------------------------------------------------------------------------------------------
function shTabBoton(){

    if( get('frmContenido.hDeshabilitarFactorCuadre') == 'S' ){
      focaliza('frmContenido.cbIndicadorCuadre','');
    }
    else{
      focaliza('frmContenido.txtFactorCuadre','');
    }
}

// ------------------------------------------------------------------------------------------------------------------------------------------------
function shTabFactor(){

    if( get('frmContenido.hDeshabilitarCombo') == 'S' ){
      document.all.BuscarDiv.focus();
    }
    else{
      focaliza('frmContenido.cbIndicadorCuadre','');
    }
}

// ------------------------------------------------------------------------------------------------------------------------------------------------
function tabCombo(){

    if( get('frmContenido.hDeshabilitarFactorCuadre') == 'S' ){
      document.all.BuscarDiv.focus();
    }
    else{
      focaliza('frmContenido.txtFactorCuadre','');
    }
}

// ------------------------------------------------------------------------------------------------------------------------------------------------
function fLimpiar(){

    if( get('frmContenido.hDeshabilitarFactorCuadre') != 'S' ){
      //set('frmContenido.txtFactorCuadre','');
		set('frmContenido.txtFactorCuadre',arrLimpia[1]);
	 }
    if( get('frmContenido.hDeshabilitarCombo') == 'S' ){
      focaliza('frmContenido.txtFactorCuadre','');
    }
    else{
      //set('frmContenido.cbIndicadorCuadre','');
		set('frmContenido.cbIndicadorCuadre',arrLimpia[0]);
		focaliza('frmContenido.cbIndicadorCuadre','');
    }
}


// ------------------------------------------------------------------------------------------------------------------------------------------------
function fBorrar(){

  var codigo = "";
  var sCodigo = "";
  codigo = listado1.codSeleccionados();
  var i = 0;

  if (listado1.numSelecc() < 1){
    GestionarMensaje('4');
    return;
  }

  if(listado1.numSelecc() > 0){
    if(GestionarMensaje('5')){
      for( i = 0; i < codigo.length; i++ ){
        sCodigo += codigo[i];
        sCodigo += '|';
      }

      set('frmContenido.elementosSeleccionadosProductosAsociados', sCodigo);
      set('frmContenido.accion', 'Eliminar productos');
	    if(get('frmContenido.casoDeUso')=='modificar'){
		set('frmContenido.conectorAction', 'LPModificarGrupo');
		}else{
			set('frmContenido.conectorAction', 'LPCrearGrupo');
  	     }
      enviaSICC('frmContenido');
    }
  }
}

// ------------------------------------------------------------------------------------------------------------------------------------------------
function onLoadPag()   {

  varNoLimpiarSICC=true;
  configurarMenuSecundario('frmContenido');
    // Modificado por SICC20070316 - Rafael Romero - 18/07/2007
  if(get('frmContenido.casoDeUso')=='modificar'){
		btnProxy(2,"0");
		btnProxy(7,"0");
		btnProxy(8,"0");
        document.all["ConsultarDiv"].style.visibility='hidden';
    }else if(get('frmContenido.casoDeUso')=='consultar'){
		btnProxy(1,"0");
		btnProxy(2,"1");
		btnProxy(3,"0");
		btnProxy(4,"0");
		btnProxy(5,"0");
		btnProxy(7,"0");
		btnProxy(8,"0");
        document.all["BuscarDiv"].style.visibility='hidden';
        document.all["ModificarDiv"].style.visibility='hidden';
    }else{
        document.all["ConsultarDiv"].style.visibility='hidden';
    }
    // Fin modificado SICC20070316
  DrdEnsanchaConMargenDcho('listado1',12);
  eval (ON_RSZ);  

  asignarCombo();
  
  if( get('frmContenido.hDeshabilitarCombo') == 'S' ){
    accion('frmContenido.cbIndicadorCuadre', '.disabled="true"');
	 focaliza('frmContenido.txtFactorCuadre');
  }
  if( get('frmContenido.hDeshabilitarFactorCuadre') == 'S' ){
    accion('frmContenido.txtFactorCuadre', '.disabled="true"');
	   if( get('frmContenido.hDeshabilitarCombo') != 'S' )
			 focaliza('frmContenido.cbIndicadorCuadre');
  }  
  if (listado1.datos.length > 0) {
    // Modificado por SICC20070316 - Rafael Romero - 19/07/2007
    if(get('frmContenido.casoDeUso')!='consultar'){
        btnProxy(4, '1');
    }
    // fin modificado SICC20070316
  } else {
    btnProxy(4, '0');
  }
	arrLimpia[0]= get('frmContenido.cbIndicadorCuadre');
	arrLimpia[1]= get('frmContenido.txtFactorCuadre');
  //set( 'frmContenido.txtFactorCuadre', get('frmContenido.hFactorCuadre') );
}

// ------------------------------------------------------------------------------------------------------------------------------------------------
function asignarCombo(){

  var seleccionados = new Array();
  
  seleccionados[0] = get('frmContenido.valorCombo');
  set('frmContenido.cbIndicadorCuadre', seleccionados);
}

// ------------------------------------------------------------------------------------------------------------------------------------------------
function buscar(){

//alert('fsdfds     xsfc '+ get('frmContenido.casoDeUso'));
  set('frmContenido.accion', 'Buscar producto');

//	alert( get('frmContenido.casoDeUso'));
  if(get('frmContenido.casoDeUso')=='modificar'){
//  alert('caso de uso modificar');
		set('frmContenido.conectorAction', 'LPModificarGrupo');
  }else{
		set('frmContenido.conectorAction', 'LPCrearGrupo');
  }
  enviarFormulario();
}

// ------------------------------------------------------------------------------------------------------------------------------------------------
function enviarFormulario(){

  set( 'frmContenido.valorCombo', get( 'frmContenido.cbIndicadorCuadre' ) );
  set('frmContenido.hFactorCuadre', get( 'frmContenido.txtFactorCuadre' ));
  if(get('frmContenido.casoDeUso')=='modificar'){
		set('frmContenido.conectorAction', 'LPModificarGrupo');
  }else{
		set('frmContenido.conectorAction', 'LPCrearGrupo');
  }
  enviaSICC('frmContenido');
}

// ------------------------------------------------------------------------------------------------------------------------------------------------
function arrayComponentes(){
		var arr = new Array();
		arr[arr.length]= new Array("cbIndicadorCuadre","");
		arr[arr.length]= new Array("txtFactorCuadre","");      
		arr[arr.length]= new Array("Buscar","BOTONXY");
								
		return arr;
}

// ------------------------------------------------------------------------------------------------------------------------------------------------
 function tabGenerico(nombreComp, tipotab){       

	var arr = arrayComponentes();
	var tabular = false;
	var nombreFormulario = getFormularioSICC();
	var j = 0;
	var k = arr.length;
	if (tipotab != "sh") {
		 j = j-1;                
		 k = k-1;
	}

	while(j<k){
		 var t;
		 if(tipotab == "sh"){
			k--;
			t = k;
		 } else{
			j++;
			t = j;                  
		 }
			
		 var nombre = arr[t][0];
		 var tipo = arr[t][1];
		 if (tabular==false){
			if (nombreComp==nombre){
				 tabular=true;
				 if (tipotab == "sh"){
					if (k==0) k= arr.length;
				 } else {
					if ((j+1)==arr.length)  j = -1;
				 }
			}                
		 } else {
			try {
			  var name = nombreFormulario+"."+nombre;
			  if (tipo=="BOTONXY"){
				  focalizaBotonHTML_XY(nombre);
			  } else if (tipo=="BOTON") {
				  focalizaBotonHTML("botonContenido",nombre)
			  } else {
				  focaliza(name);
			  }
			  return;
			} catch (e) {
			  if (tipotab == "sh") {if (k==0) k= arr.length;} else 
			  {if ((j+1)==arr.length)  j = -1;}                    
			}
		 }
	}
 }

// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// Añadida por ssantana, 5/10/2005
// Por cambio GCC-PRE-001.
 function accionModificarProducto() {

	 listado1.actualizaDat();
	 
	 var casoDeUso = get('frmContenido.casoDeUso');
	 var datosLista = listado1.datos;
 	 var codSeleccionados = listado1.codSeleccionados();

	 if ( codSeleccionados.length == 0) {
			GestionarMensaje("PRE0025", null, null, null);   // Debe seleccionar un producto.
	 } else {
		  set('frmContenido.accion', 'Modificar producto');
 		  if ( casoDeUso =='modificar' ) {
				 set('frmContenido.conectorAction', 'LPModificarGrupo');
				 set('frmContenido.hidCodSeleccionadosLE', '[' + codSeleccionados + ']');
 				 //alert("codigos Seleccionados: " + get('frmContenido.hidCodSeleccionadosLE') );
		  } else {
				 set('frmContenido.conectorAction', 'LPCrearGrupo');
		  }
 		  enviarFormulario();
	 }
 }
 
// Agregado por SICC20070316 - Rafael Romero - 20/07/2007
function accionConsultarProducto(){
    listado1.actualizaDat();
    var numSelec = listado1.numSelecc();
    if ( numSelec < 1 ) {
        GestionarMensaje("PRE0025", null, null, null);   // Debe seleccionar un producto.
    } else {
        var codSeleccionados = listado1.codSeleccionados();
        var arrayDatos = obtieneLineasSeleccionadas(codSeleccionados, 'listado1'); 
        var cadenaLista = serializaLineasDatos(arrayDatos);
        var obj = new Object();
        obj.hidCodSeleccionadosLE = "[" + codSeleccionados + "]";
        obj.hidListaEditable =  cadenaLista;
        //set('frmContenido.conectorAction', 'LPModificarGrupo');
        mostrarModalSICC('LPModificarOferta','Consultar producto',obj,795,495);
    }
}

function obtieneLineasSeleccionadas(codSeleccionados, nombreLista) {
	// Recibe un array de codigos, y a partir de ellos, retorna un array con el contenido
	// de cada línea que matchea con esos codigos.

	eval(nombreLista + ".actualizaDat();");

	var datosLista = eval(nombreLista + ".datos;");
	var longLista = datosLista.length;
	var cantCodigos = codSeleccionados.length; 
	var arrayRetorno = new Array(); 
	var match = false; 

	for ( var i = 0; i < cantCodigos; i++ )
	{
		var codigoABuscar = codSeleccionados[i];
		match = false;

		for ( var j = 0; (j < longLista) && (!match); j++)
		{
			var codigoLista = datosLista[j][0]; 
			//if ( parseInt(codigoABuscar, 10) == parseInt(codigoLista, 10) )	// Comentado por HRCS
			if ( codigoABuscar == codigoLista )	// Modificado por HRCS - Fecha 22/03/2007 - Incidencia Sicc20070106
			{
				// Match. tomo la fila y la añado al nuevo array. 
				var fila = datosLista[j]; 
				arrayRetorno[arrayRetorno.length]  = fila;
				match = true;
			}
		} // Fin for j (recorrido de datos de Lista);
	} // Fin for i ( recorrido de codigos a buscar.
	return arrayRetorno;
}

  function serializaLineasDatos(arrayDatos) {
		// Arma una cadena serializando los datos del array recibido por parametro. 
		// Se usa "!" para separar los campos individuales, y "@" para separar las lineas. 
		// Nota: arrayDatos es un array donde cada elemento es un subArray.

		var cadenaSerializada = "[";

		// Defino los separadores. 
		var sepCampos = '!';
		var sepLineas = '@';
		var longArray = arrayDatos.length;

		// Por cada linea de la listaEditable. 
		for (var i = 0; i < longArray; i++) {
				// Tomamos la Linea. 
				var linea = arrayDatos[i]; 
				//alert("Linea " + i + ": " + linea);

				// Nos fijamos si es la primer cadena. Si no es así, le agregamos un separador de Linea a la 
				// cadena. 
				if ( i != 0) {
					 cadenaSerializada = cadenaSerializada + sepLineas;
				}

				// Por cada elemento de la linea. 
				for (var j = 0; j < linea.length; j++ ) {
					 // Tomamos el elemento. 
					 var elemento = linea[j];

					 // Nos fijamos si es el primer elemento. Si no es así, le agregamos un separador de Campos a la 
					 // cadena. 
					 if ( j != 0 ) {
					     cadenaSerializada = cadenaSerializada + sepCampos;
					 }
					 // Ahora añadimos el elemento que corresponde. 
					 if (elemento == "") { 
					     cadenaSerializada = cadenaSerializada + " ";
					 } else { 
					     cadenaSerializada = cadenaSerializada + elemento;
					 }
				} // Fin For j 
		} // Fin For i 

		cadenaSerializada = cadenaSerializada + "]";

		//alert("cadenaSerializada: " + cadenaSerializada);
		return cadenaSerializada;

  }

    // Agregado por SICC20070316 - Rafael Romero - 20/07/2007
    function fVolver(){
        window.close();
    }
    // Fin agregado SICC20070316
    