/**
* Copyright 2005 © por Indra Sistemas,S.A.. Todos los derechos reservados.
* Avda. de Bruselas, 35
* Parque Empresarial Arroyo de la Vega
* 28108 Alcobendas, Madrid
* España
*
* Privado y Confidencial.
* La información contenida en este documento es propiedad de Indra sistemas.
* Para uso exclusivo de empleados autorizados no permitiéndose
* la distribución de este código sin permiso expreso.
*/

var FORMULARIO = 'frmContenido';

function onLoadPag()   { 
          if (get(FORMULARIO+'.errDescripcion')!='') {
                  var wnd = fMostrarMensajeError(get(FORMULARIO+'.errCodigo'),get(FORMULARIO+'.errDescripcion'));
          }
          
	    //DrdEnsanchaConMargenDcho('listado1',12);
	    
	    document.all["Cplistado1"].style.visibility='';
	    document.all["CpLin1listado1"].style.visibility='';
	    document.all["CpLin2listado1"].style.visibility='';
	    document.all["CpLin3listado1"].style.visibility='';
	    document.all["CpLin4listado1"].style.visibility='';

	    document.all["primera1Div"].style.visibility='';
	    document.all["ret1Div"].style.visibility='';
	    document.all["ava1Div"].style.visibility='';
	    document.all["separaDiv"].style.visibility='';

	    //eval (ON_RSZ);            
          
          //Control del foco
          focaliza(FORMULARIO + ".txtCodCliente");
          
          configurarMenuSecundario(FORMULARIO);
}

function cargarLista(){ //bntBuscar
	var codCliente = get(FORMULARIO+'.txtCodCliente');
	var oidPais = get(FORMULARIO+'.idioma');
	var oidIdioma = get(FORMULARIO+'.pais');
	var conector = "" //falta
	var DTOString = 'es.indra.sicc.util.DTOString';
	/*
	configurarPaginado(mipgndo, "RECConsultarCabeceraReclamo ", conector, DTOString, 
	[["cadena",codCliente],
	["oidPais", oidPais],
	["oidIdioma", oidIdioma]] )
	*/
	alert("Busqueda de cliente");
	visibleLista();
}

function onClickConsultar(){
	/*
	Llamamos a la LPConsultarInforme con: 
	- accion = "consultar informe" 
	- codCliente
	*/
	//SOLO SE PUEDE SELECCIONAR UNO O VARIOS?

	if (listado1.numSelecc() == 0) {
		// Muestra el mensaje: "Debe seleccionar un elemento de la lista"
		GestionarMensaje('50');
	} else {
		if (listado1.numSelecc() != 1 ) {
			//Muesta el mensaje: "Debe seleccionar un solo registro"
			GestionarMensaje('8');
		} else {
	
			var oidCliente = listado1.codSeleccionados();
			alert("OidCliente: "+oidCliente);
			var codCliente=listado1.extraeDato(oidCliente,0);
		
			alert("CodigoCliente: "+codCliente);
			/*
			var objParams = new Object();
			objParams.codCliente=codCliente;                                           
			mostrarModalSICC('LPConsultarInforme', 'consultar reclamo', objParams, null, null);
			*/
			//Si no es modal y es el oidcliente de la lista lo que hay que pasar y no el codCliente
		       set(FORMULARIO+'.codCliente',codCliente);
		       set(FORMULARIO+'.accion','consultar reclamo');
		       set(FORMULARIO+'.conectorAction','LPConsultarInforme');
		       enviaSICC(FORMULARIO);			
		}
	}
			

	
}

function visibleLista() {
         DrdEnsanchaConMargenDcho('listado1',12);
         visibilidad('capaLista','V');
         eval (ON_RSZ);  
         ON_RSZ = '';
}

function invisibleLista() {
         visibilidad('capaLista','O');
}

function muestraLista(ultima, rowset){
	var tamano = rowset.length;
	if (tamano > 0) {
	          visibleLista();
	          return true;
	} else {
	          invisibleLista();                
	          focaliza(FORMULARIO+'.txtCodCliente');
	          return false;
	}
}

function iconoCliente(txtCodCliente){
    //Llamamos al proceso correspondiente Modal
    var objParams = new Object();
    var cliente = mostrarModalSICC('LPBusquedaRapidaCliente', '', objParams, null, null);            

    if (cliente != null && cliente.length > 1) {
         var codigoCliente = cliente[1];
         set(FORMULARIO+'.'+txtCodCliente,codigoCliente);
    }
    return;
}

function codClienteOnShtab(){
	if (!get_visibilidad("capaLista")) {
		document.all['btnBuscar'].focus();
	}else{
	       document.all['Consultar'].focus();
	}
}
function buscarOntab(){
	if (!get_visibilidad("capaLista")) {
		focaliza(FORMULARIO+'.txtCodCliente');
	}else{
	       document.all['Consultar'].focus();
	}
}