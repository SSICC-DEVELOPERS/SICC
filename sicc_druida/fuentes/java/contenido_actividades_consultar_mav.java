
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_actividades_consultar_mav  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_actividades_consultar" );
      ((Element)v.get(0)).setAttribute("cod","092" );
      ((Element)v.get(0)).setAttribute("titulo","Consultar Actividades" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","onLoadPag();" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(1)).setAttribute("src","sicc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(1));
      /* Termina nodo:1   */

      /* Empieza nodo:2 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(2)).setAttribute("src","PaginacionSicc.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(2));
      /* Termina nodo:2   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(3)).setAttribute("src","DruidaTransactionMare.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(4));

      /* Elemento padre:4 / Elemento actual: 5   */
      v.add(doc.createTextNode("\r   \r\r	var form = \"frmFormulario.\";\r	var elementos = new Array('txtCodActividad', 'txtDescripcion', 'cbMarca', 'cbCanal', 'btnBuscar',\r								'btnDetalle', 'btnModificar');\r	\r	function onLoadPag(){\r		ocultarLista();\r		configurarMenuSecundario(\"frmFormulario\");\r		fMostrarMensajeError();\r		focaliza(form + elementos[0]);  \r		if( get(form + 'casodeuso') == 'modificar' || get(form + 'casodeuso') == 'consultar'){\r			mipgndo1.lista.maxSel = 1;\r		}\r		if( get(form + 'casodeuso') == 'eliminar'  ){\r			btnProxy(4, 0);\r			mipgndo1.lista.maxSel = -1;\r		}\r		\r   }\r   \r   function mostrarLista(){\r		DrdEnsanchaConMargenDcho('listado1',12);\r		document.all[\"Cplistado1\"].style.visibility='visible';\r		document.all[\"CpLin1listado1\"].style.visibility='visible';\r		document.all[\"CpLin2listado1\"].style.visibility='visible';\r		document.all[\"CpLin3listado1\"].style.visibility='visible';\r		document.all[\"CpLin4listado1\"].style.visibility='visible';\r		document.all[\"separaDiv\"].style.visibility='visible';\r		document.all[\"primera1Div\"].style.visibility='visible';\r		document.all[\"ret1Div\"].style.visibility='visible';\r		document.all[\"ava1Div\"].style.visibility='visible';\r		document.all[\"btnModificarDiv\"].style.visibility='hidden';\r		document.all[\"btnDetalleDiv\"].style.visibility='hidden';\r		if( get(form + 'casodeuso') == 'consultar' || get(form + 'casodeuso') == 'eliminar'){\r			document.all[\"btnDetalleDiv\"].style.visibility='visible';\r		} \r		if( get(form + 'casodeuso') == 'modificar' ){\r			document.all[\"btnModificarDiv\"].style.visibility='visible';\r		}\r		eval (ON_RSZ);  \r   }\r\r   function ocultarLista(){\r		DrdEnsanchaConMargenDcho('listado1',12);\r		document.all[\"Cplistado1\"].style.visibility='hidden';\r		document.all[\"CpLin1listado1\"].style.visibility='hidden';\r		document.all[\"CpLin2listado1\"].style.visibility='hidden';\r		document.all[\"CpLin3listado1\"].style.visibility='hidden';\r		document.all[\"CpLin4listado1\"].style.visibility='hidden';\r		document.all[\"separaDiv\"].style.visibility='hidden';\r		document.all[\"primera1Div\"].style.visibility='hidden';\r		document.all[\"ret1Div\"].style.visibility='hidden';\r		document.all[\"ava1Div\"].style.visibility='hidden';\r		document.all[\"btnDetalleDiv\"].style.visibility='hidden';\r		document.all[\"btnModificarDiv\"].style.visibility='hidden';\r   }\r\r	function detalle(){\r		var valorSeteado = mipgndo1.lista.codSeleccionados();\r		set(form + 'accion', 'detalle');\r\r		if( valorSeteado != '' ){\r						var obj = new Object();\r			obj.seleccion = valorSeteado;\r			obj.casodeuso = 'consultar';\r			var winModal = mostrarModalSICC('LPMantenimientoActividadesMAV', 'detalle', obj, null, null);\r		}else{\r			GestionarMensaje('4', null, null, null);\r		}\r	}\r\r\r\r	function modificar(){\r		var valorSeteado = mipgndo1.lista.codSeleccionados();\r		set(form + 'accion', 'modificar');\r\r		if( valorSeteado != '' ){\r			var obj = new Object();\r			obj.seleccion = valorSeteado;\r			obj.casodeuso = 'modificar';\r			var winModal = mostrarModalSICC('LPMantenimientoActividadesMAV', 'modificar', obj, null, null);\r\r			if (winModal){            \r				mipgndo1.recargar();          \r	        } \r\r		}else{\r			GestionarMensaje('4', null, null, null);\r		}\r	}\r\r	function buscar(){\r		if(sicc_validaciones_generales())\r		configurarPaginado(mipgndo1, \"MAVBuscarActividades\", \"ConectorBuscarActividadesMAV\", \r							\"es.indra.sicc.dtos.mav.DTOEBuscarActividadesMAV\", armarArray() );\r		focaliza(form + 'txtCodActividad');\r	}\r\r	function muestraLista( ultima, rowset ){\r		var tamano = rowset.length;\r		if (tamano > 0) {\r			mostrarLista();\r			if(get(form + 'casodeuso') == 'eliminar'){\r				btnProxy(4, 1);\r			}else{\r				btnProxy(4, 0);\r			}\r			return true;\r		} else {\r			ocultarLista();\r			btnProxy(4, 0);\r			focaliza(form + 'txtCodActividad');\r			return false;\r		}\r	}\r\r	function armarArray(){\r		var hh = new Array();\r		var i=0;\r \r		hh[i] = new Array('oidIdioma','1');\r		i++;\r		hh[i] = new Array('oidPais','1');\r		i++;\r \r		if( get(form + 'txtCodActividad') != ''){\r			hh[i] = new Array('codigo', get(form + 'txtCodActividad'));\r			i++;\r		}\r\r		if( get(form + 'cbCanal') != ''){\r			hh[i] = new Array('canal', get(form + 'cbCanal'));\r			i++;\r		}\r\r		if( get(form + 'txtDescripcion') != ''){\r			hh[i] = new Array('descripcion' , get(form + 'txtDescripcion'));\r		}\r        return hh;\r	}\r\r	function fBorrar(){\r		var seleccion = mipgndo1.lista.codSeleccionados();\r		if( seleccion != '' ){\r			eliminarFilas(seleccion, 'MAVEliminarActividades', mipgndo1);\r		} else {\r			GestionarMensaje('4', null, null, null);\r		}\r	}\r\r	function fLimpiar(){	\r		focaliza(form + 'txtCodActividad');		\r\r	}\r\r	function tab(elemento){\r		try{\r			for(i=0; i < elementos.length; i++){\r				if( elementos[i] == elemento ){\r					if( i == elementos.length - 1 ) i = 0;\r					else i++;\r					document.selection.empty();\r					switch(elementos[i]){\r						case 'btnBuscar':\r						case 'btnDetalle':\r						case 'btnModificar': \r							focalizaBotonHTML('botonContenido', elementos[i]);\r							break;\r						default:\r							focaliza(form + elementos[i]);\r							break;\r					}\r					return;\r				}\r			}\r		}catch(e){\r			tab(elementos[i]);\r		}\r	}\r\r	function shtab(elemento){\r		try{\r			for(i=elementos.length - 1; i >= 0 ; i--){\r				if( elementos[i] == elemento ){\r					if( i == 0 ) i = elementos.length - 1;\r					else i--;\r					document.selection.empty();\r					switch(elementos[i]){\r						case 'btnBuscar':\r						case 'btnDetalle':\r						case 'btnModificar': \r							focalizaBotonHTML('botonContenido', elementos[i]);\r							break;\r						default:\r							focaliza(form + elementos[i]);\r							break;\r					}\r					return;\r				}\r			}\r		}catch(e){\r			shtab(elementos[i]);\r		}\r	}\r\r   \r"));
      ((Element)v.get(4)).appendChild((Text)v.get(5));

      /* Termina nodo Texto:5   */
      /* Termina nodo:4   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(6));

      /* Empieza nodo:7 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(7)).setAttribute("name","txtCodActividad" );
      ((Element)v.get(7)).setAttribute("required","false" );
      ((Element)v.get(7)).setAttribute("cod","151" );
      ((Element)v.get(7)).setAttribute("format","e" );
      ((Element)v.get(7)).setAttribute("min","0" );
      ((Element)v.get(7)).setAttribute("max","999999" );
      ((Element)v.get(6)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */
      /* Termina nodo:6   */

      /* Empieza nodo:8 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(8)).setAttribute("nombre","frmFormulario" );
      ((Element)v.get(0)).appendChild((Element)v.get(8));

      /* Empieza nodo:9 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(9)).setAttribute("valor","LPMantenimientoActividadesMAV" );
      ((Element)v.get(8)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","accion" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","casodeuso" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 8   */
      v.add(doc.createElement("table"));
      ((Element)v.get(14)).setAttribute("width","100%" );
      ((Element)v.get(14)).setAttribute("border","0" );
      ((Element)v.get(14)).setAttribute("cellspacing","0" );
      ((Element)v.get(14)).setAttribute("cellpadding","0" );
      ((Element)v.get(8)).appendChild((Element)v.get(14));

      /* Empieza nodo:15 / Elemento padre: 14   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(14)).appendChild((Element)v.get(15));

      /* Empieza nodo:16 / Elemento padre: 15   */
      v.add(doc.createElement("td"));
      ((Element)v.get(16)).setAttribute("width","12" );
      ((Element)v.get(16)).setAttribute("align","center" );
      ((Element)v.get(15)).appendChild((Element)v.get(16));

      /* Empieza nodo:17 / Elemento padre: 16   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(17)).setAttribute("src","b.gif" );
      ((Element)v.get(17)).setAttribute("width","12" );
      ((Element)v.get(17)).setAttribute("height","12" );
      ((Element)v.get(16)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */
      /* Termina nodo:16   */

      /* Empieza nodo:18 / Elemento padre: 15   */
      v.add(doc.createElement("td"));
      ((Element)v.get(18)).setAttribute("width","750" );
      ((Element)v.get(15)).appendChild((Element)v.get(18));

      /* Empieza nodo:19 / Elemento padre: 18   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(19)).setAttribute("src","b.gif" );
      ((Element)v.get(18)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */
      /* Termina nodo:18   */

      /* Empieza nodo:20 / Elemento padre: 15   */
      v.add(doc.createElement("td"));
      ((Element)v.get(20)).setAttribute("width","12" );
      ((Element)v.get(15)).appendChild((Element)v.get(20));

      /* Empieza nodo:21 / Elemento padre: 20   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(21)).setAttribute("src","b.gif" );
      ((Element)v.get(21)).setAttribute("width","12" );
      ((Element)v.get(21)).setAttribute("height","1" );
      ((Element)v.get(20)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */
      /* Termina nodo:20   */
      /* Termina nodo:15   */

      /* Empieza nodo:22 / Elemento padre: 14   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(14)).appendChild((Element)v.get(22));

      /* Empieza nodo:23 / Elemento padre: 22   */
      v.add(doc.createElement("td"));
   }

   private void getXML90(Document doc) {
      ((Element)v.get(22)).appendChild((Element)v.get(23));

      /* Empieza nodo:24 / Elemento padre: 23   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(24)).setAttribute("src","b.gif" );
      ((Element)v.get(23)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */
      /* Termina nodo:23   */

      /* Empieza nodo:25 / Elemento padre: 22   */
      v.add(doc.createElement("td"));
      ((Element)v.get(22)).appendChild((Element)v.get(25));

      /* Empieza nodo:26 / Elemento padre: 25   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(25)).appendChild((Element)v.get(26));

      /* Empieza nodo:27 / Elemento padre: 26   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(27)).setAttribute("class","legend" );
      ((Element)v.get(26)).appendChild((Element)v.get(27));

      /* Empieza nodo:28 / Elemento padre: 27   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(28)).setAttribute("nombre","lblCriteriosBusqueda" );
      ((Element)v.get(28)).setAttribute("alto","13" );
      ((Element)v.get(28)).setAttribute("filas","1" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(28)).setAttribute("id","legend" );
      ((Element)v.get(28)).setAttribute("cod","0075" );
      ((Element)v.get(27)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */
      /* Termina nodo:27   */

      /* Empieza nodo:29 / Elemento padre: 26   */
      v.add(doc.createElement("table"));
      ((Element)v.get(29)).setAttribute("width","100%" );
      ((Element)v.get(29)).setAttribute("border","0" );
      ((Element)v.get(29)).setAttribute("align","center" );
      ((Element)v.get(29)).setAttribute("cellspacing","0" );
      ((Element)v.get(29)).setAttribute("cellpadding","0" );
      ((Element)v.get(26)).appendChild((Element)v.get(29));

      /* Empieza nodo:30 / Elemento padre: 29   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(29)).appendChild((Element)v.get(30));

      /* Empieza nodo:31 / Elemento padre: 30   */
      v.add(doc.createElement("td"));
      ((Element)v.get(30)).appendChild((Element)v.get(31));

      /* Empieza nodo:32 / Elemento padre: 31   */
      v.add(doc.createElement("table"));
      ((Element)v.get(32)).setAttribute("width","553" );
      ((Element)v.get(32)).setAttribute("border","0" );
      ((Element)v.get(32)).setAttribute("align","left" );
      ((Element)v.get(32)).setAttribute("cellspacing","0" );
      ((Element)v.get(32)).setAttribute("cellpadding","0" );
      ((Element)v.get(31)).appendChild((Element)v.get(32));

      /* Empieza nodo:33 / Elemento padre: 32   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(32)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("td"));
      ((Element)v.get(34)).setAttribute("colspan","4" );
      ((Element)v.get(33)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(35)).setAttribute("src","b.gif" );
      ((Element)v.get(35)).setAttribute("width","8" );
      ((Element)v.get(35)).setAttribute("height","8" );
      ((Element)v.get(34)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */
      /* Termina nodo:34   */
      /* Termina nodo:33   */

      /* Empieza nodo:36 / Elemento padre: 32   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(32)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("td"));
      ((Element)v.get(36)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(38)).setAttribute("src","b.gif" );
      ((Element)v.get(38)).setAttribute("width","8" );
      ((Element)v.get(38)).setAttribute("height","8" );
      ((Element)v.get(37)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */
      /* Termina nodo:37   */

      /* Empieza nodo:39 / Elemento padre: 36   */
      v.add(doc.createElement("td"));
      ((Element)v.get(36)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(40)).setAttribute("nombre","lblCodActividad" );
      ((Element)v.get(40)).setAttribute("alto","13" );
      ((Element)v.get(40)).setAttribute("filas","1" );
      ((Element)v.get(40)).setAttribute("valor","" );
      ((Element)v.get(40)).setAttribute("id","datosTitle" );
      ((Element)v.get(40)).setAttribute("cod","151" );
      ((Element)v.get(39)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */
      /* Termina nodo:39   */

      /* Empieza nodo:41 / Elemento padre: 36   */
      v.add(doc.createElement("td"));
      ((Element)v.get(36)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(42)).setAttribute("src","b.gif" );
      ((Element)v.get(42)).setAttribute("width","25" );
      ((Element)v.get(42)).setAttribute("height","8" );
      ((Element)v.get(41)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */
      /* Termina nodo:41   */

      /* Empieza nodo:43 / Elemento padre: 36   */
      v.add(doc.createElement("td"));
      ((Element)v.get(36)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(44)).setAttribute("nombre","lblDescripcion" );
      ((Element)v.get(44)).setAttribute("alto","13" );
      ((Element)v.get(44)).setAttribute("filas","1" );
      ((Element)v.get(44)).setAttribute("valor","" );
      ((Element)v.get(44)).setAttribute("id","datosTitle" );
      ((Element)v.get(44)).setAttribute("cod","9" );
      ((Element)v.get(43)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */
      /* Termina nodo:43   */

      /* Empieza nodo:45 / Elemento padre: 36   */
      v.add(doc.createElement("td"));
      ((Element)v.get(45)).setAttribute("width","100%" );
      ((Element)v.get(36)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(46)).setAttribute("src","b.gif" );
      ((Element)v.get(46)).setAttribute("width","8" );
      ((Element)v.get(46)).setAttribute("height","8" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(45)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */
      /* Termina nodo:45   */
      /* Termina nodo:36   */

      /* Empieza nodo:47 / Elemento padre: 32   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(32)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("td"));
      ((Element)v.get(47)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(49)).setAttribute("src","b.gif" );
      ((Element)v.get(49)).setAttribute("width","8" );
      ((Element)v.get(49)).setAttribute("height","8" );
      ((Element)v.get(48)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */
      /* Termina nodo:48   */

      /* Empieza nodo:50 / Elemento padre: 47   */
      v.add(doc.createElement("td"));
      ((Element)v.get(50)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(47)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(51)).setAttribute("nombre","txtCodActividad" );
      ((Element)v.get(51)).setAttribute("id","datosCampos" );
      ((Element)v.get(51)).setAttribute("max","6" );
      ((Element)v.get(51)).setAttribute("tipo","" );
      ((Element)v.get(51)).setAttribute("onchange","" );
      ((Element)v.get(51)).setAttribute("req","N" );
      ((Element)v.get(51)).setAttribute("size","8" );
      ((Element)v.get(51)).setAttribute("valor","" );
      ((Element)v.get(51)).setAttribute("validacion","" );
      ((Element)v.get(51)).setAttribute("ontab","tab('txtCodActividad')" );
      ((Element)v.get(51)).setAttribute("onshtab","shtab('txtCodActividad')" );
      ((Element)v.get(50)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */
      /* Termina nodo:50   */

      /* Empieza nodo:52 / Elemento padre: 47   */
      v.add(doc.createElement("td"));
      ((Element)v.get(47)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(53)).setAttribute("src","b.gif" );
      ((Element)v.get(53)).setAttribute("width","25" );
      ((Element)v.get(53)).setAttribute("height","8" );
      ((Element)v.get(52)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */
      /* Termina nodo:52   */

      /* Empieza nodo:54 / Elemento padre: 47   */
      v.add(doc.createElement("td"));
      ((Element)v.get(54)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(47)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(55)).setAttribute("nombre","txtDescripcion" );
      ((Element)v.get(55)).setAttribute("id","datosCampos" );
      ((Element)v.get(55)).setAttribute("max","40" );
      ((Element)v.get(55)).setAttribute("tipo","" );
      ((Element)v.get(55)).setAttribute("onchange","" );
      ((Element)v.get(55)).setAttribute("req","N" );
      ((Element)v.get(55)).setAttribute("size","40" );
      ((Element)v.get(55)).setAttribute("valor","" );
      ((Element)v.get(55)).setAttribute("validacion","" );
      ((Element)v.get(55)).setAttribute("ontab","tab('txtDescripcion')" );
      ((Element)v.get(55)).setAttribute("onshtab","shtab('txtDescripcion')" );
      ((Element)v.get(54)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */
      /* Termina nodo:54   */

      /* Empieza nodo:56 / Elemento padre: 47   */
      v.add(doc.createElement("td"));
      ((Element)v.get(56)).setAttribute("width","100%" );
      ((Element)v.get(47)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(57)).setAttribute("src","b.gif" );
      ((Element)v.get(57)).setAttribute("width","8" );
      ((Element)v.get(57)).setAttribute("height","8" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */
      /* Termina nodo:56   */
      /* Termina nodo:47   */

      /* Empieza nodo:58 / Elemento padre: 32   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(32)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("td"));
      ((Element)v.get(59)).setAttribute("colspan","4" );
      ((Element)v.get(58)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(60)).setAttribute("src","b.gif" );
      ((Element)v.get(60)).setAttribute("width","8" );
      ((Element)v.get(60)).setAttribute("height","8" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */
      /* Termina nodo:59   */
      /* Termina nodo:58   */
      /* Termina nodo:32   */
      /* Termina nodo:31   */
      /* Termina nodo:30   */

      /* Empieza nodo:61 / Elemento padre: 29   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(29)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("td"));
      ((Element)v.get(61)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("table"));
      ((Element)v.get(63)).setAttribute("width","553" );
      ((Element)v.get(63)).setAttribute("border","0" );
      ((Element)v.get(63)).setAttribute("align","left" );
      ((Element)v.get(63)).setAttribute("cellspacing","0" );
      ((Element)v.get(63)).setAttribute("cellpadding","0" );
      ((Element)v.get(62)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(63)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("td"));
      ((Element)v.get(64)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(66)).setAttribute("src","b.gif" );
      ((Element)v.get(66)).setAttribute("width","8" );
      ((Element)v.get(66)).setAttribute("height","8" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */
      /* Termina nodo:65   */

      /* Empieza nodo:67 / Elemento padre: 64   */
      v.add(doc.createElement("td"));
      ((Element)v.get(64)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("LABELC"));
   }

   private void getXML270(Document doc) {
      ((Element)v.get(68)).setAttribute("nombre","lblMarca" );
      ((Element)v.get(68)).setAttribute("alto","13" );
      ((Element)v.get(68)).setAttribute("filas","1" );
      ((Element)v.get(68)).setAttribute("valor","" );
      ((Element)v.get(68)).setAttribute("id","datosTitle" );
      ((Element)v.get(68)).setAttribute("cod","6" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */
      /* Termina nodo:67   */

      /* Empieza nodo:69 / Elemento padre: 64   */
      v.add(doc.createElement("td"));
      ((Element)v.get(64)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(70)).setAttribute("src","b.gif" );
      ((Element)v.get(70)).setAttribute("width","25" );
      ((Element)v.get(70)).setAttribute("height","8" );
      ((Element)v.get(69)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */
      /* Termina nodo:69   */

      /* Empieza nodo:71 / Elemento padre: 64   */
      v.add(doc.createElement("td"));
      ((Element)v.get(64)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(72)).setAttribute("nombre","lblCanal" );
      ((Element)v.get(72)).setAttribute("alto","13" );
      ((Element)v.get(72)).setAttribute("filas","1" );
      ((Element)v.get(72)).setAttribute("valor","" );
      ((Element)v.get(72)).setAttribute("id","datosTitle" );
      ((Element)v.get(72)).setAttribute("cod","7" );
      ((Element)v.get(71)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */
      /* Termina nodo:71   */

      /* Empieza nodo:73 / Elemento padre: 64   */
      v.add(doc.createElement("td"));
      ((Element)v.get(73)).setAttribute("width","100%" );
      ((Element)v.get(64)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(74)).setAttribute("src","b.gif" );
      ((Element)v.get(74)).setAttribute("width","8" );
      ((Element)v.get(74)).setAttribute("height","8" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */
      /* Termina nodo:73   */
      /* Termina nodo:64   */

      /* Empieza nodo:75 / Elemento padre: 63   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(63)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("td"));
      ((Element)v.get(75)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(77)).setAttribute("src","b.gif" );
      ((Element)v.get(77)).setAttribute("width","8" );
      ((Element)v.get(77)).setAttribute("height","8" );
      ((Element)v.get(76)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */
      /* Termina nodo:76   */

      /* Empieza nodo:78 / Elemento padre: 75   */
      v.add(doc.createElement("td"));
      ((Element)v.get(78)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(75)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(79)).setAttribute("nombre","cbMarca" );
      ((Element)v.get(79)).setAttribute("id","datosCampos" );
      ((Element)v.get(79)).setAttribute("size","1" );
      ((Element)v.get(79)).setAttribute("multiple","N" );
      ((Element)v.get(79)).setAttribute("req","N" );
      ((Element)v.get(79)).setAttribute("valorinicial","" );
      ((Element)v.get(79)).setAttribute("textoinicial","" );
      ((Element)v.get(79)).setAttribute("ontab","tab('cbMarca')" );
      ((Element)v.get(79)).setAttribute("onshtab","shtab('cbMarca')" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(79)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */
      /* Termina nodo:79   */
      /* Termina nodo:78   */

      /* Empieza nodo:81 / Elemento padre: 75   */
      v.add(doc.createElement("td"));
      ((Element)v.get(75)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(82)).setAttribute("src","b.gif" );
      ((Element)v.get(82)).setAttribute("width","25" );
      ((Element)v.get(82)).setAttribute("height","8" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */
      /* Termina nodo:81   */

      /* Empieza nodo:83 / Elemento padre: 75   */
      v.add(doc.createElement("td"));
      ((Element)v.get(83)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(75)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(84)).setAttribute("nombre","cbCanal" );
      ((Element)v.get(84)).setAttribute("id","datosCampos" );
      ((Element)v.get(84)).setAttribute("size","1" );
      ((Element)v.get(84)).setAttribute("multiple","N" );
      ((Element)v.get(84)).setAttribute("req","N" );
      ((Element)v.get(84)).setAttribute("valorinicial","" );
      ((Element)v.get(84)).setAttribute("textoinicial","" );
      ((Element)v.get(84)).setAttribute("ontab","tab('cbCanal')" );
      ((Element)v.get(84)).setAttribute("onshtab","shtab('cbCanal')" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(84)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */
      /* Termina nodo:84   */
      /* Termina nodo:83   */

      /* Empieza nodo:86 / Elemento padre: 75   */
      v.add(doc.createElement("td"));
      ((Element)v.get(86)).setAttribute("width","100%" );
      ((Element)v.get(75)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(87)).setAttribute("src","b.gif" );
      ((Element)v.get(87)).setAttribute("width","8" );
      ((Element)v.get(87)).setAttribute("height","8" );
      ((Element)v.get(86)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */
      /* Termina nodo:86   */
      /* Termina nodo:75   */

      /* Empieza nodo:88 / Elemento padre: 63   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(63)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
   }

   private void getXML360(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(89)).setAttribute("colspan","4" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(90)).setAttribute("src","b.gif" );
      ((Element)v.get(90)).setAttribute("width","8" );
      ((Element)v.get(90)).setAttribute("height","8" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */
      /* Termina nodo:89   */
      /* Termina nodo:88   */
      /* Termina nodo:63   */
      /* Termina nodo:62   */
      /* Termina nodo:61   */
      /* Termina nodo:29   */
      /* Termina nodo:26   */
      /* Termina nodo:25   */

      /* Empieza nodo:91 / Elemento padre: 22   */
      v.add(doc.createElement("td"));
      ((Element)v.get(22)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(92)).setAttribute("src","b.gif" );
      ((Element)v.get(91)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */
      /* Termina nodo:91   */
      /* Termina nodo:22   */

      /* Empieza nodo:93 / Elemento padre: 14   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(14)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("td"));
      ((Element)v.get(93)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(95)).setAttribute("src","b.gif" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */
      /* Termina nodo:94   */

      /* Empieza nodo:96 / Elemento padre: 93   */
      v.add(doc.createElement("td"));
      ((Element)v.get(93)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(96)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("table"));
      ((Element)v.get(98)).setAttribute("width","100%" );
      ((Element)v.get(98)).setAttribute("border","0" );
      ((Element)v.get(98)).setAttribute("align","center" );
      ((Element)v.get(98)).setAttribute("cellspacing","0" );
      ((Element)v.get(98)).setAttribute("cellpadding","0" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(98)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("td"));
      ((Element)v.get(100)).setAttribute("class","botonera" );
      ((Element)v.get(99)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(101)).setAttribute("nombre","btnBuscar" );
      ((Element)v.get(101)).setAttribute("ID","botonContenido" );
      ((Element)v.get(101)).setAttribute("tipo","html" );
      ((Element)v.get(101)).setAttribute("estado","false" );
      ((Element)v.get(101)).setAttribute("cod","1" );
      ((Element)v.get(101)).setAttribute("accion","buscar()" );
      ((Element)v.get(101)).setAttribute("ontab","tab('btnBuscar')" );
      ((Element)v.get(101)).setAttribute("onshtab","shtab('btnBuscar')" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */
      /* Termina nodo:100   */
      /* Termina nodo:99   */
      /* Termina nodo:98   */
      /* Termina nodo:97   */
      /* Termina nodo:96   */

      /* Empieza nodo:102 / Elemento padre: 93   */
      v.add(doc.createElement("td"));
      ((Element)v.get(93)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(103)).setAttribute("src","b.gif" );
      ((Element)v.get(103)).setAttribute("width","8" );
      ((Element)v.get(103)).setAttribute("height","12" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */
      /* Termina nodo:102   */
      /* Termina nodo:93   */

      /* Empieza nodo:104 / Elemento padre: 14   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(14)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("td"));
      ((Element)v.get(105)).setAttribute("width","12" );
      ((Element)v.get(105)).setAttribute("align","center" );
      ((Element)v.get(104)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(106)).setAttribute("src","b.gif" );
      ((Element)v.get(106)).setAttribute("width","12" );
      ((Element)v.get(106)).setAttribute("height","12" );
      ((Element)v.get(105)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */
      /* Termina nodo:105   */

      /* Empieza nodo:107 / Elemento padre: 104   */
      v.add(doc.createElement("td"));
      ((Element)v.get(107)).setAttribute("width","756" );
      ((Element)v.get(104)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(108)).setAttribute("src","b.gif" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */
      /* Termina nodo:107   */

      /* Empieza nodo:109 / Elemento padre: 104   */
      v.add(doc.createElement("td"));
      ((Element)v.get(109)).setAttribute("width","12" );
      ((Element)v.get(104)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(110)).setAttribute("src","b.gif" );
      ((Element)v.get(110)).setAttribute("width","12" );
      ((Element)v.get(110)).setAttribute("height","1" );
      ((Element)v.get(109)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */
      /* Termina nodo:109   */
      /* Termina nodo:104   */
      /* Termina nodo:14   */

      /* Empieza nodo:111 / Elemento padre: 8   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(111)).setAttribute("nombre","listado1" );
      ((Element)v.get(111)).setAttribute("ancho","557" );
      ((Element)v.get(111)).setAttribute("alto","317" );
      ((Element)v.get(111)).setAttribute("x","12" );
      ((Element)v.get(111)).setAttribute("y","163" );
      ((Element)v.get(111)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(111)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(8)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(112)).setAttribute("precarga","S" );
      ((Element)v.get(112)).setAttribute("conROver","S" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(111)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(113)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(113)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(113)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(113)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));
      /* Termina nodo:113   */

      /* Empieza nodo:114 / Elemento padre: 112   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(114)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(114)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(114)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(114)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(112)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */

      /* Empieza nodo:115 / Elemento padre: 112   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(115)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(115)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(112)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */
      /* Termina nodo:112   */

      /* Empieza nodo:116 / Elemento padre: 111   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(111)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(117)).setAttribute("borde","1" );
      ((Element)v.get(117)).setAttribute("horizDatos","1" );
      ((Element)v.get(117)).setAttribute("horizCabecera","1" );
      ((Element)v.get(117)).setAttribute("vertical","0" );
      ((Element)v.get(117)).setAttribute("horizTitulo","1" );
      ((Element)v.get(117)).setAttribute("horizBase","1" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */

      /* Empieza nodo:118 / Elemento padre: 116   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(118)).setAttribute("borde","#999999" );
      ((Element)v.get(118)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(118)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(118)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(118)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(118)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(118)).setAttribute("horizBase","#999999" );
      ((Element)v.get(116)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */
      /* Termina nodo:116   */

      /* Empieza nodo:119 / Elemento padre: 111   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(119)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(119)).setAttribute("alto","22" );
      ((Element)v.get(119)).setAttribute("imgFondo","" );
      ((Element)v.get(119)).setAttribute("cod","00135" );
      ((Element)v.get(119)).setAttribute("ID","datosTitle" );
      ((Element)v.get(111)).appendChild((Element)v.get(119));
      /* Termina nodo:119   */

      /* Empieza nodo:120 / Elemento padre: 111   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(120)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(120)).setAttribute("alto","22" );
      ((Element)v.get(120)).setAttribute("imgFondo","" );
      ((Element)v.get(111)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */

      /* Empieza nodo:121 / Elemento padre: 111   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(121)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(121)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(121)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(121)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(121)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(121)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(111)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(122)).setAttribute("ancho","20" );
      ((Element)v.get(122)).setAttribute("minimizable","S" );
      ((Element)v.get(122)).setAttribute("minimizada","N" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */

      /* Empieza nodo:123 / Elemento padre: 121   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(123)).setAttribute("ancho","20" );
      ((Element)v.get(123)).setAttribute("minimizable","S" );
      ((Element)v.get(123)).setAttribute("minimizada","N" );
      ((Element)v.get(123)).setAttribute("orden","alfanumerico" );
      ((Element)v.get(121)).appendChild((Element)v.get(123));
      /* Termina nodo:123   */

      /* Empieza nodo:124 / Elemento padre: 121   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(124)).setAttribute("ancho","20" );
      ((Element)v.get(124)).setAttribute("minimizable","S" );
      ((Element)v.get(124)).setAttribute("minimizada","N" );
      ((Element)v.get(121)).appendChild((Element)v.get(124));
      /* Termina nodo:124   */

      /* Empieza nodo:125 / Elemento padre: 121   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(125)).setAttribute("ancho","20" );
      ((Element)v.get(125)).setAttribute("minimizable","S" );
      ((Element)v.get(125)).setAttribute("minimizada","N" );
      ((Element)v.get(121)).appendChild((Element)v.get(125));
      /* Termina nodo:125   */
      /* Termina nodo:121   */

      /* Empieza nodo:126 / Elemento padre: 111   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(126)).setAttribute("alto","20" );
      ((Element)v.get(126)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(126)).setAttribute("imgFondo","" );
      ((Element)v.get(126)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(111)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(127)).setAttribute("colFondo","" );
      ((Element)v.get(127)).setAttribute("ID","EstCab" );
      ((Element)v.get(127)).setAttribute("align","center" );
      ((Element)v.get(127)).setAttribute("cod","151" );
      ((Element)v.get(126)).appendChild((Element)v.get(127));

      /* Elemento padre:127 / Elemento actual: 128   */
      v.add(doc.createTextNode("Cód. actividad"));
   }

   private void getXML540(Document doc) {
      ((Element)v.get(127)).appendChild((Text)v.get(128));

      /* Termina nodo Texto:128   */
      /* Termina nodo:127   */

      /* Empieza nodo:129 / Elemento padre: 126   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(129)).setAttribute("colFondo","" );
      ((Element)v.get(129)).setAttribute("ID","EstCab" );
      ((Element)v.get(129)).setAttribute("cod","9" );
      ((Element)v.get(126)).appendChild((Element)v.get(129));

      /* Elemento padre:129 / Elemento actual: 130   */
      v.add(doc.createTextNode("Descripción"));
      ((Element)v.get(129)).appendChild((Text)v.get(130));

      /* Termina nodo Texto:130   */
      /* Termina nodo:129   */

      /* Empieza nodo:131 / Elemento padre: 126   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(131)).setAttribute("colFondo","" );
      ((Element)v.get(131)).setAttribute("ID","EstCab" );
      ((Element)v.get(131)).setAttribute("cod","6" );
      ((Element)v.get(126)).appendChild((Element)v.get(131));

      /* Elemento padre:131 / Elemento actual: 132   */
      v.add(doc.createTextNode("Marca"));
      ((Element)v.get(131)).appendChild((Text)v.get(132));

      /* Termina nodo Texto:132   */
      /* Termina nodo:131   */

      /* Empieza nodo:133 / Elemento padre: 126   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(133)).setAttribute("colFondo","" );
      ((Element)v.get(133)).setAttribute("ID","EstCab" );
      ((Element)v.get(133)).setAttribute("cod","7" );
      ((Element)v.get(126)).appendChild((Element)v.get(133));

      /* Elemento padre:133 / Elemento actual: 134   */
      v.add(doc.createTextNode("Canal"));
      ((Element)v.get(133)).appendChild((Text)v.get(134));

      /* Termina nodo Texto:134   */
      /* Termina nodo:133   */
      /* Termina nodo:126   */

      /* Empieza nodo:135 / Elemento padre: 111   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(135)).setAttribute("alto","22" );
      ((Element)v.get(135)).setAttribute("accion","" );
      ((Element)v.get(135)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(135)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(135)).setAttribute("maxSel","-1" );
      ((Element)v.get(135)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(135)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(135)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(135)).setAttribute("onLoad","" );
      ((Element)v.get(135)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(111)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(136)).setAttribute("tipo","texto" );
      ((Element)v.get(136)).setAttribute("ID","EstDat" );
      ((Element)v.get(135)).appendChild((Element)v.get(136));
      /* Termina nodo:136   */

      /* Empieza nodo:137 / Elemento padre: 135   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(137)).setAttribute("tipo","texto" );
      ((Element)v.get(137)).setAttribute("ID","EstDat2" );
      ((Element)v.get(135)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */

      /* Empieza nodo:138 / Elemento padre: 135   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(138)).setAttribute("tipo","texto" );
      ((Element)v.get(138)).setAttribute("ID","EstDat" );
      ((Element)v.get(135)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */

      /* Empieza nodo:139 / Elemento padre: 135   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(139)).setAttribute("tipo","texto" );
      ((Element)v.get(139)).setAttribute("ID","EstDat2" );
      ((Element)v.get(135)).appendChild((Element)v.get(139));
      /* Termina nodo:139   */
      /* Termina nodo:135   */

      /* Empieza nodo:140 / Elemento padre: 111   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(111)).appendChild((Element)v.get(140));
      /* Termina nodo:140   */

      /* Empieza nodo:141 / Elemento padre: 111   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(141)).setAttribute("nombre","mipgndo1" );
      ((Element)v.get(141)).setAttribute("ancho","726" );
      ((Element)v.get(141)).setAttribute("sep","$" );
      ((Element)v.get(141)).setAttribute("x","12" );
      ((Element)v.get(141)).setAttribute("class","botonera" );
      ((Element)v.get(141)).setAttribute("y","457" );
      ((Element)v.get(141)).setAttribute("control","|" );
      ((Element)v.get(141)).setAttribute("conector","conectorSandra" );
      ((Element)v.get(141)).setAttribute("rowset","" );
      ((Element)v.get(141)).setAttribute("cargainicial","N" );
      ((Element)v.get(141)).setAttribute("onload","procesarPaginado(mipgndo1, msgError, ultima, rowset, 'muestraLista(ultima, rowset)')" );
      ((Element)v.get(111)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(142)).setAttribute("nombre","ret1" );
      ((Element)v.get(142)).setAttribute("x","37" );
      ((Element)v.get(142)).setAttribute("y","461" );
      ((Element)v.get(142)).setAttribute("ID","botonContenido" );
      ((Element)v.get(142)).setAttribute("img","retroceder_on" );
      ((Element)v.get(142)).setAttribute("tipo","0" );
      ((Element)v.get(142)).setAttribute("estado","false" );
      ((Element)v.get(142)).setAttribute("alt","" );
      ((Element)v.get(142)).setAttribute("codigo","" );
      ((Element)v.get(142)).setAttribute("accion","mipgndo1.retroceder();" );
      ((Element)v.get(141)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */

      /* Empieza nodo:143 / Elemento padre: 141   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(143)).setAttribute("nombre","ava1" );
      ((Element)v.get(143)).setAttribute("x","52" );
      ((Element)v.get(143)).setAttribute("y","461" );
      ((Element)v.get(143)).setAttribute("ID","botonContenido" );
      ((Element)v.get(143)).setAttribute("img","avanzar_on" );
      ((Element)v.get(143)).setAttribute("tipo","0" );
      ((Element)v.get(143)).setAttribute("estado","false" );
      ((Element)v.get(143)).setAttribute("alt","" );
      ((Element)v.get(143)).setAttribute("codigo","" );
      ((Element)v.get(143)).setAttribute("accion","mipgndo1.avanzar();" );
      ((Element)v.get(141)).appendChild((Element)v.get(143));
      /* Termina nodo:143   */
      /* Termina nodo:141   */
      /* Termina nodo:111   */

      /* Empieza nodo:144 / Elemento padre: 8   */
      v.add(doc.createElement("BOTON"));
   }

   private void getXML630(Document doc) {
      ((Element)v.get(144)).setAttribute("nombre","primera1" );
      ((Element)v.get(144)).setAttribute("x","20" );
      ((Element)v.get(144)).setAttribute("y","461" );
      ((Element)v.get(144)).setAttribute("ID","botonContenido" );
      ((Element)v.get(144)).setAttribute("img","primera_on" );
      ((Element)v.get(144)).setAttribute("tipo","-2" );
      ((Element)v.get(144)).setAttribute("estado","false" );
      ((Element)v.get(144)).setAttribute("alt","" );
      ((Element)v.get(144)).setAttribute("codigo","" );
      ((Element)v.get(144)).setAttribute("accion","mipgndo1.retrocederPrimeraPagina();" );
      ((Element)v.get(8)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */

      /* Empieza nodo:145 / Elemento padre: 8   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(145)).setAttribute("nombre","separa" );
      ((Element)v.get(145)).setAttribute("x","59" );
      ((Element)v.get(145)).setAttribute("y","457" );
      ((Element)v.get(145)).setAttribute("ID","botonContenido" );
      ((Element)v.get(145)).setAttribute("img","separa_base" );
      ((Element)v.get(145)).setAttribute("tipo","0" );
      ((Element)v.get(145)).setAttribute("estado","false" );
      ((Element)v.get(145)).setAttribute("alt","" );
      ((Element)v.get(145)).setAttribute("codigo","" );
      ((Element)v.get(145)).setAttribute("accion","" );
      ((Element)v.get(8)).appendChild((Element)v.get(145));
      /* Termina nodo:145   */

      /* Empieza nodo:146 / Elemento padre: 8   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(146)).setAttribute("nombre","btnDetalle" );
      ((Element)v.get(146)).setAttribute("x","80" );
      ((Element)v.get(146)).setAttribute("y","458" );
      ((Element)v.get(146)).setAttribute("ID","botonContenido" );
      ((Element)v.get(146)).setAttribute("tipo","html" );
      ((Element)v.get(146)).setAttribute("estado","false" );
      ((Element)v.get(146)).setAttribute("cod","3" );
      ((Element)v.get(146)).setAttribute("accion","detalle()" );
      ((Element)v.get(146)).setAttribute("ontab","tab('btnDetalle')" );
      ((Element)v.get(146)).setAttribute("onshtab","shtab('btnDetalle')" );
      ((Element)v.get(8)).appendChild((Element)v.get(146));
      /* Termina nodo:146   */

      /* Empieza nodo:147 / Elemento padre: 8   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(147)).setAttribute("nombre","btnModificar" );
      ((Element)v.get(147)).setAttribute("x","80" );
      ((Element)v.get(147)).setAttribute("y","458" );
      ((Element)v.get(147)).setAttribute("ID","botonContenido" );
      ((Element)v.get(147)).setAttribute("tipo","html" );
      ((Element)v.get(147)).setAttribute("estado","false" );
      ((Element)v.get(147)).setAttribute("cod","2" );
      ((Element)v.get(147)).setAttribute("accion","modificar()" );
      ((Element)v.get(147)).setAttribute("ontab","tab('btnModificar')" );
      ((Element)v.get(147)).setAttribute("onshtab","shtab('btnModificar')" );
      ((Element)v.get(8)).appendChild((Element)v.get(147));
      /* Termina nodo:147   */

      /* Empieza nodo:148 / Elemento padre: 8   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(148)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(148)).setAttribute("alto","12" );
      ((Element)v.get(148)).setAttribute("ancho","100%" );
      ((Element)v.get(148)).setAttribute("colorf","" );
      ((Element)v.get(148)).setAttribute("borde","0" );
      ((Element)v.get(148)).setAttribute("imagenf","" );
      ((Element)v.get(148)).setAttribute("repeat","" );
      ((Element)v.get(148)).setAttribute("padding","" );
      ((Element)v.get(148)).setAttribute("visibilidad","visible" );
      ((Element)v.get(148)).setAttribute("contravsb","" );
      ((Element)v.get(148)).setAttribute("x","0" );
      ((Element)v.get(148)).setAttribute("y","480" );
      ((Element)v.get(148)).setAttribute("zindex","" );
      ((Element)v.get(8)).appendChild((Element)v.get(148));
      /* Termina nodo:148   */
      /* Termina nodo:8   */


   }

}
