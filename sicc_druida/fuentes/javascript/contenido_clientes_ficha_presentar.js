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

var FORMULARIO = 'formulario';
var cargado = false;
var arrNombres=new Array("cbdtTipoCliente","cbdtSubTipoCliente","cbdtTipoClasificacion","cbdtClasificacion");

function onLoadPag(){
         
         if (get(FORMULARIO + '.errDescripcion')!='') {                         
                var wnd = fMostrarMensajeError(get(FORMULARIO+'.errCodigo'),get(FORMULARIO+'.errDescripcion'));
                window.close();
         }	
         cargado = true;	
         
         DrdEnsanchaConMargenDcho('listado1',12);
         
         DrdEnsanchaConMargenDcho('listado2',12);
         DrdEnsanchaConMargenDcho('listado5',12);
         eval (ON_RSZ);
         
         if (get(FORMULARIO + '.activaBtActualiza') != "S") {
                  document.all['btnActualizarEstadoContacto'].disabled = true;
         }
         if (get(FORMULARIO + '.activaBtBloqueo') != "S") {
                  document.all['btnRealizarBloqueoAdministrativo'].disabled = true;
         }
         configurarMenuSecundario(FORMULARIO);
         /*
         Llamamos a configurarPaginado pasándole los siguientes parametros: 
         
         - Objeto paginado (lstContactos) 
         - idBusiness ("CALObtenerContactos") 
         - "ConectorObtenerContactos" 
         - "DTOOID" 
         - Parametros del DTO: 
         - pais activo 
         - idioma activo 
         - oidCliente*/
         recargaContactos();
		
         //document.anchors[0].focus();
         //focalizaPrimeroEnLista(listado1);
         //document.all['btnRealizarBloqueoAdministrativo'].focus();

}


function fnTipificacion(numero){
         seleccionarValores(numero, buscarSeleccionados(buscarObj(numero)));
}

function buscarObj(numero){return document.all.tags("SELECT")[numero];}

function buscarSeleccionados(objCombo){
         if(!objCombo){return;}
         var arrTextos = new Array();
         var arrValores = new Array();
         for(var i=0; i< objCombo.options.length; i++){
                  var optionActual = objCombo.options[i];
                  if(optionActual && optionActual.selected){
                           arrTextos[arrTextos.length] = optionActual.text;
                           arrValores[arrValores.length] = optionActual.value;
                  }
         }
         return new Array(arrTextos,arrValores);
}
function seleccionarValores(comboOrigen, valores){
         if(!valores){return;}
         var arrSelec = null;
         if(comboOrigen > 0){
                  arrSelec = valores[1] ;
                  for(var comboActual = comboOrigen-1;comboActual >=0;comboActual--){
                           marcarPadres(comboActual, arrSelec);
                           arrSelec = buscarSeleccionados(buscarObj(comboActual))[1]
                  }
         }
         if(comboOrigen<3){
                  arrSelec = valores[0];
                  for(var comboActual = comboOrigen+1;comboActual <=3;comboActual++){
                           marcarHijos(comboActual, arrSelec);
                           arrSelec = buscarSeleccionados(buscarObj(comboActual))[0]
                  }

         }
}

function marcarPadres(comboNumero, valores){
         var objCombo = buscarObj(comboNumero);
         if(!objCombo){return;}
         //Limpiamos el combo que vamos a trabajar
         limpiarCombo(objCombo);
         //este es padre del que genero el array de entrada,
         //por ende, usamos los textos para comparar.
         for(var n=0; n<valores.length;n++ ){	
                  for(var i=0; i< objCombo.options.length; i++){
                           if(objCombo.options[i].text==valores[n]){
                                    objCombo.options[i].selected=true;
                           }
                  }
         }

}
function marcarHijos(comboNumero, valores){
         var objCombo = buscarObj(comboNumero);
         if(!objCombo){return;}
         //Limpiamos el combo que vamos a trabajar
         limpiarCombo(objCombo);
         //este es hijo del que genero el array de entrada,
         //por ende, usamos los textos para comparar.
         for(var n=0; n<valores.length;n++ ){	
                  for(var i=0; i< objCombo.options.length; i++){
                           if(objCombo.options[i].value==valores[n]){
                                    objCombo.options[i].selected=true;
                           }
                  }
         }
}

