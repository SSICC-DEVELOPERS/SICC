/**
* Copyright 2004 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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


/*
    INDRA/CAR/PROY
    $Id: contenido_formas_pago_detalle_consultar.js,v 1.1 2009/12/03 19:01:47 pecbazalar Exp $
    DESC
*/
var FORMULARIO = 'formulario';

//Funcion que se ejecuta al cargar la pagina
function onLoadPag()   {
	
    
    if (get(FORMULARIO+'.errDescripcion')!='') {
		var wnd = fMostrarMensajeError(get(FORMULARIO+'.errCodigo'),get(FORMULARIO+'.errDescripcion'));
    }   
    focaliza(FORMULARIO + ".cbFormaPago");
    configurarMenuSecundario(FORMULARIO); 
    
    
    
    
    //*************************************************************************
    
    //recarga de combos dependientes
    var idioma = get('formulario.idioma').toString();
    var pais = get('formulario.pais');
  
   // recargaCombo('formulario.cbFormaPago', 'BELObtenerFormasPagoCabecera', 'es.indra.sicc.util.DTOBelcorp', [["oidIdioma", idioma], ["oidPais", pais]]);
   // recargaCombo('formulario.cbCanal', 'SEGConsultaCanales', 'es.indra.sicc.util.DTOBelcorp', [["oidIdioma", idioma], ["oidPais", pais]]);
   // recargaCombo('formulario.cdMarca', 'SEGConsultarMarcas', 'es.indra.sicc.util.DTOBelcorp', [["oidIdioma", idioma], ["oidPais", pais]]);
   // recargaCombo('formulario.cbMedioPago', 'BELObtenerMediosPagoCombo', 'es.indra.sicc.util.DTOBelcorp', [["oidIdioma", idioma], ["oidPais", pais]]);
  
    
    //**************************************************************************
}

//Funcion que se ejecuta cuando se pulsa buscar
function accionBuscar() {
	//Llamamos a configurarPaginado pasandole los siguientes parametros: 
	var formaPagoCabecera =get(FORMULARIO+'.cbFormaPago');
	var canal = get(FORMULARIO+'.cbCanal');
	var marca =get(FORMULARIO+'.cbMarca');
	var medioPago =get(FORMULARIO+'.cbMedioPago');
	var indicadorDeDias = get(FORMULARIO+'.cbIndicadorDias','T');
	var idioma=get(FORMULARIO+'.idioma');
	var pais=get(FORMULARIO+'.pais');
	configurarPaginado(mipgndo, "BELBuscarFormasPagoDetalle", "ConectorBuscarFormasPagoDetalle","es.indra.sicc.dtos.bel.DTOEBuscarFormasPagoDetalle", [ ["oidFormaPagoCabecera", formaPagoCabecera], ["oidCanal", canal], ["oidMarca", marca], ["oidMedioPago", medioPago], ["indicadorDeDias",indicadorDeDias],["oidPais",pais],["oidIdioma",idioma]]);	
	
}


function accionDetalle() {
	
	//Llamar a la lp LPMantenimientoFormasPagoDetalle con acción "detalle"
	 if (listado1.numSelecc() == 0) {
        //Mostramos mensaje de error 
        GestionarMensaje('50');
    } else {
          if (listado1.numSelecc() != 1 ) {
              //Muesta el mensaje: "Debe seleccionar un solo registro"
              GestionarMensaje('1217');
              //Se limpia la lista editable
              var seleccion=listado1.codigos();
              var i=0;
              while(seleccion[i]!=null){
                  listado1.deselecciona(i); 
                  i++;           
              }
   } else {
 		//Obtenemos los datos del seleccionado y los insertamos	
 		var codigo = listado1.codSeleccionados()
 		var objParams = new Object();	
		objParams.oid = codigo; 
		objParams.descFormaPago = listado1.extraeDato(codigo,0); 
                mostrarModalSICC('LPMantenimientoFormasPagoDetalle', 'detalle', objParams, null, null);    	
          }
   }
}
 
//Funcion para hacer visible la capa
function visibleLista() {
    DrdEnsanchaConMargenDcho('listado1',12);
    
    visibilidad('capaLista','V');
    
    eval (ON_RSZ);
}

//Funcion para no visible la capa
function novisibleLista() {
    visibilidad('capaLista','O');
}

function muestraLista( ultima, rowset){

		var tamano = rowset.length;
		if (tamano > 0) {
			visibleLista();
			return true;
		} else {
			novisibleLista();
         	focaliza(FORMULARIO+'.cbFormaPago','');
		  	return false;
		 }
	}

function focoboton(){
	if(get_visibilidad("capaLista")){
			document.all['btnDetalle'].focus();
	}else{
		document.all['btnBuscar'].focus();
	}
}

function focobotonBuscar(){
	if(get_visibilidad("capaLista")){
			document.all['btnDetalle'].focus();
	}else{
		focaliza(FORMULARIO+'.cbFormaPago');
	}
}

function focoBuscar(){
	document.all['btnBuscar'].focus();
}