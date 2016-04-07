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

var borroUltimos = false;

function onLoadPag() {
    
    configurarMenuSecundario("formulario");
    fMostrarMensajeError();
    DrdEnsanchaConMargenDcho('listado1',12);
    focaliza('formulario.txtCodCliente');
    
    document.all["Cplistado1"].style.visibility='hidden';
    document.all["CpLin1listado1"].style.visibility='hidden';
    document.all["CpLin2listado1"].style.visibility='hidden';
    document.all["CpLin3listado1"].style.visibility='hidden';
    document.all["CpLin4listado1"].style.visibility='hidden';

    document.all["primera1Div"].style.visibility='hidden';
    document.all["ret1Div"].style.visibility='hidden';
    document.all["ava1Div"].style.visibility='hidden'; 
    document.all["separaDiv"].style.visibility='hidden';

    document.all["btnDetalleDiv"].style.visibility='hidden';
    document.all["btnModificarDiv"].style.visibility='hidden';
    document.all["btnEliminarDiv"].style.visibility='hidden';
    eval (ON_RSZ);
}

function onChangeCodigoCliente() {
    set('formulario.oidCliente','');
    set('formulario.txtCodCliente', completaCampo('txtCodCliente', '0') );
}

function accionBuscarCliente() {
    var obj = new Object();
    var cliSelecc = mostrarModalSICC('LPBusquedaRapidaCliente','',obj);
             
    if (cliSelecc != null) {
        set("formulario.oidCliente", cliSelecc[0]);
         set("formulario.txtCodCliente", cliSelecc[1]);
    }
}

function onChangePregunta() {
    if (get('formulario.cbPregunta') != '') {
        var arra = new Array();
        arra[0] = ["oid",get('formulario.cbPregunta')];
        arra[1] = ["oidPais",get('formulario.pais')];
        arra[2] = ["oidIdioma",get('formulario.idioma')];
           
        recargaCombo("formulario.cbRespuesta","MAEObtenerRespuestasPorPregunta","es.indra.sicc.util.DTOOID",arra);
    } else {
        vaciarComboRespuestas();
    }
}

function accionBuscar(){
    configurarPaginado(mipgndo,"MAEBuscarEncuestasAplicadasCliente", "ConectorBuscarEncuestasAplicadasCliente",
                        "es.indra.sicc.dtos.mae.DTOEncuestaAplicadaPorCliente", armaArray());
}

function armaArray(){
    var arrDatos = new Array();
    var i=0;

    arrDatos[i] = new Array('oidPais',get('formulario.pais'));
    i++;
    arrDatos[i] = new Array('oidIdioma',get('formulario.idioma'));
    i++;
    if (get('formulario.cbPregunta')!=''){
        arrDatos[i] = new Array('oidPregunta',get('formulario.cbPregunta'));
        i++;
    }
    if (get('formulario.cbRespuesta')!=''){
        arrDatos[i] = new Array('oidRespuesta',get('formulario.cbRespuesta'));
        i++;
    }
    if (get('formulario.txtCodCliente')!=''){
        arrDatos[i] = new Array('codigoCliente',get('formulario.txtCodCliente'));
        i++;
    }
    if (get('formulario.oidCliente')!=''){
        arrDatos[i] = new Array('oidCliente',get('formulario.oidCliente'));
        i++;
    }     
      
    return arrDatos;      
}

function accionDetalle() {
    /* Muestra la ventana modal y emergente PGInsertarEncuestaAplicadaAClientes */
    var codigos = new Array();
    codigos = listado1.codSeleccionados();
    var cant = codigos.length;
    if (cant == 1) {
        var obj = new Object();
        obj.oidEncuestaCliente = codigos[0];
        obj.opcionMenu = get('formulario.opcionMenu');
        focaliza('formulario.txtCodCliente');
        mostrarModalSICC('LPMantenimientoEncuestaAplicadaAClientes',"detalle",obj,750,350);
    } else {
        GestionarMensaje('50');
    }
}

function accionModificar() {
    var codigos = new Array();
    codigos = listado1.codSeleccionados();
    var cant = codigos.length;
  
    if (cant == 1) {
        var oidEncuestaCliente = codigos[0];  // El oid del registro que modificaremos
        var obj = new Object();
        obj.oidEncuestaCliente = oidEncuestaCliente;
        obj.opcionMenu = get('formulario.opcionMenu');
		var arrayDevuelto = mostrarModalSICC('LPMantenimientoEncuestaAplicadaAClientes',"modificar",obj,750,350);
        //accionBuscar();
        if (arrayDevuelto != null && arrayDevuelto.length == 3) {
            listado1.insertaDato(oidEncuestaCliente, 0, arrayDevuelto[0]); //codigoCliente
            listado1.insertaDato(oidEncuestaCliente, 1, arrayDevuelto[1]); //pregunta
            listado1.insertaDato(oidEncuestaCliente, 2, arrayDevuelto[2]); //respuesta
        }
        focaliza('formulario.txtCodCliente');
    } else if (cant < 1) {
        GestionarMensaje('50');
    } else if (cant > 1) {
        cdos_mostrarAlert(GestionarMensaje('240'));
    }
}  

function accionEliminar() {
    var seleccionados = listado1.codSeleccionados();
    var cantSeleccionados = seleccionados.length;
     
    if (cantSeleccionados > 0) {
        if (listado1.datos.length == cantSeleccionados) { // Voy a eliminar el último de mi lista
            borroUltimos = true; // Esta bandera se chequea en el 'onload' del PAGINADO para no mostrar error
        } else {
            borroUltimos = false;
        }
        eliminarFilas(seleccionados, "MAEEliminarEncuestaAplicadaCliente", mipgndo);
        return true;
    } else {
        GestionarMensaje("4", null, null, null);
        return false;
    }
}

