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


function onLoadPag() {

    configurarMenuSecundario("formulario");
    fMostrarMensajeError();
      
    if (get('formulario.cerrar') == "S") {
        set('formulario.cerrar', "N");
        window.close();
    }

    if (get('formulario.habilitarEdicionCampos') == "N") {
        deshabilitarCampos();
    }
    
    if (get('formulario.opcionMenu') == "InsertarEncuestaAplicadaAClientes") {
        focaliza('formulario.txtCodCliente');

    } else { // Para consultar (detalle) y modificar
        varNoLimpiarSICC = true;
        accion('formulario.txtCodCliente','.disabled=true');
        ocultarImagen('lupa');
        if (get('formulario.recupera') == "S") { // Si se recarga por un error de insersión
            set('formulario.recupera', "N");
            set('formulario.oidPregunta', get('formulario.hPregunta'));
            set('formulario.oidRespuesta', get('formulario.hRespuesta'));
            //cargarCombosConValorSeleccionado();
            //onChangePregunta();
			window.returnValue = null;
        }
        if (get('formulario.opcionMenu') == "ConsultarEncuestaAplicadaAClientes") {
            deshabilitarCampos();
        }
        cargarCombosConValorSeleccionado();
        onChangePregunta();
        focaliza('formulario.cbPregunta');
    }

}

function fGuardar() {
    accionGuardar();
    if (get('formulario.opcionMenu') == "ModificarEncuestaAplicadaAClientes") {
        var arrayParaDevolver = new Array();
                  
        arrayParaDevolver[0] = get('formulario.txtCodCliente');
        arrayParaDevolver[1] = get('formulario.cbPregunta','T').toString(); // La descripcion de la pregunta
        arrayParaDevolver[2] = get('formulario.cbRespuesta','T').toString(); // La descripcion de la respuesta
    
        window.returnValue = arrayParaDevolver;
    }
}

function fLimpiar() {
    if (get('formulario.opcionMenu') == "InsertarEncuestaAplicadaAClientes") {
        set('formulario.txtCodCliente','');
        set( "formulario.oidCliente", '');

        iSeleccionado = new Array();
        iSeleccionado[0] = '';
        set('formulario.cbPregunta',iSeleccionado);

        arrRes = new Array(); 
        arrRes[arrRes.length] = new Array(); 
        arrRes[arrRes.length] = '';
        set_combo('formulario.cbRespuesta',arrRes, []);
    }
    if (get('formulario.opcionMenu') == "ModificarEncuestaAplicadaAClientes") {
        iSeleccionado = new Array();
        iSeleccionado[0] = get('formulario.oidPregunta');
        set('formulario.cbPregunta',iSeleccionado);
        onChangePregunta();
    }
}
  
function fVolver() {
    if (get('formulario.opcionMenu') != "InsertarEncuestaAplicadaAClientes") {
        window.returnValue = null; // Para que no actualice el LISTADO si no se 'guardó' correctamente.
        window.close();
    }
}

function onChangeCodigoCliente() {
    set('formulario.oidCliente','');
    set('formulario.txtCodCliente', completaCampo('txtCodCliente', '0') );
}

function onChangePregunta() {
    if (get('formulario.cbPregunta') != '') {
        var arra = new Array();
        arra[0] = ["oidPais",get('formulario.pais')]; 
        arra[1] = ["oidIdioma",get('formulario.idioma')]; 
        arra[2] = ["oid",get('formulario.cbPregunta')];
        recargaCombo("formulario.cbRespuesta","MAEObtenerRespuestasPorPregunta","es.indra.sicc.util.DTOOID",arra, "cargaComboRespuestas(datos)");
    } else {
        vaciarComboRespuestas();
    }
}

function accionBuscarCliente() {
    if ( get('formulario.opcionMenu') == "InsertarEncuestaAplicadaAClientes" ) {
        var obj = new Object();
        var clien = mostrarModalSICC('LPBusquedaRapidaCliente','',obj);
        /* La LPBusquedaRapidaCliente devuelve un array con datos del cliente
           seleccionado por el usuario */
        if (clien != null) {
            set("formulario.txtCodCliente", clien[1]);
            set("formulario.oidCliente", clien[0]);
            focaliza('formulario.cbPregunta');
        }
      
    } else {
        // No debe hacer nada cuando opcionMenu es para Detalle ni Modificar
    }

}

