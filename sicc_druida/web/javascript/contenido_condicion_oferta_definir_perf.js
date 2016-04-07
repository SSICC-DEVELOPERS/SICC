var formName = 'frmContenido.';

//Matriz utilizada para insertar
//en la lista lineas de condicion
var matrizLineasCondicion = new Array();

//Contador utilizado para diferenciar
//los registros ingresados en la lista
//lineas de condicion
var contadorLineasCondicion = 0;

//Contador para el campo NUM_COND
//de la tabla PRE_PROMO
var numeroCondicion;

function foco2(opcion){
	if(opcion==1){
		if (get('frmContenido.casoDeUso') == "Modificar Condicion")
			focaliza("frmContenido.cbIndicadorCuadre");
		else focalizaBotonHTML('botonContenido','SalirCondicion');
	}
	if(opcion==2){
		if (get('frmContenido.casoDeUso') == "Modificar Condicion")
			focaliza("frmContenido.checkExcluir2");
		else focalizaBotonHTML('botonContenido','SalirCondicion');
	}
}

function fVolver() {
	window.close();
}

function mostrarMensajeNumerico(campo){
	var msg = sicc_obtenerDescripcion(campo);
    focaliza("frmContenido."+campo);
    cdos_mostrarAlert(GestionarMensaje("000000000000100" ,  "\""+msg+"\""));
}
    
function onLoadPag() {
	configurarMenuSecundario("frmContenido");    

	btnProxy(2, '1');
	btnProxy(3, '0');
	btnProxy(7, '0');
	btnProxy(8, '0');
	btnProxy(9, '0');
	
	//Agregado - cambios performance
	dtoOferta = window.dialogArguments.parametros.dtoOferta;

	if(dtoOferta.promocion!=null&&dtoOferta.promocion.length!=null){
		numeroCondicion = dtoOferta.promocion.length;
	}
	else {
		numeroCondicion = 0;
	}
	//fin - Agregado - cambios performance

    DrdEnsanchaConMargenDcho('listado1',22);
    DrdEnsanchaConMargenDcho('listado2',22);
    DrdEnsanchaConMargenDcho('listado3',22);
    eval (ON_RSZ);  
    varNoLimpiarSICC=true;

	if (get('frmContenido.casoDeUso') == "Modificar Condicion"){
		document.all["SalirCondicionDiv"].style.visibility='hidden';
		btnProxy(7,"0");
		btnProxy(8,"0");
		btnProxy(9,"0");
    } 

    focaliza('frmContenido.cbIndicadorCuadre','');

    set('frmContenido.cbIndicadorCuadre', get('frmContenido.hidIndicadorCuadre'));
    set('frmContenido.cbCatalogo', get('frmContenido.hidDesCatalogo'));    
    set('frmContenido.txtPaginaDesde', get('frmContenido.hidPaginaDesde'));
    set('frmContenido.txtPaginaHasta',get('frmContenido.hidPaginaHasta'));
    set('frmContenido.txtFactorCuadre',get('frmContenido.hidFactorCuadre'));
    
    checked= get(formName + 'hidcheckExcluirPagina')==""?"N":get(formName + 'hidcheckExcluirPagina');
    set(formName + 'checkExcluirPagina',checked);
    checked= get(formName + 'hidcheckExcluirLineaProd')==""?"N":get(formName + 'hidcheckExcluirLineaProd');
    set(formName + 'checkExcluir1',checked);
    checked= get(formName + 'hidcheckExcluirProducto')==""?"N":get(formName + 'hidcheckExcluirProducto');
    set(formName + 'checkExcluir2',checked);

	inicializarCombos();    
}

function inicializarCombos(){
	array = new Array();
    array[0] = get('frmContenido.hOidCatalogo');
    set('frmContenido.cbCatalogo',array);

    if (get('frmContenido.hidHabilitaCatalogo')=='N'){
		accion('frmContenido.cbCatalogo','.disabled=true');
    }
	else {
		accion('frmContenido.cbCatalogo','.disabled=false');
    }

    array = new Array();
    array[0] = get('frmContenido.hidIndicadorCuadre');
    set('frmContenido.cbIndicadorCuadre',array);
}

