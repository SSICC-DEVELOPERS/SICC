function onLoadPag()   {
  
         //set("frmFormulario.oidCabecera", "2");
         //set("frmFormulario.oidPeriodo", "null");
         //set("frmFormulario.tipoProductoEstrategia", "null");
         configurarMenuSecundario("frmFormulario");
    DrdEnsanchaConMargenDcho('listado1',12);
    DrdEnsanchaConMargenDcho('listado2',12);
    
    eval (ON_RSZ);  

}

/*
function fVolver() {
	if (get('frmFormulario.accion')=='buscarProductoPrincipal') {
			set("frmFormulario.conectorAction", "LPSeleccionarMF");
			set("frmFormulario.accion", "");
			enviaSICC("frmFormulario");
	} else {
			set("frmFormulario.conectorAction", get("frmFormulario.UltimaLP"));	
			set("frmFormulario.accion", "productoPrincipalSeleccionado");
			enviaSICC("frmFormulario");
	}
}
*/



function muestraLista(ultima, rowset){
	var tamano = rowset.length;
    if (tamano > 0) {
        oculta('');
		btnProxy(1,'1');
		set('frmFormulario.hidHayDatos','S');
		focaliza('frmFormulario.txtCodigoVenta','');  		
		return true;
	} else {
		btnProxy(1,'0');
		oculta("none");
		set('frmFormulario.hidHayDatos','N');
		focaliza('frmFormulario.txtCodigoVenta','');  		
		return false;
	}	
}



function fnErrores()
{
                  onLoadPag();
                  oculta("none");

                  // Chequeo de errores.
                  var codigoError = get("frmFormulario.errCodigo");
                  var descError = get("frmFormulario.errDescripcion");

                  if ( codigoError != "" )
                  {
                           fMostrarMensajeError();
                           if ( get("frmFormulario.accion") == "aniadir")
                                    oculta("inline");

                           return;
                  }

				  focaliza('frmFormulario.txtCodigoVenta','');  

}

function buscar()
{
         
         oculta("none");
         limpiaSeleccionados();
         hacerPaginado();
}

function hacerPaginado()
{

         // Obtiene los valores para pasar al DTO
         var codVenta = get('frmFormulario.txtCodigoVenta');   // si no hay nada la caja de texto, trae "" (asi que no hay validacion). 
         var descProducto = get('frmFormulario.txtDescripcion');  // si no hay nada en descripcion, trae "" (asi no que no hay validacion).
         var oidCabecera =  get('frmFormulario.oidMatrizFacturacion');  // Deberia contener un valor desde la LP. 
         var oidPeriodo = get('frmFormulario.oidPeriodo');  // Puede venir con valor "null". 
         var tipoProductoEstrategia = get('frmFormulario.tipoProductoEstrategia');  // Puede venir con valor "null".
         var idioma = get("frmFormulario.idiomaSesion"); // Debe venir de la LP con un valor.

         var array = armarArray(codVenta, descProducto, oidPeriodo, tipoProductoEstrategia, oidCabecera, idioma);
         configurarPaginado(mipgndo,"PREBuscarProductosVenta", 
						"ConectorBuscarProductosVenta", "es.indra.sicc.dtos.pre.DTOEBuscarProductosVenta", array);

}

function eliminarSeleccion()
{
          // **********************************************************************
          //          Elimina un Producto de la lista temporal. 
          // **********************************************************************

          // 1. Chequea que se haya seleccionado un producto.
          //     Si no, muestra un mensaje de error.

          if ( listado2.numSelecc()== 0 )
          {
                  // alert("Debe seleccionar un elemento para eliminar");
				  GestionarMensaje('1227',null,null,null);
          } else
          {
                  listado2.eliminarSelecc();
          }

}

