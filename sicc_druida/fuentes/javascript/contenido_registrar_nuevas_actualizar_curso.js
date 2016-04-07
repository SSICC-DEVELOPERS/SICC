var FORMULARIO="formulario";
var contador = 1;

function onLoad()   
{            
         if (get(FORMULARIO+'.errDescripcion')!='') {
                  var wnd = fMostrarMensajeError(get(FORMULARIO+'.errCodigo'),get(FORMULARIO+'.errDescripcion'));
         } 
         DrdEnsanchaConMargenDcho('listado1',12); 
         configurarMenuSecundario(FORMULARIO);
         document.all["Cplistado1"].style.visibility=''; 
         document.all["CpLin1listado1"].style.visibility='';  
         document.all["CpLin2listado1"].style.visibility=''; 
         document.all["CpLin3listado1"].style.visibility='';
         document.all["CpLin4listado1"].style.visibility='';  
         
         document.all["primera1Div"].style.visibility=''; 
         document.all["ret1Div"].style.visibility='';
         document.all["ava1Div"].style.visibility='';  
         document.all["separaDiv"].style.visibility=''; 
         eval (ON_RSZ);  
         
}

function onClickAceptar(){
    var cadena = "";
    listado1.actualizaDat(); //Actualiza el array 'datos'
    datosFinal = listado1.datos;
    for (i = 0; i < datosFinal.length; i++) {
        var fila = datosFinal[i];
        cadena += fila[0] + "@" + fila[2] + "@" + fila[7] + "#";
    }
    set(FORMULARIO+'.lista', cadena);
    set(FORMULARIO+'.conectorAction',"LPRegistrarNuevas");
    set(FORMULARIO+'.accion',"Registrar");
    enviaSICC(FORMULARIO);      
}

function insercionCorrecta(codigoError, codigosNOValidos, codigosValidos){

    if ( codigosValidos != '' ) {
        var regValidos = codigosValidos.split(",");
        for (var i = 0; i < regValidos.length; i++) {
            var indice = obtieneIndicePorCodigo(regValidos[i], 'listado1');
            if ( indice != -1) {
                listado1.eliminar(indice);
            }
        }
    }

    if ( codigoError != '' ) {
        GestionarMensaje(codigoError);
        var regNOValidos = codigosNOValidos.split(",");
        
        /*
        for (var i = 0; i < regNOValidos.length; i++) {
            var indice = obtieneIndicePorCodigo(regNOValidos[i], 'listado1');
            if ( indice != -1) {
                listado1.ponColorFondoFila(indice, 'red');
            }
        }
        */
        
    }
}

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


function resaltaFila(indice, color) {
    listado1.ponColorFondoFila(indice, 'red');
}

function validaFormularioOnBlur(fila){
    validaFecha(fila);
}

function validaFecha(numFila) {
    var resul = 0;
    var fecha = "";
    listado1.actualizaDat();
    datosFinal = listado1.datos;
    var fila = datosFinal[numFila];
    fecha=fila[4];

    if(fecha != ""){
        resul = EsFechaValida(fecha,fecha, FORMULARIO,null);
        if(resul==1 || resul==2){  
            GestionarMensaje('1006', get(FORMULARIO+'.hFormatoFechaPais')); 
            mandaElFoco(numFila);
            return false;
        } else{
            return true;
        }
    }   
}        

function mandaElFoco(fila){  // focaliza una caja de texto
    var nombrelistado="listado1"; 
    var nombreCajaText="Texto1"; 
    var indiceFila=fila;   //Empezando desde 0 
    eval(nombrelistado+".preparaCamposDR()"); 
    focaliza('frm'+nombrelistado+'.'+nombreCajaText+'_'+indiceFila,''); //Focalizo 
} 

function fLimpiar(){
    /*
    listado1.actualizaDat();
    var datosFinal = listado1.datos;
    for (i = 0; i < datosFinal.length; i++) {
         datosFinal[i][4] = ''; 
    }
    listado1.reajusta();
    mandaElFoco(0);
    */
    set(FORMULARIO + '.txtCodigoCliente', '');
    set(FORMULARIO + '.txtFechaAsistenciaCurso', '');
    listado1.setDatos(new Array());
    focaliza(FORMULARIO + ".txtCodigoCliente");
}

