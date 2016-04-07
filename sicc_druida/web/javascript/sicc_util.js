//$Id: sicc_util.js,v 1.1 2009/12/03 19:01:33 pecbazalar Exp $

// pNombreBarra : Nombre de la barra
	// sEstadoBorrar : Estado de la barra para el boton borrar I, A 
	// sEstadoGuardar : Estado de la barra para el boton guardar I, A 
	/*function cargarBarra(pNombreBarra, sEstadoBorrar, sEstadoGuardar, sEstadoLimpiar)
	{
		parent.frames['iconos'].location.href="sicc0000jg?ON=LPCargarBarra&xml="+pNombreBarra+"&Borrar="+sEstadoBorrar + "&Guardar="+sEstadoGuardar + "&Limpiar=" + sEstadoLimpiar;
	} */
	
	
   /**
    * Esta funci�n devuelve la posicion del elemento del cual se recibe la clave.
    * La lista sobre la que aplica es de tipo "BOTON", y solo debe haber un elemento seleccionado.
    */

	//Variables de uso en las funciones genericas
	var varNoLimpiarSICC;
	var varNoInicializarListas;


	function fValidarCTEXT(pNombreControl){
		/*
		Parametros:
			pNombreControl = Es nombre completo del control. Ej: "form.NombreCTRL"

		retorna:
			true	-> si se ingresaron datos en el campo.
			false -> si NO se ingresaron datos en el campo.

		Nota:
			Se realizar un TRIM de los espacios
		*/
		var pValor = new String( get(pNombreControl) + "");

		if ( cdos_trim( pValor ) == "" ){
			GestionarMensaje('27',  pNombreControl);
			try{
				focaliza(pNombreControl,'');
			}
			catch(e){
			}
			return false;
		}
			
		return true;
	}


	function fValidarCOMBO(pNombreControl){
		/*
		Parametros:
			pNombreControl = Es nombre completo del control. Ej: "form.NombreCTRL"

		retorna:
			true	-> si se ingresaron datos en el campo.
			false -> si NO se ingresaron datos en el campo.

		Nota:
			La funci�n no realiza un TRIM() de los espacios.
		*/

        //alert("get(pNombreControl): " + get(pNombreControl));

		if ( get(pNombreControl) == '-1' || get(pNombreControl) == ""){
			GestionarMensaje('27',  pNombreControl);
			try{
				setTimeout('focaliza(\'' + pNombreControl + '\',\'\')', 100);
			}
			catch(e){
			
			}
			return false;
		}
		return true;
	}

/*********************************************
***********************************************/
function cdos_trim(valor) {
	var strValor = valor+"";
	return strValor.replace(/^\s+/g, '').replace(/\s+$/g, '');
}

	function fValidarNumero(valor, lon, rangoMin, rangoMax){
		/* 
			Parametros:
					-Valor: el valor a validar
					-lon: la longitud maxima
					-rangoMin : menor valor permitido
					-rangoMax : maximo valor permitido

			Returns:
				OK Si se pasa la validacion
				Formato del numero incorrecto si no pasa
		*/
		var x;
		x =  ValidaInt(valor, lon, rangoMin, rangoMax );
		y =  ValidaRango(valor, rangoMin, rangoMax);
		
		if (x!='OK'){
			return x;
		}

		if (y!='OK'){
			return y;
		}
		
		return 'OK'
	  }

	function fValidarNatural(valor, lon, rangoMin, rangoMax){
		/* 
			Parametros:
					-Valor: el valor a validar
					-lon: la longitud maxima
					-rangoMin : menor valor permitido
					-rangoMax : maximo valor permitido

			Returns:
				OK Si se pasa la validacion
				Formato del numero incorrecto si no pasa
		*/
		var x;
		x =  esNumero(valor);
		y =  ValidaRango(valor, rangoMin, rangoMax);
		
		if (x!='OK'){
			GestionarMensaje("747");
			return null;
		}

		if (y!='OK'){
			return null;
		}
		
		return 'OK'
	  }

	  function esNumero(orden){
		 var str=orden+"";
		 var RegInteger = /^\d+$/; //Solo numeros
		 if(!RegInteger.test(str)){
			return '-1';
		 }
		 return 'OK';
	  }

	/*
	 * Agregadas por compatibilidad de v2. rgiorgi - 23/03/2004
	 * */
	function fTrim(inputString){
	   return cdos_trim(inputString) ; 
	} 

	/*
	 * Agregadas por compatibilidad de v2. rgiorgi - 23/03/2004
	 * */
	function fFullTrim(inputString){
	   return cdos_trim(inputString); 
	} 


	/* 
			Parametros:
					-Valor: el valor a validar
					-ent: cantidad de la parte entera
					-dec : cantidad de la parte decimal
					-boleano : el booleano de validaFloat
					-min: rango minimo
					-max: rango maximo
					-obligatorio: si el campo viene ""

			Returns:
				OK Si se pasa la validacion
				Formato del numero incorrecto si no pasa
		*/
	 function fValidarFloat(valor, ent, dec, boleano, min, max, obligatorio){

		if ( (obligatorio) && (fTrim(valor)=="")){
			return GestionarMensaje("9");
		}

		if (fTrim(valor)==""){
			return 'OK';
		}

		var x,y;
		x =  ValidaFloat(valor, ent, dec, boleano );
		if (x!='OK'){
			return x;
		}

		y =  ValidaRango(parseInt(valor), min, max);
		if (y!='OK'){
			return y;
		}

		//return x==y?x:GestionarMensaje("000000000000002") ;
		return 'OK'
	  }