/*function buscarLineaProductos()   {
	//Tomo los valores de los controles
    setMV('frmContenido.cbIndicadorCuadre','N');
    setMV('frmContenido.txtFactorCuadre','N');
    setMV('frmContenido.cbCatalogo','N');
    TomarDatosPantalla();       
    set('frmContenido.accion','Buscar lineas productos');
    enviaSICC('frmContenido');
}*/

//Cambios por performance
function buscarLineaProductos()   {
	//1° - Se levanta la pantalla modal
	var parametros = new Object();
    var lineasProductos = mostrarModalSICC("LPSeleccionarLineasProductosPerf","", parametros,800,600);

    if(lineasProductos != undefined){
		//2° - Con los datos de lineas de productos de la modal se ingresan 
		//los registros seleccionados a la primer lista	
		listado1.actualizaDat();
		var datos = listado1.datos;

		for(var i=0; i<lineasProductos.length; i++) {
			var existe = "false";

			for(var j=0; j<datos.length; j++) {
				if(datos[j][0] == lineasProductos[i][0]) {
					existe = "true";
				}
			}

			if(existe == "false") {
				datos[datos.length] = lineasProductos[i];
				listado1.setDatos(datos);
			}

		}

		listado1.repintaDat();	
	}
}

/*function TomarDatosPantalla(){
	set('frmContenido.hOidCatalogo',get('frmContenido.cbCatalogo','V'));
    set('frmContenido.hidDesCatalogo',get('frmContenido.cbCatalogo','T'));
    set('frmContenido.hidIndicadorCuadre',get('frmContenido.cbIndicadorCuadre','V'));
    set('frmContenido.hidFactorCuadre',get('frmContenido.txtFactorCuadre'));
    set('frmContenido.hidPaginaDesde', get('frmContenido.txtPaginaDesde'));
    set('frmContenido.hidPaginaHasta', get('frmContenido.txtPaginaHasta'));        
    set('frmContenido.hidcheckExcluirPagina', get('frmContenido.checkExcluirPagina'));
    set('frmContenido.hidcheckExcluirLineaProd', get('frmContenido.checkExcluir1'));
    set('frmContenido.hidcheckExcluirProducto', get('frmContenido.checkExcluir2'));
}*/

/*function buscarProducto()   {
	//incidencia 10341 (obligat campo por incoherencia)
    if(!sicc_validaciones_generales("grgral")){
		return false;
    }          
    
	setMV('frmContenido.cbIndicadorCuadre','N');
    setMV('frmContenido.txtFactorCuadre','N');
    setMV('frmContenido.cbCatalogo','N');
    TomarDatosPantalla();
    set('frmContenido.accion','Buscar producto');
    enviaSICC('frmContenido');
}*/

//Cambios por performance
function buscarProducto()   {
	//incidencia 10341 (obligat campo por incoherencia)
    if(!sicc_validaciones_generales("grgral")){
		return false;
    }         

	//1° - Se levanta la pantalla modal
	var parametros = new Object();
	parametros.oidCatalogo = get('frmContenido.cbCatalogo');
	parametros.descripcionCatalogo = get('frmContenido.cbCatalogo','T');
	parametros.multiseleccion = "true";
	parametros.mostrarValoresAdicionales = "false";	
	parametros.volverLPBuscarProducto = "";

    var productos = mostrarModalSICC("LPBuscarProductoPerf","", parametros,1150,800);

	if(productos!=undefined) {	
		listado2.actualizaDat();
		var datos = listado2.datos;

		for(var i=0; i<productos.length; i++) {
			var existe = "false";

			for(var j=0; j<datos.length; j++) {
				if(datos[j][0] == productos[i][0]) {
					existe = "true";
				}
			}

			if(existe == "false") {
				datos[datos.length] = productos[i];
				listado2.setDatos(datos);
			}
		}

		listado2.repintaDat();
	}
}

