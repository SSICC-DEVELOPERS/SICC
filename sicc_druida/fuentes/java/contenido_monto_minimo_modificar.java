
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_monto_minimo_modificar  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("nombre","contenido_monto_minimo_modificar" );
      ((Element)v.get(0)).setAttribute("cod","0616" );
      ((Element)v.get(0)).setAttribute("titulo","Modificar Monto Mínimo" );
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
      v.add(doc.createTextNode("\r          \r	function onLoadPag()   \r	{\r	    fMostrarMensajeError();\r		configurarMenuSecundario('frmFormulario');\r		\r		ocultarLista();\r\r		focaliza(\"frmFormulario.cbTipoSolicitud\");\r\r	}\r\r\r	function mostrarLista(){\r		DrdEnsanchaConMargenDcho('listado1',12);\r    \r		document.all[\"Cplistado1\"].style.visibility='visible';\r		document.all[\"CpLin1listado1\"].style.visibility='visible';\r		document.all[\"CpLin2listado1\"].style.visibility='visible';\r		document.all[\"CpLin3listado1\"].style.visibility='visible';\r		document.all[\"CpLin4listado1\"].style.visibility='visible';\r    \r		document.all[\"separaDiv\"].style.visibility='visible';\r		document.all[\"primera1Div\"].style.visibility='visible';\r		document.all[\"ret1Div\"].style.visibility='visible';\r		document.all[\"ava1Div\"].style.visibility='visible';\r		document.all[\"ModificarDiv\"].style.visibility='hidden';\r		document.all[\"DetalleDiv\"].style.visibility='hidden';\r\r		\r		if( get('frmFormulario.casoDeUso') == 'modifica' )\r			document.all[\"ModificarDiv\"].style.visibility='visible';\r		if( get('frmFormulario.casoDeUso') == 'consulta' || get('frmFormulario.casoDeUso') == 'elimina' )\r			document.all[\"DetalleDiv\"].style.visibility='visible';\r		eval (ON_RSZ);  \r	}\r\r\r	function ocultarLista(){\r		DrdEnsanchaConMargenDcho('listado1',12);\r    \r		document.all[\"Cplistado1\"].style.visibility='hidden';\r		document.all[\"CpLin1listado1\"].style.visibility='hidden';\r		document.all[\"CpLin2listado1\"].style.visibility='hidden';\r		document.all[\"CpLin3listado1\"].style.visibility='hidden';\r		document.all[\"CpLin4listado1\"].style.visibility='hidden';\r    \r		document.all[\"separaDiv\"].style.visibility='hidden';\r		document.all[\"primera1Div\"].style.visibility='hidden';\r		document.all[\"ret1Div\"].style.visibility='hidden';\r		document.all[\"ava1Div\"].style.visibility='hidden';\r		document.all[\"ModificarDiv\"].style.visibility='hidden';\r		document.all[\"DetalleDiv\"].style.visibility='hidden';\r	}\r\r	 function fLimpiar(){\r		set('frmFormulario.cbTipoSolicitud',new Array(''));\r		focaliza(\"frmFormulario.cbTipoSolicitud\");\r    }\r\r\r\r    function onClickBuscar(){\r\r	    ocultarLista();\r\r		var arr = new Array();\r        arr[arr.length]=new Array('tipoSolicitudPais', get('frmFormulario.cbTipoSolicitud'));\r        arr[arr.length]=new Array('oidIdioma', get('frmFormulario.hIdioma'));\r        arr[arr.length]=new Array('oidPais', get('frmFormulario.hPais'));\r\r        configurarPaginado(mipgndo, \"PEDconsultaMontoMinimo\", \"ConectorBuscarMontoMinimo\", \"es.indra.sicc.dtos.ped.DTOMontoMinimo\", arr);\r    }\r\r\r    function onClickModificar(){\r		var valorSeteado = mipgndo.lista.codSeleccionados();\r\r		if( valorSeteado != '' ){\r			if( valorSeteado.length == 1 ){\r				var obj = new Object();\r				obj.seleccion = valorSeteado[0];\r				obj.accion = 'modificar';\r				obj.casoDeUso = get('frmFormulario.casoDeUso');\r				var retorno = mostrarModalSICC('LPMantieneMontoMinimo', 'modificar', obj, null, null);\r				if( retorno != null && retorno == true ){\r					onClickBuscar();\r				}\r			} else {\r				GestionarMensaje('8',null,null,null);\r			}\r		}else{\r			GestionarMensaje('8', null, null, null);\r		}\r	}\r\r\r    function onClickDetalle(){\r		var valorSeteado = mipgndo.lista.codSeleccionados();\r\r		if( valorSeteado != '' ){\r			if( valorSeteado.length == 1 ){\r				var obj = new Object();\r				obj.seleccion = valorSeteado[0];\r				obj.accion = 'detalle';\r				obj.casoDeUso = get('frmFormulario.casoDeUso');\r				var winModal = mostrarModalSICC('LPMantieneMontoMinimo', 'detalle', obj, null, null);\r			} else {\r				GestionarMensaje('8',null,null,null);\r			}\r		}else{\r			GestionarMensaje('8', null, null, null);\r		}		\r	}\r\r    function fBorrar(){\r        var seleccion = mipgndo.lista.codSeleccionados();\r		if( seleccion != '' ){\r			eliminarFilas(listado1.codSeleccionados(),\"PEDeliminaMontoMinimo\", mipgndo);\r            focaliza('frmFormulario.cbTipoSolicitud');\r		}else{\r			GestionarMensaje('8', null, null, null);\r		}\r    }\r\r\r    function muestraLista(ultima, rowset) {\r\r         var tamano = rowset.length;\r\r         if (tamano > 0) {\r			mostrarLista();\r			if(get('frmFormulario.casoDeUso') == 'elimina'){\r				btnProxy(4, 1);\r				mipgndo.lista.maxSel = -1;\r			}else{\r				btnProxy(4, 0);\r				mipgndo.lista.maxSel = 1;\r			}\r			return true;\r		 } else {\r			ocultarLista();\r			btnProxy(4, 0);\r			return false;\r		 }\r    }\r\r\r	function focalizaTab(){  \r		if(document.all[\"Cplistado1\"].style.visibility=='hidden'){\r			focaliza(\"frmFormulario.cbTipoSolicitud\");\r		}else{\r		    if(get('frmFormulario.casoDeUso') == 'modifica' ){\r				focalizaBotonHTML_XY('Modificar');\r			}else{\r				focalizaBotonHTML_XY('Detalle');\r			}\r		}\r    }\r\r	function focalizaShTab(){  \r		if(document.all[\"Cplistado1\"].style.visibility=='hidden'){\r			focalizaBotonHTML('botonContenido','btnBuscar');\r		}else{\r		    if(get('frmFormulario.casoDeUso') == 'modifica' ){\r				focalizaBotonHTML_XY('Modificar');\r			}else{\r				focalizaBotonHTML_XY('Detalle');\r			}\r\r		}\r    }\r\r\r  \r  "));
      ((Element)v.get(4)).appendChild((Text)v.get(5));

      /* Termina nodo Texto:5   */
      /* Termina nodo:4   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(6)).setAttribute("nombre","frmFormulario" );
      ((Element)v.get(0)).appendChild((Element)v.get(6));

      /* Empieza nodo:7 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(7)).setAttribute("nombre","accion" );
      ((Element)v.get(7)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(8)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(8)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","casoDeUso" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","oid" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","hIdioma" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","hPais" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","hcbTipoSolicitud" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","hcbTipoCliente" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(17)).setAttribute("nombre","capaContenido1" );
      ((Element)v.get(17)).setAttribute("visibilidad","visible" );
      ((Element)v.get(17)).setAttribute("x","0" );
      ((Element)v.get(17)).setAttribute("y","0" );
      ((Element)v.get(6)).appendChild((Element)v.get(17));

      /* Empieza nodo:18 / Elemento padre: 17   */
      v.add(doc.createElement("table"));
      ((Element)v.get(18)).setAttribute("width","100%" );
      ((Element)v.get(18)).setAttribute("border","0" );
      ((Element)v.get(18)).setAttribute("cellspacing","0" );
      ((Element)v.get(18)).setAttribute("cellpadding","0" );
      ((Element)v.get(17)).appendChild((Element)v.get(18));

      /* Empieza nodo:19 / Elemento padre: 18   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(18)).appendChild((Element)v.get(19));

      /* Empieza nodo:20 / Elemento padre: 19   */
      v.add(doc.createElement("td"));
      ((Element)v.get(20)).setAttribute("width","12" );
      ((Element)v.get(20)).setAttribute("align","center" );
      ((Element)v.get(19)).appendChild((Element)v.get(20));

      /* Empieza nodo:21 / Elemento padre: 20   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(21)).setAttribute("src","b.gif" );
      ((Element)v.get(21)).setAttribute("width","12" );
      ((Element)v.get(21)).setAttribute("height","12" );
      ((Element)v.get(20)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */
      /* Termina nodo:20   */

      /* Empieza nodo:22 / Elemento padre: 19   */
      v.add(doc.createElement("td"));
   }

   private void getXML90(Document doc) {
      ((Element)v.get(22)).setAttribute("width","750" );
      ((Element)v.get(19)).appendChild((Element)v.get(22));

      /* Empieza nodo:23 / Elemento padre: 22   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(23)).setAttribute("src","b.gif" );
      ((Element)v.get(22)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */
      /* Termina nodo:22   */

      /* Empieza nodo:24 / Elemento padre: 19   */
      v.add(doc.createElement("td"));
      ((Element)v.get(24)).setAttribute("width","12" );
      ((Element)v.get(19)).appendChild((Element)v.get(24));

      /* Empieza nodo:25 / Elemento padre: 24   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(25)).setAttribute("src","b.gif" );
      ((Element)v.get(25)).setAttribute("width","12" );
      ((Element)v.get(25)).setAttribute("height","1" );
      ((Element)v.get(24)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */
      /* Termina nodo:24   */
      /* Termina nodo:19   */

      /* Empieza nodo:26 / Elemento padre: 18   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(18)).appendChild((Element)v.get(26));

      /* Empieza nodo:27 / Elemento padre: 26   */
      v.add(doc.createElement("td"));
      ((Element)v.get(26)).appendChild((Element)v.get(27));

      /* Empieza nodo:28 / Elemento padre: 27   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(28)).setAttribute("src","b.gif" );
      ((Element)v.get(27)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */
      /* Termina nodo:27   */

      /* Empieza nodo:29 / Elemento padre: 26   */
      v.add(doc.createElement("td"));
      ((Element)v.get(26)).appendChild((Element)v.get(29));

      /* Empieza nodo:30 / Elemento padre: 29   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(29)).appendChild((Element)v.get(30));

      /* Empieza nodo:31 / Elemento padre: 30   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(31)).setAttribute("class","legend" );
      ((Element)v.get(30)).appendChild((Element)v.get(31));

      /* Empieza nodo:32 / Elemento padre: 31   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(32)).setAttribute("nombre","lblCriteriosBusqueda" );
      ((Element)v.get(32)).setAttribute("alto","13" );
      ((Element)v.get(32)).setAttribute("filas","1" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(32)).setAttribute("id","legend" );
      ((Element)v.get(32)).setAttribute("cod","0075" );
      ((Element)v.get(31)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */
      /* Termina nodo:31   */

      /* Empieza nodo:33 / Elemento padre: 30   */
      v.add(doc.createElement("table"));
      ((Element)v.get(33)).setAttribute("width","100%" );
      ((Element)v.get(33)).setAttribute("border","0" );
      ((Element)v.get(33)).setAttribute("align","center" );
      ((Element)v.get(33)).setAttribute("cellspacing","0" );
      ((Element)v.get(33)).setAttribute("cellpadding","0" );
      ((Element)v.get(30)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(33)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("td"));
      ((Element)v.get(34)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("table"));
      ((Element)v.get(36)).setAttribute("width","450" );
      ((Element)v.get(36)).setAttribute("border","0" );
      ((Element)v.get(36)).setAttribute("align","left" );
      ((Element)v.get(36)).setAttribute("cellspacing","0" );
      ((Element)v.get(36)).setAttribute("cellpadding","0" );
      ((Element)v.get(35)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(36)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("td"));
      ((Element)v.get(38)).setAttribute("colspan","3" );
      ((Element)v.get(37)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(39)).setAttribute("src","b.gif" );
      ((Element)v.get(39)).setAttribute("width","8" );
      ((Element)v.get(39)).setAttribute("height","8" );
      ((Element)v.get(38)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */
      /* Termina nodo:38   */
      /* Termina nodo:37   */

      /* Empieza nodo:40 / Elemento padre: 36   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(36)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("td"));
      ((Element)v.get(40)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(42)).setAttribute("src","b.gif" );
      ((Element)v.get(42)).setAttribute("width","8" );
      ((Element)v.get(42)).setAttribute("height","8" );
      ((Element)v.get(41)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */
      /* Termina nodo:41   */

      /* Empieza nodo:43 / Elemento padre: 40   */
      v.add(doc.createElement("td"));
      ((Element)v.get(40)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(44)).setAttribute("nombre","lblTipoSolicitud" );
      ((Element)v.get(44)).setAttribute("alto","13" );
      ((Element)v.get(44)).setAttribute("filas","1" );
      ((Element)v.get(44)).setAttribute("valor","" );
      ((Element)v.get(44)).setAttribute("id","datosTitle" );
      ((Element)v.get(44)).setAttribute("cod","415" );
      ((Element)v.get(43)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */
      /* Termina nodo:43   */

      /* Empieza nodo:45 / Elemento padre: 40   */
      v.add(doc.createElement("td"));
      ((Element)v.get(45)).setAttribute("width","100%" );
      ((Element)v.get(40)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(46)).setAttribute("src","b.gif" );
      ((Element)v.get(46)).setAttribute("width","8" );
      ((Element)v.get(46)).setAttribute("height","8" );
      ((Element)v.get(45)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */
      /* Termina nodo:45   */
      /* Termina nodo:40   */

      /* Empieza nodo:47 / Elemento padre: 36   */
   }

   private void getXML180(Document doc) {
      v.add(doc.createElement("tr"));
      ((Element)v.get(36)).appendChild((Element)v.get(47));

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
      ((Element)v.get(47)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(51)).setAttribute("nombre","cbTipoSolicitud" );
      ((Element)v.get(51)).setAttribute("id","datosCampos" );
      ((Element)v.get(51)).setAttribute("size","1" );
      ((Element)v.get(51)).setAttribute("multiple","N" );
      ((Element)v.get(51)).setAttribute("req","N" );
      ((Element)v.get(51)).setAttribute("valorinicial","" );
      ((Element)v.get(51)).setAttribute("textoinicial","" );
      ((Element)v.get(51)).setAttribute("onshtab","focalizaShTab();" );
      ((Element)v.get(50)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(51)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */
      /* Termina nodo:51   */
      /* Termina nodo:50   */

      /* Empieza nodo:53 / Elemento padre: 47   */
      v.add(doc.createElement("td"));
      ((Element)v.get(53)).setAttribute("width","100%" );
      ((Element)v.get(47)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(54)).setAttribute("src","b.gif" );
      ((Element)v.get(54)).setAttribute("width","8" );
      ((Element)v.get(54)).setAttribute("height","8" );
      ((Element)v.get(53)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */
      /* Termina nodo:53   */
      /* Termina nodo:47   */

      /* Empieza nodo:55 / Elemento padre: 36   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(36)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(56)).setAttribute("colspan","3" );
      ((Element)v.get(55)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(57)).setAttribute("src","b.gif" );
      ((Element)v.get(57)).setAttribute("width","8" );
      ((Element)v.get(57)).setAttribute("height","8" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */
      /* Termina nodo:56   */
      /* Termina nodo:55   */
      /* Termina nodo:36   */
      /* Termina nodo:35   */
      /* Termina nodo:34   */
      /* Termina nodo:33   */
      /* Termina nodo:30   */
      /* Termina nodo:29   */

      /* Empieza nodo:58 / Elemento padre: 26   */
      v.add(doc.createElement("td"));
      ((Element)v.get(26)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(59)).setAttribute("src","b.gif" );
      ((Element)v.get(58)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */
      /* Termina nodo:58   */
      /* Termina nodo:26   */

      /* Empieza nodo:60 / Elemento padre: 18   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(18)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("td"));
      ((Element)v.get(60)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(62)).setAttribute("src","b.gif" );
      ((Element)v.get(61)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */
      /* Termina nodo:61   */

      /* Empieza nodo:63 / Elemento padre: 60   */
      v.add(doc.createElement("td"));
      ((Element)v.get(60)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(63)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("table"));
      ((Element)v.get(65)).setAttribute("width","100%" );
      ((Element)v.get(65)).setAttribute("border","0" );
      ((Element)v.get(65)).setAttribute("align","center" );
      ((Element)v.get(65)).setAttribute("cellspacing","0" );
      ((Element)v.get(65)).setAttribute("cellpadding","0" );
      ((Element)v.get(64)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(65)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("td"));
      ((Element)v.get(67)).setAttribute("class","botonera" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(68)).setAttribute("nombre","btnBuscar" );
      ((Element)v.get(68)).setAttribute("ID","botonContenido" );
      ((Element)v.get(68)).setAttribute("tipo","html" );
      ((Element)v.get(68)).setAttribute("accion","onClickBuscar();" );
      ((Element)v.get(68)).setAttribute("estado","false" );
      ((Element)v.get(68)).setAttribute("cod","1" );
      ((Element)v.get(68)).setAttribute("ontab","focalizaTab();" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */
      /* Termina nodo:67   */
      /* Termina nodo:66   */
      /* Termina nodo:65   */
      /* Termina nodo:64   */
      /* Termina nodo:63   */

      /* Empieza nodo:69 / Elemento padre: 60   */
      v.add(doc.createElement("td"));
      ((Element)v.get(60)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(70)).setAttribute("src","b.gif" );
      ((Element)v.get(70)).setAttribute("width","8" );
      ((Element)v.get(70)).setAttribute("height","12" );
      ((Element)v.get(69)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */
      /* Termina nodo:69   */
      /* Termina nodo:60   */

      /* Empieza nodo:71 / Elemento padre: 18   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(18)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("td"));
      ((Element)v.get(72)).setAttribute("width","12" );
      ((Element)v.get(72)).setAttribute("align","center" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(71)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(73)).setAttribute("src","b.gif" );
      ((Element)v.get(73)).setAttribute("width","12" );
      ((Element)v.get(73)).setAttribute("height","12" );
      ((Element)v.get(72)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */
      /* Termina nodo:72   */

      /* Empieza nodo:74 / Elemento padre: 71   */
      v.add(doc.createElement("td"));
      ((Element)v.get(74)).setAttribute("width","756" );
      ((Element)v.get(71)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(75)).setAttribute("src","b.gif" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */
      /* Termina nodo:74   */

      /* Empieza nodo:76 / Elemento padre: 71   */
      v.add(doc.createElement("td"));
      ((Element)v.get(76)).setAttribute("width","12" );
      ((Element)v.get(71)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(77)).setAttribute("src","b.gif" );
      ((Element)v.get(77)).setAttribute("width","12" );
      ((Element)v.get(77)).setAttribute("height","1" );
      ((Element)v.get(76)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */
      /* Termina nodo:76   */
      /* Termina nodo:71   */
      /* Termina nodo:18   */
      /* Termina nodo:17   */

      /* Empieza nodo:78 / Elemento padre: 6   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(78)).setAttribute("nombre","listado1" );
      ((Element)v.get(78)).setAttribute("ancho","453" );
      ((Element)v.get(78)).setAttribute("alto","317" );
      ((Element)v.get(78)).setAttribute("x","12" );
      ((Element)v.get(78)).setAttribute("y","123" );
      ((Element)v.get(78)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(78)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(6)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(79)).setAttribute("precarga","S" );
      ((Element)v.get(79)).setAttribute("conROver","S" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(80)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(80)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(80)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(80)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(79)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */

      /* Empieza nodo:81 / Elemento padre: 79   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(81)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(81)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(81)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(81)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(79)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */

      /* Empieza nodo:82 / Elemento padre: 79   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(82)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(82)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(79)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */
      /* Termina nodo:79   */

      /* Empieza nodo:83 / Elemento padre: 78   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(78)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(84)).setAttribute("borde","1" );
      ((Element)v.get(84)).setAttribute("horizDatos","1" );
      ((Element)v.get(84)).setAttribute("horizCabecera","1" );
      ((Element)v.get(84)).setAttribute("vertical","1" );
      ((Element)v.get(84)).setAttribute("horizTitulo","1" );
      ((Element)v.get(84)).setAttribute("horizBase","1" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */

      /* Empieza nodo:85 / Elemento padre: 83   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(85)).setAttribute("borde","#999999" );
      ((Element)v.get(85)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(85)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(85)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(85)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(85)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(85)).setAttribute("horizBase","#999999" );
      ((Element)v.get(83)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */
      /* Termina nodo:83   */

      /* Empieza nodo:86 / Elemento padre: 78   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(86)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(86)).setAttribute("alto","22" );
      ((Element)v.get(86)).setAttribute("imgFondo","" );
      ((Element)v.get(86)).setAttribute("cod","00135" );
      ((Element)v.get(86)).setAttribute("ID","datosTitle" );
      ((Element)v.get(78)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */

      /* Empieza nodo:87 / Elemento padre: 78   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(87)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(87)).setAttribute("alto","22" );
      ((Element)v.get(87)).setAttribute("imgFondo","" );
      ((Element)v.get(78)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */

      /* Empieza nodo:88 / Elemento padre: 78   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(88)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(88)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(88)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(88)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(88)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(88)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(78)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(89)).setAttribute("ancho","100" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(89)).setAttribute("minimizable","S" );
      ((Element)v.get(89)).setAttribute("minimizada","N" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */

      /* Empieza nodo:90 / Elemento padre: 88   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(90)).setAttribute("ancho","100" );
      ((Element)v.get(90)).setAttribute("minimizable","S" );
      ((Element)v.get(90)).setAttribute("minimizada","N" );
      ((Element)v.get(88)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */

      /* Empieza nodo:91 / Elemento padre: 88   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(91)).setAttribute("ancho","100" );
      ((Element)v.get(91)).setAttribute("minimizable","S" );
      ((Element)v.get(91)).setAttribute("minimizada","N" );
      ((Element)v.get(88)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */

      /* Empieza nodo:92 / Elemento padre: 88   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(92)).setAttribute("ancho","140" );
      ((Element)v.get(92)).setAttribute("minimizable","S" );
      ((Element)v.get(92)).setAttribute("minimizada","N" );
      ((Element)v.get(88)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */

      /* Empieza nodo:93 / Elemento padre: 88   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(93)).setAttribute("ancho","140" );
      ((Element)v.get(93)).setAttribute("minimizable","S" );
      ((Element)v.get(93)).setAttribute("minimizada","N" );
      ((Element)v.get(88)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */

      /* Empieza nodo:94 / Elemento padre: 88   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(94)).setAttribute("ancho","140" );
      ((Element)v.get(94)).setAttribute("minimizable","S" );
      ((Element)v.get(94)).setAttribute("minimizada","N" );
      ((Element)v.get(88)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */

      /* Empieza nodo:95 / Elemento padre: 88   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(95)).setAttribute("ancho","140" );
      ((Element)v.get(95)).setAttribute("minimizable","S" );
      ((Element)v.get(95)).setAttribute("minimizada","N" );
      ((Element)v.get(88)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */

      /* Empieza nodo:96 / Elemento padre: 88   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(96)).setAttribute("ancho","140" );
      ((Element)v.get(96)).setAttribute("minimizable","S" );
      ((Element)v.get(96)).setAttribute("minimizada","N" );
      ((Element)v.get(88)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */

      /* Empieza nodo:97 / Elemento padre: 88   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(97)).setAttribute("ancho","80" );
      ((Element)v.get(97)).setAttribute("minimizable","S" );
      ((Element)v.get(97)).setAttribute("minimizada","N" );
      ((Element)v.get(88)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */

      /* Empieza nodo:98 / Elemento padre: 88   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(98)).setAttribute("ancho","80" );
      ((Element)v.get(98)).setAttribute("minimizable","S" );
      ((Element)v.get(98)).setAttribute("minimizada","N" );
      ((Element)v.get(88)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */

      /* Empieza nodo:99 / Elemento padre: 88   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(99)).setAttribute("ancho","80" );
      ((Element)v.get(99)).setAttribute("minimizable","S" );
      ((Element)v.get(99)).setAttribute("minimizada","N" );
      ((Element)v.get(88)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */

      /* Empieza nodo:100 / Elemento padre: 88   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(100)).setAttribute("ancho","80" );
      ((Element)v.get(100)).setAttribute("minimizable","S" );
      ((Element)v.get(100)).setAttribute("minimizada","N" );
      ((Element)v.get(88)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */
      /* Termina nodo:88   */

      /* Empieza nodo:101 / Elemento padre: 78   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(101)).setAttribute("alto","20" );
      ((Element)v.get(101)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(101)).setAttribute("imgFondo","" );
      ((Element)v.get(101)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(78)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(102)).setAttribute("colFondo","" );
      ((Element)v.get(102)).setAttribute("ID","EstCab" );
      ((Element)v.get(102)).setAttribute("cod","415" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */

      /* Empieza nodo:103 / Elemento padre: 101   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(103)).setAttribute("colFondo","" );
      ((Element)v.get(103)).setAttribute("ID","EstCab" );
      ((Element)v.get(103)).setAttribute("cod","109" );
      ((Element)v.get(101)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */

      /* Empieza nodo:104 / Elemento padre: 101   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(104)).setAttribute("colFondo","" );
      ((Element)v.get(104)).setAttribute("ID","EstCab" );
      ((Element)v.get(104)).setAttribute("cod","143" );
      ((Element)v.get(101)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */

      /* Empieza nodo:105 / Elemento padre: 101   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(105)).setAttribute("colFondo","" );
      ((Element)v.get(105)).setAttribute("ID","EstCab" );
      ((Element)v.get(105)).setAttribute("cod","1869" );
      ((Element)v.get(101)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */

      /* Empieza nodo:106 / Elemento padre: 101   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(106)).setAttribute("colFondo","" );
      ((Element)v.get(106)).setAttribute("ID","EstCab" );
      ((Element)v.get(106)).setAttribute("cod","595" );
      ((Element)v.get(101)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */

      /* Empieza nodo:107 / Elemento padre: 101   */
      v.add(doc.createElement("COL"));
   }

   private void getXML450(Document doc) {
      ((Element)v.get(107)).setAttribute("colFondo","" );
      ((Element)v.get(107)).setAttribute("ID","EstCab" );
      ((Element)v.get(107)).setAttribute("cod","756" );
      ((Element)v.get(101)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */

      /* Empieza nodo:108 / Elemento padre: 101   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(108)).setAttribute("colFondo","" );
      ((Element)v.get(108)).setAttribute("ID","EstCab" );
      ((Element)v.get(108)).setAttribute("cod","550" );
      ((Element)v.get(101)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */

      /* Empieza nodo:109 / Elemento padre: 101   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(109)).setAttribute("colFondo","" );
      ((Element)v.get(109)).setAttribute("ID","EstCab" );
      ((Element)v.get(109)).setAttribute("cod","2174" );
      ((Element)v.get(101)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */

      /* Empieza nodo:110 / Elemento padre: 101   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(110)).setAttribute("colFondo","" );
      ((Element)v.get(110)).setAttribute("ID","EstCab" );
      ((Element)v.get(110)).setAttribute("cod","1097" );
      ((Element)v.get(101)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */

      /* Empieza nodo:111 / Elemento padre: 101   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(111)).setAttribute("colFondo","" );
      ((Element)v.get(111)).setAttribute("ID","EstCab" );
      ((Element)v.get(111)).setAttribute("cod","1098" );
      ((Element)v.get(101)).appendChild((Element)v.get(111));
      /* Termina nodo:111   */

      /* Empieza nodo:112 / Elemento padre: 101   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(112)).setAttribute("colFondo","" );
      ((Element)v.get(112)).setAttribute("ID","EstCab" );
      ((Element)v.get(112)).setAttribute("cod","1099" );
      ((Element)v.get(101)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */

      /* Empieza nodo:113 / Elemento padre: 101   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(113)).setAttribute("colFondo","" );
      ((Element)v.get(113)).setAttribute("ID","EstCab" );
      ((Element)v.get(113)).setAttribute("cod","390" );
      ((Element)v.get(101)).appendChild((Element)v.get(113));
      /* Termina nodo:113   */
      /* Termina nodo:101   */

      /* Empieza nodo:114 / Elemento padre: 78   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(114)).setAttribute("alto","22" );
      ((Element)v.get(114)).setAttribute("accion","" );
      ((Element)v.get(114)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(114)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(114)).setAttribute("maxSel","-1" );
      ((Element)v.get(114)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(114)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(114)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(114)).setAttribute("onLoad","" );
      ((Element)v.get(114)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(78)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(115)).setAttribute("tipo","texto" );
      ((Element)v.get(115)).setAttribute("ID","EstDat" );
      ((Element)v.get(114)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */

      /* Empieza nodo:116 / Elemento padre: 114   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(116)).setAttribute("tipo","texto" );
      ((Element)v.get(116)).setAttribute("ID","EstDat2" );
      ((Element)v.get(114)).appendChild((Element)v.get(116));
      /* Termina nodo:116   */

      /* Empieza nodo:117 / Elemento padre: 114   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(117)).setAttribute("tipo","texto" );
      ((Element)v.get(117)).setAttribute("ID","EstDat" );
      ((Element)v.get(114)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */

      /* Empieza nodo:118 / Elemento padre: 114   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(118)).setAttribute("tipo","texto" );
      ((Element)v.get(118)).setAttribute("ID","EstDat2" );
      ((Element)v.get(114)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */

      /* Empieza nodo:119 / Elemento padre: 114   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(119)).setAttribute("tipo","texto" );
      ((Element)v.get(119)).setAttribute("ID","EstDat" );
      ((Element)v.get(114)).appendChild((Element)v.get(119));
      /* Termina nodo:119   */

      /* Empieza nodo:120 / Elemento padre: 114   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(120)).setAttribute("tipo","texto" );
      ((Element)v.get(120)).setAttribute("ID","EstDat2" );
      ((Element)v.get(114)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */

      /* Empieza nodo:121 / Elemento padre: 114   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(121)).setAttribute("tipo","texto" );
      ((Element)v.get(121)).setAttribute("ID","EstDat" );
      ((Element)v.get(114)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */

      /* Empieza nodo:122 / Elemento padre: 114   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(122)).setAttribute("tipo","texto" );
      ((Element)v.get(122)).setAttribute("ID","EstDat2" );
      ((Element)v.get(114)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */

      /* Empieza nodo:123 / Elemento padre: 114   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(123)).setAttribute("tipo","texto" );
      ((Element)v.get(123)).setAttribute("ID","EstDat" );
      ((Element)v.get(114)).appendChild((Element)v.get(123));
      /* Termina nodo:123   */

      /* Empieza nodo:124 / Elemento padre: 114   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(124)).setAttribute("tipo","texto" );
      ((Element)v.get(124)).setAttribute("ID","EstDat2" );
      ((Element)v.get(114)).appendChild((Element)v.get(124));
      /* Termina nodo:124   */

      /* Empieza nodo:125 / Elemento padre: 114   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(125)).setAttribute("tipo","texto" );
      ((Element)v.get(125)).setAttribute("ID","EstDat" );
      ((Element)v.get(114)).appendChild((Element)v.get(125));
      /* Termina nodo:125   */

      /* Empieza nodo:126 / Elemento padre: 114   */
   }

   private void getXML540(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(126)).setAttribute("tipo","texto" );
      ((Element)v.get(126)).setAttribute("ID","EstDat2" );
      ((Element)v.get(114)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */
      /* Termina nodo:114   */

      /* Empieza nodo:127 / Elemento padre: 78   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(78)).appendChild((Element)v.get(127));
      /* Termina nodo:127   */

      /* Empieza nodo:128 / Elemento padre: 78   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(128)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(128)).setAttribute("ancho","453" );
      ((Element)v.get(128)).setAttribute("sep","$" );
      ((Element)v.get(128)).setAttribute("x","12" );
      ((Element)v.get(128)).setAttribute("class","botonera" );
      ((Element)v.get(128)).setAttribute("y","417" );
      ((Element)v.get(128)).setAttribute("control","|" );
      ((Element)v.get(128)).setAttribute("conector","conector_prototipo_2" );
      ((Element)v.get(128)).setAttribute("rowset","" );
      ((Element)v.get(128)).setAttribute("cargainicial","N" );
      ((Element)v.get(128)).setAttribute("onload","procesarPaginado(mipgndo,msgError,ultima,rowset,'muestraLista(ultima,rowset)');" );
      ((Element)v.get(78)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(129)).setAttribute("nombre","ret1" );
      ((Element)v.get(129)).setAttribute("x","37" );
      ((Element)v.get(129)).setAttribute("y","421" );
      ((Element)v.get(129)).setAttribute("ID","botonContenido" );
      ((Element)v.get(129)).setAttribute("img","retroceder_on" );
      ((Element)v.get(129)).setAttribute("tipo","0" );
      ((Element)v.get(129)).setAttribute("estado","false" );
      ((Element)v.get(129)).setAttribute("alt","" );
      ((Element)v.get(129)).setAttribute("codigo","" );
      ((Element)v.get(129)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(128)).appendChild((Element)v.get(129));
      /* Termina nodo:129   */

      /* Empieza nodo:130 / Elemento padre: 128   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(130)).setAttribute("nombre","ava1" );
      ((Element)v.get(130)).setAttribute("x","52" );
      ((Element)v.get(130)).setAttribute("y","421" );
      ((Element)v.get(130)).setAttribute("ID","botonContenido" );
      ((Element)v.get(130)).setAttribute("img","avanzar_on" );
      ((Element)v.get(130)).setAttribute("tipo","0" );
      ((Element)v.get(130)).setAttribute("estado","false" );
      ((Element)v.get(130)).setAttribute("alt","" );
      ((Element)v.get(130)).setAttribute("codigo","" );
      ((Element)v.get(130)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(128)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */
      /* Termina nodo:128   */
      /* Termina nodo:78   */

      /* Empieza nodo:131 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(131)).setAttribute("nombre","primera1" );
      ((Element)v.get(131)).setAttribute("x","20" );
      ((Element)v.get(131)).setAttribute("y","421" );
      ((Element)v.get(131)).setAttribute("ID","botonContenido" );
      ((Element)v.get(131)).setAttribute("img","primera_on" );
      ((Element)v.get(131)).setAttribute("tipo","-2" );
      ((Element)v.get(131)).setAttribute("estado","false" );
      ((Element)v.get(131)).setAttribute("alt","" );
      ((Element)v.get(131)).setAttribute("codigo","" );
      ((Element)v.get(131)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(6)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */

      /* Empieza nodo:132 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(132)).setAttribute("nombre","separa" );
      ((Element)v.get(132)).setAttribute("x","59" );
      ((Element)v.get(132)).setAttribute("y","417" );
      ((Element)v.get(132)).setAttribute("ID","botonContenido" );
      ((Element)v.get(132)).setAttribute("img","separa_base" );
      ((Element)v.get(132)).setAttribute("tipo","0" );
      ((Element)v.get(132)).setAttribute("estado","false" );
      ((Element)v.get(132)).setAttribute("alt","" );
      ((Element)v.get(132)).setAttribute("codigo","" );
      ((Element)v.get(132)).setAttribute("accion","" );
      ((Element)v.get(6)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */

      /* Empieza nodo:133 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(133)).setAttribute("nombre","Modificar" );
      ((Element)v.get(133)).setAttribute("x","80" );
      ((Element)v.get(133)).setAttribute("y","418" );
      ((Element)v.get(133)).setAttribute("ID","botonContenido" );
      ((Element)v.get(133)).setAttribute("tipo","html" );
      ((Element)v.get(133)).setAttribute("estado","false" );
      ((Element)v.get(133)).setAttribute("cod","2" );
      ((Element)v.get(133)).setAttribute("accion","onClickModificar();" );
      ((Element)v.get(133)).setAttribute("ontab","focaliza('frmFormulario.cbTipoSolicitud');" );
      ((Element)v.get(133)).setAttribute("onshtab","focalizaBotonHTML('botonContenido','btnBuscar');" );
      ((Element)v.get(6)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */

      /* Empieza nodo:134 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(134)).setAttribute("nombre","Detalle" );
      ((Element)v.get(134)).setAttribute("x","80" );
      ((Element)v.get(134)).setAttribute("y","418" );
      ((Element)v.get(134)).setAttribute("ID","botonContenido" );
      ((Element)v.get(134)).setAttribute("tipo","html" );
      ((Element)v.get(134)).setAttribute("estado","false" );
      ((Element)v.get(134)).setAttribute("cod","3" );
      ((Element)v.get(134)).setAttribute("accion","onClickDetalle();" );
      ((Element)v.get(134)).setAttribute("ontab","focaliza('frmFormulario.cbTipoSolicitud');" );
      ((Element)v.get(134)).setAttribute("onshtab","focalizaBotonHTML('botonContenido','btnBuscar');" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(6)).appendChild((Element)v.get(134));
      /* Termina nodo:134   */

      /* Empieza nodo:135 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(135)).setAttribute("nombre","capaEspacio2" );
      ((Element)v.get(135)).setAttribute("alto","18" );
      ((Element)v.get(135)).setAttribute("ancho","100" );
      ((Element)v.get(135)).setAttribute("colorf","" );
      ((Element)v.get(135)).setAttribute("borde","0" );
      ((Element)v.get(135)).setAttribute("imagenf","" );
      ((Element)v.get(135)).setAttribute("repeat","" );
      ((Element)v.get(135)).setAttribute("padding","" );
      ((Element)v.get(135)).setAttribute("visibilidad","visible" );
      ((Element)v.get(135)).setAttribute("contravsb","" );
      ((Element)v.get(135)).setAttribute("x","0" );
      ((Element)v.get(135)).setAttribute("y","440" );
      ((Element)v.get(135)).setAttribute("zindex","" );
      ((Element)v.get(6)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */
      /* Termina nodo:6   */


   }

}
