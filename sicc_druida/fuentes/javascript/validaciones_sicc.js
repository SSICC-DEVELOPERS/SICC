/*
	- Estas validaciones son genericas y han de aplicarse mediante el mecanismo de inclusion del tag 
		VALIDACION en las paginas donde se requiera.
	
	- Todas las funciones devuelven true o false, segun el resultado de la validacion.
	- Todas las funciones que fallen en la validacion focalizan el campo procesado y se muestran el mensaje correspondiente
*/

//los objetos a validar pueden agruparse, por lo que es
//posible utilizar el grupo para validar solo aquellos
//objetos que pertenezcan al mismo, utilizando para ello
//el parametro strGrupos que es la lista de grupos a validar, 
//separados por coma o vacio si se quiere procesar todo.

//objValidante("txtFechaInicio",true,"Texto","","","","Fecha inicio","grupo1")


function objValidante(nombre, requerido, formato, maximo, minimo, caracteres, mostrar,grupo){
	this.nombre=nombre;
	this.requerido=requerido;
	this.formato=formato;
	this.maximo=maximo;
	this.minimo=minimo;
	this.caracteres=caracteres;
	this.mostrar=mostrar;
	this.grupo=grupo;
}


function sicc_validaciones_generales(strGrupos) {
	var obj;
	var objGrupos = new Object();
	if(strGrupos!=null){
		var arrGrupos = strGrupos.split(",");
		for(var i=0;i<arrGrupos.length;i++){
			var nombreGrupo = arrGrupos[i].split(" ").join("");
			eval("objGrupos."+nombreGrupo+"=\"\"");
		}
	}
	var largo = objValidacionSICC.length;
	for(var i = 0; i<largo;i++){
		obj = objValidacionSICC[i];
		if(strGrupos==null){//no se usa el grupo
			
			if(!sicc_efectuarValidacion(obj)){
				return false;
			}
		}else{
			if(obj.grupo!="" && eval("objGrupos."+obj.grupo)!=null){//me fijo si es parte del grupo
				if(!sicc_efectuarValidacion(obj)){
					return false;
				}
			}
		}
	}
	return true;
}
//********************************************************//
//********************************************************//
//********************************************************//
function sicc_efectuarValidacion(obj) {
	if(obj.requerido){
		if(!sicc_valida_requerido(obj.nombre, obj.mostrar)){
			return false;
		}
	}
	if(obj.formato=="Numerico" || obj.formato=="Moneda" || obj.formato=="MonedaAlternativa" || obj.formato=="Entero"){
		if(!sicc_valida_numero(obj.nombre, obj.mostrar, obj.minimo, obj.maximo, obj.formato)){
			return false;
		}
	}else	if(obj.formato=="Texto"){
		if(!sicc_validarTexto(obj.nombre, obj.mostrar, obj.caracteres, obj.minimo, obj.maximo)){
			return false;
		}
	}else	if(obj.formato=="Fecha"){
		//if(!sicc_validar_fecha(obj.nombre, obj.mostrar, obj.minimo, obj.maximo, "dd/mm/yyyy")){
		if(!sicc_validar_fecha(obj.nombre, obj.mostrar, obj.minimo, obj.maximo)){
			return false;
		}
	}
	return true
}

