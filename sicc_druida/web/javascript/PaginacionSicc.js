//Agregado de Gaston Acevedo, segun incidencia 3757
//--------------------------------------------------------------
function obtenerFormatoFecha(fecha) {
	if(fecha == null){
		return;
	}
    var strFecha = fecha+""
	if(strFecha == ""){
		return;
	}
	//Debemos pasar la fecha de entrada al formato correspondiente, teniendo en cuenta
	//que los distintos usuarios pueden configurar su propio formato, por lo que
	//validamos el formato actual. Se presupone que en la logica de presentacion se ha
	//invocado al metodo generarHiddenFormatoFecha de LPSICCBase para obtener 
	//el formato de fecha de usuario en el hidden "hFormatoFechaPais";
	var formatoFechaUsuario =""
	try{
		formatoFechaUsuario = get(getFormularioSICC()+".hFormatoFechaPais");
	}catch(e){
		//Esto se dejara durante algun tiempo hasta que nos acostumbremos
		//a llamar al metodo en la LP para generar el hidden necesario.
		alert("No se ha obtenido el formato de Fecha de Usuario");
	}
	if(formatoFechaUsuario==""){
		return;
	}
	if(formatoFechaUsuario=="dd/mm/yyyy" || formatoFechaUsuario=="dd/mm/aaaa"){
		return strFecha;
	}

	//si llegamos aqui, es porque debemos transformar.
	var arrFormato = null;
	var arrFecha = null;
	if(formatoFechaUsuario.indexOf("/")>-1){
		arrFormato = formatoFechaUsuario.split("/");
		arrFecha = strFecha.split("/");
	}else{
		arrFormato = formatoFechaUsuario.split("-");
		arrFecha = strFecha.split("-");
	}

	var dia, mes, anio;

	for(var i=0; i < arrFormato.length;i++){
		switch(arrFormato[i]){
			case 'dd':
				dia = arrFecha[i]-0;
				break;
			case 'mm':
				mes = arrFecha[i]-0;
				break;
			default:
				anio = arrFecha[i]-0;
				break;
		}
	}

	if(anio<100){
		if(anio<10){
			anio+=2000;
		}else{
			anio+=1900;
		}
	}
	if(dia<10){
		dia = "0"+(dia+"");
	}
	if(mes < 10){
		mes = "0"+(mes+"");
	}
	
	return dia+"/"+mes+"/"+anio;
}


function formarCadenaPaginado(idBusiness, conector, dto, posicion, pageSize, parametros){
    //El 0 es la posicion de inicio del paginado
    // luego el paginado de Druida lo va actualizando
	var cadena = "0|" + idBusiness + "|" + conector + "|" + dto + "|" + posicion + "|" + pageSize + "|";
    for(i=0;i<parametros.length;i++) {
		cadena += parametros[i][0] + "=" 
		var posicionCad = parametros[i][1];
		if(posicionCad.length && (typeof(posicionCad)).toUpperCase() != "STRING"){
			cadena += posicionCad[0];
		}else{
			posicionCad = reemplazo(posicionCad,"&",";druida;amp;");
			cadena += posicionCad;
		}
		if (i!= parametros.length-1) {
			cadena += "&"
		}
	} 
	return cadena;
}


