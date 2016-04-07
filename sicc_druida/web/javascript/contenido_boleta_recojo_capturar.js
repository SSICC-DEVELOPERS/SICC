var dtoBoletas;
var busco;
var autogenerado = new Number(0);
var primera = true;
	
	function ocultaTodo(){
		ocultarSeleccion();         
	}

	function muestraTodo(){	
		mostrarSeleccion();         
	}
    
    function onLoadPag()   {
        configurarMenuSecundario("frmContenido"); 
				
        DrdEnsanchaConMargenDcho('listado1',12);
        eval (ON_RSZ);

		ocultaTodo();
		busco = false;
		set('frmContenido.txtFechaCaptura', get('frmContenido.hFechaIni'));
		setearCombosEstado();

		focaliza('frmContenido.txtFechaCaptura'); 
    }
	
    function setearCombosEstado(){
        var array = new Array();
        array[0]= get('frmContenido.hEstado');//seteado el dato en la variable oculta en la pagina
        set('frmContenido.cbEstado',array);
    }

	function ShowError() {
	  if (get('frmContenido.errCodigo') != ''){
			fMostrarMensajeError();
	   }
	}

    function makeParameters() {
        var array = new Array();
        var i=0;
        array[i] = new Array('pais',get('frmContenido.oidPais'));
        i++;
        array[i] = new Array('marca',get('frmContenido.cbMarca'));
        i++;
        array[i] = new Array('canal',get('frmContenido.cbCanal'))
        return array;
    }

    function botonAceptar(){

        if(!sicc_validaciones_generales("Recepcionar")){
          return false;
        }

   	    accion('frmContenido.txtFechaCaptura','.disabled=true');
		accion('frmContenido.cbEstado','.disabled=true');

		//desmarco los seleccionados
		var codigos = listado1.codigos();
		var longitud = codigos.length;
		for(var i=0;i<longitud;i++) {
			listado1.deselecciona(i);    
		}

		if (busco) {

		} else {
			//busqueda listado 1
			configurarPaginado(mipgndo1,"RECObtenerBoletasRecojoTemporal",
							  "ConectorObtenerBoletasRecojoTemporal",
							  "es.indra.sicc.dtos.rec.DTOFiltroBoletasRecojo",
							  armaArray());
		}
		busco = true;
		muestraTodo();

		eval(ON_RSZ);

		focaliza('frmContenido.txtNroBoleta');
    }        

   function armaArray(){ 
      var arrDatos = new Array();
      var i=0;

      if (get('frmContenido.oidIdioma')!=''){
             arrDatos[i] = new Array('oidIdioma',get('frmContenido.oidIdioma'));
             i++;
      }
      if (get('frmContenido.oidPais')!=''){
             arrDatos[i] = new Array('oidPais',get('frmContenido.oidPais'));
             i++;
      }
      if (get('frmContenido.cbEstado')!=''){
             arrDatos[i] = new Array('estado',get('frmContenido.cbEstado'));
             i++;
      }
      if (get('frmContenido.txtFechaCaptura')!=''){
             arrDatos[i] = new Array('fechaCaptura',get('frmContenido.txtFechaCaptura'));
             i++;
      }
      if (get('frmContenido.hUsuario')!=''){
             arrDatos[i] = new Array('idUsuario',get('frmContenido.hUsuario'));
             i++;
      }
      return arrDatos;
                    
  }

