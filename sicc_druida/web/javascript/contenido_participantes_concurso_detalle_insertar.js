var listaGrupoClientes;
var listaSubtipos;
var listaClasificaciones;

function onLoadPag(){	
	configurarMenuSecundario("formulario");
	fMostrarMensajeError();
	listaGrupoClientes = get("formulario.listaGrupoClientes");  
	listaSubtipos = get("formulario.listaSubtipos");  

	var accion = get("formulario.accion");  
	if(accion=="detalle") {
		marcaComboGrupoCliente();
		marcaIDClasificacion();
		marcaComboTipoCliente();
		marcaComboSubtipoCliente();
		marcaComboTipoClasificacion();
		deshabilitarCampos(accion);
	
		btnProxy(1, 0);     
		btnProxy(2, 1);     
		btnProxy(3, 0);     
		btnProxy(4, 0);     
		btnProxy(5, 0);     
		btnProxy(6, 1);     
		btnProxy(7, 0);     
		btnProxy(8, 0);     
		btnProxy(9, 0);     
		btnProxy(10, 1);
	}
	// DBLG500000303
	else if( accion=="modificar" ){
		marcaComboGrupoCliente();
		marcaIDClasificacion();
		marcaComboTipoCliente();
		marcaComboSubtipoCliente();
		marcaComboTipoClasificacion();

		deshabilitarCampos(accion);

		btnProxy(1, 1);     
		btnProxy(2, 1);     
		btnProxy(3, 0);     
		btnProxy(4, 0);     
		btnProxy(5, 0);     
		btnProxy(6, 1);     
		btnProxy(7, 0);     
		btnProxy(8, 0);     
		btnProxy(9, 0);     
		btnProxy(10, 1);
	}else {
		focaliza("formulario.cbGrupoCliente");
	}
	set("formulario.txtDescripcion", get("formulario.descripcion") );
	document.getElementById("txtIdClsificacion").disabled = true;
}

function fVolver() {
	window.close();
}

function marcaComboGrupoCliente() {
	var oidGrupo = get("formulario.oidGrupo");  
    var oidSeleccionado = new Array();
    oidSeleccionado = oidGrupo.split(",");	    
	set("formulario.cbGrupoCliente", oidSeleccionado);
}

function marcaIDClasificacion() {
	set("formulario.txtIdClsificacion", get("formulario.IDclasificacion"));
}

function marcaComboTipoCliente() {
	var tipoCliente = get("formulario.tipoCliente");  
    var oidSeleccionado = new Array();
    oidSeleccionado = tipoCliente.split(",");	    
	set("formulario.cbTipoCliente", oidSeleccionado);
}

function marcaComboSubtipoCliente() {
	var oidTipoCliente = get("formulario.tipoCliente");  
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
	else {
		var subtipoCliente = get("formulario.subtipoCliente");  
	    var oidSeleccionado = new Array();
		oidSeleccionado = subtipoCliente.split(",");	    
		set("formulario.cbSubTipoCliente", oidSeleccionado);
	}
}

function marcaComboTipoClasificacion() {	
	 var oidSubTipoCliente = get("formulario.subtipoCliente");  

	 if(oidSubTipoCliente!="") {
		 set('formulario.conectorAction', 'LPMantenimientoParticipantesConcursoINCDetalle');
	     set('formulario.accion', 'recargaTipoClasificacion');
		 set('formulario.opcionMenu', get("formulario.opcionMenu"));
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

function marcaComboClasificacion() {
	var oidTipoClasificacion = get("formulario.cbTipoClsificacion");  
	set_combo("formulario.cbClasificacion", 
	generarDatosComboClasificacion(listaClasificaciones, oidTipoClasificacion));

	var clasificacion = get("formulario.clasificacion");
    var oidSeleccionado = new Array();
    oidSeleccionado = clasificacion.split(",");	    
	set("formulario.cbClasificacion", oidSeleccionado);
}

// DBLG500000303 - se agrega el parametro accion
function deshabilitarCampos(accion) {
	document.getElementById("cbGrupoCliente").disabled = true;
	document.getElementById("txtIdClsificacion").disabled = true;
	document.getElementById("cbTipoCliente").disabled = true;
	document.getElementById("cbSubTipoCliente").disabled = true;
	document.getElementById("cbTipoClsificacion").disabled = true;
	document.getElementById("cbClasificacion").disabled = true;

	if (accion == "detalle" ){
		document.getElementById("txtDescripcion").disabled = true; 
	}
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

	var opcionMenu = get("formulario.opcionMenu");  
	if(opcionMenu=="consultar") {
		var tipoClasificacion = get("formulario.tipoClasificacion");  
	    var oidSeleccionado = new Array();
		oidSeleccionado = tipoClasificacion.split(",");	    
		set("formulario.cbTipoClsificacion", oidSeleccionado);
		marcaComboClasificacion();
	}
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

function onChangeTipoClasificacion() {
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

function fGuardar() {
	guardar();
}

function guardar() {
	if(!sicc_validaciones_generales('grupoCamposObligatorios')) {
		return;
    }	
	else {
		 set('formulario.conectorAction', 'LPMantenimientoParticipantesConcursoINCDetalle');
	     set('formulario.accion', 'guardar');

		 set('formulario.oidCabecera', get("formulario.cbGrupoCliente"));
 	  	 set('formulario.tipoCliente', get("formulario.cbTipoCliente"));
 	  	 set('formulario.subtipoCliente', get("formulario.cbSubTipoCliente"));
 	  	 set('formulario.tipoClasificacion', get("formulario.cbTipoClsificacion"));
 	  	 set('formulario.clasificacion', get("formulario.cbClasificacion"));
		 set('formulario.descripcion', get("formulario.txtDescripcion"));
		 
		 eval('formulario').oculto = 'S';
 		 enviaSICC('formulario', null, null, 'N');
	}
}

function guardarOK() {
	eval("formulario").oculto= "N";
	var arrVacio = new Array();
	arrVacio[0] = "";
	arrVacio[1] = "";

	var arr = new Array();	
	arr[0] = arrVacio;

	var valorSelec = new Array();

	set("formulario.cbGrupoCliente", valorSelec);
	set("formulario.txtIdClsificacion", "");
	set("formulario.cbTipoCliente", valorSelec);
	set_combo("formulario.cbSubTipoCliente", arr);
	set_combo("formulario.cbTipoClsificacion", arr);
	set_combo("formulario.cbClasificacion", arr);
	set('formulario.txtDescripcion', "");
	focaliza("formulario.cbGrupoCliente");

	var retorno = new Object();
	retorno.oidDetalle = get("formulario.oidDetalle");
	retorno.descripcion = get("formulario.descripcion");
	window.returnValue = retorno;
}

function guardarERR() {
	eval("formulario").oculto= "N";
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