function fBorrar(){
	if (listado1.numSelecc() > 0) {
		accionEliminarLineasProductos();
        return true;   
    }        
    if (listado2.numSelecc() > 0){
		accionEliminarProductos();
        return true;
    }                
    if (listado3.numSelecc() > 0){
		accionEliminarLineasCondicion();
        return true;
    }
}

/*function accionEliminarLineasProductos (){
	setMV('frmContenido.cbIndicadorCuadre','N');
    setMV('frmContenido.txtFactorCuadre','N');
    setMV('frmContenido.cbCatalogo','N');
    //Comprobar que se ha seleccionado al menos una linea 
    //Si no, muestra el mensaje PRE-0013 
    if (listado1.numSelecc() > 0) {
	    var strV;
        strV = tomarInfoListaProductos( listado1 );
        set('frmContenido.hLineaProductosSeleccionados', strV);
        set('frmContenido.accion','Eliminar lineas producto');
        enviaSICC('frmContenido');
    }
    else
	    GestionarMensaje('13');
}*/

//cambios por performance
function accionEliminarLineasProductos(){
    if (listado1.numSelecc() > 0) {
		var array = listado1.codSeleccionados();
		var datos = listado1.datos;
		var datosNuevos = new Array();
		var f = 0;

		for(var i=0; i<datos.length; i++) {
			var existe = "false";

			for(var j=0; j<array.length; j++) {
				if(datos[i][0]==array[j]) {
					existe = "true";
				}
			}

			if(existe == "false") {
				datosNuevos[f] = datos[i];
				f++;
			}
		}

		listado1.actualizaDat();
		listado1.setDatos(datosNuevos);
		listado1.repintaDat();
	}
    else
	    GestionarMensaje('13');
}

/*function accionEliminarProductos(){
	setMV('frmContenido.cbIndicadorCuadre','N');
    setMV('frmContenido.txtFactorCuadre','N');
    setMV('frmContenido.cbCatalogo','N'); 
    //Comprobar que se ha seleccionado al menos una linea 
    //Si no, muestra el mensaje PRE-0013 
    if (listado2.numSelecc() > 0) {
	    var strV;
        strV = tomarInfoListaProductos( listado2 );
        set('frmContenido.hProductosSeleccionados', strV);
        set('frmContenido.accion','Eliminar productos');
        enviaSICC('frmContenido');
    }
    else
	    GestionarMensaje('13');
}*/

//Cambios por performance
function accionEliminarProductos(){
    if (listado2.numSelecc() > 0) {
		var array = listado2.codSeleccionados();
		var datos = listado2.datos;
		var datosNuevos = new Array();
		var f = 0;

		for(var i=0; i<datos.length; i++) {
			var existe = "false";

			for(var j=0; j<array.length; j++) {
				if(datos[i][0]==array[j]) {
					existe = "true";
				}
			}

			if(existe == "false") {
				datosNuevos[f] = datos[i];
				f++;
			}
		}

		listado2.actualizaDat();
		listado2.setDatos(datosNuevos);
		listado2.repintaDat();		
    }
    else
	    GestionarMensaje('13');
}

/*function accionEliminarLineasCondicion(){
	setMV('frmContenido.cbCatalogo','N');
    setMV('frmContenido.cbIndicadorCuadre','N'); 
    setMV('frmContenido.txtFactorCuadre','N'); 	        
    //Comprobar que se ha seleccionado al menos una linea 
    //Si no, muestra el mensaje PRE-0013 
    if (listado3.numSelecc() > 0) {
		var strV;
        strV = tomarInfoListaProductos( listado3 );
        setMV('frmContenido.cbIndicadorCuadre','N'); 
        setMV('frmContenido.txtFactorCuadre','N'); 
        set('frmContenido.hLineasCondicionSeleccionadas', strV);
        set('frmContenido.accion','Eliminar lineas condicion');
        enviaSICC('frmContenido');
    }
	else GestionarMensaje('13');
} */