//Esta versi�n extendida permite definir la posicion de la columna en la que se pagina
// y el tama�o de p�gina deseado. Si no se especifica tama�o de p�gina se toma el que este 
// configurado en el sistema (el parametro es opcional)
function configurarPaginadoExt(paginado, idBusiness, conector, dto, parametros, posicion, pageSize, capalistado){
	paginado.clear();                                      //Limpiamos la lista
	//paginado.lista.muestra();
	/*
	if(capatitulo!=null){
		try{visibilidad(capatitulo,'O');}catch(e){;}
	}
	document.all[paginado.ret.nombre+"Div"].style.visibility='hidden';
	document.all[paginado.ava.nombre+"Div"].style.visibility='hidden';
	try{document.all["primera1Div"].style.visibility='hidden';}catch(e){;}
	try{document.all["DetalleDiv"].style.visibility='hidden';}catch(e){;}
	try{document.all["ModificarDiv"].style.visibility='hidden';}catch(e){;}
	*/

	paginado.setConector("ConectorPaginadoTransaction");   //El conector de subsistema
	paginado.setRowset("dtoSalida.resultado");             //El nombre del Rowset es fijo (se encarga de ello el subsistema)

    if (pageSize == null) {
    	pageSize = '';
    }
    var cadenaParametros = formarCadenaPaginado(idBusiness, conector, dto, posicion, pageSize, parametros);
	//alert(cadenaParametros)
	paginado.setControl(cadenaParametros);     //Los parametros de la lista paginada
	paginado.avanzar();                                  //Cargamos la primeraPagina
}

//Esta es la configuracion m�s sencilla, supone que la primera columna es por la que se pagina 
// y que el tama�o de p�gina se coge de la configuraci�n del sistema
function configurarPaginado(paginado, idBusiness, conector, dto, parametros, capalistado) {
	configurarPaginadoExt(paginado, idBusiness, conector, dto, parametros, 0);
}


//Esta funcion se debe poner siempre en el evento onload del objeto paginado
// para procesar el resultado.
//Si se quiere hacer un procesamiento adicional, se debe a�adir el parametro funcion
//con el siguiente formato: myfuncion(ultima, rowset)
function procesarPaginado(paginado,error, ultima, rowset, funcion, capatitulo) {
       var boolResult = true;
       primeraBusqueda = paginado.indices.indexOf('#')==-1;
       if (error != "" && primeraBusqueda){
             //No encontro mas datos y es la primera busqueda.
              var codigoError = mostrarErrorSubsistema(error);
              //Agregado el 25/05/2004
              //En caso de no haber datos, intentamos ocultar la lista.
             /*
             if(rowset!=null && rowset.length == 0){//no trajo nada
                    if(parseInt(codigoError,10)==5){//error de no hay datos
                           paginado.lista.setDatos(new Array());
                           paginado.lista.oculta();
                           if(capatitulo!=null){
                                  try{visibilidad(capatitulo,'O');}catch(e){;}
                           }
                           document.all[paginado.ret.nombre+"Div"].style.visibility='hidden';
                           document.all[paginado.ava.nombre+"Div"].style.visibility='hidden';
                           try{document.all["primera1Div"].style.visibility='hidden';}catch(e){;}
                           try{document.all["DetalleDiv"].style.visibility='hidden';}catch(e){;}
                           try{document.all["ModificarDiv"].style.visibility='hidden';}catch(e){;}
                    }
             }
             */
             boolResult = false;
       }else if (error != "" && !primeraBusqueda) {
             //No encontro mas datos y no es la primera busqueda.
             rowset = new Array();
             mostrarErrorSubsistema(error);
             boolResult = false;
             //Deshabilita boton avance y habilita retroceso
             paginado.ava.tipo = 0;
             paginado.ret.tipo = -2;
             //Limpia la Lista 
             paginado.lista.setDatos(new Array());
       }

       if (funcion != null && funcion != "") {
             //var llamada = funcion + "(rowset, ultima)";
             boolResult = eval(funcion);
       }      
       return boolResult;
}


/*funcion para reemplazar una cadena sAreemplazar dentro de una cadena s
  por otra cadena sReemplazo
*/
function reemplazo(s, sAreemplazar, sReemplazo) {
 
  r = "";
  var i=0;
  sTmp = new String (s);
  i= sTmp.indexOf(sAreemplazar);
  if (i == -1) return s;
  
  sVector =  s.split(sAreemplazar);
  for (i = 0; i< sVector.length; i++){
	s = s.replace(sAreemplazar,sReemplazo);
  }
  return s;
} 