function agregarSeleccion()
{
         // *************************************************************************
         //	 Mueve un producto de la lista de seleccion a la lista temporal.
         // *************************************************************************

         // Si no hay ningun elemento seleccionado, tira un mensaje.
         var cant = listado1.numSelecc();   // Cantidad de elementos seleccionados en lista de Productos.
         var cantTemporal = listado2.codigos().length;  // Cantidad de elementos en lista Temporal.
         var toAdd = "|";
         var codigo = "";

         // PRIMERO chequea que, si solo se puede seleccionar un producto
         // para devolver, entonces la lista temporal no tenga ya un producto. 

         var cantElementosPermitidos = get("frmFormulario.cantElem");

         if ( (cantElementosPermitidos == "true") && (cantTemporal > 0) )
         {
                 // alert("Solo se puede devolver un elemento, y ya hay un elemento en la lista temporal");
					GestionarMensaje('1226',null,null,null);	

         } else
         {
                           if ( cant == 0){
                                 //   alert("Se debe seleccionar UN elemento");
								 GestionarMensaje('4',null,null,null);
									
						 }			
                           else
                           {
                        	   var accion = get("frmFormulario.accion");
                        	   //SE AGREGA VALIDACIONES ADICIONALES AL INGRESO DEL PRODUCTO DE LA OFERTA
                        	   if((accion == "buscarGrupoProductosRecuperacion") && (arguments.length == 0)) {
                        		   set('frmFormulario.oidMatrizCodigoAlternativo', listado1.codSeleccionados());
                        		
                        		   set("frmFormulario.conectorAction", "LPBuscarProductosVenta");
                        		   set('frmFormulario.accion', 'validarRecuperacion');
                        		   eval('frmFormulario').oculto = 'S';
                        		   enviaSICC('frmFormulario','','','N');
                        		   return;
                        	   }
                        	   
                                    // Primero obtiene el codigo del elemento seleccionado. 
                                    codigo = listado1.codSeleccionados();

                                    // Con ese codigo, toma los valores de las columnas para formar 
                                    // el valor a pasar a la lista temporal.

                                    toAdd = listado1.extraeDato (codigo, 0);
                                    toAdd = toAdd + "|" + listado1.extraeDato(codigo, 1);
									toAdd = toAdd + "|" + listado1.extraeDato(codigo, 2);

                                    // Ahora pasa a la lista temporal ese valor. 
                                    pasaListaTemporal( codigo, toAdd);

                           }
         }

         return cant;

}
         //var toAdd = get("frmFormulario.listado1");

function pasaListaTemporal(codigo, datos)
{
         // ****************************************************************************************
         // Recibe el "codigo", que usa para chequear que el mismo no se encuentre ya 
         // anteriormente (por si ya se ha pasado la fila)
         // En "datos" se pasa un par de valores, "codigoVenta | descripcion" 
         // Si el codigo a agregar no se encuentra en la lista temporal, lo agrega. 
         // ****************************************************************************************
         
         // 1. Obtiene los codigos ya existentes en la tabla temporal (TODOS)

         var codigosTemporal = listado2.codigos();

          // 2. Busca si hay coincidencia entre los codigos existentes en temporal y el codigo pasado.
         var match = rowMatch(codigo, codigosTemporal);

         // 3. Si no hay coincidencia, agrega una fila. 
         //     Si la hay, muestra un mensaje de error. 
         if (match)  // Hubo coincidencia
         {
                //  alert("El producto seleccionado ya se encuentra en la lista temporal");
				GestionarMensaje('1228',null,null,null);
				  
         } else
         {
                  datos = codigo + "|" + datos;  // Agrega el codigo al String de valores. 
                  var newRow = new Array();
                  newRow = datos.split("|");
                  listado2.insertar(newRow);
         }

}

function rowMatch(codigo, codigosTemporal)
{
                  // ****************************************************************************************
                  //      Recibe un codigo, y un array con codigos
                  //      Devuelve true si el codigo ya esta en el array, false en caso contrario
                  // ****************************************************************************************

                  var flag = false;
                  var i = 0;

                  while ( (i < codigosTemporal.length) && (flag == false) )
                  {
                           if ( codigo == codigosTemporal[i] )
                                    flag = true;	
                           i++;
                  }
                  return flag;

}


