/* ------------------------------------------------------------------------------------------------------------------------------------------------------------------ */
function onLoadPag() {
	configurarMenuSecundario("frmContenido");      
	DrdEnsanchaConMargenDcho('listado1',12);
	DrdEnsanchaConMargenDcho('listado2',12);
	var entro = get('frmContenido.entroConsulta');

	if(entro=="") {			
		ocultaCapas();
		ocultaCapasLista2();
	}    
	eval (ON_RSZ);
	set('frmContenido.cbTipoSolicitud','');
	focaliza("frmContenido.cbTipoSolicitud");

}

/* ------------------------------------------------------------------------------------------------------------------------------------------------------------------ */
function accionBuscar(){    
   if (!sicc_validaciones_generales('campoObligatorio')) {
	  return;      
   }     
   
   var arr = new Array();
   arr[arr.length] = new Array("oidTipoSolicitudPais", get("frmContenido.cbTipoSolicitud")+"");
   arr[arr.length] = new Array("oidPais", get("frmContenido.oidPais")+"");
   arr[arr.length] = new Array("oidIdioma", get("frmContenido.oidIdioma")+"");      

   if (get('frmContenido.opcionMenu') != 'modificar'){
	   configurarPaginado(mipgndo,"PEDconsultaValoresDefecto","ConectorBuscarValoresPorDefecto",
	   "es.indra.sicc.dtos.ped.DTOValoresPorDefecto",arr);      
	   ocultaCapas();      
   } else {
	   eval("frmContenido").oculto= "S";
	   set("frmContenido.conectorAction", "LPMantieneValoresPorDefecto");
	   set("frmContenido.accion", "cargarValoresPorDefecto");
	   set("frmContenido.oidTipoSolicitud", get("frmContenido.cbTipoSolicitud"));	
	   enviaSICC('frmContenido', '', '', 'N');	
   }
}  

/* ------------------------------------------------------------------------------------------------------------------------------------------------------------------ */
function muestraLista( ultima, rowset, error){
	var tamano = rowset.length;

	if (tamano > 0) {
		muestraCapas();
		eval (ON_RSZ);
		focaliza("frmContenido.cbTipoSolicitud");
		if (get('frmContenido.opcionMenu') == 'eliminar') { btnProxy(4,"1"); }
		accion('frmContenido.cbTipoSolicitud', '.disabled=true');
		return true;
	} else {
		ocultaCapas();
		eval (ON_RSZ);                    
		focaliza("frmContenido.cbTipoSolicitud");			
		if (get('frmContenido.opcionMenu') == 'eliminar') { btnProxy(4,"0"); }
		return false;
	}
}

/* ------------------------------------------------------------------------------------------------------------------------------------------------------------------ */
function muestraCapas() {  
   document.all["Cplistado1"].style.visibility='';
   document.all["CpLin1listado1"].style.visibility='';
   document.all["CpLin2listado1"].style.visibility='';
   document.all["CpLin3listado1"].style.visibility='';
   document.all["CpLin4listado1"].style.visibility='';
   document.all["primera1Div"].style.visibility='';
   document.all["ret1Div"].style.visibility='';
   document.all["ava1Div"].style.visibility='';
   document.all["separaDiv"].style.visibility='';
}

/* ------------------------------------------------------------------------------------------------------------------------------------------------------------------ */
function ocultaCapas(){
    document.all["Cplistado1"].style.visibility='hidden';
    document.all["CpLin1listado1"].style.visibility='hidden';
    document.all["CpLin2listado1"].style.visibility='hidden';
    document.all["CpLin3listado1"].style.visibility='hidden';
    document.all["CpLin4listado1"].style.visibility='hidden';
    document.all["primera1Div"].style.visibility='hidden';
    document.all["ret1Div"].style.visibility='hidden';
    document.all["ava1Div"].style.visibility='hidden';
    document.all["separaDiv"].style.visibility='hidden';
}

/* ------------------------------------------------------------------------------------------------------------------------------------------------------------------ */
function muestraCapasLista2() {  
   document.all["Cplistado2"].style.visibility='';
   document.all["CpLin1listado2"].style.visibility='';
   document.all["CpLin2listado2"].style.visibility='';
   document.all["CpLin3listado2"].style.visibility='';
   document.all["CpLin4listado2"].style.visibility='';
   document.all["primera2Div"].style.visibility='hidden';
   document.all["ret2Div"].style.visibility='hidden';
   document.all["ava12Div"].style.visibility='hidden';
   document.all["separa2Div"].style.visibility='hidden';
}