function muestraLista(ultima, rowset) {
    var tamano = rowset.length;
            
    if (tamano > 0) {
        visualizarLista();
        return true;
    } else {
        // No se ha encontrado ningún elemento con los criterios especificados
        ocultarLista();
        focaliza('formulario.txtCodCliente');
        return false;
    }

}

function visualizarLista() {
    DrdEnsanchaConMargenDcho('listado1',12);

    document.all["Cplistado1"].style.visibility='';
    document.all["CpLin1listado1"].style.visibility='';
    document.all["CpLin2listado1"].style.visibility='';
    document.all["CpLin3listado1"].style.visibility='';
    document.all["CpLin4listado1"].style.visibility='';

    document.all["primera1Div"].style.visibility='';
    document.all["ret1Div"].style.visibility='';
    document.all["ava1Div"].style.visibility='';
    document.all["separaDiv"].style.visibility='';
        
    if (get('formulario.opcionMenu')=='ModificarEncuestaAplicadaAClientes'){ // Para modificar
        document.all["btnModificarDiv"].style.visibility='visible';
        document.all["btnDetalleDiv"].style.visibility='hidden';
        document.all["btnEliminarDiv"].style.visibility='hidden';
    }
    if (get('formulario.opcionMenu')=='ConsultarEncuestaAplicadaAClientes'){ // Para ver detalle
        document.all["btnModificarDiv"].style.visibility='hidden';
        document.all["btnDetalleDiv"].style.visibility='visible';
        document.all["btnEliminarDiv"].style.visibility='hidden';
    }
    if (get('formulario.opcionMenu')=='EliminarEncuestaAplicadaAClientes'){ // Para eliminar
        document.all["btnModificarDiv"].style.visibility='hidden';
        document.all["btnDetalleDiv"].style.visibility='visible';
        document.all["btnEliminarDiv"].style.visibility='hidden';
		btnProxy(4,1);

    }

    eval (ON_RSZ);
}

function ocultarLista() {
    document.all["Cplistado1"].style.visibility='hidden';
    document.all["CpLin1listado1"].style.visibility='hidden';
    document.all["CpLin2listado1"].style.visibility='hidden';
    document.all["CpLin3listado1"].style.visibility='hidden';
    document.all["CpLin4listado1"].style.visibility='hidden';

    document.all["primera1Div"].style.visibility='hidden';
    document.all["ret1Div"].style.visibility='hidden';
    document.all["ava1Div"].style.visibility='hidden';
    document.all["separaDiv"].style.visibility='hidden';

    document.all["btnDetalleDiv"].style.visibility='hidden';
    document.all["btnModificarDiv"].style.visibility='hidden';
    document.all["btnEliminarDiv"].style.visibility='hidden';


    eval (ON_RSZ);
}
    
function fLimpiar() {
    iSeleccionado = new Array();
    iSeleccionado[0] = '';
    set('formulario.cbPregunta',iSeleccionado);

    arrRes = new Array(); 
    arrRes[arrRes.length] = new Array(); 
    arrRes[arrRes.length] = '';
          
    set_combo('formulario.cbRespuesta',arrRes, []); 
    set( "formulario.txtCodCliente", '');
    set( "formulario.oidCliente", '');
    focaliza('formulario.txtCodCliente');
}

function fBorrar() {
    accionEliminar();
}

function vaciarComboRespuestas() {
    var arrRes = new Array(); 
    arrRes[arrRes.length] = new Array();
    arrRes[0] = "";
    arrRes[1] = "";
    set_combo('formulario.cbRespuesta', arrRes , []);
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


/*  Verifica que el error indicado tenga un codigo que corresponda al pasado
 *  por parametro.
 *  
 *  @param: el mensaje de error, con la forma esperada "<codigo>|<mensaje>" (error)
 *  @param: el codigo de mensaje de error deseado (codigo)
 *  @return: true si coinciden y false en caso contrario o ante falla de formato 
 *  (si el separador no es '|' (pipe)).
 *  
 *  @author: eiraola
 *  @date: 08/03/2006
 *  
 */
function esMensajeErrorIndicado(error, codigo) {
    if(error != null && error.indexOf('|') > -1) {
        var arrError = error.split('|'); //Separa el mensaje de error
        var codigoAux = arrError[0].replace(' ', ''); //Elimina blancos del codigo
        if (codigoAux == codigo) {
            return true; // Hubo coincidencia
        } else {
            return false; // No hubo coincidencia
        }
    }
    return false; // No adecuado a formato
}

/*  Si es el caso en que acabo de borrar todos los registros de
 *  una lista editable devuelve string nulo ('') para que no se 
 *  muestre el mensaje de error "5|No existen datos con el criterio
 *  especificado".
 *  Se la utiliza en el onload del PAGINADO para darle valor a la
 *  variable msgError (antes de realizar procesarPaginado(mipgndo,
 *  msgError,...).
 *
 *  @author: eiraola
 *  @date: 09/03/2006
 *
 */
function administraMensajeNoExistenDatos(mensajeError) {
    if (borroUltimos && esMensajeErrorIndicado(mensajeError, '5')) { 
        borroUltimos = false;
        return ''; 
    } 
    return mensajeError;
}