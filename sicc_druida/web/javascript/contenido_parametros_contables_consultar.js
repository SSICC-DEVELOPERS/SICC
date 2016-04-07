/**
* Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
    $Id: contenido_parametros_contables_consultar.js,v 1.1 2009/12/03 19:01:41 pecbazalar Exp $
    DESC
*/

//Funcion que se ejecuta al cargar la pagina

function onLoadPag(){
                      
         if (get('formulario.hCbProceso') == "N") {
             accion('formulario.cbProceso','.disabled=true');             
    }
    if (get('formulario.hCbSubprocesoContable') == "N") {
           accion('formulario.cbSubprocesoContable','.disabled=true');             
    }
    if (get('formulario.hRbDebeHaber') == "N") {
            accion('formulario.rbDebeHaber','.disabled=true');             
    }
    if (get('formulario.hCbObtencionCuenta') == "N") {
           accion('formulario.cbObtencionCuenta','.disabled=true');             
    }
    if (get('formulario.hCbCuentaDirecta') == "N") {
           accion('formulario.cbCuentaDirecta','.disabled=true');             
    }
         if (get('formulario.hTxtTextoApunte') == "N") {
           accion('formulario.txtTextoApunte','.disabled=true');             
    }
         
         configurarMenuSecundario("formulario");
    DrdEnsanchaConMargenDcho('listado1',12);
          
    ocultaCapas();
    eval (ON_RSZ);  

    focaliza('formulario.cbProceso');
}

function ocultaCapas(){

         document.all["Cplistado1"].style.visibility='hidden';
         document.all["CpLin1listado1"].style.visibility='hidden';
         document.all["CpLin2listado1"].style.visibility='hidden';
         document.all["CpLin3listado1"].style.visibility='hidden';
         document.all["CpLin4listado1"].style.visibility='hidden';	    
         document.all["primera1Div"].style.visibility='hidden';
         document.all["ret1Div"].style.visibility='hidden';
         document.all["ava1Div"].style.visibility='hidden';
         document.all["separaDiv"].style.visibility='hidden';
         document.all["btnDetalleDiv"].style.visibility='hidden';
         document.all["btnModificarDiv"].style.visibility='hidden';
         document.all["btnEliminarDiv"].style.visibility='hidden';

}

function muestraCapas(){
                  document.all["Cplistado1"].style.visibility='';
                  document.all["CpLin1listado1"].style.visibility='';
                  document.all["CpLin2listado1"].style.visibility='';
                  document.all["CpLin3listado1"].style.visibility='';
                  document.all["CpLin4listado1"].style.visibility='';
                  document.all["primera1Div"].style.visibility='';
                  document.all["ret1Div"].style.visibility='';
                  document.all["ava1Div"].style.visibility='';
                  document.all["separaDiv"].style.visibility='';
                  
}
  
function onChangeProceso() {

           if (get('formulario.cbProceso')!='') {
                  var paramDTO = new Array();
                  paramDTO[0] = ["oidPais",get('formulario.pais')];
                  paramDTO[1] = ["oidIdioma",get('formulario.idioma')];      
                  paramDTO[2] = ["oid",get('formulario.cbProceso')];
                  recargaCombo("formulario.cbSubprocesoContable","CCCObtenerSubProcesosPorProceso","es.indra.sicc.util.DTOOID",paramDTO);
         } else {
                  set_combo('formulario.cbSubprocesoContable',['','']);
         }	  
}

function accionBuscar() {
          
         //if ( sicc_validaciones_generales() ) {
         configurarPaginado(mipgndo,"CCCBuscarParametrosContables","ConectorBuscarParametrosContables","es.indra.sicc.dtos.ccc.DTOParametrosContables",obtenerArrayDeParametros());
         //}
}

function obtenerArrayDeParametros(){
//obtiene los datos seleccionados en los combos, parametros del DTO

      var arrayParam = new Array();
      var i=0;

      arrayParam[i] = new Array('oidPais',get('formulario.pais'));
      i++;
           
      arrayParam[i] = new Array('oidIdioma',get('formulario.idioma'));
      i++;          

      if (get('formulario.cbProceso')!=''){
           arrayParam[i] = new Array('proceso',get('formulario.cbProceso'));
           i++;
      }
      if (get('formulario.cbSubprocesoContable')!=''){
             arrayParam[i] = new Array('subProceso',get('formulario.cbSubprocesoContable'));
             i++;
      }
          /*
      if (get('formulario.debeHaber')!=''){
             arrayParam[i] = new Array('indicativoDebeHaber',get('formulario.debeHaber'));
             i++;
      }
          */
           if (get('formulario.rbDebeHaber')!=''){
             
                           var indicativoDH = get('formulario.rbDebeHaber');
                           

                           if(indicativoDH == '1'){
                                    arrayParam[i] = new Array('indicativoDebeHaber','D');
                                    i++;
                           }else{
                                    arrayParam[i] = new Array('indicativoDebeHaber','H');
                                    i++;
                           }
      }
           
//         alert("datos cargados en arrayParam " + arrayParam);

      return arrayParam;      
}

