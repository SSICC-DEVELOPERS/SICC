var listaGrupoClientes;
var listaSubtipos;
var listaClasificaciones;

function onLoadPag(){	
	configurarMenuSecundario("formulario");
	fMostrarMensajeError();
	listaGrupoClientes = get("formulario.listaGrupoClientes");
	listaSubtipos = get("formulario.listaSubtipos");

	var menu = get("formulario.opcionMenu");
	if(menu == "eliminar"){
		btnProxy(4, 1);
	}else{
		btnProxy(4, 0);
	}
	btnProxy(3, 1);
	btnProxy(5, 0);

	ocultarListaPaginada();
	document.getElementById("txtIdClsificacion").disabled = true;
	focaliza("formulario.cbGrupoCliente");
}

function ocultarListaPaginada() {
	DrdEnsanchaConMargenDcho('listado1',12);
	document.all["Cplistado1"].style.visibility = 'hidden';
	document.all["CpLin1listado1"].style.visibility = 'hidden';
	document.all["CpLin2listado1"].style.visibility = 'hidden';
	document.all["CpLin3listado1"].style.visibility = 'hidden';
	document.all["CpLin4listado1"].style.visibility = 'hidden';
	document.all["separaDiv"].style.visibility = 'hidden';
	document.all["primera1Div"].style.visibility = 'hidden';
	document.all["ret1Div"].style.visibility = 'hidden';
	document.all["ava1Div"].style.visibility = 'hidden';
    document.all["btnEliminarDiv"].style.visibility = 'hidden';
    document.all["btnDetalleDiv"].style.visibility = 'hidden';
	document.all["btnModificarDiv"].style.visibility = 'hidden';
	eval(ON_RSZ);  
}

function mostrarListaPaginada() {
	DrdEnsanchaConMargenDcho('listado1',12);
	document.all["Cplistado1"].style.visibility = 'visible';
	document.all["CpLin1listado1"].style.visibility = 'visible';
	document.all["CpLin2listado1"].style.visibility = 'visible';
	document.all["CpLin3listado1"].style.visibility = 'visible';
	document.all["CpLin4listado1"].style.visibility = 'visible';
	document.all["separaDiv"].style.visibility = 'visible';
	document.all["primera1Div"].style.visibility = 'visible';
	document.all["ret1Div"].style.visibility = 'visible';
	document.all["ava1Div"].style.visibility = 'visible';

	if(get("formulario.opcionMenu")=="consultar") {
	    document.all["btnEliminarDiv"].style.visibility = 'hidden';
		document.all["btnDetalleDiv"].style.visibility = 'visible';
		document.all["btnModificarDiv"].style.visibility = 'hidden';
	}
	else if(get("formulario.opcionMenu")=="eliminar") {
	    document.all["btnEliminarDiv"].style.visibility = 'visible';
		document.all["btnDetalleDiv"].style.visibility = 'hidden';
		document.all["btnModificarDiv"].style.visibility = 'hidden';
	}
	else if( get("formulario.opcionMenu") == "modificar" ){
		document.all["btnEliminarDiv"].style.visibility = 'hidden';
		document.all["btnDetalleDiv"].style.visibility = 'hidden';
		document.all["btnModificarDiv"].style.visibility = 'visible';
	}

	eval(ON_RSZ);  
}

function onChangeGrupoCliente() {
	var oidGrupoCliente = get("formulario.cbGrupoCliente");  

	if(oidGrupoCliente!="") {
		var filas = listaGrupoClientes.split('|');
		for(var i=0; i<filas.length; i++) {
			var campos = filas[i];
			var campo = campos.split(",");
			if(campo[0]==oidGrupoCliente) {
				set("formulario.txtIdClsificacion",campo[1]);
			}  		
		}		
	}
	else {
		set("formulario.txtIdClsificacion","");
	}
}

function parseaCombo(str, oid) {	
	var arrVacio = new Array();
	arrVacio[0] = "";
	arrVacio[1] = "";

	var arr = new Array();	
	arr[0] = arrVacio;

    var filas = str.split('|');
	var j=0;

	for(var i=0; i<filas.length; i++) {
		var campos = filas[i];
		var campo = campos.split(",");

		if(campo[1]==oid) {
			j++;
			arrIn = new Array();
		    arrIn[0] = campo[0];
			arrIn[1] = campo[2];                        
	        arr[j] = arrIn;   
		}   		
	}

    return arr;
}  

function onChangeTipoCliente() {
	var oidTipoCliente = get("formulario.cbTipoCliente");  
	var arrResultado = parseaCombo(listaSubtipos, oidTipoCliente);
	set_combo("formulario.cbSubTipoCliente", arrResultado);

	if(arrResultado.length<=1) {
		var arrVacio = new Array();
		arrVacio[0] = "";
		arrVacio[1] = "";

		var arr = new Array();	
		arr[0] = arrVacio;

		set_combo("formulario.cbTipoClsificacion", arr);
		set_combo("formulario.cbClasificacion", arr);
	}
}

