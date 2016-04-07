
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_busqueda_materiales  implements es.indra.druida.base.ObjetoXML {
   private ArrayList v = new ArrayList();

   public Element getXML (Document doc){
      

      getXML0(doc);
         

      getXML90(doc);
         

      getXML180(doc);
         

      getXML270(doc);
         

      getXML360(doc);
         

      getXML450(doc);
         

      getXML540(doc);
         

      getXML630(doc);
         

      getXML720(doc);
         

      getXML810(doc);
         

      getXML900(doc);
         

      getXML990(doc);
         

      getXML1080(doc);
         

      getXML1170(doc);
         

      getXML1260(doc);
         

      getXML1350(doc);
         

      getXML1440(doc);
         

      getXML1530(doc);
         

      getXML1620(doc);
         

      getXML1710(doc);
         

      getXML1800(doc);
         

      getXML1890(doc);
         

      getXML1980(doc);
         

      getXML2070(doc);
         

      getXML2160(doc);
         

      getXML2250(doc);
         

      getXML2340(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_consultar_modificar_materiales" );
      ((Element)v.get(0)).setAttribute("titulo","Modificar Materiales" );
      ((Element)v.get(0)).setAttribute("estilos","estilos.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","Modificar Materiales" );
      ((Element)v.get(0)).setAttribute("onload","" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(1)).setAttribute("src","sicc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(1));
      /* Termina nodo:1   */

      /* Empieza nodo:2 / Elemento padre: 0   */
      v.add(doc.createElement("ESTILO"));
      ((Element)v.get(0)).appendChild((Element)v.get(2));

      /* Elemento padre:2 / Elemento actual: 3   */
      v.add(doc.createTextNode(" \r    #estMiCombo30F { width:355px} \r    #estMiCombo40F { width:465px} \r"));
      ((Element)v.get(2)).appendChild((Text)v.get(3));

      /* Termina nodo Texto:3   */
      /* Termina nodo:2   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(4));

      /* Elemento padre:4 / Elemento actual: 5   */
      v.add(doc.createTextNode("\r  \r\r	var pantalla = '';\r\r	function setComboDefault(hid, cb){\r		 iSeleccionado = new Array(); \r		 iSeleccionado[0] = get(hid);\r		 set(cb,iSeleccionado);\r	}\r\r		function CleanModificar() {\r				set('frmMateriales.rdbLote',get('frmMateriales.hidLote'));\r		setComboDefault('frmMateriales.hidUdDeMedidaDimensiones', 'frmMateriales.cbUdDeMedidaDimensiones');\r		setComboDefault('frmMateriales.hidUdMedidaPeso', 'frmMateriales.cbUnidadMedidaPeso');		\r		set('frmMateriales.txtUdDentroPedido',get('frmMateriales.hidUdDentroPedido'));		\r		set('frmMateriales.txtUnidadesPorCaja',get('frmMateriales.hidUdCaja'));		\r		setComboDefault('frmMateriales.hidUdMedidaVenta', 'frmMateriales.cbUnidadMedidaVenta');		\r		set('frmMateriales.txtCosteEstandar',get('frmMateriales.hidCosteEstandar'));		\r		set('frmMateriales.txtPrecioPosicionamiento',get('frmMateriales.hidPrecioPosicionamiento'));\r		set('frmMateriales.rdbSituacion',get('frmMateriales.hidSituacion'));				\r		set('frmMateriales.rdbIndicadorDentroDeCaja',get('frmMateriales.hidIndicadorDentroDeCaja'));\r		set('frmMateriales.txtCodigoPagoFraccionado',get('frmMateriales.hidCodPagoFraccionado'));		\r		set('frmMateriales.txtCodigoImpuesto',get('frmMateriales.hidCodImpuesto'));\r		setTimeout('focaliza(\\'frmMateriales.rdbLote\\',\\'\\',0)', 100);\r	}\r	\r	function Clean() {\r		iSeleccionado = new Array ();\r		iSeleccionado[0] = \"0\";\r				set('frmMateriales.txtCodigoSAP','');\r		set('frmMateriales.txtCodigoAntiguo','');\r		set('frmMateriales.txtDescripcionSAP','');\r		set('frmMateriales.txtDescripcionCorta','');\r		set('frmMateriales.rdbLote','');\r		set('frmMateriales.rdbTipo','');\r		set('frmMateriales.cbMarca','');\r		set('frmMateriales.cbUnidadDeNegocio','');\r		set('frmMateriales.cbNegocio','');\r		set('frmMateriales.cbGenerico','');\r		set('frmMateriales.cbSupergenerico','');\r		set('frmMateriales.txtJerarquia1','');\r		set('frmMateriales.txtJerarquia2','');\r		set('frmMateriales.txtJerarquia3','');\r		set('frmMateriales.cbLinea','');\r		set('frmMateriales.txtAtributo1','');\r		set('frmMateriales.txtAtributo2','');\r		set('frmMateriales.txtAtributo3','');\r		set('frmMateriales.txtAlto','');\r		set('frmMateriales.txtLargo','');\r		set('frmMateriales.txtAncho','');\r		set('frmMateriales.cbUdDeMedidaDimensiones','');\r		set('frmMateriales.txtVolumen','');\r		set('frmMateriales.txtPeso','');\r		set('frmMateriales.cbUnidadMedidaPeso','');\r		set('frmMateriales.txtUdDentroPedido','');\r		set('frmMateriales.txtUnidadesPorCaja','');\r		set('frmMateriales.cbUnidadMedidaVenta','');\r		set('frmMateriales.txtCosteEstandar','');\r		set('frmMateriales.txtPrecioPosicionamiento','');\r		set('frmMateriales.rdbSituacion','');\r		set('frmMateriales.cbEstatusDelProducto','');\r		set('frmMateriales.rdbIndicadorDentroDeCaja','');\r		set('frmMateriales.txtCodigoPagoFraccionado','');\r		set('frmMateriales.txtCodigoImpuesto','');\r		set('frmMateriales.txtPrecioCatalogo','');\r		set('frmMateriales.txtPrecioContable','');\r		setTimeout ('focaliza(\\'frmMateriales.txtCodigoSAP\\',\\'\\')', 100);\r	}\r\r	function inicializacion() {\r				pantalla = get('frmMateriales.hidPantalla');\r\r		cargarBarra(document.all.barra.value);\r		cargarValoresPorDefecto();\r		mostrarCodigoError();\r				if ( pantalla == 'modificar' ) {\r			deshabilitarControlesModificar();\r			if (get('frmMateriales.hidLote') == 'SI') {\r				document.all.rdbLote[0].focus();\r			}\r			else {\r				document.all.rdbLote[1].focus();\r			}\r			setTimeout('focaliza(\\'frmMateriales.rdbLote\\',\\'\\',0)', 100);\r		}\r		else {\r			focaliza ('frmMateriales.txtCodigoSAP', '');\r		}\r	}\r\r	function deshabilitarControles() {\r				deshabilitarControlesModificar();\r				document.all.rdbLote[0].disabled = true;\r		document.all.rdbLote[1].disabled = true;\r		accion('frmMateriales.cbUdDeMedidaDimensiones','.disabled=true');\r		accion('frmMateriales.cbUnidadMedidaPeso','.disabled=true');\r		accion('frmMateriales.txtUdDentroPedido','.disabled=true');\r		accion('frmMateriales.txtUnidadesPorCaja','.disabled=true');\r		accion('frmMateriales.cbUnidadMedidaVenta','.disabled=true');\r		accion('frmMateriales.txtCosteEstandar','.disabled=true');\r		accion('frmMateriales.txtPrecioPosicionamiento','.disabled=true');\r		document.all.rdbSituacion[0].disabled=true;\r		document.all.rdbSituacion[1].disabled=true;\r		accion('frmMateriales.cbEstatusDelProducto','.disabled=true');\r		document.all.rdbIndicadorDentroDeCaja[0].disabled=true;\r		document.all.rdbIndicadorDentroDeCaja[1].disabled=true;\r		accion('frmMateriales.rdbSituacion','.disabled=true');\r		accion('frmMateriales.txtCodigoPagoFraccionado','.disabled=true');\r		accion('frmMateriales.txtCodigoImpuesto','.disabled=true');\r			}\r\r	function deshabilitarControlesModificar() {\r		accion('frmMateriales.txtCodigoSAP','.disabled=true');\r		accion('frmMateriales.txtCodigoAntiguo','.disabled=true');\r		accion('frmMateriales.txtDescripcionSAP' , '.disabled=true');\r		accion('frmMateriales.txtDescripcionCorta','.disabled=true');\r		document.all.rdbTipo[0].disabled = true;\r		document.all.rdbTipo[1].disabled = true;\r		accion('frmMateriales.cbMarca', '.disabled=true');\r		accion('frmMateriales.cbUnidadDeNegocio','.disabled=true');\r		accion('frmMateriales.cbNegocio','.disabled=true');\r		accion('frmMateriales.cbGenerico','.disabled=true');\r		accion('frmMateriales.cbSupergenerico', '.disabled=true');\r		accion('frmMateriales.txtJerarquia1','.disabled=true');\r		accion('frmMateriales.txtJerarquia2','.disabled=true');\r		accion('frmMateriales.txtJerarquia3','.disabled=true');\r		accion('frmMateriales.cbLinea', '.disabled=true');\r		accion('frmMateriales.txtAtributo1','.disabled=true');\r		accion('frmMateriales.txtAtributo2','.disabled=true');\r		accion('frmMateriales.txtAtributo3','.disabled=true');\r		accion('frmMateriales.txtAlto','.disabled=true');\r		accion('frmMateriales.txtLargo','.disabled=true');\r		accion('frmMateriales.txtAncho','.disabled=true');\r		accion('frmMateriales.txtVolumen','.disabled=true');\r		accion('frmMateriales.txtPeso','.disabled=true');\r		accion('frmMateriales.cbEstatusDelProducto', '.disabled=true');\r		accion('frmMateriales.txtPrecioCatalogo','.disabled=true');\r		accion('frmMateriales.txtPrecioContable','.disabled=true');\r	}\r\r		function cargarValoresPorDefecto() {\r		set('frmMateriales.txtCodigoSAP',get('frmMateriales.hidCodigoSAP'));\r		set('frmMateriales.txtCodigoAntiguo',get('frmMateriales.hidCodigoAntiguo'));\r		set('frmMateriales.txtDescripcionSAP',get('frmMateriales.hidDescripcionSAP'));\r		set('frmMateriales.txtDescripcionCorta',get('frmMateriales.hidDescripcionCorta'));\r		set('frmMateriales.rdbLote',get('frmMateriales.hidLote'));\r		set('frmMateriales.rdbTipo',get('frmMateriales.hidTipo'));\r		setComboDefault('frmMateriales.hidMarca', 'frmMateriales.cbMarca');\r		setComboDefault('frmMateriales.hidUnidadDeNegocio', 'frmMateriales.cbUnidadDeNegocio');\r		setComboDefault('frmMateriales.hidNegocio', 'frmMateriales.cbNegocio');\r		setComboDefault('frmMateriales.hidGenerico', 'frmMateriales.cbGenerico');\r		setComboDefault('frmMateriales.hidSupergenerico', 'frmMateriales.cbSupergenerico');\r		set('frmMateriales.txtJerarquia1',get('frmMateriales.hidJerarquia1'));\r		set('frmMateriales.txtJerarquia2',get('frmMateriales.hidJerarquia2'));\r		set('frmMateriales.txtJerarquia3',get('frmMateriales.hidJerarquia3'));\r		setComboDefault('frmMateriales.hidLinea', 'frmMateriales.cbLinea');\r		set('frmMateriales.txtAtributo1',get('frmMateriales.hidAtributo1'));\r		set('frmMateriales.txtAtributo2',get('frmMateriales.hidAtributo2'));\r		set('frmMateriales.txtAtributo3',get('frmMateriales.hidAtributo3'));\r		set('frmMateriales.txtAlto',get('frmMateriales.hidAlto'));\r		set('frmMateriales.txtLargo',get('frmMateriales.hidLargo'));\r		set('frmMateriales.txtAncho',get('frmMateriales.hidAncho'));\r		setComboDefault('frmMateriales.hidUdDeMedidaDimensiones', 'frmMateriales.cbUdDeMedidaDimensiones');\r		set('frmMateriales.txtVolumen',get('frmMateriales.hidVolumen'));\r		set('frmMateriales.txtPeso',get('frmMateriales.hidPeso'));\r		setComboDefault('frmMateriales.hidUdMedidaPeso', 'frmMateriales.cbUnidadMedidaPeso');\r		set('frmMateriales.txtUdDentroPedido',get('frmMateriales.hidUdDentroPedido'));\r		set('frmMateriales.txtUnidadesPorCaja',get('frmMateriales.hidUdCaja'));\r		setComboDefault('frmMateriales.hidUdMedidaVenta', 'frmMateriales.cbUnidadMedidaVenta');\r		set('frmMateriales.txtCosteEstandar',get('frmMateriales.hidCosteEstandar'));\r		set('frmMateriales.txtPrecioPosicionamiento',get('frmMateriales.hidPrecioPosicionamiento'));\r		set('frmMateriales.rdbSituacion',get('frmMateriales.hidSituacion'));\r		setComboDefault('frmMateriales.hidEstatusDelProducto', 'frmMateriales.cbEstatusDelProducto');\r		set('frmMateriales.rdbIndicadorDentroDeCaja',get('frmMateriales.hidIndicadorDentroCaja'));\r		set('frmMateriales.txtCodigoPagoFraccionado',get('frmMateriales.hidCodPagoFraccionado'));\r		set('frmMateriales.txtCodigoImpuesto',get('frmMateriales.hidCodImpuesto'));\r		set('frmMateriales.txtPrecioCatalogo',get('frmMateriales.hidPrecioCatalogo'));\r		set('frmMateriales.txtPrecioContable',get('frmMateriales.hidPrecioContable'));\r	}\r\r	function buscar() {\r		if ( ValidaCamposBuscar() ) {\r			set ('frmMateriales.accion', 'buscar');\r			enviarFormulario();\r		}\r	}\r\r	function validarCaracteres(valor,permitidos) {\r		var c;\r		for(var i=0;i<valor.length;i++) {\r			c=valor.charAt(i);\r			if (permitidos.indexOf(c)==-1) {\r				return false;}\r		 }\r		return true;\r	}\r\r	/* Parametros:\r						 -Valor: el valor a validar\r						 -ent: cantidad de la parte entera\r						 -dec : cantidad de la parte decimal\r						 -min: rango minimo\r						 -max: rango maximo\r						 -obligatorio: si el campo viene */\r	function ValidarNumerico( nombre, requerido, error, ent, dec, min, max ) {\r		var variable = get(nombre).replace(\",\",\".\");\r		if ( ( ! requerido ) && ( variable.length == 0 ) )\r			return true;	\r				if ( ! validarCaracteres(variable,'0123456789. ')) {\r			GestionarMensaje ( '2455', null, null, null);\r			focaliza(nombre,'');\r			return false;\r		}\r		var resultado = fValidarFloat(variable, ent, dec, false, min, max, requerido);\r		if  ( resultado != \"OK\" ) {\r			GestionarMensaje ( error, null, null, null);\r			focaliza(nombre,'');\r			return false;\r		}\r		else {\r			set(nombre,variable);\r			return true;\r		}\r	}\r\r	/* Parametros:\r				 -nombre del componente a validar\r				 -lon: la longitud maxima\r				 -min : menor valor permitido\r				 -max : maximo valor permitido\r				 -error : codigo de error a devolver\r				 -requerido : define si el campo es requerido o no */\r	function ValidarNumericoEntero( nombre, requerido, error, min, max, lon ) {\r		var variable = get(nombre);\r		if ( ( ! requerido ) && ( variable.length == 0 ) )\r			return true;	\r				var resultado = 	fValidarNumero(variable, lon, min, max)\r		if  ( resultado != \"OK\" ) {\r			GestionarMensaje ( error, null, null, null);\r			focaliza(nombre,'');\r			return false;\r		}\r		else \r			return true;\r	}\r\r	function ValidarRequeridoCombo( nombre, requerido, error ) { \r		return fValidarCOMBO(nombre);\r	}\r\r		function ValidarRequeridoRadio( nombre, requerido, error ) { \r		var variable = get(nombre);\r		if ( requerido && ( variable.length == 0 ) ) {\r			GestionarMensaje ( error, null, null, null);\r			return false;\r		}\r		else\r			return true;\r	}\r\r	function ValidarRequerido( nombre, requerido, error ) { \r		var variable = get(nombre);\r		if ( requerido && ( variable.length == 0 ) ) {\r			GestionarMensaje ( error, null, null, null);\r			return false;\r		}\r		else\r			return true;\r	}\r\r	function ValidaCamposModificar() {\r\r		if ( ! ValidarRequeridoRadio( 'frmMateriales.rdbLote', true, 2513 )  )\r			return false;\r\r		if ( ! ValidarRequeridoCombo( 'frmMateriales.cbUdDeMedidaDimensiones', true, 2513 )  )\r			return false;\r\r		if ( ! ValidarRequeridoCombo( 'frmMateriales.cbUnidadMedidaPeso', true, 2513 )  )\r			return false;\r\r		if ( !  ValidarNumericoEntero( 'frmMateriales.txtUdDentroPedido', false, 2455, 0, 999, 3 ) )\r			return false;\r\r		if ( !  ValidarNumericoEntero( 'frmMateriales.txtUnidadesPorCaja', false, 2455, 0, 99999, 5 ) )\r			return false;\r\r		if ( ! ValidarRequeridoCombo( 'frmMateriales.cbUnidadMedidaVenta', true, 2513 )  )\r			return false;\r\r		if ( !  ValidarNumerico( 'frmMateriales.txtCosteEstandar', false, 2510, 14, 2, 0, 99999999999999.99) )\r			return false;\r\r		if ( !  ValidarNumerico( 'frmMateriales.txtPrecioPosicionamiento', false, 2510, 14, 2, 0, 99999999999999.99) )\r			return false;\r\r		\r		\r		\r		\r		return true;\r	}\r\r	function ValidaCamposBuscar() {\r		if ( !  ValidarNumerico( 'frmMateriales.txtAlto', false, 2511, 15, 5, 0, 99999999999999.99999) )\r			return false;\r\r		if ( !  ValidarNumerico( 'frmMateriales.txtLargo', false, 2511, 15, 5, 0, 99999999999999.99999) )\r			return false;\r\r		if ( !  ValidarNumerico( 'frmMateriales.txtAncho', false, 2511, 15, 5, 0, 99999999999999.99999) )\r			return false;\r\r		if ( !  ValidarNumerico( 'frmMateriales.txtPeso', false, 2511, 5, 5, 0, 99999.99999) )\r			return false;\r\r		if ( !  ValidarNumerico( 'frmMateriales.txtVolumen', false, 2512, 15, 5, 0, 99999999999999.99999) )\r			return false;\r\r		if ( !  ValidarNumericoEntero( 'frmMateriales.txtUdDentroPedido', false, 2455, 0, 999, 3 ) )\r			return false;\r\r		if ( !  ValidarNumericoEntero( 'frmMateriales.txtUnidadesPorCaja', false, 2455, 0, 99999, 5 ) )\r			return false;\r\r		if ( !  ValidarNumerico( 'frmMateriales.txtCosteEstandar', false, 2510, 14, 2, 0, 99999999999999.99) )\r			return false;\r\r		if ( !  ValidarNumerico( 'frmMateriales.txtPrecioPosicionamiento', false, 2510, 14, 2, 0, 99999999999999.99) )\r			return false;\r\r		if ( !  ValidarNumerico( 'frmMateriales.txtPrecioCatalogo', false, 2510, 14, 2, 0, 99999999999999.99) )\r			return false;\r\r		if ( !  ValidarNumerico( 'frmMateriales.txtPrecioContable', false, 2510, 14, 2, 0, 99999999999999.99) )\r			return false;\r		return true;\r	}\r\r	function modificar() {\r	  if (lstResultado.seleccion.longitud == 1) {\r		  var posicion = obtenerPosicionLista (lstResultado.getSeleccion(), lstResultado );\r		  set ('frmMateriales.elementosSeleccionados', lstResultado.getSeleccion() );\r\r		  myString = new String(lstResultado.datos.ij(posicion,0));\r		  splitString = myString.split('--');\r		  if ( splitString.length != 0 ) {\r\r				set('frmMateriales.hidCodigoSAP', splitString[0] );\r				set('frmMateriales.hidCodigoAntiguo', splitString[1] );\r				set('frmMateriales.hidDescripcionSAP', splitString[2] );\r				set('frmMateriales.hidDescripcionCorta', splitString[3] );\r				set('frmMateriales.hidLote', splitString[4] );\r				set('frmMateriales.hidTipo', splitString[5] );\r				set('frmMateriales.hidMarca', splitString[6] );\r				set('frmMateriales.hidUnidadDeNegocio', splitString[7] );\r				set('frmMateriales.hidNegocio', splitString[8] );\r				set('frmMateriales.hidGenerico', splitString[9] );\r				set('frmMateriales.hidSupergenerico', splitString[10] );\r				set('frmMateriales.hidJerarquia1', splitString[11] );\r				set('frmMateriales.hidJerarquia2', splitString[12] );\r				set('frmMateriales.hidJerarquia3', splitString[13] );\r				set('frmMateriales.hidLinea', splitString[14] );\r				set('frmMateriales.hidAtributo1', splitString[15] );\r				set('frmMateriales.hidAtributo2', splitString[16] );\r				set('frmMateriales.hidAtributo3', splitString[17] );\r				set('frmMateriales.hidAlto', splitString[18] );\r				set('frmMateriales.hidLargo', splitString[19] );\r				set('frmMateriales.hidAncho', splitString[20] );\r				set('frmMateriales.hidUdDeMedidaDimensiones', splitString[21] );\r				set('frmMateriales.hidVolumen', splitString[22] );\r				set('frmMateriales.hidPeso', splitString[23] );\r				set('frmMateriales.hidUdMedidaPeso', splitString[24] );\r				set('frmMateriales.hidUdDentroPedido', splitString[25] );\r				set('frmMateriales.hidUdCaja', splitString[26] );\r				set('frmMateriales.hidUdMedidaVenta', splitString[27] );\r				set('frmMateriales.hidCosteEstandar', splitString[28] );\r				set('frmMateriales.hidPrecioPosicionamiento', splitString[29] );\r				set('frmMateriales.hidSituacion', splitString[30] );\r				set('frmMateriales.hidEstatusDelProducto', splitString[31] );\r				set('frmMateriales.hidIndicadorDentroCaja', splitString[32] );\r				set('frmMateriales.hidCodPagoFraccionado', splitString[33] );\r				set('frmMateriales.hidCodImpuesto', splitString[34] );\r				set('frmMateriales.hidPrecioCatalogo', splitString[35] );\r				set('frmMateriales.hidPrecioContable', splitString[36] );\r						\r				set ('frmMateriales.conectorAction','LPModificarMateriales');\r				set ('frmMateriales.accion', 'modificar');\r				enviarFormulario();\r		  }\r	  } else {\r		  GestionarMensaje ('8', null, null, null);\r	  }\r	}\r\r	function guardar() {\r		if ( ValidaCamposModificar() ) {\r		  set ('frmMateriales.conectorAction','LPModificarMateriales');\r		  set ('frmMateriales.accion', 'guardar');\r		  enviarFormulario();\r		}\r	}\r\r	function mostrarCodigoError() { \r	  if ( get('frmMateriales.errDescripcion') != '' ) {\r		  		  cdos_mostrarAlert( get('frmMateriales.errDescripcion') );\r	  }\r	}\r\r	function pasarFocoAnteriorRDBLotes() {\r		if ( pantalla == 'modificar' )\r			focaliza('frmMateriales.txtCodigoImpuesto','');\r		else\r			focaliza('frmMateriales.txtDescripcionCorta','');\r	}\r\r	function pasarFocoAnteriorCodigoSAP() {\r		focaliza('frmMateriales.txtPrecioContable','');\r	}\r\r	function pasarFocoSiguienteCodigoImpuesto() {	\r	\r		if ( pantalla == 'modificar' )\r		  if (get('frmMateriales.hidLote') == 'SI') {\r				document.all.rdbLote[0].focus();\r			}\r			else {\r				document.all.rdbLote[1].focus();\r			}\r		else\r			focaliza('frmMateriales.txtPrecioCatalogo','');\r	}\r\r	function pasarFocoSiguientePrecioContable() {\r		focaliza('frmMateriales.txtCodigoSAP','');\r	}\r\r	function enviarFormulario() {\r				deshabilitarControles();\r		envia ('frmMateriales');\r	}\r\r	function setRdbTipoS() {\r		set('frmMateriales.rdbTipo','Producto');\r	}\r\r	function setRdbTipoN() {\r		set('frmMateriales.rdbTipo','Servicio');\r	}\r\r	function setRdbLoteS() {\r		set('frmMateriales.rdbLote','SI');\r	}\r\r	function setRdbLoteN() {\r		set('frmMateriales.rdbLote','NO');\r	}\r\r	function setRdbSituacionN() {\r		set('frmMateriales.rdbSituacion','Inactivo');\r	}\r\r	function setRdbSituacionS() {\r		set('frmMateriales.rdbSituacion','Activo');\r	}\r\r	function setRdbIndicadorDentroDeCajaS() {\r		set('frmMateriales.rdbIndicadorDentroDeCaja','SI');\r	}\r\r	function setRdbIndicadorDentroDeCajaN() {\r		set('frmMateriales.rdbIndicadorDentroDeCaja','NO');\r	}\r\r  \r"));
      ((Element)v.get(4)).appendChild((Text)v.get(5));

      /* Termina nodo Texto:5   */
      /* Termina nodo:4   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(6)).setAttribute("nombre","frmMateriales" );
      ((Element)v.get(0)).appendChild((Element)v.get(6));

      /* Empieza nodo:7 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(7)).setAttribute("nombre","barra" );
      ((Element)v.get(7)).setAttribute("valor","barra_consultar_materiales" );
      ((Element)v.get(6)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(8)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(8)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","accion" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(11)).setAttribute("valor","LPBusquedaMateriales" );
      ((Element)v.get(6)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","casoDeUso" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","hidCodigoSAP" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","hidCodigoAntiguo" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","hidDescripcionSAP" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","hidDescripcionCorta" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","hidLote" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","hidTipo" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","hidMarca" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","hidUnidadDeNegocio" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","hidNegocio" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","hidGenerico" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","hidSupergenerico" );
      ((Element)v.get(23)).setAttribute("valor","" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(6)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","hidJerarquia1" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","hidJerarquia2" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","hidJerarquia3" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","hidLinea" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","hidAtributo1" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","hidAtributo2" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","hidAtributo3" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","hidAlto" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","hidLargo" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","hidAncho" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(34)).setAttribute("nombre","hidUdDeMedidaDimensiones" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(35)).setAttribute("nombre","hidVolumen" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(36)).setAttribute("nombre","hidPeso" );
      ((Element)v.get(36)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(37)).setAttribute("nombre","hidUdMedidaPeso" );
      ((Element)v.get(37)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(38)).setAttribute("nombre","hidUdDentroPedido" );
      ((Element)v.get(38)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(39)).setAttribute("nombre","hidUdCaja" );
      ((Element)v.get(39)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(40)).setAttribute("nombre","hidUdMedidaVenta" );
      ((Element)v.get(40)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(41)).setAttribute("nombre","hidCosteEstandar" );
      ((Element)v.get(41)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */

      /* Empieza nodo:42 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(42)).setAttribute("nombre","hidPrecioPosicionamiento" );
      ((Element)v.get(42)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */

      /* Empieza nodo:43 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(43)).setAttribute("nombre","hidSituacion" );
      ((Element)v.get(43)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */

      /* Empieza nodo:44 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(44)).setAttribute("nombre","hidEstatusDelProducto" );
      ((Element)v.get(44)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */

      /* Empieza nodo:45 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(45)).setAttribute("nombre","hidIndicadorDentroCaja" );
      ((Element)v.get(45)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */

      /* Empieza nodo:46 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
   }

   private void getXML180(Document doc) {
      ((Element)v.get(46)).setAttribute("nombre","hidCodPagoFraccionado" );
      ((Element)v.get(46)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */

      /* Empieza nodo:47 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(47)).setAttribute("nombre","hidCodImpuesto" );
      ((Element)v.get(47)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */

      /* Empieza nodo:48 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(48)).setAttribute("nombre","hidPrecioCatalogo" );
      ((Element)v.get(48)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */

      /* Empieza nodo:49 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(49)).setAttribute("nombre","hidPrecioContable" );
      ((Element)v.get(49)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */

      /* Empieza nodo:50 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(50)).setAttribute("nombre","hidClave" );
      ((Element)v.get(50)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */

      /* Empieza nodo:51 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(51)).setAttribute("nombre","hidPantalla" );
      ((Element)v.get(51)).setAttribute("valor","consultar" );
      ((Element)v.get(6)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */

      /* Empieza nodo:52 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(52)).setAttribute("nombre","hidClean" );
      ((Element)v.get(52)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */

      /* Empieza nodo:53 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(53)).setAttribute("nombre","elementosSeleccionados" );
      ((Element)v.get(53)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */

      /* Empieza nodo:54 / Elemento padre: 6   */
      v.add(doc.createElement("table"));
      ((Element)v.get(54)).setAttribute("border","0" );
      ((Element)v.get(54)).setAttribute("cellpadding","1" );
      ((Element)v.get(54)).setAttribute("cellspacing","0" );
      ((Element)v.get(54)).setAttribute("align","left" );
      ((Element)v.get(54)).setAttribute("width","1280" );
      ((Element)v.get(6)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(54)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(56)).setAttribute("width","12" );
      ((Element)v.get(56)).setAttribute("align","center" );
      ((Element)v.get(55)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(57)).setAttribute("src","b.gif" );
      ((Element)v.get(57)).setAttribute("width","12" );
      ((Element)v.get(57)).setAttribute("height","8" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */
      /* Termina nodo:56   */

      /* Empieza nodo:58 / Elemento padre: 55   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(55)).appendChild((Element)v.get(58));

      /* Elemento padre:58 / Elemento actual: 59   */
      v.add(doc.createTextNode(" "));
      ((Element)v.get(58)).appendChild((Text)v.get(59));

      /* Termina nodo Texto:59   */
      /* Termina nodo:58   */

      /* Empieza nodo:60 / Elemento padre: 55   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(60)).setAttribute("width","12" );
      ((Element)v.get(55)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(61)).setAttribute("src","b.gif" );
      ((Element)v.get(61)).setAttribute("width","12" );
      ((Element)v.get(61)).setAttribute("height","8" );
      ((Element)v.get(60)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */
      /* Termina nodo:60   */
      /* Termina nodo:55   */

      /* Empieza nodo:62 / Elemento padre: 54   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(54)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(62)).appendChild((Element)v.get(63));

      /* Elemento padre:63 / Elemento actual: 64   */
      v.add(doc.createTextNode(" "));
      ((Element)v.get(63)).appendChild((Text)v.get(64));

      /* Termina nodo Texto:64   */
      /* Termina nodo:63   */

      /* Empieza nodo:65 / Elemento padre: 62   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(65)).setAttribute("align","center" );
      ((Element)v.get(62)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("table"));
      ((Element)v.get(66)).setAttribute("width","1260" );
      ((Element)v.get(66)).setAttribute("border","1" );
      ((Element)v.get(66)).setAttribute("cellspacing","1" );
      ((Element)v.get(66)).setAttribute("cellpadding","0" );
      ((Element)v.get(66)).setAttribute("bordercolor","#CCCCCC" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("td"));
      ((Element)v.get(66)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("table"));
      ((Element)v.get(68)).setAttribute("cellSpacing","0" );
      ((Element)v.get(68)).setAttribute("cellPadding","0" );
      ((Element)v.get(68)).setAttribute("width","99%" );
      ((Element)v.get(68)).setAttribute("align","center" );
      ((Element)v.get(68)).setAttribute("border","0" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(68)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("td"));
      ((Element)v.get(69)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
   }

   private void getXML270(Document doc) {
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(71)).setAttribute("nombre","lblCodigoSAP" );
      ((Element)v.get(71)).setAttribute("ancho","155" );
      ((Element)v.get(71)).setAttribute("alto","30" );
      ((Element)v.get(71)).setAttribute("filas","1" );
      ((Element)v.get(71)).setAttribute("id","datosTitle" );
      ((Element)v.get(71)).setAttribute("cod","475" );
      ((Element)v.get(70)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */
      /* Termina nodo:70   */

      /* Empieza nodo:72 / Elemento padre: 69   */
      v.add(doc.createElement("td"));
      ((Element)v.get(69)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(73)).setAttribute("src","b.gif" );
      ((Element)v.get(73)).setAttribute("width","8" );
      ((Element)v.get(73)).setAttribute("height","8" );
      ((Element)v.get(72)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */
      /* Termina nodo:72   */

      /* Empieza nodo:74 / Elemento padre: 69   */
      v.add(doc.createElement("td"));
      ((Element)v.get(69)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(75)).setAttribute("id","datosCamposLeft" );
      ((Element)v.get(75)).setAttribute("nombre","txtCodigoSAP" );
      ((Element)v.get(75)).setAttribute("valor","" );
      ((Element)v.get(75)).setAttribute("size","34" );
      ((Element)v.get(75)).setAttribute("max","20" );
      ((Element)v.get(75)).setAttribute("onshtab","pasarFocoAnteriorCodigoSAP();" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */
      /* Termina nodo:74   */

      /* Empieza nodo:76 / Elemento padre: 69   */
      v.add(doc.createElement("td"));
      ((Element)v.get(69)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */

      /* Empieza nodo:77 / Elemento padre: 69   */
      v.add(doc.createElement("td"));
      ((Element)v.get(69)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(78)).setAttribute("src","b.gif" );
      ((Element)v.get(78)).setAttribute("width","665" );
      ((Element)v.get(78)).setAttribute("height","8" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */
      /* Termina nodo:77   */

      /* Empieza nodo:79 / Elemento padre: 69   */
      v.add(doc.createElement("td"));
      ((Element)v.get(69)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */
      /* Termina nodo:69   */

      /* Empieza nodo:80 / Elemento padre: 68   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(68)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(80)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(82)).setAttribute("nombre","lblCodigoAntiguo" );
      ((Element)v.get(82)).setAttribute("ancho","155" );
      ((Element)v.get(82)).setAttribute("alto","30" );
      ((Element)v.get(82)).setAttribute("filas","1" );
      ((Element)v.get(82)).setAttribute("id","datosTitle" );
      ((Element)v.get(82)).setAttribute("cod","2468" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */
      /* Termina nodo:81   */

      /* Empieza nodo:83 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(80)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(84)).setAttribute("src","b.gif" );
      ((Element)v.get(84)).setAttribute("width","8" );
      ((Element)v.get(84)).setAttribute("height","8" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */
      /* Termina nodo:83   */

      /* Empieza nodo:85 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(80)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(86)).setAttribute("id","datosCamposLeft" );
      ((Element)v.get(86)).setAttribute("nombre","txtCodigoAntiguo" );
      ((Element)v.get(86)).setAttribute("valor","" );
      ((Element)v.get(86)).setAttribute("size","30" );
      ((Element)v.get(86)).setAttribute("max","18" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */
      /* Termina nodo:85   */

      /* Empieza nodo:87 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(80)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */

      /* Empieza nodo:88 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(80)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(89)).setAttribute("src","b.gif" );
      ((Element)v.get(89)).setAttribute("width","8" );
      ((Element)v.get(89)).setAttribute("height","8" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */
      /* Termina nodo:88   */

      /* Empieza nodo:90 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(80)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */
      /* Termina nodo:80   */

      /* Empieza nodo:91 / Elemento padre: 68   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(68)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("td"));
      ((Element)v.get(91)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(93)).setAttribute("nombre","lblDescripcionSap" );
      ((Element)v.get(93)).setAttribute("ancho","155" );
      ((Element)v.get(93)).setAttribute("alto","30" );
      ((Element)v.get(93)).setAttribute("filas","1" );
      ((Element)v.get(93)).setAttribute("id","datosTitle" );
      ((Element)v.get(93)).setAttribute("cod","2469" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */
      /* Termina nodo:92   */

      /* Empieza nodo:94 / Elemento padre: 91   */
      v.add(doc.createElement("td"));
      ((Element)v.get(91)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML360(Document doc) {
      ((Element)v.get(95)).setAttribute("src","b.gif" );
      ((Element)v.get(95)).setAttribute("width","8" );
      ((Element)v.get(95)).setAttribute("height","8" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */
      /* Termina nodo:94   */

      /* Empieza nodo:96 / Elemento padre: 91   */
      v.add(doc.createElement("td"));
      ((Element)v.get(91)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(97)).setAttribute("id","datosCamposLeft" );
      ((Element)v.get(97)).setAttribute("nombre","txtDescripcionSAP" );
      ((Element)v.get(97)).setAttribute("valor","" );
      ((Element)v.get(97)).setAttribute("size","71" );
      ((Element)v.get(97)).setAttribute("max","40" );
      ((Element)v.get(96)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */
      /* Termina nodo:96   */

      /* Empieza nodo:98 / Elemento padre: 91   */
      v.add(doc.createElement("td"));
      ((Element)v.get(91)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */

      /* Empieza nodo:99 / Elemento padre: 91   */
      v.add(doc.createElement("td"));
      ((Element)v.get(91)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(100)).setAttribute("src","b.gif" );
      ((Element)v.get(100)).setAttribute("width","8" );
      ((Element)v.get(100)).setAttribute("height","8" );
      ((Element)v.get(99)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */
      /* Termina nodo:99   */

      /* Empieza nodo:101 / Elemento padre: 91   */
      v.add(doc.createElement("td"));
      ((Element)v.get(91)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */
      /* Termina nodo:91   */

      /* Empieza nodo:102 / Elemento padre: 68   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(68)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("td"));
      ((Element)v.get(102)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(104)).setAttribute("nombre","lblDescripcionCorta" );
      ((Element)v.get(104)).setAttribute("ancho","155" );
      ((Element)v.get(104)).setAttribute("alto","30" );
      ((Element)v.get(104)).setAttribute("filas","1" );
      ((Element)v.get(104)).setAttribute("id","datosTitle" );
      ((Element)v.get(104)).setAttribute("cod","47" );
      ((Element)v.get(103)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */
      /* Termina nodo:103   */

      /* Empieza nodo:105 / Elemento padre: 102   */
      v.add(doc.createElement("td"));
      ((Element)v.get(102)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(106)).setAttribute("src","b.gif" );
      ((Element)v.get(106)).setAttribute("width","8" );
      ((Element)v.get(106)).setAttribute("height","8" );
      ((Element)v.get(105)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */
      /* Termina nodo:105   */

      /* Empieza nodo:107 / Elemento padre: 102   */
      v.add(doc.createElement("td"));
      ((Element)v.get(102)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(108)).setAttribute("id","datosCamposLeft" );
      ((Element)v.get(108)).setAttribute("nombre","txtDescripcionCorta" );
      ((Element)v.get(108)).setAttribute("valor","" );
      ((Element)v.get(108)).setAttribute("size","71" );
      ((Element)v.get(108)).setAttribute("max","40" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */
      /* Termina nodo:107   */

      /* Empieza nodo:109 / Elemento padre: 102   */
      v.add(doc.createElement("td"));
      ((Element)v.get(102)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */

      /* Empieza nodo:110 / Elemento padre: 102   */
      v.add(doc.createElement("td"));
      ((Element)v.get(102)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(111)).setAttribute("src","b.gif" );
      ((Element)v.get(111)).setAttribute("width","8" );
      ((Element)v.get(111)).setAttribute("height","8" );
      ((Element)v.get(110)).appendChild((Element)v.get(111));
      /* Termina nodo:111   */
      /* Termina nodo:110   */

      /* Empieza nodo:112 / Elemento padre: 102   */
      v.add(doc.createElement("td"));
      ((Element)v.get(102)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */
      /* Termina nodo:102   */
      /* Termina nodo:68   */

      /* Empieza nodo:113 / Elemento padre: 67   */
      v.add(doc.createElement("table"));
      ((Element)v.get(113)).setAttribute("cellSpacing","0" );
      ((Element)v.get(113)).setAttribute("cellPadding","0" );
      ((Element)v.get(113)).setAttribute("width","99%" );
      ((Element)v.get(113)).setAttribute("align","center" );
      ((Element)v.get(113)).setAttribute("border","0" );
      ((Element)v.get(67)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(114)).setAttribute("align","left" );
      ((Element)v.get(113)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("td"));
      ((Element)v.get(114)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(116)).setAttribute("nombre","lblLote" );
      ((Element)v.get(116)).setAttribute("ancho","155" );
      ((Element)v.get(116)).setAttribute("alto","30" );
      ((Element)v.get(116)).setAttribute("filas","1" );
      ((Element)v.get(116)).setAttribute("id","datosTitle" );
      ((Element)v.get(116)).setAttribute("cod","2470" );
      ((Element)v.get(115)).appendChild((Element)v.get(116));
      /* Termina nodo:116   */
      /* Termina nodo:115   */

      /* Empieza nodo:117 / Elemento padre: 114   */
      v.add(doc.createElement("td"));
      ((Element)v.get(114)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(118)).setAttribute("src","b.gif" );
      ((Element)v.get(118)).setAttribute("width","8" );
      ((Element)v.get(118)).setAttribute("height","8" );
      ((Element)v.get(117)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */
      /* Termina nodo:117   */

      /* Empieza nodo:119 / Elemento padre: 114   */
   }

   private void getXML450(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(119)).setAttribute("align","left" );
      ((Element)v.get(119)).setAttribute("class","datosCampos" );
      ((Element)v.get(119)).setAttribute("tipo","H" );
      ((Element)v.get(114)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(120)).setAttribute("nombre","rdbLote" );
      ((Element)v.get(120)).setAttribute("tipo","H" );
      ((Element)v.get(120)).setAttribute("req","N" );
      ((Element)v.get(120)).setAttribute("id","datosTitleLeft.css" );
      ((Element)v.get(120)).setAttribute("onshtab","pasarFocoAnteriorRDBLotes();" );
      ((Element)v.get(119)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(121)).setAttribute("valor","SI" );
      ((Element)v.get(121)).setAttribute("check","" );
      ((Element)v.get(121)).setAttribute("onfocus","" );
      ((Element)v.get(120)).appendChild((Element)v.get(121));

      /* Elemento padre:121 / Elemento actual: 122   */
      v.add(doc.createTextNode("Si"));
      ((Element)v.get(121)).appendChild((Text)v.get(122));

      /* Termina nodo Texto:122   */
      /* Termina nodo:121   */

      /* Empieza nodo:123 / Elemento padre: 120   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(123)).setAttribute("valor","NO" );
      ((Element)v.get(123)).setAttribute("onfocus","" );
      ((Element)v.get(120)).appendChild((Element)v.get(123));

      /* Elemento padre:123 / Elemento actual: 124   */
      v.add(doc.createTextNode("No"));
      ((Element)v.get(123)).appendChild((Text)v.get(124));

      /* Termina nodo Texto:124   */
      /* Termina nodo:123   */
      /* Termina nodo:120   */
      /* Termina nodo:119   */

      /* Empieza nodo:125 / Elemento padre: 114   */
      v.add(doc.createElement("td"));
      ((Element)v.get(114)).appendChild((Element)v.get(125));
      /* Termina nodo:125   */

      /* Empieza nodo:126 / Elemento padre: 114   */
      v.add(doc.createElement("td"));
      ((Element)v.get(114)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(127)).setAttribute("src","b.gif" );
      ((Element)v.get(127)).setAttribute("width","1060" );
      ((Element)v.get(127)).setAttribute("height","8" );
      ((Element)v.get(126)).appendChild((Element)v.get(127));
      /* Termina nodo:127   */
      /* Termina nodo:126   */

      /* Empieza nodo:128 / Elemento padre: 114   */
      v.add(doc.createElement("td"));
      ((Element)v.get(114)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */
      /* Termina nodo:114   */
      /* Termina nodo:113   */

      /* Empieza nodo:129 / Elemento padre: 67   */
      v.add(doc.createElement("table"));
      ((Element)v.get(129)).setAttribute("cellSpacing","0" );
      ((Element)v.get(129)).setAttribute("cellPadding","0" );
      ((Element)v.get(129)).setAttribute("width","99%" );
      ((Element)v.get(129)).setAttribute("align","center" );
      ((Element)v.get(129)).setAttribute("border","0" );
      ((Element)v.get(67)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(129)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("td"));
      ((Element)v.get(130)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(132)).setAttribute("nombre","lblTipo" );
      ((Element)v.get(132)).setAttribute("ancho","155" );
      ((Element)v.get(132)).setAttribute("alto","30" );
      ((Element)v.get(132)).setAttribute("filas","1" );
      ((Element)v.get(132)).setAttribute("id","datosTitle" );
      ((Element)v.get(132)).setAttribute("cod","2471" );
      ((Element)v.get(131)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */
      /* Termina nodo:131   */

      /* Empieza nodo:133 / Elemento padre: 130   */
      v.add(doc.createElement("td"));
      ((Element)v.get(130)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(134)).setAttribute("src","b.gif" );
      ((Element)v.get(134)).setAttribute("width","8" );
      ((Element)v.get(134)).setAttribute("height","8" );
      ((Element)v.get(133)).appendChild((Element)v.get(134));
      /* Termina nodo:134   */
      /* Termina nodo:133   */

      /* Empieza nodo:135 / Elemento padre: 130   */
      v.add(doc.createElement("td"));
      ((Element)v.get(135)).setAttribute("align","left" );
      ((Element)v.get(135)).setAttribute("class","datosCampos" );
      ((Element)v.get(135)).setAttribute("tipo","H" );
      ((Element)v.get(130)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(136)).setAttribute("nombre","rdbTipo" );
      ((Element)v.get(136)).setAttribute("tipo","H" );
      ((Element)v.get(136)).setAttribute("req","N" );
      ((Element)v.get(136)).setAttribute("id","datosTitleLeft.css" );
      ((Element)v.get(135)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(137)).setAttribute("valor","Producto" );
      ((Element)v.get(137)).setAttribute("check","" );
      ((Element)v.get(137)).setAttribute("onfocus","" );
      ((Element)v.get(136)).appendChild((Element)v.get(137));

      /* Elemento padre:137 / Elemento actual: 138   */
      v.add(doc.createTextNode("Producto"));
      ((Element)v.get(137)).appendChild((Text)v.get(138));

      /* Termina nodo Texto:138   */
      /* Termina nodo:137   */

      /* Empieza nodo:139 / Elemento padre: 136   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(139)).setAttribute("valor","Servicio" );
      ((Element)v.get(139)).setAttribute("onfocus","" );
      ((Element)v.get(136)).appendChild((Element)v.get(139));

      /* Elemento padre:139 / Elemento actual: 140   */
      v.add(doc.createTextNode("Servicio"));
      ((Element)v.get(139)).appendChild((Text)v.get(140));

      /* Termina nodo Texto:140   */
      /* Termina nodo:139   */
      /* Termina nodo:136   */
      /* Termina nodo:135   */

      /* Empieza nodo:141 / Elemento padre: 130   */
      v.add(doc.createElement("td"));
      ((Element)v.get(130)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */

      /* Empieza nodo:142 / Elemento padre: 130   */
      v.add(doc.createElement("td"));
      ((Element)v.get(130)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
   }

   private void getXML540(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(143)).setAttribute("src","b.gif" );
      ((Element)v.get(143)).setAttribute("width","1000" );
      ((Element)v.get(143)).setAttribute("height","8" );
      ((Element)v.get(142)).appendChild((Element)v.get(143));
      /* Termina nodo:143   */
      /* Termina nodo:142   */

      /* Empieza nodo:144 / Elemento padre: 130   */
      v.add(doc.createElement("td"));
      ((Element)v.get(130)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */
      /* Termina nodo:130   */
      /* Termina nodo:129   */

      /* Empieza nodo:145 / Elemento padre: 67   */
      v.add(doc.createElement("table"));
      ((Element)v.get(145)).setAttribute("cellSpacing","0" );
      ((Element)v.get(145)).setAttribute("cellPadding","0" );
      ((Element)v.get(145)).setAttribute("width","99%" );
      ((Element)v.get(145)).setAttribute("align","center" );
      ((Element)v.get(145)).setAttribute("border","0" );
      ((Element)v.get(67)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(145)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("td"));
      ((Element)v.get(146)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(148)).setAttribute("nombre","lblMarca" );
      ((Element)v.get(148)).setAttribute("ancho","155" );
      ((Element)v.get(148)).setAttribute("alto","30" );
      ((Element)v.get(148)).setAttribute("filas","1" );
      ((Element)v.get(148)).setAttribute("id","datosTitle" );
      ((Element)v.get(148)).setAttribute("cod","165" );
      ((Element)v.get(147)).appendChild((Element)v.get(148));
      /* Termina nodo:148   */
      /* Termina nodo:147   */

      /* Empieza nodo:149 / Elemento padre: 146   */
      v.add(doc.createElement("td"));
      ((Element)v.get(146)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(150)).setAttribute("src","b.gif" );
      ((Element)v.get(150)).setAttribute("width","8" );
      ((Element)v.get(150)).setAttribute("height","8" );
      ((Element)v.get(149)).appendChild((Element)v.get(150));
      /* Termina nodo:150   */
      /* Termina nodo:149   */

      /* Empieza nodo:151 / Elemento padre: 146   */
      v.add(doc.createElement("td"));
      ((Element)v.get(146)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(152)).setAttribute("id","estMiCombo30" );
      ((Element)v.get(152)).setAttribute("nombre","cbMarca" );
      ((Element)v.get(152)).setAttribute("size","1" );
      ((Element)v.get(152)).setAttribute("multiple","N" );
      ((Element)v.get(152)).setAttribute("req","N" );
      ((Element)v.get(152)).setAttribute("valorinicial","" );
      ((Element)v.get(152)).setAttribute("textoinicial"," " );
      ((Element)v.get(151)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(152)).appendChild((Element)v.get(153));
      /* Termina nodo:153   */
      /* Termina nodo:152   */
      /* Termina nodo:151   */

      /* Empieza nodo:154 / Elemento padre: 146   */
      v.add(doc.createElement("td"));
      ((Element)v.get(146)).appendChild((Element)v.get(154));
      /* Termina nodo:154   */

      /* Empieza nodo:155 / Elemento padre: 146   */
      v.add(doc.createElement("td"));
      ((Element)v.get(146)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(156)).setAttribute("src","b.gif" );
      ((Element)v.get(156)).setAttribute("width","8" );
      ((Element)v.get(156)).setAttribute("height","8" );
      ((Element)v.get(155)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */
      /* Termina nodo:155   */

      /* Empieza nodo:157 / Elemento padre: 146   */
      v.add(doc.createElement("td"));
      ((Element)v.get(146)).appendChild((Element)v.get(157));
      /* Termina nodo:157   */
      /* Termina nodo:146   */

      /* Empieza nodo:158 / Elemento padre: 145   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(145)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("td"));
      ((Element)v.get(158)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(160)).setAttribute("nombre","lblUnidadDeNegocio" );
      ((Element)v.get(160)).setAttribute("ancho","155" );
      ((Element)v.get(160)).setAttribute("alto","30" );
      ((Element)v.get(160)).setAttribute("filas","1" );
      ((Element)v.get(160)).setAttribute("id","datosTitle" );
      ((Element)v.get(160)).setAttribute("cod","480" );
      ((Element)v.get(159)).appendChild((Element)v.get(160));
      /* Termina nodo:160   */
      /* Termina nodo:159   */

      /* Empieza nodo:161 / Elemento padre: 158   */
      v.add(doc.createElement("td"));
      ((Element)v.get(158)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(162)).setAttribute("src","b.gif" );
      ((Element)v.get(162)).setAttribute("width","8" );
      ((Element)v.get(162)).setAttribute("height","8" );
      ((Element)v.get(161)).appendChild((Element)v.get(162));
      /* Termina nodo:162   */
      /* Termina nodo:161   */

      /* Empieza nodo:163 / Elemento padre: 158   */
      v.add(doc.createElement("td"));
      ((Element)v.get(158)).appendChild((Element)v.get(163));

      /* Empieza nodo:164 / Elemento padre: 163   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(164)).setAttribute("id","estMiCombo40" );
      ((Element)v.get(164)).setAttribute("nombre","cbUnidadDeNegocio" );
      ((Element)v.get(164)).setAttribute("size","1" );
      ((Element)v.get(164)).setAttribute("multiple","N" );
      ((Element)v.get(164)).setAttribute("req","N" );
      ((Element)v.get(164)).setAttribute("valorinicial","" );
      ((Element)v.get(164)).setAttribute("textoinicial"," " );
      ((Element)v.get(163)).appendChild((Element)v.get(164));

      /* Empieza nodo:165 / Elemento padre: 164   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(164)).appendChild((Element)v.get(165));
      /* Termina nodo:165   */
      /* Termina nodo:164   */
      /* Termina nodo:163   */

      /* Empieza nodo:166 / Elemento padre: 158   */
      v.add(doc.createElement("td"));
   }

   private void getXML630(Document doc) {
      ((Element)v.get(158)).appendChild((Element)v.get(166));

      /* Empieza nodo:167 / Elemento padre: 166   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(167)).setAttribute("nombre","lblNegocio" );
      ((Element)v.get(167)).setAttribute("ancho","175" );
      ((Element)v.get(167)).setAttribute("alto","30" );
      ((Element)v.get(167)).setAttribute("filas","1" );
      ((Element)v.get(167)).setAttribute("id","datosTitle" );
      ((Element)v.get(167)).setAttribute("cod","481" );
      ((Element)v.get(166)).appendChild((Element)v.get(167));
      /* Termina nodo:167   */
      /* Termina nodo:166   */

      /* Empieza nodo:168 / Elemento padre: 158   */
      v.add(doc.createElement("td"));
      ((Element)v.get(158)).appendChild((Element)v.get(168));

      /* Empieza nodo:169 / Elemento padre: 168   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(169)).setAttribute("src","b.gif" );
      ((Element)v.get(169)).setAttribute("width","8" );
      ((Element)v.get(169)).setAttribute("height","8" );
      ((Element)v.get(168)).appendChild((Element)v.get(169));
      /* Termina nodo:169   */
      /* Termina nodo:168   */

      /* Empieza nodo:170 / Elemento padre: 158   */
      v.add(doc.createElement("td"));
      ((Element)v.get(158)).appendChild((Element)v.get(170));

      /* Empieza nodo:171 / Elemento padre: 170   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(171)).setAttribute("id","estMiCombo40" );
      ((Element)v.get(171)).setAttribute("nombre","cbNegocio" );
      ((Element)v.get(171)).setAttribute("size","1" );
      ((Element)v.get(171)).setAttribute("multiple","N" );
      ((Element)v.get(171)).setAttribute("req","N" );
      ((Element)v.get(171)).setAttribute("valorinicial","" );
      ((Element)v.get(171)).setAttribute("textoinicial"," " );
      ((Element)v.get(170)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(171)).appendChild((Element)v.get(172));
      /* Termina nodo:172   */
      /* Termina nodo:171   */
      /* Termina nodo:170   */
      /* Termina nodo:158   */

      /* Empieza nodo:173 / Elemento padre: 145   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(145)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("td"));
      ((Element)v.get(173)).appendChild((Element)v.get(174));

      /* Empieza nodo:175 / Elemento padre: 174   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(175)).setAttribute("nombre","lblGenerico" );
      ((Element)v.get(175)).setAttribute("ancho","155" );
      ((Element)v.get(175)).setAttribute("alto","30" );
      ((Element)v.get(175)).setAttribute("filas","1" );
      ((Element)v.get(175)).setAttribute("id","datosTitle" );
      ((Element)v.get(175)).setAttribute("cod","482" );
      ((Element)v.get(174)).appendChild((Element)v.get(175));
      /* Termina nodo:175   */
      /* Termina nodo:174   */

      /* Empieza nodo:176 / Elemento padre: 173   */
      v.add(doc.createElement("td"));
      ((Element)v.get(173)).appendChild((Element)v.get(176));

      /* Empieza nodo:177 / Elemento padre: 176   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(177)).setAttribute("src","b.gif" );
      ((Element)v.get(177)).setAttribute("width","8" );
      ((Element)v.get(177)).setAttribute("height","8" );
      ((Element)v.get(176)).appendChild((Element)v.get(177));
      /* Termina nodo:177   */
      /* Termina nodo:176   */

      /* Empieza nodo:178 / Elemento padre: 173   */
      v.add(doc.createElement("td"));
      ((Element)v.get(173)).appendChild((Element)v.get(178));

      /* Empieza nodo:179 / Elemento padre: 178   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(179)).setAttribute("id","estMiCombo40" );
      ((Element)v.get(179)).setAttribute("nombre","cbGenerico" );
      ((Element)v.get(179)).setAttribute("size","1" );
      ((Element)v.get(179)).setAttribute("multiple","N" );
      ((Element)v.get(179)).setAttribute("req","N" );
      ((Element)v.get(179)).setAttribute("valorinicial","" );
      ((Element)v.get(179)).setAttribute("textoinicial"," " );
      ((Element)v.get(178)).appendChild((Element)v.get(179));

      /* Empieza nodo:180 / Elemento padre: 179   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(179)).appendChild((Element)v.get(180));
      /* Termina nodo:180   */
      /* Termina nodo:179   */
      /* Termina nodo:178   */

      /* Empieza nodo:181 / Elemento padre: 173   */
      v.add(doc.createElement("td"));
      ((Element)v.get(173)).appendChild((Element)v.get(181));

      /* Empieza nodo:182 / Elemento padre: 181   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(182)).setAttribute("nombre","lblSupergenerico" );
      ((Element)v.get(182)).setAttribute("ancho","175" );
      ((Element)v.get(182)).setAttribute("alto","30" );
      ((Element)v.get(182)).setAttribute("filas","1" );
      ((Element)v.get(182)).setAttribute("id","datosTitle" );
      ((Element)v.get(182)).setAttribute("cod","483" );
      ((Element)v.get(181)).appendChild((Element)v.get(182));
      /* Termina nodo:182   */
      /* Termina nodo:181   */

      /* Empieza nodo:183 / Elemento padre: 173   */
      v.add(doc.createElement("td"));
      ((Element)v.get(173)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(184)).setAttribute("src","b.gif" );
      ((Element)v.get(184)).setAttribute("width","8" );
      ((Element)v.get(184)).setAttribute("height","8" );
      ((Element)v.get(183)).appendChild((Element)v.get(184));
      /* Termina nodo:184   */
      /* Termina nodo:183   */

      /* Empieza nodo:185 / Elemento padre: 173   */
      v.add(doc.createElement("td"));
      ((Element)v.get(173)).appendChild((Element)v.get(185));

      /* Empieza nodo:186 / Elemento padre: 185   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(186)).setAttribute("id","estMiCombo40" );
      ((Element)v.get(186)).setAttribute("nombre","cbSupergenerico" );
      ((Element)v.get(186)).setAttribute("size","1" );
      ((Element)v.get(186)).setAttribute("multiple","N" );
      ((Element)v.get(186)).setAttribute("req","N" );
      ((Element)v.get(186)).setAttribute("valorinicial","" );
      ((Element)v.get(186)).setAttribute("textoinicial"," " );
      ((Element)v.get(185)).appendChild((Element)v.get(186));

      /* Empieza nodo:187 / Elemento padre: 186   */
      v.add(doc.createElement("ROWSET"));
   }

   private void getXML720(Document doc) {
      ((Element)v.get(186)).appendChild((Element)v.get(187));
      /* Termina nodo:187   */
      /* Termina nodo:186   */
      /* Termina nodo:185   */
      /* Termina nodo:173   */

      /* Empieza nodo:188 / Elemento padre: 145   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(145)).appendChild((Element)v.get(188));

      /* Empieza nodo:189 / Elemento padre: 188   */
      v.add(doc.createElement("td"));
      ((Element)v.get(188)).appendChild((Element)v.get(189));

      /* Empieza nodo:190 / Elemento padre: 189   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(190)).setAttribute("nombre","lblJerarquia1" );
      ((Element)v.get(190)).setAttribute("ancho","155" );
      ((Element)v.get(190)).setAttribute("alto","30" );
      ((Element)v.get(190)).setAttribute("filas","1" );
      ((Element)v.get(190)).setAttribute("id","datosTitle" );
      ((Element)v.get(190)).setAttribute("cod","314" );
      ((Element)v.get(189)).appendChild((Element)v.get(190));
      /* Termina nodo:190   */
      /* Termina nodo:189   */

      /* Empieza nodo:191 / Elemento padre: 188   */
      v.add(doc.createElement("td"));
      ((Element)v.get(188)).appendChild((Element)v.get(191));

      /* Empieza nodo:192 / Elemento padre: 191   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(192)).setAttribute("src","b.gif" );
      ((Element)v.get(192)).setAttribute("width","8" );
      ((Element)v.get(192)).setAttribute("height","8" );
      ((Element)v.get(191)).appendChild((Element)v.get(192));
      /* Termina nodo:192   */
      /* Termina nodo:191   */

      /* Empieza nodo:193 / Elemento padre: 188   */
      v.add(doc.createElement("td"));
      ((Element)v.get(188)).appendChild((Element)v.get(193));

      /* Empieza nodo:194 / Elemento padre: 193   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(194)).setAttribute("id","datosCamposLeft" );
      ((Element)v.get(194)).setAttribute("nombre","txtJerarquia1" );
      ((Element)v.get(194)).setAttribute("valor","" );
      ((Element)v.get(194)).setAttribute("size","4" );
      ((Element)v.get(194)).setAttribute("max","3" );
      ((Element)v.get(193)).appendChild((Element)v.get(194));
      /* Termina nodo:194   */
      /* Termina nodo:193   */

      /* Empieza nodo:195 / Elemento padre: 188   */
      v.add(doc.createElement("td"));
      ((Element)v.get(188)).appendChild((Element)v.get(195));

      /* Empieza nodo:196 / Elemento padre: 195   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(196)).setAttribute("nombre","lblJerarquia2" );
      ((Element)v.get(196)).setAttribute("ancho","175" );
      ((Element)v.get(196)).setAttribute("alto","30" );
      ((Element)v.get(196)).setAttribute("filas","1" );
      ((Element)v.get(196)).setAttribute("id","datosTitle" );
      ((Element)v.get(196)).setAttribute("cod","315" );
      ((Element)v.get(195)).appendChild((Element)v.get(196));
      /* Termina nodo:196   */
      /* Termina nodo:195   */

      /* Empieza nodo:197 / Elemento padre: 188   */
      v.add(doc.createElement("td"));
      ((Element)v.get(188)).appendChild((Element)v.get(197));

      /* Empieza nodo:198 / Elemento padre: 197   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(198)).setAttribute("src","b.gif" );
      ((Element)v.get(198)).setAttribute("width","8" );
      ((Element)v.get(198)).setAttribute("height","8" );
      ((Element)v.get(197)).appendChild((Element)v.get(198));
      /* Termina nodo:198   */
      /* Termina nodo:197   */

      /* Empieza nodo:199 / Elemento padre: 188   */
      v.add(doc.createElement("td"));
      ((Element)v.get(188)).appendChild((Element)v.get(199));

      /* Empieza nodo:200 / Elemento padre: 199   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(200)).setAttribute("id","datosCamposLeft" );
      ((Element)v.get(200)).setAttribute("nombre","txtJerarquia2" );
      ((Element)v.get(200)).setAttribute("valor","" );
      ((Element)v.get(200)).setAttribute("size","4" );
      ((Element)v.get(200)).setAttribute("max","3" );
      ((Element)v.get(199)).appendChild((Element)v.get(200));
      /* Termina nodo:200   */
      /* Termina nodo:199   */
      /* Termina nodo:188   */

      /* Empieza nodo:201 / Elemento padre: 145   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(145)).appendChild((Element)v.get(201));

      /* Empieza nodo:202 / Elemento padre: 201   */
      v.add(doc.createElement("td"));
      ((Element)v.get(201)).appendChild((Element)v.get(202));

      /* Empieza nodo:203 / Elemento padre: 202   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(203)).setAttribute("nombre","lblJerarquia3" );
      ((Element)v.get(203)).setAttribute("ancho","155" );
      ((Element)v.get(203)).setAttribute("alto","30" );
      ((Element)v.get(203)).setAttribute("filas","1" );
      ((Element)v.get(203)).setAttribute("id","datosTitle" );
      ((Element)v.get(203)).setAttribute("cod","316" );
      ((Element)v.get(202)).appendChild((Element)v.get(203));
      /* Termina nodo:203   */
      /* Termina nodo:202   */

      /* Empieza nodo:204 / Elemento padre: 201   */
      v.add(doc.createElement("td"));
      ((Element)v.get(201)).appendChild((Element)v.get(204));

      /* Empieza nodo:205 / Elemento padre: 204   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(205)).setAttribute("src","b.gif" );
      ((Element)v.get(205)).setAttribute("width","8" );
      ((Element)v.get(205)).setAttribute("height","8" );
      ((Element)v.get(204)).appendChild((Element)v.get(205));
      /* Termina nodo:205   */
      /* Termina nodo:204   */

      /* Empieza nodo:206 / Elemento padre: 201   */
      v.add(doc.createElement("td"));
      ((Element)v.get(201)).appendChild((Element)v.get(206));

      /* Empieza nodo:207 / Elemento padre: 206   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(207)).setAttribute("id","datosCamposLeft" );
      ((Element)v.get(207)).setAttribute("nombre","txtJerarquia3" );
      ((Element)v.get(207)).setAttribute("valor","" );
      ((Element)v.get(207)).setAttribute("size","4" );
      ((Element)v.get(207)).setAttribute("max","3" );
      ((Element)v.get(206)).appendChild((Element)v.get(207));
      /* Termina nodo:207   */
      /* Termina nodo:206   */

      /* Empieza nodo:208 / Elemento padre: 201   */
      v.add(doc.createElement("td"));
      ((Element)v.get(201)).appendChild((Element)v.get(208));
      /* Termina nodo:208   */

      /* Empieza nodo:209 / Elemento padre: 201   */
      v.add(doc.createElement("td"));
      ((Element)v.get(201)).appendChild((Element)v.get(209));

      /* Empieza nodo:210 / Elemento padre: 209   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(210)).setAttribute("src","b.gif" );
      ((Element)v.get(210)).setAttribute("width","8" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(210)).setAttribute("height","8" );
      ((Element)v.get(209)).appendChild((Element)v.get(210));
      /* Termina nodo:210   */
      /* Termina nodo:209   */

      /* Empieza nodo:211 / Elemento padre: 201   */
      v.add(doc.createElement("td"));
      ((Element)v.get(201)).appendChild((Element)v.get(211));
      /* Termina nodo:211   */
      /* Termina nodo:201   */

      /* Empieza nodo:212 / Elemento padre: 145   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(145)).appendChild((Element)v.get(212));

      /* Empieza nodo:213 / Elemento padre: 212   */
      v.add(doc.createElement("td"));
      ((Element)v.get(212)).appendChild((Element)v.get(213));

      /* Empieza nodo:214 / Elemento padre: 213   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(214)).setAttribute("nombre","lblLinea" );
      ((Element)v.get(214)).setAttribute("ancho","155" );
      ((Element)v.get(214)).setAttribute("alto","30" );
      ((Element)v.get(214)).setAttribute("filas","1" );
      ((Element)v.get(214)).setAttribute("id","datosTitle" );
      ((Element)v.get(214)).setAttribute("cod","2473" );
      ((Element)v.get(213)).appendChild((Element)v.get(214));
      /* Termina nodo:214   */
      /* Termina nodo:213   */

      /* Empieza nodo:215 / Elemento padre: 212   */
      v.add(doc.createElement("td"));
      ((Element)v.get(212)).appendChild((Element)v.get(215));

      /* Empieza nodo:216 / Elemento padre: 215   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(216)).setAttribute("src","b.gif" );
      ((Element)v.get(216)).setAttribute("width","8" );
      ((Element)v.get(216)).setAttribute("height","8" );
      ((Element)v.get(215)).appendChild((Element)v.get(216));
      /* Termina nodo:216   */
      /* Termina nodo:215   */

      /* Empieza nodo:217 / Elemento padre: 212   */
      v.add(doc.createElement("td"));
      ((Element)v.get(212)).appendChild((Element)v.get(217));

      /* Empieza nodo:218 / Elemento padre: 217   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(218)).setAttribute("id","estMiCombo40" );
      ((Element)v.get(218)).setAttribute("nombre","cbLinea" );
      ((Element)v.get(218)).setAttribute("size","1" );
      ((Element)v.get(218)).setAttribute("multiple","N" );
      ((Element)v.get(218)).setAttribute("req","N" );
      ((Element)v.get(218)).setAttribute("valorinicial","" );
      ((Element)v.get(218)).setAttribute("textoinicial"," " );
      ((Element)v.get(217)).appendChild((Element)v.get(218));

      /* Empieza nodo:219 / Elemento padre: 218   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(218)).appendChild((Element)v.get(219));
      /* Termina nodo:219   */
      /* Termina nodo:218   */
      /* Termina nodo:217   */

      /* Empieza nodo:220 / Elemento padre: 212   */
      v.add(doc.createElement("td"));
      ((Element)v.get(212)).appendChild((Element)v.get(220));
      /* Termina nodo:220   */

      /* Empieza nodo:221 / Elemento padre: 212   */
      v.add(doc.createElement("td"));
      ((Element)v.get(212)).appendChild((Element)v.get(221));

      /* Empieza nodo:222 / Elemento padre: 221   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(222)).setAttribute("src","b.gif" );
      ((Element)v.get(222)).setAttribute("width","8" );
      ((Element)v.get(222)).setAttribute("height","8" );
      ((Element)v.get(221)).appendChild((Element)v.get(222));
      /* Termina nodo:222   */
      /* Termina nodo:221   */

      /* Empieza nodo:223 / Elemento padre: 212   */
      v.add(doc.createElement("td"));
      ((Element)v.get(212)).appendChild((Element)v.get(223));
      /* Termina nodo:223   */
      /* Termina nodo:212   */

      /* Empieza nodo:224 / Elemento padre: 145   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(145)).appendChild((Element)v.get(224));

      /* Empieza nodo:225 / Elemento padre: 224   */
      v.add(doc.createElement("td"));
      ((Element)v.get(224)).appendChild((Element)v.get(225));

      /* Empieza nodo:226 / Elemento padre: 225   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(226)).setAttribute("nombre","lblAtributo1" );
      ((Element)v.get(226)).setAttribute("ancho","155" );
      ((Element)v.get(226)).setAttribute("alto","30" );
      ((Element)v.get(226)).setAttribute("filas","1" );
      ((Element)v.get(226)).setAttribute("id","datosTitle" );
      ((Element)v.get(226)).setAttribute("cod","189" );
      ((Element)v.get(225)).appendChild((Element)v.get(226));
      /* Termina nodo:226   */
      /* Termina nodo:225   */

      /* Empieza nodo:227 / Elemento padre: 224   */
      v.add(doc.createElement("td"));
      ((Element)v.get(224)).appendChild((Element)v.get(227));

      /* Empieza nodo:228 / Elemento padre: 227   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(228)).setAttribute("src","b.gif" );
      ((Element)v.get(228)).setAttribute("width","8" );
      ((Element)v.get(228)).setAttribute("height","8" );
      ((Element)v.get(227)).appendChild((Element)v.get(228));
      /* Termina nodo:228   */
      /* Termina nodo:227   */

      /* Empieza nodo:229 / Elemento padre: 224   */
      v.add(doc.createElement("td"));
      ((Element)v.get(224)).appendChild((Element)v.get(229));

      /* Empieza nodo:230 / Elemento padre: 229   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(230)).setAttribute("id","datosCamposLeft" );
      ((Element)v.get(230)).setAttribute("nombre","txtAtributo1" );
      ((Element)v.get(230)).setAttribute("valor","" );
      ((Element)v.get(230)).setAttribute("size","4" );
      ((Element)v.get(230)).setAttribute("max","3" );
      ((Element)v.get(229)).appendChild((Element)v.get(230));
      /* Termina nodo:230   */
      /* Termina nodo:229   */

      /* Empieza nodo:231 / Elemento padre: 224   */
      v.add(doc.createElement("td"));
      ((Element)v.get(224)).appendChild((Element)v.get(231));

      /* Empieza nodo:232 / Elemento padre: 231   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(232)).setAttribute("nombre","lblAtributo2" );
      ((Element)v.get(232)).setAttribute("ancho","175" );
      ((Element)v.get(232)).setAttribute("alto","30" );
      ((Element)v.get(232)).setAttribute("filas","1" );
      ((Element)v.get(232)).setAttribute("id","datosTitle" );
      ((Element)v.get(232)).setAttribute("cod","190" );
      ((Element)v.get(231)).appendChild((Element)v.get(232));
      /* Termina nodo:232   */
      /* Termina nodo:231   */

      /* Empieza nodo:233 / Elemento padre: 224   */
      v.add(doc.createElement("td"));
      ((Element)v.get(224)).appendChild((Element)v.get(233));

      /* Empieza nodo:234 / Elemento padre: 233   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(234)).setAttribute("src","b.gif" );
      ((Element)v.get(234)).setAttribute("width","8" );
   }

   private void getXML900(Document doc) {
      ((Element)v.get(234)).setAttribute("height","8" );
      ((Element)v.get(233)).appendChild((Element)v.get(234));
      /* Termina nodo:234   */
      /* Termina nodo:233   */

      /* Empieza nodo:235 / Elemento padre: 224   */
      v.add(doc.createElement("td"));
      ((Element)v.get(224)).appendChild((Element)v.get(235));

      /* Empieza nodo:236 / Elemento padre: 235   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(236)).setAttribute("id","datosCamposLeft" );
      ((Element)v.get(236)).setAttribute("nombre","txtAtributo2" );
      ((Element)v.get(236)).setAttribute("valor","" );
      ((Element)v.get(236)).setAttribute("size","6" );
      ((Element)v.get(236)).setAttribute("max","4" );
      ((Element)v.get(235)).appendChild((Element)v.get(236));
      /* Termina nodo:236   */
      /* Termina nodo:235   */
      /* Termina nodo:224   */

      /* Empieza nodo:237 / Elemento padre: 145   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(145)).appendChild((Element)v.get(237));

      /* Empieza nodo:238 / Elemento padre: 237   */
      v.add(doc.createElement("td"));
      ((Element)v.get(237)).appendChild((Element)v.get(238));

      /* Empieza nodo:239 / Elemento padre: 238   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(239)).setAttribute("nombre","lblAtributo3" );
      ((Element)v.get(239)).setAttribute("ancho","155" );
      ((Element)v.get(239)).setAttribute("alto","30" );
      ((Element)v.get(239)).setAttribute("filas","1" );
      ((Element)v.get(239)).setAttribute("id","datosTitle" );
      ((Element)v.get(239)).setAttribute("cod","191" );
      ((Element)v.get(238)).appendChild((Element)v.get(239));
      /* Termina nodo:239   */
      /* Termina nodo:238   */

      /* Empieza nodo:240 / Elemento padre: 237   */
      v.add(doc.createElement("td"));
      ((Element)v.get(237)).appendChild((Element)v.get(240));

      /* Empieza nodo:241 / Elemento padre: 240   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(241)).setAttribute("src","b.gif" );
      ((Element)v.get(241)).setAttribute("width","8" );
      ((Element)v.get(241)).setAttribute("height","8" );
      ((Element)v.get(240)).appendChild((Element)v.get(241));
      /* Termina nodo:241   */
      /* Termina nodo:240   */

      /* Empieza nodo:242 / Elemento padre: 237   */
      v.add(doc.createElement("td"));
      ((Element)v.get(237)).appendChild((Element)v.get(242));

      /* Empieza nodo:243 / Elemento padre: 242   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(243)).setAttribute("id","datosCamposLeft" );
      ((Element)v.get(243)).setAttribute("nombre","txtAtributo3" );
      ((Element)v.get(243)).setAttribute("valor","" );
      ((Element)v.get(243)).setAttribute("size","16" );
      ((Element)v.get(243)).setAttribute("max","10" );
      ((Element)v.get(242)).appendChild((Element)v.get(243));
      /* Termina nodo:243   */
      /* Termina nodo:242   */

      /* Empieza nodo:244 / Elemento padre: 237   */
      v.add(doc.createElement("td"));
      ((Element)v.get(237)).appendChild((Element)v.get(244));
      /* Termina nodo:244   */

      /* Empieza nodo:245 / Elemento padre: 237   */
      v.add(doc.createElement("td"));
      ((Element)v.get(237)).appendChild((Element)v.get(245));

      /* Empieza nodo:246 / Elemento padre: 245   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(246)).setAttribute("src","b.gif" );
      ((Element)v.get(246)).setAttribute("width","8" );
      ((Element)v.get(246)).setAttribute("height","8" );
      ((Element)v.get(245)).appendChild((Element)v.get(246));
      /* Termina nodo:246   */
      /* Termina nodo:245   */

      /* Empieza nodo:247 / Elemento padre: 237   */
      v.add(doc.createElement("td"));
      ((Element)v.get(237)).appendChild((Element)v.get(247));
      /* Termina nodo:247   */
      /* Termina nodo:237   */

      /* Empieza nodo:248 / Elemento padre: 145   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(145)).appendChild((Element)v.get(248));

      /* Empieza nodo:249 / Elemento padre: 248   */
      v.add(doc.createElement("td"));
      ((Element)v.get(248)).appendChild((Element)v.get(249));

      /* Empieza nodo:250 / Elemento padre: 249   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(250)).setAttribute("nombre","lblDimensionAlto" );
      ((Element)v.get(250)).setAttribute("ancho","155" );
      ((Element)v.get(250)).setAttribute("alto","30" );
      ((Element)v.get(250)).setAttribute("filas","1" );
      ((Element)v.get(250)).setAttribute("id","datosTitle" );
      ((Element)v.get(250)).setAttribute("cod","2474" );
      ((Element)v.get(249)).appendChild((Element)v.get(250));
      /* Termina nodo:250   */
      /* Termina nodo:249   */

      /* Empieza nodo:251 / Elemento padre: 248   */
      v.add(doc.createElement("td"));
      ((Element)v.get(248)).appendChild((Element)v.get(251));

      /* Empieza nodo:252 / Elemento padre: 251   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(252)).setAttribute("src","b.gif" );
      ((Element)v.get(252)).setAttribute("width","8" );
      ((Element)v.get(252)).setAttribute("height","8" );
      ((Element)v.get(251)).appendChild((Element)v.get(252));
      /* Termina nodo:252   */
      /* Termina nodo:251   */

      /* Empieza nodo:253 / Elemento padre: 248   */
      v.add(doc.createElement("td"));
      ((Element)v.get(248)).appendChild((Element)v.get(253));

      /* Empieza nodo:254 / Elemento padre: 253   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(254)).setAttribute("id","datosCamposLeft" );
      ((Element)v.get(254)).setAttribute("nombre","txtAlto" );
      ((Element)v.get(254)).setAttribute("valor","" );
      ((Element)v.get(254)).setAttribute("size","18" );
      ((Element)v.get(254)).setAttribute("max","11" );
      ((Element)v.get(253)).appendChild((Element)v.get(254));
      /* Termina nodo:254   */
      /* Termina nodo:253   */

      /* Empieza nodo:255 / Elemento padre: 248   */
      v.add(doc.createElement("td"));
      ((Element)v.get(248)).appendChild((Element)v.get(255));

      /* Empieza nodo:256 / Elemento padre: 255   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(256)).setAttribute("nombre","lblDimensionLargo" );
      ((Element)v.get(256)).setAttribute("ancho","175" );
      ((Element)v.get(256)).setAttribute("alto","30" );
      ((Element)v.get(256)).setAttribute("filas","1" );
      ((Element)v.get(256)).setAttribute("id","datosTitle" );
      ((Element)v.get(256)).setAttribute("cod","2475" );
      ((Element)v.get(255)).appendChild((Element)v.get(256));
      /* Termina nodo:256   */
      /* Termina nodo:255   */

      /* Empieza nodo:257 / Elemento padre: 248   */
      v.add(doc.createElement("td"));
      ((Element)v.get(248)).appendChild((Element)v.get(257));

      /* Empieza nodo:258 / Elemento padre: 257   */
   }

   private void getXML990(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(258)).setAttribute("src","b.gif" );
      ((Element)v.get(258)).setAttribute("width","8" );
      ((Element)v.get(258)).setAttribute("height","8" );
      ((Element)v.get(257)).appendChild((Element)v.get(258));
      /* Termina nodo:258   */
      /* Termina nodo:257   */

      /* Empieza nodo:259 / Elemento padre: 248   */
      v.add(doc.createElement("td"));
      ((Element)v.get(248)).appendChild((Element)v.get(259));

      /* Empieza nodo:260 / Elemento padre: 259   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(260)).setAttribute("id","datosCamposLeft" );
      ((Element)v.get(260)).setAttribute("nombre","txtLargo" );
      ((Element)v.get(260)).setAttribute("valor","" );
      ((Element)v.get(260)).setAttribute("size","18" );
      ((Element)v.get(260)).setAttribute("max","11" );
      ((Element)v.get(259)).appendChild((Element)v.get(260));
      /* Termina nodo:260   */
      /* Termina nodo:259   */
      /* Termina nodo:248   */

      /* Empieza nodo:261 / Elemento padre: 145   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(145)).appendChild((Element)v.get(261));

      /* Empieza nodo:262 / Elemento padre: 261   */
      v.add(doc.createElement("td"));
      ((Element)v.get(261)).appendChild((Element)v.get(262));

      /* Empieza nodo:263 / Elemento padre: 262   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(263)).setAttribute("nombre","lblDimensionAncho" );
      ((Element)v.get(263)).setAttribute("ancho","155" );
      ((Element)v.get(263)).setAttribute("alto","30" );
      ((Element)v.get(263)).setAttribute("filas","1" );
      ((Element)v.get(263)).setAttribute("id","datosTitle" );
      ((Element)v.get(263)).setAttribute("cod","2476" );
      ((Element)v.get(262)).appendChild((Element)v.get(263));
      /* Termina nodo:263   */
      /* Termina nodo:262   */

      /* Empieza nodo:264 / Elemento padre: 261   */
      v.add(doc.createElement("td"));
      ((Element)v.get(261)).appendChild((Element)v.get(264));

      /* Empieza nodo:265 / Elemento padre: 264   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(265)).setAttribute("src","b.gif" );
      ((Element)v.get(265)).setAttribute("width","8" );
      ((Element)v.get(265)).setAttribute("height","8" );
      ((Element)v.get(264)).appendChild((Element)v.get(265));
      /* Termina nodo:265   */
      /* Termina nodo:264   */

      /* Empieza nodo:266 / Elemento padre: 261   */
      v.add(doc.createElement("td"));
      ((Element)v.get(261)).appendChild((Element)v.get(266));

      /* Empieza nodo:267 / Elemento padre: 266   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(267)).setAttribute("id","datosCamposLeft" );
      ((Element)v.get(267)).setAttribute("nombre","txtAncho" );
      ((Element)v.get(267)).setAttribute("valor","" );
      ((Element)v.get(267)).setAttribute("size","18" );
      ((Element)v.get(267)).setAttribute("max","11" );
      ((Element)v.get(266)).appendChild((Element)v.get(267));
      /* Termina nodo:267   */
      /* Termina nodo:266   */

      /* Empieza nodo:268 / Elemento padre: 261   */
      v.add(doc.createElement("td"));
      ((Element)v.get(261)).appendChild((Element)v.get(268));

      /* Empieza nodo:269 / Elemento padre: 268   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(269)).setAttribute("nombre","lblUdDeMedidaDimensiones" );
      ((Element)v.get(269)).setAttribute("ancho","175" );
      ((Element)v.get(269)).setAttribute("alto","30" );
      ((Element)v.get(269)).setAttribute("filas","1" );
      ((Element)v.get(269)).setAttribute("id","datosTitle" );
      ((Element)v.get(269)).setAttribute("cod","2477" );
      ((Element)v.get(268)).appendChild((Element)v.get(269));
      /* Termina nodo:269   */
      /* Termina nodo:268   */

      /* Empieza nodo:270 / Elemento padre: 261   */
      v.add(doc.createElement("td"));
      ((Element)v.get(261)).appendChild((Element)v.get(270));

      /* Empieza nodo:271 / Elemento padre: 270   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(271)).setAttribute("src","b.gif" );
      ((Element)v.get(271)).setAttribute("width","8" );
      ((Element)v.get(271)).setAttribute("height","8" );
      ((Element)v.get(270)).appendChild((Element)v.get(271));
      /* Termina nodo:271   */
      /* Termina nodo:270   */

      /* Empieza nodo:272 / Elemento padre: 261   */
      v.add(doc.createElement("td"));
      ((Element)v.get(261)).appendChild((Element)v.get(272));

      /* Empieza nodo:273 / Elemento padre: 272   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(273)).setAttribute("id","estMiCombo30" );
      ((Element)v.get(273)).setAttribute("nombre","cbUdDeMedidaDimensiones" );
      ((Element)v.get(273)).setAttribute("size","1" );
      ((Element)v.get(273)).setAttribute("multiple","N" );
      ((Element)v.get(273)).setAttribute("req","N" );
      ((Element)v.get(273)).setAttribute("valorinicial","" );
      ((Element)v.get(273)).setAttribute("textoinicial"," " );
      ((Element)v.get(272)).appendChild((Element)v.get(273));

      /* Empieza nodo:274 / Elemento padre: 273   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(273)).appendChild((Element)v.get(274));
      /* Termina nodo:274   */
      /* Termina nodo:273   */
      /* Termina nodo:272   */
      /* Termina nodo:261   */

      /* Empieza nodo:275 / Elemento padre: 145   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(145)).appendChild((Element)v.get(275));

      /* Empieza nodo:276 / Elemento padre: 275   */
      v.add(doc.createElement("td"));
      ((Element)v.get(275)).appendChild((Element)v.get(276));

      /* Empieza nodo:277 / Elemento padre: 276   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(277)).setAttribute("nombre","lblVolumen" );
      ((Element)v.get(277)).setAttribute("ancho","155" );
      ((Element)v.get(277)).setAttribute("alto","30" );
      ((Element)v.get(277)).setAttribute("filas","1" );
      ((Element)v.get(277)).setAttribute("id","datosTitle" );
      ((Element)v.get(277)).setAttribute("cod","2478" );
      ((Element)v.get(276)).appendChild((Element)v.get(277));
      /* Termina nodo:277   */
      /* Termina nodo:276   */

      /* Empieza nodo:278 / Elemento padre: 275   */
      v.add(doc.createElement("td"));
      ((Element)v.get(275)).appendChild((Element)v.get(278));

      /* Empieza nodo:279 / Elemento padre: 278   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(279)).setAttribute("src","b.gif" );
      ((Element)v.get(279)).setAttribute("width","8" );
      ((Element)v.get(279)).setAttribute("height","8" );
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(278)).appendChild((Element)v.get(279));
      /* Termina nodo:279   */
      /* Termina nodo:278   */

      /* Empieza nodo:280 / Elemento padre: 275   */
      v.add(doc.createElement("td"));
      ((Element)v.get(275)).appendChild((Element)v.get(280));

      /* Empieza nodo:281 / Elemento padre: 280   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(281)).setAttribute("id","datosCamposLeft" );
      ((Element)v.get(281)).setAttribute("nombre","txtVolumen" );
      ((Element)v.get(281)).setAttribute("valor","" );
      ((Element)v.get(281)).setAttribute("size","36" );
      ((Element)v.get(281)).setAttribute("max","21" );
      ((Element)v.get(280)).appendChild((Element)v.get(281));
      /* Termina nodo:281   */
      /* Termina nodo:280   */

      /* Empieza nodo:282 / Elemento padre: 275   */
      v.add(doc.createElement("td"));
      ((Element)v.get(275)).appendChild((Element)v.get(282));
      /* Termina nodo:282   */

      /* Empieza nodo:283 / Elemento padre: 275   */
      v.add(doc.createElement("td"));
      ((Element)v.get(275)).appendChild((Element)v.get(283));

      /* Empieza nodo:284 / Elemento padre: 283   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(284)).setAttribute("src","b.gif" );
      ((Element)v.get(284)).setAttribute("width","8" );
      ((Element)v.get(284)).setAttribute("height","8" );
      ((Element)v.get(283)).appendChild((Element)v.get(284));
      /* Termina nodo:284   */
      /* Termina nodo:283   */

      /* Empieza nodo:285 / Elemento padre: 275   */
      v.add(doc.createElement("td"));
      ((Element)v.get(275)).appendChild((Element)v.get(285));
      /* Termina nodo:285   */
      /* Termina nodo:275   */

      /* Empieza nodo:286 / Elemento padre: 145   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(145)).appendChild((Element)v.get(286));

      /* Empieza nodo:287 / Elemento padre: 286   */
      v.add(doc.createElement("td"));
      ((Element)v.get(286)).appendChild((Element)v.get(287));

      /* Empieza nodo:288 / Elemento padre: 287   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(288)).setAttribute("nombre","lblPeso" );
      ((Element)v.get(288)).setAttribute("ancho","155" );
      ((Element)v.get(288)).setAttribute("alto","30" );
      ((Element)v.get(288)).setAttribute("filas","1" );
      ((Element)v.get(288)).setAttribute("id","datosTitle" );
      ((Element)v.get(288)).setAttribute("cod","350" );
      ((Element)v.get(287)).appendChild((Element)v.get(288));
      /* Termina nodo:288   */
      /* Termina nodo:287   */

      /* Empieza nodo:289 / Elemento padre: 286   */
      v.add(doc.createElement("td"));
      ((Element)v.get(286)).appendChild((Element)v.get(289));

      /* Empieza nodo:290 / Elemento padre: 289   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(290)).setAttribute("src","b.gif" );
      ((Element)v.get(290)).setAttribute("width","8" );
      ((Element)v.get(290)).setAttribute("height","8" );
      ((Element)v.get(289)).appendChild((Element)v.get(290));
      /* Termina nodo:290   */
      /* Termina nodo:289   */

      /* Empieza nodo:291 / Elemento padre: 286   */
      v.add(doc.createElement("td"));
      ((Element)v.get(286)).appendChild((Element)v.get(291));

      /* Empieza nodo:292 / Elemento padre: 291   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(292)).setAttribute("id","datosCamposLeft" );
      ((Element)v.get(292)).setAttribute("nombre","txtPeso" );
      ((Element)v.get(292)).setAttribute("valor","" );
      ((Element)v.get(292)).setAttribute("size","18" );
      ((Element)v.get(292)).setAttribute("max","11" );
      ((Element)v.get(291)).appendChild((Element)v.get(292));
      /* Termina nodo:292   */
      /* Termina nodo:291   */

      /* Empieza nodo:293 / Elemento padre: 286   */
      v.add(doc.createElement("td"));
      ((Element)v.get(286)).appendChild((Element)v.get(293));

      /* Empieza nodo:294 / Elemento padre: 293   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(294)).setAttribute("nombre","lblUnidadMedidaPeso" );
      ((Element)v.get(294)).setAttribute("ancho","175" );
      ((Element)v.get(294)).setAttribute("alto","30" );
      ((Element)v.get(294)).setAttribute("filas","1" );
      ((Element)v.get(294)).setAttribute("id","datosTitle" );
      ((Element)v.get(294)).setAttribute("cod","2479" );
      ((Element)v.get(293)).appendChild((Element)v.get(294));
      /* Termina nodo:294   */
      /* Termina nodo:293   */

      /* Empieza nodo:295 / Elemento padre: 286   */
      v.add(doc.createElement("td"));
      ((Element)v.get(286)).appendChild((Element)v.get(295));

      /* Empieza nodo:296 / Elemento padre: 295   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(296)).setAttribute("src","b.gif" );
      ((Element)v.get(296)).setAttribute("width","8" );
      ((Element)v.get(296)).setAttribute("height","8" );
      ((Element)v.get(295)).appendChild((Element)v.get(296));
      /* Termina nodo:296   */
      /* Termina nodo:295   */

      /* Empieza nodo:297 / Elemento padre: 286   */
      v.add(doc.createElement("td"));
      ((Element)v.get(286)).appendChild((Element)v.get(297));

      /* Empieza nodo:298 / Elemento padre: 297   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(298)).setAttribute("id","estMiCombo40" );
      ((Element)v.get(298)).setAttribute("nombre","cbUnidadMedidaPeso" );
      ((Element)v.get(298)).setAttribute("size","1" );
      ((Element)v.get(298)).setAttribute("multiple","N" );
      ((Element)v.get(298)).setAttribute("req","N" );
      ((Element)v.get(298)).setAttribute("valorinicial","" );
      ((Element)v.get(298)).setAttribute("textoinicial"," " );
      ((Element)v.get(297)).appendChild((Element)v.get(298));

      /* Empieza nodo:299 / Elemento padre: 298   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(298)).appendChild((Element)v.get(299));
      /* Termina nodo:299   */
      /* Termina nodo:298   */
      /* Termina nodo:297   */
      /* Termina nodo:286   */

      /* Empieza nodo:300 / Elemento padre: 145   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(145)).appendChild((Element)v.get(300));

      /* Empieza nodo:301 / Elemento padre: 300   */
      v.add(doc.createElement("td"));
      ((Element)v.get(300)).appendChild((Element)v.get(301));

      /* Empieza nodo:302 / Elemento padre: 301   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(302)).setAttribute("nombre","lblUnidadesDentroDePedido" );
      ((Element)v.get(302)).setAttribute("ancho","155" );
      ((Element)v.get(302)).setAttribute("alto","30" );
      ((Element)v.get(302)).setAttribute("filas","1" );
      ((Element)v.get(302)).setAttribute("id","datosTitle" );
      ((Element)v.get(302)).setAttribute("cod","2480" );
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(301)).appendChild((Element)v.get(302));
      /* Termina nodo:302   */
      /* Termina nodo:301   */

      /* Empieza nodo:303 / Elemento padre: 300   */
      v.add(doc.createElement("td"));
      ((Element)v.get(300)).appendChild((Element)v.get(303));

      /* Empieza nodo:304 / Elemento padre: 303   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(304)).setAttribute("src","b.gif" );
      ((Element)v.get(304)).setAttribute("width","8" );
      ((Element)v.get(304)).setAttribute("height","8" );
      ((Element)v.get(303)).appendChild((Element)v.get(304));
      /* Termina nodo:304   */
      /* Termina nodo:303   */

      /* Empieza nodo:305 / Elemento padre: 300   */
      v.add(doc.createElement("td"));
      ((Element)v.get(300)).appendChild((Element)v.get(305));

      /* Empieza nodo:306 / Elemento padre: 305   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(306)).setAttribute("id","datosCamposLeft" );
      ((Element)v.get(306)).setAttribute("nombre","txtUdDentroPedido" );
      ((Element)v.get(306)).setAttribute("valor","" );
      ((Element)v.get(306)).setAttribute("size","4" );
      ((Element)v.get(306)).setAttribute("max","3" );
      ((Element)v.get(305)).appendChild((Element)v.get(306));
      /* Termina nodo:306   */
      /* Termina nodo:305   */

      /* Empieza nodo:307 / Elemento padre: 300   */
      v.add(doc.createElement("td"));
      ((Element)v.get(300)).appendChild((Element)v.get(307));

      /* Empieza nodo:308 / Elemento padre: 307   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(308)).setAttribute("nombre","lblUnidadesPorCaja" );
      ((Element)v.get(308)).setAttribute("ancho","175" );
      ((Element)v.get(308)).setAttribute("alto","30" );
      ((Element)v.get(308)).setAttribute("filas","1" );
      ((Element)v.get(308)).setAttribute("id","datosTitle" );
      ((Element)v.get(308)).setAttribute("cod","2481" );
      ((Element)v.get(307)).appendChild((Element)v.get(308));
      /* Termina nodo:308   */
      /* Termina nodo:307   */

      /* Empieza nodo:309 / Elemento padre: 300   */
      v.add(doc.createElement("td"));
      ((Element)v.get(300)).appendChild((Element)v.get(309));

      /* Empieza nodo:310 / Elemento padre: 309   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(310)).setAttribute("src","b.gif" );
      ((Element)v.get(310)).setAttribute("width","8" );
      ((Element)v.get(310)).setAttribute("height","8" );
      ((Element)v.get(309)).appendChild((Element)v.get(310));
      /* Termina nodo:310   */
      /* Termina nodo:309   */

      /* Empieza nodo:311 / Elemento padre: 300   */
      v.add(doc.createElement("td"));
      ((Element)v.get(300)).appendChild((Element)v.get(311));

      /* Empieza nodo:312 / Elemento padre: 311   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(312)).setAttribute("id","datosCamposLeft" );
      ((Element)v.get(312)).setAttribute("nombre","txtUnidadesPorCaja" );
      ((Element)v.get(312)).setAttribute("valor","" );
      ((Element)v.get(312)).setAttribute("size","7" );
      ((Element)v.get(312)).setAttribute("max","5" );
      ((Element)v.get(311)).appendChild((Element)v.get(312));
      /* Termina nodo:312   */
      /* Termina nodo:311   */
      /* Termina nodo:300   */

      /* Empieza nodo:313 / Elemento padre: 145   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(145)).appendChild((Element)v.get(313));

      /* Empieza nodo:314 / Elemento padre: 313   */
      v.add(doc.createElement("td"));
      ((Element)v.get(313)).appendChild((Element)v.get(314));

      /* Empieza nodo:315 / Elemento padre: 314   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(315)).setAttribute("nombre","lblUnidadMedidaVenta" );
      ((Element)v.get(315)).setAttribute("ancho","155" );
      ((Element)v.get(315)).setAttribute("alto","30" );
      ((Element)v.get(315)).setAttribute("filas","1" );
      ((Element)v.get(315)).setAttribute("id","datosTitle" );
      ((Element)v.get(315)).setAttribute("cod","2482" );
      ((Element)v.get(314)).appendChild((Element)v.get(315));
      /* Termina nodo:315   */
      /* Termina nodo:314   */

      /* Empieza nodo:316 / Elemento padre: 313   */
      v.add(doc.createElement("td"));
      ((Element)v.get(313)).appendChild((Element)v.get(316));

      /* Empieza nodo:317 / Elemento padre: 316   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(317)).setAttribute("src","b.gif" );
      ((Element)v.get(317)).setAttribute("width","8" );
      ((Element)v.get(317)).setAttribute("height","8" );
      ((Element)v.get(316)).appendChild((Element)v.get(317));
      /* Termina nodo:317   */
      /* Termina nodo:316   */

      /* Empieza nodo:318 / Elemento padre: 313   */
      v.add(doc.createElement("td"));
      ((Element)v.get(313)).appendChild((Element)v.get(318));

      /* Empieza nodo:319 / Elemento padre: 318   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(319)).setAttribute("id","estMiCombo40" );
      ((Element)v.get(319)).setAttribute("nombre","cbUnidadMedidaVenta" );
      ((Element)v.get(319)).setAttribute("size","1" );
      ((Element)v.get(319)).setAttribute("multiple","N" );
      ((Element)v.get(319)).setAttribute("req","N" );
      ((Element)v.get(319)).setAttribute("valorinicial","" );
      ((Element)v.get(319)).setAttribute("textoinicial"," " );
      ((Element)v.get(318)).appendChild((Element)v.get(319));

      /* Empieza nodo:320 / Elemento padre: 319   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(319)).appendChild((Element)v.get(320));
      /* Termina nodo:320   */
      /* Termina nodo:319   */
      /* Termina nodo:318   */

      /* Empieza nodo:321 / Elemento padre: 313   */
      v.add(doc.createElement("td"));
      ((Element)v.get(313)).appendChild((Element)v.get(321));
      /* Termina nodo:321   */

      /* Empieza nodo:322 / Elemento padre: 313   */
      v.add(doc.createElement("td"));
      ((Element)v.get(313)).appendChild((Element)v.get(322));

      /* Empieza nodo:323 / Elemento padre: 322   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(323)).setAttribute("src","b.gif" );
      ((Element)v.get(323)).setAttribute("width","8" );
      ((Element)v.get(323)).setAttribute("height","8" );
      ((Element)v.get(322)).appendChild((Element)v.get(323));
      /* Termina nodo:323   */
      /* Termina nodo:322   */

      /* Empieza nodo:324 / Elemento padre: 313   */
      v.add(doc.createElement("td"));
      ((Element)v.get(313)).appendChild((Element)v.get(324));
      /* Termina nodo:324   */
      /* Termina nodo:313   */

      /* Empieza nodo:325 / Elemento padre: 145   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(145)).appendChild((Element)v.get(325));

      /* Empieza nodo:326 / Elemento padre: 325   */
      v.add(doc.createElement("td"));
      ((Element)v.get(325)).appendChild((Element)v.get(326));

      /* Empieza nodo:327 / Elemento padre: 326   */
   }

   private void getXML1260(Document doc) {
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(327)).setAttribute("nombre","lblCosteEstandar" );
      ((Element)v.get(327)).setAttribute("ancho","155" );
      ((Element)v.get(327)).setAttribute("alto","30" );
      ((Element)v.get(327)).setAttribute("filas","1" );
      ((Element)v.get(327)).setAttribute("id","datosTitle" );
      ((Element)v.get(327)).setAttribute("cod","2483" );
      ((Element)v.get(326)).appendChild((Element)v.get(327));
      /* Termina nodo:327   */
      /* Termina nodo:326   */

      /* Empieza nodo:328 / Elemento padre: 325   */
      v.add(doc.createElement("td"));
      ((Element)v.get(325)).appendChild((Element)v.get(328));

      /* Empieza nodo:329 / Elemento padre: 328   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(329)).setAttribute("src","b.gif" );
      ((Element)v.get(329)).setAttribute("width","8" );
      ((Element)v.get(329)).setAttribute("height","8" );
      ((Element)v.get(328)).appendChild((Element)v.get(329));
      /* Termina nodo:329   */
      /* Termina nodo:328   */

      /* Empieza nodo:330 / Elemento padre: 325   */
      v.add(doc.createElement("td"));
      ((Element)v.get(325)).appendChild((Element)v.get(330));

      /* Empieza nodo:331 / Elemento padre: 330   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(331)).setAttribute("id","datosCamposLeft" );
      ((Element)v.get(331)).setAttribute("nombre","txtCosteEstandar" );
      ((Element)v.get(331)).setAttribute("valor","" );
      ((Element)v.get(331)).setAttribute("size","29" );
      ((Element)v.get(331)).setAttribute("max","17" );
      ((Element)v.get(330)).appendChild((Element)v.get(331));
      /* Termina nodo:331   */
      /* Termina nodo:330   */

      /* Empieza nodo:332 / Elemento padre: 325   */
      v.add(doc.createElement("td"));
      ((Element)v.get(325)).appendChild((Element)v.get(332));

      /* Empieza nodo:333 / Elemento padre: 332   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(333)).setAttribute("nombre","lblPrecioPosicionamiento" );
      ((Element)v.get(333)).setAttribute("ancho","175" );
      ((Element)v.get(333)).setAttribute("alto","30" );
      ((Element)v.get(333)).setAttribute("filas","1" );
      ((Element)v.get(333)).setAttribute("id","datosTitle" );
      ((Element)v.get(333)).setAttribute("cod","2484" );
      ((Element)v.get(332)).appendChild((Element)v.get(333));
      /* Termina nodo:333   */
      /* Termina nodo:332   */

      /* Empieza nodo:334 / Elemento padre: 325   */
      v.add(doc.createElement("td"));
      ((Element)v.get(325)).appendChild((Element)v.get(334));

      /* Empieza nodo:335 / Elemento padre: 334   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(335)).setAttribute("src","b.gif" );
      ((Element)v.get(335)).setAttribute("width","8" );
      ((Element)v.get(335)).setAttribute("height","8" );
      ((Element)v.get(334)).appendChild((Element)v.get(335));
      /* Termina nodo:335   */
      /* Termina nodo:334   */

      /* Empieza nodo:336 / Elemento padre: 325   */
      v.add(doc.createElement("td"));
      ((Element)v.get(325)).appendChild((Element)v.get(336));

      /* Empieza nodo:337 / Elemento padre: 336   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(337)).setAttribute("id","datosCamposLeft" );
      ((Element)v.get(337)).setAttribute("nombre","txtPrecioPosicionamiento" );
      ((Element)v.get(337)).setAttribute("valor","" );
      ((Element)v.get(337)).setAttribute("size","29" );
      ((Element)v.get(337)).setAttribute("max","17" );
      ((Element)v.get(336)).appendChild((Element)v.get(337));
      /* Termina nodo:337   */
      /* Termina nodo:336   */
      /* Termina nodo:325   */
      /* Termina nodo:145   */

      /* Empieza nodo:338 / Elemento padre: 67   */
      v.add(doc.createElement("table"));
      ((Element)v.get(338)).setAttribute("cellSpacing","0" );
      ((Element)v.get(338)).setAttribute("cellPadding","0" );
      ((Element)v.get(338)).setAttribute("width","99%" );
      ((Element)v.get(338)).setAttribute("align","center" );
      ((Element)v.get(338)).setAttribute("border","0" );
      ((Element)v.get(67)).appendChild((Element)v.get(338));

      /* Empieza nodo:339 / Elemento padre: 338   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(338)).appendChild((Element)v.get(339));

      /* Empieza nodo:340 / Elemento padre: 339   */
      v.add(doc.createElement("td"));
      ((Element)v.get(339)).appendChild((Element)v.get(340));

      /* Empieza nodo:341 / Elemento padre: 340   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(341)).setAttribute("nombre","lblSituacion" );
      ((Element)v.get(341)).setAttribute("ancho","155" );
      ((Element)v.get(341)).setAttribute("alto","30" );
      ((Element)v.get(341)).setAttribute("filas","1" );
      ((Element)v.get(341)).setAttribute("id","datosTitle" );
      ((Element)v.get(341)).setAttribute("cod","2485" );
      ((Element)v.get(340)).appendChild((Element)v.get(341));
      /* Termina nodo:341   */
      /* Termina nodo:340   */

      /* Empieza nodo:342 / Elemento padre: 339   */
      v.add(doc.createElement("td"));
      ((Element)v.get(339)).appendChild((Element)v.get(342));

      /* Empieza nodo:343 / Elemento padre: 342   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(343)).setAttribute("src","b.gif" );
      ((Element)v.get(343)).setAttribute("width","8" );
      ((Element)v.get(343)).setAttribute("height","8" );
      ((Element)v.get(342)).appendChild((Element)v.get(343));
      /* Termina nodo:343   */
      /* Termina nodo:342   */

      /* Empieza nodo:344 / Elemento padre: 339   */
      v.add(doc.createElement("td"));
      ((Element)v.get(344)).setAttribute("align","left" );
      ((Element)v.get(344)).setAttribute("class","datosCampos" );
      ((Element)v.get(339)).appendChild((Element)v.get(344));

      /* Empieza nodo:345 / Elemento padre: 344   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(345)).setAttribute("nombre","rdbSituacion" );
      ((Element)v.get(345)).setAttribute("tipo","H" );
      ((Element)v.get(345)).setAttribute("req","N" );
      ((Element)v.get(345)).setAttribute("id","datosTitleLeft.css" );
      ((Element)v.get(344)).appendChild((Element)v.get(345));

      /* Empieza nodo:346 / Elemento padre: 345   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(346)).setAttribute("valor","Activo" );
      ((Element)v.get(346)).setAttribute("check","" );
      ((Element)v.get(346)).setAttribute("onfocus","" );
   }

   private void getXML1350(Document doc) {
      ((Element)v.get(345)).appendChild((Element)v.get(346));

      /* Elemento padre:346 / Elemento actual: 347   */
      v.add(doc.createTextNode("Activo"));
      ((Element)v.get(346)).appendChild((Text)v.get(347));

      /* Termina nodo Texto:347   */
      /* Termina nodo:346   */

      /* Empieza nodo:348 / Elemento padre: 345   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(348)).setAttribute("valor","Inactivo" );
      ((Element)v.get(348)).setAttribute("onfocus","" );
      ((Element)v.get(345)).appendChild((Element)v.get(348));

      /* Elemento padre:348 / Elemento actual: 349   */
      v.add(doc.createTextNode("Inactivo"));
      ((Element)v.get(348)).appendChild((Text)v.get(349));

      /* Termina nodo Texto:349   */
      /* Termina nodo:348   */
      /* Termina nodo:345   */
      /* Termina nodo:344   */

      /* Empieza nodo:350 / Elemento padre: 339   */
      v.add(doc.createElement("td"));
      ((Element)v.get(339)).appendChild((Element)v.get(350));
      /* Termina nodo:350   */

      /* Empieza nodo:351 / Elemento padre: 339   */
      v.add(doc.createElement("td"));
      ((Element)v.get(339)).appendChild((Element)v.get(351));

      /* Empieza nodo:352 / Elemento padre: 351   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(352)).setAttribute("src","b.gif" );
      ((Element)v.get(352)).setAttribute("width","1015" );
      ((Element)v.get(352)).setAttribute("height","8" );
      ((Element)v.get(351)).appendChild((Element)v.get(352));
      /* Termina nodo:352   */
      /* Termina nodo:351   */

      /* Empieza nodo:353 / Elemento padre: 339   */
      v.add(doc.createElement("td"));
      ((Element)v.get(339)).appendChild((Element)v.get(353));
      /* Termina nodo:353   */
      /* Termina nodo:339   */
      /* Termina nodo:338   */

      /* Empieza nodo:354 / Elemento padre: 67   */
      v.add(doc.createElement("table"));
      ((Element)v.get(354)).setAttribute("cellSpacing","0" );
      ((Element)v.get(354)).setAttribute("cellPadding","0" );
      ((Element)v.get(354)).setAttribute("width","99%" );
      ((Element)v.get(354)).setAttribute("align","center" );
      ((Element)v.get(354)).setAttribute("border","0" );
      ((Element)v.get(67)).appendChild((Element)v.get(354));

      /* Empieza nodo:355 / Elemento padre: 354   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(354)).appendChild((Element)v.get(355));

      /* Empieza nodo:356 / Elemento padre: 355   */
      v.add(doc.createElement("td"));
      ((Element)v.get(355)).appendChild((Element)v.get(356));

      /* Empieza nodo:357 / Elemento padre: 356   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(357)).setAttribute("nombre","lblEstatusDelProducto" );
      ((Element)v.get(357)).setAttribute("ancho","155" );
      ((Element)v.get(357)).setAttribute("alto","30" );
      ((Element)v.get(357)).setAttribute("filas","1" );
      ((Element)v.get(357)).setAttribute("id","datosTitle" );
      ((Element)v.get(357)).setAttribute("cod","2487" );
      ((Element)v.get(356)).appendChild((Element)v.get(357));
      /* Termina nodo:357   */
      /* Termina nodo:356   */

      /* Empieza nodo:358 / Elemento padre: 355   */
      v.add(doc.createElement("td"));
      ((Element)v.get(355)).appendChild((Element)v.get(358));

      /* Empieza nodo:359 / Elemento padre: 358   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(359)).setAttribute("src","b.gif" );
      ((Element)v.get(359)).setAttribute("width","8" );
      ((Element)v.get(359)).setAttribute("height","8" );
      ((Element)v.get(358)).appendChild((Element)v.get(359));
      /* Termina nodo:359   */
      /* Termina nodo:358   */

      /* Empieza nodo:360 / Elemento padre: 355   */
      v.add(doc.createElement("td"));
      ((Element)v.get(355)).appendChild((Element)v.get(360));

      /* Empieza nodo:361 / Elemento padre: 360   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(361)).setAttribute("id","estMiCombo30" );
      ((Element)v.get(361)).setAttribute("nombre","cbEstatusDelProducto" );
      ((Element)v.get(361)).setAttribute("size","1" );
      ((Element)v.get(361)).setAttribute("multiple","N" );
      ((Element)v.get(361)).setAttribute("req","N" );
      ((Element)v.get(361)).setAttribute("valorinicial","" );
      ((Element)v.get(361)).setAttribute("textoinicial"," " );
      ((Element)v.get(360)).appendChild((Element)v.get(361));

      /* Empieza nodo:362 / Elemento padre: 361   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(361)).appendChild((Element)v.get(362));
      /* Termina nodo:362   */
      /* Termina nodo:361   */
      /* Termina nodo:360   */

      /* Empieza nodo:363 / Elemento padre: 355   */
      v.add(doc.createElement("td"));
      ((Element)v.get(355)).appendChild((Element)v.get(363));
      /* Termina nodo:363   */

      /* Empieza nodo:364 / Elemento padre: 355   */
      v.add(doc.createElement("td"));
      ((Element)v.get(355)).appendChild((Element)v.get(364));

      /* Empieza nodo:365 / Elemento padre: 364   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(365)).setAttribute("src","b.gif" );
      ((Element)v.get(365)).setAttribute("width","745" );
      ((Element)v.get(365)).setAttribute("height","8" );
      ((Element)v.get(364)).appendChild((Element)v.get(365));
      /* Termina nodo:365   */
      /* Termina nodo:364   */

      /* Empieza nodo:366 / Elemento padre: 355   */
      v.add(doc.createElement("td"));
      ((Element)v.get(355)).appendChild((Element)v.get(366));
      /* Termina nodo:366   */
      /* Termina nodo:355   */
      /* Termina nodo:354   */

      /* Empieza nodo:367 / Elemento padre: 67   */
      v.add(doc.createElement("table"));
      ((Element)v.get(367)).setAttribute("cellSpacing","0" );
      ((Element)v.get(367)).setAttribute("cellPadding","0" );
      ((Element)v.get(367)).setAttribute("width","99%" );
      ((Element)v.get(367)).setAttribute("align","center" );
      ((Element)v.get(367)).setAttribute("border","0" );
      ((Element)v.get(67)).appendChild((Element)v.get(367));

      /* Empieza nodo:368 / Elemento padre: 367   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(367)).appendChild((Element)v.get(368));

      /* Empieza nodo:369 / Elemento padre: 368   */
      v.add(doc.createElement("td"));
      ((Element)v.get(368)).appendChild((Element)v.get(369));

      /* Empieza nodo:370 / Elemento padre: 369   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(370)).setAttribute("nombre","lblIndicadorDentroDeCaja" );
      ((Element)v.get(370)).setAttribute("ancho","155" );
      ((Element)v.get(370)).setAttribute("alto","30" );
      ((Element)v.get(370)).setAttribute("filas","1" );
      ((Element)v.get(370)).setAttribute("id","datosTitle" );
      ((Element)v.get(370)).setAttribute("cod","2488" );
      ((Element)v.get(369)).appendChild((Element)v.get(370));
      /* Termina nodo:370   */
      /* Termina nodo:369   */

      /* Empieza nodo:371 / Elemento padre: 368   */
      v.add(doc.createElement("td"));
   }

   private void getXML1440(Document doc) {
      ((Element)v.get(368)).appendChild((Element)v.get(371));

      /* Empieza nodo:372 / Elemento padre: 371   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(372)).setAttribute("src","b.gif" );
      ((Element)v.get(372)).setAttribute("width","8" );
      ((Element)v.get(372)).setAttribute("height","8" );
      ((Element)v.get(371)).appendChild((Element)v.get(372));
      /* Termina nodo:372   */
      /* Termina nodo:371   */

      /* Empieza nodo:373 / Elemento padre: 368   */
      v.add(doc.createElement("td"));
      ((Element)v.get(373)).setAttribute("class","datosCampos" );
      ((Element)v.get(373)).setAttribute("align","left" );
      ((Element)v.get(368)).appendChild((Element)v.get(373));

      /* Empieza nodo:374 / Elemento padre: 373   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(374)).setAttribute("nombre","rdbIndicadorDentroDeCaja" );
      ((Element)v.get(374)).setAttribute("tipo","H" );
      ((Element)v.get(374)).setAttribute("req","N" );
      ((Element)v.get(374)).setAttribute("id","datosTitleLeft.css" );
      ((Element)v.get(373)).appendChild((Element)v.get(374));

      /* Empieza nodo:375 / Elemento padre: 374   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(375)).setAttribute("valor","SI" );
      ((Element)v.get(375)).setAttribute("check","" );
      ((Element)v.get(375)).setAttribute("onfocus","" );
      ((Element)v.get(374)).appendChild((Element)v.get(375));

      /* Elemento padre:375 / Elemento actual: 376   */
      v.add(doc.createTextNode("Si"));
      ((Element)v.get(375)).appendChild((Text)v.get(376));

      /* Termina nodo Texto:376   */
      /* Termina nodo:375   */

      /* Empieza nodo:377 / Elemento padre: 374   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(377)).setAttribute("valor","NO" );
      ((Element)v.get(377)).setAttribute("onfocus","" );
      ((Element)v.get(374)).appendChild((Element)v.get(377));

      /* Elemento padre:377 / Elemento actual: 378   */
      v.add(doc.createTextNode("No"));
      ((Element)v.get(377)).appendChild((Text)v.get(378));

      /* Termina nodo Texto:378   */
      /* Termina nodo:377   */
      /* Termina nodo:374   */
      /* Termina nodo:373   */

      /* Empieza nodo:379 / Elemento padre: 368   */
      v.add(doc.createElement("td"));
      ((Element)v.get(368)).appendChild((Element)v.get(379));
      /* Termina nodo:379   */

      /* Empieza nodo:380 / Elemento padre: 368   */
      v.add(doc.createElement("td"));
      ((Element)v.get(368)).appendChild((Element)v.get(380));

      /* Empieza nodo:381 / Elemento padre: 380   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(381)).setAttribute("src","b.gif" );
      ((Element)v.get(381)).setAttribute("width","1060" );
      ((Element)v.get(381)).setAttribute("height","8" );
      ((Element)v.get(380)).appendChild((Element)v.get(381));
      /* Termina nodo:381   */
      /* Termina nodo:380   */

      /* Empieza nodo:382 / Elemento padre: 368   */
      v.add(doc.createElement("td"));
      ((Element)v.get(368)).appendChild((Element)v.get(382));
      /* Termina nodo:382   */
      /* Termina nodo:368   */
      /* Termina nodo:367   */

      /* Empieza nodo:383 / Elemento padre: 67   */
      v.add(doc.createElement("table"));
      ((Element)v.get(383)).setAttribute("cellSpacing","0" );
      ((Element)v.get(383)).setAttribute("cellPadding","0" );
      ((Element)v.get(383)).setAttribute("width","99%" );
      ((Element)v.get(383)).setAttribute("align","center" );
      ((Element)v.get(383)).setAttribute("border","0" );
      ((Element)v.get(67)).appendChild((Element)v.get(383));

      /* Empieza nodo:384 / Elemento padre: 383   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(383)).appendChild((Element)v.get(384));

      /* Empieza nodo:385 / Elemento padre: 384   */
      v.add(doc.createElement("td"));
      ((Element)v.get(384)).appendChild((Element)v.get(385));

      /* Empieza nodo:386 / Elemento padre: 385   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(386)).setAttribute("nombre","lblCodigoPagoFraccionado" );
      ((Element)v.get(386)).setAttribute("ancho","155" );
      ((Element)v.get(386)).setAttribute("alto","30" );
      ((Element)v.get(386)).setAttribute("filas","1" );
      ((Element)v.get(386)).setAttribute("id","datosTitle" );
      ((Element)v.get(386)).setAttribute("cod","558" );
      ((Element)v.get(385)).appendChild((Element)v.get(386));
      /* Termina nodo:386   */
      /* Termina nodo:385   */

      /* Empieza nodo:387 / Elemento padre: 384   */
      v.add(doc.createElement("td"));
      ((Element)v.get(384)).appendChild((Element)v.get(387));

      /* Empieza nodo:388 / Elemento padre: 387   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(388)).setAttribute("src","b.gif" );
      ((Element)v.get(388)).setAttribute("width","8" );
      ((Element)v.get(388)).setAttribute("height","8" );
      ((Element)v.get(387)).appendChild((Element)v.get(388));
      /* Termina nodo:388   */
      /* Termina nodo:387   */

      /* Empieza nodo:389 / Elemento padre: 384   */
      v.add(doc.createElement("td"));
      ((Element)v.get(384)).appendChild((Element)v.get(389));

      /* Empieza nodo:390 / Elemento padre: 389   */
      v.add(doc.createElement("td"));
      ((Element)v.get(389)).appendChild((Element)v.get(390));

      /* Empieza nodo:391 / Elemento padre: 390   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(391)).setAttribute("id","datosCamposLeft" );
      ((Element)v.get(391)).setAttribute("nombre","txtCodigoPagoFraccionado" );
      ((Element)v.get(391)).setAttribute("valor","" );
      ((Element)v.get(391)).setAttribute("size","16" );
      ((Element)v.get(391)).setAttribute("max","10" );
      ((Element)v.get(390)).appendChild((Element)v.get(391));
      /* Termina nodo:391   */
      /* Termina nodo:390   */

      /* Empieza nodo:392 / Elemento padre: 389   */
      v.add(doc.createElement("td"));
      ((Element)v.get(389)).appendChild((Element)v.get(392));

      /* Empieza nodo:393 / Elemento padre: 392   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(393)).setAttribute("src","b.gif" );
      ((Element)v.get(393)).setAttribute("width","265" );
      ((Element)v.get(393)).setAttribute("height","0" );
      ((Element)v.get(392)).appendChild((Element)v.get(393));
      /* Termina nodo:393   */
      /* Termina nodo:392   */
      /* Termina nodo:389   */

      /* Empieza nodo:394 / Elemento padre: 384   */
      v.add(doc.createElement("td"));
      ((Element)v.get(384)).appendChild((Element)v.get(394));

      /* Empieza nodo:395 / Elemento padre: 394   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(395)).setAttribute("nombre","lblCodigoImpuesto" );
      ((Element)v.get(395)).setAttribute("ancho","175" );
      ((Element)v.get(395)).setAttribute("alto","30" );
   }

   private void getXML1530(Document doc) {
      ((Element)v.get(395)).setAttribute("filas","1" );
      ((Element)v.get(395)).setAttribute("id","datosTitle" );
      ((Element)v.get(395)).setAttribute("cod","2489" );
      ((Element)v.get(394)).appendChild((Element)v.get(395));
      /* Termina nodo:395   */
      /* Termina nodo:394   */

      /* Empieza nodo:396 / Elemento padre: 384   */
      v.add(doc.createElement("td"));
      ((Element)v.get(384)).appendChild((Element)v.get(396));

      /* Empieza nodo:397 / Elemento padre: 396   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(397)).setAttribute("src","b.gif" );
      ((Element)v.get(397)).setAttribute("width","8" );
      ((Element)v.get(397)).setAttribute("height","8" );
      ((Element)v.get(396)).appendChild((Element)v.get(397));
      /* Termina nodo:397   */
      /* Termina nodo:396   */

      /* Empieza nodo:398 / Elemento padre: 384   */
      v.add(doc.createElement("td"));
      ((Element)v.get(384)).appendChild((Element)v.get(398));

      /* Empieza nodo:399 / Elemento padre: 398   */
      v.add(doc.createElement("td"));
      ((Element)v.get(398)).appendChild((Element)v.get(399));

      /* Empieza nodo:400 / Elemento padre: 399   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(400)).setAttribute("id","datosCamposLeft" );
      ((Element)v.get(400)).setAttribute("nombre","txtCodigoImpuesto" );
      ((Element)v.get(400)).setAttribute("valor","" );
      ((Element)v.get(400)).setAttribute("size","16" );
      ((Element)v.get(400)).setAttribute("max","10" );
      ((Element)v.get(400)).setAttribute("ontab","pasarFocoSiguienteCodigoImpuesto();" );
      ((Element)v.get(399)).appendChild((Element)v.get(400));
      /* Termina nodo:400   */
      /* Termina nodo:399   */

      /* Empieza nodo:401 / Elemento padre: 398   */
      v.add(doc.createElement("td"));
      ((Element)v.get(398)).appendChild((Element)v.get(401));

      /* Empieza nodo:402 / Elemento padre: 401   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(402)).setAttribute("src","b.gif" );
      ((Element)v.get(402)).setAttribute("width","265" );
      ((Element)v.get(402)).setAttribute("height","0" );
      ((Element)v.get(401)).appendChild((Element)v.get(402));
      /* Termina nodo:402   */
      /* Termina nodo:401   */
      /* Termina nodo:398   */
      /* Termina nodo:384   */

      /* Empieza nodo:403 / Elemento padre: 383   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(383)).appendChild((Element)v.get(403));

      /* Empieza nodo:404 / Elemento padre: 403   */
      v.add(doc.createElement("td"));
      ((Element)v.get(403)).appendChild((Element)v.get(404));

      /* Empieza nodo:405 / Elemento padre: 404   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(405)).setAttribute("nombre","lblPrecioCatalogo" );
      ((Element)v.get(405)).setAttribute("ancho","155" );
      ((Element)v.get(405)).setAttribute("alto","30" );
      ((Element)v.get(405)).setAttribute("filas","1" );
      ((Element)v.get(405)).setAttribute("id","datosTitle" );
      ((Element)v.get(405)).setAttribute("cod","2490" );
      ((Element)v.get(404)).appendChild((Element)v.get(405));
      /* Termina nodo:405   */
      /* Termina nodo:404   */

      /* Empieza nodo:406 / Elemento padre: 403   */
      v.add(doc.createElement("td"));
      ((Element)v.get(403)).appendChild((Element)v.get(406));

      /* Empieza nodo:407 / Elemento padre: 406   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(407)).setAttribute("src","b.gif" );
      ((Element)v.get(407)).setAttribute("width","8" );
      ((Element)v.get(407)).setAttribute("height","8" );
      ((Element)v.get(406)).appendChild((Element)v.get(407));
      /* Termina nodo:407   */
      /* Termina nodo:406   */

      /* Empieza nodo:408 / Elemento padre: 403   */
      v.add(doc.createElement("td"));
      ((Element)v.get(403)).appendChild((Element)v.get(408));

      /* Empieza nodo:409 / Elemento padre: 408   */
      v.add(doc.createElement("td"));
      ((Element)v.get(408)).appendChild((Element)v.get(409));

      /* Empieza nodo:410 / Elemento padre: 409   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(410)).setAttribute("id","datosCamposLeft" );
      ((Element)v.get(410)).setAttribute("nombre","txtPrecioCatalogo" );
      ((Element)v.get(410)).setAttribute("valor","" );
      ((Element)v.get(410)).setAttribute("size","29" );
      ((Element)v.get(410)).setAttribute("max","17" );
      ((Element)v.get(409)).appendChild((Element)v.get(410));
      /* Termina nodo:410   */
      /* Termina nodo:409   */

      /* Empieza nodo:411 / Elemento padre: 408   */
      v.add(doc.createElement("td"));
      ((Element)v.get(408)).appendChild((Element)v.get(411));

      /* Empieza nodo:412 / Elemento padre: 411   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(412)).setAttribute("src","b.gif" );
      ((Element)v.get(412)).setAttribute("width","265" );
      ((Element)v.get(412)).setAttribute("height","0" );
      ((Element)v.get(411)).appendChild((Element)v.get(412));
      /* Termina nodo:412   */
      /* Termina nodo:411   */
      /* Termina nodo:408   */

      /* Empieza nodo:413 / Elemento padre: 403   */
      v.add(doc.createElement("td"));
      ((Element)v.get(403)).appendChild((Element)v.get(413));

      /* Empieza nodo:414 / Elemento padre: 413   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(414)).setAttribute("nombre","lblPrecioContable" );
      ((Element)v.get(414)).setAttribute("ancho","175" );
      ((Element)v.get(414)).setAttribute("alto","30" );
      ((Element)v.get(414)).setAttribute("filas","1" );
      ((Element)v.get(414)).setAttribute("id","datosTitle" );
      ((Element)v.get(414)).setAttribute("cod","712" );
      ((Element)v.get(413)).appendChild((Element)v.get(414));
      /* Termina nodo:414   */
      /* Termina nodo:413   */

      /* Empieza nodo:415 / Elemento padre: 403   */
      v.add(doc.createElement("td"));
      ((Element)v.get(403)).appendChild((Element)v.get(415));

      /* Empieza nodo:416 / Elemento padre: 415   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(416)).setAttribute("src","b.gif" );
      ((Element)v.get(416)).setAttribute("width","8" );
      ((Element)v.get(416)).setAttribute("height","8" );
      ((Element)v.get(415)).appendChild((Element)v.get(416));
      /* Termina nodo:416   */
      /* Termina nodo:415   */

      /* Empieza nodo:417 / Elemento padre: 403   */
      v.add(doc.createElement("td"));
      ((Element)v.get(403)).appendChild((Element)v.get(417));

      /* Empieza nodo:418 / Elemento padre: 417   */
      v.add(doc.createElement("td"));
      ((Element)v.get(417)).appendChild((Element)v.get(418));

      /* Empieza nodo:419 / Elemento padre: 418   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(419)).setAttribute("id","datosCamposLeft" );
   }

   private void getXML1620(Document doc) {
      ((Element)v.get(419)).setAttribute("nombre","txtPrecioContable" );
      ((Element)v.get(419)).setAttribute("valor","" );
      ((Element)v.get(419)).setAttribute("size","29" );
      ((Element)v.get(419)).setAttribute("max","17" );
      ((Element)v.get(419)).setAttribute("ontab","pasarFocoSiguientePrecioContable();" );
      ((Element)v.get(418)).appendChild((Element)v.get(419));
      /* Termina nodo:419   */
      /* Termina nodo:418   */

      /* Empieza nodo:420 / Elemento padre: 417   */
      v.add(doc.createElement("td"));
      ((Element)v.get(417)).appendChild((Element)v.get(420));

      /* Empieza nodo:421 / Elemento padre: 420   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(421)).setAttribute("src","b.gif" );
      ((Element)v.get(421)).setAttribute("width","265" );
      ((Element)v.get(421)).setAttribute("height","0" );
      ((Element)v.get(420)).appendChild((Element)v.get(421));
      /* Termina nodo:421   */
      /* Termina nodo:420   */
      /* Termina nodo:417   */
      /* Termina nodo:403   */
      /* Termina nodo:383   */
      /* Termina nodo:67   */
      /* Termina nodo:66   */
      /* Termina nodo:65   */

      /* Empieza nodo:422 / Elemento padre: 62   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(62)).appendChild((Element)v.get(422));
      /* Termina nodo:422   */
      /* Termina nodo:62   */
      /* Termina nodo:54   */

      /* Empieza nodo:423 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(423)).setAttribute("nombre","capaBotonBuscar" );
      ((Element)v.get(423)).setAttribute("alto","25" );
      ((Element)v.get(423)).setAttribute("ancho","1294" );
      ((Element)v.get(423)).setAttribute("colorf","#CCCCCC" );
      ((Element)v.get(423)).setAttribute("imagenf","" );
      ((Element)v.get(423)).setAttribute("repeat","" );
      ((Element)v.get(423)).setAttribute("padding","" );
      ((Element)v.get(423)).setAttribute("visibilidad","visible" );
      ((Element)v.get(423)).setAttribute("contravsb","" );
      ((Element)v.get(423)).setAttribute("x","14" );
      ((Element)v.get(423)).setAttribute("y","809" );
      ((Element)v.get(423)).setAttribute("zindex","" );
      ((Element)v.get(6)).appendChild((Element)v.get(423));

      /* Empieza nodo:424 / Elemento padre: 423   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(423)).appendChild((Element)v.get(424));

      /* Empieza nodo:425 / Elemento padre: 424   */
      v.add(doc.createElement("td"));
      ((Element)v.get(424)).appendChild((Element)v.get(425));

      /* Empieza nodo:426 / Elemento padre: 425   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(426)).setAttribute("src","b.gif" );
      ((Element)v.get(426)).setAttribute("width","1" );
      ((Element)v.get(426)).setAttribute("height","8" );
      ((Element)v.get(425)).appendChild((Element)v.get(426));
      /* Termina nodo:426   */
      /* Termina nodo:425   */

      /* Empieza nodo:427 / Elemento padre: 424   */
      v.add(doc.createElement("td"));
      ((Element)v.get(427)).setAttribute("bgcolor","#CCCCCC" );
      ((Element)v.get(424)).appendChild((Element)v.get(427));

      /* Empieza nodo:428 / Elemento padre: 427   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(428)).setAttribute("cod","141" );
      ((Element)v.get(428)).setAttribute("estado","false" );
      ((Element)v.get(428)).setAttribute("accion","buscar();" );
      ((Element)v.get(428)).setAttribute("tipo","html" );
      ((Element)v.get(428)).setAttribute("ID","botonContenido" );
      ((Element)v.get(428)).setAttribute("nombre","btnBuscar" );
      ((Element)v.get(427)).appendChild((Element)v.get(428));
      /* Termina nodo:428   */
      /* Termina nodo:427   */
      /* Termina nodo:424   */
      /* Termina nodo:423   */

      /* Empieza nodo:429 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(429)).setAttribute("nombre","capaResultado" );
      ((Element)v.get(429)).setAttribute("alto","150" );
      ((Element)v.get(429)).setAttribute("ancho","1294" );
      ((Element)v.get(429)).setAttribute("colorf","#CCCCCC" );
      ((Element)v.get(429)).setAttribute("borde","0" );
      ((Element)v.get(429)).setAttribute("imagenf","" );
      ((Element)v.get(429)).setAttribute("repeat","" );
      ((Element)v.get(429)).setAttribute("padding","" );
      ((Element)v.get(429)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(429)).setAttribute("contravsb","" );
      ((Element)v.get(429)).setAttribute("x","14" );
      ((Element)v.get(429)).setAttribute("y","880" );
      ((Element)v.get(429)).setAttribute("zindex","" );
      ((Element)v.get(6)).appendChild((Element)v.get(429));

      /* Empieza nodo:430 / Elemento padre: 429   */
      v.add(doc.createElement("LISTA"));
      ((Element)v.get(430)).setAttribute("seleccion","boton" );
      ((Element)v.get(430)).setAttribute("nombre","lstResultado" );
      ((Element)v.get(430)).setAttribute("x","0" );
      ((Element)v.get(430)).setAttribute("y","0" );
      ((Element)v.get(430)).setAttribute("ancho","1294" );
      ((Element)v.get(430)).setAttribute("alto","150" );
      ((Element)v.get(430)).setAttribute("multisel","1" );
      ((Element)v.get(430)).setAttribute("incy","10" );
      ((Element)v.get(430)).setAttribute("incx","10" );
      ((Element)v.get(430)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(430)).setAttribute("imagenoff","close_no.gif" );
      ((Element)v.get(430)).setAttribute("imagenon","close_up.gif" );
      ((Element)v.get(430)).setAttribute("accion","" );
      ((Element)v.get(430)).setAttribute("sep","|" );
      ((Element)v.get(430)).setAttribute("pixelsborde","3" );
      ((Element)v.get(430)).setAttribute("colorborde","#CCCCCC" );
      ((Element)v.get(429)).appendChild((Element)v.get(430));

      /* Empieza nodo:431 / Elemento padre: 430   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(431)).setAttribute("nombre","cab1" );
      ((Element)v.get(431)).setAttribute("height","20" );
      ((Element)v.get(430)).appendChild((Element)v.get(431));

      /* Empieza nodo:432 / Elemento padre: 431   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(432)).setAttribute("id","fondoCabecera" );
      ((Element)v.get(432)).setAttribute("ancho","20" );
      ((Element)v.get(431)).appendChild((Element)v.get(432));

      /* Empieza nodo:433 / Elemento padre: 432   */
   }

   private void getXML1710(Document doc) {
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(433)).setAttribute("nombre","lblEspacio" );
      ((Element)v.get(433)).setAttribute("ancho","20" );
      ((Element)v.get(433)).setAttribute("alto","20" );
      ((Element)v.get(433)).setAttribute("filas","1" );
      ((Element)v.get(433)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(433)).setAttribute("cod","" );
      ((Element)v.get(432)).appendChild((Element)v.get(433));
      /* Termina nodo:433   */
      /* Termina nodo:432   */

      /* Empieza nodo:434 / Elemento padre: 431   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(434)).setAttribute("id","fondoCabecera" );
      ((Element)v.get(434)).setAttribute("ancho","210" );
      ((Element)v.get(431)).appendChild((Element)v.get(434));

      /* Empieza nodo:435 / Elemento padre: 434   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(435)).setAttribute("nombre","lblCodigoSAPLista" );
      ((Element)v.get(435)).setAttribute("ancho","210" );
      ((Element)v.get(435)).setAttribute("alto","20" );
      ((Element)v.get(435)).setAttribute("filas","1" );
      ((Element)v.get(435)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(435)).setAttribute("cod","2467" );
      ((Element)v.get(434)).appendChild((Element)v.get(435));
      /* Termina nodo:435   */
      /* Termina nodo:434   */

      /* Empieza nodo:436 / Elemento padre: 431   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(436)).setAttribute("id","fondoCabecera" );
      ((Element)v.get(436)).setAttribute("ancho","190" );
      ((Element)v.get(431)).appendChild((Element)v.get(436));

      /* Empieza nodo:437 / Elemento padre: 436   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(437)).setAttribute("nombre","lblCodigoAntiguoLista" );
      ((Element)v.get(437)).setAttribute("ancho","190" );
      ((Element)v.get(437)).setAttribute("alto","20" );
      ((Element)v.get(437)).setAttribute("filas","1" );
      ((Element)v.get(437)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(437)).setAttribute("cod","2468" );
      ((Element)v.get(436)).appendChild((Element)v.get(437));
      /* Termina nodo:437   */
      /* Termina nodo:436   */

      /* Empieza nodo:438 / Elemento padre: 431   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(438)).setAttribute("id","fondoCabecera" );
      ((Element)v.get(438)).setAttribute("ancho","410" );
      ((Element)v.get(431)).appendChild((Element)v.get(438));

      /* Empieza nodo:439 / Elemento padre: 438   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(439)).setAttribute("nombre","lblDescripcionSAPLista" );
      ((Element)v.get(439)).setAttribute("ancho","410" );
      ((Element)v.get(439)).setAttribute("alto","20" );
      ((Element)v.get(439)).setAttribute("filas","1" );
      ((Element)v.get(439)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(439)).setAttribute("cod","2469" );
      ((Element)v.get(438)).appendChild((Element)v.get(439));
      /* Termina nodo:439   */
      /* Termina nodo:438   */

      /* Empieza nodo:440 / Elemento padre: 431   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(440)).setAttribute("id","fondoCabecera" );
      ((Element)v.get(440)).setAttribute("ancho","410" );
      ((Element)v.get(431)).appendChild((Element)v.get(440));

      /* Empieza nodo:441 / Elemento padre: 440   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(441)).setAttribute("nombre","lblDescripcionCortaLista" );
      ((Element)v.get(441)).setAttribute("ancho","410" );
      ((Element)v.get(441)).setAttribute("alto","20" );
      ((Element)v.get(441)).setAttribute("filas","1" );
      ((Element)v.get(441)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(441)).setAttribute("cod","47" );
      ((Element)v.get(440)).appendChild((Element)v.get(441));
      /* Termina nodo:441   */
      /* Termina nodo:440   */

      /* Empieza nodo:442 / Elemento padre: 431   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(442)).setAttribute("id","fondoCabecera" );
      ((Element)v.get(442)).setAttribute("ancho","100" );
      ((Element)v.get(431)).appendChild((Element)v.get(442));

      /* Empieza nodo:443 / Elemento padre: 442   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(443)).setAttribute("nombre","lblLoteLista" );
      ((Element)v.get(443)).setAttribute("ancho","100" );
      ((Element)v.get(443)).setAttribute("alto","20" );
      ((Element)v.get(443)).setAttribute("filas","1" );
      ((Element)v.get(443)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(443)).setAttribute("cod","2470" );
      ((Element)v.get(442)).appendChild((Element)v.get(443));
      /* Termina nodo:443   */
      /* Termina nodo:442   */

      /* Empieza nodo:444 / Elemento padre: 431   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(444)).setAttribute("id","fondoCabecera" );
      ((Element)v.get(444)).setAttribute("ancho","100" );
      ((Element)v.get(431)).appendChild((Element)v.get(444));

      /* Empieza nodo:445 / Elemento padre: 444   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(445)).setAttribute("nombre","lblTipoLista" );
      ((Element)v.get(445)).setAttribute("ancho","100" );
      ((Element)v.get(445)).setAttribute("alto","20" );
      ((Element)v.get(445)).setAttribute("filas","1" );
      ((Element)v.get(445)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(445)).setAttribute("cod","2471" );
      ((Element)v.get(444)).appendChild((Element)v.get(445));
      /* Termina nodo:445   */
      /* Termina nodo:444   */

      /* Empieza nodo:446 / Elemento padre: 431   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(446)).setAttribute("id","fondoCabecera" );
      ((Element)v.get(446)).setAttribute("ancho","310" );
      ((Element)v.get(431)).appendChild((Element)v.get(446));

      /* Empieza nodo:447 / Elemento padre: 446   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(447)).setAttribute("nombre","lblMarcaLista" );
      ((Element)v.get(447)).setAttribute("ancho","310" );
      ((Element)v.get(447)).setAttribute("alto","20" );
      ((Element)v.get(447)).setAttribute("filas","1" );
      ((Element)v.get(447)).setAttribute("id","datosCamposCabecera" );
   }

   private void getXML1800(Document doc) {
      ((Element)v.get(447)).setAttribute("cod","165" );
      ((Element)v.get(446)).appendChild((Element)v.get(447));
      /* Termina nodo:447   */
      /* Termina nodo:446   */

      /* Empieza nodo:448 / Elemento padre: 431   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(448)).setAttribute("id","fondoCabecera" );
      ((Element)v.get(448)).setAttribute("ancho","410" );
      ((Element)v.get(431)).appendChild((Element)v.get(448));

      /* Empieza nodo:449 / Elemento padre: 448   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(449)).setAttribute("nombre","lblUnidaddeNegocioLista" );
      ((Element)v.get(449)).setAttribute("ancho","410" );
      ((Element)v.get(449)).setAttribute("alto","20" );
      ((Element)v.get(449)).setAttribute("filas","1" );
      ((Element)v.get(449)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(449)).setAttribute("cod","480" );
      ((Element)v.get(448)).appendChild((Element)v.get(449));
      /* Termina nodo:449   */
      /* Termina nodo:448   */

      /* Empieza nodo:450 / Elemento padre: 431   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(450)).setAttribute("id","fondoCabecera" );
      ((Element)v.get(450)).setAttribute("ancho","410" );
      ((Element)v.get(431)).appendChild((Element)v.get(450));

      /* Empieza nodo:451 / Elemento padre: 450   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(451)).setAttribute("nombre","lblNegocioLista" );
      ((Element)v.get(451)).setAttribute("ancho","410" );
      ((Element)v.get(451)).setAttribute("alto","20" );
      ((Element)v.get(451)).setAttribute("filas","1" );
      ((Element)v.get(451)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(451)).setAttribute("cod","481" );
      ((Element)v.get(450)).appendChild((Element)v.get(451));
      /* Termina nodo:451   */
      /* Termina nodo:450   */

      /* Empieza nodo:452 / Elemento padre: 431   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(452)).setAttribute("id","fondoCabecera" );
      ((Element)v.get(452)).setAttribute("ancho","410" );
      ((Element)v.get(431)).appendChild((Element)v.get(452));

      /* Empieza nodo:453 / Elemento padre: 452   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(453)).setAttribute("nombre","lblGenericoLista" );
      ((Element)v.get(453)).setAttribute("ancho","410" );
      ((Element)v.get(453)).setAttribute("alto","20" );
      ((Element)v.get(453)).setAttribute("filas","1" );
      ((Element)v.get(453)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(453)).setAttribute("cod","482" );
      ((Element)v.get(452)).appendChild((Element)v.get(453));
      /* Termina nodo:453   */
      /* Termina nodo:452   */

      /* Empieza nodo:454 / Elemento padre: 431   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(454)).setAttribute("id","fondoCabecera" );
      ((Element)v.get(454)).setAttribute("ancho","410" );
      ((Element)v.get(431)).appendChild((Element)v.get(454));

      /* Empieza nodo:455 / Elemento padre: 454   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(455)).setAttribute("nombre","lblSupergenericoLista" );
      ((Element)v.get(455)).setAttribute("ancho","410" );
      ((Element)v.get(455)).setAttribute("alto","20" );
      ((Element)v.get(455)).setAttribute("filas","1" );
      ((Element)v.get(455)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(455)).setAttribute("cod","483" );
      ((Element)v.get(454)).appendChild((Element)v.get(455));
      /* Termina nodo:455   */
      /* Termina nodo:454   */

      /* Empieza nodo:456 / Elemento padre: 431   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(456)).setAttribute("id","fondoCabecera" );
      ((Element)v.get(456)).setAttribute("ancho","130" );
      ((Element)v.get(431)).appendChild((Element)v.get(456));

      /* Empieza nodo:457 / Elemento padre: 456   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(457)).setAttribute("nombre","lblJerarquia1Lista" );
      ((Element)v.get(457)).setAttribute("ancho","130" );
      ((Element)v.get(457)).setAttribute("alto","20" );
      ((Element)v.get(457)).setAttribute("filas","1" );
      ((Element)v.get(457)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(457)).setAttribute("cod","314" );
      ((Element)v.get(456)).appendChild((Element)v.get(457));
      /* Termina nodo:457   */
      /* Termina nodo:456   */

      /* Empieza nodo:458 / Elemento padre: 431   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(458)).setAttribute("id","fondoCabecera" );
      ((Element)v.get(458)).setAttribute("ancho","130" );
      ((Element)v.get(431)).appendChild((Element)v.get(458));

      /* Empieza nodo:459 / Elemento padre: 458   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(459)).setAttribute("nombre","lblJerarquia2Lista" );
      ((Element)v.get(459)).setAttribute("ancho","130" );
      ((Element)v.get(459)).setAttribute("alto","20" );
      ((Element)v.get(459)).setAttribute("filas","1" );
      ((Element)v.get(459)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(459)).setAttribute("cod","315" );
      ((Element)v.get(458)).appendChild((Element)v.get(459));
      /* Termina nodo:459   */
      /* Termina nodo:458   */

      /* Empieza nodo:460 / Elemento padre: 431   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(460)).setAttribute("id","fondoCabecera" );
      ((Element)v.get(460)).setAttribute("ancho","130" );
      ((Element)v.get(431)).appendChild((Element)v.get(460));

      /* Empieza nodo:461 / Elemento padre: 460   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(461)).setAttribute("nombre","lblJerarquia3Lista" );
      ((Element)v.get(461)).setAttribute("ancho","130" );
      ((Element)v.get(461)).setAttribute("alto","20" );
      ((Element)v.get(461)).setAttribute("filas","1" );
      ((Element)v.get(461)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(461)).setAttribute("cod","316" );
      ((Element)v.get(460)).appendChild((Element)v.get(461));
      /* Termina nodo:461   */
      /* Termina nodo:460   */

      /* Empieza nodo:462 / Elemento padre: 431   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(462)).setAttribute("id","fondoCabecera" );
      ((Element)v.get(462)).setAttribute("ancho","410" );
      ((Element)v.get(431)).appendChild((Element)v.get(462));

      /* Empieza nodo:463 / Elemento padre: 462   */
   }

   private void getXML1890(Document doc) {
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(463)).setAttribute("nombre","lblLineaLista" );
      ((Element)v.get(463)).setAttribute("ancho","410" );
      ((Element)v.get(463)).setAttribute("alto","20" );
      ((Element)v.get(463)).setAttribute("filas","1" );
      ((Element)v.get(463)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(463)).setAttribute("cod","2473" );
      ((Element)v.get(462)).appendChild((Element)v.get(463));
      /* Termina nodo:463   */
      /* Termina nodo:462   */

      /* Empieza nodo:464 / Elemento padre: 431   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(464)).setAttribute("id","fondoCabecera" );
      ((Element)v.get(464)).setAttribute("ancho","110" );
      ((Element)v.get(431)).appendChild((Element)v.get(464));

      /* Empieza nodo:465 / Elemento padre: 464   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(465)).setAttribute("nombre","lblAtributo1Lista" );
      ((Element)v.get(465)).setAttribute("ancho","110" );
      ((Element)v.get(465)).setAttribute("alto","20" );
      ((Element)v.get(465)).setAttribute("filas","1" );
      ((Element)v.get(465)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(465)).setAttribute("cod","189" );
      ((Element)v.get(464)).appendChild((Element)v.get(465));
      /* Termina nodo:465   */
      /* Termina nodo:464   */

      /* Empieza nodo:466 / Elemento padre: 431   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(466)).setAttribute("id","fondoCabecera" );
      ((Element)v.get(466)).setAttribute("ancho","110" );
      ((Element)v.get(431)).appendChild((Element)v.get(466));

      /* Empieza nodo:467 / Elemento padre: 466   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(467)).setAttribute("nombre","lblAtributo2Lista" );
      ((Element)v.get(467)).setAttribute("ancho","110" );
      ((Element)v.get(467)).setAttribute("alto","20" );
      ((Element)v.get(467)).setAttribute("filas","1" );
      ((Element)v.get(467)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(467)).setAttribute("cod","190" );
      ((Element)v.get(466)).appendChild((Element)v.get(467));
      /* Termina nodo:467   */
      /* Termina nodo:466   */

      /* Empieza nodo:468 / Elemento padre: 431   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(468)).setAttribute("id","fondoCabecera" );
      ((Element)v.get(468)).setAttribute("ancho","110" );
      ((Element)v.get(431)).appendChild((Element)v.get(468));

      /* Empieza nodo:469 / Elemento padre: 468   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(469)).setAttribute("nombre","lblAtributo3Lista" );
      ((Element)v.get(469)).setAttribute("ancho","110" );
      ((Element)v.get(469)).setAttribute("alto","20" );
      ((Element)v.get(469)).setAttribute("filas","1" );
      ((Element)v.get(469)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(469)).setAttribute("cod","191" );
      ((Element)v.get(468)).appendChild((Element)v.get(469));
      /* Termina nodo:469   */
      /* Termina nodo:468   */

      /* Empieza nodo:470 / Elemento padre: 431   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(470)).setAttribute("id","fondoCabecera" );
      ((Element)v.get(470)).setAttribute("ancho","110" );
      ((Element)v.get(431)).appendChild((Element)v.get(470));

      /* Empieza nodo:471 / Elemento padre: 470   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(471)).setAttribute("nombre","lblAltoLista" );
      ((Element)v.get(471)).setAttribute("ancho","110" );
      ((Element)v.get(471)).setAttribute("alto","20" );
      ((Element)v.get(471)).setAttribute("filas","1" );
      ((Element)v.get(471)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(471)).setAttribute("cod","2493" );
      ((Element)v.get(470)).appendChild((Element)v.get(471));
      /* Termina nodo:471   */
      /* Termina nodo:470   */

      /* Empieza nodo:472 / Elemento padre: 431   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(472)).setAttribute("id","fondoCabecera" );
      ((Element)v.get(472)).setAttribute("ancho","110" );
      ((Element)v.get(431)).appendChild((Element)v.get(472));

      /* Empieza nodo:473 / Elemento padre: 472   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(473)).setAttribute("nombre","lblLargoLista" );
      ((Element)v.get(473)).setAttribute("ancho","110" );
      ((Element)v.get(473)).setAttribute("alto","20" );
      ((Element)v.get(473)).setAttribute("filas","1" );
      ((Element)v.get(473)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(473)).setAttribute("cod","2494" );
      ((Element)v.get(472)).appendChild((Element)v.get(473));
      /* Termina nodo:473   */
      /* Termina nodo:472   */

      /* Empieza nodo:474 / Elemento padre: 431   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(474)).setAttribute("id","fondoCabecera" );
      ((Element)v.get(474)).setAttribute("ancho","110" );
      ((Element)v.get(431)).appendChild((Element)v.get(474));

      /* Empieza nodo:475 / Elemento padre: 474   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(475)).setAttribute("nombre","lblAnchoLista" );
      ((Element)v.get(475)).setAttribute("ancho","110" );
      ((Element)v.get(475)).setAttribute("alto","20" );
      ((Element)v.get(475)).setAttribute("filas","1" );
      ((Element)v.get(475)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(475)).setAttribute("cod","2495" );
      ((Element)v.get(474)).appendChild((Element)v.get(475));
      /* Termina nodo:475   */
      /* Termina nodo:474   */

      /* Empieza nodo:476 / Elemento padre: 431   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(476)).setAttribute("id","fondoCabecera" );
      ((Element)v.get(476)).setAttribute("ancho","310" );
      ((Element)v.get(431)).appendChild((Element)v.get(476));

      /* Empieza nodo:477 / Elemento padre: 476   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(477)).setAttribute("nombre","lblUdMedidaLista" );
      ((Element)v.get(477)).setAttribute("ancho","310" );
      ((Element)v.get(477)).setAttribute("alto","20" );
      ((Element)v.get(477)).setAttribute("filas","1" );
      ((Element)v.get(477)).setAttribute("id","datosCamposCabecera" );
   }

   private void getXML1980(Document doc) {
      ((Element)v.get(477)).setAttribute("cod","2496" );
      ((Element)v.get(476)).appendChild((Element)v.get(477));
      /* Termina nodo:477   */
      /* Termina nodo:476   */

      /* Empieza nodo:478 / Elemento padre: 431   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(478)).setAttribute("id","fondoCabecera" );
      ((Element)v.get(478)).setAttribute("ancho","210" );
      ((Element)v.get(431)).appendChild((Element)v.get(478));

      /* Empieza nodo:479 / Elemento padre: 478   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(479)).setAttribute("nombre","lblVolumenLista" );
      ((Element)v.get(479)).setAttribute("ancho","210" );
      ((Element)v.get(479)).setAttribute("alto","20" );
      ((Element)v.get(479)).setAttribute("filas","1" );
      ((Element)v.get(479)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(479)).setAttribute("cod","2478" );
      ((Element)v.get(478)).appendChild((Element)v.get(479));
      /* Termina nodo:479   */
      /* Termina nodo:478   */

      /* Empieza nodo:480 / Elemento padre: 431   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(480)).setAttribute("id","fondoCabecera" );
      ((Element)v.get(480)).setAttribute("ancho","110" );
      ((Element)v.get(431)).appendChild((Element)v.get(480));

      /* Empieza nodo:481 / Elemento padre: 480   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(481)).setAttribute("nombre","lblPesoLista" );
      ((Element)v.get(481)).setAttribute("ancho","110" );
      ((Element)v.get(481)).setAttribute("alto","20" );
      ((Element)v.get(481)).setAttribute("filas","1" );
      ((Element)v.get(481)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(481)).setAttribute("cod","350" );
      ((Element)v.get(480)).appendChild((Element)v.get(481));
      /* Termina nodo:481   */
      /* Termina nodo:480   */

      /* Empieza nodo:482 / Elemento padre: 431   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(482)).setAttribute("id","fondoCabecera" );
      ((Element)v.get(482)).setAttribute("ancho","410" );
      ((Element)v.get(431)).appendChild((Element)v.get(482));

      /* Empieza nodo:483 / Elemento padre: 482   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(483)).setAttribute("nombre","lblUdMedidaPesoLista" );
      ((Element)v.get(483)).setAttribute("ancho","410" );
      ((Element)v.get(483)).setAttribute("alto","20" );
      ((Element)v.get(483)).setAttribute("filas","1" );
      ((Element)v.get(483)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(483)).setAttribute("cod","2497" );
      ((Element)v.get(482)).appendChild((Element)v.get(483));
      /* Termina nodo:483   */
      /* Termina nodo:482   */

      /* Empieza nodo:484 / Elemento padre: 431   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(484)).setAttribute("id","fondoCabecera" );
      ((Element)v.get(484)).setAttribute("ancho","250" );
      ((Element)v.get(431)).appendChild((Element)v.get(484));

      /* Empieza nodo:485 / Elemento padre: 484   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(485)).setAttribute("nombre","lblUdDentroPedidoLista" );
      ((Element)v.get(485)).setAttribute("ancho","250" );
      ((Element)v.get(485)).setAttribute("alto","20" );
      ((Element)v.get(485)).setAttribute("filas","1" );
      ((Element)v.get(485)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(485)).setAttribute("cod","2498" );
      ((Element)v.get(484)).appendChild((Element)v.get(485));
      /* Termina nodo:485   */
      /* Termina nodo:484   */

      /* Empieza nodo:486 / Elemento padre: 431   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(486)).setAttribute("id","fondoCabecera" );
      ((Element)v.get(486)).setAttribute("ancho","150" );
      ((Element)v.get(431)).appendChild((Element)v.get(486));

      /* Empieza nodo:487 / Elemento padre: 486   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(487)).setAttribute("nombre","lblUdCajaLista" );
      ((Element)v.get(487)).setAttribute("ancho","150" );
      ((Element)v.get(487)).setAttribute("alto","20" );
      ((Element)v.get(487)).setAttribute("filas","1" );
      ((Element)v.get(487)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(487)).setAttribute("cod","2505" );
      ((Element)v.get(486)).appendChild((Element)v.get(487));
      /* Termina nodo:487   */
      /* Termina nodo:486   */

      /* Empieza nodo:488 / Elemento padre: 431   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(488)).setAttribute("id","fondoCabecera" );
      ((Element)v.get(488)).setAttribute("ancho","410" );
      ((Element)v.get(431)).appendChild((Element)v.get(488));

      /* Empieza nodo:489 / Elemento padre: 488   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(489)).setAttribute("nombre","lblUdMedidaVentaLista" );
      ((Element)v.get(489)).setAttribute("ancho","410" );
      ((Element)v.get(489)).setAttribute("alto","20" );
      ((Element)v.get(489)).setAttribute("filas","1" );
      ((Element)v.get(489)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(489)).setAttribute("cod","2499" );
      ((Element)v.get(488)).appendChild((Element)v.get(489));
      /* Termina nodo:489   */
      /* Termina nodo:488   */

      /* Empieza nodo:490 / Elemento padre: 431   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(490)).setAttribute("id","fondoCabecera" );
      ((Element)v.get(490)).setAttribute("ancho","170" );
      ((Element)v.get(431)).appendChild((Element)v.get(490));

      /* Empieza nodo:491 / Elemento padre: 490   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(491)).setAttribute("nombre","lblCosteEstandarLista" );
      ((Element)v.get(491)).setAttribute("ancho","170" );
      ((Element)v.get(491)).setAttribute("alto","20" );
      ((Element)v.get(491)).setAttribute("filas","1" );
      ((Element)v.get(491)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(491)).setAttribute("cod","2483" );
      ((Element)v.get(490)).appendChild((Element)v.get(491));
      /* Termina nodo:491   */
      /* Termina nodo:490   */

      /* Empieza nodo:492 / Elemento padre: 431   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(492)).setAttribute("id","fondoCabecera" );
      ((Element)v.get(492)).setAttribute("ancho","170" );
      ((Element)v.get(431)).appendChild((Element)v.get(492));

      /* Empieza nodo:493 / Elemento padre: 492   */
   }

   private void getXML2070(Document doc) {
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(493)).setAttribute("nombre","lblPrecioPosicionamientoLista" );
      ((Element)v.get(493)).setAttribute("ancho","170" );
      ((Element)v.get(493)).setAttribute("alto","20" );
      ((Element)v.get(493)).setAttribute("filas","1" );
      ((Element)v.get(493)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(493)).setAttribute("cod","2484" );
      ((Element)v.get(492)).appendChild((Element)v.get(493));
      /* Termina nodo:493   */
      /* Termina nodo:492   */

      /* Empieza nodo:494 / Elemento padre: 431   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(494)).setAttribute("id","fondoCabecera" );
      ((Element)v.get(494)).setAttribute("ancho","100" );
      ((Element)v.get(431)).appendChild((Element)v.get(494));

      /* Empieza nodo:495 / Elemento padre: 494   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(495)).setAttribute("nombre","lblSituacionLista" );
      ((Element)v.get(495)).setAttribute("ancho","100" );
      ((Element)v.get(495)).setAttribute("alto","20" );
      ((Element)v.get(495)).setAttribute("filas","1" );
      ((Element)v.get(495)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(495)).setAttribute("cod","2485" );
      ((Element)v.get(494)).appendChild((Element)v.get(495));
      /* Termina nodo:495   */
      /* Termina nodo:494   */

      /* Empieza nodo:496 / Elemento padre: 431   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(496)).setAttribute("id","fondoCabecera" );
      ((Element)v.get(496)).setAttribute("ancho","310" );
      ((Element)v.get(431)).appendChild((Element)v.get(496));

      /* Empieza nodo:497 / Elemento padre: 496   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(497)).setAttribute("nombre","lblEstatusdelProductoLista" );
      ((Element)v.get(497)).setAttribute("ancho","310" );
      ((Element)v.get(497)).setAttribute("alto","20" );
      ((Element)v.get(497)).setAttribute("filas","1" );
      ((Element)v.get(497)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(497)).setAttribute("cod","2487" );
      ((Element)v.get(496)).appendChild((Element)v.get(497));
      /* Termina nodo:497   */
      /* Termina nodo:496   */

      /* Empieza nodo:498 / Elemento padre: 431   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(498)).setAttribute("id","fondoCabecera" );
      ((Element)v.get(498)).setAttribute("ancho","210" );
      ((Element)v.get(431)).appendChild((Element)v.get(498));

      /* Empieza nodo:499 / Elemento padre: 498   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(499)).setAttribute("nombre","lblIndicadorDentroCajaLista" );
      ((Element)v.get(499)).setAttribute("ancho","210" );
      ((Element)v.get(499)).setAttribute("alto","20" );
      ((Element)v.get(499)).setAttribute("filas","1" );
      ((Element)v.get(499)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(499)).setAttribute("cod","2500" );
      ((Element)v.get(498)).appendChild((Element)v.get(499));
      /* Termina nodo:499   */
      /* Termina nodo:498   */

      /* Empieza nodo:500 / Elemento padre: 431   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(500)).setAttribute("id","fondoCabecera" );
      ((Element)v.get(500)).setAttribute("ancho","220" );
      ((Element)v.get(431)).appendChild((Element)v.get(500));

      /* Empieza nodo:501 / Elemento padre: 500   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(501)).setAttribute("nombre","lblCodPagoFraccionadoLista" );
      ((Element)v.get(501)).setAttribute("ancho","220" );
      ((Element)v.get(501)).setAttribute("alto","20" );
      ((Element)v.get(501)).setAttribute("filas","1" );
      ((Element)v.get(501)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(501)).setAttribute("cod","2501" );
      ((Element)v.get(500)).appendChild((Element)v.get(501));
      /* Termina nodo:501   */
      /* Termina nodo:500   */

      /* Empieza nodo:502 / Elemento padre: 431   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(502)).setAttribute("id","fondoCabecera" );
      ((Element)v.get(502)).setAttribute("ancho","150" );
      ((Element)v.get(431)).appendChild((Element)v.get(502));

      /* Empieza nodo:503 / Elemento padre: 502   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(503)).setAttribute("nombre","lblCodImpuestoLista" );
      ((Element)v.get(503)).setAttribute("ancho","150" );
      ((Element)v.get(503)).setAttribute("alto","20" );
      ((Element)v.get(503)).setAttribute("filas","1" );
      ((Element)v.get(503)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(503)).setAttribute("cod","2502" );
      ((Element)v.get(502)).appendChild((Element)v.get(503));
      /* Termina nodo:503   */
      /* Termina nodo:502   */

      /* Empieza nodo:504 / Elemento padre: 431   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(504)).setAttribute("id","fondoCabecera" );
      ((Element)v.get(504)).setAttribute("ancho","30" );
      ((Element)v.get(431)).appendChild((Element)v.get(504));

      /* Empieza nodo:505 / Elemento padre: 504   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(505)).setAttribute("nombre","lblVacia" );
      ((Element)v.get(505)).setAttribute("ancho","30" );
      ((Element)v.get(505)).setAttribute("alto","20" );
      ((Element)v.get(505)).setAttribute("filas","1" );
      ((Element)v.get(505)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(505)).setAttribute("cod","" );
      ((Element)v.get(504)).appendChild((Element)v.get(505));
      /* Termina nodo:505   */
      /* Termina nodo:504   */
      /* Termina nodo:431   */

      /* Empieza nodo:506 / Elemento padre: 430   */
      v.add(doc.createElement("PRESENTACION"));
      ((Element)v.get(506)).setAttribute("ancho","8030" );
      ((Element)v.get(506)).setAttribute("filas","1" );
      ((Element)v.get(506)).setAttribute("bloquesid","['datosCamposCenterImpar', 'datosCamposCenterPar', 'datosCamposCenterImpar', 'datosCamposCenterPar',             'datosCamposCenterImpar', 'datosCamposCenterPar', 'datosCamposCenterImpar', 'datosCamposCenterPar',             'datosCamposCenterImpar', 'datosCamposCenterPar', 'datosCamposCenterImpar', 'datosCamposCenterPar',             'datosCamposCenterImpar', 'datosCamposCenterPar', 'datosCamposCenterImpar', 'datosCamposCenterPar',             'datosCamposCenterImpar', 'datosCamposCenterPar', 'datosCamposCenterImpar', 'datosCamposCenterPar',             'datosCamposCenterImpar', 'datosCamposCenterPar', 'datosCamposCenterImpar', 'datosCamposCenterPar',             'datosCamposCenterImpar', 'datosCamposCenterPar', 'datosCamposCenterImpar', 'datosCamposCenterPar',             'datosCamposCenterImpar', 'datosCamposCenterPar', 'datosCamposCenterImpar', 'datosCamposCenterPar',             'datosCamposCenterImpar', 'datosCamposCenterPar', 'datosCamposCenterImpar' ]" );
      ((Element)v.get(430)).appendChild((Element)v.get(506));

      /* Empieza nodo:507 / Elemento padre: 506   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(507)).setAttribute("ancho","20" );
      ((Element)v.get(506)).appendChild((Element)v.get(507));
      /* Termina nodo:507   */

      /* Empieza nodo:508 / Elemento padre: 506   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(508)).setAttribute("ancho","210" );
   }

   private void getXML2160(Document doc) {
      ((Element)v.get(508)).setAttribute("caracteres","20" );
      ((Element)v.get(506)).appendChild((Element)v.get(508));

      /* Elemento padre:508 / Elemento actual: 509   */
      v.add(doc.createTextNode("Código SAP"));
      ((Element)v.get(508)).appendChild((Text)v.get(509));

      /* Termina nodo Texto:509   */
      /* Termina nodo:508   */

      /* Empieza nodo:510 / Elemento padre: 506   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(510)).setAttribute("ancho","190" );
      ((Element)v.get(510)).setAttribute("caracteres","18" );
      ((Element)v.get(506)).appendChild((Element)v.get(510));

      /* Elemento padre:510 / Elemento actual: 511   */
      v.add(doc.createTextNode("Código Antiguo"));
      ((Element)v.get(510)).appendChild((Text)v.get(511));

      /* Termina nodo Texto:511   */
      /* Termina nodo:510   */

      /* Empieza nodo:512 / Elemento padre: 506   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(512)).setAttribute("ancho","410" );
      ((Element)v.get(512)).setAttribute("caracteres","40" );
      ((Element)v.get(506)).appendChild((Element)v.get(512));

      /* Elemento padre:512 / Elemento actual: 513   */
      v.add(doc.createTextNode("Descripción SAP"));
      ((Element)v.get(512)).appendChild((Text)v.get(513));

      /* Termina nodo Texto:513   */
      /* Termina nodo:512   */

      /* Empieza nodo:514 / Elemento padre: 506   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(514)).setAttribute("ancho","410" );
      ((Element)v.get(514)).setAttribute("caracteres","40" );
      ((Element)v.get(506)).appendChild((Element)v.get(514));

      /* Elemento padre:514 / Elemento actual: 515   */
      v.add(doc.createTextNode("Descripción Corta"));
      ((Element)v.get(514)).appendChild((Text)v.get(515));

      /* Termina nodo Texto:515   */
      /* Termina nodo:514   */

      /* Empieza nodo:516 / Elemento padre: 506   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(516)).setAttribute("ancho","100" );
      ((Element)v.get(516)).setAttribute("caracteres","4" );
      ((Element)v.get(506)).appendChild((Element)v.get(516));

      /* Elemento padre:516 / Elemento actual: 517   */
      v.add(doc.createTextNode("Lote"));
      ((Element)v.get(516)).appendChild((Text)v.get(517));

      /* Termina nodo Texto:517   */
      /* Termina nodo:516   */

      /* Empieza nodo:518 / Elemento padre: 506   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(518)).setAttribute("ancho","100" );
      ((Element)v.get(518)).setAttribute("caracteres","9" );
      ((Element)v.get(506)).appendChild((Element)v.get(518));

      /* Elemento padre:518 / Elemento actual: 519   */
      v.add(doc.createTextNode("Tipo"));
      ((Element)v.get(518)).appendChild((Text)v.get(519));

      /* Termina nodo Texto:519   */
      /* Termina nodo:518   */

      /* Empieza nodo:520 / Elemento padre: 506   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(520)).setAttribute("ancho","310" );
      ((Element)v.get(520)).setAttribute("caracteres","30" );
      ((Element)v.get(506)).appendChild((Element)v.get(520));

      /* Elemento padre:520 / Elemento actual: 521   */
      v.add(doc.createTextNode("Marca"));
      ((Element)v.get(520)).appendChild((Text)v.get(521));

      /* Termina nodo Texto:521   */
      /* Termina nodo:520   */

      /* Empieza nodo:522 / Elemento padre: 506   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(522)).setAttribute("ancho","410" );
      ((Element)v.get(522)).setAttribute("caracteres","40" );
      ((Element)v.get(506)).appendChild((Element)v.get(522));

      /* Elemento padre:522 / Elemento actual: 523   */
      v.add(doc.createTextNode("Unidad de Negocio"));
      ((Element)v.get(522)).appendChild((Text)v.get(523));

      /* Termina nodo Texto:523   */
      /* Termina nodo:522   */

      /* Empieza nodo:524 / Elemento padre: 506   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(524)).setAttribute("ancho","410" );
      ((Element)v.get(524)).setAttribute("caracteres","40" );
      ((Element)v.get(506)).appendChild((Element)v.get(524));

      /* Elemento padre:524 / Elemento actual: 525   */
      v.add(doc.createTextNode("Negocio"));
      ((Element)v.get(524)).appendChild((Text)v.get(525));

      /* Termina nodo Texto:525   */
      /* Termina nodo:524   */

      /* Empieza nodo:526 / Elemento padre: 506   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(526)).setAttribute("ancho","410" );
      ((Element)v.get(526)).setAttribute("caracteres","40" );
      ((Element)v.get(506)).appendChild((Element)v.get(526));

      /* Elemento padre:526 / Elemento actual: 527   */
      v.add(doc.createTextNode("Generico"));
      ((Element)v.get(526)).appendChild((Text)v.get(527));

      /* Termina nodo Texto:527   */
      /* Termina nodo:526   */

      /* Empieza nodo:528 / Elemento padre: 506   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(528)).setAttribute("ancho","410" );
      ((Element)v.get(528)).setAttribute("caracteres","40" );
      ((Element)v.get(506)).appendChild((Element)v.get(528));

      /* Elemento padre:528 / Elemento actual: 529   */
      v.add(doc.createTextNode("Supergenerico"));
      ((Element)v.get(528)).appendChild((Text)v.get(529));

      /* Termina nodo Texto:529   */
      /* Termina nodo:528   */

      /* Empieza nodo:530 / Elemento padre: 506   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(530)).setAttribute("ancho","130" );
      ((Element)v.get(530)).setAttribute("caracteres","12" );
      ((Element)v.get(506)).appendChild((Element)v.get(530));

      /* Elemento padre:530 / Elemento actual: 531   */
      v.add(doc.createTextNode("Jerarquia 1"));
      ((Element)v.get(530)).appendChild((Text)v.get(531));

      /* Termina nodo Texto:531   */
      /* Termina nodo:530   */

      /* Empieza nodo:532 / Elemento padre: 506   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(532)).setAttribute("ancho","130" );
      ((Element)v.get(532)).setAttribute("caracteres","12" );
      ((Element)v.get(506)).appendChild((Element)v.get(532));

      /* Elemento padre:532 / Elemento actual: 533   */
      v.add(doc.createTextNode("Jerarquia 2"));
      ((Element)v.get(532)).appendChild((Text)v.get(533));

      /* Termina nodo Texto:533   */
      /* Termina nodo:532   */

      /* Empieza nodo:534 / Elemento padre: 506   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(534)).setAttribute("ancho","130" );
      ((Element)v.get(534)).setAttribute("caracteres","12" );
      ((Element)v.get(506)).appendChild((Element)v.get(534));

      /* Elemento padre:534 / Elemento actual: 535   */
      v.add(doc.createTextNode("Jerarquia 3"));
      ((Element)v.get(534)).appendChild((Text)v.get(535));

      /* Termina nodo Texto:535   */
      /* Termina nodo:534   */

      /* Empieza nodo:536 / Elemento padre: 506   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(536)).setAttribute("ancho","410" );
      ((Element)v.get(536)).setAttribute("caracteres","40" );
      ((Element)v.get(506)).appendChild((Element)v.get(536));

      /* Elemento padre:536 / Elemento actual: 537   */
      v.add(doc.createTextNode("Linea"));
      ((Element)v.get(536)).appendChild((Text)v.get(537));

      /* Termina nodo Texto:537   */
      /* Termina nodo:536   */

      /* Empieza nodo:538 / Elemento padre: 506   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(538)).setAttribute("ancho","110" );
   }

   private void getXML2250(Document doc) {
      ((Element)v.get(538)).setAttribute("caracteres","10" );
      ((Element)v.get(506)).appendChild((Element)v.get(538));

      /* Elemento padre:538 / Elemento actual: 539   */
      v.add(doc.createTextNode("Atributo 1"));
      ((Element)v.get(538)).appendChild((Text)v.get(539));

      /* Termina nodo Texto:539   */
      /* Termina nodo:538   */

      /* Empieza nodo:540 / Elemento padre: 506   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(540)).setAttribute("ancho","110" );
      ((Element)v.get(540)).setAttribute("caracteres","10" );
      ((Element)v.get(506)).appendChild((Element)v.get(540));

      /* Elemento padre:540 / Elemento actual: 541   */
      v.add(doc.createTextNode("Atributo 2"));
      ((Element)v.get(540)).appendChild((Text)v.get(541));

      /* Termina nodo Texto:541   */
      /* Termina nodo:540   */

      /* Empieza nodo:542 / Elemento padre: 506   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(542)).setAttribute("ancho","110" );
      ((Element)v.get(542)).setAttribute("caracteres","10" );
      ((Element)v.get(506)).appendChild((Element)v.get(542));

      /* Elemento padre:542 / Elemento actual: 543   */
      v.add(doc.createTextNode("Atributo 3"));
      ((Element)v.get(542)).appendChild((Text)v.get(543));

      /* Termina nodo Texto:543   */
      /* Termina nodo:542   */

      /* Empieza nodo:544 / Elemento padre: 506   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(544)).setAttribute("ancho","110" );
      ((Element)v.get(544)).setAttribute("caracteres","10" );
      ((Element)v.get(506)).appendChild((Element)v.get(544));

      /* Elemento padre:544 / Elemento actual: 545   */
      v.add(doc.createTextNode("Alto"));
      ((Element)v.get(544)).appendChild((Text)v.get(545));

      /* Termina nodo Texto:545   */
      /* Termina nodo:544   */

      /* Empieza nodo:546 / Elemento padre: 506   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(546)).setAttribute("ancho","110" );
      ((Element)v.get(546)).setAttribute("caracteres","10" );
      ((Element)v.get(506)).appendChild((Element)v.get(546));

      /* Elemento padre:546 / Elemento actual: 547   */
      v.add(doc.createTextNode("Largo"));
      ((Element)v.get(546)).appendChild((Text)v.get(547));

      /* Termina nodo Texto:547   */
      /* Termina nodo:546   */

      /* Empieza nodo:548 / Elemento padre: 506   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(548)).setAttribute("ancho","110" );
      ((Element)v.get(548)).setAttribute("caracteres","10" );
      ((Element)v.get(506)).appendChild((Element)v.get(548));

      /* Elemento padre:548 / Elemento actual: 549   */
      v.add(doc.createTextNode("Ancho"));
      ((Element)v.get(548)).appendChild((Text)v.get(549));

      /* Termina nodo Texto:549   */
      /* Termina nodo:548   */

      /* Empieza nodo:550 / Elemento padre: 506   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(550)).setAttribute("ancho","310" );
      ((Element)v.get(550)).setAttribute("caracteres","30" );
      ((Element)v.get(506)).appendChild((Element)v.get(550));

      /* Elemento padre:550 / Elemento actual: 551   */
      v.add(doc.createTextNode("Ud. Medida"));
      ((Element)v.get(550)).appendChild((Text)v.get(551));

      /* Termina nodo Texto:551   */
      /* Termina nodo:550   */

      /* Empieza nodo:552 / Elemento padre: 506   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(552)).setAttribute("ancho","210" );
      ((Element)v.get(552)).setAttribute("caracteres","20" );
      ((Element)v.get(506)).appendChild((Element)v.get(552));

      /* Elemento padre:552 / Elemento actual: 553   */
      v.add(doc.createTextNode("Volumen"));
      ((Element)v.get(552)).appendChild((Text)v.get(553));

      /* Termina nodo Texto:553   */
      /* Termina nodo:552   */

      /* Empieza nodo:554 / Elemento padre: 506   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(554)).setAttribute("ancho","110" );
      ((Element)v.get(554)).setAttribute("caracteres","10" );
      ((Element)v.get(506)).appendChild((Element)v.get(554));

      /* Elemento padre:554 / Elemento actual: 555   */
      v.add(doc.createTextNode("Peso"));
      ((Element)v.get(554)).appendChild((Text)v.get(555));

      /* Termina nodo Texto:555   */
      /* Termina nodo:554   */

      /* Empieza nodo:556 / Elemento padre: 506   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(556)).setAttribute("ancho","410" );
      ((Element)v.get(556)).setAttribute("caracteres","40" );
      ((Element)v.get(506)).appendChild((Element)v.get(556));

      /* Elemento padre:556 / Elemento actual: 557   */
      v.add(doc.createTextNode("Ud. Medida Peso"));
      ((Element)v.get(556)).appendChild((Text)v.get(557));

      /* Termina nodo Texto:557   */
      /* Termina nodo:556   */

      /* Empieza nodo:558 / Elemento padre: 506   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(558)).setAttribute("ancho","250" );
      ((Element)v.get(558)).setAttribute("caracteres","17" );
      ((Element)v.get(506)).appendChild((Element)v.get(558));

      /* Elemento padre:558 / Elemento actual: 559   */
      v.add(doc.createTextNode("Ud. Dentro Pedido"));
      ((Element)v.get(558)).appendChild((Text)v.get(559));

      /* Termina nodo Texto:559   */
      /* Termina nodo:558   */

      /* Empieza nodo:560 / Elemento padre: 506   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(560)).setAttribute("ancho","150" );
      ((Element)v.get(560)).setAttribute("caracteres","8" );
      ((Element)v.get(506)).appendChild((Element)v.get(560));

      /* Elemento padre:560 / Elemento actual: 561   */
      v.add(doc.createTextNode("Ud. Caja"));
      ((Element)v.get(560)).appendChild((Text)v.get(561));

      /* Termina nodo Texto:561   */
      /* Termina nodo:560   */

      /* Empieza nodo:562 / Elemento padre: 506   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(562)).setAttribute("ancho","410" );
      ((Element)v.get(562)).setAttribute("caracteres","40" );
      ((Element)v.get(506)).appendChild((Element)v.get(562));

      /* Elemento padre:562 / Elemento actual: 563   */
      v.add(doc.createTextNode("Ud. Medida Venta"));
      ((Element)v.get(562)).appendChild((Text)v.get(563));

      /* Termina nodo Texto:563   */
      /* Termina nodo:562   */

      /* Empieza nodo:564 / Elemento padre: 506   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(564)).setAttribute("ancho","170" );
      ((Element)v.get(564)).setAttribute("caracteres","16" );
      ((Element)v.get(506)).appendChild((Element)v.get(564));

      /* Elemento padre:564 / Elemento actual: 565   */
      v.add(doc.createTextNode("Coste Estandar"));
      ((Element)v.get(564)).appendChild((Text)v.get(565));

      /* Termina nodo Texto:565   */
      /* Termina nodo:564   */

      /* Empieza nodo:566 / Elemento padre: 506   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(566)).setAttribute("ancho","170" );
      ((Element)v.get(566)).setAttribute("caracteres","16" );
      ((Element)v.get(506)).appendChild((Element)v.get(566));

      /* Elemento padre:566 / Elemento actual: 567   */
      v.add(doc.createTextNode("Precio Posicionamiento"));
      ((Element)v.get(566)).appendChild((Text)v.get(567));

      /* Termina nodo Texto:567   */
      /* Termina nodo:566   */

      /* Empieza nodo:568 / Elemento padre: 506   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(568)).setAttribute("ancho","100" );
   }

   private void getXML2340(Document doc) {
      ((Element)v.get(568)).setAttribute("caracteres","9" );
      ((Element)v.get(506)).appendChild((Element)v.get(568));

      /* Elemento padre:568 / Elemento actual: 569   */
      v.add(doc.createTextNode("Situación"));
      ((Element)v.get(568)).appendChild((Text)v.get(569));

      /* Termina nodo Texto:569   */
      /* Termina nodo:568   */

      /* Empieza nodo:570 / Elemento padre: 506   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(570)).setAttribute("ancho","310" );
      ((Element)v.get(570)).setAttribute("caracteres","30" );
      ((Element)v.get(506)).appendChild((Element)v.get(570));

      /* Elemento padre:570 / Elemento actual: 571   */
      v.add(doc.createTextNode("Estatus del Producto"));
      ((Element)v.get(570)).appendChild((Text)v.get(571));

      /* Termina nodo Texto:571   */
      /* Termina nodo:570   */

      /* Empieza nodo:572 / Elemento padre: 506   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(572)).setAttribute("ancho","210" );
      ((Element)v.get(572)).setAttribute("caracteres","20" );
      ((Element)v.get(506)).appendChild((Element)v.get(572));

      /* Elemento padre:572 / Elemento actual: 573   */
      v.add(doc.createTextNode("Indicador Dentro Caja"));
      ((Element)v.get(572)).appendChild((Text)v.get(573));

      /* Termina nodo Texto:573   */
      /* Termina nodo:572   */

      /* Empieza nodo:574 / Elemento padre: 506   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(574)).setAttribute("ancho","220" );
      ((Element)v.get(574)).setAttribute("caracteres","10" );
      ((Element)v.get(506)).appendChild((Element)v.get(574));

      /* Elemento padre:574 / Elemento actual: 575   */
      v.add(doc.createTextNode("Cod. Pago Fraccionado"));
      ((Element)v.get(574)).appendChild((Text)v.get(575));

      /* Termina nodo Texto:575   */
      /* Termina nodo:574   */

      /* Empieza nodo:576 / Elemento padre: 506   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(576)).setAttribute("ancho","150" );
      ((Element)v.get(576)).setAttribute("caracteres","10" );
      ((Element)v.get(506)).appendChild((Element)v.get(576));

      /* Elemento padre:576 / Elemento actual: 577   */
      v.add(doc.createTextNode("Cod. Impuesto"));
      ((Element)v.get(576)).appendChild((Text)v.get(577));

      /* Termina nodo Texto:577   */
      /* Termina nodo:576   */
      /* Termina nodo:506   */

      /* Empieza nodo:578 / Elemento padre: 430   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(430)).appendChild((Element)v.get(578));
      /* Termina nodo:578   */
      /* Termina nodo:430   */
      /* Termina nodo:429   */

      /* Empieza nodo:579 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(579)).setAttribute("nombre","capaBotonModificar" );
      ((Element)v.get(579)).setAttribute("alto","25" );
      ((Element)v.get(579)).setAttribute("ancho","1294" );
      ((Element)v.get(579)).setAttribute("colorf","#CCCCCC" );
      ((Element)v.get(579)).setAttribute("borde","1" );
      ((Element)v.get(579)).setAttribute("imagenf","" );
      ((Element)v.get(579)).setAttribute("repeat","" );
      ((Element)v.get(579)).setAttribute("padding","" );
      ((Element)v.get(579)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(579)).setAttribute("contravsb","" );
      ((Element)v.get(579)).setAttribute("zindex","" );
      ((Element)v.get(579)).setAttribute("x","14" );
      ((Element)v.get(579)).setAttribute("y","1030" );
      ((Element)v.get(6)).appendChild((Element)v.get(579));

      /* Empieza nodo:580 / Elemento padre: 579   */
      v.add(doc.createElement("table"));
      ((Element)v.get(580)).setAttribute("width","100%" );
      ((Element)v.get(579)).appendChild((Element)v.get(580));

      /* Empieza nodo:581 / Elemento padre: 580   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(580)).appendChild((Element)v.get(581));

      /* Empieza nodo:582 / Elemento padre: 581   */
      v.add(doc.createElement("td"));
      ((Element)v.get(581)).appendChild((Element)v.get(582));

      /* Empieza nodo:583 / Elemento padre: 582   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(583)).setAttribute("nombre","btnModificar" );
      ((Element)v.get(583)).setAttribute("ID","botonContenido" );
      ((Element)v.get(583)).setAttribute("alt","" );
      ((Element)v.get(583)).setAttribute("estado","false" );
      ((Element)v.get(583)).setAttribute("accion","modificar();" );
      ((Element)v.get(583)).setAttribute("tipo","html" );
      ((Element)v.get(583)).setAttribute("cod","142" );
      ((Element)v.get(582)).appendChild((Element)v.get(583));
      /* Termina nodo:583   */
      /* Termina nodo:582   */
      /* Termina nodo:581   */
      /* Termina nodo:580   */
      /* Termina nodo:579   */
      /* Termina nodo:6   */


   }

}