function trim(cadena) {
	for(i=0; i<cadena.length; )
	{
		if(cadena.charAt(i)==" ")
			cadena=cadena.substring(i+1, cadena.length);
		else
			break;
	}

	for(i=cadena.length-1; i>=0; i=cadena.length-1)
	{
		if(cadena.charAt(i)==" ")
			cadena=cadena.substring(0,i);
		else
			break;
	}
	
	return cadena;
}

  function botonIngresar(){

        if(!sicc_validaciones_generales("Ingresar")){
          return false;
        }

		primer();

		var toAdd = "";
		var nroBoleta = get('frmContenido.txtNroBoleta')+"";

		var checkBR = nroBoleta.substring(0,2);

		checkBR = checkBR.toUpperCase();

		if (checkBR=='BR') {
			nroBoleta = nroBoleta.substring(2,nroBoleta.length);
			nroBoleta = trim(nroBoleta);
		}

		//relleno con ceros a izquierda a 10 - 00000000000000000000
		var tam = 10 - nroBoleta.length;
		var ceros = '';
		for (var i=0; i<tam; i++){
			ceros = '0' + ceros;
		}
		nroBoleta = ceros + nroBoleta;
		set('frmContenido.txtNroBoleta', nroBoleta);
		


		autogenerado++;
		toAdd = autogenerado;
		toAdd = toAdd + "|" + nroBoleta;
		toAdd = toAdd + "|" + " ";
		toAdd = toAdd + "|" + " ";
		toAdd = toAdd + "|" + "";
		
		pasaListaTemporal(autogenerado, toAdd, nroBoleta); //esto antes del guardado logico por si ya existe.

		if(muestraMsg == false){ // si no existe.
			var posEncontrada = -1;
			var cantBoletas = dtoBoletas.boletas.length;
			
			for (var i = 0; i<cantBoletas ; i++) {
				if (dtoBoletas.boletas[i].nroBoleta == nroBoleta) {
					posEncontrada = i;
				}
			}			
			
			if (posEncontrada!=-1) {
				if (dtoBoletas.boletas[posEncontrada].tipoOperacion=='BAJA') {
					if (dtoBoletas.boletas[posEncontrada].oid==null||
						dtoBoletas.boletas[posEncontrada].oid=='') {
						dtoBoletas.boletas[posEncontrada].tipoOperacion = 'ALTA';
					} else {
						dtoBoletas.boletas[posEncontrada].tipoOperacion = '';
					}
				}
			} else {
				var posicion = dtoBoletas.boletas.length;
				dtoBoletas.boletas[posicion] = new Object();
				dtoBoletas.boletas[posicion].nroBoleta = nroBoleta;
				dtoBoletas.boletas[posicion].oid = '';
				dtoBoletas.boletas[posicion].ordenIngreso = autogenerado;
				dtoBoletas.boletas[posicion].tipoOperacion = 'ALTA';
			}
			set('frmContenido.txtNroBoleta','');
		}

		if(muestraMsg == true){
			autogenerado--;
			muestraMsg = false;
			GestionarMensaje("83", null,null,null);
		} else {
			//desmarco los seleccionados
			var codigos = listado1.codigos();
			var longitud = codigos.length;
			for(var i=0;i<longitud;i++) {
				listado1.deselecciona(i);    
			}
		}
		btnProxy(4, '1');
		document.all["EliminarDiv"].style.visibility='visible'; 

		focaliza('frmContenido.txtNroBoleta');
    }

	var muestraMsg = false;
			 
	function pasaListaTemporal(codigo, datos, nroBoleta){
	var codigosTemporal = listado1.codigos();
		var match = rowMatch(nroBoleta, codigosTemporal);
		if (match){
			muestraMsg = true;
		}else{
			datos = codigo + "|" + datos;  // Agrega el codigo al String de valores. 
			var newRow = new Array();
			newRow = datos.split("|");
			listado1.insertar(newRow);
		}
	}


	function dejaEsp(a){
		if (a==null||a.length == 0){
			return ' ';
		}else{
			return a;
	  }
	}

	function quitaEsp(a){
		if (a == ' '){
			return '';
		}else{
			return a;
	  }
	}

	function rowMatch(codigo, codigosTemporal){
		  var flag = false;
		  var i = 0;
		  while ( (i < codigosTemporal.length) && (flag == false) ){
			   if ( codigo == listado1.extraeDato(codigosTemporal[i], 1))
					flag = true;      
			   i++;
		  }
		  return flag;
	}

	function botonProcesar(){
		btnProxy(4, '0');
		document.all["EliminarDiv"].style.visibility='hidden'; 

		document.all["ProcesarDiv"].style.visibility='hidden'; 
		primer();

		serializarDtoBoletas();
		serializarBoletas();

		set('frmContenido.hFechaCaptura',get('frmContenido.txtFechaCaptura'));
		set('frmContenido.conectorAction','LPCapturarBoletasRecojo');
		set('frmContenido.accion','procesar');
		enviaSICC('frmContenido');
	}

	function procesarResultado(resultado) {

		busco = false;
		dtoBoletas = null;
		primera = true;

		var temp = resultado.split("&");
		var listaOriginal = listado1.datos;
		var listaNueva = new Array();

		for (var i=0; i<listaOriginal.length; i++) {
			for (var j=0; j<temp.length; j++) {
				var fila = temp[j].split("#");
				if (listaOriginal[i][0]==fila[0]) {
					var pos = listaNueva.length;
					listaNueva[pos] = new Array();
					listaNueva[pos][0] = listaOriginal[i][0];
					listaNueva[pos][1] = listaOriginal[i][0];
					listaNueva[pos][2] = listaOriginal[i][2];
					listaNueva[pos][3] = fila[1];
					listaNueva[pos][4] = listaOriginal[i][4];
					listaNueva[pos][5] = listaOriginal[i][5];
				}
			}
		}
		listado1.setDatos(listaNueva);

		document.all["ProcesarDiv"].style.visibility='visible'; 
		btnProxy(4, '0');
		document.all["EliminarDiv"].style.visibility='hidden'; 
		focaliza('frmContenido.txtNroBoleta');

	}
	function procesoOK() {
		busco = false;
		dtoBoletas = null;
		primera = true;
		botonAceptar();

		GestionarMensaje("2619");
		document.all["ProcesarDiv"].style.visibility='visible'; 
		limpiar();
	}
	function guardoOK() {
		
		busco = false;
		dtoBoletas = null;
		primera = true;
		botonAceptar();

		GestionarMensaje("2618");
		document.all["ProcesarDiv"].style.visibility='visible'; 
	}

	function primer(){
		if (primera) {
			var codigos = listado1.codigos();
			if (dtoBoletas==null) {
				dtoBoletas = new Object();
				dtoBoletas.boletas = new Array();
				dtoBoletas.oidPais = get('frmContenido.oidPais');
				dtoBoletas.oidIdioma = get('frmContenido.oidIdioma');
				dtoBoletas.fechaCaptura = get('frmContenido.txtFechaCaptura');
				dtoBoletas.estado = get('frmContenido.cbEstado');

			} else {
				if (dtoBoletas.boletas==null) {
					dtoBoletas.boletas = new Array();
				}		
			}
			for (var i=0; i<codigos.length ; i++) {
				var posicion = dtoBoletas.boletas.length;
				var ordenIngreso = new Number(listado1.extraeDato(codigos[i], 0));
				dtoBoletas.boletas[posicion] = new Object();
				dtoBoletas.boletas[posicion].nroBoleta = listado1.extraeDato(codigos[i], 1);
				dtoBoletas.boletas[posicion].oid = listado1.extraeDato(codigos[i], 4);
				if (listado1.extraeDato(codigos[i], 2)!='') {
					dtoBoletas.boletas[posicion].preValidado = 'SI';
				} else {
					dtoBoletas.boletas[posicion].preValidado = 'NO';
				}
				dtoBoletas.boletas[posicion].ordenIngreso = ordenIngreso;
				dtoBoletas.boletas[posicion].tipoOperacion = '';

				if (autogenerado<ordenIngreso) {
					autogenerado = ordenIngreso;
				}
			}
			primera = false;
		}
	}

	function fGuardar(){ 

		primer();
		//pasar lo de guardado logico a var ocultas
		serializarDtoBoletas();
		serializarBoletas();
		
		set('frmContenido.hFechaCaptura',get('frmContenido.txtFechaCaptura'));
		set('frmContenido.conectorAction','LPCapturarBoletasRecojo');
		set('frmContenido.accion','guardar');
		enviaSICC('frmContenido');
	}
	
	function serializarDtoBoletas() {
		var aux = "";

		aux = "estado=" + dtoBoletas.estado;
		aux = aux + "|" + "oidPais=" + dtoBoletas.oidPais;
		aux = aux + "|" + "oidIdioma=" + dtoBoletas.oidIdioma;

		set("frmContenido.hdtoBoletas",aux);
	}
	
	function serializarBoletas() {
		var aux = "";
		
		if (dtoBoletas.boletas!=null&&dtoBoletas.boletas.length>0) {
			var tam = dtoBoletas.boletas.length;
			for (var i=0;i<tam;i++)	{
				aux = aux + "oid=" + dtoBoletas.boletas[i].oid;
				aux = aux + "|ordenIngreso=" + dtoBoletas.boletas[i].ordenIngreso;
				aux = aux + "|numeroBoleta=" + dtoBoletas.boletas[i].nroBoleta;
				aux = aux + "|tipoOperacion=" + dtoBoletas.boletas[i].tipoOperacion;
				aux = aux + "|preValidado=" + dtoBoletas.boletas[i].preValidado;
				aux = aux + "|idUsuario=" + get('frmContenido.hUsuario');				
				aux = aux + "&";
			}
		}
		set("frmContenido.hBoletas",aux);
	}

	function botonResultado() {
		var parametros = new Object();
		parametros.txtFecCaptura = get('frmContenido.txtFechaCaptura');
		parametros.oidEstado = get('frmContenido.cbEstado','V');
		
		var an = screen.availWidth;
		var al = screen.availHeight;

		var res = mostrarModalSICC("LPGestionarBoletaRecProcesada", "gestionarBolProcesadas", parametros, an, al);
	}
	
	function botonEliminar() {
		  var elemSel = listado1.codSeleccionados();
		  if ( elemSel.length == 0 ){
			GestionarMensaje("4", null, null, null);
		  }else{
				primer();
				//eliminar logicamente			
				for(var a = 0; a < elemSel.length ; a++){
					var cod = elemSel[a];					
					var cantBoletas = 0;
					if (dtoBoletas!=null&&dtoBoletas.boletas!=null) {
						cantBoletas = dtoBoletas.boletas.length;
					} 
					
					var posEncontrada = -1;
					for (var i = 0; i<cantBoletas ; i++) {
						if (dtoBoletas.boletas[i].ordenIngreso == cod) {
							posEncontrada = i;
						}
					}
					if (posEncontrada!=-1){
						//se setea a baja
						dtoBoletas.boletas[posEncontrada].tipoOperacion = 'BAJA';
					} else {
						//se agrega para luego dar de baja fisicamente.
						if (dtoBoletas==null) {
							dtoBoletas = new Object();
							dtoBoletas.boletas = new Array();
							dtoBoletas.oidPais = get('frmContenido.oidPais');
							dtoBoletas.oidIdioma = get('frmContenido.oidIdioma');
							dtoBoletas.fechaCaptura = get('frmContenido.txtFechaCaptura');
							dtoBoletas.estado = get('frmContenido.cbEstado');
						} 
						var posicion = dtoBoletas.boletas.length;
						dtoBoletas.boletas[posicion] = new Object();
						var ordenIngreso = new Number(listado1.extraeDato(elemSel[a], 0));
						dtoBoletas.boletas[posicion].oid = listado1.extraeDato(elemSel[a], 4);
						dtoBoletas.boletas[posicion].nroBoleta = listado1.extraeDato(elemSel[a], 1);
						dtoBoletas.boletas[posicion].tipoOperacion = 'BAJA';
						dtoBoletas.boletas[posicion].ordenIngreso = ordenIngreso;	
					}
				}
				listado1.eliminarSelecc();
		  }
	}

	function fBorrar() {
			 botonEliminar();      
	}

	function fLimpiar() {
		 // preguntar si continua sin guardar los cambios en caso de no haber guardado
		 // eliminar todos los datos almacenados logicamente
		 // habilitar MCP
		 if (busco) {
			 if (GestionarMensaje('751')) {
				limpiar();
			 }
		 } else {
			limpiar();
		 }
	}

	function limpiar() {
		 accion('frmContenido.txtFechaCaptura','.disabled=false');
		 accion('frmContenido.cbEstado','.disabled=false');
		 set('frmContenido.txtNroBoleta','');
		 set('frmContenido.txtFechaCaptura', get('frmContenido.hFechaIni'));
		 setearCombosEstado();
		 btnProxy(4, '1');
		 dtoBoletas = null;
		 autogenerado = new Number(0);
		 busco = false;
		 primera = true;
		 ocultaTodo();
		 focaliza('frmContenido.txtFechaCaptura'); 
	}

	 function mostrarSeleccion(){
			 document.all["Cplistado1"].style.visibility='visible'; /*
			 document.all["separa1Div"].style.visibility='visible';
			 document.all["primera1Div"].style.visibility='visible'; 
			 document.all["ret1Div"].style.visibility='visible'; 
			 document.all["ava1Div"].style.visibility='visible';*/
			 document.all["CpLin1listado1"].style.visibility='visible';
			 document.all["CpLin2listado1"].style.visibility='visible';
			 document.all["CpLin3listado1"].style.visibility='visible';
			 document.all["CpLin4listado1"].style.visibility='visible';
			 document.all["EliminarDiv"].style.visibility='visible';    
			 accion('frmContenido.txtNroBoleta','.disabled=false');
			 document.all["ProcesarDiv"].style.visibility='visible';  
			 document.all["ResultadoDiv"].style.visibility='visible';  

			document.all["capaContenido"].childNodes[1].style.visibility='visible';	
	 }
	 function ocultarSeleccion(){
			 //Al principio se debe ocular la lista
			 document.all["Cplistado1"].style.visibility='hidden';   //la lista se llama listado1 pero hay que anteponer Cp
/*			 document.all["separa1Div"].style.visibility='hidden';
			 document.all["primera1Div"].style.visibility='hidden';     //el boton se llama prim1 pero hay que poner al final Div*/
			 document.all["ret1Div"].style.visibility='hidden'; 
			 document.all["ava1Div"].style.visibility='hidden';   
			 document.all["CpLin1listado1"].style.visibility='hidden';   //para ocultar las lineas que conforman el marco
			 document.all["CpLin2listado1"].style.visibility='hidden'; 
			 document.all["CpLin3listado1"].style.visibility='hidden'; 
			 document.all["CpLin4listado1"].style.visibility='hidden';
			 document.all["EliminarDiv"].style.visibility='hidden';  // Para ocultar los botones  
			 document.all["ProcesarDiv"].style.visibility='hidden';  // Para ocultar los botones  
			 document.all["ResultadoDiv"].style.visibility='hidden';  // Para ocultar los botones  

 			 document.all["capaContenido"].childNodes[1].style.visibility='hidden';

			 accion('frmContenido.txtNroBoleta','.disabled=true');
	}

