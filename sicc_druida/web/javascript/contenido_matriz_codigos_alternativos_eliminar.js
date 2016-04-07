var formName = 'frmFormulario.';
var formNameSinPunto = 'frmFormulario';



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


function fLimpiar(){    
         cargarAccion("Matriz seleccionada");
}


function onLoadPag(){ 
	configurarMenuSecundario("frmFormulario");
    DrdEnsanchaConMargenDcho('listado1',12);
	ocultarLista();	
	eval (ON_RSZ);
	
		if( !fMostrarMensajeError() ){
		if((get('frmFormulario.hidDatosReemp')=="N") || (get('frmFormulario.hidDatosReemp')=="")){
			ocultarLista();
		} else if(get('frmFormulario.hidDatosReemp')=="S") {
			mostrarLista();
		}
		focalizaBotonHTML('botonContenido' ,'btnBuscarProductoPrincipal');		    
	} 
}      

function focalizaTab(componente) {  
	if (componente==1){
		focalizaBotonHTML('botonContenido' ,'btnBuscarProductoAlternativo');	  
	}else if (componente==2){
		focalizaBotonHTML('botonContenido' ,'btnBuscarProductoPrincipal');	
	}
}


function focalizaTabShift(componente) {    
	if (componente==1){             
		focalizaBotonHTML('botonContenido' ,'btnBuscarProductoAlternativo');	
	} else if (componente==2){	
		focalizaBotonHTML('botonContenido' ,'btnBuscarProductoPrincipal');	
	}
}

 
function ocultarLista() {
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


function cargarAccion(accion){
	if(accion == "buscarProductoPrincipal" || accion == "Matriz seleccionada") {
		set('frmFormulario.accion',accion);
		set('frmFormulario.conectorAction','LPBuscarMatrizCodigosAlternativos');
		enviaSICC('frmFormulario');
	} else {
		var arr = new Array() ;
		arr[arr.length] = new Array("oidCabeceraMF", get("frmFormulario.oidMatrizFacturacion")+"");
		arr[arr.length] = new Array("codigoVenta", get("frmFormulario.codigoVenta")+"");
		arr[arr.length] = new Array("descripcionProducto", get("frmFormulario.descripcionProducto")+"");
		arr[arr.length] = new Array("oidIdioma",  get("frmFormulario.hIdioma")+"");
		arr[arr.length] = new Array("oidPais",  get("frmFormulario.hPais")+"");
		configurarPaginado(mipgndo,"PREBuscarMatricesCodigosAlternativos","ConectorBuscarMatricesCodigosAlternativos","es.indra.sicc.dtos.pre.DTOEBuscarMatrizCodigosAlternativos",arr);
		set("frmFormulario.hidDatosReemp","S");
	}
}


function mostrarLista( ultima, rowset){
	var tamano = rowset.length;

	if (tamano > 0) {
		//reemplazarValores(rowset);
		muestraCapas();
		if(get("frmFormulario.casoDeUso") =="eliminar"){
			btnProxy(4,'1');
		}
		return true;
	}else {
		ocultarLista();	
		btnProxy(4,'0');
		return false;
	}

}


function reemplazarValores(rowset){
	var valorEmitirMensj = 6;
	var si = GestionarMensaje(1010);
	var no = GestionarMensaje(1011);
         
	for( var i = 0; i < rowset.length; i++ ){
		//reemplazar los valores de emitir mensaje
		if( rowset[i][valorEmitirMensj] == '1')
			rowset[i][valorEmitirMensj] = si;
		else
			rowset[i][valorEmitirMensj] = no;
	}
}

var arrFilas = null;

function fBorrar() {
	if (listado1.numSelecc()== 0) {
		GestionarMensaje('1021',null,null,null);
		return false;
	}else{
		eliminarFilas(listado1.codSeleccionados(), "PREEliminarMatricesCodigosAlternativos", mipgndo,null, false);
	}	
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
}
