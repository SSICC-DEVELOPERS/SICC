//Cristian Valenzuela - 3/6/2005
//La variable finCargaPagina se seteaa false al principio.
//Al final de la funcion Onload de cada pagina se pondra a true.
//Es para que no aparezcan errores de javascript cuando en el 
//evento onmouseover se llama a la funcion activarPuntero
//y la pagina todavia no termino su carga
var finCargaPagina = false;

//Marcelo J. Maidana -- 04/05/2005
function onClickPestanyaHabilitada(valor, form, nombreLP){
  //Esta funcion condiciona el cambio de pestanya dependiendo de variables ocultas

  //Productos         5
  //ProgramaNuevas    2 -
  //AmbitoGeografico  3 -
  //Calificion        9 -
  //Gerentes          10 -
  //Consultoras       11 -
  //Multinivel        12 -

  switch(valor){
    case 2:
      if(get(form + '.hIndEstadoProgramaNuevas')=='S'){
        onClickPestanya(valor, form, nombreLP);
      }
      break;
    case 3:
      if(get(form + '.hIndEstadoAmbitoGeografico')=='S'){
        onClickPestanya(valor, form, nombreLP);
      }
      break;
    case 5:
      if(get(form + '.hIndEstadoProductos')=='S'){
        onClickPestanya(valor, form, nombreLP);
      }
      break;
    case 9:
      if(get(form + '.hIndEstadoCalificion')=='S'){
        onClickPestanya(valor, form, nombreLP);
      }
      break;
    case 10:
      if(get(form + '.hIndEstadoGerentes')=='S'){
        onClickPestanya(valor, form, nombreLP);
      }
      break;
    case 11:
      if(get(form + '.hIndEstadoConsultoras')=='S'){
        onClickPestanya(valor, form, nombreLP);
      }
      break;
    case 12:
      if(get(form + '.hIndEstadoMultinivel')=='S'){
        onClickPestanya(valor, form, nombreLP);
      }
      break;
    default:
      onClickPestanya(valor, form, nombreLP);
  }
}

//Marcelo J. Maidana -- 04/05/2005
function onClickPestanya(valor, form, nombreLP) {
	var datosObligatorios = comprobarDatosObligatorios();
	var oMenu = get(form + '.opcionMenu');

	//Cristian Valenzuela - 7/6/2005
	//Valores posibles para opcionMenu
	// "Crear Concurso" 
	// "Consultar Concurso"
	// "Modificar Concurso" 	
    if( oMenu.toLowerCase() != 'consultar concurso' ){
      set(form + '.conectorAction', nombreLP);
      set(form + '.accion', 'almacenar');
      set(form + '.idPestanyaDest', valor);
      set(form + '.datosObligatorios', datosObligatorios);
    }
	else{
      set(form + '.conectorAction', nombreLP);
      set(form + '.accion', 'redirigir');
      set(form + '.idPestanyaDest', valor);
    }
    
	eval(form).oculto = 'N';
    enviaSICC(form, null, null, 'N');
}

//Marcelo J. Maidana -- 04/05/2005
function activarPuntero(form, dato, nombre){
  //Esta funcion condiciona el cambio de puntero dependiendo de variables ocultas

  //Productos         5
  //ProgramaNuevas    2
  //AmbitoGeografico  3
  //Calificion        9
  //Gerentes          10
  //Consultoras       11
  //Multinivel        12

  //Agregado por Cristian Valenzuela - 3/6/2005
  //Verifica si ya termino de cargar la pagina
  if(finCargaPagina==false) return;
  
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
    case 5:
      if(get(form + '.hIndEstadoProductos')=='S'){
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
}

//Marcelo J. Maidana -- 04/05/2005
function poneManito(nombre) {           
	var nombre = document.getElementById(nombre);
	nombre.style.cursor = "hand";
}


// INC 21375 - dmorello, 06/12/2005
// Esta función se ejecutará luego de guardar un concurso al modificarlo.
// Muestra un alerta de que no se pudieron guardar todos los datos del concurso
// por datos obligatorios incompletos. Luego procede a cerrar la ventana modal
function mostrarAlertaYCerrar() {
	GestionarMensaje("INC-0052", null, null, null);
	window.close();
}


// INC 21375 - dmorello, 06/12/2005
// Esta función se ejecutará luego de guardar un concurso al crearlo.
// Muestra un alerta de que no se pudieron guardar todos los datos del concurso
// por datos obligatorios incompletos. Luego procede a reiniciar el caso de uso Crear concurso
function mostrarAlerta(opcionMenu) {
	GestionarMensaje("INC-0052", null, null, null);
	// Lo siguiente se hacía antes en la LP, ahora se hace desde aquí...
	set('formulario.conectorAction','LPCrearConcurso');
	set('formulario.accion','');
    set('formulario.opcionMenu',opcionMenu);
	enviaSICC('formulario');
}

function activarPunteroAux(form, dato, nombre){
	var menu = get(form + '.opcionMenu');
	var oidVigenciaConcurso = get(form + '.oidVigenciaConcurso');
	
	if(menu.toLowerCase() == "modificar concurso") {
		if(oidVigenciaConcurso == '1') {
			if((dato == 1) || (dato == 6))
		    	return activarPuntero(form, dato, nombre);
		    else
		    	return;	
		} else 
			return activarPuntero(form, dato, nombre);
	} else {
		return activarPuntero(form, dato, nombre);
	}   
}

function onClickPestanyaHabilitadaAux(valor, form, nombreLP){
	var menu = get(form + '.opcionMenu');
	var oidVigenciaConcurso = get(form + '.oidVigenciaConcurso');
	
	if(menu.toLowerCase() == "modificar concurso") {
		if(oidVigenciaConcurso == '1') {
			if((valor == 1) || (valor == 6))
		    	return onClickPestanyaHabilitada(valor, form, nombreLP);
		    else
		    	return;	
		} else 
			return onClickPestanyaHabilitada(valor, form, nombreLP);
	} else {
		return onClickPestanyaHabilitada(valor, form, nombreLP);
	}   
}
