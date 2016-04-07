var objGlobal = new Object();	
var datosListaTemp = new Array();	
var objVarHidden = new Object(); //[1] reemplaza las variables definidas en la pagina
	objVarHidden.hiCodCliente = ""; 
	objVarHidden.concursoElegido ="";
	objVarHidden.hiNumConcurso = "";
	objVarHidden.hiVersionConcurso="";
	objVarHidden.hiOidCliente= "";
	objVarHidden.hiOidConcurso= "";

	saltaValidacion = false;

var codClienteAnt;

function stringToObject(str){
    	var filas = str.split('|');
	var cantFilas = filas.length;

	for(var i=0; i< cantFilas ; i++) {
		var campo = filas[i].split(",");
		objGlobal[campo[0]]=[campo[0],campo[1],campo[2],campo[3]];
	}

}


function fLimpiar() {
	if (document.all["Cplistado1"].style.visibility=='visible'){
		var arrVacio = new Array();
		listado1.setDatos(arrVacio);
	}
	set("formulario.txtCodCliente", "");  
	set("formulario.txtNumeroPremio", "");
	focoCodigoCliente();
	objVarHidden.hiCodCliente = ""; 
	objVarHidden.hiNumConcurso = "";
	objVarHidden.hiVersionConcurso="";
	objVarHidden.hiOidCliente= "";
	objVarHidden.hiOidConcurso= "";
	ocultarCapaCabecera();
	ocultarLista1();
	codClienteAnt ="";
}

function onLoadPag() {  
	fMostrarMensajeError();
	configurarMenuSecundario("formulario");
	document.all["btnEliminarDiv"].style.visibility='hidden'; 

	stringToObject(get("formulario.hiLstConcursos"));
	focoComboNumeroConcurso();    

}

function ocultarCapaCriteriosBusqueda() {
	document.all["capa2"].style.visibility= "hidden";
}

function mostrarCapaCriteriosBusqueda() {
	document.all["capa2"].style.visibility= "visible";
}

function ocultarCapaCabecera() {
	document.all["capa3"].style.visibility= "hidden";
}

function mostrarCapaCabecera() {
	document.all["capa3"].style.visibility= "visible";
}

function mostrarLista1() {
    DrdEnsanchaConMargenDcho('listado1',12);    
	setTimeout('eval (ON_RSZ)',200);
    document.all["Cplistado1"].style.visibility='visible'; 
    document.all["CpLin1listado1"].style.visibility='visible';  
    document.all["CpLin2listado1"].style.visibility='visible'; 
    document.all["CpLin3listado1"].style.visibility='visible';
    document.all["CpLin4listado1"].style.visibility='visible';        
    document.all["btnEliminarDiv"].style.visibility='visible';                  

}

function ocultarLista1() {
    DrdEnsanchaConMargenDcho('listado1',12);      
	setTimeout('eval (ON_RSZ)',200);
    document.all["Cplistado1"].style.visibility='hidden'; 
    document.all["CpLin1listado1"].style.visibility='hidden';  
    document.all["CpLin2listado1"].style.visibility='hidden'; 
    document.all["CpLin3listado1"].style.visibility='hidden';
    document.all["CpLin4listado1"].style.visibility='hidden';
    document.all["btnEliminarDiv"].style.visibility='hidden';                   
}

function accionbtAceptarConcurso() { 
	if(!sicc_validaciones_generales('grupoNumeroConcurso')) {
	    return;
    }	

	var conSelec  = get("formulario.cbNumeroConcurso");
	
	objVarHidden.concursoElegido = conSelec; //[1] set("formulario.concursoElegido", conSelec);
	objVarHidden.hiOidConcurso = objGlobal[conSelec][0];//[1] set("formulario.hiOidConcurso", objGlobal[conSelec][0]);
	objVarHidden.hiNumConcurso = objGlobal[conSelec][1]; //[1] set("formulario.hiNumConcurso", objGlobal[conSelec][1]);	
	objVarHidden.hiVersionConcurso = objGlobal[conSelec][2]; //[1]set("formulario.hiVersionConcurso", objGlobal[conSelec][2]);
	mostrarCapaCriteriosBusqueda();
	document.getElementById("txtNumeroPremio").disabled = true;
	focoCodigoCliente();
}

