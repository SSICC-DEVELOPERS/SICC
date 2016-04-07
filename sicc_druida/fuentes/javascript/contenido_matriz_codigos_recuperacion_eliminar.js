var formName = 'frmFormulario.';
var formNameSinPunto = 'frmFormulario';
	

function fBorrar() {
	if (listado1.numSelecc()== 0) {
        GestionarMensaje('1021',null,null,null);
        return false;
     } else{
            //alert('contenido de codSeleccionados:::' + listado1.codSeleccionados());
            
            eliminarFilas(listado1.codSeleccionados(), "PREEliminarMatricesCodigosRecuperacion", mipgndo, null, false);
      }
}


function fLimpiar(){	
	cargarAccion("Matriz seleccionada");
}

function inicializar(){
	//alert("menu: " + get(formName + 'SICC_TOOLBAR_CONFIG'));
	configurarMenuSecundario("frmFormulario");
	onLoadPag();
	focalizaBotonHTML('botonContenido' ,'btnBuscarProductoprincipal');		    

	fMostrarMensajeError(); 
}


function focalizaTab(componente) {  
	if (componente==1){
			focalizaBotonHTML('botonContenido' ,'btnBuscarProductoRecuperacion');
	}else if (componente==2){
			focalizaBotonHTML('botonContenido' ,'btnBuscarProductoprincipal');	
	}
}


function focalizaTabShift(componente) {    
    if (componente==1){		   
			focalizaBotonHTML('botonContenido' ,'btnBuscarProductoRecuperacion');		   
	} else if (componente==2){	
		focalizaBotonHTML('botonContenido' ,'btnBuscarProductoprincipal');	
	}
}

function onLoadPag()   {
    DrdEnsanchaConMargenDcho('listado1',12);   
     ocultarCapas();
     eval (ON_RSZ);  
}



function cargarAccion(accion){
    if(accion == "buscarProductoPrincipal" || accion == "Matriz seleccionada") {
		set(formName + "conectorAction" ,"LPBuscarMatrizCodigosRecuperacion"); 
		set(formName + 'accion', accion);
		enviaSICC(formNameSinPunto);	
	} else {

		var arr = new Array();
		arr[arr.length]=new Array('oidCabeceraMF', get(formName + 'hidOidFacturacion'));
		arr[arr.length]=new Array('codigoVenta', get(formName + 'hidCodigoVenta'));
		arr[arr.length]=new Array('descripcionProducto', get(formName + 'hidDescripcion'));   
		arr[arr.length]=new Array('oidIdioma', get(formName + 'hIdioma'));
		arr[arr.length]=new Array('oidPais', get(formName + 'hPais'));
		arr[arr.length]=new Array('indicadorSituacion', '1');
		arr[arr.length]=new Array('tamanioPagina', '2');

		  
		configurarPaginado(mipgndo,"PREBuscarMatricesCodigosRecuperacion","ConectorBuscarMatricesCodigosRecuperacion","es.indra.sicc.dtos.pre.DTOEBuscarMatrizCodigosRecuperacion", arr);
	}
}


function mostrarLista( ultima, rowset){
	var tamano = rowset.length;

	//alert("tamano:" + tamano);

    if (tamano > 0) {
		//reemplazarValores(rowset);
		muestraCapas();
		if(get(formName + 'casodeuso')=="eliminar"){
			btnProxy(4,'1');
		}
		return true;		
	}else {
		ocultarCapas();		
		btnProxy(4,'0');
		return false; 

	}

}

function ocultarCapas(){
    document.all["Cplistado1"].style.visibility='hidden';
    document.all["CpLin1listado1"].style.visibility='hidden';
    document.all["CpLin2listado1"].style.visibility='hidden';
    document.all["CpLin3listado1"].style.visibility='hidden';
    document.all["CpLin4listado1"].style.visibility='hidden';
	//document.all["capaTitulo"].style.visibility='hidden';

    document.all["primera1Div"].style.visibility='hidden';
    document.all["ret1Div"].style.visibility='hidden';
    document.all["ava1Div"].style.visibility='hidden';    

    document.all["separaDiv"].style.visibility='hidden';    

  }

  function muestraCapas(){
    document.all["Cplistado1"].style.visibility='';
    document.all["CpLin1listado1"].style.visibility='';
    document.all["CpLin2listado1"].style.visibility='';
    document.all["CpLin3listado1"].style.visibility='';
    document.all["CpLin4listado1"].style.visibility='';
	//document.all["capaTitulo"].style.visibility='';

    document.all["primera1Div"].style.visibility='';
    document.all["ret1Div"].style.visibility='';
    document.all["ava1Div"].style.visibility='';    

    document.all["separaDiv"].style.visibility='';
  }

  function reemplazarValores(rowset){

	  var valorRecuperacionAutomatica = 6;
	  var valorEmitirMensj = 7;
	 
	  var si = GestionarMensaje(1010);
	  var no = GestionarMensaje(1011);
	
	  for( var i = 0; i < rowset.length; i++ ){
	
	    //reemplazar los valores de indicador recuperacion automatica
	     //reemplazar los valores de emitir mensaje
	    if( rowset[i][valorRecuperacionAutomatica] == '1')
	      rowset[i][valorRecuperacionAutomatica] = si;
	    else
	      rowset[i][valorRecuperacionAutomatica] = no;
	
	    //reemplazar los valores de emitir mensaje
	    if( rowset[i][valorEmitirMensj] == '1')
	      rowset[i][valorEmitirMensj] = si;
	    else
	      rowset[i][valorEmitirMensj] = no;
	  }
    
  }
