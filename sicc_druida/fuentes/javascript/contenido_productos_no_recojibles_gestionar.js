var dtoGestionProductosNoRecogibles;
var busco;
	
	function ocultaTodo(){
		ocultarResultado();
		ocultarSeleccion();         
	}

	function muestraTodo(){
		mostrarResultado();   
		mostrarSeleccion();         
	}
    
    function onLoadPag()   {
        configurarMenuSecundario("frmContenido"); 
		
		/*parametros = window.dialogArguments.parametros;
		dtoOferta = window.dialogArguments.parametros.dtoOferta;
		eval("cbLineaProducto.disabled=true");*/
		
        DrdEnsanchaConMargenDcho('listado1',12);
        DrdEnsanchaConMargenDcho('listado2',12);
        eval (ON_RSZ);

		setearCombosMarcaCanal();
		cambioMarcaCanal();
		window.setTimeout("setearCombosPeriodo()", 2800);
        ocultaTodo();
		busco = false;

		focaliza('frmContenido.cbMarca'); 
    }
	
    function setearCombosMarcaCanal(){
        var array = new Array();
        array[0]= get('frmContenido.hidCanal');
        set('frmContenido.cbCanal',array);
        array = new Array();
        array[0]= get('frmContenido.hidMarca');
        set('frmContenido.cbMarca',array);
    }

    function setearCombosPeriodo(){
        var array = new Array();
        array[0]= get('frmContenido.hidPeriodo');
        set('frmContenido.cbPeriodo',array);
    }

	function ShowError() {
	  if (get('frmContenido.errCodigo') != ''){
			fMostrarMensajeError();
	   }
	}

	function deshab(){
		if (get('frmContenido.txtCodVent')!='') {
			if (get('frmContenido.txtCodVentFict')=='') {
				accion('frmContenido.txtCodVentFict','.disabled=true');
			} else {
				set('frmContenido.txtCodVent','');
			}
		} else if (get('frmContenido.txtCodVent')=='') {
			accion('frmContenido.txtCodVentFict','.disabled=false');
		}
		if (get('frmContenido.txtCodVentFict')!='') {
			if (get('frmContenido.txtCodVent')=='') {
				accion('frmContenido.txtCodVent','.disabled=true');
			} else {
				set('frmContenido.txtCodVentFict','');
			}
		} else if (get('frmContenido.txtCodVentFict')=='') {
			accion('frmContenido.txtCodVent','.disabled=false');
		}

	}

	function vacio(msgError, ultima, rowset) {
       var tamano = rowset.length;         
       if (tamano == 0) {
			GestionarMensaje("2596");
			return false;
	   }
	   return true;
	}

    function cambioMarcaCanal(){
        if (get('frmContenido.cbMarca')!=''
        &&get('frmContenido.cbCanal')!=''){
            accion('frmContenido.cbPeriodo','.disabled=false');
            var oid = get('frmContenido.cbCanal').toString();
            var marca= get('frmContenido.cbMarca').toString();
            frmContenido.hidCanal = oid;
            frmContenido.hidMarca = marca;
            if(oid != "") {                    
                recargaCombo("frmContenido.cbPeriodo","PRECargarPeriodos","es.indra.sicc.dtos.cra.DTOPeriodo",makeParameters());
            }      
        }else{
            set_combo('frmContenido.cbPeriodo',new Array());
            accion('frmContenido.cbPeriodo','.disabled=true');
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

    function botonBuscar(){

        if(!sicc_validaciones_generales()){
          return false;
        }
		
		//desmarco los seleccionados
		var codigos = listado1.codigos();
		var longitud = codigos.length;
		for(var i=0;i<longitud;i++) {
		listado1.deselecciona(i);    
		}

		//busqueda listado 1
		configurarPaginado(mipgndo1,"RECObtenerProductosRecojo",
						  "ConectorObtenerProductosRecojo",
						  "es.indra.sicc.dtos.rec.DTOFiltroProductoNoRecogible",
						  armaArray());
		//deshabilito MCP
		accion('frmContenido.cbPeriodo','.disabled=true');
		accion('frmContenido.cbMarca','.disabled=true');
		accion('frmContenido.cbCanal','.disabled=true');

		if (busco) {
			//no vuelvo a consultar la segunda.
		} else {
			//busqueda listado 2 - listado de resultado-seleccion
			configurarPaginado(mipgndo2,"RECObtenerProductosNoRecogibles",
							  "ConectorObtenerProductosNoRecogibles",
							  "es.indra.sicc.dtos.rec.DTOFiltroProductoNoRecogible",
							  armaArray()); //es casi el mismo filtro solo que no usa cv, cvf, codsap y desc.
		}
		busco = true;
		muestraTodo();

		eval(ON_RSZ);
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
      if (get('frmContenido.cbMarca')!=''){
             arrDatos[i] = new Array('oidMarca',get('frmContenido.cbMarca'));
             i++;
      }
      if (get('frmContenido.cbCanal')!=''){
             arrDatos[i] = new Array('oidCanal',get('frmContenido.cbCanal'));
             i++;
      }
      if (get('frmContenido.cbPeriodo')!=''){
             arrDatos[i] = new Array('oidPeriodo',get('frmContenido.cbPeriodo'));
             i++;
      }

      if (get('frmContenido.txtCodSAP')!=''){
             arrDatos[i] = new Array('codigoSAP',get('frmContenido.txtCodSAP'));
             i++;
      }
      if (get('frmContenido.txtDescripcion')!=''){
             arrDatos[i] = new Array('descripcion',get('frmContenido.txtDescripcion'));
             i++;
      }
      
      if (get('frmContenido.txtCodVent')!=''){
             arrDatos[i] = new Array('codigoVenta',get('frmContenido.txtCodVent'));
             i++;
      }

      if (get('frmContenido.txtCodVentFict')!=''){
             arrDatos[i] = new Array('codigoVentaFicticio',get('frmContenido.txtCodVentFict'));
             i++;
      }

      return arrDatos;
                    
  }

      
  function botonAniadir(){
        var cant = listado1.numSelecc(); 
        var cantTemporal = listado2.codigos().length;  // Cantidad de elementos en 
        var toAdd = "";
        var codigo = "";

        if ( cant == 0 ){            
            GestionarMensaje("PRE0077");                                    
        }else{
            codigo = listado1.codSeleccionados();
            for(var a = 0; a < codigo.length ; a++){
				toAdd = listado1.extraeDato(codigo[a], 0);
				toAdd = toAdd + "|" +listado1.extraeDato(codigo[a], 1);
				toAdd = toAdd + "|" + dejaEsp(listado1.extraeDato(codigo[a], 2));
				toAdd = toAdd + "|" + dejaEsp(listado1.extraeDato(codigo[a], 3));
				toAdd = toAdd + "|" + dejaEsp(listado1.extraeDato(codigo[a], 4));
				toAdd = toAdd + "|" + dejaEsp(listado1.extraeDato(codigo[a], 5));
				toAdd = toAdd + "|" + dejaEsp(listado1.extraeDato(codigo[a], 6));
				toAdd = toAdd + "|" + dejaEsp(listado1.extraeDato(codigo[a], 7));
				toAdd = toAdd + "|" + dejaEsp(listado1.extraeDato(codigo[a], 8));										 
				toAdd = toAdd + "|" + dejaEsp(listado1.extraeDato(codigo[a], 9));
				toAdd = toAdd + "|" + " ";//como es nuevo el oid no existe, pero listado2 tiene un campo extra por los que si.
				
				pasaListaTemporal( codigo[a], toAdd); //esto antes del guardado logico por si ya existe.

				if(muestraMsg == false){ // si no existe.
					var posEncontrada = -1;
					if (dtoGestionProductosNoRecogibles==null) {
						dtoGestionProductosNoRecogibles = new Object();
						dtoGestionProductosNoRecogibles.productosNoRecogibles = new Array();
						dtoGestionProductosNoRecogibles.oidPais = get('frmContenido.oidPais');
						dtoGestionProductosNoRecogibles.oidIdioma = get('frmContenido.oidIdioma');
						dtoGestionProductosNoRecogibles.oidMarca = get('frmContenido.cbMarca');
						dtoGestionProductosNoRecogibles.oidCanal = get('frmContenido.cbCanal');
						dtoGestionProductosNoRecogibles.oidPeriodo = get('frmContenido.cbPeriodo');
					} else {
						if (dtoGestionProductosNoRecogibles.productosNoRecogibles==null) {
							dtoGestionProductosNoRecogibles.productosNoRecogibles = new Array();
						}
						var codAB = codigo[a];
						var aB = codAB.substring(0,1);
						var oidS = codAB.substring(1,codAB.length);
						var oid = new Number(oidS);
						var cantProdNoRecog = dtoGestionProductosNoRecogibles.productosNoRecogibles.length;
						
						for (var i = 0; i<cantProdNoRecog ; i++) {
							if (aB == '1') {
								if (dtoGestionProductosNoRecogibles.productosNoRecogibles[i].oidDetalleOferta == oid) {
									posEncontrada = i;
								}
							} else if (aB == '2') {
								if (dtoGestionProductosNoRecogibles.productosNoRecogibles[i].oidArticuloLote == oid) {
									posEncontrada = i;
								}
							}
						}			
					}
					if (posEncontrada!=-1) {
						if (dtoGestionProductosNoRecogibles.productosNoRecogibles[posEncontrada].tipoOperacion=='BAJA') {
							if (dtoGestionProductosNoRecogibles.productosNoRecogibles[posEncontrada].oid==null||
								dtoGestionProductosNoRecogibles.productosNoRecogibles[posEncontrada].oid=='') {
								dtoGestionProductosNoRecogibles.productosNoRecogibles[posEncontrada].tipoOperacion = 'ALTA';
							} else {
								dtoGestionProductosNoRecogibles.productosNoRecogibles[posEncontrada].tipoOperacion = '';
							}
						}
					} else {
						var posicion = dtoGestionProductosNoRecogibles.productosNoRecogibles.length;
						dtoGestionProductosNoRecogibles.productosNoRecogibles[posicion] = new Object();
						var oidCAB = codigo[a] + "";
						var sub = oidCAB.substring(0,1);
						var oidS = oidCAB.substring(1,oidCAB.length);
						var oid = new Number(oidS);
						if (sub=='1') {
							dtoGestionProductosNoRecogibles.productosNoRecogibles[posicion].oidDetalleOferta = oid;
						} if (sub=='2') {
							dtoGestionProductosNoRecogibles.productosNoRecogibles[posicion].oidArticuloLote = oid;
						}
						dtoGestionProductosNoRecogibles.productosNoRecogibles[posicion].tipoOperacion = 'ALTA';
					}
				}
            }
            if(muestraMsg == true){                
                muestraMsg = false;
                GestionarMensaje("PRE0079", null,null,null);
            } else {
				//desmarco los seleccionados
				var codigos = listado1.codigos();
				var longitud = codigos.length;
				for(var i=0;i<longitud;i++) {
					listado1.deselecciona(i);    
				}
			}
        }
    }

	var muestraMsg = false;
			 
	function pasaListaTemporal(codigo, datos){
	var codigosTemporal = listado2.codigos();
		var match = rowMatch(codigo, codigosTemporal);
		if (match){
			muestraMsg = true;
		}else{
			datos = codigo + "|" + datos;  // Agrega el codigo al String de valores. 
			var newRow = new Array();
			newRow = datos.split("|");
			listado2.insertar(newRow);
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
			   if ( codigo == codigosTemporal[i] )
					flag = true;      
			   i++;
		  }
		  return flag;
	}

         
	function fGuardar(){ 
		
		//pasar lo de guardado logico a var ocultas
		serializarDTOGestionProductosNoRecogibles();
		serializarDTOProductoNoRecogibles();
		set('frmContenido.conectorAction','LPGestionarProductosNoRecogibles');
		set('frmContenido.accion','guardar');
		enviaSICC('frmContenido');
	}
	
	function serializarDTOGestionProductosNoRecogibles() {
		var aux = "";

		aux = "oidMarca=" + dtoGestionProductosNoRecogibles.oidMarca;
		aux = aux + "|" + "oidCanal=" + dtoGestionProductosNoRecogibles.oidCanal;
		aux = aux + "|" + "oidPeriodo=" + dtoGestionProductosNoRecogibles.oidPeriodo;
		aux = aux + "|" + "oidPais=" + dtoGestionProductosNoRecogibles.oidPais;
		aux = aux + "|" + "oidIdioma=" + dtoGestionProductosNoRecogibles.oidIdioma;

		set("frmContenido.dTOGestionProductosNoRecogibles",aux);
	}
	
	function serializarDTOProductoNoRecogibles() {
		var aux = "";
		
		if (dtoGestionProductosNoRecogibles.productosNoRecogibles!=null&&dtoGestionProductosNoRecogibles.productosNoRecogibles.length>0) {
			var tam = dtoGestionProductosNoRecogibles.productosNoRecogibles.length;
			for (var i=0;i<tam;i++)	{
				aux = aux + "oidDetalleOferta=" + dtoGestionProductosNoRecogibles.productosNoRecogibles[i].oidDetalleOferta;
				aux = aux + "|oidArticuloLote=" + dtoGestionProductosNoRecogibles.productosNoRecogibles[i].oidArticuloLote;
				aux = aux + "|oid=" + dtoGestionProductosNoRecogibles.productosNoRecogibles[i].oid;
				aux = aux + "|tipoOperacion=" + dtoGestionProductosNoRecogibles.productosNoRecogibles[i].tipoOperacion;
				aux = aux + "&";
			}
		}
		set("frmContenido.dTOProductoNoRecogibles",aux);
	}
	
	function botonEliminar() {
		  var elemSel = listado2.codSeleccionados();
		  if ( elemSel.length == 0 ){
			GestionarMensaje("4", null, null, null);
		  }else{
				//eliminar logicamente			
				for(var a = 0; a < elemSel.length ; a++){
					var codAB = elemSel[a];
					var aB = codAB.substring(0,1);
					var oidS = codAB.substring(1,codAB.length);
					var oid = new Number(oidS);
					var cantProdNoRecog = 0;
					if (dtoGestionProductosNoRecogibles!=null&&dtoGestionProductosNoRecogibles.productosNoRecogibles!=null) {
						cantProdNoRecog = dtoGestionProductosNoRecogibles.productosNoRecogibles.length;
					} 
					
					var posEncontrada = -1;
					for (var i = 0; i<cantProdNoRecog ; i++) {
						if (aB == '1') {
							if (dtoGestionProductosNoRecogibles.productosNoRecogibles[i].oidDetalleOferta == oid) {
								posEncontrada = i;
							}
						} else if (aB == '2') {
							if (dtoGestionProductosNoRecogibles.productosNoRecogibles[i].oidArticuloLote == oid) {
								posEncontrada = i;
							}
						}
					}
					if (posEncontrada!=-1){
						//se setea a baja
						dtoGestionProductosNoRecogibles.productosNoRecogibles[posEncontrada].tipoOperacion = 'BAJA';
					} else {
						//se agrega para luego dar de baja fisicamente.
						if (dtoGestionProductosNoRecogibles==null) {
							dtoGestionProductosNoRecogibles = new Object();
							dtoGestionProductosNoRecogibles.productosNoRecogibles = new Array();
							dtoGestionProductosNoRecogibles.oidPais = get('frmContenido.oidPais');
							dtoGestionProductosNoRecogibles.oidIdioma = get('frmContenido.oidIdioma');
							dtoGestionProductosNoRecogibles.oidMarca = get('frmContenido.cbMarca');
							dtoGestionProductosNoRecogibles.oidCanal = get('frmContenido.cbCanal');
							dtoGestionProductosNoRecogibles.oidPeriodo = get('frmContenido.cbPeriodo');
						} 
						var posicion = dtoGestionProductosNoRecogibles.productosNoRecogibles.length;
						dtoGestionProductosNoRecogibles.productosNoRecogibles[posicion] = new Object();
						if (aB=='1') {
							dtoGestionProductosNoRecogibles.productosNoRecogibles[posicion].oidDetalleOferta = oid;
						} if (aB=='2') {
							dtoGestionProductosNoRecogibles.productosNoRecogibles[posicion].oidArticuloLote = oid;							
						}
						dtoGestionProductosNoRecogibles.productosNoRecogibles[posicion].oid = listado2.extraeDato(elemSel[a], 8);
						dtoGestionProductosNoRecogibles.productosNoRecogibles[posicion].tipoOperacion = 'BAJA';
					}
				}
				listado2.eliminarSelecc();
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
		 }
	}

	function limpiar() {
		 accion('frmContenido.cbPeriodo','.disabled=false');
		 accion('frmContenido.cbMarca','.disabled=false');
		 accion('frmContenido.cbCanal','.disabled=false');
		 dtoGestionProductosNoRecogibles = null;
		 busco = false;
		 ocultaTodo();
		 focaliza('frmContenido.cbMarca'); 
	}

	 function mostrarResultado(){
			 document.all["Cplistado1"].style.visibility='visible'; 
			 document.all["separa1Div"].style.visibility='visible';
			 document.all["primera1Div"].style.visibility='visible'; 
			 document.all["ret1Div"].style.visibility='visible'; 
			 document.all["ava1Div"].style.visibility='visible';
			 document.all["CpLin1listado1"].style.visibility='visible';
			 document.all["CpLin2listado1"].style.visibility='visible';
			 document.all["CpLin3listado1"].style.visibility='visible';
			 document.all["CpLin4listado1"].style.visibility='visible';
			 document.all["AnadirDiv"].style.visibility='visible';    
			 //document.all["DefinirTxtDiv"].style.visibility='visible'; 
	 }
	 function ocultarResultado(){
			 //Al principio se debe ocular la lista
			 document.all["Cplistado1"].style.visibility='hidden';   //la lista se llama listado1 pero hay que anteponer Cp
			 document.all["separa1Div"].style.visibility='hidden';
			 document.all["primera1Div"].style.visibility='hidden';     //el boton se llama prim1 pero hay que poner al final Div
			 document.all["ret1Div"].style.visibility='hidden'; 
			 document.all["ava1Div"].style.visibility='hidden';   
			 document.all["CpLin1listado1"].style.visibility='hidden';   //para ocultar las lineas que conforman el marco
			 document.all["CpLin2listado1"].style.visibility='hidden'; 
			 document.all["CpLin3listado1"].style.visibility='hidden'; 
			 document.all["CpLin4listado1"].style.visibility='hidden';
			 document.all["AnadirDiv"].style.visibility='hidden';  // Para ocultar los botones  
	}

	 function mostrarSeleccion(){
			 document.all["Cplistado2"].style.visibility='visible'; /*
			 document.all["separa2Div"].style.visibility='visible';
			 document.all["primera2Div"].style.visibility='visible'; 
			 document.all["ret2Div"].style.visibility='visible'; 
			 document.all["ava2Div"].style.visibility='visible';*/
			 document.all["CpLin1listado2"].style.visibility='visible';
			 document.all["CpLin2listado2"].style.visibility='visible';
			 document.all["CpLin3listado2"].style.visibility='visible';
			 document.all["CpLin4listado2"].style.visibility='visible';
			 document.all["EliminarDiv"].style.visibility='visible';  // Para poner visibles los botones                   
	 }
	 function ocultarSeleccion(){
			 //Al principio se debe ocular la lista
			 document.all["Cplistado2"].style.visibility='hidden';  //la lista se llama listado1 pero hay que anteponer Cp
			/* document.all["separa2Div"].style.visibility='hidden';
			 document.all["primera2Div"].style.visibility='hidden'; */    //el boton se llama prim1 pero hay que poner al final Div
			 document.all["ret2Div"].style.visibility='hidden'; 
			 document.all["ava2Div"].style.visibility='hidden';  
			 document.all["CpLin1listado2"].style.visibility='hidden';   //para ocultar las lineas que conforman el marco
			 document.all["CpLin2listado2"].style.visibility='hidden'; 
			 document.all["CpLin3listado2"].style.visibility='hidden'; 
			 document.all["CpLin4listado2"].style.visibility='hidden';
			 document.all["EliminarDiv"].style.visibility='hidden';  // Para ocultar los botones                   
	 }  

function arrayComponentes(){
	var arr = new Array();
    arr[arr.length]= new Array("cbMarca","");
	arr[arr.length]= new Array("cbCanal","");
	arr[arr.length]= new Array("cbPeriodo","");

	arr[arr.length]= new Array("txtCodVent","");
	arr[arr.length]= new Array("txtCodVentFict","");
	arr[arr.length]= new Array("txtCodSAP","");
	arr[arr.length]= new Array("txtDescripcion","");

	arr[arr.length]= new Array("btnBuscar","BOTON");
	arr[arr.length]= new Array("Anadir","BOTONXY");
	arr[arr.length]= new Array("Eliminar","BOTONXY");

    arr[arr.length]= new Array("cbMarca","");
	arr[arr.length]= new Array("cbCanal","");
	arr[arr.length]= new Array("cbPeriodo","");

	arr[arr.length]= new Array("txtCodVent","");
	arr[arr.length]= new Array("txtCodVentFict","");
	arr[arr.length]= new Array("txtCodSAP","");
	arr[arr.length]= new Array("txtDescripcion","");

	arr[arr.length]= new Array("btnBuscar","BOTON");
	arr[arr.length]= new Array("Anadir","BOTONXY");
	arr[arr.length]= new Array("Eliminar","BOTONXY");

	return arr;
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