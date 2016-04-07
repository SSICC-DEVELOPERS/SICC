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

function onLoadPag() {
    cargado = true;
    DrdEnsanchaConMargenDcho('listado1',12);
    var errDescripcion = get(FORMULARIO +'.errDescripcion');
    if (errDescripcion !='') {            
          var errCodigo = get(FORMULARIO+'.errCodigo');
          var wnd = fMostrarMensajeError(errCodigo, errDescripcion);
    }
    configurarMenuSecundario(FORMULARIO);
    
    DrdEnsanchaConMargenDcho('listado2',12);
    eval (ON_RSZ);
    focaliza(FORMULARIO+'.cbPeriodo');
	onClickEjecutarConsultas();
	onClickAceptar();
}

function visibleLista(lista) {
          
    visibilidad(lista,'V');
    DrdEnsanchaConMargenDcho(lista,12);
    eval (ON_RSZ);  
}

function noVisibleLista(lista) {
           visibilidad(lista,'O');
}

function muestraLista1(ultima, rowset) {
            
          var tamano = rowset.length;
          if (tamano > 0) {
                    visibleLista('capaLista1');
                    return true;
          } else {
					//inc BELC300024370, la lista sigue mostrandose aunque no haya registros
					 visibleLista('capaLista1');

                    //noVisibleLista('capaLista1');
                    // No se ha encontrado ningún elemento con los criterios especificados
                    //Control del foco
                    //focaliza(FORMULARIO+'.cbPeriodo');
					//return false;
                    return false;
          }
}

function muestraLista2(ultima, rowset) {
            
          var tamano = rowset.length;
          if (tamano > 0) {
                    visibleLista('capaLista2');
                    return true;
          } else {
                    noVisibleLista('capaLista2');
                    // No se ha encontrado ningún elemento con los criterios especificados
                    //Control del foco
                    focaliza(FORMULARIO+'.cbPeriodo');
                    return false;
          }
}

function fLimpiar() {
	set(FORMULARIO + '.cbPeriodo', ['']);
	noVisibleLista('capaLista1');
	noVisibleLista('capaLista2');
}

function shtabPeriodo(){
	document.all['btnActualizar'].focus();
}

function tabAceptar() {
	document.all['btnEjecutar'].focus();
}

function shtabEjeCon() {
	document.all['btnAceptar'].focus();
}

function tabActualizar() {
	navPestana('lblCuentaCorriente');
}

function shtabActualizar() {
	document.all['btnEjecutar'].focus();
}

function shEjecutar() {
	document.all['btnAceptar'].focus();
}

function tabEjecutar() {
	document.all['btnActualizar'].focus();
	//	navPestana('lblCuentaCorriente');
}

function onClickAceptar() {
	accionAceptar();	
}

function accionAceptar() {
	//Ariel D. agregado por incidencia CAL-05
	set(FORMULARIO+'.oidPeriodo', get(FORMULARIO+'.cbPeriodo'));	
	
	var pais = get(FORMULARIO+'.pais');
	var idioma = get(FORMULARIO+'.idioma');
	var oid =  get(FORMULARIO+'.oidCliente'); 
	var dto =  [ ["oidPais", pais], ["oidIdioma", idioma], ["oid", oid]];
	configurarPaginado(mipgndo, "CALCargarContactos", "ConectorCargarContactos", "es.indra.sicc.dtos.cal.DTOCargarOID", dto );
}

function onClickEjecutarConsultas() {
	//Se carga la lista lstMotivos con los motivos por tipo de cliente.
	var pais = get(FORMULARIO+'.pais');
	var idioma = get(FORMULARIO+'.idioma');
	var oid =  get(FORMULARIO+'.oidTipoCliente'); 
	var dto =  [ ["oidPais", pais], ["oidIdioma", idioma], ["oid", oid] ];
	configurarPaginado(mipgndo2, "CALCargarMotivosTipoCliente", "ConectorCargarMotivosTipoCliente", "es.indra.sicc.dtos.cal.DTOCargarOID", dto );
}

