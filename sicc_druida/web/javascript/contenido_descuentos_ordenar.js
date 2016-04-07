// SPLATAS - BELC300021890 - 06/06/2006
var listaResultado = new Array();

function onLoadPag()   {
     
    configurarMenuSecundario("formulario");
    DrdEnsanchaConMargenDcho('listado1',12);
    ocultarLista();
    eval (ON_RSZ);  
    // Seteo del combo inicial
    if( ( get("formulario.casoDeUso") == 'descuentoDefinido' ) || 
        ( get("formulario.casoDeUso") == 'buscar' ) ){
        
        if(get("formulario.vacia")=="S"){
        
            btnProxy(1,'0');
            GestionarMensaje("1397",null,null,null);
            
        } else {
        
            mostrarLista();
            iSeleccionado = new Array(); 
            iSeleccionado[0] = get('formulario.marcaInit') == ""? 
                                    "0":
                                    get('formulario.marcaInit');
            set('formulario.cbMarca',iSeleccionado);
                     
            var iSeleccionadoC = new Array(); 
            iSeleccionadoC[0] =  get('formulario.canalInit') == ""?
                                    "0":
                                    get('formulario.canalInit');
            set('formulario.cbCanal',iSeleccionadoC);           
           
            // SPLATAS - BELC300021890 - 06/06/2006
            for(var i = 0; i < listado1.datos.length; i++){
                listaResultado[i] = listado1.datos[i];
            }
            // FIN

        }
    }
    
    focaliza('formulario.cbMarca','');   
    
}

//------------------------------------------------------------------------------
function ocultarLista(){

    document.all["Cplistado1"].style.visibility='hidden';
    document.all["CpLin1listado1"].style.visibility='hidden';
    document.all["CpLin2listado1"].style.visibility='hidden';
    document.all["CpLin3listado1"].style.visibility='hidden';
    document.all["CpLin4listado1"].style.visibility='hidden';
    document.all["separaDiv"].style.visibility='hidden';
    document.all["primera1Div"].style.visibility='hidden';
    document.all["ret1Div"].style.visibility='hidden';
    document.all["ava1Div"].style.visibility='hidden';
    document.all["btnSubirDiv"].style.visibility='hidden';
    document.all["btnBajarDiv"].style.visibility='hidden';

}

//------------------------------------------------------------------------------
function mostrarLista(){

    document.all["Cplistado1"].style.visibility='visible';
    document.all["CpLin1listado1"].style.visibility='visible';
    document.all["CpLin2listado1"].style.visibility='visible';
    document.all["CpLin3listado1"].style.visibility='visible';
    document.all["CpLin4listado1"].style.visibility='visible';
    document.all["separaDiv"].style.visibility='visible';
    document.all["primera1Div"].style.visibility='visible';
    document.all["ret1Div"].style.visibility='visible';
    document.all["ava1Div"].style.visibility='visible';
    document.all["btnSubirDiv"].style.visibility='visible';
    document.all["btnBajarDiv"].style.visibility='visible';

}

//------------------------------------------------------------------------------
function fGuardar(){
    // MODIFICADO POR SPLATAS - BELC300021890 - 06/06/2006
    // Se verifica si cambió el orden de los descuentos.
    var modificado = "0";

    for(i = 0; i < listado1.datos.length; i++){
        if( listaResultado[i] != listado1.datos[i] ){  
            modificado = "1";
            break;
        } 
    }    
    // FIN
    
    //Funcion modificada por Cristian Valenzuela
    //Incidencia Peru PE_T400000230
    //11/2/2005
    //Principio
    listado1.actualizaDat();
    var datosFinales = listado1.datos;

    for(var i=0; i < datosFinales.length; i++) {
        var periodofin = datosFinales[i][5];
        if(periodofin=="") {
            //Para que no se rompa el parseo en la LP
            datosFinales[i][5] = " ";
        }
    }

    listado1.setDatos(datosFinales);
    //Fin

    if(listado1.datos.length != 0){
        var i;
        var j;
        var stream = "";
        for (i = 0; i < listado1.datos.length; i++) 	{
            for (j = 0; j<listado1.datos[i].length;j++){
                stream = stream+"|"+listado1.datos[i][j];
            }
        }
        
        set('formulario.stream',stream);
        set('formulario.accion', 'guardar');
        
        // MODIFICADO POR SPLATAS - BELC300021890 - 06/06/2006
        var resultado = enviaSICC('formulario');
        
        if( resultado ){     
            if( modificado == "1"){     
                GestionarMensaje('3337',null,null,null);
        
            }
        }
        // FIN MODIFICACION
    }
    
}

//------------------------------------------------------------------------------
function fVolver(){
}

//------------------------------------------------------------------------------
function fBorrar(){
}

//------------------------------------------------------------------------------	
function fLimpiar()	{
    listado1.load();
    focaliza('formulario.cbMarca','');   
}

//------------------------------------------------------------------------------
function botonBuscar(){
    if(sicc_validaciones_generales("g1")){
        set('formulario.accion', 'buscar');
        enviaSICC('formulario');
    }	
}