function recuperarOK(saldoCliente, saldoCurso, datosLista, oidCliente) {
	mostrarCapaCabecera();
	mostrarLista1();

	//[1] eval("formulario").oculto= "N";

	//Frame Datos de cabecera
	txt_to('lbldtNumConcurso', objVarHidden.hiNumConcurso); //[1] get("formulario.hiNumConcurso"));
	txt_to('lbldtVersion', objVarHidden.hiVersionConcurso); // [1]get("formulario.hiVersionConcurso"));
	txt_to('lbldtCodCliente', objVarHidden.hiCodCliente);//[1] txt_to('lbldtCodCliente', get("formulario.hiCodCliente"));	
	txt_to('lbldtSaldoCliente', saldoCliente);
	txt_to('lbldtSaldoCurso', saldoCurso);

	//Seteo el oid de cliente
	//es por si se da el caso en que el usuario
	//se sepa el codigo de cliente de memoria
	//y hasta ahora no tenga el oid
	//que lo necesita al guardar
	objVarHidden.hiOidCliente = oidCliente;//[1] set("formulario.hiOidCliente", oidCliente);  

	//Lista Datos de detalle
	var datos = new Array();
	var filasTemp = datosLista.split("|");

	//Recorro filas
	for(var i=0; i<filasTemp.length ; i++) {
		var columnasTemp = filasTemp[i].split("$");
		datos[i] = columnasTemp;
	}
	
	datosListaTemp = datos;
	focoNumeroPremio();
	return true;
}

function recuperarERR() {
	//[1] eval("formulario").oculto= "N";
}

function fGuardar() {
	if(listado1.datos.length>0) {
		accionbtGuardar();
	}
}

function accionbtGuardar() {	
	var valoresLista = listado1.datos;
	var datosDeLista = "[";
	var tamano = valoresLista.length;

	for(var i=0; i<tamano; i++) {
		var fila = new Array();

		//Oid Nivel
		var oidNivel = valoresLista[i][5];
		if(oidNivel==""){
			oidNivel = " ";
		}
		fila[0] = oidNivel;

		//Numero premio
		var numPremio = valoresLista[i][2];
		if(numPremio=="") {
			numPremio = " ";
		}
		fila[1] = numPremio;		

		if(i==0){ 
			datosDeLista = datosDeLista + fila;	
		}else {
			datosDeLista = datosDeLista + "|" + fila;
		}
	}

	datosDeLista = datosDeLista + "]"
	

	var objParamsInt = new Object();
	objParamsInt.opener = window;
	objParamsInt.destino ='LPElegirPremiosElectivos';
	objParamsInt.conectorAction= 'LPElegirPremiosElectivos';
	var obj = new Object();
	obj.datosDeLista = datosDeLista;
	obj.hiOidCliente = objVarHidden.hiOidCliente;
	obj.hiOidConcurso = objVarHidden.hiOidConcurso ;
	obj.accion = 'guardarPremiosElegidos';
	objParamsInt.parametros = obj;
	setValues(objParamsInt);

}

function graboOK() {
	eval("formulario").oculto= "N";	
	ocultarCapaCabecera();
	ocultarLista1();
	objVarHidden.oidCliente = "";//[1] set("formulario.hiOidCliente", "");  
	objVarHidden.hiCodCliente ="";//[1] set("formulario.hiCodCliente", "");
    // [1] set("formulario.hiSaldoEnCurso", ""); se comenta porque no se usa
    // [1] set("formulario.hiSaldoCliente", "");  se comenta porque no se usa se setea siempre desde la lp   

	//Se vacia la lista
	var arrVacio = new Array();
	listado1.actualizaDat();
	listado1.setDatos(arrVacio);
	listado1.repintaDat();
	
	set("formulario.txtNumeroPremio", "");    
	document.getElementById("txtNumeroPremio").disabled = true;
	set("formulario.txtCodCliente", "");    
	focoCodigoCliente();
}

function graboERR() {
	eval("formulario").oculto= "N";
}

function accionBuscarCliente() {
   var obj = new Object();
   var whnd = mostrarModalSICC('LPBusquedaRapidaCliente','',obj);
  
   if(whnd!=null){
	  var oid = whnd[0];
      var cod = whnd[1];            
  	  objVarHidden.oidCliente = oid;//[1] set("formulario.hiOidCliente", oid);      
	  set("formulario.txtCodCliente", cod);
   }
}

function onChangeCodigoCliente() {
	objVarHidden.oidCliente = "";// [1] set("formulario.hiOidCliente", "");  

}