function onClickActualizar() {
	 if (listado1.numSelecc() == 0) {
                    // Muestra el mensaje: "Debe seleccionar un elemento de la lista"
                    GestionarMensaje('50');
          } else if (listado1.numSelecc() > 1){
          	    // Muestra el mensaje: "Debe seleccionar un solo elemento de la lista "
          	    GestionarMensaje('1022');
          	    deseleccionaListado1();
          } else {
          	var objParams = new Object();
          	var codigosSeleccionados = listado1.codSeleccionados();
             objParams.oidContacto = listado1.extraeDato(codigosSeleccionados[0],0);
			//alert(objParams.oidContacto);
			mostrarModalSICC('LPPresentarClientes', 'Actualizar Estado Contacto',objParams, null,null);
	   
		    accionAceptar();

	 }
}

function onClickEjecutar() {
	 if (listado2.numSelecc() == 0) {
                    // Muestra el mensaje: "Debe seleccionar un elemento de la lista"
                    GestionarMensaje('50');
          } else if (listado2.numSelecc() > 1) {
          	    // Muestra el mensaje: "Debe seleccionar un solo elemento de la lista "
          	    GestionarMensaje('1022');
          	    deseleccionaListado2();
          } else {
          	var objParams = new Object();
          	formulario.oculto = "S";
			objParams.oidCliente = get(FORMULARIO+'.oidCliente');
			objParams.codCliente = get(FORMULARIO+'.codCliente');
			objParams.oidTipoCliente = get(FORMULARIO+'.oidTipoCliente');
			
			//var oidPeriodo = get(FORMULARIO+'.oidPeriodo');
			//alert(oidPeriodo);

			objParams.oidPeriodo = get(FORMULARIO+'.oidPeriodo');
			objParams.oidMarca = get(FORMULARIO+'.oidMarca');
			objParams.oidCanal = get(FORMULARIO+'.oidCanal');
			objParams.oidZona = get(FORMULARIO+'.oidZona');
			objParams.oidMotivoContacto = listado2.codSeleccionados();
			objParams.codProceso = listado2.extraeDato(listado2.codSeleccionados(),1);
			var valor = mostrarModalSICC('LPGestionarContactos', 'ejecutar',objParams, null,null);
			
			//set(FORMULARIO+'.accion','recuperarSesion');
			//set(FORMULARIO+'.conectorAction','LPGestionarContactos');
      
       var objParamsInt = new Object();          
       objParamsInt.accion = 'recuperarSesion';
       objParamsInt.conectorAction= 'LPGestionarContactos';
         
          setValues(objParamsInt);
         
			   //enviaSICC(FORMULARIO, null, null, "N");

			/*if((valor != -1) && (valor!='undefined')) { 
				objParams.oidContacto = valor;
				//alert(valor);
				mostrarModalSICC('LPPresentarClientes', 'Actualizar Estado Contacto',objParams, null,null);
				accionAceptar();
			}*/
		 }
  }

  function oidRecuperado(oidContacto) {
		var objParams = new Object();
        //formulario.oculto = "S";
		objParams.oidCliente = get(FORMULARIO+'.oidCliente');
		objParams.oidTipoCliente = get(FORMULARIO+'.oidTipoCliente');
		objParams.oidPeriodo = get(FORMULARIO+'.oidPeriodo');
		objParams.oidMarca = get(FORMULARIO+'.oidMarca');
		objParams.oidCanal = get(FORMULARIO+'.oidCanal');
		objParams.oidZona = get(FORMULARIO+'.oidZona');
		objParams.oidMotivoContacto = listado2.codSeleccionados();
		objParams.codProceso = listado2.extraeDato(listado2.codSeleccionados(),1);
		objParams.oidContacto = oidContacto;
	
	    mostrarModalSICC('LPPresentarClientes', 'Actualizar Estado Contacto',objParams, null,null);	
		accionAceptar();
		
}
         function deseleccionaListado1() {
                  for (i = 0; i < listado1.datos.length; i++)
                                    listado1.deselecciona(i); 
         }


         function deseleccionaListado2() {
                  for (i = 0; i < listado2.datos.length; i++)
                                    listado2.deselecciona(i); 
         }

function noDisponible() {
	//Muestra el mensaje: "Opción no disponible en esta versión " (CAL-0002 )
         cdos_mostrarAlert(GestionarMensaje('1458'));
}