/********************************************************************************************/

   function obtenerPosicionLista(clave, lista){
      this.posicion = 0;
   
      if (lista.seleccion.longitud > 0){
      
         for(var k=0;k<lista.datos.longitud;k++) {
               if (lista.datos.ij(k,0) == clave) {
                  posicion=k;
                  break;
               }		            
			}         
      return posicion;
	   }

	}
	
	/**
    * Esta funcion muestra el error que llegua del servidor por pantalla
    */
	function fMostrarMensajeError( severidad ){
		/*
		Parametros:
			pErrCodigo -> El codigo de error.
			pErrDescrip-> La descripcion del error.
			
		Descripcion:
			Esta funci�n muestra la ventana modal con el mensaje de error que se paso
			a la p�gina.
			Llama a la LP LPPantallaError que a su vez muestra a PantallaError.xml.		

		Valores de retorno:
				1	->	Si se presiono en el boton <CANCELAR>
				0	->	Si se presiono en el boton <REINTENTAR>
				-1 -> Si no hubo errores.		
		*/

		var vWnd = false;
		var strFormName = getFormularioSICC();
		var strCodigo = get(strFormName+".errCodigo");
		var strMensaje  = get(strFormName+".errDescripcion");
		var strSeveridad = (severidad)?severidad:get(strFormName+".errSeverity");
		if ( (strMensaje != null && strMensaje.split(" ").join("") != "" )  || (strCodigo != null && strCodigo.split(" ").join("")!="" ) ){
			var sDescrip =new String(strMensaje + '');
			var sCodigo =new String(strCodigo + '');

			if ( sDescrip.length > 0 || sCodigo.length > 0  ){
				var parametrosError = new Object();
				parametrosError.errCodigo = sCodigo;
				parametrosError.errDescripcion = sDescrip;
				parametrosError.errSeveridad = strSeveridad;
				parametrosError.opener = window;
				vWnd = window.showModalDialog('../paginaError.html', parametrosError, 'dialogWidth:464px;dialogHeight:140px;status:no;scroll:no;help:no;resizable=no;');
				if (vWnd == 'CAUDI-CLOSE' || parseInt(strSeveridad,10)==9999) {
				    fSalirAplicacion(true);
				}
				
			}	
		}
		return vWnd;
	}
	

	/* Funcion para GestionarMensaje */	
	function cdos_mostrarAlert(pMensaje){
		var vWnd = -1;
		if ( pMensaje != null){
			var sDescrip =new String(pMensaje + '');
			if ( sDescrip.length > 0){
				var parametrosReturn = new Object();
				parametrosReturn.descripcionMensaje = sDescrip;//descripcionMensaje = sDescrip;
				parametrosReturn.opener = window;
				vWnd = window.showModalDialog('../paginaAlert.html', parametrosReturn, 'dialogWidth:464px;dialogHeight:140px;status:no;scroll:no;help:no;resizable=no;');
				//queda obsoleto, hablar con juan pablo bosnjak cualquier consulta vWnd = window.showModalDialog('sicc0000jg?ON=LPPantallaAlert', parametrosReturn, 'dialogWidth:464px;dialogHeight:140px;status:no;scroll:no;help:no;resizable=no;');
			}	
		}
		return vWnd;
	}

	/* Funcion para GestionarMensaje */	
	function cdos_mostrarConfirm(pMensaje){
		var vWnd = -1;
		if ( pMensaje != null){
	    var sDescrip =new String(pMensaje + '');
			if ( sDescrip.length > 0){
				var parametrosReturn = new Object();
				parametrosReturn.descripcionMensaje = sDescrip;
				parametrosReturn.opener = window;
				vWnd = window.showModalDialog('sicc0000jg?ON=LPPantallaConfirm', parametrosReturn, 'dialogWidth:464px;dialogHeight:140px;status:no;scroll:no;help:no;resizable=no;');
			}	
		}
		return vWnd;
	}


	/* Funcion para GestionarMensaje de Exito*/	
	function cdos_mostrarExito(pMensaje){
		var vWnd = -1;
		if ( pMensaje != null){
			var sDescrip =new String(pMensaje + '');
			if ( sDescrip.length > 0){
				var parametroExito = new Object();
				parametroExito.exito = GestionarMensaje('1459',null,null,null);
				parametroExito.exitoDescripcion = sDescrip;
				parametroExito.opener = window;
				vWnd = window.showModalDialog('../paginaExito.html', parametroExito, 'dialogWidth:464px;dialogHeight:140px;status:no;scroll:no;help:no;resizable=no;');
				//queda obsoleto, hablar con juan pablo bosnjak cualquier consulta vWnd = window.showModalDialog('sicc0000jg?ON=LPPantallaAlert', parametrosReturn, 'dialogWidth:464px;dialogHeight:140px;status:no;scroll:no;help:no;resizable=no;');
			}	
		}
		return vWnd;
	}


	/**
    * Esta funcion muestra el mensaje de Exito
    */
	function fMostrarMensajeExito(casodeuso){
		/*	
		Descripcion:
			Esta funci�n muestra la ventana modal con el mensaje de exito
	
		*/

		var vWnd = -1;		

		var parametroExito = new Object();
		parametroExito.exito = GestionarMensaje('958',null,null,null);		
		
		if ( casodeuso != null){
				var sDescrip =new String(casodeuso + '');
				if(sDescrip=='insertar'){
					parametroExito.exitoDescripcion = GestionarMensaje('988',null,null,null);
				}else if (sDescrip=='eliminar')
				{
					parametroExito.exitoDescripcion = GestionarMensaje('989',null,null,null);
				}
				else if (sDescrip=='modificar')
				{
					parametroExito.exitoDescripcion = GestionarMensaje('990',null,null,null);
				}

		} else {
			    parametroExito.exitoDescripcion = GestionarMensaje('951',null,null,null);
		}
		parametroExito.opener = window;
		vWnd = window.showModalDialog('../paginaExito.html', parametroExito, 'dialogWidth:464px;dialogHeight:140px;status:no;scroll:no;help:no;resizable=no;');
				
		if (vWnd == 'CAUDI-CLOSE') 
			top.location.href = '/'+APP_CONTEXT_ROOT+'/inicio.html';
		else if (vWnd == 1) {
			//var fecha = new Date();
			//fecha.setMinutes(fecha.getMinutes()+1);
			
			//setCookie('cookieSICC', 'true', fecha , '', '', '');
		}			
		

		return vWnd;
	}
	


	/*
	Funciones de soporte para el menu secundario
	******************************************
	*/
	function btnProxy(ordinalBoton, estadoBoton){
		parent.frames["iconos"].set_estado_botonera("btnBarra",ordinalBoton,convertEstado(estadoBoton));
	}

	function configurarMenuSecundario(strFrame){
		/*
			Este funcion se encarga de configurar la botonera, para ello
			parsea el contenido del var configuracion.
		*/
		//obtengo el String con la configuracion a aplicar

		var strCodigos = get(strFrame+".SICC_TOOLBAR_CONFIG");
		if(strCodigos!=null && strCodigos.split(" ").join("")!="" ){
			//obtengo un array con cada elemento configurable.
			//arrCodigos = strCodigos.split(",");
			strCodigos = strCodigos.split("[").join("");
			strCodigos = strCodigos.split("]").join("");
			var arrCodigos = strCodigos.split(",");
			var etiqueta;
			if((arrCodigos[0]+"")!="-1"){
                // Modificado por SICC20070322 - Rafael Romero - 24/07/2007
                var strTitulo = get(strFrame+".SICC_CUSTOM_TITTLE");
                var strTituloSep = get(strFrame+".SICC_CUSTOM_TITTLE_SEP");
                if(strTitulo==null) strTitulo = '';
                if(strTitulo.length > 0){
                    if(strTituloSep==null || strTituloSep.length == 0) strTituloSep = '   ';
                    strTitulo = strTituloSep + strTitulo;
                }
				etiqueta = document.title + strTitulo;
                // Fin modificado SICC20070322
			}else{
				etiqueta = "Belcorp";
			}
			var guardar = arrCodigos[1]+"";
			var volver = arrCodigos[2]+"";
			var salir = arrCodigos[3]+"";
			var borrar = arrCodigos[4]+"";
			var limpiar = arrCodigos[5]+"";
			var imprimir = arrCodigos[6]+"";
			var clave = arrCodigos[7]+"";
			var favoritos = arrCodigos[8]+"";
			var pais = arrCodigos[9]+"";
			var ayuda = arrCodigos[10]+"";
			
			//seteo el titulo
			parent.frames["iconos"].txt_to("etiqueta1",etiqueta);
			//seteo el estado de los botones
			btnProxy(1,guardar);
			btnProxy(2,volver);
			btnProxy(3,salir);
			btnProxy(4,borrar);
			btnProxy(5,limpiar);
			btnProxy(6,imprimir);
			btnProxy(7,clave);
			btnProxy(8,favoritos);
			btnProxy(9,pais);
			btnProxy(10,ayuda);
			parent.frames["iconos"].ocultarCapa();
		}
		parent.frames["iconos"].setActive(true);
	}
	function convertEstado(numero){
		numero = (numero+"").split(" ").join("");
		if((numero+'')=="1"){
			return "activo";
		}else{
			return "inactivo";
		}
	}

	function enviaSICC(form,action,target,valid) {
		//la deshabilitacion del menu secundario, ocurre solo
		//si la funcion envia termina correctamente.
		//queda por verificar si esto funciona en todos los casos
		var validarCampos;
		if(valid==null){//por defecto se quita la validacion de Druida.
			validarCampos = "N";
		}else{
			validarCampos = valid;
		}
		var salida = envia(form,action,target,validarCampos);
		//var salida = envia(form,action,target,valid);
		if(salida){
			try{
				parent.frames["iconos"].setActive(false);
			}catch(e){;}
		}
		return salida;
	}
	/*
	Fin de funciones de soporte para el menu secundario
	***********************************************
	*/


	function fFavoritos(){
		var formulario = getFormularioSICC();
		set(formulario+".accion","");
		set(formulario+".conectorAction","LPSeleccionarFuncionesFavoritas");
     	eval(formulario).oculto = 'N';
		enviaSICC(formulario,'','','N');
	}


	//Funci�n v2
	function fAyuda() {
		var objDummy = new Object();
		objDummy.opener = window;
		return window.showModalDialog('sicc0000jg?ON=LPPresentaAyuda', objDummy, 'dialogWidth:464px;dialogHeight:340px;status:no;scroll:no;help:no;resizable=no;');
	}
	
	//Funci�n v2
	function fSalir(booleanMensaje)
	{
		// MODIFICACION
		// Autor: Maximiliano Dello Russo (grusso)
		// Fecha: 07/12/2004
		// Motivo: Mostrar el mensaje indicado en el documento de requisitos generales v: 3.22
//		var vRet = GestionarMensaje('82',null,null,null);
		
		var vRet;
			
		if(booleanMensaje){
		   vRet = true;
		}else{
		   vRet = GestionarMensaje('1214',null,null,null);
		}

		if (vRet)	{
			//debugger
			/*mdolce agregado para la validacion de concurrencia en Cargos y Abonos Directos*/
			if(window.desbloquear){
			   window.desbloquear();
			//   window.onbeforeunload = null;
		       window.onunload = null;
			}
			
			var formulario = getFormularioSICC();
			set(formulario+".conectorAction","LPInicioBelcorp");
			set(formulario+".accion","");
			try{
				parent.frames['menu'].location.reload();
				parent.frames["iconos"].mostrarCapa();
			}catch(e){}
			eval(formulario).oculto = 'N';
			enviaSICC(formulario,'','','N');
		}		
	}
	
	//Funci�n v2
	function fImprimir(){
		parent.frames['contenido'].focus()
		parent.frames['contenido'].print();
		//window.print();
	}
	
	//Funci�n v2
	function fCambiarClave(){
		var obj = new Object();
		obj.modal = "1";
		currentwidth = 700;
		currentheight = 440;
		eval(formulario).oculto = 'N';
		obj.opener = window;
		return window.showModalDialog("../index_clave_acceso_cambiar.html",obj, 'dialogWidth:'+currentwidth+'px;dialogHeight:'+currentheight+'px;status:no;scroll:no;help:no;resizable=no;');		
		//mostrarModalSICC("LPCambiarClave", "", obj);
	}
	
	//Funci�n v2
	function fPais(){
		var formulario = getFormularioSICC();
		set(formulario+".conectorAction","LPCambiarPais");
		set(formulario+".accion","");
    	eval(formulario).oculto = 'N';
		enviaSICC(formulario,'','','N');
		
	}

	function fLimpiarGenericoSICC(){
		try{
			if(varNoLimpiarSICC==null){
				var formLocal = getFormularioSICC();
				drdOnLoad();
				var arrCombos = document.all.tags("SELECT");
				if(arrCombos.length){
					for(var i=0; i < d3_componentes.length; i++){
						if(d3_componentes[i][0]=="COMBO"){
							var strNombre = d3_componentes[i][1].split(".")[1];
							var objComboInicial = eval(d3_componentes[i][1]+"valorinicial");
							if (objComboInicial!= null){
								for(var j=0; j< arrCombos.length;j++){
									if(arrCombos[j].name && arrCombos[j].name.toUpperCase()==strNombre.toUpperCase()){
										for(var n=0; n<arrCombos[j].options.length;n++){
											if(arrCombos[j].options[n].value == objComboInicial){
												arrCombos[j].options[n].selected = true;
												break;
											}else{
												arrCombos[j].options[n].selected = false;
											}
										}
										break;
									}
								}
							}else{
								for(var j=0; j< arrCombos.length;j++){
									if(arrCombos[j].name && arrCombos[j].name.toUpperCase()==strNombre.toUpperCase()){
										arrCombos[j].selectedIndex = -1;
									}
								}
							}
						}/*else {
							if(d3_componentes[i][0]=="PAGINADO"){//vamos por las listas
								debugger;
								eval(d3_componentes[i][1]+".init()");
								if(varNoInicializarListas != true){
									eval(d3_componentes[i][1]+".setDatos(new Array())");
								}
							}
						}*/
					}
				}
			}
		}catch(e){
			alert(e.description);
		}
	}



	function getFormularioSICC(objWindow) {
		if(objWindow==null){
			objWindow = window;
		}
		var objs = objWindow.document.getElementsByTagName("INPUT");
		var formName = "";
		for(var i=0; i< objs.length;i++){
			var obj = objs[i];
			if(obj.type && obj.type.toUpperCase() == "HIDDEN"){
				if (obj.name && obj.name.toUpperCase()== "CONECTORACTION") {
				    formName = obj.parentElement.name;
					break;
				}
			}
		}
	    return formName;
	}


	function fnCheckKeys(){
		/*if (!parent) {
			return;
		}else{
			if (!parent.frames || !parent.frames["contenido"]) {
				return;
			}
		}*/
		var keyShift = event.shiftKey;
		var keyAlt = event.altKey;
		var keyCtrl = event.ctrlKey;
		var keyValue = event.keyCode;
		var keyText = String.fromCharCode(keyValue);

/*		alert("keyShift: " + keyShift);
		alert("keyAlt: " + keyAlt);
		alert("keyCtrl: " + keyCtrl);
		alert("keyValue: " + keyValue);
		alert("keyText: " + keyText);*/

		//debugger;

		if(keyShift){
			switch(keyValue){
				case 113://F2
					if(keyText == "q"){
						return clickButton(4);
					}
				case 114://F3
					if(keyText == "r"){
						return  clickButton(3);
					}
			}
		}else	if(keyCtrl){
			switch(keyValue){
				case 68://D
				case 73://I
				case 87://W
				case 82://R
				case 85://U
					event.returnValue = false;
					return false;
				case 80://P
					return clickButton(6);
				case 83://S
					return clickButton(1);
				case 118://F7
					if(keyText == "v"){
						return clickButton(7);                                                       
					}
				case 120://F9
					if(keyText == "x"){
						return clickButton(9);
					}
				case 123://F12
					if(keyText == "{"){
						//alert(document.location.protocol+"//"+document.location.host+"/sicc/grilla.html")
						window.open("/"+APP_CONTEXT_ROOT+"/grilla.html","",null);
						return true;
					}
					
			}                                  
		}else	if(keyAlt){
			switch(keyValue){                                                      
				case 37://IZQUIERDA
				case 39://DERECHA
					event.returnValue = false;
					return false;
				case 115://F4
					if(keyText == "s"){
						event.returnValue = false;
						return false;
					}
			}
		}else{
			switch(keyValue){
				case 112://F1
					if(keyText == "p"){
						return false;//clickButton(10);
					}
				case 113://F4 cambiado por F2
					if(keyText == "q"){
						return clickButton(2);
					}
				case 118://F7
					if(keyText == "v"){
						return clickButton(5);
					}
				case 117://F10 cambiado por F6
					if(keyText == "u"){
						resizeMenu();
						event.returnValue=false;
						event.cancelBubble=true;
						return false;
					}
				case 119://F8
					if(keyText == "w"){
						return clickButton(8);
					}
			}
		}
		return true;
	}

	function clickButton(number) {
	    var imagenes = parent.frames["iconos"].document.getElementsByTagName("IMG");
		for(var i=0; i< imagenes.length;i++){
			var imagen = imagenes[i];
			if (imagen.name && imagen.name.toUpperCase() == ("BTNBARRA"+number)) {
			    imagen.parentElement.click();
				break;
			}
		}
		return false;
	}

	function fnShowHelp() {
		event.returnValue = false;
		event.cancelBubble=true;
	    return clickButton(10);
	}

	/*
Agregada por: Marcelo Altaba
Autor: Gast�n Acevedo.
Fecha: 19/08/2003
Funci�n que inhabilita el tab cuando se agrega en la p�gina la siguiente funci�n:
document.body.onkeydown  = inhabilitaTab;

*/
function inhabilitaTab(){ 
     if(event.keyCode == 9){ 
          return false;
     }
     return true;
}