function muestraLista(ultima, rowset) {
    var tamano = rowset.length;
                  /*cambiarListadoValores(rowset);*/
         
         if (tamano > 0) {
            visualizarLista();
            return true;
    } else {

            ocultarLista();
            return false;

            // No se ha encontrado ningún elemento con los criterios especificados

            //focaliza("frmClientesAnteriores.txtClienteNuevo");            
                  }
 
}

function ocultarLista() {
           document.all["Cplistado1"].style.visibility='hidden';
           document.all["CpLin1listado1"].style.visibility='hidden';
           document.all["CpLin2listado1"].style.visibility='hidden';
           document.all["CpLin3listado1"].style.visibility='hidden';
           document.all["CpLin4listado1"].style.visibility='hidden';
           document.all["primera1Div"].style.visibility='hidden';
           document.all["ret1Div"].style.visibility='hidden';
           document.all["ava1Div"].style.visibility='hidden';
           document.all["separaDiv"].style.visibility='hidden';
  
           document.all["btnDetalleDiv"].style.visibility='hidden';
           document.all["btnModificarDiv"].style.visibility='hidden';           
           document.all["btnEliminarDiv"].style.visibility='hidden';

           eval (ON_RSZ);
         }


function visualizarLista() {
         DrdEnsanchaConMargenDcho('listado1',12);

         document.all["Cplistado1"].style.visibility='';
         document.all["CpLin1listado1"].style.visibility='';
         document.all["CpLin2listado1"].style.visibility='';
         document.all["CpLin3listado1"].style.visibility='';
         document.all["CpLin4listado1"].style.visibility='';

         document.all["primera1Div"].style.visibility='';
         document.all["ret1Div"].style.visibility='';
         document.all["ava1Div"].style.visibility='';
         document.all["separaDiv"].style.visibility='';
                  
                  if (get('formulario.opcionMenu')=='ConsultarParametrosContables'){ // Para "consultar"
            document.all["btnModificarDiv"].style.visibility='hidden';
            document.all["btnDetalleDiv"].style.visibility='visible';
                 document.all["btnEliminarDiv"].style.visibility='hidden';
             }
                  if (get('formulario.opcionMenu')=='ModificarParametrosContables'){ // Para "modificar"
                     document.all["btnModificarDiv"].style.visibility='visible';
            document.all["btnDetalleDiv"].style.visibility='hidden';
                     document.all["btnEliminarDiv"].style.visibility='hidden';
                  }
                  if (get('formulario.opcionMenu')=='EliminarParametrosContables'){ // Para "eliminar"
                     document.all["btnModificarDiv"].style.visibility='hidden';
            document.all["btnDetalleDiv"].style.visibility='hidden';
                     document.all["btnEliminarDiv"].style.visibility='visible';
                  }
                  
         eval (ON_RSZ);
}

function accionDetalle(){
//Muestra la ventana modal y emergente PGInsertarParametrosContables 
//Comprueba si se ha seleccionado un solo elemento de la lista resultado 
//Si ha seleccionado un solo elemento, activa la LPMantenimientoParametrosContables con: 
//- opcionMenu 
//- accion = "detalle"

           var seleccionados = new Array();
      seleccionados = listado1.codSeleccionados();
      var cantSeleccionados = seleccionados.length;
      var posicion = obtenerPosicionListaEditable(listado1.codSeleccionados(),listado1);

           if (cantSeleccionados == 1) {
           var obj = new Object();
           obj.oidParametroContable = seleccionados[0];
                    obj.opcionMenu = get('formulario.opcionMenu');

           mostrarModalSICC('LPMantenimientoParametrosContables',"detalle",obj,750,350);
      } else    {
           GestionarMensaje('50');
      }

}