function accionEliminarLineasCondicion(){
    if (listado3.numSelecc() > 0) {
		var array = listado3.codSeleccionados();		
		var k = 0;

		//Actualizando matriz de javascript
		var nuevaMatrizLineasCondicion = new Array();		 

		for(var i=0; i<matrizLineasCondicion.length; i++) {
			var existe = "false";

			for(var j=0; j<array.length; j++) {
				if(matrizLineasCondicion[i][0]==array[j]) {
					existe = "true";
				}
			}
			
			if(existe == "false") {
				//Borrar
				nuevaMatrizLineasCondicion[k] = matrizLineasCondicion[i];
				k++;
			}
		}

		matrizLineasCondicion = new Array();

		for(var i=0; i<nuevaMatrizLineasCondicion.length; i++) {
			matrizLineasCondicion[i] = nuevaMatrizLineasCondicion[i];

		}

		//Borrando de la lista
		var datos = listado3.datos;
		var datosNuevos = new Array();
		var f = 0;

		for(var i=0; i<datos.length; i++) {
			var existe = "false";

			for(var j=0; j<array.length; j++) {
				if(datos[i][0]==array[j]) {
					existe = "true";
				}
			}

			if(existe == "false") {
				datosNuevos[f] = datos[i];
				f++;
			}
		}

		listado3.actualizaDat();
		listado3.setDatos(datosNuevos);
		listado3.repintaDat();				
    }
	else GestionarMensaje('13');
}

/*function accionAniadirCondicion(){
	setMV('frmContenido.cbIndicadorCuadre','N');
    setMV('frmContenido.txtFactorCuadre','N');

                    if (get('frmContenido.txtPaginaHasta')!='')
                    {		  
                             if(!sicc_validaciones_generales("nros")){
                                      return false;
                             }
                    }
                    if (get('frmContenido.txtPaginaHasta')!=''&&get('frmContenido.txtPaginaDesde')=='')
                    {		  
                             if(!sicc_validaciones_generales("grpags")){
                                      return false;
                             }
                    }
                    if (get('frmContenido.txtPaginaDesde')!='')
                    {		  
                             if(!sicc_validaciones_generales("grpags")){
                                      return false;
                             }
                    }
           if(!sicc_validaciones_generales("grgral")){
           return false;
           }
           
           if((listado1.datos.length <= 0) && 
              (listado2.datos.length <= 0) && 
              (get('frmContenido.txtPaginaDesde')=='')){
              //Hay que mostrar el mensaje de que debo definir alguna condicion.
              GestionarMensaje('220');
           } else {
              //=> puedo aniadir
              
             set('frmContenido.hidIndicadorCuadre',get('frmContenido.cbIndicadorCuadre','V'));
             set('frmContenido.hidFactorCuadre',get('frmContenido.txtFactorCuadre'));
             
             set('frmContenido.hidcheckExcluirPagina', get('frmContenido.checkExcluirPagina'));
             set('frmContenido.hOidCatalogo',get('frmContenido.cbCatalogo','V'));
             set('frmContenido.hidDesCatalogo', get('frmContenido.cbCatalogo','T'));
             set('frmContenido.hidPaginaDesde', get('frmContenido.txtPaginaDesde'));
             set('frmContenido.hidPaginaHasta', get('frmContenido.txtPaginaHasta'));
             
             set('frmContenido.hidcheckExcluirLineaProd', get('frmContenido.checkExcluir1'));
             marcaSeleccion(listado1);
             strV = tomarInfoListaProductos( listado1 );
             set('frmContenido.hLineaProductosSeleccionados', strV);


             set('frmContenido.hidcheckExcluirProducto', get('frmContenido.checkExcluir2'));
             marcaSeleccion(listado2);
             strV =  tomarInfoListaProductos( listado2 );
             set('frmContenido.hProductosSeleccionados', strV);

             set('frmContenido.accion','Anadir condicion');
             enviaSICC('frmContenido');
           }
    }*/