function chequeoCantidad()
{
         // *********************************************************************************************
         //  Chequea que la cantidad de productos en lista temporal no sea mayor a uno en 
         //  caso de que se pueda seleccionar tan solo 1. 
         // *********************************************************************************************

         var cant = get("frmFormulario.cantElem");

         var cantSeleccionada = get("frmFormulario.lstTemporal");
         //  ********** TESTING ***************
         //cant = "true";   // Un solo elemento
         //cant = "false"; // Mas de uno 
         //cantSeleccionada =2;
         // *************************************

         if ( cantSeleccionada == 0)
                  alert("Debe seleccionar al menos un elemento");
         else if ( cant == "true")  // Solo se puede seleccionar un elemento.
         {
                  if ( cantSeleccionada > 1 )
                           alert("Debe seleccionar SOLO 1 elemento");

         }

}



function oculta(valor)
{
         // Oculta las dos listas. 
         
         //document.all["capaTitulo"].style.display=valor;
    document.all["Cplistado1"].style.display=valor; 
    document.all["CpLin1listado1"].style.display=valor;
    document.all["CpLin2listado1"].style.display=valor;
    document.all["CpLin3listado1"].style.display=valor;
    document.all["CpLin4listado1"].style.display=valor;
         document.all["primera1Div"].style.display=valor; 
    document.all["ret1Div"].style.display=valor;
    document.all["separaDiv"].style.display=valor; 
    document.all["ava1Div"].style.display=valor; 
    document.all["btnAnadir"].style.display=valor; 

         //document.all["capaTitulo2"].style.display=valor;
    document.all["Cplistado2"].style.display=valor;
    document.all["CpLin1listado2"].style.display=valor;
    document.all["CpLin2listado2"].style.display=valor;
    document.all["CpLin3listado2"].style.display=valor;
    document.all["CpLin4listado2"].style.display=valor;
       //document.all["primera2Div"].style.display=valor; 
    //document.all["ret2Div"].style.display=valor; 
    //document.all["ava2Div"].style.display=valor; 
    document.all["btnEliminar"].style.display=valor; 

}

function prueba()
{

         set("frmFormulario.conectorAction", "LPBuscarProductosVenta");
         set("frmFormulario.accion", "aniadir");
         enviaSICC("frmFormulario");
}

function armarArray(codigoVenta, descripcionProducto, oidPeriodo, tipoProductoEstrategia, oidCabecera, idioma){
  var arrDatos = new Array();
  var i=0;

  //alert("FUNCION armarArray");

/*  alert("oidCabecera: " + oidCabecera);
  alert("oidPeriodo: " + oidPeriodo);
  alert("tipoProductoEstrategia: " + tipoProductoEstrategia);
  alert("codigoVenta: " + codigoVenta);
  alert("descripcionProducto: " + descripcionProducto);
  alert("idioma: " + idioma);*/

    

  if ( oidPeriodo == "null")
                  oidPeriodo = "";

  if ( tipoProductoEstrategia == "null")
                  tipoProductoEstrategia = "";

         arrDatos[i] = new Array("codigoVenta", codigoVenta);   
         i++;
         arrDatos[i] = new Array("descripcionProducto", descripcionProducto);
         i++;
         arrDatos[i] = new Array("oidPeriodo", oidPeriodo);
         i++;
         arrDatos[i] = new Array("tipoProductoEstrategia", tipoProductoEstrategia);
         i++;
  //arrDatos[i] = new Array("oidMatrizFacturacion",oidCabecera );
  arrDatos[i] = new Array("oidCabeceraMF",oidCabecera );
         i++;
         arrDatos[i] = new Array('oidIdioma', idioma );  

         return arrDatos;
}

function limpiaSeleccionados()
{
         // Funcion que deselecciona los codigos seleccionados.
         // Se usa para bypassear el error de javascript interno de la LISTA-EDITABLE.
         var longitud = listado1.codigos().length;

         for (var i = 0; i<longitud; i++)
                  listado1.desactiva(i);
}

function fGuardar()
{
         guardar();
}