function arrayComponentes(){
	var arr = new Array();
	arr[arr.length]= new Array("txtFechaCaptura","");
	arr[arr.length]= new Array("cbEstado","");

	arr[arr.length]= new Array("btnRecepcionar","BOTON");

	arr[arr.length]= new Array("txtNroBoleta","");

	arr[arr.length]= new Array("btnIngresar","BOTON");

	arr[arr.length]= new Array("Eliminar","BOTONXY");
	arr[arr.length]= new Array("Procesar","BOTONXY");
	arr[arr.length]= new Array("Resultado","BOTONXY");

	arr[arr.length]= new Array("txtFechaCaptura","");
	arr[arr.length]= new Array("cbEstado","");

	arr[arr.length]= new Array("btnRecepcionar","BOTON");

	arr[arr.length]= new Array("txtNroBoleta","");

	arr[arr.length]= new Array("btnIngresar","BOTON");

	arr[arr.length]= new Array("Eliminar","BOTONXY");
	arr[arr.length]= new Array("Procesar","BOTONXY");
	arr[arr.length]= new Array("Resultado","BOTONXY");
	

	return arr;
}

function presionaEnter(){
	  if (event.keyCode == 13){
			  botonIngresar();
	  }
}

function tabGenerico(nombreComp, tipotab){       
	var arr = arrayComponentes();
	var tabular = false;
	var nombreFormulario = getFormularioSICC();
	var j = 0;
	var k = arr.length;
	if (tipotab != "sh") {
		j = j-1;                
		k = k-1;
	}

	while(j<k){
		var t;
		if(tipotab == "sh"){
		  k--;
		  t = k;
		} else{
		  j++;
		  t = j;                  
		}
		  
		var nombre = arr[t][0];
		var tipo = arr[t][1];
		if (tabular==false){
		  if (nombreComp==nombre){
			  tabular=true;
			  if (tipotab == "sh"){
				if (k==0) k= arr.length;
			  } else {
				if ((j+1)==arr.length)  j = -1;
			  }
		  }                
		} else {
		  try {
			var name = nombreFormulario+"."+nombre;
			if (tipo=="BOTONXY"){
			   focalizaBotonHTML_XY(nombre);
			} else if (tipo=="BOTON") {
			   focalizaBotonHTML("botonContenido",nombre)
			} else {
				if (eval("document.all."+nombre+"[0].disabled==true")){
					continue;
				} else {
				   focaliza(name);
				}
			}
			return;
		  } catch (e) {
		  }
		}
	}
}