function limpiarCombo(objCombo){
         for(var i=0; i<objCombo.options.length; i++ ){
                  objCombo.options[i].selected=false;
         }
}
function muestraLista( ultima, rowset){
                  DrdEnsanchaConMargenDcho('listado3',12);
                  document.all["Cplistado3"].style.visibility='visible';
                  document.all["CpLin1listado3"].style.visibility='visible';
                  document.all["CpLin2listado3"].style.visibility='visible';
                  document.all["CpLin3listado3"].style.visibility='visible';
                  document.all["CpLin4listado3"].style.visibility='visible';
                  document.all["primera3Div"].style.visibility='visible';
                  document.all["ret3Div"].style.visibility='visible';
                  document.all["ava3Div"].style.visibility='visible';
                  document.all["separa3Div"].style.visibility='visible';
                  eval (ON_RSZ);  
                  //si no se comenta esto, hay error de java script cuando la lista editable tiene una sola pagina
                  //setTimeout("document.all['btnRealizarBloqueoAdministrativo'].focus()", 500);
                  return true;
         }


function accionBloqueoAdministrativo(){
         /* Envia el formulario oculto 
         formulario.oculto = "S" 
         enviaSICC(formulario) 
         
         Llamar a la LPPresentarClientes con los siguientes parámetros: 
         accion = "Bloqueo" 
         pais = pais activo 
         oidCliente*/
         
         formulario.oculto = "S";
         set(FORMULARIO + '.accion', 'Bloqueo');
         set(FORMULARIO + '.conectorAction', 'LPPresentarClientes');
         enviaSICC(FORMULARIO);
         
}

function procesarBloqueo(oidCliente){
         var objParams = new Object();
         objParams.casoDeUso = get(FORMULARIO + '.casoDeUso');
         objParams.oidCliente = oidCliente;
         mostrarModalSICC('LPPresentarClientes', 'Procesar Bloqueo', objParams, null, null);
}

function accionFicha() {
    // No realizar nada pues ya estamos en la pestanya Ficha
}

function accionContactos(){
         /*
         Llamar a la LPGestionarContactos con: 
         accion = "" 
         oidCliente 
         oidTipoCliente 
         oidSubtipoCliente 
         indConsultoraInterna*/
         formulario.oculto = 'N';	
         set(FORMULARIO + '.accion','');
         set(FORMULARIO + '.conectorAction', 'LPGestionarContactos');
         enviaSICC(FORMULARIO);	
         
}

function accionCuentasCorrientes(){
         /*
         Llamar a la LPPresentarClientes con: 
         accion = "Cuentas corrientes" 
         pais activo 
         oidCliente 
         oidTipoCliente 
         oidSubtipoCliente 
         indConsultoraInterna*/
         formulario.oculto = 'N';
         set(FORMULARIO + '.accion','Cuentas corrientes');
         set(FORMULARIO + '.conectorAction', 'LPPresentarClientes');
         enviaSICC(FORMULARIO);
         
}

function accionPedidos(){
         /*
         Llamar a la LPPresentarClientes con: 
         accion = "Pedidos" 
         pais activo 
         oidCliente 
         oidTipoCliente 
         oidSubtipoCliente 
         indConsultoraInterna	*/
         formulario.oculto = 'N';
         set(FORMULARIO+'.accion','Pedidos');
         set(FORMULARIO+'.conectorAction','LPPresentarClientes');
         enviaSICC(FORMULARIO);
}

function accionVinculos(){
         /*
         Llamar a la LPPresentarClientes con: 
         accion = "Vinculos" 
         pais activo 
         oidCliente 
         oidTipoCliente 
         oidSubtipoCliente 
         indConsultoraInterna*/	
         formulario.oculto = 'N';
         set(FORMULARIO+'.accion','Vinculos');
         set(FORMULARIO+'.conectorAction','LPPresentarClientes');
         enviaSICC(FORMULARIO);	 
}

function accionDocumentos(){
         /*
         Llamar a la LPPresentarClientes con: 
         accion = "Documentos" 
         pais activo 
         oidCliente 
         oidTipoCliente 
         oidSubtipoCliente 
         indConsultoraInterna*/
         formulario.oculto = 'N';
         set(FORMULARIO+'.accion','Documentos');
         set(FORMULARIO+'.conectorAction','LPPresentarClientes');
         enviaSICC(FORMULARIO);
}

