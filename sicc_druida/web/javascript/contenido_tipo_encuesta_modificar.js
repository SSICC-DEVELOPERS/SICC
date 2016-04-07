function onLoadPag(){

	  fMostrarMensajeError();
	  configurarMenuSecundario('formulario');
	  focaliza('formulario.txtCodEncuesta');
	  DrdEnsanchaConMargenDcho('listado1',12);     
	  eval (ON_RSZ);
	  ocultaCapa();

}

function ocultaCapa(){

	  btnProxy(1,0); 
	  btnProxy(4,0);
	  document.all["Cplistado1"].style.visibility='hidden';
	  document.all["CpLin1listado1"].style.visibility='hidden';
	  document.all["CpLin2listado1"].style.visibility='hidden';
	  document.all["CpLin3listado1"].style.visibility='hidden';
	  document.all["CpLin4listado1"].style.visibility='hidden';
	  document.all["ava1Div"].style.visibility='hidden';
	  document.all["ret1Div"].style.visibility='hidden';
	  document.all["separaDiv"].style.visibility='hidden';
	  document.all["primera1Div"].style.visibility='hidden';
	  document.all["btnModificarDiv"].style.visibility='hidden';
	  document.all["btnDetalleDiv"].style.visibility='hidden';

}

function muestraCapa(){

	  document.all["Cplistado1"].style.visibility='';
	  document.all["CpLin1listado1"].style.visibility='';
	  document.all["CpLin2listado1"].style.visibility='';
	  document.all["CpLin3listado1"].style.visibility='';
	  document.all["CpLin4listado1"].style.visibility='';
	  document.all["ava1Div"].style.visibility='';
	  document.all["ret1Div"].style.visibility='';
	  document.all["separaDiv"].style.visibility='';
	  document.all["primera1Div"].style.visibility='';

	  var opcionMenu = get("formulario.opcionMenu");
	  if(opcionMenu == "consultar") {
			document.all["btnModificarDiv"].style.visibility='hidden';
			document.all["btnDetalleDiv"].style.visibility='';
	  }
	  else if(opcionMenu == "modificar") {
				
			document.all["btnModificarDiv"].style.visibility='';
			document.all["btnDetalleDiv"].style.visibility='hidden';
	  }
	  else if(opcionMenu == "eliminar") {
			document.all["btnModificarDiv"].style.visibility='hidden';
			document.all["btnDetalleDiv"].style.visibility='';
			btnProxy(4,1);
	  }

}
function fLimpiar(){
	  eval("formulario").oculto= "N"; 	
	  var oidMarca = new Array();
      ocultaCapa();

	  set('formulario.txtCodEncuesta', '');
	  set('formulario.txtDescripcion', '');
	  set('formulario.cbMarca', '');

}

function onClickBtnBuscar() {
         if(sicc_validaciones_generales()) {
          ocultaCapa();
          btnProxy(4,0);		 
          var arr = new Array();
          arr[arr.length] = new Array("oidPais", get("formulario.varPais")+"");
          arr[arr.length] = new Array("codTipoEncuesta", get("formulario.txtCodEncuesta")+"");
		  arr[arr.length] = new Array("oidMarca", get("formulario.cbMarca")+"");
          arr[arr.length] = new Array("descripcion", get("formulario.txtDescripcion")+"");
          
          configurarPaginado(mipgndo,"MAEBuscarEncuestaNSE","ConectorBuscarEncuestaNSE","es.indra.sicc.dtos.mae.DTOTipoEncuesta",arr);  
         }
}
function muestraLista(ultima, rowset) {

    var tamanio = rowset.length;

    if (tamanio > 0) {
        muestraCapa();
        return true;
   } else {
        ocultaCapa();
            GestionarMensaje('2596',null,null,null);
        return false;
   }
} 
function onClickBtnDetalle() {
          var opcionMenu = get('formulario.opcionMenu');
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

             
}
function onClickBtnModificar() {
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
          var valor =  asignarObjyMostrarModal(obj,listado1,codSeleccionados,opcionMenu,'modificar');
                   if(valor == true){

                           onClickBtnBuscar();
                   
                   }
                         
}
function asignarObjyMostrarModal(obj,listado1,codSeleccionados,opcionMenu,accion){

          obj.oidTipoEncuesta = codSeleccionados[0]; 
          obj.codEncuesta = listado1.extraeDato(codSeleccionados[0], 0); 
          obj.descripcion = listado1.extraeDato(codSeleccionados[0], 1); 
          obj.desMarca = listado1.extraeDato(codSeleccionados[0], 2); 
          obj.oidMarca = listado1.extraeDato(codSeleccionados[0], 3); 
          obj.opcionMenu = opcionMenu;
          return mostrarModalSICC('LPMantenimientoTipoEncuesta', accion, obj);
}
function fBorrar(){
          
          var codSeleccionados = listado1.codSeleccionados();
          
          if (codSeleccionados.length == 0){
                    GestionarMensaje('1021',null,null,null);
                    return false;
          }
          else {
                    listado1.actualizaDat();
                    datos = listado1.datos;
                    
                    if ( codSeleccionados.length < 1){
                              GestionarMensaje('4');
                              return;
                    }

                    var arrOids = new Array();
                    for(var i = 0; i < codSeleccionados.length; i++){
                         var oidGaraProd = codSeleccionados[i];
                         arrOids[arrOids.length] = oidGaraProd;

                    }
              eliminarFilas(arrOids,"MAEEliminarEncuestaNSE", mipgndo);
          }

}
