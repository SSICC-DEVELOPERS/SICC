/**
* Copyright 2005 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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

var FORMULARIO = 'formulario';


function onLoadPag()   {
    eval (ON_RSZ);  
    configurarMenuSecundario(FORMULARIO);

    set(FORMULARIO+'.cargado', "true");
    focaliza(FORMULARIO+'.cbEstadoContacto');
}

function ontabBtnActualizarContacto(){
    focaliza(FORMULARIO+'.cbEstadoContacto');
}

function onshtabCbEstadoContacto(){
    document.all['btnActualizarContacto'].focus();
}

function onChangeEstadoContacto(){
    recargaCombo(FORMULARIO+'.cbAtributoEstado', 'CALObtenerAtributoEstado', 'es.indra.sicc.util.DTOOID', 
                        [['oid', get(FORMULARIO+'.cbEstadoContacto')], 
                        ['oidPais', get(FORMULARIO+'.pais')], 
                        ['oidIdioma', get(FORMULARIO+'.idioma')]] );
}

function accionActualizarContacto(){
    if (!sicc_validaciones_generales()) { 
        return false; 
    }
    eval(FORMULARIO).oculto = "S";
    set(FORMULARIO+'.conectorAction', 'LPPresentarClientes'); 
    set(FORMULARIO+'.accion', 'Actualizar');
    enviaSICC(FORMULARIO); 
}

function fLimpiar(){
    focaliza(FORMULARIO+'.cbEstadoContacto');
}

function fVolver(){
    window.close();
}