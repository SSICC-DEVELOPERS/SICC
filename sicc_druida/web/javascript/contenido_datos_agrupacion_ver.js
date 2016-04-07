function onLoad(){
    configurarMenuSecundario('formulario');
    ocultarLista();
    var parametros = new Array();
    var oidCentroDistribucion = get('formulario.hOidCentroDistribucion','V');
    var codAgrupacion = get('formulario.hCodAgrupacion','V');
    // Completando DTO
    parametros[parametros.length] = new Array('oidIdioma', get('formulario.varIdioma'));
    parametros[parametros.length] = new Array('oidPais', get('formulario.varPais'));
    if (oidCentroDistribucion != ''){
          parametros[parametros.length] = new Array('oidCentroDistribucion', oidCentroDistribucion);
    }
    if (codAgrupacion != ''){
          parametros[parametros.length] = new Array('numeroAgrupacion', codAgrupacion);
    }
    // Carga de lista editable
    configurarPaginado(mipgndo,
          'APEDatosAgrupacionVer',
          'ConectorDatosAgrupacionVer',
          'es.indra.sicc.dtos.ape.DTODatosAgrupacion',
          parametros);
}

function fVolver() {
    this.close();
}

function ocultarLista() {
    document.all["Cplistado1"].style.visibility='hidden';
    document.all["CpLin1listado1"].style.visibility='hidden';
    document.all["CpLin2listado1" ].style.visibility='hidden';
    document.all["CpLin3listado1"].style.visibility='hidden';
    document.all["CpLin4listado1"].style.visibility='hidden';
    document.all["primera1Div"].style.visibility='hidden';
    document.all["ret1Div"].style.visibility='hidden';
    document.all["ava1Div"].style.visibility='hidden';
    document.all["separaDiv"].style.visibility='hidden';    
}

function mostrarLista(){

    DrdEnsanchaConMargenDcho('listado1',12);
    document.all["Cplistado1"].style.visibility='visible';
    document.all["CpLin1listado1"].style.visibility='visible';
    document.all["CpLin2listado1"].style.visibility='visible';
    document.all["CpLin3listado1"].style.visibility='visible';
    document.all["CpLin4listado1"].style.visibility='visible';
    document.all["primera1Div"].style.visibility='hidden';
    document.all["ret1Div"].style.visibility='hidden';
    document.all["ava1Div"].style.visibility='hidden';
    document.all["separaDiv"].style.visibility='hidden';
    eval (ON_RSZ);
}

function muestraLista(ultima, rowset) {
    if (rowset && rowset!=null && rowset.length > 0) {
        mostrarLista();
        return true; 
    }else{
        ocultarLista();
        return false;  
    }
}
