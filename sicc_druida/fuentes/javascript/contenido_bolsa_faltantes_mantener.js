	function ocultarListaEditable() {   
		document.all["Cplistado1"].style.visibility='hidden'; 
		document.all["CpLin1listado1"].style.visibility='hidden';  
		document.all["CpLin2listado1"].style.visibility='hidden'; 
		document.all["CpLin3listado1"].style.visibility='hidden';
		document.all["CpLin4listado1"].style.visibility='hidden';        
	    document.all["primera1Div"].style.visibility='hidden'; 
		document.all["ret1Div"].style.visibility='hidden';
		document.all["ava1Div"].style.visibility='hidden';  
		document.all["separaDiv"].style.visibility='hidden';  
		document.all["Aceptar"].style.visibility='hidden';
	}   

	function fLimpiar(){
		posicionarCombo();
		focaliza('formulario.cbSituacionRegistro');
	}

	function onLoadPag() {
		DrdEnsanchaConMargenDcho('listado1',12);
		DrdEnsanchaConMargenDcho('lstCodProducto',12);

		configurarMenuSecundario("formulario");                     
		ocultarListaEditable();  
		posicionarCombo();		
 		desabilitaListas();
	    eval (ON_RSZ);  
		focaliza('formulario.cbSituacionRegistro');
	}


    function posicionarCombo() {    
	   var iSeleccionadoM = new Array();    
	   iSeleccionadoM[0] = get('formulario.oidSituacionRegistro');
	   iSeleccionadoM[1] = get('formulario.oidConcurso');    
	   set('formulario.cbSituacionRegistro',iSeleccionadoM[0]); 
	   set('formulario.cbCodConcurso',iSeleccionadoM[1]); 
	}      

	function desabilitaListas(){
		document.getElementById("cbZona").disabled = true;
		document.getElementById("cbRegion").disabled = true;
		return true;
	}

	function mostrarListaEditable() {
		document.all["Cplistado1"].style.visibility=''; 
		document.all["CpLin1listado1"].style.visibility='';  
		document.all["CpLin2listado1"].style.visibility=''; 
		document.all["CpLin3listado1"].style.visibility='';
		document.all["CpLin4listado1"].style.visibility='';        
	    document.all["primera1Div"].style.visibility=''; 
		document.all["ret1Div"].style.visibility='';
		document.all["ava1Div"].style.visibility='';  
		document.all["separaDiv"].style.visibility=''; 
		document.all["Aceptar"].style.visibility=''; 
	}

	function muestraLista(ultima, _rowset, error) {
	  var tamano = _rowset.length;
		
	  if (tamano > 0) {
		  mostrarListaEditable();

  		  if(get('formulario.cbSituacionRegistro') == get('formulario.hConstSitRegHist')) {
			listado1.alternaVerColumna(7,true);	
			listado1.alternaVerColumna(8,true);
			listado1.alternaVerColumna(9,true);	
		  } 
		  else {
			listado1.alternaVerColumna(7,false);	
			listado1.alternaVerColumna(8,false);
			listado1.alternaVerColumna(9,false);		
  		  }	

   		  eval (ON_RSZ);
		  return true;
	  }
	  else {
		ocultarListaEditable();
		return false;
	  }
	}  
    
	function onClickRbRegion() {
		document.getElementById("cbZona").disabled = true;
		document.getElementById("cbRegion").disabled = false;
		return true;
	}
    
	function onClickRbZona(){
		document.getElementById("cbRegion").disabled = true;
		document.getElementById("cbZona").disabled = false;
		return true;
	}

	//Modificado por incidencia BELC300024106     
	function accionBtBuscar(){
		if (!sicc_validaciones_generales('situacionRegistro')){
			return false;
		}

		var arrDatos = new Array();
		var i=0;
		var conector;
		
		arrDatos[i] = new Array('oidPais',get('formulario.hPais'));
  		i++;
		arrDatos[i] = new Array('oidIdioma',get('formulario.hIdioma'));
		i++;
		arrDatos[i] = new Array('situacionRegistro',get('formulario.cbSituacionRegistro'));
		i++;
		arrDatos[i] = new Array('oidConcurso',get('formulario.cbCodConcurso'));
		i++;
		//arrDatos[i] = new Array('codigosProductos',get('formulario.cbCodProducto'));
		arrDatos[i] = new Array('codigosProductos',obtenerOidsProductos());
		i++;
		arrDatos[i] = new Array('regiones',get('formulario.cbRegion')); 
		i++;
		arrDatos[i] = new Array('zonas',get('formulario.cbZona'));
      
		if(get('formulario.cbSituacionRegistro') == get('formulario.hConstSitRegHist')) { 
			conector = 'ConectorPremiosFaltantes';
		} 
		else { 		    
            conector = 'ConectorPremiosFaltantesVigentes';
		}

		configurarPaginado(mipgndo, 'INCPremiosFaltantes', conector,
            'es.indra.sicc.dtos.inc.DTOBusquedaFaltantes', arrDatos);  
	}

   //Agregado por incidencia BELC300024106    
   function obtenerOidsProductos() {
	   var oids = "";
	   var datos = lstCodProducto.datos;

	   for(var i=0; i<datos.length; i++) {
		   if(i==0) oids = datos[i][0];
		   else oids = oids + "," + datos[i][0]; 
	   }
	   return oids;
   }
   
   function onChangeCbSituacionRegistro(){
		if(get('formulario.cbSituacionRegistro')==get('formulario.hConstSitRegHist')){
			document.getElementById("Aceptar").disabled = true;
		} 
		else document.getElementById("Aceptar").disabled = false;
   }

   function obtenerPosicionListaEditable(clave, lista){
		this.posicion = 0;
		if (lista.codSeleccionados().length > 0){
			for(var k=0;k<lista.datos.length;k++) {
				if (lista.datos[k][0] == clave) {
					posicion=k;
					break;
				}
			}       
			return posicion;
		}
   }
    
   function accionBtAceptar(){		
	    listado1.actualizaDat();

		var codSeleccionados = listado1.codSeleccionados();
		if ( codSeleccionados.length < 1)	{
			GestionarMensaje('4');
			return;
		}

		var posicion = obtenerPosicionListaEditable(listado1.codSeleccionados(),listado1);

		var parametros = new Object();
		parametros.oidConcurso = listado1.datos[posicion][1];
		parametros.oidCliente = listado1.datos[posicion][10];
		parametros.oidSolicitud = listado1.datos[posicion][9];
		parametros.numero_premio = listado1.datos[posicion][6];
		parametros.oidRegion = listado1.datos[posicion][12];
		parametros.oidZona = listado1.datos[posicion][11];

		mostrarModalSICC("LPMantenerBolsaDeFaltantes", "inicioDetalle", parametros);
		accionBtBuscar();
	}

	//Agregado por incidencia BELC300024106 
	function onClickBuscar() {	
		var datos = new Object();    
		datos.dto = "es.indra.sicc.cmn.negocio.comun.DTOComunes.DTOGenBusquedaProducto";
		datos.conector = "ConectorGENBusquedaProducto";
		var salida = abrirBusquedaGenerica(datos, "","0075");

		if(salida!=undefined) {
			if(salida.length>0) {
				lstCodProducto.actualizaDat();
				var datos = lstCodProducto.datos;

				for(var i=0; i<salida.length;i++) {
					var fila = new Array();
					fila[0] = salida[i][0];
					fila[1] = salida[i][1];
		
					var existe = "false";
		
					for(var j=0; j<datos.length; j++) {
						if(datos[j][0] == salida[i][0]) {
							existe = "true";
						}
					}
		
					if(existe == "false") {
						datos[datos.length] = fila;
						lstCodProducto.setDatos(datos);
					}
				}

				lstCodProducto.repintaDat();	
			}			
		}	
	}

	function onClickEliminar() {
		if (lstCodProducto.numSelecc() > 0) {
			var array = lstCodProducto.codSeleccionados();
			var datos = lstCodProducto.datos;
			var datosNuevos = new Array();
			var f = 0;

			for(var i=0; i<datos.length; i++) {
				var existe = "false";

				for(var j=0; j<array.length; j++) {
					if(datos[i][0]==array[j]) {
						existe = "true";
					}
				}

				if(existe == "false") {
					datosNuevos[f] = datos[i];
					f++;
				}
			}

			lstCodProducto.actualizaDat();
			lstCodProducto.setDatos(datosNuevos);
			lstCodProducto.repintaDat();
		}
		else
			GestionarMensaje('4');
	}

	//FIN - Agregado por incidencia BELC300024106 