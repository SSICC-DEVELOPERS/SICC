function onLoad() {
  ocultarLista();
  configurarMenuSecundario('formulario');
  var acc = get('formulario.accion');
  var opcionMenu = get('formulario.opcionMenu');
  var oidCentroVD = get('formulario.centroDistribucionVD');
  set('formulario.cbCentroDistribucion', [get('formulario.centroDistribucionVD')]);
  if (oidCentroVD!=''){
    onChangeCbCentroDistribucion();    
  }
  focaliza('formulario.cbCentroDistribucion');
}

//--------------------------------------------------------------------------------------------------------

function onChangeCbCentroDistribucion() {
         var oidCentro = get('formulario.cbCentroDistribucion', 'V');
         if (oidCentro != '') {
                  var array = new Array();
                  array[0] = new Array('oid',oidCentro);
                  array[1] = new Array('oidIdioma',get('formulario.varIdioma'));
                  recargaCombo('formulario.cbLineaArmado',
                                             'APEObtenerLineasArmadoCD',
                                             'es.indra.sicc.util.DTOOID',
                                             array,
                                             'setearCbLineaArmado(datos)');
         } else {
                  set_combo('formulario.cbLineaArmado', new Array(['','']));
         }
         set('formulario.hOidCentroAnterior', oidCentro);
}

function obtenerLineaDef(datos){ 
   valoresLineasDef = get('formulario.hCbLineasCDDef').split(","); 
   //alert("valoresLineasDef: " + valoresLineasDef); 
   if(datos != "" && valoresLineasDef != ""){ 
    
        for(i = 0; i < datos.length; i++){ 
          oidLinea = datos[i][0]; 
          for(j = 0; j < valoresLineasDef.length; j++){   
            if(valoresLineasDef[j]==oidLinea){ 
                 return oidLinea; 
            } 
          } 
        }  
        return ""; 
         
   } else { 
        return ""; 
   } 
} 

function setearCbLineaArmado(datos) {
    lineaDef = obtenerLineaDef(datos);
    
    var arrayNuevo = new Array();
    arrayNuevo[0] = new Array('','');
    arrayNuevo = arrayNuevo.concat(datos);
    set_combo('formulario.cbLineaArmado',arrayNuevo);
    set('formulario.cbLineaArmado', [lineaDef]);
}

//--------------------------------------------------------------------------------------------------------

function onClickBuscar() {
  var parametros = new Array();
  parametros[parametros.length] = new Array('oidIdioma', get('formulario.varIdioma'));
  parametros[parametros.length] = new Array('oidPais', get('formulario.varPais'));

  var centroDistribucion = get('formulario.cbCentroDistribucion','V');
  if (centroDistribucion != ''){
    parametros[parametros.length] = new Array('oidCentroDistribucion', centroDistribucion);
  }
  var lineaArmado = get('formulario.cbLineaArmado','V');
  if (lineaArmado != ''){
    parametros[parametros.length] = new Array('oidLineaArmado', lineaArmado);
  }
  
  var codigoAgrupacion = get('formulario.txtCodigoAgrupacion');
  if (codigoAgrupacion != ''){
    parametros[parametros.length] = new Array('codAgrupacion', codigoAgrupacion);
  }  
  
  configurarPaginado(mipgndo,
                      'APEConsultarParamBalanceoAreaChequeo',
                      'ConectorConsultarParamBalanceoAreaChequeo',
                      'es.indra.sicc.dtos.ape.DTOParamBalanceoAreaChequeo',
                      parametros);
  //mostrarLista();
}

//--------------------------------------------------------------------------------------------------------