function errorAceptar() {

	GestionarMensaje('INC046',null,null,null);
	//ocultarCapaCabecera();
	//ocultarLista1();	

	//Se vacia la lista
	//[1] var arrVacio = new Array();
	//[1] listado1.actualizaDat();
	//[1] listado1.setDatos(arrVacio);
	//[1] listado1.repintaDat();

	set("formulario.txtNumeroPremio", "");    
	document.getElementById("txtNumeroPremio").disabled = true;
	focoCodigoCliente();
	return false;
}

function clienteInexistente() {
	//eval("formulario").oculto= "N";	
	ocultarCapaCabecera();
	ocultarLista1();	
	
	//Se vacia la lista
	var arrVacio = new Array();
	//[1] listado1.actualizaDat();
	listado1.setDatos(arrVacio);
	//[1] listado1.repintaDat();
	
	set("formulario.txtNumeroPremio", "");    
	set("formulario.txtCodCliente", "");
	document.getElementById("txtNumeroPremio").disabled = true;
	focoCodigoCliente();
	return false;
}

function clienteOnBlur() {
	/* [1]
	var longiCod = get('formulario.hLongCliente');
    var elTexto  = get('formulario.txtCodCliente');

    if(elTexto.length!=0){
    	var faltantes = longiCod -  elTexto.length;
        var resultCod = new String("");
        
		if(faltantes > 0){
        	for(var t = 0 ; t<faltantes; t++){
            	resultCod = resultCod + "0";
            }
	    }
        
		resultCod = resultCod + elTexto;
        set('formulario.txtCodCliente', resultCod);
 		document.getElementById("txtNumeroPremio").disabled = false;		
		focoNumeroPremio();

	    eval("formulario").oculto= "S";     
		set("formulario.hiOidCliente", "");  
		set("formulario.conectorAction", "LPElegirPremiosElectivos");
	    set("formulario.accion", "recuperarDatosCabeceraDetalle");    
		set("formulario.hiCodCliente", get("formulario.txtCodCliente"));
	    enviaSICC('formulario', '', '', 'N');
	}
	*/
	var longiCod = get('formulario.hLongCliente');
    var elTexto  = get('formulario.txtCodCliente');
	if (elTexto != "" && codClienteAnt != elTexto){		
	   	if(elTexto.length!=0){
	   		var faltantes = longiCod -  elTexto.length;
	        var resultCod = new String("");
	       
			if(faltantes > 0){
	       		for(var t = 0 ; t<faltantes; t++){
	           		resultCod = resultCod + "0";
	            }
			  }
		}
		resultCod = resultCod + elTexto;
		document.getElementById("txtNumeroPremio").disabled = false;		
	       
	    set('formulario.txtCodCliente', resultCod);
	    codClienteAnt = resultCod;
		objVarHidden.hiCodCliente = resultCod; //[1]
		var objParamsInt = new Object();
		objParamsInt.opener = window;
		objParamsInt.destino ='LPElegirPremiosElectivos';
		objParamsInt.conectorAction= 'LPElegirPremiosElectivos';
		var obj = new Object();
		obj.hiOidCliente = "";
		obj.hiCodCliente = resultCod;
		obj.hiOidConcurso = objVarHidden.hiOidConcurso;//objGlobal[tmpConSel][0] ;
		obj.hiNumConcurso = objVarHidden.hiNumConcurso;//objGlobal[tmpConSel][1];
		obj.hiVersionConcurso = objVarHidden.hiVersionConcurso;//objGlobal[tmpConSel][2];
		obj.accion = 'recuperarDatosCabeceraDetalle';
		objParamsInt.parametros = obj;
		setValues(objParamsInt);
	}

} 