function mostrarModalSICC(lpDestino, accion, objParams, width, height){
	var objParamsInt = new Object();
	objParamsInt.opener = window;
	objParamsInt.destino = lpDestino;
	objParams.conectorAction= lpDestino;
	objParams.accion = accion;
	//objParams.window = window;
	objParamsInt.parametros = ((objParams==null)?new Object():objParams);
	currentwidth = (width==null)?'795':width+'';
	currentheight = (height==null)?'495':height+'';
	return window.showModalDialog("../index_generico.html",objParamsInt, 'dialogWidth:'+currentwidth+'px;dialogHeight:'+currentheight+'px;status:no;scroll:no;help:no;resizable=yes;minimize:yes;maximize:yes');
}


   /**
    * Esta funcion obtiene la posicion de la listaeditable
   */

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


		// Funcion: Validar que las fechas sean v�lidas y que fecha Desde sea menor a la de Hasta.
	// Realizado el: 03/02/2003.
	// Por: Hugo Mansi, Maximiliano Dello Russo
	function EsFechaValida(FechaDesde, FechaHasta, formName, igual) 
	{
		// Param igual: Si recibe valor "S", chequea que Desde sea menor que Hasta
		//					  Cualquier otro valor, permite menor o IGUAL
		// Devuelve:
		// 
		// 0 - Todo V�lido.
		// 1- Fecha inv�lida, Desde.
		// 2- Fecha inv�lida, Hasta.
		// 3- Desde mayor que Hasta.

	  var formatoFecha = get(formName + ".hFormatoFechaPais");
	  var delim  = obtieneDelimitador(formName);
  	  var fechaSpliteada = "";

	  // Valida que los campos no esten VACIOS.
//	  alert("(Valida campos vacios");
	  if ( !FechaDesde ){
//	    	alert("HOLA");	
	      return 1;
	  }
	  
	  if ( !FechaHasta ){
//		alert("CHAU");	
	  return 2;
	  }
//	  alert("Realiza el split");
	  FechaDesdeCortada = FechaDesde.split(delim);
	  FechaHastaCortada = FechaHasta.split(delim);  
	  fechaSpliteada = formatoFecha.split(delim);


		/*Agregado de Gaston Acevedo
			Aqui se valida que todos los caracteres en la fecha
			que no sean los separadores, sean numeros.
		*/
		var RegInteger = /^\d+$/; //Expresion regular que verifica la existencia de "solo numeros"
		var FechaDesdeCortadaTmp = FechaDesdeCortada.join("");
		var FechaHastaCortadaTmp = FechaHastaCortada.join("");
		if(!RegInteger.test(FechaHastaCortadaTmp)){
			return 2;
		}
		if( !RegInteger.test(FechaDesdeCortadaTmp)  ){
			return 1;
		}
		/*Fin del agregado de Gaston Acevedo*/	


//	  alert("FechaDesdeCortada: " + FechaDesdeCortada);
//	  alert("FechaHastaCortada: " + FechaHastaCortada);
//	  alert("fechaSpliteada  " + fechaSpliteada);

	  // Valida que haya las 3 partes de la fecha luego de splitear x el delimitador.
	  if ( FechaDesdeCortada.length != 3 ){
//		  alert("entro al if 1");
	      return 1;
	  }
	  if ( FechaHastaCortada.length != 3 ){
//		  alert("entro al if 2");
	  return 2;
	  }

  
		// Chequea cu�l es el a�o (Y o y), al resto (mes o dia, le agrega ceros si es necesario).
//	  alert("Chequea a�o");
	  var formatoArray = new Array(3);
	  for (var i = 0; i<3; i++ )
	  {
		  formatoArray[i] = parseaFormato(i, formName);
	  }	

//	  alert("formatoArray: " + formatoArray);

	 var diaMesAgno = "";
	 for (var i = 0; i<3 ; i++)
  	 {
		diaMesAgno = formatoArray[i];
		switch (diaMesAgno)
		{
		case 1:
			 NDiaD = FechaDesdeCortada[i];
	//		 alert("NDiaD = " + NDiaD); 
			 NDiaH = FechaHastaCortada[i];
			 break;
		case 2:
			 NMesD = FechaDesdeCortada[i];
	//		 alert("NMesD = " + NMesD);
			 NMesH = FechaHastaCortada[i];
			 break;
		case 3: 
		     NAnoD = FechaDesdeCortada[i];
	//		 alert("NAnoD = " + NAnoD);
			 NAnoH = FechaHastaCortada[i];
			 break;
		}
	 }

	  NDiaD = AgregaCero(NDiaD);
//	  alert("NDiaD: " + NDiaD );
	  NDiaH = AgregaCero(NDiaH);
	  NMesD = AgregaCero(NMesD);
//	  alert("NMesD: " + NMesD );
	  NMesH = AgregaCero(NMesH);


	  var longAgno = obtieneLongAgno(formName);
//	  alert("antes de validez");
	  if (NDiaD >31 || NMesD > 12 || NAnoD.length != longAgno){ 
//		   alert("ESTE ES ");	
		  return 1;  // Valores no validos en Desde. 
		  
	  }
	  // Menores que 0 se chequean en EsDiaValido + abajo.
//	  alert("Despues de validez");
	  if (NDiaH >31 || NMesH > 12 || NAnoH.length != longAgno) return 2;  // Valores no validos en Hasta. 


//		alert("antes de diavalido desde");
		
      if( ! EsDiaValido(parseInt(NDiaD, 10), parseInt(NMesD, 10), parseInt(NAnoD, 10)) ){
  // 		alert("ESTE ES OTRO");		  
		  return 1;

	 }



	//  alert("antes de diavalido hasta");
      if( ! EsDiaValido(parseInt(NDiaH, 10), parseInt(NMesH, 10), parseInt(NAnoH, 10)) ) return 2;
	 // alert("fdespues de dia valido");

	  var ND = NAnoD + NMesD + NDiaD;
	//  alert("Desde: " + ND);
	  var NH = NAnoH + NMesH + NDiaH;
	 // alert("Hasta: " + NH);

	 // by ssantana - cambio para diferenciar entre menor o menor e igual (x inc. 4883).
	 if (igual != "S")
	 {
		  if( parseInt(ND, 10) > parseInt(NH, 10) ) 
			   return 3
		  else
			   return 0;
	 } else
	 {
		  if( parseInt(ND, 10) >= parseInt(NH, 10) ) 
			   return 3
		  else
			   return 0;
	 }


    }

    // Funcion: Analiza si el a�o es bisiesto
	// Realizado el: 03/02/2003.
	// Por: Hugo Mansi, Maximiliano Dello Russo
  function EsBisiesto(anio){
    if (anio%100 == 0){
      if (anio%400 == 0){
        return true;
      }
      else{
        return false;
      }
    }
    else{
	  if (anio%4 == 0){ 
		return true;
	  }
	  else{
	    return false;
      }
    }
  }

    // Funcion: Analiza si el d�a es v�lido dentro del calendario Gregoriano.
	// Realizado el: 03/02/2003.
	// Por: Hugo Mansi, Maximiliano Dello Russo
  function EsDiaValido(dia, mes, anio){
	  var DiasMeses = new Array(12);

/*	  alert("EsDiaValido");
	  alert("Dia: " + dia + ", Mes: " + mes + ", A�o: " + anio);*/

	  DiasMeses[0]=31;
	  DiasMeses[1]=28;
	  DiasMeses[2]=31;
	  DiasMeses[3]=30;
	  DiasMeses[4]=31;
	  DiasMeses[5]=30;
	  DiasMeses[6]=31;
	  DiasMeses[7]=31;
	  DiasMeses[8]=30;
	  DiasMeses[9]=31;
	  DiasMeses[10]=30;
	  DiasMeses[11]=31;

	  if( mes <= 0 || dia <= 0 || anio <= 0 ) return false;

	  if( mes == 2 ) 
		  if( EsBisiesto(anio) ) DiasMeses[1]++;

	  if( dia <= DiasMeses[mes-1] ) return true;
	  else return false;

  }
	
    // Funcion: Utilitaria de la funcion EsFechaValida. 
	// Realizado el: 03/02/2003.
	// Por: Hugo Mansi, Maximiliano Dello Russo
  function AgregaCero(V) {

  
	 if ( V.length == 1)
		 return '0' + V
	 else
		 return V;

  }
	

   function obtieneDelimitador(formName)
   {
	   var formatoFechaUsuario = get(formName + ".hFormatoFechaPais");
	 //  1-1-2000
	   var numeros = "mMdDyY";
	   var c;
  	   
	   for(var i=0; i<formatoFechaUsuario.length; i++) 
			{
					c = formatoFechaUsuario.charAt(i);
					if (numeros.indexOf(c) == -1 ) 
						return c;
			}
			return false;
    }	


 function parseaFormato(indice, formName)
 {
	 // De acuerdo al indice que se le pasa (0, 1 o 2) y el formato de fecha actual, 
	 // devuelve:
	 //
	 //  -1  - Si es otro.  <----- No deber�a pasar
	 //   1  - Si es Dia
	 //   2  - Si es Mes
	 //   3  - Si es a�o

	 var formatoFechaUsuario = get(formName + ".hFormatoFechaPais");
	 // formatoFechaUsuario = "yyyy/mm/dd";  // Para testeo de formato.
	 var delim = obtieneDelimitador(formName);
	 var formatoSpliteado = formatoFechaUsuario.split(delim);
	 var campo = "";
	 var c = "";

	 campo = formatoSpliteado[indice];
	// alert("formatoSpliteado[" + indice + "]: " + campo);
	 c = campo.charAt(0);  // Trata de obtener el primer caracter (sea "m" o sea "MM" el campo, por ejemplo).
	 //alert("campo.charAt(0): " + c);

	 if ( c != "Y" && c != "y" )  // No es el a�o
	 {
		 if ( c != "d" && c != "D" )  // No es d�a
		 {
			 if ( c != "m" & c != "M")  // Tampoco es mes, asi que tira -1 (Error);
			 {	
				 return -1;
			 } else  // Es Mes
				 return  2;
		 } else  // Es Dia
			return 1;
	 } else  // Es A�o.
		 return 3;
  
 }


 function obtieneLongAgno(formName)
 {
     // Funcion que obtiene la longitud del campo A�O dentro del formato de fecha, para luego validar.
	 // Se cuenta 1 caracter por cada "y" o "Y" en este campo.

	 var formatoFechaUsuario = get(formName + ".hFormatoFechaPais");
	 var diaMesAgno = "";
	 var longCampoAgno = 0;

	 var delim = obtieneDelimitador(formName);
	 var formatoParseado = formatoFechaUsuario.split(delim);


	 for (var i = 0; i<3 ; i++ )
	 {
		  diaMesAgno = parseaFormato(i, formName);
		  if (diaMesAgno == 3)
		  {
			    // Obtiene la longitud del campo A�o. 
				longCampoAgno = formatoParseado[i].length;
           }
	 }
//	 alert("Longitud de Campo A�o: " + longCampoAgno);
	 return longCampoAgno;

 }


 function manejoErroresFechaValida(errorCode, controlDesde, controlHasta, formName) {
	 // Recibe el codigo de Error devuelto x la funcion EsFechaValida, el nombre de los controles
	 // Desde y Hasta. 
	 // Si hay error, genera el mensaje de error apropiado con GestionarMensaje, teniendo en cuenta los codigos 
	 // de error devueltos x EsFechaValida, y focaliza en el control correspondiente (desde o hasta).
	 // Devuelve true si no hubo errores., false si hubo alguno.

     var formatoFechaUsuario = get(formName + ".hFormatoFechaPais");
	 switch (errorCode)
	 {
	 case 0:  // No hay errores.
		 return true;
	 case 1:   // Error formato en Desde
		GestionarMensaje('1006', formatoFechaUsuario.replace(/y/g,'a') , null, null);
		focaliza(formName + "." + controlDesde, "");
		break;
	 case 2:	   // Error formato en Hasta.
		GestionarMensaje('1006', formatoFechaUsuario.replace(/y/g,'a'), null, null);
		focaliza(formName + "." + controlHasta, "");
		break;
	 case 3:   // Fecha DEsde Mayor que Fecha Hasta.
 		GestionarMensaje('1007', null, null, null);
		focaliza(formName + "." + controlDesde, "");
		break;
	 }

	 return false;

 }