function fVolver(){
    //cerramos la ventana
    window.close();              
}

function muestraLista( ultima, rowset){
    var tamano = rowset.length;
    if (tamano > 0) {
        //visibleLista();
        return true;
    } else {
        window.close();	
        return false;
    }
}

/*function visibleLista(){                                     
         visibilidad('capaLista','V'); 
         DrdEnsanchaConMargenDcho('listado1',12);
    eval (ON_RSZ);  
         document.body.focus();
    setTimeout('listado1.form.Texto1_0.focus();var tr=listado1.form.Texto1_0.createTextRange();tr.execCommand("SelectAll");',5)   
}

function noVisibleLista() { 
          visibilidad('capaLista','O');
}*/

function focalizaAnterior(FILAEVENTO, TECLAEVENTO){
    if (TECLAEVENTO == 9 && FILAEVENTO == 0) {
        //document.all['Aceptar'].focus();
    }
}

function accionBuscar() {
    var obj = new Object();
    var busquedaRapida = mostrarModalSICC('LPBusquedaRapidaCliente', '', obj);

    if ( busquedaRapida != null && busquedaRapida != undefined) {
        var oidCliente = busquedaRapida[0];
        var codCliente = busquedaRapida[1];
        var nombre1 =    busquedaRapida[2];
        var nombre2 =    busquedaRapida[3];
        var apellido1 =  busquedaRapida[4];
        var apellido2 =  busquedaRapida[5];

        set(FORMULARIO + '.oidCliente', oidCliente);
        set(FORMULARIO + '.txtCodigoCliente', codCliente);
        set(FORMULARIO + '.nombre1', nombre1);
        set(FORMULARIO + '.nombre2', nombre2);
        set(FORMULARIO + '.apellido1', apellido1);
        set(FORMULARIO + '.apellido2', apellido2);
    }
}

function accionAniadir() {
    var oidCliente = get(FORMULARIO + '.oidCliente');

    if ( sicc_validaciones_generales('grupoPPal') ) {
        if ( oidCliente == null || oidCliente == undefined || oidCliente == '') {
            // Busco los datos del cliente para el Código de Cliente ingresado. 
            eval(FORMULARIO).oculto="S";
            codCliente = get(FORMULARIO + '.txtCodigoCliente');
            set(FORMULARIO + '.codigoCliente', codCliente);
            set(FORMULARIO + '.conectorAction', 'LPRegistrarNuevas');
            set(FORMULARIO + '.accion', 'ObtenerDatosCliente');
            enviaSICC(FORMULARIO);
        } else {
            var nuevaFila = new Array();
            listado1.actualizaDat();
            var oidCliente = get(FORMULARIO + '.oidCliente');
            var codCliente = get(FORMULARIO + '.txtCodigoCliente');
            if(!validarCodigoCliente(codCliente)){
                return;
            }
            var nombre1 = get(FORMULARIO + '.nombre1');
            var nombre2 = get(FORMULARIO + '.nombre2');
            var apellido1 = get(FORMULARIO + '.apellido1');
            var apellido2 = get(FORMULARIO + '.apellido2');
            var fecha = get(FORMULARIO  + '.txtFechaAsistenciaCurso');
            
            nuevaFila[0] = contador;
            nuevaFila[1] = codCliente;
            nuevaFila[2] = fecha;
            if(apellido1 == 'null'){
                nuevaFila[3] = '';
            }else{
                nuevaFila[3] = apellido1;
            }

            if(apellido2 == 'null'){
                nuevaFila[4] = '';
            }else{
                nuevaFila[4] = apellido2;
            }

            if(nombre1 == 'null'){
                nuevaFila[5] = '';
            }else{
                nuevaFila[5] = nombre1;
            }
            
            if(nombre2 == 'null'){
                nuevaFila[6] = '';
            }else{
                nuevaFila[6] = nombre2;
            }
                  
            nuevaFila[7] = oidCliente;
            listado1.insertar(nuevaFila);
            contador++;
            
            set(FORMULARIO + '.oidCliente', '');
            set(FORMULARIO + '.txtCodigoCliente', '');
            //set(FORMULARIO + '.txtFechaAsistenciaCurso', '');
            set(FORMULARIO + '.codigoCliente', '');
            set(FORMULARIO + '.nombre1', '');
            set(FORMULARIO + '.nombre2', '');
            set(FORMULARIO + '.apellido1', '');
            set(FORMULARIO + '.apellido2', '');
        
            focaliza(FORMULARIO + ".txtCodigoCliente");
            
        }
    }
}