function accionModificar(){
// Muestra la ventana modal y emergente PGInsertarParametrosContables 
//Comprueba si se ha seleccionado un solo elemento de la lista resultado 
           
           var seleccionados = new Array();
           seleccionados = listado1.codSeleccionados();
      var cantSeleccionados = seleccionados.length;
            
      if (cantSeleccionados == 1) {
            var obj = new Object();
            obj.oidParametroContable = seleccionados[0];
            obj.opcionMenu = get('formulario.opcionMenu');

                     // Se bloquea la ejecución hasta el cierre de la ventana emergente 
                     mostrarModalSICC('LPMantenimientoParametrosContables',"modificar",obj,750,350);          

                     //Refrescar la lista paginada de resultados para que se muestren las modificaciones realizadas		   
                     accionBuscar(); 
      }else{
            GestionarMensaje('50');
      } 

 }

function accionEliminar(){
//Comprueba que hay, al menos, un elemento seleccionado en la lista resultados 
//Si hay algún valor seleccionado { 
//DTOOIDs = Se crea un DTOOIDs con los oids de las filas seleccionadas 

//Llamamos a eliminarFilas y le pasamos: 
//- idBusiness = "CCCEliminarParametrosContables" 
//- DTOOIDs 
//- El objeto paginado (lstResultado). }

           var seleccionados = listado1.codSeleccionados();      
      var cantSeleccionados = seleccionados.length;
           var oids =  new Array();
      
//            alert("Se van a Eliminar "+cantSeleccionados);
      if (cantSeleccionados == 0){
           GestionarMensaje("4", null, null, null);      
           return;
      }
      
      for (var i = 0; i < seleccionados.length; i++)
      {                 
                  
                   //oids[i] = listado1.extraeDato(seleccionados[i], 6); 
                   oids[i]  = seleccionados[i];
           }
//      alert("Se Elimina "+oids);
      
      if (cantSeleccionados > 0) {
           eliminarFilas(oids, "CCCEliminarParametrosContables", mipgndo);
          /*listado1.eliminarSelecc();*/
      }
}

function fLimpiar() {
         limpiar();
}

function limpiar() {
         ocultaCapas();
         set('formulario.cbProceso','');
         set_combo('formulario.cbSubprocesoContable',['','']);
         document.all.rbDebeHaber[0].checked=false;
         document.all.rbDebeHaber[1].checked=false;
}

//ON_TAB
function onTab_btnBuscar(){
   
   if(document.all["Cplistado1"].style.visibility == 'hidden') {
         focaliza('formulario.cbProceso');
   }else {
     if(get('formulario.opcionMenu').toString() == "ConsultarParametrosContables")      
         focalizaBotonHTML('botonContenido','btnDetalle');     
         
          if(get('formulario.opcionMenu').toString() == "ModificarParametrosContables")     	
         focalizaBotonHTML('botonContenido','btnModificar');     
          
          if(get('formulario.opcionMenu').toString() == "EliminarParametrosContables")     	
         focalizaBotonHTML('botonContenido','btnEliminar');
   }
}

function onTab_btnDetalle(){
          focaliza('formulario.cbProceso');  
}

function onTab_btnEliminar(){
          focaliza('formulario.cbProceso');  
}
function onTab_btnModificar(){
          focaliza('formulario.cbProceso');  
}


//ON_SH_TAB
function onshTab_cbProceso(){
   
   if(document.all["Cplistado1"].style.visibility == 'hidden') {
         focalizaBotonHTML('botonContenido','btnBuscar');

   }else {
     if(get('formulario.opcionMenu').toString() == "ConsultarParametrosContables")      
         focalizaBotonHTML('botonContenido','btnDetalle');     
         
          if(get('formulario.opcionMenu').toString() == "ModificarParametrosContables")     	
         focalizaBotonHTML('botonContenido','btnModificar');     
          
          if(get('formulario.opcionMenu').toString() == "EliminarParametrosContables")     	
         focalizaBotonHTML('botonContenido','btnEliminar');
   }

}

function onshTab_btnBuscar(){
   
   if(document.all["Cplistado1"].style.visibility == 'hidden') {
         focaliza('formulario.cbProceso');
   }
}

function onshTab_btnDetalle(){
         focalizaBotonHTML('botonContenido','btnBuscar');
}

function onshTab_btnEliminar(){
         focalizaBotonHTML('botonContenido','btnBuscar');
}
function onshTab_btnModificar(){
         focalizaBotonHTML('botonContenido','btnBuscar');
}

