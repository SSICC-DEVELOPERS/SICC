
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_tipo_solicitud_pais_insertar  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_tipo_solicitud_pais_insertar" );
      ((Element)v.get(0)).setAttribute("cod","0608" );
      ((Element)v.get(0)).setAttribute("titulo","Insertar tipo de solicitud por país" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","Insertar tipo de solicitud por país" );
      ((Element)v.get(0)).setAttribute("onload","onLoad();" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(1)).setAttribute("src","sicc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(1));
      /* Termina nodo:1   */

      /* Empieza nodo:2 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(2)).setAttribute("src","DruidaTransactionMare.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(2));
      /* Termina nodo:2   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(3));

      /* Elemento padre:3 / Elemento actual: 4   */
      v.add(doc.createTextNode("\r	 \r		/**\r		 * Sistema:     Belcorp\r		 * Modulo:      PED\r		 * Fecha:       26/07/2004\r		 * @version     1.0\r		 * @autor       Maximiliano Dello Russo\r		 * Descripcion: \r		 */\r		var form = 'formulario.';\r		var elementos = new Array('cbTipoSolicitud', 'txtNumSolicitudesLote', 'txtAlarmaNumUnidades', 'ckSujetoFlete',\r								'ckPermiteUnionSolicitudes', 'cbTipoConsolidado', 'cbTipoDocumentoLegal', 'ckPermitirReversion',\r								'ckPedidoPrueba', 'ckComisionable', 'ckPedGtZona', 'ckCambioVentaBelcenter', 'ckVentaInterfazSAB14',\r								'cbSociedad', 'cbFormaPago', 'cbAlmacen', 'cbTipoMovimientoAsignacionStock', 'chkReservaStock',\r								'cbTipoMovimientoReservaStock', 'cbTipoMovimientoFacturacion', 'cbCodActividadCronograma',\r								'cbMoneda', 'atxtObservaciones');\r		 \r		function cargaComboActividad(){\r			limpiarActividades();\r			if(get(form + 'cbTipoSolicitud') != ''){            \r				recargaCombo(form + 'cbCodActividadCronograma', 'CRAObtieneActividadesPorTipoSolicitud', 'es.indra.sicc.util.DTOOID', armarArrayActividades(), \"marcaCombo(datos);\");\r			}\r        }\r\r		function marcaCombo(datos) {\r			var datosNuevo = new Array(); \r	        datosNuevo[0] = [\"\",\"\"];\r	        for (var i = 0; i < datos.length; i++ )\r		        datosNuevo[i+1]  = datos[i];\r\r			set_combo(\"formulario.cbCodActividadCronograma\", datosNuevo);\r	        var oid = get(form + 'actividad');\r	        var oidSeleccionado = new Array();\r		    oidSeleccionado = oid.split(\",\");	    \r		    set(\"formulario.cbCodActividadCronograma\", oidSeleccionado);\r		}\r\r		function onLoad() {\r			fMostrarMensajeError();\r			configurarMenuSecundario('formulario');\r			set(form + 'casoDeUso', get(form + 'accion'));\r\r			if( get(form + 'accion') == 'modificar' ){\r				seteaDatos();\r				cargaComboActividad();\r				accion(form + elementos[0], '.disabled=true');\r				focaliza(form + elementos[1]);\r			}\r\r			if( get(form + 'accion') == 'muestraInsercion' ){\r				cargaValoresPorDefecto();\r				focaliza(form + elementos[0]);\r				accion(form + 'cbTipoConsolidado', '.disabled=true');\r			}\r\r			if( get(form + 'accion') == 'muestraDetalle' ){\r				seteaDatos();\r				deshabilitaTodo();\r			}\r\r		    accion(form + 'cbTipoMovimientoReservaStock', '.disabled=true');\r		}\r\r		function cargaValoresPorDefecto(){\r			set(form + 'cbSociedad', [get(form + 'sociedad')]);\r		}\r\r		function fLimpiar(){\r			set(form + 'cbTipoSolicitud', [get(form + 'tipoSolicitud')]);\r			set(form + 'txtNumSolicitudesLote', get(form + 'numSolicitudesLote'));\r			set(form + 'txtAlarmaNumUnidades', get(form + 'alarmaNumUnidades'));\r			seteaCheck('ckSujetoFlete', get(form + 'sujetoAFlete'));\r			seteaCheck('ckPermiteUnionSolicitudes', get(form + 'permiteUnion'));\r			onChangePermiteUnion();\r			set(form + 'cbTipoConsolidado', [get(form + 'tipoConsolidado')]);\r			set(form + 'cbTipoDocumentoLegal', [get(form + 'tipoDocumentoLegal')]);\r			seteaCheck('ckPermitirReversion', get(form + 'permitirReversion'));\r			seteaCheck('ckPedidoPrueba', get(form + 'indPedidoPrueba'));\r			seteaCheck('ckComisionable', get(form + 'indComisionable'));\r			seteaCheck('ckPedGtZona', get(form + 'indPedGtZona'));			\r			seteaCheck('ckCambioVentaBelcenter', get(form + 'indCambioVentaBEL'));\r			seteaCheck('ckVentaInterfazSAB14', get(form + 'indVentaSAB14'));\r			set(form + 'cbSociedad', [get(form + 'sociedad')]);\r			set(form + 'cbFormaPago', [get(form + 'formaPago')]);	\r			set(form + 'cbAlmacen', [get(form + 'almacen')]);\r			set(form + 'cbTipoMovimientoAsignacionStock', [get(form + 'tipoMovAsigna')]);\r			seteaCheck('chkReservaStock', get(form + 'reservaStock'));\r			set(form + 'cbTipoMovimientoReservaStock', [get(form + 'tipoMovReserva')]);\r			set(form + 'cbTipoMovimientoFacturacion', [get(form + 'tipoMovFacturacion')]);\r			set(form + 'cbCodActividadCronograma', [get(form + 'actividad')]);\r			set(form + 'cbMoneda', [get(form + 'moneda')]);\r			set(form + 'atxtObservaciones', get(form + 'observaciones'));\r			if( get(form + 'accion') == 'modificar' ){\r				focaliza(form + elementos[1]);\r			}else{\r				focaliza(form + elementos[0]);\r			}\r			\r		}\r\r																function setRequerido(campo, esRequerido){\r			if( campo == null ) return;\r			if( esRequerido != true && esRequerido != false ){\r				return;\r			}\r			for(var i=0; i < objValidacionSICC.length; i++){\r				if(objValidacionSICC[i].nombre == campo){\r					objValidacionSICC[i].requerido = esRequerido;\r					return;\r				}\r			}\r			return;\r		}\r\r		function onChangePermiteUnion(){\r			if( get(form + 'ckPermiteUnionSolicitudes') == 'S' ){\r				accion(form + 'cbTipoConsolidado', '.disabled=false');\r				setRequerido('cbTipoConsolidado', true);\r			}else{\r				set(form + 'cbTipoConsolidado', ['']);	\r				setRequerido('cbTipoConsolidado', false);\r				accion(form + 'cbTipoConsolidado', '.disabled=true');\r			}\r		}\r\r		function fGuardar(){\r			set(form + 'accion', 'guardar');\r			if ( !sicc_validaciones_generales(\"resto\") )   				return false;\r\r			var reservaStock = get(form + \"chkReservaStock\");\r			if (reservaStock == \"S\")\r			{\r					if(!sicc_validaciones_generales(\"reservaStock\") )	{\r						return false;\r					}\r			}\r			var asignacion = get(form + 'cbTipoMovimientoAsignacionStock');\r			var reserva = get(form + 'cbTipoMovimientoReservaStock');\r			if( asignacion != '' && reserva != '' ){\r				GestionarMensaje('UIPED002', null, null, null);\r				                  \r			}\r			enviaSICC('formulario');\r		}\r\r		function borrarTodo(){\r		   /* vbongiov\r		      Se modifica porque no se estaba actualizando el combo de solicitudes posibles a consolidar con el valor grabado en un\r			  paso anterios\r           */  \r		   set(form + 'accion', 'muestraInsercion');\r			eval(form + 'oculto = \\'N\\'');\r         enviaSICC('formulario');\r\r\r		   /*\r			set(form + 'cbTipoSolicitud', ['']);\r			set(form + 'txtNumSolicitudesLote', '');\r			set(form + 'txtAlarmaNumUnidades', '0');\r			seteaCheck('ckSujetoFlete', 'N');\r			seteaCheck('ckPermiteUnionSolicitudes', 'N');\r			onChangePermiteUnion();\r			set(form + 'cbTipoConsolidado', ['']);\r			set(form + 'cbTipoDocumentoLegal', ['']);\r			seteaCheck('ckPermitirReversion', 'N');\r			seteaCheck('ckPedidoPrueba', 'N');\r			seteaCheck('ckComisionable', 'N');\r			seteaCheck('ckPedGtZona', 'N');			\r			seteaCheck('ckCambioVentaBelcenter', 'N');\r			seteaCheck('ckVentaInterfazSAB14', 'N');\r			set(form + 'cbSociedad', ['']);\r			set(form + 'cbFormaPago', ['']);	\r			set(form + 'cbAlmacen', ['']);\r			set(form + 'cbTipoMovimientoAsignacionStock', '');\r			seteaCheck('chkReservaStock', 'N');\r			set(form + 'cbTipoMovimientoReservaStock', ['']);\r			set(form + 'cbTipoMovimientoFacturacion', ['']);\r			set(form + 'cbCodActividadCronograma', ['']);\r			set(form + 'cbMoneda', ['']);\r			set(form + 'atxtObservaciones', '');\r			focaliza(form + 'cbTipoSolicitud');\r			cargaValoresPorDefecto();\r			*/\r		}\r\r		function seteaCheck(elemento, valor){\r			if( valor == 'true' ){\r				set(form + elemento, 'S');\r			}else{\r				set(form + elemento, 'N');\r			}\r		}\r\r		function tab(elemento){\r			try{\r				for(i=0; i < elementos.length; i++){\r					if( elementos[i] == elemento ){\r						if( i == elementos.length - 1 ) i = 0;\r						else i++;\r						document.selection.empty();\r						focaliza(form + elementos[i]);\r						return;\r					}\r				}\r			}catch(e){\r				tab(elementos[i]);\r			}\r		}\r\r		function shtab(elemento){\r			try{\r				for(i=elementos.length - 1; i >= 0 ; i--){\r					if( elementos[i] == elemento ){\r						if( i == 0 ) i = elementos.length - 1;\r						else i--;\r						document.selection.empty();\r						focaliza(form + elementos[i]);\r						return;\r					}\r				}\r			}catch(e){\r				shtab(elementos[i]);\r			}\r		}\r\r		function fVolver(){\r			if( get(form + 'accion') == 'modificar' || get(form + 'accion') == 'muestraDetalle' )\r				window.close();\r		}\r                 \r		function retornoModal(){\r			window.returnValue = true;\r		}\r\r		function seteaDatos(){\r			set(form + 'cbTipoSolicitud', [get(form + 'tipoSolicitud')]);\r			set(form + 'txtNumSolicitudesLote', get(form + 'numSolicitudesLote'));\r			set(form + 'txtAlarmaNumUnidades', get(form + 'alarmaNumUnidades'));\r			set(form + 'ckSujetoFlete', formateaBoolean(get(form + 'sujetoAFlete')));\r			set(form + 'ckPermiteUnionSolicitudes', formateaBoolean(get(form + 'permiteUnion')));\r			onChangePermiteUnion();\r			set(form + 'cbTipoConsolidado', [get(form + 'tipoConsolidado')]);\r			set(form + 'cbTipoDocumentoLegal', [get(form + 'tipoDocumentoLegal')]);\r			set(form + 'ckPermitirReversion', formateaBoolean(get(form + 'permitirReversion')));\r			set(form + 'ckPedidoPrueba', formateaBoolean(get(form + 'indPedidoPrueba')));\r			set(form + 'ckComisionable', formateaBoolean(get(form + 'indComisionable')));\r			set(form + 'ckPedGtZona', formateaBoolean(get(form + 'indPedGtZona')));\r			set(form + 'ckCambioVentaBelcenter', formateaBoolean(get(form + 'indCambioVentaBEL')));\r			set(form + 'ckVentaInterfazSAB14', formateaBoolean(get(form + 'indVentaSAB14')));\r			set(form + 'cbSociedad', [get(form + 'sociedad')]);\r			set(form + 'cbFormaPago',[get(form + 'formaPago')]);\r			set(form + 'cbAlmacen', [get(form + 'almacen')]);\r			set(form + 'cbTipoMovimientoAsignacionStock', [get(form + 'tipoMovAsigna')]);\r			set(form + 'chkReservaStock', formateaBoolean(get(form + 'reservaStock')));\r			set(form + 'cbTipoMovimientoReservaStock', [get(form + 'tipoMovReserva')]);\r			set(form + 'cbTipoMovimientoFacturacion', [get(form + 'tipoMovFacturacion')]);\r			set(form + 'cbCodActividadCronograma', [get(form + 'actividad')]);\r			set(form + 'cbMoneda', [get(form + 'moneda')]);\r			set(form + 'atxtObservaciones', get(form + 'observaciones'));\r		}\r		\r		function formateaBoolean(valor){\r			if( valor == 'true' )\r				return 'S'\r			else \r				return 'N'\r		}\r\r		function deshabilitaTodo(){\r			for( i=0; i < elementos.length; i++ ){\r				if( elementos[i] == 'atxtObservaciones' )\r					accion(form + elementos[i], '.readOnly=true');\r				else\r					accion(form + elementos[i], '.disabled=true');\r\r			}\r		}\r				 \r		function errorAlGuardar(){\r			if(get(form + 'casoDeUso') == 'modificar'){\r				focaliza(form + elementos[1]);\r			}else{\r				focaliza(form + elementos[0]);\r			}\r		}\r\r    function reservaStock() {\r      var reservaStock = get(form + \"chkReservaStock\");\r  \r			if (reservaStock == \"S\") {\r        accion(form + 'cbTipoMovimientoReservaStock', '.disabled=false');\r      }\r      else {\r        set(form + 'cbTipoMovimientoReservaStock', '');\r        accion(form + 'cbTipoMovimientoReservaStock', '.disabled=true');\r      }\r      \r    }\r\r    function onchange_TipoSolicitud(){\r         limpiarActividades();\r         if(get(form + 'cbTipoSolicitud') != ''){\r              recargaCombo(form + 'cbCodActividadCronograma', 'CRAObtieneActividadesPorTipoSolicitud', 'es.indra.sicc.util.DTOOID', armarArrayActividades());\r         }\r    }\r    function armarArrayActividades(){\r      var arr = new Array();\r      var oid = get(form + 'cbTipoSolicitud');\r      arr[arr.length] = new Array(\"oid\", oid);\r      var pais = get(form + 'pais');\r      arr[arr.length] = new Array(\"oidPais\", pais);\r      var idioma = get(form + 'idioma');\r      arr[arr.length] = new Array(\"oidIdioma\", idioma);\r      return arr;\r    }\r   function limpiarActividades(){\r			set_combo(form + 'cbCodActividadCronograma', new Array());\r   }\r\r\r\r	 \r"));
      ((Element)v.get(3)).appendChild((Text)v.get(4));

      /* Termina nodo Texto:4   */
      /* Termina nodo:3   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(5));

      /* Empieza nodo:6 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(6)).setAttribute("name","cbTipoSolicitud" );
      ((Element)v.get(6)).setAttribute("required","true" );
      ((Element)v.get(6)).setAttribute("group","resto" );
      ((Element)v.get(6)).setAttribute("cod","415" );
      ((Element)v.get(5)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(7)).setAttribute("name","cbTipoConsolidado" );
      ((Element)v.get(7)).setAttribute("required","false" );
      ((Element)v.get(7)).setAttribute("group","resto" );
      ((Element)v.get(7)).setAttribute("cod","1470" );
      ((Element)v.get(5)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(8)).setAttribute("name","txtNumSolicitudesLote" );
      ((Element)v.get(8)).setAttribute("required","true" );
      ((Element)v.get(8)).setAttribute("group","resto" );
      ((Element)v.get(8)).setAttribute("cod","1386" );
      ((Element)v.get(8)).setAttribute("format","e" );
      ((Element)v.get(8)).setAttribute("min","0" );
      ((Element)v.get(8)).setAttribute("max","999" );
      ((Element)v.get(5)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(9)).setAttribute("name","txtAlarmaNumUnidades" );
      ((Element)v.get(9)).setAttribute("required","false" );
      ((Element)v.get(9)).setAttribute("group","resto" );
      ((Element)v.get(9)).setAttribute("cod","2146" );
      ((Element)v.get(9)).setAttribute("format","e" );
      ((Element)v.get(9)).setAttribute("min","0" );
      ((Element)v.get(9)).setAttribute("max","99999" );
      ((Element)v.get(5)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(10)).setAttribute("name","cbTipoMovimientoReservaStock" );
      ((Element)v.get(10)).setAttribute("required","true" );
      ((Element)v.get(10)).setAttribute("group","reservaStock" );
      ((Element)v.get(10)).setAttribute("cod","2379" );
      ((Element)v.get(5)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */
      /* Termina nodo:5   */

      /* Empieza nodo:11 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(11)).setAttribute("nombre","formulario" );
      ((Element)v.get(11)).setAttribute("oculto","S" );
      ((Element)v.get(0)).appendChild((Element)v.get(11));

      /* Empieza nodo:12 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(12)).setAttribute("valor","LPMantieneTiposSolicitudPais" );
      ((Element)v.get(11)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","accion" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","casoDeUso" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","pais" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","idioma" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 11   */
   }

   private void getXML90(Document doc) {
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","varOid" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","sujetoAFlete" );
      ((Element)v.get(20)).setAttribute("valor","N" );
      ((Element)v.get(11)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","permiteUnion" );
      ((Element)v.get(21)).setAttribute("valor","N" );
      ((Element)v.get(11)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","reservaStock" );
      ((Element)v.get(22)).setAttribute("valor","N" );
      ((Element)v.get(11)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","permitirReversion" );
      ((Element)v.get(23)).setAttribute("valor","N" );
      ((Element)v.get(11)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","indPedidoPrueba" );
      ((Element)v.get(24)).setAttribute("valor","N" );
      ((Element)v.get(11)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","indComisionable" );
      ((Element)v.get(25)).setAttribute("valor","N" );
      ((Element)v.get(11)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","indPedGtZona" );
      ((Element)v.get(26)).setAttribute("valor","N" );
      ((Element)v.get(11)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","indCambioVentaBEL" );
      ((Element)v.get(27)).setAttribute("valor","N" );
      ((Element)v.get(11)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","indVentaSAB14" );
      ((Element)v.get(28)).setAttribute("valor","N" );
      ((Element)v.get(11)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","sociedad" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","formaPago" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","tipoDocumentoLegal" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","moneda" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","actividad" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(34)).setAttribute("nombre","tipoMovReserva" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(35)).setAttribute("nombre","tipoMovAsigna" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(36)).setAttribute("nombre","tipoMovFacturacion" );
      ((Element)v.get(36)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(37)).setAttribute("nombre","tipoSolicitud" );
      ((Element)v.get(37)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(38)).setAttribute("nombre","tipoConsolidado" );
      ((Element)v.get(38)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(39)).setAttribute("nombre","almacen" );
      ((Element)v.get(39)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(40)).setAttribute("nombre","numSolicitudesLote" );
      ((Element)v.get(40)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(41)).setAttribute("nombre","alarmaNumUnidades" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(41)).setAttribute("valor","0" );
      ((Element)v.get(11)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */

      /* Empieza nodo:42 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(42)).setAttribute("nombre","observaciones" );
      ((Element)v.get(42)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */

      /* Empieza nodo:43 / Elemento padre: 11   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(43)).setAttribute("nombre","capa1" );
      ((Element)v.get(11)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("table"));
      ((Element)v.get(44)).setAttribute("width","100%" );
      ((Element)v.get(44)).setAttribute("border","0" );
      ((Element)v.get(44)).setAttribute("cellspacing","0" );
      ((Element)v.get(44)).setAttribute("cellpadding","0" );
      ((Element)v.get(43)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(44)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("td"));
      ((Element)v.get(46)).setAttribute("width","12" );
      ((Element)v.get(46)).setAttribute("align","center" );
      ((Element)v.get(45)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(47)).setAttribute("src","b.gif" );
      ((Element)v.get(47)).setAttribute("width","12" );
      ((Element)v.get(47)).setAttribute("height","12" );
      ((Element)v.get(46)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */
      /* Termina nodo:46   */

      /* Empieza nodo:48 / Elemento padre: 45   */
      v.add(doc.createElement("td"));
      ((Element)v.get(48)).setAttribute("width","750" );
      ((Element)v.get(45)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(49)).setAttribute("src","b.gif" );
      ((Element)v.get(48)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */
      /* Termina nodo:48   */

      /* Empieza nodo:50 / Elemento padre: 45   */
      v.add(doc.createElement("td"));
      ((Element)v.get(50)).setAttribute("width","12" );
      ((Element)v.get(45)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(51)).setAttribute("src","b.gif" );
      ((Element)v.get(51)).setAttribute("width","12" );
      ((Element)v.get(51)).setAttribute("height","1" );
      ((Element)v.get(50)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */
      /* Termina nodo:50   */
      /* Termina nodo:45   */

      /* Empieza nodo:52 / Elemento padre: 44   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(44)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("td"));
      ((Element)v.get(52)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(54)).setAttribute("src","b.gif" );
      ((Element)v.get(53)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */
      /* Termina nodo:53   */

      /* Empieza nodo:55 / Elemento padre: 52   */
      v.add(doc.createElement("td"));
      ((Element)v.get(52)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(55)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(57)).setAttribute("class","legend" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(58)).setAttribute("nombre","lblDatosPrincipales" );
      ((Element)v.get(58)).setAttribute("alto","13" );
      ((Element)v.get(58)).setAttribute("filas","1" );
      ((Element)v.get(58)).setAttribute("cod","00174" );
      ((Element)v.get(58)).setAttribute("id","legend" );
      ((Element)v.get(57)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */
      /* Termina nodo:57   */

      /* Empieza nodo:59 / Elemento padre: 56   */
      v.add(doc.createElement("table"));
      ((Element)v.get(59)).setAttribute("width","100%" );
      ((Element)v.get(59)).setAttribute("border","0" );
      ((Element)v.get(59)).setAttribute("align","center" );
      ((Element)v.get(59)).setAttribute("cellspacing","0" );
      ((Element)v.get(59)).setAttribute("cellpadding","0" );
      ((Element)v.get(56)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(59)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("td"));
      ((Element)v.get(61)).setAttribute("colspan","4" );
      ((Element)v.get(60)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(62)).setAttribute("src","b.gif" );
      ((Element)v.get(62)).setAttribute("width","8" );
      ((Element)v.get(62)).setAttribute("height","8" );
      ((Element)v.get(61)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */
      /* Termina nodo:61   */
      /* Termina nodo:60   */

      /* Empieza nodo:63 / Elemento padre: 59   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(59)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("td"));
      ((Element)v.get(63)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(65)).setAttribute("src","b.gif" );
      ((Element)v.get(65)).setAttribute("width","8" );
      ((Element)v.get(65)).setAttribute("height","8" );
      ((Element)v.get(64)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */
      /* Termina nodo:64   */

      /* Empieza nodo:66 / Elemento padre: 63   */
      v.add(doc.createElement("td"));
      ((Element)v.get(63)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("LABELC"));
   }

   private void getXML270(Document doc) {
      ((Element)v.get(67)).setAttribute("nombre","lblTipoSolicitud" );
      ((Element)v.get(67)).setAttribute("alto","13" );
      ((Element)v.get(67)).setAttribute("filas","1" );
      ((Element)v.get(67)).setAttribute("valor","" );
      ((Element)v.get(67)).setAttribute("id","datosTitle" );
      ((Element)v.get(67)).setAttribute("cod","415" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */
      /* Termina nodo:66   */

      /* Empieza nodo:68 / Elemento padre: 63   */
      v.add(doc.createElement("td"));
      ((Element)v.get(63)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(69)).setAttribute("src","b.gif" );
      ((Element)v.get(69)).setAttribute("width","25" );
      ((Element)v.get(69)).setAttribute("height","8" );
      ((Element)v.get(68)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */
      /* Termina nodo:68   */

      /* Empieza nodo:70 / Elemento padre: 63   */
      v.add(doc.createElement("td"));
      ((Element)v.get(63)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(71)).setAttribute("nombre","lblNumSolicitudesLote" );
      ((Element)v.get(71)).setAttribute("alto","13" );
      ((Element)v.get(71)).setAttribute("filas","1" );
      ((Element)v.get(71)).setAttribute("valor","" );
      ((Element)v.get(71)).setAttribute("id","datosTitle" );
      ((Element)v.get(71)).setAttribute("cod","1386" );
      ((Element)v.get(70)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */
      /* Termina nodo:70   */

      /* Empieza nodo:72 / Elemento padre: 63   */
      v.add(doc.createElement("td"));
      ((Element)v.get(63)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(73)).setAttribute("src","b.gif" );
      ((Element)v.get(73)).setAttribute("width","25" );
      ((Element)v.get(73)).setAttribute("height","8" );
      ((Element)v.get(72)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */
      /* Termina nodo:72   */

      /* Empieza nodo:74 / Elemento padre: 63   */
      v.add(doc.createElement("td"));
      ((Element)v.get(63)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(75)).setAttribute("nombre","lblAlarmaNumUnidades" );
      ((Element)v.get(75)).setAttribute("alto","13" );
      ((Element)v.get(75)).setAttribute("filas","1" );
      ((Element)v.get(75)).setAttribute("valor","" );
      ((Element)v.get(75)).setAttribute("id","datosTitle" );
      ((Element)v.get(75)).setAttribute("cod","2146" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */
      /* Termina nodo:74   */

      /* Empieza nodo:76 / Elemento padre: 63   */
      v.add(doc.createElement("td"));
      ((Element)v.get(63)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(77)).setAttribute("src","b.gif" );
      ((Element)v.get(77)).setAttribute("width","25" );
      ((Element)v.get(77)).setAttribute("height","8" );
      ((Element)v.get(76)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */
      /* Termina nodo:76   */

      /* Empieza nodo:78 / Elemento padre: 63   */
      v.add(doc.createElement("td"));
      ((Element)v.get(63)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(79)).setAttribute("nombre","lblSujetoFlete" );
      ((Element)v.get(79)).setAttribute("alto","13" );
      ((Element)v.get(79)).setAttribute("filas","1" );
      ((Element)v.get(79)).setAttribute("valor","" );
      ((Element)v.get(79)).setAttribute("id","datosTitle" );
      ((Element)v.get(79)).setAttribute("cod","2147" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */
      /* Termina nodo:78   */

      /* Empieza nodo:80 / Elemento padre: 63   */
      v.add(doc.createElement("td"));
      ((Element)v.get(80)).setAttribute("width","100%" );
      ((Element)v.get(63)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(81)).setAttribute("src","b.gif" );
      ((Element)v.get(81)).setAttribute("width","8" );
      ((Element)v.get(81)).setAttribute("height","8" );
      ((Element)v.get(80)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */
      /* Termina nodo:80   */
      /* Termina nodo:63   */

      /* Empieza nodo:82 / Elemento padre: 59   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(59)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("td"));
      ((Element)v.get(82)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(84)).setAttribute("src","b.gif" );
      ((Element)v.get(84)).setAttribute("width","8" );
      ((Element)v.get(84)).setAttribute("height","8" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */
      /* Termina nodo:83   */

      /* Empieza nodo:85 / Elemento padre: 82   */
      v.add(doc.createElement("td"));
      ((Element)v.get(85)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(82)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(86)).setAttribute("nombre","cbTipoSolicitud" );
      ((Element)v.get(86)).setAttribute("id","datosCampos" );
      ((Element)v.get(86)).setAttribute("size","1" );
      ((Element)v.get(86)).setAttribute("multiple","N" );
      ((Element)v.get(86)).setAttribute("req","S" );
      ((Element)v.get(86)).setAttribute("valorinicial","" );
      ((Element)v.get(86)).setAttribute("textoinicial","" );
      ((Element)v.get(86)).setAttribute("onchange","onchange_TipoSolicitud();" );
      ((Element)v.get(86)).setAttribute("ontab","tab('cbTipoSolicitud')" );
      ((Element)v.get(86)).setAttribute("onshtab","shtab('cbTipoSolicitud')" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
   }

   private void getXML360(Document doc) {
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(86)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */
      /* Termina nodo:86   */
      /* Termina nodo:85   */

      /* Empieza nodo:88 / Elemento padre: 82   */
      v.add(doc.createElement("td"));
      ((Element)v.get(82)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(89)).setAttribute("src","b.gif" );
      ((Element)v.get(89)).setAttribute("width","25" );
      ((Element)v.get(89)).setAttribute("height","8" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */
      /* Termina nodo:88   */

      /* Empieza nodo:90 / Elemento padre: 82   */
      v.add(doc.createElement("td"));
      ((Element)v.get(90)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(82)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(91)).setAttribute("nombre","txtNumSolicitudesLote" );
      ((Element)v.get(91)).setAttribute("id","datosCampos" );
      ((Element)v.get(91)).setAttribute("max","3" );
      ((Element)v.get(91)).setAttribute("tipo","" );
      ((Element)v.get(91)).setAttribute("onchange","" );
      ((Element)v.get(91)).setAttribute("req","S" );
      ((Element)v.get(91)).setAttribute("size","3" );
      ((Element)v.get(91)).setAttribute("valor","" );
      ((Element)v.get(91)).setAttribute("validacion","" );
      ((Element)v.get(91)).setAttribute("ontab","tab('txtNumSolicitudesLote')" );
      ((Element)v.get(91)).setAttribute("onshtab","shtab('txtNumSolicitudesLote')" );
      ((Element)v.get(90)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */
      /* Termina nodo:90   */

      /* Empieza nodo:92 / Elemento padre: 82   */
      v.add(doc.createElement("td"));
      ((Element)v.get(82)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(93)).setAttribute("src","b.gif" );
      ((Element)v.get(93)).setAttribute("width","25" );
      ((Element)v.get(93)).setAttribute("height","8" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */
      /* Termina nodo:92   */

      /* Empieza nodo:94 / Elemento padre: 82   */
      v.add(doc.createElement("td"));
      ((Element)v.get(82)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(95)).setAttribute("nombre","txtAlarmaNumUnidades" );
      ((Element)v.get(95)).setAttribute("id","datosCampos" );
      ((Element)v.get(95)).setAttribute("max","5" );
      ((Element)v.get(95)).setAttribute("tipo","" );
      ((Element)v.get(95)).setAttribute("onchange","" );
      ((Element)v.get(95)).setAttribute("req","N" );
      ((Element)v.get(95)).setAttribute("size","7" );
      ((Element)v.get(95)).setAttribute("valor","0" );
      ((Element)v.get(95)).setAttribute("validacion","" );
      ((Element)v.get(95)).setAttribute("ontab","tab('txtAlarmaNumUnidades')" );
      ((Element)v.get(95)).setAttribute("onshtab","shtab('txtAlarmaNumUnidades')" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */
      /* Termina nodo:94   */

      /* Empieza nodo:96 / Elemento padre: 82   */
      v.add(doc.createElement("td"));
      ((Element)v.get(82)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(97)).setAttribute("src","b.gif" );
      ((Element)v.get(97)).setAttribute("width","25" );
      ((Element)v.get(97)).setAttribute("height","8" );
      ((Element)v.get(96)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */
      /* Termina nodo:96   */

      /* Empieza nodo:98 / Elemento padre: 82   */
      v.add(doc.createElement("td"));
      ((Element)v.get(82)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(99)).setAttribute("check","" );
      ((Element)v.get(99)).setAttribute("id","" );
      ((Element)v.get(99)).setAttribute("msjreq","" );
      ((Element)v.get(99)).setAttribute("nombre","ckSujetoFlete" );
      ((Element)v.get(99)).setAttribute("onclick","" );
      ((Element)v.get(99)).setAttribute("onfocus","" );
      ((Element)v.get(99)).setAttribute("readonly","" );
      ((Element)v.get(99)).setAttribute("req","" );
      ((Element)v.get(99)).setAttribute("tabindex","1" );
      ((Element)v.get(99)).setAttribute("texto","" );
      ((Element)v.get(99)).setAttribute("validacion","" );
      ((Element)v.get(99)).setAttribute("ontab","tab('ckSujetoFlete')" );
      ((Element)v.get(99)).setAttribute("onshtab","shtab('ckSujetoFlete')" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */
      /* Termina nodo:98   */

      /* Empieza nodo:100 / Elemento padre: 82   */
      v.add(doc.createElement("td"));
      ((Element)v.get(100)).setAttribute("width","100%" );
      ((Element)v.get(82)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(101)).setAttribute("src","b.gif" );
      ((Element)v.get(101)).setAttribute("width","8" );
      ((Element)v.get(101)).setAttribute("height","8" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */
      /* Termina nodo:100   */
      /* Termina nodo:82   */

      /* Empieza nodo:102 / Elemento padre: 59   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(59)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("td"));
      ((Element)v.get(103)).setAttribute("colspan","4" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(104)).setAttribute("src","b.gif" );
      ((Element)v.get(104)).setAttribute("width","8" );
      ((Element)v.get(104)).setAttribute("height","8" );
      ((Element)v.get(103)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */
      /* Termina nodo:103   */
      /* Termina nodo:102   */
      /* Termina nodo:59   */

      /* Empieza nodo:105 / Elemento padre: 56   */
      v.add(doc.createElement("table"));
   }

   private void getXML450(Document doc) {
      ((Element)v.get(105)).setAttribute("width","100%" );
      ((Element)v.get(105)).setAttribute("border","0" );
      ((Element)v.get(105)).setAttribute("align","center" );
      ((Element)v.get(105)).setAttribute("cellspacing","0" );
      ((Element)v.get(105)).setAttribute("cellpadding","0" );
      ((Element)v.get(56)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(105)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("td"));
      ((Element)v.get(106)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(108)).setAttribute("src","b.gif" );
      ((Element)v.get(108)).setAttribute("width","8" );
      ((Element)v.get(108)).setAttribute("height","8" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */
      /* Termina nodo:107   */

      /* Empieza nodo:109 / Elemento padre: 106   */
      v.add(doc.createElement("td"));
      ((Element)v.get(106)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(110)).setAttribute("nombre","lblPermiteUnionSolicitudes" );
      ((Element)v.get(110)).setAttribute("alto","13" );
      ((Element)v.get(110)).setAttribute("filas","1" );
      ((Element)v.get(110)).setAttribute("valor","" );
      ((Element)v.get(110)).setAttribute("id","datosTitle" );
      ((Element)v.get(110)).setAttribute("cod","2372" );
      ((Element)v.get(109)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */
      /* Termina nodo:109   */

      /* Empieza nodo:111 / Elemento padre: 106   */
      v.add(doc.createElement("td"));
      ((Element)v.get(106)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(112)).setAttribute("src","b.gif" );
      ((Element)v.get(112)).setAttribute("width","25" );
      ((Element)v.get(112)).setAttribute("height","8" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */
      /* Termina nodo:111   */

      /* Empieza nodo:113 / Elemento padre: 106   */
      v.add(doc.createElement("td"));
      ((Element)v.get(106)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(114)).setAttribute("nombre","lblTipoConsolidado" );
      ((Element)v.get(114)).setAttribute("alto","13" );
      ((Element)v.get(114)).setAttribute("filas","1" );
      ((Element)v.get(114)).setAttribute("valor","" );
      ((Element)v.get(114)).setAttribute("id","datosTitle" );
      ((Element)v.get(114)).setAttribute("cod","1470" );
      ((Element)v.get(113)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */
      /* Termina nodo:113   */

      /* Empieza nodo:115 / Elemento padre: 106   */
      v.add(doc.createElement("td"));
      ((Element)v.get(106)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(116)).setAttribute("src","b.gif" );
      ((Element)v.get(116)).setAttribute("width","25" );
      ((Element)v.get(116)).setAttribute("height","8" );
      ((Element)v.get(115)).appendChild((Element)v.get(116));
      /* Termina nodo:116   */
      /* Termina nodo:115   */

      /* Empieza nodo:117 / Elemento padre: 106   */
      v.add(doc.createElement("td"));
      ((Element)v.get(106)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(118)).setAttribute("nombre","lblTipoDocumentoLegal" );
      ((Element)v.get(118)).setAttribute("alto","13" );
      ((Element)v.get(118)).setAttribute("filas","1" );
      ((Element)v.get(118)).setAttribute("valor","" );
      ((Element)v.get(118)).setAttribute("id","datosTitle" );
      ((Element)v.get(118)).setAttribute("cod","2373" );
      ((Element)v.get(117)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */
      /* Termina nodo:117   */

      /* Empieza nodo:119 / Elemento padre: 106   */
      v.add(doc.createElement("td"));
      ((Element)v.get(106)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(120)).setAttribute("src","b.gif" );
      ((Element)v.get(120)).setAttribute("width","25" );
      ((Element)v.get(120)).setAttribute("height","8" );
      ((Element)v.get(119)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */
      /* Termina nodo:119   */

      /* Empieza nodo:121 / Elemento padre: 106   */
      v.add(doc.createElement("td"));
      ((Element)v.get(106)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(122)).setAttribute("nombre","lblPermitirReversion" );
      ((Element)v.get(122)).setAttribute("alto","13" );
      ((Element)v.get(122)).setAttribute("filas","1" );
      ((Element)v.get(122)).setAttribute("valor","" );
      ((Element)v.get(122)).setAttribute("id","datosTitle" );
      ((Element)v.get(122)).setAttribute("cod","2155" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */
      /* Termina nodo:121   */

      /* Empieza nodo:123 / Elemento padre: 106   */
      v.add(doc.createElement("td"));
      ((Element)v.get(106)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(124)).setAttribute("src","b.gif" );
      ((Element)v.get(124)).setAttribute("width","25" );
      ((Element)v.get(124)).setAttribute("height","8" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));
      /* Termina nodo:124   */
      /* Termina nodo:123   */

      /* Empieza nodo:125 / Elemento padre: 106   */
      v.add(doc.createElement("td"));
      ((Element)v.get(106)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(126)).setAttribute("nombre","lblPedidoPrueba" );
      ((Element)v.get(126)).setAttribute("alto","13" );
      ((Element)v.get(126)).setAttribute("filas","1" );
      ((Element)v.get(126)).setAttribute("valor","" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(126)).setAttribute("id","datosTitle" );
      ((Element)v.get(126)).setAttribute("cod","2156" );
      ((Element)v.get(125)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */
      /* Termina nodo:125   */

      /* Empieza nodo:127 / Elemento padre: 106   */
      v.add(doc.createElement("td"));
      ((Element)v.get(106)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(128)).setAttribute("src","b.gif" );
      ((Element)v.get(128)).setAttribute("width","25" );
      ((Element)v.get(128)).setAttribute("height","8" );
      ((Element)v.get(127)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */
      /* Termina nodo:127   */

      /* Empieza nodo:129 / Elemento padre: 106   */
      v.add(doc.createElement("td"));
      ((Element)v.get(106)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(130)).setAttribute("nombre","lblComisionable" );
      ((Element)v.get(130)).setAttribute("alto","13" );
      ((Element)v.get(130)).setAttribute("filas","1" );
      ((Element)v.get(130)).setAttribute("valor","" );
      ((Element)v.get(130)).setAttribute("id","datosTitle" );
      ((Element)v.get(130)).setAttribute("cod","466" );
      ((Element)v.get(129)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */
      /* Termina nodo:129   */

      /* Empieza nodo:131 / Elemento padre: 106   */
      v.add(doc.createElement("td"));
      ((Element)v.get(131)).setAttribute("width","100%" );
      ((Element)v.get(106)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(132)).setAttribute("src","b.gif" );
      ((Element)v.get(132)).setAttribute("width","8" );
      ((Element)v.get(132)).setAttribute("height","8" );
      ((Element)v.get(131)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */
      /* Termina nodo:131   */
      /* Termina nodo:106   */

      /* Empieza nodo:133 / Elemento padre: 105   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(105)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("td"));
      ((Element)v.get(133)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(135)).setAttribute("src","b.gif" );
      ((Element)v.get(135)).setAttribute("width","8" );
      ((Element)v.get(135)).setAttribute("height","8" );
      ((Element)v.get(134)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */
      /* Termina nodo:134   */

      /* Empieza nodo:136 / Elemento padre: 133   */
      v.add(doc.createElement("td"));
      ((Element)v.get(133)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(137)).setAttribute("check","" );
      ((Element)v.get(137)).setAttribute("id","" );
      ((Element)v.get(137)).setAttribute("msjreq","" );
      ((Element)v.get(137)).setAttribute("nombre","ckPermiteUnionSolicitudes" );
      ((Element)v.get(137)).setAttribute("onfocus","" );
      ((Element)v.get(137)).setAttribute("ontab","tab('ckPermiteUnionSolicitudes')" );
      ((Element)v.get(137)).setAttribute("onshtab","shtab('ckPermiteUnionSolicitudes')" );
      ((Element)v.get(137)).setAttribute("readonly","" );
      ((Element)v.get(137)).setAttribute("req","" );
      ((Element)v.get(137)).setAttribute("tabindex","1" );
      ((Element)v.get(137)).setAttribute("texto","" );
      ((Element)v.get(137)).setAttribute("validacion","" );
      ((Element)v.get(137)).setAttribute("onclick","onChangePermiteUnion()" );
      ((Element)v.get(136)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */
      /* Termina nodo:136   */

      /* Empieza nodo:138 / Elemento padre: 133   */
      v.add(doc.createElement("td"));
      ((Element)v.get(133)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(139)).setAttribute("src","b.gif" );
      ((Element)v.get(139)).setAttribute("width","25" );
      ((Element)v.get(139)).setAttribute("height","8" );
      ((Element)v.get(138)).appendChild((Element)v.get(139));
      /* Termina nodo:139   */
      /* Termina nodo:138   */

      /* Empieza nodo:140 / Elemento padre: 133   */
      v.add(doc.createElement("td"));
      ((Element)v.get(140)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(133)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(141)).setAttribute("nombre","cbTipoConsolidado" );
      ((Element)v.get(141)).setAttribute("id","datosCampos" );
      ((Element)v.get(141)).setAttribute("size","1" );
      ((Element)v.get(141)).setAttribute("multiple","N" );
      ((Element)v.get(141)).setAttribute("req","N" );
      ((Element)v.get(141)).setAttribute("valorinicial","" );
      ((Element)v.get(141)).setAttribute("textoinicial","" );
      ((Element)v.get(141)).setAttribute("ontab","tab('cbTipoConsolidado')" );
      ((Element)v.get(141)).setAttribute("onshtab","shtab('cbTipoConsolidado')" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(141)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */
      /* Termina nodo:141   */
      /* Termina nodo:140   */

      /* Empieza nodo:143 / Elemento padre: 133   */
      v.add(doc.createElement("td"));
      ((Element)v.get(133)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(144)).setAttribute("src","b.gif" );
      ((Element)v.get(144)).setAttribute("width","25" );
      ((Element)v.get(144)).setAttribute("height","8" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */
      /* Termina nodo:143   */

      /* Empieza nodo:145 / Elemento padre: 133   */
      v.add(doc.createElement("td"));
      ((Element)v.get(145)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(133)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(146)).setAttribute("nombre","cbTipoDocumentoLegal" );
      ((Element)v.get(146)).setAttribute("id","datosCampos" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(146)).setAttribute("size","1" );
      ((Element)v.get(146)).setAttribute("multiple","N" );
      ((Element)v.get(146)).setAttribute("req","N" );
      ((Element)v.get(146)).setAttribute("valorinicial","" );
      ((Element)v.get(146)).setAttribute("textoinicial","" );
      ((Element)v.get(146)).setAttribute("ontab","tab('cbTipoDocumentoLegal')" );
      ((Element)v.get(146)).setAttribute("onshtab","shtab('cbTipoDocumentoLegal')" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(146)).appendChild((Element)v.get(147));
      /* Termina nodo:147   */
      /* Termina nodo:146   */
      /* Termina nodo:145   */

      /* Empieza nodo:148 / Elemento padre: 133   */
      v.add(doc.createElement("td"));
      ((Element)v.get(133)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(149)).setAttribute("src","b.gif" );
      ((Element)v.get(149)).setAttribute("width","25" );
      ((Element)v.get(149)).setAttribute("height","8" );
      ((Element)v.get(148)).appendChild((Element)v.get(149));
      /* Termina nodo:149   */
      /* Termina nodo:148   */

      /* Empieza nodo:150 / Elemento padre: 133   */
      v.add(doc.createElement("td"));
      ((Element)v.get(133)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(151)).setAttribute("check","" );
      ((Element)v.get(151)).setAttribute("id","" );
      ((Element)v.get(151)).setAttribute("msjreq","" );
      ((Element)v.get(151)).setAttribute("nombre","ckPermitirReversion" );
      ((Element)v.get(151)).setAttribute("onclick","" );
      ((Element)v.get(151)).setAttribute("onfocus","" );
      ((Element)v.get(151)).setAttribute("ontab","tab('ckPermitirReversion')" );
      ((Element)v.get(151)).setAttribute("onshtab","shtab('ckPermitirReversion')" );
      ((Element)v.get(151)).setAttribute("readonly","" );
      ((Element)v.get(151)).setAttribute("req","" );
      ((Element)v.get(151)).setAttribute("tabindex","1" );
      ((Element)v.get(151)).setAttribute("texto","" );
      ((Element)v.get(151)).setAttribute("validacion","" );
      ((Element)v.get(150)).appendChild((Element)v.get(151));
      /* Termina nodo:151   */
      /* Termina nodo:150   */

      /* Empieza nodo:152 / Elemento padre: 133   */
      v.add(doc.createElement("td"));
      ((Element)v.get(133)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(153)).setAttribute("src","b.gif" );
      ((Element)v.get(153)).setAttribute("width","25" );
      ((Element)v.get(153)).setAttribute("height","8" );
      ((Element)v.get(152)).appendChild((Element)v.get(153));
      /* Termina nodo:153   */
      /* Termina nodo:152   */

      /* Empieza nodo:154 / Elemento padre: 133   */
      v.add(doc.createElement("td"));
      ((Element)v.get(133)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(155)).setAttribute("check","" );
      ((Element)v.get(155)).setAttribute("id","" );
      ((Element)v.get(155)).setAttribute("msjreq","" );
      ((Element)v.get(155)).setAttribute("nombre","ckPedidoPrueba" );
      ((Element)v.get(155)).setAttribute("onclick","" );
      ((Element)v.get(155)).setAttribute("onfocus","" );
      ((Element)v.get(155)).setAttribute("ontab","tab('ckPedidoPrueba')" );
      ((Element)v.get(155)).setAttribute("onshtab","shtab('ckPedidoPrueba')" );
      ((Element)v.get(155)).setAttribute("readonly","" );
      ((Element)v.get(155)).setAttribute("req","" );
      ((Element)v.get(155)).setAttribute("tabindex","1" );
      ((Element)v.get(155)).setAttribute("texto","" );
      ((Element)v.get(155)).setAttribute("validacion","" );
      ((Element)v.get(154)).appendChild((Element)v.get(155));
      /* Termina nodo:155   */
      /* Termina nodo:154   */

      /* Empieza nodo:156 / Elemento padre: 133   */
      v.add(doc.createElement("td"));
      ((Element)v.get(133)).appendChild((Element)v.get(156));

      /* Empieza nodo:157 / Elemento padre: 156   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(157)).setAttribute("src","b.gif" );
      ((Element)v.get(157)).setAttribute("width","25" );
      ((Element)v.get(157)).setAttribute("height","8" );
      ((Element)v.get(156)).appendChild((Element)v.get(157));
      /* Termina nodo:157   */
      /* Termina nodo:156   */

      /* Empieza nodo:158 / Elemento padre: 133   */
      v.add(doc.createElement("td"));
      ((Element)v.get(133)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(159)).setAttribute("check","" );
      ((Element)v.get(159)).setAttribute("id","" );
      ((Element)v.get(159)).setAttribute("msjreq","" );
      ((Element)v.get(159)).setAttribute("nombre","ckComisionable" );
      ((Element)v.get(159)).setAttribute("onclick","" );
      ((Element)v.get(159)).setAttribute("onfocus","" );
      ((Element)v.get(159)).setAttribute("ontab","tab('ckComisionable')" );
      ((Element)v.get(159)).setAttribute("onshtab","shtab('ckComisionable')" );
      ((Element)v.get(159)).setAttribute("readonly","" );
      ((Element)v.get(159)).setAttribute("req","" );
      ((Element)v.get(159)).setAttribute("tabindex","1" );
      ((Element)v.get(159)).setAttribute("texto","" );
      ((Element)v.get(159)).setAttribute("validacion","" );
      ((Element)v.get(158)).appendChild((Element)v.get(159));
      /* Termina nodo:159   */
      /* Termina nodo:158   */

      /* Empieza nodo:160 / Elemento padre: 133   */
      v.add(doc.createElement("td"));
      ((Element)v.get(160)).setAttribute("width","100%" );
      ((Element)v.get(133)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(161)).setAttribute("src","b.gif" );
      ((Element)v.get(161)).setAttribute("width","8" );
      ((Element)v.get(161)).setAttribute("height","8" );
      ((Element)v.get(160)).appendChild((Element)v.get(161));
      /* Termina nodo:161   */
      /* Termina nodo:160   */
      /* Termina nodo:133   */

      /* Empieza nodo:162 / Elemento padre: 105   */
   }

   private void getXML720(Document doc) {
      v.add(doc.createElement("tr"));
      ((Element)v.get(105)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("td"));
      ((Element)v.get(163)).setAttribute("colspan","4" );
      ((Element)v.get(162)).appendChild((Element)v.get(163));

      /* Empieza nodo:164 / Elemento padre: 163   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(164)).setAttribute("src","b.gif" );
      ((Element)v.get(164)).setAttribute("width","8" );
      ((Element)v.get(164)).setAttribute("height","8" );
      ((Element)v.get(163)).appendChild((Element)v.get(164));
      /* Termina nodo:164   */
      /* Termina nodo:163   */
      /* Termina nodo:162   */
      /* Termina nodo:105   */

      /* Empieza nodo:165 / Elemento padre: 56   */
      v.add(doc.createElement("table"));
      ((Element)v.get(165)).setAttribute("width","100%" );
      ((Element)v.get(165)).setAttribute("border","0" );
      ((Element)v.get(165)).setAttribute("align","center" );
      ((Element)v.get(165)).setAttribute("cellspacing","0" );
      ((Element)v.get(165)).setAttribute("cellpadding","0" );
      ((Element)v.get(56)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(165)).appendChild((Element)v.get(166));

      /* Empieza nodo:167 / Elemento padre: 166   */
      v.add(doc.createElement("td"));
      ((Element)v.get(166)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(168)).setAttribute("src","b.gif" );
      ((Element)v.get(168)).setAttribute("width","8" );
      ((Element)v.get(168)).setAttribute("height","8" );
      ((Element)v.get(167)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */
      /* Termina nodo:167   */

      /* Empieza nodo:169 / Elemento padre: 166   */
      v.add(doc.createElement("td"));
      ((Element)v.get(166)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(170)).setAttribute("nombre","lblPedGtZona" );
      ((Element)v.get(170)).setAttribute("alto","13" );
      ((Element)v.get(170)).setAttribute("filas","1" );
      ((Element)v.get(170)).setAttribute("valor","" );
      ((Element)v.get(170)).setAttribute("id","datosTitle" );
      ((Element)v.get(170)).setAttribute("cod","2375" );
      ((Element)v.get(169)).appendChild((Element)v.get(170));
      /* Termina nodo:170   */
      /* Termina nodo:169   */

      /* Empieza nodo:171 / Elemento padre: 166   */
      v.add(doc.createElement("td"));
      ((Element)v.get(166)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(172)).setAttribute("src","b.gif" );
      ((Element)v.get(172)).setAttribute("width","25" );
      ((Element)v.get(172)).setAttribute("height","8" );
      ((Element)v.get(171)).appendChild((Element)v.get(172));
      /* Termina nodo:172   */
      /* Termina nodo:171   */

      /* Empieza nodo:173 / Elemento padre: 166   */
      v.add(doc.createElement("td"));
      ((Element)v.get(166)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(174)).setAttribute("nombre","lblCambioVentaBelcenter" );
      ((Element)v.get(174)).setAttribute("alto","13" );
      ((Element)v.get(174)).setAttribute("filas","1" );
      ((Element)v.get(174)).setAttribute("valor","" );
      ((Element)v.get(174)).setAttribute("id","datosTitle" );
      ((Element)v.get(174)).setAttribute("cod","2376" );
      ((Element)v.get(173)).appendChild((Element)v.get(174));
      /* Termina nodo:174   */
      /* Termina nodo:173   */

      /* Empieza nodo:175 / Elemento padre: 166   */
      v.add(doc.createElement("td"));
      ((Element)v.get(166)).appendChild((Element)v.get(175));

      /* Empieza nodo:176 / Elemento padre: 175   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(176)).setAttribute("src","b.gif" );
      ((Element)v.get(176)).setAttribute("width","25" );
      ((Element)v.get(176)).setAttribute("height","8" );
      ((Element)v.get(175)).appendChild((Element)v.get(176));
      /* Termina nodo:176   */
      /* Termina nodo:175   */

      /* Empieza nodo:177 / Elemento padre: 166   */
      v.add(doc.createElement("td"));
      ((Element)v.get(166)).appendChild((Element)v.get(177));

      /* Empieza nodo:178 / Elemento padre: 177   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(178)).setAttribute("nombre","lblVentaInterfazSAB14" );
      ((Element)v.get(178)).setAttribute("alto","13" );
      ((Element)v.get(178)).setAttribute("filas","1" );
      ((Element)v.get(178)).setAttribute("valor","" );
      ((Element)v.get(178)).setAttribute("id","datosTitle" );
      ((Element)v.get(178)).setAttribute("cod","2377" );
      ((Element)v.get(177)).appendChild((Element)v.get(178));
      /* Termina nodo:178   */
      /* Termina nodo:177   */

      /* Empieza nodo:179 / Elemento padre: 166   */
      v.add(doc.createElement("td"));
      ((Element)v.get(166)).appendChild((Element)v.get(179));

      /* Empieza nodo:180 / Elemento padre: 179   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(180)).setAttribute("src","b.gif" );
      ((Element)v.get(180)).setAttribute("width","25" );
      ((Element)v.get(180)).setAttribute("height","8" );
      ((Element)v.get(179)).appendChild((Element)v.get(180));
      /* Termina nodo:180   */
      /* Termina nodo:179   */

      /* Empieza nodo:181 / Elemento padre: 166   */
      v.add(doc.createElement("td"));
      ((Element)v.get(166)).appendChild((Element)v.get(181));

      /* Empieza nodo:182 / Elemento padre: 181   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(182)).setAttribute("nombre","lblSociedad" );
      ((Element)v.get(182)).setAttribute("alto","13" );
      ((Element)v.get(182)).setAttribute("filas","1" );
      ((Element)v.get(182)).setAttribute("valor","" );
      ((Element)v.get(182)).setAttribute("id","datosTitle" );
      ((Element)v.get(182)).setAttribute("cod","120" );
      ((Element)v.get(181)).appendChild((Element)v.get(182));
      /* Termina nodo:182   */
      /* Termina nodo:181   */

      /* Empieza nodo:183 / Elemento padre: 166   */
      v.add(doc.createElement("td"));
      ((Element)v.get(183)).setAttribute("width","100%" );
      ((Element)v.get(166)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
   }

   private void getXML810(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(184)).setAttribute("src","b.gif" );
      ((Element)v.get(184)).setAttribute("width","8" );
      ((Element)v.get(184)).setAttribute("height","8" );
      ((Element)v.get(183)).appendChild((Element)v.get(184));
      /* Termina nodo:184   */
      /* Termina nodo:183   */
      /* Termina nodo:166   */

      /* Empieza nodo:185 / Elemento padre: 165   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(165)).appendChild((Element)v.get(185));

      /* Empieza nodo:186 / Elemento padre: 185   */
      v.add(doc.createElement("td"));
      ((Element)v.get(185)).appendChild((Element)v.get(186));

      /* Empieza nodo:187 / Elemento padre: 186   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(187)).setAttribute("src","b.gif" );
      ((Element)v.get(187)).setAttribute("width","8" );
      ((Element)v.get(187)).setAttribute("height","8" );
      ((Element)v.get(186)).appendChild((Element)v.get(187));
      /* Termina nodo:187   */
      /* Termina nodo:186   */

      /* Empieza nodo:188 / Elemento padre: 185   */
      v.add(doc.createElement("td"));
      ((Element)v.get(185)).appendChild((Element)v.get(188));

      /* Empieza nodo:189 / Elemento padre: 188   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(189)).setAttribute("check","" );
      ((Element)v.get(189)).setAttribute("id","" );
      ((Element)v.get(189)).setAttribute("msjreq","" );
      ((Element)v.get(189)).setAttribute("nombre","ckPedGtZona" );
      ((Element)v.get(189)).setAttribute("onclick","" );
      ((Element)v.get(189)).setAttribute("onfocus","" );
      ((Element)v.get(189)).setAttribute("ontab","tab('ckPedGtZona')" );
      ((Element)v.get(189)).setAttribute("onshtab","shtab('ckPedGtZona')" );
      ((Element)v.get(189)).setAttribute("readonly","" );
      ((Element)v.get(189)).setAttribute("req","" );
      ((Element)v.get(189)).setAttribute("tabindex","1" );
      ((Element)v.get(189)).setAttribute("texto","" );
      ((Element)v.get(189)).setAttribute("validacion","" );
      ((Element)v.get(188)).appendChild((Element)v.get(189));
      /* Termina nodo:189   */
      /* Termina nodo:188   */

      /* Empieza nodo:190 / Elemento padre: 185   */
      v.add(doc.createElement("td"));
      ((Element)v.get(185)).appendChild((Element)v.get(190));

      /* Empieza nodo:191 / Elemento padre: 190   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(191)).setAttribute("src","b.gif" );
      ((Element)v.get(191)).setAttribute("width","25" );
      ((Element)v.get(191)).setAttribute("height","8" );
      ((Element)v.get(190)).appendChild((Element)v.get(191));
      /* Termina nodo:191   */
      /* Termina nodo:190   */

      /* Empieza nodo:192 / Elemento padre: 185   */
      v.add(doc.createElement("td"));
      ((Element)v.get(185)).appendChild((Element)v.get(192));

      /* Empieza nodo:193 / Elemento padre: 192   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(193)).setAttribute("check","" );
      ((Element)v.get(193)).setAttribute("id","" );
      ((Element)v.get(193)).setAttribute("msjreq","" );
      ((Element)v.get(193)).setAttribute("nombre","ckCambioVentaBelcenter" );
      ((Element)v.get(193)).setAttribute("onclick","" );
      ((Element)v.get(193)).setAttribute("onfocus","" );
      ((Element)v.get(193)).setAttribute("ontab","tab('ckCambioVentaBelcenter')" );
      ((Element)v.get(193)).setAttribute("onshtab","shtab('ckCambioVentaBelcenter')" );
      ((Element)v.get(193)).setAttribute("readonly","" );
      ((Element)v.get(193)).setAttribute("req","" );
      ((Element)v.get(193)).setAttribute("tabindex","1" );
      ((Element)v.get(193)).setAttribute("texto","" );
      ((Element)v.get(193)).setAttribute("validacion","" );
      ((Element)v.get(192)).appendChild((Element)v.get(193));
      /* Termina nodo:193   */
      /* Termina nodo:192   */

      /* Empieza nodo:194 / Elemento padre: 185   */
      v.add(doc.createElement("td"));
      ((Element)v.get(185)).appendChild((Element)v.get(194));

      /* Empieza nodo:195 / Elemento padre: 194   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(195)).setAttribute("src","b.gif" );
      ((Element)v.get(195)).setAttribute("width","25" );
      ((Element)v.get(195)).setAttribute("height","8" );
      ((Element)v.get(194)).appendChild((Element)v.get(195));
      /* Termina nodo:195   */
      /* Termina nodo:194   */

      /* Empieza nodo:196 / Elemento padre: 185   */
      v.add(doc.createElement("td"));
      ((Element)v.get(185)).appendChild((Element)v.get(196));

      /* Empieza nodo:197 / Elemento padre: 196   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(197)).setAttribute("check","" );
      ((Element)v.get(197)).setAttribute("id","" );
      ((Element)v.get(197)).setAttribute("msjreq","" );
      ((Element)v.get(197)).setAttribute("nombre","ckVentaInterfazSAB14" );
      ((Element)v.get(197)).setAttribute("onclick","" );
      ((Element)v.get(197)).setAttribute("onfocus","" );
      ((Element)v.get(197)).setAttribute("ontab","tab('ckVentaInterfazSAB14')" );
      ((Element)v.get(197)).setAttribute("onshtab","shtab('ckVentaInterfazSAB14')" );
      ((Element)v.get(197)).setAttribute("readonly","" );
      ((Element)v.get(197)).setAttribute("req","" );
      ((Element)v.get(197)).setAttribute("tabindex","1" );
      ((Element)v.get(197)).setAttribute("texto","" );
      ((Element)v.get(197)).setAttribute("validacion","" );
      ((Element)v.get(196)).appendChild((Element)v.get(197));
      /* Termina nodo:197   */
      /* Termina nodo:196   */

      /* Empieza nodo:198 / Elemento padre: 185   */
      v.add(doc.createElement("td"));
      ((Element)v.get(185)).appendChild((Element)v.get(198));

      /* Empieza nodo:199 / Elemento padre: 198   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(199)).setAttribute("src","b.gif" );
      ((Element)v.get(199)).setAttribute("width","25" );
      ((Element)v.get(199)).setAttribute("height","8" );
      ((Element)v.get(198)).appendChild((Element)v.get(199));
      /* Termina nodo:199   */
      /* Termina nodo:198   */

      /* Empieza nodo:200 / Elemento padre: 185   */
      v.add(doc.createElement("td"));
      ((Element)v.get(200)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(185)).appendChild((Element)v.get(200));

      /* Empieza nodo:201 / Elemento padre: 200   */
      v.add(doc.createElement("COMBO"));
   }

   private void getXML900(Document doc) {
      ((Element)v.get(201)).setAttribute("nombre","cbSociedad" );
      ((Element)v.get(201)).setAttribute("id","datosCampos" );
      ((Element)v.get(201)).setAttribute("size","1" );
      ((Element)v.get(201)).setAttribute("multiple","N" );
      ((Element)v.get(201)).setAttribute("req","N" );
      ((Element)v.get(201)).setAttribute("valorinicial","" );
      ((Element)v.get(201)).setAttribute("textoinicial","" );
      ((Element)v.get(201)).setAttribute("ontab","tab('cbSociedad')" );
      ((Element)v.get(201)).setAttribute("onshtab","shtab('cbSociedad')" );
      ((Element)v.get(200)).appendChild((Element)v.get(201));

      /* Empieza nodo:202 / Elemento padre: 201   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(201)).appendChild((Element)v.get(202));
      /* Termina nodo:202   */
      /* Termina nodo:201   */
      /* Termina nodo:200   */

      /* Empieza nodo:203 / Elemento padre: 185   */
      v.add(doc.createElement("td"));
      ((Element)v.get(203)).setAttribute("width","100%" );
      ((Element)v.get(185)).appendChild((Element)v.get(203));

      /* Empieza nodo:204 / Elemento padre: 203   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(204)).setAttribute("src","b.gif" );
      ((Element)v.get(204)).setAttribute("width","8" );
      ((Element)v.get(204)).setAttribute("height","8" );
      ((Element)v.get(203)).appendChild((Element)v.get(204));
      /* Termina nodo:204   */
      /* Termina nodo:203   */
      /* Termina nodo:185   */

      /* Empieza nodo:205 / Elemento padre: 165   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(165)).appendChild((Element)v.get(205));

      /* Empieza nodo:206 / Elemento padre: 205   */
      v.add(doc.createElement("td"));
      ((Element)v.get(206)).setAttribute("colspan","4" );
      ((Element)v.get(205)).appendChild((Element)v.get(206));

      /* Empieza nodo:207 / Elemento padre: 206   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(207)).setAttribute("src","b.gif" );
      ((Element)v.get(207)).setAttribute("width","8" );
      ((Element)v.get(207)).setAttribute("height","8" );
      ((Element)v.get(206)).appendChild((Element)v.get(207));
      /* Termina nodo:207   */
      /* Termina nodo:206   */
      /* Termina nodo:205   */
      /* Termina nodo:165   */

      /* Empieza nodo:208 / Elemento padre: 56   */
      v.add(doc.createElement("table"));
      ((Element)v.get(208)).setAttribute("width","100%" );
      ((Element)v.get(208)).setAttribute("border","0" );
      ((Element)v.get(208)).setAttribute("align","center" );
      ((Element)v.get(208)).setAttribute("cellspacing","0" );
      ((Element)v.get(208)).setAttribute("cellpadding","0" );
      ((Element)v.get(56)).appendChild((Element)v.get(208));

      /* Empieza nodo:209 / Elemento padre: 208   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(208)).appendChild((Element)v.get(209));

      /* Empieza nodo:210 / Elemento padre: 209   */
      v.add(doc.createElement("td"));
      ((Element)v.get(209)).appendChild((Element)v.get(210));

      /* Empieza nodo:211 / Elemento padre: 210   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(211)).setAttribute("src","b.gif" );
      ((Element)v.get(211)).setAttribute("width","8" );
      ((Element)v.get(211)).setAttribute("height","8" );
      ((Element)v.get(210)).appendChild((Element)v.get(211));
      /* Termina nodo:211   */
      /* Termina nodo:210   */

      /* Empieza nodo:212 / Elemento padre: 209   */
      v.add(doc.createElement("td"));
      ((Element)v.get(209)).appendChild((Element)v.get(212));

      /* Empieza nodo:213 / Elemento padre: 212   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(213)).setAttribute("nombre","lblFormaPago" );
      ((Element)v.get(213)).setAttribute("alto","13" );
      ((Element)v.get(213)).setAttribute("filas","1" );
      ((Element)v.get(213)).setAttribute("valor","" );
      ((Element)v.get(213)).setAttribute("id","datosTitle" );
      ((Element)v.get(213)).setAttribute("cod","541" );
      ((Element)v.get(212)).appendChild((Element)v.get(213));
      /* Termina nodo:213   */
      /* Termina nodo:212   */

      /* Empieza nodo:214 / Elemento padre: 209   */
      v.add(doc.createElement("td"));
      ((Element)v.get(209)).appendChild((Element)v.get(214));

      /* Empieza nodo:215 / Elemento padre: 214   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(215)).setAttribute("src","b.gif" );
      ((Element)v.get(215)).setAttribute("width","25" );
      ((Element)v.get(215)).setAttribute("height","8" );
      ((Element)v.get(214)).appendChild((Element)v.get(215));
      /* Termina nodo:215   */
      /* Termina nodo:214   */

      /* Empieza nodo:216 / Elemento padre: 209   */
      v.add(doc.createElement("td"));
      ((Element)v.get(209)).appendChild((Element)v.get(216));

      /* Empieza nodo:217 / Elemento padre: 216   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(217)).setAttribute("nombre","lblAlmacen" );
      ((Element)v.get(217)).setAttribute("alto","13" );
      ((Element)v.get(217)).setAttribute("filas","1" );
      ((Element)v.get(217)).setAttribute("valor","" );
      ((Element)v.get(217)).setAttribute("id","datosTitle" );
      ((Element)v.get(217)).setAttribute("cod","797" );
      ((Element)v.get(216)).appendChild((Element)v.get(217));
      /* Termina nodo:217   */
      /* Termina nodo:216   */

      /* Empieza nodo:218 / Elemento padre: 209   */
      v.add(doc.createElement("td"));
      ((Element)v.get(218)).setAttribute("width","100%" );
      ((Element)v.get(209)).appendChild((Element)v.get(218));

      /* Empieza nodo:219 / Elemento padre: 218   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(219)).setAttribute("src","b.gif" );
      ((Element)v.get(219)).setAttribute("width","8" );
      ((Element)v.get(219)).setAttribute("height","8" );
      ((Element)v.get(218)).appendChild((Element)v.get(219));
      /* Termina nodo:219   */
      /* Termina nodo:218   */
      /* Termina nodo:209   */

      /* Empieza nodo:220 / Elemento padre: 208   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(208)).appendChild((Element)v.get(220));

      /* Empieza nodo:221 / Elemento padre: 220   */
      v.add(doc.createElement("td"));
      ((Element)v.get(220)).appendChild((Element)v.get(221));

      /* Empieza nodo:222 / Elemento padre: 221   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(222)).setAttribute("src","b.gif" );
      ((Element)v.get(222)).setAttribute("width","8" );
      ((Element)v.get(222)).setAttribute("height","8" );
      ((Element)v.get(221)).appendChild((Element)v.get(222));
      /* Termina nodo:222   */
      /* Termina nodo:221   */

      /* Empieza nodo:223 / Elemento padre: 220   */
   }

   private void getXML990(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(223)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(220)).appendChild((Element)v.get(223));

      /* Empieza nodo:224 / Elemento padre: 223   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(224)).setAttribute("nombre","cbFormaPago" );
      ((Element)v.get(224)).setAttribute("id","datosCampos" );
      ((Element)v.get(224)).setAttribute("size","1" );
      ((Element)v.get(224)).setAttribute("multiple","N" );
      ((Element)v.get(224)).setAttribute("req","N" );
      ((Element)v.get(224)).setAttribute("valorinicial","" );
      ((Element)v.get(224)).setAttribute("textoinicial","" );
      ((Element)v.get(224)).setAttribute("ontab","tab('cbFormaPago')" );
      ((Element)v.get(224)).setAttribute("onshtab","shtab('cbFormaPago')" );
      ((Element)v.get(223)).appendChild((Element)v.get(224));

      /* Empieza nodo:225 / Elemento padre: 224   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(224)).appendChild((Element)v.get(225));
      /* Termina nodo:225   */
      /* Termina nodo:224   */
      /* Termina nodo:223   */

      /* Empieza nodo:226 / Elemento padre: 220   */
      v.add(doc.createElement("td"));
      ((Element)v.get(220)).appendChild((Element)v.get(226));

      /* Empieza nodo:227 / Elemento padre: 226   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(227)).setAttribute("src","b.gif" );
      ((Element)v.get(227)).setAttribute("width","25" );
      ((Element)v.get(227)).setAttribute("height","8" );
      ((Element)v.get(226)).appendChild((Element)v.get(227));
      /* Termina nodo:227   */
      /* Termina nodo:226   */

      /* Empieza nodo:228 / Elemento padre: 220   */
      v.add(doc.createElement("td"));
      ((Element)v.get(228)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(220)).appendChild((Element)v.get(228));

      /* Empieza nodo:229 / Elemento padre: 228   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(229)).setAttribute("nombre","cbAlmacen" );
      ((Element)v.get(229)).setAttribute("id","datosCampos" );
      ((Element)v.get(229)).setAttribute("size","1" );
      ((Element)v.get(229)).setAttribute("multiple","N" );
      ((Element)v.get(229)).setAttribute("req","N" );
      ((Element)v.get(229)).setAttribute("valorinicial","" );
      ((Element)v.get(229)).setAttribute("textoinicial","" );
      ((Element)v.get(229)).setAttribute("ontab","tab('cbAlmacen')" );
      ((Element)v.get(229)).setAttribute("onshtab","shtab('cbAlmacen')" );
      ((Element)v.get(228)).appendChild((Element)v.get(229));

      /* Empieza nodo:230 / Elemento padre: 229   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(229)).appendChild((Element)v.get(230));
      /* Termina nodo:230   */
      /* Termina nodo:229   */
      /* Termina nodo:228   */

      /* Empieza nodo:231 / Elemento padre: 220   */
      v.add(doc.createElement("td"));
      ((Element)v.get(231)).setAttribute("width","100%" );
      ((Element)v.get(220)).appendChild((Element)v.get(231));

      /* Empieza nodo:232 / Elemento padre: 231   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(232)).setAttribute("src","b.gif" );
      ((Element)v.get(232)).setAttribute("width","8" );
      ((Element)v.get(232)).setAttribute("height","8" );
      ((Element)v.get(231)).appendChild((Element)v.get(232));
      /* Termina nodo:232   */
      /* Termina nodo:231   */
      /* Termina nodo:220   */

      /* Empieza nodo:233 / Elemento padre: 208   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(208)).appendChild((Element)v.get(233));

      /* Empieza nodo:234 / Elemento padre: 233   */
      v.add(doc.createElement("td"));
      ((Element)v.get(234)).setAttribute("colspan","4" );
      ((Element)v.get(233)).appendChild((Element)v.get(234));

      /* Empieza nodo:235 / Elemento padre: 234   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(235)).setAttribute("src","b.gif" );
      ((Element)v.get(235)).setAttribute("width","8" );
      ((Element)v.get(235)).setAttribute("height","8" );
      ((Element)v.get(234)).appendChild((Element)v.get(235));
      /* Termina nodo:235   */
      /* Termina nodo:234   */
      /* Termina nodo:233   */
      /* Termina nodo:208   */

      /* Empieza nodo:236 / Elemento padre: 56   */
      v.add(doc.createElement("table"));
      ((Element)v.get(236)).setAttribute("width","100%" );
      ((Element)v.get(236)).setAttribute("border","0" );
      ((Element)v.get(236)).setAttribute("align","center" );
      ((Element)v.get(236)).setAttribute("cellspacing","0" );
      ((Element)v.get(236)).setAttribute("cellpadding","0" );
      ((Element)v.get(56)).appendChild((Element)v.get(236));

      /* Empieza nodo:237 / Elemento padre: 236   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(236)).appendChild((Element)v.get(237));

      /* Empieza nodo:238 / Elemento padre: 237   */
      v.add(doc.createElement("td"));
      ((Element)v.get(237)).appendChild((Element)v.get(238));

      /* Empieza nodo:239 / Elemento padre: 238   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(239)).setAttribute("src","b.gif" );
      ((Element)v.get(239)).setAttribute("width","8" );
      ((Element)v.get(239)).setAttribute("height","8" );
      ((Element)v.get(238)).appendChild((Element)v.get(239));
      /* Termina nodo:239   */
      /* Termina nodo:238   */

      /* Empieza nodo:240 / Elemento padre: 237   */
      v.add(doc.createElement("td"));
      ((Element)v.get(237)).appendChild((Element)v.get(240));

      /* Empieza nodo:241 / Elemento padre: 240   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(241)).setAttribute("nombre","lblTipoMovimientoAsignacionStock" );
      ((Element)v.get(241)).setAttribute("alto","13" );
      ((Element)v.get(241)).setAttribute("filas","1" );
      ((Element)v.get(241)).setAttribute("valor","" );
      ((Element)v.get(241)).setAttribute("id","datosTitle" );
      ((Element)v.get(241)).setAttribute("cod","2378" );
      ((Element)v.get(240)).appendChild((Element)v.get(241));
      /* Termina nodo:241   */
      /* Termina nodo:240   */

      /* Empieza nodo:242 / Elemento padre: 237   */
      v.add(doc.createElement("td"));
      ((Element)v.get(237)).appendChild((Element)v.get(242));

      /* Empieza nodo:243 / Elemento padre: 242   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(243)).setAttribute("src","b.gif" );
      ((Element)v.get(243)).setAttribute("width","25" );
      ((Element)v.get(243)).setAttribute("height","8" );
      ((Element)v.get(242)).appendChild((Element)v.get(243));
      /* Termina nodo:243   */
      /* Termina nodo:242   */

      /* Empieza nodo:244 / Elemento padre: 237   */
   }

   private void getXML1080(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(237)).appendChild((Element)v.get(244));

      /* Empieza nodo:245 / Elemento padre: 244   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(245)).setAttribute("nombre","lblReservaStock" );
      ((Element)v.get(245)).setAttribute("alto","13" );
      ((Element)v.get(245)).setAttribute("filas","1" );
      ((Element)v.get(245)).setAttribute("valor","" );
      ((Element)v.get(245)).setAttribute("id","datosTitle" );
      ((Element)v.get(245)).setAttribute("cod","2374" );
      ((Element)v.get(244)).appendChild((Element)v.get(245));
      /* Termina nodo:245   */
      /* Termina nodo:244   */

      /* Empieza nodo:246 / Elemento padre: 237   */
      v.add(doc.createElement("td"));
      ((Element)v.get(237)).appendChild((Element)v.get(246));

      /* Empieza nodo:247 / Elemento padre: 246   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(247)).setAttribute("src","b.gif" );
      ((Element)v.get(247)).setAttribute("width","25" );
      ((Element)v.get(247)).setAttribute("height","8" );
      ((Element)v.get(246)).appendChild((Element)v.get(247));
      /* Termina nodo:247   */
      /* Termina nodo:246   */

      /* Empieza nodo:248 / Elemento padre: 237   */
      v.add(doc.createElement("td"));
      ((Element)v.get(237)).appendChild((Element)v.get(248));

      /* Empieza nodo:249 / Elemento padre: 248   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(249)).setAttribute("nombre","lblTipoMovimientoReservaStock" );
      ((Element)v.get(249)).setAttribute("alto","13" );
      ((Element)v.get(249)).setAttribute("filas","1" );
      ((Element)v.get(249)).setAttribute("valor","" );
      ((Element)v.get(249)).setAttribute("id","datosTitle" );
      ((Element)v.get(249)).setAttribute("cod","2379" );
      ((Element)v.get(248)).appendChild((Element)v.get(249));
      /* Termina nodo:249   */
      /* Termina nodo:248   */

      /* Empieza nodo:250 / Elemento padre: 237   */
      v.add(doc.createElement("td"));
      ((Element)v.get(250)).setAttribute("width","100%" );
      ((Element)v.get(237)).appendChild((Element)v.get(250));

      /* Empieza nodo:251 / Elemento padre: 250   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(251)).setAttribute("src","b.gif" );
      ((Element)v.get(251)).setAttribute("width","8" );
      ((Element)v.get(251)).setAttribute("height","8" );
      ((Element)v.get(250)).appendChild((Element)v.get(251));
      /* Termina nodo:251   */
      /* Termina nodo:250   */
      /* Termina nodo:237   */

      /* Empieza nodo:252 / Elemento padre: 236   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(236)).appendChild((Element)v.get(252));

      /* Empieza nodo:253 / Elemento padre: 252   */
      v.add(doc.createElement("td"));
      ((Element)v.get(252)).appendChild((Element)v.get(253));

      /* Empieza nodo:254 / Elemento padre: 253   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(254)).setAttribute("src","b.gif" );
      ((Element)v.get(254)).setAttribute("width","8" );
      ((Element)v.get(254)).setAttribute("height","8" );
      ((Element)v.get(253)).appendChild((Element)v.get(254));
      /* Termina nodo:254   */
      /* Termina nodo:253   */

      /* Empieza nodo:255 / Elemento padre: 252   */
      v.add(doc.createElement("td"));
      ((Element)v.get(255)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(252)).appendChild((Element)v.get(255));

      /* Empieza nodo:256 / Elemento padre: 255   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(256)).setAttribute("nombre","cbTipoMovimientoAsignacionStock" );
      ((Element)v.get(256)).setAttribute("id","datosCampos" );
      ((Element)v.get(256)).setAttribute("size","1" );
      ((Element)v.get(256)).setAttribute("multiple","N" );
      ((Element)v.get(256)).setAttribute("req","N" );
      ((Element)v.get(256)).setAttribute("valorinicial","" );
      ((Element)v.get(256)).setAttribute("textoinicial","" );
      ((Element)v.get(256)).setAttribute("ontab","tab('cbTipoMovimientoAsignacionStock')" );
      ((Element)v.get(256)).setAttribute("onshtab","shtab('cbTipoMovimientoAsignacionStock')" );
      ((Element)v.get(255)).appendChild((Element)v.get(256));

      /* Empieza nodo:257 / Elemento padre: 256   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(256)).appendChild((Element)v.get(257));
      /* Termina nodo:257   */
      /* Termina nodo:256   */
      /* Termina nodo:255   */

      /* Empieza nodo:258 / Elemento padre: 252   */
      v.add(doc.createElement("td"));
      ((Element)v.get(252)).appendChild((Element)v.get(258));

      /* Empieza nodo:259 / Elemento padre: 258   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(259)).setAttribute("src","b.gif" );
      ((Element)v.get(259)).setAttribute("width","25" );
      ((Element)v.get(259)).setAttribute("height","8" );
      ((Element)v.get(258)).appendChild((Element)v.get(259));
      /* Termina nodo:259   */
      /* Termina nodo:258   */

      /* Empieza nodo:260 / Elemento padre: 252   */
      v.add(doc.createElement("td"));
      ((Element)v.get(252)).appendChild((Element)v.get(260));

      /* Empieza nodo:261 / Elemento padre: 260   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(261)).setAttribute("check","" );
      ((Element)v.get(261)).setAttribute("id","" );
      ((Element)v.get(261)).setAttribute("msjreq","" );
      ((Element)v.get(261)).setAttribute("nombre","chkReservaStock" );
      ((Element)v.get(261)).setAttribute("onclick","reservaStock();" );
      ((Element)v.get(261)).setAttribute("onfocus","" );
      ((Element)v.get(261)).setAttribute("ontab","tab('chkReservaStock')" );
      ((Element)v.get(261)).setAttribute("onshtab","shtab('chkReservaStock')" );
      ((Element)v.get(261)).setAttribute("readonly","" );
      ((Element)v.get(261)).setAttribute("req","" );
      ((Element)v.get(261)).setAttribute("tabindex","1" );
      ((Element)v.get(261)).setAttribute("texto","" );
      ((Element)v.get(261)).setAttribute("validacion","" );
      ((Element)v.get(260)).appendChild((Element)v.get(261));
      /* Termina nodo:261   */
      /* Termina nodo:260   */

      /* Empieza nodo:262 / Elemento padre: 252   */
      v.add(doc.createElement("td"));
      ((Element)v.get(252)).appendChild((Element)v.get(262));

      /* Empieza nodo:263 / Elemento padre: 262   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(263)).setAttribute("src","b.gif" );
      ((Element)v.get(263)).setAttribute("width","25" );
      ((Element)v.get(263)).setAttribute("height","8" );
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(262)).appendChild((Element)v.get(263));
      /* Termina nodo:263   */
      /* Termina nodo:262   */

      /* Empieza nodo:264 / Elemento padre: 252   */
      v.add(doc.createElement("td"));
      ((Element)v.get(264)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(252)).appendChild((Element)v.get(264));

      /* Empieza nodo:265 / Elemento padre: 264   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(265)).setAttribute("nombre","cbTipoMovimientoReservaStock" );
      ((Element)v.get(265)).setAttribute("id","datosCampos" );
      ((Element)v.get(265)).setAttribute("size","1" );
      ((Element)v.get(265)).setAttribute("multiple","N" );
      ((Element)v.get(265)).setAttribute("req","N" );
      ((Element)v.get(265)).setAttribute("valorinicial","" );
      ((Element)v.get(265)).setAttribute("textoinicial","" );
      ((Element)v.get(265)).setAttribute("ontab","tab('cbTipoMovimientoReservaStock')" );
      ((Element)v.get(265)).setAttribute("onshtab","shtab('cbTipoMovimientoReservaStock')" );
      ((Element)v.get(264)).appendChild((Element)v.get(265));

      /* Empieza nodo:266 / Elemento padre: 265   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(265)).appendChild((Element)v.get(266));
      /* Termina nodo:266   */
      /* Termina nodo:265   */
      /* Termina nodo:264   */

      /* Empieza nodo:267 / Elemento padre: 252   */
      v.add(doc.createElement("td"));
      ((Element)v.get(267)).setAttribute("width","100%" );
      ((Element)v.get(252)).appendChild((Element)v.get(267));

      /* Empieza nodo:268 / Elemento padre: 267   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(268)).setAttribute("src","b.gif" );
      ((Element)v.get(268)).setAttribute("width","8" );
      ((Element)v.get(268)).setAttribute("height","8" );
      ((Element)v.get(267)).appendChild((Element)v.get(268));
      /* Termina nodo:268   */
      /* Termina nodo:267   */
      /* Termina nodo:252   */

      /* Empieza nodo:269 / Elemento padre: 236   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(236)).appendChild((Element)v.get(269));

      /* Empieza nodo:270 / Elemento padre: 269   */
      v.add(doc.createElement("td"));
      ((Element)v.get(270)).setAttribute("colspan","4" );
      ((Element)v.get(269)).appendChild((Element)v.get(270));

      /* Empieza nodo:271 / Elemento padre: 270   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(271)).setAttribute("src","b.gif" );
      ((Element)v.get(271)).setAttribute("width","8" );
      ((Element)v.get(271)).setAttribute("height","8" );
      ((Element)v.get(270)).appendChild((Element)v.get(271));
      /* Termina nodo:271   */
      /* Termina nodo:270   */
      /* Termina nodo:269   */
      /* Termina nodo:236   */

      /* Empieza nodo:272 / Elemento padre: 56   */
      v.add(doc.createElement("table"));
      ((Element)v.get(272)).setAttribute("width","100%" );
      ((Element)v.get(272)).setAttribute("border","0" );
      ((Element)v.get(272)).setAttribute("align","center" );
      ((Element)v.get(272)).setAttribute("cellspacing","0" );
      ((Element)v.get(272)).setAttribute("cellpadding","0" );
      ((Element)v.get(56)).appendChild((Element)v.get(272));

      /* Empieza nodo:273 / Elemento padre: 272   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(272)).appendChild((Element)v.get(273));

      /* Empieza nodo:274 / Elemento padre: 273   */
      v.add(doc.createElement("td"));
      ((Element)v.get(273)).appendChild((Element)v.get(274));

      /* Empieza nodo:275 / Elemento padre: 274   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(275)).setAttribute("src","b.gif" );
      ((Element)v.get(275)).setAttribute("width","8" );
      ((Element)v.get(275)).setAttribute("height","8" );
      ((Element)v.get(274)).appendChild((Element)v.get(275));
      /* Termina nodo:275   */
      /* Termina nodo:274   */

      /* Empieza nodo:276 / Elemento padre: 273   */
      v.add(doc.createElement("td"));
      ((Element)v.get(273)).appendChild((Element)v.get(276));

      /* Empieza nodo:277 / Elemento padre: 276   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(277)).setAttribute("nombre","lblTipoMovimientoFacturacion" );
      ((Element)v.get(277)).setAttribute("alto","13" );
      ((Element)v.get(277)).setAttribute("filas","1" );
      ((Element)v.get(277)).setAttribute("valor","" );
      ((Element)v.get(277)).setAttribute("id","datosTitle" );
      ((Element)v.get(277)).setAttribute("cod","2381" );
      ((Element)v.get(276)).appendChild((Element)v.get(277));
      /* Termina nodo:277   */
      /* Termina nodo:276   */

      /* Empieza nodo:278 / Elemento padre: 273   */
      v.add(doc.createElement("td"));
      ((Element)v.get(273)).appendChild((Element)v.get(278));

      /* Empieza nodo:279 / Elemento padre: 278   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(279)).setAttribute("src","b.gif" );
      ((Element)v.get(279)).setAttribute("width","25" );
      ((Element)v.get(279)).setAttribute("height","8" );
      ((Element)v.get(278)).appendChild((Element)v.get(279));
      /* Termina nodo:279   */
      /* Termina nodo:278   */

      /* Empieza nodo:280 / Elemento padre: 273   */
      v.add(doc.createElement("td"));
      ((Element)v.get(273)).appendChild((Element)v.get(280));

      /* Empieza nodo:281 / Elemento padre: 280   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(281)).setAttribute("nombre","lblCodActividadCronograma" );
      ((Element)v.get(281)).setAttribute("alto","13" );
      ((Element)v.get(281)).setAttribute("filas","1" );
      ((Element)v.get(281)).setAttribute("valor","" );
      ((Element)v.get(281)).setAttribute("id","datosTitle" );
      ((Element)v.get(281)).setAttribute("cod","151" );
      ((Element)v.get(280)).appendChild((Element)v.get(281));
      /* Termina nodo:281   */
      /* Termina nodo:280   */

      /* Empieza nodo:282 / Elemento padre: 273   */
      v.add(doc.createElement("td"));
      ((Element)v.get(273)).appendChild((Element)v.get(282));

      /* Empieza nodo:283 / Elemento padre: 282   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(283)).setAttribute("src","b.gif" );
      ((Element)v.get(283)).setAttribute("width","25" );
      ((Element)v.get(283)).setAttribute("height","8" );
      ((Element)v.get(282)).appendChild((Element)v.get(283));
      /* Termina nodo:283   */
      /* Termina nodo:282   */

      /* Empieza nodo:284 / Elemento padre: 273   */
      v.add(doc.createElement("td"));
      ((Element)v.get(273)).appendChild((Element)v.get(284));

      /* Empieza nodo:285 / Elemento padre: 284   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(285)).setAttribute("nombre","lblMoneda" );
      ((Element)v.get(285)).setAttribute("alto","13" );
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(285)).setAttribute("filas","1" );
      ((Element)v.get(285)).setAttribute("valor","" );
      ((Element)v.get(285)).setAttribute("id","datosTitle" );
      ((Element)v.get(285)).setAttribute("cod","1216" );
      ((Element)v.get(284)).appendChild((Element)v.get(285));
      /* Termina nodo:285   */
      /* Termina nodo:284   */

      /* Empieza nodo:286 / Elemento padre: 273   */
      v.add(doc.createElement("td"));
      ((Element)v.get(286)).setAttribute("width","100%" );
      ((Element)v.get(273)).appendChild((Element)v.get(286));

      /* Empieza nodo:287 / Elemento padre: 286   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(287)).setAttribute("src","b.gif" );
      ((Element)v.get(287)).setAttribute("width","8" );
      ((Element)v.get(287)).setAttribute("height","8" );
      ((Element)v.get(286)).appendChild((Element)v.get(287));
      /* Termina nodo:287   */
      /* Termina nodo:286   */
      /* Termina nodo:273   */

      /* Empieza nodo:288 / Elemento padre: 272   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(272)).appendChild((Element)v.get(288));

      /* Empieza nodo:289 / Elemento padre: 288   */
      v.add(doc.createElement("td"));
      ((Element)v.get(288)).appendChild((Element)v.get(289));

      /* Empieza nodo:290 / Elemento padre: 289   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(290)).setAttribute("src","b.gif" );
      ((Element)v.get(290)).setAttribute("width","8" );
      ((Element)v.get(290)).setAttribute("height","8" );
      ((Element)v.get(289)).appendChild((Element)v.get(290));
      /* Termina nodo:290   */
      /* Termina nodo:289   */

      /* Empieza nodo:291 / Elemento padre: 288   */
      v.add(doc.createElement("td"));
      ((Element)v.get(291)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(288)).appendChild((Element)v.get(291));

      /* Empieza nodo:292 / Elemento padre: 291   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(292)).setAttribute("nombre","cbTipoMovimientoFacturacion" );
      ((Element)v.get(292)).setAttribute("id","datosCampos" );
      ((Element)v.get(292)).setAttribute("size","1" );
      ((Element)v.get(292)).setAttribute("multiple","N" );
      ((Element)v.get(292)).setAttribute("req","N" );
      ((Element)v.get(292)).setAttribute("valorinicial","" );
      ((Element)v.get(292)).setAttribute("textoinicial","" );
      ((Element)v.get(292)).setAttribute("ontab","tab('cbTipoMovimientoFacturacion')" );
      ((Element)v.get(292)).setAttribute("onshtab","shtab('cbTipoMovimientoFacturacion')" );
      ((Element)v.get(291)).appendChild((Element)v.get(292));

      /* Empieza nodo:293 / Elemento padre: 292   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(292)).appendChild((Element)v.get(293));
      /* Termina nodo:293   */
      /* Termina nodo:292   */
      /* Termina nodo:291   */

      /* Empieza nodo:294 / Elemento padre: 288   */
      v.add(doc.createElement("td"));
      ((Element)v.get(288)).appendChild((Element)v.get(294));

      /* Empieza nodo:295 / Elemento padre: 294   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(295)).setAttribute("src","b.gif" );
      ((Element)v.get(295)).setAttribute("width","25" );
      ((Element)v.get(295)).setAttribute("height","8" );
      ((Element)v.get(294)).appendChild((Element)v.get(295));
      /* Termina nodo:295   */
      /* Termina nodo:294   */

      /* Empieza nodo:296 / Elemento padre: 288   */
      v.add(doc.createElement("td"));
      ((Element)v.get(296)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(288)).appendChild((Element)v.get(296));

      /* Empieza nodo:297 / Elemento padre: 296   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(297)).setAttribute("nombre","cbCodActividadCronograma" );
      ((Element)v.get(297)).setAttribute("id","datosCampos" );
      ((Element)v.get(297)).setAttribute("size","1" );
      ((Element)v.get(297)).setAttribute("multiple","N" );
      ((Element)v.get(297)).setAttribute("req","N" );
      ((Element)v.get(297)).setAttribute("valorinicial","" );
      ((Element)v.get(297)).setAttribute("textoinicial","" );
      ((Element)v.get(297)).setAttribute("ontab","tab('cbCodActividadCronograma')" );
      ((Element)v.get(297)).setAttribute("onshtab","shtab('cbCodActividadCronograma')" );
      ((Element)v.get(296)).appendChild((Element)v.get(297));

      /* Empieza nodo:298 / Elemento padre: 297   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(297)).appendChild((Element)v.get(298));
      /* Termina nodo:298   */
      /* Termina nodo:297   */
      /* Termina nodo:296   */

      /* Empieza nodo:299 / Elemento padre: 288   */
      v.add(doc.createElement("td"));
      ((Element)v.get(288)).appendChild((Element)v.get(299));

      /* Empieza nodo:300 / Elemento padre: 299   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(300)).setAttribute("src","b.gif" );
      ((Element)v.get(300)).setAttribute("width","25" );
      ((Element)v.get(300)).setAttribute("height","8" );
      ((Element)v.get(299)).appendChild((Element)v.get(300));
      /* Termina nodo:300   */
      /* Termina nodo:299   */

      /* Empieza nodo:301 / Elemento padre: 288   */
      v.add(doc.createElement("td"));
      ((Element)v.get(301)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(288)).appendChild((Element)v.get(301));

      /* Empieza nodo:302 / Elemento padre: 301   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(302)).setAttribute("nombre","cbMoneda" );
      ((Element)v.get(302)).setAttribute("id","datosCampos" );
      ((Element)v.get(302)).setAttribute("size","1" );
      ((Element)v.get(302)).setAttribute("multiple","N" );
      ((Element)v.get(302)).setAttribute("req","N" );
      ((Element)v.get(302)).setAttribute("valorinicial","" );
      ((Element)v.get(302)).setAttribute("textoinicial","" );
      ((Element)v.get(302)).setAttribute("ontab","tab('cbMoneda')" );
      ((Element)v.get(302)).setAttribute("onshtab","shtab('cbMoneda')" );
      ((Element)v.get(301)).appendChild((Element)v.get(302));

      /* Empieza nodo:303 / Elemento padre: 302   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(302)).appendChild((Element)v.get(303));
      /* Termina nodo:303   */
      /* Termina nodo:302   */
      /* Termina nodo:301   */

      /* Empieza nodo:304 / Elemento padre: 288   */
      v.add(doc.createElement("td"));
      ((Element)v.get(304)).setAttribute("width","100%" );
      ((Element)v.get(288)).appendChild((Element)v.get(304));

      /* Empieza nodo:305 / Elemento padre: 304   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(305)).setAttribute("src","b.gif" );
      ((Element)v.get(305)).setAttribute("width","8" );
   }

   private void getXML1350(Document doc) {
      ((Element)v.get(305)).setAttribute("height","8" );
      ((Element)v.get(304)).appendChild((Element)v.get(305));
      /* Termina nodo:305   */
      /* Termina nodo:304   */
      /* Termina nodo:288   */

      /* Empieza nodo:306 / Elemento padre: 272   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(272)).appendChild((Element)v.get(306));

      /* Empieza nodo:307 / Elemento padre: 306   */
      v.add(doc.createElement("td"));
      ((Element)v.get(307)).setAttribute("colspan","4" );
      ((Element)v.get(306)).appendChild((Element)v.get(307));

      /* Empieza nodo:308 / Elemento padre: 307   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(308)).setAttribute("src","b.gif" );
      ((Element)v.get(308)).setAttribute("width","8" );
      ((Element)v.get(308)).setAttribute("height","8" );
      ((Element)v.get(307)).appendChild((Element)v.get(308));
      /* Termina nodo:308   */
      /* Termina nodo:307   */
      /* Termina nodo:306   */
      /* Termina nodo:272   */

      /* Empieza nodo:309 / Elemento padre: 56   */
      v.add(doc.createElement("table"));
      ((Element)v.get(309)).setAttribute("width","100%" );
      ((Element)v.get(309)).setAttribute("border","0" );
      ((Element)v.get(309)).setAttribute("align","center" );
      ((Element)v.get(309)).setAttribute("cellspacing","0" );
      ((Element)v.get(309)).setAttribute("cellpadding","0" );
      ((Element)v.get(56)).appendChild((Element)v.get(309));

      /* Empieza nodo:310 / Elemento padre: 309   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(309)).appendChild((Element)v.get(310));

      /* Empieza nodo:311 / Elemento padre: 310   */
      v.add(doc.createElement("td"));
      ((Element)v.get(310)).appendChild((Element)v.get(311));

      /* Empieza nodo:312 / Elemento padre: 311   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(312)).setAttribute("src","b.gif" );
      ((Element)v.get(312)).setAttribute("width","8" );
      ((Element)v.get(312)).setAttribute("height","8" );
      ((Element)v.get(311)).appendChild((Element)v.get(312));
      /* Termina nodo:312   */
      /* Termina nodo:311   */

      /* Empieza nodo:313 / Elemento padre: 310   */
      v.add(doc.createElement("td"));
      ((Element)v.get(310)).appendChild((Element)v.get(313));

      /* Empieza nodo:314 / Elemento padre: 313   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(314)).setAttribute("nombre","lblObservaciones" );
      ((Element)v.get(314)).setAttribute("alto","13" );
      ((Element)v.get(314)).setAttribute("filas","1" );
      ((Element)v.get(314)).setAttribute("valor","" );
      ((Element)v.get(314)).setAttribute("id","datosTitle" );
      ((Element)v.get(314)).setAttribute("cod","169" );
      ((Element)v.get(313)).appendChild((Element)v.get(314));
      /* Termina nodo:314   */
      /* Termina nodo:313   */

      /* Empieza nodo:315 / Elemento padre: 310   */
      v.add(doc.createElement("td"));
      ((Element)v.get(315)).setAttribute("width","100%" );
      ((Element)v.get(310)).appendChild((Element)v.get(315));

      /* Empieza nodo:316 / Elemento padre: 315   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(316)).setAttribute("src","b.gif" );
      ((Element)v.get(316)).setAttribute("width","8" );
      ((Element)v.get(316)).setAttribute("height","8" );
      ((Element)v.get(315)).appendChild((Element)v.get(316));
      /* Termina nodo:316   */
      /* Termina nodo:315   */
      /* Termina nodo:310   */

      /* Empieza nodo:317 / Elemento padre: 309   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(309)).appendChild((Element)v.get(317));

      /* Empieza nodo:318 / Elemento padre: 317   */
      v.add(doc.createElement("td"));
      ((Element)v.get(317)).appendChild((Element)v.get(318));

      /* Empieza nodo:319 / Elemento padre: 318   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(319)).setAttribute("src","b.gif" );
      ((Element)v.get(319)).setAttribute("width","8" );
      ((Element)v.get(319)).setAttribute("height","8" );
      ((Element)v.get(318)).appendChild((Element)v.get(319));
      /* Termina nodo:319   */
      /* Termina nodo:318   */

      /* Empieza nodo:320 / Elemento padre: 317   */
      v.add(doc.createElement("td"));
      ((Element)v.get(320)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(317)).appendChild((Element)v.get(320));

      /* Empieza nodo:321 / Elemento padre: 320   */
      v.add(doc.createElement("AREATEXTO"));
      ((Element)v.get(321)).setAttribute("max","255" );
      ((Element)v.get(321)).setAttribute("cols","50" );
      ((Element)v.get(321)).setAttribute("id","datosCampos" );
      ((Element)v.get(321)).setAttribute("msjreq","" );
      ((Element)v.get(321)).setAttribute("nombre","atxtObservaciones" );
      ((Element)v.get(321)).setAttribute("readonly","N" );
      ((Element)v.get(321)).setAttribute("req","N" );
      ((Element)v.get(321)).setAttribute("rows","3" );
      ((Element)v.get(321)).setAttribute("tabindex","2" );
      ((Element)v.get(321)).setAttribute("valor","" );
      ((Element)v.get(321)).setAttribute("ontab","tab('atxtObservaciones')" );
      ((Element)v.get(321)).setAttribute("onshtab","shtab('atxtObservaciones')" );
      ((Element)v.get(320)).appendChild((Element)v.get(321));
      /* Termina nodo:321   */
      /* Termina nodo:320   */

      /* Empieza nodo:322 / Elemento padre: 317   */
      v.add(doc.createElement("td"));
      ((Element)v.get(322)).setAttribute("width","100%" );
      ((Element)v.get(317)).appendChild((Element)v.get(322));

      /* Empieza nodo:323 / Elemento padre: 322   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(323)).setAttribute("src","b.gif" );
      ((Element)v.get(323)).setAttribute("width","8" );
      ((Element)v.get(323)).setAttribute("height","8" );
      ((Element)v.get(322)).appendChild((Element)v.get(323));
      /* Termina nodo:323   */
      /* Termina nodo:322   */
      /* Termina nodo:317   */

      /* Empieza nodo:324 / Elemento padre: 309   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(309)).appendChild((Element)v.get(324));

      /* Empieza nodo:325 / Elemento padre: 324   */
      v.add(doc.createElement("td"));
      ((Element)v.get(325)).setAttribute("colspan","4" );
      ((Element)v.get(324)).appendChild((Element)v.get(325));

      /* Empieza nodo:326 / Elemento padre: 325   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(326)).setAttribute("src","b.gif" );
      ((Element)v.get(326)).setAttribute("width","8" );
      ((Element)v.get(326)).setAttribute("height","8" );
      ((Element)v.get(325)).appendChild((Element)v.get(326));
      /* Termina nodo:326   */
      /* Termina nodo:325   */
      /* Termina nodo:324   */
      /* Termina nodo:309   */
      /* Termina nodo:56   */
      /* Termina nodo:55   */

      /* Empieza nodo:327 / Elemento padre: 52   */
   }

   private void getXML1440(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(52)).appendChild((Element)v.get(327));

      /* Empieza nodo:328 / Elemento padre: 327   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(328)).setAttribute("src","b.gif" );
      ((Element)v.get(327)).appendChild((Element)v.get(328));
      /* Termina nodo:328   */
      /* Termina nodo:327   */
      /* Termina nodo:52   */

      /* Empieza nodo:329 / Elemento padre: 44   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(44)).appendChild((Element)v.get(329));

      /* Empieza nodo:330 / Elemento padre: 329   */
      v.add(doc.createElement("td"));
      ((Element)v.get(330)).setAttribute("width","12" );
      ((Element)v.get(330)).setAttribute("align","center" );
      ((Element)v.get(329)).appendChild((Element)v.get(330));

      /* Empieza nodo:331 / Elemento padre: 330   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(331)).setAttribute("src","b.gif" );
      ((Element)v.get(331)).setAttribute("width","12" );
      ((Element)v.get(331)).setAttribute("height","12" );
      ((Element)v.get(330)).appendChild((Element)v.get(331));
      /* Termina nodo:331   */
      /* Termina nodo:330   */

      /* Empieza nodo:332 / Elemento padre: 329   */
      v.add(doc.createElement("td"));
      ((Element)v.get(332)).setAttribute("width","756" );
      ((Element)v.get(329)).appendChild((Element)v.get(332));

      /* Empieza nodo:333 / Elemento padre: 332   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(333)).setAttribute("src","b.gif" );
      ((Element)v.get(332)).appendChild((Element)v.get(333));
      /* Termina nodo:333   */
      /* Termina nodo:332   */

      /* Empieza nodo:334 / Elemento padre: 329   */
      v.add(doc.createElement("td"));
      ((Element)v.get(334)).setAttribute("width","12" );
      ((Element)v.get(329)).appendChild((Element)v.get(334));

      /* Empieza nodo:335 / Elemento padre: 334   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(335)).setAttribute("src","b.gif" );
      ((Element)v.get(335)).setAttribute("width","12" );
      ((Element)v.get(335)).setAttribute("height","1" );
      ((Element)v.get(334)).appendChild((Element)v.get(335));
      /* Termina nodo:335   */
      /* Termina nodo:334   */
      /* Termina nodo:329   */
      /* Termina nodo:44   */
      /* Termina nodo:43   */
      /* Termina nodo:11   */


   }

}
