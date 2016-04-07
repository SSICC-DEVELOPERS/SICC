function onLoad() {
  ocultarLista();
  configurarMenuSecundario('formulario');
  /*var acc = get('formulario.accion');
  var opcionMenu = get('formulario.opcionMenu');*/
  focaliza('formulario.cbMagnitud');
}

//--------------------------------------------------------------------------------------------------------

function onChangeMagnitud () {
         var oidMagnitud = get('formulario.cbMagnitud', 'V');
         set('formulario.oidMagnitud', oidMagnitud); 
         if (oidMagnitud != '') {
                  var array = new Array();
                  array[0] = new Array('oid',oidMagnitud);
                  array[1] = new Array('oidIdioma',get('formulario.varIdioma'));
				  array[2] = new Array('oidPais',get('formulario.varPais'));
				  set_combo('formulario.cbUnidMedOrigen', arrayVacio());
				  set_combo('formulario.cbUnidMedDestino', arrayVacio());

                  recargaCombo('formulario.cbUnidMedOrigen',
                                             'APEObtenerUnidadesMedidaPorMagnitud',
                                             'es.indra.sicc.util.DTOOID',
                                             array,
                                             'setearcbUnidMedOrigen(datos)');
                  
				  recargaCombo('formulario.cbUnidMedDestino',
                                             'APEObtenerUnidadesMedidaPorMagnitud',
                                             'es.indra.sicc.util.DTOOID',
                                             array,
                                             'setearcbUnidMedDestino(datos)');

         } else {
                  set_combo('formulario.cbUnidMedOrigen', arrayVacio());
				  set_combo('formulario.cbUnidMedDestino', arrayVacio());
         }
}

//--------------------------------------------------------------------------------------------------------

function accionBuscar() {

  ocultarLista();
  
  var parametros = new Array();
  parametros[parametros.length] = new Array('oidIdioma', get('formulario.varIdioma'));
  parametros[parametros.length] = new Array('oidPais', get('formulario.varPais'));

  var magnitud = get('formulario.cbMagnitud','V');
  if (magnitud != ''){
    parametros[parametros.length] = new Array('oidMagnitud', magnitud);
  }
  var unidMedOrigen = get('formulario.cbUnidMedOrigen','V');
  if (unidMedOrigen != ''){
    parametros[parametros.length] = new Array('oidUnidadMedidaOrigen', unidMedOrigen);
  }
  var unidMedDestino = get('formulario.cbUnidMedDestino','V');
  if (unidMedDestino != ''){
    parametros[parametros.length] = new Array('oidUnidadMedidaDestino', unidMedDestino);
  }
  configurarPaginado(mipgndo,
                      'APEBuscarFactoresConversion',
                      'ConectorBuscarFactoresConversion',
                      'es.indra.sicc.dtos.ape.DTOFactoresConversion',
                      parametros);
}

//--------------------------------------------------------------------------------------------------------

function muestraLista(ultima, rowset) {
         var tamano = rowset.length;
         if (tamano > 0) {
                  mostrarLista();
                  return true; 
         }else{
                  ocultarLista();
                  focaliza('formulario.cbMagnitud');
                  return false;  
         }
}

//-------------------------------------------------------------------------------------

function mostrarLista(){
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
         var opcionMenu = get('formulario.opcionMenu');
         if (opcionMenu == 'ModificarFactoresConversion') {
                  document.all["btnModificarDiv"].style.visibility='visible';
         } else if (opcionMenu = 'ConsultarFactoresConversion' || opcionMenu == 'EliminarFactoresConversion') {
                  document.all["btnDetalleDiv"].style.visibility='visible';
         }
         if (get('formulario.opcionMenu')=='EliminarFactoresConversion') {
                  btnProxy(4,1);
         }
         eval (ON_RSZ);
}

//-------------------------------------------------------------------------------------

function ocultarLista() {
    document.all["Cplistado1"].style.visibility='hidden';
    document.all["CpLin1listado1"].style.visibility='hidden';
    document.all["CpLin2listado1" ].style.visibility='hidden';
    document.all["CpLin3listado1"].style.visibility='hidden';
    document.all["CpLin4listado1"].style.visibility='hidden';
    document.all["primera1Div"].style.visibility='hidden';
    document.all["ret1Div"].style.visibility='hidden';
    document.all["ava1Div"].style.visibility='hidden';
    document.all["separaDiv"].style.visibility='hidden';    
    document.all["btnDetalleDiv"].style.visibility='hidden';
    document.all["btnModificarDiv"].style.visibility='hidden';
    btnProxy(4,0);
}