function muestraLista(ultima, rowset) {
         var tamano = rowset.length;
         if (tamano > 0) {
                  mostrarLista();
                  return true; 
         }else{
                  ocultarLista();
                  focaliza('formulario.cbCentroDistribucion');
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
         if (opcionMenu == 'modificar') {
                  document.all["ModificarDiv"].style.visibility='visible';
         } else if (opcionMenu = 'consultar' || opcionMenu == 'eliminar') {
                  document.all["DetalleDiv"].style.visibility='visible';
         }
         if (get('formulario.opcionMenu')=='eliminar') {
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
    document.all["DetalleDiv"].style.visibility='hidden';
    document.all["ModificarDiv"].style.visibility='hidden';
    btnProxy(4,0);
}

//-------------------------------------------------------------------------------------

function onClickModificar() {
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
         codSeleccionados = listado1.codSeleccionados();
         if (codSeleccionados.length > 1) {
                  GestionarMensaje('1022');
         return;
         }
         if ( codSeleccionados.length < 1) {
                  GestionarMensaje('4');
         return;
         }
         // Obtengo el índice de la fila marcada (en este punto, solo una estará marcada)
		 asignarObjyMostrarModal(obj,listado1,codSeleccionados,opcionMenu,'modificar');
         //var filaMarcada = listado1.filaSelecc;
         // Seteo los valores obtenidos. 
         /*obj.oidParametros = datos[filaMarcada][1];
         obj.oidCentroDistribucion = datos[filaMarcada][2];
         obj.centroDistribucion = datos[filaMarcada][3];
         obj.oidLineaArmado = datos[filaMarcada][4];
         obj.lineaArmado = datos[filaMarcada][5];
         obj.pedidosArmadoHoras = datos[filaMarcada][8];
         obj.unidadesChequeoHoraPersona = datos[filaMarcada][9];
         obj.parametroDistribucion = datos[filaMarcada][10];
         obj.opcionMenu = opcionMenu;
         var retorno = mostrarModalSICC('LPMantenerParamBalanceoAreaChequeo', 'modificar', obj);*/
         onClickBuscar();
}

//--------------------------------------------------------------------------------------------------------

function onClickDetalle() {
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
         codSeleccionados = listado1.codSeleccionados();

         if (codSeleccionados.length > 1) {
                  GestionarMensaje('1022');
         return;
         }

         if ( codSeleccionados.length < 1) {
                  GestionarMensaje('4');
         return;
         }
		 asignarObjyMostrarModal(obj,listado1,codSeleccionados,opcionMenu,'detalle');
         // Obtengo el índice de la fila marcada (en este punto, solo una estará marcada)
         //var filaMarcada = listado1.filaSelecc;
         // Seteo los valores obtenidos. 
         /*obj.oidParametros = datos[filaMarcada][1];
         obj.oidCentroDistribucion = datos[filaMarcada][2];
         obj.centroDistribucion = datos[filaMarcada][3];
         obj.oidLineaArmado = datos[filaMarcada][4];
         obj.lineaArmado = datos[filaMarcada][5];
         obj.pedidosArmadoHoras = datos[filaMarcada][8];
         obj.unidadesChequeoHoraPersona = datos[filaMarcada][9];
         obj.parametroDistribucion = datos[filaMarcada][10];
         obj.opcionMenu = opcionMenu;
         var retorno = mostrarModalSICC('LPMantenerParamBalanceoAreaChequeo', 'detalle', obj);*/
         //onClickBuscar();
}

//--------------------------------------------------------------------------------------------------------

function onClickEliminar() {
         if (listado1.numSelecc()== 0) {
                  GestionarMensaje('1021');
         return false;
    }
         else {
			 // Para que solo permita escoger un solo registro 
			 listado1.actualizaDat();
			 datos = listado1.datos;
			 var codSeleccionados = listado1.codSeleccionados();
			 /*	VALIDAR QUE SOLO ELIJA UNO */
			 /*if (codSeleccionados.length > 1) {
					  GestionarMensaje('8');
			 return;
			 }*/
			 /*	VALIDAR QUE AL MENOS ELIJA UNO */
			 if ( codSeleccionados.length < 1) {
					  GestionarMensaje('4');
			 return;
			 }
			
			var detallesEliminados = "";
			for (var i=0; i<codSeleccionados.length ; i++){   
				if(listado1.extraeDato(codSeleccionados[i], 1)!="BLANCO") {
					if(detallesEliminados==""){
					   detallesEliminados = detallesEliminados + listado1.extraeDato(codSeleccionados[i], 0); 
					} else {
					   detallesEliminados = detallesEliminados + "," + listado1.extraeDato(codSeleccionados[i], 0); 
					}
				}
			}
			//alert("detallesEliminados: " + detallesEliminados);
			var oidsSeleccionados = new Array();
			oidsSeleccionados = detallesEliminados.split(",")
			//alert("oidsSeleccionados: " + oidsSeleccionados);
			eliminarFilas(oidsSeleccionados,"APEEliminarParamBalanceoAreaChequeo", mipgndo);
         }
}

//--------------------------------------------------------------------------------------------------------

function fLimpiar() {
}

//--------------------------------------------------------------------------------------------------------

function fBorrar() {
         onClickEliminar();
}

function asignarObjyMostrarModal(obj,listado1,codSeleccionados,opcionMenu,accion){
	 obj.oidParametros = listado1.extraeDato(codSeleccionados[0], 0)//codSeleccionados[0];	
	 obj.oidCentroDistribucion = listado1.extraeDato(codSeleccionados[0], 1); 
	 obj.centroDistribucion = listado1.extraeDato(codSeleccionados[0], 2); 
	 obj.oidLineaArmado = listado1.extraeDato(codSeleccionados[0], 3); 
	 obj.lineaArmado = listado1.extraeDato(codSeleccionados[0], 4); 
	 obj.pedidosArmadoHoras = listado1.extraeDato(codSeleccionados[0], 8); 
	 obj.unidadesChequeoHoraPersona = listado1.extraeDato(codSeleccionados[0], 9); 
	 obj.parametroDistribucion = listado1.extraeDato(codSeleccionados[0], 10); 
	 obj.codAgrupacion = listado1.extraeDato(codSeleccionados[0], 6); 
	 obj.horaDias = listado1.extraeDato(codSeleccionados[0], 11); 

	 obj.opcionMenu = opcionMenu;
	 var retorno = mostrarModalSICC('LPMantenerParamBalanceoAreaChequeo', accion, obj);
	 /*obj.oidParametros = datos[filaMarcada][1];
	 obj.oidCentroDistribucion = datos[filaMarcada][2];
	 obj.centroDistribucion = datos[filaMarcada][3];
	 obj.oidLineaArmado = datos[filaMarcada][4];
	 obj.lineaArmado = datos[filaMarcada][5];
	 obj.pedidosArmadoHoras = datos[filaMarcada][8];
	 obj.unidadesChequeoHoraPersona = datos[filaMarcada][9];
	 obj.parametroDistribucion = datos[filaMarcada][10];
	 obj.opcionMenu = opcionMenu;
	 var retorno = mostrarModalSICC('LPMantenerParamBalanceoAreaChequeo', 'detalle', obj);*/
}

/*
 * Deshabilita el botón avance en caso de que la pagina actual este completa
 * y no queden mas datos por mostrar, evitando los carteles de error que aparecerian
 */
function asignarEstadoBotonAvance() {
	var primeraLineaLista = listado1.datos[0];
	if(primeraLineaLista){
		var esUltimaPagina = primeraLineaLista[primeraLineaLista.length - 1];
		if (esUltimaPagina == '1') {
			// Deshabilito el botón Avance
			mipgndo.ava.setTipo(0);
		}
	}
}
