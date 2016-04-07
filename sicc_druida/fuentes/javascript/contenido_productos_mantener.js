function init()
{
	finCargaPagina = true;
	configurarMenuSecundario("formulario");
	fMostrarMensajeError();
  
  
/*  var valor = get("formulario.valorMenu");
   if (valor =="no"){
     btnProxy(1, 0);
   }*/
  
  
  
}


// ----------------------------------------------------------------------------------------------------------------------------------------------------------
function accionAceptar()
{
		var seleccionCombo = get("formulario.cbProductos");
		//alert("Valor combo: " + seleccionCombo);
	

//		if ( seleccionCombo != "" )
		if ( sicc_validaciones_generales("combo") )
		{
			// Obtiene la desc. del elemento del combo. 
			var descCombo = get("formulario.cbProductos", "T"); 
			var entroAModal = get("formulario.yaEntroAModal");
			//alert("Desc Combo: " + entroAModal);
			var params = new Object();
			params.oidCombo = seleccionCombo;
			params.descCombo = descCombo;
			params.yaEntroAModal = entroAModal;

			this.mostrarModalSICC('LPMantenerProductos', 'mantener', params);

			// Setea indicador que ya entró a la modal (de forma de poder, la proxima vez, tomar el DTO copia de sesión
			//  en lugar del original.
			set("formulario.yaEntroAModal", "SI");
		}
}


// ----------------------------------------------------------------------------------------------------------------------------------------------------------
/*function poneManito(label)
{
	var obj = document.getElementById(label);
	obj.style.cursor = "hand";
}*/

// ----------------------------------------------------------------------------------------------------------------------------------------------------------
function onClickPestanyaHabilitadaSS(valor, form){
  //Esta funcion condiciona el cambio de pestanya dependiendo del estado de la 
  //pestanya en las siguientes:
  //ProgramaNuevas    2 -
  //AmbitoGeografico  3 -
  //Calificion        9 -
  //Gerentes          10 -
  //Consultoras       11 -
  //Multinivel        12 -

  nombreLP = "LPMantenerProductos";
  //alert('onClickPestanyaHabilitada: ' + valor);

  switch(valor){
  
    case 2:
      if(get(form + '.hIndEstadoProgramaNuevas')=='S'){
        onClickPestanyaSS(valor, form, nombreLP);
      }
      break;
    case 3:
      if(get(form + '.hIndEstadoAmbitoGeografico')=='S'){
        onClickPestanyaSS(valor, form, nombreLP);
      }
      break;
    case 9:
      if(get(form + '.hIndEstadoCalificion')=='S'){
        onClickPestanyaSS(valor, form, nombreLP);
      }
      break;
    case 10:
      if(get(form + '.hIndEstadoGerentes')=='S'){
        onClickPestanyaSS(valor, form, nombreLP);
      }
      break;
    case 11:
      if(get(form + '.hIndEstadoConsultoras')=='S'){
        onClickPestanyaSS(valor, form, nombreLP);
      }
      break;
    case 12:
      if(get(form + '.hIndEstadoMultinivel')=='S'){
        onClickPestanyaSS(valor, form, nombreLP);
      }
      break;
    default:
      //alert('default');
      onClickPestanyaSS(valor, form, nombreLP);
  }
}

// ----------------------------------------------------------------------------------------------------------------------------------------------------------
//Marcelo J. Maidana -- 04/05/2005
function onClickPestanyaSS(valor, form, nombreLP) {
	//var datosObligatorios = comprobarDatosObligatorios();
	var oMenu = get(form + '.opcionMenu');

    set(form + '.accion', 'redirigir');
/*    if( oMenu.toLowerCase() != 'consultar concurso' ){
      set(form + '.conectorAction', nombreLP);
      //set(form + '.accion', 'almacenar');
      set(form + '.idPestanyaDest', valor);
      //set(form + '.datosObligatorios', datosObligatorios);
    }else{*/
     set(form + '.conectorAction', nombreLP);
     set(form + '.accion', 'redirigir');
     set(form + '.idPestanyaDest', valor);
//    }
    
    enviaSICC(form, null, null, 'N');

}


// ----------------------------------------------------------------------------------------------------------------------------------------------------------
//Marcelo J. Maidana -- 04/05/2005
/*function activarPuntero(form, dato, nombre){
  //Esta funcion condiciona el cambio de puntero dependiendo del estado de la 
  //pestanya en las siguientes:
  //ProgramaNuevas    2
  //AmbitoGeografico  3
  //Calificion        9
  //Gerentes          10
  //Consultoras       11
  //Multinivel        12
  
  switch(dato){
    case 2:
      if(get(form + '.hIndEstadoProgramaNuevas')=='S'){
        poneManito(nombre);
      }
      break;
    case 3:
      if(get(form + '.hIndEstadoAmbitoGeografico')=='S'){
        poneManito(nombre);
      }
      break;
    case 9:
      if(get(form + '.hIndEstadoCalificion')=='S'){
        poneManito(nombre);
      }
      break;
    case 10:
      if(get(form + '.hIndEstadoGerentes')=='S'){
        poneManito(nombre);
      }
      break;
    case 11:
      if(get(form + '.hIndEstadoConsultoras')=='S'){
        poneManito(nombre);
      }
      break;
    case 12:
      if(get(form + '.hIndEstadoMultinivel')=='S'){
        poneManito(nombre);
      }
      break;
    default:
      poneManito(nombre);
  }
}*/

// ----------------------------------------------------------------------------------------------------------------------------------------------------------
//Marcelo J. Maidana -- 04/05/2005
function poneManito(nombre) {           
	var nombre = document.getElementById(nombre);
	nombre.style.cursor = "hand";
}   


// ----------------------------------------------------------------------------------------------------------------------------------------------------------
function fGuardar()
{
	eval("formulario").oculto = "S";
	set("formulario.accion", "guardar");
	set("formulario.conectorAction", "LPMantenerProductos");

	enviaSICC(formulario);
}



