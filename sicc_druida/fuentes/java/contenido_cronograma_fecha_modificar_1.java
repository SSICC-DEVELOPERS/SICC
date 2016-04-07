
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_cronograma_fecha_modificar_1  implements es.indra.druida.base.ObjetoXML {
   private ArrayList v = new ArrayList();

   public Element getXML (Document doc){
      

      getXML0(doc);
         

      getXML90(doc);
         

      getXML180(doc);
         

      getXML270(doc);
         

      getXML360(doc);
         

      getXML450(doc);
         

      getXML540(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_cronograma_fecha_modificar_1" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","onLoadPag()" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("cod","081" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(1)).setAttribute("src","sicc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(1));
      /* Termina nodo:1   */

      /* Empieza nodo:2 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(2));

      /* Elemento padre:2 / Elemento actual: 3   */
      v.add(doc.createTextNode("\r   \r\r	function onLoadPag() {\r		configurarMenuSecundario(\"frmModificarFecha\");\r		btnProxy(3, '0');\r		if (get_visibilidad('capaBusqueda')) {\r			txt_to(\"lblActividad1\",get('frmModificarFecha.hTextoActividad'));\r			focaliza('frmModificarFecha.txtDiasDeDesplazamiento');\r			sicc_cambiar_estado(\"txtFecha3\", false)\r		   		} else {\r			txt_to(\"lblActividad2\",get('frmModificarFecha.hTextoActividad'));\r			focaliza('frmModificarFecha.txtFecha3');       \r			sicc_cambiar_estado(\"txtDiasDeDesplazamiento\", false) \r		   		}\r	}\r\r  function fVolver() {\r      history.back();\r  }\r\r	function validaNumero(sNum) {\r		sNum = cdos_trim(sNum);\r		var numeros = \"0123456789\";\r		var c = sNum.charAt(0);\r		var j;\r		if (numeros.indexOf(c) == -1 && c != \"-\")\r			return false;\r		if (c == \"-\" && sNum.length == 1)\r			return false;\r		for (j = 1; j < sNum.length; j++) {\r			c = sNum.charAt(j);\r			if (numeros.indexOf(c) == -1) \r				return false;\r		}\r		return true;\r	}\r\r	function validaPositivo(sNum) {\r		sNum = cdos_trim(sNum);\r		var numeros = \"0123456789\";\r		var c;\r		var j;\r		for (j = 0; j < sNum.length; j++) {\r			c = sNum.charAt(j);\r			if (numeros.indexOf(c) == -1) \r				return false;\r		}\r		return true;\r	}\r\r/*	function validaNumero(sNum) {\r		var re = /[-]?\\d{1,3}/;\r		var res = re.test(sNum);\r		alert(res);\r		return false;\r	}*/\r\r	function fGuardar() {\r						if (get_visibilidad('capaBusqueda')) {\r			if (!sicc_validaciones_generales(\"grupoFase1\"))\r				return;\r			if (!validaNumero(get('frmModificarFecha.txtDiasDeDesplazamiento'))) {\r					GestionarMensaje('1514',sicc_obtenerDescripcion('txtDiasDeDesplazamiento'));\r					focaliza('frmModificarFecha.txtDiasDeDesplazamiento');       \r					return;\r			}\r			set('frmModificarFecha.hDiasDeDesp',get('frmModificarFecha.txtDiasDeDesplazamiento'));\r		} else {\r			if (!sicc_validaciones_generales(\"grupoFase2\"))\r				return;\r			if (EsFechaValida(get('frmModificarFecha.txtFecha3'),get('frmModificarFecha.txtFecha3'),'frmModificarFecha') != 0) {\r				GestionarMensaje('1313',get('frmModificarFecha.hFormatoFechaPais'));\r				focaliza('frmModificarFecha.txtFecha3');       \r				return;\r			}\r			if (!esHoraValida()) {\r				GestionarMensaje('2516');\r				focaliza('frmModificarFecha.txtHora');       \r				return;\r			}\r			set('frmModificarFecha.hFecha',get('frmModificarFecha.txtFecha3'));\r			set('frmModificarFecha.hHora',get('frmModificarFecha.txtHora'));\r		}\r		\r		set('frmModificarFecha.hlblActiFija',GestionarMensaje('1002'));\r		set('frmModificarFecha.hlblActiRefe',GestionarMensaje('1003'));\r		set('frmModificarFecha.accion', 'guardarFechaActividad');\r		set('frmModificarFecha.conectorAction', 'LPMantieneCronograma');\r		enviaSICC('frmModificarFecha');\r	}\r\r	function esHoraValida() {\r		var hora = get('frmModificarFecha.txtHora');\r		var numeros = \"0123456789:\";\r		var c;\r		var i;\r		for (i = 0; i < hora.length; i++) {\r			c = hora.charAt(i);\r			if (numeros.indexOf(c) == -1) \r				return false;\r		}\r		var aHora = hora.split(':');\r				if (aHora.length != 3) \r			return false;\r		for (i = 0; i < aHora.length; i++) {\r			if (aHora[i].length > 2 || aHora[i].length < 1)\r				return false;\r			if (!validaPositivo(aHora[i]))\r				return false;\r		}\r		if (parseInt(aHora[0],10) < 0 || parseInt(aHora[0],10) > 23)\r			return false;\r		if (parseInt(aHora[1],10) < 0 || parseInt(aHora[1],10) > 59)\r			return false;\r		if (parseInt(aHora[2],10) < 0 || parseInt(aHora[2],10) > 59)\r			return false;\r		\r		return true;\r	}\r\r	function fLimpiar() {\r		if (get_visibilidad('capaBusqueda')) {\r			txt_to(\"lblActividad1\",get('frmModificarFecha.hTextoActividad'));\r		} else {\r			txt_to(\"lblActividad2\",get('frmModificarFecha.hTextoActividad'));\r		}\r	}\r\r\r\r   \r"));
      ((Element)v.get(2)).appendChild((Text)v.get(3));

      /* Termina nodo Texto:3   */
      /* Termina nodo:2   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(4));

      /* Empieza nodo:5 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(5)).setAttribute("name","txtDiasDeDesplazamiento" );
      ((Element)v.get(5)).setAttribute("required","true" );
      ((Element)v.get(5)).setAttribute("cod","250" );
      ((Element)v.get(5)).setAttribute("group","grupoFase1" );
      ((Element)v.get(4)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(6)).setAttribute("name","txtFecha3" );
      ((Element)v.get(6)).setAttribute("required","true" );
      ((Element)v.get(6)).setAttribute("cod","183" );
      ((Element)v.get(6)).setAttribute("group","grupoFase2" );
      ((Element)v.get(4)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */
      /* Termina nodo:4   */

      /* Empieza nodo:7 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(7)).setAttribute("nombre","frmModificarFecha" );
      ((Element)v.get(0)).appendChild((Element)v.get(7));

      /* Empieza nodo:8 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(8)).setAttribute("nombre","accion" );
      ((Element)v.get(8)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","casoDeUso" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","hIdVista" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","hActividad" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","hGrupo" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","hTextoActividad" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","hCbPais" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","hMarca" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","hCanal" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","hCodPeriodo" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","hGrupoZona" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 7   */
   }

   private void getXML90(Document doc) {
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","hSubgerencia" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","hRegion" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","hZona" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","hVecDiasSemana" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","hVecMeses" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","hFormatoFechaPais" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","hlblActiFija" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","hlblActiRefe" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","hDiasDeDesp" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","hHora" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","hFecha" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","hChangePaisMC" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(34)).setAttribute("nombre","hChangeMarcaMC" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(35)).setAttribute("nombre","hChangeCanalMC" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(36)).setAttribute("nombre","hChangeGrupo" );
      ((Element)v.get(36)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(37)).setAttribute("nombre","hChangeSub" );
      ((Element)v.get(37)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(38)).setAttribute("nombre","hChangeRegion" );
      ((Element)v.get(38)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 7   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(39)).setAttribute("nombre","capaBusqueda" );
      ((Element)v.get(39)).setAttribute("x","0" );
      ((Element)v.get(39)).setAttribute("y","0" );
      ((Element)v.get(39)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(7)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("table"));
      ((Element)v.get(40)).setAttribute("width","100%" );
      ((Element)v.get(40)).setAttribute("border","0" );
      ((Element)v.get(40)).setAttribute("cellspacing","0" );
      ((Element)v.get(40)).setAttribute("cellpadding","0" );
      ((Element)v.get(39)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(40)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
      ((Element)v.get(42)).setAttribute("width","12" );
      ((Element)v.get(42)).setAttribute("align","center" );
      ((Element)v.get(41)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(43)).setAttribute("src","b.gif" );
      ((Element)v.get(43)).setAttribute("width","12" );
      ((Element)v.get(43)).setAttribute("height","12" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(42)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */
      /* Termina nodo:42   */

      /* Empieza nodo:44 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
      ((Element)v.get(44)).setAttribute("width","750" );
      ((Element)v.get(41)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(45)).setAttribute("src","b.gif" );
      ((Element)v.get(44)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */
      /* Termina nodo:44   */

      /* Empieza nodo:46 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
      ((Element)v.get(46)).setAttribute("width","12" );
      ((Element)v.get(41)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(47)).setAttribute("src","b.gif" );
      ((Element)v.get(47)).setAttribute("width","12" );
      ((Element)v.get(47)).setAttribute("height","1" );
      ((Element)v.get(46)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */
      /* Termina nodo:46   */
      /* Termina nodo:41   */

      /* Empieza nodo:48 / Elemento padre: 40   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(40)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("td"));
      ((Element)v.get(48)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(50)).setAttribute("src","b.gif" );
      ((Element)v.get(49)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */
      /* Termina nodo:49   */

      /* Empieza nodo:51 / Elemento padre: 48   */
      v.add(doc.createElement("td"));
      ((Element)v.get(48)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(51)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(53)).setAttribute("class","legend" );
      ((Element)v.get(52)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(54)).setAttribute("nombre","lblActividad1" );
      ((Element)v.get(54)).setAttribute("alto","13" );
      ((Element)v.get(54)).setAttribute("filas","1" );
      ((Element)v.get(54)).setAttribute("valor","" );
      ((Element)v.get(54)).setAttribute("id","legend" );
      ((Element)v.get(53)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */
      /* Termina nodo:53   */

      /* Empieza nodo:55 / Elemento padre: 52   */
      v.add(doc.createElement("table"));
      ((Element)v.get(55)).setAttribute("width","100%" );
      ((Element)v.get(55)).setAttribute("border","0" );
      ((Element)v.get(55)).setAttribute("align","center" );
      ((Element)v.get(55)).setAttribute("cellspacing","0" );
      ((Element)v.get(55)).setAttribute("cellpadding","0" );
      ((Element)v.get(52)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(55)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(57)).setAttribute("colspan","3" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(58)).setAttribute("src","b.gif" );
      ((Element)v.get(58)).setAttribute("width","8" );
      ((Element)v.get(58)).setAttribute("height","8" );
      ((Element)v.get(57)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */
      /* Termina nodo:57   */
      /* Termina nodo:56   */

      /* Empieza nodo:59 / Elemento padre: 55   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(55)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("td"));
      ((Element)v.get(59)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(61)).setAttribute("src","b.gif" );
      ((Element)v.get(61)).setAttribute("width","8" );
      ((Element)v.get(61)).setAttribute("height","8" );
      ((Element)v.get(60)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */
      /* Termina nodo:60   */

      /* Empieza nodo:62 / Elemento padre: 59   */
      v.add(doc.createElement("td"));
      ((Element)v.get(59)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(63)).setAttribute("nombre","lblFecha" );
      ((Element)v.get(63)).setAttribute("alto","13" );
      ((Element)v.get(63)).setAttribute("filas","1" );
      ((Element)v.get(63)).setAttribute("valor","" );
      ((Element)v.get(63)).setAttribute("id","datosTitle" );
      ((Element)v.get(63)).setAttribute("cod","188" );
      ((Element)v.get(62)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */
      /* Termina nodo:62   */

      /* Empieza nodo:64 / Elemento padre: 59   */
      v.add(doc.createElement("td"));
      ((Element)v.get(59)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(65)).setAttribute("src","b.gif" );
      ((Element)v.get(65)).setAttribute("width","25" );
      ((Element)v.get(65)).setAttribute("height","8" );
      ((Element)v.get(64)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */
      /* Termina nodo:64   */

      /* Empieza nodo:66 / Elemento padre: 59   */
      v.add(doc.createElement("td"));
      ((Element)v.get(59)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(67)).setAttribute("nombre","lblDiasDeDesplazamiento" );
      ((Element)v.get(67)).setAttribute("alto","13" );
      ((Element)v.get(67)).setAttribute("filas","1" );
      ((Element)v.get(67)).setAttribute("valor","" );
      ((Element)v.get(67)).setAttribute("id","datosTitle" );
      ((Element)v.get(67)).setAttribute("cod","250" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */
      /* Termina nodo:66   */

      /* Empieza nodo:68 / Elemento padre: 59   */
      v.add(doc.createElement("td"));
   }

   private void getXML270(Document doc) {
      ((Element)v.get(68)).setAttribute("width","100%" );
      ((Element)v.get(59)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(69)).setAttribute("src","b.gif" );
      ((Element)v.get(69)).setAttribute("width","8" );
      ((Element)v.get(69)).setAttribute("height","8" );
      ((Element)v.get(68)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */
      /* Termina nodo:68   */
      /* Termina nodo:59   */

      /* Empieza nodo:70 / Elemento padre: 55   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(55)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("td"));
      ((Element)v.get(70)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(72)).setAttribute("src","b.gif" );
      ((Element)v.get(72)).setAttribute("width","8" );
      ((Element)v.get(72)).setAttribute("height","8" );
      ((Element)v.get(71)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */
      /* Termina nodo:71   */

      /* Empieza nodo:73 / Elemento padre: 70   */
      v.add(doc.createElement("td"));
      ((Element)v.get(70)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(74)).setAttribute("nombre","lblFechaxx" );
      ((Element)v.get(74)).setAttribute("alto","13" );
      ((Element)v.get(74)).setAttribute("filas","1" );
      ((Element)v.get(74)).setAttribute("valor","" );
      ((Element)v.get(74)).setAttribute("id","datosCampos" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */
      /* Termina nodo:73   */

      /* Empieza nodo:75 / Elemento padre: 70   */
      v.add(doc.createElement("td"));
      ((Element)v.get(70)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(76)).setAttribute("src","b.gif" );
      ((Element)v.get(76)).setAttribute("width","25" );
      ((Element)v.get(76)).setAttribute("height","8" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */
      /* Termina nodo:75   */

      /* Empieza nodo:77 / Elemento padre: 70   */
      v.add(doc.createElement("td"));
      ((Element)v.get(77)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(70)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(78)).setAttribute("nombre","txtDiasDeDesplazamiento" );
      ((Element)v.get(78)).setAttribute("id","datosCampos" );
      ((Element)v.get(78)).setAttribute("max","3" );
      ((Element)v.get(78)).setAttribute("tipo","" );
      ((Element)v.get(78)).setAttribute("req","S" );
      ((Element)v.get(78)).setAttribute("size","3" );
      ((Element)v.get(78)).setAttribute("valor","" );
      ((Element)v.get(78)).setAttribute("ontab","focaliza('frmModificarFecha.txtDiasDeDesplazamiento')" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */
      /* Termina nodo:77   */

      /* Empieza nodo:79 / Elemento padre: 70   */
      v.add(doc.createElement("td"));
      ((Element)v.get(70)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(80)).setAttribute("src","b.gif" );
      ((Element)v.get(80)).setAttribute("width","83" );
      ((Element)v.get(80)).setAttribute("height","8" );
      ((Element)v.get(79)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */
      /* Termina nodo:79   */

      /* Empieza nodo:81 / Elemento padre: 70   */
      v.add(doc.createElement("td"));
      ((Element)v.get(70)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(82)).setAttribute("src","b.gif" );
      ((Element)v.get(82)).setAttribute("width","8" );
      ((Element)v.get(82)).setAttribute("height","8" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */
      /* Termina nodo:81   */
      /* Termina nodo:70   */

      /* Empieza nodo:83 / Elemento padre: 55   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(55)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("td"));
      ((Element)v.get(84)).setAttribute("colspan","3" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(85)).setAttribute("src","b.gif" );
      ((Element)v.get(85)).setAttribute("width","8" );
      ((Element)v.get(85)).setAttribute("height","8" );
      ((Element)v.get(84)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */
      /* Termina nodo:84   */
      /* Termina nodo:83   */
      /* Termina nodo:55   */
      /* Termina nodo:52   */
      /* Termina nodo:51   */

      /* Empieza nodo:86 / Elemento padre: 48   */
      v.add(doc.createElement("td"));
      ((Element)v.get(48)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(87)).setAttribute("src","b.gif" );
      ((Element)v.get(86)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */
      /* Termina nodo:86   */
      /* Termina nodo:48   */

      /* Empieza nodo:88 / Elemento padre: 40   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(40)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("td"));
      ((Element)v.get(89)).setAttribute("width","12" );
      ((Element)v.get(89)).setAttribute("align","center" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(90)).setAttribute("src","b.gif" );
      ((Element)v.get(90)).setAttribute("width","12" );
      ((Element)v.get(90)).setAttribute("height","12" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */
      /* Termina nodo:89   */

      /* Empieza nodo:91 / Elemento padre: 88   */
      v.add(doc.createElement("td"));
      ((Element)v.get(91)).setAttribute("width","756" );
      ((Element)v.get(88)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(92)).setAttribute("src","b.gif" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(91)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */
      /* Termina nodo:91   */

      /* Empieza nodo:93 / Elemento padre: 88   */
      v.add(doc.createElement("td"));
      ((Element)v.get(93)).setAttribute("width","12" );
      ((Element)v.get(88)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(94)).setAttribute("src","b.gif" );
      ((Element)v.get(94)).setAttribute("width","12" );
      ((Element)v.get(94)).setAttribute("height","1" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */
      /* Termina nodo:93   */
      /* Termina nodo:88   */
      /* Termina nodo:40   */
      /* Termina nodo:39   */

      /* Empieza nodo:95 / Elemento padre: 7   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(95)).setAttribute("nombre","capaBusqueda2" );
      ((Element)v.get(95)).setAttribute("x","0" );
      ((Element)v.get(95)).setAttribute("y","0" );
      ((Element)v.get(95)).setAttribute("visibilidad","" );
      ((Element)v.get(7)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("table"));
      ((Element)v.get(96)).setAttribute("width","100%" );
      ((Element)v.get(96)).setAttribute("border","0" );
      ((Element)v.get(96)).setAttribute("cellspacing","0" );
      ((Element)v.get(96)).setAttribute("cellpadding","0" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(96)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("td"));
      ((Element)v.get(98)).setAttribute("width","12" );
      ((Element)v.get(98)).setAttribute("align","center" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(99)).setAttribute("src","b.gif" );
      ((Element)v.get(99)).setAttribute("width","12" );
      ((Element)v.get(99)).setAttribute("height","12" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */
      /* Termina nodo:98   */

      /* Empieza nodo:100 / Elemento padre: 97   */
      v.add(doc.createElement("td"));
      ((Element)v.get(100)).setAttribute("width","750" );
      ((Element)v.get(97)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(101)).setAttribute("src","b.gif" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */
      /* Termina nodo:100   */

      /* Empieza nodo:102 / Elemento padre: 97   */
      v.add(doc.createElement("td"));
      ((Element)v.get(102)).setAttribute("width","12" );
      ((Element)v.get(97)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(103)).setAttribute("src","b.gif" );
      ((Element)v.get(103)).setAttribute("width","12" );
      ((Element)v.get(103)).setAttribute("height","1" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */
      /* Termina nodo:102   */
      /* Termina nodo:97   */

      /* Empieza nodo:104 / Elemento padre: 96   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(96)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("td"));
      ((Element)v.get(104)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(106)).setAttribute("src","b.gif" );
      ((Element)v.get(105)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */
      /* Termina nodo:105   */

      /* Empieza nodo:107 / Elemento padre: 104   */
      v.add(doc.createElement("td"));
      ((Element)v.get(104)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(107)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(109)).setAttribute("class","legend" );
      ((Element)v.get(108)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(110)).setAttribute("nombre","lblActividad2" );
      ((Element)v.get(110)).setAttribute("alto","13" );
      ((Element)v.get(110)).setAttribute("filas","1" );
      ((Element)v.get(110)).setAttribute("valor","" );
      ((Element)v.get(110)).setAttribute("id","legend" );
      ((Element)v.get(110)).setAttribute("cod","313" );
      ((Element)v.get(109)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */
      /* Termina nodo:109   */

      /* Empieza nodo:111 / Elemento padre: 108   */
      v.add(doc.createElement("table"));
      ((Element)v.get(111)).setAttribute("width","100%" );
      ((Element)v.get(111)).setAttribute("border","0" );
      ((Element)v.get(111)).setAttribute("align","center" );
      ((Element)v.get(111)).setAttribute("cellspacing","0" );
      ((Element)v.get(111)).setAttribute("cellpadding","0" );
      ((Element)v.get(108)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(111)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("td"));
      ((Element)v.get(113)).setAttribute("colspan","3" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(114)).setAttribute("src","b.gif" );
      ((Element)v.get(114)).setAttribute("width","8" );
      ((Element)v.get(114)).setAttribute("height","8" );
      ((Element)v.get(113)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */
      /* Termina nodo:113   */
      /* Termina nodo:112   */

      /* Empieza nodo:115 / Elemento padre: 111   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(111)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("td"));
      ((Element)v.get(115)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML450(Document doc) {
      ((Element)v.get(117)).setAttribute("src","b.gif" );
      ((Element)v.get(117)).setAttribute("width","8" );
      ((Element)v.get(117)).setAttribute("height","8" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */
      /* Termina nodo:116   */

      /* Empieza nodo:118 / Elemento padre: 115   */
      v.add(doc.createElement("td"));
      ((Element)v.get(115)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(119)).setAttribute("nombre","lblFecha3" );
      ((Element)v.get(119)).setAttribute("alto","13" );
      ((Element)v.get(119)).setAttribute("filas","1" );
      ((Element)v.get(119)).setAttribute("valor","" );
      ((Element)v.get(119)).setAttribute("id","datosTitle" );
      ((Element)v.get(119)).setAttribute("cod","183" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));
      /* Termina nodo:119   */
      /* Termina nodo:118   */

      /* Empieza nodo:120 / Elemento padre: 115   */
      v.add(doc.createElement("td"));
      ((Element)v.get(115)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(121)).setAttribute("src","b.gif" );
      ((Element)v.get(121)).setAttribute("width","25" );
      ((Element)v.get(121)).setAttribute("height","8" );
      ((Element)v.get(120)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */
      /* Termina nodo:120   */

      /* Empieza nodo:122 / Elemento padre: 115   */
      v.add(doc.createElement("td"));
      ((Element)v.get(115)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(123)).setAttribute("nombre","lblHora" );
      ((Element)v.get(123)).setAttribute("alto","13" );
      ((Element)v.get(123)).setAttribute("filas","1" );
      ((Element)v.get(123)).setAttribute("valor","" );
      ((Element)v.get(123)).setAttribute("id","datosTitle" );
      ((Element)v.get(123)).setAttribute("cod","184" );
      ((Element)v.get(122)).appendChild((Element)v.get(123));
      /* Termina nodo:123   */
      /* Termina nodo:122   */

      /* Empieza nodo:124 / Elemento padre: 115   */
      v.add(doc.createElement("td"));
      ((Element)v.get(124)).setAttribute("width","100%" );
      ((Element)v.get(115)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(125)).setAttribute("src","b.gif" );
      ((Element)v.get(125)).setAttribute("width","8" );
      ((Element)v.get(125)).setAttribute("height","8" );
      ((Element)v.get(124)).appendChild((Element)v.get(125));
      /* Termina nodo:125   */
      /* Termina nodo:124   */
      /* Termina nodo:115   */

      /* Empieza nodo:126 / Elemento padre: 111   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(111)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("td"));
      ((Element)v.get(126)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(128)).setAttribute("src","b.gif" );
      ((Element)v.get(128)).setAttribute("width","8" );
      ((Element)v.get(128)).setAttribute("height","8" );
      ((Element)v.get(127)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */
      /* Termina nodo:127   */

      /* Empieza nodo:129 / Elemento padre: 126   */
      v.add(doc.createElement("td"));
      ((Element)v.get(129)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(126)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(130)).setAttribute("nombre","txtFecha3" );
      ((Element)v.get(130)).setAttribute("id","datosCampos" );
      ((Element)v.get(130)).setAttribute("max","10" );
      ((Element)v.get(130)).setAttribute("tipo","" );
      ((Element)v.get(130)).setAttribute("req","S" );
      ((Element)v.get(130)).setAttribute("size","11" );
      ((Element)v.get(130)).setAttribute("valor","" );
      ((Element)v.get(130)).setAttribute("onshtab","focaliza('frmModificarFecha.txtHora');" );
      ((Element)v.get(129)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */
      /* Termina nodo:129   */

      /* Empieza nodo:131 / Elemento padre: 126   */
      v.add(doc.createElement("td"));
      ((Element)v.get(126)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(132)).setAttribute("src","b.gif" );
      ((Element)v.get(132)).setAttribute("width","25" );
      ((Element)v.get(132)).setAttribute("height","8" );
      ((Element)v.get(131)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */
      /* Termina nodo:131   */

      /* Empieza nodo:133 / Elemento padre: 126   */
      v.add(doc.createElement("td"));
      ((Element)v.get(126)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(134)).setAttribute("nombre","txtHora" );
      ((Element)v.get(134)).setAttribute("id","datosCampos" );
      ((Element)v.get(134)).setAttribute("max","8" );
      ((Element)v.get(134)).setAttribute("tipo","" );
      ((Element)v.get(134)).setAttribute("req","N" );
      ((Element)v.get(134)).setAttribute("size","8" );
      ((Element)v.get(134)).setAttribute("valor","" );
      ((Element)v.get(134)).setAttribute("ontab","focaliza('frmModificarFecha.txtFecha3');" );
      ((Element)v.get(133)).appendChild((Element)v.get(134));
      /* Termina nodo:134   */
      /* Termina nodo:133   */

      /* Empieza nodo:135 / Elemento padre: 126   */
      v.add(doc.createElement("td"));
      ((Element)v.get(126)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(136)).setAttribute("src","b.gif" );
      ((Element)v.get(136)).setAttribute("width","125" );
      ((Element)v.get(136)).setAttribute("height","8" );
      ((Element)v.get(135)).appendChild((Element)v.get(136));
      /* Termina nodo:136   */
      /* Termina nodo:135   */

      /* Empieza nodo:137 / Elemento padre: 126   */
      v.add(doc.createElement("td"));
      ((Element)v.get(137)).setAttribute("width","100%" );
      ((Element)v.get(126)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
   }

   private void getXML540(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(138)).setAttribute("src","b.gif" );
      ((Element)v.get(138)).setAttribute("width","8" );
      ((Element)v.get(138)).setAttribute("height","8" );
      ((Element)v.get(137)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */
      /* Termina nodo:137   */
      /* Termina nodo:126   */

      /* Empieza nodo:139 / Elemento padre: 111   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(111)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("td"));
      ((Element)v.get(140)).setAttribute("colspan","3" );
      ((Element)v.get(139)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(141)).setAttribute("src","b.gif" );
      ((Element)v.get(141)).setAttribute("width","8" );
      ((Element)v.get(141)).setAttribute("height","8" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */
      /* Termina nodo:140   */
      /* Termina nodo:139   */
      /* Termina nodo:111   */
      /* Termina nodo:108   */
      /* Termina nodo:107   */

      /* Empieza nodo:142 / Elemento padre: 104   */
      v.add(doc.createElement("td"));
      ((Element)v.get(104)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(143)).setAttribute("src","b.gif" );
      ((Element)v.get(142)).appendChild((Element)v.get(143));
      /* Termina nodo:143   */
      /* Termina nodo:142   */
      /* Termina nodo:104   */

      /* Empieza nodo:144 / Elemento padre: 96   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(96)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("td"));
      ((Element)v.get(145)).setAttribute("width","12" );
      ((Element)v.get(145)).setAttribute("align","center" );
      ((Element)v.get(144)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(146)).setAttribute("src","b.gif" );
      ((Element)v.get(146)).setAttribute("width","12" );
      ((Element)v.get(146)).setAttribute("height","12" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));
      /* Termina nodo:146   */
      /* Termina nodo:145   */

      /* Empieza nodo:147 / Elemento padre: 144   */
      v.add(doc.createElement("td"));
      ((Element)v.get(147)).setAttribute("width","756" );
      ((Element)v.get(144)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(148)).setAttribute("src","b.gif" );
      ((Element)v.get(147)).appendChild((Element)v.get(148));
      /* Termina nodo:148   */
      /* Termina nodo:147   */

      /* Empieza nodo:149 / Elemento padre: 144   */
      v.add(doc.createElement("td"));
      ((Element)v.get(149)).setAttribute("width","12" );
      ((Element)v.get(144)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(150)).setAttribute("src","b.gif" );
      ((Element)v.get(150)).setAttribute("width","12" );
      ((Element)v.get(150)).setAttribute("height","1" );
      ((Element)v.get(149)).appendChild((Element)v.get(150));
      /* Termina nodo:150   */
      /* Termina nodo:149   */
      /* Termina nodo:144   */
      /* Termina nodo:96   */
      /* Termina nodo:95   */
      /* Termina nodo:7   */


   }

}
