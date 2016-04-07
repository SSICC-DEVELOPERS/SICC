var FORMULARIO = "formulario";
var cargado = false;

function onLoadPag(){
  
	if (get(FORMULARIO + '.errDescripcion')!='') {
			var wnd = fMostrarMensajeError(get(FORMULARIO + '.errCodigo'), get(FORMULARIO + '.errDescripcion'));
			window.close();
	}
	cargado = true;
	configurarMenuSecundario(FORMULARIO);
	/*Llamamos a configurarPaginado pasándole los siguientes parametros: 

	- Objeto paginado (lstVinculos) 
	- idBusiness ("CALObtenerDocumentos") 
	- "ConectorObtenerDocumentos" 
	- "DTOOID"  se cambio por un DTOOIDPaginado incidencia BELC300012536
	- Parametros del DTO: 
	- pais activo 
	- idioma activo 
	- oidCliente
	*/
	
	var idioma = get(FORMULARIO+'.idioma');
	var pais = get(FORMULARIO+'.pais');
	var DTOOIDPaginado ='es.indra.sicc.cmn.negocio.comun.DTOComunes.DTOOIDPaginado';
	var oidCliente = get(FORMULARIO+'.oidCliente');
	
	
	configurarPaginado(mipgndo, 'CALObtenerDocumentos', 'ConectorObtenerDocumentos', 
	DTOOIDPaginado , [ ['oid', oidCliente], ['oidIdioma',idioma], ['oidPais',pais] ] );

}

	function muestraLista( ultima, rowset){
		DrdEnsanchaConMargenDcho('listado1',12);
		document.all["Cplistado1"].style.visibility='visible';
		document.all["CpLin1listado1"].style.visibility='visible';
		document.all["CpLin2listado1"].style.visibility='visible';
		document.all["CpLin3listado1"].style.visibility='visible';
		document.all["CpLin4listado1"].style.visibility='visible';
		document.all["primera1Div"].style.visibility='visible';
		document.all["ret1Div"].style.visibility='visible';
		document.all["ava1Div"].style.visibility='visible';
		document.all["separaDiv"].style.visibility='visible';
		eval (ON_RSZ); 
		setTimeout("document.all['primera1I'].parentElement.focus();", 500);
		return true;
	}

function configurarMenuSecundario(strFrame){

    /*
	Este funcion se encarga de configurar la botonera, para ello
    parsea el contenido del var configuracion.
    */

    //obtengo el String con la configuracion a aplicar

	var strCodigos = get(strFrame+".SICC_TOOLBAR_CONFIG");

    if(strCodigos!=null && strCodigos.split(" ").join("")!="" ){

    	//obtengo un array con cada elemento configurable.
    	//arrCodigos = strCodigos.split(",");
    	strCodigos = strCodigos.split("[").join("");
    	strCodigos = strCodigos.split("]").join("");
    	var arrCodigos = strCodigos.split(",");
    	var etiqueta;
    	if((arrCodigos[0]+"")!="-1"){
    		etiqueta = document.title;
    	}else{
    		etiqueta = "Belcorp";
    	}
    	var guardar = arrCodigos[1]+"";
    	var volver = arrCodigos[2]+"";
    	var salir = arrCodigos[3]+"";
       	var borrar = arrCodigos[4]+"";
       	var limpiar = arrCodigos[5]+"";
       	var imprimir = arrCodigos[6]+"";
       	var clave = arrCodigos[7]+"";
       	var favoritos = arrCodigos[8]+"";
       	var pais = arrCodigos[9]+"";
       	var ayuda = arrCodigos[10]+"";
      	
    	//seteo el titulo
       	parent.parent.frames["iconos"].txt_to("etiqueta1",etiqueta);
       	//seteo el estado de los botones
       	btnProxy(1,guardar);
       	btnProxy(2,volver);
       	btnProxy(3,salir);
       	btnProxy(4,borrar);
       	btnProxy(5,limpiar); 	
    	btnProxy(6,imprimir);
    	btnProxy(7,clave);
    	btnProxy(8,favoritos);
    	btnProxy(9,pais);
    	btnProxy(10,ayuda);
    	parent.parent.frames["iconos"].ocultarCapa();

    }
    parent.parent.frames["iconos"].setActive(true);

}

function btnProxy(ordinalBoton, estadoBoton){

	parent.parent.frames["iconos"].set_estado_botonera("btnBarra",ordinalBoton,convertEstado(estadoBoton));
}

function clickButton(number) {

	var imagenes = parent.parent.frames["iconos"].document.getElementsByTagName("IMG");

    for(var i=0; i< imagenes.length;i++){
		var imagen = imagenes[i];
        if (imagen.name && imagen.name.toUpperCase() == ("BTNBARRA"+number)) {
	        imagen.parentElement.click();
            break;
        }
	}
    return false;
}
   

function accionFicha(){
	
	/*Llamar a la LPPresentarClientes con: 
	accion = "Ver Ficha" 
	pais activo 
	oidCliente 
	oidTipoCliente 
	oidSubtipoCliente 
	indConsultoraInterna
	*/

	set(FORMULARIO+'.conectorAction',"LPPresentarClientes");    
	set(FORMULARIO+'.accion',"Ver Ficha Solo");                  
	enviaSICC(FORMULARIO);                                  

}

function accionContactos(){

	/*Llamar a la LPContactos con: es la LPGestionarContactos
	accion = "" 
	pais activo 
	oidCliente 
	oidTipoCliente 
	oidSubtipoCliente 
	indConsultoraInterna 
	*/
	
	set(FORMULARIO+'.conectorAction',"LPGestionarContactos");    
	set(FORMULARIO+'.accion',"");                  
	enviaSICC(FORMULARIO);                   
}

function accionCuentasCorrientes(){

	/*Llamar a la LPPresentarClientes con: 
	accion = "Cuentas corrientes" 
	pais activo 
	oidCliente 
	oidTipoCliente 
	oidSubtipoCliente 
	indConsultoraInterna
	*/
	
	set(FORMULARIO+'.conectorAction',"LPPresentarClientes");    
	set(FORMULARIO+'.accion',"Cuentas corrientes");                  
	enviaSICC(FORMULARIO);               
}

function accionPedidos(){

	/*Llamar a la LPPresentarClientes con: 
	accion = "Pedidos" 
	pais activo 
	oidCliente 
	oidTipoCliente 
	oidSubtipoCliente 
	indConsultoraInterna
	*/

	set(FORMULARIO+'.conectorAction',"LPPresentarClientes");   
	set(FORMULARIO+'.accion',"Pedidos");            
	enviaSICC(FORMULARIO);                                     
}

function accionVinculos(){

	/*Llamar a la LPPresentarClientes con: 
	accion = "Documentos" 
	pais activo 
	oidCliente 
	oidTipoCliente 
	oidSubtipoCliente 
	indConsultoraInterna
	*/
	
	set(FORMULARIO+'.conectorAction',"LPPresentarClientes");   
	set(FORMULARIO+'.accion',"Vinculos");             
	enviaSICC(FORMULARIO);                                     
}

function accionDireccion(){

	/*Llamar a la LPPresentarClientes con: 
	accion = "Direccion" 
	pais activo 
	oidCliente 
	oidTipoCliente 
	oidSubtipoCliente 
	indConsultoraInterna
	*/
	set(FORMULARIO+'.conectorAction',"LPPresentarClientes");   
	set(FORMULARIO+'.accion',"Direccion");            
	enviaSICC(FORMULARIO);             
}

	function navPestana(label) {
         if (typeof(parent.pestanas) != undefined )
         	parent.pestanas.onClickPestana(label);
	}