//cambios por performance
function accionAniadirCondicion(){
	setMV('frmContenido.cbIndicadorCuadre','N');
    setMV('frmContenido.txtFactorCuadre','N');
          
	if (get('frmContenido.txtPaginaHasta')!='')  {		  
	  if(!sicc_validaciones_generales("nros")){
		  return false;
	  }
    }

    if (get('frmContenido.txtPaginaHasta')!=''&&get('frmContenido.txtPaginaDesde')=='')  {		  
	  if(!sicc_validaciones_generales("grpags")){
		  return false;
	  }
	}

	if (get('frmContenido.txtPaginaDesde')!='')  {		  
		if(!sicc_validaciones_generales("grpags")){
			return false;
		}
	}

    if(!sicc_validaciones_generales("grgral")){
		return false;
    }
          
    if((listado1.datos.length <= 0) && 
		(listado2.datos.length <= 0) && 
        (get('frmContenido.txtPaginaDesde')=='')){
			//Hay que mostrar el mensaje de que debo definir alguna condicion.
            GestionarMensaje('220');
    }
	else {             
		//Estos tres metodos insertan datos
		//en una matriz global de javascript
		insertarSegunPaginaDesde();
		insertarSegunLineasProductos();
		insertarSegunProductos();		

		//La matriz con valores se utiliza
		//para insertar registros en la lista 
		//lineas condicion
		insertarLineasCondicion();

		//Limpiando despues de añadir 
		set("frmContenido.txtPaginaDesde", "");  
		set("frmContenido.txtPaginaHasta", "");  
		set("frmContenido.checkExcluirPagina", "N");  
		set("frmContenido.checkExcluir1", "N");  
		set("frmContenido.checkExcluir2", "N");  	
		set("frmContenido.cbCatalogo", "");  
   }
}

function actualizarContadorLineasCondicion() {
	contadorLineasCondicion++;
}

function insertarSegunPaginaDesde() {
	/*
	0 - oidLineaPromocion;
	1 - oidCatalogo;
	2 - descripcionCatalogo;
    3 - tipoRango;
	4 - numeroRangoInterno;
    5 - indicadorExclusion;
    6 - valorDesde;
    7 - valorHasta;
    8 - descripcionLineaProducto;
	9 - descripcionProducto;
    10 - codigoProducto;
	11 - codigoLineaProducto;
    12 - tipoOperacion;//[1]
	*/

	if(get('frmContenido.txtPaginaDesde')!="") {
		var fila = new Array();
		actualizarContadorLineasCondicion();	
		
		fila[0] = contadorLineasCondicion;
		fila[1] = get('frmContenido.cbCatalogo','V').toString();
		fila[2] = get('frmContenido.cbCatalogo','T').toString();
		fila[3] = "R";
		fila[4] = "";

		if(get('frmContenido.checkExcluirPagina')=="S") {
			fila[5] = "true";
		}
		else {
			fila[5] = "false";
		}

		fila[6] = get('frmContenido.txtPaginaDesde');
		
		if(get('frmContenido.txtPaginaHasta')!="") {
			fila[7] = get('frmContenido.txtPaginaHasta');
		}
		else {
			fila[7] = get('frmContenido.txtPaginaDesde');
		}
		
		fila[8] = "";
		fila[9] = "";
		fila[10] = "";
		fila[11] = "";
		fila[12] = "";

		matrizLineasCondicion[matrizLineasCondicion.length] = fila;
	}
}

