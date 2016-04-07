 var datosOriginalesConsulta = "";

/* --------------------------------------------------------------------------------------------------------------------------------------------------------------*/
	function onLoadPag() {
      configurarMenuSecundario("frmContenido"); 
      
	    DrdEnsanchaConMargenDcho('listado1',12);	    
	    document.all["Cplistado1"].style.visibility='';
	    document.all["CpLin1listado1"].style.visibility='';
	    document.all["CpLin2listado1"].style.visibility='';
	    document.all["CpLin3listado1"].style.visibility='';
	    document.all["CpLin4listado1"].style.visibility='';
	    document.all["primera1Div"].style.visibility='hidden';
	    document.all["ret1Div"].style.visibility='hidden';
	    document.all["ava1Div"].style.visibility='hidden';
	    document.all["separaDiv"].style.visibility='hidden';
	    eval (ON_RSZ);  

      focaliza("frmContenido.cbTipoSolicitud");

      if (get('frmContenido.errDescripcion')!='') {
         var wnd = fMostrarMensajeError(get('frmContenido.errCodigo'), get('frmContenido.errDescripcion'));
      }
      
      if (get('frmContenido.opcionMenu') == 'modificar'){
        set('frmContenido.cbTipoSolicitud', [get('frmContenido.oidTipoSolicitud')]);
      }      
	}

/* --------------------------------------------------------------------------------------------------------------------------------------------------------------*/
  function validaIDValorDefecto(valor) {
      var permitidos = "0123456789";
      var c;
      for(var i=0; i<valor.length; i++) {
        c = valor.charAt(i);
        if (permitidos.indexOf(c) == -1 )     return false;
      }
      return true;
   }

/* --------------------------------------------------------------------------------------------------------------------------------------------------------------*/
  function focoDespuesError(fila, componente) {
    document.selection.empty();
    var nombrelistado = "listado1";

    eval(nombrelistado+".preparaCamposDR()");
    focaliza('frm'+nombrelistado+'.'+componente+'_'+fila,'');
  }

/* --------------------------------------------------------------------------------------------------------------------------------------------------------------*/
  function fGuardar() {  
	  listado1.actualizaDat();
	  var listadoDatos = listado1.datos;  
	  var cantFilas = listadoDatos.length;    

     /* for ( var i=0; i<cantFilas; i++) {      
          var valor = listadoDatos[i][2];
          var oid = listadoDatos[i][3];
          var insercion = listadoDatos[i][4];

		      if(insercion == "S") {
				if((valor=="") && (oid=="")) {
				  GestionarMensaje('1380',null,null,null); 
				  var componente = "txtValorDefecto";
				  focoDespuesError(i, componente);          
				  return false;     
				}
			  }
			}*/

		 /*   for(var i = 0; i<cantFilas; i++) {
			  var valor = listadoDatos[i][2];
			  var oid = listadoDatos[i][3];
			  
			  if((valor!="") && (oid!="")) {
				GestionarMensaje('1381',null,null,null); 
				var componente = "txtValorDefecto";
				focoDespuesError(i, componente);        
				return false;     
			  }              
			}*/

/*	  for (var i=0; i<cantFilas; i++) {
	      var oid = listadoDatos[i][3];
	      if (oid != "") {
		       var valoid = validaIDValorDefecto(oid);
		       if ( valoid != true) {
		           GestionarMensaje("1382", null, null, null);
		           var componente = "txtIdValorDefecto";
		           focoDespuesError(i, componente);          
		           return false;
		       }  
	       }      
	  }          */
  
      if (!sicc_validaciones_generales()) { return; }                  
  
      var oidTipo = get("frmContenido.cbTipoSolicitud");
	  var arrayValores = "";
	  listado1.actualizaDat();
	  var listadoDatos = listado1.datos;    
	  var cantFilas = listadoDatos.length;
	  var cantCols = listadoDatos[0].length;      
      
	  for (var i=0; i<cantFilas; i++ ) {
		  for (var j=0; j<cantCols; j++) {
		    	var dato = listadoDatos[i][j];
				if (dato =="") { dato = "null"; }            
				if (arrayValores=="") { 
					arrayValores = dato; 
				} else {
					arrayValores = arrayValores + "," + dato;
				}            
		   }
      }        

      set("frmContenido.listaValores", arrayValores);
	  set("frmContenido.oidTipoSolicitud", oidTipo);
	  eval("frmContenido").oculto= "S";        
	  set("frmContenido.conectorAction", "LPMantieneValoresPorDefecto");
	  set("frmContenido.accion", "guardar");
	  enviaSICC("frmContenido");
  }
  