/* ------------------------------------------------------------------------------------------------------------------------------------------------------------------ */
  function ocultaCapasLista2(){
      document.all["Cplistado2"].style.visibility='hidden';
      document.all["CpLin1listado2"].style.visibility='hidden';
      document.all["CpLin2listado2"].style.visibility='hidden';
      document.all["CpLin3listado2"].style.visibility='hidden';
      document.all["CpLin4listado2"].style.visibility='hidden';
      document.all["primera2Div"].style.visibility='hidden';
      document.all["ret2Div"].style.visibility='hidden';
      document.all["ava12Div"].style.visibility='hidden';
      document.all["separa2Div"].style.visibility='hidden';
  }

/* ------------------------------------------------------------------------------------------------------------------------------------------------------------------ */
function focoBuscar() {
   focalizaBotonHTML('botonContenido','btnBuscar');
}

/* ------------------------------------------------------------------------------------------------------------------------------------------------------------------ */
function checkModificacion() {
    var nombrelistado = "listado2";
    var nombreText = "cbx2";
    var indiceFila = listado2.datos.length - 1;

    eval(nombrelistado+".preparaCamposDR()");
    focaliza('frm'+nombrelistado+'.'+nombreText+'_'+indiceFila,'');
} 

/* ------------------------------------------------------------------------------------------------------------------------------------------------------------------ */
function focoONSHTABCombo() {
   if (document.all["Cplistado2"].style.visibility!='hidden') {
		checkModificacion();
	} else {
	    focalizaBotonHTML('botonContenido','btnBuscar');
	}
}

/* ------------------------------------------------------------------------------------------------------------------------------------------------------------------ */
  function txtValorDefecto() {
    document.selection.empty();
    var nombrelistado = "listado2";
    var nombreText = "txtValorDefecto";
    var indiceFila = 0;

    eval(nombrelistado+".preparaCamposDR()");
    focaliza('frm'+nombrelistado+'.'+nombreText+'_'+indiceFila,'');
  }

/* ------------------------------------------------------------------------------------------------------------------------------------------------------------------ */
  function focoCombo() {
	focaliza("frmContenido.cbTipoSolicitud");    
  }  

/* ------------------------------------------------------------------------------------------------------------------------------------------------------------------ */
  function focoCajaLista() {
	if(document.all["Cplistado2"].style.visibility=='hidden') {
		focaliza("frmContenido.cbTipoSolicitud");
	}
	else {
		txtValorDefecto();
	}    
  }  

/* ------------------------------------------------------------------------------------------------------------------------------------------------------------------ */
  function fLimpiar() {
    focaliza("frmContenido.cbTipoSolicitud");  
  }

/* ------------------------------------------------------------------------------------------------------------------------------------------------------------------ */
function fBorrar(){
	if (listado1.codSeleccionados().length < 1){
		GestionarMensaje('4');
	} else {
		eliminarFilas(listado1.codSeleccionados(), 'PEDEliminarValoresPorDefecto', mipgndo);
	}
}

/* ------------------------------------------------------------------------------------------------------------------------------------------------------------------ */
//Autor: Marcelo J. Maidana
//Fecha: 20/12/2005
function accionModificar(){
	var datos = listado1.datos;
	var sDato;
	var sDatos = '';

	for (var i = 0; i < datos.length; i++){
		for (var j = 0; j < datos[i].length; j++){
			if (datos[i][j] == ''){
				datos[i][j] = ' ';
			}
		}
	}

	for (var i = 0; i < datos.length; i++){
		sDato = datos[i].join(',');
		sDatos += (sDatos == '') ? sDato : '|' + sDato;
	}

	set('frmContenido.hListado', sDatos);
	set('frmContenido.conectorAction', 'LPMantieneValoresPorDefecto');
	set('frmContenido.accion', 'muestraInsercion');
	set('frmContenido.opcionMenu', 'modificar');
	enviaSICC('frmContenido');
}

