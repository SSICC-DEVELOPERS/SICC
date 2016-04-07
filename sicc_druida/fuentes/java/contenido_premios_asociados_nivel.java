
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_premios_asociados_nivel  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("nombre","contenido_premios_asociados_nivel" );
      ((Element)v.get(0)).setAttribute("cod","3373" );
      ((Element)v.get(0)).setAttribute("titulo","" );
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
      v.add(doc.createTextNode("    \r\r  \r\r    function onLoadPag()  {           \r		configurarMenuSecundario(\"formulario\");\r		configurarBotones();\r		cargarLabels();\r		cargarLista();\r    }\r\r	function configurarBotones() {\r		 btnProxy(2,'1');\r 		 btnProxy(3,'0');\r  		 btnProxy(5,'0');\r		 btnProxy(7,'0');\r		 btnProxy(8,'0');\r		 btnProxy(9,'0');\r	}\r\r	function fVolver() {\r		window.close();\r	}\r\r	function cargarLista() {\r		var arr = new Array();\r\r		arr[arr.length] = new Array(\"oidConcurso\", get(\"formulario.oidConcurso\")+\"\"); \r		arr[arr.length] = new Array(\"oidCliente\", get(\"formulario.oidCliente\")+\"\");\r		arr[arr.length] = new Array(\"numeroConcurso\", get(\"formulario.numeroConcurso\")+\"\");\r		arr[arr.length] = new Array(\"oidRegion\", get(\"formulario.oidRegion\")+\"\"); \r		arr[arr.length] = new Array(\"oidZona\", get(\"formulario.oidZona\")+\"\");\r		arr[arr.length] = new Array(\"oidSeccion\", get(\"formulario.oidSeccion\")+\"\"); \r		arr[arr.length] = new Array(\"oidPais\", get(\"formulario.oidPais\")+\"\");\r		arr[arr.length] = new Array(\"oidIdioma\", get(\"formulario.oidIdioma\")+\"\"); \r      \r		configurarPaginado(mipgndo,\"INCConsultarDetallePremiosAsociadosNivel\", \"ConectorConsultarDetallePremiosAsociadosNivel\",\"es.indra.sicc.dtos.inc.DTOCabeceraConsultaIntegral\",arr);\r	}\r\r	function cargarLabels() {\r		txt_to('lblCodClientedt', get(\"formulario.codigoCliente\"));\r		txt_to('lblNombreApellidosdt', get(\"formulario.nombreApellidos\"));\r	}\r\r	function mostrarLista() {\r		DrdEnsanchaConMargenDcho('listado1',12);      \r		document.all[\"Cplistado1\"].style.visibility='visible'; \r		document.all[\"CpLin1listado1\"].style.visibility='visible';  \r		document.all[\"CpLin2listado1\"].style.visibility='visible'; \r		document.all[\"CpLin3listado1\"].style.visibility='visible';\r		document.all[\"CpLin4listado1\"].style.visibility='visible';        \r	    document.all[\"primera1Div\"].style.visibility='hidden'; \r		document.all[\"ret1Div\"].style.visibility='hidden';\r		document.all[\"ava1Div\"].style.visibility='hidden';  \r		document.all[\"separaDiv\"].style.visibility='hidden';           \r		eval (ON_RSZ);            \r	}\r\r	function muestraLista(ultima, rowset, error){\r		mostrarLista();\r		return true;\r	}\r\r\r     \r"));
      ((Element)v.get(4)).appendChild((Text)v.get(5));

      /* Termina nodo Texto:5   */
      /* Termina nodo:4   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(6)).setAttribute("nombre","formulario" );
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
      ((Element)v.get(9)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","codigoCliente" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","nombreApellidos" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","oidConcurso" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","oidCliente" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","oidRegion" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","oidZona" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","oidSeccion" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","oidPais" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","oidIdioma" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","numeroConcurso" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(21)).setAttribute("nombre","capa1" );
      ((Element)v.get(6)).appendChild((Element)v.get(21));

      /* Empieza nodo:22 / Elemento padre: 21   */
      v.add(doc.createElement("table"));
      ((Element)v.get(22)).setAttribute("width","100%" );
      ((Element)v.get(22)).setAttribute("border","0" );
      ((Element)v.get(22)).setAttribute("cellspacing","0" );
      ((Element)v.get(22)).setAttribute("cellpadding","0" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(21)).appendChild((Element)v.get(22));

      /* Empieza nodo:23 / Elemento padre: 22   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(22)).appendChild((Element)v.get(23));

      /* Empieza nodo:24 / Elemento padre: 23   */
      v.add(doc.createElement("td"));
      ((Element)v.get(24)).setAttribute("width","12" );
      ((Element)v.get(24)).setAttribute("align","center" );
      ((Element)v.get(23)).appendChild((Element)v.get(24));

      /* Empieza nodo:25 / Elemento padre: 24   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(25)).setAttribute("src","b.gif" );
      ((Element)v.get(25)).setAttribute("width","12" );
      ((Element)v.get(25)).setAttribute("height","12" );
      ((Element)v.get(24)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */
      /* Termina nodo:24   */

      /* Empieza nodo:26 / Elemento padre: 23   */
      v.add(doc.createElement("td"));
      ((Element)v.get(26)).setAttribute("width","750" );
      ((Element)v.get(23)).appendChild((Element)v.get(26));

      /* Empieza nodo:27 / Elemento padre: 26   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(27)).setAttribute("src","b.gif" );
      ((Element)v.get(26)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */
      /* Termina nodo:26   */

      /* Empieza nodo:28 / Elemento padre: 23   */
      v.add(doc.createElement("td"));
      ((Element)v.get(28)).setAttribute("width","12" );
      ((Element)v.get(23)).appendChild((Element)v.get(28));

      /* Empieza nodo:29 / Elemento padre: 28   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(29)).setAttribute("src","b.gif" );
      ((Element)v.get(29)).setAttribute("width","12" );
      ((Element)v.get(29)).setAttribute("height","1" );
      ((Element)v.get(28)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */
      /* Termina nodo:28   */
      /* Termina nodo:23   */

      /* Empieza nodo:30 / Elemento padre: 22   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(22)).appendChild((Element)v.get(30));

      /* Empieza nodo:31 / Elemento padre: 30   */
      v.add(doc.createElement("td"));
      ((Element)v.get(30)).appendChild((Element)v.get(31));

      /* Empieza nodo:32 / Elemento padre: 31   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(32)).setAttribute("src","b.gif" );
      ((Element)v.get(31)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */
      /* Termina nodo:31   */

      /* Empieza nodo:33 / Elemento padre: 30   */
      v.add(doc.createElement("td"));
      ((Element)v.get(30)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(33)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(35)).setAttribute("class","legend" );
      ((Element)v.get(34)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(36)).setAttribute("nombre","lblDatosCabecera" );
      ((Element)v.get(36)).setAttribute("alto","13" );
      ((Element)v.get(36)).setAttribute("filas","1" );
      ((Element)v.get(36)).setAttribute("valor","" );
      ((Element)v.get(36)).setAttribute("id","legend" );
      ((Element)v.get(36)).setAttribute("cod","00156" );
      ((Element)v.get(35)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */
      /* Termina nodo:35   */

      /* Empieza nodo:37 / Elemento padre: 34   */
      v.add(doc.createElement("table"));
      ((Element)v.get(37)).setAttribute("width","100%" );
      ((Element)v.get(37)).setAttribute("border","0" );
      ((Element)v.get(37)).setAttribute("align","center" );
      ((Element)v.get(37)).setAttribute("cellspacing","0" );
      ((Element)v.get(37)).setAttribute("cellpadding","0" );
      ((Element)v.get(34)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(37)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("td"));
      ((Element)v.get(38)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("table"));
      ((Element)v.get(40)).setAttribute("width","649" );
      ((Element)v.get(40)).setAttribute("border","0" );
      ((Element)v.get(40)).setAttribute("align","left" );
      ((Element)v.get(40)).setAttribute("cellspacing","0" );
      ((Element)v.get(40)).setAttribute("cellpadding","0" );
      ((Element)v.get(39)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(40)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
      ((Element)v.get(42)).setAttribute("colspan","3" );
      ((Element)v.get(41)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(43)).setAttribute("src","b.gif" );
      ((Element)v.get(43)).setAttribute("width","8" );
      ((Element)v.get(43)).setAttribute("height","8" );
      ((Element)v.get(42)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */
      /* Termina nodo:42   */
      /* Termina nodo:41   */

      /* Empieza nodo:44 / Elemento padre: 40   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(40)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("td"));
      ((Element)v.get(44)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(46)).setAttribute("src","b.gif" );
      ((Element)v.get(46)).setAttribute("width","8" );
      ((Element)v.get(46)).setAttribute("height","8" );
      ((Element)v.get(45)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */
      /* Termina nodo:45   */

      /* Empieza nodo:47 / Elemento padre: 44   */
      v.add(doc.createElement("td"));
      ((Element)v.get(44)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(48)).setAttribute("nombre","lblCodCliente" );
      ((Element)v.get(48)).setAttribute("alto","13" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(48)).setAttribute("filas","1" );
      ((Element)v.get(48)).setAttribute("valor","" );
      ((Element)v.get(48)).setAttribute("id","datosTitle" );
      ((Element)v.get(48)).setAttribute("cod","263" );
      ((Element)v.get(47)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */
      /* Termina nodo:47   */

      /* Empieza nodo:49 / Elemento padre: 44   */
      v.add(doc.createElement("td"));
      ((Element)v.get(44)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(50)).setAttribute("src","b.gif" );
      ((Element)v.get(50)).setAttribute("width","25" );
      ((Element)v.get(50)).setAttribute("height","8" );
      ((Element)v.get(49)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */
      /* Termina nodo:49   */

      /* Empieza nodo:51 / Elemento padre: 44   */
      v.add(doc.createElement("td"));
      ((Element)v.get(44)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(52)).setAttribute("nombre","lblNombreApellidos" );
      ((Element)v.get(52)).setAttribute("alto","13" );
      ((Element)v.get(52)).setAttribute("filas","1" );
      ((Element)v.get(52)).setAttribute("valor","" );
      ((Element)v.get(52)).setAttribute("id","datosTitle" );
      ((Element)v.get(52)).setAttribute("cod","943" );
      ((Element)v.get(51)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */
      /* Termina nodo:51   */

      /* Empieza nodo:53 / Elemento padre: 44   */
      v.add(doc.createElement("td"));
      ((Element)v.get(53)).setAttribute("width","100%" );
      ((Element)v.get(44)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(54)).setAttribute("src","b.gif" );
      ((Element)v.get(54)).setAttribute("width","8" );
      ((Element)v.get(54)).setAttribute("height","8" );
      ((Element)v.get(53)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */
      /* Termina nodo:53   */
      /* Termina nodo:44   */

      /* Empieza nodo:55 / Elemento padre: 40   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(40)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(55)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(57)).setAttribute("src","b.gif" );
      ((Element)v.get(57)).setAttribute("width","8" );
      ((Element)v.get(57)).setAttribute("height","8" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */
      /* Termina nodo:56   */

      /* Empieza nodo:58 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(55)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(59)).setAttribute("nombre","lblCodClientedt" );
      ((Element)v.get(59)).setAttribute("alto","13" );
      ((Element)v.get(59)).setAttribute("filas","1" );
      ((Element)v.get(59)).setAttribute("valor","" );
      ((Element)v.get(59)).setAttribute("id","datosCampos" );
      ((Element)v.get(58)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */
      /* Termina nodo:58   */

      /* Empieza nodo:60 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(55)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(61)).setAttribute("src","b.gif" );
      ((Element)v.get(61)).setAttribute("width","25" );
      ((Element)v.get(61)).setAttribute("height","8" );
      ((Element)v.get(60)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */
      /* Termina nodo:60   */

      /* Empieza nodo:62 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(55)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(63)).setAttribute("nombre","lblNombreApellidosdt" );
      ((Element)v.get(63)).setAttribute("alto","13" );
      ((Element)v.get(63)).setAttribute("filas","1" );
      ((Element)v.get(63)).setAttribute("valor","" );
      ((Element)v.get(63)).setAttribute("id","datosCampos" );
      ((Element)v.get(62)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */
      /* Termina nodo:62   */

      /* Empieza nodo:64 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(64)).setAttribute("width","100%" );
      ((Element)v.get(55)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(65)).setAttribute("src","b.gif" );
      ((Element)v.get(65)).setAttribute("width","8" );
      ((Element)v.get(65)).setAttribute("height","8" );
      ((Element)v.get(64)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */
      /* Termina nodo:64   */
      /* Termina nodo:55   */

      /* Empieza nodo:66 / Elemento padre: 40   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(40)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("td"));
      ((Element)v.get(67)).setAttribute("colspan","3" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(68)).setAttribute("src","b.gif" );
      ((Element)v.get(68)).setAttribute("width","8" );
      ((Element)v.get(68)).setAttribute("height","7" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */
      /* Termina nodo:67   */
      /* Termina nodo:66   */
      /* Termina nodo:40   */
      /* Termina nodo:39   */
      /* Termina nodo:38   */
      /* Termina nodo:37   */
      /* Termina nodo:34   */
      /* Termina nodo:33   */

      /* Empieza nodo:69 / Elemento padre: 30   */
      v.add(doc.createElement("td"));
      ((Element)v.get(30)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(70)).setAttribute("src","b.gif" );
      ((Element)v.get(69)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */
      /* Termina nodo:69   */
      /* Termina nodo:30   */

      /* Empieza nodo:71 / Elemento padre: 22   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(22)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("td"));
   }

   private void getXML270(Document doc) {
      ((Element)v.get(72)).setAttribute("width","12" );
      ((Element)v.get(72)).setAttribute("align","center" );
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
      /* Termina nodo:22   */
      /* Termina nodo:21   */

      /* Empieza nodo:78 / Elemento padre: 6   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(78)).setAttribute("nombre","listado1" );
      ((Element)v.get(78)).setAttribute("ancho","652" );
      ((Element)v.get(78)).setAttribute("alto","357" );
      ((Element)v.get(78)).setAttribute("x","12" );
      ((Element)v.get(78)).setAttribute("y","91" );
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
      ((Element)v.get(86)).setAttribute("cod","00133" );
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
   }

   private void getXML360(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(89)).setAttribute("ancho","120" );
      ((Element)v.get(89)).setAttribute("minimizable","S" );
      ((Element)v.get(89)).setAttribute("minimizada","N" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */

      /* Empieza nodo:90 / Elemento padre: 88   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(90)).setAttribute("ancho","120" );
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
      ((Element)v.get(92)).setAttribute("ancho","100" );
      ((Element)v.get(92)).setAttribute("minimizable","S" );
      ((Element)v.get(92)).setAttribute("minimizada","N" );
      ((Element)v.get(88)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */

      /* Empieza nodo:93 / Elemento padre: 88   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(93)).setAttribute("ancho","100" );
      ((Element)v.get(93)).setAttribute("minimizable","S" );
      ((Element)v.get(93)).setAttribute("minimizada","N" );
      ((Element)v.get(88)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */

      /* Empieza nodo:94 / Elemento padre: 88   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(94)).setAttribute("ancho","200" );
      ((Element)v.get(94)).setAttribute("minimizable","S" );
      ((Element)v.get(94)).setAttribute("minimizada","N" );
      ((Element)v.get(88)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */

      /* Empieza nodo:95 / Elemento padre: 88   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(95)).setAttribute("ancho","100" );
      ((Element)v.get(95)).setAttribute("minimizable","S" );
      ((Element)v.get(95)).setAttribute("minimizada","N" );
      ((Element)v.get(88)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */

      /* Empieza nodo:96 / Elemento padre: 88   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(96)).setAttribute("ancho","100" );
      ((Element)v.get(96)).setAttribute("minimizable","S" );
      ((Element)v.get(96)).setAttribute("minimizada","N" );
      ((Element)v.get(88)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */

      /* Empieza nodo:97 / Elemento padre: 88   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(97)).setAttribute("ancho","300" );
      ((Element)v.get(97)).setAttribute("minimizable","S" );
      ((Element)v.get(97)).setAttribute("minimizada","N" );
      ((Element)v.get(88)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */

      /* Empieza nodo:98 / Elemento padre: 88   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(98)).setAttribute("ancho","300" );
      ((Element)v.get(98)).setAttribute("minimizable","S" );
      ((Element)v.get(98)).setAttribute("minimizada","N" );
      ((Element)v.get(88)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */

      /* Empieza nodo:99 / Elemento padre: 88   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(99)).setAttribute("ancho","100" );
      ((Element)v.get(99)).setAttribute("minimizable","S" );
      ((Element)v.get(99)).setAttribute("minimizada","N" );
      ((Element)v.get(88)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */
      /* Termina nodo:88   */

      /* Empieza nodo:100 / Elemento padre: 78   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(100)).setAttribute("alto","20" );
      ((Element)v.get(100)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(100)).setAttribute("imgFondo","" );
      ((Element)v.get(100)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(78)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(101)).setAttribute("colFondo","" );
      ((Element)v.get(101)).setAttribute("ID","EstCab" );
      ((Element)v.get(101)).setAttribute("cod","1664" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */

      /* Empieza nodo:102 / Elemento padre: 100   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(102)).setAttribute("colFondo","" );
      ((Element)v.get(102)).setAttribute("ID","EstCab" );
      ((Element)v.get(102)).setAttribute("cod","3391" );
      ((Element)v.get(100)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */

      /* Empieza nodo:103 / Elemento padre: 100   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(103)).setAttribute("colFondo","" );
      ((Element)v.get(103)).setAttribute("ID","EstCab" );
      ((Element)v.get(103)).setAttribute("cod","1696" );
      ((Element)v.get(100)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */

      /* Empieza nodo:104 / Elemento padre: 100   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(104)).setAttribute("colFondo","" );
      ((Element)v.get(104)).setAttribute("ID","EstCab" );
      ((Element)v.get(104)).setAttribute("cod","1691" );
      ((Element)v.get(100)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */

      /* Empieza nodo:105 / Elemento padre: 100   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(105)).setAttribute("colFondo","" );
      ((Element)v.get(105)).setAttribute("ID","EstCab" );
      ((Element)v.get(105)).setAttribute("cod","337" );
      ((Element)v.get(100)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */

      /* Empieza nodo:106 / Elemento padre: 100   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(106)).setAttribute("colFondo","" );
      ((Element)v.get(106)).setAttribute("ID","EstCab" );
      ((Element)v.get(106)).setAttribute("cod","1853" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(100)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */

      /* Empieza nodo:107 / Elemento padre: 100   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(107)).setAttribute("colFondo","" );
      ((Element)v.get(107)).setAttribute("ID","EstCab" );
      ((Element)v.get(107)).setAttribute("cod","9" );
      ((Element)v.get(100)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */

      /* Empieza nodo:108 / Elemento padre: 100   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(108)).setAttribute("colFondo","" );
      ((Element)v.get(108)).setAttribute("ID","EstCab" );
      ((Element)v.get(108)).setAttribute("cod","495" );
      ((Element)v.get(100)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */

      /* Empieza nodo:109 / Elemento padre: 100   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(109)).setAttribute("colFondo","" );
      ((Element)v.get(109)).setAttribute("ID","EstCab" );
      ((Element)v.get(109)).setAttribute("cod","3188" );
      ((Element)v.get(100)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */

      /* Empieza nodo:110 / Elemento padre: 100   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(110)).setAttribute("colFondo","" );
      ((Element)v.get(110)).setAttribute("ID","EstCab" );
      ((Element)v.get(110)).setAttribute("cod","3185" );
      ((Element)v.get(100)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */

      /* Empieza nodo:111 / Elemento padre: 100   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(111)).setAttribute("colFondo","" );
      ((Element)v.get(111)).setAttribute("ID","EstCab" );
      ((Element)v.get(111)).setAttribute("cod","3375" );
      ((Element)v.get(100)).appendChild((Element)v.get(111));
      /* Termina nodo:111   */
      /* Termina nodo:100   */

      /* Empieza nodo:112 / Elemento padre: 78   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(112)).setAttribute("alto","22" );
      ((Element)v.get(112)).setAttribute("accion","" );
      ((Element)v.get(112)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(112)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(112)).setAttribute("maxSel","0" );
      ((Element)v.get(112)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(112)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(112)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(112)).setAttribute("onLoad","" );
      ((Element)v.get(112)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(78)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(113)).setAttribute("tipo","texto" );
      ((Element)v.get(113)).setAttribute("ID","EstDat" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));
      /* Termina nodo:113   */

      /* Empieza nodo:114 / Elemento padre: 112   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(114)).setAttribute("tipo","texto" );
      ((Element)v.get(114)).setAttribute("ID","EstDat" );
      ((Element)v.get(112)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */

      /* Empieza nodo:115 / Elemento padre: 112   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(115)).setAttribute("tipo","texto" );
      ((Element)v.get(115)).setAttribute("ID","EstDat2" );
      ((Element)v.get(112)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */

      /* Empieza nodo:116 / Elemento padre: 112   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(116)).setAttribute("tipo","texto" );
      ((Element)v.get(116)).setAttribute("ID","EstDat" );
      ((Element)v.get(112)).appendChild((Element)v.get(116));
      /* Termina nodo:116   */

      /* Empieza nodo:117 / Elemento padre: 112   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(117)).setAttribute("tipo","texto" );
      ((Element)v.get(117)).setAttribute("ID","EstDat2" );
      ((Element)v.get(112)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */

      /* Empieza nodo:118 / Elemento padre: 112   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(118)).setAttribute("tipo","texto" );
      ((Element)v.get(118)).setAttribute("ID","EstDat" );
      ((Element)v.get(112)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */

      /* Empieza nodo:119 / Elemento padre: 112   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(119)).setAttribute("tipo","texto" );
      ((Element)v.get(119)).setAttribute("ID","EstDat2" );
      ((Element)v.get(112)).appendChild((Element)v.get(119));
      /* Termina nodo:119   */

      /* Empieza nodo:120 / Elemento padre: 112   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(120)).setAttribute("tipo","texto" );
      ((Element)v.get(120)).setAttribute("ID","EstDat" );
      ((Element)v.get(112)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */

      /* Empieza nodo:121 / Elemento padre: 112   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(121)).setAttribute("tipo","texto" );
      ((Element)v.get(121)).setAttribute("ID","EstDat2" );
      ((Element)v.get(112)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */

      /* Empieza nodo:122 / Elemento padre: 112   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(122)).setAttribute("tipo","texto" );
      ((Element)v.get(122)).setAttribute("ID","EstDat" );
      ((Element)v.get(112)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */

      /* Empieza nodo:123 / Elemento padre: 112   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(123)).setAttribute("tipo","texto" );
      ((Element)v.get(123)).setAttribute("ID","EstDat2" );
      ((Element)v.get(112)).appendChild((Element)v.get(123));
      /* Termina nodo:123   */
      /* Termina nodo:112   */

      /* Empieza nodo:124 / Elemento padre: 78   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(78)).appendChild((Element)v.get(124));
      /* Termina nodo:124   */

      /* Empieza nodo:125 / Elemento padre: 78   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(125)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(125)).setAttribute("ancho","578" );
      ((Element)v.get(125)).setAttribute("sep","$" );
      ((Element)v.get(125)).setAttribute("x","12" );
      ((Element)v.get(125)).setAttribute("class","botonera" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(125)).setAttribute("y","625" );
      ((Element)v.get(125)).setAttribute("control","|" );
      ((Element)v.get(125)).setAttribute("conector","" );
      ((Element)v.get(125)).setAttribute("rowset","" );
      ((Element)v.get(125)).setAttribute("cargainicial","N" );
      ((Element)v.get(125)).setAttribute("onload","procesarPaginado(mipgndo,msgError, ultima, rowset, 'muestraLista(ultima, rowset)')" );
      ((Element)v.get(78)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(126)).setAttribute("nombre","ret1" );
      ((Element)v.get(126)).setAttribute("x","37" );
      ((Element)v.get(126)).setAttribute("y","629" );
      ((Element)v.get(126)).setAttribute("ID","botonContenido" );
      ((Element)v.get(126)).setAttribute("img","retroceder_on" );
      ((Element)v.get(126)).setAttribute("tipo","0" );
      ((Element)v.get(126)).setAttribute("estado","false" );
      ((Element)v.get(126)).setAttribute("alt","" );
      ((Element)v.get(126)).setAttribute("codigo","" );
      ((Element)v.get(126)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(125)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */

      /* Empieza nodo:127 / Elemento padre: 125   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(127)).setAttribute("nombre","ava1" );
      ((Element)v.get(127)).setAttribute("x","52" );
      ((Element)v.get(127)).setAttribute("y","629" );
      ((Element)v.get(127)).setAttribute("ID","botonContenido" );
      ((Element)v.get(127)).setAttribute("img","avanzar_on" );
      ((Element)v.get(127)).setAttribute("tipo","0" );
      ((Element)v.get(127)).setAttribute("estado","false" );
      ((Element)v.get(127)).setAttribute("alt","" );
      ((Element)v.get(127)).setAttribute("codigo","" );
      ((Element)v.get(127)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(125)).appendChild((Element)v.get(127));
      /* Termina nodo:127   */
      /* Termina nodo:125   */
      /* Termina nodo:78   */

      /* Empieza nodo:128 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(128)).setAttribute("nombre","primera1" );
      ((Element)v.get(128)).setAttribute("x","20" );
      ((Element)v.get(128)).setAttribute("y","629" );
      ((Element)v.get(128)).setAttribute("ID","botonContenido" );
      ((Element)v.get(128)).setAttribute("img","primera_on" );
      ((Element)v.get(128)).setAttribute("tipo","0" );
      ((Element)v.get(128)).setAttribute("estado","false" );
      ((Element)v.get(128)).setAttribute("alt","" );
      ((Element)v.get(128)).setAttribute("codigo","" );
      ((Element)v.get(128)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(6)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */

      /* Empieza nodo:129 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(129)).setAttribute("nombre","separa" );
      ((Element)v.get(129)).setAttribute("x","59" );
      ((Element)v.get(129)).setAttribute("y","625" );
      ((Element)v.get(129)).setAttribute("ID","botonContenido" );
      ((Element)v.get(129)).setAttribute("img","separa_base" );
      ((Element)v.get(129)).setAttribute("tipo","0" );
      ((Element)v.get(129)).setAttribute("estado","false" );
      ((Element)v.get(129)).setAttribute("alt","" );
      ((Element)v.get(129)).setAttribute("codigo","" );
      ((Element)v.get(129)).setAttribute("accion","" );
      ((Element)v.get(6)).appendChild((Element)v.get(129));
      /* Termina nodo:129   */

      /* Empieza nodo:130 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(130)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(130)).setAttribute("alto","12" );
      ((Element)v.get(130)).setAttribute("ancho","50" );
      ((Element)v.get(130)).setAttribute("colorf","" );
      ((Element)v.get(130)).setAttribute("borde","0" );
      ((Element)v.get(130)).setAttribute("imagenf","" );
      ((Element)v.get(130)).setAttribute("repeat","" );
      ((Element)v.get(130)).setAttribute("padding","" );
      ((Element)v.get(130)).setAttribute("visibilidad","visible" );
      ((Element)v.get(130)).setAttribute("contravsb","" );
      ((Element)v.get(130)).setAttribute("x","0" );
      ((Element)v.get(130)).setAttribute("y","648" );
      ((Element)v.get(130)).setAttribute("zindex","" );
      ((Element)v.get(6)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */
      /* Termina nodo:6   */


   }

}