function EsFechaValida_SICC(fecha, formName)
{
	  var formatoFecha = get(formName + ".hFormatoFechaPais");
	  var delim  = obtieneDelimitador(formName);
  	  var fechaSpliteada = "";

	  // Valida que fecha no est� no esten VACIO.
	  if ( !fecha )
			return false;
	  
	  FechaCortada = fecha.split(delim);
	  fechaSpliteada = formatoFecha.split(delim);

	  // Valida que haya las 3 partes de la fecha luego de splitear x el delimitador.
	  if ( FechaCortada.length != 3 )
		  return false;
  
		// Chequea cu�l es el a�o (Y o y), al resto (mes o dia, le agrega ceros si es necesario).
	  var formatoArray = new Array(3);
	  for (var i = 0; i<3; i++ )
	  {
		  formatoArray[i] = parseaFormato(i, formName);
	  }	

	 var diaMesAgno = "";
	 for (var i = 0; i<3 ; i++)
  	 {
		diaMesAgno = formatoArray[i];
		switch (diaMesAgno)
		{
		case 1:
			 NDiaD = FechaCortada[i];
			 break;
		case 2:
			 NMesD = FechaCortada[i];
			 break;
		case 3: 
		     NAnoD = FechaCortada[i];
			 break;
		}
	 }

	  NDiaD = AgregaCero(NDiaD);
	  NMesD = AgregaCero(NMesD);

	  var longAgno = obtieneLongAgno(formName);
	  
	  if (NDiaD >31 || NMesD > 12 || NAnoD.length != longAgno) return false;  // Valores no validos en Desde. 
																											  // Menores que 0 se chequean en EsDiaValido + abajo.

      if( ! EsDiaValido(parseInt(NDiaD, 10), parseInt(NMesD, 10), parseInt(NAnoD, 10)) ) return false;

	  var ND = NAnoD + NMesD + NDiaD;

	  return true;

}