function insertarSegunLineasProductos() {
	/*
	0 - oidLineaPromocion;
	1 - oidCatalogo;
	2 - descripcionCatalogo;
    3 - tipoRango;
	4 - numeroRangoInterno;
    5 - indicadorExclusion;
    6 - valorDesde;
    7 - valorHasta;
    8 - descripcionLineaProducto;
	9 - descripcionProducto;
    10 - codigoProducto;
	11 - codigoLineaProducto;
    12 - tipoOperacion;//[1]
	*/

	var datos = listado1.datos;

	for(var i=0; i<datos.length; i++) {
		var fila = new Array();
		actualizarContadorLineasCondicion();	

		fila[0] = contadorLineasCondicion;
		fila[1] = get('frmContenido.cbCatalogo','V').toString();
		fila[2] = get('frmContenido.cbCatalogo','T').toString();
		fila[3] = "L";
		fila[4] = "";

		if(get('frmContenido.checkExcluir1')=="S") {
			fila[5] = "true";
		}
		else {
			fila[5] = "false";
		}

		fila[6] = datos[i][0];		
		fila[7] = "";		
		fila[8] = datos[i][2];
		fila[9] = "";
		fila[10] = "";
		fila[11] = datos[i][1];
		fila[12] = "";

		matrizLineasCondicion[matrizLineasCondicion.length] = fila;
	}
}

function insertarSegunProductos() {
	/*
	0 - oidLineaPromocion;
	1 - oidCatalogo;
	2 - descripcionCatalogo;
    3 - tipoRango;
	4 - numeroRangoInterno;
    5 - indicadorExclusion;
    6 - valorDesde;
    7 - valorHasta;
    8 - descripcionLineaProducto;
	9 - descripcionProducto;
    10 - codigoProducto;
	11 - codigoLineaProducto;
    12 - tipoOperacion;//[1]
	*/

	var datos = listado2.datos;

	for(var i=0; i<datos.length; i++) {
		var fila = new Array();
		actualizarContadorLineasCondicion();	

		fila[0] = contadorLineasCondicion;
		fila[1] = get('frmContenido.cbCatalogo','V').toString();
		fila[2] = get('frmContenido.cbCatalogo','T').toString();
		fila[3] = "P";
		fila[4] = "";

		if(get('frmContenido.checkExcluir2')=="S") {
			fila[5] = "true";
		}
		else {
			fila[5] = "false";
		}

		fila[6] = datos[i][0];		
		fila[7] = "";		
		fila[8] = "";
		fila[9] = datos[i][2];
		fila[10] = datos[i][1];
		fila[11] = "";
		fila[12] = "";

		matrizLineasCondicion[matrizLineasCondicion.length] = fila;
	}
}

function insertarLineasCondicion() {
	//Se vacia la lista lineas de condicion
	var arrayVacio = new Array();

	listado3.actualizaDat();
	listado3.setDatos(arrayVacio);
	listado3.repintaDat();

	var datos = listado3.datos;

	//Se inserta la matriz en la lista lineas de condicion
	for(var i=0; i<matrizLineasCondicion.length; i++) {
		var registroInsertar = new Array();

		registroInsertar[0] = matrizLineasCondicion[i][0];
		registroInsertar[1] = matrizLineasCondicion[i][2];

		//En la lista no se debe mostrar valor en las
		//columnas pagina desde y pagina hasta si se inserta
		//mediante las listas lineas productos o productos
		if(matrizLineasCondicion[i][3]!="R") {
			registroInsertar[2] = "";
			registroInsertar[3] = "";
		}
		else {
			registroInsertar[2] = matrizLineasCondicion[i][6];
			registroInsertar[3] = matrizLineasCondicion[i][7];
		}

		registroInsertar[4] = matrizLineasCondicion[i][8];
		registroInsertar[5] = matrizLineasCondicion[i][10];
		registroInsertar[6] = matrizLineasCondicion[i][9];

		if(matrizLineasCondicion[i][5]=="true") {
			registroInsertar[7] = "SI";
		}
		else {
			registroInsertar[7] = "NO";
		}


		datos[datos.length] = registroInsertar;
		listado3.setDatos(datos);
	}

	listado3.repintaDat();

	//Se vacia la lista lineas productos
	var arrayVacioLineasProductos = new Array();
	listado1.actualizaDat();
	listado1.setDatos(arrayVacioLineasProductos);
	listado1.repintaDat();

	//Se vacia la lista productos
	var arrayVacioProductos = new Array();
	listado2.actualizaDat();
	listado2.setDatos(arrayVacioProductos);
	listado2.repintaDat();
}