function onChangeSubtipoCliente() {
	 var oidSubTipoCliente = get("formulario.cbSubTipoCliente");  

	 if(oidSubTipoCliente!="") {
		 set('formulario.conectorAction', 'LPMantenimientoParticipantesConcursoINCDetalle');
	     set('formulario.accion', 'recargaTipoClasificacion');
		 set('formulario.oidSubTipoCliente', oidSubTipoCliente);
		 eval('formulario').oculto = 'S';
 		 enviaSICC('formulario', null, null, 'N');
	 }	 
	 else {
		 var arrVacio = new Array();
		 arrVacio[0] = "";
		 arrVacio[1] = "";

		 var arr = new Array();	
		 arr[0] = arrVacio;

		 set_combo("formulario.cbTipoClsificacion", arr);
		 set_combo("formulario.cbClasificacion", arr);
	 }
}

function finalizaRecargarTipoClasificacionOK(strTipoClasificacion, 
	strClasificacion) {	
	eval("formulario").oculto= "N";
	set_combo("formulario.cbTipoClsificacion", generarDatosComboTipoClasificacion(strTipoClasificacion));
	listaClasificaciones = strClasificacion;  
}

function generarDatosComboTipoClasificacion(str){	
	var arr = new Array();	
	var arrVacio = new Array();
	arrVacio[0] = "";
	arrVacio[1] = "";
	arr[0] = arrVacio;

    var filas = str.split('|');

	for(var i=0; i<filas.length; i++) {
		var campos = filas[i];
		var campo = campos.split(",");
		arrIn = new Array();
        arrIn[0] = campo[0];
        arrIn[1] = campo[1];                        
        arr[i+1] = arrIn;      		
	}

    return arr;
}  

function finalizaRecargarTipoClasificacionERR() {
	eval("formulario").oculto= "N";
}

function onChangeTipoClasificacion(){
	var oidTipoClasificacion = get("formulario.cbTipoClsificacion");  
	set_combo("formulario.cbClasificacion", 
	generarDatosComboClasificacion(listaClasificaciones, oidTipoClasificacion));
}

function generarDatosComboClasificacion(str, oid) {	
	var arrVacio = new Array();
	arrVacio[0] = "";
	arrVacio[1] = "";

	var arr = new Array();	
	arr[0] = arrVacio;

    var filas = str.split('|');
	var j=0;

	for(var i=0; i<filas.length; i++) {
		var campos = filas[i];
		var campo = campos.split(",");

		if(campo[2]==oid) {
			j++;
			arrIn = new Array();
		    arrIn[0] = campo[0];
			arrIn[1] = campo[1];                        
	        arr[j] = arrIn;   
		}   		
	}

    return arr;
}  

function onClickBuscar() {
	var arrayBusqueda = armarArray();
	ocultarListaPaginada();
	configurarPaginado(mipgndo, "INCBuscarParticipantesDetalle", "ConectorBuscarParticipantesDetalle", 
    "es.indra.sicc.dtos.inc.DTOParticipantesDetalle", arrayBusqueda);
}

function armarArray(){
	var array = new Array();

	var oidIdioma = get("formulario.varIdioma");
	var oidPais = get("formulario.varPais");

	var oidCabecera = get("formulario.cbGrupoCliente");
	var tipoCliente = get("formulario.cbTipoCliente");
	var subtipoCliente = get("formulario.cbSubTipoCliente");
	var tipoClasificacion = get("formulario.cbTipoClsificacion");		
	var clasificacion = get("formulario.cbClasificacion");
	var descripcion = get("formulario.txtDescripcion");

	if ( oidCabecera != "")
		array[array.length] = ["oidCabecera", oidCabecera];

	if ( tipoCliente != "")
		array[array.length] = ["tipoCliente", tipoCliente];

	if ( subtipoCliente != "" )
		array[array.length] = ["subtipoCliente", subtipoCliente];

	if ( tipoClasificacion != "")	
		array[array.length] = ["tipoClasificacion", tipoClasificacion];

	if ( clasificacion != "")
		array[array.length] = ["clasificacion", clasificacion];

	if ( descripcion != "")
		array[array.length] = ["descripcion", descripcion];
	
	array[array.length] = ["oidIdioma", oidIdioma];
	array[array.length] = ["oidPais", oidPais];

	return array;
}

function muestraLista(ultima, rowset){
    var tamano = rowset.length;
    
    if (tamano > 0) {
        mostrarListaPaginada();
        eval(ON_RSZ);
        return true;
    }
	else {
        ocultarListaPaginada();
        return false;
    }
}

