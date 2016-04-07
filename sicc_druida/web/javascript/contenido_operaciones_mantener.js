var FORMULARIO = "frmFormulario";
var numFila = '';
var posReg = '';
var oidModificado = '';

      
function onLoadPag(){
	
	focaliza(FORMULARIO+'.txtTipoOperacion');
	
	configurarMenuSecundario(FORMULARIO);	
	if (get(FORMULARIO+'.errDescripcion')!='') {
    	var wnd = fMostrarMensajeError(get(FORMULARIO+'.errCodigo'),get(FORMULARIO+'.errDescripcion'));
    }   
    var opcionMenu = get(FORMULARIO+'.opcionMenu');
	DrdEnsanchaConMargenDcho('listado1',12);
	document.all["Cplistado1"].style.visibility='';
	document.all["CpLin1listado1"].style.visibility=''; 
	document.all["CpLin2listado1"].style.visibility='';
	document.all["CpLin3listado1"].style.visibility='';
	document.all["CpLin4listado1"].style.visibility='';
	//document.all["primera1Div"].style.visibility='hidden';
	//document.all["ret1Div"].style.visibility='hidden';
	//document.all["ava1Div"].style.visibility='hidden'; 
	//document.all["separaDiv"].style.visibility='hidden';
		
	eval (ON_RSZ);  
    if(opcionMenu == "consultar operacion"){
    	btnProxy(1,0); //se deshabilita tambien el boton guardar del menu secundario.
    	btnProxy(5,0); //se deshabilita limpiar
    	document.all["btnInsertar"].disabled = true;
    	document.all["Modificar"].disabled = true;
    	document.all["Eliminar"].disabled = true;	
    }else{
    	var listaTipos = get(FORMULARIO+'.listaTipos');                  
        var lista = listaTipos.split('#');
        var fila = '';    
        for (i = 0; i < (lista.length-1); i++) {
        	aux = new String(lista[i]);
        	fila = aux.split(",");  
        	var filaNueva = [fila[0],fila[1],fila[2],fila[3],fila[4],fila[5],fila[6],fila[7],fila[8],fila[9],fila[10],fila[11],
        	fila[12],fila[13],fila[14],fila[15],fila[16],fila[17],fila[18],fila[19]];
        	if(typeof(filaNueva)!='undefined') {
    	    	if(filaNueva.length!=0) {
    	        	//Insertamos la fila
    	            listado1.insertar(filaNueva);
    	            listado1.reajusta();
    	        }
    	   	}
    	}   
	}   
        
        
	DrdEnsanchaConMargenDcho('listado1',12);
	document.all["Cplistado1"].style.visibility='';
	document.all["CpLin1listado1"].style.visibility=''; 
	document.all["CpLin2listado1"].style.visibility='';
	document.all["CpLin3listado1"].style.visibility='';
	document.all["CpLin4listado1"].style.visibility='';
	//document.all["primera1Div"].style.visibility='hidden';
	//document.all["ret1Div"].style.visibility='hidden';
	//document.all["ava1Div"].style.visibility='hidden'; 
	//document.all["separaDiv"].style.visibility='hidden';
		
	eval (ON_RSZ);  
	    
	// Se elimina por incidencia 12868
	/*Si oidOperacion<>"" entonces{ //Si el oidOperacion no viene vacio 
	Llamamos a configurarPaginado pasándole los siguientes parametros: 
	- Objeto paginado (lstTiposOperacion) 
	- idBusiness ("CALobtenerTiposOperacion") 
	- "ConectorObtenerTiposOperacion" 
	- "DTOOid" 
	- Parametro del DTOOid: 
	- oid = oidOperacion (parametro recibido que indica a que operacion estan asociados estos tipos de operacion) 
	} 
	*/
	
	
}

function aMayusculas(campo){
	if (get(FORMULARIO+'.'+campo)!='') {
    	set(FORMULARIO+'.'+campo,get(FORMULARIO+'.'+campo).toUpperCase());
    }
}