/* --------------------------------------------------------------------------------------------------------------------------------------------------------------*/
  function fLimpiar() {
    reInicio();
    focaliza("frmContenido.cbTipoSolicitud");  
  }

/* --------------------------------------------------------------------------------------------------------------------------------------------------------------*/
  function txtValorDefecto() {
    document.selection.empty();
    var nombrelistado = "listado1";
    var nombreText = "txtValorDefecto";
    var indiceFila = 0;

    eval(nombrelistado+".preparaCamposDR()");
    focaliza('frm'+nombrelistado+'.'+nombreText+'_'+indiceFila,'');
  }

  /* --------------------------------------------------------------------------------------------------------------------------------------------------------------*/
  function focalizaListaTab(FILAEVENTO) {
      if(FILAEVENTO == (listado1.datos.length - 1)) {
        setTimeout("focaliza('frmContenido.cbTipoSolicitud','')",10); 
      }
  }

/* --------------------------------------------------------------------------------------------------------------------------------------------------------------*/
  function focalizaListaShTab(FILAEVENTO) {
    if(FILAEVENTO == 0){     	
	  setTimeout("focaliza('frmContenido.cbTipoSolicitud')",10);                   
    }        
  }

/* --------------------------------------------------------------------------------------------------------------------------------------------------------------*/
  function checkModificacion() {
    var nombrelistado = "listado1";
    var nombreText = "cbx2";
    var indiceFila = listado1.datos.length - 1;

    eval(nombrelistado+".preparaCamposDR()");
    focaliza('frm'+nombrelistado+'.'+nombreText+'_'+indiceFila,'');
  } 

/* --------------------------------------------------------------------------------------------------------------------------------------------------------------*/
  function reInicio() {    
	limpiarLista();
    listado1.setDatos(datosLista);   
    set('frmContenido.cbTipoSolicitud','');   
    setTimeout("focaliza('frmContenido.cbTipoSolicitud','')",200);
    focaliza('frmContenido.cbTipoSolicitud');
  }

/* --------------------------------------------------------------------------------------------------------------------------------------------------------------*/
	function limpiarLista(){
		datosLista = listado1.datos;
		var cantFilas = datosLista.length;      
      
		for(var i=0 ; i<cantFilas ; i++ ) {
			datosLista[i][2] = "";
/*			datosLista[i][3] = "";        */
			datosLista[i][3] = "N";
			datosLista[i][4] = "N";       
		}

		listado1.setDatos(datosLista);   
	}

/* --------------------------------------------------------------------------------------------------------------------------------------------------------------*/
  function fErrorAlGuardar() {
    focaliza('frmContenido.cbTipoSolicitud');
  }


/* --------------------------------------------------------------------------------------------------------------------------------------------------------------*/
	//Modificado: mmaidana
	//Fecha: 06/02/2005
	//Incidencia: DBLG200000152
  function cmbTipoSolicitudOnChange() {

	limpiarLista();
	listado1.actualizaDat();

	if(get("frmContenido.cbTipoSolicitud")!="") {
		eval("frmContenido").oculto= "S";
		set("frmContenido.conectorAction", "LPMantieneValoresPorDefecto");
		set("frmContenido.accion", "cargarValoresPorDefecto");
		set("frmContenido.oidTipoSolicitud", get("frmContenido.cbTipoSolicitud"));	
		enviaSICC('frmContenido', '', '', 'N');	
	}
  }