function onChangeCbConcursos() {
	var concursoElegido  = objVarHidden.concursoElegido;//get("formulario.concursoElegido");
	var concursoElegidoAhora  = get("formulario.cbNumeroConcurso");

	if(concursoElegido!="" && concursoElegido!=concursoElegidoAhora
		&& concursoElegidoAhora!="") {
		var respuesta = GestionarMensaje('INC049',null,null,null);			

		if(respuesta==true) {
			//[1] set("formulario.concursoElegido", concursoElegidoAhora);
			//[1] onLoadPag();
			fLimpiar();

			//Incidencia DBLG500000587
			if(!sicc_validaciones_generales('grupoNumeroConcurso')) {
				return;
			}	

			var conSelec  = get("formulario.cbNumeroConcurso");
			objVarHidden.concursoElegido = conSelec;
			//[1] set("formulario.concursoElegido", conSelec);
			
			objVarHidden.hiOidConcurso = objGlobal[conSelec][0];//[1] set("formulario.hiOidConcurso", objGlobal[conSelec][0]);
			objVarHidden.hiNumConcurso = objGlobal[conSelec][1]; //[1] set("formulario.hiNumConcurso", objGlobal[conSelec][1]);
			objVarHidden.hiVersionConcurso =objGlobal[conSelec][2];//[1] set("formulario.hiVersionConcurso", objGlobal[conSelec][2]);
			
			mostrarCapaCriteriosBusqueda();
			document.getElementById("txtNumeroPremio").disabled = true;

			//for(var i=0; i<100; i++) {
				focoCodigoCliente();
			//}
			
			//FIN Incidencia DBLG500000587
		}
		else {
			var oidSeleccionado = new Array();
			oidSeleccionado = objVarHidden.concursoElegido[0].split(",");//[1] concursoElegido.split(",");
			set("formulario.cbNumeroConcurso", oidSeleccionado);
		}
	}
}

function actualizaSaldoCurso(seleccionado, valSaldoCurso, costePuntos) {
	var formatoDef = get('formulario.hFormatoDef');

	if(isNaN(costePuntos)) {
		return;
	}

    if (seleccionado=="true") {
		var a = numeroDeFormatoSICC(costePuntos, formatoDef);
		var b = numeroDeFormatoSICC(valSaldoCurso, formatoDef);

		if(parseFloat(a) > parseFloat(b)) {
			saltaValidacion = true;
			GestionarMensaje('INC012',null,null,null);			
			//focoNumeroPremio();
			return false;
		}	
		else {
			var res = numeroDeFormatoSICC(valSaldoCurso, formatoDef) - numeroDeFormatoSICC(costePuntos, formatoDef);
			txt_to('lbldtSaldoCurso', res);			
		}
	}	

	if (seleccionado=="false") {	
		var sum =numeroDeFormatoSICC(valSaldoCurso, formatoDef) + numeroDeFormatoSICC(costePuntos, formatoDef);
		txt_to('lbldtSaldoCurso', sum);	
	}
}

function accionbtEliminar() {
	//1° Verificar que haya seleccionado un registro
	if (listado1.numSelecc()== 0) {
		GestionarMensaje('1021',null,null,null);
		return;
    }

	var arrAux = new Array();
    arrAux = listado1.codSeleccionados();

	//2° Se actualiza el saldo
	for(var i=0; i<arrAux.length; i++) {		
		var oid = arrAux[i];
		for(j=0; j<listado1.datos.length; j++) {
			if(oid==listado1.datos[j][0]) {
				var seleccionado = "false";				
				var saldoCurso = document.getElementById("lbldtSaldoCursoDiv");
				var valSaldoCurso = saldoCurso.innerText;				
				var costeP = listado1.datos[j][4];
				var costePuntos = parseFloat(costeP);		
				
				actualizaSaldoCurso(seleccionado, valSaldoCurso, costePuntos);
		
				//3° Actualizar la matriz oculta
				var registro = listado1.datos[j];	
//				datosListaTemp[datosListaTemp.length] = registro;
			}
		}
	}

	//4° Borrar la fila seleccionada de la lista
	listado1.eliminarSelecc();
	focoNumeroPremio();
}


