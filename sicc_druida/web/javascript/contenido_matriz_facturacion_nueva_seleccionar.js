function fLimpiar(){
        setearCombos();
        cambioMarcaCanal('true');
        focaliza('frmContenido.cbMarca','');
    }
	

    var formName = "frmContenido";
    function LoadBar(){
        configurarMenuSecundario("frmContenido");
        setearCombos();
        cambioMarcaCanal('true');
        focaliza('frmContenido.cbMarca','');
        fMostrarMensajeError();
    }

    function setearCombos(){
        var array = new Array();
        array[0]= get('frmContenido.hidMarca');
        set('frmContenido.cbCanal',array);
        array = new Array();
        array[0]= get('frmContenido.hidCanal');
        set('frmContenido.cbMarca',array);
    }
            
    function fGuardar() {
        if (sicc_validaciones_generales()){
            set('frmContenido.hCanal',get('frmContenido.cbCanal','V'));
            set('frmContenido.hMarca',get('frmContenido.cbMarca','V'));
            set('frmContenido.hPeriodo',get('frmContenido.cbPeriodo','V'));
							
            set('frmContenido.hidDescCanal',get('frmContenido.cbCanal','T'));
            set('frmContenido.hidDescMarca',get('frmContenido.cbMarca','T'));
            set('frmContenido.hidDescPeriodo',get('frmContenido.cbPeriodo','T'));
							         
            set('frmContenido.accion','Guardar');
            enviaSICC('frmContenido');
        }
    }

    function cambioMarcaCanal(escanal){
        if (get('frmContenido.cbMarca')!=''
        &&get('frmContenido.cbCanal')!=''){
            accion('frmContenido.cbPeriodo','.disabled=false');
            var oid = get('frmContenido.cbCanal').toString();
            var marca= get('frmContenido.cbMarca').toString();
            frmContenido.hidCanal = oid;
            frmContenido.hidMarca = marca;
            if(oid != "") {                    
                recargaCombo("frmContenido.cbPeriodo","PRECargarPeriodos","es.indra.sicc.dtos.cra.DTOPeriodo",makeParameters(), "despuesCambio(datos)");
            }      
        }else{
            set_combo('frmContenido.cbPeriodo',new Array());
            accion('frmContenido.cbPeriodo','.disabled=true');
        }
    }

    function despuesCambio(datos){
        set_combo('frmContenido.cbPeriodo',datos, []);
        if (datos.length==0) {
            //accion('frmContenido.cbPeriodo','.disabled=true');
        }
        var longCombo = combo_get("frmContenido.cbMarca", "L", "");

        if (!(longCombo >=1)){
            focaliza('frmContenido.cbMarca');
        }

        if( get('frmContenido.cbPeriodo')==''){
            document.body.onfocus = poneFocoEnMarca;
        }
        else
            focaliza('frmContenido.txtPedEstimados');
    }

    function poneFocoEnMarca(){
        focaliza('frmContenido.cbMarca');
    }

    function makeParameters() {
        var array = new Array();
        var i=0;
        array[i] = new Array('pais',get('frmContenido.hidPais'));
        i++;
        array[i] = new Array('marca',get('frmContenido.cbMarca'));
        i++;
        array[i] = new Array('canal',get('frmContenido.cbCanal'))
        return array;
    }

    function formarCadena(idBusiness , dto, parametros) {
        var cadena = idBusiness + "|" + dto + "|"; 
        for(i=0;i<parametros.length;i++) {
            cadena += parametros[i][0] + "=" + parametros[i][1];
            if (i!= parametros.length-1) {
                cadena += "&";
            }
        }
        return cadena;
    }


/*************************************************************************************
 ************************Esto es una flor de Basura***********************************
 ************************************************************************************/

function sicc_valida_numero(strName, strMostrar, valorMinimo, valorMaximo, tipo) {
	var formulario_local = getFormularioSICC();
	var valorTest = get(formulario_local+"."+strName);
	if(valorTest==""){
		return true;
	}
	var strSepDec = "";
	var strSepMil = "";
	var strCantDec = "";

	switch(tipo){
		case "Numerico":
			strCantDec="5";
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
			sicc_focaliza_componente(strName);
			return false;
		}else{//tambien lo saco para testear el numero
			strCleaned = strCleaned.substr(1);
		}
	}

	var RegInteger = /^\d+$/; //Solo numeros
	if(!RegInteger.test(strCleaned)){
		cdos_mostrarAlert(GestionarMensaje("000000000000100" ,  strMostrar));
		sicc_focaliza_componente(strName);
		return false;
	}
	
	//Ahora se que es un numero, primero valido los decimales
	//el ultimo debe ser un numero
	if(isNaN(parseInt(valorTest.substr(valorTest.length-1),10))){
			cdos_mostrarAlert(GestionarMensaje("000000000000100" ,  strMostrar));
			sicc_focaliza_componente(strName);
			return false;
	}

	//me fijo el largo de los decimales
	var arrTest = valorTest.split(strSepDec);
	if(arrTest.length ==2 && arrTest[1]!=null && arrTest[1]!=""){//si tiene decimales
		if(parseInt(strCantDec,10)==0){
			cdos_mostrarAlert(GestionarMensaje("000000000000104"));
			sicc_focaliza_componente(strName);
			return false;
		}
		var strDecimales = arrTest[arrTest.length-1]+"";
		if(strDecimales.length > parseInt(strCantDec,10)){//me fijo cuantos son
			cdos_mostrarAlert(GestionarMensaje("000000000000101" ,  strMostrar,parseInt(strCantDec,10)));
			sicc_focaliza_componente(strName);
			return false;
		}
	}else{
		if(arrTest.length > 2){//sino
			cdos_mostrarAlert(GestionarMensaje("000000000000102" ,  strMostrar));
			sicc_focaliza_componente(strName);
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
					sicc_focaliza_componente(strName);
					return false;
				}
			}else{
				if((arrInteger[i]+"").length!=3){
					cdos_mostrarAlert(GestionarMensaje("000000000000105",strSepMil));
					sicc_focaliza_componente(strName);
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
			sicc_focaliza_componente(strName);
			return false;
		}
	}	
	if(valorMaximo!=""){
		if(parseFloat(strNumeroTest)>parseFloat(valorMaximo)){
			cdos_mostrarAlert(GestionarMensaje("000000000000103" ,  strMostrar,parseFloat(valorMinimo),parseFloat(valorMaximo)));
			sicc_focaliza_componente(strName);
			return false;
		}
	}
	return true;
}