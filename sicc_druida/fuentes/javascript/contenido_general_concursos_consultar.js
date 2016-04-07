function onLoadPag() {    
		configurarMenuSecundario("formulario");
		ocultarLista();
		focoCodigoCliente();

    }

	function fLimpiar() {
		set("formulario.varOidCliente", "");      
		set("formulario.oidConcurso", "");   
		onLoadPag();
	}

	function focoCodigoCliente() {
		focaliza("formulario.txtCodCliente");
	}

	function ocultarLista() {
		DrdEnsanchaConMargenDcho('listado1',12);      
		document.all["Cplistado1"].style.visibility='hidden'; 
		document.all["CpLin1listado1"].style.visibility='hidden';  
		document.all["CpLin2listado1"].style.visibility='hidden'; 
		document.all["CpLin3listado1"].style.visibility='hidden';
		document.all["CpLin4listado1"].style.visibility='hidden';        		
		document.all["primera1Div"].style.visibility='hidden'; 
		document.all["ret1Div"].style.visibility='hidden';
		document.all["ava1Div"].style.visibility='hidden';  
		document.all["separaDiv"].style.visibility='hidden';           
		document.getElementById("Detalle").style.visibility = "hidden";
		document.getElementById("PremiosProcesados").style.visibility = "hidden";
		document.getElementById("Recomendacion").style.visibility = "hidden";
		document.getElementById("PremiosSeleccionados").style.visibility = "hidden";
		document.getElementById("MotivosDescalificacion").style.visibility = "hidden";
		setTimeout('eval (ON_RSZ);',200);

	}

	function mostrarListaResultados() {
		DrdEnsanchaConMargenDcho('listado1',12);      
		document.all["Cplistado1"].style.visibility='visible'; 
		document.all["CpLin1listado1"].style.visibility='visible';  
		document.all["CpLin2listado1"].style.visibility='visible'; 
		document.all["CpLin3listado1"].style.visibility='visible';
		document.all["CpLin4listado1"].style.visibility='visible';        		
		document.all["primera1Div"].style.visibility='visible'; 
		document.all["ret1Div"].style.visibility='visible';
		document.all["ava1Div"].style.visibility='visible';  
		document.all["separaDiv"].style.visibility='visible';           
		document.getElementById("Detalle").style.visibility = "visible";
		document.getElementById("PremiosProcesados").style.visibility = "visible";
		document.getElementById("Recomendacion").style.visibility = "visible";
		document.getElementById("PremiosSeleccionados").style.visibility = "visible";
		document.getElementById("MotivosDescalificacion").style.visibility = "visible";
		setTimeout('eval (ON_RSZ);',200);
	}

	function onClickboBusquedaCliente() {	
	    var obj = new Object();
		var whnd = mostrarModalSICC('LPBusquedaRapidaCliente','',obj);
  
		if(whnd!=null){
		  var oid = whnd[0];
	      var cod = whnd[1];      
	  	  var nombre1 = whnd[2];
	      var nombre2 = whnd[3];
		  var apellido1 = whnd[4];
	      var apellido2 = whnd[5];

		  var nombreCompleto = nombre1 + " " + nombre2 + " " + apellido1 
		  + " " + apellido2
      
		  set("formulario.txtCodCliente", cod);
		  set("formulario.varOidCliente", oid);      
  		  set("formulario.laNombreApellido", nombreCompleto);      		  
		  txt_to('lbldtNombreApellidos', nombreCompleto);
		}
	}

	function onChangectCodigoCliente() {		
		clienteOnBlur();
		//Si cambio el codigo de cliente, se limpia la variable
		//oculta que tiene el oid, y el campo nombre-apellido
		set("formulario.varOidCliente", "");    
		txt_to('lbldtNombreApellidos', "");

		if(get("formulario.txtCodCliente")!="") {
			/*eval("formulario").oculto= "S";
			set("formulario.conectorAction", "LPConsultaGeneralConcurso");
			set("formulario.accion", "cargaClienteConcurso");
			set("formulario.codigoCliente", get("formulario.txtCodCliente"));
			set("formulario.numeroConcurso", get("formulario.txtNumconcurso"));
			enviaSICC('formulario', '', '', 'N');*/
			var objParamsInt = new Object();
			objParamsInt.opener = window;
			objParamsInt.destino ='LPConsultaGeneralConcurso';
			objParamsInt.conectorAction= 'LPConsultaGeneralConcurso';
			var obj = new Object();
			obj.accion = 'cargaClienteConcurso';
			obj.codigoCliente = get("formulario.txtCodCliente");
			obj.numeroConcurso = get("formulario.txtNumconcurso");
			objParamsInt.parametros = obj;
			setValues(objParamsInt ,'formularioEnvia' );
		}
		
	}

	function parseaCombo(str){	

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

	function seteandoOidDefecto(oidDefault) {
		set("formulario.cbUnidadAdministrativa", oidDefault.split(","));
		endTransaction('seteandoOidDefecto');
	}

	function finalizaCargaClienteConcurso(oidCliente, codigoCliente, 
 	    nombresApellidos, oidConcurso, unidades, oidDefault, numeroConcurso) {
	    set_combo("formulario.cbUnidadAdministrativa", parseaCombo(unidades));


		if(oidDefault!="") {
			seteandoOidDefecto(oidDefault);
		}
		
		set("formulario.varOidCliente", oidCliente);      
		set("formulario.txtCodCliente", codigoCliente);
		set("formulario.laNombreApellido", nombresApellidos);      		  
		set("formulario.tempNombreApellido", nombresApellidos);      		  
		txt_to('lbldtNombreApellidos', nombresApellidos);
		set("formulario.oidConcurso", oidConcurso);      	
		set("formulario.txtNumconcurso", numeroConcurso);      	
		focaliza("formulario.cbUnidadAdministrativa");

	}

	function errorFinalizaCargaClienteConcurso() {
		eval("formulario").oculto= "N";

		var arr = new Array();	
		var arrVacio = new Array();
		arrVacio[0] = "";
		arrVacio[1] = "";
		arr[0] = arrVacio;

		set_combo("formulario.cbUnidadAdministrativa", arr);
		set("formulario.txtCodCliente", "");		
		focoCodigoCliente();		
	}

	function errorAsignarOidsOcultos() {
		eval("formulario").oculto= "N";

		set("formulario.oidSeccion", "");
		set("formulario.oidZona", "");
		set("formulario.oidRegion", "");
	}

	function asignarOidsOcultos(oidSeccion, oidZona, oidRegion) {
		eval("formulario").oculto= "N";

		set("formulario.oidSeccion", oidSeccion);
		set("formulario.oidZona", oidZona);
		set("formulario.oidRegion", oidRegion);

		var arr = new Array();
		arr[arr.length] = 
		new Array("oidCliente", get("formulario.varOidCliente")+"");

		arr[arr.length] = 
		new Array("oidConcurso", get("formulario.oidConcurso")+""); 

		arr[arr.length] = 
		new Array("numeroConcurso", get("formulario.txtNumconcurso")+"");

		arr[arr.length] = 
        new Array("oidRegion", get("formulario.oidRegion")+""); 

        arr[arr.length] = 
        new Array("oidZona", get("formulario.oidZona")+"");

        arr[arr.length] = 
        new Array("oidSeccion", get("formulario.oidSeccion")+""); 
	  
		configurarPaginado(mipgndo,"INCBuscaConcursosConsultaIntegral", 
		"ConectorBuscaConcursosConsultaIntegral",
		"es.indra.sicc.dtos.inc.DTOCabeceraConsultaIntegral",arr);		
	}

	function onClickboBuscar() {
		if(!sicc_validaciones_generales('grupoCodigoCliente')) {
			return;
		}

		if(get("formulario.cbUnidadAdministrativa")!="") {
			var objParamsInt = new Object();
			objParamsInt.opener = window;
			objParamsInt.destino ='LPConsultaGeneralConcurso';
			objParamsInt.conectorAction= 'LPConsultaGeneralConcurso';
			var obj = new Object();
			obj.accion = 'recuperarValoresUA';
			obj.oidUA = get("formulario.cbUnidadAdministrativa");
			objParamsInt.parametros = obj;
			setValues(objParamsInt ,'formularioEnvia' );

		}
		else {
			var arr = new Array();
			arr[arr.length] = 
			new Array("oidCliente", get("formulario.varOidCliente")+"");

			arr[arr.length] = 
			new Array("oidConcurso", get("formulario.oidConcurso")+""); 

			arr[arr.length] = 
			new Array("numeroConcurso", get("formulario.txtNumconcurso")+"");

			arr[arr.length] = 
			new Array("oidRegion", get("formulario.oidRegion")+""); 

			arr[arr.length] = 
			new Array("oidZona", get("formulario.oidZona")+"");

			arr[arr.length] = 
			new Array("oidSeccion", get("formulario.oidSeccion")+""); 
		  
			configurarPaginado(mipgndo,"INCBuscaConcursosConsultaIntegral", 
			"ConectorBuscaConcursosConsultaIntegral",
			"es.indra.sicc.dtos.inc.DTOCabeceraConsultaIntegral",arr);		
		}	
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

	function obtenerValoresRegistro() {

		var obj = new Object();

		listado1.actualizaDat();
		datos = listado1.datos;

		// Obtengo el índice de la fila marcada 
		//(en este punto, solo una estará marcada)
		var filaMarcada = obtenerPosicionListaEditable(listado1.codSeleccionados(),listado1);

		//1° Obtengo el oid de concurso
		var oidConcurso = datos[filaMarcada][1]; 

		//2° Obtengo el numero de concurso
		var numeroConcurso = datos[filaMarcada][2]; 

		//3° Obtengo el nombre de concurso
		var nombreConcurso = datos[filaMarcada][3]; 

		//4° Obtengo el oid de periodo inicial
		var oidPeriodoInicial = datos[filaMarcada][4]; 

		//5° Obtengo el codigo de periodo inicial
		var periodoInicial = datos[filaMarcada][5]; 

		//6° Obtengo el oid de periodo final
		var oidPeriodoFinal = datos[filaMarcada][6]; 

		//7° Obtengo el codigo de periodo final
		var periodoFinal = datos[filaMarcada][7]; 

		//8° Obtengo fase calificacion
		var faseCalificacion = datos[filaMarcada][9]; 

		//9° Obtengo el oid de base de calculo
		var oidBaseCalculo = datos[filaMarcada][10]; 

		//10° Obtengo multinivel
		var multinivel = datos[filaMarcada][11]; 		

		//11° Obtengo oidPlantilla
		var oidPlantilla = datos[filaMarcada][13]; 		
		
		obj.oidConcurso = oidConcurso;
		obj.numeroConcurso = numeroConcurso;
		obj.nombreConcurso = nombreConcurso;
		obj.oidPeriodoInicial = oidPeriodoInicial;
		obj.periodoInicial = periodoInicial;
		obj.oidPeriodoFinal = oidPeriodoFinal;
		obj.periodoFinal = periodoFinal;
		obj.faseCalificacion = faseCalificacion;
		obj.oidBaseCalculo = oidBaseCalculo;
		obj.multinivel = multinivel;
		obj.oidPlantilla = oidPlantilla;

		return obj;

	}

	function onClickboDetalle() {

		if (listado1.numSelecc()!=1) {
			GestionarMensaje('INC037',null,null,null);
		    return false;		
	    }	

		var obj = obtenerValoresRegistro();
		obj.varBotonPresionado = "detalle";
		var retorno = mostrarModalSICC('LPConsultaGeneralConcurso', 
		'direccionaPeticionDetalle', obj);

	}

	function obtenerValoresCriteriosBusqueda() {

		var obj = new Object();

		var busquedaCodClien = get("formulario.txtCodCliente");
		var busquedaOidClien = get("formulario.varOidCliente");
		var busquedaNomApe = get("formulario.tempNombreApellido");
		var busquedaNumConcu = get("formulario.txtNumconcurso");
		
		obj.busquedaCodClien = busquedaCodClien;
		obj.busquedaOidClien = busquedaOidClien;
		obj.busquedaNomApe = busquedaNomApe;
		obj.busquedaNumConcu = busquedaNumConcu;

		return obj; 

	}

	function onClickboPremiosProcesados() {		

		var obj = obtenerValoresCriteriosBusqueda();
		obj.varBotonPresionado = "premiosProcesados";
		var retorno = mostrarModalSICC('LPConsultaGeneralConcurso', 
		'direccionaPeticionDetalle', obj);

	}

	function onClickboRecomendacion() {		

		var obj = obtenerValoresCriteriosBusqueda();
		obj.varBotonPresionado = "recomendacion";
		var retorno = mostrarModalSICC('LPConsultaGeneralConcurso', 
		'direccionaPeticionDetalle', obj);

	}

	function onClickboPremiosSeleccionados() {

		var obj = obtenerValoresCriteriosBusqueda();
		obj.varBotonPresionado = "premiosSeleccionados";
		var retorno = mostrarModalSICC('LPConsultaGeneralConcurso', 
		'direccionaPeticionDetalle', obj);

	}

	function onClickboMotivosDescalificacion() {

		var obj = obtenerValoresCriteriosBusqueda();
		obj.varBotonPresionado = "motivosDescalificacion";
		var retorno = mostrarModalSICC('LPConsultaGeneralConcurso', 
		'direccionaPeticionDetalle', obj);

	}

	function ontabBotonBuscar() {

		if(document.getElementById("Detalle").style.visibility == "hidden") {
			focoCodigoCliente();
		}
		else {
			focalizaBotonHTML('botonContenido','Detalle');
		}

	}

	function onshtabCodigoCliente() {

		if(document.getElementById("Detalle").style.visibility == "hidden") {
			focoBotonBuscar();
		}
		else {
			focalizaBotonHTML('botonContenido','MotivosDescalificacion');
		}

	}

	function ontabBotonMotivos() {
		focoCodigoCliente();
	}

	function onshtabBotonDetalle() {
		focoBotonBuscar();
	}

	function focoBotonBuscar() {
		focalizaBotonHTML('botonContenido','btnBuscar');
	}

	function muestraLista(ultima, rowset, error){

		var tamano = rowset.length;
	
		if (tamano > 0) {
			mostrarListaResultados();
		    eval (ON_RSZ);
			focoBotonBuscar();
			return true;
		}
		else {
			ocultarLista();
			eval (ON_RSZ);
			focoBotonBuscar();
		    return false;
		}

		return true;

	}

	function clienteOnBlur() {
		var longiCod = get('formulario.hLongCliente');
		var elTexto  = get('formulario.txtCodCliente');

		if(elTexto.length!=0){
			var faltantes = longiCod -  elTexto.length;
			var resultCod = new String("");
			
			if(faltantes > 0){
				for(var t = 0 ; t<faltantes; t++){
					resultCod = resultCod + "0";
				}
			}
			
			resultCod = resultCod + elTexto;
			set('formulario.txtCodCliente', resultCod);
	   }

	}  

function setValues(objParams, formularioEnvia){
	if(objParams.parametros){

		var atributos;
		//Limpio todos los campos insertados del frm que envio
		eliminaElementosDinamicos(formularioEnvia);
		for(atributos in objParams.parametros){
			if(atributos != "window" && atributos != "length"){
				var hidden = document.createElement("INPUT");
				hidden.type = "hidden";
				hidden.insertado = "1";
				hidden.name = atributos;
				hidden.value = (objParams.parametros[atributos]==null)?"":objParams.parametros[atributos];
				document.forms[formularioEnvia].appendChild(hidden);
			}
		}
		set(formularioEnvia+'.conectorAction', objParams.conectorAction);
		enviaSICC(formularioEnvia);
	}
	
}

function eliminaElementosDinamicos(formularioEnvia){
	var elementos = document.forms[formularioEnvia].elements;
	var longitud = elementos.length;
	for ( i = 0;i < longitud; i++ ){
		var oChild=document.forms[formularioEnvia].children(i);	
		if (oChild!= null && oChild.insertado=="1"){
			document.forms[formularioEnvia].removeChild(oChild);
			i = i-1;
		}
	}
}