function ontabNumeroPremio() {	

if(!saltaValidacion){ 
	//1° Se toma el numero de premio ingresado por el cliente
	var numPremIngresado = get("formulario.txtNumeroPremio");
	var existe = "false";
	var posicion;
	//2° Se recorre la matriz cargado desde la LP
if (numPremIngresado != null && numPremIngresado !=""){
	for(var i=0; i<datosListaTemp.length; i++) {
		var numpremio = datosListaTemp[i][2];

		//3° Si el numero de premio coincide
		//con alguno de la matriz, se inserta en la lista
		if(numpremio==numPremIngresado) {
			posicion = i;
			existe = "true";

			//4° Se acualiza el saldo
			//[1] var seleccionado = "true";			

			//[1] var saldoCurso = document.getElementById("lbldtSaldoCursoDiv");
			var valSaldoCurso = document.getElementById("lbldtSaldoCursoDiv").innerText; //[1] saldoCurso.innerText;			
			
			//[1] var costeP = array[4];						
			var costePuntos =parseFloat(datosListaTemp[i][4]);	

			var resp = actualizaSaldoCurso("true"/*[1] seleccionado*/, valSaldoCurso, costePuntos);			

			if(resp== false) {
				break;
			}

			var array = new Array();
			array[0] = new String(datosListaTemp[i][0]);
			array[1] = new String(datosListaTemp[i][1]);
			array[2] = new String(numpremio);
			array[3] = new String(datosListaTemp[i][3]);
			array[4] = new String(datosListaTemp[i][4]);
			array[5] = new String(datosListaTemp[i][5]);

			//[1] listado1.actualizaDat();
			var datos = listado1.datos;
			datos[datos.length] = array; 
			listado1.setDatos(datos);//[1] listado1.setDatos(datos);
			// [1] listado1.repintaDat();
			break;
		}
	}

	//5° Si no coincide con ninguno de la matriz
	//se muestra un mensaje.
	if(existe=="false") {
		GestionarMensaje('INC051',null,null,null);
		focoNumeroPremio();
		return false;
	}

	//6° Se actualiza la matriz oculta
	//para que no vuelva a ingresar el mismo numero de premio.

	/* [1] se comenta porque con el splice() se logra el mismo objetivo
	var datosListaNueva = new Array();
	var k = 0;
	for(var j=0; j<datosListaTemp.length; j++) {
		if(numPremIngresado!=datosListaTemp[j][2]) {
			datosListaNueva[k] = datosListaTemp[j];
			k++;
		}
	}
	datosListaTemp = datosListaNueva;
	*/
//	datosListaTemp.splice(posicion,1);
	
	set("formulario.txtNumeroPremio", "");
	focoNumeroPremio();
}
} else {
	saltaValidacion = false;
}
}

function onTABComboConcurso() {
	focoBotonAceptar();
}

function focoComboNumeroConcurso() {
	focaliza("formulario.cbNumeroConcurso");
}

function focoNumeroPremio() {
	focaliza("formulario.txtNumeroPremio");
}

function ontabCodigoCliente() {	
	clienteOnBlur();
}

function focoCodigoCliente() {
	focaliza("formulario.txtCodCliente");
}

function onTABBtnBuscar() {
	focoCodigoCliente();
}

function onTabBotonAceptar() {
	if(document.all["capa2"].style.visibility=="hidden") {
		focoComboNumeroConcurso();
	}
	else {
		focoCodigoCliente();
	}
}

function focoBotonAceptar() {
	focalizaBotonHTML('botonContenido','btnAceptar');	
}

function onshtabNumeroPremio() {
	focoCodigoCliente();
}

function onshtabCodigoCliente() {
	focoBotonAceptar();
}

function onshtabNumeroConcurso() {	
	if(document.all["capa3"].style.visibility=="hidden") {
		if(document.all["capa2"].style.visibility=="hidden") {
			focoBotonAceptar();	
		}
		else {
			focoNumeroPremio();
		}			
	}
	else {
		focalizaBotonHTML('botonContenido','btnEliminar');
	}
}

function onEnterNumeroPremio() {
	if(event.keyCode==13) {
		ontabNumeroPremio();
	}
}

function onEnterCodigoCliente() {
	if(event.keyCode==13) {
		ontabCodigoCliente();
	}
}

function setValues(objParams){
	if(objParams.parametros){

		var atributos;
		//Limpio todos los campos insertados del frm que envio
		eliminaElementosDinamicos();
		for(atributos in objParams.parametros){
			if(atributos != "window" && atributos != "length"){
				var hidden = document.createElement("INPUT");
				hidden.type = "hidden";
				hidden.insertado = "1";
				hidden.name = atributos;
				hidden.value = (objParams.parametros[atributos]==null)?"":objParams.parametros[atributos];
				document.forms["frmContenidoEnvia"].appendChild(hidden);
			}
		}
		set('frmContenidoEnvia.conectorAction', objParams.conectorAction);
		enviaSICC("frmContenidoEnvia");
	}
	
}

/*Limpio todos los campos insertados 
dinámicamente porque sino crea otros con el mismo nombre
*/
function eliminaElementosDinamicos(){
	var elementos = document.forms["frmContenidoEnvia"].elements;
	var longitud = elementos.length;
	for ( i = 0;i < longitud; i++ ){
		var oChild=document.forms["frmContenidoEnvia"].children(i);	
		if (oChild!= null && oChild.insertado=="1"){
			document.forms["frmContenidoEnvia"].removeChild(oChild);
			i = i-1;
		}
	}
}