function fSalirAplicacion(boolSinMensaje){ 
        var vRet = true; 
        if(!boolSinMensaje){ 
          vRet = GestionarMensaje('1212',null,null,null) 
        } 
        if (vRet)       { 
                //try{ 
                      var ventana = window; 
                      
                      while(ventana.parent && ventana.parent != ventana){ 
                        ventana = ventana.parent; 
                      } 
                      
                      //Ahora busco el opener 
                      try{ 
                        while(ventana.opener && ventana.opener != ventana){ 
                          ventana.close();                      
                          ventana = ventana.opener; 
                        } 
                      }catch(e){ 
                        //debugger; 
                      } 
                    try{ 
                      ventana.top.location.href = ventana.top.location.protocol+'//'+ ventana.top.location.host + '/'+APP_CONTEXT_ROOT+'/inicio.html';

                    }catch(e){ 
                      top.location.href = top.location.protocol+'//'+ top.location.host + '/'+APP_CONTEXT_ROOT+'/inicio.html';

                    } 
                //}catch(e){ 
                //      alert("error: "+e.description); 
                //} 
        } 

} 



function resizeMenu() {
	if(!window.dialogArguments){//Si no es una Ventana modal
		if (top.framesOn == true){//turn it off
			parent.document.all["frameMenu"].cols="19%,*";
			top.framesOn = false;
		}else{ //turn it on
			parent.document.all["frameMenu"].cols="0,*";
			top.framesOn = true;
		}
	}
}