function accionGuardar() {
    if(!sicc_validaciones_generales()){
        return false;
    }
    set('formulario.conectorAction','LPMantenimientoEncuestaAplicadaAClientes');
    set('formulario.accion','guardar');
    enviaSICC('formulario');
}

function cargaComboRespuestas(datos) {
    var arrRes = new Array(); 
    arrRes[arrRes.length] = new Array();

    if (datos!='') {    
        for(var i=0; i<datos.length;i++){
            arrRes[arrRes.length] = datos[i];
        } 
        set_combo('formulario.cbRespuesta',arrRes, []); 
        if (get('formulario.oidRespuesta')!=''){ 
            iSeleccionadob = new Array();
            iSeleccionadob[0] = get('formulario.oidRespuesta'); 
            set('formulario.cbRespuesta',iSeleccionadob); 
        }
    } else { // Si la pregunta no trae respuestas, mostramos cbRespuesta vacio
        arrRes[0] = "";
        arrRes[1] = "";
        set_combo('formulario.cbRespuesta', arrRes , []);
    }
}

function cargarCombosConValorSeleccionado() {
    iSeleccionado = new Array();
    iSeleccionado[0] = get('formulario.oidPregunta');
    set('formulario.cbPregunta',iSeleccionado);
}

function deshabilitarCampos() {
    accion('formulario.txtCodCliente','.disabled=true');
    accion('formulario.cbPregunta','.disabled=true');
    accion('formulario.cbRespuesta','.disabled=true');
}

function poneManito(nombre) {
    if ( get('formulario.opcionMenu') == "InsertarEncuestaAplicadaAClientes" ) {
        var obj = document.getElementById(nombre);
        obj.style.cursor = "hand";
    }
}

function ocultarImagen(nombre) {
    if ( get('formulario.opcionMenu') != "InsertarEncuestaAplicadaAClientes" ) {
        var obj = document.getElementById(nombre);        
        obj.height = "0";
        obj.width = "0";
    }
}

function vaciarComboRespuestas() {
    var arrRes = new Array(); 
    arrRes[arrRes.length] = new Array();
    arrRes[0] = "";
    arrRes[1] = "";
    set_combo('formulario.cbRespuesta', arrRes , []);
}


function txtCodClienteSTab() {
    if (get('formulario.opcionMenu') == "InsertarEncuestaAplicadaAClientes") {
        focaliza('formulario.cbRespuesta');
    }
}

function cbPreguntaSTab() {
     var opcion = get('formulario.opcionMenu'); 
     if (opcion == "InsertarEncuestaAplicadaAClientes") {
         focaliza('formulario.txtCodCliente');
     }
     if (opcion == "ModificarEncuestaAplicadaAClientes") {
         focaliza('formulario.cbRespuesta');
     }
}

function cbRespuestaTab() {
    var opcion = get('formulario.opcionMenu'); 
    if (opcion == "InsertarEncuestaAplicadaAClientes") {
        focaliza('formulario.txtCodCliente');
    }
    if (opcion == "ModificarEncuestaAplicadaAClientes") {
        focaliza('formulario.cbPregunta');
    }
}

/*  Completa el campo cuyo 'nombre' (atributo Druida del tag CTEXTO) se indique,
 *  repitiendo el caracter que se pasa como parametro (pad) hasta alcanzar el tope 
 *  del campo en cuestión (indicado en el atributo 'max' del tag CTEXTO).
 *  
 *  @param: el nombre que identifica a un campo de texto de la página (nombreCampo)
 *  @param: el caracter con que se quiere completar el contenido del campo (pad)
 *  @return: un string con el texto para cargarle al campo.
 *  
 *  @author: eiraola
 *  @date: 06/03/2006
 *  
 */
function completaCampo(nombreCampo, pad) {
    var obj = document.getElementById(nombreCampo);
    var cantidadMaxima = 11;// Lo ideal sería asignar la capacidad del campo: obj.maxLength;

    if ( obj.value.length != '0' ) { // El campo debe tener algún valor para que lo completemos
        while(obj.value.length < cantidadMaxima) {
            obj.value= pad + obj.value;
        }
    }
    return obj.value;
}