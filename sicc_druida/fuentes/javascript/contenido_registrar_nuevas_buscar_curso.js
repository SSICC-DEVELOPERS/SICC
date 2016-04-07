var FORMULARIO = "formulario";

function onLoad(){        
    /*
    if (get(FORMULARIO+'.errDescripcion')!='') {
        var wnd = fMostrarMensajeError(get(FORMULARIO+'.errCodigo'),get(FORMULARIO+'.errDescripcion'));
    }*/
    DrdEnsanchaConMargenDcho('listado1',12);
    configurarMenuSecundario(FORMULARIO);
    eval(ON_RSZ);
    focaliza(FORMULARIO+'.cbMarca');  
}
    
function onSeleccionaMarca(){
    var marca = get(FORMULARIO+'.cbMarca');
    var idioma = get(FORMULARIO+'.idioma');
    var pais = get(FORMULARIO+'.pais');
    
    if(marca != 0){
        recargaCombo(FORMULARIO+'.cbTipoCurso', 'CMNObtieneTiposCurso', 'es.indra.sicc.dtos.edu.DTODruidaBusqueda', [['oidIdioma',idioma],['oidMarca', marca],['oidPais',pais]] );
        focaliza(FORMULARIO+'.cbTipoCurso');
    } else{
        set_combo(FORMULARIO+'.cbTipoCurso',[['','']],['']);
        focaliza(FORMULARIO+'.cbMarca'); 
    }
    
}

function compruebashtab(){                                   
    if (get_visibilidad("capaLista")){                
        document.all['InvitarParticipantes'].focus();   
    }else{                                                
        document.all['btnBuscar'].focus();      
    }                                                     
}                                                                 

function compruebatab(){                                     
    if (get_visibilidad("capaLista")){                
        document.all['Aceptar'].focus();   
    }else{                                                
        focaliza(FORMULARIO+'.cbMarca');         
    }  
}

function validarCodCurso(){
    var num = get(FORMULARIO+'.txtCodCurso'); 
    if(num != ""){
        var val = allTrim(num);              
        //Como no nos interesa validar el número de dígitos que tiene el 
        //entero ponemos uno suficientemente grande. 
        if ((ValidaInt(val.toString(),10000, 0)!="OK")||(val.toString() < 0)) {
            GestionarMensaje('747', null, null, null);
            focaliza(FORMULARIO+'.txtCodCurso');
            return false;
        }
    }
}

function allTrim(sStr){ 
    return rTrim(lTrim(sStr)); 
}

function lTrim(sStr){ 
    while (sStr.charAt(0) == " "){
        sStr = sStr.substr(1, sStr.length - 1); 
    }
    return sStr; 
} 

function rTrim(sStr){ 
    while (sStr.charAt(sStr.length - 1) == " ") {
        sStr = sStr.substr(0, sStr.length - 1); 
    }
    return sStr; 
}                                 

function onClickBuscar(){
    //Este método se ejecuta cuando pulsa sobre btnBuscar. 
    //Se carga la lista lstCursos(listado1) con los cursos que cumplen el criterio de búsqueda especificado por el usuario. 
         
    var marca = get(FORMULARIO+'.cbMarca');
    var canal = get(FORMULARIO+'.cbCanal');
    var tipocurso = get(FORMULARIO+'.cbTipoCurso');
    var codigocurso= get(FORMULARIO+'.txtCodCurso');
    var nombrecurso= get(FORMULARIO+'.txtNombreCurso');
    var idioma = get(FORMULARIO+'.idioma');
    var pais = get(FORMULARIO+'.pais');
    
    var parametros = new Array();
    parametros[parametros.length] = new Array('oidPais', pais);
    parametros[parametros.length] = new Array('oidIdioma', idioma);
    if(marca!=''){
        parametros[parametros.length] = new Array('marca', marca);
    }
    if(canal!=''){
        parametros[parametros.length] = new Array('canal', canal);
    }
    if(tipocurso!=''){
        parametros[parametros.length] = new Array('tipoCurso', tipocurso);
    }
    if(codigocurso!=''){
        parametros[parametros.length] = new Array('codigo', codigocurso);
    }
    if(nombrecurso!=''){
        parametros[parametros.length] = new Array('nombre', nombrecurso);
    }
    
    configurarPaginado(mipgndo, 
                        "EDUConsultaCursosRegistrarNuevas", 
                        "ConectorBusquedaCursosRegistrarNuevas", 
                        "es.indra.sicc.dtos.edu.DTOConsultaCurso", 
                        parametros);
         
}

function onClickAceptar(){
    /* Cuando se pulsa el botón btnAceptar, 
       si hay un curso seleccionado en la lista lstCursos(listado1), 
       se abre una ventana emergente modal 
       y en la nueva ventana se invoca LPRegistrarNuevas con: 
            accion = "RegistrarNuevas" 
            oid = el oid del curso seleccionado en lstCursos
    */	
    if (listado1.numSelecc() == 0) {
        //Mostramos mensaje de error 
        GestionarMensaje('1021');
        return;
    } 
    if (listado1.numSelecc()!=1) {
        //Muesta el mensaje: "Debe seleccionar un solo registro"
        GestionarMensaje('1022');
        //Se limpia la lista editable
        var seleccion=listado1.codigos();
        var i=0;
        while(seleccion[i]!=null){
            listado1.deselecciona(i);
            i++;
        }
        return;
    }
    
    listado1.actualizaDat();
    var datos = listado1.datos;
    var objParams = new Object();
    var cods = listado1.codSeleccionados();
    objParams.oid = cods[0];
    objParams.oidTipoCurso = listado1.extraeDato(cods[0], 7);

    mostrarModalSICC('LPRegistrarNuevas', 'RegistrarNuevas', objParams, null, null);

}


function visibleLista() {
    if (!get_visibilidad("capaLista")){
        visibilidad('capaLista','V');
        //DrdEnsanchaConMargenDcho('listado1',12);
        //eval (ON_RSZ);  
    }
}

function invisibleLista() {
    if (get_visibilidad("capaLista")){
        visibilidad('capaLista','O');
    }
}

function muestraLista(ultima, rowset){
    var tamano = rowset.length;
    if (tamano > 0) {
        visibleLista();
        return true;
    } else {
        invisibleLista();
        focaliza(FORMULARIO+'.cbMarca');
        return false;
    }
}

/*
function obtieneIndicePorCodigo(codigo, lista) {
   eval(lista    + ".actualizaDat();");
   var datos = eval(lista + ".datos;");
   var indice = -1;
   var match = false; 

   for (var i = 0; (i < datos.length) && (!match); i++) {
             var codigoLista = datos[i];
             if ( parseInt( codigo, 10) == parseInt(codigoLista , 10) ) {
                              indice = i;
                              match = true;
             }
   }

   return indice;
}
*/