//-------------------------------------------------------------------------------------

function accionModificar() {
         var opcionMenu = get("formulario.opcionMenu");
         var oidPlantilla = null;
         var numPlantilla = null;
         var oidParamGrales = null;
         var filaMarcada = null;
         var codSeleccionados = null;
         var datos = null;
         var obj = new Object();
         listado1.actualizaDat();
         datos = listado1.datos;
		 //Comprueba si se ha seleccionado un solo elemento de la lista resultado 
         codSeleccionados = listado1.codSeleccionados();
         if (codSeleccionados.length > 1) {
                  GestionarMensaje('1022');//8
         return;
         }
         if ( codSeleccionados.length < 1) {
                  GestionarMensaje('4');
         return;
         }
		 asignarObjyMostrarModal(obj,listado1,codSeleccionados,opcionMenu,'modificar');
		 //Refrescar la lista paginada de resultados para que se muestren las modificaciones realizadas 
         accionBuscar();
}

//--------------------------------------------------------------------------------------------------------

function accionDetalle() {
         var opcionMenu = get("formulario.opcionMenu");
         var oidPlantilla = null;
         var numPlantilla = null;
         var oidParamGrales = null;
         var filaMarcada = null;
         var codSeleccionados = null;
         var datos = null;
         var obj = new Object();

         listado1.actualizaDat();
         datos = listado1.datos;
         //Comprueba si se ha seleccionado un solo elemento de la lista resultado 
		 codSeleccionados = listado1.codSeleccionados();
         if (codSeleccionados.length > 1) {
                  GestionarMensaje('1022');//8
         return;
         }
         if ( codSeleccionados.length < 1) {
                  GestionarMensaje('4');
         return;
         }
         asignarObjyMostrarModal(obj,listado1,codSeleccionados,opcionMenu,'detalle');
}

//--------------------------------------------------------------------------------------------------------

function accionEliminar() {
        if (listado1.numSelecc()== 0) {
            GestionarMensaje('1021',null,null,null);
			return false;
		}
        else {
			 // Comprueba que hay, al menos, un elemento seleccionado en la lista resultados 
			 listado1.actualizaDat();
			 datos = listado1.datos;
			 var codSeleccionados = listado1.codSeleccionados();
			 if ( codSeleccionados.length < 1) {
					  GestionarMensaje('4');
			 return;
			 }
			 //alert("oidsSeleccionados: " + listado1.codSeleccionados());
			 eliminarFilas(listado1.codSeleccionados(),"APEEliminarFactoresConversion", mipgndo);
		 }
}

function setearcbUnidMedOrigen(datos) {
         var arrayNuevo = new Array();
         arrayNuevo[0] = new Array('','');
         arrayNuevo = arrayNuevo.concat(datos);
         set_combo('formulario.cbUnidMedOrigen',arrayNuevo);
}

function setearcbUnidMedDestino(datos) {
         var arrayNuevo = new Array();
         arrayNuevo[0] = new Array('','');
         arrayNuevo = arrayNuevo.concat(datos);
         set_combo('formulario.cbUnidMedDestino',arrayNuevo);
}

//--------------------------------------------------------------------------------------------------------
function fLimpiar() {
	set('formulario.cbMagnitud', '');        
	set_combo('formulario.cbUnidMedOrigen', arrayVacio());
	set_combo('formulario.cbUnidMedDestino', arrayVacio());
  
  ocultarLista();
}
//--------------------------------------------------------------------------------------------------------
function fBorrar() {
         accionEliminar();
}

function arrayVacio(){  
    var array = new Array();             
        array[0] = new Array('','');
  
    return array;
}

function asignarObjyMostrarModal(obj,listado1,codSeleccionados,opcionMenu,accion){
	 obj.oidFactoresConversion = codSeleccionados[0]; 
	 obj.magnitud = listado1.extraeDato(codSeleccionados[0], 0); 
	 obj.unidMedOrigen = listado1.extraeDato(codSeleccionados[0], 1); 
	 obj.unidMedDestino = listado1.extraeDato(codSeleccionados[0], 2); 
	 obj.factorConversion = listado1.extraeDato(codSeleccionados[0], 3); 
	 obj.oidMagnitud = listado1.extraeDato(codSeleccionados[0], 4); 
	 obj.oidUnidMedOrigen = listado1.extraeDato(codSeleccionados[0], 5); 
	 obj.oidcbUnidMedDestino = listado1.extraeDato(codSeleccionados[0], 6); 
	 obj.opcionMenu = opcionMenu;
	 var retorno = mostrarModalSICC('LPMantenimientoFactoresConversion', accion, obj);
}
