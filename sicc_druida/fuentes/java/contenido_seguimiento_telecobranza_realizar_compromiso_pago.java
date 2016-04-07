
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_seguimiento_telecobranza_realizar_compromiso_pago  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("nombre","contenido_seguimiento_telecobranza_realizar_compromiso_pago" );
      ((Element)v.get(0)).setAttribute("cod","0281" );
      ((Element)v.get(0)).setAttribute("titulo","Realizar Seguimiento de Telecobranza" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","Realizar Seguimiento de Telecobranza" );
      ((Element)v.get(0)).setAttribute("onload","onLoadPag()" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(1));

      /* Elemento padre:1 / Elemento actual: 2   */
      v.add(doc.createTextNode("\r     \r      \r	function onLoadPag()   \r	{\r        configurarMenuSecundario('frmFormulario');\r	    DrdEnsanchaConMargenDcho('listado1',12);\r	    \r	    document.all[\"Cplistado1\"].style.visibility='';\r	    document.all[\"CpLin1listado1\"].style.visibility='';\r	    document.all[\"CpLin2listado1\"].style.visibility='';\r	    document.all[\"CpLin3listado1\"].style.visibility='';\r	    document.all[\"CpLin4listado1\"].style.visibility='';\r\r	    document.all[\"primera1Div\"].style.visibility='';\r	    document.all[\"ret1Div\"].style.visibility='';\r	    document.all[\"ava1Div\"].style.visibility='';\r	    document.all[\"separaDiv\"].style.visibility='';\r          \r	    eval (ON_RSZ);  \r        fMostrarMensajeError();\r                paginado();\r        \r	}\r    \r    \r    function paginado()\r    {\r     /*   configurarPaginado(resultado, \"COBCompromisoPago\", \"ConectorCompromisoPago\", \r        DTOEBuscarCompromisosPago\", [ \r        [\"pais\", get(pais de la sesion)], \r        [\"idioma\", get(idioma de la sesion)], \r        [\"oidGestionCobranza\", get(oid)]\r        [\"paginado\", \"true\"]);*/\r        \r        configurarPaginado (mipgndo,'COBBuscarCompromisosPago','ConectorBuscarCompromisosPago',\r            'es.indra.sicc.dtos.cob.DTOEBuscarCompromisosPago', armarArray());\r    }\r    \r    function armarArray()\r    {\r        var vArray = new Array();\r        var i = 0;\r        \r        vArray[i] = new Array('oidIdioma',get(\"frmFormulario.oidIdioma\"));\r        i++;\r        vArray[i] = new Array('oidPais',get(\"frmFormulario.oidPais\"));\r        i++;\r        vArray[i] = new Array('oidGestionCobranza',get(\"frmFormulario.oidGestionCobranza\"));\r        i++;\r        vArray[i] = new Array('paginado','true');\r        i++;\r        \r        return vArray;\r    }\r    \r    function fVolver(){\r        window.close();\r     }\r     \r      function muestraLista( ultima, rowset){\r        var tamano = rowset.length;\r    \r        if (tamano > 0){\r            var datos = rowset[0].toString();            \r            var newRow = new Array();\r			newRow = datos.split(\",\");\r            txt_to('lbldtAccion',newRow[2]);\r            txt_to('lbldtDescripcionAccion',newRow[3]);\r            txt_to('lbldtSubtipoAccion',newRow[4]);\r                        \r            eval (ON_RSZ);\r            return true;\r        }\r        else{\r				  /*  cdos_mostrarAlert(error);*/\r				 window.close();\r				 return false;\r        }\r    }\r    \r  \r  "));
      ((Element)v.get(1)).appendChild((Text)v.get(2));

      /* Termina nodo Texto:2   */
      /* Termina nodo:1   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(3)).setAttribute("src","sicc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(4)).setAttribute("src","PaginacionSicc.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(5)).setAttribute("src","DruidaTransactionMare.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(6)).setAttribute("nombre","frmFormulario" );
      ((Element)v.get(0)).appendChild((Element)v.get(6));

      /* Empieza nodo:7 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(7)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(7)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(8)).setAttribute("nombre","accion" );
      ((Element)v.get(8)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","oidPais" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","oidIdioma" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","oidGestionCobranza" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(14)).setAttribute("nombre","capa1" );
      ((Element)v.get(6)).appendChild((Element)v.get(14));

      /* Empieza nodo:15 / Elemento padre: 14   */
      v.add(doc.createElement("table"));
      ((Element)v.get(15)).setAttribute("width","100%" );
      ((Element)v.get(15)).setAttribute("border","0" );
      ((Element)v.get(15)).setAttribute("cellspacing","0" );
      ((Element)v.get(15)).setAttribute("cellpadding","0" );
      ((Element)v.get(14)).appendChild((Element)v.get(15));

      /* Empieza nodo:16 / Elemento padre: 15   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(15)).appendChild((Element)v.get(16));

      /* Empieza nodo:17 / Elemento padre: 16   */
      v.add(doc.createElement("td"));
      ((Element)v.get(17)).setAttribute("width","12" );
      ((Element)v.get(17)).setAttribute("align","center" );
      ((Element)v.get(16)).appendChild((Element)v.get(17));

      /* Empieza nodo:18 / Elemento padre: 17   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(18)).setAttribute("src","b.gif" );
      ((Element)v.get(18)).setAttribute("width","12" );
      ((Element)v.get(18)).setAttribute("height","12" );
      ((Element)v.get(17)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */
      /* Termina nodo:17   */

      /* Empieza nodo:19 / Elemento padre: 16   */
      v.add(doc.createElement("td"));
      ((Element)v.get(19)).setAttribute("width","750" );
      ((Element)v.get(16)).appendChild((Element)v.get(19));

      /* Empieza nodo:20 / Elemento padre: 19   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(20)).setAttribute("src","b.gif" );
      ((Element)v.get(19)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */
      /* Termina nodo:19   */

      /* Empieza nodo:21 / Elemento padre: 16   */
      v.add(doc.createElement("td"));
      ((Element)v.get(21)).setAttribute("width","12" );
      ((Element)v.get(16)).appendChild((Element)v.get(21));

      /* Empieza nodo:22 / Elemento padre: 21   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(22)).setAttribute("src","b.gif" );
      ((Element)v.get(22)).setAttribute("width","12" );
      ((Element)v.get(22)).setAttribute("height","1" );
      ((Element)v.get(21)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */
      /* Termina nodo:21   */
      /* Termina nodo:16   */

      /* Empieza nodo:23 / Elemento padre: 15   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(15)).appendChild((Element)v.get(23));

      /* Empieza nodo:24 / Elemento padre: 23   */
   }

   private void getXML90(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(23)).appendChild((Element)v.get(24));

      /* Empieza nodo:25 / Elemento padre: 24   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(25)).setAttribute("src","b.gif" );
      ((Element)v.get(24)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */
      /* Termina nodo:24   */

      /* Empieza nodo:26 / Elemento padre: 23   */
      v.add(doc.createElement("td"));
      ((Element)v.get(23)).appendChild((Element)v.get(26));

      /* Empieza nodo:27 / Elemento padre: 26   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(26)).appendChild((Element)v.get(27));

      /* Empieza nodo:28 / Elemento padre: 27   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(28)).setAttribute("class","legend" );
      ((Element)v.get(27)).appendChild((Element)v.get(28));

      /* Empieza nodo:29 / Elemento padre: 28   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(29)).setAttribute("nombre","lblDatosAccionSeleccionada" );
      ((Element)v.get(29)).setAttribute("alto","13" );
      ((Element)v.get(29)).setAttribute("filas","1" );
      ((Element)v.get(29)).setAttribute("valor","Datos Búsqueda" );
      ((Element)v.get(29)).setAttribute("id","legend" );
      ((Element)v.get(29)).setAttribute("cod","00615" );
      ((Element)v.get(28)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */
      /* Termina nodo:28   */

      /* Empieza nodo:30 / Elemento padre: 27   */
      v.add(doc.createElement("table"));
      ((Element)v.get(30)).setAttribute("width","100%" );
      ((Element)v.get(30)).setAttribute("border","0" );
      ((Element)v.get(30)).setAttribute("align","center" );
      ((Element)v.get(30)).setAttribute("cellspacing","0" );
      ((Element)v.get(30)).setAttribute("cellpadding","0" );
      ((Element)v.get(27)).appendChild((Element)v.get(30));

      /* Empieza nodo:31 / Elemento padre: 30   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(30)).appendChild((Element)v.get(31));

      /* Empieza nodo:32 / Elemento padre: 31   */
      v.add(doc.createElement("td"));
      ((Element)v.get(31)).appendChild((Element)v.get(32));

      /* Empieza nodo:33 / Elemento padre: 32   */
      v.add(doc.createElement("table"));
      ((Element)v.get(33)).setAttribute("width","450" );
      ((Element)v.get(33)).setAttribute("border","0" );
      ((Element)v.get(33)).setAttribute("align","left" );
      ((Element)v.get(33)).setAttribute("cellspacing","0" );
      ((Element)v.get(33)).setAttribute("cellpadding","0" );
      ((Element)v.get(32)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(33)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("td"));
      ((Element)v.get(35)).setAttribute("colspan","4" );
      ((Element)v.get(34)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(36)).setAttribute("src","b.gif" );
      ((Element)v.get(36)).setAttribute("width","8" );
      ((Element)v.get(36)).setAttribute("height","8" );
      ((Element)v.get(35)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */
      /* Termina nodo:35   */
      /* Termina nodo:34   */

      /* Empieza nodo:37 / Elemento padre: 33   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(33)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("td"));
      ((Element)v.get(37)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(39)).setAttribute("src","b.gif" );
      ((Element)v.get(39)).setAttribute("width","8" );
      ((Element)v.get(39)).setAttribute("height","8" );
      ((Element)v.get(38)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */
      /* Termina nodo:38   */

      /* Empieza nodo:40 / Elemento padre: 37   */
      v.add(doc.createElement("td"));
      ((Element)v.get(37)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(41)).setAttribute("nombre","lblAccion" );
      ((Element)v.get(41)).setAttribute("alto","13" );
      ((Element)v.get(41)).setAttribute("filas","1" );
      ((Element)v.get(41)).setAttribute("valor","" );
      ((Element)v.get(41)).setAttribute("id","datosTitle" );
      ((Element)v.get(41)).setAttribute("cod","793" );
      ((Element)v.get(40)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */
      /* Termina nodo:40   */

      /* Empieza nodo:42 / Elemento padre: 37   */
      v.add(doc.createElement("td"));
      ((Element)v.get(37)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(43)).setAttribute("src","b.gif" );
      ((Element)v.get(43)).setAttribute("width","25" );
      ((Element)v.get(43)).setAttribute("height","8" );
      ((Element)v.get(42)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */
      /* Termina nodo:42   */

      /* Empieza nodo:44 / Elemento padre: 37   */
      v.add(doc.createElement("td"));
      ((Element)v.get(37)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(45)).setAttribute("nombre","lblDescripcionAccion" );
      ((Element)v.get(45)).setAttribute("alto","13" );
      ((Element)v.get(45)).setAttribute("filas","1" );
      ((Element)v.get(45)).setAttribute("valor","" );
      ((Element)v.get(45)).setAttribute("id","datosTitle" );
      ((Element)v.get(45)).setAttribute("cod","841" );
      ((Element)v.get(44)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */
      /* Termina nodo:44   */

      /* Empieza nodo:46 / Elemento padre: 37   */
      v.add(doc.createElement("td"));
      ((Element)v.get(37)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(47)).setAttribute("src","b.gif" );
      ((Element)v.get(47)).setAttribute("width","25" );
      ((Element)v.get(47)).setAttribute("height","8" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(46)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */
      /* Termina nodo:46   */

      /* Empieza nodo:48 / Elemento padre: 37   */
      v.add(doc.createElement("td"));
      ((Element)v.get(37)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(49)).setAttribute("nombre","lblSubtipoAccion" );
      ((Element)v.get(49)).setAttribute("alto","13" );
      ((Element)v.get(49)).setAttribute("filas","1" );
      ((Element)v.get(49)).setAttribute("valor","" );
      ((Element)v.get(49)).setAttribute("id","datosTitle" );
      ((Element)v.get(49)).setAttribute("cod","994" );
      ((Element)v.get(48)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */
      /* Termina nodo:48   */

      /* Empieza nodo:50 / Elemento padre: 37   */
      v.add(doc.createElement("td"));
      ((Element)v.get(50)).setAttribute("width","100%" );
      ((Element)v.get(37)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(51)).setAttribute("src","b.gif" );
      ((Element)v.get(51)).setAttribute("width","8" );
      ((Element)v.get(51)).setAttribute("height","8" );
      ((Element)v.get(50)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */
      /* Termina nodo:50   */
      /* Termina nodo:37   */

      /* Empieza nodo:52 / Elemento padre: 33   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(33)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("td"));
      ((Element)v.get(52)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(54)).setAttribute("src","b.gif" );
      ((Element)v.get(54)).setAttribute("width","8" );
      ((Element)v.get(54)).setAttribute("height","8" );
      ((Element)v.get(53)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */
      /* Termina nodo:53   */

      /* Empieza nodo:55 / Elemento padre: 52   */
      v.add(doc.createElement("td"));
      ((Element)v.get(52)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(56)).setAttribute("nombre","lbldtAccion" );
      ((Element)v.get(56)).setAttribute("alto","13" );
      ((Element)v.get(56)).setAttribute("filas","1" );
      ((Element)v.get(56)).setAttribute("valor","" );
      ((Element)v.get(56)).setAttribute("id","datosCampos" );
      ((Element)v.get(55)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */
      /* Termina nodo:55   */

      /* Empieza nodo:57 / Elemento padre: 52   */
      v.add(doc.createElement("td"));
      ((Element)v.get(52)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(58)).setAttribute("src","b.gif" );
      ((Element)v.get(58)).setAttribute("width","25" );
      ((Element)v.get(58)).setAttribute("height","8" );
      ((Element)v.get(57)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */
      /* Termina nodo:57   */

      /* Empieza nodo:59 / Elemento padre: 52   */
      v.add(doc.createElement("td"));
      ((Element)v.get(52)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(60)).setAttribute("nombre","lbldtDescripcionAccion" );
      ((Element)v.get(60)).setAttribute("alto","13" );
      ((Element)v.get(60)).setAttribute("filas","1" );
      ((Element)v.get(60)).setAttribute("valor","" );
      ((Element)v.get(60)).setAttribute("id","datosCampos" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */
      /* Termina nodo:59   */

      /* Empieza nodo:61 / Elemento padre: 52   */
      v.add(doc.createElement("td"));
      ((Element)v.get(52)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(62)).setAttribute("src","b.gif" );
      ((Element)v.get(62)).setAttribute("width","25" );
      ((Element)v.get(62)).setAttribute("height","8" );
      ((Element)v.get(61)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */
      /* Termina nodo:61   */

      /* Empieza nodo:63 / Elemento padre: 52   */
      v.add(doc.createElement("td"));
      ((Element)v.get(52)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(64)).setAttribute("nombre","lbldtSubtipoAccion" );
      ((Element)v.get(64)).setAttribute("alto","13" );
      ((Element)v.get(64)).setAttribute("filas","1" );
      ((Element)v.get(64)).setAttribute("valor","" );
      ((Element)v.get(64)).setAttribute("id","datosCampos" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */
      /* Termina nodo:63   */

      /* Empieza nodo:65 / Elemento padre: 52   */
      v.add(doc.createElement("td"));
      ((Element)v.get(65)).setAttribute("width","100%" );
      ((Element)v.get(52)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(66)).setAttribute("src","b.gif" );
      ((Element)v.get(66)).setAttribute("width","8" );
      ((Element)v.get(66)).setAttribute("height","8" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */
      /* Termina nodo:65   */
      /* Termina nodo:52   */

      /* Empieza nodo:67 / Elemento padre: 33   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(33)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("td"));
      ((Element)v.get(68)).setAttribute("colspan","4" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(69)).setAttribute("src","b.gif" );
      ((Element)v.get(69)).setAttribute("width","8" );
      ((Element)v.get(69)).setAttribute("height","8" );
      ((Element)v.get(68)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */
      /* Termina nodo:68   */
      /* Termina nodo:67   */
      /* Termina nodo:33   */
      /* Termina nodo:32   */
      /* Termina nodo:31   */
      /* Termina nodo:30   */
      /* Termina nodo:27   */
      /* Termina nodo:26   */

      /* Empieza nodo:70 / Elemento padre: 23   */
      v.add(doc.createElement("td"));
      ((Element)v.get(23)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML270(Document doc) {
      ((Element)v.get(71)).setAttribute("src","b.gif" );
      ((Element)v.get(70)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */
      /* Termina nodo:70   */
      /* Termina nodo:23   */

      /* Empieza nodo:72 / Elemento padre: 15   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(15)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("td"));
      ((Element)v.get(73)).setAttribute("width","12" );
      ((Element)v.get(73)).setAttribute("align","center" );
      ((Element)v.get(72)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(74)).setAttribute("src","b.gif" );
      ((Element)v.get(74)).setAttribute("width","12" );
      ((Element)v.get(74)).setAttribute("height","12" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */
      /* Termina nodo:73   */

      /* Empieza nodo:75 / Elemento padre: 72   */
      v.add(doc.createElement("td"));
      ((Element)v.get(75)).setAttribute("width","750" );
      ((Element)v.get(72)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(76)).setAttribute("src","b.gif" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */
      /* Termina nodo:75   */

      /* Empieza nodo:77 / Elemento padre: 72   */
      v.add(doc.createElement("td"));
      ((Element)v.get(77)).setAttribute("width","12" );
      ((Element)v.get(72)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(78)).setAttribute("src","b.gif" );
      ((Element)v.get(78)).setAttribute("width","12" );
      ((Element)v.get(78)).setAttribute("height","1" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */
      /* Termina nodo:77   */
      /* Termina nodo:72   */
      /* Termina nodo:15   */
      /* Termina nodo:14   */

      /* Empieza nodo:79 / Elemento padre: 6   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(79)).setAttribute("nombre","listado1" );
      ((Element)v.get(79)).setAttribute("ancho","654" );
      ((Element)v.get(79)).setAttribute("alto","317" );
      ((Element)v.get(79)).setAttribute("x","12" );
      ((Element)v.get(79)).setAttribute("y","92" );
      ((Element)v.get(79)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(79)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(6)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(80)).setAttribute("precarga","S" );
      ((Element)v.get(80)).setAttribute("conROver","S" );
      ((Element)v.get(79)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(81)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(81)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(81)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(81)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(80)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */

      /* Empieza nodo:82 / Elemento padre: 80   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(82)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(82)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(82)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(82)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(80)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */

      /* Empieza nodo:83 / Elemento padre: 80   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(83)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(83)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(80)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */
      /* Termina nodo:80   */

      /* Empieza nodo:84 / Elemento padre: 79   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(79)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(85)).setAttribute("borde","1" );
      ((Element)v.get(85)).setAttribute("horizDatos","1" );
      ((Element)v.get(85)).setAttribute("horizCabecera","1" );
      ((Element)v.get(85)).setAttribute("vertical","1" );
      ((Element)v.get(85)).setAttribute("horizTitulo","1" );
      ((Element)v.get(85)).setAttribute("horizBase","1" );
      ((Element)v.get(84)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */

      /* Empieza nodo:86 / Elemento padre: 84   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(86)).setAttribute("borde","#999999" );
      ((Element)v.get(86)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(86)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(86)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(86)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(86)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(86)).setAttribute("horizBase","#999999" );
      ((Element)v.get(84)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */
      /* Termina nodo:84   */

      /* Empieza nodo:87 / Elemento padre: 79   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(87)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(87)).setAttribute("alto","22" );
      ((Element)v.get(87)).setAttribute("imgFondo","" );
      ((Element)v.get(87)).setAttribute("cod","0032" );
      ((Element)v.get(87)).setAttribute("ID","datosTitle" );
      ((Element)v.get(79)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */

      /* Empieza nodo:88 / Elemento padre: 79   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(88)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(88)).setAttribute("alto","22" );
      ((Element)v.get(88)).setAttribute("imgFondo","" );
      ((Element)v.get(79)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */

      /* Empieza nodo:89 / Elemento padre: 79   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(89)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(89)).setAttribute("permiteOrdenar","S" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(89)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(89)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(89)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(89)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(79)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(90)).setAttribute("ancho","30" );
      ((Element)v.get(90)).setAttribute("minimizable","S" );
      ((Element)v.get(90)).setAttribute("minimizada","N" );
      ((Element)v.get(90)).setAttribute("oculta","S" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */

      /* Empieza nodo:91 / Elemento padre: 89   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(91)).setAttribute("ancho","30" );
      ((Element)v.get(91)).setAttribute("minimizable","S" );
      ((Element)v.get(91)).setAttribute("minimizada","N" );
      ((Element)v.get(91)).setAttribute("oculta","S" );
      ((Element)v.get(89)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */

      /* Empieza nodo:92 / Elemento padre: 89   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(92)).setAttribute("ancho","30" );
      ((Element)v.get(92)).setAttribute("minimizable","S" );
      ((Element)v.get(92)).setAttribute("minimizada","N" );
      ((Element)v.get(92)).setAttribute("oculta","S" );
      ((Element)v.get(89)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */

      /* Empieza nodo:93 / Elemento padre: 89   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(93)).setAttribute("ancho","30" );
      ((Element)v.get(93)).setAttribute("minimizable","S" );
      ((Element)v.get(93)).setAttribute("minimizada","N" );
      ((Element)v.get(93)).setAttribute("oculta","S" );
      ((Element)v.get(89)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */

      /* Empieza nodo:94 / Elemento padre: 89   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(94)).setAttribute("ancho","180" );
      ((Element)v.get(94)).setAttribute("minimizable","S" );
      ((Element)v.get(94)).setAttribute("minimizada","N" );
      ((Element)v.get(89)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */

      /* Empieza nodo:95 / Elemento padre: 89   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(95)).setAttribute("ancho","180" );
      ((Element)v.get(95)).setAttribute("minimizable","S" );
      ((Element)v.get(95)).setAttribute("minimizada","N" );
      ((Element)v.get(89)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */

      /* Empieza nodo:96 / Elemento padre: 89   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(96)).setAttribute("ancho","180" );
      ((Element)v.get(96)).setAttribute("minimizable","S" );
      ((Element)v.get(96)).setAttribute("minimizada","N" );
      ((Element)v.get(89)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */

      /* Empieza nodo:97 / Elemento padre: 89   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(97)).setAttribute("ancho","180" );
      ((Element)v.get(97)).setAttribute("minimizable","S" );
      ((Element)v.get(97)).setAttribute("minimizada","N" );
      ((Element)v.get(89)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */

      /* Empieza nodo:98 / Elemento padre: 89   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(98)).setAttribute("ancho","180" );
      ((Element)v.get(98)).setAttribute("minimizable","S" );
      ((Element)v.get(98)).setAttribute("minimizada","N" );
      ((Element)v.get(89)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */

      /* Empieza nodo:99 / Elemento padre: 89   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(99)).setAttribute("ancho","180" );
      ((Element)v.get(99)).setAttribute("minimizable","S" );
      ((Element)v.get(99)).setAttribute("minimizada","N" );
      ((Element)v.get(89)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */

      /* Empieza nodo:100 / Elemento padre: 89   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(100)).setAttribute("ancho","180" );
      ((Element)v.get(100)).setAttribute("minimizable","S" );
      ((Element)v.get(100)).setAttribute("minimizada","N" );
      ((Element)v.get(89)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */

      /* Empieza nodo:101 / Elemento padre: 89   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(101)).setAttribute("ancho","180" );
      ((Element)v.get(101)).setAttribute("minimizable","S" );
      ((Element)v.get(101)).setAttribute("minimizada","N" );
      ((Element)v.get(89)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */
      /* Termina nodo:89   */

      /* Empieza nodo:102 / Elemento padre: 79   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(102)).setAttribute("alto","20" );
      ((Element)v.get(102)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(102)).setAttribute("imgFondo","" );
      ((Element)v.get(102)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(102)).setAttribute("ajustarAMitadInf","S" );
      ((Element)v.get(79)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(103)).setAttribute("colFondo","" );
      ((Element)v.get(103)).setAttribute("ID","EstCab" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));

      /* Elemento padre:103 / Elemento actual: 104   */
      v.add(doc.createTextNode("oid"));
      ((Element)v.get(103)).appendChild((Text)v.get(104));

      /* Termina nodo Texto:104   */
      /* Termina nodo:103   */

      /* Empieza nodo:105 / Elemento padre: 102   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(105)).setAttribute("colFondo","" );
      ((Element)v.get(105)).setAttribute("ID","EstCab" );
      ((Element)v.get(102)).appendChild((Element)v.get(105));

      /* Elemento padre:105 / Elemento actual: 106   */
      v.add(doc.createTextNode("oidAccion"));
      ((Element)v.get(105)).appendChild((Text)v.get(106));

      /* Termina nodo Texto:106   */
      /* Termina nodo:105   */

      /* Empieza nodo:107 / Elemento padre: 102   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(107)).setAttribute("colFondo","" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(107)).setAttribute("ID","EstCab" );
      ((Element)v.get(102)).appendChild((Element)v.get(107));

      /* Elemento padre:107 / Elemento actual: 108   */
      v.add(doc.createTextNode("descAccion"));
      ((Element)v.get(107)).appendChild((Text)v.get(108));

      /* Termina nodo Texto:108   */
      /* Termina nodo:107   */

      /* Empieza nodo:109 / Elemento padre: 102   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(109)).setAttribute("colFondo","" );
      ((Element)v.get(109)).setAttribute("ID","EstCab" );
      ((Element)v.get(102)).appendChild((Element)v.get(109));

      /* Elemento padre:109 / Elemento actual: 110   */
      v.add(doc.createTextNode("oidSubAcc"));
      ((Element)v.get(109)).appendChild((Text)v.get(110));

      /* Termina nodo Texto:110   */
      /* Termina nodo:109   */

      /* Empieza nodo:111 / Elemento padre: 102   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(111)).setAttribute("colFondo","" );
      ((Element)v.get(111)).setAttribute("ID","EstCab" );
      ((Element)v.get(111)).setAttribute("cod","2515" );
      ((Element)v.get(102)).appendChild((Element)v.get(111));

      /* Elemento padre:111 / Elemento actual: 112   */
      v.add(doc.createTextNode("Compromiso pago"));
      ((Element)v.get(111)).appendChild((Text)v.get(112));

      /* Termina nodo Texto:112   */
      /* Termina nodo:111   */

      /* Empieza nodo:113 / Elemento padre: 102   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(113)).setAttribute("colFondo","" );
      ((Element)v.get(113)).setAttribute("ID","EstCab" );
      ((Element)v.get(113)).setAttribute("cod","263" );
      ((Element)v.get(102)).appendChild((Element)v.get(113));

      /* Elemento padre:113 / Elemento actual: 114   */
      v.add(doc.createTextNode("Cód. cliente"));
      ((Element)v.get(113)).appendChild((Text)v.get(114));

      /* Termina nodo Texto:114   */
      /* Termina nodo:113   */

      /* Empieza nodo:115 / Elemento padre: 102   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(115)).setAttribute("colFondo","" );
      ((Element)v.get(115)).setAttribute("ID","EstCab" );
      ((Element)v.get(115)).setAttribute("cod","654" );
      ((Element)v.get(102)).appendChild((Element)v.get(115));

      /* Elemento padre:115 / Elemento actual: 116   */
      v.add(doc.createTextNode("Fecha pago"));
      ((Element)v.get(115)).appendChild((Text)v.get(116));

      /* Termina nodo Texto:116   */
      /* Termina nodo:115   */

      /* Empieza nodo:117 / Elemento padre: 102   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(117)).setAttribute("colFondo","" );
      ((Element)v.get(117)).setAttribute("ID","EstCab" );
      ((Element)v.get(117)).setAttribute("cod","670" );
      ((Element)v.get(102)).appendChild((Element)v.get(117));

      /* Elemento padre:117 / Elemento actual: 118   */
      v.add(doc.createTextNode("Importe pago"));
      ((Element)v.get(117)).appendChild((Text)v.get(118));

      /* Termina nodo Texto:118   */
      /* Termina nodo:117   */

      /* Empieza nodo:119 / Elemento padre: 102   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(119)).setAttribute("colFondo","" );
      ((Element)v.get(119)).setAttribute("ID","EstCab" );
      ((Element)v.get(119)).setAttribute("cod","881" );
      ((Element)v.get(102)).appendChild((Element)v.get(119));

      /* Elemento padre:119 / Elemento actual: 120   */
      v.add(doc.createTextNode("Fecha seguimiento previsto"));
      ((Element)v.get(119)).appendChild((Text)v.get(120));

      /* Termina nodo Texto:120   */
      /* Termina nodo:119   */

      /* Empieza nodo:121 / Elemento padre: 102   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(121)).setAttribute("colFondo","" );
      ((Element)v.get(121)).setAttribute("ID","EstCab" );
      ((Element)v.get(121)).setAttribute("cod","617" );
      ((Element)v.get(102)).appendChild((Element)v.get(121));

      /* Elemento padre:121 / Elemento actual: 122   */
      v.add(doc.createTextNode("Banco"));
      ((Element)v.get(121)).appendChild((Text)v.get(122));

      /* Termina nodo Texto:122   */
      /* Termina nodo:121   */

      /* Empieza nodo:123 / Elemento padre: 102   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(123)).setAttribute("colFondo","" );
      ((Element)v.get(123)).setAttribute("ID","EstCab" );
      ((Element)v.get(123)).setAttribute("cod","995" );
      ((Element)v.get(102)).appendChild((Element)v.get(123));

      /* Elemento padre:123 / Elemento actual: 124   */
      v.add(doc.createTextNode("Sucursal"));
      ((Element)v.get(123)).appendChild((Text)v.get(124));

      /* Termina nodo Texto:124   */
      /* Termina nodo:123   */

      /* Empieza nodo:125 / Elemento padre: 102   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(125)).setAttribute("colFondo","" );
      ((Element)v.get(125)).setAttribute("ID","EstCab" );
      ((Element)v.get(125)).setAttribute("cod","169" );
      ((Element)v.get(102)).appendChild((Element)v.get(125));

      /* Elemento padre:125 / Elemento actual: 126   */
      v.add(doc.createTextNode("Observaciones"));
      ((Element)v.get(125)).appendChild((Text)v.get(126));

      /* Termina nodo Texto:126   */
      /* Termina nodo:125   */
      /* Termina nodo:102   */

      /* Empieza nodo:127 / Elemento padre: 79   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(127)).setAttribute("alto","22" );
      ((Element)v.get(127)).setAttribute("accion","" );
      ((Element)v.get(127)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(127)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(127)).setAttribute("maxSel","-1" );
      ((Element)v.get(127)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(127)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(127)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(127)).setAttribute("onLoad","" );
      ((Element)v.get(127)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(79)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(128)).setAttribute("tipo","texto" );
      ((Element)v.get(128)).setAttribute("ID","EstDat" );
      ((Element)v.get(127)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */

      /* Empieza nodo:129 / Elemento padre: 127   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(129)).setAttribute("tipo","texto" );
      ((Element)v.get(129)).setAttribute("ID","EstDat2" );
      ((Element)v.get(127)).appendChild((Element)v.get(129));
      /* Termina nodo:129   */

      /* Empieza nodo:130 / Elemento padre: 127   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(130)).setAttribute("tipo","texto" );
      ((Element)v.get(130)).setAttribute("ID","EstDat" );
      ((Element)v.get(127)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */

      /* Empieza nodo:131 / Elemento padre: 127   */
   }

   private void getXML540(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(131)).setAttribute("tipo","texto" );
      ((Element)v.get(131)).setAttribute("ID","EstDat2" );
      ((Element)v.get(127)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */

      /* Empieza nodo:132 / Elemento padre: 127   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(132)).setAttribute("tipo","texto" );
      ((Element)v.get(132)).setAttribute("ID","EstDat" );
      ((Element)v.get(127)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */

      /* Empieza nodo:133 / Elemento padre: 127   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(133)).setAttribute("tipo","texto" );
      ((Element)v.get(133)).setAttribute("ID","EstDat2" );
      ((Element)v.get(127)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */

      /* Empieza nodo:134 / Elemento padre: 127   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(134)).setAttribute("tipo","texto" );
      ((Element)v.get(134)).setAttribute("ID","EstDat" );
      ((Element)v.get(127)).appendChild((Element)v.get(134));
      /* Termina nodo:134   */

      /* Empieza nodo:135 / Elemento padre: 127   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(135)).setAttribute("tipo","texto" );
      ((Element)v.get(135)).setAttribute("ID","EstDat2" );
      ((Element)v.get(127)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */

      /* Empieza nodo:136 / Elemento padre: 127   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(136)).setAttribute("tipo","texto" );
      ((Element)v.get(136)).setAttribute("ID","EstDat" );
      ((Element)v.get(127)).appendChild((Element)v.get(136));
      /* Termina nodo:136   */

      /* Empieza nodo:137 / Elemento padre: 127   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(137)).setAttribute("tipo","texto" );
      ((Element)v.get(137)).setAttribute("ID","EstDat2" );
      ((Element)v.get(127)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */

      /* Empieza nodo:138 / Elemento padre: 127   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(138)).setAttribute("tipo","texto" );
      ((Element)v.get(138)).setAttribute("ID","EstDat" );
      ((Element)v.get(127)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */

      /* Empieza nodo:139 / Elemento padre: 127   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(139)).setAttribute("tipo","texto" );
      ((Element)v.get(139)).setAttribute("ID","EstDat2" );
      ((Element)v.get(127)).appendChild((Element)v.get(139));
      /* Termina nodo:139   */
      /* Termina nodo:127   */

      /* Empieza nodo:140 / Elemento padre: 79   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(79)).appendChild((Element)v.get(140));
      /* Termina nodo:140   */

      /* Empieza nodo:141 / Elemento padre: 79   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(141)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(141)).setAttribute("ancho","654" );
      ((Element)v.get(141)).setAttribute("sep","$" );
      ((Element)v.get(141)).setAttribute("x","12" );
      ((Element)v.get(141)).setAttribute("class","botonera" );
      ((Element)v.get(141)).setAttribute("y","386" );
      ((Element)v.get(141)).setAttribute("control","|" );
      ((Element)v.get(141)).setAttribute("conector","" );
      ((Element)v.get(141)).setAttribute("rowset","" );
      ((Element)v.get(141)).setAttribute("cargainicial","N" );
      ((Element)v.get(141)).setAttribute("onload","procesarPaginado(mipgndo,msgError, ultima, rowset, 'muestraLista(ultima, rowset)')" );
      ((Element)v.get(79)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(142)).setAttribute("nombre","ret1" );
      ((Element)v.get(142)).setAttribute("x","37" );
      ((Element)v.get(142)).setAttribute("y","390" );
      ((Element)v.get(142)).setAttribute("ID","botonContenido" );
      ((Element)v.get(142)).setAttribute("img","retroceder_on" );
      ((Element)v.get(142)).setAttribute("tipo","0" );
      ((Element)v.get(142)).setAttribute("estado","false" );
      ((Element)v.get(142)).setAttribute("alt","" );
      ((Element)v.get(142)).setAttribute("codigo","" );
      ((Element)v.get(142)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(141)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */

      /* Empieza nodo:143 / Elemento padre: 141   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(143)).setAttribute("nombre","ava1" );
      ((Element)v.get(143)).setAttribute("x","52" );
      ((Element)v.get(143)).setAttribute("y","390" );
      ((Element)v.get(143)).setAttribute("ID","botonContenido" );
      ((Element)v.get(143)).setAttribute("img","avanzar_on" );
      ((Element)v.get(143)).setAttribute("tipo","0" );
      ((Element)v.get(143)).setAttribute("estado","false" );
      ((Element)v.get(143)).setAttribute("alt","" );
      ((Element)v.get(143)).setAttribute("codigo","" );
      ((Element)v.get(143)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(141)).appendChild((Element)v.get(143));
      /* Termina nodo:143   */
      /* Termina nodo:141   */
      /* Termina nodo:79   */

      /* Empieza nodo:144 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(144)).setAttribute("nombre","primera1" );
      ((Element)v.get(144)).setAttribute("x","20" );
      ((Element)v.get(144)).setAttribute("y","390" );
      ((Element)v.get(144)).setAttribute("ID","botonContenido" );
      ((Element)v.get(144)).setAttribute("img","primera_on" );
      ((Element)v.get(144)).setAttribute("tipo","-2" );
      ((Element)v.get(144)).setAttribute("estado","false" );
      ((Element)v.get(144)).setAttribute("alt","" );
      ((Element)v.get(144)).setAttribute("codigo","" );
      ((Element)v.get(144)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(6)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */

      /* Empieza nodo:145 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(145)).setAttribute("nombre","separa" );
      ((Element)v.get(145)).setAttribute("x","59" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(145)).setAttribute("y","386" );
      ((Element)v.get(145)).setAttribute("ID","botonContenido" );
      ((Element)v.get(145)).setAttribute("img","separa_base" );
      ((Element)v.get(145)).setAttribute("tipo","0" );
      ((Element)v.get(145)).setAttribute("estado","false" );
      ((Element)v.get(145)).setAttribute("alt","" );
      ((Element)v.get(145)).setAttribute("codigo","" );
      ((Element)v.get(145)).setAttribute("accion","" );
      ((Element)v.get(6)).appendChild((Element)v.get(145));
      /* Termina nodo:145   */

      /* Empieza nodo:146 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(146)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(146)).setAttribute("alto","12" );
      ((Element)v.get(146)).setAttribute("ancho","50" );
      ((Element)v.get(146)).setAttribute("colorf","" );
      ((Element)v.get(146)).setAttribute("borde","0" );
      ((Element)v.get(146)).setAttribute("imagenf","" );
      ((Element)v.get(146)).setAttribute("repeat","" );
      ((Element)v.get(146)).setAttribute("padding","" );
      ((Element)v.get(146)).setAttribute("visibilidad","visible" );
      ((Element)v.get(146)).setAttribute("contravsb","" );
      ((Element)v.get(146)).setAttribute("x","0" );
      ((Element)v.get(146)).setAttribute("y","409" );
      ((Element)v.get(146)).setAttribute("zindex","" );
      ((Element)v.get(6)).appendChild((Element)v.get(146));
      /* Termina nodo:146   */
      /* Termina nodo:6   */


   }

}