function guardar()
{

         var codigos = listado2.codigos();
         var cadena = "";
		 var oidPerio = "";
         if (codigos.length == 0)
         {
				//       alert("No hay ningún elemento en la lista temporal");
				
				GestionarMensaje('1225',null,null,null);
         } else
         {

				  // 1. Construye la cadena, tomando los valores por cada fila.

                  for (var i =0; i<codigos.length ; i++) {
					//alert("codigo: " + codigos[i]);
					//alert("listado2.extraeDato(codigos[i], 0): " + listado2.extraeDato(codigos[i], 0) );
					//alert("listado2.extraeDato(codigos[i], 1): " + listado2.extraeDato(codigos[i], 1) );
					if ( i != 0)
						cadena = cadena + "|";

					// Añade Codigo. 
					cadena = cadena + codigos[i] + ",";
					// Añade Codigo de Venta. 
					codVenta = listado2.extraeDato(codigos[i], 0);

					// alert("codVenta"+codVenta);
					if (codVenta==""){
						codVenta=" ";
					}

					cadena = cadena + codVenta + ",";
					// Añade Descripcion
					desc = listado2.extraeDato(codigos[i], 1);
					cadena = cadena + desc + ",";
					oidPerio = listado2.extraeDato(codigos[i], 2);
					cadena = cadena + oidPerio;

				 }

              // 2. Setea la variable de formulario con la cadena, y llama a la LP con accion "aniadir"
              /*alert("oidPeriodo: " + get("frmFormulario.oidPeriodo") );
              alert("tipoProductoEstrategia: " + get("frmFormulario.tipoProductoEstrategia") );*/

              set("frmFormulario.descProd", get("frmFormulario.txtDescripcion") );
               set("frmFormulario.codVenta", get("frmFormulario.txtCodigoVenta") );
              set("frmFormulario.elementosSeleccionados", cadena);
               set("frmFormulario.conectorAction", "LPBuscarProductosVenta");
               set("frmFormulario.accion", "aniadir");
              if (get("frmFormulario.principalRecuperacion")=='S'){
                  set("frmFormulario.tipoProductoEstrategia","null");
              }/*else{
                  set("frmFormulario.tipoProductoEstrategia","null");
              }*/
              enviaSICC("frmFormulario");

         }

         return;
}

function fLimpiar()
{
         
}

function trim( inputString ) {
   if (typeof inputString != "string") { return inputString; }
   var retValue = inputString;
   var ch = retValue.substring(0, 1);
   while (ch == " ") {
      retValue = retValue.substring(1, retValue.length);
      ch = retValue.substring(0, 1);
   }
   ch = retValue.substring(retValue.length-1, retValue.length);
   while (ch == " ") { 
      retValue = retValue.substring(0, retValue.length-1);
      ch = retValue.substring(retValue.length-1, retValue.length);
   }
   while (retValue.indexOf("  ") != -1) {
      retValue = retValue.substring(0, retValue.indexOf("  ")) + retValue.substring(retValue.indexOf("  ")+1, retValue.length); 
   }
   return retValue; 
}


function focalizaTab(componente) {  
	if (componente==1){
		if(get('frmFormulario.hidHayDatos')=='S')
			focalizaBotonHTML_XY('btnAnadir');
		else if(get('frmFormulario.hidHayDatos')=='N')
			focaliza('frmFormulario.txtCodigoVenta','');  
	}else if (componente==2){
			focalizaBotonHTML_XY('btnEliminar');
	}else if (componente==3){
			focaliza('frmFormulario.txtCodigoVenta','');  
	}
}

function focalizaTabShift(componente) {    
    if (componente==1){
		if(get('frmFormulario.hidHayDatos')=='S')
			focalizaBotonHTML_XY('btnEliminar');
		else if(get('frmFormulario.hidHayDatos')=='N')
			focalizaBotonHTML('botonContenido' ,'btnBuscar');	
	}else if (componente==2){
			focalizaBotonHTML_XY('btnAnadir');
	}else if (componente==3){
			focalizaBotonHTML('botonContenido' ,'btnBuscar');	
	}
}

function mostrarValidaciones(mensaje){
	eval('frmFormulario').oculto = 'N';
	set('frmFormulario.accion', 'buscarGrupoProductosRecuperacion');
	
	if(mensaje == "") {
		agregarSeleccion('validaciones');
	} else {
		cdos_mostrarAlert(mensaje);
	}
}	