/*function accionSalirDefinirCondicion(){
	//Se le saca la obligatoriedad a los campos obligatorios por maqueta
    setMV('frmContenido.cbCatalogo','N'); 
    setMV('frmContenido.cbIndicadorCuadre','N'); 
    setMV('frmContenido.txtFactorCuadre','N'); 	
    set('frmContenido.accion','Finalizar');
    enviaSICC('frmContenido');
}*/

//Cambios por performance
function accionSalirDefinirCondicion (){
	window.close();
}

function fGuardar(){
	accionGuardar();
}

/*function accionGuardar(){
	setMV('frmContenido.cbCatalogo','N'); 
    if(!sicc_validaciones_generales("grinicial")){
		return false;
    }
    
	var validar = esNumero(get('frmContenido.txtFactorCuadre'));
    if( validar != 'OK'){
		mostrarMensajeNumerico("txtFactorCuadre");
        return false;
    }          
    
	if( (fValidarCOMBO('frmContenido.cbIndicadorCuadre')) &&
		(fValidarCTEXT('frmContenido.txtFactorCuadre')) &&
        (listado3.datos.length >0 )){

		set('frmContenido.hidFactorCuadre',get('frmContenido.txtFactorCuadre'));
        set('frmContenido.hidIndicadorCuadre',get('frmContenido.cbIndicadorCuadre','V'));
        set('frmContenido.hidDesIndCuadre',get('frmContenido.cbIndicadorCuadre','T'));                    
        set('frmContenido.accion','Guardar');
        enviaSICC('frmContenido');
    }
	else GestionarMensaje('220');
}*/

//En esta funcion deberiamos guardar todos los datos
//en el dtooferta y limpiar los componentes de la pagina
function accionGuardar(){
	setMV('frmContenido.cbCatalogo','N'); 
    if(!sicc_validaciones_generales("grinicial")){
		return false;
    }
	if (get('frmContenido.cbIndicadorCuadre','V')=='1') {//Por Unidades
		if(!sicc_validaciones_generales("grinicialfc")){
			return false;
		}
	} else {//Por Monto se permite decimales
		if(!sicc_validaciones_generales("grinicialfcd")){
			return false;
		}
	}
  
	if(listado3.datos.length >0){

		if(dtoOferta.promocion!=null&&dtoOferta.promocion.length!=null){
			posicion = dtoOferta.promocion.length;
		}
		else {
			posicion = 0;
			dtoOferta.promocion = new Array();			
		}
		
		dtoOferta.promocion[posicion]= new Object();

		//1° Rellenando DTOPromocion de DTOOferta
		dtoOferta.promocion[posicion].oidPromocion = null;
		numeroCondicion++;
	    dtoOferta.promocion[posicion].numeroCondicion = numeroCondicion;
		dtoOferta.promocion[posicion].oidIndicadorCuadre = get('frmContenido.cbIndicadorCuadre','V').toString();
	    dtoOferta.promocion[posicion].descripcionIndicadorCuadre = get('frmContenido.cbIndicadorCuadre','T').toString();
	    dtoOferta.promocion[posicion].factorCuadre = get('frmContenido.txtFactorCuadre');
 	    dtoOferta.promocion[posicion].tipoOperacion = "";
 	    
		//Del DTOPromocion queda un atributo que es el Vector lineaPromocion
		//que se rellenara mediante los datos de la lista lineas promocion
		if(dtoOferta.promocion[posicion].lineaPromocion==null||
			dtoOferta.promocion[posicion].lineaPromocion.length==null){
			dtoOferta.promocion[posicion].lineaPromocion = new Array();			
		}

		for(var i=0; i<matrizLineasCondicion.length; i++) {
			dtoOferta.promocion[posicion].lineaPromocion[i]= new Object();

			dtoOferta.promocion[posicion].lineaPromocion[i].oidLineaPromocion = 
			matrizLineasCondicion[i][0];
			
			dtoOferta.promocion[posicion].lineaPromocion[i].oidCatalogo = 
			matrizLineasCondicion[i][1];
			
			dtoOferta.promocion[posicion].lineaPromocion[i].descripcionCatalogo =
			matrizLineasCondicion[i][2];
			
			dtoOferta.promocion[posicion].lineaPromocion[i].tipoRango =
			matrizLineasCondicion[i][3];
			
			dtoOferta.promocion[posicion].lineaPromocion[i].numeroRangoInterno = 
			matrizLineasCondicion[i][4];
			
			dtoOferta.promocion[posicion].lineaPromocion[i].indicadorExclusion = 
			matrizLineasCondicion[i][5];
			
			dtoOferta.promocion[posicion].lineaPromocion[i].valorDesde = 
			matrizLineasCondicion[i][6];
			
			dtoOferta.promocion[posicion].lineaPromocion[i].valorHasta = 
			matrizLineasCondicion[i][7];
			
			dtoOferta.promocion[posicion].lineaPromocion[i].descripcionLineaProducto = 
			matrizLineasCondicion[i][8];
			
			dtoOferta.promocion[posicion].lineaPromocion[i].descripcionProducto = 
			matrizLineasCondicion[i][9];
			
			dtoOferta.promocion[posicion].lineaPromocion[i].codigoProducto = 
			matrizLineasCondicion[i][10];
			
			dtoOferta.promocion[posicion].lineaPromocion[i].codigoLineaProducto = 
			matrizLineasCondicion[i][11];
			
			dtoOferta.promocion[posicion].lineaPromocion[i].tipoOperacion = 
			matrizLineasCondicion[i][12];
		}		
		
		limpiarComponentes();
    }
	else GestionarMensaje('220');
}

