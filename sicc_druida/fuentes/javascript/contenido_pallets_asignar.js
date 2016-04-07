
var newOid = -1;

function onLoad(){
    configurarMenuSecundario('formulario');
    ocultarLista();
    var parametros = new Array();
    var oid = get('formulario.hOidListaPicadoCabecera','V');
    // Completando DTO
    parametros[parametros.length] = new Array('oidIdioma', get('formulario.varIdioma'));
    parametros[parametros.length] = new Array('oidPais', get('formulario.varPais'));
    if (oid != ''){
          parametros[parametros.length] = new Array('oid', oid);
    }
    // Carga de lista editable
    configurarPaginado(mipgndo,
          'APEBuscarListaDatosPallet',
          'ConectorBuscarListaDatosPallet',
          'es.indra.sicc.util.DTOOID',
          parametros);
}

function accionBtnDesdoblar(){
    listado1.actualizaDat();
    var codSeleccionados = listado1.codSeleccionados();
    if (codSeleccionados.length > 1) {
        GestionarMensaje('1022');
        return;
    }
    if ( codSeleccionados.length < 1) {
        GestionarMensaje('4');
        return;
    }
    
    var obj = new Object();
    obj.numUnidades = listado1.extraeDato(codSeleccionados[0], 3)*1;
    
    if(obj.numUnidades<2){
        GestionarMensaje('3378');  // No se puede desdoblar una linea con un solo articulo
        return;
    }
    
    var retorno = mostrarModalSICC('LPCubicajeAFP', 'desdoblar', obj);
    
    if(!retorno){
        return;
    }
    
    //
    // Logica para desdoblar linea en pantalla
    //
    var nuevaMatrizDatos = new Array();
	var cantLineas = listado1.datos.length;
    
    for (var i = 0; i < cantLineas; i++) {
        if (listado1.datos[i][0] == codSeleccionados[0]) {
            // Actualizar numero de unidades
            var filaDesdoblada = listado1.datos[i];
            filaDesdoblada[4] = (filaDesdoblada[4]-retorno);
            nuevaMatrizDatos[nuevaMatrizDatos.length] = filaDesdoblada;
            
            // Generar nueva linea
            var nuevaFila = new Array(18);
            nuevaFila[0] = (newOid--);
            nuevaFila[1] = listado1.datos[i][1];
            nuevaFila[2] = listado1.datos[i][2];
            nuevaFila[3] = listado1.datos[i][3];
            nuevaFila[4] = retorno;                // numero unidades
            nuevaFila[5] = '';                     // numero pallet destino
            nuevaFila[6] = listado1.datos[i][6];
            nuevaFila[7] = listado1.datos[i][7]; 
            nuevaFila[8] = listado1.datos[i][8];   // validar valor
            nuevaFila[9] = listado1.datos[i][9];
            nuevaFila[10] = listado1.datos[i][10];
            nuevaFila[11] = listado1.datos[i][11];
            nuevaFila[12] = '';
            nuevaFila[13] = listado1.datos[i][13];
            nuevaFila[14] = '';
            nuevaFila[15] = '';
            nuevaFila[16] = '';
            nuevaFila[17] = '';
            
            nuevaMatrizDatos[nuevaMatrizDatos.length] = nuevaFila;
        } else {
            nuevaMatrizDatos[nuevaMatrizDatos.length] = listado1.datos[i];
        }
        
    }
    listado1.setDatos(nuevaMatrizDatos);
}

function onClickGuardar(){
    //if (!sicc_validaciones_generales()) {
    //      return false;
    //}
    
    // Validaciones de numeros de caja introducidos
    var codigos = listado1.codigos();
    for(var id=0; id<codigos.length; id++ ){
        // Valida formato de txtZona
        if(!sicc_valida_numero_general(listado1.extraeDato(codigos[id], 4), 'N° pallet', '0', '999', 'Entero')) {
            //listado1.preparaCamposDR();
            focaliza_general('NroPallet_'+id);
            return;
        }
    }

    // Prepara arreglo para enviar a LP
    formulario.oculto = 'S';
    set('formulario.hLineas',preparaLineas());
    set('formulario.conectorAction', 'LPCubicajeAFP');
    set('formulario.accion', 'guardarListaDatosPallet');
    //enviaSICC('formulario', null, null, 'N');
    enviaSICC('formulario');
    
}