/**
    * Esta funci�n focaliza botones que no tienen atributos X e Y
	* Ej: <BOTON nombre="btnBuscar" ID="botonContenido" tipo="html" ....
	* Para este bot�n se llamaria a:
	       focalizaBotonHTML('botonContenido','btnBuscar');
*/
function focalizaBotonHTML(IDBoton,NombreBoton){
		var btns=document.all[IDBoton];
		var elInput=null;

		if (!btns)
			return
		else if (!btns.length)   
			elInput=btns;
		else {
			for (var f=0; f<btns.length;f++)   {
				if (btns[f].name && btns[f].name==NombreBoton)   {
					 elInput=btns[f];
					 break;
				}
			}
		}

		if (elInput)
			elInput.focus();
	}

/**
    * Esta funci�n focaliza botones que tienen atributos X e Y
	* Ej: <BOTON nombre="Detalle" x="80" y="457" ID="botonContenido" tipo="html" ....
	* Para este bot�n se llamaria a:
	       focalizaBotonHTML_XY('Detalle');
*/
function focalizaBotonHTML_XY(NombreBoton){
		document.all[NombreBoton + "Div"].all.tags('input')[0].focus();
	}

/**
    * Esta funci�n habilita y deshabilita botones
	* Ej:  <BOTON nombre="btnBuscarProductoReemplazo" ID="botonContenido" tipo="html" ...
	* Para desahilitar este bot�n se llamaria a:
	*       deshabilitarHabilitarBoton('botonContenido','btnBuscarProductoReemplazo','D')
	* Para habilitar este bot�n se llamaria a:
	*       deshabilitarHabilitarBoton('botonContenido','btnBuscarProductoReemplazo','A')
*/
function deshabilitarHabilitarBoton(IDBoton,NombreBoton, accion){	
		var btns=document.all[IDBoton];
		var boton=null;

		if (!btns)
			return
		else if (!btns.length)
			boton=btns;
		else {
			for (var f=0; f<btns.length;f++)   {
				if (btns[f].name && btns[f].name==NombreBoton)   {
				  boton=btns[f];
				  break;
				}
			}
		}

		if (boton)
			if (accion=="A")
				boton.disabled = false;
			else if (accion=="D")
				boton.disabled = true;
			
 }

	/* valida decimales positivos(formato con separador de miles y de decimales)
	 * valor es una cadena con el numero decimal
	 * enteros -> numero de digitos que como m�ximo tendr� la parte entera
	 * decimales -> numero de digitos que como m�ximo tendr� la parte decimal
	 * separadorMiles -> car�cter de separador de miles
	 * separadorDecimales -> car�cter de separador de decimales
	 * min -> valor minimo que tendr� el n�mero
	 * max -> valor maximo que tendr� el n�mero (se puede omitir)
	 * devuelve el mensaje 'OK' si el numero decimal es valido, en caso contrario devuelve el mensaje de error a mostrar
	 */
	function ValidaMilesDecimales(valor, enteros, decimales, separadorMiles, separadorDecimales, min, max) {
		var ok;
		var valoresPrimario = null;
		if (ValidaCaracteres(valor,'0123456789' + separadorMiles + separadorDecimales)!='OK') {return DrdMsgCore(143) + separadorMiles + separadorDecimales + '0123456789';}
		
		//empieza por separadordecimales
		if (valor.indexOf(separadorDecimales) == 0) {return DrdMsgCore(101);}

		//termina por separadordecimales
		if (valor.indexOf(separadorDecimales) == valor.length-1) {return DrdMsgCore(101);}
		
		//empieza por separadormiles
		if (valor.indexOf(separadorMiles) == 0) {return DrdMsgCore(101);}

		//termina por separadormiles
		if (valor.indexOf(separadorMiles) == valor.length-1) {return DrdMsgCore(101);}
		
		valoresPrimario = valor.split(separadorDecimales);
		if (valoresPrimario.length > 0 && valoresPrimario.length < 3 && valoresPrimario[0].length > 0 ) {
			//parte entera no est� vac�a
			var valores = valoresPrimario[0].split(separadorMiles);
			if (valores.length > 1) {
				if (valores[0].length < 1 || valores[0].length > 3 ){return DrdMsgCore(101);}
				for (i = 1; i < valores.length; i++)
					if(valores[i].length != 3){return DrdMsgCore(101);}
			}
			var entornoSeparador = (separadorDecimales == ",")?true:false;
			var valorSinSeparadorMiles = valoresPrimario[0];
			while (valorSinSeparadorMiles.indexOf(separadorMiles) != -1) {
				valorSinSeparadorMiles = valorSinSeparadorMiles.replace(separadorMiles, '');
			}
			if (valoresPrimario.length == 2) {
				//comprobar si valoresPrimario[1] tiene el separador de miles, en ese caso devolvemos mensaje de error
				if (valoresPrimario[1].indexOf(separadorMiles)!=-1){
					return DrdMsgCore(101);
				}
				valorSinSeparadorMiles += separadorDecimales;
				valorSinSeparadorMiles += valoresPrimario[1];
			}
			ok=ValidaFloat(valorSinSeparadorMiles, enteros, decimales, entornoSeparador, min, max);

		} else {return DrdMsgCore(101);}
	
		return ok;
	}

	/* valida decimales positivos/negativos(formato con separador de miles y de decimales)
	 * valor es una cadena con el numero decimal
	 * enteros -> numero de digitos que como m�ximo tendr� la parte entera
	 * decimales -> numero de digitos que como m�ximo tendr� la parte decimal
	 * separadorMiles -> car�cter de separador de miles
	 * separadorDecimales -> car�cter de separador de decimales
	 * min -> valor minimo que tendr� el n�mero
	 * max -> valor maximo que tendr� el n�mero (se puede omitir)
	 * devuelve el mensaje 'OK' si el numero decimal es valido, en caso contrario devuelve el mensaje de error a mostrar
	 */
	function ValidaMilesDecimalesNegativo(valor, enteros, decimales, separadorMiles, separadorDecimales, min, max) {
		var ok;
		//empieza por signo -
		if (valor.indexOf('-') == 0) {
			valor = valor.replace ('-', '');
		}
		//aparece el caracter - en otro lugar
		if (valor.indexOf('-') != -1) {return DrdMsgCore(101);}
		if (ValidaCaracteres(valor,'0123456789' + separadorMiles + separadorDecimales)!='OK') {return DrdMsgCore(143) + separadorMiles + separadorDecimales + '-0123456789';}
		ok=ValidaMilesDecimales(valor, enteros, decimales, separadorMiles, separadorDecimales, min, max);

		return ok;
	}


	//convierte a numero decimal una cadena con formato de miles y decimales
	function obtieneNumeroDecimal(cadena, separadorDecimales) {
		//El if que se utiliza para verificar el contenido del parametro cadena ESTA MAL
		//ya que siempre debe verificarse el valor null por separado, ya que NULL != "" = True
		//Modificado por gacevedo 07/11/2005

		//if (cadena != "") {
		if(cadena!=null && cadena != ""){
			cadena = cadena+"";
			//eliminar separador de miles
			if (separadorDecimales == ".") {
				cadena = cadena.replace(/,/g,'');
			} else {
				cadena = cadena.replace(/\./g,'');
				//sustituir separador decimal por punto
				cadena = cadena.replace(/,/g,'.');
			}
			return (Math.round(Number(cadena) * 100) / 100)
		}
	}


	//formatea un decimal a cadena con separadores de miles, separador de decimales
	//el n�mero decimal debe tener la parte decimal en el formato adecuado
	function formateaImporte(numeroDecimal, separadorMiles, separadorDecimales){
		var dineroEntrada = "" + numeroDecimal;
		var negativo = false;
		if (dineroEntrada.indexOf('-') == 0) {
			dineroEntrada = dineroEntrada.replace('-', '');
			negativo = true;
		}
		var tokens = dineroEntrada.split('.');
		var bufferEntero = tokens[0];// almacena la parte entera.
		var bufferDinero = "";//almacena el resultado
		var bufferDecimales = "";//almacena la parte decimal
		if (tokens.length > 1)
			bufferDecimales = tokens[1];

		while (bufferEntero.length > 0) {
			if (bufferEntero.length > 3) {
				bufferDinero = separadorMiles + bufferEntero.substr(bufferEntero.length-3) + bufferDinero ;
				bufferEntero = bufferEntero.substr(0, bufferEntero.length-3);
			} else {
				bufferDinero = bufferEntero.substr(0) + bufferDinero ;
				bufferEntero = "";
			}
		}
		if (bufferDecimales != "") {
			if (bufferDecimales != "0" && bufferDecimales != "00") {
				bufferDinero = bufferDinero + separadorDecimales + bufferDecimales;
			}
		}
		if (negativo)
				bufferDinero = '-' + bufferDinero;
		return bufferDinero;
	}

