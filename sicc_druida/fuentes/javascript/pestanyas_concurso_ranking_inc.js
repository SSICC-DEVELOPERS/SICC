/**
* Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
* Avda. de Bruselas, 35
* Parque Empresarial Arroyo de la Vega
* 28108 Alcobendas, Madrid
* España
*
* Privado y Confidencial.
* La información contenida en este documento es propiedad de Indra sistemas.
* Para uso exclusivo de empleados autorizados no permitiéndose
* la distribución de este código sin permiso expreso.
*/

//La variable finCargaPagina se seteaa false al principio.
//Al final de la funcion Onload de cada pagina se pondra a true.
//Es para que no aparezcan errores de javascript cuando en el 
//evento onmouseover se llama a la funcion activarPuntero
//y la pagina todavia no termino su carga
var finCargaPagina = false;

//Marcelo J. Maidana -- 16/06/2005
function onClickPestanyaHabilitada(valor, form, nombreLP){
    //Esta funcion condiciona el cambio de pestanya dependiendo del estado de la 
    //pestanya en las siguientes:

    //PESTANYA_PARAMETROS_GERENTES_RANKING      3
    //PESTANYA_PARAMETROS_CONSULTORAS_RANKING   4
    //PESTANYA_VARIABLES_VENTA_RANKING          7


    switch (valor){
        case 3:
            if (get(form + '.hIndEstadoParametrosGerentes')=='S'){
                onClickPestanya(valor, form, nombreLP);
            }
            break;
        case 4:
            if (get(form + '.hIndEstadoParametrosConsultoras')=='S'){
                onClickPestanya(valor, form, nombreLP);
            }
            break;
        case 7:
            if (get(form + '.hIndEstadoVariablesVenta')=='S'){
                onClickPestanya(valor, form, nombreLP);
            }
            break;
        default:
            onClickPestanya(valor, form, nombreLP);
    }
}

//Marcelo J. Maidana -- 16/06/2005
function onClickPestanya(valor, form, nombreLP) {
    var datosObligatorios = comprobarDatosObligatorios();
	var oMenu = get(form + '.opcionMenu');

	//Valores posibles para opcionMenu
	// "Crear Concurso Ranking" 
	// "Consultar Concurso Ranking"
	// "Modificar Concurso Ranking" 	
    if ( oMenu.toLowerCase() != 'Consultar Concurso Ranking' ){
        set(form + '.conectorAction', nombreLP);
        set(form + '.accion', 'almacenar');
        set(form + '.idPestanyaDest', valor);
        set(form + '.datosObligatorios', datosObligatorios);
    } else {
        set(form + '.conectorAction', nombreLP);
        set(form + '.accion', 'redirigir');
        set(form + '.idPestanyaDest', valor);
    }
    eval(form).oculto = 'N';
    enviaSICC(form, null, null, 'N');
}

//Marcelo J. Maidana -- 16/06/2005
function activarPuntero(form, dato, nombre){
  //Esta funcion condiciona el cambio de puntero dependiendo del estado de la 
  //pestanya en las siguientes:

    //PESTANYA_PARAMETROS_GERENTES_RANKING      3
    //PESTANYA_PARAMETROS_CONSULTORAS_RANKING   4
    //PESTANYA_VARIABLES_VENTA_RANKING          7

    //alert('dato: ' + dato);
    //alert('hIndEstadoParametrosGerentes: ' + get('formulario.hIndEstadoParametrosGerentes'));
    //alert('hIndEstadoParametrosConsultoras: ' + get('formulario.hIndEstadoParametrosConsultoras'));

    //Verifica si ya termino de cargar la pagina
    if (finCargaPagina==false){
        return;
    }
  
  
  
    //alert('paso');
  
    switch (dato){
        case 3:
            if (get(form + '.hIndEstadoParametrosGerentes')=='S'){
                poneManito(nombre);
            } else {
                sacaManito(nombre);
            }
            break;
        case 4:
            if (get(form + '.hIndEstadoParametrosConsultoras')=='S'){
                poneManito(nombre);
            } else {
                sacaManito(nombre);
            }
            break;
        case 7:
            if (get(form + '.hIndEstadoVariablesVenta')=='S'){
                poneManito(nombre);
            }
            break;
        default:
            poneManito(nombre);
    }
}

//Marcelo J. Maidana -- 16/06/2005
function poneManito(nombre) {           
    var nombre = document.getElementById(nombre);
	nombre.style.cursor = 'hand';
}   

function sacaManito(nombre) {           
    var nombre = document.getElementById(nombre);
	nombre.style.cursor = '';
}   


function guardarOK(){

    if(get('formulario.opcionMenu')=="Crear Concurso Ranking") {
        // // Consurso Ranking - Creacion
        eval('formulario').oculto = 'N';
        set('formulario.conectorAction', 'LPMantenerConcursosRanking');
        set('formulario.accion', '');
        set('formulario.hIndEstadoParametrosGerentes', 'N');
        set('formulario.hIndEstadoParametrosConsultoras', 'N');
        set('formulario.hIndEstadoVariablesVenta', 'N');
        enviaSICC("formulario", "", "", "N");
        
    } else {
        // Consurso Ranking - Modificacion o Consulta
        close();
    }
}