function codigoClienteOnBlur() {
    var codigoCliente = get(FORMULARIO + '.txtCodigoCliente').toString();

    if (codigoCliente != '') {
        var longitudCodigoCliente = get(FORMULARIO + '.hLongitudCodigoCliente').toString();
        var longitud = codigoCliente.length;
        var cadena = rellenaCeros(codigoCliente, longitudCodigoCliente, longitud);
        set(FORMULARIO + '.txtCodigoCliente', cadena);
    }
}

function limpiaVarsOcultas() {
    set(FORMULARIO + '.oidCliente', '');
    set(FORMULARIO + '.nombre1', '');
    set(FORMULARIO + '.nombre2', '');
    set(FORMULARIO + '.apellido1', '');
    set(FORMULARIO + '.apellido2', '');
}

function anyadeCampoALista(oidCliente, nombre1, nombre2, apellido1, apellido2) {
    // Tomo codigoCliente de la caja de texto.
    var codigoCliente = get(FORMULARIO + '.txtCodigoCliente');
    
    if(validarCodigoCliente(codigoCliente)){
        // Tomo fecha. 
        var fecha = get(FORMULARIO + '.txtFechaAsistenciaCurso');
        listado1.actualizaDat();
        var nuevaFila = new Array();
        nuevaFila[0] = contador;
        nuevaFila[1] = codigoCliente;
        nuevaFila[2] = fecha;
        if(apellido1 == 'null'){
            nuevaFila[3] = '';
        }else{
            nuevaFila[3] = apellido1;
        }
        if(apellido2 == 'null'){
            nuevaFila[4] = '';
        }else{
            nuevaFila[4] = apellido2;
        }
    
        if(nombre1 == 'null'){
            nuevaFila[5] = '';
        }else{
            nuevaFila[5] = nombre1;
        }
        
        if(nombre2 == 'null'){
            nuevaFila[6] = '';
        }else{
            nuevaFila[6] = nombre2;
        }
                      
        nuevaFila[7] = oidCliente;
        //alert("nuevaFila: " + nuevaFila);
        var datos = listado1.datos;
        datos[datos.length] = nuevaFila;
        //listado1.insertar(nuevaFila);
        listado1.setDatos(datos);
    
        set(FORMULARIO + '.oidCliente', '');
        set(FORMULARIO + '.txtCodigoCliente', '');
        //set(FORMULARIO + '.txtFechaAsistenciaCurso', '');
        set(FORMULARIO + '.codigoCliente', '');
        set(FORMULARIO + '.nombre1', '');
        set(FORMULARIO + '.nombre2', '');
        set(FORMULARIO + '.apellido1', '');
        set(FORMULARIO + '.apellido2', '');
    
        focaliza(FORMULARIO + ".txtCodigoCliente");
    
        contador++;
    }
}

function validarCodigoCliente(codigoCliente){
    listado1.actualizaDat(); //Actualiza el array 'datos'
    datosFinal = listado1.datos;
    
    for (i = 0; i < datosFinal.length; i++) {
        var codCliente = datosFinal[i][1];
        if(codigoCliente == codCliente) {
            cdos_mostrarAlert('El codigo de cliente ya existe en la lista.')
            return false;
        }
    }
    return true;
}

function errorBusquedaCliente() {
    focaliza(FORMULARIO + ".txtCodigoCliente");
}

function fBorrar() {
    var codSelec = listado1.codSeleccionados();
    var cantCodigos = codSelec.length;

    if (cantCodigos > 0) {
        listado1.eliminarSelecc();
    } else {
        GestionarMensaje('UIEDU0008');
    }
}

function fGuardar() {
         onClickAceptar();
}

function errorRegistraAsistencia() {
}