function rellenaCeros(codigo,longitudMax,longitud) {
	if (Number(longitud) < Number(longitudMax)) {
		var diferencia = longitudMax - longitud;
		var ceros = '';
		for (var i=0; i<diferencia;i++) {
			ceros += '0';
		}
		var codigoCeros = ceros + codigo;
		return codigoCeros;
	} else {
		return codigo;
	} 		
}

/* Modificacion por ssantana, 24/08/2006 */
function redondea(numero,numeroDecimales) {
	// Se multiplica por 10**numeroDecimales y se redondea al enter0o mas cercano
	/*var potencia = Math.pow(10,2); */
	var potencia = Math.pow(10,  parseInt(numeroDecimales,10) );
	var numEntero = Math.round(numero * potencia);

	// Se divide por 10**numeroDecimales
	var resultado = numEntero / potencia;
	return resultado;
}
/* Fin Modificacion por ssantana, 24/08/2006 */

function focalizaLista(indiceFila, nombreListado, nombreCajaTexto) {
	if (nombreListado == null) {
		nombreListado = 'listado1';
	}
   	
   	if (nombreCajaTexto == null) {
   		nombreCajaTexto = 'Texto1';
   	}
   	
   	eval(nombreListado+'.preparaCamposDR()');
	focaliza('frm'+nombreListado+'.'+nombreCajaTexto+'_'+indiceFila,''); 
}