/* ------------------------------------------------------------------------------------------------------------------------------------------------------------------ */
function recuperaValoresDefectoOK(valores) {
	var datos = new Array();	
	var filas = valores.split("|");

	for(var i=0; i<filas.length; i++) {		
		var campos = filas[i].split("~");
		var filaTemp = new Array();
		var oid = campos[0];
		var desTipoSolic = campos[1];
		var desAtri = campos[2];
		var valDefecto = campos[3];
/*		var idValDefecto = campos[4];*/
		var obli = campos[4];
		var modi = campos[5];

		filaTemp[0] = oid;
		filaTemp[1] = desTipoSolic;
		filaTemp[2] = desAtri;

		if(valDefecto!="null") {
			filaTemp[3] = valDefecto;
		}
		else {
			filaTemp[3] = "";
		}

/*		if(idValDefecto!="null") {
			filaTemp[4] = idValDefecto;
		}
		else {
			filaTemp[4] = "";
		}*/

		if(obli=="1") {
			filaTemp[4] = "S";
		}
		else {
			filaTemp[4] = "N";
		}

		if(modi=="1") {
			filaTemp[5] = "S";
		}
		else {
			filaTemp[5] = "N";
		}

		datos[i] = filaTemp;
	}

	if(datos.length>0) {
		listado2.setDatos(datos);
		listado2.repintaDat();
		muestraCapasLista2();
		btnProxy(1,"1");
	}	
	else {
		ocultaCapasLista2();
		btnProxy(1,"0");
	}
	
	eval("frmContenido").oculto= "N";
	focaliza("frmContenido.cbTipoSolicitud");
  }

/* ------------------------------------------------------------------------------------------------------------------------------------------------------------------ */
  function recuperaValoresDefectoERR() {
	eval("frmContenido").oculto= "N";
	onLoadPag();
  }

/* ------------------------------------------------------------------------------------------------------------------------------------------------------------------ */
  function fGuardar() {  
    listado2.actualizaDat();
    
	var listadoDatos = listado2.datos;      
	var cantFilas = listadoDatos.length;
    var cantCols = listadoDatos[0].length;      
    var arrayValores = "";
	var oidTipo = get("frmContenido.cbTipoSolicitud");
      
    for(var i=0 ; i<cantFilas ; i++ ) {
        for(var j=0 ; j<cantCols; j++) {
            var dato = listadoDatos[i][j];
            if(dato =="") {
              dato = "null";
            }            

            if(arrayValores=="") {
                arrayValores = dato;
            }
            else{
                arrayValores = arrayValores + "," + dato;
            }            
        }
    }        

    set("frmContenido.listaValores", arrayValores);
    set("frmContenido.oidTipoSolicitud", oidTipo);
    eval("frmContenido").oculto= "S";        
    set("frmContenido.conectorAction", "LPMantieneValoresPorDefecto");
    set("frmContenido.accion", "guardarModificar");
    enviaSICC("frmContenido");
  }

/* ------------------------------------------------------------------------------------------------------------------------------------------------------------------ */
  function reInicio() {    
  	eval("frmContenido").oculto= "N";        
	onLoadPag();
    

/*	limpiarLista();
    listado1.setDatos(datosLista);   
    set('frmContenido.cbTipoSolicitud','');   
    setTimeout("focaliza('frmContenido.cbTipoSolicitud','')",200);
    focaliza('frmContenido.cbTipoSolicitud');*/
  }

/* ------------------------------------------------------------------------------------------------------------------------------------------------------------------ */
  function fErrorAlGuardar() {
    eval("frmContenido").oculto= "N";        
    focaliza('frmContenido.cbTipoSolicitud');
  }

/* ------------------------------------------------------------------------------------------------------------------------------------------------------------------ */
  function focalizaListaShTab(FILAEVENTO) {
	if(FILAEVENTO == 0){     	
	  setTimeout("focoBuscar()",10);                   
    }        
  }

/* ------------------------------------------------------------------------------------------------------------------------------------------------------------------ */
  function focalizaListaTab(FILAEVENTO) {
	if(FILAEVENTO == (listado2.datos.length - 1)) {
		setTimeout("focaliza('frmContenido.cbTipoSolicitud','')",10); 
    }
  }
