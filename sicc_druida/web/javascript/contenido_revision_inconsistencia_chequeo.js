function onLoadPag() {  
	configurarMenuSecundario("formulario");
    DrdEnsanchaConMargenDcho('listado1',12);     
	eval (ON_RSZ);  
	set("formulario.txtFecha", get("formulario.fechaSistema"));
	ocultaLista1();
	focaliza("formulario.txtFecha");
}

function ocultaLista1() {
	document.all["Cplistado1"].style.visibility='hidden';
    document.all["CpLin1listado1"].style.visibility='hidden';
    document.all["CpLin2listado1"].style.visibility='hidden';
    document.all["CpLin3listado1"].style.visibility='hidden';
    document.all["CpLin4listado1"].style.visibility='hidden';
    document.all["avaDiv"].style.visibility='hidden';
    document.all["retDiv"].style.visibility='hidden';
    document.all["separaDiv"].style.visibility='hidden';
	document.all["primeraDiv"].style.visibility='hidden';    
	document.all["btnRevisarDiv"].style.visibility='hidden';
}

function muestraLista1() {
	document.all["Cplistado1"].style.visibility='';
    document.all["CpLin1listado1"].style.visibility='';
    document.all["CpLin2listado1"].style.visibility='';
    document.all["CpLin3listado1"].style.visibility='';
    document.all["CpLin4listado1"].style.visibility='';
    document.all["avaDiv"].style.visibility='';
    document.all["retDiv"].style.visibility='';
    document.all["separaDiv"].style.visibility='';
	document.all["primeraDiv"].style.visibility='';    
	document.all["btnRevisarDiv"].style.visibility='';
}

function onTABtxtFecha() {
	focalizaBotonHTML('botonContenido','btnBuscar');
}

function onSHTABtxtFecha() {
	focalizaBotonHTML('botonContenido','btnBuscar');
}

function onTABbtnBuscar() {
	focaliza('formulario.txtFecha');
}

function onSHTABbtnBuscar() {
	focaliza('formulario.txtFecha');
}

function onClickBuscar() {
	if(sicc_validaciones_generales()) {
	    var arr = new Array();
		arr[arr.length] = new Array("fecha", get("formulario.txtFecha")+"");    	    configurarPaginado(mipgndo,"APEBuscarInconsistenciaChequeo","ConectorBuscarInconsistenciaChequeo","es.indra.sicc.dtos.ape.DTODate",arr);  
	}
}

function muestraLista(ultima, rowset, error){
	var tamano = rowset.length;
    if (tamano > 0) {
		muestraLista1();
        eval (ON_RSZ);
        focalizaBotonHTML('botonContenido','btnBuscar');
        return true;
    }
    else {
		ocultaLista1();
        focalizaBotonHTML('botonContenido','btnBuscar');
        return false;
    }
}

function onClickRevisar() {
	/*  Llamar a la LP LPRevisionInconsistenciaChequeo con accion "revisarCaja" */

	 //1° Se verifica que se haya elegido un registro en la lista
	  if (listado1.numSelecc()!= 1) {
		GestionarMensaje('1022',null,null,null);
		return false;
	  }

  	  //2° Se toman datos de la lista y se abre la ventana modal con los datos del detalle.
      var arrAux = new Array();
      arrAux = listado1.codSeleccionados();
      var posicion = obtenerPosicionListaEditable(listado1.codSeleccionados(),listado1);
      var obj = new Object();

      obj.oidCabecera = listado1.datos[posicion][1];           
      obj.numeroCaja = listado1.datos[posicion][3];           
      obj.numeroEtiqueta = listado1.datos[posicion][5];       	  
      obj.accion = "revisarCaja";
      
      mostrarModalSICC('LPRevisionInconsistenciaChequeo','revisarCaja',obj);
	  //3° Al cerrar la modal se refresca los datos de la lista
	  onClickBuscar();
  	  //4° Se pone el foco en el boton buscar
	  focalizaBotonHTML('botonContenido','btnBuscar');
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

function onTABBotonRevisar() {
	focaliza("formulario.txtFecha");
}

function onSHTABBotonRevisar() {
	focalizaBotonHTML('botonContenido','btnBuscar');
}