//********************************************************//
//********************************************************//
//********************************************************//
function sicc_valida_requerido(strName, strMostrar) {
	var strValor = get(getFormularioSICC()+"."+strName);
	if(strValor==null){
		strValor="";
	}else{
		if((typeof(strValor)).toUpperCase() == "OBJECT"){
			strValor = strValor.toString();
		}else{
			strValor+="";
		}
	}
	strValor = strValor.split(" ").join("");
	if(strValor==""){
		cdos_mostrarAlert(GestionarMensaje("1534" ,  strMostrar));
		sicc_focaliza_componente(strName);
		return false;    
	}
    return true;
}
//********************************************************//
//********************************************************//
//********************************************************//
function sicc_valida_numero(strName, strMostrar, valorMinimo, valorMaximo, tipo) {
	var formulario_local = getFormularioSICC();
	var valorTest = get(formulario_local+"."+strName);
	if(valorTest==""){
		return true;
	}
	var strSepDec = "";
	var strSepMil = "";
	var strCantDec = "";

	switch(tipo){
		case "Numerico":
			strCantDec="2";
			strSepDec = get(formulario_local+".hSeparadorDecimalPais");
			strSepMil = get(formulario_local+".hSeparadorMilesPais");
			break;
		case "Entero":
			strCantDec="0";
			strSepDec = get(formulario_local+".hSeparadorDecimalPais");
			strSepMil = get(formulario_local+".hSeparadorMilesPais");
			break;
		case "Moneda":
			strCantDec = get(formulario_local+".hCantidadDecimalesPais");
			strSepDec = get(formulario_local+".hSeparadorDecimalPais");
			strSepMil = get(formulario_local+".hSeparadorMilesPais");
			break;
		case "MonedaAlternativa":
			strCantDec = get(formulario_local+".hCantidadDecimalesAlternativos");
			strSepDec = get(formulario_local+".hSeparadorDecimalAlternativo");
			strSepMil = get(formulario_local+".hSeparadorMilesAlternativo");
			break;
	}
	

	//aca normalizo la cantidad de decimales, ya que nada me asegura
	//que el formato admita decimales, aunque seria lo logico.
	//Si la cantidad de decimales no es un numero valido, entonces es cero.
	if(isNaN(parseInt(strCantDec,10))){
		strCantDec = 0;
	}else{
		strCantDec=parseInt(strCantDec,10);
	}

	//Primero me fijo si es un numero, para eso
	//le saco todos los separadores
	var strCleaned = valorTest.split(strSepDec).join("");
	strCleaned = strCleaned.split(strSepMil).join("")+"";
	
	if(!parseInt(strCleaned.substr(0,1),10) && parseInt(strCleaned.substr(0,1),10)!=0){//si el primero no es un numero, puede ser solo el simbolo negativo
		if(strCleaned.substr(0,1)!="-"){
			cdos_mostrarAlert(GestionarMensaje("000000000000100" ,  strMostrar));
			sicc_focaliza_componente(strName);
			return false;
		}else{//tambien lo saco para testear el numero
			strCleaned = strCleaned.substr(1);
		}
	}

	var RegInteger = /^\d+$/; //Solo numeros
	if(!RegInteger.test(strCleaned)){
		cdos_mostrarAlert(GestionarMensaje("000000000000100" ,  strMostrar));
		sicc_focaliza_componente(strName);
		return false;
	}
	
	//Ahora se que es un numero, primero valido los decimales
	//el ultimo debe ser un numero
	if(isNaN(parseInt(valorTest.substr(valorTest.length-1),10))){
			cdos_mostrarAlert(GestionarMensaje("000000000000100" ,  strMostrar));
			sicc_focaliza_componente(strName);
			return false;
	}

	//me fijo el largo de los decimales
	var arrTest = valorTest.split(strSepDec);
	if(arrTest.length ==2 && arrTest[1]!=null && arrTest[1]!=""){//si tiene decimales
		if(parseInt(strCantDec,10)==0){
			cdos_mostrarAlert(GestionarMensaje("000000000000104"));
			sicc_focaliza_componente(strName);
			return false;
		}
		var strDecimales = arrTest[arrTest.length-1]+"";
		if(strDecimales.length > parseInt(strCantDec,10)){//me fijo cuantos son
			cdos_mostrarAlert(GestionarMensaje("000000000000101" ,  strMostrar,parseInt(strCantDec,10)));
			sicc_focaliza_componente(strName);
			return false;
		}
	}else{
		if(arrTest.length > 2){//sino
			cdos_mostrarAlert(GestionarMensaje("000000000000102" ,  strMostrar));
			sicc_focaliza_componente(strName);
			return false;
		}
	}
	//ahora voy por la parte entera

	var strInteger = arrTest[0]+"";
	
	if(strInteger.indexOf(strSepMil) >- 1){//si tiene separadores de miles
		var arrInteger = strInteger.split(strSepMil);
		//en todo el array los numero son de a 3 digitos
		//excepto en la primera posicion, 
		//donde solo no pueden ser 4 digitos
		for(var i=0; i < arrInteger.length; i++){
			if(i==0){
				if((arrInteger[i]+"").length>3){
					cdos_mostrarAlert(GestionarMensaje("000000000000100" ,  strMostrar));
					sicc_focaliza_componente(strName);
					return false;
				}
			}else{
				if((arrInteger[i]+"").length!=3){
					cdos_mostrarAlert(GestionarMensaje("000000000000105",strSepMil));
					sicc_focaliza_componente(strName);
					return false;
				}
			}
		}
	}


	//por ultimo valido el rango del valor
	//saco el separador de miles
	var strNumeroTest = valorTest.split(strSepMil).join("");
	//si el separador decimal es el punto, lo dejo, sino, lo reemplazo por el punto
	if(strSepDec!="."){
		strNumeroTest  = strNumeroTest.split(strSepDec).join(".")
	}
	
	if(valorMinimo!=""){
		if(parseFloat(strNumeroTest )<parseFloat(valorMinimo)){
			cdos_mostrarAlert(GestionarMensaje("000000000000103" ,  strMostrar,parseFloat(valorMinimo),parseFloat(valorMaximo)));
			sicc_focaliza_componente(strName);
			return false;
		}
	}	
	if(valorMaximo!=""){
		if(parseFloat(strNumeroTest)>parseFloat(valorMaximo)){
			cdos_mostrarAlert(GestionarMensaje("000000000000103" ,  strMostrar,parseFloat(valorMinimo),parseFloat(valorMaximo)));
			sicc_focaliza_componente(strName);
			return false;
		}
	}
	return true;
}
//********************************************************//
//********************************************************//
//********************************************************//
function sicc_validarTexto(strName, mostrar, caracteres,minimo, maximo) {
	var strValor = get(getFormularioSICC()+"."+strName);
	if(strValor==""){
		return true;
	}
	//valido el largo del string.
	var largoString = strValor.length;

	//normalizo los valores minimos y maximos para la longitud del string
	if(isNaN(parseInt(minimo,10)) || parseInt(minimo,10) < 0){
		minimo = 0;
	}else{
		minimo=parseInt(minimo,10);
	}
	if(isNaN(parseInt(maximo,10)) || parseInt(maximo,10) < 0){
		maximo = 99999;
	}else{
		maximo = parseInt(maximo,10);
	}
	//si el minimo y maximo son cero ambos, significa que no 
	//debe efectuarse esta validacion
	if(minimo!=0 || maximo !=0){
		if(minimo > maximo){
			//aca se deja el alert, porque este error soslo debe ocurrir 
			//durante la fase de construccion.
			alert("el valor minimo de la validacion no puede ser superior al maximo");
			return false;
		}
		if(largoString < minimo){
			cdos_mostrarAlert(GestionarMensaje("000000000000007")+" "+minimo);
			sicc_focaliza_componente(strName);
			return false;
		}
		if(largoString > maximo){
			cdos_mostrarAlert(GestionarMensaje("000000000000006")+" "+maximo);
			sicc_focaliza_componente(strName);
			return false;
		}
	}
	//valido el rango de caracteres
	if(caracteres!=""){
		var expression = null;
		try{
			//se crea la expresion regular que indica los caracteres validos
			expression = new RegExp("[^"+caracteres+"]","gi");
		}catch(e){;}
		if(expression==null){
			//aca se deja el alert, porque este error soslo debe ocurrir 
			//durante la fase de construccion.
			alert("La expresion regular no es valida");
			return false;
		}
		if(expression.test(strValor)){//significa que el texto tiene caracteres no validos
			var agregar = "";
			if(caracteres.indexOf(String.fromCharCode(92)+String.fromCharCode(92))>-1){
				agregar = String.fromCharCode(92);
			}
			cdos_mostrarAlert(GestionarMensaje("000000000000003")+caracteres.split(String.fromCharCode(92)).join("")+agregar);
			sicc_focaliza_componente(strName);
			return false;
		}
	}
	return true;
}
//********************************************************//
//********************************************************//
//********************************************************//