/*function fLimpiar(){
	if (get('frmContenido.casoDeUso') == "Modificar Condicion")
		setMV('frmContenido.cbCatalogo','N');

	setMV('frmContenido.cbIndicadorCuadre','N'); 
    setMV('frmContenido.txtFactorCuadre','N'); 	
        
    document.all.tags("INPUT").checkExcluirPagina[0].checked=false;
    document.all.tags("INPUT").checkExcluir1[0].checked=false;
    document.all.tags("INPUT").checkExcluir2[0].checked=false;
    focaliza('frmContenido.cbIndicadorCuadre','');
    set('frmContenido.accion','');
    enviaSICC('frmContenido');                
}*/

//cambios por performance
function fLimpiar(){
	if (get('frmContenido.casoDeUso') == "Modificar Condicion")
		setMV('frmContenido.cbCatalogo','N');

	limpiarComponentes();
}

function limpiarComponentes() {
	//Limpiando variables globles de javascript
	matrizLineasCondicion = new Array();

	//Limpiando cajas de texto
	set("frmContenido.txtFactorCuadre", "");  
	set("frmContenido.txtPaginaDesde", "");  
	set("frmContenido.txtPaginaHasta", "");  

	//Limpiando checkbox 
	set("frmContenido.checkExcluirPagina", "N");  
	set("frmContenido.checkExcluir1", "N");  
	set("frmContenido.checkExcluir2", "N");  	

	//Limpiando combos
	set("frmContenido.cbIndicadorCuadre", "");  
	set("frmContenido.cbCatalogo", "");  

	//Se vacia la lista lineas productos
	var arrayVacio1 = new Array();
	listado1.actualizaDat();
	listado1.setDatos(arrayVacio1);
	listado1.repintaDat();

	//Se vacia la lista productos
	var arrayVacio2 = new Array();
	listado2.actualizaDat();
	listado2.setDatos(arrayVacio2);
	listado2.repintaDat();

	//Se vacia la lista lineas condicion
	var arrayVacio3 = new Array();
	listado3.actualizaDat();
	listado3.setDatos(arrayVacio3);
	listado3.repintaDat();

	focaliza("frmContenido.cbIndicadorCuadre");
}