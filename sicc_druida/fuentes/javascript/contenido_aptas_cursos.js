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
    $Id: contenido_aptas_cursos.js,v 1.1 2009/12/03 19:01:32 pecbazalar Exp $
    DESC
*/
var FORMULARIO = "formulario";

function onLoadPag(){ 
       
      configurarMenuSecundario(FORMULARIO);
      if (get(FORMULARIO+'.indOrigen') == 2){
    		btnProxy(1, 0); 
      }else{
      		btnProxy(1, 1); 
      }
      var errDescripcion = get(FORMULARIO +'.errDescripcion');
      if (errDescripcion !='') {		
			var errCodigo = get(FORMULARIO+'.errCodigo');
			var wnd = fMostrarMensajeError(errCodigo, errDescripcion);
      }
      
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
      document.all["SeleccionarNoAsistentesDiv"].style.visibility='';     
      document.all["EliminarDiv"].style.visibility='';     
      eval (ON_RSZ); 
	  if (!(errDescripcion !='')) {
	      configurarPaginado(mipgndo, "EDUBusquedaAptasCurso", "ConectorConsultaAptasCurso", "es.indra.sicc.dtos.edu.DTOOIDApta", [ ["oid", get(FORMULARIO+'.oidAsigna')], ["oidIdioma", get(FORMULARIO+'.idioma')], ["oidPais", get(FORMULARIO+'.pais')] ] );
	  }
      document.all['SeleccionarNoAsistentes'].focus();
      
}

function muestraLista( ultima, rowset){
          var tamano = rowset.length;
          if (tamano > 0) {
                    //visibleLista();
                    return true;
          } else {
                    //invisibleLista();            
                    return false;
          }
}

function visibleLista() {
          if (!get_visibilidad('capaLista')){
                    visibilidad('capaLista','V');
          }
}

function invisibleLista() {
          if (get_visibilidad('capaLista')){
                    visibilidad('capaLista','O');
          }
}   

function onClickConvocatoria(){            
         var objParams = new Object();
         //Modal -> LPSegundaConvocatoria con: accion = "" oid = oidAsigna 
         objParams.oidAsigna = get(FORMULARIO+'.oidAsigna');
         
         objParams.oidMarca = get(FORMULARIO+'.marca');
         objParams.oidCanal = get(FORMULARIO+'.canal');

         mostrarModalSICC("LPSegundaConvocatoria","", objParams, null, null);
         //Se refresca la lista lstParticipantes
         //listado1.reajusta();
         configurarPaginado(mipgndo, "EDUBusquedaAptasCurso", "ConectorConsultaAptasCurso", "es.indra.sicc.dtos.edu.DTOOIDApta", [ ["oid", get(FORMULARIO+'.oidAsigna')], ["oidIdioma", get(FORMULARIO+'.idioma')], ["oidPais", get(FORMULARIO+'.pais')] ] );
}

function onClickEliminar(){            
         set(FORMULARIO+'.accion','Eliminar');
         set(FORMULARIO+'.conectorAction','LPAptas');         
         set(FORMULARIO+'.valoresLista',listado1.codSeleccionados());
         enviaSICC(FORMULARIO);
		
         //var oids = listado1.codSeleccionados();
         //eliminarFilas(oids,"EDUBusquedaAptasCurso",mipgndo);
         //configurarPaginado(mipgndo, "EDUBusquedaAptasCurso", "ConectorConsultaAptasCurso", "es.indra.sicc.dtos.edu.DTOOIDApta", [ ["oid", get(FORMULARIO+'.oidAsigna')], ["oidIdioma", get(FORMULARIO+'.idioma')], ["oidPais", get(FORMULARIO+'.pais')] ] );
         //listado1.reajusta();
}

function fGuardar(){
         onClickGuardar();
}

function onClickGuardar(){            
         set(FORMULARIO+'.accion','Guardar');
         set(FORMULARIO+'.conectorAction','LPAptas');
         enviaSICC(FORMULARIO);
         //configurarPaginado(mipgndo, "EDUBusquedaAptasCurso", "ConectorConsultaAptasCurso", "es.indra.sicc.dtos.edu.DTOOIDApta", [ ["oid", get(FORMULARIO+'.oidAsigna')], ["oidIdioma", get(FORMULARIO+'.idioma')], ["oidPais", get(FORMULARIO+'.pais')] ] );
         //listado1.reajusta();
}

function refrescarLista(){ 
	  if (get(FORMULARIO+'.indOrigen') == 2){
    		btnProxy(1, 0); 
      }else{
      		btnProxy(1, 1); 
      }
	configurarPaginado(mipgndo, "EDUBusquedaAptasCurso", "ConectorConsultaAptasCurso", "es.indra.sicc.dtos.edu.DTOOIDApta", [ ["oid", get(FORMULARIO+'.oidAsigna')], ["oidIdioma", get(FORMULARIO+'.idioma')], ["oidPais", get(FORMULARIO+'.pais')] ] );


}

function inserccionCorrecta(){  
	window.close();
}

function fVolver(){
         window.close();	
}