function accionDireccion (){
         /*
         Llamar a la LPPresentarClientes con: 
         accion = "Direccion" 
         pais activo 
         oidCliente 
         oidTipoCliente 
         oidSubtipoCliente 
         indConsultoraInterna*/
         formulario.oculto = 'N';
         set(FORMULARIO+'.accion','Direccion');
         set(FORMULARIO+'.conectorAction','LPPresentarClientes');
         enviaSICC(FORMULARIO);
}

         function accionActualizarEstadoContacto(){
                  /*Si !indConsultoraInterna 
                  Llamar a la LPPresentarCliente con 
                  accion = "Actualizar Estado Contacto" 
                  oidContacto 
                  oidCliente 
                  oidTipoCliente 
                  oidSubtipoCliente 
                  indConsultoraInterna */	
                           var objParams = new Object();
                           objParams.oidContacto = get(FORMULARIO + '.oidContacto');
                           objParams.oidCliente = get(FORMULARIO + '.oidCliente'); 
                           objParams.oidTipoCliente = get(FORMULARIO + '.oidTipoCliente'); 
                           objParams.oidSubtipoCliente = get(FORMULARIO + '.oidSubtipoCliente'); 
                           objParams.indConsultoraInterna = get(FORMULARIO + '.indConsultoraInterna');
                           objParams.casoDeUso = get(FORMULARIO + '.casoDeUso');
                           mostrarModalSICC('LPPresentarClientes', 'Actualizar Estado Contacto', objParams, null, null);
                           recargaContactos();            
         }

         //	Modificado por Incidencia SiCC20080614
         function recargaContactos() {

                  if ( get(FORMULARIO + '.oidCliente')!=null && get(FORMULARIO + '.oidCliente')!=''  &&
                            get(FORMULARIO + '.pais')!=null && get(FORMULARIO + '.pais')!='' &&
                            get(FORMULARIO + '.idioma')!=null && get(FORMULARIO + '.idioma')!=''
                     )
                  {
                           var oidCliente = get(FORMULARIO + '.oidCliente');
                           var oidPais = get(FORMULARIO + '.pais');
                           var oidIdioma = get(FORMULARIO + '.idioma');

                           var DTOCliente = 'es.indra.sicc.dtos.cal.DTOCliente';
                            configurarPaginado(mipgndo3, "CALObtenerContactos", "ConectorObtenerContactos", DTOCliente, 
                            [["oidCliente", oidCliente],
                            ["oidPais", oidPais],
                            ["oidIdioma", oidIdioma]] );
                  }
                  else	{
                           setTimeout( recargaContactos(), 1000);
                  }
         }

function visibleLista() {
          DrdEnsanchaConMargenDcho('listado1',12);
          visibilidad('capaLista','V');
          eval (ON_RSZ);  
}

/*function muestraLista(ultima, rowset){
            var tamano = rowset.length;
            if (tamano > 0) {
                         visibleLista();
                         return true;
            } else {
                         invisibleLista();
                         return false;
            }
}*/

function mostrarCAL0001() {
         cdos_mostrarAlert(GestionarMensaje('1461'));
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

         function focalizaSiguienteBloqueo() {
                  if (get(FORMULARIO + '.activaBtActualiza') != "S") {
                           //document.all['btnRealizarBloqueoAdministrativo'].focus();
                           navPestana('lblContactos');
                  } else {
                           document.all['btnActualizarEstadoContacto'].focus();
                  }
         }

         function focalizaAnteriorPrimera() {
                  if (get(FORMULARIO + '.activaBtActualiza') != "S") {
                           //document.all['btnRealizarBloqueoAdministrativo'].focus(); //Incidencia DBLG700000296
                  } else {
                           document.all['btnActualizarEstadoContacto'].focus();
                  }

         }
         function focalizaAnteriorBloqueo() {
                  if (get(FORMULARIO + '.activaBtActualiza') != "S") {
                           //document.all['btnRealizarBloqueoAdministrativo'].focus(); //Incidencia DBLG700000296
                  } else {
                           document.all['btnActualizarEstadoContacto'].focus();
                  }

         }

         
         function navPestana(label) {
          if (typeof(parent.pestanas) != undefined )
                  parent.pestanas.onClickPestana(label);
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
function mostrarLista(){

 

    DrdEnsanchaConMargenDcho('listado5',28);
    document.all["Cplistado5"].style.visibility=''; 
    document.all["CpLin1listado5"].style.visibility='';  
    document.all["CpLin2listado5"].style.visibility=''; 
    document.all["CpLin3listado5"].style.visibility='';
    document.all["CpLin4listado5"].style.visibility='';         
    eval (ON_RSZ);          

}