function sicc_validar_fecha(strName, mostrar, fecha_desde, fecha_hasta, formatoFechaUsuario) {
	//esta funcion valida fechas, convirtiendo los strings a fechas de javascript
	//y validando tanto la existencia como el rango de la fecha. Se asume que el
	//formato de las fechas minimas y maximas seran dd/mm/yyyy.
	var strValor = get(getFormularioSICC()+"."+strName);
	if(strValor==""){
		return true;
	}

	var arrFormato = null;
	var arrFecha = null;
	var separador = "";

	var strValorFormatoFechaPais = get(getFormularioSICC()+".hFormatoFechaPais");

	if (formatoFechaUsuario == null || formatoFechaUsuario == ""){

		if( strValorFormatoFechaPais == "" ){
			formatoFechaUsuario = "dd/mm/yyyy";
		} else {
			formatoFechaUsuario = strValorFormatoFechaPais;
		}

	}
	
	if(formatoFechaUsuario.indexOf("/")>-1){
		separador = "/";
		arrFormato = formatoFechaUsuario.split("/");
		arrFecha = strValor.split("/");
	}else{
		separador = "-";
		arrFormato = formatoFechaUsuario.split("-");
		arrFecha = strValor.split("-");
	}

	//para ser valida la fecha permite 3 valores (dia, mes, anio)
	if(arrFecha.length != 3){
		//cdos_mostrarAlert(GestionarMensaje("000000000000031")+ formatoFechaUsuario.replace(/y/g,'a') +GestionarMensaje("000000000000032"));
		GestionarMensaje("1006", formatoFechaUsuario.replace(/y/g,'a'));
		sicc_focaliza_componente(strName);
		return false;
	}

	//valido los caracteres de la fecha
	if(!sicc_caracteres_fecha_validos(strValor,separador)){
		cdos_mostrarAlert(GestionarMensaje("000000000000025"));
		sicc_focaliza_componente(strName);
		return false;
	}
	//ahora trabajo con la fecha
	var dia, mes, anio;
	for(var i=0; i < arrFormato.length;i++){
		switch(arrFormato[i]){
			case 'dd':
				dia = arrFecha[i];
				break;
			case 'mm':
				mes = arrFecha[i];
				break;
			default:
				anio = arrFecha[i];
				break;
		}
	}

	//en cada variable tengo la parte de la fecha que corresponde, por lo que valido
	//primero el formato, luego la validez, por ultimo el rango
	if(dia.length!=2){
		cdos_mostrarAlert(GestionarMensaje("000000000000028"));
		sicc_focaliza_componente(strName);
		return false;
	}
	if(mes.length!=2){
		cdos_mostrarAlert(GestionarMensaje("000000000000029"));
		sicc_focaliza_componente(strName);
		return false;
	}
	if(anio.length != 4){
		cdos_mostrarAlert(GestionarMensaje("000000000000030"));
		sicc_focaliza_componente(strName);
		return false;
	}

	//el mes no puede ser superior a 12 ni menor que 1
	if(parseInt(mes,10) < 1 || parseInt(mes,10) > 12){
		cdos_mostrarAlert(GestionarMensaje("000000000000036"));
		sicc_focaliza_componente(strName);
		return false;
	}

	var diaMaximo =0;
	switch(parseInt(mes,10)){
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			diaMaximo = 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			diaMaximo = 30;
			break;
		case 2:
			if(sicc_anio_bisiesto(anio)){
				diaMaximo = 29;
			}else{
				diaMaximo = 28;
			}
	}
	
	if(parseInt(dia,10) < 1 || parseInt(dia,10) > parseInt(diaMaximo,10)){
		cdos_mostrarAlert(GestionarMensaje("000000000000037")+diaMaximo);
		sicc_focaliza_componente(strName);
		return false;
	}

	//se presupone que si existen fecha limite, las mismas
	//seran correctas, por lo que no se hacen todas las validaciones a las mismas.
	//Las fechas limite se esperan en formato dd/mm/yyyy

	var oDate = new Date(anio, parseInt(mes,10)-1, dia);

	if(fecha_desde!= null && fecha_desde != "" && fecha_desde!="0"){
		arrFechaDesde = fecha_desde.split("/");
		var oDateDesde = new Date(arrFechaDesde[2], parseInt(arrFechaDesde[1],10)-1, arrFechaDesde[0]);
		if(oDate < oDateDesde){
			cdos_mostrarAlert(GestionarMensaje("000000000000012")+fecha_desde);
			sicc_focaliza_componente(strName);
			return false;
		}
	}

	if(fecha_hasta!= null && fecha_hasta != "" && fecha_hasta != "0"){
		arrFechaHasta = fecha_hasta.split("/");
		var oDateHasta = new Date(arrFechaHasta[2], parseInt(arrFechaHasta[1],10)-1, arrFechaHasta[0]);
		if(oDate > oDateHasta){
			cdos_mostrarAlert(GestionarMensaje("000000000000013")+fecha_hasta);
			sicc_focaliza_componente(strName);
			return false;
		}
	}
	return true;
}
//********************************************************//
//********************************************************//
//********************************************************//
function sicc_anio_bisiesto(anio) {
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
//********************************************************//
//********************************************************//
//********************************************************//
function sicc_caracteres_fecha_validos(valorFecha, separador) {
    	//los caracteres permitidos para 
		//la fecha son numeros y el separador, solamente
	var RegInteger = /^\d+$/; //Expresion regular que verifica la existencia de "solo numeros"
	var FechaTmp = valorFecha.split(separador).join("");
	return RegInteger.test(FechaTmp)
}
//********************************************************//
//********************************************************//
//********************************************************//
function sicc_focaliza_componente(strName){
	var strFoc = 'try{focaliza(\''+getFormularioSICC()+"."+strName+'\',\'\')}catch(e){;}';
	window.setTimeout(strFoc,200);
}
//********************************************************//
//********************************************************//
//********************************************************//
function sicc_obtenerDescripcion(objName) {
	var largo = objValidacionSICC.length;
	var descripcion = "";
	for(var i = 0; i<largo;i++){
		if(objValidacionSICC[i].nombre == objName){
			descripcion = objValidacionSICC[i].mostrar;
			break;
		}
	}
    return descripcion;
}
//********************************************************//
//********************************************************//
//********************************************************//
function sicc_cambiar_estado(strNombre, estado) {
	var obj;
	var largo = objValidacionSICC.length;
	for(var i = 0; i<largo;i++){
		obj = objValidacionSICC[i];
		if(obj.nombre == strNombre){
			obj.requerido = estado;
			if(estado) {
				  setMV(getFormularioSICC()+"."+strNombre,"S")  ;
			}else{
				setMV(getFormularioSICC()+"."+strNombre,"N")  ;
			}
			break;
		}
	}
}

// -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

// --------------------------------------------------------------------------------------------
// Modif. a funciones existentes para listas editables by SSantana
// --------------------------------------------------------------------------------------------
function sicc_valida_numero_LE(strName, strMostrar, valorMinimo, valorMaximo, tipo, listName, posCol) {
	var formulario_local = getFormularioSICC();
	var datos = eval(listName + ".datos;");

	for (var contador = 0; contador < datos.length; contador++ ) {
					var valorTest = datos[contador][posCol];

					if (valorTest != "") {
								var strSepDec = "";
								var strSepMil = "";
								var strCantDec = "";

								switch(tipo){
									case "Numerico":
										strCantDec="2";
										strSepDec = get(formulario_local+".hSeparadorDecimalPais");
										strSepMil = get(formulario_local+".hSeparadorMilesPais");
										break;
									case "Entero":
										strCantDec="0";
										strSepDec = get(formulario_local+".hSeparadorDecimalPais");
										strSepMil = get(formulario_local+".hSeparadorMilesPais");
										break;
									case "Moneda":
										strCantDec = get(formulario_local+".hCantidadDecimalesPais");
										strSepDec = get(formulario_local+".hSeparadorDecimalPais");
										strSepMil = get(formulario_local+".hSeparadorMilesPais");
										break;
									case "MonedaAlternativa":
										strCantDec = get(formulario_local+".hCantidadDecimalesAlternativos");
										strSepDec = get(formulario_local+".hSeparadorDecimalAlternativo");
										strSepMil = get(formulario_local+".hSeparadorMilesAlternativo");
										break;
								}					

								//aca normalizo la cantidad de decimales, ya que nada me asegura
								//que el formato admita decimales, aunque seria lo logico.
								//Si la cantidad de decimales no es un numero valido, entonces es cero.
								if(isNaN(parseInt(strCantDec,10))){
									strCantDec = 0;
								}else{
									strCantDec=parseInt(strCantDec,10);
								}

								//Primero me fijo si es un numero, para eso
								//le saco todos los separadores
								var strCleaned = valorTest.split(strSepDec).join("");
								strCleaned = strCleaned.split(strSepMil).join("")+"";
								
								if(!parseInt(strCleaned.substr(0,1),10) && parseInt(strCleaned.substr(0,1),10)!=0){//si el primero no es un numero, puede ser solo el simbolo negativo
									if(strCleaned.substr(0,1)!="-"){
										cdos_mostrarAlert(GestionarMensaje("000000000000100" ,  strMostrar));
										sicc_focaliza_componente_LE(strName + "_" + contador, listName);
										return false;
									}else{//tambien lo saco para testear el numero
										strCleaned = strCleaned.substr(1);
									}
								}

								var RegInteger = /^\d+$/; //Solo numeros
								if(!RegInteger.test(strCleaned)){
									sicc_focaliza_componente_LE(strName + "_" + contador, listName);
									cdos_mostrarAlert( GestionarMensaje("000000000000100" ,  strMostrar) );
									return false;
								}
								
								//Ahora se que es un numero, primero valido los decimales
								//el ultimo debe ser un numero
								if(isNaN(parseInt(valorTest.substr(valorTest.length-1),10))){
										cdos_mostrarAlert(GestionarMensaje("000000000000100" ,  strMostrar));
										sicc_focaliza_componente_LE(strName + "_" + contador, listName);
										return false;
								}

								//me fijo el largo de los decimales
								var arrTest = valorTest.split(strSepDec);
								if(arrTest.length ==2 && arrTest[1]!=null && arrTest[1]!=""){//si tiene decimales
									if(parseInt(strCantDec,10)==0){
										cdos_mostrarAlert(GestionarMensaje("000000000000104"));
										sicc_focaliza_componente_LE(strName + "_" + contador, listName);
										return false;
									}
									var strDecimales = arrTest[arrTest.length-1]+"";
									if(strDecimales.length > parseInt(strCantDec,10)){//me fijo cuantos son
										cdos_mostrarAlert(GestionarMensaje("000000000000101" ,  strMostrar,parseInt(strCantDec,10)));
										sicc_focaliza_componente_LE(strName + "_" + contador, listName);
										return false;
									}
								}else{
									if(arrTest.length > 2){//sino
										cdos_mostrarAlert(GestionarMensaje("000000000000102" ,  strMostrar));
										sicc_focaliza_componente_LE(strName + "_" + contador, listName);
										return false;
									}
								}
								//ahora voy por la parte entera

								var strInteger = arrTest[0]+"";
								
								if(strInteger.indexOf(strSepMil) >- 1){//si tiene separadores de miles
									var arrInteger = strInteger.split(strSepMil);
									//en todo el array los numero son de a 3 digitos
									//excepto en la primera posicion, 
									//donde solo no pueden ser 4 digitos
									for(var i=0; i < arrInteger.length; i++){
										if(i==0){
											if((arrInteger[i]+"").length>3){
												cdos_mostrarAlert(GestionarMensaje("000000000000100" ,  strMostrar));
												sicc_focaliza_componente_LE(strName + "_" + contador, listName);
												return false;
											}
										}else{
											if((arrInteger[i]+"").length!=3){
												cdos_mostrarAlert(GestionarMensaje("000000000000105",strSepMil));
												sicc_focaliza_componente_LE(strName + "_" + contador, listName);
												return false;
											}
										}
									}
								}


								//por ultimo valido el rango del valor
								//saco el separador de miles
								var strNumeroTest = valorTest.split(strSepMil).join("");
								//si el separador decimal es el punto, lo dejo, sino, lo reemplazo por el punto
								if(strSepDec!="."){
									strNumeroTest  = strNumeroTest.split(strSepDec).join(".")
								}
								
								if(valorMinimo!=""){
									if(parseFloat(strNumeroTest )<parseFloat(valorMinimo)){
										cdos_mostrarAlert(GestionarMensaje("000000000000103" ,  strMostrar,parseFloat(valorMinimo),parseFloat(valorMaximo)));
										sicc_focaliza_componente_LE(strName + "_" + contador, listName);
										return false;
									}
								}	
								if(valorMaximo!=""){
									if(parseFloat(strNumeroTest)>parseFloat(valorMaximo)){
										cdos_mostrarAlert(GestionarMensaje("000000000000103" ,  strMostrar,parseFloat(valorMinimo),parseFloat(valorMaximo)));
										sicc_focaliza_componente_LE(strName + "_" + contador, listName);
										return false;
									}
								}
					}
	}
	return true;
}

// -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function sicc_valida_requerido_LE(strName, strMostrar, listName, posCol)
{
	var datos = eval(listName + ".datos;");

	for (var i = 0; i < datos.length; i++ )
	{
				var strValor = datos[i][posCol];
				if(strValor==null){
					strValor="";
				}else{
					if((typeof(strValor)).toUpperCase() == "OBJECT"){
						strValor = strValor.toString();
					}else{
						strValor+="";
					}
				}
				strValor = strValor.split(" ").join("");
				if(strValor==""){
					cdos_mostrarAlert(GestionarMensaje("1534" ,  strMostrar));
					sicc_focaliza_componente_LE(strName + "_" + i, listName);
					return false;    
				}
	}

	return true;
}

// -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function sicc_focaliza_componente_LE(strName, listName)
{
    eval(listName+".preparaCamposDR();");
	var strFoc = 'try{focaliza(\'frm' +listName+'.'+strName+'\',\'\')}catch(e){;}';
	window.setTimeout(strFoc,200);
}

// -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function sicc_validar_fecha_LE(strName, mostrar, fecha_desde, fecha_hasta, formatoFechaUsuario, listName, posCol, poneFoco, datosOpcional, arrayIndices) 
{
	//esta funcion valida fechas, convirtiendo los strings a fechas de javascript
	//y validando tanto la existencia como el rango de la fecha. Se asume que el
	//formato de las fechas minimas y maximas seran dd/mm/yyyy.

	// Agregado por ssantana, 2/3/2005, para poder trabajar con un Array de Datos Opcional
	// Esto se puede usar para validar dato Unico o un Array de valores
	var datos = null;
	if (datosOpcional != null)
		datos = datosOpcional;
	else
		datos = eval(listName + ".datos;");

	for (var contador = 0; contador < datos.length; contador++ )
	{

			/* Se modificó para que acepte un array donde contiene los índices de las columnas 
			donde se encuentran las fechas desde y hasta. */ 
			if (arrayIndices != null && arrayIndices != undefined && arrayIndices.length == 2 ) { 
					fecha_desde = datos[contador] [ arrayIndices[0] ]; 
					fecha_hasta = datos[contador] [ arrayIndices[1] ]; 
			} 

			var strValor = datos[contador][posCol];
	
			//	var strValor = get(getFormularioSICC()+"."+strName);
			if(strValor!="")
			{
					var arrFormato = null;
					var arrFecha = null;
					var separador = "";

					var strValorFormatoFechaPais = get(getFormularioSICC()+".hFormatoFechaPais");

					if (formatoFechaUsuario == null || formatoFechaUsuario == ""){

						if( strValorFormatoFechaPais == "" ){
							formatoFechaUsuario = "dd/mm/yyyy";
						} else {
							formatoFechaUsuario = strValorFormatoFechaPais;
						}

					}
					
					if(formatoFechaUsuario.indexOf("/")>-1){
						separador = "/";
						arrFormato = formatoFechaUsuario.split("/");
						arrFecha = strValor.split("/");
					}else{
						separador = "-";
						arrFormato = formatoFechaUsuario.split("-");
						arrFecha = strValor.split("-");
					}

					//para ser valida la fecha permite 3 valores (dia, mes, anio)
					if(arrFecha.length != 3){
						//cdos_mostrarAlert(GestionarMensaje("000000000000031")+ formatoFechaUsuario.replace(/y/g,'a') +GestionarMensaje("000000000000032"));
						GestionarMensaje("1006", formatoFechaUsuario.replace(/y/g,'a'));
						if (poneFoco == "S")
							sicc_focaliza_componente_LE(strName + "_" + contador, listName);
						return false;
					}

					//valido los caracteres de la fecha
					if(!sicc_caracteres_fecha_validos(strValor,separador)){
						cdos_mostrarAlert(GestionarMensaje("000000000000025"));
						//sicc_focaliza_componente_LE(strName + "_" + contador, listName);
						if (poneFoco == "S")
							sicc_focaliza_componente_LE(strName + "_" + contador, listName);

						return false;
					}
					//ahora trabajo con la fecha
					var dia, mes, anio;
					for(var i=0; i < arrFormato.length;i++){
						switch(arrFormato[i]){
							case 'dd':
								dia = arrFecha[i];
								break;
							case 'mm':
								mes = arrFecha[i];
								break;
							default:
								anio = arrFecha[i];
								break;
						}
					}

					//en cada variable tengo la parte de la fecha que corresponde, por lo que valido
					//primero el formato, luego la validez, por ultimo el rango
					if(dia.length!=2){
						cdos_mostrarAlert(GestionarMensaje("000000000000028"));
						//sicc_focaliza_componente_LE(strName + "_" + contador, listName);
						if (poneFoco == "S")
							sicc_focaliza_componente_LE(strName + "_" + contador, listName);

						return false;
					}
					if(mes.length!=2){
						cdos_mostrarAlert(GestionarMensaje("000000000000029"));
						//sicc_focaliza_componente_LE(strName + "_" + contador, listName);
						if (poneFoco == "S")
							sicc_focaliza_componente_LE(strName + "_" + contador, listName);

						return false;
					}
					if(anio.length != 4){
						cdos_mostrarAlert(GestionarMensaje("000000000000030"));
						//sicc_focaliza_componente_LE(strName + "_" + contador, listName);
						if (poneFoco == "S")
							sicc_focaliza_componente_LE(strName + "_" + contador, listName);

						return false;
					}

					//el mes no puede ser superior a 12 ni menor que 1
					if(parseInt(mes,10) < 1 || parseInt(mes,10) > 12){
						cdos_mostrarAlert(GestionarMensaje("000000000000036"));
						//sicc_focaliza_componente_LE(strName + "_" + contador, listName);
						if (poneFoco == "S")
							sicc_focaliza_componente_LE(strName + "_" + contador, listName);

						return false;
					}

					var diaMaximo =0;
					switch(parseInt(mes,10)){
						case 1:
						case 3:
						case 5:
						case 7:
						case 8:
						case 10:
						case 12:
							diaMaximo = 31;
							break;
						case 4:
						case 6:
						case 9:
						case 11:
							diaMaximo = 30;
							break;
						case 2:
							if(sicc_anio_bisiesto(anio)){
								diaMaximo = 29;
							}else{
								diaMaximo = 28;
							}
					}
					
					if(parseInt(dia,10) < 1 || parseInt(dia,10) > parseInt(diaMaximo,10)){
						cdos_mostrarAlert(GestionarMensaje("000000000000037")+diaMaximo);
						//sicc_focaliza_componente_LE(strName + "_" + contador, listName);
						if (poneFoco == "S")
							sicc_focaliza_componente_LE(strName + "_" + contador, listName);

						return false;
					}

					//se presupone que si existen fecha limite, las mismas
					//seran correctas, por lo que no se hacen todas las validaciones a las mismas.
					//Las fechas limite se esperan en formato dd/mm/yyyy

					var oDate = new Date(anio, parseInt(mes,10)-1, dia);

					if(fecha_desde!= null && fecha_desde != "" && fecha_desde!="0"){
						arrFechaDesde = fecha_desde.split("/");
						var oDateDesde = new Date(arrFechaDesde[2], parseInt(arrFechaDesde[1],10)-1, arrFechaDesde[0]);
						if(oDate < oDateDesde){
							cdos_mostrarAlert(GestionarMensaje("000000000000012")+fecha_desde);
							//sicc_focaliza_componente_LE(strName + "_" + contador, listName);
							if (poneFoco == "S")
								sicc_focaliza_componente_LE(strName + "_" + contador, listName);

							return false;
						}
					}

					if(fecha_hasta!= null && fecha_hasta != "" && fecha_hasta != "0"){
						arrFechaHasta = fecha_hasta.split("/");
						var oDateHasta = new Date(arrFechaHasta[2], parseInt(arrFechaHasta[1],10)-1, arrFechaHasta[0]);
						if(oDate > oDateHasta){
							cdos_mostrarAlert(GestionarMensaje("000000000000013")+fecha_hasta);
							//sicc_focaliza_componente_LE(strName + "_" + contador, listName);
							if (poneFoco == "S")
								sicc_focaliza_componente_LE(strName + "_" + contador, listName);

							return false;
						}
					}
			}

	}

	return true;
}