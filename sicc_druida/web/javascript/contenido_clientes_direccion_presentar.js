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


/*
    INDRA/CAR/PROY
    $Id: contenido_clientes_direccion_presentar.js,v 1.1 2009/12/03 19:02:12 pecbazalar Exp $
    DESC
*/
	var FORMULARIO = 'formulario';
	var cargado = false;

	function onLoadPag()   { 

		if (get(FORMULARIO + '.errDescripcion')!='') {
			var wnd = fMostrarMensajeError(get(FORMULARIO + '.errCodigo'), get(FORMULARIO + '.errDescripcion'));
			window.close();
		}
		cargado = true;
	
		configurarMenuSecundario(FORMULARIO);

			/*- idBusiness: "CALObtenerDirecciones" 
			- ConectorObtenerDirecciones 
			- DTOOID */

			var oid = get(FORMULARIO + '.oidCliente');
			var idioma = get(FORMULARIO+'.idioma');
			var pais = get(FORMULARIO+'.pais');

			configurarPaginado(mipgndo, "CALObtenerDirecciones", "ConectorObtenerDirecciones", "es.indra.sicc.cmn.negocio.comun.DTOComunes.DTOOIDPaginado",
				[['oid', oid], 
				['oidPais', pais], 
				['oidIdioma', idioma]]);
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




	function accionFicha() { 
		set(FORMULARIO + '.accion', 'Ver Ficha Solo');
		set(FORMULARIO + '.conectorAction', "LPPresentarClientes");
		enviaSICC(FORMULARIO);
	}

	function accionContactos() { 
		set(FORMULARIO + '.accion', '');
		set(FORMULARIO + '.conectorAction', "LPGestionarContactos");
		enviaSICC(FORMULARIO);
	}

	function accionCuentasCorrientes() { 
		set(FORMULARIO + '.accion', 'Cuentas corrientes');
		set(FORMULARIO + '.conectorAction', "LPPresentarClientes");
		enviaSICC(FORMULARIO);
	}

	function accionPedidos() { 
		set(FORMULARIO + '.accion', 'Pedidos');
		set(FORMULARIO + '.conectorAction', "LPPresentarClientes");
		enviaSICC(FORMULARIO);
	}

	function accionVinculos() { 
		set(FORMULARIO + '.accion', 'Vinculos');
		set(FORMULARIO + '.conectorAction', "LPPresentarClientes");
		enviaSICC(FORMULARIO);
	}

	function accionDocumentos() { 
		set(FORMULARIO + '.accion', 'Documentos');
		set(FORMULARIO + '.conectorAction', "LPPresentarClientes");
		enviaSICC(FORMULARIO);
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
	
	function navPestana(label) {
         if (typeof(parent.pestanas) != undefined )
         	parent.pestanas.onClickPestana(label);
	}