function fVolver() {
    this.close();
}

function fGuardar(){
    onClickGuardar();
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
        focaliza('formulario.cbCentroDistribucion');
        return false;  
    }
}

function preparaLineas(){
    var lineas = '';
    var separaCol = '; ';
    var separaFil = '| '
    
    var fil=0;
    var listaDatos = listado1.datos;
    for(fil=0; fil<listaDatos.length; fil++){
        var linea = listaDatos[fil];
        if(linea[0]*1<0){
            linea[0] = ''; 
        }
        var col=0;
        for(col=0; col<linea.length; col++){
            lineas = lineas + linea[col] + separaCol;
        }
        lineas = lineas.substr(0,lineas.length-2) + separaFil; // se quitan 2 caracteres ya que el separador tiene 2 espacios
    }
    lineas = lineas.substr(0,lineas.length-2); // se quitan 2 caracteres ya que el separador tiene 2 espacios

    return lineas;
}

function ejecutaOK(){
    //alert('OK');
    // Indicar las acciones a seguir en caso la accion de 
    // guardarListaDatosPallet finalize correctamente
}

function ejecutaERROR(){
    //alert('BAD');
    // Indicar las acciones a seguir en caso la accion de 
    // guardarListaDatosPallet NO finalize correctamente
}


function sicc_valida_numero_general(strName, strMostrar, valorMinimo, valorMaximo, tipo) {
	var formulario_local = getFormularioSICC();
	var valorTest = strName;
	if(valorTest==""){
		return true;
	}
	var strSepDec = "";
	var strSepMil = "";
	var strCantDec = "";

	switch(tipo){
		case "Numerico":
			strCantDec="2";
			strSepDec = get(formulario_local+".hSeparadorDecimalPais");
			strSepMil = get(formulario_local+".hSeparadorMilesPais");
			break;
		case "Entero":
			strCantDec="0";
			strSepDec = get(formulario_local+".hSeparadorDecimalPais");
			strSepMil = get(formulario_local+".hSeparadorMilesPais");
			break;
		case "Moneda":
			strCantDec = get(formulario_local+".hCantidadDecimalesPais");
			strSepDec = get(formulario_local+".hSeparadorDecimalPais");
			strSepMil = get(formulario_local+".hSeparadorMilesPais");
			break;
		case "MonedaAlternativa":
			strCantDec = get(formulario_local+".hCantidadDecimalesAlternativos");
			strSepDec = get(formulario_local+".hSeparadorDecimalAlternativo");
			strSepMil = get(formulario_local+".hSeparadorMilesAlternativo");
			break;
	}
	

	//aca normalizo la cantidad de decimales, ya que nada me asegura
	//que el formato admita decimales, aunque seria lo logico.
	//Si la cantidad de decimales no es un numero valido, entonces es cero.
	if(isNaN(parseInt(strCantDec,10))){
		strCantDec = 0;
	}else{
		strCantDec=parseInt(strCantDec,10);
	}

	//Primero me fijo si es un numero, para eso
	//le saco todos los separadores
	var strCleaned = valorTest.split(strSepDec).join("");
	strCleaned = strCleaned.split(strSepMil).join("")+"";
	
	if(!parseInt(strCleaned.substr(0,1),10) && parseInt(strCleaned.substr(0,1),10)!=0){//si el primero no es un numero, puede ser solo el simbolo negativo
		if(strCleaned.substr(0,1)!="-"){
			cdos_mostrarAlert(GestionarMensaje("000000000000100" ,  strMostrar));
			//sicc_focaliza_componente(strName);
			return false;
		}else{//tambien lo saco para testear el numero
			strCleaned = strCleaned.substr(1);
		}
	}

	var RegInteger = /^\d+$/; //Solo numeros
	if(!RegInteger.test(strCleaned)){
		cdos_mostrarAlert(GestionarMensaje("000000000000100" ,  strMostrar));
		//sicc_focaliza_componente(strName);
		return false;
	}
	
	//Ahora se que es un numero, primero valido los decimales
	//el ultimo debe ser un numero
	if(isNaN(parseInt(valorTest.substr(valorTest.length-1),10))){
			cdos_mostrarAlert(GestionarMensaje("000000000000100" ,  strMostrar));
			//sicc_focaliza_componente(strName);
			return false;
	}

	//me fijo el largo de los decimales
	var arrTest = valorTest.split(strSepDec);
	if(arrTest.length ==2 && arrTest[1]!=null && arrTest[1]!=""){//si tiene decimales
		if(parseInt(strCantDec,10)==0){
			cdos_mostrarAlert(GestionarMensaje("000000000000104"));
			//sicc_focaliza_componente(strName);
			return false;
		}
		var strDecimales = arrTest[arrTest.length-1]+"";
		if(strDecimales.length > parseInt(strCantDec,10)){//me fijo cuantos son
			cdos_mostrarAlert(GestionarMensaje("000000000000101" ,  strMostrar,parseInt(strCantDec,10)));
			//sicc_focaliza_componente(strName);
			return false;
		}
	}else{
		if(arrTest.length > 2){//sino
			cdos_mostrarAlert(GestionarMensaje("000000000000102" ,  strMostrar));
			//sicc_focaliza_componente(strName);
			return false;
		}
	}
	//ahora voy por la parte entera

	var strInteger = arrTest[0]+"";
	
	if(strInteger.indexOf(strSepMil) >- 1){//si tiene separadores de miles
		var arrInteger = strInteger.split(strSepMil);
		//en todo el array los numero son de a 3 digitos
		//excepto en la primera posicion, 
		//donde solo no pueden ser 4 digitos
		for(var i=0; i < arrInteger.length; i++){
			if(i==0){
				if((arrInteger[i]+"").length>3){
					cdos_mostrarAlert(GestionarMensaje("000000000000100" ,  strMostrar));
					//sicc_focaliza_componente(strName);
					return false;
				}
			}else{
				if((arrInteger[i]+"").length!=3){
					cdos_mostrarAlert(GestionarMensaje("000000000000105",strSepMil));
					//sicc_focaliza_componente(strName);
					return false;
				}
			}
		}
	}


	//por ultimo valido el rango del valor
	//saco el separador de miles
	var strNumeroTest = valorTest.split(strSepMil).join("");
	//si el separador decimal es el punto, lo dejo, sino, lo reemplazo por el punto
	if(strSepDec!="."){
		strNumeroTest  = strNumeroTest.split(strSepDec).join(".")
	}
	
	if(valorMinimo!=""){
		if(parseFloat(strNumeroTest )<parseFloat(valorMinimo)){
			cdos_mostrarAlert(GestionarMensaje("000000000000103" ,  strMostrar,parseFloat(valorMinimo),parseFloat(valorMaximo)));
			//sicc_focaliza_componente(strName);
			return false;
		}
	}	
	if(valorMaximo!=""){
		if(parseFloat(strNumeroTest)>parseFloat(valorMaximo)){
			cdos_mostrarAlert(GestionarMensaje("000000000000103" ,  strMostrar,parseFloat(valorMinimo),parseFloat(valorMaximo)));
			//sicc_focaliza_componente(strName);
			return false;
		}
	}
	return true;
}

function focaliza_general(js_nombre){
    document.all[js_nombre+''].focus();
    document.all[js_nombre+''].select();
}
