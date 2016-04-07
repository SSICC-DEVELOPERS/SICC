var boolResultadoEliminacionSICC = false;


function formarCadenaDT(idBusiness , dto, parametros) {
	 var cadena = idBusiness + "|" + dto + "|";

	 //concateno los par�metros en parejas separadas por ampersand (como en una url).
	 for(i=0;i<parametros.length;i++) {
		 cadena += parametros[i][0] + "=" + parametros[i][1];
		 if (i!= parametros.length-1) {
			cadena += "&";
		 }
	 }     
	return cadena;
 }

function recargaCombo(combo, idBusiness, dto, parametros, funcionSalida) {
	//esto hace que el subsistema muestre correctamente el mensaje de error
	asignarException = "mostrarErrorSubsistemaRecargaCombo(msgError)";

	if(funcionSalida){
	  asignar([['COMBO', combo, 'ConectorDruidaTransactionQuery', 'dtoSalida.resultado_ROWSET',
  									formarCadenaDT(idBusiness, dto, parametros),funcionSalida]]);
	}else{
	  asignar([['COMBO', combo, 'ConectorDruidaTransactionQuery', 'dtoSalida.resultado_ROWSET',
  									formarCadenaDT(idBusiness, dto, parametros)]]);
	}
	//asignarException = null;
}

var objetoPaginado; //Guardamos el objeto paginado para recargarlo una vez finalizada la eliminacion

function eliminarFilas(oids, idBusiness, paginado, funcionSalida, mostrarExito) {
	if(GestionarMensaje("5")){
		//Formamos una cadena con los elementos que se van a eliminar
		var parametros = formarCadenaEliminar(oids, idBusiness);
		if(mostrarExito!=null && mostrarExito==true){
			boolResultadoEliminacionSICC = true;
		}
		if(funcionSalida==null){
			//Hacemos la llamada al conector simulando que asignamos el valor a un campo de texto;
			// ya que el campo no existe pero capturamos el resultado en la funcion 
			// resultadosOperacion
			asignar([["TEXT","","ConectorEliminarTransaction","resultado", 
								parametros, "resultadoOperacion(datos);"]]);
		}else{
			asignar([["TEXT","","ConectorEliminarTransaction","resultado", 
								parametros, funcionSalida]]);
		
		}
		objetoPaginado = paginado; //Guardamos el objeto paginado para utilizarlo m�s tarde
	}
}

function formarCadenaEliminar(oids, idBusiness) {
	var i;
	var cadena;
		
	cadena = idBusiness + '|';
	for (i=0; i<oids.length; i++) {
       cadena = cadena + oids[i];
       if (i != oids.length -1) {
       cadena = cadena + ",";
       }		
	}
	return cadena;	
}



function resultadoOperacion(datos) {
	//Si hemos recibido un mensaje como resultado de la operaci�n lo mostramos
	var mensajeError = "";
	if(datos != null && (typeof(datos)).toUpperCase() == "OBJECT"){
		mensajeError  = datos[0];
	}else if(datos != null && (typeof(datos)).toUpperCase() == "STRING"){
	    mensajeError = datos;
	}
	if(mensajeError==""){
		if(boolResultadoEliminacionSICC){
			cdos_mostrarConfirm(GestionarMensaje("989"));
		}
	}else{
		mostrarErrorSubsistema(mensajeError );
		return false;
	}
	//Actualizamos los resultados de la b�squeda
	if (objetoPaginado != null) {
	      objetoPaginado.recargar()
	}
	return true;
}



function mostrarErrorSubsistemaRecargaCombo(error){
       if(error!= null && error.indexOf("|")>-1){
             //Formato esperado: #|#|??????? donde:
             //posicion 0: severidad
             //posicion 1: codigo
             //posicion 2: mensaje 
             var arrError = error.split("|");
             var strFormName = getFormularioSICC();

			  switch(arrError.length){
					case 2:
						 set(strFormName+".errDescripcion", arrError[1]);
						 //ak debemos tener en cuenta que el mensaje de error puede contener el nombre clase
						 //por lo que lo sacamos
						 if(arrError[0].indexOf(": ")>-1){
								set(strFormName+".errCodigo", arrError[0].split(": ")[1]);
						 }else{
								set(strFormName+".errCodigo", arrError[0]);
						 }
						 set(strFormName+".errSeverity", "0");
						 //Si la recarga de combos retorna "No hay datos" no mostramos la ventana emergente.
						 if (get(strFormName+".errCodigo") == '5' ){
								fMostrarMensajeError("0");
								return get(strFormName+".errCodigo");
						 } else {
								return true;
						 }
						break;
					case 3:
						 set(strFormName+".errDescripcion", arrError[2]);
						 //ak debemos tener en cuenta que el mensaje de error puede contener el nombre clase
						 //por lo que lo sacamos
						 if(arrError[1].indexOf(": ")>-1){
								set(strFormName+".errCodigo", arrError[1].split(": ")[1]);
						 }else{
								set(strFormName+".errCodigo", arrError[1]);
						 }
						 set(strFormName+".errSeverity", arrError[0]);
						 //Si la recarga de combos retorna "No hay datos" no mostramos la ventana emergente.
						 if (get(strFormName+".errCodigo") == '5' ){
								fMostrarMensajeError(arrError[0]);
								return get(strFormName+".errCodigo");
						 } else {
								return true;
						 }
						break;
					default:
						set(strFormName+".errDescripcion", "Error en la cadena de mensajes");
						set(strFormName+".errCodigo", "-1");
						set(strFormName+".errSeverity", "0");
			  }

       }else{
             var strFormName = getFormularioSICC();
             set(strFormName+".errDescripcion", error);
             set(strFormName+".errCodigo", "0");
             fMostrarMensajeError();
             return 0;
       }
}



function mostrarErrorSubsistema(error){
       if(error!= null && error.indexOf("|")>-1){
             //Formato esperado: #|#|??????? donde:
             //posicion 0: severidad
             //posicion 1: codigo
             //posicion 2: mensaje 
             var arrError = error.split("|");
             var strFormName = getFormularioSICC();
              switch(arrError.length){
					case 2:
						 set(strFormName+".errDescripcion", arrError[1]);
						 //ak debemos tener en cuenta que el mensaje de error puede contener el nombre clase
						 //por lo que lo sacamos
						 if(arrError[0].indexOf(": ")>-1){
								set(strFormName+".errCodigo", arrError[0].split(": ")[1]);
						 }else{
								set(strFormName+".errCodigo", arrError[0]);
						 }
						 set(strFormName+".errSeverity", "0");
						fMostrarMensajeError("0");
						return get(strFormName+".errCodigo");

					case 3:
						 set(strFormName+".errDescripcion", arrError[2]);
						 //ak debemos tener en cuenta que el mensaje de error puede contener el nombre clase
						 //por lo que lo sacamos
						 if(arrError[1].indexOf(": ")>-1){
								set(strFormName+".errCodigo", arrError[1].split(": ")[1]);
						 }else{
								set(strFormName+".errCodigo", arrError[1]);
						 }
						 set(strFormName+".errSeverity", arrError[0]);
						fMostrarMensajeError(arrError[0]);
						return get(strFormName+".errCodigo");
					default:
						set(strFormName+".errDescripcion", "Error en la cadena de mensajes");
						set(strFormName+".errCodigo", "-1");
						set(strFormName+".errSeverity", "0");
			  }
       }else{
             var strFormName = getFormularioSICC();
             set(strFormName+".errDescripcion", error);
             set(strFormName+".errCodigo", "0");
             fMostrarMensajeError("0");
             return 0;
       }
}