function accionFicha() { 
  formulario.oculto = 'N';
  set(FORMULARIO + '.accion', 'Ver Ficha Solo');
  set(FORMULARIO + '.conectorAction', "LPPresentarClientes");
  var objParamsInt = new Object();          
  objParamsInt.accion = 'Ver Ficha Solo';
  objParamsInt.conectorAction= 'LPPresentarClientes';
  setValues(objParamsInt);
  enviaSICC(FORMULARIO, null, null, "N");
}

function accionContactos() {
    // No realizar nada pues ya estamos en la pestanya Contactos
}

function accionCuentasCorrientes(){
    formulario.oculto = 'N';
    set(FORMULARIO+'.accion','Cuentas corrientes');
    set(FORMULARIO+'.conectorAction','LPPresentarClientes');
    var objParamsInt = new Object();          
    objParamsInt.accion = 'Cuentas corrientes';
    objParamsInt.conectorAction= 'LPPresentarClientes';
    setValues(objParamsInt);
    enviaSICC(FORMULARIO, null, null, "N");
         
}

function accionPedidos(){
     formulario.oculto = 'N';
     set(FORMULARIO+'.accion','Pedidos');
     set(FORMULARIO+'.conectorAction','LPPresentarClientes');
     var objParamsInt = new Object();          
     objParamsInt.accion = 'Pedidos';
     objParamsInt.conectorAction= 'LPPresentarClientes';
     setValues(objParamsInt);
     enviaSICC(FORMULARIO, null, null, "N");
}

function accionVinculos(){
     formulario.oculto = 'N';
     set(FORMULARIO+'.accion','Vinculos');
     set(FORMULARIO+'.conectorAction','LPPresentarClientes');
     var objParamsInt = new Object();          
     objParamsInt.accion = 'Vinculos';
     objParamsInt.conectorAction= 'LPPresentarClientes';
     setValues(objParamsInt);
     enviaSICC(FORMULARIO, null, null, "N");
}

function accionDocumentos(){
     formulario.oculto = 'N';
     set(FORMULARIO+'.accion','Documentos');
     set(FORMULARIO+'.conectorAction','LPPresentarClientes');
     var objParamsInt = new Object();          
     objParamsInt.accion = 'Documentos';
     objParamsInt.conectorAction= 'LPPresentarClientes';
     setValues(objParamsInt);
     enviaSICC(FORMULARIO, null, null, "N");
}

function accionDireccion (){
    formulario.oculto = 'N';
    set(FORMULARIO+'.accion','Direccion');
    set(FORMULARIO+'.conectorAction','LPPresentarClientes');
     var objParamsInt = new Object();          
     objParamsInt.accion = 'Direccion';
     objParamsInt.conectorAction= 'LPPresentarClientes';
     setValues(objParamsInt);
	  enviaSICC(FORMULARIO, null, null, "N");
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
								   //txt_to('lblValorPais', get('frmInsertarMatrizDias.hPaisDescripcion')); 

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

	function navPestana(label) {
         if (typeof(parent.pestanas) != undefined )
         	parent.pestanas.onClickPestana(label);
	}
  
  function setValues(objParams){
	if(objParams.parametros){

		var atributos;
		//Limpio todos los campos insertados del frm que envio
		eliminaElementosDinamicos();
		for(atributos in objParams.parametros){
			if(atributos != "window" && atributos != "length"){
				var hidden = document.createElement("INPUT");
				hidden.type = "hidden";
				hidden.insertado = "1";
				hidden.name = atributos;
				hidden.value = (objParams.parametros[atributos]==null)?"":objParams.parametros[atributos];
				document.forms["frmContenidoEnvia"].appendChild(hidden);
			}
		}
		set('frmContenidoEnvia.conectorAction', objParams.conectorAction);
		enviaSICC("frmContenidoEnvia");
	}	
}


function eliminaElementosDinamicos(){
	var elementos = document.forms["frmContenidoEnvia"].elements;
	var longitud = elementos.length;
	for ( i = 0;i < longitud; i++ ){
		var oChild=document.forms["frmContenidoEnvia"].children(i);	
		if (oChild!= null && oChild.insertado=="1"){
			document.forms["frmContenidoEnvia"].removeChild(oChild);
			i = i-1;
		}
	}
}