function onClickDetalle() {
	if (listado1.numSelecc()!= 1) {
		GestionarMensaje('1022',null,null,null);
		return false;
	}

    var arrAux = new Array();
    arrAux = listado1.codSeleccionados();
    var posicion = obtenerPosicionListaEditable(listado1.codSeleccionados(),listado1);
    var obj = new Object();

    obj.oidCabecera = listado1.datos[posicion][1];           
    obj.IDclasificacion = listado1.datos[posicion][3];           
    obj.tipoCliente = listado1.datos[posicion][8];           
    obj.subtipoCliente = listado1.datos[posicion][9];           
    obj.tipoClasificacion = listado1.datos[posicion][10];           
    obj.clasificacion = listado1.datos[posicion][11];           
	obj.oidGrupo = listado1.datos[posicion][12];               
	obj.descripcion = listado1.datos[posicion][13]
	obj.accion = "detalle";
    obj.opcionMenu = "consultar";
      
	mostrarModalSICC('LPMantenimientoParticipantesConcursoINCDetalle','detalle',obj);
}

function obtenerPosicionListaEditable(clave, lista){
	this.posicion = 0;
    if (lista.codSeleccionados().length > 0){
		for(var k=0;k<lista.datos.length;k++) {
			if (lista.datos[k][0] == clave) {
				posicion=k;
                break;
            }
		 }         
	     return posicion;
	}
}

function eliminar() {
	if(listado1.numSelecc() > 0) {             
	    var listaOidsEliminar = "";
        var codigo = "";
         
        codigo = listado1.codSeleccionados();
        for(var a = 0; a < codigo.length ; a++){
		    listaOidsEliminar = listado1.extraeDato(codigo[a], 0);
        } 
             
        eliminarFilas(listado1.codSeleccionados(),'INCEliminarParticipantesDetalle', mipgndo);
    }
	else{
		GestionarMensaje('406');
        return ;
    }
}

// DBLG500000303 - gPineda
function modificar(){
	if (listado1.numSelecc()!= 1) {
		GestionarMensaje('1022',null,null,null);
		return false;
	}

    var arrAux = new Array();
    arrAux = listado1.codSeleccionados();
    var posicion = obtenerPosicionListaEditable(listado1.codSeleccionados(),listado1);
    var obj = new Object();

    obj.oidCabecera = listado1.datos[posicion][1];           
    obj.IDclasificacion = listado1.datos[posicion][3];           
    obj.tipoCliente = listado1.datos[posicion][8];           
    obj.subtipoCliente = listado1.datos[posicion][9];           
    obj.tipoClasificacion = listado1.datos[posicion][10];           
    obj.clasificacion = listado1.datos[posicion][11];           
	obj.oidGrupo = listado1.datos[posicion][12];               
	obj.descripcion = listado1.datos[posicion][13];
	obj.oidDetalle = listado1.datos[posicion][0];
	obj.accion = "modificar";
    obj.opcionMenu = "modificar";
      
	var retorno = mostrarModalSICC('LPMantenimientoParticipantesConcursoINCDetalle','modificar',obj);
	if( retorno )
		listado1.insertaDato( retorno.oidDetalle , 12 , retorno.descripcion , false);
}
function fVolver(){
	window.close();
}
function ONTABbtnModificar(){
	focaliza("formulario.cbGrupoCliente");
}

function ONTABcbGrupoCliente() {
	focaliza("formulario.cbTipoCliente");
}

function ONTABcbTipoCliente() {
	focaliza("formulario.cbSubTipoCliente");
}

function ONTABcbSubTipoCliente() {
	focaliza("formulario.cbTipoClsificacion");
}

function ONTABcbTipoClsificacion() {
	focaliza("formulario.cbClasificacion");
}

function ONTABcbClasificacion() {
	focaliza("formulario.cbGrupoCliente");
}

function ONSHTABcbClasificacion() {
	focaliza("formulario.cbTipoClsificacion");
}

function ONSHTABcbTipoClsificacion() {
	focaliza("formulario.cbSubTipoCliente");
}

function ONSHTABcbSubTipoCliente() {
	focaliza("formulario.cbTipoCliente");
}

function ONSHTABcbTipoCliente() {
	focaliza("formulario.cbGrupoCliente");
}

function ONSHTABcbGrupoCliente() {
	focaliza("formulario.cbClasificacion");	
}

function ONTABbtnBuscar() {
	var menu = get("formulario.opcionMenu");    
	if(menu == "eliminar"){
		focalizaBotonHTML_XY('btnEliminar')		
	}
	else{
		focalizaBotonHTML_XY('btnDetalle');
	}	
}

function ONSHTABbtnBuscar() {
	focaliza("formulario.cbClasificacion");	
}

function ONTABbtnEliminar() {
	focaliza("formulario.cbGrupoCliente");	
}

function ONSHTABbtnEliminar() {
    focalizaBotonHTML('botonContenido','btnBuscar');	
}

function ONTABbtnDetalle() {
	focaliza("formulario.cbGrupoCliente");	
}

function ONSHTABbtnDetalle() {
    focalizaBotonHTML('botonContenido','btnBuscar');	
}