function validarDias(){
	
    var num = get(FORMULARIO+'.txtCantidadDiasAtras'); 
  
    if(num != ""){
    	var val = allTrim(num);              
    	//Como no nos interesa validar el número de dígitos que tiene el 
    	//entero ponemos uno suficientemente grande. 
    	if ((ValidaInt(val.toString(),10000, 0)!="OK")||(val.toString() < 0)) {
    		GestionarMensaje('747', null, null, null);
    		focaliza(FORMULARIO+'.txtCantidadDiasAtras');
    		return false;
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


function onClickInsertar(){

	var oid = '';
	var tipoOp = '';
	var descTipoOp = '';
	var campania = '';
	var cantidadDias = '';
	var informacionNot = '';
	var devuelveFact = '';
	var enviaFact = '';
	var oidBloqueoDifPrecio = '';
	var bloqueoDifPrecio = '';
	var oidBloqueoRec = '';
	var bloqueoRec = '';
	var oidBloqueoImp = '';
	var bloqueoImp = '';
	var oidBloqueoUnid = '';
	var bloqueoUnid = '';
	var oidBloqueoVal = '';
	var bloqueoVal = '';
	var descripciones = '';
	
	modificado = get(FORMULARIO+'.modificado');	
	
	if (sicc_validaciones_generales()){
		
		tipoOp = get(FORMULARIO+'.txtTipoOperacion');
		descTipoOp = get(FORMULARIO+'.txtDescripcion');
		campania = get(FORMULARIO+'.CampanaReferenciaUnica');
		if(campania == 'S')
			campania = 'Si';
		else
			campania = 'No';
		cantidadDias = get(FORMULARIO+'.txtCantidadDiasAtras');
		informacionNot = get(FORMULARIO+'.InformacionEbelNoticias');
		if(informacionNot == 'S')
			informacionNot = 'Si';
		else
			informacionNot = 'No';
		devuelveFact = get(FORMULARIO+'.DevuelveEstaFactura');
		if(devuelveFact == 'S')
			devuelveFact = 'Si';
		else
			devuelveFact = 'No';
			
		enviaFact = get(FORMULARIO+'.EnviaEstaFactura');
		if(enviaFact == 'S')
			enviaFact = 'Si';
		else
			enviaFact = 'No';
		oidBloqueoDifPrecio = get(FORMULARIO+'.cbBloqueoDiferenciaPrecio');
		bloqueoDifPrecio = get(FORMULARIO+'.cbBloqueoDiferenciaPrecio','T').toString();
		oidBloqueoRec = get(FORMULARIO+'.cbBloqueoReclamoAnterior');
		bloqueoRec = get(FORMULARIO+'.cbBloqueoReclamoAnterior','T').toString();
		oidBloqueoImp = get(FORMULARIO+'.cbBloqueoImporte');
		bloqueoImp = get(FORMULARIO+'.cbBloqueoImporte','T').toString();
		oidBloqueoUnid = get(FORMULARIO+'.cbBloqueoUnidades');
		bloqueoUnid = get(FORMULARIO+'.cbBloqueoUnidades','T').toString();
		oidBloqueoVal = get(FORMULARIO+'.cbRechazoValidacion');
		bloqueoVal = get(FORMULARIO+'.cbRechazoValidacion','T').toString();
		descripciones = recuperarDescripciones();
		
		if(modificado == "true"){
			//Si modificado  //El usuario rellena los campos de la pantalla y modifica el registro 
			//- Se elimina el registro seleccionado ( q es el de la posicion indicada en posReg ) de la lista lstTiposOperacion 
			oid = oidModificado; //tomamos el oid del registro que se quiere modificar
			posReg = numFila;
			listado1.eliminarSelecc();
			
			//- Se limpia la variable posReg 
			posReg = '';
			//- Se añade un nuevo registro en la lista lstTiposOperacion con los campos especificados.
			//El ultimo campo de la lista checkModificado=True 
			
			fila = [oid,tipoOp,descTipoOp,campania,cantidadDias,informacionNot,devuelveFact,enviaFact,oidBloqueoDifPrecio,
					bloqueoDifPrecio,oidBloqueoRec,bloqueoRec,oidBloqueoImp,bloqueoImp,oidBloqueoUnid,bloqueoUnid,
					oidBloqueoVal,bloqueoVal,"true",descripciones];
			//alert("fila ="+fila);
			if(typeof(fila)!='undefined') {
    	    	if(fila.length!=0) {
    	        	//Insertamos la fila
    	            listado1.insertar(fila);
    	            listado1.reajusta();
    	        }
    	    }
			//- Limpiar los campos. 
			fLimpiar();
			//- modificado = false 	
 			set(FORMULARIO+'.modificado',false);
 			
		}else{
			//En otro caso  //El usuario rellena los campos de la pantalla e inserta un nuevo registro 
			//- Se añade un nuevo registro a la lista lstTiposOperacion con los campos especificados.
			//El ultimo campo de la lista checkModificado= False  
			
			oid = "0"; //para insertar registros nuevos ponemos oid cero.  
			
			fila = [oid,tipoOp,descTipoOp,campania,cantidadDias,informacionNot,devuelveFact,enviaFact,oidBloqueoDifPrecio,
					bloqueoDifPrecio,oidBloqueoRec,bloqueoRec,oidBloqueoImp,bloqueoImp,oidBloqueoUnid,bloqueoUnid,
					oidBloqueoVal,bloqueoVal,"false",descripciones];
			//alert("fila ="+fila);
			if(typeof(fila)!='undefined') {
    	    	if(fila.length!=0) {
    	        	//Insertamos la fila
    	        	listado1.insertar(fila);
    	        	listado1.reajusta();
    	        	
    	        }
    	    }
			//- Limpiar los campos 
			fLimpiar();
		}
		
	}
	
	focaliza(FORMULARIO+'.txtTipoOperacion'); 
}

function onClickModificar(){


	//El usuario selecciona un registro de la lista y lo modifica 
	//Si solo se ha seleccionado un registro de la lstTiposOperacion: 
	//- Se cargan los campos de la pantalla con el registro seleccionado de la lista. 
	//- modificado = true 
	//- posReg = posicion del registro seleccionado dentro de la lstTiposOperacion 
	//Si no se muestra el error generico de que solo se debe seleccionar un registro.
	
	if(listado1.numSelecc() == 0){
    	// "Debe seleccionar un elemento de la lista"
        GestionarMensaje('50');
    }else if(listado1.numSelecc() >1){
    	// "Debe seleccionar solo un elemento de la lista"
        GestionarMensaje('1217');
        //Se limpia la lista editable
        var seleccion=listado1.codigos();
        var i=0;
        while(seleccion[i]!=null){
        	listado1.deselecciona(i); 
        	i++;            
    	}
	}else{
		fLimpiar();
		set(FORMULARIO+'.modificado',"true");
		posReg = numFila;
		listado1.actualizaDat(); //Actualiza el array 'datos'
    	var datosFinal = listado1.datos;
    	var fila = datosFinal[posReg];
    	//alert("fila = "+fila);
    	oidModificado = fila[0];
    	set(FORMULARIO+'.txtTipoOperacion',fila[1]);
    	set(FORMULARIO+'.txtDescripcion',fila[2]);
    	if(fila[3] == 'Si')
    		set(FORMULARIO+'.CampanaReferenciaUnica','S');
    	else
    		set(FORMULARIO+'.CampanaReferenciaUnica','N');
    	set(FORMULARIO+'.txtCantidadDiasAtras',fila[4]);
    	if(fila[5] == 'Si')
    		set(FORMULARIO+'.InformacionEbelNoticias','S');	
    	else
    		set(FORMULARIO+'.InformacionEbelNoticias','N');	
		if(fila[6] == 'Si')
			set(FORMULARIO+'.DevuelveEstaFactura','S');	
		else
			set(FORMULARIO+'.DevuelveEstaFactura','N');	
		if(fila[7] == 'Si')
			set(FORMULARIO+'.EnviaEstaFactura','S');	
		else
			set(FORMULARIO+'.EnviaEstaFactura','N');
		set(FORMULARIO+'.cbBloqueoDiferenciaPrecio',[fila[8]]);	
		set(FORMULARIO+'.cbBloqueoReclamoAnterior',[fila[10]]);	
		set(FORMULARIO+'.cbBloqueoImporte',[fila[12]]);	
		set(FORMULARIO+'.cbBloqueoUnidades',[fila[14]]);	
		set(FORMULARIO+'.cbRechazoValidacion',[fila[16]]);
		var descripciones = new String(fila[19]);
		//alert("descripciones = "+descripciones);
		var listaDesc = descripciones.split("@");
		var desc = '';
		for(i=0;i<listaDesc.length-1;i++){
			aux = new String(listaDesc[i]);
			desc = aux.split(":");
			if(desc[1] != ''){
				if(desc[1] == '-')
					set(FORMULARIO+'.descripcion_1_' +desc[0],'');
				else
					set(FORMULARIO+'.descripcion_1_' +desc[0],desc[1]);
			}
		}
				
	}
	focaliza(FORMULARIO+'.txtTipoOperacion');
}

function onClickEliminar(){
	//El usuario elimina registros de la lstTiposOperacion 
	//- Sil la fila seleccionad tiene un oid asociado : 
	//se guarda el oid de los registros seleccionados en un arrayListEliminados. 
	//- Se elimina los registros de la lstTiposOperacion. 
	if(listado1.numSelecc() == 0){
    	// "Debe seleccionar un elemento de la lista"
        GestionarMensaje('50');
    }else{
	
		var seleccionados = new String(listado1.codSeleccionados());
		var listaOids = seleccionados.split(',');
		var listaEliminados = get(FORMULARIO+'.listaEliminados');
		for(i=0;i<listaOids.length;i++){
			if(listaOids[i] != 0){
				listaEliminados += listaOids[i] + ',';
			}
		}
		set(FORMULARIO+'.listaEliminados',listaEliminados);
		listado1.eliminarSelecc(); 
	}
	focaliza(FORMULARIO+'.txtTipoOperacion');
}

function fGuardar(){
	
	onClickGuardar();	
}

function obtenerNumFila(fila){
	numFila = fila;
}

function onClickGuardar(){

	//Se cargan en un arrayListTiposOperacion los registros de la lstTiposOperacion. 
	//Se retorna: 
	//- arrayListTiposOperacion 
	//- arrayListEliminados
	 
     listado1.actualizaDat(); //Actualiza el array 'datos'
     datosFinal = listado1.datos;
     var eliminados = get(FORMULARIO+'.listaEliminados');
	 window.returnValue = [datosFinal,eliminados];	
	 window.close();
	
}

function fVolver(){
	window.close();
}

function fLimpiar(){
	
	limpiaI18N(FORMULARIO,1);
	
	set(FORMULARIO+'.txtTipoOperacion','');
	set(FORMULARIO+'.txtDescripcion','');
	set(FORMULARIO+'.txtCantidadDiasAtras','');
	
	set(FORMULARIO+'.CampanaReferenciaUnica','N');
	set(FORMULARIO+'.InformacionEbelNoticias','N');
	set(FORMULARIO+'.DevuelveEstaFactura','N');
	set(FORMULARIO+'.EnviaEstaFactura','N');	
	
	set(FORMULARIO+'.cbBloqueoDiferenciaPrecio',[0]);
	set(FORMULARIO+'.cbBloqueoReclamoAnterior',[0]);
	set(FORMULARIO+'.cbBloqueoImporte',[0]);
	set(FORMULARIO+'.cbBloqueoUnidades',[0]);
	set(FORMULARIO+'.cbRechazoValidacion',[0]); 
	var oidsIdiomas = get(FORMULARIO+".idiomas");
	var arrOids = oidsIdiomas.split(",");
	for (var i=0;i<(arrOids.length-1);i++){ 
		set(FORMULARIO+".descripcion_1_"+arrOids[i], '');		
		
	}	
}


function recuperarDescripciones(){

	var salida = '';
	var traduccion = '';
	
	var idioma = get(FORMULARIO+'.idioma');
	var idiomas = new String(get(FORMULARIO+'.idiomas'));
	
    listaIdiomas = idiomas.split(",");	
    
    for(i = 0; i < listaIdiomas.length-1; i++){
    	
    	if(idioma == listaIdiomas[i])
    	    traduccion = get(FORMULARIO+'.txtDescripcion');
    	else
    	    traduccion = get(FORMULARIO+'.descripcion_1_' + listaIdiomas[i]);
    	
    	if(traduccion == '')
    		traduccion = '-';
    	    	
    	salida += listaIdiomas[i]+':'+traduccion+'@';
    }
	return salida;

}

                     
function focalizaBoton(){
	document.all['Modificar'].focus();
}

function mostrarPopUpI18N(){
	levantarI18NNueva('frmFormulario', '1');
}

function levantarI18NNueva(frmnombre, index) {

	//Levanta un pop-up con el resultado de la invocación de LPMantenerI18N, le pasa como argumento la entidad 
	//que saca del hidden i18NEntidad, el oid de i18NOID y cargar de i18NCargar. 

	var oidsIdiomas = get(frmnombre+".idiomas");
	//alert("Idiomas = "+oidsIdiomas);
	var vWnd = -1; 
	var parametros = new Object();
	var cargado = "false"; //get(frmnombre+".hi18NCargado_"+index);
	set(frmnombre+'.hi18NEntidad_'+index,"REC_TIPOS_OPERA");
	set(frmnombre+'.hi18NOID_'+index,"");
		
	var nombreCampoTraducible = "txtDescripcion"; //get(frmnombre+".htxtNombre_"+index);
	parametros.hi18NidiomaActual = get(frmnombre+'.idioma'); //get(frmnombre+".hi18NidiomaActual");
	parametros.hSoloLectura = "false";
	
 	var arrOids = oidsIdiomas.split(",");
	for (var i=0;i<(arrOids.length-1);i++){
    	eval('parametros.hi18NTraduccion_'+arrOids[i]+'=\"\"');
    	if (arrOids[i]==get(frmnombre+'.idioma')){
			parametros['hi18NTraduccion_'+arrOids[i]] = get(frmnombre+"."+nombreCampoTraducible);
		}else{
			set(frmnombre+".hi18NTraduccion_"+index+"_"+arrOids[i],get(frmnombre+".descripcion_"+index+"_"+arrOids[i]));
    		parametros['hi18NTraduccion_'+arrOids[i]] = get(frmnombre+".descripcion_"+index+"_"+arrOids[i]);
    	}
	} 
	parametros.textarea = obtenerTipo(nombreCampoTraducible);
  	  	
  	vWnd = window.showModalDialog('sicc0000jg?ON=LPMantenerI18n&nroAtrib='+index+'&hi18NCargado='+cargado,parametros,'dialogWidth:480px;dialogHeight:500px;status:no;scroll:yes;help:no;resizable=no;');
			
	//setea los parametros de nuevo en las variables ocultas
	set(frmnombre+".hi18NCargado_"+index,"false"); 
	for (var i=0;i<(arrOids.length-1);i++){
		set(frmnombre+".descripcion_1_"+arrOids[i], eval('parametros.hi18NTraduccion_'+arrOids[i]));		
	}	
}

function obtenerTipo(strNombre){
	var obj = document.body.all[strNombre];
	if(obj.length && (typeof(obj)).toUpperCase()=="OBJECT"){
		for(var i=0;i<obj.length;i++){
	    	if(obj[i].tagName && obj[i].tagName.toUpperCase()=="TEXTAREA"){
	      		return true;
	    	}
	  	}  
	}else{
		if(obj.tagName && obj.tagName.toUpperCase()=="TEXTAREA"){
	    	return true;
	  	}
	}
	return false;
}