function ordenaCombo_SICC(combo) {  
	var Textos = new Array();
	var Valores = new Array();
	var n = combo.options.length;
	
	for(i=0; i<n; i++) {
		Textos[i] = combo.options[i].text; 
		Valores[i] = combo.options[i].value; 
	}  
	
	for (i=0; i<n; i++) {    
		for (j=0; j<n-i; j++)      
			if (Textos[j+1] < Textos[j]) {
				tmp = Textos[j]; 
				Textos[j] = Textos[j+1]; 
				Textos[j+1] = tmp; 
				tmp = Valores[j]; 
				Valores[j] = Valores[j+1]; 
				Valores[j+1] = tmp; 
			}  
	}  
	
	for(i=0; i<n; i++) {
		combo.options[i] = null;
	}  
	
	for(i=0; i<n; i++) {
		combo.options[i] = new Option(Textos[i],Valores[i]); 
	} 
}

/*
* Formatea un numero con formato SICC a Number, para validaciones JS.
* !!El formato no se esta usando en el metodo
*/
function numeroDeFormatoSICC(numero, formatoDelNumero){  
	var formulario_local = getFormularioSICC();
    var separadorDecimal = get(formulario_local+".hSeparadorDecimalPais");
	var separadorMiles = get(formulario_local+".hSeparadorMilesPais");    

	numeroFormateado = replaceString(separadorMiles,"",numero);
	numeroFormateado = replaceString(separadorDecimal,".",numeroFormateado);
	
	return Number(numeroFormateado);
}



/* 
* Formatea un Number a formato SICC, para ser visualizado.
* @autor gdmarzi
* 12/09/06 se agrega parametro sinDecSiNoTiene para que a los enteros no les ponga .0 si uno no quiere
* sinDecSiNoTiene - valores 'S' o 'N' o nada y no hace nada en ese caso
*/
function numeroAsFormatoSICC(numero, sinDecSiNoTiene) {
    var formulario_local = getFormularioSICC();
	var separadorDecimal = get(formulario_local+'.hSeparadorDecimalPais');
	var separadorMiles = get(formulario_local+'.hSeparadorMilesPais');
	var numeroStr = new String(numero);
	var arrEnteroDecimal = numeroStr.split(".");
	//forma parte decimal
	if (arrEnteroDecimal.length == 1) {
		var decimal = "0";
		separadorDecimal = ".";
	} else {
		var decimal = arrEnteroDecimal[1];
	}
	//forma parte entera
	var entero = arrEnteroDecimal[0];
	var enteroConSeparadores;
	if (entero.length > 3) {
		var entero = reverse(entero);
		//tomo los primero tres elementos
		enteroConSeparadores = entero.substr(0,3);
		//agregs los separador de miles necesarios
		for(var i=3; i < entero.length;i+=3) {
			enteroConSeparadores = enteroConSeparadores + separadorMiles + entero.substr(i,3);
		}
		enteroConSeparadores = reverse(enteroConSeparadores);
	} else {
		enteroConSeparadores = entero;
	}

	var numeroFormateadoPais;
	//une la parte enetera formateada con el separador de decimales y la parte decimal
	if (arrEnteroDecimal.length == 1&&sinDecSiNoTiene=='S') {
		numeroFormateadoPais = enteroConSeparadores;
	} else {
		numeroFormateadoPais = enteroConSeparadores + separadorDecimal + decimal;         
	}
	return numeroFormateadoPais;
}


// Replaces oldS with newS in the string fullS   
function replaceString(oldS,newS,fullS) {
	for (var i=0; i<fullS.length; i++) {     
		if (fullS.substring(i,i+oldS.length) == oldS) {    
			 fullS = fullS.substring(0,i)+newS+fullS.substring(i+oldS.length,fullS.length)    
		}  
	}  
	return fullS
}

// Retorna un arreglo de strings en orden inverso sus elementos
function reverse(str) {
	var revertido = new String("");
	for(var i=str.length-1; i >= 0; i--) {
		revertido = revertido + str.charAt(i);
	}
	return revertido;        
}


function validaFormatoHora(hora)
{
		// Valida hora con el formato establecido para la hora: HH:mm (Hora de 0 a 23, min de 00 a 59, ":" separa ambos numeros)
		var horaArray = hora.split(":");

		if (horaArray.length != 2)
			return false;

		// ------------------------- Hora ------------------------------------------------------------------------------------
		// Valida que hora sea un numero y de 1 o 2 digitos.
		if (esNumero(horaArray[0]) == -1 || (horaArray[0].length != 1 && horaArray[0].length != 2))
			return false;

		// Valida que hora este entre 0 y 23
		if ( parseInt(horaArray[0], 10) > 23 )
					return false;

		// ---------------------------------- Minutos ----------------------------------------------------
		// Valida que minuto sea numerico y tenga 2 digitos siempre
		if ( esNumero(horaArray[1]) == -1 || horaArray[1].length != 2)
					return false;

		// Valida que minuto este entre 0 y 59
		if ( parseInt(horaArray[1], 10) > 59 )
					return false;

		return true;

}


/* ------------------------------------------------------------------------------------------------------------------------------------------------------------- */
/* Agregado de ssantana, 10/04/2006 */ 
function SICC_DrdEscHTML (cad) {
   if (cad!=null){
       cad=cad+"";
	   cad = cad.replace(/&/gi, "&amp;").replace(/\'/gi, "&apos;");
	   return DrdEscHTML (cad);
   }
   return "";
}

/* ------------------------------------------------------------------------------------------------------------------------------------------------------------- */
/* Agregado de ssantana, 10/04/2006 */ 
function SICC_DrdEscXML (cad) {
   if (cad!=null){
      cad=cad+"";
	  cad = cad.replace(/&/gi, "&amp;").replace(/\'/gi, "&apos;");
	  return DrdEscXML (cad);
   }
   return "";
}

/*Gacevedo para la busqueda generica*/
function abrirBusquedaGenerica(datos, accion, titulo){
	var objParams = new Object();
	var strAccion = "";
	objParams.titulo = titulo;
	if(accion!=null){
		strAccion = accion;
	}
	objParams.accion=strAccion;
	if(datos){
		objParams.datos = datos;
	}
	return mostrarModalSICC("LPBusquedaGenerica",strAccion,objParams);
}
