
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_patron_listar  implements es.indra.druida.base.ObjetoXML {
   private ArrayList v = new ArrayList();

   public Element getXML (Document doc){
      

      getXML0(doc);
         

      getXML90(doc);
         

      getXML180(doc);
         

      getXML270(doc);
         

      getXML360(doc);
         

      getXML450(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_patron_listar" );
      ((Element)v.get(0)).setAttribute("cod","0248" );
      ((Element)v.get(0)).setAttribute("titulo","Crear patrón" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","Crear patrón" );
      ((Element)v.get(0)).setAttribute("onload","onLoadPag();" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(1));

      /* Empieza nodo:2 / Elemento padre: 1   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(2)).setAttribute("name","txtCodPatronNuevo" );
      ((Element)v.get(2)).setAttribute("required","true" );
      ((Element)v.get(2)).setAttribute("cod","2761" );
      ((Element)v.get(1)).appendChild((Element)v.get(2));
      /* Termina nodo:2   */
      /* Termina nodo:1   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(3));

      /* Elemento padre:3 / Elemento actual: 4   */
      v.add(doc.createTextNode("\r   \r\r  function onLoadPag()   {\r	configurarMenuSecundario('frmFormulario');\r	fMostrarMensajeError();\r    DrdEnsanchaConMargenDcho('listado1',12);\r	document.all[\"Cplistado1\"].style.visibility='';\r	document.all[\"CpLin1listado1\"].style.visibility='';\r	document.all[\"CpLin2listado1\"].style.visibility='';\r	document.all[\"CpLin3listado1\"].style.visibility='';\r	document.all[\"CpLin4listado1\"].style.visibility='';\r	document.all[\"primera1Div\"].style.visibility='';\r	document.all[\"ret1Div\"].style.visibility='';\r	document.all[\"ava1Div\"].style.visibility='';\r	document.all[\"separaDiv\"].style.visibility='';\r	document.all[\"CopiarDiv\"].style.visibility='';\r	focaliza('frmFormulario.txtCodPatronNuevo');\r	var arr = new Array();\r	arr[arr.length] = new Array('oidPais', get('frmFormulario.hPais'));\r	arr[arr.length] = new Array('oidIdioma', get('frmFormulario.hIdioma'));\r	configurarPaginado(mipgndo,'MSGBuscarPatrones','ConectorBuscarPatrones','es.indra.sicc.dtos.msg.DTOPatron',arr);	\r    eval(ON_RSZ);\r   }\r\r   function muestraLista(ultima, rowset) {\r        var tamano = rowset.length;\r        if (tamano > 0) {\r			mostrarLista();\r		var i;\r		var index = 5;\r		var si = GestionarMensaje(85);\r		var no = GestionarMensaje(87);\r		\r		for( i = 0; i < rowset.length; i++ ){\r			if(rowset[i][index] == '0')  \r				rowset[i][index] = no;\r			else if(rowset[i][index] == '1')	\r				rowset[i][index] = si;\r			else  rowset[i][index] = '';\r		}\r\r		index = 6;\r		for( i = 0; i < rowset.length; i++ ){\r			if(rowset[i][index] == '0')  \r				rowset[i][index] = no;\r			else if(rowset[i][index] == '1')	\r				rowset[i][index] = si;\r			else  rowset[i][index] = '';\r		}\r		return true;\r		\r        }else{\r			ocultarLista();\r			return false;\r        }\r	}   \r\r	function mostrarLista(){\r		deshabilitarHabilitarBoton('botonContenido','Copiar','A');\r		set('frmFormulario.hListaVisible', 'S');\r	}\r\r	function ocultarLista(){\r		deshabilitarHabilitarBoton('botonContenido','Copiar','D');\r		set('frmFormulario.hListaVisible', 'N');\r	}\r\r\r	function fLimpiar(){\r		focaliza('frmFormulario.txtCodPatronNuevo');\r	}\r\r	function fVolver(){\r\r	}\r\r\r   function accionCopiar(){\r		if(listado1.numSelecc()== 1){\r			if(sicc_validaciones_generales()){\r				set('frmFormulario.accion', 'Copiar patron');\r				set('frmFormulario.hOidPatron', listado1.codSeleccionados());\r				set('frmFormulario.hCodigoPatronNuevo', get('frmFormulario.txtCodPatronNuevo'));\r				enviaSICC(\"frmFormulario\");\r			}\r		} else {\r			GestionarMensaje('4');\r		}\r   }\r\r   function ontab_CodigoNuevo(){\r		var listaVisible = get('frmFormulario.hListaVisible');\r		if (listaVisible == 'N'){\r\r		} else{\r			focalizaBotonHTML('botonContenido', 'Copiar');\r		}\r\r   }\r\r   function ontab_Copiar(){\r		focaliza('frmFormulario.txtCodPatronNuevo');\r   }\r   \r   \r"));
      ((Element)v.get(3)).appendChild((Text)v.get(4));

      /* Termina nodo Texto:4   */
      /* Termina nodo:3   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(5)).setAttribute("src","sicc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(6)).setAttribute("src","PaginacionSicc.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(7)).setAttribute("src","DruidaTransactionMare.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(8)).setAttribute("nombre","frmFormulario" );
      ((Element)v.get(0)).appendChild((Element)v.get(8));

      /* Empieza nodo:9 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","accion" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","casoDeUso" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(11)).setAttribute("valor","LPMantenimientoPatrones" );
      ((Element)v.get(8)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","hPais" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","hIdioma" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","hOidPatron" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","hCodigoPatronNuevo" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","hListaVisible" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 8   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(19)).setAttribute("nombre","capa1" );
      ((Element)v.get(8)).appendChild((Element)v.get(19));

      /* Empieza nodo:20 / Elemento padre: 19   */
      v.add(doc.createElement("table"));
      ((Element)v.get(20)).setAttribute("width","100%" );
      ((Element)v.get(20)).setAttribute("border","0" );
      ((Element)v.get(20)).setAttribute("cellspacing","0" );
      ((Element)v.get(20)).setAttribute("cellpadding","0" );
      ((Element)v.get(19)).appendChild((Element)v.get(20));

      /* Empieza nodo:21 / Elemento padre: 20   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(20)).appendChild((Element)v.get(21));

      /* Empieza nodo:22 / Elemento padre: 21   */
      v.add(doc.createElement("td"));
      ((Element)v.get(22)).setAttribute("width","12" );
      ((Element)v.get(22)).setAttribute("align","center" );
      ((Element)v.get(21)).appendChild((Element)v.get(22));

      /* Empieza nodo:23 / Elemento padre: 22   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(23)).setAttribute("src","b.gif" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(23)).setAttribute("width","12" );
      ((Element)v.get(23)).setAttribute("height","12" );
      ((Element)v.get(22)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */
      /* Termina nodo:22   */

      /* Empieza nodo:24 / Elemento padre: 21   */
      v.add(doc.createElement("td"));
      ((Element)v.get(24)).setAttribute("width","750" );
      ((Element)v.get(21)).appendChild((Element)v.get(24));

      /* Empieza nodo:25 / Elemento padre: 24   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(25)).setAttribute("src","b.gif" );
      ((Element)v.get(24)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */
      /* Termina nodo:24   */

      /* Empieza nodo:26 / Elemento padre: 21   */
      v.add(doc.createElement("td"));
      ((Element)v.get(26)).setAttribute("width","12" );
      ((Element)v.get(21)).appendChild((Element)v.get(26));

      /* Empieza nodo:27 / Elemento padre: 26   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(27)).setAttribute("src","b.gif" );
      ((Element)v.get(27)).setAttribute("width","12" );
      ((Element)v.get(27)).setAttribute("height","1" );
      ((Element)v.get(26)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */
      /* Termina nodo:26   */
      /* Termina nodo:21   */

      /* Empieza nodo:28 / Elemento padre: 20   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(20)).appendChild((Element)v.get(28));

      /* Empieza nodo:29 / Elemento padre: 28   */
      v.add(doc.createElement("td"));
      ((Element)v.get(28)).appendChild((Element)v.get(29));

      /* Empieza nodo:30 / Elemento padre: 29   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(30)).setAttribute("src","b.gif" );
      ((Element)v.get(29)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */
      /* Termina nodo:29   */

      /* Empieza nodo:31 / Elemento padre: 28   */
      v.add(doc.createElement("td"));
      ((Element)v.get(28)).appendChild((Element)v.get(31));

      /* Empieza nodo:32 / Elemento padre: 31   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(31)).appendChild((Element)v.get(32));

      /* Empieza nodo:33 / Elemento padre: 32   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(33)).setAttribute("class","legend" );
      ((Element)v.get(32)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(34)).setAttribute("nombre","DatosPatron" );
      ((Element)v.get(34)).setAttribute("alto","13" );
      ((Element)v.get(34)).setAttribute("filas","1" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(34)).setAttribute("id","legend" );
      ((Element)v.get(34)).setAttribute("cod","00636" );
      ((Element)v.get(33)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */
      /* Termina nodo:33   */

      /* Empieza nodo:35 / Elemento padre: 32   */
      v.add(doc.createElement("table"));
      ((Element)v.get(35)).setAttribute("width","100%" );
      ((Element)v.get(35)).setAttribute("border","0" );
      ((Element)v.get(35)).setAttribute("align","center" );
      ((Element)v.get(35)).setAttribute("cellspacing","0" );
      ((Element)v.get(35)).setAttribute("cellpadding","0" );
      ((Element)v.get(32)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(35)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("td"));
      ((Element)v.get(36)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("table"));
      ((Element)v.get(38)).setAttribute("width","636" );
      ((Element)v.get(38)).setAttribute("border","0" );
      ((Element)v.get(38)).setAttribute("align","left" );
      ((Element)v.get(38)).setAttribute("cellspacing","0" );
      ((Element)v.get(38)).setAttribute("cellpadding","0" );
      ((Element)v.get(37)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(38)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("td"));
      ((Element)v.get(40)).setAttribute("colspan","8" );
      ((Element)v.get(39)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(41)).setAttribute("src","b.gif" );
      ((Element)v.get(41)).setAttribute("width","8" );
      ((Element)v.get(41)).setAttribute("height","8" );
      ((Element)v.get(40)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */
      /* Termina nodo:40   */
      /* Termina nodo:39   */

      /* Empieza nodo:42 / Elemento padre: 38   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(38)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("td"));
      ((Element)v.get(42)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(44)).setAttribute("src","b.gif" );
      ((Element)v.get(44)).setAttribute("width","8" );
      ((Element)v.get(44)).setAttribute("height","8" );
      ((Element)v.get(43)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */
      /* Termina nodo:43   */

      /* Empieza nodo:45 / Elemento padre: 42   */
      v.add(doc.createElement("td"));
      ((Element)v.get(42)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(46)).setAttribute("nombre","lblCodigoPatronNuevo" );
      ((Element)v.get(46)).setAttribute("alto","13" );
      ((Element)v.get(46)).setAttribute("filas","1" );
      ((Element)v.get(46)).setAttribute("valor","" );
      ((Element)v.get(46)).setAttribute("id","datosTitle" );
      ((Element)v.get(46)).setAttribute("cod","2761" );
      ((Element)v.get(45)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */
      /* Termina nodo:45   */

      /* Empieza nodo:47 / Elemento padre: 42   */
      v.add(doc.createElement("td"));
      ((Element)v.get(47)).setAttribute("width","100%" );
      ((Element)v.get(42)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML180(Document doc) {
      ((Element)v.get(48)).setAttribute("src","b.gif" );
      ((Element)v.get(48)).setAttribute("width","8" );
      ((Element)v.get(48)).setAttribute("height","8" );
      ((Element)v.get(47)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */
      /* Termina nodo:47   */
      /* Termina nodo:42   */

      /* Empieza nodo:49 / Elemento padre: 38   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(38)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("td"));
      ((Element)v.get(49)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(51)).setAttribute("src","b.gif" );
      ((Element)v.get(51)).setAttribute("width","8" );
      ((Element)v.get(51)).setAttribute("height","8" );
      ((Element)v.get(50)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */
      /* Termina nodo:50   */

      /* Empieza nodo:52 / Elemento padre: 49   */
      v.add(doc.createElement("td"));
      ((Element)v.get(52)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(49)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(53)).setAttribute("nombre","txtCodPatronNuevo" );
      ((Element)v.get(53)).setAttribute("id","datosCampos" );
      ((Element)v.get(53)).setAttribute("max","4" );
      ((Element)v.get(53)).setAttribute("tipo","" );
      ((Element)v.get(53)).setAttribute("onchange","" );
      ((Element)v.get(53)).setAttribute("req","S" );
      ((Element)v.get(53)).setAttribute("size","4" );
      ((Element)v.get(53)).setAttribute("valor","" );
      ((Element)v.get(53)).setAttribute("validacion","" );
      ((Element)v.get(53)).setAttribute("ontab","ontab_CodigoNuevo();" );
      ((Element)v.get(53)).setAttribute("onshtab","ontab_CodigoNuevo();" );
      ((Element)v.get(52)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */
      /* Termina nodo:52   */

      /* Empieza nodo:54 / Elemento padre: 49   */
      v.add(doc.createElement("td"));
      ((Element)v.get(54)).setAttribute("width","100%" );
      ((Element)v.get(49)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(55)).setAttribute("src","b.gif" );
      ((Element)v.get(55)).setAttribute("width","8" );
      ((Element)v.get(55)).setAttribute("height","8" );
      ((Element)v.get(54)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */
      /* Termina nodo:54   */
      /* Termina nodo:49   */

      /* Empieza nodo:56 / Elemento padre: 38   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(38)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(57)).setAttribute("colspan","9" );
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
      /* Termina nodo:38   */
      /* Termina nodo:37   */
      /* Termina nodo:36   */
      /* Termina nodo:35   */
      /* Termina nodo:32   */
      /* Termina nodo:31   */

      /* Empieza nodo:59 / Elemento padre: 28   */
      v.add(doc.createElement("td"));
      ((Element)v.get(28)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(60)).setAttribute("src","b.gif" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */
      /* Termina nodo:59   */
      /* Termina nodo:28   */

      /* Empieza nodo:61 / Elemento padre: 20   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(20)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("td"));
      ((Element)v.get(62)).setAttribute("width","12" );
      ((Element)v.get(62)).setAttribute("align","center" );
      ((Element)v.get(61)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(63)).setAttribute("src","b.gif" );
      ((Element)v.get(63)).setAttribute("width","12" );
      ((Element)v.get(63)).setAttribute("height","12" );
      ((Element)v.get(62)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */
      /* Termina nodo:62   */

      /* Empieza nodo:64 / Elemento padre: 61   */
      v.add(doc.createElement("td"));
      ((Element)v.get(64)).setAttribute("width","756" );
      ((Element)v.get(61)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(65)).setAttribute("src","b.gif" );
      ((Element)v.get(64)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */
      /* Termina nodo:64   */

      /* Empieza nodo:66 / Elemento padre: 61   */
      v.add(doc.createElement("td"));
      ((Element)v.get(66)).setAttribute("width","12" );
      ((Element)v.get(61)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(67)).setAttribute("src","b.gif" );
      ((Element)v.get(67)).setAttribute("width","12" );
      ((Element)v.get(67)).setAttribute("height","1" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */
      /* Termina nodo:66   */
      /* Termina nodo:61   */
      /* Termina nodo:20   */
      /* Termina nodo:19   */

      /* Empieza nodo:68 / Elemento padre: 8   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(68)).setAttribute("nombre","listado1" );
      ((Element)v.get(68)).setAttribute("ancho","708" );
      ((Element)v.get(68)).setAttribute("alto","317" );
      ((Element)v.get(68)).setAttribute("x","12" );
      ((Element)v.get(68)).setAttribute("y","102" );
      ((Element)v.get(68)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(68)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(8)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(69)).setAttribute("precarga","S" );
      ((Element)v.get(69)).setAttribute("conROver","S" );
      ((Element)v.get(68)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
   }

   private void getXML270(Document doc) {
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(70)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(70)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(70)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(70)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(69)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */

      /* Empieza nodo:71 / Elemento padre: 69   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(71)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(71)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(71)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(71)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(69)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */

      /* Empieza nodo:72 / Elemento padre: 69   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(72)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(72)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(69)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */
      /* Termina nodo:69   */

      /* Empieza nodo:73 / Elemento padre: 68   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(68)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(74)).setAttribute("borde","1" );
      ((Element)v.get(74)).setAttribute("horizDatos","1" );
      ((Element)v.get(74)).setAttribute("horizCabecera","1" );
      ((Element)v.get(74)).setAttribute("vertical","1" );
      ((Element)v.get(74)).setAttribute("horizTitulo","1" );
      ((Element)v.get(74)).setAttribute("horizBase","1" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */

      /* Empieza nodo:75 / Elemento padre: 73   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(75)).setAttribute("borde","#999999" );
      ((Element)v.get(75)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(75)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(75)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(75)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(75)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(75)).setAttribute("horizBase","#999999" );
      ((Element)v.get(73)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */
      /* Termina nodo:73   */

      /* Empieza nodo:76 / Elemento padre: 68   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(76)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(76)).setAttribute("alto","22" );
      ((Element)v.get(76)).setAttribute("imgFondo","" );
      ((Element)v.get(76)).setAttribute("cod","00546" );
      ((Element)v.get(76)).setAttribute("ID","datosTitle" );
      ((Element)v.get(68)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */

      /* Empieza nodo:77 / Elemento padre: 68   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(77)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(77)).setAttribute("alto","22" );
      ((Element)v.get(77)).setAttribute("imgFondo","" );
      ((Element)v.get(68)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */

      /* Empieza nodo:78 / Elemento padre: 68   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(78)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(78)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(78)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(78)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(78)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(78)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(68)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(79)).setAttribute("ancho","100" );
      ((Element)v.get(79)).setAttribute("minimizable","S" );
      ((Element)v.get(79)).setAttribute("minimizada","N" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */

      /* Empieza nodo:80 / Elemento padre: 78   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(80)).setAttribute("ancho","100" );
      ((Element)v.get(80)).setAttribute("minimizable","S" );
      ((Element)v.get(80)).setAttribute("minimizada","N" );
      ((Element)v.get(78)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */

      /* Empieza nodo:81 / Elemento padre: 78   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(81)).setAttribute("ancho","100" );
      ((Element)v.get(81)).setAttribute("minimizable","S" );
      ((Element)v.get(81)).setAttribute("minimizada","N" );
      ((Element)v.get(78)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */

      /* Empieza nodo:82 / Elemento padre: 78   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(82)).setAttribute("ancho","100" );
      ((Element)v.get(82)).setAttribute("minimizable","S" );
      ((Element)v.get(82)).setAttribute("minimizada","N" );
      ((Element)v.get(78)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */

      /* Empieza nodo:83 / Elemento padre: 78   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(83)).setAttribute("ancho","100" );
      ((Element)v.get(83)).setAttribute("minimizable","S" );
      ((Element)v.get(83)).setAttribute("minimizada","N" );
      ((Element)v.get(78)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */

      /* Empieza nodo:84 / Elemento padre: 78   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(84)).setAttribute("ancho","130" );
      ((Element)v.get(84)).setAttribute("minimizable","S" );
      ((Element)v.get(84)).setAttribute("minimizada","N" );
      ((Element)v.get(78)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */
      /* Termina nodo:78   */

      /* Empieza nodo:85 / Elemento padre: 68   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(85)).setAttribute("alto","20" );
      ((Element)v.get(85)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(85)).setAttribute("imgFondo","" );
      ((Element)v.get(85)).setAttribute("colFondo","#CCCCCC" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(85)).setAttribute("ajustarAMitadInf","S" );
      ((Element)v.get(68)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(86)).setAttribute("colFondo","" );
      ((Element)v.get(86)).setAttribute("ID","EstCab" );
      ((Element)v.get(86)).setAttribute("cod","823" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));

      /* Elemento padre:86 / Elemento actual: 87   */
      v.add(doc.createTextNode("Cód. patrón"));
      ((Element)v.get(86)).appendChild((Text)v.get(87));

      /* Termina nodo Texto:87   */
      /* Termina nodo:86   */

      /* Empieza nodo:88 / Elemento padre: 85   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(88)).setAttribute("colFondo","" );
      ((Element)v.get(88)).setAttribute("ID","EstCab" );
      ((Element)v.get(88)).setAttribute("cod","9" );
      ((Element)v.get(85)).appendChild((Element)v.get(88));

      /* Elemento padre:88 / Elemento actual: 89   */
      v.add(doc.createTextNode("Descripción"));
      ((Element)v.get(88)).appendChild((Text)v.get(89));

      /* Termina nodo Texto:89   */
      /* Termina nodo:88   */

      /* Empieza nodo:90 / Elemento padre: 85   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(90)).setAttribute("colFondo","" );
      ((Element)v.get(90)).setAttribute("ID","EstCab" );
      ((Element)v.get(90)).setAttribute("cod","2285" );
      ((Element)v.get(85)).appendChild((Element)v.get(90));

      /* Elemento padre:90 / Elemento actual: 91   */
      v.add(doc.createTextNode("Formulario"));
      ((Element)v.get(90)).appendChild((Text)v.get(91));

      /* Termina nodo Texto:91   */
      /* Termina nodo:90   */

      /* Empieza nodo:92 / Elemento padre: 85   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(92)).setAttribute("colFondo","" );
      ((Element)v.get(92)).setAttribute("ID","EstCab" );
      ((Element)v.get(92)).setAttribute("cod","913" );
      ((Element)v.get(85)).appendChild((Element)v.get(92));

      /* Elemento padre:92 / Elemento actual: 93   */
      v.add(doc.createTextNode("Medio envío"));
      ((Element)v.get(92)).appendChild((Text)v.get(93));

      /* Termina nodo Texto:93   */
      /* Termina nodo:92   */

      /* Empieza nodo:94 / Elemento padre: 85   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(94)).setAttribute("colFondo","" );
      ((Element)v.get(94)).setAttribute("ID","EstCab" );
      ((Element)v.get(94)).setAttribute("cod","795" );
      ((Element)v.get(85)).appendChild((Element)v.get(94));

      /* Elemento padre:94 / Elemento actual: 95   */
      v.add(doc.createTextNode("Activo"));
      ((Element)v.get(94)).appendChild((Text)v.get(95));

      /* Termina nodo Texto:95   */
      /* Termina nodo:94   */

      /* Empieza nodo:96 / Elemento padre: 85   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(96)).setAttribute("colFondo","" );
      ((Element)v.get(96)).setAttribute("ID","EstCab" );
      ((Element)v.get(96)).setAttribute("cod","965" );
      ((Element)v.get(85)).appendChild((Element)v.get(96));

      /* Elemento padre:96 / Elemento actual: 97   */
      v.add(doc.createTextNode("Patrón por período"));
      ((Element)v.get(96)).appendChild((Text)v.get(97));

      /* Termina nodo Texto:97   */
      /* Termina nodo:96   */
      /* Termina nodo:85   */

      /* Empieza nodo:98 / Elemento padre: 68   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(98)).setAttribute("alto","22" );
      ((Element)v.get(98)).setAttribute("accion","" );
      ((Element)v.get(98)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(98)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(98)).setAttribute("maxSel","-1" );
      ((Element)v.get(98)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(98)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(98)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(98)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(68)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(99)).setAttribute("tipo","texto" );
      ((Element)v.get(99)).setAttribute("ID","EstDat" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */

      /* Empieza nodo:100 / Elemento padre: 98   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(100)).setAttribute("tipo","texto" );
      ((Element)v.get(100)).setAttribute("ID","EstDat2" );
      ((Element)v.get(98)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */

      /* Empieza nodo:101 / Elemento padre: 98   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(101)).setAttribute("tipo","texto" );
      ((Element)v.get(101)).setAttribute("ID","EstDat" );
      ((Element)v.get(98)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */

      /* Empieza nodo:102 / Elemento padre: 98   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(102)).setAttribute("tipo","texto" );
      ((Element)v.get(102)).setAttribute("ID","EstDat2" );
      ((Element)v.get(98)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */

      /* Empieza nodo:103 / Elemento padre: 98   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(103)).setAttribute("tipo","texto" );
      ((Element)v.get(103)).setAttribute("ID","EstDat" );
      ((Element)v.get(98)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */

      /* Empieza nodo:104 / Elemento padre: 98   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(104)).setAttribute("tipo","texto" );
      ((Element)v.get(104)).setAttribute("ID","EstDat2" );
      ((Element)v.get(98)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */
      /* Termina nodo:98   */

      /* Empieza nodo:105 / Elemento padre: 68   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(68)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */

      /* Empieza nodo:106 / Elemento padre: 68   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(106)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(106)).setAttribute("ancho","708" );
      ((Element)v.get(106)).setAttribute("sep","$" );
      ((Element)v.get(106)).setAttribute("x","12" );
      ((Element)v.get(106)).setAttribute("class","botonera" );
      ((Element)v.get(106)).setAttribute("y","396" );
      ((Element)v.get(106)).setAttribute("control","|" );
      ((Element)v.get(106)).setAttribute("conector","conectorSandra" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(106)).setAttribute("rowset","" );
      ((Element)v.get(106)).setAttribute("cargainicial","N" );
      ((Element)v.get(106)).setAttribute("onload","procesarPaginado(mipgndo,msgError,ultima,rowset,'muestraLista(ultima,rowset)');" );
      ((Element)v.get(68)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(107)).setAttribute("nombre","ret1" );
      ((Element)v.get(107)).setAttribute("x","37" );
      ((Element)v.get(107)).setAttribute("y","400" );
      ((Element)v.get(107)).setAttribute("ID","botonContenido" );
      ((Element)v.get(107)).setAttribute("img","retroceder_on" );
      ((Element)v.get(107)).setAttribute("tipo","0" );
      ((Element)v.get(107)).setAttribute("estado","false" );
      ((Element)v.get(107)).setAttribute("alt","" );
      ((Element)v.get(107)).setAttribute("codigo","" );
      ((Element)v.get(107)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(106)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */

      /* Empieza nodo:108 / Elemento padre: 106   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(108)).setAttribute("nombre","ava1" );
      ((Element)v.get(108)).setAttribute("x","52" );
      ((Element)v.get(108)).setAttribute("y","400" );
      ((Element)v.get(108)).setAttribute("ID","botonContenido" );
      ((Element)v.get(108)).setAttribute("img","avanzar_on" );
      ((Element)v.get(108)).setAttribute("tipo","0" );
      ((Element)v.get(108)).setAttribute("estado","false" );
      ((Element)v.get(108)).setAttribute("alt","" );
      ((Element)v.get(108)).setAttribute("codigo","" );
      ((Element)v.get(108)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(106)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */
      /* Termina nodo:106   */
      /* Termina nodo:68   */

      /* Empieza nodo:109 / Elemento padre: 8   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(109)).setAttribute("nombre","primera1" );
      ((Element)v.get(109)).setAttribute("x","20" );
      ((Element)v.get(109)).setAttribute("y","400" );
      ((Element)v.get(109)).setAttribute("ID","botonContenido" );
      ((Element)v.get(109)).setAttribute("img","primera_on" );
      ((Element)v.get(109)).setAttribute("tipo","-2" );
      ((Element)v.get(109)).setAttribute("estado","false" );
      ((Element)v.get(109)).setAttribute("alt","" );
      ((Element)v.get(109)).setAttribute("codigo","" );
      ((Element)v.get(109)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(8)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */

      /* Empieza nodo:110 / Elemento padre: 8   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(110)).setAttribute("nombre","separa" );
      ((Element)v.get(110)).setAttribute("x","59" );
      ((Element)v.get(110)).setAttribute("y","396" );
      ((Element)v.get(110)).setAttribute("ID","botonContenido" );
      ((Element)v.get(110)).setAttribute("img","separa_base" );
      ((Element)v.get(110)).setAttribute("tipo","0" );
      ((Element)v.get(110)).setAttribute("estado","false" );
      ((Element)v.get(110)).setAttribute("alt","" );
      ((Element)v.get(110)).setAttribute("codigo","" );
      ((Element)v.get(110)).setAttribute("accion","" );
      ((Element)v.get(8)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */

      /* Empieza nodo:111 / Elemento padre: 8   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(111)).setAttribute("nombre","Copiar" );
      ((Element)v.get(111)).setAttribute("x","80" );
      ((Element)v.get(111)).setAttribute("y","397" );
      ((Element)v.get(111)).setAttribute("ID","botonContenido" );
      ((Element)v.get(111)).setAttribute("tipo","html" );
      ((Element)v.get(111)).setAttribute("estado","false" );
      ((Element)v.get(111)).setAttribute("alt","" );
      ((Element)v.get(111)).setAttribute("cod","721" );
      ((Element)v.get(111)).setAttribute("accion","accionCopiar();" );
      ((Element)v.get(111)).setAttribute("ontab","ontab_Copiar();" );
      ((Element)v.get(111)).setAttribute("onshtab","ontab_Copiar()" );
      ((Element)v.get(8)).appendChild((Element)v.get(111));
      /* Termina nodo:111   */

      /* Empieza nodo:112 / Elemento padre: 8   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(112)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(112)).setAttribute("alto","12" );
      ((Element)v.get(112)).setAttribute("ancho","100%" );
      ((Element)v.get(112)).setAttribute("colorf","" );
      ((Element)v.get(112)).setAttribute("borde","0" );
      ((Element)v.get(112)).setAttribute("imagenf","" );
      ((Element)v.get(112)).setAttribute("repeat","" );
      ((Element)v.get(112)).setAttribute("padding","" );
      ((Element)v.get(112)).setAttribute("visibilidad","visible" );
      ((Element)v.get(112)).setAttribute("contravsb","" );
      ((Element)v.get(112)).setAttribute("x","0" );
      ((Element)v.get(112)).setAttribute("y","419" );
      ((Element)v.get(112)).setAttribute("zindex","" );
      ((Element)v.get(8)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */
      /* Termina nodo:8   */


   }

}
