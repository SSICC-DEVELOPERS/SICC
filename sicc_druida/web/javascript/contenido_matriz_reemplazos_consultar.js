
var formName = 'frmFormulario.';
var formNameSinPunto = 'frmFormulario';
		
function fBorrar() {
     if (listado1.numSelecc()== 0) {
        GestionarMensaje('1021',null,null,null);
        return false;
     } else{            
            eliminarFilas(listado1.codSeleccionados(), "PREEliminarMatricesCodigosReemplazo", mipgndo,null, false);
      }	
  }

 function focalizaTab(componente) {  
	if (componente==1){
			focalizaBotonHTML('botonContenido' ,'btnBuscarProductoRemmplazos');
	}else if (componente==2){
			focalizaBotonHTML('botonContenido' ,'btnBuscarProductoPrincipal');	
	}
}


function focalizaTabShift(componente) {    
    if (componente==1){		   
			focalizaBotonHTML('botonContenido' ,'btnBuscarProductoRemmplazos');		   
	} else if (componente==2){	
		focalizaBotonHTML('botonContenido' ,'btnBuscarProductoPrincipal');	
	}
}

  

function fLimpiar(){	
	cargarAccion("Matriz seleccionada");
}

function inicializar(){
	
	configurarMenuSecundario("frmFormulario");
	
	onLoadPag();

	focalizaBotonHTML('botonContenido' ,'btnBuscarProductoPrincipal');	

	fMostrarMensajeError();
		

}

function onLoadPag()   {
  
    DrdEnsanchaConMargenDcho('listado1',12);   
     ocultarCapas();
     eval (ON_RSZ);  

   }



function cargarAccion(accion){
    if(accion == "buscarProductoPrincipal" || accion == "Matriz seleccionada") {
		set(formName + "conectorAction" ,"LPBuscarMatrizCodigosReemplazo"); 
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

		  
		configurarPaginado(mipgndo,"PREBuscarMatricesCodigosReemplazo","ConectorBuscarMatricesCodigosReemplazo","es.indra.sicc.dtos.pre.DTOEBuscarMatrizCodigosReemplazo", arr);
	}

}


function mostrarLista( ultima, rowset){
	var tamano = rowset.length;

	//alert("tamano:" + tamano);

    if (tamano > 0) {
		reemplazarValores(rowset);
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
	return true;

}

function ocultarCapas(){
    document.all["Cplistado1"].style.visibility='hidden';
    document.all["CpLin1listado1"].style.visibility='hidden';
    document.all["CpLin2listado1"].style.visibility='hidden';
    document.all["CpLin3listado1"].style.visibility='hidden';
    document.all["CpLin4listado1"].style.visibility='hidden';
	document.all["capaTitulo"].style.visibility='hidden';

    document.all["primera1Div"].style.visibility='hidden';
    document.all["ret1Div"].style.visibility='hidden';
    document.all["ava1Div"].style.visibility='hidden';    
  }

  function muestraCapas(){
    document.all["Cplistado1"].style.visibility='';
    document.all["CpLin1listado1"].style.visibility='';
    document.all["CpLin2listado1"].style.visibility='';
    document.all["CpLin3listado1"].style.visibility='';
    document.all["CpLin4listado1"].style.visibility='';
	document.all["capaTitulo"].style.visibility='';

    document.all["primera1Div"].style.visibility='';
    document.all["ret1Div"].style.visibility='';
    document.all["ava1Div"].style.visibility='';    
  }

  function reemplazarValores(rowset){

	  var valorAntesDeCuadre = 11;
	  var valorEmitirMensj = 12;
	  var antesDeCuadre = GestionarMensaje(1207);
	  var despuesDeCuadre = GestionarMensaje(1208);
	  var si = GestionarMensaje(1010);
	  var no = GestionarMensaje(1011);
	
	  for( var i = 0; i < rowset.length; i++ ){
	
	    //reemplazar los valores de indicador antes de cuadre		
	    if(rowset[i][valorAntesDeCuadre] == '1'){
	      rowset[i][valorAntesDeCuadre] = antesDeCuadre;
	    }else{
	      if(rowset[i][valorAntesDeCuadre] == '0'){
	         rowset[i][valorAntesDeCuadre] = despuesDeCuadre;
	   	  }else{
		     rowset[i][valorAntesDeCuadre] = '';
		  }
		}
	
	    //reemplazar los valores de emitir mensaje
	  
		if( rowset[i][valorEmitirMensj] == 'SI')
	      rowset[i][valorEmitirMensj] = si;
	    else
	      rowset[i][valorEmitirMensj] = no;
	  }
    
  }