//------------------------------------------------------------------------------
function accionBajar(){
    var posicion;
    posicion = posLinea();
    listado1.actualizaDat();

    if( posicion < (listado1.datos.length -1) && posicion != null){
        //Agregado por Cristian Valenzuela
        //Incidencia Peru PE_T400000230
        //11/2/2005
        //Principio
        var datosOriginales = listado1.datos;
        var datosOriginalesBis = duplicaArray(datosOriginales);
        //Fin

        var arrAux1 = new Array();

        for( var i = 0; i < posicion; i++){
            arrAux1[arrAux1.length] = listado1.datos[i];
        }
        
        arrAux1[arrAux1.length] = listado1.datos[posicion + 1];
        arrAux1[arrAux1.length] = listado1.datos[posicion];

        for(var i = posicion + 2; i < listado1.datos.length; i++){
            arrAux1[arrAux1.length] = listado1.datos[i];
        }
        
        listado1.deselecciona(posicion);
        listado1.setDatos(arrAux1);
        listado1.repinta;

        //Agregado por Cristian Valenzuela
        //Incidencia Peru PE_T400000230
        //11/2/2005
        //Principio
        var datosActualizados = listado1.datos;
        for(var i = 0; i<datosActualizados.length; i++) {
            datosActualizados[i][1] = datosOriginalesBis[i][1];
        }	
        
        listado1.setDatos(datosActualizados);			
        //Fin
    }
}

//------------------------------------------------------------------------------
//Funcion agregada por Cristian Valenzuela
//Incidencia Peru PE_T400000230
//11/2/2005
function duplicaArray(param){
    var valorToReturn = new Array();
    if ( param != ""){
        var cantFilas = param.length;
        var cantCols = param[0].length;
        
        for (var i = 0; i < cantFilas; i++)	{
            
            var nuevaFila = new Array();
            
            for (var j = 0; j < cantCols; j++)	{	
                var dato = param[i][j];
                nuevaFila[j] = dato;
            }
            
            valorToReturn[i] = nuevaFila;
        }
    }
    
    return valorToReturn;
}

//------------------------------------------------------------------------------
function accionSubir(){
    var posicion;
    posicion = posLinea();
    listado1.actualizaDat();

    if( posicion > 0 && posicion != null){

        //Agregado por Cristian Valenzuela
        //Incidencia Peru PE_T400000230
        //11/2/2005
        //Principio
        var datosOriginales = listado1.datos;
        var datosOriginalesBis = duplicaArray(datosOriginales);
        //Fin

        var arrAux1 = new Array();

        for( var i = 0; i < posicion-1; i++){
            arrAux1[arrAux1.length] = listado1.datos[i];
        }
        arrAux1[arrAux1.length] = listado1.datos[posicion];
        arrAux1[arrAux1.length] = listado1.datos[posicion-1];

        for(var i = posicion + 1; i < listado1.datos.length; i++){
            arrAux1[arrAux1.length] = listado1.datos[i];
        }
        
        listado1.deselecciona(posicion);
        listado1.setDatos(arrAux1);			
        listado1.repinta;

        //Agregado por Cristian Valenzuela
        //Incidencia Peru PE_T400000230
        //11/2/2005
        //Principio
        var datosActualizados = listado1.datos;
        for(var i = 0; i<datosActualizados.length; i++) {
            datosActualizados[i][1] = datosOriginalesBis[i][1];
        }	
        
        listado1.setDatos(datosActualizados);			
        //Fin
    }
}

//------------------------------------------------------------------------------
function posLinea(){
    var oid = listado1.codSeleccionados();
    
    if(listado1.datos.length != 0){
        var i;
        var pos = 0;
        rf	= new Array();
        
        for (i = 0; i < listado1.datos.length; i++){
            rf = listado1.datos[i];
            
            if(rf[0] == oid)	{
                pos = i;
            }
        }
        
        return pos;
    }
}

//------------------------------------------------------------------------------
// focaliza desde el boton buscar segun la lista resultado oculta o visible
function focalizaDesdeBusqueda() {  
    document.selection.empty();
    
    // si esta visible la capa de resultado de busqueda
    if(document.all["Cplistado1"].style.visibility == 'visible') {
        document.all.btnSubir.focus();
    
    } else {
        focaliza('formulario.cbMarca');
    }
}

//------------------------------------------------------------------------------
// focaliza desde el boton bajar
function focalizaDesdeBajar() {  
    document.selection.empty();
    focaliza('formulario.cbMarca');
}

//------------------------------------------------------------------------------
// focaliza sifhtTab desde el combo marca
function focalizaShiftDesdeMarca() {
    document.selection.empty();
    
    // si esta visible la capa de resultado de busqueda
    if(document.all["Cplistado1"].style.visibility == 'visible') {
        document.all.btnBajar.focus();
    
    } else {
        document.all.btnBuscar.focus();
    }
}

//------------------------------------------------------------------------------
// focaliza sifhtTab desde el boton bajar
function focalizaShiftDesdeSubir() {
    document.selection.empty();
	document.all.btnBuscar.focus();
}