/* --------------------------------------------------------------------------------------------------------------------------------------------------------------*/
  function recuperaValoresDefectoOK(valores) {
    datosOriginalesConsulta = valores;

	var filas = valores.split("|");
	var datos = listado1.datos;
	var longitud = datos.length;
	var contador = 0;

	for(var i=0; i<filas.length; i++) {		
		var campos = filas[i].split(",");

		var valDefecto = campos[3];
/*		var idValDefecto = campos[4];*/
		var obli = campos[4];
		var modi = campos[5];

		if(valDefecto!="" && obli!="" && modi!="") {
			for(var k=0; k<longitud; k++) {
				if(campos[2]==datos[k][1]) {

					if(valDefecto!="null") {
						datos[k][2] = valDefecto;
					}

/*					if(idValDefecto!="null") {
						datos[k][3] = idValDefecto;
					}*/

					if(obli=="1") {
						datos[k][3] = "S";
					}
					else {
						datos[k][3] = "N";
					}

					if(modi=="1") {
						datos[k][4] = "S";
					}
					else {
						datos[k][4] = "N";
					}
				}
			}	
		}
	}

	listado1.setDatos(datos);
	listado1.repintaDat();
	
	eval("frmContenido").oculto= "N";
	focaliza("frmContenido.cbTipoSolicitud");
  }

/* --------------------------------------------------------------------------------------------------------------------------------------------------------------*/
  function recuperaValoresDefectoERR() {
	eval("frmContenido").oculto= "N";
	datosOriginalesConsulta = "";
	focaliza("frmContenido.cbTipoSolicitud");
  }

/* --------------------------------------------------------------------------------------------------------------------------------------------------------------*/
  //Esta funcion duplica el array de la lista
  function creaArray(array) {
      var arrayLista = new Array();
      var cantFilas = array.length;
      var cantCols = array[0].length;      
      
      for(var i=0 ; i<cantFilas ; i++ ) {
          var nuevaFila = new Array();

          for(var j=0 ; j<cantCols; j++) {
              var dato = array[i][j];
              nuevaFila[j] = dato;
          }
          arrayLista[i] = nuevaFila;
        }
      return arrayLista;
  }

/* --------------------------------------------------------------------------------------------------------------------------------------------------------------*/
function valorModificadoOnChange(filaCambiada) {
	if(datosOriginalesConsulta=="") {
		return;
	}

	var datosLista = listado1.datos;
	var filaModificada = datosLista[filaCambiada];
	var atriEspeModificado = filaModificada[1];
	var filas = datosOriginalesConsulta.split("|");
	var cantFilas = filas.length;

	for(var i=0; i<cantFilas; i++) {
		var campos = filas[i].split(",");

		if(campos[2] == atriEspeModificado) {
			if(campos[3]=="null" && campos[5]=="0" && campos[6]=="0") {
				//alert("esta fila era modificable - sigue");
			}else {
				//alert("esta fila no era modificable");

				GestionarMensaje('UIPED042',null,null,null); 

				
				listado1.actualizaDat();
				var datosListaActualizada = listado1.datos;
				var arrayAsetear = creaArray(datosListaActualizada);
				arrayAsetear[filaCambiada][0] = datosListaActualizada[filaCambiada][0];
				arrayAsetear[filaCambiada][1] = campos[2];
				
				if(campos[3]=="null") {
					arrayAsetear[filaCambiada][2] = "";
				}
				else {
					arrayAsetear[filaCambiada][2] = campos[3];
				}
				
/*				if(campos[4]=="null") {
					arrayAsetear[filaCambiada][3] = "";
				}
				else {
					arrayAsetear[filaCambiada][3] = campos[4];
				}*/
				
				if(campos[5]=="1") {
					arrayAsetear[filaCambiada][3] = "S";
				}
				else {
					arrayAsetear[filaCambiada][3] = "N";
				}

				if(campos[6]=="1") {
					arrayAsetear[filaCambiada][4] = "S";
				}
				else {
					arrayAsetear[filaCambiada][4] = "N";
				}				

				listado1.setDatos(arrayAsetear);
				listado1.repintaDat();
			}
		}
	}
}
